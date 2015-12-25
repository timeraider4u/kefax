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
import at.jku.weiner.c.parser.parser.IterationStatement;
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
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.parser.parser.CompoundStatement;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0028_ForWithDec {
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
	
	@Test
	public void checkLexerTokens() throws Exception{
		final String text = this.getTextFromFile(
			"res/Test0028_ForWithDec.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_VOID", 
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
				"RULE_KW_FOR", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_ASSIGN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LESS", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_PLUSPLUS", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_CONTINUE", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_SKW_RIGHTBRACE", 
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
			"res/Test0028_ForWithDec.c");
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
		Assert.assertEquals(1, External_0_list.size());
		//0
		final ExternalDeclaration ExternalDeclaration_1_Var
		 = (ExternalDeclaration)External_0_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_1_Var
		);
		//1
		final FunctionDefHead FunctionDefHead_2_Var
		 = (FunctionDefHead)ExternalDeclaration_1_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_2_Var
		);
		//2
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_3_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_2_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_3_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_3_list = FunctionDeclarationSpecifiers_3_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_3_list);
		Assert.assertEquals(1, DeclarationSpecifier_3_list.size());
		//3
		final TypeSpecifier TypeSpecifier_4_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(TypeSpecifier_4_Var
		);
		Assert.assertEquals("void", TypeSpecifier_4_Var
		.getName());
		//4
		final Declarator Declarator_5_Var
		 = (Declarator)FunctionDefHead_2_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_5_Var
		);
		//5
		final DirectDeclarator DirectDeclarator_6_Var
		 = (DirectDeclarator)Declarator_5_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_6_Var
		);
		Assert.assertEquals("a", DirectDeclarator_6_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_6_list = DirectDeclarator_6_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_6_list);
		Assert.assertEquals(1, DeclaratorSuffix_6_list.size());
		//6
		final DeclaratorSuffix DeclaratorSuffix_7_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_6_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_7_Var
		);
		//7
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_8_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_7_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_8_Var
		);
		final EList<? extends EObject> ParameterTypeList_8_list = DirectDeclaratorLastSuffix_8_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_8_list);
		Assert.assertEquals(1, ParameterTypeList_8_list.size());
		//8
		final ParameterTypeList ParameterTypeList_9_Var
		 = (ParameterTypeList)ParameterTypeList_8_list.get(0);
		Assert.assertNotNull(ParameterTypeList_9_Var
		);
		//9
		final ParameterList ParameterList_10_Var
		 = (ParameterList)ParameterTypeList_9_Var
		.getList();
		Assert.assertNotNull(ParameterList_10_Var
		);
		final EList<? extends EObject> ParameterDeclaration_10_list = ParameterList_10_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_10_list);
		Assert.assertEquals(1, ParameterDeclaration_10_list.size());
		//10
		final ParameterDeclaration ParameterDeclaration_11_Var
		 = (ParameterDeclaration)ParameterDeclaration_10_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_11_Var
		);
		//11
		final DeclarationSpecifiers DeclarationSpecifiers_12_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_11_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_12_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_12_list = DeclarationSpecifiers_12_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_12_list);
		Assert.assertEquals(1, DeclarationSpecifier_12_list.size());
		//12
		final TypeSpecifier TypeSpecifier_13_Var
		 = (TypeSpecifier)DeclarationSpecifier_12_list.get(0);
		Assert.assertNotNull(TypeSpecifier_13_Var
		);
		Assert.assertEquals("int", TypeSpecifier_13_Var
		.getName());
		//13
		final Declarator Declarator_14_Var
		 = (Declarator)ParameterDeclaration_11_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_14_Var
		);
		//14
		final DirectDeclarator DirectDeclarator_15_Var
		 = (DirectDeclarator)Declarator_14_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_15_Var
		);
		Assert.assertEquals("num", DirectDeclarator_15_Var
		.getId());
		//15
		final FunctionDefinition FunctionDefinition_16_Var
		 = (FunctionDefinition)ExternalDeclaration_1_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_16_Var
		);
		//16
		final BodyStatement BodyStatement_17_Var
		 = (BodyStatement)FunctionDefinition_16_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_17_Var
		);
		final EList<? extends EObject> BlockList_17_list = BodyStatement_17_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_17_list);
		Assert.assertEquals(1, BlockList_17_list.size());
		//17
		final BlockList BlockList_18_Var
		 = (BlockList)BlockList_17_list.get(0);
		Assert.assertNotNull(BlockList_18_Var
		);
		final EList<? extends EObject> Statement_18_list = BlockList_18_Var
		.getStatement();
		Assert.assertNotNull(Statement_18_list);
		Assert.assertEquals(1, Statement_18_list.size());
		//18
		final Statement Statement_19_Var
		 = (Statement)Statement_18_list.get(0);
		Assert.assertNotNull(Statement_19_Var
		);
		//19
		final IterationStatement IterationStatement_20_Var
		 = (IterationStatement)Statement_19_Var
		.getStmt();
		Assert.assertNotNull(IterationStatement_20_Var
		);
		Assert.assertEquals("for", IterationStatement_20_Var
		.getFor());
		//20
		final Declaration Declaration_21_Var
		 = (Declaration)IterationStatement_20_Var
		.getInitDecl();
		Assert.assertNotNull(Declaration_21_Var
		);
		//21
		final DeclarationSpecifiers DeclarationSpecifiers_22_Var
		 = (DeclarationSpecifiers)Declaration_21_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_22_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_22_list = DeclarationSpecifiers_22_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_22_list);
		Assert.assertEquals(1, DeclarationSpecifier_22_list.size());
		//22
		final TypeSpecifier TypeSpecifier_23_Var
		 = (TypeSpecifier)DeclarationSpecifier_22_list.get(0);
		Assert.assertNotNull(TypeSpecifier_23_Var
		);
		Assert.assertEquals("int", TypeSpecifier_23_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_23_list = Declaration_21_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_23_list);
		Assert.assertEquals(1, InitDeclaratorList_23_list.size());
		//23
		final InitDeclaratorList InitDeclaratorList_24_Var
		 = (InitDeclaratorList)InitDeclaratorList_23_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_24_Var
		);
		final EList<? extends EObject> InitDeclarator_24_list = InitDeclaratorList_24_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_24_list);
		Assert.assertEquals(1, InitDeclarator_24_list.size());
		//24
		final InitDeclarator InitDeclarator_25_Var
		 = (InitDeclarator)InitDeclarator_24_list.get(0);
		Assert.assertNotNull(InitDeclarator_25_Var
		);
		//25
		final Declarator Declarator_26_Var
		 = (Declarator)InitDeclarator_25_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_26_Var
		);
		//26
		final DirectDeclarator DirectDeclarator_27_Var
		 = (DirectDeclarator)Declarator_26_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_27_Var
		);
		Assert.assertEquals("i", DirectDeclarator_27_Var
		.getId());
		//27
		final Initializer Initializer_28_Var
		 = (Initializer)InitDeclarator_25_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_28_Var
		);
		//28
		final AssignmentExpression AssignmentExpression_29_Var
		 = (AssignmentExpression)Initializer_28_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_29_Var
		);
		//29
		final ConditionalExpression ConditionalExpression_30_Var
		 = (ConditionalExpression)AssignmentExpression_29_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_30_Var
		);
		//30
		final LogicalOrExpression LogicalOrExpression_31_Var
		 = (LogicalOrExpression)ConditionalExpression_30_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = LogicalOrExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final LogicalAndExpression LogicalAndExpression_32_Var
		 = (LogicalAndExpression)Expr_31_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = LogicalAndExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final InclusiveOrExpression InclusiveOrExpression_33_Var
		 = (InclusiveOrExpression)Expr_32_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = InclusiveOrExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final ExclusiveOrExpression ExclusiveOrExpression_34_Var
		 = (ExclusiveOrExpression)Expr_33_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = ExclusiveOrExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final AndExpression AndExpression_35_Var
		 = (AndExpression)Expr_34_list.get(0);
		Assert.assertNotNull(AndExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = AndExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final EqualityExpression EqualityExpression_36_Var
		 = (EqualityExpression)Expr_35_list.get(0);
		Assert.assertNotNull(EqualityExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = EqualityExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final RelationalExpression RelationalExpression_37_Var
		 = (RelationalExpression)Expr_36_list.get(0);
		Assert.assertNotNull(RelationalExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = RelationalExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final ShiftExpression ShiftExpression_38_Var
		 = (ShiftExpression)Expr_37_list.get(0);
		Assert.assertNotNull(ShiftExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = ShiftExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final AdditiveExpression AdditiveExpression_39_Var
		 = (AdditiveExpression)Expr_38_list.get(0);
		Assert.assertNotNull(AdditiveExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = AdditiveExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final MultiplicativeExpression MultiplicativeExpression_40_Var
		 = (MultiplicativeExpression)Expr_39_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = MultiplicativeExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final CastExpression CastExpression_41_Var
		 = (CastExpression)Expr_40_list.get(0);
		Assert.assertNotNull(CastExpression_41_Var
		);
		//41
		final UnaryExpression UnaryExpression_42_Var
		 = (UnaryExpression)CastExpression_41_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_42_Var
		);
		//42
		final PostfixExpression PostfixExpression_43_Var
		 = (PostfixExpression)UnaryExpression_42_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = PostfixExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final PrimaryExpression PrimaryExpression_44_Var
		 = (PrimaryExpression)Expr_43_list.get(0);
		Assert.assertNotNull(PrimaryExpression_44_Var
		);
		//44
		final Constant2 Constant2_45_Var
		 = (Constant2)PrimaryExpression_44_Var
		.getConst();
		Assert.assertNotNull(Constant2_45_Var
		);
		Assert.assertEquals("0", Constant2_45_Var
		.getDec());
		Assert.assertEquals(";", Declaration_21_Var
		.getSemi());
		//45
		final Expression Expression_46_Var
		 = (Expression)IterationStatement_20_Var
		.getExpr();
		Assert.assertNotNull(Expression_46_Var
		);
		final EList<? extends EObject> ExprExpr_46_list = Expression_46_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_46_list);
		Assert.assertEquals(1, ExprExpr_46_list.size());
		//46
		final AssignmentExpression AssignmentExpression_47_Var
		 = (AssignmentExpression)ExprExpr_46_list.get(0);
		Assert.assertNotNull(AssignmentExpression_47_Var
		);
		//47
		final ConditionalExpression ConditionalExpression_48_Var
		 = (ConditionalExpression)AssignmentExpression_47_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_48_Var
		);
		//48
		final LogicalOrExpression LogicalOrExpression_49_Var
		 = (LogicalOrExpression)ConditionalExpression_48_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = LogicalOrExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final LogicalAndExpression LogicalAndExpression_50_Var
		 = (LogicalAndExpression)Expr_49_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = LogicalAndExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final InclusiveOrExpression InclusiveOrExpression_51_Var
		 = (InclusiveOrExpression)Expr_50_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = InclusiveOrExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final ExclusiveOrExpression ExclusiveOrExpression_52_Var
		 = (ExclusiveOrExpression)Expr_51_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = ExclusiveOrExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final AndExpression AndExpression_53_Var
		 = (AndExpression)Expr_52_list.get(0);
		Assert.assertNotNull(AndExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = AndExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final EqualityExpression EqualityExpression_54_Var
		 = (EqualityExpression)Expr_53_list.get(0);
		Assert.assertNotNull(EqualityExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = EqualityExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final RelationalExpression RelationalExpression_55_Var
		 = (RelationalExpression)Expr_54_list.get(0);
		Assert.assertNotNull(RelationalExpression_55_Var
		);
		Assert.assertEquals("[<]", RelationalExpression_55_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_55_list = RelationalExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(2, Expr_55_list.size());
		//55
		final ShiftExpression ShiftExpression_56_Var
		 = (ShiftExpression)Expr_55_list.get(0);
		Assert.assertNotNull(ShiftExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = ShiftExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final AdditiveExpression AdditiveExpression_57_Var
		 = (AdditiveExpression)Expr_56_list.get(0);
		Assert.assertNotNull(AdditiveExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = AdditiveExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final MultiplicativeExpression MultiplicativeExpression_58_Var
		 = (MultiplicativeExpression)Expr_57_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = MultiplicativeExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final CastExpression CastExpression_59_Var
		 = (CastExpression)Expr_58_list.get(0);
		Assert.assertNotNull(CastExpression_59_Var
		);
		//59
		final UnaryExpression UnaryExpression_60_Var
		 = (UnaryExpression)CastExpression_59_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_60_Var
		);
		//60
		final PostfixExpression PostfixExpression_61_Var
		 = (PostfixExpression)UnaryExpression_60_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = PostfixExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final PrimaryExpression PrimaryExpression_62_Var
		 = (PrimaryExpression)Expr_61_list.get(0);
		Assert.assertNotNull(PrimaryExpression_62_Var
		);
		Assert.assertEquals("i", PrimaryExpression_62_Var
		.getId());
		//62
		final ShiftExpression ShiftExpression_63_Var
		 = (ShiftExpression)Expr_55_list.get(1);
		Assert.assertNotNull(ShiftExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = ShiftExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final AdditiveExpression AdditiveExpression_64_Var
		 = (AdditiveExpression)Expr_63_list.get(0);
		Assert.assertNotNull(AdditiveExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = AdditiveExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final MultiplicativeExpression MultiplicativeExpression_65_Var
		 = (MultiplicativeExpression)Expr_64_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = MultiplicativeExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final CastExpression CastExpression_66_Var
		 = (CastExpression)Expr_65_list.get(0);
		Assert.assertNotNull(CastExpression_66_Var
		);
		//66
		final UnaryExpression UnaryExpression_67_Var
		 = (UnaryExpression)CastExpression_66_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_67_Var
		);
		//67
		final PostfixExpression PostfixExpression_68_Var
		 = (PostfixExpression)UnaryExpression_67_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = PostfixExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final PrimaryExpression PrimaryExpression_69_Var
		 = (PrimaryExpression)Expr_68_list.get(0);
		Assert.assertNotNull(PrimaryExpression_69_Var
		);
		//69
		final Constant2 Constant2_70_Var
		 = (Constant2)PrimaryExpression_69_Var
		.getConst();
		Assert.assertNotNull(Constant2_70_Var
		);
		Assert.assertEquals("5", Constant2_70_Var
		.getDec());
		//70
		final Expression Expression_71_Var
		 = (Expression)IterationStatement_20_Var
		.getIncExpr();
		Assert.assertNotNull(Expression_71_Var
		);
		final EList<? extends EObject> ExprExpr_71_list = Expression_71_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_71_list);
		Assert.assertEquals(1, ExprExpr_71_list.size());
		//71
		final AssignmentExpression AssignmentExpression_72_Var
		 = (AssignmentExpression)ExprExpr_71_list.get(0);
		Assert.assertNotNull(AssignmentExpression_72_Var
		);
		//72
		final ConditionalExpression ConditionalExpression_73_Var
		 = (ConditionalExpression)AssignmentExpression_72_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_73_Var
		);
		//73
		final LogicalOrExpression LogicalOrExpression_74_Var
		 = (LogicalOrExpression)ConditionalExpression_73_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = LogicalOrExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final LogicalAndExpression LogicalAndExpression_75_Var
		 = (LogicalAndExpression)Expr_74_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = LogicalAndExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final InclusiveOrExpression InclusiveOrExpression_76_Var
		 = (InclusiveOrExpression)Expr_75_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = InclusiveOrExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final ExclusiveOrExpression ExclusiveOrExpression_77_Var
		 = (ExclusiveOrExpression)Expr_76_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = ExclusiveOrExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final AndExpression AndExpression_78_Var
		 = (AndExpression)Expr_77_list.get(0);
		Assert.assertNotNull(AndExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = AndExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final EqualityExpression EqualityExpression_79_Var
		 = (EqualityExpression)Expr_78_list.get(0);
		Assert.assertNotNull(EqualityExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = EqualityExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final RelationalExpression RelationalExpression_80_Var
		 = (RelationalExpression)Expr_79_list.get(0);
		Assert.assertNotNull(RelationalExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = RelationalExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final ShiftExpression ShiftExpression_81_Var
		 = (ShiftExpression)Expr_80_list.get(0);
		Assert.assertNotNull(ShiftExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = ShiftExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final AdditiveExpression AdditiveExpression_82_Var
		 = (AdditiveExpression)Expr_81_list.get(0);
		Assert.assertNotNull(AdditiveExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = AdditiveExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final MultiplicativeExpression MultiplicativeExpression_83_Var
		 = (MultiplicativeExpression)Expr_82_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = MultiplicativeExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final CastExpression CastExpression_84_Var
		 = (CastExpression)Expr_83_list.get(0);
		Assert.assertNotNull(CastExpression_84_Var
		);
		//84
		final UnaryExpression UnaryExpression_85_Var
		 = (UnaryExpression)CastExpression_84_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_85_Var
		);
		//85
		final PostfixExpression PostfixExpression_86_Var
		 = (PostfixExpression)UnaryExpression_85_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = PostfixExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final PrimaryExpression PrimaryExpression_87_Var
		 = (PrimaryExpression)Expr_86_list.get(0);
		Assert.assertNotNull(PrimaryExpression_87_Var
		);
		Assert.assertEquals("i", PrimaryExpression_87_Var
		.getId());
		final EList<? extends EObject> Suffix_87_list = PostfixExpression_86_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_87_list);
		Assert.assertEquals(1, Suffix_87_list.size());
		//87
		final PostfixExpressionSuffixPlusPlus PostfixExpressionSuffixPlusPlus_88_Var
		 = (PostfixExpressionSuffixPlusPlus)Suffix_87_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixPlusPlus_88_Var
		);
		//88
		final Statement Statement_89_Var
		 = (Statement)IterationStatement_20_Var
		.getStatement();
		Assert.assertNotNull(Statement_89_Var
		);
		//89
		final CompoundStatement CompoundStatement_90_Var
		 = (CompoundStatement)Statement_89_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_90_Var
		);
		//90
		final BodyStatement BodyStatement_91_Var
		 = (BodyStatement)CompoundStatement_90_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_91_Var
		);
		final EList<? extends EObject> BlockList_91_list = BodyStatement_91_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_91_list);
		Assert.assertEquals(1, BlockList_91_list.size());
		//91
		final BlockList BlockList_92_Var
		 = (BlockList)BlockList_91_list.get(0);
		Assert.assertNotNull(BlockList_92_Var
		);
		final EList<? extends EObject> Statement_92_list = BlockList_92_Var
		.getStatement();
		Assert.assertNotNull(Statement_92_list);
		Assert.assertEquals(1, Statement_92_list.size());
		//92
		final Statement Statement_93_Var
		 = (Statement)Statement_92_list.get(0);
		Assert.assertNotNull(Statement_93_Var
		);
		//93
		final JumpStatement JumpStatement_94_Var
		 = (JumpStatement)Statement_93_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_94_Var
		);
		Assert.assertEquals("continue", JumpStatement_94_Var
		.getContinue());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0028_ForWithDec.c");
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
				method.invoke(this.generator, "Test0028_ForWithDec.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0028_ForWithDec.c");
		final String expected = this.getTextFromFile(
			"res/Test0028_ForWithDec.c"
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


