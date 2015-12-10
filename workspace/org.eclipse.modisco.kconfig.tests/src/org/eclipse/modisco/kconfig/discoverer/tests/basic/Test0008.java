package org.eclipse.modisco.kconfig.discoverer.tests.basic;

import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.ConfigExpr;
import org.eclipse.modisco.kconfig.Expr;
import org.eclipse.modisco.kconfig.Prompt;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.discoverer.tests.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test0008 {
	private static final String PREFIX = "basic";
	private static final String FILE_NAME = "config.kconfig";
	private BaseTest baseTest;

	@Before
	public void setUp() throws Exception {
		this.baseTest = new BaseTest(Test0008.PREFIX,
				Test0008.class.getSimpleName());
	}

	@Test(timeout = 5 * 60 * 1000)
	public void test() throws Exception {
		final TranslationUnit unit = this.baseTest.getTranslationUnit(
				Test0008.FILE_NAME, 1);
		Assert.assertEquals(3, unit.getConfigs().size());
		final Config config0 = unit.getConfigs().get(0);
		final Config config1 = unit.getConfigs().get(1);
		final Config config2 = unit.getConfigs().get(2);
		Assert.assertNotNull(config0);
		Assert.assertNotNull(config1);
		Assert.assertNotNull(config2);
		Assert.assertEquals("Networkingsupport1", config0.getDescription());
		Assert.assertEquals("Networkingsupport2", config1.getDescription());
		Assert.assertEquals("Networkingsupport3", config2.getDescription());
		this.checkPrompts(config0, config1, config2);

	}

	private void checkPrompts(final Config config0, final Config config1,
			final Config config2) {
		final Prompt prompt0 = config0.getPrompt();
		final Prompt prompt1 = config1.getPrompt();
		final Prompt prompt2 = config2.getPrompt();
		Assert.assertNull(prompt0);
		Assert.assertNull(prompt1);
		Assert.assertNotNull(prompt2);
		final Expr expr = prompt2.getExpression();
		Assert.assertNotNull(expr);
		Assert.assertTrue(expr instanceof ConfigExpr);
		final ConfigExpr cExpr = (ConfigExpr) expr;
		final Config ref = cExpr.getRefOnConfig();
		Assert.assertNotNull(ref);
		Assert.assertEquals(config0, ref);
	}
}
