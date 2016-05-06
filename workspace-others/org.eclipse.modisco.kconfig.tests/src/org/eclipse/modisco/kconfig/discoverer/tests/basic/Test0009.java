package org.eclipse.modisco.kconfig.discoverer.tests.basic;

import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.ConfigExpr;
import org.eclipse.modisco.kconfig.Default;
import org.eclipse.modisco.kconfig.Expr;
import org.eclipse.modisco.kconfig.LiteralExpr;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.TristateExpr;
import org.eclipse.modisco.kconfig.TristateValue;
import org.eclipse.modisco.kconfig.discoverer.tests.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test0009 {
	private static final String PREFIX = "basic";
	private static final String FILE_NAME = "config.kconfig";
	private BaseTest baseTest;

	@Before
	public void setUp() throws Exception {
		this.baseTest = new BaseTest(Test0009.PREFIX,
				Test0009.class.getSimpleName());
	}

	@Test(timeout = 5 * 60 * 1000)
	public void test() throws Exception {
		final TranslationUnit unit = this.baseTest.getTranslationUnit(
				Test0009.FILE_NAME, 1);
		Assert.assertEquals(3, unit.getConfigs().size());
		final Config config0 = unit.getConfigs().get(0);
		final Config config1 = unit.getConfigs().get(1);
		final Config config2 = unit.getConfigs().get(2);
		Assert.assertNotNull(config0);
		Assert.assertNotNull(config1);
		Assert.assertNotNull(config2);
		Assert.assertEquals("MYTEST", config0.getName());
		Assert.assertEquals("NR_CPUS", config1.getName());
		Assert.assertEquals("NET_N2", config2.getName());
		this.checkDefaultValues(config0, config1, config2);
	}

	private void checkDefaultValues(final Config config0, final Config config1,
			final Config config2) {
		Assert.assertEquals(1, config0.getDefaults().size());
		Assert.assertEquals(1, config1.getDefaults().size());
		Assert.assertEquals(1, config2.getDefaults().size());
		final Default default0 = config0.getDefaults().get(0);
		final Default default1 = config1.getDefaults().get(0);
		final Default default2 = config2.getDefaults().get(0);
		Assert.assertNotNull(default0);
		Assert.assertNotNull(default1);
		Assert.assertNotNull(default2);
		Assert.assertEquals(config0, default0.getOwner());
		Assert.assertEquals(config1, default1.getOwner());
		Assert.assertEquals(config2, default2.getOwner());
		final Expr expr0 = default0.getExpression();
		final Expr expr1 = default1.getExpression();
		final Expr expr2 = default2.getExpression();
		final Expr ifExpr2 = default2.getIfExpr();
		Assert.assertNotNull(expr0);
		Assert.assertNull(default0.getIfExpr());
		Assert.assertNotNull(expr1);
		Assert.assertNull(default1.getIfExpr());
		Assert.assertNotNull(expr2);
		Assert.assertNotNull(ifExpr2);
		Assert.assertEquals(config0, expr0.getOwner());
		Assert.assertEquals(config1, expr1.getOwner());
		Assert.assertEquals(config2, expr2.getOwner());
		Assert.assertEquals(config2, ifExpr2.getOwner());
		Assert.assertTrue(expr0 instanceof TristateExpr);
		Assert.assertTrue(expr1 instanceof LiteralExpr);
		Assert.assertTrue(expr2 instanceof TristateExpr);
		final TristateExpr exprExpr0 = (TristateExpr) expr0;
		final LiteralExpr exprExpr1 = (LiteralExpr) expr1;
		final TristateExpr exprExpr2 = (TristateExpr) expr2;
		Assert.assertEquals(TristateValue.Y, exprExpr0.getValue());
		Assert.assertEquals("4096", exprExpr1.getValue());
		Assert.assertEquals(TristateValue.Y, exprExpr2.getValue());
		Assert.assertTrue(ifExpr2 instanceof ConfigExpr);
		final ConfigExpr configExpr = (ConfigExpr) ifExpr2;
		Assert.assertNotNull(configExpr);
		final Config refConfig = configExpr.getRefOnConfig();
		Assert.assertNotNull(refConfig);
		Assert.assertEquals("NR_CPUS", refConfig.getName());
	}

}
