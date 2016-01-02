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
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.IncludeDirective;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.parser.parser.Parser;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;

@SuppressWarnings("unused")
public class Test0004_Predef {
	
	private final String pureJavaClassFileName = "Test0004_Predef";
	private final String sourceFile = "res/Test0004_Predef";
	private Map<String,Object> options;
	
	@Before
	public void initialize(){
		options = org.eclipse.modisco.cdt.discoverer.tests.EMFTest.getOptions(
			this.pureJavaClassFileName, this.sourceFile);
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
		Assert.assertEquals("platform:/plugin/at.jku.weiner.c.preprocess/res/predefined/gcc_4.8.4.h", TranslationUnit_1_Var
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
		Assert.assertEquals(3, Lines_5_list.size());
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
		Assert.assertEquals("\"../include/SimplePredef.h\"", IncludeDirective_7_Var
		.getString());
		//7
		final NewLineLine NewLineLine_8_Var
		 = (NewLineLine)Lines_5_list.get(1);
		Assert.assertNotNull(NewLineLine_8_Var
		);
		//8
		final Code Code_9_Var
		 = (Code)Lines_5_list.get(2);
		Assert.assertNotNull(Code_9_Var
		);
		Assert.assertEquals("__CHAR32_TYPE__ anotherVar2;", Code_9_Var
		.getCode());
		//9
		final Parser Parser_10_Var
		 = (Parser)TranslationUnit_3_Var
		.getParser();
		Assert.assertNotNull(Parser_10_Var
		);
		final EList<? extends EObject> External_10_list = Parser_10_Var
		.getExternal();
		Assert.assertNotNull(External_10_list);
		Assert.assertEquals(2, External_10_list.size());
		//10
		final ExternalDeclaration ExternalDeclaration_11_Var
		 = (ExternalDeclaration)External_10_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_11_Var
		);
		//11
		final Declaration Declaration_12_Var
		 = (Declaration)ExternalDeclaration_11_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_12_Var
		);
		//12
		final DeclarationSpecifiers DeclarationSpecifiers_13_Var
		 = (DeclarationSpecifiers)Declaration_12_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_13_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_13_list = DeclarationSpecifiers_13_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_13_list);
		Assert.assertEquals(2, DeclarationSpecifier_13_list.size());
		//13
		final TypeSpecifier TypeSpecifier_14_Var
		 = (TypeSpecifier)DeclarationSpecifier_13_list.get(0);
		Assert.assertNotNull(TypeSpecifier_14_Var
		);
		Assert.assertEquals("long", TypeSpecifier_14_Var
		.getName());
		//14
		final TypeSpecifier TypeSpecifier_15_Var
		 = (TypeSpecifier)DeclarationSpecifier_13_list.get(1);
		Assert.assertNotNull(TypeSpecifier_15_Var
		);
		Assert.assertEquals("int", TypeSpecifier_15_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_15_list = Declaration_12_Var
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
		Assert.assertEquals("myVar1", DirectDeclarator_19_Var
		.getId());
		Assert.assertEquals(";", Declaration_12_Var
		.getSemi());
		//19
		final ExternalDeclaration ExternalDeclaration_20_Var
		 = (ExternalDeclaration)External_10_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_20_Var
		);
		//20
		final Declaration Declaration_21_Var
		 = (Declaration)ExternalDeclaration_20_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_21_Var
		);
		//21
		final DeclarationSpecifiers DeclarationSpecifiers_22_Var
		 = (DeclarationSpecifiers)Declaration_21_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_22_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_22_list = DeclarationSpecifiers_22_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_22_list);
		Assert.assertEquals(2, DeclarationSpecifier_22_list.size());
		//22
		final TypeSpecifier TypeSpecifier_23_Var
		 = (TypeSpecifier)DeclarationSpecifier_22_list.get(0);
		Assert.assertNotNull(TypeSpecifier_23_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_23_Var
		.getName());
		//23
		final TypeSpecifier TypeSpecifier_24_Var
		 = (TypeSpecifier)DeclarationSpecifier_22_list.get(1);
		Assert.assertNotNull(TypeSpecifier_24_Var
		);
		Assert.assertEquals("int", TypeSpecifier_24_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_24_list = Declaration_21_Var
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
		Assert.assertEquals("anotherVar2", DirectDeclarator_28_Var
		.getId());
		Assert.assertEquals(";", Declaration_21_Var
		.getSemi());
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/" + options.get("sourceFile") + "/Simple.c", TranslationUnit_3_Var
		.getPath());
		//28
		final TranslationUnit TranslationUnit_29_Var
		 = (TranslationUnit)Units_0_list.get(2);
		Assert.assertNotNull(TranslationUnit_29_Var
		);
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/res/include/SimplePredef.h", TranslationUnit_29_Var
		.getPath());
		//29
		final Preprocess Preprocess_30_Var
		 = (Preprocess)TranslationUnit_29_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_30_Var
		);
		//30
		final GroupOpt GroupOpt_31_Var
		 = (GroupOpt)Preprocess_30_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_31_Var
		);
		final EList<? extends EObject> Lines_31_list = GroupOpt_31_Var
		.getLines();
		Assert.assertNotNull(Lines_31_list);
		Assert.assertEquals(1, Lines_31_list.size());
		//31
		final Code Code_32_Var
		 = (Code)Lines_31_list.get(0);
		Assert.assertNotNull(Code_32_Var
		);
		Assert.assertEquals("__INTMAX_TYPE__ myVar1;", Code_32_Var
		.getCode());
		Assert.assertNull(TranslationUnit_29_Var
		.getParser());
	}
	
	
}


