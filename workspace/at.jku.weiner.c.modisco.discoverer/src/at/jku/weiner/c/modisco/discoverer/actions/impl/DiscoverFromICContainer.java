package at.jku.weiner.c.modisco.discoverer.actions.impl;

import org.eclipse.cdt.core.model.ICContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.modisco.discoverer.actions.AbstractDiscovererWithLogic;

public class DiscoverFromICContainer extends
		AbstractDiscovererWithLogic<ICContainer> {

	@Override
	public boolean isApplicableTo(final ICContainer source) {
		final IResource resource = source.getResource();
		return super.isApplicableOn(resource);
	}

	@Override
	protected void basicDiscoverElement(final ICContainer source,
			final IProgressMonitor monitor) throws DiscoveryException {
		final IResource resource = source.getResource();
		super.discover(resource, monitor);
	}

}
