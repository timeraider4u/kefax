package at.jku.weiner.c.modisco.discoverer.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

public class DiscoverFromIFile extends AbstractDiscoverer<IFile> {
	private static final String ID = AbstractDiscoverer.PREFIX
			+ "DiscoverCDTFromIFile"; //$NON-NLS-1$

	@Override
	public boolean isApplicableTo(final IFile source) {
		System.out.println(DiscoverFromIFile.ID + " - isAplicableTo()");
		boolean result = super.isApplicableOn(source);
		System.out.println("result='" + result + "'");
		return result;
	}

	@Override
	protected void basicDiscoverElement(final IFile source,
			final IProgressMonitor monitor) throws DiscoveryException {
		super.discover(source, monitor);
	}

}
