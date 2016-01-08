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
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
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
import at.jku.weiner.c.common.common.Constant2;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0064_BlocksInPrimaryExpression {
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
			"res/Test0064_BlocksInPrimaryExpression.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_PLUS",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_OROR",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
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
			"res/Test0064_BlocksInPrimaryExpression.c");
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
		Assert.assertEquals("foo", DirectDeclarator_6_Var
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
		Assert.assertEquals(2, Statement_9_list.size());
		//9
		final Statement Statement_10_Var
		 = (Statement)Statement_9_list.get(0);
		Assert.assertNotNull(Statement_10_Var
		);
		//10
		final ExpressionStatement ExpressionStatement_11_Var
		 = (ExpressionStatement)Statement_10_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_11_Var
		);
		//11
		final Expression Expression_12_Var
		 = (Expression)ExpressionStatement_11_Var
		.getExpression();
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
		Assert.assertEquals("[+]", AdditiveExpression_23_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_23_list = AdditiveExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(2, Expr_23_list.size());
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
		Assert.assertEquals("1", Constant2_29_Var
		.getDec());
		//29
		final MultiplicativeExpression MultiplicativeExpression_30_Var
		 = (MultiplicativeExpression)Expr_23_list.get(1);
		Assert.assertNotNull(MultiplicativeExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = MultiplicativeExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final CastExpression CastExpression_31_Var
		 = (CastExpression)Expr_30_list.get(0);
		Assert.assertNotNull(CastExpression_31_Var
		);
		//31
		final UnaryExpression UnaryExpression_32_Var
		 = (UnaryExpression)CastExpression_31_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_32_Var
		);
		//32
		final PostfixExpression PostfixExpression_33_Var
		 = (PostfixExpression)UnaryExpression_32_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = PostfixExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final PrimaryExpression PrimaryExpression_34_Var
		 = (PrimaryExpression)Expr_33_list.get(0);
		Assert.assertNotNull(PrimaryExpression_34_Var
		);
		//34
		final CompoundStatement CompoundStatement_35_Var
		 = (CompoundStatement)PrimaryExpression_34_Var
		.getCompoundStmt();
		Assert.assertNotNull(CompoundStatement_35_Var
		);
		//35
		final BodyStatement BodyStatement_36_Var
		 = (BodyStatement)CompoundStatement_35_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_36_Var
		);
		final EList<? extends EObject> BlockList_36_list = BodyStatement_36_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_36_list);
		Assert.assertEquals(1, BlockList_36_list.size());
		//36
		final BlockList BlockList_37_Var
		 = (BlockList)BlockList_36_list.get(0);
		Assert.assertNotNull(BlockList_37_Var
		);
		final EList<? extends EObject> Statement_37_list = BlockList_37_Var
		.getStatement();
		Assert.assertNotNull(Statement_37_list);
		Assert.assertEquals(1, Statement_37_list.size());
		//37
		final Statement Statement_38_Var
		 = (Statement)Statement_37_list.get(0);
		Assert.assertNotNull(Statement_38_Var
		);
		//38
		final ExpressionStatement ExpressionStatement_39_Var
		 = (ExpressionStatement)Statement_38_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_39_Var
		);
		//39
		final Expression Expression_40_Var
		 = (Expression)ExpressionStatement_39_Var
		.getExpression();
		Assert.assertNotNull(Expression_40_Var
		);
		final EList<? extends EObject> ExprExpr_40_list = Expression_40_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_40_list);
		Assert.assertEquals(1, ExprExpr_40_list.size());
		//40
		final AssignmentExpression AssignmentExpression_41_Var
		 = (AssignmentExpression)ExprExpr_40_list.get(0);
		Assert.assertNotNull(AssignmentExpression_41_Var
		);
		//41
		final ConditionalExpression ConditionalExpression_42_Var
		 = (ConditionalExpression)AssignmentExpression_41_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_42_Var
		);
		//42
		final LogicalOrExpression LogicalOrExpression_43_Var
		 = (LogicalOrExpression)ConditionalExpression_42_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = LogicalOrExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final LogicalAndExpression LogicalAndExpression_44_Var
		 = (LogicalAndExpression)Expr_43_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = LogicalAndExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final InclusiveOrExpression InclusiveOrExpression_45_Var
		 = (InclusiveOrExpression)Expr_44_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = InclusiveOrExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final ExclusiveOrExpression ExclusiveOrExpression_46_Var
		 = (ExclusiveOrExpression)Expr_45_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = ExclusiveOrExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final AndExpression AndExpression_47_Var
		 = (AndExpression)Expr_46_list.get(0);
		Assert.assertNotNull(AndExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = AndExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final EqualityExpression EqualityExpression_48_Var
		 = (EqualityExpression)Expr_47_list.get(0);
		Assert.assertNotNull(EqualityExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = EqualityExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final RelationalExpression RelationalExpression_49_Var
		 = (RelationalExpression)Expr_48_list.get(0);
		Assert.assertNotNull(RelationalExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = RelationalExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final ShiftExpression ShiftExpression_50_Var
		 = (ShiftExpression)Expr_49_list.get(0);
		Assert.assertNotNull(ShiftExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = ShiftExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final AdditiveExpression AdditiveExpression_51_Var
		 = (AdditiveExpression)Expr_50_list.get(0);
		Assert.assertNotNull(AdditiveExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = AdditiveExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final MultiplicativeExpression MultiplicativeExpression_52_Var
		 = (MultiplicativeExpression)Expr_51_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = MultiplicativeExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final CastExpression CastExpression_53_Var
		 = (CastExpression)Expr_52_list.get(0);
		Assert.assertNotNull(CastExpression_53_Var
		);
		//53
		final UnaryExpression UnaryExpression_54_Var
		 = (UnaryExpression)CastExpression_53_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_54_Var
		);
		//54
		final PostfixExpression PostfixExpression_55_Var
		 = (PostfixExpression)UnaryExpression_54_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = PostfixExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final PrimaryExpression PrimaryExpression_56_Var
		 = (PrimaryExpression)Expr_55_list.get(0);
		Assert.assertNotNull(PrimaryExpression_56_Var
		);
		//56
		final Constant2 Constant2_57_Var
		 = (Constant2)PrimaryExpression_56_Var
		.getConst();
		Assert.assertNotNull(Constant2_57_Var
		);
		Assert.assertEquals("7", Constant2_57_Var
		.getDec());
		//57
		final Statement Statement_58_Var
		 = (Statement)Statement_9_list.get(1);
		Assert.assertNotNull(Statement_58_Var
		);
		//58
		final JumpStatement JumpStatement_59_Var
		 = (JumpStatement)Statement_58_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_59_Var
		);
		//59
		final Expression Expression_60_Var
		 = (Expression)JumpStatement_59_Var
		.getExpr();
		Assert.assertNotNull(Expression_60_Var
		);
		final EList<? extends EObject> ExprExpr_60_list = Expression_60_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_60_list);
		Assert.assertEquals(1, ExprExpr_60_list.size());
		//60
		final AssignmentExpression AssignmentExpression_61_Var
		 = (AssignmentExpression)ExprExpr_60_list.get(0);
		Assert.assertNotNull(AssignmentExpression_61_Var
		);
		//61
		final ConditionalExpression ConditionalExpression_62_Var
		 = (ConditionalExpression)AssignmentExpression_61_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_62_Var
		);
		//62
		final LogicalOrExpression LogicalOrExpression_63_Var
		 = (LogicalOrExpression)ConditionalExpression_62_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = LogicalOrExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final LogicalAndExpression LogicalAndExpression_64_Var
		 = (LogicalAndExpression)Expr_63_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = LogicalAndExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final InclusiveOrExpression InclusiveOrExpression_65_Var
		 = (InclusiveOrExpression)Expr_64_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = InclusiveOrExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final ExclusiveOrExpression ExclusiveOrExpression_66_Var
		 = (ExclusiveOrExpression)Expr_65_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = ExclusiveOrExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final AndExpression AndExpression_67_Var
		 = (AndExpression)Expr_66_list.get(0);
		Assert.assertNotNull(AndExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = AndExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final EqualityExpression EqualityExpression_68_Var
		 = (EqualityExpression)Expr_67_list.get(0);
		Assert.assertNotNull(EqualityExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = EqualityExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final RelationalExpression RelationalExpression_69_Var
		 = (RelationalExpression)Expr_68_list.get(0);
		Assert.assertNotNull(RelationalExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = RelationalExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final ShiftExpression ShiftExpression_70_Var
		 = (ShiftExpression)Expr_69_list.get(0);
		Assert.assertNotNull(ShiftExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = ShiftExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final AdditiveExpression AdditiveExpression_71_Var
		 = (AdditiveExpression)Expr_70_list.get(0);
		Assert.assertNotNull(AdditiveExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = AdditiveExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final MultiplicativeExpression MultiplicativeExpression_72_Var
		 = (MultiplicativeExpression)Expr_71_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = MultiplicativeExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final CastExpression CastExpression_73_Var
		 = (CastExpression)Expr_72_list.get(0);
		Assert.assertNotNull(CastExpression_73_Var
		);
		//73
		final UnaryExpression UnaryExpression_74_Var
		 = (UnaryExpression)CastExpression_73_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_74_Var
		);
		//74
		final PostfixExpression PostfixExpression_75_Var
		 = (PostfixExpression)UnaryExpression_74_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = PostfixExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final PrimaryExpression PrimaryExpression_76_Var
		 = (PrimaryExpression)Expr_75_list.get(0);
		Assert.assertNotNull(PrimaryExpression_76_Var
		);
		//76
		final Expression Expression_77_Var
		 = (Expression)PrimaryExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expression_77_Var
		);
		final EList<? extends EObject> ExprExpr_77_list = Expression_77_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_77_list);
		Assert.assertEquals(1, ExprExpr_77_list.size());
		//77
		final AssignmentExpression AssignmentExpression_78_Var
		 = (AssignmentExpression)ExprExpr_77_list.get(0);
		Assert.assertNotNull(AssignmentExpression_78_Var
		);
		//78
		final ConditionalExpression ConditionalExpression_79_Var
		 = (ConditionalExpression)AssignmentExpression_78_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_79_Var
		);
		//79
		final LogicalOrExpression LogicalOrExpression_80_Var
		 = (LogicalOrExpression)ConditionalExpression_79_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = LogicalOrExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(2, Expr_80_list.size());
		//80
		final LogicalAndExpression LogicalAndExpression_81_Var
		 = (LogicalAndExpression)Expr_80_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = LogicalAndExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final InclusiveOrExpression InclusiveOrExpression_82_Var
		 = (InclusiveOrExpression)Expr_81_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = InclusiveOrExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final ExclusiveOrExpression ExclusiveOrExpression_83_Var
		 = (ExclusiveOrExpression)Expr_82_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = ExclusiveOrExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final AndExpression AndExpression_84_Var
		 = (AndExpression)Expr_83_list.get(0);
		Assert.assertNotNull(AndExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = AndExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final EqualityExpression EqualityExpression_85_Var
		 = (EqualityExpression)Expr_84_list.get(0);
		Assert.assertNotNull(EqualityExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = EqualityExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final RelationalExpression RelationalExpression_86_Var
		 = (RelationalExpression)Expr_85_list.get(0);
		Assert.assertNotNull(RelationalExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = RelationalExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final ShiftExpression ShiftExpression_87_Var
		 = (ShiftExpression)Expr_86_list.get(0);
		Assert.assertNotNull(ShiftExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = ShiftExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final AdditiveExpression AdditiveExpression_88_Var
		 = (AdditiveExpression)Expr_87_list.get(0);
		Assert.assertNotNull(AdditiveExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = AdditiveExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final MultiplicativeExpression MultiplicativeExpression_89_Var
		 = (MultiplicativeExpression)Expr_88_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = MultiplicativeExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final CastExpression CastExpression_90_Var
		 = (CastExpression)Expr_89_list.get(0);
		Assert.assertNotNull(CastExpression_90_Var
		);
		//90
		final UnaryExpression UnaryExpression_91_Var
		 = (UnaryExpression)CastExpression_90_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_91_Var
		);
		//91
		final PostfixExpression PostfixExpression_92_Var
		 = (PostfixExpression)UnaryExpression_91_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = PostfixExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final PrimaryExpression PrimaryExpression_93_Var
		 = (PrimaryExpression)Expr_92_list.get(0);
		Assert.assertNotNull(PrimaryExpression_93_Var
		);
		//93
		final Constant2 Constant2_94_Var
		 = (Constant2)PrimaryExpression_93_Var
		.getConst();
		Assert.assertNotNull(Constant2_94_Var
		);
		Assert.assertEquals("0", Constant2_94_Var
		.getDec());
		//94
		final LogicalAndExpression LogicalAndExpression_95_Var
		 = (LogicalAndExpression)Expr_80_list.get(1);
		Assert.assertNotNull(LogicalAndExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = LogicalAndExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final InclusiveOrExpression InclusiveOrExpression_96_Var
		 = (InclusiveOrExpression)Expr_95_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = InclusiveOrExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final ExclusiveOrExpression ExclusiveOrExpression_97_Var
		 = (ExclusiveOrExpression)Expr_96_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = ExclusiveOrExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final AndExpression AndExpression_98_Var
		 = (AndExpression)Expr_97_list.get(0);
		Assert.assertNotNull(AndExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = AndExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final EqualityExpression EqualityExpression_99_Var
		 = (EqualityExpression)Expr_98_list.get(0);
		Assert.assertNotNull(EqualityExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = EqualityExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final RelationalExpression RelationalExpression_100_Var
		 = (RelationalExpression)Expr_99_list.get(0);
		Assert.assertNotNull(RelationalExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = RelationalExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final ShiftExpression ShiftExpression_101_Var
		 = (ShiftExpression)Expr_100_list.get(0);
		Assert.assertNotNull(ShiftExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = ShiftExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final AdditiveExpression AdditiveExpression_102_Var
		 = (AdditiveExpression)Expr_101_list.get(0);
		Assert.assertNotNull(AdditiveExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = AdditiveExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final MultiplicativeExpression MultiplicativeExpression_103_Var
		 = (MultiplicativeExpression)Expr_102_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = MultiplicativeExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final CastExpression CastExpression_104_Var
		 = (CastExpression)Expr_103_list.get(0);
		Assert.assertNotNull(CastExpression_104_Var
		);
		//104
		final UnaryExpression UnaryExpression_105_Var
		 = (UnaryExpression)CastExpression_104_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_105_Var
		);
		//105
		final PostfixExpression PostfixExpression_106_Var
		 = (PostfixExpression)UnaryExpression_105_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = PostfixExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final PrimaryExpression PrimaryExpression_107_Var
		 = (PrimaryExpression)Expr_106_list.get(0);
		Assert.assertNotNull(PrimaryExpression_107_Var
		);
		//107
		final Expression Expression_108_Var
		 = (Expression)PrimaryExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expression_108_Var
		);
		final EList<? extends EObject> ExprExpr_108_list = Expression_108_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_108_list);
		Assert.assertEquals(1, ExprExpr_108_list.size());
		//108
		final AssignmentExpression AssignmentExpression_109_Var
		 = (AssignmentExpression)ExprExpr_108_list.get(0);
		Assert.assertNotNull(AssignmentExpression_109_Var
		);
		//109
		final ConditionalExpression ConditionalExpression_110_Var
		 = (ConditionalExpression)AssignmentExpression_109_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_110_Var
		);
		//110
		final LogicalOrExpression LogicalOrExpression_111_Var
		 = (LogicalOrExpression)ConditionalExpression_110_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = LogicalOrExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final LogicalAndExpression LogicalAndExpression_112_Var
		 = (LogicalAndExpression)Expr_111_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = LogicalAndExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final InclusiveOrExpression InclusiveOrExpression_113_Var
		 = (InclusiveOrExpression)Expr_112_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = InclusiveOrExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final ExclusiveOrExpression ExclusiveOrExpression_114_Var
		 = (ExclusiveOrExpression)Expr_113_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = ExclusiveOrExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final AndExpression AndExpression_115_Var
		 = (AndExpression)Expr_114_list.get(0);
		Assert.assertNotNull(AndExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = AndExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final EqualityExpression EqualityExpression_116_Var
		 = (EqualityExpression)Expr_115_list.get(0);
		Assert.assertNotNull(EqualityExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = EqualityExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final RelationalExpression RelationalExpression_117_Var
		 = (RelationalExpression)Expr_116_list.get(0);
		Assert.assertNotNull(RelationalExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = RelationalExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final ShiftExpression ShiftExpression_118_Var
		 = (ShiftExpression)Expr_117_list.get(0);
		Assert.assertNotNull(ShiftExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = ShiftExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final AdditiveExpression AdditiveExpression_119_Var
		 = (AdditiveExpression)Expr_118_list.get(0);
		Assert.assertNotNull(AdditiveExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = AdditiveExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final MultiplicativeExpression MultiplicativeExpression_120_Var
		 = (MultiplicativeExpression)Expr_119_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = MultiplicativeExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final CastExpression CastExpression_121_Var
		 = (CastExpression)Expr_120_list.get(0);
		Assert.assertNotNull(CastExpression_121_Var
		);
		//121
		final UnaryExpression UnaryExpression_122_Var
		 = (UnaryExpression)CastExpression_121_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_122_Var
		);
		//122
		final PostfixExpression PostfixExpression_123_Var
		 = (PostfixExpression)UnaryExpression_122_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = PostfixExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final PrimaryExpression PrimaryExpression_124_Var
		 = (PrimaryExpression)Expr_123_list.get(0);
		Assert.assertNotNull(PrimaryExpression_124_Var
		);
		Assert.assertFalse(PrimaryExpression_124_Var
		.isExt());
		//124
		final CompoundStatement CompoundStatement_125_Var
		 = (CompoundStatement)PrimaryExpression_124_Var
		.getCompoundStmt();
		Assert.assertNotNull(CompoundStatement_125_Var
		);
		//125
		final BodyStatement BodyStatement_126_Var
		 = (BodyStatement)CompoundStatement_125_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_126_Var
		);
		final EList<? extends EObject> BlockList_126_list = BodyStatement_126_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_126_list);
		Assert.assertEquals(1, BlockList_126_list.size());
		//126
		final BlockList BlockList_127_Var
		 = (BlockList)BlockList_126_list.get(0);
		Assert.assertNotNull(BlockList_127_Var
		);
		final EList<? extends EObject> Statement_127_list = BlockList_127_Var
		.getStatement();
		Assert.assertNotNull(Statement_127_list);
		Assert.assertEquals(1, Statement_127_list.size());
		//127
		final Statement Statement_128_Var
		 = (Statement)Statement_127_list.get(0);
		Assert.assertNotNull(Statement_128_Var
		);
		//128
		final ExpressionStatement ExpressionStatement_129_Var
		 = (ExpressionStatement)Statement_128_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_129_Var
		);
		//129
		final Expression Expression_130_Var
		 = (Expression)ExpressionStatement_129_Var
		.getExpression();
		Assert.assertNotNull(Expression_130_Var
		);
		final EList<? extends EObject> ExprExpr_130_list = Expression_130_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_130_list);
		Assert.assertEquals(1, ExprExpr_130_list.size());
		//130
		final AssignmentExpression AssignmentExpression_131_Var
		 = (AssignmentExpression)ExprExpr_130_list.get(0);
		Assert.assertNotNull(AssignmentExpression_131_Var
		);
		//131
		final ConditionalExpression ConditionalExpression_132_Var
		 = (ConditionalExpression)AssignmentExpression_131_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_132_Var
		);
		//132
		final LogicalOrExpression LogicalOrExpression_133_Var
		 = (LogicalOrExpression)ConditionalExpression_132_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = LogicalOrExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final LogicalAndExpression LogicalAndExpression_134_Var
		 = (LogicalAndExpression)Expr_133_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = LogicalAndExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final InclusiveOrExpression InclusiveOrExpression_135_Var
		 = (InclusiveOrExpression)Expr_134_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = InclusiveOrExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final ExclusiveOrExpression ExclusiveOrExpression_136_Var
		 = (ExclusiveOrExpression)Expr_135_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = ExclusiveOrExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final AndExpression AndExpression_137_Var
		 = (AndExpression)Expr_136_list.get(0);
		Assert.assertNotNull(AndExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = AndExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final EqualityExpression EqualityExpression_138_Var
		 = (EqualityExpression)Expr_137_list.get(0);
		Assert.assertNotNull(EqualityExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = EqualityExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final RelationalExpression RelationalExpression_139_Var
		 = (RelationalExpression)Expr_138_list.get(0);
		Assert.assertNotNull(RelationalExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = RelationalExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final ShiftExpression ShiftExpression_140_Var
		 = (ShiftExpression)Expr_139_list.get(0);
		Assert.assertNotNull(ShiftExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = ShiftExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final AdditiveExpression AdditiveExpression_141_Var
		 = (AdditiveExpression)Expr_140_list.get(0);
		Assert.assertNotNull(AdditiveExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = AdditiveExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final MultiplicativeExpression MultiplicativeExpression_142_Var
		 = (MultiplicativeExpression)Expr_141_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = MultiplicativeExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final CastExpression CastExpression_143_Var
		 = (CastExpression)Expr_142_list.get(0);
		Assert.assertNotNull(CastExpression_143_Var
		);
		//143
		final UnaryExpression UnaryExpression_144_Var
		 = (UnaryExpression)CastExpression_143_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_144_Var
		);
		//144
		final PostfixExpression PostfixExpression_145_Var
		 = (PostfixExpression)UnaryExpression_144_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = PostfixExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final PrimaryExpression PrimaryExpression_146_Var
		 = (PrimaryExpression)Expr_145_list.get(0);
		Assert.assertNotNull(PrimaryExpression_146_Var
		);
		//146
		final Constant2 Constant2_147_Var
		 = (Constant2)PrimaryExpression_146_Var
		.getConst();
		Assert.assertNotNull(Constant2_147_Var
		);
		Assert.assertEquals("5", Constant2_147_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_59_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_59_Var
		.getSemi());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0064_BlocksInPrimaryExpression.c");
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
				method.invoke(this.generator, "Test0064_BlocksInPrimaryExpression.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0064_BlocksInPrimaryExpression.c");
		final String expected = this.getTextFromFile(
			"res/Test0064_BlocksInPrimaryExpression.c"
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


