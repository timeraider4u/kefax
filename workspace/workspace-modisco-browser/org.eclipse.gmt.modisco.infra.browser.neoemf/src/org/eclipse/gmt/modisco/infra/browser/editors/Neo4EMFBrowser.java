package org.eclipse.gmt.modisco.infra.browser.editors;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmt.modisco.infra.browser.util.Neo4EMFEditorInput;

import fr.inria.atlanmod.neoemf.datastore.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.graph.blueprints.datastore.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.graph.blueprints.neo4j.resources.BlueprintsNeo4jResourceOptions;
import fr.inria.atlanmod.neoemf.graph.blueprints.resources.BlueprintsResourceOptions;
import fr.inria.atlanmod.neoemf.graph.blueprints.util.NeoBlueprintsURI;
import fr.inria.atlanmod.neoemf.resources.PersistentResource;
import fr.inria.atlanmod.neoemf.resources.impl.PersistentResourceFactoryImpl;

public class Neo4EMFBrowser extends EcoreBrowser {
	
	public static final String EDITOR_ID = "org.eclipse.gmt.modisco.infra.browser.NeoEditor";

	public Neo4EMFBrowser() {
	}
	
	@Override
	protected Resource createModel() {
			Assert.isTrue(getEditorInput() instanceof Neo4EMFEditorInput, getEditingDomain()+ " is not type of Neo4EMFEditorInput");
		IFolder dbFolder = ((Neo4EMFEditorInput)getEditorInput()).getDbFolder();
		final String dirPath = dbFolder.getLocation().toFile().getAbsolutePath();
//		String dirPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString()+dbFolder.getFullPath().toString();
		
		PersistenceBackendFactoryRegistry.getFactories().put(NeoBlueprintsURI.NEO_GRAPH_SCHEME, 
			    new BlueprintsPersistenceBackendFactory());
			ResourceSet resSet = new ResourceSetImpl();
			resSet.getResourceFactoryRegistry().getProtocolToFactoryMap().
			    put(NeoBlueprintsURI.NEO_GRAPH_SCHEME, new PersistentResourceFactoryImpl());
		
		URI n4eResourceUri = createNeo4emfURI(dirPath);
		
		
			Resource resource = resSet.createResource(n4eResourceUri);
		System.out.println("loading uri='" + n4eResourceUri.toFileString() + "'");
				
		Map<String, String> loadOptions = new HashMap<String, String>();
		loadOptions.put(BlueprintsResourceOptions.OPTIONS_BLUEPRINTS_GRAPH_TYPE,
				BlueprintsNeo4jResourceOptions.OPTIONS_BLUEPRINTS_TYPE_NEO4J);
		try {
			resource.load(loadOptions);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return resource;
	}

	@Override
	public void dispose() {
		for (Resource resource : getEditingDomain().getResourceSet().getResources()) {
			if (resource instanceof PersistentResource) {
				((PersistentResource) resource).unload();
			}
		}
		super.dispose();
	}
	
	
	private static URI createNeo4emfURI(String path) {
		System.out.println("createNeo4emfURI='" + path + "'");
		URI fileUri = URI.createFileURI(path);
		System.out.println("fileUri='" + fileUri.toString() + "'");
		URI uri = NeoBlueprintsURI.createNeoGraphURI(fileUri);
		System.out.println("uri='" + uri.toString() + "'");
//
//		URI uri = URI.createHierarchicalURI(
//				NeoBlueprintsURI.NEO_GRAPH_SCHEME, 
//				fileUri.authority(),
//				fileUri.device(),
//				fileUri.segments(),
//				fileUri.query(),
//				fileUri.fragment());
		return uri;
	}
}