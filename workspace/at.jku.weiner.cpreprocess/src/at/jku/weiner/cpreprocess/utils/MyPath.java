package at.jku.weiner.cpreprocess.utils;

import java.io.File;

public class MyPath {

	private final String path;
	private final String pathWithoutLastSlash;

	public MyPath(final String path) {
		this.path = path;
		this.pathWithoutLastSlash = this.internalGetPathWithoutLastSlash();
	}

	public String getPathWithoutTrailingSlash() {
		return this.pathWithoutLastSlash;
	}

	private String internalGetPathWithoutLastSlash() {
		if (this.path.endsWith(File.separator)) {
			return this.path.substring(0, this.path.length() - 1);
		}
		return this.path;
	}

	public String combine(final MyPath other) {
		return this.pathWithoutLastSlash + File.separator + other.path;
	}

}
