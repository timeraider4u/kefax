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
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.IncludeDirective;
import at.jku.weiner.c.preprocess.preprocess.Code;
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

@SuppressWarnings("unused")
public class Test0013_BatchMode {
	
	private final String pureJavaClassFileName = "Test0013_BatchMode";
	private final String sourceFile = "res/Test0013_BatchMode";
	private Map<String,Object> options;
	
	@Before
	public void initialize(){
		options = at.jku.weiner.c.modisco.discoverer.tests.EMFTest.getOptions(
			this.pureJavaClassFileName, this.sourceFile);
		at.jku.weiner.c.modisco.discoverer.tests.EMFTest.test0013_before();
	}
	
	@After
	public void cleanUp() {
		at.jku.weiner.c.modisco.discoverer.tests.EMFTest.test0013_after();
	}
	
	private String getTextFromFile(final String fileName)
	throws Exception{
		final Path path = Paths.get(fileName);
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
				
	@Test (timeout=45000)
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
		Assert.assertEquals("platform:/plugin/at.jku.weiner.c.preprocess/res/predefined/gcc_4.9.3_default.h", TranslationUnit_1_Var
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
		Assert.assertEquals(2, Lines_5_list.size());
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
		Assert.assertEquals("\"../include/Test0013_TypeDef.h\"", IncludeDirective_7_Var
		.getString());
		//7
		final Code Code_8_Var
		 = (Code)Lines_5_list.get(1);
		Assert.assertNotNull(Code_8_Var
		);
		Assert.assertEquals("NUMBER i;", Code_8_Var
		.getCode());
		//8
		final Parser Parser_9_Var
		 = (Parser)TranslationUnit_3_Var
		.getParser();
		Assert.assertNotNull(Parser_9_Var
		);
		final EList<? extends EObject> External_9_list = Parser_9_Var
		.getExternal();
		Assert.assertNotNull(External_9_list);
		Assert.assertEquals(2, External_9_list.size());
		//9
		final ExternalDeclaration ExternalDeclaration_10_Var
		 = (ExternalDeclaration)External_9_list.get(0);
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
		Assert.assertEquals(2, DeclarationSpecifier_12_list.size());
		//12
		final StorageClassSpecifier StorageClassSpecifier_13_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_12_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_13_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_13_Var
		.getName());
		//13
		final TypeSpecifier TypeSpecifier_14_Var
		 = (TypeSpecifier)DeclarationSpecifier_12_list.get(1);
		Assert.assertNotNull(TypeSpecifier_14_Var
		);
		Assert.assertEquals("int", TypeSpecifier_14_Var
		.getName());
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
		Assert.assertEquals("NUMBER", DirectDeclarator_18_Var
		.getIdent());
		//18
		final ExternalDeclaration ExternalDeclaration_19_Var
		 = (ExternalDeclaration)External_9_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_19_Var
		);
		//19
		final Declaration Declaration_20_Var
		 = (Declaration)ExternalDeclaration_19_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_20_Var
		);
		//20
		final DeclarationSpecifiers DeclarationSpecifiers_21_Var
		 = (DeclarationSpecifiers)Declaration_20_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_21_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_21_list = DeclarationSpecifiers_21_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_21_list);
		Assert.assertEquals(1, DeclarationSpecifier_21_list.size());
		//21
		final TypeSpecifier TypeSpecifier_22_Var
		 = (TypeSpecifier)DeclarationSpecifier_21_list.get(0);
		Assert.assertNotNull(TypeSpecifier_22_Var
		);
		//22
		final TypedefName TypedefName_23_Var
		 = (TypedefName)TypeSpecifier_22_Var
		.getType();
		Assert.assertNotNull(TypedefName_23_Var
		);
		Assert.assertEquals("NUMBER", TypedefName_23_Var
		.getIdent());
		final EList<? extends EObject> InitDeclaratorList_23_list = Declaration_20_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_23_list);
		Assert.assertEquals(1, InitDeclaratorList_23_list.size());
		//23
		final InitDeclaratorList InitDeclaratorList_24_Var
		 = (InitDeclaratorList)InitDeclaratorList_23_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_24_Var
		);
		final EList<? extends EObject> InitDeclarator_24_list = InitDeclaratorList_24_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_24_list);
		Assert.assertEquals(1, InitDeclarator_24_list.size());
		//24
		final InitDeclarator InitDeclarator_25_Var
		 = (InitDeclarator)InitDeclarator_24_list.get(0);
		Assert.assertNotNull(InitDeclarator_25_Var
		);
		//25
		final Declarator Declarator_26_Var
		 = (Declarator)InitDeclarator_25_Var
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
		.getIdent());
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/res/Test0013_BatchMode1/A.c", TranslationUnit_3_Var
		.getPath());
		//27
		final TranslationUnit TranslationUnit_28_Var
		 = (TranslationUnit)Units_0_list.get(2);
		Assert.assertNotNull(TranslationUnit_28_Var
		);
		//28
		final Preprocess Preprocess_29_Var
		 = (Preprocess)TranslationUnit_28_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_29_Var
		);
		//29
		final GroupOpt GroupOpt_30_Var
		 = (GroupOpt)Preprocess_29_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_30_Var
		);
		final EList<? extends EObject> Lines_30_list = GroupOpt_30_Var
		.getLines();
		Assert.assertNotNull(Lines_30_list);
		Assert.assertEquals(1, Lines_30_list.size());
		//30
		final Code Code_31_Var
		 = (Code)Lines_30_list.get(0);
		Assert.assertNotNull(Code_31_Var
		);
		Assert.assertEquals("typedef int NUMBER;", Code_31_Var
		.getCode());
		Assert.assertNull(TranslationUnit_28_Var
		.getParser());
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/res/include/Test0013_TypeDef.h", TranslationUnit_28_Var
		.getPath());
		//31
		final TranslationUnit TranslationUnit_32_Var
		 = (TranslationUnit)Units_0_list.get(3);
		Assert.assertNotNull(TranslationUnit_32_Var
		);
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/res/Test0013_BatchMode2/B.c", TranslationUnit_32_Var
		.getPath());
		//32
		final Preprocess Preprocess_33_Var
		 = (Preprocess)TranslationUnit_32_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_33_Var
		);
		//33
		final GroupOpt GroupOpt_34_Var
		 = (GroupOpt)Preprocess_33_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_34_Var
		);
		final EList<? extends EObject> Lines_34_list = GroupOpt_34_Var
		.getLines();
		Assert.assertNotNull(Lines_34_list);
		Assert.assertEquals(2, Lines_34_list.size());
		//34
		final PreprocessorDirectives PreprocessorDirectives_35_Var
		 = (PreprocessorDirectives)Lines_34_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_35_Var
		);
		//35
		final IncludeDirective IncludeDirective_36_Var
		 = (IncludeDirective)PreprocessorDirectives_35_Var
		.getDirective();
		Assert.assertNotNull(IncludeDirective_36_Var
		);
		Assert.assertEquals("\"../include/Test0013_TypeDef.h\"", IncludeDirective_36_Var
		.getString());
		//36
		final Code Code_37_Var
		 = (Code)Lines_34_list.get(1);
		Assert.assertNotNull(Code_37_Var
		);
		Assert.assertEquals("NUMBER j;", Code_37_Var
		.getCode());
		//37
		final Parser Parser_38_Var
		 = (Parser)TranslationUnit_32_Var
		.getParser();
		Assert.assertNotNull(Parser_38_Var
		);
		final EList<? extends EObject> External_38_list = Parser_38_Var
		.getExternal();
		Assert.assertNotNull(External_38_list);
		Assert.assertEquals(2, External_38_list.size());
		//38
		final ExternalDeclaration ExternalDeclaration_39_Var
		 = (ExternalDeclaration)External_38_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_39_Var
		);
		//39
		final Declaration Declaration_40_Var
		 = (Declaration)ExternalDeclaration_39_Var
		.getDeclaration();
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
		Assert.assertEquals(2, DeclarationSpecifier_41_list.size());
		//41
		final StorageClassSpecifier StorageClassSpecifier_42_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_41_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_42_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_42_Var
		.getName());
		//42
		final TypeSpecifier TypeSpecifier_43_Var
		 = (TypeSpecifier)DeclarationSpecifier_41_list.get(1);
		Assert.assertNotNull(TypeSpecifier_43_Var
		);
		Assert.assertEquals("int", TypeSpecifier_43_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_43_list = Declaration_40_Var
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
		Assert.assertEquals("NUMBER", DirectDeclarator_47_Var
		.getIdent());
		//47
		final ExternalDeclaration ExternalDeclaration_48_Var
		 = (ExternalDeclaration)External_38_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_48_Var
		);
		//48
		final Declaration Declaration_49_Var
		 = (Declaration)ExternalDeclaration_48_Var
		.getDeclaration();
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
		//51
		final TypedefName TypedefName_52_Var
		 = (TypedefName)TypeSpecifier_51_Var
		.getType();
		Assert.assertNotNull(TypedefName_52_Var
		);
		Assert.assertEquals("NUMBER", TypedefName_52_Var
		.getIdent());
		final EList<? extends EObject> InitDeclaratorList_52_list = Declaration_49_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_52_list);
		Assert.assertEquals(1, InitDeclaratorList_52_list.size());
		//52
		final InitDeclaratorList InitDeclaratorList_53_Var
		 = (InitDeclaratorList)InitDeclaratorList_52_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_53_Var
		);
		final EList<? extends EObject> InitDeclarator_53_list = InitDeclaratorList_53_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_53_list);
		Assert.assertEquals(1, InitDeclarator_53_list.size());
		//53
		final InitDeclarator InitDeclarator_54_Var
		 = (InitDeclarator)InitDeclarator_53_list.get(0);
		Assert.assertNotNull(InitDeclarator_54_Var
		);
		//54
		final Declarator Declarator_55_Var
		 = (Declarator)InitDeclarator_54_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_55_Var
		);
		//55
		final DirectDeclarator DirectDeclarator_56_Var
		 = (DirectDeclarator)Declarator_55_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_56_Var
		);
		Assert.assertEquals("j", DirectDeclarator_56_Var
		.getIdent());
	}
	
	
}


