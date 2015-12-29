package org.eclipse.modisco.cdt.discoverer.ast.utils;

import org.eclipse.cdt.core.dom.ast.IASTDeclSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDefinition;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;

public final class ASTUtils {

	private ASTUtils() {
	}

	public static String getFileLocation(final IASTNode node) {
		return node.getContainingFilename();
	}

	public static boolean theSame(final String location, final IASTNode node) {
		final String newLocation = ASTUtils.getFileLocation(node);
		return location.equals(newLocation);
	}

	public static boolean isFunctionDeclaration(final IASTDeclaration dec) {
		if (dec instanceof IASTSimpleDeclaration) {
			final IASTDeclarator[] declarators = ((IASTSimpleDeclaration) dec)
					.getDeclarators();
			final IASTDeclarator decl = declarators[0];
			final boolean result = (decl instanceof IASTFunctionDeclarator);
			return result;
		}
		return false;
	}

	public static boolean isFunctionDefinition(final IASTDeclaration dec) {
		return (dec instanceof IASTFunctionDefinition);
	}

	public static boolean isVariable(final IASTDeclaration dec) {
		if (dec instanceof IASTSimpleDeclaration) {
			if (ASTUtils.isFunctionDeclaration(dec)) {
				return false;
			}
			final IASTDeclSpecifier spec = ((IASTSimpleDeclaration) dec)
					.getDeclSpecifier();
			return (spec.getStorageClass() == IASTDeclSpecifier.sc_unspecified);
		}
		return false;
	}

	public static boolean isTypeDef(final IASTDeclaration dec) {
		if (dec instanceof IASTSimpleDeclaration) {
			final IASTDeclSpecifier spec = ((IASTSimpleDeclaration) dec)
					.getDeclSpecifier();
			return (spec.getStorageClass() == IASTDeclSpecifier.sc_typedef);
		}
		return false;
	}
}
