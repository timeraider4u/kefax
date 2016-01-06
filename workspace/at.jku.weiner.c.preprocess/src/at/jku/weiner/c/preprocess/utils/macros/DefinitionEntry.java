package at.jku.weiner.c.preprocess.utils.macros;

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

	public String resolve(final String originalText, final String text) {
		return this.macro.resolve(originalText, text);
	}

	public boolean matches(final String originalText, final String text) {
		return this.macro.matches(originalText, text);
	}

	public DefinitionMacro getMacro() {
		return this.macro;
	}
}
