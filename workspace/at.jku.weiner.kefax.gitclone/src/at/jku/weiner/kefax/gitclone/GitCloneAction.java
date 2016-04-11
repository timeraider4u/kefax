package at.jku.weiner.kefax.gitclone;

import java.io.File;
import java.net.URI;
import java.text.MessageFormat;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class GitCloneAction extends AbstractHandler {

	private final IProgressMonitor monitor = new NullProgressMonitor();

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {

		final Job job = new Job("at.jku.weiner.kefax.gitclone.job") {
			@Override
			protected IStatus run(final IProgressMonitor monitor) {
				final IStatus result = GitCloneAction.this.run();
				return result;
			}
		};
		job.schedule();
		return null;
	}

	private IStatus run() {
		try {
			this.myRun();
		} catch (Exception ex) {
			// MyLog.errorNoThrows(CleanUpCommand.class, ex);
			ex.printStackTrace();
			return Status.CANCEL_STATUS;
		}
		return Status.OK_STATUS;
	}

	private void myRun() throws Exception {
		final IProject project = this.setUpProject();

		IFolder src = project.getFolder("src");
		if (src.exists()) {
			src.delete(true, this.monitor);
		}
		src.create(true, true, this.monitor);
		project.refreshLocal(IResource.DEPTH_INFINITE, this.monitor);
		this.runClone(src);
		project.refreshLocal(IResource.DEPTH_INFINITE, this.monitor);
	}

	private IProject setUpProject() throws CoreException {
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IWorkspaceRoot root = workspace.getRoot();
		final IProject project = root.getProject("kefax-linux-source");
		if (!project.exists()) {
			project.create(this.monitor);
		} else {
			// project.delete(this.monitor);
		}
		project.open(this.monitor);
		project.refreshLocal(IResource.DEPTH_INFINITE, this.monitor);
		return project;
	}

	private void runClone(final IFolder src) throws Exception {
		final IPath path = src.getLocation();
		final String target = path.toOSString();
		System.out.println("target='" + target + "'");
		final File targetDir = new File(target);

		GitCloneNotification.run();

		// GitCloneAction
		// .showStatusMessage(
		// "git clone https://github.com/torvalds/linux.git can take a few minutes!",
		// false);

		CloneCommand clone = Git.cloneRepository();
		clone.setURI("https://github.com/torvalds/linux.git");
		clone.setDirectory(targetDir);
		clone.setBare(false);
		clone.setCloneAllBranches(false);
		clone.setCloneSubmodules(false);

		clone.setBranch("master");
		clone.call();
		// FileRepositoryBuilder builder = new FileRepositoryBuilder();
		//
		// Repository repository = builder.setGitDir(new File(target))
		// .readEnvironment().findGitDir() // scan up the file system tree
		// .build();
	}

	/**
	 * taken from
	 * http://www.mindfiresolutions.com/Showing-the-status-message-in-
	 * the-Eclipse-RCP-application-261.php
	 *
	 * Shows status message in RCP
	 *
	 * @param message
	 *            message to be displayed
	 * @param isError
	 *            if its an error message or normal message
	 */
	// private static void showStatusMessage(final String message,
	// final boolean isError) {
	// Display.getDefault().syncExec(new Runnable() {
	//
	// @Override
	// @SuppressWarnings("restriction")
	// public void run() {
	// IWorkbenchWindow window = PlatformUI.getWorkbench()
	// .getActiveWorkbenchWindow();
	// if (window instanceof WorkbenchWindow) {
	// WorkbenchWindow w = (WorkbenchWindow) window;
	// if (isError) {
	// w.getStatusLineManager().setErrorMessage(message);
	// } else {
	// w.getStatusLineManager().setMessage(message);
	// }
	// }
	// }
	// });
	// }

}
