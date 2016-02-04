package at.jku.weiner.c.common.log;

import at.jku.weiner.c.common.ui.log.MyConsoleViewLoggerImpl;
import at.jku.weiner.c.common.ui.log.service.MyConsoleViewLogger;

@SuppressWarnings("unused")
public class MyLog {

	public static final int LOG_NONE = 0;
	public static final int LOG_ERROR = 2;
	public static final int LOG_INFO = 3;
	public static final int LOG_DEBUG = 4;
	public static final int LOG_TRACE = 5;

	// private static final int log_level = MyLog.LOG_NONE;

	// private static final int log_level = MyLog.LOG_ERROR;

	// private static final int log_level = MyLog.LOG_INFO;

	// private static final int log_level = MyLog.LOG_DEBUG;

	private static final int log_level = MyLog.LOG_TRACE;

	private static MyConsoleViewLogger consoleLogger = null;
	private static boolean tryWritingToConsoleView = true;
	
	public static void error(final Class<?> clazz, final Exception ex)
			throws Exception {
		MyLog.error(clazz, ex.getMessage());
		throw ex;
	}

	public static void error(final Class<?> clazz, final RuntimeException ex)
			throws RuntimeException {
		MyLog.error(clazz, ex.getMessage());
		throw ex;
	}

	public static void error(final Class<?> clazz, final String msg) {
		if (MyLog.log_level >= MyLog.LOG_ERROR) {
			System.err.println(msg);
			MyLog.writeToConsole(msg);
		}
	}

	public static void log(final Class<?> clazz, final String msg) {
		if (MyLog.log_level >= MyLog.LOG_INFO) {
			System.out.println(msg);
			MyLog.writeToConsole(msg);
		}
	}

	public static void debug(final Class<?> clazz, final String msg) {
		if (MyLog.log_level >= MyLog.LOG_DEBUG) {
			System.out.println(msg);
			MyLog.writeToConsole(msg);
		}
	}

	public static void trace(final Class<?> clazz, final String msg) {
		if (MyLog.log_level >= MyLog.LOG_TRACE) {
			System.out.println(msg);
			MyLog.writeToConsole(msg);
		}
	}
	
	private static void writeToConsole(final String msg) {
		if (!MyLog.tryWritingToConsoleView) {
			return;
		}
		if (MyLog.consoleLogger == null) {
			try {
				MyLog.consoleLogger = new MyConsoleViewLoggerImpl();
			} catch (final NoClassDefFoundError e) {
				// do nothing
				System.out.println("writeToConsole=NoClassDefFoundError");
				MyLog.tryWritingToConsoleView = false;
				return;
			}
		}
		try {
			MyLog.consoleLogger.log(msg);
		} catch (final Exception ex) {
			MyLog.tryWritingToConsoleView = false;
		}
	}

}
