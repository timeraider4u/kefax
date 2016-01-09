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
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitializerList;
import at.jku.weiner.c.parser.parser.Initializer;
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
public class Test0064_BlocksInExpressions {
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
			"res/Test0064_BlocksInExpressions.c");
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
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_INT",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
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
			"res/Test0064_BlocksInExpressions.c");
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
		Assert.assertTrue(PostfixExpression_33_Var
		.getExpr().isEmpty());
		Assert.assertFalse(PostfixExpression_33_Var
		.isExt());
		//33
		final TypeName TypeName_34_Var
		 = (TypeName)PostfixExpression_33_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_34_Var
		);
		//34
		final SpecifierQualifierList SpecifierQualifierList_35_Var
		 = (SpecifierQualifierList)TypeName_34_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_35_Var
		);
		final EList<? extends EObject> TypeSpecifier_35_list = SpecifierQualifierList_35_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_35_list);
		Assert.assertEquals(1, TypeSpecifier_35_list.size());
		//35
		final TypeSpecifier TypeSpecifier_36_Var
		 = (TypeSpecifier)TypeSpecifier_35_list.get(0);
		Assert.assertNotNull(TypeSpecifier_36_Var
		);
		Assert.assertEquals("int", TypeSpecifier_36_Var
		.getName());
		//36
		final InitializerList InitializerList_37_Var
		 = (InitializerList)PostfixExpression_33_Var
		.getInitializerList();
		Assert.assertNotNull(InitializerList_37_Var
		);
		final EList<? extends EObject> Initializer_37_list = InitializerList_37_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_37_list);
		Assert.assertEquals(1, Initializer_37_list.size());
		//37
		final Initializer Initializer_38_Var
		 = (Initializer)Initializer_37_list.get(0);
		Assert.assertNotNull(Initializer_38_Var
		);
		//38
		final AssignmentExpression AssignmentExpression_39_Var
		 = (AssignmentExpression)Initializer_38_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_39_Var
		);
		//39
		final ConditionalExpression ConditionalExpression_40_Var
		 = (ConditionalExpression)AssignmentExpression_39_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_40_Var
		);
		//40
		final LogicalOrExpression LogicalOrExpression_41_Var
		 = (LogicalOrExpression)ConditionalExpression_40_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = LogicalOrExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final LogicalAndExpression LogicalAndExpression_42_Var
		 = (LogicalAndExpression)Expr_41_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = LogicalAndExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final InclusiveOrExpression InclusiveOrExpression_43_Var
		 = (InclusiveOrExpression)Expr_42_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = InclusiveOrExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final ExclusiveOrExpression ExclusiveOrExpression_44_Var
		 = (ExclusiveOrExpression)Expr_43_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = ExclusiveOrExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final AndExpression AndExpression_45_Var
		 = (AndExpression)Expr_44_list.get(0);
		Assert.assertNotNull(AndExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = AndExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final EqualityExpression EqualityExpression_46_Var
		 = (EqualityExpression)Expr_45_list.get(0);
		Assert.assertNotNull(EqualityExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = EqualityExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final RelationalExpression RelationalExpression_47_Var
		 = (RelationalExpression)Expr_46_list.get(0);
		Assert.assertNotNull(RelationalExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = RelationalExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final ShiftExpression ShiftExpression_48_Var
		 = (ShiftExpression)Expr_47_list.get(0);
		Assert.assertNotNull(ShiftExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = ShiftExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final AdditiveExpression AdditiveExpression_49_Var
		 = (AdditiveExpression)Expr_48_list.get(0);
		Assert.assertNotNull(AdditiveExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = AdditiveExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final MultiplicativeExpression MultiplicativeExpression_50_Var
		 = (MultiplicativeExpression)Expr_49_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = MultiplicativeExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final CastExpression CastExpression_51_Var
		 = (CastExpression)Expr_50_list.get(0);
		Assert.assertNotNull(CastExpression_51_Var
		);
		//51
		final UnaryExpression UnaryExpression_52_Var
		 = (UnaryExpression)CastExpression_51_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_52_Var
		);
		//52
		final PostfixExpression PostfixExpression_53_Var
		 = (PostfixExpression)UnaryExpression_52_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = PostfixExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final PrimaryExpression PrimaryExpression_54_Var
		 = (PrimaryExpression)Expr_53_list.get(0);
		Assert.assertNotNull(PrimaryExpression_54_Var
		);
		//54
		final Constant2 Constant2_55_Var
		 = (Constant2)PrimaryExpression_54_Var
		.getConst();
		Assert.assertNotNull(Constant2_55_Var
		);
		Assert.assertEquals("7", Constant2_55_Var
		.getDec());
		Assert.assertFalse(PostfixExpression_33_Var
		.isComma());
		//55
		final Statement Statement_56_Var
		 = (Statement)Statement_9_list.get(1);
		Assert.assertNotNull(Statement_56_Var
		);
		//56
		final JumpStatement JumpStatement_57_Var
		 = (JumpStatement)Statement_56_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_57_Var
		);
		//57
		final Expression Expression_58_Var
		 = (Expression)JumpStatement_57_Var
		.getExpr();
		Assert.assertNotNull(Expression_58_Var
		);
		final EList<? extends EObject> ExprExpr_58_list = Expression_58_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_58_list);
		Assert.assertEquals(1, ExprExpr_58_list.size());
		//58
		final AssignmentExpression AssignmentExpression_59_Var
		 = (AssignmentExpression)ExprExpr_58_list.get(0);
		Assert.assertNotNull(AssignmentExpression_59_Var
		);
		//59
		final ConditionalExpression ConditionalExpression_60_Var
		 = (ConditionalExpression)AssignmentExpression_59_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_60_Var
		);
		//60
		final LogicalOrExpression LogicalOrExpression_61_Var
		 = (LogicalOrExpression)ConditionalExpression_60_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = LogicalOrExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final LogicalAndExpression LogicalAndExpression_62_Var
		 = (LogicalAndExpression)Expr_61_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = LogicalAndExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final InclusiveOrExpression InclusiveOrExpression_63_Var
		 = (InclusiveOrExpression)Expr_62_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = InclusiveOrExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final ExclusiveOrExpression ExclusiveOrExpression_64_Var
		 = (ExclusiveOrExpression)Expr_63_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = ExclusiveOrExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final AndExpression AndExpression_65_Var
		 = (AndExpression)Expr_64_list.get(0);
		Assert.assertNotNull(AndExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = AndExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final EqualityExpression EqualityExpression_66_Var
		 = (EqualityExpression)Expr_65_list.get(0);
		Assert.assertNotNull(EqualityExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = EqualityExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final RelationalExpression RelationalExpression_67_Var
		 = (RelationalExpression)Expr_66_list.get(0);
		Assert.assertNotNull(RelationalExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = RelationalExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final ShiftExpression ShiftExpression_68_Var
		 = (ShiftExpression)Expr_67_list.get(0);
		Assert.assertNotNull(ShiftExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = ShiftExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final AdditiveExpression AdditiveExpression_69_Var
		 = (AdditiveExpression)Expr_68_list.get(0);
		Assert.assertNotNull(AdditiveExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = AdditiveExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final MultiplicativeExpression MultiplicativeExpression_70_Var
		 = (MultiplicativeExpression)Expr_69_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = MultiplicativeExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final CastExpression CastExpression_71_Var
		 = (CastExpression)Expr_70_list.get(0);
		Assert.assertNotNull(CastExpression_71_Var
		);
		//71
		final UnaryExpression UnaryExpression_72_Var
		 = (UnaryExpression)CastExpression_71_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_72_Var
		);
		//72
		final PostfixExpression PostfixExpression_73_Var
		 = (PostfixExpression)UnaryExpression_72_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = PostfixExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final PrimaryExpression PrimaryExpression_74_Var
		 = (PrimaryExpression)Expr_73_list.get(0);
		Assert.assertNotNull(PrimaryExpression_74_Var
		);
		//74
		final Expression Expression_75_Var
		 = (Expression)PrimaryExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expression_75_Var
		);
		final EList<? extends EObject> ExprExpr_75_list = Expression_75_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_75_list);
		Assert.assertEquals(1, ExprExpr_75_list.size());
		//75
		final AssignmentExpression AssignmentExpression_76_Var
		 = (AssignmentExpression)ExprExpr_75_list.get(0);
		Assert.assertNotNull(AssignmentExpression_76_Var
		);
		//76
		final ConditionalExpression ConditionalExpression_77_Var
		 = (ConditionalExpression)AssignmentExpression_76_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_77_Var
		);
		//77
		final LogicalOrExpression LogicalOrExpression_78_Var
		 = (LogicalOrExpression)ConditionalExpression_77_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = LogicalOrExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(2, Expr_78_list.size());
		//78
		final LogicalAndExpression LogicalAndExpression_79_Var
		 = (LogicalAndExpression)Expr_78_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = LogicalAndExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final InclusiveOrExpression InclusiveOrExpression_80_Var
		 = (InclusiveOrExpression)Expr_79_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = InclusiveOrExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final ExclusiveOrExpression ExclusiveOrExpression_81_Var
		 = (ExclusiveOrExpression)Expr_80_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = ExclusiveOrExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final AndExpression AndExpression_82_Var
		 = (AndExpression)Expr_81_list.get(0);
		Assert.assertNotNull(AndExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = AndExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final EqualityExpression EqualityExpression_83_Var
		 = (EqualityExpression)Expr_82_list.get(0);
		Assert.assertNotNull(EqualityExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = EqualityExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final RelationalExpression RelationalExpression_84_Var
		 = (RelationalExpression)Expr_83_list.get(0);
		Assert.assertNotNull(RelationalExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = RelationalExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final ShiftExpression ShiftExpression_85_Var
		 = (ShiftExpression)Expr_84_list.get(0);
		Assert.assertNotNull(ShiftExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = ShiftExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final AdditiveExpression AdditiveExpression_86_Var
		 = (AdditiveExpression)Expr_85_list.get(0);
		Assert.assertNotNull(AdditiveExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = AdditiveExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final MultiplicativeExpression MultiplicativeExpression_87_Var
		 = (MultiplicativeExpression)Expr_86_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = MultiplicativeExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final CastExpression CastExpression_88_Var
		 = (CastExpression)Expr_87_list.get(0);
		Assert.assertNotNull(CastExpression_88_Var
		);
		//88
		final UnaryExpression UnaryExpression_89_Var
		 = (UnaryExpression)CastExpression_88_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_89_Var
		);
		//89
		final PostfixExpression PostfixExpression_90_Var
		 = (PostfixExpression)UnaryExpression_89_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = PostfixExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final PrimaryExpression PrimaryExpression_91_Var
		 = (PrimaryExpression)Expr_90_list.get(0);
		Assert.assertNotNull(PrimaryExpression_91_Var
		);
		//91
		final Constant2 Constant2_92_Var
		 = (Constant2)PrimaryExpression_91_Var
		.getConst();
		Assert.assertNotNull(Constant2_92_Var
		);
		Assert.assertEquals("0", Constant2_92_Var
		.getDec());
		//92
		final LogicalAndExpression LogicalAndExpression_93_Var
		 = (LogicalAndExpression)Expr_78_list.get(1);
		Assert.assertNotNull(LogicalAndExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = LogicalAndExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final InclusiveOrExpression InclusiveOrExpression_94_Var
		 = (InclusiveOrExpression)Expr_93_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = InclusiveOrExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final ExclusiveOrExpression ExclusiveOrExpression_95_Var
		 = (ExclusiveOrExpression)Expr_94_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = ExclusiveOrExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final AndExpression AndExpression_96_Var
		 = (AndExpression)Expr_95_list.get(0);
		Assert.assertNotNull(AndExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = AndExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final EqualityExpression EqualityExpression_97_Var
		 = (EqualityExpression)Expr_96_list.get(0);
		Assert.assertNotNull(EqualityExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = EqualityExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final RelationalExpression RelationalExpression_98_Var
		 = (RelationalExpression)Expr_97_list.get(0);
		Assert.assertNotNull(RelationalExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = RelationalExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final ShiftExpression ShiftExpression_99_Var
		 = (ShiftExpression)Expr_98_list.get(0);
		Assert.assertNotNull(ShiftExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = ShiftExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final AdditiveExpression AdditiveExpression_100_Var
		 = (AdditiveExpression)Expr_99_list.get(0);
		Assert.assertNotNull(AdditiveExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = AdditiveExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final MultiplicativeExpression MultiplicativeExpression_101_Var
		 = (MultiplicativeExpression)Expr_100_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = MultiplicativeExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final CastExpression CastExpression_102_Var
		 = (CastExpression)Expr_101_list.get(0);
		Assert.assertNotNull(CastExpression_102_Var
		);
		//102
		final UnaryExpression UnaryExpression_103_Var
		 = (UnaryExpression)CastExpression_102_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_103_Var
		);
		//103
		final PostfixExpression PostfixExpression_104_Var
		 = (PostfixExpression)UnaryExpression_103_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = PostfixExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final PrimaryExpression PrimaryExpression_105_Var
		 = (PrimaryExpression)Expr_104_list.get(0);
		Assert.assertNotNull(PrimaryExpression_105_Var
		);
		Assert.assertFalse(PrimaryExpression_105_Var
		.isExt());
		//105
		final CompoundStatement CompoundStatement_106_Var
		 = (CompoundStatement)PrimaryExpression_105_Var
		.getCompoundStmt();
		Assert.assertNotNull(CompoundStatement_106_Var
		);
		//106
		final BodyStatement BodyStatement_107_Var
		 = (BodyStatement)CompoundStatement_106_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_107_Var
		);
		final EList<? extends EObject> BlockList_107_list = BodyStatement_107_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_107_list);
		Assert.assertEquals(1, BlockList_107_list.size());
		//107
		final BlockList BlockList_108_Var
		 = (BlockList)BlockList_107_list.get(0);
		Assert.assertNotNull(BlockList_108_Var
		);
		final EList<? extends EObject> Statement_108_list = BlockList_108_Var
		.getStatement();
		Assert.assertNotNull(Statement_108_list);
		Assert.assertEquals(1, Statement_108_list.size());
		//108
		final Statement Statement_109_Var
		 = (Statement)Statement_108_list.get(0);
		Assert.assertNotNull(Statement_109_Var
		);
		//109
		final ExpressionStatement ExpressionStatement_110_Var
		 = (ExpressionStatement)Statement_109_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_110_Var
		);
		//110
		final Expression Expression_111_Var
		 = (Expression)ExpressionStatement_110_Var
		.getExpression();
		Assert.assertNotNull(Expression_111_Var
		);
		final EList<? extends EObject> ExprExpr_111_list = Expression_111_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_111_list);
		Assert.assertEquals(1, ExprExpr_111_list.size());
		//111
		final AssignmentExpression AssignmentExpression_112_Var
		 = (AssignmentExpression)ExprExpr_111_list.get(0);
		Assert.assertNotNull(AssignmentExpression_112_Var
		);
		//112
		final ConditionalExpression ConditionalExpression_113_Var
		 = (ConditionalExpression)AssignmentExpression_112_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_113_Var
		);
		//113
		final LogicalOrExpression LogicalOrExpression_114_Var
		 = (LogicalOrExpression)ConditionalExpression_113_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = LogicalOrExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final LogicalAndExpression LogicalAndExpression_115_Var
		 = (LogicalAndExpression)Expr_114_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = LogicalAndExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final InclusiveOrExpression InclusiveOrExpression_116_Var
		 = (InclusiveOrExpression)Expr_115_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = InclusiveOrExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final ExclusiveOrExpression ExclusiveOrExpression_117_Var
		 = (ExclusiveOrExpression)Expr_116_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = ExclusiveOrExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final AndExpression AndExpression_118_Var
		 = (AndExpression)Expr_117_list.get(0);
		Assert.assertNotNull(AndExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = AndExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final EqualityExpression EqualityExpression_119_Var
		 = (EqualityExpression)Expr_118_list.get(0);
		Assert.assertNotNull(EqualityExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = EqualityExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final RelationalExpression RelationalExpression_120_Var
		 = (RelationalExpression)Expr_119_list.get(0);
		Assert.assertNotNull(RelationalExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = RelationalExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final ShiftExpression ShiftExpression_121_Var
		 = (ShiftExpression)Expr_120_list.get(0);
		Assert.assertNotNull(ShiftExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = ShiftExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final AdditiveExpression AdditiveExpression_122_Var
		 = (AdditiveExpression)Expr_121_list.get(0);
		Assert.assertNotNull(AdditiveExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = AdditiveExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final MultiplicativeExpression MultiplicativeExpression_123_Var
		 = (MultiplicativeExpression)Expr_122_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = MultiplicativeExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final CastExpression CastExpression_124_Var
		 = (CastExpression)Expr_123_list.get(0);
		Assert.assertNotNull(CastExpression_124_Var
		);
		//124
		final UnaryExpression UnaryExpression_125_Var
		 = (UnaryExpression)CastExpression_124_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_125_Var
		);
		//125
		final PostfixExpression PostfixExpression_126_Var
		 = (PostfixExpression)UnaryExpression_125_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = PostfixExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final PrimaryExpression PrimaryExpression_127_Var
		 = (PrimaryExpression)Expr_126_list.get(0);
		Assert.assertNotNull(PrimaryExpression_127_Var
		);
		//127
		final Constant2 Constant2_128_Var
		 = (Constant2)PrimaryExpression_127_Var
		.getConst();
		Assert.assertNotNull(Constant2_128_Var
		);
		Assert.assertEquals("5", Constant2_128_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_57_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_57_Var
		.getSemi());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0064_BlocksInExpressions.c");
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
				method.invoke(this.generator, "Test0064_BlocksInExpressions.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0064_BlocksInExpressions.c");
		final String expected = this.getTextFromFile(
			"res/Test0064_BlocksInExpressions.c"
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


