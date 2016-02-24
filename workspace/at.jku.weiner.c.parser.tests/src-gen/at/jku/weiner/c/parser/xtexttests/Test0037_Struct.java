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
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.InitializerList;
import at.jku.weiner.c.parser.parser.Init;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Init;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
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
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0037_Struct {
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
			"res/Test0037_Struct.c");
			final String[] expected = new String[] {
				"RULE_LINEDIRECTIVE",
				"RULE_NEWLINE",
				"RULE_LINEDIRECTIVE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
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
				"RULE_KW_CHAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTBRACKET",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_STRUCT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_HEX_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_SKW_RIGHTBRACE",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_VOID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_STRING_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_KW_SIZEOF",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_DOT",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_STRING_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_KW_SIZEOF",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_DOT",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_STRING_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_KW_SIZEOF",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_DOT",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_HEX_LITERAL",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_DOT",
				"RULE_ID",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_STRING_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_DOT",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_STRING_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_DOT",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_STRING_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_DOT",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_STRING_LITERAL",
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_DOT",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
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
			"res/Test0037_Struct.c");
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
		Assert.assertEquals("employee", StructOrUnionSpecifier_5_Var
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
		Assert.assertEquals("ident", DirectDeclarator_14_Var
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
		Assert.assertEquals(1, TypeSpecifier_16_list.size());
		//16
		final TypeSpecifier TypeSpecifier_17_Var
		 = (TypeSpecifier)TypeSpecifier_16_list.get(0);
		Assert.assertNotNull(TypeSpecifier_17_Var
		);
		Assert.assertEquals("char", TypeSpecifier_17_Var
		.getName());
		//17
		final StructDeclaratorList StructDeclaratorList_18_Var
		 = (StructDeclaratorList)StructDeclaration_15_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_18_Var
		);
		final EList<? extends EObject> StructDeclarator_18_list = StructDeclaratorList_18_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_18_list);
		Assert.assertEquals(1, StructDeclarator_18_list.size());
		//18
		final StructDeclarator StructDeclarator_19_Var
		 = (StructDeclarator)StructDeclarator_18_list.get(0);
		Assert.assertNotNull(StructDeclarator_19_Var
		);
		//19
		final Declarator Declarator_20_Var
		 = (Declarator)StructDeclarator_19_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_20_Var
		);
		//20
		final DirectDeclarator DirectDeclarator_21_Var
		 = (DirectDeclarator)Declarator_20_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_21_Var
		);
		Assert.assertEquals("name", DirectDeclarator_21_Var
		.getIdent());
		final EList<? extends EObject> DeclaratorSuffix_21_list = DirectDeclarator_21_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_21_list);
		Assert.assertEquals(1, DeclaratorSuffix_21_list.size());
		//21
		final DeclaratorSuffix DeclaratorSuffix_22_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_21_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_22_Var
		);
		//22
		final PrimaryExpression PrimaryExpression_23_Var
		 = (PrimaryExpression)DeclaratorSuffix_22_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_23_Var
		);
		//23
		final Constant2 Constant2_24_Var
		 = (Constant2)PrimaryExpression_23_Var
		.getConst();
		Assert.assertNotNull(Constant2_24_Var
		);
		Assert.assertEquals("250", Constant2_24_Var
		.getDec());
		final EList<? extends EObject> InitDeclaratorList_24_list = Declaration_2_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_24_list);
		Assert.assertEquals(1, InitDeclaratorList_24_list.size());
		//24
		final InitDeclaratorList InitDeclaratorList_25_Var
		 = (InitDeclaratorList)InitDeclaratorList_24_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_25_Var
		);
		final EList<? extends EObject> InitDeclarator_25_list = InitDeclaratorList_25_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_25_list);
		Assert.assertEquals(1, InitDeclarator_25_list.size());
		//25
		final InitDeclarator InitDeclarator_26_Var
		 = (InitDeclarator)InitDeclarator_25_list.get(0);
		Assert.assertNotNull(InitDeclarator_26_Var
		);
		//26
		final Declarator Declarator_27_Var
		 = (Declarator)InitDeclarator_26_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_27_Var
		);
		//27
		final DirectDeclarator DirectDeclarator_28_Var
		 = (DirectDeclarator)Declarator_27_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_28_Var
		);
		Assert.assertEquals("phil", DirectDeclarator_28_Var
		.getIdent());
		//28
		final ExternalDeclaration ExternalDeclaration_29_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_29_Var
		);
		//29
		final Declaration Declaration_30_Var
		 = (Declaration)ExternalDeclaration_29_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_30_Var
		);
		//30
		final DeclarationSpecifiers DeclarationSpecifiers_31_Var
		 = (DeclarationSpecifiers)Declaration_30_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_31_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_31_list = DeclarationSpecifiers_31_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_31_list);
		Assert.assertEquals(1, DeclarationSpecifier_31_list.size());
		//31
		final TypeSpecifier TypeSpecifier_32_Var
		 = (TypeSpecifier)DeclarationSpecifier_31_list.get(0);
		Assert.assertNotNull(TypeSpecifier_32_Var
		);
		//32
		final StructOrUnionSpecifier StructOrUnionSpecifier_33_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_32_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_33_Var
		);
		//33
		final StructOrUnion StructOrUnion_34_Var
		 = (StructOrUnion)StructOrUnionSpecifier_33_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_34_Var
		);
		Assert.assertEquals("struct", StructOrUnion_34_Var
		.getName());
		Assert.assertEquals("employee", StructOrUnionSpecifier_33_Var
		.getIdent());
		final EList<? extends EObject> InitDeclaratorList_34_list = Declaration_30_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_34_list);
		Assert.assertEquals(1, InitDeclaratorList_34_list.size());
		//34
		final InitDeclaratorList InitDeclaratorList_35_Var
		 = (InitDeclaratorList)InitDeclaratorList_34_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_35_Var
		);
		final EList<? extends EObject> InitDeclarator_35_list = InitDeclaratorList_35_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_35_list);
		Assert.assertEquals(1, InitDeclarator_35_list.size());
		//35
		final InitDeclarator InitDeclarator_36_Var
		 = (InitDeclarator)InitDeclarator_35_list.get(0);
		Assert.assertNotNull(InitDeclarator_36_Var
		);
		//36
		final Declarator Declarator_37_Var
		 = (Declarator)InitDeclarator_36_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_37_Var
		);
		//37
		final DirectDeclarator DirectDeclarator_38_Var
		 = (DirectDeclarator)Declarator_37_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_38_Var
		);
		Assert.assertEquals("joe", DirectDeclarator_38_Var
		.getIdent());
		//38
		final Initializer Initializer_39_Var
		 = (Initializer)InitDeclarator_36_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_39_Var
		);
		//39
		final InitializerList InitializerList_40_Var
		 = (InitializerList)Initializer_39_Var
		.getList();
		Assert.assertNotNull(InitializerList_40_Var
		);
		final EList<? extends EObject> Init_40_list = InitializerList_40_Var
		.getInit();
		Assert.assertNotNull(Init_40_list);
		Assert.assertEquals(2, Init_40_list.size());
		//40
		final Init Init_41_Var
		 = (Init)Init_40_list.get(0);
		Assert.assertNotNull(Init_41_Var
		);
		//41
		final Initializer Initializer_42_Var
		 = (Initializer)Init_41_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_42_Var
		);
		//42
		final PrimaryExpression PrimaryExpression_43_Var
		 = (PrimaryExpression)Initializer_42_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_43_Var
		);
		//43
		final Constant2 Constant2_44_Var
		 = (Constant2)PrimaryExpression_43_Var
		.getConst();
		Assert.assertNotNull(Constant2_44_Var
		);
		Assert.assertEquals("0x007", Constant2_44_Var
		.getHex());
		//44
		final Init Init_45_Var
		 = (Init)Init_40_list.get(1);
		Assert.assertNotNull(Init_45_Var
		);
		//45
		final Initializer Initializer_46_Var
		 = (Initializer)Init_45_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_46_Var
		);
		//46
		final PrimaryExpression PrimaryExpression_47_Var
		 = (PrimaryExpression)Initializer_46_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_47_Var
		);
		Assert.assertEquals("[\"Joe Nobody\"]", PrimaryExpression_47_Var
		.getString().toString());
		//47
		final ExternalDeclaration ExternalDeclaration_48_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_48_Var
		);
		//48
		final FunctionDefHead FunctionDefHead_49_Var
		 = (FunctionDefHead)ExternalDeclaration_48_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_49_Var
		);
		//49
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_50_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_49_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_50_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_50_list = FunctionDeclarationSpecifiers_50_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_50_list);
		Assert.assertEquals(1, DeclarationSpecifier_50_list.size());
		//50
		final TypeSpecifier TypeSpecifier_51_Var
		 = (TypeSpecifier)DeclarationSpecifier_50_list.get(0);
		Assert.assertNotNull(TypeSpecifier_51_Var
		);
		Assert.assertEquals("int", TypeSpecifier_51_Var
		.getName());
		//51
		final Declarator Declarator_52_Var
		 = (Declarator)FunctionDefHead_49_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_52_Var
		);
		//52
		final DirectDeclarator DirectDeclarator_53_Var
		 = (DirectDeclarator)Declarator_52_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_53_Var
		);
		Assert.assertEquals("main", DirectDeclarator_53_Var
		.getIdent());
		final EList<? extends EObject> DeclaratorSuffix_53_list = DirectDeclarator_53_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_53_list);
		Assert.assertEquals(1, DeclaratorSuffix_53_list.size());
		//53
		final DeclaratorSuffix DeclaratorSuffix_54_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_53_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_54_Var
		);
		//54
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_55_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_54_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_55_Var
		);
		final EList<? extends EObject> ParameterTypeList_55_list = DirectDeclaratorLastSuffix_55_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_55_list);
		Assert.assertEquals(1, ParameterTypeList_55_list.size());
		//55
		final ParameterTypeList ParameterTypeList_56_Var
		 = (ParameterTypeList)ParameterTypeList_55_list.get(0);
		Assert.assertNotNull(ParameterTypeList_56_Var
		);
		//56
		final ParameterList ParameterList_57_Var
		 = (ParameterList)ParameterTypeList_56_Var
		.getList();
		Assert.assertNotNull(ParameterList_57_Var
		);
		final EList<? extends EObject> ParameterDeclaration_57_list = ParameterList_57_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_57_list);
		Assert.assertEquals(1, ParameterDeclaration_57_list.size());
		//57
		final ParameterDeclaration ParameterDeclaration_58_Var
		 = (ParameterDeclaration)ParameterDeclaration_57_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_58_Var
		);
		//58
		final DeclarationSpecifiers DeclarationSpecifiers_59_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_58_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_59_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_59_list = DeclarationSpecifiers_59_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_59_list);
		Assert.assertEquals(1, DeclarationSpecifier_59_list.size());
		//59
		final TypeSpecifier TypeSpecifier_60_Var
		 = (TypeSpecifier)DeclarationSpecifier_59_list.get(0);
		Assert.assertNotNull(TypeSpecifier_60_Var
		);
		Assert.assertEquals("void", TypeSpecifier_60_Var
		.getName());
		//60
		final FunctionDefinition FunctionDefinition_61_Var
		 = (FunctionDefinition)ExternalDeclaration_48_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_61_Var
		);
		//61
		final BodyStatement BodyStatement_62_Var
		 = (BodyStatement)FunctionDefinition_61_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_62_Var
		);
		final EList<? extends EObject> BlockList_62_list = BodyStatement_62_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_62_list);
		Assert.assertEquals(1, BlockList_62_list.size());
		//62
		final BlockList BlockList_63_Var
		 = (BlockList)BlockList_62_list.get(0);
		Assert.assertNotNull(BlockList_63_Var
		);
		final EList<? extends EObject> Statement_63_list = BlockList_63_Var
		.getStatement();
		Assert.assertNotNull(Statement_63_list);
		Assert.assertEquals(10, Statement_63_list.size());
		//63
		final Statement Statement_64_Var
		 = (Statement)Statement_63_list.get(0);
		Assert.assertNotNull(Statement_64_Var
		);
		//64
		final ExpressionStatement ExpressionStatement_65_Var
		 = (ExpressionStatement)Statement_64_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_65_Var
		);
		//65
		final PostfixExpression PostfixExpression_66_Var
		 = (PostfixExpression)ExpressionStatement_65_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_66_Var
		);
		//66
		final PrimaryExpression PrimaryExpression_67_Var
		 = (PrimaryExpression)PostfixExpression_66_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_67_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_67_Var
		.getIdent());
		//67
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_68_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_66_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_68_Var
		);
		//68
		final ArgumentExpressionList ArgumentExpressionList_69_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_68_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_69_Var
		);
		final EList<? extends EObject> Expr_69_list = ArgumentExpressionList_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(2, Expr_69_list.size());
		//69
		final PrimaryExpression PrimaryExpression_70_Var
		 = (PrimaryExpression)Expr_69_list.get(0);
		Assert.assertNotNull(PrimaryExpression_70_Var
		);
		Assert.assertEquals("[\"sizeof(joe.ident)=%lu\\n\"]", PrimaryExpression_70_Var
		.getString().toString());
		//70
		final UnaryExpression UnaryExpression_71_Var
		 = (UnaryExpression)Expr_69_list.get(1);
		Assert.assertNotNull(UnaryExpression_71_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_71_Var
		.getSizeOf());
		//71
		final PrimaryExpression PrimaryExpression_72_Var
		 = (PrimaryExpression)UnaryExpression_71_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_72_Var
		);
		Assert.assertTrue(PrimaryExpression_72_Var
		.isParentheses());
		//72
		final PostfixExpression PostfixExpression_73_Var
		 = (PostfixExpression)PrimaryExpression_72_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_73_Var
		);
		//73
		final PrimaryExpression PrimaryExpression_74_Var
		 = (PrimaryExpression)PostfixExpression_73_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_74_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_74_Var
		.getIdent());
		//74
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_75_Var
		 = (PostfixExpressionSuffixDot)PostfixExpression_73_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixDot_75_Var
		);
		Assert.assertEquals("ident", PostfixExpressionSuffixDot_75_Var
		.getIdent());
		//75
		final Statement Statement_76_Var
		 = (Statement)Statement_63_list.get(1);
		Assert.assertNotNull(Statement_76_Var
		);
		//76
		final ExpressionStatement ExpressionStatement_77_Var
		 = (ExpressionStatement)Statement_76_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_77_Var
		);
		//77
		final PostfixExpression PostfixExpression_78_Var
		 = (PostfixExpression)ExpressionStatement_77_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_78_Var
		);
		//78
		final PrimaryExpression PrimaryExpression_79_Var
		 = (PrimaryExpression)PostfixExpression_78_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_79_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_79_Var
		.getIdent());
		//79
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_80_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_78_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_80_Var
		);
		//80
		final ArgumentExpressionList ArgumentExpressionList_81_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_80_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_81_Var
		);
		final EList<? extends EObject> Expr_81_list = ArgumentExpressionList_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(2, Expr_81_list.size());
		//81
		final PrimaryExpression PrimaryExpression_82_Var
		 = (PrimaryExpression)Expr_81_list.get(0);
		Assert.assertNotNull(PrimaryExpression_82_Var
		);
		Assert.assertEquals("[\"sizeof(joe.name)=%lu\\n\"]", PrimaryExpression_82_Var
		.getString().toString());
		//82
		final UnaryExpression UnaryExpression_83_Var
		 = (UnaryExpression)Expr_81_list.get(1);
		Assert.assertNotNull(UnaryExpression_83_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_83_Var
		.getSizeOf());
		//83
		final PrimaryExpression PrimaryExpression_84_Var
		 = (PrimaryExpression)UnaryExpression_83_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_84_Var
		);
		Assert.assertTrue(PrimaryExpression_84_Var
		.isParentheses());
		//84
		final PostfixExpression PostfixExpression_85_Var
		 = (PostfixExpression)PrimaryExpression_84_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_85_Var
		);
		//85
		final PrimaryExpression PrimaryExpression_86_Var
		 = (PrimaryExpression)PostfixExpression_85_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_86_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_86_Var
		.getIdent());
		//86
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_87_Var
		 = (PostfixExpressionSuffixDot)PostfixExpression_85_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixDot_87_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_87_Var
		.getIdent());
		//87
		final Statement Statement_88_Var
		 = (Statement)Statement_63_list.get(2);
		Assert.assertNotNull(Statement_88_Var
		);
		//88
		final ExpressionStatement ExpressionStatement_89_Var
		 = (ExpressionStatement)Statement_88_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_89_Var
		);
		//89
		final PostfixExpression PostfixExpression_90_Var
		 = (PostfixExpression)ExpressionStatement_89_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_90_Var
		);
		//90
		final PrimaryExpression PrimaryExpression_91_Var
		 = (PrimaryExpression)PostfixExpression_90_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_91_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_91_Var
		.getIdent());
		//91
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_92_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_90_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_92_Var
		);
		//92
		final ArgumentExpressionList ArgumentExpressionList_93_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_92_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_93_Var
		);
		final EList<? extends EObject> Expr_93_list = ArgumentExpressionList_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(2, Expr_93_list.size());
		//93
		final PrimaryExpression PrimaryExpression_94_Var
		 = (PrimaryExpression)Expr_93_list.get(0);
		Assert.assertNotNull(PrimaryExpression_94_Var
		);
		Assert.assertEquals("[\"sizeof(joe)=%lu\\n\"]", PrimaryExpression_94_Var
		.getString().toString());
		//94
		final UnaryExpression UnaryExpression_95_Var
		 = (UnaryExpression)Expr_93_list.get(1);
		Assert.assertNotNull(UnaryExpression_95_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_95_Var
		.getSizeOf());
		//95
		final PrimaryExpression PrimaryExpression_96_Var
		 = (PrimaryExpression)UnaryExpression_95_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_96_Var
		);
		Assert.assertTrue(PrimaryExpression_96_Var
		.isParentheses());
		//96
		final PrimaryExpression PrimaryExpression_97_Var
		 = (PrimaryExpression)PrimaryExpression_96_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_97_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_97_Var
		.getIdent());
		//97
		final Statement Statement_98_Var
		 = (Statement)Statement_63_list.get(3);
		Assert.assertNotNull(Statement_98_Var
		);
		//98
		final ExpressionStatement ExpressionStatement_99_Var
		 = (ExpressionStatement)Statement_98_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_99_Var
		);
		//99
		final AssignmentExpression AssignmentExpression_100_Var
		 = (AssignmentExpression)ExpressionStatement_99_Var
		.getExpression();
		Assert.assertNotNull(AssignmentExpression_100_Var
		);
		//100
		final PostfixExpression PostfixExpression_101_Var
		 = (PostfixExpression)AssignmentExpression_100_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_101_Var
		);
		//101
		final PrimaryExpression PrimaryExpression_102_Var
		 = (PrimaryExpression)PostfixExpression_101_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_102_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_102_Var
		.getIdent());
		//102
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_103_Var
		 = (PostfixExpressionSuffixDot)PostfixExpression_101_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixDot_103_Var
		);
		Assert.assertEquals("ident", PostfixExpressionSuffixDot_103_Var
		.getIdent());
		Assert.assertEquals("=", AssignmentExpression_100_Var
		.getOp());
		//103
		final PrimaryExpression PrimaryExpression_104_Var
		 = (PrimaryExpression)AssignmentExpression_100_Var
		.getAssignmentExpr();
		Assert.assertNotNull(PrimaryExpression_104_Var
		);
		//104
		final Constant2 Constant2_105_Var
		 = (Constant2)PrimaryExpression_104_Var
		.getConst();
		Assert.assertNotNull(Constant2_105_Var
		);
		Assert.assertEquals("0x008", Constant2_105_Var
		.getHex());
		//105
		final Statement Statement_106_Var
		 = (Statement)Statement_63_list.get(4);
		Assert.assertNotNull(Statement_106_Var
		);
		//106
		final ExpressionStatement ExpressionStatement_107_Var
		 = (ExpressionStatement)Statement_106_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_107_Var
		);
		//107
		final PostfixExpression PostfixExpression_108_Var
		 = (PostfixExpression)ExpressionStatement_107_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_108_Var
		);
		//108
		final PrimaryExpression PrimaryExpression_109_Var
		 = (PrimaryExpression)PostfixExpression_108_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_109_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_109_Var
		.getIdent());
		//109
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_110_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_108_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_110_Var
		);
		//110
		final ArgumentExpressionList ArgumentExpressionList_111_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_110_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_111_Var
		);
		final EList<? extends EObject> Expr_111_list = ArgumentExpressionList_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(2, Expr_111_list.size());
		//111
		final PostfixExpression PostfixExpression_112_Var
		 = (PostfixExpression)Expr_111_list.get(0);
		Assert.assertNotNull(PostfixExpression_112_Var
		);
		//112
		final PrimaryExpression PrimaryExpression_113_Var
		 = (PrimaryExpression)PostfixExpression_112_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_113_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_113_Var
		.getIdent());
		//113
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_114_Var
		 = (PostfixExpressionSuffixDot)PostfixExpression_112_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixDot_114_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_114_Var
		.getIdent());
		//114
		final PrimaryExpression PrimaryExpression_115_Var
		 = (PrimaryExpression)Expr_111_list.get(1);
		Assert.assertNotNull(PrimaryExpression_115_Var
		);
		Assert.assertEquals("[\"Phil Morrison\"]", PrimaryExpression_115_Var
		.getString().toString());
		//115
		final Statement Statement_116_Var
		 = (Statement)Statement_63_list.get(5);
		Assert.assertNotNull(Statement_116_Var
		);
		//116
		final ExpressionStatement ExpressionStatement_117_Var
		 = (ExpressionStatement)Statement_116_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_117_Var
		);
		//117
		final PostfixExpression PostfixExpression_118_Var
		 = (PostfixExpression)ExpressionStatement_117_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_118_Var
		);
		//118
		final PrimaryExpression PrimaryExpression_119_Var
		 = (PrimaryExpression)PostfixExpression_118_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_119_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_119_Var
		.getIdent());
		//119
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_120_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_118_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_120_Var
		);
		//120
		final ArgumentExpressionList ArgumentExpressionList_121_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_120_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_121_Var
		);
		final EList<? extends EObject> Expr_121_list = ArgumentExpressionList_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(2, Expr_121_list.size());
		//121
		final PrimaryExpression PrimaryExpression_122_Var
		 = (PrimaryExpression)Expr_121_list.get(0);
		Assert.assertNotNull(PrimaryExpression_122_Var
		);
		Assert.assertEquals("[\"joe.ident=%d\\n\"]", PrimaryExpression_122_Var
		.getString().toString());
		//122
		final PostfixExpression PostfixExpression_123_Var
		 = (PostfixExpression)Expr_121_list.get(1);
		Assert.assertNotNull(PostfixExpression_123_Var
		);
		//123
		final PrimaryExpression PrimaryExpression_124_Var
		 = (PrimaryExpression)PostfixExpression_123_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_124_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_124_Var
		.getIdent());
		//124
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_125_Var
		 = (PostfixExpressionSuffixDot)PostfixExpression_123_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixDot_125_Var
		);
		Assert.assertEquals("ident", PostfixExpressionSuffixDot_125_Var
		.getIdent());
		//125
		final Statement Statement_126_Var
		 = (Statement)Statement_63_list.get(6);
		Assert.assertNotNull(Statement_126_Var
		);
		//126
		final ExpressionStatement ExpressionStatement_127_Var
		 = (ExpressionStatement)Statement_126_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_127_Var
		);
		//127
		final PostfixExpression PostfixExpression_128_Var
		 = (PostfixExpression)ExpressionStatement_127_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_128_Var
		);
		//128
		final PrimaryExpression PrimaryExpression_129_Var
		 = (PrimaryExpression)PostfixExpression_128_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_129_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_129_Var
		.getIdent());
		//129
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_130_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_128_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_130_Var
		);
		//130
		final ArgumentExpressionList ArgumentExpressionList_131_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_130_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_131_Var
		);
		final EList<? extends EObject> Expr_131_list = ArgumentExpressionList_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(2, Expr_131_list.size());
		//131
		final PrimaryExpression PrimaryExpression_132_Var
		 = (PrimaryExpression)Expr_131_list.get(0);
		Assert.assertNotNull(PrimaryExpression_132_Var
		);
		Assert.assertEquals("[\"joe.name=%s\\n\"]", PrimaryExpression_132_Var
		.getString().toString());
		//132
		final PostfixExpression PostfixExpression_133_Var
		 = (PostfixExpression)Expr_131_list.get(1);
		Assert.assertNotNull(PostfixExpression_133_Var
		);
		//133
		final PrimaryExpression PrimaryExpression_134_Var
		 = (PrimaryExpression)PostfixExpression_133_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_134_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_134_Var
		.getIdent());
		//134
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_135_Var
		 = (PostfixExpressionSuffixDot)PostfixExpression_133_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixDot_135_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_135_Var
		.getIdent());
		//135
		final Statement Statement_136_Var
		 = (Statement)Statement_63_list.get(7);
		Assert.assertNotNull(Statement_136_Var
		);
		//136
		final ExpressionStatement ExpressionStatement_137_Var
		 = (ExpressionStatement)Statement_136_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_137_Var
		);
		//137
		final PostfixExpression PostfixExpression_138_Var
		 = (PostfixExpression)ExpressionStatement_137_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_138_Var
		);
		//138
		final PrimaryExpression PrimaryExpression_139_Var
		 = (PrimaryExpression)PostfixExpression_138_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_139_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_139_Var
		.getIdent());
		//139
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_140_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_138_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_140_Var
		);
		//140
		final ArgumentExpressionList ArgumentExpressionList_141_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_140_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_141_Var
		);
		final EList<? extends EObject> Expr_141_list = ArgumentExpressionList_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(2, Expr_141_list.size());
		//141
		final PrimaryExpression PrimaryExpression_142_Var
		 = (PrimaryExpression)Expr_141_list.get(0);
		Assert.assertNotNull(PrimaryExpression_142_Var
		);
		Assert.assertEquals("[\"phil.ident=%d\\n\"]", PrimaryExpression_142_Var
		.getString().toString());
		//142
		final PostfixExpression PostfixExpression_143_Var
		 = (PostfixExpression)Expr_141_list.get(1);
		Assert.assertNotNull(PostfixExpression_143_Var
		);
		//143
		final PrimaryExpression PrimaryExpression_144_Var
		 = (PrimaryExpression)PostfixExpression_143_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_144_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_144_Var
		.getIdent());
		//144
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_145_Var
		 = (PostfixExpressionSuffixDot)PostfixExpression_143_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixDot_145_Var
		);
		Assert.assertEquals("ident", PostfixExpressionSuffixDot_145_Var
		.getIdent());
		//145
		final Statement Statement_146_Var
		 = (Statement)Statement_63_list.get(8);
		Assert.assertNotNull(Statement_146_Var
		);
		//146
		final ExpressionStatement ExpressionStatement_147_Var
		 = (ExpressionStatement)Statement_146_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_147_Var
		);
		//147
		final PostfixExpression PostfixExpression_148_Var
		 = (PostfixExpression)ExpressionStatement_147_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_148_Var
		);
		//148
		final PrimaryExpression PrimaryExpression_149_Var
		 = (PrimaryExpression)PostfixExpression_148_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_149_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_149_Var
		.getIdent());
		//149
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_150_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_148_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_150_Var
		);
		//150
		final ArgumentExpressionList ArgumentExpressionList_151_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_150_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_151_Var
		);
		final EList<? extends EObject> Expr_151_list = ArgumentExpressionList_151_Var
		.getExpr();
		Assert.assertNotNull(Expr_151_list);
		Assert.assertEquals(2, Expr_151_list.size());
		//151
		final PrimaryExpression PrimaryExpression_152_Var
		 = (PrimaryExpression)Expr_151_list.get(0);
		Assert.assertNotNull(PrimaryExpression_152_Var
		);
		Assert.assertEquals("[\"phil.name=%s\\n\"]", PrimaryExpression_152_Var
		.getString().toString());
		//152
		final PostfixExpression PostfixExpression_153_Var
		 = (PostfixExpression)Expr_151_list.get(1);
		Assert.assertNotNull(PostfixExpression_153_Var
		);
		//153
		final PrimaryExpression PrimaryExpression_154_Var
		 = (PrimaryExpression)PostfixExpression_153_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_154_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_154_Var
		.getIdent());
		//154
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_155_Var
		 = (PostfixExpressionSuffixDot)PostfixExpression_153_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixDot_155_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_155_Var
		.getIdent());
		//155
		final Statement Statement_156_Var
		 = (Statement)Statement_63_list.get(9);
		Assert.assertNotNull(Statement_156_Var
		);
		//156
		final JumpStatement JumpStatement_157_Var
		 = (JumpStatement)Statement_156_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_157_Var
		);
		//157
		final PrimaryExpression PrimaryExpression_158_Var
		 = (PrimaryExpression)JumpStatement_157_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_158_Var
		);
		//158
		final Constant2 Constant2_159_Var
		 = (Constant2)PrimaryExpression_158_Var
		.getConst();
		Assert.assertNotNull(Constant2_159_Var
		);
		Assert.assertEquals("0", Constant2_159_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_157_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0037_Struct.c");
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
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0037_Struct.c");
		final String expected = this.getTextFromFile(
			"res/Test0037_Struct.c"
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


