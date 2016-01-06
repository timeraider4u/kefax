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
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0081_Stringification3 {
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
			"res/Test0081_Stringification3.c");
			//System.out.println(text);
			final String[] expected = new String[] {
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
				"RULE_HASH",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_HASH",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
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
			"res/Test0081_Stringification3.c");
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
		Assert.assertEquals(7, Lines_1_list.size());
		//1
		final PreprocessorDirectives PreprocessorDirectives_2_Var
		 = (PreprocessorDirectives)Lines_1_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_2_Var
		);
		//2
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_3_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_2_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_3_Var
		);
		Assert.assertEquals("FOO", DefineFunctionLikeMacro_3_Var
		.getId());
		//3
		final IdentifierList IdentifierList_4_Var
		 = (IdentifierList)DefineFunctionLikeMacro_3_Var
		.getList();
		Assert.assertNotNull(IdentifierList_4_Var
		);
		Assert.assertEquals("[X]", IdentifierList_4_Var
		.getId().toString());
		final EList<? extends EObject> Replacement_4_list = DefineFunctionLikeMacro_3_Var
		.getReplacement();
		Assert.assertNotNull(Replacement_4_list);
		Assert.assertEquals(1, Replacement_4_list.size());
		//4
		final ReplaceLine ReplaceLine_5_Var
		 = (ReplaceLine)Replacement_4_list.get(0);
		Assert.assertNotNull(ReplaceLine_5_Var
		);
		Assert.assertEquals("", ReplaceLine_5_Var
		.getString());
		Assert.assertEquals("X", ReplaceLine_5_Var
		.getId());
		//5
		final PreprocessorDirectives PreprocessorDirectives_6_Var
		 = (PreprocessorDirectives)Lines_1_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_6_Var
		);
		//6
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_7_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_6_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_7_Var
		);
		Assert.assertEquals("BAR", DefineFunctionLikeMacro_7_Var
		.getId());
		//7
		final IdentifierList IdentifierList_8_Var
		 = (IdentifierList)DefineFunctionLikeMacro_7_Var
		.getList();
		Assert.assertNotNull(IdentifierList_8_Var
		);
		Assert.assertEquals("[X]", IdentifierList_8_Var
		.getId().toString());
		final EList<? extends EObject> Replacement_8_list = DefineFunctionLikeMacro_7_Var
		.getReplacement();
		Assert.assertNotNull(Replacement_8_list);
		Assert.assertEquals(2, Replacement_8_list.size());
		//8
		final ReplaceLine ReplaceLine_9_Var
		 = (ReplaceLine)Replacement_8_list.get(0);
		Assert.assertNotNull(ReplaceLine_9_Var
		);
		Assert.assertEquals("FOO(", ReplaceLine_9_Var
		.getString());
		Assert.assertEquals("X", ReplaceLine_9_Var
		.getId());
		//9
		final ReplaceLine ReplaceLine_10_Var
		 = (ReplaceLine)Replacement_8_list.get(1);
		Assert.assertNotNull(ReplaceLine_10_Var
		);
		Assert.assertEquals(")", ReplaceLine_10_Var
		.getString());
		//10
		final PreprocessorDirectives PreprocessorDirectives_11_Var
		 = (PreprocessorDirectives)Lines_1_list.get(2);
		Assert.assertNotNull(PreprocessorDirectives_11_Var
		);
		//11
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_12_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_11_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_12_Var
		);
		Assert.assertEquals("FOOBAR", DefineFunctionLikeMacro_12_Var
		.getId());
		//12
		final IdentifierList IdentifierList_13_Var
		 = (IdentifierList)DefineFunctionLikeMacro_12_Var
		.getList();
		Assert.assertNotNull(IdentifierList_13_Var
		);
		Assert.assertEquals("[X]", IdentifierList_13_Var
		.getId().toString());
		final EList<? extends EObject> Replacement_13_list = DefineFunctionLikeMacro_12_Var
		.getReplacement();
		Assert.assertNotNull(Replacement_13_list);
		Assert.assertEquals(3, Replacement_13_list.size());
		//13
		final ReplaceLine ReplaceLine_14_Var
		 = (ReplaceLine)Replacement_13_list.get(0);
		Assert.assertNotNull(ReplaceLine_14_Var
		);
		Assert.assertEquals("", ReplaceLine_14_Var
		.getString());
		Assert.assertEquals("X", ReplaceLine_14_Var
		.getId());
		//14
		final ReplaceLine ReplaceLine_15_Var
		 = (ReplaceLine)Replacement_13_list.get(1);
		Assert.assertNotNull(ReplaceLine_15_Var
		);
		Assert.assertEquals("BAR(", ReplaceLine_15_Var
		.getString());
		Assert.assertEquals("X", ReplaceLine_15_Var
		.getId());
		//15
		final ReplaceLine ReplaceLine_16_Var
		 = (ReplaceLine)Replacement_13_list.get(2);
		Assert.assertNotNull(ReplaceLine_16_Var
		);
		Assert.assertEquals(")", ReplaceLine_16_Var
		.getString());
		//16
		final NewLineLine NewLineLine_17_Var
		 = (NewLineLine)Lines_1_list.get(3);
		Assert.assertNotNull(NewLineLine_17_Var
		);
		//17
		final Code Code_18_Var
		 = (Code)Lines_1_list.get(4);
		Assert.assertNotNull(Code_18_Var
		);
		Assert.assertEquals("FOO(abc);", Code_18_Var
		.getCode());
		//18
		final Code Code_19_Var
		 = (Code)Lines_1_list.get(5);
		Assert.assertNotNull(Code_19_Var
		);
		Assert.assertEquals("BAR(abc);", Code_19_Var
		.getCode());
		//19
		final Code Code_20_Var
		 = (Code)Lines_1_list.get(6);
		Assert.assertNotNull(Code_20_Var
		);
		Assert.assertEquals("FOOBAR(abc);", Code_20_Var
		.getCode());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0081_Stringification3.c");
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
				method.invoke(this.generator, "Test0081_Stringification3.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0081_Stringification3.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0081_Stringification3.c"
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


