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
import at.jku.weiner.c.parser.parser.Expression;
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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
import at.jku.weiner.c.preprocess.preprocess.Code;

@SuppressWarnings("unused")
public class Test0006_SimpleAbsoluteInclude {
	
	private final String pureJavaClassFileName = "Test0006_SimpleAbsoluteInclude";
	private final String sourceFile = "res/Test0006_SimpleAbsoluteInclude";
	private Map<String,Object> options;
	
	@Before
	public void initialize(){
		options = org.eclipse.modisco.cdt.discoverer.tests.EMFTest.getOptions(
			this.pureJavaClassFileName, this.sourceFile);
		org.eclipse.modisco.cdt.discoverer.tests.EMFTest.addIncludeDir();
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
		Assert.assertEquals("<include/SimpleInclude.h>", IncludeDirective_7_Var
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
		.getId());
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
		final Expression Expression_42_Var
		 = (Expression)JumpStatement_41_Var
		.getExpr();
		Assert.assertNotNull(Expression_42_Var
		);
		final EList<? extends EObject> ExprExpr_42_list = Expression_42_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_42_list);
		Assert.assertEquals(1, ExprExpr_42_list.size());
		//42
		final AssignmentExpression AssignmentExpression_43_Var
		 = (AssignmentExpression)ExprExpr_42_list.get(0);
		Assert.assertNotNull(AssignmentExpression_43_Var
		);
		//43
		final ConditionalExpression ConditionalExpression_44_Var
		 = (ConditionalExpression)AssignmentExpression_43_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_44_Var
		);
		//44
		final LogicalOrExpression LogicalOrExpression_45_Var
		 = (LogicalOrExpression)ConditionalExpression_44_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = LogicalOrExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final LogicalAndExpression LogicalAndExpression_46_Var
		 = (LogicalAndExpression)Expr_45_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = LogicalAndExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final InclusiveOrExpression InclusiveOrExpression_47_Var
		 = (InclusiveOrExpression)Expr_46_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = InclusiveOrExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final ExclusiveOrExpression ExclusiveOrExpression_48_Var
		 = (ExclusiveOrExpression)Expr_47_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = ExclusiveOrExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final AndExpression AndExpression_49_Var
		 = (AndExpression)Expr_48_list.get(0);
		Assert.assertNotNull(AndExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = AndExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final EqualityExpression EqualityExpression_50_Var
		 = (EqualityExpression)Expr_49_list.get(0);
		Assert.assertNotNull(EqualityExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = EqualityExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final RelationalExpression RelationalExpression_51_Var
		 = (RelationalExpression)Expr_50_list.get(0);
		Assert.assertNotNull(RelationalExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = RelationalExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final ShiftExpression ShiftExpression_52_Var
		 = (ShiftExpression)Expr_51_list.get(0);
		Assert.assertNotNull(ShiftExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = ShiftExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final AdditiveExpression AdditiveExpression_53_Var
		 = (AdditiveExpression)Expr_52_list.get(0);
		Assert.assertNotNull(AdditiveExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = AdditiveExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final MultiplicativeExpression MultiplicativeExpression_54_Var
		 = (MultiplicativeExpression)Expr_53_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = MultiplicativeExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final CastExpression CastExpression_55_Var
		 = (CastExpression)Expr_54_list.get(0);
		Assert.assertNotNull(CastExpression_55_Var
		);
		//55
		final UnaryExpression UnaryExpression_56_Var
		 = (UnaryExpression)CastExpression_55_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_56_Var
		);
		//56
		final PostfixExpression PostfixExpression_57_Var
		 = (PostfixExpression)UnaryExpression_56_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = PostfixExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final PrimaryExpression PrimaryExpression_58_Var
		 = (PrimaryExpression)Expr_57_list.get(0);
		Assert.assertNotNull(PrimaryExpression_58_Var
		);
		Assert.assertEquals("getValue", PrimaryExpression_58_Var
		.getId());
		final EList<? extends EObject> Suffix_58_list = PostfixExpression_57_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_58_list);
		Assert.assertEquals(1, Suffix_58_list.size());
		//58
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_59_Var
		 = (PostfixExpressionSuffixArgument)Suffix_58_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_59_Var
		);
		Assert.assertNull(PostfixExpressionSuffixArgument_59_Var
		.getArgumentExpressionList());
		Assert.assertEquals("return", JumpStatement_41_Var
		.getReturn());
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/" + options.get("sourceFile") + "/SimpleInclude.c", TranslationUnit_3_Var
		.getPath());
		//59
		final TranslationUnit TranslationUnit_60_Var
		 = (TranslationUnit)Units_0_list.get(2);
		Assert.assertNotNull(TranslationUnit_60_Var
		);
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/res/include/SimpleInclude.h", TranslationUnit_60_Var
		.getPath());
		//60
		final Preprocess Preprocess_61_Var
		 = (Preprocess)TranslationUnit_60_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_61_Var
		);
		//61
		final GroupOpt GroupOpt_62_Var
		 = (GroupOpt)Preprocess_61_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_62_Var
		);
		final EList<? extends EObject> Lines_62_list = GroupOpt_62_Var
		.getLines();
		Assert.assertNotNull(Lines_62_list);
		Assert.assertEquals(2, Lines_62_list.size());
		//62
		final PreprocessorDirectives PreprocessorDirectives_63_Var
		 = (PreprocessorDirectives)Lines_62_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_63_Var
		);
		//63
		final DefineObjectMacro DefineObjectMacro_64_Var
		 = (DefineObjectMacro)PreprocessorDirectives_63_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_64_Var
		);
		Assert.assertEquals("NUMBER", DefineObjectMacro_64_Var
		.getId());
		Assert.assertEquals("int", DefineObjectMacro_64_Var
		.getString());
		//64
		final Code Code_65_Var
		 = (Code)Lines_62_list.get(1);
		Assert.assertNotNull(Code_65_Var
		);
		Assert.assertEquals("extern NUMBER getValue();", Code_65_Var
		.getCode());
		Assert.assertNull(TranslationUnit_60_Var
		.getParser());
	}
	
	
}


