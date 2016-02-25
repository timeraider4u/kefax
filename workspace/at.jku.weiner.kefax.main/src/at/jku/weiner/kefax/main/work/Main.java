package at.jku.weiner.kefax.main.work;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Model;
import at.jku.weiner.c.cmdarguments.ui.internal.CmdArgsActivator;
import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.modisco.discoverer.actions.DiscoverFromIResource;
import at.jku.weiner.kefax.dotconfig.dotconfig.Config;

import com.google.inject.Injector;

public class Main {

	public void start() {
		final Job job = new Job("at.jku.weiner.kefax.job") {
			@Override
			protected IStatus run(final IProgressMonitor monitor) {
				final IStatus result = Main.this.run1(monitor);
				return result;
			}
		};

		// Start the Job
		job.schedule();
	}

	private IStatus run1(final IProgressMonitor monitor) {
		IStatus result = Status.OK_STATUS;
		final Date start = new Date();
		try {
			MyLog.log(Main.class,
					"at.jku.weiner.kefax.main - Start of program!");
			result = this.run2(monitor);
		} catch (final Exception ex) {
			ex.printStackTrace();
			MyLog.errorNoThrows(Main.class, ex);
			result = Status.CANCEL_STATUS;
		} finally {
			monitor.done();
		}
		final Date end = new Date();
		final long difference = end.getTime() - start.getTime();
		final long sec = difference / 1000;
		final long min = sec / 60;
		final long seconds = sec % 60;
		MyLog.log(Main.class, "took '" + min + "' minutes and '" + seconds
				+ "' seconds for parsing!");
		MyLog.log(Main.class, "at.jku.weiner.kefax.main - End of program!");
		return result;
	}

	private IStatus run2(final IProgressMonitor monitor) throws Exception {
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		final IProject project = root.getProject("HelloC");
		final IResource cmdRes = project.findMember("test.cmd");
		if ((cmdRes == null) || !cmdRes.isAccessible()
				|| !(cmdRes instanceof IFile)) {
			this.error("invalid cmd file='" + cmdRes + "'!");
		}
		final IFile cmdFile = (IFile) cmdRes;
		final String cmdPath = cmdRes.getLocationURI().toString();
		MyLog.log(Main.class, "cmdPath='" + cmdPath + "'");
		// Linux project
		final IProject linux = root.getProject(Settings.LINUX);
		if (linux == null) {
			this.error("could not find linux project in workspace!");
		}
		// get command arguments Xtext units
		final CmdArgsActivator activator = CmdArgsActivator.getInstance();
		if (activator == null) {
			this.error("activator is null!");
		}
		final Injector injector = activator
				.getInjector(CmdArgsActivator.AT_JKU_WEINER_C_CMDARGUMENTS_CMDARGS);
		if (injector == null) {
			this.error("injector is null!");
		}
		// load resource
		final Resource res = this.loadResource(injector, cmdFile);
		if (res == null) {
			this.error("res is null!");
		}
		// validate resource
		this.validateResource(injector, res);
		MyLog.debug(Main.class,
				"validation of command file has been successfull!");
		// get command arguments
		final EObject object = res.getContents().get(0);
		if ((object == null) || (!(object instanceof Model))) {
			this.error("Returned object of file='" + cmdPath
					+ "' from XText is null!");
		}
		final Model model = (Model) object;
		final EList<CmdLine> cmdLines = model.getLines();
		if ((cmdLines == null) || cmdLines.isEmpty()) {
			this.error("no command lines found in command file='" + cmdPath
					+ "'");
		}
		// iterate command lines
		final DiscoverFromIResource discoverer = new DiscoverFromIResource();
		monitor.beginTask("iterating modules", cmdLines.size());
		final int total = cmdLines.size() + 1;
		for (int i = 0; i < cmdLines.size(); i++) {
			if (monitor.isCanceled()) {
				return Status.CANCEL_STATUS;
			}
			monitor.worked(i);
			final int num = i + 1;
			MyLog.log(Main.class, "cmdLine=" + num + "/" + total + "!");
			final CmdLine cmdLine = cmdLines.get(i);
			final CmdArgs args = new CmdArgs(cmdPath, cmdLine, linux);
			final String additionalDirectives = args
					.getAdditionalDirectivesAsString();
			MyLog.debug(Main.class, "additionalDirectives='"
					+ additionalDirectives + "'");
			final String includeDirectories = args
					.getIncludeDirectoriesAsString();
			MyLog.debug(Main.class, "includeDirectories='" + includeDirectories
					+ "'");
			final boolean stdInclude = !args.isNoStandardInclude();
			MyLog.debug(Main.class, "stdInclude='" + stdInclude + "'");
			final String inFile = args.getInFile();
			MyLog.debug(Main.class, "inFile='" + inFile + "'");
			if (!this.isValid(inFile)) {
				MyLog.debug(Main.class, "inFile is invalid, inFile='" + inFile
						+ "'!");
				continue;
			}
			// get discoverer resource input file
			final IResource inFileRes = linux.findMember(inFile);
			if ((inFileRes == null) || !inFileRes.isAccessible()) {
				this.error("could not access in-file='" + inFile
						+ "' in linux project!");
			}
			// start discoverer
			discoverer.setSetStdInclude(stdInclude);
			discoverer.setIncludeDirs(includeDirectories);
			discoverer.setAdditionalDirectives(additionalDirectives);
			// batch mode and trim preprocess are exclusive to each other
			discoverer.setTrimPreprocessModel(false);
			// discoverer.setTrimPreprocessModel(true);
			discoverer.setBatchMode(true);
			// discoverer.setBatchMode(false);
			discoverer.setUseNeoEMF(true);
			// discoverer.setUseNeoEMF(false);

			discoverer.discoverElement(inFileRes, monitor);
		}
		return Status.OK_STATUS;
	}

