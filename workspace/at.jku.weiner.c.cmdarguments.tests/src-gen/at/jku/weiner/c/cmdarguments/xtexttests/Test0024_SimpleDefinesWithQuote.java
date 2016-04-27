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
import at.jku.weiner.c.cmdarguments.cmdArgs.SimpleMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.SimpleMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.SimpleMacro;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CmdArgsInjectorProvider.class)
public class Test0024_SimpleDefinesWithQuote {
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
			"res/Test0024_SimpleDefinesWithQuote.cmd");
			final String[] expected = new String[] {
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_QUOTE1",
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
				"RULE_QUOTE1",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0024_SimpleDefinesWithQuote.cmd");
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
		final SimpleMacro SimpleMacro_4_Var
		 = (SimpleMacro)StringMacro_3_Var
		.getMacro();
		Assert.assertNotNull(SimpleMacro_4_Var
		);
		Assert.assertEquals("__FOO__BAR__", SimpleMacro_4_Var
		.getName());
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
		Assert.assertEquals(1, Arguments_5_list.size());
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
		final SimpleMacro SimpleMacro_8_Var
		 = (SimpleMacro)StringMacro_7_Var
		.getMacro();
		Assert.assertNotNull(SimpleMacro_8_Var
		);
		Assert.assertEquals("FOO2", SimpleMacro_8_Var
		.getName());
		//8
		final CmdLine CmdLine_9_Var
		 = (CmdLine)Lines_0_list.get(2);
		Assert.assertNotNull(CmdLine_9_Var
		);
		Assert.assertEquals("foobar.o", CmdLine_9_Var
		.getStart());
		final EList<? extends EObject> Arguments_9_list = CmdLine_9_Var
		.getArguments();
		Assert.assertNotNull(Arguments_9_list);
		Assert.assertEquals(1, Arguments_9_list.size());
		//9
		final Argument Argument_10_Var
		 = (Argument)Arguments_9_list.get(0);
		Assert.assertNotNull(Argument_10_Var
		);
		//10
		final StringMacro StringMacro_11_Var
		 = (StringMacro)Argument_10_Var
		.getMacro();
		Assert.assertNotNull(StringMacro_11_Var
		);
		//11
		final SimpleMacro SimpleMacro_12_Var
		 = (SimpleMacro)StringMacro_11_Var
		.getMacro();
		Assert.assertNotNull(SimpleMacro_12_Var
		);
		Assert.assertEquals("_BAR2", SimpleMacro_12_Var
		.getName());
	}
	
	
}


