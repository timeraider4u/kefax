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
import at.jku.weiner.cpreprocess.cPreprocess.GroupOpt;
import at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives;
import at.jku.weiner.cpreprocess.cPreprocess.DefineFunctionLikeMacro;
import at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives;
import at.jku.weiner.cpreprocess.cPreprocess.DefineFunctionLikeMacro;
import at.jku.weiner.cpreprocess.cPreprocess.IdentifierList;
import at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives;
import at.jku.weiner.cpreprocess.cPreprocess.DefineFunctionLikeMacro;
import at.jku.weiner.cpreprocess.cPreprocess.IdentifierList;
import at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives;
import at.jku.weiner.cpreprocess.cPreprocess.DefineFunctionLikeMacro;
import at.jku.weiner.cpreprocess.cPreprocess.IdentifierList;
import at.jku.weiner.cpreprocess.cPreprocess.NewLineLine;
import at.jku.weiner.cpreprocess.cPreprocess.Code;
import at.jku.weiner.cpreprocess.cPreprocess.Code;
import at.jku.weiner.cpreprocess.cPreprocess.Code;
import at.jku.weiner.cpreprocess.cPreprocess.Code;
import at.jku.weiner.cpreprocess.cPreprocess.Code;
import at.jku.weiner.cpreprocess.cPreprocess.Code;
import at.jku.weiner.cpreprocess.cPreprocess.Code;
import at.jku.weiner.cpreprocess.cPreprocess.Code;
import at.jku.weiner.cpreprocess.cPreprocess.Code;
import at.jku.weiner.cpreprocess.cPreprocess.Code;
import at.jku.weiner.cpreprocess.cPreprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CPreprocessInjectorProvider.class)
public class Test0027_FunctionMacroMultipleArguments {
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
			"res/Test0027_FunctionMacroMultipleArguments.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_LPAREN", 
				"RULE_WS", 
				"RULE_RPAREN", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_LPAREN", 
				"RULE_ID", 
				"RULE_RPAREN", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_ID", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_LPAREN", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_RPAREN", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_LPAREN", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_ID", 
				"RULE_RPAREN", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_LPAREN", 
				"RULE_WS", 
				"RULE_RPAREN", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_LPAREN", 
				"RULE_ID", 
				"RULE_RPAREN", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_LPAREN", 
				"RULE_SPECIAL", 
				"RULE_COMMA", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_RPAREN", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_LPAREN", 
				"RULE_LPAREN", 
				"RULE_LPAREN", 
				"RULE_ID", 
				"RULE_RPAREN", 
				"RULE_RPAREN", 
				"RULE_RPAREN", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_LPAREN", 
				"RULE_LPAREN", 
				"RULE_SPECIAL", 
				"RULE_RPAREN", 
				"RULE_WS", 
				"RULE_COMMA", 
				"RULE_WS", 
				"RULE_LPAREN", 
				"RULE_ID", 
				"RULE_RPAREN", 
				"RULE_RPAREN", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_LPAREN", 
				"RULE_SPECIAL", 
				"RULE_COMMA", 
				"RULE_ID", 
				"RULE_RPAREN", 
				"RULE_WS", 
				"RULE_LPAREN", 
				"RULE_SPECIAL", 
				"RULE_WS", 
				"RULE_LPAREN", 
				"RULE_SPECIAL", 
				"RULE_RPAREN", 
				"RULE_RPAREN", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_LPAREN", 
				"RULE_SPECIAL", 
				"RULE_RPAREN", 
				"RULE_LPAREN", 
				"RULE_SPECIAL", 
				"RULE_RPAREN", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_LPAREN", 
				"RULE_WS", 
				"RULE_LPAREN", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_LPAREN", 
				"RULE_ID", 
				"RULE_RPAREN", 
				"RULE_RPAREN", 
				"RULE_RPAREN", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_LPAREN", 
				"RULE_WS", 
				"RULE_LPAREN", 
				"RULE_SPECIAL", 
				"RULE_COMMA", 
				"RULE_ID", 
				"RULE_RPAREN", 
				"RULE_COMMA", 
				"RULE_ID", 
				"RULE_RPAREN", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_LPAREN", 
				"RULE_SPECIAL", 
				"RULE_COMMA", 
				"RULE_WS", 
				"RULE_LPAREN", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_ID", 
				"RULE_RPAREN", 
				"RULE_RPAREN", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_LPAREN", 
				"RULE_SPECIAL", 
				"RULE_COMMA", 
				"RULE_LPAREN", 
				"RULE_SPECIAL", 
				"RULE_RPAREN", 
				"RULE_COMMA", 
				"RULE_LPAREN", 
				"RULE_SPECIAL", 
				"RULE_COMMA", 
				"RULE_SPECIAL", 
				"RULE_RPAREN", 
				"RULE_RPAREN", 
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
			"res/Test0027_FunctionMacroMultipleArguments.c");
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
		Assert.assertEquals(16, Lines_2_list.size());
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
		Assert.assertEquals("foo", DefineFunctionLikeMacro_4_Var
		.getId());
		Assert.assertNull(DefineFunctionLikeMacro_4_Var
		.getList());
		Assert.assertEquals("foo_bar", DefineFunctionLikeMacro_4_Var
		.getString());
		//4
		final PreprocessorDirectives PreprocessorDirectives_5_Var
		 = (PreprocessorDirectives)Lines_2_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_5_Var
		);
		//5
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_6_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_5_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_6_Var
		);
		Assert.assertEquals("foo", DefineFunctionLikeMacro_6_Var
		.getId());
		//6
		final IdentifierList IdentifierList_7_Var
		 = (IdentifierList)DefineFunctionLikeMacro_6_Var
		.getList();
		Assert.assertNotNull(IdentifierList_7_Var
		);
		Assert.assertEquals("[X]", IdentifierList_7_Var
		.getId().toString());
		Assert.assertEquals("{X}", DefineFunctionLikeMacro_6_Var
		.getString());
		//7
		final PreprocessorDirectives PreprocessorDirectives_8_Var
		 = (PreprocessorDirectives)Lines_2_list.get(2);
		Assert.assertNotNull(PreprocessorDirectives_8_Var
		);
		//8
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_9_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_8_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_9_Var
		);
		Assert.assertEquals("foo", DefineFunctionLikeMacro_9_Var
		.getId());
		//9
		final IdentifierList IdentifierList_10_Var
		 = (IdentifierList)DefineFunctionLikeMacro_9_Var
		.getList();
		Assert.assertNotNull(IdentifierList_10_Var
		);
		Assert.assertEquals("[X, Y]", IdentifierList_10_Var
		.getId().toString());
		Assert.assertEquals("X + Y", DefineFunctionLikeMacro_9_Var
		.getString());
		//10
		final PreprocessorDirectives PreprocessorDirectives_11_Var
		 = (PreprocessorDirectives)Lines_2_list.get(3);
		Assert.assertNotNull(PreprocessorDirectives_11_Var
		);
		//11
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_12_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_11_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_12_Var
		);
		Assert.assertEquals("foo", DefineFunctionLikeMacro_12_Var
		.getId());
		//12
		final IdentifierList IdentifierList_13_Var
		 = (IdentifierList)DefineFunctionLikeMacro_12_Var
		.getList();
		Assert.assertNotNull(IdentifierList_13_Var
		);
		Assert.assertEquals("[X, Y, Z]", IdentifierList_13_Var
		.getId().toString());
		Assert.assertEquals("X * Y - Z", DefineFunctionLikeMacro_12_Var
		.getString());
		//13
		final NewLineLine NewLineLine_14_Var
		 = (NewLineLine)Lines_2_list.get(4);
		Assert.assertNotNull(NewLineLine_14_Var
		);
		//14
		final Code Code_15_Var
		 = (Code)Lines_2_list.get(5);
		Assert.assertNotNull(Code_15_Var
		);
		Assert.assertEquals("int z = foo ( );", Code_15_Var
		.getCode());
		//15
		final Code Code_16_Var
		 = (Code)Lines_2_list.get(6);
		Assert.assertNotNull(Code_16_Var
		);
		Assert.assertEquals("int a = foo(bar);", Code_16_Var
		.getCode());
		//16
		final Code Code_17_Var
		 = (Code)Lines_2_list.get(7);
		Assert.assertNotNull(Code_17_Var
		);
		Assert.assertEquals("int b = foo(0,bar );", Code_17_Var
		.getCode());
		//17
		final Code Code_18_Var
		 = (Code)Lines_2_list.get(8);
		Assert.assertNotNull(Code_18_Var
		);
		Assert.assertEquals("int c = foo (((bar)));", Code_18_Var
		.getCode());
		//18
		final Code Code_19_Var
		 = (Code)Lines_2_list.get(9);
		Assert.assertNotNull(Code_19_Var
		);
		Assert.assertEquals("int d = foo((0) , (bar));", Code_19_Var
		.getCode());
		//19
		final Code Code_20_Var
		 = (Code)Lines_2_list.get(10);
		Assert.assertNotNull(Code_20_Var
		);
		Assert.assertEquals("int e = foo(0,bar) (* (1));", Code_20_Var
		.getCode());
		//20
		final Code Code_21_Var
		 = (Code)Lines_2_list.get(11);
		Assert.assertNotNull(Code_21_Var
		);
		Assert.assertEquals("int f = foo(0)(1);", Code_21_Var
		.getCode());
		//21
		final Code Code_22_Var
		 = (Code)Lines_2_list.get(12);
		Assert.assertNotNull(Code_22_Var
		);
		Assert.assertEquals("int g = foo( (a,(b)));", Code_22_Var
		.getCode());
		//22
		final Code Code_23_Var
		 = (Code)Lines_2_list.get(13);
		Assert.assertNotNull(Code_23_Var
		);
		Assert.assertEquals("int h = foo( (0,b),bar);", Code_23_Var
		.getCode());
		//23
		final Code Code_24_Var
		 = (Code)Lines_2_list.get(14);
		Assert.assertNotNull(Code_24_Var
		);
		Assert.assertEquals("int i = foo(1, (bar,b));", Code_24_Var
		.getCode());
		//24
		final Code Code_25_Var
		 = (Code)Lines_2_list.get(15);
		Assert.assertNotNull(Code_25_Var
		);
		Assert.assertEquals("int j = foo(1,(1),(1,1));", Code_25_Var
		.getCode());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0027_FunctionMacroMultipleArguments.c");
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
				method.invoke(this.generator, "Test0027_FunctionMacroMultipleArguments.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0027_FunctionMacroMultipleArguments.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0027_FunctionMacroMultipleArguments.c"
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


