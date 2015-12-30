package org.eclipse.modisco.cdt.discoverer.tests;

import java.io.IOException;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmt.modisco.infra.common.core.internal.utils.ProjectUtils;
import org.eclipse.modisco.cdt.discoverer.actions.DiscoverCDTFromIResource;
import org.junit.Assert;
import org.osgi.framework.Bundle;

import at.jku.weiner.c.common.common.Model;

@SuppressWarnings({ "restriction" })
public class TestUtils {
	private static final String PREFIX = "/res/";

	private final IProject project;
	private final DiscoverCDTFromIResource discoverer;
	private final Resource discoveredModel;

	public TestUtils(final String testName) throws Exception {
		Thread.sleep(1000);
		this.cleanUpOldProject();
		this.project = this.getProject();
		Assert.assertNotNull(this.project);
		final IResource srcFolder = this.getRes(TestUtils.PREFIX + testName
				+ "/");
		Assert.assertNotNull(srcFolder);
		this.discoverer = new DiscoverCDTFromIResource();
		Assert.assertTrue(
				"res is not an instanceof IFolder, res='" + srcFolder.getName()
				+ "'", srcFolder instanceof IFolder);
		final IFolder srcFolderDir = (IFolder) srcFolder;
		this.discoverer
		.discoverElement(srcFolderDir, new NullProgressMonitor());
		this.discoveredModel = this.discoverer.getTargetModel();
		Assert.assertNotNull(this.discoveredModel);
	}

	private void cleanUpOldProject() throws CoreException {
		final IProject oldProject = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(Activator.PLUGIN_ID);
		if (oldProject.exists()) {
			oldProject.delete(true, true, new NullProgressMonitor());
		}
	}

	private IProject getProject() throws CoreException, IOException {
		final Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		return ProjectUtils.importPlugin(bundle);
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
		Assert.assertNotNull(model);
		// Assert.assertFalse("model.getUnits() isEmpty=TRUE!", model.getUnits()
		// .isEmpty());
		return model;
	}

}
