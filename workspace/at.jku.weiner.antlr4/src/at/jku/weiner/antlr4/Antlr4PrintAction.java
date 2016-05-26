package at.jku.weiner.antlr4;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import at.jku.weiner.kefax.shared.MyActionHandler;

public class Antlr4PrintAction extends MyActionHandler {

	private static final String	PREFIX	= "My";

	public Antlr4PrintAction() {
		super("at.jku.weiner.antlr4print");
	}

	@Override
	protected void myRun() throws Exception {
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		final IProject project = root.getProject(Antlr4PrintAction.PREFIX);
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
		final IFile res = folder.getFile("My.ecore");
		final IPath path = res.getLocation();
		final String string = path.toOSString();
		final URI uri = URI.createFileURI(string);
		// final String string = res.getLocation().toOSString();
		// final java.net.URI uri = java.net.URI.createFileURI("./univ.ecore");
		// final String string = uri.toString();
		System.out.println("string='" + string + "'");
		// final String fileString = uri.toFileString();
		// System.out.println("fileString='" + fileString + "'");
		final Resource myMetaModel = resourceSet.getResource(uri, true);
		System.out.println("myMetaModel.getResourceSet()='" + myMetaModel.getResourceSet() + "'");
		System.out.println("myMetaModel.getContents().size='" + myMetaModel.getContents().size() + "'");
		final EPackage myPackage = (EPackage)myMetaModel.getContents().get(0);
		System.out.println(myPackage.getEFactoryInstance());
		// create instance
		final IFile resInst = folder.getFile("My.xmi");
		final IPath pathInst = resInst.getLocation();
		final String stringInst = pathInst.toOSString();
		final URI uriInst = URI.createFileURI(stringInst);
		final Resource myModel = resourceSet.getResource(uriInst, true);
		System.out.println("myModel.getResourceSet()='" + myModel.getResourceSet() + "'");
		System.out.println("myModel.getContents().size()='" + myModel.getContents().size() + "'");
	}
}
