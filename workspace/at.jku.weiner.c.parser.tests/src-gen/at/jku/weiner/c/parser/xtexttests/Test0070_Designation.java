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
import at.jku.weiner.c.parser.parser.StorageClassSpecifier;
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
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
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
import at.jku.weiner.c.parser.parser.Pointer;
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
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitializerList;
import at.jku.weiner.c.parser.parser.Init;
import at.jku.weiner.c.parser.parser.Designation;
import at.jku.weiner.c.parser.parser.DesignatorList;
import at.jku.weiner.c.parser.parser.Designator;
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
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0070_Designation {
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
	
	@Test (timeout=1000)
	public void checkLexerTokens() throws Exception{
		final String text = this.getTextFromFile(
			"res/Test0070_Designation.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_TYPEDEF",
				"RULE_WHITESPACE",
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
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_ID",
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
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_WHITESPACE",
				"RULE_SKW_DOT",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTBRACE",
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
			"res/Test0070_Designation.c");
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
		Assert.assertEquals(2, DeclarationSpecifier_3_list.size());
		//3
		final StorageClassSpecifier StorageClassSpecifier_4_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_4_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_4_Var
		.getName());
		//4
		final TypeSpecifier TypeSpecifier_5_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(1);
		Assert.assertNotNull(TypeSpecifier_5_Var
		);
		//5
		final StructOrUnionSpecifier StructOrUnionSpecifier_6_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_5_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_6_Var
		);
		//6
		final StructOrUnion StructOrUnion_7_Var
		 = (StructOrUnion)StructOrUnionSpecifier_6_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_7_Var
		);
		Assert.assertEquals("struct", StructOrUnion_7_Var
		.getName());
		Assert.assertEquals("foo", StructOrUnionSpecifier_6_Var
		.getId());
		//7
		final StructDeclarationList StructDeclarationList_8_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_6_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_8_Var
		);
		final EList<? extends EObject> StructDeclaration_8_list = StructDeclarationList_8_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_8_list);
		Assert.assertEquals(1, StructDeclaration_8_list.size());
		//8
		final StructDeclaration StructDeclaration_9_Var
		 = (StructDeclaration)StructDeclaration_8_list.get(0);
		Assert.assertNotNull(StructDeclaration_9_Var
		);
		//9
		final SpecifierQualifierList SpecifierQualifierList_10_Var
		 = (SpecifierQualifierList)StructDeclaration_9_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_10_Var
		);
		final EList<? extends EObject> TypeSpecifier_10_list = SpecifierQualifierList_10_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_10_list);
		Assert.assertEquals(1, TypeSpecifier_10_list.size());
		//10
		final TypeSpecifier TypeSpecifier_11_Var
		 = (TypeSpecifier)TypeSpecifier_10_list.get(0);
		Assert.assertNotNull(TypeSpecifier_11_Var
		);
		Assert.assertEquals("int", TypeSpecifier_11_Var
		.getName());
		//11
		final StructDeclaratorList StructDeclaratorList_12_Var
		 = (StructDeclaratorList)StructDeclaration_9_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_12_Var
		);
		final EList<? extends EObject> StructDeclarator_12_list = StructDeclaratorList_12_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_12_list);
		Assert.assertEquals(1, StructDeclarator_12_list.size());
		//12
		final StructDeclarator StructDeclarator_13_Var
		 = (StructDeclarator)StructDeclarator_12_list.get(0);
		Assert.assertNotNull(StructDeclarator_13_Var
		);
		//13
		final Declarator Declarator_14_Var
		 = (Declarator)StructDeclarator_13_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_14_Var
		);
		//14
		final DirectDeclarator DirectDeclarator_15_Var
		 = (DirectDeclarator)Declarator_14_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_15_Var
		);
		Assert.assertEquals("i", DirectDeclarator_15_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_15_list = Declaration_2_Var
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
		Assert.assertEquals("bar", DirectDeclarator_19_Var
		.getId());
		//19
		final ExternalDeclaration ExternalDeclaration_20_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_20_Var
		);
		//20
		final FunctionDefHead FunctionDefHead_21_Var
		 = (FunctionDefHead)ExternalDeclaration_20_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_21_Var
		);
		//21
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_22_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_21_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_22_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_22_list = FunctionDeclarationSpecifiers_22_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_22_list);
		Assert.assertEquals(1, DeclarationSpecifier_22_list.size());
		//22
		final TypeSpecifier TypeSpecifier_23_Var
		 = (TypeSpecifier)DeclarationSpecifier_22_list.get(0);
		Assert.assertNotNull(TypeSpecifier_23_Var
		);
		//23
		final TypedefName TypedefName_24_Var
		 = (TypedefName)TypeSpecifier_23_Var
		.getType();
		Assert.assertNotNull(TypedefName_24_Var
		);
		Assert.assertEquals("bar", TypedefName_24_Var
		.getId());
		//24
		final Declarator Declarator_25_Var
		 = (Declarator)FunctionDefHead_21_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_25_Var
		);
		//25
		final DirectDeclarator DirectDeclarator_26_Var
		 = (DirectDeclarator)Declarator_25_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_26_Var
		);
		Assert.assertEquals("my", DirectDeclarator_26_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_26_list = DirectDeclarator_26_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_26_list);
		Assert.assertEquals(1, DeclaratorSuffix_26_list.size());
		//26
		final DeclaratorSuffix DeclaratorSuffix_27_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_26_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_27_Var
		);
		//27
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_28_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_27_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_28_Var
		);
		final EList<? extends EObject> ParameterTypeList_28_list = DirectDeclaratorLastSuffix_28_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_28_list);
		Assert.assertEquals(1, ParameterTypeList_28_list.size());
		//28
		final ParameterTypeList ParameterTypeList_29_Var
		 = (ParameterTypeList)ParameterTypeList_28_list.get(0);
		Assert.assertNotNull(ParameterTypeList_29_Var
		);
		//29
		final ParameterList ParameterList_30_Var
		 = (ParameterList)ParameterTypeList_29_Var
		.getList();
		Assert.assertNotNull(ParameterList_30_Var
		);
		final EList<? extends EObject> ParameterDeclaration_30_list = ParameterList_30_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_30_list);
		Assert.assertEquals(1, ParameterDeclaration_30_list.size());
		//30
		final ParameterDeclaration ParameterDeclaration_31_Var
		 = (ParameterDeclaration)ParameterDeclaration_30_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_31_Var
		);
		//31
		final DeclarationSpecifiers DeclarationSpecifiers_32_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_31_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_32_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_32_list = DeclarationSpecifiers_32_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_32_list);
		Assert.assertEquals(1, DeclarationSpecifier_32_list.size());
		//32
		final TypeSpecifier TypeSpecifier_33_Var
		 = (TypeSpecifier)DeclarationSpecifier_32_list.get(0);
		Assert.assertNotNull(TypeSpecifier_33_Var
		);
		Assert.assertEquals("int", TypeSpecifier_33_Var
		.getName());
		//33
		final Declarator Declarator_34_Var
		 = (Declarator)ParameterDeclaration_31_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_34_Var
		);
		//34
		final DirectDeclarator DirectDeclarator_35_Var
		 = (DirectDeclarator)Declarator_34_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_35_Var
		);
		Assert.assertEquals("arg", DirectDeclarator_35_Var
		.getId());
		//35
		final Pointer Pointer_36_Var
		 = (Pointer)Declarator_34_Var
		.getPointer();
		Assert.assertNotNull(Pointer_36_Var
		);
		Assert.assertTrue(Pointer_36_Var
		.getStar().isEmpty());
		//36
		final FunctionDefinition FunctionDefinition_37_Var
		 = (FunctionDefinition)ExternalDeclaration_20_Var
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
		Assert.assertTrue(BlockList_39_Var
		.getDeclaration().isEmpty());
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
		Assert.assertFalse(PostfixExpression_57_Var
		.isExt());
		//57
		final TypeName TypeName_58_Var
		 = (TypeName)PostfixExpression_57_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_58_Var
		);
		//58
		final SpecifierQualifierList SpecifierQualifierList_59_Var
		 = (SpecifierQualifierList)TypeName_58_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_59_Var
		);
		final EList<? extends EObject> TypeSpecifier_59_list = SpecifierQualifierList_59_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_59_list);
		Assert.assertEquals(1, TypeSpecifier_59_list.size());
		//59
		final TypeSpecifier TypeSpecifier_60_Var
		 = (TypeSpecifier)TypeSpecifier_59_list.get(0);
		Assert.assertNotNull(TypeSpecifier_60_Var
		);
		//60
		final TypedefName TypedefName_61_Var
		 = (TypedefName)TypeSpecifier_60_Var
		.getType();
		Assert.assertNotNull(TypedefName_61_Var
		);
		Assert.assertEquals("bar", TypedefName_61_Var
		.getId());
		//61
		final InitializerList InitializerList_62_Var
		 = (InitializerList)PostfixExpression_57_Var
		.getInitializerList();
		Assert.assertNotNull(InitializerList_62_Var
		);
		final EList<? extends EObject> Init_62_list = InitializerList_62_Var
		.getInit();
		Assert.assertNotNull(Init_62_list);
		Assert.assertEquals(1, Init_62_list.size());
		//62
		final Init Init_63_Var
		 = (Init)Init_62_list.get(0);
		Assert.assertNotNull(Init_63_Var
		);
		//63
		final Designation Designation_64_Var
		 = (Designation)Init_63_Var
		.getDesignation();
		Assert.assertNotNull(Designation_64_Var
		);
		//64
		final DesignatorList DesignatorList_65_Var
		 = (DesignatorList)Designation_64_Var
		.getList();
		Assert.assertNotNull(DesignatorList_65_Var
		);
		final EList<? extends EObject> Designator_65_list = DesignatorList_65_Var
		.getDesignator();
		Assert.assertNotNull(Designator_65_list);
		Assert.assertEquals(1, Designator_65_list.size());
		//65
		final Designator Designator_66_Var
		 = (Designator)Designator_65_list.get(0);
		Assert.assertNotNull(Designator_66_Var
		);
		Assert.assertEquals("i", Designator_66_Var
		.getId());
		//66
		final Initializer Initializer_67_Var
		 = (Initializer)Init_63_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_67_Var
		);
		//67
		final AssignmentExpression AssignmentExpression_68_Var
		 = (AssignmentExpression)Initializer_67_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_68_Var
		);
		//68
		final ConditionalExpression ConditionalExpression_69_Var
		 = (ConditionalExpression)AssignmentExpression_68_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_69_Var
		);
		//69
		final LogicalOrExpression LogicalOrExpression_70_Var
		 = (LogicalOrExpression)ConditionalExpression_69_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = LogicalOrExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final LogicalAndExpression LogicalAndExpression_71_Var
		 = (LogicalAndExpression)Expr_70_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = LogicalAndExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final InclusiveOrExpression InclusiveOrExpression_72_Var
		 = (InclusiveOrExpression)Expr_71_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = InclusiveOrExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final ExclusiveOrExpression ExclusiveOrExpression_73_Var
		 = (ExclusiveOrExpression)Expr_72_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = ExclusiveOrExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final AndExpression AndExpression_74_Var
		 = (AndExpression)Expr_73_list.get(0);
		Assert.assertNotNull(AndExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = AndExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final EqualityExpression EqualityExpression_75_Var
		 = (EqualityExpression)Expr_74_list.get(0);
		Assert.assertNotNull(EqualityExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = EqualityExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final RelationalExpression RelationalExpression_76_Var
		 = (RelationalExpression)Expr_75_list.get(0);
		Assert.assertNotNull(RelationalExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = RelationalExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final ShiftExpression ShiftExpression_77_Var
		 = (ShiftExpression)Expr_76_list.get(0);
		Assert.assertNotNull(ShiftExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = ShiftExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final AdditiveExpression AdditiveExpression_78_Var
		 = (AdditiveExpression)Expr_77_list.get(0);
		Assert.assertNotNull(AdditiveExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = AdditiveExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final MultiplicativeExpression MultiplicativeExpression_79_Var
		 = (MultiplicativeExpression)Expr_78_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = MultiplicativeExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final CastExpression CastExpression_80_Var
		 = (CastExpression)Expr_79_list.get(0);
		Assert.assertNotNull(CastExpression_80_Var
		);
		//80
		final UnaryExpression UnaryExpression_81_Var
		 = (UnaryExpression)CastExpression_80_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_81_Var
		);
		//81
		final PostfixExpression PostfixExpression_82_Var
		 = (PostfixExpression)UnaryExpression_81_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = PostfixExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final PrimaryExpression PrimaryExpression_83_Var
		 = (PrimaryExpression)Expr_82_list.get(0);
		Assert.assertNotNull(PrimaryExpression_83_Var
		);
		Assert.assertEquals("arg", PrimaryExpression_83_Var
		.getId());
		Assert.assertEquals("return", JumpStatement_41_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_41_Var
		.getSemi());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0070_Designation.c");
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
				method.invoke(this.generator, "Test0070_Designation.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0070_Designation.c");
		final String expected = this.getTextFromFile(
			"res/Test0070_Designation.c"
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


