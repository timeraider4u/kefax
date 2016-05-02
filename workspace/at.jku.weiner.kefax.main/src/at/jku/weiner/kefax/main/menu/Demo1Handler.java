package at.jku.weiner.kefax.main.menu;

import org.eclipse.core.resources.IProject;

import at.jku.weiner.kefax.compile.CompileHandler;
import at.jku.weiner.kefax.configfeatures.ConfigFeatureHandler;
import at.jku.weiner.kefax.configure.ConfigureHandler;
import at.jku.weiner.kefax.gitclone.GitCloneAction;
import at.jku.weiner.kefax.infra.InfraCmdHandler;
import at.jku.weiner.kefax.shared.KefaxUtils;
import at.jku.weiner.kefax.shared.MyActionHandler;
import at.jku.weiner.kefax.shared.MyNotification;

public class Demo1Handler extends MyActionHandler {

	public Demo1Handler() {
		super("at.jku.weiner.kefax.main.Demo1Cmd");
	}

	@Override
	protected void myRun() throws Exception {
		// TODO Auto-generated method stub
		final IProject srcProject = KefaxUtils.getLinuxProject();
		final IProject dstProject = KefaxUtils.getLinuxDiscoverProject();
		if (srcProject.exists()) {
			srcProject.delete(true, this.getMonitor());
		}
		if (dstProject.exists()) {
			dstProject.delete(true, this.getMonitor());
		}
		
		final GitCloneAction gitClone = new GitCloneAction();
		gitClone.start();
		final ConfigureHandler configHandler = new ConfigureHandler();
		configHandler.start();
		final ConfigFeatureHandler featureHandler = new ConfigFeatureHandler();
		featureHandler.start();
		final CompileHandler compileHandler = new CompileHandler();
		compileHandler.start();
		final InfraCmdHandler infraCmdHandler = new InfraCmdHandler();
		infraCmdHandler.start();
		final MainHandler mainHandler = new MainHandler();
		mainHandler.start();
		MyNotification.run("Kefax demo done", "Kefax demonstration has finished successfully!");
	}

}
