package org.eclipse.gmt.modisco.infra.browser.filters;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.IActionFilter;

public class NeoAdapterFactory implements IAdapterFactory{

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(adapterType == IActionFilter.class)
			return NeoResourceFilter.getInstance();
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return new Class[] {IActionFilter.class};
	}

}
