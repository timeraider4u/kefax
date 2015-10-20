package at.jku.weiner.c;

public class Log {

	public static boolean LOGGING = true;

	public static void log(final String msg) {
		if (Log.LOGGING) {
			System.out.println(msg);
		}
	}

	public static void error(final String msg) {
		if (Log.LOGGING) {
			System.err.println(msg);
		}
	}
}
