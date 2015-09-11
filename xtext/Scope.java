package at.jku.isse.ecco.kefax.c.parser.antlr.internal;

import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

public final class Scope {

	private final class Symbols {
		@SuppressWarnings("unused")
		public final String scopeName;
		public final Set<String> types = new HashSet<String>();
		public Symbols(final String scopeName) {
			this.scopeName = scopeName;
		}
	}
	
	protected final Stack<Symbols> scope = new Stack<Symbols>();
	protected Symbols currScope = null;
	
	protected final boolean isTypeName(final String name) {
		// System.out.println("searching for typeName='" + name + "', scopeSize='"
		//	+ this.scope.size() + "'");
		if (currScope.types.contains(name)) {
			//System.out.println("found in currScope!");
			return true;
		}
		for (int i = 0; i < this.scope.size(); i++) {
			final Symbols symbols = this.scope.get(i);
			if (symbols.types.contains(name)) {
				// System.out.println("found in scope='" + symbols.scopeName + "'");
				return true;
			}
			// System.out.println("no type found in scope='" + symbols.scopeName + "'");
		}
		return false;
	}
	
	protected final void createNewScope(final String scopeName) {
		// System.out.println("createNewScope='" + scopeName + "'");
		final Symbols symbols = new Symbols(scopeName);
		if (this.currScope != null) {
			this.scope.push(this.currScope);
		}
		this.currScope = symbols;
		this.setTypedef(false);
	}
	
	protected final void removeScope() {
		// System.out.println("removeScope='" + currScope.scopeName + "'");
		if (this.scope.isEmpty()) {
			this.currScope = null;
		}
		else {
			this.currScope = this.scope.pop();
		}
		this.setTypedef(false);
	}
	
	protected final void addTypedef(final String name) {
		this.currScope.types.add(name);
		// System.out.println("define type='" + name + "'");
	}
	
	protected final void setTypedef(final boolean newTypeDef) {
		isTypedefValue = newTypeDef;
	}
	
	protected final boolean isTypedef() {
		return isTypedefValue;
	}
	
	protected boolean isTypedefValue = false;
	
}
