package org.eclipse.modisco.cdt.discoverer.utils;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.modisco.cdt.discoverer.actions.XtextUtils;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.common.common.CommonFactory;
import at.jku.weiner.c.common.common.Model;

public final class MyStore {
	
	private final IProgressMonitor monitor;
	private final CommonFactory factory;
	private final Model model;
	private final XtextUtils parser;
	
	public MyStore(final IProgressMonitor monitor, final Resource targetModel)
			throws DiscoveryException {
		this.monitor = monitor;
		this.factory = CommonFactory.eINSTANCE;
		if (this.factory == null) {
			throw new DiscoveryException("factory is null!");
		}
		this.model = this.factory.createModel();
		targetModel.getContents().add(this.model);
		this.parser = new XtextUtils(this);
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
		return parser;
	}
	
}
