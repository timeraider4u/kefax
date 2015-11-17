package at.jku.weiner.cpreprocess.xtexttests;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import at.jku.weiner.cpreprocess.utils.IncludeDirs;

@RunWith(Suite.class)
@SuiteClasses({ Test0014_AbsoluteInclude.class, })
public class Test0014_AbsoluteIncludeSuite {

	@BeforeClass
	public static void setUp() {
		final File file = new File(""); // dummy file
		final String prjDir = file.getAbsolutePath() + File.separator;
		IncludeDirs.addIncludeDirectoryToList(prjDir + "myinclude");
	}

}
