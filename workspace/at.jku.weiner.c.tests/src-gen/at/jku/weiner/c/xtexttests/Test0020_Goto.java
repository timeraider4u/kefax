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
import at.jku.weiner.c.c.FunctionDefinition;
import at.jku.weiner.c.c.BodyStatement;
import at.jku.weiner.c.c.BlockList;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.JumpStatement;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
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
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.LabeledStatement;
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

@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0020_Goto {

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
		final Path path = Paths.get("res/Test0020_Goto.c");
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
	@Test
	public void checkLexerTokens()
	throws Exception{
		final String text = this.getSourceText();
		//System.out.println(text);
		final String[] expected = new String[] {
			"RULE_KW_VOID",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_LEFTPAREN",
			"RULE_RIGHTPAREN",
			"RULE_WHITESPACE",
			"RULE_LEFTBRACE",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_KW_GOTO",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_LEFTPAREN",
			"RULE_STRING_LITERAL",
			"RULE_RIGHTPAREN",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_COLON",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_LEFTPAREN",
			"RULE_STRING_LITERAL",
			"RULE_RIGHTPAREN",
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
		Assert.assertEquals("void", TypeSpecifier_5_Var.getName());
		final Declarator Declarator_6_Var = (Declarator)FunctionDefHead_3_Var.getFunDeclarator();
		Assert.assertNotNull(Declarator_6_Var);
		final DirectDeclarator DirectDeclarator_7_Var = (DirectDeclarator)Declarator_6_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_7_Var);
		Assert.assertEquals("doSomething", DirectDeclarator_7_Var.getId());
		final FunctionDefinition FunctionDefinition_8_Var = (FunctionDefinition)ExternalDeclaration_2_Var.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_8_Var);
		final BodyStatement BodyStatement_9_Var = (BodyStatement)FunctionDefinition_8_Var.getBody();
		Assert.assertNotNull(BodyStatement_9_Var);
		final EList<? extends EObject> BlockList_9_list = BodyStatement_9_Var.getBlockList();
		Assert.assertNotNull(BlockList_9_list);
		Assert.assertEquals(1, BlockList_9_list.size());
		final BlockList BlockList_10_Var = (BlockList)BlockList_9_list.get(0);
		Assert.assertNotNull(BlockList_10_Var);
		final EList<? extends EObject> Statement_10_list = BlockList_10_Var.getStatement();
		Assert.assertNotNull(Statement_10_list);
		Assert.assertEquals(3, Statement_10_list.size());
		final Statement Statement_11_Var = (Statement)Statement_10_list.get(0);
		Assert.assertNotNull(Statement_11_Var);
		final JumpStatement JumpStatement_12_Var = (JumpStatement)Statement_11_Var.getStmt();
		Assert.assertNotNull(JumpStatement_12_Var);
		final UnaryExpression UnaryExpression_13_Var = (UnaryExpression)JumpStatement_12_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_13_Var);
		final PostfixExpression PostfixExpression_14_Var = (PostfixExpression)UnaryExpression_13_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_14_Var);
		final EList<? extends EObject> Expr_14_list = PostfixExpression_14_Var.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		final PrimaryExpression PrimaryExpression_15_Var = (PrimaryExpression)Expr_14_list.get(0);
		Assert.assertNotNull(PrimaryExpression_15_Var);
		Assert.assertEquals("target", PrimaryExpression_15_Var.getId());
		Assert.assertEquals("goto", JumpStatement_12_Var.getGoto());
		Assert.assertEquals(";", JumpStatement_12_Var.getSemi());
		final Statement Statement_16_Var = (Statement)Statement_10_list.get(1);
		Assert.assertNotNull(Statement_16_Var);
		final ExpressionStatement ExpressionStatement_17_Var = (ExpressionStatement)Statement_16_Var.getStmt();
		Assert.assertNotNull(ExpressionStatement_17_Var);
		final Expression Expression_18_Var = (Expression)ExpressionStatement_17_Var.getExpression();
		Assert.assertNotNull(Expression_18_Var);
		final EList<? extends EObject> ExprExpr_18_list = Expression_18_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_18_list);
		Assert.assertEquals(1, ExprExpr_18_list.size());
		final AssignmentExpression AssignmentExpression_19_Var = (AssignmentExpression)ExprExpr_18_list.get(0);
		Assert.assertNotNull(AssignmentExpression_19_Var);
		final ConditionalExpression ConditionalExpression_20_Var = (ConditionalExpression)AssignmentExpression_19_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_20_Var);
		final LogicalOrExpression LogicalOrExpression_21_Var = (LogicalOrExpression)ConditionalExpression_20_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_21_Var);
		final EList<? extends EObject> Expr_21_list = LogicalOrExpression_21_Var.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		final LogicalAndExpression LogicalAndExpression_22_Var = (LogicalAndExpression)Expr_21_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_22_Var);
		final EList<? extends EObject> Expr_22_list = LogicalAndExpression_22_Var.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		final InclusiveOrExpression InclusiveOrExpression_23_Var = (InclusiveOrExpression)Expr_22_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_23_Var);
		final EList<? extends EObject> Expr_23_list = InclusiveOrExpression_23_Var.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_24_Var = (ExclusiveOrExpression)Expr_23_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_24_Var);
		final EList<? extends EObject> Expr_24_list = ExclusiveOrExpression_24_Var.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		final AndExpression AndExpression_25_Var = (AndExpression)Expr_24_list.get(0);
		Assert.assertNotNull(AndExpression_25_Var);
		final EList<? extends EObject> Expr_25_list = AndExpression_25_Var.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		final EqualityExpression EqualityExpression_26_Var = (EqualityExpression)Expr_25_list.get(0);
		Assert.assertNotNull(EqualityExpression_26_Var);
		final EList<? extends EObject> Expr_26_list = EqualityExpression_26_Var.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		final RelationalExpression RelationalExpression_27_Var = (RelationalExpression)Expr_26_list.get(0);
		Assert.assertNotNull(RelationalExpression_27_Var);
		final EList<? extends EObject> Expr_27_list = RelationalExpression_27_Var.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		final ShiftExpression ShiftExpression_28_Var = (ShiftExpression)Expr_27_list.get(0);
		Assert.assertNotNull(ShiftExpression_28_Var);
		final EList<? extends EObject> Expr_28_list = ShiftExpression_28_Var.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		final AdditiveExpression AdditiveExpression_29_Var = (AdditiveExpression)Expr_28_list.get(0);
		Assert.assertNotNull(AdditiveExpression_29_Var);
		final EList<? extends EObject> Expr_29_list = AdditiveExpression_29_Var.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		final MultiplicativeExpression MultiplicativeExpression_30_Var = (MultiplicativeExpression)Expr_29_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_30_Var);
		final EList<? extends EObject> Expr_30_list = MultiplicativeExpression_30_Var.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		final CastExpression CastExpression_31_Var = (CastExpression)Expr_30_list.get(0);
		Assert.assertNotNull(CastExpression_31_Var);
		final UnaryExpression UnaryExpression_32_Var = (UnaryExpression)CastExpression_31_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_32_Var);
		final PostfixExpression PostfixExpression_33_Var = (PostfixExpression)UnaryExpression_32_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_33_Var);
		final EList<? extends EObject> Expr_33_list = PostfixExpression_33_Var.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		final PrimaryExpression PrimaryExpression_34_Var = (PrimaryExpression)Expr_33_list.get(0);
		Assert.assertNotNull(PrimaryExpression_34_Var);
		Assert.assertEquals("printf", PrimaryExpression_34_Var.getId());
		final EList<? extends EObject> ArgumentExpressionList_34_list = PostfixExpression_33_Var.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_34_list);
		Assert.assertEquals(1, ArgumentExpressionList_34_list.size());
		final ArgumentExpressionList ArgumentExpressionList_35_Var = (ArgumentExpressionList)ArgumentExpressionList_34_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_35_Var);
		final EList<? extends EObject> Expr_35_list = ArgumentExpressionList_35_Var.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		final AssignmentExpression AssignmentExpression_36_Var = (AssignmentExpression)Expr_35_list.get(0);
		Assert.assertNotNull(AssignmentExpression_36_Var);
		final ConditionalExpression ConditionalExpression_37_Var = (ConditionalExpression)AssignmentExpression_36_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_37_Var);
		final LogicalOrExpression LogicalOrExpression_38_Var = (LogicalOrExpression)ConditionalExpression_37_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_38_Var);
		final EList<? extends EObject> Expr_38_list = LogicalOrExpression_38_Var.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		final LogicalAndExpression LogicalAndExpression_39_Var = (LogicalAndExpression)Expr_38_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_39_Var);
		final EList<? extends EObject> Expr_39_list = LogicalAndExpression_39_Var.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		final InclusiveOrExpression InclusiveOrExpression_40_Var = (InclusiveOrExpression)Expr_39_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_40_Var);
		final EList<? extends EObject> Expr_40_list = InclusiveOrExpression_40_Var.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_41_Var = (ExclusiveOrExpression)Expr_40_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_41_Var);
		final EList<? extends EObject> Expr_41_list = ExclusiveOrExpression_41_Var.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		final AndExpression AndExpression_42_Var = (AndExpression)Expr_41_list.get(0);
		Assert.assertNotNull(AndExpression_42_Var);
		final EList<? extends EObject> Expr_42_list = AndExpression_42_Var.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		final EqualityExpression EqualityExpression_43_Var = (EqualityExpression)Expr_42_list.get(0);
		Assert.assertNotNull(EqualityExpression_43_Var);
		final EList<? extends EObject> Expr_43_list = EqualityExpression_43_Var.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		final RelationalExpression RelationalExpression_44_Var = (RelationalExpression)Expr_43_list.get(0);
		Assert.assertNotNull(RelationalExpression_44_Var);
		final EList<? extends EObject> Expr_44_list = RelationalExpression_44_Var.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		final ShiftExpression ShiftExpression_45_Var = (ShiftExpression)Expr_44_list.get(0);
		Assert.assertNotNull(ShiftExpression_45_Var);
		final EList<? extends EObject> Expr_45_list = ShiftExpression_45_Var.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		final AdditiveExpression AdditiveExpression_46_Var = (AdditiveExpression)Expr_45_list.get(0);
		Assert.assertNotNull(AdditiveExpression_46_Var);
		final EList<? extends EObject> Expr_46_list = AdditiveExpression_46_Var.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		final MultiplicativeExpression MultiplicativeExpression_47_Var = (MultiplicativeExpression)Expr_46_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_47_Var);
		final EList<? extends EObject> Expr_47_list = MultiplicativeExpression_47_Var.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		final CastExpression CastExpression_48_Var = (CastExpression)Expr_47_list.get(0);
		Assert.assertNotNull(CastExpression_48_Var);
		final UnaryExpression UnaryExpression_49_Var = (UnaryExpression)CastExpression_48_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_49_Var);
		final PostfixExpression PostfixExpression_50_Var = (PostfixExpression)UnaryExpression_49_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_50_Var);
		final EList<? extends EObject> Expr_50_list = PostfixExpression_50_Var.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		final PrimaryExpression PrimaryExpression_51_Var = (PrimaryExpression)Expr_50_list.get(0);
		Assert.assertNotNull(PrimaryExpression_51_Var);
		final Constant Constant_52_Var = (Constant)PrimaryExpression_51_Var.getConst();
		Assert.assertNotNull(Constant_52_Var);
		Assert.assertEquals("\"will never be reached\\n\"", Constant_52_Var.getStr());
		Assert.assertEquals(";", ExpressionStatement_17_Var.getSemi());
		final Statement Statement_53_Var = (Statement)Statement_10_list.get(2);
		Assert.assertNotNull(Statement_53_Var);
		final LabeledStatement LabeledStatement_54_Var = (LabeledStatement)Statement_53_Var.getStmt();
		Assert.assertNotNull(LabeledStatement_54_Var);
		Assert.assertEquals("target", LabeledStatement_54_Var.getId());
		final Statement Statement_55_Var = (Statement)LabeledStatement_54_Var.getLStmt();
		Assert.assertNotNull(Statement_55_Var);
		final ExpressionStatement ExpressionStatement_56_Var = (ExpressionStatement)Statement_55_Var.getStmt();
		Assert.assertNotNull(ExpressionStatement_56_Var);
		final Expression Expression_57_Var = (Expression)ExpressionStatement_56_Var.getExpression();
		Assert.assertNotNull(Expression_57_Var);
		final EList<? extends EObject> ExprExpr_57_list = Expression_57_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_57_list);
		Assert.assertEquals(1, ExprExpr_57_list.size());
		final AssignmentExpression AssignmentExpression_58_Var = (AssignmentExpression)ExprExpr_57_list.get(0);
		Assert.assertNotNull(AssignmentExpression_58_Var);
		final ConditionalExpression ConditionalExpression_59_Var = (ConditionalExpression)AssignmentExpression_58_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_59_Var);
		final LogicalOrExpression LogicalOrExpression_60_Var = (LogicalOrExpression)ConditionalExpression_59_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_60_Var);
		final EList<? extends EObject> Expr_60_list = LogicalOrExpression_60_Var.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		final LogicalAndExpression LogicalAndExpression_61_Var = (LogicalAndExpression)Expr_60_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_61_Var);
		final EList<? extends EObject> Expr_61_list = LogicalAndExpression_61_Var.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		final InclusiveOrExpression InclusiveOrExpression_62_Var = (InclusiveOrExpression)Expr_61_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_62_Var);
		final EList<? extends EObject> Expr_62_list = InclusiveOrExpression_62_Var.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_63_Var = (ExclusiveOrExpression)Expr_62_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_63_Var);
		final EList<? extends EObject> Expr_63_list = ExclusiveOrExpression_63_Var.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		final AndExpression AndExpression_64_Var = (AndExpression)Expr_63_list.get(0);
		Assert.assertNotNull(AndExpression_64_Var);
		final EList<? extends EObject> Expr_64_list = AndExpression_64_Var.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		final EqualityExpression EqualityExpression_65_Var = (EqualityExpression)Expr_64_list.get(0);
		Assert.assertNotNull(EqualityExpression_65_Var);
		final EList<? extends EObject> Expr_65_list = EqualityExpression_65_Var.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		final RelationalExpression RelationalExpression_66_Var = (RelationalExpression)Expr_65_list.get(0);
		Assert.assertNotNull(RelationalExpression_66_Var);
		final EList<? extends EObject> Expr_66_list = RelationalExpression_66_Var.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		final ShiftExpression ShiftExpression_67_Var = (ShiftExpression)Expr_66_list.get(0);
		Assert.assertNotNull(ShiftExpression_67_Var);
		final EList<? extends EObject> Expr_67_list = ShiftExpression_67_Var.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		final AdditiveExpression AdditiveExpression_68_Var = (AdditiveExpression)Expr_67_list.get(0);
		Assert.assertNotNull(AdditiveExpression_68_Var);
		final EList<? extends EObject> Expr_68_list = AdditiveExpression_68_Var.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		final MultiplicativeExpression MultiplicativeExpression_69_Var = (MultiplicativeExpression)Expr_68_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_69_Var);
		final EList<? extends EObject> Expr_69_list = MultiplicativeExpression_69_Var.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		final CastExpression CastExpression_70_Var = (CastExpression)Expr_69_list.get(0);
		Assert.assertNotNull(CastExpression_70_Var);
		final UnaryExpression UnaryExpression_71_Var = (UnaryExpression)CastExpression_70_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_71_Var);
		final PostfixExpression PostfixExpression_72_Var = (PostfixExpression)UnaryExpression_71_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_72_Var);
		final EList<? extends EObject> Expr_72_list = PostfixExpression_72_Var.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		final PrimaryExpression PrimaryExpression_73_Var = (PrimaryExpression)Expr_72_list.get(0);
		Assert.assertNotNull(PrimaryExpression_73_Var);
		Assert.assertEquals("printf", PrimaryExpression_73_Var.getId());
		final EList<? extends EObject> ArgumentExpressionList_73_list = PostfixExpression_72_Var.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_73_list);
		Assert.assertEquals(1, ArgumentExpressionList_73_list.size());
		final ArgumentExpressionList ArgumentExpressionList_74_Var = (ArgumentExpressionList)ArgumentExpressionList_73_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_74_Var);
		final EList<? extends EObject> Expr_74_list = ArgumentExpressionList_74_Var.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		final AssignmentExpression AssignmentExpression_75_Var = (AssignmentExpression)Expr_74_list.get(0);
		Assert.assertNotNull(AssignmentExpression_75_Var);
		final ConditionalExpression ConditionalExpression_76_Var = (ConditionalExpression)AssignmentExpression_75_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_76_Var);
		final LogicalOrExpression LogicalOrExpression_77_Var = (LogicalOrExpression)ConditionalExpression_76_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_77_Var);
		final EList<? extends EObject> Expr_77_list = LogicalOrExpression_77_Var.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		final LogicalAndExpression LogicalAndExpression_78_Var = (LogicalAndExpression)Expr_77_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_78_Var);
		final EList<? extends EObject> Expr_78_list = LogicalAndExpression_78_Var.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		final InclusiveOrExpression InclusiveOrExpression_79_Var = (InclusiveOrExpression)Expr_78_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_79_Var);
		final EList<? extends EObject> Expr_79_list = InclusiveOrExpression_79_Var.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_80_Var = (ExclusiveOrExpression)Expr_79_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_80_Var);
		final EList<? extends EObject> Expr_80_list = ExclusiveOrExpression_80_Var.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		final AndExpression AndExpression_81_Var = (AndExpression)Expr_80_list.get(0);
		Assert.assertNotNull(AndExpression_81_Var);
		final EList<? extends EObject> Expr_81_list = AndExpression_81_Var.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		final EqualityExpression EqualityExpression_82_Var = (EqualityExpression)Expr_81_list.get(0);
		Assert.assertNotNull(EqualityExpression_82_Var);
		final EList<? extends EObject> Expr_82_list = EqualityExpression_82_Var.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		final RelationalExpression RelationalExpression_83_Var = (RelationalExpression)Expr_82_list.get(0);
		Assert.assertNotNull(RelationalExpression_83_Var);
		final EList<? extends EObject> Expr_83_list = RelationalExpression_83_Var.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		final ShiftExpression ShiftExpression_84_Var = (ShiftExpression)Expr_83_list.get(0);
		Assert.assertNotNull(ShiftExpression_84_Var);
		final EList<? extends EObject> Expr_84_list = ShiftExpression_84_Var.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		final AdditiveExpression AdditiveExpression_85_Var = (AdditiveExpression)Expr_84_list.get(0);
		Assert.assertNotNull(AdditiveExpression_85_Var);
		final EList<? extends EObject> Expr_85_list = AdditiveExpression_85_Var.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		final MultiplicativeExpression MultiplicativeExpression_86_Var = (MultiplicativeExpression)Expr_85_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_86_Var);
		final EList<? extends EObject> Expr_86_list = MultiplicativeExpression_86_Var.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		final CastExpression CastExpression_87_Var = (CastExpression)Expr_86_list.get(0);
		Assert.assertNotNull(CastExpression_87_Var);
		final UnaryExpression UnaryExpression_88_Var = (UnaryExpression)CastExpression_87_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_88_Var);
		final PostfixExpression PostfixExpression_89_Var = (PostfixExpression)UnaryExpression_88_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_89_Var);
		final EList<? extends EObject> Expr_89_list = PostfixExpression_89_Var.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		final PrimaryExpression PrimaryExpression_90_Var = (PrimaryExpression)Expr_89_list.get(0);
		Assert.assertNotNull(PrimaryExpression_90_Var);
		final Constant Constant_91_Var = (Constant)PrimaryExpression_90_Var.getConst();
		Assert.assertNotNull(Constant_91_Var);
		Assert.assertEquals("\"reached target\\n\"", Constant_91_Var.getStr());
		Assert.assertEquals(";", ExpressionStatement_56_Var.getSemi());
	}


}