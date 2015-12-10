package org.eclipse.modisco.cdt.discoverer.ast.my;

import org.eclipse.cdt.core.dom.ast.IASTCompoundStatement;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTDeclarationStatement;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDefinition;
import org.eclipse.cdt.core.dom.ast.IASTStatement;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.modisco.cdt.CompoundStatement;
import org.eclipse.modisco.cdt.Declaration;
import org.eclipse.modisco.cdt.Function;
import org.eclipse.modisco.cdt.FunctionDefinition;
import org.eclipse.modisco.cdt.Scope;
import org.eclipse.modisco.cdt.Statement;
import org.eclipse.modisco.cdt.TranslationUnit;
import org.eclipse.modisco.cdt.discoverer.ast.utils.ASTUtils;
import org.eclipse.modisco.cdt.discoverer.utils.MyStore;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

public final class MyASTLookUp {

	private final MyStore store;
	private String location;

	public MyASTLookUp(final MyStore store) {
		this.store = store;
		this.location = null;
	}

	public final TranslationUnit lookUp(final IASTTranslationUnit tu)
			throws DiscoveryException {
		this.visitAllNodes(tu);

		System.out.println("visitTranslationUnit=" + tu.getFilePath());
		final MyASTTranslationUnit myUnit = new MyASTTranslationUnit(
				this.store, tu);
		final TranslationUnit unit = myUnit.lookUpTranslationUnit();
		final String uid = unit.getFullPath();
		if (this.store.getAlreadyParsed().containsKey(uid)) {
			return this.store.getAlreadyParsed().get(uid);
		}
		this.store.getAlreadyParsed().put(uid, unit);
		myUnit.lookUpIncludesFirst(this);
		// this.store.getModel().getUnits().add(unit);
		// myUnit.updatePreprocessorIncludesToNewTranslationUnit();
		this.location = ASTUtils.getFileLocation(tu);

		this.enterScope(unit);
		this.visitAllDeclarations(tu);

		this.leaveScope();

		return unit;
	}

	private final void visitAllNodes(final IASTTranslationUnit tu) {
		final MyASTVisitor visitor = new MyASTVisitor();
		tu.accept(visitor);
	}

	private final void visitAllDeclarations(final IASTTranslationUnit tu) {
		final IASTDeclaration[] declarations = tu.getDeclarations();
		if (declarations == null) {
			return;
		}
		for (int i = 0; i < declarations.length; i++) {
			final IASTDeclaration dec = declarations[i];
			this.visit(dec);
		}
	}

	private final void enterScope(final Scope newScope) {
		newScope.setParent(this.store.getScope());
		this.store.setScope(newScope);
	}

	private final void leaveScope() {
		this.store.setScope(this.store.getScope().getParent());
	}

	private final void visit(final IASTDeclaration declaration) {
		System.out.println("visitDeclaration=" + declaration.toString());
		// ignore #include macro expansion declarations!
		if (!ASTUtils.theSame(this.location, declaration)) {
			return;
		}
		final Declaration declare = MyDeclaration.lookUpDeclaration(this.store,
				declaration);
		if (declare instanceof Function) {
			this.enterScope((Scope) declare);
		}
		if (ASTUtils.isFunctionDefinition(declaration)) {
			final IASTFunctionDefinition def = (IASTFunctionDefinition) declaration;
			final Statement stmt = this.visit(def.getBody());
			final FunctionDefinition funDef = (FunctionDefinition) declare;
			funDef.setBody((CompoundStatement) stmt);
		}
		this.leave(declaration, declare);
	}

	private final void leave(final IASTDeclaration declaration,
			final Declaration declare) {
		System.out.println("leaveDeclaration='" + declaration.toString());
		if (declare instanceof Function) {
			this.leaveScope();
		}
	}

	private final Statement visit(final IASTStatement statement) {
		final Statement result = MyStatement.lookUpStatement(this.store,
				statement);
		if (statement instanceof IASTCompoundStatement) {
			this.enterScope((CompoundStatement) result);
			final IASTCompoundStatement body = (IASTCompoundStatement) statement;
			this.visitStatements(body.getStatements());
		}
		if (statement instanceof IASTDeclarationStatement) {
			final IASTDeclarationStatement decStmt = (IASTDeclarationStatement) statement;
			final IASTDeclaration dec = decStmt.getDeclaration();
			this.visit(dec);
		}
		this.leave(statement);
		return result;
	}

	private final void visitStatements(final IASTStatement[] statements) {
		if (statements == null) {
			return;
		}
		for (int i = 0; i < statements.length; i++) {
			this.visit(statements[i]);
		}
	}

	private final void leave(final IASTStatement statement) {
		if (statement instanceof IASTCompoundStatement) {
			this.leaveScope();
		}
	}

}
