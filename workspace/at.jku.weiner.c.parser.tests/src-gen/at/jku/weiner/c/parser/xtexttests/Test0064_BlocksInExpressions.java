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
import at.jku.weiner.c.parser.parser.Init;
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
		final EList<? extends EObject> Init_37_list = InitializerList_37_Var
		.getInit();
		Assert.assertNotNull(Init_37_list);
		Assert.assertEquals(1, Init_37_list.size());
		//37
		final Init Init_38_Var
		 = (Init)Init_37_list.get(0);
		Assert.assertNotNull(Init_38_Var
		);
		//38
		final Initializer Initializer_39_Var
		 = (Initializer)Init_38_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_39_Var
		);
		//39
		final AssignmentExpression AssignmentExpression_40_Var
		 = (AssignmentExpression)Initializer_39_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_40_Var
		);
		//40
		final ConditionalExpression ConditionalExpression_41_Var
		 = (ConditionalExpression)AssignmentExpression_40_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_41_Var
		);
		//41
		final LogicalOrExpression LogicalOrExpression_42_Var
		 = (LogicalOrExpression)ConditionalExpression_41_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = LogicalOrExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final LogicalAndExpression LogicalAndExpression_43_Var
		 = (LogicalAndExpression)Expr_42_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = LogicalAndExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final InclusiveOrExpression InclusiveOrExpression_44_Var
		 = (InclusiveOrExpression)Expr_43_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = InclusiveOrExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final ExclusiveOrExpression ExclusiveOrExpression_45_Var
		 = (ExclusiveOrExpression)Expr_44_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = ExclusiveOrExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final AndExpression AndExpression_46_Var
		 = (AndExpression)Expr_45_list.get(0);
		Assert.assertNotNull(AndExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = AndExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final EqualityExpression EqualityExpression_47_Var
		 = (EqualityExpression)Expr_46_list.get(0);
		Assert.assertNotNull(EqualityExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = EqualityExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final RelationalExpression RelationalExpression_48_Var
		 = (RelationalExpression)Expr_47_list.get(0);
		Assert.assertNotNull(RelationalExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = RelationalExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final ShiftExpression ShiftExpression_49_Var
		 = (ShiftExpression)Expr_48_list.get(0);
		Assert.assertNotNull(ShiftExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = ShiftExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final AdditiveExpression AdditiveExpression_50_Var
		 = (AdditiveExpression)Expr_49_list.get(0);
		Assert.assertNotNull(AdditiveExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = AdditiveExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final MultiplicativeExpression MultiplicativeExpression_51_Var
		 = (MultiplicativeExpression)Expr_50_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = MultiplicativeExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final CastExpression CastExpression_52_Var
		 = (CastExpression)Expr_51_list.get(0);
		Assert.assertNotNull(CastExpression_52_Var
		);
		//52
		final UnaryExpression UnaryExpression_53_Var
		 = (UnaryExpression)CastExpression_52_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_53_Var
		);
		//53
		final PostfixExpression PostfixExpression_54_Var
		 = (PostfixExpression)UnaryExpression_53_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = PostfixExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final PrimaryExpression PrimaryExpression_55_Var
		 = (PrimaryExpression)Expr_54_list.get(0);
		Assert.assertNotNull(PrimaryExpression_55_Var
		);
		//55
		final Constant2 Constant2_56_Var
		 = (Constant2)PrimaryExpression_55_Var
		.getConst();
		Assert.assertNotNull(Constant2_56_Var
		);
		Assert.assertEquals("7", Constant2_56_Var
		.getDec());
		Assert.assertFalse(PostfixExpression_33_Var
		.isComma());
		//56
		final Statement Statement_57_Var
		 = (Statement)Statement_9_list.get(1);
		Assert.assertNotNull(Statement_57_Var
		);
		//57
		final JumpStatement JumpStatement_58_Var
		 = (JumpStatement)Statement_57_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_58_Var
		);
		//58
		final Expression Expression_59_Var
		 = (Expression)JumpStatement_58_Var
		.getExpr();
		Assert.assertNotNull(Expression_59_Var
		);
		final EList<? extends EObject> ExprExpr_59_list = Expression_59_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_59_list);
		Assert.assertEquals(1, ExprExpr_59_list.size());
		//59
		final AssignmentExpression AssignmentExpression_60_Var
		 = (AssignmentExpression)ExprExpr_59_list.get(0);
		Assert.assertNotNull(AssignmentExpression_60_Var
		);
		//60
		final ConditionalExpression ConditionalExpression_61_Var
		 = (ConditionalExpression)AssignmentExpression_60_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_61_Var
		);
		//61
		final LogicalOrExpression LogicalOrExpression_62_Var
		 = (LogicalOrExpression)ConditionalExpression_61_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = LogicalOrExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final LogicalAndExpression LogicalAndExpression_63_Var
		 = (LogicalAndExpression)Expr_62_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = LogicalAndExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final InclusiveOrExpression InclusiveOrExpression_64_Var
		 = (InclusiveOrExpression)Expr_63_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = InclusiveOrExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final ExclusiveOrExpression ExclusiveOrExpression_65_Var
		 = (ExclusiveOrExpression)Expr_64_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = ExclusiveOrExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final AndExpression AndExpression_66_Var
		 = (AndExpression)Expr_65_list.get(0);
		Assert.assertNotNull(AndExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = AndExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final EqualityExpression EqualityExpression_67_Var
		 = (EqualityExpression)Expr_66_list.get(0);
		Assert.assertNotNull(EqualityExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = EqualityExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final RelationalExpression RelationalExpression_68_Var
		 = (RelationalExpression)Expr_67_list.get(0);
		Assert.assertNotNull(RelationalExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = RelationalExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final ShiftExpression ShiftExpression_69_Var
		 = (ShiftExpression)Expr_68_list.get(0);
		Assert.assertNotNull(ShiftExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = ShiftExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final AdditiveExpression AdditiveExpression_70_Var
		 = (AdditiveExpression)Expr_69_list.get(0);
		Assert.assertNotNull(AdditiveExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = AdditiveExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final MultiplicativeExpression MultiplicativeExpression_71_Var
		 = (MultiplicativeExpression)Expr_70_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = MultiplicativeExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final CastExpression CastExpression_72_Var
		 = (CastExpression)Expr_71_list.get(0);
		Assert.assertNotNull(CastExpression_72_Var
		);
		//72
		final UnaryExpression UnaryExpression_73_Var
		 = (UnaryExpression)CastExpression_72_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_73_Var
		);
		//73
		final PostfixExpression PostfixExpression_74_Var
		 = (PostfixExpression)UnaryExpression_73_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = PostfixExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final PrimaryExpression PrimaryExpression_75_Var
		 = (PrimaryExpression)Expr_74_list.get(0);
		Assert.assertNotNull(PrimaryExpression_75_Var
		);
		//75
		final Expression Expression_76_Var
		 = (Expression)PrimaryExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expression_76_Var
		);
		final EList<? extends EObject> ExprExpr_76_list = Expression_76_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_76_list);
		Assert.assertEquals(1, ExprExpr_76_list.size());
		//76
		final AssignmentExpression AssignmentExpression_77_Var
		 = (AssignmentExpression)ExprExpr_76_list.get(0);
		Assert.assertNotNull(AssignmentExpression_77_Var
		);
		//77
		final ConditionalExpression ConditionalExpression_78_Var
		 = (ConditionalExpression)AssignmentExpression_77_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_78_Var
		);
		//78
		final LogicalOrExpression LogicalOrExpression_79_Var
		 = (LogicalOrExpression)ConditionalExpression_78_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = LogicalOrExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(2, Expr_79_list.size());
		//79
		final LogicalAndExpression LogicalAndExpression_80_Var
		 = (LogicalAndExpression)Expr_79_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = LogicalAndExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final InclusiveOrExpression InclusiveOrExpression_81_Var
		 = (InclusiveOrExpression)Expr_80_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = InclusiveOrExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final ExclusiveOrExpression ExclusiveOrExpression_82_Var
		 = (ExclusiveOrExpression)Expr_81_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = ExclusiveOrExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final AndExpression AndExpression_83_Var
		 = (AndExpression)Expr_82_list.get(0);
		Assert.assertNotNull(AndExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = AndExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final EqualityExpression EqualityExpression_84_Var
		 = (EqualityExpression)Expr_83_list.get(0);
		Assert.assertNotNull(EqualityExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = EqualityExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final RelationalExpression RelationalExpression_85_Var
		 = (RelationalExpression)Expr_84_list.get(0);
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
		Assert.assertEquals("0", Constant2_93_Var
		.getDec());
		//93
		final LogicalAndExpression LogicalAndExpression_94_Var
		 = (LogicalAndExpression)Expr_79_list.get(1);
		Assert.assertNotNull(LogicalAndExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = LogicalAndExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final InclusiveOrExpression InclusiveOrExpression_95_Var
		 = (InclusiveOrExpression)Expr_94_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = InclusiveOrExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final ExclusiveOrExpression ExclusiveOrExpression_96_Var
		 = (ExclusiveOrExpression)Expr_95_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = ExclusiveOrExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final AndExpression AndExpression_97_Var
		 = (AndExpression)Expr_96_list.get(0);
		Assert.assertNotNull(AndExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = AndExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final EqualityExpression EqualityExpression_98_Var
		 = (EqualityExpression)Expr_97_list.get(0);
		Assert.assertNotNull(EqualityExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = EqualityExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final RelationalExpression RelationalExpression_99_Var
		 = (RelationalExpression)Expr_98_list.get(0);
		Assert.assertNotNull(RelationalExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = RelationalExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final ShiftExpression ShiftExpression_100_Var
		 = (ShiftExpression)Expr_99_list.get(0);
		Assert.assertNotNull(ShiftExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = ShiftExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final AdditiveExpression AdditiveExpression_101_Var
		 = (AdditiveExpression)Expr_100_list.get(0);
		Assert.assertNotNull(AdditiveExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = AdditiveExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final MultiplicativeExpression MultiplicativeExpression_102_Var
		 = (MultiplicativeExpression)Expr_101_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = MultiplicativeExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final CastExpression CastExpression_103_Var
		 = (CastExpression)Expr_102_list.get(0);
		Assert.assertNotNull(CastExpression_103_Var
		);
		//103
		final UnaryExpression UnaryExpression_104_Var
		 = (UnaryExpression)CastExpression_103_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_104_Var
		);
		//104
		final PostfixExpression PostfixExpression_105_Var
		 = (PostfixExpression)UnaryExpression_104_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = PostfixExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final PrimaryExpression PrimaryExpression_106_Var
		 = (PrimaryExpression)Expr_105_list.get(0);
		Assert.assertNotNull(PrimaryExpression_106_Var
		);
		Assert.assertFalse(PrimaryExpression_106_Var
		.isExt());
		//106
		final CompoundStatement CompoundStatement_107_Var
		 = (CompoundStatement)PrimaryExpression_106_Var
		.getCompoundStmt();
		Assert.assertNotNull(CompoundStatement_107_Var
		);
		//107
		final BodyStatement BodyStatement_108_Var
		 = (BodyStatement)CompoundStatement_107_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_108_Var
		);
		final EList<? extends EObject> BlockList_108_list = BodyStatement_108_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_108_list);
		Assert.assertEquals(1, BlockList_108_list.size());
		//108
		final BlockList BlockList_109_Var
		 = (BlockList)BlockList_108_list.get(0);
		Assert.assertNotNull(BlockList_109_Var
		);
		final EList<? extends EObject> Statement_109_list = BlockList_109_Var
		.getStatement();
		Assert.assertNotNull(Statement_109_list);
		Assert.assertEquals(1, Statement_109_list.size());
		//109
		final Statement Statement_110_Var
		 = (Statement)Statement_109_list.get(0);
		Assert.assertNotNull(Statement_110_Var
		);
		//110
		final ExpressionStatement ExpressionStatement_111_Var
		 = (ExpressionStatement)Statement_110_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_111_Var
		);
		//111
		final Expression Expression_112_Var
		 = (Expression)ExpressionStatement_111_Var
		.getExpression();
		Assert.assertNotNull(Expression_112_Var
		);
		final EList<? extends EObject> ExprExpr_112_list = Expression_112_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_112_list);
		Assert.assertEquals(1, ExprExpr_112_list.size());
		//112
		final AssignmentExpression AssignmentExpression_113_Var
		 = (AssignmentExpression)ExprExpr_112_list.get(0);
		Assert.assertNotNull(AssignmentExpression_113_Var
		);
		//113
		final ConditionalExpression ConditionalExpression_114_Var
		 = (ConditionalExpression)AssignmentExpression_113_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_114_Var
		);
		//114
		final LogicalOrExpression LogicalOrExpression_115_Var
		 = (LogicalOrExpression)ConditionalExpression_114_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = LogicalOrExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final LogicalAndExpression LogicalAndExpression_116_Var
		 = (LogicalAndExpression)Expr_115_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = LogicalAndExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final InclusiveOrExpression InclusiveOrExpression_117_Var
		 = (InclusiveOrExpression)Expr_116_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = InclusiveOrExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final ExclusiveOrExpression ExclusiveOrExpression_118_Var
		 = (ExclusiveOrExpression)Expr_117_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = ExclusiveOrExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final AndExpression AndExpression_119_Var
		 = (AndExpression)Expr_118_list.get(0);
		Assert.assertNotNull(AndExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = AndExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final EqualityExpression EqualityExpression_120_Var
		 = (EqualityExpression)Expr_119_list.get(0);
		Assert.assertNotNull(EqualityExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = EqualityExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final RelationalExpression RelationalExpression_121_Var
		 = (RelationalExpression)Expr_120_list.get(0);
		Assert.assertNotNull(RelationalExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = RelationalExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final ShiftExpression ShiftExpression_122_Var
		 = (ShiftExpression)Expr_121_list.get(0);
		Assert.assertNotNull(ShiftExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = ShiftExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final AdditiveExpression AdditiveExpression_123_Var
		 = (AdditiveExpression)Expr_122_list.get(0);
		Assert.assertNotNull(AdditiveExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = AdditiveExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final MultiplicativeExpression MultiplicativeExpression_124_Var
		 = (MultiplicativeExpression)Expr_123_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = MultiplicativeExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final CastExpression CastExpression_125_Var
		 = (CastExpression)Expr_124_list.get(0);
		Assert.assertNotNull(CastExpression_125_Var
		);
		//125
		final UnaryExpression UnaryExpression_126_Var
		 = (UnaryExpression)CastExpression_125_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_126_Var
		);
		//126
		final PostfixExpression PostfixExpression_127_Var
		 = (PostfixExpression)UnaryExpression_126_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = PostfixExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final PrimaryExpression PrimaryExpression_128_Var
		 = (PrimaryExpression)Expr_127_list.get(0);
		Assert.assertNotNull(PrimaryExpression_128_Var
		);
		//128
		final Constant2 Constant2_129_Var
		 = (Constant2)PrimaryExpression_128_Var
		.getConst();
		Assert.assertNotNull(Constant2_129_Var
		);
		Assert.assertEquals("5", Constant2_129_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_58_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_58_Var
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


