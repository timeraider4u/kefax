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

import at.jku.weiner.c.preprocess.preprocess.Model;
import at.jku.weiner.c.preprocess.preprocess.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
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
public class Test0079_EscapeSequences {
	@Inject
	private ParseHelper<Model> parseHelper;
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
	
	@Test
	public void checkLexerTokens() throws Exception{
		final String text = this.getTextFromFile(
			"res/Test0079_EscapeSequences.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_CHAR_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_CHAR_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_CHAR_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_CHAR_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_CHAR_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_CHAR_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_CHAR_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_CHAR_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_STRING_LITERAL", 
				"RULE_NEWLINE", 
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0079_EscapeSequences.c");
		final Model Model_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(Model_0_Var
		);
		
		Assert.assertNotNull(Model_0_Var
		);
		final EList<? extends EObject> Units_0_list = Model_0_Var
		.getUnits();
		Assert.assertNotNull(Units_0_list);
		Assert.assertEquals(1, Units_0_list.size());
		//0
		final TranslationUnit TranslationUnit_1_Var
		 = (TranslationUnit)Units_0_list.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var
		);
		//1
		final GroupOpt GroupOpt_2_Var
		 = (GroupOpt)TranslationUnit_1_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_2_Var
		);
		final EList<? extends EObject> Lines_2_list = GroupOpt_2_Var
		.getLines();
		Assert.assertNotNull(Lines_2_list);
		Assert.assertEquals(9, Lines_2_list.size());
		//2
		final Code Code_3_Var
		 = (Code)Lines_2_list.get(0);
		Assert.assertNotNull(Code_3_Var
		);
		Assert.assertEquals("'a'", Code_3_Var
		.getCode());
		//3
		final Code Code_4_Var
		 = (Code)Lines_2_list.get(1);
		Assert.assertNotNull(Code_4_Var
		);
		Assert.assertEquals("'9'", Code_4_Var
		.getCode());
		//4
		final Code Code_5_Var
		 = (Code)Lines_2_list.get(2);
		Assert.assertNotNull(Code_5_Var
		);
		Assert.assertEquals("'\\012'", Code_5_Var
		.getCode());
		//5
		final Code Code_6_Var
		 = (Code)Lines_2_list.get(3);
		Assert.assertNotNull(Code_6_Var
		);
		Assert.assertEquals("'\\x2f'", Code_6_Var
		.getCode());
		//6
		final Code Code_7_Var
		 = (Code)Lines_2_list.get(4);
		Assert.assertNotNull(Code_7_Var
		);
		Assert.assertEquals("'\\0'", Code_7_Var
		.getCode());
		//7
		final Code Code_8_Var
		 = (Code)Lines_2_list.get(5);
		Assert.assertNotNull(Code_8_Var
		);
		Assert.assertEquals("'\\''", Code_8_Var
		.getCode());
		//8
		final Code Code_9_Var
		 = (Code)Lines_2_list.get(6);
		Assert.assertNotNull(Code_9_Var
		);
		Assert.assertEquals("'\\\\'", Code_9_Var
		.getCode());
		//9
		final Code Code_10_Var
		 = (Code)Lines_2_list.get(7);
		Assert.assertNotNull(Code_10_Var
		);
		Assert.assertEquals("'\\f'", Code_10_Var
		.getCode());
		//10
		final Code Code_11_Var
		 = (Code)Lines_2_list.get(8);
		Assert.assertNotNull(Code_11_Var
		);
		Assert.assertEquals("\"\\f\\\\a\\0\"", Code_11_Var
		.getCode());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0079_EscapeSequences.c");
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
				method.invoke(this.generator, "Test0079_EscapeSequences.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0079_EscapeSequences.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0079_EscapeSequences.c"
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


