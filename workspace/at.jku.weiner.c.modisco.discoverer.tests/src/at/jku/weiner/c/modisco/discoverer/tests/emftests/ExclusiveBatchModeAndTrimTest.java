package at.jku.weiner.c.modisco.discoverer.tests.emftests;

import org.eclipse.core.resources.IResource;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.c.modisco.discoverer.actions.AbstractDiscovererWithLogic;
import at.jku.weiner.c.modisco.discoverer.actions.impl.DiscoverFromIResource;
import at.jku.weiner.log.MyLog;

public class ExclusiveBatchModeAndTrimTest {
	
	@Before
	public void setUp() {
		MyLog.setLog_level(MyLog.LOG_NONE);
	}
	
	@Test(expected = RuntimeException.class)
	public void test() {
		final AbstractDiscovererWithLogic<IResource> discoverer = new DiscoverFromIResource();
		discoverer.setTrimPreprocessModel(true);
		discoverer.setBatchMode(true);
	}
	
}
