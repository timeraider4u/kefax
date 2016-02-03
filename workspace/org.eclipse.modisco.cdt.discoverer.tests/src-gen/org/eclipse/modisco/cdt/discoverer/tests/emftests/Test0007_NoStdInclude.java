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
import at.jku.weiner.c.parser.parser.Parser;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
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
		Assert.assertEquals(2, Units_0_list.size());
		//0
		final TranslationUnit TranslationUnit_1_Var
		 = (TranslationUnit)Units_0_list.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var
		);
		Assert.assertEquals("platform:/plugin/at.jku.weiner.c.preprocess/res/predefined/gcc_4.8.4_nostdinc.h", TranslationUnit_1_Var
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
		final Parser Parser_5_Var
		 = (Parser)TranslationUnit_3_Var
		.getParser();
		Assert.assertNotNull(Parser_5_Var
		);
		final EList<? extends EObject> External_5_list = Parser_5_Var
		.getExternal();
		Assert.assertNotNull(External_5_list);
		Assert.assertEquals(2, External_5_list.size());
		//5
		final ExternalDeclaration ExternalDeclaration_6_Var
		 = (ExternalDeclaration)External_5_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_6_Var
		);
		//6
		final Declaration Declaration_7_Var
		 = (Declaration)ExternalDeclaration_6_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_7_Var
		);
		//7
		final DeclarationSpecifiers DeclarationSpecifiers_8_Var
		 = (DeclarationSpecifiers)Declaration_7_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_8_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_8_list = DeclarationSpecifiers_8_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_8_list);
		Assert.assertEquals(1, DeclarationSpecifier_8_list.size());
		//8
		final TypeSpecifier TypeSpecifier_9_Var
		 = (TypeSpecifier)DeclarationSpecifier_8_list.get(0);
		Assert.assertNotNull(TypeSpecifier_9_Var
		);
		Assert.assertEquals("int", TypeSpecifier_9_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_9_list = Declaration_7_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_9_list);
		Assert.assertEquals(1, InitDeclaratorList_9_list.size());
		//9
		final InitDeclaratorList InitDeclaratorList_10_Var
		 = (InitDeclaratorList)InitDeclaratorList_9_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_10_Var
		);
		final EList<? extends EObject> InitDeclarator_10_list = InitDeclaratorList_10_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_10_list);
		Assert.assertEquals(1, InitDeclarator_10_list.size());
		//10
		final InitDeclarator InitDeclarator_11_Var
		 = (InitDeclarator)InitDeclarator_10_list.get(0);
		Assert.assertNotNull(InitDeclarator_11_Var
		);
		//11
		final Declarator Declarator_12_Var
		 = (Declarator)InitDeclarator_11_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_12_Var
		);
		//12
		final DirectDeclarator DirectDeclarator_13_Var
		 = (DirectDeclarator)Declarator_12_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_13_Var
		);
		Assert.assertEquals("i", DirectDeclarator_13_Var
		.getId());
		Assert.assertTrue(DirectDeclarator_13_Var
		.getDeclaratorSuffix().isEmpty());
		//13
		final Initializer Initializer_14_Var
		 = (Initializer)InitDeclarator_11_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_14_Var
		);
		//14
		final PrimaryExpression PrimaryExpression_15_Var
		 = (PrimaryExpression)Initializer_14_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_15_Var
		);
		//15
		final Constant2 Constant2_16_Var
		 = (Constant2)PrimaryExpression_15_Var
		.getConst();
		Assert.assertNotNull(Constant2_16_Var
		);
		Assert.assertEquals("1", Constant2_16_Var
		.getDec());
		//16
		final ExternalDeclaration ExternalDeclaration_17_Var
		 = (ExternalDeclaration)External_5_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_17_Var
		);
		//17
		final Declaration Declaration_18_Var
		 = (Declaration)ExternalDeclaration_17_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_18_Var
		);
		//18
		final DeclarationSpecifiers DeclarationSpecifiers_19_Var
		 = (DeclarationSpecifiers)Declaration_18_Var
		.getSpecifiers();
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
		Assert.assertEquals("int", TypeSpecifier_20_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_20_list = Declaration_18_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_20_list);
		Assert.assertEquals(1, InitDeclaratorList_20_list.size());
		//20
		final InitDeclaratorList InitDeclaratorList_21_Var
		 = (InitDeclaratorList)InitDeclaratorList_20_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_21_Var
		);
		final EList<? extends EObject> InitDeclarator_21_list = InitDeclaratorList_21_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_21_list);
		Assert.assertEquals(1, InitDeclarator_21_list.size());
		//21
		final InitDeclarator InitDeclarator_22_Var
		 = (InitDeclarator)InitDeclarator_21_list.get(0);
		Assert.assertNotNull(InitDeclarator_22_Var
		);
		//22
		final Declarator Declarator_23_Var
		 = (Declarator)InitDeclarator_22_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_23_Var
		);
		//23
		final DirectDeclarator DirectDeclarator_24_Var
		 = (DirectDeclarator)Declarator_23_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_24_Var
		);
		Assert.assertEquals("_STDC_PREDEF_H", DirectDeclarator_24_Var
		.getId());
		Assert.assertTrue(DirectDeclarator_24_Var
		.getDeclaratorSuffix().isEmpty());
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/" + options.get("sourceFile") + "/Empty.c", TranslationUnit_3_Var
		.getPath());
	}
	
	
}


