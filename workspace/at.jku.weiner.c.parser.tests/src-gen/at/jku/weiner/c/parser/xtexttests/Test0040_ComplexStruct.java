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
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.StructDeclarationList;
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.StructDeclarationList;
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0040_ComplexStruct {
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
			"res/Test0040_ComplexStruct.c");
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
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_SKW_RIGHTBRACE", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_STRUCT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_LINE_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_STRUCT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_STAR", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_STRUCT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_UNION", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_STRUCT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_SKW_RIGHTBRACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
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
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0040_ComplexStruct.c");
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
		Assert.assertEquals(2, External_2_list.size());
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
		final StructOrUnionSpecifier StructOrUnionSpecifier_6_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_5_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_6_Var
		);
		//6
		final StructOrUnion StructOrUnion_7_Var
		 = (StructOrUnion)StructOrUnionSpecifier_6_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_7_Var
		);
		Assert.assertEquals("struct", StructOrUnion_7_Var
		.getName());
		Assert.assertEquals("temp", StructOrUnionSpecifier_6_Var
		.getId());
		//7
		final StructDeclarationList StructDeclarationList_8_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_6_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_8_Var
		);
		final EList<? extends EObject> StructDeclaration_8_list = StructDeclarationList_8_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_8_list);
		Assert.assertEquals(1, StructDeclaration_8_list.size());
		//8
		final StructDeclaration StructDeclaration_9_Var
		 = (StructDeclaration)StructDeclaration_8_list.get(0);
		Assert.assertNotNull(StructDeclaration_9_Var
		);
		//9
		final SpecifierQualifierList SpecifierQualifierList_10_Var
		 = (SpecifierQualifierList)StructDeclaration_9_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_10_Var
		);
		final EList<? extends EObject> TypeSpecifier_10_list = SpecifierQualifierList_10_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_10_list);
		Assert.assertEquals(1, TypeSpecifier_10_list.size());
		//10
		final TypeSpecifier TypeSpecifier_11_Var
		 = (TypeSpecifier)TypeSpecifier_10_list.get(0);
		Assert.assertNotNull(TypeSpecifier_11_Var
		);
		Assert.assertEquals("int", TypeSpecifier_11_Var
		.getName());
		//11
		final StructDeclaratorList StructDeclaratorList_12_Var
		 = (StructDeclaratorList)StructDeclaration_9_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_12_Var
		);
		final EList<? extends EObject> StructDeclarator_12_list = StructDeclaratorList_12_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_12_list);
		Assert.assertEquals(1, StructDeclarator_12_list.size());
		//12
		final StructDeclarator StructDeclarator_13_Var
		 = (StructDeclarator)StructDeclarator_12_list.get(0);
		Assert.assertNotNull(StructDeclarator_13_Var
		);
		//13
		final Declarator Declarator_14_Var
		 = (Declarator)StructDeclarator_13_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_14_Var
		);
		//14
		final DirectDeclarator DirectDeclarator_15_Var
		 = (DirectDeclarator)Declarator_14_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_15_Var
		);
		Assert.assertEquals("i", DirectDeclarator_15_Var
		.getId());
		//15
		final ExternalDeclaration ExternalDeclaration_16_Var
		 = (ExternalDeclaration)External_2_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_16_Var
		);
		//16
		final Declaration Declaration_17_Var
		 = (Declaration)ExternalDeclaration_16_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_17_Var
		);
		//17
		final DeclarationSpecifiers DeclarationSpecifiers_18_Var
		 = (DeclarationSpecifiers)Declaration_17_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_18_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_18_list = DeclarationSpecifiers_18_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_18_list);
		Assert.assertEquals(1, DeclarationSpecifier_18_list.size());
		//18
		final StructOrUnionSpecifier StructOrUnionSpecifier_19_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_18_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_19_Var
		);
		//19
		final StructOrUnion StructOrUnion_20_Var
		 = (StructOrUnion)StructOrUnionSpecifier_19_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_20_Var
		);
		Assert.assertEquals("struct", StructOrUnion_20_Var
		.getName());
		Assert.assertEquals("outer", StructOrUnionSpecifier_19_Var
		.getId());
		//20
		final StructDeclarationList StructDeclarationList_21_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_19_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_21_Var
		);
		final EList<? extends EObject> StructDeclaration_21_list = StructDeclarationList_21_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_21_list);
		Assert.assertEquals(3, StructDeclaration_21_list.size());
		//21
		final StructDeclaration StructDeclaration_22_Var
		 = (StructDeclaration)StructDeclaration_21_list.get(0);
		Assert.assertNotNull(StructDeclaration_22_Var
		);
		//22
		final SpecifierQualifierList SpecifierQualifierList_23_Var
		 = (SpecifierQualifierList)StructDeclaration_22_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_23_Var
		);
		final EList<? extends EObject> StructOrUnionSpecifier_23_list = SpecifierQualifierList_23_Var
		.getStructOrUnionSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_23_list);
		Assert.assertEquals(1, StructOrUnionSpecifier_23_list.size());
		//23
		final StructOrUnionSpecifier StructOrUnionSpecifier_24_Var
		 = (StructOrUnionSpecifier)StructOrUnionSpecifier_23_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_24_Var
		);
		//24
		final StructOrUnion StructOrUnion_25_Var
		 = (StructOrUnion)StructOrUnionSpecifier_24_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_25_Var
		);
		Assert.assertEquals("struct", StructOrUnion_25_Var
		.getName());
		Assert.assertEquals("temp", StructOrUnionSpecifier_24_Var
		.getId());
		//25
		final StructDeclaratorList StructDeclaratorList_26_Var
		 = (StructDeclaratorList)StructDeclaration_22_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_26_Var
		);
		final EList<? extends EObject> StructDeclarator_26_list = StructDeclaratorList_26_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_26_list);
		Assert.assertEquals(1, StructDeclarator_26_list.size());
		//26
		final StructDeclarator StructDeclarator_27_Var
		 = (StructDeclarator)StructDeclarator_26_list.get(0);
		Assert.assertNotNull(StructDeclarator_27_Var
		);
		//27
		final Declarator Declarator_28_Var
		 = (Declarator)StructDeclarator_27_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_28_Var
		);
		//28
		final Pointer Pointer_29_Var
		 = (Pointer)Declarator_28_Var
		.getPointer();
		Assert.assertNotNull(Pointer_29_Var
		);
		Assert.assertEquals("[*]", Pointer_29_Var
		.getStar().toString());
		//29
		final DirectDeclarator DirectDeclarator_30_Var
		 = (DirectDeclarator)Declarator_28_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_30_Var
		);
		Assert.assertEquals("in1", DirectDeclarator_30_Var
		.getId());
		//30
		final StructDeclaration StructDeclaration_31_Var
		 = (StructDeclaration)StructDeclaration_21_list.get(1);
		Assert.assertNotNull(StructDeclaration_31_Var
		);
		//31
		final SpecifierQualifierList SpecifierQualifierList_32_Var
		 = (SpecifierQualifierList)StructDeclaration_31_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_32_Var
		);
		final EList<? extends EObject> StructOrUnionSpecifier_32_list = SpecifierQualifierList_32_Var
		.getStructOrUnionSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_32_list);
		Assert.assertEquals(1, StructOrUnionSpecifier_32_list.size());
		//32
		final StructOrUnionSpecifier StructOrUnionSpecifier_33_Var
		 = (StructOrUnionSpecifier)StructOrUnionSpecifier_32_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_33_Var
		);
		//33
		final StructOrUnion StructOrUnion_34_Var
		 = (StructOrUnion)StructOrUnionSpecifier_33_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_34_Var
		);
		Assert.assertEquals("struct", StructOrUnion_34_Var
		.getName());
		Assert.assertEquals("temp", StructOrUnionSpecifier_33_Var
		.getId());
		//34
		final StructDeclaratorList StructDeclaratorList_35_Var
		 = (StructDeclaratorList)StructDeclaration_31_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_35_Var
		);
		final EList<? extends EObject> StructDeclarator_35_list = StructDeclaratorList_35_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_35_list);
		Assert.assertEquals(1, StructDeclarator_35_list.size());
		//35
		final StructDeclarator StructDeclarator_36_Var
		 = (StructDeclarator)StructDeclarator_35_list.get(0);
		Assert.assertNotNull(StructDeclarator_36_Var
		);
		//36
		final Declarator Declarator_37_Var
		 = (Declarator)StructDeclarator_36_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_37_Var
		);
		//37
		final DirectDeclarator DirectDeclarator_38_Var
		 = (DirectDeclarator)Declarator_37_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_38_Var
		);
		Assert.assertEquals("in2", DirectDeclarator_38_Var
		.getId());
		//38
		final StructDeclaration StructDeclaration_39_Var
		 = (StructDeclaration)StructDeclaration_21_list.get(2);
		Assert.assertNotNull(StructDeclaration_39_Var
		);
		//39
		final SpecifierQualifierList SpecifierQualifierList_40_Var
		 = (SpecifierQualifierList)StructDeclaration_39_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_40_Var
		);
		final EList<? extends EObject> StructOrUnionSpecifier_40_list = SpecifierQualifierList_40_Var
		.getStructOrUnionSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_40_list);
		Assert.assertEquals(1, StructOrUnionSpecifier_40_list.size());
		//40
		final StructOrUnionSpecifier StructOrUnionSpecifier_41_Var
		 = (StructOrUnionSpecifier)StructOrUnionSpecifier_40_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_41_Var
		);
		//41
		final StructOrUnion StructOrUnion_42_Var
		 = (StructOrUnion)StructOrUnionSpecifier_41_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_42_Var
		);
		Assert.assertEquals("union", StructOrUnion_42_Var
		.getName());
		//42
		final StructDeclarationList StructDeclarationList_43_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_41_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_43_Var
		);
		final EList<? extends EObject> StructDeclaration_43_list = StructDeclarationList_43_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_43_list);
		Assert.assertEquals(1, StructDeclaration_43_list.size());
		//43
		final StructDeclaration StructDeclaration_44_Var
		 = (StructDeclaration)StructDeclaration_43_list.get(0);
		Assert.assertNotNull(StructDeclaration_44_Var
		);
		//44
		final SpecifierQualifierList SpecifierQualifierList_45_Var
		 = (SpecifierQualifierList)StructDeclaration_44_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_45_Var
		);
		final EList<? extends EObject> StructOrUnionSpecifier_45_list = SpecifierQualifierList_45_Var
		.getStructOrUnionSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_45_list);
		Assert.assertEquals(1, StructOrUnionSpecifier_45_list.size());
		//45
		final StructOrUnionSpecifier StructOrUnionSpecifier_46_Var
		 = (StructOrUnionSpecifier)StructOrUnionSpecifier_45_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_46_Var
		);
		//46
		final StructOrUnion StructOrUnion_47_Var
		 = (StructOrUnion)StructOrUnionSpecifier_46_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_47_Var
		);
		Assert.assertEquals("struct", StructOrUnion_47_Var
		.getName());
		Assert.assertEquals("temp", StructOrUnionSpecifier_46_Var
		.getId());
		//47
		final StructDeclaratorList StructDeclaratorList_48_Var
		 = (StructDeclaratorList)StructDeclaration_44_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_48_Var
		);
		final EList<? extends EObject> StructDeclarator_48_list = StructDeclaratorList_48_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_48_list);
		Assert.assertEquals(1, StructDeclarator_48_list.size());
		//48
		final StructDeclarator StructDeclarator_49_Var
		 = (StructDeclarator)StructDeclarator_48_list.get(0);
		Assert.assertNotNull(StructDeclarator_49_Var
		);
		//49
		final Declarator Declarator_50_Var
		 = (Declarator)StructDeclarator_49_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_50_Var
		);
		//50
		final DirectDeclarator DirectDeclarator_51_Var
		 = (DirectDeclarator)Declarator_50_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_51_Var
		);
		Assert.assertEquals("in3", DirectDeclarator_51_Var
		.getId());
		//51
		final StructDeclaratorList StructDeclaratorList_52_Var
		 = (StructDeclaratorList)StructDeclaration_39_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_52_Var
		);
		final EList<? extends EObject> StructDeclarator_52_list = StructDeclaratorList_52_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_52_list);
		Assert.assertEquals(1, StructDeclarator_52_list.size());
		//52
		final StructDeclarator StructDeclarator_53_Var
		 = (StructDeclarator)StructDeclarator_52_list.get(0);
		Assert.assertNotNull(StructDeclarator_53_Var
		);
		//53
		final Declarator Declarator_54_Var
		 = (Declarator)StructDeclarator_53_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_54_Var
		);
		//54
		final DirectDeclarator DirectDeclarator_55_Var
		 = (DirectDeclarator)Declarator_54_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_55_Var
		);
		Assert.assertEquals("inner4", DirectDeclarator_55_Var
		.getId());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0040_ComplexStruct.c");
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
				method.invoke(this.generator, "Test0040_ComplexStruct.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0040_ComplexStruct.c");
		final String expected = this.getTextFromFile(
			"res/Test0040_ComplexStruct.c"
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


