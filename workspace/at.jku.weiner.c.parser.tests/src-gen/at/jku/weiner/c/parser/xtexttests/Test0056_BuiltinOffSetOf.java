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

import at.jku.weiner.c.parser.parser.Parser;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.StructDeclarationList;
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
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
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
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
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0056_BuiltinOffSetOf {
	@Inject
	private ParseHelper<Parser> parseHelper;
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
		at.jku.weiner.c.parser.xtexttests.TestSuite_Structs.testSize();
	}
	
	@After
	public void cleanUp() {
		at.jku.weiner.c.parser.xtexttests.TestSuite_Structs.testSize();
	}
	
	private String getTextFromFile(final String fileName)
	throws Exception{
		final Path path = Paths.get(fileName);
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
	@Test (timeout=1000)
	public void checkLexerTokens() throws Exception{
		final String text = this.getTextFromFile(
			"res/Test0056_BuiltinOffSetOf.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_STRUCT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_STRUCT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_BUILTIN_OFFSETOF",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_STRUCT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
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
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0056_BuiltinOffSetOf.c");
		final Parser Parser_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(Parser_0_Var
		);
		
		Assert.assertNotNull(Parser_0_Var
		);
		final EList<? extends EObject> External_0_list = Parser_0_Var
		.getExternal();
		Assert.assertNotNull(External_0_list);
		Assert.assertEquals(2, External_0_list.size());
		//0
		final ExternalDeclaration ExternalDeclaration_1_Var
		 = (ExternalDeclaration)External_0_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_1_Var
		);
		//1
		final Declaration Declaration_2_Var
		 = (Declaration)ExternalDeclaration_1_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_2_Var
		);
		//2
		final DeclarationSpecifiers DeclarationSpecifiers_3_Var
		 = (DeclarationSpecifiers)Declaration_2_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_3_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_3_list = DeclarationSpecifiers_3_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_3_list);
		Assert.assertEquals(1, DeclarationSpecifier_3_list.size());
		//3
		final StructOrUnionSpecifier StructOrUnionSpecifier_4_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_4_Var
		);
		//4
		final StructOrUnion StructOrUnion_5_Var
		 = (StructOrUnion)StructOrUnionSpecifier_4_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_5_Var
		);
		Assert.assertEquals("struct", StructOrUnion_5_Var
		.getName());
		Assert.assertEquals("foo", StructOrUnionSpecifier_4_Var
		.getId());
		//5
		final StructDeclarationList StructDeclarationList_6_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_4_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_6_Var
		);
		final EList<? extends EObject> StructDeclaration_6_list = StructDeclarationList_6_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_6_list);
		Assert.assertEquals(1, StructDeclaration_6_list.size());
		//6
		final StructDeclaration StructDeclaration_7_Var
		 = (StructDeclaration)StructDeclaration_6_list.get(0);
		Assert.assertNotNull(StructDeclaration_7_Var
		);
		//7
		final SpecifierQualifierList SpecifierQualifierList_8_Var
		 = (SpecifierQualifierList)StructDeclaration_7_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_8_Var
		);
		final EList<? extends EObject> TypeSpecifier_8_list = SpecifierQualifierList_8_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_8_list);
		Assert.assertEquals(1, TypeSpecifier_8_list.size());
		//8
		final TypeSpecifier TypeSpecifier_9_Var
		 = (TypeSpecifier)TypeSpecifier_8_list.get(0);
		Assert.assertNotNull(TypeSpecifier_9_Var
		);
		Assert.assertEquals("int", TypeSpecifier_9_Var
		.getName());
		//9
		final StructDeclaratorList StructDeclaratorList_10_Var
		 = (StructDeclaratorList)StructDeclaration_7_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_10_Var
		);
		final EList<? extends EObject> StructDeclarator_10_list = StructDeclaratorList_10_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_10_list);
		Assert.assertEquals(1, StructDeclarator_10_list.size());
		//10
		final StructDeclarator StructDeclarator_11_Var
		 = (StructDeclarator)StructDeclarator_10_list.get(0);
		Assert.assertNotNull(StructDeclarator_11_Var
		);
		//11
		final Declarator Declarator_12_Var
		 = (Declarator)StructDeclarator_11_Var
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
		//13
		final ExternalDeclaration ExternalDeclaration_14_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_14_Var
		);
		//14
		final FunctionDefHead FunctionDefHead_15_Var
		 = (FunctionDefHead)ExternalDeclaration_14_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_15_Var
		);
		//15
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_16_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_15_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_16_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_16_list = FunctionDeclarationSpecifiers_16_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_16_list);
		Assert.assertEquals(1, DeclarationSpecifier_16_list.size());
		//16
		final TypeSpecifier TypeSpecifier_17_Var
		 = (TypeSpecifier)DeclarationSpecifier_16_list.get(0);
		Assert.assertNotNull(TypeSpecifier_17_Var
		);
		Assert.assertEquals("void", TypeSpecifier_17_Var
		.getName());
		//17
		final Declarator Declarator_18_Var
		 = (Declarator)FunctionDefHead_15_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_18_Var
		);
		//18
		final DirectDeclarator DirectDeclarator_19_Var
		 = (DirectDeclarator)Declarator_18_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_19_Var
		);
		Assert.assertEquals("bar", DirectDeclarator_19_Var
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
		final EList<? extends EObject> ParameterTypeList_21_list = DirectDeclaratorLastSuffix_21_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_21_list);
		Assert.assertEquals(1, ParameterTypeList_21_list.size());
		//21
		final ParameterTypeList ParameterTypeList_22_Var
		 = (ParameterTypeList)ParameterTypeList_21_list.get(0);
		Assert.assertNotNull(ParameterTypeList_22_Var
		);
		//22
		final ParameterList ParameterList_23_Var
		 = (ParameterList)ParameterTypeList_22_Var
		.getList();
		Assert.assertNotNull(ParameterList_23_Var
		);
		final EList<? extends EObject> ParameterDeclaration_23_list = ParameterList_23_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_23_list);
		Assert.assertEquals(1, ParameterDeclaration_23_list.size());
		//23
		final ParameterDeclaration ParameterDeclaration_24_Var
		 = (ParameterDeclaration)ParameterDeclaration_23_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_24_Var
		);
		//24
		final DeclarationSpecifiers DeclarationSpecifiers_25_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_24_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_25_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_25_list = DeclarationSpecifiers_25_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_25_list);
		Assert.assertEquals(1, DeclarationSpecifier_25_list.size());
		//25
		final StructOrUnionSpecifier StructOrUnionSpecifier_26_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_25_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_26_Var
		);
		//26
		final StructOrUnion StructOrUnion_27_Var
		 = (StructOrUnion)StructOrUnionSpecifier_26_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_27_Var
		);
		Assert.assertEquals("struct", StructOrUnion_27_Var
		.getName());
		Assert.assertEquals("foo", StructOrUnionSpecifier_26_Var
		.getId());
		//27
		final Declarator Declarator_28_Var
		 = (Declarator)ParameterDeclaration_24_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_28_Var
		);
		//28
		final DirectDeclarator DirectDeclarator_29_Var
		 = (DirectDeclarator)Declarator_28_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_29_Var
		);
		Assert.assertEquals("foobar", DirectDeclarator_29_Var
		.getId());
		//29
		final FunctionDefinition FunctionDefinition_30_Var
		 = (FunctionDefinition)ExternalDeclaration_14_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_30_Var
		);
		//30
		final BodyStatement BodyStatement_31_Var
		 = (BodyStatement)FunctionDefinition_30_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_31_Var
		);
		final EList<? extends EObject> BlockList_31_list = BodyStatement_31_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_31_list);
		Assert.assertEquals(1, BlockList_31_list.size());
		//31
		final BlockList BlockList_32_Var
		 = (BlockList)BlockList_31_list.get(0);
		Assert.assertNotNull(BlockList_32_Var
		);
		final EList<? extends EObject> Statement_32_list = BlockList_32_Var
		.getStatement();
		Assert.assertNotNull(Statement_32_list);
		Assert.assertEquals(1, Statement_32_list.size());
		//32
		final Statement Statement_33_Var
		 = (Statement)Statement_32_list.get(0);
		Assert.assertNotNull(Statement_33_Var
		);
		//33
		final ExpressionStatement ExpressionStatement_34_Var
		 = (ExpressionStatement)Statement_33_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_34_Var
		);
		//34
		final Expression Expression_35_Var
		 = (Expression)ExpressionStatement_34_Var
		.getExpression();
		Assert.assertNotNull(Expression_35_Var
		);
		final EList<? extends EObject> ExprExpr_35_list = Expression_35_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_35_list);
		Assert.assertEquals(1, ExprExpr_35_list.size());
		//35
		final AssignmentExpression AssignmentExpression_36_Var
		 = (AssignmentExpression)ExprExpr_35_list.get(0);
		Assert.assertNotNull(AssignmentExpression_36_Var
		);
		//36
		final ConditionalExpression ConditionalExpression_37_Var
		 = (ConditionalExpression)AssignmentExpression_36_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_37_Var
		);
		//37
		final LogicalOrExpression LogicalOrExpression_38_Var
		 = (LogicalOrExpression)ConditionalExpression_37_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = LogicalOrExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final LogicalAndExpression LogicalAndExpression_39_Var
		 = (LogicalAndExpression)Expr_38_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = LogicalAndExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final InclusiveOrExpression InclusiveOrExpression_40_Var
		 = (InclusiveOrExpression)Expr_39_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = InclusiveOrExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final ExclusiveOrExpression ExclusiveOrExpression_41_Var
		 = (ExclusiveOrExpression)Expr_40_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = ExclusiveOrExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final AndExpression AndExpression_42_Var
		 = (AndExpression)Expr_41_list.get(0);
		Assert.assertNotNull(AndExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = AndExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final EqualityExpression EqualityExpression_43_Var
		 = (EqualityExpression)Expr_42_list.get(0);
		Assert.assertNotNull(EqualityExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = EqualityExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final RelationalExpression RelationalExpression_44_Var
		 = (RelationalExpression)Expr_43_list.get(0);
		Assert.assertNotNull(RelationalExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = RelationalExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final ShiftExpression ShiftExpression_45_Var
		 = (ShiftExpression)Expr_44_list.get(0);
		Assert.assertNotNull(ShiftExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = ShiftExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final AdditiveExpression AdditiveExpression_46_Var
		 = (AdditiveExpression)Expr_45_list.get(0);
		Assert.assertNotNull(AdditiveExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = AdditiveExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final MultiplicativeExpression MultiplicativeExpression_47_Var
		 = (MultiplicativeExpression)Expr_46_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = MultiplicativeExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final CastExpression CastExpression_48_Var
		 = (CastExpression)Expr_47_list.get(0);
		Assert.assertNotNull(CastExpression_48_Var
		);
		//48
		final UnaryExpression UnaryExpression_49_Var
		 = (UnaryExpression)CastExpression_48_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_49_Var
		);
		//49
		final PostfixExpression PostfixExpression_50_Var
		 = (PostfixExpression)UnaryExpression_49_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = PostfixExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final PrimaryExpression PrimaryExpression_51_Var
		 = (PrimaryExpression)Expr_50_list.get(0);
		Assert.assertNotNull(PrimaryExpression_51_Var
		);
		Assert.assertTrue(PrimaryExpression_51_Var
		.isBuiltin_offsetof());
		//51
		final TypeName TypeName_52_Var
		 = (TypeName)PrimaryExpression_51_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_52_Var
		);
		//52
		final SpecifierQualifierList SpecifierQualifierList_53_Var
		 = (SpecifierQualifierList)TypeName_52_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_53_Var
		);
		final EList<? extends EObject> StructOrUnionSpecifier_53_list = SpecifierQualifierList_53_Var
		.getStructOrUnionSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_53_list);
		Assert.assertEquals(1, StructOrUnionSpecifier_53_list.size());
		//53
		final StructOrUnionSpecifier StructOrUnionSpecifier_54_Var
		 = (StructOrUnionSpecifier)StructOrUnionSpecifier_53_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_54_Var
		);
		//54
		final StructOrUnion StructOrUnion_55_Var
		 = (StructOrUnion)StructOrUnionSpecifier_54_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_55_Var
		);
		Assert.assertEquals("struct", StructOrUnion_55_Var
		.getName());
		Assert.assertEquals("foo", StructOrUnionSpecifier_54_Var
		.getId());
		//55
		final UnaryExpression UnaryExpression_56_Var
		 = (UnaryExpression)PrimaryExpression_51_Var
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
		Assert.assertEquals("i", PrimaryExpression_58_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_34_Var
		.getSemi());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0056_BuiltinOffSetOf.c");
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
				method.invoke(this.generator, "Test0056_BuiltinOffSetOf.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0056_BuiltinOffSetOf.c");
		final String expected = this.getTextFromFile(
			"res/Test0056_BuiltinOffSetOf.c"
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


