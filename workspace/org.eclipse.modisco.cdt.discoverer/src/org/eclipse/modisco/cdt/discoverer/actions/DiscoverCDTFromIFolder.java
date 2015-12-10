package org.eclipse.modisco.cdt.discoverer.actions;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

public class DiscoverCDTFromIFolder extends AbstractCDTDiscoverer<IFolder> {
	private static final String ID = AbstractCDTDiscoverer.PREFIX
			+ "DiscoverCDTFromIFolder"; //$NON-NLS-1$

	@Override
	public boolean isApplicableTo(final IFolder source) {
		System.out.println(DiscoverCDTFromIFolder.ID + " - isAplicableTo()");
		boolean result = super.isApplicableOn(source);
		System.out.println("result='" + result + "'");
		return result;
	}

	@Override
	protected void basicDiscoverElement(final IFolder source,
			final IProgressMonitor monitor) throws DiscoveryException {
		super.discover(source, monitor);
	}

}
