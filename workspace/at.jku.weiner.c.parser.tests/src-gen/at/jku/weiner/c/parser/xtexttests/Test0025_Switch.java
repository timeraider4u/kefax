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
		Assert.assertEquals(2, Statement_20_list.size());
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
		Assert.assertEquals("switch", SelectionStatement_22_Var
		.getSwitch());
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
		final EList<? extends EObject> Expr_32_list = RelationalExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
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
		final Statement Statement_40_Var
		 = (Statement)SelectionStatement_22_Var
		.getSwitchStatement();
		Assert.assertNotNull(Statement_40_Var
		);
		//40
		final CompoundStatement CompoundStatement_41_Var
		 = (CompoundStatement)Statement_40_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_41_Var
		);
		//41
		final BodyStatement BodyStatement_42_Var
		 = (BodyStatement)CompoundStatement_41_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_42_Var
		);
		final EList<? extends EObject> BlockList_42_list = BodyStatement_42_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_42_list);
		Assert.assertEquals(1, BlockList_42_list.size());
		//42
		final BlockList BlockList_43_Var
		 = (BlockList)BlockList_42_list.get(0);
		Assert.assertNotNull(BlockList_43_Var
		);
		final EList<? extends EObject> Statement_43_list = BlockList_43_Var
		.getStatement();
		Assert.assertNotNull(Statement_43_list);
		Assert.assertEquals(3, Statement_43_list.size());
		//43
		final Statement Statement_44_Var
		 = (Statement)Statement_43_list.get(0);
		Assert.assertNotNull(Statement_44_Var
		);
		//44
		final LabeledStatement LabeledStatement_45_Var
		 = (LabeledStatement)Statement_44_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_45_Var
		);
		Assert.assertEquals("case", LabeledStatement_45_Var
		.getCase());
		//45
		final ConstantExpression ConstantExpression_46_Var
		 = (ConstantExpression)LabeledStatement_45_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_46_Var
		);
		//46
		final ConditionalExpression ConditionalExpression_47_Var
		 = (ConditionalExpression)ConstantExpression_46_Var
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
		final EList<? extends EObject> Expr_54_list = RelationalExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
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
		//61
		final Constant2 Constant2_62_Var
		 = (Constant2)PrimaryExpression_61_Var
		.getConst();
		Assert.assertNotNull(Constant2_62_Var
		);
		Assert.assertEquals("0", Constant2_62_Var
		.getDec());
		//62
		final Statement Statement_63_Var
		 = (Statement)LabeledStatement_45_Var
		.getLStmt();
		Assert.assertNotNull(Statement_63_Var
		);
		//63
		final JumpStatement JumpStatement_64_Var
		 = (JumpStatement)Statement_63_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_64_Var
		);
		Assert.assertEquals("return", JumpStatement_64_Var
		.getReturn());
		//64
		final Expression Expression_65_Var
		 = (Expression)JumpStatement_64_Var
		.getExpr();
		Assert.assertNotNull(Expression_65_Var
		);
		final EList<? extends EObject> ExprExpr_65_list = Expression_65_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_65_list);
		Assert.assertEquals(1, ExprExpr_65_list.size());
		//65
		final AssignmentExpression AssignmentExpression_66_Var
		 = (AssignmentExpression)ExprExpr_65_list.get(0);
		Assert.assertNotNull(AssignmentExpression_66_Var
		);
		//66
		final ConditionalExpression ConditionalExpression_67_Var
		 = (ConditionalExpression)AssignmentExpression_66_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_67_Var
		);
		//67
		final LogicalOrExpression LogicalOrExpression_68_Var
		 = (LogicalOrExpression)ConditionalExpression_67_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = LogicalOrExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final LogicalAndExpression LogicalAndExpression_69_Var
		 = (LogicalAndExpression)Expr_68_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = LogicalAndExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final InclusiveOrExpression InclusiveOrExpression_70_Var
		 = (InclusiveOrExpression)Expr_69_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = InclusiveOrExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final ExclusiveOrExpression ExclusiveOrExpression_71_Var
		 = (ExclusiveOrExpression)Expr_70_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = ExclusiveOrExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final AndExpression AndExpression_72_Var
		 = (AndExpression)Expr_71_list.get(0);
		Assert.assertNotNull(AndExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = AndExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final EqualityExpression EqualityExpression_73_Var
		 = (EqualityExpression)Expr_72_list.get(0);
		Assert.assertNotNull(EqualityExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = EqualityExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final RelationalExpression RelationalExpression_74_Var
		 = (RelationalExpression)Expr_73_list.get(0);
		Assert.assertNotNull(RelationalExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = RelationalExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final ShiftExpression ShiftExpression_75_Var
		 = (ShiftExpression)Expr_74_list.get(0);
		Assert.assertNotNull(ShiftExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = ShiftExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final AdditiveExpression AdditiveExpression_76_Var
		 = (AdditiveExpression)Expr_75_list.get(0);
		Assert.assertNotNull(AdditiveExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = AdditiveExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final MultiplicativeExpression MultiplicativeExpression_77_Var
		 = (MultiplicativeExpression)Expr_76_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = MultiplicativeExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final CastExpression CastExpression_78_Var
		 = (CastExpression)Expr_77_list.get(0);
		Assert.assertNotNull(CastExpression_78_Var
		);
		//78
		final UnaryExpression UnaryExpression_79_Var
		 = (UnaryExpression)CastExpression_78_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_79_Var
		);
		//79
		final PostfixExpression PostfixExpression_80_Var
		 = (PostfixExpression)UnaryExpression_79_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = PostfixExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final PrimaryExpression PrimaryExpression_81_Var
		 = (PrimaryExpression)Expr_80_list.get(0);
		Assert.assertNotNull(PrimaryExpression_81_Var
		);
		//81
		final Constant2 Constant2_82_Var
		 = (Constant2)PrimaryExpression_81_Var
		.getConst();
		Assert.assertNotNull(Constant2_82_Var
		);
		Assert.assertEquals("0", Constant2_82_Var
		.getDec());
		Assert.assertEquals(";", JumpStatement_64_Var
		.getSemi());
		//82
		final Statement Statement_83_Var
		 = (Statement)Statement_43_list.get(1);
		Assert.assertNotNull(Statement_83_Var
		);
		//83
		final LabeledStatement LabeledStatement_84_Var
		 = (LabeledStatement)Statement_83_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_84_Var
		);
		Assert.assertEquals("case", LabeledStatement_84_Var
		.getCase());
		//84
		final ConstantExpression ConstantExpression_85_Var
		 = (ConstantExpression)LabeledStatement_84_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_85_Var
		);
		//85
		final ConditionalExpression ConditionalExpression_86_Var
		 = (ConditionalExpression)ConstantExpression_85_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_86_Var
		);
		//86
		final LogicalOrExpression LogicalOrExpression_87_Var
		 = (LogicalOrExpression)ConditionalExpression_86_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = LogicalOrExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final LogicalAndExpression LogicalAndExpression_88_Var
		 = (LogicalAndExpression)Expr_87_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = LogicalAndExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final InclusiveOrExpression InclusiveOrExpression_89_Var
		 = (InclusiveOrExpression)Expr_88_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = InclusiveOrExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final ExclusiveOrExpression ExclusiveOrExpression_90_Var
		 = (ExclusiveOrExpression)Expr_89_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = ExclusiveOrExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final AndExpression AndExpression_91_Var
		 = (AndExpression)Expr_90_list.get(0);
		Assert.assertNotNull(AndExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = AndExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final EqualityExpression EqualityExpression_92_Var
		 = (EqualityExpression)Expr_91_list.get(0);
		Assert.assertNotNull(EqualityExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = EqualityExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final RelationalExpression RelationalExpression_93_Var
		 = (RelationalExpression)Expr_92_list.get(0);
		Assert.assertNotNull(RelationalExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = RelationalExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final ShiftExpression ShiftExpression_94_Var
		 = (ShiftExpression)Expr_93_list.get(0);
		Assert.assertNotNull(ShiftExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = ShiftExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final AdditiveExpression AdditiveExpression_95_Var
		 = (AdditiveExpression)Expr_94_list.get(0);
		Assert.assertNotNull(AdditiveExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = AdditiveExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final MultiplicativeExpression MultiplicativeExpression_96_Var
		 = (MultiplicativeExpression)Expr_95_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = MultiplicativeExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final CastExpression CastExpression_97_Var
		 = (CastExpression)Expr_96_list.get(0);
		Assert.assertNotNull(CastExpression_97_Var
		);
		//97
		final UnaryExpression UnaryExpression_98_Var
		 = (UnaryExpression)CastExpression_97_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_98_Var
		);
		//98
		final PostfixExpression PostfixExpression_99_Var
		 = (PostfixExpression)UnaryExpression_98_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = PostfixExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final PrimaryExpression PrimaryExpression_100_Var
		 = (PrimaryExpression)Expr_99_list.get(0);
		Assert.assertNotNull(PrimaryExpression_100_Var
		);
		//100
		final Constant2 Constant2_101_Var
		 = (Constant2)PrimaryExpression_100_Var
		.getConst();
		Assert.assertNotNull(Constant2_101_Var
		);
		Assert.assertEquals("1", Constant2_101_Var
		.getDec());
		//101
		final Statement Statement_102_Var
		 = (Statement)LabeledStatement_84_Var
		.getLStmt();
		Assert.assertNotNull(Statement_102_Var
		);
		//102
		final CompoundStatement CompoundStatement_103_Var
		 = (CompoundStatement)Statement_102_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_103_Var
		);
		//103
		final BodyStatement BodyStatement_104_Var
		 = (BodyStatement)CompoundStatement_103_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_104_Var
		);
		final EList<? extends EObject> BlockList_104_list = BodyStatement_104_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_104_list);
		Assert.assertEquals(1, BlockList_104_list.size());
		//104
		final BlockList BlockList_105_Var
		 = (BlockList)BlockList_104_list.get(0);
		Assert.assertNotNull(BlockList_105_Var
		);
		final EList<? extends EObject> Statement_105_list = BlockList_105_Var
		.getStatement();
		Assert.assertNotNull(Statement_105_list);
		Assert.assertEquals(1, Statement_105_list.size());
		//105
		final Statement Statement_106_Var
		 = (Statement)Statement_105_list.get(0);
		Assert.assertNotNull(Statement_106_Var
		);
		//106
		final JumpStatement JumpStatement_107_Var
		 = (JumpStatement)Statement_106_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_107_Var
		);
		Assert.assertEquals("break", JumpStatement_107_Var
		.getBreak());
		Assert.assertEquals(";", JumpStatement_107_Var
		.getSemi());
		//107
		final Statement Statement_108_Var
		 = (Statement)Statement_43_list.get(2);
		Assert.assertNotNull(Statement_108_Var
		);
		//108
		final LabeledStatement LabeledStatement_109_Var
		 = (LabeledStatement)Statement_108_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_109_Var
		);
		Assert.assertEquals("default", LabeledStatement_109_Var
		.getDefault());
		//109
		final Statement Statement_110_Var
		 = (Statement)LabeledStatement_109_Var
		.getLStmt();
		Assert.assertNotNull(Statement_110_Var
		);
		//110
		final CompoundStatement CompoundStatement_111_Var
		 = (CompoundStatement)Statement_110_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_111_Var
		);
		//111
		final BodyStatement BodyStatement_112_Var
		 = (BodyStatement)CompoundStatement_111_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_112_Var
		);
		final EList<? extends EObject> BlockList_112_list = BodyStatement_112_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_112_list);
		Assert.assertEquals(1, BlockList_112_list.size());
		//112
		final BlockList BlockList_113_Var
		 = (BlockList)BlockList_112_list.get(0);
		Assert.assertNotNull(BlockList_113_Var
		);
		final EList<? extends EObject> Statement_113_list = BlockList_113_Var
		.getStatement();
		Assert.assertNotNull(Statement_113_list);
		Assert.assertEquals(1, Statement_113_list.size());
		//113
		final Statement Statement_114_Var
		 = (Statement)Statement_113_list.get(0);
		Assert.assertNotNull(Statement_114_Var
		);
		//114
		final JumpStatement JumpStatement_115_Var
		 = (JumpStatement)Statement_114_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_115_Var
		);
		Assert.assertEquals("return", JumpStatement_115_Var
		.getReturn());
		//115
		final Expression Expression_116_Var
		 = (Expression)JumpStatement_115_Var
		.getExpr();
		Assert.assertNotNull(Expression_116_Var
		);
		final EList<? extends EObject> ExprExpr_116_list = Expression_116_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_116_list);
		Assert.assertEquals(1, ExprExpr_116_list.size());
		//116
		final AssignmentExpression AssignmentExpression_117_Var
		 = (AssignmentExpression)ExprExpr_116_list.get(0);
		Assert.assertNotNull(AssignmentExpression_117_Var
		);
		//117
		final ConditionalExpression ConditionalExpression_118_Var
		 = (ConditionalExpression)AssignmentExpression_117_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_118_Var
		);
		//118
		final LogicalOrExpression LogicalOrExpression_119_Var
		 = (LogicalOrExpression)ConditionalExpression_118_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = LogicalOrExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final LogicalAndExpression LogicalAndExpression_120_Var
		 = (LogicalAndExpression)Expr_119_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = LogicalAndExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final InclusiveOrExpression InclusiveOrExpression_121_Var
		 = (InclusiveOrExpression)Expr_120_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = InclusiveOrExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final ExclusiveOrExpression ExclusiveOrExpression_122_Var
		 = (ExclusiveOrExpression)Expr_121_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = ExclusiveOrExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final AndExpression AndExpression_123_Var
		 = (AndExpression)Expr_122_list.get(0);
		Assert.assertNotNull(AndExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = AndExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final EqualityExpression EqualityExpression_124_Var
		 = (EqualityExpression)Expr_123_list.get(0);
		Assert.assertNotNull(EqualityExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = EqualityExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final RelationalExpression RelationalExpression_125_Var
		 = (RelationalExpression)Expr_124_list.get(0);
		Assert.assertNotNull(RelationalExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = RelationalExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final ShiftExpression ShiftExpression_126_Var
		 = (ShiftExpression)Expr_125_list.get(0);
		Assert.assertNotNull(ShiftExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = ShiftExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final AdditiveExpression AdditiveExpression_127_Var
		 = (AdditiveExpression)Expr_126_list.get(0);
		Assert.assertNotNull(AdditiveExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = AdditiveExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final MultiplicativeExpression MultiplicativeExpression_128_Var
		 = (MultiplicativeExpression)Expr_127_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = MultiplicativeExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final CastExpression CastExpression_129_Var
		 = (CastExpression)Expr_128_list.get(0);
		Assert.assertNotNull(CastExpression_129_Var
		);
		//129
		final UnaryExpression UnaryExpression_130_Var
		 = (UnaryExpression)CastExpression_129_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_130_Var
		);
		//130
		final PostfixExpression PostfixExpression_131_Var
		 = (PostfixExpression)UnaryExpression_130_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = PostfixExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final PrimaryExpression PrimaryExpression_132_Var
		 = (PrimaryExpression)Expr_131_list.get(0);
		Assert.assertNotNull(PrimaryExpression_132_Var
		);
		//132
		final Constant2 Constant2_133_Var
		 = (Constant2)PrimaryExpression_132_Var
		.getConst();
		Assert.assertNotNull(Constant2_133_Var
		);
		Assert.assertEquals("2", Constant2_133_Var
		.getDec());
		Assert.assertEquals(";", JumpStatement_115_Var
		.getSemi());
		//133
		final Statement Statement_134_Var
		 = (Statement)Statement_20_list.get(1);
		Assert.assertNotNull(Statement_134_Var
		);
		//134
		final JumpStatement JumpStatement_135_Var
		 = (JumpStatement)Statement_134_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_135_Var
		);
		//135
		final Expression Expression_136_Var
		 = (Expression)JumpStatement_135_Var
		.getExpr();
		Assert.assertNotNull(Expression_136_Var
		);
		final EList<? extends EObject> ExprExpr_136_list = Expression_136_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_136_list);
		Assert.assertEquals(1, ExprExpr_136_list.size());
		//136
		final AssignmentExpression AssignmentExpression_137_Var
		 = (AssignmentExpression)ExprExpr_136_list.get(0);
		Assert.assertNotNull(AssignmentExpression_137_Var
		);
		//137
		final ConditionalExpression ConditionalExpression_138_Var
		 = (ConditionalExpression)AssignmentExpression_137_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_138_Var
		);
		//138
		final LogicalOrExpression LogicalOrExpression_139_Var
		 = (LogicalOrExpression)ConditionalExpression_138_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = LogicalOrExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final LogicalAndExpression LogicalAndExpression_140_Var
		 = (LogicalAndExpression)Expr_139_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = LogicalAndExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final InclusiveOrExpression InclusiveOrExpression_141_Var
		 = (InclusiveOrExpression)Expr_140_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = InclusiveOrExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final ExclusiveOrExpression ExclusiveOrExpression_142_Var
		 = (ExclusiveOrExpression)Expr_141_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = ExclusiveOrExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final AndExpression AndExpression_143_Var
		 = (AndExpression)Expr_142_list.get(0);
		Assert.assertNotNull(AndExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = AndExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final EqualityExpression EqualityExpression_144_Var
		 = (EqualityExpression)Expr_143_list.get(0);
		Assert.assertNotNull(EqualityExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = EqualityExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final RelationalExpression RelationalExpression_145_Var
		 = (RelationalExpression)Expr_144_list.get(0);
		Assert.assertNotNull(RelationalExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = RelationalExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final ShiftExpression ShiftExpression_146_Var
		 = (ShiftExpression)Expr_145_list.get(0);
		Assert.assertNotNull(ShiftExpression_146_Var
		);
		final EList<? extends EObject> Expr_146_list = ShiftExpression_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final AdditiveExpression AdditiveExpression_147_Var
		 = (AdditiveExpression)Expr_146_list.get(0);
		Assert.assertNotNull(AdditiveExpression_147_Var
		);
		final EList<? extends EObject> Expr_147_list = AdditiveExpression_147_Var
		.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(1, Expr_147_list.size());
		//147
		final MultiplicativeExpression MultiplicativeExpression_148_Var
		 = (MultiplicativeExpression)Expr_147_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_148_Var
		);
		final EList<? extends EObject> Expr_148_list = MultiplicativeExpression_148_Var
		.getExpr();
		Assert.assertNotNull(Expr_148_list);
		Assert.assertEquals(1, Expr_148_list.size());
		//148
		final CastExpression CastExpression_149_Var
		 = (CastExpression)Expr_148_list.get(0);
		Assert.assertNotNull(CastExpression_149_Var
		);
		//149
		final UnaryExpression UnaryExpression_150_Var
		 = (UnaryExpression)CastExpression_149_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_150_Var
		);
		//150
		final PostfixExpression PostfixExpression_151_Var
		 = (PostfixExpression)UnaryExpression_150_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_151_Var
		);
		final EList<? extends EObject> Expr_151_list = PostfixExpression_151_Var
		.getExpr();
		Assert.assertNotNull(Expr_151_list);
		Assert.assertEquals(1, Expr_151_list.size());
		//151
		final PrimaryExpression PrimaryExpression_152_Var
		 = (PrimaryExpression)Expr_151_list.get(0);
		Assert.assertNotNull(PrimaryExpression_152_Var
		);
		//152
		final Constant2 Constant2_153_Var
		 = (Constant2)PrimaryExpression_152_Var
		.getConst();
		Assert.assertNotNull(Constant2_153_Var
		);
		Assert.assertEquals("1", Constant2_153_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_135_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_135_Var
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


