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
import at.jku.weiner.c.c.Pointer;
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.Pointer;
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
import at.jku.weiner.c.c.FunctionDefinition;
import at.jku.weiner.c.c.BodyStatement;
import at.jku.weiner.c.c.BlockList;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
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
import at.jku.weiner.c.c.AssignmentOperator;
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
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0018_PointerInFunctionDef {
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
			"res/Test0018_PointerInFunctionDef.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_VOID", 
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
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_KW_FLOAT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_LEFTPAREN", 
				"RULE_ID", 
				"RULE_LEFTBRACKET", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_RIGHTBRACKET", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTBRACKET", 
				"RULE_ID", 
				"RULE_RIGHTBRACKET", 
				"RULE_WHITESPACE", 
				"RULE_PLUS", 
				"RULE_WHITESPACE", 
				"RULE_BIN_LITERAL", 
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
			"res/Test0018_PointerInFunctionDef.c");
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
		Assert.assertEquals("do1", DirectDeclarator_7_Var
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
		Assert.assertEquals(4, ParameterDeclaration_11_list.size());
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
		final Pointer Pointer_17_Var
		 = (Pointer)Declarator_15_Var
		.getPointer();
		Assert.assertNotNull(Pointer_17_Var
		);
		Assert.assertEquals("[]", Pointer_17_Var
		.getStar().toString());
		//17
		final ParameterDeclaration ParameterDeclaration_18_Var
		 = (ParameterDeclaration)ParameterDeclaration_11_list.get(1);
		Assert.assertNotNull(ParameterDeclaration_18_Var
		);
		//18
		final DeclarationSpecifiers DeclarationSpecifiers_19_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_18_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_19_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_19_list = DeclarationSpecifiers_19_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_19_list);
		Assert.assertEquals(1, DeclarationSpecifier_19_list.size());
		//19
		final TypeSpecifier TypeSpecifier_20_Var
		 = (TypeSpecifier)DeclarationSpecifier_19_list.get(0);
		Assert.assertNotNull(TypeSpecifier_20_Var
		);
		Assert.assertEquals("char", TypeSpecifier_20_Var
		.getName());
		//20
		final Declarator Declarator_21_Var
		 = (Declarator)ParameterDeclaration_18_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_21_Var
		);
		//21
		final DirectDeclarator DirectDeclarator_22_Var
		 = (DirectDeclarator)Declarator_21_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_22_Var
		);
		Assert.assertEquals("argv", DirectDeclarator_22_Var
		.getId());
		//22
		final Pointer Pointer_23_Var
		 = (Pointer)Declarator_21_Var
		.getPointer();
		Assert.assertNotNull(Pointer_23_Var
		);
		Assert.assertEquals("[*, *]", Pointer_23_Var
		.getStar().toString());
		//23
		final ParameterDeclaration ParameterDeclaration_24_Var
		 = (ParameterDeclaration)ParameterDeclaration_11_list.get(2);
		Assert.assertNotNull(ParameterDeclaration_24_Var
		);
		//24
		final DeclarationSpecifiers DeclarationSpecifiers_25_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_24_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_25_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_25_list = DeclarationSpecifiers_25_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_25_list);
		Assert.assertEquals(1, DeclarationSpecifier_25_list.size());
		//25
		final TypeSpecifier TypeSpecifier_26_Var
		 = (TypeSpecifier)DeclarationSpecifier_25_list.get(0);
		Assert.assertNotNull(TypeSpecifier_26_Var
		);
		Assert.assertEquals("float", TypeSpecifier_26_Var
		.getName());
		//26
		final Declarator Declarator_27_Var
		 = (Declarator)ParameterDeclaration_24_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_27_Var
		);
		//27
		final DirectDeclarator DirectDeclarator_28_Var
		 = (DirectDeclarator)Declarator_27_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_28_Var
		);
		Assert.assertEquals("f", DirectDeclarator_28_Var
		.getId());
		//28
		final ParameterDeclaration ParameterDeclaration_29_Var
		 = (ParameterDeclaration)ParameterDeclaration_11_list.get(3);
		Assert.assertNotNull(ParameterDeclaration_29_Var
		);
		//29
		final DeclarationSpecifiers DeclarationSpecifiers_30_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_29_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_30_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_30_list = DeclarationSpecifiers_30_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_30_list);
		Assert.assertEquals(1, DeclarationSpecifier_30_list.size());
		//30
		final TypeSpecifier TypeSpecifier_31_Var
		 = (TypeSpecifier)DeclarationSpecifier_30_list.get(0);
		Assert.assertNotNull(TypeSpecifier_31_Var
		);
		Assert.assertEquals("int", TypeSpecifier_31_Var
		.getName());
		//31
		final Declarator Declarator_32_Var
		 = (Declarator)ParameterDeclaration_29_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_32_Var
		);
		//32
		final DirectDeclarator DirectDeclarator_33_Var
		 = (DirectDeclarator)Declarator_32_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_33_Var
		);
		Assert.assertEquals("i", DirectDeclarator_33_Var
		.getId());
		//33
		final FunctionDefinition FunctionDefinition_34_Var
		 = (FunctionDefinition)ExternalDeclaration_2_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_34_Var
		);
		//34
		final BodyStatement BodyStatement_35_Var
		 = (BodyStatement)FunctionDefinition_34_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_35_Var
		);
		final EList<? extends EObject> BlockList_35_list = BodyStatement_35_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_35_list);
		Assert.assertEquals(1, BlockList_35_list.size());
		//35
		final BlockList BlockList_36_Var
		 = (BlockList)BlockList_35_list.get(0);
		Assert.assertNotNull(BlockList_36_Var
		);
		final EList<? extends EObject> Statement_36_list = BlockList_36_Var
		.getStatement();
		Assert.assertNotNull(Statement_36_list);
		Assert.assertEquals(1, Statement_36_list.size());
		//36
		final Statement Statement_37_Var
		 = (Statement)Statement_36_list.get(0);
		Assert.assertNotNull(Statement_37_Var
		);
		//37
		final ExpressionStatement ExpressionStatement_38_Var
		 = (ExpressionStatement)Statement_37_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_38_Var
		);
		//38
		final Expression Expression_39_Var
		 = (Expression)ExpressionStatement_38_Var
		.getExpression();
		Assert.assertNotNull(Expression_39_Var
		);
		final EList<? extends EObject> ExprExpr_39_list = Expression_39_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_39_list);
		Assert.assertEquals(1, ExprExpr_39_list.size());
		//39
		final AssignmentExpression AssignmentExpression_40_Var
		 = (AssignmentExpression)ExprExpr_39_list.get(0);
		Assert.assertNotNull(AssignmentExpression_40_Var
		);
		//40
		final UnaryExpression UnaryExpression_41_Var
		 = (UnaryExpression)AssignmentExpression_40_Var
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
		//43
		final Expression Expression_44_Var
		 = (Expression)PrimaryExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expression_44_Var
		);
		final EList<? extends EObject> ExprExpr_44_list = Expression_44_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_44_list);
		Assert.assertEquals(1, ExprExpr_44_list.size());
		//44
		final AssignmentExpression AssignmentExpression_45_Var
		 = (AssignmentExpression)ExprExpr_44_list.get(0);
		Assert.assertNotNull(AssignmentExpression_45_Var
		);
		//45
		final ConditionalExpression ConditionalExpression_46_Var
		 = (ConditionalExpression)AssignmentExpression_45_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_46_Var
		);
		//46
		final LogicalOrExpression LogicalOrExpression_47_Var
		 = (LogicalOrExpression)ConditionalExpression_46_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = LogicalOrExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final LogicalAndExpression LogicalAndExpression_48_Var
		 = (LogicalAndExpression)Expr_47_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = LogicalAndExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final InclusiveOrExpression InclusiveOrExpression_49_Var
		 = (InclusiveOrExpression)Expr_48_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = InclusiveOrExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final ExclusiveOrExpression ExclusiveOrExpression_50_Var
		 = (ExclusiveOrExpression)Expr_49_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = ExclusiveOrExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final AndExpression AndExpression_51_Var
		 = (AndExpression)Expr_50_list.get(0);
		Assert.assertNotNull(AndExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = AndExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final EqualityExpression EqualityExpression_52_Var
		 = (EqualityExpression)Expr_51_list.get(0);
		Assert.assertNotNull(EqualityExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = EqualityExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final RelationalExpression RelationalExpression_53_Var
		 = (RelationalExpression)Expr_52_list.get(0);
		Assert.assertNotNull(RelationalExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = RelationalExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final ShiftExpression ShiftExpression_54_Var
		 = (ShiftExpression)Expr_53_list.get(0);
		Assert.assertNotNull(ShiftExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = ShiftExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final AdditiveExpression AdditiveExpression_55_Var
		 = (AdditiveExpression)Expr_54_list.get(0);
		Assert.assertNotNull(AdditiveExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = AdditiveExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final MultiplicativeExpression MultiplicativeExpression_56_Var
		 = (MultiplicativeExpression)Expr_55_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = MultiplicativeExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final CastExpression CastExpression_57_Var
		 = (CastExpression)Expr_56_list.get(0);
		Assert.assertNotNull(CastExpression_57_Var
		);
		//57
		final UnaryExpression UnaryExpression_58_Var
		 = (UnaryExpression)CastExpression_57_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_58_Var
		);
		//58
		final PostfixExpression PostfixExpression_59_Var
		 = (PostfixExpression)UnaryExpression_58_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = PostfixExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final PrimaryExpression PrimaryExpression_60_Var
		 = (PrimaryExpression)Expr_59_list.get(0);
		Assert.assertNotNull(PrimaryExpression_60_Var
		);
		Assert.assertEquals("argv", PrimaryExpression_60_Var
		.getId());
		final EList<? extends EObject> ArrayExpr_60_list = PostfixExpression_59_Var
		.getArrayExpr();
		Assert.assertNotNull(ArrayExpr_60_list);
		Assert.assertEquals(1, ArrayExpr_60_list.size());
		//60
		final Expression Expression_61_Var
		 = (Expression)ArrayExpr_60_list.get(0);
		Assert.assertNotNull(Expression_61_Var
		);
		final EList<? extends EObject> ExprExpr_61_list = Expression_61_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_61_list);
		Assert.assertEquals(1, ExprExpr_61_list.size());
		//61
		final AssignmentExpression AssignmentExpression_62_Var
		 = (AssignmentExpression)ExprExpr_61_list.get(0);
		Assert.assertNotNull(AssignmentExpression_62_Var
		);
		//62
		final ConditionalExpression ConditionalExpression_63_Var
		 = (ConditionalExpression)AssignmentExpression_62_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_63_Var
		);
		//63
		final LogicalOrExpression LogicalOrExpression_64_Var
		 = (LogicalOrExpression)ConditionalExpression_63_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = LogicalOrExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final LogicalAndExpression LogicalAndExpression_65_Var
		 = (LogicalAndExpression)Expr_64_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = LogicalAndExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final InclusiveOrExpression InclusiveOrExpression_66_Var
		 = (InclusiveOrExpression)Expr_65_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = InclusiveOrExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final ExclusiveOrExpression ExclusiveOrExpression_67_Var
		 = (ExclusiveOrExpression)Expr_66_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = ExclusiveOrExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final AndExpression AndExpression_68_Var
		 = (AndExpression)Expr_67_list.get(0);
		Assert.assertNotNull(AndExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = AndExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final EqualityExpression EqualityExpression_69_Var
		 = (EqualityExpression)Expr_68_list.get(0);
		Assert.assertNotNull(EqualityExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = EqualityExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final RelationalExpression RelationalExpression_70_Var
		 = (RelationalExpression)Expr_69_list.get(0);
		Assert.assertNotNull(RelationalExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = RelationalExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final ShiftExpression ShiftExpression_71_Var
		 = (ShiftExpression)Expr_70_list.get(0);
		Assert.assertNotNull(ShiftExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = ShiftExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final AdditiveExpression AdditiveExpression_72_Var
		 = (AdditiveExpression)Expr_71_list.get(0);
		Assert.assertNotNull(AdditiveExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = AdditiveExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final MultiplicativeExpression MultiplicativeExpression_73_Var
		 = (MultiplicativeExpression)Expr_72_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = MultiplicativeExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final CastExpression CastExpression_74_Var
		 = (CastExpression)Expr_73_list.get(0);
		Assert.assertNotNull(CastExpression_74_Var
		);
		//74
		final UnaryExpression UnaryExpression_75_Var
		 = (UnaryExpression)CastExpression_74_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_75_Var
		);
		//75
		final PostfixExpression PostfixExpression_76_Var
		 = (PostfixExpression)UnaryExpression_75_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = PostfixExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final PrimaryExpression PrimaryExpression_77_Var
		 = (PrimaryExpression)Expr_76_list.get(0);
		Assert.assertNotNull(PrimaryExpression_77_Var
		);
		//77
		final Constant Constant_78_Var
		 = (Constant)PrimaryExpression_77_Var
		.getConst();
		Assert.assertNotNull(Constant_78_Var
		);
		Assert.assertEquals("9", Constant_78_Var
		.getDec());
		//78
		final AssignmentOperator AssignmentOperator_79_Var
		 = (AssignmentOperator)AssignmentExpression_40_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_79_Var
		);
		Assert.assertEquals("=", AssignmentOperator_79_Var
		.getOp());
		//79
		final AssignmentExpression AssignmentExpression_80_Var
		 = (AssignmentExpression)AssignmentExpression_40_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_80_Var
		);
		//80
		final ConditionalExpression ConditionalExpression_81_Var
		 = (ConditionalExpression)AssignmentExpression_80_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_81_Var
		);
		//81
		final LogicalOrExpression LogicalOrExpression_82_Var
		 = (LogicalOrExpression)ConditionalExpression_81_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = LogicalOrExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final LogicalAndExpression LogicalAndExpression_83_Var
		 = (LogicalAndExpression)Expr_82_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = LogicalAndExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final InclusiveOrExpression InclusiveOrExpression_84_Var
		 = (InclusiveOrExpression)Expr_83_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = InclusiveOrExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final ExclusiveOrExpression ExclusiveOrExpression_85_Var
		 = (ExclusiveOrExpression)Expr_84_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = ExclusiveOrExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final AndExpression AndExpression_86_Var
		 = (AndExpression)Expr_85_list.get(0);
		Assert.assertNotNull(AndExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = AndExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final EqualityExpression EqualityExpression_87_Var
		 = (EqualityExpression)Expr_86_list.get(0);
		Assert.assertNotNull(EqualityExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = EqualityExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final RelationalExpression RelationalExpression_88_Var
		 = (RelationalExpression)Expr_87_list.get(0);
		Assert.assertNotNull(RelationalExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = RelationalExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final ShiftExpression ShiftExpression_89_Var
		 = (ShiftExpression)Expr_88_list.get(0);
		Assert.assertNotNull(ShiftExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = ShiftExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final AdditiveExpression AdditiveExpression_90_Var
		 = (AdditiveExpression)Expr_89_list.get(0);
		Assert.assertNotNull(AdditiveExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = AdditiveExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(2, Expr_90_list.size());
		//90
		final MultiplicativeExpression MultiplicativeExpression_91_Var
		 = (MultiplicativeExpression)Expr_90_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = MultiplicativeExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final CastExpression CastExpression_92_Var
		 = (CastExpression)Expr_91_list.get(0);
		Assert.assertNotNull(CastExpression_92_Var
		);
		//92
		final UnaryExpression UnaryExpression_93_Var
		 = (UnaryExpression)CastExpression_92_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_93_Var
		);
		//93
		final PostfixExpression PostfixExpression_94_Var
		 = (PostfixExpression)UnaryExpression_93_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = PostfixExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final PrimaryExpression PrimaryExpression_95_Var
		 = (PrimaryExpression)Expr_94_list.get(0);
		Assert.assertNotNull(PrimaryExpression_95_Var
		);
		Assert.assertEquals("argv", PrimaryExpression_95_Var
		.getId());
		final EList<? extends EObject> ArrayExpr_95_list = PostfixExpression_94_Var
		.getArrayExpr();
		Assert.assertNotNull(ArrayExpr_95_list);
		Assert.assertEquals(1, ArrayExpr_95_list.size());
		//95
		final Expression Expression_96_Var
		 = (Expression)ArrayExpr_95_list.get(0);
		Assert.assertNotNull(Expression_96_Var
		);
		final EList<? extends EObject> ExprExpr_96_list = Expression_96_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_96_list);
		Assert.assertEquals(1, ExprExpr_96_list.size());
		//96
		final AssignmentExpression AssignmentExpression_97_Var
		 = (AssignmentExpression)ExprExpr_96_list.get(0);
		Assert.assertNotNull(AssignmentExpression_97_Var
		);
		//97
		final ConditionalExpression ConditionalExpression_98_Var
		 = (ConditionalExpression)AssignmentExpression_97_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_98_Var
		);
		//98
		final LogicalOrExpression LogicalOrExpression_99_Var
		 = (LogicalOrExpression)ConditionalExpression_98_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = LogicalOrExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final LogicalAndExpression LogicalAndExpression_100_Var
		 = (LogicalAndExpression)Expr_99_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = LogicalAndExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final InclusiveOrExpression InclusiveOrExpression_101_Var
		 = (InclusiveOrExpression)Expr_100_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = InclusiveOrExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final ExclusiveOrExpression ExclusiveOrExpression_102_Var
		 = (ExclusiveOrExpression)Expr_101_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = ExclusiveOrExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final AndExpression AndExpression_103_Var
		 = (AndExpression)Expr_102_list.get(0);
		Assert.assertNotNull(AndExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = AndExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final EqualityExpression EqualityExpression_104_Var
		 = (EqualityExpression)Expr_103_list.get(0);
		Assert.assertNotNull(EqualityExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = EqualityExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final RelationalExpression RelationalExpression_105_Var
		 = (RelationalExpression)Expr_104_list.get(0);
		Assert.assertNotNull(RelationalExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = RelationalExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final ShiftExpression ShiftExpression_106_Var
		 = (ShiftExpression)Expr_105_list.get(0);
		Assert.assertNotNull(ShiftExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = ShiftExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final AdditiveExpression AdditiveExpression_107_Var
		 = (AdditiveExpression)Expr_106_list.get(0);
		Assert.assertNotNull(AdditiveExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = AdditiveExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final MultiplicativeExpression MultiplicativeExpression_108_Var
		 = (MultiplicativeExpression)Expr_107_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = MultiplicativeExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final CastExpression CastExpression_109_Var
		 = (CastExpression)Expr_108_list.get(0);
		Assert.assertNotNull(CastExpression_109_Var
		);
		//109
		final UnaryExpression UnaryExpression_110_Var
		 = (UnaryExpression)CastExpression_109_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_110_Var
		);
		//110
		final PostfixExpression PostfixExpression_111_Var
		 = (PostfixExpression)UnaryExpression_110_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = PostfixExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final PrimaryExpression PrimaryExpression_112_Var
		 = (PrimaryExpression)Expr_111_list.get(0);
		Assert.assertNotNull(PrimaryExpression_112_Var
		);
		Assert.assertEquals("i", PrimaryExpression_112_Var
		.getId());
		//112
		final MultiplicativeExpression MultiplicativeExpression_113_Var
		 = (MultiplicativeExpression)Expr_90_list.get(1);
		Assert.assertNotNull(MultiplicativeExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = MultiplicativeExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final CastExpression CastExpression_114_Var
		 = (CastExpression)Expr_113_list.get(0);
		Assert.assertNotNull(CastExpression_114_Var
		);
		//114
		final UnaryExpression UnaryExpression_115_Var
		 = (UnaryExpression)CastExpression_114_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_115_Var
		);
		//115
		final PostfixExpression PostfixExpression_116_Var
		 = (PostfixExpression)UnaryExpression_115_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = PostfixExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final PrimaryExpression PrimaryExpression_117_Var
		 = (PrimaryExpression)Expr_116_list.get(0);
		Assert.assertNotNull(PrimaryExpression_117_Var
		);
		//117
		final Constant Constant_118_Var
		 = (Constant)PrimaryExpression_117_Var
		.getConst();
		Assert.assertNotNull(Constant_118_Var
		);
		Assert.assertEquals("0b011", Constant_118_Var
		.getBin());
		Assert.assertEquals("[+]", AdditiveExpression_90_Var
		.getOp().toString());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0018_PointerInFunctionDef.c");
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
			"res/Test0018_PointerInFunctionDef.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
		// System.out.println("Code generation finished.");
	}
	
}


