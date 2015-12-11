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

import at.jku.weiner.c.parser.parser.Model;
import at.jku.weiner.c.parser.parser.TranslationUnit;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0005_FunctionDecls {
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
			"res/Test0005_FunctionDecls.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_CHAR", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_KW_DOUBLE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_KW_FLOAT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_KW_VOID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
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
			"res/Test0005_FunctionDecls.c");
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
		Assert.assertEquals(5, External_1_list.size());
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
		Assert.assertEquals("char", TypeSpecifier_5_Var
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
		Assert.assertEquals("do2", DirectDeclarator_9_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_9_list = DirectDeclarator_9_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_9_list);
		Assert.assertEquals(1, DeclaratorSuffix_9_list.size());
		//9
		final DeclaratorSuffix DeclaratorSuffix_10_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_9_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_10_Var
		);
		//10
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_11_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_10_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_11_Var
		);
		Assert.assertEquals(";", Declaration_3_Var
		.getSemi());
		//11
		final ExternalDeclaration ExternalDeclaration_12_Var
		 = (ExternalDeclaration)External_1_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_12_Var
		);
		//12
		final Declaration Declaration_13_Var
		 = (Declaration)ExternalDeclaration_12_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_13_Var
		);
		//13
		final DeclarationSpecifiers DeclarationSpecifiers_14_Var
		 = (DeclarationSpecifiers)Declaration_13_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_14_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_14_list = DeclarationSpecifiers_14_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_14_list);
		Assert.assertEquals(1, DeclarationSpecifier_14_list.size());
		//14
		final TypeSpecifier TypeSpecifier_15_Var
		 = (TypeSpecifier)DeclarationSpecifier_14_list.get(0);
		Assert.assertNotNull(TypeSpecifier_15_Var
		);
		Assert.assertEquals("double", TypeSpecifier_15_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_15_list = Declaration_13_Var
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
		Assert.assertEquals("do3", DirectDeclarator_19_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_19_list = DirectDeclarator_19_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_19_list);
		Assert.assertEquals(1, DeclaratorSuffix_19_list.size());
		//19
		final DeclaratorSuffix DeclaratorSuffix_20_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_19_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_20_Var
		);
		//20
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_21_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_20_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_21_Var
		);
		Assert.assertEquals(";", Declaration_13_Var
		.getSemi());
		//21
		final ExternalDeclaration ExternalDeclaration_22_Var
		 = (ExternalDeclaration)External_1_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_22_Var
		);
		//22
		final Declaration Declaration_23_Var
		 = (Declaration)ExternalDeclaration_22_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_23_Var
		);
		//23
		final DeclarationSpecifiers DeclarationSpecifiers_24_Var
		 = (DeclarationSpecifiers)Declaration_23_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_24_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_24_list = DeclarationSpecifiers_24_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_24_list);
		Assert.assertEquals(1, DeclarationSpecifier_24_list.size());
		//24
		final TypeSpecifier TypeSpecifier_25_Var
		 = (TypeSpecifier)DeclarationSpecifier_24_list.get(0);
		Assert.assertNotNull(TypeSpecifier_25_Var
		);
		Assert.assertEquals("float", TypeSpecifier_25_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_25_list = Declaration_23_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_25_list);
		Assert.assertEquals(1, InitDeclaratorList_25_list.size());
		//25
		final InitDeclaratorList InitDeclaratorList_26_Var
		 = (InitDeclaratorList)InitDeclaratorList_25_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_26_Var
		);
		final EList<? extends EObject> InitDeclarator_26_list = InitDeclaratorList_26_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_26_list);
		Assert.assertEquals(1, InitDeclarator_26_list.size());
		//26
		final InitDeclarator InitDeclarator_27_Var
		 = (InitDeclarator)InitDeclarator_26_list.get(0);
		Assert.assertNotNull(InitDeclarator_27_Var
		);
		//27
		final Declarator Declarator_28_Var
		 = (Declarator)InitDeclarator_27_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_28_Var
		);
		//28
		final DirectDeclarator DirectDeclarator_29_Var
		 = (DirectDeclarator)Declarator_28_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_29_Var
		);
		Assert.assertEquals("do4", DirectDeclarator_29_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_29_list = DirectDeclarator_29_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_29_list);
		Assert.assertEquals(1, DeclaratorSuffix_29_list.size());
		//29
		final DeclaratorSuffix DeclaratorSuffix_30_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_29_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_30_Var
		);
		//30
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_31_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_30_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_31_Var
		);
		Assert.assertEquals(";", Declaration_23_Var
		.getSemi());
		//31
		final ExternalDeclaration ExternalDeclaration_32_Var
		 = (ExternalDeclaration)External_1_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_32_Var
		);
		//32
		final Declaration Declaration_33_Var
		 = (Declaration)ExternalDeclaration_32_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_33_Var
		);
		//33
		final DeclarationSpecifiers DeclarationSpecifiers_34_Var
		 = (DeclarationSpecifiers)Declaration_33_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_34_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_34_list = DeclarationSpecifiers_34_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_34_list);
		Assert.assertEquals(1, DeclarationSpecifier_34_list.size());
		//34
		final TypeSpecifier TypeSpecifier_35_Var
		 = (TypeSpecifier)DeclarationSpecifier_34_list.get(0);
		Assert.assertNotNull(TypeSpecifier_35_Var
		);
		Assert.assertEquals("int", TypeSpecifier_35_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_35_list = Declaration_33_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_35_list);
		Assert.assertEquals(1, InitDeclaratorList_35_list.size());
		//35
		final InitDeclaratorList InitDeclaratorList_36_Var
		 = (InitDeclaratorList)InitDeclaratorList_35_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_36_Var
		);
		final EList<? extends EObject> InitDeclarator_36_list = InitDeclaratorList_36_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_36_list);
		Assert.assertEquals(1, InitDeclarator_36_list.size());
		//36
		final InitDeclarator InitDeclarator_37_Var
		 = (InitDeclarator)InitDeclarator_36_list.get(0);
		Assert.assertNotNull(InitDeclarator_37_Var
		);
		//37
		final Declarator Declarator_38_Var
		 = (Declarator)InitDeclarator_37_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_38_Var
		);
		//38
		final DirectDeclarator DirectDeclarator_39_Var
		 = (DirectDeclarator)Declarator_38_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_39_Var
		);
		Assert.assertEquals("do5", DirectDeclarator_39_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_39_list = DirectDeclarator_39_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_39_list);
		Assert.assertEquals(1, DeclaratorSuffix_39_list.size());
		//39
		final DeclaratorSuffix DeclaratorSuffix_40_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_39_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_40_Var
		);
		//40
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_41_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_40_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_41_Var
		);
		Assert.assertEquals(";", Declaration_33_Var
		.getSemi());
		//41
		final ExternalDeclaration ExternalDeclaration_42_Var
		 = (ExternalDeclaration)External_1_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_42_Var
		);
		//42
		final Declaration Declaration_43_Var
		 = (Declaration)ExternalDeclaration_42_Var
		.getDeclaration();
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
		Assert.assertEquals("void", TypeSpecifier_45_Var
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
		Assert.assertEquals("do6", DirectDeclarator_49_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_49_list = DirectDeclarator_49_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_49_list);
		Assert.assertEquals(1, DeclaratorSuffix_49_list.size());
		//49
		final DeclaratorSuffix DeclaratorSuffix_50_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_49_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_50_Var
		);
		//50
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_51_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_50_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_51_Var
		);
		Assert.assertEquals(";", Declaration_43_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0005_FunctionDecls.c");
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
				method.invoke(this.generator, "Test0005_FunctionDecls.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0005_FunctionDecls.c");
		final String expected = this.getTextFromFile(
			"res/Test0005_FunctionDecls.c"
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


