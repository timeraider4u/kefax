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
public class Test0065_IfElseNested {
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
			"res/Test0065_IfElseNested.c");
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
			"res/Test0065_IfElseNested.c");
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
		Assert.assertEquals("64", DefineDirective_4_Var
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
		Assert.assertEquals(2, Lines_26_list.size());
		//26
		final Code Code_27_Var
		 = (Code)Lines_26_list.get(0);
		Assert.assertNotNull(Code_27_Var
		);
		Assert.assertEquals("	void foo();", Code_27_Var
		.getCode());
		//27
		final PreprocessorDirectives PreprocessorDirectives_28_Var
		 = (PreprocessorDirectives)Lines_26_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_28_Var
		);
		//28
		final ConditionalDirective ConditionalDirective_29_Var
		 = (ConditionalDirective)PreprocessorDirectives_28_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_29_Var
		);
		//29
		final IfConditional IfConditional_30_Var
		 = (IfConditional)ConditionalDirective_29_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_30_Var
		);
		//30
		final ConstantExpression ConstantExpression_31_Var
		 = (ConstantExpression)IfConditional_30_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_31_Var
		);
		//31
		final ConditionalExpression ConditionalExpression_32_Var
		 = (ConditionalExpression)ConstantExpression_31_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_32_Var
		);
		//32
		final LogicalOrExpression LogicalOrExpression_33_Var
		 = (LogicalOrExpression)ConditionalExpression_32_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = LogicalOrExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final LogicalAndExpression LogicalAndExpression_34_Var
		 = (LogicalAndExpression)Expr_33_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = LogicalAndExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final InclusiveOrExpression InclusiveOrExpression_35_Var
		 = (InclusiveOrExpression)Expr_34_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = InclusiveOrExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final ExclusiveOrExpression ExclusiveOrExpression_36_Var
		 = (ExclusiveOrExpression)Expr_35_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = ExclusiveOrExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final AndExpression AndExpression_37_Var
		 = (AndExpression)Expr_36_list.get(0);
		Assert.assertNotNull(AndExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = AndExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final EqualityExpression EqualityExpression_38_Var
		 = (EqualityExpression)Expr_37_list.get(0);
		Assert.assertNotNull(EqualityExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = EqualityExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final RelationalExpression RelationalExpression_39_Var
		 = (RelationalExpression)Expr_38_list.get(0);
		Assert.assertNotNull(RelationalExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = RelationalExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final ShiftExpression ShiftExpression_40_Var
		 = (ShiftExpression)Expr_39_list.get(0);
		Assert.assertNotNull(ShiftExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = ShiftExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final AdditiveExpression AdditiveExpression_41_Var
		 = (AdditiveExpression)Expr_40_list.get(0);
		Assert.assertNotNull(AdditiveExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = AdditiveExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final MultiplicativeExpression MultiplicativeExpression_42_Var
		 = (MultiplicativeExpression)Expr_41_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = MultiplicativeExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final CastExpression CastExpression_43_Var
		 = (CastExpression)Expr_42_list.get(0);
		Assert.assertNotNull(CastExpression_43_Var
		);
		//43
		final UnaryExpression UnaryExpression_44_Var
		 = (UnaryExpression)CastExpression_43_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_44_Var
		);
		//44
		final PostfixExpression PostfixExpression_45_Var
		 = (PostfixExpression)UnaryExpression_44_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_45_Var
		);
		//45
		final PrimaryExpression PrimaryExpression_46_Var
		 = (PrimaryExpression)PostfixExpression_45_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_46_Var
		);
		Assert.assertTrue(PrimaryExpression_46_Var
		.isDefined());
		Assert.assertEquals("BAR", PrimaryExpression_46_Var
		.getId());
		//46
		final GroupOpt GroupOpt_47_Var
		 = (GroupOpt)IfConditional_30_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_47_Var
		);
		final EList<? extends EObject> Lines_47_list = GroupOpt_47_Var
		.getLines();
		Assert.assertNotNull(Lines_47_list);
		Assert.assertEquals(1, Lines_47_list.size());
		//47
		final Code Code_48_Var
		 = (Code)Lines_47_list.get(0);
		Assert.assertNotNull(Code_48_Var
		);
		Assert.assertEquals("		void bar();", Code_48_Var
		.getCode());
		//48
		final ElseConditional ElseConditional_49_Var
		 = (ElseConditional)ConditionalDirective_29_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_49_Var
		);
		//49
		final GroupOpt GroupOpt_50_Var
		 = (GroupOpt)ElseConditional_49_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_50_Var
		);
		final EList<? extends EObject> Lines_50_list = GroupOpt_50_Var
		.getLines();
		Assert.assertNotNull(Lines_50_list);
		Assert.assertEquals(2, Lines_50_list.size());
		//50
		final Code Code_51_Var
		 = (Code)Lines_50_list.get(0);
		Assert.assertNotNull(Code_51_Var
		);
		Assert.assertEquals("		void no_bar();", Code_51_Var
		.getCode());
		//51
		final PreprocessorDirectives PreprocessorDirectives_52_Var
		 = (PreprocessorDirectives)Lines_50_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_52_Var
		);
		//52
		final ConditionalDirective ConditionalDirective_53_Var
		 = (ConditionalDirective)PreprocessorDirectives_52_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_53_Var
		);
		//53
		final IfConditional IfConditional_54_Var
		 = (IfConditional)ConditionalDirective_53_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_54_Var
		);
		//54
		final ConstantExpression ConstantExpression_55_Var
		 = (ConstantExpression)IfConditional_54_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_55_Var
		);
		//55
		final ConditionalExpression ConditionalExpression_56_Var
		 = (ConditionalExpression)ConstantExpression_55_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_56_Var
		);
		//56
		final LogicalOrExpression LogicalOrExpression_57_Var
		 = (LogicalOrExpression)ConditionalExpression_56_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = LogicalOrExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final LogicalAndExpression LogicalAndExpression_58_Var
		 = (LogicalAndExpression)Expr_57_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = LogicalAndExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final InclusiveOrExpression InclusiveOrExpression_59_Var
		 = (InclusiveOrExpression)Expr_58_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = InclusiveOrExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final ExclusiveOrExpression ExclusiveOrExpression_60_Var
		 = (ExclusiveOrExpression)Expr_59_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = ExclusiveOrExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final AndExpression AndExpression_61_Var
		 = (AndExpression)Expr_60_list.get(0);
		Assert.assertNotNull(AndExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = AndExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final EqualityExpression EqualityExpression_62_Var
		 = (EqualityExpression)Expr_61_list.get(0);
		Assert.assertNotNull(EqualityExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = EqualityExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final RelationalExpression RelationalExpression_63_Var
		 = (RelationalExpression)Expr_62_list.get(0);
		Assert.assertNotNull(RelationalExpression_63_Var
		);
		Assert.assertEquals("[>=]", RelationalExpression_63_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_63_list = RelationalExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(2, Expr_63_list.size());
		//63
		final ShiftExpression ShiftExpression_64_Var
		 = (ShiftExpression)Expr_63_list.get(0);
		Assert.assertNotNull(ShiftExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = ShiftExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final AdditiveExpression AdditiveExpression_65_Var
		 = (AdditiveExpression)Expr_64_list.get(0);
		Assert.assertNotNull(AdditiveExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = AdditiveExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final MultiplicativeExpression MultiplicativeExpression_66_Var
		 = (MultiplicativeExpression)Expr_65_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = MultiplicativeExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final CastExpression CastExpression_67_Var
		 = (CastExpression)Expr_66_list.get(0);
		Assert.assertNotNull(CastExpression_67_Var
		);
		//67
		final UnaryExpression UnaryExpression_68_Var
		 = (UnaryExpression)CastExpression_67_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_68_Var
		);
		//68
		final PostfixExpression PostfixExpression_69_Var
		 = (PostfixExpression)UnaryExpression_68_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_69_Var
		);
		//69
		final PrimaryExpression PrimaryExpression_70_Var
		 = (PrimaryExpression)PostfixExpression_69_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_70_Var
		);
		Assert.assertEquals("FOO", PrimaryExpression_70_Var
		.getId());
		//70
		final ShiftExpression ShiftExpression_71_Var
		 = (ShiftExpression)Expr_63_list.get(1);
		Assert.assertNotNull(ShiftExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = ShiftExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final AdditiveExpression AdditiveExpression_72_Var
		 = (AdditiveExpression)Expr_71_list.get(0);
		Assert.assertNotNull(AdditiveExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = AdditiveExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final MultiplicativeExpression MultiplicativeExpression_73_Var
		 = (MultiplicativeExpression)Expr_72_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = MultiplicativeExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final CastExpression CastExpression_74_Var
		 = (CastExpression)Expr_73_list.get(0);
		Assert.assertNotNull(CastExpression_74_Var
		);
		//74
		final UnaryExpression UnaryExpression_75_Var
		 = (UnaryExpression)CastExpression_74_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_75_Var
		);
		//75
		final PostfixExpression PostfixExpression_76_Var
		 = (PostfixExpression)UnaryExpression_75_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_76_Var
		);
		//76
		final PrimaryExpression PrimaryExpression_77_Var
		 = (PrimaryExpression)PostfixExpression_76_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_77_Var
		);
		Assert.assertEquals("64", PrimaryExpression_77_Var
		.getConst());
		//77
		final GroupOpt GroupOpt_78_Var
		 = (GroupOpt)IfConditional_54_Var
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
		Assert.assertEquals("			void foo_64();", Code_79_Var
		.getCode());
		//79
		final ElseConditional ElseConditional_80_Var
		 = (ElseConditional)ConditionalDirective_53_Var
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
		Assert.assertEquals("			void foo_and_no_bar();", Code_82_Var
		.getCode());
		//82
		final ElseConditional ElseConditional_83_Var
		 = (ElseConditional)ConditionalDirective_8_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_83_Var
		);
		//83
		final GroupOpt GroupOpt_84_Var
		 = (GroupOpt)ElseConditional_83_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_84_Var
		);
		final EList<? extends EObject> Lines_84_list = GroupOpt_84_Var
		.getLines();
		Assert.assertNotNull(Lines_84_list);
		Assert.assertEquals(1, Lines_84_list.size());
		//84
		final Code Code_85_Var
		 = (Code)Lines_84_list.get(0);
		Assert.assertNotNull(Code_85_Var
		);
		Assert.assertEquals("	void no_foo_and_no_bar();", Code_85_Var
		.getCode());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0065_IfElseNested.c");
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
				method.invoke(this.generator, "Test0065_IfElseNested.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0065_IfElseNested.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0065_IfElseNested.c"
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


