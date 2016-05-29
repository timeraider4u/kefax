package at.jku.weiner.antlr4.tests;

import java.io.File;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Bundle;

import at.jku.weiner.antlr4.GeneratorUtils;
import at.jku.weiner.log.MyLog;

public class GeneratorUtilsTestMisc {

	private static final String PKG_NAME = "at.jku.weiner.antlr4.tests";
	private static final String TEST_PROJECT_NAME = "testProject";
	private IProgressMonitor monitor;
	private IProject myTestProject;

	@Before
	public void setUp() throws Exception {
		MyLog.setLog_level(MyLog.LOG_NONE);
		this.monitor = new NullProgressMonitor();
		this.myTestProject = GeneratorUtils.reCreateProject(
				GeneratorUtilsTestMisc.TEST_PROJECT_NAME, this.monitor);
	}

	@Test
	public void testGetResourceFor() throws Exception {
		// prepare test
		final IFile file = this.myTestProject.getFile("my.g4");
		final InputStream in = GeneratorUtils
				.convertStringToStream("some content!");
		file.create(in, true, this.monitor);
		final ISelection selection = new StructuredSelection(file);
		// run test
		final IResource res = GeneratorUtils.getIResourceFor(selection);
		Assert.assertNotNull(res);
		Assert.assertEquals(file, res);
	}

	@Test
	public void testGetBundleNameFor() throws Exception {
		// prepare test
		final Bundle bundle = Activator.getContext().getBundle();
		final String myName = "META-INF/MANIFEST.MF";
		// run test
		final String fileName = GeneratorUtils.getAbsoluteFileNameFor(bundle,
				myName);
		Assert.assertNotNull(fileName);
		Assert.assertTrue(fileName.endsWith(GeneratorUtilsTestMisc.PKG_NAME
				+ File.separator + myName));
	}
	
	@Test
	public void testCopyLib() throws Exception {
		// prepare test
		final IFolder libFolder = this.myTestProject
				.getFolder(GeneratorUtils.LIB_DIR);
		final IFile libFile = libFolder.getFile(GeneratorUtils.LIB_FILE);
		Assert.assertFalse(libFolder.exists());
		Assert.assertFalse(libFile.exists());
		// run test
		final IFile result = GeneratorUtils.copyLibTo(this.myTestProject,
				this.monitor);
		Assert.assertTrue(libFolder.exists());
		Assert.assertTrue(libFile.exists());
		Assert.assertEquals(libFile, result);
	}

	@Test
	public void testCopyLib2() throws Exception {
		final IFolder libFolder = this.myTestProject
				.getFolder(GeneratorUtils.LIB_DIR);
		final IFile libFile = libFolder.getFile(GeneratorUtils.LIB_FILE);
		Assert.assertFalse(libFolder.exists());
		Assert.assertFalse(libFile.exists());
		// run test
		final IFile result = GeneratorUtils.copyLibTo(this.myTestProject,
				this.monitor);
		Assert.assertTrue(libFolder.exists());
		final IResource[] members = libFolder.members();
		Assert.assertNotNull(members);
		Assert.assertEquals(1, members.length);
		Assert.assertTrue(libFile.exists());
		Assert.assertEquals(libFile, result);
		// run test again
		final IFile result2 = GeneratorUtils.copyLibTo(this.myTestProject,
				this.monitor);
		Assert.assertTrue(libFolder.exists());
		final IResource[] members2 = libFolder.members();
		Assert.assertNotNull(members2);
		Assert.assertEquals(1, members2.length);
		Assert.assertTrue(libFile.exists());
		Assert.assertEquals(libFile, result2);
	}
	
}
