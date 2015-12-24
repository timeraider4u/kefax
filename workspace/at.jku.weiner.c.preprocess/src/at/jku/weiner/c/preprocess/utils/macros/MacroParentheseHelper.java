package at.jku.weiner.c.preprocess.utils.macros;

public class MacroParentheseHelper {

	private final String text;
	private int currIndex;
	private int parentheses;

	public MacroParentheseHelper(final String text, final int startIndex) {
		this.text = text;
		this.currIndex = startIndex;
		this.parentheses = 1;
	}

	public int getIndex() {
		return this.currIndex;
	}

	private int calculateNextIndex() {
		int nextIndex = this.currIndex;
		while (nextIndex < this.text.length()) {
			final char ch = this.text.charAt(nextIndex);
			switch (ch) {
			case '(':
				this.parentheses++;
				break;
			case ')':
				this.parentheses--;
				if (this.parentheses == 0) {
					return nextIndex;
				}
				break;
			case ',':
				if (this.parentheses == 1) {
					return nextIndex;
				}
			}
			nextIndex = nextIndex + 1;
		}
		return nextIndex;
	}

	public boolean hasMoreParams() {
		return ((this.parentheses > 0));
	}

	public String getNextParam() {
		final int nextIndex = this.calculateNextIndex();
		if (nextIndex > this.text.length()) {
			System.out.println("macro exception!");
			throw new MacroParentheseNotClosedYetException(this.text, nextIndex);
		}
		String result;
		result = this.text.substring(this.currIndex, nextIndex);
		this.currIndex = nextIndex + 1;
		return result.trim();
	}

}
