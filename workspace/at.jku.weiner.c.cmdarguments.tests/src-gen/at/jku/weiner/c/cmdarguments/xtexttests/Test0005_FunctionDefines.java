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
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.ObjectMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CmdArgsInjectorProvider.class)
public class Test0005_FunctionDefines {
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
			"res/Test0005_FunctionDefines.cmd");
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
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_STRING",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_ID",
				"RULE_SKW_ASSIGN",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_STRING",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WS",
				"RULE_SKW_COLON",
				"RULE_SKW_ASSIGN",
				"RULE_WS",
				"RULE_KW_DEFINE",
				"RULE_STRING",
				"RULE_NEWLINE",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0005_FunctionDefines.cmd");
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
		final CmdLine CmdLine_4_Var
		 = (CmdLine)Lines_0_list.get(1);
		Assert.assertNotNull(CmdLine_4_Var
		);
		final EList<? extends EObject> Arguments_4_list = CmdLine_4_Var
		.getArguments();
		Assert.assertNotNull(Arguments_4_list);
		Assert.assertEquals(2, Arguments_4_list.size());
		//4
		final Argument Argument_5_Var
		 = (Argument)Arguments_4_list.get(0);
		Assert.assertNotNull(Argument_5_Var
		);
		//5
		final StringMacro StringMacro_6_Var
		 = (StringMacro)Argument_5_Var
		.getMacro();
		Assert.assertNotNull(StringMacro_6_Var
		);
		Assert.assertEquals("BAR(x)=#x", StringMacro_6_Var
		.getString());
		//6
		final Argument Argument_7_Var
		 = (Argument)Arguments_4_list.get(1);
		Assert.assertNotNull(Argument_7_Var
		);
		//7
		final ObjectMacro ObjectMacro_8_Var
		 = (ObjectMacro)Argument_7_Var
		.getMacro();
		Assert.assertNotNull(ObjectMacro_8_Var
		);
		Assert.assertEquals("_BAR2", ObjectMacro_8_Var
		.getName());
		Assert.assertEquals("5", ObjectMacro_8_Var
		.getValue());
		//8
		final CmdLine CmdLine_9_Var
		 = (CmdLine)Lines_0_list.get(2);
		Assert.assertNotNull(CmdLine_9_Var
		);
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
		Assert.assertEquals("STR(s)=#s", StringMacro_11_Var
		.getString());
		//11
		final CmdLine CmdLine_12_Var
		 = (CmdLine)Lines_0_list.get(3);
		Assert.assertNotNull(CmdLine_12_Var
		);
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
		Assert.assertEquals("FOOBAR(X,Y)=FOO(X)##Y", StringMacro_14_Var
		.getString());
	}
	
	
}


