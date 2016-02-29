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
	private final IResource iResource;

	private final CommonFactory factory;

	private final Model model;

	public MyStore(final MySettings mySettings, final IProgressMonitor monitor,
			final IResource iResource, final Model model)
			throws DiscoveryException {
		this.mySettings = mySettings;
		this.monitor = monitor;
		this.iResource = iResource;

		this.factory = CommonFactory.eINSTANCE;

		this.model = model;
		// this.model = this.getModel(targetModel);
		// this.xtextutils = new XtextUtils(this);
	}

	// private Model getModel(final Resource targetModel) {
	// final EList<EObject> list = targetModel.getContents();
	// if (this.mySettings.isBatchMode() && (list != null)
	// && (list.size() == 1)) {
	// final EObject root = targetModel.getContents().get(0);
	// if (root instanceof Model) {
	// return (Model) root;
	// }
	// }
	// return this.createNewModel(targetModel);
	// }

	// private Model createNewModel(final Resource targetModel) {
	// final Model result = this.factory.createModel();
	// targetModel.getContents().add(result);
	// return result;
	// }

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
