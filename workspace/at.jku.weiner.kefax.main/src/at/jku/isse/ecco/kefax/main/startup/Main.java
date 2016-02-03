package at.jku.isse.ecco.kefax.main.startup;

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
import org.eclipse.core.runtime.NullProgressMonitor;
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

import at.jku.isse.ecco.kefax.dotconfig.dotconfig.Config;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Model;
import at.jku.weiner.c.cmdarguments.ui.internal.CmdArgsActivator;
import at.jku.weiner.c.modisco.discoverer.actions.DiscoverFromIResource;

import com.google.inject.Injector;

public class Main {

	public void start() {
		Job job = new Job("at.jku.weiner.kefax.job") {
			@Override
			protected IStatus run(final IProgressMonitor monitor) {
				Main.this.run1();
				return Status.OK_STATUS;
			}
		};

		// Start the Job
		job.schedule();
	}

	private void run1() {
		final Date start = new Date();
		try {
			Thread.sleep(1000);
			System.out.println("at.jku.weiner.kefax.main - Start of program!");
			// this.run();
			this.run2();
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
		final Date end = new Date();
		final long difference = end.getTime() - start.getTime();
		final long sec = difference / 1000;
		final long min = sec / 60;
		final long seconds = sec % 60;
		System.out.println("took '" + min + "' minutes and '" + seconds
				+ "' seconds for parsing!");
		System.out.println("at.jku.weiner.kefax.main - End of program!");
	}

	private void run2() throws Exception {
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		final IProject project = root.getProject("HelloC");
		final IResource cmdRes = project.findMember("test.cmd");
		if ((cmdRes == null) || !cmdRes.isAccessible()
				|| !(cmdRes instanceof IFile)) {
			this.error("invalid cmd file='" + cmdRes + "'!");
		}
		final IFile cmdFile = (IFile) cmdRes;
		final String cmdPath = cmdRes.getLocationURI().toString();
		System.out.println("cmdPath='" + cmdPath + "'");
		// Linux project
		final IProject linux = root.getProject("linux-3.18");
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
		System.out.println("validation has been successfull!");
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
		for (int i = 0; i < cmdLines.size(); i++) {
			final CmdLine cmdLine = cmdLines.get(i);
			final CmdArgs args = new CmdArgs(cmdPath, cmdLine, linux);
			final String additionalDirectives = args
					.getAdditionalDirectivesAsString();
			System.out.println("additionalDirectives='" + additionalDirectives
					+ "'");
			final String includeDirectories = args
					.getIncludeDirectoriesAsString();
			System.out.println("includeDirectories='" + includeDirectories
					+ "'");
			final boolean stdInclude = !args.isNoStandardInclude();
			System.out.println("stdInclude='" + stdInclude + "'");
			final String inFile = args.getInFile();
			System.out.println("inFile='" + inFile + "'");
			if (inFile == null) {
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
			discoverer.setTrimPreprocessModel(true);

			discoverer.discoverElement(inFileRes, new NullProgressMonitor());
		}
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
		// final String uriStr = uri.toFileString();
		// System.out.println("uri.toFileString()='" + uriStr + "'");
		// System.out.println("uri.toString()='" + uri.toString() + "'");
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

	private void error(final String text) {
		System.err.println("at.jku.weiner.kefax.main: text='" + text + "'");
		throw new RuntimeException(text);
	}

	@SuppressWarnings("unused")
	private void run() throws IOException {
		final File linuxSrcDir = Settings.DEFAULT_LINUX_DIR;
		final String linuxSrcDirPath = linuxSrcDir.getAbsolutePath();
		final File outDir = Settings.DEFAULT_OUT_DIR;
		if (outDir.exists()) {
			System.out.println("deleting existing directory '"
					+ Settings.DEFAULT_OUT + "'");
			outDir.delete();
			FileUtils.deleteDirectory(outDir);
		}
		outDir.mkdirs();
		if ((!outDir.isDirectory()) && (!outDir.canRead())) {
			throw new RuntimeException("Could not create '" + outDir + "'!");
		}
		final String outDirPath = outDir.getAbsolutePath();
		System.out.println("Using '" + linuxSrcDirPath
				+ "' as linux source directory!");
		System.out.println("Using '" + outDirPath + "' as output directory!");

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
