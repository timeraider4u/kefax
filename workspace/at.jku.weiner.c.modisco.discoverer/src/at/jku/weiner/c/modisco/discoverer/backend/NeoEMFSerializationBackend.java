package at.jku.weiner.c.modisco.discoverer.backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import fr.inria.atlanmod.neoemf.datastore.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.graph.blueprints.datastore.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.graph.blueprints.neo4j.resources.BlueprintsNeo4jResourceOptions;
import fr.inria.atlanmod.neoemf.graph.blueprints.resources.BlueprintsResourceOptions;
import fr.inria.atlanmod.neoemf.graph.blueprints.util.NeoBlueprintsURI;
import fr.inria.atlanmod.neoemf.resources.PersistentResourceFactory;
import fr.inria.atlanmod.neoemf.resources.PersistentResourceOptions;
import fr.inria.atlanmod.neoemf.resources.impl.PersistentResourceFactoryImpl;
import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.modisco.discoverer.utils.Messages;
import at.jku.weiner.c.modisco.discoverer.utils.MySettings;
import at.jku.weiner.c.parser.utils.ParserUnloader;
import at.jku.weiner.c.preprocess.utils.PreprocessUnloader;

public class NeoEMFSerializationBackend extends SerializationBackend {

	private static ResourceSet lastResSet = null;

	protected NeoEMFSerializationBackend(final IDiscoverer discoverer,
			final MySettings mySettings) {
		super(discoverer, mySettings);
	}

	@Override
	protected final void initializeInternal() throws DiscoveryException {

	}

	@Override
	protected ResourceSet createNewResourceSet() {
		final BlueprintsPersistenceBackendFactory persistenceBackendFactory = new BlueprintsPersistenceBackendFactory();
		PersistenceBackendFactoryRegistry.getFactories().put(
				NeoBlueprintsURI.NEO_GRAPH_SCHEME, persistenceBackendFactory);
		final ResourceSet resSet = new ResourceSetImpl();
		final Registry reg = resSet.getResourceFactoryRegistry();
		final Map<String, Object> map = reg.getProtocolToFactoryMap();
		final PersistentResourceFactory factory = new PersistentResourceFactoryImpl();
		map.put(NeoBlueprintsURI.NEO_GRAPH_SCHEME, factory);
		NeoEMFSerializationBackend.lastResSet = resSet;
		return resSet;
	}

	@Override
	public URI createTargetURI(final IResource iResource,
			final IProgressMonitor monitor) throws DiscoveryException {
		final URI lastUri = super.getLastUri();
		if ((lastUri != null) && this.mySettings.isBatchMode()) {
			MyLog.trace(NeoEMFSerializationBackend.class,
					"re-using existing targetURI!");
			return lastUri;
		}
		MyLog.trace(NeoEMFSerializationBackend.class, "creating new targetURI!");
		final URI fileUri = super.createTargetFileURI(iResource, monitor);
		final URI result = NeoBlueprintsURI.createNeoGraphURI(fileUri);
		return result;
	}

	@Override
	protected String getBackendExtension() {
		return Messages.modelNeoEMFSuffix;
	}

	@Override
	protected Resource createNewTargetResource(final URI uri)
			throws DiscoveryException, IOException {
		final ResourceSet resSet = this.getResourceSet();
		final Resource resource = resSet.createResource(uri);
		MyLog.log(NeoEMFSerializationBackend.class,
				"saving target model - first!");
		this.saveTargetModel(resource, uri);
		return resource;
	}

	@Override
	protected void saveTargetModel(final Resource res, final URI uri)
			throws IOException {
		MyLog.trace(NeoEMFSerializationBackend.class,
				"saving model to '" + uri.toString() + "!");
		// Create the map holding the options
		final Map<Object, Object> options = new HashMap<Object, Object>();
		final List<Object> storeOptions = new ArrayList<Object>();
		// storeOptions.add(PersistentResourceOptions.EStoreOption.LOGGING);
		storeOptions
		.add(BlueprintsResourceOptions.EStoreGraphOption.DIRECT_WRITE);
		storeOptions
		.add(BlueprintsResourceOptions.EStoreGraphOption.AUTOCOMMIT);
		options.put(BlueprintsResourceOptions.OPTIONS_BLUEPRINTS_GRAPH_TYPE,
				BlueprintsNeo4jResourceOptions.OPTIONS_BLUEPRINTS_TYPE_NEO4J);
		options.put(
				BlueprintsNeo4jResourceOptions.OPTIONS_BLUEPRINTS_NEO4J_CACHE_TYPE,
				BlueprintsNeo4jResourceOptions.CACHE_TYPE.WEAK);
		options.put(PersistentResourceOptions.STORE_OPTIONS, storeOptions);
		res.save(options);
	}

	@Override
	protected boolean deleteLastSaved(final URI lastURI) throws IOException {
		return false;
	}

	@Override
	protected void closeInternal() throws IOException {
		PreprocessUnloader.unloadCachedStuff();
		ParserUnloader.unloadCachedStuff();
		this.unloadResSet();
	}

	private void unloadResSet() {
		MyLog.trace(NeoEMFSerializationBackend.class,
				"unloading resource set - phase 1!");
		this.discoverer.setResourceSet(null);
		MyLog.trace(NeoEMFSerializationBackend.class,
				"unloading resource set - phase 2!");
		if ((NeoEMFSerializationBackend.lastResSet != null)) {

			final EList<Resource> list = NeoEMFSerializationBackend.lastResSet
					.getResources();
			if (list != null) {
				for (final Resource res : list) {
					if (res.isLoaded()) {
						res.unload();
					}
				}
			}
			NeoEMFSerializationBackend.lastResSet.getResources().clear();
			NeoEMFSerializationBackend.lastResSet.getResourceFactoryRegistry()
			.getProtocolToFactoryMap().clear();
		}
		MyLog.trace(NeoEMFSerializationBackend.class,
				"unloading resource set - phase 3!");
		PersistenceBackendFactoryRegistry.getFactories().clear();
		NeoEMFSerializationBackend.lastResSet = null;
	}

}
