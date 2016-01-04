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
public class Test0007_NoStdInclude {
	
	private final String pureJavaClassFileName = "Test0007_NoStdInclude";
	private final String sourceFile = "res/Test0007_NoStdInclude";
	private Map<String,Object> options;
	
	@Before
	public void initialize(){
		options = org.eclipse.modisco.cdt.discoverer.tests.EMFTest.getOptions(
			this.pureJavaClassFileName, this.sourceFile);
		org.eclipse.modisco.cdt.discoverer.tests.EMFTest.setNoStdInclude();
	}
	
	@After
	public void cleanUp() {
		org.eclipse.modisco.cdt.discoverer.tests.EMFTest.includeDirsIsEmpty();
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
		Assert.assertEquals(1, Units_0_list.size());
		//0
		final TranslationUnit TranslationUnit_1_Var
		 = (TranslationUnit)Units_0_list.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var
		);
		//1
		final Preprocess Preprocess_2_Var
		 = (Preprocess)TranslationUnit_1_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_2_Var
		);
		//2
		final Parser Parser_3_Var
		 = (Parser)TranslationUnit_1_Var
		.getParser();
		Assert.assertNotNull(Parser_3_Var
		);
		final EList<? extends EObject> External_3_list = Parser_3_Var
		.getExternal();
		Assert.assertNotNull(External_3_list);
		Assert.assertEquals(1, External_3_list.size());
		//3
		final ExternalDeclaration ExternalDeclaration_4_Var
		 = (ExternalDeclaration)External_3_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_4_Var
		);
		//4
		final Declaration Declaration_5_Var
		 = (Declaration)ExternalDeclaration_4_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_5_Var
		);
		//5
		final DeclarationSpecifiers DeclarationSpecifiers_6_Var
		 = (DeclarationSpecifiers)Declaration_5_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_6_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_6_list = DeclarationSpecifiers_6_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_6_list);
		Assert.assertEquals(1, DeclarationSpecifier_6_list.size());
		//6
		final TypeSpecifier TypeSpecifier_7_Var
		 = (TypeSpecifier)DeclarationSpecifier_6_list.get(0);
		Assert.assertNotNull(TypeSpecifier_7_Var
		);
		Assert.assertEquals("int", TypeSpecifier_7_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_7_list = Declaration_5_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_7_list);
		Assert.assertEquals(1, InitDeclaratorList_7_list.size());
		//7
		final InitDeclaratorList InitDeclaratorList_8_Var
		 = (InitDeclaratorList)InitDeclaratorList_7_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_8_Var
		);
		final EList<? extends EObject> InitDeclarator_8_list = InitDeclaratorList_8_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_8_list);
		Assert.assertEquals(1, InitDeclarator_8_list.size());
		//8
		final InitDeclarator InitDeclarator_9_Var
		 = (InitDeclarator)InitDeclarator_8_list.get(0);
		Assert.assertNotNull(InitDeclarator_9_Var
		);
		//9
		final Declarator Declarator_10_Var
		 = (Declarator)InitDeclarator_9_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_10_Var
		);
		//10
		final DirectDeclarator DirectDeclarator_11_Var
		 = (DirectDeclarator)Declarator_10_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_11_Var
		);
		Assert.assertEquals("__STDC__", DirectDeclarator_11_Var
		.getId());
		Assert.assertTrue(DirectDeclarator_11_Var
		.getDeclaratorSuffix().isEmpty());
		Assert.assertEquals(";", Declaration_5_Var
		.getSemi());
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/" + options.get("sourceFile") + "/Empty.c", TranslationUnit_1_Var
		.getPath());
	}
	
	
}


