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
import at.jku.weiner.c.parser.parser.Init;
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
import at.jku.weiner.c.parser.parser.Init;
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
import at.jku.weiner.c.parser.parser.Init;
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
import at.jku.weiner.c.parser.parser.Init;
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
import at.jku.weiner.c.parser.parser.Init;
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
import at.jku.weiner.c.parser.parser.Init;
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
		final EList<? extends EObject> Init_28_list = InitializerList_28_Var
		.getInit();
		Assert.assertNotNull(Init_28_list);
		Assert.assertEquals(6, Init_28_list.size());
		//28
		final Init Init_29_Var
		 = (Init)Init_28_list.get(0);
		Assert.assertNotNull(Init_29_Var
		);
		//29
		final Initializer Initializer_30_Var
		 = (Initializer)Init_29_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_30_Var
		);
		//30
		final AssignmentExpression AssignmentExpression_31_Var
		 = (AssignmentExpression)Initializer_30_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_31_Var
		);
		//31
		final ConditionalExpression ConditionalExpression_32_Var
		 = (ConditionalExpression)AssignmentExpression_31_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_32_Var
		);
		//32
		final LogicalOrExpression LogicalOrExpression_33_Var
		 = (LogicalOrExpression)ConditionalExpression_32_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = LogicalOrExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final LogicalAndExpression LogicalAndExpression_34_Var
		 = (LogicalAndExpression)Expr_33_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = LogicalAndExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final InclusiveOrExpression InclusiveOrExpression_35_Var
		 = (InclusiveOrExpression)Expr_34_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = InclusiveOrExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final ExclusiveOrExpression ExclusiveOrExpression_36_Var
		 = (ExclusiveOrExpression)Expr_35_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = ExclusiveOrExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final AndExpression AndExpression_37_Var
		 = (AndExpression)Expr_36_list.get(0);
		Assert.assertNotNull(AndExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = AndExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final EqualityExpression EqualityExpression_38_Var
		 = (EqualityExpression)Expr_37_list.get(0);
		Assert.assertNotNull(EqualityExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = EqualityExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final RelationalExpression RelationalExpression_39_Var
		 = (RelationalExpression)Expr_38_list.get(0);
		Assert.assertNotNull(RelationalExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = RelationalExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final ShiftExpression ShiftExpression_40_Var
		 = (ShiftExpression)Expr_39_list.get(0);
		Assert.assertNotNull(ShiftExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = ShiftExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final AdditiveExpression AdditiveExpression_41_Var
		 = (AdditiveExpression)Expr_40_list.get(0);
		Assert.assertNotNull(AdditiveExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = AdditiveExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final MultiplicativeExpression MultiplicativeExpression_42_Var
		 = (MultiplicativeExpression)Expr_41_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = MultiplicativeExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final CastExpression CastExpression_43_Var
		 = (CastExpression)Expr_42_list.get(0);
		Assert.assertNotNull(CastExpression_43_Var
		);
		//43
		final UnaryExpression UnaryExpression_44_Var
		 = (UnaryExpression)CastExpression_43_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_44_Var
		);
		//44
		final PostfixExpression PostfixExpression_45_Var
		 = (PostfixExpression)UnaryExpression_44_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = PostfixExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final PrimaryExpression PrimaryExpression_46_Var
		 = (PrimaryExpression)Expr_45_list.get(0);
		Assert.assertNotNull(PrimaryExpression_46_Var
		);
		//46
		final Constant2 Constant2_47_Var
		 = (Constant2)PrimaryExpression_46_Var
		.getConst();
		Assert.assertNotNull(Constant2_47_Var
		);
		Assert.assertEquals("1", Constant2_47_Var
		.getDec());
		//47
		final Init Init_48_Var
		 = (Init)Init_28_list.get(1);
		Assert.assertNotNull(Init_48_Var
		);
		//48
		final Initializer Initializer_49_Var
		 = (Initializer)Init_48_Var
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
		Assert.assertEquals("2", Constant2_66_Var
		.getDec());
		//66
		final Init Init_67_Var
		 = (Init)Init_28_list.get(2);
		Assert.assertNotNull(Init_67_Var
		);
		//67
		final Initializer Initializer_68_Var
		 = (Initializer)Init_67_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_68_Var
		);
		//68
		final AssignmentExpression AssignmentExpression_69_Var
		 = (AssignmentExpression)Initializer_68_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_69_Var
		);
		//69
		final ConditionalExpression ConditionalExpression_70_Var
		 = (ConditionalExpression)AssignmentExpression_69_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_70_Var
		);
		//70
		final LogicalOrExpression LogicalOrExpression_71_Var
		 = (LogicalOrExpression)ConditionalExpression_70_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = LogicalOrExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final LogicalAndExpression LogicalAndExpression_72_Var
		 = (LogicalAndExpression)Expr_71_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = LogicalAndExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final InclusiveOrExpression InclusiveOrExpression_73_Var
		 = (InclusiveOrExpression)Expr_72_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = InclusiveOrExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final ExclusiveOrExpression ExclusiveOrExpression_74_Var
		 = (ExclusiveOrExpression)Expr_73_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = ExclusiveOrExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final AndExpression AndExpression_75_Var
		 = (AndExpression)Expr_74_list.get(0);
		Assert.assertNotNull(AndExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = AndExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final EqualityExpression EqualityExpression_76_Var
		 = (EqualityExpression)Expr_75_list.get(0);
		Assert.assertNotNull(EqualityExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = EqualityExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final RelationalExpression RelationalExpression_77_Var
		 = (RelationalExpression)Expr_76_list.get(0);
		Assert.assertNotNull(RelationalExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = RelationalExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final ShiftExpression ShiftExpression_78_Var
		 = (ShiftExpression)Expr_77_list.get(0);
		Assert.assertNotNull(ShiftExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = ShiftExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final AdditiveExpression AdditiveExpression_79_Var
		 = (AdditiveExpression)Expr_78_list.get(0);
		Assert.assertNotNull(AdditiveExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = AdditiveExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final MultiplicativeExpression MultiplicativeExpression_80_Var
		 = (MultiplicativeExpression)Expr_79_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = MultiplicativeExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final CastExpression CastExpression_81_Var
		 = (CastExpression)Expr_80_list.get(0);
		Assert.assertNotNull(CastExpression_81_Var
		);
		//81
		final UnaryExpression UnaryExpression_82_Var
		 = (UnaryExpression)CastExpression_81_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_82_Var
		);
		//82
		final PostfixExpression PostfixExpression_83_Var
		 = (PostfixExpression)UnaryExpression_82_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = PostfixExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final PrimaryExpression PrimaryExpression_84_Var
		 = (PrimaryExpression)Expr_83_list.get(0);
		Assert.assertNotNull(PrimaryExpression_84_Var
		);
		//84
		final Constant2 Constant2_85_Var
		 = (Constant2)PrimaryExpression_84_Var
		.getConst();
		Assert.assertNotNull(Constant2_85_Var
		);
		Assert.assertEquals("3", Constant2_85_Var
		.getDec());
		//85
		final Init Init_86_Var
		 = (Init)Init_28_list.get(3);
		Assert.assertNotNull(Init_86_Var
		);
		//86
		final Initializer Initializer_87_Var
		 = (Initializer)Init_86_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_87_Var
		);
		//87
		final AssignmentExpression AssignmentExpression_88_Var
		 = (AssignmentExpression)Initializer_87_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_88_Var
		);
		//88
		final ConditionalExpression ConditionalExpression_89_Var
		 = (ConditionalExpression)AssignmentExpression_88_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_89_Var
		);
		//89
		final LogicalOrExpression LogicalOrExpression_90_Var
		 = (LogicalOrExpression)ConditionalExpression_89_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = LogicalOrExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final LogicalAndExpression LogicalAndExpression_91_Var
		 = (LogicalAndExpression)Expr_90_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = LogicalAndExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final InclusiveOrExpression InclusiveOrExpression_92_Var
		 = (InclusiveOrExpression)Expr_91_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = InclusiveOrExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final ExclusiveOrExpression ExclusiveOrExpression_93_Var
		 = (ExclusiveOrExpression)Expr_92_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = ExclusiveOrExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final AndExpression AndExpression_94_Var
		 = (AndExpression)Expr_93_list.get(0);
		Assert.assertNotNull(AndExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = AndExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final EqualityExpression EqualityExpression_95_Var
		 = (EqualityExpression)Expr_94_list.get(0);
		Assert.assertNotNull(EqualityExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = EqualityExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final RelationalExpression RelationalExpression_96_Var
		 = (RelationalExpression)Expr_95_list.get(0);
		Assert.assertNotNull(RelationalExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = RelationalExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final ShiftExpression ShiftExpression_97_Var
		 = (ShiftExpression)Expr_96_list.get(0);
		Assert.assertNotNull(ShiftExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = ShiftExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final AdditiveExpression AdditiveExpression_98_Var
		 = (AdditiveExpression)Expr_97_list.get(0);
		Assert.assertNotNull(AdditiveExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = AdditiveExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final MultiplicativeExpression MultiplicativeExpression_99_Var
		 = (MultiplicativeExpression)Expr_98_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = MultiplicativeExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final CastExpression CastExpression_100_Var
		 = (CastExpression)Expr_99_list.get(0);
		Assert.assertNotNull(CastExpression_100_Var
		);
		//100
		final UnaryExpression UnaryExpression_101_Var
		 = (UnaryExpression)CastExpression_100_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_101_Var
		);
		//101
		final PostfixExpression PostfixExpression_102_Var
		 = (PostfixExpression)UnaryExpression_101_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = PostfixExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final PrimaryExpression PrimaryExpression_103_Var
		 = (PrimaryExpression)Expr_102_list.get(0);
		Assert.assertNotNull(PrimaryExpression_103_Var
		);
		//103
		final Constant2 Constant2_104_Var
		 = (Constant2)PrimaryExpression_103_Var
		.getConst();
		Assert.assertNotNull(Constant2_104_Var
		);
		Assert.assertEquals("5", Constant2_104_Var
		.getDec());
		//104
		final Init Init_105_Var
		 = (Init)Init_28_list.get(4);
		Assert.assertNotNull(Init_105_Var
		);
		//105
		final Initializer Initializer_106_Var
		 = (Initializer)Init_105_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_106_Var
		);
		//106
		final AssignmentExpression AssignmentExpression_107_Var
		 = (AssignmentExpression)Initializer_106_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_107_Var
		);
		//107
		final ConditionalExpression ConditionalExpression_108_Var
		 = (ConditionalExpression)AssignmentExpression_107_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_108_Var
		);
		//108
		final LogicalOrExpression LogicalOrExpression_109_Var
		 = (LogicalOrExpression)ConditionalExpression_108_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = LogicalOrExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final LogicalAndExpression LogicalAndExpression_110_Var
		 = (LogicalAndExpression)Expr_109_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = LogicalAndExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final InclusiveOrExpression InclusiveOrExpression_111_Var
		 = (InclusiveOrExpression)Expr_110_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = InclusiveOrExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final ExclusiveOrExpression ExclusiveOrExpression_112_Var
		 = (ExclusiveOrExpression)Expr_111_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = ExclusiveOrExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final AndExpression AndExpression_113_Var
		 = (AndExpression)Expr_112_list.get(0);
		Assert.assertNotNull(AndExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = AndExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final EqualityExpression EqualityExpression_114_Var
		 = (EqualityExpression)Expr_113_list.get(0);
		Assert.assertNotNull(EqualityExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = EqualityExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final RelationalExpression RelationalExpression_115_Var
		 = (RelationalExpression)Expr_114_list.get(0);
		Assert.assertNotNull(RelationalExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = RelationalExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final ShiftExpression ShiftExpression_116_Var
		 = (ShiftExpression)Expr_115_list.get(0);
		Assert.assertNotNull(ShiftExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = ShiftExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final AdditiveExpression AdditiveExpression_117_Var
		 = (AdditiveExpression)Expr_116_list.get(0);
		Assert.assertNotNull(AdditiveExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = AdditiveExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final MultiplicativeExpression MultiplicativeExpression_118_Var
		 = (MultiplicativeExpression)Expr_117_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = MultiplicativeExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final CastExpression CastExpression_119_Var
		 = (CastExpression)Expr_118_list.get(0);
		Assert.assertNotNull(CastExpression_119_Var
		);
		//119
		final UnaryExpression UnaryExpression_120_Var
		 = (UnaryExpression)CastExpression_119_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_120_Var
		);
		//120
		final PostfixExpression PostfixExpression_121_Var
		 = (PostfixExpression)UnaryExpression_120_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = PostfixExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final PrimaryExpression PrimaryExpression_122_Var
		 = (PrimaryExpression)Expr_121_list.get(0);
		Assert.assertNotNull(PrimaryExpression_122_Var
		);
		//122
		final Constant2 Constant2_123_Var
		 = (Constant2)PrimaryExpression_122_Var
		.getConst();
		Assert.assertNotNull(Constant2_123_Var
		);
		Assert.assertEquals("7", Constant2_123_Var
		.getDec());
		//123
		final Init Init_124_Var
		 = (Init)Init_28_list.get(5);
		Assert.assertNotNull(Init_124_Var
		);
		//124
		final Initializer Initializer_125_Var
		 = (Initializer)Init_124_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_125_Var
		);
		//125
		final AssignmentExpression AssignmentExpression_126_Var
		 = (AssignmentExpression)Initializer_125_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_126_Var
		);
		//126
		final ConditionalExpression ConditionalExpression_127_Var
		 = (ConditionalExpression)AssignmentExpression_126_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_127_Var
		);
		//127
		final LogicalOrExpression LogicalOrExpression_128_Var
		 = (LogicalOrExpression)ConditionalExpression_127_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = LogicalOrExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final LogicalAndExpression LogicalAndExpression_129_Var
		 = (LogicalAndExpression)Expr_128_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = LogicalAndExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final InclusiveOrExpression InclusiveOrExpression_130_Var
		 = (InclusiveOrExpression)Expr_129_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = InclusiveOrExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final ExclusiveOrExpression ExclusiveOrExpression_131_Var
		 = (ExclusiveOrExpression)Expr_130_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = ExclusiveOrExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final AndExpression AndExpression_132_Var
		 = (AndExpression)Expr_131_list.get(0);
		Assert.assertNotNull(AndExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = AndExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final EqualityExpression EqualityExpression_133_Var
		 = (EqualityExpression)Expr_132_list.get(0);
		Assert.assertNotNull(EqualityExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = EqualityExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final RelationalExpression RelationalExpression_134_Var
		 = (RelationalExpression)Expr_133_list.get(0);
		Assert.assertNotNull(RelationalExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = RelationalExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final ShiftExpression ShiftExpression_135_Var
		 = (ShiftExpression)Expr_134_list.get(0);
		Assert.assertNotNull(ShiftExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = ShiftExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final AdditiveExpression AdditiveExpression_136_Var
		 = (AdditiveExpression)Expr_135_list.get(0);
		Assert.assertNotNull(AdditiveExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = AdditiveExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final MultiplicativeExpression MultiplicativeExpression_137_Var
		 = (MultiplicativeExpression)Expr_136_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = MultiplicativeExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final CastExpression CastExpression_138_Var
		 = (CastExpression)Expr_137_list.get(0);
		Assert.assertNotNull(CastExpression_138_Var
		);
		//138
		final UnaryExpression UnaryExpression_139_Var
		 = (UnaryExpression)CastExpression_138_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_139_Var
		);
		//139
		final PostfixExpression PostfixExpression_140_Var
		 = (PostfixExpression)UnaryExpression_139_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = PostfixExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final PrimaryExpression PrimaryExpression_141_Var
		 = (PrimaryExpression)Expr_140_list.get(0);
		Assert.assertNotNull(PrimaryExpression_141_Var
		);
		//141
		final Constant2 Constant2_142_Var
		 = (Constant2)PrimaryExpression_141_Var
		.getConst();
		Assert.assertNotNull(Constant2_142_Var
		);
		Assert.assertEquals("11", Constant2_142_Var
		.getDec());
		//142
		final ExternalDeclaration ExternalDeclaration_143_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_143_Var
		);
		//143
		final FunctionDefHead FunctionDefHead_144_Var
		 = (FunctionDefHead)ExternalDeclaration_143_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_144_Var
		);
		//144
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_145_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_144_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_145_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_145_list = FunctionDeclarationSpecifiers_145_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_145_list);
		Assert.assertEquals(1, DeclarationSpecifier_145_list.size());
		//145
		final TypeSpecifier TypeSpecifier_146_Var
		 = (TypeSpecifier)DeclarationSpecifier_145_list.get(0);
		Assert.assertNotNull(TypeSpecifier_146_Var
		);
		Assert.assertEquals("int", TypeSpecifier_146_Var
		.getName());
		//146
		final Declarator Declarator_147_Var
		 = (Declarator)FunctionDefHead_144_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_147_Var
		);
		//147
		final DirectDeclarator DirectDeclarator_148_Var
		 = (DirectDeclarator)Declarator_147_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_148_Var
		);
		Assert.assertEquals("main", DirectDeclarator_148_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_148_list = DirectDeclarator_148_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_148_list);
		Assert.assertEquals(1, DeclaratorSuffix_148_list.size());
		//148
		final DeclaratorSuffix DeclaratorSuffix_149_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_148_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_149_Var
		);
		//149
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_150_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_149_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_150_Var
		);
		final EList<? extends EObject> ParameterTypeList_150_list = DirectDeclaratorLastSuffix_150_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_150_list);
		Assert.assertEquals(1, ParameterTypeList_150_list.size());
		//150
		final ParameterTypeList ParameterTypeList_151_Var
		 = (ParameterTypeList)ParameterTypeList_150_list.get(0);
		Assert.assertNotNull(ParameterTypeList_151_Var
		);
		//151
		final ParameterList ParameterList_152_Var
		 = (ParameterList)ParameterTypeList_151_Var
		.getList();
		Assert.assertNotNull(ParameterList_152_Var
		);
		final EList<? extends EObject> ParameterDeclaration_152_list = ParameterList_152_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_152_list);
		Assert.assertEquals(1, ParameterDeclaration_152_list.size());
		//152
		final ParameterDeclaration ParameterDeclaration_153_Var
		 = (ParameterDeclaration)ParameterDeclaration_152_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_153_Var
		);
		//153
		final DeclarationSpecifiers DeclarationSpecifiers_154_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_153_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_154_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_154_list = DeclarationSpecifiers_154_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_154_list);
		Assert.assertEquals(1, DeclarationSpecifier_154_list.size());
		//154
		final TypeSpecifier TypeSpecifier_155_Var
		 = (TypeSpecifier)DeclarationSpecifier_154_list.get(0);
		Assert.assertNotNull(TypeSpecifier_155_Var
		);
		Assert.assertEquals("void", TypeSpecifier_155_Var
		.getName());
		//155
		final FunctionDefinition FunctionDefinition_156_Var
		 = (FunctionDefinition)ExternalDeclaration_143_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_156_Var
		);
		//156
		final BodyStatement BodyStatement_157_Var
		 = (BodyStatement)FunctionDefinition_156_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_157_Var
		);
		final EList<? extends EObject> BlockList_157_list = BodyStatement_157_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_157_list);
		Assert.assertEquals(1, BlockList_157_list.size());
		//157
		final BlockList BlockList_158_Var
		 = (BlockList)BlockList_157_list.get(0);
		Assert.assertNotNull(BlockList_158_Var
		);
		final EList<? extends EObject> Statement_158_list = BlockList_158_Var
		.getStatement();
		Assert.assertNotNull(Statement_158_list);
		Assert.assertEquals(2, Statement_158_list.size());
		//158
		final Statement Statement_159_Var
		 = (Statement)Statement_158_list.get(0);
		Assert.assertNotNull(Statement_159_Var
		);
		//159
		final ExpressionStatement ExpressionStatement_160_Var
		 = (ExpressionStatement)Statement_159_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_160_Var
		);
		//160
		final Expression Expression_161_Var
		 = (Expression)ExpressionStatement_160_Var
		.getExpression();
		Assert.assertNotNull(Expression_161_Var
		);
		final EList<? extends EObject> ExprExpr_161_list = Expression_161_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_161_list);
		Assert.assertEquals(1, ExprExpr_161_list.size());
		//161
		final AssignmentExpression AssignmentExpression_162_Var
		 = (AssignmentExpression)ExprExpr_161_list.get(0);
		Assert.assertNotNull(AssignmentExpression_162_Var
		);
		//162
		final ConditionalExpression ConditionalExpression_163_Var
		 = (ConditionalExpression)AssignmentExpression_162_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_163_Var
		);
		//163
		final LogicalOrExpression LogicalOrExpression_164_Var
		 = (LogicalOrExpression)ConditionalExpression_163_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_164_Var
		);
		final EList<? extends EObject> Expr_164_list = LogicalOrExpression_164_Var
		.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		//164
		final LogicalAndExpression LogicalAndExpression_165_Var
		 = (LogicalAndExpression)Expr_164_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_165_Var
		);
		final EList<? extends EObject> Expr_165_list = LogicalAndExpression_165_Var
		.getExpr();
		Assert.assertNotNull(Expr_165_list);
		Assert.assertEquals(1, Expr_165_list.size());
		//165
		final InclusiveOrExpression InclusiveOrExpression_166_Var
		 = (InclusiveOrExpression)Expr_165_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_166_Var
		);
		final EList<? extends EObject> Expr_166_list = InclusiveOrExpression_166_Var
		.getExpr();
		Assert.assertNotNull(Expr_166_list);
		Assert.assertEquals(1, Expr_166_list.size());
		//166
		final ExclusiveOrExpression ExclusiveOrExpression_167_Var
		 = (ExclusiveOrExpression)Expr_166_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_167_Var
		);
		final EList<? extends EObject> Expr_167_list = ExclusiveOrExpression_167_Var
		.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(1, Expr_167_list.size());
		//167
		final AndExpression AndExpression_168_Var
		 = (AndExpression)Expr_167_list.get(0);
		Assert.assertNotNull(AndExpression_168_Var
		);
		final EList<? extends EObject> Expr_168_list = AndExpression_168_Var
		.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(1, Expr_168_list.size());
		//168
		final EqualityExpression EqualityExpression_169_Var
		 = (EqualityExpression)Expr_168_list.get(0);
		Assert.assertNotNull(EqualityExpression_169_Var
		);
		final EList<? extends EObject> Expr_169_list = EqualityExpression_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		//169
		final RelationalExpression RelationalExpression_170_Var
		 = (RelationalExpression)Expr_169_list.get(0);
		Assert.assertNotNull(RelationalExpression_170_Var
		);
		final EList<? extends EObject> Expr_170_list = RelationalExpression_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		//170
		final ShiftExpression ShiftExpression_171_Var
		 = (ShiftExpression)Expr_170_list.get(0);
		Assert.assertNotNull(ShiftExpression_171_Var
		);
		final EList<? extends EObject> Expr_171_list = ShiftExpression_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		//171
		final AdditiveExpression AdditiveExpression_172_Var
		 = (AdditiveExpression)Expr_171_list.get(0);
		Assert.assertNotNull(AdditiveExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = AdditiveExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final MultiplicativeExpression MultiplicativeExpression_173_Var
		 = (MultiplicativeExpression)Expr_172_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = MultiplicativeExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final CastExpression CastExpression_174_Var
		 = (CastExpression)Expr_173_list.get(0);
		Assert.assertNotNull(CastExpression_174_Var
		);
		//174
		final UnaryExpression UnaryExpression_175_Var
		 = (UnaryExpression)CastExpression_174_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_175_Var
		);
		//175
		final PostfixExpression PostfixExpression_176_Var
		 = (PostfixExpression)UnaryExpression_175_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = PostfixExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final PrimaryExpression PrimaryExpression_177_Var
		 = (PrimaryExpression)Expr_176_list.get(0);
		Assert.assertNotNull(PrimaryExpression_177_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_177_Var
		.getId());
		final EList<? extends EObject> Suffix_177_list = PostfixExpression_176_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_177_list);
		Assert.assertEquals(1, Suffix_177_list.size());
		//177
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_178_Var
		 = (PostfixExpressionSuffixArgument)Suffix_177_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_178_Var
		);
		//178
		final ArgumentExpressionList ArgumentExpressionList_179_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_178_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_179_Var
		);
		final EList<? extends EObject> Expr_179_list = ArgumentExpressionList_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(2, Expr_179_list.size());
		//179
		final AssignmentExpression AssignmentExpression_180_Var
		 = (AssignmentExpression)Expr_179_list.get(0);
		Assert.assertNotNull(AssignmentExpression_180_Var
		);
		//180
		final ConditionalExpression ConditionalExpression_181_Var
		 = (ConditionalExpression)AssignmentExpression_180_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_181_Var
		);
		//181
		final LogicalOrExpression LogicalOrExpression_182_Var
		 = (LogicalOrExpression)ConditionalExpression_181_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_182_Var
		);
		final EList<? extends EObject> Expr_182_list = LogicalOrExpression_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(1, Expr_182_list.size());
		//182
		final LogicalAndExpression LogicalAndExpression_183_Var
		 = (LogicalAndExpression)Expr_182_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = LogicalAndExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final InclusiveOrExpression InclusiveOrExpression_184_Var
		 = (InclusiveOrExpression)Expr_183_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = InclusiveOrExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final ExclusiveOrExpression ExclusiveOrExpression_185_Var
		 = (ExclusiveOrExpression)Expr_184_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_185_Var
		);
		final EList<? extends EObject> Expr_185_list = ExclusiveOrExpression_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final AndExpression AndExpression_186_Var
		 = (AndExpression)Expr_185_list.get(0);
		Assert.assertNotNull(AndExpression_186_Var
		);
		final EList<? extends EObject> Expr_186_list = AndExpression_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(1, Expr_186_list.size());
		//186
		final EqualityExpression EqualityExpression_187_Var
		 = (EqualityExpression)Expr_186_list.get(0);
		Assert.assertNotNull(EqualityExpression_187_Var
		);
		final EList<? extends EObject> Expr_187_list = EqualityExpression_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(1, Expr_187_list.size());
		//187
		final RelationalExpression RelationalExpression_188_Var
		 = (RelationalExpression)Expr_187_list.get(0);
		Assert.assertNotNull(RelationalExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = RelationalExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final ShiftExpression ShiftExpression_189_Var
		 = (ShiftExpression)Expr_188_list.get(0);
		Assert.assertNotNull(ShiftExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = ShiftExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final AdditiveExpression AdditiveExpression_190_Var
		 = (AdditiveExpression)Expr_189_list.get(0);
		Assert.assertNotNull(AdditiveExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = AdditiveExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final MultiplicativeExpression MultiplicativeExpression_191_Var
		 = (MultiplicativeExpression)Expr_190_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = MultiplicativeExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final CastExpression CastExpression_192_Var
		 = (CastExpression)Expr_191_list.get(0);
		Assert.assertNotNull(CastExpression_192_Var
		);
		//192
		final UnaryExpression UnaryExpression_193_Var
		 = (UnaryExpression)CastExpression_192_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_193_Var
		);
		//193
		final PostfixExpression PostfixExpression_194_Var
		 = (PostfixExpression)UnaryExpression_193_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = PostfixExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final PrimaryExpression PrimaryExpression_195_Var
		 = (PrimaryExpression)Expr_194_list.get(0);
		Assert.assertNotNull(PrimaryExpression_195_Var
		);
		Assert.assertEquals("[\"%d\\n\"]", PrimaryExpression_195_Var
		.getString().toString());
		//195
		final AssignmentExpression AssignmentExpression_196_Var
		 = (AssignmentExpression)Expr_179_list.get(1);
		Assert.assertNotNull(AssignmentExpression_196_Var
		);
		//196
		final ConditionalExpression ConditionalExpression_197_Var
		 = (ConditionalExpression)AssignmentExpression_196_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_197_Var
		);
		//197
		final LogicalOrExpression LogicalOrExpression_198_Var
		 = (LogicalOrExpression)ConditionalExpression_197_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = LogicalOrExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final LogicalAndExpression LogicalAndExpression_199_Var
		 = (LogicalAndExpression)Expr_198_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = LogicalAndExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final InclusiveOrExpression InclusiveOrExpression_200_Var
		 = (InclusiveOrExpression)Expr_199_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = InclusiveOrExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final ExclusiveOrExpression ExclusiveOrExpression_201_Var
		 = (ExclusiveOrExpression)Expr_200_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = ExclusiveOrExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final AndExpression AndExpression_202_Var
		 = (AndExpression)Expr_201_list.get(0);
		Assert.assertNotNull(AndExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = AndExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final EqualityExpression EqualityExpression_203_Var
		 = (EqualityExpression)Expr_202_list.get(0);
		Assert.assertNotNull(EqualityExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = EqualityExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final RelationalExpression RelationalExpression_204_Var
		 = (RelationalExpression)Expr_203_list.get(0);
		Assert.assertNotNull(RelationalExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = RelationalExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final ShiftExpression ShiftExpression_205_Var
		 = (ShiftExpression)Expr_204_list.get(0);
		Assert.assertNotNull(ShiftExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = ShiftExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final AdditiveExpression AdditiveExpression_206_Var
		 = (AdditiveExpression)Expr_205_list.get(0);
		Assert.assertNotNull(AdditiveExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = AdditiveExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final MultiplicativeExpression MultiplicativeExpression_207_Var
		 = (MultiplicativeExpression)Expr_206_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = MultiplicativeExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final CastExpression CastExpression_208_Var
		 = (CastExpression)Expr_207_list.get(0);
		Assert.assertNotNull(CastExpression_208_Var
		);
		//208
		final UnaryExpression UnaryExpression_209_Var
		 = (UnaryExpression)CastExpression_208_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_209_Var
		);
		//209
		final PostfixExpression PostfixExpression_210_Var
		 = (PostfixExpression)UnaryExpression_209_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = PostfixExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final PrimaryExpression PrimaryExpression_211_Var
		 = (PrimaryExpression)Expr_210_list.get(0);
		Assert.assertNotNull(PrimaryExpression_211_Var
		);
		Assert.assertEquals("array", PrimaryExpression_211_Var
		.getId());
		final EList<? extends EObject> Suffix_211_list = PostfixExpression_210_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_211_list);
		Assert.assertEquals(1, Suffix_211_list.size());
		//211
		final PostfixExpressionSuffixArray PostfixExpressionSuffixArray_212_Var
		 = (PostfixExpressionSuffixArray)Suffix_211_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArray_212_Var
		);
		//212
		final Expression Expression_213_Var
		 = (Expression)PostfixExpressionSuffixArray_212_Var
		.getArrayExpr();
		Assert.assertNotNull(Expression_213_Var
		);
		final EList<? extends EObject> ExprExpr_213_list = Expression_213_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_213_list);
		Assert.assertEquals(1, ExprExpr_213_list.size());
		//213
		final AssignmentExpression AssignmentExpression_214_Var
		 = (AssignmentExpression)ExprExpr_213_list.get(0);
		Assert.assertNotNull(AssignmentExpression_214_Var
		);
		//214
		final ConditionalExpression ConditionalExpression_215_Var
		 = (ConditionalExpression)AssignmentExpression_214_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_215_Var
		);
		//215
		final LogicalOrExpression LogicalOrExpression_216_Var
		 = (LogicalOrExpression)ConditionalExpression_215_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = LogicalOrExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final LogicalAndExpression LogicalAndExpression_217_Var
		 = (LogicalAndExpression)Expr_216_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = LogicalAndExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final InclusiveOrExpression InclusiveOrExpression_218_Var
		 = (InclusiveOrExpression)Expr_217_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = InclusiveOrExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final ExclusiveOrExpression ExclusiveOrExpression_219_Var
		 = (ExclusiveOrExpression)Expr_218_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = ExclusiveOrExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final AndExpression AndExpression_220_Var
		 = (AndExpression)Expr_219_list.get(0);
		Assert.assertNotNull(AndExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = AndExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final EqualityExpression EqualityExpression_221_Var
		 = (EqualityExpression)Expr_220_list.get(0);
		Assert.assertNotNull(EqualityExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = EqualityExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final RelationalExpression RelationalExpression_222_Var
		 = (RelationalExpression)Expr_221_list.get(0);
		Assert.assertNotNull(RelationalExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = RelationalExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final ShiftExpression ShiftExpression_223_Var
		 = (ShiftExpression)Expr_222_list.get(0);
		Assert.assertNotNull(ShiftExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = ShiftExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final AdditiveExpression AdditiveExpression_224_Var
		 = (AdditiveExpression)Expr_223_list.get(0);
		Assert.assertNotNull(AdditiveExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = AdditiveExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final MultiplicativeExpression MultiplicativeExpression_225_Var
		 = (MultiplicativeExpression)Expr_224_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = MultiplicativeExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final CastExpression CastExpression_226_Var
		 = (CastExpression)Expr_225_list.get(0);
		Assert.assertNotNull(CastExpression_226_Var
		);
		//226
		final UnaryExpression UnaryExpression_227_Var
		 = (UnaryExpression)CastExpression_226_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_227_Var
		);
		//227
		final PostfixExpression PostfixExpression_228_Var
		 = (PostfixExpression)UnaryExpression_227_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = PostfixExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final PrimaryExpression PrimaryExpression_229_Var
		 = (PrimaryExpression)Expr_228_list.get(0);
		Assert.assertNotNull(PrimaryExpression_229_Var
		);
		//229
		final Constant2 Constant2_230_Var
		 = (Constant2)PrimaryExpression_229_Var
		.getConst();
		Assert.assertNotNull(Constant2_230_Var
		);
		Assert.assertEquals("3", Constant2_230_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_160_Var
		.getSemi());
		//230
		final Statement Statement_231_Var
		 = (Statement)Statement_158_list.get(1);
		Assert.assertNotNull(Statement_231_Var
		);
		//231
		final JumpStatement JumpStatement_232_Var
		 = (JumpStatement)Statement_231_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_232_Var
		);
		//232
		final Expression Expression_233_Var
		 = (Expression)JumpStatement_232_Var
		.getExpr();
		Assert.assertNotNull(Expression_233_Var
		);
		final EList<? extends EObject> ExprExpr_233_list = Expression_233_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_233_list);
		Assert.assertEquals(1, ExprExpr_233_list.size());
		//233
		final AssignmentExpression AssignmentExpression_234_Var
		 = (AssignmentExpression)ExprExpr_233_list.get(0);
		Assert.assertNotNull(AssignmentExpression_234_Var
		);
		//234
		final ConditionalExpression ConditionalExpression_235_Var
		 = (ConditionalExpression)AssignmentExpression_234_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_235_Var
		);
		//235
		final LogicalOrExpression LogicalOrExpression_236_Var
		 = (LogicalOrExpression)ConditionalExpression_235_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = LogicalOrExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final LogicalAndExpression LogicalAndExpression_237_Var
		 = (LogicalAndExpression)Expr_236_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = LogicalAndExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final InclusiveOrExpression InclusiveOrExpression_238_Var
		 = (InclusiveOrExpression)Expr_237_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = InclusiveOrExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final ExclusiveOrExpression ExclusiveOrExpression_239_Var
		 = (ExclusiveOrExpression)Expr_238_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = ExclusiveOrExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final AndExpression AndExpression_240_Var
		 = (AndExpression)Expr_239_list.get(0);
		Assert.assertNotNull(AndExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = AndExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final EqualityExpression EqualityExpression_241_Var
		 = (EqualityExpression)Expr_240_list.get(0);
		Assert.assertNotNull(EqualityExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = EqualityExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final RelationalExpression RelationalExpression_242_Var
		 = (RelationalExpression)Expr_241_list.get(0);
		Assert.assertNotNull(RelationalExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = RelationalExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final ShiftExpression ShiftExpression_243_Var
		 = (ShiftExpression)Expr_242_list.get(0);
		Assert.assertNotNull(ShiftExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = ShiftExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final AdditiveExpression AdditiveExpression_244_Var
		 = (AdditiveExpression)Expr_243_list.get(0);
		Assert.assertNotNull(AdditiveExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = AdditiveExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final MultiplicativeExpression MultiplicativeExpression_245_Var
		 = (MultiplicativeExpression)Expr_244_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = MultiplicativeExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final CastExpression CastExpression_246_Var
		 = (CastExpression)Expr_245_list.get(0);
		Assert.assertNotNull(CastExpression_246_Var
		);
		//246
		final UnaryExpression UnaryExpression_247_Var
		 = (UnaryExpression)CastExpression_246_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_247_Var
		);
		//247
		final PostfixExpression PostfixExpression_248_Var
		 = (PostfixExpression)UnaryExpression_247_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = PostfixExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final PrimaryExpression PrimaryExpression_249_Var
		 = (PrimaryExpression)Expr_248_list.get(0);
		Assert.assertNotNull(PrimaryExpression_249_Var
		);
		//249
		final Constant2 Constant2_250_Var
		 = (Constant2)PrimaryExpression_249_Var
		.getConst();
		Assert.assertNotNull(Constant2_250_Var
		);
		Assert.assertEquals("0", Constant2_250_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_232_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_232_Var
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


