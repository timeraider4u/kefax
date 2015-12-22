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
public class Test0076_IfComplexExpression {
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
			"res/Test0076_IfComplexExpression.c");
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
			"res/Test0076_IfComplexExpression.c");
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
		Assert.assertEquals(9, Lines_2_list.size());
		//2
		final PreprocessorDirectives PreprocessorDirectives_3_Var
		 = (PreprocessorDirectives)Lines_2_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_3_Var
		);
		//3
		final DefineObjectMacro DefineObjectMacro_4_Var
		 = (DefineObjectMacro)PreprocessorDirectives_3_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_4_Var
		);
		Assert.assertEquals("REQ_MAJOR", DefineObjectMacro_4_Var
		.getId());
		Assert.assertEquals("3", DefineObjectMacro_4_Var
		.getString());
		//4
		final PreprocessorDirectives PreprocessorDirectives_5_Var
		 = (PreprocessorDirectives)Lines_2_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_5_Var
		);
		//5
		final DefineObjectMacro DefineObjectMacro_6_Var
		 = (DefineObjectMacro)PreprocessorDirectives_5_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_6_Var
		);
		Assert.assertEquals("REQ_MINOR", DefineObjectMacro_6_Var
		.getId());
		Assert.assertEquals("2", DefineObjectMacro_6_Var
		.getString());
		//6
		final NewLineLine NewLineLine_7_Var
		 = (NewLineLine)Lines_2_list.get(2);
		Assert.assertNotNull(NewLineLine_7_Var
		);
		//7
		final PreprocessorDirectives PreprocessorDirectives_8_Var
		 = (PreprocessorDirectives)Lines_2_list.get(3);
		Assert.assertNotNull(PreprocessorDirectives_8_Var
		);
		//8
		final DefineObjectMacro DefineObjectMacro_9_Var
		 = (DefineObjectMacro)PreprocessorDirectives_8_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_9_Var
		);
		Assert.assertEquals("MAJOR", DefineObjectMacro_9_Var
		.getId());
		Assert.assertEquals("1", DefineObjectMacro_9_Var
		.getString());
		//9
		final PreprocessorDirectives PreprocessorDirectives_10_Var
		 = (PreprocessorDirectives)Lines_2_list.get(4);
		Assert.assertNotNull(PreprocessorDirectives_10_Var
		);
		//10
		final DefineObjectMacro DefineObjectMacro_11_Var
		 = (DefineObjectMacro)PreprocessorDirectives_10_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_11_Var
		);
		Assert.assertEquals("MINOR", DefineObjectMacro_11_Var
		.getId());
		Assert.assertEquals("4", DefineObjectMacro_11_Var
		.getString());
		//11
		final NewLineLine NewLineLine_12_Var
		 = (NewLineLine)Lines_2_list.get(5);
		Assert.assertNotNull(NewLineLine_12_Var
		);
		//12
		final PreprocessorDirectives PreprocessorDirectives_13_Var
		 = (PreprocessorDirectives)Lines_2_list.get(6);
		Assert.assertNotNull(PreprocessorDirectives_13_Var
		);
		//13
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_14_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_13_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_14_Var
		);
		Assert.assertEquals("REQ", DefineFunctionLikeMacro_14_Var
		.getId());
		//14
		final IdentifierList IdentifierList_15_Var
		 = (IdentifierList)DefineFunctionLikeMacro_14_Var
		.getList();
		Assert.assertNotNull(IdentifierList_15_Var
		);
		Assert.assertEquals("[major, minor]", IdentifierList_15_Var
		.getId().toString());
		Assert.assertEquals("((major << 32) + minor >= ((REQ_MAJOR) << 32) + (REQ_MINOR))", DefineFunctionLikeMacro_14_Var
		.getString());
		//15
		final NewLineLine NewLineLine_16_Var
		 = (NewLineLine)Lines_2_list.get(7);
		Assert.assertNotNull(NewLineLine_16_Var
		);
		//16
		final PreprocessorDirectives PreprocessorDirectives_17_Var
		 = (PreprocessorDirectives)Lines_2_list.get(8);
		Assert.assertNotNull(PreprocessorDirectives_17_Var
		);
		//17
		final ConditionalDirective ConditionalDirective_18_Var
		 = (ConditionalDirective)PreprocessorDirectives_17_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_18_Var
		);
		//18
		final IfConditional IfConditional_19_Var
		 = (IfConditional)ConditionalDirective_18_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_19_Var
		);
		//19
		final ConstantExpression ConstantExpression_20_Var
		 = (ConstantExpression)IfConditional_19_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_20_Var
		);
		//20
		final ConditionalExpression ConditionalExpression_21_Var
		 = (ConditionalExpression)ConstantExpression_20_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_21_Var
		);
		//21
		final LogicalOrExpression LogicalOrExpression_22_Var
		 = (LogicalOrExpression)ConditionalExpression_21_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = LogicalOrExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final LogicalAndExpression LogicalAndExpression_23_Var
		 = (LogicalAndExpression)Expr_22_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = LogicalAndExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final InclusiveOrExpression InclusiveOrExpression_24_Var
		 = (InclusiveOrExpression)Expr_23_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = InclusiveOrExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final ExclusiveOrExpression ExclusiveOrExpression_25_Var
		 = (ExclusiveOrExpression)Expr_24_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = ExclusiveOrExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final AndExpression AndExpression_26_Var
		 = (AndExpression)Expr_25_list.get(0);
		Assert.assertNotNull(AndExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = AndExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final EqualityExpression EqualityExpression_27_Var
		 = (EqualityExpression)Expr_26_list.get(0);
		Assert.assertNotNull(EqualityExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = EqualityExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final RelationalExpression RelationalExpression_28_Var
		 = (RelationalExpression)Expr_27_list.get(0);
		Assert.assertNotNull(RelationalExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = RelationalExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final ShiftExpression ShiftExpression_29_Var
		 = (ShiftExpression)Expr_28_list.get(0);
		Assert.assertNotNull(ShiftExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = ShiftExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final AdditiveExpression AdditiveExpression_30_Var
		 = (AdditiveExpression)Expr_29_list.get(0);
		Assert.assertNotNull(AdditiveExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = AdditiveExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final MultiplicativeExpression MultiplicativeExpression_31_Var
		 = (MultiplicativeExpression)Expr_30_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = MultiplicativeExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final CastExpression CastExpression_32_Var
		 = (CastExpression)Expr_31_list.get(0);
		Assert.assertNotNull(CastExpression_32_Var
		);
		//32
		final UnaryExpression UnaryExpression_33_Var
		 = (UnaryExpression)CastExpression_32_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_33_Var
		);
		//33
		final PostfixExpression PostfixExpression_34_Var
		 = (PostfixExpression)UnaryExpression_33_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_34_Var
		);
		//34
		final PrimaryExpression PrimaryExpression_35_Var
		 = (PrimaryExpression)PostfixExpression_34_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_35_Var
		);
		Assert.assertEquals("REQ", PrimaryExpression_35_Var
		.getId());
		final EList<? extends EObject> Suffix_35_list = PostfixExpression_34_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_35_list);
		Assert.assertEquals(1, Suffix_35_list.size());
		//35
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_36_Var
		 = (PostfixExpressionSuffixArgument)Suffix_35_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_36_Var
		);
		//36
		final ArgumentExpressionList ArgumentExpressionList_37_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_36_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_37_Var
		);
		final EList<? extends EObject> Expr_37_list = ArgumentExpressionList_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(2, Expr_37_list.size());
		//37
		final ConditionalExpression ConditionalExpression_38_Var
		 = (ConditionalExpression)Expr_37_list.get(0);
		Assert.assertNotNull(ConditionalExpression_38_Var
		);
		//38
		final LogicalOrExpression LogicalOrExpression_39_Var
		 = (LogicalOrExpression)ConditionalExpression_38_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = LogicalOrExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final LogicalAndExpression LogicalAndExpression_40_Var
		 = (LogicalAndExpression)Expr_39_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = LogicalAndExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final InclusiveOrExpression InclusiveOrExpression_41_Var
		 = (InclusiveOrExpression)Expr_40_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = InclusiveOrExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final ExclusiveOrExpression ExclusiveOrExpression_42_Var
		 = (ExclusiveOrExpression)Expr_41_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = ExclusiveOrExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final AndExpression AndExpression_43_Var
		 = (AndExpression)Expr_42_list.get(0);
		Assert.assertNotNull(AndExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = AndExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final EqualityExpression EqualityExpression_44_Var
		 = (EqualityExpression)Expr_43_list.get(0);
		Assert.assertNotNull(EqualityExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = EqualityExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final RelationalExpression RelationalExpression_45_Var
		 = (RelationalExpression)Expr_44_list.get(0);
		Assert.assertNotNull(RelationalExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = RelationalExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final ShiftExpression ShiftExpression_46_Var
		 = (ShiftExpression)Expr_45_list.get(0);
		Assert.assertNotNull(ShiftExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = ShiftExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final AdditiveExpression AdditiveExpression_47_Var
		 = (AdditiveExpression)Expr_46_list.get(0);
		Assert.assertNotNull(AdditiveExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = AdditiveExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final MultiplicativeExpression MultiplicativeExpression_48_Var
		 = (MultiplicativeExpression)Expr_47_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = MultiplicativeExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final CastExpression CastExpression_49_Var
		 = (CastExpression)Expr_48_list.get(0);
		Assert.assertNotNull(CastExpression_49_Var
		);
		//49
		final UnaryExpression UnaryExpression_50_Var
		 = (UnaryExpression)CastExpression_49_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_50_Var
		);
		//50
		final PostfixExpression PostfixExpression_51_Var
		 = (PostfixExpression)UnaryExpression_50_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_51_Var
		);
		//51
		final PrimaryExpression PrimaryExpression_52_Var
		 = (PrimaryExpression)PostfixExpression_51_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_52_Var
		);
		Assert.assertEquals("MAJOR", PrimaryExpression_52_Var
		.getId());
		//52
		final ConditionalExpression ConditionalExpression_53_Var
		 = (ConditionalExpression)Expr_37_list.get(1);
		Assert.assertNotNull(ConditionalExpression_53_Var
		);
		//53
		final LogicalOrExpression LogicalOrExpression_54_Var
		 = (LogicalOrExpression)ConditionalExpression_53_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = LogicalOrExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final LogicalAndExpression LogicalAndExpression_55_Var
		 = (LogicalAndExpression)Expr_54_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = LogicalAndExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final InclusiveOrExpression InclusiveOrExpression_56_Var
		 = (InclusiveOrExpression)Expr_55_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = InclusiveOrExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final ExclusiveOrExpression ExclusiveOrExpression_57_Var
		 = (ExclusiveOrExpression)Expr_56_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = ExclusiveOrExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final AndExpression AndExpression_58_Var
		 = (AndExpression)Expr_57_list.get(0);
		Assert.assertNotNull(AndExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = AndExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final EqualityExpression EqualityExpression_59_Var
		 = (EqualityExpression)Expr_58_list.get(0);
		Assert.assertNotNull(EqualityExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = EqualityExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final RelationalExpression RelationalExpression_60_Var
		 = (RelationalExpression)Expr_59_list.get(0);
		Assert.assertNotNull(RelationalExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = RelationalExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final ShiftExpression ShiftExpression_61_Var
		 = (ShiftExpression)Expr_60_list.get(0);
		Assert.assertNotNull(ShiftExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = ShiftExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final AdditiveExpression AdditiveExpression_62_Var
		 = (AdditiveExpression)Expr_61_list.get(0);
		Assert.assertNotNull(AdditiveExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = AdditiveExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final MultiplicativeExpression MultiplicativeExpression_63_Var
		 = (MultiplicativeExpression)Expr_62_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = MultiplicativeExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final CastExpression CastExpression_64_Var
		 = (CastExpression)Expr_63_list.get(0);
		Assert.assertNotNull(CastExpression_64_Var
		);
		//64
		final UnaryExpression UnaryExpression_65_Var
		 = (UnaryExpression)CastExpression_64_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_65_Var
		);
		//65
		final PostfixExpression PostfixExpression_66_Var
		 = (PostfixExpression)UnaryExpression_65_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_66_Var
		);
		//66
		final PrimaryExpression PrimaryExpression_67_Var
		 = (PrimaryExpression)PostfixExpression_66_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_67_Var
		);
		Assert.assertEquals("MINOR", PrimaryExpression_67_Var
		.getId());
		//67
		final GroupOpt GroupOpt_68_Var
		 = (GroupOpt)IfConditional_19_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_68_Var
		);
		final EList<? extends EObject> Lines_68_list = GroupOpt_68_Var
		.getLines();
		Assert.assertNotNull(Lines_68_list);
		Assert.assertEquals(1, Lines_68_list.size());
		//68
		final Code Code_69_Var
		 = (Code)Lines_68_list.get(0);
		Assert.assertNotNull(Code_69_Var
		);
		Assert.assertEquals("	void foo_bar();", Code_69_Var
		.getCode());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0076_IfComplexExpression.c");
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
				method.invoke(this.generator, "Test0076_IfComplexExpression.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0076_IfComplexExpression.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0076_IfComplexExpression.c"
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


