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
		Assert.assertEquals("void", TypeSpecifier_6_Var
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
		Assert.assertEquals(3, Statement_11_list.size());
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
		final UnaryExpression UnaryExpression_14_Var
		 = (UnaryExpression)JumpStatement_13_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_14_Var
		);
		//14
		final PostfixExpression PostfixExpression_15_Var
		 = (PostfixExpression)UnaryExpression_14_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = PostfixExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final PrimaryExpression PrimaryExpression_16_Var
		 = (PrimaryExpression)Expr_15_list.get(0);
		Assert.assertNotNull(PrimaryExpression_16_Var
		);
		Assert.assertEquals("target", PrimaryExpression_16_Var
		.getId());
		Assert.assertEquals("goto", JumpStatement_13_Var
		.getGoto());
		Assert.assertEquals(";", JumpStatement_13_Var
		.getSemi());
		//16
		final Statement Statement_17_Var
		 = (Statement)Statement_11_list.get(1);
		Assert.assertNotNull(Statement_17_Var
		);
		//17
		final ExpressionStatement ExpressionStatement_18_Var
		 = (ExpressionStatement)Statement_17_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_18_Var
		);
		//18
		final Expression Expression_19_Var
		 = (Expression)ExpressionStatement_18_Var
		.getExpression();
		Assert.assertNotNull(Expression_19_Var
		);
		final EList<? extends EObject> ExprExpr_19_list = Expression_19_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_19_list);
		Assert.assertEquals(1, ExprExpr_19_list.size());
		//19
		final AssignmentExpression AssignmentExpression_20_Var
		 = (AssignmentExpression)ExprExpr_19_list.get(0);
		Assert.assertNotNull(AssignmentExpression_20_Var
		);
		//20
		final ConditionalExpression ConditionalExpression_21_Var
		 = (ConditionalExpression)AssignmentExpression_20_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_21_Var
		);
		//21
		final LogicalOrExpression LogicalOrExpression_22_Var
		 = (LogicalOrExpression)ConditionalExpression_21_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = LogicalOrExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final LogicalAndExpression LogicalAndExpression_23_Var
		 = (LogicalAndExpression)Expr_22_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = LogicalAndExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final InclusiveOrExpression InclusiveOrExpression_24_Var
		 = (InclusiveOrExpression)Expr_23_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = InclusiveOrExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final ExclusiveOrExpression ExclusiveOrExpression_25_Var
		 = (ExclusiveOrExpression)Expr_24_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = ExclusiveOrExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final AndExpression AndExpression_26_Var
		 = (AndExpression)Expr_25_list.get(0);
		Assert.assertNotNull(AndExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = AndExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final EqualityExpression EqualityExpression_27_Var
		 = (EqualityExpression)Expr_26_list.get(0);
		Assert.assertNotNull(EqualityExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = EqualityExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final RelationalExpression RelationalExpression_28_Var
		 = (RelationalExpression)Expr_27_list.get(0);
		Assert.assertNotNull(RelationalExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = RelationalExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final ShiftExpression ShiftExpression_29_Var
		 = (ShiftExpression)Expr_28_list.get(0);
		Assert.assertNotNull(ShiftExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = ShiftExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final AdditiveExpression AdditiveExpression_30_Var
		 = (AdditiveExpression)Expr_29_list.get(0);
		Assert.assertNotNull(AdditiveExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = AdditiveExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final MultiplicativeExpression MultiplicativeExpression_31_Var
		 = (MultiplicativeExpression)Expr_30_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = MultiplicativeExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final CastExpression CastExpression_32_Var
		 = (CastExpression)Expr_31_list.get(0);
		Assert.assertNotNull(CastExpression_32_Var
		);
		//32
		final UnaryExpression UnaryExpression_33_Var
		 = (UnaryExpression)CastExpression_32_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_33_Var
		);
		//33
		final PostfixExpression PostfixExpression_34_Var
		 = (PostfixExpression)UnaryExpression_33_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = PostfixExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final PrimaryExpression PrimaryExpression_35_Var
		 = (PrimaryExpression)Expr_34_list.get(0);
		Assert.assertNotNull(PrimaryExpression_35_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_35_Var
		.getId());
		final EList<? extends EObject> Suffix_35_list = PostfixExpression_34_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_35_list);
		Assert.assertEquals(1, Suffix_35_list.size());
		//35
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_36_Var
		 = (PostfixExpressionSuffixArgument)Suffix_35_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_36_Var
		);
		//36
		final ArgumentExpressionList ArgumentExpressionList_37_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_36_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_37_Var
		);
		final EList<? extends EObject> Expr_37_list = ArgumentExpressionList_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final AssignmentExpression AssignmentExpression_38_Var
		 = (AssignmentExpression)Expr_37_list.get(0);
		Assert.assertNotNull(AssignmentExpression_38_Var
		);
		//38
		final ConditionalExpression ConditionalExpression_39_Var
		 = (ConditionalExpression)AssignmentExpression_38_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_39_Var
		);
		//39
		final LogicalOrExpression LogicalOrExpression_40_Var
		 = (LogicalOrExpression)ConditionalExpression_39_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = LogicalOrExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final LogicalAndExpression LogicalAndExpression_41_Var
		 = (LogicalAndExpression)Expr_40_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = LogicalAndExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final InclusiveOrExpression InclusiveOrExpression_42_Var
		 = (InclusiveOrExpression)Expr_41_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = InclusiveOrExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final ExclusiveOrExpression ExclusiveOrExpression_43_Var
		 = (ExclusiveOrExpression)Expr_42_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = ExclusiveOrExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final AndExpression AndExpression_44_Var
		 = (AndExpression)Expr_43_list.get(0);
		Assert.assertNotNull(AndExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = AndExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final EqualityExpression EqualityExpression_45_Var
		 = (EqualityExpression)Expr_44_list.get(0);
		Assert.assertNotNull(EqualityExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = EqualityExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final RelationalExpression RelationalExpression_46_Var
		 = (RelationalExpression)Expr_45_list.get(0);
		Assert.assertNotNull(RelationalExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = RelationalExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final ShiftExpression ShiftExpression_47_Var
		 = (ShiftExpression)Expr_46_list.get(0);
		Assert.assertNotNull(ShiftExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = ShiftExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final AdditiveExpression AdditiveExpression_48_Var
		 = (AdditiveExpression)Expr_47_list.get(0);
		Assert.assertNotNull(AdditiveExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = AdditiveExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final MultiplicativeExpression MultiplicativeExpression_49_Var
		 = (MultiplicativeExpression)Expr_48_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = MultiplicativeExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final CastExpression CastExpression_50_Var
		 = (CastExpression)Expr_49_list.get(0);
		Assert.assertNotNull(CastExpression_50_Var
		);
		//50
		final UnaryExpression UnaryExpression_51_Var
		 = (UnaryExpression)CastExpression_50_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_51_Var
		);
		//51
		final PostfixExpression PostfixExpression_52_Var
		 = (PostfixExpression)UnaryExpression_51_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = PostfixExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final PrimaryExpression PrimaryExpression_53_Var
		 = (PrimaryExpression)Expr_52_list.get(0);
		Assert.assertNotNull(PrimaryExpression_53_Var
		);
		//53
		final Constant2 Constant2_54_Var
		 = (Constant2)PrimaryExpression_53_Var
		.getConst();
		Assert.assertNotNull(Constant2_54_Var
		);
		Assert.assertEquals("\"will never be reached\\n\"", Constant2_54_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_18_Var
		.getSemi());
		//54
		final Statement Statement_55_Var
		 = (Statement)Statement_11_list.get(2);
		Assert.assertNotNull(Statement_55_Var
		);
		//55
		final LabeledStatement LabeledStatement_56_Var
		 = (LabeledStatement)Statement_55_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_56_Var
		);
		Assert.assertEquals("target", LabeledStatement_56_Var
		.getId());
		//56
		final Statement Statement_57_Var
		 = (Statement)LabeledStatement_56_Var
		.getLStmt();
		Assert.assertNotNull(Statement_57_Var
		);
		//57
		final ExpressionStatement ExpressionStatement_58_Var
		 = (ExpressionStatement)Statement_57_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_58_Var
		);
		//58
		final Expression Expression_59_Var
		 = (Expression)ExpressionStatement_58_Var
		.getExpression();
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
		Assert.assertEquals("printf", PrimaryExpression_75_Var
		.getId());
		final EList<? extends EObject> Suffix_75_list = PostfixExpression_74_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_75_list);
		Assert.assertEquals(1, Suffix_75_list.size());
		//75
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_76_Var
		 = (PostfixExpressionSuffixArgument)Suffix_75_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_76_Var
		);
		//76
		final ArgumentExpressionList ArgumentExpressionList_77_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_76_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_77_Var
		);
		final EList<? extends EObject> Expr_77_list = ArgumentExpressionList_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final AssignmentExpression AssignmentExpression_78_Var
		 = (AssignmentExpression)Expr_77_list.get(0);
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
		Assert.assertEquals(1, Expr_80_list.size());
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
		Assert.assertEquals("\"reached target\\n\"", Constant2_94_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_58_Var
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


