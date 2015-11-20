package at.jku.weiner.cpreprocess.xtexttests;

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
import at.jku.weiner.cpreprocess.tests.CPreprocessInjectorProvider;
import at.jku.weiner.cpreprocess.parser.antlr.CPreprocessParser;
import at.jku.weiner.cpreprocess.parser.antlr.lexer.InternalCPreprocessLexer;
import at.jku.weiner.cpreprocess.xtexttests.LexerAndParserTest;

import at.jku.weiner.cpreprocess.cPreprocess.Model;
import at.jku.weiner.cpreprocess.cPreprocess.TranslationUnit;
import at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives;
import at.jku.weiner.cpreprocess.cPreprocess.IncludeDirective;
import at.jku.weiner.cpreprocess.cPreprocess.NewLineLine;
import at.jku.weiner.cpreprocess.cPreprocess.Code;
import at.jku.weiner.cpreprocess.cPreprocess.Code;
import at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives;
import at.jku.weiner.cpreprocess.cPreprocess.IncludeDirective;
import at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives;
import at.jku.weiner.cpreprocess.cPreprocess.IncludeDirective;
import at.jku.weiner.cpreprocess.cPreprocess.NewLineLine;
import at.jku.weiner.cpreprocess.cPreprocess.Code;
import at.jku.weiner.cpreprocess.cPreprocess.NewLineLine;
import at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives;
import at.jku.weiner.cpreprocess.cPreprocess.IncludeDirective;
import at.jku.weiner.cpreprocess.cPreprocess.NewLineLine;
import at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives;
import at.jku.weiner.cpreprocess.cPreprocess.IncludeDirective;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CPreprocessInjectorProvider.class)
public class Test0012_MoreIncludes {
	@Inject
	private ParseHelper<Model> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalCPreprocessLexer lexer;
	@Inject
	private CPreprocessParser parser;
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
				"RULE_SPECIAL", 
				"RULE_ID", 
				"RULE_SPECIAL", 
				"RULE_ID", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_SPECIAL", 
				"RULE_SPECIAL", 
				"RULE_WS", 
				"RULE_INCLUDE", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_ID", 
				"RULE_SPECIAL", 
				"RULE_ID", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_SPECIAL", 
				"RULE_SPECIAL", 
				"RULE_WS", 
				"RULE_HASH", 
				"RULE_INCLUDE", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_ID", 
				"RULE_SPECIAL", 
				"RULE_ID", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_INCLUDE", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_ID", 
				"RULE_SPECIAL", 
				"RULE_ID", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_INCLUDE", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_ID", 
				"RULE_SPECIAL", 
				"RULE_ID", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_SPECIAL", 
				"RULE_SPECIAL", 
				"RULE_HASH", 
				"RULE_INCLUDE", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_ID", 
				"RULE_SPECIAL", 
				"RULE_ID", 
				"RULE_SPECIAL", 
				"RULE_SPECIAL", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_INCLUDE", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_ID", 
				"RULE_SPECIAL", 
				"RULE_ID", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_WS", 
				"RULE_INCLUDE", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_ID", 
				"RULE_SPECIAL", 
				"RULE_ID", 
				"RULE_SPECIAL", 
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
		final EList<? extends EObject> Lines_1_list = TranslationUnit_1_Var
		.getLines();
		Assert.assertNotNull(Lines_1_list);
		Assert.assertEquals(12, Lines_1_list.size());
		//1
		final PreprocessorDirectives PreprocessorDirectives_2_Var
		 = (PreprocessorDirectives)Lines_1_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_2_Var
		);
		//2
		final IncludeDirective IncludeDirective_3_Var
		 = (IncludeDirective)PreprocessorDirectives_2_Var
		.getDirective();
		Assert.assertNotNull(IncludeDirective_3_Var
		);
		Assert.assertEquals("\"Test0000_Empty.c\"", IncludeDirective_3_Var
		.getString());
		//3
		final NewLineLine NewLineLine_4_Var
		 = (NewLineLine)Lines_1_list.get(1);
		Assert.assertNotNull(NewLineLine_4_Var
		);
		//4
		final Code Code_5_Var
		 = (Code)Lines_1_list.get(2);
		Assert.assertNotNull(Code_5_Var
		);
		Assert.assertEquals("// include \"Test0000_Empty.c\"", Code_5_Var
		.getCode());
		//5
		final Code Code_6_Var
		 = (Code)Lines_1_list.get(3);
		Assert.assertNotNull(Code_6_Var
		);
		Assert.assertEquals("// #include \"Test0000_Empty.c\"", Code_6_Var
		.getCode());
		//6
		final PreprocessorDirectives PreprocessorDirectives_7_Var
		 = (PreprocessorDirectives)Lines_1_list.get(4);
		Assert.assertNotNull(PreprocessorDirectives_7_Var
		);
		//7
		final IncludeDirective IncludeDirective_8_Var
		 = (IncludeDirective)PreprocessorDirectives_7_Var
		.getDirective();
		Assert.assertNotNull(IncludeDirective_8_Var
		);
		Assert.assertEquals("\"Test0000_Empty.c\"", IncludeDirective_8_Var
		.getString());
		//8
		final PreprocessorDirectives PreprocessorDirectives_9_Var
		 = (PreprocessorDirectives)Lines_1_list.get(5);
		Assert.assertNotNull(PreprocessorDirectives_9_Var
		);
		//9
		final IncludeDirective IncludeDirective_10_Var
		 = (IncludeDirective)PreprocessorDirectives_9_Var
		.getDirective();
		Assert.assertNotNull(IncludeDirective_10_Var
		);
		Assert.assertEquals("\"Test0000_Empty.c\"", IncludeDirective_10_Var
		.getString());
		//10
		final NewLineLine NewLineLine_11_Var
		 = (NewLineLine)Lines_1_list.get(6);
		Assert.assertNotNull(NewLineLine_11_Var
		);
		//11
		final Code Code_12_Var
		 = (Code)Lines_1_list.get(7);
		Assert.assertNotNull(Code_12_Var
		);
		Assert.assertEquals("/*#include \"Test0000_Empty.c\"*/", Code_12_Var
		.getCode());
		//12
		final NewLineLine NewLineLine_13_Var
		 = (NewLineLine)Lines_1_list.get(8);
		Assert.assertNotNull(NewLineLine_13_Var
		);
		//13
		final PreprocessorDirectives PreprocessorDirectives_14_Var
		 = (PreprocessorDirectives)Lines_1_list.get(9);
		Assert.assertNotNull(PreprocessorDirectives_14_Var
		);
		//14
		final IncludeDirective IncludeDirective_15_Var
		 = (IncludeDirective)PreprocessorDirectives_14_Var
		.getDirective();
		Assert.assertNotNull(IncludeDirective_15_Var
		);
		Assert.assertEquals("\"Test0000_Empty.c\"", IncludeDirective_15_Var
		.getString());
		//15
		final NewLineLine NewLineLine_16_Var
		 = (NewLineLine)Lines_1_list.get(10);
		Assert.assertNotNull(NewLineLine_16_Var
		);
		//16
		final PreprocessorDirectives PreprocessorDirectives_17_Var
		 = (PreprocessorDirectives)Lines_1_list.get(11);
		Assert.assertNotNull(PreprocessorDirectives_17_Var
		);
		//17
		final IncludeDirective IncludeDirective_18_Var
		 = (IncludeDirective)PreprocessorDirectives_17_Var
		.getDirective();
		Assert.assertNotNull(IncludeDirective_18_Var
		);
		Assert.assertEquals("\"Test0002_Code.c\"", IncludeDirective_18_Var
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


