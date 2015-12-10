package org.eclipse.modisco.cdt.discoverer.ast.my;

import org.eclipse.cdt.core.dom.ast.IASTDeclSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTParameterDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTStandardFunctionDeclarator;
import org.eclipse.modisco.cdt.Function;
import org.eclipse.modisco.cdt.Type;
import org.eclipse.modisco.cdt.Variable;
import org.eclipse.modisco.cdt.discoverer.utils.MyStore;

public class MyParameters {

	public static void lookUpParameters(final MyStore store,
			final Function def, final IASTDeclarator declarator) {
		if (declarator instanceof IASTStandardFunctionDeclarator) {
			MyParameters.lookUpMyParameters(store, def,
					(IASTStandardFunctionDeclarator) declarator);
		}
	}

	private static void lookUpMyParameters(final MyStore store,
			final Function def, final IASTStandardFunctionDeclarator declarator) {
		final IASTParameterDeclaration[] parameters = declarator
				.getParameters();
		if (parameters == null) {
			return;
		}
		for (final IASTParameterDeclaration param : parameters) {
			final IASTDeclSpecifier decl = param.getDeclSpecifier();
			String name = param.getDeclarator().getName().toString();
			if (name == null) {
				name = "";
			}
			final Type type = MyType.lookUpType(store, decl);
			final Variable variable = store.getFactory().createVariable();
			// store.getScope().getDeclarations().add(variable);
			variable.setName(name);
			variable.setType(type);
			def.getStatements().add(variable);
			def.getParameters().add(variable);
		}
	}
}
