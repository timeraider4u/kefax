package org.eclipse.modisco.cdt.discoverer.ast.my;

import java.util.List;

import org.eclipse.cdt.core.dom.ast.IASTDeclSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDefinition;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.emf.common.util.EList;
import org.eclipse.modisco.cdt.Declaration;
import org.eclipse.modisco.cdt.FunctionDeclaration;
import org.eclipse.modisco.cdt.FunctionDefinition;
import org.eclipse.modisco.cdt.Type;
import org.eclipse.modisco.cdt.Variable;
import org.eclipse.modisco.cdt.discoverer.ast.utils.ASTUtils;
import org.eclipse.modisco.cdt.discoverer.utils.MyStore;

public class MyDeclaration {

	public static Declaration lookUpDeclaration(final MyStore store,
			final IASTDeclaration dec) {
		Declaration declare = null;
		if (ASTUtils.isFunctionDefinition(dec)) {
			declare = MyDeclaration.lookUpFunctionDefinition(store,
					(IASTFunctionDefinition) dec);
		} else if (ASTUtils.isFunctionDeclaration(dec)) {
			declare = MyDeclaration.lookUpFunctionDeclaration(store,
					(IASTSimpleDeclaration) dec);
		} else if (ASTUtils.isVariable(dec)) {
			declare = MyDeclaration.lookUpVariable(store,
					(IASTSimpleDeclaration) dec);
		} else if (ASTUtils.isTypeDef(dec)) {
			declare = MyDeclaration.lookUpTypeDef(store,
					(IASTSimpleDeclaration) dec);
		}
		return declare;
	}

	private static Declaration lookUpTypeDef(final MyStore store,
			final IASTSimpleDeclaration dec) {
		final Type type = MyType.lookUpType(store, dec.getDeclSpecifier());
		final Type result = store.getFactory().createType();
		store.getScope().getStatements().add(result);
		result.setParent(type);
		final IASTDeclarator[] declarators = dec.getDeclarators();
		final IASTDeclarator decl = declarators[0];
		result.setName(decl.getName().toString());
		return result;
	}

	private static Declaration lookUpFunctionDefinition(final MyStore store,
			final IASTFunctionDefinition dec) {
		final FunctionDefinition result = store.getFactory()
				.createFunctionDefinition();
		store.getScope().getStatements().add(result);
		final IASTFunctionDeclarator declarator = dec.getDeclarator();
		final String name = declarator.getName().toString();
		result.setName(name);
		final IASTDeclSpecifier decl = dec.getDeclSpecifier();
		final Type type = MyType.lookUpType(store, decl);
		result.setReturnType(type);
		MyParameters.lookUpParameters(store, result, declarator);
		final EList<Variable> parametersCurrent = result.getParameters();

		final MyLookUp<FunctionDeclaration> lookUp = new MyLookUp<FunctionDeclaration>(
				FunctionDeclaration.class);
		final List<FunctionDeclaration> declarations = lookUp.lookUpAll(
				store.getScope(), name);
		for (final FunctionDeclaration declare : declarations) {
			final boolean match = MyDeclaration.functionParameterTypesMatch(
					parametersCurrent, declare);
			if (match) {
				result.getFunctionDeclarations().add(declare);
			}
		}

		// TODO: lookUp already existing declarations and set to them!
		//
		// TODO: final boolean isConst = declSpecifier.isConst();
		// TODO: final boolean isInline = declSpecifier.isInline();
		// CompoundStatement stmt = (CompoundStatement) MyStatement
		// .lookUpStatement(factory, dec.getBody());
		// if (stmt == null) {
		// stmt = factory.createCompoundStatement();
		// }
		// def.setBody(stmt);
		return result;
	}

	private static boolean functionParameterTypesMatch(
			final EList<Variable> parametersCurrent,
			final FunctionDeclaration declare) {
		final EList<Variable> parametersCheck = declare.getParameters();
		if (parametersCurrent.size() != parametersCheck.size()) {
			return false;
		}
		for (int i = 0; i < parametersCurrent.size(); i++) {
			final Variable varCurr = parametersCurrent.get(i);
			final Variable varChec = parametersCheck.get(i);
			final Type tCurr = varCurr.getType();
			final Type tChec = varChec.getType();
			if (tCurr != tChec) {
				return false;
			}
		}
		return true;
	}

	private static Declaration lookUpFunctionDeclaration(final MyStore store,
			final IASTSimpleDeclaration dec) {
		final IASTDeclarator[] declarators = dec.getDeclarators();
		final FunctionDeclaration result = store.getFactory()
				.createFunctionDeclaration();
		store.getScope().getStatements().add(result);
		if ((declarators == null) || (declarators.length <= 0)) {
			return result;
		}
		final IASTDeclarator declarator = declarators[0];
		final IASTDeclSpecifier decl = dec.getDeclSpecifier();
		final Type type = MyType.lookUpType(store, decl);
		result.setReturnType(type);
		final String name = declarator.getName().toString();
		result.setName(name);
		MyParameters.lookUpParameters(store, result, declarator);

		return result;
	}

	private static Declaration lookUpVariable(final MyStore store,
			final IASTSimpleDeclaration dec) {
		final Type type = MyType.lookUpType(store, dec.getDeclSpecifier());
		final IASTDeclarator[] declarators = dec.getDeclarators();
		final IASTDeclarator decl = declarators[0];
		final String name = decl.getName().toString();
		Variable result = MyDeclaration.lookUpVariable(store, name);
		if (result == null) {
			result = store.getFactory().createVariable();
			result.setName(name);
			store.getScope().getStatements().add(result);
			result.setType(type);
		}
		MyInitializer.lookUp(store, decl.getInitializer(), result);
		return result;
	}

	public static Variable lookUpVariable(final MyStore store, final String name) {
		final MyLookUp<Variable> lookUp = new MyLookUp<Variable>(Variable.class);
		final Variable result = lookUp.lookUp(store.getScope(), name);
		return result;
	}
}
