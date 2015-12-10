package org.eclipse.modisco.kconfig.discoverer.actions;

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;

final class AccessibilityUtils {

	protected static boolean isAccessible(final IResource resource) {
		if (resource instanceof IFile) {
			return AccessibilityUtils.checkFile((IFile) resource);
		}
		if (resource instanceof IContainer) {
			final IContainer container = (IContainer) resource;
			System.out.println("isContainer");
			return container.isAccessible();
		}
		return false;
	}

	protected static boolean checkFile(final IFile file) {
		if (!file.exists()) {
			return false;
		}
		final File myFile = file.getLocation().toFile();
		final String path = myFile.getPath();
		if (path.endsWith("kconfig") || path.endsWith(".kconfig")
				|| path.endsWith("Kconfig")) {
			return true;
		}
		return false;
	}

}
