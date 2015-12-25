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
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0036_SimpleIntArray.c");
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
		Assert.assertEquals(2, External_2_list.size());
		//2
		final ExternalDeclaration ExternalDeclaration_3_Var
		 = (ExternalDeclaration)External_2_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_3_Var
		);
		//3
		final Declaration Declaration_4_Var
		 = (Declaration)ExternalDeclaration_3_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_4_Var
		);
		//4
		final DeclarationSpecifiers DeclarationSpecifiers_5_Var
		 = (DeclarationSpecifiers)Declaration_4_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_5_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_5_list = DeclarationSpecifiers_5_Var
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
		final EList<? extends EObject> InitDeclaratorList_6_list = Declaration_4_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_6_list);
		Assert.assertEquals(1, InitDeclaratorList_6_list.size());
		//6
		final InitDeclaratorList InitDeclaratorList_7_Var
		 = (InitDeclaratorList)InitDeclaratorList_6_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_7_Var
		);
		final EList<? extends EObject> InitDeclarator_7_list = InitDeclaratorList_7_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_7_list);
		Assert.assertEquals(1, InitDeclarator_7_list.size());
		//7
		final InitDeclarator InitDeclarator_8_Var
		 = (InitDeclarator)InitDeclarator_7_list.get(0);
		Assert.assertNotNull(InitDeclarator_8_Var
		);
		//8
		final Declarator Declarator_9_Var
		 = (Declarator)InitDeclarator_8_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_9_Var
		);
		//9
		final DirectDeclarator DirectDeclarator_10_Var
		 = (DirectDeclarator)Declarator_9_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_10_Var
		);
		Assert.assertEquals("array", DirectDeclarator_10_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_10_list = DirectDeclarator_10_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_10_list);
		Assert.assertEquals(1, DeclaratorSuffix_10_list.size());
		//10
		final DeclaratorSuffix DeclaratorSuffix_11_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_10_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_11_Var
		);
		//11
		final AssignmentExpression AssignmentExpression_12_Var
		 = (AssignmentExpression)DeclaratorSuffix_11_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_12_Var
		);
		//12
		final ConditionalExpression ConditionalExpression_13_Var
		 = (ConditionalExpression)AssignmentExpression_12_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_13_Var
		);
		//13
		final LogicalOrExpression LogicalOrExpression_14_Var
		 = (LogicalOrExpression)ConditionalExpression_13_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = LogicalOrExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		//14
		final LogicalAndExpression LogicalAndExpression_15_Var
		 = (LogicalAndExpression)Expr_14_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = LogicalAndExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final InclusiveOrExpression InclusiveOrExpression_16_Var
		 = (InclusiveOrExpression)Expr_15_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = InclusiveOrExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final ExclusiveOrExpression ExclusiveOrExpression_17_Var
		 = (ExclusiveOrExpression)Expr_16_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = ExclusiveOrExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final AndExpression AndExpression_18_Var
		 = (AndExpression)Expr_17_list.get(0);
		Assert.assertNotNull(AndExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = AndExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final EqualityExpression EqualityExpression_19_Var
		 = (EqualityExpression)Expr_18_list.get(0);
		Assert.assertNotNull(EqualityExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = EqualityExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final RelationalExpression RelationalExpression_20_Var
		 = (RelationalExpression)Expr_19_list.get(0);
		Assert.assertNotNull(RelationalExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = RelationalExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final ShiftExpression ShiftExpression_21_Var
		 = (ShiftExpression)Expr_20_list.get(0);
		Assert.assertNotNull(ShiftExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = ShiftExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final AdditiveExpression AdditiveExpression_22_Var
		 = (AdditiveExpression)Expr_21_list.get(0);
		Assert.assertNotNull(AdditiveExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = AdditiveExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final MultiplicativeExpression MultiplicativeExpression_23_Var
		 = (MultiplicativeExpression)Expr_22_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = MultiplicativeExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final CastExpression CastExpression_24_Var
		 = (CastExpression)Expr_23_list.get(0);
		Assert.assertNotNull(CastExpression_24_Var
		);
		//24
		final UnaryExpression UnaryExpression_25_Var
		 = (UnaryExpression)CastExpression_24_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_25_Var
		);
		//25
		final PostfixExpression PostfixExpression_26_Var
		 = (PostfixExpression)UnaryExpression_25_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = PostfixExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final PrimaryExpression PrimaryExpression_27_Var
		 = (PrimaryExpression)Expr_26_list.get(0);
		Assert.assertNotNull(PrimaryExpression_27_Var
		);
		//27
		final Constant2 Constant2_28_Var
		 = (Constant2)PrimaryExpression_27_Var
		.getConst();
		Assert.assertNotNull(Constant2_28_Var
		);
		Assert.assertEquals("6", Constant2_28_Var
		.getDec());
		//28
		final Initializer Initializer_29_Var
		 = (Initializer)InitDeclarator_8_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_29_Var
		);
		//29
		final InitializerList InitializerList_30_Var
		 = (InitializerList)Initializer_29_Var
		.getList();
		Assert.assertNotNull(InitializerList_30_Var
		);
		final EList<? extends EObject> Initializer_30_list = InitializerList_30_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_30_list);
		Assert.assertEquals(6, Initializer_30_list.size());
		//30
		final Initializer Initializer_31_Var
		 = (Initializer)Initializer_30_list.get(0);
		Assert.assertNotNull(Initializer_31_Var
		);
		//31
		final AssignmentExpression AssignmentExpression_32_Var
		 = (AssignmentExpression)Initializer_31_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_32_Var
		);
		//32
		final ConditionalExpression ConditionalExpression_33_Var
		 = (ConditionalExpression)AssignmentExpression_32_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_33_Var
		);
		//33
		final LogicalOrExpression LogicalOrExpression_34_Var
		 = (LogicalOrExpression)ConditionalExpression_33_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = LogicalOrExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final LogicalAndExpression LogicalAndExpression_35_Var
		 = (LogicalAndExpression)Expr_34_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = LogicalAndExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final InclusiveOrExpression InclusiveOrExpression_36_Var
		 = (InclusiveOrExpression)Expr_35_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = InclusiveOrExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final ExclusiveOrExpression ExclusiveOrExpression_37_Var
		 = (ExclusiveOrExpression)Expr_36_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = ExclusiveOrExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final AndExpression AndExpression_38_Var
		 = (AndExpression)Expr_37_list.get(0);
		Assert.assertNotNull(AndExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = AndExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final EqualityExpression EqualityExpression_39_Var
		 = (EqualityExpression)Expr_38_list.get(0);
		Assert.assertNotNull(EqualityExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = EqualityExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final RelationalExpression RelationalExpression_40_Var
		 = (RelationalExpression)Expr_39_list.get(0);
		Assert.assertNotNull(RelationalExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = RelationalExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final ShiftExpression ShiftExpression_41_Var
		 = (ShiftExpression)Expr_40_list.get(0);
		Assert.assertNotNull(ShiftExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = ShiftExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final AdditiveExpression AdditiveExpression_42_Var
		 = (AdditiveExpression)Expr_41_list.get(0);
		Assert.assertNotNull(AdditiveExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = AdditiveExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final MultiplicativeExpression MultiplicativeExpression_43_Var
		 = (MultiplicativeExpression)Expr_42_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = MultiplicativeExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final CastExpression CastExpression_44_Var
		 = (CastExpression)Expr_43_list.get(0);
		Assert.assertNotNull(CastExpression_44_Var
		);
		//44
		final UnaryExpression UnaryExpression_45_Var
		 = (UnaryExpression)CastExpression_44_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_45_Var
		);
		//45
		final PostfixExpression PostfixExpression_46_Var
		 = (PostfixExpression)UnaryExpression_45_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = PostfixExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final PrimaryExpression PrimaryExpression_47_Var
		 = (PrimaryExpression)Expr_46_list.get(0);
		Assert.assertNotNull(PrimaryExpression_47_Var
		);
		//47
		final Constant2 Constant2_48_Var
		 = (Constant2)PrimaryExpression_47_Var
		.getConst();
		Assert.assertNotNull(Constant2_48_Var
		);
		Assert.assertEquals("1", Constant2_48_Var
		.getDec());
		//48
		final Initializer Initializer_49_Var
		 = (Initializer)Initializer_30_list.get(1);
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
		final Initializer Initializer_67_Var
		 = (Initializer)Initializer_30_list.get(2);
		Assert.assertNotNull(Initializer_67_Var
		);
		//67
		final AssignmentExpression AssignmentExpression_68_Var
		 = (AssignmentExpression)Initializer_67_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_68_Var
		);
		//68
		final ConditionalExpression ConditionalExpression_69_Var
		 = (ConditionalExpression)AssignmentExpression_68_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_69_Var
		);
		//69
		final LogicalOrExpression LogicalOrExpression_70_Var
		 = (LogicalOrExpression)ConditionalExpression_69_Var
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
		Assert.assertEquals("3", Constant2_84_Var
		.getDec());
		//84
		final Initializer Initializer_85_Var
		 = (Initializer)Initializer_30_list.get(3);
		Assert.assertNotNull(Initializer_85_Var
		);
		//85
		final AssignmentExpression AssignmentExpression_86_Var
		 = (AssignmentExpression)Initializer_85_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_86_Var
		);
		//86
		final ConditionalExpression ConditionalExpression_87_Var
		 = (ConditionalExpression)AssignmentExpression_86_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_87_Var
		);
		//87
		final LogicalOrExpression LogicalOrExpression_88_Var
		 = (LogicalOrExpression)ConditionalExpression_87_Var
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
		Assert.assertEquals("5", Constant2_102_Var
		.getDec());
		//102
		final Initializer Initializer_103_Var
		 = (Initializer)Initializer_30_list.get(4);
		Assert.assertNotNull(Initializer_103_Var
		);
		//103
		final AssignmentExpression AssignmentExpression_104_Var
		 = (AssignmentExpression)Initializer_103_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_104_Var
		);
		//104
		final ConditionalExpression ConditionalExpression_105_Var
		 = (ConditionalExpression)AssignmentExpression_104_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_105_Var
		);
		//105
		final LogicalOrExpression LogicalOrExpression_106_Var
		 = (LogicalOrExpression)ConditionalExpression_105_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = LogicalOrExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final LogicalAndExpression LogicalAndExpression_107_Var
		 = (LogicalAndExpression)Expr_106_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = LogicalAndExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final InclusiveOrExpression InclusiveOrExpression_108_Var
		 = (InclusiveOrExpression)Expr_107_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = InclusiveOrExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final ExclusiveOrExpression ExclusiveOrExpression_109_Var
		 = (ExclusiveOrExpression)Expr_108_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = ExclusiveOrExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final AndExpression AndExpression_110_Var
		 = (AndExpression)Expr_109_list.get(0);
		Assert.assertNotNull(AndExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = AndExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final EqualityExpression EqualityExpression_111_Var
		 = (EqualityExpression)Expr_110_list.get(0);
		Assert.assertNotNull(EqualityExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = EqualityExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final RelationalExpression RelationalExpression_112_Var
		 = (RelationalExpression)Expr_111_list.get(0);
		Assert.assertNotNull(RelationalExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = RelationalExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final ShiftExpression ShiftExpression_113_Var
		 = (ShiftExpression)Expr_112_list.get(0);
		Assert.assertNotNull(ShiftExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = ShiftExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final AdditiveExpression AdditiveExpression_114_Var
		 = (AdditiveExpression)Expr_113_list.get(0);
		Assert.assertNotNull(AdditiveExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = AdditiveExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final MultiplicativeExpression MultiplicativeExpression_115_Var
		 = (MultiplicativeExpression)Expr_114_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = MultiplicativeExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final CastExpression CastExpression_116_Var
		 = (CastExpression)Expr_115_list.get(0);
		Assert.assertNotNull(CastExpression_116_Var
		);
		//116
		final UnaryExpression UnaryExpression_117_Var
		 = (UnaryExpression)CastExpression_116_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_117_Var
		);
		//117
		final PostfixExpression PostfixExpression_118_Var
		 = (PostfixExpression)UnaryExpression_117_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = PostfixExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final PrimaryExpression PrimaryExpression_119_Var
		 = (PrimaryExpression)Expr_118_list.get(0);
		Assert.assertNotNull(PrimaryExpression_119_Var
		);
		//119
		final Constant2 Constant2_120_Var
		 = (Constant2)PrimaryExpression_119_Var
		.getConst();
		Assert.assertNotNull(Constant2_120_Var
		);
		Assert.assertEquals("7", Constant2_120_Var
		.getDec());
		//120
		final Initializer Initializer_121_Var
		 = (Initializer)Initializer_30_list.get(5);
		Assert.assertNotNull(Initializer_121_Var
		);
		//121
		final AssignmentExpression AssignmentExpression_122_Var
		 = (AssignmentExpression)Initializer_121_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_122_Var
		);
		//122
		final ConditionalExpression ConditionalExpression_123_Var
		 = (ConditionalExpression)AssignmentExpression_122_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_123_Var
		);
		//123
		final LogicalOrExpression LogicalOrExpression_124_Var
		 = (LogicalOrExpression)ConditionalExpression_123_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = LogicalOrExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final LogicalAndExpression LogicalAndExpression_125_Var
		 = (LogicalAndExpression)Expr_124_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = LogicalAndExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final InclusiveOrExpression InclusiveOrExpression_126_Var
		 = (InclusiveOrExpression)Expr_125_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = InclusiveOrExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final ExclusiveOrExpression ExclusiveOrExpression_127_Var
		 = (ExclusiveOrExpression)Expr_126_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = ExclusiveOrExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final AndExpression AndExpression_128_Var
		 = (AndExpression)Expr_127_list.get(0);
		Assert.assertNotNull(AndExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = AndExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final EqualityExpression EqualityExpression_129_Var
		 = (EqualityExpression)Expr_128_list.get(0);
		Assert.assertNotNull(EqualityExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = EqualityExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final RelationalExpression RelationalExpression_130_Var
		 = (RelationalExpression)Expr_129_list.get(0);
		Assert.assertNotNull(RelationalExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = RelationalExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final ShiftExpression ShiftExpression_131_Var
		 = (ShiftExpression)Expr_130_list.get(0);
		Assert.assertNotNull(ShiftExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = ShiftExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final AdditiveExpression AdditiveExpression_132_Var
		 = (AdditiveExpression)Expr_131_list.get(0);
		Assert.assertNotNull(AdditiveExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = AdditiveExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final MultiplicativeExpression MultiplicativeExpression_133_Var
		 = (MultiplicativeExpression)Expr_132_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = MultiplicativeExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final CastExpression CastExpression_134_Var
		 = (CastExpression)Expr_133_list.get(0);
		Assert.assertNotNull(CastExpression_134_Var
		);
		//134
		final UnaryExpression UnaryExpression_135_Var
		 = (UnaryExpression)CastExpression_134_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_135_Var
		);
		//135
		final PostfixExpression PostfixExpression_136_Var
		 = (PostfixExpression)UnaryExpression_135_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = PostfixExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final PrimaryExpression PrimaryExpression_137_Var
		 = (PrimaryExpression)Expr_136_list.get(0);
		Assert.assertNotNull(PrimaryExpression_137_Var
		);
		//137
		final Constant2 Constant2_138_Var
		 = (Constant2)PrimaryExpression_137_Var
		.getConst();
		Assert.assertNotNull(Constant2_138_Var
		);
		Assert.assertEquals("11", Constant2_138_Var
		.getDec());
		//138
		final ExternalDeclaration ExternalDeclaration_139_Var
		 = (ExternalDeclaration)External_2_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_139_Var
		);
		//139
		final FunctionDefHead FunctionDefHead_140_Var
		 = (FunctionDefHead)ExternalDeclaration_139_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_140_Var
		);
		//140
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_141_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_140_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_141_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_141_list = FunctionDeclarationSpecifiers_141_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_141_list);
		Assert.assertEquals(1, DeclarationSpecifier_141_list.size());
		//141
		final TypeSpecifier TypeSpecifier_142_Var
		 = (TypeSpecifier)DeclarationSpecifier_141_list.get(0);
		Assert.assertNotNull(TypeSpecifier_142_Var
		);
		Assert.assertEquals("int", TypeSpecifier_142_Var
		.getName());
		//142
		final Declarator Declarator_143_Var
		 = (Declarator)FunctionDefHead_140_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_143_Var
		);
		//143
		final DirectDeclarator DirectDeclarator_144_Var
		 = (DirectDeclarator)Declarator_143_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_144_Var
		);
		Assert.assertEquals("main", DirectDeclarator_144_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_144_list = DirectDeclarator_144_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_144_list);
		Assert.assertEquals(1, DeclaratorSuffix_144_list.size());
		//144
		final DeclaratorSuffix DeclaratorSuffix_145_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_144_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_145_Var
		);
		//145
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_146_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_145_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_146_Var
		);
		final EList<? extends EObject> ParameterTypeList_146_list = DirectDeclaratorLastSuffix_146_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_146_list);
		Assert.assertEquals(1, ParameterTypeList_146_list.size());
		//146
		final ParameterTypeList ParameterTypeList_147_Var
		 = (ParameterTypeList)ParameterTypeList_146_list.get(0);
		Assert.assertNotNull(ParameterTypeList_147_Var
		);
		//147
		final ParameterList ParameterList_148_Var
		 = (ParameterList)ParameterTypeList_147_Var
		.getList();
		Assert.assertNotNull(ParameterList_148_Var
		);
		final EList<? extends EObject> ParameterDeclaration_148_list = ParameterList_148_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_148_list);
		Assert.assertEquals(1, ParameterDeclaration_148_list.size());
		//148
		final ParameterDeclaration ParameterDeclaration_149_Var
		 = (ParameterDeclaration)ParameterDeclaration_148_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_149_Var
		);
		//149
		final DeclarationSpecifiers DeclarationSpecifiers_150_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_149_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_150_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_150_list = DeclarationSpecifiers_150_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_150_list);
		Assert.assertEquals(1, DeclarationSpecifier_150_list.size());
		//150
		final TypeSpecifier TypeSpecifier_151_Var
		 = (TypeSpecifier)DeclarationSpecifier_150_list.get(0);
		Assert.assertNotNull(TypeSpecifier_151_Var
		);
		Assert.assertEquals("void", TypeSpecifier_151_Var
		.getName());
		//151
		final FunctionDefinition FunctionDefinition_152_Var
		 = (FunctionDefinition)ExternalDeclaration_139_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_152_Var
		);
		//152
		final BodyStatement BodyStatement_153_Var
		 = (BodyStatement)FunctionDefinition_152_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_153_Var
		);
		final EList<? extends EObject> BlockList_153_list = BodyStatement_153_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_153_list);
		Assert.assertEquals(1, BlockList_153_list.size());
		//153
		final BlockList BlockList_154_Var
		 = (BlockList)BlockList_153_list.get(0);
		Assert.assertNotNull(BlockList_154_Var
		);
		final EList<? extends EObject> Statement_154_list = BlockList_154_Var
		.getStatement();
		Assert.assertNotNull(Statement_154_list);
		Assert.assertEquals(2, Statement_154_list.size());
		//154
		final Statement Statement_155_Var
		 = (Statement)Statement_154_list.get(0);
		Assert.assertNotNull(Statement_155_Var
		);
		//155
		final ExpressionStatement ExpressionStatement_156_Var
		 = (ExpressionStatement)Statement_155_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_156_Var
		);
		//156
		final Expression Expression_157_Var
		 = (Expression)ExpressionStatement_156_Var
		.getExpression();
		Assert.assertNotNull(Expression_157_Var
		);
		final EList<? extends EObject> ExprExpr_157_list = Expression_157_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_157_list);
		Assert.assertEquals(1, ExprExpr_157_list.size());
		//157
		final AssignmentExpression AssignmentExpression_158_Var
		 = (AssignmentExpression)ExprExpr_157_list.get(0);
		Assert.assertNotNull(AssignmentExpression_158_Var
		);
		//158
		final ConditionalExpression ConditionalExpression_159_Var
		 = (ConditionalExpression)AssignmentExpression_158_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_159_Var
		);
		//159
		final LogicalOrExpression LogicalOrExpression_160_Var
		 = (LogicalOrExpression)ConditionalExpression_159_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = LogicalOrExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final LogicalAndExpression LogicalAndExpression_161_Var
		 = (LogicalAndExpression)Expr_160_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = LogicalAndExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final InclusiveOrExpression InclusiveOrExpression_162_Var
		 = (InclusiveOrExpression)Expr_161_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_162_Var
		);
		final EList<? extends EObject> Expr_162_list = InclusiveOrExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		//162
		final ExclusiveOrExpression ExclusiveOrExpression_163_Var
		 = (ExclusiveOrExpression)Expr_162_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_163_Var
		);
		final EList<? extends EObject> Expr_163_list = ExclusiveOrExpression_163_Var
		.getExpr();
		Assert.assertNotNull(Expr_163_list);
		Assert.assertEquals(1, Expr_163_list.size());
		//163
		final AndExpression AndExpression_164_Var
		 = (AndExpression)Expr_163_list.get(0);
		Assert.assertNotNull(AndExpression_164_Var
		);
		final EList<? extends EObject> Expr_164_list = AndExpression_164_Var
		.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		//164
		final EqualityExpression EqualityExpression_165_Var
		 = (EqualityExpression)Expr_164_list.get(0);
		Assert.assertNotNull(EqualityExpression_165_Var
		);
		final EList<? extends EObject> Expr_165_list = EqualityExpression_165_Var
		.getExpr();
		Assert.assertNotNull(Expr_165_list);
		Assert.assertEquals(1, Expr_165_list.size());
		//165
		final RelationalExpression RelationalExpression_166_Var
		 = (RelationalExpression)Expr_165_list.get(0);
		Assert.assertNotNull(RelationalExpression_166_Var
		);
		final EList<? extends EObject> Expr_166_list = RelationalExpression_166_Var
		.getExpr();
		Assert.assertNotNull(Expr_166_list);
		Assert.assertEquals(1, Expr_166_list.size());
		//166
		final ShiftExpression ShiftExpression_167_Var
		 = (ShiftExpression)Expr_166_list.get(0);
		Assert.assertNotNull(ShiftExpression_167_Var
		);
		final EList<? extends EObject> Expr_167_list = ShiftExpression_167_Var
		.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(1, Expr_167_list.size());
		//167
		final AdditiveExpression AdditiveExpression_168_Var
		 = (AdditiveExpression)Expr_167_list.get(0);
		Assert.assertNotNull(AdditiveExpression_168_Var
		);
		final EList<? extends EObject> Expr_168_list = AdditiveExpression_168_Var
		.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(1, Expr_168_list.size());
		//168
		final MultiplicativeExpression MultiplicativeExpression_169_Var
		 = (MultiplicativeExpression)Expr_168_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_169_Var
		);
		final EList<? extends EObject> Expr_169_list = MultiplicativeExpression_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		//169
		final CastExpression CastExpression_170_Var
		 = (CastExpression)Expr_169_list.get(0);
		Assert.assertNotNull(CastExpression_170_Var
		);
		//170
		final UnaryExpression UnaryExpression_171_Var
		 = (UnaryExpression)CastExpression_170_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_171_Var
		);
		//171
		final PostfixExpression PostfixExpression_172_Var
		 = (PostfixExpression)UnaryExpression_171_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = PostfixExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final PrimaryExpression PrimaryExpression_173_Var
		 = (PrimaryExpression)Expr_172_list.get(0);
		Assert.assertNotNull(PrimaryExpression_173_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_173_Var
		.getId());
		final EList<? extends EObject> Suffix_173_list = PostfixExpression_172_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_173_list);
		Assert.assertEquals(1, Suffix_173_list.size());
		//173
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_174_Var
		 = (PostfixExpressionSuffixArgument)Suffix_173_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_174_Var
		);
		//174
		final ArgumentExpressionList ArgumentExpressionList_175_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_174_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_175_Var
		);
		final EList<? extends EObject> Expr_175_list = ArgumentExpressionList_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(2, Expr_175_list.size());
		//175
		final AssignmentExpression AssignmentExpression_176_Var
		 = (AssignmentExpression)Expr_175_list.get(0);
		Assert.assertNotNull(AssignmentExpression_176_Var
		);
		//176
		final ConditionalExpression ConditionalExpression_177_Var
		 = (ConditionalExpression)AssignmentExpression_176_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_177_Var
		);
		//177
		final LogicalOrExpression LogicalOrExpression_178_Var
		 = (LogicalOrExpression)ConditionalExpression_177_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = LogicalOrExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final LogicalAndExpression LogicalAndExpression_179_Var
		 = (LogicalAndExpression)Expr_178_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = LogicalAndExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final InclusiveOrExpression InclusiveOrExpression_180_Var
		 = (InclusiveOrExpression)Expr_179_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_180_Var
		);
		final EList<? extends EObject> Expr_180_list = InclusiveOrExpression_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final ExclusiveOrExpression ExclusiveOrExpression_181_Var
		 = (ExclusiveOrExpression)Expr_180_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_181_Var
		);
		final EList<? extends EObject> Expr_181_list = ExclusiveOrExpression_181_Var
		.getExpr();
		Assert.assertNotNull(Expr_181_list);
		Assert.assertEquals(1, Expr_181_list.size());
		//181
		final AndExpression AndExpression_182_Var
		 = (AndExpression)Expr_181_list.get(0);
		Assert.assertNotNull(AndExpression_182_Var
		);
		final EList<? extends EObject> Expr_182_list = AndExpression_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(1, Expr_182_list.size());
		//182
		final EqualityExpression EqualityExpression_183_Var
		 = (EqualityExpression)Expr_182_list.get(0);
		Assert.assertNotNull(EqualityExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = EqualityExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final RelationalExpression RelationalExpression_184_Var
		 = (RelationalExpression)Expr_183_list.get(0);
		Assert.assertNotNull(RelationalExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = RelationalExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final ShiftExpression ShiftExpression_185_Var
		 = (ShiftExpression)Expr_184_list.get(0);
		Assert.assertNotNull(ShiftExpression_185_Var
		);
		final EList<? extends EObject> Expr_185_list = ShiftExpression_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final AdditiveExpression AdditiveExpression_186_Var
		 = (AdditiveExpression)Expr_185_list.get(0);
		Assert.assertNotNull(AdditiveExpression_186_Var
		);
		final EList<? extends EObject> Expr_186_list = AdditiveExpression_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(1, Expr_186_list.size());
		//186
		final MultiplicativeExpression MultiplicativeExpression_187_Var
		 = (MultiplicativeExpression)Expr_186_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_187_Var
		);
		final EList<? extends EObject> Expr_187_list = MultiplicativeExpression_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(1, Expr_187_list.size());
		//187
		final CastExpression CastExpression_188_Var
		 = (CastExpression)Expr_187_list.get(0);
		Assert.assertNotNull(CastExpression_188_Var
		);
		//188
		final UnaryExpression UnaryExpression_189_Var
		 = (UnaryExpression)CastExpression_188_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_189_Var
		);
		//189
		final PostfixExpression PostfixExpression_190_Var
		 = (PostfixExpression)UnaryExpression_189_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = PostfixExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final PrimaryExpression PrimaryExpression_191_Var
		 = (PrimaryExpression)Expr_190_list.get(0);
		Assert.assertNotNull(PrimaryExpression_191_Var
		);
		//191
		final Constant2 Constant2_192_Var
		 = (Constant2)PrimaryExpression_191_Var
		.getConst();
		Assert.assertNotNull(Constant2_192_Var
		);
		Assert.assertEquals("\"%d\\n\"", Constant2_192_Var
		.getStr());
		//192
		final AssignmentExpression AssignmentExpression_193_Var
		 = (AssignmentExpression)Expr_175_list.get(1);
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
		Assert.assertEquals("array", PrimaryExpression_208_Var
		.getId());
		final EList<? extends EObject> Suffix_208_list = PostfixExpression_207_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_208_list);
		Assert.assertEquals(1, Suffix_208_list.size());
		//208
		final PostfixExpressionSuffixArray PostfixExpressionSuffixArray_209_Var
		 = (PostfixExpressionSuffixArray)Suffix_208_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArray_209_Var
		);
		//209
		final Expression Expression_210_Var
		 = (Expression)PostfixExpressionSuffixArray_209_Var
		.getArrayExpr();
		Assert.assertNotNull(Expression_210_Var
		);
		final EList<? extends EObject> ExprExpr_210_list = Expression_210_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_210_list);
		Assert.assertEquals(1, ExprExpr_210_list.size());
		//210
		final AssignmentExpression AssignmentExpression_211_Var
		 = (AssignmentExpression)ExprExpr_210_list.get(0);
		Assert.assertNotNull(AssignmentExpression_211_Var
		);
		//211
		final ConditionalExpression ConditionalExpression_212_Var
		 = (ConditionalExpression)AssignmentExpression_211_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_212_Var
		);
		//212
		final LogicalOrExpression LogicalOrExpression_213_Var
		 = (LogicalOrExpression)ConditionalExpression_212_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = LogicalOrExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final LogicalAndExpression LogicalAndExpression_214_Var
		 = (LogicalAndExpression)Expr_213_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = LogicalAndExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final InclusiveOrExpression InclusiveOrExpression_215_Var
		 = (InclusiveOrExpression)Expr_214_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = InclusiveOrExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final ExclusiveOrExpression ExclusiveOrExpression_216_Var
		 = (ExclusiveOrExpression)Expr_215_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = ExclusiveOrExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final AndExpression AndExpression_217_Var
		 = (AndExpression)Expr_216_list.get(0);
		Assert.assertNotNull(AndExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = AndExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final EqualityExpression EqualityExpression_218_Var
		 = (EqualityExpression)Expr_217_list.get(0);
		Assert.assertNotNull(EqualityExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = EqualityExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final RelationalExpression RelationalExpression_219_Var
		 = (RelationalExpression)Expr_218_list.get(0);
		Assert.assertNotNull(RelationalExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = RelationalExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final ShiftExpression ShiftExpression_220_Var
		 = (ShiftExpression)Expr_219_list.get(0);
		Assert.assertNotNull(ShiftExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = ShiftExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final AdditiveExpression AdditiveExpression_221_Var
		 = (AdditiveExpression)Expr_220_list.get(0);
		Assert.assertNotNull(AdditiveExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = AdditiveExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final MultiplicativeExpression MultiplicativeExpression_222_Var
		 = (MultiplicativeExpression)Expr_221_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = MultiplicativeExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final CastExpression CastExpression_223_Var
		 = (CastExpression)Expr_222_list.get(0);
		Assert.assertNotNull(CastExpression_223_Var
		);
		//223
		final UnaryExpression UnaryExpression_224_Var
		 = (UnaryExpression)CastExpression_223_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_224_Var
		);
		//224
		final PostfixExpression PostfixExpression_225_Var
		 = (PostfixExpression)UnaryExpression_224_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = PostfixExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final PrimaryExpression PrimaryExpression_226_Var
		 = (PrimaryExpression)Expr_225_list.get(0);
		Assert.assertNotNull(PrimaryExpression_226_Var
		);
		//226
		final Constant2 Constant2_227_Var
		 = (Constant2)PrimaryExpression_226_Var
		.getConst();
		Assert.assertNotNull(Constant2_227_Var
		);
		Assert.assertEquals("3", Constant2_227_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_156_Var
		.getSemi());
		//227
		final Statement Statement_228_Var
		 = (Statement)Statement_154_list.get(1);
		Assert.assertNotNull(Statement_228_Var
		);
		//228
		final JumpStatement JumpStatement_229_Var
		 = (JumpStatement)Statement_228_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_229_Var
		);
		//229
		final Expression Expression_230_Var
		 = (Expression)JumpStatement_229_Var
		.getExpr();
		Assert.assertNotNull(Expression_230_Var
		);
		final EList<? extends EObject> ExprExpr_230_list = Expression_230_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_230_list);
		Assert.assertEquals(1, ExprExpr_230_list.size());
		//230
		final AssignmentExpression AssignmentExpression_231_Var
		 = (AssignmentExpression)ExprExpr_230_list.get(0);
		Assert.assertNotNull(AssignmentExpression_231_Var
		);
		//231
		final ConditionalExpression ConditionalExpression_232_Var
		 = (ConditionalExpression)AssignmentExpression_231_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_232_Var
		);
		//232
		final LogicalOrExpression LogicalOrExpression_233_Var
		 = (LogicalOrExpression)ConditionalExpression_232_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = LogicalOrExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final LogicalAndExpression LogicalAndExpression_234_Var
		 = (LogicalAndExpression)Expr_233_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = LogicalAndExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final InclusiveOrExpression InclusiveOrExpression_235_Var
		 = (InclusiveOrExpression)Expr_234_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = InclusiveOrExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final ExclusiveOrExpression ExclusiveOrExpression_236_Var
		 = (ExclusiveOrExpression)Expr_235_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = ExclusiveOrExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final AndExpression AndExpression_237_Var
		 = (AndExpression)Expr_236_list.get(0);
		Assert.assertNotNull(AndExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = AndExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final EqualityExpression EqualityExpression_238_Var
		 = (EqualityExpression)Expr_237_list.get(0);
		Assert.assertNotNull(EqualityExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = EqualityExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final RelationalExpression RelationalExpression_239_Var
		 = (RelationalExpression)Expr_238_list.get(0);
		Assert.assertNotNull(RelationalExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = RelationalExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final ShiftExpression ShiftExpression_240_Var
		 = (ShiftExpression)Expr_239_list.get(0);
		Assert.assertNotNull(ShiftExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = ShiftExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final AdditiveExpression AdditiveExpression_241_Var
		 = (AdditiveExpression)Expr_240_list.get(0);
		Assert.assertNotNull(AdditiveExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = AdditiveExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final MultiplicativeExpression MultiplicativeExpression_242_Var
		 = (MultiplicativeExpression)Expr_241_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = MultiplicativeExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final CastExpression CastExpression_243_Var
		 = (CastExpression)Expr_242_list.get(0);
		Assert.assertNotNull(CastExpression_243_Var
		);
		//243
		final UnaryExpression UnaryExpression_244_Var
		 = (UnaryExpression)CastExpression_243_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_244_Var
		);
		//244
		final PostfixExpression PostfixExpression_245_Var
		 = (PostfixExpression)UnaryExpression_244_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = PostfixExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final PrimaryExpression PrimaryExpression_246_Var
		 = (PrimaryExpression)Expr_245_list.get(0);
		Assert.assertNotNull(PrimaryExpression_246_Var
		);
		//246
		final Constant2 Constant2_247_Var
		 = (Constant2)PrimaryExpression_246_Var
		.getConst();
		Assert.assertNotNull(Constant2_247_Var
		);
		Assert.assertEquals("0", Constant2_247_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_229_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_229_Var
		.getSemi());
	}
	
	@Test
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


