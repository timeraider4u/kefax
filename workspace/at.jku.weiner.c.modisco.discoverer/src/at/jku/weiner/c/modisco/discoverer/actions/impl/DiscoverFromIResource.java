package at.jku.weiner.c.modisco.discoverer.actions.impl;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.modisco.discoverer.actions.AbstractDiscovererWithLogic;

public class DiscoverFromIResource extends
		AbstractDiscovererWithLogic<IResource> {
	@Override
	public boolean isApplicableTo(final IResource resource) {
		return super.isApplicableOn(resource);
	}

	@Override
	protected void basicDiscoverElement(final IResource resource,
			final IProgressMonitor monitor) throws DiscoveryException {
		super.discover(resource, monitor);
	}

}
