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
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0038_Concatenation {
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
			"res/Test0038_Concatenation.c");
			//System.out.println(text);
			final String[] expected = new String[] {
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
				"RULE_HASH",
				"RULE_HASH",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_HASH",
				"RULE_ID",
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
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_HASH",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_HASH",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_HASH",
				"RULE_HASH",
				"RULE_WHITESPACE",
				"RULE_ID",
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
				"RULE_ID",
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
			"res/Test0038_Concatenation.c");
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
		Assert.assertEquals(4, Lines_1_list.size());
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
		Assert.assertEquals("[x, y]", IdentifierList_4_Var
		.getId().toString());
		final EList<? extends EObject> Replacement_4_list = DefineFunctionLikeMacro_3_Var
		.getReplacement();
		Assert.assertNotNull(Replacement_4_list);
		Assert.assertEquals(3, Replacement_4_list.size());
		//4
		final ReplaceLine ReplaceLine_5_Var
		 = (ReplaceLine)Replacement_4_list.get(0);
		Assert.assertNotNull(ReplaceLine_5_Var
		);
		Assert.assertTrue(ReplaceLine_5_Var
		.isConcatenate());
		Assert.assertEquals(" x ", ReplaceLine_5_Var
		.getString());
		//5
		final ReplaceLine ReplaceLine_6_Var
		 = (ReplaceLine)Replacement_4_list.get(1);
		Assert.assertNotNull(ReplaceLine_6_Var
		);
		Assert.assertEquals(" y, ", ReplaceLine_6_Var
		.getString());
		Assert.assertEquals("x", ReplaceLine_6_Var
		.getId());
		//6
		final ReplaceLine ReplaceLine_7_Var
		 = (ReplaceLine)Replacement_4_list.get(2);
		Assert.assertNotNull(ReplaceLine_7_Var
		);
		Assert.assertEquals(" ", ReplaceLine_7_Var
		.getString());
		Assert.assertEquals("y", ReplaceLine_7_Var
		.getId());
		//7
		final PreprocessorDirectives PreprocessorDirectives_8_Var
		 = (PreprocessorDirectives)Lines_1_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_8_Var
		);
		//8
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_9_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_8_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_9_Var
		);
		Assert.assertEquals("BAR", DefineFunctionLikeMacro_9_Var
		.getId());
		//9
		final IdentifierList IdentifierList_10_Var
		 = (IdentifierList)DefineFunctionLikeMacro_9_Var
		.getList();
		Assert.assertNotNull(IdentifierList_10_Var
		);
		Assert.assertEquals("[x, y]", IdentifierList_10_Var
		.getId().toString());
		final EList<? extends EObject> Replacement_10_list = DefineFunctionLikeMacro_9_Var
		.getReplacement();
		Assert.assertNotNull(Replacement_10_list);
		Assert.assertEquals(4, Replacement_10_list.size());
		//10
		final ReplaceLine ReplaceLine_11_Var
		 = (ReplaceLine)Replacement_10_list.get(0);
		Assert.assertNotNull(ReplaceLine_11_Var
		);
		Assert.assertEquals(" ", ReplaceLine_11_Var
		.getString());
		Assert.assertEquals("x", ReplaceLine_11_Var
		.getId());
		//11
		final ReplaceLine ReplaceLine_12_Var
		 = (ReplaceLine)Replacement_10_list.get(1);
		Assert.assertNotNull(ReplaceLine_12_Var
		);
		Assert.assertEquals(" ", ReplaceLine_12_Var
		.getString());
		Assert.assertEquals("y", ReplaceLine_12_Var
		.getId());
		//12
		final ReplaceLine ReplaceLine_13_Var
		 = (ReplaceLine)Replacement_10_list.get(2);
		Assert.assertNotNull(ReplaceLine_13_Var
		);
		Assert.assertTrue(ReplaceLine_13_Var
		.isConcatenate());
		Assert.assertEquals(", x ", ReplaceLine_13_Var
		.getString());
		//13
		final ReplaceLine ReplaceLine_14_Var
		 = (ReplaceLine)Replacement_10_list.get(3);
		Assert.assertNotNull(ReplaceLine_14_Var
		);
		Assert.assertEquals(" y", ReplaceLine_14_Var
		.getString());
		//14
		final Code Code_15_Var
		 = (Code)Lines_1_list.get(2);
		Assert.assertNotNull(Code_15_Var
		);
		Assert.assertEquals("FOO(foo, bar)", Code_15_Var
		.getCode());
		//15
		final Code Code_16_Var
		 = (Code)Lines_1_list.get(3);
		Assert.assertNotNull(Code_16_Var
		);
		Assert.assertEquals("BAR(foo, bar)", Code_16_Var
		.getCode());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0038_Concatenation.c");
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
				method.invoke(this.generator, "Test0038_Concatenation.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0038_Concatenation.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0038_Concatenation.c"
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


