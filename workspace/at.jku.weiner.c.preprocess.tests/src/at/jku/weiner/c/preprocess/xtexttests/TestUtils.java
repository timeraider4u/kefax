package at.jku.weiner.c.preprocess.xtexttests;

import java.io.File;

import org.eclipse.xtext.generator.IGenerator;

import at.jku.weiner.c.preprocess.generator.PreprocessGenerator;
import at.jku.weiner.c.preprocess.utils.IncludeDirs;

public final class TestUtils {
	
	public static void setUpTest0014() {
		final File file = new File(""); // dummy file
		final String prjDir = file.getAbsolutePath() + File.separator;
		IncludeDirs.clearAllIncludeDirectories();
		IncludeDirs.addIncludeDirectoryToList(prjDir + "another");
		IncludeDirs.addIncludeDirectoryToList(prjDir + "myinclude");
		IncludeDirs.addIncludeDirectoryToList(prjDir + "xcopy");
		
	}
	
	public static void setUpTest0015() {
		final File file = new File(""); // dummy file
		final String prjDir = file.getAbsolutePath() + File.separator;
		IncludeDirs.clearAllIncludeDirectories();
		IncludeDirs.addIncludeDirectoryToList(prjDir + "another");
		IncludeDirs.addIncludeDirectoryToList(prjDir + "myinclude"
				+ File.separator);
		IncludeDirs.addIncludeDirectoryToList(prjDir + "xcopy");
	}
	
	public static void setUpTest0016() {
		final File file = new File(""); // dummy file
		final String prjDir = file.getAbsolutePath() + File.separator;
		IncludeDirs.clearAllIncludeDirectories();
		IncludeDirs.addIncludeDirectoryToList(prjDir + "another");
		IncludeDirs.addIncludeDirectoryToList(prjDir + "myinclude");
		IncludeDirs.addIncludeDirectoryToList(prjDir + "myinclude"
				+ File.separator + "include");
		IncludeDirs.addIncludeDirectoryToList(prjDir + "xcopy");
		
	}
	
	public static void setUpTest0068() {
		final File file = new File(""); // dummy file
		final String prjDir = file.getAbsolutePath() + File.separator;
		IncludeDirs.clearAllIncludeDirectories();
		IncludeDirs.addIncludeDirectoryToList(prjDir + "myinclude");
	}
	
	public static void setUpTest0086(final IGenerator generator) {
		final PreprocessGenerator gen = (PreprocessGenerator) generator;
		final String additionalDefines = "";
		gen.setAdditionalDefines(additionalDefines);
	}

}
