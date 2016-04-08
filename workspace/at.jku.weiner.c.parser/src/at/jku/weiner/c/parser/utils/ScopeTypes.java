package at.jku.weiner.c.parser.utils;

import java.util.HashSet;
import java.util.Iterator;

import at.jku.weiner.c.common.log.MyLog;

public final class ScopeTypes implements Cloneable {
	private final HashSet<String> types = new HashSet<String>();
	private final boolean forceEnableDebug;

	public ScopeTypes() {
		this(false);
	}

	public ScopeTypes(final boolean forceEnableDebug) {
		this.forceEnableDebug = forceEnableDebug;
	}
	
	public void addType(final String type) {
		this.types.add(type);
	}
	
	public void clear() {
		this.types.clear();
	}
	
	public void removeType(final String type) {
		this.types.remove(type);
	}
	
	public boolean containsType(final String type) {
		final boolean result = this.types.contains(type);
		return result;
	}

	public String debug() {
		if (!MyLog.shouldLog(MyLog.LOG_DEBUG) && (!this.forceEnableDebug)) {
			return "";
		}
		final StringBuffer buffer = new StringBuffer("");
		final Iterator<String> it = this.types.iterator();
		int i = 0;
		boolean first = true;
		while (it.hasNext()) {
			final String elem = it.next();
			if (!first) {
				buffer.append(" ");
			}
			buffer.append("elem('");
			buffer.append(i);
			buffer.append("')='");
			buffer.append(elem);
			buffer.append("'");
			i++;
			first = false;
		}
		return buffer.toString();
	}

	@Override
	protected Object clone() {
		final ScopeTypes result = new ScopeTypes(this.forceEnableDebug);
		final Iterator<String> it = this.types.iterator();
		while (it.hasNext()) {
			final String next = it.next();
			result.types.add(next);
		}
		return result;
	}
	
}
