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
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.StructDeclarationList;
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
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
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
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
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
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
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
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
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0081_Bitfields {
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
			"res/Test0081_Bitfields.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_STRUCT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_SKW_COLON",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_SEMI",
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
			"res/Test0081_Bitfields.c");
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
		//4
		final StructOrUnionSpecifier StructOrUnionSpecifier_5_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_4_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_5_Var
		);
		//5
		final StructOrUnion StructOrUnion_6_Var
		 = (StructOrUnion)StructOrUnionSpecifier_5_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_6_Var
		);
		Assert.assertEquals("struct", StructOrUnion_6_Var
		.getName());
		Assert.assertEquals("foo", StructOrUnionSpecifier_5_Var
		.getId());
		//6
		final StructDeclarationList StructDeclarationList_7_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_5_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_7_Var
		);
		final EList<? extends EObject> StructDeclaration_7_list = StructDeclarationList_7_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_7_list);
		Assert.assertEquals(4, StructDeclaration_7_list.size());
		//7
		final StructDeclaration StructDeclaration_8_Var
		 = (StructDeclaration)StructDeclaration_7_list.get(0);
		Assert.assertNotNull(StructDeclaration_8_Var
		);
		//8
		final SpecifierQualifierList SpecifierQualifierList_9_Var
		 = (SpecifierQualifierList)StructDeclaration_8_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_9_Var
		);
		final EList<? extends EObject> TypeSpecifier_9_list = SpecifierQualifierList_9_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_9_list);
		Assert.assertEquals(1, TypeSpecifier_9_list.size());
		//9
		final TypeSpecifier TypeSpecifier_10_Var
		 = (TypeSpecifier)TypeSpecifier_9_list.get(0);
		Assert.assertNotNull(TypeSpecifier_10_Var
		);
		Assert.assertEquals("int", TypeSpecifier_10_Var
		.getName());
		//10
		final StructDeclaratorList StructDeclaratorList_11_Var
		 = (StructDeclaratorList)StructDeclaration_8_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_11_Var
		);
		final EList<? extends EObject> StructDeclarator_11_list = StructDeclaratorList_11_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_11_list);
		Assert.assertEquals(1, StructDeclarator_11_list.size());
		//11
		final StructDeclarator StructDeclarator_12_Var
		 = (StructDeclarator)StructDeclarator_11_list.get(0);
		Assert.assertNotNull(StructDeclarator_12_Var
		);
		//12
		final Declarator Declarator_13_Var
		 = (Declarator)StructDeclarator_12_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_13_Var
		);
		//13
		final DirectDeclarator DirectDeclarator_14_Var
		 = (DirectDeclarator)Declarator_13_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_14_Var
		);
		Assert.assertEquals("i", DirectDeclarator_14_Var
		.getId());
		final EList<? extends EObject> ConstExpr_14_list = StructDeclarator_12_Var
		.getConstExpr();
		Assert.assertNotNull(ConstExpr_14_list);
		Assert.assertEquals(1, ConstExpr_14_list.size());
		//14
		final ConstantExpression ConstantExpression_15_Var
		 = (ConstantExpression)ConstExpr_14_list.get(0);
		Assert.assertNotNull(ConstantExpression_15_Var
		);
		//15
		final ConditionalExpression ConditionalExpression_16_Var
		 = (ConditionalExpression)ConstantExpression_15_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_16_Var
		);
		//16
		final LogicalOrExpression LogicalOrExpression_17_Var
		 = (LogicalOrExpression)ConditionalExpression_16_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = LogicalOrExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final LogicalAndExpression LogicalAndExpression_18_Var
		 = (LogicalAndExpression)Expr_17_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = LogicalAndExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final InclusiveOrExpression InclusiveOrExpression_19_Var
		 = (InclusiveOrExpression)Expr_18_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = InclusiveOrExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final ExclusiveOrExpression ExclusiveOrExpression_20_Var
		 = (ExclusiveOrExpression)Expr_19_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = ExclusiveOrExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final AndExpression AndExpression_21_Var
		 = (AndExpression)Expr_20_list.get(0);
		Assert.assertNotNull(AndExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = AndExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final EqualityExpression EqualityExpression_22_Var
		 = (EqualityExpression)Expr_21_list.get(0);
		Assert.assertNotNull(EqualityExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = EqualityExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final RelationalExpression RelationalExpression_23_Var
		 = (RelationalExpression)Expr_22_list.get(0);
		Assert.assertNotNull(RelationalExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = RelationalExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final ShiftExpression ShiftExpression_24_Var
		 = (ShiftExpression)Expr_23_list.get(0);
		Assert.assertNotNull(ShiftExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = ShiftExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final AdditiveExpression AdditiveExpression_25_Var
		 = (AdditiveExpression)Expr_24_list.get(0);
		Assert.assertNotNull(AdditiveExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = AdditiveExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final MultiplicativeExpression MultiplicativeExpression_26_Var
		 = (MultiplicativeExpression)Expr_25_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = MultiplicativeExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final CastExpression CastExpression_27_Var
		 = (CastExpression)Expr_26_list.get(0);
		Assert.assertNotNull(CastExpression_27_Var
		);
		//27
		final UnaryExpression UnaryExpression_28_Var
		 = (UnaryExpression)CastExpression_27_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_28_Var
		);
		//28
		final PostfixExpression PostfixExpression_29_Var
		 = (PostfixExpression)UnaryExpression_28_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = PostfixExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final PrimaryExpression PrimaryExpression_30_Var
		 = (PrimaryExpression)Expr_29_list.get(0);
		Assert.assertNotNull(PrimaryExpression_30_Var
		);
		//30
		final Constant2 Constant2_31_Var
		 = (Constant2)PrimaryExpression_30_Var
		.getConst();
		Assert.assertNotNull(Constant2_31_Var
		);
		Assert.assertEquals("3", Constant2_31_Var
		.getDec());
		//31
		final StructDeclaration StructDeclaration_32_Var
		 = (StructDeclaration)StructDeclaration_7_list.get(1);
		Assert.assertNotNull(StructDeclaration_32_Var
		);
		//32
		final SpecifierQualifierList SpecifierQualifierList_33_Var
		 = (SpecifierQualifierList)StructDeclaration_32_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_33_Var
		);
		final EList<? extends EObject> TypeSpecifier_33_list = SpecifierQualifierList_33_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_33_list);
		Assert.assertEquals(1, TypeSpecifier_33_list.size());
		//33
		final TypeSpecifier TypeSpecifier_34_Var
		 = (TypeSpecifier)TypeSpecifier_33_list.get(0);
		Assert.assertNotNull(TypeSpecifier_34_Var
		);
		Assert.assertEquals("int", TypeSpecifier_34_Var
		.getName());
		//34
		final StructDeclaratorList StructDeclaratorList_35_Var
		 = (StructDeclaratorList)StructDeclaration_32_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_35_Var
		);
		final EList<? extends EObject> StructDeclarator_35_list = StructDeclaratorList_35_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_35_list);
		Assert.assertEquals(1, StructDeclarator_35_list.size());
		//35
		final StructDeclarator StructDeclarator_36_Var
		 = (StructDeclarator)StructDeclarator_35_list.get(0);
		Assert.assertNotNull(StructDeclarator_36_Var
		);
		//36
		final Declarator Declarator_37_Var
		 = (Declarator)StructDeclarator_36_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_37_Var
		);
		//37
		final DirectDeclarator DirectDeclarator_38_Var
		 = (DirectDeclarator)Declarator_37_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_38_Var
		);
		Assert.assertEquals("j", DirectDeclarator_38_Var
		.getId());
		final EList<? extends EObject> ConstExpr_38_list = StructDeclarator_36_Var
		.getConstExpr();
		Assert.assertNotNull(ConstExpr_38_list);
		Assert.assertEquals(1, ConstExpr_38_list.size());
		//38
		final ConstantExpression ConstantExpression_39_Var
		 = (ConstantExpression)ConstExpr_38_list.get(0);
		Assert.assertNotNull(ConstantExpression_39_Var
		);
		//39
		final ConditionalExpression ConditionalExpression_40_Var
		 = (ConditionalExpression)ConstantExpression_39_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_40_Var
		);
		//40
		final LogicalOrExpression LogicalOrExpression_41_Var
		 = (LogicalOrExpression)ConditionalExpression_40_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = LogicalOrExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final LogicalAndExpression LogicalAndExpression_42_Var
		 = (LogicalAndExpression)Expr_41_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = LogicalAndExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final InclusiveOrExpression InclusiveOrExpression_43_Var
		 = (InclusiveOrExpression)Expr_42_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = InclusiveOrExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final ExclusiveOrExpression ExclusiveOrExpression_44_Var
		 = (ExclusiveOrExpression)Expr_43_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = ExclusiveOrExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final AndExpression AndExpression_45_Var
		 = (AndExpression)Expr_44_list.get(0);
		Assert.assertNotNull(AndExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = AndExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final EqualityExpression EqualityExpression_46_Var
		 = (EqualityExpression)Expr_45_list.get(0);
		Assert.assertNotNull(EqualityExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = EqualityExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final RelationalExpression RelationalExpression_47_Var
		 = (RelationalExpression)Expr_46_list.get(0);
		Assert.assertNotNull(RelationalExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = RelationalExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final ShiftExpression ShiftExpression_48_Var
		 = (ShiftExpression)Expr_47_list.get(0);
		Assert.assertNotNull(ShiftExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = ShiftExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final AdditiveExpression AdditiveExpression_49_Var
		 = (AdditiveExpression)Expr_48_list.get(0);
		Assert.assertNotNull(AdditiveExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = AdditiveExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final MultiplicativeExpression MultiplicativeExpression_50_Var
		 = (MultiplicativeExpression)Expr_49_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = MultiplicativeExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final CastExpression CastExpression_51_Var
		 = (CastExpression)Expr_50_list.get(0);
		Assert.assertNotNull(CastExpression_51_Var
		);
		//51
		final UnaryExpression UnaryExpression_52_Var
		 = (UnaryExpression)CastExpression_51_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_52_Var
		);
		//52
		final PostfixExpression PostfixExpression_53_Var
		 = (PostfixExpression)UnaryExpression_52_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = PostfixExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final PrimaryExpression PrimaryExpression_54_Var
		 = (PrimaryExpression)Expr_53_list.get(0);
		Assert.assertNotNull(PrimaryExpression_54_Var
		);
		//54
		final Constant2 Constant2_55_Var
		 = (Constant2)PrimaryExpression_54_Var
		.getConst();
		Assert.assertNotNull(Constant2_55_Var
		);
		Assert.assertEquals("4", Constant2_55_Var
		.getDec());
		//55
		final StructDeclaration StructDeclaration_56_Var
		 = (StructDeclaration)StructDeclaration_7_list.get(2);
		Assert.assertNotNull(StructDeclaration_56_Var
		);
		//56
		final SpecifierQualifierList SpecifierQualifierList_57_Var
		 = (SpecifierQualifierList)StructDeclaration_56_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_57_Var
		);
		final EList<? extends EObject> TypeSpecifier_57_list = SpecifierQualifierList_57_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_57_list);
		Assert.assertEquals(1, TypeSpecifier_57_list.size());
		//57
		final TypeSpecifier TypeSpecifier_58_Var
		 = (TypeSpecifier)TypeSpecifier_57_list.get(0);
		Assert.assertNotNull(TypeSpecifier_58_Var
		);
		Assert.assertEquals("int", TypeSpecifier_58_Var
		.getName());
		//58
		final StructDeclaratorList StructDeclaratorList_59_Var
		 = (StructDeclaratorList)StructDeclaration_56_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_59_Var
		);
		final EList<? extends EObject> StructDeclarator_59_list = StructDeclaratorList_59_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_59_list);
		Assert.assertEquals(1, StructDeclarator_59_list.size());
		//59
		final StructDeclarator StructDeclarator_60_Var
		 = (StructDeclarator)StructDeclarator_59_list.get(0);
		Assert.assertNotNull(StructDeclarator_60_Var
		);
		//60
		final Declarator Declarator_61_Var
		 = (Declarator)StructDeclarator_60_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_61_Var
		);
		//61
		final DirectDeclarator DirectDeclarator_62_Var
		 = (DirectDeclarator)Declarator_61_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_62_Var
		);
		Assert.assertEquals("k", DirectDeclarator_62_Var
		.getId());
		final EList<? extends EObject> ConstExpr_62_list = StructDeclarator_60_Var
		.getConstExpr();
		Assert.assertNotNull(ConstExpr_62_list);
		Assert.assertEquals(1, ConstExpr_62_list.size());
		//62
		final ConstantExpression ConstantExpression_63_Var
		 = (ConstantExpression)ConstExpr_62_list.get(0);
		Assert.assertNotNull(ConstantExpression_63_Var
		);
		//63
		final ConditionalExpression ConditionalExpression_64_Var
		 = (ConditionalExpression)ConstantExpression_63_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_64_Var
		);
		//64
		final LogicalOrExpression LogicalOrExpression_65_Var
		 = (LogicalOrExpression)ConditionalExpression_64_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = LogicalOrExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final LogicalAndExpression LogicalAndExpression_66_Var
		 = (LogicalAndExpression)Expr_65_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = LogicalAndExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final InclusiveOrExpression InclusiveOrExpression_67_Var
		 = (InclusiveOrExpression)Expr_66_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = InclusiveOrExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final ExclusiveOrExpression ExclusiveOrExpression_68_Var
		 = (ExclusiveOrExpression)Expr_67_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = ExclusiveOrExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final AndExpression AndExpression_69_Var
		 = (AndExpression)Expr_68_list.get(0);
		Assert.assertNotNull(AndExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = AndExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final EqualityExpression EqualityExpression_70_Var
		 = (EqualityExpression)Expr_69_list.get(0);
		Assert.assertNotNull(EqualityExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = EqualityExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final RelationalExpression RelationalExpression_71_Var
		 = (RelationalExpression)Expr_70_list.get(0);
		Assert.assertNotNull(RelationalExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = RelationalExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final ShiftExpression ShiftExpression_72_Var
		 = (ShiftExpression)Expr_71_list.get(0);
		Assert.assertNotNull(ShiftExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = ShiftExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final AdditiveExpression AdditiveExpression_73_Var
		 = (AdditiveExpression)Expr_72_list.get(0);
		Assert.assertNotNull(AdditiveExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = AdditiveExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final MultiplicativeExpression MultiplicativeExpression_74_Var
		 = (MultiplicativeExpression)Expr_73_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = MultiplicativeExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final CastExpression CastExpression_75_Var
		 = (CastExpression)Expr_74_list.get(0);
		Assert.assertNotNull(CastExpression_75_Var
		);
		//75
		final UnaryExpression UnaryExpression_76_Var
		 = (UnaryExpression)CastExpression_75_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_76_Var
		);
		//76
		final PostfixExpression PostfixExpression_77_Var
		 = (PostfixExpression)UnaryExpression_76_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = PostfixExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final PrimaryExpression PrimaryExpression_78_Var
		 = (PrimaryExpression)Expr_77_list.get(0);
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
		final StructDeclaration StructDeclaration_80_Var
		 = (StructDeclaration)StructDeclaration_7_list.get(3);
		Assert.assertNotNull(StructDeclaration_80_Var
		);
		//80
		final SpecifierQualifierList SpecifierQualifierList_81_Var
		 = (SpecifierQualifierList)StructDeclaration_80_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_81_Var
		);
		final EList<? extends EObject> TypeSpecifier_81_list = SpecifierQualifierList_81_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_81_list);
		Assert.assertEquals(1, TypeSpecifier_81_list.size());
		//81
		final TypeSpecifier TypeSpecifier_82_Var
		 = (TypeSpecifier)TypeSpecifier_81_list.get(0);
		Assert.assertNotNull(TypeSpecifier_82_Var
		);
		Assert.assertEquals("int", TypeSpecifier_82_Var
		.getName());
		//82
		final StructDeclaratorList StructDeclaratorList_83_Var
		 = (StructDeclaratorList)StructDeclaration_80_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_83_Var
		);
		final EList<? extends EObject> StructDeclarator_83_list = StructDeclaratorList_83_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_83_list);
		Assert.assertEquals(1, StructDeclarator_83_list.size());
		//83
		final StructDeclarator StructDeclarator_84_Var
		 = (StructDeclarator)StructDeclarator_83_list.get(0);
		Assert.assertNotNull(StructDeclarator_84_Var
		);
		Assert.assertNull(StructDeclarator_84_Var
		.getDeclarator());
		final EList<? extends EObject> ConstExpr_84_list = StructDeclarator_84_Var
		.getConstExpr();
		Assert.assertNotNull(ConstExpr_84_list);
		Assert.assertEquals(1, ConstExpr_84_list.size());
		//84
		final ConstantExpression ConstantExpression_85_Var
		 = (ConstantExpression)ConstExpr_84_list.get(0);
		Assert.assertNotNull(ConstantExpression_85_Var
		);
		//85
		final ConditionalExpression ConditionalExpression_86_Var
		 = (ConditionalExpression)ConstantExpression_85_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_86_Var
		);
		//86
		final LogicalOrExpression LogicalOrExpression_87_Var
		 = (LogicalOrExpression)ConditionalExpression_86_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = LogicalOrExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final LogicalAndExpression LogicalAndExpression_88_Var
		 = (LogicalAndExpression)Expr_87_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = LogicalAndExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final InclusiveOrExpression InclusiveOrExpression_89_Var
		 = (InclusiveOrExpression)Expr_88_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = InclusiveOrExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final ExclusiveOrExpression ExclusiveOrExpression_90_Var
		 = (ExclusiveOrExpression)Expr_89_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = ExclusiveOrExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final AndExpression AndExpression_91_Var
		 = (AndExpression)Expr_90_list.get(0);
		Assert.assertNotNull(AndExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = AndExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final EqualityExpression EqualityExpression_92_Var
		 = (EqualityExpression)Expr_91_list.get(0);
		Assert.assertNotNull(EqualityExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = EqualityExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final RelationalExpression RelationalExpression_93_Var
		 = (RelationalExpression)Expr_92_list.get(0);
		Assert.assertNotNull(RelationalExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = RelationalExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final ShiftExpression ShiftExpression_94_Var
		 = (ShiftExpression)Expr_93_list.get(0);
		Assert.assertNotNull(ShiftExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = ShiftExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final AdditiveExpression AdditiveExpression_95_Var
		 = (AdditiveExpression)Expr_94_list.get(0);
		Assert.assertNotNull(AdditiveExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = AdditiveExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final MultiplicativeExpression MultiplicativeExpression_96_Var
		 = (MultiplicativeExpression)Expr_95_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = MultiplicativeExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final CastExpression CastExpression_97_Var
		 = (CastExpression)Expr_96_list.get(0);
		Assert.assertNotNull(CastExpression_97_Var
		);
		//97
		final UnaryExpression UnaryExpression_98_Var
		 = (UnaryExpression)CastExpression_97_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_98_Var
		);
		//98
		final PostfixExpression PostfixExpression_99_Var
		 = (PostfixExpression)UnaryExpression_98_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = PostfixExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final PrimaryExpression PrimaryExpression_100_Var
		 = (PrimaryExpression)Expr_99_list.get(0);
		Assert.assertNotNull(PrimaryExpression_100_Var
		);
		//100
		final Constant2 Constant2_101_Var
		 = (Constant2)PrimaryExpression_100_Var
		.getConst();
		Assert.assertNotNull(Constant2_101_Var
		);
		Assert.assertEquals("8", Constant2_101_Var
		.getDec());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0081_Bitfields.c");
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
				method.invoke(this.generator, "Test0081_Bitfields.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0081_Bitfields.c");
		final String expected = this.getTextFromFile(
			"res/Test0081_Bitfields.c"
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


