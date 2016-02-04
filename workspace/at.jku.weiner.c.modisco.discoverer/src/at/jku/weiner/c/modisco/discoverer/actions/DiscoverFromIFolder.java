package at.jku.weiner.c.modisco.discoverer.actions;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.common.log.MyLog;

public class DiscoverFromIFolder extends AbstractDiscoverer<IFolder> {
	private static final String ID = AbstractDiscoverer.PREFIX
			+ "DiscoverCDTFromIFolder"; //$NON-NLS-1$

	@Override
	public boolean isApplicableTo(final IFolder source) {
		MyLog.trace(DiscoverFromIFile.class, DiscoverFromIFolder.ID
				+ " - isAplicableTo()");
		boolean result = super.isApplicableOn(source);
		MyLog.trace(DiscoverFromIFile.class, "result='" + result + "'");
		return result;
	}

	@Override
	protected void basicDiscoverElement(final IFolder source,
			final IProgressMonitor monitor) throws DiscoveryException {
		super.discover(source, monitor);
	}

}
