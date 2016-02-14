package at.jku.weiner.kefax.main.work;

import java.io.File;

public final class Settings {
	public static final String TMP_WORK_DIR = "tmp-discover";
	public static final String HOME = System.getProperty("user.home");
	public static final String DEFAULT = Settings.HOME + "/Private";
	// protected static final String DEFAULT = "/home/harry/Private";
	// protected static final String DEFAULT_LINUX = "/usr/src/linux/";
	public static final String LINUX = "linux-3.18";
	public static final String DEFAULT_LINUX = Settings.DEFAULT + "/"
			+ Settings.LINUX + "/";
	public static final String DEFAULT_OUT = Settings.DEFAULT + "/out/";
	
	public static final File DEFAULT_LINUX_DIR = new File(
			Settings.DEFAULT_LINUX);
	public static final File DEFAULT_OUT_DIR = new File(Settings.DEFAULT_OUT);
	
	public static final String PREFIX_SLASH = "/";
	public static final String PREFIX_HPP = ".hpp";
	public static final String PREFIX_CPP = ".cpp";
	public static final String PREFIX_H = ".h";
	public static final String PREFIX_C = ".c";
	public static final String PREFIX_ASM = ".S";
	
	public static final String PREFIX_INCLUDE = "-I";
	public static final Object PREFIX_POINT = ".";
	public static String[] PREFIX_EXTS = new String[] { Settings.PREFIX_HPP,
		Settings.PREFIX_CPP, Settings.PREFIX_H, Settings.PREFIX_C,
		Settings.PREFIX_ASM };
	
	public static String FILE_NAME_KERNEL = Settings.DEFAULT
			+ "/gcc-call-kernel.dat";
	public static String FILE_NAME_BZIMAGE = Settings.DEFAULT
			+ "/gcc-call-bzImage.dat";
	public static String FILE_NAME_MODULES = Settings.DEFAULT
			+ "/gcc-call-modules.dat";
	
	public static final String STR_UP_DIR_REPLACE = "/";
	public static final String STR_UP_DIR_PATTERN = "/[^/]*/\\.\\./";
	public static final String STR_UP_DIR_REPLACE_2 = "";
	public static final String STR_UP_DIR_PATTERN_2 = "[^/]*/\\.\\./";
	
	private Settings() {
	}
	
}
