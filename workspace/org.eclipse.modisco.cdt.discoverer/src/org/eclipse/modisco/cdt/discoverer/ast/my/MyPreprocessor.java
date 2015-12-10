package org.eclipse.modisco.cdt.discoverer.ast.my;

import java.io.File;

import org.eclipse.cdt.core.dom.ast.IASTPreprocessorIncludeStatement;
import org.eclipse.cdt.core.dom.ast.IASTPreprocessorMacroDefinition;
import org.eclipse.cdt.core.dom.ast.IASTPreprocessorStatement;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.modisco.cdt.CdtFactory;
import org.eclipse.modisco.cdt.PreprocessorIncludeStatement;
import org.eclipse.modisco.cdt.PreprocessorMacro;
import org.eclipse.modisco.cdt.TranslationUnit;
import org.eclipse.modisco.cdt.discoverer.actions.ParserUtils;
import org.eclipse.modisco.cdt.discoverer.ast.utils.ASTUtils;
import org.eclipse.modisco.cdt.discoverer.utils.MyStore;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

public class MyPreprocessor {
	private final MyStore store;
	private final CdtFactory factory;
	private final TranslationUnit unit;
	@SuppressWarnings("unused")
	private final String location;
	private final IASTTranslationUnit cUnit;

	public MyPreprocessor(final MyStore store, final TranslationUnit unit,
			final IASTTranslationUnit cUnit) {
		this.store = store;
		this.factory = store.getFactory();
		this.unit = unit;
		this.cUnit = cUnit;
		this.location = ASTUtils.getFileLocation(cUnit);
	}

	public void lookUp(final MyASTLookUp myASTVisitor)
			throws DiscoveryException {
		this.lookUpIncludes(this.cUnit.getIncludeDirectives(), myASTVisitor);
		this.lookUpMacros(this.cUnit.getMacroDefinitions());
		this.lookUpOtherPreStmts(this.cUnit.getAllPreprocessorStatements());
	}

	private void lookUpIncludes(
			final IASTPreprocessorIncludeStatement[] includes,
			final MyASTLookUp myASTVisitor) throws DiscoveryException {
		if (includes == null) {
			return;
		}
		for (final IASTPreprocessorIncludeStatement inc : includes) {
			/*
			 * if (!Utils.theSame(this.location, inc)) { continue; }
			 */
			final PreprocessorIncludeStatement include = this.lookUpInclude(
					inc, myASTVisitor);
			this.unit.getStatements().add(include);
		}
	}

	private PreprocessorIncludeStatement lookUpInclude(
			final IASTPreprocessorIncludeStatement inc,
			final MyASTLookUp myASTVisitor) throws DiscoveryException {
		final PreprocessorIncludeStatement include = this.factory
				.createPreprocessorIncludeStatement();
		final String name = inc.getName().toString();
		final String loc = inc.getPath();
		final boolean std = inc.isSystemInclude();
		include.setName(name);
		include.setPath(loc);
		include.setStandard(std);
		if (!std) {
			System.err.println("Visiting translation unit..." + name);
			final ParserUtils utils = new ParserUtils(this.store.getMonitor());
			final File file = new File(loc);
			final IASTTranslationUnit tu = utils.getTranslationUnitFor(file,
					this.store);
			final TranslationUnit unit = myASTVisitor.lookUp(tu);
			include.setUnit(unit);
		}
		return include;
	}

	private void lookUpMacros(final IASTPreprocessorMacroDefinition[] macros) {
		if (macros == null) {
			return;
		}

		for (final IASTPreprocessorMacroDefinition mac : macros) {
			/*
			 * if (!Utils.theSame(this.location, mac)) { continue; }
			 */
			final PreprocessorMacro macro = this.lookUpMacro(this.factory, mac);
			this.unit.getStatements().add(macro);
		}
	}

	private PreprocessorMacro lookUpMacro(final CdtFactory factory,
			final IASTPreprocessorMacroDefinition def) {
		final PreprocessorMacro macro = factory.createPreprocessorMacro();
		final String name = def.getName().toString();
		final String value = def.getExpansion();
		macro.setName(name);
		macro.setValue(value);
		return macro;
	}

	private void lookUpOtherPreStmts(
			final IASTPreprocessorStatement[] allPreprocessorStatements) {
		if (allPreprocessorStatements == null) {
			return;
		}
		for (int i = 0; i < allPreprocessorStatements.length; i++) {
			final IASTPreprocessorStatement stmt = allPreprocessorStatements[i];
		}

	}
}
