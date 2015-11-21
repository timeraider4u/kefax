package at.jku.weiner.cpreprocess.generator;

import java.util.Map;
import java.util.TreeMap;

import at.jku.weiner.cpreprocess.cPreprocess.IdentifierList;

public final class DefinitionTable {

	private static final Map<String, DefinitionMacro> table = new TreeMap<String, DefinitionMacro>();

	public static void reset() {
		DefinitionTable.table.clear();
	}

	public static void add(final String id, final String replaceWith) {
		final String key = DefinitionTable.resolve(id);
		final String val = DefinitionTable.resolve(replaceWith);
		final DefinitionMacro macro = new DefinitionObjectMacro(key, val);
		DefinitionTable.table.put(key, macro);
	}

	public static String resolve(String code) {
		for (final String key : DefinitionTable.table.keySet()) {
			final DefinitionMacro macro = DefinitionTable.table.get(key);
			code = macro.resolve(code);
		}
		return code;
	}

	public static void remove(final String key) {
		// final String key = DefinitionTable.resolve(id);
		if (DefinitionTable.table.containsKey(key)) {
			DefinitionTable.table.remove(key);
		}
	}

	public static void addFunctionMacro(final String id,
			final String replaceWith, final IdentifierList list) {
		final String key = DefinitionTable.resolve(id);
		final String val = DefinitionTable.resolve(replaceWith);
		final DefinitionMacro macro = new DefinitionFunctionMacro(key, val,
				list);
		DefinitionTable.table.put(key, macro);
	}

}
