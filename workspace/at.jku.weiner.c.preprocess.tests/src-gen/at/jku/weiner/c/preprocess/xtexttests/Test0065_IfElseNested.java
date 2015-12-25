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
		Assert.assertEquals("64", DefineDirective_5_Var
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
		Assert.assertEquals(1, Expr_14_list.size());
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
		final GroupOpt GroupOpt_27_Var
		 = (GroupOpt)IfConditional_10_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_27_Var
		);
		final EList<? extends EObject> Lines_27_list = GroupOpt_27_Var
		.getLines();
		Assert.assertNotNull(Lines_27_list);
		Assert.assertEquals(2, Lines_27_list.size());
		//27
		final Code Code_28_Var
		 = (Code)Lines_27_list.get(0);
		Assert.assertNotNull(Code_28_Var
		);
		Assert.assertEquals("	void foo();", Code_28_Var
		.getCode());
		//28
		final PreprocessorDirectives PreprocessorDirectives_29_Var
		 = (PreprocessorDirectives)Lines_27_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_29_Var
		);
		//29
		final ConditionalDirective ConditionalDirective_30_Var
		 = (ConditionalDirective)PreprocessorDirectives_29_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_30_Var
		);
		//30
		final IfConditional IfConditional_31_Var
		 = (IfConditional)ConditionalDirective_30_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_31_Var
		);
		//31
		final ConstantExpression ConstantExpression_32_Var
		 = (ConstantExpression)IfConditional_31_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_32_Var
		);
		//32
		final ConditionalExpression ConditionalExpression_33_Var
		 = (ConditionalExpression)ConstantExpression_32_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_33_Var
		);
		//33
		final LogicalOrExpression LogicalOrExpression_34_Var
		 = (LogicalOrExpression)ConditionalExpression_33_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = LogicalOrExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final LogicalAndExpression LogicalAndExpression_35_Var
		 = (LogicalAndExpression)Expr_34_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = LogicalAndExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final InclusiveOrExpression InclusiveOrExpression_36_Var
		 = (InclusiveOrExpression)Expr_35_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = InclusiveOrExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final ExclusiveOrExpression ExclusiveOrExpression_37_Var
		 = (ExclusiveOrExpression)Expr_36_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = ExclusiveOrExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final AndExpression AndExpression_38_Var
		 = (AndExpression)Expr_37_list.get(0);
		Assert.assertNotNull(AndExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = AndExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final EqualityExpression EqualityExpression_39_Var
		 = (EqualityExpression)Expr_38_list.get(0);
		Assert.assertNotNull(EqualityExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = EqualityExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final RelationalExpression RelationalExpression_40_Var
		 = (RelationalExpression)Expr_39_list.get(0);
		Assert.assertNotNull(RelationalExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = RelationalExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final ShiftExpression ShiftExpression_41_Var
		 = (ShiftExpression)Expr_40_list.get(0);
		Assert.assertNotNull(ShiftExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = ShiftExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final AdditiveExpression AdditiveExpression_42_Var
		 = (AdditiveExpression)Expr_41_list.get(0);
		Assert.assertNotNull(AdditiveExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = AdditiveExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final MultiplicativeExpression MultiplicativeExpression_43_Var
		 = (MultiplicativeExpression)Expr_42_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = MultiplicativeExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final CastExpression CastExpression_44_Var
		 = (CastExpression)Expr_43_list.get(0);
		Assert.assertNotNull(CastExpression_44_Var
		);
		//44
		final UnaryExpression UnaryExpression_45_Var
		 = (UnaryExpression)CastExpression_44_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_45_Var
		);
		//45
		final PostfixExpression PostfixExpression_46_Var
		 = (PostfixExpression)UnaryExpression_45_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_46_Var
		);
		//46
		final PrimaryExpression PrimaryExpression_47_Var
		 = (PrimaryExpression)PostfixExpression_46_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_47_Var
		);
		Assert.assertTrue(PrimaryExpression_47_Var
		.isDefined());
		Assert.assertEquals("BAR", PrimaryExpression_47_Var
		.getId());
		//47
		final GroupOpt GroupOpt_48_Var
		 = (GroupOpt)IfConditional_31_Var
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
		Assert.assertEquals("		void bar();", Code_49_Var
		.getCode());
		//49
		final ElseConditional ElseConditional_50_Var
		 = (ElseConditional)ConditionalDirective_30_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_50_Var
		);
		//50
		final GroupOpt GroupOpt_51_Var
		 = (GroupOpt)ElseConditional_50_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_51_Var
		);
		final EList<? extends EObject> Lines_51_list = GroupOpt_51_Var
		.getLines();
		Assert.assertNotNull(Lines_51_list);
		Assert.assertEquals(2, Lines_51_list.size());
		//51
		final Code Code_52_Var
		 = (Code)Lines_51_list.get(0);
		Assert.assertNotNull(Code_52_Var
		);
		Assert.assertEquals("		void no_bar();", Code_52_Var
		.getCode());
		//52
		final PreprocessorDirectives PreprocessorDirectives_53_Var
		 = (PreprocessorDirectives)Lines_51_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_53_Var
		);
		//53
		final ConditionalDirective ConditionalDirective_54_Var
		 = (ConditionalDirective)PreprocessorDirectives_53_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_54_Var
		);
		//54
		final IfConditional IfConditional_55_Var
		 = (IfConditional)ConditionalDirective_54_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_55_Var
		);
		//55
		final ConstantExpression ConstantExpression_56_Var
		 = (ConstantExpression)IfConditional_55_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_56_Var
		);
		//56
		final ConditionalExpression ConditionalExpression_57_Var
		 = (ConditionalExpression)ConstantExpression_56_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_57_Var
		);
		//57
		final LogicalOrExpression LogicalOrExpression_58_Var
		 = (LogicalOrExpression)ConditionalExpression_57_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = LogicalOrExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final LogicalAndExpression LogicalAndExpression_59_Var
		 = (LogicalAndExpression)Expr_58_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = LogicalAndExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final InclusiveOrExpression InclusiveOrExpression_60_Var
		 = (InclusiveOrExpression)Expr_59_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = InclusiveOrExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final ExclusiveOrExpression ExclusiveOrExpression_61_Var
		 = (ExclusiveOrExpression)Expr_60_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = ExclusiveOrExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final AndExpression AndExpression_62_Var
		 = (AndExpression)Expr_61_list.get(0);
		Assert.assertNotNull(AndExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = AndExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final EqualityExpression EqualityExpression_63_Var
		 = (EqualityExpression)Expr_62_list.get(0);
		Assert.assertNotNull(EqualityExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = EqualityExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final RelationalExpression RelationalExpression_64_Var
		 = (RelationalExpression)Expr_63_list.get(0);
		Assert.assertNotNull(RelationalExpression_64_Var
		);
		Assert.assertEquals("[>=]", RelationalExpression_64_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_64_list = RelationalExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(2, Expr_64_list.size());
		//64
		final ShiftExpression ShiftExpression_65_Var
		 = (ShiftExpression)Expr_64_list.get(0);
		Assert.assertNotNull(ShiftExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = ShiftExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final AdditiveExpression AdditiveExpression_66_Var
		 = (AdditiveExpression)Expr_65_list.get(0);
		Assert.assertNotNull(AdditiveExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = AdditiveExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final MultiplicativeExpression MultiplicativeExpression_67_Var
		 = (MultiplicativeExpression)Expr_66_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = MultiplicativeExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final CastExpression CastExpression_68_Var
		 = (CastExpression)Expr_67_list.get(0);
		Assert.assertNotNull(CastExpression_68_Var
		);
		//68
		final UnaryExpression UnaryExpression_69_Var
		 = (UnaryExpression)CastExpression_68_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_69_Var
		);
		//69
		final PostfixExpression PostfixExpression_70_Var
		 = (PostfixExpression)UnaryExpression_69_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_70_Var
		);
		//70
		final PrimaryExpression PrimaryExpression_71_Var
		 = (PrimaryExpression)PostfixExpression_70_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_71_Var
		);
		Assert.assertEquals("FOO", PrimaryExpression_71_Var
		.getId());
		//71
		final ShiftExpression ShiftExpression_72_Var
		 = (ShiftExpression)Expr_64_list.get(1);
		Assert.assertNotNull(ShiftExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = ShiftExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final AdditiveExpression AdditiveExpression_73_Var
		 = (AdditiveExpression)Expr_72_list.get(0);
		Assert.assertNotNull(AdditiveExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = AdditiveExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final MultiplicativeExpression MultiplicativeExpression_74_Var
		 = (MultiplicativeExpression)Expr_73_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = MultiplicativeExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final CastExpression CastExpression_75_Var
		 = (CastExpression)Expr_74_list.get(0);
		Assert.assertNotNull(CastExpression_75_Var
		);
		//75
		final UnaryExpression UnaryExpression_76_Var
		 = (UnaryExpression)CastExpression_75_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_76_Var
		);
		//76
		final PostfixExpression PostfixExpression_77_Var
		 = (PostfixExpression)UnaryExpression_76_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_77_Var
		);
		//77
		final PrimaryExpression PrimaryExpression_78_Var
		 = (PrimaryExpression)PostfixExpression_77_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_78_Var
		);
		Assert.assertEquals("64", PrimaryExpression_78_Var
		.getConst());
		//78
		final GroupOpt GroupOpt_79_Var
		 = (GroupOpt)IfConditional_55_Var
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
		Assert.assertEquals("			void foo_64();", Code_80_Var
		.getCode());
		//80
		final ElseConditional ElseConditional_81_Var
		 = (ElseConditional)ConditionalDirective_54_Var
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
		Assert.assertEquals("			void foo_and_no_bar();", Code_83_Var
		.getCode());
		//83
		final ElseConditional ElseConditional_84_Var
		 = (ElseConditional)ConditionalDirective_9_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_84_Var
		);
		//84
		final GroupOpt GroupOpt_85_Var
		 = (GroupOpt)ElseConditional_84_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_85_Var
		);
		final EList<? extends EObject> Lines_85_list = GroupOpt_85_Var
		.getLines();
		Assert.assertNotNull(Lines_85_list);
		Assert.assertEquals(1, Lines_85_list.size());
		//85
		final Code Code_86_Var
		 = (Code)Lines_85_list.get(0);
		Assert.assertNotNull(Code_86_Var
		);
		Assert.assertEquals("	void no_foo_and_no_bar();", Code_86_Var
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


