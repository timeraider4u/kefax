package org.eclipse.gmt.modisco.infra.browser.util;

import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class Neo4EMFEditorInput implements IEditorInput {
	
	private IFolder dbFolder;

	public Neo4EMFEditorInput(IFolder dbFolder) {
		this.dbFolder = dbFolder;
	}

	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolTipText() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the dbFolder
	 */
	public IFolder getDbFolder() {
		return dbFolder;
	}

	/**
	 * @param dbFolder the dbFolder to set
	 */
	public void setDbFolder(IFolder dbFolder) {
		this.dbFolder = dbFolder;
	}

}