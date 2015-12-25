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

import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.common.common.TranslationUnit;
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
		final Model Model_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(Model_0_Var
		);
		
		Assert.assertNotNull(Model_0_Var
		);
		final EList<? extends EObject> Units_0_list = Model_0_Var
		.getUnits();
		Assert.assertNotNull(Units_0_list);
		Assert.assertEquals(1, Units_0_list.size());
		//0
		final TranslationUnit TranslationUnit_1_Var
		 = (TranslationUnit)Units_0_list.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var
		);
		//1
		final Parser Parser_2_Var
		 = (Parser)TranslationUnit_1_Var
		.getParser();
		Assert.assertNotNull(Parser_2_Var
		);
		final EList<? extends EObject> External_2_list = Parser_2_Var
		.getExternal();
		Assert.assertNotNull(External_2_list);
		Assert.assertEquals(1, External_2_list.size());
		//2
		final ExternalDeclaration ExternalDeclaration_3_Var
		 = (ExternalDeclaration)External_2_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_3_Var
		);
		//3
		final FunctionDefHead FunctionDefHead_4_Var
		 = (FunctionDefHead)ExternalDeclaration_3_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_4_Var
		);
		//4
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_5_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_4_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_5_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_5_list = FunctionDeclarationSpecifiers_5_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_5_list);
		Assert.assertEquals(1, DeclarationSpecifier_5_list.size());
		//5
		final TypeSpecifier TypeSpecifier_6_Var
		 = (TypeSpecifier)DeclarationSpecifier_5_list.get(0);
		Assert.assertNotNull(TypeSpecifier_6_Var
		);
		Assert.assertEquals("int", TypeSpecifier_6_Var
		.getName());
		//6
		final Declarator Declarator_7_Var
		 = (Declarator)FunctionDefHead_4_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_7_Var
		);
		//7
		final DirectDeclarator DirectDeclarator_8_Var
		 = (DirectDeclarator)Declarator_7_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_8_Var
		);
		Assert.assertEquals("doSomething", DirectDeclarator_8_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_8_list = DirectDeclarator_8_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_8_list);
		Assert.assertEquals(1, DeclaratorSuffix_8_list.size());
		//8
		final DeclaratorSuffix DeclaratorSuffix_9_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_8_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_9_Var
		);
		//9
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_10_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_9_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_10_Var
		);
		final EList<? extends EObject> ParameterTypeList_10_list = DirectDeclaratorLastSuffix_10_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_10_list);
		Assert.assertEquals(1, ParameterTypeList_10_list.size());
		//10
		final ParameterTypeList ParameterTypeList_11_Var
		 = (ParameterTypeList)ParameterTypeList_10_list.get(0);
		Assert.assertNotNull(ParameterTypeList_11_Var
		);
		//11
		final ParameterList ParameterList_12_Var
		 = (ParameterList)ParameterTypeList_11_Var
		.getList();
		Assert.assertNotNull(ParameterList_12_Var
		);
		final EList<? extends EObject> ParameterDeclaration_12_list = ParameterList_12_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_12_list);
		Assert.assertEquals(1, ParameterDeclaration_12_list.size());
		//12
		final ParameterDeclaration ParameterDeclaration_13_Var
		 = (ParameterDeclaration)ParameterDeclaration_12_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_13_Var
		);
		//13
		final DeclarationSpecifiers DeclarationSpecifiers_14_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_13_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_14_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_14_list = DeclarationSpecifiers_14_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_14_list);
		Assert.assertEquals(1, DeclarationSpecifier_14_list.size());
		//14
		final TypeSpecifier TypeSpecifier_15_Var
		 = (TypeSpecifier)DeclarationSpecifier_14_list.get(0);
		Assert.assertNotNull(TypeSpecifier_15_Var
		);
		Assert.assertEquals("int", TypeSpecifier_15_Var
		.getName());
		//15
		final Declarator Declarator_16_Var
		 = (Declarator)ParameterDeclaration_13_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_16_Var
		);
		//16
		final DirectDeclarator DirectDeclarator_17_Var
		 = (DirectDeclarator)Declarator_16_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_17_Var
		);
		Assert.assertEquals("argc", DirectDeclarator_17_Var
		.getId());
		//17
		final FunctionDefinition FunctionDefinition_18_Var
		 = (FunctionDefinition)ExternalDeclaration_3_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_18_Var
		);
		//18
		final BodyStatement BodyStatement_19_Var
		 = (BodyStatement)FunctionDefinition_18_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_19_Var
		);
		final EList<? extends EObject> BlockList_19_list = BodyStatement_19_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_19_list);
		Assert.assertEquals(1, BlockList_19_list.size());
		//19
		final BlockList BlockList_20_Var
		 = (BlockList)BlockList_19_list.get(0);
		Assert.assertNotNull(BlockList_20_Var
		);
		final EList<? extends EObject> Statement_20_list = BlockList_20_Var
		.getStatement();
		Assert.assertNotNull(Statement_20_list);
		Assert.assertEquals(1, Statement_20_list.size());
		//20
		final Statement Statement_21_Var
		 = (Statement)Statement_20_list.get(0);
		Assert.assertNotNull(Statement_21_Var
		);
		//21
		final SelectionStatement SelectionStatement_22_Var
		 = (SelectionStatement)Statement_21_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_22_Var
		);
		Assert.assertEquals("if", SelectionStatement_22_Var
		.getIf());
		//22
		final Expression Expression_23_Var
		 = (Expression)SelectionStatement_22_Var
		.getExpr();
		Assert.assertNotNull(Expression_23_Var
		);
		final EList<? extends EObject> ExprExpr_23_list = Expression_23_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_23_list);
		Assert.assertEquals(1, ExprExpr_23_list.size());
		//23
		final AssignmentExpression AssignmentExpression_24_Var
		 = (AssignmentExpression)ExprExpr_23_list.get(0);
		Assert.assertNotNull(AssignmentExpression_24_Var
		);
		//24
		final ConditionalExpression ConditionalExpression_25_Var
		 = (ConditionalExpression)AssignmentExpression_24_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_25_Var
		);
		//25
		final LogicalOrExpression LogicalOrExpression_26_Var
		 = (LogicalOrExpression)ConditionalExpression_25_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = LogicalOrExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final LogicalAndExpression LogicalAndExpression_27_Var
		 = (LogicalAndExpression)Expr_26_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = LogicalAndExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final InclusiveOrExpression InclusiveOrExpression_28_Var
		 = (InclusiveOrExpression)Expr_27_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = InclusiveOrExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final ExclusiveOrExpression ExclusiveOrExpression_29_Var
		 = (ExclusiveOrExpression)Expr_28_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = ExclusiveOrExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final AndExpression AndExpression_30_Var
		 = (AndExpression)Expr_29_list.get(0);
		Assert.assertNotNull(AndExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = AndExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final EqualityExpression EqualityExpression_31_Var
		 = (EqualityExpression)Expr_30_list.get(0);
		Assert.assertNotNull(EqualityExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = EqualityExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final RelationalExpression RelationalExpression_32_Var
		 = (RelationalExpression)Expr_31_list.get(0);
		Assert.assertNotNull(RelationalExpression_32_Var
		);
		Assert.assertEquals("[>]", RelationalExpression_32_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_32_list = RelationalExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(2, Expr_32_list.size());
		//32
		final ShiftExpression ShiftExpression_33_Var
		 = (ShiftExpression)Expr_32_list.get(0);
		Assert.assertNotNull(ShiftExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = ShiftExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final AdditiveExpression AdditiveExpression_34_Var
		 = (AdditiveExpression)Expr_33_list.get(0);
		Assert.assertNotNull(AdditiveExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = AdditiveExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final MultiplicativeExpression MultiplicativeExpression_35_Var
		 = (MultiplicativeExpression)Expr_34_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = MultiplicativeExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final CastExpression CastExpression_36_Var
		 = (CastExpression)Expr_35_list.get(0);
		Assert.assertNotNull(CastExpression_36_Var
		);
		//36
		final UnaryExpression UnaryExpression_37_Var
		 = (UnaryExpression)CastExpression_36_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_37_Var
		);
		//37
		final PostfixExpression PostfixExpression_38_Var
		 = (PostfixExpression)UnaryExpression_37_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = PostfixExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final PrimaryExpression PrimaryExpression_39_Var
		 = (PrimaryExpression)Expr_38_list.get(0);
		Assert.assertNotNull(PrimaryExpression_39_Var
		);
		Assert.assertEquals("argc", PrimaryExpression_39_Var
		.getId());
		//39
		final ShiftExpression ShiftExpression_40_Var
		 = (ShiftExpression)Expr_32_list.get(1);
		Assert.assertNotNull(ShiftExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = ShiftExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final AdditiveExpression AdditiveExpression_41_Var
		 = (AdditiveExpression)Expr_40_list.get(0);
		Assert.assertNotNull(AdditiveExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = AdditiveExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final MultiplicativeExpression MultiplicativeExpression_42_Var
		 = (MultiplicativeExpression)Expr_41_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = MultiplicativeExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final CastExpression CastExpression_43_Var
		 = (CastExpression)Expr_42_list.get(0);
		Assert.assertNotNull(CastExpression_43_Var
		);
		//43
		final UnaryExpression UnaryExpression_44_Var
		 = (UnaryExpression)CastExpression_43_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_44_Var
		);
		//44
		final PostfixExpression PostfixExpression_45_Var
		 = (PostfixExpression)UnaryExpression_44_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = PostfixExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final PrimaryExpression PrimaryExpression_46_Var
		 = (PrimaryExpression)Expr_45_list.get(0);
		Assert.assertNotNull(PrimaryExpression_46_Var
		);
		//46
		final Constant2 Constant2_47_Var
		 = (Constant2)PrimaryExpression_46_Var
		.getConst();
		Assert.assertNotNull(Constant2_47_Var
		);
		Assert.assertEquals("0", Constant2_47_Var
		.getDec());
		//47
		final Statement Statement_48_Var
		 = (Statement)SelectionStatement_22_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_48_Var
		);
		//48
		final JumpStatement JumpStatement_49_Var
		 = (JumpStatement)Statement_48_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_49_Var
		);
		//49
		final Expression Expression_50_Var
		 = (Expression)JumpStatement_49_Var
		.getExpr();
		Assert.assertNotNull(Expression_50_Var
		);
		final EList<? extends EObject> ExprExpr_50_list = Expression_50_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_50_list);
		Assert.assertEquals(1, ExprExpr_50_list.size());
		//50
		final AssignmentExpression AssignmentExpression_51_Var
		 = (AssignmentExpression)ExprExpr_50_list.get(0);
		Assert.assertNotNull(AssignmentExpression_51_Var
		);
		//51
		final ConditionalExpression ConditionalExpression_52_Var
		 = (ConditionalExpression)AssignmentExpression_51_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_52_Var
		);
		//52
		final LogicalOrExpression LogicalOrExpression_53_Var
		 = (LogicalOrExpression)ConditionalExpression_52_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = LogicalOrExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final LogicalAndExpression LogicalAndExpression_54_Var
		 = (LogicalAndExpression)Expr_53_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = LogicalAndExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final InclusiveOrExpression InclusiveOrExpression_55_Var
		 = (InclusiveOrExpression)Expr_54_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = InclusiveOrExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final ExclusiveOrExpression ExclusiveOrExpression_56_Var
		 = (ExclusiveOrExpression)Expr_55_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = ExclusiveOrExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final AndExpression AndExpression_57_Var
		 = (AndExpression)Expr_56_list.get(0);
		Assert.assertNotNull(AndExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = AndExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final EqualityExpression EqualityExpression_58_Var
		 = (EqualityExpression)Expr_57_list.get(0);
		Assert.assertNotNull(EqualityExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = EqualityExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final RelationalExpression RelationalExpression_59_Var
		 = (RelationalExpression)Expr_58_list.get(0);
		Assert.assertNotNull(RelationalExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = RelationalExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final ShiftExpression ShiftExpression_60_Var
		 = (ShiftExpression)Expr_59_list.get(0);
		Assert.assertNotNull(ShiftExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = ShiftExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final AdditiveExpression AdditiveExpression_61_Var
		 = (AdditiveExpression)Expr_60_list.get(0);
		Assert.assertNotNull(AdditiveExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = AdditiveExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final MultiplicativeExpression MultiplicativeExpression_62_Var
		 = (MultiplicativeExpression)Expr_61_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = MultiplicativeExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final CastExpression CastExpression_63_Var
		 = (CastExpression)Expr_62_list.get(0);
		Assert.assertNotNull(CastExpression_63_Var
		);
		//63
		final UnaryExpression UnaryExpression_64_Var
		 = (UnaryExpression)CastExpression_63_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_64_Var
		);
		//64
		final PostfixExpression PostfixExpression_65_Var
		 = (PostfixExpression)UnaryExpression_64_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = PostfixExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final PrimaryExpression PrimaryExpression_66_Var
		 = (PrimaryExpression)Expr_65_list.get(0);
		Assert.assertNotNull(PrimaryExpression_66_Var
		);
		//66
		final Constant2 Constant2_67_Var
		 = (Constant2)PrimaryExpression_66_Var
		.getConst();
		Assert.assertNotNull(Constant2_67_Var
		);
		Assert.assertEquals("0", Constant2_67_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_49_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_49_Var
		.getSemi());
		//67
		final Statement Statement_68_Var
		 = (Statement)SelectionStatement_22_Var
		.getElseStatement();
		Assert.assertNotNull(Statement_68_Var
		);
		//68
		final SelectionStatement SelectionStatement_69_Var
		 = (SelectionStatement)Statement_68_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_69_Var
		);
		Assert.assertEquals("if", SelectionStatement_69_Var
		.getIf());
		//69
		final Expression Expression_70_Var
		 = (Expression)SelectionStatement_69_Var
		.getExpr();
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
		Assert.assertEquals("[==]", EqualityExpression_78_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_78_list = EqualityExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(2, Expr_78_list.size());
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
		Assert.assertEquals("argc", PrimaryExpression_86_Var
		.getId());
		//86
		final RelationalExpression RelationalExpression_87_Var
		 = (RelationalExpression)Expr_78_list.get(1);
		Assert.assertNotNull(RelationalExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = RelationalExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final ShiftExpression ShiftExpression_88_Var
		 = (ShiftExpression)Expr_87_list.get(0);
		Assert.assertNotNull(ShiftExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = ShiftExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final AdditiveExpression AdditiveExpression_89_Var
		 = (AdditiveExpression)Expr_88_list.get(0);
		Assert.assertNotNull(AdditiveExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = AdditiveExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final MultiplicativeExpression MultiplicativeExpression_90_Var
		 = (MultiplicativeExpression)Expr_89_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = MultiplicativeExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final CastExpression CastExpression_91_Var
		 = (CastExpression)Expr_90_list.get(0);
		Assert.assertNotNull(CastExpression_91_Var
		);
		//91
		final UnaryExpression UnaryExpression_92_Var
		 = (UnaryExpression)CastExpression_91_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_92_Var
		);
		//92
		final PostfixExpression PostfixExpression_93_Var
		 = (PostfixExpression)UnaryExpression_92_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = PostfixExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final PrimaryExpression PrimaryExpression_94_Var
		 = (PrimaryExpression)Expr_93_list.get(0);
		Assert.assertNotNull(PrimaryExpression_94_Var
		);
		//94
		final Constant2 Constant2_95_Var
		 = (Constant2)PrimaryExpression_94_Var
		.getConst();
		Assert.assertNotNull(Constant2_95_Var
		);
		Assert.assertEquals("1", Constant2_95_Var
		.getDec());
		Assert.assertEquals("else", SelectionStatement_69_Var
		.getElse());
		//95
		final Statement Statement_96_Var
		 = (Statement)SelectionStatement_69_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_96_Var
		);
		//96
		final CompoundStatement CompoundStatement_97_Var
		 = (CompoundStatement)Statement_96_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_97_Var
		);
		//97
		final BodyStatement BodyStatement_98_Var
		 = (BodyStatement)CompoundStatement_97_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_98_Var
		);
		final EList<? extends EObject> BlockList_98_list = BodyStatement_98_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_98_list);
		Assert.assertEquals(1, BlockList_98_list.size());
		//98
		final BlockList BlockList_99_Var
		 = (BlockList)BlockList_98_list.get(0);
		Assert.assertNotNull(BlockList_99_Var
		);
		final EList<? extends EObject> Statement_99_list = BlockList_99_Var
		.getStatement();
		Assert.assertNotNull(Statement_99_list);
		Assert.assertEquals(1, Statement_99_list.size());
		//99
		final Statement Statement_100_Var
		 = (Statement)Statement_99_list.get(0);
		Assert.assertNotNull(Statement_100_Var
		);
		//100
		final JumpStatement JumpStatement_101_Var
		 = (JumpStatement)Statement_100_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_101_Var
		);
		//101
		final Expression Expression_102_Var
		 = (Expression)JumpStatement_101_Var
		.getExpr();
		Assert.assertNotNull(Expression_102_Var
		);
		final EList<? extends EObject> ExprExpr_102_list = Expression_102_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_102_list);
		Assert.assertEquals(1, ExprExpr_102_list.size());
		//102
		final AssignmentExpression AssignmentExpression_103_Var
		 = (AssignmentExpression)ExprExpr_102_list.get(0);
		Assert.assertNotNull(AssignmentExpression_103_Var
		);
		//103
		final ConditionalExpression ConditionalExpression_104_Var
		 = (ConditionalExpression)AssignmentExpression_103_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_104_Var
		);
		//104
		final LogicalOrExpression LogicalOrExpression_105_Var
		 = (LogicalOrExpression)ConditionalExpression_104_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = LogicalOrExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final LogicalAndExpression LogicalAndExpression_106_Var
		 = (LogicalAndExpression)Expr_105_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = LogicalAndExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final InclusiveOrExpression InclusiveOrExpression_107_Var
		 = (InclusiveOrExpression)Expr_106_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = InclusiveOrExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final ExclusiveOrExpression ExclusiveOrExpression_108_Var
		 = (ExclusiveOrExpression)Expr_107_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = ExclusiveOrExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final AndExpression AndExpression_109_Var
		 = (AndExpression)Expr_108_list.get(0);
		Assert.assertNotNull(AndExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = AndExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final EqualityExpression EqualityExpression_110_Var
		 = (EqualityExpression)Expr_109_list.get(0);
		Assert.assertNotNull(EqualityExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = EqualityExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final RelationalExpression RelationalExpression_111_Var
		 = (RelationalExpression)Expr_110_list.get(0);
		Assert.assertNotNull(RelationalExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = RelationalExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final ShiftExpression ShiftExpression_112_Var
		 = (ShiftExpression)Expr_111_list.get(0);
		Assert.assertNotNull(ShiftExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = ShiftExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final AdditiveExpression AdditiveExpression_113_Var
		 = (AdditiveExpression)Expr_112_list.get(0);
		Assert.assertNotNull(AdditiveExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = AdditiveExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final MultiplicativeExpression MultiplicativeExpression_114_Var
		 = (MultiplicativeExpression)Expr_113_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = MultiplicativeExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final CastExpression CastExpression_115_Var
		 = (CastExpression)Expr_114_list.get(0);
		Assert.assertNotNull(CastExpression_115_Var
		);
		//115
		final UnaryExpression UnaryExpression_116_Var
		 = (UnaryExpression)CastExpression_115_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_116_Var
		);
		//116
		final PostfixExpression PostfixExpression_117_Var
		 = (PostfixExpression)UnaryExpression_116_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = PostfixExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final PrimaryExpression PrimaryExpression_118_Var
		 = (PrimaryExpression)Expr_117_list.get(0);
		Assert.assertNotNull(PrimaryExpression_118_Var
		);
		//118
		final Constant2 Constant2_119_Var
		 = (Constant2)PrimaryExpression_118_Var
		.getConst();
		Assert.assertNotNull(Constant2_119_Var
		);
		Assert.assertEquals("1", Constant2_119_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_101_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_101_Var
		.getSemi());
		//119
		final Statement Statement_120_Var
		 = (Statement)SelectionStatement_69_Var
		.getElseStatement();
		Assert.assertNotNull(Statement_120_Var
		);
		//120
		final CompoundStatement CompoundStatement_121_Var
		 = (CompoundStatement)Statement_120_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_121_Var
		);
		//121
		final BodyStatement BodyStatement_122_Var
		 = (BodyStatement)CompoundStatement_121_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_122_Var
		);
		final EList<? extends EObject> BlockList_122_list = BodyStatement_122_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_122_list);
		Assert.assertEquals(1, BlockList_122_list.size());
		//122
		final BlockList BlockList_123_Var
		 = (BlockList)BlockList_122_list.get(0);
		Assert.assertNotNull(BlockList_123_Var
		);
		final EList<? extends EObject> Statement_123_list = BlockList_123_Var
		.getStatement();
		Assert.assertNotNull(Statement_123_list);
		Assert.assertEquals(1, Statement_123_list.size());
		//123
		final Statement Statement_124_Var
		 = (Statement)Statement_123_list.get(0);
		Assert.assertNotNull(Statement_124_Var
		);
		//124
		final JumpStatement JumpStatement_125_Var
		 = (JumpStatement)Statement_124_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_125_Var
		);
		//125
		final Expression Expression_126_Var
		 = (Expression)JumpStatement_125_Var
		.getExpr();
		Assert.assertNotNull(Expression_126_Var
		);
		final EList<? extends EObject> ExprExpr_126_list = Expression_126_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_126_list);
		Assert.assertEquals(1, ExprExpr_126_list.size());
		//126
		final AssignmentExpression AssignmentExpression_127_Var
		 = (AssignmentExpression)ExprExpr_126_list.get(0);
		Assert.assertNotNull(AssignmentExpression_127_Var
		);
		//127
		final ConditionalExpression ConditionalExpression_128_Var
		 = (ConditionalExpression)AssignmentExpression_127_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_128_Var
		);
		//128
		final LogicalOrExpression LogicalOrExpression_129_Var
		 = (LogicalOrExpression)ConditionalExpression_128_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = LogicalOrExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final LogicalAndExpression LogicalAndExpression_130_Var
		 = (LogicalAndExpression)Expr_129_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = LogicalAndExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final InclusiveOrExpression InclusiveOrExpression_131_Var
		 = (InclusiveOrExpression)Expr_130_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = InclusiveOrExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final ExclusiveOrExpression ExclusiveOrExpression_132_Var
		 = (ExclusiveOrExpression)Expr_131_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = ExclusiveOrExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final AndExpression AndExpression_133_Var
		 = (AndExpression)Expr_132_list.get(0);
		Assert.assertNotNull(AndExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = AndExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final EqualityExpression EqualityExpression_134_Var
		 = (EqualityExpression)Expr_133_list.get(0);
		Assert.assertNotNull(EqualityExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = EqualityExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final RelationalExpression RelationalExpression_135_Var
		 = (RelationalExpression)Expr_134_list.get(0);
		Assert.assertNotNull(RelationalExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = RelationalExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final ShiftExpression ShiftExpression_136_Var
		 = (ShiftExpression)Expr_135_list.get(0);
		Assert.assertNotNull(ShiftExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = ShiftExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final AdditiveExpression AdditiveExpression_137_Var
		 = (AdditiveExpression)Expr_136_list.get(0);
		Assert.assertNotNull(AdditiveExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = AdditiveExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final MultiplicativeExpression MultiplicativeExpression_138_Var
		 = (MultiplicativeExpression)Expr_137_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = MultiplicativeExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final CastExpression CastExpression_139_Var
		 = (CastExpression)Expr_138_list.get(0);
		Assert.assertNotNull(CastExpression_139_Var
		);
		//139
		final UnaryExpression UnaryExpression_140_Var
		 = (UnaryExpression)CastExpression_139_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_140_Var
		);
		//140
		final PostfixExpression PostfixExpression_141_Var
		 = (PostfixExpression)UnaryExpression_140_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = PostfixExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final PrimaryExpression PrimaryExpression_142_Var
		 = (PrimaryExpression)Expr_141_list.get(0);
		Assert.assertNotNull(PrimaryExpression_142_Var
		);
		//142
		final Constant2 Constant2_143_Var
		 = (Constant2)PrimaryExpression_142_Var
		.getConst();
		Assert.assertNotNull(Constant2_143_Var
		);
		Assert.assertEquals("2", Constant2_143_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_125_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_125_Var
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


