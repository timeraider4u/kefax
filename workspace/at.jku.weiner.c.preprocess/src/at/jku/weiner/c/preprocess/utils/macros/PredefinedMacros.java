package at.jku.weiner.c.preprocess.utils.macros;

import java.io.File;
import java.util.Iterator;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import com.google.common.collect.Iterators;

import at.jku.weiner.c.preprocess.preprocess.Preprocess;

public class PredefinedMacros {

	private static final String BUNDLE_NAME = "at.jku.weiner.c.preprocess";
	
	private static Preprocess predefined = null;
	
	public static Preprocess loadPreDefinedMacros(final boolean standAlone) {
		if (PredefinedMacros.predefined != null) {
			return PredefinedMacros.predefined;
		}
		final URI predefinedURI = PredefinedMacros.getPredefinedURI(standAlone);
		final ResourceSet rs = new XtextResourceSet();
		final Resource predefinedRes = rs.getResource(predefinedURI, true);
		final TreeIterator<EObject> _allContents = predefinedRes
				.getAllContents();
		final Iterator<Preprocess> _filter = Iterators.<Preprocess> filter(
				_allContents, Preprocess.class);
		final Preprocess _head = IteratorExtensions.<Preprocess> head(_filter);
		PredefinedMacros.predefined = _head;
		return PredefinedMacros.predefined;
	}

	/***
	 * insert pre-defined macros
	 */
	public static URI getPredefinedURI(final boolean standAlone) {
		final String fileName = "res/predefined/gcc_4.8.4.h";
		if (standAlone) {
			return PredefinedMacros.getURIFromFile(fileName);
		}
		final URI uri = URI.createPlatformPluginURI("/"
				+ PredefinedMacros.BUNDLE_NAME + "/" + fileName, true);
		return uri;
	}

	private static URI getURIFromFile(final String fileName) {
		final File file = new File(".");
		final URI uri = URI.createFileURI("../" + PredefinedMacros.BUNDLE_NAME
				+ File.separator + fileName);
		final URI base = URI.createFileURI(file.getAbsolutePath());
		return uri.resolve(base);
	}

}
