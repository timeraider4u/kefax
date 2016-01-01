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
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineDirective;
import at.jku.weiner.c.preprocess.preprocess.Code;

@SuppressWarnings("unused")
public class Test0003_SimpleInclude {
	
	private final String pureJavaClassFileName = "Test0003_SimpleInclude";
	private final String sourceFile = "res/Test0003_SimpleInclude";
	private Map<String,Object> options;
	
	@Before
	public void initialize(){
		options = org.eclipse.modisco.cdt.discoverer.tests.EMFTest.getOptions(
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
		final Preprocess Preprocess_2_Var
		 = (Preprocess)TranslationUnit_1_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_2_Var
		);
		//2
		final GroupOpt GroupOpt_3_Var
		 = (GroupOpt)Preprocess_2_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_3_Var
		);
		final EList<? extends EObject> Lines_3_list = GroupOpt_3_Var
		.getLines();
		Assert.assertNotNull(Lines_3_list);
		Assert.assertEquals(5, Lines_3_list.size());
		//3
		final PreprocessorDirectives PreprocessorDirectives_4_Var
		 = (PreprocessorDirectives)Lines_3_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_4_Var
		);
		//4
		final IncludeDirective IncludeDirective_5_Var
		 = (IncludeDirective)PreprocessorDirectives_4_Var
		.getDirective();
		Assert.assertNotNull(IncludeDirective_5_Var
		);
		Assert.assertEquals("\"../include/SimpleInclude.h\"", IncludeDirective_5_Var
		.getString());
		//5
		final NewLineLine NewLineLine_6_Var
		 = (NewLineLine)Lines_3_list.get(1);
		Assert.assertNotNull(NewLineLine_6_Var
		);
		//6
		final Code Code_7_Var
		 = (Code)Lines_3_list.get(2);
		Assert.assertNotNull(Code_7_Var
		);
		Assert.assertEquals("NUMBER main(void) {", Code_7_Var
		.getCode());
		//7
		final Code Code_8_Var
		 = (Code)Lines_3_list.get(3);
		Assert.assertNotNull(Code_8_Var
		);
		Assert.assertEquals("	return getValue();", Code_8_Var
		.getCode());
		//8
		final Code Code_9_Var
		 = (Code)Lines_3_list.get(4);
		Assert.assertNotNull(Code_9_Var
		);
		Assert.assertEquals("}", Code_9_Var
		.getCode());
		//9
		final Parser Parser_10_Var
		 = (Parser)TranslationUnit_1_Var
		.getParser();
		Assert.assertNotNull(Parser_10_Var
		);
		final EList<? extends EObject> External_10_list = Parser_10_Var
		.getExternal();
		Assert.assertNotNull(External_10_list);
		Assert.assertEquals(2, External_10_list.size());
		//10
		final ExternalDeclaration ExternalDeclaration_11_Var
		 = (ExternalDeclaration)External_10_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_11_Var
		);
		//11
		final Declaration Declaration_12_Var
		 = (Declaration)ExternalDeclaration_11_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_12_Var
		);
		//12
		final DeclarationSpecifiers DeclarationSpecifiers_13_Var
		 = (DeclarationSpecifiers)Declaration_12_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_13_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_13_list = DeclarationSpecifiers_13_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_13_list);
		Assert.assertEquals(2, DeclarationSpecifier_13_list.size());
		//13
		final StorageClassSpecifier StorageClassSpecifier_14_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_13_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_14_Var
		);
		Assert.assertEquals("extern", StorageClassSpecifier_14_Var
		.getName());
		//14
		final TypeSpecifier TypeSpecifier_15_Var
		 = (TypeSpecifier)DeclarationSpecifier_13_list.get(1);
		Assert.assertNotNull(TypeSpecifier_15_Var
		);
		Assert.assertEquals("int", TypeSpecifier_15_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_15_list = Declaration_12_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_15_list);
		Assert.assertEquals(1, InitDeclaratorList_15_list.size());
		//15
		final InitDeclaratorList InitDeclaratorList_16_Var
		 = (InitDeclaratorList)InitDeclaratorList_15_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_16_Var
		);
		final EList<? extends EObject> InitDeclarator_16_list = InitDeclaratorList_16_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_16_list);
		Assert.assertEquals(1, InitDeclarator_16_list.size());
		//16
		final InitDeclarator InitDeclarator_17_Var
		 = (InitDeclarator)InitDeclarator_16_list.get(0);
		Assert.assertNotNull(InitDeclarator_17_Var
		);
		//17
		final Declarator Declarator_18_Var
		 = (Declarator)InitDeclarator_17_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_18_Var
		);
		//18
		final DirectDeclarator DirectDeclarator_19_Var
		 = (DirectDeclarator)Declarator_18_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_19_Var
		);
		Assert.assertEquals("getValue", DirectDeclarator_19_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_19_list = DirectDeclarator_19_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_19_list);
		Assert.assertEquals(1, DeclaratorSuffix_19_list.size());
		//19
		final DeclaratorSuffix DeclaratorSuffix_20_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_19_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_20_Var
		);
		//20
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_21_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_20_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_21_Var
		);
		Assert.assertEquals(";", Declaration_12_Var
		.getSemi());
		//21
		final ExternalDeclaration ExternalDeclaration_22_Var
		 = (ExternalDeclaration)External_10_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_22_Var
		);
		//22
		final FunctionDefHead FunctionDefHead_23_Var
		 = (FunctionDefHead)ExternalDeclaration_22_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_23_Var
		);
		//23
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_24_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_23_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_24_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_24_list = FunctionDeclarationSpecifiers_24_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_24_list);
		Assert.assertEquals(1, DeclarationSpecifier_24_list.size());
		//24
		final TypeSpecifier TypeSpecifier_25_Var
		 = (TypeSpecifier)DeclarationSpecifier_24_list.get(0);
		Assert.assertNotNull(TypeSpecifier_25_Var
		);
		Assert.assertEquals("int", TypeSpecifier_25_Var
		.getName());
		//25
		final Declarator Declarator_26_Var
		 = (Declarator)FunctionDefHead_23_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_26_Var
		);
		//26
		final DirectDeclarator DirectDeclarator_27_Var
		 = (DirectDeclarator)Declarator_26_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_27_Var
		);
		Assert.assertEquals("main", DirectDeclarator_27_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_27_list = DirectDeclarator_27_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_27_list);
		Assert.assertEquals(1, DeclaratorSuffix_27_list.size());
		//27
		final DeclaratorSuffix DeclaratorSuffix_28_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_27_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_28_Var
		);
		//28
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_29_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_28_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_29_Var
		);
		final EList<? extends EObject> ParameterTypeList_29_list = DirectDeclaratorLastSuffix_29_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_29_list);
		Assert.assertEquals(1, ParameterTypeList_29_list.size());
		//29
		final ParameterTypeList ParameterTypeList_30_Var
		 = (ParameterTypeList)ParameterTypeList_29_list.get(0);
		Assert.assertNotNull(ParameterTypeList_30_Var
		);
		//30
		final ParameterList ParameterList_31_Var
		 = (ParameterList)ParameterTypeList_30_Var
		.getList();
		Assert.assertNotNull(ParameterList_31_Var
		);
		final EList<? extends EObject> ParameterDeclaration_31_list = ParameterList_31_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_31_list);
		Assert.assertEquals(1, ParameterDeclaration_31_list.size());
		//31
		final ParameterDeclaration ParameterDeclaration_32_Var
		 = (ParameterDeclaration)ParameterDeclaration_31_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_32_Var
		);
		//32
		final DeclarationSpecifiers DeclarationSpecifiers_33_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_32_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_33_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_33_list = DeclarationSpecifiers_33_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_33_list);
		Assert.assertEquals(1, DeclarationSpecifier_33_list.size());
		//33
		final TypeSpecifier TypeSpecifier_34_Var
		 = (TypeSpecifier)DeclarationSpecifier_33_list.get(0);
		Assert.assertNotNull(TypeSpecifier_34_Var
		);
		Assert.assertEquals("void", TypeSpecifier_34_Var
		.getName());
		Assert.assertNull(ParameterDeclaration_32_Var
		.getDeclarator());
		//34
		final FunctionDefinition FunctionDefinition_35_Var
		 = (FunctionDefinition)ExternalDeclaration_22_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_35_Var
		);
		//35
		final BodyStatement BodyStatement_36_Var
		 = (BodyStatement)FunctionDefinition_35_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_36_Var
		);
		final EList<? extends EObject> BlockList_36_list = BodyStatement_36_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_36_list);
		Assert.assertEquals(1, BlockList_36_list.size());
		//36
		final BlockList BlockList_37_Var
		 = (BlockList)BlockList_36_list.get(0);
		Assert.assertNotNull(BlockList_37_Var
		);
		final EList<? extends EObject> Statement_37_list = BlockList_37_Var
		.getStatement();
		Assert.assertNotNull(Statement_37_list);
		Assert.assertEquals(1, Statement_37_list.size());
		//37
		final Statement Statement_38_Var
		 = (Statement)Statement_37_list.get(0);
		Assert.assertNotNull(Statement_38_Var
		);
		//38
		final JumpStatement JumpStatement_39_Var
		 = (JumpStatement)Statement_38_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_39_Var
		);
		//39
		final Expression Expression_40_Var
		 = (Expression)JumpStatement_39_Var
		.getExpr();
		Assert.assertNotNull(Expression_40_Var
		);
		final EList<? extends EObject> ExprExpr_40_list = Expression_40_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_40_list);
		Assert.assertEquals(1, ExprExpr_40_list.size());
		//40
		final AssignmentExpression AssignmentExpression_41_Var
		 = (AssignmentExpression)ExprExpr_40_list.get(0);
		Assert.assertNotNull(AssignmentExpression_41_Var
		);
		//41
		final ConditionalExpression ConditionalExpression_42_Var
		 = (ConditionalExpression)AssignmentExpression_41_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_42_Var
		);
		//42
		final LogicalOrExpression LogicalOrExpression_43_Var
		 = (LogicalOrExpression)ConditionalExpression_42_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = LogicalOrExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final LogicalAndExpression LogicalAndExpression_44_Var
		 = (LogicalAndExpression)Expr_43_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = LogicalAndExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final InclusiveOrExpression InclusiveOrExpression_45_Var
		 = (InclusiveOrExpression)Expr_44_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = InclusiveOrExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final ExclusiveOrExpression ExclusiveOrExpression_46_Var
		 = (ExclusiveOrExpression)Expr_45_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = ExclusiveOrExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final AndExpression AndExpression_47_Var
		 = (AndExpression)Expr_46_list.get(0);
		Assert.assertNotNull(AndExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = AndExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final EqualityExpression EqualityExpression_48_Var
		 = (EqualityExpression)Expr_47_list.get(0);
		Assert.assertNotNull(EqualityExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = EqualityExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final RelationalExpression RelationalExpression_49_Var
		 = (RelationalExpression)Expr_48_list.get(0);
		Assert.assertNotNull(RelationalExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = RelationalExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final ShiftExpression ShiftExpression_50_Var
		 = (ShiftExpression)Expr_49_list.get(0);
		Assert.assertNotNull(ShiftExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = ShiftExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final AdditiveExpression AdditiveExpression_51_Var
		 = (AdditiveExpression)Expr_50_list.get(0);
		Assert.assertNotNull(AdditiveExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = AdditiveExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final MultiplicativeExpression MultiplicativeExpression_52_Var
		 = (MultiplicativeExpression)Expr_51_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = MultiplicativeExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final CastExpression CastExpression_53_Var
		 = (CastExpression)Expr_52_list.get(0);
		Assert.assertNotNull(CastExpression_53_Var
		);
		//53
		final UnaryExpression UnaryExpression_54_Var
		 = (UnaryExpression)CastExpression_53_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_54_Var
		);
		//54
		final PostfixExpression PostfixExpression_55_Var
		 = (PostfixExpression)UnaryExpression_54_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = PostfixExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final PrimaryExpression PrimaryExpression_56_Var
		 = (PrimaryExpression)Expr_55_list.get(0);
		Assert.assertNotNull(PrimaryExpression_56_Var
		);
		Assert.assertEquals("getValue", PrimaryExpression_56_Var
		.getId());
		final EList<? extends EObject> Suffix_56_list = PostfixExpression_55_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_56_list);
		Assert.assertEquals(1, Suffix_56_list.size());
		//56
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_57_Var
		 = (PostfixExpressionSuffixArgument)Suffix_56_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_57_Var
		);
		//57
		final ArgumentExpressionList ArgumentExpressionList_58_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_57_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_58_Var
		);
		Assert.assertEquals("return", JumpStatement_39_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_39_Var
		.getSemi());
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/" + options.get("sourceFile") + "/SimpleInclude.c", TranslationUnit_1_Var
		.getPath());
		//58
		final TranslationUnit TranslationUnit_59_Var
		 = (TranslationUnit)Units_0_list.get(1);
		Assert.assertNotNull(TranslationUnit_59_Var
		);
		Assert.assertEquals("" + options.get("path") + "/" + options.get("plugin_id") + "/res/include/SimpleInclude.h", TranslationUnit_59_Var
		.getPath());
		//59
		final Preprocess Preprocess_60_Var
		 = (Preprocess)TranslationUnit_59_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_60_Var
		);
		//60
		final GroupOpt GroupOpt_61_Var
		 = (GroupOpt)Preprocess_60_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_61_Var
		);
		final EList<? extends EObject> Lines_61_list = GroupOpt_61_Var
		.getLines();
		Assert.assertNotNull(Lines_61_list);
		Assert.assertEquals(2, Lines_61_list.size());
		//61
		final PreprocessorDirectives PreprocessorDirectives_62_Var
		 = (PreprocessorDirectives)Lines_61_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_62_Var
		);
		//62
		final DefineDirective DefineDirective_63_Var
		 = (DefineDirective)PreprocessorDirectives_62_Var
		.getDirective();
		Assert.assertNotNull(DefineDirective_63_Var
		);
		Assert.assertEquals("NUMBER", DefineDirective_63_Var
		.getId());
		Assert.assertEquals("int", DefineDirective_63_Var
		.getString());
		//63
		final Code Code_64_Var
		 = (Code)Lines_61_list.get(1);
		Assert.assertNotNull(Code_64_Var
		);
		Assert.assertEquals("extern NUMBER getValue();", Code_64_Var
		.getCode());
		Assert.assertNull(TranslationUnit_59_Var
		.getParser());
	}
	
	
}


