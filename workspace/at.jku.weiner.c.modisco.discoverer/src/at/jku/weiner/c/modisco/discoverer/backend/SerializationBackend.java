package at.jku.weiner.c.modisco.discoverer.backend;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.modisco.discoverer.actions.DiscovererUtils;
import at.jku.weiner.c.modisco.discoverer.utils.MySettings;

public abstract class SerializationBackend {

	protected final IDiscoverer discoverer;
	protected final MySettings mySettings;

	private Resource resource = null;
	private URI lastUri = null;

	protected SerializationBackend(final IDiscoverer discoverer,
			final MySettings mySettings) {
		this.discoverer = discoverer;
		this.mySettings = mySettings;
	}

	protected final URI getLastUri() {
		return this.lastUri;
	}
	
	public final void initialize() throws DiscoveryException {
		this.getResourceSet(true);
		this.initializeInternal();
	}
	
	protected abstract void initializeInternal() throws DiscoveryException;
	
	protected final ResourceSet getResourceSet() throws DiscoveryException {
		return this.getResourceSet(false);
	}

	protected final ResourceSet getResourceSet(final boolean reset)
			throws DiscoveryException {
		ResourceSet resSet = this.discoverer.getResourceSet();
		if ((resSet == null) || reset) {
			resSet = this.createNewResourceSet();
			this.discoverer.setResourceSet(resSet);
		}
		return resSet;
	}

	protected abstract ResourceSet createNewResourceSet();

	public final void updateTargetURI(final IResource iResource,
			final IProgressMonitor monitor) throws DiscoveryException {
		final URI targetURI = this.createTargetURI(iResource, monitor);
		this.discoverer.setTargetURI(targetURI);
		MyLog.trace(SerializationBackend.class,
				"targetURI='" + targetURI.toString() + "'");
	}
	
	protected abstract URI createTargetURI(IResource iResource,
			IProgressMonitor monitor) throws DiscoveryException;

	protected final URI createTargetFileURI(final IResource iResource,
			final IProgressMonitor monitor) throws DiscoveryException {
		// set-up path name parts
		final String dir = DiscovererUtils.getTargetDirectory(iResource,
				monitor);
		final String ext = this.getBackendExtension();
		final Date dNow = new Date();
		final SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
		final String dateString = ft.format(dNow);
		// create URI
		final String pathName = dir + IPath.SEPARATOR + "discover-"
				+ dateString + ext;
		final URI result = URI.createFileURI(pathName);
		MyLog.trace(SerializationBackend.class, "createTargetFileURI='"
				+ result.toString() + "'");
		return result;
	}

	protected abstract String getBackendExtension();

	public final void updateTargetResource() throws DiscoveryException {
		if (this.resource == null) {
			try {
				this.resource = this.createNewTargetResource(this.discoverer
						.getTargetURI());
			} catch (final IOException ex) {
				final DiscoveryException newEx = new DiscoveryException(ex);
				MyLog.errorNoThrows(SerializationBackend.class, newEx);
				throw newEx;
			}
			this.getResourceSet().getResources().add(this.resource);
		}
		this.discoverer.setTargetResource(this.resource);
	}

	protected abstract Resource createNewTargetResource(URI uri)
			throws DiscoveryException, IOException;

	public final void save(final Resource res, final URI uri)
			throws IOException {
		res.setURI(uri);
		this.saveTargetModel(res, uri);
		this.deleteLastSavedInternal(uri);
		this.lastUri = uri;
	}

	protected abstract void saveTargetModel(final Resource res, final URI uri)
			throws IOException;

	private void deleteLastSavedInternal(final URI currUri) throws IOException {
		if ((!(this.mySettings.isBatchMode())) || (this.lastUri == null)) {
			return;
		}
		final String currUriStr = currUri.toFileString();
		final String lastUriStr = this.lastUri.toFileString();
		if (lastUriStr.equals(currUriStr)) {
			return;
		}
		MyLog.trace(SerializationBackend.class,
				"batchMode, deleting previous uri='" + lastUriStr + "...");
		final boolean deleted = this.deleteLastSaved(this.lastUri);
		MyLog.log(SerializationBackend.class,
				"batchMode, delete previous uri='" + lastUriStr + ", deleted='"
						+ deleted + "'!");
	}

	protected abstract boolean deleteLastSaved(final URI lastURI)
			throws IOException;
	
	public final void close() {
		if ((this.discoverer.getResourceSet() == null)
				|| (this.discoverer.getTargetURI() == null)
				|| (this.discoverer.getTargetResource() == null)) {
			return;
		}
		try {
			this.closeInternal();
		} catch (final Exception ex) {
			MyLog.errorNoThrows(SerializationBackend.class, ex);
		}
	}
	
	protected abstract void closeInternal() throws IOException;
	
}
