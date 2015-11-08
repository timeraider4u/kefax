package at.jku.weiner.c.xtexttests;

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
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import at.jku.weiner.c.tests.CInjectorProvider;
import at.jku.weiner.c.parser.antlr.CParser;
import at.jku.weiner.c.parser.antlr.internal.InternalCLexer;
import at.jku.weiner.c.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.c.Model;
import at.jku.weiner.c.c.TranslationUnit;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.FunctionDefHead;
import at.jku.weiner.c.c.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.FunctionDefinition;
import at.jku.weiner.c.c.BodyStatement;
import at.jku.weiner.c.c.BlockList;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.Initializer;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.Initializer;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.AssignmentOperator;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.AssignmentOperator;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0014_AssignExpr {
	@Inject
	private ParseHelper<Model> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalCLexer lexer;
	@Inject
	private CParser parser;
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
	
	@Before
	public void initialize(){
		this.testHelper = new LexerAndParserTest(lexer, 
			parser, tokenDefProvider);
	}
	
	private String getTextFromFile(final String fileName)
	throws Exception{
		final Path path = Paths.get(fileName);
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
	private String preprocess(final String string) {
		final String lineComment = string.replaceAll("//.*\n", " ");
		final String blockComment = lineComment.replaceAll("/\\*.*\\*/", " ");
		final String lines = blockComment.replaceAll("\n", " ").trim();
		final String multi = lines.replaceAll("\\s{2,}", " ").trim();
		final String sign = multi.replaceAll("\\s+([^a-zA-Z0-9_])", "$1")
				.trim();
		final String sign2 = sign.replaceAll("([^a-zA-Z0-9_])\\s+", "$1")
				.trim();
	
		// System.out.println(sign2);
		return sign2;
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
				"RULE_LEFTPAREN", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_RIGHTBRACE", 
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
		Assert.assertEquals(1, External_1_list.size());
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
		Assert.assertEquals("void", TypeSpecifier_5_Var
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
		Assert.assertEquals("doSomething", DirectDeclarator_7_Var
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
		final EList<? extends EObject> Declaration_10_list = BlockList_10_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_10_list);
		Assert.assertEquals(2, Declaration_10_list.size());
		//10
		final Declaration Declaration_11_Var
		 = (Declaration)Declaration_10_list.get(0);
		Assert.assertNotNull(Declaration_11_Var
		);
		//11
		final DeclarationSpecifiers DeclarationSpecifiers_12_Var
		 = (DeclarationSpecifiers)Declaration_11_Var
		.getSpecifiers();
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
		final EList<? extends EObject> InitDeclaratorList_13_list = Declaration_11_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_13_list);
		Assert.assertEquals(1, InitDeclaratorList_13_list.size());
		//13
		final InitDeclaratorList InitDeclaratorList_14_Var
		 = (InitDeclaratorList)InitDeclaratorList_13_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_14_Var
		);
		final EList<? extends EObject> InitDeclarator_14_list = InitDeclaratorList_14_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_14_list);
		Assert.assertEquals(1, InitDeclarator_14_list.size());
		//14
		final InitDeclarator InitDeclarator_15_Var
		 = (InitDeclarator)InitDeclarator_14_list.get(0);
		Assert.assertNotNull(InitDeclarator_15_Var
		);
		//15
		final Declarator Declarator_16_Var
		 = (Declarator)InitDeclarator_15_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_16_Var
		);
		//16
		final DirectDeclarator DirectDeclarator_17_Var
		 = (DirectDeclarator)Declarator_16_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_17_Var
		);
		Assert.assertEquals("a", DirectDeclarator_17_Var
		.getId());
		//17
		final Initializer Initializer_18_Var
		 = (Initializer)InitDeclarator_15_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_18_Var
		);
		//18
		final AssignmentExpression AssignmentExpression_19_Var
		 = (AssignmentExpression)Initializer_18_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_19_Var
		);
		//19
		final ConditionalExpression ConditionalExpression_20_Var
		 = (ConditionalExpression)AssignmentExpression_19_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_20_Var
		);
		//20
		final LogicalOrExpression LogicalOrExpression_21_Var
		 = (LogicalOrExpression)ConditionalExpression_20_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = LogicalOrExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final LogicalAndExpression LogicalAndExpression_22_Var
		 = (LogicalAndExpression)Expr_21_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = LogicalAndExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final InclusiveOrExpression InclusiveOrExpression_23_Var
		 = (InclusiveOrExpression)Expr_22_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = InclusiveOrExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final ExclusiveOrExpression ExclusiveOrExpression_24_Var
		 = (ExclusiveOrExpression)Expr_23_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = ExclusiveOrExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final AndExpression AndExpression_25_Var
		 = (AndExpression)Expr_24_list.get(0);
		Assert.assertNotNull(AndExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = AndExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final EqualityExpression EqualityExpression_26_Var
		 = (EqualityExpression)Expr_25_list.get(0);
		Assert.assertNotNull(EqualityExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = EqualityExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final RelationalExpression RelationalExpression_27_Var
		 = (RelationalExpression)Expr_26_list.get(0);
		Assert.assertNotNull(RelationalExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = RelationalExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final ShiftExpression ShiftExpression_28_Var
		 = (ShiftExpression)Expr_27_list.get(0);
		Assert.assertNotNull(ShiftExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = ShiftExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final AdditiveExpression AdditiveExpression_29_Var
		 = (AdditiveExpression)Expr_28_list.get(0);
		Assert.assertNotNull(AdditiveExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = AdditiveExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final MultiplicativeExpression MultiplicativeExpression_30_Var
		 = (MultiplicativeExpression)Expr_29_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = MultiplicativeExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final CastExpression CastExpression_31_Var
		 = (CastExpression)Expr_30_list.get(0);
		Assert.assertNotNull(CastExpression_31_Var
		);
		//31
		final UnaryExpression UnaryExpression_32_Var
		 = (UnaryExpression)CastExpression_31_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_32_Var
		);
		//32
		final PostfixExpression PostfixExpression_33_Var
		 = (PostfixExpression)UnaryExpression_32_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = PostfixExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final PrimaryExpression PrimaryExpression_34_Var
		 = (PrimaryExpression)Expr_33_list.get(0);
		Assert.assertNotNull(PrimaryExpression_34_Var
		);
		//34
		final Constant Constant_35_Var
		 = (Constant)PrimaryExpression_34_Var
		.getConst();
		Assert.assertNotNull(Constant_35_Var
		);
		Assert.assertEquals("0", Constant_35_Var
		.getDec());
		//35
		final Declaration Declaration_36_Var
		 = (Declaration)Declaration_10_list.get(1);
		Assert.assertNotNull(Declaration_36_Var
		);
		//36
		final DeclarationSpecifiers DeclarationSpecifiers_37_Var
		 = (DeclarationSpecifiers)Declaration_36_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_37_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_37_list = DeclarationSpecifiers_37_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_37_list);
		Assert.assertEquals(1, DeclarationSpecifier_37_list.size());
		//37
		final TypeSpecifier TypeSpecifier_38_Var
		 = (TypeSpecifier)DeclarationSpecifier_37_list.get(0);
		Assert.assertNotNull(TypeSpecifier_38_Var
		);
		Assert.assertEquals("int", TypeSpecifier_38_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_38_list = Declaration_36_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_38_list);
		Assert.assertEquals(1, InitDeclaratorList_38_list.size());
		//38
		final InitDeclaratorList InitDeclaratorList_39_Var
		 = (InitDeclaratorList)InitDeclaratorList_38_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_39_Var
		);
		final EList<? extends EObject> InitDeclarator_39_list = InitDeclaratorList_39_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_39_list);
		Assert.assertEquals(1, InitDeclarator_39_list.size());
		//39
		final InitDeclarator InitDeclarator_40_Var
		 = (InitDeclarator)InitDeclarator_39_list.get(0);
		Assert.assertNotNull(InitDeclarator_40_Var
		);
		//40
		final Declarator Declarator_41_Var
		 = (Declarator)InitDeclarator_40_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_41_Var
		);
		//41
		final DirectDeclarator DirectDeclarator_42_Var
		 = (DirectDeclarator)Declarator_41_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_42_Var
		);
		Assert.assertEquals("b", DirectDeclarator_42_Var
		.getId());
		//42
		final Initializer Initializer_43_Var
		 = (Initializer)InitDeclarator_40_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_43_Var
		);
		//43
		final AssignmentExpression AssignmentExpression_44_Var
		 = (AssignmentExpression)Initializer_43_Var
		.getExpr();
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
		final PostfixExpression PostfixExpression_58_Var
		 = (PostfixExpression)UnaryExpression_57_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = PostfixExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final PrimaryExpression PrimaryExpression_59_Var
		 = (PrimaryExpression)Expr_58_list.get(0);
		Assert.assertNotNull(PrimaryExpression_59_Var
		);
		//59
		final Constant Constant_60_Var
		 = (Constant)PrimaryExpression_59_Var
		.getConst();
		Assert.assertNotNull(Constant_60_Var
		);
		Assert.assertEquals("2", Constant_60_Var
		.getDec());
		final EList<? extends EObject> Statement_60_list = BlockList_10_Var
		.getStatement();
		Assert.assertNotNull(Statement_60_list);
		Assert.assertEquals(1, Statement_60_list.size());
		//60
		final Statement Statement_61_Var
		 = (Statement)Statement_60_list.get(0);
		Assert.assertNotNull(Statement_61_Var
		);
		//61
		final ExpressionStatement ExpressionStatement_62_Var
		 = (ExpressionStatement)Statement_61_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_62_Var
		);
		//62
		final Expression Expression_63_Var
		 = (Expression)ExpressionStatement_62_Var
		.getExpression();
		Assert.assertNotNull(Expression_63_Var
		);
		final EList<? extends EObject> ExprExpr_63_list = Expression_63_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_63_list);
		Assert.assertEquals(2, ExprExpr_63_list.size());
		//63
		final AssignmentExpression AssignmentExpression_64_Var
		 = (AssignmentExpression)ExprExpr_63_list.get(0);
		Assert.assertNotNull(AssignmentExpression_64_Var
		);
		//64
		final UnaryExpression UnaryExpression_65_Var
		 = (UnaryExpression)AssignmentExpression_64_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_65_Var
		);
		//65
		final PostfixExpression PostfixExpression_66_Var
		 = (PostfixExpression)UnaryExpression_65_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = PostfixExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final PrimaryExpression PrimaryExpression_67_Var
		 = (PrimaryExpression)Expr_66_list.get(0);
		Assert.assertNotNull(PrimaryExpression_67_Var
		);
		Assert.assertEquals("a", PrimaryExpression_67_Var
		.getId());
		//67
		final AssignmentOperator AssignmentOperator_68_Var
		 = (AssignmentOperator)AssignmentExpression_64_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_68_Var
		);
		Assert.assertEquals("=", AssignmentOperator_68_Var
		.getOp());
		//68
		final AssignmentExpression AssignmentExpression_69_Var
		 = (AssignmentExpression)AssignmentExpression_64_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_69_Var
		);
		//69
		final ConditionalExpression ConditionalExpression_70_Var
		 = (ConditionalExpression)AssignmentExpression_69_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_70_Var
		);
		//70
		final LogicalOrExpression LogicalOrExpression_71_Var
		 = (LogicalOrExpression)ConditionalExpression_70_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = LogicalOrExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final LogicalAndExpression LogicalAndExpression_72_Var
		 = (LogicalAndExpression)Expr_71_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = LogicalAndExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final InclusiveOrExpression InclusiveOrExpression_73_Var
		 = (InclusiveOrExpression)Expr_72_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = InclusiveOrExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final ExclusiveOrExpression ExclusiveOrExpression_74_Var
		 = (ExclusiveOrExpression)Expr_73_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = ExclusiveOrExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final AndExpression AndExpression_75_Var
		 = (AndExpression)Expr_74_list.get(0);
		Assert.assertNotNull(AndExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = AndExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final EqualityExpression EqualityExpression_76_Var
		 = (EqualityExpression)Expr_75_list.get(0);
		Assert.assertNotNull(EqualityExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = EqualityExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final RelationalExpression RelationalExpression_77_Var
		 = (RelationalExpression)Expr_76_list.get(0);
		Assert.assertNotNull(RelationalExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = RelationalExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final ShiftExpression ShiftExpression_78_Var
		 = (ShiftExpression)Expr_77_list.get(0);
		Assert.assertNotNull(ShiftExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = ShiftExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final AdditiveExpression AdditiveExpression_79_Var
		 = (AdditiveExpression)Expr_78_list.get(0);
		Assert.assertNotNull(AdditiveExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = AdditiveExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final MultiplicativeExpression MultiplicativeExpression_80_Var
		 = (MultiplicativeExpression)Expr_79_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = MultiplicativeExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final CastExpression CastExpression_81_Var
		 = (CastExpression)Expr_80_list.get(0);
		Assert.assertNotNull(CastExpression_81_Var
		);
		//81
		final UnaryExpression UnaryExpression_82_Var
		 = (UnaryExpression)CastExpression_81_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_82_Var
		);
		//82
		final PostfixExpression PostfixExpression_83_Var
		 = (PostfixExpression)UnaryExpression_82_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = PostfixExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final PrimaryExpression PrimaryExpression_84_Var
		 = (PrimaryExpression)Expr_83_list.get(0);
		Assert.assertNotNull(PrimaryExpression_84_Var
		);
		//84
		final Constant Constant_85_Var
		 = (Constant)PrimaryExpression_84_Var
		.getConst();
		Assert.assertNotNull(Constant_85_Var
		);
		Assert.assertEquals("12", Constant_85_Var
		.getDec());
		//85
		final AssignmentExpression AssignmentExpression_86_Var
		 = (AssignmentExpression)ExprExpr_63_list.get(1);
		Assert.assertNotNull(AssignmentExpression_86_Var
		);
		//86
		final UnaryExpression UnaryExpression_87_Var
		 = (UnaryExpression)AssignmentExpression_86_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_87_Var
		);
		//87
		final PostfixExpression PostfixExpression_88_Var
		 = (PostfixExpression)UnaryExpression_87_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = PostfixExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final PrimaryExpression PrimaryExpression_89_Var
		 = (PrimaryExpression)Expr_88_list.get(0);
		Assert.assertNotNull(PrimaryExpression_89_Var
		);
		Assert.assertEquals("b", PrimaryExpression_89_Var
		.getId());
		//89
		final AssignmentOperator AssignmentOperator_90_Var
		 = (AssignmentOperator)AssignmentExpression_86_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_90_Var
		);
		Assert.assertEquals("=", AssignmentOperator_90_Var
		.getOp());
		//90
		final AssignmentExpression AssignmentExpression_91_Var
		 = (AssignmentExpression)AssignmentExpression_86_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_91_Var
		);
		//91
		final ConditionalExpression ConditionalExpression_92_Var
		 = (ConditionalExpression)AssignmentExpression_91_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_92_Var
		);
		//92
		final LogicalOrExpression LogicalOrExpression_93_Var
		 = (LogicalOrExpression)ConditionalExpression_92_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = LogicalOrExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final LogicalAndExpression LogicalAndExpression_94_Var
		 = (LogicalAndExpression)Expr_93_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = LogicalAndExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final InclusiveOrExpression InclusiveOrExpression_95_Var
		 = (InclusiveOrExpression)Expr_94_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = InclusiveOrExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final ExclusiveOrExpression ExclusiveOrExpression_96_Var
		 = (ExclusiveOrExpression)Expr_95_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = ExclusiveOrExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final AndExpression AndExpression_97_Var
		 = (AndExpression)Expr_96_list.get(0);
		Assert.assertNotNull(AndExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = AndExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final EqualityExpression EqualityExpression_98_Var
		 = (EqualityExpression)Expr_97_list.get(0);
		Assert.assertNotNull(EqualityExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = EqualityExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final RelationalExpression RelationalExpression_99_Var
		 = (RelationalExpression)Expr_98_list.get(0);
		Assert.assertNotNull(RelationalExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = RelationalExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final ShiftExpression ShiftExpression_100_Var
		 = (ShiftExpression)Expr_99_list.get(0);
		Assert.assertNotNull(ShiftExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = ShiftExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final AdditiveExpression AdditiveExpression_101_Var
		 = (AdditiveExpression)Expr_100_list.get(0);
		Assert.assertNotNull(AdditiveExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = AdditiveExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final MultiplicativeExpression MultiplicativeExpression_102_Var
		 = (MultiplicativeExpression)Expr_101_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = MultiplicativeExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final CastExpression CastExpression_103_Var
		 = (CastExpression)Expr_102_list.get(0);
		Assert.assertNotNull(CastExpression_103_Var
		);
		//103
		final UnaryExpression UnaryExpression_104_Var
		 = (UnaryExpression)CastExpression_103_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_104_Var
		);
		//104
		final PostfixExpression PostfixExpression_105_Var
		 = (PostfixExpression)UnaryExpression_104_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = PostfixExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final PrimaryExpression PrimaryExpression_106_Var
		 = (PrimaryExpression)Expr_105_list.get(0);
		Assert.assertNotNull(PrimaryExpression_106_Var
		);
		//106
		final Constant Constant_107_Var
		 = (Constant)PrimaryExpression_106_Var
		.getConst();
		Assert.assertNotNull(Constant_107_Var
		);
		Assert.assertEquals("21", Constant_107_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_62_Var
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
	
}