	private boolean isValid(final String inFile) {
		if (inFile == null) {
			return false;
		} else if (inFile.endsWith(".c")) {
			return true;
		} else if (inFile.endsWith(".h")) {
			return true;
		}
		return false;
	}

	private final Resource loadResource(final Injector injector,
			final IFile iFile) throws Exception {
		final IResourceFactory resourceFactory = injector
				.getInstance(IResourceFactory.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				".cmd", resourceFactory);

		final IProject iProject = iFile.getProject();
		final XtextResourceSetProvider provider = injector
				.getInstance(XtextResourceSetProvider.class);
		final XtextResourceSet resourceSet = (XtextResourceSet) provider
				.get(iProject);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,
				Boolean.TRUE);
		final URI uri = URI.createURI(iFile.getLocationURI().toString());
		final String uriStr = uri.toFileString();
		MyLog.trace(Main.class, "uri.toFileString()='" + uriStr + "'");
		MyLog.trace(Main.class, "uri.toString()='" + uri.toString() + "'");
		final Resource resource = resourceSet.getResource(uri, true);
		return resource;
	}

	private final void validateResource(final Injector injector,
			final Resource resource) throws Exception {
		// validate the resource
		final IResourceValidator validator = injector
				.getInstance(IResourceValidator.class);
		final List<Issue> list = validator.validate(resource, CheckMode.ALL,
				CancelIndicator.NullImpl);
		if (!(list.isEmpty())) {
			final String uri = resource.getURI().toFileString();
			this.error("Errors found during validation for resource='" + uri
					+ "': " + list.toString());
		}
	}

	private void error(final String text) throws RuntimeException {
		final String msg = "at.jku.weiner.kefax.main: text='" + text + "'";
		final RuntimeException ex = new RuntimeException(msg);
		MyLog.error(Main.class, ex);
	}

	@SuppressWarnings("unused")
	private void run() throws IOException {
		final File linuxSrcDir = Settings.DEFAULT_LINUX_DIR;
		final String linuxSrcDirPath = linuxSrcDir.getAbsolutePath();
		final File outDir = Settings.DEFAULT_OUT_DIR;
		if (outDir.exists()) {
			MyLog.debug(Main.class, "deleting existing directory '"
					+ Settings.DEFAULT_OUT + "'");
			outDir.delete();
			FileUtils.deleteDirectory(outDir);
		}
		outDir.mkdirs();
		if ((!outDir.isDirectory()) && (!outDir.canRead())) {
			final RuntimeException ex = new RuntimeException(
					"Could not create '" + outDir + "'!");
			MyLog.error(Main.class, ex);
		}
		final String outDirPath = outDir.getAbsolutePath();
		MyLog.debug(Main.class, "Using '" + linuxSrcDirPath
				+ "' as linux source directory!");
		MyLog.debug(Main.class, "Using '" + outDirPath
				+ "' as output directory!");

		final File dotConfigFile = DotConfig.getDotConfigFile(linuxSrcDir,
				linuxSrcDirPath);
		final String dotConfig = dotConfigFile.getAbsolutePath();
		final List<Config> configs = DotConfig.parseDotConfig(dotConfigFile,
				dotConfig);
		final File featuresFile = new File(outDir + "/features.txt");
		final String featuresPath = featuresFile.getAbsolutePath();
		DotConfig.createFeaturesTxt(featuresFile, featuresPath, configs);
		final File defineFile = new File(outDir + "/defines.txt");
		final String defineFilePath = defineFile.getAbsolutePath();
		DotConfig.createDefineFile(defineFile, defineFilePath, configs);
		ReadLinuxBuildFilesLog.run();
	}

	@SuppressWarnings("unused")
	private static File parseLinuxSourceDir(final String[] args) {
		if ((args == null) || (args.length <= 0)) {
			return Settings.DEFAULT_LINUX_DIR;
		}
		final String dir = args[0];
		if (dir.isEmpty()) {
			return Settings.DEFAULT_LINUX_DIR;
		}
		final File srcDir = new File(dir);
		if ((!srcDir.isDirectory()) || (!srcDir.canRead())) {
			return Settings.DEFAULT_LINUX_DIR;
		}
		return srcDir;
	}

}
