package at.jku.weiner.kefax.shared;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;

import at.jku.weiner.log.MyLog;

public abstract class MyActionHandler extends AbstractHandler {
	
	private final String actionName;
	private IProgressMonitor monitor;
	private ExecutionEvent event;

	public MyActionHandler(final String actionName) {
		this.actionName = actionName;
		this.monitor = null;
		event = null;
	}
	
	private class MyActionJob extends Job {

		public MyActionJob(final String name) {
			super(name);
		}

		@Override
		protected IStatus run(final IProgressMonitor monitor) {
			final SubMonitor subMonitor = SubMonitor.convert(monitor,
					IProgressMonitor.UNKNOWN);
			MyActionHandler.this.monitor = subMonitor;
			final IStatus result = MyActionHandler.this.run();
			return result;
		}
		
	}
	
	public final void start() throws Exception {
		event = null;
		final Job job = new MyActionJob(this.getActionName());
		job.schedule();
		job.join();
		final IStatus result = job.getResult();
		if (!result.isOK()) {
			throw new OperationCanceledException("");
		}
	}

	@Override
	public final Object execute(final ExecutionEvent event)
			throws ExecutionException {
		this.event = event;
		final Job job = new MyActionJob(this.getActionName());
		job.schedule();
		return null;
	}

	private final IStatus run() {
		try {
			this.myRun();
			return Status.OK_STATUS;
		} catch (final Exception ex) {
			MyLog.errorNoThrows(this.getClass(), ex);
			MyNotification.run("execution of '" + this.getActionName()
					+ "' failed!", ex.getMessage());
			// ex.printStackTrace();
			this.getMonitor().done();
		}
		return Status.CANCEL_STATUS;
	}
	
	protected abstract void myRun() throws Exception;
	
	protected IProgressMonitor getMonitor() {
		return this.monitor;
	}

	public String getActionName() {
		return this.actionName;
	}
	
	protected ExecutionEvent getEvent() {
		return this.event;
	}
	
}
