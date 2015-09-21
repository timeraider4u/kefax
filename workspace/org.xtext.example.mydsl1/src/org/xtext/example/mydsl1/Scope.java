package org.xtext.example.mydsl1;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public final class Scope {

	private static final class Symbols {
		@SuppressWarnings("unused")
		public final String scopeName;
		public final Set<String> types = new HashSet<String>();

		public Symbols(final String scopeName) {
			this.scopeName = scopeName;
		}
	}

	protected static final Stack<Symbols> scope = new Stack<Symbols>();
	protected static Symbols currScope = null;

	public static final boolean isTypeName(final String name) {
		// System.out.println("searching for typeName='" + name + "',
		// scopeSize='"
		// + this.scope.size() + "'");
		if (Scope.currScope.types.contains(name)) {
			// System.out.println("found in currScope!");
			return true;
		}
		for (int i = 0; i < Scope.scope.size(); i++) {
			final Symbols symbols = Scope.scope.get(i);
			if (symbols.types.contains(name)) {
				// System.out.println("found in scope='" + symbols.scopeName +
				// "'");
				return true;
			}
			// System.out.println("no type found in scope='" + symbols.scopeName
			// + "'");
		}
		return false;
	}

	public static final void createNewScope(final String scopeName) {
		// System.out.println("createNewScope='" + scopeName + "'");
		final Symbols symbols = new Symbols(scopeName);
		if (Scope.currScope != null) {
			Scope.scope.push(Scope.currScope);
		}
		Scope.currScope = symbols;
		Scope.setTypedef(false);
	}

	public static final void removeScope() {
		// System.out.println("removeScope='" + currScope.scopeName + "'");
		if (Scope.scope.isEmpty()) {
			Scope.currScope = null;
		} else {
			Scope.currScope = Scope.scope.pop();
		}
		Scope.setTypedef(false);
	}

	public static final void addTypedef(final String name) {
		Scope.currScope.types.add(name);
		// System.out.println("define type='" + name + "'");
	}

	protected static final void setTypedef(final boolean newTypeDef) {
		Scope.isTypedefValue = newTypeDef;
	}

	protected static final boolean isTypedef() {
		return Scope.isTypedefValue;
	}

	protected static boolean isTypedefValue = false;

}
