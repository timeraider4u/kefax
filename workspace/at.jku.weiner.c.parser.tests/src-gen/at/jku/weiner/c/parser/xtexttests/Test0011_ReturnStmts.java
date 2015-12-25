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
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0011_ReturnStmts.c");
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
		Assert.assertEquals(5, External_2_list.size());
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
		Assert.assertEquals("char", TypeSpecifier_6_Var
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
		Assert.assertEquals("doSomething1", DirectDeclarator_8_Var
		.getId());
		//8
		final FunctionDefinition FunctionDefinition_9_Var
		 = (FunctionDefinition)ExternalDeclaration_3_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_9_Var
		);
		//9
		final BodyStatement BodyStatement_10_Var
		 = (BodyStatement)FunctionDefinition_9_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_10_Var
		);
		final EList<? extends EObject> BlockList_10_list = BodyStatement_10_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_10_list);
		Assert.assertEquals(1, BlockList_10_list.size());
		//10
		final BlockList BlockList_11_Var
		 = (BlockList)BlockList_10_list.get(0);
		Assert.assertNotNull(BlockList_11_Var
		);
		final EList<? extends EObject> Statement_11_list = BlockList_11_Var
		.getStatement();
		Assert.assertNotNull(Statement_11_list);
		Assert.assertEquals(1, Statement_11_list.size());
		//11
		final Statement Statement_12_Var
		 = (Statement)Statement_11_list.get(0);
		Assert.assertNotNull(Statement_12_Var
		);
		//12
		final JumpStatement JumpStatement_13_Var
		 = (JumpStatement)Statement_12_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_13_Var
		);
		//13
		final Expression Expression_14_Var
		 = (Expression)JumpStatement_13_Var
		.getExpr();
		Assert.assertNotNull(Expression_14_Var
		);
		final EList<? extends EObject> ExprExpr_14_list = Expression_14_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_14_list);
		Assert.assertEquals(1, ExprExpr_14_list.size());
		//14
		final AssignmentExpression AssignmentExpression_15_Var
		 = (AssignmentExpression)ExprExpr_14_list.get(0);
		Assert.assertNotNull(AssignmentExpression_15_Var
		);
		//15
		final ConditionalExpression ConditionalExpression_16_Var
		 = (ConditionalExpression)AssignmentExpression_15_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_16_Var
		);
		//16
		final LogicalOrExpression LogicalOrExpression_17_Var
		 = (LogicalOrExpression)ConditionalExpression_16_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = LogicalOrExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final LogicalAndExpression LogicalAndExpression_18_Var
		 = (LogicalAndExpression)Expr_17_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = LogicalAndExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final InclusiveOrExpression InclusiveOrExpression_19_Var
		 = (InclusiveOrExpression)Expr_18_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = InclusiveOrExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final ExclusiveOrExpression ExclusiveOrExpression_20_Var
		 = (ExclusiveOrExpression)Expr_19_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = ExclusiveOrExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final AndExpression AndExpression_21_Var
		 = (AndExpression)Expr_20_list.get(0);
		Assert.assertNotNull(AndExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = AndExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final EqualityExpression EqualityExpression_22_Var
		 = (EqualityExpression)Expr_21_list.get(0);
		Assert.assertNotNull(EqualityExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = EqualityExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final RelationalExpression RelationalExpression_23_Var
		 = (RelationalExpression)Expr_22_list.get(0);
		Assert.assertNotNull(RelationalExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = RelationalExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final ShiftExpression ShiftExpression_24_Var
		 = (ShiftExpression)Expr_23_list.get(0);
		Assert.assertNotNull(ShiftExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = ShiftExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final AdditiveExpression AdditiveExpression_25_Var
		 = (AdditiveExpression)Expr_24_list.get(0);
		Assert.assertNotNull(AdditiveExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = AdditiveExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final MultiplicativeExpression MultiplicativeExpression_26_Var
		 = (MultiplicativeExpression)Expr_25_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = MultiplicativeExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final CastExpression CastExpression_27_Var
		 = (CastExpression)Expr_26_list.get(0);
		Assert.assertNotNull(CastExpression_27_Var
		);
		//27
		final UnaryExpression UnaryExpression_28_Var
		 = (UnaryExpression)CastExpression_27_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_28_Var
		);
		//28
		final PostfixExpression PostfixExpression_29_Var
		 = (PostfixExpression)UnaryExpression_28_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = PostfixExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final PrimaryExpression PrimaryExpression_30_Var
		 = (PrimaryExpression)Expr_29_list.get(0);
		Assert.assertNotNull(PrimaryExpression_30_Var
		);
		//30
		final Constant2 Constant2_31_Var
		 = (Constant2)PrimaryExpression_30_Var
		.getConst();
		Assert.assertNotNull(Constant2_31_Var
		);
		Assert.assertEquals("'a'", Constant2_31_Var
		.getCh());
		Assert.assertEquals("return", JumpStatement_13_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_13_Var
		.getSemi());
		//31
		final ExternalDeclaration ExternalDeclaration_32_Var
		 = (ExternalDeclaration)External_2_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_32_Var
		);
		//32
		final FunctionDefHead FunctionDefHead_33_Var
		 = (FunctionDefHead)ExternalDeclaration_32_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_33_Var
		);
		//33
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_34_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_33_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_34_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_34_list = FunctionDeclarationSpecifiers_34_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_34_list);
		Assert.assertEquals(1, DeclarationSpecifier_34_list.size());
		//34
		final TypeSpecifier TypeSpecifier_35_Var
		 = (TypeSpecifier)DeclarationSpecifier_34_list.get(0);
		Assert.assertNotNull(TypeSpecifier_35_Var
		);
		Assert.assertEquals("int", TypeSpecifier_35_Var
		.getName());
		//35
		final Declarator Declarator_36_Var
		 = (Declarator)FunctionDefHead_33_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_36_Var
		);
		//36
		final DirectDeclarator DirectDeclarator_37_Var
		 = (DirectDeclarator)Declarator_36_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_37_Var
		);
		Assert.assertEquals("doSomething2", DirectDeclarator_37_Var
		.getId());
		//37
		final FunctionDefinition FunctionDefinition_38_Var
		 = (FunctionDefinition)ExternalDeclaration_32_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_38_Var
		);
		//38
		final BodyStatement BodyStatement_39_Var
		 = (BodyStatement)FunctionDefinition_38_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_39_Var
		);
		final EList<? extends EObject> BlockList_39_list = BodyStatement_39_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_39_list);
		Assert.assertEquals(1, BlockList_39_list.size());
		//39
		final BlockList BlockList_40_Var
		 = (BlockList)BlockList_39_list.get(0);
		Assert.assertNotNull(BlockList_40_Var
		);
		final EList<? extends EObject> Statement_40_list = BlockList_40_Var
		.getStatement();
		Assert.assertNotNull(Statement_40_list);
		Assert.assertEquals(1, Statement_40_list.size());
		//40
		final Statement Statement_41_Var
		 = (Statement)Statement_40_list.get(0);
		Assert.assertNotNull(Statement_41_Var
		);
		//41
		final JumpStatement JumpStatement_42_Var
		 = (JumpStatement)Statement_41_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_42_Var
		);
		//42
		final Expression Expression_43_Var
		 = (Expression)JumpStatement_42_Var
		.getExpr();
		Assert.assertNotNull(Expression_43_Var
		);
		final EList<? extends EObject> ExprExpr_43_list = Expression_43_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_43_list);
		Assert.assertEquals(1, ExprExpr_43_list.size());
		//43
		final AssignmentExpression AssignmentExpression_44_Var
		 = (AssignmentExpression)ExprExpr_43_list.get(0);
		Assert.assertNotNull(AssignmentExpression_44_Var
		);
		//44
		final ConditionalExpression ConditionalExpression_45_Var
		 = (ConditionalExpression)AssignmentExpression_44_Var
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
		final CastExpression CastExpression_58_Var
		 = (CastExpression)UnaryExpression_57_Var
		.getExpr();
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
		Assert.assertEquals("1", Constant2_62_Var
		.getDec());
		//62
		final UnaryOperator UnaryOperator_63_Var
		 = (UnaryOperator)UnaryExpression_57_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_63_Var
		);
		Assert.assertEquals("-", UnaryOperator_63_Var
		.getOp());
		Assert.assertEquals("return", JumpStatement_42_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_42_Var
		.getSemi());
		//63
		final ExternalDeclaration ExternalDeclaration_64_Var
		 = (ExternalDeclaration)External_2_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_64_Var
		);
		//64
		final FunctionDefHead FunctionDefHead_65_Var
		 = (FunctionDefHead)ExternalDeclaration_64_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_65_Var
		);
		//65
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_66_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_65_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_66_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_66_list = FunctionDeclarationSpecifiers_66_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_66_list);
		Assert.assertEquals(1, DeclarationSpecifier_66_list.size());
		//66
		final TypeSpecifier TypeSpecifier_67_Var
		 = (TypeSpecifier)DeclarationSpecifier_66_list.get(0);
		Assert.assertNotNull(TypeSpecifier_67_Var
		);
		Assert.assertEquals("double", TypeSpecifier_67_Var
		.getName());
		//67
		final Declarator Declarator_68_Var
		 = (Declarator)FunctionDefHead_65_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_68_Var
		);
		//68
		final DirectDeclarator DirectDeclarator_69_Var
		 = (DirectDeclarator)Declarator_68_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_69_Var
		);
		Assert.assertEquals("doSomething3", DirectDeclarator_69_Var
		.getId());
		//69
		final FunctionDefinition FunctionDefinition_70_Var
		 = (FunctionDefinition)ExternalDeclaration_64_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_70_Var
		);
		//70
		final BodyStatement BodyStatement_71_Var
		 = (BodyStatement)FunctionDefinition_70_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_71_Var
		);
		final EList<? extends EObject> BlockList_71_list = BodyStatement_71_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_71_list);
		Assert.assertEquals(1, BlockList_71_list.size());
		//71
		final BlockList BlockList_72_Var
		 = (BlockList)BlockList_71_list.get(0);
		Assert.assertNotNull(BlockList_72_Var
		);
		final EList<? extends EObject> Statement_72_list = BlockList_72_Var
		.getStatement();
		Assert.assertNotNull(Statement_72_list);
		Assert.assertEquals(1, Statement_72_list.size());
		//72
		final Statement Statement_73_Var
		 = (Statement)Statement_72_list.get(0);
		Assert.assertNotNull(Statement_73_Var
		);
		//73
		final JumpStatement JumpStatement_74_Var
		 = (JumpStatement)Statement_73_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_74_Var
		);
		//74
		final Expression Expression_75_Var
		 = (Expression)JumpStatement_74_Var
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
		Assert.assertEquals(1, Expr_78_list.size());
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
		Assert.assertEquals("0.8", Constant2_92_Var
		.getFloat());
		Assert.assertEquals("return", JumpStatement_74_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_74_Var
		.getSemi());
		//92
		final ExternalDeclaration ExternalDeclaration_93_Var
		 = (ExternalDeclaration)External_2_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_93_Var
		);
		//93
		final FunctionDefHead FunctionDefHead_94_Var
		 = (FunctionDefHead)ExternalDeclaration_93_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_94_Var
		);
		//94
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_95_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_94_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_95_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_95_list = FunctionDeclarationSpecifiers_95_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_95_list);
		Assert.assertEquals(1, DeclarationSpecifier_95_list.size());
		//95
		final TypeSpecifier TypeSpecifier_96_Var
		 = (TypeSpecifier)DeclarationSpecifier_95_list.get(0);
		Assert.assertNotNull(TypeSpecifier_96_Var
		);
		Assert.assertEquals("float", TypeSpecifier_96_Var
		.getName());
		//96
		final Declarator Declarator_97_Var
		 = (Declarator)FunctionDefHead_94_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_97_Var
		);
		//97
		final DirectDeclarator DirectDeclarator_98_Var
		 = (DirectDeclarator)Declarator_97_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_98_Var
		);
		Assert.assertEquals("doSomething4", DirectDeclarator_98_Var
		.getId());
		//98
		final FunctionDefinition FunctionDefinition_99_Var
		 = (FunctionDefinition)ExternalDeclaration_93_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_99_Var
		);
		//99
		final BodyStatement BodyStatement_100_Var
		 = (BodyStatement)FunctionDefinition_99_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_100_Var
		);
		final EList<? extends EObject> BlockList_100_list = BodyStatement_100_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_100_list);
		Assert.assertEquals(1, BlockList_100_list.size());
		//100
		final BlockList BlockList_101_Var
		 = (BlockList)BlockList_100_list.get(0);
		Assert.assertNotNull(BlockList_101_Var
		);
		final EList<? extends EObject> Statement_101_list = BlockList_101_Var
		.getStatement();
		Assert.assertNotNull(Statement_101_list);
		Assert.assertEquals(1, Statement_101_list.size());
		//101
		final Statement Statement_102_Var
		 = (Statement)Statement_101_list.get(0);
		Assert.assertNotNull(Statement_102_Var
		);
		//102
		final JumpStatement JumpStatement_103_Var
		 = (JumpStatement)Statement_102_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_103_Var
		);
		//103
		final Expression Expression_104_Var
		 = (Expression)JumpStatement_103_Var
		.getExpr();
		Assert.assertNotNull(Expression_104_Var
		);
		final EList<? extends EObject> ExprExpr_104_list = Expression_104_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_104_list);
		Assert.assertEquals(1, ExprExpr_104_list.size());
		//104
		final AssignmentExpression AssignmentExpression_105_Var
		 = (AssignmentExpression)ExprExpr_104_list.get(0);
		Assert.assertNotNull(AssignmentExpression_105_Var
		);
		//105
		final ConditionalExpression ConditionalExpression_106_Var
		 = (ConditionalExpression)AssignmentExpression_105_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_106_Var
		);
		//106
		final LogicalOrExpression LogicalOrExpression_107_Var
		 = (LogicalOrExpression)ConditionalExpression_106_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = LogicalOrExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final LogicalAndExpression LogicalAndExpression_108_Var
		 = (LogicalAndExpression)Expr_107_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = LogicalAndExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final InclusiveOrExpression InclusiveOrExpression_109_Var
		 = (InclusiveOrExpression)Expr_108_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = InclusiveOrExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final ExclusiveOrExpression ExclusiveOrExpression_110_Var
		 = (ExclusiveOrExpression)Expr_109_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = ExclusiveOrExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final AndExpression AndExpression_111_Var
		 = (AndExpression)Expr_110_list.get(0);
		Assert.assertNotNull(AndExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = AndExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final EqualityExpression EqualityExpression_112_Var
		 = (EqualityExpression)Expr_111_list.get(0);
		Assert.assertNotNull(EqualityExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = EqualityExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final RelationalExpression RelationalExpression_113_Var
		 = (RelationalExpression)Expr_112_list.get(0);
		Assert.assertNotNull(RelationalExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = RelationalExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final ShiftExpression ShiftExpression_114_Var
		 = (ShiftExpression)Expr_113_list.get(0);
		Assert.assertNotNull(ShiftExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = ShiftExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final AdditiveExpression AdditiveExpression_115_Var
		 = (AdditiveExpression)Expr_114_list.get(0);
		Assert.assertNotNull(AdditiveExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = AdditiveExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final MultiplicativeExpression MultiplicativeExpression_116_Var
		 = (MultiplicativeExpression)Expr_115_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = MultiplicativeExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final CastExpression CastExpression_117_Var
		 = (CastExpression)Expr_116_list.get(0);
		Assert.assertNotNull(CastExpression_117_Var
		);
		//117
		final UnaryExpression UnaryExpression_118_Var
		 = (UnaryExpression)CastExpression_117_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_118_Var
		);
		//118
		final PostfixExpression PostfixExpression_119_Var
		 = (PostfixExpression)UnaryExpression_118_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = PostfixExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final PrimaryExpression PrimaryExpression_120_Var
		 = (PrimaryExpression)Expr_119_list.get(0);
		Assert.assertNotNull(PrimaryExpression_120_Var
		);
		//120
		final Constant2 Constant2_121_Var
		 = (Constant2)PrimaryExpression_120_Var
		.getConst();
		Assert.assertNotNull(Constant2_121_Var
		);
		Assert.assertEquals("0x01A", Constant2_121_Var
		.getHex());
		Assert.assertEquals("return", JumpStatement_103_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_103_Var
		.getSemi());
		//121
		final ExternalDeclaration ExternalDeclaration_122_Var
		 = (ExternalDeclaration)External_2_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_122_Var
		);
		//122
		final FunctionDefHead FunctionDefHead_123_Var
		 = (FunctionDefHead)ExternalDeclaration_122_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_123_Var
		);
		//123
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_124_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_123_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_124_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_124_list = FunctionDeclarationSpecifiers_124_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_124_list);
		Assert.assertEquals(1, DeclarationSpecifier_124_list.size());
		//124
		final TypeSpecifier TypeSpecifier_125_Var
		 = (TypeSpecifier)DeclarationSpecifier_124_list.get(0);
		Assert.assertNotNull(TypeSpecifier_125_Var
		);
		Assert.assertEquals("void", TypeSpecifier_125_Var
		.getName());
		//125
		final Declarator Declarator_126_Var
		 = (Declarator)FunctionDefHead_123_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_126_Var
		);
		//126
		final DirectDeclarator DirectDeclarator_127_Var
		 = (DirectDeclarator)Declarator_126_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_127_Var
		);
		Assert.assertEquals("doSomething5", DirectDeclarator_127_Var
		.getId());
		//127
		final FunctionDefinition FunctionDefinition_128_Var
		 = (FunctionDefinition)ExternalDeclaration_122_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_128_Var
		);
		//128
		final BodyStatement BodyStatement_129_Var
		 = (BodyStatement)FunctionDefinition_128_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_129_Var
		);
		final EList<? extends EObject> BlockList_129_list = BodyStatement_129_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_129_list);
		Assert.assertEquals(1, BlockList_129_list.size());
		//129
		final BlockList BlockList_130_Var
		 = (BlockList)BlockList_129_list.get(0);
		Assert.assertNotNull(BlockList_130_Var
		);
		final EList<? extends EObject> Statement_130_list = BlockList_130_Var
		.getStatement();
		Assert.assertNotNull(Statement_130_list);
		Assert.assertEquals(1, Statement_130_list.size());
		//130
		final Statement Statement_131_Var
		 = (Statement)Statement_130_list.get(0);
		Assert.assertNotNull(Statement_131_Var
		);
		//131
		final JumpStatement JumpStatement_132_Var
		 = (JumpStatement)Statement_131_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_132_Var
		);
		Assert.assertEquals("return", JumpStatement_132_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_132_Var
		.getSemi());
	}
	
	@Test
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


