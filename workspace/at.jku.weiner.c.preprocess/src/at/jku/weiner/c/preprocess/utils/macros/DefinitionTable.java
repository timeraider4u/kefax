package at.jku.weiner.c.preprocess.utils.macros;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.Token;

import at.jku.weiner.c.preprocess.parser.antlr.internal.InternalPreprocessLexer;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.utils.LexerUtils;
import at.jku.weiner.c.preprocess.utils.MyLog;

public final class DefinitionTable {
	
	private long id = -1;
	private final Map<String, DefinitionMacro> macros = new HashMap<String, DefinitionMacro>();
	protected final LexerUtils lexer;

	public DefinitionTable(final LexerUtils lexer) {
		this.lexer = lexer;
	}

	public void reset() {
		this.macros.clear();
		MyLog.debug("DefinitionTable.reset()");
	}

	public int size() {
		return this.macros.size();
	}
	
	public boolean isDefined(final String macroName) {
		boolean result = false;
		result = this.macros.containsKey(macroName);
		return result;
	}
	
	public void add(final String id, final String replaceWith) {
		final String key = id;
		final String val = replaceWith;
		MyLog.debug("add new object-like macro with key='" + id
				+ "' and replaceWith='" + replaceWith + "'");
		final DefinitionMacro newMacro = new DefinitionObjectMacro(this, key,
				val);
		this.checkForExistence(key, newMacro);
		this.macros.put(id, newMacro);
	}
	
	private void checkForExistence(final String key,
			final DefinitionMacro newMacro) {
		if (this.macros.containsKey(key)) {
			final DefinitionMacro entry = this.macros.get(key);
			if (entry.equalsMacro(newMacro)) {
				this.macros.remove(entry);
			} else {
				throw new IllegalArgumentException(
						"re-definition is not possible!!!");
			}
		}
	}
	
	public void addFunctionMacro(final String id, final IdentifierList list,
			final String replaceWith) {
		final String key = id;
		final DefinitionMacro newMacro = new DefinitionFunctionMacro(this, key,
				list, replaceWith);
		this.checkForExistence(key, newMacro);
		
		this.macros.put(id, newMacro);
	}
	
	public void remove(final String key) {
		this.macros.remove(key);
	}
	
	public boolean containsAKey(final String code) {
		final boolean result = false;
		final List<Token> list = this.lexer.getTokens(code);
		for (int i = 0; i < list.size(); i++) {
			final Token next = list.get(i);
			final int type = next.getType();
			final String text = next.getText();
			if (type == InternalPreprocessLexer.RULE_ID) {
				if (this.macros.containsKey(text)) {
					return true;
				}
			}
		}
		return result;
	}
	
	public String fullResolve(final String code) {
		final StringBuffer result = new StringBuffer("");
		final List<Token> list = this.lexer.getTokens(code);
		this.id++;
		MyLog.debug("fullResolve(id='" + this.id + "'), code='" + code + "'");
		final List<Token> newList = this.resolve(this.id, list);
		for (int i = 0; i < newList.size(); i++) {
			final Token next = newList.get(i);
			final String text = next.getText();
			result.append(text);
		}
		final String resultStr = result.toString();
		MyLog.debug("fullResolve(id='" + this.id + "'), code='" + code
				+ "', result='" + resultStr + "'");
		return resultStr;
	}

	protected List<Token> resolve(final long parenID, final List<Token> list) {
		final List<Token> result = new ArrayList<Token>();
		for (int i = 0; i < list.size(); i++) {
			final Token next = list.get(i);
			final int type = next.getType();
			final String text = next.getText();
			MyLog.debug("resolve: parenID=" + parenID + "', token('" + i
					+ "')='" + text + "', result='" + result.toString() + "'");
			if (type == InternalPreprocessLexer.RULE_ID) {
				if (this.macros.containsKey(text)) {
					// resolve macro
					final DefinitionMacro macro = this.macros.get(text);
					final boolean replaced = macro.resolve(parenID, list, i);
					if (replaced) {
						i--;
					} else {
						result.add(next);
					}
				} else {
					result.add(next);
				}
			} else {
				result.add(next);
			}
		}
		return result;
	}
	
}
