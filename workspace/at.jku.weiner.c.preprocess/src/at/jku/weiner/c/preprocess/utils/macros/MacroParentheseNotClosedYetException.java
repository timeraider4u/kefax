package at.jku.weiner.c.preprocess.utils.macros;

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
		this.string = string;
		this.index = index;
	}
	
	public String getString() {
		return this.string;
	}
	
	public int getIndex() {
		return this.index;
	}
}
