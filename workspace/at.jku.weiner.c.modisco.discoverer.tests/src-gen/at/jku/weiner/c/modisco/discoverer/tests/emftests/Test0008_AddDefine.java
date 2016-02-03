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

@SuppressWarnings("unused")
public class Test0008_AddDefine {
	
	private final String pureJavaClassFileName = "Test0008_AddDefine";
	private final String sourceFile = "res/Test0008_AddDefine";
	private Map<String,Object> options;
	
	@Before
	public void initialize(){
		options = at.jku.weiner.c.modisco.discoverer.tests.EMFTest.getOptions(
			this.pureJavaClassFileName, this.sourceFile);
		at.jku.weiner.c.modisco.discoverer.tests.EMFTest.addDefine();
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
		final EObject obj = at.jku.weiner.c.modisco.discoverer.tests.EMFTest.emfTest(
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
		Assert.assertEquals(1, Lines_5_list.size());
		//5
		final Code Code_6_Var
		 = (Code)Lines_5_list.get(0);
		Assert.assertNotNull(Code_6_Var
		);
		Assert.assertEquals("__MY_TYPE__ var1;", Code_6_Var
		.getCode());
		//6
		final Parser Parser_7_Var
		 = (Parser)TranslationUnit_3_Var
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
		Assert.assertEquals(2, DeclarationSpecifier_10_list.size());
		//10
		final TypeSpecifier TypeSpecifier_11_Var
		 = (TypeSpecifier)DeclarationSpecifier_10_list.get(0);
		Assert.assertNotNull(TypeSpecifier_11_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_11_Var
		.getName());
		//11
		final TypeSpecifier TypeSpecifier_12_Var
		 = (TypeSpecifier)DeclarationSpecifier_10_list.get(1);
		Assert.assertNotNull(TypeSpecifier_12_Var
		);
		Assert.assertEquals("int", TypeSpecifier_12_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_12_list = Declaration_9_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_12_list);
		Assert.assertEquals(1, InitDeclaratorList_12_list.size());
		//12
		final InitDeclaratorList InitDeclaratorList_13_Var
		 = (InitDeclaratorList)InitDeclaratorList_12_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_13_Var
		);
		final EList<? extends EObject> InitDeclarator_13_list = InitDeclaratorList_13_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_13_list);
		Assert.assertEquals(1, InitDeclarator_13_list.size());
		//13
		final InitDeclarator InitDeclarator_14_Var
		 = (InitDeclarator)InitDeclarator_13_list.get(0);
		Assert.assertNotNull(InitDeclarator_14_Var
		);
		//14
		final Declarator Declarator_15_Var
		 = (Declarator)InitDeclarator_14_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_15_Var
		);
		//15
		final DirectDeclarator DirectDeclarator_16_Var
		 = (DirectDeclarator)Declarator_15_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_16_Var
		);
		Assert.assertEquals("var1", DirectDeclarator_16_Var
		.getId());
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/" + options.get("sourceFile") + "/Simple.c", TranslationUnit_3_Var
		.getPath());
	}
	
	
}


