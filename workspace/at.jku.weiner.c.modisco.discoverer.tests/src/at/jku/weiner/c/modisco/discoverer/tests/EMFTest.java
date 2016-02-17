package at.jku.weiner.c.modisco.discoverer.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmt.modisco.infra.common.core.internal.utils.ProjectUtils;
import org.junit.Assert;
import org.osgi.framework.Bundle;

import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.preprocess.utils.IncludeDirs;

@SuppressWarnings("restriction")
public class EMFTest {
	private static boolean firstCall = true;
	private static boolean stdInclude = true;
	private static String includeDirs = null;
	private static String path3 = null;
	private static String additionalDirectives = null;
	private static boolean trimPreprocessModel = false;

	public static Map<String, Object> getOptions(
			final String pureJavaClassFileName, final String sourceFile) {
		EMFTest.firstCall();
		final Map<String, Object> result = new HashMap<String, Object>();
		result.put("sourceFile", sourceFile);
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		final String path = root.getLocationURI().toString();
		final String path2 = path.replace("file:", "");
		EMFTest.path3 = path2;
		result.put("path", path2);
		result.put("plugin_id", Activator.PLUGIN_ID);
		return result;
	}

	private static void firstCall() {
		EMFTest.sleep();
	}

	private static void sleep() {
		if (EMFTest.firstCall) {
			try {
				EMFTest.firstCall = false;
				// Thread.sleep(500);
			} catch (final Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static Model emfTest2(final String pureJavaClassFileName,
			final String sourceFile) throws Exception {
		final List<String> list = new ArrayList<String>();
		list.add(sourceFile + "1");
		list.add(sourceFile + "2");
		return EMFTest.emfTest(pureJavaClassFileName, sourceFile, list);
	}

	public static Model emfTest(final String pureJavaClassFileName,
			final String sourceFile) throws Exception {
		return EMFTest.emfTest(pureJavaClassFileName, sourceFile,
				TestUtils.getListForElement(sourceFile));
	}

	private static Model emfTest(final String pureJavaClassFileName,
			final String testName, final List<String> resFiles)
			throws Exception {
		EMFTest.firstCall();
		EMFTest.cleanUpOldProject();
		final IProject iProject = EMFTest.getProject();
		final String myIncludeDirs = EMFTest.includeDirs;
		final boolean myStdInclude = EMFTest.stdInclude;
		final String myDefines = EMFTest.additionalDirectives;
		final boolean trimPreprocess = EMFTest.trimPreprocessModel;
		EMFTest.stdInclude = true;
		EMFTest.includeDirs = null;
		EMFTest.additionalDirectives = null;
		EMFTest.trimPreprocessModel = false;

		final TestUtils utils = new TestUtils(iProject, testName, resFiles,
				myStdInclude, myIncludeDirs, myDefines, trimPreprocess);
		final Model result = utils.getModel();
		return result;
	}

	private static void cleanUpOldProject() throws CoreException {
		final IProject oldProject = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(Activator.PLUGIN_ID);
		if (oldProject.exists()) {
			oldProject.delete(true, true, new NullProgressMonitor());
		}
	}

	private static IProject getProject() throws Exception {
		final Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		final IProject project = ProjectUtils.importPlugin(bundle);
		return project;
	}

	public static void setNoStdInclude() {
		EMFTest.stdInclude = false;
	}

	public static void includeDirsIsEmpty() {
		final List<String> list = IncludeDirs.getListCopy();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.isEmpty());
	}

	public static void includeDirsStringIsEmpty() {
		Assert.assertNull(EMFTest.includeDirs);
	}

	public static void addIncludeDir() {
		EMFTest.includeDirs = EMFTest.path3 + File.separator
				+ Activator.PLUGIN_ID + File.separator + "res/";
	}

	public static void addDefine() {
		EMFTest.additionalDirectives = "#define __MY_TYPE__ unsigned int";
	}

	public static void addInclude() {
		EMFTest.additionalDirectives = "#include \"../include/SimpleInclude.h\"";
	}

	public static void doTrim() {
		EMFTest.trimPreprocessModel = true;
		EMFTest.stdInclude = false;
	}

}
