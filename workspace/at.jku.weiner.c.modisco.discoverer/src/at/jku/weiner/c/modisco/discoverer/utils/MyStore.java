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

	private final IProgressMonitor monitor;
	private final CommonFactory factory;
	private final Model model;
	private final XtextUtils parser;
	private final boolean stdInclude;
	private final String includeDirs;
	private final IResource resource;
	private final String additionalPreprocessingDirectives;
	private final boolean trimPreprocessModel;
	private final boolean batchMode;

	public MyStore(final IProgressMonitor monitor, final Resource targetModel,
			final IResource resource, final boolean stdInclude,
			final String includeDirs,
			final String additionalPreprocessingDirectives,
			final boolean trimPreprocessModel, final boolean batchMode)
					throws DiscoveryException {
		this.monitor = monitor;
		this.resource = resource;
		this.stdInclude = stdInclude;
		this.includeDirs = includeDirs;
		this.additionalPreprocessingDirectives = additionalPreprocessingDirectives;
		this.trimPreprocessModel = trimPreprocessModel;
		this.factory = CommonFactory.eINSTANCE;
		if (this.factory == null) {
			throw new DiscoveryException("factory is null!");
		}
		this.batchMode = batchMode;

		this.model = this.getModel(targetModel);
		this.parser = new XtextUtils(this);
	}

	private Model getModel(final Resource targetModel) {
		final EList<EObject> list = targetModel.getContents();
		if (this.isBatchMode() && (list != null) && (list.size() == 1)) {
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

	public boolean isStdInclude() {
		return this.stdInclude;
	}

	public String getIncludeDirs() {
		return this.includeDirs;
	}

	public IResource getResource() {
		return this.resource;
	}

	public String getAdditionalPreprocessingDirectives() {
		return this.additionalPreprocessingDirectives;
	}

	public boolean isTrimPreprocessModel() {
		return this.trimPreprocessModel;
	}

	public boolean isBatchMode() {
		return batchMode;
	}

}
