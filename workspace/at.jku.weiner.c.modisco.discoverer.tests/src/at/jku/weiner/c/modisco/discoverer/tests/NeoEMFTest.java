package at.jku.weiner.c.modisco.discoverer.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.c.common.common.CommonFactory;
import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.modisco.discoverer.neoemf.NeoEMFDiscoverUtils;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Parser;
import at.jku.weiner.c.parser.parser.ParserFactory;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.PreprocessFactory;

public class NeoEMFTest {
	private static int i = 0;
	private URI uri;
	private Resource res;
	private ResourceSet resSet;

	private CommonFactory commonFactory;
	private PreprocessFactory preprocessFactory;
	private ParserFactory parserFactory;
	
	@Before
	public void setUp() throws Exception {
		final String path = "/tmp/neoemf-" + NeoEMFTest.i;
		NeoEMFTest.i++;
		
		final URI fileUri = URI.createFileURI(path);
		Assert.assertNotNull(fileUri);

		this.resSet = NeoEMFDiscoverUtils.createOrGetResSet();
		Assert.assertNotNull(this.resSet);
		this.uri = NeoEMFDiscoverUtils.createNeo4emfURI(fileUri);
		Assert.assertNotNull(this.uri);
		this.res = NeoEMFDiscoverUtils.createTargetModel(this.uri);
		Assert.assertNotNull(this.res);
		NeoEMFDiscoverUtils.saveTargetModel(this.uri, this.res);

		this.commonFactory = CommonFactory.eINSTANCE;
		this.parserFactory = ParserFactory.eINSTANCE;
		this.preprocessFactory = PreprocessFactory.eINSTANCE;
	}

	@After
	public void tearDown() throws Exception {
		// NeoEMFDiscoverUtils.unloadResSet();
	}

	@Test
	public void test() throws Exception {
		this.createModel("test1");
		NeoEMFDiscoverUtils.saveTargetModel(this.uri, this.res);
		Thread.sleep(500);
	}

	@Test
	public void test2() throws Exception {
		this.createModel("test2");
		NeoEMFDiscoverUtils.saveTargetModel(this.uri, this.res);
		Thread.sleep(500);
	}
	
	private Model createModel(final String testName) {
		final Model model = this.commonFactory.createModel();
		final TranslationUnit unit = this.commonFactory.createTranslationUnit();
		unit.setPath(testName);
		final Parser parser = this.parserFactory.createParser();
		final ExternalDeclaration dec = this.parserFactory
				.createExternalDeclaration();
		parser.getExternal().add(dec);
		unit.setParser(parser);
		final Preprocess preprocess = this.preprocessFactory.createPreprocess();
		unit.setPreprocess(preprocess);

		model.getUnits().add(unit);
		this.res.getContents().add(model);
		return model;
	}
	
}
