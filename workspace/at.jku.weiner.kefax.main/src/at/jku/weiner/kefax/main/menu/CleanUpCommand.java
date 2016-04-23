package at.jku.weiner.kefax.main.menu;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;

import at.jku.weiner.kefax.main.work.Settings;
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
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		final IProject linux = root.getProject(Settings.LINUX);
		if (linux == null) {
			throw new RuntimeException(
					"could not find linux project in workspace!");
		}
		final IResource res = linux.findMember(Settings.TMP_WORK_DIR);
		if (res == null) {
			throw new RuntimeException("could not find '"
					+ Settings.TMP_WORK_DIR + "' in project '" + Settings.LINUX
					+ "'!");
		}
		res.delete(true, new NullProgressMonitor());
	}
	
}
