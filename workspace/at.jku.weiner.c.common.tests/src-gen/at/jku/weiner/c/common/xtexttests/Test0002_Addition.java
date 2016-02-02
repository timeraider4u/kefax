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
import at.jku.weiner.c.common.common.MultiplicativeExpression;
import at.jku.weiner.c.common.common.CastExpression;
import at.jku.weiner.c.common.common.UnaryExpression;
import at.jku.weiner.c.common.common.PostfixExpression;
import at.jku.weiner.c.common.common.PrimaryExpression;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CommonInjectorProvider.class)
public class Test0002_Addition {
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
			"res/Test0002_Addition.txt");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_DECIMAL_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_PLUS",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0002_Addition.txt");
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
		Assert.assertEquals("[+]", AdditiveExpression_10_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_10_list = AdditiveExpression_10_Var
		.getExpr();
		Assert.assertNotNull(Expr_10_list);
		Assert.assertEquals(2, Expr_10_list.size());
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
		Assert.assertEquals("1", PrimaryExpression_15_Var
		.getConst());
		//15
		final MultiplicativeExpression MultiplicativeExpression_16_Var
		 = (MultiplicativeExpression)Expr_10_list.get(1);
		Assert.assertNotNull(MultiplicativeExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = MultiplicativeExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final CastExpression CastExpression_17_Var
		 = (CastExpression)Expr_16_list.get(0);
		Assert.assertNotNull(CastExpression_17_Var
		);
		//17
		final UnaryExpression UnaryExpression_18_Var
		 = (UnaryExpression)CastExpression_17_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_18_Var
		);
		//18
		final PostfixExpression PostfixExpression_19_Var
		 = (PostfixExpression)UnaryExpression_18_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_19_Var
		);
		//19
		final PrimaryExpression PrimaryExpression_20_Var
		 = (PrimaryExpression)PostfixExpression_19_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_20_Var
		);
		Assert.assertEquals("2", PrimaryExpression_20_Var
		.getConst());
	}
	
	
}


