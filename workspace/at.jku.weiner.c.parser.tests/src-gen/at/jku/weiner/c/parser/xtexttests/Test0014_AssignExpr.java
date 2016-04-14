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
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0014_AssignExpr {
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
			"res/Test0014_AssignExpr.c");
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
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
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
			"res/Test0014_AssignExpr.c");
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
		final EList<? extends EObject> Declaration_9_list = BlockList_9_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_9_list);
		Assert.assertEquals(2, Declaration_9_list.size());
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
		final TypeSpecifier TypeSpecifier_12_Var
		 = (TypeSpecifier)DeclarationSpecifier_11_list.get(0);
		Assert.assertNotNull(TypeSpecifier_12_Var
		);
		Assert.assertEquals("int", TypeSpecifier_12_Var
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
		Assert.assertEquals("a", DirectDeclarator_16_Var
		.getIdent());
		//16
		final Initializer Initializer_17_Var
		 = (Initializer)InitDeclarator_14_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_17_Var
		);
		//17
		final PrimaryExpression PrimaryExpression_18_Var
		 = (PrimaryExpression)Initializer_17_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_18_Var
		);
		//18
		final Constant2 Constant2_19_Var
		 = (Constant2)PrimaryExpression_18_Var
		.getConst();
		Assert.assertNotNull(Constant2_19_Var
		);
		Assert.assertEquals("0", Constant2_19_Var
		.getDec());
		//19
		final Declaration Declaration_20_Var
		 = (Declaration)Declaration_9_list.get(1);
		Assert.assertNotNull(Declaration_20_Var
		);
		//20
		final DeclarationSpecifiers DeclarationSpecifiers_21_Var
		 = (DeclarationSpecifiers)Declaration_20_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_21_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_21_list = DeclarationSpecifiers_21_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_21_list);
		Assert.assertEquals(1, DeclarationSpecifier_21_list.size());
		//21
		final TypeSpecifier TypeSpecifier_22_Var
		 = (TypeSpecifier)DeclarationSpecifier_21_list.get(0);
		Assert.assertNotNull(TypeSpecifier_22_Var
		);
		Assert.assertEquals("int", TypeSpecifier_22_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_22_list = Declaration_20_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_22_list);
		Assert.assertEquals(1, InitDeclaratorList_22_list.size());
		//22
		final InitDeclaratorList InitDeclaratorList_23_Var
		 = (InitDeclaratorList)InitDeclaratorList_22_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_23_Var
		);
		final EList<? extends EObject> InitDeclarator_23_list = InitDeclaratorList_23_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_23_list);
		Assert.assertEquals(1, InitDeclarator_23_list.size());
		//23
		final InitDeclarator InitDeclarator_24_Var
		 = (InitDeclarator)InitDeclarator_23_list.get(0);
		Assert.assertNotNull(InitDeclarator_24_Var
		);
		//24
		final Declarator Declarator_25_Var
		 = (Declarator)InitDeclarator_24_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_25_Var
		);
		//25
		final DirectDeclarator DirectDeclarator_26_Var
		 = (DirectDeclarator)Declarator_25_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_26_Var
		);
		Assert.assertEquals("b", DirectDeclarator_26_Var
		.getIdent());
		//26
		final Initializer Initializer_27_Var
		 = (Initializer)InitDeclarator_24_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_27_Var
		);
		//27
		final PrimaryExpression PrimaryExpression_28_Var
		 = (PrimaryExpression)Initializer_27_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_28_Var
		);
		//28
		final Constant2 Constant2_29_Var
		 = (Constant2)PrimaryExpression_28_Var
		.getConst();
		Assert.assertNotNull(Constant2_29_Var
		);
		Assert.assertEquals("2", Constant2_29_Var
		.getDec());
		final EList<? extends EObject> Statement_29_list = BlockList_9_Var
		.getStatement();
		Assert.assertNotNull(Statement_29_list);
		Assert.assertEquals(1, Statement_29_list.size());
		//29
		final Statement Statement_30_Var
		 = (Statement)Statement_29_list.get(0);
		Assert.assertNotNull(Statement_30_Var
		);
		//30
		final ExpressionStatement ExpressionStatement_31_Var
		 = (ExpressionStatement)Statement_30_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_31_Var
		);
		//31
		final Expression Expression_32_Var
		 = (Expression)ExpressionStatement_31_Var
		.getExpression();
		Assert.assertNotNull(Expression_32_Var
		);
		//32
		final AssignmentExpression AssignmentExpression_33_Var
		 = (AssignmentExpression)Expression_32_Var
		.getLeft();
		Assert.assertNotNull(AssignmentExpression_33_Var
		);
		//33
		final PrimaryExpression PrimaryExpression_34_Var
		 = (PrimaryExpression)AssignmentExpression_33_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_34_Var
		);
		Assert.assertEquals("a", PrimaryExpression_34_Var
		.getIdent());
		Assert.assertEquals("=", AssignmentExpression_33_Var
		.getOp());
		//34
		final PrimaryExpression PrimaryExpression_35_Var
		 = (PrimaryExpression)AssignmentExpression_33_Var
		.getAssignmentExpr();
		Assert.assertNotNull(PrimaryExpression_35_Var
		);
		//35
		final Constant2 Constant2_36_Var
		 = (Constant2)PrimaryExpression_35_Var
		.getConst();
		Assert.assertNotNull(Constant2_36_Var
		);
		Assert.assertEquals("12", Constant2_36_Var
		.getDec());
		//36
		final AssignmentExpression AssignmentExpression_37_Var
		 = (AssignmentExpression)Expression_32_Var
		.getRight();
		Assert.assertNotNull(AssignmentExpression_37_Var
		);
		//37
		final PrimaryExpression PrimaryExpression_38_Var
		 = (PrimaryExpression)AssignmentExpression_37_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_38_Var
		);
		Assert.assertEquals("b", PrimaryExpression_38_Var
		.getIdent());
		Assert.assertEquals("=", AssignmentExpression_37_Var
		.getOp());
		//38
		final PrimaryExpression PrimaryExpression_39_Var
		 = (PrimaryExpression)AssignmentExpression_37_Var
		.getAssignmentExpr();
		Assert.assertNotNull(PrimaryExpression_39_Var
		);
		//39
		final Constant2 Constant2_40_Var
		 = (Constant2)PrimaryExpression_39_Var
		.getConst();
		Assert.assertNotNull(Constant2_40_Var
		);
		Assert.assertEquals("21", Constant2_40_Var
		.getDec());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0014_AssignExpr.c");
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
				method.invoke(this.generator, "Test0014_AssignExpr.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0014_AssignExpr.c");
		final String expected = this.getTextFromFile(
			"res/Test0014_AssignExpr.c"
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


