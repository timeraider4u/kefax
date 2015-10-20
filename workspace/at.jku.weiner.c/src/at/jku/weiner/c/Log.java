package at.jku.weiner.c;

public class Log {

	public static boolean LOGGING = false;
	public static boolean LOGGING_ERROR = false;

	public static void log(final String msg) {
		if (Log.LOGGING) {
			System.out.println(msg);
		}
	}

	public static void error(final String msg) {
		if (Log.LOGGING_ERROR) {
			System.err.println(msg);
		}
	}
}
