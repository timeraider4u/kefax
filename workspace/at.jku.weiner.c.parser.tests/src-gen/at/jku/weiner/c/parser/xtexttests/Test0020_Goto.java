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
		Assert.assertEquals("void", TypeSpecifier_5_Var
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
		//7
		final FunctionDefinition FunctionDefinition_8_Var
		 = (FunctionDefinition)ExternalDeclaration_2_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_8_Var
		);
		//8
		final BodyStatement BodyStatement_9_Var
		 = (BodyStatement)FunctionDefinition_8_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_9_Var
		);
		final EList<? extends EObject> BlockList_9_list = BodyStatement_9_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_9_list);
		Assert.assertEquals(1, BlockList_9_list.size());
		//9
		final BlockList BlockList_10_Var
		 = (BlockList)BlockList_9_list.get(0);
		Assert.assertNotNull(BlockList_10_Var
		);
		final EList<? extends EObject> Statement_10_list = BlockList_10_Var
		.getStatement();
		Assert.assertNotNull(Statement_10_list);
		Assert.assertEquals(3, Statement_10_list.size());
		//10
		final Statement Statement_11_Var
		 = (Statement)Statement_10_list.get(0);
		Assert.assertNotNull(Statement_11_Var
		);
		//11
		final JumpStatement JumpStatement_12_Var
		 = (JumpStatement)Statement_11_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_12_Var
		);
		//12
		final UnaryExpression UnaryExpression_13_Var
		 = (UnaryExpression)JumpStatement_12_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_13_Var
		);
		//13
		final PostfixExpression PostfixExpression_14_Var
		 = (PostfixExpression)UnaryExpression_13_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = PostfixExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		//14
		final PrimaryExpression PrimaryExpression_15_Var
		 = (PrimaryExpression)Expr_14_list.get(0);
		Assert.assertNotNull(PrimaryExpression_15_Var
		);
		Assert.assertEquals("target", PrimaryExpression_15_Var
		.getId());
		Assert.assertEquals("goto", JumpStatement_12_Var
		.getGoto());
		Assert.assertEquals(";", JumpStatement_12_Var
		.getSemi());
		//15
		final Statement Statement_16_Var
		 = (Statement)Statement_10_list.get(1);
		Assert.assertNotNull(Statement_16_Var
		);
		//16
		final ExpressionStatement ExpressionStatement_17_Var
		 = (ExpressionStatement)Statement_16_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_17_Var
		);
		//17
		final Expression Expression_18_Var
		 = (Expression)ExpressionStatement_17_Var
		.getExpression();
		Assert.assertNotNull(Expression_18_Var
		);
		final EList<? extends EObject> ExprExpr_18_list = Expression_18_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_18_list);
		Assert.assertEquals(1, ExprExpr_18_list.size());
		//18
		final AssignmentExpression AssignmentExpression_19_Var
		 = (AssignmentExpression)ExprExpr_18_list.get(0);
		Assert.assertNotNull(AssignmentExpression_19_Var
		);
		//19
		final ConditionalExpression ConditionalExpression_20_Var
		 = (ConditionalExpression)AssignmentExpression_19_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_20_Var
		);
		//20
		final LogicalOrExpression LogicalOrExpression_21_Var
		 = (LogicalOrExpression)ConditionalExpression_20_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = LogicalOrExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final LogicalAndExpression LogicalAndExpression_22_Var
		 = (LogicalAndExpression)Expr_21_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = LogicalAndExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final InclusiveOrExpression InclusiveOrExpression_23_Var
		 = (InclusiveOrExpression)Expr_22_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = InclusiveOrExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final ExclusiveOrExpression ExclusiveOrExpression_24_Var
		 = (ExclusiveOrExpression)Expr_23_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = ExclusiveOrExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final AndExpression AndExpression_25_Var
		 = (AndExpression)Expr_24_list.get(0);
		Assert.assertNotNull(AndExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = AndExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final EqualityExpression EqualityExpression_26_Var
		 = (EqualityExpression)Expr_25_list.get(0);
		Assert.assertNotNull(EqualityExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = EqualityExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final RelationalExpression RelationalExpression_27_Var
		 = (RelationalExpression)Expr_26_list.get(0);
		Assert.assertNotNull(RelationalExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = RelationalExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final ShiftExpression ShiftExpression_28_Var
		 = (ShiftExpression)Expr_27_list.get(0);
		Assert.assertNotNull(ShiftExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = ShiftExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final AdditiveExpression AdditiveExpression_29_Var
		 = (AdditiveExpression)Expr_28_list.get(0);
		Assert.assertNotNull(AdditiveExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = AdditiveExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final MultiplicativeExpression MultiplicativeExpression_30_Var
		 = (MultiplicativeExpression)Expr_29_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_34_Var
		.getId());
		final EList<? extends EObject> Suffix_34_list = PostfixExpression_33_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_34_list);
		Assert.assertEquals(1, Suffix_34_list.size());
		//34
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_35_Var
		 = (PostfixExpressionSuffixArgument)Suffix_34_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_35_Var
		);
		//35
		final ArgumentExpressionList ArgumentExpressionList_36_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_35_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_36_Var
		);
		final EList<? extends EObject> Expr_36_list = ArgumentExpressionList_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final AssignmentExpression AssignmentExpression_37_Var
		 = (AssignmentExpression)Expr_36_list.get(0);
		Assert.assertNotNull(AssignmentExpression_37_Var
		);
		//37
		final ConditionalExpression ConditionalExpression_38_Var
		 = (ConditionalExpression)AssignmentExpression_37_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_38_Var
		);
		//38
		final LogicalOrExpression LogicalOrExpression_39_Var
		 = (LogicalOrExpression)ConditionalExpression_38_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = LogicalOrExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final LogicalAndExpression LogicalAndExpression_40_Var
		 = (LogicalAndExpression)Expr_39_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = LogicalAndExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final InclusiveOrExpression InclusiveOrExpression_41_Var
		 = (InclusiveOrExpression)Expr_40_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = InclusiveOrExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final ExclusiveOrExpression ExclusiveOrExpression_42_Var
		 = (ExclusiveOrExpression)Expr_41_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = ExclusiveOrExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final AndExpression AndExpression_43_Var
		 = (AndExpression)Expr_42_list.get(0);
		Assert.assertNotNull(AndExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = AndExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final EqualityExpression EqualityExpression_44_Var
		 = (EqualityExpression)Expr_43_list.get(0);
		Assert.assertNotNull(EqualityExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = EqualityExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final RelationalExpression RelationalExpression_45_Var
		 = (RelationalExpression)Expr_44_list.get(0);
		Assert.assertNotNull(RelationalExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = RelationalExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final ShiftExpression ShiftExpression_46_Var
		 = (ShiftExpression)Expr_45_list.get(0);
		Assert.assertNotNull(ShiftExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = ShiftExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final AdditiveExpression AdditiveExpression_47_Var
		 = (AdditiveExpression)Expr_46_list.get(0);
		Assert.assertNotNull(AdditiveExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = AdditiveExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final MultiplicativeExpression MultiplicativeExpression_48_Var
		 = (MultiplicativeExpression)Expr_47_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = MultiplicativeExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final CastExpression CastExpression_49_Var
		 = (CastExpression)Expr_48_list.get(0);
		Assert.assertNotNull(CastExpression_49_Var
		);
		//49
		final UnaryExpression UnaryExpression_50_Var
		 = (UnaryExpression)CastExpression_49_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_50_Var
		);
		//50
		final PostfixExpression PostfixExpression_51_Var
		 = (PostfixExpression)UnaryExpression_50_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = PostfixExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final PrimaryExpression PrimaryExpression_52_Var
		 = (PrimaryExpression)Expr_51_list.get(0);
		Assert.assertNotNull(PrimaryExpression_52_Var
		);
		//52
		final Constant2 Constant2_53_Var
		 = (Constant2)PrimaryExpression_52_Var
		.getConst();
		Assert.assertNotNull(Constant2_53_Var
		);
		Assert.assertEquals("\"will never be reached\\n\"", Constant2_53_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_17_Var
		.getSemi());
		//53
		final Statement Statement_54_Var
		 = (Statement)Statement_10_list.get(2);
		Assert.assertNotNull(Statement_54_Var
		);
		//54
		final LabeledStatement LabeledStatement_55_Var
		 = (LabeledStatement)Statement_54_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_55_Var
		);
		Assert.assertEquals("target", LabeledStatement_55_Var
		.getId());
		//55
		final Statement Statement_56_Var
		 = (Statement)LabeledStatement_55_Var
		.getLStmt();
		Assert.assertNotNull(Statement_56_Var
		);
		//56
		final ExpressionStatement ExpressionStatement_57_Var
		 = (ExpressionStatement)Statement_56_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_57_Var
		);
		//57
		final Expression Expression_58_Var
		 = (Expression)ExpressionStatement_57_Var
		.getExpression();
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
		Assert.assertEquals("printf", PrimaryExpression_74_Var
		.getId());
		final EList<? extends EObject> Suffix_74_list = PostfixExpression_73_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_74_list);
		Assert.assertEquals(1, Suffix_74_list.size());
		//74
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_75_Var
		 = (PostfixExpressionSuffixArgument)Suffix_74_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_75_Var
		);
		//75
		final ArgumentExpressionList ArgumentExpressionList_76_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_75_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_76_Var
		);
		final EList<? extends EObject> Expr_76_list = ArgumentExpressionList_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final AssignmentExpression AssignmentExpression_77_Var
		 = (AssignmentExpression)Expr_76_list.get(0);
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
		Assert.assertEquals(1, Expr_79_list.size());
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
		Assert.assertEquals("\"reached target\\n\"", Constant2_93_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_57_Var
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


