package at.jku.weiner.cpreprocess.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class IncludeDirs {

	private static final List<String> dirs = new ArrayList<String>();

	public static void clearAllIncludeDirectories() {
		IncludeDirs.dirs.clear();
	}

	public static void addIncludeDirectoryToList(final String path) {
		IncludeDirs.dirs.add(path);
	}

	public static List<String> getListCopy() {
		return Collections.unmodifiableList(IncludeDirs.dirs);
	}

}
