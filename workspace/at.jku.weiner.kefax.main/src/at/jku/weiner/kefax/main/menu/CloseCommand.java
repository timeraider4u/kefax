package at.jku.weiner.kefax.main.menu;

import at.jku.weiner.c.modisco.discoverer.actions.impl.DiscoverFromIResource;
import at.jku.weiner.kefax.shared.MyActionHandler;

public class CloseCommand extends MyActionHandler {
	
	private static DiscoverFromIResource discoverer = null;
	
	public static void setDiscoverer(final DiscoverFromIResource discoverer) {
		CloseCommand.discoverer = discoverer;
	}

	public CloseCommand() {
		super("at.jku.weiner.kefax.main.closecommand");
	}

	@Override
	protected void myRun() throws Exception {
		if (discoverer == null) {
			throw new NullPointerException("discoverer should be set first!");
		}
		discoverer.close();
	}

}
