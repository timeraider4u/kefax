package at.jku.weiner.c.modisco.discoverer.backend;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public interface IDiscoverer {

	public ResourceSet getResourceSet();

	public void setResourceSet(ResourceSet resourceSet);

	public URI getTargetURI();

	public void setTargetURI(URI uri);

	public Resource getTargetResource();

	public void setTargetResource(Resource resource);
	
}
