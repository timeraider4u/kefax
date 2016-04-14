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
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitializerList;
import at.jku.weiner.c.parser.parser.Init;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.CompoundStatement;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0064_BlocksInExpressions {
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
			"res/Test0064_BlocksInExpressions.c");
			final String[] expected = new String[] {
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_PLUS",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_INT",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_OROR",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_SKW_RIGHTPAREN",
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
			"res/Test0064_BlocksInExpressions.c");
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
		Assert.assertEquals("int", TypeSpecifier_4_Var
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
		final ExpressionStatement ExpressionStatement_11_Var
		 = (ExpressionStatement)Statement_10_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_11_Var
		);
		//11
		final AdditiveExpression AdditiveExpression_12_Var
		 = (AdditiveExpression)ExpressionStatement_11_Var
		.getExpression();
		Assert.assertNotNull(AdditiveExpression_12_Var
		);
		//12
		final PrimaryExpression PrimaryExpression_13_Var
		 = (PrimaryExpression)AdditiveExpression_12_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_13_Var
		);
		//13
		final Constant2 Constant2_14_Var
		 = (Constant2)PrimaryExpression_13_Var
		.getConst();
		Assert.assertNotNull(Constant2_14_Var
		);
		Assert.assertEquals("1", Constant2_14_Var
		.getDec());
		Assert.assertEquals("+", AdditiveExpression_12_Var
		.getOp());
		//14
		final PostfixExpression PostfixExpression_15_Var
		 = (PostfixExpression)AdditiveExpression_12_Var
		.getRight();
		Assert.assertNotNull(PostfixExpression_15_Var
		);
		Assert.assertNull(PostfixExpression_15_Var
		.getExpr());
		Assert.assertFalse(PostfixExpression_15_Var
		.isExt());
		//15
		final TypeName TypeName_16_Var
		 = (TypeName)PostfixExpression_15_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_16_Var
		);
		//16
		final SpecifierQualifierList SpecifierQualifierList_17_Var
		 = (SpecifierQualifierList)TypeName_16_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_17_Var
		);
		final EList<? extends EObject> TypeSpecifier_17_list = SpecifierQualifierList_17_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_17_list);
		Assert.assertEquals(1, TypeSpecifier_17_list.size());
		//17
		final TypeSpecifier TypeSpecifier_18_Var
		 = (TypeSpecifier)TypeSpecifier_17_list.get(0);
		Assert.assertNotNull(TypeSpecifier_18_Var
		);
		Assert.assertEquals("int", TypeSpecifier_18_Var
		.getName());
		//18
		final InitializerList InitializerList_19_Var
		 = (InitializerList)PostfixExpression_15_Var
		.getInitializerList();
		Assert.assertNotNull(InitializerList_19_Var
		);
		final EList<? extends EObject> Init_19_list = InitializerList_19_Var
		.getInit();
		Assert.assertNotNull(Init_19_list);
		Assert.assertEquals(1, Init_19_list.size());
		//19
		final Init Init_20_Var
		 = (Init)Init_19_list.get(0);
		Assert.assertNotNull(Init_20_Var
		);
		//20
		final Initializer Initializer_21_Var
		 = (Initializer)Init_20_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_21_Var
		);
		//21
		final PrimaryExpression PrimaryExpression_22_Var
		 = (PrimaryExpression)Initializer_21_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_22_Var
		);
		//22
		final Constant2 Constant2_23_Var
		 = (Constant2)PrimaryExpression_22_Var
		.getConst();
		Assert.assertNotNull(Constant2_23_Var
		);
		Assert.assertEquals("7", Constant2_23_Var
		.getDec());
		//23
		final Statement Statement_24_Var
		 = (Statement)Statement_9_list.get(1);
		Assert.assertNotNull(Statement_24_Var
		);
		//24
		final JumpStatement JumpStatement_25_Var
		 = (JumpStatement)Statement_24_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_25_Var
		);
		//25
		final PrimaryExpression PrimaryExpression_26_Var
		 = (PrimaryExpression)JumpStatement_25_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_26_Var
		);
		Assert.assertTrue(PrimaryExpression_26_Var
		.isParentheses());
		//26
		final LogicalOrExpression LogicalOrExpression_27_Var
		 = (LogicalOrExpression)PrimaryExpression_26_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_27_Var
		);
		//27
		final PrimaryExpression PrimaryExpression_28_Var
		 = (PrimaryExpression)LogicalOrExpression_27_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_28_Var
		);
		//28
		final Constant2 Constant2_29_Var
		 = (Constant2)PrimaryExpression_28_Var
		.getConst();
		Assert.assertNotNull(Constant2_29_Var
		);
		Assert.assertEquals("0", Constant2_29_Var
		.getDec());
		//29
		final PrimaryExpression PrimaryExpression_30_Var
		 = (PrimaryExpression)LogicalOrExpression_27_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_30_Var
		);
		Assert.assertFalse(PrimaryExpression_30_Var
		.isExt());
		//30
		final CompoundStatement CompoundStatement_31_Var
		 = (CompoundStatement)PrimaryExpression_30_Var
		.getCompoundStmt();
		Assert.assertNotNull(CompoundStatement_31_Var
		);
		//31
		final BodyStatement BodyStatement_32_Var
		 = (BodyStatement)CompoundStatement_31_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_32_Var
		);
		final EList<? extends EObject> BlockList_32_list = BodyStatement_32_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_32_list);
		Assert.assertEquals(1, BlockList_32_list.size());
		//32
		final BlockList BlockList_33_Var
		 = (BlockList)BlockList_32_list.get(0);
		Assert.assertNotNull(BlockList_33_Var
		);
		final EList<? extends EObject> Statement_33_list = BlockList_33_Var
		.getStatement();
		Assert.assertNotNull(Statement_33_list);
		Assert.assertEquals(1, Statement_33_list.size());
		//33
		final Statement Statement_34_Var
		 = (Statement)Statement_33_list.get(0);
		Assert.assertNotNull(Statement_34_Var
		);
		//34
		final ExpressionStatement ExpressionStatement_35_Var
		 = (ExpressionStatement)Statement_34_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_35_Var
		);
		//35
		final PrimaryExpression PrimaryExpression_36_Var
		 = (PrimaryExpression)ExpressionStatement_35_Var
		.getExpression();
		Assert.assertNotNull(PrimaryExpression_36_Var
		);
		//36
		final Constant2 Constant2_37_Var
		 = (Constant2)PrimaryExpression_36_Var
		.getConst();
		Assert.assertNotNull(Constant2_37_Var
		);
		Assert.assertEquals("5", Constant2_37_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_25_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0064_BlocksInExpressions.c");
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
				method.invoke(this.generator, "Test0064_BlocksInExpressions.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0064_BlocksInExpressions.c");
		final String expected = this.getTextFromFile(
			"res/Test0064_BlocksInExpressions.c"
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


