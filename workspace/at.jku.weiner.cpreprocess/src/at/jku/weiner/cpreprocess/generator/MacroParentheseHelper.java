package at.jku.weiner.cpreprocess.generator;

public class MacroParentheseHelper {

	private final String string;
	private final int startIndex;

	public MacroParentheseHelper(final String string, final int startIndex) {
		this.string = string;
		this.startIndex = startIndex;
	}

	public int getEndIndex() {

		return -1;
	}

	public boolean hasMoreParams() {
		return false;
	}

	public String getNextParam() {
		return "";
	}

}
