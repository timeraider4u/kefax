package at.jku.weiner.c.modisco.discoverer.actions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.modisco.discoverer.utils.FileNameSorter;
import at.jku.weiner.c.modisco.discoverer.utils.Messages;
import at.jku.weiner.c.modisco.discoverer.utils.MyStore;
import at.jku.weiner.log.MyLog;

public abstract class AbstractDiscovererWithLogic<T> extends
AbstractDiscoverer<T> {

	private MyStore myStore = null;
	private XtextUtils xtextUtils = null;

	protected final boolean isApplicableOn(final IResource iResource) {
		return DiscovererUtils.isApplicableOn(iResource);
	}

	protected final void discover(final IResource iResource,
			final IProgressMonitor monitor) throws DiscoveryException {
		try {
			monitor.subTask(Messages.discover + "'"
					+ iResource.getLocationURI().toString() + "'");
			this.discover2(iResource, monitor);
		} catch (final Exception ex) {
			DiscovererUtils.handleException(ex);
		} finally {
			monitor.done();
		}
	}

	private final void discover2(final IResource iResource,
			IProgressMonitor monitor) throws Exception {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		monitor.beginTask(Messages.discover, IProgressMonitor.UNKNOWN);

		this.initialize(iResource, monitor);
		MyLog.trace(AbstractDiscovererWithLogic.class, "initialization done!");

		this.discoverIResource();

		// clean-up
		this.xtextUtils.cleanUp();
		this.xtextUtils = null;
		this.myStore = null;
	}

	/***
	 * initialize all data values
	 *
	 * @param iResource
	 *
	 * @param monitor
	 * @return
	 * @throws DiscoveryException
	 */
	private final void initialize(final IResource iResource,
			final IProgressMonitor monitor) throws DiscoveryException {
		// check if previous discoverer has been closed successfully
		// if ((!AbstractDiscoverer.closeCalled)
		// && (!this.getSettings().isBatchMode())) {
		// throw new DiscoveryException(
		// "close has not been called before starting new discovery!");
		// }
		AbstractDiscoverer.closeCalled = false;

		// initialize backend
		MyLog.trace(AbstractDiscovererWithLogic.class, "initialize backend!");
		this.backend.initialize();

		// creating target URI
		MyLog.trace(AbstractDiscovererWithLogic.class, "creating target URI!");
		this.backend.updateTargetURI(iResource, monitor);

		// creating target resource
		MyLog.trace(AbstractDiscovererWithLogic.class,
				"creating target resource!");
		this.backend.updateTargetResource();

		// create MyStore
		MyLog.trace(AbstractDiscovererWithLogic.class, "creating MyStore!");
		final MyStore result = new MyStore(this.getSettings(), this.backend,
				monitor, iResource, this);
		this.myStore = result;

		// create XText utilities
		MyLog.trace(AbstractDiscovererWithLogic.class, "creating xtext utils!");
		this.xtextUtils = new XtextUtils(this.myStore);
	}

	private final void discoverIResource() throws Exception {
		final IResource iResource = this.myStore.getIResource();
		if (iResource instanceof IFile) {
			final IFile file = (IFile) iResource;
			this.discoverFile(file.getLocation().toFile());
		} else if (iResource instanceof IContainer) {
			final IContainer container = (IContainer) iResource;
			this.discoverDirectory(container.getLocation().toFile());
		} else {
			final DiscoveryException ex = new DiscoveryException(iResource
					.getClass().getName() + " not handled"); //$NON-NLS-1$
			MyLog.error(AbstractDiscovererWithLogic.class, ex);
		}
	}

	/**
	 * Recursively discover all files contained in the given directory into the
	 * given model
	 *
	 * @throws DiscoveryException
	 */
	private final void discoverDirectory(final File directory) throws Exception {
		if (!directory.isDirectory()) {
			final Exception ex = new DiscoveryException(
					"not a directory '" + directory.getAbsolutePath() + "'"); //$NON-NLS-1$
			MyLog.error(AbstractDiscovererWithLogic.class, ex);
		}
		final File[] files = directory.listFiles();
		Arrays.sort(files, new FileNameSorter());
		for (final File file : files) {
			if (file.isDirectory()) {
				this.discoverDirectory(file);
			} else {
				final String fileExtension = new Path(file.getPath())
						.getFileExtension();
				if (DiscovererUtils.isCdtExtension(fileExtension)) {
					this.discoverFile(file);
				}
			}
		}
	}

	private final void discoverFile(final File file) throws Exception {
		MyLog.log(AbstractDiscovererWithLogic.class, "discovering file='"
				+ file.getAbsolutePath() + "'...");
		try {

			final IFile iFile = DiscovererUtils.getFileFor(file);
			this.xtextUtils.readFromXtextFile(file, iFile);
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
	@Override
	protected final void saveTargetModel() throws IOException {
		try {
			this.saveTargetModel2();
		} catch (final CoreException ex) {
			throw new IOException(ex);
		}
	}

	private final void saveTargetModel2() throws CoreException, IOException {
		MyLog.log(AbstractDiscovererWithLogic.class, "saving target model...");
		// saving
		final URI targetURI = this.getTargetURI();
		final Resource targetModel = this.getTargetResource();
		this.backend.save(targetModel, targetURI);
		final String currUriStr = targetURI.toFileString();
		MyLog.log(AbstractDiscovererWithLogic.class, "saved to='" + currUriStr
				+ "'");

		// close streams, shutdown databases or whatever
		if (!this.isBatchMode()) {
			// this.backend.close();
		}

		// update project
		final IProject project = this.myStore.getIResource().getProject();
		project.refreshLocal(IResource.DEPTH_INFINITE,
				this.myStore.getMonitor());
	}

	public void close() {
		this.backend.close();
		AbstractDiscoverer.closeCalled = true;
	}

}
