package at.jku.weiner.kefax.main.menu;

import java.util.Date;

import org.eclipse.core.resources.IProject;

import at.jku.weiner.kefax.compile.CompileHandler;
import at.jku.weiner.kefax.configfeatures.ConfigFeatureHandler;
import at.jku.weiner.kefax.configure.ConfigureHandlerFactory;
import at.jku.weiner.kefax.gitclone.GitCloneAction;
import at.jku.weiner.kefax.infra.InfraCmdHandler;
import at.jku.weiner.kefax.shared.KefaxUtils;
import at.jku.weiner.kefax.shared.MyActionHandler;
import at.jku.weiner.kefax.shared.MyNotification;
import at.jku.weiner.log.MyLog;

abstract class DemoHandler extends MyActionHandler {
	private final boolean isMode;

	public DemoHandler(final String actionName, final boolean isMode) {
		super(actionName);
		this.isMode = isMode;
	}

	@Override
	protected final void myRun() throws Exception {
		final Date start = new Date();
		//System.gc();
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
		final MyActionHandler configHandler = ConfigureHandlerFactory.createConfigureHandler(isMode);
		configHandler.start();
		final ConfigFeatureHandler featureHandler = new ConfigFeatureHandler();
		featureHandler.start();
		final CompileHandler compileHandler = new CompileHandler();
		compileHandler.start();
		final InfraCmdHandler infraCmdHandler = new InfraCmdHandler();
		infraCmdHandler.start();
		final MainHandler mainHandler = new MainHandler();
		mainHandler.start();
		final BrowserCommandHandler browserHandler = new BrowserCommandHandler();
		browserHandler.start();
		final CloseCommand closeHandler = new CloseCommand();
		closeHandler.start();
		final Date end = new Date();
		final long difference = end.getTime() - start.getTime();
		final long sec = difference / 1000;
		final long min = sec / 60;
		final long seconds = sec % 60;
		MyLog.log(MainHandler.class, "Demonstration mode took '" + min + "' minutes and '"
				+ seconds + "' seconds for !");		
		MyNotification.run("Kefax demo done", "Kefax demonstration has finished successfully after '" 
				+ min + "'minutes and '" 
				+ seconds + "' seconds!");
	}
	
}
