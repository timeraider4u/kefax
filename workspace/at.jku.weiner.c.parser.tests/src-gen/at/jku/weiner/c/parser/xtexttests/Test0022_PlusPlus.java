package at.jku.weiner.c.parser.xtexttests;

import com.google.inject.Inject;
import com.google.inject.Provider;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.antlr.runtime.Token;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import at.jku.weiner.c.parser.tests.ParserInjectorProvider;
import at.jku.weiner.c.parser.parser.antlr.ParserParser;
import at.jku.weiner.c.parser.parser.antlr.internal.InternalParserLexer;
import at.jku.weiner.c.parser.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.parser.parser.Parser;
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
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixPlusPlus;
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
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0022_PlusPlus {
	@Inject
	private ParseHelper<Model> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalParserLexer lexer;
	@Inject
	private ParserParser parser;
	@Inject
	private ITokenDefProvider tokenDefProvider;
	//@Inject
	private LexerAndParserTest testHelper;
	@Inject
	private IGenerator generator;
	@Inject
	private Provider<ResourceSet> resourceSetProvider;
	@Inject
	private IResourceValidator validator;
	@Inject
	private JavaIoFileSystemAccess fileAccessSystem;
	@Inject
	private IResourceFactory resourceFactory;
	
	@Before
	public void initialize(){
		this.testHelper = new LexerAndParserTest(lexer, 
			parser, tokenDefProvider);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("c",
						this.resourceFactory);
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
	
	@Test
	public void checkLexerTokens() throws Exception{
		final String text = this.getTextFromFile(
			"res/Test0022_PlusPlus.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_PLUSPLUS", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_PLUSPLUS", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_SKW_RIGHTBRACE", 
				"RULE_NEWLINE", 
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0022_PlusPlus.c");
		final Model Model_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(Model_0_Var
		);
		
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
		final Parser Parser_2_Var
		 = (Parser)TranslationUnit_1_Var
		.getParser();
		Assert.assertNotNull(Parser_2_Var
		);
		final EList<? extends EObject> External_2_list = Parser_2_Var
		.getExternal();
		Assert.assertNotNull(External_2_list);
		Assert.assertEquals(1, External_2_list.size());
		//2
		final ExternalDeclaration ExternalDeclaration_3_Var
		 = (ExternalDeclaration)External_2_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_3_Var
		);
		//3
		final FunctionDefHead FunctionDefHead_4_Var
		 = (FunctionDefHead)ExternalDeclaration_3_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_4_Var
		);
		//4
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_5_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_4_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_5_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_5_list = FunctionDeclarationSpecifiers_5_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_5_list);
		Assert.assertEquals(1, DeclarationSpecifier_5_list.size());
		//5
		final TypeSpecifier TypeSpecifier_6_Var
		 = (TypeSpecifier)DeclarationSpecifier_5_list.get(0);
		Assert.assertNotNull(TypeSpecifier_6_Var
		);
		Assert.assertEquals("int", TypeSpecifier_6_Var
		.getName());
		//6
		final Declarator Declarator_7_Var
		 = (Declarator)FunctionDefHead_4_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_7_Var
		);
		//7
		final DirectDeclarator DirectDeclarator_8_Var
		 = (DirectDeclarator)Declarator_7_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_8_Var
		);
		Assert.assertEquals("a", DirectDeclarator_8_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_8_list = DirectDeclarator_8_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_8_list);
		Assert.assertEquals(1, DeclaratorSuffix_8_list.size());
		//8
		final DeclaratorSuffix DeclaratorSuffix_9_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_8_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_9_Var
		);
		//9
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_10_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_9_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_10_Var
		);
		final EList<? extends EObject> ParameterTypeList_10_list = DirectDeclaratorLastSuffix_10_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_10_list);
		Assert.assertEquals(1, ParameterTypeList_10_list.size());
		//10
		final ParameterTypeList ParameterTypeList_11_Var
		 = (ParameterTypeList)ParameterTypeList_10_list.get(0);
		Assert.assertNotNull(ParameterTypeList_11_Var
		);
		//11
		final ParameterList ParameterList_12_Var
		 = (ParameterList)ParameterTypeList_11_Var
		.getList();
		Assert.assertNotNull(ParameterList_12_Var
		);
		final EList<? extends EObject> ParameterDeclaration_12_list = ParameterList_12_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_12_list);
		Assert.assertEquals(1, ParameterDeclaration_12_list.size());
		//12
		final ParameterDeclaration ParameterDeclaration_13_Var
		 = (ParameterDeclaration)ParameterDeclaration_12_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_13_Var
		);
		//13
		final DeclarationSpecifiers DeclarationSpecifiers_14_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_13_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_14_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_14_list = DeclarationSpecifiers_14_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_14_list);
		Assert.assertEquals(1, DeclarationSpecifier_14_list.size());
		//14
		final TypeSpecifier TypeSpecifier_15_Var
		 = (TypeSpecifier)DeclarationSpecifier_14_list.get(0);
		Assert.assertNotNull(TypeSpecifier_15_Var
		);
		Assert.assertEquals("int", TypeSpecifier_15_Var
		.getName());
		//15
		final Declarator Declarator_16_Var
		 = (Declarator)ParameterDeclaration_13_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_16_Var
		);
		//16
		final DirectDeclarator DirectDeclarator_17_Var
		 = (DirectDeclarator)Declarator_16_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_17_Var
		);
		Assert.assertEquals("num", DirectDeclarator_17_Var
		.getId());
		//17
		final FunctionDefinition FunctionDefinition_18_Var
		 = (FunctionDefinition)ExternalDeclaration_3_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_18_Var
		);
		//18
		final BodyStatement BodyStatement_19_Var
		 = (BodyStatement)FunctionDefinition_18_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_19_Var
		);
		final EList<? extends EObject> BlockList_19_list = BodyStatement_19_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_19_list);
		Assert.assertEquals(1, BlockList_19_list.size());
		//19
		final BlockList BlockList_20_Var
		 = (BlockList)BlockList_19_list.get(0);
		Assert.assertNotNull(BlockList_20_Var
		);
		final EList<? extends EObject> Statement_20_list = BlockList_20_Var
		.getStatement();
		Assert.assertNotNull(Statement_20_list);
		Assert.assertEquals(2, Statement_20_list.size());
		//20
		final Statement Statement_21_Var
		 = (Statement)Statement_20_list.get(0);
		Assert.assertNotNull(Statement_21_Var
		);
		//21
		final ExpressionStatement ExpressionStatement_22_Var
		 = (ExpressionStatement)Statement_21_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_22_Var
		);
		//22
		final Expression Expression_23_Var
		 = (Expression)ExpressionStatement_22_Var
		.getExpression();
		Assert.assertNotNull(Expression_23_Var
		);
		final EList<? extends EObject> ExprExpr_23_list = Expression_23_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_23_list);
		Assert.assertEquals(1, ExprExpr_23_list.size());
		//23
		final AssignmentExpression AssignmentExpression_24_Var
		 = (AssignmentExpression)ExprExpr_23_list.get(0);
		Assert.assertNotNull(AssignmentExpression_24_Var
		);
		//24
		final ConditionalExpression ConditionalExpression_25_Var
		 = (ConditionalExpression)AssignmentExpression_24_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_25_Var
		);
		//25
		final LogicalOrExpression LogicalOrExpression_26_Var
		 = (LogicalOrExpression)ConditionalExpression_25_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = LogicalOrExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final LogicalAndExpression LogicalAndExpression_27_Var
		 = (LogicalAndExpression)Expr_26_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = LogicalAndExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final InclusiveOrExpression InclusiveOrExpression_28_Var
		 = (InclusiveOrExpression)Expr_27_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = InclusiveOrExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final ExclusiveOrExpression ExclusiveOrExpression_29_Var
		 = (ExclusiveOrExpression)Expr_28_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = ExclusiveOrExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final AndExpression AndExpression_30_Var
		 = (AndExpression)Expr_29_list.get(0);
		Assert.assertNotNull(AndExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = AndExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final EqualityExpression EqualityExpression_31_Var
		 = (EqualityExpression)Expr_30_list.get(0);
		Assert.assertNotNull(EqualityExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = EqualityExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final RelationalExpression RelationalExpression_32_Var
		 = (RelationalExpression)Expr_31_list.get(0);
		Assert.assertNotNull(RelationalExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = RelationalExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final ShiftExpression ShiftExpression_33_Var
		 = (ShiftExpression)Expr_32_list.get(0);
		Assert.assertNotNull(ShiftExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = ShiftExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final AdditiveExpression AdditiveExpression_34_Var
		 = (AdditiveExpression)Expr_33_list.get(0);
		Assert.assertNotNull(AdditiveExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = AdditiveExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final MultiplicativeExpression MultiplicativeExpression_35_Var
		 = (MultiplicativeExpression)Expr_34_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = MultiplicativeExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final CastExpression CastExpression_36_Var
		 = (CastExpression)Expr_35_list.get(0);
		Assert.assertNotNull(CastExpression_36_Var
		);
		//36
		final UnaryExpression UnaryExpression_37_Var
		 = (UnaryExpression)CastExpression_36_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_37_Var
		);
		//37
		final PostfixExpression PostfixExpression_38_Var
		 = (PostfixExpression)UnaryExpression_37_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = PostfixExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final PrimaryExpression PrimaryExpression_39_Var
		 = (PrimaryExpression)Expr_38_list.get(0);
		Assert.assertNotNull(PrimaryExpression_39_Var
		);
		Assert.assertEquals("num", PrimaryExpression_39_Var
		.getId());
		final EList<? extends EObject> Suffix_39_list = PostfixExpression_38_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_39_list);
		Assert.assertEquals(1, Suffix_39_list.size());
		//39
		final PostfixExpressionSuffixPlusPlus PostfixExpressionSuffixPlusPlus_40_Var
		 = (PostfixExpressionSuffixPlusPlus)Suffix_39_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixPlusPlus_40_Var
		);
		Assert.assertEquals(";", ExpressionStatement_22_Var
		.getSemi());
		//40
		final Statement Statement_41_Var
		 = (Statement)Statement_20_list.get(1);
		Assert.assertNotNull(Statement_41_Var
		);
		//41
		final JumpStatement JumpStatement_42_Var
		 = (JumpStatement)Statement_41_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_42_Var
		);
		Assert.assertEquals("return", JumpStatement_42_Var
		.getReturn());
		//42
		final Expression Expression_43_Var
		 = (Expression)JumpStatement_42_Var
		.getExpr();
		Assert.assertNotNull(Expression_43_Var
		);
		final EList<? extends EObject> ExprExpr_43_list = Expression_43_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_43_list);
		Assert.assertEquals(1, ExprExpr_43_list.size());
		//43
		final AssignmentExpression AssignmentExpression_44_Var
		 = (AssignmentExpression)ExprExpr_43_list.get(0);
		Assert.assertNotNull(AssignmentExpression_44_Var
		);
		//44
		final ConditionalExpression ConditionalExpression_45_Var
		 = (ConditionalExpression)AssignmentExpression_44_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_45_Var
		);
		//45
		final LogicalOrExpression LogicalOrExpression_46_Var
		 = (LogicalOrExpression)ConditionalExpression_45_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = LogicalOrExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final LogicalAndExpression LogicalAndExpression_47_Var
		 = (LogicalAndExpression)Expr_46_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = LogicalAndExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final InclusiveOrExpression InclusiveOrExpression_48_Var
		 = (InclusiveOrExpression)Expr_47_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = InclusiveOrExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final ExclusiveOrExpression ExclusiveOrExpression_49_Var
		 = (ExclusiveOrExpression)Expr_48_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = ExclusiveOrExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final AndExpression AndExpression_50_Var
		 = (AndExpression)Expr_49_list.get(0);
		Assert.assertNotNull(AndExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = AndExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final EqualityExpression EqualityExpression_51_Var
		 = (EqualityExpression)Expr_50_list.get(0);
		Assert.assertNotNull(EqualityExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = EqualityExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final RelationalExpression RelationalExpression_52_Var
		 = (RelationalExpression)Expr_51_list.get(0);
		Assert.assertNotNull(RelationalExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = RelationalExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final ShiftExpression ShiftExpression_53_Var
		 = (ShiftExpression)Expr_52_list.get(0);
		Assert.assertNotNull(ShiftExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = ShiftExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final AdditiveExpression AdditiveExpression_54_Var
		 = (AdditiveExpression)Expr_53_list.get(0);
		Assert.assertNotNull(AdditiveExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = AdditiveExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final MultiplicativeExpression MultiplicativeExpression_55_Var
		 = (MultiplicativeExpression)Expr_54_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = MultiplicativeExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final CastExpression CastExpression_56_Var
		 = (CastExpression)Expr_55_list.get(0);
		Assert.assertNotNull(CastExpression_56_Var
		);
		//56
		final UnaryExpression UnaryExpression_57_Var
		 = (UnaryExpression)CastExpression_56_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_57_Var
		);
		//57
		final UnaryExpression UnaryExpression_58_Var
		 = (UnaryExpression)UnaryExpression_57_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_58_Var
		);
		//58
		final PostfixExpression PostfixExpression_59_Var
		 = (PostfixExpression)UnaryExpression_58_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = PostfixExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final PrimaryExpression PrimaryExpression_60_Var
		 = (PrimaryExpression)Expr_59_list.get(0);
		Assert.assertNotNull(PrimaryExpression_60_Var
		);
		Assert.assertEquals("num", PrimaryExpression_60_Var
		.getId());
		Assert.assertEquals("++", UnaryExpression_57_Var
		.getPlusplus());
		Assert.assertEquals(";", JumpStatement_42_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0022_PlusPlus.c");
		Resource resource = set.getResource(uri, true);
		// validate the resource
		List<Issue> list = this.validator.validate(resource, 
			CheckMode.ALL,CancelIndicator.NullImpl);
		Assert.assertTrue(list.isEmpty());
		
		// configure and start the generator
		this.fileAccessSystem.setOutputPath("bin");
		final Class<?> clazz = this.generator.getClass();
		try {
			final Method method = clazz.getMethod("setFileName",
					String.class);
			if (method != null) {
				method.invoke(this.generator, "Test0022_PlusPlus.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0022_PlusPlus.c");
		final String expected = this.getTextFromFile(
			"res/Test0022_PlusPlus.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
		// System.out.println("Code generation finished.");
	}
	
	private String preprocess(String string) throws Exception {
		string = preprocessForFile(string);
		string = preprocessForPatterns(string);
		return string;
	}
	
	private String preprocessForFile(String string) throws Exception {
		final String content = this.getTextFromFile("res/Patterns.txt");
		final String[] lines = content.split("\n");
		if (lines == null) {
			return string;
		}
		for (String line : lines) {
			final String[] myLine = line.split("=");
			if (myLine == null || myLine.length != 2) {
				continue;
			}
			final String regex = myLine[0].replace("\"", "").replace("\\\\", "\\");
			final String replace = myLine[1].replace("\"", "").replace("\\\\", "\\");
			string = string.replaceAll(regex, replace);
		}
		return string;
	}
	
	private String preprocessForPatterns(String string) {
		return string;
	}
	
}


