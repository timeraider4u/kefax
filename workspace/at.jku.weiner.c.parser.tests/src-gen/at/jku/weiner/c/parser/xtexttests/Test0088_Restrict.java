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
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Pointer;
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
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.ConstantExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Pointer;
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
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.ConstantExpression;
import at.jku.weiner.c.parser.parser.Pointer;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0088_Restrict {
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
			"res/Test0088_Restrict.c");
			final String[] expected = new String[] {
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_SKW_STAR",
				"RULE_WHITESPACE",
				"RULE_KW_RESTRICT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_KW_CHAR",
				"RULE_WHITESPACE",
				"RULE_SKW_STAR",
				"RULE_SKW_STAR",
				"RULE_WHITESPACE",
				"RULE_KW_RESTRICT2",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_SKW_STAR",
				"RULE_WHITESPACE",
				"RULE_KW_RESTRICT3",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTBRACKET",
				"RULE_KW_RESTRICT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_SKW_LEFTBRACKET",
				"RULE_ID",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTBRACKET",
				"RULE_KW_RESTRICT2",
				"RULE_SKW_RIGHTBRACKET",
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
			"res/Test0088_Restrict.c");
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
		Assert.assertEquals(3, External_0_list.size());
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
		Assert.assertEquals("void", TypeSpecifier_4_Var
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
		Assert.assertEquals("do1", DirectDeclarator_8_Var
		.getIdent());
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
		Assert.assertEquals(3, ParameterDeclaration_12_list.size());
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
		final DirectDeclarator DirectDeclarator_17_Var
		 = (DirectDeclarator)Declarator_16_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_17_Var
		);
		Assert.assertEquals("argc", DirectDeclarator_17_Var
		.getIdent());
		//17
		final Pointer Pointer_18_Var
		 = (Pointer)Declarator_16_Var
		.getPointer();
		Assert.assertNotNull(Pointer_18_Var
		);
		Assert.assertEquals("[*]", Pointer_18_Var
		.getStar().toString());
		//18
		final ParameterDeclaration ParameterDeclaration_19_Var
		 = (ParameterDeclaration)ParameterDeclaration_12_list.get(1);
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
		Assert.assertEquals("char", TypeSpecifier_21_Var
		.getName());
		//21
		final Declarator Declarator_22_Var
		 = (Declarator)ParameterDeclaration_19_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_22_Var
		);
		//22
		final DirectDeclarator DirectDeclarator_23_Var
		 = (DirectDeclarator)Declarator_22_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_23_Var
		);
		Assert.assertEquals("argv", DirectDeclarator_23_Var
		.getIdent());
		//23
		final Pointer Pointer_24_Var
		 = (Pointer)Declarator_22_Var
		.getPointer();
		Assert.assertNotNull(Pointer_24_Var
		);
		Assert.assertEquals("[*, *]", Pointer_24_Var
		.getStar().toString());
		//24
		final ParameterDeclaration ParameterDeclaration_25_Var
		 = (ParameterDeclaration)ParameterDeclaration_12_list.get(2);
		Assert.assertNotNull(ParameterDeclaration_25_Var
		);
		//25
		final DeclarationSpecifiers DeclarationSpecifiers_26_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_25_Var
		.getDeclSpecifiers();
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
		Assert.assertEquals("int", TypeSpecifier_27_Var
		.getName());
		//27
		final Declarator Declarator_28_Var
		 = (Declarator)ParameterDeclaration_25_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_28_Var
		);
		//28
		final DirectDeclarator DirectDeclarator_29_Var
		 = (DirectDeclarator)Declarator_28_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_29_Var
		);
		Assert.assertEquals("num", DirectDeclarator_29_Var
		.getIdent());
		//29
		final Pointer Pointer_30_Var
		 = (Pointer)Declarator_28_Var
		.getPointer();
		Assert.assertNotNull(Pointer_30_Var
		);
		Assert.assertEquals("[*]", Pointer_30_Var
		.getStar().toString());
		//30
		final ExternalDeclaration ExternalDeclaration_31_Var
		 = (ExternalDeclaration)External_0_list.get(1);
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
		Assert.assertEquals("void", TypeSpecifier_34_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_34_list = Declaration_32_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_34_list);
		Assert.assertEquals(1, InitDeclaratorList_34_list.size());
		//34
		final InitDeclaratorList InitDeclaratorList_35_Var
		 = (InitDeclaratorList)InitDeclaratorList_34_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_35_Var
		);
		final EList<? extends EObject> InitDeclarator_35_list = InitDeclaratorList_35_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_35_list);
		Assert.assertEquals(1, InitDeclarator_35_list.size());
		//35
		final InitDeclarator InitDeclarator_36_Var
		 = (InitDeclarator)InitDeclarator_35_list.get(0);
		Assert.assertNotNull(InitDeclarator_36_Var
		);
		//36
		final Declarator Declarator_37_Var
		 = (Declarator)InitDeclarator_36_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_37_Var
		);
		//37
		final DirectDeclarator DirectDeclarator_38_Var
		 = (DirectDeclarator)Declarator_37_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_38_Var
		);
		Assert.assertEquals("do2", DirectDeclarator_38_Var
		.getIdent());
		final EList<? extends EObject> DeclaratorSuffix_38_list = DirectDeclarator_38_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_38_list);
		Assert.assertEquals(1, DeclaratorSuffix_38_list.size());
		//38
		final DeclaratorSuffix DeclaratorSuffix_39_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_38_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_39_Var
		);
		//39
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_40_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_39_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_40_Var
		);
		final EList<? extends EObject> ParameterTypeList_40_list = DirectDeclaratorLastSuffix_40_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_40_list);
		Assert.assertEquals(1, ParameterTypeList_40_list.size());
		//40
		final ParameterTypeList ParameterTypeList_41_Var
		 = (ParameterTypeList)ParameterTypeList_40_list.get(0);
		Assert.assertNotNull(ParameterTypeList_41_Var
		);
		//41
		final ParameterList ParameterList_42_Var
		 = (ParameterList)ParameterTypeList_41_Var
		.getList();
		Assert.assertNotNull(ParameterList_42_Var
		);
		final EList<? extends EObject> ParameterDeclaration_42_list = ParameterList_42_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_42_list);
		Assert.assertEquals(3, ParameterDeclaration_42_list.size());
		//42
		final ParameterDeclaration ParameterDeclaration_43_Var
		 = (ParameterDeclaration)ParameterDeclaration_42_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_43_Var
		);
		//43
		final DeclarationSpecifiers DeclarationSpecifiers_44_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_43_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_44_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_44_list = DeclarationSpecifiers_44_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_44_list);
		Assert.assertEquals(1, DeclarationSpecifier_44_list.size());
		//44
		final TypeSpecifier TypeSpecifier_45_Var
		 = (TypeSpecifier)DeclarationSpecifier_44_list.get(0);
		Assert.assertNotNull(TypeSpecifier_45_Var
		);
		Assert.assertEquals("int", TypeSpecifier_45_Var
		.getName());
		//45
		final Declarator Declarator_46_Var
		 = (Declarator)ParameterDeclaration_43_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_46_Var
		);
		//46
		final DirectDeclarator DirectDeclarator_47_Var
		 = (DirectDeclarator)Declarator_46_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_47_Var
		);
		Assert.assertEquals("a", DirectDeclarator_47_Var
		.getIdent());
		//47
		final Pointer Pointer_48_Var
		 = (Pointer)Declarator_46_Var
		.getPointer();
		Assert.assertNotNull(Pointer_48_Var
		);
		Assert.assertTrue(Pointer_48_Var
		.getStar().isEmpty());
		//48
		final ParameterDeclaration ParameterDeclaration_49_Var
		 = (ParameterDeclaration)ParameterDeclaration_42_list.get(1);
		Assert.assertNotNull(ParameterDeclaration_49_Var
		);
		//49
		final DeclarationSpecifiers DeclarationSpecifiers_50_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_49_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_50_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_50_list = DeclarationSpecifiers_50_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_50_list);
		Assert.assertEquals(1, DeclarationSpecifier_50_list.size());
		//50
		final TypeSpecifier TypeSpecifier_51_Var
		 = (TypeSpecifier)DeclarationSpecifier_50_list.get(0);
		Assert.assertNotNull(TypeSpecifier_51_Var
		);
		Assert.assertEquals("int", TypeSpecifier_51_Var
		.getName());
		//51
		final Declarator Declarator_52_Var
		 = (Declarator)ParameterDeclaration_49_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_52_Var
		);
		//52
		final DirectDeclarator DirectDeclarator_53_Var
		 = (DirectDeclarator)Declarator_52_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_53_Var
		);
		Assert.assertEquals("b", DirectDeclarator_53_Var
		.getIdent());
		//53
		final Pointer Pointer_54_Var
		 = (Pointer)Declarator_52_Var
		.getPointer();
		Assert.assertNotNull(Pointer_54_Var
		);
		Assert.assertTrue(Pointer_54_Var
		.getStar().isEmpty());
		//54
		final ParameterDeclaration ParameterDeclaration_55_Var
		 = (ParameterDeclaration)ParameterDeclaration_42_list.get(2);
		Assert.assertNotNull(ParameterDeclaration_55_Var
		);
		//55
		final DeclarationSpecifiers DeclarationSpecifiers_56_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_55_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_56_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_56_list = DeclarationSpecifiers_56_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_56_list);
		Assert.assertEquals(1, DeclarationSpecifier_56_list.size());
		//56
		final TypeSpecifier TypeSpecifier_57_Var
		 = (TypeSpecifier)DeclarationSpecifier_56_list.get(0);
		Assert.assertNotNull(TypeSpecifier_57_Var
		);
		Assert.assertEquals("int", TypeSpecifier_57_Var
		.getName());
		//57
		final Declarator Declarator_58_Var
		 = (Declarator)ParameterDeclaration_55_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_58_Var
		);
		//58
		final DirectDeclarator DirectDeclarator_59_Var
		 = (DirectDeclarator)Declarator_58_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_59_Var
		);
		Assert.assertEquals("array", DirectDeclarator_59_Var
		.getIdent());
		final EList<? extends EObject> DeclaratorSuffix_59_list = DirectDeclarator_59_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_59_list);
		Assert.assertEquals(2, DeclaratorSuffix_59_list.size());
		//59
		final DeclaratorSuffix DeclaratorSuffix_60_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_59_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_60_Var
		);
		//60
		final ConstantExpression ConstantExpression_61_Var
		 = (ConstantExpression)DeclaratorSuffix_60_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_61_Var
		);
		Assert.assertEquals("restrict", ConstantExpression_61_Var
		.getRestrict());
		//61
		final PrimaryExpression PrimaryExpression_62_Var
		 = (PrimaryExpression)ConstantExpression_61_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_62_Var
		);
		Assert.assertEquals("a", PrimaryExpression_62_Var
		.getIdent());
		//62
		final DeclaratorSuffix DeclaratorSuffix_63_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_59_list.get(1);
		Assert.assertNotNull(DeclaratorSuffix_63_Var
		);
		//63
		final PrimaryExpression PrimaryExpression_64_Var
		 = (PrimaryExpression)DeclaratorSuffix_63_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_64_Var
		);
		Assert.assertEquals("b", PrimaryExpression_64_Var
		.getIdent());
		//64
		final Pointer Pointer_65_Var
		 = (Pointer)Declarator_58_Var
		.getPointer();
		Assert.assertNotNull(Pointer_65_Var
		);
		Assert.assertTrue(Pointer_65_Var
		.getStar().isEmpty());
		//65
		final ExternalDeclaration ExternalDeclaration_66_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_66_Var
		);
		//66
		final Declaration Declaration_67_Var
		 = (Declaration)ExternalDeclaration_66_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_67_Var
		);
		//67
		final DeclarationSpecifiers DeclarationSpecifiers_68_Var
		 = (DeclarationSpecifiers)Declaration_67_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_68_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_68_list = DeclarationSpecifiers_68_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_68_list);
		Assert.assertEquals(1, DeclarationSpecifier_68_list.size());
		//68
		final TypeSpecifier TypeSpecifier_69_Var
		 = (TypeSpecifier)DeclarationSpecifier_68_list.get(0);
		Assert.assertNotNull(TypeSpecifier_69_Var
		);
		Assert.assertEquals("void", TypeSpecifier_69_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_69_list = Declaration_67_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_69_list);
		Assert.assertEquals(1, InitDeclaratorList_69_list.size());
		//69
		final InitDeclaratorList InitDeclaratorList_70_Var
		 = (InitDeclaratorList)InitDeclaratorList_69_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_70_Var
		);
		final EList<? extends EObject> InitDeclarator_70_list = InitDeclaratorList_70_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_70_list);
		Assert.assertEquals(1, InitDeclarator_70_list.size());
		//70
		final InitDeclarator InitDeclarator_71_Var
		 = (InitDeclarator)InitDeclarator_70_list.get(0);
		Assert.assertNotNull(InitDeclarator_71_Var
		);
		//71
		final Declarator Declarator_72_Var
		 = (Declarator)InitDeclarator_71_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_72_Var
		);
		//72
		final DirectDeclarator DirectDeclarator_73_Var
		 = (DirectDeclarator)Declarator_72_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_73_Var
		);
		Assert.assertEquals("do3", DirectDeclarator_73_Var
		.getIdent());
		final EList<? extends EObject> DeclaratorSuffix_73_list = DirectDeclarator_73_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_73_list);
		Assert.assertEquals(1, DeclaratorSuffix_73_list.size());
		//73
		final DeclaratorSuffix DeclaratorSuffix_74_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_73_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_74_Var
		);
		//74
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_75_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_74_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_75_Var
		);
		final EList<? extends EObject> ParameterTypeList_75_list = DirectDeclaratorLastSuffix_75_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_75_list);
		Assert.assertEquals(1, ParameterTypeList_75_list.size());
		//75
		final ParameterTypeList ParameterTypeList_76_Var
		 = (ParameterTypeList)ParameterTypeList_75_list.get(0);
		Assert.assertNotNull(ParameterTypeList_76_Var
		);
		//76
		final ParameterList ParameterList_77_Var
		 = (ParameterList)ParameterTypeList_76_Var
		.getList();
		Assert.assertNotNull(ParameterList_77_Var
		);
		final EList<? extends EObject> ParameterDeclaration_77_list = ParameterList_77_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_77_list);
		Assert.assertEquals(1, ParameterDeclaration_77_list.size());
		//77
		final ParameterDeclaration ParameterDeclaration_78_Var
		 = (ParameterDeclaration)ParameterDeclaration_77_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_78_Var
		);
		//78
		final DeclarationSpecifiers DeclarationSpecifiers_79_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_78_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_79_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_79_list = DeclarationSpecifiers_79_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_79_list);
		Assert.assertEquals(1, DeclarationSpecifier_79_list.size());
		//79
		final TypeSpecifier TypeSpecifier_80_Var
		 = (TypeSpecifier)DeclarationSpecifier_79_list.get(0);
		Assert.assertNotNull(TypeSpecifier_80_Var
		);
		Assert.assertEquals("int", TypeSpecifier_80_Var
		.getName());
		//80
		final Declarator Declarator_81_Var
		 = (Declarator)ParameterDeclaration_78_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_81_Var
		);
		//81
		final DirectDeclarator DirectDeclarator_82_Var
		 = (DirectDeclarator)Declarator_81_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_82_Var
		);
		Assert.assertEquals("array", DirectDeclarator_82_Var
		.getIdent());
		final EList<? extends EObject> DeclaratorSuffix_82_list = DirectDeclarator_82_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_82_list);
		Assert.assertEquals(1, DeclaratorSuffix_82_list.size());
		//82
		final DeclaratorSuffix DeclaratorSuffix_83_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_82_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_83_Var
		);
		//83
		final ConstantExpression ConstantExpression_84_Var
		 = (ConstantExpression)DeclaratorSuffix_83_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_84_Var
		);
		Assert.assertEquals("__restrict", ConstantExpression_84_Var
		.getRestrict());
		//84
		final Pointer Pointer_85_Var
		 = (Pointer)Declarator_81_Var
		.getPointer();
		Assert.assertNotNull(Pointer_85_Var
		);
		Assert.assertTrue(Pointer_85_Var
		.getStar().isEmpty());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0088_Restrict.c");
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
				method.invoke(this.generator, "Test0088_Restrict.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0088_Restrict.c");
		final String expected = this.getTextFromFile(
			"res/Test0088_Restrict.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
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


