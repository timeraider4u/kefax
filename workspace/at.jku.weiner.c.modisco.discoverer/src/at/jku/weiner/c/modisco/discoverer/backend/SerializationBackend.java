package at.jku.weiner.c.modisco.discoverer.backend;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.modisco.discoverer.actions.impl.DiscoverFromIFile;
import at.jku.weiner.c.modisco.discoverer.utils.MySettings;

public abstract class SerializationBackend {

	protected final IDiscoverer discoverer;
	private final MySettings mySettings;
	
	private ResourceSet resSet = null;
	private URI lastUri = null;
	private Resource lastResource = null;

	protected SerializationBackend(final IDiscoverer discoverer,
			final MySettings mySettings) {
		this.discoverer = discoverer;
		this.mySettings = mySettings;
	}

	public ResourceSet getResourceSet() {
		if (this.resSet == null) {
			this.resSet = this.createNewResourceSet();
		}
		return this.resSet;
	}

	protected abstract ResourceSet createNewResourceSet();

	public abstract URI getTargetURI();

	protected URI createTargetFileURI() {
		final String pathName = "";
		final URI result = URI.createFileURI(pathName);
		return result;
	}
	
	protected abstract String getBackendExtension();
	
	protected abstract Resource createNewTargetResource();

	public void save(final Resource res, final URI uri) throws IOException {
		res.setURI(uri);
		this.saveTargetModel(res, uri);
		this.deleteLastSavedInternal(uri);
		this.lastUri = uri;
		this.lastResource = res;
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
