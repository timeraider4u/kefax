package org.eclipse.modisco.cdt.discoverer.tests.basic;

import java.io.IOException;

import org.eclipse.modisco.cdt.discoverer.tests.TestUtils;
import org.junit.Before;
import org.junit.Test;

public class TestCdt0001 {
	private TestUtils baseTest;

	@Before
	public void setUp() throws Exception {
		this.baseTest = new TestUtils(TestCdt0001.class.getSimpleName());
	}

	@Test(timeout = 5 * 60 * 1000)
	public void test0001() throws IOException {
		this.baseTest.compareModels();
	}
}
