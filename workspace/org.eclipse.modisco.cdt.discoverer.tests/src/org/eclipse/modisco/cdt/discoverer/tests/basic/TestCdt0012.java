package org.eclipse.modisco.cdt.discoverer.tests.basic;

import org.eclipse.modisco.cdt.discoverer.tests.TestUtils;
import org.junit.Before;
import org.junit.Test;

public class TestCdt0012 {

	private TestUtils baseTest;

	@Before
	public void setUp() throws Exception {
		this.baseTest = new TestUtils(TestCdt0012.class.getSimpleName());
	}

	@Test(timeout = 5 * 60 * 1000)
	public void test0012() throws Exception {
		this.baseTest.compareModels();
	}

}
