package at.jku.weiner.c.modisco.discoverer.utils;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.common.common.CommonFactory;
import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.modisco.discoverer.backend.IDiscoverer;

public final class MyStore {

	private final MySettings mySettings;
	private final IProgressMonitor monitor;
	private final IResource iResource;

	private final CommonFactory factory;

	private final Model model;

	public MyStore(final MySettings mySettings, final IProgressMonitor monitor,
			final IResource iResource, final IDiscoverer discoverer)
			throws DiscoveryException {
		this.mySettings = mySettings;
		this.monitor = monitor;
		this.iResource = iResource;

		this.factory = ModelUtils.getCommonFactory();
		this.model = ModelUtils.getModel(mySettings,
				discoverer.getTargetResource());
	}

	public IProgressMonitor getMonitor() {
		return this.monitor;
	}

	public CommonFactory getFactory() {
		return this.factory;
	}

	public Model getModel() {
		return this.model;
	}

	public MySettings getMySettings() {
		return this.mySettings;
	}

	public IResource getIResource() {
		return this.iResource;
	}

}
