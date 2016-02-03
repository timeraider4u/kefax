package at.jku.weiner.c.modisco.discoverer.actions;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

public class DiscoverFromIResource extends AbstractDiscoverer<IResource> {
	@SuppressWarnings("unused")
	private static final String ID = AbstractDiscoverer.PREFIX
	+ "DiscoverCDTFromProject"; //$NON-NLS-1$
	
	@Override
	public boolean isApplicableTo(final IResource resource) {
		// System.out.println(DiscoverCDTFromIResource.ID +
		// " - isAplicableTo()");
		final boolean result = super.isApplicableOn(resource);
		// System.out.println("result='" + result + "'");
		return result;
	}
	
	@Override
	protected void basicDiscoverElement(final IResource resource,
			final IProgressMonitor monitor) throws DiscoveryException {
		super.discover(resource, monitor);
	}
	
}
