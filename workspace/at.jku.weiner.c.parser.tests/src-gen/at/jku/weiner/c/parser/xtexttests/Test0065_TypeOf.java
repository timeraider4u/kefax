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
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0065_TypeOf {
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
	
	@Test (timeout=1000)
	public void checkLexerTokens() throws Exception{
		final String text = this.getTextFromFile(
			"res/Test0065_TypeOf.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_KW_TYPEOF1",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_KW_TYPEOF2",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_KW_TYPEOF3",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0065_TypeOf.c");
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
		Assert.assertEquals(4, External_0_list.size());
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
		Assert.assertEquals("i", DirectDeclarator_8_Var
		.getId());
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
		Assert.assertEquals(1, DeclarationSpecifier_11_list.size());
		//11
		final TypeSpecifier TypeSpecifier_12_Var
		 = (TypeSpecifier)DeclarationSpecifier_11_list.get(0);
		Assert.assertNotNull(TypeSpecifier_12_Var
		);
		Assert.assertEquals("typeof", TypeSpecifier_12_Var
		.getTypeOf());
		//12
		final PrimaryExpression PrimaryExpression_13_Var
		 = (PrimaryExpression)TypeSpecifier_12_Var
		.getConstExpr();
		Assert.assertNotNull(PrimaryExpression_13_Var
		);
		Assert.assertEquals("i", PrimaryExpression_13_Var
		.getId());
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
		Assert.assertEquals("j", DirectDeclarator_17_Var
		.getId());
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
		Assert.assertEquals("__typeof", TypeSpecifier_21_Var
		.getTypeOf());
		//21
		final PrimaryExpression PrimaryExpression_22_Var
		 = (PrimaryExpression)TypeSpecifier_21_Var
		.getConstExpr();
		Assert.assertNotNull(PrimaryExpression_22_Var
		);
		Assert.assertEquals("j", PrimaryExpression_22_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_22_list = Declaration_19_Var
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
		Assert.assertEquals("k", DirectDeclarator_26_Var
		.getId());
		//26
		final ExternalDeclaration ExternalDeclaration_27_Var
		 = (ExternalDeclaration)External_0_list.get(3);
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
		Assert.assertEquals("__typeof__", TypeSpecifier_30_Var
		.getTypeOf());
		//30
		final PrimaryExpression PrimaryExpression_31_Var
		 = (PrimaryExpression)TypeSpecifier_30_Var
		.getConstExpr();
		Assert.assertNotNull(PrimaryExpression_31_Var
		);
		Assert.assertEquals("k", PrimaryExpression_31_Var
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
		Assert.assertEquals("m", DirectDeclarator_35_Var
		.getId());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0065_TypeOf.c");
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
				method.invoke(this.generator, "Test0065_TypeOf.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0065_TypeOf.c");
		final String expected = this.getTextFromFile(
			"res/Test0065_TypeOf.c"
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


