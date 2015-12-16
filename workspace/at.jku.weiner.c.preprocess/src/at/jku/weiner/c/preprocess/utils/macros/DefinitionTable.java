package at.jku.weiner.c.preprocess.utils.macros;

import java.util.ArrayList;
import java.util.List;

import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.utils.IncludeDirs;
import at.jku.weiner.c.preprocess.utils.OSEnum;
import at.jku.weiner.c.preprocess.utils.OSUtils;

public final class DefinitionTable {

	private static final List<DefinitionEntry> macros = new ArrayList<DefinitionEntry>();

	public static void reset() {
		DefinitionTable.macros.clear();
	}

	/***
	 * insert pre-defined macros
	 */
	public static void insertPredefinedMacros() {
		final OSEnum os = OSUtils.getOS();
		switch (os) {
		case Linux:
			DefinitionTable.add("__STDC__", "1");
			DefinitionTable.add("__GNUC__", "4");
			DefinitionTable.add("__GNUC_MINOR__", "8");
			DefinitionTable.add("__GNUC_PATCHLEVEL__", "4");
			break;
		default:
			break;
		}
	}

	public static int size() {
		return DefinitionTable.macros.size();
	}

	public static String resolve(String code) {
		for (int i = 0; i < DefinitionTable.macros.size(); i++) {
			final DefinitionEntry entry = DefinitionTable.macros.get(i);
			code = entry.resolve(code);
		}
		return code;
	}

	public static boolean isDefined(final String macroName) {
		boolean result = false;
		for (int i = 0; i < DefinitionTable.macros.size(); i++) {
			final DefinitionEntry entry = DefinitionTable.macros.get(i);
			if (entry.equalsKey(macroName)) {
				result = true;
			}
		}
		return result;
	}

	public static boolean containsAKey(final String code) {
		for (final DefinitionEntry entry : DefinitionTable.macros) {
			if (entry.matches(code)) {
				return true;
			}
		}
		return false;
	}

	public static void add(final String id, final String replaceWith) {
		final String key = id;
		final String val = replaceWith;
		final DefinitionMacro newMacro = new DefinitionObjectMacro(key, val);

		DefinitionTable.checkForExistence(key, newMacro);

		final DefinitionEntry entry = new DefinitionEntry(key, newMacro);
		DefinitionTable.macros.add(entry);
	}

	private static void checkForExistence(final String key,
			final DefinitionMacro newMacro) {
		for (int i = 0; i < DefinitionTable.macros.size(); i++) {
			final DefinitionEntry entry = DefinitionTable.macros.get(i);
			if (entry.equalsKey(newMacro.getName())) {
				if (entry.equalsMacro(newMacro)) {
					DefinitionTable.macros.remove(entry);
				} else {
					throw new IllegalArgumentException(
							"re-definition is not possible!!!");
				}
			}
		}
	}

	public static void addFunctionMacro(final String id,
			final String replaceWith, final IdentifierList list) {
		final String key = id;
		// final String val = DefinitionTable.resolve(replaceWith);
		final String val = replaceWith;
		final DefinitionMacro newMacro = new DefinitionFunctionMacro(key, val,
				list);

		DefinitionTable.checkForExistence(key, newMacro);

		final DefinitionEntry entry = new DefinitionEntry(key, newMacro);
		DefinitionTable.macros.add(entry);
	}

	public static void remove(final String key) {
		for (int i = 0; i < DefinitionTable.macros.size(); i++) {
			final DefinitionEntry entry = DefinitionTable.macros.get(i);

			if (entry.equalsKey(key)) {
				DefinitionTable.macros.remove(entry);
			}
		}
	}

}
