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
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.StorageClassSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.ParameterTypeList;
import at.jku.weiner.c.parser.parser.ParameterList;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
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
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.Expression;
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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
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
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0055_StructInFunctionCall {
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
			"res/Test0055_StructInFunctionCall.c");
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
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_EXTERN",
				"RULE_WHITESPACE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_STRUCT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_STRUCT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
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
			"res/Test0055_StructInFunctionCall.c");
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
		Assert.assertEquals(3, External_0_list.size());
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
		final StructOrUnionSpecifier StructOrUnionSpecifier_4_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_4_Var
		);
		//4
		final StructOrUnion StructOrUnion_5_Var
		 = (StructOrUnion)StructOrUnionSpecifier_4_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_5_Var
		);
		Assert.assertEquals("struct", StructOrUnion_5_Var
		.getName());
		Assert.assertEquals("foo", StructOrUnionSpecifier_4_Var
		.getId());
		//5
		final StructDeclarationList StructDeclarationList_6_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_4_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_6_Var
		);
		final EList<? extends EObject> StructDeclaration_6_list = StructDeclarationList_6_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_6_list);
		Assert.assertEquals(1, StructDeclaration_6_list.size());
		//6
		final StructDeclaration StructDeclaration_7_Var
		 = (StructDeclaration)StructDeclaration_6_list.get(0);
		Assert.assertNotNull(StructDeclaration_7_Var
		);
		//7
		final SpecifierQualifierList SpecifierQualifierList_8_Var
		 = (SpecifierQualifierList)StructDeclaration_7_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_8_Var
		);
		final EList<? extends EObject> TypeSpecifier_8_list = SpecifierQualifierList_8_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_8_list);
		Assert.assertEquals(1, TypeSpecifier_8_list.size());
		//8
		final TypeSpecifier TypeSpecifier_9_Var
		 = (TypeSpecifier)TypeSpecifier_8_list.get(0);
		Assert.assertNotNull(TypeSpecifier_9_Var
		);
		Assert.assertEquals("int", TypeSpecifier_9_Var
		.getName());
		//9
		final StructDeclaratorList StructDeclaratorList_10_Var
		 = (StructDeclaratorList)StructDeclaration_7_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_10_Var
		);
		final EList<? extends EObject> StructDeclarator_10_list = StructDeclaratorList_10_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_10_list);
		Assert.assertEquals(1, StructDeclarator_10_list.size());
		//10
		final StructDeclarator StructDeclarator_11_Var
		 = (StructDeclarator)StructDeclarator_10_list.get(0);
		Assert.assertNotNull(StructDeclarator_11_Var
		);
		//11
		final Declarator Declarator_12_Var
		 = (Declarator)StructDeclarator_11_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_12_Var
		);
		//12
		final DirectDeclarator DirectDeclarator_13_Var
		 = (DirectDeclarator)Declarator_12_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_13_Var
		);
		Assert.assertEquals("i", DirectDeclarator_13_Var
		.getId());
		//13
		final ExternalDeclaration ExternalDeclaration_14_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_14_Var
		);
		//14
		final Declaration Declaration_15_Var
		 = (Declaration)ExternalDeclaration_14_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_15_Var
		);
		//15
		final DeclarationSpecifiers DeclarationSpecifiers_16_Var
		 = (DeclarationSpecifiers)Declaration_15_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_16_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_16_list = DeclarationSpecifiers_16_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_16_list);
		Assert.assertEquals(2, DeclarationSpecifier_16_list.size());
		//16
		final StorageClassSpecifier StorageClassSpecifier_17_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_16_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_17_Var
		);
		Assert.assertEquals("extern", StorageClassSpecifier_17_Var
		.getName());
		//17
		final TypeSpecifier TypeSpecifier_18_Var
		 = (TypeSpecifier)DeclarationSpecifier_16_list.get(1);
		Assert.assertNotNull(TypeSpecifier_18_Var
		);
		Assert.assertEquals("void", TypeSpecifier_18_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_18_list = Declaration_15_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_18_list);
		Assert.assertEquals(1, InitDeclaratorList_18_list.size());
		//18
		final InitDeclaratorList InitDeclaratorList_19_Var
		 = (InitDeclaratorList)InitDeclaratorList_18_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_19_Var
		);
		final EList<? extends EObject> InitDeclarator_19_list = InitDeclaratorList_19_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_19_list);
		Assert.assertEquals(1, InitDeclarator_19_list.size());
		//19
		final InitDeclarator InitDeclarator_20_Var
		 = (InitDeclarator)InitDeclarator_19_list.get(0);
		Assert.assertNotNull(InitDeclarator_20_Var
		);
		//20
		final Declarator Declarator_21_Var
		 = (Declarator)InitDeclarator_20_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_21_Var
		);
		//21
		final DirectDeclarator DirectDeclarator_22_Var
		 = (DirectDeclarator)Declarator_21_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_22_Var
		);
		Assert.assertEquals("myprintf", DirectDeclarator_22_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_22_list = DirectDeclarator_22_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_22_list);
		Assert.assertEquals(1, DeclaratorSuffix_22_list.size());
		//22
		final DeclaratorSuffix DeclaratorSuffix_23_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_22_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_23_Var
		);
		//23
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_24_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_23_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_24_Var
		);
		final EList<? extends EObject> ParameterTypeList_24_list = DirectDeclaratorLastSuffix_24_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_24_list);
		Assert.assertEquals(1, ParameterTypeList_24_list.size());
		//24
		final ParameterTypeList ParameterTypeList_25_Var
		 = (ParameterTypeList)ParameterTypeList_24_list.get(0);
		Assert.assertNotNull(ParameterTypeList_25_Var
		);
		//25
		final ParameterList ParameterList_26_Var
		 = (ParameterList)ParameterTypeList_25_Var
		.getList();
		Assert.assertNotNull(ParameterList_26_Var
		);
		final EList<? extends EObject> ParameterDeclaration_26_list = ParameterList_26_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_26_list);
		Assert.assertEquals(1, ParameterDeclaration_26_list.size());
		//26
		final ParameterDeclaration ParameterDeclaration_27_Var
		 = (ParameterDeclaration)ParameterDeclaration_26_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_27_Var
		);
		//27
		final DeclarationSpecifiers DeclarationSpecifiers_28_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_27_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_28_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_28_list = DeclarationSpecifiers_28_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_28_list);
		Assert.assertEquals(1, DeclarationSpecifier_28_list.size());
		//28
		final StructOrUnionSpecifier StructOrUnionSpecifier_29_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_28_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_29_Var
		);
		//29
		final StructOrUnion StructOrUnion_30_Var
		 = (StructOrUnion)StructOrUnionSpecifier_29_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_30_Var
		);
		Assert.assertEquals("struct", StructOrUnion_30_Var
		.getName());
		Assert.assertEquals("foo", StructOrUnionSpecifier_29_Var
		.getId());
		//30
		final Declarator Declarator_31_Var
		 = (Declarator)ParameterDeclaration_27_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_31_Var
		);
		//31
		final DirectDeclarator DirectDeclarator_32_Var
		 = (DirectDeclarator)Declarator_31_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_32_Var
		);
		Assert.assertEquals("foobar", DirectDeclarator_32_Var
		.getId());
		Assert.assertEquals(";", Declaration_15_Var
		.getSemi());
		//32
		final ExternalDeclaration ExternalDeclaration_33_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_33_Var
		);
		//33
		final FunctionDefHead FunctionDefHead_34_Var
		 = (FunctionDefHead)ExternalDeclaration_33_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_34_Var
		);
		//34
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_35_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_34_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_35_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_35_list = FunctionDeclarationSpecifiers_35_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_35_list);
		Assert.assertEquals(1, DeclarationSpecifier_35_list.size());
		//35
		final TypeSpecifier TypeSpecifier_36_Var
		 = (TypeSpecifier)DeclarationSpecifier_35_list.get(0);
		Assert.assertNotNull(TypeSpecifier_36_Var
		);
		Assert.assertEquals("void", TypeSpecifier_36_Var
		.getName());
		//36
		final Declarator Declarator_37_Var
		 = (Declarator)FunctionDefHead_34_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_37_Var
		);
		//37
		final DirectDeclarator DirectDeclarator_38_Var
		 = (DirectDeclarator)Declarator_37_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_38_Var
		);
		Assert.assertEquals("bar", DirectDeclarator_38_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_38_list = DirectDeclarator_38_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_38_list);
		Assert.assertEquals(1, DeclaratorSuffix_38_list.size());
		//38
		final DeclaratorSuffix DeclaratorSuffix_39_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_38_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_39_Var
		);
		//39
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_40_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_39_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_40_Var
		);
		final EList<? extends EObject> ParameterTypeList_40_list = DirectDeclaratorLastSuffix_40_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_40_list);
		Assert.assertEquals(1, ParameterTypeList_40_list.size());
		//40
		final ParameterTypeList ParameterTypeList_41_Var
		 = (ParameterTypeList)ParameterTypeList_40_list.get(0);
		Assert.assertNotNull(ParameterTypeList_41_Var
		);
		//41
		final ParameterList ParameterList_42_Var
		 = (ParameterList)ParameterTypeList_41_Var
		.getList();
		Assert.assertNotNull(ParameterList_42_Var
		);
		final EList<? extends EObject> ParameterDeclaration_42_list = ParameterList_42_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_42_list);
		Assert.assertEquals(1, ParameterDeclaration_42_list.size());
		//42
		final ParameterDeclaration ParameterDeclaration_43_Var
		 = (ParameterDeclaration)ParameterDeclaration_42_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_43_Var
		);
		//43
		final DeclarationSpecifiers DeclarationSpecifiers_44_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_43_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_44_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_44_list = DeclarationSpecifiers_44_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_44_list);
		Assert.assertEquals(1, DeclarationSpecifier_44_list.size());
		//44
		final StructOrUnionSpecifier StructOrUnionSpecifier_45_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_44_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_45_Var
		);
		//45
		final StructOrUnion StructOrUnion_46_Var
		 = (StructOrUnion)StructOrUnionSpecifier_45_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_46_Var
		);
		Assert.assertEquals("struct", StructOrUnion_46_Var
		.getName());
		Assert.assertEquals("foo", StructOrUnionSpecifier_45_Var
		.getId());
		//46
		final Declarator Declarator_47_Var
		 = (Declarator)ParameterDeclaration_43_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_47_Var
		);
		//47
		final DirectDeclarator DirectDeclarator_48_Var
		 = (DirectDeclarator)Declarator_47_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_48_Var
		);
		Assert.assertEquals("foobar", DirectDeclarator_48_Var
		.getId());
		//48
		final FunctionDefinition FunctionDefinition_49_Var
		 = (FunctionDefinition)ExternalDeclaration_33_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_49_Var
		);
		//49
		final BodyStatement BodyStatement_50_Var
		 = (BodyStatement)FunctionDefinition_49_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_50_Var
		);
		final EList<? extends EObject> BlockList_50_list = BodyStatement_50_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_50_list);
		Assert.assertEquals(1, BlockList_50_list.size());
		//50
		final BlockList BlockList_51_Var
		 = (BlockList)BlockList_50_list.get(0);
		Assert.assertNotNull(BlockList_51_Var
		);
		final EList<? extends EObject> Statement_51_list = BlockList_51_Var
		.getStatement();
		Assert.assertNotNull(Statement_51_list);
		Assert.assertEquals(1, Statement_51_list.size());
		//51
		final Statement Statement_52_Var
		 = (Statement)Statement_51_list.get(0);
		Assert.assertNotNull(Statement_52_Var
		);
		//52
		final ExpressionStatement ExpressionStatement_53_Var
		 = (ExpressionStatement)Statement_52_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_53_Var
		);
		//53
		final Expression Expression_54_Var
		 = (Expression)ExpressionStatement_53_Var
		.getExpression();
		Assert.assertNotNull(Expression_54_Var
		);
		final EList<? extends EObject> ExprExpr_54_list = Expression_54_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_54_list);
		Assert.assertEquals(1, ExprExpr_54_list.size());
		//54
		final AssignmentExpression AssignmentExpression_55_Var
		 = (AssignmentExpression)ExprExpr_54_list.get(0);
		Assert.assertNotNull(AssignmentExpression_55_Var
		);
		//55
		final ConditionalExpression ConditionalExpression_56_Var
		 = (ConditionalExpression)AssignmentExpression_55_Var
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
		Assert.assertEquals("myprintf", PrimaryExpression_70_Var
		.getId());
		final EList<? extends EObject> Suffix_70_list = PostfixExpression_69_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_70_list);
		Assert.assertEquals(1, Suffix_70_list.size());
		//70
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_71_Var
		 = (PostfixExpressionSuffixArgument)Suffix_70_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_71_Var
		);
		//71
		final ArgumentExpressionList ArgumentExpressionList_72_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_71_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_72_Var
		);
		final EList<? extends EObject> Expr_72_list = ArgumentExpressionList_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final AssignmentExpression AssignmentExpression_73_Var
		 = (AssignmentExpression)Expr_72_list.get(0);
		Assert.assertNotNull(AssignmentExpression_73_Var
		);
		//73
		final ConditionalExpression ConditionalExpression_74_Var
		 = (ConditionalExpression)AssignmentExpression_73_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_74_Var
		);
		//74
		final LogicalOrExpression LogicalOrExpression_75_Var
		 = (LogicalOrExpression)ConditionalExpression_74_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = LogicalOrExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final LogicalAndExpression LogicalAndExpression_76_Var
		 = (LogicalAndExpression)Expr_75_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = LogicalAndExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final InclusiveOrExpression InclusiveOrExpression_77_Var
		 = (InclusiveOrExpression)Expr_76_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = InclusiveOrExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final ExclusiveOrExpression ExclusiveOrExpression_78_Var
		 = (ExclusiveOrExpression)Expr_77_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = ExclusiveOrExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final AndExpression AndExpression_79_Var
		 = (AndExpression)Expr_78_list.get(0);
		Assert.assertNotNull(AndExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = AndExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final EqualityExpression EqualityExpression_80_Var
		 = (EqualityExpression)Expr_79_list.get(0);
		Assert.assertNotNull(EqualityExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = EqualityExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final RelationalExpression RelationalExpression_81_Var
		 = (RelationalExpression)Expr_80_list.get(0);
		Assert.assertNotNull(RelationalExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = RelationalExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final ShiftExpression ShiftExpression_82_Var
		 = (ShiftExpression)Expr_81_list.get(0);
		Assert.assertNotNull(ShiftExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = ShiftExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final AdditiveExpression AdditiveExpression_83_Var
		 = (AdditiveExpression)Expr_82_list.get(0);
		Assert.assertNotNull(AdditiveExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = AdditiveExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final MultiplicativeExpression MultiplicativeExpression_84_Var
		 = (MultiplicativeExpression)Expr_83_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = MultiplicativeExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final CastExpression CastExpression_85_Var
		 = (CastExpression)Expr_84_list.get(0);
		Assert.assertNotNull(CastExpression_85_Var
		);
		//85
		final UnaryExpression UnaryExpression_86_Var
		 = (UnaryExpression)CastExpression_85_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_86_Var
		);
		//86
		final PostfixExpression PostfixExpression_87_Var
		 = (PostfixExpression)UnaryExpression_86_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = PostfixExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final PrimaryExpression PrimaryExpression_88_Var
		 = (PrimaryExpression)Expr_87_list.get(0);
		Assert.assertNotNull(PrimaryExpression_88_Var
		);
		Assert.assertEquals("foobar", PrimaryExpression_88_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_53_Var
		.getSemi());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0055_StructInFunctionCall.c");
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
				method.invoke(this.generator, "Test0037_Struct.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0037_Struct.c");
		final String expected = this.getTextFromFile(
			"res/Test0055_StructInFunctionCall.c"
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


