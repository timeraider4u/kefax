package org.eclipse.modisco.cdt.discoverer.tests.basic;

import org.eclipse.modisco.cdt.discoverer.tests.TestUtils;

import at.jku.weiner.c.common.common.Model;

public class EMFTest {
	
	public static Model emfTest(final String fileName) throws Exception {
		final TestUtils utils = new TestUtils(fileName);
		final Model result = utils.getModel();
		return result;
	}
	
}
