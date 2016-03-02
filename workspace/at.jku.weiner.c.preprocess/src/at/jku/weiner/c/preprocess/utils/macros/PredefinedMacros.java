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

import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;

import com.google.common.collect.Iterators;

public class PredefinedMacros {
	public static final String MACRO_FILE = "__FILE__";
	public static final String MACRO_LINE = "__LINE__";

	private static final String BUNDLE_NAME = "at.jku.weiner.c.preprocess";

	private static Preprocess predefined = null;
	private static boolean stdPreInclude = false;

	public static void clear() {
		PredefinedMacros.predefined = null;
		PredefinedMacros.stdPreInclude = false;
	}

	public static Preprocess loadPreDefinedMacros(final boolean standAlone,
			final boolean stdInclude) {
		if ((PredefinedMacros.predefined != null)
				&& (PredefinedMacros.stdPreInclude == stdInclude)) {
			MyLog.trace(PredefinedMacros.class,
					"returning an existing pre-defined macros preprocessor");
			return PredefinedMacros.predefined;
		}
		MyLog.trace(PredefinedMacros.class,
				"creating a new predefined-macros preprocessor");
		final URI predefinedURI = PredefinedMacros.getPredefinedURI(standAlone,
				stdInclude);
		final ResourceSet rs = new XtextResourceSet();
		final Resource predefinedRes = rs.getResource(predefinedURI, true);
		final TreeIterator<EObject> _allContents = predefinedRes
				.getAllContents();
		final Iterator<Preprocess> _filter = Iterators.<Preprocess> filter(
				_allContents, Preprocess.class);
		final Preprocess _head = IteratorExtensions.<Preprocess> head(_filter);
		PredefinedMacros.predefined = _head;
		PredefinedMacros.stdPreInclude = stdInclude;
		return PredefinedMacros.predefined;
	}

	/***
	 * insert pre-defined macros
	 */
	public static URI getPredefinedURI(final boolean standAlone,
			final boolean stdInclude) {
		final String suffix = PredefinedMacros.getSuffix(stdInclude);
		final String fileName = "res/predefined/gcc_4.8.4_" + suffix + ".h";
		if (standAlone) {
			return PredefinedMacros.getURIFromFile(fileName);
		}
		final URI uri = URI.createPlatformPluginURI("/"
				+ PredefinedMacros.BUNDLE_NAME + "/" + fileName, true);
		return uri;
	}

	private static String getSuffix(final boolean stdInclude) {
		if (stdInclude) {
			return "default";
		}
		return "nostdinc";
	}

	private static URI getURIFromFile(final String fileName) {
		final File file = new File(".");
		final URI uri = URI.createFileURI("../" + PredefinedMacros.BUNDLE_NAME
				+ File.separator + fileName);
		final URI base = URI.createFileURI(file.getAbsolutePath());
		return uri.resolve(base);
	}

}
