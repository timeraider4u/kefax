package at.jku.weiner.kefax.shared;

public final class Settings {

	public static final String LINUX_OS_NAME_1 = "linux";
	public static final String LINUX_OS_NAME_2 = "Linux";

	public static final String LINUX_CHECKOUT_URL = "git://github.com/torvalds/linux.git";
	public static final String LINUX_CHECKOUT_BRANCH = "master";
	public static final String LINUX_CHECKOUT_PRJ = "kefax-linux-source";
	public static final String LINUX_CHECKOUT_DIR = "src";
	public static final String LINUX_CHECKOUT_CONFIG = ".config";

	public static final String MAKE_COMMAND = "make";
	public static final String MAKE_ARG1 = "tinyconfig";
	public static final String MAKE_ARG2 = "olddefconfig";

	public static final String CONFIG_1 = "CONFIG_BLOCK=y";
	public static final String CONFIG_2 = "CONFIG_EXT4_FS=y";

}
