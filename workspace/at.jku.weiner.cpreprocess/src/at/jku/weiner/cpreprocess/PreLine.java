package at.jku.weiner.cpreprocess;

public final class PreLine {

	private static boolean isPreLine = false;

	public static boolean isPreLine() {
		return PreLine.isPreLine;
	}

	public static boolean isNotPreLine() {
		return !PreLine.isPreLine();
	}

	public static void setPreLine(final boolean isPreLine) {
		PreLine.isPreLine = isPreLine;
	}

}
