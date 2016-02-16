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
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.ConditionalDirective;
import at.jku.weiner.c.preprocess.preprocess.IfConditional;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.ElseConditional;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.ConditionalDirective;
import at.jku.weiner.c.preprocess.preprocess.IfConditional;
import at.jku.weiner.c.common.common.RelationalExpression;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
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
		final PrimaryExpression PrimaryExpression_7_Var
		 = (PrimaryExpression)IfConditional_6_Var
		.getExpression();
		Assert.assertNotNull(PrimaryExpression_7_Var
		);
		Assert.assertTrue(PrimaryExpression_7_Var
		.isDefined());
		Assert.assertEquals("FOO", PrimaryExpression_7_Var
		.getId());
		//7
		final GroupOpt GroupOpt_8_Var
		 = (GroupOpt)IfConditional_6_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_8_Var
		);
		final EList<? extends EObject> Lines_8_list = GroupOpt_8_Var
		.getLines();
		Assert.assertNotNull(Lines_8_list);
		Assert.assertEquals(2, Lines_8_list.size());
		//8
		final Code Code_9_Var
		 = (Code)Lines_8_list.get(0);
		Assert.assertNotNull(Code_9_Var
		);
		Assert.assertEquals("	void foo();", Code_9_Var
		.getCode());
		//9
		final PreprocessorDirectives PreprocessorDirectives_10_Var
		 = (PreprocessorDirectives)Lines_8_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_10_Var
		);
		//10
		final ConditionalDirective ConditionalDirective_11_Var
		 = (ConditionalDirective)PreprocessorDirectives_10_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_11_Var
		);
		//11
		final IfConditional IfConditional_12_Var
		 = (IfConditional)ConditionalDirective_11_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_12_Var
		);
		//12
		final PrimaryExpression PrimaryExpression_13_Var
		 = (PrimaryExpression)IfConditional_12_Var
		.getExpression();
		Assert.assertNotNull(PrimaryExpression_13_Var
		);
		Assert.assertTrue(PrimaryExpression_13_Var
		.isDefined());
		Assert.assertEquals("BAR", PrimaryExpression_13_Var
		.getId());
		//13
		final GroupOpt GroupOpt_14_Var
		 = (GroupOpt)IfConditional_12_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_14_Var
		);
		final EList<? extends EObject> Lines_14_list = GroupOpt_14_Var
		.getLines();
		Assert.assertNotNull(Lines_14_list);
		Assert.assertEquals(1, Lines_14_list.size());
		//14
		final Code Code_15_Var
		 = (Code)Lines_14_list.get(0);
		Assert.assertNotNull(Code_15_Var
		);
		Assert.assertEquals("		void bar();", Code_15_Var
		.getCode());
		//15
		final ElseConditional ElseConditional_16_Var
		 = (ElseConditional)ConditionalDirective_11_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_16_Var
		);
		//16
		final GroupOpt GroupOpt_17_Var
		 = (GroupOpt)ElseConditional_16_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_17_Var
		);
		final EList<? extends EObject> Lines_17_list = GroupOpt_17_Var
		.getLines();
		Assert.assertNotNull(Lines_17_list);
		Assert.assertEquals(2, Lines_17_list.size());
		//17
		final Code Code_18_Var
		 = (Code)Lines_17_list.get(0);
		Assert.assertNotNull(Code_18_Var
		);
		Assert.assertEquals("		void no_bar();", Code_18_Var
		.getCode());
		//18
		final PreprocessorDirectives PreprocessorDirectives_19_Var
		 = (PreprocessorDirectives)Lines_17_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_19_Var
		);
		//19
		final ConditionalDirective ConditionalDirective_20_Var
		 = (ConditionalDirective)PreprocessorDirectives_19_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_20_Var
		);
		//20
		final IfConditional IfConditional_21_Var
		 = (IfConditional)ConditionalDirective_20_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_21_Var
		);
		//21
		final RelationalExpression RelationalExpression_22_Var
		 = (RelationalExpression)IfConditional_21_Var
		.getExpression();
		Assert.assertNotNull(RelationalExpression_22_Var
		);
		Assert.assertEquals(">=", RelationalExpression_22_Var
		.getOp());
		//22
		final PrimaryExpression PrimaryExpression_23_Var
		 = (PrimaryExpression)RelationalExpression_22_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_23_Var
		);
		Assert.assertEquals("FOO", PrimaryExpression_23_Var
		.getId());
		//23
		final PrimaryExpression PrimaryExpression_24_Var
		 = (PrimaryExpression)RelationalExpression_22_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_24_Var
		);
		Assert.assertEquals("64", PrimaryExpression_24_Var
		.getConst());
		//24
		final GroupOpt GroupOpt_25_Var
		 = (GroupOpt)IfConditional_21_Var
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
		Assert.assertEquals("			void foo_64();", Code_26_Var
		.getCode());
		//26
		final ElseConditional ElseConditional_27_Var
		 = (ElseConditional)ConditionalDirective_20_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_27_Var
		);
		//27
		final GroupOpt GroupOpt_28_Var
		 = (GroupOpt)ElseConditional_27_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_28_Var
		);
		final EList<? extends EObject> Lines_28_list = GroupOpt_28_Var
		.getLines();
		Assert.assertNotNull(Lines_28_list);
		Assert.assertEquals(1, Lines_28_list.size());
		//28
		final Code Code_29_Var
		 = (Code)Lines_28_list.get(0);
		Assert.assertNotNull(Code_29_Var
		);
		Assert.assertEquals("			void foo_and_no_bar();", Code_29_Var
		.getCode());
		//29
		final ElseConditional ElseConditional_30_Var
		 = (ElseConditional)ConditionalDirective_5_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_30_Var
		);
		//30
		final GroupOpt GroupOpt_31_Var
		 = (GroupOpt)ElseConditional_30_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_31_Var
		);
		final EList<? extends EObject> Lines_31_list = GroupOpt_31_Var
		.getLines();
		Assert.assertNotNull(Lines_31_list);
		Assert.assertEquals(1, Lines_31_list.size());
		//31
		final Code Code_32_Var
		 = (Code)Lines_31_list.get(0);
		Assert.assertNotNull(Code_32_Var
		);
		Assert.assertEquals("	void no_foo_and_no_bar();", Code_32_Var
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
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0062_IfElseNested.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0062_IfElseNested.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
	}
	
	private String preprocess(String string) throws Exception {
		string = preprocessForPatterns(string);
		return string;
	}
	
	
	private String preprocessForPatterns(String string) {
		return string;
	}
	
}


