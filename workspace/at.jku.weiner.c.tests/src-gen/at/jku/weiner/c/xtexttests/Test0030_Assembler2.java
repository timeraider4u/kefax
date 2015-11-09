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
		final EList<? extends EObject> ArgumentExpressionList_117_list = PostfixExpression_115_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_117_list);
		Assert.assertEquals(1, ArgumentExpressionList_117_list.size());
		//117
		final ArgumentExpressionList ArgumentExpressionList_118_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_117_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_118_Var
		);
		final EList<? extends EObject> Expr_118_list = ArgumentExpressionList_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final AssignmentExpression AssignmentExpression_119_Var
		 = (AssignmentExpression)Expr_118_list.get(0);
		Assert.assertNotNull(AssignmentExpression_119_Var
		);
		//119
		final ConditionalExpression ConditionalExpression_120_Var
		 = (ConditionalExpression)AssignmentExpression_119_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_120_Var
		);
		//120
		final LogicalOrExpression LogicalOrExpression_121_Var
		 = (LogicalOrExpression)ConditionalExpression_120_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = LogicalOrExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final LogicalAndExpression LogicalAndExpression_122_Var
		 = (LogicalAndExpression)Expr_121_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = LogicalAndExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final InclusiveOrExpression InclusiveOrExpression_123_Var
		 = (InclusiveOrExpression)Expr_122_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = InclusiveOrExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final ExclusiveOrExpression ExclusiveOrExpression_124_Var
		 = (ExclusiveOrExpression)Expr_123_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = ExclusiveOrExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final AndExpression AndExpression_125_Var
		 = (AndExpression)Expr_124_list.get(0);
		Assert.assertNotNull(AndExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = AndExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final EqualityExpression EqualityExpression_126_Var
		 = (EqualityExpression)Expr_125_list.get(0);
		Assert.assertNotNull(EqualityExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = EqualityExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final RelationalExpression RelationalExpression_127_Var
		 = (RelationalExpression)Expr_126_list.get(0);
		Assert.assertNotNull(RelationalExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = RelationalExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final ShiftExpression ShiftExpression_128_Var
		 = (ShiftExpression)Expr_127_list.get(0);
		Assert.assertNotNull(ShiftExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = ShiftExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final AdditiveExpression AdditiveExpression_129_Var
		 = (AdditiveExpression)Expr_128_list.get(0);
		Assert.assertNotNull(AdditiveExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = AdditiveExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final MultiplicativeExpression MultiplicativeExpression_130_Var
		 = (MultiplicativeExpression)Expr_129_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = MultiplicativeExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final CastExpression CastExpression_131_Var
		 = (CastExpression)Expr_130_list.get(0);
		Assert.assertNotNull(CastExpression_131_Var
		);
		//131
		final UnaryExpression UnaryExpression_132_Var
		 = (UnaryExpression)CastExpression_131_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_132_Var
		);
		//132
		final PostfixExpression PostfixExpression_133_Var
		 = (PostfixExpression)UnaryExpression_132_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = PostfixExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final PrimaryExpression PrimaryExpression_134_Var
		 = (PrimaryExpression)Expr_133_list.get(0);
		Assert.assertNotNull(PrimaryExpression_134_Var
		);
		Assert.assertEquals("bar", PrimaryExpression_134_Var
		.getId());
		//134
		final AsmLine AsmLine_135_Var
		 = (AsmLine)AsmLine_69_list.get(3);
		Assert.assertNotNull(AsmLine_135_Var
		);
		//135
		final LogicalOrExpression LogicalOrExpression_136_Var
		 = (LogicalOrExpression)AsmLine_135_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = LogicalOrExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final LogicalAndExpression LogicalAndExpression_137_Var
		 = (LogicalAndExpression)Expr_136_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = LogicalAndExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final InclusiveOrExpression InclusiveOrExpression_138_Var
		 = (InclusiveOrExpression)Expr_137_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = InclusiveOrExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final ExclusiveOrExpression ExclusiveOrExpression_139_Var
		 = (ExclusiveOrExpression)Expr_138_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = ExclusiveOrExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final AndExpression AndExpression_140_Var
		 = (AndExpression)Expr_139_list.get(0);
		Assert.assertNotNull(AndExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = AndExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final EqualityExpression EqualityExpression_141_Var
		 = (EqualityExpression)Expr_140_list.get(0);
		Assert.assertNotNull(EqualityExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = EqualityExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final RelationalExpression RelationalExpression_142_Var
		 = (RelationalExpression)Expr_141_list.get(0);
		Assert.assertNotNull(RelationalExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = RelationalExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final ShiftExpression ShiftExpression_143_Var
		 = (ShiftExpression)Expr_142_list.get(0);
		Assert.assertNotNull(ShiftExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = ShiftExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final AdditiveExpression AdditiveExpression_144_Var
		 = (AdditiveExpression)Expr_143_list.get(0);
		Assert.assertNotNull(AdditiveExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = AdditiveExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final MultiplicativeExpression MultiplicativeExpression_145_Var
		 = (MultiplicativeExpression)Expr_144_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = MultiplicativeExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final CastExpression CastExpression_146_Var
		 = (CastExpression)Expr_145_list.get(0);
		Assert.assertNotNull(CastExpression_146_Var
		);
		//146
		final UnaryExpression UnaryExpression_147_Var
		 = (UnaryExpression)CastExpression_146_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_147_Var
		);
		//147
		final PostfixExpression PostfixExpression_148_Var
		 = (PostfixExpression)UnaryExpression_147_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_148_Var
		);
		final EList<? extends EObject> Expr_148_list = PostfixExpression_148_Var
		.getExpr();
		Assert.assertNotNull(Expr_148_list);
		Assert.assertEquals(1, Expr_148_list.size());
		//148
		final PrimaryExpression PrimaryExpression_149_Var
		 = (PrimaryExpression)Expr_148_list.get(0);
		Assert.assertNotNull(PrimaryExpression_149_Var
		);
		//149
		final Constant Constant_150_Var
		 = (Constant)PrimaryExpression_149_Var
		.getConst();
		Assert.assertNotNull(Constant_150_Var
		);
		Assert.assertEquals("\"g\"", Constant_150_Var
		.getStr());
		final EList<? extends EObject> ArgumentExpressionList_150_list = PostfixExpression_148_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_150_list);
		Assert.assertEquals(1, ArgumentExpressionList_150_list.size());
		//150
		final ArgumentExpressionList ArgumentExpressionList_151_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_150_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_151_Var
		);
		final EList<? extends EObject> Expr_151_list = ArgumentExpressionList_151_Var
		.getExpr();
		Assert.assertNotNull(Expr_151_list);
		Assert.assertEquals(1, Expr_151_list.size());
		//151
		final AssignmentExpression AssignmentExpression_152_Var
		 = (AssignmentExpression)Expr_151_list.get(0);
		Assert.assertNotNull(AssignmentExpression_152_Var
		);
		//152
		final ConditionalExpression ConditionalExpression_153_Var
		 = (ConditionalExpression)AssignmentExpression_152_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_153_Var
		);
		//153
		final LogicalOrExpression LogicalOrExpression_154_Var
		 = (LogicalOrExpression)ConditionalExpression_153_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_154_Var
		);
		final EList<? extends EObject> Expr_154_list = LogicalOrExpression_154_Var
		.getExpr();
		Assert.assertNotNull(Expr_154_list);
		Assert.assertEquals(1, Expr_154_list.size());
		//154
		final LogicalAndExpression LogicalAndExpression_155_Var
		 = (LogicalAndExpression)Expr_154_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_155_Var
		);
		final EList<? extends EObject> Expr_155_list = LogicalAndExpression_155_Var
		.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		//155
		final InclusiveOrExpression InclusiveOrExpression_156_Var
		 = (InclusiveOrExpression)Expr_155_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_156_Var
		);
		final EList<? extends EObject> Expr_156_list = InclusiveOrExpression_156_Var
		.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		//156
		final ExclusiveOrExpression ExclusiveOrExpression_157_Var
		 = (ExclusiveOrExpression)Expr_156_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = ExclusiveOrExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final AndExpression AndExpression_158_Var
		 = (AndExpression)Expr_157_list.get(0);
		Assert.assertNotNull(AndExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = AndExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final EqualityExpression EqualityExpression_159_Var
		 = (EqualityExpression)Expr_158_list.get(0);
		Assert.assertNotNull(EqualityExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = EqualityExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final RelationalExpression RelationalExpression_160_Var
		 = (RelationalExpression)Expr_159_list.get(0);
		Assert.assertNotNull(RelationalExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = RelationalExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final ShiftExpression ShiftExpression_161_Var
		 = (ShiftExpression)Expr_160_list.get(0);
		Assert.assertNotNull(ShiftExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = ShiftExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final AdditiveExpression AdditiveExpression_162_Var
		 = (AdditiveExpression)Expr_161_list.get(0);
		Assert.assertNotNull(AdditiveExpression_162_Var
		);
		final EList<? extends EObject> Expr_162_list = AdditiveExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		//162
		final MultiplicativeExpression MultiplicativeExpression_163_Var
		 = (MultiplicativeExpression)Expr_162_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_163_Var
		);
		final EList<? extends EObject> Expr_163_list = MultiplicativeExpression_163_Var
		.getExpr();
		Assert.assertNotNull(Expr_163_list);
		Assert.assertEquals(1, Expr_163_list.size());
		//163
		final CastExpression CastExpression_164_Var
		 = (CastExpression)Expr_163_list.get(0);
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
		Assert.assertEquals("foo", PrimaryExpression_167_Var
		.getId());
		//167
		final AsmLineWithColon AsmLineWithColon_168_Var
		 = (AsmLineWithColon)AsmLine_69_list.get(4);
		Assert.assertNotNull(AsmLineWithColon_168_Var
		);
		//168
		final LogicalOrExpression LogicalOrExpression_169_Var
		 = (LogicalOrExpression)AsmLineWithColon_168_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_169_Var
		);
		final EList<? extends EObject> Expr_169_list = LogicalOrExpression_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		//169
		final LogicalAndExpression LogicalAndExpression_170_Var
		 = (LogicalAndExpression)Expr_169_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_170_Var
		);
		final EList<? extends EObject> Expr_170_list = LogicalAndExpression_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		//170
		final InclusiveOrExpression InclusiveOrExpression_171_Var
		 = (InclusiveOrExpression)Expr_170_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_171_Var
		);
		final EList<? extends EObject> Expr_171_list = InclusiveOrExpression_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		//171
		final ExclusiveOrExpression ExclusiveOrExpression_172_Var
		 = (ExclusiveOrExpression)Expr_171_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = ExclusiveOrExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final AndExpression AndExpression_173_Var
		 = (AndExpression)Expr_172_list.get(0);
		Assert.assertNotNull(AndExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = AndExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final EqualityExpression EqualityExpression_174_Var
		 = (EqualityExpression)Expr_173_list.get(0);
		Assert.assertNotNull(EqualityExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = EqualityExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final RelationalExpression RelationalExpression_175_Var
		 = (RelationalExpression)Expr_174_list.get(0);
		Assert.assertNotNull(RelationalExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = RelationalExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final ShiftExpression ShiftExpression_176_Var
		 = (ShiftExpression)Expr_175_list.get(0);
		Assert.assertNotNull(ShiftExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = ShiftExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final AdditiveExpression AdditiveExpression_177_Var
		 = (AdditiveExpression)Expr_176_list.get(0);
		Assert.assertNotNull(AdditiveExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = AdditiveExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final MultiplicativeExpression MultiplicativeExpression_178_Var
		 = (MultiplicativeExpression)Expr_177_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = MultiplicativeExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final CastExpression CastExpression_179_Var
		 = (CastExpression)Expr_178_list.get(0);
		Assert.assertNotNull(CastExpression_179_Var
		);
		//179
		final UnaryExpression UnaryExpression_180_Var
		 = (UnaryExpression)CastExpression_179_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_180_Var
		);
		//180
		final PostfixExpression PostfixExpression_181_Var
		 = (PostfixExpression)UnaryExpression_180_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_181_Var
		);
		final EList<? extends EObject> Expr_181_list = PostfixExpression_181_Var
		.getExpr();
		Assert.assertNotNull(Expr_181_list);
		Assert.assertEquals(1, Expr_181_list.size());
		//181
		final PrimaryExpression PrimaryExpression_182_Var
		 = (PrimaryExpression)Expr_181_list.get(0);
		Assert.assertNotNull(PrimaryExpression_182_Var
		);
		//182
		final Constant Constant_183_Var
		 = (Constant)PrimaryExpression_182_Var
		.getConst();
		Assert.assertNotNull(Constant_183_Var
		);
		Assert.assertEquals("\"cc\"", Constant_183_Var
		.getStr());
		//183
		final Statement Statement_184_Var
		 = (Statement)Statement_67_list.get(1);
		Assert.assertNotNull(Statement_184_Var
		);
		//184
		final ExpressionStatement ExpressionStatement_185_Var
		 = (ExpressionStatement)Statement_184_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_185_Var
		);
		//185
		final Expression Expression_186_Var
		 = (Expression)ExpressionStatement_185_Var
		.getExpression();
		Assert.assertNotNull(Expression_186_Var
		);
		final EList<? extends EObject> ExprExpr_186_list = Expression_186_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_186_list);
		Assert.assertEquals(1, ExprExpr_186_list.size());
		//186
		final AssignmentExpression AssignmentExpression_187_Var
		 = (AssignmentExpression)ExprExpr_186_list.get(0);
		Assert.assertNotNull(AssignmentExpression_187_Var
		);
		//187
		final ConditionalExpression ConditionalExpression_188_Var
		 = (ConditionalExpression)AssignmentExpression_187_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_188_Var
		);
		//188
		final LogicalOrExpression LogicalOrExpression_189_Var
		 = (LogicalOrExpression)ConditionalExpression_188_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = LogicalOrExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final LogicalAndExpression LogicalAndExpression_190_Var
		 = (LogicalAndExpression)Expr_189_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = LogicalAndExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final InclusiveOrExpression InclusiveOrExpression_191_Var
		 = (InclusiveOrExpression)Expr_190_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = InclusiveOrExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final ExclusiveOrExpression ExclusiveOrExpression_192_Var
		 = (ExclusiveOrExpression)Expr_191_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = ExclusiveOrExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final AndExpression AndExpression_193_Var
		 = (AndExpression)Expr_192_list.get(0);
		Assert.assertNotNull(AndExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = AndExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final EqualityExpression EqualityExpression_194_Var
		 = (EqualityExpression)Expr_193_list.get(0);
		Assert.assertNotNull(EqualityExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = EqualityExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final RelationalExpression RelationalExpression_195_Var
		 = (RelationalExpression)Expr_194_list.get(0);
		Assert.assertNotNull(RelationalExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = RelationalExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final ShiftExpression ShiftExpression_196_Var
		 = (ShiftExpression)Expr_195_list.get(0);
		Assert.assertNotNull(ShiftExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = ShiftExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final AdditiveExpression AdditiveExpression_197_Var
		 = (AdditiveExpression)Expr_196_list.get(0);
		Assert.assertNotNull(AdditiveExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = AdditiveExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final MultiplicativeExpression MultiplicativeExpression_198_Var
		 = (MultiplicativeExpression)Expr_197_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = MultiplicativeExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final CastExpression CastExpression_199_Var
		 = (CastExpression)Expr_198_list.get(0);
		Assert.assertNotNull(CastExpression_199_Var
		);
		//199
		final UnaryExpression UnaryExpression_200_Var
		 = (UnaryExpression)CastExpression_199_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_200_Var
		);
		//200
		final PostfixExpression PostfixExpression_201_Var
		 = (PostfixExpression)UnaryExpression_200_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = PostfixExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final PrimaryExpression PrimaryExpression_202_Var
		 = (PrimaryExpression)Expr_201_list.get(0);
		Assert.assertNotNull(PrimaryExpression_202_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_202_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_202_list = PostfixExpression_201_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_202_list);
		Assert.assertEquals(1, ArgumentExpressionList_202_list.size());
		//202
		final ArgumentExpressionList ArgumentExpressionList_203_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_202_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_203_Var
		);
		final EList<? extends EObject> Expr_203_list = ArgumentExpressionList_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(2, Expr_203_list.size());
		//203
		final AssignmentExpression AssignmentExpression_204_Var
		 = (AssignmentExpression)Expr_203_list.get(0);
		Assert.assertNotNull(AssignmentExpression_204_Var
		);
		//204
		final ConditionalExpression ConditionalExpression_205_Var
		 = (ConditionalExpression)AssignmentExpression_204_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_205_Var
		);
		//205
		final LogicalOrExpression LogicalOrExpression_206_Var
		 = (LogicalOrExpression)ConditionalExpression_205_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = LogicalOrExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final LogicalAndExpression LogicalAndExpression_207_Var
		 = (LogicalAndExpression)Expr_206_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = LogicalAndExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final InclusiveOrExpression InclusiveOrExpression_208_Var
		 = (InclusiveOrExpression)Expr_207_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = InclusiveOrExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final ExclusiveOrExpression ExclusiveOrExpression_209_Var
		 = (ExclusiveOrExpression)Expr_208_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = ExclusiveOrExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final AndExpression AndExpression_210_Var
		 = (AndExpression)Expr_209_list.get(0);
		Assert.assertNotNull(AndExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = AndExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final EqualityExpression EqualityExpression_211_Var
		 = (EqualityExpression)Expr_210_list.get(0);
		Assert.assertNotNull(EqualityExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = EqualityExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final RelationalExpression RelationalExpression_212_Var
		 = (RelationalExpression)Expr_211_list.get(0);
		Assert.assertNotNull(RelationalExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = RelationalExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final ShiftExpression ShiftExpression_213_Var
		 = (ShiftExpression)Expr_212_list.get(0);
		Assert.assertNotNull(ShiftExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = ShiftExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final AdditiveExpression AdditiveExpression_214_Var
		 = (AdditiveExpression)Expr_213_list.get(0);
		Assert.assertNotNull(AdditiveExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = AdditiveExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final MultiplicativeExpression MultiplicativeExpression_215_Var
		 = (MultiplicativeExpression)Expr_214_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = MultiplicativeExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final CastExpression CastExpression_216_Var
		 = (CastExpression)Expr_215_list.get(0);
		Assert.assertNotNull(CastExpression_216_Var
		);
		//216
		final UnaryExpression UnaryExpression_217_Var
		 = (UnaryExpression)CastExpression_216_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_217_Var
		);
		//217
		final PostfixExpression PostfixExpression_218_Var
		 = (PostfixExpression)UnaryExpression_217_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = PostfixExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final PrimaryExpression PrimaryExpression_219_Var
		 = (PrimaryExpression)Expr_218_list.get(0);
		Assert.assertNotNull(PrimaryExpression_219_Var
		);
		//219
		final Constant Constant_220_Var
		 = (Constant)PrimaryExpression_219_Var
		.getConst();
		Assert.assertNotNull(Constant_220_Var
		);
		Assert.assertEquals("\"Ergebnis: %i\\n\"", Constant_220_Var
		.getStr());
		//220
		final AssignmentExpression AssignmentExpression_221_Var
		 = (AssignmentExpression)Expr_203_list.get(1);
		Assert.assertNotNull(AssignmentExpression_221_Var
		);
		//221
		final ConditionalExpression ConditionalExpression_222_Var
		 = (ConditionalExpression)AssignmentExpression_221_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_222_Var
		);
		//222
		final LogicalOrExpression LogicalOrExpression_223_Var
		 = (LogicalOrExpression)ConditionalExpression_222_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = LogicalOrExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final LogicalAndExpression LogicalAndExpression_224_Var
		 = (LogicalAndExpression)Expr_223_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = LogicalAndExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final InclusiveOrExpression InclusiveOrExpression_225_Var
		 = (InclusiveOrExpression)Expr_224_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = InclusiveOrExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final ExclusiveOrExpression ExclusiveOrExpression_226_Var
		 = (ExclusiveOrExpression)Expr_225_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = ExclusiveOrExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final AndExpression AndExpression_227_Var
		 = (AndExpression)Expr_226_list.get(0);
		Assert.assertNotNull(AndExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = AndExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final EqualityExpression EqualityExpression_228_Var
		 = (EqualityExpression)Expr_227_list.get(0);
		Assert.assertNotNull(EqualityExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = EqualityExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final RelationalExpression RelationalExpression_229_Var
		 = (RelationalExpression)Expr_228_list.get(0);
		Assert.assertNotNull(RelationalExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = RelationalExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final ShiftExpression ShiftExpression_230_Var
		 = (ShiftExpression)Expr_229_list.get(0);
		Assert.assertNotNull(ShiftExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = ShiftExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final AdditiveExpression AdditiveExpression_231_Var
		 = (AdditiveExpression)Expr_230_list.get(0);
		Assert.assertNotNull(AdditiveExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = AdditiveExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final MultiplicativeExpression MultiplicativeExpression_232_Var
		 = (MultiplicativeExpression)Expr_231_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = MultiplicativeExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final CastExpression CastExpression_233_Var
		 = (CastExpression)Expr_232_list.get(0);
		Assert.assertNotNull(CastExpression_233_Var
		);
		//233
		final UnaryExpression UnaryExpression_234_Var
		 = (UnaryExpression)CastExpression_233_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_234_Var
		);
		//234
		final PostfixExpression PostfixExpression_235_Var
		 = (PostfixExpression)UnaryExpression_234_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = PostfixExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final PrimaryExpression PrimaryExpression_236_Var
		 = (PrimaryExpression)Expr_235_list.get(0);
		Assert.assertNotNull(PrimaryExpression_236_Var
		);
		Assert.assertEquals("bar", PrimaryExpression_236_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_185_Var
		.getSemi());
		//236
		final Statement Statement_237_Var
		 = (Statement)Statement_67_list.get(2);
		Assert.assertNotNull(Statement_237_Var
		);
		//237
		final JumpStatement JumpStatement_238_Var
		 = (JumpStatement)Statement_237_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_238_Var
		);
		//238
		final Expression Expression_239_Var
		 = (Expression)JumpStatement_238_Var
		.getExpr();
		Assert.assertNotNull(Expression_239_Var
		);
		final EList<? extends EObject> ExprExpr_239_list = Expression_239_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_239_list);
		Assert.assertEquals(1, ExprExpr_239_list.size());
		//239
		final AssignmentExpression AssignmentExpression_240_Var
		 = (AssignmentExpression)ExprExpr_239_list.get(0);
		Assert.assertNotNull(AssignmentExpression_240_Var
		);
		//240
		final ConditionalExpression ConditionalExpression_241_Var
		 = (ConditionalExpression)AssignmentExpression_240_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_241_Var
		);
		//241
		final LogicalOrExpression LogicalOrExpression_242_Var
		 = (LogicalOrExpression)ConditionalExpression_241_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = LogicalOrExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final LogicalAndExpression LogicalAndExpression_243_Var
		 = (LogicalAndExpression)Expr_242_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = LogicalAndExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final InclusiveOrExpression InclusiveOrExpression_244_Var
		 = (InclusiveOrExpression)Expr_243_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = InclusiveOrExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final ExclusiveOrExpression ExclusiveOrExpression_245_Var
		 = (ExclusiveOrExpression)Expr_244_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = ExclusiveOrExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final AndExpression AndExpression_246_Var
		 = (AndExpression)Expr_245_list.get(0);
		Assert.assertNotNull(AndExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = AndExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final EqualityExpression EqualityExpression_247_Var
		 = (EqualityExpression)Expr_246_list.get(0);
		Assert.assertNotNull(EqualityExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = EqualityExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final RelationalExpression RelationalExpression_248_Var
		 = (RelationalExpression)Expr_247_list.get(0);
		Assert.assertNotNull(RelationalExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = RelationalExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final ShiftExpression ShiftExpression_249_Var
		 = (ShiftExpression)Expr_248_list.get(0);
		Assert.assertNotNull(ShiftExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = ShiftExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final AdditiveExpression AdditiveExpression_250_Var
		 = (AdditiveExpression)Expr_249_list.get(0);
		Assert.assertNotNull(AdditiveExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = AdditiveExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final MultiplicativeExpression MultiplicativeExpression_251_Var
		 = (MultiplicativeExpression)Expr_250_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = MultiplicativeExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final CastExpression CastExpression_252_Var
		 = (CastExpression)Expr_251_list.get(0);
		Assert.assertNotNull(CastExpression_252_Var
		);
		//252
		final UnaryExpression UnaryExpression_253_Var
		 = (UnaryExpression)CastExpression_252_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_253_Var
		);
		//253
		final PostfixExpression PostfixExpression_254_Var
		 = (PostfixExpression)UnaryExpression_253_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = PostfixExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final PrimaryExpression PrimaryExpression_255_Var
		 = (PrimaryExpression)Expr_254_list.get(0);
		Assert.assertNotNull(PrimaryExpression_255_Var
		);
		//255
		final Constant Constant_256_Var
		 = (Constant)PrimaryExpression_255_Var
		.getConst();
		Assert.assertNotNull(Constant_256_Var
		);
		Assert.assertEquals("0", Constant_256_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_238_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_238_Var
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


