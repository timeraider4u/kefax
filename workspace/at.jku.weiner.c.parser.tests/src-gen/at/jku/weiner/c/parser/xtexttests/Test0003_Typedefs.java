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
	private ParseHelper<Parser> parseHelper;
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
		final Parser Parser_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(Parser_0_Var
		);
		
		Assert.assertNotNull(Parser_0_Var
		);
		final EList<? extends EObject> External_0_list = Parser_0_Var
		.getExternal();
		Assert.assertNotNull(External_0_list);
		Assert.assertEquals(9, External_0_list.size());
		//0
		final ExternalDeclaration ExternalDeclaration_1_Var
		 = (ExternalDeclaration)External_0_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_1_Var
		);
		//1
		final Declaration Declaration_2_Var
		 = (Declaration)ExternalDeclaration_1_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_2_Var
		);
		//2
		final DeclarationSpecifiers DeclarationSpecifiers_3_Var
		 = (DeclarationSpecifiers)Declaration_2_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_3_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_3_list = DeclarationSpecifiers_3_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_3_list);
		Assert.assertEquals(1, DeclarationSpecifier_3_list.size());
		//3
		final TypeSpecifier TypeSpecifier_4_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(TypeSpecifier_4_Var
		);
		Assert.assertEquals("int", TypeSpecifier_4_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_4_list = Declaration_2_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_4_list);
		Assert.assertEquals(1, InitDeclaratorList_4_list.size());
		//4
		final InitDeclaratorList InitDeclaratorList_5_Var
		 = (InitDeclaratorList)InitDeclaratorList_4_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_5_Var
		);
		final EList<? extends EObject> InitDeclarator_5_list = InitDeclaratorList_5_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_5_list);
		Assert.assertEquals(1, InitDeclarator_5_list.size());
		//5
		final InitDeclarator InitDeclarator_6_Var
		 = (InitDeclarator)InitDeclarator_5_list.get(0);
		Assert.assertNotNull(InitDeclarator_6_Var
		);
		//6
		final Declarator Declarator_7_Var
		 = (Declarator)InitDeclarator_6_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_7_Var
		);
		//7
		final DirectDeclarator DirectDeclarator_8_Var
		 = (DirectDeclarator)Declarator_7_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_8_Var
		);
		Assert.assertEquals("a", DirectDeclarator_8_Var
		.getId());
		Assert.assertEquals(";", Declaration_2_Var
		.getSemi());
		//8
		final ExternalDeclaration ExternalDeclaration_9_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_9_Var
		);
		//9
		final Declaration Declaration_10_Var
		 = (Declaration)ExternalDeclaration_9_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_10_Var
		);
		//10
		final DeclarationSpecifiers DeclarationSpecifiers_11_Var
		 = (DeclarationSpecifiers)Declaration_10_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_11_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_11_list = DeclarationSpecifiers_11_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_11_list);
		Assert.assertEquals(2, DeclarationSpecifier_11_list.size());
		//11
		final StorageClassSpecifier StorageClassSpecifier_12_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_11_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_12_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_12_Var
		.getName());
		//12
		final TypeSpecifier TypeSpecifier_13_Var
		 = (TypeSpecifier)DeclarationSpecifier_11_list.get(1);
		Assert.assertNotNull(TypeSpecifier_13_Var
		);
		Assert.assertEquals("int", TypeSpecifier_13_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_13_list = Declaration_10_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_13_list);
		Assert.assertEquals(1, InitDeclaratorList_13_list.size());
		//13
		final InitDeclaratorList InitDeclaratorList_14_Var
		 = (InitDeclaratorList)InitDeclaratorList_13_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_14_Var
		);
		final EList<? extends EObject> InitDeclarator_14_list = InitDeclaratorList_14_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_14_list);
		Assert.assertEquals(1, InitDeclarator_14_list.size());
		//14
		final InitDeclarator InitDeclarator_15_Var
		 = (InitDeclarator)InitDeclarator_14_list.get(0);
		Assert.assertNotNull(InitDeclarator_15_Var
		);
		//15
		final Declarator Declarator_16_Var
		 = (Declarator)InitDeclarator_15_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_16_Var
		);
		//16
		final DirectDeclarator DirectDeclarator_17_Var
		 = (DirectDeclarator)Declarator_16_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_17_Var
		);
		Assert.assertEquals("NUMBER1", DirectDeclarator_17_Var
		.getId());
		Assert.assertEquals(";", Declaration_10_Var
		.getSemi());
		//17
		final ExternalDeclaration ExternalDeclaration_18_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_18_Var
		);
		//18
		final Declaration Declaration_19_Var
		 = (Declaration)ExternalDeclaration_18_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_19_Var
		);
		//19
		final DeclarationSpecifiers DeclarationSpecifiers_20_Var
		 = (DeclarationSpecifiers)Declaration_19_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_20_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_20_list = DeclarationSpecifiers_20_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_20_list);
		Assert.assertEquals(1, DeclarationSpecifier_20_list.size());
		//20
		final TypeSpecifier TypeSpecifier_21_Var
		 = (TypeSpecifier)DeclarationSpecifier_20_list.get(0);
		Assert.assertNotNull(TypeSpecifier_21_Var
		);
		Assert.assertEquals("int", TypeSpecifier_21_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_21_list = Declaration_19_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_21_list);
		Assert.assertEquals(1, InitDeclaratorList_21_list.size());
		//21
		final InitDeclaratorList InitDeclaratorList_22_Var
		 = (InitDeclaratorList)InitDeclaratorList_21_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_22_Var
		);
		final EList<? extends EObject> InitDeclarator_22_list = InitDeclaratorList_22_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_22_list);
		Assert.assertEquals(1, InitDeclarator_22_list.size());
		//22
		final InitDeclarator InitDeclarator_23_Var
		 = (InitDeclarator)InitDeclarator_22_list.get(0);
		Assert.assertNotNull(InitDeclarator_23_Var
		);
		//23
		final Declarator Declarator_24_Var
		 = (Declarator)InitDeclarator_23_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_24_Var
		);
		//24
		final DirectDeclarator DirectDeclarator_25_Var
		 = (DirectDeclarator)Declarator_24_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_25_Var
		);
		Assert.assertEquals("b", DirectDeclarator_25_Var
		.getId());
		Assert.assertEquals(";", Declaration_19_Var
		.getSemi());
		//25
		final ExternalDeclaration ExternalDeclaration_26_Var
		 = (ExternalDeclaration)External_0_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_26_Var
		);
		//26
		final Declaration Declaration_27_Var
		 = (Declaration)ExternalDeclaration_26_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_27_Var
		);
		//27
		final DeclarationSpecifiers DeclarationSpecifiers_28_Var
		 = (DeclarationSpecifiers)Declaration_27_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_28_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_28_list = DeclarationSpecifiers_28_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_28_list);
		Assert.assertEquals(1, DeclarationSpecifier_28_list.size());
		//28
		final TypeSpecifier TypeSpecifier_29_Var
		 = (TypeSpecifier)DeclarationSpecifier_28_list.get(0);
		Assert.assertNotNull(TypeSpecifier_29_Var
		);
		//29
		final TypedefName TypedefName_30_Var
		 = (TypedefName)TypeSpecifier_29_Var
		.getType();
		Assert.assertNotNull(TypedefName_30_Var
		);
		Assert.assertEquals("NUMBER1", TypedefName_30_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_30_list = Declaration_27_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_30_list);
		Assert.assertEquals(1, InitDeclaratorList_30_list.size());
		//30
		final InitDeclaratorList InitDeclaratorList_31_Var
		 = (InitDeclaratorList)InitDeclaratorList_30_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_31_Var
		);
		final EList<? extends EObject> InitDeclarator_31_list = InitDeclaratorList_31_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_31_list);
		Assert.assertEquals(1, InitDeclarator_31_list.size());
		//31
		final InitDeclarator InitDeclarator_32_Var
		 = (InitDeclarator)InitDeclarator_31_list.get(0);
		Assert.assertNotNull(InitDeclarator_32_Var
		);
		//32
		final Declarator Declarator_33_Var
		 = (Declarator)InitDeclarator_32_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_33_Var
		);
		//33
		final DirectDeclarator DirectDeclarator_34_Var
		 = (DirectDeclarator)Declarator_33_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_34_Var
		);
		Assert.assertEquals("c", DirectDeclarator_34_Var
		.getId());
		Assert.assertEquals(";", Declaration_27_Var
		.getSemi());
		//34
		final ExternalDeclaration ExternalDeclaration_35_Var
		 = (ExternalDeclaration)External_0_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_35_Var
		);
		//35
		final Declaration Declaration_36_Var
		 = (Declaration)ExternalDeclaration_35_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_36_Var
		);
		//36
		final DeclarationSpecifiers DeclarationSpecifiers_37_Var
		 = (DeclarationSpecifiers)Declaration_36_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_37_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_37_list = DeclarationSpecifiers_37_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_37_list);
		Assert.assertEquals(2, DeclarationSpecifier_37_list.size());
		//37
		final StorageClassSpecifier StorageClassSpecifier_38_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_37_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_38_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_38_Var
		.getName());
		//38
		final TypeSpecifier TypeSpecifier_39_Var
		 = (TypeSpecifier)DeclarationSpecifier_37_list.get(1);
		Assert.assertNotNull(TypeSpecifier_39_Var
		);
		Assert.assertEquals("double", TypeSpecifier_39_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_39_list = Declaration_36_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_39_list);
		Assert.assertEquals(1, InitDeclaratorList_39_list.size());
		//39
		final InitDeclaratorList InitDeclaratorList_40_Var
		 = (InitDeclaratorList)InitDeclaratorList_39_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_40_Var
		);
		final EList<? extends EObject> InitDeclarator_40_list = InitDeclaratorList_40_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_40_list);
		Assert.assertEquals(1, InitDeclarator_40_list.size());
		//40
		final InitDeclarator InitDeclarator_41_Var
		 = (InitDeclarator)InitDeclarator_40_list.get(0);
		Assert.assertNotNull(InitDeclarator_41_Var
		);
		//41
		final Declarator Declarator_42_Var
		 = (Declarator)InitDeclarator_41_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_42_Var
		);
		//42
		final DirectDeclarator DirectDeclarator_43_Var
		 = (DirectDeclarator)Declarator_42_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_43_Var
		);
		Assert.assertEquals("NUMBER2", DirectDeclarator_43_Var
		.getId());
		Assert.assertEquals(";", Declaration_36_Var
		.getSemi());
		//43
		final ExternalDeclaration ExternalDeclaration_44_Var
		 = (ExternalDeclaration)External_0_list.get(5);
		Assert.assertNotNull(ExternalDeclaration_44_Var
		);
		//44
		final Declaration Declaration_45_Var
		 = (Declaration)ExternalDeclaration_44_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_45_Var
		);
		//45
		final DeclarationSpecifiers DeclarationSpecifiers_46_Var
		 = (DeclarationSpecifiers)Declaration_45_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_46_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_46_list = DeclarationSpecifiers_46_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_46_list);
		Assert.assertEquals(1, DeclarationSpecifier_46_list.size());
		//46
		final TypeSpecifier TypeSpecifier_47_Var
		 = (TypeSpecifier)DeclarationSpecifier_46_list.get(0);
		Assert.assertNotNull(TypeSpecifier_47_Var
		);
		//47
		final TypedefName TypedefName_48_Var
		 = (TypedefName)TypeSpecifier_47_Var
		.getType();
		Assert.assertNotNull(TypedefName_48_Var
		);
		Assert.assertEquals("NUMBER2", TypedefName_48_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_48_list = Declaration_45_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_48_list);
		Assert.assertEquals(1, InitDeclaratorList_48_list.size());
		//48
		final InitDeclaratorList InitDeclaratorList_49_Var
		 = (InitDeclaratorList)InitDeclaratorList_48_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_49_Var
		);
		final EList<? extends EObject> InitDeclarator_49_list = InitDeclaratorList_49_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_49_list);
		Assert.assertEquals(1, InitDeclarator_49_list.size());
		//49
		final InitDeclarator InitDeclarator_50_Var
		 = (InitDeclarator)InitDeclarator_49_list.get(0);
		Assert.assertNotNull(InitDeclarator_50_Var
		);
		//50
		final Declarator Declarator_51_Var
		 = (Declarator)InitDeclarator_50_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_51_Var
		);
		//51
		final DirectDeclarator DirectDeclarator_52_Var
		 = (DirectDeclarator)Declarator_51_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_52_Var
		);
		Assert.assertEquals("d", DirectDeclarator_52_Var
		.getId());
		Assert.assertEquals(";", Declaration_45_Var
		.getSemi());
		//52
		final ExternalDeclaration ExternalDeclaration_53_Var
		 = (ExternalDeclaration)External_0_list.get(6);
		Assert.assertNotNull(ExternalDeclaration_53_Var
		);
		//53
		final Declaration Declaration_54_Var
		 = (Declaration)ExternalDeclaration_53_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_54_Var
		);
		//54
		final DeclarationSpecifiers DeclarationSpecifiers_55_Var
		 = (DeclarationSpecifiers)Declaration_54_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_55_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_55_list = DeclarationSpecifiers_55_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_55_list);
		Assert.assertEquals(1, DeclarationSpecifier_55_list.size());
		//55
		final TypeSpecifier TypeSpecifier_56_Var
		 = (TypeSpecifier)DeclarationSpecifier_55_list.get(0);
		Assert.assertNotNull(TypeSpecifier_56_Var
		);
		//56
		final TypedefName TypedefName_57_Var
		 = (TypedefName)TypeSpecifier_56_Var
		.getType();
		Assert.assertNotNull(TypedefName_57_Var
		);
		Assert.assertEquals("NUMBER1", TypedefName_57_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_57_list = Declaration_54_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_57_list);
		Assert.assertEquals(1, InitDeclaratorList_57_list.size());
		//57
		final InitDeclaratorList InitDeclaratorList_58_Var
		 = (InitDeclaratorList)InitDeclaratorList_57_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_58_Var
		);
		final EList<? extends EObject> InitDeclarator_58_list = InitDeclaratorList_58_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_58_list);
		Assert.assertEquals(1, InitDeclarator_58_list.size());
		//58
		final InitDeclarator InitDeclarator_59_Var
		 = (InitDeclarator)InitDeclarator_58_list.get(0);
		Assert.assertNotNull(InitDeclarator_59_Var
		);
		//59
		final Declarator Declarator_60_Var
		 = (Declarator)InitDeclarator_59_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_60_Var
		);
		//60
		final DirectDeclarator DirectDeclarator_61_Var
		 = (DirectDeclarator)Declarator_60_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_61_Var
		);
		Assert.assertEquals("e", DirectDeclarator_61_Var
		.getId());
		Assert.assertEquals(";", Declaration_54_Var
		.getSemi());
		//61
		final ExternalDeclaration ExternalDeclaration_62_Var
		 = (ExternalDeclaration)External_0_list.get(7);
		Assert.assertNotNull(ExternalDeclaration_62_Var
		);
		//62
		final Declaration Declaration_63_Var
		 = (Declaration)ExternalDeclaration_62_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_63_Var
		);
		//63
		final DeclarationSpecifiers DeclarationSpecifiers_64_Var
		 = (DeclarationSpecifiers)Declaration_63_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_64_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_64_list = DeclarationSpecifiers_64_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_64_list);
		Assert.assertEquals(1, DeclarationSpecifier_64_list.size());
		//64
		final TypeSpecifier TypeSpecifier_65_Var
		 = (TypeSpecifier)DeclarationSpecifier_64_list.get(0);
		Assert.assertNotNull(TypeSpecifier_65_Var
		);
		//65
		final TypedefName TypedefName_66_Var
		 = (TypedefName)TypeSpecifier_65_Var
		.getType();
		Assert.assertNotNull(TypedefName_66_Var
		);
		Assert.assertEquals("NUMBER2", TypedefName_66_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_66_list = Declaration_63_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_66_list);
		Assert.assertEquals(1, InitDeclaratorList_66_list.size());
		//66
		final InitDeclaratorList InitDeclaratorList_67_Var
		 = (InitDeclaratorList)InitDeclaratorList_66_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_67_Var
		);
		final EList<? extends EObject> InitDeclarator_67_list = InitDeclaratorList_67_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_67_list);
		Assert.assertEquals(1, InitDeclarator_67_list.size());
		//67
		final InitDeclarator InitDeclarator_68_Var
		 = (InitDeclarator)InitDeclarator_67_list.get(0);
		Assert.assertNotNull(InitDeclarator_68_Var
		);
		//68
		final Declarator Declarator_69_Var
		 = (Declarator)InitDeclarator_68_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_69_Var
		);
		//69
		final DirectDeclarator DirectDeclarator_70_Var
		 = (DirectDeclarator)Declarator_69_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_70_Var
		);
		Assert.assertEquals("f", DirectDeclarator_70_Var
		.getId());
		Assert.assertEquals(";", Declaration_63_Var
		.getSemi());
		//70
		final ExternalDeclaration ExternalDeclaration_71_Var
		 = (ExternalDeclaration)External_0_list.get(8);
		Assert.assertNotNull(ExternalDeclaration_71_Var
		);
		//71
		final Declaration Declaration_72_Var
		 = (Declaration)ExternalDeclaration_71_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_72_Var
		);
		//72
		final DeclarationSpecifiers DeclarationSpecifiers_73_Var
		 = (DeclarationSpecifiers)Declaration_72_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_73_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_73_list = DeclarationSpecifiers_73_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_73_list);
		Assert.assertEquals(1, DeclarationSpecifier_73_list.size());
		//73
		final TypeSpecifier TypeSpecifier_74_Var
		 = (TypeSpecifier)DeclarationSpecifier_73_list.get(0);
		Assert.assertNotNull(TypeSpecifier_74_Var
		);
		Assert.assertEquals("int", TypeSpecifier_74_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_74_list = Declaration_72_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_74_list);
		Assert.assertEquals(1, InitDeclaratorList_74_list.size());
		//74
		final InitDeclaratorList InitDeclaratorList_75_Var
		 = (InitDeclaratorList)InitDeclaratorList_74_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_75_Var
		);
		final EList<? extends EObject> InitDeclarator_75_list = InitDeclaratorList_75_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_75_list);
		Assert.assertEquals(1, InitDeclarator_75_list.size());
		//75
		final InitDeclarator InitDeclarator_76_Var
		 = (InitDeclarator)InitDeclarator_75_list.get(0);
		Assert.assertNotNull(InitDeclarator_76_Var
		);
		//76
		final Declarator Declarator_77_Var
		 = (Declarator)InitDeclarator_76_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_77_Var
		);
		//77
		final DirectDeclarator DirectDeclarator_78_Var
		 = (DirectDeclarator)Declarator_77_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_78_Var
		);
		Assert.assertEquals("g", DirectDeclarator_78_Var
		.getId());
		Assert.assertEquals(";", Declaration_72_Var
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


