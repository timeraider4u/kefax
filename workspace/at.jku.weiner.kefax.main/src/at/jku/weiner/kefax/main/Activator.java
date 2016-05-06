package at.jku.weiner.kefax.main;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.State;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.RegistryToggleState;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import at.jku.weiner.kefax.main.menu.UseNeoEMFHandler;
import at.jku.weiner.log.MyLog;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "MyTestPlugin"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		Activator.plugin = this;
		MyLog.trace(Activator.class, "Starting plug-in!");
		// initialize UseNeoEMFHandler
		initializeUseNeoEMFHandler();
	}

	private void initializeUseNeoEMFHandler() {
		final ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);  
	    final Command useNeoEMFCmd = commandService.getCommand(UseNeoEMFHandler.COMMAND_ID);
	    final State useNeoEMFState = useNeoEMFCmd.getState(RegistryToggleState.STATE_ID);
	    final Boolean useNeoEMF = ((Boolean)useNeoEMFState.getValue());
	    UseNeoEMFHandler.setUseNeoEMFBackend(useNeoEMF);
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
		Activator.plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return Activator.plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 *
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(final String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
				path);
	}
}
