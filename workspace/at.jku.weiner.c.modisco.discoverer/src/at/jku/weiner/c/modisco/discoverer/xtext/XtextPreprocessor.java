package at.jku.weiner.c.modisco.discoverer.xtext;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.modisco.discoverer.utils.MyStore;
import at.jku.weiner.c.preprocess.generator.PreprocessGenerator;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;

public class XtextPreprocessor extends XtextHandler<Preprocess> {

	public XtextPreprocessor(final MyStore store) {
		super(new String[] { "c,h" }, store, XtextHandler.setupPreprocessor());
	}

	@Override
	public String getOutputPath(final IFile iFile) throws DiscoveryException {
		IProject project = iFile.getProject();
		IFolder folder = project.getFolder("tmp-discover");
		if (!folder.exists()) {
			try {
				folder.create(true, true, this.store.getMonitor());
			} catch (CoreException ex) {
				throw new DiscoveryException(ex);
			}
		}
		final String tmpStr = folder.getLocationURI().toString();
		final String result = tmpStr.replaceAll("file[:]", "");
		return result;
	}

	@Override
	protected void setUpGenerator() {

	}

	public PreprocessGenerator getGenerator() {
		return (PreprocessGenerator) this.generator;
	}
}
