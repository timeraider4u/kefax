package at.jku.weiner.c.parser.xtexttests;

import com.google.inject.Inject;
import com.google.inject.Provider;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import at.jku.weiner.c.parser.tests.ParserInjectorProvider;
import at.jku.weiner.c.parser.parser.antlr.ParserParser;
import at.jku.weiner.c.parser.parser.antlr.internal.InternalParserLexer;
import at.jku.weiner.c.parser.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.parser.parser.Model;
import at.jku.weiner.c.parser.parser.TranslationUnit;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.ParameterTypeList;
import at.jku.weiner.c.parser.parser.ParameterList;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.IterationStatement;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.AssignmentOperator;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixPlusPlus;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.CompoundStatement;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixMinusMinus;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0027_For {
	@Inject
	private ParseHelper<Model> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalParserLexer lexer;
	@Inject
	private ParserParser parser;
	@Inject
	private ITokenDefProvider tokenDefProvider;
	//@Inject
	private LexerAndParserTest testHelper;
	@Inject
	private IGenerator generator;
	@Inject
	private Provider<ResourceSet> resourceSetProvider;
	@Inject
	private IResourceValidator validator;
	@Inject
	private JavaIoFileSystemAccess fileAccessSystem;
	@Inject
	private IResourceFactory resourceFactory;
	
	@Before
	public void initialize(){
		this.testHelper = new LexerAndParserTest(lexer, 
			parser, tokenDefProvider);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("c",
						this.resourceFactory);
	}
	
	@After
	public void cleanUp() {
	}
	
	private String getTextFromFile(final String fileName)
	throws Exception{
		final Path path = Paths.get(fileName);
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
	@Test
	public void checkLexerTokens() throws Exception{
		final String text = this.getTextFromFile(
			"res/Test0027_For.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_VOID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_FOR", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_ASSIGN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LESS", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_PLUSPLUS", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_MINUSMINUS", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_BREAK", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_SKW_RIGHTBRACE", 
				"RULE_NEWLINE", 
				"RULE_SKW_RIGHTBRACE", 
				"RULE_NEWLINE", 
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0027_For.c");
		final Model Model_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(Model_0_Var
		);
		
		Assert.assertNotNull(Model_0_Var
		);
		final EList<? extends EObject> Unit_0_list = Model_0_Var
		.getUnit();
		Assert.assertNotNull(Unit_0_list);
		Assert.assertEquals(1, Unit_0_list.size());
		//0
		final TranslationUnit TranslationUnit_1_Var
		 = (TranslationUnit)Unit_0_list.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var
		);
		final EList<? extends EObject> External_1_list = TranslationUnit_1_Var
		.getExternal();
		Assert.assertNotNull(External_1_list);
		Assert.assertEquals(1, External_1_list.size());
		//1
		final ExternalDeclaration ExternalDeclaration_2_Var
		 = (ExternalDeclaration)External_1_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_2_Var
		);
		//2
		final FunctionDefHead FunctionDefHead_3_Var
		 = (FunctionDefHead)ExternalDeclaration_2_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_3_Var
		);
		//3
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_4_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_3_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_4_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_4_list = FunctionDeclarationSpecifiers_4_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_4_list);
		Assert.assertEquals(1, DeclarationSpecifier_4_list.size());
		//4
		final TypeSpecifier TypeSpecifier_5_Var
		 = (TypeSpecifier)DeclarationSpecifier_4_list.get(0);
		Assert.assertNotNull(TypeSpecifier_5_Var
		);
		Assert.assertEquals("void", TypeSpecifier_5_Var
		.getName());
		//5
		final Declarator Declarator_6_Var
		 = (Declarator)FunctionDefHead_3_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_6_Var
		);
		//6
		final DirectDeclarator DirectDeclarator_7_Var
		 = (DirectDeclarator)Declarator_6_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_7_Var
		);
		Assert.assertEquals("a", DirectDeclarator_7_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_7_list = DirectDeclarator_7_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_7_list);
		Assert.assertEquals(1, DeclaratorSuffix_7_list.size());
		//7
		final DeclaratorSuffix DeclaratorSuffix_8_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_7_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_8_Var
		);
		//8
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_9_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_8_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_9_Var
		);
		final EList<? extends EObject> ParameterTypeList_9_list = DirectDeclaratorLastSuffix_9_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_9_list);
		Assert.assertEquals(1, ParameterTypeList_9_list.size());
		//9
		final ParameterTypeList ParameterTypeList_10_Var
		 = (ParameterTypeList)ParameterTypeList_9_list.get(0);
		Assert.assertNotNull(ParameterTypeList_10_Var
		);
		//10
		final ParameterList ParameterList_11_Var
		 = (ParameterList)ParameterTypeList_10_Var
		.getList();
		Assert.assertNotNull(ParameterList_11_Var
		);
		final EList<? extends EObject> ParameterDeclaration_11_list = ParameterList_11_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_11_list);
		Assert.assertEquals(1, ParameterDeclaration_11_list.size());
		//11
		final ParameterDeclaration ParameterDeclaration_12_Var
		 = (ParameterDeclaration)ParameterDeclaration_11_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_12_Var
		);
		//12
		final DeclarationSpecifiers DeclarationSpecifiers_13_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_12_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_13_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_13_list = DeclarationSpecifiers_13_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_13_list);
		Assert.assertEquals(1, DeclarationSpecifier_13_list.size());
		//13
		final TypeSpecifier TypeSpecifier_14_Var
		 = (TypeSpecifier)DeclarationSpecifier_13_list.get(0);
		Assert.assertNotNull(TypeSpecifier_14_Var
		);
		Assert.assertEquals("int", TypeSpecifier_14_Var
		.getName());
		//14
		final Declarator Declarator_15_Var
		 = (Declarator)ParameterDeclaration_12_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_15_Var
		);
		//15
		final DirectDeclarator DirectDeclarator_16_Var
		 = (DirectDeclarator)Declarator_15_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_16_Var
		);
		Assert.assertEquals("num", DirectDeclarator_16_Var
		.getId());
		//16
		final FunctionDefinition FunctionDefinition_17_Var
		 = (FunctionDefinition)ExternalDeclaration_2_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_17_Var
		);
		//17
		final BodyStatement BodyStatement_18_Var
		 = (BodyStatement)FunctionDefinition_17_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_18_Var
		);
		final EList<? extends EObject> BlockList_18_list = BodyStatement_18_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_18_list);
		Assert.assertEquals(1, BlockList_18_list.size());
		//18
		final BlockList BlockList_19_Var
		 = (BlockList)BlockList_18_list.get(0);
		Assert.assertNotNull(BlockList_19_Var
		);
		final EList<? extends EObject> Statement_19_list = BlockList_19_Var
		.getStatement();
		Assert.assertNotNull(Statement_19_list);
		Assert.assertEquals(1, Statement_19_list.size());
		//19
		final Statement Statement_20_Var
		 = (Statement)Statement_19_list.get(0);
		Assert.assertNotNull(Statement_20_Var
		);
		//20
		final IterationStatement IterationStatement_21_Var
		 = (IterationStatement)Statement_20_Var
		.getStmt();
		Assert.assertNotNull(IterationStatement_21_Var
		);
		Assert.assertEquals("for", IterationStatement_21_Var
		.getFor());
		//21
		final Expression Expression_22_Var
		 = (Expression)IterationStatement_21_Var
		.getInitExpr();
		Assert.assertNotNull(Expression_22_Var
		);
		final EList<? extends EObject> ExprExpr_22_list = Expression_22_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_22_list);
		Assert.assertEquals(1, ExprExpr_22_list.size());
		//22
		final AssignmentExpression AssignmentExpression_23_Var
		 = (AssignmentExpression)ExprExpr_22_list.get(0);
		Assert.assertNotNull(AssignmentExpression_23_Var
		);
		//23
		final AssignmentOperator AssignmentOperator_24_Var
		 = (AssignmentOperator)AssignmentExpression_23_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_24_Var
		);
		Assert.assertEquals("=", AssignmentOperator_24_Var
		.getOp());
		//24
		final UnaryExpression UnaryExpression_25_Var
		 = (UnaryExpression)AssignmentExpression_23_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_25_Var
		);
		//25
		final PostfixExpression PostfixExpression_26_Var
		 = (PostfixExpression)UnaryExpression_25_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = PostfixExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final PrimaryExpression PrimaryExpression_27_Var
		 = (PrimaryExpression)Expr_26_list.get(0);
		Assert.assertNotNull(PrimaryExpression_27_Var
		);
		Assert.assertEquals("num", PrimaryExpression_27_Var
		.getId());
		//27
		final AssignmentExpression AssignmentExpression_28_Var
		 = (AssignmentExpression)AssignmentExpression_23_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_28_Var
		);
		//28
		final ConditionalExpression ConditionalExpression_29_Var
		 = (ConditionalExpression)AssignmentExpression_28_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_29_Var
		);
		//29
		final LogicalOrExpression LogicalOrExpression_30_Var
		 = (LogicalOrExpression)ConditionalExpression_29_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = LogicalOrExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final LogicalAndExpression LogicalAndExpression_31_Var
		 = (LogicalAndExpression)Expr_30_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = LogicalAndExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final InclusiveOrExpression InclusiveOrExpression_32_Var
		 = (InclusiveOrExpression)Expr_31_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = InclusiveOrExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final ExclusiveOrExpression ExclusiveOrExpression_33_Var
		 = (ExclusiveOrExpression)Expr_32_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = ExclusiveOrExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final AndExpression AndExpression_34_Var
		 = (AndExpression)Expr_33_list.get(0);
		Assert.assertNotNull(AndExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = AndExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final EqualityExpression EqualityExpression_35_Var
		 = (EqualityExpression)Expr_34_list.get(0);
		Assert.assertNotNull(EqualityExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = EqualityExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final RelationalExpression RelationalExpression_36_Var
		 = (RelationalExpression)Expr_35_list.get(0);
		Assert.assertNotNull(RelationalExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = RelationalExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final ShiftExpression ShiftExpression_37_Var
		 = (ShiftExpression)Expr_36_list.get(0);
		Assert.assertNotNull(ShiftExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = ShiftExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final AdditiveExpression AdditiveExpression_38_Var
		 = (AdditiveExpression)Expr_37_list.get(0);
		Assert.assertNotNull(AdditiveExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = AdditiveExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final MultiplicativeExpression MultiplicativeExpression_39_Var
		 = (MultiplicativeExpression)Expr_38_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = MultiplicativeExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final CastExpression CastExpression_40_Var
		 = (CastExpression)Expr_39_list.get(0);
		Assert.assertNotNull(CastExpression_40_Var
		);
		//40
		final UnaryExpression UnaryExpression_41_Var
		 = (UnaryExpression)CastExpression_40_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_41_Var
		);
		//41
		final PostfixExpression PostfixExpression_42_Var
		 = (PostfixExpression)UnaryExpression_41_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = PostfixExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final PrimaryExpression PrimaryExpression_43_Var
		 = (PrimaryExpression)Expr_42_list.get(0);
		Assert.assertNotNull(PrimaryExpression_43_Var
		);
		//43
		final Constant2 Constant2_44_Var
		 = (Constant2)PrimaryExpression_43_Var
		.getConst();
		Assert.assertNotNull(Constant2_44_Var
		);
		Assert.assertEquals("0", Constant2_44_Var
		.getDec());
		//44
		final Expression Expression_45_Var
		 = (Expression)IterationStatement_21_Var
		.getExpr();
		Assert.assertNotNull(Expression_45_Var
		);
		final EList<? extends EObject> ExprExpr_45_list = Expression_45_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_45_list);
		Assert.assertEquals(1, ExprExpr_45_list.size());
		//45
		final AssignmentExpression AssignmentExpression_46_Var
		 = (AssignmentExpression)ExprExpr_45_list.get(0);
		Assert.assertNotNull(AssignmentExpression_46_Var
		);
		//46
		final ConditionalExpression ConditionalExpression_47_Var
		 = (ConditionalExpression)AssignmentExpression_46_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_47_Var
		);
		//47
		final LogicalOrExpression LogicalOrExpression_48_Var
		 = (LogicalOrExpression)ConditionalExpression_47_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = LogicalOrExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final LogicalAndExpression LogicalAndExpression_49_Var
		 = (LogicalAndExpression)Expr_48_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = LogicalAndExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final InclusiveOrExpression InclusiveOrExpression_50_Var
		 = (InclusiveOrExpression)Expr_49_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = InclusiveOrExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final ExclusiveOrExpression ExclusiveOrExpression_51_Var
		 = (ExclusiveOrExpression)Expr_50_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = ExclusiveOrExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final AndExpression AndExpression_52_Var
		 = (AndExpression)Expr_51_list.get(0);
		Assert.assertNotNull(AndExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = AndExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final EqualityExpression EqualityExpression_53_Var
		 = (EqualityExpression)Expr_52_list.get(0);
		Assert.assertNotNull(EqualityExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = EqualityExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final RelationalExpression RelationalExpression_54_Var
		 = (RelationalExpression)Expr_53_list.get(0);
		Assert.assertNotNull(RelationalExpression_54_Var
		);
		Assert.assertEquals("[<]", RelationalExpression_54_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_54_list = RelationalExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(2, Expr_54_list.size());
		//54
		final ShiftExpression ShiftExpression_55_Var
		 = (ShiftExpression)Expr_54_list.get(0);
		Assert.assertNotNull(ShiftExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = ShiftExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final AdditiveExpression AdditiveExpression_56_Var
		 = (AdditiveExpression)Expr_55_list.get(0);
		Assert.assertNotNull(AdditiveExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = AdditiveExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final MultiplicativeExpression MultiplicativeExpression_57_Var
		 = (MultiplicativeExpression)Expr_56_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = MultiplicativeExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final CastExpression CastExpression_58_Var
		 = (CastExpression)Expr_57_list.get(0);
		Assert.assertNotNull(CastExpression_58_Var
		);
		//58
		final UnaryExpression UnaryExpression_59_Var
		 = (UnaryExpression)CastExpression_58_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_59_Var
		);
		//59
		final PostfixExpression PostfixExpression_60_Var
		 = (PostfixExpression)UnaryExpression_59_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = PostfixExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final PrimaryExpression PrimaryExpression_61_Var
		 = (PrimaryExpression)Expr_60_list.get(0);
		Assert.assertNotNull(PrimaryExpression_61_Var
		);
		Assert.assertEquals("num", PrimaryExpression_61_Var
		.getId());
		//61
		final ShiftExpression ShiftExpression_62_Var
		 = (ShiftExpression)Expr_54_list.get(1);
		Assert.assertNotNull(ShiftExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = ShiftExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final AdditiveExpression AdditiveExpression_63_Var
		 = (AdditiveExpression)Expr_62_list.get(0);
		Assert.assertNotNull(AdditiveExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = AdditiveExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final MultiplicativeExpression MultiplicativeExpression_64_Var
		 = (MultiplicativeExpression)Expr_63_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = MultiplicativeExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final CastExpression CastExpression_65_Var
		 = (CastExpression)Expr_64_list.get(0);
		Assert.assertNotNull(CastExpression_65_Var
		);
		//65
		final UnaryExpression UnaryExpression_66_Var
		 = (UnaryExpression)CastExpression_65_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_66_Var
		);
		//66
		final PostfixExpression PostfixExpression_67_Var
		 = (PostfixExpression)UnaryExpression_66_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = PostfixExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final PrimaryExpression PrimaryExpression_68_Var
		 = (PrimaryExpression)Expr_67_list.get(0);
		Assert.assertNotNull(PrimaryExpression_68_Var
		);
		//68
		final Constant2 Constant2_69_Var
		 = (Constant2)PrimaryExpression_68_Var
		.getConst();
		Assert.assertNotNull(Constant2_69_Var
		);
		Assert.assertEquals("5", Constant2_69_Var
		.getDec());
		//69
		final Expression Expression_70_Var
		 = (Expression)IterationStatement_21_Var
		.getIncExpr();
		Assert.assertNotNull(Expression_70_Var
		);
		final EList<? extends EObject> ExprExpr_70_list = Expression_70_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_70_list);
		Assert.assertEquals(1, ExprExpr_70_list.size());
		//70
		final AssignmentExpression AssignmentExpression_71_Var
		 = (AssignmentExpression)ExprExpr_70_list.get(0);
		Assert.assertNotNull(AssignmentExpression_71_Var
		);
		//71
		final ConditionalExpression ConditionalExpression_72_Var
		 = (ConditionalExpression)AssignmentExpression_71_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_72_Var
		);
		//72
		final LogicalOrExpression LogicalOrExpression_73_Var
		 = (LogicalOrExpression)ConditionalExpression_72_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = LogicalOrExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final LogicalAndExpression LogicalAndExpression_74_Var
		 = (LogicalAndExpression)Expr_73_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = LogicalAndExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final InclusiveOrExpression InclusiveOrExpression_75_Var
		 = (InclusiveOrExpression)Expr_74_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = InclusiveOrExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final ExclusiveOrExpression ExclusiveOrExpression_76_Var
		 = (ExclusiveOrExpression)Expr_75_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = ExclusiveOrExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final AndExpression AndExpression_77_Var
		 = (AndExpression)Expr_76_list.get(0);
		Assert.assertNotNull(AndExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = AndExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final EqualityExpression EqualityExpression_78_Var
		 = (EqualityExpression)Expr_77_list.get(0);
		Assert.assertNotNull(EqualityExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = EqualityExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final RelationalExpression RelationalExpression_79_Var
		 = (RelationalExpression)Expr_78_list.get(0);
		Assert.assertNotNull(RelationalExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = RelationalExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final ShiftExpression ShiftExpression_80_Var
		 = (ShiftExpression)Expr_79_list.get(0);
		Assert.assertNotNull(ShiftExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = ShiftExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final AdditiveExpression AdditiveExpression_81_Var
		 = (AdditiveExpression)Expr_80_list.get(0);
		Assert.assertNotNull(AdditiveExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = AdditiveExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final MultiplicativeExpression MultiplicativeExpression_82_Var
		 = (MultiplicativeExpression)Expr_81_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = MultiplicativeExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final CastExpression CastExpression_83_Var
		 = (CastExpression)Expr_82_list.get(0);
		Assert.assertNotNull(CastExpression_83_Var
		);
		//83
		final UnaryExpression UnaryExpression_84_Var
		 = (UnaryExpression)CastExpression_83_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_84_Var
		);
		//84
		final PostfixExpression PostfixExpression_85_Var
		 = (PostfixExpression)UnaryExpression_84_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = PostfixExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final PrimaryExpression PrimaryExpression_86_Var
		 = (PrimaryExpression)Expr_85_list.get(0);
		Assert.assertNotNull(PrimaryExpression_86_Var
		);
		Assert.assertEquals("num", PrimaryExpression_86_Var
		.getId());
		final EList<? extends EObject> Suffix_86_list = PostfixExpression_85_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_86_list);
		Assert.assertEquals(1, Suffix_86_list.size());
		//86
		final PostfixExpressionSuffixPlusPlus PostfixExpressionSuffixPlusPlus_87_Var
		 = (PostfixExpressionSuffixPlusPlus)Suffix_86_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixPlusPlus_87_Var
		);
		//87
		final Statement Statement_88_Var
		 = (Statement)IterationStatement_21_Var
		.getStatement();
		Assert.assertNotNull(Statement_88_Var
		);
		//88
		final CompoundStatement CompoundStatement_89_Var
		 = (CompoundStatement)Statement_88_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_89_Var
		);
		//89
		final BodyStatement BodyStatement_90_Var
		 = (BodyStatement)CompoundStatement_89_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_90_Var
		);
		final EList<? extends EObject> BlockList_90_list = BodyStatement_90_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_90_list);
		Assert.assertEquals(1, BlockList_90_list.size());
		//90
		final BlockList BlockList_91_Var
		 = (BlockList)BlockList_90_list.get(0);
		Assert.assertNotNull(BlockList_91_Var
		);
		final EList<? extends EObject> Statement_91_list = BlockList_91_Var
		.getStatement();
		Assert.assertNotNull(Statement_91_list);
		Assert.assertEquals(2, Statement_91_list.size());
		//91
		final Statement Statement_92_Var
		 = (Statement)Statement_91_list.get(0);
		Assert.assertNotNull(Statement_92_Var
		);
		//92
		final ExpressionStatement ExpressionStatement_93_Var
		 = (ExpressionStatement)Statement_92_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_93_Var
		);
		//93
		final Expression Expression_94_Var
		 = (Expression)ExpressionStatement_93_Var
		.getExpression();
		Assert.assertNotNull(Expression_94_Var
		);
		final EList<? extends EObject> ExprExpr_94_list = Expression_94_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_94_list);
		Assert.assertEquals(1, ExprExpr_94_list.size());
		//94
		final AssignmentExpression AssignmentExpression_95_Var
		 = (AssignmentExpression)ExprExpr_94_list.get(0);
		Assert.assertNotNull(AssignmentExpression_95_Var
		);
		//95
		final ConditionalExpression ConditionalExpression_96_Var
		 = (ConditionalExpression)AssignmentExpression_95_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_96_Var
		);
		//96
		final LogicalOrExpression LogicalOrExpression_97_Var
		 = (LogicalOrExpression)ConditionalExpression_96_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = LogicalOrExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final LogicalAndExpression LogicalAndExpression_98_Var
		 = (LogicalAndExpression)Expr_97_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = LogicalAndExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final InclusiveOrExpression InclusiveOrExpression_99_Var
		 = (InclusiveOrExpression)Expr_98_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = InclusiveOrExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final ExclusiveOrExpression ExclusiveOrExpression_100_Var
		 = (ExclusiveOrExpression)Expr_99_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = ExclusiveOrExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final AndExpression AndExpression_101_Var
		 = (AndExpression)Expr_100_list.get(0);
		Assert.assertNotNull(AndExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = AndExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final EqualityExpression EqualityExpression_102_Var
		 = (EqualityExpression)Expr_101_list.get(0);
		Assert.assertNotNull(EqualityExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = EqualityExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final RelationalExpression RelationalExpression_103_Var
		 = (RelationalExpression)Expr_102_list.get(0);
		Assert.assertNotNull(RelationalExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = RelationalExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final ShiftExpression ShiftExpression_104_Var
		 = (ShiftExpression)Expr_103_list.get(0);
		Assert.assertNotNull(ShiftExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = ShiftExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final AdditiveExpression AdditiveExpression_105_Var
		 = (AdditiveExpression)Expr_104_list.get(0);
		Assert.assertNotNull(AdditiveExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = AdditiveExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final MultiplicativeExpression MultiplicativeExpression_106_Var
		 = (MultiplicativeExpression)Expr_105_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = MultiplicativeExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final CastExpression CastExpression_107_Var
		 = (CastExpression)Expr_106_list.get(0);
		Assert.assertNotNull(CastExpression_107_Var
		);
		//107
		final UnaryExpression UnaryExpression_108_Var
		 = (UnaryExpression)CastExpression_107_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_108_Var
		);
		//108
		final PostfixExpression PostfixExpression_109_Var
		 = (PostfixExpression)UnaryExpression_108_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = PostfixExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final PrimaryExpression PrimaryExpression_110_Var
		 = (PrimaryExpression)Expr_109_list.get(0);
		Assert.assertNotNull(PrimaryExpression_110_Var
		);
		Assert.assertEquals("num", PrimaryExpression_110_Var
		.getId());
		final EList<? extends EObject> Suffix_110_list = PostfixExpression_109_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_110_list);
		Assert.assertEquals(1, Suffix_110_list.size());
		//110
		final PostfixExpressionSuffixMinusMinus PostfixExpressionSuffixMinusMinus_111_Var
		 = (PostfixExpressionSuffixMinusMinus)Suffix_110_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixMinusMinus_111_Var
		);
		Assert.assertEquals(";", ExpressionStatement_93_Var
		.getSemi());
		//111
		final Statement Statement_112_Var
		 = (Statement)Statement_91_list.get(1);
		Assert.assertNotNull(Statement_112_Var
		);
		//112
		final JumpStatement JumpStatement_113_Var
		 = (JumpStatement)Statement_112_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_113_Var
		);
		Assert.assertEquals("break", JumpStatement_113_Var
		.getBreak());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0027_For.c");
		Resource resource = set.getResource(uri, true);
		// validate the resource
		List<Issue> list = this.validator.validate(resource, 
			CheckMode.ALL,CancelIndicator.NullImpl);
		Assert.assertTrue(list.isEmpty());
		
		// configure and start the generator
		this.fileAccessSystem.setOutputPath("bin");
		final Class<?> clazz = this.generator.getClass();
		try {
			final Method method = clazz.getMethod("setFileName",
					String.class);
			if (method != null) {
				method.invoke(this.generator, "Test0027_For.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0027_For.c");
		final String expected = this.getTextFromFile(
			"res/Test0027_For.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
		// System.out.println("Code generation finished.");
	}
	
	private String preprocess(String string) throws Exception {
		string = preprocessForFile(string);
		string = preprocessForPatterns(string);
		return string;
	}
	
	private String preprocessForFile(String string) throws Exception {
		final String content = this.getTextFromFile("res/Patterns.txt");
		final String[] lines = content.split("\n");
		if (lines == null) {
			return string;
		}
		for (String line : lines) {
			final String[] myLine = line.split("=");
			if (myLine == null || myLine.length != 2) {
				continue;
			}
			final String regex = myLine[0].replace("\"", "").replace("\\\\", "\\");
			final String replace = myLine[1].replace("\"", "").replace("\\\\", "\\");
			string = string.replaceAll(regex, replace);
		}
		return string;
	}
	
	private String preprocessForPatterns(String string) {
		return string;
	}
	
}


