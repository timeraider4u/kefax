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
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
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
		Assert.assertEquals(";", Declaration_2_Var
		.getSemi());
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
		Assert.assertEquals(";", Declaration_29_Var
		.getSemi());
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
		Assert.assertEquals(";", Declaration_38_Var
		.getSemi());
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
		final AsmLineWithoutColon AsmLineWithoutColon_78_Var
		 = (AsmLineWithoutColon)AsmStatement_77_Var
		.getAsmLine1();
		Assert.assertNotNull(AsmLineWithoutColon_78_Var
		);
		Assert.assertNull(AsmLineWithoutColon_78_Var
		.getSym());
		//78
		final LogicalOrExpression LogicalOrExpression_79_Var
		 = (LogicalOrExpression)AsmLineWithoutColon_78_Var
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
		//94
		final AsmSymbolicName AsmSymbolicName_95_Var
		 = (AsmSymbolicName)AsmLineWithoutColon_94_Var
		.getSym();
		Assert.assertNotNull(AsmSymbolicName_95_Var
		);
		Assert.assertEquals("d", AsmSymbolicName_95_Var
		.getId());
		//95
		final LogicalOrExpression LogicalOrExpression_96_Var
		 = (LogicalOrExpression)AsmLineWithoutColon_94_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = LogicalOrExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final LogicalAndExpression LogicalAndExpression_97_Var
		 = (LogicalAndExpression)Expr_96_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = LogicalAndExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final InclusiveOrExpression InclusiveOrExpression_98_Var
		 = (InclusiveOrExpression)Expr_97_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = InclusiveOrExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final ExclusiveOrExpression ExclusiveOrExpression_99_Var
		 = (ExclusiveOrExpression)Expr_98_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = ExclusiveOrExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final AndExpression AndExpression_100_Var
		 = (AndExpression)Expr_99_list.get(0);
		Assert.assertNotNull(AndExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = AndExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final EqualityExpression EqualityExpression_101_Var
		 = (EqualityExpression)Expr_100_list.get(0);
		Assert.assertNotNull(EqualityExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = EqualityExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final RelationalExpression RelationalExpression_102_Var
		 = (RelationalExpression)Expr_101_list.get(0);
		Assert.assertNotNull(RelationalExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = RelationalExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final ShiftExpression ShiftExpression_103_Var
		 = (ShiftExpression)Expr_102_list.get(0);
		Assert.assertNotNull(ShiftExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = ShiftExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final AdditiveExpression AdditiveExpression_104_Var
		 = (AdditiveExpression)Expr_103_list.get(0);
		Assert.assertNotNull(AdditiveExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = AdditiveExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final MultiplicativeExpression MultiplicativeExpression_105_Var
		 = (MultiplicativeExpression)Expr_104_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = MultiplicativeExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final CastExpression CastExpression_106_Var
		 = (CastExpression)Expr_105_list.get(0);
		Assert.assertNotNull(CastExpression_106_Var
		);
		//106
		final UnaryExpression UnaryExpression_107_Var
		 = (UnaryExpression)CastExpression_106_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_107_Var
		);
		//107
		final PostfixExpression PostfixExpression_108_Var
		 = (PostfixExpression)UnaryExpression_107_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = PostfixExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final PrimaryExpression PrimaryExpression_109_Var
		 = (PrimaryExpression)Expr_108_list.get(0);
		Assert.assertNotNull(PrimaryExpression_109_Var
		);
		Assert.assertEquals("[\"=rm\"]", PrimaryExpression_109_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_109_list = PostfixExpression_108_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_109_list);
		Assert.assertEquals(1, Suffix_109_list.size());
		//109
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_110_Var
		 = (PostfixExpressionSuffixArgument)Suffix_109_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_110_Var
		);
		//110
		final ArgumentExpressionList ArgumentExpressionList_111_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_110_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_111_Var
		);
		final EList<? extends EObject> Expr_111_list = ArgumentExpressionList_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final AssignmentExpression AssignmentExpression_112_Var
		 = (AssignmentExpression)Expr_111_list.get(0);
		Assert.assertNotNull(AssignmentExpression_112_Var
		);
		//112
		final ConditionalExpression ConditionalExpression_113_Var
		 = (ConditionalExpression)AssignmentExpression_112_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_113_Var
		);
		//113
		final LogicalOrExpression LogicalOrExpression_114_Var
		 = (LogicalOrExpression)ConditionalExpression_113_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = LogicalOrExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final LogicalAndExpression LogicalAndExpression_115_Var
		 = (LogicalAndExpression)Expr_114_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = LogicalAndExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final InclusiveOrExpression InclusiveOrExpression_116_Var
		 = (InclusiveOrExpression)Expr_115_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = InclusiveOrExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final ExclusiveOrExpression ExclusiveOrExpression_117_Var
		 = (ExclusiveOrExpression)Expr_116_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = ExclusiveOrExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final AndExpression AndExpression_118_Var
		 = (AndExpression)Expr_117_list.get(0);
		Assert.assertNotNull(AndExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = AndExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final EqualityExpression EqualityExpression_119_Var
		 = (EqualityExpression)Expr_118_list.get(0);
		Assert.assertNotNull(EqualityExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = EqualityExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final RelationalExpression RelationalExpression_120_Var
		 = (RelationalExpression)Expr_119_list.get(0);
		Assert.assertNotNull(RelationalExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = RelationalExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final ShiftExpression ShiftExpression_121_Var
		 = (ShiftExpression)Expr_120_list.get(0);
		Assert.assertNotNull(ShiftExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = ShiftExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final AdditiveExpression AdditiveExpression_122_Var
		 = (AdditiveExpression)Expr_121_list.get(0);
		Assert.assertNotNull(AdditiveExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = AdditiveExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final MultiplicativeExpression MultiplicativeExpression_123_Var
		 = (MultiplicativeExpression)Expr_122_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = MultiplicativeExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final CastExpression CastExpression_124_Var
		 = (CastExpression)Expr_123_list.get(0);
		Assert.assertNotNull(CastExpression_124_Var
		);
		//124
		final UnaryExpression UnaryExpression_125_Var
		 = (UnaryExpression)CastExpression_124_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_125_Var
		);
		//125
		final PostfixExpression PostfixExpression_126_Var
		 = (PostfixExpression)UnaryExpression_125_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = PostfixExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final PrimaryExpression PrimaryExpression_127_Var
		 = (PrimaryExpression)Expr_126_list.get(0);
		Assert.assertNotNull(PrimaryExpression_127_Var
		);
		Assert.assertEquals("i", PrimaryExpression_127_Var
		.getId());
		//127
		final AsmLineWithColon AsmLineWithColon_128_Var
		 = (AsmLineWithColon)AsmLines_92_list.get(1);
		Assert.assertNotNull(AsmLineWithColon_128_Var
		);
		//128
		final AsmLineWithoutColon AsmLineWithoutColon_129_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_128_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_129_Var
		);
		//129
		final AsmSymbolicName AsmSymbolicName_130_Var
		 = (AsmSymbolicName)AsmLineWithoutColon_129_Var
		.getSym();
		Assert.assertNotNull(AsmSymbolicName_130_Var
		);
		Assert.assertEquals("e", AsmSymbolicName_130_Var
		.getId());
		//130
		final LogicalOrExpression LogicalOrExpression_131_Var
		 = (LogicalOrExpression)AsmLineWithoutColon_129_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = LogicalOrExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final LogicalAndExpression LogicalAndExpression_132_Var
		 = (LogicalAndExpression)Expr_131_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = LogicalAndExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final InclusiveOrExpression InclusiveOrExpression_133_Var
		 = (InclusiveOrExpression)Expr_132_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = InclusiveOrExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final ExclusiveOrExpression ExclusiveOrExpression_134_Var
		 = (ExclusiveOrExpression)Expr_133_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = ExclusiveOrExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final AndExpression AndExpression_135_Var
		 = (AndExpression)Expr_134_list.get(0);
		Assert.assertNotNull(AndExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = AndExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final EqualityExpression EqualityExpression_136_Var
		 = (EqualityExpression)Expr_135_list.get(0);
		Assert.assertNotNull(EqualityExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = EqualityExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final RelationalExpression RelationalExpression_137_Var
		 = (RelationalExpression)Expr_136_list.get(0);
		Assert.assertNotNull(RelationalExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = RelationalExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final ShiftExpression ShiftExpression_138_Var
		 = (ShiftExpression)Expr_137_list.get(0);
		Assert.assertNotNull(ShiftExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = ShiftExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final AdditiveExpression AdditiveExpression_139_Var
		 = (AdditiveExpression)Expr_138_list.get(0);
		Assert.assertNotNull(AdditiveExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = AdditiveExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final MultiplicativeExpression MultiplicativeExpression_140_Var
		 = (MultiplicativeExpression)Expr_139_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = MultiplicativeExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final CastExpression CastExpression_141_Var
		 = (CastExpression)Expr_140_list.get(0);
		Assert.assertNotNull(CastExpression_141_Var
		);
		//141
		final UnaryExpression UnaryExpression_142_Var
		 = (UnaryExpression)CastExpression_141_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_142_Var
		);
		//142
		final PostfixExpression PostfixExpression_143_Var
		 = (PostfixExpression)UnaryExpression_142_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = PostfixExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final PrimaryExpression PrimaryExpression_144_Var
		 = (PrimaryExpression)Expr_143_list.get(0);
		Assert.assertNotNull(PrimaryExpression_144_Var
		);
		Assert.assertEquals("[\"rm\"]", PrimaryExpression_144_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_144_list = PostfixExpression_143_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_144_list);
		Assert.assertEquals(1, Suffix_144_list.size());
		//144
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_145_Var
		 = (PostfixExpressionSuffixArgument)Suffix_144_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_145_Var
		);
		//145
		final ArgumentExpressionList ArgumentExpressionList_146_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_145_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_146_Var
		);
		final EList<? extends EObject> Expr_146_list = ArgumentExpressionList_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final AssignmentExpression AssignmentExpression_147_Var
		 = (AssignmentExpression)Expr_146_list.get(0);
		Assert.assertNotNull(AssignmentExpression_147_Var
		);
		//147
		final ConditionalExpression ConditionalExpression_148_Var
		 = (ConditionalExpression)AssignmentExpression_147_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_148_Var
		);
		//148
		final LogicalOrExpression LogicalOrExpression_149_Var
		 = (LogicalOrExpression)ConditionalExpression_148_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_149_Var
		);
		final EList<? extends EObject> Expr_149_list = LogicalOrExpression_149_Var
		.getExpr();
		Assert.assertNotNull(Expr_149_list);
		Assert.assertEquals(1, Expr_149_list.size());
		//149
		final LogicalAndExpression LogicalAndExpression_150_Var
		 = (LogicalAndExpression)Expr_149_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_150_Var
		);
		final EList<? extends EObject> Expr_150_list = LogicalAndExpression_150_Var
		.getExpr();
		Assert.assertNotNull(Expr_150_list);
		Assert.assertEquals(1, Expr_150_list.size());
		//150
		final InclusiveOrExpression InclusiveOrExpression_151_Var
		 = (InclusiveOrExpression)Expr_150_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_151_Var
		);
		final EList<? extends EObject> Expr_151_list = InclusiveOrExpression_151_Var
		.getExpr();
		Assert.assertNotNull(Expr_151_list);
		Assert.assertEquals(1, Expr_151_list.size());
		//151
		final ExclusiveOrExpression ExclusiveOrExpression_152_Var
		 = (ExclusiveOrExpression)Expr_151_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_152_Var
		);
		final EList<? extends EObject> Expr_152_list = ExclusiveOrExpression_152_Var
		.getExpr();
		Assert.assertNotNull(Expr_152_list);
		Assert.assertEquals(1, Expr_152_list.size());
		//152
		final AndExpression AndExpression_153_Var
		 = (AndExpression)Expr_152_list.get(0);
		Assert.assertNotNull(AndExpression_153_Var
		);
		final EList<? extends EObject> Expr_153_list = AndExpression_153_Var
		.getExpr();
		Assert.assertNotNull(Expr_153_list);
		Assert.assertEquals(1, Expr_153_list.size());
		//153
		final EqualityExpression EqualityExpression_154_Var
		 = (EqualityExpression)Expr_153_list.get(0);
		Assert.assertNotNull(EqualityExpression_154_Var
		);
		final EList<? extends EObject> Expr_154_list = EqualityExpression_154_Var
		.getExpr();
		Assert.assertNotNull(Expr_154_list);
		Assert.assertEquals(1, Expr_154_list.size());
		//154
		final RelationalExpression RelationalExpression_155_Var
		 = (RelationalExpression)Expr_154_list.get(0);
		Assert.assertNotNull(RelationalExpression_155_Var
		);
		final EList<? extends EObject> Expr_155_list = RelationalExpression_155_Var
		.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		//155
		final ShiftExpression ShiftExpression_156_Var
		 = (ShiftExpression)Expr_155_list.get(0);
		Assert.assertNotNull(ShiftExpression_156_Var
		);
		final EList<? extends EObject> Expr_156_list = ShiftExpression_156_Var
		.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		//156
		final AdditiveExpression AdditiveExpression_157_Var
		 = (AdditiveExpression)Expr_156_list.get(0);
		Assert.assertNotNull(AdditiveExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = AdditiveExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final MultiplicativeExpression MultiplicativeExpression_158_Var
		 = (MultiplicativeExpression)Expr_157_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = MultiplicativeExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final CastExpression CastExpression_159_Var
		 = (CastExpression)Expr_158_list.get(0);
		Assert.assertNotNull(CastExpression_159_Var
		);
		//159
		final UnaryExpression UnaryExpression_160_Var
		 = (UnaryExpression)CastExpression_159_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_160_Var
		);
		//160
		final UnaryOperator UnaryOperator_161_Var
		 = (UnaryOperator)UnaryExpression_160_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_161_Var
		);
		Assert.assertEquals("*", UnaryOperator_161_Var
		.getOp());
		//161
		final CastExpression CastExpression_162_Var
		 = (CastExpression)UnaryExpression_160_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_162_Var
		);
		//162
		final UnaryExpression UnaryExpression_163_Var
		 = (UnaryExpression)CastExpression_162_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_163_Var
		);
		//163
		final PostfixExpression PostfixExpression_164_Var
		 = (PostfixExpression)UnaryExpression_163_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_164_Var
		);
		final EList<? extends EObject> Expr_164_list = PostfixExpression_164_Var
		.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		//164
		final PrimaryExpression PrimaryExpression_165_Var
		 = (PrimaryExpression)Expr_164_list.get(0);
		Assert.assertNotNull(PrimaryExpression_165_Var
		);
		Assert.assertEquals("k", PrimaryExpression_165_Var
		.getId());
		final EList<? extends EObject> AsmLines_165_list = AsmLineWithoutColon_129_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_165_list);
		Assert.assertEquals(2, AsmLines_165_list.size());
		//165
		final AsmLine AsmLine_166_Var
		 = (AsmLine)AsmLines_165_list.get(0);
		Assert.assertNotNull(AsmLine_166_Var
		);
		//166
		final AsmSymbolicName AsmSymbolicName_167_Var
		 = (AsmSymbolicName)AsmLine_166_Var
		.getSym();
		Assert.assertNotNull(AsmSymbolicName_167_Var
		);
		Assert.assertEquals("f", AsmSymbolicName_167_Var
		.getId());
		//167
		final LogicalOrExpression LogicalOrExpression_168_Var
		 = (LogicalOrExpression)AsmLine_166_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_168_Var
		);
		final EList<? extends EObject> Expr_168_list = LogicalOrExpression_168_Var
		.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(1, Expr_168_list.size());
		//168
		final LogicalAndExpression LogicalAndExpression_169_Var
		 = (LogicalAndExpression)Expr_168_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_169_Var
		);
		final EList<? extends EObject> Expr_169_list = LogicalAndExpression_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		//169
		final InclusiveOrExpression InclusiveOrExpression_170_Var
		 = (InclusiveOrExpression)Expr_169_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_170_Var
		);
		final EList<? extends EObject> Expr_170_list = InclusiveOrExpression_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		//170
		final ExclusiveOrExpression ExclusiveOrExpression_171_Var
		 = (ExclusiveOrExpression)Expr_170_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_171_Var
		);
		final EList<? extends EObject> Expr_171_list = ExclusiveOrExpression_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		//171
		final AndExpression AndExpression_172_Var
		 = (AndExpression)Expr_171_list.get(0);
		Assert.assertNotNull(AndExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = AndExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final EqualityExpression EqualityExpression_173_Var
		 = (EqualityExpression)Expr_172_list.get(0);
		Assert.assertNotNull(EqualityExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = EqualityExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final RelationalExpression RelationalExpression_174_Var
		 = (RelationalExpression)Expr_173_list.get(0);
		Assert.assertNotNull(RelationalExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = RelationalExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final ShiftExpression ShiftExpression_175_Var
		 = (ShiftExpression)Expr_174_list.get(0);
		Assert.assertNotNull(ShiftExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = ShiftExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final AdditiveExpression AdditiveExpression_176_Var
		 = (AdditiveExpression)Expr_175_list.get(0);
		Assert.assertNotNull(AdditiveExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = AdditiveExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final MultiplicativeExpression MultiplicativeExpression_177_Var
		 = (MultiplicativeExpression)Expr_176_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = MultiplicativeExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final CastExpression CastExpression_178_Var
		 = (CastExpression)Expr_177_list.get(0);
		Assert.assertNotNull(CastExpression_178_Var
		);
		//178
		final UnaryExpression UnaryExpression_179_Var
		 = (UnaryExpression)CastExpression_178_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_179_Var
		);
		//179
		final PostfixExpression PostfixExpression_180_Var
		 = (PostfixExpression)UnaryExpression_179_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_180_Var
		);
		final EList<? extends EObject> Expr_180_list = PostfixExpression_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final PrimaryExpression PrimaryExpression_181_Var
		 = (PrimaryExpression)Expr_180_list.get(0);
		Assert.assertNotNull(PrimaryExpression_181_Var
		);
		Assert.assertEquals("[\"i\"]", PrimaryExpression_181_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_181_list = PostfixExpression_180_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_181_list);
		Assert.assertEquals(1, Suffix_181_list.size());
		//181
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_182_Var
		 = (PostfixExpressionSuffixArgument)Suffix_181_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_182_Var
		);
		//182
		final ArgumentExpressionList ArgumentExpressionList_183_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_182_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_183_Var
		);
		final EList<? extends EObject> Expr_183_list = ArgumentExpressionList_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final AssignmentExpression AssignmentExpression_184_Var
		 = (AssignmentExpression)Expr_183_list.get(0);
		Assert.assertNotNull(AssignmentExpression_184_Var
		);
		//184
		final ConditionalExpression ConditionalExpression_185_Var
		 = (ConditionalExpression)AssignmentExpression_184_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_185_Var
		);
		//185
		final LogicalOrExpression LogicalOrExpression_186_Var
		 = (LogicalOrExpression)ConditionalExpression_185_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_186_Var
		);
		final EList<? extends EObject> Expr_186_list = LogicalOrExpression_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(1, Expr_186_list.size());
		//186
		final LogicalAndExpression LogicalAndExpression_187_Var
		 = (LogicalAndExpression)Expr_186_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_187_Var
		);
		final EList<? extends EObject> Expr_187_list = LogicalAndExpression_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(1, Expr_187_list.size());
		//187
		final InclusiveOrExpression InclusiveOrExpression_188_Var
		 = (InclusiveOrExpression)Expr_187_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = InclusiveOrExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final ExclusiveOrExpression ExclusiveOrExpression_189_Var
		 = (ExclusiveOrExpression)Expr_188_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = ExclusiveOrExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final AndExpression AndExpression_190_Var
		 = (AndExpression)Expr_189_list.get(0);
		Assert.assertNotNull(AndExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = AndExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final EqualityExpression EqualityExpression_191_Var
		 = (EqualityExpression)Expr_190_list.get(0);
		Assert.assertNotNull(EqualityExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = EqualityExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final RelationalExpression RelationalExpression_192_Var
		 = (RelationalExpression)Expr_191_list.get(0);
		Assert.assertNotNull(RelationalExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = RelationalExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final ShiftExpression ShiftExpression_193_Var
		 = (ShiftExpression)Expr_192_list.get(0);
		Assert.assertNotNull(ShiftExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = ShiftExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final AdditiveExpression AdditiveExpression_194_Var
		 = (AdditiveExpression)Expr_193_list.get(0);
		Assert.assertNotNull(AdditiveExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = AdditiveExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final MultiplicativeExpression MultiplicativeExpression_195_Var
		 = (MultiplicativeExpression)Expr_194_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = MultiplicativeExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final CastExpression CastExpression_196_Var
		 = (CastExpression)Expr_195_list.get(0);
		Assert.assertNotNull(CastExpression_196_Var
		);
		//196
		final UnaryExpression UnaryExpression_197_Var
		 = (UnaryExpression)CastExpression_196_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_197_Var
		);
		//197
		final PostfixExpression PostfixExpression_198_Var
		 = (PostfixExpression)UnaryExpression_197_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = PostfixExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final PrimaryExpression PrimaryExpression_199_Var
		 = (PrimaryExpression)Expr_198_list.get(0);
		Assert.assertNotNull(PrimaryExpression_199_Var
		);
		//199
		final Constant2 Constant2_200_Var
		 = (Constant2)PrimaryExpression_199_Var
		.getConst();
		Assert.assertNotNull(Constant2_200_Var
		);
		Assert.assertEquals("1", Constant2_200_Var
		.getDec());
		//200
		final AsmLine AsmLine_201_Var
		 = (AsmLine)AsmLines_165_list.get(1);
		Assert.assertNotNull(AsmLine_201_Var
		);
		Assert.assertNull(AsmLine_201_Var
		.getSym());
		//201
		final LogicalOrExpression LogicalOrExpression_202_Var
		 = (LogicalOrExpression)AsmLine_201_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = LogicalOrExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final LogicalAndExpression LogicalAndExpression_203_Var
		 = (LogicalAndExpression)Expr_202_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = LogicalAndExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final InclusiveOrExpression InclusiveOrExpression_204_Var
		 = (InclusiveOrExpression)Expr_203_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = InclusiveOrExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final ExclusiveOrExpression ExclusiveOrExpression_205_Var
		 = (ExclusiveOrExpression)Expr_204_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = ExclusiveOrExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final AndExpression AndExpression_206_Var
		 = (AndExpression)Expr_205_list.get(0);
		Assert.assertNotNull(AndExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = AndExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final EqualityExpression EqualityExpression_207_Var
		 = (EqualityExpression)Expr_206_list.get(0);
		Assert.assertNotNull(EqualityExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = EqualityExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final RelationalExpression RelationalExpression_208_Var
		 = (RelationalExpression)Expr_207_list.get(0);
		Assert.assertNotNull(RelationalExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = RelationalExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final ShiftExpression ShiftExpression_209_Var
		 = (ShiftExpression)Expr_208_list.get(0);
		Assert.assertNotNull(ShiftExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = ShiftExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final AdditiveExpression AdditiveExpression_210_Var
		 = (AdditiveExpression)Expr_209_list.get(0);
		Assert.assertNotNull(AdditiveExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = AdditiveExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final MultiplicativeExpression MultiplicativeExpression_211_Var
		 = (MultiplicativeExpression)Expr_210_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = MultiplicativeExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final CastExpression CastExpression_212_Var
		 = (CastExpression)Expr_211_list.get(0);
		Assert.assertNotNull(CastExpression_212_Var
		);
		//212
		final UnaryExpression UnaryExpression_213_Var
		 = (UnaryExpression)CastExpression_212_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_213_Var
		);
		//213
		final PostfixExpression PostfixExpression_214_Var
		 = (PostfixExpression)UnaryExpression_213_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = PostfixExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final PrimaryExpression PrimaryExpression_215_Var
		 = (PrimaryExpression)Expr_214_list.get(0);
		Assert.assertNotNull(PrimaryExpression_215_Var
		);
		Assert.assertEquals("[\"d\"]", PrimaryExpression_215_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_215_list = PostfixExpression_214_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_215_list);
		Assert.assertEquals(1, Suffix_215_list.size());
		//215
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_216_Var
		 = (PostfixExpressionSuffixArgument)Suffix_215_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_216_Var
		);
		//216
		final ArgumentExpressionList ArgumentExpressionList_217_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_216_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_217_Var
		);
		final EList<? extends EObject> Expr_217_list = ArgumentExpressionList_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final AssignmentExpression AssignmentExpression_218_Var
		 = (AssignmentExpression)Expr_217_list.get(0);
		Assert.assertNotNull(AssignmentExpression_218_Var
		);
		//218
		final ConditionalExpression ConditionalExpression_219_Var
		 = (ConditionalExpression)AssignmentExpression_218_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_219_Var
		);
		//219
		final LogicalOrExpression LogicalOrExpression_220_Var
		 = (LogicalOrExpression)ConditionalExpression_219_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = LogicalOrExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final LogicalAndExpression LogicalAndExpression_221_Var
		 = (LogicalAndExpression)Expr_220_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = LogicalAndExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final InclusiveOrExpression InclusiveOrExpression_222_Var
		 = (InclusiveOrExpression)Expr_221_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = InclusiveOrExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final ExclusiveOrExpression ExclusiveOrExpression_223_Var
		 = (ExclusiveOrExpression)Expr_222_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = ExclusiveOrExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final AndExpression AndExpression_224_Var
		 = (AndExpression)Expr_223_list.get(0);
		Assert.assertNotNull(AndExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = AndExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final EqualityExpression EqualityExpression_225_Var
		 = (EqualityExpression)Expr_224_list.get(0);
		Assert.assertNotNull(EqualityExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = EqualityExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final RelationalExpression RelationalExpression_226_Var
		 = (RelationalExpression)Expr_225_list.get(0);
		Assert.assertNotNull(RelationalExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = RelationalExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final ShiftExpression ShiftExpression_227_Var
		 = (ShiftExpression)Expr_226_list.get(0);
		Assert.assertNotNull(ShiftExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = ShiftExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final AdditiveExpression AdditiveExpression_228_Var
		 = (AdditiveExpression)Expr_227_list.get(0);
		Assert.assertNotNull(AdditiveExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = AdditiveExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final MultiplicativeExpression MultiplicativeExpression_229_Var
		 = (MultiplicativeExpression)Expr_228_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = MultiplicativeExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final CastExpression CastExpression_230_Var
		 = (CastExpression)Expr_229_list.get(0);
		Assert.assertNotNull(CastExpression_230_Var
		);
		//230
		final UnaryExpression UnaryExpression_231_Var
		 = (UnaryExpression)CastExpression_230_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_231_Var
		);
		//231
		final PostfixExpression PostfixExpression_232_Var
		 = (PostfixExpression)UnaryExpression_231_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = PostfixExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final PrimaryExpression PrimaryExpression_233_Var
		 = (PrimaryExpression)Expr_232_list.get(0);
		Assert.assertNotNull(PrimaryExpression_233_Var
		);
		Assert.assertEquals("j", PrimaryExpression_233_Var
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


