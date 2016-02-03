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
import at.jku.weiner.c.parser.parser.AssignmentExpression;
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
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
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
			//System.out.println(text);
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
		final AssignmentExpression AssignmentExpression_66_Var
		 = (AssignmentExpression)Initializer_65_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_66_Var
		);
		//66
		final PrimaryExpression PrimaryExpression_67_Var
		 = (PrimaryExpression)AssignmentExpression_66_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_67_Var
		);
		Assert.assertEquals("[\"Phil Morrison\"]", PrimaryExpression_67_Var
		.getString().toString());
		//67
		final ExternalDeclaration ExternalDeclaration_68_Var
		 = (ExternalDeclaration)External_0_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_68_Var
		);
		//68
		final FunctionDefHead FunctionDefHead_69_Var
		 = (FunctionDefHead)ExternalDeclaration_68_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_69_Var
		);
		//69
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_70_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_69_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_70_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_70_list = FunctionDeclarationSpecifiers_70_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_70_list);
		Assert.assertEquals(1, DeclarationSpecifier_70_list.size());
		//70
		final TypeSpecifier TypeSpecifier_71_Var
		 = (TypeSpecifier)DeclarationSpecifier_70_list.get(0);
		Assert.assertNotNull(TypeSpecifier_71_Var
		);
		Assert.assertEquals("void", TypeSpecifier_71_Var
		.getName());
		//71
		final Declarator Declarator_72_Var
		 = (Declarator)FunctionDefHead_69_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_72_Var
		);
		//72
		final DirectDeclarator DirectDeclarator_73_Var
		 = (DirectDeclarator)Declarator_72_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_73_Var
		);
		Assert.assertEquals("print", DirectDeclarator_73_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_73_list = DirectDeclarator_73_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_73_list);
		Assert.assertEquals(1, DeclaratorSuffix_73_list.size());
		//73
		final DeclaratorSuffix DeclaratorSuffix_74_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_73_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_74_Var
		);
		//74
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_75_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_74_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_75_Var
		);
		final EList<? extends EObject> ParameterTypeList_75_list = DirectDeclaratorLastSuffix_75_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_75_list);
		Assert.assertEquals(1, ParameterTypeList_75_list.size());
		//75
		final ParameterTypeList ParameterTypeList_76_Var
		 = (ParameterTypeList)ParameterTypeList_75_list.get(0);
		Assert.assertNotNull(ParameterTypeList_76_Var
		);
		//76
		final ParameterList ParameterList_77_Var
		 = (ParameterList)ParameterTypeList_76_Var
		.getList();
		Assert.assertNotNull(ParameterList_77_Var
		);
		final EList<? extends EObject> ParameterDeclaration_77_list = ParameterList_77_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_77_list);
		Assert.assertEquals(1, ParameterDeclaration_77_list.size());
		//77
		final ParameterDeclaration ParameterDeclaration_78_Var
		 = (ParameterDeclaration)ParameterDeclaration_77_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_78_Var
		);
		//78
		final DeclarationSpecifiers DeclarationSpecifiers_79_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_78_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_79_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_79_list = DeclarationSpecifiers_79_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_79_list);
		Assert.assertEquals(1, DeclarationSpecifier_79_list.size());
		//79
		final TypeSpecifier TypeSpecifier_80_Var
		 = (TypeSpecifier)DeclarationSpecifier_79_list.get(0);
		Assert.assertNotNull(TypeSpecifier_80_Var
		);
		//80
		final TypedefName TypedefName_81_Var
		 = (TypedefName)TypeSpecifier_80_Var
		.getType();
		Assert.assertNotNull(TypedefName_81_Var
		);
		Assert.assertEquals("employee", TypedefName_81_Var
		.getId());
		//81
		final Declarator Declarator_82_Var
		 = (Declarator)ParameterDeclaration_78_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_82_Var
		);
		//82
		final DirectDeclarator DirectDeclarator_83_Var
		 = (DirectDeclarator)Declarator_82_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_83_Var
		);
		Assert.assertEquals("emp", DirectDeclarator_83_Var
		.getId());
		//83
		final Pointer Pointer_84_Var
		 = (Pointer)Declarator_82_Var
		.getPointer();
		Assert.assertNotNull(Pointer_84_Var
		);
		Assert.assertEquals("[*]", Pointer_84_Var
		.getStar().toString());
		//84
		final FunctionDefinition FunctionDefinition_85_Var
		 = (FunctionDefinition)ExternalDeclaration_68_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_85_Var
		);
		//85
		final BodyStatement BodyStatement_86_Var
		 = (BodyStatement)FunctionDefinition_85_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_86_Var
		);
		final EList<? extends EObject> BlockList_86_list = BodyStatement_86_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_86_list);
		Assert.assertEquals(1, BlockList_86_list.size());
		//86
		final BlockList BlockList_87_Var
		 = (BlockList)BlockList_86_list.get(0);
		Assert.assertNotNull(BlockList_87_Var
		);
		final EList<? extends EObject> Statement_87_list = BlockList_87_Var
		.getStatement();
		Assert.assertNotNull(Statement_87_list);
		Assert.assertEquals(2, Statement_87_list.size());
		//87
		final Statement Statement_88_Var
		 = (Statement)Statement_87_list.get(0);
		Assert.assertNotNull(Statement_88_Var
		);
		//88
		final ExpressionStatement ExpressionStatement_89_Var
		 = (ExpressionStatement)Statement_88_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_89_Var
		);
		//89
		final PostfixExpression PostfixExpression_90_Var
		 = (PostfixExpression)ExpressionStatement_89_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_90_Var
		);
		//90
		final PrimaryExpression PrimaryExpression_91_Var
		 = (PrimaryExpression)PostfixExpression_90_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_91_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_91_Var
		.getId());
		//91
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_92_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_90_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_92_Var
		);
		//92
		final ArgumentExpressionList ArgumentExpressionList_93_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_92_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_93_Var
		);
		final EList<? extends EObject> Expr_93_list = ArgumentExpressionList_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(2, Expr_93_list.size());
		//93
		final PrimaryExpression PrimaryExpression_94_Var
		 = (PrimaryExpression)Expr_93_list.get(0);
		Assert.assertNotNull(PrimaryExpression_94_Var
		);
		Assert.assertEquals("[\"(*employee).id=%d\\n\"]", PrimaryExpression_94_Var
		.getString().toString());
		//94
		final PrimaryExpression PrimaryExpression_95_Var
		 = (PrimaryExpression)Expr_93_list.get(1);
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
		final Statement Statement_98_Var
		 = (Statement)Statement_87_list.get(1);
		Assert.assertNotNull(Statement_98_Var
		);
		//98
		final ExpressionStatement ExpressionStatement_99_Var
		 = (ExpressionStatement)Statement_98_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_99_Var
		);
		//99
		final PostfixExpression PostfixExpression_100_Var
		 = (PostfixExpression)ExpressionStatement_99_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_100_Var
		);
		//100
		final PrimaryExpression PrimaryExpression_101_Var
		 = (PrimaryExpression)PostfixExpression_100_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_101_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_101_Var
		.getId());
		//101
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_102_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_100_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_102_Var
		);
		//102
		final ArgumentExpressionList ArgumentExpressionList_103_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_102_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_103_Var
		);
		final EList<? extends EObject> Expr_103_list = ArgumentExpressionList_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(2, Expr_103_list.size());
		//103
		final PrimaryExpression PrimaryExpression_104_Var
		 = (PrimaryExpression)Expr_103_list.get(0);
		Assert.assertNotNull(PrimaryExpression_104_Var
		);
		Assert.assertEquals("[\"employee->name=%s\\n\"]", PrimaryExpression_104_Var
		.getString().toString());
		//104
		final PostfixExpression PostfixExpression_105_Var
		 = (PostfixExpression)Expr_103_list.get(1);
		Assert.assertNotNull(PostfixExpression_105_Var
		);
		//105
		final PrimaryExpression PrimaryExpression_106_Var
		 = (PrimaryExpression)PostfixExpression_105_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_106_Var
		);
		Assert.assertEquals("emp", PrimaryExpression_106_Var
		.getId());
		//106
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_107_Var
		 = (PostfixExpressionSuffixArrow)PostfixExpression_105_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArrow_107_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixArrow_107_Var
		.getId());
		//107
		final ExternalDeclaration ExternalDeclaration_108_Var
		 = (ExternalDeclaration)External_0_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_108_Var
		);
		//108
		final FunctionDefHead FunctionDefHead_109_Var
		 = (FunctionDefHead)ExternalDeclaration_108_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_109_Var
		);
		//109
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_110_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_109_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_110_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_110_list = FunctionDeclarationSpecifiers_110_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_110_list);
		Assert.assertEquals(1, DeclarationSpecifier_110_list.size());
		//110
		final TypeSpecifier TypeSpecifier_111_Var
		 = (TypeSpecifier)DeclarationSpecifier_110_list.get(0);
		Assert.assertNotNull(TypeSpecifier_111_Var
		);
		Assert.assertEquals("int", TypeSpecifier_111_Var
		.getName());
		//111
		final Declarator Declarator_112_Var
		 = (Declarator)FunctionDefHead_109_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_112_Var
		);
		//112
		final DirectDeclarator DirectDeclarator_113_Var
		 = (DirectDeclarator)Declarator_112_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_113_Var
		);
		Assert.assertEquals("main", DirectDeclarator_113_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_113_list = DirectDeclarator_113_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_113_list);
		Assert.assertEquals(1, DeclaratorSuffix_113_list.size());
		//113
		final DeclaratorSuffix DeclaratorSuffix_114_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_113_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_114_Var
		);
		//114
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_115_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_114_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_115_Var
		);
		final EList<? extends EObject> ParameterTypeList_115_list = DirectDeclaratorLastSuffix_115_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_115_list);
		Assert.assertEquals(1, ParameterTypeList_115_list.size());
		//115
		final ParameterTypeList ParameterTypeList_116_Var
		 = (ParameterTypeList)ParameterTypeList_115_list.get(0);
		Assert.assertNotNull(ParameterTypeList_116_Var
		);
		//116
		final ParameterList ParameterList_117_Var
		 = (ParameterList)ParameterTypeList_116_Var
		.getList();
		Assert.assertNotNull(ParameterList_117_Var
		);
		final EList<? extends EObject> ParameterDeclaration_117_list = ParameterList_117_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_117_list);
		Assert.assertEquals(1, ParameterDeclaration_117_list.size());
		//117
		final ParameterDeclaration ParameterDeclaration_118_Var
		 = (ParameterDeclaration)ParameterDeclaration_117_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_118_Var
		);
		//118
		final DeclarationSpecifiers DeclarationSpecifiers_119_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_118_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_119_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_119_list = DeclarationSpecifiers_119_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_119_list);
		Assert.assertEquals(1, DeclarationSpecifier_119_list.size());
		//119
		final TypeSpecifier TypeSpecifier_120_Var
		 = (TypeSpecifier)DeclarationSpecifier_119_list.get(0);
		Assert.assertNotNull(TypeSpecifier_120_Var
		);
		Assert.assertEquals("void", TypeSpecifier_120_Var
		.getName());
		//120
		final FunctionDefinition FunctionDefinition_121_Var
		 = (FunctionDefinition)ExternalDeclaration_108_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_121_Var
		);
		//121
		final BodyStatement BodyStatement_122_Var
		 = (BodyStatement)FunctionDefinition_121_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_122_Var
		);
		final EList<? extends EObject> BlockList_122_list = BodyStatement_122_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_122_list);
		Assert.assertEquals(1, BlockList_122_list.size());
		//122
		final BlockList BlockList_123_Var
		 = (BlockList)BlockList_122_list.get(0);
		Assert.assertNotNull(BlockList_123_Var
		);
		final EList<? extends EObject> Declaration_123_list = BlockList_123_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_123_list);
		Assert.assertEquals(1, Declaration_123_list.size());
		//123
		final Declaration Declaration_124_Var
		 = (Declaration)Declaration_123_list.get(0);
		Assert.assertNotNull(Declaration_124_Var
		);
		//124
		final DeclarationSpecifiers DeclarationSpecifiers_125_Var
		 = (DeclarationSpecifiers)Declaration_124_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_125_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_125_list = DeclarationSpecifiers_125_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_125_list);
		Assert.assertEquals(1, DeclarationSpecifier_125_list.size());
		//125
		final TypeSpecifier TypeSpecifier_126_Var
		 = (TypeSpecifier)DeclarationSpecifier_125_list.get(0);
		Assert.assertNotNull(TypeSpecifier_126_Var
		);
		//126
		final TypedefName TypedefName_127_Var
		 = (TypedefName)TypeSpecifier_126_Var
		.getType();
		Assert.assertNotNull(TypedefName_127_Var
		);
		Assert.assertEquals("employee", TypedefName_127_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_127_list = Declaration_124_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_127_list);
		Assert.assertEquals(1, InitDeclaratorList_127_list.size());
		//127
		final InitDeclaratorList InitDeclaratorList_128_Var
		 = (InitDeclaratorList)InitDeclaratorList_127_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_128_Var
		);
		final EList<? extends EObject> InitDeclarator_128_list = InitDeclaratorList_128_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_128_list);
		Assert.assertEquals(1, InitDeclarator_128_list.size());
		//128
		final InitDeclarator InitDeclarator_129_Var
		 = (InitDeclarator)InitDeclarator_128_list.get(0);
		Assert.assertNotNull(InitDeclarator_129_Var
		);
		//129
		final Declarator Declarator_130_Var
		 = (Declarator)InitDeclarator_129_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_130_Var
		);
		//130
		final Pointer Pointer_131_Var
		 = (Pointer)Declarator_130_Var
		.getPointer();
		Assert.assertNotNull(Pointer_131_Var
		);
		Assert.assertEquals("[*]", Pointer_131_Var
		.getStar().toString());
		//131
		final DirectDeclarator DirectDeclarator_132_Var
		 = (DirectDeclarator)Declarator_130_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_132_Var
		);
		Assert.assertEquals("newEmployee", DirectDeclarator_132_Var
		.getId());
		//132
		final Initializer Initializer_133_Var
		 = (Initializer)InitDeclarator_129_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_133_Var
		);
		//133
		final PostfixExpression PostfixExpression_134_Var
		 = (PostfixExpression)Initializer_133_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_134_Var
		);
		//134
		final PrimaryExpression PrimaryExpression_135_Var
		 = (PrimaryExpression)PostfixExpression_134_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_135_Var
		);
		Assert.assertEquals("malloc", PrimaryExpression_135_Var
		.getId());
		//135
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_136_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_134_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_136_Var
		);
		//136
		final ArgumentExpressionList ArgumentExpressionList_137_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_136_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_137_Var
		);
		final EList<? extends EObject> Expr_137_list = ArgumentExpressionList_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final UnaryExpression UnaryExpression_138_Var
		 = (UnaryExpression)Expr_137_list.get(0);
		Assert.assertNotNull(UnaryExpression_138_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_138_Var
		.getSizeOf());
		//138
		final TypeName TypeName_139_Var
		 = (TypeName)UnaryExpression_138_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_139_Var
		);
		//139
		final SpecifierQualifierList SpecifierQualifierList_140_Var
		 = (SpecifierQualifierList)TypeName_139_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_140_Var
		);
		final EList<? extends EObject> TypeSpecifier_140_list = SpecifierQualifierList_140_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_140_list);
		Assert.assertEquals(1, TypeSpecifier_140_list.size());
		//140
		final TypeSpecifier TypeSpecifier_141_Var
		 = (TypeSpecifier)TypeSpecifier_140_list.get(0);
		Assert.assertNotNull(TypeSpecifier_141_Var
		);
		//141
		final TypedefName TypedefName_142_Var
		 = (TypedefName)TypeSpecifier_141_Var
		.getType();
		Assert.assertNotNull(TypedefName_142_Var
		);
		Assert.assertEquals("employee", TypedefName_142_Var
		.getId());
		final EList<? extends EObject> Statement_142_list = BlockList_123_Var
		.getStatement();
		Assert.assertNotNull(Statement_142_list);
		Assert.assertEquals(8, Statement_142_list.size());
		//142
		final Statement Statement_143_Var
		 = (Statement)Statement_142_list.get(0);
		Assert.assertNotNull(Statement_143_Var
		);
		//143
		final SelectionStatement SelectionStatement_144_Var
		 = (SelectionStatement)Statement_143_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_144_Var
		);
		Assert.assertEquals("if", SelectionStatement_144_Var
		.getIf());
		//144
		final EqualityExpression EqualityExpression_145_Var
		 = (EqualityExpression)SelectionStatement_144_Var
		.getExpr();
		Assert.assertNotNull(EqualityExpression_145_Var
		);
		//145
		final PrimaryExpression PrimaryExpression_146_Var
		 = (PrimaryExpression)EqualityExpression_145_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_146_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_146_Var
		.getId());
		Assert.assertEquals("[==]", EqualityExpression_145_Var
		.getOp().toString());
		//146
		final PrimaryExpression PrimaryExpression_147_Var
		 = (PrimaryExpression)EqualityExpression_145_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_147_Var
		);
		Assert.assertEquals("NULL", PrimaryExpression_147_Var
		.getId());
		//147
		final Statement Statement_148_Var
		 = (Statement)SelectionStatement_144_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_148_Var
		);
		//148
		final CompoundStatement CompoundStatement_149_Var
		 = (CompoundStatement)Statement_148_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_149_Var
		);
		//149
		final BodyStatement BodyStatement_150_Var
		 = (BodyStatement)CompoundStatement_149_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_150_Var
		);
		final EList<? extends EObject> BlockList_150_list = BodyStatement_150_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_150_list);
		Assert.assertEquals(1, BlockList_150_list.size());
		//150
		final BlockList BlockList_151_Var
		 = (BlockList)BlockList_150_list.get(0);
		Assert.assertNotNull(BlockList_151_Var
		);
		final EList<? extends EObject> Statement_151_list = BlockList_151_Var
		.getStatement();
		Assert.assertNotNull(Statement_151_list);
		Assert.assertEquals(2, Statement_151_list.size());
		//151
		final Statement Statement_152_Var
		 = (Statement)Statement_151_list.get(0);
		Assert.assertNotNull(Statement_152_Var
		);
		//152
		final ExpressionStatement ExpressionStatement_153_Var
		 = (ExpressionStatement)Statement_152_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_153_Var
		);
		//153
		final PostfixExpression PostfixExpression_154_Var
		 = (PostfixExpression)ExpressionStatement_153_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_154_Var
		);
		//154
		final PrimaryExpression PrimaryExpression_155_Var
		 = (PrimaryExpression)PostfixExpression_154_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_155_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_155_Var
		.getId());
		//155
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_156_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_154_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_156_Var
		);
		//156
		final ArgumentExpressionList ArgumentExpressionList_157_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_156_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_157_Var
		);
		final EList<? extends EObject> Expr_157_list = ArgumentExpressionList_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final PrimaryExpression PrimaryExpression_158_Var
		 = (PrimaryExpression)Expr_157_list.get(0);
		Assert.assertNotNull(PrimaryExpression_158_Var
		);
		Assert.assertEquals("[\"Could not reserve space for new employee!\\n\"]", PrimaryExpression_158_Var
		.getString().toString());
		//158
		final Statement Statement_159_Var
		 = (Statement)Statement_151_list.get(1);
		Assert.assertNotNull(Statement_159_Var
		);
		//159
		final JumpStatement JumpStatement_160_Var
		 = (JumpStatement)Statement_159_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_160_Var
		);
		//160
		final UnaryExpression UnaryExpression_161_Var
		 = (UnaryExpression)JumpStatement_160_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_161_Var
		);
		Assert.assertEquals("-", UnaryExpression_161_Var
		.getOp());
		//161
		final PrimaryExpression PrimaryExpression_162_Var
		 = (PrimaryExpression)UnaryExpression_161_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_162_Var
		);
		//162
		final Constant2 Constant2_163_Var
		 = (Constant2)PrimaryExpression_162_Var
		.getConst();
		Assert.assertNotNull(Constant2_163_Var
		);
		Assert.assertEquals("1", Constant2_163_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_160_Var
		.getReturn());
		//163
		final Statement Statement_164_Var
		 = (Statement)Statement_142_list.get(1);
		Assert.assertNotNull(Statement_164_Var
		);
		//164
		final ExpressionStatement ExpressionStatement_165_Var
		 = (ExpressionStatement)Statement_164_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_165_Var
		);
		//165
		final PostfixExpression PostfixExpression_166_Var
		 = (PostfixExpression)ExpressionStatement_165_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_166_Var
		);
		//166
		final PrimaryExpression PrimaryExpression_167_Var
		 = (PrimaryExpression)PostfixExpression_166_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_167_Var
		);
		Assert.assertEquals("print", PrimaryExpression_167_Var
		.getId());
		//167
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_168_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_166_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_168_Var
		);
		//168
		final ArgumentExpressionList ArgumentExpressionList_169_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_168_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_169_Var
		);
		final EList<? extends EObject> Expr_169_list = ArgumentExpressionList_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		//169
		final UnaryExpression UnaryExpression_170_Var
		 = (UnaryExpression)Expr_169_list.get(0);
		Assert.assertNotNull(UnaryExpression_170_Var
		);
		Assert.assertEquals("&", UnaryExpression_170_Var
		.getOp());
		//170
		final PrimaryExpression PrimaryExpression_171_Var
		 = (PrimaryExpression)UnaryExpression_170_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_171_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_171_Var
		.getId());
		//171
		final Statement Statement_172_Var
		 = (Statement)Statement_142_list.get(2);
		Assert.assertNotNull(Statement_172_Var
		);
		//172
		final ExpressionStatement ExpressionStatement_173_Var
		 = (ExpressionStatement)Statement_172_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_173_Var
		);
		//173
		final PostfixExpression PostfixExpression_174_Var
		 = (PostfixExpression)ExpressionStatement_173_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_174_Var
		);
		//174
		final PrimaryExpression PrimaryExpression_175_Var
		 = (PrimaryExpression)PostfixExpression_174_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_175_Var
		);
		Assert.assertEquals("print", PrimaryExpression_175_Var
		.getId());
		//175
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_176_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_174_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_176_Var
		);
		//176
		final ArgumentExpressionList ArgumentExpressionList_177_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_176_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_177_Var
		);
		final EList<? extends EObject> Expr_177_list = ArgumentExpressionList_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final UnaryExpression UnaryExpression_178_Var
		 = (UnaryExpression)Expr_177_list.get(0);
		Assert.assertNotNull(UnaryExpression_178_Var
		);
		Assert.assertEquals("&", UnaryExpression_178_Var
		.getOp());
		//178
		final PrimaryExpression PrimaryExpression_179_Var
		 = (PrimaryExpression)UnaryExpression_178_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_179_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_179_Var
		.getId());
		//179
		final Statement Statement_180_Var
		 = (Statement)Statement_142_list.get(3);
		Assert.assertNotNull(Statement_180_Var
		);
		//180
		final ExpressionStatement ExpressionStatement_181_Var
		 = (ExpressionStatement)Statement_180_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_181_Var
		);
		//181
		final AssignmentExpression AssignmentExpression_182_Var
		 = (AssignmentExpression)ExpressionStatement_181_Var
		.getExpression();
		Assert.assertNotNull(AssignmentExpression_182_Var
		);
		//182
		final PostfixExpression PostfixExpression_183_Var
		 = (PostfixExpression)AssignmentExpression_182_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_183_Var
		);
		//183
		final PrimaryExpression PrimaryExpression_184_Var
		 = (PrimaryExpression)PostfixExpression_183_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_184_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_184_Var
		.getId());
		//184
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_185_Var
		 = (PostfixExpressionSuffixArrow)PostfixExpression_183_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArrow_185_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixArrow_185_Var
		.getId());
		Assert.assertEquals("=", AssignmentExpression_182_Var
		.getOp());
		//185
		final PrimaryExpression PrimaryExpression_186_Var
		 = (PrimaryExpression)AssignmentExpression_182_Var
		.getAssignmentExpr();
		Assert.assertNotNull(PrimaryExpression_186_Var
		);
		//186
		final Constant2 Constant2_187_Var
		 = (Constant2)PrimaryExpression_186_Var
		.getConst();
		Assert.assertNotNull(Constant2_187_Var
		);
		Assert.assertEquals("0x009", Constant2_187_Var
		.getHex());
		//187
		final Statement Statement_188_Var
		 = (Statement)Statement_142_list.get(4);
		Assert.assertNotNull(Statement_188_Var
		);
		//188
		final ExpressionStatement ExpressionStatement_189_Var
		 = (ExpressionStatement)Statement_188_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_189_Var
		);
		//189
		final PostfixExpression PostfixExpression_190_Var
		 = (PostfixExpression)ExpressionStatement_189_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_190_Var
		);
		//190
		final PrimaryExpression PrimaryExpression_191_Var
		 = (PrimaryExpression)PostfixExpression_190_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_191_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_191_Var
		.getId());
		//191
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_192_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_190_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_192_Var
		);
		//192
		final ArgumentExpressionList ArgumentExpressionList_193_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_192_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_193_Var
		);
		final EList<? extends EObject> Expr_193_list = ArgumentExpressionList_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(2, Expr_193_list.size());
		//193
		final PostfixExpression PostfixExpression_194_Var
		 = (PostfixExpression)Expr_193_list.get(0);
		Assert.assertNotNull(PostfixExpression_194_Var
		);
		//194
		final PrimaryExpression PrimaryExpression_195_Var
		 = (PrimaryExpression)PostfixExpression_194_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_195_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_195_Var
		.getId());
		//195
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_196_Var
		 = (PostfixExpressionSuffixArrow)PostfixExpression_194_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArrow_196_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixArrow_196_Var
		.getId());
		//196
		final PrimaryExpression PrimaryExpression_197_Var
		 = (PrimaryExpression)Expr_193_list.get(1);
		Assert.assertNotNull(PrimaryExpression_197_Var
		);
		Assert.assertEquals("[\"Billy The Kid\"]", PrimaryExpression_197_Var
		.getString().toString());
		//197
		final Statement Statement_198_Var
		 = (Statement)Statement_142_list.get(5);
		Assert.assertNotNull(Statement_198_Var
		);
		//198
		final ExpressionStatement ExpressionStatement_199_Var
		 = (ExpressionStatement)Statement_198_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_199_Var
		);
		//199
		final PostfixExpression PostfixExpression_200_Var
		 = (PostfixExpression)ExpressionStatement_199_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_200_Var
		);
		//200
		final PrimaryExpression PrimaryExpression_201_Var
		 = (PrimaryExpression)PostfixExpression_200_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_201_Var
		);
		Assert.assertEquals("print", PrimaryExpression_201_Var
		.getId());
		//201
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_202_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_200_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_202_Var
		);
		//202
		final ArgumentExpressionList ArgumentExpressionList_203_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_202_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_203_Var
		);
		final EList<? extends EObject> Expr_203_list = ArgumentExpressionList_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final PrimaryExpression PrimaryExpression_204_Var
		 = (PrimaryExpression)Expr_203_list.get(0);
		Assert.assertNotNull(PrimaryExpression_204_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_204_Var
		.getId());
		//204
		final Statement Statement_205_Var
		 = (Statement)Statement_142_list.get(6);
		Assert.assertNotNull(Statement_205_Var
		);
		//205
		final ExpressionStatement ExpressionStatement_206_Var
		 = (ExpressionStatement)Statement_205_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_206_Var
		);
		//206
		final PostfixExpression PostfixExpression_207_Var
		 = (PostfixExpression)ExpressionStatement_206_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_207_Var
		);
		//207
		final PrimaryExpression PrimaryExpression_208_Var
		 = (PrimaryExpression)PostfixExpression_207_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_208_Var
		);
		Assert.assertEquals("free", PrimaryExpression_208_Var
		.getId());
		//208
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_209_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_207_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_209_Var
		);
		//209
		final ArgumentExpressionList ArgumentExpressionList_210_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_209_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_210_Var
		);
		final EList<? extends EObject> Expr_210_list = ArgumentExpressionList_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final PrimaryExpression PrimaryExpression_211_Var
		 = (PrimaryExpression)Expr_210_list.get(0);
		Assert.assertNotNull(PrimaryExpression_211_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_211_Var
		.getId());
		//211
		final Statement Statement_212_Var
		 = (Statement)Statement_142_list.get(7);
		Assert.assertNotNull(Statement_212_Var
		);
		//212
		final JumpStatement JumpStatement_213_Var
		 = (JumpStatement)Statement_212_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_213_Var
		);
		//213
		final PrimaryExpression PrimaryExpression_214_Var
		 = (PrimaryExpression)JumpStatement_213_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_214_Var
		);
		//214
		final Constant2 Constant2_215_Var
		 = (Constant2)PrimaryExpression_214_Var
		.getConst();
		Assert.assertNotNull(Constant2_215_Var
		);
		Assert.assertEquals("0", Constant2_215_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_213_Var
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
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0038_StructAdvanced.c");
		final String expected = this.getTextFromFile(
			"res/Test0038_StructAdvanced.c"
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


