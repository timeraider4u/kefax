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
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.ConditionalDirective;
import at.jku.weiner.c.preprocess.preprocess.IfConditional;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.ElIfConditional;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.ElseConditional;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0058_IfElIfElse {
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
			"res/Test0058_IfElIfElse.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_LINE_COMMENT",
				"RULE_NEWLINE",
				"RULE_LINE_COMMENT",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_IF",
				"RULE_WHITESPACE",
				"RULE_DEFINED",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_ELIF",
				"RULE_WHITESPACE",
				"RULE_DEFINED",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_ELSE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_ENDIF",
				"RULE_NEWLINE",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0058_IfElIfElse.c");
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
		Assert.assertEquals(3, Lines_1_list.size());
		//1
		final NewLineLine NewLineLine_2_Var
		 = (NewLineLine)Lines_1_list.get(0);
		Assert.assertNotNull(NewLineLine_2_Var
		);
		//2
		final NewLineLine NewLineLine_3_Var
		 = (NewLineLine)Lines_1_list.get(1);
		Assert.assertNotNull(NewLineLine_3_Var
		);
		//3
		final PreprocessorDirectives PreprocessorDirectives_4_Var
		 = (PreprocessorDirectives)Lines_1_list.get(2);
		Assert.assertNotNull(PreprocessorDirectives_4_Var
		);
		//4
		final ConditionalDirective ConditionalDirective_5_Var
		 = (ConditionalDirective)PreprocessorDirectives_4_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_5_Var
		);
		//5
		final IfConditional IfConditional_6_Var
		 = (IfConditional)ConditionalDirective_5_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_6_Var
		);
		//6
		final PrimaryExpression PrimaryExpression_7_Var
		 = (PrimaryExpression)IfConditional_6_Var
		.getExpression();
		Assert.assertNotNull(PrimaryExpression_7_Var
		);
		Assert.assertTrue(PrimaryExpression_7_Var
		.isDefined());
		Assert.assertEquals("FOO", PrimaryExpression_7_Var
		.getId());
		//7
		final GroupOpt GroupOpt_8_Var
		 = (GroupOpt)IfConditional_6_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_8_Var
		);
		final EList<? extends EObject> Lines_8_list = GroupOpt_8_Var
		.getLines();
		Assert.assertNotNull(Lines_8_list);
		Assert.assertEquals(1, Lines_8_list.size());
		//8
		final Code Code_9_Var
		 = (Code)Lines_8_list.get(0);
		Assert.assertNotNull(Code_9_Var
		);
		Assert.assertEquals("	void foo();", Code_9_Var
		.getCode());
		final EList<? extends EObject> Elifs_9_list = ConditionalDirective_5_Var
		.getElifs();
		Assert.assertNotNull(Elifs_9_list);
		Assert.assertEquals(1, Elifs_9_list.size());
		//9
		final ElIfConditional ElIfConditional_10_Var
		 = (ElIfConditional)Elifs_9_list.get(0);
		Assert.assertNotNull(ElIfConditional_10_Var
		);
		//10
		final PrimaryExpression PrimaryExpression_11_Var
		 = (PrimaryExpression)ElIfConditional_10_Var
		.getExpression();
		Assert.assertNotNull(PrimaryExpression_11_Var
		);
		Assert.assertTrue(PrimaryExpression_11_Var
		.isDefined());
		Assert.assertEquals("BAR", PrimaryExpression_11_Var
		.getId());
		//11
		final GroupOpt GroupOpt_12_Var
		 = (GroupOpt)ElIfConditional_10_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_12_Var
		);
		final EList<? extends EObject> Lines_12_list = GroupOpt_12_Var
		.getLines();
		Assert.assertNotNull(Lines_12_list);
		Assert.assertEquals(1, Lines_12_list.size());
		//12
		final Code Code_13_Var
		 = (Code)Lines_12_list.get(0);
		Assert.assertNotNull(Code_13_Var
		);
		Assert.assertEquals("	void bar();", Code_13_Var
		.getCode());
		//13
		final ElseConditional ElseConditional_14_Var
		 = (ElseConditional)ConditionalDirective_5_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_14_Var
		);
		//14
		final GroupOpt GroupOpt_15_Var
		 = (GroupOpt)ElseConditional_14_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_15_Var
		);
		final EList<? extends EObject> Lines_15_list = GroupOpt_15_Var
		.getLines();
		Assert.assertNotNull(Lines_15_list);
		Assert.assertEquals(1, Lines_15_list.size());
		//15
		final Code Code_16_Var
		 = (Code)Lines_15_list.get(0);
		Assert.assertNotNull(Code_16_Var
		);
		Assert.assertEquals("	void no_foo_and_no_bar();", Code_16_Var
		.getCode());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0058_IfElIfElse.c");
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
				method.invoke(this.generator, "Test0058_IfElIfElse.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0058_IfElIfElse.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0058_IfElIfElse.c"
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


