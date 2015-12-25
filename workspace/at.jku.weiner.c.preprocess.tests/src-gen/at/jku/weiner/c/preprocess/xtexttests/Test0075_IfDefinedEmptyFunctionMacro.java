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
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
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
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0075_IfDefinedEmptyFunctionMacro {
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
			"res/Test0075_IfDefinedEmptyFunctionMacro.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_HASH", 
				"RULE_DEFINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_NEWLINE", 
				"RULE_HASH", 
				"RULE_IF", 
				"RULE_WHITESPACE", 
				"RULE_DEFINED", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
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
			"res/Test0075_IfDefinedEmptyFunctionMacro.c");
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
		Assert.assertEquals(2, Lines_3_list.size());
		//3
		final PreprocessorDirectives PreprocessorDirectives_4_Var
		 = (PreprocessorDirectives)Lines_3_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_4_Var
		);
		//4
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_5_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_4_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_5_Var
		);
		Assert.assertEquals("FOO", DefineFunctionLikeMacro_5_Var
		.getId());
		//5
		final IdentifierList IdentifierList_6_Var
		 = (IdentifierList)DefineFunctionLikeMacro_5_Var
		.getList();
		Assert.assertNotNull(IdentifierList_6_Var
		);
		Assert.assertEquals("[bar]", IdentifierList_6_Var
		.getId().toString());
		Assert.assertNull(DefineFunctionLikeMacro_5_Var
		.getString());
		//6
		final PreprocessorDirectives PreprocessorDirectives_7_Var
		 = (PreprocessorDirectives)Lines_3_list.get(1);
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
		Assert.assertEquals("	void foo_bar();", Code_27_Var
		.getCode());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0075_IfDefinedEmptyFunctionMacro.c");
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
				method.invoke(this.generator, "Test0075_IfDefinedEmptyFunctionMacro.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0075_IfDefinedEmptyFunctionMacro.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0075_IfDefinedEmptyFunctionMacro.c"
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


