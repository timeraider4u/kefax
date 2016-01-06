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
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
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
public class Test0048_IfDefined {
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
			"res/Test0048_IfDefined.c");
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
				"RULE_IF",
				"RULE_WHITESPACE",
				"RULE_DEFINED",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ANDAND",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_GREATEREQUAL",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
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
			"res/Test0048_IfDefined.c");
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
		Assert.assertEquals(2, Lines_1_list.size());
		//1
		final PreprocessorDirectives PreprocessorDirectives_2_Var
		 = (PreprocessorDirectives)Lines_1_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_2_Var
		);
		//2
		final DefineObjectMacro DefineObjectMacro_3_Var
		 = (DefineObjectMacro)PreprocessorDirectives_2_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_3_Var
		);
		Assert.assertEquals("FOO", DefineObjectMacro_3_Var
		.getId());
		Assert.assertEquals("64", DefineObjectMacro_3_Var
		.getString());
		//3
		final PreprocessorDirectives PreprocessorDirectives_4_Var
		 = (PreprocessorDirectives)Lines_1_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_4_Var
		);
		//4
		final ConditionalDirective ConditionalDirective_5_Var
		 = (ConditionalDirective)PreprocessorDirectives_4_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_5_Var
		);
		//5
		final IfConditional IfConditional_6_Var
		 = (IfConditional)ConditionalDirective_5_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_6_Var
		);
		//6
		final ConstantExpression ConstantExpression_7_Var
		 = (ConstantExpression)IfConditional_6_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_7_Var
		);
		//7
		final ConditionalExpression ConditionalExpression_8_Var
		 = (ConditionalExpression)ConstantExpression_7_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_8_Var
		);
		//8
		final LogicalOrExpression LogicalOrExpression_9_Var
		 = (LogicalOrExpression)ConditionalExpression_8_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_9_Var
		);
		final EList<? extends EObject> Expr_9_list = LogicalOrExpression_9_Var
		.getExpr();
		Assert.assertNotNull(Expr_9_list);
		Assert.assertEquals(1, Expr_9_list.size());
		//9
		final LogicalAndExpression LogicalAndExpression_10_Var
		 = (LogicalAndExpression)Expr_9_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_10_Var
		);
		final EList<? extends EObject> Expr_10_list = LogicalAndExpression_10_Var
		.getExpr();
		Assert.assertNotNull(Expr_10_list);
		Assert.assertEquals(2, Expr_10_list.size());
		//10
		final InclusiveOrExpression InclusiveOrExpression_11_Var
		 = (InclusiveOrExpression)Expr_10_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_11_Var
		);
		final EList<? extends EObject> Expr_11_list = InclusiveOrExpression_11_Var
		.getExpr();
		Assert.assertNotNull(Expr_11_list);
		Assert.assertEquals(1, Expr_11_list.size());
		//11
		final ExclusiveOrExpression ExclusiveOrExpression_12_Var
		 = (ExclusiveOrExpression)Expr_11_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_12_Var
		);
		final EList<? extends EObject> Expr_12_list = ExclusiveOrExpression_12_Var
		.getExpr();
		Assert.assertNotNull(Expr_12_list);
		Assert.assertEquals(1, Expr_12_list.size());
		//12
		final AndExpression AndExpression_13_Var
		 = (AndExpression)Expr_12_list.get(0);
		Assert.assertNotNull(AndExpression_13_Var
		);
		final EList<? extends EObject> Expr_13_list = AndExpression_13_Var
		.getExpr();
		Assert.assertNotNull(Expr_13_list);
		Assert.assertEquals(1, Expr_13_list.size());
		//13
		final EqualityExpression EqualityExpression_14_Var
		 = (EqualityExpression)Expr_13_list.get(0);
		Assert.assertNotNull(EqualityExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = EqualityExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		//14
		final RelationalExpression RelationalExpression_15_Var
		 = (RelationalExpression)Expr_14_list.get(0);
		Assert.assertNotNull(RelationalExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = RelationalExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final ShiftExpression ShiftExpression_16_Var
		 = (ShiftExpression)Expr_15_list.get(0);
		Assert.assertNotNull(ShiftExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = ShiftExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final AdditiveExpression AdditiveExpression_17_Var
		 = (AdditiveExpression)Expr_16_list.get(0);
		Assert.assertNotNull(AdditiveExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = AdditiveExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final MultiplicativeExpression MultiplicativeExpression_18_Var
		 = (MultiplicativeExpression)Expr_17_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = MultiplicativeExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final CastExpression CastExpression_19_Var
		 = (CastExpression)Expr_18_list.get(0);
		Assert.assertNotNull(CastExpression_19_Var
		);
		//19
		final UnaryExpression UnaryExpression_20_Var
		 = (UnaryExpression)CastExpression_19_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_20_Var
		);
		//20
		final PostfixExpression PostfixExpression_21_Var
		 = (PostfixExpression)UnaryExpression_20_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_21_Var
		);
		//21
		final PrimaryExpression PrimaryExpression_22_Var
		 = (PrimaryExpression)PostfixExpression_21_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_22_Var
		);
		Assert.assertTrue(PrimaryExpression_22_Var
		.isDefined());
		Assert.assertEquals("FOO", PrimaryExpression_22_Var
		.getId());
		//22
		final InclusiveOrExpression InclusiveOrExpression_23_Var
		 = (InclusiveOrExpression)Expr_10_list.get(1);
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
		Assert.assertEquals("[>=]", RelationalExpression_27_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_27_list = RelationalExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(2, Expr_27_list.size());
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
		//33
		final PrimaryExpression PrimaryExpression_34_Var
		 = (PrimaryExpression)PostfixExpression_33_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_34_Var
		);
		Assert.assertEquals("FOO", PrimaryExpression_34_Var
		.getId());
		//34
		final ShiftExpression ShiftExpression_35_Var
		 = (ShiftExpression)Expr_27_list.get(1);
		Assert.assertNotNull(ShiftExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = ShiftExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final AdditiveExpression AdditiveExpression_36_Var
		 = (AdditiveExpression)Expr_35_list.get(0);
		Assert.assertNotNull(AdditiveExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = AdditiveExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final MultiplicativeExpression MultiplicativeExpression_37_Var
		 = (MultiplicativeExpression)Expr_36_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = MultiplicativeExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final CastExpression CastExpression_38_Var
		 = (CastExpression)Expr_37_list.get(0);
		Assert.assertNotNull(CastExpression_38_Var
		);
		//38
		final UnaryExpression UnaryExpression_39_Var
		 = (UnaryExpression)CastExpression_38_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_39_Var
		);
		//39
		final PostfixExpression PostfixExpression_40_Var
		 = (PostfixExpression)UnaryExpression_39_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_40_Var
		);
		//40
		final PrimaryExpression PrimaryExpression_41_Var
		 = (PrimaryExpression)PostfixExpression_40_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_41_Var
		);
		Assert.assertEquals("64", PrimaryExpression_41_Var
		.getConst());
		//41
		final GroupOpt GroupOpt_42_Var
		 = (GroupOpt)IfConditional_6_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_42_Var
		);
		final EList<? extends EObject> Lines_42_list = GroupOpt_42_Var
		.getLines();
		Assert.assertNotNull(Lines_42_list);
		Assert.assertEquals(1, Lines_42_list.size());
		//42
		final Code Code_43_Var
		 = (Code)Lines_42_list.get(0);
		Assert.assertNotNull(Code_43_Var
		);
		Assert.assertEquals("	void size_64();", Code_43_Var
		.getCode());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0048_IfDefined.c");
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
				method.invoke(this.generator, "Test0048_IfDefined.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0048_IfDefined.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0048_IfDefined.c"
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


