package at.jku.weiner.kefax.main.work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import at.jku.weiner.log.MyLog;

public class ReadLinuxBuildFilesLog {
	
	private static List<String> includeDirs = new ArrayList<String>();
	private static List<String> sourceFiles = new CopyOnWriteArrayList<String>();
	
	public static void run() throws IOException {
		ReadLinuxBuildFilesLog.parseAll(Settings.FILE_NAME_KERNEL);
		MyLog.debug(ReadLinuxBuildFilesLog.class,
				"Parsing kernel-build-log completed!");
		ReadLinuxBuildFilesLog.parseAll(Settings.FILE_NAME_BZIMAGE);
		MyLog.debug(ReadLinuxBuildFilesLog.class,
				"Parsing bzImage-build-log completed!");
		ReadLinuxBuildFilesLog.parseAll(Settings.FILE_NAME_MODULES);
		MyLog.debug(ReadLinuxBuildFilesLog.class,
				"Parsing modules-build-log completed!");
		ReadLinuxBuildFilesLog.copyIncludeDirs();
		ReadLinuxBuildFilesLog.copySourceFiles();
		MyLog.debug(ReadLinuxBuildFilesLog.class,
				"copying infrastructure files");
		LinuxBuildInfrastructure.copyInfrastructureFiles();
		MyLog.debug(ReadLinuxBuildFilesLog.class, "done!");
	}
	
	private static void parseAll(final String fileName) {
		try {
			final List<String> lines = ReadLinuxBuildFilesLog
					.readFile(fileName);
			ReadLinuxBuildFilesLog.parseLines(lines);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
	
	private static List<String> readFile(final String fileName)
			throws IOException {
		MyLog.trace(ReadLinuxBuildFilesLog.class, "Parsing buildfiles-log '"
				+ fileName + "'");
		final List<String> result = new ArrayList<String>();
		final BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			String line;
			while ((line = br.readLine()) != null) {
				result.add(line);
			}
		} finally {
			br.close();
		}
		return result;
	}
	
	private static void parseLines(final List<String> lines) {
		for (final String line : lines) {
			final String[] words = line.split(" ");
			for (final String word : words) {
				ReadLinuxBuildFilesLog.parseWord(word);
			}
		}
	}
	
	private static void parseWord(final String word) {
		if (word.startsWith(Settings.PREFIX_INCLUDE)) {
			ReadLinuxBuildFilesLog.handleIncludeDir(word);
		} else {
			for (final String ext : Settings.PREFIX_EXTS) {
				if (word.endsWith(ext)) {
					ReadLinuxBuildFilesLog.handleSourceFile(word);
				}
			}
		}
	}
	
	private static void handleIncludeDir(final String word) {
		final String include = word.substring(Settings.PREFIX_INCLUDE.length());
		if (include.startsWith(Settings.PREFIX_SLASH)) {
			return;
		}
		if (include.equals(Settings.PREFIX_POINT)) {
			return;
		}
		final String includeFile = ReadLinuxBuildFilesLog
				.parseFileName(include);
		if (!ReadLinuxBuildFilesLog.includeDirs.contains(includeFile)) {
			ReadLinuxBuildFilesLog.includeDirs.add(includeFile);
		}
	}
	
	private static String parseFileName(String include) {
		if (include.startsWith("-Wa,")) {
			include = include.substring("-Wa,".length());
		}
		String help = include.replaceAll(Settings.STR_UP_DIR_PATTERN,
				Settings.STR_UP_DIR_REPLACE);
		help = help.replaceAll(Settings.STR_UP_DIR_PATTERN,
				Settings.STR_UP_DIR_REPLACE);
		return help.replaceAll(Settings.STR_UP_DIR_PATTERN_2,
				Settings.STR_UP_DIR_REPLACE_2);
	}
	
	private static void handleSourceFile(final String word) {
		final String sourceFile = ReadLinuxBuildFilesLog.parseFileName(word);
		if (!ReadLinuxBuildFilesLog.sourceFiles.contains(sourceFile)) {
			ReadLinuxBuildFilesLog.sourceFiles.add(sourceFile);
		}
	}
	
	private static void copyIncludeDirs() throws IOException {
		for (final String include : ReadLinuxBuildFilesLog.includeDirs) {
			final File src = new File(Settings.DEFAULT_LINUX + include);
			final File dst = new File(Settings.DEFAULT_OUT + include);
			final Copy copy = new Copy(src, dst);
			copy.copy();
		}
	}
	
	private static void copySourceFiles() throws IOException {
		for (int i = 0; i < ReadLinuxBuildFilesLog.sourceFiles.size(); i++) {
			final String sourceFile = ReadLinuxBuildFilesLog.sourceFiles.get(i);
			final Copy copy = new Copy(Settings.DEFAULT_LINUX + sourceFile,
					Settings.DEFAULT_OUT + sourceFile);
			copy.copy();
			ReadLinuxBuildFilesLog.parseSourceFileForIncludeFiles(sourceFile);
		}
	}
	
	private static void parseSourceFileForIncludeFiles(final String fileName)
			throws IOException {
		final BufferedReader br = new BufferedReader(new FileReader(
				Settings.DEFAULT_LINUX + fileName));
		try {
			final int index = fileName.lastIndexOf("/");
			final String path = fileName.substring(0, index);
			String line;
			while ((line = br.readLine()) != null) {
				final String pattern = "^#(\\s*)include \"(.*)\"(.*)$";
				final boolean match = line.matches(pattern);
				final String name = line.replaceAll(pattern, "$2");
				final String result = path + "/" + name;
				if ((match && (result != null)) && !result.isEmpty()) {
					final String includeFile = ReadLinuxBuildFilesLog
							.getFileName(result);
					if (!includeFile.isEmpty()
							&& !(ReadLinuxBuildFilesLog.sourceFiles
									.contains(includeFile))) {
						ReadLinuxBuildFilesLog.sourceFiles.add(includeFile);
						MyLog.trace(ReadLinuxBuildFilesLog.class,
								"include file='" + includeFile + "'");
					}
				}
			}
		} finally {
			br.close();
		}
	}
	
	private static String getFileName(final String includeFile) {
		final File src = new File(Settings.DEFAULT_LINUX + includeFile);
		if (src.exists()) {
			return includeFile;
		}
		MyLog.trace(ReadLinuxBuildFilesLog.class, "getFileName for '"
				+ includeFile + "'");
		final int index = includeFile.indexOf("../");
		final int lastIndex = includeFile.lastIndexOf("../");
		if (index < 0) {
			return ReadLinuxBuildFilesLog.getLastPath(includeFile);
		}
		final String fileName = includeFile.substring(0, index)
				+ includeFile.substring(lastIndex + 3);
		if ((new File(Settings.DEFAULT_LINUX + fileName)).exists()) {
			return fileName;
		}
		return "";
	}
	
	private static String getLastPath(final String includeFile) {
		String subject = includeFile;
		String[] paths;
		do {
			paths = subject.split("/");
			String path = "";
			for (int i = 0; i <= (paths.length - 3); i++) {
				path = path + paths[i] + "/";
			}
			subject = path + paths[paths.length - 1];
			MyLog.trace(ReadLinuxBuildFilesLog.class, "  subject='" + subject
					+ "'");
			if ((new File(Settings.DEFAULT_LINUX + subject)).exists()) {
				return subject;
			}
		} while (paths.length > 1);
		MyLog.trace(ReadLinuxBuildFilesLog.class, "not found here '"
				+ includeFile + "', subject='" + subject + "'");
		return "";
	}
	
}
