/**
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.kefax.dotconfig;

import at.jku.weiner.kefax.dotconfig.DotconfigStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class DotconfigStandaloneSetup extends DotconfigStandaloneSetupGenerated {
  public static void doSetup() {
    DotconfigStandaloneSetup _dotconfigStandaloneSetup = new DotconfigStandaloneSetup();
    _dotconfigStandaloneSetup.createInjectorAndDoEMFRegistration();
  }
}
