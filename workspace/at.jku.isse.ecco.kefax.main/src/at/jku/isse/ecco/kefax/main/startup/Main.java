package at.jku.isse.ecco.kefax.main.startup;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.ui.IStartup;

import at.jku.isse.ecco.kefax.dotconfig.dotconfig.Config;

public class Main implements IStartup {

	@Override
	public void earlyStartup() {
		try {
			this.run();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	private void run() throws IOException {
		final File linuxSrcDir = Settings.DEFAULT_LINUX_DIR;
		final String linuxSrcDirPath = linuxSrcDir.getAbsolutePath();
		final File outDir = Settings.DEFAULT_OUT_DIR;
		if (outDir.exists()) {
			System.out.println("deleting existing directory '"
					+ Settings.DEFAULT_OUT + "'");
			outDir.delete();
			FileUtils.deleteDirectory(outDir);
		}
		outDir.mkdirs();
		if ((!outDir.isDirectory()) && (!outDir.canRead())) {
			throw new RuntimeException("Could not create '" + outDir + "'!");
		}
		final String outDirPath = outDir.getAbsolutePath();
		System.out.println("Using '" + linuxSrcDirPath
				+ "' as linux source directory!");
		System.out.println("Using '" + outDirPath + "' as output directory!");

		final File dotConfigFile = DotConfig.getDotConfigFile(linuxSrcDir,
				linuxSrcDirPath);
		final String dotConfig = dotConfigFile.getAbsolutePath();
		final List<Config> configs = DotConfig.parseDotConfig(dotConfigFile,
				dotConfig);
		final File featuresFile = new File(outDir + "/features.txt");
		final String featuresPath = featuresFile.getAbsolutePath();
		DotConfig.createFeaturesTxt(featuresFile, featuresPath, configs);
		final File defineFile = new File(outDir + "/defines.txt");
		final String defineFilePath = defineFile.getAbsolutePath();
		DotConfig.createDefineFile(defineFile, defineFilePath, configs);
		ReadLinuxBuildFilesLog.run();
	}

	@SuppressWarnings("unused")
	private static File parseLinuxSourceDir(final String[] args) {
		if ((args == null) || (args.length <= 0)) {
			return Settings.DEFAULT_LINUX_DIR;
		}
		final String dir = args[0];
		if (dir.isEmpty()) {
			return Settings.DEFAULT_LINUX_DIR;
		}
		final File srcDir = new File(dir);
		if ((!srcDir.isDirectory()) || (!srcDir.canRead())) {
			return Settings.DEFAULT_LINUX_DIR;
		}
		return srcDir;
	}

}
