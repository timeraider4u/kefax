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
import at.jku.weiner.c.parser.parser.TypeSpecifier;
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
import at.jku.weiner.c.parser.parser.TypeSpecifier;
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
import at.jku.weiner.c.parser.parser.TypeSpecifier;
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
		final TypeSpecifier TypeSpecifier_4_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(TypeSpecifier_4_Var
		);
		//4
		final StructOrUnionSpecifier StructOrUnionSpecifier_5_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_4_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_5_Var
		);
		//5
		final StructOrUnion StructOrUnion_6_Var
		 = (StructOrUnion)StructOrUnionSpecifier_5_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_6_Var
		);
		Assert.assertEquals("struct", StructOrUnion_6_Var
		.getName());
		Assert.assertEquals("foo", StructOrUnionSpecifier_5_Var
		.getId());
		//6
		final StructDeclarationList StructDeclarationList_7_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_5_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_7_Var
		);
		final EList<? extends EObject> StructDeclaration_7_list = StructDeclarationList_7_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_7_list);
		Assert.assertEquals(1, StructDeclaration_7_list.size());
		//7
		final StructDeclaration StructDeclaration_8_Var
		 = (StructDeclaration)StructDeclaration_7_list.get(0);
		Assert.assertNotNull(StructDeclaration_8_Var
		);
		//8
		final SpecifierQualifierList SpecifierQualifierList_9_Var
		 = (SpecifierQualifierList)StructDeclaration_8_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_9_Var
		);
		final EList<? extends EObject> TypeSpecifier_9_list = SpecifierQualifierList_9_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_9_list);
		Assert.assertEquals(1, TypeSpecifier_9_list.size());
		//9
		final TypeSpecifier TypeSpecifier_10_Var
		 = (TypeSpecifier)TypeSpecifier_9_list.get(0);
		Assert.assertNotNull(TypeSpecifier_10_Var
		);
		Assert.assertEquals("int", TypeSpecifier_10_Var
		.getName());
		//10
		final StructDeclaratorList StructDeclaratorList_11_Var
		 = (StructDeclaratorList)StructDeclaration_8_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_11_Var
		);
		final EList<? extends EObject> StructDeclarator_11_list = StructDeclaratorList_11_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_11_list);
		Assert.assertEquals(1, StructDeclarator_11_list.size());
		//11
		final StructDeclarator StructDeclarator_12_Var
		 = (StructDeclarator)StructDeclarator_11_list.get(0);
		Assert.assertNotNull(StructDeclarator_12_Var
		);
		//12
		final Declarator Declarator_13_Var
		 = (Declarator)StructDeclarator_12_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_13_Var
		);
		//13
		final DirectDeclarator DirectDeclarator_14_Var
		 = (DirectDeclarator)Declarator_13_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_14_Var
		);
		Assert.assertEquals("i", DirectDeclarator_14_Var
		.getId());
		//14
		final ExternalDeclaration ExternalDeclaration_15_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_15_Var
		);
		//15
		final FunctionDefHead FunctionDefHead_16_Var
		 = (FunctionDefHead)ExternalDeclaration_15_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_16_Var
		);
		//16
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_17_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_16_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_17_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_17_list = FunctionDeclarationSpecifiers_17_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_17_list);
		Assert.assertEquals(1, DeclarationSpecifier_17_list.size());
		//17
		final TypeSpecifier TypeSpecifier_18_Var
		 = (TypeSpecifier)DeclarationSpecifier_17_list.get(0);
		Assert.assertNotNull(TypeSpecifier_18_Var
		);
		Assert.assertEquals("void", TypeSpecifier_18_Var
		.getName());
		//18
		final Declarator Declarator_19_Var
		 = (Declarator)FunctionDefHead_16_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_19_Var
		);
		//19
		final DirectDeclarator DirectDeclarator_20_Var
		 = (DirectDeclarator)Declarator_19_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_20_Var
		);
		Assert.assertEquals("bar", DirectDeclarator_20_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_20_list = DirectDeclarator_20_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_20_list);
		Assert.assertEquals(1, DeclaratorSuffix_20_list.size());
		//20
		final DeclaratorSuffix DeclaratorSuffix_21_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_20_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_21_Var
		);
		//21
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_22_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_21_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_22_Var
		);
		final EList<? extends EObject> ParameterTypeList_22_list = DirectDeclaratorLastSuffix_22_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_22_list);
		Assert.assertEquals(1, ParameterTypeList_22_list.size());
		//22
		final ParameterTypeList ParameterTypeList_23_Var
		 = (ParameterTypeList)ParameterTypeList_22_list.get(0);
		Assert.assertNotNull(ParameterTypeList_23_Var
		);
		//23
		final ParameterList ParameterList_24_Var
		 = (ParameterList)ParameterTypeList_23_Var
		.getList();
		Assert.assertNotNull(ParameterList_24_Var
		);
		final EList<? extends EObject> ParameterDeclaration_24_list = ParameterList_24_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_24_list);
		Assert.assertEquals(1, ParameterDeclaration_24_list.size());
		//24
		final ParameterDeclaration ParameterDeclaration_25_Var
		 = (ParameterDeclaration)ParameterDeclaration_24_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_25_Var
		);
		//25
		final DeclarationSpecifiers DeclarationSpecifiers_26_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_25_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_26_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_26_list = DeclarationSpecifiers_26_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_26_list);
		Assert.assertEquals(1, DeclarationSpecifier_26_list.size());
		//26
		final TypeSpecifier TypeSpecifier_27_Var
		 = (TypeSpecifier)DeclarationSpecifier_26_list.get(0);
		Assert.assertNotNull(TypeSpecifier_27_Var
		);
		//27
		final StructOrUnionSpecifier StructOrUnionSpecifier_28_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_27_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_28_Var
		);
		//28
		final StructOrUnion StructOrUnion_29_Var
		 = (StructOrUnion)StructOrUnionSpecifier_28_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_29_Var
		);
		Assert.assertEquals("struct", StructOrUnion_29_Var
		.getName());
		Assert.assertEquals("foo", StructOrUnionSpecifier_28_Var
		.getId());
		//29
		final Declarator Declarator_30_Var
		 = (Declarator)ParameterDeclaration_25_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_30_Var
		);
		//30
		final DirectDeclarator DirectDeclarator_31_Var
		 = (DirectDeclarator)Declarator_30_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_31_Var
		);
		Assert.assertEquals("foobar", DirectDeclarator_31_Var
		.getId());
		//31
		final FunctionDefinition FunctionDefinition_32_Var
		 = (FunctionDefinition)ExternalDeclaration_15_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_32_Var
		);
		//32
		final BodyStatement BodyStatement_33_Var
		 = (BodyStatement)FunctionDefinition_32_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_33_Var
		);
		final EList<? extends EObject> BlockList_33_list = BodyStatement_33_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_33_list);
		Assert.assertEquals(1, BlockList_33_list.size());
		//33
		final BlockList BlockList_34_Var
		 = (BlockList)BlockList_33_list.get(0);
		Assert.assertNotNull(BlockList_34_Var
		);
		final EList<? extends EObject> Statement_34_list = BlockList_34_Var
		.getStatement();
		Assert.assertNotNull(Statement_34_list);
		Assert.assertEquals(1, Statement_34_list.size());
		//34
		final Statement Statement_35_Var
		 = (Statement)Statement_34_list.get(0);
		Assert.assertNotNull(Statement_35_Var
		);
		//35
		final ExpressionStatement ExpressionStatement_36_Var
		 = (ExpressionStatement)Statement_35_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_36_Var
		);
		//36
		final Expression Expression_37_Var
		 = (Expression)ExpressionStatement_36_Var
		.getExpression();
		Assert.assertNotNull(Expression_37_Var
		);
		final EList<? extends EObject> ExprExpr_37_list = Expression_37_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_37_list);
		Assert.assertEquals(1, ExprExpr_37_list.size());
		//37
		final AssignmentExpression AssignmentExpression_38_Var
		 = (AssignmentExpression)ExprExpr_37_list.get(0);
		Assert.assertNotNull(AssignmentExpression_38_Var
		);
		//38
		final ConditionalExpression ConditionalExpression_39_Var
		 = (ConditionalExpression)AssignmentExpression_38_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_39_Var
		);
		//39
		final LogicalOrExpression LogicalOrExpression_40_Var
		 = (LogicalOrExpression)ConditionalExpression_39_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = LogicalOrExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final LogicalAndExpression LogicalAndExpression_41_Var
		 = (LogicalAndExpression)Expr_40_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = LogicalAndExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final InclusiveOrExpression InclusiveOrExpression_42_Var
		 = (InclusiveOrExpression)Expr_41_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = InclusiveOrExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final ExclusiveOrExpression ExclusiveOrExpression_43_Var
		 = (ExclusiveOrExpression)Expr_42_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = ExclusiveOrExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final AndExpression AndExpression_44_Var
		 = (AndExpression)Expr_43_list.get(0);
		Assert.assertNotNull(AndExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = AndExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final EqualityExpression EqualityExpression_45_Var
		 = (EqualityExpression)Expr_44_list.get(0);
		Assert.assertNotNull(EqualityExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = EqualityExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final RelationalExpression RelationalExpression_46_Var
		 = (RelationalExpression)Expr_45_list.get(0);
		Assert.assertNotNull(RelationalExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = RelationalExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final ShiftExpression ShiftExpression_47_Var
		 = (ShiftExpression)Expr_46_list.get(0);
		Assert.assertNotNull(ShiftExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = ShiftExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final AdditiveExpression AdditiveExpression_48_Var
		 = (AdditiveExpression)Expr_47_list.get(0);
		Assert.assertNotNull(AdditiveExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = AdditiveExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final MultiplicativeExpression MultiplicativeExpression_49_Var
		 = (MultiplicativeExpression)Expr_48_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = MultiplicativeExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final CastExpression CastExpression_50_Var
		 = (CastExpression)Expr_49_list.get(0);
		Assert.assertNotNull(CastExpression_50_Var
		);
		//50
		final UnaryExpression UnaryExpression_51_Var
		 = (UnaryExpression)CastExpression_50_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_51_Var
		);
		//51
		final PostfixExpression PostfixExpression_52_Var
		 = (PostfixExpression)UnaryExpression_51_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = PostfixExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final PrimaryExpression PrimaryExpression_53_Var
		 = (PrimaryExpression)Expr_52_list.get(0);
		Assert.assertNotNull(PrimaryExpression_53_Var
		);
		Assert.assertTrue(PrimaryExpression_53_Var
		.isBuiltin_offsetof());
		//53
		final TypeName TypeName_54_Var
		 = (TypeName)PrimaryExpression_53_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_54_Var
		);
		//54
		final SpecifierQualifierList SpecifierQualifierList_55_Var
		 = (SpecifierQualifierList)TypeName_54_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_55_Var
		);
		final EList<? extends EObject> TypeSpecifier_55_list = SpecifierQualifierList_55_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_55_list);
		Assert.assertEquals(1, TypeSpecifier_55_list.size());
		//55
		final TypeSpecifier TypeSpecifier_56_Var
		 = (TypeSpecifier)TypeSpecifier_55_list.get(0);
		Assert.assertNotNull(TypeSpecifier_56_Var
		);
		//56
		final StructOrUnionSpecifier StructOrUnionSpecifier_57_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_56_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_57_Var
		);
		//57
		final StructOrUnion StructOrUnion_58_Var
		 = (StructOrUnion)StructOrUnionSpecifier_57_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_58_Var
		);
		Assert.assertEquals("struct", StructOrUnion_58_Var
		.getName());
		Assert.assertEquals("foo", StructOrUnionSpecifier_57_Var
		.getId());
		//58
		final UnaryExpression UnaryExpression_59_Var
		 = (UnaryExpression)PrimaryExpression_53_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_59_Var
		);
		//59
		final PostfixExpression PostfixExpression_60_Var
		 = (PostfixExpression)UnaryExpression_59_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = PostfixExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final PrimaryExpression PrimaryExpression_61_Var
		 = (PrimaryExpression)Expr_60_list.get(0);
		Assert.assertNotNull(PrimaryExpression_61_Var
		);
		Assert.assertEquals("i", PrimaryExpression_61_Var
		.getId());
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


