package at.jku.weiner.c.common.ui.log;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import at.jku.weiner.c.common.ui.log.service.MyConsoleViewLogger;

public final class MyConsoleViewLoggerImpl implements MyConsoleViewLogger {
	
	private static final String CONSOLE_NAME = "at.jku.weiner.common.ui.log";
	private static final int CONSOLE_SIZE_MIN = 10000;
	private static final int CONSOLE_SIZE_MAX = 80000;
	
	private MessageConsole messageConsole = null;
	
	@Override
	public void log(final String message) {
		if (this.messageConsole == null) {
			this.messageConsole = this
					.findConsole(MyConsoleViewLoggerImpl.CONSOLE_NAME);
		}
		this.messageConsole.setWaterMarks(MyConsoleViewLoggerImpl.CONSOLE_SIZE_MIN, MyConsoleViewLoggerImpl.CONSOLE_SIZE_MAX);
		final MessageConsoleStream out = this.messageConsole.newMessageStream();
		out.println(message);
		this.messageConsole.activate();
	}
	
	@Override
	public void error(final String message) {
		if (this.messageConsole == null) {
			this.messageConsole = this
					.findConsole(MyConsoleViewLoggerImpl.CONSOLE_NAME);
		}
		final MessageConsoleStream out = this.messageConsole.newMessageStream();
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				final Color red = Display.getDefault().getSystemColor(
						SWT.COLOR_RED);
				out.setColor(red);
				// out.setFontStyle(SWT.BOLD);
				out.println(message);
				MyConsoleViewLoggerImpl.this.messageConsole.activate();
				try {
					out.close();
				} catch (final IOException ex) {
					ex.printStackTrace();
				}
			}
		});
	}
	
	private MessageConsole findConsole(final String name) {
		final ConsolePlugin plugin = ConsolePlugin.getDefault();
		if (plugin == null) {
			throw new RuntimeException("ConsolePlugin is null!");
		}
		final IConsoleManager conMan = plugin.getConsoleManager();
		final IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++) {
			if (name.equals(existing[i].getName())) {
				return (MessageConsole) existing[i];
			}
		}
		// no console found, so create a new one
		final MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}
	
}
