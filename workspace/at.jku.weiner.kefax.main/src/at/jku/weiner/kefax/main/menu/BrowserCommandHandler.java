package at.jku.weiner.kefax.main.menu;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.facet.util.emf.core.IBrowserRegistry;
import org.eclipse.emf.facet.util.emf.core.IResourceBrowserOpener;

import at.jku.weiner.c.modisco.discoverer.actions.impl.DiscoverFromIResource;
import at.jku.weiner.kefax.shared.MyActionHandler;
import at.jku.weiner.log.MyLog;

public class BrowserCommandHandler extends MyActionHandler {

	private static DiscoverFromIResource discoverer = null;
	
	public static void setDiscoverer(final DiscoverFromIResource discoverer) {
		BrowserCommandHandler.discoverer = discoverer;
	}

	public BrowserCommandHandler() {
		super("at.jku.weiner.kefax.main.browsercommand");
	}

	@Override
	protected void myRun() throws Exception {
		if (discoverer == null) {
			throw new NullPointerException("discoverer should be set first!");
		}
		// open browser
		MyLog.log(MainHandler.class, "Opening browser now!");
		final Resource targetModel = discoverer.getTargetResource();
		MyLog.debug(MainHandler.class, "resource targetModel='" + targetModel + "'");
		final IBrowserRegistry browserRegistry = IBrowserRegistry.INSTANCE;
		final IResourceBrowserOpener browser = browserRegistry.getDefaultResourceBrowserOpener();
		MyLog.debug(MainHandler.class, "opening browser='" + browser + "'");
		browser.openResource(targetModel);
		// Neo4EMFBrowser browser2 = new Neo4EMFBrowser();
	}

}
