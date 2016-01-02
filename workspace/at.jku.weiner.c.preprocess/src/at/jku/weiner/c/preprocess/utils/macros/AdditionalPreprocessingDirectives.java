package at.jku.weiner.c.preprocess.utils.macros;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;

import at.jku.weiner.c.preprocess.preprocess.Preprocess;

public class AdditionalPreprocessingDirectives {
	
	public static Preprocess getAdditionalDirectivesFor(
			final String additionalPreprocessorDirectives) throws IOException {

		final ResourceSet resourceSet = new XtextResourceSet();
		final Resource resource = resourceSet.createResource(URI
				.createURI("dummy:/additionalDefines.c"));
		// System.out.println("Resource='" + resource + "'");
		final InputStream in = new ByteArrayInputStream(
				additionalPreprocessorDirectives.getBytes());
		resource.load(in, resourceSet.getLoadOptions());
		final Preprocess preprocess = (Preprocess) resource.getContents()
				.get(0);
		return preprocess;
	}

}
