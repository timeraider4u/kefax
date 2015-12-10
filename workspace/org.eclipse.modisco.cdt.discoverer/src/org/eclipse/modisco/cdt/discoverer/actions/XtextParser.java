package org.eclipse.modisco.cdt.discoverer.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import at.jku.weiner.c.parser.parser.Model;
import at.jku.weiner.c.parser.ui.internal.ParserActivator;

import com.google.inject.Injector;

public class XtextParser {

	private final Injector injector;

	public XtextParser() {
		final ParserActivator activator = ParserActivator.getInstance();
		this.injector = activator
				.getInjector(ParserActivator.AT_JKU_WEINER_C_PARSER_PARSER);
		// "at.jku.weiner.c.C");
		// this.setupParser();
	}

	private void setupParser() {
		// new org.eclipse.emf.mwe.utils.StandaloneSetup()
		// .setPlatformUri("http://www.jku.at/weiner/c/C");
		ParserActivator.getInstance().getInjector("at.jku.weiner.c.C")
		.injectMembers(this);
	}

	public final Model readFromXtextFile(final File file, final IFile iFile)
			throws IOException, DiscoveryException {
		// this.readFromXtextFileInternal(file);
		final XtextResourceSet resourceSet = (XtextResourceSet) this.injector
				.getInstance(XtextResourceSetProvider.class).get(
						iFile.getProject());
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,
				Boolean.TRUE);
		final URI uri = URI.createURI(iFile.getLocationURI().toString());
		final String uriStr = uri.toFileString();
		System.out.println("uri.toFileString()='" + uriStr + "'");
		System.out.println("uri.toString()='" + uri.toString() + "'");
		final Resource resource = resourceSet.getResource(uri, true);
		System.out.println("get resource was successfull!");
		final EObject object = resource.getContents().get(0);
		System.out.println("get contents from resource was successfull!");
		final Model model = (Model) object;
		if (object == null) {
			System.err.println("Returned object of file='"
					+ file.getAbsolutePath() + "' from XText is null!");
			throw new DiscoveryException("Returned object of file='"
					+ file.getAbsolutePath() + "' from XText is null!");
		}
		if (!(object instanceof Model)) {
			System.err.println("Returned object is not a C model - file='"
					+ file.getAbsolutePath() + "' from XText!");
			throw new DiscoveryException(
					"Returned object is not a C model - file='"
							+ file.getAbsolutePath() + "' from XText!");
		}
		System.out.println("XText parsing was successfuly for file='"
				+ file.toString() + "'!");
		return model;
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
