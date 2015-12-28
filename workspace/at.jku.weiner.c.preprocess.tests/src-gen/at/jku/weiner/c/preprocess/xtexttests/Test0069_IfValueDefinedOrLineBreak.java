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
import at.jku.weiner.c.preprocess.preprocess.DefineDirective;
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
import at.jku.weiner.c.common.common.Expression;
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
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0069_IfValueDefinedOrLineBreak {
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
			"res/Test0069_IfValueDefinedOrLineBreak.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_IF", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_DEFINED", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_LINEBREAK", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_SKW_OROR", 
				"RULE_WHITESPACE", 
				"RULE_DEFINED", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
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
			"res/Test0069_IfValueDefinedOrLineBreak.c");
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
		Assert.assertEquals(2, Lines_1_list.size());
		//1
		final PreprocessorDirectives PreprocessorDirectives_2_Var
		 = (PreprocessorDirectives)Lines_1_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_2_Var
		);
		//2
		final DefineDirective DefineDirective_3_Var
		 = (DefineDirective)PreprocessorDirectives_2_Var
		.getDirective();
		Assert.assertNotNull(DefineDirective_3_Var
		);
		Assert.assertEquals("__STDC_VERSION__", DefineDirective_3_Var
		.getId());
		Assert.assertEquals("201300UL", DefineDirective_3_Var
		.getString());
		//3
		final PreprocessorDirectives PreprocessorDirectives_4_Var
		 = (PreprocessorDirectives)Lines_1_list.get(1);
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
		final ConstantExpression ConstantExpression_7_Var
		 = (ConstantExpression)IfConditional_6_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_7_Var
		);
		//7
		final ConditionalExpression ConditionalExpression_8_Var
		 = (ConditionalExpression)ConstantExpression_7_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_8_Var
		);
		//8
		final LogicalOrExpression LogicalOrExpression_9_Var
		 = (LogicalOrExpression)ConditionalExpression_8_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_9_Var
		);
		final EList<? extends EObject> Expr_9_list = LogicalOrExpression_9_Var
		.getExpr();
		Assert.assertNotNull(Expr_9_list);
		Assert.assertEquals(1, Expr_9_list.size());
		//9
		final LogicalAndExpression LogicalAndExpression_10_Var
		 = (LogicalAndExpression)Expr_9_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_10_Var
		);
		final EList<? extends EObject> Expr_10_list = LogicalAndExpression_10_Var
		.getExpr();
		Assert.assertNotNull(Expr_10_list);
		Assert.assertEquals(1, Expr_10_list.size());
		//10
		final InclusiveOrExpression InclusiveOrExpression_11_Var
		 = (InclusiveOrExpression)Expr_10_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_11_Var
		);
		final EList<? extends EObject> Expr_11_list = InclusiveOrExpression_11_Var
		.getExpr();
		Assert.assertNotNull(Expr_11_list);
		Assert.assertEquals(1, Expr_11_list.size());
		//11
		final ExclusiveOrExpression ExclusiveOrExpression_12_Var
		 = (ExclusiveOrExpression)Expr_11_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_12_Var
		);
		final EList<? extends EObject> Expr_12_list = ExclusiveOrExpression_12_Var
		.getExpr();
		Assert.assertNotNull(Expr_12_list);
		Assert.assertEquals(1, Expr_12_list.size());
		//12
		final AndExpression AndExpression_13_Var
		 = (AndExpression)Expr_12_list.get(0);
		Assert.assertNotNull(AndExpression_13_Var
		);
		final EList<? extends EObject> Expr_13_list = AndExpression_13_Var
		.getExpr();
		Assert.assertNotNull(Expr_13_list);
		Assert.assertEquals(1, Expr_13_list.size());
		//13
		final EqualityExpression EqualityExpression_14_Var
		 = (EqualityExpression)Expr_13_list.get(0);
		Assert.assertNotNull(EqualityExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = EqualityExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		//14
		final RelationalExpression RelationalExpression_15_Var
		 = (RelationalExpression)Expr_14_list.get(0);
		Assert.assertNotNull(RelationalExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = RelationalExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final ShiftExpression ShiftExpression_16_Var
		 = (ShiftExpression)Expr_15_list.get(0);
		Assert.assertNotNull(ShiftExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = ShiftExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final AdditiveExpression AdditiveExpression_17_Var
		 = (AdditiveExpression)Expr_16_list.get(0);
		Assert.assertNotNull(AdditiveExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = AdditiveExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final MultiplicativeExpression MultiplicativeExpression_18_Var
		 = (MultiplicativeExpression)Expr_17_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = MultiplicativeExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final CastExpression CastExpression_19_Var
		 = (CastExpression)Expr_18_list.get(0);
		Assert.assertNotNull(CastExpression_19_Var
		);
		//19
		final UnaryExpression UnaryExpression_20_Var
		 = (UnaryExpression)CastExpression_19_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_20_Var
		);
		//20
		final PostfixExpression PostfixExpression_21_Var
		 = (PostfixExpression)UnaryExpression_20_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_21_Var
		);
		//21
		final PrimaryExpression PrimaryExpression_22_Var
		 = (PrimaryExpression)PostfixExpression_21_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_22_Var
		);
		//22
		final Expression Expression_23_Var
		 = (Expression)PrimaryExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expression_23_Var
		);
		//23
		final ConditionalExpression ConditionalExpression_24_Var
		 = (ConditionalExpression)Expression_23_Var
		.getExpression();
		Assert.assertNotNull(ConditionalExpression_24_Var
		);
		//24
		final LogicalOrExpression LogicalOrExpression_25_Var
		 = (LogicalOrExpression)ConditionalExpression_24_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = LogicalOrExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(2, Expr_25_list.size());
		//25
		final LogicalAndExpression LogicalAndExpression_26_Var
		 = (LogicalAndExpression)Expr_25_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = LogicalAndExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final InclusiveOrExpression InclusiveOrExpression_27_Var
		 = (InclusiveOrExpression)Expr_26_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = InclusiveOrExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final ExclusiveOrExpression ExclusiveOrExpression_28_Var
		 = (ExclusiveOrExpression)Expr_27_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = ExclusiveOrExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final AndExpression AndExpression_29_Var
		 = (AndExpression)Expr_28_list.get(0);
		Assert.assertNotNull(AndExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = AndExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final EqualityExpression EqualityExpression_30_Var
		 = (EqualityExpression)Expr_29_list.get(0);
		Assert.assertNotNull(EqualityExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = EqualityExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final RelationalExpression RelationalExpression_31_Var
		 = (RelationalExpression)Expr_30_list.get(0);
		Assert.assertNotNull(RelationalExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = RelationalExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final ShiftExpression ShiftExpression_32_Var
		 = (ShiftExpression)Expr_31_list.get(0);
		Assert.assertNotNull(ShiftExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = ShiftExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final AdditiveExpression AdditiveExpression_33_Var
		 = (AdditiveExpression)Expr_32_list.get(0);
		Assert.assertNotNull(AdditiveExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = AdditiveExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final MultiplicativeExpression MultiplicativeExpression_34_Var
		 = (MultiplicativeExpression)Expr_33_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = MultiplicativeExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final CastExpression CastExpression_35_Var
		 = (CastExpression)Expr_34_list.get(0);
		Assert.assertNotNull(CastExpression_35_Var
		);
		//35
		final UnaryExpression UnaryExpression_36_Var
		 = (UnaryExpression)CastExpression_35_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_36_Var
		);
		//36
		final PostfixExpression PostfixExpression_37_Var
		 = (PostfixExpression)UnaryExpression_36_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_37_Var
		);
		//37
		final PrimaryExpression PrimaryExpression_38_Var
		 = (PrimaryExpression)PostfixExpression_37_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_38_Var
		);
		Assert.assertTrue(PrimaryExpression_38_Var
		.isDefined());
		Assert.assertEquals("__STDC_VERSION__", PrimaryExpression_38_Var
		.getId());
		//38
		final LogicalAndExpression LogicalAndExpression_39_Var
		 = (LogicalAndExpression)Expr_25_list.get(1);
		Assert.assertNotNull(LogicalAndExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = LogicalAndExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final InclusiveOrExpression InclusiveOrExpression_40_Var
		 = (InclusiveOrExpression)Expr_39_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = InclusiveOrExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final ExclusiveOrExpression ExclusiveOrExpression_41_Var
		 = (ExclusiveOrExpression)Expr_40_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = ExclusiveOrExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final AndExpression AndExpression_42_Var
		 = (AndExpression)Expr_41_list.get(0);
		Assert.assertNotNull(AndExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = AndExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final EqualityExpression EqualityExpression_43_Var
		 = (EqualityExpression)Expr_42_list.get(0);
		Assert.assertNotNull(EqualityExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = EqualityExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final RelationalExpression RelationalExpression_44_Var
		 = (RelationalExpression)Expr_43_list.get(0);
		Assert.assertNotNull(RelationalExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = RelationalExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final ShiftExpression ShiftExpression_45_Var
		 = (ShiftExpression)Expr_44_list.get(0);
		Assert.assertNotNull(ShiftExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = ShiftExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final AdditiveExpression AdditiveExpression_46_Var
		 = (AdditiveExpression)Expr_45_list.get(0);
		Assert.assertNotNull(AdditiveExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = AdditiveExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final MultiplicativeExpression MultiplicativeExpression_47_Var
		 = (MultiplicativeExpression)Expr_46_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = MultiplicativeExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final CastExpression CastExpression_48_Var
		 = (CastExpression)Expr_47_list.get(0);
		Assert.assertNotNull(CastExpression_48_Var
		);
		//48
		final UnaryExpression UnaryExpression_49_Var
		 = (UnaryExpression)CastExpression_48_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_49_Var
		);
		//49
		final PostfixExpression PostfixExpression_50_Var
		 = (PostfixExpression)UnaryExpression_49_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_50_Var
		);
		//50
		final PrimaryExpression PrimaryExpression_51_Var
		 = (PrimaryExpression)PostfixExpression_50_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_51_Var
		);
		Assert.assertTrue(PrimaryExpression_51_Var
		.isDefined());
		Assert.assertEquals("__GCC_VERSION__", PrimaryExpression_51_Var
		.getId());
		//51
		final GroupOpt GroupOpt_52_Var
		 = (GroupOpt)IfConditional_6_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_52_Var
		);
		final EList<? extends EObject> Lines_52_list = GroupOpt_52_Var
		.getLines();
		Assert.assertNotNull(Lines_52_list);
		Assert.assertEquals(1, Lines_52_list.size());
		//52
		final Code Code_53_Var
		 = (Code)Lines_52_list.get(0);
		Assert.assertNotNull(Code_53_Var
		);
		Assert.assertEquals("	void c11_extension();", Code_53_Var
		.getCode());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0069_IfValueDefinedOrLineBreak.c");
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
				method.invoke(this.generator, "Test0069_IfValueDefinedOrLineBreak.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0069_IfValueDefinedOrLineBreak.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0069_IfValueDefinedOrLineBreak.c"
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


