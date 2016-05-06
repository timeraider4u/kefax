package at.jku.weiner.kefax.main.menu;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.ui.handlers.HandlerUtil;

import at.jku.weiner.kefax.shared.MyActionHandler;
import at.jku.weiner.log.MyLog;

public class UseNeoEMFHandler extends MyActionHandler {

	public static final String COMMAND_ID = "at.jku.weiner.kefax.main.menu.useneoemf";
	private static boolean useNeoEMFBackend = false;

	public static boolean useNeoEMFBackend() {
		return UseNeoEMFHandler.useNeoEMFBackend;
	}
	
	public UseNeoEMFHandler() {
		super(COMMAND_ID);
	}

	@Override
	protected void myRun() throws Exception {
		ExecutionEvent event = this.getEvent();
		Command command = event.getCommand();
	    boolean oldValue = HandlerUtil.toggleCommandState(command);
	     // use the old value and perform the operation
	    setUseNeoEMFBackend(!oldValue);
	}
	
	public static void setUseNeoEMFBackend(final boolean useNeoEMF) {
		UseNeoEMFHandler.useNeoEMFBackend = useNeoEMF;
		MyLog.log(UseNeoEMFHandler.class,"useNeoEMFBackend='" 
				+ UseNeoEMFHandler.useNeoEMFBackend + "'");
	}
	
}
