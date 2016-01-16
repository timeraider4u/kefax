package org.eclipse.modisco.cdt.xtext;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.modisco.cdt.discoverer.utils.MyStore;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import at.jku.weiner.c.parser.ui.internal.ParserActivator;
import at.jku.weiner.c.preprocess.ui.internal.PreprocessActivator;

import com.google.inject.Injector;

public abstract class XtextHandler<T> {

	public static Injector setupPreprocessor() {
		final PreprocessActivator activator = PreprocessActivator.getInstance();
		final Injector result = activator
				.getInjector(PreprocessActivator.AT_JKU_WEINER_C_PREPROCESS_PREPROCESS);
		return result;
	}

	public static Injector setupParser() {
		final ParserActivator activator = ParserActivator.getInstance();
		final Injector result = activator
				.getInjector(ParserActivator.AT_JKU_WEINER_C_PARSER_PARSER);
		return result;
	}

	protected final String[] fileExtensions;
	protected final MyStore store;
	private final Injector injector;
	private final IResourceFactory resourceFactory;
	private final IResourceValidator validator;
	private final JavaIoFileSystemAccess fileAccessSystem;
	protected final IGenerator generator;

	private Resource resource = null;

	public XtextHandler(final String[] fileExtensions, final MyStore store,
			final Injector injector) {
		this.fileExtensions = fileExtensions;
		this.injector = injector;
		this.store = store;
		this.resourceFactory = this.injector
				.getInstance(IResourceFactory.class);
		this.validator = this.injector.getInstance(IResourceValidator.class);
		this.fileAccessSystem = this.injector
				.getInstance(JavaIoFileSystemAccess.class);
		this.generator = this.injector.getInstance(IGenerator.class);
	}

	public final T parseFile(final File file, final IFile iFile)
			throws DiscoveryException {
		// set-up
		this.setUp(file, iFile);
		// load resource
		this.resource = this.loadResource(file, iFile);
		// System.out.println("get resource was successfull!");
		this.validateResource(this.resource);
		// System.out.println("validation was successfull!");
		final EObject object = this.resource.getContents().get(0);
		// System.out.println("get contents from resource was successfull!");
		if (object == null) {
			this.error("Returned object of file='" + file.getAbsolutePath()
					+ "' from XText is null!");
		}
		try {
			@SuppressWarnings("unchecked")
			final T result = (T) object;
			// System.out.println("XText parsing was successfuly for file='"
			// + file.toString() + "'!");
			this.parseFinalize(result);
			return result;
		} catch (final ClassCastException ignored) {
			this.error("Returned object is not a C model - file='"
					+ file.getAbsolutePath() + "' (class='"
					+ object.getClass().getCanonicalName() + "') from XText!");
		}
		// should never get here
		return null;
	}

	protected void setUp(final File file, final IFile iFile) {

	}

	private final void error(final String string) throws DiscoveryException {
		System.err.println(string);
		throw new DiscoveryException(string);
	}

	private final Resource loadResource(final File file, final IFile iFile)
			throws DiscoveryException {
		for (final String ext : this.fileExtensions) {
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					ext, this.resourceFactory);
		}
		final IProject iProject = iFile.getProject();
		final XtextResourceSetProvider provider = this.injector
				.getInstance(XtextResourceSetProvider.class);
		final XtextResourceSet resourceSet = (XtextResourceSet) provider
				.get(iProject);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,
				Boolean.TRUE);
		final URI uri = URI.createURI(iFile.getLocationURI().toString());
		// final String uriStr = uri.toFileString();
		// System.out.println("uri.toFileString()='" + uriStr + "'");
		// System.out.println("uri.toString()='" + uri.toString() + "'");
		final Resource resource = resourceSet.getResource(uri, true);
		return resource;
	}

	private final void validateResource(final Resource resource)
			throws DiscoveryException {
		// validate the resource
		final List<Issue> list = this.validator.validate(resource,
				CheckMode.ALL, CancelIndicator.NullImpl);
		if (!(list.isEmpty())) {
			final String uri = resource.getURI().toFileString();
			this.error("Errors found during validation for resource='" + uri
					+ "': " + list.toString());
		}
	}

	protected void parseFinalize(final T resource) {

	}

	public void generate(final IFile iFile, final String fileNameOnly)
			throws DiscoveryException {
		final String path = this.getOutputPath(iFile);
		// System.out.println("outputPath='" + path + "'");
		this.fileAccessSystem.setOutputPath(path);
		this.setUpGenerator();
		this.generator.doGenerate(this.resource, this.fileAccessSystem);
	}

	public abstract String getOutputPath(IFile iFile) throws DiscoveryException;

	protected abstract void setUpGenerator();

}
