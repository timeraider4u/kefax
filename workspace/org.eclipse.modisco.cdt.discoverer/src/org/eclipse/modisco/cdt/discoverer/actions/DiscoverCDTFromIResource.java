/*********************************************************************************
 * Copyright (c) 2009,2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Fabien Giquel (Mia-Software) - initial API and implementation
 *    Nicolas Bros (Mia-Software) - adapted to new discovery framework (Bug 335003)
 *********************************************************************************/
package org.eclipse.modisco.cdt.discoverer.actions;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

public class DiscoverCDTFromIResource extends AbstractCDTDiscoverer<IResource> {
	private static final String ID = AbstractCDTDiscoverer.PREFIX
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
