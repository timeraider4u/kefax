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
		Assert.assertEquals("doSomething", DirectDeclarator_6_Var
		.getId());
		//6
		final FunctionDefinition FunctionDefinition_7_Var
		 = (FunctionDefinition)ExternalDeclaration_1_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_7_Var
		);
		//7
		final BodyStatement BodyStatement_8_Var
		 = (BodyStatement)FunctionDefinition_7_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_8_Var
		);
		final EList<? extends EObject> BlockList_8_list = BodyStatement_8_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_8_list);
		Assert.assertEquals(1, BlockList_8_list.size());
		//8
		final BlockList BlockList_9_Var
		 = (BlockList)BlockList_8_list.get(0);
		Assert.assertNotNull(BlockList_9_Var
		);
		final EList<? extends EObject> Declaration_9_list = BlockList_9_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_9_list);
		Assert.assertEquals(2, Declaration_9_list.size());
		//9
		final Declaration Declaration_10_Var
		 = (Declaration)Declaration_9_list.get(0);
		Assert.assertNotNull(Declaration_10_Var
		);
		//10
		final DeclarationSpecifiers DeclarationSpecifiers_11_Var
		 = (DeclarationSpecifiers)Declaration_10_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_11_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_11_list = DeclarationSpecifiers_11_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_11_list);
		Assert.assertEquals(1, DeclarationSpecifier_11_list.size());
		//11
		final TypeSpecifier TypeSpecifier_12_Var
		 = (TypeSpecifier)DeclarationSpecifier_11_list.get(0);
		Assert.assertNotNull(TypeSpecifier_12_Var
		);
		Assert.assertEquals("int", TypeSpecifier_12_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_12_list = Declaration_10_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_12_list);
		Assert.assertEquals(1, InitDeclaratorList_12_list.size());
		//12
		final InitDeclaratorList InitDeclaratorList_13_Var
		 = (InitDeclaratorList)InitDeclaratorList_12_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_13_Var
		);
		final EList<? extends EObject> InitDeclarator_13_list = InitDeclaratorList_13_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_13_list);
		Assert.assertEquals(1, InitDeclarator_13_list.size());
		//13
		final InitDeclarator InitDeclarator_14_Var
		 = (InitDeclarator)InitDeclarator_13_list.get(0);
		Assert.assertNotNull(InitDeclarator_14_Var
		);
		//14
		final Declarator Declarator_15_Var
		 = (Declarator)InitDeclarator_14_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_15_Var
		);
		//15
		final DirectDeclarator DirectDeclarator_16_Var
		 = (DirectDeclarator)Declarator_15_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_16_Var
		);
		Assert.assertEquals("a", DirectDeclarator_16_Var
		.getId());
		//16
		final Initializer Initializer_17_Var
		 = (Initializer)InitDeclarator_14_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_17_Var
		);
		//17
		final AssignmentExpression AssignmentExpression_18_Var
		 = (AssignmentExpression)Initializer_17_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_18_Var
		);
		//18
		final ConditionalExpression ConditionalExpression_19_Var
		 = (ConditionalExpression)AssignmentExpression_18_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_19_Var
		);
		//19
		final LogicalOrExpression LogicalOrExpression_20_Var
		 = (LogicalOrExpression)ConditionalExpression_19_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = LogicalOrExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final LogicalAndExpression LogicalAndExpression_21_Var
		 = (LogicalAndExpression)Expr_20_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = LogicalAndExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final InclusiveOrExpression InclusiveOrExpression_22_Var
		 = (InclusiveOrExpression)Expr_21_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = InclusiveOrExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final ExclusiveOrExpression ExclusiveOrExpression_23_Var
		 = (ExclusiveOrExpression)Expr_22_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = ExclusiveOrExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final AndExpression AndExpression_24_Var
		 = (AndExpression)Expr_23_list.get(0);
		Assert.assertNotNull(AndExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = AndExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final EqualityExpression EqualityExpression_25_Var
		 = (EqualityExpression)Expr_24_list.get(0);
		Assert.assertNotNull(EqualityExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = EqualityExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final RelationalExpression RelationalExpression_26_Var
		 = (RelationalExpression)Expr_25_list.get(0);
		Assert.assertNotNull(RelationalExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = RelationalExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final ShiftExpression ShiftExpression_27_Var
		 = (ShiftExpression)Expr_26_list.get(0);
		Assert.assertNotNull(ShiftExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = ShiftExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final AdditiveExpression AdditiveExpression_28_Var
		 = (AdditiveExpression)Expr_27_list.get(0);
		Assert.assertNotNull(AdditiveExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = AdditiveExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final MultiplicativeExpression MultiplicativeExpression_29_Var
		 = (MultiplicativeExpression)Expr_28_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = MultiplicativeExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final CastExpression CastExpression_30_Var
		 = (CastExpression)Expr_29_list.get(0);
		Assert.assertNotNull(CastExpression_30_Var
		);
		//30
		final UnaryExpression UnaryExpression_31_Var
		 = (UnaryExpression)CastExpression_30_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_31_Var
		);
		//31
		final PostfixExpression PostfixExpression_32_Var
		 = (PostfixExpression)UnaryExpression_31_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = PostfixExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final PrimaryExpression PrimaryExpression_33_Var
		 = (PrimaryExpression)Expr_32_list.get(0);
		Assert.assertNotNull(PrimaryExpression_33_Var
		);
		//33
		final Constant2 Constant2_34_Var
		 = (Constant2)PrimaryExpression_33_Var
		.getConst();
		Assert.assertNotNull(Constant2_34_Var
		);
		Assert.assertEquals("0", Constant2_34_Var
		.getDec());
		//34
		final Declaration Declaration_35_Var
		 = (Declaration)Declaration_9_list.get(1);
		Assert.assertNotNull(Declaration_35_Var
		);
		//35
		final DeclarationSpecifiers DeclarationSpecifiers_36_Var
		 = (DeclarationSpecifiers)Declaration_35_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_36_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_36_list = DeclarationSpecifiers_36_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_36_list);
		Assert.assertEquals(1, DeclarationSpecifier_36_list.size());
		//36
		final TypeSpecifier TypeSpecifier_37_Var
		 = (TypeSpecifier)DeclarationSpecifier_36_list.get(0);
		Assert.assertNotNull(TypeSpecifier_37_Var
		);
		Assert.assertEquals("int", TypeSpecifier_37_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_37_list = Declaration_35_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_37_list);
		Assert.assertEquals(1, InitDeclaratorList_37_list.size());
		//37
		final InitDeclaratorList InitDeclaratorList_38_Var
		 = (InitDeclaratorList)InitDeclaratorList_37_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_38_Var
		);
		final EList<? extends EObject> InitDeclarator_38_list = InitDeclaratorList_38_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_38_list);
		Assert.assertEquals(1, InitDeclarator_38_list.size());
		//38
		final InitDeclarator InitDeclarator_39_Var
		 = (InitDeclarator)InitDeclarator_38_list.get(0);
		Assert.assertNotNull(InitDeclarator_39_Var
		);
		//39
		final Declarator Declarator_40_Var
		 = (Declarator)InitDeclarator_39_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_40_Var
		);
		//40
		final DirectDeclarator DirectDeclarator_41_Var
		 = (DirectDeclarator)Declarator_40_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_41_Var
		);
		Assert.assertEquals("b", DirectDeclarator_41_Var
		.getId());
		//41
		final Initializer Initializer_42_Var
		 = (Initializer)InitDeclarator_39_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_42_Var
		);
		//42
		final AssignmentExpression AssignmentExpression_43_Var
		 = (AssignmentExpression)Initializer_42_Var
		.getExpr();
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
		//58
		final Constant2 Constant2_59_Var
		 = (Constant2)PrimaryExpression_58_Var
		.getConst();
		Assert.assertNotNull(Constant2_59_Var
		);
		Assert.assertEquals("2", Constant2_59_Var
		.getDec());
		final EList<? extends EObject> Statement_59_list = BlockList_9_Var
		.getStatement();
		Assert.assertNotNull(Statement_59_list);
		Assert.assertEquals(1, Statement_59_list.size());
		//59
		final Statement Statement_60_Var
		 = (Statement)Statement_59_list.get(0);
		Assert.assertNotNull(Statement_60_Var
		);
		//60
		final ExpressionStatement ExpressionStatement_61_Var
		 = (ExpressionStatement)Statement_60_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_61_Var
		);
		//61
		final Expression Expression_62_Var
		 = (Expression)ExpressionStatement_61_Var
		.getExpression();
		Assert.assertNotNull(Expression_62_Var
		);
		final EList<? extends EObject> ExprExpr_62_list = Expression_62_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_62_list);
		Assert.assertEquals(2, ExprExpr_62_list.size());
		//62
		final AssignmentExpression AssignmentExpression_63_Var
		 = (AssignmentExpression)ExprExpr_62_list.get(0);
		Assert.assertNotNull(AssignmentExpression_63_Var
		);
		//63
		final UnaryExpression UnaryExpression_64_Var
		 = (UnaryExpression)AssignmentExpression_63_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_64_Var
		);
		//64
		final PostfixExpression PostfixExpression_65_Var
		 = (PostfixExpression)UnaryExpression_64_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = PostfixExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final PrimaryExpression PrimaryExpression_66_Var
		 = (PrimaryExpression)Expr_65_list.get(0);
		Assert.assertNotNull(PrimaryExpression_66_Var
		);
		Assert.assertEquals("a", PrimaryExpression_66_Var
		.getId());
		//66
		final AssignmentOperator AssignmentOperator_67_Var
		 = (AssignmentOperator)AssignmentExpression_63_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_67_Var
		);
		Assert.assertEquals("=", AssignmentOperator_67_Var
		.getOp());
		//67
		final AssignmentExpression AssignmentExpression_68_Var
		 = (AssignmentExpression)AssignmentExpression_63_Var
		.getAssignmentExpr();
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
		//83
		final Constant2 Constant2_84_Var
		 = (Constant2)PrimaryExpression_83_Var
		.getConst();
		Assert.assertNotNull(Constant2_84_Var
		);
		Assert.assertEquals("12", Constant2_84_Var
		.getDec());
		//84
		final AssignmentExpression AssignmentExpression_85_Var
		 = (AssignmentExpression)ExprExpr_62_list.get(1);
		Assert.assertNotNull(AssignmentExpression_85_Var
		);
		//85
		final UnaryExpression UnaryExpression_86_Var
		 = (UnaryExpression)AssignmentExpression_85_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_86_Var
		);
		//86
		final PostfixExpression PostfixExpression_87_Var
		 = (PostfixExpression)UnaryExpression_86_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = PostfixExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final PrimaryExpression PrimaryExpression_88_Var
		 = (PrimaryExpression)Expr_87_list.get(0);
		Assert.assertNotNull(PrimaryExpression_88_Var
		);
		Assert.assertEquals("b", PrimaryExpression_88_Var
		.getId());
		//88
		final AssignmentOperator AssignmentOperator_89_Var
		 = (AssignmentOperator)AssignmentExpression_85_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_89_Var
		);
		Assert.assertEquals("=", AssignmentOperator_89_Var
		.getOp());
		//89
		final AssignmentExpression AssignmentExpression_90_Var
		 = (AssignmentExpression)AssignmentExpression_85_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_90_Var
		);
		//90
		final ConditionalExpression ConditionalExpression_91_Var
		 = (ConditionalExpression)AssignmentExpression_90_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_91_Var
		);
		//91
		final LogicalOrExpression LogicalOrExpression_92_Var
		 = (LogicalOrExpression)ConditionalExpression_91_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = LogicalOrExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final LogicalAndExpression LogicalAndExpression_93_Var
		 = (LogicalAndExpression)Expr_92_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = LogicalAndExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final InclusiveOrExpression InclusiveOrExpression_94_Var
		 = (InclusiveOrExpression)Expr_93_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = InclusiveOrExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final ExclusiveOrExpression ExclusiveOrExpression_95_Var
		 = (ExclusiveOrExpression)Expr_94_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = ExclusiveOrExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final AndExpression AndExpression_96_Var
		 = (AndExpression)Expr_95_list.get(0);
		Assert.assertNotNull(AndExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = AndExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final EqualityExpression EqualityExpression_97_Var
		 = (EqualityExpression)Expr_96_list.get(0);
		Assert.assertNotNull(EqualityExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = EqualityExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final RelationalExpression RelationalExpression_98_Var
		 = (RelationalExpression)Expr_97_list.get(0);
		Assert.assertNotNull(RelationalExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = RelationalExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final ShiftExpression ShiftExpression_99_Var
		 = (ShiftExpression)Expr_98_list.get(0);
		Assert.assertNotNull(ShiftExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = ShiftExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final AdditiveExpression AdditiveExpression_100_Var
		 = (AdditiveExpression)Expr_99_list.get(0);
		Assert.assertNotNull(AdditiveExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = AdditiveExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final MultiplicativeExpression MultiplicativeExpression_101_Var
		 = (MultiplicativeExpression)Expr_100_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = MultiplicativeExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final CastExpression CastExpression_102_Var
		 = (CastExpression)Expr_101_list.get(0);
		Assert.assertNotNull(CastExpression_102_Var
		);
		//102
		final UnaryExpression UnaryExpression_103_Var
		 = (UnaryExpression)CastExpression_102_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_103_Var
		);
		//103
		final PostfixExpression PostfixExpression_104_Var
		 = (PostfixExpression)UnaryExpression_103_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = PostfixExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final PrimaryExpression PrimaryExpression_105_Var
		 = (PrimaryExpression)Expr_104_list.get(0);
		Assert.assertNotNull(PrimaryExpression_105_Var
		);
		//105
		final Constant2 Constant2_106_Var
		 = (Constant2)PrimaryExpression_105_Var
		.getConst();
		Assert.assertNotNull(Constant2_106_Var
		);
		Assert.assertEquals("21", Constant2_106_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_61_Var
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


