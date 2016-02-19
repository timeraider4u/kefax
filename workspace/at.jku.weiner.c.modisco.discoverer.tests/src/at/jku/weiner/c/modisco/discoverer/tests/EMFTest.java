package at.jku.weiner.c.modisco.discoverer.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
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
	private static String path3 = null;

	public static Map<String, Object> getOptions(
			final String pureJavaClassFileName, final String sourceFile) {
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

	public static Model emfTestB(final String pureJavaClassFileName,
			final String sourceFile) throws Exception {
		final List<String> list = new ArrayList<String>();
		list.add(sourceFile + "1");
		list.add(sourceFile + "2");
		return EMFTest.emfTest(pureJavaClassFileName, sourceFile, list);
	}

	public static Model emfTest(final String pureJavaClassFileName,
			final String sourceFile) throws Exception {
		return EMFTest.emfTest(pureJavaClassFileName, sourceFile,
				EMFTest.getListForElement(sourceFile));
	}

	private static List<String> getListForElement(final String element) {
		final List<String> result = new ArrayList<String>();
		result.add(element);
		return result;
	}

	private static Model emfTest(final String pureJavaClassFileName,
			final String testName, final List<String> resFiles)
			throws Exception {
		EMFTest.cleanUpOldProject();
		final IProject iProject = EMFTest.getProject();
		iProject.refreshLocal(IResource.DEPTH_INFINITE,
				new NullProgressMonitor());

		final TestUtils utils = new TestUtils(iProject, testName, resFiles);
		final Model result = utils.getModel();
		TestUtils.reset();
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

	public static void test0001() {
		TestUtils.isEmpty = true;
	}

	public static void test0002() {
		EMFTest.testIncludeDirsIsEmpty();
	}

	public static void test0006() {
		TestUtils.includeDirs = EMFTest.path3 + File.separator
				+ Activator.PLUGIN_ID + File.separator + "res/";
	}

	public static void test0007_before() {
		TestUtils.stdInclude = false;
	}

	public static void test0007_after() {
		EMFTest.testIncludeDirsIsEmpty();
	}

	public static void test0008() {
		TestUtils.additionalDirectives = "#define __MY_TYPE__ unsigned int";
	}

	public static void test0009() {
		TestUtils.additionalDirectives = "#include \"../include/SimpleInclude.h\"";
	}

	public static void test0010() {
		TestUtils.trimPreprocessModel = true;
		TestUtils.stdInclude = false;
	}

	public static void test0012() {
		TestUtils.batchMode = true;
	}

	public static void test0013() {
		TestUtils.batchMode = true;
		TestUtils.trimPreprocessModel = true;
	}

	private static void testIncludeDirsIsEmpty() {
		final List<String> list = IncludeDirs.getListCopy();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.isEmpty());
		Assert.assertNull(TestUtils.includeDirs);
	}
}
