package org.eclipse.modisco.kconfig.discoverer.tests.basic;

import org.eclipse.modisco.kconfig.BooleanExpr;
import org.eclipse.modisco.kconfig.BooleanExprType;
import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.ConfigExpr;
import org.eclipse.modisco.kconfig.ConfigType;
import org.eclipse.modisco.kconfig.Default;
import org.eclipse.modisco.kconfig.Depend;
import org.eclipse.modisco.kconfig.Expr;
import org.eclipse.modisco.kconfig.LiteralExpr;
import org.eclipse.modisco.kconfig.Model;
import org.eclipse.modisco.kconfig.Prompt;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.TristateExpr;
import org.eclipse.modisco.kconfig.TristateValue;
import org.eclipse.modisco.kconfig.discoverer.tests.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test0015 {
	private static final String PREFIX = "basic";
	private static final String FILE_NAME = "config.kconfig";
	private BaseTest baseTest;

	@Before
	public void setUp() throws Exception {
		this.baseTest = new BaseTest(Test0015.PREFIX,
				Test0015.class.getSimpleName());
	}

	@Test(timeout = 5 * 60 * 1000)
	public void test() throws Exception {
		final Model model = this.baseTest.getModel();
		final TranslationUnit unit = this.baseTest.getTranslationUnit(
				Test0015.FILE_NAME, 1);
		Assert.assertNotNull(unit);
		Assert.assertEquals(3, unit.getConfigs().size());
		Assert.assertEquals(7, model.getConfigs().size());
		this.checkFirstConfig(unit.getConfigs().get(0));
		this.checkSecond(unit.getConfigs().get(1));
		this.checkThird(unit.getConfigs().get(2));
	}

	private void checkFirstConfig(Config config) {
		Assert.assertNotNull(config);
		Assert.assertEquals("HAVE_64BIT_ALIGNED_ACCESS", config.getName());
		Assert.assertEquals(ConfigType.BOOL, config.getType());
		Assert.assertEquals(1, config.getDefaults().size());
		final Default myDefault = config.getDefaults().get(0);
		final Expr defExpr = myDefault.getExpression();
		Assert.assertNotNull(defExpr);
		Assert.assertTrue(defExpr instanceof BooleanExpr);
		final BooleanExpr boolExpr = (BooleanExpr) defExpr;
		Assert.assertEquals(BooleanExprType.OR, boolExpr.getType());
		final Expr left = boolExpr.getLeft();
		final Expr right = boolExpr.getRight();
		Assert.assertNotNull(left);
		Assert.assertNotNull(right);
		Assert.assertTrue(left instanceof ConfigExpr);
		Assert.assertTrue(right instanceof ConfigExpr);
		final ConfigExpr leftExpr = (ConfigExpr) left;
		final ConfigExpr rightExpr = (ConfigExpr) right;
		Assert.assertEquals(config, leftExpr.getOwner());
		Assert.assertEquals(config, rightExpr.getOwner());
		Assert.assertFalse(leftExpr.isNegated());
		Assert.assertTrue(rightExpr.isNegated());
		final Config leftConf = leftExpr.getRefOnConfig();
		final Config rightConf = rightExpr.getRefOnConfig();
		Assert.assertNotNull(leftConf);
		Assert.assertNotNull(rightConf);
		Assert.assertEquals("64BIT", leftConf.getName());
		Assert.assertEquals("HAVE_EFFICIENT_UNALIGNED_ACCESS",
				rightConf.getName());
	}

	private void checkSecond(Config config) {
		Assert.assertNotNull(config);
		Assert.assertEquals("KRETPROBES", config.getName());
		Assert.assertEquals(ConfigType.BOOL, config.getType());
		Assert.assertEquals(1, config.getDefaults().size());
		final Default myDefault = config.getDefaults().get(0);
		final Expr myDefaultExpr = myDefault.getExpression();
		Assert.assertNotNull(myDefaultExpr);
		Assert.assertNull(myDefault.getIfExpr());
		Assert.assertTrue(myDefaultExpr instanceof TristateExpr);
		Assert.assertEquals(TristateValue.Y,
				((TristateExpr) myDefaultExpr).getValue());
		Assert.assertEquals(1, config.getDepends().size());
		final Depend depend = config.getDepends().get(0);
		Assert.assertEquals(config, depend.getOwner());
		final Expr expr = depend.getExpression();
		Assert.assertNotNull(expr);
		Assert.assertTrue(expr instanceof BooleanExpr);
		final BooleanExpr boolExpr = (BooleanExpr) expr;
		Assert.assertEquals(BooleanExprType.AND, boolExpr.getType());
		final Expr left = boolExpr.getLeft();
		final Expr right = boolExpr.getRight();
		Assert.assertNotNull(left);
		Assert.assertNotNull(right);
		Assert.assertEquals(config, left.getOwner());
		Assert.assertEquals(config, right.getOwner());
		Assert.assertTrue(left instanceof ConfigExpr);
		Assert.assertTrue(right instanceof ConfigExpr);
		final Config configLeft = ((ConfigExpr) left).getRefOnConfig();
		final Config configRight = ((ConfigExpr) right).getRefOnConfig();
		Assert.assertNotNull(configLeft);
		Assert.assertNotNull(configRight);
		Assert.assertEquals("KPROBES", configLeft.getName());
		Assert.assertEquals("HAVE_KRETPROBES", configRight.getName());
	}

	private void checkThird(Config config) {
		Assert.assertNotNull(config);
		Assert.assertEquals(ConfigType.BOOL, config.getType());
		Assert.assertEquals("64-bitkernel", config.getDescription());
		final Prompt prompt = config.getPrompt();
		Assert.assertEquals(config, prompt.getOwner());
		final Expr promptExpr = prompt.getExpression();
		Assert.assertNotNull(promptExpr);
		Assert.assertTrue(promptExpr instanceof BooleanExpr);
		final BooleanExpr promptBoolExpr = (BooleanExpr) promptExpr;
		Assert.assertEquals(BooleanExprType.EQUALS, promptBoolExpr.getType());
		final Expr promptLeftExpr = promptBoolExpr.getLeft();
		final Expr promptRightExpr = promptBoolExpr.getRight();
		Assert.assertNotNull(promptLeftExpr);
		Assert.assertNotNull(promptRightExpr);
		Assert.assertTrue(promptLeftExpr instanceof ConfigExpr);
		Assert.assertTrue(promptRightExpr instanceof LiteralExpr);
		final ConfigExpr promptConfigExpr = (ConfigExpr) promptLeftExpr;
		final LiteralExpr promptLitExpr = (LiteralExpr) promptRightExpr;
		final Config promptConfig = promptConfigExpr.getRefOnConfig();
		Assert.assertNotNull(promptConfig);
		Assert.assertEquals("ARCH", promptConfig.getName());
		Assert.assertEquals("x86", promptLitExpr.getValue());
		Assert.assertEquals(1, config.getDefaults().size());
		final Default myDefault = config.getDefaults().get(0);
		final Expr myDefaultExpr = myDefault.getExpression();
		Assert.assertNotNull(myDefaultExpr);
		Assert.assertNull(myDefault.getIfExpr());
		Assert.assertTrue(myDefaultExpr instanceof BooleanExpr);
		final BooleanExpr boolDefaultExpr = (BooleanExpr) myDefaultExpr;
		Assert.assertEquals(config, boolDefaultExpr.getOwner());
		Assert.assertEquals(BooleanExprType.NONEQUALS,
				boolDefaultExpr.getType());
		final Expr defaultLeftExpr = boolDefaultExpr.getLeft();
		final Expr defaultRightExpr = boolDefaultExpr.getRight();
		Assert.assertNotNull(defaultLeftExpr);
		Assert.assertNotNull(defaultRightExpr);
		Assert.assertTrue(defaultLeftExpr instanceof ConfigExpr);
		Assert.assertTrue(defaultRightExpr instanceof LiteralExpr);
		final ConfigExpr defaultConfigExpr = (ConfigExpr) defaultLeftExpr;
		final LiteralExpr defaultLitExpr = (LiteralExpr) defaultRightExpr;
		Assert.assertEquals(config, defaultConfigExpr.getOwner());
		Assert.assertEquals(promptConfig, defaultConfigExpr.getRefOnConfig());
		Assert.assertEquals(config, defaultLitExpr.getOwner());
		Assert.assertEquals("i386", defaultLitExpr.getValue());
	}
}
