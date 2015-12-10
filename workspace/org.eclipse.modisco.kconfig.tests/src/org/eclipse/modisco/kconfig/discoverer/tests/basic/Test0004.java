package org.eclipse.modisco.kconfig.discoverer.tests.basic;

import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.discoverer.tests.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test0004 {
	private static final String PREFIX = "basic";
	private static final String FILE_NAME = "config.kconfig";
	private BaseTest baseTest;

	@Before
	public void setUp() throws Exception {
		this.baseTest = new BaseTest(Test0004.PREFIX,
				Test0004.class.getSimpleName());
	}

	@Test(timeout = 5 * 60 * 1000)
	public void test() throws Exception {
		final TranslationUnit unit = this.baseTest.getTranslationUnit(
				Test0004.FILE_NAME, 1);
		Assert.assertEquals(3, unit.getConfigs().size());
		final Config config = unit.getConfigs().get(0);
		Assert.assertEquals("OPROFILE", config.getName());
		Assert.assertEquals("OProfilesystemprofiling", config.getDescription());
		final Config config1 = unit.getConfigs().get(1);
		Assert.assertEquals("HAVE_OPROFILE", config1.getName());
		Assert.assertEquals("", config1.getDescription());
		final Config config2 = unit.getConfigs().get(2);
		Assert.assertEquals("KPROBES", config2.getName());
		Assert.assertEquals("Kprobes", config2.getDescription());
	}

}
