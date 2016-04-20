package at.jku.weiner.kefax.infra;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.UnsupportedDataTypeException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Injector;

import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Model;
import at.jku.weiner.c.cmdarguments.ui.internal.CmdArgsActivator;
import at.jku.weiner.kefax.shared.KefaxUtils;
import at.jku.weiner.kefax.shared.MyActionHandler;
import at.jku.weiner.kefax.shared.MySettings;
import at.jku.weiner.log.MyLog;
import at.jku.weiner.xtext.XtextUtils;

public class InfraCmdHandler extends MyActionHandler implements
IResourceVisitor {

	private final List<IFile> files;
	
	public InfraCmdHandler() {
		super("at.jku.weiner.kefax.infra.infra.command");
		this.files = new ArrayList<IFile>();
	}
	
	@Override
	protected void myRun() throws Exception {
		MyLog.trace(InfraCmdHandler.class, "starting infra handler!");
		// final IFolder srcFolder = KefaxUtils.getLinuxSrcFolder();
		final IFolder srcFolder = KefaxUtils.getLinuxExt4SrcFolder();
		this.files.clear();
		srcFolder.accept(this);
		final IProject project = this.setUpProject();
		final IFolder src = project.getFolder(MySettings.LINUX_DISCOVER_DIR);
		if (src.exists()) {
			src.delete(true, this.getMonitor());
		}
		src.create(true, true, this.getMonitor());
		project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
		this.getMonitor().beginTask("working on .cmd files", this.files.size());
		for (int i = 0; i < this.files.size(); i++) {
			final IFile file = this.files.get(i);
			this.parse(project, file);
			this.getMonitor().worked(1);
			if (this.getMonitor().isCanceled()) {
				throw new OperationCanceledException();
			}
		}
	}

	@Override
	public boolean visit(final IResource resource) throws CoreException {
		if (resource == null) {
			return false;
		} else if (resource instanceof IContainer) {
			return true;
		} else if (resource instanceof IFile) {
			final IFile file = (IFile) resource;
			final String name = resource.getName();
			if (name == null) {
				return false;
			} else if (name.startsWith(".") && name.endsWith(".cmd")) {
				MyLog.trace(InfraCmdHandler.class, "resource='" + resource
						+ "'");
				this.files.add(file);
				return false;
			}
		}
		return false;
	}
	
	private IProject setUpProject() throws CoreException {
		final IProject project = KefaxUtils.getLinuxDiscoverProject();
		if (project.exists()) {
			// TODO maybe ask for confirmation before re-creating
			project.delete(true, this.getMonitor());
			project.create(this.getMonitor());
		} else {
			project.create(this.getMonitor());
		}
		project.open(this.getMonitor());
		project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
		return project;
	}
	
	private void parse(final IProject project, final IFile file)
			throws Exception {
		if ((file == null) || (!file.isAccessible())) {
			final Exception ex = new UnsupportedDataTypeException(
					"Could not access cmd file='" + file + "'");
			MyLog.error(InfraCmdHandler.class, ex);
		}
		final String languageName = CmdArgsActivator.AT_JKU_WEINER_C_CMDARGUMENTS_CMDARGS;
		final CmdArgsActivator activator = CmdArgsActivator.getInstance();
		if (activator == null) {
			final Exception ex = new NullPointerException("activator is null!");
			MyLog.error(InfraCmdHandler.class, ex);
		}
		final Injector injector = activator.getInjector(languageName);
		if (injector == null) {
			final Exception ex = new NullPointerException("injector is null!");
			MyLog.error(InfraCmdHandler.class, ex);
		}
		final Resource resource = XtextUtils.loadResource(file, injector,
				".cmd");
		if (resource == null) {
			final Exception ex = new NullPointerException("resource is null!");
			MyLog.error(InfraCmdHandler.class, ex);
		}
		final Model model = (Model) resource.getContents().get(0);
		if (model == null) {
			final Exception ex = new NullPointerException("model is null!");
			MyLog.error(InfraCmdHandler.class, ex);
		}
		final EList<CmdLine> cmdLines = model.getLines();
		if ((cmdLines == null) || cmdLines.isEmpty()) {
			final Exception ex = new ParseException("no command lines"
					+ " found in command file='" + file + "'", 0);
			MyLog.error(InfraCmdHandler.class, ex);
		}
		// Only read first line
		final CmdLine cmdLine = cmdLines.get(0);
		final CmdArgs args = new CmdArgs(file, cmdLine);
		final String inFile = args.getInFile();
		final List<String> includes = args.getIncludeDirectoriesAsList();
		MyLog.log(InfraCmdHandler.class, "inFile='" + inFile + "'");
		MyLog.log(InfraCmdHandler.class, "includes='" + includes + "'");
		project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
	}

}
