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
import at.jku.weiner.c.c.Pointer;
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.Pointer;
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
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
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.AssignmentOperator;
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
public class Test0018_PointerInFunctionDef {

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
		final Path path = Paths.get("res/Test0018_PointerInFunctionDef.c");
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
			"RULE_COMMA",
			"RULE_WHITESPACE",
			"RULE_KW_CHAR",
			"RULE_WHITESPACE",
			"RULE_STAR",
			"RULE_STAR",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_COMMA",
			"RULE_WHITESPACE",
			"RULE_KW_FLOAT",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_COMMA",
			"RULE_WHITESPACE",
			"RULE_KW_INT",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_RIGHTPAREN",
			"RULE_WHITESPACE",
			"RULE_LEFTBRACE",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_LINE_COMMENT",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_WHITESPACE",
			"RULE_ASSIGN",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_LEFTBRACKET",
			"RULE_ID",
			"RULE_RIGHTBRACKET",
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
		Assert.assertEquals("voids", TypeSpecifier_5_Var.getName());
		final Declarator Declarator_6_Var = (Declarator)FunctionDefHead_3_Var.getFunDeclarator();
		Assert.assertNotNull(Declarator_6_Var);
		final DirectDeclarator DirectDeclarator_7_Var = (DirectDeclarator)Declarator_6_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_7_Var);
		Assert.assertEquals("do12", DirectDeclarator_7_Var.getId());
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
		Assert.assertEquals(4, ParameterDeclaration_11_list.size());
		final ParameterDeclaration ParameterDeclaration_12_Var = (ParameterDeclaration)ParameterDeclaration_11_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_12_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_13_Var = (DeclarationSpecifiers)ParameterDeclaration_12_Var.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_13_Var);
		final EList<? extends EObject> DeclarationSpecifier_13_list = DeclarationSpecifiers_13_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_13_list);
		Assert.assertEquals(1, DeclarationSpecifier_13_list.size());
		final TypeSpecifier TypeSpecifier_14_Var = (TypeSpecifier)DeclarationSpecifier_13_list.get(0);
		Assert.assertNotNull(TypeSpecifier_14_Var);
		Assert.assertEquals("intInt", TypeSpecifier_14_Var.getName());
		final Declarator Declarator_15_Var = (Declarator)ParameterDeclaration_12_Var.getDeclarator();
		Assert.assertNotNull(Declarator_15_Var);
		final DirectDeclarator DirectDeclarator_16_Var = (DirectDeclarator)Declarator_15_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_16_Var);
		Assert.assertEquals("argC", DirectDeclarator_16_Var.getId());
		final Pointer Pointer_17_Var = (Pointer)Declarator_15_Var.getPointer();
		Assert.assertNotNull(Pointer_17_Var);
		Assert.assertEquals("[*^]", Pointer_17_Var.getStar().toString());
		final ParameterDeclaration ParameterDeclaration_18_Var = (ParameterDeclaration)ParameterDeclaration_11_list.get(1);
		Assert.assertNotNull(ParameterDeclaration_18_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_19_Var = (DeclarationSpecifiers)ParameterDeclaration_18_Var.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_19_Var);
		final EList<? extends EObject> DeclarationSpecifier_19_list = DeclarationSpecifiers_19_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_19_list);
		Assert.assertEquals(1, DeclarationSpecifier_19_list.size());
		final TypeSpecifier TypeSpecifier_20_Var = (TypeSpecifier)DeclarationSpecifier_19_list.get(0);
		Assert.assertNotNull(TypeSpecifier_20_Var);
		Assert.assertEquals("charChar", TypeSpecifier_20_Var.getName());
		final Declarator Declarator_21_Var = (Declarator)ParameterDeclaration_18_Var.getDeclarator();
		Assert.assertNotNull(Declarator_21_Var);
		final DirectDeclarator DirectDeclarator_22_Var = (DirectDeclarator)Declarator_21_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_22_Var);
		Assert.assertEquals("argV", DirectDeclarator_22_Var.getId());
		final Pointer Pointer_23_Var = (Pointer)Declarator_21_Var.getPointer();
		Assert.assertNotNull(Pointer_23_Var);
		Assert.assertEquals("[*,^ *]", Pointer_23_Var.getStar().toString());
		final ParameterDeclaration ParameterDeclaration_24_Var = (ParameterDeclaration)ParameterDeclaration_11_list.get(2);
		Assert.assertNotNull(ParameterDeclaration_24_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_25_Var = (DeclarationSpecifiers)ParameterDeclaration_24_Var.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_25_Var);
		final EList<? extends EObject> DeclarationSpecifier_25_list = DeclarationSpecifiers_25_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_25_list);
		Assert.assertEquals(1, DeclarationSpecifier_25_list.size());
		final TypeSpecifier TypeSpecifier_26_Var = (TypeSpecifier)DeclarationSpecifier_25_list.get(0);
		Assert.assertNotNull(TypeSpecifier_26_Var);
		Assert.assertEquals("floatFloat", TypeSpecifier_26_Var.getName());
		final Declarator Declarator_27_Var = (Declarator)ParameterDeclaration_24_Var.getDeclarator();
		Assert.assertNotNull(Declarator_27_Var);
		final DirectDeclarator DirectDeclarator_28_Var = (DirectDeclarator)Declarator_27_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_28_Var);
		Assert.assertEquals("F", DirectDeclarator_28_Var.getId());
		final ParameterDeclaration ParameterDeclaration_29_Var = (ParameterDeclaration)ParameterDeclaration_11_list.get(3);
		Assert.assertNotNull(ParameterDeclaration_29_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_30_Var = (DeclarationSpecifiers)ParameterDeclaration_29_Var.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_30_Var);
		final EList<? extends EObject> DeclarationSpecifier_30_list = DeclarationSpecifiers_30_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_30_list);
		Assert.assertEquals(1, DeclarationSpecifier_30_list.size());
		final TypeSpecifier TypeSpecifier_31_Var = (TypeSpecifier)DeclarationSpecifier_30_list.get(0);
		Assert.assertNotNull(TypeSpecifier_31_Var);
		Assert.assertEquals("intInt", TypeSpecifier_31_Var.getName());
		final Declarator Declarator_32_Var = (Declarator)ParameterDeclaration_29_Var.getDeclarator();
		Assert.assertNotNull(Declarator_32_Var);
		final DirectDeclarator DirectDeclarator_33_Var = (DirectDeclarator)Declarator_32_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_33_Var);
		Assert.assertEquals("I", DirectDeclarator_33_Var.getId());
		final FunctionDefinition FunctionDefinition_34_Var = (FunctionDefinition)ExternalDeclaration_2_Var.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_34_Var);
		final BodyStatement BodyStatement_35_Var = (BodyStatement)FunctionDefinition_34_Var.getBody();
		Assert.assertNotNull(BodyStatement_35_Var);
		final EList<? extends EObject> BlockList_35_list = BodyStatement_35_Var.getBlockList();
		Assert.assertNotNull(BlockList_35_list);
		Assert.assertEquals(1, BlockList_35_list.size());
		final BlockList BlockList_36_Var = (BlockList)BlockList_35_list.get(0);
		Assert.assertNotNull(BlockList_36_Var);
		final EList<? extends EObject> Statement_36_list = BlockList_36_Var.getStatement();
		Assert.assertNotNull(Statement_36_list);
		Assert.assertEquals(1, Statement_36_list.size());
		final Statement Statement_37_Var = (Statement)Statement_36_list.get(0);
		Assert.assertNotNull(Statement_37_Var);
		final ExpressionStatement ExpressionStatement_38_Var = (ExpressionStatement)Statement_37_Var.getStmt();
		Assert.assertNotNull(ExpressionStatement_38_Var);
		final Expression Expression_39_Var = (Expression)ExpressionStatement_38_Var.getExpression();
		Assert.assertNotNull(Expression_39_Var);
		final EList<? extends EObject> ExprExpr_39_list = Expression_39_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_39_list);
		Assert.assertEquals(1, ExprExpr_39_list.size());
		final AssignmentExpression AssignmentExpression_40_Var = (AssignmentExpression)ExprExpr_39_list.get(0);
		Assert.assertNotNull(AssignmentExpression_40_Var);
		final UnaryExpression UnaryExpression_41_Var = (UnaryExpression)AssignmentExpression_40_Var.getExpr();
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
		Assert.assertEquals("1", Constant_44_Var.getDec());
		final EList<? extends EObject> ArrayExpr_44_list = PostfixExpression_42_Var.getArrayExpr();
		Assert.assertNotNull(ArrayExpr_44_list);
		Assert.assertEquals(1, ArrayExpr_44_list.size());
		final Expression Expression_45_Var = (Expression)ArrayExpr_44_list.get(0);
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
		final EList<? extends EObject> Expr_54_list = RelationalExpression_54_Var.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
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
		final Constant Constant_62_Var = (Constant)PrimaryExpression_61_Var.getConst();
		Assert.assertNotNull(Constant_62_Var);
		Assert.assertEquals("2", Constant_62_Var.getDec());
		final AssignmentOperator AssignmentOperator_63_Var = (AssignmentOperator)AssignmentExpression_40_Var.getOp();
		Assert.assertNotNull(AssignmentOperator_63_Var);
		Assert.assertEquals("*=", AssignmentOperator_63_Var.getOp());
		final AssignmentExpression AssignmentExpression_64_Var = (AssignmentExpression)AssignmentExpression_40_Var.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_64_Var);
		final ConditionalExpression ConditionalExpression_65_Var = (ConditionalExpression)AssignmentExpression_64_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_65_Var);
		final LogicalOrExpression LogicalOrExpression_66_Var = (LogicalOrExpression)ConditionalExpression_65_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_66_Var);
		final EList<? extends EObject> Expr_66_list = LogicalOrExpression_66_Var.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		final LogicalAndExpression LogicalAndExpression_67_Var = (LogicalAndExpression)Expr_66_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_67_Var);
		final EList<? extends EObject> Expr_67_list = LogicalAndExpression_67_Var.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		final InclusiveOrExpression InclusiveOrExpression_68_Var = (InclusiveOrExpression)Expr_67_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_68_Var);
		final EList<? extends EObject> Expr_68_list = InclusiveOrExpression_68_Var.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_69_Var = (ExclusiveOrExpression)Expr_68_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_69_Var);
		final EList<? extends EObject> Expr_69_list = ExclusiveOrExpression_69_Var.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		final AndExpression AndExpression_70_Var = (AndExpression)Expr_69_list.get(0);
		Assert.assertNotNull(AndExpression_70_Var);
		final EList<? extends EObject> Expr_70_list = AndExpression_70_Var.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		final EqualityExpression EqualityExpression_71_Var = (EqualityExpression)Expr_70_list.get(0);
		Assert.assertNotNull(EqualityExpression_71_Var);
		final EList<? extends EObject> Expr_71_list = EqualityExpression_71_Var.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		final RelationalExpression RelationalExpression_72_Var = (RelationalExpression)Expr_71_list.get(0);
		Assert.assertNotNull(RelationalExpression_72_Var);
		final EList<? extends EObject> Expr_72_list = RelationalExpression_72_Var.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		final ShiftExpression ShiftExpression_73_Var = (ShiftExpression)Expr_72_list.get(0);
		Assert.assertNotNull(ShiftExpression_73_Var);
		final EList<? extends EObject> Expr_73_list = ShiftExpression_73_Var.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		final AdditiveExpression AdditiveExpression_74_Var = (AdditiveExpression)Expr_73_list.get(0);
		Assert.assertNotNull(AdditiveExpression_74_Var);
		final EList<? extends EObject> Expr_74_list = AdditiveExpression_74_Var.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(2, Expr_74_list.size());
		final MultiplicativeExpression MultiplicativeExpression_75_Var = (MultiplicativeExpression)Expr_74_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_75_Var);
		final EList<? extends EObject> Expr_75_list = MultiplicativeExpression_75_Var.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		final CastExpression CastExpression_76_Var = (CastExpression)Expr_75_list.get(0);
		Assert.assertNotNull(CastExpression_76_Var);
		final UnaryExpression UnaryExpression_77_Var = (UnaryExpression)CastExpression_76_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_77_Var);
		final PostfixExpression PostfixExpression_78_Var = (PostfixExpression)UnaryExpression_77_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_78_Var);
		final EList<? extends EObject> Expr_78_list = PostfixExpression_78_Var.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		final PrimaryExpression PrimaryExpression_79_Var = (PrimaryExpression)Expr_78_list.get(0);
		Assert.assertNotNull(PrimaryExpression_79_Var);
		final Constant Constant_80_Var = (Constant)PrimaryExpression_79_Var.getConst();
		Assert.assertNotNull(Constant_80_Var);
		Assert.assertEquals("1", Constant_80_Var.getDec());
		final EList<? extends EObject> ArrayExpr_80_list = PostfixExpression_78_Var.getArrayExpr();
		Assert.assertNotNull(ArrayExpr_80_list);
		Assert.assertEquals(1, ArrayExpr_80_list.size());
		final Expression Expression_81_Var = (Expression)ArrayExpr_80_list.get(0);
		Assert.assertNotNull(Expression_81_Var);
		final EList<? extends EObject> ExprExpr_81_list = Expression_81_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_81_list);
		Assert.assertEquals(1, ExprExpr_81_list.size());
		final AssignmentExpression AssignmentExpression_82_Var = (AssignmentExpression)ExprExpr_81_list.get(0);
		Assert.assertNotNull(AssignmentExpression_82_Var);
		final ConditionalExpression ConditionalExpression_83_Var = (ConditionalExpression)AssignmentExpression_82_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_83_Var);
		final LogicalOrExpression LogicalOrExpression_84_Var = (LogicalOrExpression)ConditionalExpression_83_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_84_Var);
		final EList<? extends EObject> Expr_84_list = LogicalOrExpression_84_Var.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		final LogicalAndExpression LogicalAndExpression_85_Var = (LogicalAndExpression)Expr_84_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_85_Var);
		final EList<? extends EObject> Expr_85_list = LogicalAndExpression_85_Var.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		final InclusiveOrExpression InclusiveOrExpression_86_Var = (InclusiveOrExpression)Expr_85_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_86_Var);
		final EList<? extends EObject> Expr_86_list = InclusiveOrExpression_86_Var.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_87_Var = (ExclusiveOrExpression)Expr_86_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_87_Var);
		final EList<? extends EObject> Expr_87_list = ExclusiveOrExpression_87_Var.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		final AndExpression AndExpression_88_Var = (AndExpression)Expr_87_list.get(0);
		Assert.assertNotNull(AndExpression_88_Var);
		final EList<? extends EObject> Expr_88_list = AndExpression_88_Var.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		final EqualityExpression EqualityExpression_89_Var = (EqualityExpression)Expr_88_list.get(0);
		Assert.assertNotNull(EqualityExpression_89_Var);
		final EList<? extends EObject> Expr_89_list = EqualityExpression_89_Var.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		final RelationalExpression RelationalExpression_90_Var = (RelationalExpression)Expr_89_list.get(0);
		Assert.assertNotNull(RelationalExpression_90_Var);
		final EList<? extends EObject> Expr_90_list = RelationalExpression_90_Var.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		final ShiftExpression ShiftExpression_91_Var = (ShiftExpression)Expr_90_list.get(0);
		Assert.assertNotNull(ShiftExpression_91_Var);
		final EList<? extends EObject> Expr_91_list = ShiftExpression_91_Var.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		final AdditiveExpression AdditiveExpression_92_Var = (AdditiveExpression)Expr_91_list.get(0);
		Assert.assertNotNull(AdditiveExpression_92_Var);
		final EList<? extends EObject> Expr_92_list = AdditiveExpression_92_Var.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		final MultiplicativeExpression MultiplicativeExpression_93_Var = (MultiplicativeExpression)Expr_92_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_93_Var);
		final EList<? extends EObject> Expr_93_list = MultiplicativeExpression_93_Var.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		final CastExpression CastExpression_94_Var = (CastExpression)Expr_93_list.get(0);
		Assert.assertNotNull(CastExpression_94_Var);
		final UnaryExpression UnaryExpression_95_Var = (UnaryExpression)CastExpression_94_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_95_Var);
		final PostfixExpression PostfixExpression_96_Var = (PostfixExpression)UnaryExpression_95_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_96_Var);
		final EList<? extends EObject> Expr_96_list = PostfixExpression_96_Var.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		final PrimaryExpression PrimaryExpression_97_Var = (PrimaryExpression)Expr_96_list.get(0);
		Assert.assertNotNull(PrimaryExpression_97_Var);
		final Constant Constant_98_Var = (Constant)PrimaryExpression_97_Var.getConst();
		Assert.assertNotNull(Constant_98_Var);
		Assert.assertEquals("2", Constant_98_Var.getDec());
		final MultiplicativeExpression MultiplicativeExpression_99_Var = (MultiplicativeExpression)Expr_74_list.get(1);
		Assert.assertNotNull(MultiplicativeExpression_99_Var);
		final EList<? extends EObject> Expr_99_list = MultiplicativeExpression_99_Var.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		final CastExpression CastExpression_100_Var = (CastExpression)Expr_99_list.get(0);
		Assert.assertNotNull(CastExpression_100_Var);
		final UnaryExpression UnaryExpression_101_Var = (UnaryExpression)CastExpression_100_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_101_Var);
		final PostfixExpression PostfixExpression_102_Var = (PostfixExpression)UnaryExpression_101_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_102_Var);
		final EList<? extends EObject> Expr_102_list = PostfixExpression_102_Var.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		final PrimaryExpression PrimaryExpression_103_Var = (PrimaryExpression)Expr_102_list.get(0);
		Assert.assertNotNull(PrimaryExpression_103_Var);
		final Constant Constant_104_Var = (Constant)PrimaryExpression_103_Var.getConst();
		Assert.assertNotNull(Constant_104_Var);
		Assert.assertEquals("2", Constant_104_Var.getDec());
		Assert.assertEquals("[-]", AdditiveExpression_74_Var.getOp().toString());
		Assert.assertEquals(";", ExternalDeclaration_2_Var.getSemi());
	}


}
