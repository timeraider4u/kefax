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
		final StructOrUnionSpecifier StructOrUnionSpecifier_4_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_4_Var
		);
		//4
		final StructOrUnion StructOrUnion_5_Var
		 = (StructOrUnion)StructOrUnionSpecifier_4_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_5_Var
		);
		Assert.assertEquals("struct", StructOrUnion_5_Var
		.getName());
		Assert.assertEquals("temp", StructOrUnionSpecifier_4_Var
		.getId());
		//5
		final StructDeclarationList StructDeclarationList_6_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_4_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_6_Var
		);
		final EList<? extends EObject> StructDeclaration_6_list = StructDeclarationList_6_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_6_list);
		Assert.assertEquals(1, StructDeclaration_6_list.size());
		//6
		final StructDeclaration StructDeclaration_7_Var
		 = (StructDeclaration)StructDeclaration_6_list.get(0);
		Assert.assertNotNull(StructDeclaration_7_Var
		);
		//7
		final SpecifierQualifierList SpecifierQualifierList_8_Var
		 = (SpecifierQualifierList)StructDeclaration_7_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_8_Var
		);
		final EList<? extends EObject> TypeSpecifier_8_list = SpecifierQualifierList_8_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_8_list);
		Assert.assertEquals(1, TypeSpecifier_8_list.size());
		//8
		final TypeSpecifier TypeSpecifier_9_Var
		 = (TypeSpecifier)TypeSpecifier_8_list.get(0);
		Assert.assertNotNull(TypeSpecifier_9_Var
		);
		Assert.assertEquals("int", TypeSpecifier_9_Var
		.getName());
		//9
		final StructDeclaratorList StructDeclaratorList_10_Var
		 = (StructDeclaratorList)StructDeclaration_7_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_10_Var
		);
		final EList<? extends EObject> StructDeclarator_10_list = StructDeclaratorList_10_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_10_list);
		Assert.assertEquals(1, StructDeclarator_10_list.size());
		//10
		final StructDeclarator StructDeclarator_11_Var
		 = (StructDeclarator)StructDeclarator_10_list.get(0);
		Assert.assertNotNull(StructDeclarator_11_Var
		);
		//11
		final Declarator Declarator_12_Var
		 = (Declarator)StructDeclarator_11_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_12_Var
		);
		//12
		final DirectDeclarator DirectDeclarator_13_Var
		 = (DirectDeclarator)Declarator_12_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_13_Var
		);
		Assert.assertEquals("i", DirectDeclarator_13_Var
		.getId());
		//13
		final ExternalDeclaration ExternalDeclaration_14_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_14_Var
		);
		//14
		final Declaration Declaration_15_Var
		 = (Declaration)ExternalDeclaration_14_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_15_Var
		);
		//15
		final DeclarationSpecifiers DeclarationSpecifiers_16_Var
		 = (DeclarationSpecifiers)Declaration_15_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_16_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_16_list = DeclarationSpecifiers_16_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_16_list);
		Assert.assertEquals(1, DeclarationSpecifier_16_list.size());
		//16
		final StructOrUnionSpecifier StructOrUnionSpecifier_17_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_16_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_17_Var
		);
		//17
		final StructOrUnion StructOrUnion_18_Var
		 = (StructOrUnion)StructOrUnionSpecifier_17_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_18_Var
		);
		Assert.assertEquals("struct", StructOrUnion_18_Var
		.getName());
		Assert.assertEquals("outer", StructOrUnionSpecifier_17_Var
		.getId());
		//18
		final StructDeclarationList StructDeclarationList_19_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_17_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_19_Var
		);
		final EList<? extends EObject> StructDeclaration_19_list = StructDeclarationList_19_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_19_list);
		Assert.assertEquals(3, StructDeclaration_19_list.size());
		//19
		final StructDeclaration StructDeclaration_20_Var
		 = (StructDeclaration)StructDeclaration_19_list.get(0);
		Assert.assertNotNull(StructDeclaration_20_Var
		);
		//20
		final SpecifierQualifierList SpecifierQualifierList_21_Var
		 = (SpecifierQualifierList)StructDeclaration_20_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_21_Var
		);
		final EList<? extends EObject> StructOrUnionSpecifier_21_list = SpecifierQualifierList_21_Var
		.getStructOrUnionSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_21_list);
		Assert.assertEquals(1, StructOrUnionSpecifier_21_list.size());
		//21
		final StructOrUnionSpecifier StructOrUnionSpecifier_22_Var
		 = (StructOrUnionSpecifier)StructOrUnionSpecifier_21_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_22_Var
		);
		//22
		final StructOrUnion StructOrUnion_23_Var
		 = (StructOrUnion)StructOrUnionSpecifier_22_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_23_Var
		);
		Assert.assertEquals("struct", StructOrUnion_23_Var
		.getName());
		Assert.assertEquals("temp", StructOrUnionSpecifier_22_Var
		.getId());
		//23
		final StructDeclaratorList StructDeclaratorList_24_Var
		 = (StructDeclaratorList)StructDeclaration_20_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_24_Var
		);
		final EList<? extends EObject> StructDeclarator_24_list = StructDeclaratorList_24_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_24_list);
		Assert.assertEquals(1, StructDeclarator_24_list.size());
		//24
		final StructDeclarator StructDeclarator_25_Var
		 = (StructDeclarator)StructDeclarator_24_list.get(0);
		Assert.assertNotNull(StructDeclarator_25_Var
		);
		//25
		final Declarator Declarator_26_Var
		 = (Declarator)StructDeclarator_25_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_26_Var
		);
		//26
		final Pointer Pointer_27_Var
		 = (Pointer)Declarator_26_Var
		.getPointer();
		Assert.assertNotNull(Pointer_27_Var
		);
		Assert.assertEquals("[*]", Pointer_27_Var
		.getStar().toString());
		//27
		final DirectDeclarator DirectDeclarator_28_Var
		 = (DirectDeclarator)Declarator_26_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_28_Var
		);
		Assert.assertEquals("in1", DirectDeclarator_28_Var
		.getId());
		//28
		final StructDeclaration StructDeclaration_29_Var
		 = (StructDeclaration)StructDeclaration_19_list.get(1);
		Assert.assertNotNull(StructDeclaration_29_Var
		);
		//29
		final SpecifierQualifierList SpecifierQualifierList_30_Var
		 = (SpecifierQualifierList)StructDeclaration_29_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_30_Var
		);
		final EList<? extends EObject> StructOrUnionSpecifier_30_list = SpecifierQualifierList_30_Var
		.getStructOrUnionSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_30_list);
		Assert.assertEquals(1, StructOrUnionSpecifier_30_list.size());
		//30
		final StructOrUnionSpecifier StructOrUnionSpecifier_31_Var
		 = (StructOrUnionSpecifier)StructOrUnionSpecifier_30_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_31_Var
		);
		//31
		final StructOrUnion StructOrUnion_32_Var
		 = (StructOrUnion)StructOrUnionSpecifier_31_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_32_Var
		);
		Assert.assertEquals("struct", StructOrUnion_32_Var
		.getName());
		Assert.assertEquals("temp", StructOrUnionSpecifier_31_Var
		.getId());
		//32
		final StructDeclaratorList StructDeclaratorList_33_Var
		 = (StructDeclaratorList)StructDeclaration_29_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_33_Var
		);
		final EList<? extends EObject> StructDeclarator_33_list = StructDeclaratorList_33_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_33_list);
		Assert.assertEquals(1, StructDeclarator_33_list.size());
		//33
		final StructDeclarator StructDeclarator_34_Var
		 = (StructDeclarator)StructDeclarator_33_list.get(0);
		Assert.assertNotNull(StructDeclarator_34_Var
		);
		//34
		final Declarator Declarator_35_Var
		 = (Declarator)StructDeclarator_34_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_35_Var
		);
		//35
		final DirectDeclarator DirectDeclarator_36_Var
		 = (DirectDeclarator)Declarator_35_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_36_Var
		);
		Assert.assertEquals("in2", DirectDeclarator_36_Var
		.getId());
		//36
		final StructDeclaration StructDeclaration_37_Var
		 = (StructDeclaration)StructDeclaration_19_list.get(2);
		Assert.assertNotNull(StructDeclaration_37_Var
		);
		//37
		final SpecifierQualifierList SpecifierQualifierList_38_Var
		 = (SpecifierQualifierList)StructDeclaration_37_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_38_Var
		);
		final EList<? extends EObject> StructOrUnionSpecifier_38_list = SpecifierQualifierList_38_Var
		.getStructOrUnionSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_38_list);
		Assert.assertEquals(1, StructOrUnionSpecifier_38_list.size());
		//38
		final StructOrUnionSpecifier StructOrUnionSpecifier_39_Var
		 = (StructOrUnionSpecifier)StructOrUnionSpecifier_38_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_39_Var
		);
		//39
		final StructOrUnion StructOrUnion_40_Var
		 = (StructOrUnion)StructOrUnionSpecifier_39_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_40_Var
		);
		Assert.assertEquals("union", StructOrUnion_40_Var
		.getName());
		//40
		final StructDeclarationList StructDeclarationList_41_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_39_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_41_Var
		);
		final EList<? extends EObject> StructDeclaration_41_list = StructDeclarationList_41_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_41_list);
		Assert.assertEquals(1, StructDeclaration_41_list.size());
		//41
		final StructDeclaration StructDeclaration_42_Var
		 = (StructDeclaration)StructDeclaration_41_list.get(0);
		Assert.assertNotNull(StructDeclaration_42_Var
		);
		//42
		final SpecifierQualifierList SpecifierQualifierList_43_Var
		 = (SpecifierQualifierList)StructDeclaration_42_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_43_Var
		);
		final EList<? extends EObject> StructOrUnionSpecifier_43_list = SpecifierQualifierList_43_Var
		.getStructOrUnionSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_43_list);
		Assert.assertEquals(1, StructOrUnionSpecifier_43_list.size());
		//43
		final StructOrUnionSpecifier StructOrUnionSpecifier_44_Var
		 = (StructOrUnionSpecifier)StructOrUnionSpecifier_43_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_44_Var
		);
		//44
		final StructOrUnion StructOrUnion_45_Var
		 = (StructOrUnion)StructOrUnionSpecifier_44_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_45_Var
		);
		Assert.assertEquals("struct", StructOrUnion_45_Var
		.getName());
		Assert.assertEquals("temp", StructOrUnionSpecifier_44_Var
		.getId());
		//45
		final StructDeclaratorList StructDeclaratorList_46_Var
		 = (StructDeclaratorList)StructDeclaration_42_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_46_Var
		);
		final EList<? extends EObject> StructDeclarator_46_list = StructDeclaratorList_46_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_46_list);
		Assert.assertEquals(1, StructDeclarator_46_list.size());
		//46
		final StructDeclarator StructDeclarator_47_Var
		 = (StructDeclarator)StructDeclarator_46_list.get(0);
		Assert.assertNotNull(StructDeclarator_47_Var
		);
		//47
		final Declarator Declarator_48_Var
		 = (Declarator)StructDeclarator_47_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_48_Var
		);
		//48
		final DirectDeclarator DirectDeclarator_49_Var
		 = (DirectDeclarator)Declarator_48_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_49_Var
		);
		Assert.assertEquals("in3", DirectDeclarator_49_Var
		.getId());
		//49
		final StructDeclaratorList StructDeclaratorList_50_Var
		 = (StructDeclaratorList)StructDeclaration_37_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_50_Var
		);
		final EList<? extends EObject> StructDeclarator_50_list = StructDeclaratorList_50_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_50_list);
		Assert.assertEquals(1, StructDeclarator_50_list.size());
		//50
		final StructDeclarator StructDeclarator_51_Var
		 = (StructDeclarator)StructDeclarator_50_list.get(0);
		Assert.assertNotNull(StructDeclarator_51_Var
		);
		//51
		final Declarator Declarator_52_Var
		 = (Declarator)StructDeclarator_51_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_52_Var
		);
		//52
		final DirectDeclarator DirectDeclarator_53_Var
		 = (DirectDeclarator)Declarator_52_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_53_Var
		);
		Assert.assertEquals("inner4", DirectDeclarator_53_Var
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


