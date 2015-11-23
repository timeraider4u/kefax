package at.jku.weiner.cpreprocess.utils.macros;

import java.util.ArrayList;
import java.util.List;

import at.jku.weiner.cpreprocess.cPreprocess.IdentifierList;

public final class DefinitionTable {

	private static final List<DefinitionMacro> macros = new ArrayList<DefinitionMacro>();

	public static void reset() {
		DefinitionTable.macros.clear();
	}

	public static int size() {
		return DefinitionTable.macros.size();
	}

	public static String resolve(String code) {
		for (final DefinitionMacro macro : DefinitionTable.macros) {
			// final DefinitionMacro macro = DefinitionTable.macros.get(key);
			code = macro.resolve(code);
		}
		return code;
	}

	public static void add(final String id, final String replaceWith) {
		// final String key = DefinitionTable.resolve(id);
		final String key = id;
		final String val = DefinitionTable.resolve(replaceWith);
		final DefinitionMacro newMacro = new DefinitionObjectMacro(key, val);

		DefinitionTable.checkForExistence(key, newMacro);

		DefinitionTable.macros.add(newMacro);
	}

	private static void checkForExistence(final String key,
			final DefinitionMacro newMacro) {
		for (int i = 0; i < DefinitionTable.macros.size(); i++) {
			final DefinitionMacro macro = DefinitionTable.macros.get(i);
			final String name = macro.getName();
			if (name.equals(key)) {
				if (macro.equals(newMacro)) {
					DefinitionTable.macros.remove(macro);
				} else {
					throw new IllegalArgumentException(
							"re-definition is not possible!!!");
				}
			}
		}
	}

	public static void addFunctionMacro(final String id,
			final String replaceWith, final IdentifierList list) {
		// final String key = DefinitionTable.resolve(id);
		final String key = id;
		final String val = DefinitionTable.resolve(replaceWith);
		final DefinitionMacro newMacro = new DefinitionFunctionMacro(key, val,
				list);

		DefinitionTable.checkForExistence(key, newMacro);

		DefinitionTable.macros.add(newMacro);
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
