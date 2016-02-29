package at.jku.weiner.c.modisco.discoverer.actions.impl;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.modisco.discoverer.actions.AbstractDiscovererWithLogic;

public class DiscoverFromIFile extends AbstractDiscovererWithLogic<IFile> {

	@Override
	public boolean isApplicableTo(final IFile source) {
		return super.isApplicableOn(source);
	}

	@Override
	protected void basicDiscoverElement(final IFile source,
			final IProgressMonitor monitor) throws DiscoveryException {
		super.discover(source, monitor);
	}

}
