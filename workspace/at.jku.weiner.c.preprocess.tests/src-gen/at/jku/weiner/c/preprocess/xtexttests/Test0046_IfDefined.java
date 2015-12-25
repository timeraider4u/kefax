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
import at.jku.weiner.c.common.common.ConstantExpression;
import at.jku.weiner.c.common.common.ConditionalExpression;
import at.jku.weiner.c.common.common.LogicalOrExpression;
import at.jku.weiner.c.common.common.LogicalAndExpression;
import at.jku.weiner.c.common.common.InclusiveOrExpression;
import at.jku.weiner.c.common.common.ExclusiveOrExpression;
import at.jku.weiner.c.common.common.AndExpression;
import at.jku.weiner.c.common.common.EqualityExpression;
import at.jku.weiner.c.common.common.RelationalExpression;
import at.jku.weiner.c.common.common.ShiftExpression;
import at.jku.weiner.c.common.common.AdditiveExpression;
import at.jku.weiner.c.common.common.MultiplicativeExpression;
import at.jku.weiner.c.common.common.CastExpression;
import at.jku.weiner.c.common.common.UnaryExpression;
import at.jku.weiner.c.common.common.PostfixExpression;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.common.common.InclusiveOrExpression;
import at.jku.weiner.c.common.common.ExclusiveOrExpression;
import at.jku.weiner.c.common.common.AndExpression;
import at.jku.weiner.c.common.common.EqualityExpression;
import at.jku.weiner.c.common.common.RelationalExpression;
import at.jku.weiner.c.common.common.ShiftExpression;
import at.jku.weiner.c.common.common.AdditiveExpression;
import at.jku.weiner.c.common.common.MultiplicativeExpression;
import at.jku.weiner.c.common.common.CastExpression;
import at.jku.weiner.c.common.common.UnaryExpression;
import at.jku.weiner.c.common.common.PostfixExpression;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.common.common.ShiftExpression;
import at.jku.weiner.c.common.common.AdditiveExpression;
import at.jku.weiner.c.common.common.MultiplicativeExpression;
import at.jku.weiner.c.common.common.CastExpression;
import at.jku.weiner.c.common.common.UnaryExpression;
import at.jku.weiner.c.common.common.PostfixExpression;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0046_IfDefined {
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
	
	@Test
	public void checkLexerTokens() throws Exception{
		final String text = this.getTextFromFile(
			"res/Test0046_IfDefined.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_HASH", 
				"RULE_IF", 
				"RULE_WHITESPACE", 
				"RULE_DEFINED", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ANDAND", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_GREATEREQUAL", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
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
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0046_IfDefined.c");
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
		final ConstantExpression ConstantExpression_5_Var
		 = (ConstantExpression)IfConditional_4_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_5_Var
		);
		//5
		final ConditionalExpression ConditionalExpression_6_Var
		 = (ConditionalExpression)ConstantExpression_5_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_6_Var
		);
		//6
		final LogicalOrExpression LogicalOrExpression_7_Var
		 = (LogicalOrExpression)ConditionalExpression_6_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_7_Var
		);
		final EList<? extends EObject> Expr_7_list = LogicalOrExpression_7_Var
		.getExpr();
		Assert.assertNotNull(Expr_7_list);
		Assert.assertEquals(1, Expr_7_list.size());
		//7
		final LogicalAndExpression LogicalAndExpression_8_Var
		 = (LogicalAndExpression)Expr_7_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_8_Var
		);
		final EList<? extends EObject> Expr_8_list = LogicalAndExpression_8_Var
		.getExpr();
		Assert.assertNotNull(Expr_8_list);
		Assert.assertEquals(2, Expr_8_list.size());
		//8
		final InclusiveOrExpression InclusiveOrExpression_9_Var
		 = (InclusiveOrExpression)Expr_8_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_9_Var
		);
		final EList<? extends EObject> Expr_9_list = InclusiveOrExpression_9_Var
		.getExpr();
		Assert.assertNotNull(Expr_9_list);
		Assert.assertEquals(1, Expr_9_list.size());
		//9
		final ExclusiveOrExpression ExclusiveOrExpression_10_Var
		 = (ExclusiveOrExpression)Expr_9_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_10_Var
		);
		final EList<? extends EObject> Expr_10_list = ExclusiveOrExpression_10_Var
		.getExpr();
		Assert.assertNotNull(Expr_10_list);
		Assert.assertEquals(1, Expr_10_list.size());
		//10
		final AndExpression AndExpression_11_Var
		 = (AndExpression)Expr_10_list.get(0);
		Assert.assertNotNull(AndExpression_11_Var
		);
		final EList<? extends EObject> Expr_11_list = AndExpression_11_Var
		.getExpr();
		Assert.assertNotNull(Expr_11_list);
		Assert.assertEquals(1, Expr_11_list.size());
		//11
		final EqualityExpression EqualityExpression_12_Var
		 = (EqualityExpression)Expr_11_list.get(0);
		Assert.assertNotNull(EqualityExpression_12_Var
		);
		final EList<? extends EObject> Expr_12_list = EqualityExpression_12_Var
		.getExpr();
		Assert.assertNotNull(Expr_12_list);
		Assert.assertEquals(1, Expr_12_list.size());
		//12
		final RelationalExpression RelationalExpression_13_Var
		 = (RelationalExpression)Expr_12_list.get(0);
		Assert.assertNotNull(RelationalExpression_13_Var
		);
		final EList<? extends EObject> Expr_13_list = RelationalExpression_13_Var
		.getExpr();
		Assert.assertNotNull(Expr_13_list);
		Assert.assertEquals(1, Expr_13_list.size());
		//13
		final ShiftExpression ShiftExpression_14_Var
		 = (ShiftExpression)Expr_13_list.get(0);
		Assert.assertNotNull(ShiftExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = ShiftExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		//14
		final AdditiveExpression AdditiveExpression_15_Var
		 = (AdditiveExpression)Expr_14_list.get(0);
		Assert.assertNotNull(AdditiveExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = AdditiveExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final MultiplicativeExpression MultiplicativeExpression_16_Var
		 = (MultiplicativeExpression)Expr_15_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = MultiplicativeExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final CastExpression CastExpression_17_Var
		 = (CastExpression)Expr_16_list.get(0);
		Assert.assertNotNull(CastExpression_17_Var
		);
		//17
		final UnaryExpression UnaryExpression_18_Var
		 = (UnaryExpression)CastExpression_17_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_18_Var
		);
		//18
		final PostfixExpression PostfixExpression_19_Var
		 = (PostfixExpression)UnaryExpression_18_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_19_Var
		);
		//19
		final PrimaryExpression PrimaryExpression_20_Var
		 = (PrimaryExpression)PostfixExpression_19_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_20_Var
		);
		Assert.assertTrue(PrimaryExpression_20_Var
		.isDefined());
		Assert.assertEquals("FOO", PrimaryExpression_20_Var
		.getId());
		//20
		final InclusiveOrExpression InclusiveOrExpression_21_Var
		 = (InclusiveOrExpression)Expr_8_list.get(1);
		Assert.assertNotNull(InclusiveOrExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = InclusiveOrExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final ExclusiveOrExpression ExclusiveOrExpression_22_Var
		 = (ExclusiveOrExpression)Expr_21_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = ExclusiveOrExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final AndExpression AndExpression_23_Var
		 = (AndExpression)Expr_22_list.get(0);
		Assert.assertNotNull(AndExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = AndExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final EqualityExpression EqualityExpression_24_Var
		 = (EqualityExpression)Expr_23_list.get(0);
		Assert.assertNotNull(EqualityExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = EqualityExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final RelationalExpression RelationalExpression_25_Var
		 = (RelationalExpression)Expr_24_list.get(0);
		Assert.assertNotNull(RelationalExpression_25_Var
		);
		Assert.assertEquals("[>=]", RelationalExpression_25_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_25_list = RelationalExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(2, Expr_25_list.size());
		//25
		final ShiftExpression ShiftExpression_26_Var
		 = (ShiftExpression)Expr_25_list.get(0);
		Assert.assertNotNull(ShiftExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = ShiftExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final AdditiveExpression AdditiveExpression_27_Var
		 = (AdditiveExpression)Expr_26_list.get(0);
		Assert.assertNotNull(AdditiveExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = AdditiveExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final MultiplicativeExpression MultiplicativeExpression_28_Var
		 = (MultiplicativeExpression)Expr_27_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = MultiplicativeExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final CastExpression CastExpression_29_Var
		 = (CastExpression)Expr_28_list.get(0);
		Assert.assertNotNull(CastExpression_29_Var
		);
		//29
		final UnaryExpression UnaryExpression_30_Var
		 = (UnaryExpression)CastExpression_29_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_30_Var
		);
		//30
		final PostfixExpression PostfixExpression_31_Var
		 = (PostfixExpression)UnaryExpression_30_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_31_Var
		);
		//31
		final PrimaryExpression PrimaryExpression_32_Var
		 = (PrimaryExpression)PostfixExpression_31_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_32_Var
		);
		Assert.assertEquals("FOO", PrimaryExpression_32_Var
		.getId());
		//32
		final ShiftExpression ShiftExpression_33_Var
		 = (ShiftExpression)Expr_25_list.get(1);
		Assert.assertNotNull(ShiftExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = ShiftExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final AdditiveExpression AdditiveExpression_34_Var
		 = (AdditiveExpression)Expr_33_list.get(0);
		Assert.assertNotNull(AdditiveExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = AdditiveExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final MultiplicativeExpression MultiplicativeExpression_35_Var
		 = (MultiplicativeExpression)Expr_34_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = MultiplicativeExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final CastExpression CastExpression_36_Var
		 = (CastExpression)Expr_35_list.get(0);
		Assert.assertNotNull(CastExpression_36_Var
		);
		//36
		final UnaryExpression UnaryExpression_37_Var
		 = (UnaryExpression)CastExpression_36_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_37_Var
		);
		//37
		final PostfixExpression PostfixExpression_38_Var
		 = (PostfixExpression)UnaryExpression_37_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_38_Var
		);
		//38
		final PrimaryExpression PrimaryExpression_39_Var
		 = (PrimaryExpression)PostfixExpression_38_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_39_Var
		);
		Assert.assertEquals("64", PrimaryExpression_39_Var
		.getConst());
		//39
		final GroupOpt GroupOpt_40_Var
		 = (GroupOpt)IfConditional_4_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_40_Var
		);
		final EList<? extends EObject> Lines_40_list = GroupOpt_40_Var
		.getLines();
		Assert.assertNotNull(Lines_40_list);
		Assert.assertEquals(1, Lines_40_list.size());
		//40
		final Code Code_41_Var
		 = (Code)Lines_40_list.get(0);
		Assert.assertNotNull(Code_41_Var
		);
		Assert.assertEquals("	void size_64();", Code_41_Var
		.getCode());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0046_IfDefined.c");
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
				method.invoke(this.generator, "Test0046_IfDefined.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0046_IfDefined.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0046_IfDefined.c"
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


