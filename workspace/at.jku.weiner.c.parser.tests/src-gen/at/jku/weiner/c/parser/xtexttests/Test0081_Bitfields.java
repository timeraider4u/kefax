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
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.StructDeclarationList;
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0081_Bitfields {
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
			"res/Test0081_Bitfields.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_STRUCT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
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
			"res/Test0081_Bitfields.c");
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
		Assert.assertEquals(1, External_0_list.size());
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
		//4
		final StructOrUnionSpecifier StructOrUnionSpecifier_5_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_4_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_5_Var
		);
		//5
		final StructOrUnion StructOrUnion_6_Var
		 = (StructOrUnion)StructOrUnionSpecifier_5_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_6_Var
		);
		Assert.assertEquals("struct", StructOrUnion_6_Var
		.getName());
		Assert.assertEquals("foo", StructOrUnionSpecifier_5_Var
		.getId());
		//6
		final StructDeclarationList StructDeclarationList_7_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_5_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_7_Var
		);
		final EList<? extends EObject> StructDeclaration_7_list = StructDeclarationList_7_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_7_list);
		Assert.assertEquals(4, StructDeclaration_7_list.size());
		//7
		final StructDeclaration StructDeclaration_8_Var
		 = (StructDeclaration)StructDeclaration_7_list.get(0);
		Assert.assertNotNull(StructDeclaration_8_Var
		);
		//8
		final SpecifierQualifierList SpecifierQualifierList_9_Var
		 = (SpecifierQualifierList)StructDeclaration_8_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_9_Var
		);
		final EList<? extends EObject> TypeSpecifier_9_list = SpecifierQualifierList_9_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_9_list);
		Assert.assertEquals(1, TypeSpecifier_9_list.size());
		//9
		final TypeSpecifier TypeSpecifier_10_Var
		 = (TypeSpecifier)TypeSpecifier_9_list.get(0);
		Assert.assertNotNull(TypeSpecifier_10_Var
		);
		Assert.assertEquals("int", TypeSpecifier_10_Var
		.getName());
		//10
		final StructDeclaratorList StructDeclaratorList_11_Var
		 = (StructDeclaratorList)StructDeclaration_8_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_11_Var
		);
		final EList<? extends EObject> StructDeclarator_11_list = StructDeclaratorList_11_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_11_list);
		Assert.assertEquals(1, StructDeclarator_11_list.size());
		//11
		final StructDeclarator StructDeclarator_12_Var
		 = (StructDeclarator)StructDeclarator_11_list.get(0);
		Assert.assertNotNull(StructDeclarator_12_Var
		);
		//12
		final Declarator Declarator_13_Var
		 = (Declarator)StructDeclarator_12_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_13_Var
		);
		//13
		final DirectDeclarator DirectDeclarator_14_Var
		 = (DirectDeclarator)Declarator_13_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_14_Var
		);
		Assert.assertEquals("i", DirectDeclarator_14_Var
		.getId());
		final EList<? extends EObject> ConstExpr_14_list = StructDeclarator_12_Var
		.getConstExpr();
		Assert.assertNotNull(ConstExpr_14_list);
		Assert.assertEquals(1, ConstExpr_14_list.size());
		//14
		final PrimaryExpression PrimaryExpression_15_Var
		 = (PrimaryExpression)ConstExpr_14_list.get(0);
		Assert.assertNotNull(PrimaryExpression_15_Var
		);
		//15
		final Constant2 Constant2_16_Var
		 = (Constant2)PrimaryExpression_15_Var
		.getConst();
		Assert.assertNotNull(Constant2_16_Var
		);
		Assert.assertEquals("3", Constant2_16_Var
		.getDec());
		//16
		final StructDeclaration StructDeclaration_17_Var
		 = (StructDeclaration)StructDeclaration_7_list.get(1);
		Assert.assertNotNull(StructDeclaration_17_Var
		);
		//17
		final SpecifierQualifierList SpecifierQualifierList_18_Var
		 = (SpecifierQualifierList)StructDeclaration_17_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_18_Var
		);
		final EList<? extends EObject> TypeSpecifier_18_list = SpecifierQualifierList_18_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_18_list);
		Assert.assertEquals(1, TypeSpecifier_18_list.size());
		//18
		final TypeSpecifier TypeSpecifier_19_Var
		 = (TypeSpecifier)TypeSpecifier_18_list.get(0);
		Assert.assertNotNull(TypeSpecifier_19_Var
		);
		Assert.assertEquals("int", TypeSpecifier_19_Var
		.getName());
		//19
		final StructDeclaratorList StructDeclaratorList_20_Var
		 = (StructDeclaratorList)StructDeclaration_17_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_20_Var
		);
		final EList<? extends EObject> StructDeclarator_20_list = StructDeclaratorList_20_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_20_list);
		Assert.assertEquals(1, StructDeclarator_20_list.size());
		//20
		final StructDeclarator StructDeclarator_21_Var
		 = (StructDeclarator)StructDeclarator_20_list.get(0);
		Assert.assertNotNull(StructDeclarator_21_Var
		);
		//21
		final Declarator Declarator_22_Var
		 = (Declarator)StructDeclarator_21_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_22_Var
		);
		//22
		final DirectDeclarator DirectDeclarator_23_Var
		 = (DirectDeclarator)Declarator_22_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_23_Var
		);
		Assert.assertEquals("j", DirectDeclarator_23_Var
		.getId());
		final EList<? extends EObject> ConstExpr_23_list = StructDeclarator_21_Var
		.getConstExpr();
		Assert.assertNotNull(ConstExpr_23_list);
		Assert.assertEquals(1, ConstExpr_23_list.size());
		//23
		final PrimaryExpression PrimaryExpression_24_Var
		 = (PrimaryExpression)ConstExpr_23_list.get(0);
		Assert.assertNotNull(PrimaryExpression_24_Var
		);
		//24
		final Constant2 Constant2_25_Var
		 = (Constant2)PrimaryExpression_24_Var
		.getConst();
		Assert.assertNotNull(Constant2_25_Var
		);
		Assert.assertEquals("4", Constant2_25_Var
		.getDec());
		//25
		final StructDeclaration StructDeclaration_26_Var
		 = (StructDeclaration)StructDeclaration_7_list.get(2);
		Assert.assertNotNull(StructDeclaration_26_Var
		);
		//26
		final SpecifierQualifierList SpecifierQualifierList_27_Var
		 = (SpecifierQualifierList)StructDeclaration_26_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_27_Var
		);
		final EList<? extends EObject> TypeSpecifier_27_list = SpecifierQualifierList_27_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_27_list);
		Assert.assertEquals(1, TypeSpecifier_27_list.size());
		//27
		final TypeSpecifier TypeSpecifier_28_Var
		 = (TypeSpecifier)TypeSpecifier_27_list.get(0);
		Assert.assertNotNull(TypeSpecifier_28_Var
		);
		Assert.assertEquals("int", TypeSpecifier_28_Var
		.getName());
		//28
		final StructDeclaratorList StructDeclaratorList_29_Var
		 = (StructDeclaratorList)StructDeclaration_26_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_29_Var
		);
		final EList<? extends EObject> StructDeclarator_29_list = StructDeclaratorList_29_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_29_list);
		Assert.assertEquals(1, StructDeclarator_29_list.size());
		//29
		final StructDeclarator StructDeclarator_30_Var
		 = (StructDeclarator)StructDeclarator_29_list.get(0);
		Assert.assertNotNull(StructDeclarator_30_Var
		);
		//30
		final Declarator Declarator_31_Var
		 = (Declarator)StructDeclarator_30_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_31_Var
		);
		//31
		final DirectDeclarator DirectDeclarator_32_Var
		 = (DirectDeclarator)Declarator_31_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_32_Var
		);
		Assert.assertEquals("k", DirectDeclarator_32_Var
		.getId());
		final EList<? extends EObject> ConstExpr_32_list = StructDeclarator_30_Var
		.getConstExpr();
		Assert.assertNotNull(ConstExpr_32_list);
		Assert.assertEquals(1, ConstExpr_32_list.size());
		//32
		final PrimaryExpression PrimaryExpression_33_Var
		 = (PrimaryExpression)ConstExpr_32_list.get(0);
		Assert.assertNotNull(PrimaryExpression_33_Var
		);
		//33
		final Constant2 Constant2_34_Var
		 = (Constant2)PrimaryExpression_33_Var
		.getConst();
		Assert.assertNotNull(Constant2_34_Var
		);
		Assert.assertEquals("1", Constant2_34_Var
		.getDec());
		//34
		final StructDeclaration StructDeclaration_35_Var
		 = (StructDeclaration)StructDeclaration_7_list.get(3);
		Assert.assertNotNull(StructDeclaration_35_Var
		);
		//35
		final SpecifierQualifierList SpecifierQualifierList_36_Var
		 = (SpecifierQualifierList)StructDeclaration_35_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_36_Var
		);
		final EList<? extends EObject> TypeSpecifier_36_list = SpecifierQualifierList_36_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_36_list);
		Assert.assertEquals(1, TypeSpecifier_36_list.size());
		//36
		final TypeSpecifier TypeSpecifier_37_Var
		 = (TypeSpecifier)TypeSpecifier_36_list.get(0);
		Assert.assertNotNull(TypeSpecifier_37_Var
		);
		Assert.assertEquals("int", TypeSpecifier_37_Var
		.getName());
		//37
		final StructDeclaratorList StructDeclaratorList_38_Var
		 = (StructDeclaratorList)StructDeclaration_35_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_38_Var
		);
		final EList<? extends EObject> StructDeclarator_38_list = StructDeclaratorList_38_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_38_list);
		Assert.assertEquals(1, StructDeclarator_38_list.size());
		//38
		final StructDeclarator StructDeclarator_39_Var
		 = (StructDeclarator)StructDeclarator_38_list.get(0);
		Assert.assertNotNull(StructDeclarator_39_Var
		);
		Assert.assertNull(StructDeclarator_39_Var
		.getDeclarator());
		final EList<? extends EObject> ConstExpr_39_list = StructDeclarator_39_Var
		.getConstExpr();
		Assert.assertNotNull(ConstExpr_39_list);
		Assert.assertEquals(1, ConstExpr_39_list.size());
		//39
		final PrimaryExpression PrimaryExpression_40_Var
		 = (PrimaryExpression)ConstExpr_39_list.get(0);
		Assert.assertNotNull(PrimaryExpression_40_Var
		);
		//40
		final Constant2 Constant2_41_Var
		 = (Constant2)PrimaryExpression_40_Var
		.getConst();
		Assert.assertNotNull(Constant2_41_Var
		);
		Assert.assertEquals("8", Constant2_41_Var
		.getDec());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0081_Bitfields.c");
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
				method.invoke(this.generator, "Test0081_Bitfields.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0081_Bitfields.c");
		final String expected = this.getTextFromFile(
			"res/Test0081_Bitfields.c"
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


