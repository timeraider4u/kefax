package at.jku.weiner.c.preprocess.utils.macros;

import java.awt.Point;
import java.util.List;

import org.antlr.runtime.Token;

import at.jku.weiner.c.preprocess.utils.MyLog;

public final class DefinitionObjectMacro implements DefinitionMacro {

	private final DefinitionTable definitionTable;
	private final String macroID;
	private final String value;
	private final List<Token> replacement;
	private boolean enabled = true;

	public DefinitionObjectMacro(final DefinitionTable definitionTable,
			final String key, final String replace) {
		this.definitionTable = definitionTable;
		this.macroID = key;
		this.value = (replace == null) ? "" : replace;
		this.replacement = definitionTable.lexer.getTokens(this.value);
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
			final Point point) {
		if (!this.enabled) {
			// prevent endless replacement loops
			MyLog.trace("prevent endless replacement loops with'"
					+ this.macroID + "', currPos='" + point.x + "'");
			return;
		}
		code.remove(point.x);
		code.addAll(point.x, this.replacement);
		// rescan
		this.enabled = false;
		final int size = this.replacement.size();
		point.y += size;
		this.definitionTable.resolve(parenID, code, new Point(point.x, point.x
				+ size));
		this.enabled = true;
	}

}
