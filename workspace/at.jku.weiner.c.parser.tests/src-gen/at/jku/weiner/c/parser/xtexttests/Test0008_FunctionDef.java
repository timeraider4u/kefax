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
		final FunctionDefHead FunctionDefHead_2_Var
		 = (FunctionDefHead)ExternalDeclaration_1_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_2_Var
		);
		//2
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_3_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_2_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_3_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_3_list = FunctionDeclarationSpecifiers_3_Var
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
		//4
		final Declarator Declarator_5_Var
		 = (Declarator)FunctionDefHead_2_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_5_Var
		);
		//5
		final DirectDeclarator DirectDeclarator_6_Var
		 = (DirectDeclarator)Declarator_5_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_6_Var
		);
		Assert.assertEquals("do1", DirectDeclarator_6_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_6_list = DirectDeclarator_6_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_6_list);
		Assert.assertEquals(1, DeclaratorSuffix_6_list.size());
		//6
		final DeclaratorSuffix DeclaratorSuffix_7_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_6_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_7_Var
		);
		//7
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_8_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_7_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_8_Var
		);
		final EList<? extends EObject> ParameterTypeList_8_list = DirectDeclaratorLastSuffix_8_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_8_list);
		Assert.assertEquals(1, ParameterTypeList_8_list.size());
		//8
		final ParameterTypeList ParameterTypeList_9_Var
		 = (ParameterTypeList)ParameterTypeList_8_list.get(0);
		Assert.assertNotNull(ParameterTypeList_9_Var
		);
		//9
		final ParameterList ParameterList_10_Var
		 = (ParameterList)ParameterTypeList_9_Var
		.getList();
		Assert.assertNotNull(ParameterList_10_Var
		);
		final EList<? extends EObject> ParameterDeclaration_10_list = ParameterList_10_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_10_list);
		Assert.assertEquals(3, ParameterDeclaration_10_list.size());
		//10
		final ParameterDeclaration ParameterDeclaration_11_Var
		 = (ParameterDeclaration)ParameterDeclaration_10_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_11_Var
		);
		//11
		final DeclarationSpecifiers DeclarationSpecifiers_12_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_11_Var
		.getDeclSpecifiers();
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
		Assert.assertEquals("char", TypeSpecifier_13_Var
		.getName());
		//13
		final Declarator Declarator_14_Var
		 = (Declarator)ParameterDeclaration_11_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_14_Var
		);
		//14
		final DirectDeclarator DirectDeclarator_15_Var
		 = (DirectDeclarator)Declarator_14_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_15_Var
		);
		Assert.assertEquals("c", DirectDeclarator_15_Var
		.getId());
		//15
		final ParameterDeclaration ParameterDeclaration_16_Var
		 = (ParameterDeclaration)ParameterDeclaration_10_list.get(1);
		Assert.assertNotNull(ParameterDeclaration_16_Var
		);
		//16
		final DeclarationSpecifiers DeclarationSpecifiers_17_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_16_Var
		.getDeclSpecifiers();
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
		Assert.assertEquals("float", TypeSpecifier_18_Var
		.getName());
		//18
		final Declarator Declarator_19_Var
		 = (Declarator)ParameterDeclaration_16_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_19_Var
		);
		//19
		final DirectDeclarator DirectDeclarator_20_Var
		 = (DirectDeclarator)Declarator_19_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_20_Var
		);
		Assert.assertEquals("f", DirectDeclarator_20_Var
		.getId());
		//20
		final ParameterDeclaration ParameterDeclaration_21_Var
		 = (ParameterDeclaration)ParameterDeclaration_10_list.get(2);
		Assert.assertNotNull(ParameterDeclaration_21_Var
		);
		//21
		final DeclarationSpecifiers DeclarationSpecifiers_22_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_21_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_22_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_22_list = DeclarationSpecifiers_22_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_22_list);
		Assert.assertEquals(1, DeclarationSpecifier_22_list.size());
		//22
		final TypeSpecifier TypeSpecifier_23_Var
		 = (TypeSpecifier)DeclarationSpecifier_22_list.get(0);
		Assert.assertNotNull(TypeSpecifier_23_Var
		);
		Assert.assertEquals("int", TypeSpecifier_23_Var
		.getName());
		//23
		final Declarator Declarator_24_Var
		 = (Declarator)ParameterDeclaration_21_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_24_Var
		);
		//24
		final DirectDeclarator DirectDeclarator_25_Var
		 = (DirectDeclarator)Declarator_24_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_25_Var
		);
		Assert.assertEquals("i", DirectDeclarator_25_Var
		.getId());
		//25
		final ExternalDeclaration ExternalDeclaration_26_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_26_Var
		);
		//26
		final FunctionDefinition FunctionDefinition_27_Var
		 = (FunctionDefinition)ExternalDeclaration_26_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_27_Var
		);
		//27
		final BodyStatement BodyStatement_28_Var
		 = (BodyStatement)FunctionDefinition_27_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_28_Var
		);
		//28
		final FunctionDefHead FunctionDefHead_29_Var
		 = (FunctionDefHead)ExternalDeclaration_26_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_29_Var
		);
		//29
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_30_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_29_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_30_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_30_list = FunctionDeclarationSpecifiers_30_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_30_list);
		Assert.assertEquals(1, DeclarationSpecifier_30_list.size());
		//30
		final TypeSpecifier TypeSpecifier_31_Var
		 = (TypeSpecifier)DeclarationSpecifier_30_list.get(0);
		Assert.assertNotNull(TypeSpecifier_31_Var
		);
		Assert.assertEquals("void", TypeSpecifier_31_Var
		.getName());
		//31
		final Declarator Declarator_32_Var
		 = (Declarator)FunctionDefHead_29_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_32_Var
		);
		//32
		final DirectDeclarator DirectDeclarator_33_Var
		 = (DirectDeclarator)Declarator_32_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_33_Var
		);
		Assert.assertEquals("do3", DirectDeclarator_33_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_33_list = DirectDeclarator_33_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_33_list);
		Assert.assertEquals(1, DeclaratorSuffix_33_list.size());
		//33
		final DeclaratorSuffix DeclaratorSuffix_34_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_33_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_34_Var
		);
		//34
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_35_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_34_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_35_Var
		);
		//35
		final IdentifierList IdentifierList_36_Var
		 = (IdentifierList)DirectDeclaratorLastSuffix_35_Var
		.getIdentifierList();
		Assert.assertNotNull(IdentifierList_36_Var
		);
		final EList<? extends EObject> Id_36_list = IdentifierList_36_Var
		.getId();
		Assert.assertNotNull(Id_36_list);
		Assert.assertEquals(3, Id_36_list.size());
		//36
		final MyIdentifier MyIdentifier_37_Var
		 = (MyIdentifier)Id_36_list.get(0);
		Assert.assertNotNull(MyIdentifier_37_Var
		);
		Assert.assertEquals("c", MyIdentifier_37_Var
		.getId());
		//37
		final MyIdentifier MyIdentifier_38_Var
		 = (MyIdentifier)Id_36_list.get(1);
		Assert.assertNotNull(MyIdentifier_38_Var
		);
		Assert.assertEquals("f", MyIdentifier_38_Var
		.getId());
		//38
		final MyIdentifier MyIdentifier_39_Var
		 = (MyIdentifier)Id_36_list.get(2);
		Assert.assertNotNull(MyIdentifier_39_Var
		);
		Assert.assertEquals("i", MyIdentifier_39_Var
		.getId());
		final EList<? extends EObject> FunDeclaration_39_list = FunctionDefHead_29_Var
		.getFunDeclaration();
		Assert.assertNotNull(FunDeclaration_39_list);
		Assert.assertEquals(3, FunDeclaration_39_list.size());
		//39
		final Declaration Declaration_40_Var
		 = (Declaration)FunDeclaration_39_list.get(0);
		Assert.assertNotNull(Declaration_40_Var
		);
		//40
		final DeclarationSpecifiers DeclarationSpecifiers_41_Var
		 = (DeclarationSpecifiers)Declaration_40_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_41_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_41_list = DeclarationSpecifiers_41_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_41_list);
		Assert.assertEquals(1, DeclarationSpecifier_41_list.size());
		//41
		final TypeSpecifier TypeSpecifier_42_Var
		 = (TypeSpecifier)DeclarationSpecifier_41_list.get(0);
		Assert.assertNotNull(TypeSpecifier_42_Var
		);
		Assert.assertEquals("char", TypeSpecifier_42_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_42_list = Declaration_40_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_42_list);
		Assert.assertEquals(1, InitDeclaratorList_42_list.size());
		//42
		final InitDeclaratorList InitDeclaratorList_43_Var
		 = (InitDeclaratorList)InitDeclaratorList_42_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_43_Var
		);
		final EList<? extends EObject> InitDeclarator_43_list = InitDeclaratorList_43_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_43_list);
		Assert.assertEquals(1, InitDeclarator_43_list.size());
		//43
		final InitDeclarator InitDeclarator_44_Var
		 = (InitDeclarator)InitDeclarator_43_list.get(0);
		Assert.assertNotNull(InitDeclarator_44_Var
		);
		//44
		final Declarator Declarator_45_Var
		 = (Declarator)InitDeclarator_44_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_45_Var
		);
		//45
		final DirectDeclarator DirectDeclarator_46_Var
		 = (DirectDeclarator)Declarator_45_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_46_Var
		);
		Assert.assertEquals("c", DirectDeclarator_46_Var
		.getId());
		//46
		final Declaration Declaration_47_Var
		 = (Declaration)FunDeclaration_39_list.get(1);
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
		Assert.assertEquals("float", TypeSpecifier_49_Var
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
		Assert.assertEquals("f", DirectDeclarator_53_Var
		.getId());
		//53
		final Declaration Declaration_54_Var
		 = (Declaration)FunDeclaration_39_list.get(2);
		Assert.assertNotNull(Declaration_54_Var
		);
		//54
		final DeclarationSpecifiers DeclarationSpecifiers_55_Var
		 = (DeclarationSpecifiers)Declaration_54_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_55_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_55_list = DeclarationSpecifiers_55_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_55_list);
		Assert.assertEquals(1, DeclarationSpecifier_55_list.size());
		//55
		final TypeSpecifier TypeSpecifier_56_Var
		 = (TypeSpecifier)DeclarationSpecifier_55_list.get(0);
		Assert.assertNotNull(TypeSpecifier_56_Var
		);
		Assert.assertEquals("int", TypeSpecifier_56_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_56_list = Declaration_54_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_56_list);
		Assert.assertEquals(1, InitDeclaratorList_56_list.size());
		//56
		final InitDeclaratorList InitDeclaratorList_57_Var
		 = (InitDeclaratorList)InitDeclaratorList_56_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_57_Var
		);
		final EList<? extends EObject> InitDeclarator_57_list = InitDeclaratorList_57_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_57_list);
		Assert.assertEquals(1, InitDeclarator_57_list.size());
		//57
		final InitDeclarator InitDeclarator_58_Var
		 = (InitDeclarator)InitDeclarator_57_list.get(0);
		Assert.assertNotNull(InitDeclarator_58_Var
		);
		//58
		final Declarator Declarator_59_Var
		 = (Declarator)InitDeclarator_58_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_59_Var
		);
		//59
		final DirectDeclarator DirectDeclarator_60_Var
		 = (DirectDeclarator)Declarator_59_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_60_Var
		);
		Assert.assertEquals("i", DirectDeclarator_60_Var
		.getId());
		//60
		final FunctionDefinition FunctionDefinition_61_Var
		 = (FunctionDefinition)ExternalDeclaration_26_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_61_Var
		);
		//61
		final BodyStatement BodyStatement_62_Var
		 = (BodyStatement)FunctionDefinition_61_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_62_Var
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


