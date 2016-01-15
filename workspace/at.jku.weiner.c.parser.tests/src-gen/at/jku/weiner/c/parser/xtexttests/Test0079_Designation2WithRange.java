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
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.InitializerList;
import at.jku.weiner.c.parser.parser.Init;
import at.jku.weiner.c.parser.parser.Designation;
import at.jku.weiner.c.parser.parser.DesignatorList;
import at.jku.weiner.c.parser.parser.Designator;
import at.jku.weiner.c.parser.parser.ConstantExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Init;
import at.jku.weiner.c.parser.parser.Designation;
import at.jku.weiner.c.parser.parser.DesignatorList;
import at.jku.weiner.c.parser.parser.Designator;
import at.jku.weiner.c.parser.parser.ConstantExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.ConstantExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Init;
import at.jku.weiner.c.parser.parser.Designation;
import at.jku.weiner.c.parser.parser.DesignatorList;
import at.jku.weiner.c.parser.parser.Designator;
import at.jku.weiner.c.parser.parser.ConstantExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0079_Designation2WithRange {
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
			"res/Test0079_Designation2WithRange.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTBRACKET",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACKET",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACKET",
				"RULE_DECIMAL_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_DOT",
				"RULE_SKW_DOT",
				"RULE_SKW_DOT",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACKET",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0079_Designation2WithRange.c");
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
		final Declaration Declaration_2_Var
		 = (Declaration)ExternalDeclaration_1_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_2_Var
		);
		//2
		final DeclarationSpecifiers DeclarationSpecifiers_3_Var
		 = (DeclarationSpecifiers)Declaration_2_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_3_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_3_list = DeclarationSpecifiers_3_Var
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
		final EList<? extends EObject> InitDeclaratorList_4_list = Declaration_2_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_4_list);
		Assert.assertEquals(1, InitDeclaratorList_4_list.size());
		//4
		final InitDeclaratorList InitDeclaratorList_5_Var
		 = (InitDeclaratorList)InitDeclaratorList_4_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_5_Var
		);
		final EList<? extends EObject> InitDeclarator_5_list = InitDeclaratorList_5_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_5_list);
		Assert.assertEquals(1, InitDeclarator_5_list.size());
		//5
		final InitDeclarator InitDeclarator_6_Var
		 = (InitDeclarator)InitDeclarator_5_list.get(0);
		Assert.assertNotNull(InitDeclarator_6_Var
		);
		//6
		final Declarator Declarator_7_Var
		 = (Declarator)InitDeclarator_6_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_7_Var
		);
		//7
		final DirectDeclarator DirectDeclarator_8_Var
		 = (DirectDeclarator)Declarator_7_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_8_Var
		);
		Assert.assertEquals("foo", DirectDeclarator_8_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_8_list = DirectDeclarator_8_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_8_list);
		Assert.assertEquals(1, DeclaratorSuffix_8_list.size());
		//8
		final DeclaratorSuffix DeclaratorSuffix_9_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_8_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_9_Var
		);
		Assert.assertNull(DeclaratorSuffix_9_Var
		.getExpr());
		//9
		final Initializer Initializer_10_Var
		 = (Initializer)InitDeclarator_6_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_10_Var
		);
		//10
		final InitializerList InitializerList_11_Var
		 = (InitializerList)Initializer_10_Var
		.getList();
		Assert.assertNotNull(InitializerList_11_Var
		);
		final EList<? extends EObject> Init_11_list = InitializerList_11_Var
		.getInit();
		Assert.assertNotNull(Init_11_list);
		Assert.assertEquals(3, Init_11_list.size());
		//11
		final Init Init_12_Var
		 = (Init)Init_11_list.get(0);
		Assert.assertNotNull(Init_12_Var
		);
		//12
		final Designation Designation_13_Var
		 = (Designation)Init_12_Var
		.getDesignation();
		Assert.assertNotNull(Designation_13_Var
		);
		//13
		final DesignatorList DesignatorList_14_Var
		 = (DesignatorList)Designation_13_Var
		.getList();
		Assert.assertNotNull(DesignatorList_14_Var
		);
		final EList<? extends EObject> Designator_14_list = DesignatorList_14_Var
		.getDesignator();
		Assert.assertNotNull(Designator_14_list);
		Assert.assertEquals(1, Designator_14_list.size());
		//14
		final Designator Designator_15_Var
		 = (Designator)Designator_14_list.get(0);
		Assert.assertNotNull(Designator_15_Var
		);
		//15
		final ConstantExpression ConstantExpression_16_Var
		 = (ConstantExpression)Designator_15_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_16_Var
		);
		//16
		final ConditionalExpression ConditionalExpression_17_Var
		 = (ConditionalExpression)ConstantExpression_16_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_17_Var
		);
		//17
		final LogicalOrExpression LogicalOrExpression_18_Var
		 = (LogicalOrExpression)ConditionalExpression_17_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = LogicalOrExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final LogicalAndExpression LogicalAndExpression_19_Var
		 = (LogicalAndExpression)Expr_18_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = LogicalAndExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final InclusiveOrExpression InclusiveOrExpression_20_Var
		 = (InclusiveOrExpression)Expr_19_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = InclusiveOrExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final ExclusiveOrExpression ExclusiveOrExpression_21_Var
		 = (ExclusiveOrExpression)Expr_20_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = ExclusiveOrExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final AndExpression AndExpression_22_Var
		 = (AndExpression)Expr_21_list.get(0);
		Assert.assertNotNull(AndExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = AndExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final EqualityExpression EqualityExpression_23_Var
		 = (EqualityExpression)Expr_22_list.get(0);
		Assert.assertNotNull(EqualityExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = EqualityExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final RelationalExpression RelationalExpression_24_Var
		 = (RelationalExpression)Expr_23_list.get(0);
		Assert.assertNotNull(RelationalExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = RelationalExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final ShiftExpression ShiftExpression_25_Var
		 = (ShiftExpression)Expr_24_list.get(0);
		Assert.assertNotNull(ShiftExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = ShiftExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final AdditiveExpression AdditiveExpression_26_Var
		 = (AdditiveExpression)Expr_25_list.get(0);
		Assert.assertNotNull(AdditiveExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = AdditiveExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final MultiplicativeExpression MultiplicativeExpression_27_Var
		 = (MultiplicativeExpression)Expr_26_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = MultiplicativeExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final CastExpression CastExpression_28_Var
		 = (CastExpression)Expr_27_list.get(0);
		Assert.assertNotNull(CastExpression_28_Var
		);
		//28
		final UnaryExpression UnaryExpression_29_Var
		 = (UnaryExpression)CastExpression_28_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_29_Var
		);
		//29
		final PostfixExpression PostfixExpression_30_Var
		 = (PostfixExpression)UnaryExpression_29_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = PostfixExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final PrimaryExpression PrimaryExpression_31_Var
		 = (PrimaryExpression)Expr_30_list.get(0);
		Assert.assertNotNull(PrimaryExpression_31_Var
		);
		//31
		final Constant2 Constant2_32_Var
		 = (Constant2)PrimaryExpression_31_Var
		.getConst();
		Assert.assertNotNull(Constant2_32_Var
		);
		Assert.assertEquals("0", Constant2_32_Var
		.getDec());
		//32
		final Initializer Initializer_33_Var
		 = (Initializer)Init_12_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_33_Var
		);
		//33
		final AssignmentExpression AssignmentExpression_34_Var
		 = (AssignmentExpression)Initializer_33_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_34_Var
		);
		//34
		final ConditionalExpression ConditionalExpression_35_Var
		 = (ConditionalExpression)AssignmentExpression_34_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_35_Var
		);
		//35
		final LogicalOrExpression LogicalOrExpression_36_Var
		 = (LogicalOrExpression)ConditionalExpression_35_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = LogicalOrExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final LogicalAndExpression LogicalAndExpression_37_Var
		 = (LogicalAndExpression)Expr_36_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = LogicalAndExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final InclusiveOrExpression InclusiveOrExpression_38_Var
		 = (InclusiveOrExpression)Expr_37_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = InclusiveOrExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final ExclusiveOrExpression ExclusiveOrExpression_39_Var
		 = (ExclusiveOrExpression)Expr_38_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = ExclusiveOrExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final AndExpression AndExpression_40_Var
		 = (AndExpression)Expr_39_list.get(0);
		Assert.assertNotNull(AndExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = AndExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final EqualityExpression EqualityExpression_41_Var
		 = (EqualityExpression)Expr_40_list.get(0);
		Assert.assertNotNull(EqualityExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = EqualityExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final RelationalExpression RelationalExpression_42_Var
		 = (RelationalExpression)Expr_41_list.get(0);
		Assert.assertNotNull(RelationalExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = RelationalExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final ShiftExpression ShiftExpression_43_Var
		 = (ShiftExpression)Expr_42_list.get(0);
		Assert.assertNotNull(ShiftExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = ShiftExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final AdditiveExpression AdditiveExpression_44_Var
		 = (AdditiveExpression)Expr_43_list.get(0);
		Assert.assertNotNull(AdditiveExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = AdditiveExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final MultiplicativeExpression MultiplicativeExpression_45_Var
		 = (MultiplicativeExpression)Expr_44_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = MultiplicativeExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final CastExpression CastExpression_46_Var
		 = (CastExpression)Expr_45_list.get(0);
		Assert.assertNotNull(CastExpression_46_Var
		);
		//46
		final UnaryExpression UnaryExpression_47_Var
		 = (UnaryExpression)CastExpression_46_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_47_Var
		);
		//47
		final PostfixExpression PostfixExpression_48_Var
		 = (PostfixExpression)UnaryExpression_47_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = PostfixExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final PrimaryExpression PrimaryExpression_49_Var
		 = (PrimaryExpression)Expr_48_list.get(0);
		Assert.assertNotNull(PrimaryExpression_49_Var
		);
		//49
		final Constant2 Constant2_50_Var
		 = (Constant2)PrimaryExpression_49_Var
		.getConst();
		Assert.assertNotNull(Constant2_50_Var
		);
		Assert.assertEquals("0", Constant2_50_Var
		.getDec());
		//50
		final Init Init_51_Var
		 = (Init)Init_11_list.get(1);
		Assert.assertNotNull(Init_51_Var
		);
		//51
		final Designation Designation_52_Var
		 = (Designation)Init_51_Var
		.getDesignation();
		Assert.assertNotNull(Designation_52_Var
		);
		//52
		final DesignatorList DesignatorList_53_Var
		 = (DesignatorList)Designation_52_Var
		.getList();
		Assert.assertNotNull(DesignatorList_53_Var
		);
		final EList<? extends EObject> Designator_53_list = DesignatorList_53_Var
		.getDesignator();
		Assert.assertNotNull(Designator_53_list);
		Assert.assertEquals(1, Designator_53_list.size());
		//53
		final Designator Designator_54_Var
		 = (Designator)Designator_53_list.get(0);
		Assert.assertNotNull(Designator_54_Var
		);
		//54
		final ConstantExpression ConstantExpression_55_Var
		 = (ConstantExpression)Designator_54_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_55_Var
		);
		//55
		final ConditionalExpression ConditionalExpression_56_Var
		 = (ConditionalExpression)ConstantExpression_55_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_56_Var
		);
		//56
		final LogicalOrExpression LogicalOrExpression_57_Var
		 = (LogicalOrExpression)ConditionalExpression_56_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = LogicalOrExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final LogicalAndExpression LogicalAndExpression_58_Var
		 = (LogicalAndExpression)Expr_57_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = LogicalAndExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final InclusiveOrExpression InclusiveOrExpression_59_Var
		 = (InclusiveOrExpression)Expr_58_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = InclusiveOrExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final ExclusiveOrExpression ExclusiveOrExpression_60_Var
		 = (ExclusiveOrExpression)Expr_59_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = ExclusiveOrExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final AndExpression AndExpression_61_Var
		 = (AndExpression)Expr_60_list.get(0);
		Assert.assertNotNull(AndExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = AndExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final EqualityExpression EqualityExpression_62_Var
		 = (EqualityExpression)Expr_61_list.get(0);
		Assert.assertNotNull(EqualityExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = EqualityExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final RelationalExpression RelationalExpression_63_Var
		 = (RelationalExpression)Expr_62_list.get(0);
		Assert.assertNotNull(RelationalExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = RelationalExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final ShiftExpression ShiftExpression_64_Var
		 = (ShiftExpression)Expr_63_list.get(0);
		Assert.assertNotNull(ShiftExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = ShiftExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final AdditiveExpression AdditiveExpression_65_Var
		 = (AdditiveExpression)Expr_64_list.get(0);
		Assert.assertNotNull(AdditiveExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = AdditiveExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final MultiplicativeExpression MultiplicativeExpression_66_Var
		 = (MultiplicativeExpression)Expr_65_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = MultiplicativeExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final CastExpression CastExpression_67_Var
		 = (CastExpression)Expr_66_list.get(0);
		Assert.assertNotNull(CastExpression_67_Var
		);
		//67
		final UnaryExpression UnaryExpression_68_Var
		 = (UnaryExpression)CastExpression_67_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_68_Var
		);
		//68
		final PostfixExpression PostfixExpression_69_Var
		 = (PostfixExpression)UnaryExpression_68_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = PostfixExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final PrimaryExpression PrimaryExpression_70_Var
		 = (PrimaryExpression)Expr_69_list.get(0);
		Assert.assertNotNull(PrimaryExpression_70_Var
		);
		//70
		final Constant2 Constant2_71_Var
		 = (Constant2)PrimaryExpression_70_Var
		.getConst();
		Assert.assertNotNull(Constant2_71_Var
		);
		Assert.assertEquals("1", Constant2_71_Var
		.getDec());
		//71
		final ConstantExpression ConstantExpression_72_Var
		 = (ConstantExpression)Designator_54_Var
		.getTo();
		Assert.assertNotNull(ConstantExpression_72_Var
		);
		//72
		final ConditionalExpression ConditionalExpression_73_Var
		 = (ConditionalExpression)ConstantExpression_72_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_73_Var
		);
		//73
		final LogicalOrExpression LogicalOrExpression_74_Var
		 = (LogicalOrExpression)ConditionalExpression_73_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = LogicalOrExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final LogicalAndExpression LogicalAndExpression_75_Var
		 = (LogicalAndExpression)Expr_74_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = LogicalAndExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final InclusiveOrExpression InclusiveOrExpression_76_Var
		 = (InclusiveOrExpression)Expr_75_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = InclusiveOrExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final ExclusiveOrExpression ExclusiveOrExpression_77_Var
		 = (ExclusiveOrExpression)Expr_76_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = ExclusiveOrExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final AndExpression AndExpression_78_Var
		 = (AndExpression)Expr_77_list.get(0);
		Assert.assertNotNull(AndExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = AndExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final EqualityExpression EqualityExpression_79_Var
		 = (EqualityExpression)Expr_78_list.get(0);
		Assert.assertNotNull(EqualityExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = EqualityExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final RelationalExpression RelationalExpression_80_Var
		 = (RelationalExpression)Expr_79_list.get(0);
		Assert.assertNotNull(RelationalExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = RelationalExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final ShiftExpression ShiftExpression_81_Var
		 = (ShiftExpression)Expr_80_list.get(0);
		Assert.assertNotNull(ShiftExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = ShiftExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final AdditiveExpression AdditiveExpression_82_Var
		 = (AdditiveExpression)Expr_81_list.get(0);
		Assert.assertNotNull(AdditiveExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = AdditiveExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final MultiplicativeExpression MultiplicativeExpression_83_Var
		 = (MultiplicativeExpression)Expr_82_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = MultiplicativeExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final CastExpression CastExpression_84_Var
		 = (CastExpression)Expr_83_list.get(0);
		Assert.assertNotNull(CastExpression_84_Var
		);
		//84
		final UnaryExpression UnaryExpression_85_Var
		 = (UnaryExpression)CastExpression_84_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_85_Var
		);
		//85
		final PostfixExpression PostfixExpression_86_Var
		 = (PostfixExpression)UnaryExpression_85_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = PostfixExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final PrimaryExpression PrimaryExpression_87_Var
		 = (PrimaryExpression)Expr_86_list.get(0);
		Assert.assertNotNull(PrimaryExpression_87_Var
		);
		//87
		final Constant2 Constant2_88_Var
		 = (Constant2)PrimaryExpression_87_Var
		.getConst();
		Assert.assertNotNull(Constant2_88_Var
		);
		Assert.assertEquals("9", Constant2_88_Var
		.getDec());
		//88
		final Initializer Initializer_89_Var
		 = (Initializer)Init_51_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_89_Var
		);
		//89
		final AssignmentExpression AssignmentExpression_90_Var
		 = (AssignmentExpression)Initializer_89_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_90_Var
		);
		//90
		final ConditionalExpression ConditionalExpression_91_Var
		 = (ConditionalExpression)AssignmentExpression_90_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_91_Var
		);
		//91
		final LogicalOrExpression LogicalOrExpression_92_Var
		 = (LogicalOrExpression)ConditionalExpression_91_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = LogicalOrExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final LogicalAndExpression LogicalAndExpression_93_Var
		 = (LogicalAndExpression)Expr_92_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = LogicalAndExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final InclusiveOrExpression InclusiveOrExpression_94_Var
		 = (InclusiveOrExpression)Expr_93_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = InclusiveOrExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final ExclusiveOrExpression ExclusiveOrExpression_95_Var
		 = (ExclusiveOrExpression)Expr_94_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = ExclusiveOrExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final AndExpression AndExpression_96_Var
		 = (AndExpression)Expr_95_list.get(0);
		Assert.assertNotNull(AndExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = AndExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final EqualityExpression EqualityExpression_97_Var
		 = (EqualityExpression)Expr_96_list.get(0);
		Assert.assertNotNull(EqualityExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = EqualityExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final RelationalExpression RelationalExpression_98_Var
		 = (RelationalExpression)Expr_97_list.get(0);
		Assert.assertNotNull(RelationalExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = RelationalExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final ShiftExpression ShiftExpression_99_Var
		 = (ShiftExpression)Expr_98_list.get(0);
		Assert.assertNotNull(ShiftExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = ShiftExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final AdditiveExpression AdditiveExpression_100_Var
		 = (AdditiveExpression)Expr_99_list.get(0);
		Assert.assertNotNull(AdditiveExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = AdditiveExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final MultiplicativeExpression MultiplicativeExpression_101_Var
		 = (MultiplicativeExpression)Expr_100_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = MultiplicativeExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final CastExpression CastExpression_102_Var
		 = (CastExpression)Expr_101_list.get(0);
		Assert.assertNotNull(CastExpression_102_Var
		);
		//102
		final UnaryExpression UnaryExpression_103_Var
		 = (UnaryExpression)CastExpression_102_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_103_Var
		);
		//103
		final PostfixExpression PostfixExpression_104_Var
		 = (PostfixExpression)UnaryExpression_103_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = PostfixExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final PrimaryExpression PrimaryExpression_105_Var
		 = (PrimaryExpression)Expr_104_list.get(0);
		Assert.assertNotNull(PrimaryExpression_105_Var
		);
		//105
		final Constant2 Constant2_106_Var
		 = (Constant2)PrimaryExpression_105_Var
		.getConst();
		Assert.assertNotNull(Constant2_106_Var
		);
		Assert.assertEquals("1", Constant2_106_Var
		.getDec());
		//106
		final Init Init_107_Var
		 = (Init)Init_11_list.get(2);
		Assert.assertNotNull(Init_107_Var
		);
		//107
		final Designation Designation_108_Var
		 = (Designation)Init_107_Var
		.getDesignation();
		Assert.assertNotNull(Designation_108_Var
		);
		//108
		final DesignatorList DesignatorList_109_Var
		 = (DesignatorList)Designation_108_Var
		.getList();
		Assert.assertNotNull(DesignatorList_109_Var
		);
		final EList<? extends EObject> Designator_109_list = DesignatorList_109_Var
		.getDesignator();
		Assert.assertNotNull(Designator_109_list);
		Assert.assertEquals(1, Designator_109_list.size());
		//109
		final Designator Designator_110_Var
		 = (Designator)Designator_109_list.get(0);
		Assert.assertNotNull(Designator_110_Var
		);
		//110
		final ConstantExpression ConstantExpression_111_Var
		 = (ConstantExpression)Designator_110_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_111_Var
		);
		//111
		final ConditionalExpression ConditionalExpression_112_Var
		 = (ConditionalExpression)ConstantExpression_111_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_112_Var
		);
		//112
		final LogicalOrExpression LogicalOrExpression_113_Var
		 = (LogicalOrExpression)ConditionalExpression_112_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = LogicalOrExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final LogicalAndExpression LogicalAndExpression_114_Var
		 = (LogicalAndExpression)Expr_113_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = LogicalAndExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final InclusiveOrExpression InclusiveOrExpression_115_Var
		 = (InclusiveOrExpression)Expr_114_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = InclusiveOrExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final ExclusiveOrExpression ExclusiveOrExpression_116_Var
		 = (ExclusiveOrExpression)Expr_115_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = ExclusiveOrExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final AndExpression AndExpression_117_Var
		 = (AndExpression)Expr_116_list.get(0);
		Assert.assertNotNull(AndExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = AndExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final EqualityExpression EqualityExpression_118_Var
		 = (EqualityExpression)Expr_117_list.get(0);
		Assert.assertNotNull(EqualityExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = EqualityExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final RelationalExpression RelationalExpression_119_Var
		 = (RelationalExpression)Expr_118_list.get(0);
		Assert.assertNotNull(RelationalExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = RelationalExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final ShiftExpression ShiftExpression_120_Var
		 = (ShiftExpression)Expr_119_list.get(0);
		Assert.assertNotNull(ShiftExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = ShiftExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final AdditiveExpression AdditiveExpression_121_Var
		 = (AdditiveExpression)Expr_120_list.get(0);
		Assert.assertNotNull(AdditiveExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = AdditiveExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final MultiplicativeExpression MultiplicativeExpression_122_Var
		 = (MultiplicativeExpression)Expr_121_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = MultiplicativeExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final CastExpression CastExpression_123_Var
		 = (CastExpression)Expr_122_list.get(0);
		Assert.assertNotNull(CastExpression_123_Var
		);
		//123
		final UnaryExpression UnaryExpression_124_Var
		 = (UnaryExpression)CastExpression_123_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_124_Var
		);
		//124
		final PostfixExpression PostfixExpression_125_Var
		 = (PostfixExpression)UnaryExpression_124_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = PostfixExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final PrimaryExpression PrimaryExpression_126_Var
		 = (PrimaryExpression)Expr_125_list.get(0);
		Assert.assertNotNull(PrimaryExpression_126_Var
		);
		//126
		final Constant2 Constant2_127_Var
		 = (Constant2)PrimaryExpression_126_Var
		.getConst();
		Assert.assertNotNull(Constant2_127_Var
		);
		Assert.assertEquals("10", Constant2_127_Var
		.getDec());
		//127
		final Initializer Initializer_128_Var
		 = (Initializer)Init_107_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_128_Var
		);
		//128
		final AssignmentExpression AssignmentExpression_129_Var
		 = (AssignmentExpression)Initializer_128_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_129_Var
		);
		//129
		final ConditionalExpression ConditionalExpression_130_Var
		 = (ConditionalExpression)AssignmentExpression_129_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_130_Var
		);
		//130
		final LogicalOrExpression LogicalOrExpression_131_Var
		 = (LogicalOrExpression)ConditionalExpression_130_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = LogicalOrExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final LogicalAndExpression LogicalAndExpression_132_Var
		 = (LogicalAndExpression)Expr_131_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = LogicalAndExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final InclusiveOrExpression InclusiveOrExpression_133_Var
		 = (InclusiveOrExpression)Expr_132_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = InclusiveOrExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final ExclusiveOrExpression ExclusiveOrExpression_134_Var
		 = (ExclusiveOrExpression)Expr_133_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = ExclusiveOrExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final AndExpression AndExpression_135_Var
		 = (AndExpression)Expr_134_list.get(0);
		Assert.assertNotNull(AndExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = AndExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final EqualityExpression EqualityExpression_136_Var
		 = (EqualityExpression)Expr_135_list.get(0);
		Assert.assertNotNull(EqualityExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = EqualityExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final RelationalExpression RelationalExpression_137_Var
		 = (RelationalExpression)Expr_136_list.get(0);
		Assert.assertNotNull(RelationalExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = RelationalExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final ShiftExpression ShiftExpression_138_Var
		 = (ShiftExpression)Expr_137_list.get(0);
		Assert.assertNotNull(ShiftExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = ShiftExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final AdditiveExpression AdditiveExpression_139_Var
		 = (AdditiveExpression)Expr_138_list.get(0);
		Assert.assertNotNull(AdditiveExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = AdditiveExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final MultiplicativeExpression MultiplicativeExpression_140_Var
		 = (MultiplicativeExpression)Expr_139_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = MultiplicativeExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final CastExpression CastExpression_141_Var
		 = (CastExpression)Expr_140_list.get(0);
		Assert.assertNotNull(CastExpression_141_Var
		);
		//141
		final UnaryExpression UnaryExpression_142_Var
		 = (UnaryExpression)CastExpression_141_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_142_Var
		);
		//142
		final PostfixExpression PostfixExpression_143_Var
		 = (PostfixExpression)UnaryExpression_142_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = PostfixExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final PrimaryExpression PrimaryExpression_144_Var
		 = (PrimaryExpression)Expr_143_list.get(0);
		Assert.assertNotNull(PrimaryExpression_144_Var
		);
		//144
		final Constant2 Constant2_145_Var
		 = (Constant2)PrimaryExpression_144_Var
		.getConst();
		Assert.assertNotNull(Constant2_145_Var
		);
		Assert.assertEquals("2", Constant2_145_Var
		.getDec());
		Assert.assertTrue(Initializer_10_Var
		.isLastComma());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0079_Designation2WithRange.c");
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
				method.invoke(this.generator, "Test0079_Designation2WithRange.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0079_Designation2WithRange.c");
		final String expected = this.getTextFromFile(
			"res/Test0079_Designation2WithRange.c"
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


