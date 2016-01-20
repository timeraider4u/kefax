package at.jku.weiner.c.preprocess.utils.macros;

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
		MyLog.trace("DefinitionTable.reset()");
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
		MyLog.trace("add new object-like macro with key='" + id
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
		TokenListUtils.print("fullResolve-start(id='" + this.id + "'), code='"
				+ code + "', list='", list);
		this.resolve(this.id, list, new MacroRanges(0, list.size()));
		for (int i = 0; i < list.size(); i++) {
			final Token next = list.get(i);
			final String text = next.getText();
			result.append(text);
		}
		final String resultStr = result.toString();
		MyLog.trace("fullResolve-end(id='" + this.id + "'), code='" + code
				+ "', result='" + resultStr + "'");
		return resultStr;
	}
	
	protected void resolve(final long parenID, final List<Token> list,
			final MacroRanges ranges) {
		TokenListUtils.print(
				"resolve-start('" + parenID + "'), " + ranges.toString(), list);
		for (int i = ranges.startIndex; (i < ranges.stopIndex)
		// && (ranges.currIndex < list.size())
		; i++) {
			MyLog.trace("resolve-loop0('" + parenID + "'), '"
					+ ranges.toString() + ", size='" + list.size() + "'");
			final Token next = list.get(i);
			final String text = next.getText();
			MyLog.trace("resolve-loop1('" + parenID + "'), token('" + i
					+ "')='" + text + "'");
			if (this.macros.containsKey(text)) {
				// resolve macro
				final DefinitionMacro macro = this.macros.get(text);
				final MacroRanges newRange = new MacroRanges(i,
						ranges.stopIndex);
				macro.resolve(parenID, list, newRange);
				ranges.update(newRange);
				i = newRange.getCurrentIndex();
				MyLog.trace("resolve-loop2('" + parenID + "'), "
						+ ranges.toString() + ", macroID='" + macro.getKey()
						+ "', size='" + list.size() + "'");
			}
		}
		TokenListUtils.print(
				"resolve-end('" + parenID + "'), " + ranges.toString()
						+ ", list='", list);
	}
	
}
