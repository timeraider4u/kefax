package at.jku.weiner.kefax.gitclone;

import java.util.Collections;
import java.util.Date;

import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.mylyn.commons.ui.dialogs.AbstractNotificationPopup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.UIJob;

//import org.eclipse.mylyn.commons.notifications.core.AbstractNotification;
//import org.eclipse.mylyn.internal.commons.notifications.ui.NotificationService;

@SuppressWarnings("restriction")
public class GitCloneNotification extends AbstractNotificationPopup {
	private final String title;
	private final String message;
	private final Image icon;

	public GitCloneNotification(final Display display, final String title,
			final String message, final Image icon) {
		super(display);
		this.title = title;
		this.message = message;
		this.icon = icon;
	}

	@Override
	protected void createContentArea(final Composite composite) {
		composite.setLayout(new GridLayout(1, true));
		Label messageLabel = new Label(composite, SWT.WRAP);
		messageLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		messageLabel.setText(this.message);
		messageLabel.setBackground(composite.getBackground());
	}

	@Override
	protected String getPopupShellTitle() {
		// Return a custom title
		return this.title;
	}

	@Override
	protected Image getPopupShellImage(final int maximumHeight) {
		// Use createResource to use a shared Image instance of the
		// ImageDescriptor
		// return (Image) Activator.getImageDescriptor("/icons/alt_about.gif")
		// .createResource(Display.getDefault());
		return this.icon;
	}

	public static void run() {
		final UIJob job = new UIJob("show notification") {
			@Override
			public org.eclipse.core.runtime.IStatus runInUIThread(
					final org.eclipse.core.runtime.IProgressMonitor monitor) {
				Display display = PlatformUI.getWorkbench().getDisplay();
				GitCloneNotification popup = new GitCloneNotification(display,
						"at.jku.weiner.kefax.gitclone actions started",
						"git clone" + " https://github.com/torvalds/linux.git"
								+ " can take several minutes!", null);
				popup.create();
				popup.open();
				return Status.OK_STATUS;
			};
		};
		job.schedule();
	}
}
