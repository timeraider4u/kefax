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
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Pointer;
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
public class Test0019_HelloWorld {
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
			"res/Test0019_HelloWorld.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_LINEDIRECTIVE", 
				"RULE_NEWLINE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_KW_CHAR", 
				"RULE_WHITESPACE", 
				"RULE_SKW_STAR", 
				"RULE_SKW_STAR", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
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
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0019_HelloWorld.c");
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
		Assert.assertEquals("main", DirectDeclarator_6_Var
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
		Assert.assertEquals(2, ParameterDeclaration_10_list.size());
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
		Assert.assertEquals("int", TypeSpecifier_13_Var
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
		final ParameterDeclaration ParameterDeclaration_16_Var
		 = (ParameterDeclaration)ParameterDeclaration_10_list.get(1);
		Assert.assertNotNull(ParameterDeclaration_16_Var
		);
		//16
		final DeclarationSpecifiers DeclarationSpecifiers_17_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_16_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_17_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_17_list = DeclarationSpecifiers_17_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_17_list);
		Assert.assertEquals(1, DeclarationSpecifier_17_list.size());
		//17
		final TypeSpecifier TypeSpecifier_18_Var
		 = (TypeSpecifier)DeclarationSpecifier_17_list.get(0);
		Assert.assertNotNull(TypeSpecifier_18_Var
		);
		Assert.assertEquals("char", TypeSpecifier_18_Var
		.getName());
		//18
		final Declarator Declarator_19_Var
		 = (Declarator)ParameterDeclaration_16_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_19_Var
		);
		//19
		final DirectDeclarator DirectDeclarator_20_Var
		 = (DirectDeclarator)Declarator_19_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_20_Var
		);
		Assert.assertEquals("argv", DirectDeclarator_20_Var
		.getId());
		//20
		final Pointer Pointer_21_Var
		 = (Pointer)Declarator_19_Var
		.getPointer();
		Assert.assertNotNull(Pointer_21_Var
		);
		Assert.assertEquals("[*, *]", Pointer_21_Var
		.getStar().toString());
		//21
		final FunctionDefinition FunctionDefinition_22_Var
		 = (FunctionDefinition)ExternalDeclaration_1_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_22_Var
		);
		//22
		final BodyStatement BodyStatement_23_Var
		 = (BodyStatement)FunctionDefinition_22_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_23_Var
		);
		final EList<? extends EObject> BlockList_23_list = BodyStatement_23_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_23_list);
		Assert.assertEquals(1, BlockList_23_list.size());
		//23
		final BlockList BlockList_24_Var
		 = (BlockList)BlockList_23_list.get(0);
		Assert.assertNotNull(BlockList_24_Var
		);
		final EList<? extends EObject> Statement_24_list = BlockList_24_Var
		.getStatement();
		Assert.assertNotNull(Statement_24_list);
		Assert.assertEquals(2, Statement_24_list.size());
		//24
		final Statement Statement_25_Var
		 = (Statement)Statement_24_list.get(0);
		Assert.assertNotNull(Statement_25_Var
		);
		//25
		final ExpressionStatement ExpressionStatement_26_Var
		 = (ExpressionStatement)Statement_25_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_26_Var
		);
		//26
		final Expression Expression_27_Var
		 = (Expression)ExpressionStatement_26_Var
		.getExpression();
		Assert.assertNotNull(Expression_27_Var
		);
		final EList<? extends EObject> ExprExpr_27_list = Expression_27_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_27_list);
		Assert.assertEquals(1, ExprExpr_27_list.size());
		//27
		final AssignmentExpression AssignmentExpression_28_Var
		 = (AssignmentExpression)ExprExpr_27_list.get(0);
		Assert.assertNotNull(AssignmentExpression_28_Var
		);
		//28
		final ConditionalExpression ConditionalExpression_29_Var
		 = (ConditionalExpression)AssignmentExpression_28_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_29_Var
		);
		//29
		final LogicalOrExpression LogicalOrExpression_30_Var
		 = (LogicalOrExpression)ConditionalExpression_29_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = LogicalOrExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final LogicalAndExpression LogicalAndExpression_31_Var
		 = (LogicalAndExpression)Expr_30_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = LogicalAndExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final InclusiveOrExpression InclusiveOrExpression_32_Var
		 = (InclusiveOrExpression)Expr_31_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = InclusiveOrExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final ExclusiveOrExpression ExclusiveOrExpression_33_Var
		 = (ExclusiveOrExpression)Expr_32_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = ExclusiveOrExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final AndExpression AndExpression_34_Var
		 = (AndExpression)Expr_33_list.get(0);
		Assert.assertNotNull(AndExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = AndExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final EqualityExpression EqualityExpression_35_Var
		 = (EqualityExpression)Expr_34_list.get(0);
		Assert.assertNotNull(EqualityExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = EqualityExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final RelationalExpression RelationalExpression_36_Var
		 = (RelationalExpression)Expr_35_list.get(0);
		Assert.assertNotNull(RelationalExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = RelationalExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final ShiftExpression ShiftExpression_37_Var
		 = (ShiftExpression)Expr_36_list.get(0);
		Assert.assertNotNull(ShiftExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = ShiftExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final AdditiveExpression AdditiveExpression_38_Var
		 = (AdditiveExpression)Expr_37_list.get(0);
		Assert.assertNotNull(AdditiveExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = AdditiveExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final MultiplicativeExpression MultiplicativeExpression_39_Var
		 = (MultiplicativeExpression)Expr_38_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = MultiplicativeExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final CastExpression CastExpression_40_Var
		 = (CastExpression)Expr_39_list.get(0);
		Assert.assertNotNull(CastExpression_40_Var
		);
		//40
		final UnaryExpression UnaryExpression_41_Var
		 = (UnaryExpression)CastExpression_40_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_41_Var
		);
		//41
		final PostfixExpression PostfixExpression_42_Var
		 = (PostfixExpression)UnaryExpression_41_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = PostfixExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final PrimaryExpression PrimaryExpression_43_Var
		 = (PrimaryExpression)Expr_42_list.get(0);
		Assert.assertNotNull(PrimaryExpression_43_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_43_Var
		.getId());
		final EList<? extends EObject> Suffix_43_list = PostfixExpression_42_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_43_list);
		Assert.assertEquals(1, Suffix_43_list.size());
		//43
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_44_Var
		 = (PostfixExpressionSuffixArgument)Suffix_43_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_44_Var
		);
		//44
		final ArgumentExpressionList ArgumentExpressionList_45_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_44_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_45_Var
		);
		final EList<? extends EObject> Expr_45_list = ArgumentExpressionList_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(2, Expr_45_list.size());
		//45
		final AssignmentExpression AssignmentExpression_46_Var
		 = (AssignmentExpression)Expr_45_list.get(0);
		Assert.assertNotNull(AssignmentExpression_46_Var
		);
		//46
		final ConditionalExpression ConditionalExpression_47_Var
		 = (ConditionalExpression)AssignmentExpression_46_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_47_Var
		);
		//47
		final LogicalOrExpression LogicalOrExpression_48_Var
		 = (LogicalOrExpression)ConditionalExpression_47_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = LogicalOrExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final LogicalAndExpression LogicalAndExpression_49_Var
		 = (LogicalAndExpression)Expr_48_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = LogicalAndExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final InclusiveOrExpression InclusiveOrExpression_50_Var
		 = (InclusiveOrExpression)Expr_49_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = InclusiveOrExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final ExclusiveOrExpression ExclusiveOrExpression_51_Var
		 = (ExclusiveOrExpression)Expr_50_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = ExclusiveOrExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final AndExpression AndExpression_52_Var
		 = (AndExpression)Expr_51_list.get(0);
		Assert.assertNotNull(AndExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = AndExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final EqualityExpression EqualityExpression_53_Var
		 = (EqualityExpression)Expr_52_list.get(0);
		Assert.assertNotNull(EqualityExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = EqualityExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final RelationalExpression RelationalExpression_54_Var
		 = (RelationalExpression)Expr_53_list.get(0);
		Assert.assertNotNull(RelationalExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = RelationalExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final ShiftExpression ShiftExpression_55_Var
		 = (ShiftExpression)Expr_54_list.get(0);
		Assert.assertNotNull(ShiftExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = ShiftExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final AdditiveExpression AdditiveExpression_56_Var
		 = (AdditiveExpression)Expr_55_list.get(0);
		Assert.assertNotNull(AdditiveExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = AdditiveExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final MultiplicativeExpression MultiplicativeExpression_57_Var
		 = (MultiplicativeExpression)Expr_56_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = MultiplicativeExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final CastExpression CastExpression_58_Var
		 = (CastExpression)Expr_57_list.get(0);
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
		Assert.assertEquals("\"%s\\n\"", Constant2_62_Var
		.getStr());
		//62
		final AssignmentExpression AssignmentExpression_63_Var
		 = (AssignmentExpression)Expr_45_list.get(1);
		Assert.assertNotNull(AssignmentExpression_63_Var
		);
		//63
		final ConditionalExpression ConditionalExpression_64_Var
		 = (ConditionalExpression)AssignmentExpression_63_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_64_Var
		);
		//64
		final LogicalOrExpression LogicalOrExpression_65_Var
		 = (LogicalOrExpression)ConditionalExpression_64_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = LogicalOrExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final LogicalAndExpression LogicalAndExpression_66_Var
		 = (LogicalAndExpression)Expr_65_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = LogicalAndExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final InclusiveOrExpression InclusiveOrExpression_67_Var
		 = (InclusiveOrExpression)Expr_66_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = InclusiveOrExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final ExclusiveOrExpression ExclusiveOrExpression_68_Var
		 = (ExclusiveOrExpression)Expr_67_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = ExclusiveOrExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final AndExpression AndExpression_69_Var
		 = (AndExpression)Expr_68_list.get(0);
		Assert.assertNotNull(AndExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = AndExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final EqualityExpression EqualityExpression_70_Var
		 = (EqualityExpression)Expr_69_list.get(0);
		Assert.assertNotNull(EqualityExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = EqualityExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final RelationalExpression RelationalExpression_71_Var
		 = (RelationalExpression)Expr_70_list.get(0);
		Assert.assertNotNull(RelationalExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = RelationalExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final ShiftExpression ShiftExpression_72_Var
		 = (ShiftExpression)Expr_71_list.get(0);
		Assert.assertNotNull(ShiftExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = ShiftExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final AdditiveExpression AdditiveExpression_73_Var
		 = (AdditiveExpression)Expr_72_list.get(0);
		Assert.assertNotNull(AdditiveExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = AdditiveExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final MultiplicativeExpression MultiplicativeExpression_74_Var
		 = (MultiplicativeExpression)Expr_73_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = MultiplicativeExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final CastExpression CastExpression_75_Var
		 = (CastExpression)Expr_74_list.get(0);
		Assert.assertNotNull(CastExpression_75_Var
		);
		//75
		final UnaryExpression UnaryExpression_76_Var
		 = (UnaryExpression)CastExpression_75_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_76_Var
		);
		//76
		final PostfixExpression PostfixExpression_77_Var
		 = (PostfixExpression)UnaryExpression_76_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = PostfixExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final PrimaryExpression PrimaryExpression_78_Var
		 = (PrimaryExpression)Expr_77_list.get(0);
		Assert.assertNotNull(PrimaryExpression_78_Var
		);
		//78
		final Constant2 Constant2_79_Var
		 = (Constant2)PrimaryExpression_78_Var
		.getConst();
		Assert.assertNotNull(Constant2_79_Var
		);
		Assert.assertEquals("\"Hello World!\"", Constant2_79_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_26_Var
		.getSemi());
		//79
		final Statement Statement_80_Var
		 = (Statement)Statement_24_list.get(1);
		Assert.assertNotNull(Statement_80_Var
		);
		//80
		final JumpStatement JumpStatement_81_Var
		 = (JumpStatement)Statement_80_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_81_Var
		);
		//81
		final Expression Expression_82_Var
		 = (Expression)JumpStatement_81_Var
		.getExpr();
		Assert.assertNotNull(Expression_82_Var
		);
		final EList<? extends EObject> ExprExpr_82_list = Expression_82_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_82_list);
		Assert.assertEquals(1, ExprExpr_82_list.size());
		//82
		final AssignmentExpression AssignmentExpression_83_Var
		 = (AssignmentExpression)ExprExpr_82_list.get(0);
		Assert.assertNotNull(AssignmentExpression_83_Var
		);
		//83
		final ConditionalExpression ConditionalExpression_84_Var
		 = (ConditionalExpression)AssignmentExpression_83_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_84_Var
		);
		//84
		final LogicalOrExpression LogicalOrExpression_85_Var
		 = (LogicalOrExpression)ConditionalExpression_84_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = LogicalOrExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final LogicalAndExpression LogicalAndExpression_86_Var
		 = (LogicalAndExpression)Expr_85_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = LogicalAndExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final InclusiveOrExpression InclusiveOrExpression_87_Var
		 = (InclusiveOrExpression)Expr_86_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = InclusiveOrExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final ExclusiveOrExpression ExclusiveOrExpression_88_Var
		 = (ExclusiveOrExpression)Expr_87_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = ExclusiveOrExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final AndExpression AndExpression_89_Var
		 = (AndExpression)Expr_88_list.get(0);
		Assert.assertNotNull(AndExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = AndExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final EqualityExpression EqualityExpression_90_Var
		 = (EqualityExpression)Expr_89_list.get(0);
		Assert.assertNotNull(EqualityExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = EqualityExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final RelationalExpression RelationalExpression_91_Var
		 = (RelationalExpression)Expr_90_list.get(0);
		Assert.assertNotNull(RelationalExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = RelationalExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final ShiftExpression ShiftExpression_92_Var
		 = (ShiftExpression)Expr_91_list.get(0);
		Assert.assertNotNull(ShiftExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = ShiftExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final AdditiveExpression AdditiveExpression_93_Var
		 = (AdditiveExpression)Expr_92_list.get(0);
		Assert.assertNotNull(AdditiveExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = AdditiveExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final MultiplicativeExpression MultiplicativeExpression_94_Var
		 = (MultiplicativeExpression)Expr_93_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = MultiplicativeExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final CastExpression CastExpression_95_Var
		 = (CastExpression)Expr_94_list.get(0);
		Assert.assertNotNull(CastExpression_95_Var
		);
		//95
		final UnaryExpression UnaryExpression_96_Var
		 = (UnaryExpression)CastExpression_95_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_96_Var
		);
		//96
		final PostfixExpression PostfixExpression_97_Var
		 = (PostfixExpression)UnaryExpression_96_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = PostfixExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final PrimaryExpression PrimaryExpression_98_Var
		 = (PrimaryExpression)Expr_97_list.get(0);
		Assert.assertNotNull(PrimaryExpression_98_Var
		);
		//98
		final Constant2 Constant2_99_Var
		 = (Constant2)PrimaryExpression_98_Var
		.getConst();
		Assert.assertNotNull(Constant2_99_Var
		);
		Assert.assertEquals("0", Constant2_99_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_81_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_81_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0019_HelloWorld.c");
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
				method.invoke(this.generator, "Test0019_HelloWorld.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0019_HelloWorld.c");
		final String expected = this.getTextFromFile(
			"res/Test0019_HelloWorld.c"
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


