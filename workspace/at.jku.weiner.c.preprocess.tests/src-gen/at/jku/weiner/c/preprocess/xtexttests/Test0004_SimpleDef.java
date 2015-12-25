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

import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineDirective;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineDirective;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineDirective;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineDirective;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineDirective;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineDirective;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0004_SimpleDef {
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
			"res/Test0004_SimpleDef.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_FLOAT_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_LINE_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_MINUS", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_SKW_RIGHTBRACE", 
				"RULE_NEWLINE", 
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0004_SimpleDef.c");
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
		final Preprocess Preprocess_2_Var
		 = (Preprocess)TranslationUnit_1_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_2_Var
		);
		//2
		final GroupOpt GroupOpt_3_Var
		 = (GroupOpt)Preprocess_2_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_3_Var
		);
		final EList<? extends EObject> Lines_3_list = GroupOpt_3_Var
		.getLines();
		Assert.assertNotNull(Lines_3_list);
		Assert.assertEquals(15, Lines_3_list.size());
		//3
		final PreprocessorDirectives PreprocessorDirectives_4_Var
		 = (PreprocessorDirectives)Lines_3_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_4_Var
		);
		//4
		final DefineDirective DefineDirective_5_Var
		 = (DefineDirective)PreprocessorDirectives_4_Var
		.getDirective();
		Assert.assertNotNull(DefineDirective_5_Var
		);
		Assert.assertEquals("PI", DefineDirective_5_Var
		.getId());
		Assert.assertEquals("3.1415926535897932", DefineDirective_5_Var
		.getString());
		//5
		final PreprocessorDirectives PreprocessorDirectives_6_Var
		 = (PreprocessorDirectives)Lines_3_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_6_Var
		);
		//6
		final DefineDirective DefineDirective_7_Var
		 = (DefineDirective)PreprocessorDirectives_6_Var
		.getDirective();
		Assert.assertNotNull(DefineDirective_7_Var
		);
		Assert.assertEquals("NAME", DefineDirective_7_Var
		.getId());
		Assert.assertEquals("\"Nobody\"", DefineDirective_7_Var
		.getString());
		//7
		final PreprocessorDirectives PreprocessorDirectives_8_Var
		 = (PreprocessorDirectives)Lines_3_list.get(2);
		Assert.assertNotNull(PreprocessorDirectives_8_Var
		);
		//8
		final DefineDirective DefineDirective_9_Var
		 = (DefineDirective)PreprocessorDirectives_8_Var
		.getDirective();
		Assert.assertNotNull(DefineDirective_9_Var
		);
		Assert.assertEquals("NUMBER", DefineDirective_9_Var
		.getId());
		Assert.assertEquals("2", DefineDirective_9_Var
		.getString());
		//9
		final NewLineLine NewLineLine_10_Var
		 = (NewLineLine)Lines_3_list.get(3);
		Assert.assertNotNull(NewLineLine_10_Var
		);
		//10
		final PreprocessorDirectives PreprocessorDirectives_11_Var
		 = (PreprocessorDirectives)Lines_3_list.get(4);
		Assert.assertNotNull(PreprocessorDirectives_11_Var
		);
		//11
		final DefineDirective DefineDirective_12_Var
		 = (DefineDirective)PreprocessorDirectives_11_Var
		.getDirective();
		Assert.assertNotNull(DefineDirective_12_Var
		);
		Assert.assertEquals("X", DefineDirective_12_Var
		.getId());
		Assert.assertEquals("NUMBER", DefineDirective_12_Var
		.getString());
		//12
		final NewLineLine NewLineLine_13_Var
		 = (NewLineLine)Lines_3_list.get(5);
		Assert.assertNotNull(NewLineLine_13_Var
		);
		//13
		final PreprocessorDirectives PreprocessorDirectives_14_Var
		 = (PreprocessorDirectives)Lines_3_list.get(6);
		Assert.assertNotNull(PreprocessorDirectives_14_Var
		);
		//14
		final DefineDirective DefineDirective_15_Var
		 = (DefineDirective)PreprocessorDirectives_14_Var
		.getDirective();
		Assert.assertNotNull(DefineDirective_15_Var
		);
		Assert.assertEquals("MAIN", DefineDirective_15_Var
		.getId());
		Assert.assertEquals("int main(void)", DefineDirective_15_Var
		.getString());
		//15
		final NewLineLine NewLineLine_16_Var
		 = (NewLineLine)Lines_3_list.get(7);
		Assert.assertNotNull(NewLineLine_16_Var
		);
		//16
		final NewLineLine NewLineLine_17_Var
		 = (NewLineLine)Lines_3_list.get(8);
		Assert.assertNotNull(NewLineLine_17_Var
		);
		//17
		final PreprocessorDirectives PreprocessorDirectives_18_Var
		 = (PreprocessorDirectives)Lines_3_list.get(9);
		Assert.assertNotNull(PreprocessorDirectives_18_Var
		);
		//18
		final DefineDirective DefineDirective_19_Var
		 = (DefineDirective)PreprocessorDirectives_18_Var
		.getDirective();
		Assert.assertNotNull(DefineDirective_19_Var
		);
		Assert.assertEquals("long", DefineDirective_19_Var
		.getId());
		Assert.assertEquals("int", DefineDirective_19_Var
		.getString());
		//19
		final NewLineLine NewLineLine_20_Var
		 = (NewLineLine)Lines_3_list.get(10);
		Assert.assertNotNull(NewLineLine_20_Var
		);
		//20
		final Code Code_21_Var
		 = (Code)Lines_3_list.get(11);
		Assert.assertNotNull(Code_21_Var
		);
		Assert.assertEquals("MAIN {", Code_21_Var
		.getCode());
		//21
		final Code Code_22_Var
		 = (Code)Lines_3_list.get(12);
		Assert.assertNotNull(Code_22_Var
		);
		Assert.assertEquals("	long d = X - NUMBER;", Code_22_Var
		.getCode());
		//22
		final Code Code_23_Var
		 = (Code)Lines_3_list.get(13);
		Assert.assertNotNull(Code_23_Var
		);
		Assert.assertEquals("	return d;", Code_23_Var
		.getCode());
		//23
		final Code Code_24_Var
		 = (Code)Lines_3_list.get(14);
		Assert.assertNotNull(Code_24_Var
		);
		Assert.assertEquals("}", Code_24_Var
		.getCode());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0004_SimpleDef.c");
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
				method.invoke(this.generator, "Test0004_SimpleDef.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0004_SimpleDef.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0004_SimpleDef.c"
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


