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
public class Test0122_ExpansionOfArgs {
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
			"res/Test0122_ExpansionOfArgs.c");
			final String[] expected = new String[] {
				"RULE_HASH",
				"RULE_DEFINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
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
				"RULE_WHITESPACE",
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
				"RULE_HASH",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_HASH",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_SKW_MINUS",
				"RULE_ID",
				"RULE_SKW_MINUS",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_MINUS",
				"RULE_ID",
				"RULE_SKW_MINUS",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_SKW_MINUS",
				"RULE_ID",
				"RULE_SKW_MINUS",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
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
			"res/Test0122_ExpansionOfArgs.c");
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
		Assert.assertEquals(11, Lines_1_list.size());
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
		Assert.assertEquals("FOO", DefineObjectMacro_3_Var
		.getIdent());
		Assert.assertEquals("foo", DefineObjectMacro_3_Var
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
		Assert.assertEquals("X Y", DefineFunctionLikeMacro_5_Var
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
		Assert.assertEquals("BAR(X, Y)", DefineFunctionLikeMacro_8_Var
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
		Assert.assertEquals("FOO2", DefineFunctionLikeMacro_11_Var
		.getIdent());
		//11
		final IdentifierList IdentifierList_12_Var
		 = (IdentifierList)DefineFunctionLikeMacro_11_Var
		.getList();
		Assert.assertNotNull(IdentifierList_12_Var
		);
		Assert.assertEquals("[X, Y]", IdentifierList_12_Var
		.getIdent().toString());
		Assert.assertEquals("BAR(#X, #Y)", DefineFunctionLikeMacro_11_Var
		.getString());
		//12
		final Code Code_13_Var
		 = (Code)Lines_1_list.get(4);
		Assert.assertNotNull(Code_13_Var
		);
		Assert.assertEquals("BAR(FOO, FOO)", Code_13_Var
		.getCode());
		//13
		final Code Code_14_Var
		 = (Code)Lines_1_list.get(5);
		Assert.assertNotNull(Code_14_Var
		);
		Assert.assertEquals("BAR((FOO), -FOO-)", Code_14_Var
		.getCode());
		//14
		final Code Code_15_Var
		 = (Code)Lines_1_list.get(6);
		Assert.assertNotNull(Code_15_Var
		);
		Assert.assertEquals("BAZ(FOO, FOO)", Code_15_Var
		.getCode());
		//15
		final Code Code_16_Var
		 = (Code)Lines_1_list.get(7);
		Assert.assertNotNull(Code_16_Var
		);
		Assert.assertEquals("BAZ((FOO), (-FOO-))", Code_16_Var
		.getCode());
		//16
		final Code Code_17_Var
		 = (Code)Lines_1_list.get(8);
		Assert.assertNotNull(Code_17_Var
		);
		Assert.assertEquals("FOO2(FOO, FOO)", Code_17_Var
		.getCode());
		//17
		final Code Code_18_Var
		 = (Code)Lines_1_list.get(9);
		Assert.assertNotNull(Code_18_Var
		);
		Assert.assertEquals("FOO2((FOO), -FOO-)", Code_18_Var
		.getCode());
		//18
		final Code Code_19_Var
		 = (Code)Lines_1_list.get(10);
		Assert.assertNotNull(Code_19_Var
		);
		Assert.assertEquals("FOO2((FOO,FOO), FOO$FOO)", Code_19_Var
		.getCode());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0122_ExpansionOfArgs.c");
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
				method.invoke(this.generator, "Test0122_ExpansionOfArgs.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0122_ExpansionOfArgs.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0122_ExpansionOfArgs.c"
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


