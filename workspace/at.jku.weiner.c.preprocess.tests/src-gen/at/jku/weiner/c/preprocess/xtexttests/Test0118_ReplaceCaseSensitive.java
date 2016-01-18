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
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0118_ReplaceCaseSensitive {
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
			"res/Test0118_ReplaceCaseSensitive.c");
			//System.out.println(text);
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
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_HASH",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
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
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_HASH",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
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
			"res/Test0118_ReplaceCaseSensitive.c");
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
		Assert.assertEquals(25, Lines_1_list.size());
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
		.getId());
		Assert.assertEquals("x", DefineObjectMacro_3_Var
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
		.getId());
		//5
		final IdentifierList IdentifierList_6_Var
		 = (IdentifierList)DefineFunctionLikeMacro_5_Var
		.getList();
		Assert.assertNotNull(IdentifierList_6_Var
		);
		Assert.assertEquals("[x]", IdentifierList_6_Var
		.getId().toString());
		Assert.assertEquals("#x", DefineFunctionLikeMacro_5_Var
		.getString());
		//6
		final Code Code_7_Var
		 = (Code)Lines_1_list.get(2);
		Assert.assertNotNull(Code_7_Var
		);
		Assert.assertEquals("foo", Code_7_Var
		.getCode());
		//7
		final Code Code_8_Var
		 = (Code)Lines_1_list.get(3);
		Assert.assertNotNull(Code_8_Var
		);
		Assert.assertEquals("foo(y)", Code_8_Var
		.getCode());
		//8
		final Code Code_9_Var
		 = (Code)Lines_1_list.get(4);
		Assert.assertNotNull(Code_9_Var
		);
		Assert.assertEquals("bar", Code_9_Var
		.getCode());
		//9
		final Code Code_10_Var
		 = (Code)Lines_1_list.get(5);
		Assert.assertNotNull(Code_10_Var
		);
		Assert.assertEquals("bar(y)", Code_10_Var
		.getCode());
		//10
		final Code Code_11_Var
		 = (Code)Lines_1_list.get(6);
		Assert.assertNotNull(Code_11_Var
		);
		Assert.assertEquals("Foo", Code_11_Var
		.getCode());
		//11
		final Code Code_12_Var
		 = (Code)Lines_1_list.get(7);
		Assert.assertNotNull(Code_12_Var
		);
		Assert.assertEquals("Foo(y)", Code_12_Var
		.getCode());
		//12
		final Code Code_13_Var
		 = (Code)Lines_1_list.get(8);
		Assert.assertNotNull(Code_13_Var
		);
		Assert.assertEquals("Bar", Code_13_Var
		.getCode());
		//13
		final Code Code_14_Var
		 = (Code)Lines_1_list.get(9);
		Assert.assertNotNull(Code_14_Var
		);
		Assert.assertEquals("Bar(y)", Code_14_Var
		.getCode());
		//14
		final Code Code_15_Var
		 = (Code)Lines_1_list.get(10);
		Assert.assertNotNull(Code_15_Var
		);
		Assert.assertEquals("FOO", Code_15_Var
		.getCode());
		//15
		final Code Code_16_Var
		 = (Code)Lines_1_list.get(11);
		Assert.assertNotNull(Code_16_Var
		);
		Assert.assertEquals("FOO(y)", Code_16_Var
		.getCode());
		//16
		final Code Code_17_Var
		 = (Code)Lines_1_list.get(12);
		Assert.assertNotNull(Code_17_Var
		);
		Assert.assertEquals("BAR", Code_17_Var
		.getCode());
		//17
		final Code Code_18_Var
		 = (Code)Lines_1_list.get(13);
		Assert.assertNotNull(Code_18_Var
		);
		Assert.assertEquals("BAR(y)", Code_18_Var
		.getCode());
		//18
		final NewLineLine NewLineLine_19_Var
		 = (NewLineLine)Lines_1_list.get(14);
		Assert.assertNotNull(NewLineLine_19_Var
		);
		//19
		final Code Code_20_Var
		 = (Code)Lines_1_list.get(15);
		Assert.assertNotNull(Code_20_Var
		);
		Assert.assertEquals("BAR FOO", Code_20_Var
		.getCode());
		//20
		final Code Code_21_Var
		 = (Code)Lines_1_list.get(16);
		Assert.assertNotNull(Code_21_Var
		);
		Assert.assertEquals("BAR(FOO(y))", Code_21_Var
		.getCode());
		//21
		final Code Code_22_Var
		 = (Code)Lines_1_list.get(17);
		Assert.assertNotNull(Code_22_Var
		);
		Assert.assertEquals("BAR(Foo)", Code_22_Var
		.getCode());
		//22
		final Code Code_23_Var
		 = (Code)Lines_1_list.get(18);
		Assert.assertNotNull(Code_23_Var
		);
		Assert.assertEquals("BAR(foo)", Code_23_Var
		.getCode());
		//23
		final NewLineLine NewLineLine_24_Var
		 = (NewLineLine)Lines_1_list.get(19);
		Assert.assertNotNull(NewLineLine_24_Var
		);
		//24
		final PreprocessorDirectives PreprocessorDirectives_25_Var
		 = (PreprocessorDirectives)Lines_1_list.get(20);
		Assert.assertNotNull(PreprocessorDirectives_25_Var
		);
		//25
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_26_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_25_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_26_Var
		);
		Assert.assertEquals("BAZ", DefineFunctionLikeMacro_26_Var
		.getId());
		//26
		final IdentifierList IdentifierList_27_Var
		 = (IdentifierList)DefineFunctionLikeMacro_26_Var
		.getList();
		Assert.assertNotNull(IdentifierList_27_Var
		);
		Assert.assertEquals("[z]", IdentifierList_27_Var
		.getId().toString());
		Assert.assertEquals("FOO foo z Foo #z", DefineFunctionLikeMacro_26_Var
		.getString());
		//27
		final Code Code_28_Var
		 = (Code)Lines_1_list.get(21);
		Assert.assertNotNull(Code_28_Var
		);
		Assert.assertEquals("baz(y)", Code_28_Var
		.getCode());
		//28
		final Code Code_29_Var
		 = (Code)Lines_1_list.get(22);
		Assert.assertNotNull(Code_29_Var
		);
		Assert.assertEquals("BAZ(Foo)", Code_29_Var
		.getCode());
		//29
		final Code Code_30_Var
		 = (Code)Lines_1_list.get(23);
		Assert.assertNotNull(Code_30_Var
		);
		Assert.assertEquals("BAZ(foo)", Code_30_Var
		.getCode());
		//30
		final Code Code_31_Var
		 = (Code)Lines_1_list.get(24);
		Assert.assertNotNull(Code_31_Var
		);
		Assert.assertEquals("BAZ(FOO)", Code_31_Var
		.getCode());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0118_ReplaceCaseSensitive.c");
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
				method.invoke(this.generator, "Test0118_ReplaceCaseSensitive.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0118_ReplaceCaseSensitive.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0118_ReplaceCaseSensitive.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
		// System.out.println("Code generation finished.");
	}
	
	private String preprocess(String string) throws Exception {
		string = preprocessForPatterns(string);
		return string;
	}
	
	
	private String preprocessForPatterns(String string) {
		return string;
	}
	
}


