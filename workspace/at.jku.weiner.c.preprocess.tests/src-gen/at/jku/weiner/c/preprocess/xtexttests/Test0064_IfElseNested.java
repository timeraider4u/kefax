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
public class Test0064_IfElseNested {
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
			"res/Test0064_IfElseNested.c");
			final String[] expected = new String[] {
				"RULE_HASH",
				"RULE_DEFINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_NEWLINE",
				"RULE_IGNORED",
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
				"RULE_IGNORED",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_HASH",
				"RULE_ENDIF",
				"RULE_WHITESPACE",
				"RULE_IGNORED",
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
			"res/Test0064_IfElseNested.c");
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
		Assert.assertEquals("FOO", DefineObjectMacro_3_Var
		.getIdent());
		Assert.assertEquals("64", DefineObjectMacro_3_Var
		.getString());
		//3
		final NewLineLine NewLineLine_4_Var
		 = (NewLineLine)Lines_1_list.get(1);
		Assert.assertNotNull(NewLineLine_4_Var
		);
		//4
		final PreprocessorDirectives PreprocessorDirectives_5_Var
		 = (PreprocessorDirectives)Lines_1_list.get(2);
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
		final PrimaryExpression PrimaryExpression_8_Var
		 = (PrimaryExpression)IfConditional_7_Var
		.getExpression();
		Assert.assertNotNull(PrimaryExpression_8_Var
		);
		Assert.assertTrue(PrimaryExpression_8_Var
		.isDefined());
		Assert.assertEquals("FOO", PrimaryExpression_8_Var
		.getIdent());
		//8
		final GroupOpt GroupOpt_9_Var
		 = (GroupOpt)IfConditional_7_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_9_Var
		);
		final EList<? extends EObject> Lines_9_list = GroupOpt_9_Var
		.getLines();
		Assert.assertNotNull(Lines_9_list);
		Assert.assertEquals(2, Lines_9_list.size());
		//9
		final Code Code_10_Var
		 = (Code)Lines_9_list.get(0);
		Assert.assertNotNull(Code_10_Var
		);
		Assert.assertEquals("	void foo();", Code_10_Var
		.getCode());
		//10
		final PreprocessorDirectives PreprocessorDirectives_11_Var
		 = (PreprocessorDirectives)Lines_9_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_11_Var
		);
		//11
		final ConditionalDirective ConditionalDirective_12_Var
		 = (ConditionalDirective)PreprocessorDirectives_11_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_12_Var
		);
		//12
		final IfConditional IfConditional_13_Var
		 = (IfConditional)ConditionalDirective_12_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_13_Var
		);
		//13
		final PrimaryExpression PrimaryExpression_14_Var
		 = (PrimaryExpression)IfConditional_13_Var
		.getExpression();
		Assert.assertNotNull(PrimaryExpression_14_Var
		);
		Assert.assertTrue(PrimaryExpression_14_Var
		.isDefined());
		Assert.assertEquals("BAR", PrimaryExpression_14_Var
		.getIdent());
		//14
		final GroupOpt GroupOpt_15_Var
		 = (GroupOpt)IfConditional_13_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_15_Var
		);
		final EList<? extends EObject> Lines_15_list = GroupOpt_15_Var
		.getLines();
		Assert.assertNotNull(Lines_15_list);
		Assert.assertEquals(1, Lines_15_list.size());
		//15
		final Code Code_16_Var
		 = (Code)Lines_15_list.get(0);
		Assert.assertNotNull(Code_16_Var
		);
		Assert.assertEquals("		void bar();", Code_16_Var
		.getCode());
		//16
		final ElseConditional ElseConditional_17_Var
		 = (ElseConditional)ConditionalDirective_12_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_17_Var
		);
		//17
		final GroupOpt GroupOpt_18_Var
		 = (GroupOpt)ElseConditional_17_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_18_Var
		);
		final EList<? extends EObject> Lines_18_list = GroupOpt_18_Var
		.getLines();
		Assert.assertNotNull(Lines_18_list);
		Assert.assertEquals(2, Lines_18_list.size());
		//18
		final Code Code_19_Var
		 = (Code)Lines_18_list.get(0);
		Assert.assertNotNull(Code_19_Var
		);
		Assert.assertEquals("		void no_bar();", Code_19_Var
		.getCode());
		//19
		final PreprocessorDirectives PreprocessorDirectives_20_Var
		 = (PreprocessorDirectives)Lines_18_list.get(1);
		Assert.assertNotNull(PreprocessorDirectives_20_Var
		);
		//20
		final ConditionalDirective ConditionalDirective_21_Var
		 = (ConditionalDirective)PreprocessorDirectives_20_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_21_Var
		);
		//21
		final IfConditional IfConditional_22_Var
		 = (IfConditional)ConditionalDirective_21_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_22_Var
		);
		//22
		final RelationalExpression RelationalExpression_23_Var
		 = (RelationalExpression)IfConditional_22_Var
		.getExpression();
		Assert.assertNotNull(RelationalExpression_23_Var
		);
		Assert.assertEquals(">=", RelationalExpression_23_Var
		.getOp());
		//23
		final PrimaryExpression PrimaryExpression_24_Var
		 = (PrimaryExpression)RelationalExpression_23_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_24_Var
		);
		Assert.assertEquals("FOO", PrimaryExpression_24_Var
		.getIdent());
		//24
		final PrimaryExpression PrimaryExpression_25_Var
		 = (PrimaryExpression)RelationalExpression_23_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_25_Var
		);
		Assert.assertEquals("64", PrimaryExpression_25_Var
		.getConst());
		//25
		final GroupOpt GroupOpt_26_Var
		 = (GroupOpt)IfConditional_22_Var
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
		Assert.assertEquals("			void foo_64();", Code_27_Var
		.getCode());
		//27
		final ElseConditional ElseConditional_28_Var
		 = (ElseConditional)ConditionalDirective_21_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_28_Var
		);
		//28
		final GroupOpt GroupOpt_29_Var
		 = (GroupOpt)ElseConditional_28_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_29_Var
		);
		final EList<? extends EObject> Lines_29_list = GroupOpt_29_Var
		.getLines();
		Assert.assertNotNull(Lines_29_list);
		Assert.assertEquals(1, Lines_29_list.size());
		//29
		final Code Code_30_Var
		 = (Code)Lines_29_list.get(0);
		Assert.assertNotNull(Code_30_Var
		);
		Assert.assertEquals("			void foo_and_no_bar();", Code_30_Var
		.getCode());
		//30
		final ElseConditional ElseConditional_31_Var
		 = (ElseConditional)ConditionalDirective_6_Var
		.getElse();
		Assert.assertNotNull(ElseConditional_31_Var
		);
		//31
		final GroupOpt GroupOpt_32_Var
		 = (GroupOpt)ElseConditional_31_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_32_Var
		);
		final EList<? extends EObject> Lines_32_list = GroupOpt_32_Var
		.getLines();
		Assert.assertNotNull(Lines_32_list);
		Assert.assertEquals(1, Lines_32_list.size());
		//32
		final Code Code_33_Var
		 = (Code)Lines_32_list.get(0);
		Assert.assertNotNull(Code_33_Var
		);
		Assert.assertEquals("	void no_foo_and_no_bar();", Code_33_Var
		.getCode());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0064_IfElseNested.c");
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
				method.invoke(this.generator, "Test0064_IfElseNested.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0064_IfElseNested.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0064_IfElseNested.c"
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


