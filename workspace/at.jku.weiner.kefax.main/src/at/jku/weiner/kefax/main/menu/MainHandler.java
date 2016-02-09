package at.jku.weiner.kefax.main.menu;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import at.jku.weiner.kefax.main.work.Main;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 *
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class MainHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public MainHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		// IWorkbenchWindow window = HandlerUtil
		// .getActiveWorkbenchWindowChecked(event);
		// MessageDialog.openInformation(window.getShell(), "MyTestPlugin",
		// "Start discoverer");
		Main main = new Main();
		main.start();
		return null;
	}

}
