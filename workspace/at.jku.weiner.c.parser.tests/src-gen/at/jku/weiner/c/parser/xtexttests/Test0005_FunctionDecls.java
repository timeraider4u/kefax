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
		Assert.assertEquals(5, External_2_list.size());
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
		Assert.assertEquals("char", TypeSpecifier_6_Var
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
		Assert.assertEquals("do2", DirectDeclarator_10_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_10_list = DirectDeclarator_10_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_10_list);
		Assert.assertEquals(1, DeclaratorSuffix_10_list.size());
		//10
		final DeclaratorSuffix DeclaratorSuffix_11_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_10_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_11_Var
		);
		//11
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_12_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_11_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_12_Var
		);
		Assert.assertEquals(";", Declaration_4_Var
		.getSemi());
		//12
		final ExternalDeclaration ExternalDeclaration_13_Var
		 = (ExternalDeclaration)External_2_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_13_Var
		);
		//13
		final Declaration Declaration_14_Var
		 = (Declaration)ExternalDeclaration_13_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_14_Var
		);
		//14
		final DeclarationSpecifiers DeclarationSpecifiers_15_Var
		 = (DeclarationSpecifiers)Declaration_14_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_15_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_15_list = DeclarationSpecifiers_15_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_15_list);
		Assert.assertEquals(1, DeclarationSpecifier_15_list.size());
		//15
		final TypeSpecifier TypeSpecifier_16_Var
		 = (TypeSpecifier)DeclarationSpecifier_15_list.get(0);
		Assert.assertNotNull(TypeSpecifier_16_Var
		);
		Assert.assertEquals("double", TypeSpecifier_16_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_16_list = Declaration_14_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_16_list);
		Assert.assertEquals(1, InitDeclaratorList_16_list.size());
		//16
		final InitDeclaratorList InitDeclaratorList_17_Var
		 = (InitDeclaratorList)InitDeclaratorList_16_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_17_Var
		);
		final EList<? extends EObject> InitDeclarator_17_list = InitDeclaratorList_17_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_17_list);
		Assert.assertEquals(1, InitDeclarator_17_list.size());
		//17
		final InitDeclarator InitDeclarator_18_Var
		 = (InitDeclarator)InitDeclarator_17_list.get(0);
		Assert.assertNotNull(InitDeclarator_18_Var
		);
		//18
		final Declarator Declarator_19_Var
		 = (Declarator)InitDeclarator_18_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_19_Var
		);
		//19
		final DirectDeclarator DirectDeclarator_20_Var
		 = (DirectDeclarator)Declarator_19_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_20_Var
		);
		Assert.assertEquals("do3", DirectDeclarator_20_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_20_list = DirectDeclarator_20_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_20_list);
		Assert.assertEquals(1, DeclaratorSuffix_20_list.size());
		//20
		final DeclaratorSuffix DeclaratorSuffix_21_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_20_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_21_Var
		);
		//21
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_22_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_21_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_22_Var
		);
		Assert.assertEquals(";", Declaration_14_Var
		.getSemi());
		//22
		final ExternalDeclaration ExternalDeclaration_23_Var
		 = (ExternalDeclaration)External_2_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_23_Var
		);
		//23
		final Declaration Declaration_24_Var
		 = (Declaration)ExternalDeclaration_23_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_24_Var
		);
		//24
		final DeclarationSpecifiers DeclarationSpecifiers_25_Var
		 = (DeclarationSpecifiers)Declaration_24_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_25_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_25_list = DeclarationSpecifiers_25_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_25_list);
		Assert.assertEquals(1, DeclarationSpecifier_25_list.size());
		//25
		final TypeSpecifier TypeSpecifier_26_Var
		 = (TypeSpecifier)DeclarationSpecifier_25_list.get(0);
		Assert.assertNotNull(TypeSpecifier_26_Var
		);
		Assert.assertEquals("float", TypeSpecifier_26_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_26_list = Declaration_24_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_26_list);
		Assert.assertEquals(1, InitDeclaratorList_26_list.size());
		//26
		final InitDeclaratorList InitDeclaratorList_27_Var
		 = (InitDeclaratorList)InitDeclaratorList_26_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_27_Var
		);
		final EList<? extends EObject> InitDeclarator_27_list = InitDeclaratorList_27_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_27_list);
		Assert.assertEquals(1, InitDeclarator_27_list.size());
		//27
		final InitDeclarator InitDeclarator_28_Var
		 = (InitDeclarator)InitDeclarator_27_list.get(0);
		Assert.assertNotNull(InitDeclarator_28_Var
		);
		//28
		final Declarator Declarator_29_Var
		 = (Declarator)InitDeclarator_28_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_29_Var
		);
		//29
		final DirectDeclarator DirectDeclarator_30_Var
		 = (DirectDeclarator)Declarator_29_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_30_Var
		);
		Assert.assertEquals("do4", DirectDeclarator_30_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_30_list = DirectDeclarator_30_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_30_list);
		Assert.assertEquals(1, DeclaratorSuffix_30_list.size());
		//30
		final DeclaratorSuffix DeclaratorSuffix_31_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_30_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_31_Var
		);
		//31
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_32_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_31_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_32_Var
		);
		Assert.assertEquals(";", Declaration_24_Var
		.getSemi());
		//32
		final ExternalDeclaration ExternalDeclaration_33_Var
		 = (ExternalDeclaration)External_2_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_33_Var
		);
		//33
		final Declaration Declaration_34_Var
		 = (Declaration)ExternalDeclaration_33_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_34_Var
		);
		//34
		final DeclarationSpecifiers DeclarationSpecifiers_35_Var
		 = (DeclarationSpecifiers)Declaration_34_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_35_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_35_list = DeclarationSpecifiers_35_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_35_list);
		Assert.assertEquals(1, DeclarationSpecifier_35_list.size());
		//35
		final TypeSpecifier TypeSpecifier_36_Var
		 = (TypeSpecifier)DeclarationSpecifier_35_list.get(0);
		Assert.assertNotNull(TypeSpecifier_36_Var
		);
		Assert.assertEquals("int", TypeSpecifier_36_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_36_list = Declaration_34_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_36_list);
		Assert.assertEquals(1, InitDeclaratorList_36_list.size());
		//36
		final InitDeclaratorList InitDeclaratorList_37_Var
		 = (InitDeclaratorList)InitDeclaratorList_36_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_37_Var
		);
		final EList<? extends EObject> InitDeclarator_37_list = InitDeclaratorList_37_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_37_list);
		Assert.assertEquals(1, InitDeclarator_37_list.size());
		//37
		final InitDeclarator InitDeclarator_38_Var
		 = (InitDeclarator)InitDeclarator_37_list.get(0);
		Assert.assertNotNull(InitDeclarator_38_Var
		);
		//38
		final Declarator Declarator_39_Var
		 = (Declarator)InitDeclarator_38_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_39_Var
		);
		//39
		final DirectDeclarator DirectDeclarator_40_Var
		 = (DirectDeclarator)Declarator_39_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_40_Var
		);
		Assert.assertEquals("do5", DirectDeclarator_40_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_40_list = DirectDeclarator_40_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_40_list);
		Assert.assertEquals(1, DeclaratorSuffix_40_list.size());
		//40
		final DeclaratorSuffix DeclaratorSuffix_41_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_40_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_41_Var
		);
		//41
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_42_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_41_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_42_Var
		);
		Assert.assertEquals(";", Declaration_34_Var
		.getSemi());
		//42
		final ExternalDeclaration ExternalDeclaration_43_Var
		 = (ExternalDeclaration)External_2_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_43_Var
		);
		//43
		final Declaration Declaration_44_Var
		 = (Declaration)ExternalDeclaration_43_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_44_Var
		);
		//44
		final DeclarationSpecifiers DeclarationSpecifiers_45_Var
		 = (DeclarationSpecifiers)Declaration_44_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_45_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_45_list = DeclarationSpecifiers_45_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_45_list);
		Assert.assertEquals(1, DeclarationSpecifier_45_list.size());
		//45
		final TypeSpecifier TypeSpecifier_46_Var
		 = (TypeSpecifier)DeclarationSpecifier_45_list.get(0);
		Assert.assertNotNull(TypeSpecifier_46_Var
		);
		Assert.assertEquals("void", TypeSpecifier_46_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_46_list = Declaration_44_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_46_list);
		Assert.assertEquals(1, InitDeclaratorList_46_list.size());
		//46
		final InitDeclaratorList InitDeclaratorList_47_Var
		 = (InitDeclaratorList)InitDeclaratorList_46_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_47_Var
		);
		final EList<? extends EObject> InitDeclarator_47_list = InitDeclaratorList_47_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_47_list);
		Assert.assertEquals(1, InitDeclarator_47_list.size());
		//47
		final InitDeclarator InitDeclarator_48_Var
		 = (InitDeclarator)InitDeclarator_47_list.get(0);
		Assert.assertNotNull(InitDeclarator_48_Var
		);
		//48
		final Declarator Declarator_49_Var
		 = (Declarator)InitDeclarator_48_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_49_Var
		);
		//49
		final DirectDeclarator DirectDeclarator_50_Var
		 = (DirectDeclarator)Declarator_49_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_50_Var
		);
		Assert.assertEquals("do6", DirectDeclarator_50_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_50_list = DirectDeclarator_50_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_50_list);
		Assert.assertEquals(1, DeclaratorSuffix_50_list.size());
		//50
		final DeclaratorSuffix DeclaratorSuffix_51_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_50_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_51_Var
		);
		//51
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_52_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_51_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_52_Var
		);
		Assert.assertEquals(";", Declaration_44_Var
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


