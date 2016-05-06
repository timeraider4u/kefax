package org.eclipse.modisco.kconfig.discoverer.parser;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.modisco.kconfig.KconfigFactory;
import org.eclipse.modisco.kconfig.Model;
import org.eclipse.modisco.kconfig.TranslationUnit;

public class UnitHelper {

	public static TranslationUnit lookUpTranslationUnit(
			final KconfigFactory factory, final Model model,
			final String fileName, final boolean isFullPath) {
		final String myFileName = UnitHelper.getMyPath(model, fileName);
		for (final TranslationUnit tmp : model.getUnits()) {
			final String name = tmp.getName();
			if (myFileName.equals(name)) {
				if (isFullPath) {
					tmp.setFullPath(fileName);
				}
				return tmp;
			}
		}
		final TranslationUnit unit = factory.createTranslationUnit();
		unit.setUnitOwner(model);
		if (isFullPath) {
			unit.setFullPath(fileName);
		}
		unit.setName(myFileName);
		model.getUnits().add(unit);
		return unit;
	}

	private static String getMyPath(final Model model, final String fileName) {
		final String modelPath = model.getFullPath();
		final String path = fileName.replaceAll(modelPath, "");
		if (path.startsWith("/") && (path.length() > 1)) {
			return path.substring(1);
		}
		return path;
	}

	@SuppressWarnings("unused")
	private static String getWorkspaceRoot() {
		final IPath rootPath = ResourcesPlugin.getWorkspace().getRoot()
				.getLocation();
		return rootPath.toString();
	}

}
