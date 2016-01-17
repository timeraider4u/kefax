package at.jku.weiner.c.preprocess.utils.macros;

import java.util.List;
import java.util.regex.Pattern;

import org.antlr.runtime.Token;

import at.jku.weiner.c.preprocess.utils.LexerUtils;

public final class DefinitionObjectMacro implements DefinitionMacro {

	private final String macroID;
	private final String value;
	private final List<Token> replacement;

	public DefinitionObjectMacro(final LexerUtils lexerUtils, final String key,
			final String replace) {
		this.macroID = key;
		this.value = this.getValue(replace);
		this.replacement = lexerUtils.getTokens(this.value);
	}

	private String getValue(String value2) {
		if (value2 == null) {
			value2 = "";
		}
		return value2;
	}

	@Override
	public boolean equalsMacro(final DefinitionMacro obj) {
		if (!(obj instanceof DefinitionObjectMacro)) {
			return false;
		}
		final DefinitionObjectMacro other = (DefinitionObjectMacro) obj;
		if (!(this.macroID.equals(other.macroID))) {
			return false;
		}
		return this.value.equals(other.value);
	}

	@Override
	public int resolve(final StringBuffer result, final List<Token> code,
			final int currPosition) {
		code.remove(currPosition);
		code.addAll(currPosition, this.replacement);
		// if (!this.preCheck(originalText, code)) {
		// return code;
		// }
		// this.lastOriginal = originalText;
		// final Matcher matcher = this.pattern.matcher(code);
		// if (!matcher.find()) {
		// return code;
		// }
		// final StringBuffer result = new StringBuffer("");
		// MatchState state = MatchState.Normal;
		// int nextMatchStartIndex = matcher.start();
		// int nextMatchEndIndex = matcher.end();
		// for (int i = 0; i < code.length(); i++) {
		// final char c = code.charAt(i);
		// state = MatchUtils.calculateNextState(c, state);
		// if ((state == MatchState.Normal) && (i == nextMatchStartIndex)) {
		// result.append(this.replacement);
		// i = nextMatchEndIndex - 1;
		// } else if (!matcher.find(i)) {
		// result.append(code.substring(i));
		// return result.toString();
		//
		// } else {
		// result.append(c);
		// }
		// nextMatchStartIndex = matcher.start();
		// nextMatchEndIndex = matcher.end();
		// }
		// this.lastExpansion = result.toString();
		// return this.lastExpansion;
		final int size = this.replacement.size();
		return currPosition + size;
	}

}
