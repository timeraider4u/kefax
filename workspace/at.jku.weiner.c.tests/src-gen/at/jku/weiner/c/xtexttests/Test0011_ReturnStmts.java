package at.jku.weiner.c.xtexttests;

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
import at.jku.weiner.c.c.FunctionDeclarationSpecifiers;
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
import at.jku.weiner.c.c.FunctionDeclarationSpecifiers;
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
import at.jku.weiner.c.c.FunctionDeclarationSpecifiers;
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
import at.jku.weiner.c.c.FunctionDeclarationSpecifiers;
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
public class Test0011_ReturnStmts {
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
	
	@Before
	public void initialize(){
		this.testHelper = new LexerAndParserTest(lexer, 
			parser, tokenDefProvider);
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
			"res/Test0011_ReturnStmts.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_CHAR", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
				"RULE_CHAR_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_RIGHTBRACE", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
				"RULE_MINUS", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_RIGHTBRACE", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_DOUBLE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
				"RULE_FLOAT_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_RIGHTBRACE", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_FLOAT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
				"RULE_HEX_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_RIGHTBRACE", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_VOID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
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
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0011_ReturnStmts.c");
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
		Assert.assertEquals(5, External_1_list.size());
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
		Assert.assertEquals("char", TypeSpecifier_5_Var
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
		Assert.assertEquals("doSomething1", DirectDeclarator_7_Var
		.getId());
		//7
		final FunctionDefinition FunctionDefinition_8_Var
		 = (FunctionDefinition)ExternalDeclaration_2_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_8_Var
		);
		//8
		final BodyStatement BodyStatement_9_Var
		 = (BodyStatement)FunctionDefinition_8_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_9_Var
		);
		final EList<? extends EObject> BlockList_9_list = BodyStatement_9_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_9_list);
		Assert.assertEquals(1, BlockList_9_list.size());
		//9
		final BlockList BlockList_10_Var
		 = (BlockList)BlockList_9_list.get(0);
		Assert.assertNotNull(BlockList_10_Var
		);
		final EList<? extends EObject> Statement_10_list = BlockList_10_Var
		.getStatement();
		Assert.assertNotNull(Statement_10_list);
		Assert.assertEquals(1, Statement_10_list.size());
		//10
		final Statement Statement_11_Var
		 = (Statement)Statement_10_list.get(0);
		Assert.assertNotNull(Statement_11_Var
		);
		//11
		final JumpStatement JumpStatement_12_Var
		 = (JumpStatement)Statement_11_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_12_Var
		);
		//12
		final Expression Expression_13_Var
		 = (Expression)JumpStatement_12_Var
		.getExpr();
		Assert.assertNotNull(Expression_13_Var
		);
		final EList<? extends EObject> ExprExpr_13_list = Expression_13_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_13_list);
		Assert.assertEquals(1, ExprExpr_13_list.size());
		//13
		final AssignmentExpression AssignmentExpression_14_Var
		 = (AssignmentExpression)ExprExpr_13_list.get(0);
		Assert.assertNotNull(AssignmentExpression_14_Var
		);
		//14
		final ConditionalExpression ConditionalExpression_15_Var
		 = (ConditionalExpression)AssignmentExpression_14_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_15_Var
		);
		//15
		final LogicalOrExpression LogicalOrExpression_16_Var
		 = (LogicalOrExpression)ConditionalExpression_15_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = LogicalOrExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final LogicalAndExpression LogicalAndExpression_17_Var
		 = (LogicalAndExpression)Expr_16_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = LogicalAndExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final InclusiveOrExpression InclusiveOrExpression_18_Var
		 = (InclusiveOrExpression)Expr_17_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = InclusiveOrExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final ExclusiveOrExpression ExclusiveOrExpression_19_Var
		 = (ExclusiveOrExpression)Expr_18_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = ExclusiveOrExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final AndExpression AndExpression_20_Var
		 = (AndExpression)Expr_19_list.get(0);
		Assert.assertNotNull(AndExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = AndExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final EqualityExpression EqualityExpression_21_Var
		 = (EqualityExpression)Expr_20_list.get(0);
		Assert.assertNotNull(EqualityExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = EqualityExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final RelationalExpression RelationalExpression_22_Var
		 = (RelationalExpression)Expr_21_list.get(0);
		Assert.assertNotNull(RelationalExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = RelationalExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final ShiftExpression ShiftExpression_23_Var
		 = (ShiftExpression)Expr_22_list.get(0);
		Assert.assertNotNull(ShiftExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = ShiftExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final AdditiveExpression AdditiveExpression_24_Var
		 = (AdditiveExpression)Expr_23_list.get(0);
		Assert.assertNotNull(AdditiveExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = AdditiveExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final MultiplicativeExpression MultiplicativeExpression_25_Var
		 = (MultiplicativeExpression)Expr_24_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = MultiplicativeExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final CastExpression CastExpression_26_Var
		 = (CastExpression)Expr_25_list.get(0);
		Assert.assertNotNull(CastExpression_26_Var
		);
		//26
		final UnaryExpression UnaryExpression_27_Var
		 = (UnaryExpression)CastExpression_26_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_27_Var
		);
		//27
		final PostfixExpression PostfixExpression_28_Var
		 = (PostfixExpression)UnaryExpression_27_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = PostfixExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final PrimaryExpression PrimaryExpression_29_Var
		 = (PrimaryExpression)Expr_28_list.get(0);
		Assert.assertNotNull(PrimaryExpression_29_Var
		);
		//29
		final Constant Constant_30_Var
		 = (Constant)PrimaryExpression_29_Var
		.getConst();
		Assert.assertNotNull(Constant_30_Var
		);
		Assert.assertEquals("'a'", Constant_30_Var
		.getCh());
		Assert.assertEquals("return", JumpStatement_12_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_12_Var
		.getSemi());
		//30
		final ExternalDeclaration ExternalDeclaration_31_Var
		 = (ExternalDeclaration)External_1_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_31_Var
		);
		//31
		final FunctionDefHead FunctionDefHead_32_Var
		 = (FunctionDefHead)ExternalDeclaration_31_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_32_Var
		);
		//32
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_33_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_32_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_33_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_33_list = FunctionDeclarationSpecifiers_33_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_33_list);
		Assert.assertEquals(1, DeclarationSpecifier_33_list.size());
		//33
		final TypeSpecifier TypeSpecifier_34_Var
		 = (TypeSpecifier)DeclarationSpecifier_33_list.get(0);
		Assert.assertNotNull(TypeSpecifier_34_Var
		);
		Assert.assertEquals("int", TypeSpecifier_34_Var
		.getName());
		//34
		final Declarator Declarator_35_Var
		 = (Declarator)FunctionDefHead_32_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_35_Var
		);
		//35
		final DirectDeclarator DirectDeclarator_36_Var
		 = (DirectDeclarator)Declarator_35_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_36_Var
		);
		Assert.assertEquals("doSomething2", DirectDeclarator_36_Var
		.getId());
		//36
		final FunctionDefinition FunctionDefinition_37_Var
		 = (FunctionDefinition)ExternalDeclaration_31_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_37_Var
		);
		//37
		final BodyStatement BodyStatement_38_Var
		 = (BodyStatement)FunctionDefinition_37_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_38_Var
		);
		final EList<? extends EObject> BlockList_38_list = BodyStatement_38_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_38_list);
		Assert.assertEquals(1, BlockList_38_list.size());
		//38
		final BlockList BlockList_39_Var
		 = (BlockList)BlockList_38_list.get(0);
		Assert.assertNotNull(BlockList_39_Var
		);
		final EList<? extends EObject> Statement_39_list = BlockList_39_Var
		.getStatement();
		Assert.assertNotNull(Statement_39_list);
		Assert.assertEquals(1, Statement_39_list.size());
		//39
		final Statement Statement_40_Var
		 = (Statement)Statement_39_list.get(0);
		Assert.assertNotNull(Statement_40_Var
		);
		//40
		final JumpStatement JumpStatement_41_Var
		 = (JumpStatement)Statement_40_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_41_Var
		);
		//41
		final Expression Expression_42_Var
		 = (Expression)JumpStatement_41_Var
		.getExpr();
		Assert.assertNotNull(Expression_42_Var
		);
		final EList<? extends EObject> ExprExpr_42_list = Expression_42_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_42_list);
		Assert.assertEquals(1, ExprExpr_42_list.size());
		//42
		final AssignmentExpression AssignmentExpression_43_Var
		 = (AssignmentExpression)ExprExpr_42_list.get(0);
		Assert.assertNotNull(AssignmentExpression_43_Var
		);
		//43
		final ConditionalExpression ConditionalExpression_44_Var
		 = (ConditionalExpression)AssignmentExpression_43_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_44_Var
		);
		//44
		final LogicalOrExpression LogicalOrExpression_45_Var
		 = (LogicalOrExpression)ConditionalExpression_44_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = LogicalOrExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final LogicalAndExpression LogicalAndExpression_46_Var
		 = (LogicalAndExpression)Expr_45_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = LogicalAndExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final InclusiveOrExpression InclusiveOrExpression_47_Var
		 = (InclusiveOrExpression)Expr_46_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = InclusiveOrExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final ExclusiveOrExpression ExclusiveOrExpression_48_Var
		 = (ExclusiveOrExpression)Expr_47_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = ExclusiveOrExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final AndExpression AndExpression_49_Var
		 = (AndExpression)Expr_48_list.get(0);
		Assert.assertNotNull(AndExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = AndExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final EqualityExpression EqualityExpression_50_Var
		 = (EqualityExpression)Expr_49_list.get(0);
		Assert.assertNotNull(EqualityExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = EqualityExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final RelationalExpression RelationalExpression_51_Var
		 = (RelationalExpression)Expr_50_list.get(0);
		Assert.assertNotNull(RelationalExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = RelationalExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final ShiftExpression ShiftExpression_52_Var
		 = (ShiftExpression)Expr_51_list.get(0);
		Assert.assertNotNull(ShiftExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = ShiftExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final AdditiveExpression AdditiveExpression_53_Var
		 = (AdditiveExpression)Expr_52_list.get(0);
		Assert.assertNotNull(AdditiveExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = AdditiveExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final MultiplicativeExpression MultiplicativeExpression_54_Var
		 = (MultiplicativeExpression)Expr_53_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = MultiplicativeExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final CastExpression CastExpression_55_Var
		 = (CastExpression)Expr_54_list.get(0);
		Assert.assertNotNull(CastExpression_55_Var
		);
		//55
		final UnaryExpression UnaryExpression_56_Var
		 = (UnaryExpression)CastExpression_55_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_56_Var
		);
		//56
		final CastExpression CastExpression_57_Var
		 = (CastExpression)UnaryExpression_56_Var
		.getExpr();
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
		//60
		final Constant Constant_61_Var
		 = (Constant)PrimaryExpression_60_Var
		.getConst();
		Assert.assertNotNull(Constant_61_Var
		);
		Assert.assertEquals("1", Constant_61_Var
		.getDec());
		//61
		final UnaryOperator UnaryOperator_62_Var
		 = (UnaryOperator)UnaryExpression_56_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_62_Var
		);
		Assert.assertEquals("-", UnaryOperator_62_Var
		.getOp());
		Assert.assertEquals("return", JumpStatement_41_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_41_Var
		.getSemi());
		//62
		final ExternalDeclaration ExternalDeclaration_63_Var
		 = (ExternalDeclaration)External_1_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_63_Var
		);
		//63
		final FunctionDefHead FunctionDefHead_64_Var
		 = (FunctionDefHead)ExternalDeclaration_63_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_64_Var
		);
		//64
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_65_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_64_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_65_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_65_list = FunctionDeclarationSpecifiers_65_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_65_list);
		Assert.assertEquals(1, DeclarationSpecifier_65_list.size());
		//65
		final TypeSpecifier TypeSpecifier_66_Var
		 = (TypeSpecifier)DeclarationSpecifier_65_list.get(0);
		Assert.assertNotNull(TypeSpecifier_66_Var
		);
		Assert.assertEquals("double", TypeSpecifier_66_Var
		.getName());
		//66
		final Declarator Declarator_67_Var
		 = (Declarator)FunctionDefHead_64_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_67_Var
		);
		//67
		final DirectDeclarator DirectDeclarator_68_Var
		 = (DirectDeclarator)Declarator_67_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_68_Var
		);
		Assert.assertEquals("doSomething3", DirectDeclarator_68_Var
		.getId());
		//68
		final FunctionDefinition FunctionDefinition_69_Var
		 = (FunctionDefinition)ExternalDeclaration_63_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_69_Var
		);
		//69
		final BodyStatement BodyStatement_70_Var
		 = (BodyStatement)FunctionDefinition_69_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_70_Var
		);
		final EList<? extends EObject> BlockList_70_list = BodyStatement_70_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_70_list);
		Assert.assertEquals(1, BlockList_70_list.size());
		//70
		final BlockList BlockList_71_Var
		 = (BlockList)BlockList_70_list.get(0);
		Assert.assertNotNull(BlockList_71_Var
		);
		final EList<? extends EObject> Statement_71_list = BlockList_71_Var
		.getStatement();
		Assert.assertNotNull(Statement_71_list);
		Assert.assertEquals(1, Statement_71_list.size());
		//71
		final Statement Statement_72_Var
		 = (Statement)Statement_71_list.get(0);
		Assert.assertNotNull(Statement_72_Var
		);
		//72
		final JumpStatement JumpStatement_73_Var
		 = (JumpStatement)Statement_72_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_73_Var
		);
		//73
		final Expression Expression_74_Var
		 = (Expression)JumpStatement_73_Var
		.getExpr();
		Assert.assertNotNull(Expression_74_Var
		);
		final EList<? extends EObject> ExprExpr_74_list = Expression_74_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_74_list);
		Assert.assertEquals(1, ExprExpr_74_list.size());
		//74
		final AssignmentExpression AssignmentExpression_75_Var
		 = (AssignmentExpression)ExprExpr_74_list.get(0);
		Assert.assertNotNull(AssignmentExpression_75_Var
		);
		//75
		final ConditionalExpression ConditionalExpression_76_Var
		 = (ConditionalExpression)AssignmentExpression_75_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_76_Var
		);
		//76
		final LogicalOrExpression LogicalOrExpression_77_Var
		 = (LogicalOrExpression)ConditionalExpression_76_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = LogicalOrExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final LogicalAndExpression LogicalAndExpression_78_Var
		 = (LogicalAndExpression)Expr_77_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = LogicalAndExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final InclusiveOrExpression InclusiveOrExpression_79_Var
		 = (InclusiveOrExpression)Expr_78_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = InclusiveOrExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final ExclusiveOrExpression ExclusiveOrExpression_80_Var
		 = (ExclusiveOrExpression)Expr_79_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = ExclusiveOrExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final AndExpression AndExpression_81_Var
		 = (AndExpression)Expr_80_list.get(0);
		Assert.assertNotNull(AndExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = AndExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final EqualityExpression EqualityExpression_82_Var
		 = (EqualityExpression)Expr_81_list.get(0);
		Assert.assertNotNull(EqualityExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = EqualityExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final RelationalExpression RelationalExpression_83_Var
		 = (RelationalExpression)Expr_82_list.get(0);
		Assert.assertNotNull(RelationalExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = RelationalExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final ShiftExpression ShiftExpression_84_Var
		 = (ShiftExpression)Expr_83_list.get(0);
		Assert.assertNotNull(ShiftExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = ShiftExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final AdditiveExpression AdditiveExpression_85_Var
		 = (AdditiveExpression)Expr_84_list.get(0);
		Assert.assertNotNull(AdditiveExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = AdditiveExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final MultiplicativeExpression MultiplicativeExpression_86_Var
		 = (MultiplicativeExpression)Expr_85_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = MultiplicativeExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final CastExpression CastExpression_87_Var
		 = (CastExpression)Expr_86_list.get(0);
		Assert.assertNotNull(CastExpression_87_Var
		);
		//87
		final UnaryExpression UnaryExpression_88_Var
		 = (UnaryExpression)CastExpression_87_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_88_Var
		);
		//88
		final PostfixExpression PostfixExpression_89_Var
		 = (PostfixExpression)UnaryExpression_88_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = PostfixExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final PrimaryExpression PrimaryExpression_90_Var
		 = (PrimaryExpression)Expr_89_list.get(0);
		Assert.assertNotNull(PrimaryExpression_90_Var
		);
		//90
		final Constant Constant_91_Var
		 = (Constant)PrimaryExpression_90_Var
		.getConst();
		Assert.assertNotNull(Constant_91_Var
		);
		Assert.assertEquals("0.8", Constant_91_Var
		.getFloat());
		Assert.assertEquals("return", JumpStatement_73_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_73_Var
		.getSemi());
		//91
		final ExternalDeclaration ExternalDeclaration_92_Var
		 = (ExternalDeclaration)External_1_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_92_Var
		);
		//92
		final FunctionDefHead FunctionDefHead_93_Var
		 = (FunctionDefHead)ExternalDeclaration_92_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_93_Var
		);
		//93
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_94_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_93_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_94_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_94_list = FunctionDeclarationSpecifiers_94_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_94_list);
		Assert.assertEquals(1, DeclarationSpecifier_94_list.size());
		//94
		final TypeSpecifier TypeSpecifier_95_Var
		 = (TypeSpecifier)DeclarationSpecifier_94_list.get(0);
		Assert.assertNotNull(TypeSpecifier_95_Var
		);
		Assert.assertEquals("float", TypeSpecifier_95_Var
		.getName());
		//95
		final Declarator Declarator_96_Var
		 = (Declarator)FunctionDefHead_93_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_96_Var
		);
		//96
		final DirectDeclarator DirectDeclarator_97_Var
		 = (DirectDeclarator)Declarator_96_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_97_Var
		);
		Assert.assertEquals("doSomething4", DirectDeclarator_97_Var
		.getId());
		//97
		final FunctionDefinition FunctionDefinition_98_Var
		 = (FunctionDefinition)ExternalDeclaration_92_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_98_Var
		);
		//98
		final BodyStatement BodyStatement_99_Var
		 = (BodyStatement)FunctionDefinition_98_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_99_Var
		);
		final EList<? extends EObject> BlockList_99_list = BodyStatement_99_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_99_list);
		Assert.assertEquals(1, BlockList_99_list.size());
		//99
		final BlockList BlockList_100_Var
		 = (BlockList)BlockList_99_list.get(0);
		Assert.assertNotNull(BlockList_100_Var
		);
		final EList<? extends EObject> Statement_100_list = BlockList_100_Var
		.getStatement();
		Assert.assertNotNull(Statement_100_list);
		Assert.assertEquals(1, Statement_100_list.size());
		//100
		final Statement Statement_101_Var
		 = (Statement)Statement_100_list.get(0);
		Assert.assertNotNull(Statement_101_Var
		);
		//101
		final JumpStatement JumpStatement_102_Var
		 = (JumpStatement)Statement_101_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_102_Var
		);
		//102
		final Expression Expression_103_Var
		 = (Expression)JumpStatement_102_Var
		.getExpr();
		Assert.assertNotNull(Expression_103_Var
		);
		final EList<? extends EObject> ExprExpr_103_list = Expression_103_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_103_list);
		Assert.assertEquals(1, ExprExpr_103_list.size());
		//103
		final AssignmentExpression AssignmentExpression_104_Var
		 = (AssignmentExpression)ExprExpr_103_list.get(0);
		Assert.assertNotNull(AssignmentExpression_104_Var
		);
		//104
		final ConditionalExpression ConditionalExpression_105_Var
		 = (ConditionalExpression)AssignmentExpression_104_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_105_Var
		);
		//105
		final LogicalOrExpression LogicalOrExpression_106_Var
		 = (LogicalOrExpression)ConditionalExpression_105_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = LogicalOrExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final LogicalAndExpression LogicalAndExpression_107_Var
		 = (LogicalAndExpression)Expr_106_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = LogicalAndExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final InclusiveOrExpression InclusiveOrExpression_108_Var
		 = (InclusiveOrExpression)Expr_107_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = InclusiveOrExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final ExclusiveOrExpression ExclusiveOrExpression_109_Var
		 = (ExclusiveOrExpression)Expr_108_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = ExclusiveOrExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final AndExpression AndExpression_110_Var
		 = (AndExpression)Expr_109_list.get(0);
		Assert.assertNotNull(AndExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = AndExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final EqualityExpression EqualityExpression_111_Var
		 = (EqualityExpression)Expr_110_list.get(0);
		Assert.assertNotNull(EqualityExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = EqualityExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final RelationalExpression RelationalExpression_112_Var
		 = (RelationalExpression)Expr_111_list.get(0);
		Assert.assertNotNull(RelationalExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = RelationalExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final ShiftExpression ShiftExpression_113_Var
		 = (ShiftExpression)Expr_112_list.get(0);
		Assert.assertNotNull(ShiftExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = ShiftExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final AdditiveExpression AdditiveExpression_114_Var
		 = (AdditiveExpression)Expr_113_list.get(0);
		Assert.assertNotNull(AdditiveExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = AdditiveExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final MultiplicativeExpression MultiplicativeExpression_115_Var
		 = (MultiplicativeExpression)Expr_114_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = MultiplicativeExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final CastExpression CastExpression_116_Var
		 = (CastExpression)Expr_115_list.get(0);
		Assert.assertNotNull(CastExpression_116_Var
		);
		//116
		final UnaryExpression UnaryExpression_117_Var
		 = (UnaryExpression)CastExpression_116_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_117_Var
		);
		//117
		final PostfixExpression PostfixExpression_118_Var
		 = (PostfixExpression)UnaryExpression_117_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = PostfixExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final PrimaryExpression PrimaryExpression_119_Var
		 = (PrimaryExpression)Expr_118_list.get(0);
		Assert.assertNotNull(PrimaryExpression_119_Var
		);
		//119
		final Constant Constant_120_Var
		 = (Constant)PrimaryExpression_119_Var
		.getConst();
		Assert.assertNotNull(Constant_120_Var
		);
		Assert.assertEquals("0x01A", Constant_120_Var
		.getHex());
		Assert.assertEquals("return", JumpStatement_102_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_102_Var
		.getSemi());
		//120
		final ExternalDeclaration ExternalDeclaration_121_Var
		 = (ExternalDeclaration)External_1_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_121_Var
		);
		//121
		final FunctionDefHead FunctionDefHead_122_Var
		 = (FunctionDefHead)ExternalDeclaration_121_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_122_Var
		);
		//122
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_123_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_122_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_123_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_123_list = FunctionDeclarationSpecifiers_123_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_123_list);
		Assert.assertEquals(1, DeclarationSpecifier_123_list.size());
		//123
		final TypeSpecifier TypeSpecifier_124_Var
		 = (TypeSpecifier)DeclarationSpecifier_123_list.get(0);
		Assert.assertNotNull(TypeSpecifier_124_Var
		);
		Assert.assertEquals("void", TypeSpecifier_124_Var
		.getName());
		//124
		final Declarator Declarator_125_Var
		 = (Declarator)FunctionDefHead_122_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_125_Var
		);
		//125
		final DirectDeclarator DirectDeclarator_126_Var
		 = (DirectDeclarator)Declarator_125_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_126_Var
		);
		Assert.assertEquals("doSomething5", DirectDeclarator_126_Var
		.getId());
		//126
		final FunctionDefinition FunctionDefinition_127_Var
		 = (FunctionDefinition)ExternalDeclaration_121_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_127_Var
		);
		//127
		final BodyStatement BodyStatement_128_Var
		 = (BodyStatement)FunctionDefinition_127_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_128_Var
		);
		final EList<? extends EObject> BlockList_128_list = BodyStatement_128_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_128_list);
		Assert.assertEquals(1, BlockList_128_list.size());
		//128
		final BlockList BlockList_129_Var
		 = (BlockList)BlockList_128_list.get(0);
		Assert.assertNotNull(BlockList_129_Var
		);
		final EList<? extends EObject> Statement_129_list = BlockList_129_Var
		.getStatement();
		Assert.assertNotNull(Statement_129_list);
		Assert.assertEquals(1, Statement_129_list.size());
		//129
		final Statement Statement_130_Var
		 = (Statement)Statement_129_list.get(0);
		Assert.assertNotNull(Statement_130_Var
		);
		//130
		final JumpStatement JumpStatement_131_Var
		 = (JumpStatement)Statement_130_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_131_Var
		);
		Assert.assertEquals("return", JumpStatement_131_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_131_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0011_ReturnStmts.c");
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
				method.invoke(this.generator, "Test0011_ReturnStmts.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0011_ReturnStmts.c");
		final String expected = this.getTextFromFile(
			"res/Test0011_ReturnStmts.c"
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


