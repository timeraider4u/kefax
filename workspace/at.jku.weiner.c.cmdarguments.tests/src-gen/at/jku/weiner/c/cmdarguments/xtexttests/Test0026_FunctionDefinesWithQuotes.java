package at.jku.weiner.c.cmdarguments.xtexttests;

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
import at.jku.weiner.c.cmdarguments.tests.CmdArgsInjectorProvider;
import at.jku.weiner.c.cmdarguments.parser.antlr.CmdArgsParser;
import at.jku.weiner.c.cmdarguments.parser.antlr.lexer.InternalCmdArgsLexer;
import at.jku.weiner.c.cmdarguments.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.cmdarguments.cmdArgs.Model;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.FunctionMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.FunctionMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.ObjectMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.FunctionMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.FunctionMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.FunctionMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.FunctionMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.SimpleMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.ObjectMacro;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CmdArgsInjectorProvider.class)
public class Test0026_FunctionDefinesWithQuotes {
	@Inject
	private ParseHelper<Model> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalCmdArgsLexer lexer;
	@Inject
	private CmdArgsParser parser;
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
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("cmd",
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
			"res/Test0026_FunctionDefinesWithQuotes.cmd");
			final String[] expected = new String[] {
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_QUOTE1",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_ASSIGN",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_QUOTE1",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_QUOTE1",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_ASSIGN",
				"RULE_ID",
				"RULE_QUOTE1",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_QUOTE1",
				"RULE_ID",
				"RULE_SKW_ASSIGN",
				"RULE_ID",
				"RULE_QUOTE1",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_QUOTE1",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_ASSIGN",
				"RULE_ID",
				"RULE_QUOTE1",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_QUOTE1",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_ASSIGN",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_QUOTE1",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_QUOTE1",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_ASSIGN",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_QUOTE1",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_QUOTE1",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_ASSIGN",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_COMMA",
				"RULE_ID",
				"RULE_QUOTE1",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_QUOTE1",
				"RULE_KW_NOSTDINC",
				"RULE_QUOTE1",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_QUOTE1",
				"RULE_KW_INCSYS",
				"RULE_SKW_ASSIGN",
				"RULE_KW_INCLUDE",
				"RULE_QUOTE1",
				"RULE_NEWLINE",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0026_FunctionDefinesWithQuotes.cmd");
		final Model Model_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(Model_0_Var
		);
		
		Assert.assertNotNull(Model_0_Var
		);
		final EList<? extends EObject> Lines_0_list = Model_0_Var
		.getLines();
		Assert.assertNotNull(Lines_0_list);
		Assert.assertEquals(8, Lines_0_list.size());
		//0
		final CmdLine CmdLine_1_Var
		 = (CmdLine)Lines_0_list.get(0);
		Assert.assertNotNull(CmdLine_1_Var
		);
		Assert.assertEquals("foobar.o", CmdLine_1_Var
		.getStart());
		final EList<? extends EObject> Arguments_1_list = CmdLine_1_Var
		.getArguments();
		Assert.assertNotNull(Arguments_1_list);
		Assert.assertEquals(1, Arguments_1_list.size());
		//1
		final Argument Argument_2_Var
		 = (Argument)Arguments_1_list.get(0);
		Assert.assertNotNull(Argument_2_Var
		);
		//2
		final StringMacro StringMacro_3_Var
		 = (StringMacro)Argument_2_Var
		.getMacro();
		Assert.assertNotNull(StringMacro_3_Var
		);
		//3
		final FunctionMacro FunctionMacro_4_Var
		 = (FunctionMacro)StringMacro_3_Var
		.getMacro();
		Assert.assertNotNull(FunctionMacro_4_Var
		);
		Assert.assertEquals("FOO", FunctionMacro_4_Var
		.getName());
		Assert.assertEquals("[X]", FunctionMacro_4_Var
		.getParams().toString());
		Assert.assertEquals("BAR(X)", FunctionMacro_4_Var
		.getValue());
		//4
		final CmdLine CmdLine_5_Var
		 = (CmdLine)Lines_0_list.get(1);
		Assert.assertNotNull(CmdLine_5_Var
		);
		Assert.assertEquals("foobar.o", CmdLine_5_Var
		.getStart());
		final EList<? extends EObject> Arguments_5_list = CmdLine_5_Var
		.getArguments();
		Assert.assertNotNull(Arguments_5_list);
		Assert.assertEquals(2, Arguments_5_list.size());
		//5
		final Argument Argument_6_Var
		 = (Argument)Arguments_5_list.get(0);
		Assert.assertNotNull(Argument_6_Var
		);
		//6
		final StringMacro StringMacro_7_Var
		 = (StringMacro)Argument_6_Var
		.getMacro();
		Assert.assertNotNull(StringMacro_7_Var
		);
		//7
		final FunctionMacro FunctionMacro_8_Var
		 = (FunctionMacro)StringMacro_7_Var
		.getMacro();
		Assert.assertNotNull(FunctionMacro_8_Var
		);
		Assert.assertEquals("BAR", FunctionMacro_8_Var
		.getName());
		Assert.assertEquals("[x]", FunctionMacro_8_Var
		.getParams().toString());
		Assert.assertEquals("x", FunctionMacro_8_Var
		.getValue());
		//8
		final Argument Argument_9_Var
		 = (Argument)Arguments_5_list.get(1);
		Assert.assertNotNull(Argument_9_Var
		);
		//9
		final StringMacro StringMacro_10_Var
		 = (StringMacro)Argument_9_Var
		.getMacro();
		Assert.assertNotNull(StringMacro_10_Var
		);
		//10
		final ObjectMacro ObjectMacro_11_Var
		 = (ObjectMacro)StringMacro_10_Var
		.getMacro();
		Assert.assertNotNull(ObjectMacro_11_Var
		);
		Assert.assertEquals("_BAR2", ObjectMacro_11_Var
		.getName());
		Assert.assertEquals("5", ObjectMacro_11_Var
		.getValue());
		//11
		final CmdLine CmdLine_12_Var
		 = (CmdLine)Lines_0_list.get(2);
		Assert.assertNotNull(CmdLine_12_Var
		);
		Assert.assertEquals("foobar.o", CmdLine_12_Var
		.getStart());
		final EList<? extends EObject> Arguments_12_list = CmdLine_12_Var
		.getArguments();
		Assert.assertNotNull(Arguments_12_list);
		Assert.assertEquals(1, Arguments_12_list.size());
		//12
		final Argument Argument_13_Var
		 = (Argument)Arguments_12_list.get(0);
		Assert.assertNotNull(Argument_13_Var
		);
		//13
		final StringMacro StringMacro_14_Var
		 = (StringMacro)Argument_13_Var
		.getMacro();
		Assert.assertNotNull(StringMacro_14_Var
		);
		//14
		final FunctionMacro FunctionMacro_15_Var
		 = (FunctionMacro)StringMacro_14_Var
		.getMacro();
		Assert.assertNotNull(FunctionMacro_15_Var
		);
		Assert.assertEquals("STR", FunctionMacro_15_Var
		.getName());
		Assert.assertEquals("[s]", FunctionMacro_15_Var
		.getParams().toString());
		Assert.assertEquals("s", FunctionMacro_15_Var
		.getValue());
		//15
		final CmdLine CmdLine_16_Var
		 = (CmdLine)Lines_0_list.get(3);
		Assert.assertNotNull(CmdLine_16_Var
		);
		Assert.assertEquals("foobar.o", CmdLine_16_Var
		.getStart());
		final EList<? extends EObject> Arguments_16_list = CmdLine_16_Var
		.getArguments();
		Assert.assertNotNull(Arguments_16_list);
		Assert.assertEquals(1, Arguments_16_list.size());
		//16
		final Argument Argument_17_Var
		 = (Argument)Arguments_16_list.get(0);
		Assert.assertNotNull(Argument_17_Var
		);
		//17
		final StringMacro StringMacro_18_Var
		 = (StringMacro)Argument_17_Var
		.getMacro();
		Assert.assertNotNull(StringMacro_18_Var
		);
		//18
		final FunctionMacro FunctionMacro_19_Var
		 = (FunctionMacro)StringMacro_18_Var
		.getMacro();
		Assert.assertNotNull(FunctionMacro_19_Var
		);
		Assert.assertEquals("FOOBAR", FunctionMacro_19_Var
		.getName());
		Assert.assertEquals("[X]", FunctionMacro_19_Var
		.getParams().toString());
		Assert.assertEquals("FOO(X)(Y)", FunctionMacro_19_Var
		.getValue());
		//19
		final CmdLine CmdLine_20_Var
		 = (CmdLine)Lines_0_list.get(4);
		Assert.assertNotNull(CmdLine_20_Var
		);
		Assert.assertEquals("foobar.o", CmdLine_20_Var
		.getStart());
		final EList<? extends EObject> Arguments_20_list = CmdLine_20_Var
		.getArguments();
		Assert.assertNotNull(Arguments_20_list);
		Assert.assertEquals(1, Arguments_20_list.size());
		//20
		final Argument Argument_21_Var
		 = (Argument)Arguments_20_list.get(0);
		Assert.assertNotNull(Argument_21_Var
		);
		//21
		final StringMacro StringMacro_22_Var
		 = (StringMacro)Argument_21_Var
		.getMacro();
		Assert.assertNotNull(StringMacro_22_Var
		);
		//22
		final FunctionMacro FunctionMacro_23_Var
		 = (FunctionMacro)StringMacro_22_Var
		.getMacro();
		Assert.assertNotNull(FunctionMacro_23_Var
		);
		Assert.assertEquals("STR", FunctionMacro_23_Var
		.getName());
		Assert.assertEquals("[s]", FunctionMacro_23_Var
		.getParams().toString());
		Assert.assertEquals("FOO(BAR(s))", FunctionMacro_23_Var
		.getValue());
		//23
		final CmdLine CmdLine_24_Var
		 = (CmdLine)Lines_0_list.get(5);
		Assert.assertNotNull(CmdLine_24_Var
		);
		Assert.assertEquals("foobar.o", CmdLine_24_Var
		.getStart());
		final EList<? extends EObject> Arguments_24_list = CmdLine_24_Var
		.getArguments();
		Assert.assertNotNull(Arguments_24_list);
		Assert.assertEquals(1, Arguments_24_list.size());
		//24
		final Argument Argument_25_Var
		 = (Argument)Arguments_24_list.get(0);
		Assert.assertNotNull(Argument_25_Var
		);
		//25
		final StringMacro StringMacro_26_Var
		 = (StringMacro)Argument_25_Var
		.getMacro();
		Assert.assertNotNull(StringMacro_26_Var
		);
		//26
		final FunctionMacro FunctionMacro_27_Var
		 = (FunctionMacro)StringMacro_26_Var
		.getMacro();
		Assert.assertNotNull(FunctionMacro_27_Var
		);
		Assert.assertEquals("FOOBAR", FunctionMacro_27_Var
		.getName());
		Assert.assertEquals("[X, Y]", FunctionMacro_27_Var
		.getParams().toString());
		Assert.assertEquals("FOO(X),Y", FunctionMacro_27_Var
		.getValue());
		//27
		final CmdLine CmdLine_28_Var
		 = (CmdLine)Lines_0_list.get(6);
		Assert.assertNotNull(CmdLine_28_Var
		);
		Assert.assertEquals("foobar.o", CmdLine_28_Var
		.getStart());
		final EList<? extends EObject> Arguments_28_list = CmdLine_28_Var
		.getArguments();
		Assert.assertNotNull(Arguments_28_list);
		Assert.assertEquals(1, Arguments_28_list.size());
		//28
		final Argument Argument_29_Var
		 = (Argument)Arguments_28_list.get(0);
		Assert.assertNotNull(Argument_29_Var
		);
		//29
		final StringMacro StringMacro_30_Var
		 = (StringMacro)Argument_29_Var
		.getMacro();
		Assert.assertNotNull(StringMacro_30_Var
		);
		//30
		final SimpleMacro SimpleMacro_31_Var
		 = (SimpleMacro)StringMacro_30_Var
		.getMacro();
		Assert.assertNotNull(SimpleMacro_31_Var
		);
		Assert.assertEquals("nostdinc", SimpleMacro_31_Var
		.getName());
		//31
		final CmdLine CmdLine_32_Var
		 = (CmdLine)Lines_0_list.get(7);
		Assert.assertNotNull(CmdLine_32_Var
		);
		Assert.assertEquals("foobar.o", CmdLine_32_Var
		.getStart());
		final EList<? extends EObject> Arguments_32_list = CmdLine_32_Var
		.getArguments();
		Assert.assertNotNull(Arguments_32_list);
		Assert.assertEquals(1, Arguments_32_list.size());
		//32
		final Argument Argument_33_Var
		 = (Argument)Arguments_32_list.get(0);
		Assert.assertNotNull(Argument_33_Var
		);
		//33
		final StringMacro StringMacro_34_Var
		 = (StringMacro)Argument_33_Var
		.getMacro();
		Assert.assertNotNull(StringMacro_34_Var
		);
		//34
		final ObjectMacro ObjectMacro_35_Var
		 = (ObjectMacro)StringMacro_34_Var
		.getMacro();
		Assert.assertNotNull(ObjectMacro_35_Var
		);
		Assert.assertEquals("isystem", ObjectMacro_35_Var
		.getName());
		Assert.assertEquals("include", ObjectMacro_35_Var
		.getValue());
	}
	
	
}


