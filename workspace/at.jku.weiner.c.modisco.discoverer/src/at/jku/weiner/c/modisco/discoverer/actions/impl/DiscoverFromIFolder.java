package at.jku.weiner.c.modisco.discoverer.actions.impl;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.modisco.discoverer.actions.AbstractDiscovererWithLogic;

public class DiscoverFromIFolder extends AbstractDiscovererWithLogic<IFolder> {

	@Override
	public boolean isApplicableTo(final IFolder source) {
		return super.isApplicableOn(source);
	}

	@Override
	protected void basicDiscoverElement(final IFolder source,
			final IProgressMonitor monitor) throws DiscoveryException {
		super.discover(source, monitor);
	}

}
