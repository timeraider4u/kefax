package at.jku.weiner.kefax.configure;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;

import at.jku.weiner.kefax.shared.KefaxUtils;
import at.jku.weiner.kefax.shared.MyActionHandler;
import at.jku.weiner.kefax.shared.MyNotification;
import at.jku.weiner.kefax.shared.Settings;

public class DeleteHandler extends MyActionHandler {

	public DeleteHandler() {
		super("at.jku.weiner.kefax.configure.delete.command");
	}

	@Override
	protected void myRun() throws Exception {
		final IFolder folder = KefaxUtils.getLinuxSrcFolder();
		final IFile configFile = KefaxUtils.getLinuxConfigFile();
		if (configFile.exists()) {
			configFile.delete(true, this.getMonitor());
		}
		final IFile configOldFile = folder
				.getFile(Settings.LINUX_CHECKOUT_CONFIG_OLD);
		if (configOldFile.exists()) {
			configOldFile.delete(true, this.getMonitor());
		}
		final IProject project = KefaxUtils.getLinuxProject();
		project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());

		MyNotification.run("Deleting .config done!",
				"Deleting config files has been successfull!");

	}
	
}
