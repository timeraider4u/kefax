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
import at.jku.weiner.c.preprocess.tests.PreprocessInjectorProvider;
import at.jku.weiner.c.preprocess.parser.antlr.PreprocessParser;
import at.jku.weiner.c.preprocess.parser.antlr.internal.InternalPreprocessLexer;
import at.jku.weiner.c.preprocess.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.preprocess.preprocess.Model;
import at.jku.weiner.c.preprocess.preprocess.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineDirective;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.ConditionalDirective;
import at.jku.weiner.c.preprocess.preprocess.IfConditional;
import at.jku.weiner.c.preprocess.preprocess.ConstantExpression;
import at.jku.weiner.c.preprocess.preprocess.ConditionalExpression;
import at.jku.weiner.c.preprocess.preprocess.LogicalOrExpression;
import at.jku.weiner.c.preprocess.preprocess.LogicalAndExpression;
import at.jku.weiner.c.preprocess.preprocess.InclusiveOrExpression;
import at.jku.weiner.c.preprocess.preprocess.ExclusiveOrExpression;
import at.jku.weiner.c.preprocess.preprocess.AndExpression;
import at.jku.weiner.c.preprocess.preprocess.EqualityExpression;
import at.jku.weiner.c.preprocess.preprocess.RelationalExpression;
import at.jku.weiner.c.preprocess.preprocess.ShiftExpression;
import at.jku.weiner.c.preprocess.preprocess.AdditiveExpression;
import at.jku.weiner.c.preprocess.preprocess.MultiplicativeExpression;
import at.jku.weiner.c.preprocess.preprocess.CastExpression;
import at.jku.weiner.c.preprocess.preprocess.UnaryExpression;
import at.jku.weiner.c.preprocess.preprocess.PostfixExpression;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.ShiftExpression;
import at.jku.weiner.c.preprocess.preprocess.AdditiveExpression;
import at.jku.weiner.c.preprocess.preprocess.MultiplicativeExpression;
import at.jku.weiner.c.preprocess.preprocess.CastExpression;
import at.jku.weiner.c.preprocess.preprocess.UnaryExpression;
import at.jku.weiner.c.preprocess.preprocess.PostfixExpression;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0044_IfValueGreater {
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
			"res/Test0044_IfValueGreater.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_IF", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_SKW_GREATEREQUAL", 
				"RULE_WS", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
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
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0044_IfValueGreater.c");
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
		Assert.assertEquals(2, Lines_2_list.size());
		//2
		final PreprocessorDirectives PreprocessorDirectives_3_Var
		 = (PreprocessorDirectives)Lines_2_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_3_Var
		);
		//3
		final DefineDirective DefineDirective_4_Var
		 = (DefineDirective)PreprocessorDirectives_3_Var
		.getDirective();
		Assert.assertNotNull(DefineDirective_4_Var
		);
		Assert.assertEquals("VERSION", DefineDirective_4_Var
		.getId());
		Assert.assertEquals("100", DefineDirective_4_Var
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
		//6
		final IfConditional IfConditional_7_Var
		 = (IfConditional)ConditionalDirective_6_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_7_Var
		);
		//7
		final ConstantExpression ConstantExpression_8_Var
		 = (ConstantExpression)IfConditional_7_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_8_Var
		);
		//8
		final ConditionalExpression ConditionalExpression_9_Var
		 = (ConditionalExpression)ConstantExpression_8_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_9_Var
		);
		//9
		final LogicalOrExpression LogicalOrExpression_10_Var
		 = (LogicalOrExpression)ConditionalExpression_9_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_10_Var
		);
		final EList<? extends EObject> Expr_10_list = LogicalOrExpression_10_Var
		.getExpr();
		Assert.assertNotNull(Expr_10_list);
		Assert.assertEquals(1, Expr_10_list.size());
		//10
		final LogicalAndExpression LogicalAndExpression_11_Var
		 = (LogicalAndExpression)Expr_10_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_11_Var
		);
		final EList<? extends EObject> Expr_11_list = LogicalAndExpression_11_Var
		.getExpr();
		Assert.assertNotNull(Expr_11_list);
		Assert.assertEquals(1, Expr_11_list.size());
		//11
		final InclusiveOrExpression InclusiveOrExpression_12_Var
		 = (InclusiveOrExpression)Expr_11_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_12_Var
		);
		final EList<? extends EObject> Expr_12_list = InclusiveOrExpression_12_Var
		.getExpr();
		Assert.assertNotNull(Expr_12_list);
		Assert.assertEquals(1, Expr_12_list.size());
		//12
		final ExclusiveOrExpression ExclusiveOrExpression_13_Var
		 = (ExclusiveOrExpression)Expr_12_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_13_Var
		);
		final EList<? extends EObject> Expr_13_list = ExclusiveOrExpression_13_Var
		.getExpr();
		Assert.assertNotNull(Expr_13_list);
		Assert.assertEquals(1, Expr_13_list.size());
		//13
		final AndExpression AndExpression_14_Var
		 = (AndExpression)Expr_13_list.get(0);
		Assert.assertNotNull(AndExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = AndExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		//14
		final EqualityExpression EqualityExpression_15_Var
		 = (EqualityExpression)Expr_14_list.get(0);
		Assert.assertNotNull(EqualityExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = EqualityExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final RelationalExpression RelationalExpression_16_Var
		 = (RelationalExpression)Expr_15_list.get(0);
		Assert.assertNotNull(RelationalExpression_16_Var
		);
		Assert.assertEquals("[>=]", RelationalExpression_16_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_16_list = RelationalExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(2, Expr_16_list.size());
		//16
		final ShiftExpression ShiftExpression_17_Var
		 = (ShiftExpression)Expr_16_list.get(0);
		Assert.assertNotNull(ShiftExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = ShiftExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final AdditiveExpression AdditiveExpression_18_Var
		 = (AdditiveExpression)Expr_17_list.get(0);
		Assert.assertNotNull(AdditiveExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = AdditiveExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final MultiplicativeExpression MultiplicativeExpression_19_Var
		 = (MultiplicativeExpression)Expr_18_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = MultiplicativeExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final CastExpression CastExpression_20_Var
		 = (CastExpression)Expr_19_list.get(0);
		Assert.assertNotNull(CastExpression_20_Var
		);
		//20
		final UnaryExpression UnaryExpression_21_Var
		 = (UnaryExpression)CastExpression_20_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_21_Var
		);
		//21
		final PostfixExpression PostfixExpression_22_Var
		 = (PostfixExpression)UnaryExpression_21_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_22_Var
		);
		//22
		final PrimaryExpression PrimaryExpression_23_Var
		 = (PrimaryExpression)PostfixExpression_22_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_23_Var
		);
		Assert.assertEquals("VERSION", PrimaryExpression_23_Var
		.getId());
		//23
		final ShiftExpression ShiftExpression_24_Var
		 = (ShiftExpression)Expr_16_list.get(1);
		Assert.assertNotNull(ShiftExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = ShiftExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final AdditiveExpression AdditiveExpression_25_Var
		 = (AdditiveExpression)Expr_24_list.get(0);
		Assert.assertNotNull(AdditiveExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = AdditiveExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final MultiplicativeExpression MultiplicativeExpression_26_Var
		 = (MultiplicativeExpression)Expr_25_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = MultiplicativeExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final CastExpression CastExpression_27_Var
		 = (CastExpression)Expr_26_list.get(0);
		Assert.assertNotNull(CastExpression_27_Var
		);
		//27
		final UnaryExpression UnaryExpression_28_Var
		 = (UnaryExpression)CastExpression_27_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_28_Var
		);
		//28
		final PostfixExpression PostfixExpression_29_Var
		 = (PostfixExpression)UnaryExpression_28_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_29_Var
		);
		//29
		final PrimaryExpression PrimaryExpression_30_Var
		 = (PrimaryExpression)PostfixExpression_29_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_30_Var
		);
		Assert.assertEquals("200", PrimaryExpression_30_Var
		.getConst());
		//30
		final GroupOpt GroupOpt_31_Var
		 = (GroupOpt)IfConditional_7_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_31_Var
		);
		final EList<? extends EObject> Lines_31_list = GroupOpt_31_Var
		.getLines();
		Assert.assertNotNull(Lines_31_list);
		Assert.assertEquals(1, Lines_31_list.size());
		//31
		final Code Code_32_Var
		 = (Code)Lines_31_list.get(0);
		Assert.assertNotNull(Code_32_Var
		);
		Assert.assertEquals("	void api_version_2();", Code_32_Var
		.getCode());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0044_IfValueGreater.c");
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
				method.invoke(this.generator, "Test0044_IfValueGreater.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0044_IfValueGreater.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0044_IfValueGreater.c"
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


