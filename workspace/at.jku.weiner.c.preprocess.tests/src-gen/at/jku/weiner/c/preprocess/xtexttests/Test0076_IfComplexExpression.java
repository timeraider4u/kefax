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
		Assert.assertEquals(9, Lines_1_list.size());
		//1
		final PreprocessorDirectives PreprocessorDirectives_2_Var
		 = (PreprocessorDirectives)Lines_1_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_2_Var
		);
		//2
		final DefineObjectMacro DefineObjectMacro_3_Var
		 = (DefineObjectMacro)PreprocessorDirectives_2_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_3_Var
		);
		Assert.assertEquals("REQ_MAJOR", DefineObjectMacro_3_Var
		.getId());
		Assert.assertEquals("3", DefineObjectMacro_3_Var
		.getString());
		//3
		final PreprocessorDirectives PreprocessorDirectives_4_Var
		 = (PreprocessorDirectives)Lines_1_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_4_Var
		);
		//4
		final DefineObjectMacro DefineObjectMacro_5_Var
		 = (DefineObjectMacro)PreprocessorDirectives_4_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_5_Var
		);
		Assert.assertEquals("REQ_MINOR", DefineObjectMacro_5_Var
		.getId());
		Assert.assertEquals("2", DefineObjectMacro_5_Var
		.getString());
		//5
		final NewLineLine NewLineLine_6_Var
		 = (NewLineLine)Lines_1_list.get(2);
		Assert.assertNotNull(NewLineLine_6_Var
		);
		//6
		final PreprocessorDirectives PreprocessorDirectives_7_Var
		 = (PreprocessorDirectives)Lines_1_list.get(3);
		Assert.assertNotNull(PreprocessorDirectives_7_Var
		);
		//7
		final DefineObjectMacro DefineObjectMacro_8_Var
		 = (DefineObjectMacro)PreprocessorDirectives_7_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_8_Var
		);
		Assert.assertEquals("MAJOR", DefineObjectMacro_8_Var
		.getId());
		Assert.assertEquals("1", DefineObjectMacro_8_Var
		.getString());
		//8
		final PreprocessorDirectives PreprocessorDirectives_9_Var
		 = (PreprocessorDirectives)Lines_1_list.get(4);
		Assert.assertNotNull(PreprocessorDirectives_9_Var
		);
		//9
		final DefineObjectMacro DefineObjectMacro_10_Var
		 = (DefineObjectMacro)PreprocessorDirectives_9_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_10_Var
		);
		Assert.assertEquals("MINOR", DefineObjectMacro_10_Var
		.getId());
		Assert.assertEquals("4", DefineObjectMacro_10_Var
		.getString());
		//10
		final NewLineLine NewLineLine_11_Var
		 = (NewLineLine)Lines_1_list.get(5);
		Assert.assertNotNull(NewLineLine_11_Var
		);
		//11
		final PreprocessorDirectives PreprocessorDirectives_12_Var
		 = (PreprocessorDirectives)Lines_1_list.get(6);
		Assert.assertNotNull(PreprocessorDirectives_12_Var
		);
		//12
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_13_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_12_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_13_Var
		);
		Assert.assertEquals("REQ", DefineFunctionLikeMacro_13_Var
		.getId());
		//13
		final IdentifierList IdentifierList_14_Var
		 = (IdentifierList)DefineFunctionLikeMacro_13_Var
		.getList();
		Assert.assertNotNull(IdentifierList_14_Var
		);
		Assert.assertEquals("[major, minor]", IdentifierList_14_Var
		.getId().toString());
		Assert.assertEquals("((major << 32) + minor >= ((REQ_MAJOR) << 32) + (REQ_MINOR))", DefineFunctionLikeMacro_13_Var
		.getString());
		//14
		final NewLineLine NewLineLine_15_Var
		 = (NewLineLine)Lines_1_list.get(7);
		Assert.assertNotNull(NewLineLine_15_Var
		);
		//15
		final PreprocessorDirectives PreprocessorDirectives_16_Var
		 = (PreprocessorDirectives)Lines_1_list.get(8);
		Assert.assertNotNull(PreprocessorDirectives_16_Var
		);
		//16
		final ConditionalDirective ConditionalDirective_17_Var
		 = (ConditionalDirective)PreprocessorDirectives_16_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_17_Var
		);
		//17
		final IfConditional IfConditional_18_Var
		 = (IfConditional)ConditionalDirective_17_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_18_Var
		);
		//18
		final ConstantExpression ConstantExpression_19_Var
		 = (ConstantExpression)IfConditional_18_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_19_Var
		);
		//19
		final ConditionalExpression ConditionalExpression_20_Var
		 = (ConditionalExpression)ConstantExpression_19_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_20_Var
		);
		//20
		final LogicalOrExpression LogicalOrExpression_21_Var
		 = (LogicalOrExpression)ConditionalExpression_20_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = LogicalOrExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final LogicalAndExpression LogicalAndExpression_22_Var
		 = (LogicalAndExpression)Expr_21_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = LogicalAndExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final InclusiveOrExpression InclusiveOrExpression_23_Var
		 = (InclusiveOrExpression)Expr_22_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = InclusiveOrExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final ExclusiveOrExpression ExclusiveOrExpression_24_Var
		 = (ExclusiveOrExpression)Expr_23_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = ExclusiveOrExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final AndExpression AndExpression_25_Var
		 = (AndExpression)Expr_24_list.get(0);
		Assert.assertNotNull(AndExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = AndExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final EqualityExpression EqualityExpression_26_Var
		 = (EqualityExpression)Expr_25_list.get(0);
		Assert.assertNotNull(EqualityExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = EqualityExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final RelationalExpression RelationalExpression_27_Var
		 = (RelationalExpression)Expr_26_list.get(0);
		Assert.assertNotNull(RelationalExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = RelationalExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final ShiftExpression ShiftExpression_28_Var
		 = (ShiftExpression)Expr_27_list.get(0);
		Assert.assertNotNull(ShiftExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = ShiftExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final AdditiveExpression AdditiveExpression_29_Var
		 = (AdditiveExpression)Expr_28_list.get(0);
		Assert.assertNotNull(AdditiveExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = AdditiveExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final MultiplicativeExpression MultiplicativeExpression_30_Var
		 = (MultiplicativeExpression)Expr_29_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = MultiplicativeExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final CastExpression CastExpression_31_Var
		 = (CastExpression)Expr_30_list.get(0);
		Assert.assertNotNull(CastExpression_31_Var
		);
		//31
		final UnaryExpression UnaryExpression_32_Var
		 = (UnaryExpression)CastExpression_31_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_32_Var
		);
		//32
		final PostfixExpression PostfixExpression_33_Var
		 = (PostfixExpression)UnaryExpression_32_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_33_Var
		);
		//33
		final PrimaryExpression PrimaryExpression_34_Var
		 = (PrimaryExpression)PostfixExpression_33_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_34_Var
		);
		Assert.assertEquals("REQ", PrimaryExpression_34_Var
		.getId());
		final EList<? extends EObject> Suffix_34_list = PostfixExpression_33_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_34_list);
		Assert.assertEquals(1, Suffix_34_list.size());
		//34
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_35_Var
		 = (PostfixExpressionSuffixArgument)Suffix_34_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_35_Var
		);
		//35
		final ArgumentExpressionList ArgumentExpressionList_36_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_35_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_36_Var
		);
		final EList<? extends EObject> Expr_36_list = ArgumentExpressionList_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(2, Expr_36_list.size());
		//36
		final ConditionalExpression ConditionalExpression_37_Var
		 = (ConditionalExpression)Expr_36_list.get(0);
		Assert.assertNotNull(ConditionalExpression_37_Var
		);
		//37
		final LogicalOrExpression LogicalOrExpression_38_Var
		 = (LogicalOrExpression)ConditionalExpression_37_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = LogicalOrExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final LogicalAndExpression LogicalAndExpression_39_Var
		 = (LogicalAndExpression)Expr_38_list.get(0);
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
		Assert.assertEquals("MAJOR", PrimaryExpression_51_Var
		.getId());
		//51
		final ConditionalExpression ConditionalExpression_52_Var
		 = (ConditionalExpression)Expr_36_list.get(1);
		Assert.assertNotNull(ConditionalExpression_52_Var
		);
		//52
		final LogicalOrExpression LogicalOrExpression_53_Var
		 = (LogicalOrExpression)ConditionalExpression_52_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = LogicalOrExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final LogicalAndExpression LogicalAndExpression_54_Var
		 = (LogicalAndExpression)Expr_53_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = LogicalAndExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final InclusiveOrExpression InclusiveOrExpression_55_Var
		 = (InclusiveOrExpression)Expr_54_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = InclusiveOrExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final ExclusiveOrExpression ExclusiveOrExpression_56_Var
		 = (ExclusiveOrExpression)Expr_55_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = ExclusiveOrExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final AndExpression AndExpression_57_Var
		 = (AndExpression)Expr_56_list.get(0);
		Assert.assertNotNull(AndExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = AndExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final EqualityExpression EqualityExpression_58_Var
		 = (EqualityExpression)Expr_57_list.get(0);
		Assert.assertNotNull(EqualityExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = EqualityExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final RelationalExpression RelationalExpression_59_Var
		 = (RelationalExpression)Expr_58_list.get(0);
		Assert.assertNotNull(RelationalExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = RelationalExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final ShiftExpression ShiftExpression_60_Var
		 = (ShiftExpression)Expr_59_list.get(0);
		Assert.assertNotNull(ShiftExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = ShiftExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final AdditiveExpression AdditiveExpression_61_Var
		 = (AdditiveExpression)Expr_60_list.get(0);
		Assert.assertNotNull(AdditiveExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = AdditiveExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final MultiplicativeExpression MultiplicativeExpression_62_Var
		 = (MultiplicativeExpression)Expr_61_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = MultiplicativeExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final CastExpression CastExpression_63_Var
		 = (CastExpression)Expr_62_list.get(0);
		Assert.assertNotNull(CastExpression_63_Var
		);
		//63
		final UnaryExpression UnaryExpression_64_Var
		 = (UnaryExpression)CastExpression_63_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_64_Var
		);
		//64
		final PostfixExpression PostfixExpression_65_Var
		 = (PostfixExpression)UnaryExpression_64_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_65_Var
		);
		//65
		final PrimaryExpression PrimaryExpression_66_Var
		 = (PrimaryExpression)PostfixExpression_65_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_66_Var
		);
		Assert.assertEquals("MINOR", PrimaryExpression_66_Var
		.getId());
		//66
		final GroupOpt GroupOpt_67_Var
		 = (GroupOpt)IfConditional_18_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_67_Var
		);
		final EList<? extends EObject> Lines_67_list = GroupOpt_67_Var
		.getLines();
		Assert.assertNotNull(Lines_67_list);
		Assert.assertEquals(1, Lines_67_list.size());
		//67
		final Code Code_68_Var
		 = (Code)Lines_67_list.get(0);
		Assert.assertNotNull(Code_68_Var
		);
		Assert.assertEquals("	void foo_bar();", Code_68_Var
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


