package at.jku.weiner.log.eclipselog;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import at.jku.weiner.log.MyLogServiceProvider;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator implements BundleActivator {

	private static BundleContext context;
	
	static BundleContext getContext() {
		return Activator.context;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(final BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		MyLogServiceProvider.register(new MyConsoleViewLoggerImpl());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop(final BundleContext context) throws Exception {
		Activator.context = null;
	}

}
