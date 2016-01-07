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
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.ParameterTypeList;
import at.jku.weiner.c.parser.parser.ParameterList;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.GccDeclaratorExtension;
import at.jku.weiner.c.parser.parser.GccAttributeSpecifier;
import at.jku.weiner.c.parser.parser.GccAttributeList;
import at.jku.weiner.c.parser.parser.GccAttribute;
import at.jku.weiner.c.parser.parser.GccAttribute;
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
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.GccDeclaratorExtension;
import at.jku.weiner.c.parser.parser.GccAttributeSpecifier;
import at.jku.weiner.c.parser.parser.GccAttributeList;
import at.jku.weiner.c.parser.parser.GccAttribute;
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
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.GccDeclaratorExtension;
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
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.GccDeclaratorExtension;
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
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.GccDeclaratorExtension;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0046_FunctionDeclsWithGccExts {
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
			"res/Test0046_FunctionDeclsWithGccExts.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_CHAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_KW_ATTRIBUTE",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_KW_CHAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_KW_ATTRIBUTE",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_KW_CHAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_KW_ASM1",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_KW_CHAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_KW_ASM2",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_KW_CHAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_KW_ASM3",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
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
			"res/Test0046_FunctionDeclsWithGccExts.c");
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
		Assert.assertEquals(5, External_0_list.size());
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
		Assert.assertEquals("char", TypeSpecifier_4_Var
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
		Assert.assertEquals("do2", DirectDeclarator_8_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_8_list = DirectDeclarator_8_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_8_list);
		Assert.assertEquals(1, DeclaratorSuffix_8_list.size());
		//8
		final DeclaratorSuffix DeclaratorSuffix_9_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_8_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_9_Var
		);
		//9
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_10_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_9_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_10_Var
		);
		final EList<? extends EObject> ParameterTypeList_10_list = DirectDeclaratorLastSuffix_10_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_10_list);
		Assert.assertEquals(1, ParameterTypeList_10_list.size());
		//10
		final ParameterTypeList ParameterTypeList_11_Var
		 = (ParameterTypeList)ParameterTypeList_10_list.get(0);
		Assert.assertNotNull(ParameterTypeList_11_Var
		);
		//11
		final ParameterList ParameterList_12_Var
		 = (ParameterList)ParameterTypeList_11_Var
		.getList();
		Assert.assertNotNull(ParameterList_12_Var
		);
		final EList<? extends EObject> ParameterDeclaration_12_list = ParameterList_12_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_12_list);
		Assert.assertEquals(1, ParameterDeclaration_12_list.size());
		//12
		final ParameterDeclaration ParameterDeclaration_13_Var
		 = (ParameterDeclaration)ParameterDeclaration_12_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_13_Var
		);
		//13
		final DeclarationSpecifiers DeclarationSpecifiers_14_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_13_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_14_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_14_list = DeclarationSpecifiers_14_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_14_list);
		Assert.assertEquals(1, DeclarationSpecifier_14_list.size());
		//14
		final TypeSpecifier TypeSpecifier_15_Var
		 = (TypeSpecifier)DeclarationSpecifier_14_list.get(0);
		Assert.assertNotNull(TypeSpecifier_15_Var
		);
		Assert.assertEquals("int", TypeSpecifier_15_Var
		.getName());
		//15
		final Declarator Declarator_16_Var
		 = (Declarator)ParameterDeclaration_13_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_16_Var
		);
		//16
		final Pointer Pointer_17_Var
		 = (Pointer)Declarator_16_Var
		.getPointer();
		Assert.assertNotNull(Pointer_17_Var
		);
		//17
		final DirectDeclarator DirectDeclarator_18_Var
		 = (DirectDeclarator)Declarator_16_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_18_Var
		);
		Assert.assertEquals("c", DirectDeclarator_18_Var
		.getId());
		final EList<? extends EObject> GccDeclExt2_18_list = Declarator_7_Var
		.getGccDeclExt2();
		Assert.assertNotNull(GccDeclExt2_18_list);
		Assert.assertEquals(1, GccDeclExt2_18_list.size());
		//18
		final GccDeclaratorExtension GccDeclaratorExtension_19_Var
		 = (GccDeclaratorExtension)GccDeclExt2_18_list.get(0);
		Assert.assertNotNull(GccDeclaratorExtension_19_Var
		);
		//19
		final GccAttributeSpecifier GccAttributeSpecifier_20_Var
		 = (GccAttributeSpecifier)GccDeclaratorExtension_19_Var
		.getGccAttributeSpecifier();
		Assert.assertNotNull(GccAttributeSpecifier_20_Var
		);
		//20
		final GccAttributeList GccAttributeList_21_Var
		 = (GccAttributeList)GccAttributeSpecifier_20_Var
		.getList();
		Assert.assertNotNull(GccAttributeList_21_Var
		);
		final EList<? extends EObject> GccAttribute_21_list = GccAttributeList_21_Var
		.getGccAttribute();
		Assert.assertNotNull(GccAttribute_21_list);
		Assert.assertEquals(2, GccAttribute_21_list.size());
		//21
		final GccAttribute GccAttribute_22_Var
		 = (GccAttribute)GccAttribute_21_list.get(0);
		Assert.assertNotNull(GccAttribute_22_Var
		);
		Assert.assertEquals("__nothrow__", GccAttribute_22_Var
		.getId());
		//22
		final GccAttribute GccAttribute_23_Var
		 = (GccAttribute)GccAttribute_21_list.get(1);
		Assert.assertNotNull(GccAttribute_23_Var
		);
		Assert.assertEquals("__leaf__", GccAttribute_23_Var
		.getId());
		Assert.assertEquals(";", Declaration_2_Var
		.getSemi());
		//23
		final ExternalDeclaration ExternalDeclaration_24_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_24_Var
		);
		//24
		final Declaration Declaration_25_Var
		 = (Declaration)ExternalDeclaration_24_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_25_Var
		);
		//25
		final DeclarationSpecifiers DeclarationSpecifiers_26_Var
		 = (DeclarationSpecifiers)Declaration_25_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_26_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_26_list = DeclarationSpecifiers_26_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_26_list);
		Assert.assertEquals(1, DeclarationSpecifier_26_list.size());
		//26
		final TypeSpecifier TypeSpecifier_27_Var
		 = (TypeSpecifier)DeclarationSpecifier_26_list.get(0);
		Assert.assertNotNull(TypeSpecifier_27_Var
		);
		Assert.assertEquals("char", TypeSpecifier_27_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_27_list = Declaration_25_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_27_list);
		Assert.assertEquals(1, InitDeclaratorList_27_list.size());
		//27
		final InitDeclaratorList InitDeclaratorList_28_Var
		 = (InitDeclaratorList)InitDeclaratorList_27_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_28_Var
		);
		final EList<? extends EObject> InitDeclarator_28_list = InitDeclaratorList_28_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_28_list);
		Assert.assertEquals(1, InitDeclarator_28_list.size());
		//28
		final InitDeclarator InitDeclarator_29_Var
		 = (InitDeclarator)InitDeclarator_28_list.get(0);
		Assert.assertNotNull(InitDeclarator_29_Var
		);
		//29
		final Declarator Declarator_30_Var
		 = (Declarator)InitDeclarator_29_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_30_Var
		);
		//30
		final DirectDeclarator DirectDeclarator_31_Var
		 = (DirectDeclarator)Declarator_30_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_31_Var
		);
		Assert.assertEquals("do1", DirectDeclarator_31_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_31_list = DirectDeclarator_31_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_31_list);
		Assert.assertEquals(1, DeclaratorSuffix_31_list.size());
		//31
		final DeclaratorSuffix DeclaratorSuffix_32_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_31_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_32_Var
		);
		//32
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_33_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_32_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_33_Var
		);
		final EList<? extends EObject> ParameterTypeList_33_list = DirectDeclaratorLastSuffix_33_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_33_list);
		Assert.assertEquals(1, ParameterTypeList_33_list.size());
		//33
		final ParameterTypeList ParameterTypeList_34_Var
		 = (ParameterTypeList)ParameterTypeList_33_list.get(0);
		Assert.assertNotNull(ParameterTypeList_34_Var
		);
		//34
		final ParameterList ParameterList_35_Var
		 = (ParameterList)ParameterTypeList_34_Var
		.getList();
		Assert.assertNotNull(ParameterList_35_Var
		);
		final EList<? extends EObject> ParameterDeclaration_35_list = ParameterList_35_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_35_list);
		Assert.assertEquals(1, ParameterDeclaration_35_list.size());
		//35
		final ParameterDeclaration ParameterDeclaration_36_Var
		 = (ParameterDeclaration)ParameterDeclaration_35_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_36_Var
		);
		//36
		final DeclarationSpecifiers DeclarationSpecifiers_37_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_36_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_37_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_37_list = DeclarationSpecifiers_37_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_37_list);
		Assert.assertEquals(1, DeclarationSpecifier_37_list.size());
		//37
		final TypeSpecifier TypeSpecifier_38_Var
		 = (TypeSpecifier)DeclarationSpecifier_37_list.get(0);
		Assert.assertNotNull(TypeSpecifier_38_Var
		);
		Assert.assertEquals("int", TypeSpecifier_38_Var
		.getName());
		//38
		final Declarator Declarator_39_Var
		 = (Declarator)ParameterDeclaration_36_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_39_Var
		);
		//39
		final Pointer Pointer_40_Var
		 = (Pointer)Declarator_39_Var
		.getPointer();
		Assert.assertNotNull(Pointer_40_Var
		);
		//40
		final DirectDeclarator DirectDeclarator_41_Var
		 = (DirectDeclarator)Declarator_39_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_41_Var
		);
		Assert.assertEquals("c", DirectDeclarator_41_Var
		.getId());
		final EList<? extends EObject> GccDeclExt2_41_list = Declarator_30_Var
		.getGccDeclExt2();
		Assert.assertNotNull(GccDeclExt2_41_list);
		Assert.assertEquals(1, GccDeclExt2_41_list.size());
		//41
		final GccDeclaratorExtension GccDeclaratorExtension_42_Var
		 = (GccDeclaratorExtension)GccDeclExt2_41_list.get(0);
		Assert.assertNotNull(GccDeclaratorExtension_42_Var
		);
		//42
		final GccAttributeSpecifier GccAttributeSpecifier_43_Var
		 = (GccAttributeSpecifier)GccDeclaratorExtension_42_Var
		.getGccAttributeSpecifier();
		Assert.assertNotNull(GccAttributeSpecifier_43_Var
		);
		//43
		final GccAttributeList GccAttributeList_44_Var
		 = (GccAttributeList)GccAttributeSpecifier_43_Var
		.getList();
		Assert.assertNotNull(GccAttributeList_44_Var
		);
		final EList<? extends EObject> GccAttribute_44_list = GccAttributeList_44_Var
		.getGccAttribute();
		Assert.assertNotNull(GccAttribute_44_list);
		Assert.assertEquals(1, GccAttribute_44_list.size());
		//44
		final GccAttribute GccAttribute_45_Var
		 = (GccAttribute)GccAttribute_44_list.get(0);
		Assert.assertNotNull(GccAttribute_45_Var
		);
		Assert.assertEquals("__nothrow__", GccAttribute_45_Var
		.getId());
		Assert.assertEquals(";", Declaration_25_Var
		.getSemi());
		//45
		final ExternalDeclaration ExternalDeclaration_46_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_46_Var
		);
		//46
		final Declaration Declaration_47_Var
		 = (Declaration)ExternalDeclaration_46_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_47_Var
		);
		//47
		final DeclarationSpecifiers DeclarationSpecifiers_48_Var
		 = (DeclarationSpecifiers)Declaration_47_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_48_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_48_list = DeclarationSpecifiers_48_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_48_list);
		Assert.assertEquals(1, DeclarationSpecifier_48_list.size());
		//48
		final TypeSpecifier TypeSpecifier_49_Var
		 = (TypeSpecifier)DeclarationSpecifier_48_list.get(0);
		Assert.assertNotNull(TypeSpecifier_49_Var
		);
		Assert.assertEquals("char", TypeSpecifier_49_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_49_list = Declaration_47_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_49_list);
		Assert.assertEquals(1, InitDeclaratorList_49_list.size());
		//49
		final InitDeclaratorList InitDeclaratorList_50_Var
		 = (InitDeclaratorList)InitDeclaratorList_49_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_50_Var
		);
		final EList<? extends EObject> InitDeclarator_50_list = InitDeclaratorList_50_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_50_list);
		Assert.assertEquals(1, InitDeclarator_50_list.size());
		//50
		final InitDeclarator InitDeclarator_51_Var
		 = (InitDeclarator)InitDeclarator_50_list.get(0);
		Assert.assertNotNull(InitDeclarator_51_Var
		);
		//51
		final Declarator Declarator_52_Var
		 = (Declarator)InitDeclarator_51_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_52_Var
		);
		//52
		final DirectDeclarator DirectDeclarator_53_Var
		 = (DirectDeclarator)Declarator_52_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_53_Var
		);
		Assert.assertEquals("do3", DirectDeclarator_53_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_53_list = DirectDeclarator_53_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_53_list);
		Assert.assertEquals(1, DeclaratorSuffix_53_list.size());
		//53
		final DeclaratorSuffix DeclaratorSuffix_54_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_53_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_54_Var
		);
		//54
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_55_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_54_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_55_Var
		);
		final EList<? extends EObject> ParameterTypeList_55_list = DirectDeclaratorLastSuffix_55_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_55_list);
		Assert.assertEquals(1, ParameterTypeList_55_list.size());
		//55
		final ParameterTypeList ParameterTypeList_56_Var
		 = (ParameterTypeList)ParameterTypeList_55_list.get(0);
		Assert.assertNotNull(ParameterTypeList_56_Var
		);
		//56
		final ParameterList ParameterList_57_Var
		 = (ParameterList)ParameterTypeList_56_Var
		.getList();
		Assert.assertNotNull(ParameterList_57_Var
		);
		final EList<? extends EObject> ParameterDeclaration_57_list = ParameterList_57_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_57_list);
		Assert.assertEquals(1, ParameterDeclaration_57_list.size());
		//57
		final ParameterDeclaration ParameterDeclaration_58_Var
		 = (ParameterDeclaration)ParameterDeclaration_57_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_58_Var
		);
		//58
		final DeclarationSpecifiers DeclarationSpecifiers_59_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_58_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_59_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_59_list = DeclarationSpecifiers_59_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_59_list);
		Assert.assertEquals(1, DeclarationSpecifier_59_list.size());
		//59
		final TypeSpecifier TypeSpecifier_60_Var
		 = (TypeSpecifier)DeclarationSpecifier_59_list.get(0);
		Assert.assertNotNull(TypeSpecifier_60_Var
		);
		Assert.assertEquals("int", TypeSpecifier_60_Var
		.getName());
		//60
		final Declarator Declarator_61_Var
		 = (Declarator)ParameterDeclaration_58_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_61_Var
		);
		//61
		final Pointer Pointer_62_Var
		 = (Pointer)Declarator_61_Var
		.getPointer();
		Assert.assertNotNull(Pointer_62_Var
		);
		//62
		final DirectDeclarator DirectDeclarator_63_Var
		 = (DirectDeclarator)Declarator_61_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_63_Var
		);
		Assert.assertEquals("c", DirectDeclarator_63_Var
		.getId());
		final EList<? extends EObject> GccDeclExt2_63_list = Declarator_52_Var
		.getGccDeclExt2();
		Assert.assertNotNull(GccDeclExt2_63_list);
		Assert.assertEquals(1, GccDeclExt2_63_list.size());
		//63
		final GccDeclaratorExtension GccDeclaratorExtension_64_Var
		 = (GccDeclaratorExtension)GccDeclExt2_63_list.get(0);
		Assert.assertNotNull(GccDeclaratorExtension_64_Var
		);
		Assert.assertEquals("asm", GccDeclaratorExtension_64_Var
		.getAsm());
		Assert.assertEquals("[\"\", \"something\"]", GccDeclaratorExtension_64_Var
		.getString().toString());
		Assert.assertEquals(";", Declaration_47_Var
		.getSemi());
		//64
		final ExternalDeclaration ExternalDeclaration_65_Var
		 = (ExternalDeclaration)External_0_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_65_Var
		);
		//65
		final Declaration Declaration_66_Var
		 = (Declaration)ExternalDeclaration_65_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_66_Var
		);
		//66
		final DeclarationSpecifiers DeclarationSpecifiers_67_Var
		 = (DeclarationSpecifiers)Declaration_66_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_67_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_67_list = DeclarationSpecifiers_67_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_67_list);
		Assert.assertEquals(1, DeclarationSpecifier_67_list.size());
		//67
		final TypeSpecifier TypeSpecifier_68_Var
		 = (TypeSpecifier)DeclarationSpecifier_67_list.get(0);
		Assert.assertNotNull(TypeSpecifier_68_Var
		);
		Assert.assertEquals("char", TypeSpecifier_68_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_68_list = Declaration_66_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_68_list);
		Assert.assertEquals(1, InitDeclaratorList_68_list.size());
		//68
		final InitDeclaratorList InitDeclaratorList_69_Var
		 = (InitDeclaratorList)InitDeclaratorList_68_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_69_Var
		);
		final EList<? extends EObject> InitDeclarator_69_list = InitDeclaratorList_69_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_69_list);
		Assert.assertEquals(1, InitDeclarator_69_list.size());
		//69
		final InitDeclarator InitDeclarator_70_Var
		 = (InitDeclarator)InitDeclarator_69_list.get(0);
		Assert.assertNotNull(InitDeclarator_70_Var
		);
		//70
		final Declarator Declarator_71_Var
		 = (Declarator)InitDeclarator_70_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_71_Var
		);
		//71
		final DirectDeclarator DirectDeclarator_72_Var
		 = (DirectDeclarator)Declarator_71_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_72_Var
		);
		Assert.assertEquals("do4", DirectDeclarator_72_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_72_list = DirectDeclarator_72_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_72_list);
		Assert.assertEquals(1, DeclaratorSuffix_72_list.size());
		//72
		final DeclaratorSuffix DeclaratorSuffix_73_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_72_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_73_Var
		);
		//73
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_74_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_73_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_74_Var
		);
		final EList<? extends EObject> ParameterTypeList_74_list = DirectDeclaratorLastSuffix_74_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_74_list);
		Assert.assertEquals(1, ParameterTypeList_74_list.size());
		//74
		final ParameterTypeList ParameterTypeList_75_Var
		 = (ParameterTypeList)ParameterTypeList_74_list.get(0);
		Assert.assertNotNull(ParameterTypeList_75_Var
		);
		//75
		final ParameterList ParameterList_76_Var
		 = (ParameterList)ParameterTypeList_75_Var
		.getList();
		Assert.assertNotNull(ParameterList_76_Var
		);
		final EList<? extends EObject> ParameterDeclaration_76_list = ParameterList_76_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_76_list);
		Assert.assertEquals(1, ParameterDeclaration_76_list.size());
		//76
		final ParameterDeclaration ParameterDeclaration_77_Var
		 = (ParameterDeclaration)ParameterDeclaration_76_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_77_Var
		);
		//77
		final DeclarationSpecifiers DeclarationSpecifiers_78_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_77_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_78_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_78_list = DeclarationSpecifiers_78_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_78_list);
		Assert.assertEquals(1, DeclarationSpecifier_78_list.size());
		//78
		final TypeSpecifier TypeSpecifier_79_Var
		 = (TypeSpecifier)DeclarationSpecifier_78_list.get(0);
		Assert.assertNotNull(TypeSpecifier_79_Var
		);
		Assert.assertEquals("int", TypeSpecifier_79_Var
		.getName());
		//79
		final Declarator Declarator_80_Var
		 = (Declarator)ParameterDeclaration_77_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_80_Var
		);
		//80
		final Pointer Pointer_81_Var
		 = (Pointer)Declarator_80_Var
		.getPointer();
		Assert.assertNotNull(Pointer_81_Var
		);
		//81
		final DirectDeclarator DirectDeclarator_82_Var
		 = (DirectDeclarator)Declarator_80_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_82_Var
		);
		Assert.assertEquals("c", DirectDeclarator_82_Var
		.getId());
		final EList<? extends EObject> GccDeclExt2_82_list = Declarator_71_Var
		.getGccDeclExt2();
		Assert.assertNotNull(GccDeclExt2_82_list);
		Assert.assertEquals(1, GccDeclExt2_82_list.size());
		//82
		final GccDeclaratorExtension GccDeclaratorExtension_83_Var
		 = (GccDeclaratorExtension)GccDeclExt2_82_list.get(0);
		Assert.assertNotNull(GccDeclaratorExtension_83_Var
		);
		Assert.assertEquals("__asm", GccDeclaratorExtension_83_Var
		.getAsm());
		Assert.assertEquals("[\"\", \"something\"]", GccDeclaratorExtension_83_Var
		.getString().toString());
		Assert.assertEquals(";", Declaration_66_Var
		.getSemi());
		//83
		final ExternalDeclaration ExternalDeclaration_84_Var
		 = (ExternalDeclaration)External_0_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_84_Var
		);
		//84
		final Declaration Declaration_85_Var
		 = (Declaration)ExternalDeclaration_84_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_85_Var
		);
		//85
		final DeclarationSpecifiers DeclarationSpecifiers_86_Var
		 = (DeclarationSpecifiers)Declaration_85_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_86_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_86_list = DeclarationSpecifiers_86_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_86_list);
		Assert.assertEquals(1, DeclarationSpecifier_86_list.size());
		//86
		final TypeSpecifier TypeSpecifier_87_Var
		 = (TypeSpecifier)DeclarationSpecifier_86_list.get(0);
		Assert.assertNotNull(TypeSpecifier_87_Var
		);
		Assert.assertEquals("char", TypeSpecifier_87_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_87_list = Declaration_85_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_87_list);
		Assert.assertEquals(1, InitDeclaratorList_87_list.size());
		//87
		final InitDeclaratorList InitDeclaratorList_88_Var
		 = (InitDeclaratorList)InitDeclaratorList_87_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_88_Var
		);
		final EList<? extends EObject> InitDeclarator_88_list = InitDeclaratorList_88_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_88_list);
		Assert.assertEquals(1, InitDeclarator_88_list.size());
		//88
		final InitDeclarator InitDeclarator_89_Var
		 = (InitDeclarator)InitDeclarator_88_list.get(0);
		Assert.assertNotNull(InitDeclarator_89_Var
		);
		//89
		final Declarator Declarator_90_Var
		 = (Declarator)InitDeclarator_89_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_90_Var
		);
		//90
		final DirectDeclarator DirectDeclarator_91_Var
		 = (DirectDeclarator)Declarator_90_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_91_Var
		);
		Assert.assertEquals("do5", DirectDeclarator_91_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_91_list = DirectDeclarator_91_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_91_list);
		Assert.assertEquals(1, DeclaratorSuffix_91_list.size());
		//91
		final DeclaratorSuffix DeclaratorSuffix_92_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_91_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_92_Var
		);
		//92
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_93_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_92_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_93_Var
		);
		final EList<? extends EObject> ParameterTypeList_93_list = DirectDeclaratorLastSuffix_93_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_93_list);
		Assert.assertEquals(1, ParameterTypeList_93_list.size());
		//93
		final ParameterTypeList ParameterTypeList_94_Var
		 = (ParameterTypeList)ParameterTypeList_93_list.get(0);
		Assert.assertNotNull(ParameterTypeList_94_Var
		);
		//94
		final ParameterList ParameterList_95_Var
		 = (ParameterList)ParameterTypeList_94_Var
		.getList();
		Assert.assertNotNull(ParameterList_95_Var
		);
		final EList<? extends EObject> ParameterDeclaration_95_list = ParameterList_95_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_95_list);
		Assert.assertEquals(1, ParameterDeclaration_95_list.size());
		//95
		final ParameterDeclaration ParameterDeclaration_96_Var
		 = (ParameterDeclaration)ParameterDeclaration_95_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_96_Var
		);
		//96
		final DeclarationSpecifiers DeclarationSpecifiers_97_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_96_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_97_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_97_list = DeclarationSpecifiers_97_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_97_list);
		Assert.assertEquals(1, DeclarationSpecifier_97_list.size());
		//97
		final TypeSpecifier TypeSpecifier_98_Var
		 = (TypeSpecifier)DeclarationSpecifier_97_list.get(0);
		Assert.assertNotNull(TypeSpecifier_98_Var
		);
		Assert.assertEquals("int", TypeSpecifier_98_Var
		.getName());
		//98
		final Declarator Declarator_99_Var
		 = (Declarator)ParameterDeclaration_96_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_99_Var
		);
		//99
		final Pointer Pointer_100_Var
		 = (Pointer)Declarator_99_Var
		.getPointer();
		Assert.assertNotNull(Pointer_100_Var
		);
		//100
		final DirectDeclarator DirectDeclarator_101_Var
		 = (DirectDeclarator)Declarator_99_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_101_Var
		);
		Assert.assertEquals("c", DirectDeclarator_101_Var
		.getId());
		final EList<? extends EObject> GccDeclExt2_101_list = Declarator_90_Var
		.getGccDeclExt2();
		Assert.assertNotNull(GccDeclExt2_101_list);
		Assert.assertEquals(1, GccDeclExt2_101_list.size());
		//101
		final GccDeclaratorExtension GccDeclaratorExtension_102_Var
		 = (GccDeclaratorExtension)GccDeclExt2_101_list.get(0);
		Assert.assertNotNull(GccDeclaratorExtension_102_Var
		);
		Assert.assertEquals("__asm__", GccDeclaratorExtension_102_Var
		.getAsm());
		Assert.assertEquals("[\"\", \"something\"]", GccDeclaratorExtension_102_Var
		.getString().toString());
		Assert.assertEquals(";", Declaration_85_Var
		.getSemi());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0046_FunctionDeclsWithGccExts.c");
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
				method.invoke(this.generator, "Test0046_FunctionDeclsWithGccExts.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0046_FunctionDeclsWithGccExts.c");
		final String expected = this.getTextFromFile(
			"res/Test0046_FunctionDeclsWithGccExts.c"
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


