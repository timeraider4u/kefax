package at.jku.weiner.cpreprocess.generator;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import at.jku.weiner.cpreprocess.CPreprocessRuntimeModule;
import at.jku.weiner.cpreprocess.validation.CPreprocessValidator;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public final class IncludeUtils {

	private final ResourceSet rs;
	private final String fileName;

	// @Inject
	// private IResourceValidator validator;

	public IncludeUtils(final ResourceSet set, final String fileName) {
		this.fileName = fileName.replace("\"", "");
		this.rs = set;
		// this.validator = new CPreprocessValidator();
	}

	public Resource getResource() throws IOException {
		// load the resource
		final ResourceSet set = this.rs; // this.resourceSetProvider.get();
		final URI uri = URI.createURI(this.fileName);
		final Resource resource = set.getResource(uri, true);
		// validate the resource
		// final List<Issue> list = this.validator.validate(resource,
		// CheckMode.ALL, CancelIndicator.NullImpl);
		// if (list.isEmpty()) {
		// throw new ParseException("Could not parse include file '"
		// + this.fileName + "'");
		// }
		return resource;
	}

	IncludeUtils(final String string) {
		throw new UnsupportedOperationException(
				"TODO: auto-generated method stub");
	}

}
