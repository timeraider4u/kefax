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
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.StorageClassSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
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
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0075_LocalLabel {
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
			"res/Test0075_LocalLabel.c");
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
				"RULE_KW_LABEL3",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
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
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0075_LocalLabel.c");
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
		final EList<? extends EObject> Declaration_9_list = BlockList_9_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_9_list);
		Assert.assertEquals(1, Declaration_9_list.size());
		//9
		final Declaration Declaration_10_Var
		 = (Declaration)Declaration_9_list.get(0);
		Assert.assertNotNull(Declaration_10_Var
		);
		//10
		final DeclarationSpecifiers DeclarationSpecifiers_11_Var
		 = (DeclarationSpecifiers)Declaration_10_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_11_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_11_list = DeclarationSpecifiers_11_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_11_list);
		Assert.assertEquals(1, DeclarationSpecifier_11_list.size());
		//11
		final StorageClassSpecifier StorageClassSpecifier_12_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_11_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_12_Var
		);
		Assert.assertEquals("__label__", StorageClassSpecifier_12_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_12_list = Declaration_10_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_12_list);
		Assert.assertEquals(1, InitDeclaratorList_12_list.size());
		//12
		final InitDeclaratorList InitDeclaratorList_13_Var
		 = (InitDeclaratorList)InitDeclaratorList_12_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_13_Var
		);
		final EList<? extends EObject> InitDeclarator_13_list = InitDeclaratorList_13_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_13_list);
		Assert.assertEquals(1, InitDeclarator_13_list.size());
		//13
		final InitDeclarator InitDeclarator_14_Var
		 = (InitDeclarator)InitDeclarator_13_list.get(0);
		Assert.assertNotNull(InitDeclarator_14_Var
		);
		//14
		final Declarator Declarator_15_Var
		 = (Declarator)InitDeclarator_14_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_15_Var
		);
		//15
		final DirectDeclarator DirectDeclarator_16_Var
		 = (DirectDeclarator)Declarator_15_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_16_Var
		);
		Assert.assertEquals("target", DirectDeclarator_16_Var
		.getId());
		final EList<? extends EObject> Statement_16_list = BlockList_9_Var
		.getStatement();
		Assert.assertNotNull(Statement_16_list);
		Assert.assertEquals(3, Statement_16_list.size());
		//16
		final Statement Statement_17_Var
		 = (Statement)Statement_16_list.get(0);
		Assert.assertNotNull(Statement_17_Var
		);
		//17
		final JumpStatement JumpStatement_18_Var
		 = (JumpStatement)Statement_17_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_18_Var
		);
		//18
		final UnaryExpression UnaryExpression_19_Var
		 = (UnaryExpression)JumpStatement_18_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_19_Var
		);
		//19
		final PostfixExpression PostfixExpression_20_Var
		 = (PostfixExpression)UnaryExpression_19_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = PostfixExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final PrimaryExpression PrimaryExpression_21_Var
		 = (PrimaryExpression)Expr_20_list.get(0);
		Assert.assertNotNull(PrimaryExpression_21_Var
		);
		Assert.assertEquals("target", PrimaryExpression_21_Var
		.getId());
		Assert.assertEquals("goto", JumpStatement_18_Var
		.getGoto());
		//21
		final Statement Statement_22_Var
		 = (Statement)Statement_16_list.get(1);
		Assert.assertNotNull(Statement_22_Var
		);
		//22
		final ExpressionStatement ExpressionStatement_23_Var
		 = (ExpressionStatement)Statement_22_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_23_Var
		);
		//23
		final Expression Expression_24_Var
		 = (Expression)ExpressionStatement_23_Var
		.getExpression();
		Assert.assertNotNull(Expression_24_Var
		);
		final EList<? extends EObject> ExprExpr_24_list = Expression_24_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_24_list);
		Assert.assertEquals(1, ExprExpr_24_list.size());
		//24
		final AssignmentExpression AssignmentExpression_25_Var
		 = (AssignmentExpression)ExprExpr_24_list.get(0);
		Assert.assertNotNull(AssignmentExpression_25_Var
		);
		//25
		final ConditionalExpression ConditionalExpression_26_Var
		 = (ConditionalExpression)AssignmentExpression_25_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_26_Var
		);
		//26
		final LogicalOrExpression LogicalOrExpression_27_Var
		 = (LogicalOrExpression)ConditionalExpression_26_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = LogicalOrExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final LogicalAndExpression LogicalAndExpression_28_Var
		 = (LogicalAndExpression)Expr_27_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = LogicalAndExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final InclusiveOrExpression InclusiveOrExpression_29_Var
		 = (InclusiveOrExpression)Expr_28_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = InclusiveOrExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final ExclusiveOrExpression ExclusiveOrExpression_30_Var
		 = (ExclusiveOrExpression)Expr_29_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = ExclusiveOrExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final AndExpression AndExpression_31_Var
		 = (AndExpression)Expr_30_list.get(0);
		Assert.assertNotNull(AndExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = AndExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final EqualityExpression EqualityExpression_32_Var
		 = (EqualityExpression)Expr_31_list.get(0);
		Assert.assertNotNull(EqualityExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = EqualityExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final RelationalExpression RelationalExpression_33_Var
		 = (RelationalExpression)Expr_32_list.get(0);
		Assert.assertNotNull(RelationalExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = RelationalExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final ShiftExpression ShiftExpression_34_Var
		 = (ShiftExpression)Expr_33_list.get(0);
		Assert.assertNotNull(ShiftExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = ShiftExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final AdditiveExpression AdditiveExpression_35_Var
		 = (AdditiveExpression)Expr_34_list.get(0);
		Assert.assertNotNull(AdditiveExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = AdditiveExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final MultiplicativeExpression MultiplicativeExpression_36_Var
		 = (MultiplicativeExpression)Expr_35_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = MultiplicativeExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final CastExpression CastExpression_37_Var
		 = (CastExpression)Expr_36_list.get(0);
		Assert.assertNotNull(CastExpression_37_Var
		);
		//37
		final UnaryExpression UnaryExpression_38_Var
		 = (UnaryExpression)CastExpression_37_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_38_Var
		);
		//38
		final PostfixExpression PostfixExpression_39_Var
		 = (PostfixExpression)UnaryExpression_38_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = PostfixExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final PrimaryExpression PrimaryExpression_40_Var
		 = (PrimaryExpression)Expr_39_list.get(0);
		Assert.assertNotNull(PrimaryExpression_40_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_40_Var
		.getId());
		final EList<? extends EObject> Suffix_40_list = PostfixExpression_39_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_40_list);
		Assert.assertEquals(1, Suffix_40_list.size());
		//40
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_41_Var
		 = (PostfixExpressionSuffixArgument)Suffix_40_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_41_Var
		);
		//41
		final ArgumentExpressionList ArgumentExpressionList_42_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_41_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_42_Var
		);
		final EList<? extends EObject> Expr_42_list = ArgumentExpressionList_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final AssignmentExpression AssignmentExpression_43_Var
		 = (AssignmentExpression)Expr_42_list.get(0);
		Assert.assertNotNull(AssignmentExpression_43_Var
		);
		//43
		final ConditionalExpression ConditionalExpression_44_Var
		 = (ConditionalExpression)AssignmentExpression_43_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_44_Var
		);
		//44
		final LogicalOrExpression LogicalOrExpression_45_Var
		 = (LogicalOrExpression)ConditionalExpression_44_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = LogicalOrExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final LogicalAndExpression LogicalAndExpression_46_Var
		 = (LogicalAndExpression)Expr_45_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = LogicalAndExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final InclusiveOrExpression InclusiveOrExpression_47_Var
		 = (InclusiveOrExpression)Expr_46_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = InclusiveOrExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final ExclusiveOrExpression ExclusiveOrExpression_48_Var
		 = (ExclusiveOrExpression)Expr_47_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = ExclusiveOrExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final AndExpression AndExpression_49_Var
		 = (AndExpression)Expr_48_list.get(0);
		Assert.assertNotNull(AndExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = AndExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final EqualityExpression EqualityExpression_50_Var
		 = (EqualityExpression)Expr_49_list.get(0);
		Assert.assertNotNull(EqualityExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = EqualityExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final RelationalExpression RelationalExpression_51_Var
		 = (RelationalExpression)Expr_50_list.get(0);
		Assert.assertNotNull(RelationalExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = RelationalExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final ShiftExpression ShiftExpression_52_Var
		 = (ShiftExpression)Expr_51_list.get(0);
		Assert.assertNotNull(ShiftExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = ShiftExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final AdditiveExpression AdditiveExpression_53_Var
		 = (AdditiveExpression)Expr_52_list.get(0);
		Assert.assertNotNull(AdditiveExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = AdditiveExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final MultiplicativeExpression MultiplicativeExpression_54_Var
		 = (MultiplicativeExpression)Expr_53_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = MultiplicativeExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final CastExpression CastExpression_55_Var
		 = (CastExpression)Expr_54_list.get(0);
		Assert.assertNotNull(CastExpression_55_Var
		);
		//55
		final UnaryExpression UnaryExpression_56_Var
		 = (UnaryExpression)CastExpression_55_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_56_Var
		);
		//56
		final PostfixExpression PostfixExpression_57_Var
		 = (PostfixExpression)UnaryExpression_56_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = PostfixExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final PrimaryExpression PrimaryExpression_58_Var
		 = (PrimaryExpression)Expr_57_list.get(0);
		Assert.assertNotNull(PrimaryExpression_58_Var
		);
		Assert.assertEquals("[\"will never be reached\\n\"]", PrimaryExpression_58_Var
		.getString().toString());
		//58
		final Statement Statement_59_Var
		 = (Statement)Statement_16_list.get(2);
		Assert.assertNotNull(Statement_59_Var
		);
		//59
		final LabeledStatement LabeledStatement_60_Var
		 = (LabeledStatement)Statement_59_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_60_Var
		);
		Assert.assertEquals("target", LabeledStatement_60_Var
		.getId());
		//60
		final Statement Statement_61_Var
		 = (Statement)LabeledStatement_60_Var
		.getLStmt();
		Assert.assertNotNull(Statement_61_Var
		);
		//61
		final ExpressionStatement ExpressionStatement_62_Var
		 = (ExpressionStatement)Statement_61_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_62_Var
		);
		//62
		final Expression Expression_63_Var
		 = (Expression)ExpressionStatement_62_Var
		.getExpression();
		Assert.assertNotNull(Expression_63_Var
		);
		final EList<? extends EObject> ExprExpr_63_list = Expression_63_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_63_list);
		Assert.assertEquals(1, ExprExpr_63_list.size());
		//63
		final AssignmentExpression AssignmentExpression_64_Var
		 = (AssignmentExpression)ExprExpr_63_list.get(0);
		Assert.assertNotNull(AssignmentExpression_64_Var
		);
		//64
		final ConditionalExpression ConditionalExpression_65_Var
		 = (ConditionalExpression)AssignmentExpression_64_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_65_Var
		);
		//65
		final LogicalOrExpression LogicalOrExpression_66_Var
		 = (LogicalOrExpression)ConditionalExpression_65_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = LogicalOrExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final LogicalAndExpression LogicalAndExpression_67_Var
		 = (LogicalAndExpression)Expr_66_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = LogicalAndExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final InclusiveOrExpression InclusiveOrExpression_68_Var
		 = (InclusiveOrExpression)Expr_67_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = InclusiveOrExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final ExclusiveOrExpression ExclusiveOrExpression_69_Var
		 = (ExclusiveOrExpression)Expr_68_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = ExclusiveOrExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final AndExpression AndExpression_70_Var
		 = (AndExpression)Expr_69_list.get(0);
		Assert.assertNotNull(AndExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = AndExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final EqualityExpression EqualityExpression_71_Var
		 = (EqualityExpression)Expr_70_list.get(0);
		Assert.assertNotNull(EqualityExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = EqualityExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final RelationalExpression RelationalExpression_72_Var
		 = (RelationalExpression)Expr_71_list.get(0);
		Assert.assertNotNull(RelationalExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = RelationalExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final ShiftExpression ShiftExpression_73_Var
		 = (ShiftExpression)Expr_72_list.get(0);
		Assert.assertNotNull(ShiftExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = ShiftExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final AdditiveExpression AdditiveExpression_74_Var
		 = (AdditiveExpression)Expr_73_list.get(0);
		Assert.assertNotNull(AdditiveExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = AdditiveExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final MultiplicativeExpression MultiplicativeExpression_75_Var
		 = (MultiplicativeExpression)Expr_74_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = MultiplicativeExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final CastExpression CastExpression_76_Var
		 = (CastExpression)Expr_75_list.get(0);
		Assert.assertNotNull(CastExpression_76_Var
		);
		//76
		final UnaryExpression UnaryExpression_77_Var
		 = (UnaryExpression)CastExpression_76_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_77_Var
		);
		//77
		final PostfixExpression PostfixExpression_78_Var
		 = (PostfixExpression)UnaryExpression_77_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = PostfixExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final PrimaryExpression PrimaryExpression_79_Var
		 = (PrimaryExpression)Expr_78_list.get(0);
		Assert.assertNotNull(PrimaryExpression_79_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_79_Var
		.getId());
		final EList<? extends EObject> Suffix_79_list = PostfixExpression_78_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_79_list);
		Assert.assertEquals(1, Suffix_79_list.size());
		//79
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_80_Var
		 = (PostfixExpressionSuffixArgument)Suffix_79_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_80_Var
		);
		//80
		final ArgumentExpressionList ArgumentExpressionList_81_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_80_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_81_Var
		);
		final EList<? extends EObject> Expr_81_list = ArgumentExpressionList_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final AssignmentExpression AssignmentExpression_82_Var
		 = (AssignmentExpression)Expr_81_list.get(0);
		Assert.assertNotNull(AssignmentExpression_82_Var
		);
		//82
		final ConditionalExpression ConditionalExpression_83_Var
		 = (ConditionalExpression)AssignmentExpression_82_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_83_Var
		);
		//83
		final LogicalOrExpression LogicalOrExpression_84_Var
		 = (LogicalOrExpression)ConditionalExpression_83_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = LogicalOrExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final LogicalAndExpression LogicalAndExpression_85_Var
		 = (LogicalAndExpression)Expr_84_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = LogicalAndExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final InclusiveOrExpression InclusiveOrExpression_86_Var
		 = (InclusiveOrExpression)Expr_85_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = InclusiveOrExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final ExclusiveOrExpression ExclusiveOrExpression_87_Var
		 = (ExclusiveOrExpression)Expr_86_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = ExclusiveOrExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final AndExpression AndExpression_88_Var
		 = (AndExpression)Expr_87_list.get(0);
		Assert.assertNotNull(AndExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = AndExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final EqualityExpression EqualityExpression_89_Var
		 = (EqualityExpression)Expr_88_list.get(0);
		Assert.assertNotNull(EqualityExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = EqualityExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final RelationalExpression RelationalExpression_90_Var
		 = (RelationalExpression)Expr_89_list.get(0);
		Assert.assertNotNull(RelationalExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = RelationalExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final ShiftExpression ShiftExpression_91_Var
		 = (ShiftExpression)Expr_90_list.get(0);
		Assert.assertNotNull(ShiftExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = ShiftExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final AdditiveExpression AdditiveExpression_92_Var
		 = (AdditiveExpression)Expr_91_list.get(0);
		Assert.assertNotNull(AdditiveExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = AdditiveExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final MultiplicativeExpression MultiplicativeExpression_93_Var
		 = (MultiplicativeExpression)Expr_92_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = MultiplicativeExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final CastExpression CastExpression_94_Var
		 = (CastExpression)Expr_93_list.get(0);
		Assert.assertNotNull(CastExpression_94_Var
		);
		//94
		final UnaryExpression UnaryExpression_95_Var
		 = (UnaryExpression)CastExpression_94_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_95_Var
		);
		//95
		final PostfixExpression PostfixExpression_96_Var
		 = (PostfixExpression)UnaryExpression_95_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = PostfixExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final PrimaryExpression PrimaryExpression_97_Var
		 = (PrimaryExpression)Expr_96_list.get(0);
		Assert.assertNotNull(PrimaryExpression_97_Var
		);
		Assert.assertEquals("[\"reached target\\n\"]", PrimaryExpression_97_Var
		.getString().toString());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0075_LocalLabel.c");
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
				method.invoke(this.generator, "Test0075_LocalLabel.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0075_LocalLabel.c");
		final String expected = this.getTextFromFile(
			"res/Test0075_LocalLabel.c"
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


