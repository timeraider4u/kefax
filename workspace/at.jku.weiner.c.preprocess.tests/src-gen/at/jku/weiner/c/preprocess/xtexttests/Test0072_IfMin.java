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
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
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
public class Test0072_IfMin {
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
			"res/Test0072_IfMin.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LESS", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_QUESTION", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_COLON", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
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
			"res/Test0072_IfMin.c");
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
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_5_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_4_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_5_Var
		);
		Assert.assertEquals("MIN", DefineFunctionLikeMacro_5_Var
		.getId());
		//5
		final IdentifierList IdentifierList_6_Var
		 = (IdentifierList)DefineFunctionLikeMacro_5_Var
		.getList();
		Assert.assertNotNull(IdentifierList_6_Var
		);
		Assert.assertEquals("[X, Y]", IdentifierList_6_Var
		.getId().toString());
		Assert.assertEquals("((X) < (Y) ? (X) : (Y))", DefineFunctionLikeMacro_5_Var
		.getString());
		//6
		final PreprocessorDirectives PreprocessorDirectives_7_Var
		 = (PreprocessorDirectives)Lines_3_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_7_Var
		);
		//7
		final ConditionalDirective ConditionalDirective_8_Var
		 = (ConditionalDirective)PreprocessorDirectives_7_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_8_Var
		);
		//8
		final IfConditional IfConditional_9_Var
		 = (IfConditional)ConditionalDirective_8_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_9_Var
		);
		//9
		final ConstantExpression ConstantExpression_10_Var
		 = (ConstantExpression)IfConditional_9_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_10_Var
		);
		//10
		final ConditionalExpression ConditionalExpression_11_Var
		 = (ConditionalExpression)ConstantExpression_10_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_11_Var
		);
		//11
		final LogicalOrExpression LogicalOrExpression_12_Var
		 = (LogicalOrExpression)ConditionalExpression_11_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_12_Var
		);
		final EList<? extends EObject> Expr_12_list = LogicalOrExpression_12_Var
		.getExpr();
		Assert.assertNotNull(Expr_12_list);
		Assert.assertEquals(1, Expr_12_list.size());
		//12
		final LogicalAndExpression LogicalAndExpression_13_Var
		 = (LogicalAndExpression)Expr_12_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_13_Var
		);
		final EList<? extends EObject> Expr_13_list = LogicalAndExpression_13_Var
		.getExpr();
		Assert.assertNotNull(Expr_13_list);
		Assert.assertEquals(1, Expr_13_list.size());
		//13
		final InclusiveOrExpression InclusiveOrExpression_14_Var
		 = (InclusiveOrExpression)Expr_13_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = InclusiveOrExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		//14
		final ExclusiveOrExpression ExclusiveOrExpression_15_Var
		 = (ExclusiveOrExpression)Expr_14_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = ExclusiveOrExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final AndExpression AndExpression_16_Var
		 = (AndExpression)Expr_15_list.get(0);
		Assert.assertNotNull(AndExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = AndExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final EqualityExpression EqualityExpression_17_Var
		 = (EqualityExpression)Expr_16_list.get(0);
		Assert.assertNotNull(EqualityExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = EqualityExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final RelationalExpression RelationalExpression_18_Var
		 = (RelationalExpression)Expr_17_list.get(0);
		Assert.assertNotNull(RelationalExpression_18_Var
		);
		Assert.assertEquals("[>=]", RelationalExpression_18_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_18_list = RelationalExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(2, Expr_18_list.size());
		//18
		final ShiftExpression ShiftExpression_19_Var
		 = (ShiftExpression)Expr_18_list.get(0);
		Assert.assertNotNull(ShiftExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = ShiftExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final AdditiveExpression AdditiveExpression_20_Var
		 = (AdditiveExpression)Expr_19_list.get(0);
		Assert.assertNotNull(AdditiveExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = AdditiveExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final MultiplicativeExpression MultiplicativeExpression_21_Var
		 = (MultiplicativeExpression)Expr_20_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = MultiplicativeExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final CastExpression CastExpression_22_Var
		 = (CastExpression)Expr_21_list.get(0);
		Assert.assertNotNull(CastExpression_22_Var
		);
		//22
		final UnaryExpression UnaryExpression_23_Var
		 = (UnaryExpression)CastExpression_22_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_23_Var
		);
		//23
		final PostfixExpression PostfixExpression_24_Var
		 = (PostfixExpression)UnaryExpression_23_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_24_Var
		);
		//24
		final PrimaryExpression PrimaryExpression_25_Var
		 = (PrimaryExpression)PostfixExpression_24_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_25_Var
		);
		Assert.assertEquals("MIN", PrimaryExpression_25_Var
		.getId());
		final EList<? extends EObject> Suffix_25_list = PostfixExpression_24_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_25_list);
		Assert.assertEquals(1, Suffix_25_list.size());
		//25
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_26_Var
		 = (PostfixExpressionSuffixArgument)Suffix_25_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_26_Var
		);
		//26
		final ArgumentExpressionList ArgumentExpressionList_27_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_26_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_27_Var
		);
		final EList<? extends EObject> Expr_27_list = ArgumentExpressionList_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(2, Expr_27_list.size());
		//27
		final ConditionalExpression ConditionalExpression_28_Var
		 = (ConditionalExpression)Expr_27_list.get(0);
		Assert.assertNotNull(ConditionalExpression_28_Var
		);
		//28
		final LogicalOrExpression LogicalOrExpression_29_Var
		 = (LogicalOrExpression)ConditionalExpression_28_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = LogicalOrExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final LogicalAndExpression LogicalAndExpression_30_Var
		 = (LogicalAndExpression)Expr_29_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = LogicalAndExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final InclusiveOrExpression InclusiveOrExpression_31_Var
		 = (InclusiveOrExpression)Expr_30_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = InclusiveOrExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final ExclusiveOrExpression ExclusiveOrExpression_32_Var
		 = (ExclusiveOrExpression)Expr_31_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = ExclusiveOrExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final AndExpression AndExpression_33_Var
		 = (AndExpression)Expr_32_list.get(0);
		Assert.assertNotNull(AndExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = AndExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final EqualityExpression EqualityExpression_34_Var
		 = (EqualityExpression)Expr_33_list.get(0);
		Assert.assertNotNull(EqualityExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = EqualityExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final RelationalExpression RelationalExpression_35_Var
		 = (RelationalExpression)Expr_34_list.get(0);
		Assert.assertNotNull(RelationalExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = RelationalExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final ShiftExpression ShiftExpression_36_Var
		 = (ShiftExpression)Expr_35_list.get(0);
		Assert.assertNotNull(ShiftExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = ShiftExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final AdditiveExpression AdditiveExpression_37_Var
		 = (AdditiveExpression)Expr_36_list.get(0);
		Assert.assertNotNull(AdditiveExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = AdditiveExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final MultiplicativeExpression MultiplicativeExpression_38_Var
		 = (MultiplicativeExpression)Expr_37_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = MultiplicativeExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final CastExpression CastExpression_39_Var
		 = (CastExpression)Expr_38_list.get(0);
		Assert.assertNotNull(CastExpression_39_Var
		);
		//39
		final UnaryExpression UnaryExpression_40_Var
		 = (UnaryExpression)CastExpression_39_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_40_Var
		);
		//40
		final PostfixExpression PostfixExpression_41_Var
		 = (PostfixExpression)UnaryExpression_40_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_41_Var
		);
		//41
		final PrimaryExpression PrimaryExpression_42_Var
		 = (PrimaryExpression)PostfixExpression_41_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_42_Var
		);
		Assert.assertEquals("0", PrimaryExpression_42_Var
		.getConst());
		//42
		final ConditionalExpression ConditionalExpression_43_Var
		 = (ConditionalExpression)Expr_27_list.get(1);
		Assert.assertNotNull(ConditionalExpression_43_Var
		);
		//43
		final LogicalOrExpression LogicalOrExpression_44_Var
		 = (LogicalOrExpression)ConditionalExpression_43_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = LogicalOrExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final LogicalAndExpression LogicalAndExpression_45_Var
		 = (LogicalAndExpression)Expr_44_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = LogicalAndExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final InclusiveOrExpression InclusiveOrExpression_46_Var
		 = (InclusiveOrExpression)Expr_45_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = InclusiveOrExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final ExclusiveOrExpression ExclusiveOrExpression_47_Var
		 = (ExclusiveOrExpression)Expr_46_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = ExclusiveOrExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final AndExpression AndExpression_48_Var
		 = (AndExpression)Expr_47_list.get(0);
		Assert.assertNotNull(AndExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = AndExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final EqualityExpression EqualityExpression_49_Var
		 = (EqualityExpression)Expr_48_list.get(0);
		Assert.assertNotNull(EqualityExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = EqualityExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final RelationalExpression RelationalExpression_50_Var
		 = (RelationalExpression)Expr_49_list.get(0);
		Assert.assertNotNull(RelationalExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = RelationalExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final ShiftExpression ShiftExpression_51_Var
		 = (ShiftExpression)Expr_50_list.get(0);
		Assert.assertNotNull(ShiftExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = ShiftExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final AdditiveExpression AdditiveExpression_52_Var
		 = (AdditiveExpression)Expr_51_list.get(0);
		Assert.assertNotNull(AdditiveExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = AdditiveExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final MultiplicativeExpression MultiplicativeExpression_53_Var
		 = (MultiplicativeExpression)Expr_52_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = MultiplicativeExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final CastExpression CastExpression_54_Var
		 = (CastExpression)Expr_53_list.get(0);
		Assert.assertNotNull(CastExpression_54_Var
		);
		//54
		final UnaryExpression UnaryExpression_55_Var
		 = (UnaryExpression)CastExpression_54_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_55_Var
		);
		//55
		final PostfixExpression PostfixExpression_56_Var
		 = (PostfixExpression)UnaryExpression_55_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_56_Var
		);
		//56
		final PrimaryExpression PrimaryExpression_57_Var
		 = (PrimaryExpression)PostfixExpression_56_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_57_Var
		);
		Assert.assertEquals("6", PrimaryExpression_57_Var
		.getConst());
		//57
		final ShiftExpression ShiftExpression_58_Var
		 = (ShiftExpression)Expr_18_list.get(1);
		Assert.assertNotNull(ShiftExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = ShiftExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final AdditiveExpression AdditiveExpression_59_Var
		 = (AdditiveExpression)Expr_58_list.get(0);
		Assert.assertNotNull(AdditiveExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = AdditiveExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final MultiplicativeExpression MultiplicativeExpression_60_Var
		 = (MultiplicativeExpression)Expr_59_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = MultiplicativeExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final CastExpression CastExpression_61_Var
		 = (CastExpression)Expr_60_list.get(0);
		Assert.assertNotNull(CastExpression_61_Var
		);
		//61
		final UnaryExpression UnaryExpression_62_Var
		 = (UnaryExpression)CastExpression_61_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_62_Var
		);
		//62
		final PostfixExpression PostfixExpression_63_Var
		 = (PostfixExpression)UnaryExpression_62_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_63_Var
		);
		//63
		final PrimaryExpression PrimaryExpression_64_Var
		 = (PrimaryExpression)PostfixExpression_63_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_64_Var
		);
		Assert.assertEquals("5", PrimaryExpression_64_Var
		.getConst());
		//64
		final GroupOpt GroupOpt_65_Var
		 = (GroupOpt)IfConditional_9_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_65_Var
		);
		final EList<? extends EObject> Lines_65_list = GroupOpt_65_Var
		.getLines();
		Assert.assertNotNull(Lines_65_list);
		Assert.assertEquals(1, Lines_65_list.size());
		//65
		final Code Code_66_Var
		 = (Code)Lines_65_list.get(0);
		Assert.assertNotNull(Code_66_Var
		);
		Assert.assertEquals("	void greaterEqualFive();", Code_66_Var
		.getCode());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0072_IfMin.c");
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
				method.invoke(this.generator, "Test0072_IfMin.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0072_IfMin.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0072_IfMin.c"
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


