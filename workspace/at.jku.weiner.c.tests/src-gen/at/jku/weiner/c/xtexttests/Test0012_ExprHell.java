package at.jku.weiner.c.xtexttests;

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
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import at.jku.weiner.c.tests.CInjectorProvider;
import at.jku.weiner.c.parser.antlr.CParser;
import at.jku.weiner.c.parser.antlr.internal.InternalCLexer;
import at.jku.weiner.c.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.c.Model;
import at.jku.weiner.c.c.TranslationUnit;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.FunctionDefHead;
import at.jku.weiner.c.c.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.FunctionDefinition;
import at.jku.weiner.c.c.BodyStatement;
import at.jku.weiner.c.c.BlockList;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0012_ExprHell {
	@Inject
	private ParseHelper<Model> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalCLexer lexer;
	@Inject
	private CParser parser;
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
	
	@Before
	public void initialize(){
		this.testHelper = new LexerAndParserTest(lexer, 
			parser, tokenDefProvider);
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
			"res/Test0012_ExprHell.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_VOID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_LEFTPAREN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_STAR", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_LEFTSHIFT", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_LESS", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_EQUAL", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_AND", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_OR", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_CARET", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_ANDAND", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_OROR", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_QUESTION", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_COLON", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_RIGHTBRACE", 
				"RULE_NEWLINE", 
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0012_ExprHell.c");
		final Model Model_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(Model_0_Var
		);
		
		Assert.assertNotNull(Model_0_Var
		);
		final EList<? extends EObject> Unit_0_list = Model_0_Var
		.getUnit();
		Assert.assertNotNull(Unit_0_list);
		Assert.assertEquals(1, Unit_0_list.size());
		//0
		final TranslationUnit TranslationUnit_1_Var
		 = (TranslationUnit)Unit_0_list.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var
		);
		final EList<? extends EObject> External_1_list = TranslationUnit_1_Var
		.getExternal();
		Assert.assertNotNull(External_1_list);
		Assert.assertEquals(1, External_1_list.size());
		//1
		final ExternalDeclaration ExternalDeclaration_2_Var
		 = (ExternalDeclaration)External_1_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_2_Var
		);
		//2
		final FunctionDefHead FunctionDefHead_3_Var
		 = (FunctionDefHead)ExternalDeclaration_2_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_3_Var
		);
		//3
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_4_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_3_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_4_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_4_list = FunctionDeclarationSpecifiers_4_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_4_list);
		Assert.assertEquals(1, DeclarationSpecifier_4_list.size());
		//4
		final TypeSpecifier TypeSpecifier_5_Var
		 = (TypeSpecifier)DeclarationSpecifier_4_list.get(0);
		Assert.assertNotNull(TypeSpecifier_5_Var
		);
		Assert.assertEquals("void", TypeSpecifier_5_Var
		.getName());
		//5
		final Declarator Declarator_6_Var
		 = (Declarator)FunctionDefHead_3_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_6_Var
		);
		//6
		final DirectDeclarator DirectDeclarator_7_Var
		 = (DirectDeclarator)Declarator_6_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_7_Var
		);
		Assert.assertEquals("doSomething", DirectDeclarator_7_Var
		.getId());
		//7
		final FunctionDefinition FunctionDefinition_8_Var
		 = (FunctionDefinition)ExternalDeclaration_2_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_8_Var
		);
		//8
		final BodyStatement BodyStatement_9_Var
		 = (BodyStatement)FunctionDefinition_8_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_9_Var
		);
		final EList<? extends EObject> BlockList_9_list = BodyStatement_9_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_9_list);
		Assert.assertEquals(1, BlockList_9_list.size());
		//9
		final BlockList BlockList_10_Var
		 = (BlockList)BlockList_9_list.get(0);
		Assert.assertNotNull(BlockList_10_Var
		);
		final EList<? extends EObject> Statement_10_list = BlockList_10_Var
		.getStatement();
		Assert.assertNotNull(Statement_10_list);
		Assert.assertEquals(12, Statement_10_list.size());
		//10
		final Statement Statement_11_Var
		 = (Statement)Statement_10_list.get(0);
		Assert.assertNotNull(Statement_11_Var
		);
		//11
		final ExpressionStatement ExpressionStatement_12_Var
		 = (ExpressionStatement)Statement_11_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_12_Var
		);
		//12
		final Expression Expression_13_Var
		 = (Expression)ExpressionStatement_12_Var
		.getExpression();
		Assert.assertNotNull(Expression_13_Var
		);
		final EList<? extends EObject> ExprExpr_13_list = Expression_13_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_13_list);
		Assert.assertEquals(1, ExprExpr_13_list.size());
		//13
		final AssignmentExpression AssignmentExpression_14_Var
		 = (AssignmentExpression)ExprExpr_13_list.get(0);
		Assert.assertNotNull(AssignmentExpression_14_Var
		);
		//14
		final ConditionalExpression ConditionalExpression_15_Var
		 = (ConditionalExpression)AssignmentExpression_14_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_15_Var
		);
		//15
		final LogicalOrExpression LogicalOrExpression_16_Var
		 = (LogicalOrExpression)ConditionalExpression_15_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = LogicalOrExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final LogicalAndExpression LogicalAndExpression_17_Var
		 = (LogicalAndExpression)Expr_16_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = LogicalAndExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final InclusiveOrExpression InclusiveOrExpression_18_Var
		 = (InclusiveOrExpression)Expr_17_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = InclusiveOrExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final ExclusiveOrExpression ExclusiveOrExpression_19_Var
		 = (ExclusiveOrExpression)Expr_18_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = ExclusiveOrExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final AndExpression AndExpression_20_Var
		 = (AndExpression)Expr_19_list.get(0);
		Assert.assertNotNull(AndExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = AndExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final EqualityExpression EqualityExpression_21_Var
		 = (EqualityExpression)Expr_20_list.get(0);
		Assert.assertNotNull(EqualityExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = EqualityExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final RelationalExpression RelationalExpression_22_Var
		 = (RelationalExpression)Expr_21_list.get(0);
		Assert.assertNotNull(RelationalExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = RelationalExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final ShiftExpression ShiftExpression_23_Var
		 = (ShiftExpression)Expr_22_list.get(0);
		Assert.assertNotNull(ShiftExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = ShiftExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final AdditiveExpression AdditiveExpression_24_Var
		 = (AdditiveExpression)Expr_23_list.get(0);
		Assert.assertNotNull(AdditiveExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = AdditiveExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final MultiplicativeExpression MultiplicativeExpression_25_Var
		 = (MultiplicativeExpression)Expr_24_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = MultiplicativeExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final CastExpression CastExpression_26_Var
		 = (CastExpression)Expr_25_list.get(0);
		Assert.assertNotNull(CastExpression_26_Var
		);
		//26
		final UnaryExpression UnaryExpression_27_Var
		 = (UnaryExpression)CastExpression_26_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_27_Var
		);
		//27
		final PostfixExpression PostfixExpression_28_Var
		 = (PostfixExpression)UnaryExpression_27_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = PostfixExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final PrimaryExpression PrimaryExpression_29_Var
		 = (PrimaryExpression)Expr_28_list.get(0);
		Assert.assertNotNull(PrimaryExpression_29_Var
		);
		//29
		final Constant Constant_30_Var
		 = (Constant)PrimaryExpression_29_Var
		.getConst();
		Assert.assertNotNull(Constant_30_Var
		);
		Assert.assertEquals("1", Constant_30_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_12_Var
		.getSemi());
		//30
		final Statement Statement_31_Var
		 = (Statement)Statement_10_list.get(1);
		Assert.assertNotNull(Statement_31_Var
		);
		//31
		final ExpressionStatement ExpressionStatement_32_Var
		 = (ExpressionStatement)Statement_31_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_32_Var
		);
		//32
		final Expression Expression_33_Var
		 = (Expression)ExpressionStatement_32_Var
		.getExpression();
		Assert.assertNotNull(Expression_33_Var
		);
		final EList<? extends EObject> ExprExpr_33_list = Expression_33_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_33_list);
		Assert.assertEquals(1, ExprExpr_33_list.size());
		//33
		final AssignmentExpression AssignmentExpression_34_Var
		 = (AssignmentExpression)ExprExpr_33_list.get(0);
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
		final Expression Expression_50_Var
		 = (Expression)PrimaryExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expression_50_Var
		);
		final EList<? extends EObject> ExprExpr_50_list = Expression_50_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_50_list);
		Assert.assertEquals(1, ExprExpr_50_list.size());
		//50
		final AssignmentExpression AssignmentExpression_51_Var
		 = (AssignmentExpression)ExprExpr_50_list.get(0);
		Assert.assertNotNull(AssignmentExpression_51_Var
		);
		//51
		final ConditionalExpression ConditionalExpression_52_Var
		 = (ConditionalExpression)AssignmentExpression_51_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_52_Var
		);
		//52
		final LogicalOrExpression LogicalOrExpression_53_Var
		 = (LogicalOrExpression)ConditionalExpression_52_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = LogicalOrExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final LogicalAndExpression LogicalAndExpression_54_Var
		 = (LogicalAndExpression)Expr_53_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = LogicalAndExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final InclusiveOrExpression InclusiveOrExpression_55_Var
		 = (InclusiveOrExpression)Expr_54_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = InclusiveOrExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final ExclusiveOrExpression ExclusiveOrExpression_56_Var
		 = (ExclusiveOrExpression)Expr_55_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = ExclusiveOrExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final AndExpression AndExpression_57_Var
		 = (AndExpression)Expr_56_list.get(0);
		Assert.assertNotNull(AndExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = AndExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final EqualityExpression EqualityExpression_58_Var
		 = (EqualityExpression)Expr_57_list.get(0);
		Assert.assertNotNull(EqualityExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = EqualityExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final RelationalExpression RelationalExpression_59_Var
		 = (RelationalExpression)Expr_58_list.get(0);
		Assert.assertNotNull(RelationalExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = RelationalExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final ShiftExpression ShiftExpression_60_Var
		 = (ShiftExpression)Expr_59_list.get(0);
		Assert.assertNotNull(ShiftExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = ShiftExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final AdditiveExpression AdditiveExpression_61_Var
		 = (AdditiveExpression)Expr_60_list.get(0);
		Assert.assertNotNull(AdditiveExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = AdditiveExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final MultiplicativeExpression MultiplicativeExpression_62_Var
		 = (MultiplicativeExpression)Expr_61_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = MultiplicativeExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final CastExpression CastExpression_63_Var
		 = (CastExpression)Expr_62_list.get(0);
		Assert.assertNotNull(CastExpression_63_Var
		);
		//63
		final UnaryExpression UnaryExpression_64_Var
		 = (UnaryExpression)CastExpression_63_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_64_Var
		);
		//64
		final PostfixExpression PostfixExpression_65_Var
		 = (PostfixExpression)UnaryExpression_64_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = PostfixExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final PrimaryExpression PrimaryExpression_66_Var
		 = (PrimaryExpression)Expr_65_list.get(0);
		Assert.assertNotNull(PrimaryExpression_66_Var
		);
		//66
		final Constant Constant_67_Var
		 = (Constant)PrimaryExpression_66_Var
		.getConst();
		Assert.assertNotNull(Constant_67_Var
		);
		Assert.assertEquals("2", Constant_67_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_32_Var
		.getSemi());
		//67
		final Statement Statement_68_Var
		 = (Statement)Statement_10_list.get(2);
		Assert.assertNotNull(Statement_68_Var
		);
		//68
		final ExpressionStatement ExpressionStatement_69_Var
		 = (ExpressionStatement)Statement_68_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_69_Var
		);
		//69
		final Expression Expression_70_Var
		 = (Expression)ExpressionStatement_69_Var
		.getExpression();
		Assert.assertNotNull(Expression_70_Var
		);
		final EList<? extends EObject> ExprExpr_70_list = Expression_70_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_70_list);
		Assert.assertEquals(1, ExprExpr_70_list.size());
		//70
		final AssignmentExpression AssignmentExpression_71_Var
		 = (AssignmentExpression)ExprExpr_70_list.get(0);
		Assert.assertNotNull(AssignmentExpression_71_Var
		);
		//71
		final ConditionalExpression ConditionalExpression_72_Var
		 = (ConditionalExpression)AssignmentExpression_71_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_72_Var
		);
		//72
		final LogicalOrExpression LogicalOrExpression_73_Var
		 = (LogicalOrExpression)ConditionalExpression_72_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = LogicalOrExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final LogicalAndExpression LogicalAndExpression_74_Var
		 = (LogicalAndExpression)Expr_73_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = LogicalAndExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final InclusiveOrExpression InclusiveOrExpression_75_Var
		 = (InclusiveOrExpression)Expr_74_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = InclusiveOrExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final ExclusiveOrExpression ExclusiveOrExpression_76_Var
		 = (ExclusiveOrExpression)Expr_75_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = ExclusiveOrExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final AndExpression AndExpression_77_Var
		 = (AndExpression)Expr_76_list.get(0);
		Assert.assertNotNull(AndExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = AndExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final EqualityExpression EqualityExpression_78_Var
		 = (EqualityExpression)Expr_77_list.get(0);
		Assert.assertNotNull(EqualityExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = EqualityExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final RelationalExpression RelationalExpression_79_Var
		 = (RelationalExpression)Expr_78_list.get(0);
		Assert.assertNotNull(RelationalExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = RelationalExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final ShiftExpression ShiftExpression_80_Var
		 = (ShiftExpression)Expr_79_list.get(0);
		Assert.assertNotNull(ShiftExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = ShiftExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final AdditiveExpression AdditiveExpression_81_Var
		 = (AdditiveExpression)Expr_80_list.get(0);
		Assert.assertNotNull(AdditiveExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = AdditiveExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final MultiplicativeExpression MultiplicativeExpression_82_Var
		 = (MultiplicativeExpression)Expr_81_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = MultiplicativeExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(2, Expr_82_list.size());
		//82
		final CastExpression CastExpression_83_Var
		 = (CastExpression)Expr_82_list.get(0);
		Assert.assertNotNull(CastExpression_83_Var
		);
		//83
		final UnaryExpression UnaryExpression_84_Var
		 = (UnaryExpression)CastExpression_83_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_84_Var
		);
		//84
		final PostfixExpression PostfixExpression_85_Var
		 = (PostfixExpression)UnaryExpression_84_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = PostfixExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final PrimaryExpression PrimaryExpression_86_Var
		 = (PrimaryExpression)Expr_85_list.get(0);
		Assert.assertNotNull(PrimaryExpression_86_Var
		);
		//86
		final Constant Constant_87_Var
		 = (Constant)PrimaryExpression_86_Var
		.getConst();
		Assert.assertNotNull(Constant_87_Var
		);
		Assert.assertEquals("1", Constant_87_Var
		.getDec());
		//87
		final CastExpression CastExpression_88_Var
		 = (CastExpression)Expr_82_list.get(1);
		Assert.assertNotNull(CastExpression_88_Var
		);
		//88
		final UnaryExpression UnaryExpression_89_Var
		 = (UnaryExpression)CastExpression_88_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_89_Var
		);
		//89
		final PostfixExpression PostfixExpression_90_Var
		 = (PostfixExpression)UnaryExpression_89_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = PostfixExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final PrimaryExpression PrimaryExpression_91_Var
		 = (PrimaryExpression)Expr_90_list.get(0);
		Assert.assertNotNull(PrimaryExpression_91_Var
		);
		//91
		final Constant Constant_92_Var
		 = (Constant)PrimaryExpression_91_Var
		.getConst();
		Assert.assertNotNull(Constant_92_Var
		);
		Assert.assertEquals("2", Constant_92_Var
		.getDec());
		Assert.assertEquals("[*]", MultiplicativeExpression_82_Var
		.getOp().toString());
		Assert.assertEquals(";", ExpressionStatement_69_Var
		.getSemi());
		//92
		final Statement Statement_93_Var
		 = (Statement)Statement_10_list.get(3);
		Assert.assertNotNull(Statement_93_Var
		);
		//93
		final ExpressionStatement ExpressionStatement_94_Var
		 = (ExpressionStatement)Statement_93_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_94_Var
		);
		//94
		final Expression Expression_95_Var
		 = (Expression)ExpressionStatement_94_Var
		.getExpression();
		Assert.assertNotNull(Expression_95_Var
		);
		final EList<? extends EObject> ExprExpr_95_list = Expression_95_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_95_list);
		Assert.assertEquals(1, ExprExpr_95_list.size());
		//95
		final AssignmentExpression AssignmentExpression_96_Var
		 = (AssignmentExpression)ExprExpr_95_list.get(0);
		Assert.assertNotNull(AssignmentExpression_96_Var
		);
		//96
		final ConditionalExpression ConditionalExpression_97_Var
		 = (ConditionalExpression)AssignmentExpression_96_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_97_Var
		);
		//97
		final LogicalOrExpression LogicalOrExpression_98_Var
		 = (LogicalOrExpression)ConditionalExpression_97_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = LogicalOrExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final LogicalAndExpression LogicalAndExpression_99_Var
		 = (LogicalAndExpression)Expr_98_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = LogicalAndExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final InclusiveOrExpression InclusiveOrExpression_100_Var
		 = (InclusiveOrExpression)Expr_99_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = InclusiveOrExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final ExclusiveOrExpression ExclusiveOrExpression_101_Var
		 = (ExclusiveOrExpression)Expr_100_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = ExclusiveOrExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final AndExpression AndExpression_102_Var
		 = (AndExpression)Expr_101_list.get(0);
		Assert.assertNotNull(AndExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = AndExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final EqualityExpression EqualityExpression_103_Var
		 = (EqualityExpression)Expr_102_list.get(0);
		Assert.assertNotNull(EqualityExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = EqualityExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final RelationalExpression RelationalExpression_104_Var
		 = (RelationalExpression)Expr_103_list.get(0);
		Assert.assertNotNull(RelationalExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = RelationalExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final ShiftExpression ShiftExpression_105_Var
		 = (ShiftExpression)Expr_104_list.get(0);
		Assert.assertNotNull(ShiftExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = ShiftExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(2, Expr_105_list.size());
		//105
		final AdditiveExpression AdditiveExpression_106_Var
		 = (AdditiveExpression)Expr_105_list.get(0);
		Assert.assertNotNull(AdditiveExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = AdditiveExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final MultiplicativeExpression MultiplicativeExpression_107_Var
		 = (MultiplicativeExpression)Expr_106_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = MultiplicativeExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final CastExpression CastExpression_108_Var
		 = (CastExpression)Expr_107_list.get(0);
		Assert.assertNotNull(CastExpression_108_Var
		);
		//108
		final UnaryExpression UnaryExpression_109_Var
		 = (UnaryExpression)CastExpression_108_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_109_Var
		);
		//109
		final PostfixExpression PostfixExpression_110_Var
		 = (PostfixExpression)UnaryExpression_109_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = PostfixExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final PrimaryExpression PrimaryExpression_111_Var
		 = (PrimaryExpression)Expr_110_list.get(0);
		Assert.assertNotNull(PrimaryExpression_111_Var
		);
		//111
		final Constant Constant_112_Var
		 = (Constant)PrimaryExpression_111_Var
		.getConst();
		Assert.assertNotNull(Constant_112_Var
		);
		Assert.assertEquals("1", Constant_112_Var
		.getDec());
		//112
		final AdditiveExpression AdditiveExpression_113_Var
		 = (AdditiveExpression)Expr_105_list.get(1);
		Assert.assertNotNull(AdditiveExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = AdditiveExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final MultiplicativeExpression MultiplicativeExpression_114_Var
		 = (MultiplicativeExpression)Expr_113_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = MultiplicativeExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final CastExpression CastExpression_115_Var
		 = (CastExpression)Expr_114_list.get(0);
		Assert.assertNotNull(CastExpression_115_Var
		);
		//115
		final UnaryExpression UnaryExpression_116_Var
		 = (UnaryExpression)CastExpression_115_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_116_Var
		);
		//116
		final PostfixExpression PostfixExpression_117_Var
		 = (PostfixExpression)UnaryExpression_116_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = PostfixExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final PrimaryExpression PrimaryExpression_118_Var
		 = (PrimaryExpression)Expr_117_list.get(0);
		Assert.assertNotNull(PrimaryExpression_118_Var
		);
		//118
		final Constant Constant_119_Var
		 = (Constant)PrimaryExpression_118_Var
		.getConst();
		Assert.assertNotNull(Constant_119_Var
		);
		Assert.assertEquals("2", Constant_119_Var
		.getDec());
		Assert.assertEquals("[<<]", ShiftExpression_105_Var
		.getOp().toString());
		Assert.assertEquals(";", ExpressionStatement_94_Var
		.getSemi());
		//119
		final Statement Statement_120_Var
		 = (Statement)Statement_10_list.get(4);
		Assert.assertNotNull(Statement_120_Var
		);
		//120
		final ExpressionStatement ExpressionStatement_121_Var
		 = (ExpressionStatement)Statement_120_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_121_Var
		);
		//121
		final Expression Expression_122_Var
		 = (Expression)ExpressionStatement_121_Var
		.getExpression();
		Assert.assertNotNull(Expression_122_Var
		);
		final EList<? extends EObject> ExprExpr_122_list = Expression_122_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_122_list);
		Assert.assertEquals(1, ExprExpr_122_list.size());
		//122
		final AssignmentExpression AssignmentExpression_123_Var
		 = (AssignmentExpression)ExprExpr_122_list.get(0);
		Assert.assertNotNull(AssignmentExpression_123_Var
		);
		//123
		final ConditionalExpression ConditionalExpression_124_Var
		 = (ConditionalExpression)AssignmentExpression_123_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_124_Var
		);
		//124
		final LogicalOrExpression LogicalOrExpression_125_Var
		 = (LogicalOrExpression)ConditionalExpression_124_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = LogicalOrExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final LogicalAndExpression LogicalAndExpression_126_Var
		 = (LogicalAndExpression)Expr_125_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = LogicalAndExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final InclusiveOrExpression InclusiveOrExpression_127_Var
		 = (InclusiveOrExpression)Expr_126_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = InclusiveOrExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final ExclusiveOrExpression ExclusiveOrExpression_128_Var
		 = (ExclusiveOrExpression)Expr_127_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = ExclusiveOrExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final AndExpression AndExpression_129_Var
		 = (AndExpression)Expr_128_list.get(0);
		Assert.assertNotNull(AndExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = AndExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final EqualityExpression EqualityExpression_130_Var
		 = (EqualityExpression)Expr_129_list.get(0);
		Assert.assertNotNull(EqualityExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = EqualityExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final RelationalExpression RelationalExpression_131_Var
		 = (RelationalExpression)Expr_130_list.get(0);
		Assert.assertNotNull(RelationalExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = RelationalExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(2, Expr_131_list.size());
		//131
		final ShiftExpression ShiftExpression_132_Var
		 = (ShiftExpression)Expr_131_list.get(0);
		Assert.assertNotNull(ShiftExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = ShiftExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final AdditiveExpression AdditiveExpression_133_Var
		 = (AdditiveExpression)Expr_132_list.get(0);
		Assert.assertNotNull(AdditiveExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = AdditiveExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final MultiplicativeExpression MultiplicativeExpression_134_Var
		 = (MultiplicativeExpression)Expr_133_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = MultiplicativeExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final CastExpression CastExpression_135_Var
		 = (CastExpression)Expr_134_list.get(0);
		Assert.assertNotNull(CastExpression_135_Var
		);
		//135
		final UnaryExpression UnaryExpression_136_Var
		 = (UnaryExpression)CastExpression_135_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_136_Var
		);
		//136
		final PostfixExpression PostfixExpression_137_Var
		 = (PostfixExpression)UnaryExpression_136_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = PostfixExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final PrimaryExpression PrimaryExpression_138_Var
		 = (PrimaryExpression)Expr_137_list.get(0);
		Assert.assertNotNull(PrimaryExpression_138_Var
		);
		//138
		final Constant Constant_139_Var
		 = (Constant)PrimaryExpression_138_Var
		.getConst();
		Assert.assertNotNull(Constant_139_Var
		);
		Assert.assertEquals("1", Constant_139_Var
		.getDec());
		//139
		final ShiftExpression ShiftExpression_140_Var
		 = (ShiftExpression)Expr_131_list.get(1);
		Assert.assertNotNull(ShiftExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = ShiftExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final AdditiveExpression AdditiveExpression_141_Var
		 = (AdditiveExpression)Expr_140_list.get(0);
		Assert.assertNotNull(AdditiveExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = AdditiveExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final MultiplicativeExpression MultiplicativeExpression_142_Var
		 = (MultiplicativeExpression)Expr_141_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = MultiplicativeExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final CastExpression CastExpression_143_Var
		 = (CastExpression)Expr_142_list.get(0);
		Assert.assertNotNull(CastExpression_143_Var
		);
		//143
		final UnaryExpression UnaryExpression_144_Var
		 = (UnaryExpression)CastExpression_143_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_144_Var
		);
		//144
		final PostfixExpression PostfixExpression_145_Var
		 = (PostfixExpression)UnaryExpression_144_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = PostfixExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final PrimaryExpression PrimaryExpression_146_Var
		 = (PrimaryExpression)Expr_145_list.get(0);
		Assert.assertNotNull(PrimaryExpression_146_Var
		);
		//146
		final Constant Constant_147_Var
		 = (Constant)PrimaryExpression_146_Var
		.getConst();
		Assert.assertNotNull(Constant_147_Var
		);
		Assert.assertEquals("2", Constant_147_Var
		.getDec());
		Assert.assertEquals("[<]", RelationalExpression_131_Var
		.getOp().toString());
		Assert.assertEquals(";", ExpressionStatement_121_Var
		.getSemi());
		//147
		final Statement Statement_148_Var
		 = (Statement)Statement_10_list.get(5);
		Assert.assertNotNull(Statement_148_Var
		);
		//148
		final ExpressionStatement ExpressionStatement_149_Var
		 = (ExpressionStatement)Statement_148_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_149_Var
		);
		//149
		final Expression Expression_150_Var
		 = (Expression)ExpressionStatement_149_Var
		.getExpression();
		Assert.assertNotNull(Expression_150_Var
		);
		final EList<? extends EObject> ExprExpr_150_list = Expression_150_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_150_list);
		Assert.assertEquals(1, ExprExpr_150_list.size());
		//150
		final AssignmentExpression AssignmentExpression_151_Var
		 = (AssignmentExpression)ExprExpr_150_list.get(0);
		Assert.assertNotNull(AssignmentExpression_151_Var
		);
		//151
		final ConditionalExpression ConditionalExpression_152_Var
		 = (ConditionalExpression)AssignmentExpression_151_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_152_Var
		);
		//152
		final LogicalOrExpression LogicalOrExpression_153_Var
		 = (LogicalOrExpression)ConditionalExpression_152_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_153_Var
		);
		final EList<? extends EObject> Expr_153_list = LogicalOrExpression_153_Var
		.getExpr();
		Assert.assertNotNull(Expr_153_list);
		Assert.assertEquals(1, Expr_153_list.size());
		//153
		final LogicalAndExpression LogicalAndExpression_154_Var
		 = (LogicalAndExpression)Expr_153_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_154_Var
		);
		final EList<? extends EObject> Expr_154_list = LogicalAndExpression_154_Var
		.getExpr();
		Assert.assertNotNull(Expr_154_list);
		Assert.assertEquals(1, Expr_154_list.size());
		//154
		final InclusiveOrExpression InclusiveOrExpression_155_Var
		 = (InclusiveOrExpression)Expr_154_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_155_Var
		);
		final EList<? extends EObject> Expr_155_list = InclusiveOrExpression_155_Var
		.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		//155
		final ExclusiveOrExpression ExclusiveOrExpression_156_Var
		 = (ExclusiveOrExpression)Expr_155_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_156_Var
		);
		final EList<? extends EObject> Expr_156_list = ExclusiveOrExpression_156_Var
		.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		//156
		final AndExpression AndExpression_157_Var
		 = (AndExpression)Expr_156_list.get(0);
		Assert.assertNotNull(AndExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = AndExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final EqualityExpression EqualityExpression_158_Var
		 = (EqualityExpression)Expr_157_list.get(0);
		Assert.assertNotNull(EqualityExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = EqualityExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(2, Expr_158_list.size());
		//158
		final RelationalExpression RelationalExpression_159_Var
		 = (RelationalExpression)Expr_158_list.get(0);
		Assert.assertNotNull(RelationalExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = RelationalExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final ShiftExpression ShiftExpression_160_Var
		 = (ShiftExpression)Expr_159_list.get(0);
		Assert.assertNotNull(ShiftExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = ShiftExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final AdditiveExpression AdditiveExpression_161_Var
		 = (AdditiveExpression)Expr_160_list.get(0);
		Assert.assertNotNull(AdditiveExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = AdditiveExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final MultiplicativeExpression MultiplicativeExpression_162_Var
		 = (MultiplicativeExpression)Expr_161_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_162_Var
		);
		final EList<? extends EObject> Expr_162_list = MultiplicativeExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		//162
		final CastExpression CastExpression_163_Var
		 = (CastExpression)Expr_162_list.get(0);
		Assert.assertNotNull(CastExpression_163_Var
		);
		//163
		final UnaryExpression UnaryExpression_164_Var
		 = (UnaryExpression)CastExpression_163_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_164_Var
		);
		//164
		final PostfixExpression PostfixExpression_165_Var
		 = (PostfixExpression)UnaryExpression_164_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_165_Var
		);
		final EList<? extends EObject> Expr_165_list = PostfixExpression_165_Var
		.getExpr();
		Assert.assertNotNull(Expr_165_list);
		Assert.assertEquals(1, Expr_165_list.size());
		//165
		final PrimaryExpression PrimaryExpression_166_Var
		 = (PrimaryExpression)Expr_165_list.get(0);
		Assert.assertNotNull(PrimaryExpression_166_Var
		);
		//166
		final Constant Constant_167_Var
		 = (Constant)PrimaryExpression_166_Var
		.getConst();
		Assert.assertNotNull(Constant_167_Var
		);
		Assert.assertEquals("1", Constant_167_Var
		.getDec());
		//167
		final RelationalExpression RelationalExpression_168_Var
		 = (RelationalExpression)Expr_158_list.get(1);
		Assert.assertNotNull(RelationalExpression_168_Var
		);
		final EList<? extends EObject> Expr_168_list = RelationalExpression_168_Var
		.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(1, Expr_168_list.size());
		//168
		final ShiftExpression ShiftExpression_169_Var
		 = (ShiftExpression)Expr_168_list.get(0);
		Assert.assertNotNull(ShiftExpression_169_Var
		);
		final EList<? extends EObject> Expr_169_list = ShiftExpression_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		//169
		final AdditiveExpression AdditiveExpression_170_Var
		 = (AdditiveExpression)Expr_169_list.get(0);
		Assert.assertNotNull(AdditiveExpression_170_Var
		);
		final EList<? extends EObject> Expr_170_list = AdditiveExpression_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		//170
		final MultiplicativeExpression MultiplicativeExpression_171_Var
		 = (MultiplicativeExpression)Expr_170_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_171_Var
		);
		final EList<? extends EObject> Expr_171_list = MultiplicativeExpression_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		//171
		final CastExpression CastExpression_172_Var
		 = (CastExpression)Expr_171_list.get(0);
		Assert.assertNotNull(CastExpression_172_Var
		);
		//172
		final UnaryExpression UnaryExpression_173_Var
		 = (UnaryExpression)CastExpression_172_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_173_Var
		);
		//173
		final PostfixExpression PostfixExpression_174_Var
		 = (PostfixExpression)UnaryExpression_173_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = PostfixExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final PrimaryExpression PrimaryExpression_175_Var
		 = (PrimaryExpression)Expr_174_list.get(0);
		Assert.assertNotNull(PrimaryExpression_175_Var
		);
		//175
		final Constant Constant_176_Var
		 = (Constant)PrimaryExpression_175_Var
		.getConst();
		Assert.assertNotNull(Constant_176_Var
		);
		Assert.assertEquals("2", Constant_176_Var
		.getDec());
		Assert.assertEquals("[==]", EqualityExpression_158_Var
		.getOp().toString());
		Assert.assertEquals(";", ExpressionStatement_149_Var
		.getSemi());
		//176
		final Statement Statement_177_Var
		 = (Statement)Statement_10_list.get(6);
		Assert.assertNotNull(Statement_177_Var
		);
		//177
		final ExpressionStatement ExpressionStatement_178_Var
		 = (ExpressionStatement)Statement_177_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_178_Var
		);
		//178
		final Expression Expression_179_Var
		 = (Expression)ExpressionStatement_178_Var
		.getExpression();
		Assert.assertNotNull(Expression_179_Var
		);
		final EList<? extends EObject> ExprExpr_179_list = Expression_179_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_179_list);
		Assert.assertEquals(1, ExprExpr_179_list.size());
		//179
		final AssignmentExpression AssignmentExpression_180_Var
		 = (AssignmentExpression)ExprExpr_179_list.get(0);
		Assert.assertNotNull(AssignmentExpression_180_Var
		);
		//180
		final ConditionalExpression ConditionalExpression_181_Var
		 = (ConditionalExpression)AssignmentExpression_180_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_181_Var
		);
		//181
		final LogicalOrExpression LogicalOrExpression_182_Var
		 = (LogicalOrExpression)ConditionalExpression_181_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_182_Var
		);
		final EList<? extends EObject> Expr_182_list = LogicalOrExpression_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(1, Expr_182_list.size());
		//182
		final LogicalAndExpression LogicalAndExpression_183_Var
		 = (LogicalAndExpression)Expr_182_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = LogicalAndExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final InclusiveOrExpression InclusiveOrExpression_184_Var
		 = (InclusiveOrExpression)Expr_183_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = InclusiveOrExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final ExclusiveOrExpression ExclusiveOrExpression_185_Var
		 = (ExclusiveOrExpression)Expr_184_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_185_Var
		);
		final EList<? extends EObject> Expr_185_list = ExclusiveOrExpression_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final AndExpression AndExpression_186_Var
		 = (AndExpression)Expr_185_list.get(0);
		Assert.assertNotNull(AndExpression_186_Var
		);
		final EList<? extends EObject> Expr_186_list = AndExpression_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(2, Expr_186_list.size());
		//186
		final EqualityExpression EqualityExpression_187_Var
		 = (EqualityExpression)Expr_186_list.get(0);
		Assert.assertNotNull(EqualityExpression_187_Var
		);
		final EList<? extends EObject> Expr_187_list = EqualityExpression_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(1, Expr_187_list.size());
		//187
		final RelationalExpression RelationalExpression_188_Var
		 = (RelationalExpression)Expr_187_list.get(0);
		Assert.assertNotNull(RelationalExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = RelationalExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final ShiftExpression ShiftExpression_189_Var
		 = (ShiftExpression)Expr_188_list.get(0);
		Assert.assertNotNull(ShiftExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = ShiftExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final AdditiveExpression AdditiveExpression_190_Var
		 = (AdditiveExpression)Expr_189_list.get(0);
		Assert.assertNotNull(AdditiveExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = AdditiveExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final MultiplicativeExpression MultiplicativeExpression_191_Var
		 = (MultiplicativeExpression)Expr_190_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = MultiplicativeExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final CastExpression CastExpression_192_Var
		 = (CastExpression)Expr_191_list.get(0);
		Assert.assertNotNull(CastExpression_192_Var
		);
		//192
		final UnaryExpression UnaryExpression_193_Var
		 = (UnaryExpression)CastExpression_192_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_193_Var
		);
		//193
		final PostfixExpression PostfixExpression_194_Var
		 = (PostfixExpression)UnaryExpression_193_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = PostfixExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final PrimaryExpression PrimaryExpression_195_Var
		 = (PrimaryExpression)Expr_194_list.get(0);
		Assert.assertNotNull(PrimaryExpression_195_Var
		);
		//195
		final Constant Constant_196_Var
		 = (Constant)PrimaryExpression_195_Var
		.getConst();
		Assert.assertNotNull(Constant_196_Var
		);
		Assert.assertEquals("1", Constant_196_Var
		.getDec());
		//196
		final EqualityExpression EqualityExpression_197_Var
		 = (EqualityExpression)Expr_186_list.get(1);
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
		final Constant Constant_206_Var
		 = (Constant)PrimaryExpression_205_Var
		.getConst();
		Assert.assertNotNull(Constant_206_Var
		);
		Assert.assertEquals("2", Constant_206_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_178_Var
		.getSemi());
		//206
		final Statement Statement_207_Var
		 = (Statement)Statement_10_list.get(7);
		Assert.assertNotNull(Statement_207_Var
		);
		//207
		final ExpressionStatement ExpressionStatement_208_Var
		 = (ExpressionStatement)Statement_207_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_208_Var
		);
		//208
		final Expression Expression_209_Var
		 = (Expression)ExpressionStatement_208_Var
		.getExpression();
		Assert.assertNotNull(Expression_209_Var
		);
		final EList<? extends EObject> ExprExpr_209_list = Expression_209_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_209_list);
		Assert.assertEquals(1, ExprExpr_209_list.size());
		//209
		final AssignmentExpression AssignmentExpression_210_Var
		 = (AssignmentExpression)ExprExpr_209_list.get(0);
		Assert.assertNotNull(AssignmentExpression_210_Var
		);
		//210
		final ConditionalExpression ConditionalExpression_211_Var
		 = (ConditionalExpression)AssignmentExpression_210_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_211_Var
		);
		//211
		final LogicalOrExpression LogicalOrExpression_212_Var
		 = (LogicalOrExpression)ConditionalExpression_211_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = LogicalOrExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final LogicalAndExpression LogicalAndExpression_213_Var
		 = (LogicalAndExpression)Expr_212_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = LogicalAndExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final InclusiveOrExpression InclusiveOrExpression_214_Var
		 = (InclusiveOrExpression)Expr_213_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = InclusiveOrExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(2, Expr_214_list.size());
		//214
		final ExclusiveOrExpression ExclusiveOrExpression_215_Var
		 = (ExclusiveOrExpression)Expr_214_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = ExclusiveOrExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final AndExpression AndExpression_216_Var
		 = (AndExpression)Expr_215_list.get(0);
		Assert.assertNotNull(AndExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = AndExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final EqualityExpression EqualityExpression_217_Var
		 = (EqualityExpression)Expr_216_list.get(0);
		Assert.assertNotNull(EqualityExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = EqualityExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final RelationalExpression RelationalExpression_218_Var
		 = (RelationalExpression)Expr_217_list.get(0);
		Assert.assertNotNull(RelationalExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = RelationalExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final ShiftExpression ShiftExpression_219_Var
		 = (ShiftExpression)Expr_218_list.get(0);
		Assert.assertNotNull(ShiftExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = ShiftExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final AdditiveExpression AdditiveExpression_220_Var
		 = (AdditiveExpression)Expr_219_list.get(0);
		Assert.assertNotNull(AdditiveExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = AdditiveExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final MultiplicativeExpression MultiplicativeExpression_221_Var
		 = (MultiplicativeExpression)Expr_220_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = MultiplicativeExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final CastExpression CastExpression_222_Var
		 = (CastExpression)Expr_221_list.get(0);
		Assert.assertNotNull(CastExpression_222_Var
		);
		//222
		final UnaryExpression UnaryExpression_223_Var
		 = (UnaryExpression)CastExpression_222_Var
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
		//225
		final Constant Constant_226_Var
		 = (Constant)PrimaryExpression_225_Var
		.getConst();
		Assert.assertNotNull(Constant_226_Var
		);
		Assert.assertEquals("1", Constant_226_Var
		.getDec());
		//226
		final ExclusiveOrExpression ExclusiveOrExpression_227_Var
		 = (ExclusiveOrExpression)Expr_214_list.get(1);
		Assert.assertNotNull(ExclusiveOrExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = ExclusiveOrExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final AndExpression AndExpression_228_Var
		 = (AndExpression)Expr_227_list.get(0);
		Assert.assertNotNull(AndExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = AndExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final EqualityExpression EqualityExpression_229_Var
		 = (EqualityExpression)Expr_228_list.get(0);
		Assert.assertNotNull(EqualityExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = EqualityExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final RelationalExpression RelationalExpression_230_Var
		 = (RelationalExpression)Expr_229_list.get(0);
		Assert.assertNotNull(RelationalExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = RelationalExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final ShiftExpression ShiftExpression_231_Var
		 = (ShiftExpression)Expr_230_list.get(0);
		Assert.assertNotNull(ShiftExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = ShiftExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final AdditiveExpression AdditiveExpression_232_Var
		 = (AdditiveExpression)Expr_231_list.get(0);
		Assert.assertNotNull(AdditiveExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = AdditiveExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final MultiplicativeExpression MultiplicativeExpression_233_Var
		 = (MultiplicativeExpression)Expr_232_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = MultiplicativeExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final CastExpression CastExpression_234_Var
		 = (CastExpression)Expr_233_list.get(0);
		Assert.assertNotNull(CastExpression_234_Var
		);
		//234
		final UnaryExpression UnaryExpression_235_Var
		 = (UnaryExpression)CastExpression_234_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_235_Var
		);
		//235
		final PostfixExpression PostfixExpression_236_Var
		 = (PostfixExpression)UnaryExpression_235_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = PostfixExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final PrimaryExpression PrimaryExpression_237_Var
		 = (PrimaryExpression)Expr_236_list.get(0);
		Assert.assertNotNull(PrimaryExpression_237_Var
		);
		//237
		final Constant Constant_238_Var
		 = (Constant)PrimaryExpression_237_Var
		.getConst();
		Assert.assertNotNull(Constant_238_Var
		);
		Assert.assertEquals("2", Constant_238_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_208_Var
		.getSemi());
		//238
		final Statement Statement_239_Var
		 = (Statement)Statement_10_list.get(8);
		Assert.assertNotNull(Statement_239_Var
		);
		//239
		final ExpressionStatement ExpressionStatement_240_Var
		 = (ExpressionStatement)Statement_239_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_240_Var
		);
		//240
		final Expression Expression_241_Var
		 = (Expression)ExpressionStatement_240_Var
		.getExpression();
		Assert.assertNotNull(Expression_241_Var
		);
		final EList<? extends EObject> ExprExpr_241_list = Expression_241_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_241_list);
		Assert.assertEquals(1, ExprExpr_241_list.size());
		//241
		final AssignmentExpression AssignmentExpression_242_Var
		 = (AssignmentExpression)ExprExpr_241_list.get(0);
		Assert.assertNotNull(AssignmentExpression_242_Var
		);
		//242
		final ConditionalExpression ConditionalExpression_243_Var
		 = (ConditionalExpression)AssignmentExpression_242_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_243_Var
		);
		//243
		final LogicalOrExpression LogicalOrExpression_244_Var
		 = (LogicalOrExpression)ConditionalExpression_243_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = LogicalOrExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final LogicalAndExpression LogicalAndExpression_245_Var
		 = (LogicalAndExpression)Expr_244_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = LogicalAndExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final InclusiveOrExpression InclusiveOrExpression_246_Var
		 = (InclusiveOrExpression)Expr_245_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = InclusiveOrExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final ExclusiveOrExpression ExclusiveOrExpression_247_Var
		 = (ExclusiveOrExpression)Expr_246_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = ExclusiveOrExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(2, Expr_247_list.size());
		//247
		final AndExpression AndExpression_248_Var
		 = (AndExpression)Expr_247_list.get(0);
		Assert.assertNotNull(AndExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = AndExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final EqualityExpression EqualityExpression_249_Var
		 = (EqualityExpression)Expr_248_list.get(0);
		Assert.assertNotNull(EqualityExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = EqualityExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final RelationalExpression RelationalExpression_250_Var
		 = (RelationalExpression)Expr_249_list.get(0);
		Assert.assertNotNull(RelationalExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = RelationalExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final ShiftExpression ShiftExpression_251_Var
		 = (ShiftExpression)Expr_250_list.get(0);
		Assert.assertNotNull(ShiftExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = ShiftExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final AdditiveExpression AdditiveExpression_252_Var
		 = (AdditiveExpression)Expr_251_list.get(0);
		Assert.assertNotNull(AdditiveExpression_252_Var
		);
		final EList<? extends EObject> Expr_252_list = AdditiveExpression_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(1, Expr_252_list.size());
		//252
		final MultiplicativeExpression MultiplicativeExpression_253_Var
		 = (MultiplicativeExpression)Expr_252_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = MultiplicativeExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final CastExpression CastExpression_254_Var
		 = (CastExpression)Expr_253_list.get(0);
		Assert.assertNotNull(CastExpression_254_Var
		);
		//254
		final UnaryExpression UnaryExpression_255_Var
		 = (UnaryExpression)CastExpression_254_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_255_Var
		);
		//255
		final PostfixExpression PostfixExpression_256_Var
		 = (PostfixExpression)UnaryExpression_255_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_256_Var
		);
		final EList<? extends EObject> Expr_256_list = PostfixExpression_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(1, Expr_256_list.size());
		//256
		final PrimaryExpression PrimaryExpression_257_Var
		 = (PrimaryExpression)Expr_256_list.get(0);
		Assert.assertNotNull(PrimaryExpression_257_Var
		);
		//257
		final Constant Constant_258_Var
		 = (Constant)PrimaryExpression_257_Var
		.getConst();
		Assert.assertNotNull(Constant_258_Var
		);
		Assert.assertEquals("1", Constant_258_Var
		.getDec());
		//258
		final AndExpression AndExpression_259_Var
		 = (AndExpression)Expr_247_list.get(1);
		Assert.assertNotNull(AndExpression_259_Var
		);
		final EList<? extends EObject> Expr_259_list = AndExpression_259_Var
		.getExpr();
		Assert.assertNotNull(Expr_259_list);
		Assert.assertEquals(1, Expr_259_list.size());
		//259
		final EqualityExpression EqualityExpression_260_Var
		 = (EqualityExpression)Expr_259_list.get(0);
		Assert.assertNotNull(EqualityExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = EqualityExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final RelationalExpression RelationalExpression_261_Var
		 = (RelationalExpression)Expr_260_list.get(0);
		Assert.assertNotNull(RelationalExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = RelationalExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final ShiftExpression ShiftExpression_262_Var
		 = (ShiftExpression)Expr_261_list.get(0);
		Assert.assertNotNull(ShiftExpression_262_Var
		);
		final EList<? extends EObject> Expr_262_list = ShiftExpression_262_Var
		.getExpr();
		Assert.assertNotNull(Expr_262_list);
		Assert.assertEquals(1, Expr_262_list.size());
		//262
		final AdditiveExpression AdditiveExpression_263_Var
		 = (AdditiveExpression)Expr_262_list.get(0);
		Assert.assertNotNull(AdditiveExpression_263_Var
		);
		final EList<? extends EObject> Expr_263_list = AdditiveExpression_263_Var
		.getExpr();
		Assert.assertNotNull(Expr_263_list);
		Assert.assertEquals(1, Expr_263_list.size());
		//263
		final MultiplicativeExpression MultiplicativeExpression_264_Var
		 = (MultiplicativeExpression)Expr_263_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_264_Var
		);
		final EList<? extends EObject> Expr_264_list = MultiplicativeExpression_264_Var
		.getExpr();
		Assert.assertNotNull(Expr_264_list);
		Assert.assertEquals(1, Expr_264_list.size());
		//264
		final CastExpression CastExpression_265_Var
		 = (CastExpression)Expr_264_list.get(0);
		Assert.assertNotNull(CastExpression_265_Var
		);
		//265
		final UnaryExpression UnaryExpression_266_Var
		 = (UnaryExpression)CastExpression_265_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_266_Var
		);
		//266
		final PostfixExpression PostfixExpression_267_Var
		 = (PostfixExpression)UnaryExpression_266_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_267_Var
		);
		final EList<? extends EObject> Expr_267_list = PostfixExpression_267_Var
		.getExpr();
		Assert.assertNotNull(Expr_267_list);
		Assert.assertEquals(1, Expr_267_list.size());
		//267
		final PrimaryExpression PrimaryExpression_268_Var
		 = (PrimaryExpression)Expr_267_list.get(0);
		Assert.assertNotNull(PrimaryExpression_268_Var
		);
		//268
		final Constant Constant_269_Var
		 = (Constant)PrimaryExpression_268_Var
		.getConst();
		Assert.assertNotNull(Constant_269_Var
		);
		Assert.assertEquals("2", Constant_269_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_240_Var
		.getSemi());
		//269
		final Statement Statement_270_Var
		 = (Statement)Statement_10_list.get(9);
		Assert.assertNotNull(Statement_270_Var
		);
		//270
		final ExpressionStatement ExpressionStatement_271_Var
		 = (ExpressionStatement)Statement_270_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_271_Var
		);
		//271
		final Expression Expression_272_Var
		 = (Expression)ExpressionStatement_271_Var
		.getExpression();
		Assert.assertNotNull(Expression_272_Var
		);
		final EList<? extends EObject> ExprExpr_272_list = Expression_272_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_272_list);
		Assert.assertEquals(1, ExprExpr_272_list.size());
		//272
		final AssignmentExpression AssignmentExpression_273_Var
		 = (AssignmentExpression)ExprExpr_272_list.get(0);
		Assert.assertNotNull(AssignmentExpression_273_Var
		);
		//273
		final ConditionalExpression ConditionalExpression_274_Var
		 = (ConditionalExpression)AssignmentExpression_273_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_274_Var
		);
		//274
		final LogicalOrExpression LogicalOrExpression_275_Var
		 = (LogicalOrExpression)ConditionalExpression_274_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_275_Var
		);
		final EList<? extends EObject> Expr_275_list = LogicalOrExpression_275_Var
		.getExpr();
		Assert.assertNotNull(Expr_275_list);
		Assert.assertEquals(1, Expr_275_list.size());
		//275
		final LogicalAndExpression LogicalAndExpression_276_Var
		 = (LogicalAndExpression)Expr_275_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_276_Var
		);
		final EList<? extends EObject> Expr_276_list = LogicalAndExpression_276_Var
		.getExpr();
		Assert.assertNotNull(Expr_276_list);
		Assert.assertEquals(2, Expr_276_list.size());
		//276
		final InclusiveOrExpression InclusiveOrExpression_277_Var
		 = (InclusiveOrExpression)Expr_276_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_277_Var
		);
		final EList<? extends EObject> Expr_277_list = InclusiveOrExpression_277_Var
		.getExpr();
		Assert.assertNotNull(Expr_277_list);
		Assert.assertEquals(1, Expr_277_list.size());
		//277
		final ExclusiveOrExpression ExclusiveOrExpression_278_Var
		 = (ExclusiveOrExpression)Expr_277_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_278_Var
		);
		final EList<? extends EObject> Expr_278_list = ExclusiveOrExpression_278_Var
		.getExpr();
		Assert.assertNotNull(Expr_278_list);
		Assert.assertEquals(1, Expr_278_list.size());
		//278
		final AndExpression AndExpression_279_Var
		 = (AndExpression)Expr_278_list.get(0);
		Assert.assertNotNull(AndExpression_279_Var
		);
		final EList<? extends EObject> Expr_279_list = AndExpression_279_Var
		.getExpr();
		Assert.assertNotNull(Expr_279_list);
		Assert.assertEquals(1, Expr_279_list.size());
		//279
		final EqualityExpression EqualityExpression_280_Var
		 = (EqualityExpression)Expr_279_list.get(0);
		Assert.assertNotNull(EqualityExpression_280_Var
		);
		final EList<? extends EObject> Expr_280_list = EqualityExpression_280_Var
		.getExpr();
		Assert.assertNotNull(Expr_280_list);
		Assert.assertEquals(1, Expr_280_list.size());
		//280
		final RelationalExpression RelationalExpression_281_Var
		 = (RelationalExpression)Expr_280_list.get(0);
		Assert.assertNotNull(RelationalExpression_281_Var
		);
		final EList<? extends EObject> Expr_281_list = RelationalExpression_281_Var
		.getExpr();
		Assert.assertNotNull(Expr_281_list);
		Assert.assertEquals(1, Expr_281_list.size());
		//281
		final ShiftExpression ShiftExpression_282_Var
		 = (ShiftExpression)Expr_281_list.get(0);
		Assert.assertNotNull(ShiftExpression_282_Var
		);
		final EList<? extends EObject> Expr_282_list = ShiftExpression_282_Var
		.getExpr();
		Assert.assertNotNull(Expr_282_list);
		Assert.assertEquals(1, Expr_282_list.size());
		//282
		final AdditiveExpression AdditiveExpression_283_Var
		 = (AdditiveExpression)Expr_282_list.get(0);
		Assert.assertNotNull(AdditiveExpression_283_Var
		);
		final EList<? extends EObject> Expr_283_list = AdditiveExpression_283_Var
		.getExpr();
		Assert.assertNotNull(Expr_283_list);
		Assert.assertEquals(1, Expr_283_list.size());
		//283
		final MultiplicativeExpression MultiplicativeExpression_284_Var
		 = (MultiplicativeExpression)Expr_283_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_284_Var
		);
		final EList<? extends EObject> Expr_284_list = MultiplicativeExpression_284_Var
		.getExpr();
		Assert.assertNotNull(Expr_284_list);
		Assert.assertEquals(1, Expr_284_list.size());
		//284
		final CastExpression CastExpression_285_Var
		 = (CastExpression)Expr_284_list.get(0);
		Assert.assertNotNull(CastExpression_285_Var
		);
		//285
		final UnaryExpression UnaryExpression_286_Var
		 = (UnaryExpression)CastExpression_285_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_286_Var
		);
		//286
		final PostfixExpression PostfixExpression_287_Var
		 = (PostfixExpression)UnaryExpression_286_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_287_Var
		);
		final EList<? extends EObject> Expr_287_list = PostfixExpression_287_Var
		.getExpr();
		Assert.assertNotNull(Expr_287_list);
		Assert.assertEquals(1, Expr_287_list.size());
		//287
		final PrimaryExpression PrimaryExpression_288_Var
		 = (PrimaryExpression)Expr_287_list.get(0);
		Assert.assertNotNull(PrimaryExpression_288_Var
		);
		//288
		final Constant Constant_289_Var
		 = (Constant)PrimaryExpression_288_Var
		.getConst();
		Assert.assertNotNull(Constant_289_Var
		);
		Assert.assertEquals("1", Constant_289_Var
		.getDec());
		//289
		final InclusiveOrExpression InclusiveOrExpression_290_Var
		 = (InclusiveOrExpression)Expr_276_list.get(1);
		Assert.assertNotNull(InclusiveOrExpression_290_Var
		);
		final EList<? extends EObject> Expr_290_list = InclusiveOrExpression_290_Var
		.getExpr();
		Assert.assertNotNull(Expr_290_list);
		Assert.assertEquals(1, Expr_290_list.size());
		//290
		final ExclusiveOrExpression ExclusiveOrExpression_291_Var
		 = (ExclusiveOrExpression)Expr_290_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_291_Var
		);
		final EList<? extends EObject> Expr_291_list = ExclusiveOrExpression_291_Var
		.getExpr();
		Assert.assertNotNull(Expr_291_list);
		Assert.assertEquals(1, Expr_291_list.size());
		//291
		final AndExpression AndExpression_292_Var
		 = (AndExpression)Expr_291_list.get(0);
		Assert.assertNotNull(AndExpression_292_Var
		);
		final EList<? extends EObject> Expr_292_list = AndExpression_292_Var
		.getExpr();
		Assert.assertNotNull(Expr_292_list);
		Assert.assertEquals(1, Expr_292_list.size());
		//292
		final EqualityExpression EqualityExpression_293_Var
		 = (EqualityExpression)Expr_292_list.get(0);
		Assert.assertNotNull(EqualityExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = EqualityExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final RelationalExpression RelationalExpression_294_Var
		 = (RelationalExpression)Expr_293_list.get(0);
		Assert.assertNotNull(RelationalExpression_294_Var
		);
		final EList<? extends EObject> Expr_294_list = RelationalExpression_294_Var
		.getExpr();
		Assert.assertNotNull(Expr_294_list);
		Assert.assertEquals(1, Expr_294_list.size());
		//294
		final ShiftExpression ShiftExpression_295_Var
		 = (ShiftExpression)Expr_294_list.get(0);
		Assert.assertNotNull(ShiftExpression_295_Var
		);
		final EList<? extends EObject> Expr_295_list = ShiftExpression_295_Var
		.getExpr();
		Assert.assertNotNull(Expr_295_list);
		Assert.assertEquals(1, Expr_295_list.size());
		//295
		final AdditiveExpression AdditiveExpression_296_Var
		 = (AdditiveExpression)Expr_295_list.get(0);
		Assert.assertNotNull(AdditiveExpression_296_Var
		);
		final EList<? extends EObject> Expr_296_list = AdditiveExpression_296_Var
		.getExpr();
		Assert.assertNotNull(Expr_296_list);
		Assert.assertEquals(1, Expr_296_list.size());
		//296
		final MultiplicativeExpression MultiplicativeExpression_297_Var
		 = (MultiplicativeExpression)Expr_296_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_297_Var
		);
		final EList<? extends EObject> Expr_297_list = MultiplicativeExpression_297_Var
		.getExpr();
		Assert.assertNotNull(Expr_297_list);
		Assert.assertEquals(1, Expr_297_list.size());
		//297
		final CastExpression CastExpression_298_Var
		 = (CastExpression)Expr_297_list.get(0);
		Assert.assertNotNull(CastExpression_298_Var
		);
		//298
		final UnaryExpression UnaryExpression_299_Var
		 = (UnaryExpression)CastExpression_298_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_299_Var
		);
		//299
		final PostfixExpression PostfixExpression_300_Var
		 = (PostfixExpression)UnaryExpression_299_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_300_Var
		);
		final EList<? extends EObject> Expr_300_list = PostfixExpression_300_Var
		.getExpr();
		Assert.assertNotNull(Expr_300_list);
		Assert.assertEquals(1, Expr_300_list.size());
		//300
		final PrimaryExpression PrimaryExpression_301_Var
		 = (PrimaryExpression)Expr_300_list.get(0);
		Assert.assertNotNull(PrimaryExpression_301_Var
		);
		//301
		final Constant Constant_302_Var
		 = (Constant)PrimaryExpression_301_Var
		.getConst();
		Assert.assertNotNull(Constant_302_Var
		);
		Assert.assertEquals("2", Constant_302_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_271_Var
		.getSemi());
		//302
		final Statement Statement_303_Var
		 = (Statement)Statement_10_list.get(10);
		Assert.assertNotNull(Statement_303_Var
		);
		//303
		final ExpressionStatement ExpressionStatement_304_Var
		 = (ExpressionStatement)Statement_303_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_304_Var
		);
		//304
		final Expression Expression_305_Var
		 = (Expression)ExpressionStatement_304_Var
		.getExpression();
		Assert.assertNotNull(Expression_305_Var
		);
		final EList<? extends EObject> ExprExpr_305_list = Expression_305_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_305_list);
		Assert.assertEquals(1, ExprExpr_305_list.size());
		//305
		final AssignmentExpression AssignmentExpression_306_Var
		 = (AssignmentExpression)ExprExpr_305_list.get(0);
		Assert.assertNotNull(AssignmentExpression_306_Var
		);
		//306
		final ConditionalExpression ConditionalExpression_307_Var
		 = (ConditionalExpression)AssignmentExpression_306_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_307_Var
		);
		//307
		final LogicalOrExpression LogicalOrExpression_308_Var
		 = (LogicalOrExpression)ConditionalExpression_307_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_308_Var
		);
		final EList<? extends EObject> Expr_308_list = LogicalOrExpression_308_Var
		.getExpr();
		Assert.assertNotNull(Expr_308_list);
		Assert.assertEquals(2, Expr_308_list.size());
		//308
		final LogicalAndExpression LogicalAndExpression_309_Var
		 = (LogicalAndExpression)Expr_308_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_309_Var
		);
		final EList<? extends EObject> Expr_309_list = LogicalAndExpression_309_Var
		.getExpr();
		Assert.assertNotNull(Expr_309_list);
		Assert.assertEquals(1, Expr_309_list.size());
		//309
		final InclusiveOrExpression InclusiveOrExpression_310_Var
		 = (InclusiveOrExpression)Expr_309_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_310_Var
		);
		final EList<? extends EObject> Expr_310_list = InclusiveOrExpression_310_Var
		.getExpr();
		Assert.assertNotNull(Expr_310_list);
		Assert.assertEquals(1, Expr_310_list.size());
		//310
		final ExclusiveOrExpression ExclusiveOrExpression_311_Var
		 = (ExclusiveOrExpression)Expr_310_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = ExclusiveOrExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final AndExpression AndExpression_312_Var
		 = (AndExpression)Expr_311_list.get(0);
		Assert.assertNotNull(AndExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = AndExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final EqualityExpression EqualityExpression_313_Var
		 = (EqualityExpression)Expr_312_list.get(0);
		Assert.assertNotNull(EqualityExpression_313_Var
		);
		final EList<? extends EObject> Expr_313_list = EqualityExpression_313_Var
		.getExpr();
		Assert.assertNotNull(Expr_313_list);
		Assert.assertEquals(1, Expr_313_list.size());
		//313
		final RelationalExpression RelationalExpression_314_Var
		 = (RelationalExpression)Expr_313_list.get(0);
		Assert.assertNotNull(RelationalExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = RelationalExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final ShiftExpression ShiftExpression_315_Var
		 = (ShiftExpression)Expr_314_list.get(0);
		Assert.assertNotNull(ShiftExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = ShiftExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final AdditiveExpression AdditiveExpression_316_Var
		 = (AdditiveExpression)Expr_315_list.get(0);
		Assert.assertNotNull(AdditiveExpression_316_Var
		);
		final EList<? extends EObject> Expr_316_list = AdditiveExpression_316_Var
		.getExpr();
		Assert.assertNotNull(Expr_316_list);
		Assert.assertEquals(1, Expr_316_list.size());
		//316
		final MultiplicativeExpression MultiplicativeExpression_317_Var
		 = (MultiplicativeExpression)Expr_316_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_317_Var
		);
		final EList<? extends EObject> Expr_317_list = MultiplicativeExpression_317_Var
		.getExpr();
		Assert.assertNotNull(Expr_317_list);
		Assert.assertEquals(1, Expr_317_list.size());
		//317
		final CastExpression CastExpression_318_Var
		 = (CastExpression)Expr_317_list.get(0);
		Assert.assertNotNull(CastExpression_318_Var
		);
		//318
		final UnaryExpression UnaryExpression_319_Var
		 = (UnaryExpression)CastExpression_318_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_319_Var
		);
		//319
		final PostfixExpression PostfixExpression_320_Var
		 = (PostfixExpression)UnaryExpression_319_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_320_Var
		);
		final EList<? extends EObject> Expr_320_list = PostfixExpression_320_Var
		.getExpr();
		Assert.assertNotNull(Expr_320_list);
		Assert.assertEquals(1, Expr_320_list.size());
		//320
		final PrimaryExpression PrimaryExpression_321_Var
		 = (PrimaryExpression)Expr_320_list.get(0);
		Assert.assertNotNull(PrimaryExpression_321_Var
		);
		//321
		final Constant Constant_322_Var
		 = (Constant)PrimaryExpression_321_Var
		.getConst();
		Assert.assertNotNull(Constant_322_Var
		);
		Assert.assertEquals("1", Constant_322_Var
		.getDec());
		//322
		final LogicalAndExpression LogicalAndExpression_323_Var
		 = (LogicalAndExpression)Expr_308_list.get(1);
		Assert.assertNotNull(LogicalAndExpression_323_Var
		);
		final EList<? extends EObject> Expr_323_list = LogicalAndExpression_323_Var
		.getExpr();
		Assert.assertNotNull(Expr_323_list);
		Assert.assertEquals(1, Expr_323_list.size());
		//323
		final InclusiveOrExpression InclusiveOrExpression_324_Var
		 = (InclusiveOrExpression)Expr_323_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_324_Var
		);
		final EList<? extends EObject> Expr_324_list = InclusiveOrExpression_324_Var
		.getExpr();
		Assert.assertNotNull(Expr_324_list);
		Assert.assertEquals(1, Expr_324_list.size());
		//324
		final ExclusiveOrExpression ExclusiveOrExpression_325_Var
		 = (ExclusiveOrExpression)Expr_324_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_325_Var
		);
		final EList<? extends EObject> Expr_325_list = ExclusiveOrExpression_325_Var
		.getExpr();
		Assert.assertNotNull(Expr_325_list);
		Assert.assertEquals(1, Expr_325_list.size());
		//325
		final AndExpression AndExpression_326_Var
		 = (AndExpression)Expr_325_list.get(0);
		Assert.assertNotNull(AndExpression_326_Var
		);
		final EList<? extends EObject> Expr_326_list = AndExpression_326_Var
		.getExpr();
		Assert.assertNotNull(Expr_326_list);
		Assert.assertEquals(1, Expr_326_list.size());
		//326
		final EqualityExpression EqualityExpression_327_Var
		 = (EqualityExpression)Expr_326_list.get(0);
		Assert.assertNotNull(EqualityExpression_327_Var
		);
		final EList<? extends EObject> Expr_327_list = EqualityExpression_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final RelationalExpression RelationalExpression_328_Var
		 = (RelationalExpression)Expr_327_list.get(0);
		Assert.assertNotNull(RelationalExpression_328_Var
		);
		final EList<? extends EObject> Expr_328_list = RelationalExpression_328_Var
		.getExpr();
		Assert.assertNotNull(Expr_328_list);
		Assert.assertEquals(1, Expr_328_list.size());
		//328
		final ShiftExpression ShiftExpression_329_Var
		 = (ShiftExpression)Expr_328_list.get(0);
		Assert.assertNotNull(ShiftExpression_329_Var
		);
		final EList<? extends EObject> Expr_329_list = ShiftExpression_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final AdditiveExpression AdditiveExpression_330_Var
		 = (AdditiveExpression)Expr_329_list.get(0);
		Assert.assertNotNull(AdditiveExpression_330_Var
		);
		final EList<? extends EObject> Expr_330_list = AdditiveExpression_330_Var
		.getExpr();
		Assert.assertNotNull(Expr_330_list);
		Assert.assertEquals(1, Expr_330_list.size());
		//330
		final MultiplicativeExpression MultiplicativeExpression_331_Var
		 = (MultiplicativeExpression)Expr_330_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = MultiplicativeExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final CastExpression CastExpression_332_Var
		 = (CastExpression)Expr_331_list.get(0);
		Assert.assertNotNull(CastExpression_332_Var
		);
		//332
		final UnaryExpression UnaryExpression_333_Var
		 = (UnaryExpression)CastExpression_332_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_333_Var
		);
		//333
		final PostfixExpression PostfixExpression_334_Var
		 = (PostfixExpression)UnaryExpression_333_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = PostfixExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final PrimaryExpression PrimaryExpression_335_Var
		 = (PrimaryExpression)Expr_334_list.get(0);
		Assert.assertNotNull(PrimaryExpression_335_Var
		);
		//335
		final Constant Constant_336_Var
		 = (Constant)PrimaryExpression_335_Var
		.getConst();
		Assert.assertNotNull(Constant_336_Var
		);
		Assert.assertEquals("2", Constant_336_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_304_Var
		.getSemi());
		//336
		final Statement Statement_337_Var
		 = (Statement)Statement_10_list.get(11);
		Assert.assertNotNull(Statement_337_Var
		);
		//337
		final ExpressionStatement ExpressionStatement_338_Var
		 = (ExpressionStatement)Statement_337_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_338_Var
		);
		//338
		final Expression Expression_339_Var
		 = (Expression)ExpressionStatement_338_Var
		.getExpression();
		Assert.assertNotNull(Expression_339_Var
		);
		final EList<? extends EObject> ExprExpr_339_list = Expression_339_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_339_list);
		Assert.assertEquals(1, ExprExpr_339_list.size());
		//339
		final AssignmentExpression AssignmentExpression_340_Var
		 = (AssignmentExpression)ExprExpr_339_list.get(0);
		Assert.assertNotNull(AssignmentExpression_340_Var
		);
		//340
		final ConditionalExpression ConditionalExpression_341_Var
		 = (ConditionalExpression)AssignmentExpression_340_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_341_Var
		);
		//341
		final LogicalOrExpression LogicalOrExpression_342_Var
		 = (LogicalOrExpression)ConditionalExpression_341_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_342_Var
		);
		final EList<? extends EObject> Expr_342_list = LogicalOrExpression_342_Var
		.getExpr();
		Assert.assertNotNull(Expr_342_list);
		Assert.assertEquals(1, Expr_342_list.size());
		//342
		final LogicalAndExpression LogicalAndExpression_343_Var
		 = (LogicalAndExpression)Expr_342_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_343_Var
		);
		final EList<? extends EObject> Expr_343_list = LogicalAndExpression_343_Var
		.getExpr();
		Assert.assertNotNull(Expr_343_list);
		Assert.assertEquals(1, Expr_343_list.size());
		//343
		final InclusiveOrExpression InclusiveOrExpression_344_Var
		 = (InclusiveOrExpression)Expr_343_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_344_Var
		);
		final EList<? extends EObject> Expr_344_list = InclusiveOrExpression_344_Var
		.getExpr();
		Assert.assertNotNull(Expr_344_list);
		Assert.assertEquals(1, Expr_344_list.size());
		//344
		final ExclusiveOrExpression ExclusiveOrExpression_345_Var
		 = (ExclusiveOrExpression)Expr_344_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_345_Var
		);
		final EList<? extends EObject> Expr_345_list = ExclusiveOrExpression_345_Var
		.getExpr();
		Assert.assertNotNull(Expr_345_list);
		Assert.assertEquals(1, Expr_345_list.size());
		//345
		final AndExpression AndExpression_346_Var
		 = (AndExpression)Expr_345_list.get(0);
		Assert.assertNotNull(AndExpression_346_Var
		);
		final EList<? extends EObject> Expr_346_list = AndExpression_346_Var
		.getExpr();
		Assert.assertNotNull(Expr_346_list);
		Assert.assertEquals(1, Expr_346_list.size());
		//346
		final EqualityExpression EqualityExpression_347_Var
		 = (EqualityExpression)Expr_346_list.get(0);
		Assert.assertNotNull(EqualityExpression_347_Var
		);
		final EList<? extends EObject> Expr_347_list = EqualityExpression_347_Var
		.getExpr();
		Assert.assertNotNull(Expr_347_list);
		Assert.assertEquals(1, Expr_347_list.size());
		//347
		final RelationalExpression RelationalExpression_348_Var
		 = (RelationalExpression)Expr_347_list.get(0);
		Assert.assertNotNull(RelationalExpression_348_Var
		);
		final EList<? extends EObject> Expr_348_list = RelationalExpression_348_Var
		.getExpr();
		Assert.assertNotNull(Expr_348_list);
		Assert.assertEquals(1, Expr_348_list.size());
		//348
		final ShiftExpression ShiftExpression_349_Var
		 = (ShiftExpression)Expr_348_list.get(0);
		Assert.assertNotNull(ShiftExpression_349_Var
		);
		final EList<? extends EObject> Expr_349_list = ShiftExpression_349_Var
		.getExpr();
		Assert.assertNotNull(Expr_349_list);
		Assert.assertEquals(1, Expr_349_list.size());
		//349
		final AdditiveExpression AdditiveExpression_350_Var
		 = (AdditiveExpression)Expr_349_list.get(0);
		Assert.assertNotNull(AdditiveExpression_350_Var
		);
		final EList<? extends EObject> Expr_350_list = AdditiveExpression_350_Var
		.getExpr();
		Assert.assertNotNull(Expr_350_list);
		Assert.assertEquals(1, Expr_350_list.size());
		//350
		final MultiplicativeExpression MultiplicativeExpression_351_Var
		 = (MultiplicativeExpression)Expr_350_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_351_Var
		);
		final EList<? extends EObject> Expr_351_list = MultiplicativeExpression_351_Var
		.getExpr();
		Assert.assertNotNull(Expr_351_list);
		Assert.assertEquals(1, Expr_351_list.size());
		//351
		final CastExpression CastExpression_352_Var
		 = (CastExpression)Expr_351_list.get(0);
		Assert.assertNotNull(CastExpression_352_Var
		);
		//352
		final UnaryExpression UnaryExpression_353_Var
		 = (UnaryExpression)CastExpression_352_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_353_Var
		);
		//353
		final PostfixExpression PostfixExpression_354_Var
		 = (PostfixExpression)UnaryExpression_353_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_354_Var
		);
		final EList<? extends EObject> Expr_354_list = PostfixExpression_354_Var
		.getExpr();
		Assert.assertNotNull(Expr_354_list);
		Assert.assertEquals(1, Expr_354_list.size());
		//354
		final PrimaryExpression PrimaryExpression_355_Var
		 = (PrimaryExpression)Expr_354_list.get(0);
		Assert.assertNotNull(PrimaryExpression_355_Var
		);
		//355
		final Constant Constant_356_Var
		 = (Constant)PrimaryExpression_355_Var
		.getConst();
		Assert.assertNotNull(Constant_356_Var
		);
		Assert.assertEquals("1", Constant_356_Var
		.getDec());
		//356
		final Expression Expression_357_Var
		 = (Expression)ConditionalExpression_341_Var
		.getQExpr();
		Assert.assertNotNull(Expression_357_Var
		);
		final EList<? extends EObject> ExprExpr_357_list = Expression_357_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_357_list);
		Assert.assertEquals(1, ExprExpr_357_list.size());
		//357
		final AssignmentExpression AssignmentExpression_358_Var
		 = (AssignmentExpression)ExprExpr_357_list.get(0);
		Assert.assertNotNull(AssignmentExpression_358_Var
		);
		//358
		final ConditionalExpression ConditionalExpression_359_Var
		 = (ConditionalExpression)AssignmentExpression_358_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_359_Var
		);
		//359
		final LogicalOrExpression LogicalOrExpression_360_Var
		 = (LogicalOrExpression)ConditionalExpression_359_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_360_Var
		);
		final EList<? extends EObject> Expr_360_list = LogicalOrExpression_360_Var
		.getExpr();
		Assert.assertNotNull(Expr_360_list);
		Assert.assertEquals(1, Expr_360_list.size());
		//360
		final LogicalAndExpression LogicalAndExpression_361_Var
		 = (LogicalAndExpression)Expr_360_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_361_Var
		);
		final EList<? extends EObject> Expr_361_list = LogicalAndExpression_361_Var
		.getExpr();
		Assert.assertNotNull(Expr_361_list);
		Assert.assertEquals(1, Expr_361_list.size());
		//361
		final InclusiveOrExpression InclusiveOrExpression_362_Var
		 = (InclusiveOrExpression)Expr_361_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_362_Var
		);
		final EList<? extends EObject> Expr_362_list = InclusiveOrExpression_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(1, Expr_362_list.size());
		//362
		final ExclusiveOrExpression ExclusiveOrExpression_363_Var
		 = (ExclusiveOrExpression)Expr_362_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_363_Var
		);
		final EList<? extends EObject> Expr_363_list = ExclusiveOrExpression_363_Var
		.getExpr();
		Assert.assertNotNull(Expr_363_list);
		Assert.assertEquals(1, Expr_363_list.size());
		//363
		final AndExpression AndExpression_364_Var
		 = (AndExpression)Expr_363_list.get(0);
		Assert.assertNotNull(AndExpression_364_Var
		);
		final EList<? extends EObject> Expr_364_list = AndExpression_364_Var
		.getExpr();
		Assert.assertNotNull(Expr_364_list);
		Assert.assertEquals(1, Expr_364_list.size());
		//364
		final EqualityExpression EqualityExpression_365_Var
		 = (EqualityExpression)Expr_364_list.get(0);
		Assert.assertNotNull(EqualityExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = EqualityExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final RelationalExpression RelationalExpression_366_Var
		 = (RelationalExpression)Expr_365_list.get(0);
		Assert.assertNotNull(RelationalExpression_366_Var
		);
		final EList<? extends EObject> Expr_366_list = RelationalExpression_366_Var
		.getExpr();
		Assert.assertNotNull(Expr_366_list);
		Assert.assertEquals(1, Expr_366_list.size());
		//366
		final ShiftExpression ShiftExpression_367_Var
		 = (ShiftExpression)Expr_366_list.get(0);
		Assert.assertNotNull(ShiftExpression_367_Var
		);
		final EList<? extends EObject> Expr_367_list = ShiftExpression_367_Var
		.getExpr();
		Assert.assertNotNull(Expr_367_list);
		Assert.assertEquals(1, Expr_367_list.size());
		//367
		final AdditiveExpression AdditiveExpression_368_Var
		 = (AdditiveExpression)Expr_367_list.get(0);
		Assert.assertNotNull(AdditiveExpression_368_Var
		);
		final EList<? extends EObject> Expr_368_list = AdditiveExpression_368_Var
		.getExpr();
		Assert.assertNotNull(Expr_368_list);
		Assert.assertEquals(1, Expr_368_list.size());
		//368
		final MultiplicativeExpression MultiplicativeExpression_369_Var
		 = (MultiplicativeExpression)Expr_368_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_369_Var
		);
		final EList<? extends EObject> Expr_369_list = MultiplicativeExpression_369_Var
		.getExpr();
		Assert.assertNotNull(Expr_369_list);
		Assert.assertEquals(1, Expr_369_list.size());
		//369
		final CastExpression CastExpression_370_Var
		 = (CastExpression)Expr_369_list.get(0);
		Assert.assertNotNull(CastExpression_370_Var
		);
		//370
		final UnaryExpression UnaryExpression_371_Var
		 = (UnaryExpression)CastExpression_370_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_371_Var
		);
		//371
		final PostfixExpression PostfixExpression_372_Var
		 = (PostfixExpression)UnaryExpression_371_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_372_Var
		);
		final EList<? extends EObject> Expr_372_list = PostfixExpression_372_Var
		.getExpr();
		Assert.assertNotNull(Expr_372_list);
		Assert.assertEquals(1, Expr_372_list.size());
		//372
		final PrimaryExpression PrimaryExpression_373_Var
		 = (PrimaryExpression)Expr_372_list.get(0);
		Assert.assertNotNull(PrimaryExpression_373_Var
		);
		//373
		final Constant Constant_374_Var
		 = (Constant)PrimaryExpression_373_Var
		.getConst();
		Assert.assertNotNull(Constant_374_Var
		);
		Assert.assertEquals("2", Constant_374_Var
		.getDec());
		//374
		final ConditionalExpression ConditionalExpression_375_Var
		 = (ConditionalExpression)ConditionalExpression_341_Var
		.getCExpr();
		Assert.assertNotNull(ConditionalExpression_375_Var
		);
		//375
		final LogicalOrExpression LogicalOrExpression_376_Var
		 = (LogicalOrExpression)ConditionalExpression_375_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_376_Var
		);
		final EList<? extends EObject> Expr_376_list = LogicalOrExpression_376_Var
		.getExpr();
		Assert.assertNotNull(Expr_376_list);
		Assert.assertEquals(1, Expr_376_list.size());
		//376
		final LogicalAndExpression LogicalAndExpression_377_Var
		 = (LogicalAndExpression)Expr_376_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_377_Var
		);
		final EList<? extends EObject> Expr_377_list = LogicalAndExpression_377_Var
		.getExpr();
		Assert.assertNotNull(Expr_377_list);
		Assert.assertEquals(1, Expr_377_list.size());
		//377
		final InclusiveOrExpression InclusiveOrExpression_378_Var
		 = (InclusiveOrExpression)Expr_377_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_378_Var
		);
		final EList<? extends EObject> Expr_378_list = InclusiveOrExpression_378_Var
		.getExpr();
		Assert.assertNotNull(Expr_378_list);
		Assert.assertEquals(1, Expr_378_list.size());
		//378
		final ExclusiveOrExpression ExclusiveOrExpression_379_Var
		 = (ExclusiveOrExpression)Expr_378_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_379_Var
		);
		final EList<? extends EObject> Expr_379_list = ExclusiveOrExpression_379_Var
		.getExpr();
		Assert.assertNotNull(Expr_379_list);
		Assert.assertEquals(1, Expr_379_list.size());
		//379
		final AndExpression AndExpression_380_Var
		 = (AndExpression)Expr_379_list.get(0);
		Assert.assertNotNull(AndExpression_380_Var
		);
		final EList<? extends EObject> Expr_380_list = AndExpression_380_Var
		.getExpr();
		Assert.assertNotNull(Expr_380_list);
		Assert.assertEquals(1, Expr_380_list.size());
		//380
		final EqualityExpression EqualityExpression_381_Var
		 = (EqualityExpression)Expr_380_list.get(0);
		Assert.assertNotNull(EqualityExpression_381_Var
		);
		final EList<? extends EObject> Expr_381_list = EqualityExpression_381_Var
		.getExpr();
		Assert.assertNotNull(Expr_381_list);
		Assert.assertEquals(1, Expr_381_list.size());
		//381
		final RelationalExpression RelationalExpression_382_Var
		 = (RelationalExpression)Expr_381_list.get(0);
		Assert.assertNotNull(RelationalExpression_382_Var
		);
		final EList<? extends EObject> Expr_382_list = RelationalExpression_382_Var
		.getExpr();
		Assert.assertNotNull(Expr_382_list);
		Assert.assertEquals(1, Expr_382_list.size());
		//382
		final ShiftExpression ShiftExpression_383_Var
		 = (ShiftExpression)Expr_382_list.get(0);
		Assert.assertNotNull(ShiftExpression_383_Var
		);
		final EList<? extends EObject> Expr_383_list = ShiftExpression_383_Var
		.getExpr();
		Assert.assertNotNull(Expr_383_list);
		Assert.assertEquals(1, Expr_383_list.size());
		//383
		final AdditiveExpression AdditiveExpression_384_Var
		 = (AdditiveExpression)Expr_383_list.get(0);
		Assert.assertNotNull(AdditiveExpression_384_Var
		);
		final EList<? extends EObject> Expr_384_list = AdditiveExpression_384_Var
		.getExpr();
		Assert.assertNotNull(Expr_384_list);
		Assert.assertEquals(1, Expr_384_list.size());
		//384
		final MultiplicativeExpression MultiplicativeExpression_385_Var
		 = (MultiplicativeExpression)Expr_384_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_385_Var
		);
		final EList<? extends EObject> Expr_385_list = MultiplicativeExpression_385_Var
		.getExpr();
		Assert.assertNotNull(Expr_385_list);
		Assert.assertEquals(1, Expr_385_list.size());
		//385
		final CastExpression CastExpression_386_Var
		 = (CastExpression)Expr_385_list.get(0);
		Assert.assertNotNull(CastExpression_386_Var
		);
		//386
		final UnaryExpression UnaryExpression_387_Var
		 = (UnaryExpression)CastExpression_386_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_387_Var
		);
		//387
		final PostfixExpression PostfixExpression_388_Var
		 = (PostfixExpression)UnaryExpression_387_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_388_Var
		);
		final EList<? extends EObject> Expr_388_list = PostfixExpression_388_Var
		.getExpr();
		Assert.assertNotNull(Expr_388_list);
		Assert.assertEquals(1, Expr_388_list.size());
		//388
		final PrimaryExpression PrimaryExpression_389_Var
		 = (PrimaryExpression)Expr_388_list.get(0);
		Assert.assertNotNull(PrimaryExpression_389_Var
		);
		//389
		final Constant Constant_390_Var
		 = (Constant)PrimaryExpression_389_Var
		.getConst();
		Assert.assertNotNull(Constant_390_Var
		);
		Assert.assertEquals("3", Constant_390_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_338_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0012_ExprHell.c");
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
				method.invoke(this.generator, "Test0012_ExprHell.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0012_ExprHell.c");
		final String expected = this.getTextFromFile(
			"res/Test0012_ExprHell.c"
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


