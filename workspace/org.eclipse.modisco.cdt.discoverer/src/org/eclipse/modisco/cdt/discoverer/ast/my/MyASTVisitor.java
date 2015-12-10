package org.eclipse.modisco.cdt.discoverer.ast.my;

import org.eclipse.cdt.core.dom.ast.ASTGenericVisitor;
import org.eclipse.cdt.core.dom.ast.IASTNode;

public class MyASTVisitor extends ASTGenericVisitor {

	public MyASTVisitor() {
		super(true);
	}

	@Override
	protected int genericVisit(final IASTNode node) {
		System.out.println("genericVisit='" + node.toString() + "'");
		return super.genericVisit(node);
	}

}
