package at.jku.weiner.c.preprocess.utils.macros;

public class MacroParentheseNotClosedYetException extends
StringIndexOutOfBoundsException {

	/**
	 * generated id
	 */
	private static final long serialVersionUID = 1482427312416722776L;

	public MacroParentheseNotClosedYetException(final String string,
			final int index) {
		super("String='" + string + "', index out of range: " + index);
	}
}
