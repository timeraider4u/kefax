package at.jku.weiner.antlr4.utils.tests;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Bundle;

import at.jku.weiner.antlr4.Antlr4MyListener;
import at.jku.weiner.antlr4.tests.Activator;
import at.jku.weiner.antlr4.utils.Antlr4Utils;
import at.jku.weiner.antlr4.utils.GeneratorUtils;
import at.jku.weiner.antlr4.utils.MetamodelUtils;
import at.jku.weiner.log.MyLog;

public class TestRunParserAndListenerMisc {
	private IProgressMonitor	monitor;
	private IProject			myTestProject;
	private String				fileName;
	private MetamodelUtils		mmUtils;
	private Antlr4Utils			utils;

	@Before
	public void setUp() throws Exception {
		MyLog.setLog_level(MyLog.LOG_NONE);
		this.myTestProject = GeneratorUtils.reCreateProject(
				MetamodelUtilsTestMisc.TEST_PROJECT_NAME, this.monitor);
		this.myTestProject.delete(true, this.monitor);
		this.myTestProject.create(this.monitor);
		this.myTestProject.open(this.monitor);

		final Bundle bundle = Activator.getContext().getBundle();
		this.fileName = GeneratorUtils.getAbsoluteFileNameFor(bundle,
				"data/my.g4");
		this.utils = new Antlr4Utils(this.fileName);
		this.mmUtils = new MetamodelUtils(this.myTestProject, this.monitor,
				MetamodelUtilsTestMisc.DIR_MODEL);
		final String name = "hello";
		this.mmUtils.createECoreFile(name, name, name);
	}

	@Test
	public void testRunner() throws Exception {
		final Antlr4MyListener listener = this.utils
				.runParserAndListener(this.mmUtils);
		Assert.assertNotNull(listener);
	}

}
