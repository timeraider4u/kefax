package org.eclipse.modisco.cdt.discoverer.ast.my;

import java.io.File;

import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.modisco.cdt.TranslationUnit;
import org.eclipse.modisco.cdt.discoverer.utils.MyStore;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

public class MyASTTranslationUnit {

	private final TranslationUnit unit;
	private final MyStore store;
	private final MyPreprocessor preprocessor;

	public MyASTTranslationUnit(final MyStore store,
			final IASTTranslationUnit tu) {
		this.store = store;
		this.unit = this.store.getFactory().createTranslationUnit();
		this.preprocessor = new MyPreprocessor(this.store, this.unit, tu);
		// preprocessor.lookUp();
		final String fullFileName = tu.getContainingFilename();
		final String fileName = this.getSimpleFileName(fullFileName);
		this.unit.setName(fileName);
		this.unit.setFullPath(fullFileName);
	}

	private String getSimpleFileName(final String fullFileName) {
		final int index = fullFileName.lastIndexOf(File.separator);
		if ((index < 0) || (index == (fullFileName.length() - 1))) {
			return fullFileName;
		}
		return fullFileName.substring(index + 1);
	}

	public TranslationUnit lookUpTranslationUnit() {
		return this.unit;
	}

	public void lookUpIncludesFirst(final MyASTLookUp myASTVisitor)
			throws DiscoveryException {
		this.preprocessor.lookUp(myASTVisitor);
	}

	/*
	 * public void updatePreprocessorIncludesToNewTranslationUnit() { for (final
	 * TranslationUnit u : this.model.getUnits()) {
	 * this.updatePreprocessorIncludesToNewTranslationUnit(u); } }
	 * 
	 * private void updatePreprocessorIncludesToNewTranslationUnit( final
	 * TranslationUnit u) { System.out
	 * .println("Testing updatePreprocessorIncludesToNewTranslationUnit for '" +
	 * u.getName() + "'"); System.out.println("includes='" +
	 * u.getIncludes().size() + "'"); for (final PrecompilerInclude include :
	 * u.getIncludes()) { System.out .println("Testing update includes for '" +
	 * include.getName() + "' and '" + this.unit.getName() + "'"); if
	 * (include.getName().equals(this.unit.getName())) { System.out
	 * .println("updatePreprocessorIncludesToNewTranslationUnit='" +
	 * include.getName()); include.setUnit(this.unit); } } }
	 */

}
