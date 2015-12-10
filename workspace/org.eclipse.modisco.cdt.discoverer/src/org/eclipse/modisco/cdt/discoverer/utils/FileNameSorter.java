package org.eclipse.modisco.cdt.discoverer.utils;

import java.io.File;
import java.util.Comparator;

public final class FileNameSorter implements Comparator<File> {

	@Override
	public int compare(final File o1, final File o2) {
		return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
	}
}
