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
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
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
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.UnDefineDirective;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0133_ComplexConcateReplacements {
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
			"res/Test0133_ComplexConcateReplacements.c");
			final String[] expected = new String[] {
				"RULE_LINE_COMMENT",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_DEFINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_DEFINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_DEFINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_HASH",
				"RULE_HASH",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_DEFINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
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
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_SKW_DOT",
				"RULE_SKW_DOT",
				"RULE_SKW_DOT",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_DEFINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_UNDEF",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_DEFINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0133_ComplexConcateReplacements.c");
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
		Assert.assertEquals(13, Lines_1_list.size());
		//1
		final NewLineLine NewLineLine_2_Var
		 = (NewLineLine)Lines_1_list.get(0);
		Assert.assertNotNull(NewLineLine_2_Var
		);
		//2
		final PreprocessorDirectives PreprocessorDirectives_3_Var
		 = (PreprocessorDirectives)Lines_1_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_3_Var
		);
		//3
		final DefineObjectMacro DefineObjectMacro_4_Var
		 = (DefineObjectMacro)PreprocessorDirectives_3_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_4_Var
		);
		Assert.assertEquals("__ARG_FOO_1", DefineObjectMacro_4_Var
		.getId());
		Assert.assertEquals("0,", DefineObjectMacro_4_Var
		.getString());
		//4
		final PreprocessorDirectives PreprocessorDirectives_5_Var
		 = (PreprocessorDirectives)Lines_1_list.get(2);
		Assert.assertNotNull(PreprocessorDirectives_5_Var
		);
		//5
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_6_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_5_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_6_Var
		);
		Assert.assertEquals("BAR_ENABLED", DefineFunctionLikeMacro_6_Var
		.getId());
		//6
		final IdentifierList IdentifierList_7_Var
		 = (IdentifierList)DefineFunctionLikeMacro_6_Var
		.getList();
		Assert.assertNotNull(IdentifierList_7_Var
		);
		Assert.assertEquals("[foo1]", IdentifierList_7_Var
		.getId().toString());
		Assert.assertEquals("_BAR_ENABLED(foo1)", DefineFunctionLikeMacro_6_Var
		.getString());
		//7
		final PreprocessorDirectives PreprocessorDirectives_8_Var
		 = (PreprocessorDirectives)Lines_1_list.get(3);
		Assert.assertNotNull(PreprocessorDirectives_8_Var
		);
		//8
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_9_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_8_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_9_Var
		);
		Assert.assertEquals("_BAR_ENABLED", DefineFunctionLikeMacro_9_Var
		.getId());
		//9
		final IdentifierList IdentifierList_10_Var
		 = (IdentifierList)DefineFunctionLikeMacro_9_Var
		.getList();
		Assert.assertNotNull(IdentifierList_10_Var
		);
		Assert.assertEquals("[foo2]", IdentifierList_10_Var
		.getId().toString());
		Assert.assertEquals("__BAR_ENABLED(__ARG_FOO_##foo2)", DefineFunctionLikeMacro_9_Var
		.getString());
		//10
		final PreprocessorDirectives PreprocessorDirectives_11_Var
		 = (PreprocessorDirectives)Lines_1_list.get(4);
		Assert.assertNotNull(PreprocessorDirectives_11_Var
		);
		//11
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_12_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_11_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_12_Var
		);
		Assert.assertEquals("__BAR_ENABLED", DefineFunctionLikeMacro_12_Var
		.getId());
		//12
		final IdentifierList IdentifierList_13_Var
		 = (IdentifierList)DefineFunctionLikeMacro_12_Var
		.getList();
		Assert.assertNotNull(IdentifierList_13_Var
		);
		Assert.assertEquals("[foo3_or_junk]", IdentifierList_13_Var
		.getId().toString());
		Assert.assertEquals("___BAR_ENABLED(foo3_or_junk 1, 0)", DefineFunctionLikeMacro_12_Var
		.getString());
		//13
		final PreprocessorDirectives PreprocessorDirectives_14_Var
		 = (PreprocessorDirectives)Lines_1_list.get(5);
		Assert.assertNotNull(PreprocessorDirectives_14_Var
		);
		//14
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_15_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_14_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_15_Var
		);
		Assert.assertEquals("___BAR_ENABLED", DefineFunctionLikeMacro_15_Var
		.getId());
		//15
		final IdentifierList IdentifierList_16_Var
		 = (IdentifierList)DefineFunctionLikeMacro_15_Var
		.getList();
		Assert.assertNotNull(IdentifierList_16_Var
		);
		Assert.assertEquals("[__ignored, foo4]", IdentifierList_16_Var
		.getId().toString());
		Assert.assertTrue(IdentifierList_16_Var
		.isVariadic());
		Assert.assertEquals("foo4", DefineFunctionLikeMacro_15_Var
		.getString());
		//16
		final NewLineLine NewLineLine_17_Var
		 = (NewLineLine)Lines_1_list.get(6);
		Assert.assertNotNull(NewLineLine_17_Var
		);
		//17
		final Code Code_18_Var
		 = (Code)Lines_1_list.get(7);
		Assert.assertNotNull(Code_18_Var
		);
		Assert.assertEquals("int i = BAR_ENABLED(FOO);", Code_18_Var
		.getCode());
		//18
		final PreprocessorDirectives PreprocessorDirectives_19_Var
		 = (PreprocessorDirectives)Lines_1_list.get(8);
		Assert.assertNotNull(PreprocessorDirectives_19_Var
		);
		//19
		final DefineObjectMacro DefineObjectMacro_20_Var
		 = (DefineObjectMacro)PreprocessorDirectives_19_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_20_Var
		);
		Assert.assertEquals("FOO", DefineObjectMacro_20_Var
		.getId());
		Assert.assertEquals("1", DefineObjectMacro_20_Var
		.getString());
		//20
		final Code Code_21_Var
		 = (Code)Lines_1_list.get(9);
		Assert.assertNotNull(Code_21_Var
		);
		Assert.assertEquals("int j = BAR_ENABLED(FOO);", Code_21_Var
		.getCode());
		//21
		final PreprocessorDirectives PreprocessorDirectives_22_Var
		 = (PreprocessorDirectives)Lines_1_list.get(10);
		Assert.assertNotNull(PreprocessorDirectives_22_Var
		);
		//22
		final UnDefineDirective UnDefineDirective_23_Var
		 = (UnDefineDirective)PreprocessorDirectives_22_Var
		.getDirective();
		Assert.assertNotNull(UnDefineDirective_23_Var
		);
		Assert.assertEquals("FOO", UnDefineDirective_23_Var
		.getId());
		//23
		final PreprocessorDirectives PreprocessorDirectives_24_Var
		 = (PreprocessorDirectives)Lines_1_list.get(11);
		Assert.assertNotNull(PreprocessorDirectives_24_Var
		);
		//24
		final DefineObjectMacro DefineObjectMacro_25_Var
		 = (DefineObjectMacro)PreprocessorDirectives_24_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_25_Var
		);
		Assert.assertEquals("FOO", DefineObjectMacro_25_Var
		.getId());
		Assert.assertNull(DefineObjectMacro_25_Var
		.getString());
		//25
		final Code Code_26_Var
		 = (Code)Lines_1_list.get(12);
		Assert.assertNotNull(Code_26_Var
		);
		Assert.assertEquals("int k = BAR_ENABLED(FOO);", Code_26_Var
		.getCode());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0133_ComplexConcateReplacements.c");
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
				method.invoke(this.generator, "Test0133_ComplexConcateReplacements.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0133_ComplexConcateReplacements.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0133_ComplexConcateReplacements.c"
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


