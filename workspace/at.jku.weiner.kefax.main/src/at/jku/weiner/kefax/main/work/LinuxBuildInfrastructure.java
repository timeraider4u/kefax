package at.jku.weiner.kefax.main.work;

import java.io.File;
import java.io.IOException;

import at.jku.weiner.log.MyLog;

public class LinuxBuildInfrastructure {
	
	private static final String STR_CONFIG = ".config";
	private static final String STR_MAKEFILE = "Makefile";
	private static final String STR_INCLUDE_EXT = ".include";
	private static final String STR_SHELL_EXT = ".sh";
	private static final String STR_PL_EXT = ".pl";
	private static final String STR_ASM_EXT = ".S";
	private static final String STR_KCONFIG = "Kconfig";
	private static final String STR_KBUILD = "Kbuild";
	private static final String[] STR_DIRS = new String[] { "distro",
			"arch/x86/syscalls" };
	private static final String[] STR_FILES = new String[] {
		"arch/x86/lib/x86-opcode-map.txt",
		"arch/x86/tools/gen-insn-attr-x86.awk", "arch/x86/vdso/vdso.lds",
		"drivers/tty/vt/cp437.uni", "fs/exofs/Kbuild",
		"kernel/time/timeconst.bc", "lib/build_OID_registry",
		"scripts/mkcompile_h", "scripts/setlocalversion",
		"./scripts/mksysmap", "scripts/module-common.lds" };
	
	public static void copyInfrastructureFiles() throws IOException {
		final File src = new File("DEFAULT_LINUX");
		final File dst = new File("DEFAULT_OUT");
		LinuxBuildInfrastructure.copyFiles(src, dst);
		LinuxBuildInfrastructure.copyDirs();
		LinuxBuildInfrastructure.copyAdditionalFiles();
		MyLog.trace(LinuxBuildInfrastructure.class, "copy kconfig files");
		LinuxBuildInfrastructure.copyKbuildFiles(src, dst);
	}
	
	private static void copyFiles(final File src, final File dst)
			throws IOException {
		final File[] files = src.listFiles();
		for (final File file : files) {
			final String name = file.getName();
			final File target = new File(dst, name);
			if (file.isDirectory() && target.exists()) {
				LinuxBuildInfrastructure.copyFiles(file, target);
			} else if (name.equals(LinuxBuildInfrastructure.STR_CONFIG)) {
				LinuxBuildInfrastructure.copyFile(src, dst, name);
			} else if (name.endsWith(LinuxBuildInfrastructure.STR_INCLUDE_EXT)) {
				LinuxBuildInfrastructure.copyFile(src, dst, name);
			} else if (name.endsWith(LinuxBuildInfrastructure.STR_SHELL_EXT)) {
				LinuxBuildInfrastructure.copyFile(src, dst, name);
			} else if (name.endsWith(LinuxBuildInfrastructure.STR_PL_EXT)) {
				LinuxBuildInfrastructure.copyFile(src, dst, name);
			} else if (name.endsWith(LinuxBuildInfrastructure.STR_ASM_EXT)) {
				LinuxBuildInfrastructure.copyFile(src, dst, name);
			}
		}
	}
	
	private static void copyFile(final File src, final File dst,
			final String name) throws IOException {
		if (!src.exists()) {
			return;
		}
		final Copy copy = new Copy(src, dst, name);
		copy.copy();
	}
	
	private static void copyDirs() throws IOException {
		for (final String dir : LinuxBuildInfrastructure.STR_DIRS) {
			final Copy copy = new Copy("DEFAULT_LINUX" + "/" + dir,
					"DEFAULT_OUT" + "/" + dir);
			copy.copy();
		}
	}
	
	private static void copyAdditionalFiles() throws IOException {
		for (final String file : LinuxBuildInfrastructure.STR_FILES) {
			final Copy copy = new Copy("DEFAULT_LINUX" + "/" + file,
					"DEFAULT_OUT" + "/" + file);
			copy.copy();
		}
	}
	
	private static void copyKbuildFiles(final File src, final File dst)
			throws IOException {
		final File[] files = src.listFiles();
		for (final File file : files) {
			final String name = file.getName();
			if (file.isDirectory()) {
				LinuxBuildInfrastructure.copyKbuildFiles(file, new File(dst,
						name));
			} else if (name.startsWith(LinuxBuildInfrastructure.STR_KCONFIG)) {
				final Copy copy = new Copy(file, new File(dst, name));
				copy.copy();
			} else if (name.startsWith(LinuxBuildInfrastructure.STR_KBUILD)) {
				final Copy copy = new Copy(file, new File(dst, name));
				copy.copy();
				
			} else if (name.startsWith(LinuxBuildInfrastructure.STR_MAKEFILE)) {
				final Copy copy = new Copy(file, new File(dst, name));
				copy.copy();
			}
		}
	}
}
