package at.jku.weiner.c.parser.utils;

import java.util.ArrayList;
import java.util.List;

import at.jku.weiner.c.common.log.MyLog;

public final class ScopeSymbols implements Cloneable {
	private final String scopeName;
	private final List<ScopeTypes> types = new ArrayList<ScopeTypes>();
	private boolean isTypeDefValue = false;
	private String temp = null;

	private final boolean forceEnableDebug;

	public ScopeSymbols(final String scopeName) {
		this(scopeName, false);
	}
	
	public ScopeSymbols(final String scopeName, final boolean forceEnableDebug) {
		this.forceEnableDebug = forceEnableDebug;
		this.scopeName = scopeName;
		// level 0
		this.types.add(new ScopeTypes(forceEnableDebug));
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
			this.types.add(new ScopeTypes(this.forceEnableDebug));
		}
	}
	
	public void addType(final int level) {
		this.cleanUp(level);
		if (this.isTypeDefValue && (this.temp != null)) {
			this.types.get(level).addType(this.temp);
			MyLog.debug(ScopeSymbols.class, "add type, temp='" + this.temp
					+ "', level='" + level + "'");
			MyLog.debug(ScopeSymbols.class, this.debug());
			this.setTemp(null);
			this.setTypeDefValue(false);
		}
	}
	
	public boolean containsType(final int level, final String type) {
		this.cleanUp(level);
		MyLog.trace(ScopeSymbols.class, this.debug());
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
		if (!MyLog.shouldLog(MyLog.LOG_DEBUG) && (!this.forceEnableDebug)) {
			return "";
		}
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
		MyLog.trace(ScopeSymbols.class, "setTypedefValue='" + isTypeDefValue
				+ "'");
		this.isTypeDefValue = isTypeDefValue;
	}
	
	public void setTemp(final String temp) {
		this.temp = temp;
	}
	
	public String getScopeName() {
		return this.scopeName;
	}
	
	@Override
	public Object clone() {
		final ScopeSymbols result = new ScopeSymbols(this.scopeName,
				this.forceEnableDebug);
		// result.isTypeDefValue = this.isTypeDefValue;
		// result.temp = this.temp;
		result.isTypeDefValue = false;
		result.temp = null;
		result.types.clear();
		for (int i = 0; i < this.types.size(); i++) {
			final ScopeTypes type = (ScopeTypes) this.types.get(i).clone();
			result.types.add(type);
		}
		return result;
	}
	
}
