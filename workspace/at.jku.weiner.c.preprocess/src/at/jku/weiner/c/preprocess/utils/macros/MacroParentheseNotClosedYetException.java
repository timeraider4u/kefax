package at.jku.weiner.c.preprocess.utils.macros;

import java.util.List;

import org.antlr.runtime.Token;

import at.jku.weiner.c.preprocess.utils.MyLog;

public final class MacroParentheseNotClosedYetException extends
		StringIndexOutOfBoundsException {

	/**
	 * generated id
	 */
	private static final long serialVersionUID = 1482427312416722776L;
	private final String string;
	private final int index;

	public MacroParentheseNotClosedYetException(final String string,
			final int index) {
		super("String='" + string + "', index out of range: " + index);
		MyLog.debug("MacroParentheseNotClosedYetException: string='" + string
				+ ", index out of range='" + index + "'");
		this.string = string;
		this.index = index;
	}

	public MacroParentheseNotClosedYetException(final List<Token> code,
			final int size) {
		this(MacroParentheseNotClosedYetException.getString(code), size);
	}
	
	public String getString() {
		return this.string;
	}

	public int getIndex() {
		return this.index;
	}

	private static String getString(final List<Token> code) {
		final StringBuffer buffer = new StringBuffer("");
		for (int i = 0; i < code.size(); i++) {
			final Token token = code.get(i);
			final String string = token.getText();
			buffer.append(string);
		}
		return buffer.toString();
	}
}
