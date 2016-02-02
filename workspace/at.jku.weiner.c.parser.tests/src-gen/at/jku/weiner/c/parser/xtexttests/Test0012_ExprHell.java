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
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0012_ExprHell {
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
			"res/Test0012_ExprHell.c");
			//System.out.println(text);
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
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_STAR",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_LEFTSHIFT",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_LESS",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_EQUAL",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_AND",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_OR",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_CARET",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_ANDAND",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_OROR",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_QUESTION",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COLON",
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
			"res/Test0012_ExprHell.c");
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
		final EList<? extends EObject> Statement_9_list = BlockList_9_Var
		.getStatement();
		Assert.assertNotNull(Statement_9_list);
		Assert.assertEquals(12, Statement_9_list.size());
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
		final PrimaryExpression PrimaryExpression_12_Var
		 = (PrimaryExpression)ExpressionStatement_11_Var
		.getExpression();
		Assert.assertNotNull(PrimaryExpression_12_Var
		);
		//12
		final Constant2 Constant2_13_Var
		 = (Constant2)PrimaryExpression_12_Var
		.getConst();
		Assert.assertNotNull(Constant2_13_Var
		);
		Assert.assertEquals("1", Constant2_13_Var
		.getDec());
		//13
		final Statement Statement_14_Var
		 = (Statement)Statement_9_list.get(1);
		Assert.assertNotNull(Statement_14_Var
		);
		//14
		final ExpressionStatement ExpressionStatement_15_Var
		 = (ExpressionStatement)Statement_14_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_15_Var
		);
		//15
		final PrimaryExpression PrimaryExpression_16_Var
		 = (PrimaryExpression)ExpressionStatement_15_Var
		.getExpression();
		Assert.assertNotNull(PrimaryExpression_16_Var
		);
		Assert.assertTrue(PrimaryExpression_16_Var
		.isParentheses());
		//16
		final PrimaryExpression PrimaryExpression_17_Var
		 = (PrimaryExpression)PrimaryExpression_16_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_17_Var
		);
		//17
		final Constant2 Constant2_18_Var
		 = (Constant2)PrimaryExpression_17_Var
		.getConst();
		Assert.assertNotNull(Constant2_18_Var
		);
		Assert.assertEquals("2", Constant2_18_Var
		.getDec());
		//18
		final Statement Statement_19_Var
		 = (Statement)Statement_9_list.get(2);
		Assert.assertNotNull(Statement_19_Var
		);
		//19
		final ExpressionStatement ExpressionStatement_20_Var
		 = (ExpressionStatement)Statement_19_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_20_Var
		);
		//20
		final MultiplicativeExpression MultiplicativeExpression_21_Var
		 = (MultiplicativeExpression)ExpressionStatement_20_Var
		.getExpression();
		Assert.assertNotNull(MultiplicativeExpression_21_Var
		);
		//21
		final PrimaryExpression PrimaryExpression_22_Var
		 = (PrimaryExpression)MultiplicativeExpression_21_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_22_Var
		);
		//22
		final Constant2 Constant2_23_Var
		 = (Constant2)PrimaryExpression_22_Var
		.getConst();
		Assert.assertNotNull(Constant2_23_Var
		);
		Assert.assertEquals("1", Constant2_23_Var
		.getDec());
		//23
		final PrimaryExpression PrimaryExpression_24_Var
		 = (PrimaryExpression)MultiplicativeExpression_21_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_24_Var
		);
		//24
		final Constant2 Constant2_25_Var
		 = (Constant2)PrimaryExpression_24_Var
		.getConst();
		Assert.assertNotNull(Constant2_25_Var
		);
		Assert.assertEquals("2", Constant2_25_Var
		.getDec());
		Assert.assertEquals("*", MultiplicativeExpression_21_Var
		.getOp());
		//25
		final Statement Statement_26_Var
		 = (Statement)Statement_9_list.get(3);
		Assert.assertNotNull(Statement_26_Var
		);
		//26
		final ExpressionStatement ExpressionStatement_27_Var
		 = (ExpressionStatement)Statement_26_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_27_Var
		);
		//27
		final ShiftExpression ShiftExpression_28_Var
		 = (ShiftExpression)ExpressionStatement_27_Var
		.getExpression();
		Assert.assertNotNull(ShiftExpression_28_Var
		);
		//28
		final PrimaryExpression PrimaryExpression_29_Var
		 = (PrimaryExpression)ShiftExpression_28_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_29_Var
		);
		//29
		final Constant2 Constant2_30_Var
		 = (Constant2)PrimaryExpression_29_Var
		.getConst();
		Assert.assertNotNull(Constant2_30_Var
		);
		Assert.assertEquals("1", Constant2_30_Var
		.getDec());
		//30
		final PrimaryExpression PrimaryExpression_31_Var
		 = (PrimaryExpression)ShiftExpression_28_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_31_Var
		);
		//31
		final Constant2 Constant2_32_Var
		 = (Constant2)PrimaryExpression_31_Var
		.getConst();
		Assert.assertNotNull(Constant2_32_Var
		);
		Assert.assertEquals("2", Constant2_32_Var
		.getDec());
		Assert.assertEquals("<<", ShiftExpression_28_Var
		.getOp());
		//32
		final Statement Statement_33_Var
		 = (Statement)Statement_9_list.get(4);
		Assert.assertNotNull(Statement_33_Var
		);
		//33
		final ExpressionStatement ExpressionStatement_34_Var
		 = (ExpressionStatement)Statement_33_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_34_Var
		);
		//34
		final RelationalExpression RelationalExpression_35_Var
		 = (RelationalExpression)ExpressionStatement_34_Var
		.getExpression();
		Assert.assertNotNull(RelationalExpression_35_Var
		);
		//35
		final PrimaryExpression PrimaryExpression_36_Var
		 = (PrimaryExpression)RelationalExpression_35_Var
		.getLeft();
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
		final PrimaryExpression PrimaryExpression_38_Var
		 = (PrimaryExpression)RelationalExpression_35_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_38_Var
		);
		//38
		final Constant2 Constant2_39_Var
		 = (Constant2)PrimaryExpression_38_Var
		.getConst();
		Assert.assertNotNull(Constant2_39_Var
		);
		Assert.assertEquals("2", Constant2_39_Var
		.getDec());
		Assert.assertEquals("<", RelationalExpression_35_Var
		.getOp());
		//39
		final Statement Statement_40_Var
		 = (Statement)Statement_9_list.get(5);
		Assert.assertNotNull(Statement_40_Var
		);
		//40
		final ExpressionStatement ExpressionStatement_41_Var
		 = (ExpressionStatement)Statement_40_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_41_Var
		);
		//41
		final EqualityExpression EqualityExpression_42_Var
		 = (EqualityExpression)ExpressionStatement_41_Var
		.getExpression();
		Assert.assertNotNull(EqualityExpression_42_Var
		);
		//42
		final PrimaryExpression PrimaryExpression_43_Var
		 = (PrimaryExpression)EqualityExpression_42_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_43_Var
		);
		//43
		final Constant2 Constant2_44_Var
		 = (Constant2)PrimaryExpression_43_Var
		.getConst();
		Assert.assertNotNull(Constant2_44_Var
		);
		Assert.assertEquals("1", Constant2_44_Var
		.getDec());
		//44
		final PrimaryExpression PrimaryExpression_45_Var
		 = (PrimaryExpression)EqualityExpression_42_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_45_Var
		);
		//45
		final Constant2 Constant2_46_Var
		 = (Constant2)PrimaryExpression_45_Var
		.getConst();
		Assert.assertNotNull(Constant2_46_Var
		);
		Assert.assertEquals("2", Constant2_46_Var
		.getDec());
		Assert.assertEquals("==", EqualityExpression_42_Var
		.getOp());
		//46
		final Statement Statement_47_Var
		 = (Statement)Statement_9_list.get(6);
		Assert.assertNotNull(Statement_47_Var
		);
		//47
		final ExpressionStatement ExpressionStatement_48_Var
		 = (ExpressionStatement)Statement_47_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_48_Var
		);
		//48
		final AndExpression AndExpression_49_Var
		 = (AndExpression)ExpressionStatement_48_Var
		.getExpression();
		Assert.assertNotNull(AndExpression_49_Var
		);
		//49
		final PrimaryExpression PrimaryExpression_50_Var
		 = (PrimaryExpression)AndExpression_49_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_50_Var
		);
		//50
		final Constant2 Constant2_51_Var
		 = (Constant2)PrimaryExpression_50_Var
		.getConst();
		Assert.assertNotNull(Constant2_51_Var
		);
		Assert.assertEquals("1", Constant2_51_Var
		.getDec());
		//51
		final PrimaryExpression PrimaryExpression_52_Var
		 = (PrimaryExpression)AndExpression_49_Var
		.getRight();
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
		 = (Statement)Statement_9_list.get(7);
		Assert.assertNotNull(Statement_54_Var
		);
		//54
		final ExpressionStatement ExpressionStatement_55_Var
		 = (ExpressionStatement)Statement_54_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_55_Var
		);
		//55
		final InclusiveOrExpression InclusiveOrExpression_56_Var
		 = (InclusiveOrExpression)ExpressionStatement_55_Var
		.getExpression();
		Assert.assertNotNull(InclusiveOrExpression_56_Var
		);
		//56
		final PrimaryExpression PrimaryExpression_57_Var
		 = (PrimaryExpression)InclusiveOrExpression_56_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_57_Var
		);
		//57
		final Constant2 Constant2_58_Var
		 = (Constant2)PrimaryExpression_57_Var
		.getConst();
		Assert.assertNotNull(Constant2_58_Var
		);
		Assert.assertEquals("1", Constant2_58_Var
		.getDec());
		//58
		final PrimaryExpression PrimaryExpression_59_Var
		 = (PrimaryExpression)InclusiveOrExpression_56_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_59_Var
		);
		//59
		final Constant2 Constant2_60_Var
		 = (Constant2)PrimaryExpression_59_Var
		.getConst();
		Assert.assertNotNull(Constant2_60_Var
		);
		Assert.assertEquals("2", Constant2_60_Var
		.getDec());
		//60
		final Statement Statement_61_Var
		 = (Statement)Statement_9_list.get(8);
		Assert.assertNotNull(Statement_61_Var
		);
		//61
		final ExpressionStatement ExpressionStatement_62_Var
		 = (ExpressionStatement)Statement_61_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_62_Var
		);
		//62
		final ExclusiveOrExpression ExclusiveOrExpression_63_Var
		 = (ExclusiveOrExpression)ExpressionStatement_62_Var
		.getExpression();
		Assert.assertNotNull(ExclusiveOrExpression_63_Var
		);
		//63
		final PrimaryExpression PrimaryExpression_64_Var
		 = (PrimaryExpression)ExclusiveOrExpression_63_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_64_Var
		);
		//64
		final Constant2 Constant2_65_Var
		 = (Constant2)PrimaryExpression_64_Var
		.getConst();
		Assert.assertNotNull(Constant2_65_Var
		);
		Assert.assertEquals("1", Constant2_65_Var
		.getDec());
		//65
		final PrimaryExpression PrimaryExpression_66_Var
		 = (PrimaryExpression)ExclusiveOrExpression_63_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_66_Var
		);
		//66
		final Constant2 Constant2_67_Var
		 = (Constant2)PrimaryExpression_66_Var
		.getConst();
		Assert.assertNotNull(Constant2_67_Var
		);
		Assert.assertEquals("2", Constant2_67_Var
		.getDec());
		//67
		final Statement Statement_68_Var
		 = (Statement)Statement_9_list.get(9);
		Assert.assertNotNull(Statement_68_Var
		);
		//68
		final ExpressionStatement ExpressionStatement_69_Var
		 = (ExpressionStatement)Statement_68_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_69_Var
		);
		//69
		final LogicalAndExpression LogicalAndExpression_70_Var
		 = (LogicalAndExpression)ExpressionStatement_69_Var
		.getExpression();
		Assert.assertNotNull(LogicalAndExpression_70_Var
		);
		//70
		final PrimaryExpression PrimaryExpression_71_Var
		 = (PrimaryExpression)LogicalAndExpression_70_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_71_Var
		);
		//71
		final Constant2 Constant2_72_Var
		 = (Constant2)PrimaryExpression_71_Var
		.getConst();
		Assert.assertNotNull(Constant2_72_Var
		);
		Assert.assertEquals("1", Constant2_72_Var
		.getDec());
		//72
		final PrimaryExpression PrimaryExpression_73_Var
		 = (PrimaryExpression)LogicalAndExpression_70_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_73_Var
		);
		//73
		final Constant2 Constant2_74_Var
		 = (Constant2)PrimaryExpression_73_Var
		.getConst();
		Assert.assertNotNull(Constant2_74_Var
		);
		Assert.assertEquals("2", Constant2_74_Var
		.getDec());
		//74
		final Statement Statement_75_Var
		 = (Statement)Statement_9_list.get(10);
		Assert.assertNotNull(Statement_75_Var
		);
		//75
		final ExpressionStatement ExpressionStatement_76_Var
		 = (ExpressionStatement)Statement_75_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_76_Var
		);
		//76
		final LogicalOrExpression LogicalOrExpression_77_Var
		 = (LogicalOrExpression)ExpressionStatement_76_Var
		.getExpression();
		Assert.assertNotNull(LogicalOrExpression_77_Var
		);
		//77
		final PrimaryExpression PrimaryExpression_78_Var
		 = (PrimaryExpression)LogicalOrExpression_77_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_78_Var
		);
		//78
		final Constant2 Constant2_79_Var
		 = (Constant2)PrimaryExpression_78_Var
		.getConst();
		Assert.assertNotNull(Constant2_79_Var
		);
		Assert.assertEquals("1", Constant2_79_Var
		.getDec());
		//79
		final PrimaryExpression PrimaryExpression_80_Var
		 = (PrimaryExpression)LogicalOrExpression_77_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_80_Var
		);
		//80
		final Constant2 Constant2_81_Var
		 = (Constant2)PrimaryExpression_80_Var
		.getConst();
		Assert.assertNotNull(Constant2_81_Var
		);
		Assert.assertEquals("2", Constant2_81_Var
		.getDec());
		//81
		final Statement Statement_82_Var
		 = (Statement)Statement_9_list.get(11);
		Assert.assertNotNull(Statement_82_Var
		);
		//82
		final ExpressionStatement ExpressionStatement_83_Var
		 = (ExpressionStatement)Statement_82_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_83_Var
		);
		//83
		final ConditionalExpression ConditionalExpression_84_Var
		 = (ConditionalExpression)ExpressionStatement_83_Var
		.getExpression();
		Assert.assertNotNull(ConditionalExpression_84_Var
		);
		//84
		final PrimaryExpression PrimaryExpression_85_Var
		 = (PrimaryExpression)ConditionalExpression_84_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_85_Var
		);
		//85
		final Constant2 Constant2_86_Var
		 = (Constant2)PrimaryExpression_85_Var
		.getConst();
		Assert.assertNotNull(Constant2_86_Var
		);
		Assert.assertEquals("1", Constant2_86_Var
		.getDec());
		//86
		final PrimaryExpression PrimaryExpression_87_Var
		 = (PrimaryExpression)ConditionalExpression_84_Var
		.getQExpr();
		Assert.assertNotNull(PrimaryExpression_87_Var
		);
		//87
		final Constant2 Constant2_88_Var
		 = (Constant2)PrimaryExpression_87_Var
		.getConst();
		Assert.assertNotNull(Constant2_88_Var
		);
		Assert.assertEquals("2", Constant2_88_Var
		.getDec());
		//88
		final PrimaryExpression PrimaryExpression_89_Var
		 = (PrimaryExpression)ConditionalExpression_84_Var
		.getCExpr();
		Assert.assertNotNull(PrimaryExpression_89_Var
		);
		//89
		final Constant2 Constant2_90_Var
		 = (Constant2)PrimaryExpression_89_Var
		.getConst();
		Assert.assertNotNull(Constant2_90_Var
		);
		Assert.assertEquals("3", Constant2_90_Var
		.getDec());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0012_ExprHell.c");
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
				method.invoke(this.generator, "Test0012_ExprHell.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0012_ExprHell.c");
		final String expected = this.getTextFromFile(
			"res/Test0012_ExprHell.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
		// System.out.println("Code generation finished.");
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


