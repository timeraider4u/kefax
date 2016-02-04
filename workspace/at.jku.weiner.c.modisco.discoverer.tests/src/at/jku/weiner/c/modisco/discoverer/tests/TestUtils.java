package at.jku.weiner.c.modisco.discoverer.tests;

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
			final String additionalDirectives, final boolean trimPreprocessModel)
					throws Exception {
		this.project = iProject;
		Assert.assertNotNull(this.project);
		final IResource res = this.getRes(testName);
		Assert.assertNotNull(res);
		this.discoverer = new DiscoverFromIResource();
		this.discoverer.setSetStdInclude(stdInclude);
		this.discoverer.setIncludeDirs(includeDirs);
		this.discoverer.setAdditionalDirectives(additionalDirectives);
		this.discoverer.setTrimPreprocessModel(trimPreprocessModel);
		MyLog.trace(TestUtils.class, "testName='" + testName
				+ "', includeDirs='" + includeDirs + "'");
		this.discoverer.discoverElement(res, new NullProgressMonitor());
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
		final EObject root = this.discoveredModel.getContents().get(0);
		final Model model = (Model) root;
		return model;
	}

}
