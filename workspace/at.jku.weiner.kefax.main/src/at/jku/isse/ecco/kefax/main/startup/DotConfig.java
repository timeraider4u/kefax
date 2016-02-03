package at.jku.isse.ecco.kefax.main.startup;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import at.jku.isse.ecco.kefax.dotconfig.dotconfig.Config;
import at.jku.isse.ecco.kefax.dotconfig.dotconfig.DotConfigModel;

public class DotConfig {

	private static final FilenameFilter DOT_CONFIG_FILTER = new FilenameFilter() {

		@Override
		public boolean accept(final File dir, final String name) {
			if (name.equals(".config")) {
				return true;
			}
			return false;
		}
	};

	protected static File getDotConfigFile(final File linuxSrcDir,
			final String linuxSrcDirPath) {
		final File[] dotConfigFiles = linuxSrcDir
				.listFiles(DotConfig.DOT_CONFIG_FILTER);
		if (dotConfigFiles.length <= 0) {
			throw new IllegalArgumentException("No .config file found in '"
					+ linuxSrcDirPath + "'");
		}
		if (dotConfigFiles.length > 1) {
			throw new IllegalArgumentException(
					"More than one .config file found in '" + linuxSrcDirPath
					+ "'");
		}
		return dotConfigFiles[0];
	}

	protected static List<Config> parseDotConfig(final File dotConfigFile,
			final String dotConfig) {
		try {
			return DotConfig.parseDotConfigInteral(dotConfigFile, dotConfig);
		} catch (final IOException e) {
			throw new RuntimeException("could not parse .config file '"
					+ dotConfig + "'!");
		}
	}

	/***
	 * see http://wiki.eclipse.org/Xtext/FAQ#
	 * How_do_I_load_my_model_in_a_standalone_Java_application.C2.A0.3F for
	 * details
	 */
	private static List<Config> parseDotConfigInteral(final File dotConfigFile,
			final String dotConfig) throws IOException {
		System.out.println("Parsing .config file '" + dotConfig + "'!");
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource resource = resourceSet.createResource(URI
				.createURI("dummy:/example.config"));
		final InputStream in = new FileInputStream(dotConfigFile);
		resource.load(in, resourceSet.getLoadOptions());
		final DotConfigModel model = (DotConfigModel) resource.getContents()
				.get(0);
		final EList<Config> configs = model.getConfigs();
		final List<Config> resultList = new ArrayList<Config>();
		for (final Config config : configs) {
			resultList.add(config);
		}
		return resultList;
	}

	protected static void createFeaturesTxt(final File featuresFile,
			final String features, final List<Config> configs) {
		try {
			DotConfig
			.createFeaturesTxtInternal(featuresFile, features, configs);
		} catch (final IOException e) {
			throw new RuntimeException("Could not create features.txt as '"
					+ features + "'");
		}
	}

	private static void createFeaturesTxtInternal(final File featuresFile,
			final String features, final List<Config> configs)
					throws IOException {
		System.out.println("Creating features.txt as '" + features + "'");
		featuresFile.delete();
		featuresFile.createNewFile();
		final FileWriter writer = new FileWriter(featuresFile);
		final BufferedWriter output = new BufferedWriter(writer);
		for (final Config config : configs) {
			final String configName = config.getName();
			final String configValue = config.getV();
			if (("y".equals(configValue)) || ("m".equals(configValue))) {
				output.write(configName);
				output.write("; ");
				output.write("; ");
				output.write("\n");
			}
		}
		output.close();
	}

	public static void createDefineFile(final File defineFile,
			final String defineFilePath, final List<Config> configs)
					throws IOException {
		System.out.println("Creating define file as '" + defineFilePath + "'");
		defineFile.delete();
		defineFile.createNewFile();
		final FileWriter writer = new FileWriter(defineFile);
		final BufferedWriter output = new BufferedWriter(writer);
		for (final Config config : configs) {
			final String configName = config.getName();
			final String configValue = config.getV();
			if (configValue != null) {
				output.write("#define ");
				output.write(configName);
				output.write(" ");
				output.write(configValue);
				output.write("\n");
			}
		}
		output.close();

	}
}
