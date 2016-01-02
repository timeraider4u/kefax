/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.c.cmdarguments;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.common.TerminalsStandaloneSetup;

@SuppressWarnings("all")
public class CmdArgsStandaloneSetupGenerated implements ISetup {

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		TerminalsStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new CmdArgsRuntimeModule());
	}
	
	public void register(Injector injector) {
		
		
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.jku.at/weiner/c/cmdarguments/CmdArgs")) {
		EPackage.Registry.INSTANCE.put("http://www.jku.at/weiner/c/cmdarguments/CmdArgs", at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage.eINSTANCE);
		}
		
		
		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		org.eclipse.xtext.resource.IResourceServiceProvider serviceProvider = injector.getInstance(org.eclipse.xtext.resource.IResourceServiceProvider.class);
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("cmd", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("cmd", serviceProvider);
		
		
	}
}
