package at.jku.weiner.kefax.main.menu;

import java.util.Date;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.facet.util.emf.core.IBrowserRegistry;
import org.eclipse.emf.facet.util.emf.core.IResourceBrowserOpener;
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
import at.jku.weiner.c.modisco.discoverer.actions.impl.DiscoverFromIResource;
import at.jku.weiner.kefax.infra.cmdargs.CmdArgs;
import at.jku.weiner.kefax.shared.KefaxUtils;
import at.jku.weiner.kefax.shared.MyActionHandler;
import at.jku.weiner.log.MyLog;

import com.google.inject.Injector;

public class MainHandler extends MyActionHandler {

	public MainHandler() {
		super("at.jku.weiner.kefax.job");
	}

	private IProject project = null;

	@Override
	protected void myRun() throws Exception {
		final Date start = new Date();
		final DiscoverFromIResource discoverer = new DiscoverFromIResource();
		try {
			this.project = KefaxUtils.getLinuxDiscoverProject();
			MyLog.log(MainHandler.class,
					"at.jku.weiner.kefax.main - Start of program!");
			this.run2(this.getMonitor(), discoverer);
		} catch (final Exception ex) {
			ex.printStackTrace();
			this.updateProject();
			discoverer.close();
			MyLog.error(MainHandler.class, ex);
		}
		this.updateProject();
		discoverer.close();
		final Date end = new Date();
		final long difference = end.getTime() - start.getTime();
		final long sec = difference / 1000;
		final long min = sec / 60;
		final long seconds = sec % 60;
		MyLog.log(MainHandler.class, "took '" + min + "' minutes and '"
				+ seconds + "' seconds for parsing!");
		MyLog.log(MainHandler.class,
				"at.jku.weiner.kefax.main - End of program!");
	}

	private void run2(final IProgressMonitor monitor,
			final DiscoverFromIResource discoverer) throws Exception {
		final IFile cmdFile = KefaxUtils.getCommandsFile();

		if ((cmdFile == null) || !cmdFile.isAccessible()) {
			this.error("invalid cmd file='" + cmdFile + "'!");
		}
		final String cmdPath = cmdFile.getLocationURI().toString();
		MyLog.log(MainHandler.class, "cmdPath='" + cmdPath + "'");
		final IFolder dstFolder = KefaxUtils.getLinuxDiscoverSrcFolder();
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
		MyLog.debug(MainHandler.class,
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
		monitor.beginTask("iterating modules", cmdLines.size());
		final int total = cmdLines.size() + 1;
		for (int i = 0; i < cmdLines.size(); i++) {
			if (monitor.isCanceled()) {
				throw new OperationCanceledException(
						"operation canceled by user");
			}
			monitor.worked(i);
			final int num = i + 1;
			MyLog.log(MainHandler.class, "cmdLine=" + num + "/" + total + "!");
			final CmdLine cmdLine = cmdLines.get(i);
			final CmdArgs args = new CmdArgs(cmdFile, cmdLine);
			final String additionalDirectives = args
					.getAdditionalDirectivesAsString();
			MyLog.debug(MainHandler.class, "additionalDirectives='"
					+ additionalDirectives + "'");
			final String includeDirectories = args
					.getIncludeDirectoriesAsString();
			MyLog.debug(MainHandler.class, "includeDirectories='"
					+ includeDirectories + "'");
			final boolean stdInclude = !args.isNoStandardInclude();
			MyLog.debug(MainHandler.class, "stdInclude='" + stdInclude + "'");
			// final IFolder dstSrcFolder =
			// KefaxUtils.getLinuxDiscoverSrcFolder();
			final List<IPath> inFiles = args.getInRealCFilePath();
			for (int j = 0; j < inFiles.size(); j++) {
				final IPath inFilePath = inFiles.get(j);
				// final IFile inFile = dstSrcFolder.getFile(inFilePath);
				final String fileName = inFilePath.toString();
				this.discoverSourceFile(monitor, discoverer, dstFolder,
						additionalDirectives, includeDirectories, stdInclude,
						fileName);
			}
		}
		// open browser
		MyLog.debug(MainHandler.class, "discovering finished! Opening browser now!");
		final Resource targetModel = discoverer.getTargetResource();
		final IBrowserRegistry browserRegistry = IBrowserRegistry.INSTANCE;
		final IResourceBrowserOpener browser = browserRegistry.getDefaultResourceBrowserOpener();
		MyLog.debug(MainHandler.class, "opening browser='" + browser + "'");
		browser.openResource(targetModel);
	}

	private void discoverSourceFile(final IProgressMonitor monitor,
			final DiscoverFromIResource discoverer, final IFolder dstFolder,
			final String additionalDirectives, final String includeDirectories,
			final boolean stdInclude, final String inFile) throws Exception {
		MyLog.debug(MainHandler.class, "inFile='" + inFile + "'");
		if (!this.isValid(inFile)) {
			MyLog.debug(MainHandler.class, "inFile is invalid, inFile='"
					+ inFile + "'!");
			return;
		}
		// get discoverer resource input file
		final IResource inFileRes = dstFolder.findMember(inFile);
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
		// discoverer.setUseNeoEMF(true);
		discoverer.setUseNeoEMF(false);
		discoverer.discoverElement(inFileRes, monitor);
		this.updateProject();
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
		MyLog.trace(MainHandler.class, "uri.toFileString()='" + uriStr + "'");
		MyLog.trace(MainHandler.class, "uri.toString()='" + uri.toString()
				+ "'");
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
		MyLog.error(MainHandler.class, ex);
	}

	private void updateProject() throws Exception {
		if ((this.project != null) && (this.project.exists())) {
			this.project.refreshLocal(IResource.DEPTH_INFINITE,
					this.getMonitor());
		}
	}

}
