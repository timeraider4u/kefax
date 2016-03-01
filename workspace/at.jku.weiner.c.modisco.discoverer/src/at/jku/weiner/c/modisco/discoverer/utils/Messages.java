package at.jku.weiner.c.modisco.discoverer.utils;

import org.eclipse.osgi.util.NLS;

public final class Messages extends NLS {
	private static final String BUNDLE_NAME = Messages.class.getCanonicalName(); //$NON-NLS-1$
	public static String discover;
	public static String saving;
	public static String modelFileSuffix;
	public static String extensionList;
	public static String done;
	public static String prefix;
	public static String modelNeoEMFSuffix;
	static {
		// initialize resource bundle
		NLS.initializeMessages(Messages.BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
