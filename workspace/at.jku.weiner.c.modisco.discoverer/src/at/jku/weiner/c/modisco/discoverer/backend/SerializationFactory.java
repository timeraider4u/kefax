package at.jku.weiner.c.modisco.discoverer.backend;

import at.jku.weiner.c.modisco.discoverer.utils.MySettings;

public final class SerializationFactory {

	private SerializationFactory() {

	}

	public static SerializationBackend getBackend(final boolean useNeoEMF,
			final IDiscoverer discoverer, final MySettings mySettings) {
		if (useNeoEMF) {
			return null;
		} else {
			return new XMISerializationBackend(discoverer, mySettings);
		}
	}

}
