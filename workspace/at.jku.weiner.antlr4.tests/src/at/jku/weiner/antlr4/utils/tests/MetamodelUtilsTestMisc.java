package at.jku.weiner.antlr4.utils.tests;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.antlr4.utils.GeneratorUtils;
import at.jku.weiner.antlr4.utils.MetamodelUtils;
import at.jku.weiner.log.MyLog;

public class MetamodelUtilsTestMisc {
	private static final String	DIR_MODEL			= "my_model";

	private static final String	TEST_PROJECT_NAME	= "testProject";
	private IProgressMonitor	monitor;
	private IProject			myTestProject;
	private MetamodelUtils		utils;
	
	@Before
	public void setUp() throws Exception {
		MyLog.setLog_level(MyLog.LOG_NONE);
		this.monitor = new NullProgressMonitor();
		this.myTestProject = GeneratorUtils.reCreateProject(
				MetamodelUtilsTestMisc.TEST_PROJECT_NAME, this.monitor);
		this.myTestProject.delete(true, this.monitor);
		this.myTestProject.create(this.monitor);
		this.myTestProject.open(this.monitor);
		this.utils = null;
	}
	
	@Test
	public void testSetUp() throws Exception {
		// prepare test
		final IFolder modelDir = this.myTestProject
				.getFolder(MetamodelUtilsTestMisc.DIR_MODEL);
		Assert.assertFalse(modelDir.exists());
		// run test
		this.utils = new MetamodelUtils(this.myTestProject, this.monitor,
				MetamodelUtilsTestMisc.DIR_MODEL);
		Assert.assertTrue(modelDir.exists());
	}
	
	@Test
	public void testCreateEcoreFile() throws Exception {
		// prepare test
		final String name = "hello";
		final IFolder modelDir = this.myTestProject
				.getFolder(MetamodelUtilsTestMisc.DIR_MODEL);
		final IFile mmFile = modelDir.getFile(name + MetamodelUtils.ECORE_EXT);
		Assert.assertFalse(mmFile.exists());
		// run test
		this.utils = new MetamodelUtils(this.myTestProject, this.monitor,
				MetamodelUtilsTestMisc.DIR_MODEL);
		Assert.assertFalse(mmFile.exists());
		this.utils.createECoreFile(name, name, name);
		Assert.assertTrue(modelDir.exists());
		Assert.assertTrue(mmFile.exists());
	}

}
