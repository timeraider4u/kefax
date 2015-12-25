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
import at.jku.weiner.c.parser.parser.SelectionStatement;
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
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
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
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.SelectionStatement;
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
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.CompoundStatement;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
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
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.CompoundStatement;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
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
import at.jku.weiner.c.common.common.Constant2;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0021_IfElse {
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
	
	@Test
	public void checkLexerTokens() throws Exception{
		final String text = this.getTextFromFile(
			"res/Test0021_IfElse.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_INT", 
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
				"RULE_KW_IF", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_GREATER", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_ELSE", 
				"RULE_WHITESPACE", 
				"RULE_KW_IF", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_EQUAL", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_SKW_RIGHTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_ELSE", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
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
			"res/Test0021_IfElse.c");
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
		Assert.assertEquals("int", TypeSpecifier_4_Var
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
		Assert.assertEquals("doSomething", DirectDeclarator_6_Var
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
		Assert.assertEquals("argc", DirectDeclarator_15_Var
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
		final SelectionStatement SelectionStatement_20_Var
		 = (SelectionStatement)Statement_19_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_20_Var
		);
		Assert.assertEquals("if", SelectionStatement_20_Var
		.getIf());
		//20
		final Expression Expression_21_Var
		 = (Expression)SelectionStatement_20_Var
		.getExpr();
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
		final ConditionalExpression ConditionalExpression_23_Var
		 = (ConditionalExpression)AssignmentExpression_22_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_23_Var
		);
		//23
		final LogicalOrExpression LogicalOrExpression_24_Var
		 = (LogicalOrExpression)ConditionalExpression_23_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = LogicalOrExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final LogicalAndExpression LogicalAndExpression_25_Var
		 = (LogicalAndExpression)Expr_24_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = LogicalAndExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final InclusiveOrExpression InclusiveOrExpression_26_Var
		 = (InclusiveOrExpression)Expr_25_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = InclusiveOrExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final ExclusiveOrExpression ExclusiveOrExpression_27_Var
		 = (ExclusiveOrExpression)Expr_26_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = ExclusiveOrExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final AndExpression AndExpression_28_Var
		 = (AndExpression)Expr_27_list.get(0);
		Assert.assertNotNull(AndExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = AndExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final EqualityExpression EqualityExpression_29_Var
		 = (EqualityExpression)Expr_28_list.get(0);
		Assert.assertNotNull(EqualityExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = EqualityExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final RelationalExpression RelationalExpression_30_Var
		 = (RelationalExpression)Expr_29_list.get(0);
		Assert.assertNotNull(RelationalExpression_30_Var
		);
		Assert.assertEquals("[>]", RelationalExpression_30_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_30_list = RelationalExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(2, Expr_30_list.size());
		//30
		final ShiftExpression ShiftExpression_31_Var
		 = (ShiftExpression)Expr_30_list.get(0);
		Assert.assertNotNull(ShiftExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = ShiftExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final AdditiveExpression AdditiveExpression_32_Var
		 = (AdditiveExpression)Expr_31_list.get(0);
		Assert.assertNotNull(AdditiveExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = AdditiveExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final MultiplicativeExpression MultiplicativeExpression_33_Var
		 = (MultiplicativeExpression)Expr_32_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = MultiplicativeExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final CastExpression CastExpression_34_Var
		 = (CastExpression)Expr_33_list.get(0);
		Assert.assertNotNull(CastExpression_34_Var
		);
		//34
		final UnaryExpression UnaryExpression_35_Var
		 = (UnaryExpression)CastExpression_34_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_35_Var
		);
		//35
		final PostfixExpression PostfixExpression_36_Var
		 = (PostfixExpression)UnaryExpression_35_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = PostfixExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final PrimaryExpression PrimaryExpression_37_Var
		 = (PrimaryExpression)Expr_36_list.get(0);
		Assert.assertNotNull(PrimaryExpression_37_Var
		);
		Assert.assertEquals("argc", PrimaryExpression_37_Var
		.getId());
		//37
		final ShiftExpression ShiftExpression_38_Var
		 = (ShiftExpression)Expr_30_list.get(1);
		Assert.assertNotNull(ShiftExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = ShiftExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final AdditiveExpression AdditiveExpression_39_Var
		 = (AdditiveExpression)Expr_38_list.get(0);
		Assert.assertNotNull(AdditiveExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = AdditiveExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final MultiplicativeExpression MultiplicativeExpression_40_Var
		 = (MultiplicativeExpression)Expr_39_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = MultiplicativeExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final CastExpression CastExpression_41_Var
		 = (CastExpression)Expr_40_list.get(0);
		Assert.assertNotNull(CastExpression_41_Var
		);
		//41
		final UnaryExpression UnaryExpression_42_Var
		 = (UnaryExpression)CastExpression_41_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_42_Var
		);
		//42
		final PostfixExpression PostfixExpression_43_Var
		 = (PostfixExpression)UnaryExpression_42_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = PostfixExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final PrimaryExpression PrimaryExpression_44_Var
		 = (PrimaryExpression)Expr_43_list.get(0);
		Assert.assertNotNull(PrimaryExpression_44_Var
		);
		//44
		final Constant2 Constant2_45_Var
		 = (Constant2)PrimaryExpression_44_Var
		.getConst();
		Assert.assertNotNull(Constant2_45_Var
		);
		Assert.assertEquals("0", Constant2_45_Var
		.getDec());
		//45
		final Statement Statement_46_Var
		 = (Statement)SelectionStatement_20_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_46_Var
		);
		//46
		final JumpStatement JumpStatement_47_Var
		 = (JumpStatement)Statement_46_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_47_Var
		);
		//47
		final Expression Expression_48_Var
		 = (Expression)JumpStatement_47_Var
		.getExpr();
		Assert.assertNotNull(Expression_48_Var
		);
		final EList<? extends EObject> ExprExpr_48_list = Expression_48_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_48_list);
		Assert.assertEquals(1, ExprExpr_48_list.size());
		//48
		final AssignmentExpression AssignmentExpression_49_Var
		 = (AssignmentExpression)ExprExpr_48_list.get(0);
		Assert.assertNotNull(AssignmentExpression_49_Var
		);
		//49
		final ConditionalExpression ConditionalExpression_50_Var
		 = (ConditionalExpression)AssignmentExpression_49_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_50_Var
		);
		//50
		final LogicalOrExpression LogicalOrExpression_51_Var
		 = (LogicalOrExpression)ConditionalExpression_50_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = LogicalOrExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final LogicalAndExpression LogicalAndExpression_52_Var
		 = (LogicalAndExpression)Expr_51_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = LogicalAndExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final InclusiveOrExpression InclusiveOrExpression_53_Var
		 = (InclusiveOrExpression)Expr_52_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = InclusiveOrExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final ExclusiveOrExpression ExclusiveOrExpression_54_Var
		 = (ExclusiveOrExpression)Expr_53_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = ExclusiveOrExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final AndExpression AndExpression_55_Var
		 = (AndExpression)Expr_54_list.get(0);
		Assert.assertNotNull(AndExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = AndExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final EqualityExpression EqualityExpression_56_Var
		 = (EqualityExpression)Expr_55_list.get(0);
		Assert.assertNotNull(EqualityExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = EqualityExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final RelationalExpression RelationalExpression_57_Var
		 = (RelationalExpression)Expr_56_list.get(0);
		Assert.assertNotNull(RelationalExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = RelationalExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final ShiftExpression ShiftExpression_58_Var
		 = (ShiftExpression)Expr_57_list.get(0);
		Assert.assertNotNull(ShiftExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = ShiftExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final AdditiveExpression AdditiveExpression_59_Var
		 = (AdditiveExpression)Expr_58_list.get(0);
		Assert.assertNotNull(AdditiveExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = AdditiveExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final MultiplicativeExpression MultiplicativeExpression_60_Var
		 = (MultiplicativeExpression)Expr_59_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = MultiplicativeExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final CastExpression CastExpression_61_Var
		 = (CastExpression)Expr_60_list.get(0);
		Assert.assertNotNull(CastExpression_61_Var
		);
		//61
		final UnaryExpression UnaryExpression_62_Var
		 = (UnaryExpression)CastExpression_61_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_62_Var
		);
		//62
		final PostfixExpression PostfixExpression_63_Var
		 = (PostfixExpression)UnaryExpression_62_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = PostfixExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final PrimaryExpression PrimaryExpression_64_Var
		 = (PrimaryExpression)Expr_63_list.get(0);
		Assert.assertNotNull(PrimaryExpression_64_Var
		);
		//64
		final Constant2 Constant2_65_Var
		 = (Constant2)PrimaryExpression_64_Var
		.getConst();
		Assert.assertNotNull(Constant2_65_Var
		);
		Assert.assertEquals("0", Constant2_65_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_47_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_47_Var
		.getSemi());
		//65
		final Statement Statement_66_Var
		 = (Statement)SelectionStatement_20_Var
		.getElseStatement();
		Assert.assertNotNull(Statement_66_Var
		);
		//66
		final SelectionStatement SelectionStatement_67_Var
		 = (SelectionStatement)Statement_66_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_67_Var
		);
		Assert.assertEquals("if", SelectionStatement_67_Var
		.getIf());
		//67
		final Expression Expression_68_Var
		 = (Expression)SelectionStatement_67_Var
		.getExpr();
		Assert.assertNotNull(Expression_68_Var
		);
		final EList<? extends EObject> ExprExpr_68_list = Expression_68_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_68_list);
		Assert.assertEquals(1, ExprExpr_68_list.size());
		//68
		final AssignmentExpression AssignmentExpression_69_Var
		 = (AssignmentExpression)ExprExpr_68_list.get(0);
		Assert.assertNotNull(AssignmentExpression_69_Var
		);
		//69
		final ConditionalExpression ConditionalExpression_70_Var
		 = (ConditionalExpression)AssignmentExpression_69_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_70_Var
		);
		//70
		final LogicalOrExpression LogicalOrExpression_71_Var
		 = (LogicalOrExpression)ConditionalExpression_70_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = LogicalOrExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final LogicalAndExpression LogicalAndExpression_72_Var
		 = (LogicalAndExpression)Expr_71_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = LogicalAndExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final InclusiveOrExpression InclusiveOrExpression_73_Var
		 = (InclusiveOrExpression)Expr_72_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = InclusiveOrExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final ExclusiveOrExpression ExclusiveOrExpression_74_Var
		 = (ExclusiveOrExpression)Expr_73_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = ExclusiveOrExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final AndExpression AndExpression_75_Var
		 = (AndExpression)Expr_74_list.get(0);
		Assert.assertNotNull(AndExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = AndExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final EqualityExpression EqualityExpression_76_Var
		 = (EqualityExpression)Expr_75_list.get(0);
		Assert.assertNotNull(EqualityExpression_76_Var
		);
		Assert.assertEquals("[==]", EqualityExpression_76_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_76_list = EqualityExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(2, Expr_76_list.size());
		//76
		final RelationalExpression RelationalExpression_77_Var
		 = (RelationalExpression)Expr_76_list.get(0);
		Assert.assertNotNull(RelationalExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = RelationalExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final ShiftExpression ShiftExpression_78_Var
		 = (ShiftExpression)Expr_77_list.get(0);
		Assert.assertNotNull(ShiftExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = ShiftExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final AdditiveExpression AdditiveExpression_79_Var
		 = (AdditiveExpression)Expr_78_list.get(0);
		Assert.assertNotNull(AdditiveExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = AdditiveExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final MultiplicativeExpression MultiplicativeExpression_80_Var
		 = (MultiplicativeExpression)Expr_79_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = MultiplicativeExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final CastExpression CastExpression_81_Var
		 = (CastExpression)Expr_80_list.get(0);
		Assert.assertNotNull(CastExpression_81_Var
		);
		//81
		final UnaryExpression UnaryExpression_82_Var
		 = (UnaryExpression)CastExpression_81_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_82_Var
		);
		//82
		final PostfixExpression PostfixExpression_83_Var
		 = (PostfixExpression)UnaryExpression_82_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = PostfixExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final PrimaryExpression PrimaryExpression_84_Var
		 = (PrimaryExpression)Expr_83_list.get(0);
		Assert.assertNotNull(PrimaryExpression_84_Var
		);
		Assert.assertEquals("argc", PrimaryExpression_84_Var
		.getId());
		//84
		final RelationalExpression RelationalExpression_85_Var
		 = (RelationalExpression)Expr_76_list.get(1);
		Assert.assertNotNull(RelationalExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = RelationalExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final ShiftExpression ShiftExpression_86_Var
		 = (ShiftExpression)Expr_85_list.get(0);
		Assert.assertNotNull(ShiftExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = ShiftExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final AdditiveExpression AdditiveExpression_87_Var
		 = (AdditiveExpression)Expr_86_list.get(0);
		Assert.assertNotNull(AdditiveExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = AdditiveExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final MultiplicativeExpression MultiplicativeExpression_88_Var
		 = (MultiplicativeExpression)Expr_87_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = MultiplicativeExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final CastExpression CastExpression_89_Var
		 = (CastExpression)Expr_88_list.get(0);
		Assert.assertNotNull(CastExpression_89_Var
		);
		//89
		final UnaryExpression UnaryExpression_90_Var
		 = (UnaryExpression)CastExpression_89_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_90_Var
		);
		//90
		final PostfixExpression PostfixExpression_91_Var
		 = (PostfixExpression)UnaryExpression_90_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = PostfixExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final PrimaryExpression PrimaryExpression_92_Var
		 = (PrimaryExpression)Expr_91_list.get(0);
		Assert.assertNotNull(PrimaryExpression_92_Var
		);
		//92
		final Constant2 Constant2_93_Var
		 = (Constant2)PrimaryExpression_92_Var
		.getConst();
		Assert.assertNotNull(Constant2_93_Var
		);
		Assert.assertEquals("1", Constant2_93_Var
		.getDec());
		Assert.assertEquals("else", SelectionStatement_67_Var
		.getElse());
		//93
		final Statement Statement_94_Var
		 = (Statement)SelectionStatement_67_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_94_Var
		);
		//94
		final CompoundStatement CompoundStatement_95_Var
		 = (CompoundStatement)Statement_94_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_95_Var
		);
		//95
		final BodyStatement BodyStatement_96_Var
		 = (BodyStatement)CompoundStatement_95_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_96_Var
		);
		final EList<? extends EObject> BlockList_96_list = BodyStatement_96_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_96_list);
		Assert.assertEquals(1, BlockList_96_list.size());
		//96
		final BlockList BlockList_97_Var
		 = (BlockList)BlockList_96_list.get(0);
		Assert.assertNotNull(BlockList_97_Var
		);
		final EList<? extends EObject> Statement_97_list = BlockList_97_Var
		.getStatement();
		Assert.assertNotNull(Statement_97_list);
		Assert.assertEquals(1, Statement_97_list.size());
		//97
		final Statement Statement_98_Var
		 = (Statement)Statement_97_list.get(0);
		Assert.assertNotNull(Statement_98_Var
		);
		//98
		final JumpStatement JumpStatement_99_Var
		 = (JumpStatement)Statement_98_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_99_Var
		);
		//99
		final Expression Expression_100_Var
		 = (Expression)JumpStatement_99_Var
		.getExpr();
		Assert.assertNotNull(Expression_100_Var
		);
		final EList<? extends EObject> ExprExpr_100_list = Expression_100_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_100_list);
		Assert.assertEquals(1, ExprExpr_100_list.size());
		//100
		final AssignmentExpression AssignmentExpression_101_Var
		 = (AssignmentExpression)ExprExpr_100_list.get(0);
		Assert.assertNotNull(AssignmentExpression_101_Var
		);
		//101
		final ConditionalExpression ConditionalExpression_102_Var
		 = (ConditionalExpression)AssignmentExpression_101_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_102_Var
		);
		//102
		final LogicalOrExpression LogicalOrExpression_103_Var
		 = (LogicalOrExpression)ConditionalExpression_102_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = LogicalOrExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final LogicalAndExpression LogicalAndExpression_104_Var
		 = (LogicalAndExpression)Expr_103_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = LogicalAndExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final InclusiveOrExpression InclusiveOrExpression_105_Var
		 = (InclusiveOrExpression)Expr_104_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = InclusiveOrExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final ExclusiveOrExpression ExclusiveOrExpression_106_Var
		 = (ExclusiveOrExpression)Expr_105_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = ExclusiveOrExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final AndExpression AndExpression_107_Var
		 = (AndExpression)Expr_106_list.get(0);
		Assert.assertNotNull(AndExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = AndExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final EqualityExpression EqualityExpression_108_Var
		 = (EqualityExpression)Expr_107_list.get(0);
		Assert.assertNotNull(EqualityExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = EqualityExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final RelationalExpression RelationalExpression_109_Var
		 = (RelationalExpression)Expr_108_list.get(0);
		Assert.assertNotNull(RelationalExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = RelationalExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final ShiftExpression ShiftExpression_110_Var
		 = (ShiftExpression)Expr_109_list.get(0);
		Assert.assertNotNull(ShiftExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = ShiftExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final AdditiveExpression AdditiveExpression_111_Var
		 = (AdditiveExpression)Expr_110_list.get(0);
		Assert.assertNotNull(AdditiveExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = AdditiveExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final MultiplicativeExpression MultiplicativeExpression_112_Var
		 = (MultiplicativeExpression)Expr_111_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = MultiplicativeExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final CastExpression CastExpression_113_Var
		 = (CastExpression)Expr_112_list.get(0);
		Assert.assertNotNull(CastExpression_113_Var
		);
		//113
		final UnaryExpression UnaryExpression_114_Var
		 = (UnaryExpression)CastExpression_113_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_114_Var
		);
		//114
		final PostfixExpression PostfixExpression_115_Var
		 = (PostfixExpression)UnaryExpression_114_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = PostfixExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final PrimaryExpression PrimaryExpression_116_Var
		 = (PrimaryExpression)Expr_115_list.get(0);
		Assert.assertNotNull(PrimaryExpression_116_Var
		);
		//116
		final Constant2 Constant2_117_Var
		 = (Constant2)PrimaryExpression_116_Var
		.getConst();
		Assert.assertNotNull(Constant2_117_Var
		);
		Assert.assertEquals("1", Constant2_117_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_99_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_99_Var
		.getSemi());
		//117
		final Statement Statement_118_Var
		 = (Statement)SelectionStatement_67_Var
		.getElseStatement();
		Assert.assertNotNull(Statement_118_Var
		);
		//118
		final CompoundStatement CompoundStatement_119_Var
		 = (CompoundStatement)Statement_118_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_119_Var
		);
		//119
		final BodyStatement BodyStatement_120_Var
		 = (BodyStatement)CompoundStatement_119_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_120_Var
		);
		final EList<? extends EObject> BlockList_120_list = BodyStatement_120_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_120_list);
		Assert.assertEquals(1, BlockList_120_list.size());
		//120
		final BlockList BlockList_121_Var
		 = (BlockList)BlockList_120_list.get(0);
		Assert.assertNotNull(BlockList_121_Var
		);
		final EList<? extends EObject> Statement_121_list = BlockList_121_Var
		.getStatement();
		Assert.assertNotNull(Statement_121_list);
		Assert.assertEquals(1, Statement_121_list.size());
		//121
		final Statement Statement_122_Var
		 = (Statement)Statement_121_list.get(0);
		Assert.assertNotNull(Statement_122_Var
		);
		//122
		final JumpStatement JumpStatement_123_Var
		 = (JumpStatement)Statement_122_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_123_Var
		);
		//123
		final Expression Expression_124_Var
		 = (Expression)JumpStatement_123_Var
		.getExpr();
		Assert.assertNotNull(Expression_124_Var
		);
		final EList<? extends EObject> ExprExpr_124_list = Expression_124_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_124_list);
		Assert.assertEquals(1, ExprExpr_124_list.size());
		//124
		final AssignmentExpression AssignmentExpression_125_Var
		 = (AssignmentExpression)ExprExpr_124_list.get(0);
		Assert.assertNotNull(AssignmentExpression_125_Var
		);
		//125
		final ConditionalExpression ConditionalExpression_126_Var
		 = (ConditionalExpression)AssignmentExpression_125_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_126_Var
		);
		//126
		final LogicalOrExpression LogicalOrExpression_127_Var
		 = (LogicalOrExpression)ConditionalExpression_126_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = LogicalOrExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final LogicalAndExpression LogicalAndExpression_128_Var
		 = (LogicalAndExpression)Expr_127_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = LogicalAndExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final InclusiveOrExpression InclusiveOrExpression_129_Var
		 = (InclusiveOrExpression)Expr_128_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = InclusiveOrExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final ExclusiveOrExpression ExclusiveOrExpression_130_Var
		 = (ExclusiveOrExpression)Expr_129_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = ExclusiveOrExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final AndExpression AndExpression_131_Var
		 = (AndExpression)Expr_130_list.get(0);
		Assert.assertNotNull(AndExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = AndExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final EqualityExpression EqualityExpression_132_Var
		 = (EqualityExpression)Expr_131_list.get(0);
		Assert.assertNotNull(EqualityExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = EqualityExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final RelationalExpression RelationalExpression_133_Var
		 = (RelationalExpression)Expr_132_list.get(0);
		Assert.assertNotNull(RelationalExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = RelationalExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final ShiftExpression ShiftExpression_134_Var
		 = (ShiftExpression)Expr_133_list.get(0);
		Assert.assertNotNull(ShiftExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = ShiftExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final AdditiveExpression AdditiveExpression_135_Var
		 = (AdditiveExpression)Expr_134_list.get(0);
		Assert.assertNotNull(AdditiveExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = AdditiveExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final MultiplicativeExpression MultiplicativeExpression_136_Var
		 = (MultiplicativeExpression)Expr_135_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = MultiplicativeExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final CastExpression CastExpression_137_Var
		 = (CastExpression)Expr_136_list.get(0);
		Assert.assertNotNull(CastExpression_137_Var
		);
		//137
		final UnaryExpression UnaryExpression_138_Var
		 = (UnaryExpression)CastExpression_137_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_138_Var
		);
		//138
		final PostfixExpression PostfixExpression_139_Var
		 = (PostfixExpression)UnaryExpression_138_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = PostfixExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final PrimaryExpression PrimaryExpression_140_Var
		 = (PrimaryExpression)Expr_139_list.get(0);
		Assert.assertNotNull(PrimaryExpression_140_Var
		);
		//140
		final Constant2 Constant2_141_Var
		 = (Constant2)PrimaryExpression_140_Var
		.getConst();
		Assert.assertNotNull(Constant2_141_Var
		);
		Assert.assertEquals("2", Constant2_141_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_123_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_123_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0021_IfElse.c");
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
				method.invoke(this.generator, "Test0021_IfElse.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0021_IfElse.c");
		final String expected = this.getTextFromFile(
			"res/Test0021_IfElse.c"
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


