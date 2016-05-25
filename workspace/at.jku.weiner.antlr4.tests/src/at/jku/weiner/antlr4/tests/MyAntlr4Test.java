package at.jku.weiner.antlr4.tests;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.Bundle;

import at.jku.weiner.antlr4.Main;

@SuppressWarnings("unused")
public class MyAntlr4Test {
	
	@Test
	public void test() throws Exception {
		final Bundle bundle = Activator.getContext().getBundle();
		final URL url = bundle.getEntry(Main.FILE_NAME1);
		final URL fileURL = FileLocator.toFileURL(url);
		final String fileName = fileURL.getFile();
		System.out.println("fileName='" + fileName + "'");
		final String result = Main.runInternal(fileName);
		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());
	}
}
