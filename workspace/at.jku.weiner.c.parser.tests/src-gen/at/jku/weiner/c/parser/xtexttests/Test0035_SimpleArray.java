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
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
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
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArray;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0035_SimpleArray {
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
			"res/Test0035_SimpleArray.c");
			final String[] expected = new String[] {
				"RULE_LINEDIRECTIVE",
				"RULE_NEWLINE",
				"RULE_LINEDIRECTIVE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_CHAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTBRACKET",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_VOID",
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
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_STRING_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTBRACKET",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_CHAR_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_STRING_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
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
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0035_SimpleArray.c");
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
		Assert.assertEquals(2, External_0_list.size());
		//0
		final ExternalDeclaration ExternalDeclaration_1_Var
		 = (ExternalDeclaration)External_0_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_1_Var
		);
		//1
		final Declaration Declaration_2_Var
		 = (Declaration)ExternalDeclaration_1_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_2_Var
		);
		//2
		final DeclarationSpecifiers DeclarationSpecifiers_3_Var
		 = (DeclarationSpecifiers)Declaration_2_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_3_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_3_list = DeclarationSpecifiers_3_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_3_list);
		Assert.assertEquals(1, DeclarationSpecifier_3_list.size());
		//3
		final TypeSpecifier TypeSpecifier_4_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(TypeSpecifier_4_Var
		);
		Assert.assertEquals("char", TypeSpecifier_4_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_4_list = Declaration_2_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_4_list);
		Assert.assertEquals(1, InitDeclaratorList_4_list.size());
		//4
		final InitDeclaratorList InitDeclaratorList_5_Var
		 = (InitDeclaratorList)InitDeclaratorList_4_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_5_Var
		);
		final EList<? extends EObject> InitDeclarator_5_list = InitDeclaratorList_5_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_5_list);
		Assert.assertEquals(1, InitDeclarator_5_list.size());
		//5
		final InitDeclarator InitDeclarator_6_Var
		 = (InitDeclarator)InitDeclarator_5_list.get(0);
		Assert.assertNotNull(InitDeclarator_6_Var
		);
		//6
		final Declarator Declarator_7_Var
		 = (Declarator)InitDeclarator_6_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_7_Var
		);
		//7
		final DirectDeclarator DirectDeclarator_8_Var
		 = (DirectDeclarator)Declarator_7_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_8_Var
		);
		Assert.assertEquals("out", DirectDeclarator_8_Var
		.getIdent());
		final EList<? extends EObject> DeclaratorSuffix_8_list = DirectDeclarator_8_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_8_list);
		Assert.assertEquals(1, DeclaratorSuffix_8_list.size());
		//8
		final DeclaratorSuffix DeclaratorSuffix_9_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_8_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_9_Var
		);
		//9
		final PrimaryExpression PrimaryExpression_10_Var
		 = (PrimaryExpression)DeclaratorSuffix_9_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_10_Var
		);
		//10
		final Constant2 Constant2_11_Var
		 = (Constant2)PrimaryExpression_10_Var
		.getConst();
		Assert.assertNotNull(Constant2_11_Var
		);
		Assert.assertEquals("255", Constant2_11_Var
		.getDec());
		//11
		final Initializer Initializer_12_Var
		 = (Initializer)InitDeclarator_6_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_12_Var
		);
		//12
		final PrimaryExpression PrimaryExpression_13_Var
		 = (PrimaryExpression)Initializer_12_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_13_Var
		);
		Assert.assertEquals("[\"some output\"]", PrimaryExpression_13_Var
		.getString().toString());
		//13
		final ExternalDeclaration ExternalDeclaration_14_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_14_Var
		);
		//14
		final FunctionDefHead FunctionDefHead_15_Var
		 = (FunctionDefHead)ExternalDeclaration_14_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_15_Var
		);
		//15
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_16_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_15_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_16_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_16_list = FunctionDeclarationSpecifiers_16_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_16_list);
		Assert.assertEquals(1, DeclarationSpecifier_16_list.size());
		//16
		final TypeSpecifier TypeSpecifier_17_Var
		 = (TypeSpecifier)DeclarationSpecifier_16_list.get(0);
		Assert.assertNotNull(TypeSpecifier_17_Var
		);
		Assert.assertEquals("int", TypeSpecifier_17_Var
		.getName());
		//17
		final Declarator Declarator_18_Var
		 = (Declarator)FunctionDefHead_15_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_18_Var
		);
		//18
		final DirectDeclarator DirectDeclarator_19_Var
		 = (DirectDeclarator)Declarator_18_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_19_Var
		);
		Assert.assertEquals("main", DirectDeclarator_19_Var
		.getIdent());
		final EList<? extends EObject> DeclaratorSuffix_19_list = DirectDeclarator_19_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_19_list);
		Assert.assertEquals(1, DeclaratorSuffix_19_list.size());
		//19
		final DeclaratorSuffix DeclaratorSuffix_20_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_19_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_20_Var
		);
		//20
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_21_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_20_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_21_Var
		);
		final EList<? extends EObject> ParameterTypeList_21_list = DirectDeclaratorLastSuffix_21_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_21_list);
		Assert.assertEquals(1, ParameterTypeList_21_list.size());
		//21
		final ParameterTypeList ParameterTypeList_22_Var
		 = (ParameterTypeList)ParameterTypeList_21_list.get(0);
		Assert.assertNotNull(ParameterTypeList_22_Var
		);
		//22
		final ParameterList ParameterList_23_Var
		 = (ParameterList)ParameterTypeList_22_Var
		.getList();
		Assert.assertNotNull(ParameterList_23_Var
		);
		final EList<? extends EObject> ParameterDeclaration_23_list = ParameterList_23_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_23_list);
		Assert.assertEquals(1, ParameterDeclaration_23_list.size());
		//23
		final ParameterDeclaration ParameterDeclaration_24_Var
		 = (ParameterDeclaration)ParameterDeclaration_23_list.get(0);
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
		Assert.assertEquals("void", TypeSpecifier_26_Var
		.getName());
		//26
		final FunctionDefinition FunctionDefinition_27_Var
		 = (FunctionDefinition)ExternalDeclaration_14_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_27_Var
		);
		//27
		final BodyStatement BodyStatement_28_Var
		 = (BodyStatement)FunctionDefinition_27_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_28_Var
		);
		final EList<? extends EObject> BlockList_28_list = BodyStatement_28_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_28_list);
		Assert.assertEquals(1, BlockList_28_list.size());
		//28
		final BlockList BlockList_29_Var
		 = (BlockList)BlockList_28_list.get(0);
		Assert.assertNotNull(BlockList_29_Var
		);
		final EList<? extends EObject> Statement_29_list = BlockList_29_Var
		.getStatement();
		Assert.assertNotNull(Statement_29_list);
		Assert.assertEquals(6, Statement_29_list.size());
		//29
		final Statement Statement_30_Var
		 = (Statement)Statement_29_list.get(0);
		Assert.assertNotNull(Statement_30_Var
		);
		//30
		final ExpressionStatement ExpressionStatement_31_Var
		 = (ExpressionStatement)Statement_30_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_31_Var
		);
		//31
		final PostfixExpression PostfixExpression_32_Var
		 = (PostfixExpression)ExpressionStatement_31_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_32_Var
		);
		//32
		final PrimaryExpression PrimaryExpression_33_Var
		 = (PrimaryExpression)PostfixExpression_32_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_33_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_33_Var
		.getIdent());
		//33
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_34_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_32_Var
		.getSuffix();
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
		Assert.assertEquals(2, Expr_35_list.size());
		//35
		final PrimaryExpression PrimaryExpression_36_Var
		 = (PrimaryExpression)Expr_35_list.get(0);
		Assert.assertNotNull(PrimaryExpression_36_Var
		);
		Assert.assertEquals("[\"%s\\n\"]", PrimaryExpression_36_Var
		.getString().toString());
		//36
		final PrimaryExpression PrimaryExpression_37_Var
		 = (PrimaryExpression)Expr_35_list.get(1);
		Assert.assertNotNull(PrimaryExpression_37_Var
		);
		Assert.assertEquals("out", PrimaryExpression_37_Var
		.getIdent());
		//37
		final Statement Statement_38_Var
		 = (Statement)Statement_29_list.get(1);
		Assert.assertNotNull(Statement_38_Var
		);
		//38
		final ExpressionStatement ExpressionStatement_39_Var
		 = (ExpressionStatement)Statement_38_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_39_Var
		);
		//39
		final PostfixExpression PostfixExpression_40_Var
		 = (PostfixExpression)ExpressionStatement_39_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_40_Var
		);
		//40
		final PrimaryExpression PrimaryExpression_41_Var
		 = (PrimaryExpression)PostfixExpression_40_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_41_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_41_Var
		.getIdent());
		//41
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_42_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_40_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_42_Var
		);
		//42
		final ArgumentExpressionList ArgumentExpressionList_43_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_42_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_43_Var
		);
		final EList<? extends EObject> Expr_43_list = ArgumentExpressionList_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(2, Expr_43_list.size());
		//43
		final PrimaryExpression PrimaryExpression_44_Var
		 = (PrimaryExpression)Expr_43_list.get(0);
		Assert.assertNotNull(PrimaryExpression_44_Var
		);
		Assert.assertEquals("out", PrimaryExpression_44_Var
		.getIdent());
		//44
		final PrimaryExpression PrimaryExpression_45_Var
		 = (PrimaryExpression)Expr_43_list.get(1);
		Assert.assertNotNull(PrimaryExpression_45_Var
		);
		Assert.assertEquals("[\"Hello World!\"]", PrimaryExpression_45_Var
		.getString().toString());
		//45
		final Statement Statement_46_Var
		 = (Statement)Statement_29_list.get(2);
		Assert.assertNotNull(Statement_46_Var
		);
		//46
		final ExpressionStatement ExpressionStatement_47_Var
		 = (ExpressionStatement)Statement_46_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_47_Var
		);
		//47
		final PostfixExpression PostfixExpression_48_Var
		 = (PostfixExpression)ExpressionStatement_47_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_48_Var
		);
		//48
		final PrimaryExpression PrimaryExpression_49_Var
		 = (PrimaryExpression)PostfixExpression_48_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_49_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_49_Var
		.getIdent());
		//49
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_50_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_48_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_50_Var
		);
		//50
		final ArgumentExpressionList ArgumentExpressionList_51_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_50_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_51_Var
		);
		final EList<? extends EObject> Expr_51_list = ArgumentExpressionList_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(2, Expr_51_list.size());
		//51
		final PrimaryExpression PrimaryExpression_52_Var
		 = (PrimaryExpression)Expr_51_list.get(0);
		Assert.assertNotNull(PrimaryExpression_52_Var
		);
		Assert.assertEquals("[\"%s\\n\"]", PrimaryExpression_52_Var
		.getString().toString());
		//52
		final PrimaryExpression PrimaryExpression_53_Var
		 = (PrimaryExpression)Expr_51_list.get(1);
		Assert.assertNotNull(PrimaryExpression_53_Var
		);
		Assert.assertEquals("out", PrimaryExpression_53_Var
		.getIdent());
		//53
		final Statement Statement_54_Var
		 = (Statement)Statement_29_list.get(3);
		Assert.assertNotNull(Statement_54_Var
		);
		//54
		final ExpressionStatement ExpressionStatement_55_Var
		 = (ExpressionStatement)Statement_54_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_55_Var
		);
		//55
		final AssignmentExpression AssignmentExpression_56_Var
		 = (AssignmentExpression)ExpressionStatement_55_Var
		.getExpression();
		Assert.assertNotNull(AssignmentExpression_56_Var
		);
		//56
		final PostfixExpression PostfixExpression_57_Var
		 = (PostfixExpression)AssignmentExpression_56_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_57_Var
		);
		//57
		final PrimaryExpression PrimaryExpression_58_Var
		 = (PrimaryExpression)PostfixExpression_57_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_58_Var
		);
		Assert.assertEquals("out", PrimaryExpression_58_Var
		.getIdent());
		//58
		final PostfixExpressionSuffixArray PostfixExpressionSuffixArray_59_Var
		 = (PostfixExpressionSuffixArray)PostfixExpression_57_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArray_59_Var
		);
		//59
		final PrimaryExpression PrimaryExpression_60_Var
		 = (PrimaryExpression)PostfixExpressionSuffixArray_59_Var
		.getArrayExpr();
		Assert.assertNotNull(PrimaryExpression_60_Var
		);
		//60
		final Constant2 Constant2_61_Var
		 = (Constant2)PrimaryExpression_60_Var
		.getConst();
		Assert.assertNotNull(Constant2_61_Var
		);
		Assert.assertEquals("6", Constant2_61_Var
		.getDec());
		Assert.assertEquals("=", AssignmentExpression_56_Var
		.getOp());
		//61
		final PrimaryExpression PrimaryExpression_62_Var
		 = (PrimaryExpression)AssignmentExpression_56_Var
		.getAssignmentExpr();
		Assert.assertNotNull(PrimaryExpression_62_Var
		);
		//62
		final Constant2 Constant2_63_Var
		 = (Constant2)PrimaryExpression_62_Var
		.getConst();
		Assert.assertNotNull(Constant2_63_Var
		);
		Assert.assertEquals("'w'", Constant2_63_Var
		.getCh());
		//63
		final Statement Statement_64_Var
		 = (Statement)Statement_29_list.get(4);
		Assert.assertNotNull(Statement_64_Var
		);
		//64
		final ExpressionStatement ExpressionStatement_65_Var
		 = (ExpressionStatement)Statement_64_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_65_Var
		);
		//65
		final PostfixExpression PostfixExpression_66_Var
		 = (PostfixExpression)ExpressionStatement_65_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_66_Var
		);
		//66
		final PrimaryExpression PrimaryExpression_67_Var
		 = (PrimaryExpression)PostfixExpression_66_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_67_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_67_Var
		.getIdent());
		//67
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_68_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_66_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_68_Var
		);
		//68
		final ArgumentExpressionList ArgumentExpressionList_69_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_68_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_69_Var
		);
		final EList<? extends EObject> Expr_69_list = ArgumentExpressionList_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(2, Expr_69_list.size());
		//69
		final PrimaryExpression PrimaryExpression_70_Var
		 = (PrimaryExpression)Expr_69_list.get(0);
		Assert.assertNotNull(PrimaryExpression_70_Var
		);
		Assert.assertEquals("[\"%s\\n\"]", PrimaryExpression_70_Var
		.getString().toString());
		//70
		final PrimaryExpression PrimaryExpression_71_Var
		 = (PrimaryExpression)Expr_69_list.get(1);
		Assert.assertNotNull(PrimaryExpression_71_Var
		);
		Assert.assertEquals("out", PrimaryExpression_71_Var
		.getIdent());
		//71
		final Statement Statement_72_Var
		 = (Statement)Statement_29_list.get(5);
		Assert.assertNotNull(Statement_72_Var
		);
		//72
		final JumpStatement JumpStatement_73_Var
		 = (JumpStatement)Statement_72_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_73_Var
		);
		//73
		final PrimaryExpression PrimaryExpression_74_Var
		 = (PrimaryExpression)JumpStatement_73_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_74_Var
		);
		//74
		final Constant2 Constant2_75_Var
		 = (Constant2)PrimaryExpression_74_Var
		.getConst();
		Assert.assertNotNull(Constant2_75_Var
		);
		Assert.assertEquals("0", Constant2_75_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_73_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0035_SimpleArray.c");
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
				method.invoke(this.generator, "Test0035_SimpleArray.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0035_SimpleArray.c");
		final String expected = this.getTextFromFile(
			"res/Test0035_SimpleArray.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
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


