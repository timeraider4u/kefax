package at.jku.weiner.c.modisco.discoverer.actions;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.common.ui.internal.CommonActivator;
import at.jku.weiner.c.modisco.discoverer.utils.MyStore;
import at.jku.weiner.c.modisco.discoverer.xtext.XtextParser;
import at.jku.weiner.c.modisco.discoverer.xtext.XtextPreprocessor;
import at.jku.weiner.c.parser.parser.Parser;
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
		final CommonActivator activator = CommonActivator.getInstance();
		final Injector result = activator
				.getInjector(CommonActivator.AT_JKU_WEINER_C_COMMON_COMMON);
		return result;
	}
	
	private void setUpPredefinedMacros() {
		final URI uri = PredefinedMacros.getPredefinedURI(false,
				this.store.isStdInclude());
		final Preprocess preprocess = PredefinedMacros.loadPreDefinedMacros(
				false, this.store.isStdInclude());
		final TranslationUnit predefined = this.store.getFactory()
				.createTranslationUnit();
		predefined.setPreprocess(preprocess);
		final String path = uri.toString();
		predefined.setPath(path);
		this.store.getModel().getUnits().add(predefined);
	}
	
	public final void readFromXtextFile(final File file, final IFile iFile)
			throws IOException, DiscoveryException {
		// initialize ...
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
		unit.setParser(parser);
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
		
		this.setUpIncludeDirs();
		final PreprocessGenerator preprocessGenerator = this.preprocessor
				.getGenerator();
		preprocessGenerator.setFileName(wholeStr);
		preprocessGenerator.setInsertPredefinedMacros(true);
		preprocessGenerator.setValidateUnit(true);
		preprocessGenerator.setUnit(unit);
		preprocessGenerator.setStdInclude(this.store.isStdInclude());
		preprocessGenerator.setTrimPreprocessModel(this.store
				.isTrimPreprocessModel());
		// System.out.println("setStdInclude='" + this.store.isStdInclude() +
		// "'");
		preprocessGenerator.setAdditionalPreprocessingDirectives(this.store
				.getAdditionalPreprocessingDirectives());
		preprocessGenerator.setCommonInjector(this.commonInjector);
		// preprocessGenerator.insertPredefinedMacros(this.store.getModel());
		this.preprocessor.generate(iFile, fileNameOnly);
		return wholeStr;
	}
	
	private void setUpIncludeDirs() {
		final String includeDirs = this.store.getIncludeDirs();
		// System.out.println("includeDirs='" + includeDirs + "'");
		if ((includeDirs == null) || includeDirs.isEmpty()) {
			return;
		}
		final String[] dirs = includeDirs.split(File.pathSeparator);
		for (final String dir : dirs) {
			// System.out.println("addIncludeDirectoryToList='" + dir + "'");
			IncludeDirs.addIncludeDirectoryToList(dir);
		}
	}
	
	public void cleanUp() {
		IncludeDirs.clearAllIncludeDirectories();
	}
	
	private void setUpAdditionalPreprocessingDirectives(
			final TranslationUnit unit) throws IOException {
		final String additionalStr = this.store
				.getAdditionalPreprocessingDirectives();
		if ((additionalStr == null) || additionalStr.isEmpty()) {
			return;
		}
		final Preprocess additional = AdditionalPreprocessingDirectives
				.getAdditionalDirectivesFor(additionalStr);
		unit.setAdditionalPreprocessingDirectives(additional);
	}
	
}