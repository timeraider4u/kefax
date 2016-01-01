package org.eclipse.modisco.cdt.discoverer.tests;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmt.modisco.infra.common.core.internal.utils.ProjectUtils;
import org.osgi.framework.Bundle;

import at.jku.weiner.c.common.common.Model;

@SuppressWarnings("restriction")
public class EMFTest {
	private static boolean firstCall = true;

	public static Map<String, Object> getOptions(
			final String pureJavaClassFileName, final String sourceFile) {
		EMFTest.firstCall();
		final Map<String, Object> result = new HashMap<String, Object>();
		result.put("sourceFile", sourceFile);
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		final String path = root.getLocationURI().toString();
		final String path2 = path.replace("file:", "");
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

	public static Model emfTest(final String pureJavaClassFileName,
			final String sourceFile) throws Exception {
		EMFTest.firstCall();
		EMFTest.cleanUpOldProject();
		final IProject iProject = EMFTest.getProject();
		final TestUtils utils = new TestUtils(iProject, sourceFile);
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
	
}
