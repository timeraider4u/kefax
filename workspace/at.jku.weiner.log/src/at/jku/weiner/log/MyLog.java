package at.jku.weiner.log;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class MyLog {
	
	public static final int LOG_NONE = 0;
	public static final int LOG_ERROR = 2;
	public static final int LOG_INFO = 3;
	public static final int LOG_DEBUG = 4;
	public static final int LOG_TRACE = 5;
	
	// private static int log_level = MyLog.LOG_NONE ;
	
	// private static int log_level = MyLog.LOG_ERR

	private static int log_level = MyLog.LOG_INFO;
	
	// private static int log_level = MyLog.LOG_DEB

	// private static int log_level = MyLog.LOG_TRACE ;

	public static boolean shouldLog(final int requestedLogLevel) {
		final boolean result = (MyLog.getLog_level() >= requestedLogLevel);
		return result;
	}
	
	public static void errorNoThrows(final Class<?> clazz, final Exception ex) {
		MyLog.error(clazz, ex.getMessage());
		MyLog.error(clazz, MyLog.getMessage(ex));
	}
	
	public static void error(final Class<?> clazz, final Exception ex)
			throws Exception {
		final String string = MyLog.getMessage(ex);
		MyLog.error(clazz, string);
		throw ex;
	}
	
	public static void error(final Class<?> clazz, final RuntimeException ex)
			throws RuntimeException {
		final String string = MyLog.getMessage(ex);
		MyLog.error(clazz, string);
		throw ex;
	}
	
	private static String getMessage(final Exception ex) {
		final String stackTrace = MyLog.getStackTrace(ex);
		final String string = ex.getMessage() + ", stackTrace='" + stackTrace
				+ "'";
		return string;
	}

	private static String getStackTrace(final Exception ex) {
		final ByteArrayOutputStream stream = new ByteArrayOutputStream();
		final PrintStream printStream = new PrintStream(stream);
		ex.printStackTrace(printStream);
		printStream.close();
		final String stackTrace = stream.toString();
		return stackTrace;
	}
	
	public static void error(final Class<?> clazz, final String msg) {
		if (MyLog.getLog_level() >= MyLog.LOG_ERROR) {
			MyLog.providersError(msg);
		}
	}
	
	public static void log(final Class<?> clazz, final String msg) {
		if (MyLog.getLog_level() >= MyLog.LOG_INFO) {
			MyLog.providersLog(msg);
		}
	}
	
	public static void debug(final Class<?> clazz, final String msg) {
		if (MyLog.getLog_level() >= MyLog.LOG_DEBUG) {
			MyLog.providersLog(msg);
		}
	}
	
	public static void trace(final Class<?> clazz, final String msg) {
		if (MyLog.getLog_level() >= MyLog.LOG_TRACE) {
			MyLog.providersLog(msg);
		}
	}
	
	private static int getLog_level() {
		return MyLog.log_level;
	}
	
	public static void setLog_level(final int log_level) {
		MyLog.log_level = log_level;
	}
	
	private static void providersLog(final String message) {
		final List<MyLogService> providers = MyLogServiceProvider
				.getServiceProviders();
		for (int i = 0; i < providers.size(); i++) {
			final MyLogService service = providers.get(i);
			service.log(message);
		}
	}
	
	private static void providersError(final String message) {
		final List<MyLogService> providers = MyLogServiceProvider
				.getServiceProviders();
		for (int i = 0; i < providers.size(); i++) {
			final MyLogService service = providers.get(i);
			service.error(message);
		}
	}

}
