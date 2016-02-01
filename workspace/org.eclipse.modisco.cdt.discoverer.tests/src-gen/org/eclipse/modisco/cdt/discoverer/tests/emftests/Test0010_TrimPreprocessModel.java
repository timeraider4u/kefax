package org.eclipse.modisco.cdt.discoverer.tests.emftests;

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
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.IncludeDirective;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
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
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;

@SuppressWarnings("unused")
public class Test0010_TrimPreprocessModel {
	
	private final String pureJavaClassFileName = "Test0010_TrimPreprocessModel";
	private final String sourceFile = "res/Test0010_TrimPreprocessModel";
	private Map<String,Object> options;
	
	@Before
	public void initialize(){
		options = org.eclipse.modisco.cdt.discoverer.tests.EMFTest.getOptions(
			this.pureJavaClassFileName, this.sourceFile);
		org.eclipse.modisco.cdt.discoverer.tests.EMFTest.doTrim();
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
		final EObject obj = org.eclipse.modisco.cdt.discoverer.tests.EMFTest.emfTest(
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
		Assert.assertEquals(3, Units_0_list.size());
		//0
		final TranslationUnit TranslationUnit_1_Var
		 = (TranslationUnit)Units_0_list.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var
		);
		//1
		final TranslationUnit TranslationUnit_2_Var
		 = (TranslationUnit)Units_0_list.get(1);
		Assert.assertNotNull(TranslationUnit_2_Var
		);
		//2
		final Preprocess Preprocess_3_Var
		 = (Preprocess)TranslationUnit_2_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_3_Var
		);
		//3
		final GroupOpt GroupOpt_4_Var
		 = (GroupOpt)Preprocess_3_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_4_Var
		);
		final EList<? extends EObject> Lines_4_list = GroupOpt_4_Var
		.getLines();
		Assert.assertNotNull(Lines_4_list);
		Assert.assertEquals(2, Lines_4_list.size());
		//4
		final PreprocessorDirectives PreprocessorDirectives_5_Var
		 = (PreprocessorDirectives)Lines_4_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_5_Var
		);
		//5
		final IncludeDirective IncludeDirective_6_Var
		 = (IncludeDirective)PreprocessorDirectives_5_Var
		.getDirective();
		Assert.assertNotNull(IncludeDirective_6_Var
		);
		Assert.assertEquals("\"../include/SimpleInclude.h\"", IncludeDirective_6_Var
		.getString());
		//6
		final PreprocessorDirectives PreprocessorDirectives_7_Var
		 = (PreprocessorDirectives)Lines_4_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_7_Var
		);
		//7
		final DefineObjectMacro DefineObjectMacro_8_Var
		 = (DefineObjectMacro)PreprocessorDirectives_7_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_8_Var
		);
		Assert.assertEquals("FOO", DefineObjectMacro_8_Var
		.getId());
		Assert.assertEquals("bar", DefineObjectMacro_8_Var
		.getString());
		//8
		final Parser Parser_9_Var
		 = (Parser)TranslationUnit_2_Var
		.getParser();
		Assert.assertNotNull(Parser_9_Var
		);
		final EList<? extends EObject> External_9_list = Parser_9_Var
		.getExternal();
		Assert.assertNotNull(External_9_list);
		Assert.assertEquals(3, External_9_list.size());
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
		Assert.assertEquals("extern", StorageClassSpecifier_13_Var
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
		Assert.assertEquals("getValue", DirectDeclarator_18_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_18_list = DirectDeclarator_18_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_18_list);
		Assert.assertEquals(1, DeclaratorSuffix_18_list.size());
		//18
		final DeclaratorSuffix DeclaratorSuffix_19_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_18_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_19_Var
		);
		//19
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_20_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_19_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_20_Var
		);
		Assert.assertEquals(";", Declaration_11_Var
		.getSemi());
		//20
		final ExternalDeclaration ExternalDeclaration_21_Var
		 = (ExternalDeclaration)External_9_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_21_Var
		);
		//21
		final Declaration Declaration_22_Var
		 = (Declaration)ExternalDeclaration_21_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_22_Var
		);
		//22
		final DeclarationSpecifiers DeclarationSpecifiers_23_Var
		 = (DeclarationSpecifiers)Declaration_22_Var
		.getSpecifiers();
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
		final EList<? extends EObject> InitDeclaratorList_24_list = Declaration_22_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_24_list);
		Assert.assertEquals(1, InitDeclaratorList_24_list.size());
		//24
		final InitDeclaratorList InitDeclaratorList_25_Var
		 = (InitDeclaratorList)InitDeclaratorList_24_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_25_Var
		);
		final EList<? extends EObject> InitDeclarator_25_list = InitDeclaratorList_25_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_25_list);
		Assert.assertEquals(1, InitDeclarator_25_list.size());
		//25
		final InitDeclarator InitDeclarator_26_Var
		 = (InitDeclarator)InitDeclarator_25_list.get(0);
		Assert.assertNotNull(InitDeclarator_26_Var
		);
		//26
		final Declarator Declarator_27_Var
		 = (Declarator)InitDeclarator_26_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_27_Var
		);
		//27
		final DirectDeclarator DirectDeclarator_28_Var
		 = (DirectDeclarator)Declarator_27_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_28_Var
		);
		Assert.assertEquals("bar", DirectDeclarator_28_Var
		.getId());
		Assert.assertEquals(";", Declaration_22_Var
		.getSemi());
		//28
		final ExternalDeclaration ExternalDeclaration_29_Var
		 = (ExternalDeclaration)External_9_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_29_Var
		);
		//29
		final Declaration Declaration_30_Var
		 = (Declaration)ExternalDeclaration_29_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_30_Var
		);
		//30
		final DeclarationSpecifiers DeclarationSpecifiers_31_Var
		 = (DeclarationSpecifiers)Declaration_30_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_31_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_31_list = DeclarationSpecifiers_31_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_31_list);
		Assert.assertEquals(1, DeclarationSpecifier_31_list.size());
		//31
		final TypeSpecifier TypeSpecifier_32_Var
		 = (TypeSpecifier)DeclarationSpecifier_31_list.get(0);
		Assert.assertNotNull(TypeSpecifier_32_Var
		);
		Assert.assertEquals("int", TypeSpecifier_32_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_32_list = Declaration_30_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_32_list);
		Assert.assertEquals(1, InitDeclaratorList_32_list.size());
		//32
		final InitDeclaratorList InitDeclaratorList_33_Var
		 = (InitDeclaratorList)InitDeclaratorList_32_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_33_Var
		);
		final EList<? extends EObject> InitDeclarator_33_list = InitDeclaratorList_33_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_33_list);
		Assert.assertEquals(1, InitDeclarator_33_list.size());
		//33
		final InitDeclarator InitDeclarator_34_Var
		 = (InitDeclarator)InitDeclarator_33_list.get(0);
		Assert.assertNotNull(InitDeclarator_34_Var
		);
		//34
		final Declarator Declarator_35_Var
		 = (Declarator)InitDeclarator_34_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_35_Var
		);
		//35
		final DirectDeclarator DirectDeclarator_36_Var
		 = (DirectDeclarator)Declarator_35_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_36_Var
		);
		Assert.assertEquals("foobar", DirectDeclarator_36_Var
		.getId());
		Assert.assertEquals(";", Declaration_30_Var
		.getSemi());
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/" + options.get("sourceFile") + "/File.c", TranslationUnit_2_Var
		.getPath());
		//36
		final TranslationUnit TranslationUnit_37_Var
		 = (TranslationUnit)Units_0_list.get(2);
		Assert.assertNotNull(TranslationUnit_37_Var
		);
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/res/include/SimpleInclude.h", TranslationUnit_37_Var
		.getPath());
		//37
		final Preprocess Preprocess_38_Var
		 = (Preprocess)TranslationUnit_37_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_38_Var
		);
		//38
		final GroupOpt GroupOpt_39_Var
		 = (GroupOpt)Preprocess_38_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_39_Var
		);
		final EList<? extends EObject> Lines_39_list = GroupOpt_39_Var
		.getLines();
		Assert.assertNotNull(Lines_39_list);
		Assert.assertEquals(1, Lines_39_list.size());
		//39
		final PreprocessorDirectives PreprocessorDirectives_40_Var
		 = (PreprocessorDirectives)Lines_39_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_40_Var
		);
		//40
		final DefineObjectMacro DefineObjectMacro_41_Var
		 = (DefineObjectMacro)PreprocessorDirectives_40_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_41_Var
		);
		Assert.assertEquals("NUMBER", DefineObjectMacro_41_Var
		.getId());
		Assert.assertEquals("int", DefineObjectMacro_41_Var
		.getString());
		Assert.assertNull(TranslationUnit_37_Var
		.getParser());
	}
	
	
}


