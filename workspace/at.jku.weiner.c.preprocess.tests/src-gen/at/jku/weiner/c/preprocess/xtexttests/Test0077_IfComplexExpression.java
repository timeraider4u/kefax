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
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.ConditionalDirective;
import at.jku.weiner.c.preprocess.preprocess.IfConditional;
import at.jku.weiner.c.common.common.PostfixExpression;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.common.common.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.common.common.ArgumentExpressionList;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0077_IfComplexExpression {
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
			"res/Test0077_IfComplexExpression.c");
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
				"RULE_NEWLINE",
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
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_DEFINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTSHIFT",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_PLUS",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_GREATEREQUAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTSHIFT",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_PLUS",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_IF",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_COMMA",
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
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0077_IfComplexExpression.c");
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
		Assert.assertEquals(9, Lines_1_list.size());
		//1
		final PreprocessorDirectives PreprocessorDirectives_2_Var
		 = (PreprocessorDirectives)Lines_1_list.get(0);
		Assert.assertNotNull(PreprocessorDirectives_2_Var
		);
		//2
		final DefineObjectMacro DefineObjectMacro_3_Var
		 = (DefineObjectMacro)PreprocessorDirectives_2_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_3_Var
		);
		Assert.assertEquals("REQ_MAJOR", DefineObjectMacro_3_Var
		.getId());
		Assert.assertEquals("3", DefineObjectMacro_3_Var
		.getString());
		//3
		final PreprocessorDirectives PreprocessorDirectives_4_Var
		 = (PreprocessorDirectives)Lines_1_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_4_Var
		);
		//4
		final DefineObjectMacro DefineObjectMacro_5_Var
		 = (DefineObjectMacro)PreprocessorDirectives_4_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_5_Var
		);
		Assert.assertEquals("REQ_MINOR", DefineObjectMacro_5_Var
		.getId());
		Assert.assertEquals("2", DefineObjectMacro_5_Var
		.getString());
		//5
		final NewLineLine NewLineLine_6_Var
		 = (NewLineLine)Lines_1_list.get(2);
		Assert.assertNotNull(NewLineLine_6_Var
		);
		//6
		final PreprocessorDirectives PreprocessorDirectives_7_Var
		 = (PreprocessorDirectives)Lines_1_list.get(3);
		Assert.assertNotNull(PreprocessorDirectives_7_Var
		);
		//7
		final DefineObjectMacro DefineObjectMacro_8_Var
		 = (DefineObjectMacro)PreprocessorDirectives_7_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_8_Var
		);
		Assert.assertEquals("MAJOR", DefineObjectMacro_8_Var
		.getId());
		Assert.assertEquals("4", DefineObjectMacro_8_Var
		.getString());
		//8
		final PreprocessorDirectives PreprocessorDirectives_9_Var
		 = (PreprocessorDirectives)Lines_1_list.get(4);
		Assert.assertNotNull(PreprocessorDirectives_9_Var
		);
		//9
		final DefineObjectMacro DefineObjectMacro_10_Var
		 = (DefineObjectMacro)PreprocessorDirectives_9_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_10_Var
		);
		Assert.assertEquals("MINOR", DefineObjectMacro_10_Var
		.getId());
		Assert.assertEquals("1", DefineObjectMacro_10_Var
		.getString());
		//10
		final NewLineLine NewLineLine_11_Var
		 = (NewLineLine)Lines_1_list.get(5);
		Assert.assertNotNull(NewLineLine_11_Var
		);
		//11
		final PreprocessorDirectives PreprocessorDirectives_12_Var
		 = (PreprocessorDirectives)Lines_1_list.get(6);
		Assert.assertNotNull(PreprocessorDirectives_12_Var
		);
		//12
		final DefineFunctionLikeMacro DefineFunctionLikeMacro_13_Var
		 = (DefineFunctionLikeMacro)PreprocessorDirectives_12_Var
		.getDirective();
		Assert.assertNotNull(DefineFunctionLikeMacro_13_Var
		);
		Assert.assertEquals("REQ", DefineFunctionLikeMacro_13_Var
		.getId());
		//13
		final IdentifierList IdentifierList_14_Var
		 = (IdentifierList)DefineFunctionLikeMacro_13_Var
		.getList();
		Assert.assertNotNull(IdentifierList_14_Var
		);
		Assert.assertEquals("[major, minor]", IdentifierList_14_Var
		.getId().toString());
		Assert.assertEquals("((major << 32) + minor >= ((REQ_MAJOR) << 32) + (REQ_MINOR))", DefineFunctionLikeMacro_13_Var
		.getString());
		//14
		final NewLineLine NewLineLine_15_Var
		 = (NewLineLine)Lines_1_list.get(7);
		Assert.assertNotNull(NewLineLine_15_Var
		);
		//15
		final PreprocessorDirectives PreprocessorDirectives_16_Var
		 = (PreprocessorDirectives)Lines_1_list.get(8);
		Assert.assertNotNull(PreprocessorDirectives_16_Var
		);
		//16
		final ConditionalDirective ConditionalDirective_17_Var
		 = (ConditionalDirective)PreprocessorDirectives_16_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_17_Var
		);
		//17
		final IfConditional IfConditional_18_Var
		 = (IfConditional)ConditionalDirective_17_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_18_Var
		);
		//18
		final PostfixExpression PostfixExpression_19_Var
		 = (PostfixExpression)IfConditional_18_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_19_Var
		);
		//19
		final PrimaryExpression PrimaryExpression_20_Var
		 = (PrimaryExpression)PostfixExpression_19_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_20_Var
		);
		Assert.assertEquals("REQ", PrimaryExpression_20_Var
		.getId());
		//20
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_21_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_19_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_21_Var
		);
		//21
		final ArgumentExpressionList ArgumentExpressionList_22_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_21_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_22_Var
		);
		final EList<? extends EObject> Expr_22_list = ArgumentExpressionList_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(2, Expr_22_list.size());
		//22
		final PrimaryExpression PrimaryExpression_23_Var
		 = (PrimaryExpression)Expr_22_list.get(0);
		Assert.assertNotNull(PrimaryExpression_23_Var
		);
		Assert.assertEquals("MAJOR", PrimaryExpression_23_Var
		.getId());
		//23
		final PrimaryExpression PrimaryExpression_24_Var
		 = (PrimaryExpression)Expr_22_list.get(1);
		Assert.assertNotNull(PrimaryExpression_24_Var
		);
		Assert.assertEquals("MINOR", PrimaryExpression_24_Var
		.getId());
		//24
		final GroupOpt GroupOpt_25_Var
		 = (GroupOpt)IfConditional_18_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_25_Var
		);
		final EList<? extends EObject> Lines_25_list = GroupOpt_25_Var
		.getLines();
		Assert.assertNotNull(Lines_25_list);
		Assert.assertEquals(1, Lines_25_list.size());
		//25
		final Code Code_26_Var
		 = (Code)Lines_25_list.get(0);
		Assert.assertNotNull(Code_26_Var
		);
		Assert.assertEquals("	void foo_bar();", Code_26_Var
		.getCode());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0077_IfComplexExpression.c");
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
				method.invoke(this.generator, "Test0077_IfComplexExpression.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0077_IfComplexExpression.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0077_IfComplexExpression.c"
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


