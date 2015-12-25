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
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
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
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.AssignmentOperator;
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
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.AssignmentOperator;
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
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0014_AssignExpr {
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
			"res/Test0014_AssignExpr.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_VOID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
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
			"res/Test0014_AssignExpr.c");
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
		Assert.assertEquals("void", TypeSpecifier_6_Var
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
		Assert.assertEquals("doSomething", DirectDeclarator_8_Var
		.getId());
		//8
		final FunctionDefinition FunctionDefinition_9_Var
		 = (FunctionDefinition)ExternalDeclaration_3_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_9_Var
		);
		//9
		final BodyStatement BodyStatement_10_Var
		 = (BodyStatement)FunctionDefinition_9_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_10_Var
		);
		final EList<? extends EObject> BlockList_10_list = BodyStatement_10_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_10_list);
		Assert.assertEquals(1, BlockList_10_list.size());
		//10
		final BlockList BlockList_11_Var
		 = (BlockList)BlockList_10_list.get(0);
		Assert.assertNotNull(BlockList_11_Var
		);
		final EList<? extends EObject> Declaration_11_list = BlockList_11_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_11_list);
		Assert.assertEquals(2, Declaration_11_list.size());
		//11
		final Declaration Declaration_12_Var
		 = (Declaration)Declaration_11_list.get(0);
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
		Assert.assertEquals(1, DeclarationSpecifier_13_list.size());
		//13
		final TypeSpecifier TypeSpecifier_14_Var
		 = (TypeSpecifier)DeclarationSpecifier_13_list.get(0);
		Assert.assertNotNull(TypeSpecifier_14_Var
		);
		Assert.assertEquals("int", TypeSpecifier_14_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_14_list = Declaration_12_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_14_list);
		Assert.assertEquals(1, InitDeclaratorList_14_list.size());
		//14
		final InitDeclaratorList InitDeclaratorList_15_Var
		 = (InitDeclaratorList)InitDeclaratorList_14_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_15_Var
		);
		final EList<? extends EObject> InitDeclarator_15_list = InitDeclaratorList_15_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_15_list);
		Assert.assertEquals(1, InitDeclarator_15_list.size());
		//15
		final InitDeclarator InitDeclarator_16_Var
		 = (InitDeclarator)InitDeclarator_15_list.get(0);
		Assert.assertNotNull(InitDeclarator_16_Var
		);
		//16
		final Declarator Declarator_17_Var
		 = (Declarator)InitDeclarator_16_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_17_Var
		);
		//17
		final DirectDeclarator DirectDeclarator_18_Var
		 = (DirectDeclarator)Declarator_17_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_18_Var
		);
		Assert.assertEquals("a", DirectDeclarator_18_Var
		.getId());
		//18
		final Initializer Initializer_19_Var
		 = (Initializer)InitDeclarator_16_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_19_Var
		);
		//19
		final AssignmentExpression AssignmentExpression_20_Var
		 = (AssignmentExpression)Initializer_19_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_20_Var
		);
		//20
		final ConditionalExpression ConditionalExpression_21_Var
		 = (ConditionalExpression)AssignmentExpression_20_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_21_Var
		);
		//21
		final LogicalOrExpression LogicalOrExpression_22_Var
		 = (LogicalOrExpression)ConditionalExpression_21_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = LogicalOrExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final LogicalAndExpression LogicalAndExpression_23_Var
		 = (LogicalAndExpression)Expr_22_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = LogicalAndExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final InclusiveOrExpression InclusiveOrExpression_24_Var
		 = (InclusiveOrExpression)Expr_23_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = InclusiveOrExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final ExclusiveOrExpression ExclusiveOrExpression_25_Var
		 = (ExclusiveOrExpression)Expr_24_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = ExclusiveOrExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final AndExpression AndExpression_26_Var
		 = (AndExpression)Expr_25_list.get(0);
		Assert.assertNotNull(AndExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = AndExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final EqualityExpression EqualityExpression_27_Var
		 = (EqualityExpression)Expr_26_list.get(0);
		Assert.assertNotNull(EqualityExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = EqualityExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final RelationalExpression RelationalExpression_28_Var
		 = (RelationalExpression)Expr_27_list.get(0);
		Assert.assertNotNull(RelationalExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = RelationalExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final ShiftExpression ShiftExpression_29_Var
		 = (ShiftExpression)Expr_28_list.get(0);
		Assert.assertNotNull(ShiftExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = ShiftExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final AdditiveExpression AdditiveExpression_30_Var
		 = (AdditiveExpression)Expr_29_list.get(0);
		Assert.assertNotNull(AdditiveExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = AdditiveExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final MultiplicativeExpression MultiplicativeExpression_31_Var
		 = (MultiplicativeExpression)Expr_30_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = MultiplicativeExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final CastExpression CastExpression_32_Var
		 = (CastExpression)Expr_31_list.get(0);
		Assert.assertNotNull(CastExpression_32_Var
		);
		//32
		final UnaryExpression UnaryExpression_33_Var
		 = (UnaryExpression)CastExpression_32_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_33_Var
		);
		//33
		final PostfixExpression PostfixExpression_34_Var
		 = (PostfixExpression)UnaryExpression_33_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = PostfixExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final PrimaryExpression PrimaryExpression_35_Var
		 = (PrimaryExpression)Expr_34_list.get(0);
		Assert.assertNotNull(PrimaryExpression_35_Var
		);
		//35
		final Constant2 Constant2_36_Var
		 = (Constant2)PrimaryExpression_35_Var
		.getConst();
		Assert.assertNotNull(Constant2_36_Var
		);
		Assert.assertEquals("0", Constant2_36_Var
		.getDec());
		//36
		final Declaration Declaration_37_Var
		 = (Declaration)Declaration_11_list.get(1);
		Assert.assertNotNull(Declaration_37_Var
		);
		//37
		final DeclarationSpecifiers DeclarationSpecifiers_38_Var
		 = (DeclarationSpecifiers)Declaration_37_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_38_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_38_list = DeclarationSpecifiers_38_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_38_list);
		Assert.assertEquals(1, DeclarationSpecifier_38_list.size());
		//38
		final TypeSpecifier TypeSpecifier_39_Var
		 = (TypeSpecifier)DeclarationSpecifier_38_list.get(0);
		Assert.assertNotNull(TypeSpecifier_39_Var
		);
		Assert.assertEquals("int", TypeSpecifier_39_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_39_list = Declaration_37_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_39_list);
		Assert.assertEquals(1, InitDeclaratorList_39_list.size());
		//39
		final InitDeclaratorList InitDeclaratorList_40_Var
		 = (InitDeclaratorList)InitDeclaratorList_39_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_40_Var
		);
		final EList<? extends EObject> InitDeclarator_40_list = InitDeclaratorList_40_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_40_list);
		Assert.assertEquals(1, InitDeclarator_40_list.size());
		//40
		final InitDeclarator InitDeclarator_41_Var
		 = (InitDeclarator)InitDeclarator_40_list.get(0);
		Assert.assertNotNull(InitDeclarator_41_Var
		);
		//41
		final Declarator Declarator_42_Var
		 = (Declarator)InitDeclarator_41_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_42_Var
		);
		//42
		final DirectDeclarator DirectDeclarator_43_Var
		 = (DirectDeclarator)Declarator_42_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_43_Var
		);
		Assert.assertEquals("b", DirectDeclarator_43_Var
		.getId());
		//43
		final Initializer Initializer_44_Var
		 = (Initializer)InitDeclarator_41_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_44_Var
		);
		//44
		final AssignmentExpression AssignmentExpression_45_Var
		 = (AssignmentExpression)Initializer_44_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_45_Var
		);
		//45
		final ConditionalExpression ConditionalExpression_46_Var
		 = (ConditionalExpression)AssignmentExpression_45_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_46_Var
		);
		//46
		final LogicalOrExpression LogicalOrExpression_47_Var
		 = (LogicalOrExpression)ConditionalExpression_46_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = LogicalOrExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final LogicalAndExpression LogicalAndExpression_48_Var
		 = (LogicalAndExpression)Expr_47_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = LogicalAndExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final InclusiveOrExpression InclusiveOrExpression_49_Var
		 = (InclusiveOrExpression)Expr_48_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = InclusiveOrExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final ExclusiveOrExpression ExclusiveOrExpression_50_Var
		 = (ExclusiveOrExpression)Expr_49_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = ExclusiveOrExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final AndExpression AndExpression_51_Var
		 = (AndExpression)Expr_50_list.get(0);
		Assert.assertNotNull(AndExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = AndExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final EqualityExpression EqualityExpression_52_Var
		 = (EqualityExpression)Expr_51_list.get(0);
		Assert.assertNotNull(EqualityExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = EqualityExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final RelationalExpression RelationalExpression_53_Var
		 = (RelationalExpression)Expr_52_list.get(0);
		Assert.assertNotNull(RelationalExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = RelationalExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final ShiftExpression ShiftExpression_54_Var
		 = (ShiftExpression)Expr_53_list.get(0);
		Assert.assertNotNull(ShiftExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = ShiftExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final AdditiveExpression AdditiveExpression_55_Var
		 = (AdditiveExpression)Expr_54_list.get(0);
		Assert.assertNotNull(AdditiveExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = AdditiveExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final MultiplicativeExpression MultiplicativeExpression_56_Var
		 = (MultiplicativeExpression)Expr_55_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = MultiplicativeExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final CastExpression CastExpression_57_Var
		 = (CastExpression)Expr_56_list.get(0);
		Assert.assertNotNull(CastExpression_57_Var
		);
		//57
		final UnaryExpression UnaryExpression_58_Var
		 = (UnaryExpression)CastExpression_57_Var
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
		//60
		final Constant2 Constant2_61_Var
		 = (Constant2)PrimaryExpression_60_Var
		.getConst();
		Assert.assertNotNull(Constant2_61_Var
		);
		Assert.assertEquals("2", Constant2_61_Var
		.getDec());
		final EList<? extends EObject> Statement_61_list = BlockList_11_Var
		.getStatement();
		Assert.assertNotNull(Statement_61_list);
		Assert.assertEquals(1, Statement_61_list.size());
		//61
		final Statement Statement_62_Var
		 = (Statement)Statement_61_list.get(0);
		Assert.assertNotNull(Statement_62_Var
		);
		//62
		final ExpressionStatement ExpressionStatement_63_Var
		 = (ExpressionStatement)Statement_62_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_63_Var
		);
		//63
		final Expression Expression_64_Var
		 = (Expression)ExpressionStatement_63_Var
		.getExpression();
		Assert.assertNotNull(Expression_64_Var
		);
		final EList<? extends EObject> ExprExpr_64_list = Expression_64_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_64_list);
		Assert.assertEquals(2, ExprExpr_64_list.size());
		//64
		final AssignmentExpression AssignmentExpression_65_Var
		 = (AssignmentExpression)ExprExpr_64_list.get(0);
		Assert.assertNotNull(AssignmentExpression_65_Var
		);
		//65
		final UnaryExpression UnaryExpression_66_Var
		 = (UnaryExpression)AssignmentExpression_65_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_66_Var
		);
		//66
		final PostfixExpression PostfixExpression_67_Var
		 = (PostfixExpression)UnaryExpression_66_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = PostfixExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final PrimaryExpression PrimaryExpression_68_Var
		 = (PrimaryExpression)Expr_67_list.get(0);
		Assert.assertNotNull(PrimaryExpression_68_Var
		);
		Assert.assertEquals("a", PrimaryExpression_68_Var
		.getId());
		//68
		final AssignmentOperator AssignmentOperator_69_Var
		 = (AssignmentOperator)AssignmentExpression_65_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_69_Var
		);
		Assert.assertEquals("=", AssignmentOperator_69_Var
		.getOp());
		//69
		final AssignmentExpression AssignmentExpression_70_Var
		 = (AssignmentExpression)AssignmentExpression_65_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_70_Var
		);
		//70
		final ConditionalExpression ConditionalExpression_71_Var
		 = (ConditionalExpression)AssignmentExpression_70_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_71_Var
		);
		//71
		final LogicalOrExpression LogicalOrExpression_72_Var
		 = (LogicalOrExpression)ConditionalExpression_71_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = LogicalOrExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final LogicalAndExpression LogicalAndExpression_73_Var
		 = (LogicalAndExpression)Expr_72_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = LogicalAndExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final InclusiveOrExpression InclusiveOrExpression_74_Var
		 = (InclusiveOrExpression)Expr_73_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = InclusiveOrExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final ExclusiveOrExpression ExclusiveOrExpression_75_Var
		 = (ExclusiveOrExpression)Expr_74_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = ExclusiveOrExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final AndExpression AndExpression_76_Var
		 = (AndExpression)Expr_75_list.get(0);
		Assert.assertNotNull(AndExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = AndExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final EqualityExpression EqualityExpression_77_Var
		 = (EqualityExpression)Expr_76_list.get(0);
		Assert.assertNotNull(EqualityExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = EqualityExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final RelationalExpression RelationalExpression_78_Var
		 = (RelationalExpression)Expr_77_list.get(0);
		Assert.assertNotNull(RelationalExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = RelationalExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final ShiftExpression ShiftExpression_79_Var
		 = (ShiftExpression)Expr_78_list.get(0);
		Assert.assertNotNull(ShiftExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = ShiftExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final AdditiveExpression AdditiveExpression_80_Var
		 = (AdditiveExpression)Expr_79_list.get(0);
		Assert.assertNotNull(AdditiveExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = AdditiveExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final MultiplicativeExpression MultiplicativeExpression_81_Var
		 = (MultiplicativeExpression)Expr_80_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = MultiplicativeExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final CastExpression CastExpression_82_Var
		 = (CastExpression)Expr_81_list.get(0);
		Assert.assertNotNull(CastExpression_82_Var
		);
		//82
		final UnaryExpression UnaryExpression_83_Var
		 = (UnaryExpression)CastExpression_82_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_83_Var
		);
		//83
		final PostfixExpression PostfixExpression_84_Var
		 = (PostfixExpression)UnaryExpression_83_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = PostfixExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final PrimaryExpression PrimaryExpression_85_Var
		 = (PrimaryExpression)Expr_84_list.get(0);
		Assert.assertNotNull(PrimaryExpression_85_Var
		);
		//85
		final Constant2 Constant2_86_Var
		 = (Constant2)PrimaryExpression_85_Var
		.getConst();
		Assert.assertNotNull(Constant2_86_Var
		);
		Assert.assertEquals("12", Constant2_86_Var
		.getDec());
		//86
		final AssignmentExpression AssignmentExpression_87_Var
		 = (AssignmentExpression)ExprExpr_64_list.get(1);
		Assert.assertNotNull(AssignmentExpression_87_Var
		);
		//87
		final UnaryExpression UnaryExpression_88_Var
		 = (UnaryExpression)AssignmentExpression_87_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_88_Var
		);
		//88
		final PostfixExpression PostfixExpression_89_Var
		 = (PostfixExpression)UnaryExpression_88_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = PostfixExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final PrimaryExpression PrimaryExpression_90_Var
		 = (PrimaryExpression)Expr_89_list.get(0);
		Assert.assertNotNull(PrimaryExpression_90_Var
		);
		Assert.assertEquals("b", PrimaryExpression_90_Var
		.getId());
		//90
		final AssignmentOperator AssignmentOperator_91_Var
		 = (AssignmentOperator)AssignmentExpression_87_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_91_Var
		);
		Assert.assertEquals("=", AssignmentOperator_91_Var
		.getOp());
		//91
		final AssignmentExpression AssignmentExpression_92_Var
		 = (AssignmentExpression)AssignmentExpression_87_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_92_Var
		);
		//92
		final ConditionalExpression ConditionalExpression_93_Var
		 = (ConditionalExpression)AssignmentExpression_92_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_93_Var
		);
		//93
		final LogicalOrExpression LogicalOrExpression_94_Var
		 = (LogicalOrExpression)ConditionalExpression_93_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = LogicalOrExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final LogicalAndExpression LogicalAndExpression_95_Var
		 = (LogicalAndExpression)Expr_94_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = LogicalAndExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final InclusiveOrExpression InclusiveOrExpression_96_Var
		 = (InclusiveOrExpression)Expr_95_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = InclusiveOrExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final ExclusiveOrExpression ExclusiveOrExpression_97_Var
		 = (ExclusiveOrExpression)Expr_96_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = ExclusiveOrExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final AndExpression AndExpression_98_Var
		 = (AndExpression)Expr_97_list.get(0);
		Assert.assertNotNull(AndExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = AndExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final EqualityExpression EqualityExpression_99_Var
		 = (EqualityExpression)Expr_98_list.get(0);
		Assert.assertNotNull(EqualityExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = EqualityExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final RelationalExpression RelationalExpression_100_Var
		 = (RelationalExpression)Expr_99_list.get(0);
		Assert.assertNotNull(RelationalExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = RelationalExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final ShiftExpression ShiftExpression_101_Var
		 = (ShiftExpression)Expr_100_list.get(0);
		Assert.assertNotNull(ShiftExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = ShiftExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final AdditiveExpression AdditiveExpression_102_Var
		 = (AdditiveExpression)Expr_101_list.get(0);
		Assert.assertNotNull(AdditiveExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = AdditiveExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final MultiplicativeExpression MultiplicativeExpression_103_Var
		 = (MultiplicativeExpression)Expr_102_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = MultiplicativeExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final CastExpression CastExpression_104_Var
		 = (CastExpression)Expr_103_list.get(0);
		Assert.assertNotNull(CastExpression_104_Var
		);
		//104
		final UnaryExpression UnaryExpression_105_Var
		 = (UnaryExpression)CastExpression_104_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_105_Var
		);
		//105
		final PostfixExpression PostfixExpression_106_Var
		 = (PostfixExpression)UnaryExpression_105_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = PostfixExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final PrimaryExpression PrimaryExpression_107_Var
		 = (PrimaryExpression)Expr_106_list.get(0);
		Assert.assertNotNull(PrimaryExpression_107_Var
		);
		//107
		final Constant2 Constant2_108_Var
		 = (Constant2)PrimaryExpression_107_Var
		.getConst();
		Assert.assertNotNull(Constant2_108_Var
		);
		Assert.assertEquals("21", Constant2_108_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_63_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0014_AssignExpr.c");
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
				method.invoke(this.generator, "Test0014_AssignExpr.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0014_AssignExpr.c");
		final String expected = this.getTextFromFile(
			"res/Test0014_AssignExpr.c"
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


