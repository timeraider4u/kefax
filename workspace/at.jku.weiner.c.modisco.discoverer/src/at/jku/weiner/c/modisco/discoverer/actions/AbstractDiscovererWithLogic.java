package at.jku.weiner.c.modisco.discoverer.actions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.modisco.infra.discovery.core.AbstractModelDiscoverer;
import org.eclipse.modisco.infra.discovery.core.annotations.Parameter;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.common.common.CommonFactory;
import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.modisco.discoverer.neoemf.NeoEMFDiscoverUtils;
import at.jku.weiner.c.modisco.discoverer.utils.FileNameSorter;
import at.jku.weiner.c.modisco.discoverer.utils.Messages;
import at.jku.weiner.c.modisco.discoverer.utils.MySettings;
import at.jku.weiner.c.modisco.discoverer.utils.MyStore;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Parser;
import at.jku.weiner.c.parser.parser.ParserFactory;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.PreprocessFactory;

public abstract class AbstractDiscovererWithLogic<T> extends
		AbstractDiscoverer<T> {
	
	private URI lastUri = null;
	
	protected final boolean isApplicableOn(final IResource resource) {
		MyLog.trace(AbstractDiscovererWithLogic.class, "isApplicableOn='"
				+ resource + "'");
		MyLog.trace(AbstractDiscovererWithLogic.class, "isApplicableOn='"
				+ resource.getClass() + "'");
		
		if (resource instanceof IFile) {
			return DiscovererUtils.checkFile((IFile) resource);
		} else if (resource instanceof IContainer) {
			final IContainer container = (IContainer) resource;
			MyLog.trace(AbstractDiscovererWithLogic.class, "isContainer");
			final boolean result = container.isAccessible();
			MyLog.trace(AbstractDiscovererWithLogic.class,
					"isContainer.isAccessible='" + result + "'");
			return result;
		} else if (resource instanceof IFolder) {
			final IFolder folder = (IFolder) resource;
			MyLog.trace(AbstractDiscovererWithLogic.class, "isFolder");
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
				MyLog.errorNoThrows(AbstractDiscovererWithLogic.class, ex);
				throw (DiscoveryException) ex;
			}
			final DiscoveryException newEx = new DiscoveryException("'"
					+ ex.getClass() + "':" + ex.getMessage());
			MyLog.errorNoThrows(AbstractDiscovererWithLogic.class, ex);
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
			MyLog.error(AbstractDiscovererWithLogic.class, ex);
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
		if (this.isUseNeoEMF()) {
			final ResourceSet resSet = NeoEMFDiscoverUtils.createOrGetResSet();
			this.setResourceSet(resSet);
		}
		final URI targetURI = DiscovererUtils.getTargetUri(resource, monitor,
				this.isUseNeoEMF(), this.lastUri, this.isBatchMode());
		this.setTargetURI(targetURI);
		MyLog.log(AbstractDiscovererWithLogic.class, "creating target model!");
		final Resource targetModel = this.createTargetModel();
		if (this.isUseNeoEMF()) {
			try {
				MyLog.log(AbstractDiscovererWithLogic.class,
						"saving target model - first!");
				NeoEMFDiscoverUtils.saveTargetModel(targetURI, targetModel);
			} catch (final IOException ex) {
				throw new DiscoveryException(ex);
			}
		}
		final MyStore result = new MyStore(monitor, targetModel, resource,
				this.isSetStdInclude(), this.getIncludeDirs(),
				this.getAdditionalDirectives(), this.isTrimPreprocessModel(),
				this.isBatchMode());
		return result;
	}
	
	@Override
	protected Resource createTargetModel() {
		if (this.isUseNeoEMF()) {
			// final Resource targetModel = this.getTargetModel();
			// if (targetModel != null) {
			// return targetModel;
			// }
			final URI targetURI = this.getTargetURI();
			final Resource newTargetModel = NeoEMFDiscoverUtils
					.createTargetModel(targetURI);
			
			this.setTargetModel(newTargetModel);
			return newTargetModel;
		} else {
			final Resource res = super.createTargetModel();
			return res;
		}
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
			MyLog.error(AbstractDiscovererWithLogic.class, ex);
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
		MyLog.log(AbstractDiscovererWithLogic.class, "discovering file='"
				+ file.getAbsolutePath() + "'...");
		try {
			
			final IFile iFile = DiscovererUtils.getFileFor(file);
			store.getParser().readFromXtextFile(file, iFile);
			MyLog.log(AbstractDiscovererWithLogic.class,
					"discovering file done!");
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
		MyLog.log(AbstractDiscovererWithLogic.class, "save target model!");
		// if (this.isTargetSerializationChosen()) {
		try {
			final URI targetURI = this.getTargetURI();
			final Resource targetModel = this.getTargetModel();
			if (this.isUseNeoEMF()) {
				NeoEMFDiscoverUtils.saveTargetModel(targetURI, targetModel);
			} else {
				this.saveTargetModel();
			}
			// update project
			final String currUriStr = targetURI.toFileString();
			final IProject project = store.getResource().getProject();
			project.refreshLocal(IResource.DEPTH_INFINITE, store.getMonitor());
			MyLog.log(DiscoverFromIFile.class, "saved to='" + currUriStr + "'");
			this.deleteLastXMISerialization(currUriStr, store, project);
			this.lastUri = targetURI;
		} catch (final Exception ex) {
			throw new DiscoveryException(
					"Error saving discovery result model", ex); //$NON-NLS-1$
		}
		// }
	}

	private void deleteLastXMISerialization(final String currUriStr,
			final MyStore store, final IProject project) throws CoreException {
		if (this.isBatchMode() && (this.lastUri != null)
				&& (!this.isUseNeoEMF())) {
			final String lastUriStr = this.lastUri.toFileString();
			if (!(lastUriStr.equals(currUriStr))) {
				MyLog.log(DiscoverFromIFile.class,
						"batchMode, delete previous uri='" + lastUriStr + "!");
				final File file = new File(lastUriStr);
				final boolean wasDeleted = file.delete();
				MyLog.log(DiscoverFromIFile.class, "wasDeleted='" + wasDeleted
						+ "'");
				project.refreshLocal(IResource.DEPTH_INFINITE,
						store.getMonitor());
			}
		}
	}
	
}
