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
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
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
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
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
public class Test0034_Union {
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
			"res/Test0034_Union.c");
			final String[] expected = new String[] {
				"RULE_LINEDIRECTIVE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_UNION",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_CHAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_FLOAT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_UNION",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_ID",
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
				"RULE_KW_UNSIGNED",
				"RULE_WHITESPACE",
				"RULE_KW_LONG",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_UNSIGNED",
				"RULE_WHITESPACE",
				"RULE_KW_LONG",
				"RULE_SKW_RIGHTPAREN",
				"RULE_KW_SIZEOF",
				"RULE_SKW_LEFTPAREN",
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
				"RULE_KW_FLOAT",
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
				"RULE_DECIMAL_LITERAL",
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
				"RULE_SKW_DOT",
				"RULE_ID",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_FLOAT_LITERAL",
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
			"res/Test0034_Union.c");
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
		Assert.assertEquals("union", StructOrUnion_6_Var
		.getName());
		Assert.assertEquals("num", StructOrUnionSpecifier_5_Var
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
		Assert.assertEquals("char", TypeSpecifier_10_Var
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
		Assert.assertEquals("numChar", DirectDeclarator_14_Var
		.getId());
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
		Assert.assertEquals("float", TypeSpecifier_17_Var
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
		Assert.assertEquals("numFloat", DirectDeclarator_21_Var
		.getId());
		//21
		final ExternalDeclaration ExternalDeclaration_22_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_22_Var
		);
		//22
		final Declaration Declaration_23_Var
		 = (Declaration)ExternalDeclaration_22_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_23_Var
		);
		//23
		final DeclarationSpecifiers DeclarationSpecifiers_24_Var
		 = (DeclarationSpecifiers)Declaration_23_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_24_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_24_list = DeclarationSpecifiers_24_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_24_list);
		Assert.assertEquals(1, DeclarationSpecifier_24_list.size());
		//24
		final TypeSpecifier TypeSpecifier_25_Var
		 = (TypeSpecifier)DeclarationSpecifier_24_list.get(0);
		Assert.assertNotNull(TypeSpecifier_25_Var
		);
		//25
		final StructOrUnionSpecifier StructOrUnionSpecifier_26_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_25_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_26_Var
		);
		//26
		final StructOrUnion StructOrUnion_27_Var
		 = (StructOrUnion)StructOrUnionSpecifier_26_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_27_Var
		);
		Assert.assertEquals("union", StructOrUnion_27_Var
		.getName());
		Assert.assertEquals("num", StructOrUnionSpecifier_26_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_27_list = Declaration_23_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_27_list);
		Assert.assertEquals(1, InitDeclaratorList_27_list.size());
		//27
		final InitDeclaratorList InitDeclaratorList_28_Var
		 = (InitDeclaratorList)InitDeclaratorList_27_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_28_Var
		);
		final EList<? extends EObject> InitDeclarator_28_list = InitDeclaratorList_28_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_28_list);
		Assert.assertEquals(1, InitDeclarator_28_list.size());
		//28
		final InitDeclarator InitDeclarator_29_Var
		 = (InitDeclarator)InitDeclarator_28_list.get(0);
		Assert.assertNotNull(InitDeclarator_29_Var
		);
		//29
		final Declarator Declarator_30_Var
		 = (Declarator)InitDeclarator_29_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_30_Var
		);
		//30
		final DirectDeclarator DirectDeclarator_31_Var
		 = (DirectDeclarator)Declarator_30_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_31_Var
		);
		Assert.assertEquals("number", DirectDeclarator_31_Var
		.getId());
		//31
		final ExternalDeclaration ExternalDeclaration_32_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_32_Var
		);
		//32
		final FunctionDefHead FunctionDefHead_33_Var
		 = (FunctionDefHead)ExternalDeclaration_32_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_33_Var
		);
		//33
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_34_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_33_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_34_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_34_list = FunctionDeclarationSpecifiers_34_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_34_list);
		Assert.assertEquals(1, DeclarationSpecifier_34_list.size());
		//34
		final TypeSpecifier TypeSpecifier_35_Var
		 = (TypeSpecifier)DeclarationSpecifier_34_list.get(0);
		Assert.assertNotNull(TypeSpecifier_35_Var
		);
		Assert.assertEquals("int", TypeSpecifier_35_Var
		.getName());
		//35
		final Declarator Declarator_36_Var
		 = (Declarator)FunctionDefHead_33_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_36_Var
		);
		//36
		final DirectDeclarator DirectDeclarator_37_Var
		 = (DirectDeclarator)Declarator_36_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_37_Var
		);
		Assert.assertEquals("main", DirectDeclarator_37_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_37_list = DirectDeclarator_37_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_37_list);
		Assert.assertEquals(1, DeclaratorSuffix_37_list.size());
		//37
		final DeclaratorSuffix DeclaratorSuffix_38_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_37_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_38_Var
		);
		//38
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_39_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_38_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_39_Var
		);
		final EList<? extends EObject> ParameterTypeList_39_list = DirectDeclaratorLastSuffix_39_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_39_list);
		Assert.assertEquals(1, ParameterTypeList_39_list.size());
		//39
		final ParameterTypeList ParameterTypeList_40_Var
		 = (ParameterTypeList)ParameterTypeList_39_list.get(0);
		Assert.assertNotNull(ParameterTypeList_40_Var
		);
		//40
		final ParameterList ParameterList_41_Var
		 = (ParameterList)ParameterTypeList_40_Var
		.getList();
		Assert.assertNotNull(ParameterList_41_Var
		);
		final EList<? extends EObject> ParameterDeclaration_41_list = ParameterList_41_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_41_list);
		Assert.assertEquals(1, ParameterDeclaration_41_list.size());
		//41
		final ParameterDeclaration ParameterDeclaration_42_Var
		 = (ParameterDeclaration)ParameterDeclaration_41_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_42_Var
		);
		//42
		final DeclarationSpecifiers DeclarationSpecifiers_43_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_42_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_43_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_43_list = DeclarationSpecifiers_43_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_43_list);
		Assert.assertEquals(1, DeclarationSpecifier_43_list.size());
		//43
		final TypeSpecifier TypeSpecifier_44_Var
		 = (TypeSpecifier)DeclarationSpecifier_43_list.get(0);
		Assert.assertNotNull(TypeSpecifier_44_Var
		);
		Assert.assertEquals("void", TypeSpecifier_44_Var
		.getName());
		//44
		final FunctionDefinition FunctionDefinition_45_Var
		 = (FunctionDefinition)ExternalDeclaration_32_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_45_Var
		);
		//45
		final BodyStatement BodyStatement_46_Var
		 = (BodyStatement)FunctionDefinition_45_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_46_Var
		);
		final EList<? extends EObject> BlockList_46_list = BodyStatement_46_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_46_list);
		Assert.assertEquals(1, BlockList_46_list.size());
		//46
		final BlockList BlockList_47_Var
		 = (BlockList)BlockList_46_list.get(0);
		Assert.assertNotNull(BlockList_47_Var
		);
		final EList<? extends EObject> Declaration_47_list = BlockList_47_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_47_list);
		Assert.assertEquals(1, Declaration_47_list.size());
		//47
		final Declaration Declaration_48_Var
		 = (Declaration)Declaration_47_list.get(0);
		Assert.assertNotNull(Declaration_48_Var
		);
		//48
		final DeclarationSpecifiers DeclarationSpecifiers_49_Var
		 = (DeclarationSpecifiers)Declaration_48_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_49_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_49_list = DeclarationSpecifiers_49_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_49_list);
		Assert.assertEquals(2, DeclarationSpecifier_49_list.size());
		//49
		final TypeSpecifier TypeSpecifier_50_Var
		 = (TypeSpecifier)DeclarationSpecifier_49_list.get(0);
		Assert.assertNotNull(TypeSpecifier_50_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_50_Var
		.getName());
		//50
		final TypeSpecifier TypeSpecifier_51_Var
		 = (TypeSpecifier)DeclarationSpecifier_49_list.get(1);
		Assert.assertNotNull(TypeSpecifier_51_Var
		);
		Assert.assertEquals("long", TypeSpecifier_51_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_51_list = Declaration_48_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_51_list);
		Assert.assertEquals(1, InitDeclaratorList_51_list.size());
		//51
		final InitDeclaratorList InitDeclaratorList_52_Var
		 = (InitDeclaratorList)InitDeclaratorList_51_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_52_Var
		);
		final EList<? extends EObject> InitDeclarator_52_list = InitDeclaratorList_52_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_52_list);
		Assert.assertEquals(1, InitDeclarator_52_list.size());
		//52
		final InitDeclarator InitDeclarator_53_Var
		 = (InitDeclarator)InitDeclarator_52_list.get(0);
		Assert.assertNotNull(InitDeclarator_53_Var
		);
		//53
		final Declarator Declarator_54_Var
		 = (Declarator)InitDeclarator_53_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_54_Var
		);
		//54
		final DirectDeclarator DirectDeclarator_55_Var
		 = (DirectDeclarator)Declarator_54_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_55_Var
		);
		Assert.assertEquals("size", DirectDeclarator_55_Var
		.getId());
		//55
		final Initializer Initializer_56_Var
		 = (Initializer)InitDeclarator_53_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_56_Var
		);
		//56
		final CastExpression CastExpression_57_Var
		 = (CastExpression)Initializer_56_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_57_Var
		);
		//57
		final TypeName TypeName_58_Var
		 = (TypeName)CastExpression_57_Var
		.getType();
		Assert.assertNotNull(TypeName_58_Var
		);
		//58
		final SpecifierQualifierList SpecifierQualifierList_59_Var
		 = (SpecifierQualifierList)TypeName_58_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_59_Var
		);
		final EList<? extends EObject> TypeSpecifier_59_list = SpecifierQualifierList_59_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_59_list);
		Assert.assertEquals(2, TypeSpecifier_59_list.size());
		//59
		final TypeSpecifier TypeSpecifier_60_Var
		 = (TypeSpecifier)TypeSpecifier_59_list.get(0);
		Assert.assertNotNull(TypeSpecifier_60_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_60_Var
		.getName());
		//60
		final TypeSpecifier TypeSpecifier_61_Var
		 = (TypeSpecifier)TypeSpecifier_59_list.get(1);
		Assert.assertNotNull(TypeSpecifier_61_Var
		);
		Assert.assertEquals("long", TypeSpecifier_61_Var
		.getName());
		//61
		final UnaryExpression UnaryExpression_62_Var
		 = (UnaryExpression)CastExpression_57_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_62_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_62_Var
		.getSizeOf());
		//62
		final PrimaryExpression PrimaryExpression_63_Var
		 = (PrimaryExpression)UnaryExpression_62_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_63_Var
		);
		//63
		final PrimaryExpression PrimaryExpression_64_Var
		 = (PrimaryExpression)PrimaryExpression_63_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_64_Var
		);
		Assert.assertEquals("number", PrimaryExpression_64_Var
		.getId());
		final EList<? extends EObject> Statement_64_list = BlockList_47_Var
		.getStatement();
		Assert.assertNotNull(Statement_64_list);
		Assert.assertEquals(11, Statement_64_list.size());
		//64
		final Statement Statement_65_Var
		 = (Statement)Statement_64_list.get(0);
		Assert.assertNotNull(Statement_65_Var
		);
		//65
		final ExpressionStatement ExpressionStatement_66_Var
		 = (ExpressionStatement)Statement_65_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_66_Var
		);
		//66
		final PostfixExpression PostfixExpression_67_Var
		 = (PostfixExpression)ExpressionStatement_66_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_67_Var
		);
		//67
		final PrimaryExpression PrimaryExpression_68_Var
		 = (PrimaryExpression)PostfixExpression_67_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_68_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_68_Var
		.getId());
		//68
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_69_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_67_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_69_Var
		);
		//69
		final ArgumentExpressionList ArgumentExpressionList_70_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_69_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_70_Var
		);
		final EList<? extends EObject> Expr_70_list = ArgumentExpressionList_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(2, Expr_70_list.size());
		//70
		final PrimaryExpression PrimaryExpression_71_Var
		 = (PrimaryExpression)Expr_70_list.get(0);
		Assert.assertNotNull(PrimaryExpression_71_Var
		);
		Assert.assertEquals("[\"sizeof(number)=%lu\\n\"]", PrimaryExpression_71_Var
		.getString().toString());
		//71
		final PrimaryExpression PrimaryExpression_72_Var
		 = (PrimaryExpression)Expr_70_list.get(1);
		Assert.assertNotNull(PrimaryExpression_72_Var
		);
		Assert.assertEquals("size", PrimaryExpression_72_Var
		.getId());
		//72
		final Statement Statement_73_Var
		 = (Statement)Statement_64_list.get(1);
		Assert.assertNotNull(Statement_73_Var
		);
		//73
		final ExpressionStatement ExpressionStatement_74_Var
		 = (ExpressionStatement)Statement_73_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_74_Var
		);
		//74
		final PostfixExpression PostfixExpression_75_Var
		 = (PostfixExpression)ExpressionStatement_74_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_75_Var
		);
		//75
		final PrimaryExpression PrimaryExpression_76_Var
		 = (PrimaryExpression)PostfixExpression_75_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_76_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_76_Var
		.getId());
		//76
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_77_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_75_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_77_Var
		);
		//77
		final ArgumentExpressionList ArgumentExpressionList_78_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_77_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_78_Var
		);
		final EList<? extends EObject> Expr_78_list = ArgumentExpressionList_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(2, Expr_78_list.size());
		//78
		final PrimaryExpression PrimaryExpression_79_Var
		 = (PrimaryExpression)Expr_78_list.get(0);
		Assert.assertNotNull(PrimaryExpression_79_Var
		);
		Assert.assertEquals("[\"sizeof(number.numChar)=%lu\\n\"]", PrimaryExpression_79_Var
		.getString().toString());
		//79
		final UnaryExpression UnaryExpression_80_Var
		 = (UnaryExpression)Expr_78_list.get(1);
		Assert.assertNotNull(UnaryExpression_80_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_80_Var
		.getSizeOf());
		//80
		final PrimaryExpression PrimaryExpression_81_Var
		 = (PrimaryExpression)UnaryExpression_80_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_81_Var
		);
		Assert.assertTrue(PrimaryExpression_81_Var
		.isParentheses());
		//81
		final PostfixExpression PostfixExpression_82_Var
		 = (PostfixExpression)PrimaryExpression_81_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_82_Var
		);
		//82
		final PrimaryExpression PrimaryExpression_83_Var
		 = (PrimaryExpression)PostfixExpression_82_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_83_Var
		);
		Assert.assertEquals("number", PrimaryExpression_83_Var
		.getId());
		//83
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_84_Var
		 = (PostfixExpressionSuffixDot)PostfixExpression_82_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixDot_84_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_84_Var
		.getId());
		//84
		final Statement Statement_85_Var
		 = (Statement)Statement_64_list.get(2);
		Assert.assertNotNull(Statement_85_Var
		);
		//85
		final ExpressionStatement ExpressionStatement_86_Var
		 = (ExpressionStatement)Statement_85_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_86_Var
		);
		//86
		final PostfixExpression PostfixExpression_87_Var
		 = (PostfixExpression)ExpressionStatement_86_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_87_Var
		);
		//87
		final PrimaryExpression PrimaryExpression_88_Var
		 = (PrimaryExpression)PostfixExpression_87_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_88_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_88_Var
		.getId());
		//88
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_89_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_87_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_89_Var
		);
		//89
		final ArgumentExpressionList ArgumentExpressionList_90_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_89_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_90_Var
		);
		final EList<? extends EObject> Expr_90_list = ArgumentExpressionList_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(2, Expr_90_list.size());
		//90
		final PrimaryExpression PrimaryExpression_91_Var
		 = (PrimaryExpression)Expr_90_list.get(0);
		Assert.assertNotNull(PrimaryExpression_91_Var
		);
		Assert.assertEquals("[\"sizeof(float)=%lu\\n\"]", PrimaryExpression_91_Var
		.getString().toString());
		//91
		final UnaryExpression UnaryExpression_92_Var
		 = (UnaryExpression)Expr_90_list.get(1);
		Assert.assertNotNull(UnaryExpression_92_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_92_Var
		.getSizeOf());
		//92
		final TypeName TypeName_93_Var
		 = (TypeName)UnaryExpression_92_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_93_Var
		);
		//93
		final SpecifierQualifierList SpecifierQualifierList_94_Var
		 = (SpecifierQualifierList)TypeName_93_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_94_Var
		);
		final EList<? extends EObject> TypeSpecifier_94_list = SpecifierQualifierList_94_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_94_list);
		Assert.assertEquals(1, TypeSpecifier_94_list.size());
		//94
		final TypeSpecifier TypeSpecifier_95_Var
		 = (TypeSpecifier)TypeSpecifier_94_list.get(0);
		Assert.assertNotNull(TypeSpecifier_95_Var
		);
		Assert.assertEquals("float", TypeSpecifier_95_Var
		.getName());
		//95
		final Statement Statement_96_Var
		 = (Statement)Statement_64_list.get(3);
		Assert.assertNotNull(Statement_96_Var
		);
		//96
		final ExpressionStatement ExpressionStatement_97_Var
		 = (ExpressionStatement)Statement_96_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_97_Var
		);
		//97
		final AssignmentExpression AssignmentExpression_98_Var
		 = (AssignmentExpression)ExpressionStatement_97_Var
		.getExpression();
		Assert.assertNotNull(AssignmentExpression_98_Var
		);
		//98
		final PostfixExpression PostfixExpression_99_Var
		 = (PostfixExpression)AssignmentExpression_98_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_99_Var
		);
		//99
		final PrimaryExpression PrimaryExpression_100_Var
		 = (PrimaryExpression)PostfixExpression_99_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_100_Var
		);
		Assert.assertEquals("number", PrimaryExpression_100_Var
		.getId());
		//100
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_101_Var
		 = (PostfixExpressionSuffixDot)PostfixExpression_99_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixDot_101_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_101_Var
		.getId());
		Assert.assertEquals("=", AssignmentExpression_98_Var
		.getOp());
		//101
		final PrimaryExpression PrimaryExpression_102_Var
		 = (PrimaryExpression)AssignmentExpression_98_Var
		.getAssignmentExpr();
		Assert.assertNotNull(PrimaryExpression_102_Var
		);
		//102
		final Constant2 Constant2_103_Var
		 = (Constant2)PrimaryExpression_102_Var
		.getConst();
		Assert.assertNotNull(Constant2_103_Var
		);
		Assert.assertEquals("65", Constant2_103_Var
		.getDec());
		//103
		final Statement Statement_104_Var
		 = (Statement)Statement_64_list.get(4);
		Assert.assertNotNull(Statement_104_Var
		);
		//104
		final ExpressionStatement ExpressionStatement_105_Var
		 = (ExpressionStatement)Statement_104_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_105_Var
		);
		//105
		final PostfixExpression PostfixExpression_106_Var
		 = (PostfixExpression)ExpressionStatement_105_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_106_Var
		);
		//106
		final PrimaryExpression PrimaryExpression_107_Var
		 = (PrimaryExpression)PostfixExpression_106_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_107_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_107_Var
		.getId());
		//107
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_108_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_106_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_108_Var
		);
		//108
		final ArgumentExpressionList ArgumentExpressionList_109_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_108_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_109_Var
		);
		final EList<? extends EObject> Expr_109_list = ArgumentExpressionList_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(2, Expr_109_list.size());
		//109
		final PrimaryExpression PrimaryExpression_110_Var
		 = (PrimaryExpression)Expr_109_list.get(0);
		Assert.assertNotNull(PrimaryExpression_110_Var
		);
		Assert.assertEquals("[\"number.numChar(as decimal)=%d\\n\"]", PrimaryExpression_110_Var
		.getString().toString());
		//110
		final PostfixExpression PostfixExpression_111_Var
		 = (PostfixExpression)Expr_109_list.get(1);
		Assert.assertNotNull(PostfixExpression_111_Var
		);
		//111
		final PrimaryExpression PrimaryExpression_112_Var
		 = (PrimaryExpression)PostfixExpression_111_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_112_Var
		);
		Assert.assertEquals("number", PrimaryExpression_112_Var
		.getId());
		//112
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_113_Var
		 = (PostfixExpressionSuffixDot)PostfixExpression_111_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixDot_113_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_113_Var
		.getId());
		//113
		final Statement Statement_114_Var
		 = (Statement)Statement_64_list.get(5);
		Assert.assertNotNull(Statement_114_Var
		);
		//114
		final ExpressionStatement ExpressionStatement_115_Var
		 = (ExpressionStatement)Statement_114_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_115_Var
		);
		//115
		final PostfixExpression PostfixExpression_116_Var
		 = (PostfixExpression)ExpressionStatement_115_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_116_Var
		);
		//116
		final PrimaryExpression PrimaryExpression_117_Var
		 = (PrimaryExpression)PostfixExpression_116_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_117_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_117_Var
		.getId());
		//117
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_118_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_116_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_118_Var
		);
		//118
		final ArgumentExpressionList ArgumentExpressionList_119_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_118_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_119_Var
		);
		final EList<? extends EObject> Expr_119_list = ArgumentExpressionList_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(2, Expr_119_list.size());
		//119
		final PrimaryExpression PrimaryExpression_120_Var
		 = (PrimaryExpression)Expr_119_list.get(0);
		Assert.assertNotNull(PrimaryExpression_120_Var
		);
		Assert.assertEquals("[\"number.numChar(as char)=%c\\n\"]", PrimaryExpression_120_Var
		.getString().toString());
		//120
		final PostfixExpression PostfixExpression_121_Var
		 = (PostfixExpression)Expr_119_list.get(1);
		Assert.assertNotNull(PostfixExpression_121_Var
		);
		//121
		final PrimaryExpression PrimaryExpression_122_Var
		 = (PrimaryExpression)PostfixExpression_121_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_122_Var
		);
		Assert.assertEquals("number", PrimaryExpression_122_Var
		.getId());
		//122
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_123_Var
		 = (PostfixExpressionSuffixDot)PostfixExpression_121_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixDot_123_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_123_Var
		.getId());
		//123
		final Statement Statement_124_Var
		 = (Statement)Statement_64_list.get(6);
		Assert.assertNotNull(Statement_124_Var
		);
		//124
		final ExpressionStatement ExpressionStatement_125_Var
		 = (ExpressionStatement)Statement_124_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_125_Var
		);
		//125
		final PostfixExpression PostfixExpression_126_Var
		 = (PostfixExpression)ExpressionStatement_125_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_126_Var
		);
		//126
		final PrimaryExpression PrimaryExpression_127_Var
		 = (PrimaryExpression)PostfixExpression_126_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_127_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_127_Var
		.getId());
		//127
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_128_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_126_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_128_Var
		);
		//128
		final ArgumentExpressionList ArgumentExpressionList_129_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_128_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_129_Var
		);
		final EList<? extends EObject> Expr_129_list = ArgumentExpressionList_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(2, Expr_129_list.size());
		//129
		final PrimaryExpression PrimaryExpression_130_Var
		 = (PrimaryExpression)Expr_129_list.get(0);
		Assert.assertNotNull(PrimaryExpression_130_Var
		);
		Assert.assertEquals("[\"number.numFloat=%f\\n\"]", PrimaryExpression_130_Var
		.getString().toString());
		//130
		final PostfixExpression PostfixExpression_131_Var
		 = (PostfixExpression)Expr_129_list.get(1);
		Assert.assertNotNull(PostfixExpression_131_Var
		);
		//131
		final PrimaryExpression PrimaryExpression_132_Var
		 = (PrimaryExpression)PostfixExpression_131_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_132_Var
		);
		Assert.assertEquals("number", PrimaryExpression_132_Var
		.getId());
		//132
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_133_Var
		 = (PostfixExpressionSuffixDot)PostfixExpression_131_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixDot_133_Var
		);
		Assert.assertEquals("numFloat", PostfixExpressionSuffixDot_133_Var
		.getId());
		//133
		final Statement Statement_134_Var
		 = (Statement)Statement_64_list.get(7);
		Assert.assertNotNull(Statement_134_Var
		);
		//134
		final ExpressionStatement ExpressionStatement_135_Var
		 = (ExpressionStatement)Statement_134_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_135_Var
		);
		//135
		final AssignmentExpression AssignmentExpression_136_Var
		 = (AssignmentExpression)ExpressionStatement_135_Var
		.getExpression();
		Assert.assertNotNull(AssignmentExpression_136_Var
		);
		//136
		final PostfixExpression PostfixExpression_137_Var
		 = (PostfixExpression)AssignmentExpression_136_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_137_Var
		);
		//137
		final PrimaryExpression PrimaryExpression_138_Var
		 = (PrimaryExpression)PostfixExpression_137_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_138_Var
		);
		Assert.assertEquals("number", PrimaryExpression_138_Var
		.getId());
		//138
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_139_Var
		 = (PostfixExpressionSuffixDot)PostfixExpression_137_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixDot_139_Var
		);
		Assert.assertEquals("numFloat", PostfixExpressionSuffixDot_139_Var
		.getId());
		Assert.assertEquals("=", AssignmentExpression_136_Var
		.getOp());
		//139
		final PrimaryExpression PrimaryExpression_140_Var
		 = (PrimaryExpression)AssignmentExpression_136_Var
		.getAssignmentExpr();
		Assert.assertNotNull(PrimaryExpression_140_Var
		);
		//140
		final Constant2 Constant2_141_Var
		 = (Constant2)PrimaryExpression_140_Var
		.getConst();
		Assert.assertNotNull(Constant2_141_Var
		);
		Assert.assertEquals("0.56789", Constant2_141_Var
		.getFloat());
		//141
		final Statement Statement_142_Var
		 = (Statement)Statement_64_list.get(8);
		Assert.assertNotNull(Statement_142_Var
		);
		//142
		final ExpressionStatement ExpressionStatement_143_Var
		 = (ExpressionStatement)Statement_142_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_143_Var
		);
		//143
		final PostfixExpression PostfixExpression_144_Var
		 = (PostfixExpression)ExpressionStatement_143_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_144_Var
		);
		//144
		final PrimaryExpression PrimaryExpression_145_Var
		 = (PrimaryExpression)PostfixExpression_144_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_145_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_145_Var
		.getId());
		//145
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_146_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_144_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_146_Var
		);
		//146
		final ArgumentExpressionList ArgumentExpressionList_147_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_146_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_147_Var
		);
		final EList<? extends EObject> Expr_147_list = ArgumentExpressionList_147_Var
		.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(2, Expr_147_list.size());
		//147
		final PrimaryExpression PrimaryExpression_148_Var
		 = (PrimaryExpression)Expr_147_list.get(0);
		Assert.assertNotNull(PrimaryExpression_148_Var
		);
		Assert.assertEquals("[\"number.numChar(as decimal)=%d\\n\"]", PrimaryExpression_148_Var
		.getString().toString());
		//148
		final PostfixExpression PostfixExpression_149_Var
		 = (PostfixExpression)Expr_147_list.get(1);
		Assert.assertNotNull(PostfixExpression_149_Var
		);
		//149
		final PrimaryExpression PrimaryExpression_150_Var
		 = (PrimaryExpression)PostfixExpression_149_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_150_Var
		);
		Assert.assertEquals("number", PrimaryExpression_150_Var
		.getId());
		//150
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_151_Var
		 = (PostfixExpressionSuffixDot)PostfixExpression_149_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixDot_151_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_151_Var
		.getId());
		//151
		final Statement Statement_152_Var
		 = (Statement)Statement_64_list.get(9);
		Assert.assertNotNull(Statement_152_Var
		);
		//152
		final ExpressionStatement ExpressionStatement_153_Var
		 = (ExpressionStatement)Statement_152_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_153_Var
		);
		//153
		final PostfixExpression PostfixExpression_154_Var
		 = (PostfixExpression)ExpressionStatement_153_Var
		.getExpression();
		Assert.assertNotNull(PostfixExpression_154_Var
		);
		//154
		final PrimaryExpression PrimaryExpression_155_Var
		 = (PrimaryExpression)PostfixExpression_154_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_155_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_155_Var
		.getId());
		//155
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_156_Var
		 = (PostfixExpressionSuffixArgument)PostfixExpression_154_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixArgument_156_Var
		);
		//156
		final ArgumentExpressionList ArgumentExpressionList_157_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_156_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_157_Var
		);
		final EList<? extends EObject> Expr_157_list = ArgumentExpressionList_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(2, Expr_157_list.size());
		//157
		final PrimaryExpression PrimaryExpression_158_Var
		 = (PrimaryExpression)Expr_157_list.get(0);
		Assert.assertNotNull(PrimaryExpression_158_Var
		);
		Assert.assertEquals("[\"number.numFloat=%f\\n\"]", PrimaryExpression_158_Var
		.getString().toString());
		//158
		final PostfixExpression PostfixExpression_159_Var
		 = (PostfixExpression)Expr_157_list.get(1);
		Assert.assertNotNull(PostfixExpression_159_Var
		);
		//159
		final PrimaryExpression PrimaryExpression_160_Var
		 = (PrimaryExpression)PostfixExpression_159_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_160_Var
		);
		Assert.assertEquals("number", PrimaryExpression_160_Var
		.getId());
		//160
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_161_Var
		 = (PostfixExpressionSuffixDot)PostfixExpression_159_Var
		.getSuffix();
		Assert.assertNotNull(PostfixExpressionSuffixDot_161_Var
		);
		Assert.assertEquals("numFloat", PostfixExpressionSuffixDot_161_Var
		.getId());
		//161
		final Statement Statement_162_Var
		 = (Statement)Statement_64_list.get(10);
		Assert.assertNotNull(Statement_162_Var
		);
		//162
		final JumpStatement JumpStatement_163_Var
		 = (JumpStatement)Statement_162_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_163_Var
		);
		//163
		final PrimaryExpression PrimaryExpression_164_Var
		 = (PrimaryExpression)JumpStatement_163_Var
		.getExpr();
		Assert.assertNotNull(PrimaryExpression_164_Var
		);
		//164
		final Constant2 Constant2_165_Var
		 = (Constant2)PrimaryExpression_164_Var
		.getConst();
		Assert.assertNotNull(Constant2_165_Var
		);
		Assert.assertEquals("0", Constant2_165_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_163_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0034_Union.c");
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
				method.invoke(this.generator, "Test0034_Union.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0034_Union.c");
		final String expected = this.getTextFromFile(
			"res/Test0034_Union.c"
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


