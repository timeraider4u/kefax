package org.eclipse.modisco.cdt.discoverer.tests;

import at.jku.weiner.c.common.common.Model;

public class EMFTest {

	public static Model emfTest(final String fileName, final String sourceFile)
			throws Exception {
		final TestUtils utils = new TestUtils(fileName);
		final Model result = utils.getModel();
		return result;
	}

}
