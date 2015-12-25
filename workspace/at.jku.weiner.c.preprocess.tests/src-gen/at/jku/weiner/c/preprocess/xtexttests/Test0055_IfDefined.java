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

import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.common.common.TranslationUnit;
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
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0055_IfDefined {
	@Inject
	private ParseHelper<Model> parseHelper;
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
	
	@Test
	public void checkLexerTokens() throws Exception{
		final String text = this.getTextFromFile(
			"res/Test0055_IfDefined.c");
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
				"RULE_DEFINED", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ANDAND", 
				"RULE_WHITESPACE", 
				"RULE_DEFINED", 
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
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0055_IfDefined.c");
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
		final Preprocess Preprocess_2_Var
		 = (Preprocess)TranslationUnit_1_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_2_Var
		);
		//2
		final GroupOpt GroupOpt_3_Var
		 = (GroupOpt)Preprocess_2_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_3_Var
		);
		final EList<? extends EObject> Lines_3_list = GroupOpt_3_Var
		.getLines();
		Assert.assertNotNull(Lines_3_list);
		Assert.assertEquals(3, Lines_3_list.size());
		//3
		final PreprocessorDirectives PreprocessorDirectives_4_Var
		 = (PreprocessorDirectives)Lines_3_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_4_Var
		);
		//4
		final DefineDirective DefineDirective_5_Var
		 = (DefineDirective)PreprocessorDirectives_4_Var
		.getDirective();
		Assert.assertNotNull(DefineDirective_5_Var
		);
		Assert.assertEquals("FOO", DefineDirective_5_Var
		.getId());
		Assert.assertEquals("50", DefineDirective_5_Var
		.getString());
		//5
		final PreprocessorDirectives PreprocessorDirectives_6_Var
		 = (PreprocessorDirectives)Lines_3_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_6_Var
		);
		//6
		final DefineDirective DefineDirective_7_Var
		 = (DefineDirective)PreprocessorDirectives_6_Var
		.getDirective();
		Assert.assertNotNull(DefineDirective_7_Var
		);
		Assert.assertEquals("BAR", DefineDirective_7_Var
		.getId());
		Assert.assertEquals("0", DefineDirective_7_Var
		.getString());
		//7
		final PreprocessorDirectives PreprocessorDirectives_8_Var
		 = (PreprocessorDirectives)Lines_3_list.get(2);
		Assert.assertNotNull(PreprocessorDirectives_8_Var
		);
		//8
		final ConditionalDirective ConditionalDirective_9_Var
		 = (ConditionalDirective)PreprocessorDirectives_8_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_9_Var
		);
		//9
		final IfConditional IfConditional_10_Var
		 = (IfConditional)ConditionalDirective_9_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_10_Var
		);
		//10
		final ConstantExpression ConstantExpression_11_Var
		 = (ConstantExpression)IfConditional_10_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_11_Var
		);
		//11
		final ConditionalExpression ConditionalExpression_12_Var
		 = (ConditionalExpression)ConstantExpression_11_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_12_Var
		);
		//12
		final LogicalOrExpression LogicalOrExpression_13_Var
		 = (LogicalOrExpression)ConditionalExpression_12_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_13_Var
		);
		final EList<? extends EObject> Expr_13_list = LogicalOrExpression_13_Var
		.getExpr();
		Assert.assertNotNull(Expr_13_list);
		Assert.assertEquals(1, Expr_13_list.size());
		//13
		final LogicalAndExpression LogicalAndExpression_14_Var
		 = (LogicalAndExpression)Expr_13_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = LogicalAndExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(2, Expr_14_list.size());
		//14
		final InclusiveOrExpression InclusiveOrExpression_15_Var
		 = (InclusiveOrExpression)Expr_14_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = InclusiveOrExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final ExclusiveOrExpression ExclusiveOrExpression_16_Var
		 = (ExclusiveOrExpression)Expr_15_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = ExclusiveOrExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final AndExpression AndExpression_17_Var
		 = (AndExpression)Expr_16_list.get(0);
		Assert.assertNotNull(AndExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = AndExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final EqualityExpression EqualityExpression_18_Var
		 = (EqualityExpression)Expr_17_list.get(0);
		Assert.assertNotNull(EqualityExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = EqualityExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final RelationalExpression RelationalExpression_19_Var
		 = (RelationalExpression)Expr_18_list.get(0);
		Assert.assertNotNull(RelationalExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = RelationalExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final ShiftExpression ShiftExpression_20_Var
		 = (ShiftExpression)Expr_19_list.get(0);
		Assert.assertNotNull(ShiftExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = ShiftExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final AdditiveExpression AdditiveExpression_21_Var
		 = (AdditiveExpression)Expr_20_list.get(0);
		Assert.assertNotNull(AdditiveExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = AdditiveExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final MultiplicativeExpression MultiplicativeExpression_22_Var
		 = (MultiplicativeExpression)Expr_21_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = MultiplicativeExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final CastExpression CastExpression_23_Var
		 = (CastExpression)Expr_22_list.get(0);
		Assert.assertNotNull(CastExpression_23_Var
		);
		//23
		final UnaryExpression UnaryExpression_24_Var
		 = (UnaryExpression)CastExpression_23_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_24_Var
		);
		//24
		final PostfixExpression PostfixExpression_25_Var
		 = (PostfixExpression)UnaryExpression_24_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_25_Var
		);
		//25
		final PrimaryExpression PrimaryExpression_26_Var
		 = (PrimaryExpression)PostfixExpression_25_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_26_Var
		);
		Assert.assertTrue(PrimaryExpression_26_Var
		.isDefined());
		Assert.assertEquals("FOO", PrimaryExpression_26_Var
		.getId());
		//26
		final InclusiveOrExpression InclusiveOrExpression_27_Var
		 = (InclusiveOrExpression)Expr_14_list.get(1);
		Assert.assertNotNull(InclusiveOrExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = InclusiveOrExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final ExclusiveOrExpression ExclusiveOrExpression_28_Var
		 = (ExclusiveOrExpression)Expr_27_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = ExclusiveOrExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final AndExpression AndExpression_29_Var
		 = (AndExpression)Expr_28_list.get(0);
		Assert.assertNotNull(AndExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = AndExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final EqualityExpression EqualityExpression_30_Var
		 = (EqualityExpression)Expr_29_list.get(0);
		Assert.assertNotNull(EqualityExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = EqualityExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final RelationalExpression RelationalExpression_31_Var
		 = (RelationalExpression)Expr_30_list.get(0);
		Assert.assertNotNull(RelationalExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = RelationalExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final ShiftExpression ShiftExpression_32_Var
		 = (ShiftExpression)Expr_31_list.get(0);
		Assert.assertNotNull(ShiftExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = ShiftExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final AdditiveExpression AdditiveExpression_33_Var
		 = (AdditiveExpression)Expr_32_list.get(0);
		Assert.assertNotNull(AdditiveExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = AdditiveExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final MultiplicativeExpression MultiplicativeExpression_34_Var
		 = (MultiplicativeExpression)Expr_33_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = MultiplicativeExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final CastExpression CastExpression_35_Var
		 = (CastExpression)Expr_34_list.get(0);
		Assert.assertNotNull(CastExpression_35_Var
		);
		//35
		final UnaryExpression UnaryExpression_36_Var
		 = (UnaryExpression)CastExpression_35_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_36_Var
		);
		//36
		final PostfixExpression PostfixExpression_37_Var
		 = (PostfixExpression)UnaryExpression_36_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_37_Var
		);
		//37
		final PrimaryExpression PrimaryExpression_38_Var
		 = (PrimaryExpression)PostfixExpression_37_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_38_Var
		);
		Assert.assertTrue(PrimaryExpression_38_Var
		.isDefined());
		Assert.assertEquals("BAR", PrimaryExpression_38_Var
		.getId());
		//38
		final GroupOpt GroupOpt_39_Var
		 = (GroupOpt)IfConditional_10_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_39_Var
		);
		final EList<? extends EObject> Lines_39_list = GroupOpt_39_Var
		.getLines();
		Assert.assertNotNull(Lines_39_list);
		Assert.assertEquals(1, Lines_39_list.size());
		//39
		final Code Code_40_Var
		 = (Code)Lines_39_list.get(0);
		Assert.assertNotNull(Code_40_Var
		);
		Assert.assertEquals("	void foo_bar();", Code_40_Var
		.getCode());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0055_IfDefined.c");
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
				method.invoke(this.generator, "Test0055_IfDefined.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0055_IfDefined.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0055_IfDefined.c"
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


