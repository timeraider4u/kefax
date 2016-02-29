package at.jku.weiner.c.modisco.discoverer.backend;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public interface IDiscoverer {

	public Resource createTargetModel();

	public URI getTargetURI();

	public Resource getTargetModel();

	public void saveTargetModelDefault() throws IOException;

}
