package at.jku.weiner.c.modisco.discoverer.actions;

import org.eclipse.cdt.core.model.ICContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

public class DiscoverFromICContainer extends
AbstractDiscoverer<ICContainer> {
	private static final String ID = AbstractDiscoverer.PREFIX
			+ "DiscoverCDTFromSource"; //$NON-NLS-1$

	@Override
	public boolean isApplicableTo(final ICContainer source) {
		System.out
		.println(DiscoverFromICContainer.ID + " - isAplicableTo()");
		final IResource resource = source.getResource();
		boolean result = super.isApplicableOn(resource);
		System.out.println("result='" + result + "'");
		return result;
	}

	@Override
	protected void basicDiscoverElement(final ICContainer source,
			final IProgressMonitor monitor) throws DiscoveryException {
		final IResource resource = source.getResource();
		super.discover(resource, monitor);
	}

}
