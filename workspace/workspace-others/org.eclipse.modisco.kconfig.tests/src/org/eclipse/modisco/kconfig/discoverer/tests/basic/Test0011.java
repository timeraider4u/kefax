package org.eclipse.modisco.kconfig.discoverer.tests.basic;

import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.ConfigExpr;
import org.eclipse.modisco.kconfig.Default;
import org.eclipse.modisco.kconfig.Expr;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.TristateExpr;
import org.eclipse.modisco.kconfig.TristateValue;
import org.eclipse.modisco.kconfig.discoverer.tests.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test0011 {
	private static final String PREFIX = "basic";
	private static final String FILE_NAME = "config.kconfig";
	private BaseTest baseTest;

	@Before
	public void setUp() throws Exception {
		this.baseTest = new BaseTest(Test0011.PREFIX,
				Test0011.class.getSimpleName());
	}

	@Test(timeout = 5 * 60 * 1000)
	public void test() throws Exception {
		final TranslationUnit unit = this.baseTest.getTranslationUnit(
				Test0011.FILE_NAME, 1);
		Assert.assertEquals(3, unit.getConfigs().size());
		final Config config0 = unit.getConfigs().get(0);
		final Config config1 = unit.getConfigs().get(1);
		final Config config2 = unit.getConfigs().get(2);
		Assert.assertNotNull(config0);
		Assert.assertNotNull(config1);
		Assert.assertNotNull(config2);
		Assert.assertEquals("MYTEST", config0.getName());
		Assert.assertEquals("MYTEST_2", config1.getName());
		Assert.assertEquals("MYTEST_3", config2.getName());
		this.checkDefaultValues(config0, config1, config2);
	}

	private void checkDefaultValues(final Config config0, final Config config1,
			final Config config2) {
		Assert.assertEquals(1, config0.getDefaults().size());
		Assert.assertEquals(3, config1.getDefaults().size());
		Assert.assertEquals(1, config2.getDefaults().size());
		final Default default0 = config0.getDefaults().get(0);
		final Default default1a = config1.getDefaults().get(0);
		final Default default1b = config1.getDefaults().get(1);
		final Default default1c = config1.getDefaults().get(2);
		final Default default2 = config2.getDefaults().get(0);
		Assert.assertNotNull(default0);
		Assert.assertNotNull(default1a);
		Assert.assertNotNull(default1b);
		Assert.assertNotNull(default1c);
		Assert.assertNotNull(default2);
		Assert.assertEquals(config0, default0.getOwner());
		Assert.assertEquals(config1, default1a.getOwner());
		Assert.assertEquals(config1, default1b.getOwner());
		Assert.assertEquals(config1, default1c.getOwner());
		Assert.assertEquals(config2, default2.getOwner());
		final Expr expr0 = default0.getExpression();
		final Expr expr1a = default1a.getExpression();
		final Expr expr1b = default1b.getExpression();
		final Expr expr1c = default1c.getExpression();
		final Expr expr2 = default2.getExpression();
		final Expr ifExpr1b = default1b.getIfExpr();
		final Expr ifExpr1c = default1c.getIfExpr();
		final Expr ifExpr2 = default2.getIfExpr();
		Assert.assertNotNull(expr0);
		Assert.assertNull(default0.getIfExpr());
		Assert.assertNotNull(expr1a);
		Assert.assertNotNull(expr1b);
		Assert.assertNotNull(expr1c);
		Assert.assertNull(default1a.getIfExpr());
		Assert.assertNotNull(ifExpr1b);
		Assert.assertNotNull(ifExpr1c);
		Assert.assertNotNull(expr2);
		Assert.assertNotNull(ifExpr2);
		Assert.assertEquals(config0, expr0.getOwner());
		Assert.assertEquals(config1, expr1a.getOwner());
		Assert.assertEquals(config1, expr1b.getOwner());
		Assert.assertEquals(config1, expr1c.getOwner());
		Assert.assertEquals(config1, ifExpr1b.getOwner());
		Assert.assertEquals(config1, ifExpr1c.getOwner());
		Assert.assertEquals(config2, expr2.getOwner());
		Assert.assertEquals(config2, ifExpr2.getOwner());
		Assert.assertTrue(expr0 instanceof TristateExpr);
		Assert.assertTrue(expr1a instanceof TristateExpr);
		Assert.assertTrue(expr1b instanceof TristateExpr);
		Assert.assertTrue(expr1c instanceof TristateExpr);
		Assert.assertTrue(expr2 instanceof TristateExpr);
		final TristateExpr exprExpr0 = (TristateExpr) expr0;
		final TristateExpr exprExpr1a = (TristateExpr) expr1a;
		final TristateExpr exprExpr1b = (TristateExpr) expr1b;
		final TristateExpr exprExpr1c = (TristateExpr) expr1c;
		final TristateExpr exprExpr2 = (TristateExpr) expr2;
		Assert.assertEquals(TristateValue.Y, exprExpr0.getValue());
		Assert.assertEquals(TristateValue.M, exprExpr1a.getValue());
		Assert.assertEquals(TristateValue.N, exprExpr1b.getValue());
		Assert.assertEquals(TristateValue.N, exprExpr1c.getValue());
		Assert.assertEquals(TristateValue.Y, exprExpr2.getValue());
		Assert.assertTrue(ifExpr1b instanceof ConfigExpr);
		Assert.assertTrue(ifExpr1c instanceof ConfigExpr);
		final ConfigExpr configExpr1b = (ConfigExpr) ifExpr1b;
		final ConfigExpr configExpr1c = (ConfigExpr) ifExpr1c;
		Assert.assertNotNull(configExpr1b);
		Assert.assertNotNull(configExpr1c);
		final Config refConfig1b = configExpr1b.getRefOnConfig();
		final Config refConfig1c = configExpr1c.getRefOnConfig();
		Assert.assertNotNull(refConfig1b);
		Assert.assertNotNull(refConfig1c);
		Assert.assertEquals("MYTEST", refConfig1b.getName());
		Assert.assertEquals("MYTEST_3", refConfig1c.getName());
		Assert.assertTrue(ifExpr2 instanceof ConfigExpr);
		final ConfigExpr configExpr = (ConfigExpr) ifExpr2;
		Assert.assertNotNull(configExpr);
		final Config refConfig = configExpr.getRefOnConfig();
		Assert.assertNotNull(refConfig);
		Assert.assertEquals("MYTEST", refConfig.getName());
	}

}
