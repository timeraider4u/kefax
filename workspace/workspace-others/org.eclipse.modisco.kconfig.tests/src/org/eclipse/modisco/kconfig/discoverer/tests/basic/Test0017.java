package org.eclipse.modisco.kconfig.discoverer.tests.basic;

import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.Model;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.discoverer.tests.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test0017 {
	private static final String PREFIX = "basic";
	private static final String FILE_NAME = "config.kconfig";
	private BaseTest baseTest;

	@Before
	public void setUp() throws Exception {
		this.baseTest = new BaseTest(Test0017.PREFIX,
				Test0017.class.getSimpleName());
	}

	@Test(timeout = 5 * 60 * 1000)
	public void test() throws Exception {
		final Model model = this.baseTest.getModel();
		final String path = model.getFullPath();
		Assert.assertNotNull(path);
		Assert.assertFalse(path.isEmpty());
		final TranslationUnit unit = this.baseTest.getTranslationUnit(
				Test0017.FILE_NAME, 1);
		Assert.assertNotNull(unit);
		Assert.assertEquals(3, unit.getConfigs().size());
		final Config config0 = unit.getConfigs().get(0);
		final Config config1 = unit.getConfigs().get(1);
		final Config config2 = unit.getConfigs().get(2);
		Assert.assertEquals("IRQ_WORK", config0.getName());
		Assert.assertEquals("BROKEN", config1.getName());
		Assert.assertEquals("PREEMPT_NOTIFIERS", config2.getName());
	}
}
