package at.jku.weiner.c.preprocess.xtexttests;

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
import at.jku.weiner.c.preprocess.tests.PreprocessInjectorProvider;
import at.jku.weiner.c.preprocess.parser.antlr.PreprocessParser;
import at.jku.weiner.c.preprocess.parser.antlr.internal.InternalPreprocessLexer;
import at.jku.weiner.c.preprocess.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineDirective;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineDirective;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.ConditionalDirective;
import at.jku.weiner.c.preprocess.preprocess.IfConditional;
import at.jku.weiner.c.common.common.ConstantExpression;
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
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.common.common.RelationalExpression;
import at.jku.weiner.c.common.common.ShiftExpression;
import at.jku.weiner.c.common.common.AdditiveExpression;
import at.jku.weiner.c.common.common.MultiplicativeExpression;
import at.jku.weiner.c.common.common.CastExpression;
import at.jku.weiner.c.common.common.UnaryExpression;
import at.jku.weiner.c.common.common.PostfixExpression;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0084_If {
	@Inject
	private ParseHelper<Preprocess> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalPreprocessLexer lexer;
	@Inject
	private PreprocessParser parser;
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
			"res/Test0084_If.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_IF", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_EQUAL", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_ENDIF", 
				"RULE_NEWLINE", 
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0084_If.c");
		final Preprocess Preprocess_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(Preprocess_0_Var
		);
		
		Assert.assertNotNull(Preprocess_0_Var
		);
		//0
		final GroupOpt GroupOpt_1_Var
		 = (GroupOpt)Preprocess_0_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_1_Var
		);
		final EList<? extends EObject> Lines_1_list = GroupOpt_1_Var
		.getLines();
		Assert.assertNotNull(Lines_1_list);
		Assert.assertEquals(3, Lines_1_list.size());
		//1
		final PreprocessorDirectives PreprocessorDirectives_2_Var
		 = (PreprocessorDirectives)Lines_1_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_2_Var
		);
		//2
		final DefineDirective DefineDirective_3_Var
		 = (DefineDirective)PreprocessorDirectives_2_Var
		.getDirective();
		Assert.assertNotNull(DefineDirective_3_Var
		);
		Assert.assertEquals("__FOO", DefineDirective_3_Var
		.getId());
		Assert.assertEquals("1234", DefineDirective_3_Var
		.getString());
		//3
		final PreprocessorDirectives PreprocessorDirectives_4_Var
		 = (PreprocessorDirectives)Lines_1_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_4_Var
		);
		//4
		final DefineDirective DefineDirective_5_Var
		 = (DefineDirective)PreprocessorDirectives_4_Var
		.getDirective();
		Assert.assertNotNull(DefineDirective_5_Var
		);
		Assert.assertEquals("__BAR", DefineDirective_5_Var
		.getId());
		Assert.assertEquals("4321", DefineDirective_5_Var
		.getString());
		//5
		final PreprocessorDirectives PreprocessorDirectives_6_Var
		 = (PreprocessorDirectives)Lines_1_list.get(2);
		Assert.assertNotNull(PreprocessorDirectives_6_Var
		);
		//6
		final ConditionalDirective ConditionalDirective_7_Var
		 = (ConditionalDirective)PreprocessorDirectives_6_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_7_Var
		);
		//7
		final IfConditional IfConditional_8_Var
		 = (IfConditional)ConditionalDirective_7_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_8_Var
		);
		//8
		final ConstantExpression ConstantExpression_9_Var
		 = (ConstantExpression)IfConditional_8_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_9_Var
		);
		//9
		final ConditionalExpression ConditionalExpression_10_Var
		 = (ConditionalExpression)ConstantExpression_9_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_10_Var
		);
		//10
		final LogicalOrExpression LogicalOrExpression_11_Var
		 = (LogicalOrExpression)ConditionalExpression_10_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_11_Var
		);
		final EList<? extends EObject> Expr_11_list = LogicalOrExpression_11_Var
		.getExpr();
		Assert.assertNotNull(Expr_11_list);
		Assert.assertEquals(1, Expr_11_list.size());
		//11
		final LogicalAndExpression LogicalAndExpression_12_Var
		 = (LogicalAndExpression)Expr_11_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_12_Var
		);
		final EList<? extends EObject> Expr_12_list = LogicalAndExpression_12_Var
		.getExpr();
		Assert.assertNotNull(Expr_12_list);
		Assert.assertEquals(1, Expr_12_list.size());
		//12
		final InclusiveOrExpression InclusiveOrExpression_13_Var
		 = (InclusiveOrExpression)Expr_12_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_13_Var
		);
		final EList<? extends EObject> Expr_13_list = InclusiveOrExpression_13_Var
		.getExpr();
		Assert.assertNotNull(Expr_13_list);
		Assert.assertEquals(1, Expr_13_list.size());
		//13
		final ExclusiveOrExpression ExclusiveOrExpression_14_Var
		 = (ExclusiveOrExpression)Expr_13_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = ExclusiveOrExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		//14
		final AndExpression AndExpression_15_Var
		 = (AndExpression)Expr_14_list.get(0);
		Assert.assertNotNull(AndExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = AndExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final EqualityExpression EqualityExpression_16_Var
		 = (EqualityExpression)Expr_15_list.get(0);
		Assert.assertNotNull(EqualityExpression_16_Var
		);
		Assert.assertEquals("[==]", EqualityExpression_16_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_16_list = EqualityExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(2, Expr_16_list.size());
		//16
		final RelationalExpression RelationalExpression_17_Var
		 = (RelationalExpression)Expr_16_list.get(0);
		Assert.assertNotNull(RelationalExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = RelationalExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final ShiftExpression ShiftExpression_18_Var
		 = (ShiftExpression)Expr_17_list.get(0);
		Assert.assertNotNull(ShiftExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = ShiftExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final AdditiveExpression AdditiveExpression_19_Var
		 = (AdditiveExpression)Expr_18_list.get(0);
		Assert.assertNotNull(AdditiveExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = AdditiveExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final MultiplicativeExpression MultiplicativeExpression_20_Var
		 = (MultiplicativeExpression)Expr_19_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = MultiplicativeExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final CastExpression CastExpression_21_Var
		 = (CastExpression)Expr_20_list.get(0);
		Assert.assertNotNull(CastExpression_21_Var
		);
		//21
		final UnaryExpression UnaryExpression_22_Var
		 = (UnaryExpression)CastExpression_21_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_22_Var
		);
		//22
		final PostfixExpression PostfixExpression_23_Var
		 = (PostfixExpression)UnaryExpression_22_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_23_Var
		);
		//23
		final PrimaryExpression PrimaryExpression_24_Var
		 = (PrimaryExpression)PostfixExpression_23_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_24_Var
		);
		Assert.assertEquals("__FOO", PrimaryExpression_24_Var
		.getId());
		//24
		final RelationalExpression RelationalExpression_25_Var
		 = (RelationalExpression)Expr_16_list.get(1);
		Assert.assertNotNull(RelationalExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = RelationalExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final ShiftExpression ShiftExpression_26_Var
		 = (ShiftExpression)Expr_25_list.get(0);
		Assert.assertNotNull(ShiftExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = ShiftExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final AdditiveExpression AdditiveExpression_27_Var
		 = (AdditiveExpression)Expr_26_list.get(0);
		Assert.assertNotNull(AdditiveExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = AdditiveExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final MultiplicativeExpression MultiplicativeExpression_28_Var
		 = (MultiplicativeExpression)Expr_27_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = MultiplicativeExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final CastExpression CastExpression_29_Var
		 = (CastExpression)Expr_28_list.get(0);
		Assert.assertNotNull(CastExpression_29_Var
		);
		//29
		final UnaryExpression UnaryExpression_30_Var
		 = (UnaryExpression)CastExpression_29_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_30_Var
		);
		//30
		final PostfixExpression PostfixExpression_31_Var
		 = (PostfixExpression)UnaryExpression_30_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_31_Var
		);
		//31
		final PrimaryExpression PrimaryExpression_32_Var
		 = (PrimaryExpression)PostfixExpression_31_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_32_Var
		);
		Assert.assertEquals("__BAR", PrimaryExpression_32_Var
		.getId());
		//32
		final GroupOpt GroupOpt_33_Var
		 = (GroupOpt)IfConditional_8_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_33_Var
		);
		final EList<? extends EObject> Lines_33_list = GroupOpt_33_Var
		.getLines();
		Assert.assertNotNull(Lines_33_list);
		Assert.assertEquals(1, Lines_33_list.size());
		//33
		final Code Code_34_Var
		 = (Code)Lines_33_list.get(0);
		Assert.assertNotNull(Code_34_Var
		);
		Assert.assertEquals("	void doSomething();", Code_34_Var
		.getCode());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0084_If.c");
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
				method.invoke(this.generator, "Test0084_If.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0084_If.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0084_If.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
		// System.out.println("Code generation finished.");
	}
	
	private String preprocess(String string) throws Exception {
		string = preprocessForPatterns(string);
		return string;
	}
	
	
	private String preprocessForPatterns(String string) {
		return string;
	}
	
}


