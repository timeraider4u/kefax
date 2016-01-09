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

import at.jku.weiner.c.parser.parser.Parser;
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
	private ParseHelper<Parser> parseHelper;
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
	
	@Test (timeout=1000)
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
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0027_For.c");
		final Parser Parser_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(Parser_0_Var
		);
		
		Assert.assertNotNull(Parser_0_Var
		);
		final EList<? extends EObject> External_0_list = Parser_0_Var
		.getExternal();
		Assert.assertNotNull(External_0_list);
		Assert.assertEquals(1, External_0_list.size());
		//0
		final ExternalDeclaration ExternalDeclaration_1_Var
		 = (ExternalDeclaration)External_0_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_1_Var
		);
		//1
		final FunctionDefHead FunctionDefHead_2_Var
		 = (FunctionDefHead)ExternalDeclaration_1_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_2_Var
		);
		//2
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_3_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_2_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_3_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_3_list = FunctionDeclarationSpecifiers_3_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_3_list);
		Assert.assertEquals(1, DeclarationSpecifier_3_list.size());
		//3
		final TypeSpecifier TypeSpecifier_4_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(TypeSpecifier_4_Var
		);
		Assert.assertEquals("void", TypeSpecifier_4_Var
		.getName());
		//4
		final Declarator Declarator_5_Var
		 = (Declarator)FunctionDefHead_2_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_5_Var
		);
		//5
		final DirectDeclarator DirectDeclarator_6_Var
		 = (DirectDeclarator)Declarator_5_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_6_Var
		);
		Assert.assertEquals("a", DirectDeclarator_6_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_6_list = DirectDeclarator_6_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_6_list);
		Assert.assertEquals(1, DeclaratorSuffix_6_list.size());
		//6
		final DeclaratorSuffix DeclaratorSuffix_7_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_6_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_7_Var
		);
		//7
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_8_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_7_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_8_Var
		);
		final EList<? extends EObject> ParameterTypeList_8_list = DirectDeclaratorLastSuffix_8_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_8_list);
		Assert.assertEquals(1, ParameterTypeList_8_list.size());
		//8
		final ParameterTypeList ParameterTypeList_9_Var
		 = (ParameterTypeList)ParameterTypeList_8_list.get(0);
		Assert.assertNotNull(ParameterTypeList_9_Var
		);
		//9
		final ParameterList ParameterList_10_Var
		 = (ParameterList)ParameterTypeList_9_Var
		.getList();
		Assert.assertNotNull(ParameterList_10_Var
		);
		final EList<? extends EObject> ParameterDeclaration_10_list = ParameterList_10_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_10_list);
		Assert.assertEquals(1, ParameterDeclaration_10_list.size());
		//10
		final ParameterDeclaration ParameterDeclaration_11_Var
		 = (ParameterDeclaration)ParameterDeclaration_10_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_11_Var
		);
		//11
		final DeclarationSpecifiers DeclarationSpecifiers_12_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_11_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_12_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_12_list = DeclarationSpecifiers_12_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_12_list);
		Assert.assertEquals(1, DeclarationSpecifier_12_list.size());
		//12
		final TypeSpecifier TypeSpecifier_13_Var
		 = (TypeSpecifier)DeclarationSpecifier_12_list.get(0);
		Assert.assertNotNull(TypeSpecifier_13_Var
		);
		Assert.assertEquals("int", TypeSpecifier_13_Var
		.getName());
		//13
		final Declarator Declarator_14_Var
		 = (Declarator)ParameterDeclaration_11_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_14_Var
		);
		//14
		final DirectDeclarator DirectDeclarator_15_Var
		 = (DirectDeclarator)Declarator_14_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_15_Var
		);
		Assert.assertEquals("num", DirectDeclarator_15_Var
		.getId());
		//15
		final FunctionDefinition FunctionDefinition_16_Var
		 = (FunctionDefinition)ExternalDeclaration_1_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_16_Var
		);
		//16
		final BodyStatement BodyStatement_17_Var
		 = (BodyStatement)FunctionDefinition_16_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_17_Var
		);
		final EList<? extends EObject> BlockList_17_list = BodyStatement_17_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_17_list);
		Assert.assertEquals(1, BlockList_17_list.size());
		//17
		final BlockList BlockList_18_Var
		 = (BlockList)BlockList_17_list.get(0);
		Assert.assertNotNull(BlockList_18_Var
		);
		final EList<? extends EObject> Statement_18_list = BlockList_18_Var
		.getStatement();
		Assert.assertNotNull(Statement_18_list);
		Assert.assertEquals(1, Statement_18_list.size());
		//18
		final Statement Statement_19_Var
		 = (Statement)Statement_18_list.get(0);
		Assert.assertNotNull(Statement_19_Var
		);
		//19
		final IterationStatement IterationStatement_20_Var
		 = (IterationStatement)Statement_19_Var
		.getStmt();
		Assert.assertNotNull(IterationStatement_20_Var
		);
		Assert.assertEquals("for", IterationStatement_20_Var
		.getFor());
		//20
		final Expression Expression_21_Var
		 = (Expression)IterationStatement_20_Var
		.getInitExpr();
		Assert.assertNotNull(Expression_21_Var
		);
		final EList<? extends EObject> ExprExpr_21_list = Expression_21_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_21_list);
		Assert.assertEquals(1, ExprExpr_21_list.size());
		//21
		final AssignmentExpression AssignmentExpression_22_Var
		 = (AssignmentExpression)ExprExpr_21_list.get(0);
		Assert.assertNotNull(AssignmentExpression_22_Var
		);
		//22
		final AssignmentOperator AssignmentOperator_23_Var
		 = (AssignmentOperator)AssignmentExpression_22_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_23_Var
		);
		Assert.assertEquals("=", AssignmentOperator_23_Var
		.getOp());
		//23
		final UnaryExpression UnaryExpression_24_Var
		 = (UnaryExpression)AssignmentExpression_22_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_24_Var
		);
		//24
		final PostfixExpression PostfixExpression_25_Var
		 = (PostfixExpression)UnaryExpression_24_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = PostfixExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final PrimaryExpression PrimaryExpression_26_Var
		 = (PrimaryExpression)Expr_25_list.get(0);
		Assert.assertNotNull(PrimaryExpression_26_Var
		);
		Assert.assertEquals("num", PrimaryExpression_26_Var
		.getId());
		//26
		final AssignmentExpression AssignmentExpression_27_Var
		 = (AssignmentExpression)AssignmentExpression_22_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_27_Var
		);
		//27
		final ConditionalExpression ConditionalExpression_28_Var
		 = (ConditionalExpression)AssignmentExpression_27_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_28_Var
		);
		//28
		final LogicalOrExpression LogicalOrExpression_29_Var
		 = (LogicalOrExpression)ConditionalExpression_28_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = LogicalOrExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final LogicalAndExpression LogicalAndExpression_30_Var
		 = (LogicalAndExpression)Expr_29_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = LogicalAndExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final InclusiveOrExpression InclusiveOrExpression_31_Var
		 = (InclusiveOrExpression)Expr_30_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = InclusiveOrExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final ExclusiveOrExpression ExclusiveOrExpression_32_Var
		 = (ExclusiveOrExpression)Expr_31_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = ExclusiveOrExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final AndExpression AndExpression_33_Var
		 = (AndExpression)Expr_32_list.get(0);
		Assert.assertNotNull(AndExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = AndExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final EqualityExpression EqualityExpression_34_Var
		 = (EqualityExpression)Expr_33_list.get(0);
		Assert.assertNotNull(EqualityExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = EqualityExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final RelationalExpression RelationalExpression_35_Var
		 = (RelationalExpression)Expr_34_list.get(0);
		Assert.assertNotNull(RelationalExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = RelationalExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final ShiftExpression ShiftExpression_36_Var
		 = (ShiftExpression)Expr_35_list.get(0);
		Assert.assertNotNull(ShiftExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = ShiftExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final AdditiveExpression AdditiveExpression_37_Var
		 = (AdditiveExpression)Expr_36_list.get(0);
		Assert.assertNotNull(AdditiveExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = AdditiveExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final MultiplicativeExpression MultiplicativeExpression_38_Var
		 = (MultiplicativeExpression)Expr_37_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = MultiplicativeExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final CastExpression CastExpression_39_Var
		 = (CastExpression)Expr_38_list.get(0);
		Assert.assertNotNull(CastExpression_39_Var
		);
		//39
		final UnaryExpression UnaryExpression_40_Var
		 = (UnaryExpression)CastExpression_39_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_40_Var
		);
		//40
		final PostfixExpression PostfixExpression_41_Var
		 = (PostfixExpression)UnaryExpression_40_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = PostfixExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final PrimaryExpression PrimaryExpression_42_Var
		 = (PrimaryExpression)Expr_41_list.get(0);
		Assert.assertNotNull(PrimaryExpression_42_Var
		);
		//42
		final Constant2 Constant2_43_Var
		 = (Constant2)PrimaryExpression_42_Var
		.getConst();
		Assert.assertNotNull(Constant2_43_Var
		);
		Assert.assertEquals("0", Constant2_43_Var
		.getDec());
		//43
		final Expression Expression_44_Var
		 = (Expression)IterationStatement_20_Var
		.getExpr();
		Assert.assertNotNull(Expression_44_Var
		);
		final EList<? extends EObject> ExprExpr_44_list = Expression_44_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_44_list);
		Assert.assertEquals(1, ExprExpr_44_list.size());
		//44
		final AssignmentExpression AssignmentExpression_45_Var
		 = (AssignmentExpression)ExprExpr_44_list.get(0);
		Assert.assertNotNull(AssignmentExpression_45_Var
		);
		//45
		final ConditionalExpression ConditionalExpression_46_Var
		 = (ConditionalExpression)AssignmentExpression_45_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_46_Var
		);
		//46
		final LogicalOrExpression LogicalOrExpression_47_Var
		 = (LogicalOrExpression)ConditionalExpression_46_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = LogicalOrExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final LogicalAndExpression LogicalAndExpression_48_Var
		 = (LogicalAndExpression)Expr_47_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = LogicalAndExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final InclusiveOrExpression InclusiveOrExpression_49_Var
		 = (InclusiveOrExpression)Expr_48_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = InclusiveOrExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final ExclusiveOrExpression ExclusiveOrExpression_50_Var
		 = (ExclusiveOrExpression)Expr_49_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = ExclusiveOrExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final AndExpression AndExpression_51_Var
		 = (AndExpression)Expr_50_list.get(0);
		Assert.assertNotNull(AndExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = AndExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final EqualityExpression EqualityExpression_52_Var
		 = (EqualityExpression)Expr_51_list.get(0);
		Assert.assertNotNull(EqualityExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = EqualityExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final RelationalExpression RelationalExpression_53_Var
		 = (RelationalExpression)Expr_52_list.get(0);
		Assert.assertNotNull(RelationalExpression_53_Var
		);
		Assert.assertEquals("[<]", RelationalExpression_53_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_53_list = RelationalExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(2, Expr_53_list.size());
		//53
		final ShiftExpression ShiftExpression_54_Var
		 = (ShiftExpression)Expr_53_list.get(0);
		Assert.assertNotNull(ShiftExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = ShiftExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final AdditiveExpression AdditiveExpression_55_Var
		 = (AdditiveExpression)Expr_54_list.get(0);
		Assert.assertNotNull(AdditiveExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = AdditiveExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final MultiplicativeExpression MultiplicativeExpression_56_Var
		 = (MultiplicativeExpression)Expr_55_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = MultiplicativeExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final CastExpression CastExpression_57_Var
		 = (CastExpression)Expr_56_list.get(0);
		Assert.assertNotNull(CastExpression_57_Var
		);
		//57
		final UnaryExpression UnaryExpression_58_Var
		 = (UnaryExpression)CastExpression_57_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_58_Var
		);
		//58
		final PostfixExpression PostfixExpression_59_Var
		 = (PostfixExpression)UnaryExpression_58_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = PostfixExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final PrimaryExpression PrimaryExpression_60_Var
		 = (PrimaryExpression)Expr_59_list.get(0);
		Assert.assertNotNull(PrimaryExpression_60_Var
		);
		Assert.assertEquals("num", PrimaryExpression_60_Var
		.getId());
		//60
		final ShiftExpression ShiftExpression_61_Var
		 = (ShiftExpression)Expr_53_list.get(1);
		Assert.assertNotNull(ShiftExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = ShiftExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final AdditiveExpression AdditiveExpression_62_Var
		 = (AdditiveExpression)Expr_61_list.get(0);
		Assert.assertNotNull(AdditiveExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = AdditiveExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final MultiplicativeExpression MultiplicativeExpression_63_Var
		 = (MultiplicativeExpression)Expr_62_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = MultiplicativeExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final CastExpression CastExpression_64_Var
		 = (CastExpression)Expr_63_list.get(0);
		Assert.assertNotNull(CastExpression_64_Var
		);
		//64
		final UnaryExpression UnaryExpression_65_Var
		 = (UnaryExpression)CastExpression_64_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_65_Var
		);
		//65
		final PostfixExpression PostfixExpression_66_Var
		 = (PostfixExpression)UnaryExpression_65_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = PostfixExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final PrimaryExpression PrimaryExpression_67_Var
		 = (PrimaryExpression)Expr_66_list.get(0);
		Assert.assertNotNull(PrimaryExpression_67_Var
		);
		//67
		final Constant2 Constant2_68_Var
		 = (Constant2)PrimaryExpression_67_Var
		.getConst();
		Assert.assertNotNull(Constant2_68_Var
		);
		Assert.assertEquals("5", Constant2_68_Var
		.getDec());
		//68
		final Expression Expression_69_Var
		 = (Expression)IterationStatement_20_Var
		.getIncExpr();
		Assert.assertNotNull(Expression_69_Var
		);
		final EList<? extends EObject> ExprExpr_69_list = Expression_69_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_69_list);
		Assert.assertEquals(1, ExprExpr_69_list.size());
		//69
		final AssignmentExpression AssignmentExpression_70_Var
		 = (AssignmentExpression)ExprExpr_69_list.get(0);
		Assert.assertNotNull(AssignmentExpression_70_Var
		);
		//70
		final ConditionalExpression ConditionalExpression_71_Var
		 = (ConditionalExpression)AssignmentExpression_70_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_71_Var
		);
		//71
		final LogicalOrExpression LogicalOrExpression_72_Var
		 = (LogicalOrExpression)ConditionalExpression_71_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = LogicalOrExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final LogicalAndExpression LogicalAndExpression_73_Var
		 = (LogicalAndExpression)Expr_72_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = LogicalAndExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final InclusiveOrExpression InclusiveOrExpression_74_Var
		 = (InclusiveOrExpression)Expr_73_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = InclusiveOrExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final ExclusiveOrExpression ExclusiveOrExpression_75_Var
		 = (ExclusiveOrExpression)Expr_74_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = ExclusiveOrExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final AndExpression AndExpression_76_Var
		 = (AndExpression)Expr_75_list.get(0);
		Assert.assertNotNull(AndExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = AndExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final EqualityExpression EqualityExpression_77_Var
		 = (EqualityExpression)Expr_76_list.get(0);
		Assert.assertNotNull(EqualityExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = EqualityExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final RelationalExpression RelationalExpression_78_Var
		 = (RelationalExpression)Expr_77_list.get(0);
		Assert.assertNotNull(RelationalExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = RelationalExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final ShiftExpression ShiftExpression_79_Var
		 = (ShiftExpression)Expr_78_list.get(0);
		Assert.assertNotNull(ShiftExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = ShiftExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final AdditiveExpression AdditiveExpression_80_Var
		 = (AdditiveExpression)Expr_79_list.get(0);
		Assert.assertNotNull(AdditiveExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = AdditiveExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final MultiplicativeExpression MultiplicativeExpression_81_Var
		 = (MultiplicativeExpression)Expr_80_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = MultiplicativeExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final CastExpression CastExpression_82_Var
		 = (CastExpression)Expr_81_list.get(0);
		Assert.assertNotNull(CastExpression_82_Var
		);
		//82
		final UnaryExpression UnaryExpression_83_Var
		 = (UnaryExpression)CastExpression_82_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_83_Var
		);
		//83
		final PostfixExpression PostfixExpression_84_Var
		 = (PostfixExpression)UnaryExpression_83_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = PostfixExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final PrimaryExpression PrimaryExpression_85_Var
		 = (PrimaryExpression)Expr_84_list.get(0);
		Assert.assertNotNull(PrimaryExpression_85_Var
		);
		Assert.assertEquals("num", PrimaryExpression_85_Var
		.getId());
		final EList<? extends EObject> Suffix_85_list = PostfixExpression_84_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_85_list);
		Assert.assertEquals(1, Suffix_85_list.size());
		//85
		final PostfixExpressionSuffixPlusPlus PostfixExpressionSuffixPlusPlus_86_Var
		 = (PostfixExpressionSuffixPlusPlus)Suffix_85_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixPlusPlus_86_Var
		);
		//86
		final Statement Statement_87_Var
		 = (Statement)IterationStatement_20_Var
		.getStatement();
		Assert.assertNotNull(Statement_87_Var
		);
		//87
		final CompoundStatement CompoundStatement_88_Var
		 = (CompoundStatement)Statement_87_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_88_Var
		);
		//88
		final BodyStatement BodyStatement_89_Var
		 = (BodyStatement)CompoundStatement_88_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_89_Var
		);
		final EList<? extends EObject> BlockList_89_list = BodyStatement_89_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_89_list);
		Assert.assertEquals(1, BlockList_89_list.size());
		//89
		final BlockList BlockList_90_Var
		 = (BlockList)BlockList_89_list.get(0);
		Assert.assertNotNull(BlockList_90_Var
		);
		final EList<? extends EObject> Statement_90_list = BlockList_90_Var
		.getStatement();
		Assert.assertNotNull(Statement_90_list);
		Assert.assertEquals(2, Statement_90_list.size());
		//90
		final Statement Statement_91_Var
		 = (Statement)Statement_90_list.get(0);
		Assert.assertNotNull(Statement_91_Var
		);
		//91
		final ExpressionStatement ExpressionStatement_92_Var
		 = (ExpressionStatement)Statement_91_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_92_Var
		);
		//92
		final Expression Expression_93_Var
		 = (Expression)ExpressionStatement_92_Var
		.getExpression();
		Assert.assertNotNull(Expression_93_Var
		);
		final EList<? extends EObject> ExprExpr_93_list = Expression_93_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_93_list);
		Assert.assertEquals(1, ExprExpr_93_list.size());
		//93
		final AssignmentExpression AssignmentExpression_94_Var
		 = (AssignmentExpression)ExprExpr_93_list.get(0);
		Assert.assertNotNull(AssignmentExpression_94_Var
		);
		//94
		final ConditionalExpression ConditionalExpression_95_Var
		 = (ConditionalExpression)AssignmentExpression_94_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_95_Var
		);
		//95
		final LogicalOrExpression LogicalOrExpression_96_Var
		 = (LogicalOrExpression)ConditionalExpression_95_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = LogicalOrExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final LogicalAndExpression LogicalAndExpression_97_Var
		 = (LogicalAndExpression)Expr_96_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = LogicalAndExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final InclusiveOrExpression InclusiveOrExpression_98_Var
		 = (InclusiveOrExpression)Expr_97_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = InclusiveOrExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final ExclusiveOrExpression ExclusiveOrExpression_99_Var
		 = (ExclusiveOrExpression)Expr_98_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = ExclusiveOrExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final AndExpression AndExpression_100_Var
		 = (AndExpression)Expr_99_list.get(0);
		Assert.assertNotNull(AndExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = AndExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final EqualityExpression EqualityExpression_101_Var
		 = (EqualityExpression)Expr_100_list.get(0);
		Assert.assertNotNull(EqualityExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = EqualityExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final RelationalExpression RelationalExpression_102_Var
		 = (RelationalExpression)Expr_101_list.get(0);
		Assert.assertNotNull(RelationalExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = RelationalExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final ShiftExpression ShiftExpression_103_Var
		 = (ShiftExpression)Expr_102_list.get(0);
		Assert.assertNotNull(ShiftExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = ShiftExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final AdditiveExpression AdditiveExpression_104_Var
		 = (AdditiveExpression)Expr_103_list.get(0);
		Assert.assertNotNull(AdditiveExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = AdditiveExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final MultiplicativeExpression MultiplicativeExpression_105_Var
		 = (MultiplicativeExpression)Expr_104_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = MultiplicativeExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final CastExpression CastExpression_106_Var
		 = (CastExpression)Expr_105_list.get(0);
		Assert.assertNotNull(CastExpression_106_Var
		);
		//106
		final UnaryExpression UnaryExpression_107_Var
		 = (UnaryExpression)CastExpression_106_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_107_Var
		);
		//107
		final PostfixExpression PostfixExpression_108_Var
		 = (PostfixExpression)UnaryExpression_107_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = PostfixExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final PrimaryExpression PrimaryExpression_109_Var
		 = (PrimaryExpression)Expr_108_list.get(0);
		Assert.assertNotNull(PrimaryExpression_109_Var
		);
		Assert.assertEquals("num", PrimaryExpression_109_Var
		.getId());
		final EList<? extends EObject> Suffix_109_list = PostfixExpression_108_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_109_list);
		Assert.assertEquals(1, Suffix_109_list.size());
		//109
		final PostfixExpressionSuffixMinusMinus PostfixExpressionSuffixMinusMinus_110_Var
		 = (PostfixExpressionSuffixMinusMinus)Suffix_109_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixMinusMinus_110_Var
		);
		Assert.assertEquals(";", ExpressionStatement_92_Var
		.getSemi());
		//110
		final Statement Statement_111_Var
		 = (Statement)Statement_90_list.get(1);
		Assert.assertNotNull(Statement_111_Var
		);
		//111
		final JumpStatement JumpStatement_112_Var
		 = (JumpStatement)Statement_111_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_112_Var
		);
		Assert.assertEquals("break", JumpStatement_112_Var
		.getBreak());
	}
	
	@Test
	(timeout=1000
	)
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


