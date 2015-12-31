package org.eclipse.modisco.cdt.discoverer.tests;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;

import at.jku.weiner.c.common.common.Model;

public class EMFTest {

	public static Model emfTest(final String pureJavaClassFileName,
			final String sourceFile) throws Exception {
		final TestUtils utils = new TestUtils(sourceFile);
		final Model result = utils.getModel();
		return result;
	}

	public static Map<String, Object> getOptions(
			final String pureJavaClassFileName, final String sourceFile) {
		final Map<String, Object> result = new HashMap<String, Object>();
		result.put("sourceFile", sourceFile);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(Activator.PLUGIN_ID);
		final String path = project.getLocationURI().toString();
		final String path2 = path.replace("file:", "");
		result.put("path", path2);
		return result;
	}

}
