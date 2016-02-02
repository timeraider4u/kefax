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
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.CompoundStatement;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.LabeledStatement;
import at.jku.weiner.c.parser.parser.ConstantExpression;
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
import at.jku.weiner.c.parser.parser.LabeledStatement;
import at.jku.weiner.c.parser.parser.ConstantExpression;
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
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.LabeledStatement;
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
public class Test0025_Switch {
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
			"res/Test0025_Switch.c");
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
				"RULE_KW_SWITCH",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_CASE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COLON",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_CASE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_BREAK",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_DEFAULT",
				"RULE_SKW_COLON",
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
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
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
			"res/Test0025_Switch.c");
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
		Assert.assertEquals(2, Statement_18_list.size());
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
		Assert.assertEquals("switch", SelectionStatement_20_Var
		.getSwitch());
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
		final EList<? extends EObject> Expr_30_list = RelationalExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
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
		final Statement Statement_38_Var
		 = (Statement)SelectionStatement_20_Var
		.getSwitchStatement();
		Assert.assertNotNull(Statement_38_Var
		);
		//38
		final CompoundStatement CompoundStatement_39_Var
		 = (CompoundStatement)Statement_38_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_39_Var
		);
		//39
		final BodyStatement BodyStatement_40_Var
		 = (BodyStatement)CompoundStatement_39_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_40_Var
		);
		final EList<? extends EObject> BlockList_40_list = BodyStatement_40_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_40_list);
		Assert.assertEquals(1, BlockList_40_list.size());
		//40
		final BlockList BlockList_41_Var
		 = (BlockList)BlockList_40_list.get(0);
		Assert.assertNotNull(BlockList_41_Var
		);
		final EList<? extends EObject> Statement_41_list = BlockList_41_Var
		.getStatement();
		Assert.assertNotNull(Statement_41_list);
		Assert.assertEquals(3, Statement_41_list.size());
		//41
		final Statement Statement_42_Var
		 = (Statement)Statement_41_list.get(0);
		Assert.assertNotNull(Statement_42_Var
		);
		//42
		final LabeledStatement LabeledStatement_43_Var
		 = (LabeledStatement)Statement_42_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_43_Var
		);
		Assert.assertEquals("case", LabeledStatement_43_Var
		.getCase());
		//43
		final ConstantExpression ConstantExpression_44_Var
		 = (ConstantExpression)LabeledStatement_43_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_44_Var
		);
		//44
		final ConditionalExpression ConditionalExpression_45_Var
		 = (ConditionalExpression)ConstantExpression_44_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_45_Var
		);
		//45
		final LogicalOrExpression LogicalOrExpression_46_Var
		 = (LogicalOrExpression)ConditionalExpression_45_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = LogicalOrExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final LogicalAndExpression LogicalAndExpression_47_Var
		 = (LogicalAndExpression)Expr_46_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = LogicalAndExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final InclusiveOrExpression InclusiveOrExpression_48_Var
		 = (InclusiveOrExpression)Expr_47_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = InclusiveOrExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final ExclusiveOrExpression ExclusiveOrExpression_49_Var
		 = (ExclusiveOrExpression)Expr_48_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = ExclusiveOrExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final AndExpression AndExpression_50_Var
		 = (AndExpression)Expr_49_list.get(0);
		Assert.assertNotNull(AndExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = AndExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final EqualityExpression EqualityExpression_51_Var
		 = (EqualityExpression)Expr_50_list.get(0);
		Assert.assertNotNull(EqualityExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = EqualityExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final RelationalExpression RelationalExpression_52_Var
		 = (RelationalExpression)Expr_51_list.get(0);
		Assert.assertNotNull(RelationalExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = RelationalExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final ShiftExpression ShiftExpression_53_Var
		 = (ShiftExpression)Expr_52_list.get(0);
		Assert.assertNotNull(ShiftExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = ShiftExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final AdditiveExpression AdditiveExpression_54_Var
		 = (AdditiveExpression)Expr_53_list.get(0);
		Assert.assertNotNull(AdditiveExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = AdditiveExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final MultiplicativeExpression MultiplicativeExpression_55_Var
		 = (MultiplicativeExpression)Expr_54_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = MultiplicativeExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final CastExpression CastExpression_56_Var
		 = (CastExpression)Expr_55_list.get(0);
		Assert.assertNotNull(CastExpression_56_Var
		);
		//56
		final UnaryExpression UnaryExpression_57_Var
		 = (UnaryExpression)CastExpression_56_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_57_Var
		);
		//57
		final PostfixExpression PostfixExpression_58_Var
		 = (PostfixExpression)UnaryExpression_57_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = PostfixExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final PrimaryExpression PrimaryExpression_59_Var
		 = (PrimaryExpression)Expr_58_list.get(0);
		Assert.assertNotNull(PrimaryExpression_59_Var
		);
		//59
		final Constant2 Constant2_60_Var
		 = (Constant2)PrimaryExpression_59_Var
		.getConst();
		Assert.assertNotNull(Constant2_60_Var
		);
		Assert.assertEquals("0", Constant2_60_Var
		.getDec());
		//60
		final Statement Statement_61_Var
		 = (Statement)LabeledStatement_43_Var
		.getLStmt();
		Assert.assertNotNull(Statement_61_Var
		);
		//61
		final JumpStatement JumpStatement_62_Var
		 = (JumpStatement)Statement_61_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_62_Var
		);
		Assert.assertEquals("return", JumpStatement_62_Var
		.getReturn());
		//62
		final Expression Expression_63_Var
		 = (Expression)JumpStatement_62_Var
		.getExpr();
		Assert.assertNotNull(Expression_63_Var
		);
		final EList<? extends EObject> ExprExpr_63_list = Expression_63_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_63_list);
		Assert.assertEquals(1, ExprExpr_63_list.size());
		//63
		final AssignmentExpression AssignmentExpression_64_Var
		 = (AssignmentExpression)ExprExpr_63_list.get(0);
		Assert.assertNotNull(AssignmentExpression_64_Var
		);
		//64
		final ConditionalExpression ConditionalExpression_65_Var
		 = (ConditionalExpression)AssignmentExpression_64_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_65_Var
		);
		//65
		final LogicalOrExpression LogicalOrExpression_66_Var
		 = (LogicalOrExpression)ConditionalExpression_65_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = LogicalOrExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final LogicalAndExpression LogicalAndExpression_67_Var
		 = (LogicalAndExpression)Expr_66_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = LogicalAndExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final InclusiveOrExpression InclusiveOrExpression_68_Var
		 = (InclusiveOrExpression)Expr_67_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = InclusiveOrExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final ExclusiveOrExpression ExclusiveOrExpression_69_Var
		 = (ExclusiveOrExpression)Expr_68_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = ExclusiveOrExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final AndExpression AndExpression_70_Var
		 = (AndExpression)Expr_69_list.get(0);
		Assert.assertNotNull(AndExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = AndExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final EqualityExpression EqualityExpression_71_Var
		 = (EqualityExpression)Expr_70_list.get(0);
		Assert.assertNotNull(EqualityExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = EqualityExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final RelationalExpression RelationalExpression_72_Var
		 = (RelationalExpression)Expr_71_list.get(0);
		Assert.assertNotNull(RelationalExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = RelationalExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final ShiftExpression ShiftExpression_73_Var
		 = (ShiftExpression)Expr_72_list.get(0);
		Assert.assertNotNull(ShiftExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = ShiftExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final AdditiveExpression AdditiveExpression_74_Var
		 = (AdditiveExpression)Expr_73_list.get(0);
		Assert.assertNotNull(AdditiveExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = AdditiveExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final MultiplicativeExpression MultiplicativeExpression_75_Var
		 = (MultiplicativeExpression)Expr_74_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = MultiplicativeExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final CastExpression CastExpression_76_Var
		 = (CastExpression)Expr_75_list.get(0);
		Assert.assertNotNull(CastExpression_76_Var
		);
		//76
		final UnaryExpression UnaryExpression_77_Var
		 = (UnaryExpression)CastExpression_76_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_77_Var
		);
		//77
		final PostfixExpression PostfixExpression_78_Var
		 = (PostfixExpression)UnaryExpression_77_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = PostfixExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final PrimaryExpression PrimaryExpression_79_Var
		 = (PrimaryExpression)Expr_78_list.get(0);
		Assert.assertNotNull(PrimaryExpression_79_Var
		);
		//79
		final Constant2 Constant2_80_Var
		 = (Constant2)PrimaryExpression_79_Var
		.getConst();
		Assert.assertNotNull(Constant2_80_Var
		);
		Assert.assertEquals("0", Constant2_80_Var
		.getDec());
		//80
		final Statement Statement_81_Var
		 = (Statement)Statement_41_list.get(1);
		Assert.assertNotNull(Statement_81_Var
		);
		//81
		final LabeledStatement LabeledStatement_82_Var
		 = (LabeledStatement)Statement_81_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_82_Var
		);
		Assert.assertEquals("case", LabeledStatement_82_Var
		.getCase());
		//82
		final ConstantExpression ConstantExpression_83_Var
		 = (ConstantExpression)LabeledStatement_82_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_83_Var
		);
		//83
		final ConditionalExpression ConditionalExpression_84_Var
		 = (ConditionalExpression)ConstantExpression_83_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_84_Var
		);
		//84
		final LogicalOrExpression LogicalOrExpression_85_Var
		 = (LogicalOrExpression)ConditionalExpression_84_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = LogicalOrExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final LogicalAndExpression LogicalAndExpression_86_Var
		 = (LogicalAndExpression)Expr_85_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = LogicalAndExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final InclusiveOrExpression InclusiveOrExpression_87_Var
		 = (InclusiveOrExpression)Expr_86_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = InclusiveOrExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final ExclusiveOrExpression ExclusiveOrExpression_88_Var
		 = (ExclusiveOrExpression)Expr_87_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = ExclusiveOrExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final AndExpression AndExpression_89_Var
		 = (AndExpression)Expr_88_list.get(0);
		Assert.assertNotNull(AndExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = AndExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final EqualityExpression EqualityExpression_90_Var
		 = (EqualityExpression)Expr_89_list.get(0);
		Assert.assertNotNull(EqualityExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = EqualityExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final RelationalExpression RelationalExpression_91_Var
		 = (RelationalExpression)Expr_90_list.get(0);
		Assert.assertNotNull(RelationalExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = RelationalExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final ShiftExpression ShiftExpression_92_Var
		 = (ShiftExpression)Expr_91_list.get(0);
		Assert.assertNotNull(ShiftExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = ShiftExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final AdditiveExpression AdditiveExpression_93_Var
		 = (AdditiveExpression)Expr_92_list.get(0);
		Assert.assertNotNull(AdditiveExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = AdditiveExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final MultiplicativeExpression MultiplicativeExpression_94_Var
		 = (MultiplicativeExpression)Expr_93_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = MultiplicativeExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final CastExpression CastExpression_95_Var
		 = (CastExpression)Expr_94_list.get(0);
		Assert.assertNotNull(CastExpression_95_Var
		);
		//95
		final UnaryExpression UnaryExpression_96_Var
		 = (UnaryExpression)CastExpression_95_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_96_Var
		);
		//96
		final PostfixExpression PostfixExpression_97_Var
		 = (PostfixExpression)UnaryExpression_96_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = PostfixExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final PrimaryExpression PrimaryExpression_98_Var
		 = (PrimaryExpression)Expr_97_list.get(0);
		Assert.assertNotNull(PrimaryExpression_98_Var
		);
		//98
		final Constant2 Constant2_99_Var
		 = (Constant2)PrimaryExpression_98_Var
		.getConst();
		Assert.assertNotNull(Constant2_99_Var
		);
		Assert.assertEquals("1", Constant2_99_Var
		.getDec());
		//99
		final Statement Statement_100_Var
		 = (Statement)LabeledStatement_82_Var
		.getLStmt();
		Assert.assertNotNull(Statement_100_Var
		);
		//100
		final CompoundStatement CompoundStatement_101_Var
		 = (CompoundStatement)Statement_100_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_101_Var
		);
		//101
		final BodyStatement BodyStatement_102_Var
		 = (BodyStatement)CompoundStatement_101_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_102_Var
		);
		final EList<? extends EObject> BlockList_102_list = BodyStatement_102_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_102_list);
		Assert.assertEquals(1, BlockList_102_list.size());
		//102
		final BlockList BlockList_103_Var
		 = (BlockList)BlockList_102_list.get(0);
		Assert.assertNotNull(BlockList_103_Var
		);
		final EList<? extends EObject> Statement_103_list = BlockList_103_Var
		.getStatement();
		Assert.assertNotNull(Statement_103_list);
		Assert.assertEquals(1, Statement_103_list.size());
		//103
		final Statement Statement_104_Var
		 = (Statement)Statement_103_list.get(0);
		Assert.assertNotNull(Statement_104_Var
		);
		//104
		final JumpStatement JumpStatement_105_Var
		 = (JumpStatement)Statement_104_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_105_Var
		);
		Assert.assertEquals("break", JumpStatement_105_Var
		.getBreak());
		//105
		final Statement Statement_106_Var
		 = (Statement)Statement_41_list.get(2);
		Assert.assertNotNull(Statement_106_Var
		);
		//106
		final LabeledStatement LabeledStatement_107_Var
		 = (LabeledStatement)Statement_106_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_107_Var
		);
		Assert.assertTrue(LabeledStatement_107_Var
		.isMydefault());
		//107
		final Statement Statement_108_Var
		 = (Statement)LabeledStatement_107_Var
		.getLStmt();
		Assert.assertNotNull(Statement_108_Var
		);
		//108
		final CompoundStatement CompoundStatement_109_Var
		 = (CompoundStatement)Statement_108_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_109_Var
		);
		//109
		final BodyStatement BodyStatement_110_Var
		 = (BodyStatement)CompoundStatement_109_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_110_Var
		);
		final EList<? extends EObject> BlockList_110_list = BodyStatement_110_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_110_list);
		Assert.assertEquals(1, BlockList_110_list.size());
		//110
		final BlockList BlockList_111_Var
		 = (BlockList)BlockList_110_list.get(0);
		Assert.assertNotNull(BlockList_111_Var
		);
		final EList<? extends EObject> Statement_111_list = BlockList_111_Var
		.getStatement();
		Assert.assertNotNull(Statement_111_list);
		Assert.assertEquals(1, Statement_111_list.size());
		//111
		final Statement Statement_112_Var
		 = (Statement)Statement_111_list.get(0);
		Assert.assertNotNull(Statement_112_Var
		);
		//112
		final JumpStatement JumpStatement_113_Var
		 = (JumpStatement)Statement_112_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_113_Var
		);
		Assert.assertEquals("return", JumpStatement_113_Var
		.getReturn());
		//113
		final Expression Expression_114_Var
		 = (Expression)JumpStatement_113_Var
		.getExpr();
		Assert.assertNotNull(Expression_114_Var
		);
		final EList<? extends EObject> ExprExpr_114_list = Expression_114_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_114_list);
		Assert.assertEquals(1, ExprExpr_114_list.size());
		//114
		final AssignmentExpression AssignmentExpression_115_Var
		 = (AssignmentExpression)ExprExpr_114_list.get(0);
		Assert.assertNotNull(AssignmentExpression_115_Var
		);
		//115
		final ConditionalExpression ConditionalExpression_116_Var
		 = (ConditionalExpression)AssignmentExpression_115_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_116_Var
		);
		//116
		final LogicalOrExpression LogicalOrExpression_117_Var
		 = (LogicalOrExpression)ConditionalExpression_116_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = LogicalOrExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final LogicalAndExpression LogicalAndExpression_118_Var
		 = (LogicalAndExpression)Expr_117_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = LogicalAndExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final InclusiveOrExpression InclusiveOrExpression_119_Var
		 = (InclusiveOrExpression)Expr_118_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = InclusiveOrExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final ExclusiveOrExpression ExclusiveOrExpression_120_Var
		 = (ExclusiveOrExpression)Expr_119_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = ExclusiveOrExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final AndExpression AndExpression_121_Var
		 = (AndExpression)Expr_120_list.get(0);
		Assert.assertNotNull(AndExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = AndExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final EqualityExpression EqualityExpression_122_Var
		 = (EqualityExpression)Expr_121_list.get(0);
		Assert.assertNotNull(EqualityExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = EqualityExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final RelationalExpression RelationalExpression_123_Var
		 = (RelationalExpression)Expr_122_list.get(0);
		Assert.assertNotNull(RelationalExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = RelationalExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final ShiftExpression ShiftExpression_124_Var
		 = (ShiftExpression)Expr_123_list.get(0);
		Assert.assertNotNull(ShiftExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = ShiftExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final AdditiveExpression AdditiveExpression_125_Var
		 = (AdditiveExpression)Expr_124_list.get(0);
		Assert.assertNotNull(AdditiveExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = AdditiveExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final MultiplicativeExpression MultiplicativeExpression_126_Var
		 = (MultiplicativeExpression)Expr_125_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = MultiplicativeExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final CastExpression CastExpression_127_Var
		 = (CastExpression)Expr_126_list.get(0);
		Assert.assertNotNull(CastExpression_127_Var
		);
		//127
		final UnaryExpression UnaryExpression_128_Var
		 = (UnaryExpression)CastExpression_127_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_128_Var
		);
		//128
		final PostfixExpression PostfixExpression_129_Var
		 = (PostfixExpression)UnaryExpression_128_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = PostfixExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final PrimaryExpression PrimaryExpression_130_Var
		 = (PrimaryExpression)Expr_129_list.get(0);
		Assert.assertNotNull(PrimaryExpression_130_Var
		);
		//130
		final Constant2 Constant2_131_Var
		 = (Constant2)PrimaryExpression_130_Var
		.getConst();
		Assert.assertNotNull(Constant2_131_Var
		);
		Assert.assertEquals("2", Constant2_131_Var
		.getDec());
		//131
		final Statement Statement_132_Var
		 = (Statement)Statement_18_list.get(1);
		Assert.assertNotNull(Statement_132_Var
		);
		//132
		final JumpStatement JumpStatement_133_Var
		 = (JumpStatement)Statement_132_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_133_Var
		);
		//133
		final Expression Expression_134_Var
		 = (Expression)JumpStatement_133_Var
		.getExpr();
		Assert.assertNotNull(Expression_134_Var
		);
		final EList<? extends EObject> ExprExpr_134_list = Expression_134_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_134_list);
		Assert.assertEquals(1, ExprExpr_134_list.size());
		//134
		final AssignmentExpression AssignmentExpression_135_Var
		 = (AssignmentExpression)ExprExpr_134_list.get(0);
		Assert.assertNotNull(AssignmentExpression_135_Var
		);
		//135
		final ConditionalExpression ConditionalExpression_136_Var
		 = (ConditionalExpression)AssignmentExpression_135_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_136_Var
		);
		//136
		final LogicalOrExpression LogicalOrExpression_137_Var
		 = (LogicalOrExpression)ConditionalExpression_136_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = LogicalOrExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final LogicalAndExpression LogicalAndExpression_138_Var
		 = (LogicalAndExpression)Expr_137_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = LogicalAndExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final InclusiveOrExpression InclusiveOrExpression_139_Var
		 = (InclusiveOrExpression)Expr_138_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = InclusiveOrExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final ExclusiveOrExpression ExclusiveOrExpression_140_Var
		 = (ExclusiveOrExpression)Expr_139_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = ExclusiveOrExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final AndExpression AndExpression_141_Var
		 = (AndExpression)Expr_140_list.get(0);
		Assert.assertNotNull(AndExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = AndExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final EqualityExpression EqualityExpression_142_Var
		 = (EqualityExpression)Expr_141_list.get(0);
		Assert.assertNotNull(EqualityExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = EqualityExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final RelationalExpression RelationalExpression_143_Var
		 = (RelationalExpression)Expr_142_list.get(0);
		Assert.assertNotNull(RelationalExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = RelationalExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final ShiftExpression ShiftExpression_144_Var
		 = (ShiftExpression)Expr_143_list.get(0);
		Assert.assertNotNull(ShiftExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = ShiftExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final AdditiveExpression AdditiveExpression_145_Var
		 = (AdditiveExpression)Expr_144_list.get(0);
		Assert.assertNotNull(AdditiveExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = AdditiveExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final MultiplicativeExpression MultiplicativeExpression_146_Var
		 = (MultiplicativeExpression)Expr_145_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_146_Var
		);
		final EList<? extends EObject> Expr_146_list = MultiplicativeExpression_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final CastExpression CastExpression_147_Var
		 = (CastExpression)Expr_146_list.get(0);
		Assert.assertNotNull(CastExpression_147_Var
		);
		//147
		final UnaryExpression UnaryExpression_148_Var
		 = (UnaryExpression)CastExpression_147_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_148_Var
		);
		//148
		final PostfixExpression PostfixExpression_149_Var
		 = (PostfixExpression)UnaryExpression_148_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_149_Var
		);
		final EList<? extends EObject> Expr_149_list = PostfixExpression_149_Var
		.getExpr();
		Assert.assertNotNull(Expr_149_list);
		Assert.assertEquals(1, Expr_149_list.size());
		//149
		final PrimaryExpression PrimaryExpression_150_Var
		 = (PrimaryExpression)Expr_149_list.get(0);
		Assert.assertNotNull(PrimaryExpression_150_Var
		);
		//150
		final Constant2 Constant2_151_Var
		 = (Constant2)PrimaryExpression_150_Var
		.getConst();
		Assert.assertNotNull(Constant2_151_Var
		);
		Assert.assertEquals("1", Constant2_151_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_133_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0025_Switch.c");
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
				method.invoke(this.generator, "Test0025_Switch.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0025_Switch.c");
		final String expected = this.getTextFromFile(
			"res/Test0025_Switch.c"
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


