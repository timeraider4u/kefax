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
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.StructDeclarationList;
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.InitializerList;
import at.jku.weiner.c.parser.parser.Init;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Init;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.InitializerList;
import at.jku.weiner.c.parser.parser.Init;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Init;
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
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Pointer;
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
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArrow;
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
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.SelectionStatement;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.CompoundStatement;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArrow;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArrow;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0038_StructAdvanced {
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
		at.jku.weiner.c.parser.xtexttests.TestSuite_Structs.testSize();
	}
	
	@After
	public void cleanUp() {
		at.jku.weiner.c.parser.xtexttests.TestSuite_Structs.testSize();
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
			"res/Test0038_StructAdvanced.c");
			final String[] expected = new String[] {
				"RULE_LINEDIRECTIVE",
				"RULE_NEWLINE",
				"RULE_LINEDIRECTIVE",
				"RULE_NEWLINE",
				"RULE_LINEDIRECTIVE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_TYPEDEF",
				"RULE_WHITESPACE",
				"RULE_KW_STRUCT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_CHAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTBRACKET",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_STRUCT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_HEX_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_SKW_RIGHTBRACE",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_HEX_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_SKW_RIGHTBRACE",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_STAR",
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
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_STAR",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_DOT",
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
				"RULE_ARROW",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
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
				"RULE_WHITESPACE",
				"RULE_SKW_STAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_SIZEOF",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_IF",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_EQUAL",
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
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_SKW_MINUS",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_AND",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_AND",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_ARROW",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_HEX_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_ARROW",
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
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
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
			"res/Test0038_StructAdvanced.c");
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
		Assert.assertEquals(5, External_0_list.size());
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
		Assert.assertEquals("typedef", StorageClassSpecifier_4_Var
		.getName());
		//4
		final TypeSpecifier TypeSpecifier_5_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(1);
		Assert.assertNotNull(TypeSpecifier_5_Var
		);
		//5
		final StructOrUnionSpecifier StructOrUnionSpecifier_6_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_5_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_6_Var
		);
		//6
		final StructOrUnion StructOrUnion_7_Var
		 = (StructOrUnion)StructOrUnionSpecifier_6_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_7_Var
		);
		Assert.assertEquals("struct", StructOrUnion_7_Var
		.getName());
		Assert.assertEquals("empStruct", StructOrUnionSpecifier_6_Var
		.getId());
		//7
		final StructDeclarationList StructDeclarationList_8_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_6_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_8_Var
		);
		final EList<? extends EObject> StructDeclaration_8_list = StructDeclarationList_8_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_8_list);
		Assert.assertEquals(2, StructDeclaration_8_list.size());
		//8
		final StructDeclaration StructDeclaration_9_Var
		 = (StructDeclaration)StructDeclaration_8_list.get(0);
		Assert.assertNotNull(StructDeclaration_9_Var
		);
		//9
		final SpecifierQualifierList SpecifierQualifierList_10_Var
		 = (SpecifierQualifierList)StructDeclaration_9_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_10_Var
		);
		final EList<? extends EObject> TypeSpecifier_10_list = SpecifierQualifierList_10_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_10_list);
		Assert.assertEquals(1, TypeSpecifier_10_list.size());
		//10
		final TypeSpecifier TypeSpecifier_11_Var
		 = (TypeSpecifier)TypeSpecifier_10_list.get(0);
		Assert.assertNotNull(TypeSpecifier_11_Var
		);
		Assert.assertEquals("int", TypeSpecifier_11_Var
		.getName());
		//11
		final StructDeclaratorList StructDeclaratorList_12_Var
		 = (StructDeclaratorList)StructDeclaration_9_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_12_Var
		);
		final EList<? extends EObject> StructDeclarator_12_list = StructDeclaratorList_12_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_12_list);
		Assert.assertEquals(1, StructDeclarator_12_list.size());
		//12
		final StructDeclarator StructDeclarator_13_Var
		 = (StructDeclarator)StructDeclarator_12_list.get(0);
		Assert.assertNotNull(StructDeclarator_13_Var
		);
		//13
		final Declarator Declarator_14_Var
		 = (Declarator)StructDeclarator_13_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_14_Var
		);
		//14
		final DirectDeclarator DirectDeclarator_15_Var
		 = (DirectDeclarator)Declarator_14_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_15_Var
		);
		Assert.assertEquals("id", DirectDeclarator_15_Var
		.getId());
		//15
		final StructDeclaration StructDeclaration_16_Var
		 = (StructDeclaration)StructDeclaration_8_list.get(1);
		Assert.assertNotNull(StructDeclaration_16_Var
		);
		//16
		final SpecifierQualifierList SpecifierQualifierList_17_Var
		 = (SpecifierQualifierList)StructDeclaration_16_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_17_Var
		);
		final EList<? extends EObject> TypeSpecifier_17_list = SpecifierQualifierList_17_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_17_list);
		Assert.assertEquals(1, TypeSpecifier_17_list.size());
		//17
		final TypeSpecifier TypeSpecifier_18_Var
		 = (TypeSpecifier)TypeSpecifier_17_list.get(0);
		Assert.assertNotNull(TypeSpecifier_18_Var
		);
		Assert.assertEquals("char", TypeSpecifier_18_Var
		.getName());
		//18
		final StructDeclaratorList StructDeclaratorList_19_Var
		 = (StructDeclaratorList)StructDeclaration_16_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_19_Var
		);
		final EList<? extends EObject> StructDeclarator_19_list = StructDeclaratorList_19_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_19_list);
		Assert.assertEquals(1, StructDeclarator_19_list.size());
		//19
		final StructDeclarator StructDeclarator_20_Var
		 = (StructDeclarator)StructDeclarator_19_list.get(0);
		Assert.assertNotNull(StructDeclarator_20_Var
		);
		//20
		final Declarator Declarator_21_Var
		 = (Declarator)StructDeclarator_20_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_21_Var
		);
		//21
		final DirectDeclarator DirectDeclarator_22_Var
		 = (DirectDeclarator)Declarator_21_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_22_Var
		);
		Assert.assertEquals("name", DirectDeclarator_22_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_22_list = DirectDeclarator_22_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_22_list);
		Assert.assertEquals(1, DeclaratorSuffix_22_list.size());
		//22
		final DeclaratorSuffix DeclaratorSuffix_23_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_22_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_23_Var
		);
		//23
		final PrimaryExpression PrimaryExpression_24_Var
		 = (PrimaryExpression)DeclaratorSuffix_23_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_24_Var
		);
		//24
		final Constant2 Constant2_25_Var
		 = (Constant2)PrimaryExpression_24_Var
		.getConst();
		Assert.assertNotNull(Constant2_25_Var
		);
		Assert.assertEquals("250", Constant2_25_Var
		.getDec());
		final EList<? extends EObject> InitDeclaratorList_25_list = Declaration_2_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_25_list);
		Assert.assertEquals(1, InitDeclaratorList_25_list.size());
		//25
		final InitDeclaratorList InitDeclaratorList_26_Var
		 = (InitDeclaratorList)InitDeclaratorList_25_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_26_Var
		);
		final EList<? extends EObject> InitDeclarator_26_list = InitDeclaratorList_26_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_26_list);
		Assert.assertEquals(1, InitDeclarator_26_list.size());
		//26
		final InitDeclarator InitDeclarator_27_Var
		 = (InitDeclarator)InitDeclarator_26_list.get(0);
		Assert.assertNotNull(InitDeclarator_27_Var
		);
		//27
		final Declarator Declarator_28_Var
		 = (Declarator)InitDeclarator_27_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_28_Var
		);
		//28
		final DirectDeclarator DirectDeclarator_29_Var
		 = (DirectDeclarator)Declarator_28_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_29_Var
		);
		Assert.assertEquals("employee", DirectDeclarator_29_Var
		.getId());
		//29
		final ExternalDeclaration ExternalDeclaration_30_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_30_Var
		);
		//30
		final Declaration Declaration_31_Var
		 = (Declaration)ExternalDeclaration_30_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_31_Var
		);
		//31
		final DeclarationSpecifiers DeclarationSpecifiers_32_Var
		 = (DeclarationSpecifiers)Declaration_31_Var
		.getSpecifiers();
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
		//33
		final StructOrUnionSpecifier StructOrUnionSpecifier_34_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_33_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_34_Var
		);
		//34
		final StructOrUnion StructOrUnion_35_Var
		 = (StructOrUnion)StructOrUnionSpecifier_34_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_35_Var
		);
		Assert.assertEquals("struct", StructOrUnion_35_Var
		.getName());
		Assert.assertEquals("empStruct", StructOrUnionSpecifier_34_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_35_list = Declaration_31_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_35_list);
		Assert.assertEquals(1, InitDeclaratorList_35_list.size());
		//35
		final InitDeclaratorList InitDeclaratorList_36_Var
		 = (InitDeclaratorList)InitDeclaratorList_35_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_36_Var
		);
		final EList<? extends EObject> InitDeclarator_36_list = InitDeclaratorList_36_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_36_list);
		Assert.assertEquals(1, InitDeclarator_36_list.size());
		//36
		final InitDeclarator InitDeclarator_37_Var
		 = (InitDeclarator)InitDeclarator_36_list.get(0);
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
		Assert.assertEquals("joe", DirectDeclarator_39_Var
		.getId());
		//39
		final Initializer Initializer_40_Var
		 = (Initializer)InitDeclarator_37_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_40_Var
		);
		//40
		final InitializerList InitializerList_41_Var
		 = (InitializerList)Initializer_40_Var
		.getList();
		Assert.assertNotNull(InitializerList_41_Var
		);
		final EList<? extends EObject> Init_41_list = InitializerList_41_Var
		.getInit();
		Assert.assertNotNull(Init_41_list);
		Assert.assertEquals(2, Init_41_list.size());
		//41
		final Init Init_42_Var
		 = (Init)Init_41_list.get(0);
		Assert.assertNotNull(Init_42_Var
		);
		//42
		final Initializer Initializer_43_Var
		 = (Initializer)Init_42_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_43_Var
		);
		//43
		final PrimaryExpression PrimaryExpression_44_Var
		 = (PrimaryExpression)Initializer_43_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_44_Var
		);
		//44
		final Constant2 Constant2_45_Var
		 = (Constant2)PrimaryExpression_44_Var
		.getConst();
		Assert.assertNotNull(Constant2_45_Var
		);
		Assert.assertEquals("0x007", Constant2_45_Var
		.getHex());
		//45
		final Init Init_46_Var
		 = (Init)Init_41_list.get(1);
		Assert.assertNotNull(Init_46_Var
		);
		//46
		final Initializer Initializer_47_Var
		 = (Initializer)Init_46_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_47_Var
		);
		//47
		final PrimaryExpression PrimaryExpression_48_Var
		 = (PrimaryExpression)Initializer_47_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_48_Var
		);
		Assert.assertEquals("[\"Joe Nobody\"]", PrimaryExpression_48_Var
		.getString().toString());
		//48
		final ExternalDeclaration ExternalDeclaration_49_Var
		 = (ExternalDeclaration)External_0_list.get(2);
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
		final TypedefName TypedefName_53_Var
		 = (TypedefName)TypeSpecifier_52_Var
		.getType();
		Assert.assertNotNull(TypedefName_53_Var
		);
		Assert.assertEquals("employee", TypedefName_53_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_53_list = Declaration_50_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_53_list);
		Assert.assertEquals(1, InitDeclaratorList_53_list.size());
		//53
		final InitDeclaratorList InitDeclaratorList_54_Var
		 = (InitDeclaratorList)InitDeclaratorList_53_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_54_Var
		);
		final EList<? extends EObject> InitDeclarator_54_list = InitDeclaratorList_54_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_54_list);
		Assert.assertEquals(1, InitDeclarator_54_list.size());
		//54
		final InitDeclarator InitDeclarator_55_Var
		 = (InitDeclarator)InitDeclarator_54_list.get(0);
		Assert.assertNotNull(InitDeclarator_55_Var
		);
		//55
		final Declarator Declarator_56_Var
		 = (Declarator)InitDeclarator_55_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_56_Var
		);
		//56
		final DirectDeclarator DirectDeclarator_57_Var
		 = (DirectDeclarator)Declarator_56_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_57_Var
		);
		Assert.assertEquals("phil", DirectDeclarator_57_Var
		.getId());
		//57
		final Initializer Initializer_58_Var
		 = (Initializer)InitDeclarator_55_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_58_Var
		);
		//58
		final InitializerList InitializerList_59_Var
		 = (InitializerList)Initializer_58_Var
		.getList();
		Assert.assertNotNull(InitializerList_59_Var
		);
		final EList<? extends EObject> Init_59_list = InitializerList_59_Var
		.getInit();
		Assert.assertNotNull(Init_59_list);
		Assert.assertEquals(2, Init_59_list.size());
		//59
		final Init Init_60_Var
		 = (Init)Init_59_list.get(0);
		Assert.assertNotNull(Init_60_Var
		);
		//60
		final Initializer Initializer_61_Var
		 = (Initializer)Init_60_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_61_Var
		);
		//61
		final PrimaryExpression PrimaryExpression_62_Var
		 = (PrimaryExpression)Initializer_61_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_62_Var
		);
		//62
		final Constant2 Constant2_63_Var
		 = (Constant2)PrimaryExpression_62_Var
		.getConst();
		Assert.assertNotNull(Constant2_63_Var
		);
		Assert.assertEquals("0x008", Constant2_63_Var
		.getHex());
		//63
		final Init Init_64_Var
		 = (Init)Init_59_list.get(1);
		Assert.assertNotNull(Init_64_Var
		);
		//64
		final Initializer Initializer_65_Var
		 = (Initializer)Init_64_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_65_Var
		);
		//65
		final PrimaryExpression PrimaryExpression_66_Var
		 = (PrimaryExpression)Initializer_65_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_66_Var
		);
		Assert.assertEquals("[\"Phil Morrison\"]", PrimaryExpression_66_Var
		.getString().toString());
		//66
		final ExternalDeclaration ExternalDeclaration_67_Var
		 = (ExternalDeclaration)External_0_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_67_Var
		);
		//67
		final FunctionDefHead FunctionDefHead_68_Var
		 = (FunctionDefHead)ExternalDeclaration_67_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_68_Var
		);
		//68
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_69_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_68_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_69_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_69_list = FunctionDeclarationSpecifiers_69_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_69_list);
		Assert.assertEquals(1, DeclarationSpecifier_69_list.size());
		//69
		final TypeSpecifier TypeSpecifier_70_Var
		 = (TypeSpecifier)DeclarationSpecifier_69_list.get(0);
		Assert.assertNotNull(TypeSpecifier_70_Var
		);
		Assert.assertEquals("void", TypeSpecifier_70_Var
		.getName());
		//70
		final Declarator Declarator_71_Var
		 = (Declarator)FunctionDefHead_68_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_71_Var
		);
		//71
		final DirectDeclarator DirectDeclarator_72_Var
		 = (DirectDeclarator)Declarator_71_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_72_Var
		);
		Assert.assertEquals("print", DirectDeclarator_72_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_72_list = DirectDeclarator_72_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_72_list);
		Assert.assertEquals(1, DeclaratorSuffix_72_list.size());
		//72
		final DeclaratorSuffix DeclaratorSuffix_73_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_72_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_73_Var
		);
		//73
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_74_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_73_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_74_Var
		);
		final EList<? extends EObject> ParameterTypeList_74_list = DirectDeclaratorLastSuffix_74_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_74_list);
		Assert.assertEquals(1, ParameterTypeList_74_list.size());
		//74
		final ParameterTypeList ParameterTypeList_75_Var
		 = (ParameterTypeList)ParameterTypeList_74_list.get(0);
		Assert.assertNotNull(ParameterTypeList_75_Var
		);
		//75
		final ParameterList ParameterList_76_Var
		 = (ParameterList)ParameterTypeList_75_Var
		.getList();
		Assert.assertNotNull(ParameterList_76_Var
		);
		final EList<? extends EObject> ParameterDeclaration_76_list = ParameterList_76_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_76_list);
		Assert.assertEquals(1, ParameterDeclaration_76_list.size());
		//76
		final ParameterDeclaration ParameterDeclaration_77_Var
		 = (ParameterDeclaration)ParameterDeclaration_76_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_77_Var
		);
		//77
		final DeclarationSpecifiers DeclarationSpecifiers_78_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_77_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_78_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_78_list = DeclarationSpecifiers_78_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_78_list);
		Assert.assertEquals(1, DeclarationSpecifier_78_list.size());
		//78
		final TypeSpecifier TypeSpecifier_79_Var
		 = (TypeSpecifier)DeclarationSpecifier_78_list.get(0);
		Assert.assertNotNull(TypeSpecifier_79_Var
		);
		//79
		final TypedefName TypedefName_80_Var
		 = (TypedefName)TypeSpecifier_79_Var
		.getType();
		Assert.assertNotNull(TypedefName_80_Var
		);
		Assert.assertEquals("employee", TypedefName_80_Var
		.getId());
		//80
		final Declarator Declarator_81_Var
		 = (Declarator)ParameterDeclaration_77_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_81_Var
		);
		//81
		final DirectDeclarator DirectDeclarator_82_Var
		 = (DirectDeclarator)Declarator_81_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_82_Var
		);
		Assert.assertEquals("emp", DirectDeclarator_82_Var
		.getId());
		//82
		final Pointer Pointer_83_Var
		 = (Pointer)Declarator_81_Var
		.getPointer();
		Assert.assertNotNull(Pointer_83_Var
		);
		Assert.assertEquals("[*]", Pointer_83_Var
		.getStar().toString());
		//83
		final FunctionDefinition FunctionDefinition_84_Var
		 = (FunctionDefinition)ExternalDeclaration_67_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_84_Var
		);
		//84
		final BodyStatement BodyStatement_85_Var
		 = (BodyStatement)FunctionDefinition_84_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_85_Var
		);
		final EList<? extends EObject> BlockList_85_list = BodyStatement_85_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_85_list);
		Assert.assertEquals(1, BlockList_85_list.size());
		//85
		final BlockList BlockList_86_Var
		 = (BlockList)BlockList_85_list.get(0);
		Assert.assertNotNull(BlockList_86_Var
		);
		final EList<? extends EObject> Statement_86_list = BlockList_86_Var
		.getStatement();
		Assert.assertNotNull(Statement_86_list);
		Assert.assertEquals(2, Statement_86_list.size());
		//86
		final Statement Statement_87_Var
		 = (Statement)Statement_86_list.get(0);
		Assert.assertNotNull(Statement_87_Var
		);
		//87
		final ExpressionStatement ExpressionStatement_88_Var
		 = (ExpressionStatement)Statement_87_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_88_Var
		);
		//88
		final PostfixExpression PostfixExpression_89_Var
		 = (PostfixExpression)ExpressionStatement_88_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_89_Var
		);
		//89
		final PrimaryExpression PrimaryExpression_90_Var
		 = (PrimaryExpression)PostfixExpression_89_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_90_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_90_Var
		.getId());
		//90
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_91_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_89_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_91_Var
		);
		//91
		final ArgumentExpressionList ArgumentExpressionList_92_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_91_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_92_Var
		);
		final EList<? extends EObject> Expr_92_list = ArgumentExpressionList_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(2, Expr_92_list.size());
		//92
		final PrimaryExpression PrimaryExpression_93_Var
		 = (PrimaryExpression)Expr_92_list.get(0);
		Assert.assertNotNull(PrimaryExpression_93_Var
		);
		Assert.assertEquals("[\"(*employee).id=%d\\n\"]", PrimaryExpression_93_Var
		.getString().toString());
		//93
		final PostfixExpression PostfixExpression_94_Var
		 = (PostfixExpression)Expr_92_list.get(1);
		Assert.assertNotNull(PostfixExpression_94_Var
		);
		//94
		final PrimaryExpression PrimaryExpression_95_Var
		 = (PrimaryExpression)PostfixExpression_94_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_95_Var
		);
		Assert.assertTrue(PrimaryExpression_95_Var
		.isParentheses());
		//95
		final UnaryExpression UnaryExpression_96_Var
		 = (UnaryExpression)PrimaryExpression_95_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_96_Var
		);
		Assert.assertEquals("*", UnaryExpression_96_Var
		.getOp());
		//96
		final PrimaryExpression PrimaryExpression_97_Var
		 = (PrimaryExpression)UnaryExpression_96_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_97_Var
		);
		Assert.assertEquals("emp", PrimaryExpression_97_Var
		.getId());
		//97
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_98_Var
		 = (PostfixExpressionSuffixDot)PostfixExpression_94_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixDot_98_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_98_Var
		.getId());
		//98
		final Statement Statement_99_Var
		 = (Statement)Statement_86_list.get(1);
		Assert.assertNotNull(Statement_99_Var
		);
		//99
		final ExpressionStatement ExpressionStatement_100_Var
		 = (ExpressionStatement)Statement_99_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_100_Var
		);
		//100
		final PostfixExpression PostfixExpression_101_Var
		 = (PostfixExpression)ExpressionStatement_100_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_101_Var
		);
		//101
		final PrimaryExpression PrimaryExpression_102_Var
		 = (PrimaryExpression)PostfixExpression_101_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_102_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_102_Var
		.getId());
		//102
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_103_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_101_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_103_Var
		);
		//103
		final ArgumentExpressionList ArgumentExpressionList_104_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_103_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_104_Var
		);
		final EList<? extends EObject> Expr_104_list = ArgumentExpressionList_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(2, Expr_104_list.size());
		//104
		final PrimaryExpression PrimaryExpression_105_Var
		 = (PrimaryExpression)Expr_104_list.get(0);
		Assert.assertNotNull(PrimaryExpression_105_Var
		);
		Assert.assertEquals("[\"employee->name=%s\\n\"]", PrimaryExpression_105_Var
		.getString().toString());
		//105
		final PostfixExpression PostfixExpression_106_Var
		 = (PostfixExpression)Expr_104_list.get(1);
		Assert.assertNotNull(PostfixExpression_106_Var
		);
		//106
		final PrimaryExpression PrimaryExpression_107_Var
		 = (PrimaryExpression)PostfixExpression_106_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_107_Var
		);
		Assert.assertEquals("emp", PrimaryExpression_107_Var
		.getId());
		//107
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_108_Var
		 = (PostfixExpressionSuffixArrow)PostfixExpression_106_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArrow_108_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixArrow_108_Var
		.getId());
		//108
		final ExternalDeclaration ExternalDeclaration_109_Var
		 = (ExternalDeclaration)External_0_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_109_Var
		);
		//109
		final FunctionDefHead FunctionDefHead_110_Var
		 = (FunctionDefHead)ExternalDeclaration_109_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_110_Var
		);
		//110
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_111_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_110_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_111_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_111_list = FunctionDeclarationSpecifiers_111_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_111_list);
		Assert.assertEquals(1, DeclarationSpecifier_111_list.size());
		//111
		final TypeSpecifier TypeSpecifier_112_Var
		 = (TypeSpecifier)DeclarationSpecifier_111_list.get(0);
		Assert.assertNotNull(TypeSpecifier_112_Var
		);
		Assert.assertEquals("int", TypeSpecifier_112_Var
		.getName());
		//112
		final Declarator Declarator_113_Var
		 = (Declarator)FunctionDefHead_110_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_113_Var
		);
		//113
		final DirectDeclarator DirectDeclarator_114_Var
		 = (DirectDeclarator)Declarator_113_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_114_Var
		);
		Assert.assertEquals("main", DirectDeclarator_114_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_114_list = DirectDeclarator_114_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_114_list);
		Assert.assertEquals(1, DeclaratorSuffix_114_list.size());
		//114
		final DeclaratorSuffix DeclaratorSuffix_115_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_114_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_115_Var
		);
		//115
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_116_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_115_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_116_Var
		);
		final EList<? extends EObject> ParameterTypeList_116_list = DirectDeclaratorLastSuffix_116_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_116_list);
		Assert.assertEquals(1, ParameterTypeList_116_list.size());
		//116
		final ParameterTypeList ParameterTypeList_117_Var
		 = (ParameterTypeList)ParameterTypeList_116_list.get(0);
		Assert.assertNotNull(ParameterTypeList_117_Var
		);
		//117
		final ParameterList ParameterList_118_Var
		 = (ParameterList)ParameterTypeList_117_Var
		.getList();
		Assert.assertNotNull(ParameterList_118_Var
		);
		final EList<? extends EObject> ParameterDeclaration_118_list = ParameterList_118_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_118_list);
		Assert.assertEquals(1, ParameterDeclaration_118_list.size());
		//118
		final ParameterDeclaration ParameterDeclaration_119_Var
		 = (ParameterDeclaration)ParameterDeclaration_118_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_119_Var
		);
		//119
		final DeclarationSpecifiers DeclarationSpecifiers_120_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_119_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_120_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_120_list = DeclarationSpecifiers_120_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_120_list);
		Assert.assertEquals(1, DeclarationSpecifier_120_list.size());
		//120
		final TypeSpecifier TypeSpecifier_121_Var
		 = (TypeSpecifier)DeclarationSpecifier_120_list.get(0);
		Assert.assertNotNull(TypeSpecifier_121_Var
		);
		Assert.assertEquals("void", TypeSpecifier_121_Var
		.getName());
		//121
		final FunctionDefinition FunctionDefinition_122_Var
		 = (FunctionDefinition)ExternalDeclaration_109_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_122_Var
		);
		//122
		final BodyStatement BodyStatement_123_Var
		 = (BodyStatement)FunctionDefinition_122_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_123_Var
		);
		final EList<? extends EObject> BlockList_123_list = BodyStatement_123_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_123_list);
		Assert.assertEquals(1, BlockList_123_list.size());
		//123
		final BlockList BlockList_124_Var
		 = (BlockList)BlockList_123_list.get(0);
		Assert.assertNotNull(BlockList_124_Var
		);
		final EList<? extends EObject> Declaration_124_list = BlockList_124_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_124_list);
		Assert.assertEquals(1, Declaration_124_list.size());
		//124
		final Declaration Declaration_125_Var
		 = (Declaration)Declaration_124_list.get(0);
		Assert.assertNotNull(Declaration_125_Var
		);
		//125
		final DeclarationSpecifiers DeclarationSpecifiers_126_Var
		 = (DeclarationSpecifiers)Declaration_125_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_126_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_126_list = DeclarationSpecifiers_126_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_126_list);
		Assert.assertEquals(1, DeclarationSpecifier_126_list.size());
		//126
		final TypeSpecifier TypeSpecifier_127_Var
		 = (TypeSpecifier)DeclarationSpecifier_126_list.get(0);
		Assert.assertNotNull(TypeSpecifier_127_Var
		);
		//127
		final TypedefName TypedefName_128_Var
		 = (TypedefName)TypeSpecifier_127_Var
		.getType();
		Assert.assertNotNull(TypedefName_128_Var
		);
		Assert.assertEquals("employee", TypedefName_128_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_128_list = Declaration_125_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_128_list);
		Assert.assertEquals(1, InitDeclaratorList_128_list.size());
		//128
		final InitDeclaratorList InitDeclaratorList_129_Var
		 = (InitDeclaratorList)InitDeclaratorList_128_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_129_Var
		);
		final EList<? extends EObject> InitDeclarator_129_list = InitDeclaratorList_129_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_129_list);
		Assert.assertEquals(1, InitDeclarator_129_list.size());
		//129
		final InitDeclarator InitDeclarator_130_Var
		 = (InitDeclarator)InitDeclarator_129_list.get(0);
		Assert.assertNotNull(InitDeclarator_130_Var
		);
		//130
		final Declarator Declarator_131_Var
		 = (Declarator)InitDeclarator_130_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_131_Var
		);
		//131
		final Pointer Pointer_132_Var
		 = (Pointer)Declarator_131_Var
		.getPointer();
		Assert.assertNotNull(Pointer_132_Var
		);
		Assert.assertEquals("[*]", Pointer_132_Var
		.getStar().toString());
		//132
		final DirectDeclarator DirectDeclarator_133_Var
		 = (DirectDeclarator)Declarator_131_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_133_Var
		);
		Assert.assertEquals("newEmployee", DirectDeclarator_133_Var
		.getId());
		//133
		final Initializer Initializer_134_Var
		 = (Initializer)InitDeclarator_130_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_134_Var
		);
		//134
		final PostfixExpression PostfixExpression_135_Var
		 = (PostfixExpression)Initializer_134_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_135_Var
		);
		//135
		final PrimaryExpression PrimaryExpression_136_Var
		 = (PrimaryExpression)PostfixExpression_135_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_136_Var
		);
		Assert.assertEquals("malloc", PrimaryExpression_136_Var
		.getId());
		//136
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_137_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_135_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_137_Var
		);
		//137
		final ArgumentExpressionList ArgumentExpressionList_138_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_137_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_138_Var
		);
		final EList<? extends EObject> Expr_138_list = ArgumentExpressionList_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final UnaryExpression UnaryExpression_139_Var
		 = (UnaryExpression)Expr_138_list.get(0);
		Assert.assertNotNull(UnaryExpression_139_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_139_Var
		.getSizeOf());
		//139
		final TypeName TypeName_140_Var
		 = (TypeName)UnaryExpression_139_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_140_Var
		);
		//140
		final SpecifierQualifierList SpecifierQualifierList_141_Var
		 = (SpecifierQualifierList)TypeName_140_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_141_Var
		);
		final EList<? extends EObject> TypeSpecifier_141_list = SpecifierQualifierList_141_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_141_list);
		Assert.assertEquals(1, TypeSpecifier_141_list.size());
		//141
		final TypeSpecifier TypeSpecifier_142_Var
		 = (TypeSpecifier)TypeSpecifier_141_list.get(0);
		Assert.assertNotNull(TypeSpecifier_142_Var
		);
		//142
		final TypedefName TypedefName_143_Var
		 = (TypedefName)TypeSpecifier_142_Var
		.getType();
		Assert.assertNotNull(TypedefName_143_Var
		);
		Assert.assertEquals("employee", TypedefName_143_Var
		.getId());
		final EList<? extends EObject> Statement_143_list = BlockList_124_Var
		.getStatement();
		Assert.assertNotNull(Statement_143_list);
		Assert.assertEquals(8, Statement_143_list.size());
		//143
		final Statement Statement_144_Var
		 = (Statement)Statement_143_list.get(0);
		Assert.assertNotNull(Statement_144_Var
		);
		//144
		final SelectionStatement SelectionStatement_145_Var
		 = (SelectionStatement)Statement_144_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_145_Var
		);
		Assert.assertEquals("if", SelectionStatement_145_Var
		.getIf());
		//145
		final EqualityExpression EqualityExpression_146_Var
		 = (EqualityExpression)SelectionStatement_145_Var
		.getExpr();
		Assert.assertNotNull(EqualityExpression_146_Var
		);
		//146
		final PrimaryExpression PrimaryExpression_147_Var
		 = (PrimaryExpression)EqualityExpression_146_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_147_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_147_Var
		.getId());
		Assert.assertEquals("==", EqualityExpression_146_Var
		.getOp());
		//147
		final PrimaryExpression PrimaryExpression_148_Var
		 = (PrimaryExpression)EqualityExpression_146_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_148_Var
		);
		Assert.assertEquals("NULL", PrimaryExpression_148_Var
		.getId());
		//148
		final Statement Statement_149_Var
		 = (Statement)SelectionStatement_145_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_149_Var
		);
		//149
		final CompoundStatement CompoundStatement_150_Var
		 = (CompoundStatement)Statement_149_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_150_Var
		);
		//150
		final BodyStatement BodyStatement_151_Var
		 = (BodyStatement)CompoundStatement_150_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_151_Var
		);
		final EList<? extends EObject> BlockList_151_list = BodyStatement_151_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_151_list);
		Assert.assertEquals(1, BlockList_151_list.size());
		//151
		final BlockList BlockList_152_Var
		 = (BlockList)BlockList_151_list.get(0);
		Assert.assertNotNull(BlockList_152_Var
		);
		final EList<? extends EObject> Statement_152_list = BlockList_152_Var
		.getStatement();
		Assert.assertNotNull(Statement_152_list);
		Assert.assertEquals(2, Statement_152_list.size());
		//152
		final Statement Statement_153_Var
		 = (Statement)Statement_152_list.get(0);
		Assert.assertNotNull(Statement_153_Var
		);
		//153
		final ExpressionStatement ExpressionStatement_154_Var
		 = (ExpressionStatement)Statement_153_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_154_Var
		);
		//154
		final PostfixExpression PostfixExpression_155_Var
		 = (PostfixExpression)ExpressionStatement_154_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_155_Var
		);
		//155
		final PrimaryExpression PrimaryExpression_156_Var
		 = (PrimaryExpression)PostfixExpression_155_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_156_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_156_Var
		.getId());
		//156
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_157_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_155_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_157_Var
		);
		//157
		final ArgumentExpressionList ArgumentExpressionList_158_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_157_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_158_Var
		);
		final EList<? extends EObject> Expr_158_list = ArgumentExpressionList_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final PrimaryExpression PrimaryExpression_159_Var
		 = (PrimaryExpression)Expr_158_list.get(0);
		Assert.assertNotNull(PrimaryExpression_159_Var
		);
		Assert.assertEquals("[\"Could not reserve space for new employee!\\n\"]", PrimaryExpression_159_Var
		.getString().toString());
		//159
		final Statement Statement_160_Var
		 = (Statement)Statement_152_list.get(1);
		Assert.assertNotNull(Statement_160_Var
		);
		//160
		final JumpStatement JumpStatement_161_Var
		 = (JumpStatement)Statement_160_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_161_Var
		);
		//161
		final UnaryExpression UnaryExpression_162_Var
		 = (UnaryExpression)JumpStatement_161_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_162_Var
		);
		Assert.assertEquals("-", UnaryExpression_162_Var
		.getOp());
		//162
		final PrimaryExpression PrimaryExpression_163_Var
		 = (PrimaryExpression)UnaryExpression_162_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_163_Var
		);
		//163
		final Constant2 Constant2_164_Var
		 = (Constant2)PrimaryExpression_163_Var
		.getConst();
		Assert.assertNotNull(Constant2_164_Var
		);
		Assert.assertEquals("1", Constant2_164_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_161_Var
		.getReturn());
		//164
		final Statement Statement_165_Var
		 = (Statement)Statement_143_list.get(1);
		Assert.assertNotNull(Statement_165_Var
		);
		//165
		final ExpressionStatement ExpressionStatement_166_Var
		 = (ExpressionStatement)Statement_165_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_166_Var
		);
		//166
		final PostfixExpression PostfixExpression_167_Var
		 = (PostfixExpression)ExpressionStatement_166_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_167_Var
		);
		//167
		final PrimaryExpression PrimaryExpression_168_Var
		 = (PrimaryExpression)PostfixExpression_167_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_168_Var
		);
		Assert.assertEquals("print", PrimaryExpression_168_Var
		.getId());
		//168
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_169_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_167_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_169_Var
		);
		//169
		final ArgumentExpressionList ArgumentExpressionList_170_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_169_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_170_Var
		);
		final EList<? extends EObject> Expr_170_list = ArgumentExpressionList_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		//170
		final UnaryExpression UnaryExpression_171_Var
		 = (UnaryExpression)Expr_170_list.get(0);
		Assert.assertNotNull(UnaryExpression_171_Var
		);
		Assert.assertEquals("&", UnaryExpression_171_Var
		.getOp());
		//171
		final PrimaryExpression PrimaryExpression_172_Var
		 = (PrimaryExpression)UnaryExpression_171_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_172_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_172_Var
		.getId());
		//172
		final Statement Statement_173_Var
		 = (Statement)Statement_143_list.get(2);
		Assert.assertNotNull(Statement_173_Var
		);
		//173
		final ExpressionStatement ExpressionStatement_174_Var
		 = (ExpressionStatement)Statement_173_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_174_Var
		);
		//174
		final PostfixExpression PostfixExpression_175_Var
		 = (PostfixExpression)ExpressionStatement_174_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_175_Var
		);
		//175
		final PrimaryExpression PrimaryExpression_176_Var
		 = (PrimaryExpression)PostfixExpression_175_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_176_Var
		);
		Assert.assertEquals("print", PrimaryExpression_176_Var
		.getId());
		//176
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_177_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_175_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_177_Var
		);
		//177
		final ArgumentExpressionList ArgumentExpressionList_178_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_177_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_178_Var
		);
		final EList<? extends EObject> Expr_178_list = ArgumentExpressionList_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final UnaryExpression UnaryExpression_179_Var
		 = (UnaryExpression)Expr_178_list.get(0);
		Assert.assertNotNull(UnaryExpression_179_Var
		);
		Assert.assertEquals("&", UnaryExpression_179_Var
		.getOp());
		//179
		final PrimaryExpression PrimaryExpression_180_Var
		 = (PrimaryExpression)UnaryExpression_179_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_180_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_180_Var
		.getId());
		//180
		final Statement Statement_181_Var
		 = (Statement)Statement_143_list.get(3);
		Assert.assertNotNull(Statement_181_Var
		);
		//181
		final ExpressionStatement ExpressionStatement_182_Var
		 = (ExpressionStatement)Statement_181_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_182_Var
		);
		//182
		final AssignmentExpression AssignmentExpression_183_Var
		 = (AssignmentExpression)ExpressionStatement_182_Var
		.getExpression();
		Assert.assertNotNull(AssignmentExpression_183_Var
		);
		//183
		final PostfixExpression PostfixExpression_184_Var
		 = (PostfixExpression)AssignmentExpression_183_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_184_Var
		);
		//184
		final PrimaryExpression PrimaryExpression_185_Var
		 = (PrimaryExpression)PostfixExpression_184_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_185_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_185_Var
		.getId());
		//185
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_186_Var
		 = (PostfixExpressionSuffixArrow)PostfixExpression_184_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArrow_186_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixArrow_186_Var
		.getId());
		Assert.assertEquals("=", AssignmentExpression_183_Var
		.getOp());
		//186
		final PrimaryExpression PrimaryExpression_187_Var
		 = (PrimaryExpression)AssignmentExpression_183_Var
		.getAssignmentExpr();
		Assert.assertNotNull(PrimaryExpression_187_Var
		);
		//187
		final Constant2 Constant2_188_Var
		 = (Constant2)PrimaryExpression_187_Var
		.getConst();
		Assert.assertNotNull(Constant2_188_Var
		);
		Assert.assertEquals("0x009", Constant2_188_Var
		.getHex());
		//188
		final Statement Statement_189_Var
		 = (Statement)Statement_143_list.get(4);
		Assert.assertNotNull(Statement_189_Var
		);
		//189
		final ExpressionStatement ExpressionStatement_190_Var
		 = (ExpressionStatement)Statement_189_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_190_Var
		);
		//190
		final PostfixExpression PostfixExpression_191_Var
		 = (PostfixExpression)ExpressionStatement_190_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_191_Var
		);
		//191
		final PrimaryExpression PrimaryExpression_192_Var
		 = (PrimaryExpression)PostfixExpression_191_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_192_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_192_Var
		.getId());
		//192
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_193_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_191_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_193_Var
		);
		//193
		final ArgumentExpressionList ArgumentExpressionList_194_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_193_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_194_Var
		);
		final EList<? extends EObject> Expr_194_list = ArgumentExpressionList_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(2, Expr_194_list.size());
		//194
		final PostfixExpression PostfixExpression_195_Var
		 = (PostfixExpression)Expr_194_list.get(0);
		Assert.assertNotNull(PostfixExpression_195_Var
		);
		//195
		final PrimaryExpression PrimaryExpression_196_Var
		 = (PrimaryExpression)PostfixExpression_195_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_196_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_196_Var
		.getId());
		//196
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_197_Var
		 = (PostfixExpressionSuffixArrow)PostfixExpression_195_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArrow_197_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixArrow_197_Var
		.getId());
		//197
		final PrimaryExpression PrimaryExpression_198_Var
		 = (PrimaryExpression)Expr_194_list.get(1);
		Assert.assertNotNull(PrimaryExpression_198_Var
		);
		Assert.assertEquals("[\"Billy The Kid\"]", PrimaryExpression_198_Var
		.getString().toString());
		//198
		final Statement Statement_199_Var
		 = (Statement)Statement_143_list.get(5);
		Assert.assertNotNull(Statement_199_Var
		);
		//199
		final ExpressionStatement ExpressionStatement_200_Var
		 = (ExpressionStatement)Statement_199_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_200_Var
		);
		//200
		final PostfixExpression PostfixExpression_201_Var
		 = (PostfixExpression)ExpressionStatement_200_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_201_Var
		);
		//201
		final PrimaryExpression PrimaryExpression_202_Var
		 = (PrimaryExpression)PostfixExpression_201_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_202_Var
		);
		Assert.assertEquals("print", PrimaryExpression_202_Var
		.getId());
		//202
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_203_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_201_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_203_Var
		);
		//203
		final ArgumentExpressionList ArgumentExpressionList_204_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_203_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_204_Var
		);
		final EList<? extends EObject> Expr_204_list = ArgumentExpressionList_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final PrimaryExpression PrimaryExpression_205_Var
		 = (PrimaryExpression)Expr_204_list.get(0);
		Assert.assertNotNull(PrimaryExpression_205_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_205_Var
		.getId());
		//205
		final Statement Statement_206_Var
		 = (Statement)Statement_143_list.get(6);
		Assert.assertNotNull(Statement_206_Var
		);
		//206
		final ExpressionStatement ExpressionStatement_207_Var
		 = (ExpressionStatement)Statement_206_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_207_Var
		);
		//207
		final PostfixExpression PostfixExpression_208_Var
		 = (PostfixExpression)ExpressionStatement_207_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_208_Var
		);
		//208
		final PrimaryExpression PrimaryExpression_209_Var
		 = (PrimaryExpression)PostfixExpression_208_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_209_Var
		);
		Assert.assertEquals("free", PrimaryExpression_209_Var
		.getId());
		//209
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_210_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_208_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_210_Var
		);
		//210
		final ArgumentExpressionList ArgumentExpressionList_211_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_210_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_211_Var
		);
		final EList<? extends EObject> Expr_211_list = ArgumentExpressionList_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final PrimaryExpression PrimaryExpression_212_Var
		 = (PrimaryExpression)Expr_211_list.get(0);
		Assert.assertNotNull(PrimaryExpression_212_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_212_Var
		.getId());
		//212
		final Statement Statement_213_Var
		 = (Statement)Statement_143_list.get(7);
		Assert.assertNotNull(Statement_213_Var
		);
		//213
		final JumpStatement JumpStatement_214_Var
		 = (JumpStatement)Statement_213_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_214_Var
		);
		//214
		final PrimaryExpression PrimaryExpression_215_Var
		 = (PrimaryExpression)JumpStatement_214_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_215_Var
		);
		//215
		final Constant2 Constant2_216_Var
		 = (Constant2)PrimaryExpression_215_Var
		.getConst();
		Assert.assertNotNull(Constant2_216_Var
		);
		Assert.assertEquals("0", Constant2_216_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_214_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0038_StructAdvanced.c");
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
				method.invoke(this.generator, "Test0038_StructAdvanced.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0038_StructAdvanced.c");
		final String expected = this.getTextFromFile(
			"res/Test0038_StructAdvanced.c"
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


