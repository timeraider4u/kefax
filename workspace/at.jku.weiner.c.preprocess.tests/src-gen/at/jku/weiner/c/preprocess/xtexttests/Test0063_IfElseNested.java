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
public class Test0063_IfElseNested {
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
			"res/Test0063_IfElseNested.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_LINE_COMMENT", 
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
				"RULE_WS", 
				"RULE_HASH", 
				"RULE_IF", 
				"RULE_WS", 
				"RULE_DEFINED", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_NEWLINE", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WS", 
				"RULE_HASH", 
				"RULE_ELSE", 
				"RULE_NEWLINE", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_HASH", 
				"RULE_IF", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_SKW_GREATEREQUAL", 
				"RULE_WS", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_NEWLINE", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_HASH", 
				"RULE_ELSE", 
				"RULE_NEWLINE", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_WS", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WS", 
				"RULE_WS", 
				"RULE_HASH", 
				"RULE_ENDIF", 
				"RULE_WS", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WS", 
				"RULE_HASH", 
				"RULE_ENDIF", 
				"RULE_WS", 
				"RULE_BLOCK_COMMENT", 
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
			"res/Test0063_IfElseNested.c");
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
		final NewLineLine NewLineLine_5_Var
		 = (NewLineLine)Lines_2_list.get(1);
		Assert.assertNotNull(NewLineLine_5_Var
		);
		//5
		final PreprocessorDirectives PreprocessorDirectives_6_Var
		 = (PreprocessorDirectives)Lines_2_list.get(2);
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
		final EList<? extends EObject> Expr_16_list = EqualityExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
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
		Assert.assertTrue(PrimaryExpression_24_Var
		.isDefined());
		Assert.assertEquals("FOO", PrimaryExpression_24_Var
		.getId());
		//24
		final GroupOpt GroupOpt_25_Var
		 = (GroupOpt)IfConditional_8_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_25_Var
		);
		final EList<? extends EObject> Lines_25_list = GroupOpt_25_Var
		.getLines();
		Assert.assertNotNull(Lines_25_list);
		Assert.assertEquals(2, Lines_25_list.size());
		//25
		final Code Code_26_Var
		 = (Code)Lines_25_list.get(0);
		Assert.assertNotNull(Code_26_Var
		);
		Assert.assertEquals("	void foo();", Code_26_Var
		.getCode());
		//26
		final PreprocessorDirectives PreprocessorDirectives_27_Var
		 = (PreprocessorDirectives)Lines_25_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_27_Var
		);
		//27
		final ConditionalDirective ConditionalDirective_28_Var
		 = (ConditionalDirective)PreprocessorDirectives_27_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_28_Var
		);
		//28
		final IfConditional IfConditional_29_Var
		 = (IfConditional)ConditionalDirective_28_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_29_Var
		);
		//29
		final ConstantExpression ConstantExpression_30_Var
		 = (ConstantExpression)IfConditional_29_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_30_Var
		);
		//30
		final ConditionalExpression ConditionalExpression_31_Var
		 = (ConditionalExpression)ConstantExpression_30_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_31_Var
		);
		//31
		final LogicalOrExpression LogicalOrExpression_32_Var
		 = (LogicalOrExpression)ConditionalExpression_31_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = LogicalOrExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final LogicalAndExpression LogicalAndExpression_33_Var
		 = (LogicalAndExpression)Expr_32_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = LogicalAndExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final InclusiveOrExpression InclusiveOrExpression_34_Var
		 = (InclusiveOrExpression)Expr_33_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = InclusiveOrExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final ExclusiveOrExpression ExclusiveOrExpression_35_Var
		 = (ExclusiveOrExpression)Expr_34_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = ExclusiveOrExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final AndExpression AndExpression_36_Var
		 = (AndExpression)Expr_35_list.get(0);
		Assert.assertNotNull(AndExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = AndExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final EqualityExpression EqualityExpression_37_Var
		 = (EqualityExpression)Expr_36_list.get(0);
		Assert.assertNotNull(EqualityExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = EqualityExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final RelationalExpression RelationalExpression_38_Var
		 = (RelationalExpression)Expr_37_list.get(0);
		Assert.assertNotNull(RelationalExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = RelationalExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final ShiftExpression ShiftExpression_39_Var
		 = (ShiftExpression)Expr_38_list.get(0);
		Assert.assertNotNull(ShiftExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = ShiftExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final AdditiveExpression AdditiveExpression_40_Var
		 = (AdditiveExpression)Expr_39_list.get(0);
		Assert.assertNotNull(AdditiveExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = AdditiveExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final MultiplicativeExpression MultiplicativeExpression_41_Var
		 = (MultiplicativeExpression)Expr_40_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = MultiplicativeExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final CastExpression CastExpression_42_Var
		 = (CastExpression)Expr_41_list.get(0);
		Assert.assertNotNull(CastExpression_42_Var
		);
		//42
		final UnaryExpression UnaryExpression_43_Var
		 = (UnaryExpression)CastExpression_42_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_43_Var
		);
		//43
		final PostfixExpression PostfixExpression_44_Var
		 = (PostfixExpression)UnaryExpression_43_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_44_Var
		);
		//44
		final PrimaryExpression PrimaryExpression_45_Var
		 = (PrimaryExpression)PostfixExpression_44_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_45_Var
		);
		Assert.assertTrue(PrimaryExpression_45_Var
		.isDefined());
		Assert.assertEquals("BAR", PrimaryExpression_45_Var
		.getId());
		//45
		final GroupOpt GroupOpt_46_Var
		 = (GroupOpt)IfConditional_29_Var
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
		Assert.assertEquals("		void bar();", Code_47_Var
		.getCode());
		//47
		final ElseConditional ElseConditional_48_Var
		 = (ElseConditional)ConditionalDirective_28_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_48_Var
		);
		//48
		final GroupOpt GroupOpt_49_Var
		 = (GroupOpt)ElseConditional_48_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_49_Var
		);
		final EList<? extends EObject> Lines_49_list = GroupOpt_49_Var
		.getLines();
		Assert.assertNotNull(Lines_49_list);
		Assert.assertEquals(2, Lines_49_list.size());
		//49
		final Code Code_50_Var
		 = (Code)Lines_49_list.get(0);
		Assert.assertNotNull(Code_50_Var
		);
		Assert.assertEquals("		void no_bar();", Code_50_Var
		.getCode());
		//50
		final PreprocessorDirectives PreprocessorDirectives_51_Var
		 = (PreprocessorDirectives)Lines_49_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_51_Var
		);
		//51
		final ConditionalDirective ConditionalDirective_52_Var
		 = (ConditionalDirective)PreprocessorDirectives_51_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_52_Var
		);
		//52
		final IfConditional IfConditional_53_Var
		 = (IfConditional)ConditionalDirective_52_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_53_Var
		);
		//53
		final ConstantExpression ConstantExpression_54_Var
		 = (ConstantExpression)IfConditional_53_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_54_Var
		);
		//54
		final ConditionalExpression ConditionalExpression_55_Var
		 = (ConditionalExpression)ConstantExpression_54_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_55_Var
		);
		//55
		final LogicalOrExpression LogicalOrExpression_56_Var
		 = (LogicalOrExpression)ConditionalExpression_55_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = LogicalOrExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final LogicalAndExpression LogicalAndExpression_57_Var
		 = (LogicalAndExpression)Expr_56_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = LogicalAndExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final InclusiveOrExpression InclusiveOrExpression_58_Var
		 = (InclusiveOrExpression)Expr_57_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = InclusiveOrExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final ExclusiveOrExpression ExclusiveOrExpression_59_Var
		 = (ExclusiveOrExpression)Expr_58_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = ExclusiveOrExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final AndExpression AndExpression_60_Var
		 = (AndExpression)Expr_59_list.get(0);
		Assert.assertNotNull(AndExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = AndExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final EqualityExpression EqualityExpression_61_Var
		 = (EqualityExpression)Expr_60_list.get(0);
		Assert.assertNotNull(EqualityExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = EqualityExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final RelationalExpression RelationalExpression_62_Var
		 = (RelationalExpression)Expr_61_list.get(0);
		Assert.assertNotNull(RelationalExpression_62_Var
		);
		Assert.assertEquals("[>=]", RelationalExpression_62_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_62_list = RelationalExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(2, Expr_62_list.size());
		//62
		final ShiftExpression ShiftExpression_63_Var
		 = (ShiftExpression)Expr_62_list.get(0);
		Assert.assertNotNull(ShiftExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = ShiftExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final AdditiveExpression AdditiveExpression_64_Var
		 = (AdditiveExpression)Expr_63_list.get(0);
		Assert.assertNotNull(AdditiveExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = AdditiveExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final MultiplicativeExpression MultiplicativeExpression_65_Var
		 = (MultiplicativeExpression)Expr_64_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = MultiplicativeExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final CastExpression CastExpression_66_Var
		 = (CastExpression)Expr_65_list.get(0);
		Assert.assertNotNull(CastExpression_66_Var
		);
		//66
		final UnaryExpression UnaryExpression_67_Var
		 = (UnaryExpression)CastExpression_66_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_67_Var
		);
		//67
		final PostfixExpression PostfixExpression_68_Var
		 = (PostfixExpression)UnaryExpression_67_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_68_Var
		);
		//68
		final PrimaryExpression PrimaryExpression_69_Var
		 = (PrimaryExpression)PostfixExpression_68_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_69_Var
		);
		Assert.assertEquals("FOO", PrimaryExpression_69_Var
		.getId());
		//69
		final ShiftExpression ShiftExpression_70_Var
		 = (ShiftExpression)Expr_62_list.get(1);
		Assert.assertNotNull(ShiftExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = ShiftExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final AdditiveExpression AdditiveExpression_71_Var
		 = (AdditiveExpression)Expr_70_list.get(0);
		Assert.assertNotNull(AdditiveExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = AdditiveExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final MultiplicativeExpression MultiplicativeExpression_72_Var
		 = (MultiplicativeExpression)Expr_71_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = MultiplicativeExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final CastExpression CastExpression_73_Var
		 = (CastExpression)Expr_72_list.get(0);
		Assert.assertNotNull(CastExpression_73_Var
		);
		//73
		final UnaryExpression UnaryExpression_74_Var
		 = (UnaryExpression)CastExpression_73_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_74_Var
		);
		//74
		final PostfixExpression PostfixExpression_75_Var
		 = (PostfixExpression)UnaryExpression_74_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_75_Var
		);
		//75
		final PrimaryExpression PrimaryExpression_76_Var
		 = (PrimaryExpression)PostfixExpression_75_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_76_Var
		);
		Assert.assertEquals("64", PrimaryExpression_76_Var
		.getConst());
		//76
		final GroupOpt GroupOpt_77_Var
		 = (GroupOpt)IfConditional_53_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_77_Var
		);
		final EList<? extends EObject> Lines_77_list = GroupOpt_77_Var
		.getLines();
		Assert.assertNotNull(Lines_77_list);
		Assert.assertEquals(1, Lines_77_list.size());
		//77
		final Code Code_78_Var
		 = (Code)Lines_77_list.get(0);
		Assert.assertNotNull(Code_78_Var
		);
		Assert.assertEquals("			void foo_64();", Code_78_Var
		.getCode());
		//78
		final ElseConditional ElseConditional_79_Var
		 = (ElseConditional)ConditionalDirective_52_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_79_Var
		);
		//79
		final GroupOpt GroupOpt_80_Var
		 = (GroupOpt)ElseConditional_79_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_80_Var
		);
		final EList<? extends EObject> Lines_80_list = GroupOpt_80_Var
		.getLines();
		Assert.assertNotNull(Lines_80_list);
		Assert.assertEquals(1, Lines_80_list.size());
		//80
		final Code Code_81_Var
		 = (Code)Lines_80_list.get(0);
		Assert.assertNotNull(Code_81_Var
		);
		Assert.assertEquals("			void foo_and_no_bar();", Code_81_Var
		.getCode());
		//81
		final ElseConditional ElseConditional_82_Var
		 = (ElseConditional)ConditionalDirective_7_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_82_Var
		);
		//82
		final GroupOpt GroupOpt_83_Var
		 = (GroupOpt)ElseConditional_82_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_83_Var
		);
		final EList<? extends EObject> Lines_83_list = GroupOpt_83_Var
		.getLines();
		Assert.assertNotNull(Lines_83_list);
		Assert.assertEquals(1, Lines_83_list.size());
		//83
		final Code Code_84_Var
		 = (Code)Lines_83_list.get(0);
		Assert.assertNotNull(Code_84_Var
		);
		Assert.assertEquals("	void no_foo_and_no_bar();", Code_84_Var
		.getCode());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0063_IfElseNested.c");
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
				method.invoke(this.generator, "Test0063_IfElseNested.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0063_IfElseNested.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0063_IfElseNested.c"
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


