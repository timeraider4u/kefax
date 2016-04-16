package at.jku.weiner.kefax.ant;

import java.io.PrintStream;

import org.apache.tools.ant.BuildEvent;

public class MyAntBuildLogger implements org.apache.tools.ant.BuildLogger {
	private static final String BUILD_STARTED = "BUILD_STARTED";
	private static final String BUILD_FINISHED = "BUILD_FINISHED";
	private static final String TARGET_STARTED = "TARGET_STARTED";
	private static final String TARGET_FINISHED = "TARGET_FINISHED";
	private static final String TASK_STARTED = "TASK_STARTED";
	private static final String TASK_FINISHED = "TASK_FINISHED";
	private static final String MSG_LOGGED = "MSG_LOGGED";

	@Override
	public void buildStarted(final BuildEvent event) {
		this.log(MyAntBuildLogger.BUILD_STARTED, event);
	}

	@Override
	public void buildFinished(final BuildEvent event) {
		this.log(MyAntBuildLogger.BUILD_FINISHED, event);
	}

	@Override
	public void targetStarted(final BuildEvent event) {
		this.log(MyAntBuildLogger.TARGET_STARTED, event);
	}

	@Override
	public void targetFinished(final BuildEvent event) {
		this.log(MyAntBuildLogger.TARGET_FINISHED, event);
	}

	@Override
	public void taskStarted(final BuildEvent event) {
		this.log(MyAntBuildLogger.TASK_STARTED, event);
	}

	@Override
	public void taskFinished(final BuildEvent event) {
		this.log(MyAntBuildLogger.TASK_FINISHED, event);
	}

	@Override
	public void messageLogged(final BuildEvent event) {
		this.log(MyAntBuildLogger.MSG_LOGGED, event);
	}

	@Override
	public void setMessageOutputLevel(final int level) {
	}

	@Override
	public void setOutputPrintStream(final PrintStream output) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEmacsMode(final boolean emacsMode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setErrorPrintStream(final PrintStream err) {
		// TODO Auto-generated method stub
		
	}
	
	private void log(final String phase, final BuildEvent event) {
		System.out.println(phase + ": '" + event.getMessage() + "' from '"
				+ event.getSource() + "'");
		
	}
}
