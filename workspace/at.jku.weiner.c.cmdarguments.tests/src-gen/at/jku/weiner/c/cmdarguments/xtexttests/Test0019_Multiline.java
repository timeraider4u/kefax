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
import at.jku.weiner.c.cmdarguments.cmdArgs.FunctionMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.SimpleMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CmdArgsInjectorProvider.class)
public class Test0019_Multiline {
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
			"res/Test0019_Multiline.cmd");
			final String[] expected = new String[] {
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_ASSIGN",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WS",
				"RULE_LINE_BREAK",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_STRING2",
				"RULE_LINE_BREAK",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_ID",
				"RULE_WS",
				"RULE_WS",
				"RULE_LINE_BREAK",
				"RULE_WS",
				"RULE_WS",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_STRING2",
				"RULE_WS",
				"RULE_LINE_BREAK",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_STRING2",
				"RULE_NEWLINE",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0019_Multiline.cmd");
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
		Assert.assertEquals(1, Lines_0_list.size());
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
		Assert.assertEquals(5, Arguments_1_list.size());
		//1
		final Argument Argument_2_Var
		 = (Argument)Arguments_1_list.get(0);
		Assert.assertNotNull(Argument_2_Var
		);
		//2
		final FunctionMacro FunctionMacro_3_Var
		 = (FunctionMacro)Argument_2_Var
		.getMacro();
		Assert.assertNotNull(FunctionMacro_3_Var
		);
		Assert.assertEquals("FOO", FunctionMacro_3_Var
		.getName());
		Assert.assertEquals("[X]", FunctionMacro_3_Var
		.getParams().toString());
		Assert.assertEquals("BAR(X)", FunctionMacro_3_Var
		.getValue());
		//3
		final Argument Argument_4_Var
		 = (Argument)Arguments_1_list.get(1);
		Assert.assertNotNull(Argument_4_Var
		);
		//4
		final StringMacro StringMacro_5_Var
		 = (StringMacro)Argument_4_Var
		.getMacro();
		Assert.assertNotNull(StringMacro_5_Var
		);
		Assert.assertEquals("BAR(x)=#x", StringMacro_5_Var
		.getString());
		//5
		final Argument Argument_6_Var
		 = (Argument)Arguments_1_list.get(2);
		Assert.assertNotNull(Argument_6_Var
		);
		//6
		final SimpleMacro SimpleMacro_7_Var
		 = (SimpleMacro)Argument_6_Var
		.getMacro();
		Assert.assertNotNull(SimpleMacro_7_Var
		);
		Assert.assertEquals("_BAR2", SimpleMacro_7_Var
		.getName());
		//7
		final Argument Argument_8_Var
		 = (Argument)Arguments_1_list.get(3);
		Assert.assertNotNull(Argument_8_Var
		);
		//8
		final StringMacro StringMacro_9_Var
		 = (StringMacro)Argument_8_Var
		.getMacro();
		Assert.assertNotNull(StringMacro_9_Var
		);
		Assert.assertEquals("STR(s)=#s", StringMacro_9_Var
		.getString());
		//9
		final Argument Argument_10_Var
		 = (Argument)Arguments_1_list.get(4);
		Assert.assertNotNull(Argument_10_Var
		);
		//10
		final StringMacro StringMacro_11_Var
		 = (StringMacro)Argument_10_Var
		.getMacro();
		Assert.assertNotNull(StringMacro_11_Var
		);
		Assert.assertEquals("FOOBAR(X,Y)=FOO(X)##Y", StringMacro_11_Var
		.getString());
	}
	
	
}


