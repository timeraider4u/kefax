package org.eclipse.modisco.cdt.discoverer.actions;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.modisco.cdt.discoverer.utils.MyStore;
import org.eclipse.modisco.cdt.xtext.XtextParser;
import org.eclipse.modisco.cdt.xtext.XtextPreprocessor;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.common.ui.internal.CommonActivator;
import at.jku.weiner.c.parser.parser.Parser;
import at.jku.weiner.c.preprocess.generator.PreprocessGenerator;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
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
		final URI uri = PredefinedMacros.getPredefinedURI(false);
		final Preprocess preprocess = PredefinedMacros
				.loadPreDefinedMacros(false);
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
		final TranslationUnit unit = this.store.getFactory()
				.createTranslationUnit();
		final URI uri = URI.createURI(iFile.getLocationURI().toString());
		final String uriStr = uri.toFileString();
		unit.setPath(uriStr);
		this.store.getModel().getUnits().add(unit);
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
		// update project
		try {
			iFile.getProject().refreshLocal(IResource.DEPTH_INFINITE,
					this.store.getMonitor());
		} catch (final CoreException ex) {
			throw new DiscoveryException(ex);
		}
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

		final PreprocessGenerator preprocessGenerator = this.preprocessor
				.getGenerator();
		preprocessGenerator.setFileName(wholeStr);
		preprocessGenerator.setInsertPredefinedMacros(true);
		preprocessGenerator.setValidateUnit(true);
		preprocessGenerator.setUnit(unit);
		preprocessGenerator.setCommonInjector(this.commonInjector);
		// preprocessGenerator.insertPredefinedMacros(this.store.getModel());
		this.preprocessor.generate(iFile, fileNameOnly);
		return wholeStr;
	}

}
