package at.jku.weiner.c.modisco.discoverer.backend;

import at.jku.weiner.c.modisco.discoverer.utils.MySettings;

public final class SerializationFactory {

	private SerializationFactory() {

	}

	public static SerializationBackend getBackend(final IDiscoverer discoverer,
			final MySettings mySettings) {
		if (mySettings.isUseNeoEMF()) {
			return new NeoEMFSerializationBackend(discoverer, mySettings);
		} else {
			return new XMISerializationBackend(discoverer, mySettings);
		}
	}

}
