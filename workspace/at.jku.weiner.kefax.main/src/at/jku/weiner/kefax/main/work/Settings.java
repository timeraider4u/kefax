package at.jku.weiner.kefax.main.work;

import java.io.File;

public final class Settings {
	public static final String TMP_WORK_DIR = "tmp-discover";
	protected static final String HOME = System.getProperty("user.home");
	protected static final String DEFAULT = Settings.HOME + "/Private";
	// protected static final String DEFAULT = "/home/harry/Private";
	// protected static final String DEFAULT_LINUX = "/usr/src/linux/";
	public static final String LINUX = "linux-3.18";
	protected static final String DEFAULT_LINUX = Settings.DEFAULT + "/"
			+ Settings.LINUX + "/";
	protected static final String DEFAULT_OUT = Settings.DEFAULT + "/out/";

	protected static final File DEFAULT_LINUX_DIR = new File(
			Settings.DEFAULT_LINUX);
	protected static final File DEFAULT_OUT_DIR = new File(Settings.DEFAULT_OUT);

	protected static final String PREFIX_SLASH = "/";
	protected static final String PREFIX_HPP = ".hpp";
	protected static final String PREFIX_CPP = ".cpp";
	protected static final String PREFIX_H = ".h";
	protected static final String PREFIX_C = ".c";
	protected static final String PREFIX_ASM = ".S";

	protected static final String PREFIX_INCLUDE = "-I";
	protected static final Object PREFIX_POINT = ".";
	protected static String[] PREFIX_EXTS = new String[] { Settings.PREFIX_HPP,
			Settings.PREFIX_CPP, Settings.PREFIX_H, Settings.PREFIX_C,
			Settings.PREFIX_ASM };

	protected static String FILE_NAME_KERNEL = Settings.DEFAULT
			+ "/gcc-call-kernel.dat";
	protected static String FILE_NAME_BZIMAGE = Settings.DEFAULT
			+ "/gcc-call-bzImage.dat";
	protected static String FILE_NAME_MODULES = Settings.DEFAULT
			+ "/gcc-call-modules.dat";

	protected static final String STR_UP_DIR_REPLACE = "/";
	protected static final String STR_UP_DIR_PATTERN = "/[^/]*/\\.\\./";
	protected static final String STR_UP_DIR_REPLACE_2 = "";
	protected static final String STR_UP_DIR_PATTERN_2 = "[^/]*/\\.\\./";

	private Settings() {
	}

}
