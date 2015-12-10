package org.eclipse.modisco.cdt.discoverer.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

public class DiscoverCDTFromIFile extends AbstractCDTDiscoverer<IFile> {
	private static final String ID = AbstractCDTDiscoverer.PREFIX
			+ "DiscoverCDTFromIFile"; //$NON-NLS-1$

	@Override
	public boolean isApplicableTo(final IFile source) {
		System.out.println(DiscoverCDTFromIFile.ID + " - isAplicableTo()");
		boolean result = super.isApplicableOn(source);
		System.out.println("result='" + result + "'");
		return result;
	}

	@Override
	protected void basicDiscoverElement(final IFile source,
			final IProgressMonitor monitor) throws DiscoveryException {
		super.discover(source, monitor);
	}

}
