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
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
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
		final AssignmentExpression AssignmentExpression_15_Var
		 = (AssignmentExpression)Initializer_14_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_15_Var
		);
		//15
		final ConditionalExpression ConditionalExpression_16_Var
		 = (ConditionalExpression)AssignmentExpression_15_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_16_Var
		);
		//16
		final LogicalOrExpression LogicalOrExpression_17_Var
		 = (LogicalOrExpression)ConditionalExpression_16_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = LogicalOrExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final LogicalAndExpression LogicalAndExpression_18_Var
		 = (LogicalAndExpression)Expr_17_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = LogicalAndExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final InclusiveOrExpression InclusiveOrExpression_19_Var
		 = (InclusiveOrExpression)Expr_18_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = InclusiveOrExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final ExclusiveOrExpression ExclusiveOrExpression_20_Var
		 = (ExclusiveOrExpression)Expr_19_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = ExclusiveOrExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final AndExpression AndExpression_21_Var
		 = (AndExpression)Expr_20_list.get(0);
		Assert.assertNotNull(AndExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = AndExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final EqualityExpression EqualityExpression_22_Var
		 = (EqualityExpression)Expr_21_list.get(0);
		Assert.assertNotNull(EqualityExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = EqualityExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final RelationalExpression RelationalExpression_23_Var
		 = (RelationalExpression)Expr_22_list.get(0);
		Assert.assertNotNull(RelationalExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = RelationalExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final ShiftExpression ShiftExpression_24_Var
		 = (ShiftExpression)Expr_23_list.get(0);
		Assert.assertNotNull(ShiftExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = ShiftExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final AdditiveExpression AdditiveExpression_25_Var
		 = (AdditiveExpression)Expr_24_list.get(0);
		Assert.assertNotNull(AdditiveExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = AdditiveExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final MultiplicativeExpression MultiplicativeExpression_26_Var
		 = (MultiplicativeExpression)Expr_25_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = MultiplicativeExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final CastExpression CastExpression_27_Var
		 = (CastExpression)Expr_26_list.get(0);
		Assert.assertNotNull(CastExpression_27_Var
		);
		//27
		final UnaryExpression UnaryExpression_28_Var
		 = (UnaryExpression)CastExpression_27_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_28_Var
		);
		//28
		final PostfixExpression PostfixExpression_29_Var
		 = (PostfixExpression)UnaryExpression_28_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = PostfixExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final PrimaryExpression PrimaryExpression_30_Var
		 = (PrimaryExpression)Expr_29_list.get(0);
		Assert.assertNotNull(PrimaryExpression_30_Var
		);
		//30
		final Constant2 Constant2_31_Var
		 = (Constant2)PrimaryExpression_30_Var
		.getConst();
		Assert.assertNotNull(Constant2_31_Var
		);
		Assert.assertEquals("1", Constant2_31_Var
		.getDec());
		Assert.assertEquals(";", Declaration_7_Var
		.getSemi());
		//31
		final ExternalDeclaration ExternalDeclaration_32_Var
		 = (ExternalDeclaration)External_5_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_32_Var
		);
		//32
		final Declaration Declaration_33_Var
		 = (Declaration)ExternalDeclaration_32_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_33_Var
		);
		//33
		final DeclarationSpecifiers DeclarationSpecifiers_34_Var
		 = (DeclarationSpecifiers)Declaration_33_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_34_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_34_list = DeclarationSpecifiers_34_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_34_list);
		Assert.assertEquals(1, DeclarationSpecifier_34_list.size());
		//34
		final TypeSpecifier TypeSpecifier_35_Var
		 = (TypeSpecifier)DeclarationSpecifier_34_list.get(0);
		Assert.assertNotNull(TypeSpecifier_35_Var
		);
		Assert.assertEquals("int", TypeSpecifier_35_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_35_list = Declaration_33_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_35_list);
		Assert.assertEquals(1, InitDeclaratorList_35_list.size());
		//35
		final InitDeclaratorList InitDeclaratorList_36_Var
		 = (InitDeclaratorList)InitDeclaratorList_35_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_36_Var
		);
		final EList<? extends EObject> InitDeclarator_36_list = InitDeclaratorList_36_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_36_list);
		Assert.assertEquals(1, InitDeclarator_36_list.size());
		//36
		final InitDeclarator InitDeclarator_37_Var
		 = (InitDeclarator)InitDeclarator_36_list.get(0);
		Assert.assertNotNull(InitDeclarator_37_Var
		);
		//37
		final Declarator Declarator_38_Var
		 = (Declarator)InitDeclarator_37_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_38_Var
		);
		//38
		final DirectDeclarator DirectDeclarator_39_Var
		 = (DirectDeclarator)Declarator_38_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_39_Var
		);
		Assert.assertEquals("_STDC_PREDEF_H", DirectDeclarator_39_Var
		.getId());
		Assert.assertTrue(DirectDeclarator_39_Var
		.getDeclaratorSuffix().isEmpty());
		Assert.assertEquals(";", Declaration_33_Var
		.getSemi());
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/" + options.get("sourceFile") + "/Empty.c", TranslationUnit_3_Var
		.getPath());
	}
	
	
}


