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
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
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
	
	@Test
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
	
	@Test
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
		final EList<? extends EObject> AsmLine_68_list = AsmStatement_68_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLine_68_list);
		Assert.assertEquals(5, AsmLine_68_list.size());
		//68
		final AsmLineWithColon AsmLineWithColon_69_Var
		 = (AsmLineWithColon)AsmLine_68_list.get(0);
		Assert.assertNotNull(AsmLineWithColon_69_Var
		);
		//69
		final LogicalOrExpression LogicalOrExpression_70_Var
		 = (LogicalOrExpression)AsmLineWithColon_69_Var
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
		//84
		final AsmLineWithColon AsmLineWithColon_85_Var
		 = (AsmLineWithColon)AsmLine_68_list.get(1);
		Assert.assertNotNull(AsmLineWithColon_85_Var
		);
		//85
		final LogicalOrExpression LogicalOrExpression_86_Var
		 = (LogicalOrExpression)AsmLineWithColon_85_Var
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
		//100
		final AsmLineWithColon AsmLineWithColon_101_Var
		 = (AsmLineWithColon)AsmLine_68_list.get(2);
		Assert.assertNotNull(AsmLineWithColon_101_Var
		);
		//101
		final LogicalOrExpression LogicalOrExpression_102_Var
		 = (LogicalOrExpression)AsmLineWithColon_101_Var
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
		//115
		final Constant2 Constant2_116_Var
		 = (Constant2)PrimaryExpression_115_Var
		.getConst();
		Assert.assertNotNull(Constant2_116_Var
		);
		Assert.assertEquals("\"+r\"", Constant2_116_Var
		.getStr());
		final EList<? extends EObject> Suffix_116_list = PostfixExpression_114_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_116_list);
		Assert.assertEquals(1, Suffix_116_list.size());
		//116
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_117_Var
		 = (PostfixExpressionSuffixArgument)Suffix_116_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_117_Var
		);
		//117
		final ArgumentExpressionList ArgumentExpressionList_118_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_117_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_118_Var
		);
		final EList<? extends EObject> Expr_118_list = ArgumentExpressionList_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final AssignmentExpression AssignmentExpression_119_Var
		 = (AssignmentExpression)Expr_118_list.get(0);
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
		Assert.assertEquals("bar", PrimaryExpression_134_Var
		.getId());
		//134
		final AsmLine AsmLine_135_Var
		 = (AsmLine)AsmLine_68_list.get(3);
		Assert.assertNotNull(AsmLine_135_Var
		);
		//135
		final LogicalOrExpression LogicalOrExpression_136_Var
		 = (LogicalOrExpression)AsmLine_135_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = LogicalOrExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final LogicalAndExpression LogicalAndExpression_137_Var
		 = (LogicalAndExpression)Expr_136_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = LogicalAndExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final InclusiveOrExpression InclusiveOrExpression_138_Var
		 = (InclusiveOrExpression)Expr_137_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = InclusiveOrExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final ExclusiveOrExpression ExclusiveOrExpression_139_Var
		 = (ExclusiveOrExpression)Expr_138_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = ExclusiveOrExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final AndExpression AndExpression_140_Var
		 = (AndExpression)Expr_139_list.get(0);
		Assert.assertNotNull(AndExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = AndExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final EqualityExpression EqualityExpression_141_Var
		 = (EqualityExpression)Expr_140_list.get(0);
		Assert.assertNotNull(EqualityExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = EqualityExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final RelationalExpression RelationalExpression_142_Var
		 = (RelationalExpression)Expr_141_list.get(0);
		Assert.assertNotNull(RelationalExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = RelationalExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final ShiftExpression ShiftExpression_143_Var
		 = (ShiftExpression)Expr_142_list.get(0);
		Assert.assertNotNull(ShiftExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = ShiftExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final AdditiveExpression AdditiveExpression_144_Var
		 = (AdditiveExpression)Expr_143_list.get(0);
		Assert.assertNotNull(AdditiveExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = AdditiveExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final MultiplicativeExpression MultiplicativeExpression_145_Var
		 = (MultiplicativeExpression)Expr_144_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = MultiplicativeExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final CastExpression CastExpression_146_Var
		 = (CastExpression)Expr_145_list.get(0);
		Assert.assertNotNull(CastExpression_146_Var
		);
		//146
		final UnaryExpression UnaryExpression_147_Var
		 = (UnaryExpression)CastExpression_146_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_147_Var
		);
		//147
		final PostfixExpression PostfixExpression_148_Var
		 = (PostfixExpression)UnaryExpression_147_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_148_Var
		);
		final EList<? extends EObject> Expr_148_list = PostfixExpression_148_Var
		.getExpr();
		Assert.assertNotNull(Expr_148_list);
		Assert.assertEquals(1, Expr_148_list.size());
		//148
		final PrimaryExpression PrimaryExpression_149_Var
		 = (PrimaryExpression)Expr_148_list.get(0);
		Assert.assertNotNull(PrimaryExpression_149_Var
		);
		//149
		final Constant2 Constant2_150_Var
		 = (Constant2)PrimaryExpression_149_Var
		.getConst();
		Assert.assertNotNull(Constant2_150_Var
		);
		Assert.assertEquals("\"g\"", Constant2_150_Var
		.getStr());
		final EList<? extends EObject> Suffix_150_list = PostfixExpression_148_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_150_list);
		Assert.assertEquals(1, Suffix_150_list.size());
		//150
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_151_Var
		 = (PostfixExpressionSuffixArgument)Suffix_150_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_151_Var
		);
		//151
		final ArgumentExpressionList ArgumentExpressionList_152_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_151_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_152_Var
		);
		final EList<? extends EObject> Expr_152_list = ArgumentExpressionList_152_Var
		.getExpr();
		Assert.assertNotNull(Expr_152_list);
		Assert.assertEquals(1, Expr_152_list.size());
		//152
		final AssignmentExpression AssignmentExpression_153_Var
		 = (AssignmentExpression)Expr_152_list.get(0);
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
		Assert.assertEquals("foo", PrimaryExpression_168_Var
		.getId());
		//168
		final AsmLineWithColon AsmLineWithColon_169_Var
		 = (AsmLineWithColon)AsmLine_68_list.get(4);
		Assert.assertNotNull(AsmLineWithColon_169_Var
		);
		//169
		final LogicalOrExpression LogicalOrExpression_170_Var
		 = (LogicalOrExpression)AsmLineWithColon_169_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_170_Var
		);
		final EList<? extends EObject> Expr_170_list = LogicalOrExpression_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		//170
		final LogicalAndExpression LogicalAndExpression_171_Var
		 = (LogicalAndExpression)Expr_170_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_171_Var
		);
		final EList<? extends EObject> Expr_171_list = LogicalAndExpression_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		//171
		final InclusiveOrExpression InclusiveOrExpression_172_Var
		 = (InclusiveOrExpression)Expr_171_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = InclusiveOrExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final ExclusiveOrExpression ExclusiveOrExpression_173_Var
		 = (ExclusiveOrExpression)Expr_172_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = ExclusiveOrExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final AndExpression AndExpression_174_Var
		 = (AndExpression)Expr_173_list.get(0);
		Assert.assertNotNull(AndExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = AndExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final EqualityExpression EqualityExpression_175_Var
		 = (EqualityExpression)Expr_174_list.get(0);
		Assert.assertNotNull(EqualityExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = EqualityExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final RelationalExpression RelationalExpression_176_Var
		 = (RelationalExpression)Expr_175_list.get(0);
		Assert.assertNotNull(RelationalExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = RelationalExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final ShiftExpression ShiftExpression_177_Var
		 = (ShiftExpression)Expr_176_list.get(0);
		Assert.assertNotNull(ShiftExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = ShiftExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final AdditiveExpression AdditiveExpression_178_Var
		 = (AdditiveExpression)Expr_177_list.get(0);
		Assert.assertNotNull(AdditiveExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = AdditiveExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final MultiplicativeExpression MultiplicativeExpression_179_Var
		 = (MultiplicativeExpression)Expr_178_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = MultiplicativeExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final CastExpression CastExpression_180_Var
		 = (CastExpression)Expr_179_list.get(0);
		Assert.assertNotNull(CastExpression_180_Var
		);
		//180
		final UnaryExpression UnaryExpression_181_Var
		 = (UnaryExpression)CastExpression_180_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_181_Var
		);
		//181
		final PostfixExpression PostfixExpression_182_Var
		 = (PostfixExpression)UnaryExpression_181_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_182_Var
		);
		final EList<? extends EObject> Expr_182_list = PostfixExpression_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(1, Expr_182_list.size());
		//182
		final PrimaryExpression PrimaryExpression_183_Var
		 = (PrimaryExpression)Expr_182_list.get(0);
		Assert.assertNotNull(PrimaryExpression_183_Var
		);
		//183
		final Constant2 Constant2_184_Var
		 = (Constant2)PrimaryExpression_183_Var
		.getConst();
		Assert.assertNotNull(Constant2_184_Var
		);
		Assert.assertEquals("\"cc\"", Constant2_184_Var
		.getStr());
		//184
		final Statement Statement_185_Var
		 = (Statement)Statement_66_list.get(1);
		Assert.assertNotNull(Statement_185_Var
		);
		//185
		final ExpressionStatement ExpressionStatement_186_Var
		 = (ExpressionStatement)Statement_185_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_186_Var
		);
		//186
		final Expression Expression_187_Var
		 = (Expression)ExpressionStatement_186_Var
		.getExpression();
		Assert.assertNotNull(Expression_187_Var
		);
		final EList<? extends EObject> ExprExpr_187_list = Expression_187_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_187_list);
		Assert.assertEquals(1, ExprExpr_187_list.size());
		//187
		final AssignmentExpression AssignmentExpression_188_Var
		 = (AssignmentExpression)ExprExpr_187_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_203_Var
		.getId());
		final EList<? extends EObject> Suffix_203_list = PostfixExpression_202_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_203_list);
		Assert.assertEquals(1, Suffix_203_list.size());
		//203
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_204_Var
		 = (PostfixExpressionSuffixArgument)Suffix_203_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_204_Var
		);
		//204
		final ArgumentExpressionList ArgumentExpressionList_205_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_204_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_205_Var
		);
		final EList<? extends EObject> Expr_205_list = ArgumentExpressionList_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(2, Expr_205_list.size());
		//205
		final AssignmentExpression AssignmentExpression_206_Var
		 = (AssignmentExpression)Expr_205_list.get(0);
		Assert.assertNotNull(AssignmentExpression_206_Var
		);
		//206
		final ConditionalExpression ConditionalExpression_207_Var
		 = (ConditionalExpression)AssignmentExpression_206_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_207_Var
		);
		//207
		final LogicalOrExpression LogicalOrExpression_208_Var
		 = (LogicalOrExpression)ConditionalExpression_207_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = LogicalOrExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final LogicalAndExpression LogicalAndExpression_209_Var
		 = (LogicalAndExpression)Expr_208_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = LogicalAndExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final InclusiveOrExpression InclusiveOrExpression_210_Var
		 = (InclusiveOrExpression)Expr_209_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = InclusiveOrExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final ExclusiveOrExpression ExclusiveOrExpression_211_Var
		 = (ExclusiveOrExpression)Expr_210_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = ExclusiveOrExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final AndExpression AndExpression_212_Var
		 = (AndExpression)Expr_211_list.get(0);
		Assert.assertNotNull(AndExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = AndExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final EqualityExpression EqualityExpression_213_Var
		 = (EqualityExpression)Expr_212_list.get(0);
		Assert.assertNotNull(EqualityExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = EqualityExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final RelationalExpression RelationalExpression_214_Var
		 = (RelationalExpression)Expr_213_list.get(0);
		Assert.assertNotNull(RelationalExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = RelationalExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final ShiftExpression ShiftExpression_215_Var
		 = (ShiftExpression)Expr_214_list.get(0);
		Assert.assertNotNull(ShiftExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = ShiftExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final AdditiveExpression AdditiveExpression_216_Var
		 = (AdditiveExpression)Expr_215_list.get(0);
		Assert.assertNotNull(AdditiveExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = AdditiveExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final MultiplicativeExpression MultiplicativeExpression_217_Var
		 = (MultiplicativeExpression)Expr_216_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = MultiplicativeExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final CastExpression CastExpression_218_Var
		 = (CastExpression)Expr_217_list.get(0);
		Assert.assertNotNull(CastExpression_218_Var
		);
		//218
		final UnaryExpression UnaryExpression_219_Var
		 = (UnaryExpression)CastExpression_218_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_219_Var
		);
		//219
		final PostfixExpression PostfixExpression_220_Var
		 = (PostfixExpression)UnaryExpression_219_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = PostfixExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final PrimaryExpression PrimaryExpression_221_Var
		 = (PrimaryExpression)Expr_220_list.get(0);
		Assert.assertNotNull(PrimaryExpression_221_Var
		);
		//221
		final Constant2 Constant2_222_Var
		 = (Constant2)PrimaryExpression_221_Var
		.getConst();
		Assert.assertNotNull(Constant2_222_Var
		);
		Assert.assertEquals("\"Ergebnis: %i\\n\"", Constant2_222_Var
		.getStr());
		//222
		final AssignmentExpression AssignmentExpression_223_Var
		 = (AssignmentExpression)Expr_205_list.get(1);
		Assert.assertNotNull(AssignmentExpression_223_Var
		);
		//223
		final ConditionalExpression ConditionalExpression_224_Var
		 = (ConditionalExpression)AssignmentExpression_223_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_224_Var
		);
		//224
		final LogicalOrExpression LogicalOrExpression_225_Var
		 = (LogicalOrExpression)ConditionalExpression_224_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = LogicalOrExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final LogicalAndExpression LogicalAndExpression_226_Var
		 = (LogicalAndExpression)Expr_225_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = LogicalAndExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final InclusiveOrExpression InclusiveOrExpression_227_Var
		 = (InclusiveOrExpression)Expr_226_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = InclusiveOrExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final ExclusiveOrExpression ExclusiveOrExpression_228_Var
		 = (ExclusiveOrExpression)Expr_227_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = ExclusiveOrExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final AndExpression AndExpression_229_Var
		 = (AndExpression)Expr_228_list.get(0);
		Assert.assertNotNull(AndExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = AndExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final EqualityExpression EqualityExpression_230_Var
		 = (EqualityExpression)Expr_229_list.get(0);
		Assert.assertNotNull(EqualityExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = EqualityExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final RelationalExpression RelationalExpression_231_Var
		 = (RelationalExpression)Expr_230_list.get(0);
		Assert.assertNotNull(RelationalExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = RelationalExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final ShiftExpression ShiftExpression_232_Var
		 = (ShiftExpression)Expr_231_list.get(0);
		Assert.assertNotNull(ShiftExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = ShiftExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final AdditiveExpression AdditiveExpression_233_Var
		 = (AdditiveExpression)Expr_232_list.get(0);
		Assert.assertNotNull(AdditiveExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = AdditiveExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final MultiplicativeExpression MultiplicativeExpression_234_Var
		 = (MultiplicativeExpression)Expr_233_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = MultiplicativeExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final CastExpression CastExpression_235_Var
		 = (CastExpression)Expr_234_list.get(0);
		Assert.assertNotNull(CastExpression_235_Var
		);
		//235
		final UnaryExpression UnaryExpression_236_Var
		 = (UnaryExpression)CastExpression_235_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_236_Var
		);
		//236
		final PostfixExpression PostfixExpression_237_Var
		 = (PostfixExpression)UnaryExpression_236_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = PostfixExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final PrimaryExpression PrimaryExpression_238_Var
		 = (PrimaryExpression)Expr_237_list.get(0);
		Assert.assertNotNull(PrimaryExpression_238_Var
		);
		Assert.assertEquals("bar", PrimaryExpression_238_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_186_Var
		.getSemi());
		//238
		final Statement Statement_239_Var
		 = (Statement)Statement_66_list.get(2);
		Assert.assertNotNull(Statement_239_Var
		);
		//239
		final JumpStatement JumpStatement_240_Var
		 = (JumpStatement)Statement_239_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_240_Var
		);
		//240
		final Expression Expression_241_Var
		 = (Expression)JumpStatement_240_Var
		.getExpr();
		Assert.assertNotNull(Expression_241_Var
		);
		final EList<? extends EObject> ExprExpr_241_list = Expression_241_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_241_list);
		Assert.assertEquals(1, ExprExpr_241_list.size());
		//241
		final AssignmentExpression AssignmentExpression_242_Var
		 = (AssignmentExpression)ExprExpr_241_list.get(0);
		Assert.assertNotNull(AssignmentExpression_242_Var
		);
		//242
		final ConditionalExpression ConditionalExpression_243_Var
		 = (ConditionalExpression)AssignmentExpression_242_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_243_Var
		);
		//243
		final LogicalOrExpression LogicalOrExpression_244_Var
		 = (LogicalOrExpression)ConditionalExpression_243_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = LogicalOrExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final LogicalAndExpression LogicalAndExpression_245_Var
		 = (LogicalAndExpression)Expr_244_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = LogicalAndExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final InclusiveOrExpression InclusiveOrExpression_246_Var
		 = (InclusiveOrExpression)Expr_245_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = InclusiveOrExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final ExclusiveOrExpression ExclusiveOrExpression_247_Var
		 = (ExclusiveOrExpression)Expr_246_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = ExclusiveOrExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final AndExpression AndExpression_248_Var
		 = (AndExpression)Expr_247_list.get(0);
		Assert.assertNotNull(AndExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = AndExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final EqualityExpression EqualityExpression_249_Var
		 = (EqualityExpression)Expr_248_list.get(0);
		Assert.assertNotNull(EqualityExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = EqualityExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final RelationalExpression RelationalExpression_250_Var
		 = (RelationalExpression)Expr_249_list.get(0);
		Assert.assertNotNull(RelationalExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = RelationalExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final ShiftExpression ShiftExpression_251_Var
		 = (ShiftExpression)Expr_250_list.get(0);
		Assert.assertNotNull(ShiftExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = ShiftExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final AdditiveExpression AdditiveExpression_252_Var
		 = (AdditiveExpression)Expr_251_list.get(0);
		Assert.assertNotNull(AdditiveExpression_252_Var
		);
		final EList<? extends EObject> Expr_252_list = AdditiveExpression_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(1, Expr_252_list.size());
		//252
		final MultiplicativeExpression MultiplicativeExpression_253_Var
		 = (MultiplicativeExpression)Expr_252_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = MultiplicativeExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final CastExpression CastExpression_254_Var
		 = (CastExpression)Expr_253_list.get(0);
		Assert.assertNotNull(CastExpression_254_Var
		);
		//254
		final UnaryExpression UnaryExpression_255_Var
		 = (UnaryExpression)CastExpression_254_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_255_Var
		);
		//255
		final PostfixExpression PostfixExpression_256_Var
		 = (PostfixExpression)UnaryExpression_255_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_256_Var
		);
		final EList<? extends EObject> Expr_256_list = PostfixExpression_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(1, Expr_256_list.size());
		//256
		final PrimaryExpression PrimaryExpression_257_Var
		 = (PrimaryExpression)Expr_256_list.get(0);
		Assert.assertNotNull(PrimaryExpression_257_Var
		);
		//257
		final Constant2 Constant2_258_Var
		 = (Constant2)PrimaryExpression_257_Var
		.getConst();
		Assert.assertNotNull(Constant2_258_Var
		);
		Assert.assertEquals("0", Constant2_258_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_240_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_240_Var
		.getSemi());
	}
	
	@Test
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


