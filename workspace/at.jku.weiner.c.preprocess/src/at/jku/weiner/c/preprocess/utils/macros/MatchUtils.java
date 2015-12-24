package at.jku.weiner.c.preprocess.utils.macros;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MatchUtils {

	public static boolean matches(final String code, final Pattern pattern) {
		final Matcher matcher = pattern.matcher(code);
		if (!matcher.find()) {
			return false;
		}
		MatchState state = MatchState.Normal;
		int nextMatchStartIndex = matcher.start();
		for (int i = 0; i < code.length(); i++) {
			final char c = code.charAt(i);
			state = MatchUtils.calculateNextState(c, state);
			if ((state == MatchState.Normal) && (i == nextMatchStartIndex)) {
				return true;
			}
			if (!matcher.find(i)) {
				return false;
			}
			nextMatchStartIndex = matcher.start();
		}
		return false;
	}

	protected static MatchState calculateNextState(final char c,
			MatchState state) {
		switch (state) {
		case Normal:
			if (c == '"') {
				state = MatchState.InString;
			} else if (c == '\'') {
				state = MatchState.InChar;
			}
			break;
		case InString:
			if (c == '\\') {
				state = MatchState.BackslashInString;
			} else if (c == '"') {
				state = MatchState.Normal;
			}
			break;

		case InChar:
			if (c == '\\') {
				state = MatchState.BackslashInChar;
			} else if (c == '\'') {
				state = MatchState.Normal;
			}
			break;
		case BackslashInString:
			state = MatchState.InString;
			break;
		case BackslashInChar:
			state = MatchState.InChar;
			break;
		default:
			return state;
		}
		return state;
	}

}
