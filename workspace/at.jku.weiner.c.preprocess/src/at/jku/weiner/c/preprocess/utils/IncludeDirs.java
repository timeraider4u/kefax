package at.jku.weiner.c.preprocess.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class IncludeDirs {

	private static final List<String> dirs = new ArrayList<String>();

	public static void setUp() {
		final String os = System.getProperty("os.name");
		// System.out.println("os2='" + os + "'");
		if (os.indexOf("win") >= 0) {

		} else {
			// is unix-like operating system
			// add GCC include dirs,
			// seehttps://gcc.gnu.org/onlinedocs/cpp/Search-Path.html#Search-Path
			IncludeDirs.addIncludeDirectoryToList("/usr/local/include");
			IncludeDirs.addIncludeDirectoryToList("/usr/target/include");
			IncludeDirs.addIncludeDirectoryToList("/usr/include");
		}
	}

	public static void clearAllIncludeDirectories() {
		IncludeDirs.dirs.clear();
	}

	public static void addIncludeDirectoryToList(final String path) {
		final File file = new File(path);
		if (file.exists()) {
			IncludeDirs.dirs.add(path);
		}
	}

	public static List<String> getListCopy() {
		return Collections.unmodifiableList(IncludeDirs.dirs);
	}

}
