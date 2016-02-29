package at.jku.weiner.c.modisco.discoverer.utils;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.common.common.CommonFactory;
import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.modisco.discoverer.actions.XtextUtils;

public final class MyStore {

	private final MySettings mySettings;
	private final IProgressMonitor monitor;
	private final CommonFactory factory;
	private final Model model;
	private final XtextUtils parser;
	private final IResource resource;

	public MyStore(final MySettings mySettings, final IProgressMonitor monitor,
			final Resource targetModel, final IResource resource)
					throws DiscoveryException {
		this.mySettings = mySettings;
		this.monitor = monitor;
		this.resource = resource;

		this.factory = CommonFactory.eINSTANCE;
		if (this.factory == null) {
			throw new DiscoveryException("factory is null!");
		}

		this.model = this.getModel(targetModel);
		this.parser = new XtextUtils(this);
	}

	private Model getModel(final Resource targetModel) {
		final EList<EObject> list = targetModel.getContents();
		if (this.mySettings.isBatchMode() && (list != null)
				&& (list.size() == 1)) {
			final EObject root = targetModel.getContents().get(0);
			if (root instanceof Model) {
				return (Model) root;
			}
		}
		return this.createNewModel(targetModel);
	}

	private Model createNewModel(final Resource targetModel) {
		final Model result = this.factory.createModel();
		targetModel.getContents().add(result);
		return result;
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

	public XtextUtils getParser() {
		return this.parser;
	}

	public MySettings getMySettings() {
		return this.mySettings;
	}

	public IResource getResource() {
		return resource;
	}

}
