package at.jku.weiner.kefax.gitclone;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.ui.handlers.HandlerUtil;

import at.jku.weiner.kefax.shared.MyActionHandler;

public class ReUseExistingLinuxSrc extends MyActionHandler {

	private static boolean	reUseExistingLinuxSrc	= false;

	public static boolean reUseExistingLinuxSrc() {
		return ReUseExistingLinuxSrc.reUseExistingLinuxSrc;
	}
	
	public ReUseExistingLinuxSrc() {
		super("at.jku.weiner.kefax.gitclone.reuseexistinglinuxsrc");
	}
	
	@Override
	protected void myRun() throws Exception {
		ExecutionEvent event = this.getEvent();
		Command command = event.getCommand();
		boolean oldValue = HandlerUtil.toggleCommandState(command);
		// use the old value and perform the operation
		ReUseExistingLinuxSrc.reUseExistingLinuxSrc = !oldValue;
	}

}
