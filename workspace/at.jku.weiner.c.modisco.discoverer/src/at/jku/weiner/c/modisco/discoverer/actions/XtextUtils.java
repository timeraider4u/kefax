package at.jku.weiner.c.modisco.discoverer.actions;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.common.ui.internal.CommonActivator;
import at.jku.weiner.c.modisco.discoverer.utils.MyStore;
import at.jku.weiner.c.modisco.discoverer.xtext.XtextHandler;
import at.jku.weiner.c.modisco.discoverer.xtext.XtextParser;
import at.jku.weiner.c.modisco.discoverer.xtext.XtextPreprocessor;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Parser;
import at.jku.weiner.c.parser.parser.ParserFactory;
import at.jku.weiner.c.preprocess.generator.PreprocessGenerator;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.utils.IncludeDirs;
import at.jku.weiner.c.preprocess.utils.macros.AdditionalPreprocessingDirectives;
import at.jku.weiner.c.preprocess.utils.macros.PredefinedMacros;

import com.google.inject.Injector;

public class XtextUtils {

	private final MyStore store;

	private final Injector commonInjector;
	private final XtextPreprocessor preprocessor;
	private final XtextParser parser;

	public XtextUtils(final MyStore store) {
		this.store = store;
		this.commonInjector = this.setupCommon();
		this.preprocessor = new XtextPreprocessor(store);
		this.parser = new XtextParser(store);
		this.setUpPredefinedMacros();
	}

	private Injector setupCommon() {
		MyLog.trace(XtextUtils.class, "setupCommon!");
		final CommonActivator activator = CommonActivator.getInstance();
		final Injector result = activator
				.getInjector(CommonActivator.AT_JKU_WEINER_C_COMMON_COMMON);
		return result;
	}

	private void setUpPredefinedMacros() {
		MyLog.trace(XtextUtils.class, "setup predefined macros!");
		final URI uri = PredefinedMacros.getPredefinedURI(false, this.store
				.getMySettings().isSetStdInclude());
		MyLog.trace(XtextUtils.class, "uri='" + uri + "'!");
		if (this.store.getMySettings().isBatchMode()) {
			// skip loading pre-defined macros if already in added to model
			// by previous discover call
			final String uriPath = uri.toString();
			final EList<TranslationUnit> units = this.store.getModel()
					.getUnits();
			for (final TranslationUnit unit : units) {
				final String unitPath = unit.getPath();
				if (uriPath.equals(unitPath)) {
					return;
				}
			}
		}

		MyLog.trace(XtextUtils.class, "PredefinedMacros.loadPreDefinedMacros!");
		final Preprocess preprocess = PredefinedMacros.loadPreDefinedMacros(
				false, this.store.getMySettings().isSetStdInclude());
		MyLog.trace(XtextUtils.class,
				"PredefinedMacros.loadPreDefinedMacros done!");
		final TranslationUnit predefined = this.store.getFactory()
				.createTranslationUnit();
		MyLog.trace(XtextUtils.class, "created translation unit!");
		MyLog.trace(XtextUtils.class, "predefined='" + predefined + "'");
		MyLog.trace(XtextUtils.class, "preprocess='" + preprocess + "'");

		predefined.setPreprocess(preprocess);
		MyLog.trace(XtextUtils.class, "setted pre-process to translation unit!");
		final String path = uri.toString();
		predefined.setPath(path);

		MyLog.trace(XtextUtils.class, "adding predefined to model!");
		this.store.getModel().getUnits().add(predefined);
		MyLog.trace(XtextUtils.class, "setUpPredefinedMacros done!");
	}

