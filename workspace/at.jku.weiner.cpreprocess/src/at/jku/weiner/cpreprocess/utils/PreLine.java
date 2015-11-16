package at.jku.weiner.cpreprocess.utils;

import org.antlr.runtime.IntStream;

import com.google.common.primitives.Chars;

import at.jku.weiner.cpreprocess.parser.antlr.internal.InternalCPreprocessLexer;

public final class PreLine {

	private static State state = State.Unknown;

	// private static boolean isPreLine = false;

	/*
	 * public static boolean isPreLine() { // return PreLine.isPreLine; return
	 * PreLine.state == State.PreLine; }
	 */

	public static void setNewLine() {
		// PreLine.isPreLine = false;
		PreLine.state = State.Unknown;
	}

	public static void setPreLine(final boolean isPreLine) {
		// PreLine.isPreLine = isPreLine;
		if (isPreLine) {
			PreLine.state = State.PreLine;
		} else {
			PreLine.state = State.Code;
		}
	}

	public static boolean checkIfIsCode(final IntStream input) {
		switch (PreLine.state) {
		case PreLine:
			return false;
		case Code:
			return true;
		default:
			int nextToken = -1;
			for (int i = 1; ((nextToken = input.LA(i)) != InternalCPreprocessLexer.EOF); i++) {
				// System.out.println("nextToken('" + nextToken + "'='"
				// + Chars.checkedCast(nextToken) + "'");
				switch (nextToken) {
				case ' ':
					continue;
				case '\t':
					continue;
				case '#': {
					PreLine.state = State.PreLine;
					return false;
				}
				default:
					PreLine.state = State.Code;
					return true;
				}
			}
		}
		return false;
	}

}
