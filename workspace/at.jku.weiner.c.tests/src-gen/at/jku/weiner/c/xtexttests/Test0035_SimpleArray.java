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
	
	private String preprocess(final String string) {
		final String lineComment = string.replaceAll("//.*\n", " ");
		final String blockComment = lineComment.replaceAll("/\\*.*\\*/", " ");
		final String lines = blockComment.replaceAll("\n", " ").trim();
		final String multi = lines.replaceAll("\\s{2,}", " ").trim();
		final String sign = multi.replaceAll("\\s+([^a-zA-Z0-9_])", "$1")
				.trim();
		final String sign2 = sign.replaceAll("([^a-zA-Z0-9_])\\s+", "$1")
				.trim();
	
		// System.out.println(sign2);
		return sign2;
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
		final EList<? extends EObject> ArgumentExpressionList_80_list = PostfixExpression_79_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_80_list);
		Assert.assertEquals(1, ArgumentExpressionList_80_list.size());
		//80
		final ArgumentExpressionList ArgumentExpressionList_81_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_80_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_81_Var
		);
		final EList<? extends EObject> Expr_81_list = ArgumentExpressionList_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(2, Expr_81_list.size());
		//81
		final AssignmentExpression AssignmentExpression_82_Var
		 = (AssignmentExpression)Expr_81_list.get(0);
		Assert.assertNotNull(AssignmentExpression_82_Var
		);
		//82
		final ConditionalExpression ConditionalExpression_83_Var
		 = (ConditionalExpression)AssignmentExpression_82_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_83_Var
		);
		//83
		final LogicalOrExpression LogicalOrExpression_84_Var
		 = (LogicalOrExpression)ConditionalExpression_83_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = LogicalOrExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final LogicalAndExpression LogicalAndExpression_85_Var
		 = (LogicalAndExpression)Expr_84_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = LogicalAndExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final InclusiveOrExpression InclusiveOrExpression_86_Var
		 = (InclusiveOrExpression)Expr_85_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = InclusiveOrExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final ExclusiveOrExpression ExclusiveOrExpression_87_Var
		 = (ExclusiveOrExpression)Expr_86_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = ExclusiveOrExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final AndExpression AndExpression_88_Var
		 = (AndExpression)Expr_87_list.get(0);
		Assert.assertNotNull(AndExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = AndExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final EqualityExpression EqualityExpression_89_Var
		 = (EqualityExpression)Expr_88_list.get(0);
		Assert.assertNotNull(EqualityExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = EqualityExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final RelationalExpression RelationalExpression_90_Var
		 = (RelationalExpression)Expr_89_list.get(0);
		Assert.assertNotNull(RelationalExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = RelationalExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final ShiftExpression ShiftExpression_91_Var
		 = (ShiftExpression)Expr_90_list.get(0);
		Assert.assertNotNull(ShiftExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = ShiftExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final AdditiveExpression AdditiveExpression_92_Var
		 = (AdditiveExpression)Expr_91_list.get(0);
		Assert.assertNotNull(AdditiveExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = AdditiveExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final MultiplicativeExpression MultiplicativeExpression_93_Var
		 = (MultiplicativeExpression)Expr_92_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = MultiplicativeExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final CastExpression CastExpression_94_Var
		 = (CastExpression)Expr_93_list.get(0);
		Assert.assertNotNull(CastExpression_94_Var
		);
		//94
		final UnaryExpression UnaryExpression_95_Var
		 = (UnaryExpression)CastExpression_94_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_95_Var
		);
		//95
		final PostfixExpression PostfixExpression_96_Var
		 = (PostfixExpression)UnaryExpression_95_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = PostfixExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final PrimaryExpression PrimaryExpression_97_Var
		 = (PrimaryExpression)Expr_96_list.get(0);
		Assert.assertNotNull(PrimaryExpression_97_Var
		);
		//97
		final Constant Constant_98_Var
		 = (Constant)PrimaryExpression_97_Var
		.getConst();
		Assert.assertNotNull(Constant_98_Var
		);
		Assert.assertEquals("\"%s\\n\"", Constant_98_Var
		.getStr());
		//98
		final AssignmentExpression AssignmentExpression_99_Var
		 = (AssignmentExpression)Expr_81_list.get(1);
		Assert.assertNotNull(AssignmentExpression_99_Var
		);
		//99
		final ConditionalExpression ConditionalExpression_100_Var
		 = (ConditionalExpression)AssignmentExpression_99_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_100_Var
		);
		//100
		final LogicalOrExpression LogicalOrExpression_101_Var
		 = (LogicalOrExpression)ConditionalExpression_100_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = LogicalOrExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final LogicalAndExpression LogicalAndExpression_102_Var
		 = (LogicalAndExpression)Expr_101_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = LogicalAndExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final InclusiveOrExpression InclusiveOrExpression_103_Var
		 = (InclusiveOrExpression)Expr_102_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = InclusiveOrExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final ExclusiveOrExpression ExclusiveOrExpression_104_Var
		 = (ExclusiveOrExpression)Expr_103_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = ExclusiveOrExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final AndExpression AndExpression_105_Var
		 = (AndExpression)Expr_104_list.get(0);
		Assert.assertNotNull(AndExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = AndExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final EqualityExpression EqualityExpression_106_Var
		 = (EqualityExpression)Expr_105_list.get(0);
		Assert.assertNotNull(EqualityExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = EqualityExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final RelationalExpression RelationalExpression_107_Var
		 = (RelationalExpression)Expr_106_list.get(0);
		Assert.assertNotNull(RelationalExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = RelationalExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final ShiftExpression ShiftExpression_108_Var
		 = (ShiftExpression)Expr_107_list.get(0);
		Assert.assertNotNull(ShiftExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = ShiftExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final AdditiveExpression AdditiveExpression_109_Var
		 = (AdditiveExpression)Expr_108_list.get(0);
		Assert.assertNotNull(AdditiveExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = AdditiveExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final MultiplicativeExpression MultiplicativeExpression_110_Var
		 = (MultiplicativeExpression)Expr_109_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = MultiplicativeExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final CastExpression CastExpression_111_Var
		 = (CastExpression)Expr_110_list.get(0);
		Assert.assertNotNull(CastExpression_111_Var
		);
		//111
		final UnaryExpression UnaryExpression_112_Var
		 = (UnaryExpression)CastExpression_111_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_112_Var
		);
		//112
		final PostfixExpression PostfixExpression_113_Var
		 = (PostfixExpression)UnaryExpression_112_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = PostfixExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final PrimaryExpression PrimaryExpression_114_Var
		 = (PrimaryExpression)Expr_113_list.get(0);
		Assert.assertNotNull(PrimaryExpression_114_Var
		);
		Assert.assertEquals("out", PrimaryExpression_114_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_63_Var
		.getSemi());
		//114
		final Statement Statement_115_Var
		 = (Statement)Statement_61_list.get(1);
		Assert.assertNotNull(Statement_115_Var
		);
		//115
		final ExpressionStatement ExpressionStatement_116_Var
		 = (ExpressionStatement)Statement_115_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_116_Var
		);
		//116
		final Expression Expression_117_Var
		 = (Expression)ExpressionStatement_116_Var
		.getExpression();
		Assert.assertNotNull(Expression_117_Var
		);
		final EList<? extends EObject> ExprExpr_117_list = Expression_117_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_117_list);
		Assert.assertEquals(1, ExprExpr_117_list.size());
		//117
		final AssignmentExpression AssignmentExpression_118_Var
		 = (AssignmentExpression)ExprExpr_117_list.get(0);
		Assert.assertNotNull(AssignmentExpression_118_Var
		);
		//118
		final ConditionalExpression ConditionalExpression_119_Var
		 = (ConditionalExpression)AssignmentExpression_118_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_119_Var
		);
		//119
		final LogicalOrExpression LogicalOrExpression_120_Var
		 = (LogicalOrExpression)ConditionalExpression_119_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = LogicalOrExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final LogicalAndExpression LogicalAndExpression_121_Var
		 = (LogicalAndExpression)Expr_120_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = LogicalAndExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final InclusiveOrExpression InclusiveOrExpression_122_Var
		 = (InclusiveOrExpression)Expr_121_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = InclusiveOrExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final ExclusiveOrExpression ExclusiveOrExpression_123_Var
		 = (ExclusiveOrExpression)Expr_122_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = ExclusiveOrExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final AndExpression AndExpression_124_Var
		 = (AndExpression)Expr_123_list.get(0);
		Assert.assertNotNull(AndExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = AndExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final EqualityExpression EqualityExpression_125_Var
		 = (EqualityExpression)Expr_124_list.get(0);
		Assert.assertNotNull(EqualityExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = EqualityExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final RelationalExpression RelationalExpression_126_Var
		 = (RelationalExpression)Expr_125_list.get(0);
		Assert.assertNotNull(RelationalExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = RelationalExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final ShiftExpression ShiftExpression_127_Var
		 = (ShiftExpression)Expr_126_list.get(0);
		Assert.assertNotNull(ShiftExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = ShiftExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final AdditiveExpression AdditiveExpression_128_Var
		 = (AdditiveExpression)Expr_127_list.get(0);
		Assert.assertNotNull(AdditiveExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = AdditiveExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final MultiplicativeExpression MultiplicativeExpression_129_Var
		 = (MultiplicativeExpression)Expr_128_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = MultiplicativeExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final CastExpression CastExpression_130_Var
		 = (CastExpression)Expr_129_list.get(0);
		Assert.assertNotNull(CastExpression_130_Var
		);
		//130
		final UnaryExpression UnaryExpression_131_Var
		 = (UnaryExpression)CastExpression_130_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_131_Var
		);
		//131
		final PostfixExpression PostfixExpression_132_Var
		 = (PostfixExpression)UnaryExpression_131_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = PostfixExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final PrimaryExpression PrimaryExpression_133_Var
		 = (PrimaryExpression)Expr_132_list.get(0);
		Assert.assertNotNull(PrimaryExpression_133_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_133_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_133_list = PostfixExpression_132_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_133_list);
		Assert.assertEquals(1, ArgumentExpressionList_133_list.size());
		//133
		final ArgumentExpressionList ArgumentExpressionList_134_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_133_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_134_Var
		);
		final EList<? extends EObject> Expr_134_list = ArgumentExpressionList_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(2, Expr_134_list.size());
		//134
		final AssignmentExpression AssignmentExpression_135_Var
		 = (AssignmentExpression)Expr_134_list.get(0);
		Assert.assertNotNull(AssignmentExpression_135_Var
		);
		//135
		final ConditionalExpression ConditionalExpression_136_Var
		 = (ConditionalExpression)AssignmentExpression_135_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_136_Var
		);
		//136
		final LogicalOrExpression LogicalOrExpression_137_Var
		 = (LogicalOrExpression)ConditionalExpression_136_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = LogicalOrExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final LogicalAndExpression LogicalAndExpression_138_Var
		 = (LogicalAndExpression)Expr_137_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = LogicalAndExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final InclusiveOrExpression InclusiveOrExpression_139_Var
		 = (InclusiveOrExpression)Expr_138_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = InclusiveOrExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final ExclusiveOrExpression ExclusiveOrExpression_140_Var
		 = (ExclusiveOrExpression)Expr_139_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = ExclusiveOrExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final AndExpression AndExpression_141_Var
		 = (AndExpression)Expr_140_list.get(0);
		Assert.assertNotNull(AndExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = AndExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final EqualityExpression EqualityExpression_142_Var
		 = (EqualityExpression)Expr_141_list.get(0);
		Assert.assertNotNull(EqualityExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = EqualityExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final RelationalExpression RelationalExpression_143_Var
		 = (RelationalExpression)Expr_142_list.get(0);
		Assert.assertNotNull(RelationalExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = RelationalExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final ShiftExpression ShiftExpression_144_Var
		 = (ShiftExpression)Expr_143_list.get(0);
		Assert.assertNotNull(ShiftExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = ShiftExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final AdditiveExpression AdditiveExpression_145_Var
		 = (AdditiveExpression)Expr_144_list.get(0);
		Assert.assertNotNull(AdditiveExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = AdditiveExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final MultiplicativeExpression MultiplicativeExpression_146_Var
		 = (MultiplicativeExpression)Expr_145_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_146_Var
		);
		final EList<? extends EObject> Expr_146_list = MultiplicativeExpression_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final CastExpression CastExpression_147_Var
		 = (CastExpression)Expr_146_list.get(0);
		Assert.assertNotNull(CastExpression_147_Var
		);
		//147
		final UnaryExpression UnaryExpression_148_Var
		 = (UnaryExpression)CastExpression_147_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_148_Var
		);
		//148
		final PostfixExpression PostfixExpression_149_Var
		 = (PostfixExpression)UnaryExpression_148_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_149_Var
		);
		final EList<? extends EObject> Expr_149_list = PostfixExpression_149_Var
		.getExpr();
		Assert.assertNotNull(Expr_149_list);
		Assert.assertEquals(1, Expr_149_list.size());
		//149
		final PrimaryExpression PrimaryExpression_150_Var
		 = (PrimaryExpression)Expr_149_list.get(0);
		Assert.assertNotNull(PrimaryExpression_150_Var
		);
		Assert.assertEquals("out", PrimaryExpression_150_Var
		.getId());
		//150
		final AssignmentExpression AssignmentExpression_151_Var
		 = (AssignmentExpression)Expr_134_list.get(1);
		Assert.assertNotNull(AssignmentExpression_151_Var
		);
		//151
		final ConditionalExpression ConditionalExpression_152_Var
		 = (ConditionalExpression)AssignmentExpression_151_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_152_Var
		);
		//152
		final LogicalOrExpression LogicalOrExpression_153_Var
		 = (LogicalOrExpression)ConditionalExpression_152_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_153_Var
		);
		final EList<? extends EObject> Expr_153_list = LogicalOrExpression_153_Var
		.getExpr();
		Assert.assertNotNull(Expr_153_list);
		Assert.assertEquals(1, Expr_153_list.size());
		//153
		final LogicalAndExpression LogicalAndExpression_154_Var
		 = (LogicalAndExpression)Expr_153_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_154_Var
		);
		final EList<? extends EObject> Expr_154_list = LogicalAndExpression_154_Var
		.getExpr();
		Assert.assertNotNull(Expr_154_list);
		Assert.assertEquals(1, Expr_154_list.size());
		//154
		final InclusiveOrExpression InclusiveOrExpression_155_Var
		 = (InclusiveOrExpression)Expr_154_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_155_Var
		);
		final EList<? extends EObject> Expr_155_list = InclusiveOrExpression_155_Var
		.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		//155
		final ExclusiveOrExpression ExclusiveOrExpression_156_Var
		 = (ExclusiveOrExpression)Expr_155_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_156_Var
		);
		final EList<? extends EObject> Expr_156_list = ExclusiveOrExpression_156_Var
		.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		//156
		final AndExpression AndExpression_157_Var
		 = (AndExpression)Expr_156_list.get(0);
		Assert.assertNotNull(AndExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = AndExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final EqualityExpression EqualityExpression_158_Var
		 = (EqualityExpression)Expr_157_list.get(0);
		Assert.assertNotNull(EqualityExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = EqualityExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final RelationalExpression RelationalExpression_159_Var
		 = (RelationalExpression)Expr_158_list.get(0);
		Assert.assertNotNull(RelationalExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = RelationalExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final ShiftExpression ShiftExpression_160_Var
		 = (ShiftExpression)Expr_159_list.get(0);
		Assert.assertNotNull(ShiftExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = ShiftExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final AdditiveExpression AdditiveExpression_161_Var
		 = (AdditiveExpression)Expr_160_list.get(0);
		Assert.assertNotNull(AdditiveExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = AdditiveExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final MultiplicativeExpression MultiplicativeExpression_162_Var
		 = (MultiplicativeExpression)Expr_161_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_162_Var
		);
		final EList<? extends EObject> Expr_162_list = MultiplicativeExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		//162
		final CastExpression CastExpression_163_Var
		 = (CastExpression)Expr_162_list.get(0);
		Assert.assertNotNull(CastExpression_163_Var
		);
		//163
		final UnaryExpression UnaryExpression_164_Var
		 = (UnaryExpression)CastExpression_163_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_164_Var
		);
		//164
		final PostfixExpression PostfixExpression_165_Var
		 = (PostfixExpression)UnaryExpression_164_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_165_Var
		);
		final EList<? extends EObject> Expr_165_list = PostfixExpression_165_Var
		.getExpr();
		Assert.assertNotNull(Expr_165_list);
		Assert.assertEquals(1, Expr_165_list.size());
		//165
		final PrimaryExpression PrimaryExpression_166_Var
		 = (PrimaryExpression)Expr_165_list.get(0);
		Assert.assertNotNull(PrimaryExpression_166_Var
		);
		//166
		final Constant Constant_167_Var
		 = (Constant)PrimaryExpression_166_Var
		.getConst();
		Assert.assertNotNull(Constant_167_Var
		);
		Assert.assertEquals("\"Hello World!\"", Constant_167_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_116_Var
		.getSemi());
		//167
		final Statement Statement_168_Var
		 = (Statement)Statement_61_list.get(2);
		Assert.assertNotNull(Statement_168_Var
		);
		//168
		final ExpressionStatement ExpressionStatement_169_Var
		 = (ExpressionStatement)Statement_168_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_169_Var
		);
		//169
		final Expression Expression_170_Var
		 = (Expression)ExpressionStatement_169_Var
		.getExpression();
		Assert.assertNotNull(Expression_170_Var
		);
		final EList<? extends EObject> ExprExpr_170_list = Expression_170_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_170_list);
		Assert.assertEquals(1, ExprExpr_170_list.size());
		//170
		final AssignmentExpression AssignmentExpression_171_Var
		 = (AssignmentExpression)ExprExpr_170_list.get(0);
		Assert.assertNotNull(AssignmentExpression_171_Var
		);
		//171
		final ConditionalExpression ConditionalExpression_172_Var
		 = (ConditionalExpression)AssignmentExpression_171_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_172_Var
		);
		//172
		final LogicalOrExpression LogicalOrExpression_173_Var
		 = (LogicalOrExpression)ConditionalExpression_172_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = LogicalOrExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final LogicalAndExpression LogicalAndExpression_174_Var
		 = (LogicalAndExpression)Expr_173_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = LogicalAndExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final InclusiveOrExpression InclusiveOrExpression_175_Var
		 = (InclusiveOrExpression)Expr_174_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = InclusiveOrExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final ExclusiveOrExpression ExclusiveOrExpression_176_Var
		 = (ExclusiveOrExpression)Expr_175_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = ExclusiveOrExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final AndExpression AndExpression_177_Var
		 = (AndExpression)Expr_176_list.get(0);
		Assert.assertNotNull(AndExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = AndExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final EqualityExpression EqualityExpression_178_Var
		 = (EqualityExpression)Expr_177_list.get(0);
		Assert.assertNotNull(EqualityExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = EqualityExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final RelationalExpression RelationalExpression_179_Var
		 = (RelationalExpression)Expr_178_list.get(0);
		Assert.assertNotNull(RelationalExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = RelationalExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final ShiftExpression ShiftExpression_180_Var
		 = (ShiftExpression)Expr_179_list.get(0);
		Assert.assertNotNull(ShiftExpression_180_Var
		);
		final EList<? extends EObject> Expr_180_list = ShiftExpression_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final AdditiveExpression AdditiveExpression_181_Var
		 = (AdditiveExpression)Expr_180_list.get(0);
		Assert.assertNotNull(AdditiveExpression_181_Var
		);
		final EList<? extends EObject> Expr_181_list = AdditiveExpression_181_Var
		.getExpr();
		Assert.assertNotNull(Expr_181_list);
		Assert.assertEquals(1, Expr_181_list.size());
		//181
		final MultiplicativeExpression MultiplicativeExpression_182_Var
		 = (MultiplicativeExpression)Expr_181_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_182_Var
		);
		final EList<? extends EObject> Expr_182_list = MultiplicativeExpression_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(1, Expr_182_list.size());
		//182
		final CastExpression CastExpression_183_Var
		 = (CastExpression)Expr_182_list.get(0);
		Assert.assertNotNull(CastExpression_183_Var
		);
		//183
		final UnaryExpression UnaryExpression_184_Var
		 = (UnaryExpression)CastExpression_183_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_184_Var
		);
		//184
		final PostfixExpression PostfixExpression_185_Var
		 = (PostfixExpression)UnaryExpression_184_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_185_Var
		);
		final EList<? extends EObject> Expr_185_list = PostfixExpression_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final PrimaryExpression PrimaryExpression_186_Var
		 = (PrimaryExpression)Expr_185_list.get(0);
		Assert.assertNotNull(PrimaryExpression_186_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_186_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_186_list = PostfixExpression_185_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_186_list);
		Assert.assertEquals(1, ArgumentExpressionList_186_list.size());
		//186
		final ArgumentExpressionList ArgumentExpressionList_187_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_186_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_187_Var
		);
		final EList<? extends EObject> Expr_187_list = ArgumentExpressionList_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(2, Expr_187_list.size());
		//187
		final AssignmentExpression AssignmentExpression_188_Var
		 = (AssignmentExpression)Expr_187_list.get(0);
		Assert.assertNotNull(AssignmentExpression_188_Var
		);
		//188
		final ConditionalExpression ConditionalExpression_189_Var
		 = (ConditionalExpression)AssignmentExpression_188_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_189_Var
		);
		//189
		final LogicalOrExpression LogicalOrExpression_190_Var
		 = (LogicalOrExpression)ConditionalExpression_189_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = LogicalOrExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final LogicalAndExpression LogicalAndExpression_191_Var
		 = (LogicalAndExpression)Expr_190_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = LogicalAndExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final InclusiveOrExpression InclusiveOrExpression_192_Var
		 = (InclusiveOrExpression)Expr_191_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = InclusiveOrExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final ExclusiveOrExpression ExclusiveOrExpression_193_Var
		 = (ExclusiveOrExpression)Expr_192_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = ExclusiveOrExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final AndExpression AndExpression_194_Var
		 = (AndExpression)Expr_193_list.get(0);
		Assert.assertNotNull(AndExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = AndExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final EqualityExpression EqualityExpression_195_Var
		 = (EqualityExpression)Expr_194_list.get(0);
		Assert.assertNotNull(EqualityExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = EqualityExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final RelationalExpression RelationalExpression_196_Var
		 = (RelationalExpression)Expr_195_list.get(0);
		Assert.assertNotNull(RelationalExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = RelationalExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final ShiftExpression ShiftExpression_197_Var
		 = (ShiftExpression)Expr_196_list.get(0);
		Assert.assertNotNull(ShiftExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = ShiftExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final AdditiveExpression AdditiveExpression_198_Var
		 = (AdditiveExpression)Expr_197_list.get(0);
		Assert.assertNotNull(AdditiveExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = AdditiveExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final MultiplicativeExpression MultiplicativeExpression_199_Var
		 = (MultiplicativeExpression)Expr_198_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = MultiplicativeExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final CastExpression CastExpression_200_Var
		 = (CastExpression)Expr_199_list.get(0);
		Assert.assertNotNull(CastExpression_200_Var
		);
		//200
		final UnaryExpression UnaryExpression_201_Var
		 = (UnaryExpression)CastExpression_200_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_201_Var
		);
		//201
		final PostfixExpression PostfixExpression_202_Var
		 = (PostfixExpression)UnaryExpression_201_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = PostfixExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final PrimaryExpression PrimaryExpression_203_Var
		 = (PrimaryExpression)Expr_202_list.get(0);
		Assert.assertNotNull(PrimaryExpression_203_Var
		);
		//203
		final Constant Constant_204_Var
		 = (Constant)PrimaryExpression_203_Var
		.getConst();
		Assert.assertNotNull(Constant_204_Var
		);
		Assert.assertEquals("\"%s\\n\"", Constant_204_Var
		.getStr());
		//204
		final AssignmentExpression AssignmentExpression_205_Var
		 = (AssignmentExpression)Expr_187_list.get(1);
		Assert.assertNotNull(AssignmentExpression_205_Var
		);
		//205
		final ConditionalExpression ConditionalExpression_206_Var
		 = (ConditionalExpression)AssignmentExpression_205_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_206_Var
		);
		//206
		final LogicalOrExpression LogicalOrExpression_207_Var
		 = (LogicalOrExpression)ConditionalExpression_206_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = LogicalOrExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final LogicalAndExpression LogicalAndExpression_208_Var
		 = (LogicalAndExpression)Expr_207_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = LogicalAndExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final InclusiveOrExpression InclusiveOrExpression_209_Var
		 = (InclusiveOrExpression)Expr_208_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = InclusiveOrExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final ExclusiveOrExpression ExclusiveOrExpression_210_Var
		 = (ExclusiveOrExpression)Expr_209_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = ExclusiveOrExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final AndExpression AndExpression_211_Var
		 = (AndExpression)Expr_210_list.get(0);
		Assert.assertNotNull(AndExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = AndExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final EqualityExpression EqualityExpression_212_Var
		 = (EqualityExpression)Expr_211_list.get(0);
		Assert.assertNotNull(EqualityExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = EqualityExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final RelationalExpression RelationalExpression_213_Var
		 = (RelationalExpression)Expr_212_list.get(0);
		Assert.assertNotNull(RelationalExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = RelationalExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final ShiftExpression ShiftExpression_214_Var
		 = (ShiftExpression)Expr_213_list.get(0);
		Assert.assertNotNull(ShiftExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = ShiftExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final AdditiveExpression AdditiveExpression_215_Var
		 = (AdditiveExpression)Expr_214_list.get(0);
		Assert.assertNotNull(AdditiveExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = AdditiveExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final MultiplicativeExpression MultiplicativeExpression_216_Var
		 = (MultiplicativeExpression)Expr_215_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = MultiplicativeExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final CastExpression CastExpression_217_Var
		 = (CastExpression)Expr_216_list.get(0);
		Assert.assertNotNull(CastExpression_217_Var
		);
		//217
		final UnaryExpression UnaryExpression_218_Var
		 = (UnaryExpression)CastExpression_217_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_218_Var
		);
		//218
		final PostfixExpression PostfixExpression_219_Var
		 = (PostfixExpression)UnaryExpression_218_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = PostfixExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final PrimaryExpression PrimaryExpression_220_Var
		 = (PrimaryExpression)Expr_219_list.get(0);
		Assert.assertNotNull(PrimaryExpression_220_Var
		);
		Assert.assertEquals("out", PrimaryExpression_220_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_169_Var
		.getSemi());
		//220
		final Statement Statement_221_Var
		 = (Statement)Statement_61_list.get(3);
		Assert.assertNotNull(Statement_221_Var
		);
		//221
		final ExpressionStatement ExpressionStatement_222_Var
		 = (ExpressionStatement)Statement_221_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_222_Var
		);
		//222
		final Expression Expression_223_Var
		 = (Expression)ExpressionStatement_222_Var
		.getExpression();
		Assert.assertNotNull(Expression_223_Var
		);
		final EList<? extends EObject> ExprExpr_223_list = Expression_223_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_223_list);
		Assert.assertEquals(1, ExprExpr_223_list.size());
		//223
		final AssignmentExpression AssignmentExpression_224_Var
		 = (AssignmentExpression)ExprExpr_223_list.get(0);
		Assert.assertNotNull(AssignmentExpression_224_Var
		);
		//224
		final UnaryExpression UnaryExpression_225_Var
		 = (UnaryExpression)AssignmentExpression_224_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_225_Var
		);
		//225
		final PostfixExpression PostfixExpression_226_Var
		 = (PostfixExpression)UnaryExpression_225_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = PostfixExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final PrimaryExpression PrimaryExpression_227_Var
		 = (PrimaryExpression)Expr_226_list.get(0);
		Assert.assertNotNull(PrimaryExpression_227_Var
		);
		Assert.assertEquals("out", PrimaryExpression_227_Var
		.getId());
		final EList<? extends EObject> ArrayExpr_227_list = PostfixExpression_226_Var
		.getArrayExpr();
		Assert.assertNotNull(ArrayExpr_227_list);
		Assert.assertEquals(1, ArrayExpr_227_list.size());
		//227
		final Expression Expression_228_Var
		 = (Expression)ArrayExpr_227_list.get(0);
		Assert.assertNotNull(Expression_228_Var
		);
		final EList<? extends EObject> ExprExpr_228_list = Expression_228_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_228_list);
		Assert.assertEquals(1, ExprExpr_228_list.size());
		//228
		final AssignmentExpression AssignmentExpression_229_Var
		 = (AssignmentExpression)ExprExpr_228_list.get(0);
		Assert.assertNotNull(AssignmentExpression_229_Var
		);
		//229
		final ConditionalExpression ConditionalExpression_230_Var
		 = (ConditionalExpression)AssignmentExpression_229_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_230_Var
		);
		//230
		final LogicalOrExpression LogicalOrExpression_231_Var
		 = (LogicalOrExpression)ConditionalExpression_230_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = LogicalOrExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final LogicalAndExpression LogicalAndExpression_232_Var
		 = (LogicalAndExpression)Expr_231_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = LogicalAndExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final InclusiveOrExpression InclusiveOrExpression_233_Var
		 = (InclusiveOrExpression)Expr_232_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = InclusiveOrExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final ExclusiveOrExpression ExclusiveOrExpression_234_Var
		 = (ExclusiveOrExpression)Expr_233_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = ExclusiveOrExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final AndExpression AndExpression_235_Var
		 = (AndExpression)Expr_234_list.get(0);
		Assert.assertNotNull(AndExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = AndExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final EqualityExpression EqualityExpression_236_Var
		 = (EqualityExpression)Expr_235_list.get(0);
		Assert.assertNotNull(EqualityExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = EqualityExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final RelationalExpression RelationalExpression_237_Var
		 = (RelationalExpression)Expr_236_list.get(0);
		Assert.assertNotNull(RelationalExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = RelationalExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final ShiftExpression ShiftExpression_238_Var
		 = (ShiftExpression)Expr_237_list.get(0);
		Assert.assertNotNull(ShiftExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = ShiftExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final AdditiveExpression AdditiveExpression_239_Var
		 = (AdditiveExpression)Expr_238_list.get(0);
		Assert.assertNotNull(AdditiveExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = AdditiveExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final MultiplicativeExpression MultiplicativeExpression_240_Var
		 = (MultiplicativeExpression)Expr_239_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = MultiplicativeExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final CastExpression CastExpression_241_Var
		 = (CastExpression)Expr_240_list.get(0);
		Assert.assertNotNull(CastExpression_241_Var
		);
		//241
		final UnaryExpression UnaryExpression_242_Var
		 = (UnaryExpression)CastExpression_241_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_242_Var
		);
		//242
		final PostfixExpression PostfixExpression_243_Var
		 = (PostfixExpression)UnaryExpression_242_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = PostfixExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final PrimaryExpression PrimaryExpression_244_Var
		 = (PrimaryExpression)Expr_243_list.get(0);
		Assert.assertNotNull(PrimaryExpression_244_Var
		);
		//244
		final Constant Constant_245_Var
		 = (Constant)PrimaryExpression_244_Var
		.getConst();
		Assert.assertNotNull(Constant_245_Var
		);
		Assert.assertEquals("6", Constant_245_Var
		.getDec());
		//245
		final AssignmentOperator AssignmentOperator_246_Var
		 = (AssignmentOperator)AssignmentExpression_224_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_246_Var
		);
		Assert.assertEquals("=", AssignmentOperator_246_Var
		.getOp());
		//246
		final AssignmentExpression AssignmentExpression_247_Var
		 = (AssignmentExpression)AssignmentExpression_224_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_247_Var
		);
		//247
		final ConditionalExpression ConditionalExpression_248_Var
		 = (ConditionalExpression)AssignmentExpression_247_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_248_Var
		);
		//248
		final LogicalOrExpression LogicalOrExpression_249_Var
		 = (LogicalOrExpression)ConditionalExpression_248_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = LogicalOrExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final LogicalAndExpression LogicalAndExpression_250_Var
		 = (LogicalAndExpression)Expr_249_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = LogicalAndExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final InclusiveOrExpression InclusiveOrExpression_251_Var
		 = (InclusiveOrExpression)Expr_250_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = InclusiveOrExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final ExclusiveOrExpression ExclusiveOrExpression_252_Var
		 = (ExclusiveOrExpression)Expr_251_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_252_Var
		);
		final EList<? extends EObject> Expr_252_list = ExclusiveOrExpression_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(1, Expr_252_list.size());
		//252
		final AndExpression AndExpression_253_Var
		 = (AndExpression)Expr_252_list.get(0);
		Assert.assertNotNull(AndExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = AndExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final EqualityExpression EqualityExpression_254_Var
		 = (EqualityExpression)Expr_253_list.get(0);
		Assert.assertNotNull(EqualityExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = EqualityExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final RelationalExpression RelationalExpression_255_Var
		 = (RelationalExpression)Expr_254_list.get(0);
		Assert.assertNotNull(RelationalExpression_255_Var
		);
		final EList<? extends EObject> Expr_255_list = RelationalExpression_255_Var
		.getExpr();
		Assert.assertNotNull(Expr_255_list);
		Assert.assertEquals(1, Expr_255_list.size());
		//255
		final ShiftExpression ShiftExpression_256_Var
		 = (ShiftExpression)Expr_255_list.get(0);
		Assert.assertNotNull(ShiftExpression_256_Var
		);
		final EList<? extends EObject> Expr_256_list = ShiftExpression_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(1, Expr_256_list.size());
		//256
		final AdditiveExpression AdditiveExpression_257_Var
		 = (AdditiveExpression)Expr_256_list.get(0);
		Assert.assertNotNull(AdditiveExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = AdditiveExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final MultiplicativeExpression MultiplicativeExpression_258_Var
		 = (MultiplicativeExpression)Expr_257_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_258_Var
		);
		final EList<? extends EObject> Expr_258_list = MultiplicativeExpression_258_Var
		.getExpr();
		Assert.assertNotNull(Expr_258_list);
		Assert.assertEquals(1, Expr_258_list.size());
		//258
		final CastExpression CastExpression_259_Var
		 = (CastExpression)Expr_258_list.get(0);
		Assert.assertNotNull(CastExpression_259_Var
		);
		//259
		final UnaryExpression UnaryExpression_260_Var
		 = (UnaryExpression)CastExpression_259_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_260_Var
		);
		//260
		final PostfixExpression PostfixExpression_261_Var
		 = (PostfixExpression)UnaryExpression_260_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = PostfixExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final PrimaryExpression PrimaryExpression_262_Var
		 = (PrimaryExpression)Expr_261_list.get(0);
		Assert.assertNotNull(PrimaryExpression_262_Var
		);
		//262
		final Constant Constant_263_Var
		 = (Constant)PrimaryExpression_262_Var
		.getConst();
		Assert.assertNotNull(Constant_263_Var
		);
		Assert.assertEquals("'w'", Constant_263_Var
		.getCh());
		Assert.assertEquals(";", ExpressionStatement_222_Var
		.getSemi());
		//263
		final Statement Statement_264_Var
		 = (Statement)Statement_61_list.get(4);
		Assert.assertNotNull(Statement_264_Var
		);
		//264
		final ExpressionStatement ExpressionStatement_265_Var
		 = (ExpressionStatement)Statement_264_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_265_Var
		);
		//265
		final Expression Expression_266_Var
		 = (Expression)ExpressionStatement_265_Var
		.getExpression();
		Assert.assertNotNull(Expression_266_Var
		);
		final EList<? extends EObject> ExprExpr_266_list = Expression_266_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_266_list);
		Assert.assertEquals(1, ExprExpr_266_list.size());
		//266
		final AssignmentExpression AssignmentExpression_267_Var
		 = (AssignmentExpression)ExprExpr_266_list.get(0);
		Assert.assertNotNull(AssignmentExpression_267_Var
		);
		//267
		final ConditionalExpression ConditionalExpression_268_Var
		 = (ConditionalExpression)AssignmentExpression_267_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_268_Var
		);
		//268
		final LogicalOrExpression LogicalOrExpression_269_Var
		 = (LogicalOrExpression)ConditionalExpression_268_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_269_Var
		);
		final EList<? extends EObject> Expr_269_list = LogicalOrExpression_269_Var
		.getExpr();
		Assert.assertNotNull(Expr_269_list);
		Assert.assertEquals(1, Expr_269_list.size());
		//269
		final LogicalAndExpression LogicalAndExpression_270_Var
		 = (LogicalAndExpression)Expr_269_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_270_Var
		);
		final EList<? extends EObject> Expr_270_list = LogicalAndExpression_270_Var
		.getExpr();
		Assert.assertNotNull(Expr_270_list);
		Assert.assertEquals(1, Expr_270_list.size());
		//270
		final InclusiveOrExpression InclusiveOrExpression_271_Var
		 = (InclusiveOrExpression)Expr_270_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_271_Var
		);
		final EList<? extends EObject> Expr_271_list = InclusiveOrExpression_271_Var
		.getExpr();
		Assert.assertNotNull(Expr_271_list);
		Assert.assertEquals(1, Expr_271_list.size());
		//271
		final ExclusiveOrExpression ExclusiveOrExpression_272_Var
		 = (ExclusiveOrExpression)Expr_271_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_272_Var
		);
		final EList<? extends EObject> Expr_272_list = ExclusiveOrExpression_272_Var
		.getExpr();
		Assert.assertNotNull(Expr_272_list);
		Assert.assertEquals(1, Expr_272_list.size());
		//272
		final AndExpression AndExpression_273_Var
		 = (AndExpression)Expr_272_list.get(0);
		Assert.assertNotNull(AndExpression_273_Var
		);
		final EList<? extends EObject> Expr_273_list = AndExpression_273_Var
		.getExpr();
		Assert.assertNotNull(Expr_273_list);
		Assert.assertEquals(1, Expr_273_list.size());
		//273
		final EqualityExpression EqualityExpression_274_Var
		 = (EqualityExpression)Expr_273_list.get(0);
		Assert.assertNotNull(EqualityExpression_274_Var
		);
		final EList<? extends EObject> Expr_274_list = EqualityExpression_274_Var
		.getExpr();
		Assert.assertNotNull(Expr_274_list);
		Assert.assertEquals(1, Expr_274_list.size());
		//274
		final RelationalExpression RelationalExpression_275_Var
		 = (RelationalExpression)Expr_274_list.get(0);
		Assert.assertNotNull(RelationalExpression_275_Var
		);
		final EList<? extends EObject> Expr_275_list = RelationalExpression_275_Var
		.getExpr();
		Assert.assertNotNull(Expr_275_list);
		Assert.assertEquals(1, Expr_275_list.size());
		//275
		final ShiftExpression ShiftExpression_276_Var
		 = (ShiftExpression)Expr_275_list.get(0);
		Assert.assertNotNull(ShiftExpression_276_Var
		);
		final EList<? extends EObject> Expr_276_list = ShiftExpression_276_Var
		.getExpr();
		Assert.assertNotNull(Expr_276_list);
		Assert.assertEquals(1, Expr_276_list.size());
		//276
		final AdditiveExpression AdditiveExpression_277_Var
		 = (AdditiveExpression)Expr_276_list.get(0);
		Assert.assertNotNull(AdditiveExpression_277_Var
		);
		final EList<? extends EObject> Expr_277_list = AdditiveExpression_277_Var
		.getExpr();
		Assert.assertNotNull(Expr_277_list);
		Assert.assertEquals(1, Expr_277_list.size());
		//277
		final MultiplicativeExpression MultiplicativeExpression_278_Var
		 = (MultiplicativeExpression)Expr_277_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_278_Var
		);
		final EList<? extends EObject> Expr_278_list = MultiplicativeExpression_278_Var
		.getExpr();
		Assert.assertNotNull(Expr_278_list);
		Assert.assertEquals(1, Expr_278_list.size());
		//278
		final CastExpression CastExpression_279_Var
		 = (CastExpression)Expr_278_list.get(0);
		Assert.assertNotNull(CastExpression_279_Var
		);
		//279
		final UnaryExpression UnaryExpression_280_Var
		 = (UnaryExpression)CastExpression_279_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_280_Var
		);
		//280
		final PostfixExpression PostfixExpression_281_Var
		 = (PostfixExpression)UnaryExpression_280_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_281_Var
		);
		final EList<? extends EObject> Expr_281_list = PostfixExpression_281_Var
		.getExpr();
		Assert.assertNotNull(Expr_281_list);
		Assert.assertEquals(1, Expr_281_list.size());
		//281
		final PrimaryExpression PrimaryExpression_282_Var
		 = (PrimaryExpression)Expr_281_list.get(0);
		Assert.assertNotNull(PrimaryExpression_282_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_282_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_282_list = PostfixExpression_281_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_282_list);
		Assert.assertEquals(1, ArgumentExpressionList_282_list.size());
		//282
		final ArgumentExpressionList ArgumentExpressionList_283_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_282_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_283_Var
		);
		final EList<? extends EObject> Expr_283_list = ArgumentExpressionList_283_Var
		.getExpr();
		Assert.assertNotNull(Expr_283_list);
		Assert.assertEquals(2, Expr_283_list.size());
		//283
		final AssignmentExpression AssignmentExpression_284_Var
		 = (AssignmentExpression)Expr_283_list.get(0);
		Assert.assertNotNull(AssignmentExpression_284_Var
		);
		//284
		final ConditionalExpression ConditionalExpression_285_Var
		 = (ConditionalExpression)AssignmentExpression_284_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_285_Var
		);
		//285
		final LogicalOrExpression LogicalOrExpression_286_Var
		 = (LogicalOrExpression)ConditionalExpression_285_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_286_Var
		);
		final EList<? extends EObject> Expr_286_list = LogicalOrExpression_286_Var
		.getExpr();
		Assert.assertNotNull(Expr_286_list);
		Assert.assertEquals(1, Expr_286_list.size());
		//286
		final LogicalAndExpression LogicalAndExpression_287_Var
		 = (LogicalAndExpression)Expr_286_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_287_Var
		);
		final EList<? extends EObject> Expr_287_list = LogicalAndExpression_287_Var
		.getExpr();
		Assert.assertNotNull(Expr_287_list);
		Assert.assertEquals(1, Expr_287_list.size());
		//287
		final InclusiveOrExpression InclusiveOrExpression_288_Var
		 = (InclusiveOrExpression)Expr_287_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_288_Var
		);
		final EList<? extends EObject> Expr_288_list = InclusiveOrExpression_288_Var
		.getExpr();
		Assert.assertNotNull(Expr_288_list);
		Assert.assertEquals(1, Expr_288_list.size());
		//288
		final ExclusiveOrExpression ExclusiveOrExpression_289_Var
		 = (ExclusiveOrExpression)Expr_288_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_289_Var
		);
		final EList<? extends EObject> Expr_289_list = ExclusiveOrExpression_289_Var
		.getExpr();
		Assert.assertNotNull(Expr_289_list);
		Assert.assertEquals(1, Expr_289_list.size());
		//289
		final AndExpression AndExpression_290_Var
		 = (AndExpression)Expr_289_list.get(0);
		Assert.assertNotNull(AndExpression_290_Var
		);
		final EList<? extends EObject> Expr_290_list = AndExpression_290_Var
		.getExpr();
		Assert.assertNotNull(Expr_290_list);
		Assert.assertEquals(1, Expr_290_list.size());
		//290
		final EqualityExpression EqualityExpression_291_Var
		 = (EqualityExpression)Expr_290_list.get(0);
		Assert.assertNotNull(EqualityExpression_291_Var
		);
		final EList<? extends EObject> Expr_291_list = EqualityExpression_291_Var
		.getExpr();
		Assert.assertNotNull(Expr_291_list);
		Assert.assertEquals(1, Expr_291_list.size());
		//291
		final RelationalExpression RelationalExpression_292_Var
		 = (RelationalExpression)Expr_291_list.get(0);
		Assert.assertNotNull(RelationalExpression_292_Var
		);
		final EList<? extends EObject> Expr_292_list = RelationalExpression_292_Var
		.getExpr();
		Assert.assertNotNull(Expr_292_list);
		Assert.assertEquals(1, Expr_292_list.size());
		//292
		final ShiftExpression ShiftExpression_293_Var
		 = (ShiftExpression)Expr_292_list.get(0);
		Assert.assertNotNull(ShiftExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = ShiftExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final AdditiveExpression AdditiveExpression_294_Var
		 = (AdditiveExpression)Expr_293_list.get(0);
		Assert.assertNotNull(AdditiveExpression_294_Var
		);
		final EList<? extends EObject> Expr_294_list = AdditiveExpression_294_Var
		.getExpr();
		Assert.assertNotNull(Expr_294_list);
		Assert.assertEquals(1, Expr_294_list.size());
		//294
		final MultiplicativeExpression MultiplicativeExpression_295_Var
		 = (MultiplicativeExpression)Expr_294_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_295_Var
		);
		final EList<? extends EObject> Expr_295_list = MultiplicativeExpression_295_Var
		.getExpr();
		Assert.assertNotNull(Expr_295_list);
		Assert.assertEquals(1, Expr_295_list.size());
		//295
		final CastExpression CastExpression_296_Var
		 = (CastExpression)Expr_295_list.get(0);
		Assert.assertNotNull(CastExpression_296_Var
		);
		//296
		final UnaryExpression UnaryExpression_297_Var
		 = (UnaryExpression)CastExpression_296_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_297_Var
		);
		//297
		final PostfixExpression PostfixExpression_298_Var
		 = (PostfixExpression)UnaryExpression_297_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_298_Var
		);
		final EList<? extends EObject> Expr_298_list = PostfixExpression_298_Var
		.getExpr();
		Assert.assertNotNull(Expr_298_list);
		Assert.assertEquals(1, Expr_298_list.size());
		//298
		final PrimaryExpression PrimaryExpression_299_Var
		 = (PrimaryExpression)Expr_298_list.get(0);
		Assert.assertNotNull(PrimaryExpression_299_Var
		);
		//299
		final Constant Constant_300_Var
		 = (Constant)PrimaryExpression_299_Var
		.getConst();
		Assert.assertNotNull(Constant_300_Var
		);
		Assert.assertEquals("\"%s\\n\"", Constant_300_Var
		.getStr());
		//300
		final AssignmentExpression AssignmentExpression_301_Var
		 = (AssignmentExpression)Expr_283_list.get(1);
		Assert.assertNotNull(AssignmentExpression_301_Var
		);
		//301
		final ConditionalExpression ConditionalExpression_302_Var
		 = (ConditionalExpression)AssignmentExpression_301_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_302_Var
		);
		//302
		final LogicalOrExpression LogicalOrExpression_303_Var
		 = (LogicalOrExpression)ConditionalExpression_302_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_303_Var
		);
		final EList<? extends EObject> Expr_303_list = LogicalOrExpression_303_Var
		.getExpr();
		Assert.assertNotNull(Expr_303_list);
		Assert.assertEquals(1, Expr_303_list.size());
		//303
		final LogicalAndExpression LogicalAndExpression_304_Var
		 = (LogicalAndExpression)Expr_303_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_304_Var
		);
		final EList<? extends EObject> Expr_304_list = LogicalAndExpression_304_Var
		.getExpr();
		Assert.assertNotNull(Expr_304_list);
		Assert.assertEquals(1, Expr_304_list.size());
		//304
		final InclusiveOrExpression InclusiveOrExpression_305_Var
		 = (InclusiveOrExpression)Expr_304_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_305_Var
		);
		final EList<? extends EObject> Expr_305_list = InclusiveOrExpression_305_Var
		.getExpr();
		Assert.assertNotNull(Expr_305_list);
		Assert.assertEquals(1, Expr_305_list.size());
		//305
		final ExclusiveOrExpression ExclusiveOrExpression_306_Var
		 = (ExclusiveOrExpression)Expr_305_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_306_Var
		);
		final EList<? extends EObject> Expr_306_list = ExclusiveOrExpression_306_Var
		.getExpr();
		Assert.assertNotNull(Expr_306_list);
		Assert.assertEquals(1, Expr_306_list.size());
		//306
		final AndExpression AndExpression_307_Var
		 = (AndExpression)Expr_306_list.get(0);
		Assert.assertNotNull(AndExpression_307_Var
		);
		final EList<? extends EObject> Expr_307_list = AndExpression_307_Var
		.getExpr();
		Assert.assertNotNull(Expr_307_list);
		Assert.assertEquals(1, Expr_307_list.size());
		//307
		final EqualityExpression EqualityExpression_308_Var
		 = (EqualityExpression)Expr_307_list.get(0);
		Assert.assertNotNull(EqualityExpression_308_Var
		);
		final EList<? extends EObject> Expr_308_list = EqualityExpression_308_Var
		.getExpr();
		Assert.assertNotNull(Expr_308_list);
		Assert.assertEquals(1, Expr_308_list.size());
		//308
		final RelationalExpression RelationalExpression_309_Var
		 = (RelationalExpression)Expr_308_list.get(0);
		Assert.assertNotNull(RelationalExpression_309_Var
		);
		final EList<? extends EObject> Expr_309_list = RelationalExpression_309_Var
		.getExpr();
		Assert.assertNotNull(Expr_309_list);
		Assert.assertEquals(1, Expr_309_list.size());
		//309
		final ShiftExpression ShiftExpression_310_Var
		 = (ShiftExpression)Expr_309_list.get(0);
		Assert.assertNotNull(ShiftExpression_310_Var
		);
		final EList<? extends EObject> Expr_310_list = ShiftExpression_310_Var
		.getExpr();
		Assert.assertNotNull(Expr_310_list);
		Assert.assertEquals(1, Expr_310_list.size());
		//310
		final AdditiveExpression AdditiveExpression_311_Var
		 = (AdditiveExpression)Expr_310_list.get(0);
		Assert.assertNotNull(AdditiveExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = AdditiveExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final MultiplicativeExpression MultiplicativeExpression_312_Var
		 = (MultiplicativeExpression)Expr_311_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = MultiplicativeExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final CastExpression CastExpression_313_Var
		 = (CastExpression)Expr_312_list.get(0);
		Assert.assertNotNull(CastExpression_313_Var
		);
		//313
		final UnaryExpression UnaryExpression_314_Var
		 = (UnaryExpression)CastExpression_313_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_314_Var
		);
		//314
		final PostfixExpression PostfixExpression_315_Var
		 = (PostfixExpression)UnaryExpression_314_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = PostfixExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final PrimaryExpression PrimaryExpression_316_Var
		 = (PrimaryExpression)Expr_315_list.get(0);
		Assert.assertNotNull(PrimaryExpression_316_Var
		);
		Assert.assertEquals("out", PrimaryExpression_316_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_265_Var
		.getSemi());
		//316
		final Statement Statement_317_Var
		 = (Statement)Statement_61_list.get(5);
		Assert.assertNotNull(Statement_317_Var
		);
		//317
		final JumpStatement JumpStatement_318_Var
		 = (JumpStatement)Statement_317_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_318_Var
		);
		//318
		final Expression Expression_319_Var
		 = (Expression)JumpStatement_318_Var
		.getExpr();
		Assert.assertNotNull(Expression_319_Var
		);
		final EList<? extends EObject> ExprExpr_319_list = Expression_319_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_319_list);
		Assert.assertEquals(1, ExprExpr_319_list.size());
		//319
		final AssignmentExpression AssignmentExpression_320_Var
		 = (AssignmentExpression)ExprExpr_319_list.get(0);
		Assert.assertNotNull(AssignmentExpression_320_Var
		);
		//320
		final ConditionalExpression ConditionalExpression_321_Var
		 = (ConditionalExpression)AssignmentExpression_320_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_321_Var
		);
		//321
		final LogicalOrExpression LogicalOrExpression_322_Var
		 = (LogicalOrExpression)ConditionalExpression_321_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_322_Var
		);
		final EList<? extends EObject> Expr_322_list = LogicalOrExpression_322_Var
		.getExpr();
		Assert.assertNotNull(Expr_322_list);
		Assert.assertEquals(1, Expr_322_list.size());
		//322
		final LogicalAndExpression LogicalAndExpression_323_Var
		 = (LogicalAndExpression)Expr_322_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_323_Var
		);
		final EList<? extends EObject> Expr_323_list = LogicalAndExpression_323_Var
		.getExpr();
		Assert.assertNotNull(Expr_323_list);
		Assert.assertEquals(1, Expr_323_list.size());
		//323
		final InclusiveOrExpression InclusiveOrExpression_324_Var
		 = (InclusiveOrExpression)Expr_323_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_324_Var
		);
		final EList<? extends EObject> Expr_324_list = InclusiveOrExpression_324_Var
		.getExpr();
		Assert.assertNotNull(Expr_324_list);
		Assert.assertEquals(1, Expr_324_list.size());
		//324
		final ExclusiveOrExpression ExclusiveOrExpression_325_Var
		 = (ExclusiveOrExpression)Expr_324_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_325_Var
		);
		final EList<? extends EObject> Expr_325_list = ExclusiveOrExpression_325_Var
		.getExpr();
		Assert.assertNotNull(Expr_325_list);
		Assert.assertEquals(1, Expr_325_list.size());
		//325
		final AndExpression AndExpression_326_Var
		 = (AndExpression)Expr_325_list.get(0);
		Assert.assertNotNull(AndExpression_326_Var
		);
		final EList<? extends EObject> Expr_326_list = AndExpression_326_Var
		.getExpr();
		Assert.assertNotNull(Expr_326_list);
		Assert.assertEquals(1, Expr_326_list.size());
		//326
		final EqualityExpression EqualityExpression_327_Var
		 = (EqualityExpression)Expr_326_list.get(0);
		Assert.assertNotNull(EqualityExpression_327_Var
		);
		final EList<? extends EObject> Expr_327_list = EqualityExpression_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final RelationalExpression RelationalExpression_328_Var
		 = (RelationalExpression)Expr_327_list.get(0);
		Assert.assertNotNull(RelationalExpression_328_Var
		);
		final EList<? extends EObject> Expr_328_list = RelationalExpression_328_Var
		.getExpr();
		Assert.assertNotNull(Expr_328_list);
		Assert.assertEquals(1, Expr_328_list.size());
		//328
		final ShiftExpression ShiftExpression_329_Var
		 = (ShiftExpression)Expr_328_list.get(0);
		Assert.assertNotNull(ShiftExpression_329_Var
		);
		final EList<? extends EObject> Expr_329_list = ShiftExpression_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final AdditiveExpression AdditiveExpression_330_Var
		 = (AdditiveExpression)Expr_329_list.get(0);
		Assert.assertNotNull(AdditiveExpression_330_Var
		);
		final EList<? extends EObject> Expr_330_list = AdditiveExpression_330_Var
		.getExpr();
		Assert.assertNotNull(Expr_330_list);
		Assert.assertEquals(1, Expr_330_list.size());
		//330
		final MultiplicativeExpression MultiplicativeExpression_331_Var
		 = (MultiplicativeExpression)Expr_330_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = MultiplicativeExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final CastExpression CastExpression_332_Var
		 = (CastExpression)Expr_331_list.get(0);
		Assert.assertNotNull(CastExpression_332_Var
		);
		//332
		final UnaryExpression UnaryExpression_333_Var
		 = (UnaryExpression)CastExpression_332_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_333_Var
		);
		//333
		final PostfixExpression PostfixExpression_334_Var
		 = (PostfixExpression)UnaryExpression_333_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = PostfixExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final PrimaryExpression PrimaryExpression_335_Var
		 = (PrimaryExpression)Expr_334_list.get(0);
		Assert.assertNotNull(PrimaryExpression_335_Var
		);
		//335
		final Constant Constant_336_Var
		 = (Constant)PrimaryExpression_335_Var
		.getConst();
		Assert.assertNotNull(Constant_336_Var
		);
		Assert.assertEquals("0", Constant_336_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_318_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_318_Var
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
	
}


