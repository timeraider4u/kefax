package at.jku.weiner.c.modisco.discoverer.neoemf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.modisco.discoverer.utils.Messages;
import fr.inria.atlanmod.neoemf.datastore.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.graph.blueprints.datastore.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.graph.blueprints.neo4j.resources.BlueprintsNeo4jResourceOptions;
import fr.inria.atlanmod.neoemf.graph.blueprints.resources.BlueprintsResourceOptions;
import fr.inria.atlanmod.neoemf.graph.blueprints.util.NeoBlueprintsURI;
import fr.inria.atlanmod.neoemf.resources.PersistentResourceFactory;
import fr.inria.atlanmod.neoemf.resources.PersistentResourceOptions;
import fr.inria.atlanmod.neoemf.resources.impl.PersistentResourceFactoryImpl;

public final class NeoEMFDiscoverUtils {

	private static ResourceSet resSet = null;
	private static URI uri = null;

	private static URI getTargetUri(final URI lastUri, final boolean batchMode) {
		if ((lastUri != null) && batchMode) {
			return lastUri;
		}
		final URI result = NeoEMFDiscoverUtils
				.createNeo4emfURI(NeoEMFDiscoverUtils.uri);
		MyLog.trace(NeoEMFDiscoverUtils.class, "resultURI='" + result + "'");
		return result;
	}

	private static void saveTargetUriFirst(final URI targetURI,
			final Resource targetModel) throws IOException {
		MyLog.log(NeoEMFDiscoverUtils.class, "saving target model - first!");
		NeoEMFDiscoverUtils.saveTargetModel(targetURI, targetModel);
	}

	public static ResourceSet createOrGetResSet() {
		NeoEMFDiscoverUtils.unloadResSet();
		final ResourceSet resSet = NeoEMFDiscoverUtils.getResSet();
		return resSet;
	}

	private static ResourceSet getResSet() {
		if ((NeoEMFDiscoverUtils.resSet == null)) {
			final BlueprintsPersistenceBackendFactory persistenceBackendFactory = new BlueprintsPersistenceBackendFactory();
			PersistenceBackendFactoryRegistry.getFactories().put(
					NeoBlueprintsURI.NEO_GRAPH_SCHEME,
					persistenceBackendFactory);
			NeoEMFDiscoverUtils.resSet = new ResourceSetImpl();
			final Registry reg = NeoEMFDiscoverUtils.resSet
					.getResourceFactoryRegistry();
			final Map<String, Object> map = reg.getProtocolToFactoryMap();
			final PersistentResourceFactory factory = new PersistentResourceFactoryImpl();
			map.put(NeoBlueprintsURI.NEO_GRAPH_SCHEME, factory);
		}
		return NeoEMFDiscoverUtils.resSet;
	}

	public static void unloadResSet() {
		System.err.println("unloadResSet1");
		if ((NeoEMFDiscoverUtils.resSet == null)) {
			return;
		}
		System.err.println("unloadResSet2");
		final EList<Resource> list = NeoEMFDiscoverUtils.resSet.getResources();
		if (list != null) {
			for (final Resource res : list) {
				res.unload();
			}
		}
		System.err.println("unloadResSet3");

		NeoEMFDiscoverUtils.resSet.getResourceFactoryRegistry()
				.getProtocolToFactoryMap().clear();
		PersistenceBackendFactoryRegistry.getFactories().clear();
		if (NeoEMFDiscoverUtils.uri != null) {
			// final String path = NeoEMFDiscoverUtils.uri.toFileString();
			// try {
			// FileUtils.forceDelete(new File(path));
			// } catch (final IOException e) {
			// e.printStackTrace();
			// }
			NeoEMFDiscoverUtils.uri = null;
		}

		NeoEMFDiscoverUtils.resSet = null;
	}

	// public static void unload() {
	// NeoEMFDiscoverUtils.resSet = null;
	//
	// }

	private NeoEMFDiscoverUtils() {

	}

	public static String getBackendExtension() {
		return Messages.modelNeoEMFSuffix;
	}

	public static URI createNeo4emfURI(final URI fileUri) {
		final URI uri = NeoBlueprintsURI.createNeoGraphURI(fileUri);
		// URI uri = URI.createHierarchicalURI("neo4emf", fileUri.authority(),
		// fileUri.device(), fileUri.segments(), fileUri.query(),
		// fileUri.fragment());
		return uri;
	}

	public static Resource createTargetModel(final URI uri) {
		final ResourceSet resSet = NeoEMFDiscoverUtils.getResSet();
		final Resource resource = resSet.createResource(uri);
		return resource;
	}

	public static void saveTargetModel(final URI uri, final Resource res)
			throws IOException {
		NeoEMFDiscoverUtils.uri = uri;
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
		// options.put(
		// BlueprintsNeo4jResourceOptions.OPTIONS_BLUEPRINTS_NEO4J_CACHE_TYPE,
		// BlueprintsNeo4jResourceOptions.CACHE_TYPE.WEAK);
		options.put(PersistentResourceOptions.STORE_OPTIONS, storeOptions);
		res.save(options);
	}

}
