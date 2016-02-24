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
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
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
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
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
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0135_AnotherConcatenate {
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
			"res/Test0135_AnotherConcatenate.c");
			final String[] expected = new String[] {
				"RULE_HASH",
				"RULE_DEFINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
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
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
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
				"RULE_WHITESPACE",
				"RULE_SKW_DOT",
				"RULE_SKW_DOT",
				"RULE_SKW_DOT",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_HASH",
				"RULE_HASH",
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
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
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
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
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
				"RULE_WHITESPACE",
				"RULE_SKW_DOT",
				"RULE_SKW_DOT",
				"RULE_SKW_DOT",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_HASH",
				"RULE_HASH",
				"RULE_VA_ARGS",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_DEFINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_DEFINE",
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
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_DEFINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_HASH",
				"RULE_HASH",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0135_AnotherConcatenate.c");
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
		Assert.assertEquals(25, Lines_1_list.size());
		//1
		final PreprocessorDirectives PreprocessorDirectives_2_Var
		 = (PreprocessorDirectives)Lines_1_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_2_Var
		);
		//2
		final DefineObjectMacro DefineObjectMacro_3_Var
		 = (DefineObjectMacro)PreprocessorDirectives_2_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_3_Var
		);
		Assert.assertEquals("FOO1", DefineObjectMacro_3_Var
		.getIdent());
		Assert.assertEquals("0,", DefineObjectMacro_3_Var
		.getString());
		//3
		final PreprocessorDirectives PreprocessorDirectives_4_Var
		 = (PreprocessorDirectives)Lines_1_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_4_Var
		);
		//4
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_5_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_4_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_5_Var
		);
		Assert.assertEquals("BAR", DefineFunctionLikeMacro_5_Var
		.getIdent());
		//5
		final IdentifierList IdentifierList_6_Var
		 = (IdentifierList)DefineFunctionLikeMacro_5_Var
		.getList();
		Assert.assertNotNull(IdentifierList_6_Var
		);
		Assert.assertEquals("[X, Y]", IdentifierList_6_Var
		.getIdent().toString());
		Assert.assertEquals("BAZ(X, Y)", DefineFunctionLikeMacro_5_Var
		.getString());
		//6
		final PreprocessorDirectives PreprocessorDirectives_7_Var
		 = (PreprocessorDirectives)Lines_1_list.get(2);
		Assert.assertNotNull(PreprocessorDirectives_7_Var
		);
		//7
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_8_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_7_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_8_Var
		);
		Assert.assertEquals("BAZ", DefineFunctionLikeMacro_8_Var
		.getIdent());
		//8
		final IdentifierList IdentifierList_9_Var
		 = (IdentifierList)DefineFunctionLikeMacro_8_Var
		.getList();
		Assert.assertNotNull(IdentifierList_9_Var
		);
		Assert.assertEquals("[X, Y]", IdentifierList_9_Var
		.getIdent().toString());
		Assert.assertTrue(IdentifierList_9_Var
		.isVariadic());
		Assert.assertEquals("X##Y", DefineFunctionLikeMacro_8_Var
		.getString());
		//9
		final PreprocessorDirectives PreprocessorDirectives_10_Var
		 = (PreprocessorDirectives)Lines_1_list.get(3);
		Assert.assertNotNull(PreprocessorDirectives_10_Var
		);
		//10
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_11_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_10_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_11_Var
		);
		Assert.assertEquals("FOOBAR", DefineFunctionLikeMacro_11_Var
		.getIdent());
		//11
		final IdentifierList IdentifierList_12_Var
		 = (IdentifierList)DefineFunctionLikeMacro_11_Var
		.getList();
		Assert.assertNotNull(IdentifierList_12_Var
		);
		Assert.assertEquals("[X, Y]", IdentifierList_12_Var
		.getIdent().toString());
		Assert.assertEquals("foobar(X, Y)", DefineFunctionLikeMacro_11_Var
		.getString());
		//12
		final PreprocessorDirectives PreprocessorDirectives_13_Var
		 = (PreprocessorDirectives)Lines_1_list.get(4);
		Assert.assertNotNull(PreprocessorDirectives_13_Var
		);
		//13
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_14_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_13_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_14_Var
		);
		Assert.assertEquals("BAR2", DefineFunctionLikeMacro_14_Var
		.getIdent());
		//14
		final IdentifierList IdentifierList_15_Var
		 = (IdentifierList)DefineFunctionLikeMacro_14_Var
		.getList();
		Assert.assertNotNull(IdentifierList_15_Var
		);
		Assert.assertEquals("[X, Y]", IdentifierList_15_Var
		.getIdent().toString());
		Assert.assertEquals("BAZ2(X, Y)", DefineFunctionLikeMacro_14_Var
		.getString());
		//15
		final PreprocessorDirectives PreprocessorDirectives_16_Var
		 = (PreprocessorDirectives)Lines_1_list.get(5);
		Assert.assertNotNull(PreprocessorDirectives_16_Var
		);
		//16
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_17_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_16_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_17_Var
		);
		Assert.assertEquals("BAZ2", DefineFunctionLikeMacro_17_Var
		.getIdent());
		//17
		final IdentifierList IdentifierList_18_Var
		 = (IdentifierList)DefineFunctionLikeMacro_17_Var
		.getList();
		Assert.assertNotNull(IdentifierList_18_Var
		);
		Assert.assertEquals("[X, Y]", IdentifierList_18_Var
		.getIdent().toString());
		Assert.assertTrue(IdentifierList_18_Var
		.isVariadic());
		Assert.assertEquals("X##__VA_ARGS__", DefineFunctionLikeMacro_17_Var
		.getString());
		//18
		final PreprocessorDirectives PreprocessorDirectives_19_Var
		 = (PreprocessorDirectives)Lines_1_list.get(6);
		Assert.assertNotNull(PreprocessorDirectives_19_Var
		);
		//19
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_20_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_19_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_20_Var
		);
		Assert.assertEquals("FOOBAR2", DefineFunctionLikeMacro_20_Var
		.getIdent());
		//20
		final IdentifierList IdentifierList_21_Var
		 = (IdentifierList)DefineFunctionLikeMacro_20_Var
		.getList();
		Assert.assertNotNull(IdentifierList_21_Var
		);
		Assert.assertEquals("[X]", IdentifierList_21_Var
		.getIdent().toString());
		Assert.assertEquals("foobar2(FOO1, X)", DefineFunctionLikeMacro_20_Var
		.getString());
		//21
		final PreprocessorDirectives PreprocessorDirectives_22_Var
		 = (PreprocessorDirectives)Lines_1_list.get(7);
		Assert.assertNotNull(PreprocessorDirectives_22_Var
		);
		//22
		final DefineObjectMacro DefineObjectMacro_23_Var
		 = (DefineObjectMacro)PreprocessorDirectives_22_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_23_Var
		);
		Assert.assertEquals("FOO2", DefineObjectMacro_23_Var
		.getIdent());
		Assert.assertNull(DefineObjectMacro_23_Var
		.getString());
		//23
		final PreprocessorDirectives PreprocessorDirectives_24_Var
		 = (PreprocessorDirectives)Lines_1_list.get(8);
		Assert.assertNotNull(PreprocessorDirectives_24_Var
		);
		//24
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_25_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_24_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_25_Var
		);
		Assert.assertEquals("BAR3", DefineFunctionLikeMacro_25_Var
		.getIdent());
		//25
		final IdentifierList IdentifierList_26_Var
		 = (IdentifierList)DefineFunctionLikeMacro_25_Var
		.getList();
		Assert.assertNotNull(IdentifierList_26_Var
		);
		Assert.assertEquals("[X]", IdentifierList_26_Var
		.getIdent().toString());
		Assert.assertEquals("BAZ3(X)", DefineFunctionLikeMacro_25_Var
		.getString());
		//26
		final PreprocessorDirectives PreprocessorDirectives_27_Var
		 = (PreprocessorDirectives)Lines_1_list.get(9);
		Assert.assertNotNull(PreprocessorDirectives_27_Var
		);
		//27
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_28_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_27_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_28_Var
		);
		Assert.assertEquals("BAZ3", DefineFunctionLikeMacro_28_Var
		.getIdent());
		//28
		final IdentifierList IdentifierList_29_Var
		 = (IdentifierList)DefineFunctionLikeMacro_28_Var
		.getList();
		Assert.assertNotNull(IdentifierList_29_Var
		);
		Assert.assertEquals("[X]", IdentifierList_29_Var
		.getIdent().toString());
		Assert.assertFalse(IdentifierList_29_Var
		.isVariadic());
		Assert.assertEquals("foobar3(FOO##X)", DefineFunctionLikeMacro_28_Var
		.getString());
		//29
		final Code Code_30_Var
		 = (Code)Lines_1_list.get(10);
		Assert.assertNotNull(Code_30_Var
		);
		Assert.assertEquals("FOOBAR(0, 1)", Code_30_Var
		.getCode());
		//30
		final Code Code_31_Var
		 = (Code)Lines_1_list.get(11);
		Assert.assertNotNull(Code_31_Var
		);
		Assert.assertEquals("FOOBAR(FOO1, 1)", Code_31_Var
		.getCode());
		//31
		final Code Code_32_Var
		 = (Code)Lines_1_list.get(12);
		Assert.assertNotNull(Code_32_Var
		);
		Assert.assertEquals("FOOBAR(1, FOO1)", Code_32_Var
		.getCode());
		//32
		final Code Code_33_Var
		 = (Code)Lines_1_list.get(13);
		Assert.assertNotNull(Code_33_Var
		);
		Assert.assertEquals("BAR(0, 1)", Code_33_Var
		.getCode());
		//33
		final Code Code_34_Var
		 = (Code)Lines_1_list.get(14);
		Assert.assertNotNull(Code_34_Var
		);
		Assert.assertEquals("BAR(FOO1, 1)", Code_34_Var
		.getCode());
		//34
		final Code Code_35_Var
		 = (Code)Lines_1_list.get(15);
		Assert.assertNotNull(Code_35_Var
		);
		Assert.assertEquals("BAR(1, FOO1)", Code_35_Var
		.getCode());
		//35
		final Code Code_36_Var
		 = (Code)Lines_1_list.get(16);
		Assert.assertNotNull(Code_36_Var
		);
		Assert.assertEquals("BAR2(0, 1)", Code_36_Var
		.getCode());
		//36
		final Code Code_37_Var
		 = (Code)Lines_1_list.get(17);
		Assert.assertNotNull(Code_37_Var
		);
		Assert.assertEquals("BAR2(FOO1, 1)", Code_37_Var
		.getCode());
		//37
		final Code Code_38_Var
		 = (Code)Lines_1_list.get(18);
		Assert.assertNotNull(Code_38_Var
		);
		Assert.assertEquals("BAR2(1, FOO1)", Code_38_Var
		.getCode());
		//38
		final Code Code_39_Var
		 = (Code)Lines_1_list.get(19);
		Assert.assertNotNull(Code_39_Var
		);
		Assert.assertEquals("FOOBAR2(0)", Code_39_Var
		.getCode());
		//39
		final Code Code_40_Var
		 = (Code)Lines_1_list.get(20);
		Assert.assertNotNull(Code_40_Var
		);
		Assert.assertEquals("FOOBAR2(1)", Code_40_Var
		.getCode());
		//40
		final Code Code_41_Var
		 = (Code)Lines_1_list.get(21);
		Assert.assertNotNull(Code_41_Var
		);
		Assert.assertEquals("FOOBAR2(FOO2)", Code_41_Var
		.getCode());
		//41
		final Code Code_42_Var
		 = (Code)Lines_1_list.get(22);
		Assert.assertNotNull(Code_42_Var
		);
		Assert.assertEquals("BAR3(1)", Code_42_Var
		.getCode());
		//42
		final Code Code_43_Var
		 = (Code)Lines_1_list.get(23);
		Assert.assertNotNull(Code_43_Var
		);
		Assert.assertEquals("BAR3(2)", Code_43_Var
		.getCode());
		//43
		final Code Code_44_Var
		 = (Code)Lines_1_list.get(24);
		Assert.assertNotNull(Code_44_Var
		);
		Assert.assertEquals("BAR3(FOO2)", Code_44_Var
		.getCode());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0135_AnotherConcatenate.c");
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
				method.invoke(this.generator, "Test0135_AnotherConcatenate.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0135_AnotherConcatenate.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0135_AnotherConcatenate.c"
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


