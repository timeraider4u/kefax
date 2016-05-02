package at.jku.weiner.kefax.main.menu;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;

import at.jku.weiner.kefax.shared.KefaxUtils;
import at.jku.weiner.kefax.shared.MyActionHandler;
import at.jku.weiner.kefax.shared.MySettings;

public class CleanUpCommand extends MyActionHandler {
	
	public CleanUpCommand() {
		super("at.jku.weiner.kefax.main.CleanUpCommand");
	}

	@Override
	protected void myRun() throws Exception {
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
