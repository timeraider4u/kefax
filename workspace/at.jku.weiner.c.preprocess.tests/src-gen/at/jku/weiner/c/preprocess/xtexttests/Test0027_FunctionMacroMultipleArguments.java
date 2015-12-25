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

import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.UnDefineDirective;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0027_FunctionMacroMultipleArguments {
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
	
	@Test
	public void checkLexerTokens() throws Exception{
		final String text = this.getTextFromFile(
			"res/Test0027_FunctionMacroMultipleArguments.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_ID", 
				"RULE_SKW_RIGHTBRACE", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_PLUS", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_STAR", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_MINUS", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_UNDEF", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_STAR", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_COMMA", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_COMMA", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_PLUS", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_MINUS", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_STAR", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
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
		final Preprocess Preprocess_2_Var
		 = (Preprocess)TranslationUnit_1_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_2_Var
		);
		//2
		final GroupOpt GroupOpt_3_Var
		 = (GroupOpt)Preprocess_2_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_3_Var
		);
		final EList<? extends EObject> Lines_3_list = GroupOpt_3_Var
		.getLines();
		Assert.assertNotNull(Lines_3_list);
		Assert.assertEquals(19, Lines_3_list.size());
		//3
		final PreprocessorDirectives PreprocessorDirectives_4_Var
		 = (PreprocessorDirectives)Lines_3_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_4_Var
		);
		//4
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_5_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_4_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_5_Var
		);
		Assert.assertEquals("foo0", DefineFunctionLikeMacro_5_Var
		.getId());
		Assert.assertNull(DefineFunctionLikeMacro_5_Var
		.getList());
		Assert.assertEquals("bar_foo", DefineFunctionLikeMacro_5_Var
		.getString());
		//5
		final PreprocessorDirectives PreprocessorDirectives_6_Var
		 = (PreprocessorDirectives)Lines_3_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_6_Var
		);
		//6
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_7_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_6_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_7_Var
		);
		Assert.assertEquals("foo1", DefineFunctionLikeMacro_7_Var
		.getId());
		//7
		final IdentifierList IdentifierList_8_Var
		 = (IdentifierList)DefineFunctionLikeMacro_7_Var
		.getList();
		Assert.assertNotNull(IdentifierList_8_Var
		);
		Assert.assertEquals("[X]", IdentifierList_8_Var
		.getId().toString());
		Assert.assertEquals("{X}", DefineFunctionLikeMacro_7_Var
		.getString());
		//8
		final PreprocessorDirectives PreprocessorDirectives_9_Var
		 = (PreprocessorDirectives)Lines_3_list.get(2);
		Assert.assertNotNull(PreprocessorDirectives_9_Var
		);
		//9
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_10_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_9_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_10_Var
		);
		Assert.assertEquals("foo2", DefineFunctionLikeMacro_10_Var
		.getId());
		//10
		final IdentifierList IdentifierList_11_Var
		 = (IdentifierList)DefineFunctionLikeMacro_10_Var
		.getList();
		Assert.assertNotNull(IdentifierList_11_Var
		);
		Assert.assertEquals("[X, Y]", IdentifierList_11_Var
		.getId().toString());
		Assert.assertEquals("X + Y", DefineFunctionLikeMacro_10_Var
		.getString());
		//11
		final PreprocessorDirectives PreprocessorDirectives_12_Var
		 = (PreprocessorDirectives)Lines_3_list.get(3);
		Assert.assertNotNull(PreprocessorDirectives_12_Var
		);
		//12
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_13_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_12_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_13_Var
		);
		Assert.assertEquals("foo3", DefineFunctionLikeMacro_13_Var
		.getId());
		//13
		final IdentifierList IdentifierList_14_Var
		 = (IdentifierList)DefineFunctionLikeMacro_13_Var
		.getList();
		Assert.assertNotNull(IdentifierList_14_Var
		);
		Assert.assertEquals("[X, Y, Z]", IdentifierList_14_Var
		.getId().toString());
		Assert.assertEquals("X * Y - Z", DefineFunctionLikeMacro_13_Var
		.getString());
		//14
		final PreprocessorDirectives PreprocessorDirectives_15_Var
		 = (PreprocessorDirectives)Lines_3_list.get(4);
		Assert.assertNotNull(PreprocessorDirectives_15_Var
		);
		//15
		final UnDefineDirective UnDefineDirective_16_Var
		 = (UnDefineDirective)PreprocessorDirectives_15_Var
		.getDirective();
		Assert.assertNotNull(UnDefineDirective_16_Var
		);
		Assert.assertEquals("foo0", UnDefineDirective_16_Var
		.getId());
		//16
		final PreprocessorDirectives PreprocessorDirectives_17_Var
		 = (PreprocessorDirectives)Lines_3_list.get(5);
		Assert.assertNotNull(PreprocessorDirectives_17_Var
		);
		//17
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_18_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_17_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_18_Var
		);
		Assert.assertEquals("foo0", DefineFunctionLikeMacro_18_Var
		.getId());
		Assert.assertNull(DefineFunctionLikeMacro_18_Var
		.getList());
		Assert.assertEquals("foo_bar", DefineFunctionLikeMacro_18_Var
		.getString());
		//18
		final NewLineLine NewLineLine_19_Var
		 = (NewLineLine)Lines_3_list.get(6);
		Assert.assertNotNull(NewLineLine_19_Var
		);
		//19
		final Code Code_20_Var
		 = (Code)Lines_3_list.get(7);
		Assert.assertNotNull(Code_20_Var
		);
		Assert.assertEquals("int z = foo0 ( );", Code_20_Var
		.getCode());
		//20
		final Code Code_21_Var
		 = (Code)Lines_3_list.get(8);
		Assert.assertNotNull(Code_21_Var
		);
		Assert.assertEquals("int a = foo1(bar);", Code_21_Var
		.getCode());
		//21
		final Code Code_22_Var
		 = (Code)Lines_3_list.get(9);
		Assert.assertNotNull(Code_22_Var
		);
		Assert.assertEquals("int b = foo2(0,bar );", Code_22_Var
		.getCode());
		//22
		final Code Code_23_Var
		 = (Code)Lines_3_list.get(10);
		Assert.assertNotNull(Code_23_Var
		);
		Assert.assertEquals("int c = foo1 (((bar)));", Code_23_Var
		.getCode());
		//23
		final Code Code_24_Var
		 = (Code)Lines_3_list.get(11);
		Assert.assertNotNull(Code_24_Var
		);
		Assert.assertEquals("int d = foo2((0) , (bar));", Code_24_Var
		.getCode());
		//24
		final Code Code_25_Var
		 = (Code)Lines_3_list.get(12);
		Assert.assertNotNull(Code_25_Var
		);
		Assert.assertEquals("int e = foo2(0,bar) (* (1));", Code_25_Var
		.getCode());
		//25
		final Code Code_26_Var
		 = (Code)Lines_3_list.get(13);
		Assert.assertNotNull(Code_26_Var
		);
		Assert.assertEquals("int f = foo1(0)(1);", Code_26_Var
		.getCode());
		//26
		final Code Code_27_Var
		 = (Code)Lines_3_list.get(14);
		Assert.assertNotNull(Code_27_Var
		);
		Assert.assertEquals("int g = foo1( (a,(b)));", Code_27_Var
		.getCode());
		//27
		final Code Code_28_Var
		 = (Code)Lines_3_list.get(15);
		Assert.assertNotNull(Code_28_Var
		);
		Assert.assertEquals("int h = foo2( (0,b),bar);", Code_28_Var
		.getCode());
		//28
		final Code Code_29_Var
		 = (Code)Lines_3_list.get(16);
		Assert.assertNotNull(Code_29_Var
		);
		Assert.assertEquals("int i = foo2(1, (bar,b));", Code_29_Var
		.getCode());
		//29
		final Code Code_30_Var
		 = (Code)Lines_3_list.get(17);
		Assert.assertNotNull(Code_30_Var
		);
		Assert.assertEquals("int j = foo3(1,(1),(1,1));", Code_30_Var
		.getCode());
		//30
		final Code Code_31_Var
		 = (Code)Lines_3_list.get(18);
		Assert.assertNotNull(Code_31_Var
		);
		Assert.assertEquals("int k = foo0() + (foo1(a)) - foo2(foo, bar) * foo3(foo, bar, baaar);", Code_31_Var
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


