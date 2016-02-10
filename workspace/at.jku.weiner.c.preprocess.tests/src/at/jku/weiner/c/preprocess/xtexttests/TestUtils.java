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
		final StringBuffer additionalDefines = new StringBuffer("");
		additionalDefines.append("#define DO_SOMETHING void doSomething();");
		additionalDefines.append(System.lineSeparator());
		additionalDefines.append("#define STR(x) FOO(x)");
		additionalDefines.append(System.lineSeparator());
		additionalDefines.append("#define FOO(x) #x");
		additionalDefines.append(System.lineSeparator());
		gen.setAdditionalPreprocessingDirectives(additionalDefines.toString());
	}

	public static void setUpTest0088(final IGenerator generator) {
		final PreprocessGenerator gen = (PreprocessGenerator) generator;
		final StringBuffer additionalDefines = new StringBuffer("");
		additionalDefines.append("#include \"Test0000_Empty.c\"");
		additionalDefines.append(System.lineSeparator());
		additionalDefines.append("#include \"Test0002b_Code.c\"");
		additionalDefines.append(System.lineSeparator());
		gen.setAdditionalPreprocessingDirectives(additionalDefines.toString());
	}

	public static void setUpTest0089() {
		final File file = new File(""); // dummy file
		final String prjDir = file.getAbsolutePath() + File.separator;
		IncludeDirs.clearAllIncludeDirectories();
		IncludeDirs.addIncludeDirectoryToList(prjDir + "myinclude");
	}

	public static void setUpTest0090(final IGenerator generator) {
		final PreprocessGenerator gen = (PreprocessGenerator) generator;
		final File file = new File(""); // dummy file
		final String prjDir = file.getAbsolutePath() + File.separator;
		IncludeDirs.clearAllIncludeDirectories();
		IncludeDirs.addIncludeDirectoryToList(prjDir);
		final StringBuffer additionalDefines = new StringBuffer("");
		additionalDefines.append("#include <./myinclude/include/foo/foo.h>");
		additionalDefines.append(System.lineSeparator());
		gen.setAdditionalPreprocessingDirectives(additionalDefines.toString());

	}

	public static void setUpTest0091(final IGenerator generator) {
		final PreprocessGenerator gen = (PreprocessGenerator) generator;
		final File file = new File(""); // dummy file
		final String prjDir = file.getAbsolutePath();
		IncludeDirs.clearAllIncludeDirectories();
		IncludeDirs.addIncludeDirectoryToList(prjDir);
		final StringBuffer additionalDefines = new StringBuffer("");
		additionalDefines.append("#include <myinclude/include/foo/foo.h>");
		additionalDefines.append(System.lineSeparator());
		gen.setAdditionalPreprocessingDirectives(additionalDefines.toString());
	}

	public static void setUpTest0108(final IGenerator generator) {
		final PreprocessGenerator gen = (PreprocessGenerator) generator;
		gen.setInsertPredefinedMacros(true);
		gen.setStdInclude(true);
	}

	public static void setUpTest0109(final IGenerator generator) {
		final PreprocessGenerator gen = (PreprocessGenerator) generator;
		gen.setInsertPredefinedMacros(true);
		gen.setStdInclude(false);

	}

	public static void setUpTest0112(final IGenerator generator) {
		final File file = new File(""); // dummy file
		final String prjDir = file.getAbsolutePath() + File.separator;
		IncludeDirs.clearAllIncludeDirectories();
		IncludeDirs.addIncludeDirectoryToList(prjDir + "myinclude"
				+ File.separator + "include");
	}

	public static void setUpTest0119() {

	}

	public static void setUpTest0130() {
		final File file = new File(""); // dummy file
		final String prjDir = file.getAbsolutePath() + File.separator;
		IncludeDirs.clearAllIncludeDirectories();
		IncludeDirs.addIncludeDirectoryToList(prjDir + "myinclude"
				+ File.separator + "include");
	}

	public static void setUpTest0131() {
		final File file = new File(""); // dummy file
		final String prjDir = file.getAbsolutePath() + File.separator;
		IncludeDirs.clearAllIncludeDirectories();
		IncludeDirs.addIncludeDirectoryToList(prjDir + "myinclude"
				+ File.separator + "include");
		IncludeDirs.addIncludeDirectoryToList(prjDir + "myinclude"
				+ File.separator + "include" + File.separator + "test0131");
		IncludeDirs.addIncludeDirectoryToList(prjDir + "myinclude"
				+ File.separator + "include" + File.separator + "test0131");
		IncludeDirs.addIncludeDirectoryToList(prjDir + "myinclude"
				+ File.separator + "include" + File.separator + "test0131"
				+ File.separator + "test0131");
	}
}
