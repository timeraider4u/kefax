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
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.ParameterTypeList;
import at.jku.weiner.c.parser.parser.ParameterList;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.SelectionStatement;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.SelectionStatement;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.CompoundStatement;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.CompoundStatement;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0021_IfElse {
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
			"res/Test0021_IfElse.c");
			final String[] expected = new String[] {
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_IF",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_GREATER",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_IGNORED",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_ELSE",
				"RULE_WHITESPACE",
				"RULE_KW_IF",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_EQUAL",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_IGNORED",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_ELSE",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTBRACE",
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
			"res/Test0021_IfElse.c");
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
		Assert.assertEquals("doSomething", DirectDeclarator_6_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_6_list = DirectDeclarator_6_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_6_list);
		Assert.assertEquals(1, DeclaratorSuffix_6_list.size());
		//6
		final DeclaratorSuffix DeclaratorSuffix_7_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_6_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_7_Var
		);
		//7
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_8_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_7_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_8_Var
		);
		final EList<? extends EObject> ParameterTypeList_8_list = DirectDeclaratorLastSuffix_8_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_8_list);
		Assert.assertEquals(1, ParameterTypeList_8_list.size());
		//8
		final ParameterTypeList ParameterTypeList_9_Var
		 = (ParameterTypeList)ParameterTypeList_8_list.get(0);
		Assert.assertNotNull(ParameterTypeList_9_Var
		);
		//9
		final ParameterList ParameterList_10_Var
		 = (ParameterList)ParameterTypeList_9_Var
		.getList();
		Assert.assertNotNull(ParameterList_10_Var
		);
		final EList<? extends EObject> ParameterDeclaration_10_list = ParameterList_10_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_10_list);
		Assert.assertEquals(1, ParameterDeclaration_10_list.size());
		//10
		final ParameterDeclaration ParameterDeclaration_11_Var
		 = (ParameterDeclaration)ParameterDeclaration_10_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_11_Var
		);
		//11
		final DeclarationSpecifiers DeclarationSpecifiers_12_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_11_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_12_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_12_list = DeclarationSpecifiers_12_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_12_list);
		Assert.assertEquals(1, DeclarationSpecifier_12_list.size());
		//12
		final TypeSpecifier TypeSpecifier_13_Var
		 = (TypeSpecifier)DeclarationSpecifier_12_list.get(0);
		Assert.assertNotNull(TypeSpecifier_13_Var
		);
		Assert.assertEquals("int", TypeSpecifier_13_Var
		.getName());
		//13
		final Declarator Declarator_14_Var
		 = (Declarator)ParameterDeclaration_11_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_14_Var
		);
		//14
		final DirectDeclarator DirectDeclarator_15_Var
		 = (DirectDeclarator)Declarator_14_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_15_Var
		);
		Assert.assertEquals("argc", DirectDeclarator_15_Var
		.getId());
		//15
		final FunctionDefinition FunctionDefinition_16_Var
		 = (FunctionDefinition)ExternalDeclaration_1_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_16_Var
		);
		//16
		final BodyStatement BodyStatement_17_Var
		 = (BodyStatement)FunctionDefinition_16_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_17_Var
		);
		final EList<? extends EObject> BlockList_17_list = BodyStatement_17_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_17_list);
		Assert.assertEquals(1, BlockList_17_list.size());
		//17
		final BlockList BlockList_18_Var
		 = (BlockList)BlockList_17_list.get(0);
		Assert.assertNotNull(BlockList_18_Var
		);
		final EList<? extends EObject> Statement_18_list = BlockList_18_Var
		.getStatement();
		Assert.assertNotNull(Statement_18_list);
		Assert.assertEquals(1, Statement_18_list.size());
		//18
		final Statement Statement_19_Var
		 = (Statement)Statement_18_list.get(0);
		Assert.assertNotNull(Statement_19_Var
		);
		//19
		final SelectionStatement SelectionStatement_20_Var
		 = (SelectionStatement)Statement_19_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_20_Var
		);
		Assert.assertEquals("if", SelectionStatement_20_Var
		.getIf());
		//20
		final RelationalExpression RelationalExpression_21_Var
		 = (RelationalExpression)SelectionStatement_20_Var
		.getExpr();
		Assert.assertNotNull(RelationalExpression_21_Var
		);
		Assert.assertEquals(">", RelationalExpression_21_Var
		.getOp());
		//21
		final PrimaryExpression PrimaryExpression_22_Var
		 = (PrimaryExpression)RelationalExpression_21_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_22_Var
		);
		Assert.assertEquals("argc", PrimaryExpression_22_Var
		.getId());
		//22
		final PrimaryExpression PrimaryExpression_23_Var
		 = (PrimaryExpression)RelationalExpression_21_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_23_Var
		);
		//23
		final Constant2 Constant2_24_Var
		 = (Constant2)PrimaryExpression_23_Var
		.getConst();
		Assert.assertNotNull(Constant2_24_Var
		);
		Assert.assertEquals("0", Constant2_24_Var
		.getDec());
		//24
		final Statement Statement_25_Var
		 = (Statement)SelectionStatement_20_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_25_Var
		);
		//25
		final JumpStatement JumpStatement_26_Var
		 = (JumpStatement)Statement_25_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_26_Var
		);
		//26
		final PrimaryExpression PrimaryExpression_27_Var
		 = (PrimaryExpression)JumpStatement_26_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_27_Var
		);
		//27
		final Constant2 Constant2_28_Var
		 = (Constant2)PrimaryExpression_27_Var
		.getConst();
		Assert.assertNotNull(Constant2_28_Var
		);
		Assert.assertEquals("0", Constant2_28_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_26_Var
		.getReturn());
		//28
		final Statement Statement_29_Var
		 = (Statement)SelectionStatement_20_Var
		.getElseStatement();
		Assert.assertNotNull(Statement_29_Var
		);
		//29
		final SelectionStatement SelectionStatement_30_Var
		 = (SelectionStatement)Statement_29_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_30_Var
		);
		Assert.assertEquals("if", SelectionStatement_30_Var
		.getIf());
		//30
		final EqualityExpression EqualityExpression_31_Var
		 = (EqualityExpression)SelectionStatement_30_Var
		.getExpr();
		Assert.assertNotNull(EqualityExpression_31_Var
		);
		Assert.assertEquals("==", EqualityExpression_31_Var
		.getOp());
		//31
		final PrimaryExpression PrimaryExpression_32_Var
		 = (PrimaryExpression)EqualityExpression_31_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_32_Var
		);
		Assert.assertEquals("argc", PrimaryExpression_32_Var
		.getId());
		//32
		final PrimaryExpression PrimaryExpression_33_Var
		 = (PrimaryExpression)EqualityExpression_31_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_33_Var
		);
		//33
		final Constant2 Constant2_34_Var
		 = (Constant2)PrimaryExpression_33_Var
		.getConst();
		Assert.assertNotNull(Constant2_34_Var
		);
		Assert.assertEquals("1", Constant2_34_Var
		.getDec());
		Assert.assertEquals("else", SelectionStatement_30_Var
		.getElse());
		//34
		final Statement Statement_35_Var
		 = (Statement)SelectionStatement_30_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_35_Var
		);
		//35
		final CompoundStatement CompoundStatement_36_Var
		 = (CompoundStatement)Statement_35_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_36_Var
		);
		//36
		final BodyStatement BodyStatement_37_Var
		 = (BodyStatement)CompoundStatement_36_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_37_Var
		);
		final EList<? extends EObject> BlockList_37_list = BodyStatement_37_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_37_list);
		Assert.assertEquals(1, BlockList_37_list.size());
		//37
		final BlockList BlockList_38_Var
		 = (BlockList)BlockList_37_list.get(0);
		Assert.assertNotNull(BlockList_38_Var
		);
		final EList<? extends EObject> Statement_38_list = BlockList_38_Var
		.getStatement();
		Assert.assertNotNull(Statement_38_list);
		Assert.assertEquals(1, Statement_38_list.size());
		//38
		final Statement Statement_39_Var
		 = (Statement)Statement_38_list.get(0);
		Assert.assertNotNull(Statement_39_Var
		);
		//39
		final JumpStatement JumpStatement_40_Var
		 = (JumpStatement)Statement_39_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_40_Var
		);
		//40
		final PrimaryExpression PrimaryExpression_41_Var
		 = (PrimaryExpression)JumpStatement_40_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_41_Var
		);
		//41
		final Constant2 Constant2_42_Var
		 = (Constant2)PrimaryExpression_41_Var
		.getConst();
		Assert.assertNotNull(Constant2_42_Var
		);
		Assert.assertEquals("1", Constant2_42_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_40_Var
		.getReturn());
		//42
		final Statement Statement_43_Var
		 = (Statement)SelectionStatement_30_Var
		.getElseStatement();
		Assert.assertNotNull(Statement_43_Var
		);
		//43
		final CompoundStatement CompoundStatement_44_Var
		 = (CompoundStatement)Statement_43_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_44_Var
		);
		//44
		final BodyStatement BodyStatement_45_Var
		 = (BodyStatement)CompoundStatement_44_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_45_Var
		);
		final EList<? extends EObject> BlockList_45_list = BodyStatement_45_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_45_list);
		Assert.assertEquals(1, BlockList_45_list.size());
		//45
		final BlockList BlockList_46_Var
		 = (BlockList)BlockList_45_list.get(0);
		Assert.assertNotNull(BlockList_46_Var
		);
		final EList<? extends EObject> Statement_46_list = BlockList_46_Var
		.getStatement();
		Assert.assertNotNull(Statement_46_list);
		Assert.assertEquals(1, Statement_46_list.size());
		//46
		final Statement Statement_47_Var
		 = (Statement)Statement_46_list.get(0);
		Assert.assertNotNull(Statement_47_Var
		);
		//47
		final JumpStatement JumpStatement_48_Var
		 = (JumpStatement)Statement_47_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_48_Var
		);
		//48
		final PrimaryExpression PrimaryExpression_49_Var
		 = (PrimaryExpression)JumpStatement_48_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_49_Var
		);
		//49
		final Constant2 Constant2_50_Var
		 = (Constant2)PrimaryExpression_49_Var
		.getConst();
		Assert.assertNotNull(Constant2_50_Var
		);
		Assert.assertEquals("2", Constant2_50_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_48_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0021_IfElse.c");
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
				method.invoke(this.generator, "Test0021_IfElse.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0021_IfElse.c");
		final String expected = this.getTextFromFile(
			"res/Test0021_IfElse.c"
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


