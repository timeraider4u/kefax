package at.jku.weiner.antlr4.utils.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Bundle;

import at.jku.weiner.antlr4.Antlr4MyListener;
import at.jku.weiner.antlr4.Grammar;
import at.jku.weiner.antlr4.tests.Activator;
import at.jku.weiner.antlr4.utils.Antlr4Utils;
import at.jku.weiner.antlr4.utils.GeneratorUtils;
import at.jku.weiner.log.MyLog;

public class TestRunParserAndListenerMisc {
	
	private String	fileName;

	@Before
	public void setUp() throws Exception {
		MyLog.setLog_level(MyLog.LOG_NONE);
		final Bundle bundle = Activator.getContext().getBundle();
		this.fileName = GeneratorUtils.getAbsoluteFileNameFor(bundle,
				"data/my.g4");
	}
	
	@Test
	public void testRunner() throws Exception {
		final Antlr4MyListener listener = Antlr4Utils
				.runParserAndListener(this.fileName);
		Assert.assertNotNull(listener);
		final Grammar grammar = listener.getGrammar();
		Assert.assertNotNull(grammar);
		final String grammarName = grammar.getIdentifier();
		Assert.assertEquals("my", grammarName);
	}
	
}