	public final void readFromXtextFile(final File file, final IFile iFile)
			throws Exception {
		// initialize ...
		MyLog.trace(XtextUtils.class, "starting readFromXtextFil!");

		this.cleanUp();
		final TranslationUnit unit = this.store.getFactory()
				.createTranslationUnit();
		final URI uri = URI.createURI(iFile.getLocationURI().toString());
		final String uriStr = uri.toFileString();
		unit.setPath(uriStr);
		this.store.getModel().getUnits().add(unit);
		// set-up additional preprocessing directives
		this.setUpAdditionalPreprocessingDirectives(unit);
		// preprocess
		final Preprocess preprocess = this.preprocessor.parseFile(file, iFile);
		unit.setPreprocess(preprocess);
		// generate intermediate
		final String fileNameOnly = this.getFilenameForIntermediate(uri);
		final String intermediate = this.generateIntermediateFile(iFile,
				fileNameOnly, unit);
		// parse
		final String output = this.preprocessor.getOutputPath(iFile)
				+ IPath.SEPARATOR;
		final String intermediateStr = output + intermediate;
		final File intermediateFile = new File(intermediateStr);
		final IFile iIntermediate = DiscovererUtils
				.getFileFor(intermediateFile);
		final Parser parser = this.parser.parseFile(intermediateFile,
				iIntermediate);
		final Parser secondParser = ParserFactory.eINSTANCE.createParser();
		unit.setParser(secondParser);
		MyLog.debug(XtextHandler.class, "copying to second parser!");
		if (parser != null) {
			final EList<ExternalDeclaration> list = parser.getExternal();
			if (list != null) {
				for (int i = list.size() - 1; i >= 0; i--) {
					MyLog.debug(XtextHandler.class, "handling of #'" + i
							+ "' of '" + list.size() + "'");
					final ExternalDeclaration dec = list.get(i);
					secondParser.getExternal().add(0, dec);
				}
			}
			MyLog.debug(XtextHandler.class, "setting second parser!");
		}
		
		MyLog.debug(XtextHandler.class, "readFromXtextFile done!");
	}

	private final String getFilenameForIntermediate(final URI uri) {
		final String fileExt = uri.fileExtension();
		final String lastSegment = uri.lastSegment();
		final int index = lastSegment.length() - fileExt.length() - 1;
		final String fileNameOnly = lastSegment.substring(0, index) + ".i";
		return fileNameOnly;
	}

	private final String generateIntermediateFile(final IFile iFile,
			final String fileNameOnly, final TranslationUnit unit)
			throws DiscoveryException {
		// configure and start the generator
		final URI whole = URI.createURI(iFile.getLocationURI().toString());
		final URI uri = whole.trimSegments(1);
		final String path = uri.path();
		final String wholeStr = path + File.separator + fileNameOnly;

		this.setUpIncludeDirs(path);
		final PreprocessGenerator preprocessGenerator = this.preprocessor
				.getGenerator();
		preprocessGenerator.setFileName(wholeStr);
		preprocessGenerator.setInsertPredefinedMacros(true);
		preprocessGenerator.setValidateUnit(true);
		preprocessGenerator.setUnit(unit);
		preprocessGenerator.setStdInclude(this.store.getMySettings()
				.isSetStdInclude());
		preprocessGenerator.setTrimPreprocessModel(this.store.getMySettings()
				.isTrimPreprocessModel());
		MyLog.trace(XtextUtils.class, "setStdInclude='"
				+ this.store.getMySettings().isSetStdInclude() + "'");
		preprocessGenerator.setAdditionalPreprocessingDirectives(this.store
				.getMySettings().getAdditionalDirectives());
		preprocessGenerator.setCommonInjector(this.commonInjector);
		// preprocessGenerator.insertPredefinedMacros(this.store.getModel());
		this.preprocessor.generate(iFile, fileNameOnly);
		return wholeStr;
	}

	private void setUpIncludeDirs(final String path) {
		String includeDirs = this.store.getMySettings().getIncludeDirs();
		MyLog.trace(XtextUtils.class, "includeDirs='" + includeDirs + "'");
		if (includeDirs == null) {
			includeDirs = "";
		}
		final String[] dirs = includeDirs.split(File.pathSeparator);
		for (final String dir : dirs) {
			MyLog.trace(XtextUtils.class, "addIncludeDirectoryToList='" + dir
					+ "'");
			IncludeDirs.addIncludeDirectoryToList(dir);
		}
		IncludeDirs.addIncludeDirectoryToList(path);
	}

	public void cleanUp() {
		IncludeDirs.clearAllIncludeDirectories();
	}

	private void setUpAdditionalPreprocessingDirectives(
			final TranslationUnit unit) throws IOException {
		final String additionalStr = this.store.getMySettings()
				.getAdditionalDirectives();
		if ((additionalStr == null) || additionalStr.isEmpty()) {
			return;
		}
		final Preprocess additional = AdditionalPreprocessingDirectives
				.getAdditionalDirectivesFor(additionalStr);
		unit.setAdditionalPreprocessingDirectives(additional);
	}

}
