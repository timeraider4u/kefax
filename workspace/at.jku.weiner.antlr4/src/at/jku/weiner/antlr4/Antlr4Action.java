package at.jku.weiner.antlr4;

import java.net.URL;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
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
import org.osgi.framework.Bundle;

import at.jku.weiner.kefax.shared.MyActionHandler;
import at.jku.weiner.log.MyLog;

public class Antlr4Action extends MyActionHandler {

	private static final String	PREFIX	= "hello";
	private static final String	NS_URI	= "http://www.jku.at/weiner/hello";

	public Antlr4Action() {
		super("at.jku.weiner.antlr4");
	}

	@Override
	protected void myRun() throws Exception {
		final Bundle bundle = Activator.getContext().getBundle();
		final URL url = bundle.getEntry(Main.FILE_NAME1);
		final URL fileURL = FileLocator.toFileURL(url);
		final String fileName = fileURL.getFile();
		final String result = Main.runInternal(fileName);
		MyLog.setLog_level(MyLog.LOG_INFO);
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
				XMLResource.OPTION_ENCODING, "UTF-8");
		genModelResource.getContents().add(genModel);
		genModelResource.save(Collections.EMPTY_MAP);

	}
}
