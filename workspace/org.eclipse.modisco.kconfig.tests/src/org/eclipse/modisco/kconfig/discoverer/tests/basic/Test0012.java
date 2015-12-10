package org.eclipse.modisco.kconfig.discoverer.tests.basic;

import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.ConfigExpr;
import org.eclipse.modisco.kconfig.Expr;
import org.eclipse.modisco.kconfig.Model;
import org.eclipse.modisco.kconfig.Select;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.discoverer.tests.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test0012 {
	private static final String PREFIX = "basic";
	private static final String FILE_NAME = "config.kconfig";
	private BaseTest baseTest;

	@Before
	public void setUp() throws Exception {
		this.baseTest = new BaseTest(Test0012.PREFIX,
				Test0012.class.getSimpleName());
	}

	@Test(timeout = 5 * 60 * 1000)
	public void test() throws Exception {
		final Model model = this.baseTest.getModel();
		final TranslationUnit unit = this.baseTest.getTranslationUnit(
				Test0012.FILE_NAME, 1);
		Assert.assertNotNull(unit);
		Assert.assertEquals(1, unit.getConfigs().size());
		Assert.assertEquals(6, model.getConfigs().size());
		final Config config0 = unit.getConfigs().get(0);
		final Config config1 = model.getConfigs().get(1);
		final Config config2 = model.getConfigs().get(2);
		final Config config3 = model.getConfigs().get(3);
		final Config config4 = model.getConfigs().get(4);
		final Config config5 = model.getConfigs().get(5);
		Assert.assertEquals("GENTOO_LINUX_UDEV", config0.getName());
		Assert.assertEquals("DEVTMPFS", config1.getName());
		Assert.assertEquals("TMPFS", config2.getName());
		Assert.assertEquals("FHANDLE", config3.getName());
		Assert.assertEquals("MMU", config4.getName());
		Assert.assertEquals("SHMEM", config5.getName());
		this.checkConfig(config0);
	}

	private void checkConfig(Config config0) {
		Assert.assertEquals(5, config0.getSelects().size());
		this.checkSelect(config0, 0, "DEVTMPFS");
		this.checkSelectIfExprIsNull(config0, 0);
		this.checkSelect(config0, 1, "TMPFS");
		this.checkSelectIfExprIsNull(config0, 1);
		this.checkSelect(config0, 2, "FHANDLE");
		this.checkSelectIfExprIsNull(config0, 2);
		this.checkSelect(config0, 3, "MMU");
		this.checkSelectIfExprIsNull(config0, 3);
		this.checkSelect(config0, 4, "SHMEM");
		final Expr expr = config0.getSelects().get(4).getIfExpr();
		Assert.assertNotNull(expr);
		Assert.assertTrue(expr instanceof ConfigExpr);
		final ConfigExpr cExpr = (ConfigExpr) expr;
		final Config config = cExpr.getRefOnConfig();
		Assert.assertNotNull(config);
		Assert.assertEquals("DEVTMPFS", config.getName());
	}

	private void checkSelect(final Config config, final int pos,
			final String name) {
		final Select select = config.getSelects().get(pos);
		final Expr expr = select.getExpression();
		Assert.assertNotNull(expr);
		Assert.assertEquals(config, expr.getOwner());
		Assert.assertTrue(expr instanceof ConfigExpr);
		final ConfigExpr cExpr = (ConfigExpr) expr;
		final Config refConfig = cExpr.getRefOnConfig();
		Assert.assertNotNull(refConfig);
		Assert.assertEquals(name, refConfig.getName());
	}

	private void checkSelectIfExprIsNull(final Config config, final int pos) {
		final Select select = config.getSelects().get(pos);
		Assert.assertNull(select.getIfExpr());
	}
}
