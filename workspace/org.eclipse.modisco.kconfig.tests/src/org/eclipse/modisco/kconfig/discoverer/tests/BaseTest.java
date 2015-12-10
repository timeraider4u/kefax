package org.eclipse.modisco.kconfig.discoverer.tests;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmt.modisco.infra.common.core.internal.utils.ProjectUtils;
import org.eclipse.modisco.kconfig.Model;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.discoverer.actions.DiscoverKCONFIGFromProject;
import org.junit.Assert;
import org.osgi.framework.Bundle;

@SuppressWarnings("restriction")
public class BaseTest {
	private static final String RESOURCES_TEST = "resources/";
	private final String testName;
	private Resource resource;
	private final IProject project;
	private final DiscoverKCONFIGFromProject discoverer;

	public BaseTest(final String prefix, final String testName)
			throws Exception {
		this.testName = BaseTest.RESOURCES_TEST + prefix + '/' + testName + '/';
		this.cleanUpOldProject();
		this.project = this.getProject();
		Assert.assertNotNull(this.project);
		if (this.project == null) {
			throw new NullPointerException();
		}
		this.checkFilesFromList();
		this.discoverer = new DiscoverKCONFIGFromProject();
		this.discoverElement("");
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

	private void checkFilesFromList() {
		final String resName = '/' + this.testName;
		System.out.println("In checkFilesFromList, testName=" + resName);
		final IResource res = this.getRes(resName);
		Assert.assertTrue(
				"Could not initialize on the test resource :" + res.getName(),
				res.exists() && res.isAccessible());
	}

	private IResource getRes(final String fileName) {
		IResource res = this.project.getFile(fileName);
		if ((res == null) || !res.exists()) {
			System.out.println("extendedSearch!");
			res = this.project.findMember(fileName);
		}
		Assert.assertNotNull("res is null, fileName=" + fileName, res);
		Assert.assertTrue(
				"Could not access the test resource :" + res.getName(),
				res.exists() && res.isAccessible());
		return res;
	}

	public void discoverElement(final String fileName) throws Exception {
		System.out.println("discoverElement fileName=" + fileName);
		final String resName = this.testName + fileName;
		System.out.println("discoverElement resName=" + resName);
		final IResource res = this.getRes(resName);
		this.discoverer.discoverElement(res, new NullProgressMonitor());
		this.resource = this.discoverer.getTargetModel();
		Assert.assertNotNull(this.resource);
		Assert.assertFalse(this.resource.getContents().isEmpty());
	}

	public Model getModel() {
		final EObject root = this.resource.getContents().get(0);
		final Model model = (Model) root;
		Assert.assertNotNull(model);

		return model;
	}

	public TranslationUnit getTranslationUnit(final String fileName,
			final int size) throws Exception {
		final Model model = this.getModel();
		Assert.assertFalse("model.getUnits() isEmpty=TRUE!", model.getUnits()
				.isEmpty());
		Assert.assertEquals("size of units does not match", size, model
				.getUnits().size());
		final TranslationUnit unit = model.getUnits().get(0);
		Assert.assertNotNull(unit);
		Assert.assertEquals(fileName, unit.getName());
		return unit;
	}

}
