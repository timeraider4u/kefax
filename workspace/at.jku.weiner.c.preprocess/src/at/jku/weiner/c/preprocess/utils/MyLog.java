package at.jku.weiner.c.preprocess.utils;

public class MyLog {

	public static final int LOG_NONE = 0;
	public static final int LOG_ERROR = 2;
	public static final int LOG_INFO = 3;
	public static final int LOG_DEBUG = 4;

	private static final int log_level = MyLog.LOG_INFO;

	public static void log(final String msg) {
		if (MyLog.log_level >= MyLog.LOG_INFO) {
			System.out.println(msg);
		}
	}
	
	@SuppressWarnings("unused")
	public static void debug(final String msg) {
		if (MyLog.log_level >= MyLog.LOG_DEBUG) {
			System.out.println(msg);
		}
	}

}
