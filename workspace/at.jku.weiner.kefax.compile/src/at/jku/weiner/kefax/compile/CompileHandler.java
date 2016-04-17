package at.jku.weiner.kefax.compile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;

import at.jku.weiner.kefax.shared.KefaxUtils;
import at.jku.weiner.kefax.shared.MyActionHandler;
import at.jku.weiner.kefax.shared.MySettings;
import at.jku.weiner.log.MyLog;

public class CompileHandler extends MyActionHandler {
	
	public CompileHandler() {
		super("at.jku.weiner.kefax.compile");
	}
	
	@Override
	protected void myRun() throws Exception {
		MyLog.trace(CompileHandler.class, "starting compile handler!");
		final IProject project = KefaxUtils.getLinuxProject();
		final String src = KefaxUtils.getLinuxSrcFolderAsFilePath();
		final File workingDirectory = new File(src);
		final List<String> cmds = new ArrayList<String>();
		cmds.add(MySettings.MAKE_COMMAND);
		cmds.add(MySettings.MAKE_ARG_3);
		if (!KefaxUtils.executeCommand(cmds, workingDirectory,
				this.getMonitor(), false)) {
			return;
		}
		project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
		MyLog.trace(CompileHandler.class, "compilation done!");
	}

}
