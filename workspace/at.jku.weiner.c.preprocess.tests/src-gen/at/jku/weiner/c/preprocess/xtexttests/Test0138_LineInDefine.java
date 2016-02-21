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
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.ConditionalDirective;
import at.jku.weiner.c.preprocess.preprocess.IfDefConditional;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.ConditionalDirective;
import at.jku.weiner.c.preprocess.preprocess.IfNotDefConditional;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.ConditionalDirective;
import at.jku.weiner.c.preprocess.preprocess.IfConditional;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.Code;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class Test0138_LineInDefine {
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
			"res/Test0138_LineInDefine.c");
			final String[] expected = new String[] {
				"RULE_HASH",
				"RULE_DEFINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_LINE",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_LINE",
				"RULE_WHITESPACE",
				"RULE_CHAR_LITERAL",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_LINE",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_DEFINE",
				"RULE_WHITESPACE",
				"RULE_LINE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_IFDEF",
				"RULE_WHITESPACE",
				"RULE_LINE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_ENDIF",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_IFNOTDEF",
				"RULE_WHITESPACE",
				"RULE_LINE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_ENDIF",
				"RULE_NEWLINE",
				"RULE_HASH",
				"RULE_IF",
				"RULE_WHITESPACE",
				"RULE_LINE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
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
			"res/Test0138_LineInDefine.c");
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
		Assert.assertEquals(6, Lines_1_list.size());
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
		Assert.assertEquals("FOO", DefineFunctionLikeMacro_3_Var
		.getId());
		//3
		final IdentifierList IdentifierList_4_Var
		 = (IdentifierList)DefineFunctionLikeMacro_3_Var
		.getList();
		Assert.assertNotNull(IdentifierList_4_Var
		);
		Assert.assertEquals("[line, val]", IdentifierList_4_Var
		.getId().toString());
		Assert.assertEquals("line ':' val", DefineFunctionLikeMacro_3_Var
		.getString());
		//4
		final Code Code_5_Var
		 = (Code)Lines_1_list.get(1);
		Assert.assertNotNull(Code_5_Var
		);
		Assert.assertEquals("FOO(1, line)", Code_5_Var
		.getCode());
		//5
		final PreprocessorDirectives PreprocessorDirectives_6_Var
		 = (PreprocessorDirectives)Lines_1_list.get(2);
		Assert.assertNotNull(PreprocessorDirectives_6_Var
		);
		//6
		final DefineObjectMacro DefineObjectMacro_7_Var
		 = (DefineObjectMacro)PreprocessorDirectives_6_Var
		.getDirective();
		Assert.assertNotNull(DefineObjectMacro_7_Var
		);
		Assert.assertEquals("line", DefineObjectMacro_7_Var
		.getId());
		Assert.assertEquals("1", DefineObjectMacro_7_Var
		.getString());
		//7
		final PreprocessorDirectives PreprocessorDirectives_8_Var
		 = (PreprocessorDirectives)Lines_1_list.get(3);
		Assert.assertNotNull(PreprocessorDirectives_8_Var
		);
		//8
		final ConditionalDirective ConditionalDirective_9_Var
		 = (ConditionalDirective)PreprocessorDirectives_8_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_9_Var
		);
		//9
		final IfDefConditional IfDefConditional_10_Var
		 = (IfDefConditional)ConditionalDirective_9_Var
		.getConditional();
		Assert.assertNotNull(IfDefConditional_10_Var
		);
		Assert.assertEquals("line", IfDefConditional_10_Var
		.getId());
		//10
		final GroupOpt GroupOpt_11_Var
		 = (GroupOpt)IfDefConditional_10_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_11_Var
		);
		final EList<? extends EObject> Lines_11_list = GroupOpt_11_Var
		.getLines();
		Assert.assertNotNull(Lines_11_list);
		Assert.assertEquals(1, Lines_11_list.size());
		//11
		final Code Code_12_Var
		 = (Code)Lines_11_list.get(0);
		Assert.assertNotNull(Code_12_Var
		);
		Assert.assertEquals("	MY_LINE;", Code_12_Var
		.getCode());
		//12
		final PreprocessorDirectives PreprocessorDirectives_13_Var
		 = (PreprocessorDirectives)Lines_1_list.get(4);
		Assert.assertNotNull(PreprocessorDirectives_13_Var
		);
		//13
		final ConditionalDirective ConditionalDirective_14_Var
		 = (ConditionalDirective)PreprocessorDirectives_13_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_14_Var
		);
		//14
		final IfNotDefConditional IfNotDefConditional_15_Var
		 = (IfNotDefConditional)ConditionalDirective_14_Var
		.getConditional();
		Assert.assertNotNull(IfNotDefConditional_15_Var
		);
		Assert.assertEquals("line", IfNotDefConditional_15_Var
		.getId());
		//15
		final GroupOpt GroupOpt_16_Var
		 = (GroupOpt)IfNotDefConditional_15_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_16_Var
		);
		final EList<? extends EObject> Lines_16_list = GroupOpt_16_Var
		.getLines();
		Assert.assertNotNull(Lines_16_list);
		Assert.assertEquals(1, Lines_16_list.size());
		//16
		final Code Code_17_Var
		 = (Code)Lines_16_list.get(0);
		Assert.assertNotNull(Code_17_Var
		);
		Assert.assertEquals("	NO_LINE;", Code_17_Var
		.getCode());
		//17
		final PreprocessorDirectives PreprocessorDirectives_18_Var
		 = (PreprocessorDirectives)Lines_1_list.get(5);
		Assert.assertNotNull(PreprocessorDirectives_18_Var
		);
		//18
		final ConditionalDirective ConditionalDirective_19_Var
		 = (ConditionalDirective)PreprocessorDirectives_18_Var
		.getDirective();
		Assert.assertNotNull(ConditionalDirective_19_Var
		);
		//19
		final IfConditional IfConditional_20_Var
		 = (IfConditional)ConditionalDirective_19_Var
		.getConditional();
		Assert.assertNotNull(IfConditional_20_Var
		);
		//20
		final PrimaryExpression PrimaryExpression_21_Var
		 = (PrimaryExpression)IfConditional_20_Var
		.getExpression();
		Assert.assertNotNull(PrimaryExpression_21_Var
		);
		Assert.assertEquals("line", PrimaryExpression_21_Var
		.getId());
		//21
		final GroupOpt GroupOpt_22_Var
		 = (GroupOpt)IfConditional_20_Var
		.getGroup();
		Assert.assertNotNull(GroupOpt_22_Var
		);
		final EList<? extends EObject> Lines_22_list = GroupOpt_22_Var
		.getLines();
		Assert.assertNotNull(Lines_22_list);
		Assert.assertEquals(1, Lines_22_list.size());
		//22
		final Code Code_23_Var
		 = (Code)Lines_22_list.get(0);
		Assert.assertNotNull(Code_23_Var
		);
		Assert.assertEquals("	MY_LINE2;", Code_23_Var
		.getCode());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0138_LineInDefine.c");
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
				method.invoke(this.generator, "Test0138_LineInDefine.c.i");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0138_LineInDefine.c.i");
		final String expected = this.getTextFromFile(
			"expected/Test0138_LineInDefine.c"
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


