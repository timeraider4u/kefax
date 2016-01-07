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
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
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
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.InitializerList;
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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArray;
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
public class Test0036_SimpleIntArray {
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
			"res/Test0036_SimpleIntArray.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_LINEDIRECTIVE",
				"RULE_NEWLINE",
				"RULE_LINEDIRECTIVE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTBRACKET",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_SKW_SEMI",
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
				"RULE_SKW_LEFTPAREN",
				"RULE_STRING_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTBRACKET",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTBRACKET",
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
			"res/Test0036_SimpleIntArray.c");
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
		Assert.assertEquals(2, External_0_list.size());
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
		Assert.assertEquals(1, DeclarationSpecifier_3_list.size());
		//3
		final TypeSpecifier TypeSpecifier_4_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(TypeSpecifier_4_Var
		);
		Assert.assertEquals("int", TypeSpecifier_4_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_4_list = Declaration_2_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_4_list);
		Assert.assertEquals(1, InitDeclaratorList_4_list.size());
		//4
		final InitDeclaratorList InitDeclaratorList_5_Var
		 = (InitDeclaratorList)InitDeclaratorList_4_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_5_Var
		);
		final EList<? extends EObject> InitDeclarator_5_list = InitDeclaratorList_5_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_5_list);
		Assert.assertEquals(1, InitDeclarator_5_list.size());
		//5
		final InitDeclarator InitDeclarator_6_Var
		 = (InitDeclarator)InitDeclarator_5_list.get(0);
		Assert.assertNotNull(InitDeclarator_6_Var
		);
		//6
		final Declarator Declarator_7_Var
		 = (Declarator)InitDeclarator_6_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_7_Var
		);
		//7
		final DirectDeclarator DirectDeclarator_8_Var
		 = (DirectDeclarator)Declarator_7_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_8_Var
		);
		Assert.assertEquals("array", DirectDeclarator_8_Var
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
		final AssignmentExpression AssignmentExpression_10_Var
		 = (AssignmentExpression)DeclaratorSuffix_9_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_10_Var
		);
		//10
		final ConditionalExpression ConditionalExpression_11_Var
		 = (ConditionalExpression)AssignmentExpression_10_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_11_Var
		);
		//11
		final LogicalOrExpression LogicalOrExpression_12_Var
		 = (LogicalOrExpression)ConditionalExpression_11_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_12_Var
		);
		final EList<? extends EObject> Expr_12_list = LogicalOrExpression_12_Var
		.getExpr();
		Assert.assertNotNull(Expr_12_list);
		Assert.assertEquals(1, Expr_12_list.size());
		//12
		final LogicalAndExpression LogicalAndExpression_13_Var
		 = (LogicalAndExpression)Expr_12_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_13_Var
		);
		final EList<? extends EObject> Expr_13_list = LogicalAndExpression_13_Var
		.getExpr();
		Assert.assertNotNull(Expr_13_list);
		Assert.assertEquals(1, Expr_13_list.size());
		//13
		final InclusiveOrExpression InclusiveOrExpression_14_Var
		 = (InclusiveOrExpression)Expr_13_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = InclusiveOrExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		//14
		final ExclusiveOrExpression ExclusiveOrExpression_15_Var
		 = (ExclusiveOrExpression)Expr_14_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = ExclusiveOrExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final AndExpression AndExpression_16_Var
		 = (AndExpression)Expr_15_list.get(0);
		Assert.assertNotNull(AndExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = AndExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final EqualityExpression EqualityExpression_17_Var
		 = (EqualityExpression)Expr_16_list.get(0);
		Assert.assertNotNull(EqualityExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = EqualityExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final RelationalExpression RelationalExpression_18_Var
		 = (RelationalExpression)Expr_17_list.get(0);
		Assert.assertNotNull(RelationalExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = RelationalExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final ShiftExpression ShiftExpression_19_Var
		 = (ShiftExpression)Expr_18_list.get(0);
		Assert.assertNotNull(ShiftExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = ShiftExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final AdditiveExpression AdditiveExpression_20_Var
		 = (AdditiveExpression)Expr_19_list.get(0);
		Assert.assertNotNull(AdditiveExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = AdditiveExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final MultiplicativeExpression MultiplicativeExpression_21_Var
		 = (MultiplicativeExpression)Expr_20_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = MultiplicativeExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final CastExpression CastExpression_22_Var
		 = (CastExpression)Expr_21_list.get(0);
		Assert.assertNotNull(CastExpression_22_Var
		);
		//22
		final UnaryExpression UnaryExpression_23_Var
		 = (UnaryExpression)CastExpression_22_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_23_Var
		);
		//23
		final PostfixExpression PostfixExpression_24_Var
		 = (PostfixExpression)UnaryExpression_23_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = PostfixExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final PrimaryExpression PrimaryExpression_25_Var
		 = (PrimaryExpression)Expr_24_list.get(0);
		Assert.assertNotNull(PrimaryExpression_25_Var
		);
		//25
		final Constant2 Constant2_26_Var
		 = (Constant2)PrimaryExpression_25_Var
		.getConst();
		Assert.assertNotNull(Constant2_26_Var
		);
		Assert.assertEquals("6", Constant2_26_Var
		.getDec());
		//26
		final Initializer Initializer_27_Var
		 = (Initializer)InitDeclarator_6_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_27_Var
		);
		//27
		final InitializerList InitializerList_28_Var
		 = (InitializerList)Initializer_27_Var
		.getList();
		Assert.assertNotNull(InitializerList_28_Var
		);
		final EList<? extends EObject> Initializer_28_list = InitializerList_28_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_28_list);
		Assert.assertEquals(6, Initializer_28_list.size());
		//28
		final Initializer Initializer_29_Var
		 = (Initializer)Initializer_28_list.get(0);
		Assert.assertNotNull(Initializer_29_Var
		);
		//29
		final AssignmentExpression AssignmentExpression_30_Var
		 = (AssignmentExpression)Initializer_29_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_30_Var
		);
		//30
		final ConditionalExpression ConditionalExpression_31_Var
		 = (ConditionalExpression)AssignmentExpression_30_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_31_Var
		);
		//31
		final LogicalOrExpression LogicalOrExpression_32_Var
		 = (LogicalOrExpression)ConditionalExpression_31_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = LogicalOrExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final LogicalAndExpression LogicalAndExpression_33_Var
		 = (LogicalAndExpression)Expr_32_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = LogicalAndExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final InclusiveOrExpression InclusiveOrExpression_34_Var
		 = (InclusiveOrExpression)Expr_33_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = InclusiveOrExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final ExclusiveOrExpression ExclusiveOrExpression_35_Var
		 = (ExclusiveOrExpression)Expr_34_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = ExclusiveOrExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final AndExpression AndExpression_36_Var
		 = (AndExpression)Expr_35_list.get(0);
		Assert.assertNotNull(AndExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = AndExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final EqualityExpression EqualityExpression_37_Var
		 = (EqualityExpression)Expr_36_list.get(0);
		Assert.assertNotNull(EqualityExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = EqualityExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final RelationalExpression RelationalExpression_38_Var
		 = (RelationalExpression)Expr_37_list.get(0);
		Assert.assertNotNull(RelationalExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = RelationalExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final ShiftExpression ShiftExpression_39_Var
		 = (ShiftExpression)Expr_38_list.get(0);
		Assert.assertNotNull(ShiftExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = ShiftExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final AdditiveExpression AdditiveExpression_40_Var
		 = (AdditiveExpression)Expr_39_list.get(0);
		Assert.assertNotNull(AdditiveExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = AdditiveExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final MultiplicativeExpression MultiplicativeExpression_41_Var
		 = (MultiplicativeExpression)Expr_40_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = MultiplicativeExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final CastExpression CastExpression_42_Var
		 = (CastExpression)Expr_41_list.get(0);
		Assert.assertNotNull(CastExpression_42_Var
		);
		//42
		final UnaryExpression UnaryExpression_43_Var
		 = (UnaryExpression)CastExpression_42_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_43_Var
		);
		//43
		final PostfixExpression PostfixExpression_44_Var
		 = (PostfixExpression)UnaryExpression_43_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = PostfixExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final PrimaryExpression PrimaryExpression_45_Var
		 = (PrimaryExpression)Expr_44_list.get(0);
		Assert.assertNotNull(PrimaryExpression_45_Var
		);
		//45
		final Constant2 Constant2_46_Var
		 = (Constant2)PrimaryExpression_45_Var
		.getConst();
		Assert.assertNotNull(Constant2_46_Var
		);
		Assert.assertEquals("1", Constant2_46_Var
		.getDec());
		//46
		final Initializer Initializer_47_Var
		 = (Initializer)Initializer_28_list.get(1);
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
		final PostfixExpression PostfixExpression_62_Var
		 = (PostfixExpression)UnaryExpression_61_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = PostfixExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final PrimaryExpression PrimaryExpression_63_Var
		 = (PrimaryExpression)Expr_62_list.get(0);
		Assert.assertNotNull(PrimaryExpression_63_Var
		);
		//63
		final Constant2 Constant2_64_Var
		 = (Constant2)PrimaryExpression_63_Var
		.getConst();
		Assert.assertNotNull(Constant2_64_Var
		);
		Assert.assertEquals("2", Constant2_64_Var
		.getDec());
		//64
		final Initializer Initializer_65_Var
		 = (Initializer)Initializer_28_list.get(2);
		Assert.assertNotNull(Initializer_65_Var
		);
		//65
		final AssignmentExpression AssignmentExpression_66_Var
		 = (AssignmentExpression)Initializer_65_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_66_Var
		);
		//66
		final ConditionalExpression ConditionalExpression_67_Var
		 = (ConditionalExpression)AssignmentExpression_66_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_67_Var
		);
		//67
		final LogicalOrExpression LogicalOrExpression_68_Var
		 = (LogicalOrExpression)ConditionalExpression_67_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = LogicalOrExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final LogicalAndExpression LogicalAndExpression_69_Var
		 = (LogicalAndExpression)Expr_68_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = LogicalAndExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final InclusiveOrExpression InclusiveOrExpression_70_Var
		 = (InclusiveOrExpression)Expr_69_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = InclusiveOrExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final ExclusiveOrExpression ExclusiveOrExpression_71_Var
		 = (ExclusiveOrExpression)Expr_70_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = ExclusiveOrExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final AndExpression AndExpression_72_Var
		 = (AndExpression)Expr_71_list.get(0);
		Assert.assertNotNull(AndExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = AndExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final EqualityExpression EqualityExpression_73_Var
		 = (EqualityExpression)Expr_72_list.get(0);
		Assert.assertNotNull(EqualityExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = EqualityExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final RelationalExpression RelationalExpression_74_Var
		 = (RelationalExpression)Expr_73_list.get(0);
		Assert.assertNotNull(RelationalExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = RelationalExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final ShiftExpression ShiftExpression_75_Var
		 = (ShiftExpression)Expr_74_list.get(0);
		Assert.assertNotNull(ShiftExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = ShiftExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final AdditiveExpression AdditiveExpression_76_Var
		 = (AdditiveExpression)Expr_75_list.get(0);
		Assert.assertNotNull(AdditiveExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = AdditiveExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final MultiplicativeExpression MultiplicativeExpression_77_Var
		 = (MultiplicativeExpression)Expr_76_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = MultiplicativeExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final CastExpression CastExpression_78_Var
		 = (CastExpression)Expr_77_list.get(0);
		Assert.assertNotNull(CastExpression_78_Var
		);
		//78
		final UnaryExpression UnaryExpression_79_Var
		 = (UnaryExpression)CastExpression_78_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_79_Var
		);
		//79
		final PostfixExpression PostfixExpression_80_Var
		 = (PostfixExpression)UnaryExpression_79_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = PostfixExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final PrimaryExpression PrimaryExpression_81_Var
		 = (PrimaryExpression)Expr_80_list.get(0);
		Assert.assertNotNull(PrimaryExpression_81_Var
		);
		//81
		final Constant2 Constant2_82_Var
		 = (Constant2)PrimaryExpression_81_Var
		.getConst();
		Assert.assertNotNull(Constant2_82_Var
		);
		Assert.assertEquals("3", Constant2_82_Var
		.getDec());
		//82
		final Initializer Initializer_83_Var
		 = (Initializer)Initializer_28_list.get(3);
		Assert.assertNotNull(Initializer_83_Var
		);
		//83
		final AssignmentExpression AssignmentExpression_84_Var
		 = (AssignmentExpression)Initializer_83_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_84_Var
		);
		//84
		final ConditionalExpression ConditionalExpression_85_Var
		 = (ConditionalExpression)AssignmentExpression_84_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_85_Var
		);
		//85
		final LogicalOrExpression LogicalOrExpression_86_Var
		 = (LogicalOrExpression)ConditionalExpression_85_Var
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
		Assert.assertEquals("5", Constant2_100_Var
		.getDec());
		//100
		final Initializer Initializer_101_Var
		 = (Initializer)Initializer_28_list.get(4);
		Assert.assertNotNull(Initializer_101_Var
		);
		//101
		final AssignmentExpression AssignmentExpression_102_Var
		 = (AssignmentExpression)Initializer_101_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_102_Var
		);
		//102
		final ConditionalExpression ConditionalExpression_103_Var
		 = (ConditionalExpression)AssignmentExpression_102_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_103_Var
		);
		//103
		final LogicalOrExpression LogicalOrExpression_104_Var
		 = (LogicalOrExpression)ConditionalExpression_103_Var
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
		Assert.assertEquals("7", Constant2_118_Var
		.getDec());
		//118
		final Initializer Initializer_119_Var
		 = (Initializer)Initializer_28_list.get(5);
		Assert.assertNotNull(Initializer_119_Var
		);
		//119
		final AssignmentExpression AssignmentExpression_120_Var
		 = (AssignmentExpression)Initializer_119_Var
		.getExpr();
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
		//135
		final Constant2 Constant2_136_Var
		 = (Constant2)PrimaryExpression_135_Var
		.getConst();
		Assert.assertNotNull(Constant2_136_Var
		);
		Assert.assertEquals("11", Constant2_136_Var
		.getDec());
		//136
		final ExternalDeclaration ExternalDeclaration_137_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_137_Var
		);
		//137
		final FunctionDefHead FunctionDefHead_138_Var
		 = (FunctionDefHead)ExternalDeclaration_137_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_138_Var
		);
		//138
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_139_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_138_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_139_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_139_list = FunctionDeclarationSpecifiers_139_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_139_list);
		Assert.assertEquals(1, DeclarationSpecifier_139_list.size());
		//139
		final TypeSpecifier TypeSpecifier_140_Var
		 = (TypeSpecifier)DeclarationSpecifier_139_list.get(0);
		Assert.assertNotNull(TypeSpecifier_140_Var
		);
		Assert.assertEquals("int", TypeSpecifier_140_Var
		.getName());
		//140
		final Declarator Declarator_141_Var
		 = (Declarator)FunctionDefHead_138_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_141_Var
		);
		//141
		final DirectDeclarator DirectDeclarator_142_Var
		 = (DirectDeclarator)Declarator_141_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_142_Var
		);
		Assert.assertEquals("main", DirectDeclarator_142_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_142_list = DirectDeclarator_142_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_142_list);
		Assert.assertEquals(1, DeclaratorSuffix_142_list.size());
		//142
		final DeclaratorSuffix DeclaratorSuffix_143_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_142_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_143_Var
		);
		//143
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_144_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_143_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_144_Var
		);
		final EList<? extends EObject> ParameterTypeList_144_list = DirectDeclaratorLastSuffix_144_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_144_list);
		Assert.assertEquals(1, ParameterTypeList_144_list.size());
		//144
		final ParameterTypeList ParameterTypeList_145_Var
		 = (ParameterTypeList)ParameterTypeList_144_list.get(0);
		Assert.assertNotNull(ParameterTypeList_145_Var
		);
		//145
		final ParameterList ParameterList_146_Var
		 = (ParameterList)ParameterTypeList_145_Var
		.getList();
		Assert.assertNotNull(ParameterList_146_Var
		);
		final EList<? extends EObject> ParameterDeclaration_146_list = ParameterList_146_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_146_list);
		Assert.assertEquals(1, ParameterDeclaration_146_list.size());
		//146
		final ParameterDeclaration ParameterDeclaration_147_Var
		 = (ParameterDeclaration)ParameterDeclaration_146_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_147_Var
		);
		//147
		final DeclarationSpecifiers DeclarationSpecifiers_148_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_147_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_148_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_148_list = DeclarationSpecifiers_148_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_148_list);
		Assert.assertEquals(1, DeclarationSpecifier_148_list.size());
		//148
		final TypeSpecifier TypeSpecifier_149_Var
		 = (TypeSpecifier)DeclarationSpecifier_148_list.get(0);
		Assert.assertNotNull(TypeSpecifier_149_Var
		);
		Assert.assertEquals("void", TypeSpecifier_149_Var
		.getName());
		//149
		final FunctionDefinition FunctionDefinition_150_Var
		 = (FunctionDefinition)ExternalDeclaration_137_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_150_Var
		);
		//150
		final BodyStatement BodyStatement_151_Var
		 = (BodyStatement)FunctionDefinition_150_Var
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
		final Expression Expression_155_Var
		 = (Expression)ExpressionStatement_154_Var
		.getExpression();
		Assert.assertNotNull(Expression_155_Var
		);
		final EList<? extends EObject> ExprExpr_155_list = Expression_155_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_155_list);
		Assert.assertEquals(1, ExprExpr_155_list.size());
		//155
		final AssignmentExpression AssignmentExpression_156_Var
		 = (AssignmentExpression)ExprExpr_155_list.get(0);
		Assert.assertNotNull(AssignmentExpression_156_Var
		);
		//156
		final ConditionalExpression ConditionalExpression_157_Var
		 = (ConditionalExpression)AssignmentExpression_156_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_157_Var
		);
		//157
		final LogicalOrExpression LogicalOrExpression_158_Var
		 = (LogicalOrExpression)ConditionalExpression_157_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = LogicalOrExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final LogicalAndExpression LogicalAndExpression_159_Var
		 = (LogicalAndExpression)Expr_158_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = LogicalAndExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final InclusiveOrExpression InclusiveOrExpression_160_Var
		 = (InclusiveOrExpression)Expr_159_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = InclusiveOrExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final ExclusiveOrExpression ExclusiveOrExpression_161_Var
		 = (ExclusiveOrExpression)Expr_160_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = ExclusiveOrExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final AndExpression AndExpression_162_Var
		 = (AndExpression)Expr_161_list.get(0);
		Assert.assertNotNull(AndExpression_162_Var
		);
		final EList<? extends EObject> Expr_162_list = AndExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		//162
		final EqualityExpression EqualityExpression_163_Var
		 = (EqualityExpression)Expr_162_list.get(0);
		Assert.assertNotNull(EqualityExpression_163_Var
		);
		final EList<? extends EObject> Expr_163_list = EqualityExpression_163_Var
		.getExpr();
		Assert.assertNotNull(Expr_163_list);
		Assert.assertEquals(1, Expr_163_list.size());
		//163
		final RelationalExpression RelationalExpression_164_Var
		 = (RelationalExpression)Expr_163_list.get(0);
		Assert.assertNotNull(RelationalExpression_164_Var
		);
		final EList<? extends EObject> Expr_164_list = RelationalExpression_164_Var
		.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		//164
		final ShiftExpression ShiftExpression_165_Var
		 = (ShiftExpression)Expr_164_list.get(0);
		Assert.assertNotNull(ShiftExpression_165_Var
		);
		final EList<? extends EObject> Expr_165_list = ShiftExpression_165_Var
		.getExpr();
		Assert.assertNotNull(Expr_165_list);
		Assert.assertEquals(1, Expr_165_list.size());
		//165
		final AdditiveExpression AdditiveExpression_166_Var
		 = (AdditiveExpression)Expr_165_list.get(0);
		Assert.assertNotNull(AdditiveExpression_166_Var
		);
		final EList<? extends EObject> Expr_166_list = AdditiveExpression_166_Var
		.getExpr();
		Assert.assertNotNull(Expr_166_list);
		Assert.assertEquals(1, Expr_166_list.size());
		//166
		final MultiplicativeExpression MultiplicativeExpression_167_Var
		 = (MultiplicativeExpression)Expr_166_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_167_Var
		);
		final EList<? extends EObject> Expr_167_list = MultiplicativeExpression_167_Var
		.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(1, Expr_167_list.size());
		//167
		final CastExpression CastExpression_168_Var
		 = (CastExpression)Expr_167_list.get(0);
		Assert.assertNotNull(CastExpression_168_Var
		);
		//168
		final UnaryExpression UnaryExpression_169_Var
		 = (UnaryExpression)CastExpression_168_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_169_Var
		);
		//169
		final PostfixExpression PostfixExpression_170_Var
		 = (PostfixExpression)UnaryExpression_169_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_170_Var
		);
		final EList<? extends EObject> Expr_170_list = PostfixExpression_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		//170
		final PrimaryExpression PrimaryExpression_171_Var
		 = (PrimaryExpression)Expr_170_list.get(0);
		Assert.assertNotNull(PrimaryExpression_171_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_171_Var
		.getId());
		final EList<? extends EObject> Suffix_171_list = PostfixExpression_170_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_171_list);
		Assert.assertEquals(1, Suffix_171_list.size());
		//171
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_172_Var
		 = (PostfixExpressionSuffixArgument)Suffix_171_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_172_Var
		);
		//172
		final ArgumentExpressionList ArgumentExpressionList_173_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_172_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_173_Var
		);
		final EList<? extends EObject> Expr_173_list = ArgumentExpressionList_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(2, Expr_173_list.size());
		//173
		final AssignmentExpression AssignmentExpression_174_Var
		 = (AssignmentExpression)Expr_173_list.get(0);
		Assert.assertNotNull(AssignmentExpression_174_Var
		);
		//174
		final ConditionalExpression ConditionalExpression_175_Var
		 = (ConditionalExpression)AssignmentExpression_174_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_175_Var
		);
		//175
		final LogicalOrExpression LogicalOrExpression_176_Var
		 = (LogicalOrExpression)ConditionalExpression_175_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = LogicalOrExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final LogicalAndExpression LogicalAndExpression_177_Var
		 = (LogicalAndExpression)Expr_176_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = LogicalAndExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final InclusiveOrExpression InclusiveOrExpression_178_Var
		 = (InclusiveOrExpression)Expr_177_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = InclusiveOrExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final ExclusiveOrExpression ExclusiveOrExpression_179_Var
		 = (ExclusiveOrExpression)Expr_178_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = ExclusiveOrExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final AndExpression AndExpression_180_Var
		 = (AndExpression)Expr_179_list.get(0);
		Assert.assertNotNull(AndExpression_180_Var
		);
		final EList<? extends EObject> Expr_180_list = AndExpression_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final EqualityExpression EqualityExpression_181_Var
		 = (EqualityExpression)Expr_180_list.get(0);
		Assert.assertNotNull(EqualityExpression_181_Var
		);
		final EList<? extends EObject> Expr_181_list = EqualityExpression_181_Var
		.getExpr();
		Assert.assertNotNull(Expr_181_list);
		Assert.assertEquals(1, Expr_181_list.size());
		//181
		final RelationalExpression RelationalExpression_182_Var
		 = (RelationalExpression)Expr_181_list.get(0);
		Assert.assertNotNull(RelationalExpression_182_Var
		);
		final EList<? extends EObject> Expr_182_list = RelationalExpression_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(1, Expr_182_list.size());
		//182
		final ShiftExpression ShiftExpression_183_Var
		 = (ShiftExpression)Expr_182_list.get(0);
		Assert.assertNotNull(ShiftExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = ShiftExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final AdditiveExpression AdditiveExpression_184_Var
		 = (AdditiveExpression)Expr_183_list.get(0);
		Assert.assertNotNull(AdditiveExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = AdditiveExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final MultiplicativeExpression MultiplicativeExpression_185_Var
		 = (MultiplicativeExpression)Expr_184_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_185_Var
		);
		final EList<? extends EObject> Expr_185_list = MultiplicativeExpression_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final CastExpression CastExpression_186_Var
		 = (CastExpression)Expr_185_list.get(0);
		Assert.assertNotNull(CastExpression_186_Var
		);
		//186
		final UnaryExpression UnaryExpression_187_Var
		 = (UnaryExpression)CastExpression_186_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_187_Var
		);
		//187
		final PostfixExpression PostfixExpression_188_Var
		 = (PostfixExpression)UnaryExpression_187_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = PostfixExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final PrimaryExpression PrimaryExpression_189_Var
		 = (PrimaryExpression)Expr_188_list.get(0);
		Assert.assertNotNull(PrimaryExpression_189_Var
		);
		Assert.assertEquals("[\"%d\\n\"]", PrimaryExpression_189_Var
		.getString().toString());
		//189
		final AssignmentExpression AssignmentExpression_190_Var
		 = (AssignmentExpression)Expr_173_list.get(1);
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
		Assert.assertEquals("array", PrimaryExpression_205_Var
		.getId());
		final EList<? extends EObject> Suffix_205_list = PostfixExpression_204_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_205_list);
		Assert.assertEquals(1, Suffix_205_list.size());
		//205
		final PostfixExpressionSuffixArray PostfixExpressionSuffixArray_206_Var
		 = (PostfixExpressionSuffixArray)Suffix_205_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArray_206_Var
		);
		//206
		final Expression Expression_207_Var
		 = (Expression)PostfixExpressionSuffixArray_206_Var
		.getArrayExpr();
		Assert.assertNotNull(Expression_207_Var
		);
		final EList<? extends EObject> ExprExpr_207_list = Expression_207_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_207_list);
		Assert.assertEquals(1, ExprExpr_207_list.size());
		//207
		final AssignmentExpression AssignmentExpression_208_Var
		 = (AssignmentExpression)ExprExpr_207_list.get(0);
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
		Assert.assertEquals("3", Constant2_224_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_154_Var
		.getSemi());
		//224
		final Statement Statement_225_Var
		 = (Statement)Statement_152_list.get(1);
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
		Assert.assertEquals(";", JumpStatement_226_Var
		.getSemi());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0036_SimpleIntArray.c");
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
				method.invoke(this.generator, "Test0036_SimpleIntArray.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0036_SimpleIntArray.c");
		final String expected = this.getTextFromFile(
			"res/Test0036_SimpleIntArray.c"
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


