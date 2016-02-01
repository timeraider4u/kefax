package at.jku.weiner.kefax.main;

import org.eclipse.ui.IStartup;

import at.jku.isse.ecco.kefax.main.startup.Main;

public class MainStartUp implements IStartup {

	@Override
	public void earlyStartup() {
		Main main = new Main();
		main.start();
	}

}
