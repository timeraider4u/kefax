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
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.AbstractDeclarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0043_ArraySize {
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
			"res/Test0043_ArraySize.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_CHAR", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTBRACKET", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_SKW_STAR", 
				"RULE_WHITESPACE", 
				"RULE_KW_SIZEOF", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_KW_INT", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_MINUS", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_SKW_STAR", 
				"RULE_WHITESPACE", 
				"RULE_KW_SIZEOF", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_KW_VOID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_STAR", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_MINUS", 
				"RULE_WHITESPACE", 
				"RULE_KW_SIZEOF", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_KW_INT", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_RIGHTBRACKET", 
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
			"res/Test0043_ArraySize.c");
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
		Assert.assertEquals("char", TypeSpecifier_4_Var
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
		Assert.assertEquals("__my_array", DirectDeclarator_8_Var
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
		//9
		final AssignmentExpression AssignmentExpression_10_Var
		 = (AssignmentExpression)DeclaratorSuffix_9_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_10_Var
		);
		//10
		final ConditionalExpression ConditionalExpression_11_Var
		 = (ConditionalExpression)AssignmentExpression_10_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_11_Var
		);
		//11
		final LogicalOrExpression LogicalOrExpression_12_Var
		 = (LogicalOrExpression)ConditionalExpression_11_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_12_Var
		);
		final EList<? extends EObject> Expr_12_list = LogicalOrExpression_12_Var
		.getExpr();
		Assert.assertNotNull(Expr_12_list);
		Assert.assertEquals(1, Expr_12_list.size());
		//12
		final LogicalAndExpression LogicalAndExpression_13_Var
		 = (LogicalAndExpression)Expr_12_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_13_Var
		);
		final EList<? extends EObject> Expr_13_list = LogicalAndExpression_13_Var
		.getExpr();
		Assert.assertNotNull(Expr_13_list);
		Assert.assertEquals(1, Expr_13_list.size());
		//13
		final InclusiveOrExpression InclusiveOrExpression_14_Var
		 = (InclusiveOrExpression)Expr_13_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = InclusiveOrExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		//14
		final ExclusiveOrExpression ExclusiveOrExpression_15_Var
		 = (ExclusiveOrExpression)Expr_14_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = ExclusiveOrExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final AndExpression AndExpression_16_Var
		 = (AndExpression)Expr_15_list.get(0);
		Assert.assertNotNull(AndExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = AndExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final EqualityExpression EqualityExpression_17_Var
		 = (EqualityExpression)Expr_16_list.get(0);
		Assert.assertNotNull(EqualityExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = EqualityExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final RelationalExpression RelationalExpression_18_Var
		 = (RelationalExpression)Expr_17_list.get(0);
		Assert.assertNotNull(RelationalExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = RelationalExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final ShiftExpression ShiftExpression_19_Var
		 = (ShiftExpression)Expr_18_list.get(0);
		Assert.assertNotNull(ShiftExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = ShiftExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final AdditiveExpression AdditiveExpression_20_Var
		 = (AdditiveExpression)Expr_19_list.get(0);
		Assert.assertNotNull(AdditiveExpression_20_Var
		);
		Assert.assertEquals("[-, -]", AdditiveExpression_20_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_20_list = AdditiveExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(3, Expr_20_list.size());
		//20
		final MultiplicativeExpression MultiplicativeExpression_21_Var
		 = (MultiplicativeExpression)Expr_20_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_21_Var
		);
		Assert.assertEquals("[*]", MultiplicativeExpression_21_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_21_list = MultiplicativeExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(2, Expr_21_list.size());
		//21
		final CastExpression CastExpression_22_Var
		 = (CastExpression)Expr_21_list.get(0);
		Assert.assertNotNull(CastExpression_22_Var
		);
		//22
		final UnaryExpression UnaryExpression_23_Var
		 = (UnaryExpression)CastExpression_22_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_23_Var
		);
		//23
		final PostfixExpression PostfixExpression_24_Var
		 = (PostfixExpression)UnaryExpression_23_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = PostfixExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final PrimaryExpression PrimaryExpression_25_Var
		 = (PrimaryExpression)Expr_24_list.get(0);
		Assert.assertNotNull(PrimaryExpression_25_Var
		);
		//25
		final Constant2 Constant2_26_Var
		 = (Constant2)PrimaryExpression_25_Var
		.getConst();
		Assert.assertNotNull(Constant2_26_Var
		);
		Assert.assertEquals("25", Constant2_26_Var
		.getDec());
		//26
		final CastExpression CastExpression_27_Var
		 = (CastExpression)Expr_21_list.get(1);
		Assert.assertNotNull(CastExpression_27_Var
		);
		//27
		final UnaryExpression UnaryExpression_28_Var
		 = (UnaryExpression)CastExpression_27_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_28_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_28_Var
		.getSizeOf());
		//28
		final TypeName TypeName_29_Var
		 = (TypeName)UnaryExpression_28_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_29_Var
		);
		//29
		final SpecifierQualifierList SpecifierQualifierList_30_Var
		 = (SpecifierQualifierList)TypeName_29_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_30_Var
		);
		final EList<? extends EObject> TypeSpecifier_30_list = SpecifierQualifierList_30_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_30_list);
		Assert.assertEquals(1, TypeSpecifier_30_list.size());
		//30
		final TypeSpecifier TypeSpecifier_31_Var
		 = (TypeSpecifier)TypeSpecifier_30_list.get(0);
		Assert.assertNotNull(TypeSpecifier_31_Var
		);
		Assert.assertEquals("int", TypeSpecifier_31_Var
		.getName());
		//31
		final MultiplicativeExpression MultiplicativeExpression_32_Var
		 = (MultiplicativeExpression)Expr_20_list.get(1);
		Assert.assertNotNull(MultiplicativeExpression_32_Var
		);
		Assert.assertEquals("[*]", MultiplicativeExpression_32_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_32_list = MultiplicativeExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(2, Expr_32_list.size());
		//32
		final CastExpression CastExpression_33_Var
		 = (CastExpression)Expr_32_list.get(0);
		Assert.assertNotNull(CastExpression_33_Var
		);
		//33
		final UnaryExpression UnaryExpression_34_Var
		 = (UnaryExpression)CastExpression_33_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_34_Var
		);
		//34
		final PostfixExpression PostfixExpression_35_Var
		 = (PostfixExpression)UnaryExpression_34_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = PostfixExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final PrimaryExpression PrimaryExpression_36_Var
		 = (PrimaryExpression)Expr_35_list.get(0);
		Assert.assertNotNull(PrimaryExpression_36_Var
		);
		//36
		final Constant2 Constant2_37_Var
		 = (Constant2)PrimaryExpression_36_Var
		.getConst();
		Assert.assertNotNull(Constant2_37_Var
		);
		Assert.assertEquals("8", Constant2_37_Var
		.getDec());
		//37
		final CastExpression CastExpression_38_Var
		 = (CastExpression)Expr_32_list.get(1);
		Assert.assertNotNull(CastExpression_38_Var
		);
		//38
		final UnaryExpression UnaryExpression_39_Var
		 = (UnaryExpression)CastExpression_38_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_39_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_39_Var
		.getSizeOf());
		//39
		final TypeName TypeName_40_Var
		 = (TypeName)UnaryExpression_39_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_40_Var
		);
		//40
		final SpecifierQualifierList SpecifierQualifierList_41_Var
		 = (SpecifierQualifierList)TypeName_40_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_41_Var
		);
		final EList<? extends EObject> TypeSpecifier_41_list = SpecifierQualifierList_41_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_41_list);
		Assert.assertEquals(1, TypeSpecifier_41_list.size());
		//41
		final TypeSpecifier TypeSpecifier_42_Var
		 = (TypeSpecifier)TypeSpecifier_41_list.get(0);
		Assert.assertNotNull(TypeSpecifier_42_Var
		);
		Assert.assertEquals("void", TypeSpecifier_42_Var
		.getName());
		//42
		final AbstractDeclarator AbstractDeclarator_43_Var
		 = (AbstractDeclarator)TypeName_40_Var
		.getAbstractDeclarator();
		Assert.assertNotNull(AbstractDeclarator_43_Var
		);
		//43
		final Pointer Pointer_44_Var
		 = (Pointer)AbstractDeclarator_43_Var
		.getPointer();
		Assert.assertNotNull(Pointer_44_Var
		);
		Assert.assertEquals("[*]", Pointer_44_Var
		.getStar().toString());
		//44
		final MultiplicativeExpression MultiplicativeExpression_45_Var
		 = (MultiplicativeExpression)Expr_20_list.get(2);
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
		Assert.assertEquals("sizeof", UnaryExpression_47_Var
		.getSizeOf());
		//47
		final TypeName TypeName_48_Var
		 = (TypeName)UnaryExpression_47_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_48_Var
		);
		//48
		final SpecifierQualifierList SpecifierQualifierList_49_Var
		 = (SpecifierQualifierList)TypeName_48_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_49_Var
		);
		final EList<? extends EObject> TypeSpecifier_49_list = SpecifierQualifierList_49_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_49_list);
		Assert.assertEquals(1, TypeSpecifier_49_list.size());
		//49
		final TypeSpecifier TypeSpecifier_50_Var
		 = (TypeSpecifier)TypeSpecifier_49_list.get(0);
		Assert.assertNotNull(TypeSpecifier_50_Var
		);
		Assert.assertEquals("int", TypeSpecifier_50_Var
		.getName());
		Assert.assertEquals(";", Declaration_2_Var
		.getSemi());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0043_ArraySize.c");
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
				method.invoke(this.generator, "Test0043_ArraySize.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0043_ArraySize.c");
		final String expected = this.getTextFromFile(
			"res/Test0043_ArraySize.c"
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

