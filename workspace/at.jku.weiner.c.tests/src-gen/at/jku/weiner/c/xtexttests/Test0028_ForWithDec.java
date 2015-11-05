package at.jku.weiner.c.xtexttests;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.antlr.runtime.Token;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
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
import at.jku.weiner.c.c.IterationStatement;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.Initializer;
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
import at.jku.weiner.c.c.JumpStatement;

@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0028_ForWithDec {

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
	
	@Inject
	private IGenerator generator;
	@Inject
	private Provider<ResourceSet> resourceSetProvider;
	@Inject
	private IResourceValidator validator;
	@Inject
	private JavaIoFileSystemAccess fileAccessSystem;
	
	@Before
	public void initialize(){
		this.testHelper = new LexerAndParserTest(lexer, parser, tokenDefProvider);
	}
	
	private String getTextFromFile(final String fileName)
	throws Exception{
		final Path path = Paths.get(fileName);
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
	@Test
	public void checkLexerTokens()
	throws Exception{
		final String text = this.getTextFromFile("res/Test0028_ForWithDec.c");
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
			"RULE_KW_INT",
			"RULE_WHITESPACE",
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
			"RULE_KW_CONTINUE",
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

		final String text = this.getTextFromFile("res/Test0028_ForWithDec.c");
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
		final Declaration Declaration_22_Var = (Declaration)IterationStatement_21_Var.getInitDecl();
		Assert.assertNotNull(Declaration_22_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_23_Var = (DeclarationSpecifiers)Declaration_22_Var.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_23_Var);
		final EList<? extends EObject> DeclarationSpecifier_23_list = DeclarationSpecifiers_23_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_23_list);
		Assert.assertEquals(1, DeclarationSpecifier_23_list.size());
		final TypeSpecifier TypeSpecifier_24_Var = (TypeSpecifier)DeclarationSpecifier_23_list.get(0);
		Assert.assertNotNull(TypeSpecifier_24_Var);
		Assert.assertEquals("int", TypeSpecifier_24_Var.getName());
		final EList<? extends EObject> InitDeclaratorList_24_list = Declaration_22_Var.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_24_list);
		Assert.assertEquals(1, InitDeclaratorList_24_list.size());
		final InitDeclaratorList InitDeclaratorList_25_Var = (InitDeclaratorList)InitDeclaratorList_24_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_25_Var);
		final EList<? extends EObject> InitDeclarator_25_list = InitDeclaratorList_25_Var.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_25_list);
		Assert.assertEquals(1, InitDeclarator_25_list.size());
		final InitDeclarator InitDeclarator_26_Var = (InitDeclarator)InitDeclarator_25_list.get(0);
		Assert.assertNotNull(InitDeclarator_26_Var);
		final Declarator Declarator_27_Var = (Declarator)InitDeclarator_26_Var.getDeclarator();
		Assert.assertNotNull(Declarator_27_Var);
		final DirectDeclarator DirectDeclarator_28_Var = (DirectDeclarator)Declarator_27_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_28_Var);
		Assert.assertEquals("i", DirectDeclarator_28_Var.getId());
		final Initializer Initializer_29_Var = (Initializer)InitDeclarator_26_Var.getInitializer();
		Assert.assertNotNull(Initializer_29_Var);
		final AssignmentExpression AssignmentExpression_30_Var = (AssignmentExpression)Initializer_29_Var.getExpr();
		Assert.assertNotNull(AssignmentExpression_30_Var);
		final ConditionalExpression ConditionalExpression_31_Var = (ConditionalExpression)AssignmentExpression_30_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_31_Var);
		final LogicalOrExpression LogicalOrExpression_32_Var = (LogicalOrExpression)ConditionalExpression_31_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_32_Var);
		final EList<? extends EObject> Expr_32_list = LogicalOrExpression_32_Var.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		final LogicalAndExpression LogicalAndExpression_33_Var = (LogicalAndExpression)Expr_32_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_33_Var);
		final EList<? extends EObject> Expr_33_list = LogicalAndExpression_33_Var.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		final InclusiveOrExpression InclusiveOrExpression_34_Var = (InclusiveOrExpression)Expr_33_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_34_Var);
		final EList<? extends EObject> Expr_34_list = InclusiveOrExpression_34_Var.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_35_Var = (ExclusiveOrExpression)Expr_34_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_35_Var);
		final EList<? extends EObject> Expr_35_list = ExclusiveOrExpression_35_Var.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		final AndExpression AndExpression_36_Var = (AndExpression)Expr_35_list.get(0);
		Assert.assertNotNull(AndExpression_36_Var);
		final EList<? extends EObject> Expr_36_list = AndExpression_36_Var.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		final EqualityExpression EqualityExpression_37_Var = (EqualityExpression)Expr_36_list.get(0);
		Assert.assertNotNull(EqualityExpression_37_Var);
		final EList<? extends EObject> Expr_37_list = EqualityExpression_37_Var.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		final RelationalExpression RelationalExpression_38_Var = (RelationalExpression)Expr_37_list.get(0);
		Assert.assertNotNull(RelationalExpression_38_Var);
		final EList<? extends EObject> Expr_38_list = RelationalExpression_38_Var.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		final ShiftExpression ShiftExpression_39_Var = (ShiftExpression)Expr_38_list.get(0);
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
		Assert.assertEquals(";", Declaration_22_Var.getSemi());
		final Expression Expression_47_Var = (Expression)IterationStatement_21_Var.getExpr();
		Assert.assertNotNull(Expression_47_Var);
		final EList<? extends EObject> ExprExpr_47_list = Expression_47_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_47_list);
		Assert.assertEquals(1, ExprExpr_47_list.size());
		final AssignmentExpression AssignmentExpression_48_Var = (AssignmentExpression)ExprExpr_47_list.get(0);
		Assert.assertNotNull(AssignmentExpression_48_Var);
		final ConditionalExpression ConditionalExpression_49_Var = (ConditionalExpression)AssignmentExpression_48_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_49_Var);
		final LogicalOrExpression LogicalOrExpression_50_Var = (LogicalOrExpression)ConditionalExpression_49_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_50_Var);
		final EList<? extends EObject> Expr_50_list = LogicalOrExpression_50_Var.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		final LogicalAndExpression LogicalAndExpression_51_Var = (LogicalAndExpression)Expr_50_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_51_Var);
		final EList<? extends EObject> Expr_51_list = LogicalAndExpression_51_Var.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		final InclusiveOrExpression InclusiveOrExpression_52_Var = (InclusiveOrExpression)Expr_51_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_52_Var);
		final EList<? extends EObject> Expr_52_list = InclusiveOrExpression_52_Var.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_53_Var = (ExclusiveOrExpression)Expr_52_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_53_Var);
		final EList<? extends EObject> Expr_53_list = ExclusiveOrExpression_53_Var.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		final AndExpression AndExpression_54_Var = (AndExpression)Expr_53_list.get(0);
		Assert.assertNotNull(AndExpression_54_Var);
		final EList<? extends EObject> Expr_54_list = AndExpression_54_Var.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		final EqualityExpression EqualityExpression_55_Var = (EqualityExpression)Expr_54_list.get(0);
		Assert.assertNotNull(EqualityExpression_55_Var);
		final EList<? extends EObject> Expr_55_list = EqualityExpression_55_Var.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		final RelationalExpression RelationalExpression_56_Var = (RelationalExpression)Expr_55_list.get(0);
		Assert.assertNotNull(RelationalExpression_56_Var);
		Assert.assertEquals("[<]", RelationalExpression_56_Var.getOp().toString());
		final EList<? extends EObject> Expr_56_list = RelationalExpression_56_Var.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(2, Expr_56_list.size());
		final ShiftExpression ShiftExpression_57_Var = (ShiftExpression)Expr_56_list.get(0);
		Assert.assertNotNull(ShiftExpression_57_Var);
		final EList<? extends EObject> Expr_57_list = ShiftExpression_57_Var.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		final AdditiveExpression AdditiveExpression_58_Var = (AdditiveExpression)Expr_57_list.get(0);
		Assert.assertNotNull(AdditiveExpression_58_Var);
		final EList<? extends EObject> Expr_58_list = AdditiveExpression_58_Var.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		final MultiplicativeExpression MultiplicativeExpression_59_Var = (MultiplicativeExpression)Expr_58_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_59_Var);
		final EList<? extends EObject> Expr_59_list = MultiplicativeExpression_59_Var.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		final CastExpression CastExpression_60_Var = (CastExpression)Expr_59_list.get(0);
		Assert.assertNotNull(CastExpression_60_Var);
		final UnaryExpression UnaryExpression_61_Var = (UnaryExpression)CastExpression_60_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_61_Var);
		final PostfixExpression PostfixExpression_62_Var = (PostfixExpression)UnaryExpression_61_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_62_Var);
		final EList<? extends EObject> Expr_62_list = PostfixExpression_62_Var.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		final PrimaryExpression PrimaryExpression_63_Var = (PrimaryExpression)Expr_62_list.get(0);
		Assert.assertNotNull(PrimaryExpression_63_Var);
		Assert.assertEquals("i", PrimaryExpression_63_Var.getId());
		final ShiftExpression ShiftExpression_64_Var = (ShiftExpression)Expr_56_list.get(1);
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
		final Constant Constant_71_Var = (Constant)PrimaryExpression_70_Var.getConst();
		Assert.assertNotNull(Constant_71_Var);
		Assert.assertEquals("5", Constant_71_Var.getDec());
		final Expression Expression_72_Var = (Expression)IterationStatement_21_Var.getIncExpr();
		Assert.assertNotNull(Expression_72_Var);
		final EList<? extends EObject> ExprExpr_72_list = Expression_72_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_72_list);
		Assert.assertEquals(1, ExprExpr_72_list.size());
		final AssignmentExpression AssignmentExpression_73_Var = (AssignmentExpression)ExprExpr_72_list.get(0);
		Assert.assertNotNull(AssignmentExpression_73_Var);
		final ConditionalExpression ConditionalExpression_74_Var = (ConditionalExpression)AssignmentExpression_73_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_74_Var);
		final LogicalOrExpression LogicalOrExpression_75_Var = (LogicalOrExpression)ConditionalExpression_74_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_75_Var);
		final EList<? extends EObject> Expr_75_list = LogicalOrExpression_75_Var.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		final LogicalAndExpression LogicalAndExpression_76_Var = (LogicalAndExpression)Expr_75_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_76_Var);
		final EList<? extends EObject> Expr_76_list = LogicalAndExpression_76_Var.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		final InclusiveOrExpression InclusiveOrExpression_77_Var = (InclusiveOrExpression)Expr_76_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_77_Var);
		final EList<? extends EObject> Expr_77_list = InclusiveOrExpression_77_Var.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_78_Var = (ExclusiveOrExpression)Expr_77_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_78_Var);
		final EList<? extends EObject> Expr_78_list = ExclusiveOrExpression_78_Var.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		final AndExpression AndExpression_79_Var = (AndExpression)Expr_78_list.get(0);
		Assert.assertNotNull(AndExpression_79_Var);
		final EList<? extends EObject> Expr_79_list = AndExpression_79_Var.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		final EqualityExpression EqualityExpression_80_Var = (EqualityExpression)Expr_79_list.get(0);
		Assert.assertNotNull(EqualityExpression_80_Var);
		final EList<? extends EObject> Expr_80_list = EqualityExpression_80_Var.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		final RelationalExpression RelationalExpression_81_Var = (RelationalExpression)Expr_80_list.get(0);
		Assert.assertNotNull(RelationalExpression_81_Var);
		final EList<? extends EObject> Expr_81_list = RelationalExpression_81_Var.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		final ShiftExpression ShiftExpression_82_Var = (ShiftExpression)Expr_81_list.get(0);
		Assert.assertNotNull(ShiftExpression_82_Var);
		final EList<? extends EObject> Expr_82_list = ShiftExpression_82_Var.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		final AdditiveExpression AdditiveExpression_83_Var = (AdditiveExpression)Expr_82_list.get(0);
		Assert.assertNotNull(AdditiveExpression_83_Var);
		final EList<? extends EObject> Expr_83_list = AdditiveExpression_83_Var.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		final MultiplicativeExpression MultiplicativeExpression_84_Var = (MultiplicativeExpression)Expr_83_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_84_Var);
		final EList<? extends EObject> Expr_84_list = MultiplicativeExpression_84_Var.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		final CastExpression CastExpression_85_Var = (CastExpression)Expr_84_list.get(0);
		Assert.assertNotNull(CastExpression_85_Var);
		final UnaryExpression UnaryExpression_86_Var = (UnaryExpression)CastExpression_85_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_86_Var);
		final PostfixExpression PostfixExpression_87_Var = (PostfixExpression)UnaryExpression_86_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_87_Var);
		final EList<? extends EObject> Expr_87_list = PostfixExpression_87_Var.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		final PrimaryExpression PrimaryExpression_88_Var = (PrimaryExpression)Expr_87_list.get(0);
		Assert.assertNotNull(PrimaryExpression_88_Var);
		Assert.assertEquals("i", PrimaryExpression_88_Var.getId());
		Assert.assertEquals("[++]", PostfixExpression_87_Var.getPlusplus().toString());
		final Statement Statement_89_Var = (Statement)IterationStatement_21_Var.getStatement();
		Assert.assertNotNull(Statement_89_Var);
		final CompoundStatement CompoundStatement_90_Var = (CompoundStatement)Statement_89_Var.getStmt();
		Assert.assertNotNull(CompoundStatement_90_Var);
		final BodyStatement BodyStatement_91_Var = (BodyStatement)CompoundStatement_90_Var.getBody();
		Assert.assertNotNull(BodyStatement_91_Var);
		final EList<? extends EObject> BlockList_91_list = BodyStatement_91_Var.getBlockList();
		Assert.assertNotNull(BlockList_91_list);
		Assert.assertEquals(1, BlockList_91_list.size());
		final BlockList BlockList_92_Var = (BlockList)BlockList_91_list.get(0);
		Assert.assertNotNull(BlockList_92_Var);
		final EList<? extends EObject> Statement_92_list = BlockList_92_Var.getStatement();
		Assert.assertNotNull(Statement_92_list);
		Assert.assertEquals(1, Statement_92_list.size());
		final Statement Statement_93_Var = (Statement)Statement_92_list.get(0);
		Assert.assertNotNull(Statement_93_Var);
		final JumpStatement JumpStatement_94_Var = (JumpStatement)Statement_93_Var.getStmt();
		Assert.assertNotNull(JumpStatement_94_Var);
		Assert.assertEquals("continue", JumpStatement_94_Var.getContinue());
	}
	


}
