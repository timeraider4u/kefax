package at.jku.weiner.antlr4.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import at.jku.weiner.log.MyLog;

public final class MetamodelUtils {
	
	public static final String			ECORE_EXT	= ".ecore";
	
	private final IProgressMonitor		monitor;
	private final IProject				project;
	private final EcoreFactory			ecoreFactory;
	private final Map<String, MyClazz>	clazzes;
	private final EcorePackage			ecorePackage;
	
	private ResourceSet					resourceSet;
	private IFolder						modelFolder;
	private IFile						mmFile;
	private Resource					myMetaModel;
	private EPackage					myPackage;

	private String						name;
	
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
		this.clazzes = new HashMap<String, MyClazz>();
		this.ecoreFactory = EcoreFactory.eINSTANCE;
		this.ecorePackage = EcorePackage.eINSTANCE;
		this.name = null;
		
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
		this.name = name;
		this.clazzes.clear();
		final String fileName = name + MetamodelUtils.ECORE_EXT;
		this.mmFile = this.modelFolder.getFile(fileName);
		final IPath path = this.mmFile.getLocation();
		final String string = path.toOSString();
		final URI uri = URI.createFileURI(string);
		final String fileString = uri.toFileString();
		MyLog.debug(MetamodelUtils.class, "metamodel-fileName='" + fileString
				+ "'");
		this.myMetaModel = this.resourceSet.createResource(uri);
		this.myPackage = this.ecoreFactory.createEPackage();
		this.myPackage.setName(name);
		this.myPackage.setNsPrefix(prefix);
		this.myPackage.setNsURI(nsUri);
		this.myMetaModel.getContents().add(this.myPackage);
		// register locally
		this.resourceSet.getPackageRegistry().put(nsUri, this.myPackage);
		// register globally
		EPackage.Registry.INSTANCE.put(nsUri, this.myPackage);
		// save
		this.save();
		// update project
		this.project.refreshLocal(IResource.DEPTH_INFINITE, this.monitor);
	}

	public void save() throws Exception {
		this.myMetaModel.save(null);
	}

	protected MyClazz createOrFindMyClazz(final String name) {
		MyClazz myClazz = this.clazzes.get(name);
		if (myClazz == null) {
			final EClass clazz = this.ecoreFactory.createEClass();
			clazz.setInterface(false);
			clazz.setAbstract(false);
			clazz.setName(name);
			this.myPackage.getEClassifiers().add(clazz);
			myClazz = new MyClazz(name, clazz);
			this.clazzes.put(name, myClazz);
		}
		return myClazz;
	}

	public EClass createOrFindEClass(final String name) {
		final MyClazz myClazz = this.createOrFindMyClazz(name);
		final EClass clazz = myClazz.getClazz();
		return clazz;
	}

	protected void addReference(final String from, final String to) {
		final MyClazz clazzFrom = this.createOrFindMyClazz(from);
		final MyClazz clazzTo = this.createOrFindMyClazz(to);
		clazzTo.referencedBy(clazzFrom.getName());
	}

	public EPackage getEPackage() {
		return this.myPackage;
	}
	
	public EClass getTopClazz() {
		final Set<String> keys = this.clazzes.keySet();
		final Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			final String key = it.next();
			final MyClazz clazz = this.clazzes.get(key);
			if (clazz.isTopNode()) {
				return clazz.getClazz();
			}
		}
		return null;
	}

	public String getMMName() {
		return this.name;
	}

	public EAttribute addAttribute(final EClass clazz,
			final String attributeName) {
		final EAttribute attribute = this.ecoreFactory.createEAttribute();
		attribute.setName(attributeName);
		attribute.setEType(this.ecorePackage.getEString());
		attribute.setID(false);
		attribute.setChangeable(true);
		attribute.setLowerBound(0);
		attribute.setUpperBound(1);
		clazz.getEStructuralFeatures().add(attribute);
		return attribute;
	}
	
	public EReference addContainment(final EClass clazzFrom,
			final EClass clazzTo, final String attributeName) {
		final EReference ref = this.ecoreFactory.createEReference();
		ref.setName(attributeName);
		ref.setEType(clazzTo);
		ref.setChangeable(true);
		ref.setContainment(true);
		ref.setLowerBound(0);
		ref.setUpperBound(1);
		clazzFrom.getEStructuralFeatures().add(ref);
		this.addReference(clazzFrom.getName(), clazzTo.getName());
		return ref;
	}

	public EReference addContainment(final String clazzFromName,
			final String clazzToName, final String attributeName) {
		final EClass clazzFrom = this.createOrFindEClass(clazzFromName);
		final EClass clazzTo = this.createOrFindEClass(clazzToName);
		final EReference ref = this.addContainment(clazzFrom, clazzTo,
				attributeName);
		return ref;
	}

	public EReference addContainment(final String clazzFromName,
			final String clazzToName) {
		final EReference ref = this.addContainment(clazzFromName, clazzToName,
				clazzToName);
		return ref;
	}

}
