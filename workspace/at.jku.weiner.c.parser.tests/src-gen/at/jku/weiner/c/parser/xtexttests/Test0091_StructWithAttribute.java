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
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
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
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.GccAttributeSpecifier;
import at.jku.weiner.c.parser.parser.GccAttributeList;
import at.jku.weiner.c.parser.parser.GccAttribute;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.GccAttributeSpecifier;
import at.jku.weiner.c.parser.parser.GccAttributeList;
import at.jku.weiner.c.parser.parser.GccAttribute;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0091_StructWithAttribute {
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
		at.jku.weiner.c.parser.xtexttests.TestSuite_Structs.testSize();
	}
	
	@After
	public void cleanUp() {
		at.jku.weiner.c.parser.xtexttests.TestSuite_Structs.testSize();
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
			"res/Test0091_StructWithAttribute.c");
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
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
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
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_WHITESPACE",
				"RULE_KW_ATTRIBUTE3",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_ALIGNED3",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTSHIFT",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_WHITESPACE",
				"RULE_KW_ATTRIBUTE3",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_ALIGNED3",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTSHIFT",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
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
			"res/Test0091_StructWithAttribute.c");
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
		Assert.assertEquals(2, DeclarationSpecifier_3_list.size());
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
		.getIdent());
		//6
		final StructDeclarationList StructDeclarationList_7_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_5_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_7_Var
		);
		final EList<? extends EObject> StructDeclaration_7_list = StructDeclarationList_7_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_7_list);
		Assert.assertEquals(2, StructDeclaration_7_list.size());
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
		.getIdent());
		//14
		final StructDeclaration StructDeclaration_15_Var
		 = (StructDeclaration)StructDeclaration_7_list.get(1);
		Assert.assertNotNull(StructDeclaration_15_Var
		);
		//15
		final SpecifierQualifierList SpecifierQualifierList_16_Var
		 = (SpecifierQualifierList)StructDeclaration_15_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_16_Var
		);
		final EList<? extends EObject> TypeSpecifier_16_list = SpecifierQualifierList_16_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_16_list);
		Assert.assertEquals(2, TypeSpecifier_16_list.size());
		//16
		final TypeSpecifier TypeSpecifier_17_Var
		 = (TypeSpecifier)TypeSpecifier_16_list.get(0);
		Assert.assertNotNull(TypeSpecifier_17_Var
		);
		//17
		final StructOrUnionSpecifier StructOrUnionSpecifier_18_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_17_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_18_Var
		);
		//18
		final StructOrUnion StructOrUnion_19_Var
		 = (StructOrUnion)StructOrUnionSpecifier_18_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_19_Var
		);
		Assert.assertEquals("struct", StructOrUnion_19_Var
		.getName());
		Assert.assertEquals("bar", StructOrUnionSpecifier_18_Var
		.getIdent());
		//19
		final StructDeclarationList StructDeclarationList_20_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_18_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_20_Var
		);
		final EList<? extends EObject> StructDeclaration_20_list = StructDeclarationList_20_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_20_list);
		Assert.assertEquals(1, StructDeclaration_20_list.size());
		//20
		final StructDeclaration StructDeclaration_21_Var
		 = (StructDeclaration)StructDeclaration_20_list.get(0);
		Assert.assertNotNull(StructDeclaration_21_Var
		);
		//21
		final SpecifierQualifierList SpecifierQualifierList_22_Var
		 = (SpecifierQualifierList)StructDeclaration_21_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_22_Var
		);
		final EList<? extends EObject> TypeSpecifier_22_list = SpecifierQualifierList_22_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_22_list);
		Assert.assertEquals(1, TypeSpecifier_22_list.size());
		//22
		final TypeSpecifier TypeSpecifier_23_Var
		 = (TypeSpecifier)TypeSpecifier_22_list.get(0);
		Assert.assertNotNull(TypeSpecifier_23_Var
		);
		Assert.assertEquals("int", TypeSpecifier_23_Var
		.getName());
		//23
		final StructDeclaratorList StructDeclaratorList_24_Var
		 = (StructDeclaratorList)StructDeclaration_21_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_24_Var
		);
		final EList<? extends EObject> StructDeclarator_24_list = StructDeclaratorList_24_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_24_list);
		Assert.assertEquals(1, StructDeclarator_24_list.size());
		//24
		final StructDeclarator StructDeclarator_25_Var
		 = (StructDeclarator)StructDeclarator_24_list.get(0);
		Assert.assertNotNull(StructDeclarator_25_Var
		);
		//25
		final Declarator Declarator_26_Var
		 = (Declarator)StructDeclarator_25_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_26_Var
		);
		//26
		final DirectDeclarator DirectDeclarator_27_Var
		 = (DirectDeclarator)Declarator_26_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_27_Var
		);
		Assert.assertEquals("j", DirectDeclarator_27_Var
		.getIdent());
		//27
		final TypeSpecifier TypeSpecifier_28_Var
		 = (TypeSpecifier)TypeSpecifier_16_list.get(1);
		Assert.assertNotNull(TypeSpecifier_28_Var
		);
		//28
		final GccAttributeSpecifier GccAttributeSpecifier_29_Var
		 = (GccAttributeSpecifier)TypeSpecifier_28_Var
		.getGccAttributeSpecifier();
		Assert.assertNotNull(GccAttributeSpecifier_29_Var
		);
		//29
		final GccAttributeList GccAttributeList_30_Var
		 = (GccAttributeList)GccAttributeSpecifier_29_Var
		.getList();
		Assert.assertNotNull(GccAttributeList_30_Var
		);
		final EList<? extends EObject> GccAttribute_30_list = GccAttributeList_30_Var
		.getGccAttribute();
		Assert.assertNotNull(GccAttribute_30_list);
		Assert.assertEquals(1, GccAttribute_30_list.size());
		//30
		final GccAttribute GccAttribute_31_Var
		 = (GccAttribute)GccAttribute_30_list.get(0);
		Assert.assertNotNull(GccAttribute_31_Var
		);
		Assert.assertEquals("__aligned__", GccAttribute_31_Var
		.getKeyword());
		//31
		final ArgumentExpressionList ArgumentExpressionList_32_Var
		 = (ArgumentExpressionList)GccAttribute_31_Var
		.getList();
		Assert.assertNotNull(ArgumentExpressionList_32_Var
		);
		final EList<? extends EObject> Expr_32_list = ArgumentExpressionList_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final PrimaryExpression PrimaryExpression_33_Var
		 = (PrimaryExpression)Expr_32_list.get(0);
		Assert.assertNotNull(PrimaryExpression_33_Var
		);
		Assert.assertTrue(PrimaryExpression_33_Var
		.isParentheses());
		//33
		final ShiftExpression ShiftExpression_34_Var
		 = (ShiftExpression)PrimaryExpression_33_Var
		.getExpr();
		Assert.assertNotNull(ShiftExpression_34_Var
		);
		Assert.assertEquals("<<", ShiftExpression_34_Var
		.getOp());
		//34
		final PrimaryExpression PrimaryExpression_35_Var
		 = (PrimaryExpression)ShiftExpression_34_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_35_Var
		);
		//35
		final Constant2 Constant2_36_Var
		 = (Constant2)PrimaryExpression_35_Var
		.getConst();
		Assert.assertNotNull(Constant2_36_Var
		);
		Assert.assertEquals("2", Constant2_36_Var
		.getDec());
		//36
		final PrimaryExpression PrimaryExpression_37_Var
		 = (PrimaryExpression)ShiftExpression_34_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_37_Var
		);
		Assert.assertTrue(PrimaryExpression_37_Var
		.isParentheses());
		//37
		final PrimaryExpression PrimaryExpression_38_Var
		 = (PrimaryExpression)PrimaryExpression_37_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_38_Var
		);
		//38
		final Constant2 Constant2_39_Var
		 = (Constant2)PrimaryExpression_38_Var
		.getConst();
		Assert.assertNotNull(Constant2_39_Var
		);
		Assert.assertEquals("3", Constant2_39_Var
		.getDec());
		//39
		final TypeSpecifier TypeSpecifier_40_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(1);
		Assert.assertNotNull(TypeSpecifier_40_Var
		);
		//40
		final GccAttributeSpecifier GccAttributeSpecifier_41_Var
		 = (GccAttributeSpecifier)TypeSpecifier_40_Var
		.getGccAttributeSpecifier();
		Assert.assertNotNull(GccAttributeSpecifier_41_Var
		);
		//41
		final GccAttributeList GccAttributeList_42_Var
		 = (GccAttributeList)GccAttributeSpecifier_41_Var
		.getList();
		Assert.assertNotNull(GccAttributeList_42_Var
		);
		final EList<? extends EObject> GccAttribute_42_list = GccAttributeList_42_Var
		.getGccAttribute();
		Assert.assertNotNull(GccAttribute_42_list);
		Assert.assertEquals(1, GccAttribute_42_list.size());
		//42
		final GccAttribute GccAttribute_43_Var
		 = (GccAttribute)GccAttribute_42_list.get(0);
		Assert.assertNotNull(GccAttribute_43_Var
		);
		Assert.assertEquals("__aligned__", GccAttribute_43_Var
		.getKeyword());
		//43
		final ArgumentExpressionList ArgumentExpressionList_44_Var
		 = (ArgumentExpressionList)GccAttribute_43_Var
		.getList();
		Assert.assertNotNull(ArgumentExpressionList_44_Var
		);
		final EList<? extends EObject> Expr_44_list = ArgumentExpressionList_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final PrimaryExpression PrimaryExpression_45_Var
		 = (PrimaryExpression)Expr_44_list.get(0);
		Assert.assertNotNull(PrimaryExpression_45_Var
		);
		Assert.assertTrue(PrimaryExpression_45_Var
		.isParentheses());
		//45
		final ShiftExpression ShiftExpression_46_Var
		 = (ShiftExpression)PrimaryExpression_45_Var
		.getExpr();
		Assert.assertNotNull(ShiftExpression_46_Var
		);
		Assert.assertEquals("<<", ShiftExpression_46_Var
		.getOp());
		//46
		final PrimaryExpression PrimaryExpression_47_Var
		 = (PrimaryExpression)ShiftExpression_46_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_47_Var
		);
		//47
		final Constant2 Constant2_48_Var
		 = (Constant2)PrimaryExpression_47_Var
		.getConst();
		Assert.assertNotNull(Constant2_48_Var
		);
		Assert.assertEquals("2", Constant2_48_Var
		.getDec());
		//48
		final PrimaryExpression PrimaryExpression_49_Var
		 = (PrimaryExpression)ShiftExpression_46_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_49_Var
		);
		Assert.assertTrue(PrimaryExpression_49_Var
		.isParentheses());
		//49
		final PrimaryExpression PrimaryExpression_50_Var
		 = (PrimaryExpression)PrimaryExpression_49_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_50_Var
		);
		//50
		final Constant2 Constant2_51_Var
		 = (Constant2)PrimaryExpression_50_Var
		.getConst();
		Assert.assertNotNull(Constant2_51_Var
		);
		Assert.assertEquals("3", Constant2_51_Var
		.getDec());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0091_StructWithAttribute.c");
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
				method.invoke(this.generator, "Test0091_StructWithAttribute.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0091_StructWithAttribute.c");
		final String expected = this.getTextFromFile(
			"res/Test0091_StructWithAttribute.c"
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


