package at.jku.weiner.c.modisco.discoverer.utils;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.common.common.CommonFactory;
import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.modisco.discoverer.backend.IDiscoverer;
import at.jku.weiner.c.modisco.discoverer.backend.SerializationBackend;
import at.jku.weiner.log.MyLog;

public final class MyStore {

	private final MySettings mySettings;
	private final SerializationBackend backend;
	private final IProgressMonitor monitor;
	private final IResource iResource;

	private final CommonFactory factory;

	private final Model model;
	private final IDiscoverer discoverer;

	public MyStore(final MySettings mySettings,
			final SerializationBackend backend, final IProgressMonitor monitor,
			final IResource iResource, final IDiscoverer discoverer)
			throws DiscoveryException {
		this.mySettings = mySettings;
		this.backend = backend;
		this.monitor = monitor;
		this.iResource = iResource;
		this.discoverer = discoverer;

		MyLog.trace(MyStore.class, "getting common factory!");
		this.factory = ModelUtils.getCommonFactory();
		MyLog.trace(MyStore.class, "creating/getting model!");
		this.model = ModelUtils.getModel(mySettings,
				discoverer.getTargetResource());
		MyLog.trace(MyStore.class, "initialization of MyStore finished!");
	}

	public MySettings getMySettings() {
		return this.mySettings;
	}

	public SerializationBackend getBackend() {
		return this.backend;
	}

	public IProgressMonitor getMonitor() {
		return this.monitor;
	}

	public IResource getIResource() {
		return this.iResource;
	}

	public CommonFactory getFactory() {
		return this.factory;
	}

	public Model getModel() {
		return this.model;
	}

	public IDiscoverer getDiscoverer() {
		return this.discoverer;
	}

}
