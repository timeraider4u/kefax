package at.jku.weiner.kefax.configure;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.Project;
import org.eclipse.ant.core.AntRunner;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;

import at.jku.weiner.kefax.shared.KefaxUtils;
import at.jku.weiner.kefax.shared.MyActionHandler;
import at.jku.weiner.kefax.shared.MyFileWriter;
import at.jku.weiner.kefax.shared.MyNotification;
import at.jku.weiner.kefax.shared.MySettings;
import at.jku.weiner.log.MyLog;

class ConfigureHandler extends MyActionHandler {	

	private static final String ANT_SCRIPT_PATH = "configureScript/configureLinux.xml";

	private IProject project = null;
	private String src = null;
	private File workingDirectory = null;
	private IFile config = null;
	private String configPathAsString = null;
	private final boolean isModeA;

	public ConfigureHandler(boolean isModeA) {
		super("at.jku.weiner.kefax.configure.commandHandler");
		this.isModeA = isModeA;
	}

	@Override
	protected void myRun() throws Exception {
		this.project = KefaxUtils.getLinuxProject();
		this.project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());

		this.src = KefaxUtils.getLinuxSrcFolderAsFilePath();
		this.workingDirectory = new File(this.src);
		this.config = KefaxUtils.getLinuxConfigFile();
		this.configPathAsString = KefaxUtils.getURIasFileString(this.config);
		if (!this.checkConfigExists()) {
			return;
		}

		if (!this.generateMinimalConfig()) {
			return;
		}
		if (!this.addSelectedFeaturesToConfig()) {
			return;
		}
		if (!this.updateConfig()) {
			return;
		}
	}

	private boolean checkConfigExists() {
		final boolean configExists = this.config.exists();
		if (configExists) {
			final String msg = "resource '" + this.configPathAsString
					+ "' already exists!" + " Exiting now with this command.";
			MyLog.log(ConfigureHandler.class, msg);
			MyNotification.run(".config already exists", msg);
			return false;
		}
		return true;
	}

	private boolean generateMinimalConfig() {
		final List<String> cmds = new ArrayList<String>();
		cmds.add(MySettings.MAKE_COMMAND);
		cmds.add(MySettings.MAKE_ARG_1);
		if (!KefaxUtils.executeCommand(cmds, this.workingDirectory,
				this.getMonitor(), false)) {
			return false;
		}
		return true;
	}

	private boolean addSelectedFeaturesToConfig() throws Exception {
		this.project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
		final String[] configs = this.getConfigs();
		for (int i = 0; i < configs.length; i++) {
			final String config = configs[i];
			if (!MyFileWriter.appendStringToFile(this.configPathAsString,
					config)) {
				return false;
			}
		}
		this.project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
		return true;
	}
	
	private String[] getConfigs() {
		if (this.isModeA) {
			return MySettings.CONFIGS;
		}
		return MySettings.CONFIGS;
	}

	private boolean updateConfig() throws Exception {
		final List<String> cmds = new ArrayList<String>();
		cmds.add(MySettings.MAKE_COMMAND);
		cmds.add(MySettings.MAKE_ARG_2);
		if (!KefaxUtils.executeCommand(cmds, this.workingDirectory,
				this.getMonitor(), false)) {
			return false;
		}
		this.project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
		return true;
	}

	/**
	 * @see #invokeAntScript(String, String)
	 */
	@SuppressWarnings("unused")
	private String getAntScriptLocation() {
		final Activator pluginActivator = Activator.getDefault();
		final File configureScript = KefaxUtils.getPluginResource(
				pluginActivator, ConfigureHandler.ANT_SCRIPT_PATH);
		final String configureScriptPath = configureScript.getAbsolutePath();
		return configureScriptPath;
	}

	/**
	 * AntRunner would work, but unfortunately there is a problem with the
	 * buildLogger resulting in a ClassCastException during runtime. So we would
	 * not get any output and do not know what the program is doing...
	 */
	@SuppressWarnings("unused")
	private void invokeAntScript(final String configureScriptPath,
			final String folderPathAsStr) throws Exception {
		final AntRunner runner = new AntRunner();
		runner.setMessageOutputLevel(Project.MSG_VERBOSE);
		runner.setBuildFileLocation(configureScriptPath);
		System.out.println("folderPathAsStr='" + folderPathAsStr + "'");
		final String buildLoggerName = "at.jku.weiner.kefax.ant.MyAntBuildLogger";
		System.out.println("buildLoggerName='" + buildLoggerName + "'");
		runner.addBuildLogger(buildLoggerName);
		// runner.setArguments("-verbose");
		// runner.setArguments("-Dmessage=Building -verbose");
		runner.run(this.getMonitor());
	}

}
