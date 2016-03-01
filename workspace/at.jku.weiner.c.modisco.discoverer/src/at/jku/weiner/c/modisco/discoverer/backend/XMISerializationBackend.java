package at.jku.weiner.c.modisco.discoverer.backend;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.modisco.discoverer.utils.Messages;
import at.jku.weiner.c.modisco.discoverer.utils.MySettings;

public final class XMISerializationBackend extends SerializationBackend {

	protected XMISerializationBackend(final IDiscoverer discoverer,
			final MySettings mySettings) {
		super(discoverer, mySettings);
	}

	@Override
	protected ResourceSet createNewResourceSet() {
		return new ResourceSetImpl();
	}

	@Override
	public URI getTargetURI(final IResource iResource, final IProgressMonitor monitor)
			throws DiscoveryException {
		return super.createTargetFileURI(iResource, monitor);
	}

	@Override
	protected String getBackendExtension() {
		return Messages.modelFileSuffix;
	}

	@Override
	protected Resource createNewTargetResource() {
		final Resource targetModel = new XMIResourceImpl();
		return targetModel;
	}

	@Override
	protected void saveTargetModel(final Resource res, final URI uri)
			throws IOException {
		if (res != null) {
			final Map<String, Object> options = new HashMap<String, Object>();
			options.put(XMLResource.OPTION_USE_FILE_BUFFER, Boolean.TRUE);
			if ((uri == null) || (uri.toString().trim().isEmpty())) {
				MyLog.error(XMISerializationBackend.class,
						"Cannot save resource with invalid uri:'" + uri + "'");
				return;
			}
			res.save(options);
		}
	}

	@Override
	protected boolean deleteLastSaved(final URI lastURI) throws IOException {
		final String lastUriStr = lastURI.toFileString();
		final File file = new File(lastUriStr);
		final boolean wasDeleted = file.delete();
		return wasDeleted;
	}

}
