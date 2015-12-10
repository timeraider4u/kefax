package org.eclipse.modisco.cdt.discoverer.ast.my;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.modisco.cdt.Declaration;
import org.eclipse.modisco.cdt.FunctionDefinition;
import org.eclipse.modisco.cdt.PreprocessorIncludeStatement;
import org.eclipse.modisco.cdt.Scope;
import org.eclipse.modisco.cdt.Statement;
import org.eclipse.modisco.cdt.TranslationUnit;
import org.eclipse.modisco.cdt.Variable;

public final class MyLookUp<T extends Declaration> {

	private final Class<T> type;

	public MyLookUp(final Class<T> type) {
		this.type = type;
	}

	public T lookUp(final Scope scope, final String name) {
		final List<T> list = new ArrayList<T>();
		final List<T> resultList = this.lookUp(scope, name, list);
		if (!resultList.isEmpty()) {
			return resultList.get(0);
		}
		return null;
	}

	public List<T> lookUpAll(final Scope scope, final String name) {
		final List<T> list = new ArrayList<T>();
		return this.lookUp(scope, name, list);
	}

	private List<T> lookUp(final Scope scope, final String name, List<T> result) {
		Scope currScope = scope;
		while (currScope != null) {
			if (currScope instanceof TranslationUnit) {
				result = this.lookUpFor((TranslationUnit) currScope, name,
						result);
			}
			final EList<Statement> list = currScope.getStatements();
			for (int i = 0; i < list.size(); i++) {
				final Statement elem = list.get(i);
				if (this.type.isInstance(elem)) {
					@SuppressWarnings("unchecked")
					final T item = (T) elem;
					if (item.getName().equals(name)) {
						result.add(item);
					}
				}
			}
			currScope = currScope.getParent();
		}
		return result;
	}

	private List<T> lookUpFor(final TranslationUnit scope, final String name,
			final List<T> list) {
		final List<PreprocessorIncludeStatement> includes = this
				.getIncludes(scope);
		for (int i = 0; i < includes.size(); i++) {
			final PreprocessorIncludeStatement include = includes.get(0);
			final TranslationUnit unit = include.getUnit();
			if (unit != null) {
				return this.lookUp(unit, name, list);
			}
		}
		return list;
	}

	private List<PreprocessorIncludeStatement> getIncludes(
			final TranslationUnit scope) {
		final List<PreprocessorIncludeStatement> result = new ArrayList<PreprocessorIncludeStatement>();
		for (final Statement stmt : scope.getStatements()) {
			if (stmt instanceof PreprocessorIncludeStatement) {
				result.add((PreprocessorIncludeStatement) stmt);
			}
		}
		return result;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private List<T> lookUpParametersWorkAround(final String name,
			final List<T> result, final T item) {
		if (item instanceof FunctionDefinition) {
			final FunctionDefinition function = (FunctionDefinition) item;
			final EList<Variable> variables = function.getParameters();
			for (int i = 0; i < variables.size(); i++) {
				final Variable var = variables.get(i);
				if (name.equals(name) && this.type.equals(Variable.class)) {
					result.add((T) var);
				}
			}
		}
		return result;
	}

}
