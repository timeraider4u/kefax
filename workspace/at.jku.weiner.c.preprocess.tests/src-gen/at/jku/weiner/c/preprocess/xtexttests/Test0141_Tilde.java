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
import at.jku.weiner.c.preprocess.preprocess.ConditionalDirective;
import at.jku.weiner.c.preprocess.preprocess.IfConditional;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.common.common.EqualityExpression;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.common.common.UnaryExpression;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0141_Tilde {
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
			"res/Test0141_Tilde.c");
			final String[] expected = new String[] {
				"RULE_HASH",
				"RULE_IF",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_TILDE",
				"RULE_SKW_LEFTPAREN",
				"RULE_HEX_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_EQUAL",
				"RULE_WHITESPACE",
				"RULE_HEX_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
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
			"res/Test0141_Tilde.c");
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
		Assert.assertEquals(1, Lines_1_list.size());
		//1
		final PreprocessorDirectives PreprocessorDirectives_2_Var
		 = (PreprocessorDirectives)Lines_1_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_2_Var
		);
		//2
		final ConditionalDirective ConditionalDirective_3_Var
		 = (ConditionalDirective)PreprocessorDirectives_2_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_3_Var
		);
		//3
		final IfConditional IfConditional_4_Var
		 = (IfConditional)ConditionalDirective_3_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_4_Var
		);
		//4
		final PrimaryExpression PrimaryExpression_5_Var
		 = (PrimaryExpression)IfConditional_4_Var
		.getExpression();
		Assert.assertNotNull(PrimaryExpression_5_Var
		);
		Assert.assertTrue(PrimaryExpression_5_Var
		.isParentheses());
		//5
		final EqualityExpression EqualityExpression_6_Var
		 = (EqualityExpression)PrimaryExpression_5_Var
		.getExpr();
		Assert.assertNotNull(EqualityExpression_6_Var
		);
		Assert.assertEquals("==", EqualityExpression_6_Var
		.getOp());
		//6
		final PrimaryExpression PrimaryExpression_7_Var
		 = (PrimaryExpression)EqualityExpression_6_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_7_Var
		);
		Assert.assertTrue(PrimaryExpression_7_Var
		.isParentheses());
		//7
		final UnaryExpression UnaryExpression_8_Var
		 = (UnaryExpression)PrimaryExpression_7_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_8_Var
		);
		Assert.assertEquals("~", UnaryExpression_8_Var
		.getOp());
		//8
		final PrimaryExpression PrimaryExpression_9_Var
		 = (PrimaryExpression)UnaryExpression_8_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_9_Var
		);
		Assert.assertTrue(PrimaryExpression_9_Var
		.isParentheses());
		//9
		final PrimaryExpression PrimaryExpression_10_Var
		 = (PrimaryExpression)PrimaryExpression_9_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_10_Var
		);
		Assert.assertEquals("0x2B992DDFA23249D6", PrimaryExpression_10_Var
		.getConst());
		//10
		final PrimaryExpression PrimaryExpression_11_Var
		 = (PrimaryExpression)EqualityExpression_6_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_11_Var
		);
		Assert.assertEquals("0xD466D2205DCDB629", PrimaryExpression_11_Var
		.getConst());
		//11
		final GroupOpt GroupOpt_12_Var
		 = (GroupOpt)IfConditional_4_Var
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
		Assert.assertEquals("	long i = 9;", Code_13_Var
		.getCode());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0141_Tilde.c");
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
				method.invoke(this.generator, "Test0141_Tilde.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0141_Tilde.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0141_Tilde.c"
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

