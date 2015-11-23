package at.jku.weiner.cpreprocess.generator;

public class MacroParentheseHelper {

	private final String text;
	private int indexComma;
	private int indexLParen;
	private int indexRParen;
	private int currIndex;
	private final int parentheses;

	public MacroParentheseHelper(final String text, final int startIndex) {
		this.text = text;
		this.currIndex = startIndex;
		this.parentheses = 1;
	}

	public int getIndex() {
		return this.currIndex;
	}

	private int calculateNextIndex() {
		this.indexComma = this.text.indexOf(",", this.currIndex);
		this.indexLParen = this.text.indexOf("(", this.currIndex);
		this.indexRParen = this.text.indexOf(")", this.currIndex);

		// ...

		// ...

		return -1;
	}

	public boolean hasMoreParams() {
		return (this.parentheses > 0);
	}

	public String getNextParam() {
		final int nextIndex = this.calculateNextIndex();
		final String result = this.text.substring(this.currIndex, nextIndex);
		this.currIndex = nextIndex;
		return result;
	}

}
