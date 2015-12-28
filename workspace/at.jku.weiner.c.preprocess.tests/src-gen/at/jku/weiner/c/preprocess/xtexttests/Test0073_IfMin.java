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
public class Test0073_IfMin {
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
			"res/Test0073_IfMin.c");
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
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0073_IfMin.c");
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
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_3_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_2_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_3_Var
		);
		Assert.assertEquals("MIN", DefineFunctionLikeMacro_3_Var
		.getId());
		//3
		final IdentifierList IdentifierList_4_Var
		 = (IdentifierList)DefineFunctionLikeMacro_3_Var
		.getList();
		Assert.assertNotNull(IdentifierList_4_Var
		);
		Assert.assertEquals("[X, Y]", IdentifierList_4_Var
		.getId().toString());
		Assert.assertEquals("((X) < (Y) ? (X) : (Y))", DefineFunctionLikeMacro_3_Var
		.getString());
		//4
		final PreprocessorDirectives PreprocessorDirectives_5_Var
		 = (PreprocessorDirectives)Lines_1_list.get(1);
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
		Assert.assertEquals("MIN", PrimaryExpression_23_Var
		.getId());
		final EList<? extends EObject> Suffix_23_list = PostfixExpression_22_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_23_list);
		Assert.assertEquals(1, Suffix_23_list.size());
		//23
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_24_Var
		 = (PostfixExpressionSuffixArgument)Suffix_23_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_24_Var
		);
		//24
		final ArgumentExpressionList ArgumentExpressionList_25_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_24_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_25_Var
		);
		final EList<? extends EObject> Expr_25_list = ArgumentExpressionList_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(2, Expr_25_list.size());
		//25
		final ConditionalExpression ConditionalExpression_26_Var
		 = (ConditionalExpression)Expr_25_list.get(0);
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
		Assert.assertEquals(1, Expr_27_list.size());
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
		Assert.assertEquals("5", PrimaryExpression_40_Var
		.getConst());
		//40
		final ConditionalExpression ConditionalExpression_41_Var
		 = (ConditionalExpression)Expr_25_list.get(1);
		Assert.assertNotNull(ConditionalExpression_41_Var
		);
		//41
		final LogicalOrExpression LogicalOrExpression_42_Var
		 = (LogicalOrExpression)ConditionalExpression_41_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = LogicalOrExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final LogicalAndExpression LogicalAndExpression_43_Var
		 = (LogicalAndExpression)Expr_42_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = LogicalAndExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final InclusiveOrExpression InclusiveOrExpression_44_Var
		 = (InclusiveOrExpression)Expr_43_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = InclusiveOrExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final ExclusiveOrExpression ExclusiveOrExpression_45_Var
		 = (ExclusiveOrExpression)Expr_44_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = ExclusiveOrExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final AndExpression AndExpression_46_Var
		 = (AndExpression)Expr_45_list.get(0);
		Assert.assertNotNull(AndExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = AndExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final EqualityExpression EqualityExpression_47_Var
		 = (EqualityExpression)Expr_46_list.get(0);
		Assert.assertNotNull(EqualityExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = EqualityExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final RelationalExpression RelationalExpression_48_Var
		 = (RelationalExpression)Expr_47_list.get(0);
		Assert.assertNotNull(RelationalExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = RelationalExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final ShiftExpression ShiftExpression_49_Var
		 = (ShiftExpression)Expr_48_list.get(0);
		Assert.assertNotNull(ShiftExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = ShiftExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final AdditiveExpression AdditiveExpression_50_Var
		 = (AdditiveExpression)Expr_49_list.get(0);
		Assert.assertNotNull(AdditiveExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = AdditiveExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final MultiplicativeExpression MultiplicativeExpression_51_Var
		 = (MultiplicativeExpression)Expr_50_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = MultiplicativeExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final CastExpression CastExpression_52_Var
		 = (CastExpression)Expr_51_list.get(0);
		Assert.assertNotNull(CastExpression_52_Var
		);
		//52
		final UnaryExpression UnaryExpression_53_Var
		 = (UnaryExpression)CastExpression_52_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_53_Var
		);
		//53
		final PostfixExpression PostfixExpression_54_Var
		 = (PostfixExpression)UnaryExpression_53_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_54_Var
		);
		//54
		final PrimaryExpression PrimaryExpression_55_Var
		 = (PrimaryExpression)PostfixExpression_54_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_55_Var
		);
		Assert.assertEquals("6", PrimaryExpression_55_Var
		.getConst());
		//55
		final ShiftExpression ShiftExpression_56_Var
		 = (ShiftExpression)Expr_16_list.get(1);
		Assert.assertNotNull(ShiftExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = ShiftExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final AdditiveExpression AdditiveExpression_57_Var
		 = (AdditiveExpression)Expr_56_list.get(0);
		Assert.assertNotNull(AdditiveExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = AdditiveExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final MultiplicativeExpression MultiplicativeExpression_58_Var
		 = (MultiplicativeExpression)Expr_57_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = MultiplicativeExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final CastExpression CastExpression_59_Var
		 = (CastExpression)Expr_58_list.get(0);
		Assert.assertNotNull(CastExpression_59_Var
		);
		//59
		final UnaryExpression UnaryExpression_60_Var
		 = (UnaryExpression)CastExpression_59_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_60_Var
		);
		//60
		final PostfixExpression PostfixExpression_61_Var
		 = (PostfixExpression)UnaryExpression_60_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_61_Var
		);
		//61
		final PrimaryExpression PrimaryExpression_62_Var
		 = (PrimaryExpression)PostfixExpression_61_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_62_Var
		);
		Assert.assertEquals("5", PrimaryExpression_62_Var
		.getConst());
		//62
		final GroupOpt GroupOpt_63_Var
		 = (GroupOpt)IfConditional_7_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_63_Var
		);
		final EList<? extends EObject> Lines_63_list = GroupOpt_63_Var
		.getLines();
		Assert.assertNotNull(Lines_63_list);
		Assert.assertEquals(1, Lines_63_list.size());
		//63
		final Code Code_64_Var
		 = (Code)Lines_63_list.get(0);
		Assert.assertNotNull(Code_64_Var
		);
		Assert.assertEquals("	void greaterEqualFive();", Code_64_Var
		.getCode());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0073_IfMin.c");
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
				method.invoke(this.generator, "Test0073_IfMin.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0073_IfMin.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0073_IfMin.c"
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


