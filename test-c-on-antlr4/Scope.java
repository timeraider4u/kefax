//package at.jku.weiner.c;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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
		System.out.println("searching for typeName='" + name + "', scopeSize='" + Scope.scope.size() + "'");
		if (Scope.currScope.types.contains(name)) {
			System.out.println("found in currScope!");
			return true;
		}
		for (int i = 0; i < Scope.scope.size(); i++) {
			final Symbols symbols = Scope.scope.get(i);
			if (symbols.types.contains(name)) {
				System.out.println("found in scope='" + symbols.scopeName + "'");
				return true;
			}
			System.out.println("no type found in scope='" + symbols.scopeName + "'");
		}
		return false;
	}

	public static final void createNewScope(final String scopeName) {
		System.out.println("createNewScope='" + scopeName + "'");
		final Symbols symbols = new Symbols(scopeName);
		if (Scope.currScope != null) {
			Scope.scope.push(Scope.currScope);
		}
		Scope.currScope = symbols;
		Scope.setTypedef(false);
	}

	public static final void removeScope() {
		System.out.println("removeScope='" + Scope.currScope.scopeName + "'");
		if (Scope.scope.isEmpty()) {
			Scope.currScope = null;
		} else {
			Scope.currScope = Scope.scope.pop();
		}
		Scope.setTypedef(false);
	}

	protected static final void addTypedef(final String name) {
		System.out.println("define in currScope='" + Scope.currScope.scopeName + "' newType='" + name + "'");
		Scope.currScope.types.add(name);
	}

	public static final void setTypedef(final boolean newTypeDef) {
		System.out.println("setTypedef='" + newTypeDef + "'");
		Scope.isTypedefValue = newTypeDef;
	}

	protected static final boolean isTypedef() {
		System.out.println("isTypeDef='" + Scope.isTypedefValue + "'");
		return Scope.isTypedefValue;
	}

	public static final void addTypedefIfIsTypedef(final String name) {
		if (Scope.isTypedef()) {
			Scope.addTypedef(name);
		}
	}

	protected static boolean isTypedefValue = false;

}
