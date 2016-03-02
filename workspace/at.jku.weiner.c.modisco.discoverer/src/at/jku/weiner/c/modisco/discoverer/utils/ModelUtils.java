package at.jku.weiner.c.modisco.discoverer.utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import at.jku.weiner.c.common.common.CommonFactory;
import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.common.log.MyLog;

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
			MyLog.trace(ModelUtils.class, "re-using existing model!");
			final EObject root = targetResource.getContents().get(0);
			if (root instanceof Model) {
				return (Model) root;
			}
		}
		final Model model = ModelUtils.createNewModel(targetResource);
		return model;
	}
	
	public static Model createNewModel(final Resource targetResource) {
		MyLog.trace(ModelUtils.class, "creating new model!");
		MyLog.trace(ModelUtils.class, "targetResource='" + targetResource + "'");
		MyLog.trace(ModelUtils.class, "targetURI='" + targetResource.getURI()
				+ "'");
		MyLog.trace(ModelUtils.class, "targetResource-contents='"
				+ targetResource.getContents() + "'");
		
		MyLog.trace(ModelUtils.class,
				"commonFactory='" + ModelUtils.getCommonFactory() + "'");

		final Model result = ModelUtils.getCommonFactory().createModel();
		MyLog.trace(ModelUtils.class, "clear contents!");

		targetResource.getContents().clear();
		MyLog.trace(ModelUtils.class, "add model!");
		targetResource.getContents().add(result);
		MyLog.trace(MyStore.class, "returning model!");
		return result;
	}
	
}
