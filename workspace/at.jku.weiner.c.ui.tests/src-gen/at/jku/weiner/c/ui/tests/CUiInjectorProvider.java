/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.c.ui.tests;

import at.jku.weiner.c.ui.internal.CActivator;
import com.google.inject.Injector;
import org.eclipse.xtext.junit4.IInjectorProvider;

public class CUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return CActivator.getInstance().getInjector("at.jku.weiner.c.C");
	}

}