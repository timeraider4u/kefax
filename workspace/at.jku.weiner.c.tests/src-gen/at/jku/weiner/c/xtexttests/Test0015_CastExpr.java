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
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
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
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.TypeName;
import at.jku.weiner.c.c.SpecifierQualifierList;
import at.jku.weiner.c.c.TypeSpecifier;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0015_CastExpr {
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
			"res/Test0015_CastExpr.c");
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
				"RULE_LEFTPAREN", 
				"RULE_KW_INT", 
				"RULE_RIGHTPAREN", 
				"RULE_FLOAT_LITERAL", 
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
			"res/Test0015_CastExpr.c");
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
		final ExpressionStatement ExpressionStatement_12_Var
		 = (ExpressionStatement)Statement_11_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_12_Var
		);
		//12
		final Expression Expression_13_Var
		 = (Expression)ExpressionStatement_12_Var
		.getExpression();
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
		final CastExpression CastExpression_27_Var
		 = (CastExpression)CastExpression_26_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_27_Var
		);
		//27
		final UnaryExpression UnaryExpression_28_Var
		 = (UnaryExpression)CastExpression_27_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_28_Var
		);
		//28
		final PostfixExpression PostfixExpression_29_Var
		 = (PostfixExpression)UnaryExpression_28_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = PostfixExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final PrimaryExpression PrimaryExpression_30_Var
		 = (PrimaryExpression)Expr_29_list.get(0);
		Assert.assertNotNull(PrimaryExpression_30_Var
		);
		//30
		final Constant Constant_31_Var
		 = (Constant)PrimaryExpression_30_Var
		.getConst();
		Assert.assertNotNull(Constant_31_Var
		);
		Assert.assertEquals("0.8", Constant_31_Var
		.getFloat());
		//31
		final TypeName TypeName_32_Var
		 = (TypeName)CastExpression_26_Var
		.getType();
		Assert.assertNotNull(TypeName_32_Var
		);
		//32
		final SpecifierQualifierList SpecifierQualifierList_33_Var
		 = (SpecifierQualifierList)TypeName_32_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_33_Var
		);
		final EList<? extends EObject> TypeSpecifier_33_list = SpecifierQualifierList_33_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_33_list);
		Assert.assertEquals(1, TypeSpecifier_33_list.size());
		//33
		final TypeSpecifier TypeSpecifier_34_Var
		 = (TypeSpecifier)TypeSpecifier_33_list.get(0);
		Assert.assertNotNull(TypeSpecifier_34_Var
		);
		Assert.assertEquals("int", TypeSpecifier_34_Var
		.getName());
		Assert.assertEquals(";", ExpressionStatement_12_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0015_CastExpr.c");
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
				method.invoke(this.generator, "Test0015_CastExpr.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0015_CastExpr.c");
		final String expected = this.getTextFromFile(
			"res/Test0015_CastExpr.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
		// System.out.println("Code generation finished.");
	}
	
}


