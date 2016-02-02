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
import at.jku.weiner.c.parser.parser.FunctionDefinition;
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
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
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
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.UnaryOperator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
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
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
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
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0011_ReturnStmts {
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
			"res/Test0011_ReturnStmts.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_CHAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_CHAR_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_SKW_MINUS",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_DOUBLE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_FLOAT_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_FLOAT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_HEX_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
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
			"res/Test0011_ReturnStmts.c");
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
		Assert.assertEquals(5, External_0_list.size());
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
		Assert.assertEquals("char", TypeSpecifier_4_Var
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
		Assert.assertEquals("doSomething1", DirectDeclarator_6_Var
		.getId());
		//6
		final FunctionDefinition FunctionDefinition_7_Var
		 = (FunctionDefinition)ExternalDeclaration_1_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_7_Var
		);
		//7
		final BodyStatement BodyStatement_8_Var
		 = (BodyStatement)FunctionDefinition_7_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_8_Var
		);
		final EList<? extends EObject> BlockList_8_list = BodyStatement_8_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_8_list);
		Assert.assertEquals(1, BlockList_8_list.size());
		//8
		final BlockList BlockList_9_Var
		 = (BlockList)BlockList_8_list.get(0);
		Assert.assertNotNull(BlockList_9_Var
		);
		final EList<? extends EObject> Statement_9_list = BlockList_9_Var
		.getStatement();
		Assert.assertNotNull(Statement_9_list);
		Assert.assertEquals(1, Statement_9_list.size());
		//9
		final Statement Statement_10_Var
		 = (Statement)Statement_9_list.get(0);
		Assert.assertNotNull(Statement_10_Var
		);
		//10
		final JumpStatement JumpStatement_11_Var
		 = (JumpStatement)Statement_10_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_11_Var
		);
		//11
		final Expression Expression_12_Var
		 = (Expression)JumpStatement_11_Var
		.getExpr();
		Assert.assertNotNull(Expression_12_Var
		);
		final EList<? extends EObject> ExprExpr_12_list = Expression_12_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_12_list);
		Assert.assertEquals(1, ExprExpr_12_list.size());
		//12
		final AssignmentExpression AssignmentExpression_13_Var
		 = (AssignmentExpression)ExprExpr_12_list.get(0);
		Assert.assertNotNull(AssignmentExpression_13_Var
		);
		//13
		final ConditionalExpression ConditionalExpression_14_Var
		 = (ConditionalExpression)AssignmentExpression_13_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_14_Var
		);
		//14
		final LogicalOrExpression LogicalOrExpression_15_Var
		 = (LogicalOrExpression)ConditionalExpression_14_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = LogicalOrExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final LogicalAndExpression LogicalAndExpression_16_Var
		 = (LogicalAndExpression)Expr_15_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = LogicalAndExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final InclusiveOrExpression InclusiveOrExpression_17_Var
		 = (InclusiveOrExpression)Expr_16_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = InclusiveOrExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final ExclusiveOrExpression ExclusiveOrExpression_18_Var
		 = (ExclusiveOrExpression)Expr_17_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = ExclusiveOrExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final AndExpression AndExpression_19_Var
		 = (AndExpression)Expr_18_list.get(0);
		Assert.assertNotNull(AndExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = AndExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final EqualityExpression EqualityExpression_20_Var
		 = (EqualityExpression)Expr_19_list.get(0);
		Assert.assertNotNull(EqualityExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = EqualityExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final RelationalExpression RelationalExpression_21_Var
		 = (RelationalExpression)Expr_20_list.get(0);
		Assert.assertNotNull(RelationalExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = RelationalExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final ShiftExpression ShiftExpression_22_Var
		 = (ShiftExpression)Expr_21_list.get(0);
		Assert.assertNotNull(ShiftExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = ShiftExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final AdditiveExpression AdditiveExpression_23_Var
		 = (AdditiveExpression)Expr_22_list.get(0);
		Assert.assertNotNull(AdditiveExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = AdditiveExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final MultiplicativeExpression MultiplicativeExpression_24_Var
		 = (MultiplicativeExpression)Expr_23_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = MultiplicativeExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final CastExpression CastExpression_25_Var
		 = (CastExpression)Expr_24_list.get(0);
		Assert.assertNotNull(CastExpression_25_Var
		);
		//25
		final UnaryExpression UnaryExpression_26_Var
		 = (UnaryExpression)CastExpression_25_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_26_Var
		);
		//26
		final PostfixExpression PostfixExpression_27_Var
		 = (PostfixExpression)UnaryExpression_26_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = PostfixExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final PrimaryExpression PrimaryExpression_28_Var
		 = (PrimaryExpression)Expr_27_list.get(0);
		Assert.assertNotNull(PrimaryExpression_28_Var
		);
		//28
		final Constant2 Constant2_29_Var
		 = (Constant2)PrimaryExpression_28_Var
		.getConst();
		Assert.assertNotNull(Constant2_29_Var
		);
		Assert.assertEquals("'a'", Constant2_29_Var
		.getCh());
		Assert.assertEquals("return", JumpStatement_11_Var
		.getReturn());
		//29
		final ExternalDeclaration ExternalDeclaration_30_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_30_Var
		);
		//30
		final FunctionDefHead FunctionDefHead_31_Var
		 = (FunctionDefHead)ExternalDeclaration_30_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_31_Var
		);
		//31
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_32_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_31_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_32_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_32_list = FunctionDeclarationSpecifiers_32_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_32_list);
		Assert.assertEquals(1, DeclarationSpecifier_32_list.size());
		//32
		final TypeSpecifier TypeSpecifier_33_Var
		 = (TypeSpecifier)DeclarationSpecifier_32_list.get(0);
		Assert.assertNotNull(TypeSpecifier_33_Var
		);
		Assert.assertEquals("int", TypeSpecifier_33_Var
		.getName());
		//33
		final Declarator Declarator_34_Var
		 = (Declarator)FunctionDefHead_31_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_34_Var
		);
		//34
		final DirectDeclarator DirectDeclarator_35_Var
		 = (DirectDeclarator)Declarator_34_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_35_Var
		);
		Assert.assertEquals("doSomething2", DirectDeclarator_35_Var
		.getId());
		//35
		final FunctionDefinition FunctionDefinition_36_Var
		 = (FunctionDefinition)ExternalDeclaration_30_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_36_Var
		);
		//36
		final BodyStatement BodyStatement_37_Var
		 = (BodyStatement)FunctionDefinition_36_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_37_Var
		);
		final EList<? extends EObject> BlockList_37_list = BodyStatement_37_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_37_list);
		Assert.assertEquals(1, BlockList_37_list.size());
		//37
		final BlockList BlockList_38_Var
		 = (BlockList)BlockList_37_list.get(0);
		Assert.assertNotNull(BlockList_38_Var
		);
		final EList<? extends EObject> Statement_38_list = BlockList_38_Var
		.getStatement();
		Assert.assertNotNull(Statement_38_list);
		Assert.assertEquals(1, Statement_38_list.size());
		//38
		final Statement Statement_39_Var
		 = (Statement)Statement_38_list.get(0);
		Assert.assertNotNull(Statement_39_Var
		);
		//39
		final JumpStatement JumpStatement_40_Var
		 = (JumpStatement)Statement_39_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_40_Var
		);
		//40
		final Expression Expression_41_Var
		 = (Expression)JumpStatement_40_Var
		.getExpr();
		Assert.assertNotNull(Expression_41_Var
		);
		final EList<? extends EObject> ExprExpr_41_list = Expression_41_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_41_list);
		Assert.assertEquals(1, ExprExpr_41_list.size());
		//41
		final AssignmentExpression AssignmentExpression_42_Var
		 = (AssignmentExpression)ExprExpr_41_list.get(0);
		Assert.assertNotNull(AssignmentExpression_42_Var
		);
		//42
		final ConditionalExpression ConditionalExpression_43_Var
		 = (ConditionalExpression)AssignmentExpression_42_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_43_Var
		);
		//43
		final LogicalOrExpression LogicalOrExpression_44_Var
		 = (LogicalOrExpression)ConditionalExpression_43_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = LogicalOrExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final LogicalAndExpression LogicalAndExpression_45_Var
		 = (LogicalAndExpression)Expr_44_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = LogicalAndExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final InclusiveOrExpression InclusiveOrExpression_46_Var
		 = (InclusiveOrExpression)Expr_45_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = InclusiveOrExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final ExclusiveOrExpression ExclusiveOrExpression_47_Var
		 = (ExclusiveOrExpression)Expr_46_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = ExclusiveOrExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final AndExpression AndExpression_48_Var
		 = (AndExpression)Expr_47_list.get(0);
		Assert.assertNotNull(AndExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = AndExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final EqualityExpression EqualityExpression_49_Var
		 = (EqualityExpression)Expr_48_list.get(0);
		Assert.assertNotNull(EqualityExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = EqualityExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final RelationalExpression RelationalExpression_50_Var
		 = (RelationalExpression)Expr_49_list.get(0);
		Assert.assertNotNull(RelationalExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = RelationalExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final ShiftExpression ShiftExpression_51_Var
		 = (ShiftExpression)Expr_50_list.get(0);
		Assert.assertNotNull(ShiftExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = ShiftExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final AdditiveExpression AdditiveExpression_52_Var
		 = (AdditiveExpression)Expr_51_list.get(0);
		Assert.assertNotNull(AdditiveExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = AdditiveExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final MultiplicativeExpression MultiplicativeExpression_53_Var
		 = (MultiplicativeExpression)Expr_52_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = MultiplicativeExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final CastExpression CastExpression_54_Var
		 = (CastExpression)Expr_53_list.get(0);
		Assert.assertNotNull(CastExpression_54_Var
		);
		//54
		final UnaryExpression UnaryExpression_55_Var
		 = (UnaryExpression)CastExpression_54_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_55_Var
		);
		//55
		final CastExpression CastExpression_56_Var
		 = (CastExpression)UnaryExpression_55_Var
		.getExpr();
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
		Assert.assertEquals("1", Constant2_60_Var
		.getDec());
		//60
		final UnaryOperator UnaryOperator_61_Var
		 = (UnaryOperator)UnaryExpression_55_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_61_Var
		);
		Assert.assertEquals("-", UnaryOperator_61_Var
		.getOp());
		Assert.assertEquals("return", JumpStatement_40_Var
		.getReturn());
		//61
		final ExternalDeclaration ExternalDeclaration_62_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_62_Var
		);
		//62
		final FunctionDefHead FunctionDefHead_63_Var
		 = (FunctionDefHead)ExternalDeclaration_62_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_63_Var
		);
		//63
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_64_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_63_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_64_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_64_list = FunctionDeclarationSpecifiers_64_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_64_list);
		Assert.assertEquals(1, DeclarationSpecifier_64_list.size());
		//64
		final TypeSpecifier TypeSpecifier_65_Var
		 = (TypeSpecifier)DeclarationSpecifier_64_list.get(0);
		Assert.assertNotNull(TypeSpecifier_65_Var
		);
		Assert.assertEquals("double", TypeSpecifier_65_Var
		.getName());
		//65
		final Declarator Declarator_66_Var
		 = (Declarator)FunctionDefHead_63_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_66_Var
		);
		//66
		final DirectDeclarator DirectDeclarator_67_Var
		 = (DirectDeclarator)Declarator_66_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_67_Var
		);
		Assert.assertEquals("doSomething3", DirectDeclarator_67_Var
		.getId());
		//67
		final FunctionDefinition FunctionDefinition_68_Var
		 = (FunctionDefinition)ExternalDeclaration_62_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_68_Var
		);
		//68
		final BodyStatement BodyStatement_69_Var
		 = (BodyStatement)FunctionDefinition_68_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_69_Var
		);
		final EList<? extends EObject> BlockList_69_list = BodyStatement_69_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_69_list);
		Assert.assertEquals(1, BlockList_69_list.size());
		//69
		final BlockList BlockList_70_Var
		 = (BlockList)BlockList_69_list.get(0);
		Assert.assertNotNull(BlockList_70_Var
		);
		final EList<? extends EObject> Statement_70_list = BlockList_70_Var
		.getStatement();
		Assert.assertNotNull(Statement_70_list);
		Assert.assertEquals(1, Statement_70_list.size());
		//70
		final Statement Statement_71_Var
		 = (Statement)Statement_70_list.get(0);
		Assert.assertNotNull(Statement_71_Var
		);
		//71
		final JumpStatement JumpStatement_72_Var
		 = (JumpStatement)Statement_71_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_72_Var
		);
		//72
		final Expression Expression_73_Var
		 = (Expression)JumpStatement_72_Var
		.getExpr();
		Assert.assertNotNull(Expression_73_Var
		);
		final EList<? extends EObject> ExprExpr_73_list = Expression_73_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_73_list);
		Assert.assertEquals(1, ExprExpr_73_list.size());
		//73
		final AssignmentExpression AssignmentExpression_74_Var
		 = (AssignmentExpression)ExprExpr_73_list.get(0);
		Assert.assertNotNull(AssignmentExpression_74_Var
		);
		//74
		final ConditionalExpression ConditionalExpression_75_Var
		 = (ConditionalExpression)AssignmentExpression_74_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_75_Var
		);
		//75
		final LogicalOrExpression LogicalOrExpression_76_Var
		 = (LogicalOrExpression)ConditionalExpression_75_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = LogicalOrExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final LogicalAndExpression LogicalAndExpression_77_Var
		 = (LogicalAndExpression)Expr_76_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = LogicalAndExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final InclusiveOrExpression InclusiveOrExpression_78_Var
		 = (InclusiveOrExpression)Expr_77_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = InclusiveOrExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final ExclusiveOrExpression ExclusiveOrExpression_79_Var
		 = (ExclusiveOrExpression)Expr_78_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = ExclusiveOrExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final AndExpression AndExpression_80_Var
		 = (AndExpression)Expr_79_list.get(0);
		Assert.assertNotNull(AndExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = AndExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final EqualityExpression EqualityExpression_81_Var
		 = (EqualityExpression)Expr_80_list.get(0);
		Assert.assertNotNull(EqualityExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = EqualityExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final RelationalExpression RelationalExpression_82_Var
		 = (RelationalExpression)Expr_81_list.get(0);
		Assert.assertNotNull(RelationalExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = RelationalExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final ShiftExpression ShiftExpression_83_Var
		 = (ShiftExpression)Expr_82_list.get(0);
		Assert.assertNotNull(ShiftExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = ShiftExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final AdditiveExpression AdditiveExpression_84_Var
		 = (AdditiveExpression)Expr_83_list.get(0);
		Assert.assertNotNull(AdditiveExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = AdditiveExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final MultiplicativeExpression MultiplicativeExpression_85_Var
		 = (MultiplicativeExpression)Expr_84_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = MultiplicativeExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final CastExpression CastExpression_86_Var
		 = (CastExpression)Expr_85_list.get(0);
		Assert.assertNotNull(CastExpression_86_Var
		);
		//86
		final UnaryExpression UnaryExpression_87_Var
		 = (UnaryExpression)CastExpression_86_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_87_Var
		);
		//87
		final PostfixExpression PostfixExpression_88_Var
		 = (PostfixExpression)UnaryExpression_87_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = PostfixExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final PrimaryExpression PrimaryExpression_89_Var
		 = (PrimaryExpression)Expr_88_list.get(0);
		Assert.assertNotNull(PrimaryExpression_89_Var
		);
		//89
		final Constant2 Constant2_90_Var
		 = (Constant2)PrimaryExpression_89_Var
		.getConst();
		Assert.assertNotNull(Constant2_90_Var
		);
		Assert.assertEquals("0.8", Constant2_90_Var
		.getFloat());
		Assert.assertEquals("return", JumpStatement_72_Var
		.getReturn());
		//90
		final ExternalDeclaration ExternalDeclaration_91_Var
		 = (ExternalDeclaration)External_0_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_91_Var
		);
		//91
		final FunctionDefHead FunctionDefHead_92_Var
		 = (FunctionDefHead)ExternalDeclaration_91_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_92_Var
		);
		//92
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_93_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_92_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_93_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_93_list = FunctionDeclarationSpecifiers_93_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_93_list);
		Assert.assertEquals(1, DeclarationSpecifier_93_list.size());
		//93
		final TypeSpecifier TypeSpecifier_94_Var
		 = (TypeSpecifier)DeclarationSpecifier_93_list.get(0);
		Assert.assertNotNull(TypeSpecifier_94_Var
		);
		Assert.assertEquals("float", TypeSpecifier_94_Var
		.getName());
		//94
		final Declarator Declarator_95_Var
		 = (Declarator)FunctionDefHead_92_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_95_Var
		);
		//95
		final DirectDeclarator DirectDeclarator_96_Var
		 = (DirectDeclarator)Declarator_95_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_96_Var
		);
		Assert.assertEquals("doSomething4", DirectDeclarator_96_Var
		.getId());
		//96
		final FunctionDefinition FunctionDefinition_97_Var
		 = (FunctionDefinition)ExternalDeclaration_91_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_97_Var
		);
		//97
		final BodyStatement BodyStatement_98_Var
		 = (BodyStatement)FunctionDefinition_97_Var
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
		Assert.assertEquals("0x01A", Constant2_119_Var
		.getHex());
		Assert.assertEquals("return", JumpStatement_101_Var
		.getReturn());
		//119
		final ExternalDeclaration ExternalDeclaration_120_Var
		 = (ExternalDeclaration)External_0_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_120_Var
		);
		//120
		final FunctionDefHead FunctionDefHead_121_Var
		 = (FunctionDefHead)ExternalDeclaration_120_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_121_Var
		);
		//121
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_122_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_121_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_122_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_122_list = FunctionDeclarationSpecifiers_122_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_122_list);
		Assert.assertEquals(1, DeclarationSpecifier_122_list.size());
		//122
		final TypeSpecifier TypeSpecifier_123_Var
		 = (TypeSpecifier)DeclarationSpecifier_122_list.get(0);
		Assert.assertNotNull(TypeSpecifier_123_Var
		);
		Assert.assertEquals("void", TypeSpecifier_123_Var
		.getName());
		//123
		final Declarator Declarator_124_Var
		 = (Declarator)FunctionDefHead_121_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_124_Var
		);
		//124
		final DirectDeclarator DirectDeclarator_125_Var
		 = (DirectDeclarator)Declarator_124_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_125_Var
		);
		Assert.assertEquals("doSomething5", DirectDeclarator_125_Var
		.getId());
		//125
		final FunctionDefinition FunctionDefinition_126_Var
		 = (FunctionDefinition)ExternalDeclaration_120_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_126_Var
		);
		//126
		final BodyStatement BodyStatement_127_Var
		 = (BodyStatement)FunctionDefinition_126_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_127_Var
		);
		final EList<? extends EObject> BlockList_127_list = BodyStatement_127_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_127_list);
		Assert.assertEquals(1, BlockList_127_list.size());
		//127
		final BlockList BlockList_128_Var
		 = (BlockList)BlockList_127_list.get(0);
		Assert.assertNotNull(BlockList_128_Var
		);
		final EList<? extends EObject> Statement_128_list = BlockList_128_Var
		.getStatement();
		Assert.assertNotNull(Statement_128_list);
		Assert.assertEquals(1, Statement_128_list.size());
		//128
		final Statement Statement_129_Var
		 = (Statement)Statement_128_list.get(0);
		Assert.assertNotNull(Statement_129_Var
		);
		//129
		final JumpStatement JumpStatement_130_Var
		 = (JumpStatement)Statement_129_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_130_Var
		);
		Assert.assertEquals("return", JumpStatement_130_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
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


