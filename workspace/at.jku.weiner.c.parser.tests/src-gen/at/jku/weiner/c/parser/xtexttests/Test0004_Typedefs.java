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
import at.jku.weiner.c.parser.parser.StorageClassSpecifier;
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
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0004_Typedefs {
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
			"res/Test0004_Typedefs.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_TYPEDEF", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_KW_TYPEDEF", 
				"RULE_WHITESPACE", 
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
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0004_Typedefs.c");
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
		Assert.assertEquals(4, External_2_list.size());
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
		Assert.assertEquals(2, DeclarationSpecifier_5_list.size());
		//5
		final StorageClassSpecifier StorageClassSpecifier_6_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_5_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_6_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_6_Var
		.getName());
		//6
		final TypeSpecifier TypeSpecifier_7_Var
		 = (TypeSpecifier)DeclarationSpecifier_5_list.get(1);
		Assert.assertNotNull(TypeSpecifier_7_Var
		);
		Assert.assertEquals("int", TypeSpecifier_7_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_7_list = Declaration_4_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_7_list);
		Assert.assertEquals(1, InitDeclaratorList_7_list.size());
		//7
		final InitDeclaratorList InitDeclaratorList_8_Var
		 = (InitDeclaratorList)InitDeclaratorList_7_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_8_Var
		);
		final EList<? extends EObject> InitDeclarator_8_list = InitDeclaratorList_8_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_8_list);
		Assert.assertEquals(1, InitDeclarator_8_list.size());
		//8
		final InitDeclarator InitDeclarator_9_Var
		 = (InitDeclarator)InitDeclarator_8_list.get(0);
		Assert.assertNotNull(InitDeclarator_9_Var
		);
		//9
		final Declarator Declarator_10_Var
		 = (Declarator)InitDeclarator_9_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_10_Var
		);
		//10
		final DirectDeclarator DirectDeclarator_11_Var
		 = (DirectDeclarator)Declarator_10_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_11_Var
		);
		Assert.assertEquals("NUMBER1", DirectDeclarator_11_Var
		.getId());
		Assert.assertEquals(";", Declaration_4_Var
		.getSemi());
		//11
		final ExternalDeclaration ExternalDeclaration_12_Var
		 = (ExternalDeclaration)External_2_list.get(1);
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
		Assert.assertEquals(2, DeclarationSpecifier_14_list.size());
		//14
		final StorageClassSpecifier StorageClassSpecifier_15_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_14_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_15_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_15_Var
		.getName());
		//15
		final TypeSpecifier TypeSpecifier_16_Var
		 = (TypeSpecifier)DeclarationSpecifier_14_list.get(1);
		Assert.assertNotNull(TypeSpecifier_16_Var
		);
		//16
		final TypedefName TypedefName_17_Var
		 = (TypedefName)TypeSpecifier_16_Var
		.getType();
		Assert.assertNotNull(TypedefName_17_Var
		);
		Assert.assertEquals("NUMBER1", TypedefName_17_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_17_list = Declaration_13_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_17_list);
		Assert.assertEquals(1, InitDeclaratorList_17_list.size());
		//17
		final InitDeclaratorList InitDeclaratorList_18_Var
		 = (InitDeclaratorList)InitDeclaratorList_17_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_18_Var
		);
		final EList<? extends EObject> InitDeclarator_18_list = InitDeclaratorList_18_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_18_list);
		Assert.assertEquals(1, InitDeclarator_18_list.size());
		//18
		final InitDeclarator InitDeclarator_19_Var
		 = (InitDeclarator)InitDeclarator_18_list.get(0);
		Assert.assertNotNull(InitDeclarator_19_Var
		);
		//19
		final Declarator Declarator_20_Var
		 = (Declarator)InitDeclarator_19_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_20_Var
		);
		//20
		final DirectDeclarator DirectDeclarator_21_Var
		 = (DirectDeclarator)Declarator_20_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_21_Var
		);
		Assert.assertEquals("NUMBER2", DirectDeclarator_21_Var
		.getId());
		Assert.assertEquals(";", Declaration_13_Var
		.getSemi());
		//21
		final ExternalDeclaration ExternalDeclaration_22_Var
		 = (ExternalDeclaration)External_2_list.get(2);
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
		//25
		final TypedefName TypedefName_26_Var
		 = (TypedefName)TypeSpecifier_25_Var
		.getType();
		Assert.assertNotNull(TypedefName_26_Var
		);
		Assert.assertEquals("NUMBER1", TypedefName_26_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_26_list = Declaration_23_Var
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
		Assert.assertEquals("a", DirectDeclarator_30_Var
		.getId());
		Assert.assertEquals(";", Declaration_23_Var
		.getSemi());
		//30
		final ExternalDeclaration ExternalDeclaration_31_Var
		 = (ExternalDeclaration)External_2_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_31_Var
		);
		//31
		final Declaration Declaration_32_Var
		 = (Declaration)ExternalDeclaration_31_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_32_Var
		);
		//32
		final DeclarationSpecifiers DeclarationSpecifiers_33_Var
		 = (DeclarationSpecifiers)Declaration_32_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_33_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_33_list = DeclarationSpecifiers_33_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_33_list);
		Assert.assertEquals(1, DeclarationSpecifier_33_list.size());
		//33
		final TypeSpecifier TypeSpecifier_34_Var
		 = (TypeSpecifier)DeclarationSpecifier_33_list.get(0);
		Assert.assertNotNull(TypeSpecifier_34_Var
		);
		//34
		final TypedefName TypedefName_35_Var
		 = (TypedefName)TypeSpecifier_34_Var
		.getType();
		Assert.assertNotNull(TypedefName_35_Var
		);
		Assert.assertEquals("NUMBER2", TypedefName_35_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_35_list = Declaration_32_Var
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
		Assert.assertEquals("b", DirectDeclarator_39_Var
		.getId());
		Assert.assertEquals(";", Declaration_32_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0004_Typedefs.c");
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
				method.invoke(this.generator, "Test0004_Typedefs.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0004_Typedefs.c");
		final String expected = this.getTextFromFile(
			"res/Test0004_Typedefs.c"
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


