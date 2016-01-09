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
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Pointer;
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
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArray;
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
import at.jku.weiner.c.parser.parser.AssignmentOperator;
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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArray;
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
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0018_PointerInFunctionDef {
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
			"res/Test0018_PointerInFunctionDef.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_VOID",
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
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_KW_FLOAT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_LEFTBRACKET",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTBRACKET",
				"RULE_ID",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_WHITESPACE",
				"RULE_SKW_PLUS",
				"RULE_WHITESPACE",
				"RULE_BIN_LITERAL",
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
			"res/Test0018_PointerInFunctionDef.c");
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
		Assert.assertEquals("do1", DirectDeclarator_6_Var
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
		Assert.assertEquals(4, ParameterDeclaration_10_list.size());
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
		final Pointer Pointer_16_Var
		 = (Pointer)Declarator_14_Var
		.getPointer();
		Assert.assertNotNull(Pointer_16_Var
		);
		Assert.assertEquals("[]", Pointer_16_Var
		.getStar().toString());
		//16
		final ParameterDeclaration ParameterDeclaration_17_Var
		 = (ParameterDeclaration)ParameterDeclaration_10_list.get(1);
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
		final ParameterDeclaration ParameterDeclaration_23_Var
		 = (ParameterDeclaration)ParameterDeclaration_10_list.get(2);
		Assert.assertNotNull(ParameterDeclaration_23_Var
		);
		//23
		final DeclarationSpecifiers DeclarationSpecifiers_24_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_23_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_24_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_24_list = DeclarationSpecifiers_24_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_24_list);
		Assert.assertEquals(1, DeclarationSpecifier_24_list.size());
		//24
		final TypeSpecifier TypeSpecifier_25_Var
		 = (TypeSpecifier)DeclarationSpecifier_24_list.get(0);
		Assert.assertNotNull(TypeSpecifier_25_Var
		);
		Assert.assertEquals("float", TypeSpecifier_25_Var
		.getName());
		//25
		final Declarator Declarator_26_Var
		 = (Declarator)ParameterDeclaration_23_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_26_Var
		);
		//26
		final DirectDeclarator DirectDeclarator_27_Var
		 = (DirectDeclarator)Declarator_26_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_27_Var
		);
		Assert.assertEquals("f", DirectDeclarator_27_Var
		.getId());
		//27
		final ParameterDeclaration ParameterDeclaration_28_Var
		 = (ParameterDeclaration)ParameterDeclaration_10_list.get(3);
		Assert.assertNotNull(ParameterDeclaration_28_Var
		);
		//28
		final DeclarationSpecifiers DeclarationSpecifiers_29_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_28_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_29_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_29_list = DeclarationSpecifiers_29_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_29_list);
		Assert.assertEquals(1, DeclarationSpecifier_29_list.size());
		//29
		final TypeSpecifier TypeSpecifier_30_Var
		 = (TypeSpecifier)DeclarationSpecifier_29_list.get(0);
		Assert.assertNotNull(TypeSpecifier_30_Var
		);
		Assert.assertEquals("int", TypeSpecifier_30_Var
		.getName());
		//30
		final Declarator Declarator_31_Var
		 = (Declarator)ParameterDeclaration_28_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_31_Var
		);
		//31
		final DirectDeclarator DirectDeclarator_32_Var
		 = (DirectDeclarator)Declarator_31_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_32_Var
		);
		Assert.assertEquals("i", DirectDeclarator_32_Var
		.getId());
		//32
		final FunctionDefinition FunctionDefinition_33_Var
		 = (FunctionDefinition)ExternalDeclaration_1_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_33_Var
		);
		//33
		final BodyStatement BodyStatement_34_Var
		 = (BodyStatement)FunctionDefinition_33_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_34_Var
		);
		final EList<? extends EObject> BlockList_34_list = BodyStatement_34_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_34_list);
		Assert.assertEquals(1, BlockList_34_list.size());
		//34
		final BlockList BlockList_35_Var
		 = (BlockList)BlockList_34_list.get(0);
		Assert.assertNotNull(BlockList_35_Var
		);
		final EList<? extends EObject> Statement_35_list = BlockList_35_Var
		.getStatement();
		Assert.assertNotNull(Statement_35_list);
		Assert.assertEquals(1, Statement_35_list.size());
		//35
		final Statement Statement_36_Var
		 = (Statement)Statement_35_list.get(0);
		Assert.assertNotNull(Statement_36_Var
		);
		//36
		final ExpressionStatement ExpressionStatement_37_Var
		 = (ExpressionStatement)Statement_36_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_37_Var
		);
		//37
		final Expression Expression_38_Var
		 = (Expression)ExpressionStatement_37_Var
		.getExpression();
		Assert.assertNotNull(Expression_38_Var
		);
		final EList<? extends EObject> ExprExpr_38_list = Expression_38_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_38_list);
		Assert.assertEquals(1, ExprExpr_38_list.size());
		//38
		final AssignmentExpression AssignmentExpression_39_Var
		 = (AssignmentExpression)ExprExpr_38_list.get(0);
		Assert.assertNotNull(AssignmentExpression_39_Var
		);
		//39
		final UnaryExpression UnaryExpression_40_Var
		 = (UnaryExpression)AssignmentExpression_39_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_40_Var
		);
		//40
		final PostfixExpression PostfixExpression_41_Var
		 = (PostfixExpression)UnaryExpression_40_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = PostfixExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final PrimaryExpression PrimaryExpression_42_Var
		 = (PrimaryExpression)Expr_41_list.get(0);
		Assert.assertNotNull(PrimaryExpression_42_Var
		);
		//42
		final Expression Expression_43_Var
		 = (Expression)PrimaryExpression_42_Var
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
		final PostfixExpression PostfixExpression_58_Var
		 = (PostfixExpression)UnaryExpression_57_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = PostfixExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final PrimaryExpression PrimaryExpression_59_Var
		 = (PrimaryExpression)Expr_58_list.get(0);
		Assert.assertNotNull(PrimaryExpression_59_Var
		);
		Assert.assertEquals("argv", PrimaryExpression_59_Var
		.getId());
		final EList<? extends EObject> Suffix_59_list = PostfixExpression_58_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_59_list);
		Assert.assertEquals(1, Suffix_59_list.size());
		//59
		final PostfixExpressionSuffixArray PostfixExpressionSuffixArray_60_Var
		 = (PostfixExpressionSuffixArray)Suffix_59_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArray_60_Var
		);
		//60
		final Expression Expression_61_Var
		 = (Expression)PostfixExpressionSuffixArray_60_Var
		.getArrayExpr();
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
		final Constant2 Constant2_78_Var
		 = (Constant2)PrimaryExpression_77_Var
		.getConst();
		Assert.assertNotNull(Constant2_78_Var
		);
		Assert.assertEquals("9", Constant2_78_Var
		.getDec());
		//78
		final AssignmentOperator AssignmentOperator_79_Var
		 = (AssignmentOperator)AssignmentExpression_39_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_79_Var
		);
		Assert.assertEquals("=", AssignmentOperator_79_Var
		.getOp());
		//79
		final AssignmentExpression AssignmentExpression_80_Var
		 = (AssignmentExpression)AssignmentExpression_39_Var
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
		final EList<? extends EObject> Suffix_95_list = PostfixExpression_94_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_95_list);
		Assert.assertEquals(1, Suffix_95_list.size());
		//95
		final PostfixExpressionSuffixArray PostfixExpressionSuffixArray_96_Var
		 = (PostfixExpressionSuffixArray)Suffix_95_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArray_96_Var
		);
		//96
		final Expression Expression_97_Var
		 = (Expression)PostfixExpressionSuffixArray_96_Var
		.getArrayExpr();
		Assert.assertNotNull(Expression_97_Var
		);
		final EList<? extends EObject> ExprExpr_97_list = Expression_97_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_97_list);
		Assert.assertEquals(1, ExprExpr_97_list.size());
		//97
		final AssignmentExpression AssignmentExpression_98_Var
		 = (AssignmentExpression)ExprExpr_97_list.get(0);
		Assert.assertNotNull(AssignmentExpression_98_Var
		);
		//98
		final ConditionalExpression ConditionalExpression_99_Var
		 = (ConditionalExpression)AssignmentExpression_98_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_99_Var
		);
		//99
		final LogicalOrExpression LogicalOrExpression_100_Var
		 = (LogicalOrExpression)ConditionalExpression_99_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = LogicalOrExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final LogicalAndExpression LogicalAndExpression_101_Var
		 = (LogicalAndExpression)Expr_100_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = LogicalAndExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final InclusiveOrExpression InclusiveOrExpression_102_Var
		 = (InclusiveOrExpression)Expr_101_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = InclusiveOrExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final ExclusiveOrExpression ExclusiveOrExpression_103_Var
		 = (ExclusiveOrExpression)Expr_102_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = ExclusiveOrExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final AndExpression AndExpression_104_Var
		 = (AndExpression)Expr_103_list.get(0);
		Assert.assertNotNull(AndExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = AndExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final EqualityExpression EqualityExpression_105_Var
		 = (EqualityExpression)Expr_104_list.get(0);
		Assert.assertNotNull(EqualityExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = EqualityExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final RelationalExpression RelationalExpression_106_Var
		 = (RelationalExpression)Expr_105_list.get(0);
		Assert.assertNotNull(RelationalExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = RelationalExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final ShiftExpression ShiftExpression_107_Var
		 = (ShiftExpression)Expr_106_list.get(0);
		Assert.assertNotNull(ShiftExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = ShiftExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final AdditiveExpression AdditiveExpression_108_Var
		 = (AdditiveExpression)Expr_107_list.get(0);
		Assert.assertNotNull(AdditiveExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = AdditiveExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final MultiplicativeExpression MultiplicativeExpression_109_Var
		 = (MultiplicativeExpression)Expr_108_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = MultiplicativeExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final CastExpression CastExpression_110_Var
		 = (CastExpression)Expr_109_list.get(0);
		Assert.assertNotNull(CastExpression_110_Var
		);
		//110
		final UnaryExpression UnaryExpression_111_Var
		 = (UnaryExpression)CastExpression_110_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_111_Var
		);
		//111
		final PostfixExpression PostfixExpression_112_Var
		 = (PostfixExpression)UnaryExpression_111_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = PostfixExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final PrimaryExpression PrimaryExpression_113_Var
		 = (PrimaryExpression)Expr_112_list.get(0);
		Assert.assertNotNull(PrimaryExpression_113_Var
		);
		Assert.assertEquals("i", PrimaryExpression_113_Var
		.getId());
		//113
		final MultiplicativeExpression MultiplicativeExpression_114_Var
		 = (MultiplicativeExpression)Expr_90_list.get(1);
		Assert.assertNotNull(MultiplicativeExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = MultiplicativeExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final CastExpression CastExpression_115_Var
		 = (CastExpression)Expr_114_list.get(0);
		Assert.assertNotNull(CastExpression_115_Var
		);
		//115
		final UnaryExpression UnaryExpression_116_Var
		 = (UnaryExpression)CastExpression_115_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_116_Var
		);
		//116
		final PostfixExpression PostfixExpression_117_Var
		 = (PostfixExpression)UnaryExpression_116_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = PostfixExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final PrimaryExpression PrimaryExpression_118_Var
		 = (PrimaryExpression)Expr_117_list.get(0);
		Assert.assertNotNull(PrimaryExpression_118_Var
		);
		//118
		final Constant2 Constant2_119_Var
		 = (Constant2)PrimaryExpression_118_Var
		.getConst();
		Assert.assertNotNull(Constant2_119_Var
		);
		Assert.assertEquals("0b011", Constant2_119_Var
		.getBin());
		Assert.assertEquals("[+]", AdditiveExpression_90_Var
		.getOp().toString());
	}
	
	@Test
	(timeout=1000
	)
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
		final Class<?> clazz = this.generator.getClass();
		try {
			final Method method = clazz.getMethod("setFileName",
					String.class);
			if (method != null) {
				method.invoke(this.generator, "Test0018_PointerInFunctionDef.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0018_PointerInFunctionDef.c");
		final String expected = this.getTextFromFile(
			"res/Test0018_PointerInFunctionDef.c"
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


