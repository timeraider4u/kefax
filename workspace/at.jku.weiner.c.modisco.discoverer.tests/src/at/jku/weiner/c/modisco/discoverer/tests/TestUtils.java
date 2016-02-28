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
import at.jku.weiner.c.modisco.discoverer.actions.DiscoverFromIResource;

public class TestUtils {
	protected final static boolean DEFAULT_BATCH_MODE = false;
	protected final static boolean DEFAULT_IS_EMPTY = false;
	protected final static boolean DEFAULT_STD_INC = true;
	protected final static String DEFAULT_INC_DIRS = null;
	protected final static String DEFAULT_ADDITION = null;
	protected final static boolean DEFAULT_TRIM = false;
	protected final static boolean DEFAULT_USE_NEOEMF = false;

	protected static boolean batchMode = TestUtils.DEFAULT_BATCH_MODE;
	protected static boolean isEmpty = TestUtils.DEFAULT_IS_EMPTY;
	protected static boolean stdInclude = TestUtils.DEFAULT_STD_INC;
	protected static String includeDirs = TestUtils.DEFAULT_INC_DIRS;
	protected static String additionalDirectives = TestUtils.DEFAULT_ADDITION;
	protected static boolean trimPreprocessModel = TestUtils.DEFAULT_TRIM;
	protected static boolean useNeoEMF = TestUtils.DEFAULT_USE_NEOEMF;

	protected static void reset() {
		TestUtils.batchMode = TestUtils.DEFAULT_BATCH_MODE;
		TestUtils.isEmpty = TestUtils.DEFAULT_IS_EMPTY;
		TestUtils.stdInclude = TestUtils.DEFAULT_STD_INC;
		TestUtils.includeDirs = TestUtils.DEFAULT_INC_DIRS;
		TestUtils.additionalDirectives = TestUtils.DEFAULT_ADDITION;
		TestUtils.trimPreprocessModel = TestUtils.DEFAULT_TRIM;
		TestUtils.useNeoEMF = TestUtils.DEFAULT_USE_NEOEMF;
	}

	private final IProject project;
	private final DiscoverFromIResource discoverer;
	private final Resource discoveredModel;

	public TestUtils(final IProject iProject, final String testName,
			final List<String> resFiles) throws Exception {
		this.project = iProject;
		Assert.assertNotNull(this.project);

		this.discoverer = new DiscoverFromIResource();
		this.discoverer.setSetStdInclude(TestUtils.stdInclude);
		this.discoverer.setIncludeDirs(TestUtils.includeDirs);
		this.discoverer.setAdditionalDirectives(TestUtils.additionalDirectives);
		this.discoverer.setTrimPreprocessModel(TestUtils.trimPreprocessModel);
		this.discoverer.setBatchMode(TestUtils.batchMode);
		this.discoverer.setUseNeoEMF(TestUtils.useNeoEMF);
		for (final String resName : resFiles) {
			final IResource res = this.getRes(resName);
			Assert.assertNotNull(res);
			MyLog.trace(TestUtils.class, "testName='" + testName + ", resName="
					+ resName + "', includeDirs='" + TestUtils.includeDirs
					+ "'");
			this.discoverer.discoverElement(res, new NullProgressMonitor());
			// Thread.sleep(500);
		}
		this.checkTargetModelSerialization(iProject, testName,
				TestUtils.isEmpty);
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
		// this.discoverer.unloadResource();
		// PersistentResourceImpl
		// .shutdownWithoutUnload((PersistentResourceImpl)
		// this.discoveredModel);
		// this.discoveredModel.unload();
	}

}
