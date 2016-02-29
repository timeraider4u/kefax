package at.jku.weiner.c.modisco.discoverer.backend;

import org.eclipse.emf.common.util.URI;

import at.jku.weiner.c.modisco.discoverer.utils.MyStore;

public abstract class SerializationBackend {

	private final MyStore myStore;

	private final URI lastUri = null;

	public SerializationBackend(final MyStore myStore) {
		this.myStore = myStore;

	}

}
