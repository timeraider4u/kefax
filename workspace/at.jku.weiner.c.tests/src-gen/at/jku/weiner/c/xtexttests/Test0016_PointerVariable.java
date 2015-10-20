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
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.Pointer;
import at.jku.weiner.c.c.TypeQualifierList;
import at.jku.weiner.c.c.TypeQualifier;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.Pointer;

@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0016_PointerVariable {

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
		final Path path = Paths.get("res/Test0016_PointerVariable.c");
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
	@Test
	public void checkLexerTokens()
	throws Exception{
		final String text = this.getSourceText();
		//System.out.println(text);
		final String[] expected = new String[] {
			"RULE_KW_FLOAT",
			"RULE_WHITESPACE",
			"RULE_STAR",
			"RULE_WHITESPACE",
			"RULE_KW_CONST",
			"RULE_WHITESPACE",
			"RULE_ID",
			"RULE_SEMI",
			"RULE_NEWLINE",
			"RULE_KW_DOUBLE",
			"RULE_WHITESPACE",
			"RULE_STAR",
			"RULE_WHITESPACE",
			"RULE_STAR",
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
		Assert.assertEquals("float", TypeSpecifier_5_Var.getName());
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
		Assert.assertEquals("a", DirectDeclarator_9_Var.getId());
		final Pointer Pointer_10_Var = (Pointer)Declarator_8_Var.getPointer();
		Assert.assertNotNull(Pointer_10_Var);
		Assert.assertEquals("[*]", Pointer_10_Var.getStar().toString());
		final EList<? extends EObject> TypeQualifierList_10_list = Pointer_10_Var.getTypeQualifierList();
		Assert.assertNotNull(TypeQualifierList_10_list);
		Assert.assertEquals(1, TypeQualifierList_10_list.size());
		final TypeQualifierList TypeQualifierList_11_Var = (TypeQualifierList)TypeQualifierList_10_list.get(0);
		Assert.assertNotNull(TypeQualifierList_11_Var);
		final EList<? extends EObject> TypeQualifier_11_list = TypeQualifierList_11_Var.getTypeQualifier();
		Assert.assertNotNull(TypeQualifier_11_list);
		Assert.assertEquals(1, TypeQualifier_11_list.size());
		final TypeQualifier TypeQualifier_12_Var = (TypeQualifier)TypeQualifier_11_list.get(0);
		Assert.assertNotNull(TypeQualifier_12_Var);
		Assert.assertEquals("const", TypeQualifier_12_Var.getType());
		Assert.assertEquals(";", Declaration_3_Var.getSemi());
		final ExternalDeclaration ExternalDeclaration_13_Var = (ExternalDeclaration)External_1_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_13_Var);
		final Declaration Declaration_14_Var = (Declaration)ExternalDeclaration_13_Var.getDeclaration();
		Assert.assertNotNull(Declaration_14_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_15_Var = (DeclarationSpecifiers)Declaration_14_Var.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_15_Var);
		final EList<? extends EObject> DeclarationSpecifier_15_list = DeclarationSpecifiers_15_Var.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_15_list);
		Assert.assertEquals(1, DeclarationSpecifier_15_list.size());
		final TypeSpecifier TypeSpecifier_16_Var = (TypeSpecifier)DeclarationSpecifier_15_list.get(0);
		Assert.assertNotNull(TypeSpecifier_16_Var);
		Assert.assertEquals("double", TypeSpecifier_16_Var.getName());
		final EList<? extends EObject> InitDeclaratorList_16_list = Declaration_14_Var.getInitDeclaratorList();
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
		Assert.assertEquals("b", DirectDeclarator_20_Var.getId());
		final Pointer Pointer_21_Var = (Pointer)Declarator_19_Var.getPointer();
		Assert.assertNotNull(Pointer_21_Var);
		Assert.assertEquals("[*, *]", Pointer_21_Var.getStar().toString());
		Assert.assertEquals(";", Declaration_14_Var.getSemi());
	}


}
