package at.jku.weiner.c.parser.utils;

import java.util.ArrayList;
import java.util.List;

public final class ScopeSymbols {
	private final String scopeName;
	private final List<ScopeTypes> types = new ArrayList<ScopeTypes>();
	// public final Map<Integer, Types> types = new HashMap<Integer,
	// Types>();
	private boolean isTypeDefValue = false;
	private String temp = null;

	public ScopeSymbols(final String scopeName) {
		this.scopeName = scopeName;
		// level 0
		this.types.add(new ScopeTypes());
	}
	
	public void clear(final int level) {
		this.cleanUp(level);
		if (level > 0) {
			this.types.get(level).clear();
		}
	}

	public void cleanUp(final int level) {
		for (int i = this.types.size() - 1; i > level; i--) {
			this.types.remove(i);
		}
		for (int i = this.types.size(); i <= level; i++) {
			this.types.add(new ScopeTypes());
		}
	}

	public void addType(final int level) {
		this.cleanUp(level);
		if (this.isTypeDefValue && (this.temp != null)) {
			this.types.get(level).addType(this.temp);
			Log.log("add type, level='" + level + "'");
			Log.log(this.debug());
		}
	}

	public boolean containsType(final int level, final String type) {
		this.cleanUp(level);
		Log.log(this.debug());
		int start = level;
		if (level >= this.types.size()) {
			start = this.types.size() - 1;
		}
		for (int i = start; i >= 0; i--) {
			final ScopeTypes myType = this.types.get(i);
			if (myType.containsType(type)) {
				return true;
			}
		}
		return false;
	}
	
	public String debug() {
		final StringBuffer result = new StringBuffer("Scope='"
				+ this.getScopeName() + "'");
		result.append(System.lineSeparator());
		for (int i = 0; i < this.types.size(); i++) {
			final ScopeTypes type = this.types.get(i);
			result.append("Scope='");
			result.append(this.getScopeName());
			result.append("', i='");
			result.append(i);
			result.append("', '");
			result.append(type.debug());
			result.append("'");
			result.append(System.lineSeparator());
		}
		return result.toString();
	}
	
	public void setTypeDefValue(final boolean isTypeDefValue) {
		this.isTypeDefValue = isTypeDefValue;
	}

	public void setTemp(final String temp) {
		this.temp = temp;
	}

	public String getScopeName() {
		return this.scopeName;
	}
}