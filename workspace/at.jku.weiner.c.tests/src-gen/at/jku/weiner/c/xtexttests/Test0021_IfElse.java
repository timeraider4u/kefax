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
import at.jku.weiner.c.c.FunctionDeclarationSpecifiers;
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

@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0021_IfElse {

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
		final Path path = Paths.get("res/Test0021_IfElse.c");
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
			"RULE_KW_IF",
			"RULE_WHITESPACE",
			"RULE_LEFTPAREN",
			"RULE_ID",
			"RULE_WHITESPACE",
			"RULE_GREATER",
			"RULE_WHITESPACE",
			"RULE_DECIMAL_LITERAL",
			"RULE_RIGHTPAREN",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_KW_RETURN",
			"RULE_WHITESPACE",
			"RULE_DECIMAL_LITERAL",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_BLOCK_COMMENT",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_KW_ELSE",
			"RULE_WHITESPACE",
			"RULE_KW_IF",
			"RULE_WHITESPACE",
			"RULE_LEFTPAREN",
			"RULE_ID",
			"RULE_WHITESPACE",
			"RULE_EQUAL",
			"RULE_WHITESPACE",
			"RULE_DECIMAL_LITERAL",
			"RULE_RIGHTPAREN",
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
			"RULE_BLOCK_COMMENT",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_KW_ELSE",
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
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_4_Var = (FunctionDeclarationSpecifiers)FunctionDefHead_3_Var.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_4_Var);
		final EList<? extends EObject> DeclarationSpecifier_4_list = FunctionDeclarationSpecifiers_4_Var.getDeclarationSpecifier();
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
		Assert.assertEquals(1, Statement_19_list.size());
		final Statement Statement_20_Var = (Statement)Statement_19_list.get(0);
		Assert.assertNotNull(Statement_20_Var);
		final SelectionStatement SelectionStatement_21_Var = (SelectionStatement)Statement_20_Var.getStmt();
		Assert.assertNotNull(SelectionStatement_21_Var);
		Assert.assertEquals("if", SelectionStatement_21_Var.getIf());
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
		Assert.assertEquals("[>]", RelationalExpression_31_Var.getOp().toString());
		final EList<? extends EObject> Expr_31_list = RelationalExpression_31_Var.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(2, Expr_31_list.size());
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
		final ShiftExpression ShiftExpression_39_Var = (ShiftExpression)Expr_31_list.get(1);
		Assert.assertNotNull(ShiftExpression_39_Var);
		final EList<? extends EObject> Expr_39_list = ShiftExpression_39_Var.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		final AdditiveExpression AdditiveExpression_40_Var = (AdditiveExpression)Expr_39_list.get(0);
		Assert.assertNotNull(AdditiveExpression_40_Var);
		final EList<? extends EObject> Expr_40_list = AdditiveExpression_40_Var.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		final MultiplicativeExpression MultiplicativeExpression_41_Var = (MultiplicativeExpression)Expr_40_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_41_Var);
		final EList<? extends EObject> Expr_41_list = MultiplicativeExpression_41_Var.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		final CastExpression CastExpression_42_Var = (CastExpression)Expr_41_list.get(0);
		Assert.assertNotNull(CastExpression_42_Var);
		final UnaryExpression UnaryExpression_43_Var = (UnaryExpression)CastExpression_42_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_43_Var);
		final PostfixExpression PostfixExpression_44_Var = (PostfixExpression)UnaryExpression_43_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_44_Var);
		final EList<? extends EObject> Expr_44_list = PostfixExpression_44_Var.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		final PrimaryExpression PrimaryExpression_45_Var = (PrimaryExpression)Expr_44_list.get(0);
		Assert.assertNotNull(PrimaryExpression_45_Var);
		final Constant Constant_46_Var = (Constant)PrimaryExpression_45_Var.getConst();
		Assert.assertNotNull(Constant_46_Var);
		Assert.assertEquals("0", Constant_46_Var.getDec());
		final Statement Statement_47_Var = (Statement)SelectionStatement_21_Var.getIfStatement();
		Assert.assertNotNull(Statement_47_Var);
		final JumpStatement JumpStatement_48_Var = (JumpStatement)Statement_47_Var.getStmt();
		Assert.assertNotNull(JumpStatement_48_Var);
		final Expression Expression_49_Var = (Expression)JumpStatement_48_Var.getExpr();
		Assert.assertNotNull(Expression_49_Var);
		final EList<? extends EObject> ExprExpr_49_list = Expression_49_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_49_list);
		Assert.assertEquals(1, ExprExpr_49_list.size());
		final AssignmentExpression AssignmentExpression_50_Var = (AssignmentExpression)ExprExpr_49_list.get(0);
		Assert.assertNotNull(AssignmentExpression_50_Var);
		final ConditionalExpression ConditionalExpression_51_Var = (ConditionalExpression)AssignmentExpression_50_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_51_Var);
		final LogicalOrExpression LogicalOrExpression_52_Var = (LogicalOrExpression)ConditionalExpression_51_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_52_Var);
		final EList<? extends EObject> Expr_52_list = LogicalOrExpression_52_Var.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		final LogicalAndExpression LogicalAndExpression_53_Var = (LogicalAndExpression)Expr_52_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_53_Var);
		final EList<? extends EObject> Expr_53_list = LogicalAndExpression_53_Var.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		final InclusiveOrExpression InclusiveOrExpression_54_Var = (InclusiveOrExpression)Expr_53_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_54_Var);
		final EList<? extends EObject> Expr_54_list = InclusiveOrExpression_54_Var.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_55_Var = (ExclusiveOrExpression)Expr_54_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_55_Var);
		final EList<? extends EObject> Expr_55_list = ExclusiveOrExpression_55_Var.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		final AndExpression AndExpression_56_Var = (AndExpression)Expr_55_list.get(0);
		Assert.assertNotNull(AndExpression_56_Var);
		final EList<? extends EObject> Expr_56_list = AndExpression_56_Var.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		final EqualityExpression EqualityExpression_57_Var = (EqualityExpression)Expr_56_list.get(0);
		Assert.assertNotNull(EqualityExpression_57_Var);
		final EList<? extends EObject> Expr_57_list = EqualityExpression_57_Var.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		final RelationalExpression RelationalExpression_58_Var = (RelationalExpression)Expr_57_list.get(0);
		Assert.assertNotNull(RelationalExpression_58_Var);
		final EList<? extends EObject> Expr_58_list = RelationalExpression_58_Var.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		final ShiftExpression ShiftExpression_59_Var = (ShiftExpression)Expr_58_list.get(0);
		Assert.assertNotNull(ShiftExpression_59_Var);
		final EList<? extends EObject> Expr_59_list = ShiftExpression_59_Var.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		final AdditiveExpression AdditiveExpression_60_Var = (AdditiveExpression)Expr_59_list.get(0);
		Assert.assertNotNull(AdditiveExpression_60_Var);
		final EList<? extends EObject> Expr_60_list = AdditiveExpression_60_Var.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		final MultiplicativeExpression MultiplicativeExpression_61_Var = (MultiplicativeExpression)Expr_60_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_61_Var);
		final EList<? extends EObject> Expr_61_list = MultiplicativeExpression_61_Var.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		final CastExpression CastExpression_62_Var = (CastExpression)Expr_61_list.get(0);
		Assert.assertNotNull(CastExpression_62_Var);
		final UnaryExpression UnaryExpression_63_Var = (UnaryExpression)CastExpression_62_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_63_Var);
		final PostfixExpression PostfixExpression_64_Var = (PostfixExpression)UnaryExpression_63_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_64_Var);
		final EList<? extends EObject> Expr_64_list = PostfixExpression_64_Var.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		final PrimaryExpression PrimaryExpression_65_Var = (PrimaryExpression)Expr_64_list.get(0);
		Assert.assertNotNull(PrimaryExpression_65_Var);
		final Constant Constant_66_Var = (Constant)PrimaryExpression_65_Var.getConst();
		Assert.assertNotNull(Constant_66_Var);
		Assert.assertEquals("0", Constant_66_Var.getDec());
		Assert.assertEquals("return", JumpStatement_48_Var.getReturn());
		Assert.assertEquals(";", JumpStatement_48_Var.getSemi());
		final Statement Statement_67_Var = (Statement)SelectionStatement_21_Var.getElseStatement();
		Assert.assertNotNull(Statement_67_Var);
		final SelectionStatement SelectionStatement_68_Var = (SelectionStatement)Statement_67_Var.getStmt();
		Assert.assertNotNull(SelectionStatement_68_Var);
		Assert.assertEquals("if", SelectionStatement_68_Var.getIf());
		final Expression Expression_69_Var = (Expression)SelectionStatement_68_Var.getExpr();
		Assert.assertNotNull(Expression_69_Var);
		final EList<? extends EObject> ExprExpr_69_list = Expression_69_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_69_list);
		Assert.assertEquals(1, ExprExpr_69_list.size());
		final AssignmentExpression AssignmentExpression_70_Var = (AssignmentExpression)ExprExpr_69_list.get(0);
		Assert.assertNotNull(AssignmentExpression_70_Var);
		final ConditionalExpression ConditionalExpression_71_Var = (ConditionalExpression)AssignmentExpression_70_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_71_Var);
		final LogicalOrExpression LogicalOrExpression_72_Var = (LogicalOrExpression)ConditionalExpression_71_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_72_Var);
		final EList<? extends EObject> Expr_72_list = LogicalOrExpression_72_Var.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		final LogicalAndExpression LogicalAndExpression_73_Var = (LogicalAndExpression)Expr_72_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_73_Var);
		final EList<? extends EObject> Expr_73_list = LogicalAndExpression_73_Var.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		final InclusiveOrExpression InclusiveOrExpression_74_Var = (InclusiveOrExpression)Expr_73_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_74_Var);
		final EList<? extends EObject> Expr_74_list = InclusiveOrExpression_74_Var.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_75_Var = (ExclusiveOrExpression)Expr_74_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_75_Var);
		final EList<? extends EObject> Expr_75_list = ExclusiveOrExpression_75_Var.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		final AndExpression AndExpression_76_Var = (AndExpression)Expr_75_list.get(0);
		Assert.assertNotNull(AndExpression_76_Var);
		final EList<? extends EObject> Expr_76_list = AndExpression_76_Var.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		final EqualityExpression EqualityExpression_77_Var = (EqualityExpression)Expr_76_list.get(0);
		Assert.assertNotNull(EqualityExpression_77_Var);
		Assert.assertEquals("[==]", EqualityExpression_77_Var.getOp().toString());
		final EList<? extends EObject> Expr_77_list = EqualityExpression_77_Var.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(2, Expr_77_list.size());
		final RelationalExpression RelationalExpression_78_Var = (RelationalExpression)Expr_77_list.get(0);
		Assert.assertNotNull(RelationalExpression_78_Var);
		final EList<? extends EObject> Expr_78_list = RelationalExpression_78_Var.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		final ShiftExpression ShiftExpression_79_Var = (ShiftExpression)Expr_78_list.get(0);
		Assert.assertNotNull(ShiftExpression_79_Var);
		final EList<? extends EObject> Expr_79_list = ShiftExpression_79_Var.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		final AdditiveExpression AdditiveExpression_80_Var = (AdditiveExpression)Expr_79_list.get(0);
		Assert.assertNotNull(AdditiveExpression_80_Var);
		final EList<? extends EObject> Expr_80_list = AdditiveExpression_80_Var.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		final MultiplicativeExpression MultiplicativeExpression_81_Var = (MultiplicativeExpression)Expr_80_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_81_Var);
		final EList<? extends EObject> Expr_81_list = MultiplicativeExpression_81_Var.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		final CastExpression CastExpression_82_Var = (CastExpression)Expr_81_list.get(0);
		Assert.assertNotNull(CastExpression_82_Var);
		final UnaryExpression UnaryExpression_83_Var = (UnaryExpression)CastExpression_82_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_83_Var);
		final PostfixExpression PostfixExpression_84_Var = (PostfixExpression)UnaryExpression_83_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_84_Var);
		final EList<? extends EObject> Expr_84_list = PostfixExpression_84_Var.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		final PrimaryExpression PrimaryExpression_85_Var = (PrimaryExpression)Expr_84_list.get(0);
		Assert.assertNotNull(PrimaryExpression_85_Var);
		Assert.assertEquals("argc", PrimaryExpression_85_Var.getId());
		final RelationalExpression RelationalExpression_86_Var = (RelationalExpression)Expr_77_list.get(1);
		Assert.assertNotNull(RelationalExpression_86_Var);
		final EList<? extends EObject> Expr_86_list = RelationalExpression_86_Var.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		final ShiftExpression ShiftExpression_87_Var = (ShiftExpression)Expr_86_list.get(0);
		Assert.assertNotNull(ShiftExpression_87_Var);
		final EList<? extends EObject> Expr_87_list = ShiftExpression_87_Var.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		final AdditiveExpression AdditiveExpression_88_Var = (AdditiveExpression)Expr_87_list.get(0);
		Assert.assertNotNull(AdditiveExpression_88_Var);
		final EList<? extends EObject> Expr_88_list = AdditiveExpression_88_Var.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		final MultiplicativeExpression MultiplicativeExpression_89_Var = (MultiplicativeExpression)Expr_88_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_89_Var);
		final EList<? extends EObject> Expr_89_list = MultiplicativeExpression_89_Var.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		final CastExpression CastExpression_90_Var = (CastExpression)Expr_89_list.get(0);
		Assert.assertNotNull(CastExpression_90_Var);
		final UnaryExpression UnaryExpression_91_Var = (UnaryExpression)CastExpression_90_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_91_Var);
		final PostfixExpression PostfixExpression_92_Var = (PostfixExpression)UnaryExpression_91_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_92_Var);
		final EList<? extends EObject> Expr_92_list = PostfixExpression_92_Var.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		final PrimaryExpression PrimaryExpression_93_Var = (PrimaryExpression)Expr_92_list.get(0);
		Assert.assertNotNull(PrimaryExpression_93_Var);
		final Constant Constant_94_Var = (Constant)PrimaryExpression_93_Var.getConst();
		Assert.assertNotNull(Constant_94_Var);
		Assert.assertEquals("1", Constant_94_Var.getDec());
		Assert.assertEquals("else", SelectionStatement_68_Var.getElse());
		final Statement Statement_95_Var = (Statement)SelectionStatement_68_Var.getIfStatement();
		Assert.assertNotNull(Statement_95_Var);
		final CompoundStatement CompoundStatement_96_Var = (CompoundStatement)Statement_95_Var.getStmt();
		Assert.assertNotNull(CompoundStatement_96_Var);
		final BodyStatement BodyStatement_97_Var = (BodyStatement)CompoundStatement_96_Var.getBody();
		Assert.assertNotNull(BodyStatement_97_Var);
		final EList<? extends EObject> BlockList_97_list = BodyStatement_97_Var.getBlockList();
		Assert.assertNotNull(BlockList_97_list);
		Assert.assertEquals(1, BlockList_97_list.size());
		final BlockList BlockList_98_Var = (BlockList)BlockList_97_list.get(0);
		Assert.assertNotNull(BlockList_98_Var);
		final EList<? extends EObject> Statement_98_list = BlockList_98_Var.getStatement();
		Assert.assertNotNull(Statement_98_list);
		Assert.assertEquals(1, Statement_98_list.size());
		final Statement Statement_99_Var = (Statement)Statement_98_list.get(0);
		Assert.assertNotNull(Statement_99_Var);
		final JumpStatement JumpStatement_100_Var = (JumpStatement)Statement_99_Var.getStmt();
		Assert.assertNotNull(JumpStatement_100_Var);
		final Expression Expression_101_Var = (Expression)JumpStatement_100_Var.getExpr();
		Assert.assertNotNull(Expression_101_Var);
		final EList<? extends EObject> ExprExpr_101_list = Expression_101_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_101_list);
		Assert.assertEquals(1, ExprExpr_101_list.size());
		final AssignmentExpression AssignmentExpression_102_Var = (AssignmentExpression)ExprExpr_101_list.get(0);
		Assert.assertNotNull(AssignmentExpression_102_Var);
		final ConditionalExpression ConditionalExpression_103_Var = (ConditionalExpression)AssignmentExpression_102_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_103_Var);
		final LogicalOrExpression LogicalOrExpression_104_Var = (LogicalOrExpression)ConditionalExpression_103_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_104_Var);
		final EList<? extends EObject> Expr_104_list = LogicalOrExpression_104_Var.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		final LogicalAndExpression LogicalAndExpression_105_Var = (LogicalAndExpression)Expr_104_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_105_Var);
		final EList<? extends EObject> Expr_105_list = LogicalAndExpression_105_Var.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		final InclusiveOrExpression InclusiveOrExpression_106_Var = (InclusiveOrExpression)Expr_105_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_106_Var);
		final EList<? extends EObject> Expr_106_list = InclusiveOrExpression_106_Var.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_107_Var = (ExclusiveOrExpression)Expr_106_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_107_Var);
		final EList<? extends EObject> Expr_107_list = ExclusiveOrExpression_107_Var.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		final AndExpression AndExpression_108_Var = (AndExpression)Expr_107_list.get(0);
		Assert.assertNotNull(AndExpression_108_Var);
		final EList<? extends EObject> Expr_108_list = AndExpression_108_Var.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		final EqualityExpression EqualityExpression_109_Var = (EqualityExpression)Expr_108_list.get(0);
		Assert.assertNotNull(EqualityExpression_109_Var);
		final EList<? extends EObject> Expr_109_list = EqualityExpression_109_Var.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		final RelationalExpression RelationalExpression_110_Var = (RelationalExpression)Expr_109_list.get(0);
		Assert.assertNotNull(RelationalExpression_110_Var);
		final EList<? extends EObject> Expr_110_list = RelationalExpression_110_Var.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		final ShiftExpression ShiftExpression_111_Var = (ShiftExpression)Expr_110_list.get(0);
		Assert.assertNotNull(ShiftExpression_111_Var);
		final EList<? extends EObject> Expr_111_list = ShiftExpression_111_Var.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		final AdditiveExpression AdditiveExpression_112_Var = (AdditiveExpression)Expr_111_list.get(0);
		Assert.assertNotNull(AdditiveExpression_112_Var);
		final EList<? extends EObject> Expr_112_list = AdditiveExpression_112_Var.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		final MultiplicativeExpression MultiplicativeExpression_113_Var = (MultiplicativeExpression)Expr_112_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_113_Var);
		final EList<? extends EObject> Expr_113_list = MultiplicativeExpression_113_Var.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		final CastExpression CastExpression_114_Var = (CastExpression)Expr_113_list.get(0);
		Assert.assertNotNull(CastExpression_114_Var);
		final UnaryExpression UnaryExpression_115_Var = (UnaryExpression)CastExpression_114_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_115_Var);
		final PostfixExpression PostfixExpression_116_Var = (PostfixExpression)UnaryExpression_115_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_116_Var);
		final EList<? extends EObject> Expr_116_list = PostfixExpression_116_Var.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		final PrimaryExpression PrimaryExpression_117_Var = (PrimaryExpression)Expr_116_list.get(0);
		Assert.assertNotNull(PrimaryExpression_117_Var);
		final Constant Constant_118_Var = (Constant)PrimaryExpression_117_Var.getConst();
		Assert.assertNotNull(Constant_118_Var);
		Assert.assertEquals("1", Constant_118_Var.getDec());
		Assert.assertEquals("return", JumpStatement_100_Var.getReturn());
		Assert.assertEquals(";", JumpStatement_100_Var.getSemi());
		final Statement Statement_119_Var = (Statement)SelectionStatement_68_Var.getElseStatement();
		Assert.assertNotNull(Statement_119_Var);
		final CompoundStatement CompoundStatement_120_Var = (CompoundStatement)Statement_119_Var.getStmt();
		Assert.assertNotNull(CompoundStatement_120_Var);
		final BodyStatement BodyStatement_121_Var = (BodyStatement)CompoundStatement_120_Var.getBody();
		Assert.assertNotNull(BodyStatement_121_Var);
		final EList<? extends EObject> BlockList_121_list = BodyStatement_121_Var.getBlockList();
		Assert.assertNotNull(BlockList_121_list);
		Assert.assertEquals(1, BlockList_121_list.size());
		final BlockList BlockList_122_Var = (BlockList)BlockList_121_list.get(0);
		Assert.assertNotNull(BlockList_122_Var);
		final EList<? extends EObject> Statement_122_list = BlockList_122_Var.getStatement();
		Assert.assertNotNull(Statement_122_list);
		Assert.assertEquals(1, Statement_122_list.size());
		final Statement Statement_123_Var = (Statement)Statement_122_list.get(0);
		Assert.assertNotNull(Statement_123_Var);
		final JumpStatement JumpStatement_124_Var = (JumpStatement)Statement_123_Var.getStmt();
		Assert.assertNotNull(JumpStatement_124_Var);
		final Expression Expression_125_Var = (Expression)JumpStatement_124_Var.getExpr();
		Assert.assertNotNull(Expression_125_Var);
		final EList<? extends EObject> ExprExpr_125_list = Expression_125_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_125_list);
		Assert.assertEquals(1, ExprExpr_125_list.size());
		final AssignmentExpression AssignmentExpression_126_Var = (AssignmentExpression)ExprExpr_125_list.get(0);
		Assert.assertNotNull(AssignmentExpression_126_Var);
		final ConditionalExpression ConditionalExpression_127_Var = (ConditionalExpression)AssignmentExpression_126_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_127_Var);
		final LogicalOrExpression LogicalOrExpression_128_Var = (LogicalOrExpression)ConditionalExpression_127_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_128_Var);
		final EList<? extends EObject> Expr_128_list = LogicalOrExpression_128_Var.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		final LogicalAndExpression LogicalAndExpression_129_Var = (LogicalAndExpression)Expr_128_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_129_Var);
		final EList<? extends EObject> Expr_129_list = LogicalAndExpression_129_Var.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		final InclusiveOrExpression InclusiveOrExpression_130_Var = (InclusiveOrExpression)Expr_129_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_130_Var);
		final EList<? extends EObject> Expr_130_list = InclusiveOrExpression_130_Var.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_131_Var = (ExclusiveOrExpression)Expr_130_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_131_Var);
		final EList<? extends EObject> Expr_131_list = ExclusiveOrExpression_131_Var.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		final AndExpression AndExpression_132_Var = (AndExpression)Expr_131_list.get(0);
		Assert.assertNotNull(AndExpression_132_Var);
		final EList<? extends EObject> Expr_132_list = AndExpression_132_Var.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		final EqualityExpression EqualityExpression_133_Var = (EqualityExpression)Expr_132_list.get(0);
		Assert.assertNotNull(EqualityExpression_133_Var);
		final EList<? extends EObject> Expr_133_list = EqualityExpression_133_Var.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		final RelationalExpression RelationalExpression_134_Var = (RelationalExpression)Expr_133_list.get(0);
		Assert.assertNotNull(RelationalExpression_134_Var);
		final EList<? extends EObject> Expr_134_list = RelationalExpression_134_Var.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		final ShiftExpression ShiftExpression_135_Var = (ShiftExpression)Expr_134_list.get(0);
		Assert.assertNotNull(ShiftExpression_135_Var);
		final EList<? extends EObject> Expr_135_list = ShiftExpression_135_Var.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		final AdditiveExpression AdditiveExpression_136_Var = (AdditiveExpression)Expr_135_list.get(0);
		Assert.assertNotNull(AdditiveExpression_136_Var);
		final EList<? extends EObject> Expr_136_list = AdditiveExpression_136_Var.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		final MultiplicativeExpression MultiplicativeExpression_137_Var = (MultiplicativeExpression)Expr_136_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_137_Var);
		final EList<? extends EObject> Expr_137_list = MultiplicativeExpression_137_Var.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		final CastExpression CastExpression_138_Var = (CastExpression)Expr_137_list.get(0);
		Assert.assertNotNull(CastExpression_138_Var);
		final UnaryExpression UnaryExpression_139_Var = (UnaryExpression)CastExpression_138_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_139_Var);
		final PostfixExpression PostfixExpression_140_Var = (PostfixExpression)UnaryExpression_139_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_140_Var);
		final EList<? extends EObject> Expr_140_list = PostfixExpression_140_Var.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		final PrimaryExpression PrimaryExpression_141_Var = (PrimaryExpression)Expr_140_list.get(0);
		Assert.assertNotNull(PrimaryExpression_141_Var);
		final Constant Constant_142_Var = (Constant)PrimaryExpression_141_Var.getConst();
		Assert.assertNotNull(Constant_142_Var);
		Assert.assertEquals("2", Constant_142_Var.getDec());
		Assert.assertEquals("return", JumpStatement_124_Var.getReturn());
		Assert.assertEquals(";", JumpStatement_124_Var.getSemi());
	}


}
