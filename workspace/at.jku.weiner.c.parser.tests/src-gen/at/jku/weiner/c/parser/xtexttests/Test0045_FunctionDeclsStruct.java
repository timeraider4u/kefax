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
import at.jku.weiner.c.parser.parser.ParameterTypeList;
import at.jku.weiner.c.parser.parser.ParameterList;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
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
import at.jku.weiner.c.parser.parser.ParameterTypeList;
import at.jku.weiner.c.parser.parser.ParameterList;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
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
import at.jku.weiner.c.parser.parser.ParameterTypeList;
import at.jku.weiner.c.parser.parser.ParameterList;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.AbstractDeclarator;
import at.jku.weiner.c.parser.parser.Pointer;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0045_FunctionDeclsStruct {
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
			"res/Test0045_FunctionDeclsStruct.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_STRUCT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_KW_CHAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_STRUCT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_KW_CHAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_STRUCT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_STAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_KW_CHAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_STRUCT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_STAR",
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
			"res/Test0045_FunctionDeclsStruct.c");
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
		Assert.assertEquals("STRUCT", StructOrUnionSpecifier_5_Var
		.getId());
		Assert.assertNull(StructOrUnionSpecifier_5_Var
		.getStructDeclList());
		//6
		final ExternalDeclaration ExternalDeclaration_7_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_7_Var
		);
		//7
		final Declaration Declaration_8_Var
		 = (Declaration)ExternalDeclaration_7_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_8_Var
		);
		//8
		final DeclarationSpecifiers DeclarationSpecifiers_9_Var
		 = (DeclarationSpecifiers)Declaration_8_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_9_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_9_list = DeclarationSpecifiers_9_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_9_list);
		Assert.assertEquals(1, DeclarationSpecifier_9_list.size());
		//9
		final TypeSpecifier TypeSpecifier_10_Var
		 = (TypeSpecifier)DeclarationSpecifier_9_list.get(0);
		Assert.assertNotNull(TypeSpecifier_10_Var
		);
		Assert.assertEquals("char", TypeSpecifier_10_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_10_list = Declaration_8_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_10_list);
		Assert.assertEquals(1, InitDeclaratorList_10_list.size());
		//10
		final InitDeclaratorList InitDeclaratorList_11_Var
		 = (InitDeclaratorList)InitDeclaratorList_10_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_11_Var
		);
		final EList<? extends EObject> InitDeclarator_11_list = InitDeclaratorList_11_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_11_list);
		Assert.assertEquals(1, InitDeclarator_11_list.size());
		//11
		final InitDeclarator InitDeclarator_12_Var
		 = (InitDeclarator)InitDeclarator_11_list.get(0);
		Assert.assertNotNull(InitDeclarator_12_Var
		);
		//12
		final Declarator Declarator_13_Var
		 = (Declarator)InitDeclarator_12_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_13_Var
		);
		//13
		final DirectDeclarator DirectDeclarator_14_Var
		 = (DirectDeclarator)Declarator_13_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_14_Var
		);
		Assert.assertEquals("do2", DirectDeclarator_14_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_14_list = DirectDeclarator_14_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_14_list);
		Assert.assertEquals(1, DeclaratorSuffix_14_list.size());
		//14
		final DeclaratorSuffix DeclaratorSuffix_15_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_14_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_15_Var
		);
		//15
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_16_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_15_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_16_Var
		);
		final EList<? extends EObject> ParameterTypeList_16_list = DirectDeclaratorLastSuffix_16_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_16_list);
		Assert.assertEquals(1, ParameterTypeList_16_list.size());
		//16
		final ParameterTypeList ParameterTypeList_17_Var
		 = (ParameterTypeList)ParameterTypeList_16_list.get(0);
		Assert.assertNotNull(ParameterTypeList_17_Var
		);
		//17
		final ParameterList ParameterList_18_Var
		 = (ParameterList)ParameterTypeList_17_Var
		.getList();
		Assert.assertNotNull(ParameterList_18_Var
		);
		final EList<? extends EObject> ParameterDeclaration_18_list = ParameterList_18_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_18_list);
		Assert.assertEquals(1, ParameterDeclaration_18_list.size());
		//18
		final ParameterDeclaration ParameterDeclaration_19_Var
		 = (ParameterDeclaration)ParameterDeclaration_18_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_19_Var
		);
		//19
		final DeclarationSpecifiers DeclarationSpecifiers_20_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_19_Var
		.getDeclSpecifiers();
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
		//21
		final StructOrUnionSpecifier StructOrUnionSpecifier_22_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_21_Var
		.getSpecifier();
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
		Assert.assertEquals("STRUCT", StructOrUnionSpecifier_22_Var
		.getId());
		Assert.assertNull(StructOrUnionSpecifier_22_Var
		.getStructDeclList());
		//23
		final Declarator Declarator_24_Var
		 = (Declarator)ParameterDeclaration_19_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_24_Var
		);
		//24
		final Pointer Pointer_25_Var
		 = (Pointer)Declarator_24_Var
		.getPointer();
		Assert.assertNotNull(Pointer_25_Var
		);
		//25
		final DirectDeclarator DirectDeclarator_26_Var
		 = (DirectDeclarator)Declarator_24_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_26_Var
		);
		Assert.assertEquals("s", DirectDeclarator_26_Var
		.getId());
		Assert.assertEquals(";", Declaration_8_Var
		.getSemi());
		//26
		final ExternalDeclaration ExternalDeclaration_27_Var
		 = (ExternalDeclaration)External_0_list.get(2);
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
		Assert.assertEquals("char", TypeSpecifier_30_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_30_list = Declaration_28_Var
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
		Assert.assertEquals("do3", DirectDeclarator_34_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_34_list = DirectDeclarator_34_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_34_list);
		Assert.assertEquals(1, DeclaratorSuffix_34_list.size());
		//34
		final DeclaratorSuffix DeclaratorSuffix_35_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_34_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_35_Var
		);
		//35
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_36_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_35_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_36_Var
		);
		final EList<? extends EObject> ParameterTypeList_36_list = DirectDeclaratorLastSuffix_36_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_36_list);
		Assert.assertEquals(1, ParameterTypeList_36_list.size());
		//36
		final ParameterTypeList ParameterTypeList_37_Var
		 = (ParameterTypeList)ParameterTypeList_36_list.get(0);
		Assert.assertNotNull(ParameterTypeList_37_Var
		);
		//37
		final ParameterList ParameterList_38_Var
		 = (ParameterList)ParameterTypeList_37_Var
		.getList();
		Assert.assertNotNull(ParameterList_38_Var
		);
		final EList<? extends EObject> ParameterDeclaration_38_list = ParameterList_38_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_38_list);
		Assert.assertEquals(1, ParameterDeclaration_38_list.size());
		//38
		final ParameterDeclaration ParameterDeclaration_39_Var
		 = (ParameterDeclaration)ParameterDeclaration_38_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_39_Var
		);
		//39
		final DeclarationSpecifiers DeclarationSpecifiers_40_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_39_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_40_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_40_list = DeclarationSpecifiers_40_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_40_list);
		Assert.assertEquals(1, DeclarationSpecifier_40_list.size());
		//40
		final TypeSpecifier TypeSpecifier_41_Var
		 = (TypeSpecifier)DeclarationSpecifier_40_list.get(0);
		Assert.assertNotNull(TypeSpecifier_41_Var
		);
		//41
		final StructOrUnionSpecifier StructOrUnionSpecifier_42_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_41_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_42_Var
		);
		//42
		final StructOrUnion StructOrUnion_43_Var
		 = (StructOrUnion)StructOrUnionSpecifier_42_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_43_Var
		);
		Assert.assertEquals("struct", StructOrUnion_43_Var
		.getName());
		Assert.assertEquals("STRUCT", StructOrUnionSpecifier_42_Var
		.getId());
		Assert.assertNull(StructOrUnionSpecifier_42_Var
		.getStructDeclList());
		//43
		final Declarator Declarator_44_Var
		 = (Declarator)ParameterDeclaration_39_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_44_Var
		);
		//44
		final Pointer Pointer_45_Var
		 = (Pointer)Declarator_44_Var
		.getPointer();
		Assert.assertNotNull(Pointer_45_Var
		);
		Assert.assertEquals("[*]", Pointer_45_Var
		.getStar().toString());
		//45
		final DirectDeclarator DirectDeclarator_46_Var
		 = (DirectDeclarator)Declarator_44_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_46_Var
		);
		Assert.assertEquals("s", DirectDeclarator_46_Var
		.getId());
		Assert.assertEquals(";", Declaration_28_Var
		.getSemi());
		//46
		final ExternalDeclaration ExternalDeclaration_47_Var
		 = (ExternalDeclaration)External_0_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_47_Var
		);
		//47
		final Declaration Declaration_48_Var
		 = (Declaration)ExternalDeclaration_47_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_48_Var
		);
		//48
		final DeclarationSpecifiers DeclarationSpecifiers_49_Var
		 = (DeclarationSpecifiers)Declaration_48_Var
		.getSpecifiers();
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
		Assert.assertEquals("char", TypeSpecifier_50_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_50_list = Declaration_48_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_50_list);
		Assert.assertEquals(1, InitDeclaratorList_50_list.size());
		//50
		final InitDeclaratorList InitDeclaratorList_51_Var
		 = (InitDeclaratorList)InitDeclaratorList_50_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_51_Var
		);
		final EList<? extends EObject> InitDeclarator_51_list = InitDeclaratorList_51_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_51_list);
		Assert.assertEquals(1, InitDeclarator_51_list.size());
		//51
		final InitDeclarator InitDeclarator_52_Var
		 = (InitDeclarator)InitDeclarator_51_list.get(0);
		Assert.assertNotNull(InitDeclarator_52_Var
		);
		//52
		final Declarator Declarator_53_Var
		 = (Declarator)InitDeclarator_52_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_53_Var
		);
		//53
		final DirectDeclarator DirectDeclarator_54_Var
		 = (DirectDeclarator)Declarator_53_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_54_Var
		);
		Assert.assertEquals("do4", DirectDeclarator_54_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_54_list = DirectDeclarator_54_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_54_list);
		Assert.assertEquals(1, DeclaratorSuffix_54_list.size());
		//54
		final DeclaratorSuffix DeclaratorSuffix_55_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_54_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_55_Var
		);
		//55
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_56_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_55_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_56_Var
		);
		final EList<? extends EObject> ParameterTypeList_56_list = DirectDeclaratorLastSuffix_56_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_56_list);
		Assert.assertEquals(1, ParameterTypeList_56_list.size());
		//56
		final ParameterTypeList ParameterTypeList_57_Var
		 = (ParameterTypeList)ParameterTypeList_56_list.get(0);
		Assert.assertNotNull(ParameterTypeList_57_Var
		);
		//57
		final ParameterList ParameterList_58_Var
		 = (ParameterList)ParameterTypeList_57_Var
		.getList();
		Assert.assertNotNull(ParameterList_58_Var
		);
		final EList<? extends EObject> ParameterDeclaration_58_list = ParameterList_58_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_58_list);
		Assert.assertEquals(1, ParameterDeclaration_58_list.size());
		//58
		final ParameterDeclaration ParameterDeclaration_59_Var
		 = (ParameterDeclaration)ParameterDeclaration_58_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_59_Var
		);
		//59
		final DeclarationSpecifiers DeclarationSpecifiers_60_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_59_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_60_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_60_list = DeclarationSpecifiers_60_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_60_list);
		Assert.assertEquals(1, DeclarationSpecifier_60_list.size());
		//60
		final TypeSpecifier TypeSpecifier_61_Var
		 = (TypeSpecifier)DeclarationSpecifier_60_list.get(0);
		Assert.assertNotNull(TypeSpecifier_61_Var
		);
		//61
		final StructOrUnionSpecifier StructOrUnionSpecifier_62_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_61_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_62_Var
		);
		//62
		final StructOrUnion StructOrUnion_63_Var
		 = (StructOrUnion)StructOrUnionSpecifier_62_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_63_Var
		);
		Assert.assertEquals("struct", StructOrUnion_63_Var
		.getName());
		Assert.assertEquals("STRUCT", StructOrUnionSpecifier_62_Var
		.getId());
		Assert.assertNull(StructOrUnionSpecifier_62_Var
		.getStructDeclList());
		//63
		final AbstractDeclarator AbstractDeclarator_64_Var
		 = (AbstractDeclarator)ParameterDeclaration_59_Var
		.getAbstractDeclator();
		Assert.assertNotNull(AbstractDeclarator_64_Var
		);
		//64
		final Pointer Pointer_65_Var
		 = (Pointer)AbstractDeclarator_64_Var
		.getPointer();
		Assert.assertNotNull(Pointer_65_Var
		);
		Assert.assertEquals("[*]", Pointer_65_Var
		.getStar().toString());
		Assert.assertEquals(";", Declaration_48_Var
		.getSemi());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0045_FunctionDeclsStruct.c");
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
				method.invoke(this.generator, "Test0045_FunctionDeclsStruct.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0045_FunctionDeclsStruct.c");
		final String expected = this.getTextFromFile(
			"res/Test0045_FunctionDeclsStruct.c"
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


