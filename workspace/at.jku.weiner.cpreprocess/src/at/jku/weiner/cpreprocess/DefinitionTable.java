package at.jku.weiner.cpreprocess;

import java.util.Map;
import java.util.TreeMap;

public final class DefinitionTable {

	private static final Map<String, String> table = new TreeMap<String, String>();

	public static void reset() {
		DefinitionTable.table.clear();
	}

	public static void add(final String id, final String replaceWith) {
		final String key = DefinitionTable.resolve(id);
		final String val = DefinitionTable.resolve(replaceWith);
		DefinitionTable.table.put(key, val);
	}

	public static String resolve(String code) {
		for (final String key : DefinitionTable.table.keySet()) {
			final String replace = DefinitionTable.table.get(key);
			code = code.replace(key, replace);
		}
		return code;
	}

	public static void remove(final String key) {
		// final String key = DefinitionTable.resolve(id);
		if (DefinitionTable.table.containsKey(key)) {
			DefinitionTable.table.remove(key);
		}
	}

}
