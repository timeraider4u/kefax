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
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.StorageClassSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.LabeledStatement;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0075_LocalLabel {
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
			"res/Test0075_LocalLabel.c");
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
				"RULE_KW_LABEL3",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_GOTO",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_STRING_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_STRING_LITERAL",
				"RULE_SKW_RIGHTPAREN",
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
			"res/Test0075_LocalLabel.c");
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
		Assert.assertEquals("doSomething", DirectDeclarator_6_Var
		.getId());
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
		final EList<? extends EObject> Declaration_9_list = BlockList_9_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_9_list);
		Assert.assertEquals(1, Declaration_9_list.size());
		//9
		final Declaration Declaration_10_Var
		 = (Declaration)Declaration_9_list.get(0);
		Assert.assertNotNull(Declaration_10_Var
		);
		//10
		final DeclarationSpecifiers DeclarationSpecifiers_11_Var
		 = (DeclarationSpecifiers)Declaration_10_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_11_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_11_list = DeclarationSpecifiers_11_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_11_list);
		Assert.assertEquals(1, DeclarationSpecifier_11_list.size());
		//11
		final StorageClassSpecifier StorageClassSpecifier_12_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_11_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_12_Var
		);
		Assert.assertEquals("__label__", StorageClassSpecifier_12_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_12_list = Declaration_10_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_12_list);
		Assert.assertEquals(1, InitDeclaratorList_12_list.size());
		//12
		final InitDeclaratorList InitDeclaratorList_13_Var
		 = (InitDeclaratorList)InitDeclaratorList_12_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_13_Var
		);
		final EList<? extends EObject> InitDeclarator_13_list = InitDeclaratorList_13_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_13_list);
		Assert.assertEquals(1, InitDeclarator_13_list.size());
		//13
		final InitDeclarator InitDeclarator_14_Var
		 = (InitDeclarator)InitDeclarator_13_list.get(0);
		Assert.assertNotNull(InitDeclarator_14_Var
		);
		//14
		final Declarator Declarator_15_Var
		 = (Declarator)InitDeclarator_14_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_15_Var
		);
		//15
		final DirectDeclarator DirectDeclarator_16_Var
		 = (DirectDeclarator)Declarator_15_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_16_Var
		);
		Assert.assertEquals("target", DirectDeclarator_16_Var
		.getId());
		final EList<? extends EObject> Statement_16_list = BlockList_9_Var
		.getStatement();
		Assert.assertNotNull(Statement_16_list);
		Assert.assertEquals(3, Statement_16_list.size());
		//16
		final Statement Statement_17_Var
		 = (Statement)Statement_16_list.get(0);
		Assert.assertNotNull(Statement_17_Var
		);
		//17
		final JumpStatement JumpStatement_18_Var
		 = (JumpStatement)Statement_17_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_18_Var
		);
		//18
		final PrimaryExpression PrimaryExpression_19_Var
		 = (PrimaryExpression)JumpStatement_18_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_19_Var
		);
		Assert.assertEquals("target", PrimaryExpression_19_Var
		.getId());
		Assert.assertEquals("goto", JumpStatement_18_Var
		.getGoto());
		//19
		final Statement Statement_20_Var
		 = (Statement)Statement_16_list.get(1);
		Assert.assertNotNull(Statement_20_Var
		);
		//20
		final ExpressionStatement ExpressionStatement_21_Var
		 = (ExpressionStatement)Statement_20_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_21_Var
		);
		//21
		final PostfixExpression PostfixExpression_22_Var
		 = (PostfixExpression)ExpressionStatement_21_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_22_Var
		);
		//22
		final PrimaryExpression PrimaryExpression_23_Var
		 = (PrimaryExpression)PostfixExpression_22_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_23_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_23_Var
		.getId());
		//23
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_24_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_22_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_24_Var
		);
		//24
		final ArgumentExpressionList ArgumentExpressionList_25_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_24_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_25_Var
		);
		final EList<? extends EObject> Expr_25_list = ArgumentExpressionList_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final PrimaryExpression PrimaryExpression_26_Var
		 = (PrimaryExpression)Expr_25_list.get(0);
		Assert.assertNotNull(PrimaryExpression_26_Var
		);
		Assert.assertEquals("[\"will never be reached\\n\"]", PrimaryExpression_26_Var
		.getString().toString());
		//26
		final Statement Statement_27_Var
		 = (Statement)Statement_16_list.get(2);
		Assert.assertNotNull(Statement_27_Var
		);
		//27
		final LabeledStatement LabeledStatement_28_Var
		 = (LabeledStatement)Statement_27_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_28_Var
		);
		Assert.assertEquals("target", LabeledStatement_28_Var
		.getId());
		//28
		final Statement Statement_29_Var
		 = (Statement)LabeledStatement_28_Var
		.getLStmt();
		Assert.assertNotNull(Statement_29_Var
		);
		//29
		final ExpressionStatement ExpressionStatement_30_Var
		 = (ExpressionStatement)Statement_29_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_30_Var
		);
		//30
		final PostfixExpression PostfixExpression_31_Var
		 = (PostfixExpression)ExpressionStatement_30_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_31_Var
		);
		//31
		final PrimaryExpression PrimaryExpression_32_Var
		 = (PrimaryExpression)PostfixExpression_31_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_32_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_32_Var
		.getId());
		//32
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_33_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_31_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_33_Var
		);
		//33
		final ArgumentExpressionList ArgumentExpressionList_34_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_33_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_34_Var
		);
		final EList<? extends EObject> Expr_34_list = ArgumentExpressionList_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final PrimaryExpression PrimaryExpression_35_Var
		 = (PrimaryExpression)Expr_34_list.get(0);
		Assert.assertNotNull(PrimaryExpression_35_Var
		);
		Assert.assertEquals("[\"reached target\\n\"]", PrimaryExpression_35_Var
		.getString().toString());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0075_LocalLabel.c");
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
				method.invoke(this.generator, "Test0075_LocalLabel.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0075_LocalLabel.c");
		final String expected = this.getTextFromFile(
			"res/Test0075_LocalLabel.c"
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


