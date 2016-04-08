package org.eclipse.modisco.kconfig.discoverer.tests.basic;

import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.ConfigExpr;
import org.eclipse.modisco.kconfig.ConfigType;
import org.eclipse.modisco.kconfig.Depend;
import org.eclipse.modisco.kconfig.Expr;
import org.eclipse.modisco.kconfig.Model;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.discoverer.tests.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test0016 {
	private static final String SRC_ARCH = "arch/$SRCARCH/Kconfig";
	private static final String PREFIX = "basic";
	private static final String FILE_NAME = "config.kconfig";
	private static final String FILE_NAME_2 = "distro/Kconfig";

	private BaseTest baseTest;

	@Before
	public void setUp() throws Exception {
		this.baseTest = new BaseTest(Test0016.PREFIX,
				Test0016.class.getSimpleName());
	}

	@Test(timeout = 5 * 60 * 1000)
	public void test() throws Exception {
		final Model model = this.baseTest.getModel();
		final TranslationUnit unit = this.baseTest.getTranslationUnit(
				Test0016.FILE_NAME, 3);
		Assert.assertEquals(3, model.getUnits().size());
		final TranslationUnit srcArch = model.getUnits().get(1);
		final TranslationUnit unit2 = model.getUnits().get(2);
		this.checkUnit(model, unit, unit2, srcArch);
		this.checkSecondUnit(model, unit2);
		this.checkSourceArch(srcArch);
		Assert.assertEquals(2, model.getConfigs().size());
	}

	private void checkUnit(final Model model, final TranslationUnit unit,
			final TranslationUnit unit2, final TranslationUnit srcArch) {
		Assert.assertNotNull(unit);
		Assert.assertEquals(Test0016.FILE_NAME, unit.getName());
		Assert.assertNotNull(unit2.getFullPath());
		Assert.assertFalse(unit2.getFullPath().isEmpty());
		Assert.assertNotSame(unit2.getFullPath(), unit2.getName());
		Assert.assertEquals(1, unit.getConfigs().size());
		final Config config = unit.getConfigs().get(0);
		Assert.assertEquals("MY", config.getName());
		Assert.assertEquals(ConfigType.BOOL, config.getType());
		Assert.assertEquals(unit, config.getDefinedIn());
		Assert.assertEquals(1, config.getDepends().size());
		final Depend depend = config.getDepends().get(0);
		final Expr expr = depend.getExpression();
		Assert.assertNotNull(expr);
		Assert.assertTrue(expr instanceof ConfigExpr);
		final ConfigExpr cExpr = (ConfigExpr) expr;
		Assert.assertEquals(config, cExpr.getOwner());
		final Config other = cExpr.getRefOnConfig();
		Assert.assertNotNull(other);
		Assert.assertEquals("OTHER", other.getName());
		Assert.assertEquals(unit2, other.getDefinedIn());
		Assert.assertEquals(model, other.getOwner());
		Assert.assertEquals(model, unit.getUnitOwner());
		Assert.assertEquals(2, unit.getSources().size());
		final TranslationUnit source1 = unit.getSources().get(0);
		final TranslationUnit source2 = unit.getSources().get(1);
		Assert.assertEquals(Test0016.SRC_ARCH, source1.getName());
		Assert.assertEquals(Test0016.FILE_NAME_2, source2.getName());
		Assert.assertEquals(srcArch, source1);
		Assert.assertEquals(unit2, source2);
	}

	private void checkSecondUnit(final Model model, final TranslationUnit unit2) {
		Assert.assertNotNull(unit2);
		Assert.assertNotNull(unit2.getFullPath());
		Assert.assertFalse(unit2.getFullPath().isEmpty());
		Assert.assertNotSame(unit2.getFullPath(), unit2.getName());
		Assert.assertEquals(Test0016.FILE_NAME_2, unit2.getName());
		Assert.assertEquals(1, unit2.getConfigs().size());
		final Config config = unit2.getConfigs().get(0);
		Assert.assertEquals("OTHER", config.getName());
		Assert.assertEquals(ConfigType.BOOL, config.getType());
		Assert.assertEquals(unit2, config.getDefinedIn());
		Assert.assertEquals(0, unit2.getSources().size());
		Assert.assertEquals(model, unit2.getUnitOwner());
	}

	private void checkSourceArch(final TranslationUnit srcArch) {
		Assert.assertEquals(Test0016.SRC_ARCH, srcArch.getName());
		Assert.assertNotNull(srcArch.getName());
		Assert.assertNull(srcArch.getFullPath());
	}
}
