package at.jku.weiner.c.modisco.discoverer.xtext;

import org.eclipse.core.resources.IFile;

import at.jku.weiner.c.modisco.discoverer.utils.MyStore;
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
