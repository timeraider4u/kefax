package at.jku.weiner.c.common.xtexttests;

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
import at.jku.weiner.c.common.tests.CommonInjectorProvider;
import at.jku.weiner.c.common.parser.antlr.CommonParser;
import at.jku.weiner.c.common.parser.antlr.internal.InternalCommonLexer;
import at.jku.weiner.c.common.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.common.common.Expression;
import at.jku.weiner.c.common.common.ConditionalExpression;
import at.jku.weiner.c.common.common.LogicalOrExpression;
import at.jku.weiner.c.common.common.LogicalAndExpression;
import at.jku.weiner.c.common.common.InclusiveOrExpression;
import at.jku.weiner.c.common.common.ExclusiveOrExpression;
import at.jku.weiner.c.common.common.AndExpression;
import at.jku.weiner.c.common.common.EqualityExpression;
import at.jku.weiner.c.common.common.RelationalExpression;
import at.jku.weiner.c.common.common.ShiftExpression;
import at.jku.weiner.c.common.common.AdditiveExpression;
import at.jku.weiner.c.common.common.MultiplicativeExpression;
import at.jku.weiner.c.common.common.CastExpression;
import at.jku.weiner.c.common.common.UnaryExpression;
import at.jku.weiner.c.common.common.PostfixExpression;
import at.jku.weiner.c.common.common.PrimaryExpression;
import at.jku.weiner.c.common.common.Expression;
import at.jku.weiner.c.common.common.ConditionalExpression;
import at.jku.weiner.c.common.common.LogicalOrExpression;
import at.jku.weiner.c.common.common.LogicalAndExpression;
import at.jku.weiner.c.common.common.InclusiveOrExpression;
import at.jku.weiner.c.common.common.ExclusiveOrExpression;
import at.jku.weiner.c.common.common.AndExpression;
import at.jku.weiner.c.common.common.EqualityExpression;
import at.jku.weiner.c.common.common.RelationalExpression;
import at.jku.weiner.c.common.common.ShiftExpression;
import at.jku.weiner.c.common.common.AdditiveExpression;
import at.jku.weiner.c.common.common.MultiplicativeExpression;
import at.jku.weiner.c.common.common.CastExpression;
import at.jku.weiner.c.common.common.UnaryExpression;
import at.jku.weiner.c.common.common.PostfixExpression;
import at.jku.weiner.c.common.common.PrimaryExpression;
import at.jku.weiner.c.common.common.MultiplicativeExpression;
import at.jku.weiner.c.common.common.CastExpression;
import at.jku.weiner.c.common.common.UnaryExpression;
import at.jku.weiner.c.common.common.PostfixExpression;
import at.jku.weiner.c.common.common.PrimaryExpression;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CommonInjectorProvider.class)
public class Test0003_Parentheses {
	@Inject
	private ParseHelper<Expression> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalCommonLexer lexer;
	@Inject
	private CommonParser parser;
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
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("txt",
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
			"res/Test0003_Parentheses.txt");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_PLUS",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0003_Parentheses.txt");
		final Expression Expression_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(Expression_0_Var
		);
		
		Assert.assertNotNull(Expression_0_Var
		);
		//0
		final ConditionalExpression ConditionalExpression_1_Var
		 = (ConditionalExpression)Expression_0_Var
		.getExpression();
		Assert.assertNotNull(ConditionalExpression_1_Var
		);
		//1
		final LogicalOrExpression LogicalOrExpression_2_Var
		 = (LogicalOrExpression)ConditionalExpression_1_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_2_Var
		);
		final EList<? extends EObject> Expr_2_list = LogicalOrExpression_2_Var
		.getExpr();
		Assert.assertNotNull(Expr_2_list);
		Assert.assertEquals(1, Expr_2_list.size());
		//2
		final LogicalAndExpression LogicalAndExpression_3_Var
		 = (LogicalAndExpression)Expr_2_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_3_Var
		);
		final EList<? extends EObject> Expr_3_list = LogicalAndExpression_3_Var
		.getExpr();
		Assert.assertNotNull(Expr_3_list);
		Assert.assertEquals(1, Expr_3_list.size());
		//3
		final InclusiveOrExpression InclusiveOrExpression_4_Var
		 = (InclusiveOrExpression)Expr_3_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_4_Var
		);
		final EList<? extends EObject> Expr_4_list = InclusiveOrExpression_4_Var
		.getExpr();
		Assert.assertNotNull(Expr_4_list);
		Assert.assertEquals(1, Expr_4_list.size());
		//4
		final ExclusiveOrExpression ExclusiveOrExpression_5_Var
		 = (ExclusiveOrExpression)Expr_4_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_5_Var
		);
		final EList<? extends EObject> Expr_5_list = ExclusiveOrExpression_5_Var
		.getExpr();
		Assert.assertNotNull(Expr_5_list);
		Assert.assertEquals(1, Expr_5_list.size());
		//5
		final AndExpression AndExpression_6_Var
		 = (AndExpression)Expr_5_list.get(0);
		Assert.assertNotNull(AndExpression_6_Var
		);
		final EList<? extends EObject> Expr_6_list = AndExpression_6_Var
		.getExpr();
		Assert.assertNotNull(Expr_6_list);
		Assert.assertEquals(1, Expr_6_list.size());
		//6
		final EqualityExpression EqualityExpression_7_Var
		 = (EqualityExpression)Expr_6_list.get(0);
		Assert.assertNotNull(EqualityExpression_7_Var
		);
		final EList<? extends EObject> Expr_7_list = EqualityExpression_7_Var
		.getExpr();
		Assert.assertNotNull(Expr_7_list);
		Assert.assertEquals(1, Expr_7_list.size());
		//7
		final RelationalExpression RelationalExpression_8_Var
		 = (RelationalExpression)Expr_7_list.get(0);
		Assert.assertNotNull(RelationalExpression_8_Var
		);
		final EList<? extends EObject> Expr_8_list = RelationalExpression_8_Var
		.getExpr();
		Assert.assertNotNull(Expr_8_list);
		Assert.assertEquals(1, Expr_8_list.size());
		//8
		final ShiftExpression ShiftExpression_9_Var
		 = (ShiftExpression)Expr_8_list.get(0);
		Assert.assertNotNull(ShiftExpression_9_Var
		);
		final EList<? extends EObject> Expr_9_list = ShiftExpression_9_Var
		.getExpr();
		Assert.assertNotNull(Expr_9_list);
		Assert.assertEquals(1, Expr_9_list.size());
		//9
		final AdditiveExpression AdditiveExpression_10_Var
		 = (AdditiveExpression)Expr_9_list.get(0);
		Assert.assertNotNull(AdditiveExpression_10_Var
		);
		final EList<? extends EObject> Expr_10_list = AdditiveExpression_10_Var
		.getExpr();
		Assert.assertNotNull(Expr_10_list);
		Assert.assertEquals(1, Expr_10_list.size());
		//10
		final MultiplicativeExpression MultiplicativeExpression_11_Var
		 = (MultiplicativeExpression)Expr_10_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_11_Var
		);
		final EList<? extends EObject> Expr_11_list = MultiplicativeExpression_11_Var
		.getExpr();
		Assert.assertNotNull(Expr_11_list);
		Assert.assertEquals(1, Expr_11_list.size());
		//11
		final CastExpression CastExpression_12_Var
		 = (CastExpression)Expr_11_list.get(0);
		Assert.assertNotNull(CastExpression_12_Var
		);
		//12
		final UnaryExpression UnaryExpression_13_Var
		 = (UnaryExpression)CastExpression_12_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_13_Var
		);
		//13
		final PostfixExpression PostfixExpression_14_Var
		 = (PostfixExpression)UnaryExpression_13_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_14_Var
		);
		//14
		final PrimaryExpression PrimaryExpression_15_Var
		 = (PrimaryExpression)PostfixExpression_14_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_15_Var
		);
		//15
		final Expression Expression_16_Var
		 = (Expression)PrimaryExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expression_16_Var
		);
		//16
		final ConditionalExpression ConditionalExpression_17_Var
		 = (ConditionalExpression)Expression_16_Var
		.getExpression();
		Assert.assertNotNull(ConditionalExpression_17_Var
		);
		//17
		final LogicalOrExpression LogicalOrExpression_18_Var
		 = (LogicalOrExpression)ConditionalExpression_17_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = LogicalOrExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final LogicalAndExpression LogicalAndExpression_19_Var
		 = (LogicalAndExpression)Expr_18_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = LogicalAndExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final InclusiveOrExpression InclusiveOrExpression_20_Var
		 = (InclusiveOrExpression)Expr_19_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = InclusiveOrExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final ExclusiveOrExpression ExclusiveOrExpression_21_Var
		 = (ExclusiveOrExpression)Expr_20_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = ExclusiveOrExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final AndExpression AndExpression_22_Var
		 = (AndExpression)Expr_21_list.get(0);
		Assert.assertNotNull(AndExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = AndExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final EqualityExpression EqualityExpression_23_Var
		 = (EqualityExpression)Expr_22_list.get(0);
		Assert.assertNotNull(EqualityExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = EqualityExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final RelationalExpression RelationalExpression_24_Var
		 = (RelationalExpression)Expr_23_list.get(0);
		Assert.assertNotNull(RelationalExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = RelationalExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final ShiftExpression ShiftExpression_25_Var
		 = (ShiftExpression)Expr_24_list.get(0);
		Assert.assertNotNull(ShiftExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = ShiftExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final AdditiveExpression AdditiveExpression_26_Var
		 = (AdditiveExpression)Expr_25_list.get(0);
		Assert.assertNotNull(AdditiveExpression_26_Var
		);
		Assert.assertEquals("[+]", AdditiveExpression_26_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_26_list = AdditiveExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(2, Expr_26_list.size());
		//26
		final MultiplicativeExpression MultiplicativeExpression_27_Var
		 = (MultiplicativeExpression)Expr_26_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = MultiplicativeExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final CastExpression CastExpression_28_Var
		 = (CastExpression)Expr_27_list.get(0);
		Assert.assertNotNull(CastExpression_28_Var
		);
		//28
		final UnaryExpression UnaryExpression_29_Var
		 = (UnaryExpression)CastExpression_28_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_29_Var
		);
		//29
		final PostfixExpression PostfixExpression_30_Var
		 = (PostfixExpression)UnaryExpression_29_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_30_Var
		);
		//30
		final PrimaryExpression PrimaryExpression_31_Var
		 = (PrimaryExpression)PostfixExpression_30_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_31_Var
		);
		Assert.assertEquals("1", PrimaryExpression_31_Var
		.getConst());
		//31
		final MultiplicativeExpression MultiplicativeExpression_32_Var
		 = (MultiplicativeExpression)Expr_26_list.get(1);
		Assert.assertNotNull(MultiplicativeExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = MultiplicativeExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final CastExpression CastExpression_33_Var
		 = (CastExpression)Expr_32_list.get(0);
		Assert.assertNotNull(CastExpression_33_Var
		);
		//33
		final UnaryExpression UnaryExpression_34_Var
		 = (UnaryExpression)CastExpression_33_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_34_Var
		);
		//34
		final PostfixExpression PostfixExpression_35_Var
		 = (PostfixExpression)UnaryExpression_34_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_35_Var
		);
		//35
		final PrimaryExpression PrimaryExpression_36_Var
		 = (PrimaryExpression)PostfixExpression_35_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_36_Var
		);
		Assert.assertEquals("2", PrimaryExpression_36_Var
		.getConst());
	}
	
	
}


