package at.jku.weiner.c.preprocess.utils.macros;

import java.util.List;

import org.antlr.runtime.Token;

import at.jku.weiner.c.preprocess.utils.MyLog;

public final class DefinitionObjectMacro implements DefinitionMacro {

	private final DefinitionTable definitionTable;
	private final String macroID;
	private final String value;
	private final List<Token> replacement;
	private final int size;
	private boolean enabled = true;

	public DefinitionObjectMacro(final DefinitionTable definitionTable,
			final String key, final String replace) {
		this.definitionTable = definitionTable;
		this.macroID = key;
		this.value = (replace == null) ? "" : replace;
		this.replacement = definitionTable.lexer.getTokens(this.value);
		this.size = this.replacement.size();
	}

	@Override
	public String getKey() {
		return this.macroID;
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
	public void resolve(final long parenID, final List<Token> code,
			final MacroRanges ranges) {
		if (!this.enabled) {
			// prevent endless replacement loops
			MyLog.trace("prevent endless replacement loops with'"
					+ this.macroID + "', " + ranges.toString());
			return;
		}
		// do replacement
		code.remove(ranges.startIndex);
		ranges.removeElement();
		code.addAll(ranges.startIndex, this.replacement);
		ranges.addElements(this.size);
		// rescan
		this.enabled = false;
		final MacroRanges newRanges = new MacroRanges(ranges.startIndex,
				ranges.startIndex + ranges.addedElements, ranges.level + 1);
		this.definitionTable.resolve(parenID, code, newRanges);
		ranges.update(newRanges);
		this.enabled = true;
	}

}
