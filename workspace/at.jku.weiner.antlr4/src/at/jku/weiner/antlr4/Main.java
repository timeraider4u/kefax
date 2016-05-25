package at.jku.weiner.antlr4;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import at.jku.weiner.antlr4.Antlr4Parser.Antlr4Context;

public class Main {
	
	public static final String	FILE_NAME1	= "data/hello.txt";

	public static void main(final String[] args) {
		final String result = Main.run(Main.FILE_NAME1);
		System.out.println(result);
	}

	public static String run(final String fileName) {
		try {
			final String result = Main.runInternal(fileName);
			return result;
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	public static String runInternal(final String fileName) throws Exception {
		// Set-up parser
		final Antlr4Parser parser = Main.getParser(fileName);
		// Specify our entry point
		final Antlr4Context context = parser.antlr4();
		
		// Walk it and attach our listener
		final ParseTreeWalker walker = new ParseTreeWalker();
		final Antlr4MyListener listener = new Antlr4MyListener();
		walker.walk(listener, context);
		
		final String result = listener.toString();
		return result;
	}
	
	public static Antlr4Parser getParser(final String fileName)
			throws IOException {
		final ANTLRFileStream fileStream = new ANTLRFileStream(fileName);
		final Antlr4Lexer lexer = new Antlr4Lexer(fileStream);
		final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		final Antlr4Parser parser = new Antlr4Parser(tokenStream);
		parser.setBuildParseTree(true);
		return parser;
	}
}
