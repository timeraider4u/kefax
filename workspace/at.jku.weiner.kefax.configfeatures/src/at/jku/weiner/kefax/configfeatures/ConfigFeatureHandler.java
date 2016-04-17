package at.jku.weiner.kefax.configfeatures;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;

import at.jku.weiner.kefax.shared.KefaxUtils;
import at.jku.weiner.kefax.shared.MyActionHandler;
import at.jku.weiner.kefax.shared.MyNotification;
import at.jku.weiner.kefax.shared.Settings;

public class ConfigFeatureHandler extends MyActionHandler {

	public ConfigFeatureHandler() {
		super("at.jku.weiner.kefax.configfeatures");
	}

	@Override
	protected void myRun() throws Exception {
		final IProject project = KefaxUtils.getLinuxProject();
		final String src = KefaxUtils.getLinuxSrcFolderAsFilePath();
		final IFile config = KefaxUtils.getLinuxConfigFile();
		KefaxUtils.getLinuxSrcFolderAsFilePath();
		final String configPathAsString = KefaxUtils.getURIasFileString(config);

		project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
		final File featuresFile = new File(src, Settings.FEATURES_TXT_NAME);
		final DotConfig dotConfig = new DotConfig(config, configPathAsString,
				featuresFile);
		dotConfig.parseAndGenerateFeaturesTxt();
		project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
		MyNotification.run("Reading .config / features.txt generation done!",
				"Reading config file and generating features.txt"
						+ " has been successfull!");
	}
	
}
