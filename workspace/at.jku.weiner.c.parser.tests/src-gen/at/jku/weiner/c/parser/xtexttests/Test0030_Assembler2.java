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

import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.common.common.TranslationUnit;
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
	private ParseHelper<Model> parseHelper;
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
		final Model Model_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(Model_0_Var
		);
		
		Assert.assertNotNull(Model_0_Var
		);
		final EList<? extends EObject> Units_0_list = Model_0_Var
		.getUnits();
		Assert.assertNotNull(Units_0_list);
		Assert.assertEquals(1, Units_0_list.size());
		//0
		final TranslationUnit TranslationUnit_1_Var
		 = (TranslationUnit)Units_0_list.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var
		);
		//1
		final Parser Parser_2_Var
		 = (Parser)TranslationUnit_1_Var
		.getParser();
		Assert.assertNotNull(Parser_2_Var
		);
		final EList<? extends EObject> External_2_list = Parser_2_Var
		.getExternal();
		Assert.assertNotNull(External_2_list);
		Assert.assertEquals(1, External_2_list.size());
		//2
		final ExternalDeclaration ExternalDeclaration_3_Var
		 = (ExternalDeclaration)External_2_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_3_Var
		);
		//3
		final FunctionDefHead FunctionDefHead_4_Var
		 = (FunctionDefHead)ExternalDeclaration_3_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_4_Var
		);
		//4
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_5_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_4_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_5_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_5_list = FunctionDeclarationSpecifiers_5_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_5_list);
		Assert.assertEquals(1, DeclarationSpecifier_5_list.size());
		//5
		final TypeSpecifier TypeSpecifier_6_Var
		 = (TypeSpecifier)DeclarationSpecifier_5_list.get(0);
		Assert.assertNotNull(TypeSpecifier_6_Var
		);
		Assert.assertEquals("int", TypeSpecifier_6_Var
		.getName());
		//6
		final Declarator Declarator_7_Var
		 = (Declarator)FunctionDefHead_4_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_7_Var
		);
		//7
		final DirectDeclarator DirectDeclarator_8_Var
		 = (DirectDeclarator)Declarator_7_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_8_Var
		);
		Assert.assertEquals("main", DirectDeclarator_8_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_8_list = DirectDeclarator_8_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_8_list);
		Assert.assertEquals(1, DeclaratorSuffix_8_list.size());
		//8
		final DeclaratorSuffix DeclaratorSuffix_9_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_8_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_9_Var
		);
		//9
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_10_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_9_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_10_Var
		);
		final EList<? extends EObject> ParameterTypeList_10_list = DirectDeclaratorLastSuffix_10_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_10_list);
		Assert.assertEquals(1, ParameterTypeList_10_list.size());
		//10
		final ParameterTypeList ParameterTypeList_11_Var
		 = (ParameterTypeList)ParameterTypeList_10_list.get(0);
		Assert.assertNotNull(ParameterTypeList_11_Var
		);
		//11
		final ParameterList ParameterList_12_Var
		 = (ParameterList)ParameterTypeList_11_Var
		.getList();
		Assert.assertNotNull(ParameterList_12_Var
		);
		final EList<? extends EObject> ParameterDeclaration_12_list = ParameterList_12_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_12_list);
		Assert.assertEquals(1, ParameterDeclaration_12_list.size());
		//12
		final ParameterDeclaration ParameterDeclaration_13_Var
		 = (ParameterDeclaration)ParameterDeclaration_12_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_13_Var
		);
		//13
		final DeclarationSpecifiers DeclarationSpecifiers_14_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_13_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_14_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_14_list = DeclarationSpecifiers_14_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_14_list);
		Assert.assertEquals(1, DeclarationSpecifier_14_list.size());
		//14
		final TypeSpecifier TypeSpecifier_15_Var
		 = (TypeSpecifier)DeclarationSpecifier_14_list.get(0);
		Assert.assertNotNull(TypeSpecifier_15_Var
		);
		Assert.assertEquals("void", TypeSpecifier_15_Var
		.getName());
		//15
		final FunctionDefinition FunctionDefinition_16_Var
		 = (FunctionDefinition)ExternalDeclaration_3_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_16_Var
		);
		//16
		final BodyStatement BodyStatement_17_Var
		 = (BodyStatement)FunctionDefinition_16_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_17_Var
		);
		final EList<? extends EObject> BlockList_17_list = BodyStatement_17_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_17_list);
		Assert.assertEquals(1, BlockList_17_list.size());
		//17
		final BlockList BlockList_18_Var
		 = (BlockList)BlockList_17_list.get(0);
		Assert.assertNotNull(BlockList_18_Var
		);
		final EList<? extends EObject> Declaration_18_list = BlockList_18_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_18_list);
		Assert.assertEquals(2, Declaration_18_list.size());
		//18
		final Declaration Declaration_19_Var
		 = (Declaration)Declaration_18_list.get(0);
		Assert.assertNotNull(Declaration_19_Var
		);
		//19
		final DeclarationSpecifiers DeclarationSpecifiers_20_Var
		 = (DeclarationSpecifiers)Declaration_19_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_20_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_20_list = DeclarationSpecifiers_20_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_20_list);
		Assert.assertEquals(1, DeclarationSpecifier_20_list.size());
		//20
		final TypeSpecifier TypeSpecifier_21_Var
		 = (TypeSpecifier)DeclarationSpecifier_20_list.get(0);
		Assert.assertNotNull(TypeSpecifier_21_Var
		);
		Assert.assertEquals("int", TypeSpecifier_21_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_21_list = Declaration_19_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_21_list);
		Assert.assertEquals(1, InitDeclaratorList_21_list.size());
		//21
		final InitDeclaratorList InitDeclaratorList_22_Var
		 = (InitDeclaratorList)InitDeclaratorList_21_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_22_Var
		);
		final EList<? extends EObject> InitDeclarator_22_list = InitDeclaratorList_22_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_22_list);
		Assert.assertEquals(1, InitDeclarator_22_list.size());
		//22
		final InitDeclarator InitDeclarator_23_Var
		 = (InitDeclarator)InitDeclarator_22_list.get(0);
		Assert.assertNotNull(InitDeclarator_23_Var
		);
		//23
		final Declarator Declarator_24_Var
		 = (Declarator)InitDeclarator_23_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_24_Var
		);
		//24
		final DirectDeclarator DirectDeclarator_25_Var
		 = (DirectDeclarator)Declarator_24_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_25_Var
		);
		Assert.assertEquals("foo", DirectDeclarator_25_Var
		.getId());
		//25
		final Initializer Initializer_26_Var
		 = (Initializer)InitDeclarator_23_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_26_Var
		);
		//26
		final AssignmentExpression AssignmentExpression_27_Var
		 = (AssignmentExpression)Initializer_26_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_27_Var
		);
		//27
		final ConditionalExpression ConditionalExpression_28_Var
		 = (ConditionalExpression)AssignmentExpression_27_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_28_Var
		);
		//28
		final LogicalOrExpression LogicalOrExpression_29_Var
		 = (LogicalOrExpression)ConditionalExpression_28_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = LogicalOrExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final LogicalAndExpression LogicalAndExpression_30_Var
		 = (LogicalAndExpression)Expr_29_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = LogicalAndExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final InclusiveOrExpression InclusiveOrExpression_31_Var
		 = (InclusiveOrExpression)Expr_30_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = InclusiveOrExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final ExclusiveOrExpression ExclusiveOrExpression_32_Var
		 = (ExclusiveOrExpression)Expr_31_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = ExclusiveOrExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final AndExpression AndExpression_33_Var
		 = (AndExpression)Expr_32_list.get(0);
		Assert.assertNotNull(AndExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = AndExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final EqualityExpression EqualityExpression_34_Var
		 = (EqualityExpression)Expr_33_list.get(0);
		Assert.assertNotNull(EqualityExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = EqualityExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final RelationalExpression RelationalExpression_35_Var
		 = (RelationalExpression)Expr_34_list.get(0);
		Assert.assertNotNull(RelationalExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = RelationalExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final ShiftExpression ShiftExpression_36_Var
		 = (ShiftExpression)Expr_35_list.get(0);
		Assert.assertNotNull(ShiftExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = ShiftExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final AdditiveExpression AdditiveExpression_37_Var
		 = (AdditiveExpression)Expr_36_list.get(0);
		Assert.assertNotNull(AdditiveExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = AdditiveExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final MultiplicativeExpression MultiplicativeExpression_38_Var
		 = (MultiplicativeExpression)Expr_37_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = MultiplicativeExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final CastExpression CastExpression_39_Var
		 = (CastExpression)Expr_38_list.get(0);
		Assert.assertNotNull(CastExpression_39_Var
		);
		//39
		final UnaryExpression UnaryExpression_40_Var
		 = (UnaryExpression)CastExpression_39_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_40_Var
		);
		//40
		final PostfixExpression PostfixExpression_41_Var
		 = (PostfixExpression)UnaryExpression_40_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = PostfixExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final PrimaryExpression PrimaryExpression_42_Var
		 = (PrimaryExpression)Expr_41_list.get(0);
		Assert.assertNotNull(PrimaryExpression_42_Var
		);
		//42
		final Constant2 Constant2_43_Var
		 = (Constant2)PrimaryExpression_42_Var
		.getConst();
		Assert.assertNotNull(Constant2_43_Var
		);
		Assert.assertEquals("5", Constant2_43_Var
		.getDec());
		Assert.assertEquals(";", Declaration_19_Var
		.getSemi());
		//43
		final Declaration Declaration_44_Var
		 = (Declaration)Declaration_18_list.get(1);
		Assert.assertNotNull(Declaration_44_Var
		);
		//44
		final DeclarationSpecifiers DeclarationSpecifiers_45_Var
		 = (DeclarationSpecifiers)Declaration_44_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_45_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_45_list = DeclarationSpecifiers_45_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_45_list);
		Assert.assertEquals(1, DeclarationSpecifier_45_list.size());
		//45
		final TypeSpecifier TypeSpecifier_46_Var
		 = (TypeSpecifier)DeclarationSpecifier_45_list.get(0);
		Assert.assertNotNull(TypeSpecifier_46_Var
		);
		Assert.assertEquals("int", TypeSpecifier_46_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_46_list = Declaration_44_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_46_list);
		Assert.assertEquals(1, InitDeclaratorList_46_list.size());
		//46
		final InitDeclaratorList InitDeclaratorList_47_Var
		 = (InitDeclaratorList)InitDeclaratorList_46_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_47_Var
		);
		final EList<? extends EObject> InitDeclarator_47_list = InitDeclaratorList_47_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_47_list);
		Assert.assertEquals(1, InitDeclarator_47_list.size());
		//47
		final InitDeclarator InitDeclarator_48_Var
		 = (InitDeclarator)InitDeclarator_47_list.get(0);
		Assert.assertNotNull(InitDeclarator_48_Var
		);
		//48
		final Declarator Declarator_49_Var
		 = (Declarator)InitDeclarator_48_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_49_Var
		);
		//49
		final DirectDeclarator DirectDeclarator_50_Var
		 = (DirectDeclarator)Declarator_49_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_50_Var
		);
		Assert.assertEquals("bar", DirectDeclarator_50_Var
		.getId());
		//50
		final Initializer Initializer_51_Var
		 = (Initializer)InitDeclarator_48_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_51_Var
		);
		//51
		final AssignmentExpression AssignmentExpression_52_Var
		 = (AssignmentExpression)Initializer_51_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_52_Var
		);
		//52
		final ConditionalExpression ConditionalExpression_53_Var
		 = (ConditionalExpression)AssignmentExpression_52_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_53_Var
		);
		//53
		final LogicalOrExpression LogicalOrExpression_54_Var
		 = (LogicalOrExpression)ConditionalExpression_53_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = LogicalOrExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final LogicalAndExpression LogicalAndExpression_55_Var
		 = (LogicalAndExpression)Expr_54_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = LogicalAndExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final InclusiveOrExpression InclusiveOrExpression_56_Var
		 = (InclusiveOrExpression)Expr_55_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = InclusiveOrExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final ExclusiveOrExpression ExclusiveOrExpression_57_Var
		 = (ExclusiveOrExpression)Expr_56_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = ExclusiveOrExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final AndExpression AndExpression_58_Var
		 = (AndExpression)Expr_57_list.get(0);
		Assert.assertNotNull(AndExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = AndExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final EqualityExpression EqualityExpression_59_Var
		 = (EqualityExpression)Expr_58_list.get(0);
		Assert.assertNotNull(EqualityExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = EqualityExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final RelationalExpression RelationalExpression_60_Var
		 = (RelationalExpression)Expr_59_list.get(0);
		Assert.assertNotNull(RelationalExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = RelationalExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final ShiftExpression ShiftExpression_61_Var
		 = (ShiftExpression)Expr_60_list.get(0);
		Assert.assertNotNull(ShiftExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = ShiftExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final AdditiveExpression AdditiveExpression_62_Var
		 = (AdditiveExpression)Expr_61_list.get(0);
		Assert.assertNotNull(AdditiveExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = AdditiveExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final MultiplicativeExpression MultiplicativeExpression_63_Var
		 = (MultiplicativeExpression)Expr_62_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = MultiplicativeExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final CastExpression CastExpression_64_Var
		 = (CastExpression)Expr_63_list.get(0);
		Assert.assertNotNull(CastExpression_64_Var
		);
		//64
		final UnaryExpression UnaryExpression_65_Var
		 = (UnaryExpression)CastExpression_64_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_65_Var
		);
		//65
		final PostfixExpression PostfixExpression_66_Var
		 = (PostfixExpression)UnaryExpression_65_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = PostfixExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final PrimaryExpression PrimaryExpression_67_Var
		 = (PrimaryExpression)Expr_66_list.get(0);
		Assert.assertNotNull(PrimaryExpression_67_Var
		);
		//67
		final Constant2 Constant2_68_Var
		 = (Constant2)PrimaryExpression_67_Var
		.getConst();
		Assert.assertNotNull(Constant2_68_Var
		);
		Assert.assertEquals("4", Constant2_68_Var
		.getDec());
		Assert.assertEquals(";", Declaration_44_Var
		.getSemi());
		final EList<? extends EObject> Statement_68_list = BlockList_18_Var
		.getStatement();
		Assert.assertNotNull(Statement_68_list);
		Assert.assertEquals(3, Statement_68_list.size());
		//68
		final Statement Statement_69_Var
		 = (Statement)Statement_68_list.get(0);
		Assert.assertNotNull(Statement_69_Var
		);
		//69
		final AsmStatement AsmStatement_70_Var
		 = (AsmStatement)Statement_69_Var
		.getStmt();
		Assert.assertNotNull(AsmStatement_70_Var
		);
		final EList<? extends EObject> AsmLine_70_list = AsmStatement_70_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLine_70_list);
		Assert.assertEquals(5, AsmLine_70_list.size());
		//70
		final AsmLineWithColon AsmLineWithColon_71_Var
		 = (AsmLineWithColon)AsmLine_70_list.get(0);
		Assert.assertNotNull(AsmLineWithColon_71_Var
		);
		//71
		final LogicalOrExpression LogicalOrExpression_72_Var
		 = (LogicalOrExpression)AsmLineWithColon_71_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = LogicalOrExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final LogicalAndExpression LogicalAndExpression_73_Var
		 = (LogicalAndExpression)Expr_72_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = LogicalAndExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final InclusiveOrExpression InclusiveOrExpression_74_Var
		 = (InclusiveOrExpression)Expr_73_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = InclusiveOrExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final ExclusiveOrExpression ExclusiveOrExpression_75_Var
		 = (ExclusiveOrExpression)Expr_74_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = ExclusiveOrExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final AndExpression AndExpression_76_Var
		 = (AndExpression)Expr_75_list.get(0);
		Assert.assertNotNull(AndExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = AndExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final EqualityExpression EqualityExpression_77_Var
		 = (EqualityExpression)Expr_76_list.get(0);
		Assert.assertNotNull(EqualityExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = EqualityExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final RelationalExpression RelationalExpression_78_Var
		 = (RelationalExpression)Expr_77_list.get(0);
		Assert.assertNotNull(RelationalExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = RelationalExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final ShiftExpression ShiftExpression_79_Var
		 = (ShiftExpression)Expr_78_list.get(0);
		Assert.assertNotNull(ShiftExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = ShiftExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final AdditiveExpression AdditiveExpression_80_Var
		 = (AdditiveExpression)Expr_79_list.get(0);
		Assert.assertNotNull(AdditiveExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = AdditiveExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final MultiplicativeExpression MultiplicativeExpression_81_Var
		 = (MultiplicativeExpression)Expr_80_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = MultiplicativeExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final CastExpression CastExpression_82_Var
		 = (CastExpression)Expr_81_list.get(0);
		Assert.assertNotNull(CastExpression_82_Var
		);
		//82
		final UnaryExpression UnaryExpression_83_Var
		 = (UnaryExpression)CastExpression_82_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_83_Var
		);
		//83
		final PostfixExpression PostfixExpression_84_Var
		 = (PostfixExpression)UnaryExpression_83_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = PostfixExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final PrimaryExpression PrimaryExpression_85_Var
		 = (PrimaryExpression)Expr_84_list.get(0);
		Assert.assertNotNull(PrimaryExpression_85_Var
		);
		//85
		final Constant2 Constant2_86_Var
		 = (Constant2)PrimaryExpression_85_Var
		.getConst();
		Assert.assertNotNull(Constant2_86_Var
		);
		Assert.assertEquals("\"add %1, %0\\n\\t\"", Constant2_86_Var
		.getStr());
		//86
		final AsmLineWithColon AsmLineWithColon_87_Var
		 = (AsmLineWithColon)AsmLine_70_list.get(1);
		Assert.assertNotNull(AsmLineWithColon_87_Var
		);
		//87
		final LogicalOrExpression LogicalOrExpression_88_Var
		 = (LogicalOrExpression)AsmLineWithColon_87_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = LogicalOrExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final LogicalAndExpression LogicalAndExpression_89_Var
		 = (LogicalAndExpression)Expr_88_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = LogicalAndExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final InclusiveOrExpression InclusiveOrExpression_90_Var
		 = (InclusiveOrExpression)Expr_89_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = InclusiveOrExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final ExclusiveOrExpression ExclusiveOrExpression_91_Var
		 = (ExclusiveOrExpression)Expr_90_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = ExclusiveOrExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final AndExpression AndExpression_92_Var
		 = (AndExpression)Expr_91_list.get(0);
		Assert.assertNotNull(AndExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = AndExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final EqualityExpression EqualityExpression_93_Var
		 = (EqualityExpression)Expr_92_list.get(0);
		Assert.assertNotNull(EqualityExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = EqualityExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final RelationalExpression RelationalExpression_94_Var
		 = (RelationalExpression)Expr_93_list.get(0);
		Assert.assertNotNull(RelationalExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = RelationalExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final ShiftExpression ShiftExpression_95_Var
		 = (ShiftExpression)Expr_94_list.get(0);
		Assert.assertNotNull(ShiftExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = ShiftExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final AdditiveExpression AdditiveExpression_96_Var
		 = (AdditiveExpression)Expr_95_list.get(0);
		Assert.assertNotNull(AdditiveExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = AdditiveExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final MultiplicativeExpression MultiplicativeExpression_97_Var
		 = (MultiplicativeExpression)Expr_96_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = MultiplicativeExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final CastExpression CastExpression_98_Var
		 = (CastExpression)Expr_97_list.get(0);
		Assert.assertNotNull(CastExpression_98_Var
		);
		//98
		final UnaryExpression UnaryExpression_99_Var
		 = (UnaryExpression)CastExpression_98_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_99_Var
		);
		//99
		final PostfixExpression PostfixExpression_100_Var
		 = (PostfixExpression)UnaryExpression_99_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = PostfixExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final PrimaryExpression PrimaryExpression_101_Var
		 = (PrimaryExpression)Expr_100_list.get(0);
		Assert.assertNotNull(PrimaryExpression_101_Var
		);
		//101
		final Constant2 Constant2_102_Var
		 = (Constant2)PrimaryExpression_101_Var
		.getConst();
		Assert.assertNotNull(Constant2_102_Var
		);
		Assert.assertEquals("\"inc %0\"", Constant2_102_Var
		.getStr());
		//102
		final AsmLineWithColon AsmLineWithColon_103_Var
		 = (AsmLineWithColon)AsmLine_70_list.get(2);
		Assert.assertNotNull(AsmLineWithColon_103_Var
		);
		//103
		final LogicalOrExpression LogicalOrExpression_104_Var
		 = (LogicalOrExpression)AsmLineWithColon_103_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = LogicalOrExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final LogicalAndExpression LogicalAndExpression_105_Var
		 = (LogicalAndExpression)Expr_104_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = LogicalAndExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final InclusiveOrExpression InclusiveOrExpression_106_Var
		 = (InclusiveOrExpression)Expr_105_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = InclusiveOrExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final ExclusiveOrExpression ExclusiveOrExpression_107_Var
		 = (ExclusiveOrExpression)Expr_106_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = ExclusiveOrExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final AndExpression AndExpression_108_Var
		 = (AndExpression)Expr_107_list.get(0);
		Assert.assertNotNull(AndExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = AndExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final EqualityExpression EqualityExpression_109_Var
		 = (EqualityExpression)Expr_108_list.get(0);
		Assert.assertNotNull(EqualityExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = EqualityExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final RelationalExpression RelationalExpression_110_Var
		 = (RelationalExpression)Expr_109_list.get(0);
		Assert.assertNotNull(RelationalExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = RelationalExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final ShiftExpression ShiftExpression_111_Var
		 = (ShiftExpression)Expr_110_list.get(0);
		Assert.assertNotNull(ShiftExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = ShiftExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final AdditiveExpression AdditiveExpression_112_Var
		 = (AdditiveExpression)Expr_111_list.get(0);
		Assert.assertNotNull(AdditiveExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = AdditiveExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final MultiplicativeExpression MultiplicativeExpression_113_Var
		 = (MultiplicativeExpression)Expr_112_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = MultiplicativeExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final CastExpression CastExpression_114_Var
		 = (CastExpression)Expr_113_list.get(0);
		Assert.assertNotNull(CastExpression_114_Var
		);
		//114
		final UnaryExpression UnaryExpression_115_Var
		 = (UnaryExpression)CastExpression_114_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_115_Var
		);
		//115
		final PostfixExpression PostfixExpression_116_Var
		 = (PostfixExpression)UnaryExpression_115_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = PostfixExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final PrimaryExpression PrimaryExpression_117_Var
		 = (PrimaryExpression)Expr_116_list.get(0);
		Assert.assertNotNull(PrimaryExpression_117_Var
		);
		//117
		final Constant2 Constant2_118_Var
		 = (Constant2)PrimaryExpression_117_Var
		.getConst();
		Assert.assertNotNull(Constant2_118_Var
		);
		Assert.assertEquals("\"+r\"", Constant2_118_Var
		.getStr());
		final EList<? extends EObject> Suffix_118_list = PostfixExpression_116_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_118_list);
		Assert.assertEquals(1, Suffix_118_list.size());
		//118
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_119_Var
		 = (PostfixExpressionSuffixArgument)Suffix_118_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_119_Var
		);
		//119
		final ArgumentExpressionList ArgumentExpressionList_120_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_119_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_120_Var
		);
		final EList<? extends EObject> Expr_120_list = ArgumentExpressionList_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final AssignmentExpression AssignmentExpression_121_Var
		 = (AssignmentExpression)Expr_120_list.get(0);
		Assert.assertNotNull(AssignmentExpression_121_Var
		);
		//121
		final ConditionalExpression ConditionalExpression_122_Var
		 = (ConditionalExpression)AssignmentExpression_121_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_122_Var
		);
		//122
		final LogicalOrExpression LogicalOrExpression_123_Var
		 = (LogicalOrExpression)ConditionalExpression_122_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = LogicalOrExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final LogicalAndExpression LogicalAndExpression_124_Var
		 = (LogicalAndExpression)Expr_123_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = LogicalAndExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final InclusiveOrExpression InclusiveOrExpression_125_Var
		 = (InclusiveOrExpression)Expr_124_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = InclusiveOrExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final ExclusiveOrExpression ExclusiveOrExpression_126_Var
		 = (ExclusiveOrExpression)Expr_125_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = ExclusiveOrExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final AndExpression AndExpression_127_Var
		 = (AndExpression)Expr_126_list.get(0);
		Assert.assertNotNull(AndExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = AndExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final EqualityExpression EqualityExpression_128_Var
		 = (EqualityExpression)Expr_127_list.get(0);
		Assert.assertNotNull(EqualityExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = EqualityExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final RelationalExpression RelationalExpression_129_Var
		 = (RelationalExpression)Expr_128_list.get(0);
		Assert.assertNotNull(RelationalExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = RelationalExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final ShiftExpression ShiftExpression_130_Var
		 = (ShiftExpression)Expr_129_list.get(0);
		Assert.assertNotNull(ShiftExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = ShiftExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final AdditiveExpression AdditiveExpression_131_Var
		 = (AdditiveExpression)Expr_130_list.get(0);
		Assert.assertNotNull(AdditiveExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = AdditiveExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final MultiplicativeExpression MultiplicativeExpression_132_Var
		 = (MultiplicativeExpression)Expr_131_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = MultiplicativeExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final CastExpression CastExpression_133_Var
		 = (CastExpression)Expr_132_list.get(0);
		Assert.assertNotNull(CastExpression_133_Var
		);
		//133
		final UnaryExpression UnaryExpression_134_Var
		 = (UnaryExpression)CastExpression_133_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_134_Var
		);
		//134
		final PostfixExpression PostfixExpression_135_Var
		 = (PostfixExpression)UnaryExpression_134_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = PostfixExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final PrimaryExpression PrimaryExpression_136_Var
		 = (PrimaryExpression)Expr_135_list.get(0);
		Assert.assertNotNull(PrimaryExpression_136_Var
		);
		Assert.assertEquals("bar", PrimaryExpression_136_Var
		.getId());
		//136
		final AsmLine AsmLine_137_Var
		 = (AsmLine)AsmLine_70_list.get(3);
		Assert.assertNotNull(AsmLine_137_Var
		);
		//137
		final LogicalOrExpression LogicalOrExpression_138_Var
		 = (LogicalOrExpression)AsmLine_137_Var
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
		 = (AsmLineWithColon)AsmLine_70_list.get(4);
		Assert.assertNotNull(AsmLineWithColon_171_Var
		);
		//171
		final LogicalOrExpression LogicalOrExpression_172_Var
		 = (LogicalOrExpression)AsmLineWithColon_171_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = LogicalOrExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final LogicalAndExpression LogicalAndExpression_173_Var
		 = (LogicalAndExpression)Expr_172_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = LogicalAndExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final InclusiveOrExpression InclusiveOrExpression_174_Var
		 = (InclusiveOrExpression)Expr_173_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = InclusiveOrExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final ExclusiveOrExpression ExclusiveOrExpression_175_Var
		 = (ExclusiveOrExpression)Expr_174_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = ExclusiveOrExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final AndExpression AndExpression_176_Var
		 = (AndExpression)Expr_175_list.get(0);
		Assert.assertNotNull(AndExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = AndExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final EqualityExpression EqualityExpression_177_Var
		 = (EqualityExpression)Expr_176_list.get(0);
		Assert.assertNotNull(EqualityExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = EqualityExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final RelationalExpression RelationalExpression_178_Var
		 = (RelationalExpression)Expr_177_list.get(0);
		Assert.assertNotNull(RelationalExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = RelationalExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final ShiftExpression ShiftExpression_179_Var
		 = (ShiftExpression)Expr_178_list.get(0);
		Assert.assertNotNull(ShiftExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = ShiftExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final AdditiveExpression AdditiveExpression_180_Var
		 = (AdditiveExpression)Expr_179_list.get(0);
		Assert.assertNotNull(AdditiveExpression_180_Var
		);
		final EList<? extends EObject> Expr_180_list = AdditiveExpression_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final MultiplicativeExpression MultiplicativeExpression_181_Var
		 = (MultiplicativeExpression)Expr_180_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_181_Var
		);
		final EList<? extends EObject> Expr_181_list = MultiplicativeExpression_181_Var
		.getExpr();
		Assert.assertNotNull(Expr_181_list);
		Assert.assertEquals(1, Expr_181_list.size());
		//181
		final CastExpression CastExpression_182_Var
		 = (CastExpression)Expr_181_list.get(0);
		Assert.assertNotNull(CastExpression_182_Var
		);
		//182
		final UnaryExpression UnaryExpression_183_Var
		 = (UnaryExpression)CastExpression_182_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_183_Var
		);
		//183
		final PostfixExpression PostfixExpression_184_Var
		 = (PostfixExpression)UnaryExpression_183_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = PostfixExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final PrimaryExpression PrimaryExpression_185_Var
		 = (PrimaryExpression)Expr_184_list.get(0);
		Assert.assertNotNull(PrimaryExpression_185_Var
		);
		//185
		final Constant2 Constant2_186_Var
		 = (Constant2)PrimaryExpression_185_Var
		.getConst();
		Assert.assertNotNull(Constant2_186_Var
		);
		Assert.assertEquals("\"cc\"", Constant2_186_Var
		.getStr());
		//186
		final Statement Statement_187_Var
		 = (Statement)Statement_68_list.get(1);
		Assert.assertNotNull(Statement_187_Var
		);
		//187
		final ExpressionStatement ExpressionStatement_188_Var
		 = (ExpressionStatement)Statement_187_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_188_Var
		);
		//188
		final Expression Expression_189_Var
		 = (Expression)ExpressionStatement_188_Var
		.getExpression();
		Assert.assertNotNull(Expression_189_Var
		);
		final EList<? extends EObject> ExprExpr_189_list = Expression_189_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_189_list);
		Assert.assertEquals(1, ExprExpr_189_list.size());
		//189
		final AssignmentExpression AssignmentExpression_190_Var
		 = (AssignmentExpression)ExprExpr_189_list.get(0);
		Assert.assertNotNull(AssignmentExpression_190_Var
		);
		//190
		final ConditionalExpression ConditionalExpression_191_Var
		 = (ConditionalExpression)AssignmentExpression_190_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_191_Var
		);
		//191
		final LogicalOrExpression LogicalOrExpression_192_Var
		 = (LogicalOrExpression)ConditionalExpression_191_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = LogicalOrExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final LogicalAndExpression LogicalAndExpression_193_Var
		 = (LogicalAndExpression)Expr_192_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = LogicalAndExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final InclusiveOrExpression InclusiveOrExpression_194_Var
		 = (InclusiveOrExpression)Expr_193_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = InclusiveOrExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final ExclusiveOrExpression ExclusiveOrExpression_195_Var
		 = (ExclusiveOrExpression)Expr_194_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = ExclusiveOrExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final AndExpression AndExpression_196_Var
		 = (AndExpression)Expr_195_list.get(0);
		Assert.assertNotNull(AndExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = AndExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final EqualityExpression EqualityExpression_197_Var
		 = (EqualityExpression)Expr_196_list.get(0);
		Assert.assertNotNull(EqualityExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = EqualityExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final RelationalExpression RelationalExpression_198_Var
		 = (RelationalExpression)Expr_197_list.get(0);
		Assert.assertNotNull(RelationalExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = RelationalExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final ShiftExpression ShiftExpression_199_Var
		 = (ShiftExpression)Expr_198_list.get(0);
		Assert.assertNotNull(ShiftExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = ShiftExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final AdditiveExpression AdditiveExpression_200_Var
		 = (AdditiveExpression)Expr_199_list.get(0);
		Assert.assertNotNull(AdditiveExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = AdditiveExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final MultiplicativeExpression MultiplicativeExpression_201_Var
		 = (MultiplicativeExpression)Expr_200_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = MultiplicativeExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final CastExpression CastExpression_202_Var
		 = (CastExpression)Expr_201_list.get(0);
		Assert.assertNotNull(CastExpression_202_Var
		);
		//202
		final UnaryExpression UnaryExpression_203_Var
		 = (UnaryExpression)CastExpression_202_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_203_Var
		);
		//203
		final PostfixExpression PostfixExpression_204_Var
		 = (PostfixExpression)UnaryExpression_203_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = PostfixExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final PrimaryExpression PrimaryExpression_205_Var
		 = (PrimaryExpression)Expr_204_list.get(0);
		Assert.assertNotNull(PrimaryExpression_205_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_205_Var
		.getId());
		final EList<? extends EObject> Suffix_205_list = PostfixExpression_204_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_205_list);
		Assert.assertEquals(1, Suffix_205_list.size());
		//205
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_206_Var
		 = (PostfixExpressionSuffixArgument)Suffix_205_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_206_Var
		);
		//206
		final ArgumentExpressionList ArgumentExpressionList_207_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_206_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_207_Var
		);
		final EList<? extends EObject> Expr_207_list = ArgumentExpressionList_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(2, Expr_207_list.size());
		//207
		final AssignmentExpression AssignmentExpression_208_Var
		 = (AssignmentExpression)Expr_207_list.get(0);
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
		//223
		final Constant2 Constant2_224_Var
		 = (Constant2)PrimaryExpression_223_Var
		.getConst();
		Assert.assertNotNull(Constant2_224_Var
		);
		Assert.assertEquals("\"Ergebnis: %i\\n\"", Constant2_224_Var
		.getStr());
		//224
		final AssignmentExpression AssignmentExpression_225_Var
		 = (AssignmentExpression)Expr_207_list.get(1);
		Assert.assertNotNull(AssignmentExpression_225_Var
		);
		//225
		final ConditionalExpression ConditionalExpression_226_Var
		 = (ConditionalExpression)AssignmentExpression_225_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_226_Var
		);
		//226
		final LogicalOrExpression LogicalOrExpression_227_Var
		 = (LogicalOrExpression)ConditionalExpression_226_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = LogicalOrExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final LogicalAndExpression LogicalAndExpression_228_Var
		 = (LogicalAndExpression)Expr_227_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = LogicalAndExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final InclusiveOrExpression InclusiveOrExpression_229_Var
		 = (InclusiveOrExpression)Expr_228_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = InclusiveOrExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final ExclusiveOrExpression ExclusiveOrExpression_230_Var
		 = (ExclusiveOrExpression)Expr_229_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = ExclusiveOrExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final AndExpression AndExpression_231_Var
		 = (AndExpression)Expr_230_list.get(0);
		Assert.assertNotNull(AndExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = AndExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final EqualityExpression EqualityExpression_232_Var
		 = (EqualityExpression)Expr_231_list.get(0);
		Assert.assertNotNull(EqualityExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = EqualityExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final RelationalExpression RelationalExpression_233_Var
		 = (RelationalExpression)Expr_232_list.get(0);
		Assert.assertNotNull(RelationalExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = RelationalExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final ShiftExpression ShiftExpression_234_Var
		 = (ShiftExpression)Expr_233_list.get(0);
		Assert.assertNotNull(ShiftExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = ShiftExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final AdditiveExpression AdditiveExpression_235_Var
		 = (AdditiveExpression)Expr_234_list.get(0);
		Assert.assertNotNull(AdditiveExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = AdditiveExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final MultiplicativeExpression MultiplicativeExpression_236_Var
		 = (MultiplicativeExpression)Expr_235_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = MultiplicativeExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final CastExpression CastExpression_237_Var
		 = (CastExpression)Expr_236_list.get(0);
		Assert.assertNotNull(CastExpression_237_Var
		);
		//237
		final UnaryExpression UnaryExpression_238_Var
		 = (UnaryExpression)CastExpression_237_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_238_Var
		);
		//238
		final PostfixExpression PostfixExpression_239_Var
		 = (PostfixExpression)UnaryExpression_238_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = PostfixExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final PrimaryExpression PrimaryExpression_240_Var
		 = (PrimaryExpression)Expr_239_list.get(0);
		Assert.assertNotNull(PrimaryExpression_240_Var
		);
		Assert.assertEquals("bar", PrimaryExpression_240_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_188_Var
		.getSemi());
		//240
		final Statement Statement_241_Var
		 = (Statement)Statement_68_list.get(2);
		Assert.assertNotNull(Statement_241_Var
		);
		//241
		final JumpStatement JumpStatement_242_Var
		 = (JumpStatement)Statement_241_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_242_Var
		);
		//242
		final Expression Expression_243_Var
		 = (Expression)JumpStatement_242_Var
		.getExpr();
		Assert.assertNotNull(Expression_243_Var
		);
		final EList<? extends EObject> ExprExpr_243_list = Expression_243_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_243_list);
		Assert.assertEquals(1, ExprExpr_243_list.size());
		//243
		final AssignmentExpression AssignmentExpression_244_Var
		 = (AssignmentExpression)ExprExpr_243_list.get(0);
		Assert.assertNotNull(AssignmentExpression_244_Var
		);
		//244
		final ConditionalExpression ConditionalExpression_245_Var
		 = (ConditionalExpression)AssignmentExpression_244_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_245_Var
		);
		//245
		final LogicalOrExpression LogicalOrExpression_246_Var
		 = (LogicalOrExpression)ConditionalExpression_245_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = LogicalOrExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final LogicalAndExpression LogicalAndExpression_247_Var
		 = (LogicalAndExpression)Expr_246_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = LogicalAndExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final InclusiveOrExpression InclusiveOrExpression_248_Var
		 = (InclusiveOrExpression)Expr_247_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = InclusiveOrExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final ExclusiveOrExpression ExclusiveOrExpression_249_Var
		 = (ExclusiveOrExpression)Expr_248_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = ExclusiveOrExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final AndExpression AndExpression_250_Var
		 = (AndExpression)Expr_249_list.get(0);
		Assert.assertNotNull(AndExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = AndExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final EqualityExpression EqualityExpression_251_Var
		 = (EqualityExpression)Expr_250_list.get(0);
		Assert.assertNotNull(EqualityExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = EqualityExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final RelationalExpression RelationalExpression_252_Var
		 = (RelationalExpression)Expr_251_list.get(0);
		Assert.assertNotNull(RelationalExpression_252_Var
		);
		final EList<? extends EObject> Expr_252_list = RelationalExpression_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(1, Expr_252_list.size());
		//252
		final ShiftExpression ShiftExpression_253_Var
		 = (ShiftExpression)Expr_252_list.get(0);
		Assert.assertNotNull(ShiftExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = ShiftExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final AdditiveExpression AdditiveExpression_254_Var
		 = (AdditiveExpression)Expr_253_list.get(0);
		Assert.assertNotNull(AdditiveExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = AdditiveExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final MultiplicativeExpression MultiplicativeExpression_255_Var
		 = (MultiplicativeExpression)Expr_254_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_255_Var
		);
		final EList<? extends EObject> Expr_255_list = MultiplicativeExpression_255_Var
		.getExpr();
		Assert.assertNotNull(Expr_255_list);
		Assert.assertEquals(1, Expr_255_list.size());
		//255
		final CastExpression CastExpression_256_Var
		 = (CastExpression)Expr_255_list.get(0);
		Assert.assertNotNull(CastExpression_256_Var
		);
		//256
		final UnaryExpression UnaryExpression_257_Var
		 = (UnaryExpression)CastExpression_256_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_257_Var
		);
		//257
		final PostfixExpression PostfixExpression_258_Var
		 = (PostfixExpression)UnaryExpression_257_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_258_Var
		);
		final EList<? extends EObject> Expr_258_list = PostfixExpression_258_Var
		.getExpr();
		Assert.assertNotNull(Expr_258_list);
		Assert.assertEquals(1, Expr_258_list.size());
		//258
		final PrimaryExpression PrimaryExpression_259_Var
		 = (PrimaryExpression)Expr_258_list.get(0);
		Assert.assertNotNull(PrimaryExpression_259_Var
		);
		//259
		final Constant2 Constant2_260_Var
		 = (Constant2)PrimaryExpression_259_Var
		.getConst();
		Assert.assertNotNull(Constant2_260_Var
		);
		Assert.assertEquals("0", Constant2_260_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_242_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_242_Var
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


