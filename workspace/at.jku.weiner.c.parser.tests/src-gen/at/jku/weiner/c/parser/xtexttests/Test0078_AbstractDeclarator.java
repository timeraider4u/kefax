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
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.ParameterTypeList;
import at.jku.weiner.c.parser.parser.ParameterList;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.AbstractDeclarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.AbstractDeclarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.AbstractDeclarator;
import at.jku.weiner.c.parser.parser.DirectAbstractDeclarator;
import at.jku.weiner.c.parser.parser.AbstractDeclarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.AbstractDeclaratorSuffix;
import at.jku.weiner.c.parser.parser.ParameterTypeList;
import at.jku.weiner.c.parser.parser.ParameterList;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0078_AbstractDeclarator {
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
			"res/Test0078_AbstractDeclarator.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_TYPEDEF",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_EXTERN",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_STAR",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_SKW_STAR",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_STAR",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_STRUCT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
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
			"res/Test0078_AbstractDeclarator.c");
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
		Assert.assertEquals(2, DeclarationSpecifier_3_list.size());
		//3
		final StorageClassSpecifier StorageClassSpecifier_4_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_4_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_4_Var
		.getName());
		//4
		final TypeSpecifier TypeSpecifier_5_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(1);
		Assert.assertNotNull(TypeSpecifier_5_Var
		);
		Assert.assertEquals("int", TypeSpecifier_5_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_5_list = Declaration_2_Var
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
		Assert.assertEquals("foo", DirectDeclarator_9_Var
		.getId());
		Assert.assertEquals(";", Declaration_2_Var
		.getSemi());
		//9
		final ExternalDeclaration ExternalDeclaration_10_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_10_Var
		);
		//10
		final Declaration Declaration_11_Var
		 = (Declaration)ExternalDeclaration_10_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_11_Var
		);
		//11
		final DeclarationSpecifiers DeclarationSpecifiers_12_Var
		 = (DeclarationSpecifiers)Declaration_11_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_12_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_12_list = DeclarationSpecifiers_12_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_12_list);
		Assert.assertEquals(2, DeclarationSpecifier_12_list.size());
		//12
		final StorageClassSpecifier StorageClassSpecifier_13_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_12_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_13_Var
		);
		Assert.assertEquals("extern", StorageClassSpecifier_13_Var
		.getName());
		//13
		final TypeSpecifier TypeSpecifier_14_Var
		 = (TypeSpecifier)DeclarationSpecifier_12_list.get(1);
		Assert.assertNotNull(TypeSpecifier_14_Var
		);
		Assert.assertEquals("int", TypeSpecifier_14_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_14_list = Declaration_11_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_14_list);
		Assert.assertEquals(1, InitDeclaratorList_14_list.size());
		//14
		final InitDeclaratorList InitDeclaratorList_15_Var
		 = (InitDeclaratorList)InitDeclaratorList_14_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_15_Var
		);
		final EList<? extends EObject> InitDeclarator_15_list = InitDeclaratorList_15_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_15_list);
		Assert.assertEquals(1, InitDeclarator_15_list.size());
		//15
		final InitDeclarator InitDeclarator_16_Var
		 = (InitDeclarator)InitDeclarator_15_list.get(0);
		Assert.assertNotNull(InitDeclarator_16_Var
		);
		//16
		final Declarator Declarator_17_Var
		 = (Declarator)InitDeclarator_16_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_17_Var
		);
		//17
		final DirectDeclarator DirectDeclarator_18_Var
		 = (DirectDeclarator)Declarator_17_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_18_Var
		);
		Assert.assertEquals("bar", DirectDeclarator_18_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_18_list = DirectDeclarator_18_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_18_list);
		Assert.assertEquals(1, DeclaratorSuffix_18_list.size());
		//18
		final DeclaratorSuffix DeclaratorSuffix_19_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_18_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_19_Var
		);
		//19
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_20_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_19_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_20_Var
		);
		final EList<? extends EObject> ParameterTypeList_20_list = DirectDeclaratorLastSuffix_20_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_20_list);
		Assert.assertEquals(1, ParameterTypeList_20_list.size());
		//20
		final ParameterTypeList ParameterTypeList_21_Var
		 = (ParameterTypeList)ParameterTypeList_20_list.get(0);
		Assert.assertNotNull(ParameterTypeList_21_Var
		);
		//21
		final ParameterList ParameterList_22_Var
		 = (ParameterList)ParameterTypeList_21_Var
		.getList();
		Assert.assertNotNull(ParameterList_22_Var
		);
		final EList<? extends EObject> ParameterDeclaration_22_list = ParameterList_22_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_22_list);
		Assert.assertEquals(4, ParameterDeclaration_22_list.size());
		//22
		final ParameterDeclaration ParameterDeclaration_23_Var
		 = (ParameterDeclaration)ParameterDeclaration_22_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_23_Var
		);
		//23
		final DeclarationSpecifiers DeclarationSpecifiers_24_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_23_Var
		.getDeclSpecifiers();
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
		Assert.assertEquals("foo", TypedefName_26_Var
		.getId());
		//26
		final AbstractDeclarator AbstractDeclarator_27_Var
		 = (AbstractDeclarator)ParameterDeclaration_23_Var
		.getAbstractDeclator();
		Assert.assertNotNull(AbstractDeclarator_27_Var
		);
		//27
		final Pointer Pointer_28_Var
		 = (Pointer)AbstractDeclarator_27_Var
		.getPointer();
		Assert.assertNotNull(Pointer_28_Var
		);
		Assert.assertEquals("[*]", Pointer_28_Var
		.getStar().toString());
		//28
		final ParameterDeclaration ParameterDeclaration_29_Var
		 = (ParameterDeclaration)ParameterDeclaration_22_list.get(1);
		Assert.assertNotNull(ParameterDeclaration_29_Var
		);
		//29
		final DeclarationSpecifiers DeclarationSpecifiers_30_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_29_Var
		.getDeclSpecifiers();
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
		Assert.assertEquals("int", TypeSpecifier_31_Var
		.getName());
		//31
		final ParameterDeclaration ParameterDeclaration_32_Var
		 = (ParameterDeclaration)ParameterDeclaration_22_list.get(2);
		Assert.assertNotNull(ParameterDeclaration_32_Var
		);
		//32
		final DeclarationSpecifiers DeclarationSpecifiers_33_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_32_Var
		.getDeclSpecifiers();
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
		Assert.assertEquals("void", TypeSpecifier_34_Var
		.getName());
		//34
		final AbstractDeclarator AbstractDeclarator_35_Var
		 = (AbstractDeclarator)ParameterDeclaration_32_Var
		.getAbstractDeclator();
		Assert.assertNotNull(AbstractDeclarator_35_Var
		);
		//35
		final Pointer Pointer_36_Var
		 = (Pointer)AbstractDeclarator_35_Var
		.getPointer();
		Assert.assertNotNull(Pointer_36_Var
		);
		Assert.assertEquals("[*]", Pointer_36_Var
		.getStar().toString());
		//36
		final ParameterDeclaration ParameterDeclaration_37_Var
		 = (ParameterDeclaration)ParameterDeclaration_22_list.get(3);
		Assert.assertNotNull(ParameterDeclaration_37_Var
		);
		//37
		final DeclarationSpecifiers DeclarationSpecifiers_38_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_37_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_38_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_38_list = DeclarationSpecifiers_38_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_38_list);
		Assert.assertEquals(1, DeclarationSpecifier_38_list.size());
		//38
		final TypeSpecifier TypeSpecifier_39_Var
		 = (TypeSpecifier)DeclarationSpecifier_38_list.get(0);
		Assert.assertNotNull(TypeSpecifier_39_Var
		);
		//39
		final TypedefName TypedefName_40_Var
		 = (TypedefName)TypeSpecifier_39_Var
		.getType();
		Assert.assertNotNull(TypedefName_40_Var
		);
		Assert.assertEquals("foo", TypedefName_40_Var
		.getId());
		//40
		final AbstractDeclarator AbstractDeclarator_41_Var
		 = (AbstractDeclarator)ParameterDeclaration_37_Var
		.getAbstractDeclator();
		Assert.assertNotNull(AbstractDeclarator_41_Var
		);
		//41
		final DirectAbstractDeclarator DirectAbstractDeclarator_42_Var
		 = (DirectAbstractDeclarator)AbstractDeclarator_41_Var
		.getDirectAbstractDeclarator();
		Assert.assertNotNull(DirectAbstractDeclarator_42_Var
		);
		//42
		final AbstractDeclarator AbstractDeclarator_43_Var
		 = (AbstractDeclarator)DirectAbstractDeclarator_42_Var
		.getDeclarator();
		Assert.assertNotNull(AbstractDeclarator_43_Var
		);
		//43
		final Pointer Pointer_44_Var
		 = (Pointer)AbstractDeclarator_43_Var
		.getPointer();
		Assert.assertNotNull(Pointer_44_Var
		);
		Assert.assertEquals("[*]", Pointer_44_Var
		.getStar().toString());
		final EList<? extends EObject> AbstractDeclaratorSuffix_44_list = DirectAbstractDeclarator_42_Var
		.getAbstractDeclaratorSuffix();
		Assert.assertNotNull(AbstractDeclaratorSuffix_44_list);
		Assert.assertEquals(1, AbstractDeclaratorSuffix_44_list.size());
		//44
		final AbstractDeclaratorSuffix AbstractDeclaratorSuffix_45_Var
		 = (AbstractDeclaratorSuffix)AbstractDeclaratorSuffix_44_list.get(0);
		Assert.assertNotNull(AbstractDeclaratorSuffix_45_Var
		);
		//45
		final ParameterTypeList ParameterTypeList_46_Var
		 = (ParameterTypeList)AbstractDeclaratorSuffix_45_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_46_Var
		);
		//46
		final ParameterList ParameterList_47_Var
		 = (ParameterList)ParameterTypeList_46_Var
		.getList();
		Assert.assertNotNull(ParameterList_47_Var
		);
		final EList<? extends EObject> ParameterDeclaration_47_list = ParameterList_47_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_47_list);
		Assert.assertEquals(1, ParameterDeclaration_47_list.size());
		//47
		final ParameterDeclaration ParameterDeclaration_48_Var
		 = (ParameterDeclaration)ParameterDeclaration_47_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_48_Var
		);
		//48
		final DeclarationSpecifiers DeclarationSpecifiers_49_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_48_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_49_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_49_list = DeclarationSpecifiers_49_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_49_list);
		Assert.assertEquals(1, DeclarationSpecifier_49_list.size());
		//49
		final TypeSpecifier TypeSpecifier_50_Var
		 = (TypeSpecifier)DeclarationSpecifier_49_list.get(0);
		Assert.assertNotNull(TypeSpecifier_50_Var
		);
		//50
		final StructOrUnionSpecifier StructOrUnionSpecifier_51_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_50_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_51_Var
		);
		//51
		final StructOrUnion StructOrUnion_52_Var
		 = (StructOrUnion)StructOrUnionSpecifier_51_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_52_Var
		);
		Assert.assertEquals("struct", StructOrUnion_52_Var
		.getName());
		Assert.assertEquals("foobar", StructOrUnionSpecifier_51_Var
		.getId());
		Assert.assertFalse(StructOrUnionSpecifier_51_Var
		.isBraces());
		Assert.assertNull(StructOrUnionSpecifier_51_Var
		.getStructDeclList());
		Assert.assertEquals(";", Declaration_11_Var
		.getSemi());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0078_AbstractDeclarator.c");
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
				method.invoke(this.generator, "Test0078_AbstractDeclarator.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0078_AbstractDeclarator.c");
		final String expected = this.getTextFromFile(
			"res/Test0078_AbstractDeclarator.c"
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


