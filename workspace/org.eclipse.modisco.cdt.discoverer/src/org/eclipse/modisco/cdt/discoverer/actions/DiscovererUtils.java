package org.eclipse.modisco.cdt.discoverer.actions;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.modisco.cdt.discoverer.utils.Messages;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

final class DiscovererUtils {
	private static List<String> extensionList = null;

	private DiscovererUtils() {

	}

	protected static boolean isCdtExtension(final String fileExtension) {
		final boolean result = DiscovererUtils.getExtensionList().contains(
				fileExtension);
		System.out.println("isCdtExtension='" + fileExtension + "'=" + result);
		return result;
	}

	protected static List<String> getExtensionList() {
		if (DiscovererUtils.extensionList == null) {
			final String[] list = Messages.extensionList.split(",");
			DiscovererUtils.extensionList = Arrays.asList(list);
		}
		return DiscovererUtils.extensionList;
	}

	protected static boolean checkFile(final IFile file) {
		if (!file.exists()) {
			return false;
		}
		final String ext = file.getFileExtension();
		if (ext == null) {
			return false;
		}
		System.out.println("ext=" + ext);
		final boolean result = DiscovererUtils.isCdtExtension(file
				.getFileExtension());
		System.out.println("result=" + result);
		return result;
	}

	protected static CoreModel getCoreModel() throws DiscoveryException {
		final CoreModel coreModel = CoreModel.getDefault();
		if (coreModel == null) {
			throw new DiscoveryException("coremodel is null!");
		}
		return coreModel;
	}

	public static IFile getFileFor(final File file) throws DiscoveryException {
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IPath location = Path.fromOSString(file.getAbsolutePath());
		final IFile result = workspace.getRoot().getFileForLocation(location);
		if ((file == null) || !file.exists() || !file.canRead()) {
			throw new DiscoveryException("file cannot be accessed="
					+ file.getAbsolutePath());
		}
		final IPath path = result.getFullPath();
		if ((path == null) || path.isEmpty()) {
			throw new DiscoveryException("file cannot be accessed="
					+ file.getAbsolutePath());
		}
		System.out.println("filename=" + result.getFullPath().toOSString());
		return result;
	}
}
