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
import at.jku.weiner.c.parser.parser.FunctionSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.FunctionSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.FunctionSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.StorageClassSpecifier;
import at.jku.weiner.c.parser.parser.FunctionSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.StorageClassSpecifier;
import at.jku.weiner.c.parser.parser.FunctionSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.StorageClassSpecifier;
import at.jku.weiner.c.parser.parser.FunctionSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0049_Inline {
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
			"res/Test0049_Inline.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_INLINE1",
				"RULE_WHITESPACE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_INLINE2",
				"RULE_WHITESPACE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_INLINE3",
				"RULE_WHITESPACE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_STATIC",
				"RULE_WHITESPACE",
				"RULE_KW_INLINE1",
				"RULE_WHITESPACE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_STATIC",
				"RULE_WHITESPACE",
				"RULE_KW_INLINE2",
				"RULE_WHITESPACE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_STATIC",
				"RULE_WHITESPACE",
				"RULE_KW_INLINE3",
				"RULE_WHITESPACE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0049_Inline.c");
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
		Assert.assertEquals(6, External_0_list.size());
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
		final FunctionSpecifier FunctionSpecifier_4_Var
		 = (FunctionSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(FunctionSpecifier_4_Var
		);
		Assert.assertEquals("inline", FunctionSpecifier_4_Var
		.getName());
		//4
		final TypeSpecifier TypeSpecifier_5_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(1);
		Assert.assertNotNull(TypeSpecifier_5_Var
		);
		Assert.assertEquals("void", TypeSpecifier_5_Var
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
		Assert.assertEquals("doSomethingA1", DirectDeclarator_9_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_9_list = DirectDeclarator_9_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_9_list);
		Assert.assertEquals(1, DeclaratorSuffix_9_list.size());
		//9
		final DeclaratorSuffix DeclaratorSuffix_10_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_9_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_10_Var
		);
		//10
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_11_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_10_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_11_Var
		);
		Assert.assertEquals(";", Declaration_2_Var
		.getSemi());
		//11
		final ExternalDeclaration ExternalDeclaration_12_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_12_Var
		);
		//12
		final Declaration Declaration_13_Var
		 = (Declaration)ExternalDeclaration_12_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_13_Var
		);
		//13
		final DeclarationSpecifiers DeclarationSpecifiers_14_Var
		 = (DeclarationSpecifiers)Declaration_13_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_14_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_14_list = DeclarationSpecifiers_14_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_14_list);
		Assert.assertEquals(2, DeclarationSpecifier_14_list.size());
		//14
		final FunctionSpecifier FunctionSpecifier_15_Var
		 = (FunctionSpecifier)DeclarationSpecifier_14_list.get(0);
		Assert.assertNotNull(FunctionSpecifier_15_Var
		);
		Assert.assertEquals("__inline", FunctionSpecifier_15_Var
		.getName());
		//15
		final TypeSpecifier TypeSpecifier_16_Var
		 = (TypeSpecifier)DeclarationSpecifier_14_list.get(1);
		Assert.assertNotNull(TypeSpecifier_16_Var
		);
		Assert.assertEquals("void", TypeSpecifier_16_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_16_list = Declaration_13_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_16_list);
		Assert.assertEquals(1, InitDeclaratorList_16_list.size());
		//16
		final InitDeclaratorList InitDeclaratorList_17_Var
		 = (InitDeclaratorList)InitDeclaratorList_16_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_17_Var
		);
		final EList<? extends EObject> InitDeclarator_17_list = InitDeclaratorList_17_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_17_list);
		Assert.assertEquals(1, InitDeclarator_17_list.size());
		//17
		final InitDeclarator InitDeclarator_18_Var
		 = (InitDeclarator)InitDeclarator_17_list.get(0);
		Assert.assertNotNull(InitDeclarator_18_Var
		);
		//18
		final Declarator Declarator_19_Var
		 = (Declarator)InitDeclarator_18_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_19_Var
		);
		//19
		final DirectDeclarator DirectDeclarator_20_Var
		 = (DirectDeclarator)Declarator_19_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_20_Var
		);
		Assert.assertEquals("doSomethingA2", DirectDeclarator_20_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_20_list = DirectDeclarator_20_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_20_list);
		Assert.assertEquals(1, DeclaratorSuffix_20_list.size());
		//20
		final DeclaratorSuffix DeclaratorSuffix_21_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_20_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_21_Var
		);
		//21
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_22_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_21_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_22_Var
		);
		Assert.assertEquals(";", Declaration_13_Var
		.getSemi());
		//22
		final ExternalDeclaration ExternalDeclaration_23_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_23_Var
		);
		//23
		final Declaration Declaration_24_Var
		 = (Declaration)ExternalDeclaration_23_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_24_Var
		);
		//24
		final DeclarationSpecifiers DeclarationSpecifiers_25_Var
		 = (DeclarationSpecifiers)Declaration_24_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_25_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_25_list = DeclarationSpecifiers_25_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_25_list);
		Assert.assertEquals(2, DeclarationSpecifier_25_list.size());
		//25
		final FunctionSpecifier FunctionSpecifier_26_Var
		 = (FunctionSpecifier)DeclarationSpecifier_25_list.get(0);
		Assert.assertNotNull(FunctionSpecifier_26_Var
		);
		Assert.assertEquals("__inline__", FunctionSpecifier_26_Var
		.getName());
		//26
		final TypeSpecifier TypeSpecifier_27_Var
		 = (TypeSpecifier)DeclarationSpecifier_25_list.get(1);
		Assert.assertNotNull(TypeSpecifier_27_Var
		);
		Assert.assertEquals("void", TypeSpecifier_27_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_27_list = Declaration_24_Var
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
		Assert.assertEquals("doSomethingA3", DirectDeclarator_31_Var
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
		Assert.assertEquals(";", Declaration_24_Var
		.getSemi());
		//33
		final ExternalDeclaration ExternalDeclaration_34_Var
		 = (ExternalDeclaration)External_0_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_34_Var
		);
		//34
		final FunctionDefHead FunctionDefHead_35_Var
		 = (FunctionDefHead)ExternalDeclaration_34_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_35_Var
		);
		//35
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_36_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_35_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_36_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_36_list = FunctionDeclarationSpecifiers_36_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_36_list);
		Assert.assertEquals(3, DeclarationSpecifier_36_list.size());
		//36
		final StorageClassSpecifier StorageClassSpecifier_37_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_36_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_37_Var
		);
		Assert.assertEquals("static", StorageClassSpecifier_37_Var
		.getName());
		//37
		final FunctionSpecifier FunctionSpecifier_38_Var
		 = (FunctionSpecifier)DeclarationSpecifier_36_list.get(1);
		Assert.assertNotNull(FunctionSpecifier_38_Var
		);
		Assert.assertEquals("inline", FunctionSpecifier_38_Var
		.getName());
		//38
		final TypeSpecifier TypeSpecifier_39_Var
		 = (TypeSpecifier)DeclarationSpecifier_36_list.get(2);
		Assert.assertNotNull(TypeSpecifier_39_Var
		);
		Assert.assertEquals("void", TypeSpecifier_39_Var
		.getName());
		//39
		final Declarator Declarator_40_Var
		 = (Declarator)FunctionDefHead_35_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_40_Var
		);
		//40
		final DirectDeclarator DirectDeclarator_41_Var
		 = (DirectDeclarator)Declarator_40_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_41_Var
		);
		Assert.assertEquals("doSomethingB1", DirectDeclarator_41_Var
		.getId());
		//41
		final FunctionDefinition FunctionDefinition_42_Var
		 = (FunctionDefinition)ExternalDeclaration_34_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_42_Var
		);
		//42
		final BodyStatement BodyStatement_43_Var
		 = (BodyStatement)FunctionDefinition_42_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_43_Var
		);
		//43
		final ExternalDeclaration ExternalDeclaration_44_Var
		 = (ExternalDeclaration)External_0_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_44_Var
		);
		//44
		final FunctionDefHead FunctionDefHead_45_Var
		 = (FunctionDefHead)ExternalDeclaration_44_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_45_Var
		);
		//45
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_46_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_45_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_46_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_46_list = FunctionDeclarationSpecifiers_46_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_46_list);
		Assert.assertEquals(3, DeclarationSpecifier_46_list.size());
		//46
		final StorageClassSpecifier StorageClassSpecifier_47_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_46_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_47_Var
		);
		Assert.assertEquals("static", StorageClassSpecifier_47_Var
		.getName());
		//47
		final FunctionSpecifier FunctionSpecifier_48_Var
		 = (FunctionSpecifier)DeclarationSpecifier_46_list.get(1);
		Assert.assertNotNull(FunctionSpecifier_48_Var
		);
		Assert.assertEquals("__inline", FunctionSpecifier_48_Var
		.getName());
		//48
		final TypeSpecifier TypeSpecifier_49_Var
		 = (TypeSpecifier)DeclarationSpecifier_46_list.get(2);
		Assert.assertNotNull(TypeSpecifier_49_Var
		);
		Assert.assertEquals("void", TypeSpecifier_49_Var
		.getName());
		//49
		final Declarator Declarator_50_Var
		 = (Declarator)FunctionDefHead_45_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_50_Var
		);
		//50
		final DirectDeclarator DirectDeclarator_51_Var
		 = (DirectDeclarator)Declarator_50_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_51_Var
		);
		Assert.assertEquals("doSomethingB2", DirectDeclarator_51_Var
		.getId());
		//51
		final FunctionDefinition FunctionDefinition_52_Var
		 = (FunctionDefinition)ExternalDeclaration_44_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_52_Var
		);
		//52
		final BodyStatement BodyStatement_53_Var
		 = (BodyStatement)FunctionDefinition_52_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_53_Var
		);
		//53
		final ExternalDeclaration ExternalDeclaration_54_Var
		 = (ExternalDeclaration)External_0_list.get(5);
		Assert.assertNotNull(ExternalDeclaration_54_Var
		);
		//54
		final FunctionDefHead FunctionDefHead_55_Var
		 = (FunctionDefHead)ExternalDeclaration_54_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_55_Var
		);
		//55
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_56_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_55_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_56_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_56_list = FunctionDeclarationSpecifiers_56_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_56_list);
		Assert.assertEquals(3, DeclarationSpecifier_56_list.size());
		//56
		final StorageClassSpecifier StorageClassSpecifier_57_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_56_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_57_Var
		);
		Assert.assertEquals("static", StorageClassSpecifier_57_Var
		.getName());
		//57
		final FunctionSpecifier FunctionSpecifier_58_Var
		 = (FunctionSpecifier)DeclarationSpecifier_56_list.get(1);
		Assert.assertNotNull(FunctionSpecifier_58_Var
		);
		Assert.assertEquals("__inline__", FunctionSpecifier_58_Var
		.getName());
		//58
		final TypeSpecifier TypeSpecifier_59_Var
		 = (TypeSpecifier)DeclarationSpecifier_56_list.get(2);
		Assert.assertNotNull(TypeSpecifier_59_Var
		);
		Assert.assertEquals("void", TypeSpecifier_59_Var
		.getName());
		//59
		final Declarator Declarator_60_Var
		 = (Declarator)FunctionDefHead_55_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_60_Var
		);
		//60
		final DirectDeclarator DirectDeclarator_61_Var
		 = (DirectDeclarator)Declarator_60_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_61_Var
		);
		Assert.assertEquals("doSomethingB3", DirectDeclarator_61_Var
		.getId());
		//61
		final FunctionDefinition FunctionDefinition_62_Var
		 = (FunctionDefinition)ExternalDeclaration_54_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_62_Var
		);
		//62
		final BodyStatement BodyStatement_63_Var
		 = (BodyStatement)FunctionDefinition_62_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_63_Var
		);
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0049_Inline.c");
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
				method.invoke(this.generator, "Test0005_FunctionDecls.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0005_FunctionDecls.c");
		final String expected = this.getTextFromFile(
			"res/Test0049_Inline.c"
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


