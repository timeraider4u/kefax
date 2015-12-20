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
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
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
import at.jku.weiner.c.common.common.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.common.common.ArgumentExpressionList;
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
public class Test0071_IfMin {
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
			"res/Test0071_IfMin.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_LINE_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_IF", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_RIGHTPAREN", 
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
			"res/Test0071_IfMin.c");
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
		final NewLineLine NewLineLine_3_Var
		 = (NewLineLine)Lines_2_list.get(0);
		Assert.assertNotNull(NewLineLine_3_Var
		);
		//3
		final PreprocessorDirectives PreprocessorDirectives_4_Var
		 = (PreprocessorDirectives)Lines_2_list.get(1);
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
		Assert.assertEquals("[>=]", RelationalExpression_15_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_15_list = RelationalExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(2, Expr_15_list.size());
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
		Assert.assertEquals("MIN", PrimaryExpression_22_Var
		.getId());
		final EList<? extends EObject> Suffix_22_list = PostfixExpression_21_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_22_list);
		Assert.assertEquals(1, Suffix_22_list.size());
		//22
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_23_Var
		 = (PostfixExpressionSuffixArgument)Suffix_22_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_23_Var
		);
		//23
		final ArgumentExpressionList ArgumentExpressionList_24_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_23_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_24_Var
		);
		final EList<? extends EObject> Expr_24_list = ArgumentExpressionList_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(2, Expr_24_list.size());
		//24
		final ConditionalExpression ConditionalExpression_25_Var
		 = (ConditionalExpression)Expr_24_list.get(0);
		Assert.assertNotNull(ConditionalExpression_25_Var
		);
		//25
		final LogicalOrExpression LogicalOrExpression_26_Var
		 = (LogicalOrExpression)ConditionalExpression_25_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = LogicalOrExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final LogicalAndExpression LogicalAndExpression_27_Var
		 = (LogicalAndExpression)Expr_26_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = LogicalAndExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final InclusiveOrExpression InclusiveOrExpression_28_Var
		 = (InclusiveOrExpression)Expr_27_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = InclusiveOrExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final ExclusiveOrExpression ExclusiveOrExpression_29_Var
		 = (ExclusiveOrExpression)Expr_28_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = ExclusiveOrExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final AndExpression AndExpression_30_Var
		 = (AndExpression)Expr_29_list.get(0);
		Assert.assertNotNull(AndExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = AndExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final EqualityExpression EqualityExpression_31_Var
		 = (EqualityExpression)Expr_30_list.get(0);
		Assert.assertNotNull(EqualityExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = EqualityExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final RelationalExpression RelationalExpression_32_Var
		 = (RelationalExpression)Expr_31_list.get(0);
		Assert.assertNotNull(RelationalExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = RelationalExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final ShiftExpression ShiftExpression_33_Var
		 = (ShiftExpression)Expr_32_list.get(0);
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
		Assert.assertEquals("0", PrimaryExpression_39_Var
		.getConst());
		//39
		final ConditionalExpression ConditionalExpression_40_Var
		 = (ConditionalExpression)Expr_24_list.get(1);
		Assert.assertNotNull(ConditionalExpression_40_Var
		);
		//40
		final LogicalOrExpression LogicalOrExpression_41_Var
		 = (LogicalOrExpression)ConditionalExpression_40_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = LogicalOrExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final LogicalAndExpression LogicalAndExpression_42_Var
		 = (LogicalAndExpression)Expr_41_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = LogicalAndExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final InclusiveOrExpression InclusiveOrExpression_43_Var
		 = (InclusiveOrExpression)Expr_42_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = InclusiveOrExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final ExclusiveOrExpression ExclusiveOrExpression_44_Var
		 = (ExclusiveOrExpression)Expr_43_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = ExclusiveOrExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final AndExpression AndExpression_45_Var
		 = (AndExpression)Expr_44_list.get(0);
		Assert.assertNotNull(AndExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = AndExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final EqualityExpression EqualityExpression_46_Var
		 = (EqualityExpression)Expr_45_list.get(0);
		Assert.assertNotNull(EqualityExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = EqualityExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final RelationalExpression RelationalExpression_47_Var
		 = (RelationalExpression)Expr_46_list.get(0);
		Assert.assertNotNull(RelationalExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = RelationalExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final ShiftExpression ShiftExpression_48_Var
		 = (ShiftExpression)Expr_47_list.get(0);
		Assert.assertNotNull(ShiftExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = ShiftExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final AdditiveExpression AdditiveExpression_49_Var
		 = (AdditiveExpression)Expr_48_list.get(0);
		Assert.assertNotNull(AdditiveExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = AdditiveExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final MultiplicativeExpression MultiplicativeExpression_50_Var
		 = (MultiplicativeExpression)Expr_49_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = MultiplicativeExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final CastExpression CastExpression_51_Var
		 = (CastExpression)Expr_50_list.get(0);
		Assert.assertNotNull(CastExpression_51_Var
		);
		//51
		final UnaryExpression UnaryExpression_52_Var
		 = (UnaryExpression)CastExpression_51_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_52_Var
		);
		//52
		final PostfixExpression PostfixExpression_53_Var
		 = (PostfixExpression)UnaryExpression_52_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_53_Var
		);
		//53
		final PrimaryExpression PrimaryExpression_54_Var
		 = (PrimaryExpression)PostfixExpression_53_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_54_Var
		);
		Assert.assertEquals("6", PrimaryExpression_54_Var
		.getConst());
		//54
		final ShiftExpression ShiftExpression_55_Var
		 = (ShiftExpression)Expr_15_list.get(1);
		Assert.assertNotNull(ShiftExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = ShiftExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final AdditiveExpression AdditiveExpression_56_Var
		 = (AdditiveExpression)Expr_55_list.get(0);
		Assert.assertNotNull(AdditiveExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = AdditiveExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final MultiplicativeExpression MultiplicativeExpression_57_Var
		 = (MultiplicativeExpression)Expr_56_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = MultiplicativeExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final CastExpression CastExpression_58_Var
		 = (CastExpression)Expr_57_list.get(0);
		Assert.assertNotNull(CastExpression_58_Var
		);
		//58
		final UnaryExpression UnaryExpression_59_Var
		 = (UnaryExpression)CastExpression_58_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_59_Var
		);
		//59
		final PostfixExpression PostfixExpression_60_Var
		 = (PostfixExpression)UnaryExpression_59_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_60_Var
		);
		//60
		final PrimaryExpression PrimaryExpression_61_Var
		 = (PrimaryExpression)PostfixExpression_60_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_61_Var
		);
		Assert.assertEquals("5", PrimaryExpression_61_Var
		.getConst());
		//61
		final GroupOpt GroupOpt_62_Var
		 = (GroupOpt)IfConditional_6_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_62_Var
		);
		final EList<? extends EObject> Lines_62_list = GroupOpt_62_Var
		.getLines();
		Assert.assertNotNull(Lines_62_list);
		Assert.assertEquals(1, Lines_62_list.size());
		//62
		final Code Code_63_Var
		 = (Code)Lines_62_list.get(0);
		Assert.assertNotNull(Code_63_Var
		);
		Assert.assertEquals("	void greaterEqualFive();", Code_63_Var
		.getCode());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0071_IfMin.c");
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
				method.invoke(this.generator, "Test0071_IfMin.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0071_IfMin.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0071_IfMin.c"
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


