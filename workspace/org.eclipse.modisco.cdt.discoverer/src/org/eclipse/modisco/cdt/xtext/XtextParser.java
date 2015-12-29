package org.eclipse.modisco.cdt.xtext;

import org.eclipse.core.resources.IFile;
import org.eclipse.modisco.cdt.discoverer.utils.MyStore;

import at.jku.weiner.c.parser.parser.Parser;

public class XtextParser extends XtextHandler<Parser> {

	public XtextParser(final MyStore store) {
		super(new String[] { "i" }, store, XtextHandler.setupParser());
	}

	@Override
	public String getOutputPath(final IFile iFile) {
		return null;
	}

	@Override
	protected void setUpGenerator() {

	}

}
