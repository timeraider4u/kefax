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
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0062_IfElseNested.c");
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
		final NewLineLine NewLineLine_3_Var
		 = (NewLineLine)Lines_1_list.get(1);
		Assert.assertNotNull(NewLineLine_3_Var
		);
		//3
		final PreprocessorDirectives PreprocessorDirectives_4_Var
		 = (PreprocessorDirectives)Lines_1_list.get(2);
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
		Assert.assertEquals(1, Expr_10_list.size());
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
		final GroupOpt GroupOpt_23_Var
		 = (GroupOpt)IfConditional_6_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_23_Var
		);
		final EList<? extends EObject> Lines_23_list = GroupOpt_23_Var
		.getLines();
		Assert.assertNotNull(Lines_23_list);
		Assert.assertEquals(2, Lines_23_list.size());
		//23
		final Code Code_24_Var
		 = (Code)Lines_23_list.get(0);
		Assert.assertNotNull(Code_24_Var
		);
		Assert.assertEquals("	void foo();", Code_24_Var
		.getCode());
		//24
		final PreprocessorDirectives PreprocessorDirectives_25_Var
		 = (PreprocessorDirectives)Lines_23_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_25_Var
		);
		//25
		final ConditionalDirective ConditionalDirective_26_Var
		 = (ConditionalDirective)PreprocessorDirectives_25_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_26_Var
		);
		//26
		final IfConditional IfConditional_27_Var
		 = (IfConditional)ConditionalDirective_26_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_27_Var
		);
		//27
		final ConstantExpression ConstantExpression_28_Var
		 = (ConstantExpression)IfConditional_27_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_28_Var
		);
		//28
		final ConditionalExpression ConditionalExpression_29_Var
		 = (ConditionalExpression)ConstantExpression_28_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_29_Var
		);
		//29
		final LogicalOrExpression LogicalOrExpression_30_Var
		 = (LogicalOrExpression)ConditionalExpression_29_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = LogicalOrExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final LogicalAndExpression LogicalAndExpression_31_Var
		 = (LogicalAndExpression)Expr_30_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = LogicalAndExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final InclusiveOrExpression InclusiveOrExpression_32_Var
		 = (InclusiveOrExpression)Expr_31_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = InclusiveOrExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final ExclusiveOrExpression ExclusiveOrExpression_33_Var
		 = (ExclusiveOrExpression)Expr_32_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = ExclusiveOrExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final AndExpression AndExpression_34_Var
		 = (AndExpression)Expr_33_list.get(0);
		Assert.assertNotNull(AndExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = AndExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final EqualityExpression EqualityExpression_35_Var
		 = (EqualityExpression)Expr_34_list.get(0);
		Assert.assertNotNull(EqualityExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = EqualityExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final RelationalExpression RelationalExpression_36_Var
		 = (RelationalExpression)Expr_35_list.get(0);
		Assert.assertNotNull(RelationalExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = RelationalExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final ShiftExpression ShiftExpression_37_Var
		 = (ShiftExpression)Expr_36_list.get(0);
		Assert.assertNotNull(ShiftExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = ShiftExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final AdditiveExpression AdditiveExpression_38_Var
		 = (AdditiveExpression)Expr_37_list.get(0);
		Assert.assertNotNull(AdditiveExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = AdditiveExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final MultiplicativeExpression MultiplicativeExpression_39_Var
		 = (MultiplicativeExpression)Expr_38_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = MultiplicativeExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final CastExpression CastExpression_40_Var
		 = (CastExpression)Expr_39_list.get(0);
		Assert.assertNotNull(CastExpression_40_Var
		);
		//40
		final UnaryExpression UnaryExpression_41_Var
		 = (UnaryExpression)CastExpression_40_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_41_Var
		);
		//41
		final PostfixExpression PostfixExpression_42_Var
		 = (PostfixExpression)UnaryExpression_41_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_42_Var
		);
		//42
		final PrimaryExpression PrimaryExpression_43_Var
		 = (PrimaryExpression)PostfixExpression_42_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_43_Var
		);
		Assert.assertTrue(PrimaryExpression_43_Var
		.isDefined());
		Assert.assertEquals("BAR", PrimaryExpression_43_Var
		.getId());
		//43
		final GroupOpt GroupOpt_44_Var
		 = (GroupOpt)IfConditional_27_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_44_Var
		);
		final EList<? extends EObject> Lines_44_list = GroupOpt_44_Var
		.getLines();
		Assert.assertNotNull(Lines_44_list);
		Assert.assertEquals(1, Lines_44_list.size());
		//44
		final Code Code_45_Var
		 = (Code)Lines_44_list.get(0);
		Assert.assertNotNull(Code_45_Var
		);
		Assert.assertEquals("		void bar();", Code_45_Var
		.getCode());
		//45
		final ElseConditional ElseConditional_46_Var
		 = (ElseConditional)ConditionalDirective_26_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_46_Var
		);
		//46
		final GroupOpt GroupOpt_47_Var
		 = (GroupOpt)ElseConditional_46_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_47_Var
		);
		final EList<? extends EObject> Lines_47_list = GroupOpt_47_Var
		.getLines();
		Assert.assertNotNull(Lines_47_list);
		Assert.assertEquals(2, Lines_47_list.size());
		//47
		final Code Code_48_Var
		 = (Code)Lines_47_list.get(0);
		Assert.assertNotNull(Code_48_Var
		);
		Assert.assertEquals("		void no_bar();", Code_48_Var
		.getCode());
		//48
		final PreprocessorDirectives PreprocessorDirectives_49_Var
		 = (PreprocessorDirectives)Lines_47_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_49_Var
		);
		//49
		final ConditionalDirective ConditionalDirective_50_Var
		 = (ConditionalDirective)PreprocessorDirectives_49_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_50_Var
		);
		//50
		final IfConditional IfConditional_51_Var
		 = (IfConditional)ConditionalDirective_50_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_51_Var
		);
		//51
		final ConstantExpression ConstantExpression_52_Var
		 = (ConstantExpression)IfConditional_51_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_52_Var
		);
		//52
		final ConditionalExpression ConditionalExpression_53_Var
		 = (ConditionalExpression)ConstantExpression_52_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_53_Var
		);
		//53
		final LogicalOrExpression LogicalOrExpression_54_Var
		 = (LogicalOrExpression)ConditionalExpression_53_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = LogicalOrExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final LogicalAndExpression LogicalAndExpression_55_Var
		 = (LogicalAndExpression)Expr_54_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = LogicalAndExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final InclusiveOrExpression InclusiveOrExpression_56_Var
		 = (InclusiveOrExpression)Expr_55_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = InclusiveOrExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final ExclusiveOrExpression ExclusiveOrExpression_57_Var
		 = (ExclusiveOrExpression)Expr_56_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = ExclusiveOrExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final AndExpression AndExpression_58_Var
		 = (AndExpression)Expr_57_list.get(0);
		Assert.assertNotNull(AndExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = AndExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final EqualityExpression EqualityExpression_59_Var
		 = (EqualityExpression)Expr_58_list.get(0);
		Assert.assertNotNull(EqualityExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = EqualityExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final RelationalExpression RelationalExpression_60_Var
		 = (RelationalExpression)Expr_59_list.get(0);
		Assert.assertNotNull(RelationalExpression_60_Var
		);
		Assert.assertEquals("[>=]", RelationalExpression_60_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_60_list = RelationalExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(2, Expr_60_list.size());
		//60
		final ShiftExpression ShiftExpression_61_Var
		 = (ShiftExpression)Expr_60_list.get(0);
		Assert.assertNotNull(ShiftExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = ShiftExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final AdditiveExpression AdditiveExpression_62_Var
		 = (AdditiveExpression)Expr_61_list.get(0);
		Assert.assertNotNull(AdditiveExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = AdditiveExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final MultiplicativeExpression MultiplicativeExpression_63_Var
		 = (MultiplicativeExpression)Expr_62_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = MultiplicativeExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final CastExpression CastExpression_64_Var
		 = (CastExpression)Expr_63_list.get(0);
		Assert.assertNotNull(CastExpression_64_Var
		);
		//64
		final UnaryExpression UnaryExpression_65_Var
		 = (UnaryExpression)CastExpression_64_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_65_Var
		);
		//65
		final PostfixExpression PostfixExpression_66_Var
		 = (PostfixExpression)UnaryExpression_65_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_66_Var
		);
		//66
		final PrimaryExpression PrimaryExpression_67_Var
		 = (PrimaryExpression)PostfixExpression_66_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_67_Var
		);
		Assert.assertEquals("FOO", PrimaryExpression_67_Var
		.getId());
		//67
		final ShiftExpression ShiftExpression_68_Var
		 = (ShiftExpression)Expr_60_list.get(1);
		Assert.assertNotNull(ShiftExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = ShiftExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final AdditiveExpression AdditiveExpression_69_Var
		 = (AdditiveExpression)Expr_68_list.get(0);
		Assert.assertNotNull(AdditiveExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = AdditiveExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final MultiplicativeExpression MultiplicativeExpression_70_Var
		 = (MultiplicativeExpression)Expr_69_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = MultiplicativeExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final CastExpression CastExpression_71_Var
		 = (CastExpression)Expr_70_list.get(0);
		Assert.assertNotNull(CastExpression_71_Var
		);
		//71
		final UnaryExpression UnaryExpression_72_Var
		 = (UnaryExpression)CastExpression_71_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_72_Var
		);
		//72
		final PostfixExpression PostfixExpression_73_Var
		 = (PostfixExpression)UnaryExpression_72_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_73_Var
		);
		//73
		final PrimaryExpression PrimaryExpression_74_Var
		 = (PrimaryExpression)PostfixExpression_73_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_74_Var
		);
		Assert.assertEquals("64", PrimaryExpression_74_Var
		.getConst());
		//74
		final GroupOpt GroupOpt_75_Var
		 = (GroupOpt)IfConditional_51_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_75_Var
		);
		final EList<? extends EObject> Lines_75_list = GroupOpt_75_Var
		.getLines();
		Assert.assertNotNull(Lines_75_list);
		Assert.assertEquals(1, Lines_75_list.size());
		//75
		final Code Code_76_Var
		 = (Code)Lines_75_list.get(0);
		Assert.assertNotNull(Code_76_Var
		);
		Assert.assertEquals("			void foo_64();", Code_76_Var
		.getCode());
		//76
		final ElseConditional ElseConditional_77_Var
		 = (ElseConditional)ConditionalDirective_50_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_77_Var
		);
		//77
		final GroupOpt GroupOpt_78_Var
		 = (GroupOpt)ElseConditional_77_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_78_Var
		);
		final EList<? extends EObject> Lines_78_list = GroupOpt_78_Var
		.getLines();
		Assert.assertNotNull(Lines_78_list);
		Assert.assertEquals(1, Lines_78_list.size());
		//78
		final Code Code_79_Var
		 = (Code)Lines_78_list.get(0);
		Assert.assertNotNull(Code_79_Var
		);
		Assert.assertEquals("			void foo_and_no_bar();", Code_79_Var
		.getCode());
		//79
		final ElseConditional ElseConditional_80_Var
		 = (ElseConditional)ConditionalDirective_5_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_80_Var
		);
		//80
		final GroupOpt GroupOpt_81_Var
		 = (GroupOpt)ElseConditional_80_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_81_Var
		);
		final EList<? extends EObject> Lines_81_list = GroupOpt_81_Var
		.getLines();
		Assert.assertNotNull(Lines_81_list);
		Assert.assertEquals(1, Lines_81_list.size());
		//81
		final Code Code_82_Var
		 = (Code)Lines_81_list.get(0);
		Assert.assertNotNull(Code_82_Var
		);
		Assert.assertEquals("	void no_foo_and_no_bar();", Code_82_Var
		.getCode());
	}
	
	@Test
	(timeout=1000
	)
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


