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
import at.jku.weiner.c.parser.parser.InitializerList;
import at.jku.weiner.c.parser.parser.Init;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Init;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Init;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Init;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Init;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Init;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArray;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0036_SimpleIntArray {
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
			"res/Test0036_SimpleIntArray.c");
			final String[] expected = new String[] {
				"RULE_LINEDIRECTIVE",
				"RULE_NEWLINE",
				"RULE_LINEDIRECTIVE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTBRACKET",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTBRACE",
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
				"RULE_SKW_LEFTBRACKET",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTBRACKET",
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
			"res/Test0036_SimpleIntArray.c");
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
		Assert.assertEquals("int", TypeSpecifier_4_Var
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
		Assert.assertEquals("array", DirectDeclarator_8_Var
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
		Assert.assertEquals("6", Constant2_11_Var
		.getDec());
		//11
		final Initializer Initializer_12_Var
		 = (Initializer)InitDeclarator_6_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_12_Var
		);
		//12
		final InitializerList InitializerList_13_Var
		 = (InitializerList)Initializer_12_Var
		.getList();
		Assert.assertNotNull(InitializerList_13_Var
		);
		final EList<? extends EObject> Init_13_list = InitializerList_13_Var
		.getInit();
		Assert.assertNotNull(Init_13_list);
		Assert.assertEquals(6, Init_13_list.size());
		//13
		final Init Init_14_Var
		 = (Init)Init_13_list.get(0);
		Assert.assertNotNull(Init_14_Var
		);
		//14
		final Initializer Initializer_15_Var
		 = (Initializer)Init_14_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_15_Var
		);
		//15
		final PrimaryExpression PrimaryExpression_16_Var
		 = (PrimaryExpression)Initializer_15_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_16_Var
		);
		//16
		final Constant2 Constant2_17_Var
		 = (Constant2)PrimaryExpression_16_Var
		.getConst();
		Assert.assertNotNull(Constant2_17_Var
		);
		Assert.assertEquals("1", Constant2_17_Var
		.getDec());
		//17
		final Init Init_18_Var
		 = (Init)Init_13_list.get(1);
		Assert.assertNotNull(Init_18_Var
		);
		//18
		final Initializer Initializer_19_Var
		 = (Initializer)Init_18_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_19_Var
		);
		//19
		final PrimaryExpression PrimaryExpression_20_Var
		 = (PrimaryExpression)Initializer_19_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_20_Var
		);
		//20
		final Constant2 Constant2_21_Var
		 = (Constant2)PrimaryExpression_20_Var
		.getConst();
		Assert.assertNotNull(Constant2_21_Var
		);
		Assert.assertEquals("2", Constant2_21_Var
		.getDec());
		//21
		final Init Init_22_Var
		 = (Init)Init_13_list.get(2);
		Assert.assertNotNull(Init_22_Var
		);
		//22
		final Initializer Initializer_23_Var
		 = (Initializer)Init_22_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_23_Var
		);
		//23
		final PrimaryExpression PrimaryExpression_24_Var
		 = (PrimaryExpression)Initializer_23_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_24_Var
		);
		//24
		final Constant2 Constant2_25_Var
		 = (Constant2)PrimaryExpression_24_Var
		.getConst();
		Assert.assertNotNull(Constant2_25_Var
		);
		Assert.assertEquals("3", Constant2_25_Var
		.getDec());
		//25
		final Init Init_26_Var
		 = (Init)Init_13_list.get(3);
		Assert.assertNotNull(Init_26_Var
		);
		//26
		final Initializer Initializer_27_Var
		 = (Initializer)Init_26_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_27_Var
		);
		//27
		final PrimaryExpression PrimaryExpression_28_Var
		 = (PrimaryExpression)Initializer_27_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_28_Var
		);
		//28
		final Constant2 Constant2_29_Var
		 = (Constant2)PrimaryExpression_28_Var
		.getConst();
		Assert.assertNotNull(Constant2_29_Var
		);
		Assert.assertEquals("5", Constant2_29_Var
		.getDec());
		//29
		final Init Init_30_Var
		 = (Init)Init_13_list.get(4);
		Assert.assertNotNull(Init_30_Var
		);
		//30
		final Initializer Initializer_31_Var
		 = (Initializer)Init_30_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_31_Var
		);
		//31
		final PrimaryExpression PrimaryExpression_32_Var
		 = (PrimaryExpression)Initializer_31_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_32_Var
		);
		//32
		final Constant2 Constant2_33_Var
		 = (Constant2)PrimaryExpression_32_Var
		.getConst();
		Assert.assertNotNull(Constant2_33_Var
		);
		Assert.assertEquals("7", Constant2_33_Var
		.getDec());
		//33
		final Init Init_34_Var
		 = (Init)Init_13_list.get(5);
		Assert.assertNotNull(Init_34_Var
		);
		//34
		final Initializer Initializer_35_Var
		 = (Initializer)Init_34_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_35_Var
		);
		//35
		final PrimaryExpression PrimaryExpression_36_Var
		 = (PrimaryExpression)Initializer_35_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_36_Var
		);
		//36
		final Constant2 Constant2_37_Var
		 = (Constant2)PrimaryExpression_36_Var
		.getConst();
		Assert.assertNotNull(Constant2_37_Var
		);
		Assert.assertEquals("11", Constant2_37_Var
		.getDec());
		//37
		final ExternalDeclaration ExternalDeclaration_38_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_38_Var
		);
		//38
		final FunctionDefHead FunctionDefHead_39_Var
		 = (FunctionDefHead)ExternalDeclaration_38_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_39_Var
		);
		//39
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_40_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_39_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_40_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_40_list = FunctionDeclarationSpecifiers_40_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_40_list);
		Assert.assertEquals(1, DeclarationSpecifier_40_list.size());
		//40
		final TypeSpecifier TypeSpecifier_41_Var
		 = (TypeSpecifier)DeclarationSpecifier_40_list.get(0);
		Assert.assertNotNull(TypeSpecifier_41_Var
		);
		Assert.assertEquals("int", TypeSpecifier_41_Var
		.getName());
		//41
		final Declarator Declarator_42_Var
		 = (Declarator)FunctionDefHead_39_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_42_Var
		);
		//42
		final DirectDeclarator DirectDeclarator_43_Var
		 = (DirectDeclarator)Declarator_42_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_43_Var
		);
		Assert.assertEquals("main", DirectDeclarator_43_Var
		.getIdent());
		final EList<? extends EObject> DeclaratorSuffix_43_list = DirectDeclarator_43_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_43_list);
		Assert.assertEquals(1, DeclaratorSuffix_43_list.size());
		//43
		final DeclaratorSuffix DeclaratorSuffix_44_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_43_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_44_Var
		);
		//44
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_45_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_44_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_45_Var
		);
		final EList<? extends EObject> ParameterTypeList_45_list = DirectDeclaratorLastSuffix_45_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_45_list);
		Assert.assertEquals(1, ParameterTypeList_45_list.size());
		//45
		final ParameterTypeList ParameterTypeList_46_Var
		 = (ParameterTypeList)ParameterTypeList_45_list.get(0);
		Assert.assertNotNull(ParameterTypeList_46_Var
		);
		//46
		final ParameterList ParameterList_47_Var
		 = (ParameterList)ParameterTypeList_46_Var
		.getList();
		Assert.assertNotNull(ParameterList_47_Var
		);
		final EList<? extends EObject> ParameterDeclaration_47_list = ParameterList_47_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_47_list);
		Assert.assertEquals(1, ParameterDeclaration_47_list.size());
		//47
		final ParameterDeclaration ParameterDeclaration_48_Var
		 = (ParameterDeclaration)ParameterDeclaration_47_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_48_Var
		);
		//48
		final DeclarationSpecifiers DeclarationSpecifiers_49_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_48_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_49_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_49_list = DeclarationSpecifiers_49_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_49_list);
		Assert.assertEquals(1, DeclarationSpecifier_49_list.size());
		//49
		final TypeSpecifier TypeSpecifier_50_Var
		 = (TypeSpecifier)DeclarationSpecifier_49_list.get(0);
		Assert.assertNotNull(TypeSpecifier_50_Var
		);
		Assert.assertEquals("void", TypeSpecifier_50_Var
		.getName());
		//50
		final FunctionDefinition FunctionDefinition_51_Var
		 = (FunctionDefinition)ExternalDeclaration_38_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_51_Var
		);
		//51
		final BodyStatement BodyStatement_52_Var
		 = (BodyStatement)FunctionDefinition_51_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_52_Var
		);
		final EList<? extends EObject> BlockList_52_list = BodyStatement_52_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_52_list);
		Assert.assertEquals(1, BlockList_52_list.size());
		//52
		final BlockList BlockList_53_Var
		 = (BlockList)BlockList_52_list.get(0);
		Assert.assertNotNull(BlockList_53_Var
		);
		final EList<? extends EObject> Statement_53_list = BlockList_53_Var
		.getStatement();
		Assert.assertNotNull(Statement_53_list);
		Assert.assertEquals(2, Statement_53_list.size());
		//53
		final Statement Statement_54_Var
		 = (Statement)Statement_53_list.get(0);
		Assert.assertNotNull(Statement_54_Var
		);
		//54
		final ExpressionStatement ExpressionStatement_55_Var
		 = (ExpressionStatement)Statement_54_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_55_Var
		);
		//55
		final PostfixExpression PostfixExpression_56_Var
		 = (PostfixExpression)ExpressionStatement_55_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_56_Var
		);
		//56
		final PrimaryExpression PrimaryExpression_57_Var
		 = (PrimaryExpression)PostfixExpression_56_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_57_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_57_Var
		.getIdent());
		//57
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_58_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_56_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_58_Var
		);
		//58
		final ArgumentExpressionList ArgumentExpressionList_59_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_58_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_59_Var
		);
		final EList<? extends EObject> Expr_59_list = ArgumentExpressionList_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(2, Expr_59_list.size());
		//59
		final PrimaryExpression PrimaryExpression_60_Var
		 = (PrimaryExpression)Expr_59_list.get(0);
		Assert.assertNotNull(PrimaryExpression_60_Var
		);
		Assert.assertEquals("[\"%d\\n\"]", PrimaryExpression_60_Var
		.getString().toString());
		//60
		final PostfixExpression PostfixExpression_61_Var
		 = (PostfixExpression)Expr_59_list.get(1);
		Assert.assertNotNull(PostfixExpression_61_Var
		);
		//61
		final PrimaryExpression PrimaryExpression_62_Var
		 = (PrimaryExpression)PostfixExpression_61_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_62_Var
		);
		Assert.assertEquals("array", PrimaryExpression_62_Var
		.getIdent());
		//62
		final PostfixExpressionSuffixArray PostfixExpressionSuffixArray_63_Var
		 = (PostfixExpressionSuffixArray)PostfixExpression_61_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArray_63_Var
		);
		//63
		final PrimaryExpression PrimaryExpression_64_Var
		 = (PrimaryExpression)PostfixExpressionSuffixArray_63_Var
		.getArrayExpr();
		Assert.assertNotNull(PrimaryExpression_64_Var
		);
		//64
		final Constant2 Constant2_65_Var
		 = (Constant2)PrimaryExpression_64_Var
		.getConst();
		Assert.assertNotNull(Constant2_65_Var
		);
		Assert.assertEquals("3", Constant2_65_Var
		.getDec());
		//65
		final Statement Statement_66_Var
		 = (Statement)Statement_53_list.get(1);
		Assert.assertNotNull(Statement_66_Var
		);
		//66
		final JumpStatement JumpStatement_67_Var
		 = (JumpStatement)Statement_66_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_67_Var
		);
		//67
		final PrimaryExpression PrimaryExpression_68_Var
		 = (PrimaryExpression)JumpStatement_67_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_68_Var
		);
		//68
		final Constant2 Constant2_69_Var
		 = (Constant2)PrimaryExpression_68_Var
		.getConst();
		Assert.assertNotNull(Constant2_69_Var
		);
		Assert.assertEquals("0", Constant2_69_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_67_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0036_SimpleIntArray.c");
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
				method.invoke(this.generator, "Test0036_SimpleIntArray.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0036_SimpleIntArray.c");
		final String expected = this.getTextFromFile(
			"res/Test0036_SimpleIntArray.c"
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


