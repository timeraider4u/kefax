package at.jku.weiner.c.xtexttests;

import com.google.inject.Inject;
import com.google.inject.Provider;

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
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import at.jku.weiner.c.tests.CInjectorProvider;
import at.jku.weiner.c.parser.antlr.CParser;
import at.jku.weiner.c.parser.antlr.internal.InternalCLexer;
import at.jku.weiner.c.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.c.Model;
import at.jku.weiner.c.c.TranslationUnit;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.FunctionDefHead;
import at.jku.weiner.c.c.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.DeclaratorSuffix;
import at.jku.weiner.c.c.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.c.ParameterTypeList;
import at.jku.weiner.c.c.ParameterList;
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.Pointer;
import at.jku.weiner.c.c.FunctionDefinition;
import at.jku.weiner.c.c.BodyStatement;
import at.jku.weiner.c.c.BlockList;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.ArgumentExpressionList;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.JumpStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0019_HelloWorld {
	@Inject
	private ParseHelper<Model> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalCLexer lexer;
	@Inject
	private CParser parser;
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
	
	@Before
	public void initialize(){
		this.testHelper = new LexerAndParserTest(lexer, 
			parser, tokenDefProvider);
	}
	
	private String getTextFromFile(final String fileName)
	throws Exception{
		final Path path = Paths.get(fileName);
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
	private String preprocess(final String string) {
		final String lines = string.replaceAll("\n", " ").trim();
		final String multi = lines.replaceAll("\\s{2,}", " ").trim();
		final String sign = multi.replaceAll("\\s+([^a-zA-Z0-9_])", "$1")
				.trim();
		final String sign2 = sign.replaceAll("([^a-zA-Z0-9_])\\s+", "$1")
				.trim();
	
		// System.out.println(sign2);
		return sign2;
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
				"RULE_LEFTPAREN", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_KW_CHAR", 
				"RULE_WHITESPACE", 
				"RULE_STAR", 
				"RULE_STAR", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_RIGHTBRACE", 
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
		Assert.assertEquals("int", TypeSpecifier_5_Var
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
		Assert.assertEquals("main", DirectDeclarator_7_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_7_list = DirectDeclarator_7_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_7_list);
		Assert.assertEquals(1, DeclaratorSuffix_7_list.size());
		//7
		final DeclaratorSuffix DeclaratorSuffix_8_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_7_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_8_Var
		);
		//8
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_9_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_8_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_9_Var
		);
		final EList<? extends EObject> ParameterTypeList_9_list = DirectDeclaratorLastSuffix_9_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_9_list);
		Assert.assertEquals(1, ParameterTypeList_9_list.size());
		//9
		final ParameterTypeList ParameterTypeList_10_Var
		 = (ParameterTypeList)ParameterTypeList_9_list.get(0);
		Assert.assertNotNull(ParameterTypeList_10_Var
		);
		//10
		final ParameterList ParameterList_11_Var
		 = (ParameterList)ParameterTypeList_10_Var
		.getList();
		Assert.assertNotNull(ParameterList_11_Var
		);
		final EList<? extends EObject> ParameterDeclaration_11_list = ParameterList_11_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_11_list);
		Assert.assertEquals(2, ParameterDeclaration_11_list.size());
		//11
		final ParameterDeclaration ParameterDeclaration_12_Var
		 = (ParameterDeclaration)ParameterDeclaration_11_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_12_Var
		);
		//12
		final DeclarationSpecifiers DeclarationSpecifiers_13_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_12_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_13_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_13_list = DeclarationSpecifiers_13_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_13_list);
		Assert.assertEquals(1, DeclarationSpecifier_13_list.size());
		//13
		final TypeSpecifier TypeSpecifier_14_Var
		 = (TypeSpecifier)DeclarationSpecifier_13_list.get(0);
		Assert.assertNotNull(TypeSpecifier_14_Var
		);
		Assert.assertEquals("int", TypeSpecifier_14_Var
		.getName());
		//14
		final Declarator Declarator_15_Var
		 = (Declarator)ParameterDeclaration_12_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_15_Var
		);
		//15
		final DirectDeclarator DirectDeclarator_16_Var
		 = (DirectDeclarator)Declarator_15_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_16_Var
		);
		Assert.assertEquals("argc", DirectDeclarator_16_Var
		.getId());
		//16
		final ParameterDeclaration ParameterDeclaration_17_Var
		 = (ParameterDeclaration)ParameterDeclaration_11_list.get(1);
		Assert.assertNotNull(ParameterDeclaration_17_Var
		);
		//17
		final DeclarationSpecifiers DeclarationSpecifiers_18_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_17_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_18_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_18_list = DeclarationSpecifiers_18_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_18_list);
		Assert.assertEquals(1, DeclarationSpecifier_18_list.size());
		//18
		final TypeSpecifier TypeSpecifier_19_Var
		 = (TypeSpecifier)DeclarationSpecifier_18_list.get(0);
		Assert.assertNotNull(TypeSpecifier_19_Var
		);
		Assert.assertEquals("char", TypeSpecifier_19_Var
		.getName());
		//19
		final Declarator Declarator_20_Var
		 = (Declarator)ParameterDeclaration_17_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_20_Var
		);
		//20
		final DirectDeclarator DirectDeclarator_21_Var
		 = (DirectDeclarator)Declarator_20_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_21_Var
		);
		Assert.assertEquals("argv", DirectDeclarator_21_Var
		.getId());
		//21
		final Pointer Pointer_22_Var
		 = (Pointer)Declarator_20_Var
		.getPointer();
		Assert.assertNotNull(Pointer_22_Var
		);
		Assert.assertEquals("[*, *]", Pointer_22_Var
		.getStar().toString());
		//22
		final FunctionDefinition FunctionDefinition_23_Var
		 = (FunctionDefinition)ExternalDeclaration_2_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_23_Var
		);
		//23
		final BodyStatement BodyStatement_24_Var
		 = (BodyStatement)FunctionDefinition_23_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_24_Var
		);
		final EList<? extends EObject> BlockList_24_list = BodyStatement_24_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_24_list);
		Assert.assertEquals(1, BlockList_24_list.size());
		//24
		final BlockList BlockList_25_Var
		 = (BlockList)BlockList_24_list.get(0);
		Assert.assertNotNull(BlockList_25_Var
		);
		final EList<? extends EObject> Statement_25_list = BlockList_25_Var
		.getStatement();
		Assert.assertNotNull(Statement_25_list);
		Assert.assertEquals(2, Statement_25_list.size());
		//25
		final Statement Statement_26_Var
		 = (Statement)Statement_25_list.get(0);
		Assert.assertNotNull(Statement_26_Var
		);
		//26
		final ExpressionStatement ExpressionStatement_27_Var
		 = (ExpressionStatement)Statement_26_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_27_Var
		);
		//27
		final Expression Expression_28_Var
		 = (Expression)ExpressionStatement_27_Var
		.getExpression();
		Assert.assertNotNull(Expression_28_Var
		);
		final EList<? extends EObject> ExprExpr_28_list = Expression_28_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_28_list);
		Assert.assertEquals(1, ExprExpr_28_list.size());
		//28
		final AssignmentExpression AssignmentExpression_29_Var
		 = (AssignmentExpression)ExprExpr_28_list.get(0);
		Assert.assertNotNull(AssignmentExpression_29_Var
		);
		//29
		final ConditionalExpression ConditionalExpression_30_Var
		 = (ConditionalExpression)AssignmentExpression_29_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_30_Var
		);
		//30
		final LogicalOrExpression LogicalOrExpression_31_Var
		 = (LogicalOrExpression)ConditionalExpression_30_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = LogicalOrExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final LogicalAndExpression LogicalAndExpression_32_Var
		 = (LogicalAndExpression)Expr_31_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = LogicalAndExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final InclusiveOrExpression InclusiveOrExpression_33_Var
		 = (InclusiveOrExpression)Expr_32_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = InclusiveOrExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final ExclusiveOrExpression ExclusiveOrExpression_34_Var
		 = (ExclusiveOrExpression)Expr_33_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = ExclusiveOrExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final AndExpression AndExpression_35_Var
		 = (AndExpression)Expr_34_list.get(0);
		Assert.assertNotNull(AndExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = AndExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final EqualityExpression EqualityExpression_36_Var
		 = (EqualityExpression)Expr_35_list.get(0);
		Assert.assertNotNull(EqualityExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = EqualityExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final RelationalExpression RelationalExpression_37_Var
		 = (RelationalExpression)Expr_36_list.get(0);
		Assert.assertNotNull(RelationalExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = RelationalExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final ShiftExpression ShiftExpression_38_Var
		 = (ShiftExpression)Expr_37_list.get(0);
		Assert.assertNotNull(ShiftExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = ShiftExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final AdditiveExpression AdditiveExpression_39_Var
		 = (AdditiveExpression)Expr_38_list.get(0);
		Assert.assertNotNull(AdditiveExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = AdditiveExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final MultiplicativeExpression MultiplicativeExpression_40_Var
		 = (MultiplicativeExpression)Expr_39_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = MultiplicativeExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final CastExpression CastExpression_41_Var
		 = (CastExpression)Expr_40_list.get(0);
		Assert.assertNotNull(CastExpression_41_Var
		);
		//41
		final UnaryExpression UnaryExpression_42_Var
		 = (UnaryExpression)CastExpression_41_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_42_Var
		);
		//42
		final PostfixExpression PostfixExpression_43_Var
		 = (PostfixExpression)UnaryExpression_42_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = PostfixExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final PrimaryExpression PrimaryExpression_44_Var
		 = (PrimaryExpression)Expr_43_list.get(0);
		Assert.assertNotNull(PrimaryExpression_44_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_44_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_44_list = PostfixExpression_43_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_44_list);
		Assert.assertEquals(1, ArgumentExpressionList_44_list.size());
		//44
		final ArgumentExpressionList ArgumentExpressionList_45_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_44_list.get(0);
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
		final Constant Constant_62_Var
		 = (Constant)PrimaryExpression_61_Var
		.getConst();
		Assert.assertNotNull(Constant_62_Var
		);
		Assert.assertEquals("\"%s\\n\"", Constant_62_Var
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
		final Constant Constant_79_Var
		 = (Constant)PrimaryExpression_78_Var
		.getConst();
		Assert.assertNotNull(Constant_79_Var
		);
		Assert.assertEquals("\"Hello World!\"", Constant_79_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_27_Var
		.getSemi());
		//79
		final Statement Statement_80_Var
		 = (Statement)Statement_25_list.get(1);
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
		final Constant Constant_99_Var
		 = (Constant)PrimaryExpression_98_Var
		.getConst();
		Assert.assertNotNull(Constant_99_Var
		);
		Assert.assertEquals("0", Constant_99_Var
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
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/greetings.txt");
		final String expected = this.getTextFromFile(
			"res/Test0019_HelloWorld.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
		// System.out.println("Code generation finished.");
	}
	
}


