package at.jku.weiner.c.preprocess.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class IncludeDirs {

	private static final List<String> dirs = new ArrayList<String>();

	public static void setUp() {
		final OSEnum os = OSUtils.getOS();
		switch (os) {
		case Linux:
			// is unix-like operating system
			// add GCC include dirs,
			// seehttps://gcc.gnu.org/onlinedocs/cpp/Search-Path.html#Search-Path
			IncludeDirs.addIncludeDirectoryToList("/usr/local/include");
			IncludeDirs.addIncludeDirectoryToList("/usr/target/include");
			IncludeDirs
					.addIncludeDirectoryToList("/usr/lib64/gcc/x86_64-pc-linux-gnu/4.9.3/include");
			IncludeDirs.addIncludeDirectoryToList("/usr/include");
			break;
		default:
			break;
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
