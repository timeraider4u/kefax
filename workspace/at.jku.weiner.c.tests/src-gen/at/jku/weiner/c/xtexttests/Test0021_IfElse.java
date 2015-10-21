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
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.UnaryOperator;
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
		Assert.assertEquals(5, External_1_list.size());
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
		Assert.assertEquals("argv", DirectDeclarator_16_Var.getId());
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
		final JumpStatement JumpStatement_21_Var = (JumpStatement)Statement_20_Var.getStmt();
		Assert.assertNotNull(JumpStatement_21_Var);
		final Expression Expression_22_Var = (Expression)JumpStatement_21_Var.getExpr();
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
		final Constant Constant_39_Var = (Constant)PrimaryExpression_38_Var.getConst();
		Assert.assertNotNull(Constant_39_Var);
		Assert.assertEquals("'a'", Constant_39_Var.getCh());
		Assert.assertEquals("return", JumpStatement_21_Var.getReturn());
		Assert.assertEquals(";", JumpStatement_21_Var.getSemi());
		final ExternalDeclaration ExternalDeclaration_40_Var = (ExternalDeclaration)External_1_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_40_Var);
		final FunctionDefHead FunctionDefHead_41_Var = (FunctionDefHead)ExternalDeclaration_40_Var.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_41_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_42_Var = (DeclarationSpecifiers)FunctionDefHead_41_Var.getFunDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_42_Var);
		final EList<? extends EObject> DeclarationSpecifier_42_list = DeclarationSpecifiers_42_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_42_list);
		Assert.assertEquals(1, DeclarationSpecifier_42_list.size());
		final TypeSpecifier TypeSpecifier_43_Var = (TypeSpecifier)DeclarationSpecifier_42_list.get(0);
		Assert.assertNotNull(TypeSpecifier_43_Var);
		Assert.assertEquals("int", TypeSpecifier_43_Var.getName());
		final Declarator Declarator_44_Var = (Declarator)FunctionDefHead_41_Var.getFunDeclarator();
		Assert.assertNotNull(Declarator_44_Var);
		final DirectDeclarator DirectDeclarator_45_Var = (DirectDeclarator)Declarator_44_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_45_Var);
		Assert.assertEquals("doSomething2", DirectDeclarator_45_Var.getId());
		final FunctionDefinition FunctionDefinition_46_Var = (FunctionDefinition)ExternalDeclaration_40_Var.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_46_Var);
		final BodyStatement BodyStatement_47_Var = (BodyStatement)FunctionDefinition_46_Var.getBody();
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
		final CastExpression CastExpression_66_Var = (CastExpression)UnaryExpression_65_Var.getExpr();
		Assert.assertNotNull(CastExpression_66_Var);
		final UnaryExpression UnaryExpression_67_Var = (UnaryExpression)CastExpression_66_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_67_Var);
		final PostfixExpression PostfixExpression_68_Var = (PostfixExpression)UnaryExpression_67_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_68_Var);
		final EList<? extends EObject> Expr_68_list = PostfixExpression_68_Var.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		final PrimaryExpression PrimaryExpression_69_Var = (PrimaryExpression)Expr_68_list.get(0);
		Assert.assertNotNull(PrimaryExpression_69_Var);
		final Constant Constant_70_Var = (Constant)PrimaryExpression_69_Var.getConst();
		Assert.assertNotNull(Constant_70_Var);
		Assert.assertEquals("1", Constant_70_Var.getDec());
		final UnaryOperator UnaryOperator_71_Var = (UnaryOperator)UnaryExpression_65_Var.getOp();
		Assert.assertNotNull(UnaryOperator_71_Var);
		Assert.assertEquals("-", UnaryOperator_71_Var.getOp());
		Assert.assertEquals("return", JumpStatement_50_Var.getReturn());
		Assert.assertEquals(";", JumpStatement_50_Var.getSemi());
		final ExternalDeclaration ExternalDeclaration_72_Var = (ExternalDeclaration)External_1_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_72_Var);
		final FunctionDefHead FunctionDefHead_73_Var = (FunctionDefHead)ExternalDeclaration_72_Var.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_73_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_74_Var = (DeclarationSpecifiers)FunctionDefHead_73_Var.getFunDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_74_Var);
		final EList<? extends EObject> DeclarationSpecifier_74_list = DeclarationSpecifiers_74_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_74_list);
		Assert.assertEquals(1, DeclarationSpecifier_74_list.size());
		final TypeSpecifier TypeSpecifier_75_Var = (TypeSpecifier)DeclarationSpecifier_74_list.get(0);
		Assert.assertNotNull(TypeSpecifier_75_Var);
		Assert.assertEquals("double", TypeSpecifier_75_Var.getName());
		final Declarator Declarator_76_Var = (Declarator)FunctionDefHead_73_Var.getFunDeclarator();
		Assert.assertNotNull(Declarator_76_Var);
		final DirectDeclarator DirectDeclarator_77_Var = (DirectDeclarator)Declarator_76_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_77_Var);
		Assert.assertEquals("doSomething3", DirectDeclarator_77_Var.getId());
		final FunctionDefinition FunctionDefinition_78_Var = (FunctionDefinition)ExternalDeclaration_72_Var.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_78_Var);
		final BodyStatement BodyStatement_79_Var = (BodyStatement)FunctionDefinition_78_Var.getBody();
		Assert.assertNotNull(BodyStatement_79_Var);
		final EList<? extends EObject> BlockList_79_list = BodyStatement_79_Var.getBlockList();
		Assert.assertNotNull(BlockList_79_list);
		Assert.assertEquals(1, BlockList_79_list.size());
		final BlockList BlockList_80_Var = (BlockList)BlockList_79_list.get(0);
		Assert.assertNotNull(BlockList_80_Var);
		final EList<? extends EObject> Statement_80_list = BlockList_80_Var.getStatement();
		Assert.assertNotNull(Statement_80_list);
		Assert.assertEquals(1, Statement_80_list.size());
		final Statement Statement_81_Var = (Statement)Statement_80_list.get(0);
		Assert.assertNotNull(Statement_81_Var);
		final JumpStatement JumpStatement_82_Var = (JumpStatement)Statement_81_Var.getStmt();
		Assert.assertNotNull(JumpStatement_82_Var);
		final Expression Expression_83_Var = (Expression)JumpStatement_82_Var.getExpr();
		Assert.assertNotNull(Expression_83_Var);
		final EList<? extends EObject> ExprExpr_83_list = Expression_83_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_83_list);
		Assert.assertEquals(1, ExprExpr_83_list.size());
		final AssignmentExpression AssignmentExpression_84_Var = (AssignmentExpression)ExprExpr_83_list.get(0);
		Assert.assertNotNull(AssignmentExpression_84_Var);
		final ConditionalExpression ConditionalExpression_85_Var = (ConditionalExpression)AssignmentExpression_84_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_85_Var);
		final LogicalOrExpression LogicalOrExpression_86_Var = (LogicalOrExpression)ConditionalExpression_85_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_86_Var);
		final EList<? extends EObject> Expr_86_list = LogicalOrExpression_86_Var.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		final LogicalAndExpression LogicalAndExpression_87_Var = (LogicalAndExpression)Expr_86_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_87_Var);
		final EList<? extends EObject> Expr_87_list = LogicalAndExpression_87_Var.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		final InclusiveOrExpression InclusiveOrExpression_88_Var = (InclusiveOrExpression)Expr_87_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_88_Var);
		final EList<? extends EObject> Expr_88_list = InclusiveOrExpression_88_Var.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_89_Var = (ExclusiveOrExpression)Expr_88_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_89_Var);
		final EList<? extends EObject> Expr_89_list = ExclusiveOrExpression_89_Var.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		final AndExpression AndExpression_90_Var = (AndExpression)Expr_89_list.get(0);
		Assert.assertNotNull(AndExpression_90_Var);
		final EList<? extends EObject> Expr_90_list = AndExpression_90_Var.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		final EqualityExpression EqualityExpression_91_Var = (EqualityExpression)Expr_90_list.get(0);
		Assert.assertNotNull(EqualityExpression_91_Var);
		final EList<? extends EObject> Expr_91_list = EqualityExpression_91_Var.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		final RelationalExpression RelationalExpression_92_Var = (RelationalExpression)Expr_91_list.get(0);
		Assert.assertNotNull(RelationalExpression_92_Var);
		final EList<? extends EObject> Expr_92_list = RelationalExpression_92_Var.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		final ShiftExpression ShiftExpression_93_Var = (ShiftExpression)Expr_92_list.get(0);
		Assert.assertNotNull(ShiftExpression_93_Var);
		final EList<? extends EObject> Expr_93_list = ShiftExpression_93_Var.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		final AdditiveExpression AdditiveExpression_94_Var = (AdditiveExpression)Expr_93_list.get(0);
		Assert.assertNotNull(AdditiveExpression_94_Var);
		final EList<? extends EObject> Expr_94_list = AdditiveExpression_94_Var.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		final MultiplicativeExpression MultiplicativeExpression_95_Var = (MultiplicativeExpression)Expr_94_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_95_Var);
		final EList<? extends EObject> Expr_95_list = MultiplicativeExpression_95_Var.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		final CastExpression CastExpression_96_Var = (CastExpression)Expr_95_list.get(0);
		Assert.assertNotNull(CastExpression_96_Var);
		final UnaryExpression UnaryExpression_97_Var = (UnaryExpression)CastExpression_96_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_97_Var);
		final PostfixExpression PostfixExpression_98_Var = (PostfixExpression)UnaryExpression_97_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_98_Var);
		final EList<? extends EObject> Expr_98_list = PostfixExpression_98_Var.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		final PrimaryExpression PrimaryExpression_99_Var = (PrimaryExpression)Expr_98_list.get(0);
		Assert.assertNotNull(PrimaryExpression_99_Var);
		final Constant Constant_100_Var = (Constant)PrimaryExpression_99_Var.getConst();
		Assert.assertNotNull(Constant_100_Var);
		Assert.assertEquals("0.8", Constant_100_Var.getFloat());
		Assert.assertEquals("return", JumpStatement_82_Var.getReturn());
		Assert.assertEquals(";", JumpStatement_82_Var.getSemi());
		final ExternalDeclaration ExternalDeclaration_101_Var = (ExternalDeclaration)External_1_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_101_Var);
		final FunctionDefHead FunctionDefHead_102_Var = (FunctionDefHead)ExternalDeclaration_101_Var.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_102_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_103_Var = (DeclarationSpecifiers)FunctionDefHead_102_Var.getFunDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_103_Var);
		final EList<? extends EObject> DeclarationSpecifier_103_list = DeclarationSpecifiers_103_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_103_list);
		Assert.assertEquals(1, DeclarationSpecifier_103_list.size());
		final TypeSpecifier TypeSpecifier_104_Var = (TypeSpecifier)DeclarationSpecifier_103_list.get(0);
		Assert.assertNotNull(TypeSpecifier_104_Var);
		Assert.assertEquals("float", TypeSpecifier_104_Var.getName());
		final Declarator Declarator_105_Var = (Declarator)FunctionDefHead_102_Var.getFunDeclarator();
		Assert.assertNotNull(Declarator_105_Var);
		final DirectDeclarator DirectDeclarator_106_Var = (DirectDeclarator)Declarator_105_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_106_Var);
		Assert.assertEquals("doSomething4", DirectDeclarator_106_Var.getId());
		final FunctionDefinition FunctionDefinition_107_Var = (FunctionDefinition)ExternalDeclaration_101_Var.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_107_Var);
		final BodyStatement BodyStatement_108_Var = (BodyStatement)FunctionDefinition_107_Var.getBody();
		Assert.assertNotNull(BodyStatement_108_Var);
		final EList<? extends EObject> BlockList_108_list = BodyStatement_108_Var.getBlockList();
		Assert.assertNotNull(BlockList_108_list);
		Assert.assertEquals(1, BlockList_108_list.size());
		final BlockList BlockList_109_Var = (BlockList)BlockList_108_list.get(0);
		Assert.assertNotNull(BlockList_109_Var);
		final EList<? extends EObject> Statement_109_list = BlockList_109_Var.getStatement();
		Assert.assertNotNull(Statement_109_list);
		Assert.assertEquals(1, Statement_109_list.size());
		final Statement Statement_110_Var = (Statement)Statement_109_list.get(0);
		Assert.assertNotNull(Statement_110_Var);
		final JumpStatement JumpStatement_111_Var = (JumpStatement)Statement_110_Var.getStmt();
		Assert.assertNotNull(JumpStatement_111_Var);
		final Expression Expression_112_Var = (Expression)JumpStatement_111_Var.getExpr();
		Assert.assertNotNull(Expression_112_Var);
		final EList<? extends EObject> ExprExpr_112_list = Expression_112_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_112_list);
		Assert.assertEquals(1, ExprExpr_112_list.size());
		final AssignmentExpression AssignmentExpression_113_Var = (AssignmentExpression)ExprExpr_112_list.get(0);
		Assert.assertNotNull(AssignmentExpression_113_Var);
		final ConditionalExpression ConditionalExpression_114_Var = (ConditionalExpression)AssignmentExpression_113_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_114_Var);
		final LogicalOrExpression LogicalOrExpression_115_Var = (LogicalOrExpression)ConditionalExpression_114_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_115_Var);
		final EList<? extends EObject> Expr_115_list = LogicalOrExpression_115_Var.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		final LogicalAndExpression LogicalAndExpression_116_Var = (LogicalAndExpression)Expr_115_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_116_Var);
		final EList<? extends EObject> Expr_116_list = LogicalAndExpression_116_Var.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		final InclusiveOrExpression InclusiveOrExpression_117_Var = (InclusiveOrExpression)Expr_116_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_117_Var);
		final EList<? extends EObject> Expr_117_list = InclusiveOrExpression_117_Var.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_118_Var = (ExclusiveOrExpression)Expr_117_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_118_Var);
		final EList<? extends EObject> Expr_118_list = ExclusiveOrExpression_118_Var.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		final AndExpression AndExpression_119_Var = (AndExpression)Expr_118_list.get(0);
		Assert.assertNotNull(AndExpression_119_Var);
		final EList<? extends EObject> Expr_119_list = AndExpression_119_Var.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		final EqualityExpression EqualityExpression_120_Var = (EqualityExpression)Expr_119_list.get(0);
		Assert.assertNotNull(EqualityExpression_120_Var);
		final EList<? extends EObject> Expr_120_list = EqualityExpression_120_Var.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		final RelationalExpression RelationalExpression_121_Var = (RelationalExpression)Expr_120_list.get(0);
		Assert.assertNotNull(RelationalExpression_121_Var);
		final EList<? extends EObject> Expr_121_list = RelationalExpression_121_Var.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		final ShiftExpression ShiftExpression_122_Var = (ShiftExpression)Expr_121_list.get(0);
		Assert.assertNotNull(ShiftExpression_122_Var);
		final EList<? extends EObject> Expr_122_list = ShiftExpression_122_Var.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		final AdditiveExpression AdditiveExpression_123_Var = (AdditiveExpression)Expr_122_list.get(0);
		Assert.assertNotNull(AdditiveExpression_123_Var);
		final EList<? extends EObject> Expr_123_list = AdditiveExpression_123_Var.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		final MultiplicativeExpression MultiplicativeExpression_124_Var = (MultiplicativeExpression)Expr_123_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_124_Var);
		final EList<? extends EObject> Expr_124_list = MultiplicativeExpression_124_Var.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		final CastExpression CastExpression_125_Var = (CastExpression)Expr_124_list.get(0);
		Assert.assertNotNull(CastExpression_125_Var);
		final UnaryExpression UnaryExpression_126_Var = (UnaryExpression)CastExpression_125_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_126_Var);
		final PostfixExpression PostfixExpression_127_Var = (PostfixExpression)UnaryExpression_126_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_127_Var);
		final EList<? extends EObject> Expr_127_list = PostfixExpression_127_Var.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		final PrimaryExpression PrimaryExpression_128_Var = (PrimaryExpression)Expr_127_list.get(0);
		Assert.assertNotNull(PrimaryExpression_128_Var);
		final Constant Constant_129_Var = (Constant)PrimaryExpression_128_Var.getConst();
		Assert.assertNotNull(Constant_129_Var);
		Assert.assertEquals("0x01A", Constant_129_Var.getHex());
		Assert.assertEquals("return", JumpStatement_111_Var.getReturn());
		Assert.assertEquals(";", JumpStatement_111_Var.getSemi());
		final ExternalDeclaration ExternalDeclaration_130_Var = (ExternalDeclaration)External_1_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_130_Var);
		final FunctionDefHead FunctionDefHead_131_Var = (FunctionDefHead)ExternalDeclaration_130_Var.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_131_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_132_Var = (DeclarationSpecifiers)FunctionDefHead_131_Var.getFunDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_132_Var);
		final EList<? extends EObject> DeclarationSpecifier_132_list = DeclarationSpecifiers_132_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_132_list);
		Assert.assertEquals(1, DeclarationSpecifier_132_list.size());
		final TypeSpecifier TypeSpecifier_133_Var = (TypeSpecifier)DeclarationSpecifier_132_list.get(0);
		Assert.assertNotNull(TypeSpecifier_133_Var);
		Assert.assertEquals("void", TypeSpecifier_133_Var.getName());
		final Declarator Declarator_134_Var = (Declarator)FunctionDefHead_131_Var.getFunDeclarator();
		Assert.assertNotNull(Declarator_134_Var);
		final DirectDeclarator DirectDeclarator_135_Var = (DirectDeclarator)Declarator_134_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_135_Var);
		Assert.assertEquals("doSomething5", DirectDeclarator_135_Var.getId());
		final FunctionDefinition FunctionDefinition_136_Var = (FunctionDefinition)ExternalDeclaration_130_Var.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_136_Var);
		final BodyStatement BodyStatement_137_Var = (BodyStatement)FunctionDefinition_136_Var.getBody();
		Assert.assertNotNull(BodyStatement_137_Var);
		final EList<? extends EObject> BlockList_137_list = BodyStatement_137_Var.getBlockList();
		Assert.assertNotNull(BlockList_137_list);
		Assert.assertEquals(1, BlockList_137_list.size());
		final BlockList BlockList_138_Var = (BlockList)BlockList_137_list.get(0);
		Assert.assertNotNull(BlockList_138_Var);
		final EList<? extends EObject> Statement_138_list = BlockList_138_Var.getStatement();
		Assert.assertNotNull(Statement_138_list);
		Assert.assertEquals(1, Statement_138_list.size());
		final Statement Statement_139_Var = (Statement)Statement_138_list.get(0);
		Assert.assertNotNull(Statement_139_Var);
		final JumpStatement JumpStatement_140_Var = (JumpStatement)Statement_139_Var.getStmt();
		Assert.assertNotNull(JumpStatement_140_Var);
		Assert.assertEquals("return", JumpStatement_140_Var.getReturn());
		Assert.assertEquals(";", JumpStatement_140_Var.getSemi());
	}


}
