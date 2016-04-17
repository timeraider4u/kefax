package at.jku.weiner.kefax.configfeatures;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Injector;

import at.jku.weiner.log.MyLog;
import at.jku.weiner.xtext.XtextUtils;
import at.jku.weiner.kefax.dotconfig.dotconfig.Config;
import at.jku.weiner.kefax.dotconfig.dotconfig.DotConfigModel;
import at.jku.weiner.kefax.dotconfig.ui.internal.DotconfigActivator;
import at.jku.weiner.kefax.shared.Settings;

public class DotConfig {

	private final IFile iConfigLFile;
	private final String configPathAsString;
	private final File featuresFile;
	private final String featuresFileName;
	private EList<Config> dotConfigList;

	public DotConfig(final IFile iConfigLFile, final String configPathAsString,
			final File featuresFile) {
		this.iConfigLFile = iConfigLFile;
		this.configPathAsString = configPathAsString;
		this.featuresFile = featuresFile;
		this.featuresFileName = featuresFile.getAbsolutePath();
		this.dotConfigList = null;
	}

	public void parseAndGenerateFeaturesTxt() throws Exception {
		this.dotConfigList = null;
		try {
			this.parseDotConfigInteral();
			this.createFeaturesTxtInternal();
		} catch (final Exception ex) {
			MyLog.error(DotConfig.class, ex);
		}
	}
	
	/***
	 * see http://wiki.eclipse.org/Xtext/FAQ#
	 * How_do_I_load_my_model_in_a_standalone_Java_application.C2.A0.3F for
	 * details
	 */
	private void parseDotConfigInteral() throws Exception {
		MyLog.log(DotConfig.class, "Parsing .config file '"
				+ this.configPathAsString + "'!");
		final String languageName = DotconfigActivator.AT_JKU_WEINER_KEFAX_DOTCONFIG_DOTCONFIG;
		final DotconfigActivator activator = DotconfigActivator.getInstance();
		if (activator == null) {
			final Exception ex = new NullPointerException("activator is null!");
			MyLog.error(DotConfig.class, ex);
		}
		final Injector injector = activator.getInjector(languageName);
		if (injector == null) {
			final Exception ex = new NullPointerException("injector is null!");
			MyLog.error(DotConfig.class, ex);
		}
		// final ResourceSet resourceSet = new ResourceSetImpl();
		// final Resource resource = resourceSet.createResource(URI
		// .createURI("dummy:/example.config"));
		// final InputStream in = new FileInputStream(this.dotConfigFile);
		// resource.load(in, resourceSet.getLoadOptions());
		final Resource resource = XtextUtils.loadResource(this.iConfigLFile,
				injector, "config");
		if (resource == null) {
			final Exception ex = new NullPointerException("resource is null!");
			MyLog.error(DotConfig.class, ex);
		}
		final DotConfigModel model = (DotConfigModel) resource.getContents()
				.get(0);
		if (model == null) {
			final Exception ex = new NullPointerException("model is null!");
			MyLog.error(DotConfig.class, ex);
		}
		this.dotConfigList = model.getConfigs();
		if ((this.dotConfigList == null) || this.dotConfigList.isEmpty()) {
			final ParseException ex = new ParseException("DotConfigList for '"
					+ this.configPathAsString + "' could not be parsed!", 0);
			MyLog.error(DotConfig.class, ex);
		}
	}
	
	private void createFeaturesTxtInternal() throws Exception {
		MyLog.log(DotConfig.class, "Creating features.txt as '"
				+ this.featuresFileName + "'");
		this.featuresFile.delete();
		this.featuresFile.createNewFile();
		final FileWriter writer = new FileWriter(this.featuresFile);
		final BufferedWriter output = new BufferedWriter(writer);
		for (final Config config : this.dotConfigList) {
			final String configName = config.getName();
			final String configValue = config.getV();
			if ((Settings.LINUX_CONFIG_YES.equals(configValue))
					|| (Settings.LINUX_CONFIG_MODULE.equals(configValue))) {
				output.write(configName);
				output.write(Settings.FEATURES_TXT_ARG_1);
				output.write(Settings.FEATURES_TXT_ARG_2);
				output.write(Settings.FEATURES_TXT_ARG_3);
			}
		}
		output.close();
	}

	@SuppressWarnings("unused")
	private void createDefineFile(final File defineFile,
			final String defineFilePath) throws Exception {
		MyLog.log(DotConfig.class, "Creating define file as '" + defineFilePath
				+ "'");
		defineFile.delete();
		defineFile.createNewFile();
		final FileWriter writer = new FileWriter(defineFile);
		final BufferedWriter output = new BufferedWriter(writer);
		for (final Config config : this.dotConfigList) {
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
