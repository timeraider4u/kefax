package at.jku.weiner.cpreprocess.utils;

import java.io.File;

public class MyPath {

	private final String path;
	private final String pathWithoutLastSlash;
	private final int firstIndex;
	private final String firstPathElement;
	private final int lastIndex;
	private final String lastPathElement;

	public MyPath(final String path) {
		this.path = path;
		this.pathWithoutLastSlash = this.internalGetPathWithoutLastSlash();
		this.firstIndex = this.pathWithoutLastSlash.indexOf(File.separator);
		this.firstPathElement = this.internalGetFirstPathElement();
		this.lastIndex = this.pathWithoutLastSlash.lastIndexOf(File.separator);
		this.lastPathElement = this.internalGetLastPathElement();
	}

	private String internalGetPathWithoutLastSlash() {
		if (this.path.endsWith(File.separator)) {
			return this.path.substring(0, this.path.length() - 1);
		}
		return this.path;
	}

	private String internalGetFirstPathElement() {
		if (this.firstIndex < 0) {
			return this.pathWithoutLastSlash;
		}
		return this.pathWithoutLastSlash.substring(0, this.firstIndex);
	}

	private String internalGetLastPathElement() {
		if (this.lastIndex < 0) {
			return this.pathWithoutLastSlash;
		}
		return this.pathWithoutLastSlash.substring(this.lastIndex + 1,
				this.pathWithoutLastSlash.length());
	}

	public String getFirstPathElement() {
		return this.firstPathElement;
	}

	public String getLastPathElement() {
		return this.lastPathElement;
	}

	public boolean compareTo(final MyPath other) {
		return this.lastPathElement.equals(other.firstPathElement);
	}

	public String combine(final MyPath other) {
		final String otherStr = other.pathWithoutLastSlash.substring(
				other.firstIndex + 1, other.pathWithoutLastSlash.length());
		return this.pathWithoutLastSlash + File.separator + otherStr;
	}
}
