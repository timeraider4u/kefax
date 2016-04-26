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
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
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
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
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
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;

@SuppressWarnings("unused")
public class Test0012_BatchMode {
	
	private final String pureJavaClassFileName = "Test0012_BatchMode";
	private final String sourceFile = "res/Test0012_BatchMode";
	private Map<String,Object> options;
	
	@Before
	public void initialize(){
		options = at.jku.weiner.c.modisco.discoverer.tests.EMFTest.getOptions(
			this.pureJavaClassFileName, this.sourceFile);
		at.jku.weiner.c.modisco.discoverer.tests.EMFTest.test0012_before();
	}
	
	@After
	public void cleanUp() {
		at.jku.weiner.c.modisco.discoverer.tests.EMFTest.test0012_after();
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
		Assert.assertEquals(3, Units_0_list.size());
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
		final DefineObjectMacro DefineObjectMacro_7_Var
		 = (DefineObjectMacro)PreprocessorDirectives_6_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_7_Var
		);
		Assert.assertEquals("INT", DefineObjectMacro_7_Var
		.getIdent());
		Assert.assertEquals("int", DefineObjectMacro_7_Var
		.getString());
		//7
		final Code Code_8_Var
		 = (Code)Lines_5_list.get(1);
		Assert.assertNotNull(Code_8_Var
		);
		Assert.assertEquals("unsigned INT i = 0;", Code_8_Var
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
		Assert.assertEquals(1, External_9_list.size());
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
		final TypeSpecifier TypeSpecifier_13_Var
		 = (TypeSpecifier)DeclarationSpecifier_12_list.get(0);
		Assert.assertNotNull(TypeSpecifier_13_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_13_Var
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
		Assert.assertEquals("i", DirectDeclarator_18_Var
		.getIdent());
		//18
		final Initializer Initializer_19_Var
		 = (Initializer)InitDeclarator_16_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_19_Var
		);
		//19
		final PrimaryExpression PrimaryExpression_20_Var
		 = (PrimaryExpression)Initializer_19_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_20_Var
		);
		//20
		final Constant2 Constant2_21_Var
		 = (Constant2)PrimaryExpression_20_Var
		.getConst();
		Assert.assertNotNull(Constant2_21_Var
		);
		Assert.assertEquals("0", Constant2_21_Var
		.getDec());
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/res/Test0012_BatchMode1/Simple.c", TranslationUnit_3_Var
		.getPath());
		//21
		final TranslationUnit TranslationUnit_22_Var
		 = (TranslationUnit)Units_0_list.get(2);
		Assert.assertNotNull(TranslationUnit_22_Var
		);
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/res/Test0012_BatchMode2/Another.c", TranslationUnit_22_Var
		.getPath());
		//22
		final Preprocess Preprocess_23_Var
		 = (Preprocess)TranslationUnit_22_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_23_Var
		);
		//23
		final GroupOpt GroupOpt_24_Var
		 = (GroupOpt)Preprocess_23_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_24_Var
		);
		final EList<? extends EObject> Lines_24_list = GroupOpt_24_Var
		.getLines();
		Assert.assertNotNull(Lines_24_list);
		Assert.assertEquals(2, Lines_24_list.size());
		//24
		final PreprocessorDirectives PreprocessorDirectives_25_Var
		 = (PreprocessorDirectives)Lines_24_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_25_Var
		);
		//25
		final DefineObjectMacro DefineObjectMacro_26_Var
		 = (DefineObjectMacro)PreprocessorDirectives_25_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_26_Var
		);
		Assert.assertEquals("ANOTHER", DefineObjectMacro_26_Var
		.getIdent());
		Assert.assertEquals("1", DefineObjectMacro_26_Var
		.getString());
		//26
		final Code Code_27_Var
		 = (Code)Lines_24_list.get(1);
		Assert.assertNotNull(Code_27_Var
		);
		Assert.assertEquals("int j = ANOTHER;", Code_27_Var
		.getCode());
		//27
		final Parser Parser_28_Var
		 = (Parser)TranslationUnit_22_Var
		.getParser();
		Assert.assertNotNull(Parser_28_Var
		);
		final EList<? extends EObject> External_28_list = Parser_28_Var
		.getExternal();
		Assert.assertNotNull(External_28_list);
		Assert.assertEquals(1, External_28_list.size());
		//28
		final ExternalDeclaration ExternalDeclaration_29_Var
		 = (ExternalDeclaration)External_28_list.get(0);
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
		Assert.assertEquals("j", DirectDeclarator_36_Var
		.getIdent());
		//36
		final Initializer Initializer_37_Var
		 = (Initializer)InitDeclarator_34_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_37_Var
		);
		//37
		final PrimaryExpression PrimaryExpression_38_Var
		 = (PrimaryExpression)Initializer_37_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_38_Var
		);
		//38
		final Constant2 Constant2_39_Var
		 = (Constant2)PrimaryExpression_38_Var
		.getConst();
		Assert.assertNotNull(Constant2_39_Var
		);
		Assert.assertEquals("1", Constant2_39_Var
		.getDec());
	}
	
	
}


