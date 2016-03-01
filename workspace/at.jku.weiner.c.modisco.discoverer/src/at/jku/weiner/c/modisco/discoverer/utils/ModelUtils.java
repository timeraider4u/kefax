package at.jku.weiner.c.modisco.discoverer.utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import at.jku.weiner.c.common.common.CommonFactory;
import at.jku.weiner.c.common.common.Model;

public final class ModelUtils {

	private static CommonFactory factory = null;

	private ModelUtils() {

	}

	public static CommonFactory getCommonFactory() {
		if (ModelUtils.factory == null) {
			ModelUtils.factory = CommonFactory.eINSTANCE;
		}
		return ModelUtils.factory;
	}

	public static Model getModel(final MySettings mySettings,
			final Resource targetResource) {
		final EList<EObject> list = targetResource.getContents();
		if (mySettings.isBatchMode() && (list != null) && (list.size() == 1)) {
			final EObject root = targetResource.getContents().get(0);
			if (root instanceof Model) {
				return (Model) root;
			}
		}
		final Model model = ModelUtils.createNewModel(targetResource);
		return model;
	}

	public static Model createNewModel(final Resource targetResource) {
		final Model result = ModelUtils.getCommonFactory().createModel();
		targetResource.getContents().clear();
		targetResource.getContents().add(result);
		return result;
	}

}
