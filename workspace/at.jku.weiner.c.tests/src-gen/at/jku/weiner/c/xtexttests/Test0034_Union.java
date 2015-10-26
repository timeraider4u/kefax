package at.jku.weiner.c.xtexttests;

import com.google.inject.Inject;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.antlr.runtime.Token;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import at.jku.weiner.c.tests.CInjectorProvider;
import at.jku.weiner.c.parser.antlr.CParser;
import at.jku.weiner.c.parser.antlr.internal.InternalCLexer;
import at.jku.weiner.c.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.c.Model;
import at.jku.weiner.c.c.TranslationUnit;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.FunctionDefHead;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.DeclaratorSuffix;
import at.jku.weiner.c.c.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.c.ParameterTypeList;
import at.jku.weiner.c.c.ParameterList;
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.FunctionDefinition;
import at.jku.weiner.c.c.BodyStatement;
import at.jku.weiner.c.c.BlockList;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.ArgumentExpressionList;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.JumpStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;

@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0034_Union {

	@Inject
	private ParseHelper<Model> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalCLexer lexer;
	@Inject
	private CParser parser;
	@Inject
	private ITokenDefProvider tokenDefProvider;
	
	private LexerAndParserTest testHelper;
	
	@Before
	public void initialize(){
		this.testHelper = new LexerAndParserTest(lexer, parser, tokenDefProvider);
	}
	
	private String getSourceText()
	throws Exception{
		final Path path = Paths.get("res/Test0034_Union.c");
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
	@Test
	public void checkLexerTokens()
	throws Exception{
		final String text = this.getSourceText();
		//System.out.println(text);
		final String[] expected = new String[] {
			"RULE_LINEDIRECTIVE",
			"RULE_NEWLINE",
			"RULE_NEWLINE",
			"RULE_KW_INT",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_LEFTPAREN",
			"RULE_KW_VOID",
			"RULE_RIGHTPAREN",
			"RULE_WHITESPACE",
			"RULE_LEFTBRACE",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_LEFTPAREN",
			"RULE_STRING_LITERAL",
			"RULE_COMMA",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_DOT",
			"RULE_ID",
			"RULE_RIGHTPAREN",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_KW_RETURN",
			"RULE_WHITESPACE",
			"RULE_DECIMAL_LITERAL",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_RIGHTBRACE",
			"RULE_NEWLINE",
		};
		//final List<Token> actual = testHelper.getTokens(text);
		//testHelper.outputTokens(text);
		testHelper.checkTokenisation(text, expected);
	}
	
	@Test
	public void checkParserResult()
	throws Exception{

		final String text = this.getSourceText();
		final Model Model_0_Var = this.parseHelper.parse(text);
	
		this.valHelper.assertNoErrors(Model_0_Var);
		Assert.assertNotNull(Model_0_Var);
		final EList<? extends EObject> Unit_0_list = Model_0_Var.getUnit();
		Assert.assertNotNull(Unit_0_list);
		Assert.assertEquals(1, Unit_0_list.size());
		final TranslationUnit TranslationUnit_1_Var = (TranslationUnit)Unit_0_list.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var);
		final EList<? extends EObject> External_1_list = TranslationUnit_1_Var.getExternal();
		Assert.assertNotNull(External_1_list);
		Assert.assertEquals(1, External_1_list.size());
		final ExternalDeclaration ExternalDeclaration_2_Var = (ExternalDeclaration)External_1_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_2_Var);
		final FunctionDefHead FunctionDefHead_3_Var = (FunctionDefHead)ExternalDeclaration_2_Var.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_3_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_4_Var = (DeclarationSpecifiers)FunctionDefHead_3_Var.getFunDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_4_Var);
		final EList<? extends EObject> DeclarationSpecifier_4_list = DeclarationSpecifiers_4_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_4_list);
		Assert.assertEquals(1, DeclarationSpecifier_4_list.size());
		final TypeSpecifier TypeSpecifier_5_Var = (TypeSpecifier)DeclarationSpecifier_4_list.get(0);
		Assert.assertNotNull(TypeSpecifier_5_Var);
		Assert.assertEquals("int", TypeSpecifier_5_Var.getName());
		final Declarator Declarator_6_Var = (Declarator)FunctionDefHead_3_Var.getFunDeclarator();
		Assert.assertNotNull(Declarator_6_Var);
		final DirectDeclarator DirectDeclarator_7_Var = (DirectDeclarator)Declarator_6_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_7_Var);
		Assert.assertEquals("main", DirectDeclarator_7_Var.getId());
		final EList<? extends EObject> DeclaratorSuffix_7_list = DirectDeclarator_7_Var.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_7_list);
		Assert.assertEquals(1, DeclaratorSuffix_7_list.size());
		final DeclaratorSuffix DeclaratorSuffix_8_Var = (DeclaratorSuffix)DeclaratorSuffix_7_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_8_Var);
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_9_Var = (DirectDeclaratorLastSuffix)DeclaratorSuffix_8_Var.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_9_Var);
		final EList<? extends EObject> ParameterTypeList_9_list = DirectDeclaratorLastSuffix_9_Var.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_9_list);
		Assert.assertEquals(1, ParameterTypeList_9_list.size());
		final ParameterTypeList ParameterTypeList_10_Var = (ParameterTypeList)ParameterTypeList_9_list.get(0);
		Assert.assertNotNull(ParameterTypeList_10_Var);
		final ParameterList ParameterList_11_Var = (ParameterList)ParameterTypeList_10_Var.getList();
		Assert.assertNotNull(ParameterList_11_Var);
		final EList<? extends EObject> ParameterDeclaration_11_list = ParameterList_11_Var.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_11_list);
		Assert.assertEquals(1, ParameterDeclaration_11_list.size());
		final ParameterDeclaration ParameterDeclaration_12_Var = (ParameterDeclaration)ParameterDeclaration_11_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_12_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_13_Var = (DeclarationSpecifiers)ParameterDeclaration_12_Var.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_13_Var);
		final EList<? extends EObject> DeclarationSpecifier_13_list = DeclarationSpecifiers_13_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_13_list);
		Assert.assertEquals(1, DeclarationSpecifier_13_list.size());
		final TypeSpecifier TypeSpecifier_14_Var = (TypeSpecifier)DeclarationSpecifier_13_list.get(0);
		Assert.assertNotNull(TypeSpecifier_14_Var);
		Assert.assertEquals("void", TypeSpecifier_14_Var.getName());
		final FunctionDefinition FunctionDefinition_15_Var = (FunctionDefinition)ExternalDeclaration_2_Var.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_15_Var);
		final BodyStatement BodyStatement_16_Var = (BodyStatement)FunctionDefinition_15_Var.getBody();
		Assert.assertNotNull(BodyStatement_16_Var);
		final EList<? extends EObject> BlockList_16_list = BodyStatement_16_Var.getBlockList();
		Assert.assertNotNull(BlockList_16_list);
		Assert.assertEquals(1, BlockList_16_list.size());
		final BlockList BlockList_17_Var = (BlockList)BlockList_16_list.get(0);
		Assert.assertNotNull(BlockList_17_Var);
		final EList<? extends EObject> Statement_17_list = BlockList_17_Var.getStatement();
		Assert.assertNotNull(Statement_17_list);
		Assert.assertEquals(2, Statement_17_list.size());
		final Statement Statement_18_Var = (Statement)Statement_17_list.get(0);
		Assert.assertNotNull(Statement_18_Var);
		final ExpressionStatement ExpressionStatement_19_Var = (ExpressionStatement)Statement_18_Var.getStmt();
		Assert.assertNotNull(ExpressionStatement_19_Var);
		final Expression Expression_20_Var = (Expression)ExpressionStatement_19_Var.getExpression();
		Assert.assertNotNull(Expression_20_Var);
		final EList<? extends EObject> ExprExpr_20_list = Expression_20_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_20_list);
		Assert.assertEquals(1, ExprExpr_20_list.size());
		final AssignmentExpression AssignmentExpression_21_Var = (AssignmentExpression)ExprExpr_20_list.get(0);
		Assert.assertNotNull(AssignmentExpression_21_Var);
		final ConditionalExpression ConditionalExpression_22_Var = (ConditionalExpression)AssignmentExpression_21_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_22_Var);
		final LogicalOrExpression LogicalOrExpression_23_Var = (LogicalOrExpression)ConditionalExpression_22_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_23_Var);
		final EList<? extends EObject> Expr_23_list = LogicalOrExpression_23_Var.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		final LogicalAndExpression LogicalAndExpression_24_Var = (LogicalAndExpression)Expr_23_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_24_Var);
		final EList<? extends EObject> Expr_24_list = LogicalAndExpression_24_Var.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		final InclusiveOrExpression InclusiveOrExpression_25_Var = (InclusiveOrExpression)Expr_24_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_25_Var);
		final EList<? extends EObject> Expr_25_list = InclusiveOrExpression_25_Var.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_26_Var = (ExclusiveOrExpression)Expr_25_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_26_Var);
		final EList<? extends EObject> Expr_26_list = ExclusiveOrExpression_26_Var.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		final AndExpression AndExpression_27_Var = (AndExpression)Expr_26_list.get(0);
		Assert.assertNotNull(AndExpression_27_Var);
		final EList<? extends EObject> Expr_27_list = AndExpression_27_Var.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		final EqualityExpression EqualityExpression_28_Var = (EqualityExpression)Expr_27_list.get(0);
		Assert.assertNotNull(EqualityExpression_28_Var);
		final EList<? extends EObject> Expr_28_list = EqualityExpression_28_Var.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		final RelationalExpression RelationalExpression_29_Var = (RelationalExpression)Expr_28_list.get(0);
		Assert.assertNotNull(RelationalExpression_29_Var);
		final EList<? extends EObject> Expr_29_list = RelationalExpression_29_Var.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		final ShiftExpression ShiftExpression_30_Var = (ShiftExpression)Expr_29_list.get(0);
		Assert.assertNotNull(ShiftExpression_30_Var);
		final EList<? extends EObject> Expr_30_list = ShiftExpression_30_Var.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		final AdditiveExpression AdditiveExpression_31_Var = (AdditiveExpression)Expr_30_list.get(0);
		Assert.assertNotNull(AdditiveExpression_31_Var);
		final EList<? extends EObject> Expr_31_list = AdditiveExpression_31_Var.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		final MultiplicativeExpression MultiplicativeExpression_32_Var = (MultiplicativeExpression)Expr_31_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_32_Var);
		final EList<? extends EObject> Expr_32_list = MultiplicativeExpression_32_Var.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		final CastExpression CastExpression_33_Var = (CastExpression)Expr_32_list.get(0);
		Assert.assertNotNull(CastExpression_33_Var);
		final UnaryExpression UnaryExpression_34_Var = (UnaryExpression)CastExpression_33_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_34_Var);
		final PostfixExpression PostfixExpression_35_Var = (PostfixExpression)UnaryExpression_34_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_35_Var);
		final EList<? extends EObject> Expr_35_list = PostfixExpression_35_Var.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		final PrimaryExpression PrimaryExpression_36_Var = (PrimaryExpression)Expr_35_list.get(0);
		Assert.assertNotNull(PrimaryExpression_36_Var);
		Assert.assertEquals("printf", PrimaryExpression_36_Var.getId());
		final EList<? extends EObject> ArgumentExpressionList_36_list = PostfixExpression_35_Var.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_36_list);
		Assert.assertEquals(1, ArgumentExpressionList_36_list.size());
		final ArgumentExpressionList ArgumentExpressionList_37_Var = (ArgumentExpressionList)ArgumentExpressionList_36_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_37_Var);
		final EList<? extends EObject> Expr_37_list = ArgumentExpressionList_37_Var.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(2, Expr_37_list.size());
		final AssignmentExpression AssignmentExpression_38_Var = (AssignmentExpression)Expr_37_list.get(0);
		Assert.assertNotNull(AssignmentExpression_38_Var);
		final ConditionalExpression ConditionalExpression_39_Var = (ConditionalExpression)AssignmentExpression_38_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_39_Var);
		final LogicalOrExpression LogicalOrExpression_40_Var = (LogicalOrExpression)ConditionalExpression_39_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_40_Var);
		final EList<? extends EObject> Expr_40_list = LogicalOrExpression_40_Var.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		final LogicalAndExpression LogicalAndExpression_41_Var = (LogicalAndExpression)Expr_40_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_41_Var);
		final EList<? extends EObject> Expr_41_list = LogicalAndExpression_41_Var.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		final InclusiveOrExpression InclusiveOrExpression_42_Var = (InclusiveOrExpression)Expr_41_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_42_Var);
		final EList<? extends EObject> Expr_42_list = InclusiveOrExpression_42_Var.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_43_Var = (ExclusiveOrExpression)Expr_42_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_43_Var);
		final EList<? extends EObject> Expr_43_list = ExclusiveOrExpression_43_Var.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		final AndExpression AndExpression_44_Var = (AndExpression)Expr_43_list.get(0);
		Assert.assertNotNull(AndExpression_44_Var);
		final EList<? extends EObject> Expr_44_list = AndExpression_44_Var.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		final EqualityExpression EqualityExpression_45_Var = (EqualityExpression)Expr_44_list.get(0);
		Assert.assertNotNull(EqualityExpression_45_Var);
		final EList<? extends EObject> Expr_45_list = EqualityExpression_45_Var.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		final RelationalExpression RelationalExpression_46_Var = (RelationalExpression)Expr_45_list.get(0);
		Assert.assertNotNull(RelationalExpression_46_Var);
		final EList<? extends EObject> Expr_46_list = RelationalExpression_46_Var.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		final ShiftExpression ShiftExpression_47_Var = (ShiftExpression)Expr_46_list.get(0);
		Assert.assertNotNull(ShiftExpression_47_Var);
		final EList<? extends EObject> Expr_47_list = ShiftExpression_47_Var.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		final AdditiveExpression AdditiveExpression_48_Var = (AdditiveExpression)Expr_47_list.get(0);
		Assert.assertNotNull(AdditiveExpression_48_Var);
		final EList<? extends EObject> Expr_48_list = AdditiveExpression_48_Var.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		final MultiplicativeExpression MultiplicativeExpression_49_Var = (MultiplicativeExpression)Expr_48_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_49_Var);
		final EList<? extends EObject> Expr_49_list = MultiplicativeExpression_49_Var.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		final CastExpression CastExpression_50_Var = (CastExpression)Expr_49_list.get(0);
		Assert.assertNotNull(CastExpression_50_Var);
		final UnaryExpression UnaryExpression_51_Var = (UnaryExpression)CastExpression_50_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_51_Var);
		final PostfixExpression PostfixExpression_52_Var = (PostfixExpression)UnaryExpression_51_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_52_Var);
		final EList<? extends EObject> Expr_52_list = PostfixExpression_52_Var.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		final PrimaryExpression PrimaryExpression_53_Var = (PrimaryExpression)Expr_52_list.get(0);
		Assert.assertNotNull(PrimaryExpression_53_Var);
		final Constant Constant_54_Var = (Constant)PrimaryExpression_53_Var.getConst();
		Assert.assertNotNull(Constant_54_Var);
		Assert.assertEquals("\"number.numFloat=%f\\n\"", Constant_54_Var.getStr());
		final AssignmentExpression AssignmentExpression_55_Var = (AssignmentExpression)Expr_37_list.get(1);
		Assert.assertNotNull(AssignmentExpression_55_Var);
		final ConditionalExpression ConditionalExpression_56_Var = (ConditionalExpression)AssignmentExpression_55_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_56_Var);
		final LogicalOrExpression LogicalOrExpression_57_Var = (LogicalOrExpression)ConditionalExpression_56_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_57_Var);
		final EList<? extends EObject> Expr_57_list = LogicalOrExpression_57_Var.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		final LogicalAndExpression LogicalAndExpression_58_Var = (LogicalAndExpression)Expr_57_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_58_Var);
		final EList<? extends EObject> Expr_58_list = LogicalAndExpression_58_Var.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		final InclusiveOrExpression InclusiveOrExpression_59_Var = (InclusiveOrExpression)Expr_58_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_59_Var);
		final EList<? extends EObject> Expr_59_list = InclusiveOrExpression_59_Var.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_60_Var = (ExclusiveOrExpression)Expr_59_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_60_Var);
		final EList<? extends EObject> Expr_60_list = ExclusiveOrExpression_60_Var.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		final AndExpression AndExpression_61_Var = (AndExpression)Expr_60_list.get(0);
		Assert.assertNotNull(AndExpression_61_Var);
		final EList<? extends EObject> Expr_61_list = AndExpression_61_Var.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		final EqualityExpression EqualityExpression_62_Var = (EqualityExpression)Expr_61_list.get(0);
		Assert.assertNotNull(EqualityExpression_62_Var);
		final EList<? extends EObject> Expr_62_list = EqualityExpression_62_Var.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		final RelationalExpression RelationalExpression_63_Var = (RelationalExpression)Expr_62_list.get(0);
		Assert.assertNotNull(RelationalExpression_63_Var);
		final EList<? extends EObject> Expr_63_list = RelationalExpression_63_Var.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		final ShiftExpression ShiftExpression_64_Var = (ShiftExpression)Expr_63_list.get(0);
		Assert.assertNotNull(ShiftExpression_64_Var);
		final EList<? extends EObject> Expr_64_list = ShiftExpression_64_Var.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		final AdditiveExpression AdditiveExpression_65_Var = (AdditiveExpression)Expr_64_list.get(0);
		Assert.assertNotNull(AdditiveExpression_65_Var);
		final EList<? extends EObject> Expr_65_list = AdditiveExpression_65_Var.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		final MultiplicativeExpression MultiplicativeExpression_66_Var = (MultiplicativeExpression)Expr_65_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_66_Var);
		final EList<? extends EObject> Expr_66_list = MultiplicativeExpression_66_Var.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		final CastExpression CastExpression_67_Var = (CastExpression)Expr_66_list.get(0);
		Assert.assertNotNull(CastExpression_67_Var);
		final UnaryExpression UnaryExpression_68_Var = (UnaryExpression)CastExpression_67_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_68_Var);
		final PostfixExpression PostfixExpression_69_Var = (PostfixExpression)UnaryExpression_68_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_69_Var);
		final EList<? extends EObject> Expr_69_list = PostfixExpression_69_Var.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		final PrimaryExpression PrimaryExpression_70_Var = (PrimaryExpression)Expr_69_list.get(0);
		Assert.assertNotNull(PrimaryExpression_70_Var);
		Assert.assertEquals("number", PrimaryExpression_70_Var.getId());
		Assert.assertEquals("[.]", PostfixExpression_69_Var.getDot().toString());
		Assert.assertEquals("[numFloat]", PostfixExpression_69_Var.getId().toString());
		Assert.assertEquals(";", ExpressionStatement_19_Var.getSemi());
		final Statement Statement_71_Var = (Statement)Statement_17_list.get(1);
		Assert.assertNotNull(Statement_71_Var);
		final JumpStatement JumpStatement_72_Var = (JumpStatement)Statement_71_Var.getStmt();
		Assert.assertNotNull(JumpStatement_72_Var);
		final Expression Expression_73_Var = (Expression)JumpStatement_72_Var.getExpr();
		Assert.assertNotNull(Expression_73_Var);
		final EList<? extends EObject> ExprExpr_73_list = Expression_73_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_73_list);
		Assert.assertEquals(1, ExprExpr_73_list.size());
		final AssignmentExpression AssignmentExpression_74_Var = (AssignmentExpression)ExprExpr_73_list.get(0);
		Assert.assertNotNull(AssignmentExpression_74_Var);
		final ConditionalExpression ConditionalExpression_75_Var = (ConditionalExpression)AssignmentExpression_74_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_75_Var);
		final LogicalOrExpression LogicalOrExpression_76_Var = (LogicalOrExpression)ConditionalExpression_75_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_76_Var);
		final EList<? extends EObject> Expr_76_list = LogicalOrExpression_76_Var.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		final LogicalAndExpression LogicalAndExpression_77_Var = (LogicalAndExpression)Expr_76_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_77_Var);
		final EList<? extends EObject> Expr_77_list = LogicalAndExpression_77_Var.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		final InclusiveOrExpression InclusiveOrExpression_78_Var = (InclusiveOrExpression)Expr_77_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_78_Var);
		final EList<? extends EObject> Expr_78_list = InclusiveOrExpression_78_Var.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_79_Var = (ExclusiveOrExpression)Expr_78_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_79_Var);
		final EList<? extends EObject> Expr_79_list = ExclusiveOrExpression_79_Var.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		final AndExpression AndExpression_80_Var = (AndExpression)Expr_79_list.get(0);
		Assert.assertNotNull(AndExpression_80_Var);
		final EList<? extends EObject> Expr_80_list = AndExpression_80_Var.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		final EqualityExpression EqualityExpression_81_Var = (EqualityExpression)Expr_80_list.get(0);
		Assert.assertNotNull(EqualityExpression_81_Var);
		final EList<? extends EObject> Expr_81_list = EqualityExpression_81_Var.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		final RelationalExpression RelationalExpression_82_Var = (RelationalExpression)Expr_81_list.get(0);
		Assert.assertNotNull(RelationalExpression_82_Var);
		final EList<? extends EObject> Expr_82_list = RelationalExpression_82_Var.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		final ShiftExpression ShiftExpression_83_Var = (ShiftExpression)Expr_82_list.get(0);
		Assert.assertNotNull(ShiftExpression_83_Var);
		final EList<? extends EObject> Expr_83_list = ShiftExpression_83_Var.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		final AdditiveExpression AdditiveExpression_84_Var = (AdditiveExpression)Expr_83_list.get(0);
		Assert.assertNotNull(AdditiveExpression_84_Var);
		final EList<? extends EObject> Expr_84_list = AdditiveExpression_84_Var.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		final MultiplicativeExpression MultiplicativeExpression_85_Var = (MultiplicativeExpression)Expr_84_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_85_Var);
		final EList<? extends EObject> Expr_85_list = MultiplicativeExpression_85_Var.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		final CastExpression CastExpression_86_Var = (CastExpression)Expr_85_list.get(0);
		Assert.assertNotNull(CastExpression_86_Var);
		final UnaryExpression UnaryExpression_87_Var = (UnaryExpression)CastExpression_86_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_87_Var);
		final PostfixExpression PostfixExpression_88_Var = (PostfixExpression)UnaryExpression_87_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_88_Var);
		final EList<? extends EObject> Expr_88_list = PostfixExpression_88_Var.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		final PrimaryExpression PrimaryExpression_89_Var = (PrimaryExpression)Expr_88_list.get(0);
		Assert.assertNotNull(PrimaryExpression_89_Var);
		final Constant Constant_90_Var = (Constant)PrimaryExpression_89_Var.getConst();
		Assert.assertNotNull(Constant_90_Var);
		Assert.assertEquals("0", Constant_90_Var.getDec());
		Assert.assertEquals("return", JumpStatement_72_Var.getReturn());
		Assert.assertEquals(";", JumpStatement_72_Var.getSemi());
	}


}
