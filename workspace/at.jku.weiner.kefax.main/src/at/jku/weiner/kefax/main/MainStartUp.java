package at.jku.weiner.kefax.main;

import org.eclipse.ui.IStartup;

import at.jku.weiner.kefax.main.work.Main;

public class MainStartUp implements IStartup {

	@Override
	public void earlyStartup() {
		Main main = new Main();
		main.start();
	}

}
