package at.jku.weiner.c.preprocess.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public final class IncludeUtils {
	private final String URI_PREFIX = "file://";
	
	private final ResourceSet rs;
	private final String fileName;
	private final URI uri;
	
	private final boolean isAbsoluteInclude;
	private final String uriStr;
	
	public IncludeUtils(final ResourceSet set, final URI uri,
			final String fileName) {
		this.uri = uri;
		this.isAbsoluteInclude = this.isAbsoluteFileName(fileName);
		this.fileName = this.replace(fileName);
		this.rs = set;
		this.uriStr = this.uri.toFileString();
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
		// System.out.println("resource='" + uri + "'");
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
		if (this.fileName.startsWith(File.separator)) {
			return URI.createURI(this.URI_PREFIX + this.fileName);
		}
		final MyPath pathInURI = new MyPath(this.fileName);
		final List<String> includeDirs = IncludeDirs.getListCopy();
		for (final String include : includeDirs) {
			final MyPath pathInInclude = new MyPath(include);
			final String searchForFile = pathInInclude.combine(pathInURI);
			final File file = new File(searchForFile);
			// System.out.println("searchForFile='" + searchForFile + "'");
			// System.out.println("fileExists='" + file.exists() + "'");
			// System.out.println("canRead='" + file.canRead() + "'");
			if (file.exists() && file.canRead()) {
				return URI.createURI(this.URI_PREFIX + searchForFile);
			}
		}
		throw new RuntimeException("Absolute include file ('" + this.fileName
				+ "') not found in directories='" + includeDirs.toString()
				+ "'!");
	}
	
	private URI createRelativeURI() {
		// System.out.println(uriStr);
		final int index = this.uriStr.lastIndexOf(File.separator);
		if (index <= 0) {
			throw new IllegalArgumentException(
					"not a valid relative include fileName='" + this.uriStr
					+ "'");
		}
		final String path = this.uriStr.substring(0, index);
		final String newFileName = path + File.separator + this.fileName;
		// System.out.println(newFileName);
		return URI.createURI(newFileName);
	}
	
}
