package at.jku.weiner.kefax.shared;

public final class MySettings {

	public static final String LINUX_OS_NAME_1 = "linux";
	public static final String LINUX_OS_NAME_2 = "Linux";

	public static final String LINUX_CHECKOUT_URL = "git://github.com/torvalds/linux.git";
	public static final String LINUX_CHECKOUT_BRANCH = "master";
	public static final String LINUX_CHECKOUT_PRJ = "kefax-linux-source";
	public static final String LINUX_CHECKOUT_DIR = "src";
	public static final String LINUX_CHECKOUT_CONFIG = ".config";
	public static final String LINUX_CHECKOUT_CONFIG_OLD = MySettings.LINUX_CHECKOUT_CONFIG
			+ ".old";
	
	public static final String LINUX_DISCOVER_PRJ = "kefax-linux-working";
	public static final String LINUX_DISCOVER_DIR = "src";
	public static final String LINUX_DISCOVER_CMD_OUT = "commands.cmd";

	public static final String LINUX_EXT4_SRC = "fs/ext4";
	
	public static final String LINUX_CONFIG_YES = "y";
	public static final String LINUX_CONFIG_MODULE = "m";

	public static final String MAKE_COMMAND = "make";
	public static final String MAKE_ARG_1 = "tinyconfig";
	public static final String MAKE_ARG_2 = "olddefconfig";
	/***
	 * other targets might be: all, modules, bzImage and many more
	 */
	public static final String MAKE_ARG_3 = "vmlinux";
	
	public static final String CONFIG_1 = "CONFIG_BLOCK=y";
	public static final String CONFIG_2 = "CONFIG_EXT4_FS=y";

	public static final String FEATURES_TXT_NAME = "features.txt";
	
	public static final String FEATURES_TXT_ARG_1 = "; ";
	public static final String FEATURES_TXT_ARG_2 = MySettings.FEATURES_TXT_ARG_1;
	public static final String FEATURES_TXT_ARG_3 = System.lineSeparator();
	
}
