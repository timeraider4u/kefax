package at.jku.weiner.c.parser.xtexttests;

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
import at.jku.weiner.c.parser.tests.ParserInjectorProvider;
import at.jku.weiner.c.parser.parser.antlr.ParserParser;
import at.jku.weiner.c.parser.parser.antlr.internal.InternalParserLexer;
import at.jku.weiner.c.parser.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.parser.parser.Parser;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.AsmStatement;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.LabeledStatement;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0093_AsmGoto {
	@Inject
	private ParseHelper<Parser> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalParserLexer lexer;
	@Inject
	private ParserParser parser;
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
			"res/Test0093_AsmGoto.c");
			final String[] expected = new String[] {
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_IGNORED",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_IGNORED",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_IGNORED",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_ASM1",
				"RULE_WHITESPACE",
				"RULE_KW_GOTO",
				"RULE_SKW_LEFTPAREN",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0093_AsmGoto.c");
		final Parser Parser_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(Parser_0_Var
		);
		
		Assert.assertNotNull(Parser_0_Var
		);
		final EList<? extends EObject> External_0_list = Parser_0_Var
		.getExternal();
		Assert.assertNotNull(External_0_list);
		Assert.assertEquals(1, External_0_list.size());
		//0
		final ExternalDeclaration ExternalDeclaration_1_Var
		 = (ExternalDeclaration)External_0_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_1_Var
		);
		//1
		final FunctionDefHead FunctionDefHead_2_Var
		 = (FunctionDefHead)ExternalDeclaration_1_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_2_Var
		);
		//2
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_3_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_2_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_3_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_3_list = FunctionDeclarationSpecifiers_3_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_3_list);
		Assert.assertEquals(1, DeclarationSpecifier_3_list.size());
		//3
		final TypeSpecifier TypeSpecifier_4_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(TypeSpecifier_4_Var
		);
		Assert.assertEquals("void", TypeSpecifier_4_Var
		.getName());
		//4
		final Declarator Declarator_5_Var
		 = (Declarator)FunctionDefHead_2_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_5_Var
		);
		//5
		final DirectDeclarator DirectDeclarator_6_Var
		 = (DirectDeclarator)Declarator_5_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_6_Var
		);
		Assert.assertEquals("foo", DirectDeclarator_6_Var
		.getIdent());
		//6
		final FunctionDefinition FunctionDefinition_7_Var
		 = (FunctionDefinition)ExternalDeclaration_1_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_7_Var
		);
		//7
		final BodyStatement BodyStatement_8_Var
		 = (BodyStatement)FunctionDefinition_7_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_8_Var
		);
		final EList<? extends EObject> BlockList_8_list = BodyStatement_8_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_8_list);
		Assert.assertEquals(1, BlockList_8_list.size());
		//8
		final BlockList BlockList_9_Var
		 = (BlockList)BlockList_8_list.get(0);
		Assert.assertNotNull(BlockList_9_Var
		);
		final EList<? extends EObject> Statement_9_list = BlockList_9_Var
		.getStatement();
		Assert.assertNotNull(Statement_9_list);
		Assert.assertEquals(2, Statement_9_list.size());
		//9
		final Statement Statement_10_Var
		 = (Statement)Statement_9_list.get(0);
		Assert.assertNotNull(Statement_10_Var
		);
		//10
		final AsmStatement AsmStatement_11_Var
		 = (AsmStatement)Statement_10_Var
		.getStmt();
		Assert.assertNotNull(AsmStatement_11_Var
		);
		Assert.assertEquals("goto", AsmStatement_11_Var
		.getGoto());
		//11
		final AsmLine AsmLine_12_Var
		 = (AsmLine)AsmStatement_11_Var
		.getAsmLine1();
		Assert.assertNotNull(AsmLine_12_Var
		);
		Assert.assertNull(AsmLine_12_Var
		.getSym());
		//12
		final PrimaryExpression PrimaryExpression_13_Var
		 = (PrimaryExpression)AsmLine_12_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_13_Var
		);
		Assert.assertEquals("[\"mov %[e], %[d]; jc %l[my_label]\"]", PrimaryExpression_13_Var
		.getString().toString());
		final EList<? extends EObject> AsmLines_13_list = AsmStatement_11_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_13_list);
		Assert.assertEquals(4, AsmLines_13_list.size());
		//13
		final AsmLineWithColon AsmLineWithColon_14_Var
		 = (AsmLineWithColon)AsmLines_13_list.get(0);
		Assert.assertNotNull(AsmLineWithColon_14_Var
		);
		Assert.assertNull(AsmLineWithColon_14_Var
		.getAsmLine());
		//14
		final AsmLineWithColon AsmLineWithColon_15_Var
		 = (AsmLineWithColon)AsmLines_13_list.get(1);
		Assert.assertNotNull(AsmLineWithColon_15_Var
		);
		//15
		final AsmLineWithoutColon AsmLineWithoutColon_16_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_15_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_16_Var
		);
		final EList<? extends EObject> AsmLines_16_list = AsmLineWithoutColon_16_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_16_list);
		Assert.assertEquals(1, AsmLines_16_list.size());
		//16
		final AsmLine AsmLine_17_Var
		 = (AsmLine)AsmLines_16_list.get(0);
		Assert.assertNotNull(AsmLine_17_Var
		);
		Assert.assertNull(AsmLine_17_Var
		.getSym());
		//17
		final PrimaryExpression PrimaryExpression_18_Var
		 = (PrimaryExpression)AsmLine_17_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_18_Var
		);
		Assert.assertEquals("[\"\"]", PrimaryExpression_18_Var
		.getString().toString());
		//18
		final AsmLineWithColon AsmLineWithColon_19_Var
		 = (AsmLineWithColon)AsmLines_13_list.get(2);
		Assert.assertNotNull(AsmLineWithColon_19_Var
		);
		//19
		final AsmLineWithoutColon AsmLineWithoutColon_20_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_19_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_20_Var
		);
		final EList<? extends EObject> AsmLines_20_list = AsmLineWithoutColon_20_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_20_list);
		Assert.assertEquals(1, AsmLines_20_list.size());
		//20
		final AsmLine AsmLine_21_Var
		 = (AsmLine)AsmLines_20_list.get(0);
		Assert.assertNotNull(AsmLine_21_Var
		);
		Assert.assertNull(AsmLine_21_Var
		.getSym());
		//21
		final PrimaryExpression PrimaryExpression_22_Var
		 = (PrimaryExpression)AsmLine_21_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_22_Var
		);
		Assert.assertEquals("[\"\"]", PrimaryExpression_22_Var
		.getString().toString());
		//22
		final AsmLineWithColon AsmLineWithColon_23_Var
		 = (AsmLineWithColon)AsmLines_13_list.get(3);
		Assert.assertNotNull(AsmLineWithColon_23_Var
		);
		//23
		final AsmLineWithoutColon AsmLineWithoutColon_24_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_23_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_24_Var
		);
		final EList<? extends EObject> AsmLines_24_list = AsmLineWithoutColon_24_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_24_list);
		Assert.assertEquals(1, AsmLines_24_list.size());
		//24
		final AsmLine AsmLine_25_Var
		 = (AsmLine)AsmLines_24_list.get(0);
		Assert.assertNotNull(AsmLine_25_Var
		);
		Assert.assertNull(AsmLine_25_Var
		.getSym());
		//25
		final PrimaryExpression PrimaryExpression_26_Var
		 = (PrimaryExpression)AsmLine_25_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_26_Var
		);
		Assert.assertEquals("my_label", PrimaryExpression_26_Var
		.getIdent());
		//26
		final Statement Statement_27_Var
		 = (Statement)Statement_9_list.get(1);
		Assert.assertNotNull(Statement_27_Var
		);
		//27
		final LabeledStatement LabeledStatement_28_Var
		 = (LabeledStatement)Statement_27_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_28_Var
		);
		Assert.assertEquals("my_label", LabeledStatement_28_Var
		.getIdent());
		//28
		final Statement Statement_29_Var
		 = (Statement)LabeledStatement_28_Var
		.getLStmt();
		Assert.assertNotNull(Statement_29_Var
		);
		//29
		final JumpStatement JumpStatement_30_Var
		 = (JumpStatement)Statement_29_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_30_Var
		);
		Assert.assertEquals("return", JumpStatement_30_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0093_AsmGoto.c");
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
				method.invoke(this.generator, "Test0093_AsmGoto.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0093_AsmGoto.c");
		final String expected = this.getTextFromFile(
			"res/Test0093_AsmGoto.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
	}
	
	private String preprocess(String string) throws Exception {
		string = preprocessForFile(string);
		string = preprocessForPatterns(string);
		return string;
	}
	
	private String preprocessForFile(String string) throws Exception {
		final String content = this.getTextFromFile("res/Patterns.txt");
		final String[] lines = content.split("\n");
		if (lines == null) {
			return string;
		}
		for (String line : lines) {
			final String[] myLine = line.split("=");
			if (myLine == null || myLine.length != 2) {
				continue;
			}
			final String regex = myLine[0].replace("\"", "").replace("\\\\", "\\");
			final String replace = myLine[1].replace("\"", "").replace("\\\\", "\\");
			string = string.replaceAll(regex, replace);
		}
		return string;
	}
	
	private String preprocessForPatterns(String string) {
		return string;
	}
	
}


