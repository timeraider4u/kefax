package at.jku.weiner.c.modisco.discoverer.xtext;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;
import org.eclipse.xtext.resource.IResourceFactory;

import fr.inria.atlanmod.neoemf.resources.impl.PersistentResourceImpl;
import fr.inria.atlanmod.neoemf.util.NeoURI;
import at.jku.weiner.c.modisco.discoverer.backend.SerializationBackend;
import at.jku.weiner.c.modisco.discoverer.utils.MyStore;

public class MyResourceFactory implements IResourceFactory {

	private final MyStore store;
	
	public MyResourceFactory(final MyStore myStore) {
		this.store = myStore;
	}
	
	@Override
	public Resource createResource(final URI uri) {
		final SerializationBackend backend = this.store.getBackend();
		final URI currUri = this.store.getDiscoverer().getTargetURI();
		try {
			System.err.println("createResource uri='" + uri + "'");
			// final URI newUri = NeoURI.createNeoURI(uri);
			// return backend.createNewTargetResource(currUri);
			return new PersistentResourceImpl(uri);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
