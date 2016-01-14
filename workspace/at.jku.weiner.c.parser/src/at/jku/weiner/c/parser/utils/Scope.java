package at.jku.weiner.c.parser.utils;

import java.util.Stack;
import org.antlr.runtime.TokenStream;

public final class Scope {
	
	protected static final Stack<ScopeSymbols> scope = new Stack<ScopeSymbols>();

	public static final void createFirstScope(final String scopeName) {
		Scope.scope.clear();
		Scope.createNewScope(scopeName);
	}

	public static final void createNewScope(final String scopeName) {
		Log.log("createNewScope='" + scopeName + "'");
		final ScopeSymbols symbols = new ScopeSymbols(scopeName);
		Scope.scope.push(symbols);
		Log.debug("Scope.size()='" + Scope.scope.size() + "'");
	}

	public static final void removeScope() {
		if (Scope.scope.size() > 0) {
			Log.log("removeScope='" + Scope.scope.peek().getScopeName() + "'");
			Scope.scope.pop();
		}
		Log.debug("Scope.size()='" + Scope.scope.size() + "'");
	}

	public static final void removeScope(final int expectedSize) {
		Scope.removeScope();
		if (expectedSize != Scope.scope.size()) {
			final int actualSize = Scope.scope.size();
			Scope.scope.clear();
			throw new RuntimeException("expected size='" + expectedSize
					+ "', but was '" + actualSize + "'!");
		}
	}
	
	public static int size() {
		return Scope.scope.size();
	}

	public static final boolean isTypeName(final int backtracking,
			final TokenStream input) {
		String token = input.LT(1).getText();
		if ("(".equals(token)) {
			token = input.LT(2).getText();
		}
		Log.debug("backtracking='" + backtracking + "', token(choosen)='"
				+ token + "'");
		return Scope.isTypeName(backtracking, token);
	}

	private static final boolean isTypeName(final int backtracking,
			final String name) {
		Log.log("searching for typeName='" + name + "', scopeSize='"
				+ Scope.scope.size() + "'");
		for (int i = 0; i < Scope.scope.size(); i++) {
			final ScopeSymbols symbols = Scope.scope.get(i);
			if (symbols.containsType(backtracking, name)) {
				Log.log("found in scope='" + symbols.getScopeName() + "'");
				Log.log(symbols.debug());
				return true;
			}
			Log.debug("no type found in scope='" + symbols.getScopeName() + "'");
		}
		Log.log("isTypeName='false'");
		return false;
	}
	
	public static final void setTemp(final TokenStream stream) {
		final String string = stream.LT(1).getText();
		Scope.scope.peek().setTemp(string);
	}

	public static final void setTypedef(final int backtracking,
			final boolean newTypeDef) {
		if (!newTypeDef) {
			Scope.scope.peek().clear(backtracking);
		}
		Scope.scope.peek().setTypeDefValue(newTypeDef);
	}

	public static final void addTypedefIfIsTypedef(final int backtracking) {
		Scope.scope.peek().addType(backtracking);
	}
	
}
