package at.jku.weiner.c.preprocess.xtexttests;

import com.google.inject.Inject;
import com.google.inject.Provider;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.antlr.runtime.Token;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import at.jku.weiner.c.preprocess.tests.PreprocessInjectorProvider;
import at.jku.weiner.c.preprocess.parser.antlr.PreprocessParser;
import at.jku.weiner.c.preprocess.parser.antlr.internal.InternalPreprocessLexer;
import at.jku.weiner.c.preprocess.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.preprocess.preprocess.Model;
import at.jku.weiner.c.preprocess.preprocess.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.IncludeDirective;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.IncludeDirective;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.IncludeDirective;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.IncludeDirective;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.IncludeDirective;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0012_MoreIncludes {
	@Inject
	private ParseHelper<Model> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalPreprocessLexer lexer;
	@Inject
	private PreprocessParser parser;
	@Inject
	private ITokenDefProvider tokenDefProvider;
	//@Inject
	private LexerAndParserTest testHelper;
	@Inject
	private IGenerator generator;
	@Inject
	private Provider<ResourceSet> resourceSetProvider;
	@Inject
	private IResourceValidator validator;
	@Inject
	private JavaIoFileSystemAccess fileAccessSystem;
	
	@Before
	public void initialize(){
		this.testHelper = new LexerAndParserTest(lexer, 
			parser, tokenDefProvider);
	}
	
	@After
	public void cleanUp() {
	}
	
	private String getTextFromFile(final String fileName)
	throws Exception{
		final Path path = Paths.get(fileName);
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
	@Test
	public void checkLexerTokens() throws Exception{
		final String text = this.getTextFromFile(
			"res/Test0012_MoreIncludes.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_HASH", 
				"RULE_WS", 
				"RULE_INCLUDE", 
				"RULE_WS", 
				"RULE_STRING_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_LINE_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_LINE_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_WS", 
				"RULE_LINEBREAK", 
				"RULE_WS", 
				"RULE_INCLUDE", 
				"RULE_LINEBREAK", 
				"RULE_WS", 
				"RULE_STRING_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_INCLUDE", 
				"RULE_WS", 
				"RULE_STRING_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_INCLUDE", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_STRING_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_WS", 
				"RULE_INCLUDE", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_STRING_LITERAL", 
				"RULE_NEWLINE", 
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0012_MoreIncludes.c");
		final Model Model_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(Model_0_Var
		);
		
		Assert.assertNotNull(Model_0_Var
		);
		final EList<? extends EObject> Units_0_list = Model_0_Var
		.getUnits();
		Assert.assertNotNull(Units_0_list);
		Assert.assertEquals(1, Units_0_list.size());
		//0
		final TranslationUnit TranslationUnit_1_Var
		 = (TranslationUnit)Units_0_list.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var
		);
		//1
		final GroupOpt GroupOpt_2_Var
		 = (GroupOpt)TranslationUnit_1_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_2_Var
		);
		final EList<? extends EObject> Lines_2_list = GroupOpt_2_Var
		.getLines();
		Assert.assertNotNull(Lines_2_list);
		Assert.assertEquals(12, Lines_2_list.size());
		//2
		final PreprocessorDirectives PreprocessorDirectives_3_Var
		 = (PreprocessorDirectives)Lines_2_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_3_Var
		);
		//3
		final IncludeDirective IncludeDirective_4_Var
		 = (IncludeDirective)PreprocessorDirectives_3_Var
		.getDirective();
		Assert.assertNotNull(IncludeDirective_4_Var
		);
		Assert.assertEquals("\"Test0000_Empty.c\"", IncludeDirective_4_Var
		.getString());
		//4
		final NewLineLine NewLineLine_5_Var
		 = (NewLineLine)Lines_2_list.get(1);
		Assert.assertNotNull(NewLineLine_5_Var
		);
		//5
		final NewLineLine NewLineLine_6_Var
		 = (NewLineLine)Lines_2_list.get(2);
		Assert.assertNotNull(NewLineLine_6_Var
		);
		//6
		final NewLineLine NewLineLine_7_Var
		 = (NewLineLine)Lines_2_list.get(3);
		Assert.assertNotNull(NewLineLine_7_Var
		);
		//7
		final PreprocessorDirectives PreprocessorDirectives_8_Var
		 = (PreprocessorDirectives)Lines_2_list.get(4);
		Assert.assertNotNull(PreprocessorDirectives_8_Var
		);
		//8
		final IncludeDirective IncludeDirective_9_Var
		 = (IncludeDirective)PreprocessorDirectives_8_Var
		.getDirective();
		Assert.assertNotNull(IncludeDirective_9_Var
		);
		Assert.assertEquals("\"Test0000_Empty.c\"", IncludeDirective_9_Var
		.getString());
		//9
		final PreprocessorDirectives PreprocessorDirectives_10_Var
		 = (PreprocessorDirectives)Lines_2_list.get(5);
		Assert.assertNotNull(PreprocessorDirectives_10_Var
		);
		//10
		final IncludeDirective IncludeDirective_11_Var
		 = (IncludeDirective)PreprocessorDirectives_10_Var
		.getDirective();
		Assert.assertNotNull(IncludeDirective_11_Var
		);
		Assert.assertEquals("\"Test0000_Empty.c\"", IncludeDirective_11_Var
		.getString());
		//11
		final NewLineLine NewLineLine_12_Var
		 = (NewLineLine)Lines_2_list.get(6);
		Assert.assertNotNull(NewLineLine_12_Var
		);
		//12
		final NewLineLine NewLineLine_13_Var
		 = (NewLineLine)Lines_2_list.get(7);
		Assert.assertNotNull(NewLineLine_13_Var
		);
		//13
		final NewLineLine NewLineLine_14_Var
		 = (NewLineLine)Lines_2_list.get(8);
		Assert.assertNotNull(NewLineLine_14_Var
		);
		//14
		final PreprocessorDirectives PreprocessorDirectives_15_Var
		 = (PreprocessorDirectives)Lines_2_list.get(9);
		Assert.assertNotNull(PreprocessorDirectives_15_Var
		);
		//15
		final IncludeDirective IncludeDirective_16_Var
		 = (IncludeDirective)PreprocessorDirectives_15_Var
		.getDirective();
		Assert.assertNotNull(IncludeDirective_16_Var
		);
		Assert.assertEquals("\"Test0000_Empty.c\"", IncludeDirective_16_Var
		.getString());
		//16
		final NewLineLine NewLineLine_17_Var
		 = (NewLineLine)Lines_2_list.get(10);
		Assert.assertNotNull(NewLineLine_17_Var
		);
		//17
		final PreprocessorDirectives PreprocessorDirectives_18_Var
		 = (PreprocessorDirectives)Lines_2_list.get(11);
		Assert.assertNotNull(PreprocessorDirectives_18_Var
		);
		//18
		final IncludeDirective IncludeDirective_19_Var
		 = (IncludeDirective)PreprocessorDirectives_18_Var
		.getDirective();
		Assert.assertNotNull(IncludeDirective_19_Var
		);
		Assert.assertEquals("\"Test0002_Code.c\"", IncludeDirective_19_Var
		.getString());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0012_MoreIncludes.c");
		Resource resource = set.getResource(uri, true);
		// validate the resource
		List<Issue> list = this.validator.validate(resource, 
			CheckMode.ALL,CancelIndicator.NullImpl);
		Assert.assertTrue(list.isEmpty());
		
		// configure and start the generator
		this.fileAccessSystem.setOutputPath("bin");
		final Class<?> clazz = this.generator.getClass();
		try {
			final Method method = clazz.getMethod("setFileName",
					String.class);
			if (method != null) {
				method.invoke(this.generator, "Test0012_MoreIncludes.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0012_MoreIncludes.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0012_MoreIncludes.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
		// System.out.println("Code generation finished.");
	}
	
	private String preprocess(String string) throws Exception {
		string = preprocessForPatterns(string);
		return string;
	}
	
	
	private String preprocessForPatterns(String string) {
		return string;
	}
	
}


