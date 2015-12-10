package org.eclipse.modisco.kconfig.discoverer.tests.basic;

import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.Option;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.discoverer.tests.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test0014 {
	private static final String PREFIX = "basic";
	private static final String FILE_NAME = "config.kconfig";
	private BaseTest baseTest;

	@Before
	public void setUp() throws Exception {
		this.baseTest = new BaseTest(Test0014.PREFIX,
				Test0014.class.getSimpleName());
	}

	@Test(timeout = 5 * 60 * 1000)
	public void test() throws Exception {
		final TranslationUnit unit = this.baseTest.getTranslationUnit(
				Test0014.FILE_NAME, 1);
		Assert.assertNotNull(unit);
		Assert.assertEquals(2, unit.getConfigs().size());
		final Config config0 = unit.getConfigs().get(0);
		final Config config1 = unit.getConfigs().get(1);
		Assert.assertEquals("SRCARCH", config0.getName());
		Assert.assertEquals("ARCH", config1.getName());
		Assert.assertEquals(1, config0.getOptions().size());
		Assert.assertEquals(1, config1.getOptions().size());
		final Option option0 = config0.getOptions().get(0);
		final Option option1 = config1.getOptions().get(0);
		Assert.assertEquals("env", option0.getName());
		Assert.assertEquals("env", option1.getName());
		Assert.assertEquals("SRCARCH", option0.getValue());
		Assert.assertEquals("ARCH", option1.getValue());
	}
}
