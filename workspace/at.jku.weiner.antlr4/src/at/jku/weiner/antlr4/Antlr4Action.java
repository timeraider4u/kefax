package at.jku.weiner.antlr4;

import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.osgi.framework.Bundle;

import at.jku.weiner.kefax.shared.MyActionHandler;
import at.jku.weiner.log.MyLog;

public class Antlr4Action extends MyActionHandler {

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
		final IProject project = root.getProject("hello");
		if (!project.exists()) {
			project.create(this.getMonitor());
		}
		project.open(this.getMonitor());

		final ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("ecore", new EcoreResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());
		final IFile res = project.getFile("univ.ecore");
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
		univEPackage.setName("Hello");
		univEPackage.setNsPrefix("hello");
		univEPackage.setNsURI("http://www.jku.at/weiner/hello");
		final EClass clazz = theCoreFactory.createEClass();
		clazz.setInterface(false);
		clazz.setAbstract(false);
		clazz.setName("Hello");
		univEPackage.getEClassifiers().add(clazz);
		myMetaModel.getContents().add(univEPackage);

		resourceSet.getPackageRegistry().put("http://www.jku.at/weiner/hello",
				univEPackage);
		myMetaModel.save(null);
		project.refreshLocal(IResource.DEPTH_INFINITE, this.getMonitor());
	}
	
}
