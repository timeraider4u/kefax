package org.eclipse.modisco.kconfig.discoverer.tests.basic;

import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.ConfigExpr;
import org.eclipse.modisco.kconfig.Depend;
import org.eclipse.modisco.kconfig.Expr;
import org.eclipse.modisco.kconfig.Model;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.discoverer.tests.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test0006 {
	private static final String PREFIX = "basic";
	private static final String FILE_NAME = "config.kconfig";
	private BaseTest baseTest;

	@Before
	public void setUp() throws Exception {
		this.baseTest = new BaseTest(Test0006.PREFIX,
				Test0006.class.getSimpleName());
	}

	@Test(timeout = 5 * 60 * 1000)
	public void test() throws Exception {
		final TranslationUnit unit = this.baseTest.getTranslationUnit(
				Test0006.FILE_NAME, 1);
		Assert.assertEquals(4, unit.getConfigs().size());
		this.checkConfig0(unit);
		this.checkConfig1(unit);
		this.checkConfig2(unit);
		this.checkConfig3(unit);
		this.checkModelConfigs(unit);
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
		Assert.assertEquals("X86_64", refConf.getName());
		Assert.assertFalse(dependsOn.isNegated());
	}

	private void checkConfig2(final TranslationUnit unit) {
		final Config config2 = unit.getConfigs().get(2);
		Assert.assertEquals("X86_32", config2.getName());
		Assert.assertEquals(1, config2.getDepends().size());
		final Depend depend = config2.getDepends().get(0);
		final Expr depends2 = depend.getExpression();
		Assert.assertTrue(depends2 instanceof ConfigExpr);
		final ConfigExpr dependsOn = (ConfigExpr) depends2;
		Assert.assertNotNull(dependsOn.getRefOnConfig());
		final Config refConf = dependsOn.getRefOnConfig();
		Assert.assertEquals("64BIT", refConf.getName());
		Assert.assertTrue(dependsOn.isNegated());
	}

	private void checkConfig3(final TranslationUnit unit) {
		final Config config3 = unit.getConfigs().get(3);
		Assert.assertEquals("X86_64", config3.getName());
		Assert.assertEquals(1, config3.getDepends().size());
		final Depend depend = config3.getDepends().get(0);
		final Expr depends3 = depend.getExpression();
		Assert.assertTrue(depends3 instanceof ConfigExpr);
		final ConfigExpr dependsOn = (ConfigExpr) depends3;
		Assert.assertNotNull(dependsOn.getRefOnConfig());
		final Config refConf = dependsOn.getRefOnConfig();
		Assert.assertEquals("64BIT", refConf.getName());
		Assert.assertFalse(dependsOn.isNegated());
	}

	/***
	 * # | UNIT | Model <br/>
	 * 0 | X86 | X86 <br/>
	 * 1 | QPROFILE | QPROFILE <br/>
	 * 2 | X86_32 | X86_64<br/>
	 * 3 | X86_64 | X86_32<br/>
	 * 4 | -------- | 64BIT <br/>
	 */
	private void checkModelConfigs(final TranslationUnit unit) {
		final Model model = this.baseTest.getModel();
		final Config unitConfig0 = unit.getConfigs().get(0);
		final Config unitConfig1 = unit.getConfigs().get(1);
		final Config unitConfig2 = unit.getConfigs().get(2);
		final Config unitConfig3 = unit.getConfigs().get(3);
		Assert.assertEquals(5, model.getConfigs().size());
		final Config modelConfig0 = model.getConfigs().get(0);
		final Config modelConfig1 = model.getConfigs().get(1);
		final Config modelConfig2 = model.getConfigs().get(2);
		final Config modelConfig3 = model.getConfigs().get(3);
		final Config modelConfig4 = model.getConfigs().get(4);
		Assert.assertEquals(unitConfig0, modelConfig0);
		Assert.assertEquals(unitConfig1, modelConfig1);
		// X86_32 is added after
		// X86_64 to model
		// (depends->lookUp()->create()
		Assert.assertEquals(unitConfig2, modelConfig3);
		// X86_64 is added at
		// least in model
		Assert.assertEquals(unitConfig3, modelConfig2);
		final Depend depend1 = unitConfig1.getDepends().get(0);
		final Depend depend2 = unitConfig2.getDepends().get(0);
		final Depend depend3 = unitConfig3.getDepends().get(0);
		Assert.assertNotNull(depend1);
		Assert.assertNotNull(depend2);
		Assert.assertNotNull(depend3);
		final ConfigExpr expr1 = (ConfigExpr) depend1.getExpression();
		final ConfigExpr expr2 = (ConfigExpr) depend2.getExpression();
		final ConfigExpr expr3 = (ConfigExpr) depend3.getExpression();
		final Config ref1 = expr1.getRefOnConfig();
		final Config ref2 = expr2.getRefOnConfig();
		final Config ref3 = expr3.getRefOnConfig();
		Assert.assertNotNull(ref1);
		Assert.assertNotNull(ref2);
		Assert.assertNotNull(ref3);
		Assert.assertEquals("X86_64", ref1.getName());
		Assert.assertEquals("64BIT", ref2.getName());
		Assert.assertEquals("64BIT", ref3.getName());
		Assert.assertEquals(unitConfig3, ref1);
		Assert.assertEquals(modelConfig2, ref1);
		Assert.assertEquals(modelConfig4, ref2);
		Assert.assertEquals(modelConfig4, ref3);
		Assert.assertEquals(unit, ref1.getDefinedIn());
		Assert.assertNull(ref2.getDefinedIn());

	}
}
