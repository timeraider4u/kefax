package at.jku.weiner.xtexttest.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

@SuppressWarnings("deprecation")
public class GenerationHandler extends AbstractHandler implements IHandler {

	@Inject
	private IGenerator generator;

	@Inject
	private Provider<EclipseResourceFileSystemAccess> fileAccessProvider;

	@Inject
	IResourceDescriptions resourceDescriptions;

	@Inject
	IResourceSetProvider resourceSetProvider;

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {

		// System.out.println("GenerationHandler.execute()");

		final ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			final Object firstElement = structuredSelection.getFirstElement();
			if (firstElement instanceof IFile) {
				final IFile file = (IFile) firstElement;
				final IProject project = file.getProject();
				final IFolder srcGenFolder = project.getFolder("src-gen");
				if (!srcGenFolder.exists()) {
					try {
						srcGenFolder.create(true, true,
								new NullProgressMonitor());
					} catch (final CoreException e) {
						return null;
					}
				}

				final EclipseResourceFileSystemAccess fsa = this.fileAccessProvider
						.get();
				fsa.setOutputPath(srcGenFolder.getFullPath().toString());

				final URI uri = URI.createPlatformResourceURI(file
						.getFullPath().toString(), true);
				final ResourceSet rs = this.resourceSetProvider.get(project);
				final Resource r = rs.getResource(uri, true);
				this.generator.doGenerate(r, fsa);

			}
		}
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
