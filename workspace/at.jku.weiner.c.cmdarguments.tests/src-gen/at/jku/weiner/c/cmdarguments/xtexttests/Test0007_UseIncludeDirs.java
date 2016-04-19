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
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.SimpleMacro;
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
		Assert.assertEquals(3, Lines_0_list.size());
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
		Assert.assertEquals(3, Arguments_1_list.size());
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
		final CmdLine CmdLine_8_Var
		 = (CmdLine)Lines_0_list.get(1);
		Assert.assertNotNull(CmdLine_8_Var
		);
		Assert.assertEquals("foobar.o", CmdLine_8_Var
		.getStart());
		final EList<? extends EObject> Arguments_8_list = CmdLine_8_Var
		.getArguments();
		Assert.assertNotNull(Arguments_8_list);
		Assert.assertEquals(2, Arguments_8_list.size());
		//8
		final Argument Argument_9_Var
		 = (Argument)Arguments_8_list.get(0);
		Assert.assertNotNull(Argument_9_Var
		);
		Assert.assertFalse(Argument_9_Var
		.isIncDir());
		Assert.assertTrue(Argument_9_Var
		.isIncSys());
		//9
		final PathCmd PathCmd_10_Var
		 = (PathCmd)Argument_9_Var
		.getUseIncDir();
		Assert.assertNotNull(PathCmd_10_Var
		);
		Assert.assertEquals("C:\\system32\\include", PathCmd_10_Var
		.getPath());
		//10
		final Argument Argument_11_Var
		 = (Argument)Arguments_8_list.get(1);
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
		Assert.assertEquals("/usr/lib/gcc/x86_64-pc-linux-gnu/4.8.4/include", PathCmd_12_Var
		.getPath());
		//12
		final CmdLine CmdLine_13_Var
		 = (CmdLine)Lines_0_list.get(2);
		Assert.assertNotNull(CmdLine_13_Var
		);
		Assert.assertEquals("foobar.o", CmdLine_13_Var
		.getStart());
		final EList<? extends EObject> Arguments_13_list = CmdLine_13_Var
		.getArguments();
		Assert.assertNotNull(Arguments_13_list);
		Assert.assertEquals(1, Arguments_13_list.size());
		//13
		final Argument Argument_14_Var
		 = (Argument)Arguments_13_list.get(0);
		Assert.assertNotNull(Argument_14_Var
		);
		Assert.assertFalse(Argument_14_Var
		.isIncDir());
		Assert.assertFalse(Argument_14_Var
		.isIncSys());
		//14
		final SimpleMacro SimpleMacro_15_Var
		 = (SimpleMacro)Argument_14_Var
		.getMacro();
		Assert.assertNotNull(SimpleMacro_15_Var
		);
		Assert.assertEquals("__FOO__", SimpleMacro_15_Var
		.getName());
	}
	
	
}


