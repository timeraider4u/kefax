package org.eclipse.modisco.kconfig.discoverer.tests.basic;

import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.ConfigExpr;
import org.eclipse.modisco.kconfig.Depend;
import org.eclipse.modisco.kconfig.Expr;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.discoverer.tests.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test0007 {
	private static final String PREFIX = "basic";
	private static final String FILE_NAME = "config.kconfig";
	private BaseTest baseTest;

	@Before
	public void setUp() throws Exception {
		this.baseTest = new BaseTest(Test0007.PREFIX,
				Test0007.class.getSimpleName());
	}

	@Test(timeout = 5 * 60 * 1000)
	public void test() throws Exception {
		final TranslationUnit unit = this.baseTest.getTranslationUnit(
				Test0007.FILE_NAME, 1);
		Assert.assertEquals(2, unit.getConfigs().size());
		this.checkConfig0(unit);
		this.checkConfig1(unit);
	}

	private void checkConfig0(final TranslationUnit unit) {
		final Config config = unit.getConfigs().get(0);
		Assert.assertEquals("X86", config.getName());
		Assert.assertEquals(0, config.getDepends().size());
	}

	private void checkConfig1(final TranslationUnit unit) {
		final Config config1 = unit.getConfigs().get(1);
		Assert.assertEquals("OPROFILE", config1.getName());
		Assert.assertEquals(1, config1.getDepends().size());
		final Depend depend = config1.getDepends().get(0);
		final Expr depends1 = depend.getExpression();
		Assert.assertTrue(depends1 instanceof ConfigExpr);
		final ConfigExpr dependsOn = (ConfigExpr) depends1;
		final Config refConf = dependsOn.getRefOnConfig();
		Assert.assertNotNull(dependsOn.getRefOnConfig());
		Assert.assertEquals("X86", refConf.getName());
		Assert.assertFalse(dependsOn.isNegated());
	}

}
