package at.jku.weiner.antlr4;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.framework.Bundle;

import at.jku.weiner.kefax.shared.MyActionHandler;
import at.jku.weiner.log.MyLog;

public class Antlr4Action extends MyActionHandler {

	private static final String OUTPUT_FOLDER = "bin";
	private static final String ENCODING = "UTF-8";
	private static final String ANTLR_GEN = "src-gen";
	private static final String	PREFIX	= "hello";
	private static final String	NS_URI	= "http://www.jku.at/weiner/hello";
	private static final String LIB_DIR = "lib";
	private static final String LIB_FILE = "antlr-4.4-complete.jar";
	private static final String PACKAGE = "my.mydefault.mysecond.third";

	public Antlr4Action() {
		super("at.jku.weiner.antlr4");
	}

	@Override
	protected void myRun() throws Exception {
		MyLog.setLog_level(MyLog.LOG_INFO);
		final Bundle bundle = Activator.getContext().getBundle();

		final ExecutionEvent event = this.getEvent();
		// get workbench window
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		// set selection service
		final ISelectionService service = window.getSelectionService();
		// set structured selection
		final IStructuredSelection structured = (IStructuredSelection) service.getSelection();

		//check if it is an IResource
		final Object selected = structured.getFirstElement();
		if (selected instanceof IResource) {
			// get the selected resource
			final IResource file = (IResource) structured.getFirstElement();
			final IProject project = file.getProject();
			// get the path
			final IPath path = file.getLocation();
			final String myPath = path.toOSString();
			final URL url = bundle.getEntry(Antlr4Action.LIB_DIR + "/" + Antlr4Action.LIB_FILE);
			final URL fileURL = FileLocator.toFileURL(url);
			final String srcLibFileName = fileURL.getFile();
			final IFolder dstSourceGenFolder = project.getFolder(Antlr4Action.ANTLR_GEN);
			final IPath dstSourceGenFolderPath = dstSourceGenFolder.getFullPath();
			if (!dstSourceGenFolder.exists()) {
				dstSourceGenFolder.create(true, true, this.getMonitor());
			}
			IFolder dstSourceGenDstFolder = dstSourceGenFolder;
			final String[] segments = Antlr4Action.PACKAGE.split("[\\.]");
			for (int i = 0; i < segments.length; i++) {
				final String segment = segments[i];
				dstSourceGenDstFolder = dstSourceGenDstFolder.getFolder(segment);
				MyLog.log(Antlr4Action.class, "create folder='" + dstSourceGenDstFolder + "'");
				if (!dstSourceGenDstFolder.exists()) {
					dstSourceGenDstFolder.create(true, true, this.getMonitor());
				}
			}
			final IPath dstSourceGenDstFolderPath = dstSourceGenDstFolder.getLocation();
			final String dstSrcGenFolderName = dstSourceGenDstFolderPath.toOSString();
			MyLog.log(Antlr4Action.class, this.getClass().getCanonicalName()
					+  ": execute on path='" + myPath + "'");
			final ProcessBuilder builder = new ProcessBuilder( "java", "-cp", srcLibFileName,
					"org.antlr.v4.Tool", myPath, "-listener", "-visitor", "-encoding", Antlr4Action.ENCODING,
					"-package", Antlr4Action.PACKAGE, "-o", dstSrcGenFolderName);
			final Process process = builder.start();
			final InputStream stream = process.getErrorStream();
			final InputStreamReader reader = new InputStreamReader(stream);
			final BufferedReader in = new BufferedReader(reader);
			String line = "";
			try {
				while ((line = in.readLine()) != null) {
					MyLog.log(Antlr4Action.class, line);
				}
			} finally {
				in.close();
				reader.close();
				stream.close();
			}
			process.waitFor();
			final int retVal = process.exitValue();
			process.destroy();
			MyLog.log(Antlr4Action.class, "returnVal of org.antlr.v4.Tool='" + retVal + "'");
			project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
			final IProjectDescription description = project.getDescription();
			final String[] naturesOrig = description.getNatureIds();
			final List<String> natures = new ArrayList<String>(Arrays.asList(naturesOrig));
			if (!natures.contains(JavaCore.NATURE_ID)) {
				natures.add(JavaCore.NATURE_ID);
			}
			description.setNatureIds(natures.toArray(new String[0]));
			project.setDescription(description, this.getMonitor());
			final IFolder dstLibFolder = project.getFolder(Antlr4Action.LIB_DIR);
			if (!dstLibFolder.exists()) {
				dstLibFolder.create(true, true, this.getMonitor());
			}
			final IFile dstLibFile = dstLibFolder.getFile(Antlr4Action.LIB_FILE);
			final IPath dstLibFilePath = dstLibFile.getLocation();
			final String dstLibFileName = dstLibFilePath.toOSString();
			if (!dstLibFile.exists()) {
				final File src = new File(srcLibFileName);
				final File dst = new File(dstLibFileName);
				FileUtils.copyFile(src, dst);
			}
			project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
			final IJavaProject javaProject = JavaCore.create(project);
			final IFolder binFolder = project.getFolder(Antlr4Action.OUTPUT_FOLDER);
			if (!binFolder.exists()) {
				binFolder.create(true, true, this.getMonitor());
			}
			javaProject.setOutputLocation(binFolder.getFullPath(), null);
			final Set<IClasspathEntry> entries = new HashSet<IClasspathEntry>();
			entries.addAll(Arrays.asList(javaProject.getRawClasspath()));
			final IClasspathEntry clazzPathEntry = JavaRuntime.getDefaultJREContainerEntry();
			if (!entries.contains(clazzPathEntry)) {
				entries.add(clazzPathEntry);
			}
			final IClasspathEntry srcPathEntry = JavaCore.newSourceEntry(dstSourceGenFolderPath);
			if (!entries.contains(srcPathEntry)) {
				entries.add(srcPathEntry);
			}
			final IClasspathEntry libPathEntry = JavaCore.newLibraryEntry(dstLibFile.getFullPath(), null, null);
			if (!entries.contains(libPathEntry)) {
				entries.add(libPathEntry);
			}
			final IClasspathEntry projectEntry = JavaCore.newSourceEntry(project.getFullPath());
			if (entries.contains(projectEntry)) {
				entries.remove(projectEntry);
			}
			final IClasspathEntry[] clazzPath = new IClasspathEntry[entries.size()];
			final IClasspathEntry[] clazzPath2 = entries.toArray(clazzPath);
			for (int i = 0; i < clazzPath2.length; i++) {
				final IClasspathEntry entry = clazzPath2[i];
				final IPath entryPath = entry.getPath();
				MyLog.log(Antlr4Action.class, "clazzPath(" + i + ")='" + entry + "', path='" + entryPath + "'");
			}
			javaProject.setRawClasspath(clazzPath2, this.getMonitor());
			project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
			return;
		}


		final URL url = bundle.getEntry(Main.FILE_NAME1);
		final URL fileURL = FileLocator.toFileURL(url);
		final String fileName = fileURL.getFile();
		final String result = Main.runInternal(fileName);
		MyLog.log(Antlr4Action.class, "result='" + result + "'");

		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		final IProject project = root.getProject(Antlr4Action.PREFIX);
		if (!project.exists()) {
			project.create(this.getMonitor());
		}
		project.open(this.getMonitor());

		final ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
		.put("ecore", new EcoreResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
		.put("xmi", new XMIResourceFactoryImpl());
		final IFolder folder = project.getFolder("model");
		if (!folder.exists()) {
			folder.create(true, true, this.getMonitor());
		}
		final IFile res = folder.getFile("hello.ecore");
		final IPath path = res.getLocation();
		final String string = path.toOSString();
		final URI uri = URI.createFileURI(string);
		// final String string = res.getLocation().toOSString();
		// final java.net.URI uri = java.net.URI.createFileURI("./univ.ecore");
		// final String string = uri.toString();
		System.out.println("string='" + string + "'");
		// final String fileString = uri.toFileString();
		// System.out.println("fileString='" + fileString + "'");
		final Resource myMetaModel = resourceSet.createResource(uri);
		final EcoreFactory theCoreFactory = EcoreFactory.eINSTANCE;
		final EPackage univEPackage = theCoreFactory.createEPackage();
		univEPackage.setName(Antlr4Action.PREFIX);
		univEPackage.setNsPrefix(Antlr4Action.PREFIX);
		univEPackage.setNsURI(Antlr4Action.NS_URI);
		//final EFactory factory =
		//univEPackage.setEFactoryInstance(factory);
		final EClass clazz = theCoreFactory.createEClass();
		clazz.setInterface(false);
		clazz.setAbstract(false);
		clazz.setName("HelloClass");
		final EAttribute attribute = theCoreFactory.createEAttribute();
		attribute.setName("message");
		attribute.setEType(EcorePackage.eINSTANCE.getEString());
		attribute.setID(false);
		attribute.setChangeable(true);
		attribute.setLowerBound(0);
		attribute.setUpperBound(1);
		clazz.getEStructuralFeatures().add(attribute);
		univEPackage.getEClassifiers().add(clazz);
		myMetaModel.getContents().add(univEPackage);

		// register locally
		resourceSet.getPackageRegistry().put(Antlr4Action.NS_URI, univEPackage);
		// register globally
		EPackage.Registry.INSTANCE.put(Antlr4Action.NS_URI, univEPackage);
		myMetaModel.save(null);
		System.out.println("ePackage.getEFactory='" + univEPackage.getEFactoryInstance() + "'");
		System.out.println("myMetaModel.getResourceSet()='" + myMetaModel.getResourceSet() + "'");
		System.out.println("myMetaModel.getContents().size()='" + myMetaModel.getContents().size() + "'");
		project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
		// create genmodel
		final IFile genModel = folder.getFile("hello.genmodel");
		final IPath pathGenModel = genModel.getLocation();
		final String stringGenModel = pathGenModel.toOSString();
		this.createGenModel(univEPackage, string, stringGenModel, project);
		project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
		// create instance
		final IFile resInst = folder.getFile("hello.xmi");
		final IPath pathInst = resInst.getLocation();
		final String stringInst = pathInst.toOSString();
		final URI uriInst = URI.createFileURI(stringInst);
		final Resource myModel = resourceSet.createResource(uriInst);
		final EFactory univInstance = univEPackage.getEFactoryInstance();
		final EObject adultObject = univInstance.create(clazz);
		adultObject.eSet(attribute, "Hello World!");


		myModel.getContents().add(adultObject);
		myModel.save(null);
		System.out.println("myModel.getResourceSet()='" + myModel.getResourceSet() + "'");
		System.out.println("myModel.getContents().size()='" + myModel.getContents().size() + "'");

		project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());

	}

