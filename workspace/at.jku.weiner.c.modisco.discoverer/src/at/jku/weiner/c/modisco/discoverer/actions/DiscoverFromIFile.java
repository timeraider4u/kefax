package at.jku.weiner.c.modisco.discoverer.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.modisco.discoverer.utils.Messages;

public class DiscoverFromIFile extends AbstractDiscovererWithLogic<IFile> {
	private static final String ID = Messages.prefix + "DiscoverCDTFromIFile"; //$NON-NLS-1$
	
	@Override
	public boolean isApplicableTo(final IFile source) {
		MyLog.trace(DiscoverFromIFile.class, DiscoverFromIFile.ID
				+ " - isAplicableTo()");
		final boolean result = super.isApplicableOn(source);
		MyLog.trace(DiscoverFromIFile.class, "result='" + result + "'");
		return result;
	}
	
	@Override
	protected void basicDiscoverElement(final IFile source,
			final IProgressMonitor monitor) throws DiscoveryException {
		super.discover(source, monitor);
	}
	
}
