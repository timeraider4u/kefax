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
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
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
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0100_TestDefIf {
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
			"res/Test0100_TestDefIf.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_HASH",
				"RULE_WHITESPACE",
				"RULE_DEFINE",
				"RULE_WHITESPACE",
				"RULE_IF",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_DOT",
				"RULE_SKW_DOT",
				"RULE_SKW_DOT",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_VA_ARGS",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_WHITESPACE",
				"RULE_DEFINE",
				"RULE_WHITESPACE",
				"RULE_ENDIF",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_WHITESPACE",
				"RULE_IF",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_IF",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_WHITESPACE",
				"RULE_ENDIF",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_WHITESPACE",
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
			"res/Test0100_TestDefIf.c");
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
		Assert.assertEquals(4, Lines_1_list.size());
		//1
		final PreprocessorDirectives PreprocessorDirectives_2_Var
		 = (PreprocessorDirectives)Lines_1_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_2_Var
		);
		//2
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_3_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_2_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_3_Var
		);
		Assert.assertEquals("if", DefineFunctionLikeMacro_3_Var
		.getId());
		//3
		final IdentifierList IdentifierList_4_Var
		 = (IdentifierList)DefineFunctionLikeMacro_3_Var
		.getList();
		Assert.assertNotNull(IdentifierList_4_Var
		);
		Assert.assertTrue(IdentifierList_4_Var
		.getId().isEmpty());
		Assert.assertTrue(IdentifierList_4_Var
		.isVariadic());
		final EList<? extends EObject> Replacement_4_list = DefineFunctionLikeMacro_3_Var
		.getReplacement();
		Assert.assertNotNull(Replacement_4_list);
		Assert.assertEquals(1, Replacement_4_list.size());
		//4
		final ReplaceLine ReplaceLine_5_Var
		 = (ReplaceLine)Replacement_4_list.get(0);
		Assert.assertNotNull(ReplaceLine_5_Var
		);
		Assert.assertEquals("trace_if(__VA_ARGS__)", ReplaceLine_5_Var
		.getString());
		//5
		final PreprocessorDirectives PreprocessorDirectives_6_Var
		 = (PreprocessorDirectives)Lines_1_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_6_Var
		);
		//6
		final DefineObjectMacro DefineObjectMacro_7_Var
		 = (DefineObjectMacro)PreprocessorDirectives_6_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_7_Var
		);
		Assert.assertEquals("endif", DefineObjectMacro_7_Var
		.getId());
		Assert.assertEquals("foo", DefineObjectMacro_7_Var
		.getString());
		//7
		final NewLineLine NewLineLine_8_Var
		 = (NewLineLine)Lines_1_list.get(2);
		Assert.assertNotNull(NewLineLine_8_Var
		);
		//8
		final PreprocessorDirectives PreprocessorDirectives_9_Var
		 = (PreprocessorDirectives)Lines_1_list.get(3);
		Assert.assertNotNull(PreprocessorDirectives_9_Var
		);
		//9
		final ConditionalDirective ConditionalDirective_10_Var
		 = (ConditionalDirective)PreprocessorDirectives_9_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_10_Var
		);
		//10
		final IfConditional IfConditional_11_Var
		 = (IfConditional)ConditionalDirective_10_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_11_Var
		);
		//11
		final ConstantExpression ConstantExpression_12_Var
		 = (ConstantExpression)IfConditional_11_Var
		.getExpression();
		Assert.assertNotNull(ConstantExpression_12_Var
		);
		//12
		final ConditionalExpression ConditionalExpression_13_Var
		 = (ConditionalExpression)ConstantExpression_12_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_13_Var
		);
		//13
		final LogicalOrExpression LogicalOrExpression_14_Var
		 = (LogicalOrExpression)ConditionalExpression_13_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = LogicalOrExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		//14
		final LogicalAndExpression LogicalAndExpression_15_Var
		 = (LogicalAndExpression)Expr_14_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = LogicalAndExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final InclusiveOrExpression InclusiveOrExpression_16_Var
		 = (InclusiveOrExpression)Expr_15_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = InclusiveOrExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final ExclusiveOrExpression ExclusiveOrExpression_17_Var
		 = (ExclusiveOrExpression)Expr_16_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = ExclusiveOrExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final AndExpression AndExpression_18_Var
		 = (AndExpression)Expr_17_list.get(0);
		Assert.assertNotNull(AndExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = AndExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final EqualityExpression EqualityExpression_19_Var
		 = (EqualityExpression)Expr_18_list.get(0);
		Assert.assertNotNull(EqualityExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = EqualityExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final RelationalExpression RelationalExpression_20_Var
		 = (RelationalExpression)Expr_19_list.get(0);
		Assert.assertNotNull(RelationalExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = RelationalExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final ShiftExpression ShiftExpression_21_Var
		 = (ShiftExpression)Expr_20_list.get(0);
		Assert.assertNotNull(ShiftExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = ShiftExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final AdditiveExpression AdditiveExpression_22_Var
		 = (AdditiveExpression)Expr_21_list.get(0);
		Assert.assertNotNull(AdditiveExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = AdditiveExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final MultiplicativeExpression MultiplicativeExpression_23_Var
		 = (MultiplicativeExpression)Expr_22_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = MultiplicativeExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final CastExpression CastExpression_24_Var
		 = (CastExpression)Expr_23_list.get(0);
		Assert.assertNotNull(CastExpression_24_Var
		);
		//24
		final UnaryExpression UnaryExpression_25_Var
		 = (UnaryExpression)CastExpression_24_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_25_Var
		);
		//25
		final PostfixExpression PostfixExpression_26_Var
		 = (PostfixExpression)UnaryExpression_25_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_26_Var
		);
		//26
		final PrimaryExpression PrimaryExpression_27_Var
		 = (PrimaryExpression)PostfixExpression_26_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_27_Var
		);
		Assert.assertEquals("1", PrimaryExpression_27_Var
		.getConst());
		//27
		final GroupOpt GroupOpt_28_Var
		 = (GroupOpt)IfConditional_11_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_28_Var
		);
		final EList<? extends EObject> Lines_28_list = GroupOpt_28_Var
		.getLines();
		Assert.assertNotNull(Lines_28_list);
		Assert.assertEquals(2, Lines_28_list.size());
		//28
		final Code Code_29_Var
		 = (Code)Lines_28_list.get(0);
		Assert.assertNotNull(Code_29_Var
		);
		Assert.assertEquals("	if (abc)", Code_29_Var
		.getCode());
		//29
		final Code Code_30_Var
		 = (Code)Lines_28_list.get(1);
		Assert.assertNotNull(Code_30_Var
		);
		Assert.assertEquals("		endif", Code_30_Var
		.getCode());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0100_TestDefIf.c");
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
				method.invoke(this.generator, "Test0100_TestDefIf.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0100_TestDefIf.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0100_TestDefIf.c"
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


