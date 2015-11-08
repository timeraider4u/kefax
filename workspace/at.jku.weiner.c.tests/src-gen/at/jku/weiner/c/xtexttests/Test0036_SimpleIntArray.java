package at.jku.weiner.c.xtexttests;

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
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import at.jku.weiner.c.tests.CInjectorProvider;
import at.jku.weiner.c.parser.antlr.CParser;
import at.jku.weiner.c.parser.antlr.internal.InternalCLexer;
import at.jku.weiner.c.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.c.Model;
import at.jku.weiner.c.c.TranslationUnit;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.DeclaratorSuffix;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Initializer;
import at.jku.weiner.c.c.InitializerList;
import at.jku.weiner.c.c.Initializer;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Initializer;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Initializer;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Initializer;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Initializer;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Initializer;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.FunctionDefHead;
import at.jku.weiner.c.c.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.DeclaratorSuffix;
import at.jku.weiner.c.c.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.c.ParameterTypeList;
import at.jku.weiner.c.c.ParameterList;
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.FunctionDefinition;
import at.jku.weiner.c.c.BodyStatement;
import at.jku.weiner.c.c.BlockList;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.ArgumentExpressionList;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.JumpStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0036_SimpleIntArray {
	@Inject
	private ParseHelper<Model> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalCLexer lexer;
	@Inject
	private CParser parser;
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
	
	@Before
	public void initialize(){
		this.testHelper = new LexerAndParserTest(lexer, 
			parser, tokenDefProvider);
	}
	
	private String getTextFromFile(final String fileName)
	throws Exception{
		final Path path = Paths.get(fileName);
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
	private String preprocess(final String string) {
		final String lineComment = string.replaceAll("//.*\n", " ");
		final String blockComment = lineComment.replaceAll("/\\*.*\\*/", " ");
		final String lines = blockComment.replaceAll("\n", " ").trim();
		final String multi = lines.replaceAll("\\s{2,}", " ").trim();
		final String sign = multi.replaceAll("\\s+([^a-zA-Z0-9_])", "$1")
				.trim();
		final String sign2 = sign.replaceAll("([^a-zA-Z0-9_])\\s+", "$1")
				.trim();
	
		// System.out.println(sign2);
		return sign2;
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
				"RULE_LEFTBRACKET", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_RIGHTBRACKET", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_RIGHTBRACE", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_KW_VOID", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTBRACKET", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_RIGHTBRACKET", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_RIGHTBRACE", 
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
		final Constant Constant_27_Var
		 = (Constant)PrimaryExpression_26_Var
		.getConst();
		Assert.assertNotNull(Constant_27_Var
		);
		Assert.assertEquals("6", Constant_27_Var
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
		final Constant Constant_47_Var
		 = (Constant)PrimaryExpression_46_Var
		.getConst();
		Assert.assertNotNull(Constant_47_Var
		);
		Assert.assertEquals("1", Constant_47_Var
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
		final Constant Constant_65_Var
		 = (Constant)PrimaryExpression_64_Var
		.getConst();
		Assert.assertNotNull(Constant_65_Var
		);
		Assert.assertEquals("2", Constant_65_Var
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
		final Constant Constant_83_Var
		 = (Constant)PrimaryExpression_82_Var
		.getConst();
		Assert.assertNotNull(Constant_83_Var
		);
		Assert.assertEquals("3", Constant_83_Var
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
		final Constant Constant_101_Var
		 = (Constant)PrimaryExpression_100_Var
		.getConst();
		Assert.assertNotNull(Constant_101_Var
		);
		Assert.assertEquals("5", Constant_101_Var
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
		final Constant Constant_119_Var
		 = (Constant)PrimaryExpression_118_Var
		.getConst();
		Assert.assertNotNull(Constant_119_Var
		);
		Assert.assertEquals("7", Constant_119_Var
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
		final Constant Constant_137_Var
		 = (Constant)PrimaryExpression_136_Var
		.getConst();
		Assert.assertNotNull(Constant_137_Var
		);
		Assert.assertEquals("11", Constant_137_Var
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
		final EList<? extends EObject> ArgumentExpressionList_172_list = PostfixExpression_171_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_172_list);
		Assert.assertEquals(1, ArgumentExpressionList_172_list.size());
		//172
		final ArgumentExpressionList ArgumentExpressionList_173_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_172_list.get(0);
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
		//189
		final Constant Constant_190_Var
		 = (Constant)PrimaryExpression_189_Var
		.getConst();
		Assert.assertNotNull(Constant_190_Var
		);
		Assert.assertEquals("\"%d\\n\"", Constant_190_Var
		.getStr());
		//190
		final AssignmentExpression AssignmentExpression_191_Var
		 = (AssignmentExpression)Expr_173_list.get(1);
		Assert.assertNotNull(AssignmentExpression_191_Var
		);
		//191
		final ConditionalExpression ConditionalExpression_192_Var
		 = (ConditionalExpression)AssignmentExpression_191_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_192_Var
		);
		//192
		final LogicalOrExpression LogicalOrExpression_193_Var
		 = (LogicalOrExpression)ConditionalExpression_192_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = LogicalOrExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final LogicalAndExpression LogicalAndExpression_194_Var
		 = (LogicalAndExpression)Expr_193_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = LogicalAndExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final InclusiveOrExpression InclusiveOrExpression_195_Var
		 = (InclusiveOrExpression)Expr_194_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = InclusiveOrExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final ExclusiveOrExpression ExclusiveOrExpression_196_Var
		 = (ExclusiveOrExpression)Expr_195_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = ExclusiveOrExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final AndExpression AndExpression_197_Var
		 = (AndExpression)Expr_196_list.get(0);
		Assert.assertNotNull(AndExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = AndExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final EqualityExpression EqualityExpression_198_Var
		 = (EqualityExpression)Expr_197_list.get(0);
		Assert.assertNotNull(EqualityExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = EqualityExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final RelationalExpression RelationalExpression_199_Var
		 = (RelationalExpression)Expr_198_list.get(0);
		Assert.assertNotNull(RelationalExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = RelationalExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final ShiftExpression ShiftExpression_200_Var
		 = (ShiftExpression)Expr_199_list.get(0);
		Assert.assertNotNull(ShiftExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = ShiftExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final AdditiveExpression AdditiveExpression_201_Var
		 = (AdditiveExpression)Expr_200_list.get(0);
		Assert.assertNotNull(AdditiveExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = AdditiveExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final MultiplicativeExpression MultiplicativeExpression_202_Var
		 = (MultiplicativeExpression)Expr_201_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = MultiplicativeExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final CastExpression CastExpression_203_Var
		 = (CastExpression)Expr_202_list.get(0);
		Assert.assertNotNull(CastExpression_203_Var
		);
		//203
		final UnaryExpression UnaryExpression_204_Var
		 = (UnaryExpression)CastExpression_203_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_204_Var
		);
		//204
		final PostfixExpression PostfixExpression_205_Var
		 = (PostfixExpression)UnaryExpression_204_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = PostfixExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final PrimaryExpression PrimaryExpression_206_Var
		 = (PrimaryExpression)Expr_205_list.get(0);
		Assert.assertNotNull(PrimaryExpression_206_Var
		);
		Assert.assertEquals("array", PrimaryExpression_206_Var
		.getId());
		final EList<? extends EObject> ArrayExpr_206_list = PostfixExpression_205_Var
		.getArrayExpr();
		Assert.assertNotNull(ArrayExpr_206_list);
		Assert.assertEquals(1, ArrayExpr_206_list.size());
		//206
		final Expression Expression_207_Var
		 = (Expression)ArrayExpr_206_list.get(0);
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
		final Constant Constant_224_Var
		 = (Constant)PrimaryExpression_223_Var
		.getConst();
		Assert.assertNotNull(Constant_224_Var
		);
		Assert.assertEquals("3", Constant_224_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_155_Var
		.getSemi());
		//224
		final Statement Statement_225_Var
		 = (Statement)Statement_153_list.get(1);
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
		final Constant Constant_244_Var
		 = (Constant)PrimaryExpression_243_Var
		.getConst();
		Assert.assertNotNull(Constant_244_Var
		);
		Assert.assertEquals("0", Constant_244_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_226_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_226_Var
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
	
}


