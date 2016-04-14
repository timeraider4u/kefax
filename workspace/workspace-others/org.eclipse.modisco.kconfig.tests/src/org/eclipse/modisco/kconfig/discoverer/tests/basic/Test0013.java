package org.eclipse.modisco.kconfig.discoverer.tests.basic;

import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.ConfigExpr;
import org.eclipse.modisco.kconfig.Expr;
import org.eclipse.modisco.kconfig.LiteralExpr;
import org.eclipse.modisco.kconfig.Model;
import org.eclipse.modisco.kconfig.Range;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.discoverer.tests.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test0013 {
	private static final String PREFIX = "basic";
	private static final String FILE_NAME = "config.kconfig";
	private BaseTest baseTest;

	@Before
	public void setUp() throws Exception {
		this.baseTest = new BaseTest(Test0013.PREFIX,
				Test0013.class.getSimpleName());
	}

	@Test(timeout = 5 * 60 * 1000)
	public void test() throws Exception {
		final Model model = this.baseTest.getModel();
		final TranslationUnit unit = this.baseTest.getTranslationUnit(
				Test0013.FILE_NAME, 1);
		Assert.assertNotNull(unit);
		Assert.assertEquals(1, unit.getConfigs().size());
		Assert.assertEquals(2, model.getConfigs().size());
		final Config config0 = unit.getConfigs().get(0);
		final Config config1 = model.getConfigs().get(1);
		Assert.assertEquals("RCU_FANOUT", config0.getName());
		Assert.assertEquals("64BIT", config1.getName());
		this.checkConfig(config0);
	}

	private void checkConfig(Config config0) {
		Assert.assertEquals(2, config0.getRanges().size());
		this.checkRange(config0, 0, "64BIT", "2", "64", false);
		this.checkRange(config0, 1, "64BIT", "2", "32", true);
	}

	private void checkRange(final Config config, final int pos,
			final String name, final String lower, final String upper,
			boolean negated) {
		final Range range = config.getRanges().get(pos);
		Assert.assertEquals(config, range.getOwner());
		final Expr lExpr = range.getLowerExpr();
		final Expr uExpr = range.getUpperExpr();
		final Expr ifExpr = range.getIfExpr();
		Assert.assertNotNull(lExpr);
		Assert.assertNotNull(uExpr);
		Assert.assertNotNull(ifExpr);
		Assert.assertEquals(config, uExpr.getOwner());
		Assert.assertEquals(config, lExpr.getOwner());
		Assert.assertEquals(config, ifExpr.getOwner());
		Assert.assertTrue(lExpr instanceof LiteralExpr);
		Assert.assertTrue(uExpr instanceof LiteralExpr);
		Assert.assertTrue(ifExpr instanceof ConfigExpr);
		final LiteralExpr lExprLit = (LiteralExpr) lExpr;
		final LiteralExpr uExprLit = (LiteralExpr) uExpr;
		Assert.assertEquals(lower, lExprLit.getValue());
		Assert.assertEquals(upper, uExprLit.getValue());
		final ConfigExpr cExpr = (ConfigExpr) ifExpr;
		Assert.assertEquals(negated, cExpr.isNegated());
		final Config refConfig = cExpr.getRefOnConfig();
		Assert.assertNotNull(refConfig);
		Assert.assertEquals(name, refConfig.getName());
	}

}
