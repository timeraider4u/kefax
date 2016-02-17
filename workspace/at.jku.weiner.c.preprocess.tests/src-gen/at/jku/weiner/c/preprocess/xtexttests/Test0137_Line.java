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
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import at.jku.weiner.c.preprocess.tests.PreprocessInjectorProvider;
import at.jku.weiner.c.preprocess.parser.antlr.PreprocessParser;
import at.jku.weiner.c.preprocess.parser.antlr.internal.InternalPreprocessLexer;
import at.jku.weiner.c.preprocess.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.LineDirective;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.LineDirective;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.LineDirective;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.LineDirective;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0137_Line {
	@Inject
	private ParseHelper<Preprocess> parseHelper;
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
	@Inject
	private IResourceFactory resourceFactory;
	
	@Before
	public void initialize(){
		this.testHelper = new LexerAndParserTest(lexer, 
			parser, tokenDefProvider);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("c",
						this.resourceFactory);
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
	
	@Test (timeout=1000)
	public void checkLexerTokens() throws Exception{
		final String text = this.getTextFromFile(
			"res/Test0137_Line.c");
			final String[] expected = new String[] {
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_STAR",
				"RULE_SKW_STAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_WHITESPACE",
				"RULE_LINE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_STAR",
				"RULE_SKW_STAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_WHITESPACE",
				"RULE_LINE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_STAR",
				"RULE_SKW_STAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_DEFINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_LINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_STAR",
				"RULE_SKW_STAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_LINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_STAR",
				"RULE_SKW_STAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0137_Line.c");
		final Preprocess Preprocess_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(Preprocess_0_Var
		);
		
		Assert.assertNotNull(Preprocess_0_Var
		);
		//0
		final GroupOpt GroupOpt_1_Var
		 = (GroupOpt)Preprocess_0_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_1_Var
		);
		final EList<? extends EObject> Lines_1_list = GroupOpt_1_Var
		.getLines();
		Assert.assertNotNull(Lines_1_list);
		Assert.assertEquals(20, Lines_1_list.size());
		//1
		final Code Code_2_Var
		 = (Code)Lines_1_list.get(0);
		Assert.assertNotNull(Code_2_Var
		);
		Assert.assertEquals("int line0 = __LINE__;", Code_2_Var
		.getCode());
		//2
		final Code Code_3_Var
		 = (Code)Lines_1_list.get(1);
		Assert.assertNotNull(Code_3_Var
		);
		Assert.assertEquals("char ** file0 = __FILE__;", Code_3_Var
		.getCode());
		//3
		final NewLineLine NewLineLine_4_Var
		 = (NewLineLine)Lines_1_list.get(2);
		Assert.assertNotNull(NewLineLine_4_Var
		);
		//4
		final PreprocessorDirectives PreprocessorDirectives_5_Var
		 = (PreprocessorDirectives)Lines_1_list.get(3);
		Assert.assertNotNull(PreprocessorDirectives_5_Var
		);
		//5
		final LineDirective LineDirective_6_Var
		 = (LineDirective)PreprocessorDirectives_5_Var
		.getDirective();
		Assert.assertNotNull(LineDirective_6_Var
		);
		Assert.assertEquals("5", LineDirective_6_Var
		.getLine());
		Assert.assertNull(LineDirective_6_Var
		.getPath());
		//6
		final Code Code_7_Var
		 = (Code)Lines_1_list.get(4);
		Assert.assertNotNull(Code_7_Var
		);
		Assert.assertEquals("int line1 = __LINE__;", Code_7_Var
		.getCode());
		//7
		final Code Code_8_Var
		 = (Code)Lines_1_list.get(5);
		Assert.assertNotNull(Code_8_Var
		);
		Assert.assertEquals("char ** file1 = __FILE__;", Code_8_Var
		.getCode());
		//8
		final NewLineLine NewLineLine_9_Var
		 = (NewLineLine)Lines_1_list.get(6);
		Assert.assertNotNull(NewLineLine_9_Var
		);
		//9
		final PreprocessorDirectives PreprocessorDirectives_10_Var
		 = (PreprocessorDirectives)Lines_1_list.get(7);
		Assert.assertNotNull(PreprocessorDirectives_10_Var
		);
		//10
		final LineDirective LineDirective_11_Var
		 = (LineDirective)PreprocessorDirectives_10_Var
		.getDirective();
		Assert.assertNotNull(LineDirective_11_Var
		);
		Assert.assertEquals("25", LineDirective_11_Var
		.getLine());
		Assert.assertEquals("\"MyTest0137_Line.c_file\"", LineDirective_11_Var
		.getPath());
		//11
		final Code Code_12_Var
		 = (Code)Lines_1_list.get(8);
		Assert.assertNotNull(Code_12_Var
		);
		Assert.assertEquals("int line2 = __LINE__;", Code_12_Var
		.getCode());
		//12
		final Code Code_13_Var
		 = (Code)Lines_1_list.get(9);
		Assert.assertNotNull(Code_13_Var
		);
		Assert.assertEquals("char ** file2 = __FILE__;", Code_13_Var
		.getCode());
		//13
		final NewLineLine NewLineLine_14_Var
		 = (NewLineLine)Lines_1_list.get(10);
		Assert.assertNotNull(NewLineLine_14_Var
		);
		//14
		final PreprocessorDirectives PreprocessorDirectives_15_Var
		 = (PreprocessorDirectives)Lines_1_list.get(11);
		Assert.assertNotNull(PreprocessorDirectives_15_Var
		);
		//15
		final DefineObjectMacro DefineObjectMacro_16_Var
		 = (DefineObjectMacro)PreprocessorDirectives_15_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_16_Var
		);
		Assert.assertEquals("FOO", DefineObjectMacro_16_Var
		.getId());
		Assert.assertEquals("100", DefineObjectMacro_16_Var
		.getString());
		//16
		final PreprocessorDirectives PreprocessorDirectives_17_Var
		 = (PreprocessorDirectives)Lines_1_list.get(12);
		Assert.assertNotNull(PreprocessorDirectives_17_Var
		);
		//17
		final LineDirective LineDirective_18_Var
		 = (LineDirective)PreprocessorDirectives_17_Var
		.getDirective();
		Assert.assertNotNull(LineDirective_18_Var
		);
		Assert.assertEquals("FOO", LineDirective_18_Var
		.getLine());
		Assert.assertNull(LineDirective_18_Var
		.getPath());
		//18
		final Code Code_19_Var
		 = (Code)Lines_1_list.get(13);
		Assert.assertNotNull(Code_19_Var
		);
		Assert.assertEquals("int line3 = __LINE__;", Code_19_Var
		.getCode());
		//19
		final Code Code_20_Var
		 = (Code)Lines_1_list.get(14);
		Assert.assertNotNull(Code_20_Var
		);
		Assert.assertEquals("char ** file3 = __FILE__;", Code_20_Var
		.getCode());
		//20
		final NewLineLine NewLineLine_21_Var
		 = (NewLineLine)Lines_1_list.get(15);
		Assert.assertNotNull(NewLineLine_21_Var
		);
		//21
		final PreprocessorDirectives PreprocessorDirectives_22_Var
		 = (PreprocessorDirectives)Lines_1_list.get(16);
		Assert.assertNotNull(PreprocessorDirectives_22_Var
		);
		//22
		final LineDirective LineDirective_23_Var
		 = (LineDirective)PreprocessorDirectives_22_Var
		.getDirective();
		Assert.assertNotNull(LineDirective_23_Var
		);
		Assert.assertEquals("FOO", LineDirective_23_Var
		.getLine());
		Assert.assertEquals("\"MyTest0137_Line.c_file_2\"", LineDirective_23_Var
		.getPath());
		//23
		final Code Code_24_Var
		 = (Code)Lines_1_list.get(17);
		Assert.assertNotNull(Code_24_Var
		);
		Assert.assertEquals("int line4 = __LINE__;", Code_24_Var
		.getCode());
		//24
		final Code Code_25_Var
		 = (Code)Lines_1_list.get(18);
		Assert.assertNotNull(Code_25_Var
		);
		Assert.assertEquals("char ** file4 = __FILE__;", Code_25_Var
		.getCode());
		//25
		final NewLineLine NewLineLine_26_Var
		 = (NewLineLine)Lines_1_list.get(19);
		Assert.assertNotNull(NewLineLine_26_Var
		);
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0137_Line.c");
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
				method.invoke(this.generator, "Test0137_Line.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0137_Line.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0137_Line.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
	}
	
	private String preprocess(String string) throws Exception {
		string = preprocessForPatterns(string);
		return string;
	}
	
	
	private String preprocessForPatterns(String string) {
		return string;
	}
	
}


