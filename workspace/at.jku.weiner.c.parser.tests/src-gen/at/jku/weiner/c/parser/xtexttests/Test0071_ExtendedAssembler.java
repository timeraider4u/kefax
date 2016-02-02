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
import at.jku.weiner.c.parser.parser.TypeSpecifier;
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
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.Pointer;
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
import at.jku.weiner.c.parser.parser.UnaryOperator;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
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
import at.jku.weiner.c.parser.parser.AsmSymbolicName;
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
import at.jku.weiner.c.parser.parser.AsmSymbolicName;
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
import at.jku.weiner.c.parser.parser.UnaryOperator;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.AsmSymbolicName;
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
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0071_ExtendedAssembler {
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
			"res/Test0071_ExtendedAssembler.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_UNSIGNED",
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
				"RULE_KW_UNSIGNED",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_KW_UNSIGNED",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_SKW_STAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_SKW_AND",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_LINE_COMMENT",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_LINE_COMMENT",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_LINE_COMMENT",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_ASM1",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACKET",
				"RULE_ID",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACKET",
				"RULE_ID",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_STAR",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACKET",
				"RULE_ID",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTPAREN",
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
			"res/Test0071_ExtendedAssembler.c");
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
		Assert.assertEquals(4, External_0_list.size());
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
		final TypeSpecifier TypeSpecifier_4_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(TypeSpecifier_4_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_4_Var
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
		Assert.assertEquals("i", DirectDeclarator_9_Var
		.getId());
		//9
		final Initializer Initializer_10_Var
		 = (Initializer)InitDeclarator_7_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_10_Var
		);
		//10
		final AssignmentExpression AssignmentExpression_11_Var
		 = (AssignmentExpression)Initializer_10_Var
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
		final Constant2 Constant2_27_Var
		 = (Constant2)PrimaryExpression_26_Var
		.getConst();
		Assert.assertNotNull(Constant2_27_Var
		);
		Assert.assertEquals("0", Constant2_27_Var
		.getDec());
		//27
		final ExternalDeclaration ExternalDeclaration_28_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_28_Var
		);
		//28
		final Declaration Declaration_29_Var
		 = (Declaration)ExternalDeclaration_28_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_29_Var
		);
		//29
		final DeclarationSpecifiers DeclarationSpecifiers_30_Var
		 = (DeclarationSpecifiers)Declaration_29_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_30_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_30_list = DeclarationSpecifiers_30_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_30_list);
		Assert.assertEquals(2, DeclarationSpecifier_30_list.size());
		//30
		final TypeSpecifier TypeSpecifier_31_Var
		 = (TypeSpecifier)DeclarationSpecifier_30_list.get(0);
		Assert.assertNotNull(TypeSpecifier_31_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_31_Var
		.getName());
		//31
		final TypeSpecifier TypeSpecifier_32_Var
		 = (TypeSpecifier)DeclarationSpecifier_30_list.get(1);
		Assert.assertNotNull(TypeSpecifier_32_Var
		);
		Assert.assertEquals("int", TypeSpecifier_32_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_32_list = Declaration_29_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_32_list);
		Assert.assertEquals(1, InitDeclaratorList_32_list.size());
		//32
		final InitDeclaratorList InitDeclaratorList_33_Var
		 = (InitDeclaratorList)InitDeclaratorList_32_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_33_Var
		);
		final EList<? extends EObject> InitDeclarator_33_list = InitDeclaratorList_33_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_33_list);
		Assert.assertEquals(1, InitDeclarator_33_list.size());
		//33
		final InitDeclarator InitDeclarator_34_Var
		 = (InitDeclarator)InitDeclarator_33_list.get(0);
		Assert.assertNotNull(InitDeclarator_34_Var
		);
		//34
		final Declarator Declarator_35_Var
		 = (Declarator)InitDeclarator_34_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_35_Var
		);
		//35
		final DirectDeclarator DirectDeclarator_36_Var
		 = (DirectDeclarator)Declarator_35_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_36_Var
		);
		Assert.assertEquals("j", DirectDeclarator_36_Var
		.getId());
		//36
		final ExternalDeclaration ExternalDeclaration_37_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_37_Var
		);
		//37
		final Declaration Declaration_38_Var
		 = (Declaration)ExternalDeclaration_37_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_38_Var
		);
		//38
		final DeclarationSpecifiers DeclarationSpecifiers_39_Var
		 = (DeclarationSpecifiers)Declaration_38_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_39_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_39_list = DeclarationSpecifiers_39_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_39_list);
		Assert.assertEquals(2, DeclarationSpecifier_39_list.size());
		//39
		final TypeSpecifier TypeSpecifier_40_Var
		 = (TypeSpecifier)DeclarationSpecifier_39_list.get(0);
		Assert.assertNotNull(TypeSpecifier_40_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_40_Var
		.getName());
		//40
		final TypeSpecifier TypeSpecifier_41_Var
		 = (TypeSpecifier)DeclarationSpecifier_39_list.get(1);
		Assert.assertNotNull(TypeSpecifier_41_Var
		);
		Assert.assertEquals("int", TypeSpecifier_41_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_41_list = Declaration_38_Var
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
		final Pointer Pointer_45_Var
		 = (Pointer)Declarator_44_Var
		.getPointer();
		Assert.assertNotNull(Pointer_45_Var
		);
		Assert.assertEquals("[*]", Pointer_45_Var
		.getStar().toString());
		//45
		final DirectDeclarator DirectDeclarator_46_Var
		 = (DirectDeclarator)Declarator_44_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_46_Var
		);
		Assert.assertEquals("k", DirectDeclarator_46_Var
		.getId());
		//46
		final Initializer Initializer_47_Var
		 = (Initializer)InitDeclarator_43_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_47_Var
		);
		//47
		final AssignmentExpression AssignmentExpression_48_Var
		 = (AssignmentExpression)Initializer_47_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_48_Var
		);
		//48
		final ConditionalExpression ConditionalExpression_49_Var
		 = (ConditionalExpression)AssignmentExpression_48_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_49_Var
		);
		//49
		final LogicalOrExpression LogicalOrExpression_50_Var
		 = (LogicalOrExpression)ConditionalExpression_49_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = LogicalOrExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final LogicalAndExpression LogicalAndExpression_51_Var
		 = (LogicalAndExpression)Expr_50_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = LogicalAndExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final InclusiveOrExpression InclusiveOrExpression_52_Var
		 = (InclusiveOrExpression)Expr_51_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = InclusiveOrExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final ExclusiveOrExpression ExclusiveOrExpression_53_Var
		 = (ExclusiveOrExpression)Expr_52_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = ExclusiveOrExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final AndExpression AndExpression_54_Var
		 = (AndExpression)Expr_53_list.get(0);
		Assert.assertNotNull(AndExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = AndExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final EqualityExpression EqualityExpression_55_Var
		 = (EqualityExpression)Expr_54_list.get(0);
		Assert.assertNotNull(EqualityExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = EqualityExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final RelationalExpression RelationalExpression_56_Var
		 = (RelationalExpression)Expr_55_list.get(0);
		Assert.assertNotNull(RelationalExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = RelationalExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final ShiftExpression ShiftExpression_57_Var
		 = (ShiftExpression)Expr_56_list.get(0);
		Assert.assertNotNull(ShiftExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = ShiftExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final AdditiveExpression AdditiveExpression_58_Var
		 = (AdditiveExpression)Expr_57_list.get(0);
		Assert.assertNotNull(AdditiveExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = AdditiveExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final MultiplicativeExpression MultiplicativeExpression_59_Var
		 = (MultiplicativeExpression)Expr_58_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = MultiplicativeExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final CastExpression CastExpression_60_Var
		 = (CastExpression)Expr_59_list.get(0);
		Assert.assertNotNull(CastExpression_60_Var
		);
		//60
		final UnaryExpression UnaryExpression_61_Var
		 = (UnaryExpression)CastExpression_60_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_61_Var
		);
		//61
		final UnaryOperator UnaryOperator_62_Var
		 = (UnaryOperator)UnaryExpression_61_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_62_Var
		);
		Assert.assertEquals("&", UnaryOperator_62_Var
		.getOp());
		//62
		final CastExpression CastExpression_63_Var
		 = (CastExpression)UnaryExpression_61_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_63_Var
		);
		//63
		final UnaryExpression UnaryExpression_64_Var
		 = (UnaryExpression)CastExpression_63_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_64_Var
		);
		//64
		final PostfixExpression PostfixExpression_65_Var
		 = (PostfixExpression)UnaryExpression_64_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = PostfixExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final PrimaryExpression PrimaryExpression_66_Var
		 = (PrimaryExpression)Expr_65_list.get(0);
		Assert.assertNotNull(PrimaryExpression_66_Var
		);
		Assert.assertEquals("i", PrimaryExpression_66_Var
		.getId());
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
		Assert.assertEquals("foo", DirectDeclarator_72_Var
		.getId());
		//72
		final FunctionDefinition FunctionDefinition_73_Var
		 = (FunctionDefinition)ExternalDeclaration_67_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_73_Var
		);
		//73
		final BodyStatement BodyStatement_74_Var
		 = (BodyStatement)FunctionDefinition_73_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_74_Var
		);
		final EList<? extends EObject> BlockList_74_list = BodyStatement_74_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_74_list);
		Assert.assertEquals(1, BlockList_74_list.size());
		//74
		final BlockList BlockList_75_Var
		 = (BlockList)BlockList_74_list.get(0);
		Assert.assertNotNull(BlockList_75_Var
		);
		final EList<? extends EObject> Statement_75_list = BlockList_75_Var
		.getStatement();
		Assert.assertNotNull(Statement_75_list);
		Assert.assertEquals(1, Statement_75_list.size());
		//75
		final Statement Statement_76_Var
		 = (Statement)Statement_75_list.get(0);
		Assert.assertNotNull(Statement_76_Var
		);
		//76
		final AsmStatement AsmStatement_77_Var
		 = (AsmStatement)Statement_76_Var
		.getStmt();
		Assert.assertNotNull(AsmStatement_77_Var
		);
		//77
		final AsmLine AsmLine_78_Var
		 = (AsmLine)AsmStatement_77_Var
		.getAsmLine1();
		Assert.assertNotNull(AsmLine_78_Var
		);
		Assert.assertNull(AsmLine_78_Var
		.getSym());
		//78
		final LogicalOrExpression LogicalOrExpression_79_Var
		 = (LogicalOrExpression)AsmLine_78_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = LogicalOrExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final LogicalAndExpression LogicalAndExpression_80_Var
		 = (LogicalAndExpression)Expr_79_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = LogicalAndExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final InclusiveOrExpression InclusiveOrExpression_81_Var
		 = (InclusiveOrExpression)Expr_80_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = InclusiveOrExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final ExclusiveOrExpression ExclusiveOrExpression_82_Var
		 = (ExclusiveOrExpression)Expr_81_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = ExclusiveOrExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final AndExpression AndExpression_83_Var
		 = (AndExpression)Expr_82_list.get(0);
		Assert.assertNotNull(AndExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = AndExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final EqualityExpression EqualityExpression_84_Var
		 = (EqualityExpression)Expr_83_list.get(0);
		Assert.assertNotNull(EqualityExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = EqualityExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final RelationalExpression RelationalExpression_85_Var
		 = (RelationalExpression)Expr_84_list.get(0);
		Assert.assertNotNull(RelationalExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = RelationalExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final ShiftExpression ShiftExpression_86_Var
		 = (ShiftExpression)Expr_85_list.get(0);
		Assert.assertNotNull(ShiftExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = ShiftExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final AdditiveExpression AdditiveExpression_87_Var
		 = (AdditiveExpression)Expr_86_list.get(0);
		Assert.assertNotNull(AdditiveExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = AdditiveExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final MultiplicativeExpression MultiplicativeExpression_88_Var
		 = (MultiplicativeExpression)Expr_87_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = MultiplicativeExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final CastExpression CastExpression_89_Var
		 = (CastExpression)Expr_88_list.get(0);
		Assert.assertNotNull(CastExpression_89_Var
		);
		//89
		final UnaryExpression UnaryExpression_90_Var
		 = (UnaryExpression)CastExpression_89_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_90_Var
		);
		//90
		final PostfixExpression PostfixExpression_91_Var
		 = (PostfixExpression)UnaryExpression_90_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = PostfixExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final PrimaryExpression PrimaryExpression_92_Var
		 = (PrimaryExpression)Expr_91_list.get(0);
		Assert.assertNotNull(PrimaryExpression_92_Var
		);
		Assert.assertEquals("[\"mov %[e], %[d]\\n\\t\", \"mov %[f], %[e]\"]", PrimaryExpression_92_Var
		.getString().toString());
		final EList<? extends EObject> AsmLines_92_list = AsmStatement_77_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_92_list);
		Assert.assertEquals(2, AsmLines_92_list.size());
		//92
		final AsmLineWithColon AsmLineWithColon_93_Var
		 = (AsmLineWithColon)AsmLines_92_list.get(0);
		Assert.assertNotNull(AsmLineWithColon_93_Var
		);
		//93
		final AsmLineWithoutColon AsmLineWithoutColon_94_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_93_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_94_Var
		);
		final EList<? extends EObject> AsmLines_94_list = AsmLineWithoutColon_94_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_94_list);
		Assert.assertEquals(1, AsmLines_94_list.size());
		//94
		final AsmLine AsmLine_95_Var
		 = (AsmLine)AsmLines_94_list.get(0);
		Assert.assertNotNull(AsmLine_95_Var
		);
		//95
		final AsmSymbolicName AsmSymbolicName_96_Var
		 = (AsmSymbolicName)AsmLine_95_Var
		.getSym();
		Assert.assertNotNull(AsmSymbolicName_96_Var
		);
		Assert.assertEquals("d", AsmSymbolicName_96_Var
		.getId());
		//96
		final LogicalOrExpression LogicalOrExpression_97_Var
		 = (LogicalOrExpression)AsmLine_95_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = LogicalOrExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final LogicalAndExpression LogicalAndExpression_98_Var
		 = (LogicalAndExpression)Expr_97_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = LogicalAndExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final InclusiveOrExpression InclusiveOrExpression_99_Var
		 = (InclusiveOrExpression)Expr_98_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = InclusiveOrExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final ExclusiveOrExpression ExclusiveOrExpression_100_Var
		 = (ExclusiveOrExpression)Expr_99_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = ExclusiveOrExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final AndExpression AndExpression_101_Var
		 = (AndExpression)Expr_100_list.get(0);
		Assert.assertNotNull(AndExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = AndExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final EqualityExpression EqualityExpression_102_Var
		 = (EqualityExpression)Expr_101_list.get(0);
		Assert.assertNotNull(EqualityExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = EqualityExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final RelationalExpression RelationalExpression_103_Var
		 = (RelationalExpression)Expr_102_list.get(0);
		Assert.assertNotNull(RelationalExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = RelationalExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final ShiftExpression ShiftExpression_104_Var
		 = (ShiftExpression)Expr_103_list.get(0);
		Assert.assertNotNull(ShiftExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = ShiftExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final AdditiveExpression AdditiveExpression_105_Var
		 = (AdditiveExpression)Expr_104_list.get(0);
		Assert.assertNotNull(AdditiveExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = AdditiveExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final MultiplicativeExpression MultiplicativeExpression_106_Var
		 = (MultiplicativeExpression)Expr_105_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = MultiplicativeExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final CastExpression CastExpression_107_Var
		 = (CastExpression)Expr_106_list.get(0);
		Assert.assertNotNull(CastExpression_107_Var
		);
		//107
		final UnaryExpression UnaryExpression_108_Var
		 = (UnaryExpression)CastExpression_107_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_108_Var
		);
		//108
		final PostfixExpression PostfixExpression_109_Var
		 = (PostfixExpression)UnaryExpression_108_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = PostfixExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final PrimaryExpression PrimaryExpression_110_Var
		 = (PrimaryExpression)Expr_109_list.get(0);
		Assert.assertNotNull(PrimaryExpression_110_Var
		);
		Assert.assertEquals("[\"=rm\"]", PrimaryExpression_110_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_110_list = PostfixExpression_109_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_110_list);
		Assert.assertEquals(1, Suffix_110_list.size());
		//110
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_111_Var
		 = (PostfixExpressionSuffixArgument)Suffix_110_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_111_Var
		);
		//111
		final ArgumentExpressionList ArgumentExpressionList_112_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_111_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_112_Var
		);
		final EList<? extends EObject> Expr_112_list = ArgumentExpressionList_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final AssignmentExpression AssignmentExpression_113_Var
		 = (AssignmentExpression)Expr_112_list.get(0);
		Assert.assertNotNull(AssignmentExpression_113_Var
		);
		//113
		final ConditionalExpression ConditionalExpression_114_Var
		 = (ConditionalExpression)AssignmentExpression_113_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_114_Var
		);
		//114
		final LogicalOrExpression LogicalOrExpression_115_Var
		 = (LogicalOrExpression)ConditionalExpression_114_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = LogicalOrExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final LogicalAndExpression LogicalAndExpression_116_Var
		 = (LogicalAndExpression)Expr_115_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = LogicalAndExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final InclusiveOrExpression InclusiveOrExpression_117_Var
		 = (InclusiveOrExpression)Expr_116_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = InclusiveOrExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final ExclusiveOrExpression ExclusiveOrExpression_118_Var
		 = (ExclusiveOrExpression)Expr_117_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = ExclusiveOrExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final AndExpression AndExpression_119_Var
		 = (AndExpression)Expr_118_list.get(0);
		Assert.assertNotNull(AndExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = AndExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final EqualityExpression EqualityExpression_120_Var
		 = (EqualityExpression)Expr_119_list.get(0);
		Assert.assertNotNull(EqualityExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = EqualityExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final RelationalExpression RelationalExpression_121_Var
		 = (RelationalExpression)Expr_120_list.get(0);
		Assert.assertNotNull(RelationalExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = RelationalExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final ShiftExpression ShiftExpression_122_Var
		 = (ShiftExpression)Expr_121_list.get(0);
		Assert.assertNotNull(ShiftExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = ShiftExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final AdditiveExpression AdditiveExpression_123_Var
		 = (AdditiveExpression)Expr_122_list.get(0);
		Assert.assertNotNull(AdditiveExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = AdditiveExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final MultiplicativeExpression MultiplicativeExpression_124_Var
		 = (MultiplicativeExpression)Expr_123_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = MultiplicativeExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final CastExpression CastExpression_125_Var
		 = (CastExpression)Expr_124_list.get(0);
		Assert.assertNotNull(CastExpression_125_Var
		);
		//125
		final UnaryExpression UnaryExpression_126_Var
		 = (UnaryExpression)CastExpression_125_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_126_Var
		);
		//126
		final PostfixExpression PostfixExpression_127_Var
		 = (PostfixExpression)UnaryExpression_126_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = PostfixExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final PrimaryExpression PrimaryExpression_128_Var
		 = (PrimaryExpression)Expr_127_list.get(0);
		Assert.assertNotNull(PrimaryExpression_128_Var
		);
		Assert.assertEquals("i", PrimaryExpression_128_Var
		.getId());
		//128
		final AsmLineWithColon AsmLineWithColon_129_Var
		 = (AsmLineWithColon)AsmLines_92_list.get(1);
		Assert.assertNotNull(AsmLineWithColon_129_Var
		);
		//129
		final AsmLineWithoutColon AsmLineWithoutColon_130_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_129_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_130_Var
		);
		final EList<? extends EObject> AsmLines_130_list = AsmLineWithoutColon_130_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_130_list);
		Assert.assertEquals(3, AsmLines_130_list.size());
		//130
		final AsmLine AsmLine_131_Var
		 = (AsmLine)AsmLines_130_list.get(0);
		Assert.assertNotNull(AsmLine_131_Var
		);
		//131
		final AsmSymbolicName AsmSymbolicName_132_Var
		 = (AsmSymbolicName)AsmLine_131_Var
		.getSym();
		Assert.assertNotNull(AsmSymbolicName_132_Var
		);
		Assert.assertEquals("e", AsmSymbolicName_132_Var
		.getId());
		//132
		final LogicalOrExpression LogicalOrExpression_133_Var
		 = (LogicalOrExpression)AsmLine_131_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = LogicalOrExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final LogicalAndExpression LogicalAndExpression_134_Var
		 = (LogicalAndExpression)Expr_133_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = LogicalAndExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final InclusiveOrExpression InclusiveOrExpression_135_Var
		 = (InclusiveOrExpression)Expr_134_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = InclusiveOrExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final ExclusiveOrExpression ExclusiveOrExpression_136_Var
		 = (ExclusiveOrExpression)Expr_135_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = ExclusiveOrExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final AndExpression AndExpression_137_Var
		 = (AndExpression)Expr_136_list.get(0);
		Assert.assertNotNull(AndExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = AndExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final EqualityExpression EqualityExpression_138_Var
		 = (EqualityExpression)Expr_137_list.get(0);
		Assert.assertNotNull(EqualityExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = EqualityExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final RelationalExpression RelationalExpression_139_Var
		 = (RelationalExpression)Expr_138_list.get(0);
		Assert.assertNotNull(RelationalExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = RelationalExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final ShiftExpression ShiftExpression_140_Var
		 = (ShiftExpression)Expr_139_list.get(0);
		Assert.assertNotNull(ShiftExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = ShiftExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final AdditiveExpression AdditiveExpression_141_Var
		 = (AdditiveExpression)Expr_140_list.get(0);
		Assert.assertNotNull(AdditiveExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = AdditiveExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final MultiplicativeExpression MultiplicativeExpression_142_Var
		 = (MultiplicativeExpression)Expr_141_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = MultiplicativeExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final CastExpression CastExpression_143_Var
		 = (CastExpression)Expr_142_list.get(0);
		Assert.assertNotNull(CastExpression_143_Var
		);
		//143
		final UnaryExpression UnaryExpression_144_Var
		 = (UnaryExpression)CastExpression_143_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_144_Var
		);
		//144
		final PostfixExpression PostfixExpression_145_Var
		 = (PostfixExpression)UnaryExpression_144_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = PostfixExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final PrimaryExpression PrimaryExpression_146_Var
		 = (PrimaryExpression)Expr_145_list.get(0);
		Assert.assertNotNull(PrimaryExpression_146_Var
		);
		Assert.assertEquals("[\"rm\"]", PrimaryExpression_146_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_146_list = PostfixExpression_145_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_146_list);
		Assert.assertEquals(1, Suffix_146_list.size());
		//146
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_147_Var
		 = (PostfixExpressionSuffixArgument)Suffix_146_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_147_Var
		);
		//147
		final ArgumentExpressionList ArgumentExpressionList_148_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_147_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_148_Var
		);
		final EList<? extends EObject> Expr_148_list = ArgumentExpressionList_148_Var
		.getExpr();
		Assert.assertNotNull(Expr_148_list);
		Assert.assertEquals(1, Expr_148_list.size());
		//148
		final AssignmentExpression AssignmentExpression_149_Var
		 = (AssignmentExpression)Expr_148_list.get(0);
		Assert.assertNotNull(AssignmentExpression_149_Var
		);
		//149
		final ConditionalExpression ConditionalExpression_150_Var
		 = (ConditionalExpression)AssignmentExpression_149_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_150_Var
		);
		//150
		final LogicalOrExpression LogicalOrExpression_151_Var
		 = (LogicalOrExpression)ConditionalExpression_150_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_151_Var
		);
		final EList<? extends EObject> Expr_151_list = LogicalOrExpression_151_Var
		.getExpr();
		Assert.assertNotNull(Expr_151_list);
		Assert.assertEquals(1, Expr_151_list.size());
		//151
		final LogicalAndExpression LogicalAndExpression_152_Var
		 = (LogicalAndExpression)Expr_151_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_152_Var
		);
		final EList<? extends EObject> Expr_152_list = LogicalAndExpression_152_Var
		.getExpr();
		Assert.assertNotNull(Expr_152_list);
		Assert.assertEquals(1, Expr_152_list.size());
		//152
		final InclusiveOrExpression InclusiveOrExpression_153_Var
		 = (InclusiveOrExpression)Expr_152_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_153_Var
		);
		final EList<? extends EObject> Expr_153_list = InclusiveOrExpression_153_Var
		.getExpr();
		Assert.assertNotNull(Expr_153_list);
		Assert.assertEquals(1, Expr_153_list.size());
		//153
		final ExclusiveOrExpression ExclusiveOrExpression_154_Var
		 = (ExclusiveOrExpression)Expr_153_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_154_Var
		);
		final EList<? extends EObject> Expr_154_list = ExclusiveOrExpression_154_Var
		.getExpr();
		Assert.assertNotNull(Expr_154_list);
		Assert.assertEquals(1, Expr_154_list.size());
		//154
		final AndExpression AndExpression_155_Var
		 = (AndExpression)Expr_154_list.get(0);
		Assert.assertNotNull(AndExpression_155_Var
		);
		final EList<? extends EObject> Expr_155_list = AndExpression_155_Var
		.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		//155
		final EqualityExpression EqualityExpression_156_Var
		 = (EqualityExpression)Expr_155_list.get(0);
		Assert.assertNotNull(EqualityExpression_156_Var
		);
		final EList<? extends EObject> Expr_156_list = EqualityExpression_156_Var
		.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		//156
		final RelationalExpression RelationalExpression_157_Var
		 = (RelationalExpression)Expr_156_list.get(0);
		Assert.assertNotNull(RelationalExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = RelationalExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final ShiftExpression ShiftExpression_158_Var
		 = (ShiftExpression)Expr_157_list.get(0);
		Assert.assertNotNull(ShiftExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = ShiftExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final AdditiveExpression AdditiveExpression_159_Var
		 = (AdditiveExpression)Expr_158_list.get(0);
		Assert.assertNotNull(AdditiveExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = AdditiveExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final MultiplicativeExpression MultiplicativeExpression_160_Var
		 = (MultiplicativeExpression)Expr_159_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = MultiplicativeExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final CastExpression CastExpression_161_Var
		 = (CastExpression)Expr_160_list.get(0);
		Assert.assertNotNull(CastExpression_161_Var
		);
		//161
		final UnaryExpression UnaryExpression_162_Var
		 = (UnaryExpression)CastExpression_161_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_162_Var
		);
		//162
		final UnaryOperator UnaryOperator_163_Var
		 = (UnaryOperator)UnaryExpression_162_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_163_Var
		);
		Assert.assertEquals("*", UnaryOperator_163_Var
		.getOp());
		//163
		final CastExpression CastExpression_164_Var
		 = (CastExpression)UnaryExpression_162_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_164_Var
		);
		//164
		final UnaryExpression UnaryExpression_165_Var
		 = (UnaryExpression)CastExpression_164_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_165_Var
		);
		//165
		final PostfixExpression PostfixExpression_166_Var
		 = (PostfixExpression)UnaryExpression_165_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_166_Var
		);
		final EList<? extends EObject> Expr_166_list = PostfixExpression_166_Var
		.getExpr();
		Assert.assertNotNull(Expr_166_list);
		Assert.assertEquals(1, Expr_166_list.size());
		//166
		final PrimaryExpression PrimaryExpression_167_Var
		 = (PrimaryExpression)Expr_166_list.get(0);
		Assert.assertNotNull(PrimaryExpression_167_Var
		);
		Assert.assertEquals("k", PrimaryExpression_167_Var
		.getId());
		//167
		final AsmLine AsmLine_168_Var
		 = (AsmLine)AsmLines_130_list.get(1);
		Assert.assertNotNull(AsmLine_168_Var
		);
		//168
		final AsmSymbolicName AsmSymbolicName_169_Var
		 = (AsmSymbolicName)AsmLine_168_Var
		.getSym();
		Assert.assertNotNull(AsmSymbolicName_169_Var
		);
		Assert.assertEquals("f", AsmSymbolicName_169_Var
		.getId());
		//169
		final LogicalOrExpression LogicalOrExpression_170_Var
		 = (LogicalOrExpression)AsmLine_168_Var
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
		Assert.assertEquals("[\"i\"]", PrimaryExpression_183_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_183_list = PostfixExpression_182_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_183_list);
		Assert.assertEquals(1, Suffix_183_list.size());
		//183
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_184_Var
		 = (PostfixExpressionSuffixArgument)Suffix_183_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_184_Var
		);
		//184
		final ArgumentExpressionList ArgumentExpressionList_185_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_184_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_185_Var
		);
		final EList<? extends EObject> Expr_185_list = ArgumentExpressionList_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final AssignmentExpression AssignmentExpression_186_Var
		 = (AssignmentExpression)Expr_185_list.get(0);
		Assert.assertNotNull(AssignmentExpression_186_Var
		);
		//186
		final ConditionalExpression ConditionalExpression_187_Var
		 = (ConditionalExpression)AssignmentExpression_186_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_187_Var
		);
		//187
		final LogicalOrExpression LogicalOrExpression_188_Var
		 = (LogicalOrExpression)ConditionalExpression_187_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = LogicalOrExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final LogicalAndExpression LogicalAndExpression_189_Var
		 = (LogicalAndExpression)Expr_188_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = LogicalAndExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final InclusiveOrExpression InclusiveOrExpression_190_Var
		 = (InclusiveOrExpression)Expr_189_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = InclusiveOrExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final ExclusiveOrExpression ExclusiveOrExpression_191_Var
		 = (ExclusiveOrExpression)Expr_190_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = ExclusiveOrExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final AndExpression AndExpression_192_Var
		 = (AndExpression)Expr_191_list.get(0);
		Assert.assertNotNull(AndExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = AndExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final EqualityExpression EqualityExpression_193_Var
		 = (EqualityExpression)Expr_192_list.get(0);
		Assert.assertNotNull(EqualityExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = EqualityExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final RelationalExpression RelationalExpression_194_Var
		 = (RelationalExpression)Expr_193_list.get(0);
		Assert.assertNotNull(RelationalExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = RelationalExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final ShiftExpression ShiftExpression_195_Var
		 = (ShiftExpression)Expr_194_list.get(0);
		Assert.assertNotNull(ShiftExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = ShiftExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final AdditiveExpression AdditiveExpression_196_Var
		 = (AdditiveExpression)Expr_195_list.get(0);
		Assert.assertNotNull(AdditiveExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = AdditiveExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final MultiplicativeExpression MultiplicativeExpression_197_Var
		 = (MultiplicativeExpression)Expr_196_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = MultiplicativeExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final CastExpression CastExpression_198_Var
		 = (CastExpression)Expr_197_list.get(0);
		Assert.assertNotNull(CastExpression_198_Var
		);
		//198
		final UnaryExpression UnaryExpression_199_Var
		 = (UnaryExpression)CastExpression_198_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_199_Var
		);
		//199
		final PostfixExpression PostfixExpression_200_Var
		 = (PostfixExpression)UnaryExpression_199_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = PostfixExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final PrimaryExpression PrimaryExpression_201_Var
		 = (PrimaryExpression)Expr_200_list.get(0);
		Assert.assertNotNull(PrimaryExpression_201_Var
		);
		//201
		final Constant2 Constant2_202_Var
		 = (Constant2)PrimaryExpression_201_Var
		.getConst();
		Assert.assertNotNull(Constant2_202_Var
		);
		Assert.assertEquals("1", Constant2_202_Var
		.getDec());
		//202
		final AsmLine AsmLine_203_Var
		 = (AsmLine)AsmLines_130_list.get(2);
		Assert.assertNotNull(AsmLine_203_Var
		);
		Assert.assertNull(AsmLine_203_Var
		.getSym());
		//203
		final LogicalOrExpression LogicalOrExpression_204_Var
		 = (LogicalOrExpression)AsmLine_203_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = LogicalOrExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final LogicalAndExpression LogicalAndExpression_205_Var
		 = (LogicalAndExpression)Expr_204_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = LogicalAndExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final InclusiveOrExpression InclusiveOrExpression_206_Var
		 = (InclusiveOrExpression)Expr_205_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = InclusiveOrExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final ExclusiveOrExpression ExclusiveOrExpression_207_Var
		 = (ExclusiveOrExpression)Expr_206_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = ExclusiveOrExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final AndExpression AndExpression_208_Var
		 = (AndExpression)Expr_207_list.get(0);
		Assert.assertNotNull(AndExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = AndExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final EqualityExpression EqualityExpression_209_Var
		 = (EqualityExpression)Expr_208_list.get(0);
		Assert.assertNotNull(EqualityExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = EqualityExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final RelationalExpression RelationalExpression_210_Var
		 = (RelationalExpression)Expr_209_list.get(0);
		Assert.assertNotNull(RelationalExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = RelationalExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final ShiftExpression ShiftExpression_211_Var
		 = (ShiftExpression)Expr_210_list.get(0);
		Assert.assertNotNull(ShiftExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = ShiftExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final AdditiveExpression AdditiveExpression_212_Var
		 = (AdditiveExpression)Expr_211_list.get(0);
		Assert.assertNotNull(AdditiveExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = AdditiveExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final MultiplicativeExpression MultiplicativeExpression_213_Var
		 = (MultiplicativeExpression)Expr_212_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = MultiplicativeExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final CastExpression CastExpression_214_Var
		 = (CastExpression)Expr_213_list.get(0);
		Assert.assertNotNull(CastExpression_214_Var
		);
		//214
		final UnaryExpression UnaryExpression_215_Var
		 = (UnaryExpression)CastExpression_214_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_215_Var
		);
		//215
		final PostfixExpression PostfixExpression_216_Var
		 = (PostfixExpression)UnaryExpression_215_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = PostfixExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final PrimaryExpression PrimaryExpression_217_Var
		 = (PrimaryExpression)Expr_216_list.get(0);
		Assert.assertNotNull(PrimaryExpression_217_Var
		);
		Assert.assertEquals("[\"d\"]", PrimaryExpression_217_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_217_list = PostfixExpression_216_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_217_list);
		Assert.assertEquals(1, Suffix_217_list.size());
		//217
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_218_Var
		 = (PostfixExpressionSuffixArgument)Suffix_217_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_218_Var
		);
		//218
		final ArgumentExpressionList ArgumentExpressionList_219_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_218_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_219_Var
		);
		final EList<? extends EObject> Expr_219_list = ArgumentExpressionList_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final AssignmentExpression AssignmentExpression_220_Var
		 = (AssignmentExpression)Expr_219_list.get(0);
		Assert.assertNotNull(AssignmentExpression_220_Var
		);
		//220
		final ConditionalExpression ConditionalExpression_221_Var
		 = (ConditionalExpression)AssignmentExpression_220_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_221_Var
		);
		//221
		final LogicalOrExpression LogicalOrExpression_222_Var
		 = (LogicalOrExpression)ConditionalExpression_221_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = LogicalOrExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final LogicalAndExpression LogicalAndExpression_223_Var
		 = (LogicalAndExpression)Expr_222_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = LogicalAndExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final InclusiveOrExpression InclusiveOrExpression_224_Var
		 = (InclusiveOrExpression)Expr_223_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = InclusiveOrExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final ExclusiveOrExpression ExclusiveOrExpression_225_Var
		 = (ExclusiveOrExpression)Expr_224_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = ExclusiveOrExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final AndExpression AndExpression_226_Var
		 = (AndExpression)Expr_225_list.get(0);
		Assert.assertNotNull(AndExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = AndExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final EqualityExpression EqualityExpression_227_Var
		 = (EqualityExpression)Expr_226_list.get(0);
		Assert.assertNotNull(EqualityExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = EqualityExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final RelationalExpression RelationalExpression_228_Var
		 = (RelationalExpression)Expr_227_list.get(0);
		Assert.assertNotNull(RelationalExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = RelationalExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final ShiftExpression ShiftExpression_229_Var
		 = (ShiftExpression)Expr_228_list.get(0);
		Assert.assertNotNull(ShiftExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = ShiftExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final AdditiveExpression AdditiveExpression_230_Var
		 = (AdditiveExpression)Expr_229_list.get(0);
		Assert.assertNotNull(AdditiveExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = AdditiveExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final MultiplicativeExpression MultiplicativeExpression_231_Var
		 = (MultiplicativeExpression)Expr_230_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = MultiplicativeExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final CastExpression CastExpression_232_Var
		 = (CastExpression)Expr_231_list.get(0);
		Assert.assertNotNull(CastExpression_232_Var
		);
		//232
		final UnaryExpression UnaryExpression_233_Var
		 = (UnaryExpression)CastExpression_232_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_233_Var
		);
		//233
		final PostfixExpression PostfixExpression_234_Var
		 = (PostfixExpression)UnaryExpression_233_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = PostfixExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final PrimaryExpression PrimaryExpression_235_Var
		 = (PrimaryExpression)Expr_234_list.get(0);
		Assert.assertNotNull(PrimaryExpression_235_Var
		);
		Assert.assertEquals("j", PrimaryExpression_235_Var
		.getId());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0071_ExtendedAssembler.c");
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
				method.invoke(this.generator, "Test0071_ExtendedAssembler.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0071_ExtendedAssembler.c");
		final String expected = this.getTextFromFile(
			"res/Test0071_ExtendedAssembler.c"
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


