package at.jku.weiner.c.xtexttests;

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
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.DeclaratorSuffix;
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
import at.jku.weiner.c.c.Initializer;
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
import at.jku.weiner.c.c.FunctionDefinition;
import at.jku.weiner.c.c.BodyStatement;
import at.jku.weiner.c.c.BlockList;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
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
import at.jku.weiner.c.c.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.c.ArgumentExpressionList;
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
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
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
import at.jku.weiner.c.c.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.c.ArgumentExpressionList;
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
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
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
import at.jku.weiner.c.c.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.c.ArgumentExpressionList;
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
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.PostfixExpressionSuffixArray;
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
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
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
import at.jku.weiner.c.c.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.c.ArgumentExpressionList;
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
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.JumpStatement;
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
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0035_SimpleArray {
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
	
	@Test
	public void checkLexerTokens() throws Exception{
		final String text = this.getTextFromFile(
			"res/Test0035_SimpleArray.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_LINEDIRECTIVE", 
				"RULE_NEWLINE", 
				"RULE_LINEDIRECTIVE", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_CHAR", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTBRACKET", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_RIGHTBRACKET", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_KW_VOID", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTBRACKET", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_RIGHTBRACKET", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_CHAR_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
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
			"res/Test0035_SimpleArray.c");
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
		Assert.assertEquals(2, External_1_list.size());
		//1
		final ExternalDeclaration ExternalDeclaration_2_Var
		 = (ExternalDeclaration)External_1_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_2_Var
		);
		//2
		final Declaration Declaration_3_Var
		 = (Declaration)ExternalDeclaration_2_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_3_Var
		);
		//3
		final DeclarationSpecifiers DeclarationSpecifiers_4_Var
		 = (DeclarationSpecifiers)Declaration_3_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_4_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_4_list = DeclarationSpecifiers_4_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_4_list);
		Assert.assertEquals(1, DeclarationSpecifier_4_list.size());
		//4
		final TypeSpecifier TypeSpecifier_5_Var
		 = (TypeSpecifier)DeclarationSpecifier_4_list.get(0);
		Assert.assertNotNull(TypeSpecifier_5_Var
		);
		Assert.assertEquals("char", TypeSpecifier_5_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_5_list = Declaration_3_Var
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
		Assert.assertEquals("out", DirectDeclarator_9_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_9_list = DirectDeclarator_9_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_9_list);
		Assert.assertEquals(1, DeclaratorSuffix_9_list.size());
		//9
		final DeclaratorSuffix DeclaratorSuffix_10_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_9_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_10_Var
		);
		//10
		final AssignmentExpression AssignmentExpression_11_Var
		 = (AssignmentExpression)DeclaratorSuffix_10_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_11_Var
		);
		//11
		final ConditionalExpression ConditionalExpression_12_Var
		 = (ConditionalExpression)AssignmentExpression_11_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_12_Var
		);
		//12
		final LogicalOrExpression LogicalOrExpression_13_Var
		 = (LogicalOrExpression)ConditionalExpression_12_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_13_Var
		);
		final EList<? extends EObject> Expr_13_list = LogicalOrExpression_13_Var
		.getExpr();
		Assert.assertNotNull(Expr_13_list);
		Assert.assertEquals(1, Expr_13_list.size());
		//13
		final LogicalAndExpression LogicalAndExpression_14_Var
		 = (LogicalAndExpression)Expr_13_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = LogicalAndExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		//14
		final InclusiveOrExpression InclusiveOrExpression_15_Var
		 = (InclusiveOrExpression)Expr_14_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = InclusiveOrExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final ExclusiveOrExpression ExclusiveOrExpression_16_Var
		 = (ExclusiveOrExpression)Expr_15_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = ExclusiveOrExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final AndExpression AndExpression_17_Var
		 = (AndExpression)Expr_16_list.get(0);
		Assert.assertNotNull(AndExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = AndExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final EqualityExpression EqualityExpression_18_Var
		 = (EqualityExpression)Expr_17_list.get(0);
		Assert.assertNotNull(EqualityExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = EqualityExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final RelationalExpression RelationalExpression_19_Var
		 = (RelationalExpression)Expr_18_list.get(0);
		Assert.assertNotNull(RelationalExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = RelationalExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final ShiftExpression ShiftExpression_20_Var
		 = (ShiftExpression)Expr_19_list.get(0);
		Assert.assertNotNull(ShiftExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = ShiftExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final AdditiveExpression AdditiveExpression_21_Var
		 = (AdditiveExpression)Expr_20_list.get(0);
		Assert.assertNotNull(AdditiveExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = AdditiveExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final MultiplicativeExpression MultiplicativeExpression_22_Var
		 = (MultiplicativeExpression)Expr_21_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = MultiplicativeExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final CastExpression CastExpression_23_Var
		 = (CastExpression)Expr_22_list.get(0);
		Assert.assertNotNull(CastExpression_23_Var
		);
		//23
		final UnaryExpression UnaryExpression_24_Var
		 = (UnaryExpression)CastExpression_23_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_24_Var
		);
		//24
		final PostfixExpression PostfixExpression_25_Var
		 = (PostfixExpression)UnaryExpression_24_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = PostfixExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final PrimaryExpression PrimaryExpression_26_Var
		 = (PrimaryExpression)Expr_25_list.get(0);
		Assert.assertNotNull(PrimaryExpression_26_Var
		);
		//26
		final Constant Constant_27_Var
		 = (Constant)PrimaryExpression_26_Var
		.getConst();
		Assert.assertNotNull(Constant_27_Var
		);
		Assert.assertEquals("255", Constant_27_Var
		.getDec());
		//27
		final Initializer Initializer_28_Var
		 = (Initializer)InitDeclarator_7_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_28_Var
		);
		//28
		final AssignmentExpression AssignmentExpression_29_Var
		 = (AssignmentExpression)Initializer_28_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_29_Var
		);
		//29
		final ConditionalExpression ConditionalExpression_30_Var
		 = (ConditionalExpression)AssignmentExpression_29_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_30_Var
		);
		//30
		final LogicalOrExpression LogicalOrExpression_31_Var
		 = (LogicalOrExpression)ConditionalExpression_30_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = LogicalOrExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final LogicalAndExpression LogicalAndExpression_32_Var
		 = (LogicalAndExpression)Expr_31_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = LogicalAndExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final InclusiveOrExpression InclusiveOrExpression_33_Var
		 = (InclusiveOrExpression)Expr_32_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = InclusiveOrExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final ExclusiveOrExpression ExclusiveOrExpression_34_Var
		 = (ExclusiveOrExpression)Expr_33_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = ExclusiveOrExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final AndExpression AndExpression_35_Var
		 = (AndExpression)Expr_34_list.get(0);
		Assert.assertNotNull(AndExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = AndExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final EqualityExpression EqualityExpression_36_Var
		 = (EqualityExpression)Expr_35_list.get(0);
		Assert.assertNotNull(EqualityExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = EqualityExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final RelationalExpression RelationalExpression_37_Var
		 = (RelationalExpression)Expr_36_list.get(0);
		Assert.assertNotNull(RelationalExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = RelationalExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final ShiftExpression ShiftExpression_38_Var
		 = (ShiftExpression)Expr_37_list.get(0);
		Assert.assertNotNull(ShiftExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = ShiftExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final AdditiveExpression AdditiveExpression_39_Var
		 = (AdditiveExpression)Expr_38_list.get(0);
		Assert.assertNotNull(AdditiveExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = AdditiveExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final MultiplicativeExpression MultiplicativeExpression_40_Var
		 = (MultiplicativeExpression)Expr_39_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = MultiplicativeExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final CastExpression CastExpression_41_Var
		 = (CastExpression)Expr_40_list.get(0);
		Assert.assertNotNull(CastExpression_41_Var
		);
		//41
		final UnaryExpression UnaryExpression_42_Var
		 = (UnaryExpression)CastExpression_41_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_42_Var
		);
		//42
		final PostfixExpression PostfixExpression_43_Var
		 = (PostfixExpression)UnaryExpression_42_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = PostfixExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final PrimaryExpression PrimaryExpression_44_Var
		 = (PrimaryExpression)Expr_43_list.get(0);
		Assert.assertNotNull(PrimaryExpression_44_Var
		);
		//44
		final Constant Constant_45_Var
		 = (Constant)PrimaryExpression_44_Var
		.getConst();
		Assert.assertNotNull(Constant_45_Var
		);
		Assert.assertEquals("\"some output\"", Constant_45_Var
		.getStr());
		//45
		final ExternalDeclaration ExternalDeclaration_46_Var
		 = (ExternalDeclaration)External_1_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_46_Var
		);
		//46
		final FunctionDefHead FunctionDefHead_47_Var
		 = (FunctionDefHead)ExternalDeclaration_46_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_47_Var
		);
		//47
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_48_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_47_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_48_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_48_list = FunctionDeclarationSpecifiers_48_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_48_list);
		Assert.assertEquals(1, DeclarationSpecifier_48_list.size());
		//48
		final TypeSpecifier TypeSpecifier_49_Var
		 = (TypeSpecifier)DeclarationSpecifier_48_list.get(0);
		Assert.assertNotNull(TypeSpecifier_49_Var
		);
		Assert.assertEquals("int", TypeSpecifier_49_Var
		.getName());
		//49
		final Declarator Declarator_50_Var
		 = (Declarator)FunctionDefHead_47_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_50_Var
		);
		//50
		final DirectDeclarator DirectDeclarator_51_Var
		 = (DirectDeclarator)Declarator_50_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_51_Var
		);
		Assert.assertEquals("main", DirectDeclarator_51_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_51_list = DirectDeclarator_51_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_51_list);
		Assert.assertEquals(1, DeclaratorSuffix_51_list.size());
		//51
		final DeclaratorSuffix DeclaratorSuffix_52_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_51_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_52_Var
		);
		//52
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_53_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_52_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_53_Var
		);
		final EList<? extends EObject> ParameterTypeList_53_list = DirectDeclaratorLastSuffix_53_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_53_list);
		Assert.assertEquals(1, ParameterTypeList_53_list.size());
		//53
		final ParameterTypeList ParameterTypeList_54_Var
		 = (ParameterTypeList)ParameterTypeList_53_list.get(0);
		Assert.assertNotNull(ParameterTypeList_54_Var
		);
		//54
		final ParameterList ParameterList_55_Var
		 = (ParameterList)ParameterTypeList_54_Var
		.getList();
		Assert.assertNotNull(ParameterList_55_Var
		);
		final EList<? extends EObject> ParameterDeclaration_55_list = ParameterList_55_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_55_list);
		Assert.assertEquals(1, ParameterDeclaration_55_list.size());
		//55
		final ParameterDeclaration ParameterDeclaration_56_Var
		 = (ParameterDeclaration)ParameterDeclaration_55_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_56_Var
		);
		//56
		final DeclarationSpecifiers DeclarationSpecifiers_57_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_56_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_57_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_57_list = DeclarationSpecifiers_57_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_57_list);
		Assert.assertEquals(1, DeclarationSpecifier_57_list.size());
		//57
		final TypeSpecifier TypeSpecifier_58_Var
		 = (TypeSpecifier)DeclarationSpecifier_57_list.get(0);
		Assert.assertNotNull(TypeSpecifier_58_Var
		);
		Assert.assertEquals("void", TypeSpecifier_58_Var
		.getName());
		//58
		final FunctionDefinition FunctionDefinition_59_Var
		 = (FunctionDefinition)ExternalDeclaration_46_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_59_Var
		);
		//59
		final BodyStatement BodyStatement_60_Var
		 = (BodyStatement)FunctionDefinition_59_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_60_Var
		);
		final EList<? extends EObject> BlockList_60_list = BodyStatement_60_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_60_list);
		Assert.assertEquals(1, BlockList_60_list.size());
		//60
		final BlockList BlockList_61_Var
		 = (BlockList)BlockList_60_list.get(0);
		Assert.assertNotNull(BlockList_61_Var
		);
		final EList<? extends EObject> Statement_61_list = BlockList_61_Var
		.getStatement();
		Assert.assertNotNull(Statement_61_list);
		Assert.assertEquals(6, Statement_61_list.size());
		//61
		final Statement Statement_62_Var
		 = (Statement)Statement_61_list.get(0);
		Assert.assertNotNull(Statement_62_Var
		);
		//62
		final ExpressionStatement ExpressionStatement_63_Var
		 = (ExpressionStatement)Statement_62_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_63_Var
		);
		//63
		final Expression Expression_64_Var
		 = (Expression)ExpressionStatement_63_Var
		.getExpression();
		Assert.assertNotNull(Expression_64_Var
		);
		final EList<? extends EObject> ExprExpr_64_list = Expression_64_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_64_list);
		Assert.assertEquals(1, ExprExpr_64_list.size());
		//64
		final AssignmentExpression AssignmentExpression_65_Var
		 = (AssignmentExpression)ExprExpr_64_list.get(0);
		Assert.assertNotNull(AssignmentExpression_65_Var
		);
		//65
		final ConditionalExpression ConditionalExpression_66_Var
		 = (ConditionalExpression)AssignmentExpression_65_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_66_Var
		);
		//66
		final LogicalOrExpression LogicalOrExpression_67_Var
		 = (LogicalOrExpression)ConditionalExpression_66_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = LogicalOrExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final LogicalAndExpression LogicalAndExpression_68_Var
		 = (LogicalAndExpression)Expr_67_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = LogicalAndExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final InclusiveOrExpression InclusiveOrExpression_69_Var
		 = (InclusiveOrExpression)Expr_68_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = InclusiveOrExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final ExclusiveOrExpression ExclusiveOrExpression_70_Var
		 = (ExclusiveOrExpression)Expr_69_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = ExclusiveOrExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final AndExpression AndExpression_71_Var
		 = (AndExpression)Expr_70_list.get(0);
		Assert.assertNotNull(AndExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = AndExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final EqualityExpression EqualityExpression_72_Var
		 = (EqualityExpression)Expr_71_list.get(0);
		Assert.assertNotNull(EqualityExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = EqualityExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final RelationalExpression RelationalExpression_73_Var
		 = (RelationalExpression)Expr_72_list.get(0);
		Assert.assertNotNull(RelationalExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = RelationalExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final ShiftExpression ShiftExpression_74_Var
		 = (ShiftExpression)Expr_73_list.get(0);
		Assert.assertNotNull(ShiftExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = ShiftExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final AdditiveExpression AdditiveExpression_75_Var
		 = (AdditiveExpression)Expr_74_list.get(0);
		Assert.assertNotNull(AdditiveExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = AdditiveExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final MultiplicativeExpression MultiplicativeExpression_76_Var
		 = (MultiplicativeExpression)Expr_75_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = MultiplicativeExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final CastExpression CastExpression_77_Var
		 = (CastExpression)Expr_76_list.get(0);
		Assert.assertNotNull(CastExpression_77_Var
		);
		//77
		final UnaryExpression UnaryExpression_78_Var
		 = (UnaryExpression)CastExpression_77_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_78_Var
		);
		//78
		final PostfixExpression PostfixExpression_79_Var
		 = (PostfixExpression)UnaryExpression_78_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = PostfixExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final PrimaryExpression PrimaryExpression_80_Var
		 = (PrimaryExpression)Expr_79_list.get(0);
		Assert.assertNotNull(PrimaryExpression_80_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_80_Var
		.getId());
		final EList<? extends EObject> Suffix_80_list = PostfixExpression_79_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_80_list);
		Assert.assertEquals(1, Suffix_80_list.size());
		//80
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_81_Var
		 = (PostfixExpressionSuffixArgument)Suffix_80_list.get(0);
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
		Assert.assertEquals(2, Expr_82_list.size());
		//82
		final AssignmentExpression AssignmentExpression_83_Var
		 = (AssignmentExpression)Expr_82_list.get(0);
		Assert.assertNotNull(AssignmentExpression_83_Var
		);
		//83
		final ConditionalExpression ConditionalExpression_84_Var
		 = (ConditionalExpression)AssignmentExpression_83_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_84_Var
		);
		//84
		final LogicalOrExpression LogicalOrExpression_85_Var
		 = (LogicalOrExpression)ConditionalExpression_84_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = LogicalOrExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final LogicalAndExpression LogicalAndExpression_86_Var
		 = (LogicalAndExpression)Expr_85_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = LogicalAndExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final InclusiveOrExpression InclusiveOrExpression_87_Var
		 = (InclusiveOrExpression)Expr_86_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = InclusiveOrExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final ExclusiveOrExpression ExclusiveOrExpression_88_Var
		 = (ExclusiveOrExpression)Expr_87_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = ExclusiveOrExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final AndExpression AndExpression_89_Var
		 = (AndExpression)Expr_88_list.get(0);
		Assert.assertNotNull(AndExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = AndExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final EqualityExpression EqualityExpression_90_Var
		 = (EqualityExpression)Expr_89_list.get(0);
		Assert.assertNotNull(EqualityExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = EqualityExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final RelationalExpression RelationalExpression_91_Var
		 = (RelationalExpression)Expr_90_list.get(0);
		Assert.assertNotNull(RelationalExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = RelationalExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final ShiftExpression ShiftExpression_92_Var
		 = (ShiftExpression)Expr_91_list.get(0);
		Assert.assertNotNull(ShiftExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = ShiftExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final AdditiveExpression AdditiveExpression_93_Var
		 = (AdditiveExpression)Expr_92_list.get(0);
		Assert.assertNotNull(AdditiveExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = AdditiveExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final MultiplicativeExpression MultiplicativeExpression_94_Var
		 = (MultiplicativeExpression)Expr_93_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = MultiplicativeExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final CastExpression CastExpression_95_Var
		 = (CastExpression)Expr_94_list.get(0);
		Assert.assertNotNull(CastExpression_95_Var
		);
		//95
		final UnaryExpression UnaryExpression_96_Var
		 = (UnaryExpression)CastExpression_95_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_96_Var
		);
		//96
		final PostfixExpression PostfixExpression_97_Var
		 = (PostfixExpression)UnaryExpression_96_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = PostfixExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final PrimaryExpression PrimaryExpression_98_Var
		 = (PrimaryExpression)Expr_97_list.get(0);
		Assert.assertNotNull(PrimaryExpression_98_Var
		);
		//98
		final Constant Constant_99_Var
		 = (Constant)PrimaryExpression_98_Var
		.getConst();
		Assert.assertNotNull(Constant_99_Var
		);
		Assert.assertEquals("\"%s\\n\"", Constant_99_Var
		.getStr());
		//99
		final AssignmentExpression AssignmentExpression_100_Var
		 = (AssignmentExpression)Expr_82_list.get(1);
		Assert.assertNotNull(AssignmentExpression_100_Var
		);
		//100
		final ConditionalExpression ConditionalExpression_101_Var
		 = (ConditionalExpression)AssignmentExpression_100_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_101_Var
		);
		//101
		final LogicalOrExpression LogicalOrExpression_102_Var
		 = (LogicalOrExpression)ConditionalExpression_101_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = LogicalOrExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final LogicalAndExpression LogicalAndExpression_103_Var
		 = (LogicalAndExpression)Expr_102_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = LogicalAndExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final InclusiveOrExpression InclusiveOrExpression_104_Var
		 = (InclusiveOrExpression)Expr_103_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = InclusiveOrExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final ExclusiveOrExpression ExclusiveOrExpression_105_Var
		 = (ExclusiveOrExpression)Expr_104_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = ExclusiveOrExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final AndExpression AndExpression_106_Var
		 = (AndExpression)Expr_105_list.get(0);
		Assert.assertNotNull(AndExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = AndExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final EqualityExpression EqualityExpression_107_Var
		 = (EqualityExpression)Expr_106_list.get(0);
		Assert.assertNotNull(EqualityExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = EqualityExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final RelationalExpression RelationalExpression_108_Var
		 = (RelationalExpression)Expr_107_list.get(0);
		Assert.assertNotNull(RelationalExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = RelationalExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final ShiftExpression ShiftExpression_109_Var
		 = (ShiftExpression)Expr_108_list.get(0);
		Assert.assertNotNull(ShiftExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = ShiftExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final AdditiveExpression AdditiveExpression_110_Var
		 = (AdditiveExpression)Expr_109_list.get(0);
		Assert.assertNotNull(AdditiveExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = AdditiveExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final MultiplicativeExpression MultiplicativeExpression_111_Var
		 = (MultiplicativeExpression)Expr_110_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = MultiplicativeExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final CastExpression CastExpression_112_Var
		 = (CastExpression)Expr_111_list.get(0);
		Assert.assertNotNull(CastExpression_112_Var
		);
		//112
		final UnaryExpression UnaryExpression_113_Var
		 = (UnaryExpression)CastExpression_112_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_113_Var
		);
		//113
		final PostfixExpression PostfixExpression_114_Var
		 = (PostfixExpression)UnaryExpression_113_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = PostfixExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final PrimaryExpression PrimaryExpression_115_Var
		 = (PrimaryExpression)Expr_114_list.get(0);
		Assert.assertNotNull(PrimaryExpression_115_Var
		);
		Assert.assertEquals("out", PrimaryExpression_115_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_63_Var
		.getSemi());
		//115
		final Statement Statement_116_Var
		 = (Statement)Statement_61_list.get(1);
		Assert.assertNotNull(Statement_116_Var
		);
		//116
		final ExpressionStatement ExpressionStatement_117_Var
		 = (ExpressionStatement)Statement_116_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_117_Var
		);
		//117
		final Expression Expression_118_Var
		 = (Expression)ExpressionStatement_117_Var
		.getExpression();
		Assert.assertNotNull(Expression_118_Var
		);
		final EList<? extends EObject> ExprExpr_118_list = Expression_118_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_118_list);
		Assert.assertEquals(1, ExprExpr_118_list.size());
		//118
		final AssignmentExpression AssignmentExpression_119_Var
		 = (AssignmentExpression)ExprExpr_118_list.get(0);
		Assert.assertNotNull(AssignmentExpression_119_Var
		);
		//119
		final ConditionalExpression ConditionalExpression_120_Var
		 = (ConditionalExpression)AssignmentExpression_119_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_120_Var
		);
		//120
		final LogicalOrExpression LogicalOrExpression_121_Var
		 = (LogicalOrExpression)ConditionalExpression_120_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = LogicalOrExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final LogicalAndExpression LogicalAndExpression_122_Var
		 = (LogicalAndExpression)Expr_121_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = LogicalAndExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final InclusiveOrExpression InclusiveOrExpression_123_Var
		 = (InclusiveOrExpression)Expr_122_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = InclusiveOrExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final ExclusiveOrExpression ExclusiveOrExpression_124_Var
		 = (ExclusiveOrExpression)Expr_123_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = ExclusiveOrExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final AndExpression AndExpression_125_Var
		 = (AndExpression)Expr_124_list.get(0);
		Assert.assertNotNull(AndExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = AndExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final EqualityExpression EqualityExpression_126_Var
		 = (EqualityExpression)Expr_125_list.get(0);
		Assert.assertNotNull(EqualityExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = EqualityExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final RelationalExpression RelationalExpression_127_Var
		 = (RelationalExpression)Expr_126_list.get(0);
		Assert.assertNotNull(RelationalExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = RelationalExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final ShiftExpression ShiftExpression_128_Var
		 = (ShiftExpression)Expr_127_list.get(0);
		Assert.assertNotNull(ShiftExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = ShiftExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final AdditiveExpression AdditiveExpression_129_Var
		 = (AdditiveExpression)Expr_128_list.get(0);
		Assert.assertNotNull(AdditiveExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = AdditiveExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final MultiplicativeExpression MultiplicativeExpression_130_Var
		 = (MultiplicativeExpression)Expr_129_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = MultiplicativeExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final CastExpression CastExpression_131_Var
		 = (CastExpression)Expr_130_list.get(0);
		Assert.assertNotNull(CastExpression_131_Var
		);
		//131
		final UnaryExpression UnaryExpression_132_Var
		 = (UnaryExpression)CastExpression_131_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_132_Var
		);
		//132
		final PostfixExpression PostfixExpression_133_Var
		 = (PostfixExpression)UnaryExpression_132_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = PostfixExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final PrimaryExpression PrimaryExpression_134_Var
		 = (PrimaryExpression)Expr_133_list.get(0);
		Assert.assertNotNull(PrimaryExpression_134_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_134_Var
		.getId());
		final EList<? extends EObject> Suffix_134_list = PostfixExpression_133_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_134_list);
		Assert.assertEquals(1, Suffix_134_list.size());
		//134
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_135_Var
		 = (PostfixExpressionSuffixArgument)Suffix_134_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_135_Var
		);
		//135
		final ArgumentExpressionList ArgumentExpressionList_136_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_135_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_136_Var
		);
		final EList<? extends EObject> Expr_136_list = ArgumentExpressionList_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(2, Expr_136_list.size());
		//136
		final AssignmentExpression AssignmentExpression_137_Var
		 = (AssignmentExpression)Expr_136_list.get(0);
		Assert.assertNotNull(AssignmentExpression_137_Var
		);
		//137
		final ConditionalExpression ConditionalExpression_138_Var
		 = (ConditionalExpression)AssignmentExpression_137_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_138_Var
		);
		//138
		final LogicalOrExpression LogicalOrExpression_139_Var
		 = (LogicalOrExpression)ConditionalExpression_138_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = LogicalOrExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final LogicalAndExpression LogicalAndExpression_140_Var
		 = (LogicalAndExpression)Expr_139_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = LogicalAndExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final InclusiveOrExpression InclusiveOrExpression_141_Var
		 = (InclusiveOrExpression)Expr_140_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = InclusiveOrExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final ExclusiveOrExpression ExclusiveOrExpression_142_Var
		 = (ExclusiveOrExpression)Expr_141_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = ExclusiveOrExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final AndExpression AndExpression_143_Var
		 = (AndExpression)Expr_142_list.get(0);
		Assert.assertNotNull(AndExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = AndExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final EqualityExpression EqualityExpression_144_Var
		 = (EqualityExpression)Expr_143_list.get(0);
		Assert.assertNotNull(EqualityExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = EqualityExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final RelationalExpression RelationalExpression_145_Var
		 = (RelationalExpression)Expr_144_list.get(0);
		Assert.assertNotNull(RelationalExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = RelationalExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final ShiftExpression ShiftExpression_146_Var
		 = (ShiftExpression)Expr_145_list.get(0);
		Assert.assertNotNull(ShiftExpression_146_Var
		);
		final EList<? extends EObject> Expr_146_list = ShiftExpression_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final AdditiveExpression AdditiveExpression_147_Var
		 = (AdditiveExpression)Expr_146_list.get(0);
		Assert.assertNotNull(AdditiveExpression_147_Var
		);
		final EList<? extends EObject> Expr_147_list = AdditiveExpression_147_Var
		.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(1, Expr_147_list.size());
		//147
		final MultiplicativeExpression MultiplicativeExpression_148_Var
		 = (MultiplicativeExpression)Expr_147_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_148_Var
		);
		final EList<? extends EObject> Expr_148_list = MultiplicativeExpression_148_Var
		.getExpr();
		Assert.assertNotNull(Expr_148_list);
		Assert.assertEquals(1, Expr_148_list.size());
		//148
		final CastExpression CastExpression_149_Var
		 = (CastExpression)Expr_148_list.get(0);
		Assert.assertNotNull(CastExpression_149_Var
		);
		//149
		final UnaryExpression UnaryExpression_150_Var
		 = (UnaryExpression)CastExpression_149_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_150_Var
		);
		//150
		final PostfixExpression PostfixExpression_151_Var
		 = (PostfixExpression)UnaryExpression_150_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_151_Var
		);
		final EList<? extends EObject> Expr_151_list = PostfixExpression_151_Var
		.getExpr();
		Assert.assertNotNull(Expr_151_list);
		Assert.assertEquals(1, Expr_151_list.size());
		//151
		final PrimaryExpression PrimaryExpression_152_Var
		 = (PrimaryExpression)Expr_151_list.get(0);
		Assert.assertNotNull(PrimaryExpression_152_Var
		);
		Assert.assertEquals("out", PrimaryExpression_152_Var
		.getId());
		//152
		final AssignmentExpression AssignmentExpression_153_Var
		 = (AssignmentExpression)Expr_136_list.get(1);
		Assert.assertNotNull(AssignmentExpression_153_Var
		);
		//153
		final ConditionalExpression ConditionalExpression_154_Var
		 = (ConditionalExpression)AssignmentExpression_153_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_154_Var
		);
		//154
		final LogicalOrExpression LogicalOrExpression_155_Var
		 = (LogicalOrExpression)ConditionalExpression_154_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_155_Var
		);
		final EList<? extends EObject> Expr_155_list = LogicalOrExpression_155_Var
		.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		//155
		final LogicalAndExpression LogicalAndExpression_156_Var
		 = (LogicalAndExpression)Expr_155_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_156_Var
		);
		final EList<? extends EObject> Expr_156_list = LogicalAndExpression_156_Var
		.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		//156
		final InclusiveOrExpression InclusiveOrExpression_157_Var
		 = (InclusiveOrExpression)Expr_156_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = InclusiveOrExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final ExclusiveOrExpression ExclusiveOrExpression_158_Var
		 = (ExclusiveOrExpression)Expr_157_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = ExclusiveOrExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final AndExpression AndExpression_159_Var
		 = (AndExpression)Expr_158_list.get(0);
		Assert.assertNotNull(AndExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = AndExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final EqualityExpression EqualityExpression_160_Var
		 = (EqualityExpression)Expr_159_list.get(0);
		Assert.assertNotNull(EqualityExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = EqualityExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final RelationalExpression RelationalExpression_161_Var
		 = (RelationalExpression)Expr_160_list.get(0);
		Assert.assertNotNull(RelationalExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = RelationalExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final ShiftExpression ShiftExpression_162_Var
		 = (ShiftExpression)Expr_161_list.get(0);
		Assert.assertNotNull(ShiftExpression_162_Var
		);
		final EList<? extends EObject> Expr_162_list = ShiftExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		//162
		final AdditiveExpression AdditiveExpression_163_Var
		 = (AdditiveExpression)Expr_162_list.get(0);
		Assert.assertNotNull(AdditiveExpression_163_Var
		);
		final EList<? extends EObject> Expr_163_list = AdditiveExpression_163_Var
		.getExpr();
		Assert.assertNotNull(Expr_163_list);
		Assert.assertEquals(1, Expr_163_list.size());
		//163
		final MultiplicativeExpression MultiplicativeExpression_164_Var
		 = (MultiplicativeExpression)Expr_163_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_164_Var
		);
		final EList<? extends EObject> Expr_164_list = MultiplicativeExpression_164_Var
		.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		//164
		final CastExpression CastExpression_165_Var
		 = (CastExpression)Expr_164_list.get(0);
		Assert.assertNotNull(CastExpression_165_Var
		);
		//165
		final UnaryExpression UnaryExpression_166_Var
		 = (UnaryExpression)CastExpression_165_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_166_Var
		);
		//166
		final PostfixExpression PostfixExpression_167_Var
		 = (PostfixExpression)UnaryExpression_166_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_167_Var
		);
		final EList<? extends EObject> Expr_167_list = PostfixExpression_167_Var
		.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(1, Expr_167_list.size());
		//167
		final PrimaryExpression PrimaryExpression_168_Var
		 = (PrimaryExpression)Expr_167_list.get(0);
		Assert.assertNotNull(PrimaryExpression_168_Var
		);
		//168
		final Constant Constant_169_Var
		 = (Constant)PrimaryExpression_168_Var
		.getConst();
		Assert.assertNotNull(Constant_169_Var
		);
		Assert.assertEquals("\"Hello World!\"", Constant_169_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_117_Var
		.getSemi());
		//169
		final Statement Statement_170_Var
		 = (Statement)Statement_61_list.get(2);
		Assert.assertNotNull(Statement_170_Var
		);
		//170
		final ExpressionStatement ExpressionStatement_171_Var
		 = (ExpressionStatement)Statement_170_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_171_Var
		);
		//171
		final Expression Expression_172_Var
		 = (Expression)ExpressionStatement_171_Var
		.getExpression();
		Assert.assertNotNull(Expression_172_Var
		);
		final EList<? extends EObject> ExprExpr_172_list = Expression_172_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_172_list);
		Assert.assertEquals(1, ExprExpr_172_list.size());
		//172
		final AssignmentExpression AssignmentExpression_173_Var
		 = (AssignmentExpression)ExprExpr_172_list.get(0);
		Assert.assertNotNull(AssignmentExpression_173_Var
		);
		//173
		final ConditionalExpression ConditionalExpression_174_Var
		 = (ConditionalExpression)AssignmentExpression_173_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_174_Var
		);
		//174
		final LogicalOrExpression LogicalOrExpression_175_Var
		 = (LogicalOrExpression)ConditionalExpression_174_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = LogicalOrExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final LogicalAndExpression LogicalAndExpression_176_Var
		 = (LogicalAndExpression)Expr_175_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = LogicalAndExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final InclusiveOrExpression InclusiveOrExpression_177_Var
		 = (InclusiveOrExpression)Expr_176_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = InclusiveOrExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final ExclusiveOrExpression ExclusiveOrExpression_178_Var
		 = (ExclusiveOrExpression)Expr_177_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = ExclusiveOrExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final AndExpression AndExpression_179_Var
		 = (AndExpression)Expr_178_list.get(0);
		Assert.assertNotNull(AndExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = AndExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final EqualityExpression EqualityExpression_180_Var
		 = (EqualityExpression)Expr_179_list.get(0);
		Assert.assertNotNull(EqualityExpression_180_Var
		);
		final EList<? extends EObject> Expr_180_list = EqualityExpression_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final RelationalExpression RelationalExpression_181_Var
		 = (RelationalExpression)Expr_180_list.get(0);
		Assert.assertNotNull(RelationalExpression_181_Var
		);
		final EList<? extends EObject> Expr_181_list = RelationalExpression_181_Var
		.getExpr();
		Assert.assertNotNull(Expr_181_list);
		Assert.assertEquals(1, Expr_181_list.size());
		//181
		final ShiftExpression ShiftExpression_182_Var
		 = (ShiftExpression)Expr_181_list.get(0);
		Assert.assertNotNull(ShiftExpression_182_Var
		);
		final EList<? extends EObject> Expr_182_list = ShiftExpression_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(1, Expr_182_list.size());
		//182
		final AdditiveExpression AdditiveExpression_183_Var
		 = (AdditiveExpression)Expr_182_list.get(0);
		Assert.assertNotNull(AdditiveExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = AdditiveExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final MultiplicativeExpression MultiplicativeExpression_184_Var
		 = (MultiplicativeExpression)Expr_183_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = MultiplicativeExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final CastExpression CastExpression_185_Var
		 = (CastExpression)Expr_184_list.get(0);
		Assert.assertNotNull(CastExpression_185_Var
		);
		//185
		final UnaryExpression UnaryExpression_186_Var
		 = (UnaryExpression)CastExpression_185_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_186_Var
		);
		//186
		final PostfixExpression PostfixExpression_187_Var
		 = (PostfixExpression)UnaryExpression_186_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_187_Var
		);
		final EList<? extends EObject> Expr_187_list = PostfixExpression_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(1, Expr_187_list.size());
		//187
		final PrimaryExpression PrimaryExpression_188_Var
		 = (PrimaryExpression)Expr_187_list.get(0);
		Assert.assertNotNull(PrimaryExpression_188_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_188_Var
		.getId());
		final EList<? extends EObject> Suffix_188_list = PostfixExpression_187_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_188_list);
		Assert.assertEquals(1, Suffix_188_list.size());
		//188
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_189_Var
		 = (PostfixExpressionSuffixArgument)Suffix_188_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_189_Var
		);
		//189
		final ArgumentExpressionList ArgumentExpressionList_190_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_189_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_190_Var
		);
		final EList<? extends EObject> Expr_190_list = ArgumentExpressionList_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(2, Expr_190_list.size());
		//190
		final AssignmentExpression AssignmentExpression_191_Var
		 = (AssignmentExpression)Expr_190_list.get(0);
		Assert.assertNotNull(AssignmentExpression_191_Var
		);
		//191
		final ConditionalExpression ConditionalExpression_192_Var
		 = (ConditionalExpression)AssignmentExpression_191_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_192_Var
		);
		//192
		final LogicalOrExpression LogicalOrExpression_193_Var
		 = (LogicalOrExpression)ConditionalExpression_192_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = LogicalOrExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final LogicalAndExpression LogicalAndExpression_194_Var
		 = (LogicalAndExpression)Expr_193_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = LogicalAndExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final InclusiveOrExpression InclusiveOrExpression_195_Var
		 = (InclusiveOrExpression)Expr_194_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = InclusiveOrExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final ExclusiveOrExpression ExclusiveOrExpression_196_Var
		 = (ExclusiveOrExpression)Expr_195_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = ExclusiveOrExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final AndExpression AndExpression_197_Var
		 = (AndExpression)Expr_196_list.get(0);
		Assert.assertNotNull(AndExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = AndExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final EqualityExpression EqualityExpression_198_Var
		 = (EqualityExpression)Expr_197_list.get(0);
		Assert.assertNotNull(EqualityExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = EqualityExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final RelationalExpression RelationalExpression_199_Var
		 = (RelationalExpression)Expr_198_list.get(0);
		Assert.assertNotNull(RelationalExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = RelationalExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final ShiftExpression ShiftExpression_200_Var
		 = (ShiftExpression)Expr_199_list.get(0);
		Assert.assertNotNull(ShiftExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = ShiftExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final AdditiveExpression AdditiveExpression_201_Var
		 = (AdditiveExpression)Expr_200_list.get(0);
		Assert.assertNotNull(AdditiveExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = AdditiveExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final MultiplicativeExpression MultiplicativeExpression_202_Var
		 = (MultiplicativeExpression)Expr_201_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = MultiplicativeExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final CastExpression CastExpression_203_Var
		 = (CastExpression)Expr_202_list.get(0);
		Assert.assertNotNull(CastExpression_203_Var
		);
		//203
		final UnaryExpression UnaryExpression_204_Var
		 = (UnaryExpression)CastExpression_203_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_204_Var
		);
		//204
		final PostfixExpression PostfixExpression_205_Var
		 = (PostfixExpression)UnaryExpression_204_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = PostfixExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final PrimaryExpression PrimaryExpression_206_Var
		 = (PrimaryExpression)Expr_205_list.get(0);
		Assert.assertNotNull(PrimaryExpression_206_Var
		);
		//206
		final Constant Constant_207_Var
		 = (Constant)PrimaryExpression_206_Var
		.getConst();
		Assert.assertNotNull(Constant_207_Var
		);
		Assert.assertEquals("\"%s\\n\"", Constant_207_Var
		.getStr());
		//207
		final AssignmentExpression AssignmentExpression_208_Var
		 = (AssignmentExpression)Expr_190_list.get(1);
		Assert.assertNotNull(AssignmentExpression_208_Var
		);
		//208
		final ConditionalExpression ConditionalExpression_209_Var
		 = (ConditionalExpression)AssignmentExpression_208_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_209_Var
		);
		//209
		final LogicalOrExpression LogicalOrExpression_210_Var
		 = (LogicalOrExpression)ConditionalExpression_209_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = LogicalOrExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final LogicalAndExpression LogicalAndExpression_211_Var
		 = (LogicalAndExpression)Expr_210_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = LogicalAndExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final InclusiveOrExpression InclusiveOrExpression_212_Var
		 = (InclusiveOrExpression)Expr_211_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = InclusiveOrExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final ExclusiveOrExpression ExclusiveOrExpression_213_Var
		 = (ExclusiveOrExpression)Expr_212_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = ExclusiveOrExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final AndExpression AndExpression_214_Var
		 = (AndExpression)Expr_213_list.get(0);
		Assert.assertNotNull(AndExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = AndExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final EqualityExpression EqualityExpression_215_Var
		 = (EqualityExpression)Expr_214_list.get(0);
		Assert.assertNotNull(EqualityExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = EqualityExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final RelationalExpression RelationalExpression_216_Var
		 = (RelationalExpression)Expr_215_list.get(0);
		Assert.assertNotNull(RelationalExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = RelationalExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final ShiftExpression ShiftExpression_217_Var
		 = (ShiftExpression)Expr_216_list.get(0);
		Assert.assertNotNull(ShiftExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = ShiftExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final AdditiveExpression AdditiveExpression_218_Var
		 = (AdditiveExpression)Expr_217_list.get(0);
		Assert.assertNotNull(AdditiveExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = AdditiveExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final MultiplicativeExpression MultiplicativeExpression_219_Var
		 = (MultiplicativeExpression)Expr_218_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = MultiplicativeExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final CastExpression CastExpression_220_Var
		 = (CastExpression)Expr_219_list.get(0);
		Assert.assertNotNull(CastExpression_220_Var
		);
		//220
		final UnaryExpression UnaryExpression_221_Var
		 = (UnaryExpression)CastExpression_220_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_221_Var
		);
		//221
		final PostfixExpression PostfixExpression_222_Var
		 = (PostfixExpression)UnaryExpression_221_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = PostfixExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final PrimaryExpression PrimaryExpression_223_Var
		 = (PrimaryExpression)Expr_222_list.get(0);
		Assert.assertNotNull(PrimaryExpression_223_Var
		);
		Assert.assertEquals("out", PrimaryExpression_223_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_171_Var
		.getSemi());
		//223
		final Statement Statement_224_Var
		 = (Statement)Statement_61_list.get(3);
		Assert.assertNotNull(Statement_224_Var
		);
		//224
		final ExpressionStatement ExpressionStatement_225_Var
		 = (ExpressionStatement)Statement_224_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_225_Var
		);
		//225
		final Expression Expression_226_Var
		 = (Expression)ExpressionStatement_225_Var
		.getExpression();
		Assert.assertNotNull(Expression_226_Var
		);
		final EList<? extends EObject> ExprExpr_226_list = Expression_226_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_226_list);
		Assert.assertEquals(1, ExprExpr_226_list.size());
		//226
		final AssignmentExpression AssignmentExpression_227_Var
		 = (AssignmentExpression)ExprExpr_226_list.get(0);
		Assert.assertNotNull(AssignmentExpression_227_Var
		);
		//227
		final UnaryExpression UnaryExpression_228_Var
		 = (UnaryExpression)AssignmentExpression_227_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_228_Var
		);
		//228
		final PostfixExpression PostfixExpression_229_Var
		 = (PostfixExpression)UnaryExpression_228_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = PostfixExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final PrimaryExpression PrimaryExpression_230_Var
		 = (PrimaryExpression)Expr_229_list.get(0);
		Assert.assertNotNull(PrimaryExpression_230_Var
		);
		Assert.assertEquals("out", PrimaryExpression_230_Var
		.getId());
		final EList<? extends EObject> Suffix_230_list = PostfixExpression_229_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_230_list);
		Assert.assertEquals(1, Suffix_230_list.size());
		//230
		final PostfixExpressionSuffixArray PostfixExpressionSuffixArray_231_Var
		 = (PostfixExpressionSuffixArray)Suffix_230_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArray_231_Var
		);
		//231
		final Expression Expression_232_Var
		 = (Expression)PostfixExpressionSuffixArray_231_Var
		.getArrayExpr();
		Assert.assertNotNull(Expression_232_Var
		);
		final EList<? extends EObject> ExprExpr_232_list = Expression_232_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_232_list);
		Assert.assertEquals(1, ExprExpr_232_list.size());
		//232
		final AssignmentExpression AssignmentExpression_233_Var
		 = (AssignmentExpression)ExprExpr_232_list.get(0);
		Assert.assertNotNull(AssignmentExpression_233_Var
		);
		//233
		final ConditionalExpression ConditionalExpression_234_Var
		 = (ConditionalExpression)AssignmentExpression_233_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_234_Var
		);
		//234
		final LogicalOrExpression LogicalOrExpression_235_Var
		 = (LogicalOrExpression)ConditionalExpression_234_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = LogicalOrExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final LogicalAndExpression LogicalAndExpression_236_Var
		 = (LogicalAndExpression)Expr_235_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = LogicalAndExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final InclusiveOrExpression InclusiveOrExpression_237_Var
		 = (InclusiveOrExpression)Expr_236_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = InclusiveOrExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final ExclusiveOrExpression ExclusiveOrExpression_238_Var
		 = (ExclusiveOrExpression)Expr_237_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = ExclusiveOrExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final AndExpression AndExpression_239_Var
		 = (AndExpression)Expr_238_list.get(0);
		Assert.assertNotNull(AndExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = AndExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final EqualityExpression EqualityExpression_240_Var
		 = (EqualityExpression)Expr_239_list.get(0);
		Assert.assertNotNull(EqualityExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = EqualityExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final RelationalExpression RelationalExpression_241_Var
		 = (RelationalExpression)Expr_240_list.get(0);
		Assert.assertNotNull(RelationalExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = RelationalExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final ShiftExpression ShiftExpression_242_Var
		 = (ShiftExpression)Expr_241_list.get(0);
		Assert.assertNotNull(ShiftExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = ShiftExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final AdditiveExpression AdditiveExpression_243_Var
		 = (AdditiveExpression)Expr_242_list.get(0);
		Assert.assertNotNull(AdditiveExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = AdditiveExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final MultiplicativeExpression MultiplicativeExpression_244_Var
		 = (MultiplicativeExpression)Expr_243_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = MultiplicativeExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final CastExpression CastExpression_245_Var
		 = (CastExpression)Expr_244_list.get(0);
		Assert.assertNotNull(CastExpression_245_Var
		);
		//245
		final UnaryExpression UnaryExpression_246_Var
		 = (UnaryExpression)CastExpression_245_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_246_Var
		);
		//246
		final PostfixExpression PostfixExpression_247_Var
		 = (PostfixExpression)UnaryExpression_246_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = PostfixExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final PrimaryExpression PrimaryExpression_248_Var
		 = (PrimaryExpression)Expr_247_list.get(0);
		Assert.assertNotNull(PrimaryExpression_248_Var
		);
		//248
		final Constant Constant_249_Var
		 = (Constant)PrimaryExpression_248_Var
		.getConst();
		Assert.assertNotNull(Constant_249_Var
		);
		Assert.assertEquals("6", Constant_249_Var
		.getDec());
		//249
		final AssignmentOperator AssignmentOperator_250_Var
		 = (AssignmentOperator)AssignmentExpression_227_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_250_Var
		);
		Assert.assertEquals("=", AssignmentOperator_250_Var
		.getOp());
		//250
		final AssignmentExpression AssignmentExpression_251_Var
		 = (AssignmentExpression)AssignmentExpression_227_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_251_Var
		);
		//251
		final ConditionalExpression ConditionalExpression_252_Var
		 = (ConditionalExpression)AssignmentExpression_251_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_252_Var
		);
		//252
		final LogicalOrExpression LogicalOrExpression_253_Var
		 = (LogicalOrExpression)ConditionalExpression_252_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = LogicalOrExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final LogicalAndExpression LogicalAndExpression_254_Var
		 = (LogicalAndExpression)Expr_253_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = LogicalAndExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final InclusiveOrExpression InclusiveOrExpression_255_Var
		 = (InclusiveOrExpression)Expr_254_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_255_Var
		);
		final EList<? extends EObject> Expr_255_list = InclusiveOrExpression_255_Var
		.getExpr();
		Assert.assertNotNull(Expr_255_list);
		Assert.assertEquals(1, Expr_255_list.size());
		//255
		final ExclusiveOrExpression ExclusiveOrExpression_256_Var
		 = (ExclusiveOrExpression)Expr_255_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_256_Var
		);
		final EList<? extends EObject> Expr_256_list = ExclusiveOrExpression_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(1, Expr_256_list.size());
		//256
		final AndExpression AndExpression_257_Var
		 = (AndExpression)Expr_256_list.get(0);
		Assert.assertNotNull(AndExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = AndExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final EqualityExpression EqualityExpression_258_Var
		 = (EqualityExpression)Expr_257_list.get(0);
		Assert.assertNotNull(EqualityExpression_258_Var
		);
		final EList<? extends EObject> Expr_258_list = EqualityExpression_258_Var
		.getExpr();
		Assert.assertNotNull(Expr_258_list);
		Assert.assertEquals(1, Expr_258_list.size());
		//258
		final RelationalExpression RelationalExpression_259_Var
		 = (RelationalExpression)Expr_258_list.get(0);
		Assert.assertNotNull(RelationalExpression_259_Var
		);
		final EList<? extends EObject> Expr_259_list = RelationalExpression_259_Var
		.getExpr();
		Assert.assertNotNull(Expr_259_list);
		Assert.assertEquals(1, Expr_259_list.size());
		//259
		final ShiftExpression ShiftExpression_260_Var
		 = (ShiftExpression)Expr_259_list.get(0);
		Assert.assertNotNull(ShiftExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = ShiftExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final AdditiveExpression AdditiveExpression_261_Var
		 = (AdditiveExpression)Expr_260_list.get(0);
		Assert.assertNotNull(AdditiveExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = AdditiveExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final MultiplicativeExpression MultiplicativeExpression_262_Var
		 = (MultiplicativeExpression)Expr_261_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_262_Var
		);
		final EList<? extends EObject> Expr_262_list = MultiplicativeExpression_262_Var
		.getExpr();
		Assert.assertNotNull(Expr_262_list);
		Assert.assertEquals(1, Expr_262_list.size());
		//262
		final CastExpression CastExpression_263_Var
		 = (CastExpression)Expr_262_list.get(0);
		Assert.assertNotNull(CastExpression_263_Var
		);
		//263
		final UnaryExpression UnaryExpression_264_Var
		 = (UnaryExpression)CastExpression_263_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_264_Var
		);
		//264
		final PostfixExpression PostfixExpression_265_Var
		 = (PostfixExpression)UnaryExpression_264_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_265_Var
		);
		final EList<? extends EObject> Expr_265_list = PostfixExpression_265_Var
		.getExpr();
		Assert.assertNotNull(Expr_265_list);
		Assert.assertEquals(1, Expr_265_list.size());
		//265
		final PrimaryExpression PrimaryExpression_266_Var
		 = (PrimaryExpression)Expr_265_list.get(0);
		Assert.assertNotNull(PrimaryExpression_266_Var
		);
		//266
		final Constant Constant_267_Var
		 = (Constant)PrimaryExpression_266_Var
		.getConst();
		Assert.assertNotNull(Constant_267_Var
		);
		Assert.assertEquals("'w'", Constant_267_Var
		.getCh());
		Assert.assertEquals(";", ExpressionStatement_225_Var
		.getSemi());
		//267
		final Statement Statement_268_Var
		 = (Statement)Statement_61_list.get(4);
		Assert.assertNotNull(Statement_268_Var
		);
		//268
		final ExpressionStatement ExpressionStatement_269_Var
		 = (ExpressionStatement)Statement_268_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_269_Var
		);
		//269
		final Expression Expression_270_Var
		 = (Expression)ExpressionStatement_269_Var
		.getExpression();
		Assert.assertNotNull(Expression_270_Var
		);
		final EList<? extends EObject> ExprExpr_270_list = Expression_270_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_270_list);
		Assert.assertEquals(1, ExprExpr_270_list.size());
		//270
		final AssignmentExpression AssignmentExpression_271_Var
		 = (AssignmentExpression)ExprExpr_270_list.get(0);
		Assert.assertNotNull(AssignmentExpression_271_Var
		);
		//271
		final ConditionalExpression ConditionalExpression_272_Var
		 = (ConditionalExpression)AssignmentExpression_271_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_272_Var
		);
		//272
		final LogicalOrExpression LogicalOrExpression_273_Var
		 = (LogicalOrExpression)ConditionalExpression_272_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_273_Var
		);
		final EList<? extends EObject> Expr_273_list = LogicalOrExpression_273_Var
		.getExpr();
		Assert.assertNotNull(Expr_273_list);
		Assert.assertEquals(1, Expr_273_list.size());
		//273
		final LogicalAndExpression LogicalAndExpression_274_Var
		 = (LogicalAndExpression)Expr_273_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_274_Var
		);
		final EList<? extends EObject> Expr_274_list = LogicalAndExpression_274_Var
		.getExpr();
		Assert.assertNotNull(Expr_274_list);
		Assert.assertEquals(1, Expr_274_list.size());
		//274
		final InclusiveOrExpression InclusiveOrExpression_275_Var
		 = (InclusiveOrExpression)Expr_274_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_275_Var
		);
		final EList<? extends EObject> Expr_275_list = InclusiveOrExpression_275_Var
		.getExpr();
		Assert.assertNotNull(Expr_275_list);
		Assert.assertEquals(1, Expr_275_list.size());
		//275
		final ExclusiveOrExpression ExclusiveOrExpression_276_Var
		 = (ExclusiveOrExpression)Expr_275_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_276_Var
		);
		final EList<? extends EObject> Expr_276_list = ExclusiveOrExpression_276_Var
		.getExpr();
		Assert.assertNotNull(Expr_276_list);
		Assert.assertEquals(1, Expr_276_list.size());
		//276
		final AndExpression AndExpression_277_Var
		 = (AndExpression)Expr_276_list.get(0);
		Assert.assertNotNull(AndExpression_277_Var
		);
		final EList<? extends EObject> Expr_277_list = AndExpression_277_Var
		.getExpr();
		Assert.assertNotNull(Expr_277_list);
		Assert.assertEquals(1, Expr_277_list.size());
		//277
		final EqualityExpression EqualityExpression_278_Var
		 = (EqualityExpression)Expr_277_list.get(0);
		Assert.assertNotNull(EqualityExpression_278_Var
		);
		final EList<? extends EObject> Expr_278_list = EqualityExpression_278_Var
		.getExpr();
		Assert.assertNotNull(Expr_278_list);
		Assert.assertEquals(1, Expr_278_list.size());
		//278
		final RelationalExpression RelationalExpression_279_Var
		 = (RelationalExpression)Expr_278_list.get(0);
		Assert.assertNotNull(RelationalExpression_279_Var
		);
		final EList<? extends EObject> Expr_279_list = RelationalExpression_279_Var
		.getExpr();
		Assert.assertNotNull(Expr_279_list);
		Assert.assertEquals(1, Expr_279_list.size());
		//279
		final ShiftExpression ShiftExpression_280_Var
		 = (ShiftExpression)Expr_279_list.get(0);
		Assert.assertNotNull(ShiftExpression_280_Var
		);
		final EList<? extends EObject> Expr_280_list = ShiftExpression_280_Var
		.getExpr();
		Assert.assertNotNull(Expr_280_list);
		Assert.assertEquals(1, Expr_280_list.size());
		//280
		final AdditiveExpression AdditiveExpression_281_Var
		 = (AdditiveExpression)Expr_280_list.get(0);
		Assert.assertNotNull(AdditiveExpression_281_Var
		);
		final EList<? extends EObject> Expr_281_list = AdditiveExpression_281_Var
		.getExpr();
		Assert.assertNotNull(Expr_281_list);
		Assert.assertEquals(1, Expr_281_list.size());
		//281
		final MultiplicativeExpression MultiplicativeExpression_282_Var
		 = (MultiplicativeExpression)Expr_281_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_282_Var
		);
		final EList<? extends EObject> Expr_282_list = MultiplicativeExpression_282_Var
		.getExpr();
		Assert.assertNotNull(Expr_282_list);
		Assert.assertEquals(1, Expr_282_list.size());
		//282
		final CastExpression CastExpression_283_Var
		 = (CastExpression)Expr_282_list.get(0);
		Assert.assertNotNull(CastExpression_283_Var
		);
		//283
		final UnaryExpression UnaryExpression_284_Var
		 = (UnaryExpression)CastExpression_283_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_284_Var
		);
		//284
		final PostfixExpression PostfixExpression_285_Var
		 = (PostfixExpression)UnaryExpression_284_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_285_Var
		);
		final EList<? extends EObject> Expr_285_list = PostfixExpression_285_Var
		.getExpr();
		Assert.assertNotNull(Expr_285_list);
		Assert.assertEquals(1, Expr_285_list.size());
		//285
		final PrimaryExpression PrimaryExpression_286_Var
		 = (PrimaryExpression)Expr_285_list.get(0);
		Assert.assertNotNull(PrimaryExpression_286_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_286_Var
		.getId());
		final EList<? extends EObject> Suffix_286_list = PostfixExpression_285_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_286_list);
		Assert.assertEquals(1, Suffix_286_list.size());
		//286
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_287_Var
		 = (PostfixExpressionSuffixArgument)Suffix_286_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_287_Var
		);
		//287
		final ArgumentExpressionList ArgumentExpressionList_288_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_287_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_288_Var
		);
		final EList<? extends EObject> Expr_288_list = ArgumentExpressionList_288_Var
		.getExpr();
		Assert.assertNotNull(Expr_288_list);
		Assert.assertEquals(2, Expr_288_list.size());
		//288
		final AssignmentExpression AssignmentExpression_289_Var
		 = (AssignmentExpression)Expr_288_list.get(0);
		Assert.assertNotNull(AssignmentExpression_289_Var
		);
		//289
		final ConditionalExpression ConditionalExpression_290_Var
		 = (ConditionalExpression)AssignmentExpression_289_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_290_Var
		);
		//290
		final LogicalOrExpression LogicalOrExpression_291_Var
		 = (LogicalOrExpression)ConditionalExpression_290_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_291_Var
		);
		final EList<? extends EObject> Expr_291_list = LogicalOrExpression_291_Var
		.getExpr();
		Assert.assertNotNull(Expr_291_list);
		Assert.assertEquals(1, Expr_291_list.size());
		//291
		final LogicalAndExpression LogicalAndExpression_292_Var
		 = (LogicalAndExpression)Expr_291_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_292_Var
		);
		final EList<? extends EObject> Expr_292_list = LogicalAndExpression_292_Var
		.getExpr();
		Assert.assertNotNull(Expr_292_list);
		Assert.assertEquals(1, Expr_292_list.size());
		//292
		final InclusiveOrExpression InclusiveOrExpression_293_Var
		 = (InclusiveOrExpression)Expr_292_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = InclusiveOrExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final ExclusiveOrExpression ExclusiveOrExpression_294_Var
		 = (ExclusiveOrExpression)Expr_293_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_294_Var
		);
		final EList<? extends EObject> Expr_294_list = ExclusiveOrExpression_294_Var
		.getExpr();
		Assert.assertNotNull(Expr_294_list);
		Assert.assertEquals(1, Expr_294_list.size());
		//294
		final AndExpression AndExpression_295_Var
		 = (AndExpression)Expr_294_list.get(0);
		Assert.assertNotNull(AndExpression_295_Var
		);
		final EList<? extends EObject> Expr_295_list = AndExpression_295_Var
		.getExpr();
		Assert.assertNotNull(Expr_295_list);
		Assert.assertEquals(1, Expr_295_list.size());
		//295
		final EqualityExpression EqualityExpression_296_Var
		 = (EqualityExpression)Expr_295_list.get(0);
		Assert.assertNotNull(EqualityExpression_296_Var
		);
		final EList<? extends EObject> Expr_296_list = EqualityExpression_296_Var
		.getExpr();
		Assert.assertNotNull(Expr_296_list);
		Assert.assertEquals(1, Expr_296_list.size());
		//296
		final RelationalExpression RelationalExpression_297_Var
		 = (RelationalExpression)Expr_296_list.get(0);
		Assert.assertNotNull(RelationalExpression_297_Var
		);
		final EList<? extends EObject> Expr_297_list = RelationalExpression_297_Var
		.getExpr();
		Assert.assertNotNull(Expr_297_list);
		Assert.assertEquals(1, Expr_297_list.size());
		//297
		final ShiftExpression ShiftExpression_298_Var
		 = (ShiftExpression)Expr_297_list.get(0);
		Assert.assertNotNull(ShiftExpression_298_Var
		);
		final EList<? extends EObject> Expr_298_list = ShiftExpression_298_Var
		.getExpr();
		Assert.assertNotNull(Expr_298_list);
		Assert.assertEquals(1, Expr_298_list.size());
		//298
		final AdditiveExpression AdditiveExpression_299_Var
		 = (AdditiveExpression)Expr_298_list.get(0);
		Assert.assertNotNull(AdditiveExpression_299_Var
		);
		final EList<? extends EObject> Expr_299_list = AdditiveExpression_299_Var
		.getExpr();
		Assert.assertNotNull(Expr_299_list);
		Assert.assertEquals(1, Expr_299_list.size());
		//299
		final MultiplicativeExpression MultiplicativeExpression_300_Var
		 = (MultiplicativeExpression)Expr_299_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_300_Var
		);
		final EList<? extends EObject> Expr_300_list = MultiplicativeExpression_300_Var
		.getExpr();
		Assert.assertNotNull(Expr_300_list);
		Assert.assertEquals(1, Expr_300_list.size());
		//300
		final CastExpression CastExpression_301_Var
		 = (CastExpression)Expr_300_list.get(0);
		Assert.assertNotNull(CastExpression_301_Var
		);
		//301
		final UnaryExpression UnaryExpression_302_Var
		 = (UnaryExpression)CastExpression_301_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_302_Var
		);
		//302
		final PostfixExpression PostfixExpression_303_Var
		 = (PostfixExpression)UnaryExpression_302_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_303_Var
		);
		final EList<? extends EObject> Expr_303_list = PostfixExpression_303_Var
		.getExpr();
		Assert.assertNotNull(Expr_303_list);
		Assert.assertEquals(1, Expr_303_list.size());
		//303
		final PrimaryExpression PrimaryExpression_304_Var
		 = (PrimaryExpression)Expr_303_list.get(0);
		Assert.assertNotNull(PrimaryExpression_304_Var
		);
		//304
		final Constant Constant_305_Var
		 = (Constant)PrimaryExpression_304_Var
		.getConst();
		Assert.assertNotNull(Constant_305_Var
		);
		Assert.assertEquals("\"%s\\n\"", Constant_305_Var
		.getStr());
		//305
		final AssignmentExpression AssignmentExpression_306_Var
		 = (AssignmentExpression)Expr_288_list.get(1);
		Assert.assertNotNull(AssignmentExpression_306_Var
		);
		//306
		final ConditionalExpression ConditionalExpression_307_Var
		 = (ConditionalExpression)AssignmentExpression_306_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_307_Var
		);
		//307
		final LogicalOrExpression LogicalOrExpression_308_Var
		 = (LogicalOrExpression)ConditionalExpression_307_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_308_Var
		);
		final EList<? extends EObject> Expr_308_list = LogicalOrExpression_308_Var
		.getExpr();
		Assert.assertNotNull(Expr_308_list);
		Assert.assertEquals(1, Expr_308_list.size());
		//308
		final LogicalAndExpression LogicalAndExpression_309_Var
		 = (LogicalAndExpression)Expr_308_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_309_Var
		);
		final EList<? extends EObject> Expr_309_list = LogicalAndExpression_309_Var
		.getExpr();
		Assert.assertNotNull(Expr_309_list);
		Assert.assertEquals(1, Expr_309_list.size());
		//309
		final InclusiveOrExpression InclusiveOrExpression_310_Var
		 = (InclusiveOrExpression)Expr_309_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_310_Var
		);
		final EList<? extends EObject> Expr_310_list = InclusiveOrExpression_310_Var
		.getExpr();
		Assert.assertNotNull(Expr_310_list);
		Assert.assertEquals(1, Expr_310_list.size());
		//310
		final ExclusiveOrExpression ExclusiveOrExpression_311_Var
		 = (ExclusiveOrExpression)Expr_310_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = ExclusiveOrExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final AndExpression AndExpression_312_Var
		 = (AndExpression)Expr_311_list.get(0);
		Assert.assertNotNull(AndExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = AndExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final EqualityExpression EqualityExpression_313_Var
		 = (EqualityExpression)Expr_312_list.get(0);
		Assert.assertNotNull(EqualityExpression_313_Var
		);
		final EList<? extends EObject> Expr_313_list = EqualityExpression_313_Var
		.getExpr();
		Assert.assertNotNull(Expr_313_list);
		Assert.assertEquals(1, Expr_313_list.size());
		//313
		final RelationalExpression RelationalExpression_314_Var
		 = (RelationalExpression)Expr_313_list.get(0);
		Assert.assertNotNull(RelationalExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = RelationalExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final ShiftExpression ShiftExpression_315_Var
		 = (ShiftExpression)Expr_314_list.get(0);
		Assert.assertNotNull(ShiftExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = ShiftExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final AdditiveExpression AdditiveExpression_316_Var
		 = (AdditiveExpression)Expr_315_list.get(0);
		Assert.assertNotNull(AdditiveExpression_316_Var
		);
		final EList<? extends EObject> Expr_316_list = AdditiveExpression_316_Var
		.getExpr();
		Assert.assertNotNull(Expr_316_list);
		Assert.assertEquals(1, Expr_316_list.size());
		//316
		final MultiplicativeExpression MultiplicativeExpression_317_Var
		 = (MultiplicativeExpression)Expr_316_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_317_Var
		);
		final EList<? extends EObject> Expr_317_list = MultiplicativeExpression_317_Var
		.getExpr();
		Assert.assertNotNull(Expr_317_list);
		Assert.assertEquals(1, Expr_317_list.size());
		//317
		final CastExpression CastExpression_318_Var
		 = (CastExpression)Expr_317_list.get(0);
		Assert.assertNotNull(CastExpression_318_Var
		);
		//318
		final UnaryExpression UnaryExpression_319_Var
		 = (UnaryExpression)CastExpression_318_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_319_Var
		);
		//319
		final PostfixExpression PostfixExpression_320_Var
		 = (PostfixExpression)UnaryExpression_319_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_320_Var
		);
		final EList<? extends EObject> Expr_320_list = PostfixExpression_320_Var
		.getExpr();
		Assert.assertNotNull(Expr_320_list);
		Assert.assertEquals(1, Expr_320_list.size());
		//320
		final PrimaryExpression PrimaryExpression_321_Var
		 = (PrimaryExpression)Expr_320_list.get(0);
		Assert.assertNotNull(PrimaryExpression_321_Var
		);
		Assert.assertEquals("out", PrimaryExpression_321_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_269_Var
		.getSemi());
		//321
		final Statement Statement_322_Var
		 = (Statement)Statement_61_list.get(5);
		Assert.assertNotNull(Statement_322_Var
		);
		//322
		final JumpStatement JumpStatement_323_Var
		 = (JumpStatement)Statement_322_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_323_Var
		);
		//323
		final Expression Expression_324_Var
		 = (Expression)JumpStatement_323_Var
		.getExpr();
		Assert.assertNotNull(Expression_324_Var
		);
		final EList<? extends EObject> ExprExpr_324_list = Expression_324_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_324_list);
		Assert.assertEquals(1, ExprExpr_324_list.size());
		//324
		final AssignmentExpression AssignmentExpression_325_Var
		 = (AssignmentExpression)ExprExpr_324_list.get(0);
		Assert.assertNotNull(AssignmentExpression_325_Var
		);
		//325
		final ConditionalExpression ConditionalExpression_326_Var
		 = (ConditionalExpression)AssignmentExpression_325_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_326_Var
		);
		//326
		final LogicalOrExpression LogicalOrExpression_327_Var
		 = (LogicalOrExpression)ConditionalExpression_326_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_327_Var
		);
		final EList<? extends EObject> Expr_327_list = LogicalOrExpression_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final LogicalAndExpression LogicalAndExpression_328_Var
		 = (LogicalAndExpression)Expr_327_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_328_Var
		);
		final EList<? extends EObject> Expr_328_list = LogicalAndExpression_328_Var
		.getExpr();
		Assert.assertNotNull(Expr_328_list);
		Assert.assertEquals(1, Expr_328_list.size());
		//328
		final InclusiveOrExpression InclusiveOrExpression_329_Var
		 = (InclusiveOrExpression)Expr_328_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_329_Var
		);
		final EList<? extends EObject> Expr_329_list = InclusiveOrExpression_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final ExclusiveOrExpression ExclusiveOrExpression_330_Var
		 = (ExclusiveOrExpression)Expr_329_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_330_Var
		);
		final EList<? extends EObject> Expr_330_list = ExclusiveOrExpression_330_Var
		.getExpr();
		Assert.assertNotNull(Expr_330_list);
		Assert.assertEquals(1, Expr_330_list.size());
		//330
		final AndExpression AndExpression_331_Var
		 = (AndExpression)Expr_330_list.get(0);
		Assert.assertNotNull(AndExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = AndExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final EqualityExpression EqualityExpression_332_Var
		 = (EqualityExpression)Expr_331_list.get(0);
		Assert.assertNotNull(EqualityExpression_332_Var
		);
		final EList<? extends EObject> Expr_332_list = EqualityExpression_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final RelationalExpression RelationalExpression_333_Var
		 = (RelationalExpression)Expr_332_list.get(0);
		Assert.assertNotNull(RelationalExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = RelationalExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final ShiftExpression ShiftExpression_334_Var
		 = (ShiftExpression)Expr_333_list.get(0);
		Assert.assertNotNull(ShiftExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = ShiftExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final AdditiveExpression AdditiveExpression_335_Var
		 = (AdditiveExpression)Expr_334_list.get(0);
		Assert.assertNotNull(AdditiveExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = AdditiveExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final MultiplicativeExpression MultiplicativeExpression_336_Var
		 = (MultiplicativeExpression)Expr_335_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = MultiplicativeExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final CastExpression CastExpression_337_Var
		 = (CastExpression)Expr_336_list.get(0);
		Assert.assertNotNull(CastExpression_337_Var
		);
		//337
		final UnaryExpression UnaryExpression_338_Var
		 = (UnaryExpression)CastExpression_337_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_338_Var
		);
		//338
		final PostfixExpression PostfixExpression_339_Var
		 = (PostfixExpression)UnaryExpression_338_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_339_Var
		);
		final EList<? extends EObject> Expr_339_list = PostfixExpression_339_Var
		.getExpr();
		Assert.assertNotNull(Expr_339_list);
		Assert.assertEquals(1, Expr_339_list.size());
		//339
		final PrimaryExpression PrimaryExpression_340_Var
		 = (PrimaryExpression)Expr_339_list.get(0);
		Assert.assertNotNull(PrimaryExpression_340_Var
		);
		//340
		final Constant Constant_341_Var
		 = (Constant)PrimaryExpression_340_Var
		.getConst();
		Assert.assertNotNull(Constant_341_Var
		);
		Assert.assertEquals("0", Constant_341_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_323_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_323_Var
		.getSemi());
	}
	
	@Test
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
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0035_SimpleArray.c");
		final String expected = this.getTextFromFile(
			"res/Test0035_SimpleArray.c"
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


