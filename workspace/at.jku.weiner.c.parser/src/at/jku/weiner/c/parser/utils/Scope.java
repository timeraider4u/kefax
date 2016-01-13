package at.jku.weiner.c.parser.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;

public final class Scope {

	private static final class Symbols {
		public final String scopeName;
		public final Set<String> types = new HashSet<String>();
		public boolean isTypeDefValue = false;
		public String temp = null;
		public String lastOp = null;

		public Symbols(final String scopeName) {
			this.scopeName = scopeName;
		}
	}

	protected static final Stack<Symbols> scope = new Stack<Symbols>();
	private static boolean outOfLevel = true;

	public static void enterTypeDefName() {
		Log.log("In typedefname ");
		Scope.outOfLevel = false;
	}

	public static void leaveTypeDefName() {
		Scope.outOfLevel = true;
	}

	public static int size() {
		return Scope.scope.size();
	}

	// protected static Symbols currScope = null;

	public static final boolean isTypeName(final RecognizerSharedState state,
			final TokenStream input) {
		String token = input.LT(1).getText();
		Log.debug("token(LT1)='" + token + "'");
		if ("(".equals(token)) {
			token = input.LT(2).getText();
		}
		Log.debug("isTypeName state.backtracking=" + state.backtracking
				+ ", token(choosen)='" + token + "'");
		Log.debug("token(choosen)='" + token + "'");
		Log.debug("Out of level='" + Scope.outOfLevel + "'");
		// return (Scope.outOfLevel || Scope.isTypeName(token));
		// if (state.backtracking != 0) {
		// return true;
		// }
		return Scope.isTypeName(token);
	}

	private static final boolean isTypeName(final String name) {
		Log.log("searching for typeName='" + name + "', scopeSize='"
				+ Scope.scope.size() + "'");
		for (int i = 0; i < Scope.scope.size(); i++) {
			final Symbols symbols = Scope.scope.get(i);
			if (symbols.types.contains(name)) {
				Log.log("found in scope='" + symbols.scopeName + "'");
				return true;
			}
			Log.debug("no type found in scope='" + symbols.scopeName + "'");
		}
		Log.log("isTypeName='false'");
		return false;
	}

	public static final void createFirstScope(final String scopeName) {
		Scope.scope.clear();
		Scope.createNewScope(scopeName);
	}

	public static final void createNewScope(final String scopeName) {
		Log.log("createNewScope='" + scopeName + "'");
		final Symbols symbols = new Symbols(scopeName);
		Scope.scope.push(symbols);
		Log.debug("Scope.size()='" + Scope.scope.size() + "'");
	}

	public static final void removeScope() {
		if (Scope.scope.size() > 0) {
			Log.log("removeScope='" + Scope.scope.peek().scopeName + "'");
			Scope.scope.pop();
		}
		// Scope.setTypedef(false);
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

	protected static final void addTypedef(final String name) {
		Log.log("define in currScope='" + Scope.scope.peek().scopeName
				+ "' newType='" + name + "'");
		Scope.scope.peek().types.add(name);
		Scope.setTypedef(false);
		Scope.scope.peek().lastOp = name;
	}

	public static final void undoLastOp() {
		String name = Scope.scope.peek().lastOp;
		if (name != null) {
			System.out.println("undoLastOp='" + name + "'");
			Scope.scope.peek().types.remove(name);
			name = null;
		}
	}

	public static final void setTypedef(final boolean newTypeDef) {
		Log.debug("setTypedef='" + newTypeDef + "'");
		Scope.scope.peek().isTypeDefValue = newTypeDef;
	}

	protected static final boolean isTypedef() {
		Log.debug("isTypeDef='" + Scope.scope.peek().isTypeDefValue + "'");
		return Scope.scope.peek().isTypeDefValue;
	}

	public static final boolean checkThatNoTypeIDAndSetTemp(
			final TokenStream input) {
		final String token = input.LT(1).getText();
		Log.debug("token(LT1)='" + token + "'");
		boolean result = true;
		result = (!Scope.isTypeName(token));
		Log.debug("checkThatNoTypeIDAndSetTemp('" + result + "')");
		Scope.setTemp(input);
		// return result;
		return true;
	}

	public static final void addTypedefIfIsTypedef(final TokenStream input) {
		Log.debug("addTypedefIfIsTypedef('')");
		final String token = input.LT(1).getText();
		Log.debug("token(LT1)='" + token + "'");
		if (Scope.isTypedef()) {
			Scope.addTypedef(token);
		}
	}

	public static final void addTypedefIfIsTypedef(final String name) {
		Log.debug("addTypedefIfIsTypedef('" + name + "')");
		if (Scope.isTypedef()) {
			Scope.addTypedef(name);
		}
	}

	// protected static boolean isTypedefValue = false;

	// protected static String temp = "";

	public static final void setTemp(final TokenStream stream) {
		Log.debug("Token.LT(0)='" + stream.LT(0) + "'");
		Log.debug("Token.LT(1)='" + stream.LT(1).getText() + "'");
		Log.debug("Token.LT(2)='" + stream.LT(2).getText() + "'");
		Scope.setTemp(stream.LT(1).getText());
	}

	protected static final void setTemp(final String newTemp) {
		Log.debug("setTemp='" + newTemp + "'");
		Scope.scope.peek().temp = newTemp;
	}

	public static final void addTypedefIfIsTypedef() {
		Scope.addTypedefIfIsTypedef(Scope.scope.peek().temp);
	}

	public static final void debug(final TokenStream stream) {
		/*
		 * for (int i = 0; i < stream.size(); i++) { final Token token =
		 * stream.get(i); final String tokenText = token.getText();
		 * Log.log("i='" + i + "', token='" + tokenText + "'"); }
		 */

	}
}
