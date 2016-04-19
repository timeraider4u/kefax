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
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CmdArgsInjectorProvider.class)
public class Test0020_Variables {
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
			"res/Test0020_Variables.cmd");
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
				"RULE_KW_VAR",
				"RULE_NEWLINE",
				"RULE_KW_VAR",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_SKW_MINUS",
				"RULE_ID",
				"RULE_SKW_ASSIGN",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_KW_VAR",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_KW_VAR",
				"RULE_NEWLINE",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0020_Variables.cmd");
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
		Assert.assertEquals("foobar2.o", CmdLine_3_Var
		.getStart());
		final EList<? extends EObject> Arguments_3_list = CmdLine_3_Var
		.getArguments();
		Assert.assertNotNull(Arguments_3_list);
		Assert.assertEquals(1, Arguments_3_list.size());
		//3
		final Argument Argument_4_Var
		 = (Argument)Arguments_3_list.get(0);
		Assert.assertNotNull(Argument_4_Var
		);
		Assert.assertEquals("foobar1.o", Argument_4_Var
		.getIn());
		Assert.assertNull(Argument_4_Var
		.getOption());
		//4
		final CmdLine CmdLine_5_Var
		 = (CmdLine)Lines_0_list.get(2);
		Assert.assertNotNull(CmdLine_5_Var
		);
		Assert.assertEquals("my", CmdLine_5_Var
		.getStart());
		final EList<? extends EObject> Arguments_5_list = CmdLine_5_Var
		.getArguments();
		Assert.assertNotNull(Arguments_5_list);
		Assert.assertEquals(1, Arguments_5_list.size());
		//5
		final Argument Argument_6_Var
		 = (Argument)Arguments_5_list.get(0);
		Assert.assertNotNull(Argument_6_Var
		);
		Assert.assertEquals("std=gnu89", Argument_6_Var
		.getOption());
		//6
		final CmdLine CmdLine_7_Var
		 = (CmdLine)Lines_0_list.get(3);
		Assert.assertNotNull(CmdLine_7_Var
		);
		Assert.assertEquals("x", CmdLine_7_Var
		.getStart());
		final EList<? extends EObject> Arguments_7_list = CmdLine_7_Var
		.getArguments();
		Assert.assertNotNull(Arguments_7_list);
		Assert.assertEquals(1, Arguments_7_list.size());
		//7
		final Argument Argument_8_Var
		 = (Argument)Arguments_7_list.get(0);
		Assert.assertNotNull(Argument_8_Var
		);
		Assert.assertEquals("my-own", Argument_8_Var
		.getIn());
		Assert.assertNull(Argument_8_Var
		.getOption());
	}
	
	
}


