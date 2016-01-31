/*********************************************************************************
 * Copyright (c) 2009,2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Guyomar (Mia-Software) - initial API and implementation
 *    Nicolas Bros (Mia-Software) - adapted to new discovery framework (Bug 335003)
 *    Fabien Giquel (Mia-Software) - Bug 339720 : MoDisco Discoverers (infra + techno) API clean
 *********************************************************************************/
package org.eclipse.modisco.cdt.discoverer.actions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.modisco.cdt.discoverer.utils.FileNameSorter;
import org.eclipse.modisco.cdt.discoverer.utils.Messages;
import org.eclipse.modisco.cdt.discoverer.utils.MyStore;
import org.eclipse.modisco.infra.discovery.core.AbstractModelDiscoverer;
import org.eclipse.modisco.infra.discovery.core.annotations.Parameter;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

public abstract class AbstractCDTDiscoverer<T> extends
		AbstractModelDiscoverer<T> {
	
	protected static final String PREFIX = "org.eclipse.modisco.cdt.discoverer.actions.";

	private boolean setStdInclude = true;
	private String includeDirs = "";
	private String additionalDirectives = "";
	private boolean trimPreprocessModel = false;
	
	protected final boolean isApplicableOn(final IResource resource) {
		// System.out.println("isApplicableOn='" + resource + "'");
		// System.out.println("isApplicableOn='" + resource.getClass() + "'");
		
		if (resource instanceof IFile) {
			return DiscovererUtils.checkFile((IFile) resource);
		} else if (resource instanceof IContainer) {
			final IContainer container = (IContainer) resource;
			// System.out.println("isContainer");
			final boolean result = container.isAccessible();
			// System.out.println("isContainer.isAccessible='" + result + "'");
			return result;
		} else if (resource instanceof IFolder) {
			final IFolder folder = (IFolder) resource;
			// System.out.println("isFolder");
			final boolean result = folder.isAccessible();
			return result;
		}
		return false;
	}
	
	protected final void discover(final IResource resource,
			final IProgressMonitor monitor) throws DiscoveryException {
		final MyStore store = this.initialize(resource, monitor);
		// discover
		store.getMonitor().beginTask(Messages.discover,
				IProgressMonitor.UNKNOWN);
		if (resource instanceof IFile) {
			final IFile file = (IFile) resource;
			// this.setDefaultTargetURI(URI.createPlatformResourceURI(file
			// .getFullPath().toString().concat(Messages.modelFileSuffix),
			// true));
			this.discoverFile(file.getLocation().toFile(), store);
		} else if (resource instanceof IContainer) {
			final IContainer container = (IContainer) resource;
			// this.setDefaultTargetURI(URI.createPlatformResourceURI(container
			// .getFullPath().append(container.getName()).toString()
			// .concat(Messages.modelFileSuffix), true));
			this.discoverDirectory(container.getLocation().toFile(), store);
		} else {
			throw new DiscoveryException(resource.getClass().getName()
					+ " not handled"); //$NON-NLS-1$
		}
		// clean-up
		store.getParser().cleanUp();
		// saving
		this.save(store);
		// done
		store.getMonitor().setTaskName(Messages.done);
	}
	
	/***
	 * initialize all data values
	 *
	 * @param resource
	 *
	 * @param monitor
	 * @return
	 * @throws DiscoveryException
	 */
	private final MyStore initialize(final IResource resource,
			final IProgressMonitor monitor) throws DiscoveryException {
		monitor.beginTask(Messages.discover, IProgressMonitor.UNKNOWN);
		this.checkParameterValues();
		final URI targetURI = DiscovererUtils.getTargetModel(resource, monitor);
		this.setTargetURI(targetURI);
		final Resource targetModel = this.createTargetModel();
		final MyStore result = new MyStore(monitor, targetModel, resource,
				this.setStdInclude, this.includeDirs,
				this.getAdditionalDirectives(), this.trimPreprocessModel);
		return result;
	}
	
	/**
	 * Recursively discover all files contained in the given directory into the
	 * given model
	 *
	 * @throws DiscoveryException
	 */
	private final void discoverDirectory(final File directory,
			final MyStore store) throws DiscoveryException {
		if (!directory.isDirectory()) {
			throw new DiscoveryException(
					"not a directory '" + directory.getAbsolutePath() + "'"); //$NON-NLS-1$
		}
		final File[] files = directory.listFiles();
		Arrays.sort(files, new FileNameSorter());
		for (final File file : files) {
			if (file.isDirectory()) {
				this.discoverDirectory(file, store);
			} else {
				final String fileExtension = new Path(file.getPath())
						.getFileExtension();
				if (DiscovererUtils.isCdtExtension(fileExtension)) {
					this.discoverFile(file, store);
				}
			}
		}
	}
	
	private final void discoverFile(final File file, final MyStore store)
			throws DiscoveryException {
		// final ParserUtils utils = new ParserUtils(store.getMonitor());
		
		try {
			final IFile iFile = DiscovererUtils.getFileFor(file);
			store.getParser().readFromXtextFile(file, iFile);
			// final EList<TranslationUnit> units = model.getUnits();
			// for (int i = 0; i < units.size(); i++) {
			// final TranslationUnit unit = model.getUnits().get(i);
			// store.getModel().getUnits().add(unit);
			// }
		} catch (final IOException ex) {
			throw new DiscoveryException(
					"Error parsing file='" + file.getAbsolutePath() + "' with XText", ex); //$NON-NLS-1$
		}
		
	}
	
	/***
	 * saving
	 *
	 * @param store
	 * @throws DiscoveryException
	 */
	private final void save(final MyStore store) throws DiscoveryException {
		store.getMonitor().setTaskName(Messages.saving);
		// if (this.isTargetSerializationChosen()) {
		try {
			this.saveTargetModel();
			// update project
			final IProject project = store.getResource().getProject();
			project.refreshLocal(IResource.DEPTH_INFINITE, store.getMonitor());
			System.out.println("saved to='"
					+ this.getTargetModel().getURI().toFileString() + "'");
		} catch (final Exception ex) {
			throw new DiscoveryException(
					"Error saving discovery result model", ex); //$NON-NLS-1$
		}
		// }
	}
	
	public boolean isSetStdInclude() {
		return this.setStdInclude;
	}
	
	@Parameter(
			name = "STD_INCLUDE",
			requiresInputValue = false,
			description = "Use default standard include directories (e.g. /usr/include/). Set to false for -nostdinc behaviour.")
	public void setSetStdInclude(final boolean setStdInclude) {
		this.setStdInclude = setStdInclude;
	}

	public String getIncludeDirs() {
		return this.includeDirs;
	}

	@Parameter(
			name = "INCLUDE_DIRS",
			requiresInputValue = false,
			description = "Add additional directories to search path. Use File.pathSeparator to add multiple directories.")
	public void setIncludeDirs(final String includeDirs) {
		this.includeDirs = includeDirs;
	}
	
	public String getAdditionalDirectives() {
		return this.additionalDirectives;
	}

	@Parameter(
			name = "ADDITIONAL_PREPROCESSOR_DIRECTIVES",
			requiresInputValue = false,
			description = "Add additional preprocessor directives and macros"
					+ "(e.g., <br/>#define FOO BAR<br/>#define BAR(x) #x<br/>#include &quot;include/myinclude.h&quot;")
	public void setAdditionalDirectives(final String defines) {
		this.additionalDirectives = defines;
	}
	
	public boolean isTrimPreprocessModel() {
		return this.trimPreprocessModel;
	}
	
	@Parameter(name = "TRIM_PREPROCESS_MODEL", requiresInputValue = false,
			description = "Remove code and empty lines from preprocessor model")
	public void setTrimPreprocessModel(final boolean trimPreprocessModel) {
		this.trimPreprocessModel = trimPreprocessModel;
	}
	
}
