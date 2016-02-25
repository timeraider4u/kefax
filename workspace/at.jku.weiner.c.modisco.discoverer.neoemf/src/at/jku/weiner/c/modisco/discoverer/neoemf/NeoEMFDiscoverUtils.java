package at.jku.weiner.c.modisco.discoverer.neoemf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import at.jku.weiner.c.common.common.CommonFactory;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.modisco.discoverer.neoemf.utils.Messages;
import fr.inria.atlanmod.neoemf.datastore.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.graph.blueprints.datastore.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.graph.blueprints.neo4j.resources.BlueprintsNeo4jResourceOptions;
import fr.inria.atlanmod.neoemf.graph.blueprints.resources.BlueprintsResourceOptions;
import fr.inria.atlanmod.neoemf.graph.blueprints.util.NeoBlueprintsURI;
import fr.inria.atlanmod.neoemf.resources.PersistentResourceOptions;
import fr.inria.atlanmod.neoemf.resources.impl.PersistentResourceFactoryImpl;

public final class NeoEMFDiscoverUtils {

	private static ResourceSet resSet = null;

	public static ResourceSet getResSet() {
		if (NeoEMFDiscoverUtils.resSet == null) {
			PersistenceBackendFactoryRegistry.getFactories().put(
					NeoBlueprintsURI.NEO_GRAPH_SCHEME,
					new BlueprintsPersistenceBackendFactory());
			NeoEMFDiscoverUtils.resSet = new ResourceSetImpl();
			NeoEMFDiscoverUtils.resSet
					.getResourceFactoryRegistry()
			.getProtocolToFactoryMap()
			.put(NeoBlueprintsURI.NEO_GRAPH_SCHEME,
					new PersistentResourceFactoryImpl());
		}
		return NeoEMFDiscoverUtils.resSet;
	}

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
		ResourceSet resSet = NeoEMFDiscoverUtils.getResSet();
		Resource resource = resSet.createResource(uri);
		return resource;
	}

	public static void saveTargetModel(final URI uri, final Resource res)
			throws IOException {
		// Create the map holding the options
		Map<Object, Object> options = new HashMap<Object, Object>();
		List<Object> storeOptions = new ArrayList<Object>();
		storeOptions.add(PersistentResourceOptions.EStoreOption.LOGGING);
		// storeOptions
		// .add(BlueprintsResourceOptions.EStoreGraphOption.DIRECT_WRITE);
		storeOptions
		.add(BlueprintsResourceOptions.EStoreGraphOption.AUTOCOMMIT);
		options.put(BlueprintsResourceOptions.OPTIONS_BLUEPRINTS_GRAPH_TYPE,
				BlueprintsNeo4jResourceOptions.OPTIONS_BLUEPRINTS_TYPE_NEO4J);
		options.put(
				BlueprintsNeo4jResourceOptions.OPTIONS_BLUEPRINTS_NEO4J_CACHE_TYPE,
				BlueprintsNeo4jResourceOptions.CACHE_TYPE.STRONG);
		options.put(PersistentResourceOptions.STORE_OPTIONS, storeOptions);
		res.save(options);
	}

	public static void test() {
		MyLog.log(NeoEMFDiscoverUtils.class, "test()");

		BlueprintsPersistenceBackendFactory factory = new BlueprintsPersistenceBackendFactory();
		PersistenceBackendFactoryRegistry.getFactories().put(
				NeoBlueprintsURI.NEO_GRAPH_SCHEME, factory);
		ResourceSet resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry()
				.getProtocolToFactoryMap()
				.put(NeoBlueprintsURI.NEO_GRAPH_SCHEME,
						new PersistentResourceFactoryImpl());
		final String fileName = "/home/adalgrim/weiner/temp/neoblueprint";
		final File file = new File(fileName);
		MyLog.log(NeoEMFDiscoverUtils.class, "creating resource");
		Resource resource = resSet.createResource(NeoBlueprintsURI
				.createNeoGraphURI(file));

		// load the resource
		MyLog.log(NeoEMFDiscoverUtils.class, "loading the resource!");
		try {
			resource.load(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// perform modifications
		MyLog.log(NeoEMFDiscoverUtils.class, "performing modifications!");
		CommonFactory factory2 = CommonFactory.eINSTANCE;
		TranslationUnit unit = factory2.createTranslationUnit();
		unit.setPath("example path");
		resource.getContents().add(unit);

		// save the modifications
		MyLog.log(NeoEMFDiscoverUtils.class, "saving!");
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// unload the resource and shutdown the database engine
		MyLog.log(NeoEMFDiscoverUtils.class, "unload!");
		resource.unload();
	}
}
