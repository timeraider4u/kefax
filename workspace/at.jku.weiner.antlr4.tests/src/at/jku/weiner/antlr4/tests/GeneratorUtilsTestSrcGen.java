package at.jku.weiner.antlr4.tests;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.antlr4.GeneratorUtils;
import at.jku.weiner.log.MyLog;

public class GeneratorUtilsTestSrcGen {
	private static final String TEST_PROJECT_NAME = "testProject";
	private IProgressMonitor monitor;
	private IProject myTestProject;
	
	@Before
	public void setUp() throws Exception {
		MyLog.setLog_level(MyLog.LOG_NONE);
		this.monitor = new NullProgressMonitor();
		this.myTestProject = GeneratorUtils.reCreateProject(
				GeneratorUtilsTestSrcGen.TEST_PROJECT_NAME, this.monitor);
		Assert.assertTrue(this.myTestProject.exists());
	}
	
	@Test
	public void testReCreateProject() throws Exception {
		// prepare Test
		final IFolder folder = this.myTestProject.getFolder("myDir");
		folder.create(true, true, this.monitor);
		Assert.assertTrue(folder.exists());
		// run test
		GeneratorUtils.reCreateProject(
				GeneratorUtilsTestSrcGen.TEST_PROJECT_NAME, this.monitor);
		Assert.assertTrue(this.myTestProject.exists());
		Assert.assertFalse(folder.exists());
	}
	
	@Test
	public void testReCreateFolder() throws Exception {
		// prepare test
		final IFolder folder = this.myTestProject.getFolder("myDir");
		Assert.assertFalse(folder.exists());
		// run test
		GeneratorUtils.reCreateFolder(folder, this.monitor);
		Assert.assertTrue(folder.exists());
	}
	
	@Test
	public void testReCreateFolder2() throws Exception {
		// prepare test
		final IFolder folder = this.myTestProject.getFolder("myDir");
		folder.create(true, true, this.monitor);
		Assert.assertTrue(folder.exists());
		final IFile file = folder.getFile("myFile.text");
		final InputStream in = GeneratorUtils
				.convertStringToStream("some content");
		file.create(in, true, this.monitor);
		Assert.assertEquals(1, folder.members().length);
		// run test
		GeneratorUtils.reCreateFolder(folder, this.monitor);
		// check first sub-folder
		Assert.assertTrue(folder.exists());
		Assert.assertFalse(file.exists());
		Assert.assertNotNull(folder.members());
		Assert.assertEquals(0, folder.members().length);
	}
	
	@Test
	public void testCreateSrcGenFolder() throws Exception {
		// prepare test
		final String name1 = "src-gen";
		final String name2 = "my";
		// run test
		final IFolder folder = GeneratorUtils.createSrcGenFolder(
				this.myTestProject, name1, name2, this.monitor);
		// test first sub-folder
		final IFolder folder1 = this.myTestProject.getFolder(name1);
		Assert.assertTrue(folder1.exists());
		final IResource[] folder1Members = folder1.members();
		Assert.assertNotNull(folder1Members);
		Assert.assertEquals(1, folder1Members.length);
		// test second sub-folder
		final IFolder folder2 = folder1.getFolder(name2);
		Assert.assertTrue(folder2.exists());
		final IResource[] folder2Members = folder2.members();
		Assert.assertNotNull(folder2Members);
		Assert.assertEquals(0, folder2Members.length);
		// test result of function
		Assert.assertEquals(folder, folder2);
	}
	
	@Test
	public void testCreateSrcGenFolder2() throws Exception {
		// prepare test
		final String name1 = "my_gen";
		final String name2 = "com";
		final String name3 = "example";
		final String name4 = "abc";
		final String packageName = name2 + "." + name3 + "." + name4;
		// run test
		final IFolder folder = GeneratorUtils.createSrcGenFolder(
				this.myTestProject, name1, packageName, this.monitor);
		// test first sub-folder
		final IFolder folder1 = this.myTestProject.getFolder(name1);
		Assert.assertTrue(folder1.exists());
		final IResource[] folder1Members = folder1.members();
		Assert.assertNotNull(folder1Members);
		Assert.assertEquals(1, folder1Members.length);
		// test second sub-folder
		final IFolder folder2 = folder1.getFolder(name2);
		Assert.assertTrue(folder2.exists());
		final IResource[] folder2Members = folder2.members();
		Assert.assertNotNull(folder2Members);
		Assert.assertEquals(1, folder2Members.length);
		// test third sub-folder
		final IFolder folder3 = folder2.getFolder(name3);
		Assert.assertTrue(folder3.exists());
		final IResource[] folder3Members = folder3.members();
		Assert.assertNotNull(folder3Members);
		Assert.assertEquals(1, folder3Members.length);
		// test fourth sub-folder
		final IFolder folder4 = folder3.getFolder(name4);
		Assert.assertTrue(folder4.exists());
		final IResource[] folder4Members = folder4.members();
		Assert.assertNotNull(folder4Members);
		Assert.assertEquals(0, folder4Members.length);
		// test result of function
		Assert.assertEquals(folder, folder4);
	}
	
	@Test
	public void testCreateSrcGenFolder3() throws Exception {
		// prepare test
		final String name1 = "antlr4-gen";
		final String name2 = "at";
		final String name3 = "test";
		final String packageName = name2 + "." + name3;
		final IFolder genFolder1 = this.myTestProject.getFolder(name1);
		genFolder1.create(true, true, this.monitor);
		final IFolder genFolderB = genFolder1.getFolder(name3);
		genFolderB.create(true, true, this.monitor);
		final IFolder genFolder2 = genFolder1.getFolder(name2);
		genFolder2.create(true, true, this.monitor);
		final IFolder genFolderC = genFolder2.getFolder(name1);
		genFolderC.create(true, true, this.monitor);
		final IFolder genFolder3 = genFolder2.getFolder(name3);
		genFolder3.create(true, true, this.monitor);
		
		// run test
		final IFolder folder = GeneratorUtils.createSrcGenFolder(
				this.myTestProject, name1, packageName, this.monitor);
		// test first sub-folder
		final IFolder folder1 = this.myTestProject.getFolder(name1);
		Assert.assertTrue(folder1.exists());
		final IResource[] folder1Members = folder1.members();
		Assert.assertNotNull(folder1Members);
		Assert.assertEquals(1, folder1Members.length);
		// test second sub-folder
		final IFolder folder2 = folder1.getFolder(name2);
		Assert.assertTrue(folder2.exists());
		final IResource[] folder2Members = folder2.members();
		Assert.assertNotNull(folder2Members);
		Assert.assertEquals(1, folder2Members.length);
		// test third sub-folder
		final IFolder folder3 = folder2.getFolder(name3);
		Assert.assertTrue(folder3.exists());
		final IResource[] folder3Members = folder3.members();
		Assert.assertNotNull(folder3Members);
		Assert.assertEquals(0, folder3Members.length);
		// test result of function
		Assert.assertEquals(folder, folder3);
	}

}
