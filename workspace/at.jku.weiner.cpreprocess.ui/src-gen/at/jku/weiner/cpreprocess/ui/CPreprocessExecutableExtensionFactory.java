/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.cpreprocess.ui;

import at.jku.weiner.cpreprocess.ui.internal.CPreprocessActivator;
import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class CPreprocessExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return CPreprocessActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return CPreprocessActivator.getInstance().getInjector(CPreprocessActivator.AT_JKU_WEINER_CPREPROCESS_CPREPROCESS);
	}
	
}
