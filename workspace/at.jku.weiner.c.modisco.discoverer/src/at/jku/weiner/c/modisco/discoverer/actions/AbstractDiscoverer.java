package at.jku.weiner.c.modisco.discoverer.actions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.modisco.infra.discovery.core.AbstractModelDiscoverer;
import org.eclipse.modisco.infra.discovery.core.annotations.Parameter;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.modisco.discoverer.utils.FileNameSorter;
import at.jku.weiner.c.modisco.discoverer.utils.Messages;
import at.jku.weiner.c.modisco.discoverer.utils.MyStore;

public abstract class AbstractDiscoverer<T> extends AbstractModelDiscoverer<T> {

	protected static final String PREFIX = "org.eclipse.modisco.cdt.discoverer.actions.";

	private boolean setStdInclude = true;
	private String includeDirs = "";
	private String additionalDirectives = "";
	private boolean trimPreprocessModel = false;
	private boolean batchMode = false;
	private URI lastUri = null;

	protected final boolean isApplicableOn(final IResource resource) {
		MyLog.trace(AbstractDiscoverer.class, "isApplicableOn='" + resource
				+ "'");
		MyLog.trace(AbstractDiscoverer.class,
				"isApplicableOn='" + resource.getClass() + "'");

		if (resource instanceof IFile) {
			return DiscovererUtils.checkFile((IFile) resource);
		} else if (resource instanceof IContainer) {
			final IContainer container = (IContainer) resource;
			MyLog.trace(AbstractDiscoverer.class, "isContainer");
			final boolean result = container.isAccessible();
			MyLog.trace(AbstractDiscoverer.class, "isContainer.isAccessible='"
					+ result + "'");
			return result;
		} else if (resource instanceof IFolder) {
			final IFolder folder = (IFolder) resource;
			MyLog.trace(AbstractDiscoverer.class, "isFolder");
			final boolean result = folder.isAccessible();
			return result;
		}
		return false;
	}

	protected final void discover(final IResource resource,
			final IProgressMonitor monitor) throws DiscoveryException {
		try {
			monitor.subTask(Messages.discover + "'"
					+ resource.getLocationURI().toString() + "'");
			// System.err.println("clazz='" + monitor.getClass() + "'");
			this.discover2(resource, monitor);
		} catch (final Exception ex) {
			if (ex instanceof DiscoveryException) {
				throw (DiscoveryException) ex;
			}
			final DiscoveryException newEx = new DiscoveryException("'"
					+ ex.getClass() + "':" + ex.getMessage());
			throw newEx;
		} finally {
			monitor.done();
		}
	}

	private final void discover2(final IResource resource,
			final IProgressMonitor monitor) throws Exception {
		final MyStore store = this.initialize(resource, monitor);
		// discover
		store.getMonitor().beginTask(Messages.discover,
				IProgressMonitor.UNKNOWN);
		if (resource instanceof IFile) {
			final IFile file = (IFile) resource;
			this.discoverFile(file.getLocation().toFile(), store);
		} else if (resource instanceof IContainer) {
			final IContainer container = (IContainer) resource;
			this.discoverDirectory(container.getLocation().toFile(), store);
		} else {
			final DiscoveryException ex = new DiscoveryException(resource
					.getClass().getName() + " not handled"); //$NON-NLS-1$
			MyLog.error(AbstractDiscoverer.class, ex);
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
			IProgressMonitor monitor) throws DiscoveryException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		monitor.beginTask(Messages.discover, IProgressMonitor.UNKNOWN);
		this.checkParameterValues();
		final URI targetURI = DiscovererUtils.getTargetModel(resource, monitor);
		this.setTargetURI(targetURI);
		final Resource targetModel = this.createTargetModel();
		final MyStore result = new MyStore(monitor, targetModel, resource,
				this.setStdInclude, this.includeDirs,
				this.getAdditionalDirectives(), this.trimPreprocessModel,
				this.batchMode);
		return result;
	}

	/**
	 * Recursively discover all files contained in the given directory into the
	 * given model
	 *
	 * @throws DiscoveryException
	 */
	private final void discoverDirectory(final File directory,
			final MyStore store) throws Exception {
		if (!directory.isDirectory()) {
			final Exception ex = new DiscoveryException(
					"not a directory '" + directory.getAbsolutePath() + "'"); //$NON-NLS-1$
			MyLog.error(AbstractDiscoverer.class, ex);
			throw ex;
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
			throws Exception {
		MyLog.log(AbstractDiscoverer.class,
				"discovering file='" + file.getAbsolutePath() + "'...");
		try {
			final IFile iFile = DiscovererUtils.getFileFor(file);
			store.getParser().readFromXtextFile(file, iFile);
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
			MyLog.log(DiscoverFromIFile.class, "saved to='"
					+ this.getTargetModel().getURI().toFileString() + "'");
			if (this.batchMode && (this.lastUri != null)) {
				final String uri = this.lastUri.toFileString();
				MyLog.log(DiscoverFromIFile.class,
						"batchMode, delete previous uri='" + uri + "!");
				final File file = new File(uri);
				boolean wasDeleted = file.delete();
				MyLog.log(DiscoverFromIFile.class, "wasDeleted='" + wasDeleted
						+ "'");
				project.refreshLocal(IResource.DEPTH_INFINITE,
						store.getMonitor());
			}
			this.lastUri = this.getTargetURI();
		} catch (final Exception ex) {
			throw new DiscoveryException(
					"Error saving discovery result model", ex); //$NON-NLS-1$
		}
		// }
	}

	public boolean isSetStdInclude() {
		return this.setStdInclude;
	}

	@Parameter(name = "STD_INCLUDE", requiresInputValue = false, description = "Use default standard include directories (e.g. /usr/include/). Set to false for -nostdinc behaviour.")
	public void setSetStdInclude(final boolean setStdInclude) {
		this.setStdInclude = setStdInclude;
	}

	public String getIncludeDirs() {
		return this.includeDirs;
	}

	@Parameter(name = "INCLUDE_DIRS", requiresInputValue = false, description = "Add additional directories to search path. Use File.pathSeparator to add multiple directories.")
	public void setIncludeDirs(final String includeDirs) {
		this.includeDirs = includeDirs;
	}

	public String getAdditionalDirectives() {
		return this.additionalDirectives;
	}

	@Parameter(name = "ADDITIONAL_PREPROCESSOR_DIRECTIVES", requiresInputValue = false, description = "Add additional preprocessor directives and macros"
			+ "(e.g., <br/>#define FOO BAR<br/>#define BAR(x) #x<br/>#include &quot;include/myinclude.h&quot;")
	public void setAdditionalDirectives(final String defines) {
		this.additionalDirectives = defines;
	}

	public boolean isTrimPreprocessModel() {
		return this.trimPreprocessModel;
	}

	@Parameter(name = "TRIM_PREPROCESS_MODEL", requiresInputValue = false, description = "Remove code and empty lines from preprocessor model")
	public void setTrimPreprocessModel(final boolean trimPreprocessModel) {
		this.trimPreprocessModel = trimPreprocessModel;
	}

	public boolean isBatchMode() {
		return this.batchMode;
	}

	@Parameter(name = "BATCH_MODE", requiresInputValue = false, description = "Re-use model and clean-up any temporarily saved serializations")
	public void setBatchMode(final boolean batchMode) {
		this.batchMode = batchMode;
	}

}
