package at.jku.weiner.c.modisco.discoverer.actions;

import org.eclipse.cdt.core.model.ICContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.modisco.discoverer.utils.Messages;

public class DiscoverFromICContainer extends AbstractDiscovererWithLogic<ICContainer> {
	private static final String ID = Messages.prefix + "DiscoverCDTFromSource"; //$NON-NLS-1$
	
	@Override
	public boolean isApplicableTo(final ICContainer source) {
		MyLog.trace(DiscoverFromIFile.class, DiscoverFromICContainer.ID
				+ " - isAplicableTo()");
		final IResource resource = source.getResource();
		final boolean result = super.isApplicableOn(resource);
		MyLog.trace(DiscoverFromIFile.class, "result='" + result + "'");
		return result;
	}
	
	@Override
	protected void basicDiscoverElement(final ICContainer source,
			final IProgressMonitor monitor) throws DiscoveryException {
		final IResource resource = source.getResource();
		super.discover(resource, monitor);
	}
	
}
