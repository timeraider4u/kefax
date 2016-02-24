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
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.StorageClassSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.CompoundStatement;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.StorageClassSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.CompoundStatement;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.StorageClassSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0072_TypedefScopes {
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
			"res/Test0072_TypedefScopes.c");
			final String[] expected = new String[] {
				"RULE_KW_TYPEDEF",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_TYPEDEF",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_TYPEDEF",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_TYPEDEF",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTBRACE",
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
			"res/Test0072_TypedefScopes.c");
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
		Assert.assertEquals("fooA", DirectDeclarator_9_Var
		.getIdent());
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
		Assert.assertEquals(1, DeclarationSpecifier_12_list.size());
		//12
		final TypeSpecifier TypeSpecifier_13_Var
		 = (TypeSpecifier)DeclarationSpecifier_12_list.get(0);
		Assert.assertNotNull(TypeSpecifier_13_Var
		);
		//13
		final TypedefName TypedefName_14_Var
		 = (TypedefName)TypeSpecifier_13_Var
		.getType();
		Assert.assertNotNull(TypedefName_14_Var
		);
		Assert.assertEquals("fooA", TypedefName_14_Var
		.getIdent());
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
		Assert.assertEquals("barA_1", DirectDeclarator_18_Var
		.getIdent());
		//18
		final ExternalDeclaration ExternalDeclaration_19_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_19_Var
		);
		//19
		final FunctionDefHead FunctionDefHead_20_Var
		 = (FunctionDefHead)ExternalDeclaration_19_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_20_Var
		);
		//20
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_21_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_20_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_21_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_21_list = FunctionDeclarationSpecifiers_21_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_21_list);
		Assert.assertEquals(1, DeclarationSpecifier_21_list.size());
		//21
		final TypeSpecifier TypeSpecifier_22_Var
		 = (TypeSpecifier)DeclarationSpecifier_21_list.get(0);
		Assert.assertNotNull(TypeSpecifier_22_Var
		);
		Assert.assertEquals("void", TypeSpecifier_22_Var
		.getName());
		//22
		final Declarator Declarator_23_Var
		 = (Declarator)FunctionDefHead_20_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_23_Var
		);
		//23
		final DirectDeclarator DirectDeclarator_24_Var
		 = (DirectDeclarator)Declarator_23_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_24_Var
		);
		Assert.assertEquals("foobar", DirectDeclarator_24_Var
		.getIdent());
		//24
		final FunctionDefinition FunctionDefinition_25_Var
		 = (FunctionDefinition)ExternalDeclaration_19_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_25_Var
		);
		//25
		final BodyStatement BodyStatement_26_Var
		 = (BodyStatement)FunctionDefinition_25_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_26_Var
		);
		final EList<? extends EObject> BlockList_26_list = BodyStatement_26_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_26_list);
		Assert.assertEquals(1, BlockList_26_list.size());
		//26
		final BlockList BlockList_27_Var
		 = (BlockList)BlockList_26_list.get(0);
		Assert.assertNotNull(BlockList_27_Var
		);
		final EList<? extends EObject> Declaration_27_list = BlockList_27_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_27_list);
		Assert.assertEquals(3, Declaration_27_list.size());
		//27
		final Declaration Declaration_28_Var
		 = (Declaration)Declaration_27_list.get(0);
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
		Assert.assertEquals(2, DeclarationSpecifier_29_list.size());
		//29
		final StorageClassSpecifier StorageClassSpecifier_30_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_29_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_30_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_30_Var
		.getName());
		//30
		final TypeSpecifier TypeSpecifier_31_Var
		 = (TypeSpecifier)DeclarationSpecifier_29_list.get(1);
		Assert.assertNotNull(TypeSpecifier_31_Var
		);
		Assert.assertEquals("int", TypeSpecifier_31_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_31_list = Declaration_28_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_31_list);
		Assert.assertEquals(1, InitDeclaratorList_31_list.size());
		//31
		final InitDeclaratorList InitDeclaratorList_32_Var
		 = (InitDeclaratorList)InitDeclaratorList_31_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_32_Var
		);
		final EList<? extends EObject> InitDeclarator_32_list = InitDeclaratorList_32_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_32_list);
		Assert.assertEquals(1, InitDeclarator_32_list.size());
		//32
		final InitDeclarator InitDeclarator_33_Var
		 = (InitDeclarator)InitDeclarator_32_list.get(0);
		Assert.assertNotNull(InitDeclarator_33_Var
		);
		//33
		final Declarator Declarator_34_Var
		 = (Declarator)InitDeclarator_33_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_34_Var
		);
		//34
		final DirectDeclarator DirectDeclarator_35_Var
		 = (DirectDeclarator)Declarator_34_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_35_Var
		);
		Assert.assertEquals("fooB", DirectDeclarator_35_Var
		.getIdent());
		//35
		final Declaration Declaration_36_Var
		 = (Declaration)Declaration_27_list.get(1);
		Assert.assertNotNull(Declaration_36_Var
		);
		//36
		final DeclarationSpecifiers DeclarationSpecifiers_37_Var
		 = (DeclarationSpecifiers)Declaration_36_Var
		.getSpecifiers();
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
		//38
		final TypedefName TypedefName_39_Var
		 = (TypedefName)TypeSpecifier_38_Var
		.getType();
		Assert.assertNotNull(TypedefName_39_Var
		);
		Assert.assertEquals("fooA", TypedefName_39_Var
		.getIdent());
		final EList<? extends EObject> InitDeclaratorList_39_list = Declaration_36_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_39_list);
		Assert.assertEquals(1, InitDeclaratorList_39_list.size());
		//39
		final InitDeclaratorList InitDeclaratorList_40_Var
		 = (InitDeclaratorList)InitDeclaratorList_39_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_40_Var
		);
		final EList<? extends EObject> InitDeclarator_40_list = InitDeclaratorList_40_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_40_list);
		Assert.assertEquals(1, InitDeclarator_40_list.size());
		//40
		final InitDeclarator InitDeclarator_41_Var
		 = (InitDeclarator)InitDeclarator_40_list.get(0);
		Assert.assertNotNull(InitDeclarator_41_Var
		);
		//41
		final Declarator Declarator_42_Var
		 = (Declarator)InitDeclarator_41_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_42_Var
		);
		//42
		final DirectDeclarator DirectDeclarator_43_Var
		 = (DirectDeclarator)Declarator_42_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_43_Var
		);
		Assert.assertEquals("barA_2", DirectDeclarator_43_Var
		.getIdent());
		//43
		final Declaration Declaration_44_Var
		 = (Declaration)Declaration_27_list.get(2);
		Assert.assertNotNull(Declaration_44_Var
		);
		//44
		final DeclarationSpecifiers DeclarationSpecifiers_45_Var
		 = (DeclarationSpecifiers)Declaration_44_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_45_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_45_list = DeclarationSpecifiers_45_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_45_list);
		Assert.assertEquals(1, DeclarationSpecifier_45_list.size());
		//45
		final TypeSpecifier TypeSpecifier_46_Var
		 = (TypeSpecifier)DeclarationSpecifier_45_list.get(0);
		Assert.assertNotNull(TypeSpecifier_46_Var
		);
		//46
		final TypedefName TypedefName_47_Var
		 = (TypedefName)TypeSpecifier_46_Var
		.getType();
		Assert.assertNotNull(TypedefName_47_Var
		);
		Assert.assertEquals("fooB", TypedefName_47_Var
		.getIdent());
		final EList<? extends EObject> InitDeclaratorList_47_list = Declaration_44_Var
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
		Assert.assertEquals("barB_1", DirectDeclarator_51_Var
		.getIdent());
		final EList<? extends EObject> Statement_51_list = BlockList_27_Var
		.getStatement();
		Assert.assertNotNull(Statement_51_list);
		Assert.assertEquals(1, Statement_51_list.size());
		//51
		final Statement Statement_52_Var
		 = (Statement)Statement_51_list.get(0);
		Assert.assertNotNull(Statement_52_Var
		);
		//52
		final CompoundStatement CompoundStatement_53_Var
		 = (CompoundStatement)Statement_52_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_53_Var
		);
		//53
		final BodyStatement BodyStatement_54_Var
		 = (BodyStatement)CompoundStatement_53_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_54_Var
		);
		final EList<? extends EObject> BlockList_54_list = BodyStatement_54_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_54_list);
		Assert.assertEquals(1, BlockList_54_list.size());
		//54
		final BlockList BlockList_55_Var
		 = (BlockList)BlockList_54_list.get(0);
		Assert.assertNotNull(BlockList_55_Var
		);
		final EList<? extends EObject> Declaration_55_list = BlockList_55_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_55_list);
		Assert.assertEquals(4, Declaration_55_list.size());
		//55
		final Declaration Declaration_56_Var
		 = (Declaration)Declaration_55_list.get(0);
		Assert.assertNotNull(Declaration_56_Var
		);
		//56
		final DeclarationSpecifiers DeclarationSpecifiers_57_Var
		 = (DeclarationSpecifiers)Declaration_56_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_57_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_57_list = DeclarationSpecifiers_57_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_57_list);
		Assert.assertEquals(2, DeclarationSpecifier_57_list.size());
		//57
		final StorageClassSpecifier StorageClassSpecifier_58_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_57_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_58_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_58_Var
		.getName());
		//58
		final TypeSpecifier TypeSpecifier_59_Var
		 = (TypeSpecifier)DeclarationSpecifier_57_list.get(1);
		Assert.assertNotNull(TypeSpecifier_59_Var
		);
		Assert.assertEquals("int", TypeSpecifier_59_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_59_list = Declaration_56_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_59_list);
		Assert.assertEquals(1, InitDeclaratorList_59_list.size());
		//59
		final InitDeclaratorList InitDeclaratorList_60_Var
		 = (InitDeclaratorList)InitDeclaratorList_59_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_60_Var
		);
		final EList<? extends EObject> InitDeclarator_60_list = InitDeclaratorList_60_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_60_list);
		Assert.assertEquals(1, InitDeclarator_60_list.size());
		//60
		final InitDeclarator InitDeclarator_61_Var
		 = (InitDeclarator)InitDeclarator_60_list.get(0);
		Assert.assertNotNull(InitDeclarator_61_Var
		);
		//61
		final Declarator Declarator_62_Var
		 = (Declarator)InitDeclarator_61_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_62_Var
		);
		//62
		final DirectDeclarator DirectDeclarator_63_Var
		 = (DirectDeclarator)Declarator_62_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_63_Var
		);
		Assert.assertEquals("fooC", DirectDeclarator_63_Var
		.getIdent());
		//63
		final Declaration Declaration_64_Var
		 = (Declaration)Declaration_55_list.get(1);
		Assert.assertNotNull(Declaration_64_Var
		);
		//64
		final DeclarationSpecifiers DeclarationSpecifiers_65_Var
		 = (DeclarationSpecifiers)Declaration_64_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_65_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_65_list = DeclarationSpecifiers_65_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_65_list);
		Assert.assertEquals(1, DeclarationSpecifier_65_list.size());
		//65
		final TypeSpecifier TypeSpecifier_66_Var
		 = (TypeSpecifier)DeclarationSpecifier_65_list.get(0);
		Assert.assertNotNull(TypeSpecifier_66_Var
		);
		//66
		final TypedefName TypedefName_67_Var
		 = (TypedefName)TypeSpecifier_66_Var
		.getType();
		Assert.assertNotNull(TypedefName_67_Var
		);
		Assert.assertEquals("fooA", TypedefName_67_Var
		.getIdent());
		final EList<? extends EObject> InitDeclaratorList_67_list = Declaration_64_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_67_list);
		Assert.assertEquals(1, InitDeclaratorList_67_list.size());
		//67
		final InitDeclaratorList InitDeclaratorList_68_Var
		 = (InitDeclaratorList)InitDeclaratorList_67_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_68_Var
		);
		final EList<? extends EObject> InitDeclarator_68_list = InitDeclaratorList_68_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_68_list);
		Assert.assertEquals(1, InitDeclarator_68_list.size());
		//68
		final InitDeclarator InitDeclarator_69_Var
		 = (InitDeclarator)InitDeclarator_68_list.get(0);
		Assert.assertNotNull(InitDeclarator_69_Var
		);
		//69
		final Declarator Declarator_70_Var
		 = (Declarator)InitDeclarator_69_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_70_Var
		);
		//70
		final DirectDeclarator DirectDeclarator_71_Var
		 = (DirectDeclarator)Declarator_70_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_71_Var
		);
		Assert.assertEquals("barA_3", DirectDeclarator_71_Var
		.getIdent());
		//71
		final Declaration Declaration_72_Var
		 = (Declaration)Declaration_55_list.get(2);
		Assert.assertNotNull(Declaration_72_Var
		);
		//72
		final DeclarationSpecifiers DeclarationSpecifiers_73_Var
		 = (DeclarationSpecifiers)Declaration_72_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_73_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_73_list = DeclarationSpecifiers_73_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_73_list);
		Assert.assertEquals(1, DeclarationSpecifier_73_list.size());
		//73
		final TypeSpecifier TypeSpecifier_74_Var
		 = (TypeSpecifier)DeclarationSpecifier_73_list.get(0);
		Assert.assertNotNull(TypeSpecifier_74_Var
		);
		//74
		final TypedefName TypedefName_75_Var
		 = (TypedefName)TypeSpecifier_74_Var
		.getType();
		Assert.assertNotNull(TypedefName_75_Var
		);
		Assert.assertEquals("fooB", TypedefName_75_Var
		.getIdent());
		final EList<? extends EObject> InitDeclaratorList_75_list = Declaration_72_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_75_list);
		Assert.assertEquals(1, InitDeclaratorList_75_list.size());
		//75
		final InitDeclaratorList InitDeclaratorList_76_Var
		 = (InitDeclaratorList)InitDeclaratorList_75_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_76_Var
		);
		final EList<? extends EObject> InitDeclarator_76_list = InitDeclaratorList_76_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_76_list);
		Assert.assertEquals(1, InitDeclarator_76_list.size());
		//76
		final InitDeclarator InitDeclarator_77_Var
		 = (InitDeclarator)InitDeclarator_76_list.get(0);
		Assert.assertNotNull(InitDeclarator_77_Var
		);
		//77
		final Declarator Declarator_78_Var
		 = (Declarator)InitDeclarator_77_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_78_Var
		);
		//78
		final DirectDeclarator DirectDeclarator_79_Var
		 = (DirectDeclarator)Declarator_78_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_79_Var
		);
		Assert.assertEquals("barB_2", DirectDeclarator_79_Var
		.getIdent());
		//79
		final Declaration Declaration_80_Var
		 = (Declaration)Declaration_55_list.get(3);
		Assert.assertNotNull(Declaration_80_Var
		);
		//80
		final DeclarationSpecifiers DeclarationSpecifiers_81_Var
		 = (DeclarationSpecifiers)Declaration_80_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_81_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_81_list = DeclarationSpecifiers_81_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_81_list);
		Assert.assertEquals(1, DeclarationSpecifier_81_list.size());
		//81
		final TypeSpecifier TypeSpecifier_82_Var
		 = (TypeSpecifier)DeclarationSpecifier_81_list.get(0);
		Assert.assertNotNull(TypeSpecifier_82_Var
		);
		//82
		final TypedefName TypedefName_83_Var
		 = (TypedefName)TypeSpecifier_82_Var
		.getType();
		Assert.assertNotNull(TypedefName_83_Var
		);
		Assert.assertEquals("fooC", TypedefName_83_Var
		.getIdent());
		final EList<? extends EObject> InitDeclaratorList_83_list = Declaration_80_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_83_list);
		Assert.assertEquals(1, InitDeclaratorList_83_list.size());
		//83
		final InitDeclaratorList InitDeclaratorList_84_Var
		 = (InitDeclaratorList)InitDeclaratorList_83_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_84_Var
		);
		final EList<? extends EObject> InitDeclarator_84_list = InitDeclaratorList_84_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_84_list);
		Assert.assertEquals(1, InitDeclarator_84_list.size());
		//84
		final InitDeclarator InitDeclarator_85_Var
		 = (InitDeclarator)InitDeclarator_84_list.get(0);
		Assert.assertNotNull(InitDeclarator_85_Var
		);
		//85
		final Declarator Declarator_86_Var
		 = (Declarator)InitDeclarator_85_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_86_Var
		);
		//86
		final DirectDeclarator DirectDeclarator_87_Var
		 = (DirectDeclarator)Declarator_86_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_87_Var
		);
		Assert.assertEquals("barC_1", DirectDeclarator_87_Var
		.getIdent());
		final EList<? extends EObject> Statement_87_list = BlockList_55_Var
		.getStatement();
		Assert.assertNotNull(Statement_87_list);
		Assert.assertEquals(1, Statement_87_list.size());
		//87
		final Statement Statement_88_Var
		 = (Statement)Statement_87_list.get(0);
		Assert.assertNotNull(Statement_88_Var
		);
		//88
		final CompoundStatement CompoundStatement_89_Var
		 = (CompoundStatement)Statement_88_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_89_Var
		);
		//89
		final BodyStatement BodyStatement_90_Var
		 = (BodyStatement)CompoundStatement_89_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_90_Var
		);
		final EList<? extends EObject> BlockList_90_list = BodyStatement_90_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_90_list);
		Assert.assertEquals(1, BlockList_90_list.size());
		//90
		final BlockList BlockList_91_Var
		 = (BlockList)BlockList_90_list.get(0);
		Assert.assertNotNull(BlockList_91_Var
		);
		final EList<? extends EObject> Declaration_91_list = BlockList_91_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_91_list);
		Assert.assertEquals(5, Declaration_91_list.size());
		//91
		final Declaration Declaration_92_Var
		 = (Declaration)Declaration_91_list.get(0);
		Assert.assertNotNull(Declaration_92_Var
		);
		//92
		final DeclarationSpecifiers DeclarationSpecifiers_93_Var
		 = (DeclarationSpecifiers)Declaration_92_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_93_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_93_list = DeclarationSpecifiers_93_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_93_list);
		Assert.assertEquals(2, DeclarationSpecifier_93_list.size());
		//93
		final StorageClassSpecifier StorageClassSpecifier_94_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_93_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_94_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_94_Var
		.getName());
		//94
		final TypeSpecifier TypeSpecifier_95_Var
		 = (TypeSpecifier)DeclarationSpecifier_93_list.get(1);
		Assert.assertNotNull(TypeSpecifier_95_Var
		);
		Assert.assertEquals("int", TypeSpecifier_95_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_95_list = Declaration_92_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_95_list);
		Assert.assertEquals(1, InitDeclaratorList_95_list.size());
		//95
		final InitDeclaratorList InitDeclaratorList_96_Var
		 = (InitDeclaratorList)InitDeclaratorList_95_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_96_Var
		);
		final EList<? extends EObject> InitDeclarator_96_list = InitDeclaratorList_96_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_96_list);
		Assert.assertEquals(1, InitDeclarator_96_list.size());
		//96
		final InitDeclarator InitDeclarator_97_Var
		 = (InitDeclarator)InitDeclarator_96_list.get(0);
		Assert.assertNotNull(InitDeclarator_97_Var
		);
		//97
		final Declarator Declarator_98_Var
		 = (Declarator)InitDeclarator_97_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_98_Var
		);
		//98
		final DirectDeclarator DirectDeclarator_99_Var
		 = (DirectDeclarator)Declarator_98_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_99_Var
		);
		Assert.assertEquals("fooD", DirectDeclarator_99_Var
		.getIdent());
		//99
		final Declaration Declaration_100_Var
		 = (Declaration)Declaration_91_list.get(1);
		Assert.assertNotNull(Declaration_100_Var
		);
		//100
		final DeclarationSpecifiers DeclarationSpecifiers_101_Var
		 = (DeclarationSpecifiers)Declaration_100_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_101_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_101_list = DeclarationSpecifiers_101_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_101_list);
		Assert.assertEquals(1, DeclarationSpecifier_101_list.size());
		//101
		final TypeSpecifier TypeSpecifier_102_Var
		 = (TypeSpecifier)DeclarationSpecifier_101_list.get(0);
		Assert.assertNotNull(TypeSpecifier_102_Var
		);
		//102
		final TypedefName TypedefName_103_Var
		 = (TypedefName)TypeSpecifier_102_Var
		.getType();
		Assert.assertNotNull(TypedefName_103_Var
		);
		Assert.assertEquals("fooA", TypedefName_103_Var
		.getIdent());
		final EList<? extends EObject> InitDeclaratorList_103_list = Declaration_100_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_103_list);
		Assert.assertEquals(1, InitDeclaratorList_103_list.size());
		//103
		final InitDeclaratorList InitDeclaratorList_104_Var
		 = (InitDeclaratorList)InitDeclaratorList_103_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_104_Var
		);
		final EList<? extends EObject> InitDeclarator_104_list = InitDeclaratorList_104_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_104_list);
		Assert.assertEquals(1, InitDeclarator_104_list.size());
		//104
		final InitDeclarator InitDeclarator_105_Var
		 = (InitDeclarator)InitDeclarator_104_list.get(0);
		Assert.assertNotNull(InitDeclarator_105_Var
		);
		//105
		final Declarator Declarator_106_Var
		 = (Declarator)InitDeclarator_105_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_106_Var
		);
		//106
		final DirectDeclarator DirectDeclarator_107_Var
		 = (DirectDeclarator)Declarator_106_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_107_Var
		);
		Assert.assertEquals("barA_4", DirectDeclarator_107_Var
		.getIdent());
		//107
		final Declaration Declaration_108_Var
		 = (Declaration)Declaration_91_list.get(2);
		Assert.assertNotNull(Declaration_108_Var
		);
		//108
		final DeclarationSpecifiers DeclarationSpecifiers_109_Var
		 = (DeclarationSpecifiers)Declaration_108_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_109_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_109_list = DeclarationSpecifiers_109_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_109_list);
		Assert.assertEquals(1, DeclarationSpecifier_109_list.size());
		//109
		final TypeSpecifier TypeSpecifier_110_Var
		 = (TypeSpecifier)DeclarationSpecifier_109_list.get(0);
		Assert.assertNotNull(TypeSpecifier_110_Var
		);
		//110
		final TypedefName TypedefName_111_Var
		 = (TypedefName)TypeSpecifier_110_Var
		.getType();
		Assert.assertNotNull(TypedefName_111_Var
		);
		Assert.assertEquals("fooB", TypedefName_111_Var
		.getIdent());
		final EList<? extends EObject> InitDeclaratorList_111_list = Declaration_108_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_111_list);
		Assert.assertEquals(1, InitDeclaratorList_111_list.size());
		//111
		final InitDeclaratorList InitDeclaratorList_112_Var
		 = (InitDeclaratorList)InitDeclaratorList_111_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_112_Var
		);
		final EList<? extends EObject> InitDeclarator_112_list = InitDeclaratorList_112_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_112_list);
		Assert.assertEquals(1, InitDeclarator_112_list.size());
		//112
		final InitDeclarator InitDeclarator_113_Var
		 = (InitDeclarator)InitDeclarator_112_list.get(0);
		Assert.assertNotNull(InitDeclarator_113_Var
		);
		//113
		final Declarator Declarator_114_Var
		 = (Declarator)InitDeclarator_113_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_114_Var
		);
		//114
		final DirectDeclarator DirectDeclarator_115_Var
		 = (DirectDeclarator)Declarator_114_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_115_Var
		);
		Assert.assertEquals("barB_3", DirectDeclarator_115_Var
		.getIdent());
		//115
		final Declaration Declaration_116_Var
		 = (Declaration)Declaration_91_list.get(3);
		Assert.assertNotNull(Declaration_116_Var
		);
		//116
		final DeclarationSpecifiers DeclarationSpecifiers_117_Var
		 = (DeclarationSpecifiers)Declaration_116_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_117_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_117_list = DeclarationSpecifiers_117_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_117_list);
		Assert.assertEquals(1, DeclarationSpecifier_117_list.size());
		//117
		final TypeSpecifier TypeSpecifier_118_Var
		 = (TypeSpecifier)DeclarationSpecifier_117_list.get(0);
		Assert.assertNotNull(TypeSpecifier_118_Var
		);
		//118
		final TypedefName TypedefName_119_Var
		 = (TypedefName)TypeSpecifier_118_Var
		.getType();
		Assert.assertNotNull(TypedefName_119_Var
		);
		Assert.assertEquals("fooC", TypedefName_119_Var
		.getIdent());
		final EList<? extends EObject> InitDeclaratorList_119_list = Declaration_116_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_119_list);
		Assert.assertEquals(1, InitDeclaratorList_119_list.size());
		//119
		final InitDeclaratorList InitDeclaratorList_120_Var
		 = (InitDeclaratorList)InitDeclaratorList_119_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_120_Var
		);
		final EList<? extends EObject> InitDeclarator_120_list = InitDeclaratorList_120_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_120_list);
		Assert.assertEquals(1, InitDeclarator_120_list.size());
		//120
		final InitDeclarator InitDeclarator_121_Var
		 = (InitDeclarator)InitDeclarator_120_list.get(0);
		Assert.assertNotNull(InitDeclarator_121_Var
		);
		//121
		final Declarator Declarator_122_Var
		 = (Declarator)InitDeclarator_121_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_122_Var
		);
		//122
		final DirectDeclarator DirectDeclarator_123_Var
		 = (DirectDeclarator)Declarator_122_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_123_Var
		);
		Assert.assertEquals("barC_2", DirectDeclarator_123_Var
		.getIdent());
		//123
		final Declaration Declaration_124_Var
		 = (Declaration)Declaration_91_list.get(4);
		Assert.assertNotNull(Declaration_124_Var
		);
		//124
		final DeclarationSpecifiers DeclarationSpecifiers_125_Var
		 = (DeclarationSpecifiers)Declaration_124_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_125_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_125_list = DeclarationSpecifiers_125_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_125_list);
		Assert.assertEquals(1, DeclarationSpecifier_125_list.size());
		//125
		final TypeSpecifier TypeSpecifier_126_Var
		 = (TypeSpecifier)DeclarationSpecifier_125_list.get(0);
		Assert.assertNotNull(TypeSpecifier_126_Var
		);
		//126
		final TypedefName TypedefName_127_Var
		 = (TypedefName)TypeSpecifier_126_Var
		.getType();
		Assert.assertNotNull(TypedefName_127_Var
		);
		Assert.assertEquals("fooD", TypedefName_127_Var
		.getIdent());
		final EList<? extends EObject> InitDeclaratorList_127_list = Declaration_124_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_127_list);
		Assert.assertEquals(1, InitDeclaratorList_127_list.size());
		//127
		final InitDeclaratorList InitDeclaratorList_128_Var
		 = (InitDeclaratorList)InitDeclaratorList_127_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_128_Var
		);
		final EList<? extends EObject> InitDeclarator_128_list = InitDeclaratorList_128_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_128_list);
		Assert.assertEquals(1, InitDeclarator_128_list.size());
		//128
		final InitDeclarator InitDeclarator_129_Var
		 = (InitDeclarator)InitDeclarator_128_list.get(0);
		Assert.assertNotNull(InitDeclarator_129_Var
		);
		//129
		final Declarator Declarator_130_Var
		 = (Declarator)InitDeclarator_129_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_130_Var
		);
		//130
		final DirectDeclarator DirectDeclarator_131_Var
		 = (DirectDeclarator)Declarator_130_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_131_Var
		);
		Assert.assertEquals("barD_1", DirectDeclarator_131_Var
		.getIdent());
		Assert.assertTrue(BlockList_91_Var
		.getStatement().isEmpty());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0072_TypedefScopes.c");
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
				method.invoke(this.generator, "Test0072_TypedefScopes.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0072_TypedefScopes.c");
		final String expected = this.getTextFromFile(
			"res/Test0072_TypedefScopes.c"
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


