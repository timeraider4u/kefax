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
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.CompoundStatement;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.LabeledStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.LabeledStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.CompoundStatement;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.LabeledStatement;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.CompoundStatement;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0025_Switch {
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
			"res/Test0025_Switch.c");
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
				"RULE_KW_SWITCH",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_CASE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COLON",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_CASE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_BREAK",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_DEFAULT",
				"RULE_SKW_COLON",
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
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
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
			"res/Test0025_Switch.c");
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
		.getIdent());
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
		.getIdent());
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
		Assert.assertEquals(2, Statement_18_list.size());
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
		Assert.assertEquals("switch", SelectionStatement_20_Var
		.getSwitch());
		//20
		final PrimaryExpression PrimaryExpression_21_Var
		 = (PrimaryExpression)SelectionStatement_20_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_21_Var
		);
		Assert.assertEquals("argc", PrimaryExpression_21_Var
		.getIdent());
		//21
		final Statement Statement_22_Var
		 = (Statement)SelectionStatement_20_Var
		.getSwitchStatement();
		Assert.assertNotNull(Statement_22_Var
		);
		//22
		final CompoundStatement CompoundStatement_23_Var
		 = (CompoundStatement)Statement_22_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_23_Var
		);
		//23
		final BodyStatement BodyStatement_24_Var
		 = (BodyStatement)CompoundStatement_23_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_24_Var
		);
		final EList<? extends EObject> BlockList_24_list = BodyStatement_24_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_24_list);
		Assert.assertEquals(1, BlockList_24_list.size());
		//24
		final BlockList BlockList_25_Var
		 = (BlockList)BlockList_24_list.get(0);
		Assert.assertNotNull(BlockList_25_Var
		);
		final EList<? extends EObject> Statement_25_list = BlockList_25_Var
		.getStatement();
		Assert.assertNotNull(Statement_25_list);
		Assert.assertEquals(3, Statement_25_list.size());
		//25
		final Statement Statement_26_Var
		 = (Statement)Statement_25_list.get(0);
		Assert.assertNotNull(Statement_26_Var
		);
		//26
		final LabeledStatement LabeledStatement_27_Var
		 = (LabeledStatement)Statement_26_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_27_Var
		);
		Assert.assertEquals("case", LabeledStatement_27_Var
		.getCase());
		//27
		final PrimaryExpression PrimaryExpression_28_Var
		 = (PrimaryExpression)LabeledStatement_27_Var
		.getExpr();
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
		final Statement Statement_30_Var
		 = (Statement)LabeledStatement_27_Var
		.getLStmt();
		Assert.assertNotNull(Statement_30_Var
		);
		//30
		final JumpStatement JumpStatement_31_Var
		 = (JumpStatement)Statement_30_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_31_Var
		);
		Assert.assertEquals("return", JumpStatement_31_Var
		.getReturn());
		//31
		final PrimaryExpression PrimaryExpression_32_Var
		 = (PrimaryExpression)JumpStatement_31_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_32_Var
		);
		//32
		final Constant2 Constant2_33_Var
		 = (Constant2)PrimaryExpression_32_Var
		.getConst();
		Assert.assertNotNull(Constant2_33_Var
		);
		Assert.assertEquals("0", Constant2_33_Var
		.getDec());
		//33
		final Statement Statement_34_Var
		 = (Statement)Statement_25_list.get(1);
		Assert.assertNotNull(Statement_34_Var
		);
		//34
		final LabeledStatement LabeledStatement_35_Var
		 = (LabeledStatement)Statement_34_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_35_Var
		);
		Assert.assertEquals("case", LabeledStatement_35_Var
		.getCase());
		//35
		final PrimaryExpression PrimaryExpression_36_Var
		 = (PrimaryExpression)LabeledStatement_35_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_36_Var
		);
		//36
		final Constant2 Constant2_37_Var
		 = (Constant2)PrimaryExpression_36_Var
		.getConst();
		Assert.assertNotNull(Constant2_37_Var
		);
		Assert.assertEquals("1", Constant2_37_Var
		.getDec());
		//37
		final Statement Statement_38_Var
		 = (Statement)LabeledStatement_35_Var
		.getLStmt();
		Assert.assertNotNull(Statement_38_Var
		);
		//38
		final CompoundStatement CompoundStatement_39_Var
		 = (CompoundStatement)Statement_38_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_39_Var
		);
		//39
		final BodyStatement BodyStatement_40_Var
		 = (BodyStatement)CompoundStatement_39_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_40_Var
		);
		final EList<? extends EObject> BlockList_40_list = BodyStatement_40_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_40_list);
		Assert.assertEquals(1, BlockList_40_list.size());
		//40
		final BlockList BlockList_41_Var
		 = (BlockList)BlockList_40_list.get(0);
		Assert.assertNotNull(BlockList_41_Var
		);
		final EList<? extends EObject> Statement_41_list = BlockList_41_Var
		.getStatement();
		Assert.assertNotNull(Statement_41_list);
		Assert.assertEquals(1, Statement_41_list.size());
		//41
		final Statement Statement_42_Var
		 = (Statement)Statement_41_list.get(0);
		Assert.assertNotNull(Statement_42_Var
		);
		//42
		final JumpStatement JumpStatement_43_Var
		 = (JumpStatement)Statement_42_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_43_Var
		);
		Assert.assertEquals("break", JumpStatement_43_Var
		.getBreak());
		//43
		final Statement Statement_44_Var
		 = (Statement)Statement_25_list.get(2);
		Assert.assertNotNull(Statement_44_Var
		);
		//44
		final LabeledStatement LabeledStatement_45_Var
		 = (LabeledStatement)Statement_44_Var
		.getStmt();
		Assert.assertNotNull(LabeledStatement_45_Var
		);
		Assert.assertTrue(LabeledStatement_45_Var
		.isMydefault());
		//45
		final Statement Statement_46_Var
		 = (Statement)LabeledStatement_45_Var
		.getLStmt();
		Assert.assertNotNull(Statement_46_Var
		);
		//46
		final CompoundStatement CompoundStatement_47_Var
		 = (CompoundStatement)Statement_46_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_47_Var
		);
		//47
		final BodyStatement BodyStatement_48_Var
		 = (BodyStatement)CompoundStatement_47_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_48_Var
		);
		final EList<? extends EObject> BlockList_48_list = BodyStatement_48_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_48_list);
		Assert.assertEquals(1, BlockList_48_list.size());
		//48
		final BlockList BlockList_49_Var
		 = (BlockList)BlockList_48_list.get(0);
		Assert.assertNotNull(BlockList_49_Var
		);
		final EList<? extends EObject> Statement_49_list = BlockList_49_Var
		.getStatement();
		Assert.assertNotNull(Statement_49_list);
		Assert.assertEquals(1, Statement_49_list.size());
		//49
		final Statement Statement_50_Var
		 = (Statement)Statement_49_list.get(0);
		Assert.assertNotNull(Statement_50_Var
		);
		//50
		final JumpStatement JumpStatement_51_Var
		 = (JumpStatement)Statement_50_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_51_Var
		);
		Assert.assertEquals("return", JumpStatement_51_Var
		.getReturn());
		//51
		final PrimaryExpression PrimaryExpression_52_Var
		 = (PrimaryExpression)JumpStatement_51_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_52_Var
		);
		//52
		final Constant2 Constant2_53_Var
		 = (Constant2)PrimaryExpression_52_Var
		.getConst();
		Assert.assertNotNull(Constant2_53_Var
		);
		Assert.assertEquals("2", Constant2_53_Var
		.getDec());
		//53
		final Statement Statement_54_Var
		 = (Statement)Statement_18_list.get(1);
		Assert.assertNotNull(Statement_54_Var
		);
		//54
		final JumpStatement JumpStatement_55_Var
		 = (JumpStatement)Statement_54_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_55_Var
		);
		//55
		final PrimaryExpression PrimaryExpression_56_Var
		 = (PrimaryExpression)JumpStatement_55_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_56_Var
		);
		//56
		final Constant2 Constant2_57_Var
		 = (Constant2)PrimaryExpression_56_Var
		.getConst();
		Assert.assertNotNull(Constant2_57_Var
		);
		Assert.assertEquals("1", Constant2_57_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_55_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0025_Switch.c");
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
				method.invoke(this.generator, "Test0025_Switch.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0025_Switch.c");
		final String expected = this.getTextFromFile(
			"res/Test0025_Switch.c"
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


