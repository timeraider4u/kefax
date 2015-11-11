package at.jku.weiner.cpreprocess;

public final class PreLine {

	private static boolean isPreLine = false;
	private static boolean id = false;

	public static boolean isPreLine() {
		return PreLine.isPreLine;
	}

	public static void setPreLine(final boolean isPreLine) {
		PreLine.isPreLine = isPreLine;
	}

	public static void setIdentifier() {
		PreLine.id = true;
	}

	public static void setWhiteSpace() {
		if (PreLine.id) {
			PreLine.id = false;
			PreLine.setPreLine(false);
		}
	}

}
