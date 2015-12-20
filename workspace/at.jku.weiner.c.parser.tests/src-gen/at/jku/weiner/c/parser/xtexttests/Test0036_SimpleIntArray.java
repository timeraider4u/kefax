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

import at.jku.weiner.c.parser.parser.Model;
import at.jku.weiner.c.parser.parser.TranslationUnit;
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
		Assert.assertEquals("int", TypeSpecifier_5_Var
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
		Assert.assertEquals("array", DirectDeclarator_9_Var
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
		final Constant2 Constant2_27_Var
		 = (Constant2)PrimaryExpression_26_Var
		.getConst();
		Assert.assertNotNull(Constant2_27_Var
		);
		Assert.assertEquals("6", Constant2_27_Var
		.getDec());
		//27
		final Initializer Initializer_28_Var
		 = (Initializer)InitDeclarator_7_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_28_Var
		);
		//28
		final InitializerList InitializerList_29_Var
		 = (InitializerList)Initializer_28_Var
		.getList();
		Assert.assertNotNull(InitializerList_29_Var
		);
		final EList<? extends EObject> Initializer_29_list = InitializerList_29_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_29_list);
		Assert.assertEquals(6, Initializer_29_list.size());
		//29
		final Initializer Initializer_30_Var
		 = (Initializer)Initializer_29_list.get(0);
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
		final Initializer Initializer_48_Var
		 = (Initializer)Initializer_29_list.get(1);
		Assert.assertNotNull(Initializer_48_Var
		);
		//48
		final AssignmentExpression AssignmentExpression_49_Var
		 = (AssignmentExpression)Initializer_48_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_49_Var
		);
		//49
		final ConditionalExpression ConditionalExpression_50_Var
		 = (ConditionalExpression)AssignmentExpression_49_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_50_Var
		);
		//50
		final LogicalOrExpression LogicalOrExpression_51_Var
		 = (LogicalOrExpression)ConditionalExpression_50_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = LogicalOrExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final LogicalAndExpression LogicalAndExpression_52_Var
		 = (LogicalAndExpression)Expr_51_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = LogicalAndExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final InclusiveOrExpression InclusiveOrExpression_53_Var
		 = (InclusiveOrExpression)Expr_52_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = InclusiveOrExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final ExclusiveOrExpression ExclusiveOrExpression_54_Var
		 = (ExclusiveOrExpression)Expr_53_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = ExclusiveOrExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final AndExpression AndExpression_55_Var
		 = (AndExpression)Expr_54_list.get(0);
		Assert.assertNotNull(AndExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = AndExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final EqualityExpression EqualityExpression_56_Var
		 = (EqualityExpression)Expr_55_list.get(0);
		Assert.assertNotNull(EqualityExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = EqualityExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final RelationalExpression RelationalExpression_57_Var
		 = (RelationalExpression)Expr_56_list.get(0);
		Assert.assertNotNull(RelationalExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = RelationalExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final ShiftExpression ShiftExpression_58_Var
		 = (ShiftExpression)Expr_57_list.get(0);
		Assert.assertNotNull(ShiftExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = ShiftExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final AdditiveExpression AdditiveExpression_59_Var
		 = (AdditiveExpression)Expr_58_list.get(0);
		Assert.assertNotNull(AdditiveExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = AdditiveExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final MultiplicativeExpression MultiplicativeExpression_60_Var
		 = (MultiplicativeExpression)Expr_59_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = MultiplicativeExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final CastExpression CastExpression_61_Var
		 = (CastExpression)Expr_60_list.get(0);
		Assert.assertNotNull(CastExpression_61_Var
		);
		//61
		final UnaryExpression UnaryExpression_62_Var
		 = (UnaryExpression)CastExpression_61_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_62_Var
		);
		//62
		final PostfixExpression PostfixExpression_63_Var
		 = (PostfixExpression)UnaryExpression_62_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = PostfixExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final PrimaryExpression PrimaryExpression_64_Var
		 = (PrimaryExpression)Expr_63_list.get(0);
		Assert.assertNotNull(PrimaryExpression_64_Var
		);
		//64
		final Constant2 Constant2_65_Var
		 = (Constant2)PrimaryExpression_64_Var
		.getConst();
		Assert.assertNotNull(Constant2_65_Var
		);
		Assert.assertEquals("2", Constant2_65_Var
		.getDec());
		//65
		final Initializer Initializer_66_Var
		 = (Initializer)Initializer_29_list.get(2);
		Assert.assertNotNull(Initializer_66_Var
		);
		//66
		final AssignmentExpression AssignmentExpression_67_Var
		 = (AssignmentExpression)Initializer_66_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_67_Var
		);
		//67
		final ConditionalExpression ConditionalExpression_68_Var
		 = (ConditionalExpression)AssignmentExpression_67_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_68_Var
		);
		//68
		final LogicalOrExpression LogicalOrExpression_69_Var
		 = (LogicalOrExpression)ConditionalExpression_68_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = LogicalOrExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final LogicalAndExpression LogicalAndExpression_70_Var
		 = (LogicalAndExpression)Expr_69_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = LogicalAndExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final InclusiveOrExpression InclusiveOrExpression_71_Var
		 = (InclusiveOrExpression)Expr_70_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = InclusiveOrExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final ExclusiveOrExpression ExclusiveOrExpression_72_Var
		 = (ExclusiveOrExpression)Expr_71_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = ExclusiveOrExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final AndExpression AndExpression_73_Var
		 = (AndExpression)Expr_72_list.get(0);
		Assert.assertNotNull(AndExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = AndExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final EqualityExpression EqualityExpression_74_Var
		 = (EqualityExpression)Expr_73_list.get(0);
		Assert.assertNotNull(EqualityExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = EqualityExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final RelationalExpression RelationalExpression_75_Var
		 = (RelationalExpression)Expr_74_list.get(0);
		Assert.assertNotNull(RelationalExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = RelationalExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final ShiftExpression ShiftExpression_76_Var
		 = (ShiftExpression)Expr_75_list.get(0);
		Assert.assertNotNull(ShiftExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = ShiftExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final AdditiveExpression AdditiveExpression_77_Var
		 = (AdditiveExpression)Expr_76_list.get(0);
		Assert.assertNotNull(AdditiveExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = AdditiveExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final MultiplicativeExpression MultiplicativeExpression_78_Var
		 = (MultiplicativeExpression)Expr_77_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = MultiplicativeExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final CastExpression CastExpression_79_Var
		 = (CastExpression)Expr_78_list.get(0);
		Assert.assertNotNull(CastExpression_79_Var
		);
		//79
		final UnaryExpression UnaryExpression_80_Var
		 = (UnaryExpression)CastExpression_79_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_80_Var
		);
		//80
		final PostfixExpression PostfixExpression_81_Var
		 = (PostfixExpression)UnaryExpression_80_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = PostfixExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final PrimaryExpression PrimaryExpression_82_Var
		 = (PrimaryExpression)Expr_81_list.get(0);
		Assert.assertNotNull(PrimaryExpression_82_Var
		);
		//82
		final Constant2 Constant2_83_Var
		 = (Constant2)PrimaryExpression_82_Var
		.getConst();
		Assert.assertNotNull(Constant2_83_Var
		);
		Assert.assertEquals("3", Constant2_83_Var
		.getDec());
		//83
		final Initializer Initializer_84_Var
		 = (Initializer)Initializer_29_list.get(3);
		Assert.assertNotNull(Initializer_84_Var
		);
		//84
		final AssignmentExpression AssignmentExpression_85_Var
		 = (AssignmentExpression)Initializer_84_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_85_Var
		);
		//85
		final ConditionalExpression ConditionalExpression_86_Var
		 = (ConditionalExpression)AssignmentExpression_85_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_86_Var
		);
		//86
		final LogicalOrExpression LogicalOrExpression_87_Var
		 = (LogicalOrExpression)ConditionalExpression_86_Var
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
		//100
		final Constant2 Constant2_101_Var
		 = (Constant2)PrimaryExpression_100_Var
		.getConst();
		Assert.assertNotNull(Constant2_101_Var
		);
		Assert.assertEquals("5", Constant2_101_Var
		.getDec());
		//101
		final Initializer Initializer_102_Var
		 = (Initializer)Initializer_29_list.get(4);
		Assert.assertNotNull(Initializer_102_Var
		);
		//102
		final AssignmentExpression AssignmentExpression_103_Var
		 = (AssignmentExpression)Initializer_102_Var
		.getExpr();
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
		//118
		final Constant2 Constant2_119_Var
		 = (Constant2)PrimaryExpression_118_Var
		.getConst();
		Assert.assertNotNull(Constant2_119_Var
		);
		Assert.assertEquals("7", Constant2_119_Var
		.getDec());
		//119
		final Initializer Initializer_120_Var
		 = (Initializer)Initializer_29_list.get(5);
		Assert.assertNotNull(Initializer_120_Var
		);
		//120
		final AssignmentExpression AssignmentExpression_121_Var
		 = (AssignmentExpression)Initializer_120_Var
		.getExpr();
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
		//136
		final Constant2 Constant2_137_Var
		 = (Constant2)PrimaryExpression_136_Var
		.getConst();
		Assert.assertNotNull(Constant2_137_Var
		);
		Assert.assertEquals("11", Constant2_137_Var
		.getDec());
		//137
		final ExternalDeclaration ExternalDeclaration_138_Var
		 = (ExternalDeclaration)External_1_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_138_Var
		);
		//138
		final FunctionDefHead FunctionDefHead_139_Var
		 = (FunctionDefHead)ExternalDeclaration_138_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_139_Var
		);
		//139
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_140_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_139_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_140_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_140_list = FunctionDeclarationSpecifiers_140_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_140_list);
		Assert.assertEquals(1, DeclarationSpecifier_140_list.size());
		//140
		final TypeSpecifier TypeSpecifier_141_Var
		 = (TypeSpecifier)DeclarationSpecifier_140_list.get(0);
		Assert.assertNotNull(TypeSpecifier_141_Var
		);
		Assert.assertEquals("int", TypeSpecifier_141_Var
		.getName());
		//141
		final Declarator Declarator_142_Var
		 = (Declarator)FunctionDefHead_139_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_142_Var
		);
		//142
		final DirectDeclarator DirectDeclarator_143_Var
		 = (DirectDeclarator)Declarator_142_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_143_Var
		);
		Assert.assertEquals("main", DirectDeclarator_143_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_143_list = DirectDeclarator_143_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_143_list);
		Assert.assertEquals(1, DeclaratorSuffix_143_list.size());
		//143
		final DeclaratorSuffix DeclaratorSuffix_144_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_143_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_144_Var
		);
		//144
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_145_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_144_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_145_Var
		);
		final EList<? extends EObject> ParameterTypeList_145_list = DirectDeclaratorLastSuffix_145_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_145_list);
		Assert.assertEquals(1, ParameterTypeList_145_list.size());
		//145
		final ParameterTypeList ParameterTypeList_146_Var
		 = (ParameterTypeList)ParameterTypeList_145_list.get(0);
		Assert.assertNotNull(ParameterTypeList_146_Var
		);
		//146
		final ParameterList ParameterList_147_Var
		 = (ParameterList)ParameterTypeList_146_Var
		.getList();
		Assert.assertNotNull(ParameterList_147_Var
		);
		final EList<? extends EObject> ParameterDeclaration_147_list = ParameterList_147_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_147_list);
		Assert.assertEquals(1, ParameterDeclaration_147_list.size());
		//147
		final ParameterDeclaration ParameterDeclaration_148_Var
		 = (ParameterDeclaration)ParameterDeclaration_147_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_148_Var
		);
		//148
		final DeclarationSpecifiers DeclarationSpecifiers_149_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_148_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_149_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_149_list = DeclarationSpecifiers_149_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_149_list);
		Assert.assertEquals(1, DeclarationSpecifier_149_list.size());
		//149
		final TypeSpecifier TypeSpecifier_150_Var
		 = (TypeSpecifier)DeclarationSpecifier_149_list.get(0);
		Assert.assertNotNull(TypeSpecifier_150_Var
		);
		Assert.assertEquals("void", TypeSpecifier_150_Var
		.getName());
		//150
		final FunctionDefinition FunctionDefinition_151_Var
		 = (FunctionDefinition)ExternalDeclaration_138_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_151_Var
		);
		//151
		final BodyStatement BodyStatement_152_Var
		 = (BodyStatement)FunctionDefinition_151_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_152_Var
		);
		final EList<? extends EObject> BlockList_152_list = BodyStatement_152_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_152_list);
		Assert.assertEquals(1, BlockList_152_list.size());
		//152
		final BlockList BlockList_153_Var
		 = (BlockList)BlockList_152_list.get(0);
		Assert.assertNotNull(BlockList_153_Var
		);
		final EList<? extends EObject> Statement_153_list = BlockList_153_Var
		.getStatement();
		Assert.assertNotNull(Statement_153_list);
		Assert.assertEquals(2, Statement_153_list.size());
		//153
		final Statement Statement_154_Var
		 = (Statement)Statement_153_list.get(0);
		Assert.assertNotNull(Statement_154_Var
		);
		//154
		final ExpressionStatement ExpressionStatement_155_Var
		 = (ExpressionStatement)Statement_154_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_155_Var
		);
		//155
		final Expression Expression_156_Var
		 = (Expression)ExpressionStatement_155_Var
		.getExpression();
		Assert.assertNotNull(Expression_156_Var
		);
		final EList<? extends EObject> ExprExpr_156_list = Expression_156_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_156_list);
		Assert.assertEquals(1, ExprExpr_156_list.size());
		//156
		final AssignmentExpression AssignmentExpression_157_Var
		 = (AssignmentExpression)ExprExpr_156_list.get(0);
		Assert.assertNotNull(AssignmentExpression_157_Var
		);
		//157
		final ConditionalExpression ConditionalExpression_158_Var
		 = (ConditionalExpression)AssignmentExpression_157_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_158_Var
		);
		//158
		final LogicalOrExpression LogicalOrExpression_159_Var
		 = (LogicalOrExpression)ConditionalExpression_158_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = LogicalOrExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final LogicalAndExpression LogicalAndExpression_160_Var
		 = (LogicalAndExpression)Expr_159_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = LogicalAndExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final InclusiveOrExpression InclusiveOrExpression_161_Var
		 = (InclusiveOrExpression)Expr_160_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = InclusiveOrExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final ExclusiveOrExpression ExclusiveOrExpression_162_Var
		 = (ExclusiveOrExpression)Expr_161_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_162_Var
		);
		final EList<? extends EObject> Expr_162_list = ExclusiveOrExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		//162
		final AndExpression AndExpression_163_Var
		 = (AndExpression)Expr_162_list.get(0);
		Assert.assertNotNull(AndExpression_163_Var
		);
		final EList<? extends EObject> Expr_163_list = AndExpression_163_Var
		.getExpr();
		Assert.assertNotNull(Expr_163_list);
		Assert.assertEquals(1, Expr_163_list.size());
		//163
		final EqualityExpression EqualityExpression_164_Var
		 = (EqualityExpression)Expr_163_list.get(0);
		Assert.assertNotNull(EqualityExpression_164_Var
		);
		final EList<? extends EObject> Expr_164_list = EqualityExpression_164_Var
		.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		//164
		final RelationalExpression RelationalExpression_165_Var
		 = (RelationalExpression)Expr_164_list.get(0);
		Assert.assertNotNull(RelationalExpression_165_Var
		);
		final EList<? extends EObject> Expr_165_list = RelationalExpression_165_Var
		.getExpr();
		Assert.assertNotNull(Expr_165_list);
		Assert.assertEquals(1, Expr_165_list.size());
		//165
		final ShiftExpression ShiftExpression_166_Var
		 = (ShiftExpression)Expr_165_list.get(0);
		Assert.assertNotNull(ShiftExpression_166_Var
		);
		final EList<? extends EObject> Expr_166_list = ShiftExpression_166_Var
		.getExpr();
		Assert.assertNotNull(Expr_166_list);
		Assert.assertEquals(1, Expr_166_list.size());
		//166
		final AdditiveExpression AdditiveExpression_167_Var
		 = (AdditiveExpression)Expr_166_list.get(0);
		Assert.assertNotNull(AdditiveExpression_167_Var
		);
		final EList<? extends EObject> Expr_167_list = AdditiveExpression_167_Var
		.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(1, Expr_167_list.size());
		//167
		final MultiplicativeExpression MultiplicativeExpression_168_Var
		 = (MultiplicativeExpression)Expr_167_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_168_Var
		);
		final EList<? extends EObject> Expr_168_list = MultiplicativeExpression_168_Var
		.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(1, Expr_168_list.size());
		//168
		final CastExpression CastExpression_169_Var
		 = (CastExpression)Expr_168_list.get(0);
		Assert.assertNotNull(CastExpression_169_Var
		);
		//169
		final UnaryExpression UnaryExpression_170_Var
		 = (UnaryExpression)CastExpression_169_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_170_Var
		);
		//170
		final PostfixExpression PostfixExpression_171_Var
		 = (PostfixExpression)UnaryExpression_170_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_171_Var
		);
		final EList<? extends EObject> Expr_171_list = PostfixExpression_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		//171
		final PrimaryExpression PrimaryExpression_172_Var
		 = (PrimaryExpression)Expr_171_list.get(0);
		Assert.assertNotNull(PrimaryExpression_172_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_172_Var
		.getId());
		final EList<? extends EObject> Suffix_172_list = PostfixExpression_171_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_172_list);
		Assert.assertEquals(1, Suffix_172_list.size());
		//172
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_173_Var
		 = (PostfixExpressionSuffixArgument)Suffix_172_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_173_Var
		);
		//173
		final ArgumentExpressionList ArgumentExpressionList_174_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_173_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_174_Var
		);
		final EList<? extends EObject> Expr_174_list = ArgumentExpressionList_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(2, Expr_174_list.size());
		//174
		final AssignmentExpression AssignmentExpression_175_Var
		 = (AssignmentExpression)Expr_174_list.get(0);
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
		//190
		final Constant2 Constant2_191_Var
		 = (Constant2)PrimaryExpression_190_Var
		.getConst();
		Assert.assertNotNull(Constant2_191_Var
		);
		Assert.assertEquals("\"%d\\n\"", Constant2_191_Var
		.getStr());
		//191
		final AssignmentExpression AssignmentExpression_192_Var
		 = (AssignmentExpression)Expr_174_list.get(1);
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
		Assert.assertEquals("array", PrimaryExpression_207_Var
		.getId());
		final EList<? extends EObject> Suffix_207_list = PostfixExpression_206_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_207_list);
		Assert.assertEquals(1, Suffix_207_list.size());
		//207
		final PostfixExpressionSuffixArray PostfixExpressionSuffixArray_208_Var
		 = (PostfixExpressionSuffixArray)Suffix_207_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArray_208_Var
		);
		//208
		final Expression Expression_209_Var
		 = (Expression)PostfixExpressionSuffixArray_208_Var
		.getArrayExpr();
		Assert.assertNotNull(Expression_209_Var
		);
		final EList<? extends EObject> ExprExpr_209_list = Expression_209_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_209_list);
		Assert.assertEquals(1, ExprExpr_209_list.size());
		//209
		final AssignmentExpression AssignmentExpression_210_Var
		 = (AssignmentExpression)ExprExpr_209_list.get(0);
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
		Assert.assertEquals("3", Constant2_226_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_155_Var
		.getSemi());
		//226
		final Statement Statement_227_Var
		 = (Statement)Statement_153_list.get(1);
		Assert.assertNotNull(Statement_227_Var
		);
		//227
		final JumpStatement JumpStatement_228_Var
		 = (JumpStatement)Statement_227_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_228_Var
		);
		//228
		final Expression Expression_229_Var
		 = (Expression)JumpStatement_228_Var
		.getExpr();
		Assert.assertNotNull(Expression_229_Var
		);
		final EList<? extends EObject> ExprExpr_229_list = Expression_229_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_229_list);
		Assert.assertEquals(1, ExprExpr_229_list.size());
		//229
		final AssignmentExpression AssignmentExpression_230_Var
		 = (AssignmentExpression)ExprExpr_229_list.get(0);
		Assert.assertNotNull(AssignmentExpression_230_Var
		);
		//230
		final ConditionalExpression ConditionalExpression_231_Var
		 = (ConditionalExpression)AssignmentExpression_230_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_231_Var
		);
		//231
		final LogicalOrExpression LogicalOrExpression_232_Var
		 = (LogicalOrExpression)ConditionalExpression_231_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = LogicalOrExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final LogicalAndExpression LogicalAndExpression_233_Var
		 = (LogicalAndExpression)Expr_232_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = LogicalAndExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final InclusiveOrExpression InclusiveOrExpression_234_Var
		 = (InclusiveOrExpression)Expr_233_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = InclusiveOrExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final ExclusiveOrExpression ExclusiveOrExpression_235_Var
		 = (ExclusiveOrExpression)Expr_234_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = ExclusiveOrExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final AndExpression AndExpression_236_Var
		 = (AndExpression)Expr_235_list.get(0);
		Assert.assertNotNull(AndExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = AndExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final EqualityExpression EqualityExpression_237_Var
		 = (EqualityExpression)Expr_236_list.get(0);
		Assert.assertNotNull(EqualityExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = EqualityExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final RelationalExpression RelationalExpression_238_Var
		 = (RelationalExpression)Expr_237_list.get(0);
		Assert.assertNotNull(RelationalExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = RelationalExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final ShiftExpression ShiftExpression_239_Var
		 = (ShiftExpression)Expr_238_list.get(0);
		Assert.assertNotNull(ShiftExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = ShiftExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final AdditiveExpression AdditiveExpression_240_Var
		 = (AdditiveExpression)Expr_239_list.get(0);
		Assert.assertNotNull(AdditiveExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = AdditiveExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final MultiplicativeExpression MultiplicativeExpression_241_Var
		 = (MultiplicativeExpression)Expr_240_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = MultiplicativeExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final CastExpression CastExpression_242_Var
		 = (CastExpression)Expr_241_list.get(0);
		Assert.assertNotNull(CastExpression_242_Var
		);
		//242
		final UnaryExpression UnaryExpression_243_Var
		 = (UnaryExpression)CastExpression_242_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_243_Var
		);
		//243
		final PostfixExpression PostfixExpression_244_Var
		 = (PostfixExpression)UnaryExpression_243_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = PostfixExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final PrimaryExpression PrimaryExpression_245_Var
		 = (PrimaryExpression)Expr_244_list.get(0);
		Assert.assertNotNull(PrimaryExpression_245_Var
		);
		//245
		final Constant2 Constant2_246_Var
		 = (Constant2)PrimaryExpression_245_Var
		.getConst();
		Assert.assertNotNull(Constant2_246_Var
		);
		Assert.assertEquals("0", Constant2_246_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_228_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_228_Var
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


