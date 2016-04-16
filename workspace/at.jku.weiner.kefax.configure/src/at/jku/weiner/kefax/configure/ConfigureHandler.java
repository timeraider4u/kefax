package at.jku.weiner.kefax.configure;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildLogger;
import org.apache.tools.ant.Project;
import org.eclipse.ant.core.AntRunner;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

import at.jku.weiner.kefax.shared.KefaxUtils;
import at.jku.weiner.kefax.shared.MyActionHandler;
import at.jku.weiner.kefax.shared.MyFileWriter;
import at.jku.weiner.kefax.shared.MyNotification;
import at.jku.weiner.kefax.shared.Settings;

@SuppressWarnings("unused")
public class ConfigureHandler extends MyActionHandler {

	private static final String ANT_SCRIPT_PATH = "configureScript/configureLinux.xml";
	
	public ConfigureHandler() {
		super("at.jku.weiner.kefax.configure.commandHandler");
	}
	
	@Override
	protected void myRun() throws Exception {
		final IProject project = KefaxUtils.getLinuxProject();
		project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());

		final IFile config = KefaxUtils.getLinuxConfigFile();
		final boolean configExists = config.exists();
		final String configPathAsStr = KefaxUtils.getURIasFileString(config);
		if (configExists) {
			final String msg = "resource '" + configPathAsStr
					+ "' already exists!" + " Exiting now with this command.";
			System.out.println(msg);
			MyNotification.run(".config already exists", msg);
			return;
		}
		
		final String src = KefaxUtils.getLinuxSrcFolderAsFilePath();
		final File workingDirectory = new File(src);
		final List<String> cmds = new ArrayList<String>();
		
		cmds.add(Settings.MAKE_COMMAND);
		cmds.add(Settings.MAKE_ARG1);
		if (!KefaxUtils.executeCommand(cmds, workingDirectory,
				this.getMonitor(), false)) {
			return;
		}
		project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
		if (!MyFileWriter
				.appendStringToFile(configPathAsStr, Settings.CONFIG_1)) {
			return;
		}
		project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
		
		if (!MyFileWriter
				.appendStringToFile(configPathAsStr, Settings.CONFIG_2)) {
			return;
		}
		project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
		cmds.clear();
		cmds.add(Settings.MAKE_COMMAND);
		cmds.add(Settings.MAKE_ARG2);
		if (!KefaxUtils.executeCommand(cmds, workingDirectory,
				this.getMonitor(), false)) {
			return;
		}
		project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
	}

	/**
	 * @see #invokeAntScript(String, String)
	 */
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
