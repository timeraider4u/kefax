package at.jku.weiner.antlr4.tests.mocks;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class ExampleProjectNature implements IProjectNature {
	
	public static final String NATURE_ID = "at.jku.weiner.antlr4.tests.examplenature";
	
	private IProject project = null;
	
	@Override
	public void configure() throws CoreException {
	}
	
	@Override
	public void deconfigure() throws CoreException {
		
	}
	
	@Override
	public IProject getProject() {
		return this.project;
	}
	
	@Override
	public void setProject(final IProject project) {
		this.project = project;
	}
	
}
