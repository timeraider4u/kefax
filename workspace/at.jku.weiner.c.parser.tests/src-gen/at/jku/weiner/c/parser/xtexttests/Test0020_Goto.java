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
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
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
public class Test0020_Goto {
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
	
	@Test
	public void checkLexerTokens() throws Exception{
		final String text = this.getTextFromFile(
			"res/Test0020_Goto.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_VOID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_GOTO", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COLON", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
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
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0020_Goto.c");
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
		Assert.assertEquals("void", TypeSpecifier_4_Var
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
		Assert.assertEquals(3, Statement_9_list.size());
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
		final UnaryExpression UnaryExpression_12_Var
		 = (UnaryExpression)JumpStatement_11_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_12_Var
		);
		//12
		final PostfixExpression PostfixExpression_13_Var
		 = (PostfixExpression)UnaryExpression_12_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_13_Var
		);
		final EList<? extends EObject> Expr_13_list = PostfixExpression_13_Var
		.getExpr();
		Assert.assertNotNull(Expr_13_list);
		Assert.assertEquals(1, Expr_13_list.size());
		//13
		final PrimaryExpression PrimaryExpression_14_Var
		 = (PrimaryExpression)Expr_13_list.get(0);
		Assert.assertNotNull(PrimaryExpression_14_Var
		);
		Assert.assertEquals("target", PrimaryExpression_14_Var
		.getId());
		Assert.assertEquals("goto", JumpStatement_11_Var
		.getGoto());
		Assert.assertEquals(";", JumpStatement_11_Var
		.getSemi());
		//14
		final Statement Statement_15_Var
		 = (Statement)Statement_9_list.get(1);
		Assert.assertNotNull(Statement_15_Var
		);
		//15
		final ExpressionStatement ExpressionStatement_16_Var
		 = (ExpressionStatement)Statement_15_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_16_Var
		);
		//16
		final Expression Expression_17_Var
		 = (Expression)ExpressionStatement_16_Var
		.getExpression();
		Assert.assertNotNull(Expression_17_Var
		);
		final EList<? extends EObject> ExprExpr_17_list = Expression_17_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_17_list);
		Assert.assertEquals(1, ExprExpr_17_list.size());
		//17
		final AssignmentExpression AssignmentExpression_18_Var
		 = (AssignmentExpression)ExprExpr_17_list.get(0);
		Assert.assertNotNull(AssignmentExpression_18_Var
		);
		//18
		final ConditionalExpression ConditionalExpression_19_Var
		 = (ConditionalExpression)AssignmentExpression_18_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_19_Var
		);
		//19
		final LogicalOrExpression LogicalOrExpression_20_Var
		 = (LogicalOrExpression)ConditionalExpression_19_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = LogicalOrExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final LogicalAndExpression LogicalAndExpression_21_Var
		 = (LogicalAndExpression)Expr_20_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = LogicalAndExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final InclusiveOrExpression InclusiveOrExpression_22_Var
		 = (InclusiveOrExpression)Expr_21_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = InclusiveOrExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final ExclusiveOrExpression ExclusiveOrExpression_23_Var
		 = (ExclusiveOrExpression)Expr_22_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = ExclusiveOrExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final AndExpression AndExpression_24_Var
		 = (AndExpression)Expr_23_list.get(0);
		Assert.assertNotNull(AndExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = AndExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final EqualityExpression EqualityExpression_25_Var
		 = (EqualityExpression)Expr_24_list.get(0);
		Assert.assertNotNull(EqualityExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = EqualityExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final RelationalExpression RelationalExpression_26_Var
		 = (RelationalExpression)Expr_25_list.get(0);
		Assert.assertNotNull(RelationalExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = RelationalExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final ShiftExpression ShiftExpression_27_Var
		 = (ShiftExpression)Expr_26_list.get(0);
		Assert.assertNotNull(ShiftExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = ShiftExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final AdditiveExpression AdditiveExpression_28_Var
		 = (AdditiveExpression)Expr_27_list.get(0);
		Assert.assertNotNull(AdditiveExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = AdditiveExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final MultiplicativeExpression MultiplicativeExpression_29_Var
		 = (MultiplicativeExpression)Expr_28_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = MultiplicativeExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final CastExpression CastExpression_30_Var
		 = (CastExpression)Expr_29_list.get(0);
		Assert.assertNotNull(CastExpression_30_Var
		);
		//30
		final UnaryExpression UnaryExpression_31_Var
		 = (UnaryExpression)CastExpression_30_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_31_Var
		);
		//31
		final PostfixExpression PostfixExpression_32_Var
		 = (PostfixExpression)UnaryExpression_31_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = PostfixExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final PrimaryExpression PrimaryExpression_33_Var
		 = (PrimaryExpression)Expr_32_list.get(0);
		Assert.assertNotNull(PrimaryExpression_33_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_33_Var
		.getId());
		final EList<? extends EObject> Suffix_33_list = PostfixExpression_32_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_33_list);
		Assert.assertEquals(1, Suffix_33_list.size());
		//33
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_34_Var
		 = (PostfixExpressionSuffixArgument)Suffix_33_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_34_Var
		);
		//34
		final ArgumentExpressionList ArgumentExpressionList_35_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_34_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_35_Var
		);
		final EList<? extends EObject> Expr_35_list = ArgumentExpressionList_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final AssignmentExpression AssignmentExpression_36_Var
		 = (AssignmentExpression)Expr_35_list.get(0);
		Assert.assertNotNull(AssignmentExpression_36_Var
		);
		//36
		final ConditionalExpression ConditionalExpression_37_Var
		 = (ConditionalExpression)AssignmentExpression_36_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_37_Var
		);
		//37
		final LogicalOrExpression LogicalOrExpression_38_Var
		 = (LogicalOrExpression)ConditionalExpression_37_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = LogicalOrExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final LogicalAndExpression LogicalAndExpression_39_Var
		 = (LogicalAndExpression)Expr_38_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = LogicalAndExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final InclusiveOrExpression InclusiveOrExpression_40_Var
		 = (InclusiveOrExpression)Expr_39_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = InclusiveOrExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final ExclusiveOrExpression ExclusiveOrExpression_41_Var
		 = (ExclusiveOrExpression)Expr_40_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = ExclusiveOrExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final AndExpression AndExpression_42_Var
		 = (AndExpression)Expr_41_list.get(0);
		Assert.assertNotNull(AndExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = AndExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final EqualityExpression EqualityExpression_43_Var
		 = (EqualityExpression)Expr_42_list.get(0);
		Assert.assertNotNull(EqualityExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = EqualityExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final RelationalExpression RelationalExpression_44_Var
		 = (RelationalExpression)Expr_43_list.get(0);
		Assert.assertNotNull(RelationalExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = RelationalExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final ShiftExpression ShiftExpression_45_Var
		 = (ShiftExpression)Expr_44_list.get(0);
		Assert.assertNotNull(ShiftExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = ShiftExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final AdditiveExpression AdditiveExpression_46_Var
		 = (AdditiveExpression)Expr_45_list.get(0);
		Assert.assertNotNull(AdditiveExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = AdditiveExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final MultiplicativeExpression MultiplicativeExpression_47_Var
		 = (MultiplicativeExpression)Expr_46_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = MultiplicativeExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final CastExpression CastExpression_48_Var
		 = (CastExpression)Expr_47_list.get(0);
		Assert.assertNotNull(CastExpression_48_Var
		);
		//48
		final UnaryExpression UnaryExpression_49_Var
		 = (UnaryExpression)CastExpression_48_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_49_Var
		);
		//49
		final PostfixExpression PostfixExpression_50_Var
		 = (PostfixExpression)UnaryExpression_49_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = PostfixExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final PrimaryExpression PrimaryExpression_51_Var
		 = (PrimaryExpression)Expr_50_list.get(0);
		Assert.assertNotNull(PrimaryExpression_51_Var
		);
		//51
		final Constant2 Constant2_52_Var
		 = (Constant2)PrimaryExpression_51_Var
		.getConst();
		Assert.assertNotNull(Constant2_52_Var
		);
		Assert.assertEquals("\"will never be reached\\n\"", Constant2_52_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_16_Var
		.getSemi());
		//52
		final Statement Statement_53_Var
		 = (Statement)Statement_9_list.get(2);
		Assert.assertNotNull(Statement_53_Var
		);
		//53
		final LabeledStatement LabeledStatement_54_Var
		 = (LabeledStatement)Statement_53_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_54_Var
		);
		Assert.assertEquals("target", LabeledStatement_54_Var
		.getId());
		//54
		final Statement Statement_55_Var
		 = (Statement)LabeledStatement_54_Var
		.getLStmt();
		Assert.assertNotNull(Statement_55_Var
		);
		//55
		final ExpressionStatement ExpressionStatement_56_Var
		 = (ExpressionStatement)Statement_55_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_56_Var
		);
		//56
		final Expression Expression_57_Var
		 = (Expression)ExpressionStatement_56_Var
		.getExpression();
		Assert.assertNotNull(Expression_57_Var
		);
		final EList<? extends EObject> ExprExpr_57_list = Expression_57_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_57_list);
		Assert.assertEquals(1, ExprExpr_57_list.size());
		//57
		final AssignmentExpression AssignmentExpression_58_Var
		 = (AssignmentExpression)ExprExpr_57_list.get(0);
		Assert.assertNotNull(AssignmentExpression_58_Var
		);
		//58
		final ConditionalExpression ConditionalExpression_59_Var
		 = (ConditionalExpression)AssignmentExpression_58_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_59_Var
		);
		//59
		final LogicalOrExpression LogicalOrExpression_60_Var
		 = (LogicalOrExpression)ConditionalExpression_59_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = LogicalOrExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final LogicalAndExpression LogicalAndExpression_61_Var
		 = (LogicalAndExpression)Expr_60_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = LogicalAndExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final InclusiveOrExpression InclusiveOrExpression_62_Var
		 = (InclusiveOrExpression)Expr_61_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = InclusiveOrExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final ExclusiveOrExpression ExclusiveOrExpression_63_Var
		 = (ExclusiveOrExpression)Expr_62_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = ExclusiveOrExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final AndExpression AndExpression_64_Var
		 = (AndExpression)Expr_63_list.get(0);
		Assert.assertNotNull(AndExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = AndExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final EqualityExpression EqualityExpression_65_Var
		 = (EqualityExpression)Expr_64_list.get(0);
		Assert.assertNotNull(EqualityExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = EqualityExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final RelationalExpression RelationalExpression_66_Var
		 = (RelationalExpression)Expr_65_list.get(0);
		Assert.assertNotNull(RelationalExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = RelationalExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final ShiftExpression ShiftExpression_67_Var
		 = (ShiftExpression)Expr_66_list.get(0);
		Assert.assertNotNull(ShiftExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = ShiftExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final AdditiveExpression AdditiveExpression_68_Var
		 = (AdditiveExpression)Expr_67_list.get(0);
		Assert.assertNotNull(AdditiveExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = AdditiveExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final MultiplicativeExpression MultiplicativeExpression_69_Var
		 = (MultiplicativeExpression)Expr_68_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = MultiplicativeExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final CastExpression CastExpression_70_Var
		 = (CastExpression)Expr_69_list.get(0);
		Assert.assertNotNull(CastExpression_70_Var
		);
		//70
		final UnaryExpression UnaryExpression_71_Var
		 = (UnaryExpression)CastExpression_70_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_71_Var
		);
		//71
		final PostfixExpression PostfixExpression_72_Var
		 = (PostfixExpression)UnaryExpression_71_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = PostfixExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final PrimaryExpression PrimaryExpression_73_Var
		 = (PrimaryExpression)Expr_72_list.get(0);
		Assert.assertNotNull(PrimaryExpression_73_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_73_Var
		.getId());
		final EList<? extends EObject> Suffix_73_list = PostfixExpression_72_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_73_list);
		Assert.assertEquals(1, Suffix_73_list.size());
		//73
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_74_Var
		 = (PostfixExpressionSuffixArgument)Suffix_73_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_74_Var
		);
		//74
		final ArgumentExpressionList ArgumentExpressionList_75_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_74_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_75_Var
		);
		final EList<? extends EObject> Expr_75_list = ArgumentExpressionList_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final AssignmentExpression AssignmentExpression_76_Var
		 = (AssignmentExpression)Expr_75_list.get(0);
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
		Assert.assertEquals("\"reached target\\n\"", Constant2_92_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_56_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0020_Goto.c");
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
				method.invoke(this.generator, "Test0020_Goto.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0020_Goto.c");
		final String expected = this.getTextFromFile(
			"res/Test0020_Goto.c"
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


