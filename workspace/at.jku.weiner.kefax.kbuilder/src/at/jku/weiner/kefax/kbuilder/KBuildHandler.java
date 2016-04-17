package at.jku.weiner.kefax.kbuilder;

import at.jku.weiner.kefax.shared.MyActionHandler;
import at.jku.weiner.log.MyLog;

public class KBuildHandler extends MyActionHandler {
	
	public KBuildHandler() {
		super("at.jku.weiner.kefax.kbuilder");
	}
	
	@Override
	protected void myRun() throws Exception {
		MyLog.log(KBuildHandler.class, "started KBuildHandler run");
	}
	
}
