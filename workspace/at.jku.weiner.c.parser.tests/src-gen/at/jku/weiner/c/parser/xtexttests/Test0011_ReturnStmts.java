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
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.parser.parser.JumpStatement;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0011_ReturnStmts {
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
			"res/Test0011_ReturnStmts.c");
			final String[] expected = new String[] {
				"RULE_KW_CHAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_CHAR_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_SKW_MINUS",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_DOUBLE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_FLOAT_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_FLOAT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_HEX_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
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
			"res/Test0011_ReturnStmts.c");
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
		Assert.assertEquals(5, External_0_list.size());
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
		Assert.assertEquals("char", TypeSpecifier_4_Var
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
		Assert.assertEquals("doSomething1", DirectDeclarator_6_Var
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
		Assert.assertEquals(1, Statement_9_list.size());
		//9
		final Statement Statement_10_Var
		 = (Statement)Statement_9_list.get(0);
		Assert.assertNotNull(Statement_10_Var
		);
		//10
		final JumpStatement JumpStatement_11_Var
		 = (JumpStatement)Statement_10_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_11_Var
		);
		//11
		final PrimaryExpression PrimaryExpression_12_Var
		 = (PrimaryExpression)JumpStatement_11_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_12_Var
		);
		//12
		final Constant2 Constant2_13_Var
		 = (Constant2)PrimaryExpression_12_Var
		.getConst();
		Assert.assertNotNull(Constant2_13_Var
		);
		Assert.assertEquals("'a'", Constant2_13_Var
		.getCh());
		Assert.assertEquals("return", JumpStatement_11_Var
		.getReturn());
		//13
		final ExternalDeclaration ExternalDeclaration_14_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_14_Var
		);
		//14
		final FunctionDefHead FunctionDefHead_15_Var
		 = (FunctionDefHead)ExternalDeclaration_14_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_15_Var
		);
		//15
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_16_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_15_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_16_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_16_list = FunctionDeclarationSpecifiers_16_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_16_list);
		Assert.assertEquals(1, DeclarationSpecifier_16_list.size());
		//16
		final TypeSpecifier TypeSpecifier_17_Var
		 = (TypeSpecifier)DeclarationSpecifier_16_list.get(0);
		Assert.assertNotNull(TypeSpecifier_17_Var
		);
		Assert.assertEquals("int", TypeSpecifier_17_Var
		.getName());
		//17
		final Declarator Declarator_18_Var
		 = (Declarator)FunctionDefHead_15_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_18_Var
		);
		//18
		final DirectDeclarator DirectDeclarator_19_Var
		 = (DirectDeclarator)Declarator_18_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_19_Var
		);
		Assert.assertEquals("doSomething2", DirectDeclarator_19_Var
		.getIdent());
		//19
		final FunctionDefinition FunctionDefinition_20_Var
		 = (FunctionDefinition)ExternalDeclaration_14_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_20_Var
		);
		//20
		final BodyStatement BodyStatement_21_Var
		 = (BodyStatement)FunctionDefinition_20_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_21_Var
		);
		final EList<? extends EObject> BlockList_21_list = BodyStatement_21_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_21_list);
		Assert.assertEquals(1, BlockList_21_list.size());
		//21
		final BlockList BlockList_22_Var
		 = (BlockList)BlockList_21_list.get(0);
		Assert.assertNotNull(BlockList_22_Var
		);
		final EList<? extends EObject> Statement_22_list = BlockList_22_Var
		.getStatement();
		Assert.assertNotNull(Statement_22_list);
		Assert.assertEquals(1, Statement_22_list.size());
		//22
		final Statement Statement_23_Var
		 = (Statement)Statement_22_list.get(0);
		Assert.assertNotNull(Statement_23_Var
		);
		//23
		final JumpStatement JumpStatement_24_Var
		 = (JumpStatement)Statement_23_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_24_Var
		);
		//24
		final UnaryExpression UnaryExpression_25_Var
		 = (UnaryExpression)JumpStatement_24_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_25_Var
		);
		//25
		final PrimaryExpression PrimaryExpression_26_Var
		 = (PrimaryExpression)UnaryExpression_25_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_26_Var
		);
		//26
		final Constant2 Constant2_27_Var
		 = (Constant2)PrimaryExpression_26_Var
		.getConst();
		Assert.assertNotNull(Constant2_27_Var
		);
		Assert.assertEquals("1", Constant2_27_Var
		.getDec());
		Assert.assertEquals("-", UnaryExpression_25_Var
		.getOp());
		Assert.assertEquals("return", JumpStatement_24_Var
		.getReturn());
		//27
		final ExternalDeclaration ExternalDeclaration_28_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_28_Var
		);
		//28
		final FunctionDefHead FunctionDefHead_29_Var
		 = (FunctionDefHead)ExternalDeclaration_28_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_29_Var
		);
		//29
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_30_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_29_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_30_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_30_list = FunctionDeclarationSpecifiers_30_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_30_list);
		Assert.assertEquals(1, DeclarationSpecifier_30_list.size());
		//30
		final TypeSpecifier TypeSpecifier_31_Var
		 = (TypeSpecifier)DeclarationSpecifier_30_list.get(0);
		Assert.assertNotNull(TypeSpecifier_31_Var
		);
		Assert.assertEquals("double", TypeSpecifier_31_Var
		.getName());
		//31
		final Declarator Declarator_32_Var
		 = (Declarator)FunctionDefHead_29_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_32_Var
		);
		//32
		final DirectDeclarator DirectDeclarator_33_Var
		 = (DirectDeclarator)Declarator_32_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_33_Var
		);
		Assert.assertEquals("doSomething3", DirectDeclarator_33_Var
		.getIdent());
		//33
		final FunctionDefinition FunctionDefinition_34_Var
		 = (FunctionDefinition)ExternalDeclaration_28_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_34_Var
		);
		//34
		final BodyStatement BodyStatement_35_Var
		 = (BodyStatement)FunctionDefinition_34_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_35_Var
		);
		final EList<? extends EObject> BlockList_35_list = BodyStatement_35_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_35_list);
		Assert.assertEquals(1, BlockList_35_list.size());
		//35
		final BlockList BlockList_36_Var
		 = (BlockList)BlockList_35_list.get(0);
		Assert.assertNotNull(BlockList_36_Var
		);
		final EList<? extends EObject> Statement_36_list = BlockList_36_Var
		.getStatement();
		Assert.assertNotNull(Statement_36_list);
		Assert.assertEquals(1, Statement_36_list.size());
		//36
		final Statement Statement_37_Var
		 = (Statement)Statement_36_list.get(0);
		Assert.assertNotNull(Statement_37_Var
		);
		//37
		final JumpStatement JumpStatement_38_Var
		 = (JumpStatement)Statement_37_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_38_Var
		);
		//38
		final PrimaryExpression PrimaryExpression_39_Var
		 = (PrimaryExpression)JumpStatement_38_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_39_Var
		);
		//39
		final Constant2 Constant2_40_Var
		 = (Constant2)PrimaryExpression_39_Var
		.getConst();
		Assert.assertNotNull(Constant2_40_Var
		);
		Assert.assertEquals("0.8", Constant2_40_Var
		.getFloat());
		Assert.assertEquals("return", JumpStatement_38_Var
		.getReturn());
		//40
		final ExternalDeclaration ExternalDeclaration_41_Var
		 = (ExternalDeclaration)External_0_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_41_Var
		);
		//41
		final FunctionDefHead FunctionDefHead_42_Var
		 = (FunctionDefHead)ExternalDeclaration_41_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_42_Var
		);
		//42
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_43_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_42_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_43_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_43_list = FunctionDeclarationSpecifiers_43_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_43_list);
		Assert.assertEquals(1, DeclarationSpecifier_43_list.size());
		//43
		final TypeSpecifier TypeSpecifier_44_Var
		 = (TypeSpecifier)DeclarationSpecifier_43_list.get(0);
		Assert.assertNotNull(TypeSpecifier_44_Var
		);
		Assert.assertEquals("float", TypeSpecifier_44_Var
		.getName());
		//44
		final Declarator Declarator_45_Var
		 = (Declarator)FunctionDefHead_42_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_45_Var
		);
		//45
		final DirectDeclarator DirectDeclarator_46_Var
		 = (DirectDeclarator)Declarator_45_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_46_Var
		);
		Assert.assertEquals("doSomething4", DirectDeclarator_46_Var
		.getIdent());
		//46
		final FunctionDefinition FunctionDefinition_47_Var
		 = (FunctionDefinition)ExternalDeclaration_41_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_47_Var
		);
		//47
		final BodyStatement BodyStatement_48_Var
		 = (BodyStatement)FunctionDefinition_47_Var
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
		Assert.assertEquals("0x01A", Constant2_53_Var
		.getHex());
		Assert.assertEquals("return", JumpStatement_51_Var
		.getReturn());
		//53
		final ExternalDeclaration ExternalDeclaration_54_Var
		 = (ExternalDeclaration)External_0_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_54_Var
		);
		//54
		final FunctionDefHead FunctionDefHead_55_Var
		 = (FunctionDefHead)ExternalDeclaration_54_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_55_Var
		);
		//55
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_56_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_55_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_56_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_56_list = FunctionDeclarationSpecifiers_56_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_56_list);
		Assert.assertEquals(1, DeclarationSpecifier_56_list.size());
		//56
		final TypeSpecifier TypeSpecifier_57_Var
		 = (TypeSpecifier)DeclarationSpecifier_56_list.get(0);
		Assert.assertNotNull(TypeSpecifier_57_Var
		);
		Assert.assertEquals("void", TypeSpecifier_57_Var
		.getName());
		//57
		final Declarator Declarator_58_Var
		 = (Declarator)FunctionDefHead_55_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_58_Var
		);
		//58
		final DirectDeclarator DirectDeclarator_59_Var
		 = (DirectDeclarator)Declarator_58_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_59_Var
		);
		Assert.assertEquals("doSomething5", DirectDeclarator_59_Var
		.getIdent());
		//59
		final FunctionDefinition FunctionDefinition_60_Var
		 = (FunctionDefinition)ExternalDeclaration_54_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_60_Var
		);
		//60
		final BodyStatement BodyStatement_61_Var
		 = (BodyStatement)FunctionDefinition_60_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_61_Var
		);
		final EList<? extends EObject> BlockList_61_list = BodyStatement_61_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_61_list);
		Assert.assertEquals(1, BlockList_61_list.size());
		//61
		final BlockList BlockList_62_Var
		 = (BlockList)BlockList_61_list.get(0);
		Assert.assertNotNull(BlockList_62_Var
		);
		final EList<? extends EObject> Statement_62_list = BlockList_62_Var
		.getStatement();
		Assert.assertNotNull(Statement_62_list);
		Assert.assertEquals(1, Statement_62_list.size());
		//62
		final Statement Statement_63_Var
		 = (Statement)Statement_62_list.get(0);
		Assert.assertNotNull(Statement_63_Var
		);
		//63
		final JumpStatement JumpStatement_64_Var
		 = (JumpStatement)Statement_63_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_64_Var
		);
		Assert.assertEquals("return", JumpStatement_64_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0011_ReturnStmts.c");
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
				method.invoke(this.generator, "Test0011_ReturnStmts.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0011_ReturnStmts.c");
		final String expected = this.getTextFromFile(
			"res/Test0011_ReturnStmts.c"
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


