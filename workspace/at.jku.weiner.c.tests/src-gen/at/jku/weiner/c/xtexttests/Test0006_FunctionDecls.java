package at.jku.weiner.c.xtexttests;

import com.google.inject.Inject;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.antlr.runtime.Token;
import org.eclipse.emf.common.util.EList;
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
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
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
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.DeclaratorSuffix;
import at.jku.weiner.c.c.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.c.ParameterTypeList;
import at.jku.weiner.c.c.ParameterList;
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;

@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0006_FunctionDecls {

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
		final Path path = Paths.get("res/Test0006_FunctionDecls.c");
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
	@Test
	public void checkLexerTokens()
	throws Exception{
		final String text = this.getSourceText();
		//System.out.println(text);
		final String[] expected = new String[] {
			"RULE_KW_VOID",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_LEFTPAREN",
			"RULE_KW_CHAR",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_COMMA",
			"RULE_WHITESPACE",
			"RULE_KW_FLOAT",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_COMMA",
			"RULE_WHITESPACE",
			"RULE_KW_INT",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_RIGHTPAREN",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_KW_VOID",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_LEFTPAREN",
			"RULE_KW_CHAR",
			"RULE_COMMA",
			"RULE_WHITESPACE",
			"RULE_KW_FLOAT",
			"RULE_COMMA",
			"RULE_WHITESPACE",
			"RULE_KW_INT",
			"RULE_RIGHTPAREN",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_LINE_COMMENT",
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
		Assert.assertEquals(1, DeclarationSpecifier_4_list.size());
		final TypeSpecifier TypeSpecifier_5_Var = (TypeSpecifier)DeclarationSpecifier_4_list.get(0);
		Assert.assertNotNull(TypeSpecifier_5_Var);
		Assert.assertEquals("void", TypeSpecifier_5_Var.getName());
		final EList<? extends EObject> InitDeclaratorList_5_list = Declaration_3_Var.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_5_list);
		Assert.assertEquals(1, InitDeclaratorList_5_list.size());
		final InitDeclaratorList InitDeclaratorList_6_Var = (InitDeclaratorList)InitDeclaratorList_5_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_6_Var);
		final EList<? extends EObject> InitDeclarator_6_list = InitDeclaratorList_6_Var.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_6_list);
		Assert.assertEquals(1, InitDeclarator_6_list.size());
		final InitDeclarator InitDeclarator_7_Var = (InitDeclarator)InitDeclarator_6_list.get(0);
		Assert.assertNotNull(InitDeclarator_7_Var);
		final Declarator Declarator_8_Var = (Declarator)InitDeclarator_7_Var.getDeclarator();
		Assert.assertNotNull(Declarator_8_Var);
		final DirectDeclarator DirectDeclarator_9_Var = (DirectDeclarator)Declarator_8_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_9_Var);
		Assert.assertEquals("do1", DirectDeclarator_9_Var.getId());
		final EList<? extends EObject> DeclaratorSuffix_9_list = DirectDeclarator_9_Var.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_9_list);
		Assert.assertEquals(1, DeclaratorSuffix_9_list.size());
		final DeclaratorSuffix DeclaratorSuffix_10_Var = (DeclaratorSuffix)DeclaratorSuffix_9_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_10_Var);
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_11_Var = (DirectDeclaratorLastSuffix)DeclaratorSuffix_10_Var.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_11_Var);
		final EList<? extends EObject> ParameterTypeList_11_list = DirectDeclaratorLastSuffix_11_Var.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_11_list);
		Assert.assertEquals(1, ParameterTypeList_11_list.size());
		final ParameterTypeList ParameterTypeList_12_Var = (ParameterTypeList)ParameterTypeList_11_list.get(0);
		Assert.assertNotNull(ParameterTypeList_12_Var);
		final ParameterList ParameterList_13_Var = (ParameterList)ParameterTypeList_12_Var.getList();
		Assert.assertNotNull(ParameterList_13_Var);
		final EList<? extends EObject> ParameterDeclaration_13_list = ParameterList_13_Var.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_13_list);
		Assert.assertEquals(3, ParameterDeclaration_13_list.size());
		final ParameterDeclaration ParameterDeclaration_14_Var = (ParameterDeclaration)ParameterDeclaration_13_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_14_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_15_Var = (DeclarationSpecifiers)ParameterDeclaration_14_Var.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_15_Var);
		final EList<? extends EObject> DeclarationSpecifier_15_list = DeclarationSpecifiers_15_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_15_list);
		Assert.assertEquals(1, DeclarationSpecifier_15_list.size());
		final TypeSpecifier TypeSpecifier_16_Var = (TypeSpecifier)DeclarationSpecifier_15_list.get(0);
		Assert.assertNotNull(TypeSpecifier_16_Var);
		Assert.assertEquals("char", TypeSpecifier_16_Var.getName());
		final Declarator Declarator_17_Var = (Declarator)ParameterDeclaration_14_Var.getDeclarator();
		Assert.assertNotNull(Declarator_17_Var);
		final DirectDeclarator DirectDeclarator_18_Var = (DirectDeclarator)Declarator_17_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_18_Var);
		Assert.assertEquals("c", DirectDeclarator_18_Var.getId());
		final ParameterDeclaration ParameterDeclaration_19_Var = (ParameterDeclaration)ParameterDeclaration_13_list.get(1);
		Assert.assertNotNull(ParameterDeclaration_19_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_20_Var = (DeclarationSpecifiers)ParameterDeclaration_19_Var.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_20_Var);
		final EList<? extends EObject> DeclarationSpecifier_20_list = DeclarationSpecifiers_20_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_20_list);
		Assert.assertEquals(1, DeclarationSpecifier_20_list.size());
		final TypeSpecifier TypeSpecifier_21_Var = (TypeSpecifier)DeclarationSpecifier_20_list.get(0);
		Assert.assertNotNull(TypeSpecifier_21_Var);
		Assert.assertEquals("float", TypeSpecifier_21_Var.getName());
		final Declarator Declarator_22_Var = (Declarator)ParameterDeclaration_19_Var.getDeclarator();
		Assert.assertNotNull(Declarator_22_Var);
		final DirectDeclarator DirectDeclarator_23_Var = (DirectDeclarator)Declarator_22_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_23_Var);
		Assert.assertEquals("f", DirectDeclarator_23_Var.getId());
		final ParameterDeclaration ParameterDeclaration_24_Var = (ParameterDeclaration)ParameterDeclaration_13_list.get(2);
		Assert.assertNotNull(ParameterDeclaration_24_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_25_Var = (DeclarationSpecifiers)ParameterDeclaration_24_Var.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_25_Var);
		final EList<? extends EObject> DeclarationSpecifier_25_list = DeclarationSpecifiers_25_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_25_list);
		Assert.assertEquals(1, DeclarationSpecifier_25_list.size());
		final TypeSpecifier TypeSpecifier_26_Var = (TypeSpecifier)DeclarationSpecifier_25_list.get(0);
		Assert.assertNotNull(TypeSpecifier_26_Var);
		Assert.assertEquals("int", TypeSpecifier_26_Var.getName());
		final Declarator Declarator_27_Var = (Declarator)ParameterDeclaration_24_Var.getDeclarator();
		Assert.assertNotNull(Declarator_27_Var);
		final DirectDeclarator DirectDeclarator_28_Var = (DirectDeclarator)Declarator_27_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_28_Var);
		Assert.assertEquals("i", DirectDeclarator_28_Var.getId());
		Assert.assertEquals(";", Declaration_3_Var.getSemi());
		final ExternalDeclaration ExternalDeclaration_29_Var = (ExternalDeclaration)External_1_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_29_Var);
		final Declaration Declaration_30_Var = (Declaration)ExternalDeclaration_29_Var.getDeclaration();
		Assert.assertNotNull(Declaration_30_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_31_Var = (DeclarationSpecifiers)Declaration_30_Var.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_31_Var);
		final EList<? extends EObject> DeclarationSpecifier_31_list = DeclarationSpecifiers_31_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_31_list);
		Assert.assertEquals(1, DeclarationSpecifier_31_list.size());
		final TypeSpecifier TypeSpecifier_32_Var = (TypeSpecifier)DeclarationSpecifier_31_list.get(0);
		Assert.assertNotNull(TypeSpecifier_32_Var);
		Assert.assertEquals("void", TypeSpecifier_32_Var.getName());
		final EList<? extends EObject> InitDeclaratorList_32_list = Declaration_30_Var.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_32_list);
		Assert.assertEquals(1, InitDeclaratorList_32_list.size());
		final InitDeclaratorList InitDeclaratorList_33_Var = (InitDeclaratorList)InitDeclaratorList_32_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_33_Var);
		final EList<? extends EObject> InitDeclarator_33_list = InitDeclaratorList_33_Var.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_33_list);
		Assert.assertEquals(1, InitDeclarator_33_list.size());
		final InitDeclarator InitDeclarator_34_Var = (InitDeclarator)InitDeclarator_33_list.get(0);
		Assert.assertNotNull(InitDeclarator_34_Var);
		final Declarator Declarator_35_Var = (Declarator)InitDeclarator_34_Var.getDeclarator();
		Assert.assertNotNull(Declarator_35_Var);
		final DirectDeclarator DirectDeclarator_36_Var = (DirectDeclarator)Declarator_35_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_36_Var);
		Assert.assertEquals("do2", DirectDeclarator_36_Var.getId());
		final EList<? extends EObject> DeclaratorSuffix_36_list = DirectDeclarator_36_Var.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_36_list);
		Assert.assertEquals(1, DeclaratorSuffix_36_list.size());
		final DeclaratorSuffix DeclaratorSuffix_37_Var = (DeclaratorSuffix)DeclaratorSuffix_36_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_37_Var);
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_38_Var = (DirectDeclaratorLastSuffix)DeclaratorSuffix_37_Var.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_38_Var);
		final EList<? extends EObject> ParameterTypeList_38_list = DirectDeclaratorLastSuffix_38_Var.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_38_list);
		Assert.assertEquals(1, ParameterTypeList_38_list.size());
		final ParameterTypeList ParameterTypeList_39_Var = (ParameterTypeList)ParameterTypeList_38_list.get(0);
		Assert.assertNotNull(ParameterTypeList_39_Var);
		final ParameterList ParameterList_40_Var = (ParameterList)ParameterTypeList_39_Var.getList();
		Assert.assertNotNull(ParameterList_40_Var);
		final EList<? extends EObject> ParameterDeclaration_40_list = ParameterList_40_Var.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_40_list);
		Assert.assertEquals(3, ParameterDeclaration_40_list.size());
		final ParameterDeclaration ParameterDeclaration_41_Var = (ParameterDeclaration)ParameterDeclaration_40_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_41_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_42_Var = (DeclarationSpecifiers)ParameterDeclaration_41_Var.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_42_Var);
		final EList<? extends EObject> DeclarationSpecifier_42_list = DeclarationSpecifiers_42_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_42_list);
		Assert.assertEquals(1, DeclarationSpecifier_42_list.size());
		final TypeSpecifier TypeSpecifier_43_Var = (TypeSpecifier)DeclarationSpecifier_42_list.get(0);
		Assert.assertNotNull(TypeSpecifier_43_Var);
		Assert.assertEquals("char", TypeSpecifier_43_Var.getName());
		final ParameterDeclaration ParameterDeclaration_44_Var = (ParameterDeclaration)ParameterDeclaration_40_list.get(1);
		Assert.assertNotNull(ParameterDeclaration_44_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_45_Var = (DeclarationSpecifiers)ParameterDeclaration_44_Var.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_45_Var);
		final EList<? extends EObject> DeclarationSpecifier_45_list = DeclarationSpecifiers_45_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_45_list);
		Assert.assertEquals(1, DeclarationSpecifier_45_list.size());
		final TypeSpecifier TypeSpecifier_46_Var = (TypeSpecifier)DeclarationSpecifier_45_list.get(0);
		Assert.assertNotNull(TypeSpecifier_46_Var);
		Assert.assertEquals("float", TypeSpecifier_46_Var.getName());
		final ParameterDeclaration ParameterDeclaration_47_Var = (ParameterDeclaration)ParameterDeclaration_40_list.get(2);
		Assert.assertNotNull(ParameterDeclaration_47_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_48_Var = (DeclarationSpecifiers)ParameterDeclaration_47_Var.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_48_Var);
		final EList<? extends EObject> DeclarationSpecifier_48_list = DeclarationSpecifiers_48_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_48_list);
		Assert.assertEquals(1, DeclarationSpecifier_48_list.size());
		final TypeSpecifier TypeSpecifier_49_Var = (TypeSpecifier)DeclarationSpecifier_48_list.get(0);
		Assert.assertNotNull(TypeSpecifier_49_Var);
		Assert.assertEquals("int", TypeSpecifier_49_Var.getName());
		Assert.assertEquals(";", Declaration_30_Var.getSemi());
	}


}
