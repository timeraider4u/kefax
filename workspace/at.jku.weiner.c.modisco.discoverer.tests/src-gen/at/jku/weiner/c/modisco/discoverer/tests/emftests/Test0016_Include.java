package at.jku.weiner.c.modisco.discoverer.tests.emftests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.Token;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.EObject;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.IncludeDirective;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
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
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.IncludeDirective;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.Code;
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
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;

@SuppressWarnings("unused")
public class Test0016_Include {
	
	private final String pureJavaClassFileName = "Test0016_Include";
	private final String sourceFile = "res/Test0016_Include";
	private Map<String,Object> options;
	
	@Before
	public void initialize(){
		options = at.jku.weiner.c.modisco.discoverer.tests.EMFTest.getOptions(
			this.pureJavaClassFileName, this.sourceFile);
		at.jku.weiner.c.modisco.discoverer.tests.EMFTest.test0016();
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
	
				
	@Test (timeout=25000)
	public void checkParserResult() throws Exception {
		final EObject obj = at.jku.weiner.c.modisco.discoverer.tests.EMFTest.emfTestB(
			this.pureJavaClassFileName, this.sourceFile
		);
		Assert.assertNotNull(obj);
		Assert.assertTrue(obj instanceof Model);
		final Model Model_0_Var
		  =  (Model)obj;
		Assert.assertNotNull(Model_0_Var
		);
		final EList<? extends EObject> Units_0_list = Model_0_Var
		.getUnits();
		Assert.assertNotNull(Units_0_list);
		Assert.assertEquals(4, Units_0_list.size());
		//0
		final TranslationUnit TranslationUnit_1_Var
		 = (TranslationUnit)Units_0_list.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var
		);
		Assert.assertEquals("platform:/plugin/at.jku.weiner.c.preprocess/res/predefined/gcc_4.8.4_default.h", TranslationUnit_1_Var
		.getPath());
		//1
		final Preprocess Preprocess_2_Var
		 = (Preprocess)TranslationUnit_1_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_2_Var
		);
		//2
		final TranslationUnit TranslationUnit_3_Var
		 = (TranslationUnit)Units_0_list.get(1);
		Assert.assertNotNull(TranslationUnit_3_Var
		);
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/res/Test0016_Include1/A.c", TranslationUnit_3_Var
		.getPath());
		//3
		final Preprocess Preprocess_4_Var
		 = (Preprocess)TranslationUnit_3_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_4_Var
		);
		//4
		final GroupOpt GroupOpt_5_Var
		 = (GroupOpt)Preprocess_4_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_5_Var
		);
		final EList<? extends EObject> Lines_5_list = GroupOpt_5_Var
		.getLines();
		Assert.assertNotNull(Lines_5_list);
		Assert.assertEquals(4, Lines_5_list.size());
		//5
		final PreprocessorDirectives PreprocessorDirectives_6_Var
		 = (PreprocessorDirectives)Lines_5_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_6_Var
		);
		//6
		final IncludeDirective IncludeDirective_7_Var
		 = (IncludeDirective)PreprocessorDirectives_6_Var
		.getDirective();
		Assert.assertNotNull(IncludeDirective_7_Var
		);
		Assert.assertEquals("\"../include/Test0016_Include.h\"", IncludeDirective_7_Var
		.getString());
		//7
		final Code Code_8_Var
		 = (Code)Lines_5_list.get(1);
		Assert.assertNotNull(Code_8_Var
		);
		Assert.assertEquals("BAR(a)", Code_8_Var
		.getCode());
		//8
		final Code Code_9_Var
		 = (Code)Lines_5_list.get(2);
		Assert.assertNotNull(Code_9_Var
		);
		Assert.assertEquals("BAR(b, c)", Code_9_Var
		.getCode());
		//9
		final Code Code_10_Var
		 = (Code)Lines_5_list.get(3);
		Assert.assertNotNull(Code_10_Var
		);
		Assert.assertEquals("BAR(d, e, f)", Code_10_Var
		.getCode());
		//10
		final Parser Parser_11_Var
		 = (Parser)TranslationUnit_3_Var
		.getParser();
		Assert.assertNotNull(Parser_11_Var
		);
		final EList<? extends EObject> External_11_list = Parser_11_Var
		.getExternal();
		Assert.assertNotNull(External_11_list);
		Assert.assertEquals(3, External_11_list.size());
		//11
		final ExternalDeclaration ExternalDeclaration_12_Var
		 = (ExternalDeclaration)External_11_list.get(0);
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
		Assert.assertEquals(1, DeclarationSpecifier_14_list.size());
		//14
		final TypeSpecifier TypeSpecifier_15_Var
		 = (TypeSpecifier)DeclarationSpecifier_14_list.get(0);
		Assert.assertNotNull(TypeSpecifier_15_Var
		);
		Assert.assertEquals("char", TypeSpecifier_15_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_15_list = Declaration_13_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_15_list);
		Assert.assertEquals(1, InitDeclaratorList_15_list.size());
		//15
		final InitDeclaratorList InitDeclaratorList_16_Var
		 = (InitDeclaratorList)InitDeclaratorList_15_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_16_Var
		);
		final EList<? extends EObject> InitDeclarator_16_list = InitDeclaratorList_16_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_16_list);
		Assert.assertEquals(1, InitDeclarator_16_list.size());
		//16
		final InitDeclarator InitDeclarator_17_Var
		 = (InitDeclarator)InitDeclarator_16_list.get(0);
		Assert.assertNotNull(InitDeclarator_17_Var
		);
		//17
		final Declarator Declarator_18_Var
		 = (Declarator)InitDeclarator_17_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_18_Var
		);
		//18
		final DirectDeclarator DirectDeclarator_19_Var
		 = (DirectDeclarator)Declarator_18_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_19_Var
		);
		Assert.assertEquals("a", DirectDeclarator_19_Var
		.getIdent());
		final EList<? extends EObject> DeclaratorSuffix_19_list = DirectDeclarator_19_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_19_list);
		Assert.assertEquals(1, DeclaratorSuffix_19_list.size());
		//19
		final DeclaratorSuffix DeclaratorSuffix_20_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_19_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_20_Var
		);
		//20
		final PrimaryExpression PrimaryExpression_21_Var
		 = (PrimaryExpression)DeclaratorSuffix_20_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_21_Var
		);
		//21
		final Constant2 Constant2_22_Var
		 = (Constant2)PrimaryExpression_21_Var
		.getConst();
		Assert.assertNotNull(Constant2_22_Var
		);
		Assert.assertEquals("255", Constant2_22_Var
		.getDec());
		//22
		final Initializer Initializer_23_Var
		 = (Initializer)InitDeclarator_17_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_23_Var
		);
		//23
		final PrimaryExpression PrimaryExpression_24_Var
		 = (PrimaryExpression)Initializer_23_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_24_Var
		);
		Assert.assertEquals("[\"\"]", PrimaryExpression_24_Var
		.getString().toString());
		//24
		final ExternalDeclaration ExternalDeclaration_25_Var
		 = (ExternalDeclaration)External_11_list.get(1);
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
		Assert.assertEquals("b", DirectDeclarator_32_Var
		.getIdent());
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
		final PrimaryExpression PrimaryExpression_34_Var
		 = (PrimaryExpression)DeclaratorSuffix_33_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_34_Var
		);
		//34
		final Constant2 Constant2_35_Var
		 = (Constant2)PrimaryExpression_34_Var
		.getConst();
		Assert.assertNotNull(Constant2_35_Var
		);
		Assert.assertEquals("255", Constant2_35_Var
		.getDec());
		//35
		final Initializer Initializer_36_Var
		 = (Initializer)InitDeclarator_30_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_36_Var
		);
		//36
		final PrimaryExpression PrimaryExpression_37_Var
		 = (PrimaryExpression)Initializer_36_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_37_Var
		);
		Assert.assertEquals("[\"c\"]", PrimaryExpression_37_Var
		.getString().toString());
		//37
		final ExternalDeclaration ExternalDeclaration_38_Var
		 = (ExternalDeclaration)External_11_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_38_Var
		);
		//38
		final Declaration Declaration_39_Var
		 = (Declaration)ExternalDeclaration_38_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_39_Var
		);
		//39
		final DeclarationSpecifiers DeclarationSpecifiers_40_Var
		 = (DeclarationSpecifiers)Declaration_39_Var
		.getSpecifiers();
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
		Assert.assertEquals("char", TypeSpecifier_41_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_41_list = Declaration_39_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_41_list);
		Assert.assertEquals(1, InitDeclaratorList_41_list.size());
		//41
		final InitDeclaratorList InitDeclaratorList_42_Var
		 = (InitDeclaratorList)InitDeclaratorList_41_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_42_Var
		);
		final EList<? extends EObject> InitDeclarator_42_list = InitDeclaratorList_42_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_42_list);
		Assert.assertEquals(1, InitDeclarator_42_list.size());
		//42
		final InitDeclarator InitDeclarator_43_Var
		 = (InitDeclarator)InitDeclarator_42_list.get(0);
		Assert.assertNotNull(InitDeclarator_43_Var
		);
		//43
		final Declarator Declarator_44_Var
		 = (Declarator)InitDeclarator_43_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_44_Var
		);
		//44
		final DirectDeclarator DirectDeclarator_45_Var
		 = (DirectDeclarator)Declarator_44_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_45_Var
		);
		Assert.assertEquals("d", DirectDeclarator_45_Var
		.getIdent());
		final EList<? extends EObject> DeclaratorSuffix_45_list = DirectDeclarator_45_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_45_list);
		Assert.assertEquals(1, DeclaratorSuffix_45_list.size());
		//45
		final DeclaratorSuffix DeclaratorSuffix_46_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_45_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_46_Var
		);
		//46
		final PrimaryExpression PrimaryExpression_47_Var
		 = (PrimaryExpression)DeclaratorSuffix_46_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_47_Var
		);
		//47
		final Constant2 Constant2_48_Var
		 = (Constant2)PrimaryExpression_47_Var
		.getConst();
		Assert.assertNotNull(Constant2_48_Var
		);
		Assert.assertEquals("255", Constant2_48_Var
		.getDec());
		//48
		final Initializer Initializer_49_Var
		 = (Initializer)InitDeclarator_43_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_49_Var
		);
		//49
		final PrimaryExpression PrimaryExpression_50_Var
		 = (PrimaryExpression)Initializer_49_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_50_Var
		);
		Assert.assertEquals("[\"e, f\"]", PrimaryExpression_50_Var
		.getString().toString());
		//50
		final TranslationUnit TranslationUnit_51_Var
		 = (TranslationUnit)Units_0_list.get(2);
		Assert.assertNotNull(TranslationUnit_51_Var
		);
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/res/include/Test0016_Include.h", TranslationUnit_51_Var
		.getPath());
		//51
		final Preprocess Preprocess_52_Var
		 = (Preprocess)TranslationUnit_51_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_52_Var
		);
		//52
		final GroupOpt GroupOpt_53_Var
		 = (GroupOpt)Preprocess_52_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_53_Var
		);
		final EList<? extends EObject> Lines_53_list = GroupOpt_53_Var
		.getLines();
		Assert.assertNotNull(Lines_53_list);
		Assert.assertEquals(2, Lines_53_list.size());
		//53
		final PreprocessorDirectives PreprocessorDirectives_54_Var
		 = (PreprocessorDirectives)Lines_53_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_54_Var
		);
		//54
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_55_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_54_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_55_Var
		);
		Assert.assertEquals("FOO", DefineFunctionLikeMacro_55_Var
		.getIdent());
		//55
		final IdentifierList IdentifierList_56_Var
		 = (IdentifierList)DefineFunctionLikeMacro_55_Var
		.getList();
		Assert.assertNotNull(IdentifierList_56_Var
		);
		Assert.assertEquals("[X, Y]", IdentifierList_56_Var
		.getIdent().toString());
		Assert.assertFalse(IdentifierList_56_Var
		.isVariadic());
		Assert.assertNull(IdentifierList_56_Var
		.getVarID());
		Assert.assertEquals("char X[255] = Y;", DefineFunctionLikeMacro_55_Var
		.getString());
		//56
		final PreprocessorDirectives PreprocessorDirectives_57_Var
		 = (PreprocessorDirectives)Lines_53_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_57_Var
		);
		//57
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_58_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_57_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_58_Var
		);
		Assert.assertEquals("BAR", DefineFunctionLikeMacro_58_Var
		.getIdent());
		//58
		final IdentifierList IdentifierList_59_Var
		 = (IdentifierList)DefineFunctionLikeMacro_58_Var
		.getList();
		Assert.assertNotNull(IdentifierList_59_Var
		);
		Assert.assertEquals("[X]", IdentifierList_59_Var
		.getIdent().toString());
		Assert.assertTrue(IdentifierList_59_Var
		.isVariadic());
		Assert.assertNull(IdentifierList_59_Var
		.getVarID());
		Assert.assertEquals("FOO(X, #__VA_ARGS__)", DefineFunctionLikeMacro_58_Var
		.getString());
		Assert.assertNull(TranslationUnit_51_Var
		.getParser());
		//59
		final TranslationUnit TranslationUnit_60_Var
		 = (TranslationUnit)Units_0_list.get(3);
		Assert.assertNotNull(TranslationUnit_60_Var
		);
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/res/Test0016_Include2/B.c", TranslationUnit_60_Var
		.getPath());
		//60
		final Preprocess Preprocess_61_Var
		 = (Preprocess)TranslationUnit_60_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_61_Var
		);
		//61
		final GroupOpt GroupOpt_62_Var
		 = (GroupOpt)Preprocess_61_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_62_Var
		);
		final EList<? extends EObject> Lines_62_list = GroupOpt_62_Var
		.getLines();
		Assert.assertNotNull(Lines_62_list);
		Assert.assertEquals(4, Lines_62_list.size());
		//62
		final PreprocessorDirectives PreprocessorDirectives_63_Var
		 = (PreprocessorDirectives)Lines_62_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_63_Var
		);
		//63
		final IncludeDirective IncludeDirective_64_Var
		 = (IncludeDirective)PreprocessorDirectives_63_Var
		.getDirective();
		Assert.assertNotNull(IncludeDirective_64_Var
		);
		Assert.assertEquals("\"../include/Test0016_Include.h\"", IncludeDirective_64_Var
		.getString());
		//64
		final Code Code_65_Var
		 = (Code)Lines_62_list.get(1);
		Assert.assertNotNull(Code_65_Var
		);
		Assert.assertEquals("BAR(g)", Code_65_Var
		.getCode());
		//65
		final Code Code_66_Var
		 = (Code)Lines_62_list.get(2);
		Assert.assertNotNull(Code_66_Var
		);
		Assert.assertEquals("BAR(h, i)", Code_66_Var
		.getCode());
		//66
		final Code Code_67_Var
		 = (Code)Lines_62_list.get(3);
		Assert.assertNotNull(Code_67_Var
		);
		Assert.assertEquals("BAR(j, k, l)", Code_67_Var
		.getCode());
		//67
		final Parser Parser_68_Var
		 = (Parser)TranslationUnit_60_Var
		.getParser();
		Assert.assertNotNull(Parser_68_Var
		);
		final EList<? extends EObject> External_68_list = Parser_68_Var
		.getExternal();
		Assert.assertNotNull(External_68_list);
		Assert.assertEquals(3, External_68_list.size());
		//68
		final ExternalDeclaration ExternalDeclaration_69_Var
		 = (ExternalDeclaration)External_68_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_69_Var
		);
		//69
		final Declaration Declaration_70_Var
		 = (Declaration)ExternalDeclaration_69_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_70_Var
		);
		//70
		final DeclarationSpecifiers DeclarationSpecifiers_71_Var
		 = (DeclarationSpecifiers)Declaration_70_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_71_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_71_list = DeclarationSpecifiers_71_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_71_list);
		Assert.assertEquals(1, DeclarationSpecifier_71_list.size());
		//71
		final TypeSpecifier TypeSpecifier_72_Var
		 = (TypeSpecifier)DeclarationSpecifier_71_list.get(0);
		Assert.assertNotNull(TypeSpecifier_72_Var
		);
		Assert.assertEquals("char", TypeSpecifier_72_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_72_list = Declaration_70_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_72_list);
		Assert.assertEquals(1, InitDeclaratorList_72_list.size());
		//72
		final InitDeclaratorList InitDeclaratorList_73_Var
		 = (InitDeclaratorList)InitDeclaratorList_72_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_73_Var
		);
		final EList<? extends EObject> InitDeclarator_73_list = InitDeclaratorList_73_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_73_list);
		Assert.assertEquals(1, InitDeclarator_73_list.size());
		//73
		final InitDeclarator InitDeclarator_74_Var
		 = (InitDeclarator)InitDeclarator_73_list.get(0);
		Assert.assertNotNull(InitDeclarator_74_Var
		);
		//74
		final Declarator Declarator_75_Var
		 = (Declarator)InitDeclarator_74_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_75_Var
		);
		//75
		final DirectDeclarator DirectDeclarator_76_Var
		 = (DirectDeclarator)Declarator_75_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_76_Var
		);
		Assert.assertEquals("g", DirectDeclarator_76_Var
		.getIdent());
		final EList<? extends EObject> DeclaratorSuffix_76_list = DirectDeclarator_76_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_76_list);
		Assert.assertEquals(1, DeclaratorSuffix_76_list.size());
		//76
		final DeclaratorSuffix DeclaratorSuffix_77_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_76_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_77_Var
		);
		//77
		final PrimaryExpression PrimaryExpression_78_Var
		 = (PrimaryExpression)DeclaratorSuffix_77_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_78_Var
		);
		//78
		final Constant2 Constant2_79_Var
		 = (Constant2)PrimaryExpression_78_Var
		.getConst();
		Assert.assertNotNull(Constant2_79_Var
		);
		Assert.assertEquals("255", Constant2_79_Var
		.getDec());
		//79
		final Initializer Initializer_80_Var
		 = (Initializer)InitDeclarator_74_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_80_Var
		);
		//80
		final PrimaryExpression PrimaryExpression_81_Var
		 = (PrimaryExpression)Initializer_80_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_81_Var
		);
		Assert.assertEquals("[\"\"]", PrimaryExpression_81_Var
		.getString().toString());
		//81
		final ExternalDeclaration ExternalDeclaration_82_Var
		 = (ExternalDeclaration)External_68_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_82_Var
		);
		//82
		final Declaration Declaration_83_Var
		 = (Declaration)ExternalDeclaration_82_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_83_Var
		);
		//83
		final DeclarationSpecifiers DeclarationSpecifiers_84_Var
		 = (DeclarationSpecifiers)Declaration_83_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_84_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_84_list = DeclarationSpecifiers_84_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_84_list);
		Assert.assertEquals(1, DeclarationSpecifier_84_list.size());
		//84
		final TypeSpecifier TypeSpecifier_85_Var
		 = (TypeSpecifier)DeclarationSpecifier_84_list.get(0);
		Assert.assertNotNull(TypeSpecifier_85_Var
		);
		Assert.assertEquals("char", TypeSpecifier_85_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_85_list = Declaration_83_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_85_list);
		Assert.assertEquals(1, InitDeclaratorList_85_list.size());
		//85
		final InitDeclaratorList InitDeclaratorList_86_Var
		 = (InitDeclaratorList)InitDeclaratorList_85_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_86_Var
		);
		final EList<? extends EObject> InitDeclarator_86_list = InitDeclaratorList_86_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_86_list);
		Assert.assertEquals(1, InitDeclarator_86_list.size());
		//86
		final InitDeclarator InitDeclarator_87_Var
		 = (InitDeclarator)InitDeclarator_86_list.get(0);
		Assert.assertNotNull(InitDeclarator_87_Var
		);
		//87
		final Declarator Declarator_88_Var
		 = (Declarator)InitDeclarator_87_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_88_Var
		);
		//88
		final DirectDeclarator DirectDeclarator_89_Var
		 = (DirectDeclarator)Declarator_88_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_89_Var
		);
		Assert.assertEquals("h", DirectDeclarator_89_Var
		.getIdent());
		final EList<? extends EObject> DeclaratorSuffix_89_list = DirectDeclarator_89_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_89_list);
		Assert.assertEquals(1, DeclaratorSuffix_89_list.size());
		//89
		final DeclaratorSuffix DeclaratorSuffix_90_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_89_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_90_Var
		);
		//90
		final PrimaryExpression PrimaryExpression_91_Var
		 = (PrimaryExpression)DeclaratorSuffix_90_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_91_Var
		);
		//91
		final Constant2 Constant2_92_Var
		 = (Constant2)PrimaryExpression_91_Var
		.getConst();
		Assert.assertNotNull(Constant2_92_Var
		);
		Assert.assertEquals("255", Constant2_92_Var
		.getDec());
		//92
		final Initializer Initializer_93_Var
		 = (Initializer)InitDeclarator_87_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_93_Var
		);
		//93
		final PrimaryExpression PrimaryExpression_94_Var
		 = (PrimaryExpression)Initializer_93_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_94_Var
		);
		Assert.assertEquals("[\"i\"]", PrimaryExpression_94_Var
		.getString().toString());
		//94
		final ExternalDeclaration ExternalDeclaration_95_Var
		 = (ExternalDeclaration)External_68_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_95_Var
		);
		//95
		final Declaration Declaration_96_Var
		 = (Declaration)ExternalDeclaration_95_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_96_Var
		);
		//96
		final DeclarationSpecifiers DeclarationSpecifiers_97_Var
		 = (DeclarationSpecifiers)Declaration_96_Var
		.getSpecifiers();
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
		Assert.assertEquals("char", TypeSpecifier_98_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_98_list = Declaration_96_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_98_list);
		Assert.assertEquals(1, InitDeclaratorList_98_list.size());
		//98
		final InitDeclaratorList InitDeclaratorList_99_Var
		 = (InitDeclaratorList)InitDeclaratorList_98_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_99_Var
		);
		final EList<? extends EObject> InitDeclarator_99_list = InitDeclaratorList_99_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_99_list);
		Assert.assertEquals(1, InitDeclarator_99_list.size());
		//99
		final InitDeclarator InitDeclarator_100_Var
		 = (InitDeclarator)InitDeclarator_99_list.get(0);
		Assert.assertNotNull(InitDeclarator_100_Var
		);
		//100
		final Declarator Declarator_101_Var
		 = (Declarator)InitDeclarator_100_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_101_Var
		);
		//101
		final DirectDeclarator DirectDeclarator_102_Var
		 = (DirectDeclarator)Declarator_101_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_102_Var
		);
		Assert.assertEquals("j", DirectDeclarator_102_Var
		.getIdent());
		final EList<? extends EObject> DeclaratorSuffix_102_list = DirectDeclarator_102_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_102_list);
		Assert.assertEquals(1, DeclaratorSuffix_102_list.size());
		//102
		final DeclaratorSuffix DeclaratorSuffix_103_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_102_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_103_Var
		);
		//103
		final PrimaryExpression PrimaryExpression_104_Var
		 = (PrimaryExpression)DeclaratorSuffix_103_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_104_Var
		);
		//104
		final Constant2 Constant2_105_Var
		 = (Constant2)PrimaryExpression_104_Var
		.getConst();
		Assert.assertNotNull(Constant2_105_Var
		);
		Assert.assertEquals("255", Constant2_105_Var
		.getDec());
		//105
		final Initializer Initializer_106_Var
		 = (Initializer)InitDeclarator_100_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_106_Var
		);
		//106
		final PrimaryExpression PrimaryExpression_107_Var
		 = (PrimaryExpression)Initializer_106_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_107_Var
		);
		Assert.assertEquals("[\"k, l\"]", PrimaryExpression_107_Var
		.getString().toString());
	}
	
	
}


