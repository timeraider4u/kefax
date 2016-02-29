package at.jku.weiner.c.modisco.discoverer.backend;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public interface IDiscoverer {
	
	public URI getTargetURI();
	
	public Resource getTargetModel();

}
