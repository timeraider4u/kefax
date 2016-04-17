package at.jku.weiner.xtext;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import at.jku.weiner.log.MyLog;

import com.google.inject.Injector;

public class XtextUtils {
	
	public static ResourceSet getResourceSetForXtext(final IProject iProject,
			final Injector injector, final String languageExtension) {
		MyLog.log(XtextUtils.class,
				"loading resource set for='" + iProject.getName()
						+ "' with ext='" + languageExtension + "'");
		final IResourceFactory resourceFactory = injector
				.getInstance(IResourceFactory.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				languageExtension, resourceFactory);

		final XtextResourceSetProvider provider = injector
				.getInstance(XtextResourceSetProvider.class);
		final XtextResourceSet resourceSet = (XtextResourceSet) provider
				.get(iProject);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,
				Boolean.TRUE);
		
		return resourceSet;
	}
	
	public static Resource loadResource(final IFile iFile,
			final Injector injector, final String languageExtension) {
		MyLog.log(XtextUtils.class, "loading resource for='" + iFile.getName()
				+ "' with ext='" + languageExtension + "'");
		final IProject iProject = iFile.getProject();
		final ResourceSet resourceSet = XtextUtils.getResourceSetForXtext(
				iProject, injector, languageExtension);
		final URI uri = URI.createURI(iFile.getLocationURI().toString());
		final String uriStr = uri.toFileString();
		MyLog.log(XtextUtils.class, "uri.toFileString()='" + uriStr + "'");
		MyLog.log(XtextUtils.class, "uri.toString()='" + uri.toString() + "'");
		final Resource resource = resourceSet.getResource(uri, true);
		return resource;
	}
	
}
