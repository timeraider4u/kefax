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
import at.jku.weiner.c.modisco.discoverer.actions.impl.DiscoverFromIFile;
import at.jku.weiner.c.modisco.discoverer.utils.MySettings;

public abstract class SerializationBackend {

	protected final IDiscoverer discoverer;
	private final MySettings mySettings;

	private ResourceSet resSet = null;
	private Resource resource = null;

	private URI lastUri = null;

	protected SerializationBackend(final IDiscoverer discoverer,
			final MySettings mySettings) {
		this.discoverer = discoverer;
		this.mySettings = mySettings;
	}

	public final ResourceSet getResourceSet() {
		if (this.resSet == null) {
			this.resSet = this.createNewResourceSet();
		}
		return this.resSet;
	}

	protected abstract ResourceSet createNewResourceSet();

	public abstract URI getTargetURI(IResource iResource,
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

	public final Resource createTargetResource() throws DiscoveryException {
		if (this.resource == null) {
			this.resource = this.createNewTargetResource();
			this.getResourceSet().getResources().add(this.resource);
		}
		return this.resource;
	}

	protected abstract Resource createNewTargetResource()
			throws DiscoveryException;

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
		MyLog.trace(DiscoverFromIFile.class,
				"batchMode, deleting previous uri='" + lastUriStr + "...");
		final boolean deleted = this.deleteLastSaved(this.lastUri);
		MyLog.log(DiscoverFromIFile.class, "batchMode, delete previous uri='"
				+ lastUriStr + ", deleted='" + deleted + "'!");
	}

	protected abstract boolean deleteLastSaved(final URI lastURI)
			throws IOException;

}
