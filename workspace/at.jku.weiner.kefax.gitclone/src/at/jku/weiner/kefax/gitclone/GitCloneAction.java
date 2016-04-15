package at.jku.weiner.kefax.gitclone;

import java.io.File;

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
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;

import at.jku.weiner.kefax.shared.MyNotification;
import at.jku.weiner.kefax.shared.Settings;

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
		} catch (final Exception ex) {
			// MyLog.errorNoThrows(CleanUpCommand.class, ex);
			ex.printStackTrace();
			return Status.CANCEL_STATUS;
		}
		return Status.OK_STATUS;
	}

	private void myRun() throws Exception {
		final IProject project = this.setUpProject();

		final IFolder src = project.getFolder(Settings.LINUX_CHECKOUT_DIR);
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
		final IProject project = root.getProject(Settings.LINUX_CHECKOUT_PRJ);
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

		MyNotification.run("at.jku.weiner.kefax.gitclone actions started",
				"git clone " + Settings.LINUX_CHECKOUT_URL
				+ " can take several minutes!");

		final CloneCommand clone = Git.cloneRepository();
		clone.setURI(Settings.LINUX_CHECKOUT_URL);
		clone.setDirectory(targetDir);
		clone.setBare(false);
		clone.setCloneAllBranches(false);
		clone.setCloneSubmodules(false);

		clone.setBranch(Settings.LINUX_CHECKOUT_BRANCH);
		clone.call();
	}

}
