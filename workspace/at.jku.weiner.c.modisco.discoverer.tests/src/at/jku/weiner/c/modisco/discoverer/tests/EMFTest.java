package at.jku.weiner.c.modisco.discoverer.tests;

import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmt.modisco.infra.common.core.internal.utils.ProjectUtils;
import org.eclipse.osgi.service.datalocation.Location;
import org.junit.Assert;
import org.osgi.framework.Bundle;

import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.preprocess.utils.IncludeDirs;
import at.jku.weiner.log.MyLog;

@SuppressWarnings("restriction")
public class EMFTest {
	private static String path3 = null;
	private static TestUtils myUtils = null;

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

	@SuppressWarnings("unused")
	private static List<Object[]> getParameters() {
		return Arrays.asList(new Object[][] { { true }, { false } });
	}

	public static Model emfTestB(final String pureJavaClassFileName,
			final String sourceFile, final Boolean use) throws Exception {
		final List<String> list = new ArrayList<String>();
		list.add(sourceFile + "1");
		list.add(sourceFile + "2");
		return EMFTest.emfTest(pureJavaClassFileName, sourceFile, list, use);
	}

	public static Model emfTest(final String pureJavaClassFileName,
			final String sourceFile, final Boolean use) throws Exception {
		return EMFTest.emfTest(pureJavaClassFileName, sourceFile,
				EMFTest.getListForElement(sourceFile), use);
	}

	private static List<String> getListForElement(final String element) {
		final List<String> result = new ArrayList<String>();
		result.add(element);
		return result;
	}

	private static Model emfTest(final String pureJavaClassFileName,
			final String testName, final List<String> resFiles,
			final Boolean use) throws Exception {
		EMFTest.cleanUpOldProject();
		final IProject iProject = EMFTest.getProject();
		iProject.refreshLocal(IResource.DEPTH_INFINITE,
				new NullProgressMonitor());

		final TestUtils utils = new TestUtils(iProject, testName, resFiles, use);
		final Model result = utils.getModel();
		TestUtils.reset();
		EMFTest.myUtils = utils;
		return result;
	}

	private static void cleanUpOldProject() throws CoreException {
		//MyLog.setLog_level(MyLog.LOG_TRACE);
		MyLog.setLog_level(MyLog.LOG_INFO);
		final IProject oldProject = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(Activator.PLUGIN_ID);
		if (oldProject.exists()) {
			oldProject.delete(true, true, new NullProgressMonitor());
		}
	}

	private static IProject getProject() throws Exception {
		final Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		try {
			final IProject newProject = getProjectFromModisco(bundle);
			return newProject;
		} catch (Exception ex) {
			cleanUpOldProject();
			// ex.printStackTrace();
		}
		String bundlePath = bundle.getLocation();

		final Location platformInstall = Platform.getInstallLocation();
		final URL url = platformInstall.getURL();
		final String installPath = url.toString().replaceAll(".*file:", ""); 
		if (bundlePath
				.startsWith("initial@reference:file:")) { 
			bundlePath = bundlePath.replaceAll(
					"initial@reference:file:",
					installPath);
		}
		final IProject newProject = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(Activator.PLUGIN_ID);
		newProject.create(new NullProgressMonitor());
		newProject.open(new NullProgressMonitor());
		newProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

		System.out.println("bundlePath='" + bundlePath + "'!");
		final File bundleDir = new File(bundlePath);
		final String destPath1 = newProject.getLocation().toOSString();
//		final Date date = new Date();
//		final DateFormat format = new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss");
//		final String destPath = destPath1 + "-" + format.format(date);
		final String destPath = destPath1;
		
		System.out.println("destPath='" + destPath + "'!");
		final File destDir = new File(destPath);
		FileUtils.copyDirectory(bundleDir, destDir);
		
		newProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		return newProject;
	}
	
	private static IProject getProjectFromModisco(Bundle bundle) throws Exception {
		final IProject project = ProjectUtils.importPlugin(bundle);
		return project;
	}

	private static void setUp() {
		EMFTest.myUtils = null;
		TestUtils.reset();
	}

	private static void cleanUp() {
		EMFTest.myUtils.cleanUp();
		try {
			EMFTest.cleanUpOldProject();
			Thread.sleep(100);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static void test0001_before() {
		EMFTest.setUp();
		TestUtils.isEmpty = true;
	}

	public static void test0001_after() {
		EMFTest.cleanUp();
	}

	public static void test0002_before() {
		EMFTest.setUp();
		EMFTest.testIncludeDirsIsEmpty();
	}

	public static void test0002_after() {
		EMFTest.cleanUp();
	}

	public static void test0003_before() {
		EMFTest.setUp();
	}

	public static void test0003_after() {
		EMFTest.cleanUp();
	}

	public static void test0004_before() {
		EMFTest.setUp();
	}

	public static void test0004_after() {
		EMFTest.cleanUp();
	}

	public static void test0005_before() {
		EMFTest.setUp();
	}

	public static void test0005_after() {
		EMFTest.cleanUp();
	}

	public static void test0006_before() {
		EMFTest.setUp();
		TestUtils.mySettings.setIncludeDirs(EMFTest.path3 + File.separator
				+ Activator.PLUGIN_ID + File.separator + "res/");
	}

	public static void test0006_after() {
		EMFTest.cleanUp();
	}

	public static void test0007_before() {
		EMFTest.setUp();
		TestUtils.mySettings.setSetStdInclude(false);
	}

	public static void test0007_after() {
		EMFTest.testIncludeDirsIsEmpty();
		EMFTest.cleanUp();
	}

	public static void test0008_before() {
		EMFTest.setUp();
		TestUtils.mySettings
				.setAdditionalDirectives("#define __MY_TYPE__ unsigned int");
	}

	public static void test0008_after() {
		EMFTest.cleanUp();
	}

	public static void test0009_before() {
		EMFTest.setUp();
		TestUtils.mySettings
		.setAdditionalDirectives("#include \"../include/SimpleInclude.h\"");
	}

	public static void test0009_after() {
		EMFTest.cleanUp();
	}

	public static void test0010_before() {
		EMFTest.setUp();
		TestUtils.mySettings.setTrimPreprocessModel(true);
		TestUtils.mySettings.setSetStdInclude(false);
	}

	public static void test0010_after() {
		EMFTest.cleanUp();
	}

	public static void test0011_before() {
		EMFTest.setUp();
	}

	public static void test0011_after() {
		EMFTest.cleanUp();
	}

	public static void test0012_before() {
		EMFTest.setUp();
		TestUtils.mySettings.setBatchMode(true);
	}

	public static void test0012_after() {
		EMFTest.cleanUp();
	}

	public static void test0013_before() {
		EMFTest.setUp();
		TestUtils.mySettings.setBatchMode(true);
		// TestUtils.trimPreprocessModel = true;
	}

	public static void test0013_after() {
		EMFTest.cleanUp();
	}

	public static void test0014_before() {
		EMFTest.setUp();
	}

	public static void test0014_after() {
		EMFTest.cleanUp();
	}

	public static void test0015_before() {
		EMFTest.setUp();
		TestUtils.mySettings.setBatchMode(true);
	}

	public static void test0015_after() {
		EMFTest.cleanUp();
	}

	public static void test0016_before() {
		EMFTest.setUp();
		TestUtils.mySettings.setBatchMode(true);
	}

	public static void test0016_after() {
		EMFTest.cleanUp();
	}

	private static void testIncludeDirsIsEmpty() {
		final List<String> list = IncludeDirs.getListCopy();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.isEmpty());
		Assert.assertEquals("", TestUtils.mySettings.getIncludeDirs());
	}
}
