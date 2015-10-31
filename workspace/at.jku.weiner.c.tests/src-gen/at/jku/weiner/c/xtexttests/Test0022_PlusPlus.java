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
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;

@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0022_PlusPlus {

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
		final Path path = Paths.get("res/Test0022_PlusPlus.c");
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
			"RULE_ID",
			"RULE_PLUSPLUS",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_KW_RETURN",
			"RULE_WHITESPACE",
			"RULE_PLUSPLUS",
			"RULE_ID",
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
		Assert.assertEquals(2, Statement_19_list.size());
		final Statement Statement_20_Var = (Statement)Statement_19_list.get(0);
		Assert.assertNotNull(Statement_20_Var);
		final ExpressionStatement ExpressionStatement_21_Var = (ExpressionStatement)Statement_20_Var.getStmt();
		Assert.assertNotNull(ExpressionStatement_21_Var);
		final Expression Expression_22_Var = (Expression)ExpressionStatement_21_Var.getExpression();
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
		Assert.assertEquals("num", PrimaryExpression_38_Var.getId());
		Assert.assertEquals("[++]", PostfixExpression_37_Var.getPlusplus().toString());
		Assert.assertEquals("[]", PostfixExpression_37_Var.getMinusminus().toString());
		Assert.assertEquals(";", ExpressionStatement_21_Var.getSemi());
		final Statement Statement_39_Var = (Statement)Statement_19_list.get(1);
		Assert.assertNotNull(Statement_39_Var);
		final JumpStatement JumpStatement_40_Var = (JumpStatement)Statement_39_Var.getStmt();
		Assert.assertNotNull(JumpStatement_40_Var);
		Assert.assertEquals("return", JumpStatement_40_Var.getReturn());
		final Expression Expression_41_Var = (Expression)JumpStatement_40_Var.getExpr();
		Assert.assertNotNull(Expression_41_Var);
		final EList<? extends EObject> ExprExpr_41_list = Expression_41_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_41_list);
		Assert.assertEquals(1, ExprExpr_41_list.size());
		final AssignmentExpression AssignmentExpression_42_Var = (AssignmentExpression)ExprExpr_41_list.get(0);
		Assert.assertNotNull(AssignmentExpression_42_Var);
		final ConditionalExpression ConditionalExpression_43_Var = (ConditionalExpression)AssignmentExpression_42_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_43_Var);
		final LogicalOrExpression LogicalOrExpression_44_Var = (LogicalOrExpression)ConditionalExpression_43_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_44_Var);
		final EList<? extends EObject> Expr_44_list = LogicalOrExpression_44_Var.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		final LogicalAndExpression LogicalAndExpression_45_Var = (LogicalAndExpression)Expr_44_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_45_Var);
		final EList<? extends EObject> Expr_45_list = LogicalAndExpression_45_Var.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		final InclusiveOrExpression InclusiveOrExpression_46_Var = (InclusiveOrExpression)Expr_45_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_46_Var);
		final EList<? extends EObject> Expr_46_list = InclusiveOrExpression_46_Var.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_47_Var = (ExclusiveOrExpression)Expr_46_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_47_Var);
		final EList<? extends EObject> Expr_47_list = ExclusiveOrExpression_47_Var.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		final AndExpression AndExpression_48_Var = (AndExpression)Expr_47_list.get(0);
		Assert.assertNotNull(AndExpression_48_Var);
		final EList<? extends EObject> Expr_48_list = AndExpression_48_Var.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		final EqualityExpression EqualityExpression_49_Var = (EqualityExpression)Expr_48_list.get(0);
		Assert.assertNotNull(EqualityExpression_49_Var);
		final EList<? extends EObject> Expr_49_list = EqualityExpression_49_Var.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		final RelationalExpression RelationalExpression_50_Var = (RelationalExpression)Expr_49_list.get(0);
		Assert.assertNotNull(RelationalExpression_50_Var);
		final EList<? extends EObject> Expr_50_list = RelationalExpression_50_Var.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		final ShiftExpression ShiftExpression_51_Var = (ShiftExpression)Expr_50_list.get(0);
		Assert.assertNotNull(ShiftExpression_51_Var);
		final EList<? extends EObject> Expr_51_list = ShiftExpression_51_Var.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		final AdditiveExpression AdditiveExpression_52_Var = (AdditiveExpression)Expr_51_list.get(0);
		Assert.assertNotNull(AdditiveExpression_52_Var);
		final EList<? extends EObject> Expr_52_list = AdditiveExpression_52_Var.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		final MultiplicativeExpression MultiplicativeExpression_53_Var = (MultiplicativeExpression)Expr_52_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_53_Var);
		final EList<? extends EObject> Expr_53_list = MultiplicativeExpression_53_Var.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		final CastExpression CastExpression_54_Var = (CastExpression)Expr_53_list.get(0);
		Assert.assertNotNull(CastExpression_54_Var);
		final UnaryExpression UnaryExpression_55_Var = (UnaryExpression)CastExpression_54_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_55_Var);
		final UnaryExpression UnaryExpression_56_Var = (UnaryExpression)UnaryExpression_55_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_56_Var);
		final PostfixExpression PostfixExpression_57_Var = (PostfixExpression)UnaryExpression_56_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_57_Var);
		final EList<? extends EObject> Expr_57_list = PostfixExpression_57_Var.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		final PrimaryExpression PrimaryExpression_58_Var = (PrimaryExpression)Expr_57_list.get(0);
		Assert.assertNotNull(PrimaryExpression_58_Var);
		Assert.assertEquals("num", PrimaryExpression_58_Var.getId());
		Assert.assertEquals("++", UnaryExpression_55_Var.getPlusplus());
		Assert.assertEquals(";", JumpStatement_40_Var.getSemi());
	}


}
