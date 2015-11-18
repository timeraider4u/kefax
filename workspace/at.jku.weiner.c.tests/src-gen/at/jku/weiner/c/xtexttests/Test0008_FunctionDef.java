package at.jku.weiner.c.xtexttests;

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
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import at.jku.weiner.c.tests.CInjectorProvider;
import at.jku.weiner.c.parser.antlr.CParser;
import at.jku.weiner.c.parser.antlr.internal.InternalCLexer;
import at.jku.weiner.c.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.c.Model;
import at.jku.weiner.c.c.TranslationUnit;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.FunctionDefHead;
import at.jku.weiner.c.c.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.DeclaratorSuffix;
import at.jku.weiner.c.c.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.c.ParameterTypeList;
import at.jku.weiner.c.c.ParameterList;
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.FunctionDefinition;
import at.jku.weiner.c.c.BodyStatement;
import at.jku.weiner.c.c.FunctionDefHead;
import at.jku.weiner.c.c.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.DeclaratorSuffix;
import at.jku.weiner.c.c.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.c.IdentifierList;
import at.jku.weiner.c.c.MyIdentifier;
import at.jku.weiner.c.c.MyIdentifier;
import at.jku.weiner.c.c.MyIdentifier;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.FunctionDefinition;
import at.jku.weiner.c.c.BodyStatement;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0008_FunctionDef {
	@Inject
	private ParseHelper<Model> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalCLexer lexer;
	@Inject
	private CParser parser;
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
	
	@Before
	public void initialize(){
		this.testHelper = new LexerAndParserTest(lexer, 
			parser, tokenDefProvider);
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
				"RULE_LEFTPAREN", 
				"RULE_KW_CHAR", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_KW_FLOAT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_RIGHTBRACE", 
				"RULE_NEWLINE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_KW_VOID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
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
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_FLOAT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_LINE_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SEMI", 
				"RULE_WHITESPACE", 
				"RULE_LINE_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_RIGHTBRACE", 
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
		final EList<? extends EObject> Unit_0_list = Model_0_Var
		.getUnit();
		Assert.assertNotNull(Unit_0_list);
		Assert.assertEquals(1, Unit_0_list.size());
		//0
		final TranslationUnit TranslationUnit_1_Var
		 = (TranslationUnit)Unit_0_list.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var
		);
		final EList<? extends EObject> External_1_list = TranslationUnit_1_Var
		.getExternal();
		Assert.assertNotNull(External_1_list);
		Assert.assertEquals(2, External_1_list.size());
		//1
		final ExternalDeclaration ExternalDeclaration_2_Var
		 = (ExternalDeclaration)External_1_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_2_Var
		);
		//2
		final FunctionDefHead FunctionDefHead_3_Var
		 = (FunctionDefHead)ExternalDeclaration_2_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_3_Var
		);
		//3
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_4_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_3_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_4_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_4_list = FunctionDeclarationSpecifiers_4_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_4_list);
		Assert.assertEquals(1, DeclarationSpecifier_4_list.size());
		//4
		final TypeSpecifier TypeSpecifier_5_Var
		 = (TypeSpecifier)DeclarationSpecifier_4_list.get(0);
		Assert.assertNotNull(TypeSpecifier_5_Var
		);
		Assert.assertEquals("void", TypeSpecifier_5_Var
		.getName());
		//5
		final Declarator Declarator_6_Var
		 = (Declarator)FunctionDefHead_3_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_6_Var
		);
		//6
		final DirectDeclarator DirectDeclarator_7_Var
		 = (DirectDeclarator)Declarator_6_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_7_Var
		);
		Assert.assertEquals("do1", DirectDeclarator_7_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_7_list = DirectDeclarator_7_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_7_list);
		Assert.assertEquals(1, DeclaratorSuffix_7_list.size());
		//7
		final DeclaratorSuffix DeclaratorSuffix_8_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_7_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_8_Var
		);
		//8
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_9_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_8_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_9_Var
		);
		final EList<? extends EObject> ParameterTypeList_9_list = DirectDeclaratorLastSuffix_9_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_9_list);
		Assert.assertEquals(1, ParameterTypeList_9_list.size());
		//9
		final ParameterTypeList ParameterTypeList_10_Var
		 = (ParameterTypeList)ParameterTypeList_9_list.get(0);
		Assert.assertNotNull(ParameterTypeList_10_Var
		);
		//10
		final ParameterList ParameterList_11_Var
		 = (ParameterList)ParameterTypeList_10_Var
		.getList();
		Assert.assertNotNull(ParameterList_11_Var
		);
		final EList<? extends EObject> ParameterDeclaration_11_list = ParameterList_11_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_11_list);
		Assert.assertEquals(3, ParameterDeclaration_11_list.size());
		//11
		final ParameterDeclaration ParameterDeclaration_12_Var
		 = (ParameterDeclaration)ParameterDeclaration_11_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_12_Var
		);
		//12
		final DeclarationSpecifiers DeclarationSpecifiers_13_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_12_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_13_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_13_list = DeclarationSpecifiers_13_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_13_list);
		Assert.assertEquals(1, DeclarationSpecifier_13_list.size());
		//13
		final TypeSpecifier TypeSpecifier_14_Var
		 = (TypeSpecifier)DeclarationSpecifier_13_list.get(0);
		Assert.assertNotNull(TypeSpecifier_14_Var
		);
		Assert.assertEquals("char", TypeSpecifier_14_Var
		.getName());
		//14
		final Declarator Declarator_15_Var
		 = (Declarator)ParameterDeclaration_12_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_15_Var
		);
		//15
		final DirectDeclarator DirectDeclarator_16_Var
		 = (DirectDeclarator)Declarator_15_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_16_Var
		);
		Assert.assertEquals("c", DirectDeclarator_16_Var
		.getId());
		//16
		final ParameterDeclaration ParameterDeclaration_17_Var
		 = (ParameterDeclaration)ParameterDeclaration_11_list.get(1);
		Assert.assertNotNull(ParameterDeclaration_17_Var
		);
		//17
		final DeclarationSpecifiers DeclarationSpecifiers_18_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_17_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_18_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_18_list = DeclarationSpecifiers_18_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_18_list);
		Assert.assertEquals(1, DeclarationSpecifier_18_list.size());
		//18
		final TypeSpecifier TypeSpecifier_19_Var
		 = (TypeSpecifier)DeclarationSpecifier_18_list.get(0);
		Assert.assertNotNull(TypeSpecifier_19_Var
		);
		Assert.assertEquals("float", TypeSpecifier_19_Var
		.getName());
		//19
		final Declarator Declarator_20_Var
		 = (Declarator)ParameterDeclaration_17_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_20_Var
		);
		//20
		final DirectDeclarator DirectDeclarator_21_Var
		 = (DirectDeclarator)Declarator_20_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_21_Var
		);
		Assert.assertEquals("f", DirectDeclarator_21_Var
		.getId());
		//21
		final ParameterDeclaration ParameterDeclaration_22_Var
		 = (ParameterDeclaration)ParameterDeclaration_11_list.get(2);
		Assert.assertNotNull(ParameterDeclaration_22_Var
		);
		//22
		final DeclarationSpecifiers DeclarationSpecifiers_23_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_22_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_23_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_23_list = DeclarationSpecifiers_23_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_23_list);
		Assert.assertEquals(1, DeclarationSpecifier_23_list.size());
		//23
		final TypeSpecifier TypeSpecifier_24_Var
		 = (TypeSpecifier)DeclarationSpecifier_23_list.get(0);
		Assert.assertNotNull(TypeSpecifier_24_Var
		);
		Assert.assertEquals("int", TypeSpecifier_24_Var
		.getName());
		//24
		final Declarator Declarator_25_Var
		 = (Declarator)ParameterDeclaration_22_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_25_Var
		);
		//25
		final DirectDeclarator DirectDeclarator_26_Var
		 = (DirectDeclarator)Declarator_25_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_26_Var
		);
		Assert.assertEquals("i", DirectDeclarator_26_Var
		.getId());
		//26
		final ExternalDeclaration ExternalDeclaration_27_Var
		 = (ExternalDeclaration)External_1_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_27_Var
		);
		//27
		final FunctionDefinition FunctionDefinition_28_Var
		 = (FunctionDefinition)ExternalDeclaration_27_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_28_Var
		);
		//28
		final BodyStatement BodyStatement_29_Var
		 = (BodyStatement)FunctionDefinition_28_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_29_Var
		);
		//29
		final FunctionDefHead FunctionDefHead_30_Var
		 = (FunctionDefHead)ExternalDeclaration_27_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_30_Var
		);
		//30
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_31_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_30_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_31_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_31_list = FunctionDeclarationSpecifiers_31_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_31_list);
		Assert.assertEquals(1, DeclarationSpecifier_31_list.size());
		//31
		final TypeSpecifier TypeSpecifier_32_Var
		 = (TypeSpecifier)DeclarationSpecifier_31_list.get(0);
		Assert.assertNotNull(TypeSpecifier_32_Var
		);
		Assert.assertEquals("void", TypeSpecifier_32_Var
		.getName());
		//32
		final Declarator Declarator_33_Var
		 = (Declarator)FunctionDefHead_30_Var
		.getFunDeclarator();
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
		//36
		final IdentifierList IdentifierList_37_Var
		 = (IdentifierList)DirectDeclaratorLastSuffix_36_Var
		.getIdentifierList();
		Assert.assertNotNull(IdentifierList_37_Var
		);
		final EList<? extends EObject> Id_37_list = IdentifierList_37_Var
		.getId();
		Assert.assertNotNull(Id_37_list);
		Assert.assertEquals(3, Id_37_list.size());
		//37
		final MyIdentifier MyIdentifier_38_Var
		 = (MyIdentifier)Id_37_list.get(0);
		Assert.assertNotNull(MyIdentifier_38_Var
		);
		Assert.assertEquals("c", MyIdentifier_38_Var
		.getId());
		//38
		final MyIdentifier MyIdentifier_39_Var
		 = (MyIdentifier)Id_37_list.get(1);
		Assert.assertNotNull(MyIdentifier_39_Var
		);
		Assert.assertEquals("f", MyIdentifier_39_Var
		.getId());
		//39
		final MyIdentifier MyIdentifier_40_Var
		 = (MyIdentifier)Id_37_list.get(2);
		Assert.assertNotNull(MyIdentifier_40_Var
		);
		Assert.assertEquals("i", MyIdentifier_40_Var
		.getId());
		final EList<? extends EObject> FunDeclaration_40_list = FunctionDefHead_30_Var
		.getFunDeclaration();
		Assert.assertNotNull(FunDeclaration_40_list);
		Assert.assertEquals(3, FunDeclaration_40_list.size());
		//40
		final Declaration Declaration_41_Var
		 = (Declaration)FunDeclaration_40_list.get(0);
		Assert.assertNotNull(Declaration_41_Var
		);
		//41
		final DeclarationSpecifiers DeclarationSpecifiers_42_Var
		 = (DeclarationSpecifiers)Declaration_41_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_42_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_42_list = DeclarationSpecifiers_42_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_42_list);
		Assert.assertEquals(1, DeclarationSpecifier_42_list.size());
		//42
		final TypeSpecifier TypeSpecifier_43_Var
		 = (TypeSpecifier)DeclarationSpecifier_42_list.get(0);
		Assert.assertNotNull(TypeSpecifier_43_Var
		);
		Assert.assertEquals("char", TypeSpecifier_43_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_43_list = Declaration_41_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_43_list);
		Assert.assertEquals(1, InitDeclaratorList_43_list.size());
		//43
		final InitDeclaratorList InitDeclaratorList_44_Var
		 = (InitDeclaratorList)InitDeclaratorList_43_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_44_Var
		);
		final EList<? extends EObject> InitDeclarator_44_list = InitDeclaratorList_44_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_44_list);
		Assert.assertEquals(1, InitDeclarator_44_list.size());
		//44
		final InitDeclarator InitDeclarator_45_Var
		 = (InitDeclarator)InitDeclarator_44_list.get(0);
		Assert.assertNotNull(InitDeclarator_45_Var
		);
		//45
		final Declarator Declarator_46_Var
		 = (Declarator)InitDeclarator_45_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_46_Var
		);
		//46
		final DirectDeclarator DirectDeclarator_47_Var
		 = (DirectDeclarator)Declarator_46_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_47_Var
		);
		Assert.assertEquals("c", DirectDeclarator_47_Var
		.getId());
		//47
		final Declaration Declaration_48_Var
		 = (Declaration)FunDeclaration_40_list.get(1);
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
		Assert.assertEquals("float", TypeSpecifier_50_Var
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
		Assert.assertEquals("f", DirectDeclarator_54_Var
		.getId());
		//54
		final Declaration Declaration_55_Var
		 = (Declaration)FunDeclaration_40_list.get(2);
		Assert.assertNotNull(Declaration_55_Var
		);
		//55
		final DeclarationSpecifiers DeclarationSpecifiers_56_Var
		 = (DeclarationSpecifiers)Declaration_55_Var
		.getSpecifiers();
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
		final EList<? extends EObject> InitDeclaratorList_57_list = Declaration_55_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_57_list);
		Assert.assertEquals(1, InitDeclaratorList_57_list.size());
		//57
		final InitDeclaratorList InitDeclaratorList_58_Var
		 = (InitDeclaratorList)InitDeclaratorList_57_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_58_Var
		);
		final EList<? extends EObject> InitDeclarator_58_list = InitDeclaratorList_58_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_58_list);
		Assert.assertEquals(1, InitDeclarator_58_list.size());
		//58
		final InitDeclarator InitDeclarator_59_Var
		 = (InitDeclarator)InitDeclarator_58_list.get(0);
		Assert.assertNotNull(InitDeclarator_59_Var
		);
		//59
		final Declarator Declarator_60_Var
		 = (Declarator)InitDeclarator_59_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_60_Var
		);
		//60
		final DirectDeclarator DirectDeclarator_61_Var
		 = (DirectDeclarator)Declarator_60_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_61_Var
		);
		Assert.assertEquals("i", DirectDeclarator_61_Var
		.getId());
		//61
		final FunctionDefinition FunctionDefinition_62_Var
		 = (FunctionDefinition)ExternalDeclaration_27_Var
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


