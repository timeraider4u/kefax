package at.jku.weiner.antlr4.utils.tests;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.antlr4.utils.GeneratorUtils;
import at.jku.weiner.antlr4.utils.MetamodelUtils;
import at.jku.weiner.log.MyLog;

public class MetamodelUtilsTestMisc {
	protected static final String	DIR_MODEL			= "my_model";
	protected static final String	TEST_PROJECT_NAME	= "testProject";
	
	private IProgressMonitor		monitor;
	private IProject				myTestProject;
	private MetamodelUtils			mmUtils;

	@Before
	public void setUp() throws Exception {
		MyLog.setLog_level(MyLog.LOG_NONE);
		this.monitor = new NullProgressMonitor();
		this.myTestProject = GeneratorUtils.reCreateProject(
				MetamodelUtilsTestMisc.TEST_PROJECT_NAME, this.monitor);
		this.myTestProject.delete(true, this.monitor);
		this.myTestProject.create(this.monitor);
		this.myTestProject.open(this.monitor);
		this.mmUtils = null;
	}

	@Test
	public void testSetUp() throws Exception {
		// prepare test
		final IFolder modelDir = this.myTestProject
				.getFolder(MetamodelUtilsTestMisc.DIR_MODEL);
		Assert.assertFalse(modelDir.exists());
		// run test
		this.mmUtils = new MetamodelUtils(this.myTestProject, this.monitor,
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
		this.mmUtils = new MetamodelUtils(this.myTestProject, this.monitor,
				MetamodelUtilsTestMisc.DIR_MODEL);
		Assert.assertFalse(mmFile.exists());
		this.mmUtils.createECoreFile(name, name, name);
		Assert.assertTrue(modelDir.exists());
		Assert.assertTrue(mmFile.exists());
		final EPackage package1 = this.mmUtils.getEPackage();
		Assert.assertNotNull(package1);
		Assert.assertEquals(name, package1.getName());
		Assert.assertEquals(name, package1.getNsPrefix());
		Assert.assertEquals(name, package1.getNsURI());
	}
	
	@Test
	public void testCreateEcoreFile2() throws Exception {
		// prepare test
		final String name = "hello";
		final String clazzName = "myClazz";
		// run test
		this.mmUtils = new MetamodelUtils(this.myTestProject, this.monitor,
				MetamodelUtilsTestMisc.DIR_MODEL);
		this.mmUtils.createECoreFile(name, name, name);
		final EClass clazz = this.mmUtils.createOrFindEClass(clazzName);
		Assert.assertNotNull(clazz);
		Assert.assertFalse(clazz.isAbstract());
		Assert.assertFalse(clazz.isInterface());
		Assert.assertEquals(clazzName, clazz.getName());
		final EPackage mypackage = this.mmUtils.getEPackage();
		Assert.assertNotNull(mypackage);
		final EList<EObject> contents = mypackage.eContents();
		Assert.assertNotNull(contents);
		Assert.assertEquals(1, contents.size());
		final EObject object = contents.get(0);
		Assert.assertNotNull(object);
		Assert.assertEquals(clazz, object);
	}
	
	@Test
	public void testGetTopNode() throws Exception {
		// prepare test
		final String name = "hello";
		// run test
		this.mmUtils = new MetamodelUtils(this.myTestProject, this.monitor,
				MetamodelUtilsTestMisc.DIR_MODEL);
		this.mmUtils.createECoreFile(name, name, name);
		final String a = "a";
		final String b = "b";
		final String c = "c";
		final String d = "d";
		this.mmUtils.addContainment(a, b);
		this.mmUtils.addContainment(a, c);
		this.mmUtils.addContainment(a, d);
		this.mmUtils.addContainment(b, c);
		this.mmUtils.addContainment(b, d);
		this.mmUtils.addContainment(c, d);
		this.mmUtils.addContainment(d, d);
		// check EPackage and EClass'es
		final EPackage mypackage = this.mmUtils.getEPackage();
		Assert.assertNotNull(mypackage);
		final EList<EObject> contents = mypackage.eContents();
		Assert.assertNotNull(contents);
		Assert.assertEquals(4, contents.size());
		final EClass clazzA = this.checkEClass(a, contents.get(0));
		this.checkEClass(b, contents.get(1));
		this.checkEClass(c, contents.get(2));
		this.checkEClass(d, contents.get(3));
		// check top node
		final EClass top = this.mmUtils.getTopClazz();
		Assert.assertNotNull(top);
		Assert.assertEquals(clazzA, top);
	}

	private EClass checkEClass(final String name, final EObject object) {
		Assert.assertNotNull(object);
		Assert.assertTrue(object instanceof EClass);
		final EClass clazz = (EClass) object;
		Assert.assertEquals(name, clazz.getName());
		return clazz;
	}
	
	@Test
	public void testGetTopNode2() throws Exception {
		// prepare test
		final String name = "hello";
		// run test
		this.mmUtils = new MetamodelUtils(this.myTestProject, this.monitor,
				MetamodelUtilsTestMisc.DIR_MODEL);
		this.mmUtils.createECoreFile(name, name, name);
		final String a = "a";
		final String b = "b";
		this.mmUtils.addContainment(a, a);
		this.mmUtils.addContainment(a, b);
		this.mmUtils.addContainment(b, b);
		// check EPackage and EClass'es
		final EPackage mypackage = this.mmUtils.getEPackage();
		Assert.assertNotNull(mypackage);
		final EList<EObject> contents = mypackage.eContents();
		Assert.assertNotNull(contents);
		Assert.assertEquals(2, contents.size());
		final EClass clazzA = this.checkEClass(a, contents.get(0));
		this.checkEClass(b, contents.get(1));
		// check top node
		final EClass top = this.mmUtils.getTopClazz();
		Assert.assertNotNull(top);
		Assert.assertEquals(clazzA, top);
	}
	
}
