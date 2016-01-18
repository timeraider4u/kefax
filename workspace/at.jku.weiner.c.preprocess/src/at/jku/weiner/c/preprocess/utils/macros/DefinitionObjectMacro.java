package at.jku.weiner.c.preprocess.utils.macros;

import java.util.List;

import org.antlr.runtime.Token;

import at.jku.weiner.c.preprocess.utils.LexerUtils;

public final class DefinitionObjectMacro implements DefinitionMacro {
	
	private final DefinitionTable definitionTable;
	private final String macroID;
	private final String value;
	private final List<Token> replacement;
	private long lastId = -1;
	private int lastIndex = -1;

	public DefinitionObjectMacro(final DefinitionTable definitionTable,
			final String key, final String replace) {
		this.definitionTable = definitionTable;
		this.macroID = key;
		this.value = (replace == null) ? "" : replace;
		this.replacement = definitionTable.lexer.getTokens(this.value);
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
	public boolean resolve(final long id, final List<Token> code,
			final int currPosition) {
		if (this.lastId != id) {
			this.lastIndex = -1;
		}
		this.lastId = id;
		if (currPosition < this.lastIndex) {
			// prevent endless replacement loops
			return false;
		}
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
		this.lastIndex = currPosition + size;
		return true;
	}

}
