package at.jku.weiner.c.modisco.discoverer.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Assert;

import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.modisco.discoverer.actions.DiscoverFromIResource;

public class TestUtils {

	private final IProject project;
	private final DiscoverFromIResource discoverer;
	private final Resource discoveredModel;

	public TestUtils(final IProject iProject, final String testName,
			final boolean stdInclude, final String includeDirs,
			final String additionalDirectives,
			final boolean trimPreprocessModel, final boolean isEmpty)
					throws Exception {
		this(iProject, testName, TestUtils.getListForElement(testName),
				stdInclude, includeDirs, additionalDirectives,
				trimPreprocessModel, isEmpty);
	}

	public static List<String> getListForElement(final String element) {
		final List<String> result = new ArrayList<String>();
		result.add(element);
		return result;
	}

	public TestUtils(final IProject iProject, final String testName,
			final List<String> resFiles, final boolean stdInclude,
			final String includeDirs, final String additionalDirectives,
			final boolean trimPreprocessModel, final boolean isEmpty)
			throws Exception {
		this.project = iProject;
		Assert.assertNotNull(this.project);

		this.discoverer = new DiscoverFromIResource();
		this.discoverer.setSetStdInclude(stdInclude);
		this.discoverer.setIncludeDirs(includeDirs);
		this.discoverer.setAdditionalDirectives(additionalDirectives);
		this.discoverer.setTrimPreprocessModel(trimPreprocessModel);
		for (final String resName : resFiles) {
			final IResource res = this.getRes(resName);
			Assert.assertNotNull(res);
			MyLog.trace(TestUtils.class, "testName='" + testName + ", resName="
					+ resName + "', includeDirs='" + includeDirs + "'");
			this.discoverer.discoverElement(res, new NullProgressMonitor());
		}
		this.checkTargetModelSerialization(iProject, testName, isEmpty);
		this.discoveredModel = this.discoverer.getTargetModel();
		Assert.assertNotNull(this.discoveredModel);
	}

	private IResource getRes(final String fileName) {
		IResource res = this.project.getFile(fileName);
		if ((res == null) || !res.exists()) {
			res = this.project.findMember(fileName);
		}
		Assert.assertNotNull("res is null, fileName=" + fileName, res);
		Assert.assertTrue(
				"Could not access the test resource :" + res.getName(),
				res.exists() && res.isAccessible());
		return res;
	}

	public Model getModel() {
		Assert.assertNotNull(this.discoveredModel);
		Assert.assertEquals(1, this.discoveredModel.getContents().size());
		final EObject root = this.discoveredModel.getContents().get(0);
		final Model model = (Model) root;
		return model;
	}

	private void checkTargetModelSerialization(final IProject iProject,
			final String testName, final boolean isEmpty) throws Exception {
		IFolder resTmp = (IFolder) iProject.findMember("tmp-discover");
		Assert.assertNotNull(resTmp);
		System.err.println("resTmp='" + resTmp + "'");
		IResource[] members = resTmp.members();
		Assert.assertNotNull(members);
		int size = 1;
		if (isEmpty) {
			size = 0;
		}
		Assert.assertEquals(size + 1, members.length);
	}

}
