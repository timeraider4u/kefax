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
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.AsmStatement;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
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
public class Test0030_Assembler2 {
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
			"res/Test0030_Assembler2.c");
			final String[] expected = new String[] {
				"RULE_IGNORED",
				"RULE_NEWLINE",
				"RULE_LINEDIRECTIVE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_VOID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_IGNORED",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_ASM2",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_IGNORED",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_IGNORED",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_IGNORED",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_IGNORED",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_IGNORED",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_IGNORED",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_IGNORED",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_IGNORED",
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
			"res/Test0030_Assembler2.c");
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
		.getIdent());
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
		Assert.assertEquals(1, ParameterDeclaration_10_list.size());
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
		Assert.assertEquals("void", TypeSpecifier_13_Var
		.getName());
		//13
		final FunctionDefinition FunctionDefinition_14_Var
		 = (FunctionDefinition)ExternalDeclaration_1_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_14_Var
		);
		//14
		final BodyStatement BodyStatement_15_Var
		 = (BodyStatement)FunctionDefinition_14_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_15_Var
		);
		final EList<? extends EObject> BlockList_15_list = BodyStatement_15_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_15_list);
		Assert.assertEquals(1, BlockList_15_list.size());
		//15
		final BlockList BlockList_16_Var
		 = (BlockList)BlockList_15_list.get(0);
		Assert.assertNotNull(BlockList_16_Var
		);
		final EList<? extends EObject> Declaration_16_list = BlockList_16_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_16_list);
		Assert.assertEquals(2, Declaration_16_list.size());
		//16
		final Declaration Declaration_17_Var
		 = (Declaration)Declaration_16_list.get(0);
		Assert.assertNotNull(Declaration_17_Var
		);
		//17
		final DeclarationSpecifiers DeclarationSpecifiers_18_Var
		 = (DeclarationSpecifiers)Declaration_17_Var
		.getSpecifiers();
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
		Assert.assertEquals("int", TypeSpecifier_19_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_19_list = Declaration_17_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_19_list);
		Assert.assertEquals(1, InitDeclaratorList_19_list.size());
		//19
		final InitDeclaratorList InitDeclaratorList_20_Var
		 = (InitDeclaratorList)InitDeclaratorList_19_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_20_Var
		);
		final EList<? extends EObject> InitDeclarator_20_list = InitDeclaratorList_20_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_20_list);
		Assert.assertEquals(1, InitDeclarator_20_list.size());
		//20
		final InitDeclarator InitDeclarator_21_Var
		 = (InitDeclarator)InitDeclarator_20_list.get(0);
		Assert.assertNotNull(InitDeclarator_21_Var
		);
		//21
		final Declarator Declarator_22_Var
		 = (Declarator)InitDeclarator_21_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_22_Var
		);
		//22
		final DirectDeclarator DirectDeclarator_23_Var
		 = (DirectDeclarator)Declarator_22_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_23_Var
		);
		Assert.assertEquals("foo", DirectDeclarator_23_Var
		.getIdent());
		//23
		final Initializer Initializer_24_Var
		 = (Initializer)InitDeclarator_21_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_24_Var
		);
		//24
		final PrimaryExpression PrimaryExpression_25_Var
		 = (PrimaryExpression)Initializer_24_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_25_Var
		);
		//25
		final Constant2 Constant2_26_Var
		 = (Constant2)PrimaryExpression_25_Var
		.getConst();
		Assert.assertNotNull(Constant2_26_Var
		);
		Assert.assertEquals("5", Constant2_26_Var
		.getDec());
		//26
		final Declaration Declaration_27_Var
		 = (Declaration)Declaration_16_list.get(1);
		Assert.assertNotNull(Declaration_27_Var
		);
		//27
		final DeclarationSpecifiers DeclarationSpecifiers_28_Var
		 = (DeclarationSpecifiers)Declaration_27_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_28_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_28_list = DeclarationSpecifiers_28_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_28_list);
		Assert.assertEquals(1, DeclarationSpecifier_28_list.size());
		//28
		final TypeSpecifier TypeSpecifier_29_Var
		 = (TypeSpecifier)DeclarationSpecifier_28_list.get(0);
		Assert.assertNotNull(TypeSpecifier_29_Var
		);
		Assert.assertEquals("int", TypeSpecifier_29_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_29_list = Declaration_27_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_29_list);
		Assert.assertEquals(1, InitDeclaratorList_29_list.size());
		//29
		final InitDeclaratorList InitDeclaratorList_30_Var
		 = (InitDeclaratorList)InitDeclaratorList_29_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_30_Var
		);
		final EList<? extends EObject> InitDeclarator_30_list = InitDeclaratorList_30_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_30_list);
		Assert.assertEquals(1, InitDeclarator_30_list.size());
		//30
		final InitDeclarator InitDeclarator_31_Var
		 = (InitDeclarator)InitDeclarator_30_list.get(0);
		Assert.assertNotNull(InitDeclarator_31_Var
		);
		//31
		final Declarator Declarator_32_Var
		 = (Declarator)InitDeclarator_31_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_32_Var
		);
		//32
		final DirectDeclarator DirectDeclarator_33_Var
		 = (DirectDeclarator)Declarator_32_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_33_Var
		);
		Assert.assertEquals("bar", DirectDeclarator_33_Var
		.getIdent());
		//33
		final Initializer Initializer_34_Var
		 = (Initializer)InitDeclarator_31_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_34_Var
		);
		//34
		final PrimaryExpression PrimaryExpression_35_Var
		 = (PrimaryExpression)Initializer_34_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_35_Var
		);
		//35
		final Constant2 Constant2_36_Var
		 = (Constant2)PrimaryExpression_35_Var
		.getConst();
		Assert.assertNotNull(Constant2_36_Var
		);
		Assert.assertEquals("4", Constant2_36_Var
		.getDec());
		final EList<? extends EObject> Statement_36_list = BlockList_16_Var
		.getStatement();
		Assert.assertNotNull(Statement_36_list);
		Assert.assertEquals(3, Statement_36_list.size());
		//36
		final Statement Statement_37_Var
		 = (Statement)Statement_36_list.get(0);
		Assert.assertNotNull(Statement_37_Var
		);
		//37
		final AsmStatement AsmStatement_38_Var
		 = (AsmStatement)Statement_37_Var
		.getStmt();
		Assert.assertNotNull(AsmStatement_38_Var
		);
		//38
		final AsmLine AsmLine_39_Var
		 = (AsmLine)AsmStatement_38_Var
		.getAsmLine1();
		Assert.assertNotNull(AsmLine_39_Var
		);
		//39
		final PrimaryExpression PrimaryExpression_40_Var
		 = (PrimaryExpression)AsmLine_39_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_40_Var
		);
		Assert.assertEquals("[\"add %1, %0\\n\\t\", \"inc %0\"]", PrimaryExpression_40_Var
		.getString().toString());
		final EList<? extends EObject> AsmLines_40_list = AsmStatement_38_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_40_list);
		Assert.assertEquals(4, AsmLines_40_list.size());
		//40
		final AsmLineWithColon AsmLineWithColon_41_Var
		 = (AsmLineWithColon)AsmLines_40_list.get(0);
		Assert.assertNotNull(AsmLineWithColon_41_Var
		);
		//41
		final AsmLineWithoutColon AsmLineWithoutColon_42_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_41_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_42_Var
		);
		final EList<? extends EObject> AsmLines_42_list = AsmLineWithoutColon_42_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_42_list);
		Assert.assertEquals(1, AsmLines_42_list.size());
		//42
		final AsmLine AsmLine_43_Var
		 = (AsmLine)AsmLines_42_list.get(0);
		Assert.assertNotNull(AsmLine_43_Var
		);
		//43
		final PostfixExpression PostfixExpression_44_Var
		 = (PostfixExpression)AsmLine_43_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_44_Var
		);
		//44
		final PrimaryExpression PrimaryExpression_45_Var
		 = (PrimaryExpression)PostfixExpression_44_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_45_Var
		);
		Assert.assertEquals("[\"+r\"]", PrimaryExpression_45_Var
		.getString().toString());
		//45
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_46_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_44_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_46_Var
		);
		//46
		final ArgumentExpressionList ArgumentExpressionList_47_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_46_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_47_Var
		);
		final EList<? extends EObject> Expr_47_list = ArgumentExpressionList_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final PrimaryExpression PrimaryExpression_48_Var
		 = (PrimaryExpression)Expr_47_list.get(0);
		Assert.assertNotNull(PrimaryExpression_48_Var
		);
		Assert.assertEquals("bar", PrimaryExpression_48_Var
		.getIdent());
		//48
		final AsmLineWithColon AsmLineWithColon_49_Var
		 = (AsmLineWithColon)AsmLines_40_list.get(1);
		Assert.assertNotNull(AsmLineWithColon_49_Var
		);
		//49
		final AsmLineWithoutColon AsmLineWithoutColon_50_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_49_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_50_Var
		);
		final EList<? extends EObject> AsmLines_50_list = AsmLineWithoutColon_50_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_50_list);
		Assert.assertEquals(1, AsmLines_50_list.size());
		//50
		final AsmLine AsmLine_51_Var
		 = (AsmLine)AsmLines_50_list.get(0);
		Assert.assertNotNull(AsmLine_51_Var
		);
		//51
		final PostfixExpression PostfixExpression_52_Var
		 = (PostfixExpression)AsmLine_51_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_52_Var
		);
		//52
		final PrimaryExpression PrimaryExpression_53_Var
		 = (PrimaryExpression)PostfixExpression_52_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_53_Var
		);
		Assert.assertEquals("[\"g\"]", PrimaryExpression_53_Var
		.getString().toString());
		//53
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_54_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_52_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_54_Var
		);
		//54
		final ArgumentExpressionList ArgumentExpressionList_55_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_54_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_55_Var
		);
		final EList<? extends EObject> Expr_55_list = ArgumentExpressionList_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final PrimaryExpression PrimaryExpression_56_Var
		 = (PrimaryExpression)Expr_55_list.get(0);
		Assert.assertNotNull(PrimaryExpression_56_Var
		);
		Assert.assertEquals("foo", PrimaryExpression_56_Var
		.getIdent());
		//56
		final AsmLineWithColon AsmLineWithColon_57_Var
		 = (AsmLineWithColon)AsmLines_40_list.get(2);
		Assert.assertNotNull(AsmLineWithColon_57_Var
		);
		//57
		final AsmLineWithoutColon AsmLineWithoutColon_58_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_57_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_58_Var
		);
		final EList<? extends EObject> AsmLines_58_list = AsmLineWithoutColon_58_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_58_list);
		Assert.assertEquals(1, AsmLines_58_list.size());
		//58
		final AsmLine AsmLine_59_Var
		 = (AsmLine)AsmLines_58_list.get(0);
		Assert.assertNotNull(AsmLine_59_Var
		);
		//59
		final PrimaryExpression PrimaryExpression_60_Var
		 = (PrimaryExpression)AsmLine_59_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_60_Var
		);
		Assert.assertEquals("[\"cc\"]", PrimaryExpression_60_Var
		.getString().toString());
		//60
		final AsmLineWithColon AsmLineWithColon_61_Var
		 = (AsmLineWithColon)AsmLines_40_list.get(3);
		Assert.assertNotNull(AsmLineWithColon_61_Var
		);
		Assert.assertNull(AsmLineWithColon_61_Var
		.getAsmLine());
		//61
		final Statement Statement_62_Var
		 = (Statement)Statement_36_list.get(1);
		Assert.assertNotNull(Statement_62_Var
		);
		//62
		final ExpressionStatement ExpressionStatement_63_Var
		 = (ExpressionStatement)Statement_62_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_63_Var
		);
		//63
		final PostfixExpression PostfixExpression_64_Var
		 = (PostfixExpression)ExpressionStatement_63_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_64_Var
		);
		//64
		final PrimaryExpression PrimaryExpression_65_Var
		 = (PrimaryExpression)PostfixExpression_64_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_65_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_65_Var
		.getIdent());
		//65
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_66_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_64_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_66_Var
		);
		//66
		final ArgumentExpressionList ArgumentExpressionList_67_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_66_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_67_Var
		);
		final EList<? extends EObject> Expr_67_list = ArgumentExpressionList_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(2, Expr_67_list.size());
		//67
		final PrimaryExpression PrimaryExpression_68_Var
		 = (PrimaryExpression)Expr_67_list.get(0);
		Assert.assertNotNull(PrimaryExpression_68_Var
		);
		Assert.assertEquals("[\"Ergebnis: %i\\n\"]", PrimaryExpression_68_Var
		.getString().toString());
		//68
		final PrimaryExpression PrimaryExpression_69_Var
		 = (PrimaryExpression)Expr_67_list.get(1);
		Assert.assertNotNull(PrimaryExpression_69_Var
		);
		Assert.assertEquals("bar", PrimaryExpression_69_Var
		.getIdent());
		//69
		final Statement Statement_70_Var
		 = (Statement)Statement_36_list.get(2);
		Assert.assertNotNull(Statement_70_Var
		);
		//70
		final JumpStatement JumpStatement_71_Var
		 = (JumpStatement)Statement_70_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_71_Var
		);
		//71
		final PrimaryExpression PrimaryExpression_72_Var
		 = (PrimaryExpression)JumpStatement_71_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_72_Var
		);
		//72
		final Constant2 Constant2_73_Var
		 = (Constant2)PrimaryExpression_72_Var
		.getConst();
		Assert.assertNotNull(Constant2_73_Var
		);
		Assert.assertEquals("0", Constant2_73_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_71_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0030_Assembler2.c");
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
				method.invoke(this.generator, "Test0030_Assembler2.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0030_Assembler2.c");
		final String expected = this.getTextFromFile(
			"res/Test0030_Assembler2.c"
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


