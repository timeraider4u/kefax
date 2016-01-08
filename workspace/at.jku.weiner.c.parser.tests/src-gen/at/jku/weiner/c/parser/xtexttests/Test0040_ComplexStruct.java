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
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.StructDeclarationList;
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
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
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0040_ComplexStruct.c");
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
		Assert.assertEquals(2, External_0_list.size());
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
		Assert.assertEquals("temp", StructOrUnionSpecifier_5_Var
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
		Assert.assertEquals(1, StructDeclaration_7_list.size());
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
		//14
		final ExternalDeclaration ExternalDeclaration_15_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_15_Var
		);
		//15
		final Declaration Declaration_16_Var
		 = (Declaration)ExternalDeclaration_15_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_16_Var
		);
		//16
		final DeclarationSpecifiers DeclarationSpecifiers_17_Var
		 = (DeclarationSpecifiers)Declaration_16_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_17_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_17_list = DeclarationSpecifiers_17_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_17_list);
		Assert.assertEquals(1, DeclarationSpecifier_17_list.size());
		//17
		final TypeSpecifier TypeSpecifier_18_Var
		 = (TypeSpecifier)DeclarationSpecifier_17_list.get(0);
		Assert.assertNotNull(TypeSpecifier_18_Var
		);
		//18
		final StructOrUnionSpecifier StructOrUnionSpecifier_19_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_18_Var
		.getSpecifier();
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
		final EList<? extends EObject> TypeSpecifier_23_list = SpecifierQualifierList_23_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_23_list);
		Assert.assertEquals(1, TypeSpecifier_23_list.size());
		//23
		final TypeSpecifier TypeSpecifier_24_Var
		 = (TypeSpecifier)TypeSpecifier_23_list.get(0);
		Assert.assertNotNull(TypeSpecifier_24_Var
		);
		//24
		final StructOrUnionSpecifier StructOrUnionSpecifier_25_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_24_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_25_Var
		);
		//25
		final StructOrUnion StructOrUnion_26_Var
		 = (StructOrUnion)StructOrUnionSpecifier_25_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_26_Var
		);
		Assert.assertEquals("struct", StructOrUnion_26_Var
		.getName());
		Assert.assertEquals("temp", StructOrUnionSpecifier_25_Var
		.getId());
		//26
		final StructDeclaratorList StructDeclaratorList_27_Var
		 = (StructDeclaratorList)StructDeclaration_22_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_27_Var
		);
		final EList<? extends EObject> StructDeclarator_27_list = StructDeclaratorList_27_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_27_list);
		Assert.assertEquals(1, StructDeclarator_27_list.size());
		//27
		final StructDeclarator StructDeclarator_28_Var
		 = (StructDeclarator)StructDeclarator_27_list.get(0);
		Assert.assertNotNull(StructDeclarator_28_Var
		);
		//28
		final Declarator Declarator_29_Var
		 = (Declarator)StructDeclarator_28_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_29_Var
		);
		//29
		final Pointer Pointer_30_Var
		 = (Pointer)Declarator_29_Var
		.getPointer();
		Assert.assertNotNull(Pointer_30_Var
		);
		Assert.assertEquals("[*]", Pointer_30_Var
		.getStar().toString());
		//30
		final DirectDeclarator DirectDeclarator_31_Var
		 = (DirectDeclarator)Declarator_29_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_31_Var
		);
		Assert.assertEquals("in1", DirectDeclarator_31_Var
		.getId());
		//31
		final StructDeclaration StructDeclaration_32_Var
		 = (StructDeclaration)StructDeclaration_21_list.get(1);
		Assert.assertNotNull(StructDeclaration_32_Var
		);
		//32
		final SpecifierQualifierList SpecifierQualifierList_33_Var
		 = (SpecifierQualifierList)StructDeclaration_32_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_33_Var
		);
		final EList<? extends EObject> TypeSpecifier_33_list = SpecifierQualifierList_33_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_33_list);
		Assert.assertEquals(1, TypeSpecifier_33_list.size());
		//33
		final TypeSpecifier TypeSpecifier_34_Var
		 = (TypeSpecifier)TypeSpecifier_33_list.get(0);
		Assert.assertNotNull(TypeSpecifier_34_Var
		);
		//34
		final StructOrUnionSpecifier StructOrUnionSpecifier_35_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_34_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_35_Var
		);
		//35
		final StructOrUnion StructOrUnion_36_Var
		 = (StructOrUnion)StructOrUnionSpecifier_35_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_36_Var
		);
		Assert.assertEquals("struct", StructOrUnion_36_Var
		.getName());
		Assert.assertEquals("temp", StructOrUnionSpecifier_35_Var
		.getId());
		//36
		final StructDeclaratorList StructDeclaratorList_37_Var
		 = (StructDeclaratorList)StructDeclaration_32_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_37_Var
		);
		final EList<? extends EObject> StructDeclarator_37_list = StructDeclaratorList_37_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_37_list);
		Assert.assertEquals(1, StructDeclarator_37_list.size());
		//37
		final StructDeclarator StructDeclarator_38_Var
		 = (StructDeclarator)StructDeclarator_37_list.get(0);
		Assert.assertNotNull(StructDeclarator_38_Var
		);
		//38
		final Declarator Declarator_39_Var
		 = (Declarator)StructDeclarator_38_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_39_Var
		);
		//39
		final DirectDeclarator DirectDeclarator_40_Var
		 = (DirectDeclarator)Declarator_39_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_40_Var
		);
		Assert.assertEquals("in2", DirectDeclarator_40_Var
		.getId());
		//40
		final StructDeclaration StructDeclaration_41_Var
		 = (StructDeclaration)StructDeclaration_21_list.get(2);
		Assert.assertNotNull(StructDeclaration_41_Var
		);
		//41
		final SpecifierQualifierList SpecifierQualifierList_42_Var
		 = (SpecifierQualifierList)StructDeclaration_41_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_42_Var
		);
		final EList<? extends EObject> TypeSpecifier_42_list = SpecifierQualifierList_42_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_42_list);
		Assert.assertEquals(1, TypeSpecifier_42_list.size());
		//42
		final TypeSpecifier TypeSpecifier_43_Var
		 = (TypeSpecifier)TypeSpecifier_42_list.get(0);
		Assert.assertNotNull(TypeSpecifier_43_Var
		);
		//43
		final StructOrUnionSpecifier StructOrUnionSpecifier_44_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_43_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_44_Var
		);
		//44
		final StructOrUnion StructOrUnion_45_Var
		 = (StructOrUnion)StructOrUnionSpecifier_44_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_45_Var
		);
		Assert.assertEquals("union", StructOrUnion_45_Var
		.getName());
		//45
		final StructDeclarationList StructDeclarationList_46_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_44_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_46_Var
		);
		final EList<? extends EObject> StructDeclaration_46_list = StructDeclarationList_46_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_46_list);
		Assert.assertEquals(1, StructDeclaration_46_list.size());
		//46
		final StructDeclaration StructDeclaration_47_Var
		 = (StructDeclaration)StructDeclaration_46_list.get(0);
		Assert.assertNotNull(StructDeclaration_47_Var
		);
		//47
		final SpecifierQualifierList SpecifierQualifierList_48_Var
		 = (SpecifierQualifierList)StructDeclaration_47_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_48_Var
		);
		final EList<? extends EObject> TypeSpecifier_48_list = SpecifierQualifierList_48_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_48_list);
		Assert.assertEquals(1, TypeSpecifier_48_list.size());
		//48
		final TypeSpecifier TypeSpecifier_49_Var
		 = (TypeSpecifier)TypeSpecifier_48_list.get(0);
		Assert.assertNotNull(TypeSpecifier_49_Var
		);
		//49
		final StructOrUnionSpecifier StructOrUnionSpecifier_50_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_49_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_50_Var
		);
		//50
		final StructOrUnion StructOrUnion_51_Var
		 = (StructOrUnion)StructOrUnionSpecifier_50_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_51_Var
		);
		Assert.assertEquals("struct", StructOrUnion_51_Var
		.getName());
		Assert.assertEquals("temp", StructOrUnionSpecifier_50_Var
		.getId());
		//51
		final StructDeclaratorList StructDeclaratorList_52_Var
		 = (StructDeclaratorList)StructDeclaration_47_Var
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
		Assert.assertEquals("in3", DirectDeclarator_55_Var
		.getId());
		//55
		final StructDeclaratorList StructDeclaratorList_56_Var
		 = (StructDeclaratorList)StructDeclaration_41_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_56_Var
		);
		final EList<? extends EObject> StructDeclarator_56_list = StructDeclaratorList_56_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_56_list);
		Assert.assertEquals(1, StructDeclarator_56_list.size());
		//56
		final StructDeclarator StructDeclarator_57_Var
		 = (StructDeclarator)StructDeclarator_56_list.get(0);
		Assert.assertNotNull(StructDeclarator_57_Var
		);
		//57
		final Declarator Declarator_58_Var
		 = (Declarator)StructDeclarator_57_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_58_Var
		);
		//58
		final DirectDeclarator DirectDeclarator_59_Var
		 = (DirectDeclarator)Declarator_58_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_59_Var
		);
		Assert.assertEquals("inner4", DirectDeclarator_59_Var
		.getId());
	}
	
	@Test
	(timeout=1000
	)
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


