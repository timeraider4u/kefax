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
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.StorageClassSpecifier;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
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
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.Pointer;
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
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
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.SelectionStatement;
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
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.UnaryOperator;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
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
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.CompoundStatement;
import at.jku.weiner.c.c.BodyStatement;
import at.jku.weiner.c.c.BlockList;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.AssignmentOperator;
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
import at.jku.weiner.c.c.UnaryOperator;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.AssignmentOperator;
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
import at.jku.weiner.c.c.UnaryOperator;
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

@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0029_Assembler {

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
		final Path path = Paths.get("res/Test0029_Assembler.c");
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
			"RULE_KW_EXTERN",
			"RULE_WHITESPACE",
			"RULE_KW_INT",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_NEWLINE",
			"RULE_KW_INT",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_LEFTPAREN",
			"RULE_KW_INT",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_COMMA",
			"RULE_WHITESPACE",
			"RULE_KW_INT",
			"RULE_WHITESPACE",
			"RULE_STAR",
			"RULE_ID",
			"RULE_COMMA",
			"RULE_WHITESPACE",
			"RULE_KW_INT",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_RIGHTPAREN",
			"RULE_NEWLINE",
			"RULE_LEFTBRACE",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_KW_INT",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_BLOCK_COMMENT",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_KW_IF",
			"RULE_WHITESPACE",
			"RULE_LEFTPAREN",
			"RULE_MINUS",
			"RULE_DECIMAL_LITERAL",
			"RULE_WHITESPACE",
			"RULE_LESSEQUAL",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_WHITESPACE",
			"RULE_ANDAND",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_WHITESPACE",
			"RULE_LESS",
			"RULE_WHITESPACE",
			"RULE_DECIMAL_LITERAL",
			"RULE_RIGHTPAREN",
			"RULE_WHITESPACE",
			"RULE_LEFTBRACE",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_WHITESPACE",
			"RULE_ASSIGN",
			"RULE_WHITESPACE",
			"RULE_MINUS",
			"RULE_ID",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_WHITESPACE",
			"RULE_ASSIGN",
			"RULE_WHITESPACE",
			"RULE_MINUS",
			"RULE_DECIMAL_LITERAL",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_RIGHTBRACE",
			"RULE_NEWLINE",
			"RULE_WHITESPACE",
			"RULE_KW_RETURN",
			"RULE_WHITESPACE",
			"RULE_ID",
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
		Assert.assertEquals(2, External_1_list.size());
		final ExternalDeclaration ExternalDeclaration_2_Var = (ExternalDeclaration)External_1_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_2_Var);
		final Declaration Declaration_3_Var = (Declaration)ExternalDeclaration_2_Var.getDeclaration();
		Assert.assertNotNull(Declaration_3_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_4_Var = (DeclarationSpecifiers)Declaration_3_Var.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_4_Var);
		final EList<? extends EObject> DeclarationSpecifier_4_list = DeclarationSpecifiers_4_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_4_list);
		Assert.assertEquals(2, DeclarationSpecifier_4_list.size());
		final StorageClassSpecifier StorageClassSpecifier_5_Var = (StorageClassSpecifier)DeclarationSpecifier_4_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_5_Var);
		Assert.assertEquals("extern", StorageClassSpecifier_5_Var.getName());
		final TypeSpecifier TypeSpecifier_6_Var = (TypeSpecifier)DeclarationSpecifier_4_list.get(1);
		Assert.assertNotNull(TypeSpecifier_6_Var);
		Assert.assertEquals("int", TypeSpecifier_6_Var.getName());
		final EList<? extends EObject> InitDeclaratorList_6_list = Declaration_3_Var.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_6_list);
		Assert.assertEquals(1, InitDeclaratorList_6_list.size());
		final InitDeclaratorList InitDeclaratorList_7_Var = (InitDeclaratorList)InitDeclaratorList_6_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_7_Var);
		final EList<? extends EObject> InitDeclarator_7_list = InitDeclaratorList_7_Var.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_7_list);
		Assert.assertEquals(1, InitDeclarator_7_list.size());
		final InitDeclarator InitDeclarator_8_Var = (InitDeclarator)InitDeclarator_7_list.get(0);
		Assert.assertNotNull(InitDeclarator_8_Var);
		final Declarator Declarator_9_Var = (Declarator)InitDeclarator_8_Var.getDeclarator();
		Assert.assertNotNull(Declarator_9_Var);
		final DirectDeclarator DirectDeclarator_10_Var = (DirectDeclarator)Declarator_9_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_10_Var);
		Assert.assertEquals("errno", DirectDeclarator_10_Var.getId());
		Assert.assertEquals(";", Declaration_3_Var.getSemi());
		final ExternalDeclaration ExternalDeclaration_11_Var = (ExternalDeclaration)External_1_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_11_Var);
		final FunctionDefHead FunctionDefHead_12_Var = (FunctionDefHead)ExternalDeclaration_11_Var.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_12_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_13_Var = (DeclarationSpecifiers)FunctionDefHead_12_Var.getFunDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_13_Var);
		final EList<? extends EObject> DeclarationSpecifier_13_list = DeclarationSpecifiers_13_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_13_list);
		Assert.assertEquals(1, DeclarationSpecifier_13_list.size());
		final TypeSpecifier TypeSpecifier_14_Var = (TypeSpecifier)DeclarationSpecifier_13_list.get(0);
		Assert.assertNotNull(TypeSpecifier_14_Var);
		Assert.assertEquals("int", TypeSpecifier_14_Var.getName());
		final Declarator Declarator_15_Var = (Declarator)FunctionDefHead_12_Var.getFunDeclarator();
		Assert.assertNotNull(Declarator_15_Var);
		final DirectDeclarator DirectDeclarator_16_Var = (DirectDeclarator)Declarator_15_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_16_Var);
		Assert.assertEquals("funcname", DirectDeclarator_16_Var.getId());
		final EList<? extends EObject> DeclaratorSuffix_16_list = DirectDeclarator_16_Var.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_16_list);
		Assert.assertEquals(1, DeclaratorSuffix_16_list.size());
		final DeclaratorSuffix DeclaratorSuffix_17_Var = (DeclaratorSuffix)DeclaratorSuffix_16_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_17_Var);
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_18_Var = (DirectDeclaratorLastSuffix)DeclaratorSuffix_17_Var.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_18_Var);
		final EList<? extends EObject> ParameterTypeList_18_list = DirectDeclaratorLastSuffix_18_Var.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_18_list);
		Assert.assertEquals(1, ParameterTypeList_18_list.size());
		final ParameterTypeList ParameterTypeList_19_Var = (ParameterTypeList)ParameterTypeList_18_list.get(0);
		Assert.assertNotNull(ParameterTypeList_19_Var);
		final ParameterList ParameterList_20_Var = (ParameterList)ParameterTypeList_19_Var.getList();
		Assert.assertNotNull(ParameterList_20_Var);
		final EList<? extends EObject> ParameterDeclaration_20_list = ParameterList_20_Var.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_20_list);
		Assert.assertEquals(3, ParameterDeclaration_20_list.size());
		final ParameterDeclaration ParameterDeclaration_21_Var = (ParameterDeclaration)ParameterDeclaration_20_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_21_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_22_Var = (DeclarationSpecifiers)ParameterDeclaration_21_Var.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_22_Var);
		final EList<? extends EObject> DeclarationSpecifier_22_list = DeclarationSpecifiers_22_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_22_list);
		Assert.assertEquals(1, DeclarationSpecifier_22_list.size());
		final TypeSpecifier TypeSpecifier_23_Var = (TypeSpecifier)DeclarationSpecifier_22_list.get(0);
		Assert.assertNotNull(TypeSpecifier_23_Var);
		Assert.assertEquals("int", TypeSpecifier_23_Var.getName());
		final Declarator Declarator_24_Var = (Declarator)ParameterDeclaration_21_Var.getDeclarator();
		Assert.assertNotNull(Declarator_24_Var);
		final DirectDeclarator DirectDeclarator_25_Var = (DirectDeclarator)Declarator_24_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_25_Var);
		Assert.assertEquals("arg1", DirectDeclarator_25_Var.getId());
		final ParameterDeclaration ParameterDeclaration_26_Var = (ParameterDeclaration)ParameterDeclaration_20_list.get(1);
		Assert.assertNotNull(ParameterDeclaration_26_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_27_Var = (DeclarationSpecifiers)ParameterDeclaration_26_Var.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_27_Var);
		final EList<? extends EObject> DeclarationSpecifier_27_list = DeclarationSpecifiers_27_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_27_list);
		Assert.assertEquals(1, DeclarationSpecifier_27_list.size());
		final TypeSpecifier TypeSpecifier_28_Var = (TypeSpecifier)DeclarationSpecifier_27_list.get(0);
		Assert.assertNotNull(TypeSpecifier_28_Var);
		Assert.assertEquals("int", TypeSpecifier_28_Var.getName());
		final Declarator Declarator_29_Var = (Declarator)ParameterDeclaration_26_Var.getDeclarator();
		Assert.assertNotNull(Declarator_29_Var);
		final DirectDeclarator DirectDeclarator_30_Var = (DirectDeclarator)Declarator_29_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_30_Var);
		Assert.assertEquals("arg2", DirectDeclarator_30_Var.getId());
		final Pointer Pointer_31_Var = (Pointer)Declarator_29_Var.getPointer();
		Assert.assertNotNull(Pointer_31_Var);
		Assert.assertEquals("[*]", Pointer_31_Var.getStar().toString());
		final ParameterDeclaration ParameterDeclaration_32_Var = (ParameterDeclaration)ParameterDeclaration_20_list.get(2);
		Assert.assertNotNull(ParameterDeclaration_32_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_33_Var = (DeclarationSpecifiers)ParameterDeclaration_32_Var.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_33_Var);
		final EList<? extends EObject> DeclarationSpecifier_33_list = DeclarationSpecifiers_33_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_33_list);
		Assert.assertEquals(1, DeclarationSpecifier_33_list.size());
		final TypeSpecifier TypeSpecifier_34_Var = (TypeSpecifier)DeclarationSpecifier_33_list.get(0);
		Assert.assertNotNull(TypeSpecifier_34_Var);
		Assert.assertEquals("int", TypeSpecifier_34_Var.getName());
		final Declarator Declarator_35_Var = (Declarator)ParameterDeclaration_32_Var.getDeclarator();
		Assert.assertNotNull(Declarator_35_Var);
		final DirectDeclarator DirectDeclarator_36_Var = (DirectDeclarator)Declarator_35_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_36_Var);
		Assert.assertEquals("arg3", DirectDeclarator_36_Var.getId());
		final FunctionDefinition FunctionDefinition_37_Var = (FunctionDefinition)ExternalDeclaration_11_Var.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_37_Var);
		final BodyStatement BodyStatement_38_Var = (BodyStatement)FunctionDefinition_37_Var.getBody();
		Assert.assertNotNull(BodyStatement_38_Var);
		final EList<? extends EObject> BlockList_38_list = BodyStatement_38_Var.getBlockList();
		Assert.assertNotNull(BlockList_38_list);
		Assert.assertEquals(1, BlockList_38_list.size());
		final BlockList BlockList_39_Var = (BlockList)BlockList_38_list.get(0);
		Assert.assertNotNull(BlockList_39_Var);
		final EList<? extends EObject> Declaration_39_list = BlockList_39_Var.getDeclaration();
		Assert.assertNotNull(Declaration_39_list);
		Assert.assertEquals(1, Declaration_39_list.size());
		final Declaration Declaration_40_Var = (Declaration)Declaration_39_list.get(0);
		Assert.assertNotNull(Declaration_40_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_41_Var = (DeclarationSpecifiers)Declaration_40_Var.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_41_Var);
		final EList<? extends EObject> DeclarationSpecifier_41_list = DeclarationSpecifiers_41_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_41_list);
		Assert.assertEquals(1, DeclarationSpecifier_41_list.size());
		final TypeSpecifier TypeSpecifier_42_Var = (TypeSpecifier)DeclarationSpecifier_41_list.get(0);
		Assert.assertNotNull(TypeSpecifier_42_Var);
		Assert.assertEquals("int", TypeSpecifier_42_Var.getName());
		final EList<? extends EObject> InitDeclaratorList_42_list = Declaration_40_Var.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_42_list);
		Assert.assertEquals(1, InitDeclaratorList_42_list.size());
		final InitDeclaratorList InitDeclaratorList_43_Var = (InitDeclaratorList)InitDeclaratorList_42_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_43_Var);
		final EList<? extends EObject> InitDeclarator_43_list = InitDeclaratorList_43_Var.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_43_list);
		Assert.assertEquals(1, InitDeclarator_43_list.size());
		final InitDeclarator InitDeclarator_44_Var = (InitDeclarator)InitDeclarator_43_list.get(0);
		Assert.assertNotNull(InitDeclarator_44_Var);
		final Declarator Declarator_45_Var = (Declarator)InitDeclarator_44_Var.getDeclarator();
		Assert.assertNotNull(Declarator_45_Var);
		final DirectDeclarator DirectDeclarator_46_Var = (DirectDeclarator)Declarator_45_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_46_Var);
		Assert.assertEquals("res", DirectDeclarator_46_Var.getId());
		Assert.assertEquals(";", Declaration_40_Var.getSemi());
		final EList<? extends EObject> Statement_46_list = BlockList_39_Var.getStatement();
		Assert.assertNotNull(Statement_46_list);
		Assert.assertEquals(2, Statement_46_list.size());
		final Statement Statement_47_Var = (Statement)Statement_46_list.get(0);
		Assert.assertNotNull(Statement_47_Var);
		final SelectionStatement SelectionStatement_48_Var = (SelectionStatement)Statement_47_Var.getStmt();
		Assert.assertNotNull(SelectionStatement_48_Var);
		Assert.assertEquals("if", SelectionStatement_48_Var.getIf());
		final Expression Expression_49_Var = (Expression)SelectionStatement_48_Var.getExpr();
		Assert.assertNotNull(Expression_49_Var);
		final EList<? extends EObject> ExprExpr_49_list = Expression_49_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_49_list);
		Assert.assertEquals(1, ExprExpr_49_list.size());
		final AssignmentExpression AssignmentExpression_50_Var = (AssignmentExpression)ExprExpr_49_list.get(0);
		Assert.assertNotNull(AssignmentExpression_50_Var);
		final ConditionalExpression ConditionalExpression_51_Var = (ConditionalExpression)AssignmentExpression_50_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_51_Var);
		final LogicalOrExpression LogicalOrExpression_52_Var = (LogicalOrExpression)ConditionalExpression_51_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_52_Var);
		final EList<? extends EObject> Expr_52_list = LogicalOrExpression_52_Var.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		final LogicalAndExpression LogicalAndExpression_53_Var = (LogicalAndExpression)Expr_52_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_53_Var);
		final EList<? extends EObject> Expr_53_list = LogicalAndExpression_53_Var.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(2, Expr_53_list.size());
		final InclusiveOrExpression InclusiveOrExpression_54_Var = (InclusiveOrExpression)Expr_53_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_54_Var);
		final EList<? extends EObject> Expr_54_list = InclusiveOrExpression_54_Var.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_55_Var = (ExclusiveOrExpression)Expr_54_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_55_Var);
		final EList<? extends EObject> Expr_55_list = ExclusiveOrExpression_55_Var.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		final AndExpression AndExpression_56_Var = (AndExpression)Expr_55_list.get(0);
		Assert.assertNotNull(AndExpression_56_Var);
		final EList<? extends EObject> Expr_56_list = AndExpression_56_Var.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		final EqualityExpression EqualityExpression_57_Var = (EqualityExpression)Expr_56_list.get(0);
		Assert.assertNotNull(EqualityExpression_57_Var);
		final EList<? extends EObject> Expr_57_list = EqualityExpression_57_Var.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		final RelationalExpression RelationalExpression_58_Var = (RelationalExpression)Expr_57_list.get(0);
		Assert.assertNotNull(RelationalExpression_58_Var);
		Assert.assertEquals("[<=]", RelationalExpression_58_Var.getOp().toString());
		final EList<? extends EObject> Expr_58_list = RelationalExpression_58_Var.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(2, Expr_58_list.size());
		final ShiftExpression ShiftExpression_59_Var = (ShiftExpression)Expr_58_list.get(0);
		Assert.assertNotNull(ShiftExpression_59_Var);
		final EList<? extends EObject> Expr_59_list = ShiftExpression_59_Var.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		final AdditiveExpression AdditiveExpression_60_Var = (AdditiveExpression)Expr_59_list.get(0);
		Assert.assertNotNull(AdditiveExpression_60_Var);
		final EList<? extends EObject> Expr_60_list = AdditiveExpression_60_Var.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		final MultiplicativeExpression MultiplicativeExpression_61_Var = (MultiplicativeExpression)Expr_60_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_61_Var);
		final EList<? extends EObject> Expr_61_list = MultiplicativeExpression_61_Var.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		final CastExpression CastExpression_62_Var = (CastExpression)Expr_61_list.get(0);
		Assert.assertNotNull(CastExpression_62_Var);
		final UnaryExpression UnaryExpression_63_Var = (UnaryExpression)CastExpression_62_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_63_Var);
		final CastExpression CastExpression_64_Var = (CastExpression)UnaryExpression_63_Var.getExpr();
		Assert.assertNotNull(CastExpression_64_Var);
		final UnaryExpression UnaryExpression_65_Var = (UnaryExpression)CastExpression_64_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_65_Var);
		final PostfixExpression PostfixExpression_66_Var = (PostfixExpression)UnaryExpression_65_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_66_Var);
		final EList<? extends EObject> Expr_66_list = PostfixExpression_66_Var.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		final PrimaryExpression PrimaryExpression_67_Var = (PrimaryExpression)Expr_66_list.get(0);
		Assert.assertNotNull(PrimaryExpression_67_Var);
		final Constant Constant_68_Var = (Constant)PrimaryExpression_67_Var.getConst();
		Assert.assertNotNull(Constant_68_Var);
		Assert.assertEquals("125", Constant_68_Var.getDec());
		final UnaryOperator UnaryOperator_69_Var = (UnaryOperator)UnaryExpression_63_Var.getOp();
		Assert.assertNotNull(UnaryOperator_69_Var);
		Assert.assertEquals("-", UnaryOperator_69_Var.getOp());
		final ShiftExpression ShiftExpression_70_Var = (ShiftExpression)Expr_58_list.get(1);
		Assert.assertNotNull(ShiftExpression_70_Var);
		final EList<? extends EObject> Expr_70_list = ShiftExpression_70_Var.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		final AdditiveExpression AdditiveExpression_71_Var = (AdditiveExpression)Expr_70_list.get(0);
		Assert.assertNotNull(AdditiveExpression_71_Var);
		final EList<? extends EObject> Expr_71_list = AdditiveExpression_71_Var.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		final MultiplicativeExpression MultiplicativeExpression_72_Var = (MultiplicativeExpression)Expr_71_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_72_Var);
		final EList<? extends EObject> Expr_72_list = MultiplicativeExpression_72_Var.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		final CastExpression CastExpression_73_Var = (CastExpression)Expr_72_list.get(0);
		Assert.assertNotNull(CastExpression_73_Var);
		final UnaryExpression UnaryExpression_74_Var = (UnaryExpression)CastExpression_73_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_74_Var);
		final PostfixExpression PostfixExpression_75_Var = (PostfixExpression)UnaryExpression_74_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_75_Var);
		final EList<? extends EObject> Expr_75_list = PostfixExpression_75_Var.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		final PrimaryExpression PrimaryExpression_76_Var = (PrimaryExpression)Expr_75_list.get(0);
		Assert.assertNotNull(PrimaryExpression_76_Var);
		Assert.assertEquals("res", PrimaryExpression_76_Var.getId());
		final InclusiveOrExpression InclusiveOrExpression_77_Var = (InclusiveOrExpression)Expr_53_list.get(1);
		Assert.assertNotNull(InclusiveOrExpression_77_Var);
		final EList<? extends EObject> Expr_77_list = InclusiveOrExpression_77_Var.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_78_Var = (ExclusiveOrExpression)Expr_77_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_78_Var);
		final EList<? extends EObject> Expr_78_list = ExclusiveOrExpression_78_Var.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		final AndExpression AndExpression_79_Var = (AndExpression)Expr_78_list.get(0);
		Assert.assertNotNull(AndExpression_79_Var);
		final EList<? extends EObject> Expr_79_list = AndExpression_79_Var.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		final EqualityExpression EqualityExpression_80_Var = (EqualityExpression)Expr_79_list.get(0);
		Assert.assertNotNull(EqualityExpression_80_Var);
		final EList<? extends EObject> Expr_80_list = EqualityExpression_80_Var.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		final RelationalExpression RelationalExpression_81_Var = (RelationalExpression)Expr_80_list.get(0);
		Assert.assertNotNull(RelationalExpression_81_Var);
		Assert.assertEquals("[<]", RelationalExpression_81_Var.getOp().toString());
		final EList<? extends EObject> Expr_81_list = RelationalExpression_81_Var.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(2, Expr_81_list.size());
		final ShiftExpression ShiftExpression_82_Var = (ShiftExpression)Expr_81_list.get(0);
		Assert.assertNotNull(ShiftExpression_82_Var);
		final EList<? extends EObject> Expr_82_list = ShiftExpression_82_Var.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		final AdditiveExpression AdditiveExpression_83_Var = (AdditiveExpression)Expr_82_list.get(0);
		Assert.assertNotNull(AdditiveExpression_83_Var);
		final EList<? extends EObject> Expr_83_list = AdditiveExpression_83_Var.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		final MultiplicativeExpression MultiplicativeExpression_84_Var = (MultiplicativeExpression)Expr_83_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_84_Var);
		final EList<? extends EObject> Expr_84_list = MultiplicativeExpression_84_Var.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		final CastExpression CastExpression_85_Var = (CastExpression)Expr_84_list.get(0);
		Assert.assertNotNull(CastExpression_85_Var);
		final UnaryExpression UnaryExpression_86_Var = (UnaryExpression)CastExpression_85_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_86_Var);
		final PostfixExpression PostfixExpression_87_Var = (PostfixExpression)UnaryExpression_86_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_87_Var);
		final EList<? extends EObject> Expr_87_list = PostfixExpression_87_Var.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		final PrimaryExpression PrimaryExpression_88_Var = (PrimaryExpression)Expr_87_list.get(0);
		Assert.assertNotNull(PrimaryExpression_88_Var);
		Assert.assertEquals("res", PrimaryExpression_88_Var.getId());
		final ShiftExpression ShiftExpression_89_Var = (ShiftExpression)Expr_81_list.get(1);
		Assert.assertNotNull(ShiftExpression_89_Var);
		final EList<? extends EObject> Expr_89_list = ShiftExpression_89_Var.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		final AdditiveExpression AdditiveExpression_90_Var = (AdditiveExpression)Expr_89_list.get(0);
		Assert.assertNotNull(AdditiveExpression_90_Var);
		final EList<? extends EObject> Expr_90_list = AdditiveExpression_90_Var.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		final MultiplicativeExpression MultiplicativeExpression_91_Var = (MultiplicativeExpression)Expr_90_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_91_Var);
		final EList<? extends EObject> Expr_91_list = MultiplicativeExpression_91_Var.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		final CastExpression CastExpression_92_Var = (CastExpression)Expr_91_list.get(0);
		Assert.assertNotNull(CastExpression_92_Var);
		final UnaryExpression UnaryExpression_93_Var = (UnaryExpression)CastExpression_92_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_93_Var);
		final PostfixExpression PostfixExpression_94_Var = (PostfixExpression)UnaryExpression_93_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_94_Var);
		final EList<? extends EObject> Expr_94_list = PostfixExpression_94_Var.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		final PrimaryExpression PrimaryExpression_95_Var = (PrimaryExpression)Expr_94_list.get(0);
		Assert.assertNotNull(PrimaryExpression_95_Var);
		final Constant Constant_96_Var = (Constant)PrimaryExpression_95_Var.getConst();
		Assert.assertNotNull(Constant_96_Var);
		Assert.assertEquals("0", Constant_96_Var.getDec());
		final Statement Statement_97_Var = (Statement)SelectionStatement_48_Var.getIfStatement();
		Assert.assertNotNull(Statement_97_Var);
		final CompoundStatement CompoundStatement_98_Var = (CompoundStatement)Statement_97_Var.getStmt();
		Assert.assertNotNull(CompoundStatement_98_Var);
		final BodyStatement BodyStatement_99_Var = (BodyStatement)CompoundStatement_98_Var.getBody();
		Assert.assertNotNull(BodyStatement_99_Var);
		final EList<? extends EObject> BlockList_99_list = BodyStatement_99_Var.getBlockList();
		Assert.assertNotNull(BlockList_99_list);
		Assert.assertEquals(1, BlockList_99_list.size());
		final BlockList BlockList_100_Var = (BlockList)BlockList_99_list.get(0);
		Assert.assertNotNull(BlockList_100_Var);
		final EList<? extends EObject> Statement_100_list = BlockList_100_Var.getStatement();
		Assert.assertNotNull(Statement_100_list);
		Assert.assertEquals(2, Statement_100_list.size());
		final Statement Statement_101_Var = (Statement)Statement_100_list.get(0);
		Assert.assertNotNull(Statement_101_Var);
		final ExpressionStatement ExpressionStatement_102_Var = (ExpressionStatement)Statement_101_Var.getStmt();
		Assert.assertNotNull(ExpressionStatement_102_Var);
		final Expression Expression_103_Var = (Expression)ExpressionStatement_102_Var.getExpression();
		Assert.assertNotNull(Expression_103_Var);
		final EList<? extends EObject> ExprExpr_103_list = Expression_103_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_103_list);
		Assert.assertEquals(1, ExprExpr_103_list.size());
		final AssignmentExpression AssignmentExpression_104_Var = (AssignmentExpression)ExprExpr_103_list.get(0);
		Assert.assertNotNull(AssignmentExpression_104_Var);
		final UnaryExpression UnaryExpression_105_Var = (UnaryExpression)AssignmentExpression_104_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_105_Var);
		final PostfixExpression PostfixExpression_106_Var = (PostfixExpression)UnaryExpression_105_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_106_Var);
		final EList<? extends EObject> Expr_106_list = PostfixExpression_106_Var.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		final PrimaryExpression PrimaryExpression_107_Var = (PrimaryExpression)Expr_106_list.get(0);
		Assert.assertNotNull(PrimaryExpression_107_Var);
		Assert.assertEquals("errno", PrimaryExpression_107_Var.getId());
		final AssignmentOperator AssignmentOperator_108_Var = (AssignmentOperator)AssignmentExpression_104_Var.getOp();
		Assert.assertNotNull(AssignmentOperator_108_Var);
		Assert.assertEquals("=", AssignmentOperator_108_Var.getOp());
		final AssignmentExpression AssignmentExpression_109_Var = (AssignmentExpression)AssignmentExpression_104_Var.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_109_Var);
		final ConditionalExpression ConditionalExpression_110_Var = (ConditionalExpression)AssignmentExpression_109_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_110_Var);
		final LogicalOrExpression LogicalOrExpression_111_Var = (LogicalOrExpression)ConditionalExpression_110_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_111_Var);
		final EList<? extends EObject> Expr_111_list = LogicalOrExpression_111_Var.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		final LogicalAndExpression LogicalAndExpression_112_Var = (LogicalAndExpression)Expr_111_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_112_Var);
		final EList<? extends EObject> Expr_112_list = LogicalAndExpression_112_Var.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		final InclusiveOrExpression InclusiveOrExpression_113_Var = (InclusiveOrExpression)Expr_112_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_113_Var);
		final EList<? extends EObject> Expr_113_list = InclusiveOrExpression_113_Var.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_114_Var = (ExclusiveOrExpression)Expr_113_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_114_Var);
		final EList<? extends EObject> Expr_114_list = ExclusiveOrExpression_114_Var.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		final AndExpression AndExpression_115_Var = (AndExpression)Expr_114_list.get(0);
		Assert.assertNotNull(AndExpression_115_Var);
		final EList<? extends EObject> Expr_115_list = AndExpression_115_Var.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		final EqualityExpression EqualityExpression_116_Var = (EqualityExpression)Expr_115_list.get(0);
		Assert.assertNotNull(EqualityExpression_116_Var);
		final EList<? extends EObject> Expr_116_list = EqualityExpression_116_Var.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		final RelationalExpression RelationalExpression_117_Var = (RelationalExpression)Expr_116_list.get(0);
		Assert.assertNotNull(RelationalExpression_117_Var);
		final EList<? extends EObject> Expr_117_list = RelationalExpression_117_Var.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		final ShiftExpression ShiftExpression_118_Var = (ShiftExpression)Expr_117_list.get(0);
		Assert.assertNotNull(ShiftExpression_118_Var);
		final EList<? extends EObject> Expr_118_list = ShiftExpression_118_Var.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		final AdditiveExpression AdditiveExpression_119_Var = (AdditiveExpression)Expr_118_list.get(0);
		Assert.assertNotNull(AdditiveExpression_119_Var);
		final EList<? extends EObject> Expr_119_list = AdditiveExpression_119_Var.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		final MultiplicativeExpression MultiplicativeExpression_120_Var = (MultiplicativeExpression)Expr_119_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_120_Var);
		final EList<? extends EObject> Expr_120_list = MultiplicativeExpression_120_Var.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		final CastExpression CastExpression_121_Var = (CastExpression)Expr_120_list.get(0);
		Assert.assertNotNull(CastExpression_121_Var);
		final UnaryExpression UnaryExpression_122_Var = (UnaryExpression)CastExpression_121_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_122_Var);
		final UnaryOperator UnaryOperator_123_Var = (UnaryOperator)UnaryExpression_122_Var.getOp();
		Assert.assertNotNull(UnaryOperator_123_Var);
		Assert.assertEquals("-", UnaryOperator_123_Var.getOp());
		final CastExpression CastExpression_124_Var = (CastExpression)UnaryExpression_122_Var.getExpr();
		Assert.assertNotNull(CastExpression_124_Var);
		final UnaryExpression UnaryExpression_125_Var = (UnaryExpression)CastExpression_124_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_125_Var);
		final PostfixExpression PostfixExpression_126_Var = (PostfixExpression)UnaryExpression_125_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_126_Var);
		final EList<? extends EObject> Expr_126_list = PostfixExpression_126_Var.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		final PrimaryExpression PrimaryExpression_127_Var = (PrimaryExpression)Expr_126_list.get(0);
		Assert.assertNotNull(PrimaryExpression_127_Var);
		Assert.assertEquals("res", PrimaryExpression_127_Var.getId());
		final Statement Statement_128_Var = (Statement)Statement_100_list.get(1);
		Assert.assertNotNull(Statement_128_Var);
		final ExpressionStatement ExpressionStatement_129_Var = (ExpressionStatement)Statement_128_Var.getStmt();
		Assert.assertNotNull(ExpressionStatement_129_Var);
		final Expression Expression_130_Var = (Expression)ExpressionStatement_129_Var.getExpression();
		Assert.assertNotNull(Expression_130_Var);
		final EList<? extends EObject> ExprExpr_130_list = Expression_130_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_130_list);
		Assert.assertEquals(1, ExprExpr_130_list.size());
		final AssignmentExpression AssignmentExpression_131_Var = (AssignmentExpression)ExprExpr_130_list.get(0);
		Assert.assertNotNull(AssignmentExpression_131_Var);
		final UnaryExpression UnaryExpression_132_Var = (UnaryExpression)AssignmentExpression_131_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_132_Var);
		final PostfixExpression PostfixExpression_133_Var = (PostfixExpression)UnaryExpression_132_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_133_Var);
		final EList<? extends EObject> Expr_133_list = PostfixExpression_133_Var.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		final PrimaryExpression PrimaryExpression_134_Var = (PrimaryExpression)Expr_133_list.get(0);
		Assert.assertNotNull(PrimaryExpression_134_Var);
		Assert.assertEquals("res", PrimaryExpression_134_Var.getId());
		final AssignmentOperator AssignmentOperator_135_Var = (AssignmentOperator)AssignmentExpression_131_Var.getOp();
		Assert.assertNotNull(AssignmentOperator_135_Var);
		Assert.assertEquals("=", AssignmentOperator_135_Var.getOp());
		final AssignmentExpression AssignmentExpression_136_Var = (AssignmentExpression)AssignmentExpression_131_Var.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_136_Var);
		final ConditionalExpression ConditionalExpression_137_Var = (ConditionalExpression)AssignmentExpression_136_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_137_Var);
		final LogicalOrExpression LogicalOrExpression_138_Var = (LogicalOrExpression)ConditionalExpression_137_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_138_Var);
		final EList<? extends EObject> Expr_138_list = LogicalOrExpression_138_Var.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		final LogicalAndExpression LogicalAndExpression_139_Var = (LogicalAndExpression)Expr_138_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_139_Var);
		final EList<? extends EObject> Expr_139_list = LogicalAndExpression_139_Var.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		final InclusiveOrExpression InclusiveOrExpression_140_Var = (InclusiveOrExpression)Expr_139_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_140_Var);
		final EList<? extends EObject> Expr_140_list = InclusiveOrExpression_140_Var.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_141_Var = (ExclusiveOrExpression)Expr_140_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_141_Var);
		final EList<? extends EObject> Expr_141_list = ExclusiveOrExpression_141_Var.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		final AndExpression AndExpression_142_Var = (AndExpression)Expr_141_list.get(0);
		Assert.assertNotNull(AndExpression_142_Var);
		final EList<? extends EObject> Expr_142_list = AndExpression_142_Var.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		final EqualityExpression EqualityExpression_143_Var = (EqualityExpression)Expr_142_list.get(0);
		Assert.assertNotNull(EqualityExpression_143_Var);
		final EList<? extends EObject> Expr_143_list = EqualityExpression_143_Var.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		final RelationalExpression RelationalExpression_144_Var = (RelationalExpression)Expr_143_list.get(0);
		Assert.assertNotNull(RelationalExpression_144_Var);
		final EList<? extends EObject> Expr_144_list = RelationalExpression_144_Var.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		final ShiftExpression ShiftExpression_145_Var = (ShiftExpression)Expr_144_list.get(0);
		Assert.assertNotNull(ShiftExpression_145_Var);
		final EList<? extends EObject> Expr_145_list = ShiftExpression_145_Var.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		final AdditiveExpression AdditiveExpression_146_Var = (AdditiveExpression)Expr_145_list.get(0);
		Assert.assertNotNull(AdditiveExpression_146_Var);
		final EList<? extends EObject> Expr_146_list = AdditiveExpression_146_Var.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		final MultiplicativeExpression MultiplicativeExpression_147_Var = (MultiplicativeExpression)Expr_146_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_147_Var);
		final EList<? extends EObject> Expr_147_list = MultiplicativeExpression_147_Var.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(1, Expr_147_list.size());
		final CastExpression CastExpression_148_Var = (CastExpression)Expr_147_list.get(0);
		Assert.assertNotNull(CastExpression_148_Var);
		final UnaryExpression UnaryExpression_149_Var = (UnaryExpression)CastExpression_148_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_149_Var);
		final UnaryOperator UnaryOperator_150_Var = (UnaryOperator)UnaryExpression_149_Var.getOp();
		Assert.assertNotNull(UnaryOperator_150_Var);
		Assert.assertEquals("-", UnaryOperator_150_Var.getOp());
		final CastExpression CastExpression_151_Var = (CastExpression)UnaryExpression_149_Var.getExpr();
		Assert.assertNotNull(CastExpression_151_Var);
		final UnaryExpression UnaryExpression_152_Var = (UnaryExpression)CastExpression_151_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_152_Var);
		final PostfixExpression PostfixExpression_153_Var = (PostfixExpression)UnaryExpression_152_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_153_Var);
		final EList<? extends EObject> Expr_153_list = PostfixExpression_153_Var.getExpr();
		Assert.assertNotNull(Expr_153_list);
		Assert.assertEquals(1, Expr_153_list.size());
		final PrimaryExpression PrimaryExpression_154_Var = (PrimaryExpression)Expr_153_list.get(0);
		Assert.assertNotNull(PrimaryExpression_154_Var);
		final Constant Constant_155_Var = (Constant)PrimaryExpression_154_Var.getConst();
		Assert.assertNotNull(Constant_155_Var);
		Assert.assertEquals("1", Constant_155_Var.getDec());
		final Statement Statement_156_Var = (Statement)Statement_46_list.get(1);
		Assert.assertNotNull(Statement_156_Var);
		final JumpStatement JumpStatement_157_Var = (JumpStatement)Statement_156_Var.getStmt();
		Assert.assertNotNull(JumpStatement_157_Var);
		final Expression Expression_158_Var = (Expression)JumpStatement_157_Var.getExpr();
		Assert.assertNotNull(Expression_158_Var);
		final EList<? extends EObject> ExprExpr_158_list = Expression_158_Var.getExprExpr();
		Assert.assertNotNull(ExprExpr_158_list);
		Assert.assertEquals(1, ExprExpr_158_list.size());
		final AssignmentExpression AssignmentExpression_159_Var = (AssignmentExpression)ExprExpr_158_list.get(0);
		Assert.assertNotNull(AssignmentExpression_159_Var);
		final ConditionalExpression ConditionalExpression_160_Var = (ConditionalExpression)AssignmentExpression_159_Var.getExpr();
		Assert.assertNotNull(ConditionalExpression_160_Var);
		final LogicalOrExpression LogicalOrExpression_161_Var = (LogicalOrExpression)ConditionalExpression_160_Var.getExpr();
		Assert.assertNotNull(LogicalOrExpression_161_Var);
		final EList<? extends EObject> Expr_161_list = LogicalOrExpression_161_Var.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		final LogicalAndExpression LogicalAndExpression_162_Var = (LogicalAndExpression)Expr_161_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_162_Var);
		final EList<? extends EObject> Expr_162_list = LogicalAndExpression_162_Var.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		final InclusiveOrExpression InclusiveOrExpression_163_Var = (InclusiveOrExpression)Expr_162_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_163_Var);
		final EList<? extends EObject> Expr_163_list = InclusiveOrExpression_163_Var.getExpr();
		Assert.assertNotNull(Expr_163_list);
		Assert.assertEquals(1, Expr_163_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_164_Var = (ExclusiveOrExpression)Expr_163_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_164_Var);
		final EList<? extends EObject> Expr_164_list = ExclusiveOrExpression_164_Var.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		final AndExpression AndExpression_165_Var = (AndExpression)Expr_164_list.get(0);
		Assert.assertNotNull(AndExpression_165_Var);
		final EList<? extends EObject> Expr_165_list = AndExpression_165_Var.getExpr();
		Assert.assertNotNull(Expr_165_list);
		Assert.assertEquals(1, Expr_165_list.size());
		final EqualityExpression EqualityExpression_166_Var = (EqualityExpression)Expr_165_list.get(0);
		Assert.assertNotNull(EqualityExpression_166_Var);
		final EList<? extends EObject> Expr_166_list = EqualityExpression_166_Var.getExpr();
		Assert.assertNotNull(Expr_166_list);
		Assert.assertEquals(1, Expr_166_list.size());
		final RelationalExpression RelationalExpression_167_Var = (RelationalExpression)Expr_166_list.get(0);
		Assert.assertNotNull(RelationalExpression_167_Var);
		final EList<? extends EObject> Expr_167_list = RelationalExpression_167_Var.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(1, Expr_167_list.size());
		final ShiftExpression ShiftExpression_168_Var = (ShiftExpression)Expr_167_list.get(0);
		Assert.assertNotNull(ShiftExpression_168_Var);
		final EList<? extends EObject> Expr_168_list = ShiftExpression_168_Var.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(1, Expr_168_list.size());
		final AdditiveExpression AdditiveExpression_169_Var = (AdditiveExpression)Expr_168_list.get(0);
		Assert.assertNotNull(AdditiveExpression_169_Var);
		final EList<? extends EObject> Expr_169_list = AdditiveExpression_169_Var.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		final MultiplicativeExpression MultiplicativeExpression_170_Var = (MultiplicativeExpression)Expr_169_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_170_Var);
		final EList<? extends EObject> Expr_170_list = MultiplicativeExpression_170_Var.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		final CastExpression CastExpression_171_Var = (CastExpression)Expr_170_list.get(0);
		Assert.assertNotNull(CastExpression_171_Var);
		final UnaryExpression UnaryExpression_172_Var = (UnaryExpression)CastExpression_171_Var.getExpr();
		Assert.assertNotNull(UnaryExpression_172_Var);
		final PostfixExpression PostfixExpression_173_Var = (PostfixExpression)UnaryExpression_172_Var.getExpr();
		Assert.assertNotNull(PostfixExpression_173_Var);
		final EList<? extends EObject> Expr_173_list = PostfixExpression_173_Var.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		final PrimaryExpression PrimaryExpression_174_Var = (PrimaryExpression)Expr_173_list.get(0);
		Assert.assertNotNull(PrimaryExpression_174_Var);
		Assert.assertEquals("res", PrimaryExpression_174_Var.getId());
		Assert.assertEquals("return", JumpStatement_157_Var.getReturn());
		Assert.assertEquals(";", JumpStatement_157_Var.getSemi());
	}


}
