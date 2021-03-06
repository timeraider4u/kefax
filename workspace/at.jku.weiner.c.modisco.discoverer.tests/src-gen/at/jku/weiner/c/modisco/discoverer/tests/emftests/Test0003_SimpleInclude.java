package at.jku.weiner.c.modisco.discoverer.tests.emftests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Collection;

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
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

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
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.ParameterTypeList;
import at.jku.weiner.c.parser.parser.ParameterList;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
import at.jku.weiner.c.preprocess.preprocess.Code;

@SuppressWarnings("unused")
@RunWith(Parameterized.class)
public class Test0003_SimpleInclude {
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { true }, { false } });
	};
	
	private final String pureJavaClassFileName = "Test0003_SimpleInclude";
	private final String sourceFile = "res/Test0003_SimpleInclude";
	private Map<String,Object> options;
	private final Boolean use;
	
	public Test0003_SimpleInclude(final Boolean use) {
		this.use = use;
	}
	
	@Before
	public void initialize(){
		options = at.jku.weiner.c.modisco.discoverer.tests.EMFTest.getOptions(
			this.pureJavaClassFileName, this.sourceFile);
		at.jku.weiner.c.modisco.discoverer.tests.EMFTest.test0003_before();
	}
	
	@After
	public void cleanUp() {
		at.jku.weiner.c.modisco.discoverer.tests.EMFTest.test0003_after();
	}
	
	private String getTextFromFile(final String fileName)
	throws Exception{
		final Path path = Paths.get(fileName);
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
				
	@Test (timeout=45000)
	public void checkParserResult() throws Exception {
		final EObject obj = at.jku.weiner.c.modisco.discoverer.tests.EMFTest.emfTest(
			this.pureJavaClassFileName, this.sourceFile, this.use
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
		Assert.assertEquals(5, Lines_5_list.size());
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
		Assert.assertEquals("\"../include/SimpleInclude.h\"", IncludeDirective_7_Var
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
		Assert.assertEquals("NUMBER main(void) {", Code_9_Var
		.getCode());
		//9
		final Code Code_10_Var
		 = (Code)Lines_5_list.get(3);
		Assert.assertNotNull(Code_10_Var
		);
		Assert.assertEquals("	return getValue();", Code_10_Var
		.getCode());
		//10
		final Code Code_11_Var
		 = (Code)Lines_5_list.get(4);
		Assert.assertNotNull(Code_11_Var
		);
		Assert.assertEquals("}", Code_11_Var
		.getCode());
		//11
		final Parser Parser_12_Var
		 = (Parser)TranslationUnit_3_Var
		.getParser();
		Assert.assertNotNull(Parser_12_Var
		);
		final EList<? extends EObject> External_12_list = Parser_12_Var
		.getExternal();
		Assert.assertNotNull(External_12_list);
		Assert.assertEquals(2, External_12_list.size());
		//12
		final ExternalDeclaration ExternalDeclaration_13_Var
		 = (ExternalDeclaration)External_12_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_13_Var
		);
		//13
		final Declaration Declaration_14_Var
		 = (Declaration)ExternalDeclaration_13_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_14_Var
		);
		//14
		final DeclarationSpecifiers DeclarationSpecifiers_15_Var
		 = (DeclarationSpecifiers)Declaration_14_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_15_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_15_list = DeclarationSpecifiers_15_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_15_list);
		Assert.assertEquals(2, DeclarationSpecifier_15_list.size());
		//15
		final StorageClassSpecifier StorageClassSpecifier_16_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_15_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_16_Var
		);
		Assert.assertEquals("extern", StorageClassSpecifier_16_Var
		.getName());
		//16
		final TypeSpecifier TypeSpecifier_17_Var
		 = (TypeSpecifier)DeclarationSpecifier_15_list.get(1);
		Assert.assertNotNull(TypeSpecifier_17_Var
		);
		Assert.assertEquals("int", TypeSpecifier_17_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_17_list = Declaration_14_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_17_list);
		Assert.assertEquals(1, InitDeclaratorList_17_list.size());
		//17
		final InitDeclaratorList InitDeclaratorList_18_Var
		 = (InitDeclaratorList)InitDeclaratorList_17_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_18_Var
		);
		final EList<? extends EObject> InitDeclarator_18_list = InitDeclaratorList_18_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_18_list);
		Assert.assertEquals(1, InitDeclarator_18_list.size());
		//18
		final InitDeclarator InitDeclarator_19_Var
		 = (InitDeclarator)InitDeclarator_18_list.get(0);
		Assert.assertNotNull(InitDeclarator_19_Var
		);
		//19
		final Declarator Declarator_20_Var
		 = (Declarator)InitDeclarator_19_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_20_Var
		);
		//20
		final DirectDeclarator DirectDeclarator_21_Var
		 = (DirectDeclarator)Declarator_20_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_21_Var
		);
		Assert.assertEquals("getValue", DirectDeclarator_21_Var
		.getIdent());
		final EList<? extends EObject> DeclaratorSuffix_21_list = DirectDeclarator_21_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_21_list);
		Assert.assertEquals(1, DeclaratorSuffix_21_list.size());
		//21
		final DeclaratorSuffix DeclaratorSuffix_22_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_21_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_22_Var
		);
		//22
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_23_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_22_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_23_Var
		);
		//23
		final ExternalDeclaration ExternalDeclaration_24_Var
		 = (ExternalDeclaration)External_12_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_24_Var
		);
		//24
		final FunctionDefHead FunctionDefHead_25_Var
		 = (FunctionDefHead)ExternalDeclaration_24_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_25_Var
		);
		//25
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_26_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_25_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_26_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_26_list = FunctionDeclarationSpecifiers_26_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_26_list);
		Assert.assertEquals(1, DeclarationSpecifier_26_list.size());
		//26
		final TypeSpecifier TypeSpecifier_27_Var
		 = (TypeSpecifier)DeclarationSpecifier_26_list.get(0);
		Assert.assertNotNull(TypeSpecifier_27_Var
		);
		Assert.assertEquals("int", TypeSpecifier_27_Var
		.getName());
		//27
		final Declarator Declarator_28_Var
		 = (Declarator)FunctionDefHead_25_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_28_Var
		);
		//28
		final DirectDeclarator DirectDeclarator_29_Var
		 = (DirectDeclarator)Declarator_28_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_29_Var
		);
		Assert.assertEquals("main", DirectDeclarator_29_Var
		.getIdent());
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
		final EList<? extends EObject> ParameterTypeList_31_list = DirectDeclaratorLastSuffix_31_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_31_list);
		Assert.assertEquals(1, ParameterTypeList_31_list.size());
		//31
		final ParameterTypeList ParameterTypeList_32_Var
		 = (ParameterTypeList)ParameterTypeList_31_list.get(0);
		Assert.assertNotNull(ParameterTypeList_32_Var
		);
		//32
		final ParameterList ParameterList_33_Var
		 = (ParameterList)ParameterTypeList_32_Var
		.getList();
		Assert.assertNotNull(ParameterList_33_Var
		);
		final EList<? extends EObject> ParameterDeclaration_33_list = ParameterList_33_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_33_list);
		Assert.assertEquals(1, ParameterDeclaration_33_list.size());
		//33
		final ParameterDeclaration ParameterDeclaration_34_Var
		 = (ParameterDeclaration)ParameterDeclaration_33_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_34_Var
		);
		//34
		final DeclarationSpecifiers DeclarationSpecifiers_35_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_34_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_35_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_35_list = DeclarationSpecifiers_35_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_35_list);
		Assert.assertEquals(1, DeclarationSpecifier_35_list.size());
		//35
		final TypeSpecifier TypeSpecifier_36_Var
		 = (TypeSpecifier)DeclarationSpecifier_35_list.get(0);
		Assert.assertNotNull(TypeSpecifier_36_Var
		);
		Assert.assertEquals("void", TypeSpecifier_36_Var
		.getName());
		Assert.assertNull(ParameterDeclaration_34_Var
		.getDeclarator());
		//36
		final FunctionDefinition FunctionDefinition_37_Var
		 = (FunctionDefinition)ExternalDeclaration_24_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_37_Var
		);
		//37
		final BodyStatement BodyStatement_38_Var
		 = (BodyStatement)FunctionDefinition_37_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_38_Var
		);
		final EList<? extends EObject> BlockList_38_list = BodyStatement_38_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_38_list);
		Assert.assertEquals(1, BlockList_38_list.size());
		//38
		final BlockList BlockList_39_Var
		 = (BlockList)BlockList_38_list.get(0);
		Assert.assertNotNull(BlockList_39_Var
		);
		final EList<? extends EObject> Statement_39_list = BlockList_39_Var
		.getStatement();
		Assert.assertNotNull(Statement_39_list);
		Assert.assertEquals(1, Statement_39_list.size());
		//39
		final Statement Statement_40_Var
		 = (Statement)Statement_39_list.get(0);
		Assert.assertNotNull(Statement_40_Var
		);
		//40
		final JumpStatement JumpStatement_41_Var
		 = (JumpStatement)Statement_40_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_41_Var
		);
		//41
		final PostfixExpression PostfixExpression_42_Var
		 = (PostfixExpression)JumpStatement_41_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_42_Var
		);
		//42
		final PrimaryExpression PrimaryExpression_43_Var
		 = (PrimaryExpression)PostfixExpression_42_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_43_Var
		);
		Assert.assertEquals("getValue", PrimaryExpression_43_Var
		.getIdent());
		//43
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_44_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_42_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_44_Var
		);
		Assert.assertNull(PostfixExpressionSuffixArgument_44_Var
		.getArgumentExpressionList());
		Assert.assertEquals("return", JumpStatement_41_Var
		.getReturn());
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/" + options.get("sourceFile") + "/SimpleInclude.c", TranslationUnit_3_Var
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
		Assert.assertEquals(2, Lines_47_list.size());
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
		.getIdent());
		Assert.assertEquals("int", DefineObjectMacro_49_Var
		.getString());
		//49
		final Code Code_50_Var
		 = (Code)Lines_47_list.get(1);
		Assert.assertNotNull(Code_50_Var
		);
		Assert.assertEquals("extern NUMBER getValue();", Code_50_Var
		.getCode());
		Assert.assertNull(TranslationUnit_45_Var
		.getParser());
	}
	
	
}


