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
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
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
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.AsmStatement;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
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
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_BLOCK_COMMENT",
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
				"RULE_BLOCK_COMMENT",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_ASM2",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_BLOCK_COMMENT",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_BLOCK_COMMENT",
				"RULE_NEWLINE",
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
				"RULE_WHITESPACE",
				"RULE_BLOCK_COMMENT",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_BLOCK_COMMENT",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_BLOCK_COMMENT",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_BLOCK_COMMENT",
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
		.getId());
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
		.getId());
		//23
		final Initializer Initializer_24_Var
		 = (Initializer)InitDeclarator_21_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_24_Var
		);
		//24
		final AssignmentExpression AssignmentExpression_25_Var
		 = (AssignmentExpression)Initializer_24_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_25_Var
		);
		//25
		final ConditionalExpression ConditionalExpression_26_Var
		 = (ConditionalExpression)AssignmentExpression_25_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_26_Var
		);
		//26
		final LogicalOrExpression LogicalOrExpression_27_Var
		 = (LogicalOrExpression)ConditionalExpression_26_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = LogicalOrExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final LogicalAndExpression LogicalAndExpression_28_Var
		 = (LogicalAndExpression)Expr_27_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = LogicalAndExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final InclusiveOrExpression InclusiveOrExpression_29_Var
		 = (InclusiveOrExpression)Expr_28_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = InclusiveOrExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final ExclusiveOrExpression ExclusiveOrExpression_30_Var
		 = (ExclusiveOrExpression)Expr_29_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = ExclusiveOrExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final AndExpression AndExpression_31_Var
		 = (AndExpression)Expr_30_list.get(0);
		Assert.assertNotNull(AndExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = AndExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final EqualityExpression EqualityExpression_32_Var
		 = (EqualityExpression)Expr_31_list.get(0);
		Assert.assertNotNull(EqualityExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = EqualityExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final RelationalExpression RelationalExpression_33_Var
		 = (RelationalExpression)Expr_32_list.get(0);
		Assert.assertNotNull(RelationalExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = RelationalExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final ShiftExpression ShiftExpression_34_Var
		 = (ShiftExpression)Expr_33_list.get(0);
		Assert.assertNotNull(ShiftExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = ShiftExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final AdditiveExpression AdditiveExpression_35_Var
		 = (AdditiveExpression)Expr_34_list.get(0);
		Assert.assertNotNull(AdditiveExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = AdditiveExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final MultiplicativeExpression MultiplicativeExpression_36_Var
		 = (MultiplicativeExpression)Expr_35_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = MultiplicativeExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final CastExpression CastExpression_37_Var
		 = (CastExpression)Expr_36_list.get(0);
		Assert.assertNotNull(CastExpression_37_Var
		);
		//37
		final UnaryExpression UnaryExpression_38_Var
		 = (UnaryExpression)CastExpression_37_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_38_Var
		);
		//38
		final PostfixExpression PostfixExpression_39_Var
		 = (PostfixExpression)UnaryExpression_38_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = PostfixExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final PrimaryExpression PrimaryExpression_40_Var
		 = (PrimaryExpression)Expr_39_list.get(0);
		Assert.assertNotNull(PrimaryExpression_40_Var
		);
		//40
		final Constant2 Constant2_41_Var
		 = (Constant2)PrimaryExpression_40_Var
		.getConst();
		Assert.assertNotNull(Constant2_41_Var
		);
		Assert.assertEquals("5", Constant2_41_Var
		.getDec());
		Assert.assertEquals(";", Declaration_17_Var
		.getSemi());
		//41
		final Declaration Declaration_42_Var
		 = (Declaration)Declaration_16_list.get(1);
		Assert.assertNotNull(Declaration_42_Var
		);
		//42
		final DeclarationSpecifiers DeclarationSpecifiers_43_Var
		 = (DeclarationSpecifiers)Declaration_42_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_43_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_43_list = DeclarationSpecifiers_43_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_43_list);
		Assert.assertEquals(1, DeclarationSpecifier_43_list.size());
		//43
		final TypeSpecifier TypeSpecifier_44_Var
		 = (TypeSpecifier)DeclarationSpecifier_43_list.get(0);
		Assert.assertNotNull(TypeSpecifier_44_Var
		);
		Assert.assertEquals("int", TypeSpecifier_44_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_44_list = Declaration_42_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_44_list);
		Assert.assertEquals(1, InitDeclaratorList_44_list.size());
		//44
		final InitDeclaratorList InitDeclaratorList_45_Var
		 = (InitDeclaratorList)InitDeclaratorList_44_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_45_Var
		);
		final EList<? extends EObject> InitDeclarator_45_list = InitDeclaratorList_45_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_45_list);
		Assert.assertEquals(1, InitDeclarator_45_list.size());
		//45
		final InitDeclarator InitDeclarator_46_Var
		 = (InitDeclarator)InitDeclarator_45_list.get(0);
		Assert.assertNotNull(InitDeclarator_46_Var
		);
		//46
		final Declarator Declarator_47_Var
		 = (Declarator)InitDeclarator_46_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_47_Var
		);
		//47
		final DirectDeclarator DirectDeclarator_48_Var
		 = (DirectDeclarator)Declarator_47_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_48_Var
		);
		Assert.assertEquals("bar", DirectDeclarator_48_Var
		.getId());
		//48
		final Initializer Initializer_49_Var
		 = (Initializer)InitDeclarator_46_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_49_Var
		);
		//49
		final AssignmentExpression AssignmentExpression_50_Var
		 = (AssignmentExpression)Initializer_49_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_50_Var
		);
		//50
		final ConditionalExpression ConditionalExpression_51_Var
		 = (ConditionalExpression)AssignmentExpression_50_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_51_Var
		);
		//51
		final LogicalOrExpression LogicalOrExpression_52_Var
		 = (LogicalOrExpression)ConditionalExpression_51_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = LogicalOrExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final LogicalAndExpression LogicalAndExpression_53_Var
		 = (LogicalAndExpression)Expr_52_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = LogicalAndExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final InclusiveOrExpression InclusiveOrExpression_54_Var
		 = (InclusiveOrExpression)Expr_53_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = InclusiveOrExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final ExclusiveOrExpression ExclusiveOrExpression_55_Var
		 = (ExclusiveOrExpression)Expr_54_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = ExclusiveOrExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final AndExpression AndExpression_56_Var
		 = (AndExpression)Expr_55_list.get(0);
		Assert.assertNotNull(AndExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = AndExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final EqualityExpression EqualityExpression_57_Var
		 = (EqualityExpression)Expr_56_list.get(0);
		Assert.assertNotNull(EqualityExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = EqualityExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final RelationalExpression RelationalExpression_58_Var
		 = (RelationalExpression)Expr_57_list.get(0);
		Assert.assertNotNull(RelationalExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = RelationalExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final ShiftExpression ShiftExpression_59_Var
		 = (ShiftExpression)Expr_58_list.get(0);
		Assert.assertNotNull(ShiftExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = ShiftExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final AdditiveExpression AdditiveExpression_60_Var
		 = (AdditiveExpression)Expr_59_list.get(0);
		Assert.assertNotNull(AdditiveExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = AdditiveExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final MultiplicativeExpression MultiplicativeExpression_61_Var
		 = (MultiplicativeExpression)Expr_60_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = MultiplicativeExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final CastExpression CastExpression_62_Var
		 = (CastExpression)Expr_61_list.get(0);
		Assert.assertNotNull(CastExpression_62_Var
		);
		//62
		final UnaryExpression UnaryExpression_63_Var
		 = (UnaryExpression)CastExpression_62_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_63_Var
		);
		//63
		final PostfixExpression PostfixExpression_64_Var
		 = (PostfixExpression)UnaryExpression_63_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = PostfixExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final PrimaryExpression PrimaryExpression_65_Var
		 = (PrimaryExpression)Expr_64_list.get(0);
		Assert.assertNotNull(PrimaryExpression_65_Var
		);
		//65
		final Constant2 Constant2_66_Var
		 = (Constant2)PrimaryExpression_65_Var
		.getConst();
		Assert.assertNotNull(Constant2_66_Var
		);
		Assert.assertEquals("4", Constant2_66_Var
		.getDec());
		Assert.assertEquals(";", Declaration_42_Var
		.getSemi());
		final EList<? extends EObject> Statement_66_list = BlockList_16_Var
		.getStatement();
		Assert.assertNotNull(Statement_66_list);
		Assert.assertEquals(3, Statement_66_list.size());
		//66
		final Statement Statement_67_Var
		 = (Statement)Statement_66_list.get(0);
		Assert.assertNotNull(Statement_67_Var
		);
		//67
		final AsmStatement AsmStatement_68_Var
		 = (AsmStatement)Statement_67_Var
		.getStmt();
		Assert.assertNotNull(AsmStatement_68_Var
		);
		//68
		final AsmLineWithoutColon AsmLineWithoutColon_69_Var
		 = (AsmLineWithoutColon)AsmStatement_68_Var
		.getAsmLine1();
		Assert.assertNotNull(AsmLineWithoutColon_69_Var
		);
		//69
		final LogicalOrExpression LogicalOrExpression_70_Var
		 = (LogicalOrExpression)AsmLineWithoutColon_69_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = LogicalOrExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final LogicalAndExpression LogicalAndExpression_71_Var
		 = (LogicalAndExpression)Expr_70_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = LogicalAndExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final InclusiveOrExpression InclusiveOrExpression_72_Var
		 = (InclusiveOrExpression)Expr_71_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = InclusiveOrExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final ExclusiveOrExpression ExclusiveOrExpression_73_Var
		 = (ExclusiveOrExpression)Expr_72_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = ExclusiveOrExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final AndExpression AndExpression_74_Var
		 = (AndExpression)Expr_73_list.get(0);
		Assert.assertNotNull(AndExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = AndExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final EqualityExpression EqualityExpression_75_Var
		 = (EqualityExpression)Expr_74_list.get(0);
		Assert.assertNotNull(EqualityExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = EqualityExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final RelationalExpression RelationalExpression_76_Var
		 = (RelationalExpression)Expr_75_list.get(0);
		Assert.assertNotNull(RelationalExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = RelationalExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final ShiftExpression ShiftExpression_77_Var
		 = (ShiftExpression)Expr_76_list.get(0);
		Assert.assertNotNull(ShiftExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = ShiftExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final AdditiveExpression AdditiveExpression_78_Var
		 = (AdditiveExpression)Expr_77_list.get(0);
		Assert.assertNotNull(AdditiveExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = AdditiveExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final MultiplicativeExpression MultiplicativeExpression_79_Var
		 = (MultiplicativeExpression)Expr_78_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = MultiplicativeExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final CastExpression CastExpression_80_Var
		 = (CastExpression)Expr_79_list.get(0);
		Assert.assertNotNull(CastExpression_80_Var
		);
		//80
		final UnaryExpression UnaryExpression_81_Var
		 = (UnaryExpression)CastExpression_80_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_81_Var
		);
		//81
		final PostfixExpression PostfixExpression_82_Var
		 = (PostfixExpression)UnaryExpression_81_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = PostfixExpression_82_Var
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
		Assert.assertEquals("\"add %1, %0\\n\\t\"", Constant2_84_Var
		.getStr());
		final EList<? extends EObject> AsmLines_84_list = AsmLineWithoutColon_69_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_84_list);
		Assert.assertEquals(1, AsmLines_84_list.size());
		//84
		final AsmLine AsmLine_85_Var
		 = (AsmLine)AsmLines_84_list.get(0);
		Assert.assertNotNull(AsmLine_85_Var
		);
		Assert.assertFalse(AsmLine_85_Var
		.isComma());
		//85
		final LogicalOrExpression LogicalOrExpression_86_Var
		 = (LogicalOrExpression)AsmLine_85_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = LogicalOrExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final LogicalAndExpression LogicalAndExpression_87_Var
		 = (LogicalAndExpression)Expr_86_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = LogicalAndExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final InclusiveOrExpression InclusiveOrExpression_88_Var
		 = (InclusiveOrExpression)Expr_87_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = InclusiveOrExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final ExclusiveOrExpression ExclusiveOrExpression_89_Var
		 = (ExclusiveOrExpression)Expr_88_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = ExclusiveOrExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final AndExpression AndExpression_90_Var
		 = (AndExpression)Expr_89_list.get(0);
		Assert.assertNotNull(AndExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = AndExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final EqualityExpression EqualityExpression_91_Var
		 = (EqualityExpression)Expr_90_list.get(0);
		Assert.assertNotNull(EqualityExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = EqualityExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final RelationalExpression RelationalExpression_92_Var
		 = (RelationalExpression)Expr_91_list.get(0);
		Assert.assertNotNull(RelationalExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = RelationalExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final ShiftExpression ShiftExpression_93_Var
		 = (ShiftExpression)Expr_92_list.get(0);
		Assert.assertNotNull(ShiftExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = ShiftExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final AdditiveExpression AdditiveExpression_94_Var
		 = (AdditiveExpression)Expr_93_list.get(0);
		Assert.assertNotNull(AdditiveExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = AdditiveExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final MultiplicativeExpression MultiplicativeExpression_95_Var
		 = (MultiplicativeExpression)Expr_94_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = MultiplicativeExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final CastExpression CastExpression_96_Var
		 = (CastExpression)Expr_95_list.get(0);
		Assert.assertNotNull(CastExpression_96_Var
		);
		//96
		final UnaryExpression UnaryExpression_97_Var
		 = (UnaryExpression)CastExpression_96_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_97_Var
		);
		//97
		final PostfixExpression PostfixExpression_98_Var
		 = (PostfixExpression)UnaryExpression_97_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = PostfixExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final PrimaryExpression PrimaryExpression_99_Var
		 = (PrimaryExpression)Expr_98_list.get(0);
		Assert.assertNotNull(PrimaryExpression_99_Var
		);
		//99
		final Constant2 Constant2_100_Var
		 = (Constant2)PrimaryExpression_99_Var
		.getConst();
		Assert.assertNotNull(Constant2_100_Var
		);
		Assert.assertEquals("\"inc %0\"", Constant2_100_Var
		.getStr());
		final EList<? extends EObject> AsmLines_100_list = AsmStatement_68_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_100_list);
		Assert.assertEquals(4, AsmLines_100_list.size());
		//100
		final AsmLineWithColon AsmLineWithColon_101_Var
		 = (AsmLineWithColon)AsmLines_100_list.get(0);
		Assert.assertNotNull(AsmLineWithColon_101_Var
		);
		//101
		final AsmLineWithoutColon AsmLineWithoutColon_102_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_101_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_102_Var
		);
		//102
		final LogicalOrExpression LogicalOrExpression_103_Var
		 = (LogicalOrExpression)AsmLineWithoutColon_102_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = LogicalOrExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final LogicalAndExpression LogicalAndExpression_104_Var
		 = (LogicalAndExpression)Expr_103_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = LogicalAndExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final InclusiveOrExpression InclusiveOrExpression_105_Var
		 = (InclusiveOrExpression)Expr_104_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = InclusiveOrExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final ExclusiveOrExpression ExclusiveOrExpression_106_Var
		 = (ExclusiveOrExpression)Expr_105_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = ExclusiveOrExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final AndExpression AndExpression_107_Var
		 = (AndExpression)Expr_106_list.get(0);
		Assert.assertNotNull(AndExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = AndExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final EqualityExpression EqualityExpression_108_Var
		 = (EqualityExpression)Expr_107_list.get(0);
		Assert.assertNotNull(EqualityExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = EqualityExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final RelationalExpression RelationalExpression_109_Var
		 = (RelationalExpression)Expr_108_list.get(0);
		Assert.assertNotNull(RelationalExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = RelationalExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final ShiftExpression ShiftExpression_110_Var
		 = (ShiftExpression)Expr_109_list.get(0);
		Assert.assertNotNull(ShiftExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = ShiftExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final AdditiveExpression AdditiveExpression_111_Var
		 = (AdditiveExpression)Expr_110_list.get(0);
		Assert.assertNotNull(AdditiveExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = AdditiveExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final MultiplicativeExpression MultiplicativeExpression_112_Var
		 = (MultiplicativeExpression)Expr_111_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = MultiplicativeExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final CastExpression CastExpression_113_Var
		 = (CastExpression)Expr_112_list.get(0);
		Assert.assertNotNull(CastExpression_113_Var
		);
		//113
		final UnaryExpression UnaryExpression_114_Var
		 = (UnaryExpression)CastExpression_113_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_114_Var
		);
		//114
		final PostfixExpression PostfixExpression_115_Var
		 = (PostfixExpression)UnaryExpression_114_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = PostfixExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final PrimaryExpression PrimaryExpression_116_Var
		 = (PrimaryExpression)Expr_115_list.get(0);
		Assert.assertNotNull(PrimaryExpression_116_Var
		);
		//116
		final Constant2 Constant2_117_Var
		 = (Constant2)PrimaryExpression_116_Var
		.getConst();
		Assert.assertNotNull(Constant2_117_Var
		);
		Assert.assertEquals("\"+r\"", Constant2_117_Var
		.getStr());
		final EList<? extends EObject> Suffix_117_list = PostfixExpression_115_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_117_list);
		Assert.assertEquals(1, Suffix_117_list.size());
		//117
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_118_Var
		 = (PostfixExpressionSuffixArgument)Suffix_117_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_118_Var
		);
		//118
		final ArgumentExpressionList ArgumentExpressionList_119_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_118_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_119_Var
		);
		final EList<? extends EObject> Expr_119_list = ArgumentExpressionList_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final AssignmentExpression AssignmentExpression_120_Var
		 = (AssignmentExpression)Expr_119_list.get(0);
		Assert.assertNotNull(AssignmentExpression_120_Var
		);
		//120
		final ConditionalExpression ConditionalExpression_121_Var
		 = (ConditionalExpression)AssignmentExpression_120_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_121_Var
		);
		//121
		final LogicalOrExpression LogicalOrExpression_122_Var
		 = (LogicalOrExpression)ConditionalExpression_121_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = LogicalOrExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final LogicalAndExpression LogicalAndExpression_123_Var
		 = (LogicalAndExpression)Expr_122_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = LogicalAndExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final InclusiveOrExpression InclusiveOrExpression_124_Var
		 = (InclusiveOrExpression)Expr_123_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = InclusiveOrExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final ExclusiveOrExpression ExclusiveOrExpression_125_Var
		 = (ExclusiveOrExpression)Expr_124_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = ExclusiveOrExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final AndExpression AndExpression_126_Var
		 = (AndExpression)Expr_125_list.get(0);
		Assert.assertNotNull(AndExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = AndExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final EqualityExpression EqualityExpression_127_Var
		 = (EqualityExpression)Expr_126_list.get(0);
		Assert.assertNotNull(EqualityExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = EqualityExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final RelationalExpression RelationalExpression_128_Var
		 = (RelationalExpression)Expr_127_list.get(0);
		Assert.assertNotNull(RelationalExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = RelationalExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final ShiftExpression ShiftExpression_129_Var
		 = (ShiftExpression)Expr_128_list.get(0);
		Assert.assertNotNull(ShiftExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = ShiftExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final AdditiveExpression AdditiveExpression_130_Var
		 = (AdditiveExpression)Expr_129_list.get(0);
		Assert.assertNotNull(AdditiveExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = AdditiveExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final MultiplicativeExpression MultiplicativeExpression_131_Var
		 = (MultiplicativeExpression)Expr_130_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = MultiplicativeExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final CastExpression CastExpression_132_Var
		 = (CastExpression)Expr_131_list.get(0);
		Assert.assertNotNull(CastExpression_132_Var
		);
		//132
		final UnaryExpression UnaryExpression_133_Var
		 = (UnaryExpression)CastExpression_132_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_133_Var
		);
		//133
		final PostfixExpression PostfixExpression_134_Var
		 = (PostfixExpression)UnaryExpression_133_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = PostfixExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final PrimaryExpression PrimaryExpression_135_Var
		 = (PrimaryExpression)Expr_134_list.get(0);
		Assert.assertNotNull(PrimaryExpression_135_Var
		);
		Assert.assertEquals("bar", PrimaryExpression_135_Var
		.getId());
		//135
		final AsmLineWithColon AsmLineWithColon_136_Var
		 = (AsmLineWithColon)AsmLines_100_list.get(1);
		Assert.assertNotNull(AsmLineWithColon_136_Var
		);
		//136
		final AsmLineWithoutColon AsmLineWithoutColon_137_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_136_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_137_Var
		);
		//137
		final LogicalOrExpression LogicalOrExpression_138_Var
		 = (LogicalOrExpression)AsmLineWithoutColon_137_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = LogicalOrExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final LogicalAndExpression LogicalAndExpression_139_Var
		 = (LogicalAndExpression)Expr_138_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = LogicalAndExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final InclusiveOrExpression InclusiveOrExpression_140_Var
		 = (InclusiveOrExpression)Expr_139_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = InclusiveOrExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final ExclusiveOrExpression ExclusiveOrExpression_141_Var
		 = (ExclusiveOrExpression)Expr_140_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = ExclusiveOrExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final AndExpression AndExpression_142_Var
		 = (AndExpression)Expr_141_list.get(0);
		Assert.assertNotNull(AndExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = AndExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final EqualityExpression EqualityExpression_143_Var
		 = (EqualityExpression)Expr_142_list.get(0);
		Assert.assertNotNull(EqualityExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = EqualityExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final RelationalExpression RelationalExpression_144_Var
		 = (RelationalExpression)Expr_143_list.get(0);
		Assert.assertNotNull(RelationalExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = RelationalExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final ShiftExpression ShiftExpression_145_Var
		 = (ShiftExpression)Expr_144_list.get(0);
		Assert.assertNotNull(ShiftExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = ShiftExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final AdditiveExpression AdditiveExpression_146_Var
		 = (AdditiveExpression)Expr_145_list.get(0);
		Assert.assertNotNull(AdditiveExpression_146_Var
		);
		final EList<? extends EObject> Expr_146_list = AdditiveExpression_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final MultiplicativeExpression MultiplicativeExpression_147_Var
		 = (MultiplicativeExpression)Expr_146_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_147_Var
		);
		final EList<? extends EObject> Expr_147_list = MultiplicativeExpression_147_Var
		.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(1, Expr_147_list.size());
		//147
		final CastExpression CastExpression_148_Var
		 = (CastExpression)Expr_147_list.get(0);
		Assert.assertNotNull(CastExpression_148_Var
		);
		//148
		final UnaryExpression UnaryExpression_149_Var
		 = (UnaryExpression)CastExpression_148_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_149_Var
		);
		//149
		final PostfixExpression PostfixExpression_150_Var
		 = (PostfixExpression)UnaryExpression_149_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_150_Var
		);
		final EList<? extends EObject> Expr_150_list = PostfixExpression_150_Var
		.getExpr();
		Assert.assertNotNull(Expr_150_list);
		Assert.assertEquals(1, Expr_150_list.size());
		//150
		final PrimaryExpression PrimaryExpression_151_Var
		 = (PrimaryExpression)Expr_150_list.get(0);
		Assert.assertNotNull(PrimaryExpression_151_Var
		);
		//151
		final Constant2 Constant2_152_Var
		 = (Constant2)PrimaryExpression_151_Var
		.getConst();
		Assert.assertNotNull(Constant2_152_Var
		);
		Assert.assertEquals("\"g\"", Constant2_152_Var
		.getStr());
		final EList<? extends EObject> Suffix_152_list = PostfixExpression_150_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_152_list);
		Assert.assertEquals(1, Suffix_152_list.size());
		//152
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_153_Var
		 = (PostfixExpressionSuffixArgument)Suffix_152_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_153_Var
		);
		//153
		final ArgumentExpressionList ArgumentExpressionList_154_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_153_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_154_Var
		);
		final EList<? extends EObject> Expr_154_list = ArgumentExpressionList_154_Var
		.getExpr();
		Assert.assertNotNull(Expr_154_list);
		Assert.assertEquals(1, Expr_154_list.size());
		//154
		final AssignmentExpression AssignmentExpression_155_Var
		 = (AssignmentExpression)Expr_154_list.get(0);
		Assert.assertNotNull(AssignmentExpression_155_Var
		);
		//155
		final ConditionalExpression ConditionalExpression_156_Var
		 = (ConditionalExpression)AssignmentExpression_155_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_156_Var
		);
		//156
		final LogicalOrExpression LogicalOrExpression_157_Var
		 = (LogicalOrExpression)ConditionalExpression_156_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = LogicalOrExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final LogicalAndExpression LogicalAndExpression_158_Var
		 = (LogicalAndExpression)Expr_157_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = LogicalAndExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final InclusiveOrExpression InclusiveOrExpression_159_Var
		 = (InclusiveOrExpression)Expr_158_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = InclusiveOrExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final ExclusiveOrExpression ExclusiveOrExpression_160_Var
		 = (ExclusiveOrExpression)Expr_159_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = ExclusiveOrExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final AndExpression AndExpression_161_Var
		 = (AndExpression)Expr_160_list.get(0);
		Assert.assertNotNull(AndExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = AndExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final EqualityExpression EqualityExpression_162_Var
		 = (EqualityExpression)Expr_161_list.get(0);
		Assert.assertNotNull(EqualityExpression_162_Var
		);
		final EList<? extends EObject> Expr_162_list = EqualityExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		//162
		final RelationalExpression RelationalExpression_163_Var
		 = (RelationalExpression)Expr_162_list.get(0);
		Assert.assertNotNull(RelationalExpression_163_Var
		);
		final EList<? extends EObject> Expr_163_list = RelationalExpression_163_Var
		.getExpr();
		Assert.assertNotNull(Expr_163_list);
		Assert.assertEquals(1, Expr_163_list.size());
		//163
		final ShiftExpression ShiftExpression_164_Var
		 = (ShiftExpression)Expr_163_list.get(0);
		Assert.assertNotNull(ShiftExpression_164_Var
		);
		final EList<? extends EObject> Expr_164_list = ShiftExpression_164_Var
		.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		//164
		final AdditiveExpression AdditiveExpression_165_Var
		 = (AdditiveExpression)Expr_164_list.get(0);
		Assert.assertNotNull(AdditiveExpression_165_Var
		);
		final EList<? extends EObject> Expr_165_list = AdditiveExpression_165_Var
		.getExpr();
		Assert.assertNotNull(Expr_165_list);
		Assert.assertEquals(1, Expr_165_list.size());
		//165
		final MultiplicativeExpression MultiplicativeExpression_166_Var
		 = (MultiplicativeExpression)Expr_165_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_166_Var
		);
		final EList<? extends EObject> Expr_166_list = MultiplicativeExpression_166_Var
		.getExpr();
		Assert.assertNotNull(Expr_166_list);
		Assert.assertEquals(1, Expr_166_list.size());
		//166
		final CastExpression CastExpression_167_Var
		 = (CastExpression)Expr_166_list.get(0);
		Assert.assertNotNull(CastExpression_167_Var
		);
		//167
		final UnaryExpression UnaryExpression_168_Var
		 = (UnaryExpression)CastExpression_167_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_168_Var
		);
		//168
		final PostfixExpression PostfixExpression_169_Var
		 = (PostfixExpression)UnaryExpression_168_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_169_Var
		);
		final EList<? extends EObject> Expr_169_list = PostfixExpression_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		//169
		final PrimaryExpression PrimaryExpression_170_Var
		 = (PrimaryExpression)Expr_169_list.get(0);
		Assert.assertNotNull(PrimaryExpression_170_Var
		);
		Assert.assertEquals("foo", PrimaryExpression_170_Var
		.getId());
		//170
		final AsmLineWithColon AsmLineWithColon_171_Var
		 = (AsmLineWithColon)AsmLines_100_list.get(2);
		Assert.assertNotNull(AsmLineWithColon_171_Var
		);
		//171
		final AsmLineWithoutColon AsmLineWithoutColon_172_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_171_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_172_Var
		);
		//172
		final LogicalOrExpression LogicalOrExpression_173_Var
		 = (LogicalOrExpression)AsmLineWithoutColon_172_Var
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
		//186
		final Constant2 Constant2_187_Var
		 = (Constant2)PrimaryExpression_186_Var
		.getConst();
		Assert.assertNotNull(Constant2_187_Var
		);
		Assert.assertEquals("\"cc\"", Constant2_187_Var
		.getStr());
		//187
		final AsmLineWithColon AsmLineWithColon_188_Var
		 = (AsmLineWithColon)AsmLines_100_list.get(3);
		Assert.assertNotNull(AsmLineWithColon_188_Var
		);
		//188
		final Statement Statement_189_Var
		 = (Statement)Statement_66_list.get(1);
		Assert.assertNotNull(Statement_189_Var
		);
		//189
		final ExpressionStatement ExpressionStatement_190_Var
		 = (ExpressionStatement)Statement_189_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_190_Var
		);
		//190
		final Expression Expression_191_Var
		 = (Expression)ExpressionStatement_190_Var
		.getExpression();
		Assert.assertNotNull(Expression_191_Var
		);
		final EList<? extends EObject> ExprExpr_191_list = Expression_191_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_191_list);
		Assert.assertEquals(1, ExprExpr_191_list.size());
		//191
		final AssignmentExpression AssignmentExpression_192_Var
		 = (AssignmentExpression)ExprExpr_191_list.get(0);
		Assert.assertNotNull(AssignmentExpression_192_Var
		);
		//192
		final ConditionalExpression ConditionalExpression_193_Var
		 = (ConditionalExpression)AssignmentExpression_192_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_193_Var
		);
		//193
		final LogicalOrExpression LogicalOrExpression_194_Var
		 = (LogicalOrExpression)ConditionalExpression_193_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = LogicalOrExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final LogicalAndExpression LogicalAndExpression_195_Var
		 = (LogicalAndExpression)Expr_194_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = LogicalAndExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final InclusiveOrExpression InclusiveOrExpression_196_Var
		 = (InclusiveOrExpression)Expr_195_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = InclusiveOrExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final ExclusiveOrExpression ExclusiveOrExpression_197_Var
		 = (ExclusiveOrExpression)Expr_196_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = ExclusiveOrExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final AndExpression AndExpression_198_Var
		 = (AndExpression)Expr_197_list.get(0);
		Assert.assertNotNull(AndExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = AndExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final EqualityExpression EqualityExpression_199_Var
		 = (EqualityExpression)Expr_198_list.get(0);
		Assert.assertNotNull(EqualityExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = EqualityExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final RelationalExpression RelationalExpression_200_Var
		 = (RelationalExpression)Expr_199_list.get(0);
		Assert.assertNotNull(RelationalExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = RelationalExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final ShiftExpression ShiftExpression_201_Var
		 = (ShiftExpression)Expr_200_list.get(0);
		Assert.assertNotNull(ShiftExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = ShiftExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final AdditiveExpression AdditiveExpression_202_Var
		 = (AdditiveExpression)Expr_201_list.get(0);
		Assert.assertNotNull(AdditiveExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = AdditiveExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final MultiplicativeExpression MultiplicativeExpression_203_Var
		 = (MultiplicativeExpression)Expr_202_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = MultiplicativeExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final CastExpression CastExpression_204_Var
		 = (CastExpression)Expr_203_list.get(0);
		Assert.assertNotNull(CastExpression_204_Var
		);
		//204
		final UnaryExpression UnaryExpression_205_Var
		 = (UnaryExpression)CastExpression_204_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_205_Var
		);
		//205
		final PostfixExpression PostfixExpression_206_Var
		 = (PostfixExpression)UnaryExpression_205_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = PostfixExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final PrimaryExpression PrimaryExpression_207_Var
		 = (PrimaryExpression)Expr_206_list.get(0);
		Assert.assertNotNull(PrimaryExpression_207_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_207_Var
		.getId());
		final EList<? extends EObject> Suffix_207_list = PostfixExpression_206_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_207_list);
		Assert.assertEquals(1, Suffix_207_list.size());
		//207
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_208_Var
		 = (PostfixExpressionSuffixArgument)Suffix_207_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_208_Var
		);
		//208
		final ArgumentExpressionList ArgumentExpressionList_209_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_208_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_209_Var
		);
		final EList<? extends EObject> Expr_209_list = ArgumentExpressionList_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(2, Expr_209_list.size());
		//209
		final AssignmentExpression AssignmentExpression_210_Var
		 = (AssignmentExpression)Expr_209_list.get(0);
		Assert.assertNotNull(AssignmentExpression_210_Var
		);
		//210
		final ConditionalExpression ConditionalExpression_211_Var
		 = (ConditionalExpression)AssignmentExpression_210_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_211_Var
		);
		//211
		final LogicalOrExpression LogicalOrExpression_212_Var
		 = (LogicalOrExpression)ConditionalExpression_211_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = LogicalOrExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final LogicalAndExpression LogicalAndExpression_213_Var
		 = (LogicalAndExpression)Expr_212_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = LogicalAndExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final InclusiveOrExpression InclusiveOrExpression_214_Var
		 = (InclusiveOrExpression)Expr_213_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = InclusiveOrExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final ExclusiveOrExpression ExclusiveOrExpression_215_Var
		 = (ExclusiveOrExpression)Expr_214_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = ExclusiveOrExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final AndExpression AndExpression_216_Var
		 = (AndExpression)Expr_215_list.get(0);
		Assert.assertNotNull(AndExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = AndExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final EqualityExpression EqualityExpression_217_Var
		 = (EqualityExpression)Expr_216_list.get(0);
		Assert.assertNotNull(EqualityExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = EqualityExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final RelationalExpression RelationalExpression_218_Var
		 = (RelationalExpression)Expr_217_list.get(0);
		Assert.assertNotNull(RelationalExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = RelationalExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final ShiftExpression ShiftExpression_219_Var
		 = (ShiftExpression)Expr_218_list.get(0);
		Assert.assertNotNull(ShiftExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = ShiftExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final AdditiveExpression AdditiveExpression_220_Var
		 = (AdditiveExpression)Expr_219_list.get(0);
		Assert.assertNotNull(AdditiveExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = AdditiveExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final MultiplicativeExpression MultiplicativeExpression_221_Var
		 = (MultiplicativeExpression)Expr_220_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = MultiplicativeExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final CastExpression CastExpression_222_Var
		 = (CastExpression)Expr_221_list.get(0);
		Assert.assertNotNull(CastExpression_222_Var
		);
		//222
		final UnaryExpression UnaryExpression_223_Var
		 = (UnaryExpression)CastExpression_222_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_223_Var
		);
		//223
		final PostfixExpression PostfixExpression_224_Var
		 = (PostfixExpression)UnaryExpression_223_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = PostfixExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final PrimaryExpression PrimaryExpression_225_Var
		 = (PrimaryExpression)Expr_224_list.get(0);
		Assert.assertNotNull(PrimaryExpression_225_Var
		);
		//225
		final Constant2 Constant2_226_Var
		 = (Constant2)PrimaryExpression_225_Var
		.getConst();
		Assert.assertNotNull(Constant2_226_Var
		);
		Assert.assertEquals("\"Ergebnis: %i\\n\"", Constant2_226_Var
		.getStr());
		//226
		final AssignmentExpression AssignmentExpression_227_Var
		 = (AssignmentExpression)Expr_209_list.get(1);
		Assert.assertNotNull(AssignmentExpression_227_Var
		);
		//227
		final ConditionalExpression ConditionalExpression_228_Var
		 = (ConditionalExpression)AssignmentExpression_227_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_228_Var
		);
		//228
		final LogicalOrExpression LogicalOrExpression_229_Var
		 = (LogicalOrExpression)ConditionalExpression_228_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = LogicalOrExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final LogicalAndExpression LogicalAndExpression_230_Var
		 = (LogicalAndExpression)Expr_229_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = LogicalAndExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final InclusiveOrExpression InclusiveOrExpression_231_Var
		 = (InclusiveOrExpression)Expr_230_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = InclusiveOrExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final ExclusiveOrExpression ExclusiveOrExpression_232_Var
		 = (ExclusiveOrExpression)Expr_231_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = ExclusiveOrExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final AndExpression AndExpression_233_Var
		 = (AndExpression)Expr_232_list.get(0);
		Assert.assertNotNull(AndExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = AndExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final EqualityExpression EqualityExpression_234_Var
		 = (EqualityExpression)Expr_233_list.get(0);
		Assert.assertNotNull(EqualityExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = EqualityExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final RelationalExpression RelationalExpression_235_Var
		 = (RelationalExpression)Expr_234_list.get(0);
		Assert.assertNotNull(RelationalExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = RelationalExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final ShiftExpression ShiftExpression_236_Var
		 = (ShiftExpression)Expr_235_list.get(0);
		Assert.assertNotNull(ShiftExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = ShiftExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final AdditiveExpression AdditiveExpression_237_Var
		 = (AdditiveExpression)Expr_236_list.get(0);
		Assert.assertNotNull(AdditiveExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = AdditiveExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final MultiplicativeExpression MultiplicativeExpression_238_Var
		 = (MultiplicativeExpression)Expr_237_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = MultiplicativeExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final CastExpression CastExpression_239_Var
		 = (CastExpression)Expr_238_list.get(0);
		Assert.assertNotNull(CastExpression_239_Var
		);
		//239
		final UnaryExpression UnaryExpression_240_Var
		 = (UnaryExpression)CastExpression_239_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_240_Var
		);
		//240
		final PostfixExpression PostfixExpression_241_Var
		 = (PostfixExpression)UnaryExpression_240_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = PostfixExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final PrimaryExpression PrimaryExpression_242_Var
		 = (PrimaryExpression)Expr_241_list.get(0);
		Assert.assertNotNull(PrimaryExpression_242_Var
		);
		Assert.assertEquals("bar", PrimaryExpression_242_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_190_Var
		.getSemi());
		//242
		final Statement Statement_243_Var
		 = (Statement)Statement_66_list.get(2);
		Assert.assertNotNull(Statement_243_Var
		);
		//243
		final JumpStatement JumpStatement_244_Var
		 = (JumpStatement)Statement_243_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_244_Var
		);
		//244
		final Expression Expression_245_Var
		 = (Expression)JumpStatement_244_Var
		.getExpr();
		Assert.assertNotNull(Expression_245_Var
		);
		final EList<? extends EObject> ExprExpr_245_list = Expression_245_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_245_list);
		Assert.assertEquals(1, ExprExpr_245_list.size());
		//245
		final AssignmentExpression AssignmentExpression_246_Var
		 = (AssignmentExpression)ExprExpr_245_list.get(0);
		Assert.assertNotNull(AssignmentExpression_246_Var
		);
		//246
		final ConditionalExpression ConditionalExpression_247_Var
		 = (ConditionalExpression)AssignmentExpression_246_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_247_Var
		);
		//247
		final LogicalOrExpression LogicalOrExpression_248_Var
		 = (LogicalOrExpression)ConditionalExpression_247_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = LogicalOrExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final LogicalAndExpression LogicalAndExpression_249_Var
		 = (LogicalAndExpression)Expr_248_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = LogicalAndExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final InclusiveOrExpression InclusiveOrExpression_250_Var
		 = (InclusiveOrExpression)Expr_249_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = InclusiveOrExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final ExclusiveOrExpression ExclusiveOrExpression_251_Var
		 = (ExclusiveOrExpression)Expr_250_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = ExclusiveOrExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final AndExpression AndExpression_252_Var
		 = (AndExpression)Expr_251_list.get(0);
		Assert.assertNotNull(AndExpression_252_Var
		);
		final EList<? extends EObject> Expr_252_list = AndExpression_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(1, Expr_252_list.size());
		//252
		final EqualityExpression EqualityExpression_253_Var
		 = (EqualityExpression)Expr_252_list.get(0);
		Assert.assertNotNull(EqualityExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = EqualityExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final RelationalExpression RelationalExpression_254_Var
		 = (RelationalExpression)Expr_253_list.get(0);
		Assert.assertNotNull(RelationalExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = RelationalExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final ShiftExpression ShiftExpression_255_Var
		 = (ShiftExpression)Expr_254_list.get(0);
		Assert.assertNotNull(ShiftExpression_255_Var
		);
		final EList<? extends EObject> Expr_255_list = ShiftExpression_255_Var
		.getExpr();
		Assert.assertNotNull(Expr_255_list);
		Assert.assertEquals(1, Expr_255_list.size());
		//255
		final AdditiveExpression AdditiveExpression_256_Var
		 = (AdditiveExpression)Expr_255_list.get(0);
		Assert.assertNotNull(AdditiveExpression_256_Var
		);
		final EList<? extends EObject> Expr_256_list = AdditiveExpression_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(1, Expr_256_list.size());
		//256
		final MultiplicativeExpression MultiplicativeExpression_257_Var
		 = (MultiplicativeExpression)Expr_256_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = MultiplicativeExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final CastExpression CastExpression_258_Var
		 = (CastExpression)Expr_257_list.get(0);
		Assert.assertNotNull(CastExpression_258_Var
		);
		//258
		final UnaryExpression UnaryExpression_259_Var
		 = (UnaryExpression)CastExpression_258_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_259_Var
		);
		//259
		final PostfixExpression PostfixExpression_260_Var
		 = (PostfixExpression)UnaryExpression_259_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = PostfixExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final PrimaryExpression PrimaryExpression_261_Var
		 = (PrimaryExpression)Expr_260_list.get(0);
		Assert.assertNotNull(PrimaryExpression_261_Var
		);
		//261
		final Constant2 Constant2_262_Var
		 = (Constant2)PrimaryExpression_261_Var
		.getConst();
		Assert.assertNotNull(Constant2_262_Var
		);
		Assert.assertEquals("0", Constant2_262_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_244_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_244_Var
		.getSemi());
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
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0030_Assembler2.c");
		final String expected = this.getTextFromFile(
			"res/Test0030_Assembler2.c"
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


