package at.jku.weiner.cpreprocess.xtexttests;

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
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import at.jku.weiner.cpreprocess.tests.CPreprocessInjectorProvider;
import at.jku.weiner.cpreprocess.parser.antlr.CPreprocessParser;
import at.jku.weiner.cpreprocess.parser.antlr.lexer.InternalCPreprocessLexer;
import at.jku.weiner.cpreprocess.xtexttests.LexerAndParserTest;

import at.jku.weiner.cpreprocess.cPreprocess.Model;
import at.jku.weiner.cpreprocess.cPreprocess.TranslationUnit;
import at.jku.weiner.cpreprocess.cPreprocess.GroupOpt;
import at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives;
import at.jku.weiner.cpreprocess.cPreprocess.DefineObjectMacro;
import at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives;
import at.jku.weiner.cpreprocess.cPreprocess.ConditionalDirective;
import at.jku.weiner.cpreprocess.cPreprocess.GroupOpt;
import at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives;
import at.jku.weiner.cpreprocess.cPreprocess.DefineObjectMacro;
import at.jku.weiner.cpreprocess.cPreprocess.Code;
import at.jku.weiner.cpreprocess.cPreprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CPreprocessInjectorProvider.class)
public class Test0040_IfDefSimple {
	@Inject
	private ParseHelper<Model> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalCPreprocessLexer lexer;
	@Inject
	private CPreprocessParser parser;
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
	
	@Before
	public void initialize(){
		this.testHelper = new LexerAndParserTest(lexer, 
			parser, tokenDefProvider);
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
			"res/Test0040_IfDefSimple.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_IFDEF", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				"RULE_WS", 
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_WS", 
				"RULE_SPECIAL", 
				"RULE_SPECIAL", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_ENDIF", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0040_IfDefSimple.c");
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
		Assert.assertEquals(3, Lines_2_list.size());
		//2
		final PreprocessorDirectives PreprocessorDirectives_3_Var
		 = (PreprocessorDirectives)Lines_2_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_3_Var
		);
		//3
		final DefineObjectMacro DefineObjectMacro_4_Var
		 = (DefineObjectMacro)PreprocessorDirectives_3_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_4_Var
		);
		Assert.assertEquals("FOOBAR", DefineObjectMacro_4_Var
		.getId());
		Assert.assertEquals("foobar", DefineObjectMacro_4_Var
		.getString());
		//4
		final PreprocessorDirectives PreprocessorDirectives_5_Var
		 = (PreprocessorDirectives)Lines_2_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_5_Var
		);
		//5
		final ConditionalDirective ConditionalDirective_6_Var
		 = (ConditionalDirective)PreprocessorDirectives_5_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_6_Var
		);
		Assert.assertEquals("FOOBAR", ConditionalDirective_6_Var
		.getId());
		//6
		final GroupOpt GroupOpt_7_Var
		 = (GroupOpt)ConditionalDirective_6_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_7_Var
		);
		final EList<? extends EObject> Lines_7_list = GroupOpt_7_Var
		.getLines();
		Assert.assertNotNull(Lines_7_list);
		Assert.assertEquals(2, Lines_7_list.size());
		//7
		final PreprocessorDirectives PreprocessorDirectives_8_Var
		 = (PreprocessorDirectives)Lines_7_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_8_Var
		);
		//8
		final DefineObjectMacro DefineObjectMacro_9_Var
		 = (DefineObjectMacro)PreprocessorDirectives_8_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_9_Var
		);
		Assert.assertEquals("FOO", DefineObjectMacro_9_Var
		.getId());
		Assert.assertEquals("BAR", DefineObjectMacro_9_Var
		.getString());
		//9
		final Code Code_10_Var
		 = (Code)Lines_7_list.get(1);
		Assert.assertNotNull(Code_10_Var
		);
		Assert.assertEquals("	int foo = 0;", Code_10_Var
		.getCode());
		//10
		final Code Code_11_Var
		 = (Code)Lines_2_list.get(2);
		Assert.assertNotNull(Code_11_Var
		);
		Assert.assertEquals("FOO", Code_11_Var
		.getCode());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0040_IfDefSimple.c");
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
				method.invoke(this.generator, "Test0040_IfDefSimple.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0040_IfDefSimple.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0040_IfDefSimple.c"
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


