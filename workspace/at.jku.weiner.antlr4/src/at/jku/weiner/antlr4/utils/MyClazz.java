package at.jku.weiner.antlr4.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

class MyClazz {

	private final String		name;
	private final EClass		clazz;
	private final List<String>	referencedBy;
	
	public MyClazz(final String name, final EClass clazz) {
		this.name = name;
		this.clazz = clazz;
		this.referencedBy = new ArrayList<String>();
	}
	
	public void referencedBy(final String otherClazz) {
		if (!this.name.equals(otherClazz)) {
			if (!this.referencedBy.contains(otherClazz)) {
				this.referencedBy.add(otherClazz);
			}
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public EClass getClazz() {
		return this.clazz;
	}

	public boolean isTopNode() {
		return this.referencedBy.isEmpty();
	}

}
