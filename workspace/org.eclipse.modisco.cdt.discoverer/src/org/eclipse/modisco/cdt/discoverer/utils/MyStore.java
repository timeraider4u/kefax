package org.eclipse.modisco.cdt.discoverer.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.modisco.cdt.CdtFactory;
import org.eclipse.modisco.cdt.Scope;
import org.eclipse.modisco.cdt.TranslationUnit;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.common.common.CommonFactory;
import at.jku.weiner.c.common.common.Model;

public final class MyStore {
	
	private final IProgressMonitor monitor;
	private final CommonFactory factory;
	private final Model model;
	private final Map<String, TranslationUnit> alreadyParsed;
	private Scope scope;
	
	public MyStore(final IProgressMonitor monitor, final Resource targetModel)
			throws DiscoveryException {
		this.monitor = monitor;
		this.factory = CommonFactory.eINSTANCE;
		if (this.factory == null) {
			throw new DiscoveryException("factory is null!");
		}
		this.model = this.factory.createModel();
		targetModel.getContents().add(this.model);
		this.alreadyParsed = new HashMap<String, TranslationUnit>();
		// this.setScope(this.model);
	}
	
	public IProgressMonitor getMonitor() {
		return this.monitor;
	}
	
	public CdtFactory getFactory() {
		return null;
		// returnthis.factory;
	}
	
	public Model getModel() {
		return this.model;
	}
	
	public Map<String, TranslationUnit> getAlreadyParsed() {
		return this.alreadyParsed;
	}
	
	public Scope getScope() {
		return this.scope;
	}
	
	public void setScope(final Scope scope) {
		this.scope = scope;
	}
	
}
