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

import at.jku.weiner.c.parser.parser.Model;
import at.jku.weiner.c.parser.parser.TranslationUnit;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
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
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
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
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0032_Sizeof {
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
			"res/Test0032_SizeOf.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
				"RULE_KW_SIZEOF", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_KW_INT", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_SKW_RIGHTBRACE", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_LONG", 
				"RULE_WHITESPACE", 
				"RULE_KW_UNSIGNED", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_KW_UNSIGNED", 
				"RULE_WHITESPACE", 
				"RULE_KW_LONG", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_KW_SIZEOF", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_KW_INT", 
				"RULE_SKW_RIGHTPAREN", 
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
			"res/Test0032_SizeOf.c");
		final Model Model_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(Model_0_Var
		);
		
		Assert.assertNotNull(Model_0_Var
		);
		final EList<? extends EObject> Unit_0_list = Model_0_Var
		.getUnit();
		Assert.assertNotNull(Unit_0_list);
		Assert.assertEquals(1, Unit_0_list.size());
		//0
		final TranslationUnit TranslationUnit_1_Var
		 = (TranslationUnit)Unit_0_list.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var
		);
		final EList<? extends EObject> External_1_list = TranslationUnit_1_Var
		.getExternal();
		Assert.assertNotNull(External_1_list);
		Assert.assertEquals(2, External_1_list.size());
		//1
		final ExternalDeclaration ExternalDeclaration_2_Var
		 = (ExternalDeclaration)External_1_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_2_Var
		);
		//2
		final FunctionDefHead FunctionDefHead_3_Var
		 = (FunctionDefHead)ExternalDeclaration_2_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_3_Var
		);
		//3
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_4_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_3_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_4_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_4_list = FunctionDeclarationSpecifiers_4_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_4_list);
		Assert.assertEquals(1, DeclarationSpecifier_4_list.size());
		//4
		final TypeSpecifier TypeSpecifier_5_Var
		 = (TypeSpecifier)DeclarationSpecifier_4_list.get(0);
		Assert.assertNotNull(TypeSpecifier_5_Var
		);
		Assert.assertEquals("int", TypeSpecifier_5_Var
		.getName());
		//5
		final Declarator Declarator_6_Var
		 = (Declarator)FunctionDefHead_3_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_6_Var
		);
		//6
		final DirectDeclarator DirectDeclarator_7_Var
		 = (DirectDeclarator)Declarator_6_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_7_Var
		);
		Assert.assertEquals("sizeOfInt", DirectDeclarator_7_Var
		.getId());
		//7
		final FunctionDefinition FunctionDefinition_8_Var
		 = (FunctionDefinition)ExternalDeclaration_2_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_8_Var
		);
		//8
		final BodyStatement BodyStatement_9_Var
		 = (BodyStatement)FunctionDefinition_8_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_9_Var
		);
		final EList<? extends EObject> BlockList_9_list = BodyStatement_9_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_9_list);
		Assert.assertEquals(1, BlockList_9_list.size());
		//9
		final BlockList BlockList_10_Var
		 = (BlockList)BlockList_9_list.get(0);
		Assert.assertNotNull(BlockList_10_Var
		);
		final EList<? extends EObject> Statement_10_list = BlockList_10_Var
		.getStatement();
		Assert.assertNotNull(Statement_10_list);
		Assert.assertEquals(1, Statement_10_list.size());
		//10
		final Statement Statement_11_Var
		 = (Statement)Statement_10_list.get(0);
		Assert.assertNotNull(Statement_11_Var
		);
		//11
		final JumpStatement JumpStatement_12_Var
		 = (JumpStatement)Statement_11_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_12_Var
		);
		//12
		final Expression Expression_13_Var
		 = (Expression)JumpStatement_12_Var
		.getExpr();
		Assert.assertNotNull(Expression_13_Var
		);
		final EList<? extends EObject> ExprExpr_13_list = Expression_13_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_13_list);
		Assert.assertEquals(1, ExprExpr_13_list.size());
		//13
		final AssignmentExpression AssignmentExpression_14_Var
		 = (AssignmentExpression)ExprExpr_13_list.get(0);
		Assert.assertNotNull(AssignmentExpression_14_Var
		);
		//14
		final ConditionalExpression ConditionalExpression_15_Var
		 = (ConditionalExpression)AssignmentExpression_14_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_15_Var
		);
		//15
		final LogicalOrExpression LogicalOrExpression_16_Var
		 = (LogicalOrExpression)ConditionalExpression_15_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = LogicalOrExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final LogicalAndExpression LogicalAndExpression_17_Var
		 = (LogicalAndExpression)Expr_16_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = LogicalAndExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final InclusiveOrExpression InclusiveOrExpression_18_Var
		 = (InclusiveOrExpression)Expr_17_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = InclusiveOrExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final ExclusiveOrExpression ExclusiveOrExpression_19_Var
		 = (ExclusiveOrExpression)Expr_18_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = ExclusiveOrExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final AndExpression AndExpression_20_Var
		 = (AndExpression)Expr_19_list.get(0);
		Assert.assertNotNull(AndExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = AndExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final EqualityExpression EqualityExpression_21_Var
		 = (EqualityExpression)Expr_20_list.get(0);
		Assert.assertNotNull(EqualityExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = EqualityExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final RelationalExpression RelationalExpression_22_Var
		 = (RelationalExpression)Expr_21_list.get(0);
		Assert.assertNotNull(RelationalExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = RelationalExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final ShiftExpression ShiftExpression_23_Var
		 = (ShiftExpression)Expr_22_list.get(0);
		Assert.assertNotNull(ShiftExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = ShiftExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final AdditiveExpression AdditiveExpression_24_Var
		 = (AdditiveExpression)Expr_23_list.get(0);
		Assert.assertNotNull(AdditiveExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = AdditiveExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final MultiplicativeExpression MultiplicativeExpression_25_Var
		 = (MultiplicativeExpression)Expr_24_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = MultiplicativeExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final CastExpression CastExpression_26_Var
		 = (CastExpression)Expr_25_list.get(0);
		Assert.assertNotNull(CastExpression_26_Var
		);
		//26
		final UnaryExpression UnaryExpression_27_Var
		 = (UnaryExpression)CastExpression_26_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_27_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_27_Var
		.getSizeOf());
		//27
		final TypeName TypeName_28_Var
		 = (TypeName)UnaryExpression_27_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_28_Var
		);
		//28
		final SpecifierQualifierList SpecifierQualifierList_29_Var
		 = (SpecifierQualifierList)TypeName_28_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_29_Var
		);
		final EList<? extends EObject> TypeSpecifier_29_list = SpecifierQualifierList_29_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_29_list);
		Assert.assertEquals(1, TypeSpecifier_29_list.size());
		//29
		final TypeSpecifier TypeSpecifier_30_Var
		 = (TypeSpecifier)TypeSpecifier_29_list.get(0);
		Assert.assertNotNull(TypeSpecifier_30_Var
		);
		Assert.assertEquals("int", TypeSpecifier_30_Var
		.getName());
		Assert.assertEquals("return", JumpStatement_12_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_12_Var
		.getSemi());
		//30
		final ExternalDeclaration ExternalDeclaration_31_Var
		 = (ExternalDeclaration)External_1_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_31_Var
		);
		//31
		final FunctionDefHead FunctionDefHead_32_Var
		 = (FunctionDefHead)ExternalDeclaration_31_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_32_Var
		);
		//32
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_33_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_32_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_33_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_33_list = FunctionDeclarationSpecifiers_33_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_33_list);
		Assert.assertEquals(2, DeclarationSpecifier_33_list.size());
		//33
		final TypeSpecifier TypeSpecifier_34_Var
		 = (TypeSpecifier)DeclarationSpecifier_33_list.get(0);
		Assert.assertNotNull(TypeSpecifier_34_Var
		);
		Assert.assertEquals("long", TypeSpecifier_34_Var
		.getName());
		//34
		final TypeSpecifier TypeSpecifier_35_Var
		 = (TypeSpecifier)DeclarationSpecifier_33_list.get(1);
		Assert.assertNotNull(TypeSpecifier_35_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_35_Var
		.getName());
		//35
		final Declarator Declarator_36_Var
		 = (Declarator)FunctionDefHead_32_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_36_Var
		);
		//36
		final DirectDeclarator DirectDeclarator_37_Var
		 = (DirectDeclarator)Declarator_36_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_37_Var
		);
		Assert.assertEquals("sizeOfInt2", DirectDeclarator_37_Var
		.getId());
		//37
		final FunctionDefinition FunctionDefinition_38_Var
		 = (FunctionDefinition)ExternalDeclaration_31_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_38_Var
		);
		//38
		final BodyStatement BodyStatement_39_Var
		 = (BodyStatement)FunctionDefinition_38_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_39_Var
		);
		final EList<? extends EObject> BlockList_39_list = BodyStatement_39_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_39_list);
		Assert.assertEquals(1, BlockList_39_list.size());
		//39
		final BlockList BlockList_40_Var
		 = (BlockList)BlockList_39_list.get(0);
		Assert.assertNotNull(BlockList_40_Var
		);
		final EList<? extends EObject> Statement_40_list = BlockList_40_Var
		.getStatement();
		Assert.assertNotNull(Statement_40_list);
		Assert.assertEquals(1, Statement_40_list.size());
		//40
		final Statement Statement_41_Var
		 = (Statement)Statement_40_list.get(0);
		Assert.assertNotNull(Statement_41_Var
		);
		//41
		final JumpStatement JumpStatement_42_Var
		 = (JumpStatement)Statement_41_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_42_Var
		);
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
		final TypeName TypeName_57_Var
		 = (TypeName)CastExpression_56_Var
		.getType();
		Assert.assertNotNull(TypeName_57_Var
		);
		//57
		final SpecifierQualifierList SpecifierQualifierList_58_Var
		 = (SpecifierQualifierList)TypeName_57_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_58_Var
		);
		final EList<? extends EObject> TypeSpecifier_58_list = SpecifierQualifierList_58_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_58_list);
		Assert.assertEquals(2, TypeSpecifier_58_list.size());
		//58
		final TypeSpecifier TypeSpecifier_59_Var
		 = (TypeSpecifier)TypeSpecifier_58_list.get(0);
		Assert.assertNotNull(TypeSpecifier_59_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_59_Var
		.getName());
		//59
		final TypeSpecifier TypeSpecifier_60_Var
		 = (TypeSpecifier)TypeSpecifier_58_list.get(1);
		Assert.assertNotNull(TypeSpecifier_60_Var
		);
		Assert.assertEquals("long", TypeSpecifier_60_Var
		.getName());
		//60
		final CastExpression CastExpression_61_Var
		 = (CastExpression)CastExpression_56_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_61_Var
		);
		//61
		final UnaryExpression UnaryExpression_62_Var
		 = (UnaryExpression)CastExpression_61_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_62_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_62_Var
		.getSizeOf());
		//62
		final TypeName TypeName_63_Var
		 = (TypeName)UnaryExpression_62_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_63_Var
		);
		//63
		final SpecifierQualifierList SpecifierQualifierList_64_Var
		 = (SpecifierQualifierList)TypeName_63_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_64_Var
		);
		final EList<? extends EObject> TypeSpecifier_64_list = SpecifierQualifierList_64_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_64_list);
		Assert.assertEquals(1, TypeSpecifier_64_list.size());
		//64
		final TypeSpecifier TypeSpecifier_65_Var
		 = (TypeSpecifier)TypeSpecifier_64_list.get(0);
		Assert.assertNotNull(TypeSpecifier_65_Var
		);
		Assert.assertEquals("int", TypeSpecifier_65_Var
		.getName());
		Assert.assertEquals("return", JumpStatement_42_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_42_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0032_SizeOf.c");
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
				method.invoke(this.generator, "Test0032_Sizeof.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0032_Sizeof.c");
		final String expected = this.getTextFromFile(
			"res/Test0032_SizeOf.c"
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


