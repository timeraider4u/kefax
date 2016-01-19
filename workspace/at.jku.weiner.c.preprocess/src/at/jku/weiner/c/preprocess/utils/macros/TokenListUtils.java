package at.jku.weiner.c.preprocess.utils.macros;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.Token;

import at.jku.weiner.c.preprocess.utils.MyLog;

final class TokenListUtils {

	protected static void printList(final String start,
			final List<ArrayList<Token>> tokens) {
		for (int i = 0; i < tokens.size(); i++) {
			ArrayList<Token> list = tokens.get(i);
			TokenListUtils.print(start, list);
		}
	}

	protected static void print(final String start, final List<Token> tokens) {
		final StringBuffer buffer = new StringBuffer(start);
		for (int i = 0; i < tokens.size(); i++) {
			final Token token = tokens.get(i);
			final String text = token.getText();
			buffer.append(text);
			// buffer.append("i='" + i + "', token='" + text + "' ");
		}
		buffer.append("'");
		MyLog.trace(buffer.toString());
	}

}
