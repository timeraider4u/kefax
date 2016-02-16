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
import at.jku.weiner.c.parser.parser.StorageClassSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
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
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
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
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
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
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.SelectionStatement;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.CompoundStatement;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0029_Assembler {
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
			"res/Test0029_Assembler.c");
			final String[] expected = new String[] {
				"RULE_BLOCK_COMMENT",
				"RULE_NEWLINE",
				"RULE_KW_EXTERN",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
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
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_SKW_STAR",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_ASM3",
				"RULE_WHITESPACE",
				"RULE_KW_VOLATILE",
				"RULE_SKW_LEFTPAREN",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_BLOCK_COMMENT",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_BLOCK_COMMENT",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_BLOCK_COMMENT",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_BLOCK_COMMENT",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_BLOCK_COMMENT",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_BLOCK_COMMENT",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_BLOCK_COMMENT",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_BLOCK_COMMENT",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_IF",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_MINUS",
				"RULE_DECIMAL_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LESSEQUAL",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ANDAND",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_LESS",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_SKW_MINUS",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_SKW_MINUS",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_ID",
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
			"res/Test0029_Assembler.c");
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
		Assert.assertEquals(2, DeclarationSpecifier_3_list.size());
		//3
		final StorageClassSpecifier StorageClassSpecifier_4_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_4_Var
		);
		Assert.assertEquals("extern", StorageClassSpecifier_4_Var
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
		Assert.assertEquals("errno", DirectDeclarator_9_Var
		.getId());
		//9
		final ExternalDeclaration ExternalDeclaration_10_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_10_Var
		);
		//10
		final FunctionDefHead FunctionDefHead_11_Var
		 = (FunctionDefHead)ExternalDeclaration_10_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_11_Var
		);
		//11
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_12_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_11_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_12_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_12_list = FunctionDeclarationSpecifiers_12_Var
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
		 = (Declarator)FunctionDefHead_11_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_14_Var
		);
		//14
		final DirectDeclarator DirectDeclarator_15_Var
		 = (DirectDeclarator)Declarator_14_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_15_Var
		);
		Assert.assertEquals("funcname", DirectDeclarator_15_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_15_list = DirectDeclarator_15_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_15_list);
		Assert.assertEquals(1, DeclaratorSuffix_15_list.size());
		//15
		final DeclaratorSuffix DeclaratorSuffix_16_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_15_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_16_Var
		);
		//16
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_17_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_16_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_17_Var
		);
		final EList<? extends EObject> ParameterTypeList_17_list = DirectDeclaratorLastSuffix_17_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_17_list);
		Assert.assertEquals(1, ParameterTypeList_17_list.size());
		//17
		final ParameterTypeList ParameterTypeList_18_Var
		 = (ParameterTypeList)ParameterTypeList_17_list.get(0);
		Assert.assertNotNull(ParameterTypeList_18_Var
		);
		//18
		final ParameterList ParameterList_19_Var
		 = (ParameterList)ParameterTypeList_18_Var
		.getList();
		Assert.assertNotNull(ParameterList_19_Var
		);
		final EList<? extends EObject> ParameterDeclaration_19_list = ParameterList_19_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_19_list);
		Assert.assertEquals(3, ParameterDeclaration_19_list.size());
		//19
		final ParameterDeclaration ParameterDeclaration_20_Var
		 = (ParameterDeclaration)ParameterDeclaration_19_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_20_Var
		);
		//20
		final DeclarationSpecifiers DeclarationSpecifiers_21_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_20_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_21_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_21_list = DeclarationSpecifiers_21_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_21_list);
		Assert.assertEquals(1, DeclarationSpecifier_21_list.size());
		//21
		final TypeSpecifier TypeSpecifier_22_Var
		 = (TypeSpecifier)DeclarationSpecifier_21_list.get(0);
		Assert.assertNotNull(TypeSpecifier_22_Var
		);
		Assert.assertEquals("int", TypeSpecifier_22_Var
		.getName());
		//22
		final Declarator Declarator_23_Var
		 = (Declarator)ParameterDeclaration_20_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_23_Var
		);
		//23
		final DirectDeclarator DirectDeclarator_24_Var
		 = (DirectDeclarator)Declarator_23_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_24_Var
		);
		Assert.assertEquals("arg1", DirectDeclarator_24_Var
		.getId());
		//24
		final ParameterDeclaration ParameterDeclaration_25_Var
		 = (ParameterDeclaration)ParameterDeclaration_19_list.get(1);
		Assert.assertNotNull(ParameterDeclaration_25_Var
		);
		//25
		final DeclarationSpecifiers DeclarationSpecifiers_26_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_25_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_26_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_26_list = DeclarationSpecifiers_26_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_26_list);
		Assert.assertEquals(1, DeclarationSpecifier_26_list.size());
		//26
		final TypeSpecifier TypeSpecifier_27_Var
		 = (TypeSpecifier)DeclarationSpecifier_26_list.get(0);
		Assert.assertNotNull(TypeSpecifier_27_Var
		);
		Assert.assertEquals("int", TypeSpecifier_27_Var
		.getName());
		//27
		final Declarator Declarator_28_Var
		 = (Declarator)ParameterDeclaration_25_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_28_Var
		);
		//28
		final DirectDeclarator DirectDeclarator_29_Var
		 = (DirectDeclarator)Declarator_28_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_29_Var
		);
		Assert.assertEquals("arg2", DirectDeclarator_29_Var
		.getId());
		//29
		final Pointer Pointer_30_Var
		 = (Pointer)Declarator_28_Var
		.getPointer();
		Assert.assertNotNull(Pointer_30_Var
		);
		Assert.assertEquals("[*]", Pointer_30_Var
		.getStar().toString());
		//30
		final ParameterDeclaration ParameterDeclaration_31_Var
		 = (ParameterDeclaration)ParameterDeclaration_19_list.get(2);
		Assert.assertNotNull(ParameterDeclaration_31_Var
		);
		//31
		final DeclarationSpecifiers DeclarationSpecifiers_32_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_31_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_32_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_32_list = DeclarationSpecifiers_32_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_32_list);
		Assert.assertEquals(1, DeclarationSpecifier_32_list.size());
		//32
		final TypeSpecifier TypeSpecifier_33_Var
		 = (TypeSpecifier)DeclarationSpecifier_32_list.get(0);
		Assert.assertNotNull(TypeSpecifier_33_Var
		);
		Assert.assertEquals("int", TypeSpecifier_33_Var
		.getName());
		//33
		final Declarator Declarator_34_Var
		 = (Declarator)ParameterDeclaration_31_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_34_Var
		);
		//34
		final DirectDeclarator DirectDeclarator_35_Var
		 = (DirectDeclarator)Declarator_34_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_35_Var
		);
		Assert.assertEquals("arg3", DirectDeclarator_35_Var
		.getId());
		//35
		final FunctionDefinition FunctionDefinition_36_Var
		 = (FunctionDefinition)ExternalDeclaration_10_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_36_Var
		);
		//36
		final BodyStatement BodyStatement_37_Var
		 = (BodyStatement)FunctionDefinition_36_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_37_Var
		);
		final EList<? extends EObject> BlockList_37_list = BodyStatement_37_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_37_list);
		Assert.assertEquals(1, BlockList_37_list.size());
		//37
		final BlockList BlockList_38_Var
		 = (BlockList)BlockList_37_list.get(0);
		Assert.assertNotNull(BlockList_38_Var
		);
		final EList<? extends EObject> Declaration_38_list = BlockList_38_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_38_list);
		Assert.assertEquals(1, Declaration_38_list.size());
		//38
		final Declaration Declaration_39_Var
		 = (Declaration)Declaration_38_list.get(0);
		Assert.assertNotNull(Declaration_39_Var
		);
		//39
		final DeclarationSpecifiers DeclarationSpecifiers_40_Var
		 = (DeclarationSpecifiers)Declaration_39_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_40_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_40_list = DeclarationSpecifiers_40_Var
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
		final EList<? extends EObject> InitDeclaratorList_41_list = Declaration_39_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_41_list);
		Assert.assertEquals(1, InitDeclaratorList_41_list.size());
		//41
		final InitDeclaratorList InitDeclaratorList_42_Var
		 = (InitDeclaratorList)InitDeclaratorList_41_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_42_Var
		);
		final EList<? extends EObject> InitDeclarator_42_list = InitDeclaratorList_42_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_42_list);
		Assert.assertEquals(1, InitDeclarator_42_list.size());
		//42
		final InitDeclarator InitDeclarator_43_Var
		 = (InitDeclarator)InitDeclarator_42_list.get(0);
		Assert.assertNotNull(InitDeclarator_43_Var
		);
		//43
		final Declarator Declarator_44_Var
		 = (Declarator)InitDeclarator_43_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_44_Var
		);
		//44
		final DirectDeclarator DirectDeclarator_45_Var
		 = (DirectDeclarator)Declarator_44_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_45_Var
		);
		Assert.assertEquals("res", DirectDeclarator_45_Var
		.getId());
		final EList<? extends EObject> Statement_45_list = BlockList_38_Var
		.getStatement();
		Assert.assertNotNull(Statement_45_list);
		Assert.assertEquals(3, Statement_45_list.size());
		//45
		final Statement Statement_46_Var
		 = (Statement)Statement_45_list.get(0);
		Assert.assertNotNull(Statement_46_Var
		);
		//46
		final AsmStatement AsmStatement_47_Var
		 = (AsmStatement)Statement_46_Var
		.getStmt();
		Assert.assertNotNull(AsmStatement_47_Var
		);
		//47
		final AsmLine AsmLine_48_Var
		 = (AsmLine)AsmStatement_47_Var
		.getAsmLine1();
		Assert.assertNotNull(AsmLine_48_Var
		);
		//48
		final PrimaryExpression PrimaryExpression_49_Var
		 = (PrimaryExpression)AsmLine_48_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_49_Var
		);
		Assert.assertEquals("[\"int $0x80\"]", PrimaryExpression_49_Var
		.getString().toString());
		final EList<? extends EObject> AsmLines_49_list = AsmStatement_47_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_49_list);
		Assert.assertEquals(3, AsmLines_49_list.size());
		//49
		final AsmLineWithColon AsmLineWithColon_50_Var
		 = (AsmLineWithColon)AsmLines_49_list.get(0);
		Assert.assertNotNull(AsmLineWithColon_50_Var
		);
		//50
		final AsmLineWithoutColon AsmLineWithoutColon_51_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_50_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_51_Var
		);
		final EList<? extends EObject> AsmLines_51_list = AsmLineWithoutColon_51_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_51_list);
		Assert.assertEquals(4, AsmLines_51_list.size());
		//51
		final AsmLine AsmLine_52_Var
		 = (AsmLine)AsmLines_51_list.get(0);
		Assert.assertNotNull(AsmLine_52_Var
		);
		//52
		final PostfixExpression PostfixExpression_53_Var
		 = (PostfixExpression)AsmLine_52_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_53_Var
		);
		//53
		final PrimaryExpression PrimaryExpression_54_Var
		 = (PrimaryExpression)PostfixExpression_53_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_54_Var
		);
		Assert.assertEquals("[\"=a\"]", PrimaryExpression_54_Var
		.getString().toString());
		//54
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_55_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_53_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_55_Var
		);
		//55
		final ArgumentExpressionList ArgumentExpressionList_56_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_55_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_56_Var
		);
		final EList<? extends EObject> Expr_56_list = ArgumentExpressionList_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final PrimaryExpression PrimaryExpression_57_Var
		 = (PrimaryExpression)Expr_56_list.get(0);
		Assert.assertNotNull(PrimaryExpression_57_Var
		);
		Assert.assertEquals("res", PrimaryExpression_57_Var
		.getId());
		//57
		final AsmLine AsmLine_58_Var
		 = (AsmLine)AsmLines_51_list.get(1);
		Assert.assertNotNull(AsmLine_58_Var
		);
		//58
		final PostfixExpression PostfixExpression_59_Var
		 = (PostfixExpression)AsmLine_58_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_59_Var
		);
		//59
		final PrimaryExpression PrimaryExpression_60_Var
		 = (PrimaryExpression)PostfixExpression_59_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_60_Var
		);
		Assert.assertEquals("[\"+b\"]", PrimaryExpression_60_Var
		.getString().toString());
		//60
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_61_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_59_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_61_Var
		);
		//61
		final ArgumentExpressionList ArgumentExpressionList_62_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_61_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_62_Var
		);
		final EList<? extends EObject> Expr_62_list = ArgumentExpressionList_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final PrimaryExpression PrimaryExpression_63_Var
		 = (PrimaryExpression)Expr_62_list.get(0);
		Assert.assertNotNull(PrimaryExpression_63_Var
		);
		Assert.assertEquals("arg1", PrimaryExpression_63_Var
		.getId());
		//63
		final AsmLine AsmLine_64_Var
		 = (AsmLine)AsmLines_51_list.get(2);
		Assert.assertNotNull(AsmLine_64_Var
		);
		//64
		final PostfixExpression PostfixExpression_65_Var
		 = (PostfixExpression)AsmLine_64_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_65_Var
		);
		//65
		final PrimaryExpression PrimaryExpression_66_Var
		 = (PrimaryExpression)PostfixExpression_65_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_66_Var
		);
		Assert.assertEquals("[\"+c\"]", PrimaryExpression_66_Var
		.getString().toString());
		//66
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_67_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_65_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_67_Var
		);
		//67
		final ArgumentExpressionList ArgumentExpressionList_68_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_67_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_68_Var
		);
		final EList<? extends EObject> Expr_68_list = ArgumentExpressionList_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final PrimaryExpression PrimaryExpression_69_Var
		 = (PrimaryExpression)Expr_68_list.get(0);
		Assert.assertNotNull(PrimaryExpression_69_Var
		);
		Assert.assertEquals("arg2", PrimaryExpression_69_Var
		.getId());
		//69
		final AsmLine AsmLine_70_Var
		 = (AsmLine)AsmLines_51_list.get(3);
		Assert.assertNotNull(AsmLine_70_Var
		);
		//70
		final PostfixExpression PostfixExpression_71_Var
		 = (PostfixExpression)AsmLine_70_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_71_Var
		);
		//71
		final PrimaryExpression PrimaryExpression_72_Var
		 = (PrimaryExpression)PostfixExpression_71_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_72_Var
		);
		Assert.assertEquals("[\"+d\"]", PrimaryExpression_72_Var
		.getString().toString());
		//72
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_73_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_71_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_73_Var
		);
		//73
		final ArgumentExpressionList ArgumentExpressionList_74_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_73_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_74_Var
		);
		final EList<? extends EObject> Expr_74_list = ArgumentExpressionList_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final PrimaryExpression PrimaryExpression_75_Var
		 = (PrimaryExpression)Expr_74_list.get(0);
		Assert.assertNotNull(PrimaryExpression_75_Var
		);
		Assert.assertEquals("arg3", PrimaryExpression_75_Var
		.getId());
		//75
		final AsmLineWithColon AsmLineWithColon_76_Var
		 = (AsmLineWithColon)AsmLines_49_list.get(1);
		Assert.assertNotNull(AsmLineWithColon_76_Var
		);
		//76
		final AsmLineWithoutColon AsmLineWithoutColon_77_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_76_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_77_Var
		);
		final EList<? extends EObject> AsmLines_77_list = AsmLineWithoutColon_77_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_77_list);
		Assert.assertEquals(1, AsmLines_77_list.size());
		//77
		final AsmLine AsmLine_78_Var
		 = (AsmLine)AsmLines_77_list.get(0);
		Assert.assertNotNull(AsmLine_78_Var
		);
		//78
		final PostfixExpression PostfixExpression_79_Var
		 = (PostfixExpression)AsmLine_78_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_79_Var
		);
		//79
		final PrimaryExpression PrimaryExpression_80_Var
		 = (PrimaryExpression)PostfixExpression_79_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_80_Var
		);
		Assert.assertEquals("[\"a\"]", PrimaryExpression_80_Var
		.getString().toString());
		//80
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_81_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_79_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_81_Var
		);
		//81
		final ArgumentExpressionList ArgumentExpressionList_82_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_81_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_82_Var
		);
		final EList<? extends EObject> Expr_82_list = ArgumentExpressionList_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final PrimaryExpression PrimaryExpression_83_Var
		 = (PrimaryExpression)Expr_82_list.get(0);
		Assert.assertNotNull(PrimaryExpression_83_Var
		);
		//83
		final Constant2 Constant2_84_Var
		 = (Constant2)PrimaryExpression_83_Var
		.getConst();
		Assert.assertNotNull(Constant2_84_Var
		);
		Assert.assertEquals("128", Constant2_84_Var
		.getDec());
		//84
		final AsmLineWithColon AsmLineWithColon_85_Var
		 = (AsmLineWithColon)AsmLines_49_list.get(2);
		Assert.assertNotNull(AsmLineWithColon_85_Var
		);
		//85
		final AsmLineWithoutColon AsmLineWithoutColon_86_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_85_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_86_Var
		);
		final EList<? extends EObject> AsmLines_86_list = AsmLineWithoutColon_86_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_86_list);
		Assert.assertEquals(2, AsmLines_86_list.size());
		//86
		final AsmLine AsmLine_87_Var
		 = (AsmLine)AsmLines_86_list.get(0);
		Assert.assertNotNull(AsmLine_87_Var
		);
		//87
		final PrimaryExpression PrimaryExpression_88_Var
		 = (PrimaryExpression)AsmLine_87_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_88_Var
		);
		Assert.assertEquals("[\"memory\"]", PrimaryExpression_88_Var
		.getString().toString());
		//88
		final AsmLine AsmLine_89_Var
		 = (AsmLine)AsmLines_86_list.get(1);
		Assert.assertNotNull(AsmLine_89_Var
		);
		//89
		final PrimaryExpression PrimaryExpression_90_Var
		 = (PrimaryExpression)AsmLine_89_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_90_Var
		);
		Assert.assertEquals("[\"cc\"]", PrimaryExpression_90_Var
		.getString().toString());
		//90
		final Statement Statement_91_Var
		 = (Statement)Statement_45_list.get(1);
		Assert.assertNotNull(Statement_91_Var
		);
		//91
		final SelectionStatement SelectionStatement_92_Var
		 = (SelectionStatement)Statement_91_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_92_Var
		);
		Assert.assertEquals("if", SelectionStatement_92_Var
		.getIf());
		//92
		final LogicalAndExpression LogicalAndExpression_93_Var
		 = (LogicalAndExpression)SelectionStatement_92_Var
		.getExpr();
		Assert.assertNotNull(LogicalAndExpression_93_Var
		);
		//93
		final RelationalExpression RelationalExpression_94_Var
		 = (RelationalExpression)LogicalAndExpression_93_Var
		.getLeft();
		Assert.assertNotNull(RelationalExpression_94_Var
		);
		Assert.assertEquals("<=", RelationalExpression_94_Var
		.getOp());
		//94
		final UnaryExpression UnaryExpression_95_Var
		 = (UnaryExpression)RelationalExpression_94_Var
		.getLeft();
		Assert.assertNotNull(UnaryExpression_95_Var
		);
		//95
		final PrimaryExpression PrimaryExpression_96_Var
		 = (PrimaryExpression)UnaryExpression_95_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_96_Var
		);
		//96
		final Constant2 Constant2_97_Var
		 = (Constant2)PrimaryExpression_96_Var
		.getConst();
		Assert.assertNotNull(Constant2_97_Var
		);
		Assert.assertEquals("125", Constant2_97_Var
		.getDec());
		Assert.assertEquals("-", UnaryExpression_95_Var
		.getOp());
		//97
		final PrimaryExpression PrimaryExpression_98_Var
		 = (PrimaryExpression)RelationalExpression_94_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_98_Var
		);
		Assert.assertEquals("res", PrimaryExpression_98_Var
		.getId());
		//98
		final RelationalExpression RelationalExpression_99_Var
		 = (RelationalExpression)LogicalAndExpression_93_Var
		.getRight();
		Assert.assertNotNull(RelationalExpression_99_Var
		);
		Assert.assertEquals("<", RelationalExpression_99_Var
		.getOp());
		//99
		final PrimaryExpression PrimaryExpression_100_Var
		 = (PrimaryExpression)RelationalExpression_99_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_100_Var
		);
		Assert.assertEquals("res", PrimaryExpression_100_Var
		.getId());
		//100
		final PrimaryExpression PrimaryExpression_101_Var
		 = (PrimaryExpression)RelationalExpression_99_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_101_Var
		);
		//101
		final Constant2 Constant2_102_Var
		 = (Constant2)PrimaryExpression_101_Var
		.getConst();
		Assert.assertNotNull(Constant2_102_Var
		);
		Assert.assertEquals("0", Constant2_102_Var
		.getDec());
		//102
		final Statement Statement_103_Var
		 = (Statement)SelectionStatement_92_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_103_Var
		);
		//103
		final CompoundStatement CompoundStatement_104_Var
		 = (CompoundStatement)Statement_103_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_104_Var
		);
		//104
		final BodyStatement BodyStatement_105_Var
		 = (BodyStatement)CompoundStatement_104_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_105_Var
		);
		final EList<? extends EObject> BlockList_105_list = BodyStatement_105_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_105_list);
		Assert.assertEquals(1, BlockList_105_list.size());
		//105
		final BlockList BlockList_106_Var
		 = (BlockList)BlockList_105_list.get(0);
		Assert.assertNotNull(BlockList_106_Var
		);
		final EList<? extends EObject> Statement_106_list = BlockList_106_Var
		.getStatement();
		Assert.assertNotNull(Statement_106_list);
		Assert.assertEquals(2, Statement_106_list.size());
		//106
		final Statement Statement_107_Var
		 = (Statement)Statement_106_list.get(0);
		Assert.assertNotNull(Statement_107_Var
		);
		//107
		final ExpressionStatement ExpressionStatement_108_Var
		 = (ExpressionStatement)Statement_107_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_108_Var
		);
		//108
		final AssignmentExpression AssignmentExpression_109_Var
		 = (AssignmentExpression)ExpressionStatement_108_Var
		.getExpression();
		Assert.assertNotNull(AssignmentExpression_109_Var
		);
		//109
		final PrimaryExpression PrimaryExpression_110_Var
		 = (PrimaryExpression)AssignmentExpression_109_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_110_Var
		);
		Assert.assertEquals("errno", PrimaryExpression_110_Var
		.getId());
		Assert.assertEquals("=", AssignmentExpression_109_Var
		.getOp());
		//110
		final UnaryExpression UnaryExpression_111_Var
		 = (UnaryExpression)AssignmentExpression_109_Var
		.getAssignmentExpr();
		Assert.assertNotNull(UnaryExpression_111_Var
		);
		Assert.assertEquals("-", UnaryExpression_111_Var
		.getOp());
		//111
		final PrimaryExpression PrimaryExpression_112_Var
		 = (PrimaryExpression)UnaryExpression_111_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_112_Var
		);
		Assert.assertEquals("res", PrimaryExpression_112_Var
		.getId());
		//112
		final Statement Statement_113_Var
		 = (Statement)Statement_106_list.get(1);
		Assert.assertNotNull(Statement_113_Var
		);
		//113
		final ExpressionStatement ExpressionStatement_114_Var
		 = (ExpressionStatement)Statement_113_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_114_Var
		);
		//114
		final AssignmentExpression AssignmentExpression_115_Var
		 = (AssignmentExpression)ExpressionStatement_114_Var
		.getExpression();
		Assert.assertNotNull(AssignmentExpression_115_Var
		);
		//115
		final PrimaryExpression PrimaryExpression_116_Var
		 = (PrimaryExpression)AssignmentExpression_115_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_116_Var
		);
		Assert.assertEquals("res", PrimaryExpression_116_Var
		.getId());
		Assert.assertEquals("=", AssignmentExpression_115_Var
		.getOp());
		//116
		final UnaryExpression UnaryExpression_117_Var
		 = (UnaryExpression)AssignmentExpression_115_Var
		.getAssignmentExpr();
		Assert.assertNotNull(UnaryExpression_117_Var
		);
		Assert.assertEquals("-", UnaryExpression_117_Var
		.getOp());
		//117
		final PrimaryExpression PrimaryExpression_118_Var
		 = (PrimaryExpression)UnaryExpression_117_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_118_Var
		);
		//118
		final Constant2 Constant2_119_Var
		 = (Constant2)PrimaryExpression_118_Var
		.getConst();
		Assert.assertNotNull(Constant2_119_Var
		);
		Assert.assertEquals("1", Constant2_119_Var
		.getDec());
		//119
		final Statement Statement_120_Var
		 = (Statement)Statement_45_list.get(2);
		Assert.assertNotNull(Statement_120_Var
		);
		//120
		final JumpStatement JumpStatement_121_Var
		 = (JumpStatement)Statement_120_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_121_Var
		);
		//121
		final PrimaryExpression PrimaryExpression_122_Var
		 = (PrimaryExpression)JumpStatement_121_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_122_Var
		);
		Assert.assertEquals("res", PrimaryExpression_122_Var
		.getId());
		Assert.assertEquals("return", JumpStatement_121_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0029_Assembler.c");
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
				method.invoke(this.generator, "Test0029_Assembler.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0029_Assembler.c");
		final String expected = this.getTextFromFile(
			"res/Test0029_Assembler.c"
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


