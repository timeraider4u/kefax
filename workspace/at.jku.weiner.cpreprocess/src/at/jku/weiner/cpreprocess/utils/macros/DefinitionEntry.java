package at.jku.weiner.cpreprocess.utils.macros;

public class DefinitionEntry {

	private final String macroID;
	private final DefinitionMacro macro;

	public DefinitionEntry(final String macroID, final DefinitionMacro macro) {
		this.macroID = macroID;
		this.macro = macro;

	}

	public boolean equalsKey(final String key) {
		return this.macroID.equals(key);
	}

	public boolean equalsMacro(final DefinitionMacro newMacro) {
		return this.macro.equals(newMacro);
	}

	public String resolve(final String text) {
		return this.macro.resolve(text);
	}

	public boolean matches(final String text) {
		return this.macro.matches(text);
	}
}