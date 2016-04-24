package at.jku.weiner.kefax.infra;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Injector;

import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Model;
import at.jku.weiner.c.cmdarguments.ui.internal.CmdArgsActivator;
import at.jku.weiner.kefax.infra.cmdargs.CmdArgs;
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
		final IProject dstProject = this.setUpProject();
		final IFolder dstFolder = dstProject
				.getFolder(MySettings.LINUX_DISCOVER_DIR);
		if (dstFolder.exists()) {
			dstFolder.delete(true, this.getMonitor());
		}
		dstFolder.create(true, true, this.getMonitor());
		dstProject.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
		this.getMonitor().beginTask("working on .cmd files", this.files.size());
		final IFile cmdOutFile = this.createCmdOutFile(dstFolder);
		this.getMonitor().beginTask("working on .cmd files", this.files.size());
		
		for (int i = 0; i < this.files.size(); i++) {
			final IFile file = this.files.get(i);
			this.parse(dstProject, file, cmdOutFile);
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

	private IFile createCmdOutFile(final IFolder dstFolder)
			throws CoreException {
		final IFile cmdOutFile = KefaxUtils.getCommandsFile();
		if (cmdOutFile.exists()) {
			cmdOutFile.delete(true, this.getMonitor());
		}
		final byte[] bytes = "".getBytes();
		final InputStream source = new ByteArrayInputStream(bytes);
		cmdOutFile.create(source, true, this.getMonitor());
		return cmdOutFile;
	}
	
	private void parse(final IProject project, final IFile file,
			final IFile cmdOutFile) throws Exception {
		final CmdArgs args = this.parseCmdLines(file);
		this.writeToCmdOutFile(cmdOutFile, args);
		project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
		final List<String> list = args.getInRealCFilePath();
		for (int i = 0; i < list.size(); i++) {
			final String inFileString = list.get(i);
			final IFile srcFile = this.copySourceFile(inFileString);
			project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
			this.copyHeaderFilesInSourceFileDirectory(srcFile);
			project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
		}
		this.copyIncludeDirectories(args);
		project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
	}
	
	private CmdArgs parseCmdLines(final IFile file) throws Exception {
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
		return args;
	}

	private void writeToCmdOutFile(final IFile cmdOutFile, final CmdArgs args)
			throws CoreException {
		final String argsAsString = args.getCmdLineAsString();
		final InputStream inStream = new ByteArrayInputStream(
				argsAsString.getBytes());
		cmdOutFile.appendContents(inStream, true, true, this.getMonitor());
	}
	
	private IFile copySourceFile(final String inFileString) throws Exception {
		MyLog.trace(InfraCmdHandler.class, "inFile='" + inFileString + "'");
		final IFolder src = KefaxUtils.getLinuxSrcFolder();
		final IFile inFile = src.getFile(inFileString);
		MyLog.trace(InfraCmdHandler.class, "inFile='" + inFile + "'");
		if ((inFile == null) || (!inFile.isAccessible())) {
			final Exception ex = new FileNotFoundException("inFile='" + inFile
					+ "' can not be accessed ('" + inFileString + "')");
			MyLog.error(InfraCmdHandler.class, ex);
		}
		final IFolder dstFolder = KefaxUtils.getLinuxDiscoverSrcFolder();
		final IFile outFile = dstFolder.getFile(inFileString);
		KefaxUtils.mkParentDirsFor(outFile, this.getMonitor());

		MyLog.log(InfraCmdHandler.class, "copy '" + inFileString + "' from '"
				+ inFile + "' to '" + outFile + "'");
		inFile.copy(outFile.getFullPath(), true, this.getMonitor());
		return inFile;
	}
	
	private void copyHeaderFilesInSourceFileDirectory(final IFile srcFile)
			throws Exception {
		final IContainer container = srcFile.getParent();
		final IPath containerPath = container.getProjectRelativePath();
		final IProject dstProject = KefaxUtils.getLinuxDiscoverProject();
		final IFolder dstHeaderDir = dstProject.getFolder(containerPath);

		final IResource members[] = container.members();
		for (int i = 0; i < members.length; i++) {
			final IResource res = members[i];
			if ((res != null) && (res.isAccessible())) {
				final String name = res.getName();
				final IFile dstFile = dstHeaderDir.getFile(name);
				final IPath dstPath = dstFile.getFullPath();
				if (name.endsWith(MySettings.HEADER_FILE_SUFFIX)) {
					if (!dstFile.exists()) {
						System.err.println("copying file='" + res + "' to '"
								+ dstPath + "'");
						res.copy(dstPath, true, this.getMonitor());
					}
				}
			}
		}
	}

	private void copyIncludeDirectories(final CmdArgs args) throws Exception {
		final IFolder srcFolder = KefaxUtils.getLinuxSrcFolder();
		final String srcFolderURIStr = srcFolder.getLocationURI().toString();
		final String srcFolderStr = srcFolderURIStr.replaceFirst("file:", "");
		final IPath srcFolderPath = new Path(srcFolderStr);
		final IFolder dstFolder = KefaxUtils.getLinuxDiscoverSrcFolder();
		final List<String> incDirs = args.getIncludeDirectoriesPathsAsList();
		for (int i = 0; i < incDirs.size(); i++) {
			final String incDir = incDirs.get(i);
			final IPath path = new Path(incDir);
			final int num = srcFolderPath.matchingFirstSegments(path);
			final IPath myPath = path.makeRelativeTo(srcFolderPath);
			final boolean isAbsolute = myPath.isAbsolute();

			if (!isAbsolute && (num >= 1)) {
				this.copyIncludeDirectory(srcFolder, dstFolder, myPath);
			}
		}
	}
	
	private void copyIncludeDirectory(final IFolder srcFolder,
			final IFolder dstFolder, final IPath myPath) throws Exception {
		MyLog.log(InfraCmdHandler.class, "copy '" + myPath + "' from '"
				+ srcFolder + "' to '" + dstFolder + "'");
		final IFolder srcIncFolder = srcFolder.getFolder(myPath);
		final IFolder dstIncFolder = dstFolder.getFolder(myPath);
		final IPath dstIncPath = dstIncFolder.getFullPath();
		KefaxUtils.mkParentDirsFor(dstIncFolder, this.getMonitor());
		if (!dstIncFolder.exists()) {
			dstIncFolder.create(true, true, this.getMonitor());
		}
		final IResource[] members = srcIncFolder.members();
		if (members == null) {
			return;
		}
		for (int i = 0; i < members.length; i++) {

			final IResource member = members[i];
			// System.err.println("	member='" + member + "'");
			// System.err.println("	member.type='" + member.getClass() + "'");

			// System.err.println("	dstIncPath='" + dstIncPath + "'");
			
			if (member instanceof IFile) {
				final String name = member.getName();
				if (name.endsWith(MySettings.HEADER_FILE_SUFFIX)) {
					member.copy(dstIncPath, true, this.getMonitor());
				}
			}
		}
	}

}
