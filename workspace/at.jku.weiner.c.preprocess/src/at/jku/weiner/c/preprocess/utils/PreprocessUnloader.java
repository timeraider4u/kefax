package at.jku.weiner.c.preprocess.utils;

import at.jku.weiner.c.preprocess.utils.macros.PredefinedMacros;

public final class PreprocessUnloader {

	public static final void unloadCachedStuff() {
		PredefinedMacros.clear();
	}

}
