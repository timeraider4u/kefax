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
package org.eclipse.modisco.kconfig.discoverer.actions;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.modisco.infra.discovery.core.AbstractModelDiscoverer;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;
import org.eclipse.modisco.kconfig.Model;
import org.eclipse.modisco.kconfig.discoverer.Activator;

public class DiscoverKCONFIGFromProject extends
AbstractModelDiscoverer<IResource> {
	public static final String ID = "org.eclipse.modisco.cdt.discoverer.kconfigPoject2Model"; //$NON-NLS-1$

	@Override
	public boolean isApplicableTo(final IResource resource) {
		System.out
		.println(DiscoverKCONFIGFromProject.ID + " - isAplicableTo()");
		return AccessibilityUtils.isAccessible(resource);
	}

	@Override
	protected void basicDiscoverElement(final IResource resource,
			final IProgressMonitor monitor) throws DiscoveryException {
		monitor.beginTask(Messages.discoveringModel, IProgressMonitor.UNKNOWN);
		final Model model = DiscovererUtils.getEFactory().createModel();
		final String fileName = resource.getLocation().toString();
		model.setFullPath(fileName);
		final Resource targetModel = this.createTargetModel();
		targetModel.getContents().add(model);
		this.setDefaultTargetURI(URI.createPlatformResourceURI(resource
				.getFullPath().toString().concat(Activator.MODEL_FILE_SUFFIX),
				true));
		try {
			DiscovererUtils.discoverElement(resource, model);
		} catch (final CoreException ex) {
			ex.printStackTrace();
		}
		monitor.done();
	}

}
