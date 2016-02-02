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
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArray;
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
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.AssignmentOperator;
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
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
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
import at.jku.weiner.c.common.common.Constant2;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0035_SimpleArray {
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
			"res/Test0035_SimpleArray.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_LINEDIRECTIVE",
				"RULE_NEWLINE",
				"RULE_LINEDIRECTIVE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_CHAR",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTBRACKET",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_STRING_LITERAL",
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
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
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
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTBRACKET",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTBRACKET",
				"RULE_WHITESPACE",
				"RULE_SKW_ASSIGN",
				"RULE_WHITESPACE",
				"RULE_CHAR_LITERAL",
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
			"res/Test0035_SimpleArray.c");
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
		Assert.assertEquals(2, External_0_list.size());
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
		Assert.assertEquals("out", DirectDeclarator_8_Var
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
		final EList<? extends EObject> Expr_20_list = AdditiveExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final MultiplicativeExpression MultiplicativeExpression_21_Var
		 = (MultiplicativeExpression)Expr_20_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = MultiplicativeExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
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
		Assert.assertEquals("255", Constant2_26_Var
		.getDec());
		//26
		final Initializer Initializer_27_Var
		 = (Initializer)InitDeclarator_6_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_27_Var
		);
		//27
		final AssignmentExpression AssignmentExpression_28_Var
		 = (AssignmentExpression)Initializer_27_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_28_Var
		);
		//28
		final ConditionalExpression ConditionalExpression_29_Var
		 = (ConditionalExpression)AssignmentExpression_28_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_29_Var
		);
		//29
		final LogicalOrExpression LogicalOrExpression_30_Var
		 = (LogicalOrExpression)ConditionalExpression_29_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = LogicalOrExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final LogicalAndExpression LogicalAndExpression_31_Var
		 = (LogicalAndExpression)Expr_30_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = LogicalAndExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final InclusiveOrExpression InclusiveOrExpression_32_Var
		 = (InclusiveOrExpression)Expr_31_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = InclusiveOrExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final ExclusiveOrExpression ExclusiveOrExpression_33_Var
		 = (ExclusiveOrExpression)Expr_32_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = ExclusiveOrExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final AndExpression AndExpression_34_Var
		 = (AndExpression)Expr_33_list.get(0);
		Assert.assertNotNull(AndExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = AndExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final EqualityExpression EqualityExpression_35_Var
		 = (EqualityExpression)Expr_34_list.get(0);
		Assert.assertNotNull(EqualityExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = EqualityExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final RelationalExpression RelationalExpression_36_Var
		 = (RelationalExpression)Expr_35_list.get(0);
		Assert.assertNotNull(RelationalExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = RelationalExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final ShiftExpression ShiftExpression_37_Var
		 = (ShiftExpression)Expr_36_list.get(0);
		Assert.assertNotNull(ShiftExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = ShiftExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final AdditiveExpression AdditiveExpression_38_Var
		 = (AdditiveExpression)Expr_37_list.get(0);
		Assert.assertNotNull(AdditiveExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = AdditiveExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final MultiplicativeExpression MultiplicativeExpression_39_Var
		 = (MultiplicativeExpression)Expr_38_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = MultiplicativeExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final CastExpression CastExpression_40_Var
		 = (CastExpression)Expr_39_list.get(0);
		Assert.assertNotNull(CastExpression_40_Var
		);
		//40
		final UnaryExpression UnaryExpression_41_Var
		 = (UnaryExpression)CastExpression_40_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_41_Var
		);
		//41
		final PostfixExpression PostfixExpression_42_Var
		 = (PostfixExpression)UnaryExpression_41_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = PostfixExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final PrimaryExpression PrimaryExpression_43_Var
		 = (PrimaryExpression)Expr_42_list.get(0);
		Assert.assertNotNull(PrimaryExpression_43_Var
		);
		Assert.assertEquals("[\"some output\"]", PrimaryExpression_43_Var
		.getString().toString());
		//43
		final ExternalDeclaration ExternalDeclaration_44_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_44_Var
		);
		//44
		final FunctionDefHead FunctionDefHead_45_Var
		 = (FunctionDefHead)ExternalDeclaration_44_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_45_Var
		);
		//45
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_46_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_45_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_46_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_46_list = FunctionDeclarationSpecifiers_46_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_46_list);
		Assert.assertEquals(1, DeclarationSpecifier_46_list.size());
		//46
		final TypeSpecifier TypeSpecifier_47_Var
		 = (TypeSpecifier)DeclarationSpecifier_46_list.get(0);
		Assert.assertNotNull(TypeSpecifier_47_Var
		);
		Assert.assertEquals("int", TypeSpecifier_47_Var
		.getName());
		//47
		final Declarator Declarator_48_Var
		 = (Declarator)FunctionDefHead_45_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_48_Var
		);
		//48
		final DirectDeclarator DirectDeclarator_49_Var
		 = (DirectDeclarator)Declarator_48_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_49_Var
		);
		Assert.assertEquals("main", DirectDeclarator_49_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_49_list = DirectDeclarator_49_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_49_list);
		Assert.assertEquals(1, DeclaratorSuffix_49_list.size());
		//49
		final DeclaratorSuffix DeclaratorSuffix_50_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_49_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_50_Var
		);
		//50
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_51_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_50_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_51_Var
		);
		final EList<? extends EObject> ParameterTypeList_51_list = DirectDeclaratorLastSuffix_51_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_51_list);
		Assert.assertEquals(1, ParameterTypeList_51_list.size());
		//51
		final ParameterTypeList ParameterTypeList_52_Var
		 = (ParameterTypeList)ParameterTypeList_51_list.get(0);
		Assert.assertNotNull(ParameterTypeList_52_Var
		);
		//52
		final ParameterList ParameterList_53_Var
		 = (ParameterList)ParameterTypeList_52_Var
		.getList();
		Assert.assertNotNull(ParameterList_53_Var
		);
		final EList<? extends EObject> ParameterDeclaration_53_list = ParameterList_53_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_53_list);
		Assert.assertEquals(1, ParameterDeclaration_53_list.size());
		//53
		final ParameterDeclaration ParameterDeclaration_54_Var
		 = (ParameterDeclaration)ParameterDeclaration_53_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_54_Var
		);
		//54
		final DeclarationSpecifiers DeclarationSpecifiers_55_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_54_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_55_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_55_list = DeclarationSpecifiers_55_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_55_list);
		Assert.assertEquals(1, DeclarationSpecifier_55_list.size());
		//55
		final TypeSpecifier TypeSpecifier_56_Var
		 = (TypeSpecifier)DeclarationSpecifier_55_list.get(0);
		Assert.assertNotNull(TypeSpecifier_56_Var
		);
		Assert.assertEquals("void", TypeSpecifier_56_Var
		.getName());
		//56
		final FunctionDefinition FunctionDefinition_57_Var
		 = (FunctionDefinition)ExternalDeclaration_44_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_57_Var
		);
		//57
		final BodyStatement BodyStatement_58_Var
		 = (BodyStatement)FunctionDefinition_57_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_58_Var
		);
		final EList<? extends EObject> BlockList_58_list = BodyStatement_58_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_58_list);
		Assert.assertEquals(1, BlockList_58_list.size());
		//58
		final BlockList BlockList_59_Var
		 = (BlockList)BlockList_58_list.get(0);
		Assert.assertNotNull(BlockList_59_Var
		);
		final EList<? extends EObject> Statement_59_list = BlockList_59_Var
		.getStatement();
		Assert.assertNotNull(Statement_59_list);
		Assert.assertEquals(6, Statement_59_list.size());
		//59
		final Statement Statement_60_Var
		 = (Statement)Statement_59_list.get(0);
		Assert.assertNotNull(Statement_60_Var
		);
		//60
		final ExpressionStatement ExpressionStatement_61_Var
		 = (ExpressionStatement)Statement_60_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_61_Var
		);
		//61
		final Expression Expression_62_Var
		 = (Expression)ExpressionStatement_61_Var
		.getExpression();
		Assert.assertNotNull(Expression_62_Var
		);
		final EList<? extends EObject> ExprExpr_62_list = Expression_62_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_62_list);
		Assert.assertEquals(1, ExprExpr_62_list.size());
		//62
		final AssignmentExpression AssignmentExpression_63_Var
		 = (AssignmentExpression)ExprExpr_62_list.get(0);
		Assert.assertNotNull(AssignmentExpression_63_Var
		);
		//63
		final ConditionalExpression ConditionalExpression_64_Var
		 = (ConditionalExpression)AssignmentExpression_63_Var
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
		Assert.assertEquals("printf", PrimaryExpression_78_Var
		.getId());
		final EList<? extends EObject> Suffix_78_list = PostfixExpression_77_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_78_list);
		Assert.assertEquals(1, Suffix_78_list.size());
		//78
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_79_Var
		 = (PostfixExpressionSuffixArgument)Suffix_78_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_79_Var
		);
		//79
		final ArgumentExpressionList ArgumentExpressionList_80_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_79_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_80_Var
		);
		final EList<? extends EObject> Expr_80_list = ArgumentExpressionList_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(2, Expr_80_list.size());
		//80
		final AssignmentExpression AssignmentExpression_81_Var
		 = (AssignmentExpression)Expr_80_list.get(0);
		Assert.assertNotNull(AssignmentExpression_81_Var
		);
		//81
		final ConditionalExpression ConditionalExpression_82_Var
		 = (ConditionalExpression)AssignmentExpression_81_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_82_Var
		);
		//82
		final LogicalOrExpression LogicalOrExpression_83_Var
		 = (LogicalOrExpression)ConditionalExpression_82_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = LogicalOrExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final LogicalAndExpression LogicalAndExpression_84_Var
		 = (LogicalAndExpression)Expr_83_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = LogicalAndExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final InclusiveOrExpression InclusiveOrExpression_85_Var
		 = (InclusiveOrExpression)Expr_84_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = InclusiveOrExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final ExclusiveOrExpression ExclusiveOrExpression_86_Var
		 = (ExclusiveOrExpression)Expr_85_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = ExclusiveOrExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final AndExpression AndExpression_87_Var
		 = (AndExpression)Expr_86_list.get(0);
		Assert.assertNotNull(AndExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = AndExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final EqualityExpression EqualityExpression_88_Var
		 = (EqualityExpression)Expr_87_list.get(0);
		Assert.assertNotNull(EqualityExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = EqualityExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final RelationalExpression RelationalExpression_89_Var
		 = (RelationalExpression)Expr_88_list.get(0);
		Assert.assertNotNull(RelationalExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = RelationalExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final ShiftExpression ShiftExpression_90_Var
		 = (ShiftExpression)Expr_89_list.get(0);
		Assert.assertNotNull(ShiftExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = ShiftExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final AdditiveExpression AdditiveExpression_91_Var
		 = (AdditiveExpression)Expr_90_list.get(0);
		Assert.assertNotNull(AdditiveExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = AdditiveExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final MultiplicativeExpression MultiplicativeExpression_92_Var
		 = (MultiplicativeExpression)Expr_91_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = MultiplicativeExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final CastExpression CastExpression_93_Var
		 = (CastExpression)Expr_92_list.get(0);
		Assert.assertNotNull(CastExpression_93_Var
		);
		//93
		final UnaryExpression UnaryExpression_94_Var
		 = (UnaryExpression)CastExpression_93_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_94_Var
		);
		//94
		final PostfixExpression PostfixExpression_95_Var
		 = (PostfixExpression)UnaryExpression_94_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = PostfixExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final PrimaryExpression PrimaryExpression_96_Var
		 = (PrimaryExpression)Expr_95_list.get(0);
		Assert.assertNotNull(PrimaryExpression_96_Var
		);
		Assert.assertEquals("[\"%s\\n\"]", PrimaryExpression_96_Var
		.getString().toString());
		//96
		final AssignmentExpression AssignmentExpression_97_Var
		 = (AssignmentExpression)Expr_80_list.get(1);
		Assert.assertNotNull(AssignmentExpression_97_Var
		);
		//97
		final ConditionalExpression ConditionalExpression_98_Var
		 = (ConditionalExpression)AssignmentExpression_97_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_98_Var
		);
		//98
		final LogicalOrExpression LogicalOrExpression_99_Var
		 = (LogicalOrExpression)ConditionalExpression_98_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = LogicalOrExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final LogicalAndExpression LogicalAndExpression_100_Var
		 = (LogicalAndExpression)Expr_99_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = LogicalAndExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final InclusiveOrExpression InclusiveOrExpression_101_Var
		 = (InclusiveOrExpression)Expr_100_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = InclusiveOrExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final ExclusiveOrExpression ExclusiveOrExpression_102_Var
		 = (ExclusiveOrExpression)Expr_101_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = ExclusiveOrExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final AndExpression AndExpression_103_Var
		 = (AndExpression)Expr_102_list.get(0);
		Assert.assertNotNull(AndExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = AndExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final EqualityExpression EqualityExpression_104_Var
		 = (EqualityExpression)Expr_103_list.get(0);
		Assert.assertNotNull(EqualityExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = EqualityExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final RelationalExpression RelationalExpression_105_Var
		 = (RelationalExpression)Expr_104_list.get(0);
		Assert.assertNotNull(RelationalExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = RelationalExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final ShiftExpression ShiftExpression_106_Var
		 = (ShiftExpression)Expr_105_list.get(0);
		Assert.assertNotNull(ShiftExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = ShiftExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final AdditiveExpression AdditiveExpression_107_Var
		 = (AdditiveExpression)Expr_106_list.get(0);
		Assert.assertNotNull(AdditiveExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = AdditiveExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final MultiplicativeExpression MultiplicativeExpression_108_Var
		 = (MultiplicativeExpression)Expr_107_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = MultiplicativeExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final CastExpression CastExpression_109_Var
		 = (CastExpression)Expr_108_list.get(0);
		Assert.assertNotNull(CastExpression_109_Var
		);
		//109
		final UnaryExpression UnaryExpression_110_Var
		 = (UnaryExpression)CastExpression_109_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_110_Var
		);
		//110
		final PostfixExpression PostfixExpression_111_Var
		 = (PostfixExpression)UnaryExpression_110_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = PostfixExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final PrimaryExpression PrimaryExpression_112_Var
		 = (PrimaryExpression)Expr_111_list.get(0);
		Assert.assertNotNull(PrimaryExpression_112_Var
		);
		Assert.assertEquals("out", PrimaryExpression_112_Var
		.getId());
		//112
		final Statement Statement_113_Var
		 = (Statement)Statement_59_list.get(1);
		Assert.assertNotNull(Statement_113_Var
		);
		//113
		final ExpressionStatement ExpressionStatement_114_Var
		 = (ExpressionStatement)Statement_113_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_114_Var
		);
		//114
		final Expression Expression_115_Var
		 = (Expression)ExpressionStatement_114_Var
		.getExpression();
		Assert.assertNotNull(Expression_115_Var
		);
		final EList<? extends EObject> ExprExpr_115_list = Expression_115_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_115_list);
		Assert.assertEquals(1, ExprExpr_115_list.size());
		//115
		final AssignmentExpression AssignmentExpression_116_Var
		 = (AssignmentExpression)ExprExpr_115_list.get(0);
		Assert.assertNotNull(AssignmentExpression_116_Var
		);
		//116
		final ConditionalExpression ConditionalExpression_117_Var
		 = (ConditionalExpression)AssignmentExpression_116_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_117_Var
		);
		//117
		final LogicalOrExpression LogicalOrExpression_118_Var
		 = (LogicalOrExpression)ConditionalExpression_117_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = LogicalOrExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final LogicalAndExpression LogicalAndExpression_119_Var
		 = (LogicalAndExpression)Expr_118_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = LogicalAndExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final InclusiveOrExpression InclusiveOrExpression_120_Var
		 = (InclusiveOrExpression)Expr_119_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = InclusiveOrExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final ExclusiveOrExpression ExclusiveOrExpression_121_Var
		 = (ExclusiveOrExpression)Expr_120_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = ExclusiveOrExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final AndExpression AndExpression_122_Var
		 = (AndExpression)Expr_121_list.get(0);
		Assert.assertNotNull(AndExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = AndExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final EqualityExpression EqualityExpression_123_Var
		 = (EqualityExpression)Expr_122_list.get(0);
		Assert.assertNotNull(EqualityExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = EqualityExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final RelationalExpression RelationalExpression_124_Var
		 = (RelationalExpression)Expr_123_list.get(0);
		Assert.assertNotNull(RelationalExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = RelationalExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final ShiftExpression ShiftExpression_125_Var
		 = (ShiftExpression)Expr_124_list.get(0);
		Assert.assertNotNull(ShiftExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = ShiftExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final AdditiveExpression AdditiveExpression_126_Var
		 = (AdditiveExpression)Expr_125_list.get(0);
		Assert.assertNotNull(AdditiveExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = AdditiveExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final MultiplicativeExpression MultiplicativeExpression_127_Var
		 = (MultiplicativeExpression)Expr_126_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = MultiplicativeExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final CastExpression CastExpression_128_Var
		 = (CastExpression)Expr_127_list.get(0);
		Assert.assertNotNull(CastExpression_128_Var
		);
		//128
		final UnaryExpression UnaryExpression_129_Var
		 = (UnaryExpression)CastExpression_128_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_129_Var
		);
		//129
		final PostfixExpression PostfixExpression_130_Var
		 = (PostfixExpression)UnaryExpression_129_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = PostfixExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final PrimaryExpression PrimaryExpression_131_Var
		 = (PrimaryExpression)Expr_130_list.get(0);
		Assert.assertNotNull(PrimaryExpression_131_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_131_Var
		.getId());
		final EList<? extends EObject> Suffix_131_list = PostfixExpression_130_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_131_list);
		Assert.assertEquals(1, Suffix_131_list.size());
		//131
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_132_Var
		 = (PostfixExpressionSuffixArgument)Suffix_131_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_132_Var
		);
		//132
		final ArgumentExpressionList ArgumentExpressionList_133_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_132_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_133_Var
		);
		final EList<? extends EObject> Expr_133_list = ArgumentExpressionList_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(2, Expr_133_list.size());
		//133
		final AssignmentExpression AssignmentExpression_134_Var
		 = (AssignmentExpression)Expr_133_list.get(0);
		Assert.assertNotNull(AssignmentExpression_134_Var
		);
		//134
		final ConditionalExpression ConditionalExpression_135_Var
		 = (ConditionalExpression)AssignmentExpression_134_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_135_Var
		);
		//135
		final LogicalOrExpression LogicalOrExpression_136_Var
		 = (LogicalOrExpression)ConditionalExpression_135_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = LogicalOrExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final LogicalAndExpression LogicalAndExpression_137_Var
		 = (LogicalAndExpression)Expr_136_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = LogicalAndExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final InclusiveOrExpression InclusiveOrExpression_138_Var
		 = (InclusiveOrExpression)Expr_137_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = InclusiveOrExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final ExclusiveOrExpression ExclusiveOrExpression_139_Var
		 = (ExclusiveOrExpression)Expr_138_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = ExclusiveOrExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final AndExpression AndExpression_140_Var
		 = (AndExpression)Expr_139_list.get(0);
		Assert.assertNotNull(AndExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = AndExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final EqualityExpression EqualityExpression_141_Var
		 = (EqualityExpression)Expr_140_list.get(0);
		Assert.assertNotNull(EqualityExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = EqualityExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final RelationalExpression RelationalExpression_142_Var
		 = (RelationalExpression)Expr_141_list.get(0);
		Assert.assertNotNull(RelationalExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = RelationalExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final ShiftExpression ShiftExpression_143_Var
		 = (ShiftExpression)Expr_142_list.get(0);
		Assert.assertNotNull(ShiftExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = ShiftExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final AdditiveExpression AdditiveExpression_144_Var
		 = (AdditiveExpression)Expr_143_list.get(0);
		Assert.assertNotNull(AdditiveExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = AdditiveExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final MultiplicativeExpression MultiplicativeExpression_145_Var
		 = (MultiplicativeExpression)Expr_144_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = MultiplicativeExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final CastExpression CastExpression_146_Var
		 = (CastExpression)Expr_145_list.get(0);
		Assert.assertNotNull(CastExpression_146_Var
		);
		//146
		final UnaryExpression UnaryExpression_147_Var
		 = (UnaryExpression)CastExpression_146_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_147_Var
		);
		//147
		final PostfixExpression PostfixExpression_148_Var
		 = (PostfixExpression)UnaryExpression_147_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_148_Var
		);
		final EList<? extends EObject> Expr_148_list = PostfixExpression_148_Var
		.getExpr();
		Assert.assertNotNull(Expr_148_list);
		Assert.assertEquals(1, Expr_148_list.size());
		//148
		final PrimaryExpression PrimaryExpression_149_Var
		 = (PrimaryExpression)Expr_148_list.get(0);
		Assert.assertNotNull(PrimaryExpression_149_Var
		);
		Assert.assertEquals("out", PrimaryExpression_149_Var
		.getId());
		//149
		final AssignmentExpression AssignmentExpression_150_Var
		 = (AssignmentExpression)Expr_133_list.get(1);
		Assert.assertNotNull(AssignmentExpression_150_Var
		);
		//150
		final ConditionalExpression ConditionalExpression_151_Var
		 = (ConditionalExpression)AssignmentExpression_150_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_151_Var
		);
		//151
		final LogicalOrExpression LogicalOrExpression_152_Var
		 = (LogicalOrExpression)ConditionalExpression_151_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_152_Var
		);
		final EList<? extends EObject> Expr_152_list = LogicalOrExpression_152_Var
		.getExpr();
		Assert.assertNotNull(Expr_152_list);
		Assert.assertEquals(1, Expr_152_list.size());
		//152
		final LogicalAndExpression LogicalAndExpression_153_Var
		 = (LogicalAndExpression)Expr_152_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_153_Var
		);
		final EList<? extends EObject> Expr_153_list = LogicalAndExpression_153_Var
		.getExpr();
		Assert.assertNotNull(Expr_153_list);
		Assert.assertEquals(1, Expr_153_list.size());
		//153
		final InclusiveOrExpression InclusiveOrExpression_154_Var
		 = (InclusiveOrExpression)Expr_153_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_154_Var
		);
		final EList<? extends EObject> Expr_154_list = InclusiveOrExpression_154_Var
		.getExpr();
		Assert.assertNotNull(Expr_154_list);
		Assert.assertEquals(1, Expr_154_list.size());
		//154
		final ExclusiveOrExpression ExclusiveOrExpression_155_Var
		 = (ExclusiveOrExpression)Expr_154_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_155_Var
		);
		final EList<? extends EObject> Expr_155_list = ExclusiveOrExpression_155_Var
		.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		//155
		final AndExpression AndExpression_156_Var
		 = (AndExpression)Expr_155_list.get(0);
		Assert.assertNotNull(AndExpression_156_Var
		);
		final EList<? extends EObject> Expr_156_list = AndExpression_156_Var
		.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		//156
		final EqualityExpression EqualityExpression_157_Var
		 = (EqualityExpression)Expr_156_list.get(0);
		Assert.assertNotNull(EqualityExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = EqualityExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final RelationalExpression RelationalExpression_158_Var
		 = (RelationalExpression)Expr_157_list.get(0);
		Assert.assertNotNull(RelationalExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = RelationalExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final ShiftExpression ShiftExpression_159_Var
		 = (ShiftExpression)Expr_158_list.get(0);
		Assert.assertNotNull(ShiftExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = ShiftExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final AdditiveExpression AdditiveExpression_160_Var
		 = (AdditiveExpression)Expr_159_list.get(0);
		Assert.assertNotNull(AdditiveExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = AdditiveExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final MultiplicativeExpression MultiplicativeExpression_161_Var
		 = (MultiplicativeExpression)Expr_160_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = MultiplicativeExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final CastExpression CastExpression_162_Var
		 = (CastExpression)Expr_161_list.get(0);
		Assert.assertNotNull(CastExpression_162_Var
		);
		//162
		final UnaryExpression UnaryExpression_163_Var
		 = (UnaryExpression)CastExpression_162_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_163_Var
		);
		//163
		final PostfixExpression PostfixExpression_164_Var
		 = (PostfixExpression)UnaryExpression_163_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_164_Var
		);
		final EList<? extends EObject> Expr_164_list = PostfixExpression_164_Var
		.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		//164
		final PrimaryExpression PrimaryExpression_165_Var
		 = (PrimaryExpression)Expr_164_list.get(0);
		Assert.assertNotNull(PrimaryExpression_165_Var
		);
		Assert.assertEquals("[\"Hello World!\"]", PrimaryExpression_165_Var
		.getString().toString());
		//165
		final Statement Statement_166_Var
		 = (Statement)Statement_59_list.get(2);
		Assert.assertNotNull(Statement_166_Var
		);
		//166
		final ExpressionStatement ExpressionStatement_167_Var
		 = (ExpressionStatement)Statement_166_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_167_Var
		);
		//167
		final Expression Expression_168_Var
		 = (Expression)ExpressionStatement_167_Var
		.getExpression();
		Assert.assertNotNull(Expression_168_Var
		);
		final EList<? extends EObject> ExprExpr_168_list = Expression_168_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_168_list);
		Assert.assertEquals(1, ExprExpr_168_list.size());
		//168
		final AssignmentExpression AssignmentExpression_169_Var
		 = (AssignmentExpression)ExprExpr_168_list.get(0);
		Assert.assertNotNull(AssignmentExpression_169_Var
		);
		//169
		final ConditionalExpression ConditionalExpression_170_Var
		 = (ConditionalExpression)AssignmentExpression_169_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_170_Var
		);
		//170
		final LogicalOrExpression LogicalOrExpression_171_Var
		 = (LogicalOrExpression)ConditionalExpression_170_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_171_Var
		);
		final EList<? extends EObject> Expr_171_list = LogicalOrExpression_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		//171
		final LogicalAndExpression LogicalAndExpression_172_Var
		 = (LogicalAndExpression)Expr_171_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = LogicalAndExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final InclusiveOrExpression InclusiveOrExpression_173_Var
		 = (InclusiveOrExpression)Expr_172_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = InclusiveOrExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final ExclusiveOrExpression ExclusiveOrExpression_174_Var
		 = (ExclusiveOrExpression)Expr_173_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = ExclusiveOrExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final AndExpression AndExpression_175_Var
		 = (AndExpression)Expr_174_list.get(0);
		Assert.assertNotNull(AndExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = AndExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final EqualityExpression EqualityExpression_176_Var
		 = (EqualityExpression)Expr_175_list.get(0);
		Assert.assertNotNull(EqualityExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = EqualityExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final RelationalExpression RelationalExpression_177_Var
		 = (RelationalExpression)Expr_176_list.get(0);
		Assert.assertNotNull(RelationalExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = RelationalExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final ShiftExpression ShiftExpression_178_Var
		 = (ShiftExpression)Expr_177_list.get(0);
		Assert.assertNotNull(ShiftExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = ShiftExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final AdditiveExpression AdditiveExpression_179_Var
		 = (AdditiveExpression)Expr_178_list.get(0);
		Assert.assertNotNull(AdditiveExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = AdditiveExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final MultiplicativeExpression MultiplicativeExpression_180_Var
		 = (MultiplicativeExpression)Expr_179_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_180_Var
		);
		final EList<? extends EObject> Expr_180_list = MultiplicativeExpression_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final CastExpression CastExpression_181_Var
		 = (CastExpression)Expr_180_list.get(0);
		Assert.assertNotNull(CastExpression_181_Var
		);
		//181
		final UnaryExpression UnaryExpression_182_Var
		 = (UnaryExpression)CastExpression_181_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_182_Var
		);
		//182
		final PostfixExpression PostfixExpression_183_Var
		 = (PostfixExpression)UnaryExpression_182_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = PostfixExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final PrimaryExpression PrimaryExpression_184_Var
		 = (PrimaryExpression)Expr_183_list.get(0);
		Assert.assertNotNull(PrimaryExpression_184_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_184_Var
		.getId());
		final EList<? extends EObject> Suffix_184_list = PostfixExpression_183_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_184_list);
		Assert.assertEquals(1, Suffix_184_list.size());
		//184
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_185_Var
		 = (PostfixExpressionSuffixArgument)Suffix_184_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_185_Var
		);
		//185
		final ArgumentExpressionList ArgumentExpressionList_186_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_185_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_186_Var
		);
		final EList<? extends EObject> Expr_186_list = ArgumentExpressionList_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(2, Expr_186_list.size());
		//186
		final AssignmentExpression AssignmentExpression_187_Var
		 = (AssignmentExpression)Expr_186_list.get(0);
		Assert.assertNotNull(AssignmentExpression_187_Var
		);
		//187
		final ConditionalExpression ConditionalExpression_188_Var
		 = (ConditionalExpression)AssignmentExpression_187_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_188_Var
		);
		//188
		final LogicalOrExpression LogicalOrExpression_189_Var
		 = (LogicalOrExpression)ConditionalExpression_188_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = LogicalOrExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final LogicalAndExpression LogicalAndExpression_190_Var
		 = (LogicalAndExpression)Expr_189_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = LogicalAndExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final InclusiveOrExpression InclusiveOrExpression_191_Var
		 = (InclusiveOrExpression)Expr_190_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = InclusiveOrExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final ExclusiveOrExpression ExclusiveOrExpression_192_Var
		 = (ExclusiveOrExpression)Expr_191_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = ExclusiveOrExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final AndExpression AndExpression_193_Var
		 = (AndExpression)Expr_192_list.get(0);
		Assert.assertNotNull(AndExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = AndExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final EqualityExpression EqualityExpression_194_Var
		 = (EqualityExpression)Expr_193_list.get(0);
		Assert.assertNotNull(EqualityExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = EqualityExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final RelationalExpression RelationalExpression_195_Var
		 = (RelationalExpression)Expr_194_list.get(0);
		Assert.assertNotNull(RelationalExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = RelationalExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final ShiftExpression ShiftExpression_196_Var
		 = (ShiftExpression)Expr_195_list.get(0);
		Assert.assertNotNull(ShiftExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = ShiftExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final AdditiveExpression AdditiveExpression_197_Var
		 = (AdditiveExpression)Expr_196_list.get(0);
		Assert.assertNotNull(AdditiveExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = AdditiveExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final MultiplicativeExpression MultiplicativeExpression_198_Var
		 = (MultiplicativeExpression)Expr_197_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = MultiplicativeExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final CastExpression CastExpression_199_Var
		 = (CastExpression)Expr_198_list.get(0);
		Assert.assertNotNull(CastExpression_199_Var
		);
		//199
		final UnaryExpression UnaryExpression_200_Var
		 = (UnaryExpression)CastExpression_199_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_200_Var
		);
		//200
		final PostfixExpression PostfixExpression_201_Var
		 = (PostfixExpression)UnaryExpression_200_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = PostfixExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final PrimaryExpression PrimaryExpression_202_Var
		 = (PrimaryExpression)Expr_201_list.get(0);
		Assert.assertNotNull(PrimaryExpression_202_Var
		);
		Assert.assertEquals("[\"%s\\n\"]", PrimaryExpression_202_Var
		.getString().toString());
		//202
		final AssignmentExpression AssignmentExpression_203_Var
		 = (AssignmentExpression)Expr_186_list.get(1);
		Assert.assertNotNull(AssignmentExpression_203_Var
		);
		//203
		final ConditionalExpression ConditionalExpression_204_Var
		 = (ConditionalExpression)AssignmentExpression_203_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_204_Var
		);
		//204
		final LogicalOrExpression LogicalOrExpression_205_Var
		 = (LogicalOrExpression)ConditionalExpression_204_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = LogicalOrExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final LogicalAndExpression LogicalAndExpression_206_Var
		 = (LogicalAndExpression)Expr_205_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = LogicalAndExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final InclusiveOrExpression InclusiveOrExpression_207_Var
		 = (InclusiveOrExpression)Expr_206_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = InclusiveOrExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final ExclusiveOrExpression ExclusiveOrExpression_208_Var
		 = (ExclusiveOrExpression)Expr_207_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = ExclusiveOrExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final AndExpression AndExpression_209_Var
		 = (AndExpression)Expr_208_list.get(0);
		Assert.assertNotNull(AndExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = AndExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final EqualityExpression EqualityExpression_210_Var
		 = (EqualityExpression)Expr_209_list.get(0);
		Assert.assertNotNull(EqualityExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = EqualityExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final RelationalExpression RelationalExpression_211_Var
		 = (RelationalExpression)Expr_210_list.get(0);
		Assert.assertNotNull(RelationalExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = RelationalExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final ShiftExpression ShiftExpression_212_Var
		 = (ShiftExpression)Expr_211_list.get(0);
		Assert.assertNotNull(ShiftExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = ShiftExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final AdditiveExpression AdditiveExpression_213_Var
		 = (AdditiveExpression)Expr_212_list.get(0);
		Assert.assertNotNull(AdditiveExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = AdditiveExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final MultiplicativeExpression MultiplicativeExpression_214_Var
		 = (MultiplicativeExpression)Expr_213_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = MultiplicativeExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final CastExpression CastExpression_215_Var
		 = (CastExpression)Expr_214_list.get(0);
		Assert.assertNotNull(CastExpression_215_Var
		);
		//215
		final UnaryExpression UnaryExpression_216_Var
		 = (UnaryExpression)CastExpression_215_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_216_Var
		);
		//216
		final PostfixExpression PostfixExpression_217_Var
		 = (PostfixExpression)UnaryExpression_216_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = PostfixExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final PrimaryExpression PrimaryExpression_218_Var
		 = (PrimaryExpression)Expr_217_list.get(0);
		Assert.assertNotNull(PrimaryExpression_218_Var
		);
		Assert.assertEquals("out", PrimaryExpression_218_Var
		.getId());
		//218
		final Statement Statement_219_Var
		 = (Statement)Statement_59_list.get(3);
		Assert.assertNotNull(Statement_219_Var
		);
		//219
		final ExpressionStatement ExpressionStatement_220_Var
		 = (ExpressionStatement)Statement_219_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_220_Var
		);
		//220
		final Expression Expression_221_Var
		 = (Expression)ExpressionStatement_220_Var
		.getExpression();
		Assert.assertNotNull(Expression_221_Var
		);
		final EList<? extends EObject> ExprExpr_221_list = Expression_221_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_221_list);
		Assert.assertEquals(1, ExprExpr_221_list.size());
		//221
		final AssignmentExpression AssignmentExpression_222_Var
		 = (AssignmentExpression)ExprExpr_221_list.get(0);
		Assert.assertNotNull(AssignmentExpression_222_Var
		);
		//222
		final UnaryExpression UnaryExpression_223_Var
		 = (UnaryExpression)AssignmentExpression_222_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_223_Var
		);
		//223
		final PostfixExpression PostfixExpression_224_Var
		 = (PostfixExpression)UnaryExpression_223_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = PostfixExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final PrimaryExpression PrimaryExpression_225_Var
		 = (PrimaryExpression)Expr_224_list.get(0);
		Assert.assertNotNull(PrimaryExpression_225_Var
		);
		Assert.assertEquals("out", PrimaryExpression_225_Var
		.getId());
		final EList<? extends EObject> Suffix_225_list = PostfixExpression_224_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_225_list);
		Assert.assertEquals(1, Suffix_225_list.size());
		//225
		final PostfixExpressionSuffixArray PostfixExpressionSuffixArray_226_Var
		 = (PostfixExpressionSuffixArray)Suffix_225_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArray_226_Var
		);
		//226
		final Expression Expression_227_Var
		 = (Expression)PostfixExpressionSuffixArray_226_Var
		.getArrayExpr();
		Assert.assertNotNull(Expression_227_Var
		);
		final EList<? extends EObject> ExprExpr_227_list = Expression_227_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_227_list);
		Assert.assertEquals(1, ExprExpr_227_list.size());
		//227
		final AssignmentExpression AssignmentExpression_228_Var
		 = (AssignmentExpression)ExprExpr_227_list.get(0);
		Assert.assertNotNull(AssignmentExpression_228_Var
		);
		//228
		final ConditionalExpression ConditionalExpression_229_Var
		 = (ConditionalExpression)AssignmentExpression_228_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_229_Var
		);
		//229
		final LogicalOrExpression LogicalOrExpression_230_Var
		 = (LogicalOrExpression)ConditionalExpression_229_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = LogicalOrExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final LogicalAndExpression LogicalAndExpression_231_Var
		 = (LogicalAndExpression)Expr_230_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = LogicalAndExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final InclusiveOrExpression InclusiveOrExpression_232_Var
		 = (InclusiveOrExpression)Expr_231_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = InclusiveOrExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final ExclusiveOrExpression ExclusiveOrExpression_233_Var
		 = (ExclusiveOrExpression)Expr_232_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = ExclusiveOrExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final AndExpression AndExpression_234_Var
		 = (AndExpression)Expr_233_list.get(0);
		Assert.assertNotNull(AndExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = AndExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final EqualityExpression EqualityExpression_235_Var
		 = (EqualityExpression)Expr_234_list.get(0);
		Assert.assertNotNull(EqualityExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = EqualityExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final RelationalExpression RelationalExpression_236_Var
		 = (RelationalExpression)Expr_235_list.get(0);
		Assert.assertNotNull(RelationalExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = RelationalExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final ShiftExpression ShiftExpression_237_Var
		 = (ShiftExpression)Expr_236_list.get(0);
		Assert.assertNotNull(ShiftExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = ShiftExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final AdditiveExpression AdditiveExpression_238_Var
		 = (AdditiveExpression)Expr_237_list.get(0);
		Assert.assertNotNull(AdditiveExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = AdditiveExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final MultiplicativeExpression MultiplicativeExpression_239_Var
		 = (MultiplicativeExpression)Expr_238_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = MultiplicativeExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final CastExpression CastExpression_240_Var
		 = (CastExpression)Expr_239_list.get(0);
		Assert.assertNotNull(CastExpression_240_Var
		);
		//240
		final UnaryExpression UnaryExpression_241_Var
		 = (UnaryExpression)CastExpression_240_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_241_Var
		);
		//241
		final PostfixExpression PostfixExpression_242_Var
		 = (PostfixExpression)UnaryExpression_241_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = PostfixExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final PrimaryExpression PrimaryExpression_243_Var
		 = (PrimaryExpression)Expr_242_list.get(0);
		Assert.assertNotNull(PrimaryExpression_243_Var
		);
		//243
		final Constant2 Constant2_244_Var
		 = (Constant2)PrimaryExpression_243_Var
		.getConst();
		Assert.assertNotNull(Constant2_244_Var
		);
		Assert.assertEquals("6", Constant2_244_Var
		.getDec());
		//244
		final AssignmentOperator AssignmentOperator_245_Var
		 = (AssignmentOperator)AssignmentExpression_222_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_245_Var
		);
		Assert.assertEquals("=", AssignmentOperator_245_Var
		.getOp());
		//245
		final AssignmentExpression AssignmentExpression_246_Var
		 = (AssignmentExpression)AssignmentExpression_222_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_246_Var
		);
		//246
		final ConditionalExpression ConditionalExpression_247_Var
		 = (ConditionalExpression)AssignmentExpression_246_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_247_Var
		);
		//247
		final LogicalOrExpression LogicalOrExpression_248_Var
		 = (LogicalOrExpression)ConditionalExpression_247_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = LogicalOrExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final LogicalAndExpression LogicalAndExpression_249_Var
		 = (LogicalAndExpression)Expr_248_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = LogicalAndExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final InclusiveOrExpression InclusiveOrExpression_250_Var
		 = (InclusiveOrExpression)Expr_249_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = InclusiveOrExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final ExclusiveOrExpression ExclusiveOrExpression_251_Var
		 = (ExclusiveOrExpression)Expr_250_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = ExclusiveOrExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final AndExpression AndExpression_252_Var
		 = (AndExpression)Expr_251_list.get(0);
		Assert.assertNotNull(AndExpression_252_Var
		);
		final EList<? extends EObject> Expr_252_list = AndExpression_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(1, Expr_252_list.size());
		//252
		final EqualityExpression EqualityExpression_253_Var
		 = (EqualityExpression)Expr_252_list.get(0);
		Assert.assertNotNull(EqualityExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = EqualityExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final RelationalExpression RelationalExpression_254_Var
		 = (RelationalExpression)Expr_253_list.get(0);
		Assert.assertNotNull(RelationalExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = RelationalExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final ShiftExpression ShiftExpression_255_Var
		 = (ShiftExpression)Expr_254_list.get(0);
		Assert.assertNotNull(ShiftExpression_255_Var
		);
		final EList<? extends EObject> Expr_255_list = ShiftExpression_255_Var
		.getExpr();
		Assert.assertNotNull(Expr_255_list);
		Assert.assertEquals(1, Expr_255_list.size());
		//255
		final AdditiveExpression AdditiveExpression_256_Var
		 = (AdditiveExpression)Expr_255_list.get(0);
		Assert.assertNotNull(AdditiveExpression_256_Var
		);
		final EList<? extends EObject> Expr_256_list = AdditiveExpression_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(1, Expr_256_list.size());
		//256
		final MultiplicativeExpression MultiplicativeExpression_257_Var
		 = (MultiplicativeExpression)Expr_256_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = MultiplicativeExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final CastExpression CastExpression_258_Var
		 = (CastExpression)Expr_257_list.get(0);
		Assert.assertNotNull(CastExpression_258_Var
		);
		//258
		final UnaryExpression UnaryExpression_259_Var
		 = (UnaryExpression)CastExpression_258_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_259_Var
		);
		//259
		final PostfixExpression PostfixExpression_260_Var
		 = (PostfixExpression)UnaryExpression_259_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = PostfixExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final PrimaryExpression PrimaryExpression_261_Var
		 = (PrimaryExpression)Expr_260_list.get(0);
		Assert.assertNotNull(PrimaryExpression_261_Var
		);
		//261
		final Constant2 Constant2_262_Var
		 = (Constant2)PrimaryExpression_261_Var
		.getConst();
		Assert.assertNotNull(Constant2_262_Var
		);
		Assert.assertEquals("'w'", Constant2_262_Var
		.getCh());
		//262
		final Statement Statement_263_Var
		 = (Statement)Statement_59_list.get(4);
		Assert.assertNotNull(Statement_263_Var
		);
		//263
		final ExpressionStatement ExpressionStatement_264_Var
		 = (ExpressionStatement)Statement_263_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_264_Var
		);
		//264
		final Expression Expression_265_Var
		 = (Expression)ExpressionStatement_264_Var
		.getExpression();
		Assert.assertNotNull(Expression_265_Var
		);
		final EList<? extends EObject> ExprExpr_265_list = Expression_265_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_265_list);
		Assert.assertEquals(1, ExprExpr_265_list.size());
		//265
		final AssignmentExpression AssignmentExpression_266_Var
		 = (AssignmentExpression)ExprExpr_265_list.get(0);
		Assert.assertNotNull(AssignmentExpression_266_Var
		);
		//266
		final ConditionalExpression ConditionalExpression_267_Var
		 = (ConditionalExpression)AssignmentExpression_266_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_267_Var
		);
		//267
		final LogicalOrExpression LogicalOrExpression_268_Var
		 = (LogicalOrExpression)ConditionalExpression_267_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_268_Var
		);
		final EList<? extends EObject> Expr_268_list = LogicalOrExpression_268_Var
		.getExpr();
		Assert.assertNotNull(Expr_268_list);
		Assert.assertEquals(1, Expr_268_list.size());
		//268
		final LogicalAndExpression LogicalAndExpression_269_Var
		 = (LogicalAndExpression)Expr_268_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_269_Var
		);
		final EList<? extends EObject> Expr_269_list = LogicalAndExpression_269_Var
		.getExpr();
		Assert.assertNotNull(Expr_269_list);
		Assert.assertEquals(1, Expr_269_list.size());
		//269
		final InclusiveOrExpression InclusiveOrExpression_270_Var
		 = (InclusiveOrExpression)Expr_269_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_270_Var
		);
		final EList<? extends EObject> Expr_270_list = InclusiveOrExpression_270_Var
		.getExpr();
		Assert.assertNotNull(Expr_270_list);
		Assert.assertEquals(1, Expr_270_list.size());
		//270
		final ExclusiveOrExpression ExclusiveOrExpression_271_Var
		 = (ExclusiveOrExpression)Expr_270_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_271_Var
		);
		final EList<? extends EObject> Expr_271_list = ExclusiveOrExpression_271_Var
		.getExpr();
		Assert.assertNotNull(Expr_271_list);
		Assert.assertEquals(1, Expr_271_list.size());
		//271
		final AndExpression AndExpression_272_Var
		 = (AndExpression)Expr_271_list.get(0);
		Assert.assertNotNull(AndExpression_272_Var
		);
		final EList<? extends EObject> Expr_272_list = AndExpression_272_Var
		.getExpr();
		Assert.assertNotNull(Expr_272_list);
		Assert.assertEquals(1, Expr_272_list.size());
		//272
		final EqualityExpression EqualityExpression_273_Var
		 = (EqualityExpression)Expr_272_list.get(0);
		Assert.assertNotNull(EqualityExpression_273_Var
		);
		final EList<? extends EObject> Expr_273_list = EqualityExpression_273_Var
		.getExpr();
		Assert.assertNotNull(Expr_273_list);
		Assert.assertEquals(1, Expr_273_list.size());
		//273
		final RelationalExpression RelationalExpression_274_Var
		 = (RelationalExpression)Expr_273_list.get(0);
		Assert.assertNotNull(RelationalExpression_274_Var
		);
		final EList<? extends EObject> Expr_274_list = RelationalExpression_274_Var
		.getExpr();
		Assert.assertNotNull(Expr_274_list);
		Assert.assertEquals(1, Expr_274_list.size());
		//274
		final ShiftExpression ShiftExpression_275_Var
		 = (ShiftExpression)Expr_274_list.get(0);
		Assert.assertNotNull(ShiftExpression_275_Var
		);
		final EList<? extends EObject> Expr_275_list = ShiftExpression_275_Var
		.getExpr();
		Assert.assertNotNull(Expr_275_list);
		Assert.assertEquals(1, Expr_275_list.size());
		//275
		final AdditiveExpression AdditiveExpression_276_Var
		 = (AdditiveExpression)Expr_275_list.get(0);
		Assert.assertNotNull(AdditiveExpression_276_Var
		);
		final EList<? extends EObject> Expr_276_list = AdditiveExpression_276_Var
		.getExpr();
		Assert.assertNotNull(Expr_276_list);
		Assert.assertEquals(1, Expr_276_list.size());
		//276
		final MultiplicativeExpression MultiplicativeExpression_277_Var
		 = (MultiplicativeExpression)Expr_276_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_277_Var
		);
		final EList<? extends EObject> Expr_277_list = MultiplicativeExpression_277_Var
		.getExpr();
		Assert.assertNotNull(Expr_277_list);
		Assert.assertEquals(1, Expr_277_list.size());
		//277
		final CastExpression CastExpression_278_Var
		 = (CastExpression)Expr_277_list.get(0);
		Assert.assertNotNull(CastExpression_278_Var
		);
		//278
		final UnaryExpression UnaryExpression_279_Var
		 = (UnaryExpression)CastExpression_278_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_279_Var
		);
		//279
		final PostfixExpression PostfixExpression_280_Var
		 = (PostfixExpression)UnaryExpression_279_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_280_Var
		);
		final EList<? extends EObject> Expr_280_list = PostfixExpression_280_Var
		.getExpr();
		Assert.assertNotNull(Expr_280_list);
		Assert.assertEquals(1, Expr_280_list.size());
		//280
		final PrimaryExpression PrimaryExpression_281_Var
		 = (PrimaryExpression)Expr_280_list.get(0);
		Assert.assertNotNull(PrimaryExpression_281_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_281_Var
		.getId());
		final EList<? extends EObject> Suffix_281_list = PostfixExpression_280_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_281_list);
		Assert.assertEquals(1, Suffix_281_list.size());
		//281
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_282_Var
		 = (PostfixExpressionSuffixArgument)Suffix_281_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_282_Var
		);
		//282
		final ArgumentExpressionList ArgumentExpressionList_283_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_282_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_283_Var
		);
		final EList<? extends EObject> Expr_283_list = ArgumentExpressionList_283_Var
		.getExpr();
		Assert.assertNotNull(Expr_283_list);
		Assert.assertEquals(2, Expr_283_list.size());
		//283
		final AssignmentExpression AssignmentExpression_284_Var
		 = (AssignmentExpression)Expr_283_list.get(0);
		Assert.assertNotNull(AssignmentExpression_284_Var
		);
		//284
		final ConditionalExpression ConditionalExpression_285_Var
		 = (ConditionalExpression)AssignmentExpression_284_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_285_Var
		);
		//285
		final LogicalOrExpression LogicalOrExpression_286_Var
		 = (LogicalOrExpression)ConditionalExpression_285_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_286_Var
		);
		final EList<? extends EObject> Expr_286_list = LogicalOrExpression_286_Var
		.getExpr();
		Assert.assertNotNull(Expr_286_list);
		Assert.assertEquals(1, Expr_286_list.size());
		//286
		final LogicalAndExpression LogicalAndExpression_287_Var
		 = (LogicalAndExpression)Expr_286_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_287_Var
		);
		final EList<? extends EObject> Expr_287_list = LogicalAndExpression_287_Var
		.getExpr();
		Assert.assertNotNull(Expr_287_list);
		Assert.assertEquals(1, Expr_287_list.size());
		//287
		final InclusiveOrExpression InclusiveOrExpression_288_Var
		 = (InclusiveOrExpression)Expr_287_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_288_Var
		);
		final EList<? extends EObject> Expr_288_list = InclusiveOrExpression_288_Var
		.getExpr();
		Assert.assertNotNull(Expr_288_list);
		Assert.assertEquals(1, Expr_288_list.size());
		//288
		final ExclusiveOrExpression ExclusiveOrExpression_289_Var
		 = (ExclusiveOrExpression)Expr_288_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_289_Var
		);
		final EList<? extends EObject> Expr_289_list = ExclusiveOrExpression_289_Var
		.getExpr();
		Assert.assertNotNull(Expr_289_list);
		Assert.assertEquals(1, Expr_289_list.size());
		//289
		final AndExpression AndExpression_290_Var
		 = (AndExpression)Expr_289_list.get(0);
		Assert.assertNotNull(AndExpression_290_Var
		);
		final EList<? extends EObject> Expr_290_list = AndExpression_290_Var
		.getExpr();
		Assert.assertNotNull(Expr_290_list);
		Assert.assertEquals(1, Expr_290_list.size());
		//290
		final EqualityExpression EqualityExpression_291_Var
		 = (EqualityExpression)Expr_290_list.get(0);
		Assert.assertNotNull(EqualityExpression_291_Var
		);
		final EList<? extends EObject> Expr_291_list = EqualityExpression_291_Var
		.getExpr();
		Assert.assertNotNull(Expr_291_list);
		Assert.assertEquals(1, Expr_291_list.size());
		//291
		final RelationalExpression RelationalExpression_292_Var
		 = (RelationalExpression)Expr_291_list.get(0);
		Assert.assertNotNull(RelationalExpression_292_Var
		);
		final EList<? extends EObject> Expr_292_list = RelationalExpression_292_Var
		.getExpr();
		Assert.assertNotNull(Expr_292_list);
		Assert.assertEquals(1, Expr_292_list.size());
		//292
		final ShiftExpression ShiftExpression_293_Var
		 = (ShiftExpression)Expr_292_list.get(0);
		Assert.assertNotNull(ShiftExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = ShiftExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final AdditiveExpression AdditiveExpression_294_Var
		 = (AdditiveExpression)Expr_293_list.get(0);
		Assert.assertNotNull(AdditiveExpression_294_Var
		);
		final EList<? extends EObject> Expr_294_list = AdditiveExpression_294_Var
		.getExpr();
		Assert.assertNotNull(Expr_294_list);
		Assert.assertEquals(1, Expr_294_list.size());
		//294
		final MultiplicativeExpression MultiplicativeExpression_295_Var
		 = (MultiplicativeExpression)Expr_294_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_295_Var
		);
		final EList<? extends EObject> Expr_295_list = MultiplicativeExpression_295_Var
		.getExpr();
		Assert.assertNotNull(Expr_295_list);
		Assert.assertEquals(1, Expr_295_list.size());
		//295
		final CastExpression CastExpression_296_Var
		 = (CastExpression)Expr_295_list.get(0);
		Assert.assertNotNull(CastExpression_296_Var
		);
		//296
		final UnaryExpression UnaryExpression_297_Var
		 = (UnaryExpression)CastExpression_296_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_297_Var
		);
		//297
		final PostfixExpression PostfixExpression_298_Var
		 = (PostfixExpression)UnaryExpression_297_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_298_Var
		);
		final EList<? extends EObject> Expr_298_list = PostfixExpression_298_Var
		.getExpr();
		Assert.assertNotNull(Expr_298_list);
		Assert.assertEquals(1, Expr_298_list.size());
		//298
		final PrimaryExpression PrimaryExpression_299_Var
		 = (PrimaryExpression)Expr_298_list.get(0);
		Assert.assertNotNull(PrimaryExpression_299_Var
		);
		Assert.assertEquals("[\"%s\\n\"]", PrimaryExpression_299_Var
		.getString().toString());
		//299
		final AssignmentExpression AssignmentExpression_300_Var
		 = (AssignmentExpression)Expr_283_list.get(1);
		Assert.assertNotNull(AssignmentExpression_300_Var
		);
		//300
		final ConditionalExpression ConditionalExpression_301_Var
		 = (ConditionalExpression)AssignmentExpression_300_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_301_Var
		);
		//301
		final LogicalOrExpression LogicalOrExpression_302_Var
		 = (LogicalOrExpression)ConditionalExpression_301_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_302_Var
		);
		final EList<? extends EObject> Expr_302_list = LogicalOrExpression_302_Var
		.getExpr();
		Assert.assertNotNull(Expr_302_list);
		Assert.assertEquals(1, Expr_302_list.size());
		//302
		final LogicalAndExpression LogicalAndExpression_303_Var
		 = (LogicalAndExpression)Expr_302_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_303_Var
		);
		final EList<? extends EObject> Expr_303_list = LogicalAndExpression_303_Var
		.getExpr();
		Assert.assertNotNull(Expr_303_list);
		Assert.assertEquals(1, Expr_303_list.size());
		//303
		final InclusiveOrExpression InclusiveOrExpression_304_Var
		 = (InclusiveOrExpression)Expr_303_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_304_Var
		);
		final EList<? extends EObject> Expr_304_list = InclusiveOrExpression_304_Var
		.getExpr();
		Assert.assertNotNull(Expr_304_list);
		Assert.assertEquals(1, Expr_304_list.size());
		//304
		final ExclusiveOrExpression ExclusiveOrExpression_305_Var
		 = (ExclusiveOrExpression)Expr_304_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_305_Var
		);
		final EList<? extends EObject> Expr_305_list = ExclusiveOrExpression_305_Var
		.getExpr();
		Assert.assertNotNull(Expr_305_list);
		Assert.assertEquals(1, Expr_305_list.size());
		//305
		final AndExpression AndExpression_306_Var
		 = (AndExpression)Expr_305_list.get(0);
		Assert.assertNotNull(AndExpression_306_Var
		);
		final EList<? extends EObject> Expr_306_list = AndExpression_306_Var
		.getExpr();
		Assert.assertNotNull(Expr_306_list);
		Assert.assertEquals(1, Expr_306_list.size());
		//306
		final EqualityExpression EqualityExpression_307_Var
		 = (EqualityExpression)Expr_306_list.get(0);
		Assert.assertNotNull(EqualityExpression_307_Var
		);
		final EList<? extends EObject> Expr_307_list = EqualityExpression_307_Var
		.getExpr();
		Assert.assertNotNull(Expr_307_list);
		Assert.assertEquals(1, Expr_307_list.size());
		//307
		final RelationalExpression RelationalExpression_308_Var
		 = (RelationalExpression)Expr_307_list.get(0);
		Assert.assertNotNull(RelationalExpression_308_Var
		);
		final EList<? extends EObject> Expr_308_list = RelationalExpression_308_Var
		.getExpr();
		Assert.assertNotNull(Expr_308_list);
		Assert.assertEquals(1, Expr_308_list.size());
		//308
		final ShiftExpression ShiftExpression_309_Var
		 = (ShiftExpression)Expr_308_list.get(0);
		Assert.assertNotNull(ShiftExpression_309_Var
		);
		final EList<? extends EObject> Expr_309_list = ShiftExpression_309_Var
		.getExpr();
		Assert.assertNotNull(Expr_309_list);
		Assert.assertEquals(1, Expr_309_list.size());
		//309
		final AdditiveExpression AdditiveExpression_310_Var
		 = (AdditiveExpression)Expr_309_list.get(0);
		Assert.assertNotNull(AdditiveExpression_310_Var
		);
		final EList<? extends EObject> Expr_310_list = AdditiveExpression_310_Var
		.getExpr();
		Assert.assertNotNull(Expr_310_list);
		Assert.assertEquals(1, Expr_310_list.size());
		//310
		final MultiplicativeExpression MultiplicativeExpression_311_Var
		 = (MultiplicativeExpression)Expr_310_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = MultiplicativeExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final CastExpression CastExpression_312_Var
		 = (CastExpression)Expr_311_list.get(0);
		Assert.assertNotNull(CastExpression_312_Var
		);
		//312
		final UnaryExpression UnaryExpression_313_Var
		 = (UnaryExpression)CastExpression_312_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_313_Var
		);
		//313
		final PostfixExpression PostfixExpression_314_Var
		 = (PostfixExpression)UnaryExpression_313_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = PostfixExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final PrimaryExpression PrimaryExpression_315_Var
		 = (PrimaryExpression)Expr_314_list.get(0);
		Assert.assertNotNull(PrimaryExpression_315_Var
		);
		Assert.assertEquals("out", PrimaryExpression_315_Var
		.getId());
		//315
		final Statement Statement_316_Var
		 = (Statement)Statement_59_list.get(5);
		Assert.assertNotNull(Statement_316_Var
		);
		//316
		final JumpStatement JumpStatement_317_Var
		 = (JumpStatement)Statement_316_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_317_Var
		);
		//317
		final Expression Expression_318_Var
		 = (Expression)JumpStatement_317_Var
		.getExpr();
		Assert.assertNotNull(Expression_318_Var
		);
		final EList<? extends EObject> ExprExpr_318_list = Expression_318_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_318_list);
		Assert.assertEquals(1, ExprExpr_318_list.size());
		//318
		final AssignmentExpression AssignmentExpression_319_Var
		 = (AssignmentExpression)ExprExpr_318_list.get(0);
		Assert.assertNotNull(AssignmentExpression_319_Var
		);
		//319
		final ConditionalExpression ConditionalExpression_320_Var
		 = (ConditionalExpression)AssignmentExpression_319_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_320_Var
		);
		//320
		final LogicalOrExpression LogicalOrExpression_321_Var
		 = (LogicalOrExpression)ConditionalExpression_320_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_321_Var
		);
		final EList<? extends EObject> Expr_321_list = LogicalOrExpression_321_Var
		.getExpr();
		Assert.assertNotNull(Expr_321_list);
		Assert.assertEquals(1, Expr_321_list.size());
		//321
		final LogicalAndExpression LogicalAndExpression_322_Var
		 = (LogicalAndExpression)Expr_321_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_322_Var
		);
		final EList<? extends EObject> Expr_322_list = LogicalAndExpression_322_Var
		.getExpr();
		Assert.assertNotNull(Expr_322_list);
		Assert.assertEquals(1, Expr_322_list.size());
		//322
		final InclusiveOrExpression InclusiveOrExpression_323_Var
		 = (InclusiveOrExpression)Expr_322_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_323_Var
		);
		final EList<? extends EObject> Expr_323_list = InclusiveOrExpression_323_Var
		.getExpr();
		Assert.assertNotNull(Expr_323_list);
		Assert.assertEquals(1, Expr_323_list.size());
		//323
		final ExclusiveOrExpression ExclusiveOrExpression_324_Var
		 = (ExclusiveOrExpression)Expr_323_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_324_Var
		);
		final EList<? extends EObject> Expr_324_list = ExclusiveOrExpression_324_Var
		.getExpr();
		Assert.assertNotNull(Expr_324_list);
		Assert.assertEquals(1, Expr_324_list.size());
		//324
		final AndExpression AndExpression_325_Var
		 = (AndExpression)Expr_324_list.get(0);
		Assert.assertNotNull(AndExpression_325_Var
		);
		final EList<? extends EObject> Expr_325_list = AndExpression_325_Var
		.getExpr();
		Assert.assertNotNull(Expr_325_list);
		Assert.assertEquals(1, Expr_325_list.size());
		//325
		final EqualityExpression EqualityExpression_326_Var
		 = (EqualityExpression)Expr_325_list.get(0);
		Assert.assertNotNull(EqualityExpression_326_Var
		);
		final EList<? extends EObject> Expr_326_list = EqualityExpression_326_Var
		.getExpr();
		Assert.assertNotNull(Expr_326_list);
		Assert.assertEquals(1, Expr_326_list.size());
		//326
		final RelationalExpression RelationalExpression_327_Var
		 = (RelationalExpression)Expr_326_list.get(0);
		Assert.assertNotNull(RelationalExpression_327_Var
		);
		final EList<? extends EObject> Expr_327_list = RelationalExpression_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final ShiftExpression ShiftExpression_328_Var
		 = (ShiftExpression)Expr_327_list.get(0);
		Assert.assertNotNull(ShiftExpression_328_Var
		);
		final EList<? extends EObject> Expr_328_list = ShiftExpression_328_Var
		.getExpr();
		Assert.assertNotNull(Expr_328_list);
		Assert.assertEquals(1, Expr_328_list.size());
		//328
		final AdditiveExpression AdditiveExpression_329_Var
		 = (AdditiveExpression)Expr_328_list.get(0);
		Assert.assertNotNull(AdditiveExpression_329_Var
		);
		final EList<? extends EObject> Expr_329_list = AdditiveExpression_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final MultiplicativeExpression MultiplicativeExpression_330_Var
		 = (MultiplicativeExpression)Expr_329_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_330_Var
		);
		final EList<? extends EObject> Expr_330_list = MultiplicativeExpression_330_Var
		.getExpr();
		Assert.assertNotNull(Expr_330_list);
		Assert.assertEquals(1, Expr_330_list.size());
		//330
		final CastExpression CastExpression_331_Var
		 = (CastExpression)Expr_330_list.get(0);
		Assert.assertNotNull(CastExpression_331_Var
		);
		//331
		final UnaryExpression UnaryExpression_332_Var
		 = (UnaryExpression)CastExpression_331_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_332_Var
		);
		//332
		final PostfixExpression PostfixExpression_333_Var
		 = (PostfixExpression)UnaryExpression_332_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = PostfixExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final PrimaryExpression PrimaryExpression_334_Var
		 = (PrimaryExpression)Expr_333_list.get(0);
		Assert.assertNotNull(PrimaryExpression_334_Var
		);
		//334
		final Constant2 Constant2_335_Var
		 = (Constant2)PrimaryExpression_334_Var
		.getConst();
		Assert.assertNotNull(Constant2_335_Var
		);
		Assert.assertEquals("0", Constant2_335_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_317_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0035_SimpleArray.c");
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
				method.invoke(this.generator, "Test0035_SimpleArray.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0035_SimpleArray.c");
		final String expected = this.getTextFromFile(
			"res/Test0035_SimpleArray.c"
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


