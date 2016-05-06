package org.eclipse.gmt.modisco.infra.browser.filters;
/*******************************************************************************
 * Copyright (c) 2013 Atlanmod INRIA LINA Mines Nantes
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Atlanmod INRIA LINA Mines Nantes - initial API and implementation
 *******************************************************************************/


import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.Path;

/**
 * 
 * @author abelgomez
 *
 */
public class Neo4JDatabase extends PropertyTester {
	
	private static final String IS_NEO4J_DB= "isNeo4JDB";  
	
	public Neo4JDatabase() {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (IS_NEO4J_DB.equals(property) && receiver instanceof IFolder) {
			boolean expected = (Boolean) expectedValue;
			IFolder folder = (IFolder) receiver;
			if (folder.exists(new Path("neostore")) == expected) {
				return true;
			}
		}
		return false;
	}
}
