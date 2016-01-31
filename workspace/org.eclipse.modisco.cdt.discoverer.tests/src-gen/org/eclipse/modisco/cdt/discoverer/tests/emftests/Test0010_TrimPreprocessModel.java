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
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
import at.jku.weiner.c.parser.parser.Parser;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;

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
		Assert.assertEquals(2, Units_0_list.size());
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
		Assert.assertEquals(1, Lines_4_list.size());
		//4
		final PreprocessorDirectives PreprocessorDirectives_5_Var
		 = (PreprocessorDirectives)Lines_4_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_5_Var
		);
		//5
		final DefineObjectMacro DefineObjectMacro_6_Var
		 = (DefineObjectMacro)PreprocessorDirectives_5_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_6_Var
		);
		Assert.assertEquals("FOO", DefineObjectMacro_6_Var
		.getId());
		Assert.assertEquals("bar", DefineObjectMacro_6_Var
		.getString());
		//6
		final Parser Parser_7_Var
		 = (Parser)TranslationUnit_2_Var
		.getParser();
		Assert.assertNotNull(Parser_7_Var
		);
		final EList<? extends EObject> External_7_list = Parser_7_Var
		.getExternal();
		Assert.assertNotNull(External_7_list);
		Assert.assertEquals(1, External_7_list.size());
		//7
		final ExternalDeclaration ExternalDeclaration_8_Var
		 = (ExternalDeclaration)External_7_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_8_Var
		);
		//8
		final Declaration Declaration_9_Var
		 = (Declaration)ExternalDeclaration_8_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_9_Var
		);
		//9
		final DeclarationSpecifiers DeclarationSpecifiers_10_Var
		 = (DeclarationSpecifiers)Declaration_9_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_10_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_10_list = DeclarationSpecifiers_10_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_10_list);
		Assert.assertEquals(1, DeclarationSpecifier_10_list.size());
		//10
		final TypeSpecifier TypeSpecifier_11_Var
		 = (TypeSpecifier)DeclarationSpecifier_10_list.get(0);
		Assert.assertNotNull(TypeSpecifier_11_Var
		);
		Assert.assertEquals("int", TypeSpecifier_11_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_11_list = Declaration_9_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_11_list);
		Assert.assertEquals(1, InitDeclaratorList_11_list.size());
		//11
		final InitDeclaratorList InitDeclaratorList_12_Var
		 = (InitDeclaratorList)InitDeclaratorList_11_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_12_Var
		);
		final EList<? extends EObject> InitDeclarator_12_list = InitDeclaratorList_12_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_12_list);
		Assert.assertEquals(1, InitDeclarator_12_list.size());
		//12
		final InitDeclarator InitDeclarator_13_Var
		 = (InitDeclarator)InitDeclarator_12_list.get(0);
		Assert.assertNotNull(InitDeclarator_13_Var
		);
		//13
		final Declarator Declarator_14_Var
		 = (Declarator)InitDeclarator_13_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_14_Var
		);
		//14
		final DirectDeclarator DirectDeclarator_15_Var
		 = (DirectDeclarator)Declarator_14_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_15_Var
		);
		Assert.assertEquals("bar", DirectDeclarator_15_Var
		.getId());
		Assert.assertEquals(";", Declaration_9_Var
		.getSemi());
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/" + options.get("sourceFile") + "/File.c", TranslationUnit_2_Var
		.getPath());
	}
	
	
}


