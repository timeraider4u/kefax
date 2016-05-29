package at.jku.weiner.antlr4.tests;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.antlr4.GeneratorUtils;
import at.jku.weiner.log.MyLog;

public class GeneratorUtilsTestClassPath {
	private static final String TEST_PROJECT_NAME = "testProject";

	private IProgressMonitor monitor;
	private IProject myTestProject;
	private IJavaProject project;
	
	@Before
	public void setUp() throws Exception {
		MyLog.setLog_level(MyLog.LOG_NONE);
		this.monitor = new NullProgressMonitor();
		this.myTestProject = GeneratorUtils.reCreateProject(
				GeneratorUtilsTestClassPath.TEST_PROJECT_NAME, this.monitor);
	}

	@Test
	public void testAddJavaNature() throws Exception {
		// prepare test
		final IProjectDescription desc = this.myTestProject.getDescription();
		Assert.assertNotNull(desc);
		final String[] natures = desc.getNatureIds();
		Assert.assertNotNull(natures);
		Assert.assertEquals(0, natures.length);
		// run test
		Assert.assertNotNull(natures);

		this.project = GeneratorUtils.addJavaNature(this.myTestProject,
				this.monitor);
		Assert.assertNotNull(this.project);
		final IProjectDescription desc2 = this.myTestProject.getDescription();
		final String[] natures2 = desc2.getNatureIds();
		Assert.assertNotNull(natures2);
		Assert.assertEquals(1, natures2.length);
		Assert.assertEquals(JavaCore.NATURE_ID, natures2[0]);
	}

	@Test
	public void testAddClasspathEntry() throws Exception {
		// prepare test
		this.project = GeneratorUtils.addJavaNature(this.myTestProject,
				this.monitor);
		final IClasspathEntry[] entries = this.project.getRawClasspath();
		Assert.assertNotNull(entries);
		Assert.assertEquals(1, entries.length);
		// run test
		final IClasspathEntry entry = JavaRuntime.getDefaultJREContainerEntry();
		GeneratorUtils.addClassPathEntry(this.project, entry, this.monitor);
		final IClasspathEntry[] entries2 = this.project.getRawClasspath();
		
		Assert.assertNotNull(entries2);
		Assert.assertEquals(2, entries2.length);
		Assert.assertEquals(entry, entries2[1]);
		// run test again
		GeneratorUtils.addClassPathEntry(this.project, entry, this.monitor);
		final IClasspathEntry[] entries3 = this.project.getRawClasspath();
		Assert.assertNotNull(entries3);
		Assert.assertEquals(2, entries3.length);
		Assert.assertEquals(entry, entries3[1]);
	}
	
	@Test
	public void testAddAndRemoveClasspathEntry() throws Exception {
		// prepare test
		this.project = GeneratorUtils.addJavaNature(this.myTestProject,
				this.monitor);
		final IClasspathEntry[] entries = this.project.getRawClasspath();
		Assert.assertNotNull(entries);
		Assert.assertEquals(1, entries.length);
		// run test
		final IClasspathEntry entry = JavaRuntime.getDefaultJREContainerEntry();
		GeneratorUtils.addClassPathEntry(this.project, entry, this.monitor);
		final IClasspathEntry[] entries2 = this.project.getRawClasspath();
		Assert.assertNotNull(entries2);
		Assert.assertEquals(2, entries2.length);
		Assert.assertEquals(entry, entries2[1]);
		// remove entry
		GeneratorUtils.removeClassPathEntry(this.project, entry, this.monitor);
		final IClasspathEntry[] entries3 = this.project.getRawClasspath();
		Assert.assertNotNull(entries3);
		Assert.assertEquals(1, entries3.length);
		// run test again
		GeneratorUtils.addClassPathEntry(this.project, entry, this.monitor);
		final IClasspathEntry[] entries4 = this.project.getRawClasspath();
		Assert.assertNotNull(entries4);
		Assert.assertEquals(2, entries4.length);
		Assert.assertEquals(entry, entries4[1]);
		// remove entry again
		GeneratorUtils.removeClassPathEntry(this.project, entry, this.monitor);
		final IClasspathEntry[] entries5 = this.project.getRawClasspath();
		Assert.assertNotNull(entries5);
		Assert.assertEquals(1, entries5.length);
	}

}
