package at.jku.weiner.c.preprocess.utils.macros;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;

public final class DefinitionTable {
	
	private static final List<DefinitionEntry> macros = new ArrayList<DefinitionEntry>();
	private static final List<DefinitionEntry> objMacros = new ArrayList<DefinitionEntry>();
	private static final List<DefinitionEntry> funcMacros = new ArrayList<DefinitionEntry>();

	public static void reset() {
		DefinitionTable.macros.clear();
		DefinitionTable.objMacros.clear();
		DefinitionTable.funcMacros.clear();
	}

	public static int size() {
		return DefinitionTable.macros.size();
	}
	
	protected static String resolve(final String originalText, final String code) {
		String result = code;
		for (int i = 0; i < DefinitionTable.funcMacros.size(); i++) {
			final DefinitionEntry entry = DefinitionTable.funcMacros.get(i);
			result = entry.resolve(originalText, result);
		}
		for (int i = 0; i < DefinitionTable.objMacros.size(); i++) {
			final DefinitionEntry entry = DefinitionTable.objMacros.get(i);
			result = entry.resolve(originalText, result);
		}
		return result;
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
	
	public static boolean containsAKey(final String originalText,
			final String code) {
		for (final DefinitionEntry entry : DefinitionTable.macros) {
			if (entry.matches(originalText, code)) {
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
		DefinitionTable.objMacros.add(entry);
	}
	
	private static void checkForExistence(final String key,
			final DefinitionMacro newMacro) {
		for (int i = 0; i < DefinitionTable.macros.size(); i++) {
			final DefinitionEntry entry = DefinitionTable.macros.get(i);
			if (entry.equalsKey(newMacro.getName())) {
				if (entry.equalsMacro(newMacro)) {
					DefinitionTable.macros.remove(entry);
					DefinitionTable.objMacros.remove(entry);
					DefinitionTable.funcMacros.remove(DefinitionTable.macros);
				} else {
					throw new IllegalArgumentException(
							"re-definition is not possible!!!");
				}
			}
		}
	}
	
	public static void addFunctionMacro(final String id,
			final IdentifierList list, final EList<ReplaceLine> replaceWith) {
		final String key = id;
		// final String val = DefinitionTable.resolve(replaceWith);
		// final String val = replaceWith;
		final DefinitionMacro newMacro = new DefinitionFunctionMacro(key, list,
				replaceWith);
		DefinitionTable.checkForExistence(key, newMacro);
		
		final DefinitionEntry entry = new DefinitionEntry(key, newMacro);
		DefinitionTable.macros.add(entry);
		DefinitionTable.funcMacros.add(entry);
	}
	
	public static void remove(final String key) {
		for (int i = 0; i < DefinitionTable.macros.size(); i++) {
			final DefinitionEntry entry = DefinitionTable.macros.get(i);
			
			if (entry.equalsKey(key)) {
				DefinitionTable.macros.remove(entry);
				DefinitionTable.objMacros.remove(entry);
				DefinitionTable.funcMacros.remove(entry);
			}
		}
	}
	
	public static String fullResolve(final String code) {
		String result = code;
		while (DefinitionTable.containsAKey(code, result)) {
			result = DefinitionTable.resolve(code, result);
		}
		return result;
	}
	
}
