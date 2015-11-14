package at.jku.weiner.cpreprocess.generator;

import java.io.File;
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
	private final URI uri;

	private final boolean isAbsoluteInclude;

	public IncludeUtils(final ResourceSet set, final URI uri,
			final String fileName) {
		this.uri = uri;
		this.isAbsoluteInclude = this.isAbsoluteFileName(fileName);
		this.fileName = this.replace(fileName);
		this.rs = set;
	}

	private boolean isAbsoluteFileName(final String fileName) {
		if (fileName.startsWith("\"") && fileName.endsWith("\"")) {
			return false;
		}
		if (fileName.startsWith("<") && fileName.endsWith(">")) {
			return true;
		}
		throw new IllegalArgumentException("include fileName='" + fileName
				+ "' is not a valid path");
	}

	private String replace(final String fileName) {
		return fileName.substring(1, fileName.length() - 1);
	}

	public Resource getResource() throws IOException {
		// load the resource
		final ResourceSet set = this.rs; // this.resourceSetProvider.get();
		final URI uri = this.createURI();
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

	private URI createURI() {
		if (this.isAbsoluteInclude) {
			return this.createAbsoluteURI();
		}
		return this.createRelativeURI();
	}

	private URI createAbsoluteURI() {
		return null;
	}

	private URI createRelativeURI() {
		final String uriStr = this.uri.toFileString();
		// System.out.println(uriStr);
		final int index = uriStr.lastIndexOf(File.separator);
		if (index <= 0) {
			throw new IllegalArgumentException(
					"not a valid relative include fileName='" + uriStr + "'");
		}
		final String path = uriStr.substring(0, index);
		final String newFileName = path + File.separator + this.fileName;
		// System.out.println(newFileName);
		return URI.createURI(newFileName);
	}

}
