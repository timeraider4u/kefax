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
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
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
import at.jku.weiner.c.preprocess.preprocess.ElseConditional;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
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
import at.jku.weiner.c.preprocess.preprocess.ElseConditional;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0062_IfElseNested {
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
			"res/Test0062_IfElseNested.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_LINE_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_LINE_COMMENT", 
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
				"RULE_WHITESPACE", 
				"RULE_HASH", 
				"RULE_IF", 
				"RULE_WHITESPACE", 
				"RULE_DEFINED", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_HASH", 
				"RULE_ELSE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_HASH", 
				"RULE_IF", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_GREATEREQUAL", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_HASH", 
				"RULE_ELSE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_WHITESPACE", 
				"RULE_HASH", 
				"RULE_ENDIF", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_HASH", 
				"RULE_ENDIF", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_ELSE", 
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
			"res/Test0062_IfElseNested.c");
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
		final NewLineLine NewLineLine_3_Var
		 = (NewLineLine)Lines_2_list.get(0);
		Assert.assertNotNull(NewLineLine_3_Var
		);
		//3
		final NewLineLine NewLineLine_4_Var
		 = (NewLineLine)Lines_2_list.get(1);
		Assert.assertNotNull(NewLineLine_4_Var
		);
		//4
		final PreprocessorDirectives PreprocessorDirectives_5_Var
		 = (PreprocessorDirectives)Lines_2_list.get(2);
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
		Assert.assertEquals(2, Lines_24_list.size());
		//24
		final Code Code_25_Var
		 = (Code)Lines_24_list.get(0);
		Assert.assertNotNull(Code_25_Var
		);
		Assert.assertEquals("	void foo();", Code_25_Var
		.getCode());
		//25
		final PreprocessorDirectives PreprocessorDirectives_26_Var
		 = (PreprocessorDirectives)Lines_24_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_26_Var
		);
		//26
		final ConditionalDirective ConditionalDirective_27_Var
		 = (ConditionalDirective)PreprocessorDirectives_26_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_27_Var
		);
		//27
		final IfConditional IfConditional_28_Var
		 = (IfConditional)ConditionalDirective_27_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_28_Var
		);
		//28
		final ConstantExpression ConstantExpression_29_Var
		 = (ConstantExpression)IfConditional_28_Var
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
		 = (GroupOpt)IfConditional_28_Var
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
		Assert.assertEquals("		void bar();", Code_46_Var
		.getCode());
		//46
		final ElseConditional ElseConditional_47_Var
		 = (ElseConditional)ConditionalDirective_27_Var
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
		Assert.assertEquals(2, Lines_48_list.size());
		//48
		final Code Code_49_Var
		 = (Code)Lines_48_list.get(0);
		Assert.assertNotNull(Code_49_Var
		);
		Assert.assertEquals("		void no_bar();", Code_49_Var
		.getCode());
		//49
		final PreprocessorDirectives PreprocessorDirectives_50_Var
		 = (PreprocessorDirectives)Lines_48_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_50_Var
		);
		//50
		final ConditionalDirective ConditionalDirective_51_Var
		 = (ConditionalDirective)PreprocessorDirectives_50_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_51_Var
		);
		//51
		final IfConditional IfConditional_52_Var
		 = (IfConditional)ConditionalDirective_51_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_52_Var
		);
		//52
		final ConstantExpression ConstantExpression_53_Var
		 = (ConstantExpression)IfConditional_52_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_53_Var
		);
		//53
		final ConditionalExpression ConditionalExpression_54_Var
		 = (ConditionalExpression)ConstantExpression_53_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_54_Var
		);
		//54
		final LogicalOrExpression LogicalOrExpression_55_Var
		 = (LogicalOrExpression)ConditionalExpression_54_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = LogicalOrExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final LogicalAndExpression LogicalAndExpression_56_Var
		 = (LogicalAndExpression)Expr_55_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = LogicalAndExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final InclusiveOrExpression InclusiveOrExpression_57_Var
		 = (InclusiveOrExpression)Expr_56_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = InclusiveOrExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final ExclusiveOrExpression ExclusiveOrExpression_58_Var
		 = (ExclusiveOrExpression)Expr_57_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = ExclusiveOrExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final AndExpression AndExpression_59_Var
		 = (AndExpression)Expr_58_list.get(0);
		Assert.assertNotNull(AndExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = AndExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final EqualityExpression EqualityExpression_60_Var
		 = (EqualityExpression)Expr_59_list.get(0);
		Assert.assertNotNull(EqualityExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = EqualityExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final RelationalExpression RelationalExpression_61_Var
		 = (RelationalExpression)Expr_60_list.get(0);
		Assert.assertNotNull(RelationalExpression_61_Var
		);
		Assert.assertEquals("[>=]", RelationalExpression_61_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_61_list = RelationalExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(2, Expr_61_list.size());
		//61
		final ShiftExpression ShiftExpression_62_Var
		 = (ShiftExpression)Expr_61_list.get(0);
		Assert.assertNotNull(ShiftExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = ShiftExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final AdditiveExpression AdditiveExpression_63_Var
		 = (AdditiveExpression)Expr_62_list.get(0);
		Assert.assertNotNull(AdditiveExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = AdditiveExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final MultiplicativeExpression MultiplicativeExpression_64_Var
		 = (MultiplicativeExpression)Expr_63_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = MultiplicativeExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final CastExpression CastExpression_65_Var
		 = (CastExpression)Expr_64_list.get(0);
		Assert.assertNotNull(CastExpression_65_Var
		);
		//65
		final UnaryExpression UnaryExpression_66_Var
		 = (UnaryExpression)CastExpression_65_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_66_Var
		);
		//66
		final PostfixExpression PostfixExpression_67_Var
		 = (PostfixExpression)UnaryExpression_66_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_67_Var
		);
		//67
		final PrimaryExpression PrimaryExpression_68_Var
		 = (PrimaryExpression)PostfixExpression_67_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_68_Var
		);
		Assert.assertEquals("FOO", PrimaryExpression_68_Var
		.getId());
		//68
		final ShiftExpression ShiftExpression_69_Var
		 = (ShiftExpression)Expr_61_list.get(1);
		Assert.assertNotNull(ShiftExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = ShiftExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final AdditiveExpression AdditiveExpression_70_Var
		 = (AdditiveExpression)Expr_69_list.get(0);
		Assert.assertNotNull(AdditiveExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = AdditiveExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final MultiplicativeExpression MultiplicativeExpression_71_Var
		 = (MultiplicativeExpression)Expr_70_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = MultiplicativeExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final CastExpression CastExpression_72_Var
		 = (CastExpression)Expr_71_list.get(0);
		Assert.assertNotNull(CastExpression_72_Var
		);
		//72
		final UnaryExpression UnaryExpression_73_Var
		 = (UnaryExpression)CastExpression_72_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_73_Var
		);
		//73
		final PostfixExpression PostfixExpression_74_Var
		 = (PostfixExpression)UnaryExpression_73_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_74_Var
		);
		//74
		final PrimaryExpression PrimaryExpression_75_Var
		 = (PrimaryExpression)PostfixExpression_74_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_75_Var
		);
		Assert.assertEquals("64", PrimaryExpression_75_Var
		.getConst());
		//75
		final GroupOpt GroupOpt_76_Var
		 = (GroupOpt)IfConditional_52_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_76_Var
		);
		final EList<? extends EObject> Lines_76_list = GroupOpt_76_Var
		.getLines();
		Assert.assertNotNull(Lines_76_list);
		Assert.assertEquals(1, Lines_76_list.size());
		//76
		final Code Code_77_Var
		 = (Code)Lines_76_list.get(0);
		Assert.assertNotNull(Code_77_Var
		);
		Assert.assertEquals("			void foo_64();", Code_77_Var
		.getCode());
		//77
		final ElseConditional ElseConditional_78_Var
		 = (ElseConditional)ConditionalDirective_51_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_78_Var
		);
		//78
		final GroupOpt GroupOpt_79_Var
		 = (GroupOpt)ElseConditional_78_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_79_Var
		);
		final EList<? extends EObject> Lines_79_list = GroupOpt_79_Var
		.getLines();
		Assert.assertNotNull(Lines_79_list);
		Assert.assertEquals(1, Lines_79_list.size());
		//79
		final Code Code_80_Var
		 = (Code)Lines_79_list.get(0);
		Assert.assertNotNull(Code_80_Var
		);
		Assert.assertEquals("			void foo_and_no_bar();", Code_80_Var
		.getCode());
		//80
		final ElseConditional ElseConditional_81_Var
		 = (ElseConditional)ConditionalDirective_6_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_81_Var
		);
		//81
		final GroupOpt GroupOpt_82_Var
		 = (GroupOpt)ElseConditional_81_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_82_Var
		);
		final EList<? extends EObject> Lines_82_list = GroupOpt_82_Var
		.getLines();
		Assert.assertNotNull(Lines_82_list);
		Assert.assertEquals(1, Lines_82_list.size());
		//82
		final Code Code_83_Var
		 = (Code)Lines_82_list.get(0);
		Assert.assertNotNull(Code_83_Var
		);
		Assert.assertEquals("	void no_foo_and_no_bar();", Code_83_Var
		.getCode());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0062_IfElseNested.c");
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
				method.invoke(this.generator, "Test0062_IfElseNested.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0062_IfElseNested.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0062_IfElseNested.c"
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


