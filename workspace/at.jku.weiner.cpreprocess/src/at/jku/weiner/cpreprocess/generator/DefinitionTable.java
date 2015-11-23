package at.jku.weiner.cpreprocess.generator;

import java.util.ArrayList;
import java.util.List;

import at.jku.weiner.cpreprocess.cPreprocess.IdentifierList;

public final class DefinitionTable {

	private static final List<DefinitionMacro> macros = new ArrayList<DefinitionMacro>();

	public static void reset() {
		DefinitionTable.macros.clear();
	}

	public static String resolve(String code) {
		for (final DefinitionMacro macro : DefinitionTable.macros) {
			// final DefinitionMacro macro = DefinitionTable.macros.get(key);
			code = macro.resolve(code);
		}
		return code;
	}

	public static void add(final String id, final String replaceWith) {
		final String key = DefinitionTable.resolve(id);
		for (int i = 0; i < DefinitionTable.macros.size(); i++) {
			final DefinitionMacro macro = DefinitionTable.macros.get(i);
			if (macro.getName().equals(key)) {
				DefinitionTable.macros.remove(macro);
			}
		}

		final String val = DefinitionTable.resolve(replaceWith);
		final DefinitionMacro macro = new DefinitionObjectMacro(key, val);
		DefinitionTable.macros.add(macro);
	}

	public static void addFunctionMacro(final String id,
			final String replaceWith, final IdentifierList list) {
		final String key = DefinitionTable.resolve(id);
		final String val = DefinitionTable.resolve(replaceWith);
		final DefinitionMacro macro = new DefinitionFunctionMacro(key, val,
				list);
		DefinitionTable.macros.add(macro);
	}

	public static void remove(final String key) {
		for (int i = 0; i < DefinitionTable.macros.size(); i++) {
			final DefinitionMacro macro = DefinitionTable.macros.get(i);
			if (macro.getName().equals(key)) {
				DefinitionTable.macros.remove(macro);
			}
		}
	}

}
