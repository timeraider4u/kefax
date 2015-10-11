package at.jku.weiner.c;

public class Log {

	public static boolean LOGGING = false;

	public static void log(final String msg) {
		if (Log.LOGGING) {
			System.out.println(msg);
		}
	}
}
