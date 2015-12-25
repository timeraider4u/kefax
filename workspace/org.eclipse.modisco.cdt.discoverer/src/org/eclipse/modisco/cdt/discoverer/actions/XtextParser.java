package org.eclipse.modisco.cdt.discoverer.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import at.jku.weiner.c.common.ui.internal.CommonActivator;
import at.jku.weiner.c.parser.ui.internal.ParserActivator;
import at.jku.weiner.c.preprocess.generator.PreprocessGenerator;
import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.preprocess.ui.internal.PreprocessActivator;

import com.google.inject.Injector;

public class XtextParser {
	
	private final Injector preprocessInjector;
	private final IResourceValidator preprocessValidator;
	private final JavaIoFileSystemAccess preprocessfileAccessSystem;
	private final PreprocessGenerator preprocessGenerator;
	private final Injector commonInjector;
	private final Injector parserInjector;
	
	public XtextParser() {
		this.commonInjector = this.setupCommon();
		this.preprocessInjector = this.setupPreprocessor();
		this.preprocessValidator = this.preprocessInjector
				.getInstance(IResourceValidator.class);
		this.preprocessfileAccessSystem = this.preprocessInjector
				.getInstance(JavaIoFileSystemAccess.class);
		this.preprocessGenerator = this.preprocessInjector
				.getInstance(PreprocessGenerator.class);
		this.parserInjector = this.setupParser();
	}
	
	private Injector setupCommon() {
		final CommonActivator activator = CommonActivator.getInstance();
		final Injector result = activator
				.getInjector(CommonActivator.AT_JKU_WEINER_C_COMMON_COMMON);
		return result;
	}
	
	private Injector setupPreprocessor() {
		final PreprocessActivator activator = PreprocessActivator.getInstance();
		final Injector result = activator
				.getInjector(PreprocessActivator.AT_JKU_WEINER_C_PREPROCESS_PREPROCESS);
		return result;
	}
	
	private Injector setupParser() {
		final ParserActivator activator = ParserActivator.getInstance();
		final Injector result = activator
				.getInjector(ParserActivator.AT_JKU_WEINER_C_PARSER_PARSER);
		return result;
	}
	
	public final Model readFromXtextFile(final File file, final IFile iFile)
			throws IOException, DiscoveryException {
		final Resource resource = this.loadResource(file, iFile);
		System.out.println("get resource was successfull!");
		this.validateResource(resource);
		System.out.println("validation was successfull!");
		final EObject object = resource.getContents().get(0);
		System.out.println("get contents from resource was successfull!");
		if (object == null) {
			this.error("Returned object of file='" + file.getAbsolutePath()
					+ "' from XText is null!");
		}
		if (!(object instanceof Model)) {
			this.error("Returned object is not a C model - file='"
					+ file.getAbsolutePath() + "' (class='"
					+ object.getClass().getCanonicalName() + "') from XText!");
		}
		final Model model = (Model) object;
		System.out.println("XText parsing was successfuly for file='"
				+ file.toString() + "'!");
		// generate intermediate
		final URI uri = URI.createURI(iFile.getLocationURI().toString());
		final String fileExt = uri.fileExtension();
		final String lastSegment = uri.lastSegment();
		final int index = lastSegment.length() - fileExt.length() - 1;
		final String fileNameOnly = lastSegment.substring(0, index) + ".cdt.i";
		System.out.println("fileNameOnly='" + fileNameOnly + "'");
		this.generateIntermediateFile(resource, iFile, fileNameOnly);
		// return model
		return model;
	}
	
	private final void error(final String string) throws DiscoveryException {
		System.err.println(string);
		throw new DiscoveryException(string);
	}
	
	private final Resource loadResource(final File file, final IFile iFile)
			throws IOException, DiscoveryException {
		final IProject iProject = iFile.getProject();
		final XtextResourceSetProvider provider = this.preprocessInjector
				.getInstance(XtextResourceSetProvider.class);
		final XtextResourceSet resourceSet = (XtextResourceSet) provider
				.get(iProject);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,
				Boolean.TRUE);
		final URI uri = URI.createURI(iFile.getLocationURI().toString());
		final String uriStr = uri.toFileString();
		System.out.println("uri.toFileString()='" + uriStr + "'");
		System.out.println("uri.toString()='" + uri.toString() + "'");
		final Resource resource = resourceSet.getResource(uri, true);
		return resource;
	}
	
	private final void validateResource(final Resource resource)
			throws DiscoveryException {
		// validate the resource
		final List<Issue> list = this.preprocessValidator.validate(resource,
				CheckMode.ALL, CancelIndicator.NullImpl);
		if (!(list.isEmpty())) {
			final String uri = resource.getURI().toFileString();
			this.error("Errors found during validation for resource='" + uri
					+ "': " + list.toString());
		}
	}
	
	private final void generateIntermediateFile(final Resource resource,
			final IFile iFile, final String fileNameOnly)
					throws DiscoveryException {
		// configure and start the generator
		final URI whole = URI.createURI(iFile.getLocationURI().toString());
		final URI uri = whole.trimSegments(1);
		final String path = uri.path();
		final String wholeStr = path + File.separator + fileNameOnly;
		System.out.println("outputPath='" + path + "'");
		System.out.println("fileName='" + wholeStr + "'");
		this.preprocessfileAccessSystem.setOutputPath(path);
		this.preprocessGenerator.setFileName(wholeStr);
		this.preprocessGenerator.setInsertPredefinedMacros(true);
		this.preprocessGenerator.setValidateUnit(true);
		this.preprocessGenerator.setCommonInjector(this.commonInjector);
		this.preprocessGenerator.doGenerate(resource,
				this.preprocessfileAccessSystem);
	}
	
	private final void readFromXtextFileInternal(final File file)
			throws IOException, DiscoveryException {
		
		final String fileName = file.getAbsolutePath();
		System.out.println("Parsing .c file '" + fileName + "'!");
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource resource = resourceSet.createResource(URI
				.createURI("dummy:/example.config"));
		final InputStream in = new FileInputStream(file);
		resource.load(in, resourceSet.getLoadOptions());
		final EObject object = resource.getContents().get(0);
		if (object == null) {
			throw new DiscoveryException("Returned object of file='"
					+ file.getAbsolutePath() + "' from XText is null!");
		}
		if (!(object instanceof Model)) {
			System.out
					.println("object is not instance of C Model, object.class='"
							+ object.getClass().toString() + "'");
			return;
			// throw new DiscoveryException(
			// "Returned object is not a C model - file='"
			// + file.getAbsolutePath() + "' from XText!");
		}
		System.out.println("XText parsing was successfuly for file='"
				+ file.getAbsolutePath() + "'!");
		
	}
	
	/**
	 * Parses an input stream and returns the resulting object tree root
	 * element.
	 *
	 * @param in
	 *            Input Stream
	 * @return Root model object
	 * @throws IOException
	 *             When and I/O related parser error occurs
	 */
	/*
	 * public EObject parse(final InputStream in) throws IOException { Resource
	 * resource = this.resourceSet.createResource(URI
	 * .createURI("dummy:/inmemory.ext")); resource.load(in,
	 * this.resourceSet.getLoadOptions()); return resource.getContents().get(0);
	 * }
	 */
	
	/**
	 * Parses a resource specified by an URI and returns the resulting object
	 * tree root element.
	 *
	 * @param uri
	 *            URI of resource to be parsed
	 * @return Root model object
	 */
	/*
	 * public EObject parse(final URI uri) { Resource resource =
	 * this.resourceSet.getResource(uri, true); return
	 * resource.getContents().get(0); }
	 */
}
