package org.eclipse.modisco.cdt.discoverer.tests;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.modisco.cdt.discoverer.actions.DiscoverCDTFromIResource;
import org.junit.Assert;

import at.jku.weiner.c.common.common.Model;

public class TestUtils {

	private final IProject project;
	private final DiscoverCDTFromIResource discoverer;
	private final Resource discoveredModel;

	public TestUtils(final IProject iProject, final String testName,
			final boolean stdInclude, final String includeDirs)
			throws Exception {
		this.project = iProject;
		Assert.assertNotNull(this.project);
		final IResource res = this.getRes(testName);
		Assert.assertNotNull(res);
		this.discoverer = new DiscoverCDTFromIResource();
		this.discoverer.setSetStdInclude(stdInclude);
		this.discoverer.setIncludeDirs(includeDirs);
		System.out.println("testName='" + testName + "', includeDirs='"
				+ includeDirs + "'");
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
