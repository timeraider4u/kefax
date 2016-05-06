package org.eclipse.modisco.kconfig.discoverer.tests.basic;

import org.eclipse.modisco.kconfig.Model;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.discoverer.tests.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test0001 {
	private static final String PREFIX = "basic";
	private static final String FILE_NAME = "config.kconfig";
	private BaseTest baseTest;

	@Before
	public void setUp() throws Exception {
		this.baseTest = new BaseTest(Test0001.PREFIX,
				Test0001.class.getSimpleName());
	}

	@Test(timeout = 5 * 60 * 1000)
	public void test() throws Exception {
		final Model model = this.baseTest.getModel();
		final String path = model.getFullPath();
		Assert.assertNotNull(path);
		Assert.assertFalse(path.isEmpty());
		final TranslationUnit unit = this.baseTest.getTranslationUnit(
				Test0001.FILE_NAME, 1);
		Assert.assertNotNull(unit);
	}
}