	private void createGenModel(final EPackage rootPackage,
			final String ecoreLocation, final String genModelLocation,
			final IProject project) throws Exception {

		final GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
		genModel.setComplianceLevel(GenJDKLevel.JDK70_LITERAL);
		final IFile genDir = project.getFile("emf-gen");
		final IPath pathGenDir = genDir.getFullPath();
		final String stringGenDir = pathGenDir.toString();
		genModel.setModelDirectory(stringGenDir);
		genModel.getForeignModel().add(new Path(ecoreLocation).lastSegment());
		final String name = rootPackage.getName();
		genModel.setModelName(name);
		genModel.setRootExtendsInterface("org.eclipse.emf.ecore.EObject");
		genModel.initialize(Collections.singleton(rootPackage));
		genModel.setOperationReflection(true);
		genModel.setEditorPluginID(name + ".edit");
		genModel.setEditorPluginID(name + ".editor");
		genModel.setModelPluginID(name);
		genModel.setTestsPluginID(name + ".tests");

		final GenPackage genPackage = genModel.getGenPackages().get(0);
		genPackage.setPrefix(rootPackage.getNsPrefix());

		final URI genModelURI = URI.createFileURI(genModelLocation);
		final XMIResourceImpl genModelResource = new XMIResourceImpl(
				genModelURI);
		genModelResource.getDefaultSaveOptions().put(
				XMLResource.OPTION_ENCODING, Antlr4Action.ENCODING);
		genModelResource.getContents().add(genModel);
		genModelResource.save(Collections.EMPTY_MAP);

	}
}
