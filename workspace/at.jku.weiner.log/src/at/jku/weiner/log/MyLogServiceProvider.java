package at.jku.weiner.log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MyLogServiceProvider {
	
	private final static List<MyLogService> providers = new ArrayList<MyLogService>();
	
	private MyLogServiceProvider() {
		
	}
	
	public static void register(final MyLogService provider) {
		if (!MyLogServiceProvider.providers.contains(provider)) {
			MyLogServiceProvider.providers.add(provider);
		}
	}
	
	public static void unRegister(final MyLogService provider) {
		if (MyLogServiceProvider.providers.contains(provider)) {
			MyLogServiceProvider.providers.remove(provider);
		}
	}

	protected static List<MyLogService> getServiceProviders() {
		return Collections.unmodifiableList(MyLogServiceProvider.providers);
	}

}
