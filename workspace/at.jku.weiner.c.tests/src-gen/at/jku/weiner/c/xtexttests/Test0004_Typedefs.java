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
import at.jku.weiner.c.c.StorageClassSpecifier;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.StorageClassSpecifier;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.TypedefName;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.TypedefName;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.TypedefName;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;

@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0004_Typedefs {

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
		final Path path = Paths.get("res/Test0004_Typedefs.c");
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
	@Test
	public void checkLexerTokens()
	throws Exception{
		final String text = this.getSourceText();
		//System.out.println(text);
		final String[] expected = new String[] {
			"RULE_KW_TYPEDEF",
			"RULE_WHITESPACE",
			"RULE_KW_INT",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_KW_TYPEDEF",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_ID",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_ID",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_SEMI",
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
		Assert.assertEquals(4, External_1_list.size());
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
		Assert.assertEquals("typedef", StorageClassSpecifier_5_Var.getClass_());
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
		Assert.assertEquals("NUMBER1", DirectDeclarator_10_Var.getId());
		Assert.assertEquals(";", ExternalDeclaration_2_Var.getSemi());
		final ExternalDeclaration ExternalDeclaration_11_Var = (ExternalDeclaration)External_1_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_11_Var);
		final Declaration Declaration_12_Var = (Declaration)ExternalDeclaration_11_Var.getDeclaration();
		Assert.assertNotNull(Declaration_12_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_13_Var = (DeclarationSpecifiers)Declaration_12_Var.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_13_Var);
		final EList<? extends EObject> DeclarationSpecifier_13_list = DeclarationSpecifiers_13_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_13_list);
		Assert.assertEquals(2, DeclarationSpecifier_13_list.size());
		final StorageClassSpecifier StorageClassSpecifier_14_Var = (StorageClassSpecifier)DeclarationSpecifier_13_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_14_Var);
		Assert.assertEquals("typedef", StorageClassSpecifier_14_Var.getClass_());
		final TypeSpecifier TypeSpecifier_15_Var = (TypeSpecifier)DeclarationSpecifier_13_list.get(1);
		Assert.assertNotNull(TypeSpecifier_15_Var);
		final TypedefName TypedefName_16_Var = (TypedefName)TypeSpecifier_15_Var.getType();
		Assert.assertNotNull(TypedefName_16_Var);
		Assert.assertEquals("NUMBER1", TypedefName_16_Var.getId());
		final EList<? extends EObject> InitDeclaratorList_16_list = Declaration_12_Var.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_16_list);
		Assert.assertEquals(1, InitDeclaratorList_16_list.size());
		final InitDeclaratorList InitDeclaratorList_17_Var = (InitDeclaratorList)InitDeclaratorList_16_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_17_Var);
		final EList<? extends EObject> InitDeclarator_17_list = InitDeclaratorList_17_Var.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_17_list);
		Assert.assertEquals(1, InitDeclarator_17_list.size());
		final InitDeclarator InitDeclarator_18_Var = (InitDeclarator)InitDeclarator_17_list.get(0);
		Assert.assertNotNull(InitDeclarator_18_Var);
		final Declarator Declarator_19_Var = (Declarator)InitDeclarator_18_Var.getDeclarator();
		Assert.assertNotNull(Declarator_19_Var);
		final DirectDeclarator DirectDeclarator_20_Var = (DirectDeclarator)Declarator_19_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_20_Var);
		Assert.assertEquals("NUMBER2", DirectDeclarator_20_Var.getId());
		Assert.assertEquals(";", ExternalDeclaration_11_Var.getSemi());
		final ExternalDeclaration ExternalDeclaration_21_Var = (ExternalDeclaration)External_1_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_21_Var);
		final Declaration Declaration_22_Var = (Declaration)ExternalDeclaration_21_Var.getDeclaration();
		Assert.assertNotNull(Declaration_22_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_23_Var = (DeclarationSpecifiers)Declaration_22_Var.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_23_Var);
		final EList<? extends EObject> DeclarationSpecifier_23_list = DeclarationSpecifiers_23_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_23_list);
		Assert.assertEquals(1, DeclarationSpecifier_23_list.size());
		final TypeSpecifier TypeSpecifier_24_Var = (TypeSpecifier)DeclarationSpecifier_23_list.get(0);
		Assert.assertNotNull(TypeSpecifier_24_Var);
		final TypedefName TypedefName_25_Var = (TypedefName)TypeSpecifier_24_Var.getType();
		Assert.assertNotNull(TypedefName_25_Var);
		Assert.assertEquals("NUMBER1", TypedefName_25_Var.getId());
		final EList<? extends EObject> InitDeclaratorList_25_list = Declaration_22_Var.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_25_list);
		Assert.assertEquals(1, InitDeclaratorList_25_list.size());
		final InitDeclaratorList InitDeclaratorList_26_Var = (InitDeclaratorList)InitDeclaratorList_25_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_26_Var);
		final EList<? extends EObject> InitDeclarator_26_list = InitDeclaratorList_26_Var.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_26_list);
		Assert.assertEquals(1, InitDeclarator_26_list.size());
		final InitDeclarator InitDeclarator_27_Var = (InitDeclarator)InitDeclarator_26_list.get(0);
		Assert.assertNotNull(InitDeclarator_27_Var);
		final Declarator Declarator_28_Var = (Declarator)InitDeclarator_27_Var.getDeclarator();
		Assert.assertNotNull(Declarator_28_Var);
		final DirectDeclarator DirectDeclarator_29_Var = (DirectDeclarator)Declarator_28_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_29_Var);
		Assert.assertEquals("a", DirectDeclarator_29_Var.getId());
		Assert.assertEquals(";", ExternalDeclaration_21_Var.getSemi());
		final ExternalDeclaration ExternalDeclaration_30_Var = (ExternalDeclaration)External_1_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_30_Var);
		final Declaration Declaration_31_Var = (Declaration)ExternalDeclaration_30_Var.getDeclaration();
		Assert.assertNotNull(Declaration_31_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_32_Var = (DeclarationSpecifiers)Declaration_31_Var.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_32_Var);
		final EList<? extends EObject> DeclarationSpecifier_32_list = DeclarationSpecifiers_32_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_32_list);
		Assert.assertEquals(1, DeclarationSpecifier_32_list.size());
		final TypeSpecifier TypeSpecifier_33_Var = (TypeSpecifier)DeclarationSpecifier_32_list.get(0);
		Assert.assertNotNull(TypeSpecifier_33_Var);
		final TypedefName TypedefName_34_Var = (TypedefName)TypeSpecifier_33_Var.getType();
		Assert.assertNotNull(TypedefName_34_Var);
		Assert.assertEquals("NUMBER2", TypedefName_34_Var.getId());
		final EList<? extends EObject> InitDeclaratorList_34_list = Declaration_31_Var.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_34_list);
		Assert.assertEquals(1, InitDeclaratorList_34_list.size());
		final InitDeclaratorList InitDeclaratorList_35_Var = (InitDeclaratorList)InitDeclaratorList_34_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_35_Var);
		final EList<? extends EObject> InitDeclarator_35_list = InitDeclaratorList_35_Var.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_35_list);
		Assert.assertEquals(1, InitDeclarator_35_list.size());
		final InitDeclarator InitDeclarator_36_Var = (InitDeclarator)InitDeclarator_35_list.get(0);
		Assert.assertNotNull(InitDeclarator_36_Var);
		final Declarator Declarator_37_Var = (Declarator)InitDeclarator_36_Var.getDeclarator();
		Assert.assertNotNull(Declarator_37_Var);
		final DirectDeclarator DirectDeclarator_38_Var = (DirectDeclarator)Declarator_37_Var.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_38_Var);
		Assert.assertEquals("b", DirectDeclarator_38_Var.getId());
		Assert.assertEquals(";", ExternalDeclaration_30_Var.getSemi());
	}


}
