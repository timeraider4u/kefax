package at.jku.weiner.c.modisco.discoverer.backend;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import fr.inria.atlanmod.neoemf.datastore.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.graph.blueprints.datastore.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.graph.blueprints.util.NeoBlueprintsURI;
import fr.inria.atlanmod.neoemf.resources.PersistentResourceFactory;
import fr.inria.atlanmod.neoemf.resources.impl.PersistentResourceFactoryImpl;
import at.jku.weiner.c.modisco.discoverer.neoemf.NeoEMFDiscoverUtils;
import at.jku.weiner.c.modisco.discoverer.utils.MySettings;

public class NeoEMFSerializationBackend extends SerializationBackend {

	protected NeoEMFSerializationBackend(final IDiscoverer discoverer,
			final MySettings mySettings) {
		super(discoverer, mySettings);
	}

	@Override
	protected ResourceSet createNewResourceSet() {
		final BlueprintsPersistenceBackendFactory persistenceBackendFactory = new BlueprintsPersistenceBackendFactory();
		PersistenceBackendFactoryRegistry.getFactories().put(
				NeoBlueprintsURI.NEO_GRAPH_SCHEME, persistenceBackendFactory);
		ResourceSet resSet = new ResourceSetImpl();
		final Registry reg = resSet.getResourceFactoryRegistry();
		final Map<String, Object> map = reg.getProtocolToFactoryMap();
		final PersistentResourceFactory factory = new PersistentResourceFactoryImpl();
		map.put(NeoBlueprintsURI.NEO_GRAPH_SCHEME, factory);
		return resSet;
	}

	@Override
	public URI getTargetURI(final IResource iResource,
			final IProgressMonitor monitor) throws DiscoveryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getBackendExtension() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Resource createNewTargetResource() throws DiscoveryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void saveTargetModel(final Resource res, final URI uri)
			throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean deleteLastSaved(final URI lastURI) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

}
