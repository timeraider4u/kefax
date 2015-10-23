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
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.StorageClassSpecifier;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
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
import at.jku.weiner.c.c.FunctionDefinition;
import at.jku.weiner.c.c.BodyStatement;
import at.jku.weiner.c.c.BlockList;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
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

@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0029_Assembler {

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
		final Path path = Paths.get("res/Test0029_Assembler.c");
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
	@Test
	public void checkLexerTokens()
	throws Exception{
		final String text = this.getSourceText();
		//System.out.println(text);
		final String[] expected = new String[] {
			"RULE_BLOCK_COMMENT",
			"RULE_NEWLINE",
			"RULE_KW_EXTERN",
			"RULE_WHITESPACE",
			"RULE_KW_INT",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_NEWLINE",
			"RULE_KW_INT",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_LEFTPAREN",
			"RULE_KW_INT",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_COMMA",
			"RULE_WHITESPACE",
			"RULE_KW_INT",
			"RULE_WHITESPACE",
			"RULE_STAR",
			"RULE_ID",
			"RULE_COMMA",
			"RULE_WHITESPACE",
			"RULE_KW_INT",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_RIGHTPAREN",
			"RULE_NEWLINE",
			"RULE_LEFTBRACE",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_KW_INT",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_KW_RETURN",
			"RULE_WHITESPACE",
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
		Assert.assertEquals(2, External_1_list.size());
		final ExternalDeclaration ExternalDeclaration_2_Var = (ExternalDeclaration)External_1_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_2_Var);
		final Declaration Declaration_3_Var = (Declaration)ExternalDeclaration_2_Var.getDeclaration();
		Assert.assertNotNull(Declaration_3_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_4_Var = (DeclarationSpecifiers)Declaration_3_Var.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_4_Var);
		final EList<? extends EObject> DeclarationSpecifier_4_list = DeclarationSpecifiers_4_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_4_list);
		Assert.assertEquals(2, DeclarationSpecifier_4_list.size());
		final StorageClassSpecifier StorageClassSpecifier_5_Var = (StorageClassSpecifier)DeclarationSpecifier_4_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_5_Var);
		Assert.assertEquals("extern", StorageClassSpecifier_5_Var.getName());
		final TypeSpecifier TypeSpecifier_6_Var = (TypeSpecifier)DeclarationSpecifier_4_list.get(1);
		Assert.assertNotNull(TypeSpecifier_6_Var);
		Assert.assertEquals("int", TypeSpecifier_6_Var.getName());
		final EList<? extends EObject> InitDeclaratorList_6_list = Declaration_3_Var.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_6_list);
		Assert.assertEquals(1, InitDeclaratorList_6_list.size());
		final InitDeclaratorList InitDeclaratorList_7_Var = (InitDeclaratorList)InitDeclaratorList_6_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_7_Var);
		final EList<? extends EObject> InitDeclarator_7_list = InitDeclaratorList_7_Var.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_7_list);
		Assert.assertEquals(1, InitDeclarator_7_list.size());
		final InitDeclarator InitDeclarator_8_Var = (InitDeclarator)InitDeclarator_7_list.get(0);
		Assert.assertNotNull(InitDeclarator_8_Var);
		final Declarator Declarator_9_Var = (Declarator)InitDeclarator_8_Var.getDeclarator();
		Assert.assertNotNull(Declarator_9_Var);
		final DirectDeclarator DirectDeclarator_10_Var = (DirectDeclarator)Declarator_9_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_10_Var);
		Assert.assertEquals("errno", DirectDeclarator_10_Var.getId());
		Assert.assertEquals(";", Declaration_3_Var.getSemi());
		final ExternalDeclaration ExternalDeclaration_11_Var = (ExternalDeclaration)External_1_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_11_Var);
		final FunctionDefHead FunctionDefHead_12_Var = (FunctionDefHead)ExternalDeclaration_11_Var.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_12_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_13_Var = (DeclarationSpecifiers)FunctionDefHead_12_Var.getFunDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_13_Var);
		final EList<? extends EObject> DeclarationSpecifier_13_list = DeclarationSpecifiers_13_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_13_list);
		Assert.assertEquals(1, DeclarationSpecifier_13_list.size());
		final TypeSpecifier TypeSpecifier_14_Var = (TypeSpecifier)DeclarationSpecifier_13_list.get(0);
		Assert.assertNotNull(TypeSpecifier_14_Var);
		Assert.assertEquals("int", TypeSpecifier_14_Var.getName());
		final Declarator Declarator_15_Var = (Declarator)FunctionDefHead_12_Var.getFunDeclarator();
		Assert.assertNotNull(Declarator_15_Var);
		final DirectDeclarator DirectDeclarator_16_Var = (DirectDeclarator)Declarator_15_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_16_Var);
		Assert.assertEquals("funcname", DirectDeclarator_16_Var.getId());
		final EList<? extends EObject> DeclaratorSuffix_16_list = DirectDeclarator_16_Var.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_16_list);
		Assert.assertEquals(1, DeclaratorSuffix_16_list.size());
		final DeclaratorSuffix DeclaratorSuffix_17_Var = (DeclaratorSuffix)DeclaratorSuffix_16_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_17_Var);
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_18_Var = (DirectDeclaratorLastSuffix)DeclaratorSuffix_17_Var.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_18_Var);
		final EList<? extends EObject> ParameterTypeList_18_list = DirectDeclaratorLastSuffix_18_Var.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_18_list);
		Assert.assertEquals(1, ParameterTypeList_18_list.size());
		final ParameterTypeList ParameterTypeList_19_Var = (ParameterTypeList)ParameterTypeList_18_list.get(0);
		Assert.assertNotNull(ParameterTypeList_19_Var);
		final ParameterList ParameterList_20_Var = (ParameterList)ParameterTypeList_19_Var.getList();
		Assert.assertNotNull(ParameterList_20_Var);
		final EList<? extends EObject> ParameterDeclaration_20_list = ParameterList_20_Var.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_20_list);
		Assert.assertEquals(3, ParameterDeclaration_20_list.size());
		final ParameterDeclaration ParameterDeclaration_21_Var = (ParameterDeclaration)ParameterDeclaration_20_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_21_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_22_Var = (DeclarationSpecifiers)ParameterDeclaration_21_Var.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_22_Var);
		final EList<? extends EObject> DeclarationSpecifier_22_list = DeclarationSpecifiers_22_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_22_list);
		Assert.assertEquals(1, DeclarationSpecifier_22_list.size());
		final TypeSpecifier TypeSpecifier_23_Var = (TypeSpecifier)DeclarationSpecifier_22_list.get(0);
		Assert.assertNotNull(TypeSpecifier_23_Var);
		Assert.assertEquals("int", TypeSpecifier_23_Var.getName());
		final Declarator Declarator_24_Var = (Declarator)ParameterDeclaration_21_Var.getDeclarator();
		Assert.assertNotNull(Declarator_24_Var);
		final DirectDeclarator DirectDeclarator_25_Var = (DirectDeclarator)Declarator_24_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_25_Var);
		Assert.assertEquals("arg1", DirectDeclarator_25_Var.getId());
		final ParameterDeclaration ParameterDeclaration_26_Var = (ParameterDeclaration)ParameterDeclaration_20_list.get(1);
		Assert.assertNotNull(ParameterDeclaration_26_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_27_Var = (DeclarationSpecifiers)ParameterDeclaration_26_Var.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_27_Var);
		final EList<? extends EObject> DeclarationSpecifier_27_list = DeclarationSpecifiers_27_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_27_list);
		Assert.assertEquals(1, DeclarationSpecifier_27_list.size());
		final TypeSpecifier TypeSpecifier_28_Var = (TypeSpecifier)DeclarationSpecifier_27_list.get(0);
		Assert.assertNotNull(TypeSpecifier_28_Var);
		Assert.assertEquals("int", TypeSpecifier_28_Var.getName());
		final Declarator Declarator_29_Var = (Declarator)ParameterDeclaration_26_Var.getDeclarator();
		Assert.assertNotNull(Declarator_29_Var);
		final DirectDeclarator DirectDeclarator_30_Var = (DirectDeclarator)Declarator_29_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_30_Var);
		Assert.assertEquals("arg2", DirectDeclarator_30_Var.getId());
		final Pointer Pointer_31_Var = (Pointer)Declarator_29_Var.getPointer();
		Assert.assertNotNull(Pointer_31_Var);
		Assert.assertEquals("[*]", Pointer_31_Var.getStar().toString());
		final ParameterDeclaration ParameterDeclaration_32_Var = (ParameterDeclaration)ParameterDeclaration_20_list.get(2);
		Assert.assertNotNull(ParameterDeclaration_32_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_33_Var = (DeclarationSpecifiers)ParameterDeclaration_32_Var.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_33_Var);
		final EList<? extends EObject> DeclarationSpecifier_33_list = DeclarationSpecifiers_33_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_33_list);
		Assert.assertEquals(1, DeclarationSpecifier_33_list.size());
		final TypeSpecifier TypeSpecifier_34_Var = (TypeSpecifier)DeclarationSpecifier_33_list.get(0);
		Assert.assertNotNull(TypeSpecifier_34_Var);
		Assert.assertEquals("int", TypeSpecifier_34_Var.getName());
		final Declarator Declarator_35_Var = (Declarator)ParameterDeclaration_32_Var.getDeclarator();
		Assert.assertNotNull(Declarator_35_Var);
		final DirectDeclarator DirectDeclarator_36_Var = (DirectDeclarator)Declarator_35_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_36_Var);
		Assert.assertEquals("arg3", DirectDeclarator_36_Var.getId());
		final FunctionDefinition FunctionDefinition_37_Var = (FunctionDefinition)ExternalDeclaration_11_Var.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_37_Var);
		final BodyStatement BodyStatement_38_Var = (BodyStatement)FunctionDefinition_37_Var.getBody();
		Assert.assertNotNull(BodyStatement_38_Var);
		final EList<? extends EObject> BlockList_38_list = BodyStatement_38_Var.getBlockList();
		Assert.assertNotNull(BlockList_38_list);
		Assert.assertEquals(1, BlockList_38_list.size());
		final BlockList BlockList_39_Var = (BlockList)BlockList_38_list.get(0);
		Assert.assertNotNull(BlockList_39_Var);
		final EList<? extends EObject> Declaration_39_list = BlockList_39_Var.getDeclaration();
		Assert.assertNotNull(Declaration_39_list);
		Assert.assertEquals(1, Declaration_39_list.size());
		final Declaration Declaration_40_Var = (Declaration)Declaration_39_list.get(0);
		Assert.assertNotNull(Declaration_40_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_41_Var = (DeclarationSpecifiers)Declaration_40_Var.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_41_Var);
		final EList<? extends EObject> DeclarationSpecifier_41_list = DeclarationSpecifiers_41_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_41_list);
		Assert.assertEquals(1, DeclarationSpecifier_41_list.size());
		final TypeSpecifier TypeSpecifier_42_Var = (TypeSpecifier)DeclarationSpecifier_41_list.get(0);
		Assert.assertNotNull(TypeSpecifier_42_Var);
		Assert.assertEquals("int", TypeSpecifier_42_Var.getName());
		final EList<? extends EObject> InitDeclaratorList_42_list = Declaration_40_Var.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_42_list);
		Assert.assertEquals(1, InitDeclaratorList_42_list.size());
		final InitDeclaratorList InitDeclaratorList_43_Var = (InitDeclaratorList)InitDeclaratorList_42_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_43_Var);
		final EList<? extends EObject> InitDeclarator_43_list = InitDeclaratorList_43_Var.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_43_list);
		Assert.assertEquals(1, InitDeclarator_43_list.size());
		final InitDeclarator InitDeclarator_44_Var = (InitDeclarator)InitDeclarator_43_list.get(0);
		Assert.assertNotNull(InitDeclarator_44_Var);
		final Declarator Declarator_45_Var = (Declarator)InitDeclarator_44_Var.getDeclarator();
		Assert.assertNotNull(Declarator_45_Var);
		final DirectDeclarator DirectDeclarator_46_Var = (DirectDeclarator)Declarator_45_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_46_Var);
		Assert.assertEquals("res", DirectDeclarator_46_Var.getId());
		Assert.assertEquals(";", Declaration_40_Var.getSemi());
		final EList<? extends EObject> Statement_46_list = BlockList_39_Var.getStatement();
		Assert.assertNotNull(Statement_46_list);
		Assert.assertEquals(1, Statement_46_list.size());
		final Statement Statement_47_Var = (Statement)Statement_46_list.get(0);
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
		Assert.assertEquals("res", PrimaryExpression_65_Var.getId());
		Assert.assertEquals("return", JumpStatement_48_Var.getReturn());
		Assert.assertEquals(";", JumpStatement_48_Var.getSemi());
	}


}
