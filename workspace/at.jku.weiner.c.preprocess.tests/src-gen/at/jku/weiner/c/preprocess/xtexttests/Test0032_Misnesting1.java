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
import at.jku.weiner.c.preprocess.tests.CPreprocessInjectorProvider;
import at.jku.weiner.c.preprocess.parser.antlr.CPreprocessParser;
import at.jku.weiner.c.preprocess.parser.antlr.lexer.InternalCPreprocessLexer;
import at.jku.weiner.c.preprocess.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.preprocess.cPreprocess.Model;
import at.jku.weiner.c.preprocess.cPreprocess.TranslationUnit;
import at.jku.weiner.c.preprocess.cPreprocess.GroupOpt;
import at.jku.weiner.c.preprocess.cPreprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.cPreprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.cPreprocess.IdentifierList;
import at.jku.weiner.c.preprocess.cPreprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.cPreprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.cPreprocess.IdentifierList;
import at.jku.weiner.c.preprocess.cPreprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CPreprocessInjectorProvider.class)
public class Test0032_Misnesting1 {
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
			"res/Test0032_Misnesting1.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WS", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_PLUS", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_NEWLINE", 
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0032_Misnesting1.c");
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
		Assert.assertEquals(3, Lines_2_list.size());
		//2
		final PreprocessorDirectives PreprocessorDirectives_3_Var
		 = (PreprocessorDirectives)Lines_2_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_3_Var
		);
		//3
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_4_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_3_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_4_Var
		);
		Assert.assertEquals("FOO", DefineFunctionLikeMacro_4_Var
		.getId());
		//4
		final IdentifierList IdentifierList_5_Var
		 = (IdentifierList)DefineFunctionLikeMacro_4_Var
		.getList();
		Assert.assertNotNull(IdentifierList_5_Var
		);
		Assert.assertEquals("[x]", IdentifierList_5_Var
		.getId().toString());
		Assert.assertEquals("(3+(x))", DefineFunctionLikeMacro_4_Var
		.getString());
		//5
		final PreprocessorDirectives PreprocessorDirectives_6_Var
		 = (PreprocessorDirectives)Lines_2_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_6_Var
		);
		//6
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_7_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_6_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_7_Var
		);
		Assert.assertEquals("BAR", DefineFunctionLikeMacro_7_Var
		.getId());
		//7
		final IdentifierList IdentifierList_8_Var
		 = (IdentifierList)DefineFunctionLikeMacro_7_Var
		.getList();
		Assert.assertNotNull(IdentifierList_8_Var
		);
		Assert.assertEquals("[x]", IdentifierList_8_Var
		.getId().toString());
		Assert.assertEquals("x(1)", DefineFunctionLikeMacro_7_Var
		.getString());
		//8
		final Code Code_9_Var
		 = (Code)Lines_2_list.get(2);
		Assert.assertNotNull(Code_9_Var
		);
		Assert.assertEquals("BAR (FOO)", Code_9_Var
		.getCode());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0032_Misnesting1.c");
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
				method.invoke(this.generator, "Test0032_Misnesting1.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0032_Misnesting1.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0032_Misnesting1.c"
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


