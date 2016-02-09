package at.jku.weiner.kefax.main.menu;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.RadioState;

import at.jku.weiner.c.common.log.MyLog;

public class SetLogLevelCommand extends AbstractHandler {
	
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		// if (HandlerUtil.matchesRadioState(event)) {
		// // we are already in the updated state - do nothing
		// return null;
		// }
		final String currentState = event.getParameter(RadioState.PARAMETER_ID);
		// perform task for current state
		if ("LOG_LEVEL_NONE".equals(currentState)) {
			MyLog.setLog_level(MyLog.LOG_NONE);
		} else if ("LOG_LEVEL_ERROR".equals(currentState)) {
			MyLog.setLog_level(MyLog.LOG_ERROR);
		} else if ("LOG_LEVEL_DEBUG".equals(currentState)) {
			MyLog.setLog_level(MyLog.LOG_DEBUG);
		} else if ("LOG_LEVEL_TRACE".equals(currentState)) {
			MyLog.setLog_level(MyLog.LOG_TRACE);
		} else { // ("LOG_LEVEL_INFO".equals(currentState))
			MyLog.setLog_level(MyLog.LOG_INFO);
		}
		// and so on ...

		// and finally update the current state
		HandlerUtil.updateRadioState(event.getCommand(), currentState);
		
		return null;
	}

}
