package org.eclipse.modisco.cdt.discoverer.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.modisco.cdt.CdtFactory;
import org.eclipse.modisco.cdt.Scope;
import org.eclipse.modisco.cdt.TranslationUnit;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

import at.jku.weiner.c.parser.parser.Model;
import at.jku.weiner.c.parser.parser.ParserFactory;

public final class MyStore {

	private final IProgressMonitor monitor;
	private final ParserFactory factory;
	private final Model model;
	private final Map<String, TranslationUnit> alreadyParsed;
	private Scope scope;

	public MyStore(final IProgressMonitor monitor, final Resource targetModel)
			throws DiscoveryException {
		this.monitor = monitor;
		this.factory = ParserFactory.eINSTANCE;
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
