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
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.FunctionDefinition;
import at.jku.weiner.c.c.BodyStatement;
import at.jku.weiner.c.c.BlockList;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.IterationStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.AssignmentOperator;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
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
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
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
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.CompoundStatement;
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
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.JumpStatement;

@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0027_For {

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
		final Path path = Paths.get("res/Test0027_For.c");
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
			"RULE_KW_INT",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_RIGHTPAREN",
			"RULE_WHITESPACE",
			"RULE_LEFTBRACE",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_KW_FOR",
			"RULE_WHITESPACE",
			"RULE_LEFTPAREN",
			"RULE_ID",
			"RULE_ASSIGN",
			"RULE_DECIMAL_LITERAL",
			"RULE_SEMI",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_WHITESPACE",
			"RULE_LESS",
			"RULE_WHITESPACE",
			"RULE_DECIMAL_LITERAL",
			"RULE_SEMI",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_PLUSPLUS",
			"RULE_RIGHTPAREN",
			"RULE_WHITESPACE",
			"RULE_LEFTBRACE",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_MINUSMINUS",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_KW_BREAK",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_RIGHTBRACE",
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
		Assert.assertEquals("a", DirectDeclarator_7_Var.getId());
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
		Assert.assertEquals("int", TypeSpecifier_14_Var.getName());
		final Declarator Declarator_15_Var = (Declarator)ParameterDeclaration_12_Var.getDeclarator();
		Assert.assertNotNull(Declarator_15_Var);
		final DirectDeclarator DirectDeclarator_16_Var = (DirectDeclarator)Declarator_15_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_16_Var);
		Assert.assertEquals("num", DirectDeclarator_16_Var.getId());
		final FunctionDefinition FunctionDefinition_17_Var = (FunctionDefinition)ExternalDeclaration_2_Var.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_17_Var);
		final BodyStatement BodyStatement_18_Var = (BodyStatement)FunctionDefinition_17_Var.getBody();
		Assert.assertNotNull(BodyStatement_18_Var);
		final EList<? extends EObject> BlockList_18_list = BodyStatement_18_Var.getBlockList();
		Assert.assertNotNull(BlockList_18_list);
		Assert.assertEquals(1, BlockList_18_list.size());
		final BlockList BlockList_19_Var = (BlockList)BlockList_18_list.get(0);
		Assert.assertNotNull(BlockList_19_Var);
		final EList<? extends EObject> Statement_19_list = BlockList_19_Var.getStatement();
		Assert.assertNotNull(Statement_19_list);
		Assert.assertEquals(1, Statement_19_list.size());
		final Statement Statement_20_Var = (Statement)Statement_19_list.get(0);
		Assert.assertNotNull(Statement_20_Var);
		final IterationStatement IterationStatement_21_Var = (IterationStatement)Statement_20_Var.getStmt();
		Assert.assertNotNull(IterationStatement_21_Var);
		Assert.assertEquals("for", IterationStatement_21_Var.getFor());
		final Expression Expression_22_Var = (Expression)IterationStatement_21_Var.getInitExpr();
		Assert.assertNotNull(Expression_22_Var);
		final EList<? extends EObject> ExprExpr_22_list = Expression_22_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_22_list);
		Assert.assertEquals(1, ExprExpr_22_list.size());
		final AssignmentExpression AssignmentExpression_23_Var = (AssignmentExpression)ExprExpr_22_list.get(0);
		Assert.assertNotNull(AssignmentExpression_23_Var);
		final AssignmentOperator AssignmentOperator_24_Var = (AssignmentOperator)AssignmentExpression_23_Var.getOp();
		Assert.assertNotNull(AssignmentOperator_24_Var);
		Assert.assertEquals("=", AssignmentOperator_24_Var.getOp());
		final UnaryExpression UnaryExpression_25_Var = (UnaryExpression)AssignmentExpression_23_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_25_Var);
		final PostfixExpression PostfixExpression_26_Var = (PostfixExpression)UnaryExpression_25_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_26_Var);
		final EList<? extends EObject> Expr_26_list = PostfixExpression_26_Var.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		final PrimaryExpression PrimaryExpression_27_Var = (PrimaryExpression)Expr_26_list.get(0);
		Assert.assertNotNull(PrimaryExpression_27_Var);
		Assert.assertEquals("num", PrimaryExpression_27_Var.getId());
		final AssignmentExpression AssignmentExpression_28_Var = (AssignmentExpression)AssignmentExpression_23_Var.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_28_Var);
		final ConditionalExpression ConditionalExpression_29_Var = (ConditionalExpression)AssignmentExpression_28_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_29_Var);
		final LogicalOrExpression LogicalOrExpression_30_Var = (LogicalOrExpression)ConditionalExpression_29_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_30_Var);
		final EList<? extends EObject> Expr_30_list = LogicalOrExpression_30_Var.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		final LogicalAndExpression LogicalAndExpression_31_Var = (LogicalAndExpression)Expr_30_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_31_Var);
		final EList<? extends EObject> Expr_31_list = LogicalAndExpression_31_Var.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		final InclusiveOrExpression InclusiveOrExpression_32_Var = (InclusiveOrExpression)Expr_31_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_32_Var);
		final EList<? extends EObject> Expr_32_list = InclusiveOrExpression_32_Var.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_33_Var = (ExclusiveOrExpression)Expr_32_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_33_Var);
		final EList<? extends EObject> Expr_33_list = ExclusiveOrExpression_33_Var.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		final AndExpression AndExpression_34_Var = (AndExpression)Expr_33_list.get(0);
		Assert.assertNotNull(AndExpression_34_Var);
		final EList<? extends EObject> Expr_34_list = AndExpression_34_Var.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		final EqualityExpression EqualityExpression_35_Var = (EqualityExpression)Expr_34_list.get(0);
		Assert.assertNotNull(EqualityExpression_35_Var);
		final EList<? extends EObject> Expr_35_list = EqualityExpression_35_Var.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		final RelationalExpression RelationalExpression_36_Var = (RelationalExpression)Expr_35_list.get(0);
		Assert.assertNotNull(RelationalExpression_36_Var);
		final EList<? extends EObject> Expr_36_list = RelationalExpression_36_Var.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		final ShiftExpression ShiftExpression_37_Var = (ShiftExpression)Expr_36_list.get(0);
		Assert.assertNotNull(ShiftExpression_37_Var);
		final EList<? extends EObject> Expr_37_list = ShiftExpression_37_Var.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		final AdditiveExpression AdditiveExpression_38_Var = (AdditiveExpression)Expr_37_list.get(0);
		Assert.assertNotNull(AdditiveExpression_38_Var);
		final EList<? extends EObject> Expr_38_list = AdditiveExpression_38_Var.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		final MultiplicativeExpression MultiplicativeExpression_39_Var = (MultiplicativeExpression)Expr_38_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_39_Var);
		final EList<? extends EObject> Expr_39_list = MultiplicativeExpression_39_Var.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		final CastExpression CastExpression_40_Var = (CastExpression)Expr_39_list.get(0);
		Assert.assertNotNull(CastExpression_40_Var);
		final UnaryExpression UnaryExpression_41_Var = (UnaryExpression)CastExpression_40_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_41_Var);
		final PostfixExpression PostfixExpression_42_Var = (PostfixExpression)UnaryExpression_41_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_42_Var);
		final EList<? extends EObject> Expr_42_list = PostfixExpression_42_Var.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		final PrimaryExpression PrimaryExpression_43_Var = (PrimaryExpression)Expr_42_list.get(0);
		Assert.assertNotNull(PrimaryExpression_43_Var);
		final Constant Constant_44_Var = (Constant)PrimaryExpression_43_Var.getConst();
		Assert.assertNotNull(Constant_44_Var);
		Assert.assertEquals("0", Constant_44_Var.getDec());
		final Expression Expression_45_Var = (Expression)IterationStatement_21_Var.getExpr();
		Assert.assertNotNull(Expression_45_Var);
		final EList<? extends EObject> ExprExpr_45_list = Expression_45_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_45_list);
		Assert.assertEquals(1, ExprExpr_45_list.size());
		final AssignmentExpression AssignmentExpression_46_Var = (AssignmentExpression)ExprExpr_45_list.get(0);
		Assert.assertNotNull(AssignmentExpression_46_Var);
		final ConditionalExpression ConditionalExpression_47_Var = (ConditionalExpression)AssignmentExpression_46_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_47_Var);
		final LogicalOrExpression LogicalOrExpression_48_Var = (LogicalOrExpression)ConditionalExpression_47_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_48_Var);
		final EList<? extends EObject> Expr_48_list = LogicalOrExpression_48_Var.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		final LogicalAndExpression LogicalAndExpression_49_Var = (LogicalAndExpression)Expr_48_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_49_Var);
		final EList<? extends EObject> Expr_49_list = LogicalAndExpression_49_Var.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		final InclusiveOrExpression InclusiveOrExpression_50_Var = (InclusiveOrExpression)Expr_49_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_50_Var);
		final EList<? extends EObject> Expr_50_list = InclusiveOrExpression_50_Var.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_51_Var = (ExclusiveOrExpression)Expr_50_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_51_Var);
		final EList<? extends EObject> Expr_51_list = ExclusiveOrExpression_51_Var.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		final AndExpression AndExpression_52_Var = (AndExpression)Expr_51_list.get(0);
		Assert.assertNotNull(AndExpression_52_Var);
		final EList<? extends EObject> Expr_52_list = AndExpression_52_Var.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		final EqualityExpression EqualityExpression_53_Var = (EqualityExpression)Expr_52_list.get(0);
		Assert.assertNotNull(EqualityExpression_53_Var);
		final EList<? extends EObject> Expr_53_list = EqualityExpression_53_Var.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		final RelationalExpression RelationalExpression_54_Var = (RelationalExpression)Expr_53_list.get(0);
		Assert.assertNotNull(RelationalExpression_54_Var);
		Assert.assertEquals("[<]", RelationalExpression_54_Var.getOp().toString());
		final EList<? extends EObject> Expr_54_list = RelationalExpression_54_Var.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(2, Expr_54_list.size());
		final ShiftExpression ShiftExpression_55_Var = (ShiftExpression)Expr_54_list.get(0);
		Assert.assertNotNull(ShiftExpression_55_Var);
		final EList<? extends EObject> Expr_55_list = ShiftExpression_55_Var.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		final AdditiveExpression AdditiveExpression_56_Var = (AdditiveExpression)Expr_55_list.get(0);
		Assert.assertNotNull(AdditiveExpression_56_Var);
		final EList<? extends EObject> Expr_56_list = AdditiveExpression_56_Var.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		final MultiplicativeExpression MultiplicativeExpression_57_Var = (MultiplicativeExpression)Expr_56_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_57_Var);
		final EList<? extends EObject> Expr_57_list = MultiplicativeExpression_57_Var.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		final CastExpression CastExpression_58_Var = (CastExpression)Expr_57_list.get(0);
		Assert.assertNotNull(CastExpression_58_Var);
		final UnaryExpression UnaryExpression_59_Var = (UnaryExpression)CastExpression_58_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_59_Var);
		final PostfixExpression PostfixExpression_60_Var = (PostfixExpression)UnaryExpression_59_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_60_Var);
		final EList<? extends EObject> Expr_60_list = PostfixExpression_60_Var.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		final PrimaryExpression PrimaryExpression_61_Var = (PrimaryExpression)Expr_60_list.get(0);
		Assert.assertNotNull(PrimaryExpression_61_Var);
		Assert.assertEquals("num", PrimaryExpression_61_Var.getId());
		final ShiftExpression ShiftExpression_62_Var = (ShiftExpression)Expr_54_list.get(1);
		Assert.assertNotNull(ShiftExpression_62_Var);
		final EList<? extends EObject> Expr_62_list = ShiftExpression_62_Var.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		final AdditiveExpression AdditiveExpression_63_Var = (AdditiveExpression)Expr_62_list.get(0);
		Assert.assertNotNull(AdditiveExpression_63_Var);
		final EList<? extends EObject> Expr_63_list = AdditiveExpression_63_Var.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		final MultiplicativeExpression MultiplicativeExpression_64_Var = (MultiplicativeExpression)Expr_63_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_64_Var);
		final EList<? extends EObject> Expr_64_list = MultiplicativeExpression_64_Var.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		final CastExpression CastExpression_65_Var = (CastExpression)Expr_64_list.get(0);
		Assert.assertNotNull(CastExpression_65_Var);
		final UnaryExpression UnaryExpression_66_Var = (UnaryExpression)CastExpression_65_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_66_Var);
		final PostfixExpression PostfixExpression_67_Var = (PostfixExpression)UnaryExpression_66_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_67_Var);
		final EList<? extends EObject> Expr_67_list = PostfixExpression_67_Var.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		final PrimaryExpression PrimaryExpression_68_Var = (PrimaryExpression)Expr_67_list.get(0);
		Assert.assertNotNull(PrimaryExpression_68_Var);
		final Constant Constant_69_Var = (Constant)PrimaryExpression_68_Var.getConst();
		Assert.assertNotNull(Constant_69_Var);
		Assert.assertEquals("5", Constant_69_Var.getDec());
		final Expression Expression_70_Var = (Expression)IterationStatement_21_Var.getIncExpr();
		Assert.assertNotNull(Expression_70_Var);
		final EList<? extends EObject> ExprExpr_70_list = Expression_70_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_70_list);
		Assert.assertEquals(1, ExprExpr_70_list.size());
		final AssignmentExpression AssignmentExpression_71_Var = (AssignmentExpression)ExprExpr_70_list.get(0);
		Assert.assertNotNull(AssignmentExpression_71_Var);
		final ConditionalExpression ConditionalExpression_72_Var = (ConditionalExpression)AssignmentExpression_71_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_72_Var);
		final LogicalOrExpression LogicalOrExpression_73_Var = (LogicalOrExpression)ConditionalExpression_72_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_73_Var);
		final EList<? extends EObject> Expr_73_list = LogicalOrExpression_73_Var.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		final LogicalAndExpression LogicalAndExpression_74_Var = (LogicalAndExpression)Expr_73_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_74_Var);
		final EList<? extends EObject> Expr_74_list = LogicalAndExpression_74_Var.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		final InclusiveOrExpression InclusiveOrExpression_75_Var = (InclusiveOrExpression)Expr_74_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_75_Var);
		final EList<? extends EObject> Expr_75_list = InclusiveOrExpression_75_Var.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_76_Var = (ExclusiveOrExpression)Expr_75_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_76_Var);
		final EList<? extends EObject> Expr_76_list = ExclusiveOrExpression_76_Var.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		final AndExpression AndExpression_77_Var = (AndExpression)Expr_76_list.get(0);
		Assert.assertNotNull(AndExpression_77_Var);
		final EList<? extends EObject> Expr_77_list = AndExpression_77_Var.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		final EqualityExpression EqualityExpression_78_Var = (EqualityExpression)Expr_77_list.get(0);
		Assert.assertNotNull(EqualityExpression_78_Var);
		final EList<? extends EObject> Expr_78_list = EqualityExpression_78_Var.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		final RelationalExpression RelationalExpression_79_Var = (RelationalExpression)Expr_78_list.get(0);
		Assert.assertNotNull(RelationalExpression_79_Var);
		final EList<? extends EObject> Expr_79_list = RelationalExpression_79_Var.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		final ShiftExpression ShiftExpression_80_Var = (ShiftExpression)Expr_79_list.get(0);
		Assert.assertNotNull(ShiftExpression_80_Var);
		final EList<? extends EObject> Expr_80_list = ShiftExpression_80_Var.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		final AdditiveExpression AdditiveExpression_81_Var = (AdditiveExpression)Expr_80_list.get(0);
		Assert.assertNotNull(AdditiveExpression_81_Var);
		final EList<? extends EObject> Expr_81_list = AdditiveExpression_81_Var.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		final MultiplicativeExpression MultiplicativeExpression_82_Var = (MultiplicativeExpression)Expr_81_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_82_Var);
		final EList<? extends EObject> Expr_82_list = MultiplicativeExpression_82_Var.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		final CastExpression CastExpression_83_Var = (CastExpression)Expr_82_list.get(0);
		Assert.assertNotNull(CastExpression_83_Var);
		final UnaryExpression UnaryExpression_84_Var = (UnaryExpression)CastExpression_83_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_84_Var);
		final PostfixExpression PostfixExpression_85_Var = (PostfixExpression)UnaryExpression_84_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_85_Var);
		final EList<? extends EObject> Expr_85_list = PostfixExpression_85_Var.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		final PrimaryExpression PrimaryExpression_86_Var = (PrimaryExpression)Expr_85_list.get(0);
		Assert.assertNotNull(PrimaryExpression_86_Var);
		Assert.assertEquals("num", PrimaryExpression_86_Var.getId());
		Assert.assertEquals("[++]", PostfixExpression_85_Var.getPlusplus().toString());
		final Statement Statement_87_Var = (Statement)IterationStatement_21_Var.getStatement();
		Assert.assertNotNull(Statement_87_Var);
		final CompoundStatement CompoundStatement_88_Var = (CompoundStatement)Statement_87_Var.getStmt();
		Assert.assertNotNull(CompoundStatement_88_Var);
		final BodyStatement BodyStatement_89_Var = (BodyStatement)CompoundStatement_88_Var.getBody();
		Assert.assertNotNull(BodyStatement_89_Var);
		final EList<? extends EObject> BlockList_89_list = BodyStatement_89_Var.getBlockList();
		Assert.assertNotNull(BlockList_89_list);
		Assert.assertEquals(1, BlockList_89_list.size());
		final BlockList BlockList_90_Var = (BlockList)BlockList_89_list.get(0);
		Assert.assertNotNull(BlockList_90_Var);
		final EList<? extends EObject> Statement_90_list = BlockList_90_Var.getStatement();
		Assert.assertNotNull(Statement_90_list);
		Assert.assertEquals(2, Statement_90_list.size());
		final Statement Statement_91_Var = (Statement)Statement_90_list.get(0);
		Assert.assertNotNull(Statement_91_Var);
		final ExpressionStatement ExpressionStatement_92_Var = (ExpressionStatement)Statement_91_Var.getStmt();
		Assert.assertNotNull(ExpressionStatement_92_Var);
		final Expression Expression_93_Var = (Expression)ExpressionStatement_92_Var.getExpression();
		Assert.assertNotNull(Expression_93_Var);
		final EList<? extends EObject> ExprExpr_93_list = Expression_93_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_93_list);
		Assert.assertEquals(1, ExprExpr_93_list.size());
		final AssignmentExpression AssignmentExpression_94_Var = (AssignmentExpression)ExprExpr_93_list.get(0);
		Assert.assertNotNull(AssignmentExpression_94_Var);
		final ConditionalExpression ConditionalExpression_95_Var = (ConditionalExpression)AssignmentExpression_94_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_95_Var);
		final LogicalOrExpression LogicalOrExpression_96_Var = (LogicalOrExpression)ConditionalExpression_95_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_96_Var);
		final EList<? extends EObject> Expr_96_list = LogicalOrExpression_96_Var.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		final LogicalAndExpression LogicalAndExpression_97_Var = (LogicalAndExpression)Expr_96_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_97_Var);
		final EList<? extends EObject> Expr_97_list = LogicalAndExpression_97_Var.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		final InclusiveOrExpression InclusiveOrExpression_98_Var = (InclusiveOrExpression)Expr_97_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_98_Var);
		final EList<? extends EObject> Expr_98_list = InclusiveOrExpression_98_Var.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_99_Var = (ExclusiveOrExpression)Expr_98_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_99_Var);
		final EList<? extends EObject> Expr_99_list = ExclusiveOrExpression_99_Var.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		final AndExpression AndExpression_100_Var = (AndExpression)Expr_99_list.get(0);
		Assert.assertNotNull(AndExpression_100_Var);
		final EList<? extends EObject> Expr_100_list = AndExpression_100_Var.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		final EqualityExpression EqualityExpression_101_Var = (EqualityExpression)Expr_100_list.get(0);
		Assert.assertNotNull(EqualityExpression_101_Var);
		final EList<? extends EObject> Expr_101_list = EqualityExpression_101_Var.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		final RelationalExpression RelationalExpression_102_Var = (RelationalExpression)Expr_101_list.get(0);
		Assert.assertNotNull(RelationalExpression_102_Var);
		final EList<? extends EObject> Expr_102_list = RelationalExpression_102_Var.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		final ShiftExpression ShiftExpression_103_Var = (ShiftExpression)Expr_102_list.get(0);
		Assert.assertNotNull(ShiftExpression_103_Var);
		final EList<? extends EObject> Expr_103_list = ShiftExpression_103_Var.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		final AdditiveExpression AdditiveExpression_104_Var = (AdditiveExpression)Expr_103_list.get(0);
		Assert.assertNotNull(AdditiveExpression_104_Var);
		final EList<? extends EObject> Expr_104_list = AdditiveExpression_104_Var.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		final MultiplicativeExpression MultiplicativeExpression_105_Var = (MultiplicativeExpression)Expr_104_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_105_Var);
		final EList<? extends EObject> Expr_105_list = MultiplicativeExpression_105_Var.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		final CastExpression CastExpression_106_Var = (CastExpression)Expr_105_list.get(0);
		Assert.assertNotNull(CastExpression_106_Var);
		final UnaryExpression UnaryExpression_107_Var = (UnaryExpression)CastExpression_106_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_107_Var);
		final PostfixExpression PostfixExpression_108_Var = (PostfixExpression)UnaryExpression_107_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_108_Var);
		final EList<? extends EObject> Expr_108_list = PostfixExpression_108_Var.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		final PrimaryExpression PrimaryExpression_109_Var = (PrimaryExpression)Expr_108_list.get(0);
		Assert.assertNotNull(PrimaryExpression_109_Var);
		Assert.assertEquals("num", PrimaryExpression_109_Var.getId());
		Assert.assertEquals("[]", PostfixExpression_108_Var.getPlusplus().toString());
		Assert.assertEquals("[--]", PostfixExpression_108_Var.getMinusminus().toString());
		Assert.assertEquals(";", ExpressionStatement_92_Var.getSemi());
		final Statement Statement_110_Var = (Statement)Statement_90_list.get(1);
		Assert.assertNotNull(Statement_110_Var);
		final JumpStatement JumpStatement_111_Var = (JumpStatement)Statement_110_Var.getStmt();
		Assert.assertNotNull(JumpStatement_111_Var);
		Assert.assertEquals("break", JumpStatement_111_Var.getBreak());
	}


}
