package at.jku.weiner.c;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

public final class Scope {

	private static final class Symbols {
		public final String scopeName;
		public final Set<String> types = new HashSet<String>();

		public Symbols(final String scopeName) {
			this.scopeName = scopeName;
		}
	}

	protected static final Stack<Symbols> scope = new Stack<Symbols>();
	protected static Symbols currScope = null;

	public static final boolean isTypeName(final TokenStream input) {
		return Scope.isTypeName(input.LT(1).getText());
	}

	public static final boolean isTypeName(final String name) {
		Log.log("searching for typeName='" + name + "', scopeSize='"
				+ Scope.scope.size() + "'");
		if (Scope.currScope.types.contains(name)) {
			Log.log("found in currScope!");
			return true;
		}
		for (int i = 0; i < Scope.scope.size(); i++) {
			final Symbols symbols = Scope.scope.get(i);
			if (symbols.types.contains(name)) {
				Log.log("found in scope='" + symbols.scopeName + "'");
				return true;
			}
			Log.log("no type found in scope='" + symbols.scopeName + "'");
		}
		Log.log("isTypeName='false'");
		return false;
	}

	public static final void createNewScope(final String scopeName) {
		Log.log("createNewScope='" + scopeName + "'");
		final Symbols symbols = new Symbols(scopeName);
		if (Scope.currScope != null) {
			Scope.scope.push(Scope.currScope);
		}
		Scope.currScope = symbols;
		Scope.setTypedef(false);
		Log.log("Scope.size()='" + Scope.scope.size() + "'");
	}

	public static final void removeScope() {
		Log.log("removeScope='" + Scope.currScope.scopeName + "'");
		if (Scope.scope.isEmpty()) {
			Scope.currScope = null;
		} else {
			Scope.currScope = Scope.scope.pop();
		}
		Scope.setTypedef(false);
		Log.log("Scope.size()='" + Scope.scope.size() + "'");
	}

	protected static final void addTypedef(final String name) {
		Log.log("define in currScope='" + Scope.currScope.scopeName
				+ "' newType='" + name + "'");
		Scope.currScope.types.add(name);
	}

	public static final void setTypedef(final boolean newTypeDef) {
		Log.log("setTypedef='" + newTypeDef + "'");
		Scope.isTypedefValue = newTypeDef;
	}

	protected static final boolean isTypedef() {
		Log.log("isTypeDef='" + Scope.isTypedefValue + "'");
		return Scope.isTypedefValue;
	}

	public static final void addTypedefIfIsTypedef(final String name) {
		Log.log("addTypedefIfIsTypedef('" + name + "')");
		if (Scope.isTypedef()) {
			Scope.addTypedef(name);
		}
	}

	protected static boolean isTypedefValue = false;

	protected static String temp = "";

	public static final void setTemp(final TokenStream stream) {
		Log.log("Token.LT(0)='" + stream.LT(0) + "'");
		Log.log("Token.LT(1)='" + stream.LT(1).getText() + "'");
		Log.log("Token.LT(2)='" + stream.LT(2).getText() + "'");
		Scope.setTemp(stream.LT(1).getText());
	}

	protected static final void setTemp(final String newTemp) {
		Log.log("setTemp='" + newTemp + "'");
		Scope.temp = newTemp;
	}

	public static final void addTypedefIfIsTypedef() {
		Scope.addTypedefIfIsTypedef(Scope.temp);
	}

	public static final void debug(final TokenStream stream) {
		/*
		 * for (int i = 0; i < stream.size(); i++) { final Token token =
		 * stream.get(i); final String tokenText = token.getText();
		 * Log.log("i='" + i + "', token='" + tokenText + "'"); }
		 */

	}
}
