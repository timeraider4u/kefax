package at.jku.weiner.c.preprocess.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;

import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

public final class IncludeUtils {
	private final String URI_PREFIX = "file://";

	private final ResourceSet rs;
	private final String fileName;
	private final URI uri;
	private final String currentURIString;

	private PathState pathState = PathState.Unresolved;

	// private final String uriStr;
	private enum PathState {
		Absolute, Relative, Unresolved
	}

	public IncludeUtils(final ResourceSet set, final URI uri,
			final String fileName) {
		String newFileName = fileName;
		this.pathState = this.initializePathState(newFileName, false);
		if (this.pathState == PathState.Unresolved) {
			newFileName = DefinitionTable.fullResolve(newFileName);
		}
		this.pathState = this.initializePathState(newFileName, true);
		this.fileName = this.replace(newFileName);
		this.rs = set;
		this.uri = uri;
		this.currentURIString = uri.toFileString();
		// this.uriStr = this.uri.toFileString();
	}

	private PathState initializePathState(final String fileName,
			final boolean shouldBeResolved) {
		if (fileName.startsWith("\"") && fileName.endsWith("\"")) {
			return PathState.Relative;
		}
		if (fileName.startsWith("<") && fileName.endsWith(">")) {
			return PathState.Absolute;
		}
		if (!shouldBeResolved) {
			return PathState.Unresolved;
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
		MyLog.debug("resource='" + uri + "'");
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
		if (this.pathState == PathState.Relative) {
			final URI uri = this.createRelativeURI();
			final String str = uri.toFileString();
			final String str2 = str.replaceFirst("file:", "");
			final File file = new File(str2);
			if (file.canRead()) {
				return uri;
			}
		}
		return this.createAbsoluteURI();
	}
	
	private URI createAbsoluteURI() {
		if (this.fileName.startsWith(File.separator)) {
			return URI.createFileURI(this.fileName);
		}
		final MyPath pathInURI = new MyPath(this.fileName);
		final List<String> includeDirs = IncludeDirs.getListCopy();
		for (final String include : includeDirs) {
			final MyPath pathInInclude = new MyPath(include);
			final String searchForFile = pathInInclude.combine(pathInURI);
			final File file = new File(searchForFile);
			MyLog.debug("searchForFile='" + searchForFile + "'");
			MyLog.debug("fileExists='" + file.exists() + "'");
			MyLog.debug("canRead='" + file.canRead() + "'");
			if (file.exists() && file.canRead()) {
				return URI.createFileURI(searchForFile);
			}
		}
		throw new RuntimeException("Absolute include file ('" + this.fileName
				+ "') not found in directories='" + includeDirs.toString()
				+ "'!");
	}
	
	private URI createRelativeURI() {
		final URI relative = URI.createFileURI(this.fileName);
		final URIConverter converter = this.rs.getURIConverter();
		final URI normalized = converter.normalize(this.uri);
		final URI result = relative.resolve(normalized);
		return result;
	}
	
}
