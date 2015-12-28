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
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
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
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.ElIfConditional;
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
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.ElseConditional;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0059_IfElIfElse {
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
			"res/Test0059_IfElIfElse.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_LINE_COMMENT", 
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
				"RULE_ELIF", 
				"RULE_WHITESPACE", 
				"RULE_DEFINED", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
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
				"RULE_ELSE", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
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
			"res/Test0059_IfElIfElse.c");
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
		final NewLineLine NewLineLine_2_Var
		 = (NewLineLine)Lines_1_list.get(0);
		Assert.assertNotNull(NewLineLine_2_Var
		);
		//2
		final PreprocessorDirectives PreprocessorDirectives_3_Var
		 = (PreprocessorDirectives)Lines_1_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_3_Var
		);
		//3
		final DefineDirective DefineDirective_4_Var
		 = (DefineDirective)PreprocessorDirectives_3_Var
		.getDirective();
		Assert.assertNotNull(DefineDirective_4_Var
		);
		Assert.assertEquals("BAR", DefineDirective_4_Var
		.getId());
		Assert.assertEquals("0", DefineDirective_4_Var
		.getString());
		//4
		final PreprocessorDirectives PreprocessorDirectives_5_Var
		 = (PreprocessorDirectives)Lines_1_list.get(2);
		Assert.assertNotNull(PreprocessorDirectives_5_Var
		);
		//5
		final ConditionalDirective ConditionalDirective_6_Var
		 = (ConditionalDirective)PreprocessorDirectives_5_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_6_Var
		);
		//6
		final IfConditional IfConditional_7_Var
		 = (IfConditional)ConditionalDirective_6_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_7_Var
		);
		//7
		final ConstantExpression ConstantExpression_8_Var
		 = (ConstantExpression)IfConditional_7_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_8_Var
		);
		//8
		final ConditionalExpression ConditionalExpression_9_Var
		 = (ConditionalExpression)ConstantExpression_8_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_9_Var
		);
		//9
		final LogicalOrExpression LogicalOrExpression_10_Var
		 = (LogicalOrExpression)ConditionalExpression_9_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_10_Var
		);
		final EList<? extends EObject> Expr_10_list = LogicalOrExpression_10_Var
		.getExpr();
		Assert.assertNotNull(Expr_10_list);
		Assert.assertEquals(1, Expr_10_list.size());
		//10
		final LogicalAndExpression LogicalAndExpression_11_Var
		 = (LogicalAndExpression)Expr_10_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_11_Var
		);
		final EList<? extends EObject> Expr_11_list = LogicalAndExpression_11_Var
		.getExpr();
		Assert.assertNotNull(Expr_11_list);
		Assert.assertEquals(1, Expr_11_list.size());
		//11
		final InclusiveOrExpression InclusiveOrExpression_12_Var
		 = (InclusiveOrExpression)Expr_11_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_12_Var
		);
		final EList<? extends EObject> Expr_12_list = InclusiveOrExpression_12_Var
		.getExpr();
		Assert.assertNotNull(Expr_12_list);
		Assert.assertEquals(1, Expr_12_list.size());
		//12
		final ExclusiveOrExpression ExclusiveOrExpression_13_Var
		 = (ExclusiveOrExpression)Expr_12_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_13_Var
		);
		final EList<? extends EObject> Expr_13_list = ExclusiveOrExpression_13_Var
		.getExpr();
		Assert.assertNotNull(Expr_13_list);
		Assert.assertEquals(1, Expr_13_list.size());
		//13
		final AndExpression AndExpression_14_Var
		 = (AndExpression)Expr_13_list.get(0);
		Assert.assertNotNull(AndExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = AndExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		//14
		final EqualityExpression EqualityExpression_15_Var
		 = (EqualityExpression)Expr_14_list.get(0);
		Assert.assertNotNull(EqualityExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = EqualityExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final RelationalExpression RelationalExpression_16_Var
		 = (RelationalExpression)Expr_15_list.get(0);
		Assert.assertNotNull(RelationalExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = RelationalExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final ShiftExpression ShiftExpression_17_Var
		 = (ShiftExpression)Expr_16_list.get(0);
		Assert.assertNotNull(ShiftExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = ShiftExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final AdditiveExpression AdditiveExpression_18_Var
		 = (AdditiveExpression)Expr_17_list.get(0);
		Assert.assertNotNull(AdditiveExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = AdditiveExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final MultiplicativeExpression MultiplicativeExpression_19_Var
		 = (MultiplicativeExpression)Expr_18_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = MultiplicativeExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final CastExpression CastExpression_20_Var
		 = (CastExpression)Expr_19_list.get(0);
		Assert.assertNotNull(CastExpression_20_Var
		);
		//20
		final UnaryExpression UnaryExpression_21_Var
		 = (UnaryExpression)CastExpression_20_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_21_Var
		);
		//21
		final PostfixExpression PostfixExpression_22_Var
		 = (PostfixExpression)UnaryExpression_21_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_22_Var
		);
		//22
		final PrimaryExpression PrimaryExpression_23_Var
		 = (PrimaryExpression)PostfixExpression_22_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_23_Var
		);
		Assert.assertTrue(PrimaryExpression_23_Var
		.isDefined());
		Assert.assertEquals("FOO", PrimaryExpression_23_Var
		.getId());
		//23
		final GroupOpt GroupOpt_24_Var
		 = (GroupOpt)IfConditional_7_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_24_Var
		);
		final EList<? extends EObject> Lines_24_list = GroupOpt_24_Var
		.getLines();
		Assert.assertNotNull(Lines_24_list);
		Assert.assertEquals(1, Lines_24_list.size());
		//24
		final Code Code_25_Var
		 = (Code)Lines_24_list.get(0);
		Assert.assertNotNull(Code_25_Var
		);
		Assert.assertEquals("	void foo();", Code_25_Var
		.getCode());
		final EList<? extends EObject> Elifs_25_list = ConditionalDirective_6_Var
		.getElifs();
		Assert.assertNotNull(Elifs_25_list);
		Assert.assertEquals(1, Elifs_25_list.size());
		//25
		final ElIfConditional ElIfConditional_26_Var
		 = (ElIfConditional)Elifs_25_list.get(0);
		Assert.assertNotNull(ElIfConditional_26_Var
		);
		//26
		final ConstantExpression ConstantExpression_27_Var
		 = (ConstantExpression)ElIfConditional_26_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_27_Var
		);
		//27
		final ConditionalExpression ConditionalExpression_28_Var
		 = (ConditionalExpression)ConstantExpression_27_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_28_Var
		);
		//28
		final LogicalOrExpression LogicalOrExpression_29_Var
		 = (LogicalOrExpression)ConditionalExpression_28_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = LogicalOrExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final LogicalAndExpression LogicalAndExpression_30_Var
		 = (LogicalAndExpression)Expr_29_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = LogicalAndExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final InclusiveOrExpression InclusiveOrExpression_31_Var
		 = (InclusiveOrExpression)Expr_30_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = InclusiveOrExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final ExclusiveOrExpression ExclusiveOrExpression_32_Var
		 = (ExclusiveOrExpression)Expr_31_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = ExclusiveOrExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final AndExpression AndExpression_33_Var
		 = (AndExpression)Expr_32_list.get(0);
		Assert.assertNotNull(AndExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = AndExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final EqualityExpression EqualityExpression_34_Var
		 = (EqualityExpression)Expr_33_list.get(0);
		Assert.assertNotNull(EqualityExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = EqualityExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final RelationalExpression RelationalExpression_35_Var
		 = (RelationalExpression)Expr_34_list.get(0);
		Assert.assertNotNull(RelationalExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = RelationalExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final ShiftExpression ShiftExpression_36_Var
		 = (ShiftExpression)Expr_35_list.get(0);
		Assert.assertNotNull(ShiftExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = ShiftExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final AdditiveExpression AdditiveExpression_37_Var
		 = (AdditiveExpression)Expr_36_list.get(0);
		Assert.assertNotNull(AdditiveExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = AdditiveExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final MultiplicativeExpression MultiplicativeExpression_38_Var
		 = (MultiplicativeExpression)Expr_37_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = MultiplicativeExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final CastExpression CastExpression_39_Var
		 = (CastExpression)Expr_38_list.get(0);
		Assert.assertNotNull(CastExpression_39_Var
		);
		//39
		final UnaryExpression UnaryExpression_40_Var
		 = (UnaryExpression)CastExpression_39_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_40_Var
		);
		//40
		final PostfixExpression PostfixExpression_41_Var
		 = (PostfixExpression)UnaryExpression_40_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_41_Var
		);
		//41
		final PrimaryExpression PrimaryExpression_42_Var
		 = (PrimaryExpression)PostfixExpression_41_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_42_Var
		);
		Assert.assertTrue(PrimaryExpression_42_Var
		.isDefined());
		Assert.assertEquals("BAR", PrimaryExpression_42_Var
		.getId());
		//42
		final GroupOpt GroupOpt_43_Var
		 = (GroupOpt)ElIfConditional_26_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_43_Var
		);
		final EList<? extends EObject> Lines_43_list = GroupOpt_43_Var
		.getLines();
		Assert.assertNotNull(Lines_43_list);
		Assert.assertEquals(1, Lines_43_list.size());
		//43
		final Code Code_44_Var
		 = (Code)Lines_43_list.get(0);
		Assert.assertNotNull(Code_44_Var
		);
		Assert.assertEquals("	void bar();", Code_44_Var
		.getCode());
		//44
		final ElseConditional ElseConditional_45_Var
		 = (ElseConditional)ConditionalDirective_6_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_45_Var
		);
		//45
		final GroupOpt GroupOpt_46_Var
		 = (GroupOpt)ElseConditional_45_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_46_Var
		);
		final EList<? extends EObject> Lines_46_list = GroupOpt_46_Var
		.getLines();
		Assert.assertNotNull(Lines_46_list);
		Assert.assertEquals(1, Lines_46_list.size());
		//46
		final Code Code_47_Var
		 = (Code)Lines_46_list.get(0);
		Assert.assertNotNull(Code_47_Var
		);
		Assert.assertEquals("	void no_foo_and_no_bar();", Code_47_Var
		.getCode());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0059_IfElIfElse.c");
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
				method.invoke(this.generator, "Test0059_IfElIfElse.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0059_IfElIfElse.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0059_IfElIfElse.c"
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


