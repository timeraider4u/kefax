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
public class Test0063_SwitchWithEllipsis {
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
			"res/Test0063_SwitchWithEllipsis.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_CHAR",
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
				"RULE_WHITESPACE",
				"RULE_SKW_DOT",
				"RULE_SKW_DOT",
				"RULE_SKW_DOT",
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
				"RULE_CHAR_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_DOT",
				"RULE_SKW_DOT",
				"RULE_SKW_DOT",
				"RULE_WHITESPACE",
				"RULE_CHAR_LITERAL",
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
			"res/Test0063_SwitchWithEllipsis.c");
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
		Assert.assertEquals("char", TypeSpecifier_13_Var
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
		Assert.assertEquals("0", LabeledStatement_43_Var
		.getLower());
		Assert.assertEquals("28", LabeledStatement_43_Var
		.getHigher());
		//43
		final Statement Statement_44_Var
		 = (Statement)LabeledStatement_43_Var
		.getLStmt();
		Assert.assertNotNull(Statement_44_Var
		);
		//44
		final JumpStatement JumpStatement_45_Var
		 = (JumpStatement)Statement_44_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_45_Var
		);
		Assert.assertEquals("return", JumpStatement_45_Var
		.getReturn());
		//45
		final Expression Expression_46_Var
		 = (Expression)JumpStatement_45_Var
		.getExpr();
		Assert.assertNotNull(Expression_46_Var
		);
		final EList<? extends EObject> ExprExpr_46_list = Expression_46_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_46_list);
		Assert.assertEquals(1, ExprExpr_46_list.size());
		//46
		final AssignmentExpression AssignmentExpression_47_Var
		 = (AssignmentExpression)ExprExpr_46_list.get(0);
		Assert.assertNotNull(AssignmentExpression_47_Var
		);
		//47
		final ConditionalExpression ConditionalExpression_48_Var
		 = (ConditionalExpression)AssignmentExpression_47_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_48_Var
		);
		//48
		final LogicalOrExpression LogicalOrExpression_49_Var
		 = (LogicalOrExpression)ConditionalExpression_48_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = LogicalOrExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final LogicalAndExpression LogicalAndExpression_50_Var
		 = (LogicalAndExpression)Expr_49_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = LogicalAndExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final InclusiveOrExpression InclusiveOrExpression_51_Var
		 = (InclusiveOrExpression)Expr_50_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = InclusiveOrExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final ExclusiveOrExpression ExclusiveOrExpression_52_Var
		 = (ExclusiveOrExpression)Expr_51_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = ExclusiveOrExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final AndExpression AndExpression_53_Var
		 = (AndExpression)Expr_52_list.get(0);
		Assert.assertNotNull(AndExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = AndExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final EqualityExpression EqualityExpression_54_Var
		 = (EqualityExpression)Expr_53_list.get(0);
		Assert.assertNotNull(EqualityExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = EqualityExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final RelationalExpression RelationalExpression_55_Var
		 = (RelationalExpression)Expr_54_list.get(0);
		Assert.assertNotNull(RelationalExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = RelationalExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final ShiftExpression ShiftExpression_56_Var
		 = (ShiftExpression)Expr_55_list.get(0);
		Assert.assertNotNull(ShiftExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = ShiftExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final AdditiveExpression AdditiveExpression_57_Var
		 = (AdditiveExpression)Expr_56_list.get(0);
		Assert.assertNotNull(AdditiveExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = AdditiveExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final MultiplicativeExpression MultiplicativeExpression_58_Var
		 = (MultiplicativeExpression)Expr_57_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = MultiplicativeExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final CastExpression CastExpression_59_Var
		 = (CastExpression)Expr_58_list.get(0);
		Assert.assertNotNull(CastExpression_59_Var
		);
		//59
		final UnaryExpression UnaryExpression_60_Var
		 = (UnaryExpression)CastExpression_59_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_60_Var
		);
		//60
		final PostfixExpression PostfixExpression_61_Var
		 = (PostfixExpression)UnaryExpression_60_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = PostfixExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final PrimaryExpression PrimaryExpression_62_Var
		 = (PrimaryExpression)Expr_61_list.get(0);
		Assert.assertNotNull(PrimaryExpression_62_Var
		);
		//62
		final Constant2 Constant2_63_Var
		 = (Constant2)PrimaryExpression_62_Var
		.getConst();
		Assert.assertNotNull(Constant2_63_Var
		);
		Assert.assertEquals("0", Constant2_63_Var
		.getDec());
		//63
		final Statement Statement_64_Var
		 = (Statement)Statement_41_list.get(1);
		Assert.assertNotNull(Statement_64_Var
		);
		//64
		final LabeledStatement LabeledStatement_65_Var
		 = (LabeledStatement)Statement_64_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_65_Var
		);
		Assert.assertEquals("case", LabeledStatement_65_Var
		.getCase());
		Assert.assertEquals("'0'", LabeledStatement_65_Var
		.getLower());
		Assert.assertEquals("'7'", LabeledStatement_65_Var
		.getHigher());
		//65
		final Statement Statement_66_Var
		 = (Statement)LabeledStatement_65_Var
		.getLStmt();
		Assert.assertNotNull(Statement_66_Var
		);
		//66
		final CompoundStatement CompoundStatement_67_Var
		 = (CompoundStatement)Statement_66_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_67_Var
		);
		//67
		final BodyStatement BodyStatement_68_Var
		 = (BodyStatement)CompoundStatement_67_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_68_Var
		);
		final EList<? extends EObject> BlockList_68_list = BodyStatement_68_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_68_list);
		Assert.assertEquals(1, BlockList_68_list.size());
		//68
		final BlockList BlockList_69_Var
		 = (BlockList)BlockList_68_list.get(0);
		Assert.assertNotNull(BlockList_69_Var
		);
		final EList<? extends EObject> Statement_69_list = BlockList_69_Var
		.getStatement();
		Assert.assertNotNull(Statement_69_list);
		Assert.assertEquals(1, Statement_69_list.size());
		//69
		final Statement Statement_70_Var
		 = (Statement)Statement_69_list.get(0);
		Assert.assertNotNull(Statement_70_Var
		);
		//70
		final JumpStatement JumpStatement_71_Var
		 = (JumpStatement)Statement_70_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_71_Var
		);
		Assert.assertEquals("break", JumpStatement_71_Var
		.getBreak());
		//71
		final Statement Statement_72_Var
		 = (Statement)Statement_41_list.get(2);
		Assert.assertNotNull(Statement_72_Var
		);
		//72
		final LabeledStatement LabeledStatement_73_Var
		 = (LabeledStatement)Statement_72_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_73_Var
		);
		Assert.assertTrue(LabeledStatement_73_Var
		.isMydefault());
		//73
		final Statement Statement_74_Var
		 = (Statement)LabeledStatement_73_Var
		.getLStmt();
		Assert.assertNotNull(Statement_74_Var
		);
		//74
		final CompoundStatement CompoundStatement_75_Var
		 = (CompoundStatement)Statement_74_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_75_Var
		);
		//75
		final BodyStatement BodyStatement_76_Var
		 = (BodyStatement)CompoundStatement_75_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_76_Var
		);
		final EList<? extends EObject> BlockList_76_list = BodyStatement_76_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_76_list);
		Assert.assertEquals(1, BlockList_76_list.size());
		//76
		final BlockList BlockList_77_Var
		 = (BlockList)BlockList_76_list.get(0);
		Assert.assertNotNull(BlockList_77_Var
		);
		final EList<? extends EObject> Statement_77_list = BlockList_77_Var
		.getStatement();
		Assert.assertNotNull(Statement_77_list);
		Assert.assertEquals(1, Statement_77_list.size());
		//77
		final Statement Statement_78_Var
		 = (Statement)Statement_77_list.get(0);
		Assert.assertNotNull(Statement_78_Var
		);
		//78
		final JumpStatement JumpStatement_79_Var
		 = (JumpStatement)Statement_78_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_79_Var
		);
		Assert.assertEquals("return", JumpStatement_79_Var
		.getReturn());
		//79
		final Expression Expression_80_Var
		 = (Expression)JumpStatement_79_Var
		.getExpr();
		Assert.assertNotNull(Expression_80_Var
		);
		final EList<? extends EObject> ExprExpr_80_list = Expression_80_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_80_list);
		Assert.assertEquals(1, ExprExpr_80_list.size());
		//80
		final AssignmentExpression AssignmentExpression_81_Var
		 = (AssignmentExpression)ExprExpr_80_list.get(0);
		Assert.assertNotNull(AssignmentExpression_81_Var
		);
		//81
		final ConditionalExpression ConditionalExpression_82_Var
		 = (ConditionalExpression)AssignmentExpression_81_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_82_Var
		);
		//82
		final LogicalOrExpression LogicalOrExpression_83_Var
		 = (LogicalOrExpression)ConditionalExpression_82_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = LogicalOrExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final LogicalAndExpression LogicalAndExpression_84_Var
		 = (LogicalAndExpression)Expr_83_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = LogicalAndExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final InclusiveOrExpression InclusiveOrExpression_85_Var
		 = (InclusiveOrExpression)Expr_84_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = InclusiveOrExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final ExclusiveOrExpression ExclusiveOrExpression_86_Var
		 = (ExclusiveOrExpression)Expr_85_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = ExclusiveOrExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final AndExpression AndExpression_87_Var
		 = (AndExpression)Expr_86_list.get(0);
		Assert.assertNotNull(AndExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = AndExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final EqualityExpression EqualityExpression_88_Var
		 = (EqualityExpression)Expr_87_list.get(0);
		Assert.assertNotNull(EqualityExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = EqualityExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final RelationalExpression RelationalExpression_89_Var
		 = (RelationalExpression)Expr_88_list.get(0);
		Assert.assertNotNull(RelationalExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = RelationalExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final ShiftExpression ShiftExpression_90_Var
		 = (ShiftExpression)Expr_89_list.get(0);
		Assert.assertNotNull(ShiftExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = ShiftExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final AdditiveExpression AdditiveExpression_91_Var
		 = (AdditiveExpression)Expr_90_list.get(0);
		Assert.assertNotNull(AdditiveExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = AdditiveExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final MultiplicativeExpression MultiplicativeExpression_92_Var
		 = (MultiplicativeExpression)Expr_91_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = MultiplicativeExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final CastExpression CastExpression_93_Var
		 = (CastExpression)Expr_92_list.get(0);
		Assert.assertNotNull(CastExpression_93_Var
		);
		//93
		final UnaryExpression UnaryExpression_94_Var
		 = (UnaryExpression)CastExpression_93_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_94_Var
		);
		//94
		final PostfixExpression PostfixExpression_95_Var
		 = (PostfixExpression)UnaryExpression_94_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = PostfixExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final PrimaryExpression PrimaryExpression_96_Var
		 = (PrimaryExpression)Expr_95_list.get(0);
		Assert.assertNotNull(PrimaryExpression_96_Var
		);
		//96
		final Constant2 Constant2_97_Var
		 = (Constant2)PrimaryExpression_96_Var
		.getConst();
		Assert.assertNotNull(Constant2_97_Var
		);
		Assert.assertEquals("2", Constant2_97_Var
		.getDec());
		//97
		final Statement Statement_98_Var
		 = (Statement)Statement_18_list.get(1);
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
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0063_SwitchWithEllipsis.c");
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
				method.invoke(this.generator, "Test0063_SwitchWithEllipsis.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0063_SwitchWithEllipsis.c");
		final String expected = this.getTextFromFile(
			"res/Test0063_SwitchWithEllipsis.c"
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


