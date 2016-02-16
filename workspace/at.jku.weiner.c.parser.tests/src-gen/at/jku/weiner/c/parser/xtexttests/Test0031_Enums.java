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
import at.jku.weiner.c.parser.parser.TypeQualifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.parser.parser.EnumSpecifier;
import at.jku.weiner.c.parser.parser.EnumeratorList;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.EnumSpecifier;
import at.jku.weiner.c.parser.parser.EnumeratorList;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.EnumSpecifier;
import at.jku.weiner.c.parser.parser.EnumeratorList;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.EnumSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
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
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
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
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0031_Enums {
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
			"res/Test0031_Enums.c");
			final String[] expected = new String[] {
				"RULE_LINEDIRECTIVE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_CONST",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_ENUM",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_ASSIGN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_ENUM",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_ASSIGN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTBRACE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_ENUM",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_ASSIGN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTBRACE",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_KW_ENUM",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_ID",
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
				"RULE_STRING_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_ID",
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
			"res/Test0031_Enums.c");
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
		Assert.assertEquals(6, External_0_list.size());
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
		final TypeQualifier TypeQualifier_4_Var
		 = (TypeQualifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(TypeQualifier_4_Var
		);
		Assert.assertEquals("const", TypeQualifier_4_Var
		.getType());
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
		Assert.assertEquals(7, InitDeclarator_6_list.size());
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
		Assert.assertEquals("W_MONDAY", DirectDeclarator_9_Var
		.getId());
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
		Assert.assertEquals("1", Constant2_12_Var
		.getDec());
		//12
		final InitDeclarator InitDeclarator_13_Var
		 = (InitDeclarator)InitDeclarator_6_list.get(1);
		Assert.assertNotNull(InitDeclarator_13_Var
		);
		//13
		final Declarator Declarator_14_Var
		 = (Declarator)InitDeclarator_13_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_14_Var
		);
		//14
		final DirectDeclarator DirectDeclarator_15_Var
		 = (DirectDeclarator)Declarator_14_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_15_Var
		);
		Assert.assertEquals("W_TUESDAY", DirectDeclarator_15_Var
		.getId());
		//15
		final Initializer Initializer_16_Var
		 = (Initializer)InitDeclarator_13_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_16_Var
		);
		//16
		final PrimaryExpression PrimaryExpression_17_Var
		 = (PrimaryExpression)Initializer_16_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_17_Var
		);
		//17
		final Constant2 Constant2_18_Var
		 = (Constant2)PrimaryExpression_17_Var
		.getConst();
		Assert.assertNotNull(Constant2_18_Var
		);
		Assert.assertEquals("2", Constant2_18_Var
		.getDec());
		//18
		final InitDeclarator InitDeclarator_19_Var
		 = (InitDeclarator)InitDeclarator_6_list.get(2);
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
		Assert.assertEquals("W_WEDNESDAY", DirectDeclarator_21_Var
		.getId());
		//21
		final Initializer Initializer_22_Var
		 = (Initializer)InitDeclarator_19_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_22_Var
		);
		//22
		final PrimaryExpression PrimaryExpression_23_Var
		 = (PrimaryExpression)Initializer_22_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_23_Var
		);
		//23
		final Constant2 Constant2_24_Var
		 = (Constant2)PrimaryExpression_23_Var
		.getConst();
		Assert.assertNotNull(Constant2_24_Var
		);
		Assert.assertEquals("3", Constant2_24_Var
		.getDec());
		//24
		final InitDeclarator InitDeclarator_25_Var
		 = (InitDeclarator)InitDeclarator_6_list.get(3);
		Assert.assertNotNull(InitDeclarator_25_Var
		);
		//25
		final Declarator Declarator_26_Var
		 = (Declarator)InitDeclarator_25_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_26_Var
		);
		//26
		final DirectDeclarator DirectDeclarator_27_Var
		 = (DirectDeclarator)Declarator_26_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_27_Var
		);
		Assert.assertEquals("W_THURSDAY", DirectDeclarator_27_Var
		.getId());
		//27
		final Initializer Initializer_28_Var
		 = (Initializer)InitDeclarator_25_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_28_Var
		);
		//28
		final PrimaryExpression PrimaryExpression_29_Var
		 = (PrimaryExpression)Initializer_28_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_29_Var
		);
		//29
		final Constant2 Constant2_30_Var
		 = (Constant2)PrimaryExpression_29_Var
		.getConst();
		Assert.assertNotNull(Constant2_30_Var
		);
		Assert.assertEquals("4", Constant2_30_Var
		.getDec());
		//30
		final InitDeclarator InitDeclarator_31_Var
		 = (InitDeclarator)InitDeclarator_6_list.get(4);
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
		Assert.assertEquals("W_FRIDAY", DirectDeclarator_33_Var
		.getId());
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
		Assert.assertEquals("5", Constant2_36_Var
		.getDec());
		//36
		final InitDeclarator InitDeclarator_37_Var
		 = (InitDeclarator)InitDeclarator_6_list.get(5);
		Assert.assertNotNull(InitDeclarator_37_Var
		);
		//37
		final Declarator Declarator_38_Var
		 = (Declarator)InitDeclarator_37_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_38_Var
		);
		//38
		final DirectDeclarator DirectDeclarator_39_Var
		 = (DirectDeclarator)Declarator_38_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_39_Var
		);
		Assert.assertEquals("W_SATURDAY", DirectDeclarator_39_Var
		.getId());
		//39
		final Initializer Initializer_40_Var
		 = (Initializer)InitDeclarator_37_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_40_Var
		);
		//40
		final PrimaryExpression PrimaryExpression_41_Var
		 = (PrimaryExpression)Initializer_40_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_41_Var
		);
		//41
		final Constant2 Constant2_42_Var
		 = (Constant2)PrimaryExpression_41_Var
		.getConst();
		Assert.assertNotNull(Constant2_42_Var
		);
		Assert.assertEquals("6", Constant2_42_Var
		.getDec());
		//42
		final InitDeclarator InitDeclarator_43_Var
		 = (InitDeclarator)InitDeclarator_6_list.get(6);
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
		Assert.assertEquals("W_SUNDAY", DirectDeclarator_45_Var
		.getId());
		//45
		final Initializer Initializer_46_Var
		 = (Initializer)InitDeclarator_43_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_46_Var
		);
		//46
		final PrimaryExpression PrimaryExpression_47_Var
		 = (PrimaryExpression)Initializer_46_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_47_Var
		);
		//47
		final Constant2 Constant2_48_Var
		 = (Constant2)PrimaryExpression_47_Var
		.getConst();
		Assert.assertNotNull(Constant2_48_Var
		);
		Assert.assertEquals("7", Constant2_48_Var
		.getDec());
		//48
		final ExternalDeclaration ExternalDeclaration_49_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_49_Var
		);
		//49
		final Declaration Declaration_50_Var
		 = (Declaration)ExternalDeclaration_49_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_50_Var
		);
		//50
		final DeclarationSpecifiers DeclarationSpecifiers_51_Var
		 = (DeclarationSpecifiers)Declaration_50_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_51_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_51_list = DeclarationSpecifiers_51_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_51_list);
		Assert.assertEquals(1, DeclarationSpecifier_51_list.size());
		//51
		final TypeSpecifier TypeSpecifier_52_Var
		 = (TypeSpecifier)DeclarationSpecifier_51_list.get(0);
		Assert.assertNotNull(TypeSpecifier_52_Var
		);
		//52
		final EnumSpecifier EnumSpecifier_53_Var
		 = (EnumSpecifier)TypeSpecifier_52_Var
		.getSpecifier();
		Assert.assertNotNull(EnumSpecifier_53_Var
		);
		//53
		final EnumeratorList EnumeratorList_54_Var
		 = (EnumeratorList)EnumSpecifier_53_Var
		.getEnumList();
		Assert.assertNotNull(EnumeratorList_54_Var
		);
		final EList<? extends EObject> Enumerator_54_list = EnumeratorList_54_Var
		.getEnumerator();
		Assert.assertNotNull(Enumerator_54_list);
		Assert.assertEquals(7, Enumerator_54_list.size());
		//54
		final Enumerator Enumerator_55_Var
		 = (Enumerator)Enumerator_54_list.get(0);
		Assert.assertNotNull(Enumerator_55_Var
		);
		Assert.assertEquals("MONDAY", Enumerator_55_Var
		.getId());
		//55
		final PrimaryExpression PrimaryExpression_56_Var
		 = (PrimaryExpression)Enumerator_55_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_56_Var
		);
		//56
		final Constant2 Constant2_57_Var
		 = (Constant2)PrimaryExpression_56_Var
		.getConst();
		Assert.assertNotNull(Constant2_57_Var
		);
		Assert.assertEquals("1", Constant2_57_Var
		.getDec());
		//57
		final Enumerator Enumerator_58_Var
		 = (Enumerator)Enumerator_54_list.get(1);
		Assert.assertNotNull(Enumerator_58_Var
		);
		Assert.assertEquals("TUESDAY", Enumerator_58_Var
		.getId());
		//58
		final Enumerator Enumerator_59_Var
		 = (Enumerator)Enumerator_54_list.get(2);
		Assert.assertNotNull(Enumerator_59_Var
		);
		Assert.assertEquals("WEDNESDAY", Enumerator_59_Var
		.getId());
		//59
		final Enumerator Enumerator_60_Var
		 = (Enumerator)Enumerator_54_list.get(3);
		Assert.assertNotNull(Enumerator_60_Var
		);
		Assert.assertEquals("THURSDAY", Enumerator_60_Var
		.getId());
		//60
		final Enumerator Enumerator_61_Var
		 = (Enumerator)Enumerator_54_list.get(4);
		Assert.assertNotNull(Enumerator_61_Var
		);
		Assert.assertEquals("FRIDAY", Enumerator_61_Var
		.getId());
		//61
		final Enumerator Enumerator_62_Var
		 = (Enumerator)Enumerator_54_list.get(5);
		Assert.assertNotNull(Enumerator_62_Var
		);
		Assert.assertEquals("SATURDAY", Enumerator_62_Var
		.getId());
		//62
		final Enumerator Enumerator_63_Var
		 = (Enumerator)Enumerator_54_list.get(6);
		Assert.assertNotNull(Enumerator_63_Var
		);
		Assert.assertEquals("SUNDAY", Enumerator_63_Var
		.getId());
		//63
		final ExternalDeclaration ExternalDeclaration_64_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_64_Var
		);
		//64
		final Declaration Declaration_65_Var
		 = (Declaration)ExternalDeclaration_64_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_65_Var
		);
		//65
		final DeclarationSpecifiers DeclarationSpecifiers_66_Var
		 = (DeclarationSpecifiers)Declaration_65_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_66_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_66_list = DeclarationSpecifiers_66_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_66_list);
		Assert.assertEquals(1, DeclarationSpecifier_66_list.size());
		//66
		final TypeSpecifier TypeSpecifier_67_Var
		 = (TypeSpecifier)DeclarationSpecifier_66_list.get(0);
		Assert.assertNotNull(TypeSpecifier_67_Var
		);
		//67
		final EnumSpecifier EnumSpecifier_68_Var
		 = (EnumSpecifier)TypeSpecifier_67_Var
		.getSpecifier();
		Assert.assertNotNull(EnumSpecifier_68_Var
		);
		//68
		final EnumeratorList EnumeratorList_69_Var
		 = (EnumeratorList)EnumSpecifier_68_Var
		.getEnumList();
		Assert.assertNotNull(EnumeratorList_69_Var
		);
		final EList<? extends EObject> Enumerator_69_list = EnumeratorList_69_Var
		.getEnumerator();
		Assert.assertNotNull(Enumerator_69_list);
		Assert.assertEquals(7, Enumerator_69_list.size());
		//69
		final Enumerator Enumerator_70_Var
		 = (Enumerator)Enumerator_69_list.get(0);
		Assert.assertNotNull(Enumerator_70_Var
		);
		Assert.assertEquals("I_MONDAY", Enumerator_70_Var
		.getId());
		//70
		final PrimaryExpression PrimaryExpression_71_Var
		 = (PrimaryExpression)Enumerator_70_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_71_Var
		);
		//71
		final Constant2 Constant2_72_Var
		 = (Constant2)PrimaryExpression_71_Var
		.getConst();
		Assert.assertNotNull(Constant2_72_Var
		);
		Assert.assertEquals("1", Constant2_72_Var
		.getDec());
		//72
		final Enumerator Enumerator_73_Var
		 = (Enumerator)Enumerator_69_list.get(1);
		Assert.assertNotNull(Enumerator_73_Var
		);
		Assert.assertEquals("I_TUESDAY", Enumerator_73_Var
		.getId());
		//73
		final Enumerator Enumerator_74_Var
		 = (Enumerator)Enumerator_69_list.get(2);
		Assert.assertNotNull(Enumerator_74_Var
		);
		Assert.assertEquals("I_WEDNESDAY", Enumerator_74_Var
		.getId());
		//74
		final Enumerator Enumerator_75_Var
		 = (Enumerator)Enumerator_69_list.get(3);
		Assert.assertNotNull(Enumerator_75_Var
		);
		Assert.assertEquals("I_THURSDAY", Enumerator_75_Var
		.getId());
		//75
		final Enumerator Enumerator_76_Var
		 = (Enumerator)Enumerator_69_list.get(4);
		Assert.assertNotNull(Enumerator_76_Var
		);
		Assert.assertEquals("I_FRIDAY", Enumerator_76_Var
		.getId());
		//76
		final Enumerator Enumerator_77_Var
		 = (Enumerator)Enumerator_69_list.get(5);
		Assert.assertNotNull(Enumerator_77_Var
		);
		Assert.assertEquals("I_SATURDAY", Enumerator_77_Var
		.getId());
		//77
		final Enumerator Enumerator_78_Var
		 = (Enumerator)Enumerator_69_list.get(6);
		Assert.assertNotNull(Enumerator_78_Var
		);
		Assert.assertEquals("I_SUNDAY", Enumerator_78_Var
		.getId());
		//78
		final ExternalDeclaration ExternalDeclaration_79_Var
		 = (ExternalDeclaration)External_0_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_79_Var
		);
		//79
		final Declaration Declaration_80_Var
		 = (Declaration)ExternalDeclaration_79_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_80_Var
		);
		//80
		final DeclarationSpecifiers DeclarationSpecifiers_81_Var
		 = (DeclarationSpecifiers)Declaration_80_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_81_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_81_list = DeclarationSpecifiers_81_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_81_list);
		Assert.assertEquals(1, DeclarationSpecifier_81_list.size());
		//81
		final TypeSpecifier TypeSpecifier_82_Var
		 = (TypeSpecifier)DeclarationSpecifier_81_list.get(0);
		Assert.assertNotNull(TypeSpecifier_82_Var
		);
		//82
		final EnumSpecifier EnumSpecifier_83_Var
		 = (EnumSpecifier)TypeSpecifier_82_Var
		.getSpecifier();
		Assert.assertNotNull(EnumSpecifier_83_Var
		);
		Assert.assertEquals("weekdays", EnumSpecifier_83_Var
		.getId());
		//83
		final EnumeratorList EnumeratorList_84_Var
		 = (EnumeratorList)EnumSpecifier_83_Var
		.getEnumList();
		Assert.assertNotNull(EnumeratorList_84_Var
		);
		final EList<? extends EObject> Enumerator_84_list = EnumeratorList_84_Var
		.getEnumerator();
		Assert.assertNotNull(Enumerator_84_list);
		Assert.assertEquals(7, Enumerator_84_list.size());
		//84
		final Enumerator Enumerator_85_Var
		 = (Enumerator)Enumerator_84_list.get(0);
		Assert.assertNotNull(Enumerator_85_Var
		);
		Assert.assertEquals("M_MONDAY", Enumerator_85_Var
		.getId());
		//85
		final PrimaryExpression PrimaryExpression_86_Var
		 = (PrimaryExpression)Enumerator_85_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_86_Var
		);
		//86
		final Constant2 Constant2_87_Var
		 = (Constant2)PrimaryExpression_86_Var
		.getConst();
		Assert.assertNotNull(Constant2_87_Var
		);
		Assert.assertEquals("1", Constant2_87_Var
		.getDec());
		//87
		final Enumerator Enumerator_88_Var
		 = (Enumerator)Enumerator_84_list.get(1);
		Assert.assertNotNull(Enumerator_88_Var
		);
		Assert.assertEquals("M_TUESDAY", Enumerator_88_Var
		.getId());
		//88
		final Enumerator Enumerator_89_Var
		 = (Enumerator)Enumerator_84_list.get(2);
		Assert.assertNotNull(Enumerator_89_Var
		);
		Assert.assertEquals("M_WEDNESDAY", Enumerator_89_Var
		.getId());
		//89
		final Enumerator Enumerator_90_Var
		 = (Enumerator)Enumerator_84_list.get(3);
		Assert.assertNotNull(Enumerator_90_Var
		);
		Assert.assertEquals("M_THURSDAY", Enumerator_90_Var
		.getId());
		//90
		final Enumerator Enumerator_91_Var
		 = (Enumerator)Enumerator_84_list.get(4);
		Assert.assertNotNull(Enumerator_91_Var
		);
		Assert.assertEquals("M_FRIDAY", Enumerator_91_Var
		.getId());
		//91
		final Enumerator Enumerator_92_Var
		 = (Enumerator)Enumerator_84_list.get(5);
		Assert.assertNotNull(Enumerator_92_Var
		);
		Assert.assertEquals("M_SATURDAY", Enumerator_92_Var
		.getId());
		//92
		final Enumerator Enumerator_93_Var
		 = (Enumerator)Enumerator_84_list.get(6);
		Assert.assertNotNull(Enumerator_93_Var
		);
		Assert.assertEquals("M_SUNDAY", Enumerator_93_Var
		.getId());
		//93
		final ExternalDeclaration ExternalDeclaration_94_Var
		 = (ExternalDeclaration)External_0_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_94_Var
		);
		//94
		final Declaration Declaration_95_Var
		 = (Declaration)ExternalDeclaration_94_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_95_Var
		);
		//95
		final DeclarationSpecifiers DeclarationSpecifiers_96_Var
		 = (DeclarationSpecifiers)Declaration_95_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_96_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_96_list = DeclarationSpecifiers_96_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_96_list);
		Assert.assertEquals(1, DeclarationSpecifier_96_list.size());
		//96
		final TypeSpecifier TypeSpecifier_97_Var
		 = (TypeSpecifier)DeclarationSpecifier_96_list.get(0);
		Assert.assertNotNull(TypeSpecifier_97_Var
		);
		//97
		final EnumSpecifier EnumSpecifier_98_Var
		 = (EnumSpecifier)TypeSpecifier_97_Var
		.getSpecifier();
		Assert.assertNotNull(EnumSpecifier_98_Var
		);
		Assert.assertEquals("weekdays", EnumSpecifier_98_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_98_list = Declaration_95_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_98_list);
		Assert.assertEquals(1, InitDeclaratorList_98_list.size());
		//98
		final InitDeclaratorList InitDeclaratorList_99_Var
		 = (InitDeclaratorList)InitDeclaratorList_98_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_99_Var
		);
		final EList<? extends EObject> InitDeclarator_99_list = InitDeclaratorList_99_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_99_list);
		Assert.assertEquals(1, InitDeclarator_99_list.size());
		//99
		final InitDeclarator InitDeclarator_100_Var
		 = (InitDeclarator)InitDeclarator_99_list.get(0);
		Assert.assertNotNull(InitDeclarator_100_Var
		);
		//100
		final Declarator Declarator_101_Var
		 = (Declarator)InitDeclarator_100_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_101_Var
		);
		//101
		final DirectDeclarator DirectDeclarator_102_Var
		 = (DirectDeclarator)Declarator_101_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_102_Var
		);
		Assert.assertEquals("my_weekday", DirectDeclarator_102_Var
		.getId());
		//102
		final Initializer Initializer_103_Var
		 = (Initializer)InitDeclarator_100_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_103_Var
		);
		//103
		final PrimaryExpression PrimaryExpression_104_Var
		 = (PrimaryExpression)Initializer_103_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_104_Var
		);
		Assert.assertEquals("M_FRIDAY", PrimaryExpression_104_Var
		.getId());
		//104
		final ExternalDeclaration ExternalDeclaration_105_Var
		 = (ExternalDeclaration)External_0_list.get(5);
		Assert.assertNotNull(ExternalDeclaration_105_Var
		);
		//105
		final FunctionDefHead FunctionDefHead_106_Var
		 = (FunctionDefHead)ExternalDeclaration_105_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_106_Var
		);
		//106
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_107_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_106_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_107_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_107_list = FunctionDeclarationSpecifiers_107_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_107_list);
		Assert.assertEquals(1, DeclarationSpecifier_107_list.size());
		//107
		final TypeSpecifier TypeSpecifier_108_Var
		 = (TypeSpecifier)DeclarationSpecifier_107_list.get(0);
		Assert.assertNotNull(TypeSpecifier_108_Var
		);
		Assert.assertEquals("int", TypeSpecifier_108_Var
		.getName());
		//108
		final Declarator Declarator_109_Var
		 = (Declarator)FunctionDefHead_106_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_109_Var
		);
		//109
		final DirectDeclarator DirectDeclarator_110_Var
		 = (DirectDeclarator)Declarator_109_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_110_Var
		);
		Assert.assertEquals("main", DirectDeclarator_110_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_110_list = DirectDeclarator_110_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_110_list);
		Assert.assertEquals(1, DeclaratorSuffix_110_list.size());
		//110
		final DeclaratorSuffix DeclaratorSuffix_111_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_110_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_111_Var
		);
		//111
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_112_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_111_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_112_Var
		);
		final EList<? extends EObject> ParameterTypeList_112_list = DirectDeclaratorLastSuffix_112_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_112_list);
		Assert.assertEquals(1, ParameterTypeList_112_list.size());
		//112
		final ParameterTypeList ParameterTypeList_113_Var
		 = (ParameterTypeList)ParameterTypeList_112_list.get(0);
		Assert.assertNotNull(ParameterTypeList_113_Var
		);
		//113
		final ParameterList ParameterList_114_Var
		 = (ParameterList)ParameterTypeList_113_Var
		.getList();
		Assert.assertNotNull(ParameterList_114_Var
		);
		final EList<? extends EObject> ParameterDeclaration_114_list = ParameterList_114_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_114_list);
		Assert.assertEquals(1, ParameterDeclaration_114_list.size());
		//114
		final ParameterDeclaration ParameterDeclaration_115_Var
		 = (ParameterDeclaration)ParameterDeclaration_114_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_115_Var
		);
		//115
		final DeclarationSpecifiers DeclarationSpecifiers_116_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_115_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_116_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_116_list = DeclarationSpecifiers_116_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_116_list);
		Assert.assertEquals(1, DeclarationSpecifier_116_list.size());
		//116
		final TypeSpecifier TypeSpecifier_117_Var
		 = (TypeSpecifier)DeclarationSpecifier_116_list.get(0);
		Assert.assertNotNull(TypeSpecifier_117_Var
		);
		Assert.assertEquals("void", TypeSpecifier_117_Var
		.getName());
		//117
		final FunctionDefinition FunctionDefinition_118_Var
		 = (FunctionDefinition)ExternalDeclaration_105_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_118_Var
		);
		//118
		final BodyStatement BodyStatement_119_Var
		 = (BodyStatement)FunctionDefinition_118_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_119_Var
		);
		final EList<? extends EObject> BlockList_119_list = BodyStatement_119_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_119_list);
		Assert.assertEquals(1, BlockList_119_list.size());
		//119
		final BlockList BlockList_120_Var
		 = (BlockList)BlockList_119_list.get(0);
		Assert.assertNotNull(BlockList_120_Var
		);
		final EList<? extends EObject> Statement_120_list = BlockList_120_Var
		.getStatement();
		Assert.assertNotNull(Statement_120_list);
		Assert.assertEquals(8, Statement_120_list.size());
		//120
		final Statement Statement_121_Var
		 = (Statement)Statement_120_list.get(0);
		Assert.assertNotNull(Statement_121_Var
		);
		//121
		final ExpressionStatement ExpressionStatement_122_Var
		 = (ExpressionStatement)Statement_121_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_122_Var
		);
		//122
		final PostfixExpression PostfixExpression_123_Var
		 = (PostfixExpression)ExpressionStatement_122_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_123_Var
		);
		//123
		final PrimaryExpression PrimaryExpression_124_Var
		 = (PrimaryExpression)PostfixExpression_123_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_124_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_124_Var
		.getId());
		//124
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_125_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_123_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_125_Var
		);
		//125
		final ArgumentExpressionList ArgumentExpressionList_126_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_125_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_126_Var
		);
		final EList<? extends EObject> Expr_126_list = ArgumentExpressionList_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(2, Expr_126_list.size());
		//126
		final PrimaryExpression PrimaryExpression_127_Var
		 = (PrimaryExpression)Expr_126_list.get(0);
		Assert.assertNotNull(PrimaryExpression_127_Var
		);
		Assert.assertEquals("[\"Monday is %d. day of week\\n\"]", PrimaryExpression_127_Var
		.getString().toString());
		//127
		final PrimaryExpression PrimaryExpression_128_Var
		 = (PrimaryExpression)Expr_126_list.get(1);
		Assert.assertNotNull(PrimaryExpression_128_Var
		);
		Assert.assertEquals("W_MONDAY", PrimaryExpression_128_Var
		.getId());
		//128
		final Statement Statement_129_Var
		 = (Statement)Statement_120_list.get(1);
		Assert.assertNotNull(Statement_129_Var
		);
		//129
		final ExpressionStatement ExpressionStatement_130_Var
		 = (ExpressionStatement)Statement_129_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_130_Var
		);
		//130
		final PostfixExpression PostfixExpression_131_Var
		 = (PostfixExpression)ExpressionStatement_130_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_131_Var
		);
		//131
		final PrimaryExpression PrimaryExpression_132_Var
		 = (PrimaryExpression)PostfixExpression_131_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_132_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_132_Var
		.getId());
		//132
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_133_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_131_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_133_Var
		);
		//133
		final ArgumentExpressionList ArgumentExpressionList_134_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_133_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_134_Var
		);
		final EList<? extends EObject> Expr_134_list = ArgumentExpressionList_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(2, Expr_134_list.size());
		//134
		final PrimaryExpression PrimaryExpression_135_Var
		 = (PrimaryExpression)Expr_134_list.get(0);
		Assert.assertNotNull(PrimaryExpression_135_Var
		);
		Assert.assertEquals("[\"Monday is %d. day of week\\n\"]", PrimaryExpression_135_Var
		.getString().toString());
		//135
		final PrimaryExpression PrimaryExpression_136_Var
		 = (PrimaryExpression)Expr_134_list.get(1);
		Assert.assertNotNull(PrimaryExpression_136_Var
		);
		Assert.assertEquals("MONDAY", PrimaryExpression_136_Var
		.getId());
		//136
		final Statement Statement_137_Var
		 = (Statement)Statement_120_list.get(2);
		Assert.assertNotNull(Statement_137_Var
		);
		//137
		final ExpressionStatement ExpressionStatement_138_Var
		 = (ExpressionStatement)Statement_137_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_138_Var
		);
		//138
		final PostfixExpression PostfixExpression_139_Var
		 = (PostfixExpression)ExpressionStatement_138_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_139_Var
		);
		//139
		final PrimaryExpression PrimaryExpression_140_Var
		 = (PrimaryExpression)PostfixExpression_139_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_140_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_140_Var
		.getId());
		//140
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_141_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_139_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_141_Var
		);
		//141
		final ArgumentExpressionList ArgumentExpressionList_142_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_141_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_142_Var
		);
		final EList<? extends EObject> Expr_142_list = ArgumentExpressionList_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(2, Expr_142_list.size());
		//142
		final PrimaryExpression PrimaryExpression_143_Var
		 = (PrimaryExpression)Expr_142_list.get(0);
		Assert.assertNotNull(PrimaryExpression_143_Var
		);
		Assert.assertEquals("[\"Sunday is %d. day of week\\n\"]", PrimaryExpression_143_Var
		.getString().toString());
		//143
		final PrimaryExpression PrimaryExpression_144_Var
		 = (PrimaryExpression)Expr_142_list.get(1);
		Assert.assertNotNull(PrimaryExpression_144_Var
		);
		Assert.assertEquals("W_SUNDAY", PrimaryExpression_144_Var
		.getId());
		//144
		final Statement Statement_145_Var
		 = (Statement)Statement_120_list.get(3);
		Assert.assertNotNull(Statement_145_Var
		);
		//145
		final ExpressionStatement ExpressionStatement_146_Var
		 = (ExpressionStatement)Statement_145_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_146_Var
		);
		//146
		final PostfixExpression PostfixExpression_147_Var
		 = (PostfixExpression)ExpressionStatement_146_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_147_Var
		);
		//147
		final PrimaryExpression PrimaryExpression_148_Var
		 = (PrimaryExpression)PostfixExpression_147_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_148_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_148_Var
		.getId());
		//148
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_149_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_147_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_149_Var
		);
		//149
		final ArgumentExpressionList ArgumentExpressionList_150_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_149_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_150_Var
		);
		final EList<? extends EObject> Expr_150_list = ArgumentExpressionList_150_Var
		.getExpr();
		Assert.assertNotNull(Expr_150_list);
		Assert.assertEquals(2, Expr_150_list.size());
		//150
		final PrimaryExpression PrimaryExpression_151_Var
		 = (PrimaryExpression)Expr_150_list.get(0);
		Assert.assertNotNull(PrimaryExpression_151_Var
		);
		Assert.assertEquals("[\"Sunday is %d. day of week\\n\"]", PrimaryExpression_151_Var
		.getString().toString());
		//151
		final PrimaryExpression PrimaryExpression_152_Var
		 = (PrimaryExpression)Expr_150_list.get(1);
		Assert.assertNotNull(PrimaryExpression_152_Var
		);
		Assert.assertEquals("SUNDAY", PrimaryExpression_152_Var
		.getId());
		//152
		final Statement Statement_153_Var
		 = (Statement)Statement_120_list.get(4);
		Assert.assertNotNull(Statement_153_Var
		);
		//153
		final ExpressionStatement ExpressionStatement_154_Var
		 = (ExpressionStatement)Statement_153_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_154_Var
		);
		//154
		final AssignmentExpression AssignmentExpression_155_Var
		 = (AssignmentExpression)ExpressionStatement_154_Var
		.getExpression();
		Assert.assertNotNull(AssignmentExpression_155_Var
		);
		//155
		final PrimaryExpression PrimaryExpression_156_Var
		 = (PrimaryExpression)AssignmentExpression_155_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_156_Var
		);
		Assert.assertEquals("iAmInLove", PrimaryExpression_156_Var
		.getId());
		Assert.assertEquals("=", AssignmentExpression_155_Var
		.getOp());
		//156
		final PrimaryExpression PrimaryExpression_157_Var
		 = (PrimaryExpression)AssignmentExpression_155_Var
		.getAssignmentExpr();
		Assert.assertNotNull(PrimaryExpression_157_Var
		);
		Assert.assertEquals("I_FRIDAY", PrimaryExpression_157_Var
		.getId());
		//157
		final Statement Statement_158_Var
		 = (Statement)Statement_120_list.get(5);
		Assert.assertNotNull(Statement_158_Var
		);
		//158
		final ExpressionStatement ExpressionStatement_159_Var
		 = (ExpressionStatement)Statement_158_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_159_Var
		);
		//159
		final PostfixExpression PostfixExpression_160_Var
		 = (PostfixExpression)ExpressionStatement_159_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_160_Var
		);
		//160
		final PrimaryExpression PrimaryExpression_161_Var
		 = (PrimaryExpression)PostfixExpression_160_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_161_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_161_Var
		.getId());
		//161
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_162_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_160_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_162_Var
		);
		//162
		final ArgumentExpressionList ArgumentExpressionList_163_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_162_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_163_Var
		);
		final EList<? extends EObject> Expr_163_list = ArgumentExpressionList_163_Var
		.getExpr();
		Assert.assertNotNull(Expr_163_list);
		Assert.assertEquals(2, Expr_163_list.size());
		//163
		final PrimaryExpression PrimaryExpression_164_Var
		 = (PrimaryExpression)Expr_163_list.get(0);
		Assert.assertNotNull(PrimaryExpression_164_Var
		);
		Assert.assertEquals("[\"The %d. day of the week is my favourite!\\n\"]", PrimaryExpression_164_Var
		.getString().toString());
		//164
		final PrimaryExpression PrimaryExpression_165_Var
		 = (PrimaryExpression)Expr_163_list.get(1);
		Assert.assertNotNull(PrimaryExpression_165_Var
		);
		Assert.assertEquals("iAmInLove", PrimaryExpression_165_Var
		.getId());
		//165
		final Statement Statement_166_Var
		 = (Statement)Statement_120_list.get(6);
		Assert.assertNotNull(Statement_166_Var
		);
		//166
		final ExpressionStatement ExpressionStatement_167_Var
		 = (ExpressionStatement)Statement_166_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_167_Var
		);
		//167
		final PostfixExpression PostfixExpression_168_Var
		 = (PostfixExpression)ExpressionStatement_167_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_168_Var
		);
		//168
		final PrimaryExpression PrimaryExpression_169_Var
		 = (PrimaryExpression)PostfixExpression_168_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_169_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_169_Var
		.getId());
		//169
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_170_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_168_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_170_Var
		);
		//170
		final ArgumentExpressionList ArgumentExpressionList_171_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_170_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_171_Var
		);
		final EList<? extends EObject> Expr_171_list = ArgumentExpressionList_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(2, Expr_171_list.size());
		//171
		final PrimaryExpression PrimaryExpression_172_Var
		 = (PrimaryExpression)Expr_171_list.get(0);
		Assert.assertNotNull(PrimaryExpression_172_Var
		);
		Assert.assertEquals("[\"The %d. day of the week is my favourite!\\n\"]", PrimaryExpression_172_Var
		.getString().toString());
		//172
		final PrimaryExpression PrimaryExpression_173_Var
		 = (PrimaryExpression)Expr_171_list.get(1);
		Assert.assertNotNull(PrimaryExpression_173_Var
		);
		Assert.assertEquals("my_weekday", PrimaryExpression_173_Var
		.getId());
		//173
		final Statement Statement_174_Var
		 = (Statement)Statement_120_list.get(7);
		Assert.assertNotNull(Statement_174_Var
		);
		//174
		final JumpStatement JumpStatement_175_Var
		 = (JumpStatement)Statement_174_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_175_Var
		);
		//175
		final PrimaryExpression PrimaryExpression_176_Var
		 = (PrimaryExpression)JumpStatement_175_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_176_Var
		);
		//176
		final Constant2 Constant2_177_Var
		 = (Constant2)PrimaryExpression_176_Var
		.getConst();
		Assert.assertNotNull(Constant2_177_Var
		);
		Assert.assertEquals("0", Constant2_177_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_175_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0031_Enums.c");
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
				method.invoke(this.generator, "Test0031_Enums.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0031_Enums.c");
		final String expected = this.getTextFromFile(
			"res/Test0031_Enums.c"
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


