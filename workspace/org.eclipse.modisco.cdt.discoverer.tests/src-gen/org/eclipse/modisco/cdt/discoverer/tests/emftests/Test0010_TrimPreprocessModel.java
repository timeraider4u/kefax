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
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.ConditionalDirective;
import at.jku.weiner.c.preprocess.preprocess.IfDefConditional;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
import at.jku.weiner.c.preprocess.preprocess.ElseConditional;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
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
		Assert.assertEquals(3, Lines_4_list.size());
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
		final PreprocessorDirectives PreprocessorDirectives_9_Var
		 = (PreprocessorDirectives)Lines_4_list.get(2);
		Assert.assertNotNull(PreprocessorDirectives_9_Var
		);
		//9
		final ConditionalDirective ConditionalDirective_10_Var
		 = (ConditionalDirective)PreprocessorDirectives_9_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_10_Var
		);
		//10
		final IfDefConditional IfDefConditional_11_Var
		 = (IfDefConditional)ConditionalDirective_10_Var
		.getConditional();
		Assert.assertNotNull(IfDefConditional_11_Var
		);
		Assert.assertEquals("FOO", IfDefConditional_11_Var
		.getId());
		//11
		final GroupOpt GroupOpt_12_Var
		 = (GroupOpt)IfDefConditional_11_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_12_Var
		);
		final EList<? extends EObject> Lines_12_list = GroupOpt_12_Var
		.getLines();
		Assert.assertNotNull(Lines_12_list);
		Assert.assertEquals(1, Lines_12_list.size());
		//12
		final PreprocessorDirectives PreprocessorDirectives_13_Var
		 = (PreprocessorDirectives)Lines_12_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_13_Var
		);
		//13
		final DefineObjectMacro DefineObjectMacro_14_Var
		 = (DefineObjectMacro)PreprocessorDirectives_13_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_14_Var
		);
		Assert.assertEquals("SOMETHING", DefineObjectMacro_14_Var
		.getId());
		Assert.assertEquals("baz", DefineObjectMacro_14_Var
		.getString());
		//14
		final ElseConditional ElseConditional_15_Var
		 = (ElseConditional)ConditionalDirective_10_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_15_Var
		);
		//15
		final GroupOpt GroupOpt_16_Var
		 = (GroupOpt)ElseConditional_15_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_16_Var
		);
		Assert.assertTrue(GroupOpt_16_Var
		.getLines().isEmpty());
		//16
		final Parser Parser_17_Var
		 = (Parser)TranslationUnit_2_Var
		.getParser();
		Assert.assertNotNull(Parser_17_Var
		);
		final EList<? extends EObject> External_17_list = Parser_17_Var
		.getExternal();
		Assert.assertNotNull(External_17_list);
		Assert.assertEquals(3, External_17_list.size());
		//17
		final ExternalDeclaration ExternalDeclaration_18_Var
		 = (ExternalDeclaration)External_17_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_18_Var
		);
		//18
		final Declaration Declaration_19_Var
		 = (Declaration)ExternalDeclaration_18_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_19_Var
		);
		//19
		final DeclarationSpecifiers DeclarationSpecifiers_20_Var
		 = (DeclarationSpecifiers)Declaration_19_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_20_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_20_list = DeclarationSpecifiers_20_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_20_list);
		Assert.assertEquals(2, DeclarationSpecifier_20_list.size());
		//20
		final StorageClassSpecifier StorageClassSpecifier_21_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_20_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_21_Var
		);
		Assert.assertEquals("extern", StorageClassSpecifier_21_Var
		.getName());
		//21
		final TypeSpecifier TypeSpecifier_22_Var
		 = (TypeSpecifier)DeclarationSpecifier_20_list.get(1);
		Assert.assertNotNull(TypeSpecifier_22_Var
		);
		Assert.assertEquals("int", TypeSpecifier_22_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_22_list = Declaration_19_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_22_list);
		Assert.assertEquals(1, InitDeclaratorList_22_list.size());
		//22
		final InitDeclaratorList InitDeclaratorList_23_Var
		 = (InitDeclaratorList)InitDeclaratorList_22_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_23_Var
		);
		final EList<? extends EObject> InitDeclarator_23_list = InitDeclaratorList_23_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_23_list);
		Assert.assertEquals(1, InitDeclarator_23_list.size());
		//23
		final InitDeclarator InitDeclarator_24_Var
		 = (InitDeclarator)InitDeclarator_23_list.get(0);
		Assert.assertNotNull(InitDeclarator_24_Var
		);
		//24
		final Declarator Declarator_25_Var
		 = (Declarator)InitDeclarator_24_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_25_Var
		);
		//25
		final DirectDeclarator DirectDeclarator_26_Var
		 = (DirectDeclarator)Declarator_25_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_26_Var
		);
		Assert.assertEquals("getValue", DirectDeclarator_26_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_26_list = DirectDeclarator_26_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_26_list);
		Assert.assertEquals(1, DeclaratorSuffix_26_list.size());
		//26
		final DeclaratorSuffix DeclaratorSuffix_27_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_26_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_27_Var
		);
		//27
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_28_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_27_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_28_Var
		);
		Assert.assertEquals(";", Declaration_19_Var
		.getSemi());
		//28
		final ExternalDeclaration ExternalDeclaration_29_Var
		 = (ExternalDeclaration)External_17_list.get(1);
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
		Assert.assertEquals("bar", DirectDeclarator_36_Var
		.getId());
		Assert.assertEquals(";", Declaration_30_Var
		.getSemi());
		//36
		final ExternalDeclaration ExternalDeclaration_37_Var
		 = (ExternalDeclaration)External_17_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_37_Var
		);
		//37
		final Declaration Declaration_38_Var
		 = (Declaration)ExternalDeclaration_37_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_38_Var
		);
		//38
		final DeclarationSpecifiers DeclarationSpecifiers_39_Var
		 = (DeclarationSpecifiers)Declaration_38_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_39_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_39_list = DeclarationSpecifiers_39_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_39_list);
		Assert.assertEquals(1, DeclarationSpecifier_39_list.size());
		//39
		final TypeSpecifier TypeSpecifier_40_Var
		 = (TypeSpecifier)DeclarationSpecifier_39_list.get(0);
		Assert.assertNotNull(TypeSpecifier_40_Var
		);
		Assert.assertEquals("int", TypeSpecifier_40_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_40_list = Declaration_38_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_40_list);
		Assert.assertEquals(1, InitDeclaratorList_40_list.size());
		//40
		final InitDeclaratorList InitDeclaratorList_41_Var
		 = (InitDeclaratorList)InitDeclaratorList_40_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_41_Var
		);
		final EList<? extends EObject> InitDeclarator_41_list = InitDeclaratorList_41_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_41_list);
		Assert.assertEquals(1, InitDeclarator_41_list.size());
		//41
		final InitDeclarator InitDeclarator_42_Var
		 = (InitDeclarator)InitDeclarator_41_list.get(0);
		Assert.assertNotNull(InitDeclarator_42_Var
		);
		//42
		final Declarator Declarator_43_Var
		 = (Declarator)InitDeclarator_42_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_43_Var
		);
		//43
		final DirectDeclarator DirectDeclarator_44_Var
		 = (DirectDeclarator)Declarator_43_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_44_Var
		);
		Assert.assertEquals("foobar", DirectDeclarator_44_Var
		.getId());
		Assert.assertEquals(";", Declaration_38_Var
		.getSemi());
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/" + options.get("sourceFile") + "/File.c", TranslationUnit_2_Var
		.getPath());
		//44
		final TranslationUnit TranslationUnit_45_Var
		 = (TranslationUnit)Units_0_list.get(2);
		Assert.assertNotNull(TranslationUnit_45_Var
		);
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/res/include/SimpleInclude.h", TranslationUnit_45_Var
		.getPath());
		//45
		final Preprocess Preprocess_46_Var
		 = (Preprocess)TranslationUnit_45_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_46_Var
		);
		//46
		final GroupOpt GroupOpt_47_Var
		 = (GroupOpt)Preprocess_46_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_47_Var
		);
		final EList<? extends EObject> Lines_47_list = GroupOpt_47_Var
		.getLines();
		Assert.assertNotNull(Lines_47_list);
		Assert.assertEquals(1, Lines_47_list.size());
		//47
		final PreprocessorDirectives PreprocessorDirectives_48_Var
		 = (PreprocessorDirectives)Lines_47_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_48_Var
		);
		//48
		final DefineObjectMacro DefineObjectMacro_49_Var
		 = (DefineObjectMacro)PreprocessorDirectives_48_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_49_Var
		);
		Assert.assertEquals("NUMBER", DefineObjectMacro_49_Var
		.getId());
		Assert.assertEquals("int", DefineObjectMacro_49_Var
		.getString());
		Assert.assertNull(TranslationUnit_45_Var
		.getParser());
	}
	
	
}


