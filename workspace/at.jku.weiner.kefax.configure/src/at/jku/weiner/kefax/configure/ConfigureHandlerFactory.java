package at.jku.weiner.kefax.configure;

import at.jku.weiner.kefax.shared.MyActionHandler;

public final class ConfigureHandlerFactory {

	public static final MyActionHandler createConfigureHandler(final boolean isModeA) {
		if (isModeA) {
			return new ConfigureHandlerA();
		}
		return new ConfigureHandlerB();
	}
	
}
