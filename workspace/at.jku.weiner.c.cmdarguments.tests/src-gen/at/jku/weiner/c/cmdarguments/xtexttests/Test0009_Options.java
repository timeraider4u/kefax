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
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CmdArgsInjectorProvider.class)
public class Test0009_Options {
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
			"res/Test0009_Options.cmd");
			final String[] expected = new String[] {
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_SKW_MINUS",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_SKW_MINUS",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_MINUS",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_SKW_MINUS",
				"RULE_ID",
				"RULE_SKW_ASSIGN",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_SKW_MINUS",
				"RULE_ID",
				"RULE_SKW_ASSIGN",
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
			"res/Test0009_Options.cmd");
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
		Assert.assertEquals("Wundef", Argument_2_Var
		.getOption());
		//2
		final CmdLine CmdLine_3_Var
		 = (CmdLine)Lines_0_list.get(1);
		Assert.assertNotNull(CmdLine_3_Var
		);
		Assert.assertEquals("foobar.o", CmdLine_3_Var
		.getStart());
		final EList<? extends EObject> Arguments_3_list = CmdLine_3_Var
		.getArguments();
		Assert.assertNotNull(Arguments_3_list);
		Assert.assertEquals(2, Arguments_3_list.size());
		//3
		final Argument Argument_4_Var
		 = (Argument)Arguments_3_list.get(0);
		Assert.assertNotNull(Argument_4_Var
		);
		Assert.assertEquals("Wall", Argument_4_Var
		.getOption());
		//4
		final Argument Argument_5_Var
		 = (Argument)Arguments_3_list.get(1);
		Assert.assertNotNull(Argument_5_Var
		);
		Assert.assertEquals("Werror-implicit-function-declaration", Argument_5_Var
		.getOption());
		//5
		final CmdLine CmdLine_6_Var
		 = (CmdLine)Lines_0_list.get(2);
		Assert.assertNotNull(CmdLine_6_Var
		);
		Assert.assertEquals("foobar.o", CmdLine_6_Var
		.getStart());
		final EList<? extends EObject> Arguments_6_list = CmdLine_6_Var
		.getArguments();
		Assert.assertNotNull(Arguments_6_list);
		Assert.assertEquals(1, Arguments_6_list.size());
		//6
		final Argument Argument_7_Var
		 = (Argument)Arguments_6_list.get(0);
		Assert.assertNotNull(Argument_7_Var
		);
		Assert.assertEquals("std=gnu89", Argument_7_Var
		.getOption());
		//7
		final CmdLine CmdLine_8_Var
		 = (CmdLine)Lines_0_list.get(3);
		Assert.assertNotNull(CmdLine_8_Var
		);
		Assert.assertEquals("foobar.o", CmdLine_8_Var
		.getStart());
		final EList<? extends EObject> Arguments_8_list = CmdLine_8_Var
		.getArguments();
		Assert.assertNotNull(Arguments_8_list);
		Assert.assertEquals(1, Arguments_8_list.size());
		//8
		final Argument Argument_9_Var
		 = (Argument)Arguments_8_list.get(0);
		Assert.assertNotNull(Argument_9_Var
		);
		Assert.assertEquals("mtune=generic", Argument_9_Var
		.getOption());
	}
	
	
}


