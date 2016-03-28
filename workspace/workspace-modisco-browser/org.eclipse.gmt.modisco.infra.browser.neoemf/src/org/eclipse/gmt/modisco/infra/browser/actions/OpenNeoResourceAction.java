package org.eclipse.gmt.modisco.infra.browser.actions;

import org.eclipse.core.resources.IFolder;
import org.eclipse.gmt.modisco.infra.browser.util.Neo4EMFEditorInput;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;


public class OpenNeoResourceAction implements IObjectActionDelegate {
	
	private Shell shell;
	private IFolder dbFolder;

	@Override
	public void run(IAction action) {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		try {
			page.openEditor(new Neo4EMFEditorInput(dbFolder), "org.eclipse.gmt.modisco.infra.browser.NeoEditor");
			
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		if (!structuredSelection.isEmpty()) { 
			if (structuredSelection.getFirstElement() instanceof IFolder) {
				dbFolder = (IFolder) structuredSelection.getFirstElement();
			}
		}
		
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		setShell(targetPart.getSite().getShell());		
	}

	/**
	 * @return the shell
	 */
	public Shell getShell() {
		return shell;
	}

	/**
	 * @param shell the shell to set
	 */
	public void setShell(Shell shell) {
		this.shell = shell;
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
