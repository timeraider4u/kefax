package org.eclipse.gmt.modisco.infra.browser.filters;

import org.eclipse.core.resources.IFolder;
import org.eclipse.gmt.modisco.infra.browser.util.Neo4EMFEditorInput;
import org.eclipse.ui.IActionFilter;

public class NeoResourceFilter implements IActionFilter {

	private static NeoResourceFilter INSTANCE = new NeoResourceFilter(); 
	@Override
	public boolean testAttribute(Object target, String name, String value) {
		if (target instanceof Neo4EMFEditorInput){
		Neo4EMFEditorInput object = (Neo4EMFEditorInput) target;
		 return this.containsIndex(object) == true ? true : false;
		}
		return false;
	}

	private boolean containsIndex(Neo4EMFEditorInput object) {
		IFolder folder = object.getDbFolder();
		return folder.getFile("index") != null;
		
	}

	public static NeoResourceFilter getInstance (){
		return INSTANCE;
	}
}
