package at.jku.weiner.c.preprocess.utils.macros;

import java.io.File;

import org.eclipse.emf.common.util.URI;

public class PredefinedMacros {

	private static final String BUNDLE_NAME = "at.jku.weiner.c.preprocess";

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
