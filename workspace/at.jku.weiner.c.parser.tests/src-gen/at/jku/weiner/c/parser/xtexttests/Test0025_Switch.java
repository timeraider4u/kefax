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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0025_Switch {
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
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0025_Switch.c");
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
		Assert.assertEquals("int", TypeSpecifier_5_Var
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
		Assert.assertEquals("doSomething", DirectDeclarator_7_Var
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
		Assert.assertEquals("argc", DirectDeclarator_16_Var
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
		Assert.assertEquals(2, Statement_19_list.size());
		//19
		final Statement Statement_20_Var
		 = (Statement)Statement_19_list.get(0);
		Assert.assertNotNull(Statement_20_Var
		);
		//20
		final SelectionStatement SelectionStatement_21_Var
		 = (SelectionStatement)Statement_20_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_21_Var
		);
		Assert.assertEquals("switch", SelectionStatement_21_Var
		.getSwitch());
		//21
		final Expression Expression_22_Var
		 = (Expression)SelectionStatement_21_Var
		.getExpr();
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
		final ConditionalExpression ConditionalExpression_24_Var
		 = (ConditionalExpression)AssignmentExpression_23_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_24_Var
		);
		//24
		final LogicalOrExpression LogicalOrExpression_25_Var
		 = (LogicalOrExpression)ConditionalExpression_24_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = LogicalOrExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final LogicalAndExpression LogicalAndExpression_26_Var
		 = (LogicalAndExpression)Expr_25_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = LogicalAndExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final InclusiveOrExpression InclusiveOrExpression_27_Var
		 = (InclusiveOrExpression)Expr_26_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = InclusiveOrExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final ExclusiveOrExpression ExclusiveOrExpression_28_Var
		 = (ExclusiveOrExpression)Expr_27_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = ExclusiveOrExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final AndExpression AndExpression_29_Var
		 = (AndExpression)Expr_28_list.get(0);
		Assert.assertNotNull(AndExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = AndExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final EqualityExpression EqualityExpression_30_Var
		 = (EqualityExpression)Expr_29_list.get(0);
		Assert.assertNotNull(EqualityExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = EqualityExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final RelationalExpression RelationalExpression_31_Var
		 = (RelationalExpression)Expr_30_list.get(0);
		Assert.assertNotNull(RelationalExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = RelationalExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final ShiftExpression ShiftExpression_32_Var
		 = (ShiftExpression)Expr_31_list.get(0);
		Assert.assertNotNull(ShiftExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = ShiftExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final AdditiveExpression AdditiveExpression_33_Var
		 = (AdditiveExpression)Expr_32_list.get(0);
		Assert.assertNotNull(AdditiveExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = AdditiveExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final MultiplicativeExpression MultiplicativeExpression_34_Var
		 = (MultiplicativeExpression)Expr_33_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = MultiplicativeExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final CastExpression CastExpression_35_Var
		 = (CastExpression)Expr_34_list.get(0);
		Assert.assertNotNull(CastExpression_35_Var
		);
		//35
		final UnaryExpression UnaryExpression_36_Var
		 = (UnaryExpression)CastExpression_35_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_36_Var
		);
		//36
		final PostfixExpression PostfixExpression_37_Var
		 = (PostfixExpression)UnaryExpression_36_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = PostfixExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final PrimaryExpression PrimaryExpression_38_Var
		 = (PrimaryExpression)Expr_37_list.get(0);
		Assert.assertNotNull(PrimaryExpression_38_Var
		);
		Assert.assertEquals("argc", PrimaryExpression_38_Var
		.getId());
		//38
		final Statement Statement_39_Var
		 = (Statement)SelectionStatement_21_Var
		.getSwitchStatement();
		Assert.assertNotNull(Statement_39_Var
		);
		//39
		final CompoundStatement CompoundStatement_40_Var
		 = (CompoundStatement)Statement_39_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_40_Var
		);
		//40
		final BodyStatement BodyStatement_41_Var
		 = (BodyStatement)CompoundStatement_40_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_41_Var
		);
		final EList<? extends EObject> BlockList_41_list = BodyStatement_41_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_41_list);
		Assert.assertEquals(1, BlockList_41_list.size());
		//41
		final BlockList BlockList_42_Var
		 = (BlockList)BlockList_41_list.get(0);
		Assert.assertNotNull(BlockList_42_Var
		);
		final EList<? extends EObject> Statement_42_list = BlockList_42_Var
		.getStatement();
		Assert.assertNotNull(Statement_42_list);
		Assert.assertEquals(3, Statement_42_list.size());
		//42
		final Statement Statement_43_Var
		 = (Statement)Statement_42_list.get(0);
		Assert.assertNotNull(Statement_43_Var
		);
		//43
		final LabeledStatement LabeledStatement_44_Var
		 = (LabeledStatement)Statement_43_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_44_Var
		);
		Assert.assertEquals("case", LabeledStatement_44_Var
		.getCase());
		//44
		final ConstantExpression ConstantExpression_45_Var
		 = (ConstantExpression)LabeledStatement_44_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_45_Var
		);
		//45
		final ConditionalExpression ConditionalExpression_46_Var
		 = (ConditionalExpression)ConstantExpression_45_Var
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
		final EList<? extends EObject> Expr_53_list = RelationalExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
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
		//60
		final Constant Constant_61_Var
		 = (Constant)PrimaryExpression_60_Var
		.getConst();
		Assert.assertNotNull(Constant_61_Var
		);
		Assert.assertEquals("0", Constant_61_Var
		.getDec());
		//61
		final Statement Statement_62_Var
		 = (Statement)LabeledStatement_44_Var
		.getLStmt();
		Assert.assertNotNull(Statement_62_Var
		);
		//62
		final JumpStatement JumpStatement_63_Var
		 = (JumpStatement)Statement_62_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_63_Var
		);
		Assert.assertEquals("return", JumpStatement_63_Var
		.getReturn());
		//63
		final Expression Expression_64_Var
		 = (Expression)JumpStatement_63_Var
		.getExpr();
		Assert.assertNotNull(Expression_64_Var
		);
		final EList<? extends EObject> ExprExpr_64_list = Expression_64_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_64_list);
		Assert.assertEquals(1, ExprExpr_64_list.size());
		//64
		final AssignmentExpression AssignmentExpression_65_Var
		 = (AssignmentExpression)ExprExpr_64_list.get(0);
		Assert.assertNotNull(AssignmentExpression_65_Var
		);
		//65
		final ConditionalExpression ConditionalExpression_66_Var
		 = (ConditionalExpression)AssignmentExpression_65_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_66_Var
		);
		//66
		final LogicalOrExpression LogicalOrExpression_67_Var
		 = (LogicalOrExpression)ConditionalExpression_66_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = LogicalOrExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final LogicalAndExpression LogicalAndExpression_68_Var
		 = (LogicalAndExpression)Expr_67_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = LogicalAndExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final InclusiveOrExpression InclusiveOrExpression_69_Var
		 = (InclusiveOrExpression)Expr_68_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = InclusiveOrExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final ExclusiveOrExpression ExclusiveOrExpression_70_Var
		 = (ExclusiveOrExpression)Expr_69_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = ExclusiveOrExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final AndExpression AndExpression_71_Var
		 = (AndExpression)Expr_70_list.get(0);
		Assert.assertNotNull(AndExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = AndExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final EqualityExpression EqualityExpression_72_Var
		 = (EqualityExpression)Expr_71_list.get(0);
		Assert.assertNotNull(EqualityExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = EqualityExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final RelationalExpression RelationalExpression_73_Var
		 = (RelationalExpression)Expr_72_list.get(0);
		Assert.assertNotNull(RelationalExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = RelationalExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final ShiftExpression ShiftExpression_74_Var
		 = (ShiftExpression)Expr_73_list.get(0);
		Assert.assertNotNull(ShiftExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = ShiftExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final AdditiveExpression AdditiveExpression_75_Var
		 = (AdditiveExpression)Expr_74_list.get(0);
		Assert.assertNotNull(AdditiveExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = AdditiveExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final MultiplicativeExpression MultiplicativeExpression_76_Var
		 = (MultiplicativeExpression)Expr_75_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = MultiplicativeExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final CastExpression CastExpression_77_Var
		 = (CastExpression)Expr_76_list.get(0);
		Assert.assertNotNull(CastExpression_77_Var
		);
		//77
		final UnaryExpression UnaryExpression_78_Var
		 = (UnaryExpression)CastExpression_77_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_78_Var
		);
		//78
		final PostfixExpression PostfixExpression_79_Var
		 = (PostfixExpression)UnaryExpression_78_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = PostfixExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final PrimaryExpression PrimaryExpression_80_Var
		 = (PrimaryExpression)Expr_79_list.get(0);
		Assert.assertNotNull(PrimaryExpression_80_Var
		);
		//80
		final Constant Constant_81_Var
		 = (Constant)PrimaryExpression_80_Var
		.getConst();
		Assert.assertNotNull(Constant_81_Var
		);
		Assert.assertEquals("0", Constant_81_Var
		.getDec());
		Assert.assertEquals(";", JumpStatement_63_Var
		.getSemi());
		//81
		final Statement Statement_82_Var
		 = (Statement)Statement_42_list.get(1);
		Assert.assertNotNull(Statement_82_Var
		);
		//82
		final LabeledStatement LabeledStatement_83_Var
		 = (LabeledStatement)Statement_82_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_83_Var
		);
		Assert.assertEquals("case", LabeledStatement_83_Var
		.getCase());
		//83
		final ConstantExpression ConstantExpression_84_Var
		 = (ConstantExpression)LabeledStatement_83_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_84_Var
		);
		//84
		final ConditionalExpression ConditionalExpression_85_Var
		 = (ConditionalExpression)ConstantExpression_84_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_85_Var
		);
		//85
		final LogicalOrExpression LogicalOrExpression_86_Var
		 = (LogicalOrExpression)ConditionalExpression_85_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = LogicalOrExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final LogicalAndExpression LogicalAndExpression_87_Var
		 = (LogicalAndExpression)Expr_86_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = LogicalAndExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final InclusiveOrExpression InclusiveOrExpression_88_Var
		 = (InclusiveOrExpression)Expr_87_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = InclusiveOrExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final ExclusiveOrExpression ExclusiveOrExpression_89_Var
		 = (ExclusiveOrExpression)Expr_88_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = ExclusiveOrExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final AndExpression AndExpression_90_Var
		 = (AndExpression)Expr_89_list.get(0);
		Assert.assertNotNull(AndExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = AndExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final EqualityExpression EqualityExpression_91_Var
		 = (EqualityExpression)Expr_90_list.get(0);
		Assert.assertNotNull(EqualityExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = EqualityExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final RelationalExpression RelationalExpression_92_Var
		 = (RelationalExpression)Expr_91_list.get(0);
		Assert.assertNotNull(RelationalExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = RelationalExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final ShiftExpression ShiftExpression_93_Var
		 = (ShiftExpression)Expr_92_list.get(0);
		Assert.assertNotNull(ShiftExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = ShiftExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final AdditiveExpression AdditiveExpression_94_Var
		 = (AdditiveExpression)Expr_93_list.get(0);
		Assert.assertNotNull(AdditiveExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = AdditiveExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final MultiplicativeExpression MultiplicativeExpression_95_Var
		 = (MultiplicativeExpression)Expr_94_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = MultiplicativeExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final CastExpression CastExpression_96_Var
		 = (CastExpression)Expr_95_list.get(0);
		Assert.assertNotNull(CastExpression_96_Var
		);
		//96
		final UnaryExpression UnaryExpression_97_Var
		 = (UnaryExpression)CastExpression_96_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_97_Var
		);
		//97
		final PostfixExpression PostfixExpression_98_Var
		 = (PostfixExpression)UnaryExpression_97_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = PostfixExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final PrimaryExpression PrimaryExpression_99_Var
		 = (PrimaryExpression)Expr_98_list.get(0);
		Assert.assertNotNull(PrimaryExpression_99_Var
		);
		//99
		final Constant Constant_100_Var
		 = (Constant)PrimaryExpression_99_Var
		.getConst();
		Assert.assertNotNull(Constant_100_Var
		);
		Assert.assertEquals("1", Constant_100_Var
		.getDec());
		//100
		final Statement Statement_101_Var
		 = (Statement)LabeledStatement_83_Var
		.getLStmt();
		Assert.assertNotNull(Statement_101_Var
		);
		//101
		final CompoundStatement CompoundStatement_102_Var
		 = (CompoundStatement)Statement_101_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_102_Var
		);
		//102
		final BodyStatement BodyStatement_103_Var
		 = (BodyStatement)CompoundStatement_102_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_103_Var
		);
		final EList<? extends EObject> BlockList_103_list = BodyStatement_103_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_103_list);
		Assert.assertEquals(1, BlockList_103_list.size());
		//103
		final BlockList BlockList_104_Var
		 = (BlockList)BlockList_103_list.get(0);
		Assert.assertNotNull(BlockList_104_Var
		);
		final EList<? extends EObject> Statement_104_list = BlockList_104_Var
		.getStatement();
		Assert.assertNotNull(Statement_104_list);
		Assert.assertEquals(1, Statement_104_list.size());
		//104
		final Statement Statement_105_Var
		 = (Statement)Statement_104_list.get(0);
		Assert.assertNotNull(Statement_105_Var
		);
		//105
		final JumpStatement JumpStatement_106_Var
		 = (JumpStatement)Statement_105_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_106_Var
		);
		Assert.assertEquals("break", JumpStatement_106_Var
		.getBreak());
		Assert.assertEquals(";", JumpStatement_106_Var
		.getSemi());
		//106
		final Statement Statement_107_Var
		 = (Statement)Statement_42_list.get(2);
		Assert.assertNotNull(Statement_107_Var
		);
		//107
		final LabeledStatement LabeledStatement_108_Var
		 = (LabeledStatement)Statement_107_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_108_Var
		);
		Assert.assertEquals("default", LabeledStatement_108_Var
		.getDefault());
		//108
		final Statement Statement_109_Var
		 = (Statement)LabeledStatement_108_Var
		.getLStmt();
		Assert.assertNotNull(Statement_109_Var
		);
		//109
		final CompoundStatement CompoundStatement_110_Var
		 = (CompoundStatement)Statement_109_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_110_Var
		);
		//110
		final BodyStatement BodyStatement_111_Var
		 = (BodyStatement)CompoundStatement_110_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_111_Var
		);
		final EList<? extends EObject> BlockList_111_list = BodyStatement_111_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_111_list);
		Assert.assertEquals(1, BlockList_111_list.size());
		//111
		final BlockList BlockList_112_Var
		 = (BlockList)BlockList_111_list.get(0);
		Assert.assertNotNull(BlockList_112_Var
		);
		final EList<? extends EObject> Statement_112_list = BlockList_112_Var
		.getStatement();
		Assert.assertNotNull(Statement_112_list);
		Assert.assertEquals(1, Statement_112_list.size());
		//112
		final Statement Statement_113_Var
		 = (Statement)Statement_112_list.get(0);
		Assert.assertNotNull(Statement_113_Var
		);
		//113
		final JumpStatement JumpStatement_114_Var
		 = (JumpStatement)Statement_113_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_114_Var
		);
		Assert.assertEquals("return", JumpStatement_114_Var
		.getReturn());
		//114
		final Expression Expression_115_Var
		 = (Expression)JumpStatement_114_Var
		.getExpr();
		Assert.assertNotNull(Expression_115_Var
		);
		final EList<? extends EObject> ExprExpr_115_list = Expression_115_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_115_list);
		Assert.assertEquals(1, ExprExpr_115_list.size());
		//115
		final AssignmentExpression AssignmentExpression_116_Var
		 = (AssignmentExpression)ExprExpr_115_list.get(0);
		Assert.assertNotNull(AssignmentExpression_116_Var
		);
		//116
		final ConditionalExpression ConditionalExpression_117_Var
		 = (ConditionalExpression)AssignmentExpression_116_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_117_Var
		);
		//117
		final LogicalOrExpression LogicalOrExpression_118_Var
		 = (LogicalOrExpression)ConditionalExpression_117_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = LogicalOrExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final LogicalAndExpression LogicalAndExpression_119_Var
		 = (LogicalAndExpression)Expr_118_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = LogicalAndExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final InclusiveOrExpression InclusiveOrExpression_120_Var
		 = (InclusiveOrExpression)Expr_119_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = InclusiveOrExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final ExclusiveOrExpression ExclusiveOrExpression_121_Var
		 = (ExclusiveOrExpression)Expr_120_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = ExclusiveOrExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final AndExpression AndExpression_122_Var
		 = (AndExpression)Expr_121_list.get(0);
		Assert.assertNotNull(AndExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = AndExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final EqualityExpression EqualityExpression_123_Var
		 = (EqualityExpression)Expr_122_list.get(0);
		Assert.assertNotNull(EqualityExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = EqualityExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final RelationalExpression RelationalExpression_124_Var
		 = (RelationalExpression)Expr_123_list.get(0);
		Assert.assertNotNull(RelationalExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = RelationalExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final ShiftExpression ShiftExpression_125_Var
		 = (ShiftExpression)Expr_124_list.get(0);
		Assert.assertNotNull(ShiftExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = ShiftExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final AdditiveExpression AdditiveExpression_126_Var
		 = (AdditiveExpression)Expr_125_list.get(0);
		Assert.assertNotNull(AdditiveExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = AdditiveExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final MultiplicativeExpression MultiplicativeExpression_127_Var
		 = (MultiplicativeExpression)Expr_126_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = MultiplicativeExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final CastExpression CastExpression_128_Var
		 = (CastExpression)Expr_127_list.get(0);
		Assert.assertNotNull(CastExpression_128_Var
		);
		//128
		final UnaryExpression UnaryExpression_129_Var
		 = (UnaryExpression)CastExpression_128_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_129_Var
		);
		//129
		final PostfixExpression PostfixExpression_130_Var
		 = (PostfixExpression)UnaryExpression_129_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = PostfixExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final PrimaryExpression PrimaryExpression_131_Var
		 = (PrimaryExpression)Expr_130_list.get(0);
		Assert.assertNotNull(PrimaryExpression_131_Var
		);
		//131
		final Constant Constant_132_Var
		 = (Constant)PrimaryExpression_131_Var
		.getConst();
		Assert.assertNotNull(Constant_132_Var
		);
		Assert.assertEquals("2", Constant_132_Var
		.getDec());
		Assert.assertEquals(";", JumpStatement_114_Var
		.getSemi());
		//132
		final Statement Statement_133_Var
		 = (Statement)Statement_19_list.get(1);
		Assert.assertNotNull(Statement_133_Var
		);
		//133
		final JumpStatement JumpStatement_134_Var
		 = (JumpStatement)Statement_133_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_134_Var
		);
		//134
		final Expression Expression_135_Var
		 = (Expression)JumpStatement_134_Var
		.getExpr();
		Assert.assertNotNull(Expression_135_Var
		);
		final EList<? extends EObject> ExprExpr_135_list = Expression_135_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_135_list);
		Assert.assertEquals(1, ExprExpr_135_list.size());
		//135
		final AssignmentExpression AssignmentExpression_136_Var
		 = (AssignmentExpression)ExprExpr_135_list.get(0);
		Assert.assertNotNull(AssignmentExpression_136_Var
		);
		//136
		final ConditionalExpression ConditionalExpression_137_Var
		 = (ConditionalExpression)AssignmentExpression_136_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_137_Var
		);
		//137
		final LogicalOrExpression LogicalOrExpression_138_Var
		 = (LogicalOrExpression)ConditionalExpression_137_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = LogicalOrExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final LogicalAndExpression LogicalAndExpression_139_Var
		 = (LogicalAndExpression)Expr_138_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = LogicalAndExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final InclusiveOrExpression InclusiveOrExpression_140_Var
		 = (InclusiveOrExpression)Expr_139_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = InclusiveOrExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final ExclusiveOrExpression ExclusiveOrExpression_141_Var
		 = (ExclusiveOrExpression)Expr_140_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = ExclusiveOrExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final AndExpression AndExpression_142_Var
		 = (AndExpression)Expr_141_list.get(0);
		Assert.assertNotNull(AndExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = AndExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final EqualityExpression EqualityExpression_143_Var
		 = (EqualityExpression)Expr_142_list.get(0);
		Assert.assertNotNull(EqualityExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = EqualityExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final RelationalExpression RelationalExpression_144_Var
		 = (RelationalExpression)Expr_143_list.get(0);
		Assert.assertNotNull(RelationalExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = RelationalExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final ShiftExpression ShiftExpression_145_Var
		 = (ShiftExpression)Expr_144_list.get(0);
		Assert.assertNotNull(ShiftExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = ShiftExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final AdditiveExpression AdditiveExpression_146_Var
		 = (AdditiveExpression)Expr_145_list.get(0);
		Assert.assertNotNull(AdditiveExpression_146_Var
		);
		final EList<? extends EObject> Expr_146_list = AdditiveExpression_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final MultiplicativeExpression MultiplicativeExpression_147_Var
		 = (MultiplicativeExpression)Expr_146_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_147_Var
		);
		final EList<? extends EObject> Expr_147_list = MultiplicativeExpression_147_Var
		.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(1, Expr_147_list.size());
		//147
		final CastExpression CastExpression_148_Var
		 = (CastExpression)Expr_147_list.get(0);
		Assert.assertNotNull(CastExpression_148_Var
		);
		//148
		final UnaryExpression UnaryExpression_149_Var
		 = (UnaryExpression)CastExpression_148_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_149_Var
		);
		//149
		final PostfixExpression PostfixExpression_150_Var
		 = (PostfixExpression)UnaryExpression_149_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_150_Var
		);
		final EList<? extends EObject> Expr_150_list = PostfixExpression_150_Var
		.getExpr();
		Assert.assertNotNull(Expr_150_list);
		Assert.assertEquals(1, Expr_150_list.size());
		//150
		final PrimaryExpression PrimaryExpression_151_Var
		 = (PrimaryExpression)Expr_150_list.get(0);
		Assert.assertNotNull(PrimaryExpression_151_Var
		);
		//151
		final Constant Constant_152_Var
		 = (Constant)PrimaryExpression_151_Var
		.getConst();
		Assert.assertNotNull(Constant_152_Var
		);
		Assert.assertEquals("1", Constant_152_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_134_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_134_Var
		.getSemi());
	}
	
	@Test
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


