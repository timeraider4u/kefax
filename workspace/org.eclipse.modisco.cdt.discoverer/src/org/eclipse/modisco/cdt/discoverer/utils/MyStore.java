package org.eclipse.modisco.cdt.discoverer.utils;

import org.eclipse.core.resources.IResource;
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
	private final boolean stdInclude;
	private final String includeDirs;
	private final IResource resource;
	private final String defines;

	public MyStore(final IProgressMonitor monitor, final Resource targetModel,
			final IResource resource, final boolean stdInclude,
			final String includeDirs, final String defines)
			throws DiscoveryException {
		this.monitor = monitor;
		this.resource = resource;
		this.stdInclude = stdInclude;
		this.includeDirs = includeDirs;
		this.defines = defines;
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
	
	public String getDefines() {
		return this.defines;
	}

}
