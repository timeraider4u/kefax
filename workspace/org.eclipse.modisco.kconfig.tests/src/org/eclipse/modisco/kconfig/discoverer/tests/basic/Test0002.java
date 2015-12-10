package org.eclipse.modisco.kconfig.discoverer.tests.basic;

import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.ConfigType;
import org.eclipse.modisco.kconfig.Model;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.discoverer.tests.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test0002 {
	private static final String PREFIX = "basic";
	private static final String FILE_NAME = "config.kconfig";
	private BaseTest baseTest;
	private Model model;

	@Before
	public void setUp() throws Exception {
		this.baseTest = new BaseTest(Test0002.PREFIX,
				Test0002.class.getSimpleName());
	}

	@Test(timeout = 5 * 60 * 1000)
	public void test() throws Exception {
		this.model = this.baseTest.getModel();
		Assert.assertNotNull(this.model);
		Assert.assertEquals(1, this.model.getConfigs().size());
		final Config configFromModel = this.model.getConfigs().get(0);
		Assert.assertEquals("HAVE_KPROBES", configFromModel.getName());
		Assert.assertEquals(ConfigType.BOOL, configFromModel.getType());
		Assert.assertEquals(this.model, configFromModel.getOwner());
		final TranslationUnit unit = this.baseTest.getTranslationUnit(
				Test0002.FILE_NAME, 1);
		Assert.assertEquals(1, unit.getConfigs().size());
		final Config configFromUnit = unit.getConfigs().get(0);
		Assert.assertEquals("HAVE_KPROBES", configFromUnit.getName());
		Assert.assertEquals(ConfigType.BOOL, configFromUnit.getType());
		Assert.assertEquals(this.model, configFromUnit.getOwner());
		Assert.assertEquals(unit, configFromUnit.getDefinedIn());
		Assert.assertEquals(configFromModel, configFromUnit);
	}

}
