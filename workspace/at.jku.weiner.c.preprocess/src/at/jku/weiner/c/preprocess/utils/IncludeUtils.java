package at.jku.weiner.c.preprocess.utils;

import java.io.File;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;

import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

public final class IncludeUtils {
	private static final String PREFIX = "file:";

	private final ResourceSet rs;
	private final String fileName;
	private final URI currUri;
	private final boolean includeNext;

	private enum PathState {
		Absolute, Relative, IncludeNext, Unresolved
	}

	private PathState pathState = PathState.Unresolved;

	public IncludeUtils(final ResourceSet set, final URI uri,
			final String fileName, final DefinitionTable definitionTable,
			final boolean includeNext) {
		this.rs = set;
		this.currUri = uri;
		this.includeNext = includeNext;
		String newFileName = fileName;
		this.pathState = this.initializePathState(newFileName, false);
		if (this.pathState == PathState.Unresolved) {
			newFileName = definitionTable.fullResolve(newFileName);
		}
		this.pathState = this.initializePathState(newFileName, true);
		MyLog.trace(IncludeUtils.class, "IncludeUtils state='" + this.pathState
				+ "', newFileName='" + newFileName + "'");
		this.fileName = this.replace(newFileName);
	}

	private PathState initializePathState(final String fileName,
			final boolean shouldBeResolved) {
		if (this.includeNext) {
			return PathState.IncludeNext;
		} else if (fileName.startsWith("\"") && fileName.endsWith("\"")) {
			return PathState.Relative;
		} else if (fileName.startsWith("<") && fileName.endsWith(">")) {
			return PathState.Absolute;
		} else if (!shouldBeResolved) {
			return PathState.Unresolved;
		}
		throw new IllegalArgumentException("include fileName='" + fileName
				+ "' is not a valid path");
	}

	private String replace(final String fileName) {
		return fileName.substring(1, fileName.length() - 1);
	}

	public Resource getResource() throws Exception {
		// load the resource
		final ResourceSet set = this.rs;
		final URI uri = this.createURI();
		MyLog.trace(IncludeUtils.class, "resource='" + uri + "'");
		final Resource resource = set.getResource(uri, true);
		return resource;
	}

	private URI createURI() throws Exception {
		if (this.pathState == PathState.Relative) {
			final URI uri = this.createRelativeURI();
			final String fileName = this.getFileName(uri);
			final File file = new File(fileName);
			if (file.canRead()) {
				return uri;
			}
		}
		return this.createAbsoluteURI();
	}

	private String getFileName(final URI uri) {
		final String str = uri.toFileString();
		final String str2 = str.replaceFirst(IncludeUtils.PREFIX, "");
		return str2;
	}

	private URI createRelativeURI() {
		final URI relative = URI.createFileURI(this.fileName);
		final URIConverter converter = this.rs.getURIConverter();
		final URI normalized = converter.normalize(this.currUri);
		final URI result = relative.resolve(normalized);
		return result;
	}

	private URI createAbsoluteURI() throws Exception {
		if (this.fileName.startsWith(File.separator)) {
			return URI.createFileURI(this.fileName);
		}
		final MyPath pathInURI = new MyPath(this.fileName);
		final List<String> includeDirs = IncludeDirs.getListCopy();
		for (final String include : includeDirs) {
			final URI uri = this.searchInDirectory(pathInURI, include);
			if (uri != null) {
				final String currFileStr = this.getFileName(this.currUri);
				final String uriFileStr = this.getFileName(uri);
				MyLog.trace(IncludeUtils.class, "currURI='" + currFileStr + "'");
				if (this.includeNext) {
					return uri;
				} else {
					return uri;
				}
			}
		}

		final RuntimeException ex = new RuntimeException(
				"Absolute include file ('" + this.fileName
						+ "') not found in directories='"
						+ includeDirs.toString() + "'!");
		MyLog.error(IncludeUtils.class, ex);
		return null;
	}

	private URI searchInDirectory(final MyPath pathInURI, final String include) {
		final MyPath pathInInclude = new MyPath(include);
		final String searchForFile = pathInInclude.combine(pathInURI);
		final File file = new File(searchForFile);
		MyLog.trace(IncludeUtils.class, "searchForFile='" + searchForFile + "'");
		MyLog.trace(IncludeUtils.class, "fileExists='" + file.exists() + "'");
		MyLog.trace(IncludeUtils.class, "canRead='" + file.canRead() + "'");
		if (file.exists() && file.canRead()) {
			return URI.createFileURI(searchForFile);
		}
		return null;
	}

}
