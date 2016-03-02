package at.jku.weiner.c.modisco.discoverer.tests;

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
import at.jku.weiner.c.modisco.discoverer.actions.impl.DiscoverFromIResource;
import at.jku.weiner.c.modisco.discoverer.utils.MySettings;

public class TestUtils {
	protected static MySettings mySettings = new MySettings();
	protected static boolean isEmpty = false;

	private final IProject project;
	private final DiscoverFromIResource discoverer;
	private final Resource discoveredModel;

	public static final void reset() {
		TestUtils.isEmpty = false;
		TestUtils.mySettings = new MySettings();
		TestUtils.mySettings.setUseNeoEMF(true);
	}

	public TestUtils(final IProject iProject, final String testName,
			final List<String> resFiles) throws Exception {
		this.project = iProject;
		Assert.assertNotNull(this.project);

		this.discoverer = new DiscoverFromIResource();
		this.discoverer
				.setSetStdInclude(TestUtils.mySettings.isSetStdInclude());
		this.discoverer.setIncludeDirs(TestUtils.mySettings.getIncludeDirs());
		this.discoverer.setAdditionalDirectives(TestUtils.mySettings
				.getAdditionalDirectives());
		this.discoverer.setTrimPreprocessModel(TestUtils.mySettings
				.isTrimPreprocessModel());
		this.discoverer.setBatchMode(TestUtils.mySettings.isBatchMode());
		this.discoverer.setUseNeoEMF(TestUtils.mySettings.isUseNeoEMF());
		for (final String resName : resFiles) {
			final IResource res = this.getRes(resName);
			Assert.assertNotNull(res);
			MyLog.trace(
					TestUtils.class,
					"testName='" + testName + ", resName=" + resName
							+ "', includeDirs='"
							+ TestUtils.mySettings.getIncludeDirs() + "'");
			this.discoverer.discoverElement(res, new NullProgressMonitor());
			// Thread.sleep(500);
		}
		this.checkTargetModelSerialization(iProject, testName,
				TestUtils.isEmpty);
		this.discoveredModel = this.discoverer.getTargetResource();
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
		final IFolder resTmp = (IFolder) iProject.findMember("tmp-discover");
		Assert.assertNotNull(resTmp);
		final IResource[] members = resTmp.members();
		Assert.assertNotNull(members);
		int size = 1;
		if (isEmpty) {
			size = 0;
		}
		Assert.assertEquals(size + 1, members.length);
		Assert.assertNotNull(members[0]);
		if (size == 1) {
			Assert.assertNotNull(members[1]);
		}
		Assert.assertEquals(size + 1, members.length);
	}

	public void cleanUp() {
		this.discoverer.close();
		// PersistentResourceImpl
		// .shutdownWithoutUnload((PersistentResourceImpl)
		// this.discoveredModel);
		// this.discoveredModel.unload();
	}

}
