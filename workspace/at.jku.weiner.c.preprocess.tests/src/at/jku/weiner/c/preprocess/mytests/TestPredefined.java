package at.jku.weiner.c.preprocess.mytests;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import at.jku.weiner.c.common.common.CommonFactory;
import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.generator.PreprocessGenerator;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.tests.PreprocessInjectorProvider;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;
import at.jku.weiner.c.preprocess.utils.macros.PredefinedMacros;

import com.google.inject.Inject;
import com.google.inject.Provider;

@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class TestPredefined {
	@Inject
	private ParseHelper<Preprocess> parseHelper;
	@Inject
	private PreprocessGenerator generator;
	@Inject
	private Provider<ResourceSet> resourceSetProvider;
	@Inject
	private IResourceValidator validator;
	@Inject
	private JavaIoFileSystemAccess fileAccessSystem;
	@Inject
	private IResourceFactory resourceFactory;
	@Inject
	private ValidationTestHelper valHelper;
	
	@Test(timeout = 1000)
	public void loadPredefined() throws Exception {
		// load the resource
		final ResourceSet set = this.resourceSetProvider.get();
		final URI uri = URI.createURI("res/predefined/gcc_4.8.4.h");
		final Resource resource = set.getResource(uri, true);
		// validate the resource
		final List<Issue> list = this.validator.validate(resource,
				CheckMode.ALL, CancelIndicator.NullImpl);
		Assert.assertTrue(list.isEmpty());
		// parse helper
		final String text = this.getTextFromFile("res/predefined/gcc_4.8.4.h");
		final Preprocess preprocess = this.parseHelper.parse(text);

		this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(preprocess);
		Assert.assertNotNull(preprocess);
	}
	
	@Test(timeout = 1000)
	public void testGenerator() throws Exception {
		// load the resource
		final ResourceSet set = this.resourceSetProvider.get();
		final URI uri = URI.createURI("res/Test0000_Empty.c");
		final Resource resource = set.getResource(uri, true);
		// validate the resource
		final List<Issue> list = this.validator.validate(resource,
				CheckMode.ALL, CancelIndicator.NullImpl);
		Assert.assertTrue(list.isEmpty());

		// configure and start the generator
		this.fileAccessSystem.setOutputPath("bin");
		this.generator.setFileName("Test0000_Empty.c.i");
		this.generator.setInsertPredefinedMacros(true);
		this.generator.setValidateUnit(true);
		// create predefined macros translation unit
		final Model model = CommonFactory.eINSTANCE.createModel();
		final TranslationUnit unitPredefined = CommonFactory.eINSTANCE
				.createTranslationUnit();
		final Preprocess predefined = PredefinedMacros
				.loadPreDefinedMacros(true);
		Assert.assertNotNull(predefined);
		Assert.assertNotNull(predefined.getGroup());

		unitPredefined.setPreprocess(predefined);
		model.getUnits().add(unitPredefined);
		Assert.assertNotNull(predefined);
		Assert.assertNotNull(predefined.getGroup());
		final TranslationUnit unitNew = CommonFactory.eINSTANCE
				.createTranslationUnit();
		unitNew.setPath("res/Test0000_Empty.c");
		this.generator.setUnit(unitNew);
		// execute generation
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0000_Empty.c.i");
		final String expected = this
				.getTextFromFile("expected/Test0000_Empty.c");
		Assert.assertEquals(this.preprocess(expected), this.preprocess(actual));
		// System.out.println("Code generation finished.");
		Assert.assertTrue(DefinitionTable.size() > 0);
		Assert.assertTrue(DefinitionTable.containsAKey("__STDC__"));
	}

	@Before
	public void initialize() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("c",
				this.resourceFactory);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("h",
				this.resourceFactory);
		DefinitionTable.reset();
	}

	@After
	public void cleanUp() {
		DefinitionTable.reset();
	}

	private String getTextFromFile(final String fileName) throws Exception {
		final Path path = Paths.get(fileName);
		final String content = new String(Files.readAllBytes(path));
		return content;
	}

	private String preprocess(String string) throws Exception {
		string = this.preprocessForPatterns(string);
		return string;
	}
	
	private String preprocessForPatterns(final String string) {
		return string;
	}

}
