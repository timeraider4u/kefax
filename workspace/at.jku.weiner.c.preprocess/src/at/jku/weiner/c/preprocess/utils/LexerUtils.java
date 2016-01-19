package at.jku.weiner.c.preprocess.utils;

import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import at.jku.weiner.c.preprocess.parser.antlr.internal.InternalPreprocessLexer;

public class LexerUtils {

	private final InternalPreprocessLexer lexer;
	private final ITokenDefProvider tokenDefProvider;

	public LexerUtils(final InternalPreprocessLexer lexer,
			final ITokenDefProvider tokenDefProvider) {
		this.lexer = lexer;
		this.tokenDefProvider = tokenDefProvider;
	}

	/**
	 * return the list of tokens created by the lexer from the given input
	 */
	public List<Token> getTokens(final String input) {
		final CharStream stream = new ANTLRStringStream(input);
		this.lexer.setCharStream(stream);
		final XtextTokenStream tokenStream = new XtextTokenStream(this.lexer,
				this.tokenDefProvider);
		// this.parser.setInitialHiddenTokens(tokenStream);
		@SuppressWarnings("unchecked")
		final List<Token> tokens = tokenStream.getTokens();
		return tokens;
	}

}
