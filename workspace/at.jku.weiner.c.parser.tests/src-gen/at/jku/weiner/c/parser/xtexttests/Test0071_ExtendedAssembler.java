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
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
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
import at.jku.weiner.c.parser.parser.AsmStatement;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.AsmSymbolicName;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.AsmSymbolicName;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.AsmSymbolicName;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0071_ExtendedAssembler {
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
			"res/Test0071_ExtendedAssembler.c");
			final String[] expected = new String[] {
				"RULE_KW_UNSIGNED",
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
				"RULE_KW_UNSIGNED",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_KW_UNSIGNED",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_SKW_STAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_SKW_AND",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_IGNORED",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_IGNORED",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_IGNORED",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_ASM1",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACKET",
				"RULE_ID",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACKET",
				"RULE_ID",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_STAR",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACKET",
				"RULE_ID",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
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
			"res/Test0071_ExtendedAssembler.c");
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
		Assert.assertEquals(4, External_0_list.size());
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
		Assert.assertEquals(2, DeclarationSpecifier_3_list.size());
		//3
		final TypeSpecifier TypeSpecifier_4_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(TypeSpecifier_4_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_4_Var
		.getName());
		//4
		final TypeSpecifier TypeSpecifier_5_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(1);
		Assert.assertNotNull(TypeSpecifier_5_Var
		);
		Assert.assertEquals("int", TypeSpecifier_5_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_5_list = Declaration_2_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_5_list);
		Assert.assertEquals(1, InitDeclaratorList_5_list.size());
		//5
		final InitDeclaratorList InitDeclaratorList_6_Var
		 = (InitDeclaratorList)InitDeclaratorList_5_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_6_Var
		);
		final EList<? extends EObject> InitDeclarator_6_list = InitDeclaratorList_6_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_6_list);
		Assert.assertEquals(1, InitDeclarator_6_list.size());
		//6
		final InitDeclarator InitDeclarator_7_Var
		 = (InitDeclarator)InitDeclarator_6_list.get(0);
		Assert.assertNotNull(InitDeclarator_7_Var
		);
		//7
		final Declarator Declarator_8_Var
		 = (Declarator)InitDeclarator_7_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_8_Var
		);
		//8
		final DirectDeclarator DirectDeclarator_9_Var
		 = (DirectDeclarator)Declarator_8_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_9_Var
		);
		Assert.assertEquals("i", DirectDeclarator_9_Var
		.getIdent());
		//9
		final Initializer Initializer_10_Var
		 = (Initializer)InitDeclarator_7_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_10_Var
		);
		//10
		final PrimaryExpression PrimaryExpression_11_Var
		 = (PrimaryExpression)Initializer_10_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_11_Var
		);
		//11
		final Constant2 Constant2_12_Var
		 = (Constant2)PrimaryExpression_11_Var
		.getConst();
		Assert.assertNotNull(Constant2_12_Var
		);
		Assert.assertEquals("0", Constant2_12_Var
		.getDec());
		//12
		final ExternalDeclaration ExternalDeclaration_13_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_13_Var
		);
		//13
		final Declaration Declaration_14_Var
		 = (Declaration)ExternalDeclaration_13_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_14_Var
		);
		//14
		final DeclarationSpecifiers DeclarationSpecifiers_15_Var
		 = (DeclarationSpecifiers)Declaration_14_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_15_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_15_list = DeclarationSpecifiers_15_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_15_list);
		Assert.assertEquals(2, DeclarationSpecifier_15_list.size());
		//15
		final TypeSpecifier TypeSpecifier_16_Var
		 = (TypeSpecifier)DeclarationSpecifier_15_list.get(0);
		Assert.assertNotNull(TypeSpecifier_16_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_16_Var
		.getName());
		//16
		final TypeSpecifier TypeSpecifier_17_Var
		 = (TypeSpecifier)DeclarationSpecifier_15_list.get(1);
		Assert.assertNotNull(TypeSpecifier_17_Var
		);
		Assert.assertEquals("int", TypeSpecifier_17_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_17_list = Declaration_14_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_17_list);
		Assert.assertEquals(1, InitDeclaratorList_17_list.size());
		//17
		final InitDeclaratorList InitDeclaratorList_18_Var
		 = (InitDeclaratorList)InitDeclaratorList_17_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_18_Var
		);
		final EList<? extends EObject> InitDeclarator_18_list = InitDeclaratorList_18_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_18_list);
		Assert.assertEquals(1, InitDeclarator_18_list.size());
		//18
		final InitDeclarator InitDeclarator_19_Var
		 = (InitDeclarator)InitDeclarator_18_list.get(0);
		Assert.assertNotNull(InitDeclarator_19_Var
		);
		//19
		final Declarator Declarator_20_Var
		 = (Declarator)InitDeclarator_19_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_20_Var
		);
		//20
		final DirectDeclarator DirectDeclarator_21_Var
		 = (DirectDeclarator)Declarator_20_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_21_Var
		);
		Assert.assertEquals("j", DirectDeclarator_21_Var
		.getIdent());
		//21
		final ExternalDeclaration ExternalDeclaration_22_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_22_Var
		);
		//22
		final Declaration Declaration_23_Var
		 = (Declaration)ExternalDeclaration_22_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_23_Var
		);
		//23
		final DeclarationSpecifiers DeclarationSpecifiers_24_Var
		 = (DeclarationSpecifiers)Declaration_23_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_24_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_24_list = DeclarationSpecifiers_24_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_24_list);
		Assert.assertEquals(2, DeclarationSpecifier_24_list.size());
		//24
		final TypeSpecifier TypeSpecifier_25_Var
		 = (TypeSpecifier)DeclarationSpecifier_24_list.get(0);
		Assert.assertNotNull(TypeSpecifier_25_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_25_Var
		.getName());
		//25
		final TypeSpecifier TypeSpecifier_26_Var
		 = (TypeSpecifier)DeclarationSpecifier_24_list.get(1);
		Assert.assertNotNull(TypeSpecifier_26_Var
		);
		Assert.assertEquals("int", TypeSpecifier_26_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_26_list = Declaration_23_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_26_list);
		Assert.assertEquals(1, InitDeclaratorList_26_list.size());
		//26
		final InitDeclaratorList InitDeclaratorList_27_Var
		 = (InitDeclaratorList)InitDeclaratorList_26_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_27_Var
		);
		final EList<? extends EObject> InitDeclarator_27_list = InitDeclaratorList_27_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_27_list);
		Assert.assertEquals(1, InitDeclarator_27_list.size());
		//27
		final InitDeclarator InitDeclarator_28_Var
		 = (InitDeclarator)InitDeclarator_27_list.get(0);
		Assert.assertNotNull(InitDeclarator_28_Var
		);
		//28
		final Declarator Declarator_29_Var
		 = (Declarator)InitDeclarator_28_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_29_Var
		);
		//29
		final Pointer Pointer_30_Var
		 = (Pointer)Declarator_29_Var
		.getPointer();
		Assert.assertNotNull(Pointer_30_Var
		);
		Assert.assertEquals("[*]", Pointer_30_Var
		.getStar().toString());
		//30
		final DirectDeclarator DirectDeclarator_31_Var
		 = (DirectDeclarator)Declarator_29_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_31_Var
		);
		Assert.assertEquals("k", DirectDeclarator_31_Var
		.getIdent());
		//31
		final Initializer Initializer_32_Var
		 = (Initializer)InitDeclarator_28_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_32_Var
		);
		//32
		final UnaryExpression UnaryExpression_33_Var
		 = (UnaryExpression)Initializer_32_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_33_Var
		);
		Assert.assertEquals("&", UnaryExpression_33_Var
		.getOp());
		//33
		final PrimaryExpression PrimaryExpression_34_Var
		 = (PrimaryExpression)UnaryExpression_33_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_34_Var
		);
		Assert.assertEquals("i", PrimaryExpression_34_Var
		.getIdent());
		//34
		final ExternalDeclaration ExternalDeclaration_35_Var
		 = (ExternalDeclaration)External_0_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_35_Var
		);
		//35
		final FunctionDefHead FunctionDefHead_36_Var
		 = (FunctionDefHead)ExternalDeclaration_35_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_36_Var
		);
		//36
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_37_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_36_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_37_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_37_list = FunctionDeclarationSpecifiers_37_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_37_list);
		Assert.assertEquals(1, DeclarationSpecifier_37_list.size());
		//37
		final TypeSpecifier TypeSpecifier_38_Var
		 = (TypeSpecifier)DeclarationSpecifier_37_list.get(0);
		Assert.assertNotNull(TypeSpecifier_38_Var
		);
		Assert.assertEquals("void", TypeSpecifier_38_Var
		.getName());
		//38
		final Declarator Declarator_39_Var
		 = (Declarator)FunctionDefHead_36_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_39_Var
		);
		//39
		final DirectDeclarator DirectDeclarator_40_Var
		 = (DirectDeclarator)Declarator_39_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_40_Var
		);
		Assert.assertEquals("foo", DirectDeclarator_40_Var
		.getIdent());
		//40
		final FunctionDefinition FunctionDefinition_41_Var
		 = (FunctionDefinition)ExternalDeclaration_35_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_41_Var
		);
		//41
		final BodyStatement BodyStatement_42_Var
		 = (BodyStatement)FunctionDefinition_41_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_42_Var
		);
		final EList<? extends EObject> BlockList_42_list = BodyStatement_42_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_42_list);
		Assert.assertEquals(1, BlockList_42_list.size());
		//42
		final BlockList BlockList_43_Var
		 = (BlockList)BlockList_42_list.get(0);
		Assert.assertNotNull(BlockList_43_Var
		);
		final EList<? extends EObject> Statement_43_list = BlockList_43_Var
		.getStatement();
		Assert.assertNotNull(Statement_43_list);
		Assert.assertEquals(1, Statement_43_list.size());
		//43
		final Statement Statement_44_Var
		 = (Statement)Statement_43_list.get(0);
		Assert.assertNotNull(Statement_44_Var
		);
		//44
		final AsmStatement AsmStatement_45_Var
		 = (AsmStatement)Statement_44_Var
		.getStmt();
		Assert.assertNotNull(AsmStatement_45_Var
		);
		//45
		final AsmLine AsmLine_46_Var
		 = (AsmLine)AsmStatement_45_Var
		.getAsmLine1();
		Assert.assertNotNull(AsmLine_46_Var
		);
		Assert.assertNull(AsmLine_46_Var
		.getSym());
		//46
		final PrimaryExpression PrimaryExpression_47_Var
		 = (PrimaryExpression)AsmLine_46_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_47_Var
		);
		Assert.assertEquals("[\"mov %[e], %[d]\\n\\t\", \"mov %[f], %[e]\"]", PrimaryExpression_47_Var
		.getString().toString());
		final EList<? extends EObject> AsmLines_47_list = AsmStatement_45_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_47_list);
		Assert.assertEquals(2, AsmLines_47_list.size());
		//47
		final AsmLineWithColon AsmLineWithColon_48_Var
		 = (AsmLineWithColon)AsmLines_47_list.get(0);
		Assert.assertNotNull(AsmLineWithColon_48_Var
		);
		//48
		final AsmLineWithoutColon AsmLineWithoutColon_49_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_48_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_49_Var
		);
		final EList<? extends EObject> AsmLines_49_list = AsmLineWithoutColon_49_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_49_list);
		Assert.assertEquals(1, AsmLines_49_list.size());
		//49
		final AsmLine AsmLine_50_Var
		 = (AsmLine)AsmLines_49_list.get(0);
		Assert.assertNotNull(AsmLine_50_Var
		);
		//50
		final AsmSymbolicName AsmSymbolicName_51_Var
		 = (AsmSymbolicName)AsmLine_50_Var
		.getSym();
		Assert.assertNotNull(AsmSymbolicName_51_Var
		);
		Assert.assertEquals("d", AsmSymbolicName_51_Var
		.getIdent());
		//51
		final PostfixExpression PostfixExpression_52_Var
		 = (PostfixExpression)AsmLine_50_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_52_Var
		);
		//52
		final PrimaryExpression PrimaryExpression_53_Var
		 = (PrimaryExpression)PostfixExpression_52_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_53_Var
		);
		Assert.assertEquals("[\"=rm\"]", PrimaryExpression_53_Var
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
		Assert.assertEquals("i", PrimaryExpression_56_Var
		.getIdent());
		//56
		final AsmLineWithColon AsmLineWithColon_57_Var
		 = (AsmLineWithColon)AsmLines_47_list.get(1);
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
		Assert.assertEquals(3, AsmLines_58_list.size());
		//58
		final AsmLine AsmLine_59_Var
		 = (AsmLine)AsmLines_58_list.get(0);
		Assert.assertNotNull(AsmLine_59_Var
		);
		//59
		final AsmSymbolicName AsmSymbolicName_60_Var
		 = (AsmSymbolicName)AsmLine_59_Var
		.getSym();
		Assert.assertNotNull(AsmSymbolicName_60_Var
		);
		Assert.assertEquals("e", AsmSymbolicName_60_Var
		.getIdent());
		//60
		final PostfixExpression PostfixExpression_61_Var
		 = (PostfixExpression)AsmLine_59_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_61_Var
		);
		//61
		final PrimaryExpression PrimaryExpression_62_Var
		 = (PrimaryExpression)PostfixExpression_61_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_62_Var
		);
		Assert.assertEquals("[\"rm\"]", PrimaryExpression_62_Var
		.getString().toString());
		//62
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_63_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_61_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_63_Var
		);
		//63
		final ArgumentExpressionList ArgumentExpressionList_64_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_63_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_64_Var
		);
		final EList<? extends EObject> Expr_64_list = ArgumentExpressionList_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final UnaryExpression UnaryExpression_65_Var
		 = (UnaryExpression)Expr_64_list.get(0);
		Assert.assertNotNull(UnaryExpression_65_Var
		);
		Assert.assertEquals("*", UnaryExpression_65_Var
		.getOp());
		//65
		final PrimaryExpression PrimaryExpression_66_Var
		 = (PrimaryExpression)UnaryExpression_65_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_66_Var
		);
		Assert.assertEquals("k", PrimaryExpression_66_Var
		.getIdent());
		//66
		final AsmLine AsmLine_67_Var
		 = (AsmLine)AsmLines_58_list.get(1);
		Assert.assertNotNull(AsmLine_67_Var
		);
		//67
		final AsmSymbolicName AsmSymbolicName_68_Var
		 = (AsmSymbolicName)AsmLine_67_Var
		.getSym();
		Assert.assertNotNull(AsmSymbolicName_68_Var
		);
		Assert.assertEquals("f", AsmSymbolicName_68_Var
		.getIdent());
		//68
		final PostfixExpression PostfixExpression_69_Var
		 = (PostfixExpression)AsmLine_67_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_69_Var
		);
		//69
		final PrimaryExpression PrimaryExpression_70_Var
		 = (PrimaryExpression)PostfixExpression_69_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_70_Var
		);
		Assert.assertEquals("[\"i\"]", PrimaryExpression_70_Var
		.getString().toString());
		//70
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_71_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_69_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_71_Var
		);
		//71
		final ArgumentExpressionList ArgumentExpressionList_72_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_71_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_72_Var
		);
		final EList<? extends EObject> Expr_72_list = ArgumentExpressionList_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final PrimaryExpression PrimaryExpression_73_Var
		 = (PrimaryExpression)Expr_72_list.get(0);
		Assert.assertNotNull(PrimaryExpression_73_Var
		);
		//73
		final Constant2 Constant2_74_Var
		 = (Constant2)PrimaryExpression_73_Var
		.getConst();
		Assert.assertNotNull(Constant2_74_Var
		);
		Assert.assertEquals("1", Constant2_74_Var
		.getDec());
		//74
		final AsmLine AsmLine_75_Var
		 = (AsmLine)AsmLines_58_list.get(2);
		Assert.assertNotNull(AsmLine_75_Var
		);
		Assert.assertNull(AsmLine_75_Var
		.getSym());
		//75
		final PostfixExpression PostfixExpression_76_Var
		 = (PostfixExpression)AsmLine_75_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_76_Var
		);
		//76
		final PrimaryExpression PrimaryExpression_77_Var
		 = (PrimaryExpression)PostfixExpression_76_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_77_Var
		);
		Assert.assertEquals("[\"d\"]", PrimaryExpression_77_Var
		.getString().toString());
		//77
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_78_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_76_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_78_Var
		);
		//78
		final ArgumentExpressionList ArgumentExpressionList_79_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_78_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_79_Var
		);
		final EList<? extends EObject> Expr_79_list = ArgumentExpressionList_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final PrimaryExpression PrimaryExpression_80_Var
		 = (PrimaryExpression)Expr_79_list.get(0);
		Assert.assertNotNull(PrimaryExpression_80_Var
		);
		Assert.assertEquals("j", PrimaryExpression_80_Var
		.getIdent());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0071_ExtendedAssembler.c");
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
				method.invoke(this.generator, "Test0071_ExtendedAssembler.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0071_ExtendedAssembler.c");
		final String expected = this.getTextFromFile(
			"res/Test0071_ExtendedAssembler.c"
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


