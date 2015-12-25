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
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.common.common.Constant2;
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
	
	@Test
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
	
	@Test
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
		//43
		final Constant2 Constant2_44_Var
		 = (Constant2)PrimaryExpression_43_Var
		.getConst();
		Assert.assertNotNull(Constant2_44_Var
		);
		Assert.assertEquals("\"some output\"", Constant2_44_Var
		.getStr());
		//44
		final ExternalDeclaration ExternalDeclaration_45_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_45_Var
		);
		//45
		final FunctionDefHead FunctionDefHead_46_Var
		 = (FunctionDefHead)ExternalDeclaration_45_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_46_Var
		);
		//46
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_47_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_46_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_47_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_47_list = FunctionDeclarationSpecifiers_47_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_47_list);
		Assert.assertEquals(1, DeclarationSpecifier_47_list.size());
		//47
		final TypeSpecifier TypeSpecifier_48_Var
		 = (TypeSpecifier)DeclarationSpecifier_47_list.get(0);
		Assert.assertNotNull(TypeSpecifier_48_Var
		);
		Assert.assertEquals("int", TypeSpecifier_48_Var
		.getName());
		//48
		final Declarator Declarator_49_Var
		 = (Declarator)FunctionDefHead_46_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_49_Var
		);
		//49
		final DirectDeclarator DirectDeclarator_50_Var
		 = (DirectDeclarator)Declarator_49_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_50_Var
		);
		Assert.assertEquals("main", DirectDeclarator_50_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_50_list = DirectDeclarator_50_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_50_list);
		Assert.assertEquals(1, DeclaratorSuffix_50_list.size());
		//50
		final DeclaratorSuffix DeclaratorSuffix_51_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_50_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_51_Var
		);
		//51
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_52_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_51_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_52_Var
		);
		final EList<? extends EObject> ParameterTypeList_52_list = DirectDeclaratorLastSuffix_52_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_52_list);
		Assert.assertEquals(1, ParameterTypeList_52_list.size());
		//52
		final ParameterTypeList ParameterTypeList_53_Var
		 = (ParameterTypeList)ParameterTypeList_52_list.get(0);
		Assert.assertNotNull(ParameterTypeList_53_Var
		);
		//53
		final ParameterList ParameterList_54_Var
		 = (ParameterList)ParameterTypeList_53_Var
		.getList();
		Assert.assertNotNull(ParameterList_54_Var
		);
		final EList<? extends EObject> ParameterDeclaration_54_list = ParameterList_54_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_54_list);
		Assert.assertEquals(1, ParameterDeclaration_54_list.size());
		//54
		final ParameterDeclaration ParameterDeclaration_55_Var
		 = (ParameterDeclaration)ParameterDeclaration_54_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_55_Var
		);
		//55
		final DeclarationSpecifiers DeclarationSpecifiers_56_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_55_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_56_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_56_list = DeclarationSpecifiers_56_Var
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
		final FunctionDefinition FunctionDefinition_58_Var
		 = (FunctionDefinition)ExternalDeclaration_45_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_58_Var
		);
		//58
		final BodyStatement BodyStatement_59_Var
		 = (BodyStatement)FunctionDefinition_58_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_59_Var
		);
		final EList<? extends EObject> BlockList_59_list = BodyStatement_59_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_59_list);
		Assert.assertEquals(1, BlockList_59_list.size());
		//59
		final BlockList BlockList_60_Var
		 = (BlockList)BlockList_59_list.get(0);
		Assert.assertNotNull(BlockList_60_Var
		);
		final EList<? extends EObject> Statement_60_list = BlockList_60_Var
		.getStatement();
		Assert.assertNotNull(Statement_60_list);
		Assert.assertEquals(6, Statement_60_list.size());
		//60
		final Statement Statement_61_Var
		 = (Statement)Statement_60_list.get(0);
		Assert.assertNotNull(Statement_61_Var
		);
		//61
		final ExpressionStatement ExpressionStatement_62_Var
		 = (ExpressionStatement)Statement_61_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_62_Var
		);
		//62
		final Expression Expression_63_Var
		 = (Expression)ExpressionStatement_62_Var
		.getExpression();
		Assert.assertNotNull(Expression_63_Var
		);
		final EList<? extends EObject> ExprExpr_63_list = Expression_63_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_63_list);
		Assert.assertEquals(1, ExprExpr_63_list.size());
		//63
		final AssignmentExpression AssignmentExpression_64_Var
		 = (AssignmentExpression)ExprExpr_63_list.get(0);
		Assert.assertNotNull(AssignmentExpression_64_Var
		);
		//64
		final ConditionalExpression ConditionalExpression_65_Var
		 = (ConditionalExpression)AssignmentExpression_64_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_65_Var
		);
		//65
		final LogicalOrExpression LogicalOrExpression_66_Var
		 = (LogicalOrExpression)ConditionalExpression_65_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = LogicalOrExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final LogicalAndExpression LogicalAndExpression_67_Var
		 = (LogicalAndExpression)Expr_66_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = LogicalAndExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final InclusiveOrExpression InclusiveOrExpression_68_Var
		 = (InclusiveOrExpression)Expr_67_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = InclusiveOrExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final ExclusiveOrExpression ExclusiveOrExpression_69_Var
		 = (ExclusiveOrExpression)Expr_68_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = ExclusiveOrExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final AndExpression AndExpression_70_Var
		 = (AndExpression)Expr_69_list.get(0);
		Assert.assertNotNull(AndExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = AndExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final EqualityExpression EqualityExpression_71_Var
		 = (EqualityExpression)Expr_70_list.get(0);
		Assert.assertNotNull(EqualityExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = EqualityExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final RelationalExpression RelationalExpression_72_Var
		 = (RelationalExpression)Expr_71_list.get(0);
		Assert.assertNotNull(RelationalExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = RelationalExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final ShiftExpression ShiftExpression_73_Var
		 = (ShiftExpression)Expr_72_list.get(0);
		Assert.assertNotNull(ShiftExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = ShiftExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final AdditiveExpression AdditiveExpression_74_Var
		 = (AdditiveExpression)Expr_73_list.get(0);
		Assert.assertNotNull(AdditiveExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = AdditiveExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final MultiplicativeExpression MultiplicativeExpression_75_Var
		 = (MultiplicativeExpression)Expr_74_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = MultiplicativeExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final CastExpression CastExpression_76_Var
		 = (CastExpression)Expr_75_list.get(0);
		Assert.assertNotNull(CastExpression_76_Var
		);
		//76
		final UnaryExpression UnaryExpression_77_Var
		 = (UnaryExpression)CastExpression_76_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_77_Var
		);
		//77
		final PostfixExpression PostfixExpression_78_Var
		 = (PostfixExpression)UnaryExpression_77_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = PostfixExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final PrimaryExpression PrimaryExpression_79_Var
		 = (PrimaryExpression)Expr_78_list.get(0);
		Assert.assertNotNull(PrimaryExpression_79_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_79_Var
		.getId());
		final EList<? extends EObject> Suffix_79_list = PostfixExpression_78_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_79_list);
		Assert.assertEquals(1, Suffix_79_list.size());
		//79
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_80_Var
		 = (PostfixExpressionSuffixArgument)Suffix_79_list.get(0);
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
		final AssignmentExpression AssignmentExpression_82_Var
		 = (AssignmentExpression)Expr_81_list.get(0);
		Assert.assertNotNull(AssignmentExpression_82_Var
		);
		//82
		final ConditionalExpression ConditionalExpression_83_Var
		 = (ConditionalExpression)AssignmentExpression_82_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_83_Var
		);
		//83
		final LogicalOrExpression LogicalOrExpression_84_Var
		 = (LogicalOrExpression)ConditionalExpression_83_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = LogicalOrExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final LogicalAndExpression LogicalAndExpression_85_Var
		 = (LogicalAndExpression)Expr_84_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = LogicalAndExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final InclusiveOrExpression InclusiveOrExpression_86_Var
		 = (InclusiveOrExpression)Expr_85_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = InclusiveOrExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final ExclusiveOrExpression ExclusiveOrExpression_87_Var
		 = (ExclusiveOrExpression)Expr_86_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = ExclusiveOrExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final AndExpression AndExpression_88_Var
		 = (AndExpression)Expr_87_list.get(0);
		Assert.assertNotNull(AndExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = AndExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final EqualityExpression EqualityExpression_89_Var
		 = (EqualityExpression)Expr_88_list.get(0);
		Assert.assertNotNull(EqualityExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = EqualityExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final RelationalExpression RelationalExpression_90_Var
		 = (RelationalExpression)Expr_89_list.get(0);
		Assert.assertNotNull(RelationalExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = RelationalExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final ShiftExpression ShiftExpression_91_Var
		 = (ShiftExpression)Expr_90_list.get(0);
		Assert.assertNotNull(ShiftExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = ShiftExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final AdditiveExpression AdditiveExpression_92_Var
		 = (AdditiveExpression)Expr_91_list.get(0);
		Assert.assertNotNull(AdditiveExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = AdditiveExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final MultiplicativeExpression MultiplicativeExpression_93_Var
		 = (MultiplicativeExpression)Expr_92_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = MultiplicativeExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final CastExpression CastExpression_94_Var
		 = (CastExpression)Expr_93_list.get(0);
		Assert.assertNotNull(CastExpression_94_Var
		);
		//94
		final UnaryExpression UnaryExpression_95_Var
		 = (UnaryExpression)CastExpression_94_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_95_Var
		);
		//95
		final PostfixExpression PostfixExpression_96_Var
		 = (PostfixExpression)UnaryExpression_95_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = PostfixExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final PrimaryExpression PrimaryExpression_97_Var
		 = (PrimaryExpression)Expr_96_list.get(0);
		Assert.assertNotNull(PrimaryExpression_97_Var
		);
		//97
		final Constant2 Constant2_98_Var
		 = (Constant2)PrimaryExpression_97_Var
		.getConst();
		Assert.assertNotNull(Constant2_98_Var
		);
		Assert.assertEquals("\"%s\\n\"", Constant2_98_Var
		.getStr());
		//98
		final AssignmentExpression AssignmentExpression_99_Var
		 = (AssignmentExpression)Expr_81_list.get(1);
		Assert.assertNotNull(AssignmentExpression_99_Var
		);
		//99
		final ConditionalExpression ConditionalExpression_100_Var
		 = (ConditionalExpression)AssignmentExpression_99_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_100_Var
		);
		//100
		final LogicalOrExpression LogicalOrExpression_101_Var
		 = (LogicalOrExpression)ConditionalExpression_100_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = LogicalOrExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final LogicalAndExpression LogicalAndExpression_102_Var
		 = (LogicalAndExpression)Expr_101_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = LogicalAndExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final InclusiveOrExpression InclusiveOrExpression_103_Var
		 = (InclusiveOrExpression)Expr_102_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = InclusiveOrExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final ExclusiveOrExpression ExclusiveOrExpression_104_Var
		 = (ExclusiveOrExpression)Expr_103_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = ExclusiveOrExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final AndExpression AndExpression_105_Var
		 = (AndExpression)Expr_104_list.get(0);
		Assert.assertNotNull(AndExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = AndExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final EqualityExpression EqualityExpression_106_Var
		 = (EqualityExpression)Expr_105_list.get(0);
		Assert.assertNotNull(EqualityExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = EqualityExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final RelationalExpression RelationalExpression_107_Var
		 = (RelationalExpression)Expr_106_list.get(0);
		Assert.assertNotNull(RelationalExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = RelationalExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final ShiftExpression ShiftExpression_108_Var
		 = (ShiftExpression)Expr_107_list.get(0);
		Assert.assertNotNull(ShiftExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = ShiftExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final AdditiveExpression AdditiveExpression_109_Var
		 = (AdditiveExpression)Expr_108_list.get(0);
		Assert.assertNotNull(AdditiveExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = AdditiveExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final MultiplicativeExpression MultiplicativeExpression_110_Var
		 = (MultiplicativeExpression)Expr_109_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = MultiplicativeExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final CastExpression CastExpression_111_Var
		 = (CastExpression)Expr_110_list.get(0);
		Assert.assertNotNull(CastExpression_111_Var
		);
		//111
		final UnaryExpression UnaryExpression_112_Var
		 = (UnaryExpression)CastExpression_111_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_112_Var
		);
		//112
		final PostfixExpression PostfixExpression_113_Var
		 = (PostfixExpression)UnaryExpression_112_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = PostfixExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final PrimaryExpression PrimaryExpression_114_Var
		 = (PrimaryExpression)Expr_113_list.get(0);
		Assert.assertNotNull(PrimaryExpression_114_Var
		);
		Assert.assertEquals("out", PrimaryExpression_114_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_62_Var
		.getSemi());
		//114
		final Statement Statement_115_Var
		 = (Statement)Statement_60_list.get(1);
		Assert.assertNotNull(Statement_115_Var
		);
		//115
		final ExpressionStatement ExpressionStatement_116_Var
		 = (ExpressionStatement)Statement_115_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_116_Var
		);
		//116
		final Expression Expression_117_Var
		 = (Expression)ExpressionStatement_116_Var
		.getExpression();
		Assert.assertNotNull(Expression_117_Var
		);
		final EList<? extends EObject> ExprExpr_117_list = Expression_117_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_117_list);
		Assert.assertEquals(1, ExprExpr_117_list.size());
		//117
		final AssignmentExpression AssignmentExpression_118_Var
		 = (AssignmentExpression)ExprExpr_117_list.get(0);
		Assert.assertNotNull(AssignmentExpression_118_Var
		);
		//118
		final ConditionalExpression ConditionalExpression_119_Var
		 = (ConditionalExpression)AssignmentExpression_118_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_119_Var
		);
		//119
		final LogicalOrExpression LogicalOrExpression_120_Var
		 = (LogicalOrExpression)ConditionalExpression_119_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = LogicalOrExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final LogicalAndExpression LogicalAndExpression_121_Var
		 = (LogicalAndExpression)Expr_120_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = LogicalAndExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final InclusiveOrExpression InclusiveOrExpression_122_Var
		 = (InclusiveOrExpression)Expr_121_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = InclusiveOrExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final ExclusiveOrExpression ExclusiveOrExpression_123_Var
		 = (ExclusiveOrExpression)Expr_122_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = ExclusiveOrExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final AndExpression AndExpression_124_Var
		 = (AndExpression)Expr_123_list.get(0);
		Assert.assertNotNull(AndExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = AndExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final EqualityExpression EqualityExpression_125_Var
		 = (EqualityExpression)Expr_124_list.get(0);
		Assert.assertNotNull(EqualityExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = EqualityExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final RelationalExpression RelationalExpression_126_Var
		 = (RelationalExpression)Expr_125_list.get(0);
		Assert.assertNotNull(RelationalExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = RelationalExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final ShiftExpression ShiftExpression_127_Var
		 = (ShiftExpression)Expr_126_list.get(0);
		Assert.assertNotNull(ShiftExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = ShiftExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final AdditiveExpression AdditiveExpression_128_Var
		 = (AdditiveExpression)Expr_127_list.get(0);
		Assert.assertNotNull(AdditiveExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = AdditiveExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final MultiplicativeExpression MultiplicativeExpression_129_Var
		 = (MultiplicativeExpression)Expr_128_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = MultiplicativeExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final CastExpression CastExpression_130_Var
		 = (CastExpression)Expr_129_list.get(0);
		Assert.assertNotNull(CastExpression_130_Var
		);
		//130
		final UnaryExpression UnaryExpression_131_Var
		 = (UnaryExpression)CastExpression_130_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_131_Var
		);
		//131
		final PostfixExpression PostfixExpression_132_Var
		 = (PostfixExpression)UnaryExpression_131_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = PostfixExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final PrimaryExpression PrimaryExpression_133_Var
		 = (PrimaryExpression)Expr_132_list.get(0);
		Assert.assertNotNull(PrimaryExpression_133_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_133_Var
		.getId());
		final EList<? extends EObject> Suffix_133_list = PostfixExpression_132_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_133_list);
		Assert.assertEquals(1, Suffix_133_list.size());
		//133
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_134_Var
		 = (PostfixExpressionSuffixArgument)Suffix_133_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_134_Var
		);
		//134
		final ArgumentExpressionList ArgumentExpressionList_135_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_134_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_135_Var
		);
		final EList<? extends EObject> Expr_135_list = ArgumentExpressionList_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(2, Expr_135_list.size());
		//135
		final AssignmentExpression AssignmentExpression_136_Var
		 = (AssignmentExpression)Expr_135_list.get(0);
		Assert.assertNotNull(AssignmentExpression_136_Var
		);
		//136
		final ConditionalExpression ConditionalExpression_137_Var
		 = (ConditionalExpression)AssignmentExpression_136_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_137_Var
		);
		//137
		final LogicalOrExpression LogicalOrExpression_138_Var
		 = (LogicalOrExpression)ConditionalExpression_137_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = LogicalOrExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final LogicalAndExpression LogicalAndExpression_139_Var
		 = (LogicalAndExpression)Expr_138_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = LogicalAndExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final InclusiveOrExpression InclusiveOrExpression_140_Var
		 = (InclusiveOrExpression)Expr_139_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = InclusiveOrExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final ExclusiveOrExpression ExclusiveOrExpression_141_Var
		 = (ExclusiveOrExpression)Expr_140_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = ExclusiveOrExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final AndExpression AndExpression_142_Var
		 = (AndExpression)Expr_141_list.get(0);
		Assert.assertNotNull(AndExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = AndExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final EqualityExpression EqualityExpression_143_Var
		 = (EqualityExpression)Expr_142_list.get(0);
		Assert.assertNotNull(EqualityExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = EqualityExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final RelationalExpression RelationalExpression_144_Var
		 = (RelationalExpression)Expr_143_list.get(0);
		Assert.assertNotNull(RelationalExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = RelationalExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final ShiftExpression ShiftExpression_145_Var
		 = (ShiftExpression)Expr_144_list.get(0);
		Assert.assertNotNull(ShiftExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = ShiftExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final AdditiveExpression AdditiveExpression_146_Var
		 = (AdditiveExpression)Expr_145_list.get(0);
		Assert.assertNotNull(AdditiveExpression_146_Var
		);
		final EList<? extends EObject> Expr_146_list = AdditiveExpression_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final MultiplicativeExpression MultiplicativeExpression_147_Var
		 = (MultiplicativeExpression)Expr_146_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_147_Var
		);
		final EList<? extends EObject> Expr_147_list = MultiplicativeExpression_147_Var
		.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(1, Expr_147_list.size());
		//147
		final CastExpression CastExpression_148_Var
		 = (CastExpression)Expr_147_list.get(0);
		Assert.assertNotNull(CastExpression_148_Var
		);
		//148
		final UnaryExpression UnaryExpression_149_Var
		 = (UnaryExpression)CastExpression_148_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_149_Var
		);
		//149
		final PostfixExpression PostfixExpression_150_Var
		 = (PostfixExpression)UnaryExpression_149_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_150_Var
		);
		final EList<? extends EObject> Expr_150_list = PostfixExpression_150_Var
		.getExpr();
		Assert.assertNotNull(Expr_150_list);
		Assert.assertEquals(1, Expr_150_list.size());
		//150
		final PrimaryExpression PrimaryExpression_151_Var
		 = (PrimaryExpression)Expr_150_list.get(0);
		Assert.assertNotNull(PrimaryExpression_151_Var
		);
		Assert.assertEquals("out", PrimaryExpression_151_Var
		.getId());
		//151
		final AssignmentExpression AssignmentExpression_152_Var
		 = (AssignmentExpression)Expr_135_list.get(1);
		Assert.assertNotNull(AssignmentExpression_152_Var
		);
		//152
		final ConditionalExpression ConditionalExpression_153_Var
		 = (ConditionalExpression)AssignmentExpression_152_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_153_Var
		);
		//153
		final LogicalOrExpression LogicalOrExpression_154_Var
		 = (LogicalOrExpression)ConditionalExpression_153_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_154_Var
		);
		final EList<? extends EObject> Expr_154_list = LogicalOrExpression_154_Var
		.getExpr();
		Assert.assertNotNull(Expr_154_list);
		Assert.assertEquals(1, Expr_154_list.size());
		//154
		final LogicalAndExpression LogicalAndExpression_155_Var
		 = (LogicalAndExpression)Expr_154_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_155_Var
		);
		final EList<? extends EObject> Expr_155_list = LogicalAndExpression_155_Var
		.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		//155
		final InclusiveOrExpression InclusiveOrExpression_156_Var
		 = (InclusiveOrExpression)Expr_155_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_156_Var
		);
		final EList<? extends EObject> Expr_156_list = InclusiveOrExpression_156_Var
		.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		//156
		final ExclusiveOrExpression ExclusiveOrExpression_157_Var
		 = (ExclusiveOrExpression)Expr_156_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = ExclusiveOrExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final AndExpression AndExpression_158_Var
		 = (AndExpression)Expr_157_list.get(0);
		Assert.assertNotNull(AndExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = AndExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final EqualityExpression EqualityExpression_159_Var
		 = (EqualityExpression)Expr_158_list.get(0);
		Assert.assertNotNull(EqualityExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = EqualityExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final RelationalExpression RelationalExpression_160_Var
		 = (RelationalExpression)Expr_159_list.get(0);
		Assert.assertNotNull(RelationalExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = RelationalExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final ShiftExpression ShiftExpression_161_Var
		 = (ShiftExpression)Expr_160_list.get(0);
		Assert.assertNotNull(ShiftExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = ShiftExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final AdditiveExpression AdditiveExpression_162_Var
		 = (AdditiveExpression)Expr_161_list.get(0);
		Assert.assertNotNull(AdditiveExpression_162_Var
		);
		final EList<? extends EObject> Expr_162_list = AdditiveExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		//162
		final MultiplicativeExpression MultiplicativeExpression_163_Var
		 = (MultiplicativeExpression)Expr_162_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_163_Var
		);
		final EList<? extends EObject> Expr_163_list = MultiplicativeExpression_163_Var
		.getExpr();
		Assert.assertNotNull(Expr_163_list);
		Assert.assertEquals(1, Expr_163_list.size());
		//163
		final CastExpression CastExpression_164_Var
		 = (CastExpression)Expr_163_list.get(0);
		Assert.assertNotNull(CastExpression_164_Var
		);
		//164
		final UnaryExpression UnaryExpression_165_Var
		 = (UnaryExpression)CastExpression_164_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_165_Var
		);
		//165
		final PostfixExpression PostfixExpression_166_Var
		 = (PostfixExpression)UnaryExpression_165_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_166_Var
		);
		final EList<? extends EObject> Expr_166_list = PostfixExpression_166_Var
		.getExpr();
		Assert.assertNotNull(Expr_166_list);
		Assert.assertEquals(1, Expr_166_list.size());
		//166
		final PrimaryExpression PrimaryExpression_167_Var
		 = (PrimaryExpression)Expr_166_list.get(0);
		Assert.assertNotNull(PrimaryExpression_167_Var
		);
		//167
		final Constant2 Constant2_168_Var
		 = (Constant2)PrimaryExpression_167_Var
		.getConst();
		Assert.assertNotNull(Constant2_168_Var
		);
		Assert.assertEquals("\"Hello World!\"", Constant2_168_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_116_Var
		.getSemi());
		//168
		final Statement Statement_169_Var
		 = (Statement)Statement_60_list.get(2);
		Assert.assertNotNull(Statement_169_Var
		);
		//169
		final ExpressionStatement ExpressionStatement_170_Var
		 = (ExpressionStatement)Statement_169_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_170_Var
		);
		//170
		final Expression Expression_171_Var
		 = (Expression)ExpressionStatement_170_Var
		.getExpression();
		Assert.assertNotNull(Expression_171_Var
		);
		final EList<? extends EObject> ExprExpr_171_list = Expression_171_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_171_list);
		Assert.assertEquals(1, ExprExpr_171_list.size());
		//171
		final AssignmentExpression AssignmentExpression_172_Var
		 = (AssignmentExpression)ExprExpr_171_list.get(0);
		Assert.assertNotNull(AssignmentExpression_172_Var
		);
		//172
		final ConditionalExpression ConditionalExpression_173_Var
		 = (ConditionalExpression)AssignmentExpression_172_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_173_Var
		);
		//173
		final LogicalOrExpression LogicalOrExpression_174_Var
		 = (LogicalOrExpression)ConditionalExpression_173_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = LogicalOrExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final LogicalAndExpression LogicalAndExpression_175_Var
		 = (LogicalAndExpression)Expr_174_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = LogicalAndExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final InclusiveOrExpression InclusiveOrExpression_176_Var
		 = (InclusiveOrExpression)Expr_175_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = InclusiveOrExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final ExclusiveOrExpression ExclusiveOrExpression_177_Var
		 = (ExclusiveOrExpression)Expr_176_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = ExclusiveOrExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final AndExpression AndExpression_178_Var
		 = (AndExpression)Expr_177_list.get(0);
		Assert.assertNotNull(AndExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = AndExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final EqualityExpression EqualityExpression_179_Var
		 = (EqualityExpression)Expr_178_list.get(0);
		Assert.assertNotNull(EqualityExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = EqualityExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final RelationalExpression RelationalExpression_180_Var
		 = (RelationalExpression)Expr_179_list.get(0);
		Assert.assertNotNull(RelationalExpression_180_Var
		);
		final EList<? extends EObject> Expr_180_list = RelationalExpression_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final ShiftExpression ShiftExpression_181_Var
		 = (ShiftExpression)Expr_180_list.get(0);
		Assert.assertNotNull(ShiftExpression_181_Var
		);
		final EList<? extends EObject> Expr_181_list = ShiftExpression_181_Var
		.getExpr();
		Assert.assertNotNull(Expr_181_list);
		Assert.assertEquals(1, Expr_181_list.size());
		//181
		final AdditiveExpression AdditiveExpression_182_Var
		 = (AdditiveExpression)Expr_181_list.get(0);
		Assert.assertNotNull(AdditiveExpression_182_Var
		);
		final EList<? extends EObject> Expr_182_list = AdditiveExpression_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(1, Expr_182_list.size());
		//182
		final MultiplicativeExpression MultiplicativeExpression_183_Var
		 = (MultiplicativeExpression)Expr_182_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = MultiplicativeExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final CastExpression CastExpression_184_Var
		 = (CastExpression)Expr_183_list.get(0);
		Assert.assertNotNull(CastExpression_184_Var
		);
		//184
		final UnaryExpression UnaryExpression_185_Var
		 = (UnaryExpression)CastExpression_184_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_185_Var
		);
		//185
		final PostfixExpression PostfixExpression_186_Var
		 = (PostfixExpression)UnaryExpression_185_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_186_Var
		);
		final EList<? extends EObject> Expr_186_list = PostfixExpression_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(1, Expr_186_list.size());
		//186
		final PrimaryExpression PrimaryExpression_187_Var
		 = (PrimaryExpression)Expr_186_list.get(0);
		Assert.assertNotNull(PrimaryExpression_187_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_187_Var
		.getId());
		final EList<? extends EObject> Suffix_187_list = PostfixExpression_186_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_187_list);
		Assert.assertEquals(1, Suffix_187_list.size());
		//187
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_188_Var
		 = (PostfixExpressionSuffixArgument)Suffix_187_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_188_Var
		);
		//188
		final ArgumentExpressionList ArgumentExpressionList_189_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_188_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_189_Var
		);
		final EList<? extends EObject> Expr_189_list = ArgumentExpressionList_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(2, Expr_189_list.size());
		//189
		final AssignmentExpression AssignmentExpression_190_Var
		 = (AssignmentExpression)Expr_189_list.get(0);
		Assert.assertNotNull(AssignmentExpression_190_Var
		);
		//190
		final ConditionalExpression ConditionalExpression_191_Var
		 = (ConditionalExpression)AssignmentExpression_190_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_191_Var
		);
		//191
		final LogicalOrExpression LogicalOrExpression_192_Var
		 = (LogicalOrExpression)ConditionalExpression_191_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = LogicalOrExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final LogicalAndExpression LogicalAndExpression_193_Var
		 = (LogicalAndExpression)Expr_192_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = LogicalAndExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final InclusiveOrExpression InclusiveOrExpression_194_Var
		 = (InclusiveOrExpression)Expr_193_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = InclusiveOrExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final ExclusiveOrExpression ExclusiveOrExpression_195_Var
		 = (ExclusiveOrExpression)Expr_194_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = ExclusiveOrExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final AndExpression AndExpression_196_Var
		 = (AndExpression)Expr_195_list.get(0);
		Assert.assertNotNull(AndExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = AndExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final EqualityExpression EqualityExpression_197_Var
		 = (EqualityExpression)Expr_196_list.get(0);
		Assert.assertNotNull(EqualityExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = EqualityExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final RelationalExpression RelationalExpression_198_Var
		 = (RelationalExpression)Expr_197_list.get(0);
		Assert.assertNotNull(RelationalExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = RelationalExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final ShiftExpression ShiftExpression_199_Var
		 = (ShiftExpression)Expr_198_list.get(0);
		Assert.assertNotNull(ShiftExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = ShiftExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final AdditiveExpression AdditiveExpression_200_Var
		 = (AdditiveExpression)Expr_199_list.get(0);
		Assert.assertNotNull(AdditiveExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = AdditiveExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final MultiplicativeExpression MultiplicativeExpression_201_Var
		 = (MultiplicativeExpression)Expr_200_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = MultiplicativeExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final CastExpression CastExpression_202_Var
		 = (CastExpression)Expr_201_list.get(0);
		Assert.assertNotNull(CastExpression_202_Var
		);
		//202
		final UnaryExpression UnaryExpression_203_Var
		 = (UnaryExpression)CastExpression_202_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_203_Var
		);
		//203
		final PostfixExpression PostfixExpression_204_Var
		 = (PostfixExpression)UnaryExpression_203_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = PostfixExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final PrimaryExpression PrimaryExpression_205_Var
		 = (PrimaryExpression)Expr_204_list.get(0);
		Assert.assertNotNull(PrimaryExpression_205_Var
		);
		//205
		final Constant2 Constant2_206_Var
		 = (Constant2)PrimaryExpression_205_Var
		.getConst();
		Assert.assertNotNull(Constant2_206_Var
		);
		Assert.assertEquals("\"%s\\n\"", Constant2_206_Var
		.getStr());
		//206
		final AssignmentExpression AssignmentExpression_207_Var
		 = (AssignmentExpression)Expr_189_list.get(1);
		Assert.assertNotNull(AssignmentExpression_207_Var
		);
		//207
		final ConditionalExpression ConditionalExpression_208_Var
		 = (ConditionalExpression)AssignmentExpression_207_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_208_Var
		);
		//208
		final LogicalOrExpression LogicalOrExpression_209_Var
		 = (LogicalOrExpression)ConditionalExpression_208_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = LogicalOrExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final LogicalAndExpression LogicalAndExpression_210_Var
		 = (LogicalAndExpression)Expr_209_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = LogicalAndExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final InclusiveOrExpression InclusiveOrExpression_211_Var
		 = (InclusiveOrExpression)Expr_210_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = InclusiveOrExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final ExclusiveOrExpression ExclusiveOrExpression_212_Var
		 = (ExclusiveOrExpression)Expr_211_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = ExclusiveOrExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final AndExpression AndExpression_213_Var
		 = (AndExpression)Expr_212_list.get(0);
		Assert.assertNotNull(AndExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = AndExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final EqualityExpression EqualityExpression_214_Var
		 = (EqualityExpression)Expr_213_list.get(0);
		Assert.assertNotNull(EqualityExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = EqualityExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final RelationalExpression RelationalExpression_215_Var
		 = (RelationalExpression)Expr_214_list.get(0);
		Assert.assertNotNull(RelationalExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = RelationalExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final ShiftExpression ShiftExpression_216_Var
		 = (ShiftExpression)Expr_215_list.get(0);
		Assert.assertNotNull(ShiftExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = ShiftExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final AdditiveExpression AdditiveExpression_217_Var
		 = (AdditiveExpression)Expr_216_list.get(0);
		Assert.assertNotNull(AdditiveExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = AdditiveExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final MultiplicativeExpression MultiplicativeExpression_218_Var
		 = (MultiplicativeExpression)Expr_217_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = MultiplicativeExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final CastExpression CastExpression_219_Var
		 = (CastExpression)Expr_218_list.get(0);
		Assert.assertNotNull(CastExpression_219_Var
		);
		//219
		final UnaryExpression UnaryExpression_220_Var
		 = (UnaryExpression)CastExpression_219_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_220_Var
		);
		//220
		final PostfixExpression PostfixExpression_221_Var
		 = (PostfixExpression)UnaryExpression_220_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = PostfixExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final PrimaryExpression PrimaryExpression_222_Var
		 = (PrimaryExpression)Expr_221_list.get(0);
		Assert.assertNotNull(PrimaryExpression_222_Var
		);
		Assert.assertEquals("out", PrimaryExpression_222_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_170_Var
		.getSemi());
		//222
		final Statement Statement_223_Var
		 = (Statement)Statement_60_list.get(3);
		Assert.assertNotNull(Statement_223_Var
		);
		//223
		final ExpressionStatement ExpressionStatement_224_Var
		 = (ExpressionStatement)Statement_223_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_224_Var
		);
		//224
		final Expression Expression_225_Var
		 = (Expression)ExpressionStatement_224_Var
		.getExpression();
		Assert.assertNotNull(Expression_225_Var
		);
		final EList<? extends EObject> ExprExpr_225_list = Expression_225_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_225_list);
		Assert.assertEquals(1, ExprExpr_225_list.size());
		//225
		final AssignmentExpression AssignmentExpression_226_Var
		 = (AssignmentExpression)ExprExpr_225_list.get(0);
		Assert.assertNotNull(AssignmentExpression_226_Var
		);
		//226
		final UnaryExpression UnaryExpression_227_Var
		 = (UnaryExpression)AssignmentExpression_226_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_227_Var
		);
		//227
		final PostfixExpression PostfixExpression_228_Var
		 = (PostfixExpression)UnaryExpression_227_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = PostfixExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final PrimaryExpression PrimaryExpression_229_Var
		 = (PrimaryExpression)Expr_228_list.get(0);
		Assert.assertNotNull(PrimaryExpression_229_Var
		);
		Assert.assertEquals("out", PrimaryExpression_229_Var
		.getId());
		final EList<? extends EObject> Suffix_229_list = PostfixExpression_228_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_229_list);
		Assert.assertEquals(1, Suffix_229_list.size());
		//229
		final PostfixExpressionSuffixArray PostfixExpressionSuffixArray_230_Var
		 = (PostfixExpressionSuffixArray)Suffix_229_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArray_230_Var
		);
		//230
		final Expression Expression_231_Var
		 = (Expression)PostfixExpressionSuffixArray_230_Var
		.getArrayExpr();
		Assert.assertNotNull(Expression_231_Var
		);
		final EList<? extends EObject> ExprExpr_231_list = Expression_231_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_231_list);
		Assert.assertEquals(1, ExprExpr_231_list.size());
		//231
		final AssignmentExpression AssignmentExpression_232_Var
		 = (AssignmentExpression)ExprExpr_231_list.get(0);
		Assert.assertNotNull(AssignmentExpression_232_Var
		);
		//232
		final ConditionalExpression ConditionalExpression_233_Var
		 = (ConditionalExpression)AssignmentExpression_232_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_233_Var
		);
		//233
		final LogicalOrExpression LogicalOrExpression_234_Var
		 = (LogicalOrExpression)ConditionalExpression_233_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = LogicalOrExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final LogicalAndExpression LogicalAndExpression_235_Var
		 = (LogicalAndExpression)Expr_234_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = LogicalAndExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final InclusiveOrExpression InclusiveOrExpression_236_Var
		 = (InclusiveOrExpression)Expr_235_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = InclusiveOrExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final ExclusiveOrExpression ExclusiveOrExpression_237_Var
		 = (ExclusiveOrExpression)Expr_236_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = ExclusiveOrExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final AndExpression AndExpression_238_Var
		 = (AndExpression)Expr_237_list.get(0);
		Assert.assertNotNull(AndExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = AndExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final EqualityExpression EqualityExpression_239_Var
		 = (EqualityExpression)Expr_238_list.get(0);
		Assert.assertNotNull(EqualityExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = EqualityExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final RelationalExpression RelationalExpression_240_Var
		 = (RelationalExpression)Expr_239_list.get(0);
		Assert.assertNotNull(RelationalExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = RelationalExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final ShiftExpression ShiftExpression_241_Var
		 = (ShiftExpression)Expr_240_list.get(0);
		Assert.assertNotNull(ShiftExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = ShiftExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final AdditiveExpression AdditiveExpression_242_Var
		 = (AdditiveExpression)Expr_241_list.get(0);
		Assert.assertNotNull(AdditiveExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = AdditiveExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final MultiplicativeExpression MultiplicativeExpression_243_Var
		 = (MultiplicativeExpression)Expr_242_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = MultiplicativeExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final CastExpression CastExpression_244_Var
		 = (CastExpression)Expr_243_list.get(0);
		Assert.assertNotNull(CastExpression_244_Var
		);
		//244
		final UnaryExpression UnaryExpression_245_Var
		 = (UnaryExpression)CastExpression_244_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_245_Var
		);
		//245
		final PostfixExpression PostfixExpression_246_Var
		 = (PostfixExpression)UnaryExpression_245_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = PostfixExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final PrimaryExpression PrimaryExpression_247_Var
		 = (PrimaryExpression)Expr_246_list.get(0);
		Assert.assertNotNull(PrimaryExpression_247_Var
		);
		//247
		final Constant2 Constant2_248_Var
		 = (Constant2)PrimaryExpression_247_Var
		.getConst();
		Assert.assertNotNull(Constant2_248_Var
		);
		Assert.assertEquals("6", Constant2_248_Var
		.getDec());
		//248
		final AssignmentOperator AssignmentOperator_249_Var
		 = (AssignmentOperator)AssignmentExpression_226_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_249_Var
		);
		Assert.assertEquals("=", AssignmentOperator_249_Var
		.getOp());
		//249
		final AssignmentExpression AssignmentExpression_250_Var
		 = (AssignmentExpression)AssignmentExpression_226_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_250_Var
		);
		//250
		final ConditionalExpression ConditionalExpression_251_Var
		 = (ConditionalExpression)AssignmentExpression_250_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_251_Var
		);
		//251
		final LogicalOrExpression LogicalOrExpression_252_Var
		 = (LogicalOrExpression)ConditionalExpression_251_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_252_Var
		);
		final EList<? extends EObject> Expr_252_list = LogicalOrExpression_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(1, Expr_252_list.size());
		//252
		final LogicalAndExpression LogicalAndExpression_253_Var
		 = (LogicalAndExpression)Expr_252_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = LogicalAndExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final InclusiveOrExpression InclusiveOrExpression_254_Var
		 = (InclusiveOrExpression)Expr_253_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = InclusiveOrExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final ExclusiveOrExpression ExclusiveOrExpression_255_Var
		 = (ExclusiveOrExpression)Expr_254_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_255_Var
		);
		final EList<? extends EObject> Expr_255_list = ExclusiveOrExpression_255_Var
		.getExpr();
		Assert.assertNotNull(Expr_255_list);
		Assert.assertEquals(1, Expr_255_list.size());
		//255
		final AndExpression AndExpression_256_Var
		 = (AndExpression)Expr_255_list.get(0);
		Assert.assertNotNull(AndExpression_256_Var
		);
		final EList<? extends EObject> Expr_256_list = AndExpression_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(1, Expr_256_list.size());
		//256
		final EqualityExpression EqualityExpression_257_Var
		 = (EqualityExpression)Expr_256_list.get(0);
		Assert.assertNotNull(EqualityExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = EqualityExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final RelationalExpression RelationalExpression_258_Var
		 = (RelationalExpression)Expr_257_list.get(0);
		Assert.assertNotNull(RelationalExpression_258_Var
		);
		final EList<? extends EObject> Expr_258_list = RelationalExpression_258_Var
		.getExpr();
		Assert.assertNotNull(Expr_258_list);
		Assert.assertEquals(1, Expr_258_list.size());
		//258
		final ShiftExpression ShiftExpression_259_Var
		 = (ShiftExpression)Expr_258_list.get(0);
		Assert.assertNotNull(ShiftExpression_259_Var
		);
		final EList<? extends EObject> Expr_259_list = ShiftExpression_259_Var
		.getExpr();
		Assert.assertNotNull(Expr_259_list);
		Assert.assertEquals(1, Expr_259_list.size());
		//259
		final AdditiveExpression AdditiveExpression_260_Var
		 = (AdditiveExpression)Expr_259_list.get(0);
		Assert.assertNotNull(AdditiveExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = AdditiveExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final MultiplicativeExpression MultiplicativeExpression_261_Var
		 = (MultiplicativeExpression)Expr_260_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = MultiplicativeExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final CastExpression CastExpression_262_Var
		 = (CastExpression)Expr_261_list.get(0);
		Assert.assertNotNull(CastExpression_262_Var
		);
		//262
		final UnaryExpression UnaryExpression_263_Var
		 = (UnaryExpression)CastExpression_262_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_263_Var
		);
		//263
		final PostfixExpression PostfixExpression_264_Var
		 = (PostfixExpression)UnaryExpression_263_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_264_Var
		);
		final EList<? extends EObject> Expr_264_list = PostfixExpression_264_Var
		.getExpr();
		Assert.assertNotNull(Expr_264_list);
		Assert.assertEquals(1, Expr_264_list.size());
		//264
		final PrimaryExpression PrimaryExpression_265_Var
		 = (PrimaryExpression)Expr_264_list.get(0);
		Assert.assertNotNull(PrimaryExpression_265_Var
		);
		//265
		final Constant2 Constant2_266_Var
		 = (Constant2)PrimaryExpression_265_Var
		.getConst();
		Assert.assertNotNull(Constant2_266_Var
		);
		Assert.assertEquals("'w'", Constant2_266_Var
		.getCh());
		Assert.assertEquals(";", ExpressionStatement_224_Var
		.getSemi());
		//266
		final Statement Statement_267_Var
		 = (Statement)Statement_60_list.get(4);
		Assert.assertNotNull(Statement_267_Var
		);
		//267
		final ExpressionStatement ExpressionStatement_268_Var
		 = (ExpressionStatement)Statement_267_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_268_Var
		);
		//268
		final Expression Expression_269_Var
		 = (Expression)ExpressionStatement_268_Var
		.getExpression();
		Assert.assertNotNull(Expression_269_Var
		);
		final EList<? extends EObject> ExprExpr_269_list = Expression_269_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_269_list);
		Assert.assertEquals(1, ExprExpr_269_list.size());
		//269
		final AssignmentExpression AssignmentExpression_270_Var
		 = (AssignmentExpression)ExprExpr_269_list.get(0);
		Assert.assertNotNull(AssignmentExpression_270_Var
		);
		//270
		final ConditionalExpression ConditionalExpression_271_Var
		 = (ConditionalExpression)AssignmentExpression_270_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_271_Var
		);
		//271
		final LogicalOrExpression LogicalOrExpression_272_Var
		 = (LogicalOrExpression)ConditionalExpression_271_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_272_Var
		);
		final EList<? extends EObject> Expr_272_list = LogicalOrExpression_272_Var
		.getExpr();
		Assert.assertNotNull(Expr_272_list);
		Assert.assertEquals(1, Expr_272_list.size());
		//272
		final LogicalAndExpression LogicalAndExpression_273_Var
		 = (LogicalAndExpression)Expr_272_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_273_Var
		);
		final EList<? extends EObject> Expr_273_list = LogicalAndExpression_273_Var
		.getExpr();
		Assert.assertNotNull(Expr_273_list);
		Assert.assertEquals(1, Expr_273_list.size());
		//273
		final InclusiveOrExpression InclusiveOrExpression_274_Var
		 = (InclusiveOrExpression)Expr_273_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_274_Var
		);
		final EList<? extends EObject> Expr_274_list = InclusiveOrExpression_274_Var
		.getExpr();
		Assert.assertNotNull(Expr_274_list);
		Assert.assertEquals(1, Expr_274_list.size());
		//274
		final ExclusiveOrExpression ExclusiveOrExpression_275_Var
		 = (ExclusiveOrExpression)Expr_274_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_275_Var
		);
		final EList<? extends EObject> Expr_275_list = ExclusiveOrExpression_275_Var
		.getExpr();
		Assert.assertNotNull(Expr_275_list);
		Assert.assertEquals(1, Expr_275_list.size());
		//275
		final AndExpression AndExpression_276_Var
		 = (AndExpression)Expr_275_list.get(0);
		Assert.assertNotNull(AndExpression_276_Var
		);
		final EList<? extends EObject> Expr_276_list = AndExpression_276_Var
		.getExpr();
		Assert.assertNotNull(Expr_276_list);
		Assert.assertEquals(1, Expr_276_list.size());
		//276
		final EqualityExpression EqualityExpression_277_Var
		 = (EqualityExpression)Expr_276_list.get(0);
		Assert.assertNotNull(EqualityExpression_277_Var
		);
		final EList<? extends EObject> Expr_277_list = EqualityExpression_277_Var
		.getExpr();
		Assert.assertNotNull(Expr_277_list);
		Assert.assertEquals(1, Expr_277_list.size());
		//277
		final RelationalExpression RelationalExpression_278_Var
		 = (RelationalExpression)Expr_277_list.get(0);
		Assert.assertNotNull(RelationalExpression_278_Var
		);
		final EList<? extends EObject> Expr_278_list = RelationalExpression_278_Var
		.getExpr();
		Assert.assertNotNull(Expr_278_list);
		Assert.assertEquals(1, Expr_278_list.size());
		//278
		final ShiftExpression ShiftExpression_279_Var
		 = (ShiftExpression)Expr_278_list.get(0);
		Assert.assertNotNull(ShiftExpression_279_Var
		);
		final EList<? extends EObject> Expr_279_list = ShiftExpression_279_Var
		.getExpr();
		Assert.assertNotNull(Expr_279_list);
		Assert.assertEquals(1, Expr_279_list.size());
		//279
		final AdditiveExpression AdditiveExpression_280_Var
		 = (AdditiveExpression)Expr_279_list.get(0);
		Assert.assertNotNull(AdditiveExpression_280_Var
		);
		final EList<? extends EObject> Expr_280_list = AdditiveExpression_280_Var
		.getExpr();
		Assert.assertNotNull(Expr_280_list);
		Assert.assertEquals(1, Expr_280_list.size());
		//280
		final MultiplicativeExpression MultiplicativeExpression_281_Var
		 = (MultiplicativeExpression)Expr_280_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_281_Var
		);
		final EList<? extends EObject> Expr_281_list = MultiplicativeExpression_281_Var
		.getExpr();
		Assert.assertNotNull(Expr_281_list);
		Assert.assertEquals(1, Expr_281_list.size());
		//281
		final CastExpression CastExpression_282_Var
		 = (CastExpression)Expr_281_list.get(0);
		Assert.assertNotNull(CastExpression_282_Var
		);
		//282
		final UnaryExpression UnaryExpression_283_Var
		 = (UnaryExpression)CastExpression_282_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_283_Var
		);
		//283
		final PostfixExpression PostfixExpression_284_Var
		 = (PostfixExpression)UnaryExpression_283_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_284_Var
		);
		final EList<? extends EObject> Expr_284_list = PostfixExpression_284_Var
		.getExpr();
		Assert.assertNotNull(Expr_284_list);
		Assert.assertEquals(1, Expr_284_list.size());
		//284
		final PrimaryExpression PrimaryExpression_285_Var
		 = (PrimaryExpression)Expr_284_list.get(0);
		Assert.assertNotNull(PrimaryExpression_285_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_285_Var
		.getId());
		final EList<? extends EObject> Suffix_285_list = PostfixExpression_284_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_285_list);
		Assert.assertEquals(1, Suffix_285_list.size());
		//285
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_286_Var
		 = (PostfixExpressionSuffixArgument)Suffix_285_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_286_Var
		);
		//286
		final ArgumentExpressionList ArgumentExpressionList_287_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_286_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_287_Var
		);
		final EList<? extends EObject> Expr_287_list = ArgumentExpressionList_287_Var
		.getExpr();
		Assert.assertNotNull(Expr_287_list);
		Assert.assertEquals(2, Expr_287_list.size());
		//287
		final AssignmentExpression AssignmentExpression_288_Var
		 = (AssignmentExpression)Expr_287_list.get(0);
		Assert.assertNotNull(AssignmentExpression_288_Var
		);
		//288
		final ConditionalExpression ConditionalExpression_289_Var
		 = (ConditionalExpression)AssignmentExpression_288_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_289_Var
		);
		//289
		final LogicalOrExpression LogicalOrExpression_290_Var
		 = (LogicalOrExpression)ConditionalExpression_289_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_290_Var
		);
		final EList<? extends EObject> Expr_290_list = LogicalOrExpression_290_Var
		.getExpr();
		Assert.assertNotNull(Expr_290_list);
		Assert.assertEquals(1, Expr_290_list.size());
		//290
		final LogicalAndExpression LogicalAndExpression_291_Var
		 = (LogicalAndExpression)Expr_290_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_291_Var
		);
		final EList<? extends EObject> Expr_291_list = LogicalAndExpression_291_Var
		.getExpr();
		Assert.assertNotNull(Expr_291_list);
		Assert.assertEquals(1, Expr_291_list.size());
		//291
		final InclusiveOrExpression InclusiveOrExpression_292_Var
		 = (InclusiveOrExpression)Expr_291_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_292_Var
		);
		final EList<? extends EObject> Expr_292_list = InclusiveOrExpression_292_Var
		.getExpr();
		Assert.assertNotNull(Expr_292_list);
		Assert.assertEquals(1, Expr_292_list.size());
		//292
		final ExclusiveOrExpression ExclusiveOrExpression_293_Var
		 = (ExclusiveOrExpression)Expr_292_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = ExclusiveOrExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final AndExpression AndExpression_294_Var
		 = (AndExpression)Expr_293_list.get(0);
		Assert.assertNotNull(AndExpression_294_Var
		);
		final EList<? extends EObject> Expr_294_list = AndExpression_294_Var
		.getExpr();
		Assert.assertNotNull(Expr_294_list);
		Assert.assertEquals(1, Expr_294_list.size());
		//294
		final EqualityExpression EqualityExpression_295_Var
		 = (EqualityExpression)Expr_294_list.get(0);
		Assert.assertNotNull(EqualityExpression_295_Var
		);
		final EList<? extends EObject> Expr_295_list = EqualityExpression_295_Var
		.getExpr();
		Assert.assertNotNull(Expr_295_list);
		Assert.assertEquals(1, Expr_295_list.size());
		//295
		final RelationalExpression RelationalExpression_296_Var
		 = (RelationalExpression)Expr_295_list.get(0);
		Assert.assertNotNull(RelationalExpression_296_Var
		);
		final EList<? extends EObject> Expr_296_list = RelationalExpression_296_Var
		.getExpr();
		Assert.assertNotNull(Expr_296_list);
		Assert.assertEquals(1, Expr_296_list.size());
		//296
		final ShiftExpression ShiftExpression_297_Var
		 = (ShiftExpression)Expr_296_list.get(0);
		Assert.assertNotNull(ShiftExpression_297_Var
		);
		final EList<? extends EObject> Expr_297_list = ShiftExpression_297_Var
		.getExpr();
		Assert.assertNotNull(Expr_297_list);
		Assert.assertEquals(1, Expr_297_list.size());
		//297
		final AdditiveExpression AdditiveExpression_298_Var
		 = (AdditiveExpression)Expr_297_list.get(0);
		Assert.assertNotNull(AdditiveExpression_298_Var
		);
		final EList<? extends EObject> Expr_298_list = AdditiveExpression_298_Var
		.getExpr();
		Assert.assertNotNull(Expr_298_list);
		Assert.assertEquals(1, Expr_298_list.size());
		//298
		final MultiplicativeExpression MultiplicativeExpression_299_Var
		 = (MultiplicativeExpression)Expr_298_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_299_Var
		);
		final EList<? extends EObject> Expr_299_list = MultiplicativeExpression_299_Var
		.getExpr();
		Assert.assertNotNull(Expr_299_list);
		Assert.assertEquals(1, Expr_299_list.size());
		//299
		final CastExpression CastExpression_300_Var
		 = (CastExpression)Expr_299_list.get(0);
		Assert.assertNotNull(CastExpression_300_Var
		);
		//300
		final UnaryExpression UnaryExpression_301_Var
		 = (UnaryExpression)CastExpression_300_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_301_Var
		);
		//301
		final PostfixExpression PostfixExpression_302_Var
		 = (PostfixExpression)UnaryExpression_301_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_302_Var
		);
		final EList<? extends EObject> Expr_302_list = PostfixExpression_302_Var
		.getExpr();
		Assert.assertNotNull(Expr_302_list);
		Assert.assertEquals(1, Expr_302_list.size());
		//302
		final PrimaryExpression PrimaryExpression_303_Var
		 = (PrimaryExpression)Expr_302_list.get(0);
		Assert.assertNotNull(PrimaryExpression_303_Var
		);
		//303
		final Constant2 Constant2_304_Var
		 = (Constant2)PrimaryExpression_303_Var
		.getConst();
		Assert.assertNotNull(Constant2_304_Var
		);
		Assert.assertEquals("\"%s\\n\"", Constant2_304_Var
		.getStr());
		//304
		final AssignmentExpression AssignmentExpression_305_Var
		 = (AssignmentExpression)Expr_287_list.get(1);
		Assert.assertNotNull(AssignmentExpression_305_Var
		);
		//305
		final ConditionalExpression ConditionalExpression_306_Var
		 = (ConditionalExpression)AssignmentExpression_305_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_306_Var
		);
		//306
		final LogicalOrExpression LogicalOrExpression_307_Var
		 = (LogicalOrExpression)ConditionalExpression_306_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_307_Var
		);
		final EList<? extends EObject> Expr_307_list = LogicalOrExpression_307_Var
		.getExpr();
		Assert.assertNotNull(Expr_307_list);
		Assert.assertEquals(1, Expr_307_list.size());
		//307
		final LogicalAndExpression LogicalAndExpression_308_Var
		 = (LogicalAndExpression)Expr_307_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_308_Var
		);
		final EList<? extends EObject> Expr_308_list = LogicalAndExpression_308_Var
		.getExpr();
		Assert.assertNotNull(Expr_308_list);
		Assert.assertEquals(1, Expr_308_list.size());
		//308
		final InclusiveOrExpression InclusiveOrExpression_309_Var
		 = (InclusiveOrExpression)Expr_308_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_309_Var
		);
		final EList<? extends EObject> Expr_309_list = InclusiveOrExpression_309_Var
		.getExpr();
		Assert.assertNotNull(Expr_309_list);
		Assert.assertEquals(1, Expr_309_list.size());
		//309
		final ExclusiveOrExpression ExclusiveOrExpression_310_Var
		 = (ExclusiveOrExpression)Expr_309_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_310_Var
		);
		final EList<? extends EObject> Expr_310_list = ExclusiveOrExpression_310_Var
		.getExpr();
		Assert.assertNotNull(Expr_310_list);
		Assert.assertEquals(1, Expr_310_list.size());
		//310
		final AndExpression AndExpression_311_Var
		 = (AndExpression)Expr_310_list.get(0);
		Assert.assertNotNull(AndExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = AndExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final EqualityExpression EqualityExpression_312_Var
		 = (EqualityExpression)Expr_311_list.get(0);
		Assert.assertNotNull(EqualityExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = EqualityExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final RelationalExpression RelationalExpression_313_Var
		 = (RelationalExpression)Expr_312_list.get(0);
		Assert.assertNotNull(RelationalExpression_313_Var
		);
		final EList<? extends EObject> Expr_313_list = RelationalExpression_313_Var
		.getExpr();
		Assert.assertNotNull(Expr_313_list);
		Assert.assertEquals(1, Expr_313_list.size());
		//313
		final ShiftExpression ShiftExpression_314_Var
		 = (ShiftExpression)Expr_313_list.get(0);
		Assert.assertNotNull(ShiftExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = ShiftExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final AdditiveExpression AdditiveExpression_315_Var
		 = (AdditiveExpression)Expr_314_list.get(0);
		Assert.assertNotNull(AdditiveExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = AdditiveExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final MultiplicativeExpression MultiplicativeExpression_316_Var
		 = (MultiplicativeExpression)Expr_315_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_316_Var
		);
		final EList<? extends EObject> Expr_316_list = MultiplicativeExpression_316_Var
		.getExpr();
		Assert.assertNotNull(Expr_316_list);
		Assert.assertEquals(1, Expr_316_list.size());
		//316
		final CastExpression CastExpression_317_Var
		 = (CastExpression)Expr_316_list.get(0);
		Assert.assertNotNull(CastExpression_317_Var
		);
		//317
		final UnaryExpression UnaryExpression_318_Var
		 = (UnaryExpression)CastExpression_317_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_318_Var
		);
		//318
		final PostfixExpression PostfixExpression_319_Var
		 = (PostfixExpression)UnaryExpression_318_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_319_Var
		);
		final EList<? extends EObject> Expr_319_list = PostfixExpression_319_Var
		.getExpr();
		Assert.assertNotNull(Expr_319_list);
		Assert.assertEquals(1, Expr_319_list.size());
		//319
		final PrimaryExpression PrimaryExpression_320_Var
		 = (PrimaryExpression)Expr_319_list.get(0);
		Assert.assertNotNull(PrimaryExpression_320_Var
		);
		Assert.assertEquals("out", PrimaryExpression_320_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_268_Var
		.getSemi());
		//320
		final Statement Statement_321_Var
		 = (Statement)Statement_60_list.get(5);
		Assert.assertNotNull(Statement_321_Var
		);
		//321
		final JumpStatement JumpStatement_322_Var
		 = (JumpStatement)Statement_321_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_322_Var
		);
		//322
		final Expression Expression_323_Var
		 = (Expression)JumpStatement_322_Var
		.getExpr();
		Assert.assertNotNull(Expression_323_Var
		);
		final EList<? extends EObject> ExprExpr_323_list = Expression_323_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_323_list);
		Assert.assertEquals(1, ExprExpr_323_list.size());
		//323
		final AssignmentExpression AssignmentExpression_324_Var
		 = (AssignmentExpression)ExprExpr_323_list.get(0);
		Assert.assertNotNull(AssignmentExpression_324_Var
		);
		//324
		final ConditionalExpression ConditionalExpression_325_Var
		 = (ConditionalExpression)AssignmentExpression_324_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_325_Var
		);
		//325
		final LogicalOrExpression LogicalOrExpression_326_Var
		 = (LogicalOrExpression)ConditionalExpression_325_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_326_Var
		);
		final EList<? extends EObject> Expr_326_list = LogicalOrExpression_326_Var
		.getExpr();
		Assert.assertNotNull(Expr_326_list);
		Assert.assertEquals(1, Expr_326_list.size());
		//326
		final LogicalAndExpression LogicalAndExpression_327_Var
		 = (LogicalAndExpression)Expr_326_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_327_Var
		);
		final EList<? extends EObject> Expr_327_list = LogicalAndExpression_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final InclusiveOrExpression InclusiveOrExpression_328_Var
		 = (InclusiveOrExpression)Expr_327_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_328_Var
		);
		final EList<? extends EObject> Expr_328_list = InclusiveOrExpression_328_Var
		.getExpr();
		Assert.assertNotNull(Expr_328_list);
		Assert.assertEquals(1, Expr_328_list.size());
		//328
		final ExclusiveOrExpression ExclusiveOrExpression_329_Var
		 = (ExclusiveOrExpression)Expr_328_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_329_Var
		);
		final EList<? extends EObject> Expr_329_list = ExclusiveOrExpression_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final AndExpression AndExpression_330_Var
		 = (AndExpression)Expr_329_list.get(0);
		Assert.assertNotNull(AndExpression_330_Var
		);
		final EList<? extends EObject> Expr_330_list = AndExpression_330_Var
		.getExpr();
		Assert.assertNotNull(Expr_330_list);
		Assert.assertEquals(1, Expr_330_list.size());
		//330
		final EqualityExpression EqualityExpression_331_Var
		 = (EqualityExpression)Expr_330_list.get(0);
		Assert.assertNotNull(EqualityExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = EqualityExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final RelationalExpression RelationalExpression_332_Var
		 = (RelationalExpression)Expr_331_list.get(0);
		Assert.assertNotNull(RelationalExpression_332_Var
		);
		final EList<? extends EObject> Expr_332_list = RelationalExpression_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final ShiftExpression ShiftExpression_333_Var
		 = (ShiftExpression)Expr_332_list.get(0);
		Assert.assertNotNull(ShiftExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = ShiftExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final AdditiveExpression AdditiveExpression_334_Var
		 = (AdditiveExpression)Expr_333_list.get(0);
		Assert.assertNotNull(AdditiveExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = AdditiveExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final MultiplicativeExpression MultiplicativeExpression_335_Var
		 = (MultiplicativeExpression)Expr_334_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = MultiplicativeExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final CastExpression CastExpression_336_Var
		 = (CastExpression)Expr_335_list.get(0);
		Assert.assertNotNull(CastExpression_336_Var
		);
		//336
		final UnaryExpression UnaryExpression_337_Var
		 = (UnaryExpression)CastExpression_336_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_337_Var
		);
		//337
		final PostfixExpression PostfixExpression_338_Var
		 = (PostfixExpression)UnaryExpression_337_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = PostfixExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final PrimaryExpression PrimaryExpression_339_Var
		 = (PrimaryExpression)Expr_338_list.get(0);
		Assert.assertNotNull(PrimaryExpression_339_Var
		);
		//339
		final Constant2 Constant2_340_Var
		 = (Constant2)PrimaryExpression_339_Var
		.getConst();
		Assert.assertNotNull(Constant2_340_Var
		);
		Assert.assertEquals("0", Constant2_340_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_322_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_322_Var
		.getSemi());
	}
	
	@Test
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


