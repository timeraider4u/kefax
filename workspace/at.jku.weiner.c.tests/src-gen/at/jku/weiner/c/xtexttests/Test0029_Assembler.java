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
	}


}
