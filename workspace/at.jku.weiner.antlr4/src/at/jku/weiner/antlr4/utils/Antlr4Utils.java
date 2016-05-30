package at.jku.weiner.antlr4.utils;

import org.antlr.parser.antlr4.ANTLRv4Lexer;
import org.antlr.parser.antlr4.ANTLRv4Parser;
import org.antlr.parser.antlr4.ANTLRv4Parser.GrammarSpecContext;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import at.jku.weiner.antlr4.Antlr4MyListener;

public class Antlr4Utils {

	public static Antlr4MyListener runParserAndListener(final String fileName)
			throws Exception {
		final ANTLRv4Parser parser = Antlr4Utils.getParser(fileName);
		final GrammarSpecContext context = parser.grammarSpec();
		final ParseTreeWalker walker = new ParseTreeWalker();
		final Antlr4MyListener listener = new Antlr4MyListener();
		walker.walk(listener, context);
		return listener;
	}

	public static ANTLRv4Parser getParser(final String fileName)
			throws Exception {
		final ANTLRFileStream fileStream = new ANTLRFileStream(fileName);
		final ANTLRv4Lexer lexer = new ANTLRv4Lexer(fileStream);
		final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		final ANTLRv4Parser parser = new ANTLRv4Parser(tokenStream);
		parser.setBuildParseTree(true);
		return parser;
	}
}
