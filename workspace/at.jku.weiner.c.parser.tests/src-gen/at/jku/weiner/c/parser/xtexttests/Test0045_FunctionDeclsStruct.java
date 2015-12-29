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
import at.jku.weiner.c.parser.parser.StructOrUnionName;
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
import at.jku.weiner.c.parser.parser.StructOrUnionName;
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
import at.jku.weiner.c.parser.parser.StructOrUnionName;
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
				"RULE_WHITESPACE", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_KW_CHAR", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
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
		Assert.assertEquals("STRUCT", StructOrUnionSpecifier_4_Var
		.getId());
		Assert.assertNull(StructOrUnionSpecifier_4_Var
		.getStructDeclList());
		//5
		final ExternalDeclaration ExternalDeclaration_6_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_6_Var
		);
		//6
		final Declaration Declaration_7_Var
		 = (Declaration)ExternalDeclaration_6_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_7_Var
		);
		//7
		final DeclarationSpecifiers DeclarationSpecifiers_8_Var
		 = (DeclarationSpecifiers)Declaration_7_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_8_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_8_list = DeclarationSpecifiers_8_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_8_list);
		Assert.assertEquals(1, DeclarationSpecifier_8_list.size());
		//8
		final TypeSpecifier TypeSpecifier_9_Var
		 = (TypeSpecifier)DeclarationSpecifier_8_list.get(0);
		Assert.assertNotNull(TypeSpecifier_9_Var
		);
		Assert.assertEquals("char", TypeSpecifier_9_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_9_list = Declaration_7_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_9_list);
		Assert.assertEquals(1, InitDeclaratorList_9_list.size());
		//9
		final InitDeclaratorList InitDeclaratorList_10_Var
		 = (InitDeclaratorList)InitDeclaratorList_9_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_10_Var
		);
		final EList<? extends EObject> InitDeclarator_10_list = InitDeclaratorList_10_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_10_list);
		Assert.assertEquals(1, InitDeclarator_10_list.size());
		//10
		final InitDeclarator InitDeclarator_11_Var
		 = (InitDeclarator)InitDeclarator_10_list.get(0);
		Assert.assertNotNull(InitDeclarator_11_Var
		);
		//11
		final Declarator Declarator_12_Var
		 = (Declarator)InitDeclarator_11_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_12_Var
		);
		//12
		final DirectDeclarator DirectDeclarator_13_Var
		 = (DirectDeclarator)Declarator_12_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_13_Var
		);
		Assert.assertEquals("do2", DirectDeclarator_13_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_13_list = DirectDeclarator_13_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_13_list);
		Assert.assertEquals(1, DeclaratorSuffix_13_list.size());
		//13
		final DeclaratorSuffix DeclaratorSuffix_14_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_13_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_14_Var
		);
		//14
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_15_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_14_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_15_Var
		);
		final EList<? extends EObject> ParameterTypeList_15_list = DirectDeclaratorLastSuffix_15_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_15_list);
		Assert.assertEquals(1, ParameterTypeList_15_list.size());
		//15
		final ParameterTypeList ParameterTypeList_16_Var
		 = (ParameterTypeList)ParameterTypeList_15_list.get(0);
		Assert.assertNotNull(ParameterTypeList_16_Var
		);
		//16
		final ParameterList ParameterList_17_Var
		 = (ParameterList)ParameterTypeList_16_Var
		.getList();
		Assert.assertNotNull(ParameterList_17_Var
		);
		final EList<? extends EObject> ParameterDeclaration_17_list = ParameterList_17_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_17_list);
		Assert.assertEquals(1, ParameterDeclaration_17_list.size());
		//17
		final ParameterDeclaration ParameterDeclaration_18_Var
		 = (ParameterDeclaration)ParameterDeclaration_17_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_18_Var
		);
		//18
		final DeclarationSpecifiers DeclarationSpecifiers_19_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_18_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_19_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_19_list = DeclarationSpecifiers_19_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_19_list);
		Assert.assertEquals(1, DeclarationSpecifier_19_list.size());
		//19
		final TypeSpecifier TypeSpecifier_20_Var
		 = (TypeSpecifier)DeclarationSpecifier_19_list.get(0);
		Assert.assertNotNull(TypeSpecifier_20_Var
		);
		//20
		final StructOrUnionName StructOrUnionName_21_Var
		 = (StructOrUnionName)TypeSpecifier_20_Var
		.getStruct();
		Assert.assertNotNull(StructOrUnionName_21_Var
		);
		Assert.assertEquals("STRUCT", StructOrUnionName_21_Var
		.getId());
		//21
		final Declarator Declarator_22_Var
		 = (Declarator)ParameterDeclaration_18_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_22_Var
		);
		//22
		final Pointer Pointer_23_Var
		 = (Pointer)Declarator_22_Var
		.getPointer();
		Assert.assertNotNull(Pointer_23_Var
		);
		//23
		final DirectDeclarator DirectDeclarator_24_Var
		 = (DirectDeclarator)Declarator_22_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_24_Var
		);
		Assert.assertEquals("s", DirectDeclarator_24_Var
		.getId());
		Assert.assertEquals(";", Declaration_7_Var
		.getSemi());
		//24
		final ExternalDeclaration ExternalDeclaration_25_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_25_Var
		);
		//25
		final Declaration Declaration_26_Var
		 = (Declaration)ExternalDeclaration_25_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_26_Var
		);
		//26
		final DeclarationSpecifiers DeclarationSpecifiers_27_Var
		 = (DeclarationSpecifiers)Declaration_26_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_27_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_27_list = DeclarationSpecifiers_27_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_27_list);
		Assert.assertEquals(1, DeclarationSpecifier_27_list.size());
		//27
		final TypeSpecifier TypeSpecifier_28_Var
		 = (TypeSpecifier)DeclarationSpecifier_27_list.get(0);
		Assert.assertNotNull(TypeSpecifier_28_Var
		);
		Assert.assertEquals("char", TypeSpecifier_28_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_28_list = Declaration_26_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_28_list);
		Assert.assertEquals(1, InitDeclaratorList_28_list.size());
		//28
		final InitDeclaratorList InitDeclaratorList_29_Var
		 = (InitDeclaratorList)InitDeclaratorList_28_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_29_Var
		);
		final EList<? extends EObject> InitDeclarator_29_list = InitDeclaratorList_29_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_29_list);
		Assert.assertEquals(1, InitDeclarator_29_list.size());
		//29
		final InitDeclarator InitDeclarator_30_Var
		 = (InitDeclarator)InitDeclarator_29_list.get(0);
		Assert.assertNotNull(InitDeclarator_30_Var
		);
		//30
		final Declarator Declarator_31_Var
		 = (Declarator)InitDeclarator_30_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_31_Var
		);
		//31
		final DirectDeclarator DirectDeclarator_32_Var
		 = (DirectDeclarator)Declarator_31_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_32_Var
		);
		Assert.assertEquals("do3", DirectDeclarator_32_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_32_list = DirectDeclarator_32_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_32_list);
		Assert.assertEquals(1, DeclaratorSuffix_32_list.size());
		//32
		final DeclaratorSuffix DeclaratorSuffix_33_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_32_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_33_Var
		);
		//33
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_34_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_33_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_34_Var
		);
		final EList<? extends EObject> ParameterTypeList_34_list = DirectDeclaratorLastSuffix_34_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_34_list);
		Assert.assertEquals(1, ParameterTypeList_34_list.size());
		//34
		final ParameterTypeList ParameterTypeList_35_Var
		 = (ParameterTypeList)ParameterTypeList_34_list.get(0);
		Assert.assertNotNull(ParameterTypeList_35_Var
		);
		//35
		final ParameterList ParameterList_36_Var
		 = (ParameterList)ParameterTypeList_35_Var
		.getList();
		Assert.assertNotNull(ParameterList_36_Var
		);
		final EList<? extends EObject> ParameterDeclaration_36_list = ParameterList_36_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_36_list);
		Assert.assertEquals(1, ParameterDeclaration_36_list.size());
		//36
		final ParameterDeclaration ParameterDeclaration_37_Var
		 = (ParameterDeclaration)ParameterDeclaration_36_list.get(0);
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
		final StructOrUnionName StructOrUnionName_40_Var
		 = (StructOrUnionName)TypeSpecifier_39_Var
		.getStruct();
		Assert.assertNotNull(StructOrUnionName_40_Var
		);
		Assert.assertEquals("STRUCT", StructOrUnionName_40_Var
		.getId());
		//40
		final Declarator Declarator_41_Var
		 = (Declarator)ParameterDeclaration_37_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_41_Var
		);
		//41
		final Pointer Pointer_42_Var
		 = (Pointer)Declarator_41_Var
		.getPointer();
		Assert.assertNotNull(Pointer_42_Var
		);
		Assert.assertEquals("[*]", Pointer_42_Var
		.getStar().toString());
		//42
		final DirectDeclarator DirectDeclarator_43_Var
		 = (DirectDeclarator)Declarator_41_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_43_Var
		);
		Assert.assertEquals("s", DirectDeclarator_43_Var
		.getId());
		Assert.assertEquals(";", Declaration_26_Var
		.getSemi());
		//43
		final ExternalDeclaration ExternalDeclaration_44_Var
		 = (ExternalDeclaration)External_0_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_44_Var
		);
		//44
		final Declaration Declaration_45_Var
		 = (Declaration)ExternalDeclaration_44_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_45_Var
		);
		//45
		final DeclarationSpecifiers DeclarationSpecifiers_46_Var
		 = (DeclarationSpecifiers)Declaration_45_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_46_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_46_list = DeclarationSpecifiers_46_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_46_list);
		Assert.assertEquals(1, DeclarationSpecifier_46_list.size());
		//46
		final TypeSpecifier TypeSpecifier_47_Var
		 = (TypeSpecifier)DeclarationSpecifier_46_list.get(0);
		Assert.assertNotNull(TypeSpecifier_47_Var
		);
		Assert.assertEquals("char", TypeSpecifier_47_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_47_list = Declaration_45_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_47_list);
		Assert.assertEquals(1, InitDeclaratorList_47_list.size());
		//47
		final InitDeclaratorList InitDeclaratorList_48_Var
		 = (InitDeclaratorList)InitDeclaratorList_47_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_48_Var
		);
		final EList<? extends EObject> InitDeclarator_48_list = InitDeclaratorList_48_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_48_list);
		Assert.assertEquals(1, InitDeclarator_48_list.size());
		//48
		final InitDeclarator InitDeclarator_49_Var
		 = (InitDeclarator)InitDeclarator_48_list.get(0);
		Assert.assertNotNull(InitDeclarator_49_Var
		);
		//49
		final Declarator Declarator_50_Var
		 = (Declarator)InitDeclarator_49_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_50_Var
		);
		//50
		final DirectDeclarator DirectDeclarator_51_Var
		 = (DirectDeclarator)Declarator_50_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_51_Var
		);
		Assert.assertEquals("do4", DirectDeclarator_51_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_51_list = DirectDeclarator_51_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_51_list);
		Assert.assertEquals(1, DeclaratorSuffix_51_list.size());
		//51
		final DeclaratorSuffix DeclaratorSuffix_52_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_51_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_52_Var
		);
		//52
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_53_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_52_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_53_Var
		);
		final EList<? extends EObject> ParameterTypeList_53_list = DirectDeclaratorLastSuffix_53_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_53_list);
		Assert.assertEquals(1, ParameterTypeList_53_list.size());
		//53
		final ParameterTypeList ParameterTypeList_54_Var
		 = (ParameterTypeList)ParameterTypeList_53_list.get(0);
		Assert.assertNotNull(ParameterTypeList_54_Var
		);
		//54
		final ParameterList ParameterList_55_Var
		 = (ParameterList)ParameterTypeList_54_Var
		.getList();
		Assert.assertNotNull(ParameterList_55_Var
		);
		final EList<? extends EObject> ParameterDeclaration_55_list = ParameterList_55_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_55_list);
		Assert.assertEquals(1, ParameterDeclaration_55_list.size());
		//55
		final ParameterDeclaration ParameterDeclaration_56_Var
		 = (ParameterDeclaration)ParameterDeclaration_55_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_56_Var
		);
		//56
		final DeclarationSpecifiers DeclarationSpecifiers_57_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_56_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_57_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_57_list = DeclarationSpecifiers_57_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_57_list);
		Assert.assertEquals(1, DeclarationSpecifier_57_list.size());
		//57
		final TypeSpecifier TypeSpecifier_58_Var
		 = (TypeSpecifier)DeclarationSpecifier_57_list.get(0);
		Assert.assertNotNull(TypeSpecifier_58_Var
		);
		//58
		final StructOrUnionName StructOrUnionName_59_Var
		 = (StructOrUnionName)TypeSpecifier_58_Var
		.getStruct();
		Assert.assertNotNull(StructOrUnionName_59_Var
		);
		Assert.assertEquals("STRUCT", StructOrUnionName_59_Var
		.getId());
		//59
		final AbstractDeclarator AbstractDeclarator_60_Var
		 = (AbstractDeclarator)ParameterDeclaration_56_Var
		.getAbstractDeclator();
		Assert.assertNotNull(AbstractDeclarator_60_Var
		);
		//60
		final Pointer Pointer_61_Var
		 = (Pointer)AbstractDeclarator_60_Var
		.getPointer();
		Assert.assertNotNull(Pointer_61_Var
		);
		Assert.assertEquals("[*]", Pointer_61_Var
		.getStar().toString());
		Assert.assertEquals(";", Declaration_45_Var
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


