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
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
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
		final AsmLine AsmLine_69_Var
		 = (AsmLine)AsmStatement_68_Var
		.getAsmLine1();
		Assert.assertNotNull(AsmLine_69_Var
		);
		//69
		final LogicalOrExpression LogicalOrExpression_70_Var
		 = (LogicalOrExpression)AsmLine_69_Var
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
		Assert.assertEquals("[\"add %1, %0\\n\\t\", \"inc %0\"]", PrimaryExpression_83_Var
		.getString().toString());
		final EList<? extends EObject> AsmLines_83_list = AsmStatement_68_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_83_list);
		Assert.assertEquals(4, AsmLines_83_list.size());
		//83
		final AsmLineWithColon AsmLineWithColon_84_Var
		 = (AsmLineWithColon)AsmLines_83_list.get(0);
		Assert.assertNotNull(AsmLineWithColon_84_Var
		);
		//84
		final AsmLineWithoutColon AsmLineWithoutColon_85_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_84_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_85_Var
		);
		final EList<? extends EObject> AsmLines_85_list = AsmLineWithoutColon_85_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_85_list);
		Assert.assertEquals(1, AsmLines_85_list.size());
		//85
		final AsmLine AsmLine_86_Var
		 = (AsmLine)AsmLines_85_list.get(0);
		Assert.assertNotNull(AsmLine_86_Var
		);
		//86
		final LogicalOrExpression LogicalOrExpression_87_Var
		 = (LogicalOrExpression)AsmLine_86_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = LogicalOrExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final LogicalAndExpression LogicalAndExpression_88_Var
		 = (LogicalAndExpression)Expr_87_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = LogicalAndExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final InclusiveOrExpression InclusiveOrExpression_89_Var
		 = (InclusiveOrExpression)Expr_88_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = InclusiveOrExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final ExclusiveOrExpression ExclusiveOrExpression_90_Var
		 = (ExclusiveOrExpression)Expr_89_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = ExclusiveOrExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final AndExpression AndExpression_91_Var
		 = (AndExpression)Expr_90_list.get(0);
		Assert.assertNotNull(AndExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = AndExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final EqualityExpression EqualityExpression_92_Var
		 = (EqualityExpression)Expr_91_list.get(0);
		Assert.assertNotNull(EqualityExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = EqualityExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final RelationalExpression RelationalExpression_93_Var
		 = (RelationalExpression)Expr_92_list.get(0);
		Assert.assertNotNull(RelationalExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = RelationalExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final ShiftExpression ShiftExpression_94_Var
		 = (ShiftExpression)Expr_93_list.get(0);
		Assert.assertNotNull(ShiftExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = ShiftExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final AdditiveExpression AdditiveExpression_95_Var
		 = (AdditiveExpression)Expr_94_list.get(0);
		Assert.assertNotNull(AdditiveExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = AdditiveExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final MultiplicativeExpression MultiplicativeExpression_96_Var
		 = (MultiplicativeExpression)Expr_95_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = MultiplicativeExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final CastExpression CastExpression_97_Var
		 = (CastExpression)Expr_96_list.get(0);
		Assert.assertNotNull(CastExpression_97_Var
		);
		//97
		final UnaryExpression UnaryExpression_98_Var
		 = (UnaryExpression)CastExpression_97_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_98_Var
		);
		//98
		final PostfixExpression PostfixExpression_99_Var
		 = (PostfixExpression)UnaryExpression_98_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = PostfixExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final PrimaryExpression PrimaryExpression_100_Var
		 = (PrimaryExpression)Expr_99_list.get(0);
		Assert.assertNotNull(PrimaryExpression_100_Var
		);
		Assert.assertEquals("[\"+r\"]", PrimaryExpression_100_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_100_list = PostfixExpression_99_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_100_list);
		Assert.assertEquals(1, Suffix_100_list.size());
		//100
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_101_Var
		 = (PostfixExpressionSuffixArgument)Suffix_100_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_101_Var
		);
		//101
		final ArgumentExpressionList ArgumentExpressionList_102_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_101_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_102_Var
		);
		final EList<? extends EObject> Expr_102_list = ArgumentExpressionList_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final AssignmentExpression AssignmentExpression_103_Var
		 = (AssignmentExpression)Expr_102_list.get(0);
		Assert.assertNotNull(AssignmentExpression_103_Var
		);
		//103
		final ConditionalExpression ConditionalExpression_104_Var
		 = (ConditionalExpression)AssignmentExpression_103_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_104_Var
		);
		//104
		final LogicalOrExpression LogicalOrExpression_105_Var
		 = (LogicalOrExpression)ConditionalExpression_104_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = LogicalOrExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final LogicalAndExpression LogicalAndExpression_106_Var
		 = (LogicalAndExpression)Expr_105_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = LogicalAndExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final InclusiveOrExpression InclusiveOrExpression_107_Var
		 = (InclusiveOrExpression)Expr_106_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = InclusiveOrExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final ExclusiveOrExpression ExclusiveOrExpression_108_Var
		 = (ExclusiveOrExpression)Expr_107_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = ExclusiveOrExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final AndExpression AndExpression_109_Var
		 = (AndExpression)Expr_108_list.get(0);
		Assert.assertNotNull(AndExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = AndExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final EqualityExpression EqualityExpression_110_Var
		 = (EqualityExpression)Expr_109_list.get(0);
		Assert.assertNotNull(EqualityExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = EqualityExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final RelationalExpression RelationalExpression_111_Var
		 = (RelationalExpression)Expr_110_list.get(0);
		Assert.assertNotNull(RelationalExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = RelationalExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final ShiftExpression ShiftExpression_112_Var
		 = (ShiftExpression)Expr_111_list.get(0);
		Assert.assertNotNull(ShiftExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = ShiftExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final AdditiveExpression AdditiveExpression_113_Var
		 = (AdditiveExpression)Expr_112_list.get(0);
		Assert.assertNotNull(AdditiveExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = AdditiveExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final MultiplicativeExpression MultiplicativeExpression_114_Var
		 = (MultiplicativeExpression)Expr_113_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = MultiplicativeExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final CastExpression CastExpression_115_Var
		 = (CastExpression)Expr_114_list.get(0);
		Assert.assertNotNull(CastExpression_115_Var
		);
		//115
		final UnaryExpression UnaryExpression_116_Var
		 = (UnaryExpression)CastExpression_115_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_116_Var
		);
		//116
		final PostfixExpression PostfixExpression_117_Var
		 = (PostfixExpression)UnaryExpression_116_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = PostfixExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final PrimaryExpression PrimaryExpression_118_Var
		 = (PrimaryExpression)Expr_117_list.get(0);
		Assert.assertNotNull(PrimaryExpression_118_Var
		);
		Assert.assertEquals("bar", PrimaryExpression_118_Var
		.getId());
		//118
		final AsmLineWithColon AsmLineWithColon_119_Var
		 = (AsmLineWithColon)AsmLines_83_list.get(1);
		Assert.assertNotNull(AsmLineWithColon_119_Var
		);
		//119
		final AsmLineWithoutColon AsmLineWithoutColon_120_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_119_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_120_Var
		);
		final EList<? extends EObject> AsmLines_120_list = AsmLineWithoutColon_120_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_120_list);
		Assert.assertEquals(1, AsmLines_120_list.size());
		//120
		final AsmLine AsmLine_121_Var
		 = (AsmLine)AsmLines_120_list.get(0);
		Assert.assertNotNull(AsmLine_121_Var
		);
		//121
		final LogicalOrExpression LogicalOrExpression_122_Var
		 = (LogicalOrExpression)AsmLine_121_Var
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
		Assert.assertEquals("[\"g\"]", PrimaryExpression_135_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_135_list = PostfixExpression_134_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_135_list);
		Assert.assertEquals(1, Suffix_135_list.size());
		//135
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_136_Var
		 = (PostfixExpressionSuffixArgument)Suffix_135_list.get(0);
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
		final AssignmentExpression AssignmentExpression_138_Var
		 = (AssignmentExpression)Expr_137_list.get(0);
		Assert.assertNotNull(AssignmentExpression_138_Var
		);
		//138
		final ConditionalExpression ConditionalExpression_139_Var
		 = (ConditionalExpression)AssignmentExpression_138_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_139_Var
		);
		//139
		final LogicalOrExpression LogicalOrExpression_140_Var
		 = (LogicalOrExpression)ConditionalExpression_139_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = LogicalOrExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final LogicalAndExpression LogicalAndExpression_141_Var
		 = (LogicalAndExpression)Expr_140_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = LogicalAndExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final InclusiveOrExpression InclusiveOrExpression_142_Var
		 = (InclusiveOrExpression)Expr_141_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = InclusiveOrExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final ExclusiveOrExpression ExclusiveOrExpression_143_Var
		 = (ExclusiveOrExpression)Expr_142_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = ExclusiveOrExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final AndExpression AndExpression_144_Var
		 = (AndExpression)Expr_143_list.get(0);
		Assert.assertNotNull(AndExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = AndExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final EqualityExpression EqualityExpression_145_Var
		 = (EqualityExpression)Expr_144_list.get(0);
		Assert.assertNotNull(EqualityExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = EqualityExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final RelationalExpression RelationalExpression_146_Var
		 = (RelationalExpression)Expr_145_list.get(0);
		Assert.assertNotNull(RelationalExpression_146_Var
		);
		final EList<? extends EObject> Expr_146_list = RelationalExpression_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final ShiftExpression ShiftExpression_147_Var
		 = (ShiftExpression)Expr_146_list.get(0);
		Assert.assertNotNull(ShiftExpression_147_Var
		);
		final EList<? extends EObject> Expr_147_list = ShiftExpression_147_Var
		.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(1, Expr_147_list.size());
		//147
		final AdditiveExpression AdditiveExpression_148_Var
		 = (AdditiveExpression)Expr_147_list.get(0);
		Assert.assertNotNull(AdditiveExpression_148_Var
		);
		final EList<? extends EObject> Expr_148_list = AdditiveExpression_148_Var
		.getExpr();
		Assert.assertNotNull(Expr_148_list);
		Assert.assertEquals(1, Expr_148_list.size());
		//148
		final MultiplicativeExpression MultiplicativeExpression_149_Var
		 = (MultiplicativeExpression)Expr_148_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_149_Var
		);
		final EList<? extends EObject> Expr_149_list = MultiplicativeExpression_149_Var
		.getExpr();
		Assert.assertNotNull(Expr_149_list);
		Assert.assertEquals(1, Expr_149_list.size());
		//149
		final CastExpression CastExpression_150_Var
		 = (CastExpression)Expr_149_list.get(0);
		Assert.assertNotNull(CastExpression_150_Var
		);
		//150
		final UnaryExpression UnaryExpression_151_Var
		 = (UnaryExpression)CastExpression_150_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_151_Var
		);
		//151
		final PostfixExpression PostfixExpression_152_Var
		 = (PostfixExpression)UnaryExpression_151_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_152_Var
		);
		final EList<? extends EObject> Expr_152_list = PostfixExpression_152_Var
		.getExpr();
		Assert.assertNotNull(Expr_152_list);
		Assert.assertEquals(1, Expr_152_list.size());
		//152
		final PrimaryExpression PrimaryExpression_153_Var
		 = (PrimaryExpression)Expr_152_list.get(0);
		Assert.assertNotNull(PrimaryExpression_153_Var
		);
		Assert.assertEquals("foo", PrimaryExpression_153_Var
		.getId());
		//153
		final AsmLineWithColon AsmLineWithColon_154_Var
		 = (AsmLineWithColon)AsmLines_83_list.get(2);
		Assert.assertNotNull(AsmLineWithColon_154_Var
		);
		//154
		final AsmLineWithoutColon AsmLineWithoutColon_155_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_154_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_155_Var
		);
		final EList<? extends EObject> AsmLines_155_list = AsmLineWithoutColon_155_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_155_list);
		Assert.assertEquals(1, AsmLines_155_list.size());
		//155
		final AsmLine AsmLine_156_Var
		 = (AsmLine)AsmLines_155_list.get(0);
		Assert.assertNotNull(AsmLine_156_Var
		);
		//156
		final LogicalOrExpression LogicalOrExpression_157_Var
		 = (LogicalOrExpression)AsmLine_156_Var
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
		Assert.assertEquals("[\"cc\"]", PrimaryExpression_170_Var
		.getString().toString());
		//170
		final AsmLineWithColon AsmLineWithColon_171_Var
		 = (AsmLineWithColon)AsmLines_83_list.get(3);
		Assert.assertNotNull(AsmLineWithColon_171_Var
		);
		Assert.assertNull(AsmLineWithColon_171_Var
		.getAsmLine());
		//171
		final Statement Statement_172_Var
		 = (Statement)Statement_66_list.get(1);
		Assert.assertNotNull(Statement_172_Var
		);
		//172
		final ExpressionStatement ExpressionStatement_173_Var
		 = (ExpressionStatement)Statement_172_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_173_Var
		);
		//173
		final Expression Expression_174_Var
		 = (Expression)ExpressionStatement_173_Var
		.getExpression();
		Assert.assertNotNull(Expression_174_Var
		);
		final EList<? extends EObject> ExprExpr_174_list = Expression_174_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_174_list);
		Assert.assertEquals(1, ExprExpr_174_list.size());
		//174
		final AssignmentExpression AssignmentExpression_175_Var
		 = (AssignmentExpression)ExprExpr_174_list.get(0);
		Assert.assertNotNull(AssignmentExpression_175_Var
		);
		//175
		final ConditionalExpression ConditionalExpression_176_Var
		 = (ConditionalExpression)AssignmentExpression_175_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_176_Var
		);
		//176
		final LogicalOrExpression LogicalOrExpression_177_Var
		 = (LogicalOrExpression)ConditionalExpression_176_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = LogicalOrExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final LogicalAndExpression LogicalAndExpression_178_Var
		 = (LogicalAndExpression)Expr_177_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = LogicalAndExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final InclusiveOrExpression InclusiveOrExpression_179_Var
		 = (InclusiveOrExpression)Expr_178_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = InclusiveOrExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final ExclusiveOrExpression ExclusiveOrExpression_180_Var
		 = (ExclusiveOrExpression)Expr_179_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_180_Var
		);
		final EList<? extends EObject> Expr_180_list = ExclusiveOrExpression_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final AndExpression AndExpression_181_Var
		 = (AndExpression)Expr_180_list.get(0);
		Assert.assertNotNull(AndExpression_181_Var
		);
		final EList<? extends EObject> Expr_181_list = AndExpression_181_Var
		.getExpr();
		Assert.assertNotNull(Expr_181_list);
		Assert.assertEquals(1, Expr_181_list.size());
		//181
		final EqualityExpression EqualityExpression_182_Var
		 = (EqualityExpression)Expr_181_list.get(0);
		Assert.assertNotNull(EqualityExpression_182_Var
		);
		final EList<? extends EObject> Expr_182_list = EqualityExpression_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(1, Expr_182_list.size());
		//182
		final RelationalExpression RelationalExpression_183_Var
		 = (RelationalExpression)Expr_182_list.get(0);
		Assert.assertNotNull(RelationalExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = RelationalExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final ShiftExpression ShiftExpression_184_Var
		 = (ShiftExpression)Expr_183_list.get(0);
		Assert.assertNotNull(ShiftExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = ShiftExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final AdditiveExpression AdditiveExpression_185_Var
		 = (AdditiveExpression)Expr_184_list.get(0);
		Assert.assertNotNull(AdditiveExpression_185_Var
		);
		final EList<? extends EObject> Expr_185_list = AdditiveExpression_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final MultiplicativeExpression MultiplicativeExpression_186_Var
		 = (MultiplicativeExpression)Expr_185_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_186_Var
		);
		final EList<? extends EObject> Expr_186_list = MultiplicativeExpression_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(1, Expr_186_list.size());
		//186
		final CastExpression CastExpression_187_Var
		 = (CastExpression)Expr_186_list.get(0);
		Assert.assertNotNull(CastExpression_187_Var
		);
		//187
		final UnaryExpression UnaryExpression_188_Var
		 = (UnaryExpression)CastExpression_187_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_188_Var
		);
		//188
		final PostfixExpression PostfixExpression_189_Var
		 = (PostfixExpression)UnaryExpression_188_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = PostfixExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final PrimaryExpression PrimaryExpression_190_Var
		 = (PrimaryExpression)Expr_189_list.get(0);
		Assert.assertNotNull(PrimaryExpression_190_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_190_Var
		.getId());
		final EList<? extends EObject> Suffix_190_list = PostfixExpression_189_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_190_list);
		Assert.assertEquals(1, Suffix_190_list.size());
		//190
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_191_Var
		 = (PostfixExpressionSuffixArgument)Suffix_190_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_191_Var
		);
		//191
		final ArgumentExpressionList ArgumentExpressionList_192_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_191_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_192_Var
		);
		final EList<? extends EObject> Expr_192_list = ArgumentExpressionList_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(2, Expr_192_list.size());
		//192
		final AssignmentExpression AssignmentExpression_193_Var
		 = (AssignmentExpression)Expr_192_list.get(0);
		Assert.assertNotNull(AssignmentExpression_193_Var
		);
		//193
		final ConditionalExpression ConditionalExpression_194_Var
		 = (ConditionalExpression)AssignmentExpression_193_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_194_Var
		);
		//194
		final LogicalOrExpression LogicalOrExpression_195_Var
		 = (LogicalOrExpression)ConditionalExpression_194_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = LogicalOrExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final LogicalAndExpression LogicalAndExpression_196_Var
		 = (LogicalAndExpression)Expr_195_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = LogicalAndExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final InclusiveOrExpression InclusiveOrExpression_197_Var
		 = (InclusiveOrExpression)Expr_196_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = InclusiveOrExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final ExclusiveOrExpression ExclusiveOrExpression_198_Var
		 = (ExclusiveOrExpression)Expr_197_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = ExclusiveOrExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final AndExpression AndExpression_199_Var
		 = (AndExpression)Expr_198_list.get(0);
		Assert.assertNotNull(AndExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = AndExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final EqualityExpression EqualityExpression_200_Var
		 = (EqualityExpression)Expr_199_list.get(0);
		Assert.assertNotNull(EqualityExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = EqualityExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final RelationalExpression RelationalExpression_201_Var
		 = (RelationalExpression)Expr_200_list.get(0);
		Assert.assertNotNull(RelationalExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = RelationalExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final ShiftExpression ShiftExpression_202_Var
		 = (ShiftExpression)Expr_201_list.get(0);
		Assert.assertNotNull(ShiftExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = ShiftExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final AdditiveExpression AdditiveExpression_203_Var
		 = (AdditiveExpression)Expr_202_list.get(0);
		Assert.assertNotNull(AdditiveExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = AdditiveExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final MultiplicativeExpression MultiplicativeExpression_204_Var
		 = (MultiplicativeExpression)Expr_203_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = MultiplicativeExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final CastExpression CastExpression_205_Var
		 = (CastExpression)Expr_204_list.get(0);
		Assert.assertNotNull(CastExpression_205_Var
		);
		//205
		final UnaryExpression UnaryExpression_206_Var
		 = (UnaryExpression)CastExpression_205_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_206_Var
		);
		//206
		final PostfixExpression PostfixExpression_207_Var
		 = (PostfixExpression)UnaryExpression_206_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = PostfixExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final PrimaryExpression PrimaryExpression_208_Var
		 = (PrimaryExpression)Expr_207_list.get(0);
		Assert.assertNotNull(PrimaryExpression_208_Var
		);
		Assert.assertEquals("[\"Ergebnis: %i\\n\"]", PrimaryExpression_208_Var
		.getString().toString());
		//208
		final AssignmentExpression AssignmentExpression_209_Var
		 = (AssignmentExpression)Expr_192_list.get(1);
		Assert.assertNotNull(AssignmentExpression_209_Var
		);
		//209
		final ConditionalExpression ConditionalExpression_210_Var
		 = (ConditionalExpression)AssignmentExpression_209_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_210_Var
		);
		//210
		final LogicalOrExpression LogicalOrExpression_211_Var
		 = (LogicalOrExpression)ConditionalExpression_210_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = LogicalOrExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final LogicalAndExpression LogicalAndExpression_212_Var
		 = (LogicalAndExpression)Expr_211_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = LogicalAndExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final InclusiveOrExpression InclusiveOrExpression_213_Var
		 = (InclusiveOrExpression)Expr_212_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = InclusiveOrExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final ExclusiveOrExpression ExclusiveOrExpression_214_Var
		 = (ExclusiveOrExpression)Expr_213_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = ExclusiveOrExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final AndExpression AndExpression_215_Var
		 = (AndExpression)Expr_214_list.get(0);
		Assert.assertNotNull(AndExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = AndExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final EqualityExpression EqualityExpression_216_Var
		 = (EqualityExpression)Expr_215_list.get(0);
		Assert.assertNotNull(EqualityExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = EqualityExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final RelationalExpression RelationalExpression_217_Var
		 = (RelationalExpression)Expr_216_list.get(0);
		Assert.assertNotNull(RelationalExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = RelationalExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final ShiftExpression ShiftExpression_218_Var
		 = (ShiftExpression)Expr_217_list.get(0);
		Assert.assertNotNull(ShiftExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = ShiftExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final AdditiveExpression AdditiveExpression_219_Var
		 = (AdditiveExpression)Expr_218_list.get(0);
		Assert.assertNotNull(AdditiveExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = AdditiveExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final MultiplicativeExpression MultiplicativeExpression_220_Var
		 = (MultiplicativeExpression)Expr_219_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = MultiplicativeExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final CastExpression CastExpression_221_Var
		 = (CastExpression)Expr_220_list.get(0);
		Assert.assertNotNull(CastExpression_221_Var
		);
		//221
		final UnaryExpression UnaryExpression_222_Var
		 = (UnaryExpression)CastExpression_221_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_222_Var
		);
		//222
		final PostfixExpression PostfixExpression_223_Var
		 = (PostfixExpression)UnaryExpression_222_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = PostfixExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final PrimaryExpression PrimaryExpression_224_Var
		 = (PrimaryExpression)Expr_223_list.get(0);
		Assert.assertNotNull(PrimaryExpression_224_Var
		);
		Assert.assertEquals("bar", PrimaryExpression_224_Var
		.getId());
		//224
		final Statement Statement_225_Var
		 = (Statement)Statement_66_list.get(2);
		Assert.assertNotNull(Statement_225_Var
		);
		//225
		final JumpStatement JumpStatement_226_Var
		 = (JumpStatement)Statement_225_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_226_Var
		);
		//226
		final Expression Expression_227_Var
		 = (Expression)JumpStatement_226_Var
		.getExpr();
		Assert.assertNotNull(Expression_227_Var
		);
		final EList<? extends EObject> ExprExpr_227_list = Expression_227_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_227_list);
		Assert.assertEquals(1, ExprExpr_227_list.size());
		//227
		final AssignmentExpression AssignmentExpression_228_Var
		 = (AssignmentExpression)ExprExpr_227_list.get(0);
		Assert.assertNotNull(AssignmentExpression_228_Var
		);
		//228
		final ConditionalExpression ConditionalExpression_229_Var
		 = (ConditionalExpression)AssignmentExpression_228_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_229_Var
		);
		//229
		final LogicalOrExpression LogicalOrExpression_230_Var
		 = (LogicalOrExpression)ConditionalExpression_229_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = LogicalOrExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final LogicalAndExpression LogicalAndExpression_231_Var
		 = (LogicalAndExpression)Expr_230_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = LogicalAndExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final InclusiveOrExpression InclusiveOrExpression_232_Var
		 = (InclusiveOrExpression)Expr_231_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = InclusiveOrExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final ExclusiveOrExpression ExclusiveOrExpression_233_Var
		 = (ExclusiveOrExpression)Expr_232_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = ExclusiveOrExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final AndExpression AndExpression_234_Var
		 = (AndExpression)Expr_233_list.get(0);
		Assert.assertNotNull(AndExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = AndExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final EqualityExpression EqualityExpression_235_Var
		 = (EqualityExpression)Expr_234_list.get(0);
		Assert.assertNotNull(EqualityExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = EqualityExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final RelationalExpression RelationalExpression_236_Var
		 = (RelationalExpression)Expr_235_list.get(0);
		Assert.assertNotNull(RelationalExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = RelationalExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final ShiftExpression ShiftExpression_237_Var
		 = (ShiftExpression)Expr_236_list.get(0);
		Assert.assertNotNull(ShiftExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = ShiftExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final AdditiveExpression AdditiveExpression_238_Var
		 = (AdditiveExpression)Expr_237_list.get(0);
		Assert.assertNotNull(AdditiveExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = AdditiveExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final MultiplicativeExpression MultiplicativeExpression_239_Var
		 = (MultiplicativeExpression)Expr_238_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = MultiplicativeExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final CastExpression CastExpression_240_Var
		 = (CastExpression)Expr_239_list.get(0);
		Assert.assertNotNull(CastExpression_240_Var
		);
		//240
		final UnaryExpression UnaryExpression_241_Var
		 = (UnaryExpression)CastExpression_240_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_241_Var
		);
		//241
		final PostfixExpression PostfixExpression_242_Var
		 = (PostfixExpression)UnaryExpression_241_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = PostfixExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final PrimaryExpression PrimaryExpression_243_Var
		 = (PrimaryExpression)Expr_242_list.get(0);
		Assert.assertNotNull(PrimaryExpression_243_Var
		);
		//243
		final Constant2 Constant2_244_Var
		 = (Constant2)PrimaryExpression_243_Var
		.getConst();
		Assert.assertNotNull(Constant2_244_Var
		);
		Assert.assertEquals("0", Constant2_244_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_226_Var
		.getReturn());
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


