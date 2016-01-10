package at.jku.weiner.c.parser.utils;

public class Log {
	private static final int ERROR = 2;
	private static final int INFO = 3;
	private static final int DEBUG = 4;
	
	// private static int logLevel = Log.INFO;
	private static int logLevel = Log.DEBUG;

	public static void error(final String msg) {
		if (Log.logLevel >= Log.ERROR) {
			System.out.println(msg);
		}
	}
	
	public static void log(final String msg) {
		if (Log.logLevel >= Log.INFO) {
			System.out.println(msg);
		}
	}
	
	public static void debug(final String msg) {
		if (Log.logLevel >= Log.DEBUG) {
			System.out.println(msg);
		}
	}
}
