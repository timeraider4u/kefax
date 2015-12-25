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
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
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
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0077_IfComplexExpression {
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
			"res/Test0077_IfComplexExpression.c");
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
				"RULE_DECIMAL_LITERAL", 
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
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTSHIFT", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_PLUS", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_GREATEREQUAL", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTSHIFT", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_PLUS", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_IF", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
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
			"res/Test0077_IfComplexExpression.c");
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
		Assert.assertEquals(9, Lines_3_list.size());
		//3
		final PreprocessorDirectives PreprocessorDirectives_4_Var
		 = (PreprocessorDirectives)Lines_3_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_4_Var
		);
		//4
		final DefineObjectMacro DefineObjectMacro_5_Var
		 = (DefineObjectMacro)PreprocessorDirectives_4_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_5_Var
		);
		Assert.assertEquals("REQ_MAJOR", DefineObjectMacro_5_Var
		.getId());
		Assert.assertEquals("3", DefineObjectMacro_5_Var
		.getString());
		//5
		final PreprocessorDirectives PreprocessorDirectives_6_Var
		 = (PreprocessorDirectives)Lines_3_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_6_Var
		);
		//6
		final DefineObjectMacro DefineObjectMacro_7_Var
		 = (DefineObjectMacro)PreprocessorDirectives_6_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_7_Var
		);
		Assert.assertEquals("REQ_MINOR", DefineObjectMacro_7_Var
		.getId());
		Assert.assertEquals("2", DefineObjectMacro_7_Var
		.getString());
		//7
		final NewLineLine NewLineLine_8_Var
		 = (NewLineLine)Lines_3_list.get(2);
		Assert.assertNotNull(NewLineLine_8_Var
		);
		//8
		final PreprocessorDirectives PreprocessorDirectives_9_Var
		 = (PreprocessorDirectives)Lines_3_list.get(3);
		Assert.assertNotNull(PreprocessorDirectives_9_Var
		);
		//9
		final DefineObjectMacro DefineObjectMacro_10_Var
		 = (DefineObjectMacro)PreprocessorDirectives_9_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_10_Var
		);
		Assert.assertEquals("MAJOR", DefineObjectMacro_10_Var
		.getId());
		Assert.assertEquals("4", DefineObjectMacro_10_Var
		.getString());
		//10
		final PreprocessorDirectives PreprocessorDirectives_11_Var
		 = (PreprocessorDirectives)Lines_3_list.get(4);
		Assert.assertNotNull(PreprocessorDirectives_11_Var
		);
		//11
		final DefineObjectMacro DefineObjectMacro_12_Var
		 = (DefineObjectMacro)PreprocessorDirectives_11_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_12_Var
		);
		Assert.assertEquals("MINOR", DefineObjectMacro_12_Var
		.getId());
		Assert.assertEquals("1", DefineObjectMacro_12_Var
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
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_15_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_14_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_15_Var
		);
		Assert.assertEquals("REQ", DefineFunctionLikeMacro_15_Var
		.getId());
		//15
		final IdentifierList IdentifierList_16_Var
		 = (IdentifierList)DefineFunctionLikeMacro_15_Var
		.getList();
		Assert.assertNotNull(IdentifierList_16_Var
		);
		Assert.assertEquals("[major, minor]", IdentifierList_16_Var
		.getId().toString());
		Assert.assertEquals("((major << 32) + minor >= ((REQ_MAJOR) << 32) + (REQ_MINOR))", DefineFunctionLikeMacro_15_Var
		.getString());
		//16
		final NewLineLine NewLineLine_17_Var
		 = (NewLineLine)Lines_3_list.get(7);
		Assert.assertNotNull(NewLineLine_17_Var
		);
		//17
		final PreprocessorDirectives PreprocessorDirectives_18_Var
		 = (PreprocessorDirectives)Lines_3_list.get(8);
		Assert.assertNotNull(PreprocessorDirectives_18_Var
		);
		//18
		final ConditionalDirective ConditionalDirective_19_Var
		 = (ConditionalDirective)PreprocessorDirectives_18_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_19_Var
		);
		//19
		final IfConditional IfConditional_20_Var
		 = (IfConditional)ConditionalDirective_19_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_20_Var
		);
		//20
		final ConstantExpression ConstantExpression_21_Var
		 = (ConstantExpression)IfConditional_20_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_21_Var
		);
		//21
		final ConditionalExpression ConditionalExpression_22_Var
		 = (ConditionalExpression)ConstantExpression_21_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_22_Var
		);
		//22
		final LogicalOrExpression LogicalOrExpression_23_Var
		 = (LogicalOrExpression)ConditionalExpression_22_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = LogicalOrExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final LogicalAndExpression LogicalAndExpression_24_Var
		 = (LogicalAndExpression)Expr_23_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = LogicalAndExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final InclusiveOrExpression InclusiveOrExpression_25_Var
		 = (InclusiveOrExpression)Expr_24_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = InclusiveOrExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final ExclusiveOrExpression ExclusiveOrExpression_26_Var
		 = (ExclusiveOrExpression)Expr_25_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = ExclusiveOrExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final AndExpression AndExpression_27_Var
		 = (AndExpression)Expr_26_list.get(0);
		Assert.assertNotNull(AndExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = AndExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final EqualityExpression EqualityExpression_28_Var
		 = (EqualityExpression)Expr_27_list.get(0);
		Assert.assertNotNull(EqualityExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = EqualityExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final RelationalExpression RelationalExpression_29_Var
		 = (RelationalExpression)Expr_28_list.get(0);
		Assert.assertNotNull(RelationalExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = RelationalExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final ShiftExpression ShiftExpression_30_Var
		 = (ShiftExpression)Expr_29_list.get(0);
		Assert.assertNotNull(ShiftExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = ShiftExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final AdditiveExpression AdditiveExpression_31_Var
		 = (AdditiveExpression)Expr_30_list.get(0);
		Assert.assertNotNull(AdditiveExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = AdditiveExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final MultiplicativeExpression MultiplicativeExpression_32_Var
		 = (MultiplicativeExpression)Expr_31_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = MultiplicativeExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final CastExpression CastExpression_33_Var
		 = (CastExpression)Expr_32_list.get(0);
		Assert.assertNotNull(CastExpression_33_Var
		);
		//33
		final UnaryExpression UnaryExpression_34_Var
		 = (UnaryExpression)CastExpression_33_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_34_Var
		);
		//34
		final PostfixExpression PostfixExpression_35_Var
		 = (PostfixExpression)UnaryExpression_34_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_35_Var
		);
		//35
		final PrimaryExpression PrimaryExpression_36_Var
		 = (PrimaryExpression)PostfixExpression_35_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_36_Var
		);
		Assert.assertEquals("REQ", PrimaryExpression_36_Var
		.getId());
		final EList<? extends EObject> Suffix_36_list = PostfixExpression_35_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_36_list);
		Assert.assertEquals(1, Suffix_36_list.size());
		//36
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_37_Var
		 = (PostfixExpressionSuffixArgument)Suffix_36_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_37_Var
		);
		//37
		final ArgumentExpressionList ArgumentExpressionList_38_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_37_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_38_Var
		);
		final EList<? extends EObject> Expr_38_list = ArgumentExpressionList_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(2, Expr_38_list.size());
		//38
		final ConditionalExpression ConditionalExpression_39_Var
		 = (ConditionalExpression)Expr_38_list.get(0);
		Assert.assertNotNull(ConditionalExpression_39_Var
		);
		//39
		final LogicalOrExpression LogicalOrExpression_40_Var
		 = (LogicalOrExpression)ConditionalExpression_39_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = LogicalOrExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final LogicalAndExpression LogicalAndExpression_41_Var
		 = (LogicalAndExpression)Expr_40_list.get(0);
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
		Assert.assertEquals("MAJOR", PrimaryExpression_53_Var
		.getId());
		//53
		final ConditionalExpression ConditionalExpression_54_Var
		 = (ConditionalExpression)Expr_38_list.get(1);
		Assert.assertNotNull(ConditionalExpression_54_Var
		);
		//54
		final LogicalOrExpression LogicalOrExpression_55_Var
		 = (LogicalOrExpression)ConditionalExpression_54_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = LogicalOrExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final LogicalAndExpression LogicalAndExpression_56_Var
		 = (LogicalAndExpression)Expr_55_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = LogicalAndExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final InclusiveOrExpression InclusiveOrExpression_57_Var
		 = (InclusiveOrExpression)Expr_56_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = InclusiveOrExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final ExclusiveOrExpression ExclusiveOrExpression_58_Var
		 = (ExclusiveOrExpression)Expr_57_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = ExclusiveOrExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final AndExpression AndExpression_59_Var
		 = (AndExpression)Expr_58_list.get(0);
		Assert.assertNotNull(AndExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = AndExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final EqualityExpression EqualityExpression_60_Var
		 = (EqualityExpression)Expr_59_list.get(0);
		Assert.assertNotNull(EqualityExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = EqualityExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final RelationalExpression RelationalExpression_61_Var
		 = (RelationalExpression)Expr_60_list.get(0);
		Assert.assertNotNull(RelationalExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = RelationalExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final ShiftExpression ShiftExpression_62_Var
		 = (ShiftExpression)Expr_61_list.get(0);
		Assert.assertNotNull(ShiftExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = ShiftExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final AdditiveExpression AdditiveExpression_63_Var
		 = (AdditiveExpression)Expr_62_list.get(0);
		Assert.assertNotNull(AdditiveExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = AdditiveExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final MultiplicativeExpression MultiplicativeExpression_64_Var
		 = (MultiplicativeExpression)Expr_63_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = MultiplicativeExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final CastExpression CastExpression_65_Var
		 = (CastExpression)Expr_64_list.get(0);
		Assert.assertNotNull(CastExpression_65_Var
		);
		//65
		final UnaryExpression UnaryExpression_66_Var
		 = (UnaryExpression)CastExpression_65_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_66_Var
		);
		//66
		final PostfixExpression PostfixExpression_67_Var
		 = (PostfixExpression)UnaryExpression_66_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_67_Var
		);
		//67
		final PrimaryExpression PrimaryExpression_68_Var
		 = (PrimaryExpression)PostfixExpression_67_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_68_Var
		);
		Assert.assertEquals("MINOR", PrimaryExpression_68_Var
		.getId());
		//68
		final GroupOpt GroupOpt_69_Var
		 = (GroupOpt)IfConditional_20_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_69_Var
		);
		final EList<? extends EObject> Lines_69_list = GroupOpt_69_Var
		.getLines();
		Assert.assertNotNull(Lines_69_list);
		Assert.assertEquals(1, Lines_69_list.size());
		//69
		final Code Code_70_Var
		 = (Code)Lines_69_list.get(0);
		Assert.assertNotNull(Code_70_Var
		);
		Assert.assertEquals("	void foo_bar();", Code_70_Var
		.getCode());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0077_IfComplexExpression.c");
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
				method.invoke(this.generator, "Test0077_IfComplexExpression.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0077_IfComplexExpression.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0077_IfComplexExpression.c"
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


