package at.jku.weiner.c.preprocess.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class IncludeDirs {
	
	private static final List<String> dirs = new ArrayList<String>();
	
	public static void setUp() {
		// is unix-like operating system
		// add GCC include dirs,
		// seehttps://gcc.gnu.org/onlinedocs/cpp/Search-Path.html#Search-Path
		IncludeDirs.addIncludeDirectoryToList("/usr/local/include");
		IncludeDirs.addIncludeDirectoryToList("/usr/target/include");
		IncludeDirs
		.addIncludeDirectoryToList("/usr/lib64/gcc/x86_64-pc-linux-gnu/4.9.3/include");
		IncludeDirs.addIncludeDirectoryToList("/usr/include");
		
	}
	
	public static void clearAllIncludeDirectories() {
		IncludeDirs.dirs.clear();
	}
	
	public static void addIncludeDirectoryToList(final String path) {
		final File file = new File(path);
		if (file.exists() && (!(IncludeDirs.dirs.contains(path)))) {
			IncludeDirs.dirs.add(path);
		}
	}
	
	public static List<String> getListCopy() {
		final ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < IncludeDirs.dirs.size(); i++) {
			result.add(IncludeDirs.dirs.get(i));
		}
		// return Collections.unmodifiableList(IncludeDirs.dirs);
		return result;
	}
	
}
