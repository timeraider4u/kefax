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
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
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
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
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

@SuppressWarnings("unused")
public class Test0014_InvalidChar {
	
	private final String pureJavaClassFileName = "Test0014_InvalidChar";
	private final String sourceFile = "res/Test0014_InvalidChar";
	private Map<String,Object> options;
	
	@Before
	public void initialize(){
		options = at.jku.weiner.c.modisco.discoverer.tests.EMFTest.getOptions(
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
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/" + options.get("sourceFile") + "/Simple.c", TranslationUnit_3_Var
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
		Assert.assertEquals(3, Lines_5_list.size());
		//5
		final Code Code_6_Var
		 = (Code)Lines_5_list.get(0);
		Assert.assertNotNull(Code_6_Var
		);
		Assert.assertEquals("extern int foo_bar();", Code_6_Var
		.getCode());
		//6
		final NewLineLine NewLineLine_7_Var
		 = (NewLineLine)Lines_5_list.get(1);
		Assert.assertNotNull(NewLineLine_7_Var
		);
		//7
		final Code Code_8_Var
		 = (Code)Lines_5_list.get(2);
		Assert.assertNotNull(Code_8_Var
		);
		Assert.assertEquals("extern int baz();", Code_8_Var
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
		Assert.assertEquals("foo_bar", DirectDeclarator_18_Var
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
		Assert.assertEquals(2, DeclarationSpecifier_23_list.size());
		//23
		final StorageClassSpecifier StorageClassSpecifier_24_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_23_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_24_Var
		);
		Assert.assertEquals("extern", StorageClassSpecifier_24_Var
		.getName());
		//24
		final TypeSpecifier TypeSpecifier_25_Var
		 = (TypeSpecifier)DeclarationSpecifier_23_list.get(1);
		Assert.assertNotNull(TypeSpecifier_25_Var
		);
		Assert.assertEquals("int", TypeSpecifier_25_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_25_list = Declaration_22_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_25_list);
		Assert.assertEquals(1, InitDeclaratorList_25_list.size());
		//25
		final InitDeclaratorList InitDeclaratorList_26_Var
		 = (InitDeclaratorList)InitDeclaratorList_25_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_26_Var
		);
		final EList<? extends EObject> InitDeclarator_26_list = InitDeclaratorList_26_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_26_list);
		Assert.assertEquals(1, InitDeclarator_26_list.size());
		//26
		final InitDeclarator InitDeclarator_27_Var
		 = (InitDeclarator)InitDeclarator_26_list.get(0);
		Assert.assertNotNull(InitDeclarator_27_Var
		);
		//27
		final Declarator Declarator_28_Var
		 = (Declarator)InitDeclarator_27_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_28_Var
		);
		//28
		final DirectDeclarator DirectDeclarator_29_Var
		 = (DirectDeclarator)Declarator_28_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_29_Var
		);
		Assert.assertEquals("baz", DirectDeclarator_29_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_29_list = DirectDeclarator_29_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_29_list);
		Assert.assertEquals(1, DeclaratorSuffix_29_list.size());
		//29
		final DeclaratorSuffix DeclaratorSuffix_30_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_29_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_30_Var
		);
		//30
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_31_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_30_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_31_Var
		);
	}
	
	
}


