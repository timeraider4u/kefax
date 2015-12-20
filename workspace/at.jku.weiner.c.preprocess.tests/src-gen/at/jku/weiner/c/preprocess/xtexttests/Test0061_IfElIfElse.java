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

import at.jku.weiner.c.preprocess.preprocess.Model;
import at.jku.weiner.c.preprocess.preprocess.TranslationUnit;
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
public class Test0061_IfElIfElse {
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
			"res/Test0061_IfElIfElse.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_IF", 
				"RULE_WS", 
				"RULE_DEFINED", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_ELIF", 
				"RULE_WS", 
				"RULE_DEFINED", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_ELSE", 
				"RULE_NEWLINE", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
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
			"res/Test0061_IfElIfElse.c");
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
		final GroupOpt GroupOpt_2_Var
		 = (GroupOpt)TranslationUnit_1_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_2_Var
		);
		final EList<? extends EObject> Lines_2_list = GroupOpt_2_Var
		.getLines();
		Assert.assertNotNull(Lines_2_list);
		Assert.assertEquals(3, Lines_2_list.size());
		//2
		final PreprocessorDirectives PreprocessorDirectives_3_Var
		 = (PreprocessorDirectives)Lines_2_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_3_Var
		);
		//3
		final DefineDirective DefineDirective_4_Var
		 = (DefineDirective)PreprocessorDirectives_3_Var
		.getDirective();
		Assert.assertNotNull(DefineDirective_4_Var
		);
		Assert.assertEquals("FOO", DefineDirective_4_Var
		.getId());
		Assert.assertEquals("50", DefineDirective_4_Var
		.getString());
		//4
		final PreprocessorDirectives PreprocessorDirectives_5_Var
		 = (PreprocessorDirectives)Lines_2_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_5_Var
		);
		//5
		final DefineDirective DefineDirective_6_Var
		 = (DefineDirective)PreprocessorDirectives_5_Var
		.getDirective();
		Assert.assertNotNull(DefineDirective_6_Var
		);
		Assert.assertEquals("BAR", DefineDirective_6_Var
		.getId());
		Assert.assertEquals("0", DefineDirective_6_Var
		.getString());
		//6
		final PreprocessorDirectives PreprocessorDirectives_7_Var
		 = (PreprocessorDirectives)Lines_2_list.get(2);
		Assert.assertNotNull(PreprocessorDirectives_7_Var
		);
		//7
		final ConditionalDirective ConditionalDirective_8_Var
		 = (ConditionalDirective)PreprocessorDirectives_7_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_8_Var
		);
		//8
		final IfConditional IfConditional_9_Var
		 = (IfConditional)ConditionalDirective_8_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_9_Var
		);
		//9
		final ConstantExpression ConstantExpression_10_Var
		 = (ConstantExpression)IfConditional_9_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_10_Var
		);
		//10
		final ConditionalExpression ConditionalExpression_11_Var
		 = (ConditionalExpression)ConstantExpression_10_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_11_Var
		);
		//11
		final LogicalOrExpression LogicalOrExpression_12_Var
		 = (LogicalOrExpression)ConditionalExpression_11_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_12_Var
		);
		final EList<? extends EObject> Expr_12_list = LogicalOrExpression_12_Var
		.getExpr();
		Assert.assertNotNull(Expr_12_list);
		Assert.assertEquals(1, Expr_12_list.size());
		//12
		final LogicalAndExpression LogicalAndExpression_13_Var
		 = (LogicalAndExpression)Expr_12_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_13_Var
		);
		final EList<? extends EObject> Expr_13_list = LogicalAndExpression_13_Var
		.getExpr();
		Assert.assertNotNull(Expr_13_list);
		Assert.assertEquals(1, Expr_13_list.size());
		//13
		final InclusiveOrExpression InclusiveOrExpression_14_Var
		 = (InclusiveOrExpression)Expr_13_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = InclusiveOrExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		//14
		final ExclusiveOrExpression ExclusiveOrExpression_15_Var
		 = (ExclusiveOrExpression)Expr_14_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = ExclusiveOrExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final AndExpression AndExpression_16_Var
		 = (AndExpression)Expr_15_list.get(0);
		Assert.assertNotNull(AndExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = AndExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final EqualityExpression EqualityExpression_17_Var
		 = (EqualityExpression)Expr_16_list.get(0);
		Assert.assertNotNull(EqualityExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = EqualityExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final RelationalExpression RelationalExpression_18_Var
		 = (RelationalExpression)Expr_17_list.get(0);
		Assert.assertNotNull(RelationalExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = RelationalExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final ShiftExpression ShiftExpression_19_Var
		 = (ShiftExpression)Expr_18_list.get(0);
		Assert.assertNotNull(ShiftExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = ShiftExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final AdditiveExpression AdditiveExpression_20_Var
		 = (AdditiveExpression)Expr_19_list.get(0);
		Assert.assertNotNull(AdditiveExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = AdditiveExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final MultiplicativeExpression MultiplicativeExpression_21_Var
		 = (MultiplicativeExpression)Expr_20_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = MultiplicativeExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final CastExpression CastExpression_22_Var
		 = (CastExpression)Expr_21_list.get(0);
		Assert.assertNotNull(CastExpression_22_Var
		);
		//22
		final UnaryExpression UnaryExpression_23_Var
		 = (UnaryExpression)CastExpression_22_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_23_Var
		);
		//23
		final PostfixExpression PostfixExpression_24_Var
		 = (PostfixExpression)UnaryExpression_23_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_24_Var
		);
		//24
		final PrimaryExpression PrimaryExpression_25_Var
		 = (PrimaryExpression)PostfixExpression_24_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_25_Var
		);
		Assert.assertTrue(PrimaryExpression_25_Var
		.isDefined());
		Assert.assertEquals("FOO", PrimaryExpression_25_Var
		.getId());
		//25
		final GroupOpt GroupOpt_26_Var
		 = (GroupOpt)IfConditional_9_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_26_Var
		);
		final EList<? extends EObject> Lines_26_list = GroupOpt_26_Var
		.getLines();
		Assert.assertNotNull(Lines_26_list);
		Assert.assertEquals(1, Lines_26_list.size());
		//26
		final Code Code_27_Var
		 = (Code)Lines_26_list.get(0);
		Assert.assertNotNull(Code_27_Var
		);
		Assert.assertEquals("	void foo();", Code_27_Var
		.getCode());
		final EList<? extends EObject> Elifs_27_list = ConditionalDirective_8_Var
		.getElifs();
		Assert.assertNotNull(Elifs_27_list);
		Assert.assertEquals(1, Elifs_27_list.size());
		//27
		final ElIfConditional ElIfConditional_28_Var
		 = (ElIfConditional)Elifs_27_list.get(0);
		Assert.assertNotNull(ElIfConditional_28_Var
		);
		//28
		final ConstantExpression ConstantExpression_29_Var
		 = (ConstantExpression)ElIfConditional_28_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_29_Var
		);
		//29
		final ConditionalExpression ConditionalExpression_30_Var
		 = (ConditionalExpression)ConstantExpression_29_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_30_Var
		);
		//30
		final LogicalOrExpression LogicalOrExpression_31_Var
		 = (LogicalOrExpression)ConditionalExpression_30_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = LogicalOrExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final LogicalAndExpression LogicalAndExpression_32_Var
		 = (LogicalAndExpression)Expr_31_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = LogicalAndExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final InclusiveOrExpression InclusiveOrExpression_33_Var
		 = (InclusiveOrExpression)Expr_32_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = InclusiveOrExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final ExclusiveOrExpression ExclusiveOrExpression_34_Var
		 = (ExclusiveOrExpression)Expr_33_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = ExclusiveOrExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final AndExpression AndExpression_35_Var
		 = (AndExpression)Expr_34_list.get(0);
		Assert.assertNotNull(AndExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = AndExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final EqualityExpression EqualityExpression_36_Var
		 = (EqualityExpression)Expr_35_list.get(0);
		Assert.assertNotNull(EqualityExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = EqualityExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final RelationalExpression RelationalExpression_37_Var
		 = (RelationalExpression)Expr_36_list.get(0);
		Assert.assertNotNull(RelationalExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = RelationalExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final ShiftExpression ShiftExpression_38_Var
		 = (ShiftExpression)Expr_37_list.get(0);
		Assert.assertNotNull(ShiftExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = ShiftExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final AdditiveExpression AdditiveExpression_39_Var
		 = (AdditiveExpression)Expr_38_list.get(0);
		Assert.assertNotNull(AdditiveExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = AdditiveExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final MultiplicativeExpression MultiplicativeExpression_40_Var
		 = (MultiplicativeExpression)Expr_39_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = MultiplicativeExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final CastExpression CastExpression_41_Var
		 = (CastExpression)Expr_40_list.get(0);
		Assert.assertNotNull(CastExpression_41_Var
		);
		//41
		final UnaryExpression UnaryExpression_42_Var
		 = (UnaryExpression)CastExpression_41_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_42_Var
		);
		//42
		final PostfixExpression PostfixExpression_43_Var
		 = (PostfixExpression)UnaryExpression_42_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_43_Var
		);
		//43
		final PrimaryExpression PrimaryExpression_44_Var
		 = (PrimaryExpression)PostfixExpression_43_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_44_Var
		);
		Assert.assertTrue(PrimaryExpression_44_Var
		.isDefined());
		Assert.assertEquals("BAR", PrimaryExpression_44_Var
		.getId());
		//44
		final GroupOpt GroupOpt_45_Var
		 = (GroupOpt)ElIfConditional_28_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_45_Var
		);
		final EList<? extends EObject> Lines_45_list = GroupOpt_45_Var
		.getLines();
		Assert.assertNotNull(Lines_45_list);
		Assert.assertEquals(1, Lines_45_list.size());
		//45
		final Code Code_46_Var
		 = (Code)Lines_45_list.get(0);
		Assert.assertNotNull(Code_46_Var
		);
		Assert.assertEquals("	void bar();", Code_46_Var
		.getCode());
		//46
		final ElseConditional ElseConditional_47_Var
		 = (ElseConditional)ConditionalDirective_8_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_47_Var
		);
		//47
		final GroupOpt GroupOpt_48_Var
		 = (GroupOpt)ElseConditional_47_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_48_Var
		);
		final EList<? extends EObject> Lines_48_list = GroupOpt_48_Var
		.getLines();
		Assert.assertNotNull(Lines_48_list);
		Assert.assertEquals(1, Lines_48_list.size());
		//48
		final Code Code_49_Var
		 = (Code)Lines_48_list.get(0);
		Assert.assertNotNull(Code_49_Var
		);
		Assert.assertEquals("	void no_foo_and_no_bar();", Code_49_Var
		.getCode());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0061_IfElIfElse.c");
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
				method.invoke(this.generator, "Test0061_IfElIfElse.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0061_IfElIfElse.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0061_IfElIfElse.c"
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


