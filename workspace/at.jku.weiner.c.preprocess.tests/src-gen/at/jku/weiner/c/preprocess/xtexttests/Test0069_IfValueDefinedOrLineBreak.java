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
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0069_IfValueDefinedOrLineBreak.c");
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
		Assert.assertEquals(2, Lines_3_list.size());
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
		Assert.assertEquals("__STDC_VERSION__", DefineDirective_5_Var
		.getId());
		Assert.assertEquals("201300UL", DefineDirective_5_Var
		.getString());
		//5
		final PreprocessorDirectives PreprocessorDirectives_6_Var
		 = (PreprocessorDirectives)Lines_3_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_6_Var
		);
		//6
		final ConditionalDirective ConditionalDirective_7_Var
		 = (ConditionalDirective)PreprocessorDirectives_6_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_7_Var
		);
		//7
		final IfConditional IfConditional_8_Var
		 = (IfConditional)ConditionalDirective_7_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_8_Var
		);
		//8
		final ConstantExpression ConstantExpression_9_Var
		 = (ConstantExpression)IfConditional_8_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_9_Var
		);
		//9
		final ConditionalExpression ConditionalExpression_10_Var
		 = (ConditionalExpression)ConstantExpression_9_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_10_Var
		);
		//10
		final LogicalOrExpression LogicalOrExpression_11_Var
		 = (LogicalOrExpression)ConditionalExpression_10_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_11_Var
		);
		final EList<? extends EObject> Expr_11_list = LogicalOrExpression_11_Var
		.getExpr();
		Assert.assertNotNull(Expr_11_list);
		Assert.assertEquals(1, Expr_11_list.size());
		//11
		final LogicalAndExpression LogicalAndExpression_12_Var
		 = (LogicalAndExpression)Expr_11_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_12_Var
		);
		final EList<? extends EObject> Expr_12_list = LogicalAndExpression_12_Var
		.getExpr();
		Assert.assertNotNull(Expr_12_list);
		Assert.assertEquals(1, Expr_12_list.size());
		//12
		final InclusiveOrExpression InclusiveOrExpression_13_Var
		 = (InclusiveOrExpression)Expr_12_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_13_Var
		);
		final EList<? extends EObject> Expr_13_list = InclusiveOrExpression_13_Var
		.getExpr();
		Assert.assertNotNull(Expr_13_list);
		Assert.assertEquals(1, Expr_13_list.size());
		//13
		final ExclusiveOrExpression ExclusiveOrExpression_14_Var
		 = (ExclusiveOrExpression)Expr_13_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = ExclusiveOrExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		//14
		final AndExpression AndExpression_15_Var
		 = (AndExpression)Expr_14_list.get(0);
		Assert.assertNotNull(AndExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = AndExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final EqualityExpression EqualityExpression_16_Var
		 = (EqualityExpression)Expr_15_list.get(0);
		Assert.assertNotNull(EqualityExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = EqualityExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final RelationalExpression RelationalExpression_17_Var
		 = (RelationalExpression)Expr_16_list.get(0);
		Assert.assertNotNull(RelationalExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = RelationalExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final ShiftExpression ShiftExpression_18_Var
		 = (ShiftExpression)Expr_17_list.get(0);
		Assert.assertNotNull(ShiftExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = ShiftExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final AdditiveExpression AdditiveExpression_19_Var
		 = (AdditiveExpression)Expr_18_list.get(0);
		Assert.assertNotNull(AdditiveExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = AdditiveExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final MultiplicativeExpression MultiplicativeExpression_20_Var
		 = (MultiplicativeExpression)Expr_19_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = MultiplicativeExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final CastExpression CastExpression_21_Var
		 = (CastExpression)Expr_20_list.get(0);
		Assert.assertNotNull(CastExpression_21_Var
		);
		//21
		final UnaryExpression UnaryExpression_22_Var
		 = (UnaryExpression)CastExpression_21_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_22_Var
		);
		//22
		final PostfixExpression PostfixExpression_23_Var
		 = (PostfixExpression)UnaryExpression_22_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_23_Var
		);
		//23
		final PrimaryExpression PrimaryExpression_24_Var
		 = (PrimaryExpression)PostfixExpression_23_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_24_Var
		);
		//24
		final Expression Expression_25_Var
		 = (Expression)PrimaryExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expression_25_Var
		);
		//25
		final ConditionalExpression ConditionalExpression_26_Var
		 = (ConditionalExpression)Expression_25_Var
		.getExpression();
		Assert.assertNotNull(ConditionalExpression_26_Var
		);
		//26
		final LogicalOrExpression LogicalOrExpression_27_Var
		 = (LogicalOrExpression)ConditionalExpression_26_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = LogicalOrExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(2, Expr_27_list.size());
		//27
		final LogicalAndExpression LogicalAndExpression_28_Var
		 = (LogicalAndExpression)Expr_27_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = LogicalAndExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final InclusiveOrExpression InclusiveOrExpression_29_Var
		 = (InclusiveOrExpression)Expr_28_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = InclusiveOrExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final ExclusiveOrExpression ExclusiveOrExpression_30_Var
		 = (ExclusiveOrExpression)Expr_29_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = ExclusiveOrExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final AndExpression AndExpression_31_Var
		 = (AndExpression)Expr_30_list.get(0);
		Assert.assertNotNull(AndExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = AndExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final EqualityExpression EqualityExpression_32_Var
		 = (EqualityExpression)Expr_31_list.get(0);
		Assert.assertNotNull(EqualityExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = EqualityExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final RelationalExpression RelationalExpression_33_Var
		 = (RelationalExpression)Expr_32_list.get(0);
		Assert.assertNotNull(RelationalExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = RelationalExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final ShiftExpression ShiftExpression_34_Var
		 = (ShiftExpression)Expr_33_list.get(0);
		Assert.assertNotNull(ShiftExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = ShiftExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final AdditiveExpression AdditiveExpression_35_Var
		 = (AdditiveExpression)Expr_34_list.get(0);
		Assert.assertNotNull(AdditiveExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = AdditiveExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final MultiplicativeExpression MultiplicativeExpression_36_Var
		 = (MultiplicativeExpression)Expr_35_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = MultiplicativeExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final CastExpression CastExpression_37_Var
		 = (CastExpression)Expr_36_list.get(0);
		Assert.assertNotNull(CastExpression_37_Var
		);
		//37
		final UnaryExpression UnaryExpression_38_Var
		 = (UnaryExpression)CastExpression_37_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_38_Var
		);
		//38
		final PostfixExpression PostfixExpression_39_Var
		 = (PostfixExpression)UnaryExpression_38_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_39_Var
		);
		//39
		final PrimaryExpression PrimaryExpression_40_Var
		 = (PrimaryExpression)PostfixExpression_39_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_40_Var
		);
		Assert.assertTrue(PrimaryExpression_40_Var
		.isDefined());
		Assert.assertEquals("__STDC_VERSION__", PrimaryExpression_40_Var
		.getId());
		//40
		final LogicalAndExpression LogicalAndExpression_41_Var
		 = (LogicalAndExpression)Expr_27_list.get(1);
		Assert.assertNotNull(LogicalAndExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = LogicalAndExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final InclusiveOrExpression InclusiveOrExpression_42_Var
		 = (InclusiveOrExpression)Expr_41_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = InclusiveOrExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final ExclusiveOrExpression ExclusiveOrExpression_43_Var
		 = (ExclusiveOrExpression)Expr_42_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = ExclusiveOrExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final AndExpression AndExpression_44_Var
		 = (AndExpression)Expr_43_list.get(0);
		Assert.assertNotNull(AndExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = AndExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final EqualityExpression EqualityExpression_45_Var
		 = (EqualityExpression)Expr_44_list.get(0);
		Assert.assertNotNull(EqualityExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = EqualityExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final RelationalExpression RelationalExpression_46_Var
		 = (RelationalExpression)Expr_45_list.get(0);
		Assert.assertNotNull(RelationalExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = RelationalExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final ShiftExpression ShiftExpression_47_Var
		 = (ShiftExpression)Expr_46_list.get(0);
		Assert.assertNotNull(ShiftExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = ShiftExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final AdditiveExpression AdditiveExpression_48_Var
		 = (AdditiveExpression)Expr_47_list.get(0);
		Assert.assertNotNull(AdditiveExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = AdditiveExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final MultiplicativeExpression MultiplicativeExpression_49_Var
		 = (MultiplicativeExpression)Expr_48_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = MultiplicativeExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final CastExpression CastExpression_50_Var
		 = (CastExpression)Expr_49_list.get(0);
		Assert.assertNotNull(CastExpression_50_Var
		);
		//50
		final UnaryExpression UnaryExpression_51_Var
		 = (UnaryExpression)CastExpression_50_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_51_Var
		);
		//51
		final PostfixExpression PostfixExpression_52_Var
		 = (PostfixExpression)UnaryExpression_51_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_52_Var
		);
		//52
		final PrimaryExpression PrimaryExpression_53_Var
		 = (PrimaryExpression)PostfixExpression_52_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_53_Var
		);
		Assert.assertTrue(PrimaryExpression_53_Var
		.isDefined());
		Assert.assertEquals("__GCC_VERSION__", PrimaryExpression_53_Var
		.getId());
		//53
		final GroupOpt GroupOpt_54_Var
		 = (GroupOpt)IfConditional_8_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_54_Var
		);
		final EList<? extends EObject> Lines_54_list = GroupOpt_54_Var
		.getLines();
		Assert.assertNotNull(Lines_54_list);
		Assert.assertEquals(1, Lines_54_list.size());
		//54
		final Code Code_55_Var
		 = (Code)Lines_54_list.get(0);
		Assert.assertNotNull(Code_55_Var
		);
		Assert.assertEquals("	void c11_extension();", Code_55_Var
		.getCode());
	}
	
	@Test
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


