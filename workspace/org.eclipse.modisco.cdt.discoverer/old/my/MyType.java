package org.eclipse.modisco.cdt.discoverer.ast.my;

import org.eclipse.cdt.core.dom.ast.IASTDeclSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTNamedTypeSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclSpecifier;
import org.eclipse.modisco.cdt.Type;
import org.eclipse.modisco.cdt.discoverer.utils.MyStore;

public class MyType {

	public static Type lookUpType(final MyStore store,
			final IASTDeclSpecifier decl) {
		Type result = null;
		if (decl instanceof IASTSimpleDeclSpecifier) {
			result = MyType.lookUpSimpleDeclSpecifier(store,
					(IASTSimpleDeclSpecifier) decl);
		} else if (decl instanceof IASTNamedTypeSpecifier) {
			result = MyType.lookUpTypedefDeclSpecifier(store,
					(IASTNamedTypeSpecifier) decl);
		} else {
			System.out.println("declSpecifier =" + decl);
		}
		return result;
	}

	private static Type lookUpSimpleDeclSpecifier(final MyStore store,
			final IASTSimpleDeclSpecifier declSpecifier) {
		String typeName = "unknownTypeName";
		switch (declSpecifier.getType()) {
		case IASTSimpleDeclSpecifier.t_bool:
			typeName = "bool";
			break;
		case IASTSimpleDeclSpecifier.t_char:
			typeName = "char";
			break;
		case IASTSimpleDeclSpecifier.t_double:
			typeName = "double";
			break;
		case IASTSimpleDeclSpecifier.t_float:
			typeName = "float";
			break;
		case IASTSimpleDeclSpecifier.t_int:
			typeName = "int";
			break;
		case IASTSimpleDeclSpecifier.t_void:
			typeName = "void";
			break;
		default:
			break;
		}
		final Type result = MyType.lookUpTypeFor(store, typeName);
		return result;
	}

	public static Type lookUpTypeFor(final MyStore store, final String typeName) {
		MyLookUp<Type> lookUp = new MyLookUp<Type>(Type.class);
		Type result = lookUp.lookUp(store.getScope(), typeName);
		if (result == null) {
			result = store.getFactory().createType();
			result.setName(typeName);
			// store.getModel().getStatements().add(result);
		}
		return result;
	}

	private static Type lookUpTypedefDeclSpecifier(final MyStore store,
			final IASTNamedTypeSpecifier decl) {
		final String name = decl.getName().toString();
		final Type result = MyType.lookUpTypeFor(store, name);
		// final Type result = factory.createType();
		// result.setName(name);
		return result;
	}

}
