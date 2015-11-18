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
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
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
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
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
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.AsmStatement;
import at.jku.weiner.c.c.AsmLineWithColon;
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
import at.jku.weiner.c.c.AsmLineWithColon;
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
import at.jku.weiner.c.c.AsmLineWithColon;
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
import at.jku.weiner.c.c.PostfixExpressionSuffixArgument;
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
import at.jku.weiner.c.c.AsmLine;
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
import at.jku.weiner.c.c.PostfixExpressionSuffixArgument;
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
import at.jku.weiner.c.c.AsmLineWithColon;
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
import at.jku.weiner.c.c.PostfixExpressionSuffixArgument;
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
public class Test0030_Assembler2 {
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
				"RULE_LEFTPAREN", 
				"RULE_KW_VOID", 
				"RULE_RIGHTPAREN", 
				"RULE_NEWLINE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_ASM2", 
				"RULE_WHITESPACE", 
				"RULE_LEFTPAREN", 
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
				"RULE_COLON", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_LEFTPAREN", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_COLON", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_LEFTPAREN", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_COLON", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
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
			"res/Test0030_Assembler2.c");
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
		Assert.assertEquals(1, External_1_list.size());
		//1
		final ExternalDeclaration ExternalDeclaration_2_Var
		 = (ExternalDeclaration)External_1_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_2_Var
		);
		//2
		final FunctionDefHead FunctionDefHead_3_Var
		 = (FunctionDefHead)ExternalDeclaration_2_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_3_Var
		);
		//3
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_4_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_3_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_4_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_4_list = FunctionDeclarationSpecifiers_4_Var
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
		//5
		final Declarator Declarator_6_Var
		 = (Declarator)FunctionDefHead_3_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_6_Var
		);
		//6
		final DirectDeclarator DirectDeclarator_7_Var
		 = (DirectDeclarator)Declarator_6_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_7_Var
		);
		Assert.assertEquals("main", DirectDeclarator_7_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_7_list = DirectDeclarator_7_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_7_list);
		Assert.assertEquals(1, DeclaratorSuffix_7_list.size());
		//7
		final DeclaratorSuffix DeclaratorSuffix_8_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_7_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_8_Var
		);
		//8
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_9_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_8_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_9_Var
		);
		final EList<? extends EObject> ParameterTypeList_9_list = DirectDeclaratorLastSuffix_9_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_9_list);
		Assert.assertEquals(1, ParameterTypeList_9_list.size());
		//9
		final ParameterTypeList ParameterTypeList_10_Var
		 = (ParameterTypeList)ParameterTypeList_9_list.get(0);
		Assert.assertNotNull(ParameterTypeList_10_Var
		);
		//10
		final ParameterList ParameterList_11_Var
		 = (ParameterList)ParameterTypeList_10_Var
		.getList();
		Assert.assertNotNull(ParameterList_11_Var
		);
		final EList<? extends EObject> ParameterDeclaration_11_list = ParameterList_11_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_11_list);
		Assert.assertEquals(1, ParameterDeclaration_11_list.size());
		//11
		final ParameterDeclaration ParameterDeclaration_12_Var
		 = (ParameterDeclaration)ParameterDeclaration_11_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_12_Var
		);
		//12
		final DeclarationSpecifiers DeclarationSpecifiers_13_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_12_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_13_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_13_list = DeclarationSpecifiers_13_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_13_list);
		Assert.assertEquals(1, DeclarationSpecifier_13_list.size());
		//13
		final TypeSpecifier TypeSpecifier_14_Var
		 = (TypeSpecifier)DeclarationSpecifier_13_list.get(0);
		Assert.assertNotNull(TypeSpecifier_14_Var
		);
		Assert.assertEquals("void", TypeSpecifier_14_Var
		.getName());
		//14
		final FunctionDefinition FunctionDefinition_15_Var
		 = (FunctionDefinition)ExternalDeclaration_2_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_15_Var
		);
		//15
		final BodyStatement BodyStatement_16_Var
		 = (BodyStatement)FunctionDefinition_15_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_16_Var
		);
		final EList<? extends EObject> BlockList_16_list = BodyStatement_16_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_16_list);
		Assert.assertEquals(1, BlockList_16_list.size());
		//16
		final BlockList BlockList_17_Var
		 = (BlockList)BlockList_16_list.get(0);
		Assert.assertNotNull(BlockList_17_Var
		);
		final EList<? extends EObject> Declaration_17_list = BlockList_17_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_17_list);
		Assert.assertEquals(2, Declaration_17_list.size());
		//17
		final Declaration Declaration_18_Var
		 = (Declaration)Declaration_17_list.get(0);
		Assert.assertNotNull(Declaration_18_Var
		);
		//18
		final DeclarationSpecifiers DeclarationSpecifiers_19_Var
		 = (DeclarationSpecifiers)Declaration_18_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_19_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_19_list = DeclarationSpecifiers_19_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_19_list);
		Assert.assertEquals(1, DeclarationSpecifier_19_list.size());
		//19
		final TypeSpecifier TypeSpecifier_20_Var
		 = (TypeSpecifier)DeclarationSpecifier_19_list.get(0);
		Assert.assertNotNull(TypeSpecifier_20_Var
		);
		Assert.assertEquals("int", TypeSpecifier_20_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_20_list = Declaration_18_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_20_list);
		Assert.assertEquals(1, InitDeclaratorList_20_list.size());
		//20
		final InitDeclaratorList InitDeclaratorList_21_Var
		 = (InitDeclaratorList)InitDeclaratorList_20_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_21_Var
		);
		final EList<? extends EObject> InitDeclarator_21_list = InitDeclaratorList_21_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_21_list);
		Assert.assertEquals(1, InitDeclarator_21_list.size());
		//21
		final InitDeclarator InitDeclarator_22_Var
		 = (InitDeclarator)InitDeclarator_21_list.get(0);
		Assert.assertNotNull(InitDeclarator_22_Var
		);
		//22
		final Declarator Declarator_23_Var
		 = (Declarator)InitDeclarator_22_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_23_Var
		);
		//23
		final DirectDeclarator DirectDeclarator_24_Var
		 = (DirectDeclarator)Declarator_23_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_24_Var
		);
		Assert.assertEquals("foo", DirectDeclarator_24_Var
		.getId());
		//24
		final Initializer Initializer_25_Var
		 = (Initializer)InitDeclarator_22_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_25_Var
		);
		//25
		final AssignmentExpression AssignmentExpression_26_Var
		 = (AssignmentExpression)Initializer_25_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_26_Var
		);
		//26
		final ConditionalExpression ConditionalExpression_27_Var
		 = (ConditionalExpression)AssignmentExpression_26_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_27_Var
		);
		//27
		final LogicalOrExpression LogicalOrExpression_28_Var
		 = (LogicalOrExpression)ConditionalExpression_27_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = LogicalOrExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final LogicalAndExpression LogicalAndExpression_29_Var
		 = (LogicalAndExpression)Expr_28_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = LogicalAndExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final InclusiveOrExpression InclusiveOrExpression_30_Var
		 = (InclusiveOrExpression)Expr_29_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = InclusiveOrExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final ExclusiveOrExpression ExclusiveOrExpression_31_Var
		 = (ExclusiveOrExpression)Expr_30_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = ExclusiveOrExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final AndExpression AndExpression_32_Var
		 = (AndExpression)Expr_31_list.get(0);
		Assert.assertNotNull(AndExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = AndExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final EqualityExpression EqualityExpression_33_Var
		 = (EqualityExpression)Expr_32_list.get(0);
		Assert.assertNotNull(EqualityExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = EqualityExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final RelationalExpression RelationalExpression_34_Var
		 = (RelationalExpression)Expr_33_list.get(0);
		Assert.assertNotNull(RelationalExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = RelationalExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final ShiftExpression ShiftExpression_35_Var
		 = (ShiftExpression)Expr_34_list.get(0);
		Assert.assertNotNull(ShiftExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = ShiftExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final AdditiveExpression AdditiveExpression_36_Var
		 = (AdditiveExpression)Expr_35_list.get(0);
		Assert.assertNotNull(AdditiveExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = AdditiveExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final MultiplicativeExpression MultiplicativeExpression_37_Var
		 = (MultiplicativeExpression)Expr_36_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = MultiplicativeExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final CastExpression CastExpression_38_Var
		 = (CastExpression)Expr_37_list.get(0);
		Assert.assertNotNull(CastExpression_38_Var
		);
		//38
		final UnaryExpression UnaryExpression_39_Var
		 = (UnaryExpression)CastExpression_38_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_39_Var
		);
		//39
		final PostfixExpression PostfixExpression_40_Var
		 = (PostfixExpression)UnaryExpression_39_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = PostfixExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final PrimaryExpression PrimaryExpression_41_Var
		 = (PrimaryExpression)Expr_40_list.get(0);
		Assert.assertNotNull(PrimaryExpression_41_Var
		);
		//41
		final Constant Constant_42_Var
		 = (Constant)PrimaryExpression_41_Var
		.getConst();
		Assert.assertNotNull(Constant_42_Var
		);
		Assert.assertEquals("5", Constant_42_Var
		.getDec());
		Assert.assertEquals(";", Declaration_18_Var
		.getSemi());
		//42
		final Declaration Declaration_43_Var
		 = (Declaration)Declaration_17_list.get(1);
		Assert.assertNotNull(Declaration_43_Var
		);
		//43
		final DeclarationSpecifiers DeclarationSpecifiers_44_Var
		 = (DeclarationSpecifiers)Declaration_43_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_44_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_44_list = DeclarationSpecifiers_44_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_44_list);
		Assert.assertEquals(1, DeclarationSpecifier_44_list.size());
		//44
		final TypeSpecifier TypeSpecifier_45_Var
		 = (TypeSpecifier)DeclarationSpecifier_44_list.get(0);
		Assert.assertNotNull(TypeSpecifier_45_Var
		);
		Assert.assertEquals("int", TypeSpecifier_45_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_45_list = Declaration_43_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_45_list);
		Assert.assertEquals(1, InitDeclaratorList_45_list.size());
		//45
		final InitDeclaratorList InitDeclaratorList_46_Var
		 = (InitDeclaratorList)InitDeclaratorList_45_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_46_Var
		);
		final EList<? extends EObject> InitDeclarator_46_list = InitDeclaratorList_46_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_46_list);
		Assert.assertEquals(1, InitDeclarator_46_list.size());
		//46
		final InitDeclarator InitDeclarator_47_Var
		 = (InitDeclarator)InitDeclarator_46_list.get(0);
		Assert.assertNotNull(InitDeclarator_47_Var
		);
		//47
		final Declarator Declarator_48_Var
		 = (Declarator)InitDeclarator_47_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_48_Var
		);
		//48
		final DirectDeclarator DirectDeclarator_49_Var
		 = (DirectDeclarator)Declarator_48_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_49_Var
		);
		Assert.assertEquals("bar", DirectDeclarator_49_Var
		.getId());
		//49
		final Initializer Initializer_50_Var
		 = (Initializer)InitDeclarator_47_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_50_Var
		);
		//50
		final AssignmentExpression AssignmentExpression_51_Var
		 = (AssignmentExpression)Initializer_50_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_51_Var
		);
		//51
		final ConditionalExpression ConditionalExpression_52_Var
		 = (ConditionalExpression)AssignmentExpression_51_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_52_Var
		);
		//52
		final LogicalOrExpression LogicalOrExpression_53_Var
		 = (LogicalOrExpression)ConditionalExpression_52_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = LogicalOrExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final LogicalAndExpression LogicalAndExpression_54_Var
		 = (LogicalAndExpression)Expr_53_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = LogicalAndExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final InclusiveOrExpression InclusiveOrExpression_55_Var
		 = (InclusiveOrExpression)Expr_54_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = InclusiveOrExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final ExclusiveOrExpression ExclusiveOrExpression_56_Var
		 = (ExclusiveOrExpression)Expr_55_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = ExclusiveOrExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final AndExpression AndExpression_57_Var
		 = (AndExpression)Expr_56_list.get(0);
		Assert.assertNotNull(AndExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = AndExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final EqualityExpression EqualityExpression_58_Var
		 = (EqualityExpression)Expr_57_list.get(0);
		Assert.assertNotNull(EqualityExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = EqualityExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final RelationalExpression RelationalExpression_59_Var
		 = (RelationalExpression)Expr_58_list.get(0);
		Assert.assertNotNull(RelationalExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = RelationalExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final ShiftExpression ShiftExpression_60_Var
		 = (ShiftExpression)Expr_59_list.get(0);
		Assert.assertNotNull(ShiftExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = ShiftExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final AdditiveExpression AdditiveExpression_61_Var
		 = (AdditiveExpression)Expr_60_list.get(0);
		Assert.assertNotNull(AdditiveExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = AdditiveExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final MultiplicativeExpression MultiplicativeExpression_62_Var
		 = (MultiplicativeExpression)Expr_61_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = MultiplicativeExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final CastExpression CastExpression_63_Var
		 = (CastExpression)Expr_62_list.get(0);
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
		//66
		final Constant Constant_67_Var
		 = (Constant)PrimaryExpression_66_Var
		.getConst();
		Assert.assertNotNull(Constant_67_Var
		);
		Assert.assertEquals("4", Constant_67_Var
		.getDec());
		Assert.assertEquals(";", Declaration_43_Var
		.getSemi());
		final EList<? extends EObject> Statement_67_list = BlockList_17_Var
		.getStatement();
		Assert.assertNotNull(Statement_67_list);
		Assert.assertEquals(3, Statement_67_list.size());
		//67
		final Statement Statement_68_Var
		 = (Statement)Statement_67_list.get(0);
		Assert.assertNotNull(Statement_68_Var
		);
		//68
		final AsmStatement AsmStatement_69_Var
		 = (AsmStatement)Statement_68_Var
		.getStmt();
		Assert.assertNotNull(AsmStatement_69_Var
		);
		final EList<? extends EObject> AsmLine_69_list = AsmStatement_69_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLine_69_list);
		Assert.assertEquals(5, AsmLine_69_list.size());
		//69
		final AsmLineWithColon AsmLineWithColon_70_Var
		 = (AsmLineWithColon)AsmLine_69_list.get(0);
		Assert.assertNotNull(AsmLineWithColon_70_Var
		);
		//70
		final LogicalOrExpression LogicalOrExpression_71_Var
		 = (LogicalOrExpression)AsmLineWithColon_70_Var
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
		final Constant Constant_85_Var
		 = (Constant)PrimaryExpression_84_Var
		.getConst();
		Assert.assertNotNull(Constant_85_Var
		);
		Assert.assertEquals("\"add %1, %0\\n\\t\"", Constant_85_Var
		.getStr());
		//85
		final AsmLineWithColon AsmLineWithColon_86_Var
		 = (AsmLineWithColon)AsmLine_69_list.get(1);
		Assert.assertNotNull(AsmLineWithColon_86_Var
		);
		//86
		final LogicalOrExpression LogicalOrExpression_87_Var
		 = (LogicalOrExpression)AsmLineWithColon_86_Var
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
		Assert.assertEquals("\"inc %0\"", Constant_101_Var
		.getStr());
		//101
		final AsmLineWithColon AsmLineWithColon_102_Var
		 = (AsmLineWithColon)AsmLine_69_list.get(2);
		Assert.assertNotNull(AsmLineWithColon_102_Var
		);
		//102
		final LogicalOrExpression LogicalOrExpression_103_Var
		 = (LogicalOrExpression)AsmLineWithColon_102_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = LogicalOrExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final LogicalAndExpression LogicalAndExpression_104_Var
		 = (LogicalAndExpression)Expr_103_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = LogicalAndExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final InclusiveOrExpression InclusiveOrExpression_105_Var
		 = (InclusiveOrExpression)Expr_104_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = InclusiveOrExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final ExclusiveOrExpression ExclusiveOrExpression_106_Var
		 = (ExclusiveOrExpression)Expr_105_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = ExclusiveOrExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final AndExpression AndExpression_107_Var
		 = (AndExpression)Expr_106_list.get(0);
		Assert.assertNotNull(AndExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = AndExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final EqualityExpression EqualityExpression_108_Var
		 = (EqualityExpression)Expr_107_list.get(0);
		Assert.assertNotNull(EqualityExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = EqualityExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final RelationalExpression RelationalExpression_109_Var
		 = (RelationalExpression)Expr_108_list.get(0);
		Assert.assertNotNull(RelationalExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = RelationalExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final ShiftExpression ShiftExpression_110_Var
		 = (ShiftExpression)Expr_109_list.get(0);
		Assert.assertNotNull(ShiftExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = ShiftExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final AdditiveExpression AdditiveExpression_111_Var
		 = (AdditiveExpression)Expr_110_list.get(0);
		Assert.assertNotNull(AdditiveExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = AdditiveExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final MultiplicativeExpression MultiplicativeExpression_112_Var
		 = (MultiplicativeExpression)Expr_111_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = MultiplicativeExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final CastExpression CastExpression_113_Var
		 = (CastExpression)Expr_112_list.get(0);
		Assert.assertNotNull(CastExpression_113_Var
		);
		//113
		final UnaryExpression UnaryExpression_114_Var
		 = (UnaryExpression)CastExpression_113_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_114_Var
		);
		//114
		final PostfixExpression PostfixExpression_115_Var
		 = (PostfixExpression)UnaryExpression_114_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = PostfixExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final PrimaryExpression PrimaryExpression_116_Var
		 = (PrimaryExpression)Expr_115_list.get(0);
		Assert.assertNotNull(PrimaryExpression_116_Var
		);
		//116
		final Constant Constant_117_Var
		 = (Constant)PrimaryExpression_116_Var
		.getConst();
		Assert.assertNotNull(Constant_117_Var
		);
		Assert.assertEquals("\"+r\"", Constant_117_Var
		.getStr());
		final EList<? extends EObject> Suffix_117_list = PostfixExpression_115_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_117_list);
		Assert.assertEquals(1, Suffix_117_list.size());
		//117
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_118_Var
		 = (PostfixExpressionSuffixArgument)Suffix_117_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_118_Var
		);
		//118
		final ArgumentExpressionList ArgumentExpressionList_119_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_118_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_119_Var
		);
		final EList<? extends EObject> Expr_119_list = ArgumentExpressionList_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final AssignmentExpression AssignmentExpression_120_Var
		 = (AssignmentExpression)Expr_119_list.get(0);
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
		Assert.assertEquals("bar", PrimaryExpression_135_Var
		.getId());
		//135
		final AsmLine AsmLine_136_Var
		 = (AsmLine)AsmLine_69_list.get(3);
		Assert.assertNotNull(AsmLine_136_Var
		);
		//136
		final LogicalOrExpression LogicalOrExpression_137_Var
		 = (LogicalOrExpression)AsmLine_136_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = LogicalOrExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final LogicalAndExpression LogicalAndExpression_138_Var
		 = (LogicalAndExpression)Expr_137_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = LogicalAndExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final InclusiveOrExpression InclusiveOrExpression_139_Var
		 = (InclusiveOrExpression)Expr_138_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = InclusiveOrExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final ExclusiveOrExpression ExclusiveOrExpression_140_Var
		 = (ExclusiveOrExpression)Expr_139_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = ExclusiveOrExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final AndExpression AndExpression_141_Var
		 = (AndExpression)Expr_140_list.get(0);
		Assert.assertNotNull(AndExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = AndExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final EqualityExpression EqualityExpression_142_Var
		 = (EqualityExpression)Expr_141_list.get(0);
		Assert.assertNotNull(EqualityExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = EqualityExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final RelationalExpression RelationalExpression_143_Var
		 = (RelationalExpression)Expr_142_list.get(0);
		Assert.assertNotNull(RelationalExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = RelationalExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final ShiftExpression ShiftExpression_144_Var
		 = (ShiftExpression)Expr_143_list.get(0);
		Assert.assertNotNull(ShiftExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = ShiftExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final AdditiveExpression AdditiveExpression_145_Var
		 = (AdditiveExpression)Expr_144_list.get(0);
		Assert.assertNotNull(AdditiveExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = AdditiveExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final MultiplicativeExpression MultiplicativeExpression_146_Var
		 = (MultiplicativeExpression)Expr_145_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_146_Var
		);
		final EList<? extends EObject> Expr_146_list = MultiplicativeExpression_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final CastExpression CastExpression_147_Var
		 = (CastExpression)Expr_146_list.get(0);
		Assert.assertNotNull(CastExpression_147_Var
		);
		//147
		final UnaryExpression UnaryExpression_148_Var
		 = (UnaryExpression)CastExpression_147_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_148_Var
		);
		//148
		final PostfixExpression PostfixExpression_149_Var
		 = (PostfixExpression)UnaryExpression_148_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_149_Var
		);
		final EList<? extends EObject> Expr_149_list = PostfixExpression_149_Var
		.getExpr();
		Assert.assertNotNull(Expr_149_list);
		Assert.assertEquals(1, Expr_149_list.size());
		//149
		final PrimaryExpression PrimaryExpression_150_Var
		 = (PrimaryExpression)Expr_149_list.get(0);
		Assert.assertNotNull(PrimaryExpression_150_Var
		);
		//150
		final Constant Constant_151_Var
		 = (Constant)PrimaryExpression_150_Var
		.getConst();
		Assert.assertNotNull(Constant_151_Var
		);
		Assert.assertEquals("\"g\"", Constant_151_Var
		.getStr());
		final EList<? extends EObject> Suffix_151_list = PostfixExpression_149_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_151_list);
		Assert.assertEquals(1, Suffix_151_list.size());
		//151
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_152_Var
		 = (PostfixExpressionSuffixArgument)Suffix_151_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_152_Var
		);
		//152
		final ArgumentExpressionList ArgumentExpressionList_153_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_152_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_153_Var
		);
		final EList<? extends EObject> Expr_153_list = ArgumentExpressionList_153_Var
		.getExpr();
		Assert.assertNotNull(Expr_153_list);
		Assert.assertEquals(1, Expr_153_list.size());
		//153
		final AssignmentExpression AssignmentExpression_154_Var
		 = (AssignmentExpression)Expr_153_list.get(0);
		Assert.assertNotNull(AssignmentExpression_154_Var
		);
		//154
		final ConditionalExpression ConditionalExpression_155_Var
		 = (ConditionalExpression)AssignmentExpression_154_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_155_Var
		);
		//155
		final LogicalOrExpression LogicalOrExpression_156_Var
		 = (LogicalOrExpression)ConditionalExpression_155_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_156_Var
		);
		final EList<? extends EObject> Expr_156_list = LogicalOrExpression_156_Var
		.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		//156
		final LogicalAndExpression LogicalAndExpression_157_Var
		 = (LogicalAndExpression)Expr_156_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = LogicalAndExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final InclusiveOrExpression InclusiveOrExpression_158_Var
		 = (InclusiveOrExpression)Expr_157_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = InclusiveOrExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final ExclusiveOrExpression ExclusiveOrExpression_159_Var
		 = (ExclusiveOrExpression)Expr_158_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = ExclusiveOrExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final AndExpression AndExpression_160_Var
		 = (AndExpression)Expr_159_list.get(0);
		Assert.assertNotNull(AndExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = AndExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final EqualityExpression EqualityExpression_161_Var
		 = (EqualityExpression)Expr_160_list.get(0);
		Assert.assertNotNull(EqualityExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = EqualityExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final RelationalExpression RelationalExpression_162_Var
		 = (RelationalExpression)Expr_161_list.get(0);
		Assert.assertNotNull(RelationalExpression_162_Var
		);
		final EList<? extends EObject> Expr_162_list = RelationalExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		//162
		final ShiftExpression ShiftExpression_163_Var
		 = (ShiftExpression)Expr_162_list.get(0);
		Assert.assertNotNull(ShiftExpression_163_Var
		);
		final EList<? extends EObject> Expr_163_list = ShiftExpression_163_Var
		.getExpr();
		Assert.assertNotNull(Expr_163_list);
		Assert.assertEquals(1, Expr_163_list.size());
		//163
		final AdditiveExpression AdditiveExpression_164_Var
		 = (AdditiveExpression)Expr_163_list.get(0);
		Assert.assertNotNull(AdditiveExpression_164_Var
		);
		final EList<? extends EObject> Expr_164_list = AdditiveExpression_164_Var
		.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		//164
		final MultiplicativeExpression MultiplicativeExpression_165_Var
		 = (MultiplicativeExpression)Expr_164_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_165_Var
		);
		final EList<? extends EObject> Expr_165_list = MultiplicativeExpression_165_Var
		.getExpr();
		Assert.assertNotNull(Expr_165_list);
		Assert.assertEquals(1, Expr_165_list.size());
		//165
		final CastExpression CastExpression_166_Var
		 = (CastExpression)Expr_165_list.get(0);
		Assert.assertNotNull(CastExpression_166_Var
		);
		//166
		final UnaryExpression UnaryExpression_167_Var
		 = (UnaryExpression)CastExpression_166_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_167_Var
		);
		//167
		final PostfixExpression PostfixExpression_168_Var
		 = (PostfixExpression)UnaryExpression_167_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_168_Var
		);
		final EList<? extends EObject> Expr_168_list = PostfixExpression_168_Var
		.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(1, Expr_168_list.size());
		//168
		final PrimaryExpression PrimaryExpression_169_Var
		 = (PrimaryExpression)Expr_168_list.get(0);
		Assert.assertNotNull(PrimaryExpression_169_Var
		);
		Assert.assertEquals("foo", PrimaryExpression_169_Var
		.getId());
		//169
		final AsmLineWithColon AsmLineWithColon_170_Var
		 = (AsmLineWithColon)AsmLine_69_list.get(4);
		Assert.assertNotNull(AsmLineWithColon_170_Var
		);
		//170
		final LogicalOrExpression LogicalOrExpression_171_Var
		 = (LogicalOrExpression)AsmLineWithColon_170_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_171_Var
		);
		final EList<? extends EObject> Expr_171_list = LogicalOrExpression_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		//171
		final LogicalAndExpression LogicalAndExpression_172_Var
		 = (LogicalAndExpression)Expr_171_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = LogicalAndExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final InclusiveOrExpression InclusiveOrExpression_173_Var
		 = (InclusiveOrExpression)Expr_172_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = InclusiveOrExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final ExclusiveOrExpression ExclusiveOrExpression_174_Var
		 = (ExclusiveOrExpression)Expr_173_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = ExclusiveOrExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final AndExpression AndExpression_175_Var
		 = (AndExpression)Expr_174_list.get(0);
		Assert.assertNotNull(AndExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = AndExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final EqualityExpression EqualityExpression_176_Var
		 = (EqualityExpression)Expr_175_list.get(0);
		Assert.assertNotNull(EqualityExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = EqualityExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final RelationalExpression RelationalExpression_177_Var
		 = (RelationalExpression)Expr_176_list.get(0);
		Assert.assertNotNull(RelationalExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = RelationalExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final ShiftExpression ShiftExpression_178_Var
		 = (ShiftExpression)Expr_177_list.get(0);
		Assert.assertNotNull(ShiftExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = ShiftExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final AdditiveExpression AdditiveExpression_179_Var
		 = (AdditiveExpression)Expr_178_list.get(0);
		Assert.assertNotNull(AdditiveExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = AdditiveExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final MultiplicativeExpression MultiplicativeExpression_180_Var
		 = (MultiplicativeExpression)Expr_179_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_180_Var
		);
		final EList<? extends EObject> Expr_180_list = MultiplicativeExpression_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final CastExpression CastExpression_181_Var
		 = (CastExpression)Expr_180_list.get(0);
		Assert.assertNotNull(CastExpression_181_Var
		);
		//181
		final UnaryExpression UnaryExpression_182_Var
		 = (UnaryExpression)CastExpression_181_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_182_Var
		);
		//182
		final PostfixExpression PostfixExpression_183_Var
		 = (PostfixExpression)UnaryExpression_182_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = PostfixExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final PrimaryExpression PrimaryExpression_184_Var
		 = (PrimaryExpression)Expr_183_list.get(0);
		Assert.assertNotNull(PrimaryExpression_184_Var
		);
		//184
		final Constant Constant_185_Var
		 = (Constant)PrimaryExpression_184_Var
		.getConst();
		Assert.assertNotNull(Constant_185_Var
		);
		Assert.assertEquals("\"cc\"", Constant_185_Var
		.getStr());
		//185
		final Statement Statement_186_Var
		 = (Statement)Statement_67_list.get(1);
		Assert.assertNotNull(Statement_186_Var
		);
		//186
		final ExpressionStatement ExpressionStatement_187_Var
		 = (ExpressionStatement)Statement_186_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_187_Var
		);
		//187
		final Expression Expression_188_Var
		 = (Expression)ExpressionStatement_187_Var
		.getExpression();
		Assert.assertNotNull(Expression_188_Var
		);
		final EList<? extends EObject> ExprExpr_188_list = Expression_188_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_188_list);
		Assert.assertEquals(1, ExprExpr_188_list.size());
		//188
		final AssignmentExpression AssignmentExpression_189_Var
		 = (AssignmentExpression)ExprExpr_188_list.get(0);
		Assert.assertNotNull(AssignmentExpression_189_Var
		);
		//189
		final ConditionalExpression ConditionalExpression_190_Var
		 = (ConditionalExpression)AssignmentExpression_189_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_190_Var
		);
		//190
		final LogicalOrExpression LogicalOrExpression_191_Var
		 = (LogicalOrExpression)ConditionalExpression_190_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = LogicalOrExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final LogicalAndExpression LogicalAndExpression_192_Var
		 = (LogicalAndExpression)Expr_191_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = LogicalAndExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final InclusiveOrExpression InclusiveOrExpression_193_Var
		 = (InclusiveOrExpression)Expr_192_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = InclusiveOrExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final ExclusiveOrExpression ExclusiveOrExpression_194_Var
		 = (ExclusiveOrExpression)Expr_193_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = ExclusiveOrExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final AndExpression AndExpression_195_Var
		 = (AndExpression)Expr_194_list.get(0);
		Assert.assertNotNull(AndExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = AndExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final EqualityExpression EqualityExpression_196_Var
		 = (EqualityExpression)Expr_195_list.get(0);
		Assert.assertNotNull(EqualityExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = EqualityExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final RelationalExpression RelationalExpression_197_Var
		 = (RelationalExpression)Expr_196_list.get(0);
		Assert.assertNotNull(RelationalExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = RelationalExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final ShiftExpression ShiftExpression_198_Var
		 = (ShiftExpression)Expr_197_list.get(0);
		Assert.assertNotNull(ShiftExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = ShiftExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final AdditiveExpression AdditiveExpression_199_Var
		 = (AdditiveExpression)Expr_198_list.get(0);
		Assert.assertNotNull(AdditiveExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = AdditiveExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final MultiplicativeExpression MultiplicativeExpression_200_Var
		 = (MultiplicativeExpression)Expr_199_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = MultiplicativeExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final CastExpression CastExpression_201_Var
		 = (CastExpression)Expr_200_list.get(0);
		Assert.assertNotNull(CastExpression_201_Var
		);
		//201
		final UnaryExpression UnaryExpression_202_Var
		 = (UnaryExpression)CastExpression_201_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_202_Var
		);
		//202
		final PostfixExpression PostfixExpression_203_Var
		 = (PostfixExpression)UnaryExpression_202_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = PostfixExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final PrimaryExpression PrimaryExpression_204_Var
		 = (PrimaryExpression)Expr_203_list.get(0);
		Assert.assertNotNull(PrimaryExpression_204_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_204_Var
		.getId());
		final EList<? extends EObject> Suffix_204_list = PostfixExpression_203_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_204_list);
		Assert.assertEquals(1, Suffix_204_list.size());
		//204
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_205_Var
		 = (PostfixExpressionSuffixArgument)Suffix_204_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_205_Var
		);
		//205
		final ArgumentExpressionList ArgumentExpressionList_206_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_205_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_206_Var
		);
		final EList<? extends EObject> Expr_206_list = ArgumentExpressionList_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(2, Expr_206_list.size());
		//206
		final AssignmentExpression AssignmentExpression_207_Var
		 = (AssignmentExpression)Expr_206_list.get(0);
		Assert.assertNotNull(AssignmentExpression_207_Var
		);
		//207
		final ConditionalExpression ConditionalExpression_208_Var
		 = (ConditionalExpression)AssignmentExpression_207_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_208_Var
		);
		//208
		final LogicalOrExpression LogicalOrExpression_209_Var
		 = (LogicalOrExpression)ConditionalExpression_208_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = LogicalOrExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final LogicalAndExpression LogicalAndExpression_210_Var
		 = (LogicalAndExpression)Expr_209_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = LogicalAndExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final InclusiveOrExpression InclusiveOrExpression_211_Var
		 = (InclusiveOrExpression)Expr_210_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = InclusiveOrExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final ExclusiveOrExpression ExclusiveOrExpression_212_Var
		 = (ExclusiveOrExpression)Expr_211_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = ExclusiveOrExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final AndExpression AndExpression_213_Var
		 = (AndExpression)Expr_212_list.get(0);
		Assert.assertNotNull(AndExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = AndExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final EqualityExpression EqualityExpression_214_Var
		 = (EqualityExpression)Expr_213_list.get(0);
		Assert.assertNotNull(EqualityExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = EqualityExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final RelationalExpression RelationalExpression_215_Var
		 = (RelationalExpression)Expr_214_list.get(0);
		Assert.assertNotNull(RelationalExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = RelationalExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final ShiftExpression ShiftExpression_216_Var
		 = (ShiftExpression)Expr_215_list.get(0);
		Assert.assertNotNull(ShiftExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = ShiftExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final AdditiveExpression AdditiveExpression_217_Var
		 = (AdditiveExpression)Expr_216_list.get(0);
		Assert.assertNotNull(AdditiveExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = AdditiveExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final MultiplicativeExpression MultiplicativeExpression_218_Var
		 = (MultiplicativeExpression)Expr_217_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = MultiplicativeExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final CastExpression CastExpression_219_Var
		 = (CastExpression)Expr_218_list.get(0);
		Assert.assertNotNull(CastExpression_219_Var
		);
		//219
		final UnaryExpression UnaryExpression_220_Var
		 = (UnaryExpression)CastExpression_219_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_220_Var
		);
		//220
		final PostfixExpression PostfixExpression_221_Var
		 = (PostfixExpression)UnaryExpression_220_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = PostfixExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final PrimaryExpression PrimaryExpression_222_Var
		 = (PrimaryExpression)Expr_221_list.get(0);
		Assert.assertNotNull(PrimaryExpression_222_Var
		);
		//222
		final Constant Constant_223_Var
		 = (Constant)PrimaryExpression_222_Var
		.getConst();
		Assert.assertNotNull(Constant_223_Var
		);
		Assert.assertEquals("\"Ergebnis: %i\\n\"", Constant_223_Var
		.getStr());
		//223
		final AssignmentExpression AssignmentExpression_224_Var
		 = (AssignmentExpression)Expr_206_list.get(1);
		Assert.assertNotNull(AssignmentExpression_224_Var
		);
		//224
		final ConditionalExpression ConditionalExpression_225_Var
		 = (ConditionalExpression)AssignmentExpression_224_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_225_Var
		);
		//225
		final LogicalOrExpression LogicalOrExpression_226_Var
		 = (LogicalOrExpression)ConditionalExpression_225_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = LogicalOrExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final LogicalAndExpression LogicalAndExpression_227_Var
		 = (LogicalAndExpression)Expr_226_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = LogicalAndExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final InclusiveOrExpression InclusiveOrExpression_228_Var
		 = (InclusiveOrExpression)Expr_227_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = InclusiveOrExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final ExclusiveOrExpression ExclusiveOrExpression_229_Var
		 = (ExclusiveOrExpression)Expr_228_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = ExclusiveOrExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final AndExpression AndExpression_230_Var
		 = (AndExpression)Expr_229_list.get(0);
		Assert.assertNotNull(AndExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = AndExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final EqualityExpression EqualityExpression_231_Var
		 = (EqualityExpression)Expr_230_list.get(0);
		Assert.assertNotNull(EqualityExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = EqualityExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final RelationalExpression RelationalExpression_232_Var
		 = (RelationalExpression)Expr_231_list.get(0);
		Assert.assertNotNull(RelationalExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = RelationalExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final ShiftExpression ShiftExpression_233_Var
		 = (ShiftExpression)Expr_232_list.get(0);
		Assert.assertNotNull(ShiftExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = ShiftExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final AdditiveExpression AdditiveExpression_234_Var
		 = (AdditiveExpression)Expr_233_list.get(0);
		Assert.assertNotNull(AdditiveExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = AdditiveExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final MultiplicativeExpression MultiplicativeExpression_235_Var
		 = (MultiplicativeExpression)Expr_234_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = MultiplicativeExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final CastExpression CastExpression_236_Var
		 = (CastExpression)Expr_235_list.get(0);
		Assert.assertNotNull(CastExpression_236_Var
		);
		//236
		final UnaryExpression UnaryExpression_237_Var
		 = (UnaryExpression)CastExpression_236_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_237_Var
		);
		//237
		final PostfixExpression PostfixExpression_238_Var
		 = (PostfixExpression)UnaryExpression_237_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = PostfixExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final PrimaryExpression PrimaryExpression_239_Var
		 = (PrimaryExpression)Expr_238_list.get(0);
		Assert.assertNotNull(PrimaryExpression_239_Var
		);
		Assert.assertEquals("bar", PrimaryExpression_239_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_187_Var
		.getSemi());
		//239
		final Statement Statement_240_Var
		 = (Statement)Statement_67_list.get(2);
		Assert.assertNotNull(Statement_240_Var
		);
		//240
		final JumpStatement JumpStatement_241_Var
		 = (JumpStatement)Statement_240_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_241_Var
		);
		//241
		final Expression Expression_242_Var
		 = (Expression)JumpStatement_241_Var
		.getExpr();
		Assert.assertNotNull(Expression_242_Var
		);
		final EList<? extends EObject> ExprExpr_242_list = Expression_242_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_242_list);
		Assert.assertEquals(1, ExprExpr_242_list.size());
		//242
		final AssignmentExpression AssignmentExpression_243_Var
		 = (AssignmentExpression)ExprExpr_242_list.get(0);
		Assert.assertNotNull(AssignmentExpression_243_Var
		);
		//243
		final ConditionalExpression ConditionalExpression_244_Var
		 = (ConditionalExpression)AssignmentExpression_243_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_244_Var
		);
		//244
		final LogicalOrExpression LogicalOrExpression_245_Var
		 = (LogicalOrExpression)ConditionalExpression_244_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = LogicalOrExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final LogicalAndExpression LogicalAndExpression_246_Var
		 = (LogicalAndExpression)Expr_245_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = LogicalAndExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final InclusiveOrExpression InclusiveOrExpression_247_Var
		 = (InclusiveOrExpression)Expr_246_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = InclusiveOrExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final ExclusiveOrExpression ExclusiveOrExpression_248_Var
		 = (ExclusiveOrExpression)Expr_247_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = ExclusiveOrExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final AndExpression AndExpression_249_Var
		 = (AndExpression)Expr_248_list.get(0);
		Assert.assertNotNull(AndExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = AndExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final EqualityExpression EqualityExpression_250_Var
		 = (EqualityExpression)Expr_249_list.get(0);
		Assert.assertNotNull(EqualityExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = EqualityExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final RelationalExpression RelationalExpression_251_Var
		 = (RelationalExpression)Expr_250_list.get(0);
		Assert.assertNotNull(RelationalExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = RelationalExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final ShiftExpression ShiftExpression_252_Var
		 = (ShiftExpression)Expr_251_list.get(0);
		Assert.assertNotNull(ShiftExpression_252_Var
		);
		final EList<? extends EObject> Expr_252_list = ShiftExpression_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(1, Expr_252_list.size());
		//252
		final AdditiveExpression AdditiveExpression_253_Var
		 = (AdditiveExpression)Expr_252_list.get(0);
		Assert.assertNotNull(AdditiveExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = AdditiveExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final MultiplicativeExpression MultiplicativeExpression_254_Var
		 = (MultiplicativeExpression)Expr_253_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = MultiplicativeExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final CastExpression CastExpression_255_Var
		 = (CastExpression)Expr_254_list.get(0);
		Assert.assertNotNull(CastExpression_255_Var
		);
		//255
		final UnaryExpression UnaryExpression_256_Var
		 = (UnaryExpression)CastExpression_255_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_256_Var
		);
		//256
		final PostfixExpression PostfixExpression_257_Var
		 = (PostfixExpression)UnaryExpression_256_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = PostfixExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final PrimaryExpression PrimaryExpression_258_Var
		 = (PrimaryExpression)Expr_257_list.get(0);
		Assert.assertNotNull(PrimaryExpression_258_Var
		);
		//258
		final Constant Constant_259_Var
		 = (Constant)PrimaryExpression_258_Var
		.getConst();
		Assert.assertNotNull(Constant_259_Var
		);
		Assert.assertEquals("0", Constant_259_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_241_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_241_Var
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


