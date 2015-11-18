package at.jku.weiner.cpreprocess.xtexttests;

import java.io.File;
import at.jku.weiner.cpreprocess.utils.IncludeDirs;

public final class TestUtils {

	public static void setUpTest0014() {
		final File file = new File(""); // dummy file
		final String prjDir = file.getAbsolutePath() + File.separator;
		IncludeDirs.addIncludeDirectoryToList(prjDir + "myinclude");
	}

	public static void setUpTest0015() {
		final File file = new File(""); // dummy file
		final String prjDir = file.getAbsolutePath() + File.separator;
		IncludeDirs.addIncludeDirectoryToList(prjDir + "myinclude"
				+ File.separator);
	}

}
