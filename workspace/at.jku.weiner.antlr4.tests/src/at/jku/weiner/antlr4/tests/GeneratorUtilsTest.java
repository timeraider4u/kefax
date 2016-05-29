package at.jku.weiner.antlr4.tests;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.antlr4.GeneratorUtils;
import at.jku.weiner.log.MyLog;

public class GeneratorUtilsTest {
	private static final String TEST_PROJECT_NAME = "testProject";
	private IProgressMonitor monitor;
	private IProject myTestProject;

	private IProject reCreateProject(final String projectName) throws Exception {
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		final IProject project = root.getProject(projectName);
		if (project.exists()) {
			project.delete(true, this.monitor);
		}
		project.create(this.monitor);
		project.open(this.monitor);
		return project;
	}

	@Before
	public void setUp() throws Exception {
		MyLog.setLog_level(MyLog.LOG_NONE);
		this.monitor = new NullProgressMonitor();
		this.myTestProject = this.reCreateProject(GeneratorUtilsTest.TEST_PROJECT_NAME);
	}

	@Test
	public void testCreateSrcGenFolder() throws Exception {
		final String name1 = "src-gen";
		final String name2 = "my";
		final IFolder folder = GeneratorUtils.createSrcGenFolder(this.myTestProject,
				name1, name2, this.monitor);
		final IFolder folder1 = this.myTestProject.getFolder(name1);
		Assert.assertTrue(folder1.exists());
		final IResource[] folder1Members = folder1.members();
		Assert.assertNotNull(folder1Members);
		Assert.assertEquals(1, folder1Members.length);
		final IFolder folder2 = folder1.getFolder(name2);
		Assert.assertTrue(folder2.exists());
		final IResource[] folder2Members = folder2.members();
		Assert.assertNotNull(folder2Members);
		Assert.assertEquals(0, folder2Members.length);

		Assert.assertEquals(folder, folder2);
	}

	@Test
	public void testCreateSrcGenFolder2() throws Exception {
		final String name1 = "src-gen";
		final String name2 = "my";
		final String name3 = "mypackage";
		final String name4 = "mydefault";
		final String packageName = name2 + "." + name3 + "." + name4;
		final IFolder folder = GeneratorUtils.createSrcGenFolder(this.myTestProject,
				name1, packageName, this.monitor);
		final IFolder folder1 = this.myTestProject.getFolder(name1);
		Assert.assertTrue(folder1.exists());
		final IResource[] folder1Members = folder1.members();
		Assert.assertNotNull(folder1Members);
		Assert.assertEquals(1, folder1Members.length);
		final IFolder folder2 = folder1.getFolder(name2);
		Assert.assertTrue(folder2.exists());
		final IResource[] folder2Members = folder2.members();
		Assert.assertNotNull(folder2Members);
		Assert.assertEquals(1, folder2Members.length);
		final IFolder folder3 = folder2.getFolder(name3);
		Assert.assertTrue(folder3.exists());
		final IResource[] folder3Members = folder3.members();
		Assert.assertNotNull(folder3Members);
		Assert.assertEquals(1, folder3Members.length);
		final IFolder folder4 = folder3.getFolder(name4);
		Assert.assertTrue(folder4.exists());
		final IResource[] folder4Members = folder4.members();
		Assert.assertNotNull(folder4Members);
		Assert.assertEquals(0, folder4Members.length);

		Assert.assertEquals(folder, folder4);
	}

}
