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
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.SimpleMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CmdArgsInjectorProvider.class)
public class Test0007_UseIncludeDirs {
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
			"res/Test0007_UseIncludeDirs.cmd");
			final String[] expected = new String[] {
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_KW_INCDIR",
				"RULE_ID",
				"RULE_WS",
				"RULE_KW_INCDIR",
				"RULE_ID",
				"RULE_WS",
				"RULE_KW_INCDIR",
				"RULE_ID",
				"RULE_WS",
				"RULE_KW_INCDIR",
				"RULE_KW_INCLUDE",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_SKW_MINUS",
				"RULE_KW_INCSYS",
				"RULE_WS",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_MINUS",
				"RULE_KW_INCSYS",
				"RULE_WS",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_KW_INCDIR",
				"RULE_ID",
				"RULE_WS",
				"RULE_KW_INCDIR",
				"RULE_ID",
				"RULE_WS",
				"RULE_KW_INCDIR",
				"RULE_KW_INCSYS",
				"RULE_WS",
				"RULE_KW_INCDIR",
				"RULE_ID",
				"RULE_WS",
				"RULE_KW_INCDIR",
				"RULE_ID",
				"RULE_WS",
				"RULE_KW_INCDIR",
				"RULE_ID",
				"RULE_WS",
				"RULE_KW_INCDIR",
				"RULE_ID",
				"RULE_WS",
				"RULE_KW_INCDIR",
				"RULE_KW_NOSTDINC",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0007_UseIncludeDirs.cmd");
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
		Assert.assertEquals(4, Lines_0_list.size());
		//0
		final CmdLine CmdLine_1_Var
		 = (CmdLine)Lines_0_list.get(0);
		Assert.assertNotNull(CmdLine_1_Var
		);
		Assert.assertEquals("foobar1.o", CmdLine_1_Var
		.getStart());
		final EList<? extends EObject> Arguments_1_list = CmdLine_1_Var
		.getArguments();
		Assert.assertNotNull(Arguments_1_list);
		Assert.assertEquals(4, Arguments_1_list.size());
		//1
		final Argument Argument_2_Var
		 = (Argument)Arguments_1_list.get(0);
		Assert.assertNotNull(Argument_2_Var
		);
		Assert.assertTrue(Argument_2_Var
		.isIncDir());
		//2
		final PathCmd PathCmd_3_Var
		 = (PathCmd)Argument_2_Var
		.getUseIncDir();
		Assert.assertNotNull(PathCmd_3_Var
		);
		Assert.assertEquals("foo/bar/include", PathCmd_3_Var
		.getPath());
		//3
		final Argument Argument_4_Var
		 = (Argument)Arguments_1_list.get(1);
		Assert.assertNotNull(Argument_4_Var
		);
		Assert.assertTrue(Argument_4_Var
		.isIncDir());
		//4
		final PathCmd PathCmd_5_Var
		 = (PathCmd)Argument_4_Var
		.getUseIncDir();
		Assert.assertNotNull(PathCmd_5_Var
		);
		Assert.assertEquals("./foobar/bar/include", PathCmd_5_Var
		.getPath());
		//5
		final Argument Argument_6_Var
		 = (Argument)Arguments_1_list.get(2);
		Assert.assertNotNull(Argument_6_Var
		);
		Assert.assertTrue(Argument_6_Var
		.isIncDir());
		//6
		final PathCmd PathCmd_7_Var
		 = (PathCmd)Argument_6_Var
		.getUseIncDir();
		Assert.assertNotNull(PathCmd_7_Var
		);
		Assert.assertEquals("C:\\system\\include", PathCmd_7_Var
		.getPath());
		//7
		final Argument Argument_8_Var
		 = (Argument)Arguments_1_list.get(3);
		Assert.assertNotNull(Argument_8_Var
		);
		Assert.assertTrue(Argument_8_Var
		.isIncDir());
		//8
		final PathCmd PathCmd_9_Var
		 = (PathCmd)Argument_8_Var
		.getUseIncDir();
		Assert.assertNotNull(PathCmd_9_Var
		);
		Assert.assertEquals("include", PathCmd_9_Var
		.getPath());
		//9
		final CmdLine CmdLine_10_Var
		 = (CmdLine)Lines_0_list.get(1);
		Assert.assertNotNull(CmdLine_10_Var
		);
		Assert.assertEquals("foobar2.o", CmdLine_10_Var
		.getStart());
		final EList<? extends EObject> Arguments_10_list = CmdLine_10_Var
		.getArguments();
		Assert.assertNotNull(Arguments_10_list);
		Assert.assertEquals(2, Arguments_10_list.size());
		//10
		final Argument Argument_11_Var
		 = (Argument)Arguments_10_list.get(0);
		Assert.assertNotNull(Argument_11_Var
		);
		Assert.assertFalse(Argument_11_Var
		.isIncDir());
		Assert.assertTrue(Argument_11_Var
		.isIncSys());
		//11
		final PathCmd PathCmd_12_Var
		 = (PathCmd)Argument_11_Var
		.getUseIncDir();
		Assert.assertNotNull(PathCmd_12_Var
		);
		Assert.assertEquals("C:\\system32\\include", PathCmd_12_Var
		.getPath());
		//12
		final Argument Argument_13_Var
		 = (Argument)Arguments_10_list.get(1);
		Assert.assertNotNull(Argument_13_Var
		);
		Assert.assertFalse(Argument_13_Var
		.isIncDir());
		Assert.assertTrue(Argument_13_Var
		.isIncSys());
		//13
		final PathCmd PathCmd_14_Var
		 = (PathCmd)Argument_13_Var
		.getUseIncDir();
		Assert.assertNotNull(PathCmd_14_Var
		);
		Assert.assertEquals("/usr/lib/gcc/x86_64-pc-linux-gnu/4.8.4/include", PathCmd_14_Var
		.getPath());
		//14
		final CmdLine CmdLine_15_Var
		 = (CmdLine)Lines_0_list.get(2);
		Assert.assertNotNull(CmdLine_15_Var
		);
		Assert.assertEquals("foobar3.o", CmdLine_15_Var
		.getStart());
		final EList<? extends EObject> Arguments_15_list = CmdLine_15_Var
		.getArguments();
		Assert.assertNotNull(Arguments_15_list);
		Assert.assertEquals(1, Arguments_15_list.size());
		//15
		final Argument Argument_16_Var
		 = (Argument)Arguments_15_list.get(0);
		Assert.assertNotNull(Argument_16_Var
		);
		Assert.assertFalse(Argument_16_Var
		.isIncDir());
		Assert.assertFalse(Argument_16_Var
		.isIncSys());
		//16
		final SimpleMacro SimpleMacro_17_Var
		 = (SimpleMacro)Argument_16_Var
		.getMacro();
		Assert.assertNotNull(SimpleMacro_17_Var
		);
		Assert.assertEquals("__FOO__", SimpleMacro_17_Var
		.getName());
		//17
		final CmdLine CmdLine_18_Var
		 = (CmdLine)Lines_0_list.get(3);
		Assert.assertNotNull(CmdLine_18_Var
		);
		Assert.assertEquals("foobar4.o", CmdLine_18_Var
		.getStart());
		final EList<? extends EObject> Arguments_18_list = CmdLine_18_Var
		.getArguments();
		Assert.assertNotNull(Arguments_18_list);
		Assert.assertEquals(8, Arguments_18_list.size());
		//18
		final Argument Argument_19_Var
		 = (Argument)Arguments_18_list.get(0);
		Assert.assertNotNull(Argument_19_Var
		);
		Assert.assertTrue(Argument_19_Var
		.isIncDir());
		//19
		final PathCmd PathCmd_20_Var
		 = (PathCmd)Argument_19_Var
		.getUseIncDir();
		Assert.assertNotNull(PathCmd_20_Var
		);
		Assert.assertEquals("output", PathCmd_20_Var
		.getPath());
		//20
		final Argument Argument_21_Var
		 = (Argument)Arguments_18_list.get(1);
		Assert.assertNotNull(Argument_21_Var
		);
		Assert.assertTrue(Argument_21_Var
		.isIncDir());
		//21
		final PathCmd PathCmd_22_Var
		 = (PathCmd)Argument_21_Var
		.getUseIncDir();
		Assert.assertNotNull(PathCmd_22_Var
		);
		Assert.assertEquals("isystem/", PathCmd_22_Var
		.getPath());
		//22
		final Argument Argument_23_Var
		 = (Argument)Arguments_18_list.get(2);
		Assert.assertNotNull(Argument_23_Var
		);
		Assert.assertTrue(Argument_23_Var
		.isIncDir());
		//23
		final PathCmd PathCmd_24_Var
		 = (PathCmd)Argument_23_Var
		.getUseIncDir();
		Assert.assertNotNull(PathCmd_24_Var
		);
		Assert.assertEquals("isystem", PathCmd_24_Var
		.getPath());
		//24
		final Argument Argument_25_Var
		 = (Argument)Arguments_18_list.get(3);
		Assert.assertNotNull(Argument_25_Var
		);
		Assert.assertTrue(Argument_25_Var
		.isIncDir());
		//25
		final PathCmd PathCmd_26_Var
		 = (PathCmd)Argument_25_Var
		.getUseIncDir();
		Assert.assertNotNull(PathCmd_26_Var
		);
		Assert.assertEquals("I/", PathCmd_26_Var
		.getPath());
		//26
		final Argument Argument_27_Var
		 = (Argument)Arguments_18_list.get(4);
		Assert.assertNotNull(Argument_27_Var
		);
		Assert.assertTrue(Argument_27_Var
		.isIncDir());
		//27
		final PathCmd PathCmd_28_Var
		 = (PathCmd)Argument_27_Var
		.getUseIncDir();
		Assert.assertNotNull(PathCmd_28_Var
		);
		Assert.assertEquals("x", PathCmd_28_Var
		.getPath());
		//28
		final Argument Argument_29_Var
		 = (Argument)Arguments_18_list.get(5);
		Assert.assertNotNull(Argument_29_Var
		);
		Assert.assertTrue(Argument_29_Var
		.isIncDir());
		//29
		final PathCmd PathCmd_30_Var
		 = (PathCmd)Argument_29_Var
		.getUseIncDir();
		Assert.assertNotNull(PathCmd_30_Var
		);
		Assert.assertEquals("o", PathCmd_30_Var
		.getPath());
		//30
		final Argument Argument_31_Var
		 = (Argument)Arguments_18_list.get(6);
		Assert.assertNotNull(Argument_31_Var
		);
		Assert.assertTrue(Argument_31_Var
		.isIncDir());
		//31
		final PathCmd PathCmd_32_Var
		 = (PathCmd)Argument_31_Var
		.getUseIncDir();
		Assert.assertNotNull(PathCmd_32_Var
		);
		Assert.assertEquals("D", PathCmd_32_Var
		.getPath());
		//32
		final Argument Argument_33_Var
		 = (Argument)Arguments_18_list.get(7);
		Assert.assertNotNull(Argument_33_Var
		);
		Assert.assertTrue(Argument_33_Var
		.isIncDir());
		//33
		final PathCmd PathCmd_34_Var
		 = (PathCmd)Argument_33_Var
		.getUseIncDir();
		Assert.assertNotNull(PathCmd_34_Var
		);
		Assert.assertEquals("nostdinc", PathCmd_34_Var
		.getPath());
	}
	
	
}


