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
import at.jku.weiner.c.c.SelectionStatement;
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
import at.jku.weiner.c.c.LabeledStatement;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.CompoundStatement;
import at.jku.weiner.c.c.BodyStatement;
import at.jku.weiner.c.c.BlockList;
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
public class Test0025_Switch {

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
		final Path path = Paths.get("res/Test0025_Switch.c");
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
	@Test
	public void checkLexerTokens()
	throws Exception{
		final String text = this.getSourceText();
		//System.out.println(text);
		final String[] expected = new String[] {
			"RULE_KW_INT",
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
			"RULE_KW_SWITCH",
			"RULE_WHITESPACE",
			"RULE_LEFTPAREN",
			"RULE_ID",
			"RULE_RIGHTPAREN",
			"RULE_WHITESPACE",
			"RULE_LEFTBRACE",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_BLOCK_COMMENT",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_KW_DEFAULT",
			"RULE_COLON",
			"RULE_WHITESPACE",
			"RULE_LEFTBRACE",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_KW_RETURN",
			"RULE_WHITESPACE",
			"RULE_DECIMAL_LITERAL",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_RIGHTBRACE",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_RIGHTBRACE",
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
		Assert.assertEquals("doSomething", DirectDeclarator_7_Var.getId());
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
		Assert.assertEquals("argc", DirectDeclarator_16_Var.getId());
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
		Assert.assertEquals(2, Statement_19_list.size());
		final Statement Statement_20_Var = (Statement)Statement_19_list.get(0);
		Assert.assertNotNull(Statement_20_Var);
		final SelectionStatement SelectionStatement_21_Var = (SelectionStatement)Statement_20_Var.getStmt();
		Assert.assertNotNull(SelectionStatement_21_Var);
		Assert.assertEquals("switch", SelectionStatement_21_Var.getSwitch());
		final Expression Expression_22_Var = (Expression)SelectionStatement_21_Var.getExpr();
		Assert.assertNotNull(Expression_22_Var);
		final EList<? extends EObject> ExprExpr_22_list = Expression_22_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_22_list);
		Assert.assertEquals(1, ExprExpr_22_list.size());
		final AssignmentExpression AssignmentExpression_23_Var = (AssignmentExpression)ExprExpr_22_list.get(0);
		Assert.assertNotNull(AssignmentExpression_23_Var);
		final ConditionalExpression ConditionalExpression_24_Var = (ConditionalExpression)AssignmentExpression_23_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_24_Var);
		final LogicalOrExpression LogicalOrExpression_25_Var = (LogicalOrExpression)ConditionalExpression_24_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_25_Var);
		final EList<? extends EObject> Expr_25_list = LogicalOrExpression_25_Var.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		final LogicalAndExpression LogicalAndExpression_26_Var = (LogicalAndExpression)Expr_25_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_26_Var);
		final EList<? extends EObject> Expr_26_list = LogicalAndExpression_26_Var.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		final InclusiveOrExpression InclusiveOrExpression_27_Var = (InclusiveOrExpression)Expr_26_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_27_Var);
		final EList<? extends EObject> Expr_27_list = InclusiveOrExpression_27_Var.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_28_Var = (ExclusiveOrExpression)Expr_27_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_28_Var);
		final EList<? extends EObject> Expr_28_list = ExclusiveOrExpression_28_Var.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		final AndExpression AndExpression_29_Var = (AndExpression)Expr_28_list.get(0);
		Assert.assertNotNull(AndExpression_29_Var);
		final EList<? extends EObject> Expr_29_list = AndExpression_29_Var.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		final EqualityExpression EqualityExpression_30_Var = (EqualityExpression)Expr_29_list.get(0);
		Assert.assertNotNull(EqualityExpression_30_Var);
		final EList<? extends EObject> Expr_30_list = EqualityExpression_30_Var.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		final RelationalExpression RelationalExpression_31_Var = (RelationalExpression)Expr_30_list.get(0);
		Assert.assertNotNull(RelationalExpression_31_Var);
		final EList<? extends EObject> Expr_31_list = RelationalExpression_31_Var.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		final ShiftExpression ShiftExpression_32_Var = (ShiftExpression)Expr_31_list.get(0);
		Assert.assertNotNull(ShiftExpression_32_Var);
		final EList<? extends EObject> Expr_32_list = ShiftExpression_32_Var.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		final AdditiveExpression AdditiveExpression_33_Var = (AdditiveExpression)Expr_32_list.get(0);
		Assert.assertNotNull(AdditiveExpression_33_Var);
		final EList<? extends EObject> Expr_33_list = AdditiveExpression_33_Var.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		final MultiplicativeExpression MultiplicativeExpression_34_Var = (MultiplicativeExpression)Expr_33_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_34_Var);
		final EList<? extends EObject> Expr_34_list = MultiplicativeExpression_34_Var.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		final CastExpression CastExpression_35_Var = (CastExpression)Expr_34_list.get(0);
		Assert.assertNotNull(CastExpression_35_Var);
		final UnaryExpression UnaryExpression_36_Var = (UnaryExpression)CastExpression_35_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_36_Var);
		final PostfixExpression PostfixExpression_37_Var = (PostfixExpression)UnaryExpression_36_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_37_Var);
		final EList<? extends EObject> Expr_37_list = PostfixExpression_37_Var.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		final PrimaryExpression PrimaryExpression_38_Var = (PrimaryExpression)Expr_37_list.get(0);
		Assert.assertNotNull(PrimaryExpression_38_Var);
		Assert.assertEquals("argc", PrimaryExpression_38_Var.getId());
		final Statement Statement_39_Var = (Statement)SelectionStatement_21_Var.getSwitchStatement();
		Assert.assertNotNull(Statement_39_Var);
		final CompoundStatement CompoundStatement_40_Var = (CompoundStatement)Statement_39_Var.getStmt();
		Assert.assertNotNull(CompoundStatement_40_Var);
		final BodyStatement BodyStatement_41_Var = (BodyStatement)CompoundStatement_40_Var.getBody();
		Assert.assertNotNull(BodyStatement_41_Var);
		final EList<? extends EObject> BlockList_41_list = BodyStatement_41_Var.getBlockList();
		Assert.assertNotNull(BlockList_41_list);
		Assert.assertEquals(1, BlockList_41_list.size());
		final BlockList BlockList_42_Var = (BlockList)BlockList_41_list.get(0);
		Assert.assertNotNull(BlockList_42_Var);
		final EList<? extends EObject> Statement_42_list = BlockList_42_Var.getStatement();
		Assert.assertNotNull(Statement_42_list);
		Assert.assertEquals(1, Statement_42_list.size());
		final Statement Statement_43_Var = (Statement)Statement_42_list.get(0);
		Assert.assertNotNull(Statement_43_Var);
		final LabeledStatement LabeledStatement_44_Var = (LabeledStatement)Statement_43_Var.getStmt();
		Assert.assertNotNull(LabeledStatement_44_Var);
		Assert.assertEquals("default", LabeledStatement_44_Var.getDefault());
		final Statement Statement_45_Var = (Statement)LabeledStatement_44_Var.getLStmt();
		Assert.assertNotNull(Statement_45_Var);
		final CompoundStatement CompoundStatement_46_Var = (CompoundStatement)Statement_45_Var.getStmt();
		Assert.assertNotNull(CompoundStatement_46_Var);
		final BodyStatement BodyStatement_47_Var = (BodyStatement)CompoundStatement_46_Var.getBody();
		Assert.assertNotNull(BodyStatement_47_Var);
		final EList<? extends EObject> BlockList_47_list = BodyStatement_47_Var.getBlockList();
		Assert.assertNotNull(BlockList_47_list);
		Assert.assertEquals(1, BlockList_47_list.size());
		final BlockList BlockList_48_Var = (BlockList)BlockList_47_list.get(0);
		Assert.assertNotNull(BlockList_48_Var);
		final EList<? extends EObject> Statement_48_list = BlockList_48_Var.getStatement();
		Assert.assertNotNull(Statement_48_list);
		Assert.assertEquals(1, Statement_48_list.size());
		final Statement Statement_49_Var = (Statement)Statement_48_list.get(0);
		Assert.assertNotNull(Statement_49_Var);
		final JumpStatement JumpStatement_50_Var = (JumpStatement)Statement_49_Var.getStmt();
		Assert.assertNotNull(JumpStatement_50_Var);
		Assert.assertEquals("return", JumpStatement_50_Var.getReturn());
		final Expression Expression_51_Var = (Expression)JumpStatement_50_Var.getExpr();
		Assert.assertNotNull(Expression_51_Var);
		final EList<? extends EObject> ExprExpr_51_list = Expression_51_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_51_list);
		Assert.assertEquals(1, ExprExpr_51_list.size());
		final AssignmentExpression AssignmentExpression_52_Var = (AssignmentExpression)ExprExpr_51_list.get(0);
		Assert.assertNotNull(AssignmentExpression_52_Var);
		final ConditionalExpression ConditionalExpression_53_Var = (ConditionalExpression)AssignmentExpression_52_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_53_Var);
		final LogicalOrExpression LogicalOrExpression_54_Var = (LogicalOrExpression)ConditionalExpression_53_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_54_Var);
		final EList<? extends EObject> Expr_54_list = LogicalOrExpression_54_Var.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		final LogicalAndExpression LogicalAndExpression_55_Var = (LogicalAndExpression)Expr_54_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_55_Var);
		final EList<? extends EObject> Expr_55_list = LogicalAndExpression_55_Var.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		final InclusiveOrExpression InclusiveOrExpression_56_Var = (InclusiveOrExpression)Expr_55_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_56_Var);
		final EList<? extends EObject> Expr_56_list = InclusiveOrExpression_56_Var.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_57_Var = (ExclusiveOrExpression)Expr_56_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_57_Var);
		final EList<? extends EObject> Expr_57_list = ExclusiveOrExpression_57_Var.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		final AndExpression AndExpression_58_Var = (AndExpression)Expr_57_list.get(0);
		Assert.assertNotNull(AndExpression_58_Var);
		final EList<? extends EObject> Expr_58_list = AndExpression_58_Var.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		final EqualityExpression EqualityExpression_59_Var = (EqualityExpression)Expr_58_list.get(0);
		Assert.assertNotNull(EqualityExpression_59_Var);
		final EList<? extends EObject> Expr_59_list = EqualityExpression_59_Var.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		final RelationalExpression RelationalExpression_60_Var = (RelationalExpression)Expr_59_list.get(0);
		Assert.assertNotNull(RelationalExpression_60_Var);
		final EList<? extends EObject> Expr_60_list = RelationalExpression_60_Var.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		final ShiftExpression ShiftExpression_61_Var = (ShiftExpression)Expr_60_list.get(0);
		Assert.assertNotNull(ShiftExpression_61_Var);
		final EList<? extends EObject> Expr_61_list = ShiftExpression_61_Var.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		final AdditiveExpression AdditiveExpression_62_Var = (AdditiveExpression)Expr_61_list.get(0);
		Assert.assertNotNull(AdditiveExpression_62_Var);
		final EList<? extends EObject> Expr_62_list = AdditiveExpression_62_Var.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		final MultiplicativeExpression MultiplicativeExpression_63_Var = (MultiplicativeExpression)Expr_62_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_63_Var);
		final EList<? extends EObject> Expr_63_list = MultiplicativeExpression_63_Var.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		final CastExpression CastExpression_64_Var = (CastExpression)Expr_63_list.get(0);
		Assert.assertNotNull(CastExpression_64_Var);
		final UnaryExpression UnaryExpression_65_Var = (UnaryExpression)CastExpression_64_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_65_Var);
		final PostfixExpression PostfixExpression_66_Var = (PostfixExpression)UnaryExpression_65_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_66_Var);
		final EList<? extends EObject> Expr_66_list = PostfixExpression_66_Var.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		final PrimaryExpression PrimaryExpression_67_Var = (PrimaryExpression)Expr_66_list.get(0);
		Assert.assertNotNull(PrimaryExpression_67_Var);
		final Constant Constant_68_Var = (Constant)PrimaryExpression_67_Var.getConst();
		Assert.assertNotNull(Constant_68_Var);
		Assert.assertEquals("2", Constant_68_Var.getDec());
		Assert.assertEquals(";", JumpStatement_50_Var.getSemi());
		final Statement Statement_69_Var = (Statement)Statement_19_list.get(1);
		Assert.assertNotNull(Statement_69_Var);
		final JumpStatement JumpStatement_70_Var = (JumpStatement)Statement_69_Var.getStmt();
		Assert.assertNotNull(JumpStatement_70_Var);
		final Expression Expression_71_Var = (Expression)JumpStatement_70_Var.getExpr();
		Assert.assertNotNull(Expression_71_Var);
		final EList<? extends EObject> ExprExpr_71_list = Expression_71_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_71_list);
		Assert.assertEquals(1, ExprExpr_71_list.size());
		final AssignmentExpression AssignmentExpression_72_Var = (AssignmentExpression)ExprExpr_71_list.get(0);
		Assert.assertNotNull(AssignmentExpression_72_Var);
		final ConditionalExpression ConditionalExpression_73_Var = (ConditionalExpression)AssignmentExpression_72_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_73_Var);
		final LogicalOrExpression LogicalOrExpression_74_Var = (LogicalOrExpression)ConditionalExpression_73_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_74_Var);
		final EList<? extends EObject> Expr_74_list = LogicalOrExpression_74_Var.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		final LogicalAndExpression LogicalAndExpression_75_Var = (LogicalAndExpression)Expr_74_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_75_Var);
		final EList<? extends EObject> Expr_75_list = LogicalAndExpression_75_Var.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		final InclusiveOrExpression InclusiveOrExpression_76_Var = (InclusiveOrExpression)Expr_75_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_76_Var);
		final EList<? extends EObject> Expr_76_list = InclusiveOrExpression_76_Var.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_77_Var = (ExclusiveOrExpression)Expr_76_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_77_Var);
		final EList<? extends EObject> Expr_77_list = ExclusiveOrExpression_77_Var.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		final AndExpression AndExpression_78_Var = (AndExpression)Expr_77_list.get(0);
		Assert.assertNotNull(AndExpression_78_Var);
		final EList<? extends EObject> Expr_78_list = AndExpression_78_Var.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		final EqualityExpression EqualityExpression_79_Var = (EqualityExpression)Expr_78_list.get(0);
		Assert.assertNotNull(EqualityExpression_79_Var);
		final EList<? extends EObject> Expr_79_list = EqualityExpression_79_Var.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		final RelationalExpression RelationalExpression_80_Var = (RelationalExpression)Expr_79_list.get(0);
		Assert.assertNotNull(RelationalExpression_80_Var);
		final EList<? extends EObject> Expr_80_list = RelationalExpression_80_Var.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		final ShiftExpression ShiftExpression_81_Var = (ShiftExpression)Expr_80_list.get(0);
		Assert.assertNotNull(ShiftExpression_81_Var);
		final EList<? extends EObject> Expr_81_list = ShiftExpression_81_Var.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		final AdditiveExpression AdditiveExpression_82_Var = (AdditiveExpression)Expr_81_list.get(0);
		Assert.assertNotNull(AdditiveExpression_82_Var);
		final EList<? extends EObject> Expr_82_list = AdditiveExpression_82_Var.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		final MultiplicativeExpression MultiplicativeExpression_83_Var = (MultiplicativeExpression)Expr_82_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_83_Var);
		final EList<? extends EObject> Expr_83_list = MultiplicativeExpression_83_Var.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		final CastExpression CastExpression_84_Var = (CastExpression)Expr_83_list.get(0);
		Assert.assertNotNull(CastExpression_84_Var);
		final UnaryExpression UnaryExpression_85_Var = (UnaryExpression)CastExpression_84_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_85_Var);
		final PostfixExpression PostfixExpression_86_Var = (PostfixExpression)UnaryExpression_85_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_86_Var);
		final EList<? extends EObject> Expr_86_list = PostfixExpression_86_Var.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		final PrimaryExpression PrimaryExpression_87_Var = (PrimaryExpression)Expr_86_list.get(0);
		Assert.assertNotNull(PrimaryExpression_87_Var);
		final Constant Constant_88_Var = (Constant)PrimaryExpression_87_Var.getConst();
		Assert.assertNotNull(Constant_88_Var);
		Assert.assertEquals("1", Constant_88_Var.getDec());
		Assert.assertEquals("return", JumpStatement_70_Var.getReturn());
		Assert.assertEquals(";", JumpStatement_70_Var.getSemi());
	}


}
