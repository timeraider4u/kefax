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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
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
public class Test0060_MultipleStringsInArgument {
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
			"res/Test0060_MultipleStringsInArgument.c");
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
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_STRING_LITERAL",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
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
			"res/Test0060_MultipleStringsInArgument.c");
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
		Assert.assertTrue(DirectDeclaratorLastSuffix_8_Var
		.getParameterTypeList().isEmpty());
		//8
		final FunctionDefinition FunctionDefinition_9_Var
		 = (FunctionDefinition)ExternalDeclaration_1_Var
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
		final EList<? extends EObject> Statement_11_list = BlockList_11_Var
		.getStatement();
		Assert.assertNotNull(Statement_11_list);
		Assert.assertEquals(1, Statement_11_list.size());
		//11
		final Statement Statement_12_Var
		 = (Statement)Statement_11_list.get(0);
		Assert.assertNotNull(Statement_12_Var
		);
		//12
		final ExpressionStatement ExpressionStatement_13_Var
		 = (ExpressionStatement)Statement_12_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_13_Var
		);
		//13
		final Expression Expression_14_Var
		 = (Expression)ExpressionStatement_13_Var
		.getExpression();
		Assert.assertNotNull(Expression_14_Var
		);
		final EList<? extends EObject> ExprExpr_14_list = Expression_14_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_14_list);
		Assert.assertEquals(1, ExprExpr_14_list.size());
		//14
		final AssignmentExpression AssignmentExpression_15_Var
		 = (AssignmentExpression)ExprExpr_14_list.get(0);
		Assert.assertNotNull(AssignmentExpression_15_Var
		);
		//15
		final ConditionalExpression ConditionalExpression_16_Var
		 = (ConditionalExpression)AssignmentExpression_15_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_16_Var
		);
		//16
		final LogicalOrExpression LogicalOrExpression_17_Var
		 = (LogicalOrExpression)ConditionalExpression_16_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = LogicalOrExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final LogicalAndExpression LogicalAndExpression_18_Var
		 = (LogicalAndExpression)Expr_17_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = LogicalAndExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final InclusiveOrExpression InclusiveOrExpression_19_Var
		 = (InclusiveOrExpression)Expr_18_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = InclusiveOrExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final ExclusiveOrExpression ExclusiveOrExpression_20_Var
		 = (ExclusiveOrExpression)Expr_19_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = ExclusiveOrExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final AndExpression AndExpression_21_Var
		 = (AndExpression)Expr_20_list.get(0);
		Assert.assertNotNull(AndExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = AndExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final EqualityExpression EqualityExpression_22_Var
		 = (EqualityExpression)Expr_21_list.get(0);
		Assert.assertNotNull(EqualityExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = EqualityExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final RelationalExpression RelationalExpression_23_Var
		 = (RelationalExpression)Expr_22_list.get(0);
		Assert.assertNotNull(RelationalExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = RelationalExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final ShiftExpression ShiftExpression_24_Var
		 = (ShiftExpression)Expr_23_list.get(0);
		Assert.assertNotNull(ShiftExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = ShiftExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final AdditiveExpression AdditiveExpression_25_Var
		 = (AdditiveExpression)Expr_24_list.get(0);
		Assert.assertNotNull(AdditiveExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = AdditiveExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final MultiplicativeExpression MultiplicativeExpression_26_Var
		 = (MultiplicativeExpression)Expr_25_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = MultiplicativeExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final CastExpression CastExpression_27_Var
		 = (CastExpression)Expr_26_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_30_Var
		.getId());
		final EList<? extends EObject> Suffix_30_list = PostfixExpression_29_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_30_list);
		Assert.assertEquals(1, Suffix_30_list.size());
		//30
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_31_Var
		 = (PostfixExpressionSuffixArgument)Suffix_30_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_31_Var
		);
		//31
		final ArgumentExpressionList ArgumentExpressionList_32_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_31_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_32_Var
		);
		final EList<? extends EObject> Expr_32_list = ArgumentExpressionList_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final AssignmentExpression AssignmentExpression_33_Var
		 = (AssignmentExpression)Expr_32_list.get(0);
		Assert.assertNotNull(AssignmentExpression_33_Var
		);
		//33
		final ConditionalExpression ConditionalExpression_34_Var
		 = (ConditionalExpression)AssignmentExpression_33_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_34_Var
		);
		//34
		final LogicalOrExpression LogicalOrExpression_35_Var
		 = (LogicalOrExpression)ConditionalExpression_34_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = LogicalOrExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final LogicalAndExpression LogicalAndExpression_36_Var
		 = (LogicalAndExpression)Expr_35_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = LogicalAndExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final InclusiveOrExpression InclusiveOrExpression_37_Var
		 = (InclusiveOrExpression)Expr_36_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = InclusiveOrExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final ExclusiveOrExpression ExclusiveOrExpression_38_Var
		 = (ExclusiveOrExpression)Expr_37_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = ExclusiveOrExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final AndExpression AndExpression_39_Var
		 = (AndExpression)Expr_38_list.get(0);
		Assert.assertNotNull(AndExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = AndExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final EqualityExpression EqualityExpression_40_Var
		 = (EqualityExpression)Expr_39_list.get(0);
		Assert.assertNotNull(EqualityExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = EqualityExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final RelationalExpression RelationalExpression_41_Var
		 = (RelationalExpression)Expr_40_list.get(0);
		Assert.assertNotNull(RelationalExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = RelationalExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final ShiftExpression ShiftExpression_42_Var
		 = (ShiftExpression)Expr_41_list.get(0);
		Assert.assertNotNull(ShiftExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = ShiftExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final AdditiveExpression AdditiveExpression_43_Var
		 = (AdditiveExpression)Expr_42_list.get(0);
		Assert.assertNotNull(AdditiveExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = AdditiveExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final MultiplicativeExpression MultiplicativeExpression_44_Var
		 = (MultiplicativeExpression)Expr_43_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = MultiplicativeExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final CastExpression CastExpression_45_Var
		 = (CastExpression)Expr_44_list.get(0);
		Assert.assertNotNull(CastExpression_45_Var
		);
		//45
		final UnaryExpression UnaryExpression_46_Var
		 = (UnaryExpression)CastExpression_45_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_46_Var
		);
		//46
		final PostfixExpression PostfixExpression_47_Var
		 = (PostfixExpression)UnaryExpression_46_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = PostfixExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final PrimaryExpression PrimaryExpression_48_Var
		 = (PrimaryExpression)Expr_47_list.get(0);
		Assert.assertNotNull(PrimaryExpression_48_Var
		);
		Assert.assertEquals("[\"abc\", \"def\"]", PrimaryExpression_48_Var
		.getString().toString());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0060_MultipleStringsInArgument.c");
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
				method.invoke(this.generator, "Test0060_MultipleStringsInArgument.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0060_MultipleStringsInArgument.c");
		final String expected = this.getTextFromFile(
			"res/Test0060_MultipleStringsInArgument.c"
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


