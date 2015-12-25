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

import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.common.common.TranslationUnit;
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
	private ParseHelper<Model> parseHelper;
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
		final Model Model_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(Model_0_Var
		);
		
		Assert.assertNotNull(Model_0_Var
		);
		final EList<? extends EObject> Units_0_list = Model_0_Var
		.getUnits();
		Assert.assertNotNull(Units_0_list);
		Assert.assertEquals(1, Units_0_list.size());
		//0
		final TranslationUnit TranslationUnit_1_Var
		 = (TranslationUnit)Units_0_list.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var
		);
		//1
		final Parser Parser_2_Var
		 = (Parser)TranslationUnit_1_Var
		.getParser();
		Assert.assertNotNull(Parser_2_Var
		);
		final EList<? extends EObject> External_2_list = Parser_2_Var
		.getExternal();
		Assert.assertNotNull(External_2_list);
		Assert.assertEquals(2, External_2_list.size());
		//2
		final ExternalDeclaration ExternalDeclaration_3_Var
		 = (ExternalDeclaration)External_2_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_3_Var
		);
		//3
		final Declaration Declaration_4_Var
		 = (Declaration)ExternalDeclaration_3_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_4_Var
		);
		//4
		final DeclarationSpecifiers DeclarationSpecifiers_5_Var
		 = (DeclarationSpecifiers)Declaration_4_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_5_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_5_list = DeclarationSpecifiers_5_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_5_list);
		Assert.assertEquals(1, DeclarationSpecifier_5_list.size());
		//5
		final TypeSpecifier TypeSpecifier_6_Var
		 = (TypeSpecifier)DeclarationSpecifier_5_list.get(0);
		Assert.assertNotNull(TypeSpecifier_6_Var
		);
		Assert.assertEquals("char", TypeSpecifier_6_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_6_list = Declaration_4_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_6_list);
		Assert.assertEquals(1, InitDeclaratorList_6_list.size());
		//6
		final InitDeclaratorList InitDeclaratorList_7_Var
		 = (InitDeclaratorList)InitDeclaratorList_6_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_7_Var
		);
		final EList<? extends EObject> InitDeclarator_7_list = InitDeclaratorList_7_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_7_list);
		Assert.assertEquals(1, InitDeclarator_7_list.size());
		//7
		final InitDeclarator InitDeclarator_8_Var
		 = (InitDeclarator)InitDeclarator_7_list.get(0);
		Assert.assertNotNull(InitDeclarator_8_Var
		);
		//8
		final Declarator Declarator_9_Var
		 = (Declarator)InitDeclarator_8_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_9_Var
		);
		//9
		final DirectDeclarator DirectDeclarator_10_Var
		 = (DirectDeclarator)Declarator_9_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_10_Var
		);
		Assert.assertEquals("out", DirectDeclarator_10_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_10_list = DirectDeclarator_10_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_10_list);
		Assert.assertEquals(1, DeclaratorSuffix_10_list.size());
		//10
		final DeclaratorSuffix DeclaratorSuffix_11_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_10_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_11_Var
		);
		//11
		final AssignmentExpression AssignmentExpression_12_Var
		 = (AssignmentExpression)DeclaratorSuffix_11_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_12_Var
		);
		//12
		final ConditionalExpression ConditionalExpression_13_Var
		 = (ConditionalExpression)AssignmentExpression_12_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_13_Var
		);
		//13
		final LogicalOrExpression LogicalOrExpression_14_Var
		 = (LogicalOrExpression)ConditionalExpression_13_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = LogicalOrExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		//14
		final LogicalAndExpression LogicalAndExpression_15_Var
		 = (LogicalAndExpression)Expr_14_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = LogicalAndExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final InclusiveOrExpression InclusiveOrExpression_16_Var
		 = (InclusiveOrExpression)Expr_15_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = InclusiveOrExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final ExclusiveOrExpression ExclusiveOrExpression_17_Var
		 = (ExclusiveOrExpression)Expr_16_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = ExclusiveOrExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final AndExpression AndExpression_18_Var
		 = (AndExpression)Expr_17_list.get(0);
		Assert.assertNotNull(AndExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = AndExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final EqualityExpression EqualityExpression_19_Var
		 = (EqualityExpression)Expr_18_list.get(0);
		Assert.assertNotNull(EqualityExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = EqualityExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final RelationalExpression RelationalExpression_20_Var
		 = (RelationalExpression)Expr_19_list.get(0);
		Assert.assertNotNull(RelationalExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = RelationalExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final ShiftExpression ShiftExpression_21_Var
		 = (ShiftExpression)Expr_20_list.get(0);
		Assert.assertNotNull(ShiftExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = ShiftExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final AdditiveExpression AdditiveExpression_22_Var
		 = (AdditiveExpression)Expr_21_list.get(0);
		Assert.assertNotNull(AdditiveExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = AdditiveExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final MultiplicativeExpression MultiplicativeExpression_23_Var
		 = (MultiplicativeExpression)Expr_22_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = MultiplicativeExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final CastExpression CastExpression_24_Var
		 = (CastExpression)Expr_23_list.get(0);
		Assert.assertNotNull(CastExpression_24_Var
		);
		//24
		final UnaryExpression UnaryExpression_25_Var
		 = (UnaryExpression)CastExpression_24_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_25_Var
		);
		//25
		final PostfixExpression PostfixExpression_26_Var
		 = (PostfixExpression)UnaryExpression_25_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = PostfixExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final PrimaryExpression PrimaryExpression_27_Var
		 = (PrimaryExpression)Expr_26_list.get(0);
		Assert.assertNotNull(PrimaryExpression_27_Var
		);
		//27
		final Constant2 Constant2_28_Var
		 = (Constant2)PrimaryExpression_27_Var
		.getConst();
		Assert.assertNotNull(Constant2_28_Var
		);
		Assert.assertEquals("255", Constant2_28_Var
		.getDec());
		//28
		final Initializer Initializer_29_Var
		 = (Initializer)InitDeclarator_8_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_29_Var
		);
		//29
		final AssignmentExpression AssignmentExpression_30_Var
		 = (AssignmentExpression)Initializer_29_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_30_Var
		);
		//30
		final ConditionalExpression ConditionalExpression_31_Var
		 = (ConditionalExpression)AssignmentExpression_30_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_31_Var
		);
		//31
		final LogicalOrExpression LogicalOrExpression_32_Var
		 = (LogicalOrExpression)ConditionalExpression_31_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = LogicalOrExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final LogicalAndExpression LogicalAndExpression_33_Var
		 = (LogicalAndExpression)Expr_32_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = LogicalAndExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final InclusiveOrExpression InclusiveOrExpression_34_Var
		 = (InclusiveOrExpression)Expr_33_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = InclusiveOrExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final ExclusiveOrExpression ExclusiveOrExpression_35_Var
		 = (ExclusiveOrExpression)Expr_34_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = ExclusiveOrExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final AndExpression AndExpression_36_Var
		 = (AndExpression)Expr_35_list.get(0);
		Assert.assertNotNull(AndExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = AndExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final EqualityExpression EqualityExpression_37_Var
		 = (EqualityExpression)Expr_36_list.get(0);
		Assert.assertNotNull(EqualityExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = EqualityExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final RelationalExpression RelationalExpression_38_Var
		 = (RelationalExpression)Expr_37_list.get(0);
		Assert.assertNotNull(RelationalExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = RelationalExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final ShiftExpression ShiftExpression_39_Var
		 = (ShiftExpression)Expr_38_list.get(0);
		Assert.assertNotNull(ShiftExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = ShiftExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final AdditiveExpression AdditiveExpression_40_Var
		 = (AdditiveExpression)Expr_39_list.get(0);
		Assert.assertNotNull(AdditiveExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = AdditiveExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final MultiplicativeExpression MultiplicativeExpression_41_Var
		 = (MultiplicativeExpression)Expr_40_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = MultiplicativeExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final CastExpression CastExpression_42_Var
		 = (CastExpression)Expr_41_list.get(0);
		Assert.assertNotNull(CastExpression_42_Var
		);
		//42
		final UnaryExpression UnaryExpression_43_Var
		 = (UnaryExpression)CastExpression_42_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_43_Var
		);
		//43
		final PostfixExpression PostfixExpression_44_Var
		 = (PostfixExpression)UnaryExpression_43_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = PostfixExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final PrimaryExpression PrimaryExpression_45_Var
		 = (PrimaryExpression)Expr_44_list.get(0);
		Assert.assertNotNull(PrimaryExpression_45_Var
		);
		//45
		final Constant2 Constant2_46_Var
		 = (Constant2)PrimaryExpression_45_Var
		.getConst();
		Assert.assertNotNull(Constant2_46_Var
		);
		Assert.assertEquals("\"some output\"", Constant2_46_Var
		.getStr());
		//46
		final ExternalDeclaration ExternalDeclaration_47_Var
		 = (ExternalDeclaration)External_2_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_47_Var
		);
		//47
		final FunctionDefHead FunctionDefHead_48_Var
		 = (FunctionDefHead)ExternalDeclaration_47_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_48_Var
		);
		//48
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_49_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_48_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_49_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_49_list = FunctionDeclarationSpecifiers_49_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_49_list);
		Assert.assertEquals(1, DeclarationSpecifier_49_list.size());
		//49
		final TypeSpecifier TypeSpecifier_50_Var
		 = (TypeSpecifier)DeclarationSpecifier_49_list.get(0);
		Assert.assertNotNull(TypeSpecifier_50_Var
		);
		Assert.assertEquals("int", TypeSpecifier_50_Var
		.getName());
		//50
		final Declarator Declarator_51_Var
		 = (Declarator)FunctionDefHead_48_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_51_Var
		);
		//51
		final DirectDeclarator DirectDeclarator_52_Var
		 = (DirectDeclarator)Declarator_51_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_52_Var
		);
		Assert.assertEquals("main", DirectDeclarator_52_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_52_list = DirectDeclarator_52_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_52_list);
		Assert.assertEquals(1, DeclaratorSuffix_52_list.size());
		//52
		final DeclaratorSuffix DeclaratorSuffix_53_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_52_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_53_Var
		);
		//53
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_54_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_53_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_54_Var
		);
		final EList<? extends EObject> ParameterTypeList_54_list = DirectDeclaratorLastSuffix_54_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_54_list);
		Assert.assertEquals(1, ParameterTypeList_54_list.size());
		//54
		final ParameterTypeList ParameterTypeList_55_Var
		 = (ParameterTypeList)ParameterTypeList_54_list.get(0);
		Assert.assertNotNull(ParameterTypeList_55_Var
		);
		//55
		final ParameterList ParameterList_56_Var
		 = (ParameterList)ParameterTypeList_55_Var
		.getList();
		Assert.assertNotNull(ParameterList_56_Var
		);
		final EList<? extends EObject> ParameterDeclaration_56_list = ParameterList_56_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_56_list);
		Assert.assertEquals(1, ParameterDeclaration_56_list.size());
		//56
		final ParameterDeclaration ParameterDeclaration_57_Var
		 = (ParameterDeclaration)ParameterDeclaration_56_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_57_Var
		);
		//57
		final DeclarationSpecifiers DeclarationSpecifiers_58_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_57_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_58_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_58_list = DeclarationSpecifiers_58_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_58_list);
		Assert.assertEquals(1, DeclarationSpecifier_58_list.size());
		//58
		final TypeSpecifier TypeSpecifier_59_Var
		 = (TypeSpecifier)DeclarationSpecifier_58_list.get(0);
		Assert.assertNotNull(TypeSpecifier_59_Var
		);
		Assert.assertEquals("void", TypeSpecifier_59_Var
		.getName());
		//59
		final FunctionDefinition FunctionDefinition_60_Var
		 = (FunctionDefinition)ExternalDeclaration_47_Var
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
		Assert.assertEquals(6, Statement_62_list.size());
		//62
		final Statement Statement_63_Var
		 = (Statement)Statement_62_list.get(0);
		Assert.assertNotNull(Statement_63_Var
		);
		//63
		final ExpressionStatement ExpressionStatement_64_Var
		 = (ExpressionStatement)Statement_63_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_64_Var
		);
		//64
		final Expression Expression_65_Var
		 = (Expression)ExpressionStatement_64_Var
		.getExpression();
		Assert.assertNotNull(Expression_65_Var
		);
		final EList<? extends EObject> ExprExpr_65_list = Expression_65_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_65_list);
		Assert.assertEquals(1, ExprExpr_65_list.size());
		//65
		final AssignmentExpression AssignmentExpression_66_Var
		 = (AssignmentExpression)ExprExpr_65_list.get(0);
		Assert.assertNotNull(AssignmentExpression_66_Var
		);
		//66
		final ConditionalExpression ConditionalExpression_67_Var
		 = (ConditionalExpression)AssignmentExpression_66_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_67_Var
		);
		//67
		final LogicalOrExpression LogicalOrExpression_68_Var
		 = (LogicalOrExpression)ConditionalExpression_67_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = LogicalOrExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final LogicalAndExpression LogicalAndExpression_69_Var
		 = (LogicalAndExpression)Expr_68_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = LogicalAndExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final InclusiveOrExpression InclusiveOrExpression_70_Var
		 = (InclusiveOrExpression)Expr_69_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = InclusiveOrExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final ExclusiveOrExpression ExclusiveOrExpression_71_Var
		 = (ExclusiveOrExpression)Expr_70_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = ExclusiveOrExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final AndExpression AndExpression_72_Var
		 = (AndExpression)Expr_71_list.get(0);
		Assert.assertNotNull(AndExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = AndExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final EqualityExpression EqualityExpression_73_Var
		 = (EqualityExpression)Expr_72_list.get(0);
		Assert.assertNotNull(EqualityExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = EqualityExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final RelationalExpression RelationalExpression_74_Var
		 = (RelationalExpression)Expr_73_list.get(0);
		Assert.assertNotNull(RelationalExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = RelationalExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final ShiftExpression ShiftExpression_75_Var
		 = (ShiftExpression)Expr_74_list.get(0);
		Assert.assertNotNull(ShiftExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = ShiftExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final AdditiveExpression AdditiveExpression_76_Var
		 = (AdditiveExpression)Expr_75_list.get(0);
		Assert.assertNotNull(AdditiveExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = AdditiveExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final MultiplicativeExpression MultiplicativeExpression_77_Var
		 = (MultiplicativeExpression)Expr_76_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = MultiplicativeExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final CastExpression CastExpression_78_Var
		 = (CastExpression)Expr_77_list.get(0);
		Assert.assertNotNull(CastExpression_78_Var
		);
		//78
		final UnaryExpression UnaryExpression_79_Var
		 = (UnaryExpression)CastExpression_78_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_79_Var
		);
		//79
		final PostfixExpression PostfixExpression_80_Var
		 = (PostfixExpression)UnaryExpression_79_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = PostfixExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final PrimaryExpression PrimaryExpression_81_Var
		 = (PrimaryExpression)Expr_80_list.get(0);
		Assert.assertNotNull(PrimaryExpression_81_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_81_Var
		.getId());
		final EList<? extends EObject> Suffix_81_list = PostfixExpression_80_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_81_list);
		Assert.assertEquals(1, Suffix_81_list.size());
		//81
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_82_Var
		 = (PostfixExpressionSuffixArgument)Suffix_81_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_82_Var
		);
		//82
		final ArgumentExpressionList ArgumentExpressionList_83_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_82_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_83_Var
		);
		final EList<? extends EObject> Expr_83_list = ArgumentExpressionList_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(2, Expr_83_list.size());
		//83
		final AssignmentExpression AssignmentExpression_84_Var
		 = (AssignmentExpression)Expr_83_list.get(0);
		Assert.assertNotNull(AssignmentExpression_84_Var
		);
		//84
		final ConditionalExpression ConditionalExpression_85_Var
		 = (ConditionalExpression)AssignmentExpression_84_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_85_Var
		);
		//85
		final LogicalOrExpression LogicalOrExpression_86_Var
		 = (LogicalOrExpression)ConditionalExpression_85_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = LogicalOrExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final LogicalAndExpression LogicalAndExpression_87_Var
		 = (LogicalAndExpression)Expr_86_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = LogicalAndExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final InclusiveOrExpression InclusiveOrExpression_88_Var
		 = (InclusiveOrExpression)Expr_87_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = InclusiveOrExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final ExclusiveOrExpression ExclusiveOrExpression_89_Var
		 = (ExclusiveOrExpression)Expr_88_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = ExclusiveOrExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final AndExpression AndExpression_90_Var
		 = (AndExpression)Expr_89_list.get(0);
		Assert.assertNotNull(AndExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = AndExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final EqualityExpression EqualityExpression_91_Var
		 = (EqualityExpression)Expr_90_list.get(0);
		Assert.assertNotNull(EqualityExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = EqualityExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final RelationalExpression RelationalExpression_92_Var
		 = (RelationalExpression)Expr_91_list.get(0);
		Assert.assertNotNull(RelationalExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = RelationalExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final ShiftExpression ShiftExpression_93_Var
		 = (ShiftExpression)Expr_92_list.get(0);
		Assert.assertNotNull(ShiftExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = ShiftExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final AdditiveExpression AdditiveExpression_94_Var
		 = (AdditiveExpression)Expr_93_list.get(0);
		Assert.assertNotNull(AdditiveExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = AdditiveExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final MultiplicativeExpression MultiplicativeExpression_95_Var
		 = (MultiplicativeExpression)Expr_94_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = MultiplicativeExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final CastExpression CastExpression_96_Var
		 = (CastExpression)Expr_95_list.get(0);
		Assert.assertNotNull(CastExpression_96_Var
		);
		//96
		final UnaryExpression UnaryExpression_97_Var
		 = (UnaryExpression)CastExpression_96_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_97_Var
		);
		//97
		final PostfixExpression PostfixExpression_98_Var
		 = (PostfixExpression)UnaryExpression_97_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = PostfixExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final PrimaryExpression PrimaryExpression_99_Var
		 = (PrimaryExpression)Expr_98_list.get(0);
		Assert.assertNotNull(PrimaryExpression_99_Var
		);
		//99
		final Constant2 Constant2_100_Var
		 = (Constant2)PrimaryExpression_99_Var
		.getConst();
		Assert.assertNotNull(Constant2_100_Var
		);
		Assert.assertEquals("\"%s\\n\"", Constant2_100_Var
		.getStr());
		//100
		final AssignmentExpression AssignmentExpression_101_Var
		 = (AssignmentExpression)Expr_83_list.get(1);
		Assert.assertNotNull(AssignmentExpression_101_Var
		);
		//101
		final ConditionalExpression ConditionalExpression_102_Var
		 = (ConditionalExpression)AssignmentExpression_101_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_102_Var
		);
		//102
		final LogicalOrExpression LogicalOrExpression_103_Var
		 = (LogicalOrExpression)ConditionalExpression_102_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = LogicalOrExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final LogicalAndExpression LogicalAndExpression_104_Var
		 = (LogicalAndExpression)Expr_103_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = LogicalAndExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final InclusiveOrExpression InclusiveOrExpression_105_Var
		 = (InclusiveOrExpression)Expr_104_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = InclusiveOrExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final ExclusiveOrExpression ExclusiveOrExpression_106_Var
		 = (ExclusiveOrExpression)Expr_105_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = ExclusiveOrExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final AndExpression AndExpression_107_Var
		 = (AndExpression)Expr_106_list.get(0);
		Assert.assertNotNull(AndExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = AndExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final EqualityExpression EqualityExpression_108_Var
		 = (EqualityExpression)Expr_107_list.get(0);
		Assert.assertNotNull(EqualityExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = EqualityExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final RelationalExpression RelationalExpression_109_Var
		 = (RelationalExpression)Expr_108_list.get(0);
		Assert.assertNotNull(RelationalExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = RelationalExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final ShiftExpression ShiftExpression_110_Var
		 = (ShiftExpression)Expr_109_list.get(0);
		Assert.assertNotNull(ShiftExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = ShiftExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final AdditiveExpression AdditiveExpression_111_Var
		 = (AdditiveExpression)Expr_110_list.get(0);
		Assert.assertNotNull(AdditiveExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = AdditiveExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final MultiplicativeExpression MultiplicativeExpression_112_Var
		 = (MultiplicativeExpression)Expr_111_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = MultiplicativeExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final CastExpression CastExpression_113_Var
		 = (CastExpression)Expr_112_list.get(0);
		Assert.assertNotNull(CastExpression_113_Var
		);
		//113
		final UnaryExpression UnaryExpression_114_Var
		 = (UnaryExpression)CastExpression_113_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_114_Var
		);
		//114
		final PostfixExpression PostfixExpression_115_Var
		 = (PostfixExpression)UnaryExpression_114_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = PostfixExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final PrimaryExpression PrimaryExpression_116_Var
		 = (PrimaryExpression)Expr_115_list.get(0);
		Assert.assertNotNull(PrimaryExpression_116_Var
		);
		Assert.assertEquals("out", PrimaryExpression_116_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_64_Var
		.getSemi());
		//116
		final Statement Statement_117_Var
		 = (Statement)Statement_62_list.get(1);
		Assert.assertNotNull(Statement_117_Var
		);
		//117
		final ExpressionStatement ExpressionStatement_118_Var
		 = (ExpressionStatement)Statement_117_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_118_Var
		);
		//118
		final Expression Expression_119_Var
		 = (Expression)ExpressionStatement_118_Var
		.getExpression();
		Assert.assertNotNull(Expression_119_Var
		);
		final EList<? extends EObject> ExprExpr_119_list = Expression_119_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_119_list);
		Assert.assertEquals(1, ExprExpr_119_list.size());
		//119
		final AssignmentExpression AssignmentExpression_120_Var
		 = (AssignmentExpression)ExprExpr_119_list.get(0);
		Assert.assertNotNull(AssignmentExpression_120_Var
		);
		//120
		final ConditionalExpression ConditionalExpression_121_Var
		 = (ConditionalExpression)AssignmentExpression_120_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_121_Var
		);
		//121
		final LogicalOrExpression LogicalOrExpression_122_Var
		 = (LogicalOrExpression)ConditionalExpression_121_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = LogicalOrExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final LogicalAndExpression LogicalAndExpression_123_Var
		 = (LogicalAndExpression)Expr_122_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = LogicalAndExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final InclusiveOrExpression InclusiveOrExpression_124_Var
		 = (InclusiveOrExpression)Expr_123_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = InclusiveOrExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final ExclusiveOrExpression ExclusiveOrExpression_125_Var
		 = (ExclusiveOrExpression)Expr_124_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = ExclusiveOrExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final AndExpression AndExpression_126_Var
		 = (AndExpression)Expr_125_list.get(0);
		Assert.assertNotNull(AndExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = AndExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final EqualityExpression EqualityExpression_127_Var
		 = (EqualityExpression)Expr_126_list.get(0);
		Assert.assertNotNull(EqualityExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = EqualityExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final RelationalExpression RelationalExpression_128_Var
		 = (RelationalExpression)Expr_127_list.get(0);
		Assert.assertNotNull(RelationalExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = RelationalExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final ShiftExpression ShiftExpression_129_Var
		 = (ShiftExpression)Expr_128_list.get(0);
		Assert.assertNotNull(ShiftExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = ShiftExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final AdditiveExpression AdditiveExpression_130_Var
		 = (AdditiveExpression)Expr_129_list.get(0);
		Assert.assertNotNull(AdditiveExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = AdditiveExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final MultiplicativeExpression MultiplicativeExpression_131_Var
		 = (MultiplicativeExpression)Expr_130_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = MultiplicativeExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final CastExpression CastExpression_132_Var
		 = (CastExpression)Expr_131_list.get(0);
		Assert.assertNotNull(CastExpression_132_Var
		);
		//132
		final UnaryExpression UnaryExpression_133_Var
		 = (UnaryExpression)CastExpression_132_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_133_Var
		);
		//133
		final PostfixExpression PostfixExpression_134_Var
		 = (PostfixExpression)UnaryExpression_133_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = PostfixExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final PrimaryExpression PrimaryExpression_135_Var
		 = (PrimaryExpression)Expr_134_list.get(0);
		Assert.assertNotNull(PrimaryExpression_135_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_135_Var
		.getId());
		final EList<? extends EObject> Suffix_135_list = PostfixExpression_134_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_135_list);
		Assert.assertEquals(1, Suffix_135_list.size());
		//135
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_136_Var
		 = (PostfixExpressionSuffixArgument)Suffix_135_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_136_Var
		);
		//136
		final ArgumentExpressionList ArgumentExpressionList_137_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_136_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_137_Var
		);
		final EList<? extends EObject> Expr_137_list = ArgumentExpressionList_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(2, Expr_137_list.size());
		//137
		final AssignmentExpression AssignmentExpression_138_Var
		 = (AssignmentExpression)Expr_137_list.get(0);
		Assert.assertNotNull(AssignmentExpression_138_Var
		);
		//138
		final ConditionalExpression ConditionalExpression_139_Var
		 = (ConditionalExpression)AssignmentExpression_138_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_139_Var
		);
		//139
		final LogicalOrExpression LogicalOrExpression_140_Var
		 = (LogicalOrExpression)ConditionalExpression_139_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = LogicalOrExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final LogicalAndExpression LogicalAndExpression_141_Var
		 = (LogicalAndExpression)Expr_140_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = LogicalAndExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final InclusiveOrExpression InclusiveOrExpression_142_Var
		 = (InclusiveOrExpression)Expr_141_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = InclusiveOrExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final ExclusiveOrExpression ExclusiveOrExpression_143_Var
		 = (ExclusiveOrExpression)Expr_142_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = ExclusiveOrExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final AndExpression AndExpression_144_Var
		 = (AndExpression)Expr_143_list.get(0);
		Assert.assertNotNull(AndExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = AndExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final EqualityExpression EqualityExpression_145_Var
		 = (EqualityExpression)Expr_144_list.get(0);
		Assert.assertNotNull(EqualityExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = EqualityExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final RelationalExpression RelationalExpression_146_Var
		 = (RelationalExpression)Expr_145_list.get(0);
		Assert.assertNotNull(RelationalExpression_146_Var
		);
		final EList<? extends EObject> Expr_146_list = RelationalExpression_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final ShiftExpression ShiftExpression_147_Var
		 = (ShiftExpression)Expr_146_list.get(0);
		Assert.assertNotNull(ShiftExpression_147_Var
		);
		final EList<? extends EObject> Expr_147_list = ShiftExpression_147_Var
		.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(1, Expr_147_list.size());
		//147
		final AdditiveExpression AdditiveExpression_148_Var
		 = (AdditiveExpression)Expr_147_list.get(0);
		Assert.assertNotNull(AdditiveExpression_148_Var
		);
		final EList<? extends EObject> Expr_148_list = AdditiveExpression_148_Var
		.getExpr();
		Assert.assertNotNull(Expr_148_list);
		Assert.assertEquals(1, Expr_148_list.size());
		//148
		final MultiplicativeExpression MultiplicativeExpression_149_Var
		 = (MultiplicativeExpression)Expr_148_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_149_Var
		);
		final EList<? extends EObject> Expr_149_list = MultiplicativeExpression_149_Var
		.getExpr();
		Assert.assertNotNull(Expr_149_list);
		Assert.assertEquals(1, Expr_149_list.size());
		//149
		final CastExpression CastExpression_150_Var
		 = (CastExpression)Expr_149_list.get(0);
		Assert.assertNotNull(CastExpression_150_Var
		);
		//150
		final UnaryExpression UnaryExpression_151_Var
		 = (UnaryExpression)CastExpression_150_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_151_Var
		);
		//151
		final PostfixExpression PostfixExpression_152_Var
		 = (PostfixExpression)UnaryExpression_151_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_152_Var
		);
		final EList<? extends EObject> Expr_152_list = PostfixExpression_152_Var
		.getExpr();
		Assert.assertNotNull(Expr_152_list);
		Assert.assertEquals(1, Expr_152_list.size());
		//152
		final PrimaryExpression PrimaryExpression_153_Var
		 = (PrimaryExpression)Expr_152_list.get(0);
		Assert.assertNotNull(PrimaryExpression_153_Var
		);
		Assert.assertEquals("out", PrimaryExpression_153_Var
		.getId());
		//153
		final AssignmentExpression AssignmentExpression_154_Var
		 = (AssignmentExpression)Expr_137_list.get(1);
		Assert.assertNotNull(AssignmentExpression_154_Var
		);
		//154
		final ConditionalExpression ConditionalExpression_155_Var
		 = (ConditionalExpression)AssignmentExpression_154_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_155_Var
		);
		//155
		final LogicalOrExpression LogicalOrExpression_156_Var
		 = (LogicalOrExpression)ConditionalExpression_155_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_156_Var
		);
		final EList<? extends EObject> Expr_156_list = LogicalOrExpression_156_Var
		.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		//156
		final LogicalAndExpression LogicalAndExpression_157_Var
		 = (LogicalAndExpression)Expr_156_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = LogicalAndExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final InclusiveOrExpression InclusiveOrExpression_158_Var
		 = (InclusiveOrExpression)Expr_157_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = InclusiveOrExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final ExclusiveOrExpression ExclusiveOrExpression_159_Var
		 = (ExclusiveOrExpression)Expr_158_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = ExclusiveOrExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final AndExpression AndExpression_160_Var
		 = (AndExpression)Expr_159_list.get(0);
		Assert.assertNotNull(AndExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = AndExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final EqualityExpression EqualityExpression_161_Var
		 = (EqualityExpression)Expr_160_list.get(0);
		Assert.assertNotNull(EqualityExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = EqualityExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final RelationalExpression RelationalExpression_162_Var
		 = (RelationalExpression)Expr_161_list.get(0);
		Assert.assertNotNull(RelationalExpression_162_Var
		);
		final EList<? extends EObject> Expr_162_list = RelationalExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		//162
		final ShiftExpression ShiftExpression_163_Var
		 = (ShiftExpression)Expr_162_list.get(0);
		Assert.assertNotNull(ShiftExpression_163_Var
		);
		final EList<? extends EObject> Expr_163_list = ShiftExpression_163_Var
		.getExpr();
		Assert.assertNotNull(Expr_163_list);
		Assert.assertEquals(1, Expr_163_list.size());
		//163
		final AdditiveExpression AdditiveExpression_164_Var
		 = (AdditiveExpression)Expr_163_list.get(0);
		Assert.assertNotNull(AdditiveExpression_164_Var
		);
		final EList<? extends EObject> Expr_164_list = AdditiveExpression_164_Var
		.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		//164
		final MultiplicativeExpression MultiplicativeExpression_165_Var
		 = (MultiplicativeExpression)Expr_164_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_165_Var
		);
		final EList<? extends EObject> Expr_165_list = MultiplicativeExpression_165_Var
		.getExpr();
		Assert.assertNotNull(Expr_165_list);
		Assert.assertEquals(1, Expr_165_list.size());
		//165
		final CastExpression CastExpression_166_Var
		 = (CastExpression)Expr_165_list.get(0);
		Assert.assertNotNull(CastExpression_166_Var
		);
		//166
		final UnaryExpression UnaryExpression_167_Var
		 = (UnaryExpression)CastExpression_166_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_167_Var
		);
		//167
		final PostfixExpression PostfixExpression_168_Var
		 = (PostfixExpression)UnaryExpression_167_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_168_Var
		);
		final EList<? extends EObject> Expr_168_list = PostfixExpression_168_Var
		.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(1, Expr_168_list.size());
		//168
		final PrimaryExpression PrimaryExpression_169_Var
		 = (PrimaryExpression)Expr_168_list.get(0);
		Assert.assertNotNull(PrimaryExpression_169_Var
		);
		//169
		final Constant2 Constant2_170_Var
		 = (Constant2)PrimaryExpression_169_Var
		.getConst();
		Assert.assertNotNull(Constant2_170_Var
		);
		Assert.assertEquals("\"Hello World!\"", Constant2_170_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_118_Var
		.getSemi());
		//170
		final Statement Statement_171_Var
		 = (Statement)Statement_62_list.get(2);
		Assert.assertNotNull(Statement_171_Var
		);
		//171
		final ExpressionStatement ExpressionStatement_172_Var
		 = (ExpressionStatement)Statement_171_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_172_Var
		);
		//172
		final Expression Expression_173_Var
		 = (Expression)ExpressionStatement_172_Var
		.getExpression();
		Assert.assertNotNull(Expression_173_Var
		);
		final EList<? extends EObject> ExprExpr_173_list = Expression_173_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_173_list);
		Assert.assertEquals(1, ExprExpr_173_list.size());
		//173
		final AssignmentExpression AssignmentExpression_174_Var
		 = (AssignmentExpression)ExprExpr_173_list.get(0);
		Assert.assertNotNull(AssignmentExpression_174_Var
		);
		//174
		final ConditionalExpression ConditionalExpression_175_Var
		 = (ConditionalExpression)AssignmentExpression_174_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_175_Var
		);
		//175
		final LogicalOrExpression LogicalOrExpression_176_Var
		 = (LogicalOrExpression)ConditionalExpression_175_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = LogicalOrExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final LogicalAndExpression LogicalAndExpression_177_Var
		 = (LogicalAndExpression)Expr_176_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = LogicalAndExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final InclusiveOrExpression InclusiveOrExpression_178_Var
		 = (InclusiveOrExpression)Expr_177_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = InclusiveOrExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final ExclusiveOrExpression ExclusiveOrExpression_179_Var
		 = (ExclusiveOrExpression)Expr_178_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = ExclusiveOrExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final AndExpression AndExpression_180_Var
		 = (AndExpression)Expr_179_list.get(0);
		Assert.assertNotNull(AndExpression_180_Var
		);
		final EList<? extends EObject> Expr_180_list = AndExpression_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final EqualityExpression EqualityExpression_181_Var
		 = (EqualityExpression)Expr_180_list.get(0);
		Assert.assertNotNull(EqualityExpression_181_Var
		);
		final EList<? extends EObject> Expr_181_list = EqualityExpression_181_Var
		.getExpr();
		Assert.assertNotNull(Expr_181_list);
		Assert.assertEquals(1, Expr_181_list.size());
		//181
		final RelationalExpression RelationalExpression_182_Var
		 = (RelationalExpression)Expr_181_list.get(0);
		Assert.assertNotNull(RelationalExpression_182_Var
		);
		final EList<? extends EObject> Expr_182_list = RelationalExpression_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(1, Expr_182_list.size());
		//182
		final ShiftExpression ShiftExpression_183_Var
		 = (ShiftExpression)Expr_182_list.get(0);
		Assert.assertNotNull(ShiftExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = ShiftExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final AdditiveExpression AdditiveExpression_184_Var
		 = (AdditiveExpression)Expr_183_list.get(0);
		Assert.assertNotNull(AdditiveExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = AdditiveExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final MultiplicativeExpression MultiplicativeExpression_185_Var
		 = (MultiplicativeExpression)Expr_184_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_185_Var
		);
		final EList<? extends EObject> Expr_185_list = MultiplicativeExpression_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final CastExpression CastExpression_186_Var
		 = (CastExpression)Expr_185_list.get(0);
		Assert.assertNotNull(CastExpression_186_Var
		);
		//186
		final UnaryExpression UnaryExpression_187_Var
		 = (UnaryExpression)CastExpression_186_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_187_Var
		);
		//187
		final PostfixExpression PostfixExpression_188_Var
		 = (PostfixExpression)UnaryExpression_187_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = PostfixExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final PrimaryExpression PrimaryExpression_189_Var
		 = (PrimaryExpression)Expr_188_list.get(0);
		Assert.assertNotNull(PrimaryExpression_189_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_189_Var
		.getId());
		final EList<? extends EObject> Suffix_189_list = PostfixExpression_188_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_189_list);
		Assert.assertEquals(1, Suffix_189_list.size());
		//189
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_190_Var
		 = (PostfixExpressionSuffixArgument)Suffix_189_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_190_Var
		);
		//190
		final ArgumentExpressionList ArgumentExpressionList_191_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_190_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_191_Var
		);
		final EList<? extends EObject> Expr_191_list = ArgumentExpressionList_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(2, Expr_191_list.size());
		//191
		final AssignmentExpression AssignmentExpression_192_Var
		 = (AssignmentExpression)Expr_191_list.get(0);
		Assert.assertNotNull(AssignmentExpression_192_Var
		);
		//192
		final ConditionalExpression ConditionalExpression_193_Var
		 = (ConditionalExpression)AssignmentExpression_192_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_193_Var
		);
		//193
		final LogicalOrExpression LogicalOrExpression_194_Var
		 = (LogicalOrExpression)ConditionalExpression_193_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = LogicalOrExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final LogicalAndExpression LogicalAndExpression_195_Var
		 = (LogicalAndExpression)Expr_194_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = LogicalAndExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final InclusiveOrExpression InclusiveOrExpression_196_Var
		 = (InclusiveOrExpression)Expr_195_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = InclusiveOrExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final ExclusiveOrExpression ExclusiveOrExpression_197_Var
		 = (ExclusiveOrExpression)Expr_196_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = ExclusiveOrExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final AndExpression AndExpression_198_Var
		 = (AndExpression)Expr_197_list.get(0);
		Assert.assertNotNull(AndExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = AndExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final EqualityExpression EqualityExpression_199_Var
		 = (EqualityExpression)Expr_198_list.get(0);
		Assert.assertNotNull(EqualityExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = EqualityExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final RelationalExpression RelationalExpression_200_Var
		 = (RelationalExpression)Expr_199_list.get(0);
		Assert.assertNotNull(RelationalExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = RelationalExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final ShiftExpression ShiftExpression_201_Var
		 = (ShiftExpression)Expr_200_list.get(0);
		Assert.assertNotNull(ShiftExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = ShiftExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final AdditiveExpression AdditiveExpression_202_Var
		 = (AdditiveExpression)Expr_201_list.get(0);
		Assert.assertNotNull(AdditiveExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = AdditiveExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final MultiplicativeExpression MultiplicativeExpression_203_Var
		 = (MultiplicativeExpression)Expr_202_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = MultiplicativeExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final CastExpression CastExpression_204_Var
		 = (CastExpression)Expr_203_list.get(0);
		Assert.assertNotNull(CastExpression_204_Var
		);
		//204
		final UnaryExpression UnaryExpression_205_Var
		 = (UnaryExpression)CastExpression_204_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_205_Var
		);
		//205
		final PostfixExpression PostfixExpression_206_Var
		 = (PostfixExpression)UnaryExpression_205_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = PostfixExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final PrimaryExpression PrimaryExpression_207_Var
		 = (PrimaryExpression)Expr_206_list.get(0);
		Assert.assertNotNull(PrimaryExpression_207_Var
		);
		//207
		final Constant2 Constant2_208_Var
		 = (Constant2)PrimaryExpression_207_Var
		.getConst();
		Assert.assertNotNull(Constant2_208_Var
		);
		Assert.assertEquals("\"%s\\n\"", Constant2_208_Var
		.getStr());
		//208
		final AssignmentExpression AssignmentExpression_209_Var
		 = (AssignmentExpression)Expr_191_list.get(1);
		Assert.assertNotNull(AssignmentExpression_209_Var
		);
		//209
		final ConditionalExpression ConditionalExpression_210_Var
		 = (ConditionalExpression)AssignmentExpression_209_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_210_Var
		);
		//210
		final LogicalOrExpression LogicalOrExpression_211_Var
		 = (LogicalOrExpression)ConditionalExpression_210_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = LogicalOrExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final LogicalAndExpression LogicalAndExpression_212_Var
		 = (LogicalAndExpression)Expr_211_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = LogicalAndExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final InclusiveOrExpression InclusiveOrExpression_213_Var
		 = (InclusiveOrExpression)Expr_212_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = InclusiveOrExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final ExclusiveOrExpression ExclusiveOrExpression_214_Var
		 = (ExclusiveOrExpression)Expr_213_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = ExclusiveOrExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final AndExpression AndExpression_215_Var
		 = (AndExpression)Expr_214_list.get(0);
		Assert.assertNotNull(AndExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = AndExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final EqualityExpression EqualityExpression_216_Var
		 = (EqualityExpression)Expr_215_list.get(0);
		Assert.assertNotNull(EqualityExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = EqualityExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final RelationalExpression RelationalExpression_217_Var
		 = (RelationalExpression)Expr_216_list.get(0);
		Assert.assertNotNull(RelationalExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = RelationalExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final ShiftExpression ShiftExpression_218_Var
		 = (ShiftExpression)Expr_217_list.get(0);
		Assert.assertNotNull(ShiftExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = ShiftExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final AdditiveExpression AdditiveExpression_219_Var
		 = (AdditiveExpression)Expr_218_list.get(0);
		Assert.assertNotNull(AdditiveExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = AdditiveExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final MultiplicativeExpression MultiplicativeExpression_220_Var
		 = (MultiplicativeExpression)Expr_219_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = MultiplicativeExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final CastExpression CastExpression_221_Var
		 = (CastExpression)Expr_220_list.get(0);
		Assert.assertNotNull(CastExpression_221_Var
		);
		//221
		final UnaryExpression UnaryExpression_222_Var
		 = (UnaryExpression)CastExpression_221_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_222_Var
		);
		//222
		final PostfixExpression PostfixExpression_223_Var
		 = (PostfixExpression)UnaryExpression_222_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = PostfixExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final PrimaryExpression PrimaryExpression_224_Var
		 = (PrimaryExpression)Expr_223_list.get(0);
		Assert.assertNotNull(PrimaryExpression_224_Var
		);
		Assert.assertEquals("out", PrimaryExpression_224_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_172_Var
		.getSemi());
		//224
		final Statement Statement_225_Var
		 = (Statement)Statement_62_list.get(3);
		Assert.assertNotNull(Statement_225_Var
		);
		//225
		final ExpressionStatement ExpressionStatement_226_Var
		 = (ExpressionStatement)Statement_225_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_226_Var
		);
		//226
		final Expression Expression_227_Var
		 = (Expression)ExpressionStatement_226_Var
		.getExpression();
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
		final UnaryExpression UnaryExpression_229_Var
		 = (UnaryExpression)AssignmentExpression_228_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_229_Var
		);
		//229
		final PostfixExpression PostfixExpression_230_Var
		 = (PostfixExpression)UnaryExpression_229_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = PostfixExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final PrimaryExpression PrimaryExpression_231_Var
		 = (PrimaryExpression)Expr_230_list.get(0);
		Assert.assertNotNull(PrimaryExpression_231_Var
		);
		Assert.assertEquals("out", PrimaryExpression_231_Var
		.getId());
		final EList<? extends EObject> Suffix_231_list = PostfixExpression_230_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_231_list);
		Assert.assertEquals(1, Suffix_231_list.size());
		//231
		final PostfixExpressionSuffixArray PostfixExpressionSuffixArray_232_Var
		 = (PostfixExpressionSuffixArray)Suffix_231_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArray_232_Var
		);
		//232
		final Expression Expression_233_Var
		 = (Expression)PostfixExpressionSuffixArray_232_Var
		.getArrayExpr();
		Assert.assertNotNull(Expression_233_Var
		);
		final EList<? extends EObject> ExprExpr_233_list = Expression_233_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_233_list);
		Assert.assertEquals(1, ExprExpr_233_list.size());
		//233
		final AssignmentExpression AssignmentExpression_234_Var
		 = (AssignmentExpression)ExprExpr_233_list.get(0);
		Assert.assertNotNull(AssignmentExpression_234_Var
		);
		//234
		final ConditionalExpression ConditionalExpression_235_Var
		 = (ConditionalExpression)AssignmentExpression_234_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_235_Var
		);
		//235
		final LogicalOrExpression LogicalOrExpression_236_Var
		 = (LogicalOrExpression)ConditionalExpression_235_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = LogicalOrExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final LogicalAndExpression LogicalAndExpression_237_Var
		 = (LogicalAndExpression)Expr_236_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = LogicalAndExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final InclusiveOrExpression InclusiveOrExpression_238_Var
		 = (InclusiveOrExpression)Expr_237_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = InclusiveOrExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final ExclusiveOrExpression ExclusiveOrExpression_239_Var
		 = (ExclusiveOrExpression)Expr_238_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = ExclusiveOrExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final AndExpression AndExpression_240_Var
		 = (AndExpression)Expr_239_list.get(0);
		Assert.assertNotNull(AndExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = AndExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final EqualityExpression EqualityExpression_241_Var
		 = (EqualityExpression)Expr_240_list.get(0);
		Assert.assertNotNull(EqualityExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = EqualityExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final RelationalExpression RelationalExpression_242_Var
		 = (RelationalExpression)Expr_241_list.get(0);
		Assert.assertNotNull(RelationalExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = RelationalExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final ShiftExpression ShiftExpression_243_Var
		 = (ShiftExpression)Expr_242_list.get(0);
		Assert.assertNotNull(ShiftExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = ShiftExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final AdditiveExpression AdditiveExpression_244_Var
		 = (AdditiveExpression)Expr_243_list.get(0);
		Assert.assertNotNull(AdditiveExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = AdditiveExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final MultiplicativeExpression MultiplicativeExpression_245_Var
		 = (MultiplicativeExpression)Expr_244_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = MultiplicativeExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final CastExpression CastExpression_246_Var
		 = (CastExpression)Expr_245_list.get(0);
		Assert.assertNotNull(CastExpression_246_Var
		);
		//246
		final UnaryExpression UnaryExpression_247_Var
		 = (UnaryExpression)CastExpression_246_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_247_Var
		);
		//247
		final PostfixExpression PostfixExpression_248_Var
		 = (PostfixExpression)UnaryExpression_247_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = PostfixExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final PrimaryExpression PrimaryExpression_249_Var
		 = (PrimaryExpression)Expr_248_list.get(0);
		Assert.assertNotNull(PrimaryExpression_249_Var
		);
		//249
		final Constant2 Constant2_250_Var
		 = (Constant2)PrimaryExpression_249_Var
		.getConst();
		Assert.assertNotNull(Constant2_250_Var
		);
		Assert.assertEquals("6", Constant2_250_Var
		.getDec());
		//250
		final AssignmentOperator AssignmentOperator_251_Var
		 = (AssignmentOperator)AssignmentExpression_228_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_251_Var
		);
		Assert.assertEquals("=", AssignmentOperator_251_Var
		.getOp());
		//251
		final AssignmentExpression AssignmentExpression_252_Var
		 = (AssignmentExpression)AssignmentExpression_228_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_252_Var
		);
		//252
		final ConditionalExpression ConditionalExpression_253_Var
		 = (ConditionalExpression)AssignmentExpression_252_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_253_Var
		);
		//253
		final LogicalOrExpression LogicalOrExpression_254_Var
		 = (LogicalOrExpression)ConditionalExpression_253_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = LogicalOrExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final LogicalAndExpression LogicalAndExpression_255_Var
		 = (LogicalAndExpression)Expr_254_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_255_Var
		);
		final EList<? extends EObject> Expr_255_list = LogicalAndExpression_255_Var
		.getExpr();
		Assert.assertNotNull(Expr_255_list);
		Assert.assertEquals(1, Expr_255_list.size());
		//255
		final InclusiveOrExpression InclusiveOrExpression_256_Var
		 = (InclusiveOrExpression)Expr_255_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_256_Var
		);
		final EList<? extends EObject> Expr_256_list = InclusiveOrExpression_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(1, Expr_256_list.size());
		//256
		final ExclusiveOrExpression ExclusiveOrExpression_257_Var
		 = (ExclusiveOrExpression)Expr_256_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = ExclusiveOrExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final AndExpression AndExpression_258_Var
		 = (AndExpression)Expr_257_list.get(0);
		Assert.assertNotNull(AndExpression_258_Var
		);
		final EList<? extends EObject> Expr_258_list = AndExpression_258_Var
		.getExpr();
		Assert.assertNotNull(Expr_258_list);
		Assert.assertEquals(1, Expr_258_list.size());
		//258
		final EqualityExpression EqualityExpression_259_Var
		 = (EqualityExpression)Expr_258_list.get(0);
		Assert.assertNotNull(EqualityExpression_259_Var
		);
		final EList<? extends EObject> Expr_259_list = EqualityExpression_259_Var
		.getExpr();
		Assert.assertNotNull(Expr_259_list);
		Assert.assertEquals(1, Expr_259_list.size());
		//259
		final RelationalExpression RelationalExpression_260_Var
		 = (RelationalExpression)Expr_259_list.get(0);
		Assert.assertNotNull(RelationalExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = RelationalExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final ShiftExpression ShiftExpression_261_Var
		 = (ShiftExpression)Expr_260_list.get(0);
		Assert.assertNotNull(ShiftExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = ShiftExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final AdditiveExpression AdditiveExpression_262_Var
		 = (AdditiveExpression)Expr_261_list.get(0);
		Assert.assertNotNull(AdditiveExpression_262_Var
		);
		final EList<? extends EObject> Expr_262_list = AdditiveExpression_262_Var
		.getExpr();
		Assert.assertNotNull(Expr_262_list);
		Assert.assertEquals(1, Expr_262_list.size());
		//262
		final MultiplicativeExpression MultiplicativeExpression_263_Var
		 = (MultiplicativeExpression)Expr_262_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_263_Var
		);
		final EList<? extends EObject> Expr_263_list = MultiplicativeExpression_263_Var
		.getExpr();
		Assert.assertNotNull(Expr_263_list);
		Assert.assertEquals(1, Expr_263_list.size());
		//263
		final CastExpression CastExpression_264_Var
		 = (CastExpression)Expr_263_list.get(0);
		Assert.assertNotNull(CastExpression_264_Var
		);
		//264
		final UnaryExpression UnaryExpression_265_Var
		 = (UnaryExpression)CastExpression_264_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_265_Var
		);
		//265
		final PostfixExpression PostfixExpression_266_Var
		 = (PostfixExpression)UnaryExpression_265_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_266_Var
		);
		final EList<? extends EObject> Expr_266_list = PostfixExpression_266_Var
		.getExpr();
		Assert.assertNotNull(Expr_266_list);
		Assert.assertEquals(1, Expr_266_list.size());
		//266
		final PrimaryExpression PrimaryExpression_267_Var
		 = (PrimaryExpression)Expr_266_list.get(0);
		Assert.assertNotNull(PrimaryExpression_267_Var
		);
		//267
		final Constant2 Constant2_268_Var
		 = (Constant2)PrimaryExpression_267_Var
		.getConst();
		Assert.assertNotNull(Constant2_268_Var
		);
		Assert.assertEquals("'w'", Constant2_268_Var
		.getCh());
		Assert.assertEquals(";", ExpressionStatement_226_Var
		.getSemi());
		//268
		final Statement Statement_269_Var
		 = (Statement)Statement_62_list.get(4);
		Assert.assertNotNull(Statement_269_Var
		);
		//269
		final ExpressionStatement ExpressionStatement_270_Var
		 = (ExpressionStatement)Statement_269_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_270_Var
		);
		//270
		final Expression Expression_271_Var
		 = (Expression)ExpressionStatement_270_Var
		.getExpression();
		Assert.assertNotNull(Expression_271_Var
		);
		final EList<? extends EObject> ExprExpr_271_list = Expression_271_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_271_list);
		Assert.assertEquals(1, ExprExpr_271_list.size());
		//271
		final AssignmentExpression AssignmentExpression_272_Var
		 = (AssignmentExpression)ExprExpr_271_list.get(0);
		Assert.assertNotNull(AssignmentExpression_272_Var
		);
		//272
		final ConditionalExpression ConditionalExpression_273_Var
		 = (ConditionalExpression)AssignmentExpression_272_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_273_Var
		);
		//273
		final LogicalOrExpression LogicalOrExpression_274_Var
		 = (LogicalOrExpression)ConditionalExpression_273_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_274_Var
		);
		final EList<? extends EObject> Expr_274_list = LogicalOrExpression_274_Var
		.getExpr();
		Assert.assertNotNull(Expr_274_list);
		Assert.assertEquals(1, Expr_274_list.size());
		//274
		final LogicalAndExpression LogicalAndExpression_275_Var
		 = (LogicalAndExpression)Expr_274_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_275_Var
		);
		final EList<? extends EObject> Expr_275_list = LogicalAndExpression_275_Var
		.getExpr();
		Assert.assertNotNull(Expr_275_list);
		Assert.assertEquals(1, Expr_275_list.size());
		//275
		final InclusiveOrExpression InclusiveOrExpression_276_Var
		 = (InclusiveOrExpression)Expr_275_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_276_Var
		);
		final EList<? extends EObject> Expr_276_list = InclusiveOrExpression_276_Var
		.getExpr();
		Assert.assertNotNull(Expr_276_list);
		Assert.assertEquals(1, Expr_276_list.size());
		//276
		final ExclusiveOrExpression ExclusiveOrExpression_277_Var
		 = (ExclusiveOrExpression)Expr_276_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_277_Var
		);
		final EList<? extends EObject> Expr_277_list = ExclusiveOrExpression_277_Var
		.getExpr();
		Assert.assertNotNull(Expr_277_list);
		Assert.assertEquals(1, Expr_277_list.size());
		//277
		final AndExpression AndExpression_278_Var
		 = (AndExpression)Expr_277_list.get(0);
		Assert.assertNotNull(AndExpression_278_Var
		);
		final EList<? extends EObject> Expr_278_list = AndExpression_278_Var
		.getExpr();
		Assert.assertNotNull(Expr_278_list);
		Assert.assertEquals(1, Expr_278_list.size());
		//278
		final EqualityExpression EqualityExpression_279_Var
		 = (EqualityExpression)Expr_278_list.get(0);
		Assert.assertNotNull(EqualityExpression_279_Var
		);
		final EList<? extends EObject> Expr_279_list = EqualityExpression_279_Var
		.getExpr();
		Assert.assertNotNull(Expr_279_list);
		Assert.assertEquals(1, Expr_279_list.size());
		//279
		final RelationalExpression RelationalExpression_280_Var
		 = (RelationalExpression)Expr_279_list.get(0);
		Assert.assertNotNull(RelationalExpression_280_Var
		);
		final EList<? extends EObject> Expr_280_list = RelationalExpression_280_Var
		.getExpr();
		Assert.assertNotNull(Expr_280_list);
		Assert.assertEquals(1, Expr_280_list.size());
		//280
		final ShiftExpression ShiftExpression_281_Var
		 = (ShiftExpression)Expr_280_list.get(0);
		Assert.assertNotNull(ShiftExpression_281_Var
		);
		final EList<? extends EObject> Expr_281_list = ShiftExpression_281_Var
		.getExpr();
		Assert.assertNotNull(Expr_281_list);
		Assert.assertEquals(1, Expr_281_list.size());
		//281
		final AdditiveExpression AdditiveExpression_282_Var
		 = (AdditiveExpression)Expr_281_list.get(0);
		Assert.assertNotNull(AdditiveExpression_282_Var
		);
		final EList<? extends EObject> Expr_282_list = AdditiveExpression_282_Var
		.getExpr();
		Assert.assertNotNull(Expr_282_list);
		Assert.assertEquals(1, Expr_282_list.size());
		//282
		final MultiplicativeExpression MultiplicativeExpression_283_Var
		 = (MultiplicativeExpression)Expr_282_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_283_Var
		);
		final EList<? extends EObject> Expr_283_list = MultiplicativeExpression_283_Var
		.getExpr();
		Assert.assertNotNull(Expr_283_list);
		Assert.assertEquals(1, Expr_283_list.size());
		//283
		final CastExpression CastExpression_284_Var
		 = (CastExpression)Expr_283_list.get(0);
		Assert.assertNotNull(CastExpression_284_Var
		);
		//284
		final UnaryExpression UnaryExpression_285_Var
		 = (UnaryExpression)CastExpression_284_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_285_Var
		);
		//285
		final PostfixExpression PostfixExpression_286_Var
		 = (PostfixExpression)UnaryExpression_285_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_286_Var
		);
		final EList<? extends EObject> Expr_286_list = PostfixExpression_286_Var
		.getExpr();
		Assert.assertNotNull(Expr_286_list);
		Assert.assertEquals(1, Expr_286_list.size());
		//286
		final PrimaryExpression PrimaryExpression_287_Var
		 = (PrimaryExpression)Expr_286_list.get(0);
		Assert.assertNotNull(PrimaryExpression_287_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_287_Var
		.getId());
		final EList<? extends EObject> Suffix_287_list = PostfixExpression_286_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_287_list);
		Assert.assertEquals(1, Suffix_287_list.size());
		//287
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_288_Var
		 = (PostfixExpressionSuffixArgument)Suffix_287_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_288_Var
		);
		//288
		final ArgumentExpressionList ArgumentExpressionList_289_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_288_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_289_Var
		);
		final EList<? extends EObject> Expr_289_list = ArgumentExpressionList_289_Var
		.getExpr();
		Assert.assertNotNull(Expr_289_list);
		Assert.assertEquals(2, Expr_289_list.size());
		//289
		final AssignmentExpression AssignmentExpression_290_Var
		 = (AssignmentExpression)Expr_289_list.get(0);
		Assert.assertNotNull(AssignmentExpression_290_Var
		);
		//290
		final ConditionalExpression ConditionalExpression_291_Var
		 = (ConditionalExpression)AssignmentExpression_290_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_291_Var
		);
		//291
		final LogicalOrExpression LogicalOrExpression_292_Var
		 = (LogicalOrExpression)ConditionalExpression_291_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_292_Var
		);
		final EList<? extends EObject> Expr_292_list = LogicalOrExpression_292_Var
		.getExpr();
		Assert.assertNotNull(Expr_292_list);
		Assert.assertEquals(1, Expr_292_list.size());
		//292
		final LogicalAndExpression LogicalAndExpression_293_Var
		 = (LogicalAndExpression)Expr_292_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = LogicalAndExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final InclusiveOrExpression InclusiveOrExpression_294_Var
		 = (InclusiveOrExpression)Expr_293_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_294_Var
		);
		final EList<? extends EObject> Expr_294_list = InclusiveOrExpression_294_Var
		.getExpr();
		Assert.assertNotNull(Expr_294_list);
		Assert.assertEquals(1, Expr_294_list.size());
		//294
		final ExclusiveOrExpression ExclusiveOrExpression_295_Var
		 = (ExclusiveOrExpression)Expr_294_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_295_Var
		);
		final EList<? extends EObject> Expr_295_list = ExclusiveOrExpression_295_Var
		.getExpr();
		Assert.assertNotNull(Expr_295_list);
		Assert.assertEquals(1, Expr_295_list.size());
		//295
		final AndExpression AndExpression_296_Var
		 = (AndExpression)Expr_295_list.get(0);
		Assert.assertNotNull(AndExpression_296_Var
		);
		final EList<? extends EObject> Expr_296_list = AndExpression_296_Var
		.getExpr();
		Assert.assertNotNull(Expr_296_list);
		Assert.assertEquals(1, Expr_296_list.size());
		//296
		final EqualityExpression EqualityExpression_297_Var
		 = (EqualityExpression)Expr_296_list.get(0);
		Assert.assertNotNull(EqualityExpression_297_Var
		);
		final EList<? extends EObject> Expr_297_list = EqualityExpression_297_Var
		.getExpr();
		Assert.assertNotNull(Expr_297_list);
		Assert.assertEquals(1, Expr_297_list.size());
		//297
		final RelationalExpression RelationalExpression_298_Var
		 = (RelationalExpression)Expr_297_list.get(0);
		Assert.assertNotNull(RelationalExpression_298_Var
		);
		final EList<? extends EObject> Expr_298_list = RelationalExpression_298_Var
		.getExpr();
		Assert.assertNotNull(Expr_298_list);
		Assert.assertEquals(1, Expr_298_list.size());
		//298
		final ShiftExpression ShiftExpression_299_Var
		 = (ShiftExpression)Expr_298_list.get(0);
		Assert.assertNotNull(ShiftExpression_299_Var
		);
		final EList<? extends EObject> Expr_299_list = ShiftExpression_299_Var
		.getExpr();
		Assert.assertNotNull(Expr_299_list);
		Assert.assertEquals(1, Expr_299_list.size());
		//299
		final AdditiveExpression AdditiveExpression_300_Var
		 = (AdditiveExpression)Expr_299_list.get(0);
		Assert.assertNotNull(AdditiveExpression_300_Var
		);
		final EList<? extends EObject> Expr_300_list = AdditiveExpression_300_Var
		.getExpr();
		Assert.assertNotNull(Expr_300_list);
		Assert.assertEquals(1, Expr_300_list.size());
		//300
		final MultiplicativeExpression MultiplicativeExpression_301_Var
		 = (MultiplicativeExpression)Expr_300_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_301_Var
		);
		final EList<? extends EObject> Expr_301_list = MultiplicativeExpression_301_Var
		.getExpr();
		Assert.assertNotNull(Expr_301_list);
		Assert.assertEquals(1, Expr_301_list.size());
		//301
		final CastExpression CastExpression_302_Var
		 = (CastExpression)Expr_301_list.get(0);
		Assert.assertNotNull(CastExpression_302_Var
		);
		//302
		final UnaryExpression UnaryExpression_303_Var
		 = (UnaryExpression)CastExpression_302_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_303_Var
		);
		//303
		final PostfixExpression PostfixExpression_304_Var
		 = (PostfixExpression)UnaryExpression_303_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_304_Var
		);
		final EList<? extends EObject> Expr_304_list = PostfixExpression_304_Var
		.getExpr();
		Assert.assertNotNull(Expr_304_list);
		Assert.assertEquals(1, Expr_304_list.size());
		//304
		final PrimaryExpression PrimaryExpression_305_Var
		 = (PrimaryExpression)Expr_304_list.get(0);
		Assert.assertNotNull(PrimaryExpression_305_Var
		);
		//305
		final Constant2 Constant2_306_Var
		 = (Constant2)PrimaryExpression_305_Var
		.getConst();
		Assert.assertNotNull(Constant2_306_Var
		);
		Assert.assertEquals("\"%s\\n\"", Constant2_306_Var
		.getStr());
		//306
		final AssignmentExpression AssignmentExpression_307_Var
		 = (AssignmentExpression)Expr_289_list.get(1);
		Assert.assertNotNull(AssignmentExpression_307_Var
		);
		//307
		final ConditionalExpression ConditionalExpression_308_Var
		 = (ConditionalExpression)AssignmentExpression_307_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_308_Var
		);
		//308
		final LogicalOrExpression LogicalOrExpression_309_Var
		 = (LogicalOrExpression)ConditionalExpression_308_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_309_Var
		);
		final EList<? extends EObject> Expr_309_list = LogicalOrExpression_309_Var
		.getExpr();
		Assert.assertNotNull(Expr_309_list);
		Assert.assertEquals(1, Expr_309_list.size());
		//309
		final LogicalAndExpression LogicalAndExpression_310_Var
		 = (LogicalAndExpression)Expr_309_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_310_Var
		);
		final EList<? extends EObject> Expr_310_list = LogicalAndExpression_310_Var
		.getExpr();
		Assert.assertNotNull(Expr_310_list);
		Assert.assertEquals(1, Expr_310_list.size());
		//310
		final InclusiveOrExpression InclusiveOrExpression_311_Var
		 = (InclusiveOrExpression)Expr_310_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = InclusiveOrExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final ExclusiveOrExpression ExclusiveOrExpression_312_Var
		 = (ExclusiveOrExpression)Expr_311_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = ExclusiveOrExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final AndExpression AndExpression_313_Var
		 = (AndExpression)Expr_312_list.get(0);
		Assert.assertNotNull(AndExpression_313_Var
		);
		final EList<? extends EObject> Expr_313_list = AndExpression_313_Var
		.getExpr();
		Assert.assertNotNull(Expr_313_list);
		Assert.assertEquals(1, Expr_313_list.size());
		//313
		final EqualityExpression EqualityExpression_314_Var
		 = (EqualityExpression)Expr_313_list.get(0);
		Assert.assertNotNull(EqualityExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = EqualityExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final RelationalExpression RelationalExpression_315_Var
		 = (RelationalExpression)Expr_314_list.get(0);
		Assert.assertNotNull(RelationalExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = RelationalExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final ShiftExpression ShiftExpression_316_Var
		 = (ShiftExpression)Expr_315_list.get(0);
		Assert.assertNotNull(ShiftExpression_316_Var
		);
		final EList<? extends EObject> Expr_316_list = ShiftExpression_316_Var
		.getExpr();
		Assert.assertNotNull(Expr_316_list);
		Assert.assertEquals(1, Expr_316_list.size());
		//316
		final AdditiveExpression AdditiveExpression_317_Var
		 = (AdditiveExpression)Expr_316_list.get(0);
		Assert.assertNotNull(AdditiveExpression_317_Var
		);
		final EList<? extends EObject> Expr_317_list = AdditiveExpression_317_Var
		.getExpr();
		Assert.assertNotNull(Expr_317_list);
		Assert.assertEquals(1, Expr_317_list.size());
		//317
		final MultiplicativeExpression MultiplicativeExpression_318_Var
		 = (MultiplicativeExpression)Expr_317_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_318_Var
		);
		final EList<? extends EObject> Expr_318_list = MultiplicativeExpression_318_Var
		.getExpr();
		Assert.assertNotNull(Expr_318_list);
		Assert.assertEquals(1, Expr_318_list.size());
		//318
		final CastExpression CastExpression_319_Var
		 = (CastExpression)Expr_318_list.get(0);
		Assert.assertNotNull(CastExpression_319_Var
		);
		//319
		final UnaryExpression UnaryExpression_320_Var
		 = (UnaryExpression)CastExpression_319_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_320_Var
		);
		//320
		final PostfixExpression PostfixExpression_321_Var
		 = (PostfixExpression)UnaryExpression_320_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_321_Var
		);
		final EList<? extends EObject> Expr_321_list = PostfixExpression_321_Var
		.getExpr();
		Assert.assertNotNull(Expr_321_list);
		Assert.assertEquals(1, Expr_321_list.size());
		//321
		final PrimaryExpression PrimaryExpression_322_Var
		 = (PrimaryExpression)Expr_321_list.get(0);
		Assert.assertNotNull(PrimaryExpression_322_Var
		);
		Assert.assertEquals("out", PrimaryExpression_322_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_270_Var
		.getSemi());
		//322
		final Statement Statement_323_Var
		 = (Statement)Statement_62_list.get(5);
		Assert.assertNotNull(Statement_323_Var
		);
		//323
		final JumpStatement JumpStatement_324_Var
		 = (JumpStatement)Statement_323_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_324_Var
		);
		//324
		final Expression Expression_325_Var
		 = (Expression)JumpStatement_324_Var
		.getExpr();
		Assert.assertNotNull(Expression_325_Var
		);
		final EList<? extends EObject> ExprExpr_325_list = Expression_325_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_325_list);
		Assert.assertEquals(1, ExprExpr_325_list.size());
		//325
		final AssignmentExpression AssignmentExpression_326_Var
		 = (AssignmentExpression)ExprExpr_325_list.get(0);
		Assert.assertNotNull(AssignmentExpression_326_Var
		);
		//326
		final ConditionalExpression ConditionalExpression_327_Var
		 = (ConditionalExpression)AssignmentExpression_326_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_327_Var
		);
		//327
		final LogicalOrExpression LogicalOrExpression_328_Var
		 = (LogicalOrExpression)ConditionalExpression_327_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_328_Var
		);
		final EList<? extends EObject> Expr_328_list = LogicalOrExpression_328_Var
		.getExpr();
		Assert.assertNotNull(Expr_328_list);
		Assert.assertEquals(1, Expr_328_list.size());
		//328
		final LogicalAndExpression LogicalAndExpression_329_Var
		 = (LogicalAndExpression)Expr_328_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_329_Var
		);
		final EList<? extends EObject> Expr_329_list = LogicalAndExpression_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final InclusiveOrExpression InclusiveOrExpression_330_Var
		 = (InclusiveOrExpression)Expr_329_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_330_Var
		);
		final EList<? extends EObject> Expr_330_list = InclusiveOrExpression_330_Var
		.getExpr();
		Assert.assertNotNull(Expr_330_list);
		Assert.assertEquals(1, Expr_330_list.size());
		//330
		final ExclusiveOrExpression ExclusiveOrExpression_331_Var
		 = (ExclusiveOrExpression)Expr_330_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = ExclusiveOrExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final AndExpression AndExpression_332_Var
		 = (AndExpression)Expr_331_list.get(0);
		Assert.assertNotNull(AndExpression_332_Var
		);
		final EList<? extends EObject> Expr_332_list = AndExpression_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final EqualityExpression EqualityExpression_333_Var
		 = (EqualityExpression)Expr_332_list.get(0);
		Assert.assertNotNull(EqualityExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = EqualityExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final RelationalExpression RelationalExpression_334_Var
		 = (RelationalExpression)Expr_333_list.get(0);
		Assert.assertNotNull(RelationalExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = RelationalExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final ShiftExpression ShiftExpression_335_Var
		 = (ShiftExpression)Expr_334_list.get(0);
		Assert.assertNotNull(ShiftExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = ShiftExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final AdditiveExpression AdditiveExpression_336_Var
		 = (AdditiveExpression)Expr_335_list.get(0);
		Assert.assertNotNull(AdditiveExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = AdditiveExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final MultiplicativeExpression MultiplicativeExpression_337_Var
		 = (MultiplicativeExpression)Expr_336_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_337_Var
		);
		final EList<? extends EObject> Expr_337_list = MultiplicativeExpression_337_Var
		.getExpr();
		Assert.assertNotNull(Expr_337_list);
		Assert.assertEquals(1, Expr_337_list.size());
		//337
		final CastExpression CastExpression_338_Var
		 = (CastExpression)Expr_337_list.get(0);
		Assert.assertNotNull(CastExpression_338_Var
		);
		//338
		final UnaryExpression UnaryExpression_339_Var
		 = (UnaryExpression)CastExpression_338_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_339_Var
		);
		//339
		final PostfixExpression PostfixExpression_340_Var
		 = (PostfixExpression)UnaryExpression_339_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_340_Var
		);
		final EList<? extends EObject> Expr_340_list = PostfixExpression_340_Var
		.getExpr();
		Assert.assertNotNull(Expr_340_list);
		Assert.assertEquals(1, Expr_340_list.size());
		//340
		final PrimaryExpression PrimaryExpression_341_Var
		 = (PrimaryExpression)Expr_340_list.get(0);
		Assert.assertNotNull(PrimaryExpression_341_Var
		);
		//341
		final Constant2 Constant2_342_Var
		 = (Constant2)PrimaryExpression_341_Var
		.getConst();
		Assert.assertNotNull(Constant2_342_Var
		);
		Assert.assertEquals("0", Constant2_342_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_324_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_324_Var
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


