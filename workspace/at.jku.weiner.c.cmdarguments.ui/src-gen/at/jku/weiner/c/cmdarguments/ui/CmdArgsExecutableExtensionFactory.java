/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.c.cmdarguments.ui;

import at.jku.weiner.c.cmdarguments.ui.internal.CmdArgsActivator;
import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class CmdArgsExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return CmdArgsActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return CmdArgsActivator.getInstance().getInjector(CmdArgsActivator.AT_JKU_WEINER_C_CMDARGUMENTS_CMDARGS);
	}
	
}
