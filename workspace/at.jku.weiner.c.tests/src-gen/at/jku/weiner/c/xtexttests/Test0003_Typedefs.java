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
import at.jku.weiner.c.c.TypeSpecifier;
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
import at.jku.weiner.c.c.StorageClassSpecifier;
import at.jku.weiner.c.c.TypeSpecifier;
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
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0003_Typedefs {
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
			"res/Test0003_Typedefs.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_KW_TYPEDEF", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_KW_TYPEDEF", 
				"RULE_WHITESPACE", 
				"RULE_KW_DOUBLE", 
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
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_KW_INT", 
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
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0003_Typedefs.c");
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
		Assert.assertEquals(9, External_1_list.size());
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
		Assert.assertEquals("a", DirectDeclarator_9_Var
		.getId());
		Assert.assertEquals(";", Declaration_3_Var
		.getSemi());
		//9
		final ExternalDeclaration ExternalDeclaration_10_Var
		 = (ExternalDeclaration)External_1_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_10_Var
		);
		//10
		final Declaration Declaration_11_Var
		 = (Declaration)ExternalDeclaration_10_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_11_Var
		);
		//11
		final DeclarationSpecifiers DeclarationSpecifiers_12_Var
		 = (DeclarationSpecifiers)Declaration_11_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_12_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_12_list = DeclarationSpecifiers_12_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_12_list);
		Assert.assertEquals(2, DeclarationSpecifier_12_list.size());
		//12
		final StorageClassSpecifier StorageClassSpecifier_13_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_12_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_13_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_13_Var
		.getName());
		//13
		final TypeSpecifier TypeSpecifier_14_Var
		 = (TypeSpecifier)DeclarationSpecifier_12_list.get(1);
		Assert.assertNotNull(TypeSpecifier_14_Var
		);
		Assert.assertEquals("int", TypeSpecifier_14_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_14_list = Declaration_11_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_14_list);
		Assert.assertEquals(1, InitDeclaratorList_14_list.size());
		//14
		final InitDeclaratorList InitDeclaratorList_15_Var
		 = (InitDeclaratorList)InitDeclaratorList_14_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_15_Var
		);
		final EList<? extends EObject> InitDeclarator_15_list = InitDeclaratorList_15_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_15_list);
		Assert.assertEquals(1, InitDeclarator_15_list.size());
		//15
		final InitDeclarator InitDeclarator_16_Var
		 = (InitDeclarator)InitDeclarator_15_list.get(0);
		Assert.assertNotNull(InitDeclarator_16_Var
		);
		//16
		final Declarator Declarator_17_Var
		 = (Declarator)InitDeclarator_16_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_17_Var
		);
		//17
		final DirectDeclarator DirectDeclarator_18_Var
		 = (DirectDeclarator)Declarator_17_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_18_Var
		);
		Assert.assertEquals("NUMBER1", DirectDeclarator_18_Var
		.getId());
		Assert.assertEquals(";", Declaration_11_Var
		.getSemi());
		//18
		final ExternalDeclaration ExternalDeclaration_19_Var
		 = (ExternalDeclaration)External_1_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_19_Var
		);
		//19
		final Declaration Declaration_20_Var
		 = (Declaration)ExternalDeclaration_19_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_20_Var
		);
		//20
		final DeclarationSpecifiers DeclarationSpecifiers_21_Var
		 = (DeclarationSpecifiers)Declaration_20_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_21_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_21_list = DeclarationSpecifiers_21_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_21_list);
		Assert.assertEquals(1, DeclarationSpecifier_21_list.size());
		//21
		final TypeSpecifier TypeSpecifier_22_Var
		 = (TypeSpecifier)DeclarationSpecifier_21_list.get(0);
		Assert.assertNotNull(TypeSpecifier_22_Var
		);
		Assert.assertEquals("int", TypeSpecifier_22_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_22_list = Declaration_20_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_22_list);
		Assert.assertEquals(1, InitDeclaratorList_22_list.size());
		//22
		final InitDeclaratorList InitDeclaratorList_23_Var
		 = (InitDeclaratorList)InitDeclaratorList_22_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_23_Var
		);
		final EList<? extends EObject> InitDeclarator_23_list = InitDeclaratorList_23_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_23_list);
		Assert.assertEquals(1, InitDeclarator_23_list.size());
		//23
		final InitDeclarator InitDeclarator_24_Var
		 = (InitDeclarator)InitDeclarator_23_list.get(0);
		Assert.assertNotNull(InitDeclarator_24_Var
		);
		//24
		final Declarator Declarator_25_Var
		 = (Declarator)InitDeclarator_24_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_25_Var
		);
		//25
		final DirectDeclarator DirectDeclarator_26_Var
		 = (DirectDeclarator)Declarator_25_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_26_Var
		);
		Assert.assertEquals("b", DirectDeclarator_26_Var
		.getId());
		Assert.assertEquals(";", Declaration_20_Var
		.getSemi());
		//26
		final ExternalDeclaration ExternalDeclaration_27_Var
		 = (ExternalDeclaration)External_1_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_27_Var
		);
		//27
		final Declaration Declaration_28_Var
		 = (Declaration)ExternalDeclaration_27_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_28_Var
		);
		//28
		final DeclarationSpecifiers DeclarationSpecifiers_29_Var
		 = (DeclarationSpecifiers)Declaration_28_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_29_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_29_list = DeclarationSpecifiers_29_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_29_list);
		Assert.assertEquals(1, DeclarationSpecifier_29_list.size());
		//29
		final TypeSpecifier TypeSpecifier_30_Var
		 = (TypeSpecifier)DeclarationSpecifier_29_list.get(0);
		Assert.assertNotNull(TypeSpecifier_30_Var
		);
		//30
		final TypedefName TypedefName_31_Var
		 = (TypedefName)TypeSpecifier_30_Var
		.getType();
		Assert.assertNotNull(TypedefName_31_Var
		);
		Assert.assertEquals("NUMBER1", TypedefName_31_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_31_list = Declaration_28_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_31_list);
		Assert.assertEquals(1, InitDeclaratorList_31_list.size());
		//31
		final InitDeclaratorList InitDeclaratorList_32_Var
		 = (InitDeclaratorList)InitDeclaratorList_31_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_32_Var
		);
		final EList<? extends EObject> InitDeclarator_32_list = InitDeclaratorList_32_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_32_list);
		Assert.assertEquals(1, InitDeclarator_32_list.size());
		//32
		final InitDeclarator InitDeclarator_33_Var
		 = (InitDeclarator)InitDeclarator_32_list.get(0);
		Assert.assertNotNull(InitDeclarator_33_Var
		);
		//33
		final Declarator Declarator_34_Var
		 = (Declarator)InitDeclarator_33_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_34_Var
		);
		//34
		final DirectDeclarator DirectDeclarator_35_Var
		 = (DirectDeclarator)Declarator_34_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_35_Var
		);
		Assert.assertEquals("c", DirectDeclarator_35_Var
		.getId());
		Assert.assertEquals(";", Declaration_28_Var
		.getSemi());
		//35
		final ExternalDeclaration ExternalDeclaration_36_Var
		 = (ExternalDeclaration)External_1_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_36_Var
		);
		//36
		final Declaration Declaration_37_Var
		 = (Declaration)ExternalDeclaration_36_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_37_Var
		);
		//37
		final DeclarationSpecifiers DeclarationSpecifiers_38_Var
		 = (DeclarationSpecifiers)Declaration_37_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_38_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_38_list = DeclarationSpecifiers_38_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_38_list);
		Assert.assertEquals(2, DeclarationSpecifier_38_list.size());
		//38
		final StorageClassSpecifier StorageClassSpecifier_39_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_38_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_39_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_39_Var
		.getName());
		//39
		final TypeSpecifier TypeSpecifier_40_Var
		 = (TypeSpecifier)DeclarationSpecifier_38_list.get(1);
		Assert.assertNotNull(TypeSpecifier_40_Var
		);
		Assert.assertEquals("double", TypeSpecifier_40_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_40_list = Declaration_37_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_40_list);
		Assert.assertEquals(1, InitDeclaratorList_40_list.size());
		//40
		final InitDeclaratorList InitDeclaratorList_41_Var
		 = (InitDeclaratorList)InitDeclaratorList_40_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_41_Var
		);
		final EList<? extends EObject> InitDeclarator_41_list = InitDeclaratorList_41_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_41_list);
		Assert.assertEquals(1, InitDeclarator_41_list.size());
		//41
		final InitDeclarator InitDeclarator_42_Var
		 = (InitDeclarator)InitDeclarator_41_list.get(0);
		Assert.assertNotNull(InitDeclarator_42_Var
		);
		//42
		final Declarator Declarator_43_Var
		 = (Declarator)InitDeclarator_42_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_43_Var
		);
		//43
		final DirectDeclarator DirectDeclarator_44_Var
		 = (DirectDeclarator)Declarator_43_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_44_Var
		);
		Assert.assertEquals("NUMBER2", DirectDeclarator_44_Var
		.getId());
		Assert.assertEquals(";", Declaration_37_Var
		.getSemi());
		//44
		final ExternalDeclaration ExternalDeclaration_45_Var
		 = (ExternalDeclaration)External_1_list.get(5);
		Assert.assertNotNull(ExternalDeclaration_45_Var
		);
		//45
		final Declaration Declaration_46_Var
		 = (Declaration)ExternalDeclaration_45_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_46_Var
		);
		//46
		final DeclarationSpecifiers DeclarationSpecifiers_47_Var
		 = (DeclarationSpecifiers)Declaration_46_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_47_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_47_list = DeclarationSpecifiers_47_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_47_list);
		Assert.assertEquals(1, DeclarationSpecifier_47_list.size());
		//47
		final TypeSpecifier TypeSpecifier_48_Var
		 = (TypeSpecifier)DeclarationSpecifier_47_list.get(0);
		Assert.assertNotNull(TypeSpecifier_48_Var
		);
		//48
		final TypedefName TypedefName_49_Var
		 = (TypedefName)TypeSpecifier_48_Var
		.getType();
		Assert.assertNotNull(TypedefName_49_Var
		);
		Assert.assertEquals("NUMBER2", TypedefName_49_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_49_list = Declaration_46_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_49_list);
		Assert.assertEquals(1, InitDeclaratorList_49_list.size());
		//49
		final InitDeclaratorList InitDeclaratorList_50_Var
		 = (InitDeclaratorList)InitDeclaratorList_49_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_50_Var
		);
		final EList<? extends EObject> InitDeclarator_50_list = InitDeclaratorList_50_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_50_list);
		Assert.assertEquals(1, InitDeclarator_50_list.size());
		//50
		final InitDeclarator InitDeclarator_51_Var
		 = (InitDeclarator)InitDeclarator_50_list.get(0);
		Assert.assertNotNull(InitDeclarator_51_Var
		);
		//51
		final Declarator Declarator_52_Var
		 = (Declarator)InitDeclarator_51_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_52_Var
		);
		//52
		final DirectDeclarator DirectDeclarator_53_Var
		 = (DirectDeclarator)Declarator_52_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_53_Var
		);
		Assert.assertEquals("d", DirectDeclarator_53_Var
		.getId());
		Assert.assertEquals(";", Declaration_46_Var
		.getSemi());
		//53
		final ExternalDeclaration ExternalDeclaration_54_Var
		 = (ExternalDeclaration)External_1_list.get(6);
		Assert.assertNotNull(ExternalDeclaration_54_Var
		);
		//54
		final Declaration Declaration_55_Var
		 = (Declaration)ExternalDeclaration_54_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_55_Var
		);
		//55
		final DeclarationSpecifiers DeclarationSpecifiers_56_Var
		 = (DeclarationSpecifiers)Declaration_55_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_56_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_56_list = DeclarationSpecifiers_56_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_56_list);
		Assert.assertEquals(1, DeclarationSpecifier_56_list.size());
		//56
		final TypeSpecifier TypeSpecifier_57_Var
		 = (TypeSpecifier)DeclarationSpecifier_56_list.get(0);
		Assert.assertNotNull(TypeSpecifier_57_Var
		);
		//57
		final TypedefName TypedefName_58_Var
		 = (TypedefName)TypeSpecifier_57_Var
		.getType();
		Assert.assertNotNull(TypedefName_58_Var
		);
		Assert.assertEquals("NUMBER1", TypedefName_58_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_58_list = Declaration_55_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_58_list);
		Assert.assertEquals(1, InitDeclaratorList_58_list.size());
		//58
		final InitDeclaratorList InitDeclaratorList_59_Var
		 = (InitDeclaratorList)InitDeclaratorList_58_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_59_Var
		);
		final EList<? extends EObject> InitDeclarator_59_list = InitDeclaratorList_59_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_59_list);
		Assert.assertEquals(1, InitDeclarator_59_list.size());
		//59
		final InitDeclarator InitDeclarator_60_Var
		 = (InitDeclarator)InitDeclarator_59_list.get(0);
		Assert.assertNotNull(InitDeclarator_60_Var
		);
		//60
		final Declarator Declarator_61_Var
		 = (Declarator)InitDeclarator_60_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_61_Var
		);
		//61
		final DirectDeclarator DirectDeclarator_62_Var
		 = (DirectDeclarator)Declarator_61_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_62_Var
		);
		Assert.assertEquals("e", DirectDeclarator_62_Var
		.getId());
		Assert.assertEquals(";", Declaration_55_Var
		.getSemi());
		//62
		final ExternalDeclaration ExternalDeclaration_63_Var
		 = (ExternalDeclaration)External_1_list.get(7);
		Assert.assertNotNull(ExternalDeclaration_63_Var
		);
		//63
		final Declaration Declaration_64_Var
		 = (Declaration)ExternalDeclaration_63_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_64_Var
		);
		//64
		final DeclarationSpecifiers DeclarationSpecifiers_65_Var
		 = (DeclarationSpecifiers)Declaration_64_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_65_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_65_list = DeclarationSpecifiers_65_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_65_list);
		Assert.assertEquals(1, DeclarationSpecifier_65_list.size());
		//65
		final TypeSpecifier TypeSpecifier_66_Var
		 = (TypeSpecifier)DeclarationSpecifier_65_list.get(0);
		Assert.assertNotNull(TypeSpecifier_66_Var
		);
		//66
		final TypedefName TypedefName_67_Var
		 = (TypedefName)TypeSpecifier_66_Var
		.getType();
		Assert.assertNotNull(TypedefName_67_Var
		);
		Assert.assertEquals("NUMBER2", TypedefName_67_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_67_list = Declaration_64_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_67_list);
		Assert.assertEquals(1, InitDeclaratorList_67_list.size());
		//67
		final InitDeclaratorList InitDeclaratorList_68_Var
		 = (InitDeclaratorList)InitDeclaratorList_67_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_68_Var
		);
		final EList<? extends EObject> InitDeclarator_68_list = InitDeclaratorList_68_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_68_list);
		Assert.assertEquals(1, InitDeclarator_68_list.size());
		//68
		final InitDeclarator InitDeclarator_69_Var
		 = (InitDeclarator)InitDeclarator_68_list.get(0);
		Assert.assertNotNull(InitDeclarator_69_Var
		);
		//69
		final Declarator Declarator_70_Var
		 = (Declarator)InitDeclarator_69_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_70_Var
		);
		//70
		final DirectDeclarator DirectDeclarator_71_Var
		 = (DirectDeclarator)Declarator_70_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_71_Var
		);
		Assert.assertEquals("f", DirectDeclarator_71_Var
		.getId());
		Assert.assertEquals(";", Declaration_64_Var
		.getSemi());
		//71
		final ExternalDeclaration ExternalDeclaration_72_Var
		 = (ExternalDeclaration)External_1_list.get(8);
		Assert.assertNotNull(ExternalDeclaration_72_Var
		);
		//72
		final Declaration Declaration_73_Var
		 = (Declaration)ExternalDeclaration_72_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_73_Var
		);
		//73
		final DeclarationSpecifiers DeclarationSpecifiers_74_Var
		 = (DeclarationSpecifiers)Declaration_73_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_74_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_74_list = DeclarationSpecifiers_74_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_74_list);
		Assert.assertEquals(1, DeclarationSpecifier_74_list.size());
		//74
		final TypeSpecifier TypeSpecifier_75_Var
		 = (TypeSpecifier)DeclarationSpecifier_74_list.get(0);
		Assert.assertNotNull(TypeSpecifier_75_Var
		);
		Assert.assertEquals("int", TypeSpecifier_75_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_75_list = Declaration_73_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_75_list);
		Assert.assertEquals(1, InitDeclaratorList_75_list.size());
		//75
		final InitDeclaratorList InitDeclaratorList_76_Var
		 = (InitDeclaratorList)InitDeclaratorList_75_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_76_Var
		);
		final EList<? extends EObject> InitDeclarator_76_list = InitDeclaratorList_76_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_76_list);
		Assert.assertEquals(1, InitDeclarator_76_list.size());
		//76
		final InitDeclarator InitDeclarator_77_Var
		 = (InitDeclarator)InitDeclarator_76_list.get(0);
		Assert.assertNotNull(InitDeclarator_77_Var
		);
		//77
		final Declarator Declarator_78_Var
		 = (Declarator)InitDeclarator_77_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_78_Var
		);
		//78
		final DirectDeclarator DirectDeclarator_79_Var
		 = (DirectDeclarator)Declarator_78_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_79_Var
		);
		Assert.assertEquals("g", DirectDeclarator_79_Var
		.getId());
		Assert.assertEquals(";", Declaration_73_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0003_Typedefs.c");
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
				method.invoke(this.generator, "Test0003_Typedefs.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0003_Typedefs.c");
		final String expected = this.getTextFromFile(
			"res/Test0003_Typedefs.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
		// System.out.println("Code generation finished.");
	}
	
}


