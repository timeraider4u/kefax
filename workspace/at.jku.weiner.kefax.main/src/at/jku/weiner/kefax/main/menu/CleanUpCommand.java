package at.jku.weiner.kefax.main.menu;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;

import at.jku.weiner.kefax.shared.KefaxUtils;
import at.jku.weiner.kefax.shared.MySettings;
import at.jku.weiner.log.MyLog;

public class CleanUpCommand extends AbstractHandler {
	
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		try {
			this.myRun();
		} catch (final Exception ex) {
			MyLog.errorNoThrows(CleanUpCommand.class, ex);
		}
		return null;
	}
	
	private void myRun() throws Exception {
		final IResource res = KefaxUtils.getLinuxDiscoverTmpWorkingFolder();
		if (res == null) {
			throw new RuntimeException("could not find '"
					+ MySettings.LINUX_DISCOVER_TMP_WORK_DIR + "' in project '"
					+ MySettings.LINUX_DISCOVER_PRJ + "'!");
		} else if (res.exists()) {
			res.delete(true, new NullProgressMonitor());
		}
	}
	
}
