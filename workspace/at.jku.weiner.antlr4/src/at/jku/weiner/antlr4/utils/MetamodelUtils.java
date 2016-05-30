package at.jku.weiner.antlr4.utils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import at.jku.weiner.log.MyLog;

public final class MetamodelUtils {

	public static final String		ECORE_EXT	= ".ecore";

	private final IProgressMonitor	monitor;
	private final IProject			project;
	private ResourceSet				resourceSet;
	private IFolder					modelFolder;
	private IFile					mmFile;
	private Resource				myMetaModel;
	private EPackage				myPackage;

	public MetamodelUtils(final IProject project,
			final IProgressMonitor monitor, final String dirModelName)
					throws Exception {
		this.project = project;
		this.monitor = monitor;
		this.resourceSet = null;
		this.mmFile = null;
		this.modelFolder = null;
		this.myMetaModel = null;
		this.myPackage = null;
		this.setUp(dirModelName);
	}

	private void setUp(final String dirModelName) throws Exception {
		this.resourceSet = new ResourceSetImpl();
		this.resourceSet.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
		.put("ecore", new EcoreResourceFactoryImpl());
		this.resourceSet.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
		.put("xmi", new XMIResourceFactoryImpl());
		this.modelFolder = this.project.getFolder(dirModelName);
		if (!this.modelFolder.exists()) {
			this.modelFolder.create(true, true, this.monitor);
		}
	}

	public void createECoreFile(final String prefix, final String name,
			final String nsUri) throws Exception {
		final String fileName = name + MetamodelUtils.ECORE_EXT;
		this.mmFile = this.modelFolder.getFile(fileName);
		final IPath path = this.mmFile.getLocation();
		final String string = path.toOSString();
		final URI uri = URI.createFileURI(string);
		final String fileString = uri.toFileString();
		MyLog.debug(MetamodelUtils.class, "metamodel-fileName='" + fileString
				+ "'");
		this.myMetaModel = this.resourceSet.createResource(uri);
		final EcoreFactory theCoreFactory = EcoreFactory.eINSTANCE;
		this.myPackage = theCoreFactory.createEPackage();
		this.myPackage.setName(name);
		this.myPackage.setNsPrefix(prefix);
		this.myPackage.setNsURI(nsUri);
		this.myMetaModel.getContents().add(this.myPackage);
		// register locally
		this.resourceSet.getPackageRegistry().put(nsUri, this.myPackage);
		// register globally
		EPackage.Registry.INSTANCE.put(nsUri, this.myPackage);
		// save
		this.myMetaModel.save(null);
		// update project
		this.project.refreshLocal(IResource.DEPTH_INFINITE, this.monitor);
	}
	
}
