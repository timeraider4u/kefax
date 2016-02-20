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
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.IncludeDirective;
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
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.ConditionalDirective;
import at.jku.weiner.c.preprocess.preprocess.IfConditional;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.ElIfConditional;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.ElIfConditional;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.ElseConditional;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.IncludeDirective;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.IncludeDirective;
import at.jku.weiner.c.preprocess.preprocess.Code;
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
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.StorageClassSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;

@SuppressWarnings("unused")
public class Test0015_Include {
	
	private final String pureJavaClassFileName = "Test0015_Include";
	private final String sourceFile = "res/Test0015_Include";
	private Map<String,Object> options;
	
	@Before
	public void initialize(){
		options = at.jku.weiner.c.modisco.discoverer.tests.EMFTest.getOptions(
			this.pureJavaClassFileName, this.sourceFile);
		at.jku.weiner.c.modisco.discoverer.tests.EMFTest.test0015();
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
		Assert.assertEquals(4, Units_0_list.size());
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
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/res/Test0015_Include1/A.c", TranslationUnit_3_Var
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
		Assert.assertEquals("FOO", DefineObjectMacro_7_Var
		.getId());
		Assert.assertEquals("1", DefineObjectMacro_7_Var
		.getString());
		//7
		final PreprocessorDirectives PreprocessorDirectives_8_Var
		 = (PreprocessorDirectives)Lines_5_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_8_Var
		);
		//8
		final IncludeDirective IncludeDirective_9_Var
		 = (IncludeDirective)PreprocessorDirectives_8_Var
		.getDirective();
		Assert.assertNotNull(IncludeDirective_9_Var
		);
		Assert.assertEquals("\"../include/Test0015_Include.h\"", IncludeDirective_9_Var
		.getString());
		//9
		final Code Code_10_Var
		 = (Code)Lines_5_list.get(2);
		Assert.assertNotNull(Code_10_Var
		);
		Assert.assertEquals("TYPE_FOO i;", Code_10_Var
		.getCode());
		//10
		final Parser Parser_11_Var
		 = (Parser)TranslationUnit_3_Var
		.getParser();
		Assert.assertNotNull(Parser_11_Var
		);
		final EList<? extends EObject> External_11_list = Parser_11_Var
		.getExternal();
		Assert.assertNotNull(External_11_list);
		Assert.assertEquals(2, External_11_list.size());
		//11
		final ExternalDeclaration ExternalDeclaration_12_Var
		 = (ExternalDeclaration)External_11_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_12_Var
		);
		//12
		final Declaration Declaration_13_Var
		 = (Declaration)ExternalDeclaration_12_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_13_Var
		);
		//13
		final DeclarationSpecifiers DeclarationSpecifiers_14_Var
		 = (DeclarationSpecifiers)Declaration_13_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_14_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_14_list = DeclarationSpecifiers_14_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_14_list);
		Assert.assertEquals(2, DeclarationSpecifier_14_list.size());
		//14
		final StorageClassSpecifier StorageClassSpecifier_15_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_14_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_15_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_15_Var
		.getName());
		//15
		final TypeSpecifier TypeSpecifier_16_Var
		 = (TypeSpecifier)DeclarationSpecifier_14_list.get(1);
		Assert.assertNotNull(TypeSpecifier_16_Var
		);
		Assert.assertEquals("int", TypeSpecifier_16_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_16_list = Declaration_13_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_16_list);
		Assert.assertEquals(1, InitDeclaratorList_16_list.size());
		//16
		final InitDeclaratorList InitDeclaratorList_17_Var
		 = (InitDeclaratorList)InitDeclaratorList_16_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_17_Var
		);
		final EList<? extends EObject> InitDeclarator_17_list = InitDeclaratorList_17_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_17_list);
		Assert.assertEquals(1, InitDeclarator_17_list.size());
		//17
		final InitDeclarator InitDeclarator_18_Var
		 = (InitDeclarator)InitDeclarator_17_list.get(0);
		Assert.assertNotNull(InitDeclarator_18_Var
		);
		//18
		final Declarator Declarator_19_Var
		 = (Declarator)InitDeclarator_18_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_19_Var
		);
		//19
		final DirectDeclarator DirectDeclarator_20_Var
		 = (DirectDeclarator)Declarator_19_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_20_Var
		);
		Assert.assertEquals("TYPE_FOO", DirectDeclarator_20_Var
		.getId());
		//20
		final ExternalDeclaration ExternalDeclaration_21_Var
		 = (ExternalDeclaration)External_11_list.get(1);
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
		//24
		final TypedefName TypedefName_25_Var
		 = (TypedefName)TypeSpecifier_24_Var
		.getType();
		Assert.assertNotNull(TypedefName_25_Var
		);
		Assert.assertEquals("TYPE_FOO", TypedefName_25_Var
		.getId());
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
		Assert.assertEquals("i", DirectDeclarator_29_Var
		.getId());
		//29
		final TranslationUnit TranslationUnit_30_Var
		 = (TranslationUnit)Units_0_list.get(2);
		Assert.assertNotNull(TranslationUnit_30_Var
		);
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/res/include/Test0015_Include.h", TranslationUnit_30_Var
		.getPath());
		//30
		final Preprocess Preprocess_31_Var
		 = (Preprocess)TranslationUnit_30_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_31_Var
		);
		//31
		final GroupOpt GroupOpt_32_Var
		 = (GroupOpt)Preprocess_31_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_32_Var
		);
		final EList<? extends EObject> Lines_32_list = GroupOpt_32_Var
		.getLines();
		Assert.assertNotNull(Lines_32_list);
		Assert.assertEquals(1, Lines_32_list.size());
		//32
		final PreprocessorDirectives PreprocessorDirectives_33_Var
		 = (PreprocessorDirectives)Lines_32_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_33_Var
		);
		//33
		final ConditionalDirective ConditionalDirective_34_Var
		 = (ConditionalDirective)PreprocessorDirectives_33_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_34_Var
		);
		//34
		final IfConditional IfConditional_35_Var
		 = (IfConditional)ConditionalDirective_34_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_35_Var
		);
		//35
		final PrimaryExpression PrimaryExpression_36_Var
		 = (PrimaryExpression)IfConditional_35_Var
		.getExpression();
		Assert.assertNotNull(PrimaryExpression_36_Var
		);
		Assert.assertFalse(PrimaryExpression_36_Var
		.isDefined());
		Assert.assertEquals("FOOBAR", PrimaryExpression_36_Var
		.getId());
		//36
		final GroupOpt GroupOpt_37_Var
		 = (GroupOpt)IfConditional_35_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_37_Var
		);
		final EList<? extends EObject> Lines_37_list = GroupOpt_37_Var
		.getLines();
		Assert.assertNotNull(Lines_37_list);
		Assert.assertEquals(1, Lines_37_list.size());
		//37
		final Code Code_38_Var
		 = (Code)Lines_37_list.get(0);
		Assert.assertNotNull(Code_38_Var
		);
		Assert.assertEquals("	typedef int TYPE_FOO_BAR;", Code_38_Var
		.getCode());
		final EList<? extends EObject> Elifs_38_list = ConditionalDirective_34_Var
		.getElifs();
		Assert.assertNotNull(Elifs_38_list);
		Assert.assertEquals(2, Elifs_38_list.size());
		//38
		final ElIfConditional ElIfConditional_39_Var
		 = (ElIfConditional)Elifs_38_list.get(0);
		Assert.assertNotNull(ElIfConditional_39_Var
		);
		//39
		final PrimaryExpression PrimaryExpression_40_Var
		 = (PrimaryExpression)ElIfConditional_39_Var
		.getExpression();
		Assert.assertNotNull(PrimaryExpression_40_Var
		);
		Assert.assertFalse(PrimaryExpression_40_Var
		.isDefined());
		Assert.assertEquals("FOO", PrimaryExpression_40_Var
		.getId());
		//40
		final GroupOpt GroupOpt_41_Var
		 = (GroupOpt)ElIfConditional_39_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_41_Var
		);
		final EList<? extends EObject> Lines_41_list = GroupOpt_41_Var
		.getLines();
		Assert.assertNotNull(Lines_41_list);
		Assert.assertEquals(1, Lines_41_list.size());
		//41
		final Code Code_42_Var
		 = (Code)Lines_41_list.get(0);
		Assert.assertNotNull(Code_42_Var
		);
		Assert.assertEquals("	typedef int TYPE_FOO;", Code_42_Var
		.getCode());
		//42
		final ElIfConditional ElIfConditional_43_Var
		 = (ElIfConditional)Elifs_38_list.get(1);
		Assert.assertNotNull(ElIfConditional_43_Var
		);
		//43
		final PrimaryExpression PrimaryExpression_44_Var
		 = (PrimaryExpression)ElIfConditional_43_Var
		.getExpression();
		Assert.assertNotNull(PrimaryExpression_44_Var
		);
		Assert.assertFalse(PrimaryExpression_44_Var
		.isDefined());
		Assert.assertEquals("BAR", PrimaryExpression_44_Var
		.getId());
		//44
		final GroupOpt GroupOpt_45_Var
		 = (GroupOpt)ElIfConditional_43_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_45_Var
		);
		final EList<? extends EObject> Lines_45_list = GroupOpt_45_Var
		.getLines();
		Assert.assertNotNull(Lines_45_list);
		Assert.assertEquals(1, Lines_45_list.size());
		//45
		final Code Code_46_Var
		 = (Code)Lines_45_list.get(0);
		Assert.assertNotNull(Code_46_Var
		);
		Assert.assertEquals("	typedef int TYPE_BAR;", Code_46_Var
		.getCode());
		//46
		final ElseConditional ElseConditional_47_Var
		 = (ElseConditional)ConditionalDirective_34_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_47_Var
		);
		//47
		final GroupOpt GroupOpt_48_Var
		 = (GroupOpt)ElseConditional_47_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_48_Var
		);
		final EList<? extends EObject> Lines_48_list = GroupOpt_48_Var
		.getLines();
		Assert.assertNotNull(Lines_48_list);
		Assert.assertEquals(1, Lines_48_list.size());
		//48
		final Code Code_49_Var
		 = (Code)Lines_48_list.get(0);
		Assert.assertNotNull(Code_49_Var
		);
		Assert.assertEquals("	typedef int TYPE_BAZ;", Code_49_Var
		.getCode());
		Assert.assertNull(TranslationUnit_30_Var
		.getParser());
		//49
		final TranslationUnit TranslationUnit_50_Var
		 = (TranslationUnit)Units_0_list.get(3);
		Assert.assertNotNull(TranslationUnit_50_Var
		);
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/res/Test0015_Include2/B.c", TranslationUnit_50_Var
		.getPath());
		//50
		final Preprocess Preprocess_51_Var
		 = (Preprocess)TranslationUnit_50_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_51_Var
		);
		//51
		final GroupOpt GroupOpt_52_Var
		 = (GroupOpt)Preprocess_51_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_52_Var
		);
		final EList<? extends EObject> Lines_52_list = GroupOpt_52_Var
		.getLines();
		Assert.assertNotNull(Lines_52_list);
		Assert.assertEquals(7, Lines_52_list.size());
		//52
		final PreprocessorDirectives PreprocessorDirectives_53_Var
		 = (PreprocessorDirectives)Lines_52_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_53_Var
		);
		//53
		final IncludeDirective IncludeDirective_54_Var
		 = (IncludeDirective)PreprocessorDirectives_53_Var
		.getDirective();
		Assert.assertNotNull(IncludeDirective_54_Var
		);
		Assert.assertEquals("\"../include/Test0015_Include.h\"", IncludeDirective_54_Var
		.getString());
		//54
		final Code Code_55_Var
		 = (Code)Lines_52_list.get(1);
		Assert.assertNotNull(Code_55_Var
		);
		Assert.assertEquals("TYPE_BAZ j;", Code_55_Var
		.getCode());
		//55
		final NewLineLine NewLineLine_56_Var
		 = (NewLineLine)Lines_52_list.get(2);
		Assert.assertNotNull(NewLineLine_56_Var
		);
		//56
		final PreprocessorDirectives PreprocessorDirectives_57_Var
		 = (PreprocessorDirectives)Lines_52_list.get(3);
		Assert.assertNotNull(PreprocessorDirectives_57_Var
		);
		//57
		final DefineObjectMacro DefineObjectMacro_58_Var
		 = (DefineObjectMacro)PreprocessorDirectives_57_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_58_Var
		);
		Assert.assertEquals("BAR", DefineObjectMacro_58_Var
		.getId());
		Assert.assertEquals("1", DefineObjectMacro_58_Var
		.getString());
		//58
		final PreprocessorDirectives PreprocessorDirectives_59_Var
		 = (PreprocessorDirectives)Lines_52_list.get(4);
		Assert.assertNotNull(PreprocessorDirectives_59_Var
		);
		//59
		final IncludeDirective IncludeDirective_60_Var
		 = (IncludeDirective)PreprocessorDirectives_59_Var
		.getDirective();
		Assert.assertNotNull(IncludeDirective_60_Var
		);
		Assert.assertEquals("\"../include/Test0015_Include.h\"", IncludeDirective_60_Var
		.getString());
		//60
		final Code Code_61_Var
		 = (Code)Lines_52_list.get(5);
		Assert.assertNotNull(Code_61_Var
		);
		Assert.assertEquals("TYPE_BAZ k;", Code_61_Var
		.getCode());
		//61
		final Code Code_62_Var
		 = (Code)Lines_52_list.get(6);
		Assert.assertNotNull(Code_62_Var
		);
		Assert.assertEquals("TYPE_BAR l;", Code_62_Var
		.getCode());
		//62
		final Parser Parser_63_Var
		 = (Parser)TranslationUnit_50_Var
		.getParser();
		Assert.assertNotNull(Parser_63_Var
		);
		final EList<? extends EObject> External_63_list = Parser_63_Var
		.getExternal();
		Assert.assertNotNull(External_63_list);
		Assert.assertEquals(5, External_63_list.size());
		//63
		final ExternalDeclaration ExternalDeclaration_64_Var
		 = (ExternalDeclaration)External_63_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_64_Var
		);
		//64
		final Declaration Declaration_65_Var
		 = (Declaration)ExternalDeclaration_64_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_65_Var
		);
		//65
		final DeclarationSpecifiers DeclarationSpecifiers_66_Var
		 = (DeclarationSpecifiers)Declaration_65_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_66_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_66_list = DeclarationSpecifiers_66_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_66_list);
		Assert.assertEquals(2, DeclarationSpecifier_66_list.size());
		//66
		final StorageClassSpecifier StorageClassSpecifier_67_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_66_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_67_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_67_Var
		.getName());
		//67
		final TypeSpecifier TypeSpecifier_68_Var
		 = (TypeSpecifier)DeclarationSpecifier_66_list.get(1);
		Assert.assertNotNull(TypeSpecifier_68_Var
		);
		Assert.assertEquals("int", TypeSpecifier_68_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_68_list = Declaration_65_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_68_list);
		Assert.assertEquals(1, InitDeclaratorList_68_list.size());
		//68
		final InitDeclaratorList InitDeclaratorList_69_Var
		 = (InitDeclaratorList)InitDeclaratorList_68_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_69_Var
		);
		final EList<? extends EObject> InitDeclarator_69_list = InitDeclaratorList_69_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_69_list);
		Assert.assertEquals(1, InitDeclarator_69_list.size());
		//69
		final InitDeclarator InitDeclarator_70_Var
		 = (InitDeclarator)InitDeclarator_69_list.get(0);
		Assert.assertNotNull(InitDeclarator_70_Var
		);
		//70
		final Declarator Declarator_71_Var
		 = (Declarator)InitDeclarator_70_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_71_Var
		);
		//71
		final DirectDeclarator DirectDeclarator_72_Var
		 = (DirectDeclarator)Declarator_71_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_72_Var
		);
		Assert.assertEquals("TYPE_BAZ", DirectDeclarator_72_Var
		.getId());
		//72
		final ExternalDeclaration ExternalDeclaration_73_Var
		 = (ExternalDeclaration)External_63_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_73_Var
		);
		//73
		final Declaration Declaration_74_Var
		 = (Declaration)ExternalDeclaration_73_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_74_Var
		);
		//74
		final DeclarationSpecifiers DeclarationSpecifiers_75_Var
		 = (DeclarationSpecifiers)Declaration_74_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_75_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_75_list = DeclarationSpecifiers_75_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_75_list);
		Assert.assertEquals(1, DeclarationSpecifier_75_list.size());
		//75
		final TypeSpecifier TypeSpecifier_76_Var
		 = (TypeSpecifier)DeclarationSpecifier_75_list.get(0);
		Assert.assertNotNull(TypeSpecifier_76_Var
		);
		//76
		final TypedefName TypedefName_77_Var
		 = (TypedefName)TypeSpecifier_76_Var
		.getType();
		Assert.assertNotNull(TypedefName_77_Var
		);
		Assert.assertEquals("TYPE_BAZ", TypedefName_77_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_77_list = Declaration_74_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_77_list);
		Assert.assertEquals(1, InitDeclaratorList_77_list.size());
		//77
		final InitDeclaratorList InitDeclaratorList_78_Var
		 = (InitDeclaratorList)InitDeclaratorList_77_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_78_Var
		);
		final EList<? extends EObject> InitDeclarator_78_list = InitDeclaratorList_78_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_78_list);
		Assert.assertEquals(1, InitDeclarator_78_list.size());
		//78
		final InitDeclarator InitDeclarator_79_Var
		 = (InitDeclarator)InitDeclarator_78_list.get(0);
		Assert.assertNotNull(InitDeclarator_79_Var
		);
		//79
		final Declarator Declarator_80_Var
		 = (Declarator)InitDeclarator_79_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_80_Var
		);
		//80
		final DirectDeclarator DirectDeclarator_81_Var
		 = (DirectDeclarator)Declarator_80_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_81_Var
		);
		Assert.assertEquals("j", DirectDeclarator_81_Var
		.getId());
		//81
		final ExternalDeclaration ExternalDeclaration_82_Var
		 = (ExternalDeclaration)External_63_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_82_Var
		);
		//82
		final Declaration Declaration_83_Var
		 = (Declaration)ExternalDeclaration_82_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_83_Var
		);
		//83
		final DeclarationSpecifiers DeclarationSpecifiers_84_Var
		 = (DeclarationSpecifiers)Declaration_83_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_84_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_84_list = DeclarationSpecifiers_84_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_84_list);
		Assert.assertEquals(2, DeclarationSpecifier_84_list.size());
		//84
		final StorageClassSpecifier StorageClassSpecifier_85_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_84_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_85_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_85_Var
		.getName());
		//85
		final TypeSpecifier TypeSpecifier_86_Var
		 = (TypeSpecifier)DeclarationSpecifier_84_list.get(1);
		Assert.assertNotNull(TypeSpecifier_86_Var
		);
		Assert.assertEquals("int", TypeSpecifier_86_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_86_list = Declaration_83_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_86_list);
		Assert.assertEquals(1, InitDeclaratorList_86_list.size());
		//86
		final InitDeclaratorList InitDeclaratorList_87_Var
		 = (InitDeclaratorList)InitDeclaratorList_86_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_87_Var
		);
		final EList<? extends EObject> InitDeclarator_87_list = InitDeclaratorList_87_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_87_list);
		Assert.assertEquals(1, InitDeclarator_87_list.size());
		//87
		final InitDeclarator InitDeclarator_88_Var
		 = (InitDeclarator)InitDeclarator_87_list.get(0);
		Assert.assertNotNull(InitDeclarator_88_Var
		);
		//88
		final Declarator Declarator_89_Var
		 = (Declarator)InitDeclarator_88_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_89_Var
		);
		//89
		final DirectDeclarator DirectDeclarator_90_Var
		 = (DirectDeclarator)Declarator_89_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_90_Var
		);
		Assert.assertEquals("TYPE_BAR", DirectDeclarator_90_Var
		.getId());
		//90
		final ExternalDeclaration ExternalDeclaration_91_Var
		 = (ExternalDeclaration)External_63_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_91_Var
		);
		//91
		final Declaration Declaration_92_Var
		 = (Declaration)ExternalDeclaration_91_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_92_Var
		);
		//92
		final DeclarationSpecifiers DeclarationSpecifiers_93_Var
		 = (DeclarationSpecifiers)Declaration_92_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_93_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_93_list = DeclarationSpecifiers_93_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_93_list);
		Assert.assertEquals(1, DeclarationSpecifier_93_list.size());
		//93
		final TypeSpecifier TypeSpecifier_94_Var
		 = (TypeSpecifier)DeclarationSpecifier_93_list.get(0);
		Assert.assertNotNull(TypeSpecifier_94_Var
		);
		//94
		final TypedefName TypedefName_95_Var
		 = (TypedefName)TypeSpecifier_94_Var
		.getType();
		Assert.assertNotNull(TypedefName_95_Var
		);
		Assert.assertEquals("TYPE_BAZ", TypedefName_95_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_95_list = Declaration_92_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_95_list);
		Assert.assertEquals(1, InitDeclaratorList_95_list.size());
		//95
		final InitDeclaratorList InitDeclaratorList_96_Var
		 = (InitDeclaratorList)InitDeclaratorList_95_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_96_Var
		);
		final EList<? extends EObject> InitDeclarator_96_list = InitDeclaratorList_96_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_96_list);
		Assert.assertEquals(1, InitDeclarator_96_list.size());
		//96
		final InitDeclarator InitDeclarator_97_Var
		 = (InitDeclarator)InitDeclarator_96_list.get(0);
		Assert.assertNotNull(InitDeclarator_97_Var
		);
		//97
		final Declarator Declarator_98_Var
		 = (Declarator)InitDeclarator_97_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_98_Var
		);
		//98
		final DirectDeclarator DirectDeclarator_99_Var
		 = (DirectDeclarator)Declarator_98_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_99_Var
		);
		Assert.assertEquals("k", DirectDeclarator_99_Var
		.getId());
		//99
		final ExternalDeclaration ExternalDeclaration_100_Var
		 = (ExternalDeclaration)External_63_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_100_Var
		);
		//100
		final Declaration Declaration_101_Var
		 = (Declaration)ExternalDeclaration_100_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_101_Var
		);
		//101
		final DeclarationSpecifiers DeclarationSpecifiers_102_Var
		 = (DeclarationSpecifiers)Declaration_101_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_102_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_102_list = DeclarationSpecifiers_102_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_102_list);
		Assert.assertEquals(1, DeclarationSpecifier_102_list.size());
		//102
		final TypeSpecifier TypeSpecifier_103_Var
		 = (TypeSpecifier)DeclarationSpecifier_102_list.get(0);
		Assert.assertNotNull(TypeSpecifier_103_Var
		);
		//103
		final TypedefName TypedefName_104_Var
		 = (TypedefName)TypeSpecifier_103_Var
		.getType();
		Assert.assertNotNull(TypedefName_104_Var
		);
		Assert.assertEquals("TYPE_BAR", TypedefName_104_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_104_list = Declaration_101_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_104_list);
		Assert.assertEquals(1, InitDeclaratorList_104_list.size());
		//104
		final InitDeclaratorList InitDeclaratorList_105_Var
		 = (InitDeclaratorList)InitDeclaratorList_104_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_105_Var
		);
		final EList<? extends EObject> InitDeclarator_105_list = InitDeclaratorList_105_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_105_list);
		Assert.assertEquals(1, InitDeclarator_105_list.size());
		//105
		final InitDeclarator InitDeclarator_106_Var
		 = (InitDeclarator)InitDeclarator_105_list.get(0);
		Assert.assertNotNull(InitDeclarator_106_Var
		);
		//106
		final Declarator Declarator_107_Var
		 = (Declarator)InitDeclarator_106_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_107_Var
		);
		//107
		final DirectDeclarator DirectDeclarator_108_Var
		 = (DirectDeclarator)Declarator_107_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_108_Var
		);
		Assert.assertEquals("l", DirectDeclarator_108_Var
		.getId());
	}
	
	
}


