package at.jku.weiner.c.xtexttests;

import com.google.inject.Inject;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.antlr.runtime.Token;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.junit4.XtextRunner;
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
import at.jku.weiner.c.c.DeclarationSpecifiers;
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
	
	private LexerAndParserTest testHelper;
	
	@Before
	public void initialize(){
		this.testHelper = new LexerAndParserTest(lexer, parser, tokenDefProvider);
	}
	
	private String getSourceText()
	throws Exception{
		final Path path = Paths.get("res/Test0030_Assembler2.c");
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
	@Test
	public void checkLexerTokens()
	throws Exception{
		final String text = this.getSourceText();
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
	public void checkParserResult()
	throws Exception{

		final String text = this.getSourceText();
		final Model Model_0_Var = this.parseHelper.parse(text);
	
		this.valHelper.assertNoErrors(Model_0_Var);
		Assert.assertNotNull(Model_0_Var);
		final EList<? extends EObject> Unit_0_list = Model_0_Var.getUnit();
		Assert.assertNotNull(Unit_0_list);
		Assert.assertEquals(1, Unit_0_list.size());
		final TranslationUnit TranslationUnit_1_Var = (TranslationUnit)Unit_0_list.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var);
		final EList<? extends EObject> External_1_list = TranslationUnit_1_Var.getExternal();
		Assert.assertNotNull(External_1_list);
		Assert.assertEquals(1, External_1_list.size());
		final ExternalDeclaration ExternalDeclaration_2_Var = (ExternalDeclaration)External_1_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_2_Var);
		final FunctionDefHead FunctionDefHead_3_Var = (FunctionDefHead)ExternalDeclaration_2_Var.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_3_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_4_Var = (DeclarationSpecifiers)FunctionDefHead_3_Var.getFunDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_4_Var);
		final EList<? extends EObject> DeclarationSpecifier_4_list = DeclarationSpecifiers_4_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_4_list);
		Assert.assertEquals(1, DeclarationSpecifier_4_list.size());
		final TypeSpecifier TypeSpecifier_5_Var = (TypeSpecifier)DeclarationSpecifier_4_list.get(0);
		Assert.assertNotNull(TypeSpecifier_5_Var);
		Assert.assertEquals("int", TypeSpecifier_5_Var.getName());
		final Declarator Declarator_6_Var = (Declarator)FunctionDefHead_3_Var.getFunDeclarator();
		Assert.assertNotNull(Declarator_6_Var);
		final DirectDeclarator DirectDeclarator_7_Var = (DirectDeclarator)Declarator_6_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_7_Var);
		Assert.assertEquals("main", DirectDeclarator_7_Var.getId());
		final EList<? extends EObject> DeclaratorSuffix_7_list = DirectDeclarator_7_Var.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_7_list);
		Assert.assertEquals(1, DeclaratorSuffix_7_list.size());
		final DeclaratorSuffix DeclaratorSuffix_8_Var = (DeclaratorSuffix)DeclaratorSuffix_7_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_8_Var);
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_9_Var = (DirectDeclaratorLastSuffix)DeclaratorSuffix_8_Var.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_9_Var);
		final EList<? extends EObject> ParameterTypeList_9_list = DirectDeclaratorLastSuffix_9_Var.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_9_list);
		Assert.assertEquals(1, ParameterTypeList_9_list.size());
		final ParameterTypeList ParameterTypeList_10_Var = (ParameterTypeList)ParameterTypeList_9_list.get(0);
		Assert.assertNotNull(ParameterTypeList_10_Var);
		final ParameterList ParameterList_11_Var = (ParameterList)ParameterTypeList_10_Var.getList();
		Assert.assertNotNull(ParameterList_11_Var);
		final EList<? extends EObject> ParameterDeclaration_11_list = ParameterList_11_Var.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_11_list);
		Assert.assertEquals(1, ParameterDeclaration_11_list.size());
		final ParameterDeclaration ParameterDeclaration_12_Var = (ParameterDeclaration)ParameterDeclaration_11_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_12_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_13_Var = (DeclarationSpecifiers)ParameterDeclaration_12_Var.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_13_Var);
		final EList<? extends EObject> DeclarationSpecifier_13_list = DeclarationSpecifiers_13_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_13_list);
		Assert.assertEquals(1, DeclarationSpecifier_13_list.size());
		final TypeSpecifier TypeSpecifier_14_Var = (TypeSpecifier)DeclarationSpecifier_13_list.get(0);
		Assert.assertNotNull(TypeSpecifier_14_Var);
		Assert.assertEquals("void", TypeSpecifier_14_Var.getName());
		final FunctionDefinition FunctionDefinition_15_Var = (FunctionDefinition)ExternalDeclaration_2_Var.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_15_Var);
		final BodyStatement BodyStatement_16_Var = (BodyStatement)FunctionDefinition_15_Var.getBody();
		Assert.assertNotNull(BodyStatement_16_Var);
		final EList<? extends EObject> BlockList_16_list = BodyStatement_16_Var.getBlockList();
		Assert.assertNotNull(BlockList_16_list);
		Assert.assertEquals(1, BlockList_16_list.size());
		final BlockList BlockList_17_Var = (BlockList)BlockList_16_list.get(0);
		Assert.assertNotNull(BlockList_17_Var);
		final EList<? extends EObject> Declaration_17_list = BlockList_17_Var.getDeclaration();
		Assert.assertNotNull(Declaration_17_list);
		Assert.assertEquals(2, Declaration_17_list.size());
		final Declaration Declaration_18_Var = (Declaration)Declaration_17_list.get(0);
		Assert.assertNotNull(Declaration_18_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_19_Var = (DeclarationSpecifiers)Declaration_18_Var.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_19_Var);
		final EList<? extends EObject> DeclarationSpecifier_19_list = DeclarationSpecifiers_19_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_19_list);
		Assert.assertEquals(1, DeclarationSpecifier_19_list.size());
		final TypeSpecifier TypeSpecifier_20_Var = (TypeSpecifier)DeclarationSpecifier_19_list.get(0);
		Assert.assertNotNull(TypeSpecifier_20_Var);
		Assert.assertEquals("int", TypeSpecifier_20_Var.getName());
		final EList<? extends EObject> InitDeclaratorList_20_list = Declaration_18_Var.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_20_list);
		Assert.assertEquals(1, InitDeclaratorList_20_list.size());
		final InitDeclaratorList InitDeclaratorList_21_Var = (InitDeclaratorList)InitDeclaratorList_20_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_21_Var);
		final EList<? extends EObject> InitDeclarator_21_list = InitDeclaratorList_21_Var.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_21_list);
		Assert.assertEquals(1, InitDeclarator_21_list.size());
		final InitDeclarator InitDeclarator_22_Var = (InitDeclarator)InitDeclarator_21_list.get(0);
		Assert.assertNotNull(InitDeclarator_22_Var);
		final Declarator Declarator_23_Var = (Declarator)InitDeclarator_22_Var.getDeclarator();
		Assert.assertNotNull(Declarator_23_Var);
		final DirectDeclarator DirectDeclarator_24_Var = (DirectDeclarator)Declarator_23_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_24_Var);
		Assert.assertEquals("foo", DirectDeclarator_24_Var.getId());
		final Initializer Initializer_25_Var = (Initializer)InitDeclarator_22_Var.getInitializer();
		Assert.assertNotNull(Initializer_25_Var);
		final AssignmentExpression AssignmentExpression_26_Var = (AssignmentExpression)Initializer_25_Var.getExpr();
		Assert.assertNotNull(AssignmentExpression_26_Var);
		final ConditionalExpression ConditionalExpression_27_Var = (ConditionalExpression)AssignmentExpression_26_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_27_Var);
		final LogicalOrExpression LogicalOrExpression_28_Var = (LogicalOrExpression)ConditionalExpression_27_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_28_Var);
		final EList<? extends EObject> Expr_28_list = LogicalOrExpression_28_Var.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		final LogicalAndExpression LogicalAndExpression_29_Var = (LogicalAndExpression)Expr_28_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_29_Var);
		final EList<? extends EObject> Expr_29_list = LogicalAndExpression_29_Var.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		final InclusiveOrExpression InclusiveOrExpression_30_Var = (InclusiveOrExpression)Expr_29_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_30_Var);
		final EList<? extends EObject> Expr_30_list = InclusiveOrExpression_30_Var.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_31_Var = (ExclusiveOrExpression)Expr_30_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_31_Var);
		final EList<? extends EObject> Expr_31_list = ExclusiveOrExpression_31_Var.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		final AndExpression AndExpression_32_Var = (AndExpression)Expr_31_list.get(0);
		Assert.assertNotNull(AndExpression_32_Var);
		final EList<? extends EObject> Expr_32_list = AndExpression_32_Var.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		final EqualityExpression EqualityExpression_33_Var = (EqualityExpression)Expr_32_list.get(0);
		Assert.assertNotNull(EqualityExpression_33_Var);
		final EList<? extends EObject> Expr_33_list = EqualityExpression_33_Var.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		final RelationalExpression RelationalExpression_34_Var = (RelationalExpression)Expr_33_list.get(0);
		Assert.assertNotNull(RelationalExpression_34_Var);
		final EList<? extends EObject> Expr_34_list = RelationalExpression_34_Var.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		final ShiftExpression ShiftExpression_35_Var = (ShiftExpression)Expr_34_list.get(0);
		Assert.assertNotNull(ShiftExpression_35_Var);
		final EList<? extends EObject> Expr_35_list = ShiftExpression_35_Var.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		final AdditiveExpression AdditiveExpression_36_Var = (AdditiveExpression)Expr_35_list.get(0);
		Assert.assertNotNull(AdditiveExpression_36_Var);
		final EList<? extends EObject> Expr_36_list = AdditiveExpression_36_Var.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		final MultiplicativeExpression MultiplicativeExpression_37_Var = (MultiplicativeExpression)Expr_36_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_37_Var);
		final EList<? extends EObject> Expr_37_list = MultiplicativeExpression_37_Var.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		final CastExpression CastExpression_38_Var = (CastExpression)Expr_37_list.get(0);
		Assert.assertNotNull(CastExpression_38_Var);
		final UnaryExpression UnaryExpression_39_Var = (UnaryExpression)CastExpression_38_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_39_Var);
		final PostfixExpression PostfixExpression_40_Var = (PostfixExpression)UnaryExpression_39_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_40_Var);
		final EList<? extends EObject> Expr_40_list = PostfixExpression_40_Var.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		final PrimaryExpression PrimaryExpression_41_Var = (PrimaryExpression)Expr_40_list.get(0);
		Assert.assertNotNull(PrimaryExpression_41_Var);
		final Constant Constant_42_Var = (Constant)PrimaryExpression_41_Var.getConst();
		Assert.assertNotNull(Constant_42_Var);
		Assert.assertEquals("5", Constant_42_Var.getDec());
		Assert.assertEquals(";", Declaration_18_Var.getSemi());
		final Declaration Declaration_43_Var = (Declaration)Declaration_17_list.get(1);
		Assert.assertNotNull(Declaration_43_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_44_Var = (DeclarationSpecifiers)Declaration_43_Var.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_44_Var);
		final EList<? extends EObject> DeclarationSpecifier_44_list = DeclarationSpecifiers_44_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_44_list);
		Assert.assertEquals(1, DeclarationSpecifier_44_list.size());
		final TypeSpecifier TypeSpecifier_45_Var = (TypeSpecifier)DeclarationSpecifier_44_list.get(0);
		Assert.assertNotNull(TypeSpecifier_45_Var);
		Assert.assertEquals("int", TypeSpecifier_45_Var.getName());
		final EList<? extends EObject> InitDeclaratorList_45_list = Declaration_43_Var.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_45_list);
		Assert.assertEquals(1, InitDeclaratorList_45_list.size());
		final InitDeclaratorList InitDeclaratorList_46_Var = (InitDeclaratorList)InitDeclaratorList_45_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_46_Var);
		final EList<? extends EObject> InitDeclarator_46_list = InitDeclaratorList_46_Var.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_46_list);
		Assert.assertEquals(1, InitDeclarator_46_list.size());
		final InitDeclarator InitDeclarator_47_Var = (InitDeclarator)InitDeclarator_46_list.get(0);
		Assert.assertNotNull(InitDeclarator_47_Var);
		final Declarator Declarator_48_Var = (Declarator)InitDeclarator_47_Var.getDeclarator();
		Assert.assertNotNull(Declarator_48_Var);
		final DirectDeclarator DirectDeclarator_49_Var = (DirectDeclarator)Declarator_48_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_49_Var);
		Assert.assertEquals("bar", DirectDeclarator_49_Var.getId());
		final Initializer Initializer_50_Var = (Initializer)InitDeclarator_47_Var.getInitializer();
		Assert.assertNotNull(Initializer_50_Var);
		final AssignmentExpression AssignmentExpression_51_Var = (AssignmentExpression)Initializer_50_Var.getExpr();
		Assert.assertNotNull(AssignmentExpression_51_Var);
		final ConditionalExpression ConditionalExpression_52_Var = (ConditionalExpression)AssignmentExpression_51_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_52_Var);
		final LogicalOrExpression LogicalOrExpression_53_Var = (LogicalOrExpression)ConditionalExpression_52_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_53_Var);
		final EList<? extends EObject> Expr_53_list = LogicalOrExpression_53_Var.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		final LogicalAndExpression LogicalAndExpression_54_Var = (LogicalAndExpression)Expr_53_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_54_Var);
		final EList<? extends EObject> Expr_54_list = LogicalAndExpression_54_Var.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		final InclusiveOrExpression InclusiveOrExpression_55_Var = (InclusiveOrExpression)Expr_54_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_55_Var);
		final EList<? extends EObject> Expr_55_list = InclusiveOrExpression_55_Var.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_56_Var = (ExclusiveOrExpression)Expr_55_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_56_Var);
		final EList<? extends EObject> Expr_56_list = ExclusiveOrExpression_56_Var.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		final AndExpression AndExpression_57_Var = (AndExpression)Expr_56_list.get(0);
		Assert.assertNotNull(AndExpression_57_Var);
		final EList<? extends EObject> Expr_57_list = AndExpression_57_Var.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		final EqualityExpression EqualityExpression_58_Var = (EqualityExpression)Expr_57_list.get(0);
		Assert.assertNotNull(EqualityExpression_58_Var);
		final EList<? extends EObject> Expr_58_list = EqualityExpression_58_Var.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		final RelationalExpression RelationalExpression_59_Var = (RelationalExpression)Expr_58_list.get(0);
		Assert.assertNotNull(RelationalExpression_59_Var);
		final EList<? extends EObject> Expr_59_list = RelationalExpression_59_Var.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		final ShiftExpression ShiftExpression_60_Var = (ShiftExpression)Expr_59_list.get(0);
		Assert.assertNotNull(ShiftExpression_60_Var);
		final EList<? extends EObject> Expr_60_list = ShiftExpression_60_Var.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		final AdditiveExpression AdditiveExpression_61_Var = (AdditiveExpression)Expr_60_list.get(0);
		Assert.assertNotNull(AdditiveExpression_61_Var);
		final EList<? extends EObject> Expr_61_list = AdditiveExpression_61_Var.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		final MultiplicativeExpression MultiplicativeExpression_62_Var = (MultiplicativeExpression)Expr_61_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_62_Var);
		final EList<? extends EObject> Expr_62_list = MultiplicativeExpression_62_Var.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		final CastExpression CastExpression_63_Var = (CastExpression)Expr_62_list.get(0);
		Assert.assertNotNull(CastExpression_63_Var);
		final UnaryExpression UnaryExpression_64_Var = (UnaryExpression)CastExpression_63_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_64_Var);
		final PostfixExpression PostfixExpression_65_Var = (PostfixExpression)UnaryExpression_64_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_65_Var);
		final EList<? extends EObject> Expr_65_list = PostfixExpression_65_Var.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		final PrimaryExpression PrimaryExpression_66_Var = (PrimaryExpression)Expr_65_list.get(0);
		Assert.assertNotNull(PrimaryExpression_66_Var);
		final Constant Constant_67_Var = (Constant)PrimaryExpression_66_Var.getConst();
		Assert.assertNotNull(Constant_67_Var);
		Assert.assertEquals("4", Constant_67_Var.getDec());
		Assert.assertEquals(";", Declaration_43_Var.getSemi());
		final EList<? extends EObject> Statement_67_list = BlockList_17_Var.getStatement();
		Assert.assertNotNull(Statement_67_list);
		Assert.assertEquals(3, Statement_67_list.size());
		final Statement Statement_68_Var = (Statement)Statement_67_list.get(0);
		Assert.assertNotNull(Statement_68_Var);
		final AsmStatement AsmStatement_69_Var = (AsmStatement)Statement_68_Var.getStmt();
		Assert.assertNotNull(AsmStatement_69_Var);
		final EList<? extends EObject> Expr_69_list = AsmStatement_69_Var.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(5, Expr_69_list.size());
		final LogicalOrExpression LogicalOrExpression_70_Var = (LogicalOrExpression)Expr_69_list.get(0);
		Assert.assertNotNull(LogicalOrExpression_70_Var);
		final EList<? extends EObject> Expr_70_list = LogicalOrExpression_70_Var.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		final LogicalAndExpression LogicalAndExpression_71_Var = (LogicalAndExpression)Expr_70_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_71_Var);
		final EList<? extends EObject> Expr_71_list = LogicalAndExpression_71_Var.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		final InclusiveOrExpression InclusiveOrExpression_72_Var = (InclusiveOrExpression)Expr_71_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_72_Var);
		final EList<? extends EObject> Expr_72_list = InclusiveOrExpression_72_Var.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_73_Var = (ExclusiveOrExpression)Expr_72_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_73_Var);
		final EList<? extends EObject> Expr_73_list = ExclusiveOrExpression_73_Var.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		final AndExpression AndExpression_74_Var = (AndExpression)Expr_73_list.get(0);
		Assert.assertNotNull(AndExpression_74_Var);
		final EList<? extends EObject> Expr_74_list = AndExpression_74_Var.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		final EqualityExpression EqualityExpression_75_Var = (EqualityExpression)Expr_74_list.get(0);
		Assert.assertNotNull(EqualityExpression_75_Var);
		final EList<? extends EObject> Expr_75_list = EqualityExpression_75_Var.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		final RelationalExpression RelationalExpression_76_Var = (RelationalExpression)Expr_75_list.get(0);
		Assert.assertNotNull(RelationalExpression_76_Var);
		final EList<? extends EObject> Expr_76_list = RelationalExpression_76_Var.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		final ShiftExpression ShiftExpression_77_Var = (ShiftExpression)Expr_76_list.get(0);
		Assert.assertNotNull(ShiftExpression_77_Var);
		final EList<? extends EObject> Expr_77_list = ShiftExpression_77_Var.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		final AdditiveExpression AdditiveExpression_78_Var = (AdditiveExpression)Expr_77_list.get(0);
		Assert.assertNotNull(AdditiveExpression_78_Var);
		final EList<? extends EObject> Expr_78_list = AdditiveExpression_78_Var.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		final MultiplicativeExpression MultiplicativeExpression_79_Var = (MultiplicativeExpression)Expr_78_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_79_Var);
		final EList<? extends EObject> Expr_79_list = MultiplicativeExpression_79_Var.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		final CastExpression CastExpression_80_Var = (CastExpression)Expr_79_list.get(0);
		Assert.assertNotNull(CastExpression_80_Var);
		final UnaryExpression UnaryExpression_81_Var = (UnaryExpression)CastExpression_80_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_81_Var);
		final PostfixExpression PostfixExpression_82_Var = (PostfixExpression)UnaryExpression_81_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_82_Var);
		final EList<? extends EObject> Expr_82_list = PostfixExpression_82_Var.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		final PrimaryExpression PrimaryExpression_83_Var = (PrimaryExpression)Expr_82_list.get(0);
		Assert.assertNotNull(PrimaryExpression_83_Var);
		final Constant Constant_84_Var = (Constant)PrimaryExpression_83_Var.getConst();
		Assert.assertNotNull(Constant_84_Var);
		Assert.assertEquals("\"add %1, %0\\n\\t\"", Constant_84_Var.getStr());
		final LogicalOrExpression LogicalOrExpression_85_Var = (LogicalOrExpression)Expr_69_list.get(1);
		Assert.assertNotNull(LogicalOrExpression_85_Var);
		final EList<? extends EObject> Expr_85_list = LogicalOrExpression_85_Var.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		final LogicalAndExpression LogicalAndExpression_86_Var = (LogicalAndExpression)Expr_85_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_86_Var);
		final EList<? extends EObject> Expr_86_list = LogicalAndExpression_86_Var.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		final InclusiveOrExpression InclusiveOrExpression_87_Var = (InclusiveOrExpression)Expr_86_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_87_Var);
		final EList<? extends EObject> Expr_87_list = InclusiveOrExpression_87_Var.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_88_Var = (ExclusiveOrExpression)Expr_87_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_88_Var);
		final EList<? extends EObject> Expr_88_list = ExclusiveOrExpression_88_Var.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		final AndExpression AndExpression_89_Var = (AndExpression)Expr_88_list.get(0);
		Assert.assertNotNull(AndExpression_89_Var);
		final EList<? extends EObject> Expr_89_list = AndExpression_89_Var.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		final EqualityExpression EqualityExpression_90_Var = (EqualityExpression)Expr_89_list.get(0);
		Assert.assertNotNull(EqualityExpression_90_Var);
		final EList<? extends EObject> Expr_90_list = EqualityExpression_90_Var.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		final RelationalExpression RelationalExpression_91_Var = (RelationalExpression)Expr_90_list.get(0);
		Assert.assertNotNull(RelationalExpression_91_Var);
		final EList<? extends EObject> Expr_91_list = RelationalExpression_91_Var.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		final ShiftExpression ShiftExpression_92_Var = (ShiftExpression)Expr_91_list.get(0);
		Assert.assertNotNull(ShiftExpression_92_Var);
		final EList<? extends EObject> Expr_92_list = ShiftExpression_92_Var.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		final AdditiveExpression AdditiveExpression_93_Var = (AdditiveExpression)Expr_92_list.get(0);
		Assert.assertNotNull(AdditiveExpression_93_Var);
		final EList<? extends EObject> Expr_93_list = AdditiveExpression_93_Var.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		final MultiplicativeExpression MultiplicativeExpression_94_Var = (MultiplicativeExpression)Expr_93_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_94_Var);
		final EList<? extends EObject> Expr_94_list = MultiplicativeExpression_94_Var.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		final CastExpression CastExpression_95_Var = (CastExpression)Expr_94_list.get(0);
		Assert.assertNotNull(CastExpression_95_Var);
		final UnaryExpression UnaryExpression_96_Var = (UnaryExpression)CastExpression_95_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_96_Var);
		final PostfixExpression PostfixExpression_97_Var = (PostfixExpression)UnaryExpression_96_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_97_Var);
		final EList<? extends EObject> Expr_97_list = PostfixExpression_97_Var.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		final PrimaryExpression PrimaryExpression_98_Var = (PrimaryExpression)Expr_97_list.get(0);
		Assert.assertNotNull(PrimaryExpression_98_Var);
		final Constant Constant_99_Var = (Constant)PrimaryExpression_98_Var.getConst();
		Assert.assertNotNull(Constant_99_Var);
		Assert.assertEquals("\"inc %0\"", Constant_99_Var.getStr());
		final LogicalOrExpression LogicalOrExpression_100_Var = (LogicalOrExpression)Expr_69_list.get(2);
		Assert.assertNotNull(LogicalOrExpression_100_Var);
		final EList<? extends EObject> Expr_100_list = LogicalOrExpression_100_Var.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		final LogicalAndExpression LogicalAndExpression_101_Var = (LogicalAndExpression)Expr_100_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_101_Var);
		final EList<? extends EObject> Expr_101_list = LogicalAndExpression_101_Var.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		final InclusiveOrExpression InclusiveOrExpression_102_Var = (InclusiveOrExpression)Expr_101_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_102_Var);
		final EList<? extends EObject> Expr_102_list = InclusiveOrExpression_102_Var.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_103_Var = (ExclusiveOrExpression)Expr_102_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_103_Var);
		final EList<? extends EObject> Expr_103_list = ExclusiveOrExpression_103_Var.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		final AndExpression AndExpression_104_Var = (AndExpression)Expr_103_list.get(0);
		Assert.assertNotNull(AndExpression_104_Var);
		final EList<? extends EObject> Expr_104_list = AndExpression_104_Var.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		final EqualityExpression EqualityExpression_105_Var = (EqualityExpression)Expr_104_list.get(0);
		Assert.assertNotNull(EqualityExpression_105_Var);
		final EList<? extends EObject> Expr_105_list = EqualityExpression_105_Var.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		final RelationalExpression RelationalExpression_106_Var = (RelationalExpression)Expr_105_list.get(0);
		Assert.assertNotNull(RelationalExpression_106_Var);
		final EList<? extends EObject> Expr_106_list = RelationalExpression_106_Var.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		final ShiftExpression ShiftExpression_107_Var = (ShiftExpression)Expr_106_list.get(0);
		Assert.assertNotNull(ShiftExpression_107_Var);
		final EList<? extends EObject> Expr_107_list = ShiftExpression_107_Var.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		final AdditiveExpression AdditiveExpression_108_Var = (AdditiveExpression)Expr_107_list.get(0);
		Assert.assertNotNull(AdditiveExpression_108_Var);
		final EList<? extends EObject> Expr_108_list = AdditiveExpression_108_Var.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		final MultiplicativeExpression MultiplicativeExpression_109_Var = (MultiplicativeExpression)Expr_108_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_109_Var);
		final EList<? extends EObject> Expr_109_list = MultiplicativeExpression_109_Var.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		final CastExpression CastExpression_110_Var = (CastExpression)Expr_109_list.get(0);
		Assert.assertNotNull(CastExpression_110_Var);
		final UnaryExpression UnaryExpression_111_Var = (UnaryExpression)CastExpression_110_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_111_Var);
		final PostfixExpression PostfixExpression_112_Var = (PostfixExpression)UnaryExpression_111_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_112_Var);
		final EList<? extends EObject> Expr_112_list = PostfixExpression_112_Var.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		final PrimaryExpression PrimaryExpression_113_Var = (PrimaryExpression)Expr_112_list.get(0);
		Assert.assertNotNull(PrimaryExpression_113_Var);
		final Constant Constant_114_Var = (Constant)PrimaryExpression_113_Var.getConst();
		Assert.assertNotNull(Constant_114_Var);
		Assert.assertEquals("\"+r\"", Constant_114_Var.getStr());
		final EList<? extends EObject> ArgumentExpressionList_114_list = PostfixExpression_112_Var.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_114_list);
		Assert.assertEquals(1, ArgumentExpressionList_114_list.size());
		final ArgumentExpressionList ArgumentExpressionList_115_Var = (ArgumentExpressionList)ArgumentExpressionList_114_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_115_Var);
		final EList<? extends EObject> Expr_115_list = ArgumentExpressionList_115_Var.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		final AssignmentExpression AssignmentExpression_116_Var = (AssignmentExpression)Expr_115_list.get(0);
		Assert.assertNotNull(AssignmentExpression_116_Var);
		final ConditionalExpression ConditionalExpression_117_Var = (ConditionalExpression)AssignmentExpression_116_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_117_Var);
		final LogicalOrExpression LogicalOrExpression_118_Var = (LogicalOrExpression)ConditionalExpression_117_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_118_Var);
		final EList<? extends EObject> Expr_118_list = LogicalOrExpression_118_Var.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		final LogicalAndExpression LogicalAndExpression_119_Var = (LogicalAndExpression)Expr_118_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_119_Var);
		final EList<? extends EObject> Expr_119_list = LogicalAndExpression_119_Var.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		final InclusiveOrExpression InclusiveOrExpression_120_Var = (InclusiveOrExpression)Expr_119_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_120_Var);
		final EList<? extends EObject> Expr_120_list = InclusiveOrExpression_120_Var.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_121_Var = (ExclusiveOrExpression)Expr_120_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_121_Var);
		final EList<? extends EObject> Expr_121_list = ExclusiveOrExpression_121_Var.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		final AndExpression AndExpression_122_Var = (AndExpression)Expr_121_list.get(0);
		Assert.assertNotNull(AndExpression_122_Var);
		final EList<? extends EObject> Expr_122_list = AndExpression_122_Var.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		final EqualityExpression EqualityExpression_123_Var = (EqualityExpression)Expr_122_list.get(0);
		Assert.assertNotNull(EqualityExpression_123_Var);
		final EList<? extends EObject> Expr_123_list = EqualityExpression_123_Var.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		final RelationalExpression RelationalExpression_124_Var = (RelationalExpression)Expr_123_list.get(0);
		Assert.assertNotNull(RelationalExpression_124_Var);
		final EList<? extends EObject> Expr_124_list = RelationalExpression_124_Var.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		final ShiftExpression ShiftExpression_125_Var = (ShiftExpression)Expr_124_list.get(0);
		Assert.assertNotNull(ShiftExpression_125_Var);
		final EList<? extends EObject> Expr_125_list = ShiftExpression_125_Var.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		final AdditiveExpression AdditiveExpression_126_Var = (AdditiveExpression)Expr_125_list.get(0);
		Assert.assertNotNull(AdditiveExpression_126_Var);
		final EList<? extends EObject> Expr_126_list = AdditiveExpression_126_Var.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		final MultiplicativeExpression MultiplicativeExpression_127_Var = (MultiplicativeExpression)Expr_126_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_127_Var);
		final EList<? extends EObject> Expr_127_list = MultiplicativeExpression_127_Var.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		final CastExpression CastExpression_128_Var = (CastExpression)Expr_127_list.get(0);
		Assert.assertNotNull(CastExpression_128_Var);
		final UnaryExpression UnaryExpression_129_Var = (UnaryExpression)CastExpression_128_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_129_Var);
		final PostfixExpression PostfixExpression_130_Var = (PostfixExpression)UnaryExpression_129_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_130_Var);
		final EList<? extends EObject> Expr_130_list = PostfixExpression_130_Var.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		final PrimaryExpression PrimaryExpression_131_Var = (PrimaryExpression)Expr_130_list.get(0);
		Assert.assertNotNull(PrimaryExpression_131_Var);
		Assert.assertEquals("bar", PrimaryExpression_131_Var.getId());
		final LogicalOrExpression LogicalOrExpression_132_Var = (LogicalOrExpression)Expr_69_list.get(3);
		Assert.assertNotNull(LogicalOrExpression_132_Var);
		final EList<? extends EObject> Expr_132_list = LogicalOrExpression_132_Var.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		final LogicalAndExpression LogicalAndExpression_133_Var = (LogicalAndExpression)Expr_132_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_133_Var);
		final EList<? extends EObject> Expr_133_list = LogicalAndExpression_133_Var.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		final InclusiveOrExpression InclusiveOrExpression_134_Var = (InclusiveOrExpression)Expr_133_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_134_Var);
		final EList<? extends EObject> Expr_134_list = InclusiveOrExpression_134_Var.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_135_Var = (ExclusiveOrExpression)Expr_134_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_135_Var);
		final EList<? extends EObject> Expr_135_list = ExclusiveOrExpression_135_Var.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		final AndExpression AndExpression_136_Var = (AndExpression)Expr_135_list.get(0);
		Assert.assertNotNull(AndExpression_136_Var);
		final EList<? extends EObject> Expr_136_list = AndExpression_136_Var.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		final EqualityExpression EqualityExpression_137_Var = (EqualityExpression)Expr_136_list.get(0);
		Assert.assertNotNull(EqualityExpression_137_Var);
		final EList<? extends EObject> Expr_137_list = EqualityExpression_137_Var.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		final RelationalExpression RelationalExpression_138_Var = (RelationalExpression)Expr_137_list.get(0);
		Assert.assertNotNull(RelationalExpression_138_Var);
		final EList<? extends EObject> Expr_138_list = RelationalExpression_138_Var.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		final ShiftExpression ShiftExpression_139_Var = (ShiftExpression)Expr_138_list.get(0);
		Assert.assertNotNull(ShiftExpression_139_Var);
		final EList<? extends EObject> Expr_139_list = ShiftExpression_139_Var.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		final AdditiveExpression AdditiveExpression_140_Var = (AdditiveExpression)Expr_139_list.get(0);
		Assert.assertNotNull(AdditiveExpression_140_Var);
		final EList<? extends EObject> Expr_140_list = AdditiveExpression_140_Var.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		final MultiplicativeExpression MultiplicativeExpression_141_Var = (MultiplicativeExpression)Expr_140_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_141_Var);
		final EList<? extends EObject> Expr_141_list = MultiplicativeExpression_141_Var.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		final CastExpression CastExpression_142_Var = (CastExpression)Expr_141_list.get(0);
		Assert.assertNotNull(CastExpression_142_Var);
		final UnaryExpression UnaryExpression_143_Var = (UnaryExpression)CastExpression_142_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_143_Var);
		final PostfixExpression PostfixExpression_144_Var = (PostfixExpression)UnaryExpression_143_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_144_Var);
		final EList<? extends EObject> Expr_144_list = PostfixExpression_144_Var.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		final PrimaryExpression PrimaryExpression_145_Var = (PrimaryExpression)Expr_144_list.get(0);
		Assert.assertNotNull(PrimaryExpression_145_Var);
		final Constant Constant_146_Var = (Constant)PrimaryExpression_145_Var.getConst();
		Assert.assertNotNull(Constant_146_Var);
		Assert.assertEquals("\"g\"", Constant_146_Var.getStr());
		final EList<? extends EObject> ArgumentExpressionList_146_list = PostfixExpression_144_Var.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_146_list);
		Assert.assertEquals(1, ArgumentExpressionList_146_list.size());
		final ArgumentExpressionList ArgumentExpressionList_147_Var = (ArgumentExpressionList)ArgumentExpressionList_146_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_147_Var);
		final EList<? extends EObject> Expr_147_list = ArgumentExpressionList_147_Var.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(1, Expr_147_list.size());
		final AssignmentExpression AssignmentExpression_148_Var = (AssignmentExpression)Expr_147_list.get(0);
		Assert.assertNotNull(AssignmentExpression_148_Var);
		final ConditionalExpression ConditionalExpression_149_Var = (ConditionalExpression)AssignmentExpression_148_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_149_Var);
		final LogicalOrExpression LogicalOrExpression_150_Var = (LogicalOrExpression)ConditionalExpression_149_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_150_Var);
		final EList<? extends EObject> Expr_150_list = LogicalOrExpression_150_Var.getExpr();
		Assert.assertNotNull(Expr_150_list);
		Assert.assertEquals(1, Expr_150_list.size());
		final LogicalAndExpression LogicalAndExpression_151_Var = (LogicalAndExpression)Expr_150_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_151_Var);
		final EList<? extends EObject> Expr_151_list = LogicalAndExpression_151_Var.getExpr();
		Assert.assertNotNull(Expr_151_list);
		Assert.assertEquals(1, Expr_151_list.size());
		final InclusiveOrExpression InclusiveOrExpression_152_Var = (InclusiveOrExpression)Expr_151_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_152_Var);
		final EList<? extends EObject> Expr_152_list = InclusiveOrExpression_152_Var.getExpr();
		Assert.assertNotNull(Expr_152_list);
		Assert.assertEquals(1, Expr_152_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_153_Var = (ExclusiveOrExpression)Expr_152_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_153_Var);
		final EList<? extends EObject> Expr_153_list = ExclusiveOrExpression_153_Var.getExpr();
		Assert.assertNotNull(Expr_153_list);
		Assert.assertEquals(1, Expr_153_list.size());
		final AndExpression AndExpression_154_Var = (AndExpression)Expr_153_list.get(0);
		Assert.assertNotNull(AndExpression_154_Var);
		final EList<? extends EObject> Expr_154_list = AndExpression_154_Var.getExpr();
		Assert.assertNotNull(Expr_154_list);
		Assert.assertEquals(1, Expr_154_list.size());
		final EqualityExpression EqualityExpression_155_Var = (EqualityExpression)Expr_154_list.get(0);
		Assert.assertNotNull(EqualityExpression_155_Var);
		final EList<? extends EObject> Expr_155_list = EqualityExpression_155_Var.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		final RelationalExpression RelationalExpression_156_Var = (RelationalExpression)Expr_155_list.get(0);
		Assert.assertNotNull(RelationalExpression_156_Var);
		final EList<? extends EObject> Expr_156_list = RelationalExpression_156_Var.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		final ShiftExpression ShiftExpression_157_Var = (ShiftExpression)Expr_156_list.get(0);
		Assert.assertNotNull(ShiftExpression_157_Var);
		final EList<? extends EObject> Expr_157_list = ShiftExpression_157_Var.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		final AdditiveExpression AdditiveExpression_158_Var = (AdditiveExpression)Expr_157_list.get(0);
		Assert.assertNotNull(AdditiveExpression_158_Var);
		final EList<? extends EObject> Expr_158_list = AdditiveExpression_158_Var.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		final MultiplicativeExpression MultiplicativeExpression_159_Var = (MultiplicativeExpression)Expr_158_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_159_Var);
		final EList<? extends EObject> Expr_159_list = MultiplicativeExpression_159_Var.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		final CastExpression CastExpression_160_Var = (CastExpression)Expr_159_list.get(0);
		Assert.assertNotNull(CastExpression_160_Var);
		final UnaryExpression UnaryExpression_161_Var = (UnaryExpression)CastExpression_160_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_161_Var);
		final PostfixExpression PostfixExpression_162_Var = (PostfixExpression)UnaryExpression_161_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_162_Var);
		final EList<? extends EObject> Expr_162_list = PostfixExpression_162_Var.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		final PrimaryExpression PrimaryExpression_163_Var = (PrimaryExpression)Expr_162_list.get(0);
		Assert.assertNotNull(PrimaryExpression_163_Var);
		Assert.assertEquals("foo", PrimaryExpression_163_Var.getId());
		final LogicalOrExpression LogicalOrExpression_164_Var = (LogicalOrExpression)Expr_69_list.get(4);
		Assert.assertNotNull(LogicalOrExpression_164_Var);
		final EList<? extends EObject> Expr_164_list = LogicalOrExpression_164_Var.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		final LogicalAndExpression LogicalAndExpression_165_Var = (LogicalAndExpression)Expr_164_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_165_Var);
		final EList<? extends EObject> Expr_165_list = LogicalAndExpression_165_Var.getExpr();
		Assert.assertNotNull(Expr_165_list);
		Assert.assertEquals(1, Expr_165_list.size());
		final InclusiveOrExpression InclusiveOrExpression_166_Var = (InclusiveOrExpression)Expr_165_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_166_Var);
		final EList<? extends EObject> Expr_166_list = InclusiveOrExpression_166_Var.getExpr();
		Assert.assertNotNull(Expr_166_list);
		Assert.assertEquals(1, Expr_166_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_167_Var = (ExclusiveOrExpression)Expr_166_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_167_Var);
		final EList<? extends EObject> Expr_167_list = ExclusiveOrExpression_167_Var.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(1, Expr_167_list.size());
		final AndExpression AndExpression_168_Var = (AndExpression)Expr_167_list.get(0);
		Assert.assertNotNull(AndExpression_168_Var);
		final EList<? extends EObject> Expr_168_list = AndExpression_168_Var.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(1, Expr_168_list.size());
		final EqualityExpression EqualityExpression_169_Var = (EqualityExpression)Expr_168_list.get(0);
		Assert.assertNotNull(EqualityExpression_169_Var);
		final EList<? extends EObject> Expr_169_list = EqualityExpression_169_Var.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		final RelationalExpression RelationalExpression_170_Var = (RelationalExpression)Expr_169_list.get(0);
		Assert.assertNotNull(RelationalExpression_170_Var);
		final EList<? extends EObject> Expr_170_list = RelationalExpression_170_Var.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		final ShiftExpression ShiftExpression_171_Var = (ShiftExpression)Expr_170_list.get(0);
		Assert.assertNotNull(ShiftExpression_171_Var);
		final EList<? extends EObject> Expr_171_list = ShiftExpression_171_Var.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		final AdditiveExpression AdditiveExpression_172_Var = (AdditiveExpression)Expr_171_list.get(0);
		Assert.assertNotNull(AdditiveExpression_172_Var);
		final EList<? extends EObject> Expr_172_list = AdditiveExpression_172_Var.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		final MultiplicativeExpression MultiplicativeExpression_173_Var = (MultiplicativeExpression)Expr_172_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_173_Var);
		final EList<? extends EObject> Expr_173_list = MultiplicativeExpression_173_Var.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		final CastExpression CastExpression_174_Var = (CastExpression)Expr_173_list.get(0);
		Assert.assertNotNull(CastExpression_174_Var);
		final UnaryExpression UnaryExpression_175_Var = (UnaryExpression)CastExpression_174_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_175_Var);
		final PostfixExpression PostfixExpression_176_Var = (PostfixExpression)UnaryExpression_175_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_176_Var);
		final EList<? extends EObject> Expr_176_list = PostfixExpression_176_Var.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		final PrimaryExpression PrimaryExpression_177_Var = (PrimaryExpression)Expr_176_list.get(0);
		Assert.assertNotNull(PrimaryExpression_177_Var);
		final Constant Constant_178_Var = (Constant)PrimaryExpression_177_Var.getConst();
		Assert.assertNotNull(Constant_178_Var);
		Assert.assertEquals("\"cc\"", Constant_178_Var.getStr());
		final Statement Statement_179_Var = (Statement)Statement_67_list.get(1);
		Assert.assertNotNull(Statement_179_Var);
		final ExpressionStatement ExpressionStatement_180_Var = (ExpressionStatement)Statement_179_Var.getStmt();
		Assert.assertNotNull(ExpressionStatement_180_Var);
		final Expression Expression_181_Var = (Expression)ExpressionStatement_180_Var.getExpression();
		Assert.assertNotNull(Expression_181_Var);
		final EList<? extends EObject> ExprExpr_181_list = Expression_181_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_181_list);
		Assert.assertEquals(1, ExprExpr_181_list.size());
		final AssignmentExpression AssignmentExpression_182_Var = (AssignmentExpression)ExprExpr_181_list.get(0);
		Assert.assertNotNull(AssignmentExpression_182_Var);
		final ConditionalExpression ConditionalExpression_183_Var = (ConditionalExpression)AssignmentExpression_182_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_183_Var);
		final LogicalOrExpression LogicalOrExpression_184_Var = (LogicalOrExpression)ConditionalExpression_183_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_184_Var);
		final EList<? extends EObject> Expr_184_list = LogicalOrExpression_184_Var.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		final LogicalAndExpression LogicalAndExpression_185_Var = (LogicalAndExpression)Expr_184_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_185_Var);
		final EList<? extends EObject> Expr_185_list = LogicalAndExpression_185_Var.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		final InclusiveOrExpression InclusiveOrExpression_186_Var = (InclusiveOrExpression)Expr_185_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_186_Var);
		final EList<? extends EObject> Expr_186_list = InclusiveOrExpression_186_Var.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(1, Expr_186_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_187_Var = (ExclusiveOrExpression)Expr_186_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_187_Var);
		final EList<? extends EObject> Expr_187_list = ExclusiveOrExpression_187_Var.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(1, Expr_187_list.size());
		final AndExpression AndExpression_188_Var = (AndExpression)Expr_187_list.get(0);
		Assert.assertNotNull(AndExpression_188_Var);
		final EList<? extends EObject> Expr_188_list = AndExpression_188_Var.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		final EqualityExpression EqualityExpression_189_Var = (EqualityExpression)Expr_188_list.get(0);
		Assert.assertNotNull(EqualityExpression_189_Var);
		final EList<? extends EObject> Expr_189_list = EqualityExpression_189_Var.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		final RelationalExpression RelationalExpression_190_Var = (RelationalExpression)Expr_189_list.get(0);
		Assert.assertNotNull(RelationalExpression_190_Var);
		final EList<? extends EObject> Expr_190_list = RelationalExpression_190_Var.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		final ShiftExpression ShiftExpression_191_Var = (ShiftExpression)Expr_190_list.get(0);
		Assert.assertNotNull(ShiftExpression_191_Var);
		final EList<? extends EObject> Expr_191_list = ShiftExpression_191_Var.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		final AdditiveExpression AdditiveExpression_192_Var = (AdditiveExpression)Expr_191_list.get(0);
		Assert.assertNotNull(AdditiveExpression_192_Var);
		final EList<? extends EObject> Expr_192_list = AdditiveExpression_192_Var.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		final MultiplicativeExpression MultiplicativeExpression_193_Var = (MultiplicativeExpression)Expr_192_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_193_Var);
		final EList<? extends EObject> Expr_193_list = MultiplicativeExpression_193_Var.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		final CastExpression CastExpression_194_Var = (CastExpression)Expr_193_list.get(0);
		Assert.assertNotNull(CastExpression_194_Var);
		final UnaryExpression UnaryExpression_195_Var = (UnaryExpression)CastExpression_194_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_195_Var);
		final PostfixExpression PostfixExpression_196_Var = (PostfixExpression)UnaryExpression_195_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_196_Var);
		final EList<? extends EObject> Expr_196_list = PostfixExpression_196_Var.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		final PrimaryExpression PrimaryExpression_197_Var = (PrimaryExpression)Expr_196_list.get(0);
		Assert.assertNotNull(PrimaryExpression_197_Var);
		Assert.assertEquals("printf", PrimaryExpression_197_Var.getId());
		final EList<? extends EObject> ArgumentExpressionList_197_list = PostfixExpression_196_Var.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_197_list);
		Assert.assertEquals(1, ArgumentExpressionList_197_list.size());
		final ArgumentExpressionList ArgumentExpressionList_198_Var = (ArgumentExpressionList)ArgumentExpressionList_197_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_198_Var);
		final EList<? extends EObject> Expr_198_list = ArgumentExpressionList_198_Var.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(2, Expr_198_list.size());
		final AssignmentExpression AssignmentExpression_199_Var = (AssignmentExpression)Expr_198_list.get(0);
		Assert.assertNotNull(AssignmentExpression_199_Var);
		final ConditionalExpression ConditionalExpression_200_Var = (ConditionalExpression)AssignmentExpression_199_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_200_Var);
		final LogicalOrExpression LogicalOrExpression_201_Var = (LogicalOrExpression)ConditionalExpression_200_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_201_Var);
		final EList<? extends EObject> Expr_201_list = LogicalOrExpression_201_Var.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		final LogicalAndExpression LogicalAndExpression_202_Var = (LogicalAndExpression)Expr_201_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_202_Var);
		final EList<? extends EObject> Expr_202_list = LogicalAndExpression_202_Var.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		final InclusiveOrExpression InclusiveOrExpression_203_Var = (InclusiveOrExpression)Expr_202_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_203_Var);
		final EList<? extends EObject> Expr_203_list = InclusiveOrExpression_203_Var.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_204_Var = (ExclusiveOrExpression)Expr_203_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_204_Var);
		final EList<? extends EObject> Expr_204_list = ExclusiveOrExpression_204_Var.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		final AndExpression AndExpression_205_Var = (AndExpression)Expr_204_list.get(0);
		Assert.assertNotNull(AndExpression_205_Var);
		final EList<? extends EObject> Expr_205_list = AndExpression_205_Var.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		final EqualityExpression EqualityExpression_206_Var = (EqualityExpression)Expr_205_list.get(0);
		Assert.assertNotNull(EqualityExpression_206_Var);
		final EList<? extends EObject> Expr_206_list = EqualityExpression_206_Var.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		final RelationalExpression RelationalExpression_207_Var = (RelationalExpression)Expr_206_list.get(0);
		Assert.assertNotNull(RelationalExpression_207_Var);
		final EList<? extends EObject> Expr_207_list = RelationalExpression_207_Var.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		final ShiftExpression ShiftExpression_208_Var = (ShiftExpression)Expr_207_list.get(0);
		Assert.assertNotNull(ShiftExpression_208_Var);
		final EList<? extends EObject> Expr_208_list = ShiftExpression_208_Var.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		final AdditiveExpression AdditiveExpression_209_Var = (AdditiveExpression)Expr_208_list.get(0);
		Assert.assertNotNull(AdditiveExpression_209_Var);
		final EList<? extends EObject> Expr_209_list = AdditiveExpression_209_Var.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		final MultiplicativeExpression MultiplicativeExpression_210_Var = (MultiplicativeExpression)Expr_209_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_210_Var);
		final EList<? extends EObject> Expr_210_list = MultiplicativeExpression_210_Var.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		final CastExpression CastExpression_211_Var = (CastExpression)Expr_210_list.get(0);
		Assert.assertNotNull(CastExpression_211_Var);
		final UnaryExpression UnaryExpression_212_Var = (UnaryExpression)CastExpression_211_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_212_Var);
		final PostfixExpression PostfixExpression_213_Var = (PostfixExpression)UnaryExpression_212_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_213_Var);
		final EList<? extends EObject> Expr_213_list = PostfixExpression_213_Var.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		final PrimaryExpression PrimaryExpression_214_Var = (PrimaryExpression)Expr_213_list.get(0);
		Assert.assertNotNull(PrimaryExpression_214_Var);
		final Constant Constant_215_Var = (Constant)PrimaryExpression_214_Var.getConst();
		Assert.assertNotNull(Constant_215_Var);
		Assert.assertEquals("\"Ergebnis: %i\\n\"", Constant_215_Var.getStr());
		final AssignmentExpression AssignmentExpression_216_Var = (AssignmentExpression)Expr_198_list.get(1);
		Assert.assertNotNull(AssignmentExpression_216_Var);
		final ConditionalExpression ConditionalExpression_217_Var = (ConditionalExpression)AssignmentExpression_216_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_217_Var);
		final LogicalOrExpression LogicalOrExpression_218_Var = (LogicalOrExpression)ConditionalExpression_217_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_218_Var);
		final EList<? extends EObject> Expr_218_list = LogicalOrExpression_218_Var.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		final LogicalAndExpression LogicalAndExpression_219_Var = (LogicalAndExpression)Expr_218_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_219_Var);
		final EList<? extends EObject> Expr_219_list = LogicalAndExpression_219_Var.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		final InclusiveOrExpression InclusiveOrExpression_220_Var = (InclusiveOrExpression)Expr_219_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_220_Var);
		final EList<? extends EObject> Expr_220_list = InclusiveOrExpression_220_Var.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_221_Var = (ExclusiveOrExpression)Expr_220_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_221_Var);
		final EList<? extends EObject> Expr_221_list = ExclusiveOrExpression_221_Var.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		final AndExpression AndExpression_222_Var = (AndExpression)Expr_221_list.get(0);
		Assert.assertNotNull(AndExpression_222_Var);
		final EList<? extends EObject> Expr_222_list = AndExpression_222_Var.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		final EqualityExpression EqualityExpression_223_Var = (EqualityExpression)Expr_222_list.get(0);
		Assert.assertNotNull(EqualityExpression_223_Var);
		final EList<? extends EObject> Expr_223_list = EqualityExpression_223_Var.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		final RelationalExpression RelationalExpression_224_Var = (RelationalExpression)Expr_223_list.get(0);
		Assert.assertNotNull(RelationalExpression_224_Var);
		final EList<? extends EObject> Expr_224_list = RelationalExpression_224_Var.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		final ShiftExpression ShiftExpression_225_Var = (ShiftExpression)Expr_224_list.get(0);
		Assert.assertNotNull(ShiftExpression_225_Var);
		final EList<? extends EObject> Expr_225_list = ShiftExpression_225_Var.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		final AdditiveExpression AdditiveExpression_226_Var = (AdditiveExpression)Expr_225_list.get(0);
		Assert.assertNotNull(AdditiveExpression_226_Var);
		final EList<? extends EObject> Expr_226_list = AdditiveExpression_226_Var.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		final MultiplicativeExpression MultiplicativeExpression_227_Var = (MultiplicativeExpression)Expr_226_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_227_Var);
		final EList<? extends EObject> Expr_227_list = MultiplicativeExpression_227_Var.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		final CastExpression CastExpression_228_Var = (CastExpression)Expr_227_list.get(0);
		Assert.assertNotNull(CastExpression_228_Var);
		final UnaryExpression UnaryExpression_229_Var = (UnaryExpression)CastExpression_228_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_229_Var);
		final PostfixExpression PostfixExpression_230_Var = (PostfixExpression)UnaryExpression_229_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_230_Var);
		final EList<? extends EObject> Expr_230_list = PostfixExpression_230_Var.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		final PrimaryExpression PrimaryExpression_231_Var = (PrimaryExpression)Expr_230_list.get(0);
		Assert.assertNotNull(PrimaryExpression_231_Var);
		Assert.assertEquals("bar", PrimaryExpression_231_Var.getId());
		Assert.assertEquals(";", ExpressionStatement_180_Var.getSemi());
		final Statement Statement_232_Var = (Statement)Statement_67_list.get(2);
		Assert.assertNotNull(Statement_232_Var);
		final JumpStatement JumpStatement_233_Var = (JumpStatement)Statement_232_Var.getStmt();
		Assert.assertNotNull(JumpStatement_233_Var);
		final Expression Expression_234_Var = (Expression)JumpStatement_233_Var.getExpr();
		Assert.assertNotNull(Expression_234_Var);
		final EList<? extends EObject> ExprExpr_234_list = Expression_234_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_234_list);
		Assert.assertEquals(1, ExprExpr_234_list.size());
		final AssignmentExpression AssignmentExpression_235_Var = (AssignmentExpression)ExprExpr_234_list.get(0);
		Assert.assertNotNull(AssignmentExpression_235_Var);
		final ConditionalExpression ConditionalExpression_236_Var = (ConditionalExpression)AssignmentExpression_235_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_236_Var);
		final LogicalOrExpression LogicalOrExpression_237_Var = (LogicalOrExpression)ConditionalExpression_236_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_237_Var);
		final EList<? extends EObject> Expr_237_list = LogicalOrExpression_237_Var.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		final LogicalAndExpression LogicalAndExpression_238_Var = (LogicalAndExpression)Expr_237_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_238_Var);
		final EList<? extends EObject> Expr_238_list = LogicalAndExpression_238_Var.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		final InclusiveOrExpression InclusiveOrExpression_239_Var = (InclusiveOrExpression)Expr_238_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_239_Var);
		final EList<? extends EObject> Expr_239_list = InclusiveOrExpression_239_Var.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_240_Var = (ExclusiveOrExpression)Expr_239_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_240_Var);
		final EList<? extends EObject> Expr_240_list = ExclusiveOrExpression_240_Var.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		final AndExpression AndExpression_241_Var = (AndExpression)Expr_240_list.get(0);
		Assert.assertNotNull(AndExpression_241_Var);
		final EList<? extends EObject> Expr_241_list = AndExpression_241_Var.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		final EqualityExpression EqualityExpression_242_Var = (EqualityExpression)Expr_241_list.get(0);
		Assert.assertNotNull(EqualityExpression_242_Var);
		final EList<? extends EObject> Expr_242_list = EqualityExpression_242_Var.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		final RelationalExpression RelationalExpression_243_Var = (RelationalExpression)Expr_242_list.get(0);
		Assert.assertNotNull(RelationalExpression_243_Var);
		final EList<? extends EObject> Expr_243_list = RelationalExpression_243_Var.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		final ShiftExpression ShiftExpression_244_Var = (ShiftExpression)Expr_243_list.get(0);
		Assert.assertNotNull(ShiftExpression_244_Var);
		final EList<? extends EObject> Expr_244_list = ShiftExpression_244_Var.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		final AdditiveExpression AdditiveExpression_245_Var = (AdditiveExpression)Expr_244_list.get(0);
		Assert.assertNotNull(AdditiveExpression_245_Var);
		final EList<? extends EObject> Expr_245_list = AdditiveExpression_245_Var.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		final MultiplicativeExpression MultiplicativeExpression_246_Var = (MultiplicativeExpression)Expr_245_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_246_Var);
		final EList<? extends EObject> Expr_246_list = MultiplicativeExpression_246_Var.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		final CastExpression CastExpression_247_Var = (CastExpression)Expr_246_list.get(0);
		Assert.assertNotNull(CastExpression_247_Var);
		final UnaryExpression UnaryExpression_248_Var = (UnaryExpression)CastExpression_247_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_248_Var);
		final PostfixExpression PostfixExpression_249_Var = (PostfixExpression)UnaryExpression_248_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_249_Var);
		final EList<? extends EObject> Expr_249_list = PostfixExpression_249_Var.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		final PrimaryExpression PrimaryExpression_250_Var = (PrimaryExpression)Expr_249_list.get(0);
		Assert.assertNotNull(PrimaryExpression_250_Var);
		final Constant Constant_251_Var = (Constant)PrimaryExpression_250_Var.getConst();
		Assert.assertNotNull(Constant_251_Var);
		Assert.assertEquals("0", Constant_251_Var.getDec());
		Assert.assertEquals("return", JumpStatement_233_Var.getReturn());
		Assert.assertEquals(";", JumpStatement_233_Var.getSemi());
	}


}
