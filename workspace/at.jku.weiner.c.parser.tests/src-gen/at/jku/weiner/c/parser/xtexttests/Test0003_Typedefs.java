package at.jku.weiner.c.parser.xtexttests;

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
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import at.jku.weiner.c.parser.tests.ParserInjectorProvider;
import at.jku.weiner.c.parser.parser.antlr.ParserParser;
import at.jku.weiner.c.parser.parser.antlr.internal.InternalParserLexer;
import at.jku.weiner.c.parser.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.parser.parser.Parser;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.StorageClassSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.StorageClassSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0003_Typedefs {
	@Inject
	private ParseHelper<Model> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalParserLexer lexer;
	@Inject
	private ParserParser parser;
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
	@Inject
	private IResourceFactory resourceFactory;
	
	@Before
	public void initialize(){
		this.testHelper = new LexerAndParserTest(lexer, 
			parser, tokenDefProvider);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("c",
						this.resourceFactory);
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
			"res/Test0003_Typedefs.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_KW_TYPEDEF", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_KW_TYPEDEF", 
				"RULE_WHITESPACE", 
				"RULE_KW_DOUBLE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
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
		final EList<? extends EObject> Units_0_list = Model_0_Var
		.getUnits();
		Assert.assertNotNull(Units_0_list);
		Assert.assertEquals(1, Units_0_list.size());
		//0
		final TranslationUnit TranslationUnit_1_Var
		 = (TranslationUnit)Units_0_list.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var
		);
		//1
		final Parser Parser_2_Var
		 = (Parser)TranslationUnit_1_Var
		.getParser();
		Assert.assertNotNull(Parser_2_Var
		);
		final EList<? extends EObject> External_2_list = Parser_2_Var
		.getExternal();
		Assert.assertNotNull(External_2_list);
		Assert.assertEquals(9, External_2_list.size());
		//2
		final ExternalDeclaration ExternalDeclaration_3_Var
		 = (ExternalDeclaration)External_2_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_3_Var
		);
		//3
		final Declaration Declaration_4_Var
		 = (Declaration)ExternalDeclaration_3_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_4_Var
		);
		//4
		final DeclarationSpecifiers DeclarationSpecifiers_5_Var
		 = (DeclarationSpecifiers)Declaration_4_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_5_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_5_list = DeclarationSpecifiers_5_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_5_list);
		Assert.assertEquals(1, DeclarationSpecifier_5_list.size());
		//5
		final TypeSpecifier TypeSpecifier_6_Var
		 = (TypeSpecifier)DeclarationSpecifier_5_list.get(0);
		Assert.assertNotNull(TypeSpecifier_6_Var
		);
		Assert.assertEquals("int", TypeSpecifier_6_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_6_list = Declaration_4_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_6_list);
		Assert.assertEquals(1, InitDeclaratorList_6_list.size());
		//6
		final InitDeclaratorList InitDeclaratorList_7_Var
		 = (InitDeclaratorList)InitDeclaratorList_6_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_7_Var
		);
		final EList<? extends EObject> InitDeclarator_7_list = InitDeclaratorList_7_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_7_list);
		Assert.assertEquals(1, InitDeclarator_7_list.size());
		//7
		final InitDeclarator InitDeclarator_8_Var
		 = (InitDeclarator)InitDeclarator_7_list.get(0);
		Assert.assertNotNull(InitDeclarator_8_Var
		);
		//8
		final Declarator Declarator_9_Var
		 = (Declarator)InitDeclarator_8_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_9_Var
		);
		//9
		final DirectDeclarator DirectDeclarator_10_Var
		 = (DirectDeclarator)Declarator_9_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_10_Var
		);
		Assert.assertEquals("a", DirectDeclarator_10_Var
		.getId());
		Assert.assertEquals(";", Declaration_4_Var
		.getSemi());
		//10
		final ExternalDeclaration ExternalDeclaration_11_Var
		 = (ExternalDeclaration)External_2_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_11_Var
		);
		//11
		final Declaration Declaration_12_Var
		 = (Declaration)ExternalDeclaration_11_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_12_Var
		);
		//12
		final DeclarationSpecifiers DeclarationSpecifiers_13_Var
		 = (DeclarationSpecifiers)Declaration_12_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_13_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_13_list = DeclarationSpecifiers_13_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_13_list);
		Assert.assertEquals(2, DeclarationSpecifier_13_list.size());
		//13
		final StorageClassSpecifier StorageClassSpecifier_14_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_13_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_14_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_14_Var
		.getName());
		//14
		final TypeSpecifier TypeSpecifier_15_Var
		 = (TypeSpecifier)DeclarationSpecifier_13_list.get(1);
		Assert.assertNotNull(TypeSpecifier_15_Var
		);
		Assert.assertEquals("int", TypeSpecifier_15_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_15_list = Declaration_12_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_15_list);
		Assert.assertEquals(1, InitDeclaratorList_15_list.size());
		//15
		final InitDeclaratorList InitDeclaratorList_16_Var
		 = (InitDeclaratorList)InitDeclaratorList_15_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_16_Var
		);
		final EList<? extends EObject> InitDeclarator_16_list = InitDeclaratorList_16_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_16_list);
		Assert.assertEquals(1, InitDeclarator_16_list.size());
		//16
		final InitDeclarator InitDeclarator_17_Var
		 = (InitDeclarator)InitDeclarator_16_list.get(0);
		Assert.assertNotNull(InitDeclarator_17_Var
		);
		//17
		final Declarator Declarator_18_Var
		 = (Declarator)InitDeclarator_17_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_18_Var
		);
		//18
		final DirectDeclarator DirectDeclarator_19_Var
		 = (DirectDeclarator)Declarator_18_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_19_Var
		);
		Assert.assertEquals("NUMBER1", DirectDeclarator_19_Var
		.getId());
		Assert.assertEquals(";", Declaration_12_Var
		.getSemi());
		//19
		final ExternalDeclaration ExternalDeclaration_20_Var
		 = (ExternalDeclaration)External_2_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_20_Var
		);
		//20
		final Declaration Declaration_21_Var
		 = (Declaration)ExternalDeclaration_20_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_21_Var
		);
		//21
		final DeclarationSpecifiers DeclarationSpecifiers_22_Var
		 = (DeclarationSpecifiers)Declaration_21_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_22_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_22_list = DeclarationSpecifiers_22_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_22_list);
		Assert.assertEquals(1, DeclarationSpecifier_22_list.size());
		//22
		final TypeSpecifier TypeSpecifier_23_Var
		 = (TypeSpecifier)DeclarationSpecifier_22_list.get(0);
		Assert.assertNotNull(TypeSpecifier_23_Var
		);
		Assert.assertEquals("int", TypeSpecifier_23_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_23_list = Declaration_21_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_23_list);
		Assert.assertEquals(1, InitDeclaratorList_23_list.size());
		//23
		final InitDeclaratorList InitDeclaratorList_24_Var
		 = (InitDeclaratorList)InitDeclaratorList_23_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_24_Var
		);
		final EList<? extends EObject> InitDeclarator_24_list = InitDeclaratorList_24_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_24_list);
		Assert.assertEquals(1, InitDeclarator_24_list.size());
		//24
		final InitDeclarator InitDeclarator_25_Var
		 = (InitDeclarator)InitDeclarator_24_list.get(0);
		Assert.assertNotNull(InitDeclarator_25_Var
		);
		//25
		final Declarator Declarator_26_Var
		 = (Declarator)InitDeclarator_25_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_26_Var
		);
		//26
		final DirectDeclarator DirectDeclarator_27_Var
		 = (DirectDeclarator)Declarator_26_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_27_Var
		);
		Assert.assertEquals("b", DirectDeclarator_27_Var
		.getId());
		Assert.assertEquals(";", Declaration_21_Var
		.getSemi());
		//27
		final ExternalDeclaration ExternalDeclaration_28_Var
		 = (ExternalDeclaration)External_2_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_28_Var
		);
		//28
		final Declaration Declaration_29_Var
		 = (Declaration)ExternalDeclaration_28_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_29_Var
		);
		//29
		final DeclarationSpecifiers DeclarationSpecifiers_30_Var
		 = (DeclarationSpecifiers)Declaration_29_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_30_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_30_list = DeclarationSpecifiers_30_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_30_list);
		Assert.assertEquals(1, DeclarationSpecifier_30_list.size());
		//30
		final TypeSpecifier TypeSpecifier_31_Var
		 = (TypeSpecifier)DeclarationSpecifier_30_list.get(0);
		Assert.assertNotNull(TypeSpecifier_31_Var
		);
		//31
		final TypedefName TypedefName_32_Var
		 = (TypedefName)TypeSpecifier_31_Var
		.getType();
		Assert.assertNotNull(TypedefName_32_Var
		);
		Assert.assertEquals("NUMBER1", TypedefName_32_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_32_list = Declaration_29_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_32_list);
		Assert.assertEquals(1, InitDeclaratorList_32_list.size());
		//32
		final InitDeclaratorList InitDeclaratorList_33_Var
		 = (InitDeclaratorList)InitDeclaratorList_32_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_33_Var
		);
		final EList<? extends EObject> InitDeclarator_33_list = InitDeclaratorList_33_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_33_list);
		Assert.assertEquals(1, InitDeclarator_33_list.size());
		//33
		final InitDeclarator InitDeclarator_34_Var
		 = (InitDeclarator)InitDeclarator_33_list.get(0);
		Assert.assertNotNull(InitDeclarator_34_Var
		);
		//34
		final Declarator Declarator_35_Var
		 = (Declarator)InitDeclarator_34_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_35_Var
		);
		//35
		final DirectDeclarator DirectDeclarator_36_Var
		 = (DirectDeclarator)Declarator_35_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_36_Var
		);
		Assert.assertEquals("c", DirectDeclarator_36_Var
		.getId());
		Assert.assertEquals(";", Declaration_29_Var
		.getSemi());
		//36
		final ExternalDeclaration ExternalDeclaration_37_Var
		 = (ExternalDeclaration)External_2_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_37_Var
		);
		//37
		final Declaration Declaration_38_Var
		 = (Declaration)ExternalDeclaration_37_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_38_Var
		);
		//38
		final DeclarationSpecifiers DeclarationSpecifiers_39_Var
		 = (DeclarationSpecifiers)Declaration_38_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_39_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_39_list = DeclarationSpecifiers_39_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_39_list);
		Assert.assertEquals(2, DeclarationSpecifier_39_list.size());
		//39
		final StorageClassSpecifier StorageClassSpecifier_40_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_39_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_40_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_40_Var
		.getName());
		//40
		final TypeSpecifier TypeSpecifier_41_Var
		 = (TypeSpecifier)DeclarationSpecifier_39_list.get(1);
		Assert.assertNotNull(TypeSpecifier_41_Var
		);
		Assert.assertEquals("double", TypeSpecifier_41_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_41_list = Declaration_38_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_41_list);
		Assert.assertEquals(1, InitDeclaratorList_41_list.size());
		//41
		final InitDeclaratorList InitDeclaratorList_42_Var
		 = (InitDeclaratorList)InitDeclaratorList_41_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_42_Var
		);
		final EList<? extends EObject> InitDeclarator_42_list = InitDeclaratorList_42_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_42_list);
		Assert.assertEquals(1, InitDeclarator_42_list.size());
		//42
		final InitDeclarator InitDeclarator_43_Var
		 = (InitDeclarator)InitDeclarator_42_list.get(0);
		Assert.assertNotNull(InitDeclarator_43_Var
		);
		//43
		final Declarator Declarator_44_Var
		 = (Declarator)InitDeclarator_43_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_44_Var
		);
		//44
		final DirectDeclarator DirectDeclarator_45_Var
		 = (DirectDeclarator)Declarator_44_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_45_Var
		);
		Assert.assertEquals("NUMBER2", DirectDeclarator_45_Var
		.getId());
		Assert.assertEquals(";", Declaration_38_Var
		.getSemi());
		//45
		final ExternalDeclaration ExternalDeclaration_46_Var
		 = (ExternalDeclaration)External_2_list.get(5);
		Assert.assertNotNull(ExternalDeclaration_46_Var
		);
		//46
		final Declaration Declaration_47_Var
		 = (Declaration)ExternalDeclaration_46_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_47_Var
		);
		//47
		final DeclarationSpecifiers DeclarationSpecifiers_48_Var
		 = (DeclarationSpecifiers)Declaration_47_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_48_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_48_list = DeclarationSpecifiers_48_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_48_list);
		Assert.assertEquals(1, DeclarationSpecifier_48_list.size());
		//48
		final TypeSpecifier TypeSpecifier_49_Var
		 = (TypeSpecifier)DeclarationSpecifier_48_list.get(0);
		Assert.assertNotNull(TypeSpecifier_49_Var
		);
		//49
		final TypedefName TypedefName_50_Var
		 = (TypedefName)TypeSpecifier_49_Var
		.getType();
		Assert.assertNotNull(TypedefName_50_Var
		);
		Assert.assertEquals("NUMBER2", TypedefName_50_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_50_list = Declaration_47_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_50_list);
		Assert.assertEquals(1, InitDeclaratorList_50_list.size());
		//50
		final InitDeclaratorList InitDeclaratorList_51_Var
		 = (InitDeclaratorList)InitDeclaratorList_50_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_51_Var
		);
		final EList<? extends EObject> InitDeclarator_51_list = InitDeclaratorList_51_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_51_list);
		Assert.assertEquals(1, InitDeclarator_51_list.size());
		//51
		final InitDeclarator InitDeclarator_52_Var
		 = (InitDeclarator)InitDeclarator_51_list.get(0);
		Assert.assertNotNull(InitDeclarator_52_Var
		);
		//52
		final Declarator Declarator_53_Var
		 = (Declarator)InitDeclarator_52_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_53_Var
		);
		//53
		final DirectDeclarator DirectDeclarator_54_Var
		 = (DirectDeclarator)Declarator_53_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_54_Var
		);
		Assert.assertEquals("d", DirectDeclarator_54_Var
		.getId());
		Assert.assertEquals(";", Declaration_47_Var
		.getSemi());
		//54
		final ExternalDeclaration ExternalDeclaration_55_Var
		 = (ExternalDeclaration)External_2_list.get(6);
		Assert.assertNotNull(ExternalDeclaration_55_Var
		);
		//55
		final Declaration Declaration_56_Var
		 = (Declaration)ExternalDeclaration_55_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_56_Var
		);
		//56
		final DeclarationSpecifiers DeclarationSpecifiers_57_Var
		 = (DeclarationSpecifiers)Declaration_56_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_57_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_57_list = DeclarationSpecifiers_57_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_57_list);
		Assert.assertEquals(1, DeclarationSpecifier_57_list.size());
		//57
		final TypeSpecifier TypeSpecifier_58_Var
		 = (TypeSpecifier)DeclarationSpecifier_57_list.get(0);
		Assert.assertNotNull(TypeSpecifier_58_Var
		);
		//58
		final TypedefName TypedefName_59_Var
		 = (TypedefName)TypeSpecifier_58_Var
		.getType();
		Assert.assertNotNull(TypedefName_59_Var
		);
		Assert.assertEquals("NUMBER1", TypedefName_59_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_59_list = Declaration_56_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_59_list);
		Assert.assertEquals(1, InitDeclaratorList_59_list.size());
		//59
		final InitDeclaratorList InitDeclaratorList_60_Var
		 = (InitDeclaratorList)InitDeclaratorList_59_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_60_Var
		);
		final EList<? extends EObject> InitDeclarator_60_list = InitDeclaratorList_60_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_60_list);
		Assert.assertEquals(1, InitDeclarator_60_list.size());
		//60
		final InitDeclarator InitDeclarator_61_Var
		 = (InitDeclarator)InitDeclarator_60_list.get(0);
		Assert.assertNotNull(InitDeclarator_61_Var
		);
		//61
		final Declarator Declarator_62_Var
		 = (Declarator)InitDeclarator_61_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_62_Var
		);
		//62
		final DirectDeclarator DirectDeclarator_63_Var
		 = (DirectDeclarator)Declarator_62_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_63_Var
		);
		Assert.assertEquals("e", DirectDeclarator_63_Var
		.getId());
		Assert.assertEquals(";", Declaration_56_Var
		.getSemi());
		//63
		final ExternalDeclaration ExternalDeclaration_64_Var
		 = (ExternalDeclaration)External_2_list.get(7);
		Assert.assertNotNull(ExternalDeclaration_64_Var
		);
		//64
		final Declaration Declaration_65_Var
		 = (Declaration)ExternalDeclaration_64_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_65_Var
		);
		//65
		final DeclarationSpecifiers DeclarationSpecifiers_66_Var
		 = (DeclarationSpecifiers)Declaration_65_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_66_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_66_list = DeclarationSpecifiers_66_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_66_list);
		Assert.assertEquals(1, DeclarationSpecifier_66_list.size());
		//66
		final TypeSpecifier TypeSpecifier_67_Var
		 = (TypeSpecifier)DeclarationSpecifier_66_list.get(0);
		Assert.assertNotNull(TypeSpecifier_67_Var
		);
		//67
		final TypedefName TypedefName_68_Var
		 = (TypedefName)TypeSpecifier_67_Var
		.getType();
		Assert.assertNotNull(TypedefName_68_Var
		);
		Assert.assertEquals("NUMBER2", TypedefName_68_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_68_list = Declaration_65_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_68_list);
		Assert.assertEquals(1, InitDeclaratorList_68_list.size());
		//68
		final InitDeclaratorList InitDeclaratorList_69_Var
		 = (InitDeclaratorList)InitDeclaratorList_68_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_69_Var
		);
		final EList<? extends EObject> InitDeclarator_69_list = InitDeclaratorList_69_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_69_list);
		Assert.assertEquals(1, InitDeclarator_69_list.size());
		//69
		final InitDeclarator InitDeclarator_70_Var
		 = (InitDeclarator)InitDeclarator_69_list.get(0);
		Assert.assertNotNull(InitDeclarator_70_Var
		);
		//70
		final Declarator Declarator_71_Var
		 = (Declarator)InitDeclarator_70_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_71_Var
		);
		//71
		final DirectDeclarator DirectDeclarator_72_Var
		 = (DirectDeclarator)Declarator_71_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_72_Var
		);
		Assert.assertEquals("f", DirectDeclarator_72_Var
		.getId());
		Assert.assertEquals(";", Declaration_65_Var
		.getSemi());
		//72
		final ExternalDeclaration ExternalDeclaration_73_Var
		 = (ExternalDeclaration)External_2_list.get(8);
		Assert.assertNotNull(ExternalDeclaration_73_Var
		);
		//73
		final Declaration Declaration_74_Var
		 = (Declaration)ExternalDeclaration_73_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_74_Var
		);
		//74
		final DeclarationSpecifiers DeclarationSpecifiers_75_Var
		 = (DeclarationSpecifiers)Declaration_74_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_75_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_75_list = DeclarationSpecifiers_75_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_75_list);
		Assert.assertEquals(1, DeclarationSpecifier_75_list.size());
		//75
		final TypeSpecifier TypeSpecifier_76_Var
		 = (TypeSpecifier)DeclarationSpecifier_75_list.get(0);
		Assert.assertNotNull(TypeSpecifier_76_Var
		);
		Assert.assertEquals("int", TypeSpecifier_76_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_76_list = Declaration_74_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_76_list);
		Assert.assertEquals(1, InitDeclaratorList_76_list.size());
		//76
		final InitDeclaratorList InitDeclaratorList_77_Var
		 = (InitDeclaratorList)InitDeclaratorList_76_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_77_Var
		);
		final EList<? extends EObject> InitDeclarator_77_list = InitDeclaratorList_77_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_77_list);
		Assert.assertEquals(1, InitDeclarator_77_list.size());
		//77
		final InitDeclarator InitDeclarator_78_Var
		 = (InitDeclarator)InitDeclarator_77_list.get(0);
		Assert.assertNotNull(InitDeclarator_78_Var
		);
		//78
		final Declarator Declarator_79_Var
		 = (Declarator)InitDeclarator_78_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_79_Var
		);
		//79
		final DirectDeclarator DirectDeclarator_80_Var
		 = (DirectDeclarator)Declarator_79_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_80_Var
		);
		Assert.assertEquals("g", DirectDeclarator_80_Var
		.getId());
		Assert.assertEquals(";", Declaration_74_Var
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


