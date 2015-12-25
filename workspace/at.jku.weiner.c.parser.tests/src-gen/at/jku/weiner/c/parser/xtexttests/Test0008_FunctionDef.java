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
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
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
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.IdentifierList;
import at.jku.weiner.c.parser.parser.MyIdentifier;
import at.jku.weiner.c.parser.parser.MyIdentifier;
import at.jku.weiner.c.parser.parser.MyIdentifier;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0008_FunctionDef {
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
			"res/Test0008_FunctionDef.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_VOID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_KW_CHAR", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_KW_FLOAT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_SKW_RIGHTBRACE", 
				"RULE_NEWLINE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_KW_VOID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_LINE_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_LINE_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_CHAR", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_FLOAT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_LINE_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_WHITESPACE", 
				"RULE_LINE_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_SKW_RIGHTBRACE", 
				"RULE_NEWLINE", 
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0008_FunctionDef.c");
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
		final FunctionDefHead FunctionDefHead_4_Var
		 = (FunctionDefHead)ExternalDeclaration_3_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_4_Var
		);
		//4
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_5_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_4_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_5_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_5_list = FunctionDeclarationSpecifiers_5_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_5_list);
		Assert.assertEquals(1, DeclarationSpecifier_5_list.size());
		//5
		final TypeSpecifier TypeSpecifier_6_Var
		 = (TypeSpecifier)DeclarationSpecifier_5_list.get(0);
		Assert.assertNotNull(TypeSpecifier_6_Var
		);
		Assert.assertEquals("void", TypeSpecifier_6_Var
		.getName());
		//6
		final Declarator Declarator_7_Var
		 = (Declarator)FunctionDefHead_4_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_7_Var
		);
		//7
		final DirectDeclarator DirectDeclarator_8_Var
		 = (DirectDeclarator)Declarator_7_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_8_Var
		);
		Assert.assertEquals("do1", DirectDeclarator_8_Var
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
		Assert.assertEquals("char", TypeSpecifier_15_Var
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
		Assert.assertEquals("c", DirectDeclarator_17_Var
		.getId());
		//17
		final ParameterDeclaration ParameterDeclaration_18_Var
		 = (ParameterDeclaration)ParameterDeclaration_12_list.get(1);
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
		Assert.assertEquals("float", TypeSpecifier_20_Var
		.getName());
		//20
		final Declarator Declarator_21_Var
		 = (Declarator)ParameterDeclaration_18_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_21_Var
		);
		//21
		final DirectDeclarator DirectDeclarator_22_Var
		 = (DirectDeclarator)Declarator_21_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_22_Var
		);
		Assert.assertEquals("f", DirectDeclarator_22_Var
		.getId());
		//22
		final ParameterDeclaration ParameterDeclaration_23_Var
		 = (ParameterDeclaration)ParameterDeclaration_12_list.get(2);
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
		Assert.assertEquals("int", TypeSpecifier_25_Var
		.getName());
		//25
		final Declarator Declarator_26_Var
		 = (Declarator)ParameterDeclaration_23_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_26_Var
		);
		//26
		final DirectDeclarator DirectDeclarator_27_Var
		 = (DirectDeclarator)Declarator_26_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_27_Var
		);
		Assert.assertEquals("i", DirectDeclarator_27_Var
		.getId());
		//27
		final ExternalDeclaration ExternalDeclaration_28_Var
		 = (ExternalDeclaration)External_2_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_28_Var
		);
		//28
		final FunctionDefinition FunctionDefinition_29_Var
		 = (FunctionDefinition)ExternalDeclaration_28_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_29_Var
		);
		//29
		final BodyStatement BodyStatement_30_Var
		 = (BodyStatement)FunctionDefinition_29_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_30_Var
		);
		//30
		final FunctionDefHead FunctionDefHead_31_Var
		 = (FunctionDefHead)ExternalDeclaration_28_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_31_Var
		);
		//31
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_32_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_31_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_32_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_32_list = FunctionDeclarationSpecifiers_32_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_32_list);
		Assert.assertEquals(1, DeclarationSpecifier_32_list.size());
		//32
		final TypeSpecifier TypeSpecifier_33_Var
		 = (TypeSpecifier)DeclarationSpecifier_32_list.get(0);
		Assert.assertNotNull(TypeSpecifier_33_Var
		);
		Assert.assertEquals("void", TypeSpecifier_33_Var
		.getName());
		//33
		final Declarator Declarator_34_Var
		 = (Declarator)FunctionDefHead_31_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_34_Var
		);
		//34
		final DirectDeclarator DirectDeclarator_35_Var
		 = (DirectDeclarator)Declarator_34_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_35_Var
		);
		Assert.assertEquals("do3", DirectDeclarator_35_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_35_list = DirectDeclarator_35_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_35_list);
		Assert.assertEquals(1, DeclaratorSuffix_35_list.size());
		//35
		final DeclaratorSuffix DeclaratorSuffix_36_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_35_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_36_Var
		);
		//36
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_37_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_36_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_37_Var
		);
		//37
		final IdentifierList IdentifierList_38_Var
		 = (IdentifierList)DirectDeclaratorLastSuffix_37_Var
		.getIdentifierList();
		Assert.assertNotNull(IdentifierList_38_Var
		);
		final EList<? extends EObject> Id_38_list = IdentifierList_38_Var
		.getId();
		Assert.assertNotNull(Id_38_list);
		Assert.assertEquals(3, Id_38_list.size());
		//38
		final MyIdentifier MyIdentifier_39_Var
		 = (MyIdentifier)Id_38_list.get(0);
		Assert.assertNotNull(MyIdentifier_39_Var
		);
		Assert.assertEquals("c", MyIdentifier_39_Var
		.getId());
		//39
		final MyIdentifier MyIdentifier_40_Var
		 = (MyIdentifier)Id_38_list.get(1);
		Assert.assertNotNull(MyIdentifier_40_Var
		);
		Assert.assertEquals("f", MyIdentifier_40_Var
		.getId());
		//40
		final MyIdentifier MyIdentifier_41_Var
		 = (MyIdentifier)Id_38_list.get(2);
		Assert.assertNotNull(MyIdentifier_41_Var
		);
		Assert.assertEquals("i", MyIdentifier_41_Var
		.getId());
		final EList<? extends EObject> FunDeclaration_41_list = FunctionDefHead_31_Var
		.getFunDeclaration();
		Assert.assertNotNull(FunDeclaration_41_list);
		Assert.assertEquals(3, FunDeclaration_41_list.size());
		//41
		final Declaration Declaration_42_Var
		 = (Declaration)FunDeclaration_41_list.get(0);
		Assert.assertNotNull(Declaration_42_Var
		);
		//42
		final DeclarationSpecifiers DeclarationSpecifiers_43_Var
		 = (DeclarationSpecifiers)Declaration_42_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_43_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_43_list = DeclarationSpecifiers_43_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_43_list);
		Assert.assertEquals(1, DeclarationSpecifier_43_list.size());
		//43
		final TypeSpecifier TypeSpecifier_44_Var
		 = (TypeSpecifier)DeclarationSpecifier_43_list.get(0);
		Assert.assertNotNull(TypeSpecifier_44_Var
		);
		Assert.assertEquals("char", TypeSpecifier_44_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_44_list = Declaration_42_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_44_list);
		Assert.assertEquals(1, InitDeclaratorList_44_list.size());
		//44
		final InitDeclaratorList InitDeclaratorList_45_Var
		 = (InitDeclaratorList)InitDeclaratorList_44_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_45_Var
		);
		final EList<? extends EObject> InitDeclarator_45_list = InitDeclaratorList_45_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_45_list);
		Assert.assertEquals(1, InitDeclarator_45_list.size());
		//45
		final InitDeclarator InitDeclarator_46_Var
		 = (InitDeclarator)InitDeclarator_45_list.get(0);
		Assert.assertNotNull(InitDeclarator_46_Var
		);
		//46
		final Declarator Declarator_47_Var
		 = (Declarator)InitDeclarator_46_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_47_Var
		);
		//47
		final DirectDeclarator DirectDeclarator_48_Var
		 = (DirectDeclarator)Declarator_47_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_48_Var
		);
		Assert.assertEquals("c", DirectDeclarator_48_Var
		.getId());
		//48
		final Declaration Declaration_49_Var
		 = (Declaration)FunDeclaration_41_list.get(1);
		Assert.assertNotNull(Declaration_49_Var
		);
		//49
		final DeclarationSpecifiers DeclarationSpecifiers_50_Var
		 = (DeclarationSpecifiers)Declaration_49_Var
		.getSpecifiers();
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
		Assert.assertEquals("float", TypeSpecifier_51_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_51_list = Declaration_49_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_51_list);
		Assert.assertEquals(1, InitDeclaratorList_51_list.size());
		//51
		final InitDeclaratorList InitDeclaratorList_52_Var
		 = (InitDeclaratorList)InitDeclaratorList_51_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_52_Var
		);
		final EList<? extends EObject> InitDeclarator_52_list = InitDeclaratorList_52_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_52_list);
		Assert.assertEquals(1, InitDeclarator_52_list.size());
		//52
		final InitDeclarator InitDeclarator_53_Var
		 = (InitDeclarator)InitDeclarator_52_list.get(0);
		Assert.assertNotNull(InitDeclarator_53_Var
		);
		//53
		final Declarator Declarator_54_Var
		 = (Declarator)InitDeclarator_53_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_54_Var
		);
		//54
		final DirectDeclarator DirectDeclarator_55_Var
		 = (DirectDeclarator)Declarator_54_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_55_Var
		);
		Assert.assertEquals("f", DirectDeclarator_55_Var
		.getId());
		//55
		final Declaration Declaration_56_Var
		 = (Declaration)FunDeclaration_41_list.get(2);
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
		Assert.assertEquals(1, DeclarationSpecifier_57_list.size());
		//57
		final TypeSpecifier TypeSpecifier_58_Var
		 = (TypeSpecifier)DeclarationSpecifier_57_list.get(0);
		Assert.assertNotNull(TypeSpecifier_58_Var
		);
		Assert.assertEquals("int", TypeSpecifier_58_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_58_list = Declaration_56_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_58_list);
		Assert.assertEquals(1, InitDeclaratorList_58_list.size());
		//58
		final InitDeclaratorList InitDeclaratorList_59_Var
		 = (InitDeclaratorList)InitDeclaratorList_58_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_59_Var
		);
		final EList<? extends EObject> InitDeclarator_59_list = InitDeclaratorList_59_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_59_list);
		Assert.assertEquals(1, InitDeclarator_59_list.size());
		//59
		final InitDeclarator InitDeclarator_60_Var
		 = (InitDeclarator)InitDeclarator_59_list.get(0);
		Assert.assertNotNull(InitDeclarator_60_Var
		);
		//60
		final Declarator Declarator_61_Var
		 = (Declarator)InitDeclarator_60_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_61_Var
		);
		//61
		final DirectDeclarator DirectDeclarator_62_Var
		 = (DirectDeclarator)Declarator_61_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_62_Var
		);
		Assert.assertEquals("i", DirectDeclarator_62_Var
		.getId());
		//62
		final FunctionDefinition FunctionDefinition_63_Var
		 = (FunctionDefinition)ExternalDeclaration_28_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_63_Var
		);
		//63
		final BodyStatement BodyStatement_64_Var
		 = (BodyStatement)FunctionDefinition_63_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_64_Var
		);
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0008_FunctionDef.c");
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
				method.invoke(this.generator, "Test0008_FunctionDef.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0008_FunctionDef.c");
		final String expected = this.getTextFromFile(
			"res/Test0008_FunctionDef.c"
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


