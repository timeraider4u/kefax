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
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CmdArgsInjectorProvider.class)
public class Test0007_Include {
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
			"res/Test0007_Include.cmd");
			final String[] expected = new String[] {
				"RULE_SKW_MINUS",
				"RULE_KW_INCLUDE",
				"RULE_WS",
				"RULE_ANY_OTHER",
				"RULE_ANY_OTHER",
				"RULE_KW_INCLUDE",
				"RULE_ANY_OTHER",
				"RULE_ID",
				"RULE_ANY_OTHER",
				"RULE_ID",
				"RULE_ANY_OTHER",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_MINUS",
				"RULE_KW_INCLUDE",
				"RULE_WS",
				"RULE_ID",
				"RULE_ANY_OTHER",
				"RULE_ANY_OTHER",
				"RULE_ID",
				"RULE_ANY_OTHER",
				"RULE_ID",
				"RULE_ANY_OTHER",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_SKW_MINUS",
				"RULE_KW_INCLUDE",
				"RULE_WS",
				"RULE_ID",
				"RULE_ANY_OTHER",
				"RULE_ANY_OTHER",
				"RULE_ID",
				"RULE_ANY_OTHER",
				"RULE_ID",
				"RULE_ANY_OTHER",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_MINUS",
				"RULE_KW_INCLUDE",
				"RULE_WS",
				"RULE_ANY_OTHER",
				"RULE_ANY_OTHER",
				"RULE_ID",
				"RULE_ANY_OTHER",
				"RULE_ID",
				"RULE_ANY_OTHER",
				"RULE_ID",
				"RULE_ANY_OTHER",
				"RULE_ID",
				"RULE_NEWLINE",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0007_Include.cmd");
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
		Assert.assertEquals(2, Lines_0_list.size());
		//0
		final CmdLine CmdLine_1_Var
		 = (CmdLine)Lines_0_list.get(0);
		Assert.assertNotNull(CmdLine_1_Var
		);
		final EList<? extends EObject> Arguments_1_list = CmdLine_1_Var
		.getArguments();
		Assert.assertNotNull(Arguments_1_list);
		Assert.assertEquals(2, Arguments_1_list.size());
		//1
		final Argument Argument_2_Var
		 = (Argument)Arguments_1_list.get(0);
		Assert.assertNotNull(Argument_2_Var
		);
		//2
		final PathCmd PathCmd_3_Var
		 = (PathCmd)Argument_2_Var
		.getInclude();
		Assert.assertNotNull(PathCmd_3_Var
		);
		Assert.assertEquals("./include/std/config.h", PathCmd_3_Var
		.getPath());
		//3
		final Argument Argument_4_Var
		 = (Argument)Arguments_1_list.get(1);
		Assert.assertNotNull(Argument_4_Var
		);
		//4
		final PathCmd PathCmd_5_Var
		 = (PathCmd)Argument_4_Var
		.getInclude();
		Assert.assertNotNull(PathCmd_5_Var
		);
		Assert.assertEquals("C:\\system\\mysystem.h", PathCmd_5_Var
		.getPath());
		//5
		final CmdLine CmdLine_6_Var
		 = (CmdLine)Lines_0_list.get(1);
		Assert.assertNotNull(CmdLine_6_Var
		);
		final EList<? extends EObject> Arguments_6_list = CmdLine_6_Var
		.getArguments();
		Assert.assertNotNull(Arguments_6_list);
		Assert.assertEquals(2, Arguments_6_list.size());
		//6
		final Argument Argument_7_Var
		 = (Argument)Arguments_6_list.get(0);
		Assert.assertNotNull(Argument_7_Var
		);
		//7
		final PathCmd PathCmd_8_Var
		 = (PathCmd)Argument_7_Var
		.getInclude();
		Assert.assertNotNull(PathCmd_8_Var
		);
		Assert.assertEquals("C:\\system32\\mysystem.h", PathCmd_8_Var
		.getPath());
		//8
		final Argument Argument_9_Var
		 = (Argument)Arguments_6_list.get(1);
		Assert.assertNotNull(Argument_9_Var
		);
		//9
		final PathCmd PathCmd_10_Var
		 = (PathCmd)Argument_9_Var
		.getInclude();
		Assert.assertNotNull(PathCmd_10_Var
		);
		Assert.assertEquals("./include64/std/config.h", PathCmd_10_Var
		.getPath());
	}
	
	
}


