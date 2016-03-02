package at.jku.weiner.c.modisco.discoverer.tests;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmt.modisco.infra.common.core.internal.utils.ProjectUtils;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Bundle;

import at.jku.weiner.c.common.common.CommonFactory;
import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.modisco.discoverer.backend.IDiscoverer;
import at.jku.weiner.c.modisco.discoverer.backend.SerializationBackend;
import at.jku.weiner.c.modisco.discoverer.backend.SerializationFactory;
import at.jku.weiner.c.modisco.discoverer.utils.MySettings;

@SuppressWarnings("restriction")
public class TestNeoEMFBackend {
	
	private SerializationBackend backend;
	private MySettings mySettings;
	private MyMockDiscoverer discoverer;
	private IProject iProject;
	
	@Before
	public void setUp() throws Exception {
		Thread.sleep(250);
		Assert.assertNotNull(ResourcesPlugin.getWorkspace().getRoot());
		this.mySettings = new MySettings();
		this.mySettings.setUseNeoEMF(true);
		this.discoverer = new MyMockDiscoverer();
		this.backend = SerializationFactory.getBackend(this.discoverer,
				this.mySettings);
		this.backend.initialize();
		this.iProject = this.getProject();
	}
	
	private IProject getProject() throws Exception {
		final Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		final IProject project = ProjectUtils.importPlugin(bundle);
		return project;
	}
	
	@After
	public void tearDown() throws Exception {
		this.backend.close();
		this.cleanUpOldProject();
	}

	private void cleanUpOldProject() throws CoreException {
		final IProject oldProject = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(Activator.PLUGIN_ID);
		if (oldProject.exists()) {
			oldProject.delete(true, true, new NullProgressMonitor());
		}
	}
	
	@Test
	public void test() throws DiscoveryException, IOException {
		this.backend.updateTargetURI(this.iProject, new NullProgressMonitor());
		final URI targetURI = this.discoverer.getTargetURI();
		Assert.assertNotNull(targetURI);
		
		this.backend.updateTargetResource();
		final Resource resource = this.discoverer.getTargetResource();
		Assert.assertNotNull(resource);
		this.backend.save(this.discoverer.getTargetResource(),
				this.discoverer.getTargetURI());
	}

	@Test
	public void test2() throws DiscoveryException, IOException {
		this.backend.updateTargetURI(this.iProject, new NullProgressMonitor());
		final URI targetURI = this.discoverer.getTargetURI();
		Assert.assertNotNull(targetURI);
		
		this.backend.updateTargetResource();
		final Resource resource = this.discoverer.getTargetResource();
		final CommonFactory commonFactory = CommonFactory.eINSTANCE;
		final Model model = commonFactory.createModel();
		resource.getContents().add(model);
		Assert.assertNotNull(resource);
		this.backend.save(this.discoverer.getTargetResource(),
				this.discoverer.getTargetURI());
	}
	
	private class MyMockDiscoverer implements IDiscoverer {
		
		private ResourceSet resSet = null;
		private URI targetURI = null;
		private Resource resource = null;
		
		@Override
		public ResourceSet getResourceSet() {
			return this.resSet;
		}
		
		@Override
		public void setResourceSet(final ResourceSet resourceSet) {
			this.resSet = resourceSet;
		}
		
		@Override
		public URI getTargetURI() {
			return this.targetURI;
		}
		
		@Override
		public void setTargetURI(final URI uri) {
			this.targetURI = uri;
		}
		
		@Override
		public Resource getTargetResource() {
			return this.resource;
		}
		
		@Override
		public void setTargetResource(final Resource resource) {
			this.resource = resource;
		}

	}

}
