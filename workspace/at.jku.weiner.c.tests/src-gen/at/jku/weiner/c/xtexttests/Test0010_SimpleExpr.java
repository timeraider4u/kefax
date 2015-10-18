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
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;

@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0010_SimpleExpr {

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
		final Path path = Paths.get("res/Test0010_SimpleExpr.c");
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
			"RULE_LINE_COMMENT",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_DECIMAL_LITERAL",
			"RULE_WHITESPACE",
			"RULE_PLUS",
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
		Assert.assertEquals(1, Statement_10_list.size());
		final Statement Statement_11_Var = (Statement)Statement_10_list.get(0);
		Assert.assertNotNull(Statement_11_Var);
		final ExpressionStatement ExpressionStatement_12_Var = (ExpressionStatement)Statement_11_Var.getStmt();
		Assert.assertNotNull(ExpressionStatement_12_Var);
		final Expression Expression_13_Var = (Expression)ExpressionStatement_12_Var.getExpression();
		Assert.assertNotNull(Expression_13_Var);
		final EList<? extends EObject> ExprExpr_13_list = Expression_13_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_13_list);
		Assert.assertEquals(1, ExprExpr_13_list.size());
		final AssignmentExpression AssignmentExpression_14_Var = (AssignmentExpression)ExprExpr_13_list.get(0);
		Assert.assertNotNull(AssignmentExpression_14_Var);
		final ConditionalExpression ConditionalExpression_15_Var = (ConditionalExpression)AssignmentExpression_14_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_15_Var);
		final LogicalOrExpression LogicalOrExpression_16_Var = (LogicalOrExpression)ConditionalExpression_15_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_16_Var);
		final EList<? extends EObject> Expr_16_list = LogicalOrExpression_16_Var.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		final LogicalAndExpression LogicalAndExpression_17_Var = (LogicalAndExpression)Expr_16_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_17_Var);
		final EList<? extends EObject> Expr_17_list = LogicalAndExpression_17_Var.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		final InclusiveOrExpression InclusiveOrExpression_18_Var = (InclusiveOrExpression)Expr_17_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_18_Var);
		final EList<? extends EObject> Expr_18_list = InclusiveOrExpression_18_Var.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_19_Var = (ExclusiveOrExpression)Expr_18_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_19_Var);
		final EList<? extends EObject> Expr_19_list = ExclusiveOrExpression_19_Var.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		final AndExpression AndExpression_20_Var = (AndExpression)Expr_19_list.get(0);
		Assert.assertNotNull(AndExpression_20_Var);
		final EList<? extends EObject> Expr_20_list = AndExpression_20_Var.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		final EqualityExpression EqualityExpression_21_Var = (EqualityExpression)Expr_20_list.get(0);
		Assert.assertNotNull(EqualityExpression_21_Var);
		final EList<? extends EObject> Expr_21_list = EqualityExpression_21_Var.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		final RelationalExpression RelationalExpression_22_Var = (RelationalExpression)Expr_21_list.get(0);
		Assert.assertNotNull(RelationalExpression_22_Var);
		final EList<? extends EObject> Expr_22_list = RelationalExpression_22_Var.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		final ShiftExpression ShiftExpression_23_Var = (ShiftExpression)Expr_22_list.get(0);
		Assert.assertNotNull(ShiftExpression_23_Var);
		final EList<? extends EObject> Expr_23_list = ShiftExpression_23_Var.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		final AdditiveExpression AdditiveExpression_24_Var = (AdditiveExpression)Expr_23_list.get(0);
		Assert.assertNotNull(AdditiveExpression_24_Var);
		final EList<? extends EObject> Expr_24_list = AdditiveExpression_24_Var.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(2, Expr_24_list.size());
		final MultiplicativeExpression MultiplicativeExpression_25_Var = (MultiplicativeExpression)Expr_24_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_25_Var);
		final EList<? extends EObject> Expr_25_list = MultiplicativeExpression_25_Var.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		final CastExpression CastExpression_26_Var = (CastExpression)Expr_25_list.get(0);
		Assert.assertNotNull(CastExpression_26_Var);
		final UnaryExpression UnaryExpression_27_Var = (UnaryExpression)CastExpression_26_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_27_Var);
		final PostfixExpression PostfixExpression_28_Var = (PostfixExpression)UnaryExpression_27_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_28_Var);
		final EList<? extends EObject> Expr_28_list = PostfixExpression_28_Var.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		final PrimaryExpression PrimaryExpression_29_Var = (PrimaryExpression)Expr_28_list.get(0);
		Assert.assertNotNull(PrimaryExpression_29_Var);
		final Constant Constant_30_Var = (Constant)PrimaryExpression_29_Var.getConst();
		Assert.assertNotNull(Constant_30_Var);
		Assert.assertEquals("1", Constant_30_Var.getDec());
		final MultiplicativeExpression MultiplicativeExpression_31_Var = (MultiplicativeExpression)Expr_24_list.get(1);
		Assert.assertNotNull(MultiplicativeExpression_31_Var);
		final EList<? extends EObject> Expr_31_list = MultiplicativeExpression_31_Var.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		final CastExpression CastExpression_32_Var = (CastExpression)Expr_31_list.get(0);
		Assert.assertNotNull(CastExpression_32_Var);
		final UnaryExpression UnaryExpression_33_Var = (UnaryExpression)CastExpression_32_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_33_Var);
		final PostfixExpression PostfixExpression_34_Var = (PostfixExpression)UnaryExpression_33_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_34_Var);
		final EList<? extends EObject> Expr_34_list = PostfixExpression_34_Var.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		final PrimaryExpression PrimaryExpression_35_Var = (PrimaryExpression)Expr_34_list.get(0);
		Assert.assertNotNull(PrimaryExpression_35_Var);
		final Constant Constant_36_Var = (Constant)PrimaryExpression_35_Var.getConst();
		Assert.assertNotNull(Constant_36_Var);
		Assert.assertEquals("1", Constant_36_Var.getDec());
		Assert.assertEquals("[+]", AdditiveExpression_24_Var.getOp().toString());
		Assert.assertEquals(";", ExpressionStatement_12_Var.getSemi());
	}


}
