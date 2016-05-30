package at.jku.weiner.antlr4.utils.tests;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.antlr4.tests.mocks.ExampleProjectNature;
import at.jku.weiner.antlr4.utils.GeneratorUtils;
import at.jku.weiner.log.MyLog;

public class GeneratorUtilsTestAddNature {
	private static final String TEST_PROJECT_NAME = "testProject";
	private IProgressMonitor monitor;
	private IProject myTestProject;

	@Before
	public void setUp() throws Exception {
		MyLog.setLog_level(MyLog.LOG_NONE);
		this.monitor = new NullProgressMonitor();
		this.myTestProject = GeneratorUtils.reCreateProject(
				GeneratorUtilsTestAddNature.TEST_PROJECT_NAME, this.monitor);
	}
	
	@Test
	public void testAddJavaNature() throws Exception {
		// prepare test
		final IProjectDescription desc = this.myTestProject.getDescription();
		Assert.assertNotNull(desc);
		final String[] natures1 = desc.getNatureIds();
		Assert.assertNotNull(natures1);
		Assert.assertEquals(0, natures1.length);
		// run test
		GeneratorUtils.addNature(this.myTestProject, this.monitor,
				JavaCore.NATURE_ID);
		// test
		final IProjectDescription desc2 = this.myTestProject.getDescription();
		Assert.assertNotNull(desc2);
		final String[] natures2 = desc2.getNatureIds();
		Assert.assertNotNull(natures2);
		Assert.assertEquals(1, natures2.length);
		Assert.assertEquals(JavaCore.NATURE_ID, natures2[0]);
	}

	@Test
	public void testAddJavaNature2() throws Exception {
		// prepare test
		final IProjectDescription desc = this.myTestProject.getDescription();
		Assert.assertNotNull(desc);
		final String[] natures1 = desc.getNatureIds();
		Assert.assertNotNull(natures1);
		Assert.assertEquals(0, natures1.length);
		// run test
		GeneratorUtils.addNature(this.myTestProject, this.monitor,
				JavaCore.NATURE_ID);
		// test
		final IProjectDescription desc2 = this.myTestProject.getDescription();
		Assert.assertNotNull(desc2);
		final String[] natures2 = desc2.getNatureIds();
		Assert.assertNotNull(natures2);
		Assert.assertEquals(1, natures2.length);
		Assert.assertEquals(JavaCore.NATURE_ID, natures2[0]);
		// run test
		final String exampleNature = ExampleProjectNature.NATURE_ID;
		GeneratorUtils.addNature(this.myTestProject, this.monitor,
				exampleNature);
		// test
		final IProjectDescription desc3 = this.myTestProject.getDescription();
		Assert.assertNotNull(desc3);
		final String[] natures3 = desc3.getNatureIds();
		Assert.assertNotNull(natures3);
		Assert.assertEquals(2, natures3.length);
		Assert.assertEquals(JavaCore.NATURE_ID, natures3[0]);
		Assert.assertEquals(exampleNature, natures3[1]);
		// run test
		GeneratorUtils.addNature(this.myTestProject, this.monitor,
				exampleNature);
		// test
		final IProjectDescription desc4 = this.myTestProject.getDescription();
		Assert.assertNotNull(desc4);
		final String[] natures4 = desc4.getNatureIds();
		Assert.assertNotNull(natures4);
		Assert.assertEquals(2, natures4.length);
		Assert.assertEquals(JavaCore.NATURE_ID, natures4[0]);
		Assert.assertEquals(exampleNature, natures4[1]);
	}
}
