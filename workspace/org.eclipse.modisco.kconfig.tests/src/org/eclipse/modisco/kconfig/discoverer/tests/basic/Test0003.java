package org.eclipse.modisco.kconfig.discoverer.tests.basic;

import org.eclipse.modisco.kconfig.ConfigType;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.discoverer.tests.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test0003 {
	private static final String PREFIX = "basic";
	private static final String FILE_NAME = "config.kconfig";
	private BaseTest baseTest;

	@Before
	public void setUp() throws Exception {
		this.baseTest = new BaseTest(Test0003.PREFIX,
				Test0003.class.getSimpleName());
	}

	@Test(timeout = 5 * 60 * 1000)
	public void test() throws Exception {
		final TranslationUnit unit = this.baseTest.getTranslationUnit(
				Test0003.FILE_NAME, 1);
		Assert.assertEquals(9, unit.getConfigs().size());
		Assert.assertEquals("HAVE_KPROBES", unit.getConfigs().get(0).getName());
		Assert.assertEquals(ConfigType.BOOL, unit.getConfigs().get(0).getType());
		Assert.assertEquals("OUTPUT_FORMAT", unit.getConfigs().get(1).getName());
		Assert.assertEquals(ConfigType.STRING, unit.getConfigs().get(1)
				.getType());
		Assert.assertEquals("HAVE_DMA_CONTIGUOUS", unit.getConfigs().get(2)
				.getName());
		Assert.assertEquals(ConfigType.BOOL, unit.getConfigs().get(2).getType());
		Assert.assertEquals("NR_CPUS", unit.getConfigs().get(3).getName());
		Assert.assertEquals(ConfigType.INT, unit.getConfigs().get(3).getType());
		Assert.assertEquals("GENERIC_SMP_IDLE_THREAD", unit.getConfigs().get(4)
				.getName());
		Assert.assertEquals(ConfigType.BOOL, unit.getConfigs().get(4).getType());
		Assert.assertEquals("ILLEGAL_POINTER_VALUE", unit.getConfigs().get(5)
				.getName());
		Assert.assertEquals(ConfigType.HEX, unit.getConfigs().get(5).getType());
		Assert.assertEquals("OPROFILE", unit.getConfigs().get(6).getName());
		Assert.assertEquals(ConfigType.TRISTATE, unit.getConfigs().get(6)
				.getType());
		Assert.assertEquals("GENERIC_IDLE_POLL_SETUP", unit.getConfigs().get(7)
				.getName());
		Assert.assertEquals(ConfigType.BOOL, unit.getConfigs().get(7).getType());
		Assert.assertEquals("IOSF_MBI", unit.getConfigs().get(8).getName());
		Assert.assertEquals(ConfigType.TRISTATE, unit.getConfigs().get(8)
				.getType());
	}

}
