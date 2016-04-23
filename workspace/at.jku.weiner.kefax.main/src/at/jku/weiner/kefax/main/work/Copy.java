package at.jku.weiner.kefax.main.work;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import at.jku.weiner.log.MyLog;

public class Copy {
	private final File src;
	private final File dst;
	private final Path srcPath;
	private final Path dstPath;
	
	public Copy(final String src, final String dst) {
		this(new File(src), new File(dst));
	}
	
	public Copy(final File src, final File dst, final String name) {
		this(new File(src, name), new File(dst, name));
	}
	
	public Copy(final File src, final File dst) {
		this.src = src;
		this.dst = dst;
		this.srcPath = src.toPath();
		this.dstPath = dst.toPath();
	}
	
	/*
	 * public void copyAndContinue() { try { this.copy(); } catch (IOException
	 * e) { System.err.println("copying of file '" + this.srcPath + "' to dst='"
	 * + this.dst + "' failed!"); } }
	 */
	
	public void copy() throws IOException {
		this.dst.getParentFile().mkdirs();
		if (this.src.isDirectory()) {
			MyLog.debug(CmdArgs.class, "copy dir-src='" + this.src
					+ "' to dir-dst='" + this.dst + "'");
			final File[] files = this.src.listFiles();
			this.dst.mkdirs();
			for (final File file : files) {
				final Copy copy = new Copy(file, new File(this.dst,
						file.getName()));
				copy.copy();
			}
		} else {
			MyLog.debug(CmdArgs.class, "copy src='" + this.src + "' to dst='"
					+ this.dst + "'");
			final String name = this.src.getName();
			if (name.endsWith(".dwo")) {
				return;
			}
			if (name.endsWith(".o")) {
				return;
			}
			Files.copy(this.srcPath, this.dstPath, new CopyOption[] {
					StandardCopyOption.COPY_ATTRIBUTES,
					StandardCopyOption.REPLACE_EXISTING });
		}
	}
}
