package at.jku.weiner.c.modisco.discoverer.actions;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.modisco.discoverer.utils.Messages;

public class DiscoverFromIResource extends AbstractDiscovererWithLogic<IResource> {
	private static final String ID = Messages.prefix + "DiscoverCDTFromProject"; //$NON-NLS-1$
	
	@Override
	public boolean isApplicableTo(final IResource resource) {
		MyLog.trace(DiscoverFromIFile.class, DiscoverFromIResource.ID
				+ " - isAplicableTo()");
		final boolean result = super.isApplicableOn(resource);
		MyLog.trace(DiscoverFromIFile.class, "result='" + result + "'");
		return result;
	}
	
	@Override
	protected void basicDiscoverElement(final IResource resource,
			final IProgressMonitor monitor) throws DiscoveryException {
		super.discover(resource, monitor);
	}
	
}
