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
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
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
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.common.common.Constant2;
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
public class Test0012_ExprHell {
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
			"res/Test0012_ExprHell.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_VOID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_STAR", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_LEFTSHIFT", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_LESS", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_EQUAL", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_AND", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_OR", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_CARET", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_ANDAND", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_OROR", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_QUESTION", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_COLON", 
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
			"res/Test0012_ExprHell.c");
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
		final FunctionDefHead FunctionDefHead_2_Var
		 = (FunctionDefHead)ExternalDeclaration_1_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_2_Var
		);
		//2
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_3_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_2_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_3_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_3_list = FunctionDeclarationSpecifiers_3_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_3_list);
		Assert.assertEquals(1, DeclarationSpecifier_3_list.size());
		//3
		final TypeSpecifier TypeSpecifier_4_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(TypeSpecifier_4_Var
		);
		Assert.assertEquals("void", TypeSpecifier_4_Var
		.getName());
		//4
		final Declarator Declarator_5_Var
		 = (Declarator)FunctionDefHead_2_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_5_Var
		);
		//5
		final DirectDeclarator DirectDeclarator_6_Var
		 = (DirectDeclarator)Declarator_5_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_6_Var
		);
		Assert.assertEquals("doSomething", DirectDeclarator_6_Var
		.getId());
		//6
		final FunctionDefinition FunctionDefinition_7_Var
		 = (FunctionDefinition)ExternalDeclaration_1_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_7_Var
		);
		//7
		final BodyStatement BodyStatement_8_Var
		 = (BodyStatement)FunctionDefinition_7_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_8_Var
		);
		final EList<? extends EObject> BlockList_8_list = BodyStatement_8_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_8_list);
		Assert.assertEquals(1, BlockList_8_list.size());
		//8
		final BlockList BlockList_9_Var
		 = (BlockList)BlockList_8_list.get(0);
		Assert.assertNotNull(BlockList_9_Var
		);
		final EList<? extends EObject> Statement_9_list = BlockList_9_Var
		.getStatement();
		Assert.assertNotNull(Statement_9_list);
		Assert.assertEquals(12, Statement_9_list.size());
		//9
		final Statement Statement_10_Var
		 = (Statement)Statement_9_list.get(0);
		Assert.assertNotNull(Statement_10_Var
		);
		//10
		final ExpressionStatement ExpressionStatement_11_Var
		 = (ExpressionStatement)Statement_10_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_11_Var
		);
		//11
		final Expression Expression_12_Var
		 = (Expression)ExpressionStatement_11_Var
		.getExpression();
		Assert.assertNotNull(Expression_12_Var
		);
		final EList<? extends EObject> ExprExpr_12_list = Expression_12_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_12_list);
		Assert.assertEquals(1, ExprExpr_12_list.size());
		//12
		final AssignmentExpression AssignmentExpression_13_Var
		 = (AssignmentExpression)ExprExpr_12_list.get(0);
		Assert.assertNotNull(AssignmentExpression_13_Var
		);
		//13
		final ConditionalExpression ConditionalExpression_14_Var
		 = (ConditionalExpression)AssignmentExpression_13_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_14_Var
		);
		//14
		final LogicalOrExpression LogicalOrExpression_15_Var
		 = (LogicalOrExpression)ConditionalExpression_14_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = LogicalOrExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final LogicalAndExpression LogicalAndExpression_16_Var
		 = (LogicalAndExpression)Expr_15_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = LogicalAndExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final InclusiveOrExpression InclusiveOrExpression_17_Var
		 = (InclusiveOrExpression)Expr_16_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = InclusiveOrExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final ExclusiveOrExpression ExclusiveOrExpression_18_Var
		 = (ExclusiveOrExpression)Expr_17_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = ExclusiveOrExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final AndExpression AndExpression_19_Var
		 = (AndExpression)Expr_18_list.get(0);
		Assert.assertNotNull(AndExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = AndExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final EqualityExpression EqualityExpression_20_Var
		 = (EqualityExpression)Expr_19_list.get(0);
		Assert.assertNotNull(EqualityExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = EqualityExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final RelationalExpression RelationalExpression_21_Var
		 = (RelationalExpression)Expr_20_list.get(0);
		Assert.assertNotNull(RelationalExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = RelationalExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final ShiftExpression ShiftExpression_22_Var
		 = (ShiftExpression)Expr_21_list.get(0);
		Assert.assertNotNull(ShiftExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = ShiftExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final AdditiveExpression AdditiveExpression_23_Var
		 = (AdditiveExpression)Expr_22_list.get(0);
		Assert.assertNotNull(AdditiveExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = AdditiveExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final MultiplicativeExpression MultiplicativeExpression_24_Var
		 = (MultiplicativeExpression)Expr_23_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = MultiplicativeExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final CastExpression CastExpression_25_Var
		 = (CastExpression)Expr_24_list.get(0);
		Assert.assertNotNull(CastExpression_25_Var
		);
		//25
		final UnaryExpression UnaryExpression_26_Var
		 = (UnaryExpression)CastExpression_25_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_26_Var
		);
		//26
		final PostfixExpression PostfixExpression_27_Var
		 = (PostfixExpression)UnaryExpression_26_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = PostfixExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final PrimaryExpression PrimaryExpression_28_Var
		 = (PrimaryExpression)Expr_27_list.get(0);
		Assert.assertNotNull(PrimaryExpression_28_Var
		);
		//28
		final Constant2 Constant2_29_Var
		 = (Constant2)PrimaryExpression_28_Var
		.getConst();
		Assert.assertNotNull(Constant2_29_Var
		);
		Assert.assertEquals("1", Constant2_29_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_11_Var
		.getSemi());
		//29
		final Statement Statement_30_Var
		 = (Statement)Statement_9_list.get(1);
		Assert.assertNotNull(Statement_30_Var
		);
		//30
		final ExpressionStatement ExpressionStatement_31_Var
		 = (ExpressionStatement)Statement_30_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_31_Var
		);
		//31
		final Expression Expression_32_Var
		 = (Expression)ExpressionStatement_31_Var
		.getExpression();
		Assert.assertNotNull(Expression_32_Var
		);
		final EList<? extends EObject> ExprExpr_32_list = Expression_32_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_32_list);
		Assert.assertEquals(1, ExprExpr_32_list.size());
		//32
		final AssignmentExpression AssignmentExpression_33_Var
		 = (AssignmentExpression)ExprExpr_32_list.get(0);
		Assert.assertNotNull(AssignmentExpression_33_Var
		);
		//33
		final ConditionalExpression ConditionalExpression_34_Var
		 = (ConditionalExpression)AssignmentExpression_33_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_34_Var
		);
		//34
		final LogicalOrExpression LogicalOrExpression_35_Var
		 = (LogicalOrExpression)ConditionalExpression_34_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = LogicalOrExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final LogicalAndExpression LogicalAndExpression_36_Var
		 = (LogicalAndExpression)Expr_35_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = LogicalAndExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final InclusiveOrExpression InclusiveOrExpression_37_Var
		 = (InclusiveOrExpression)Expr_36_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = InclusiveOrExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final ExclusiveOrExpression ExclusiveOrExpression_38_Var
		 = (ExclusiveOrExpression)Expr_37_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = ExclusiveOrExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final AndExpression AndExpression_39_Var
		 = (AndExpression)Expr_38_list.get(0);
		Assert.assertNotNull(AndExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = AndExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final EqualityExpression EqualityExpression_40_Var
		 = (EqualityExpression)Expr_39_list.get(0);
		Assert.assertNotNull(EqualityExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = EqualityExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final RelationalExpression RelationalExpression_41_Var
		 = (RelationalExpression)Expr_40_list.get(0);
		Assert.assertNotNull(RelationalExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = RelationalExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final ShiftExpression ShiftExpression_42_Var
		 = (ShiftExpression)Expr_41_list.get(0);
		Assert.assertNotNull(ShiftExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = ShiftExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final AdditiveExpression AdditiveExpression_43_Var
		 = (AdditiveExpression)Expr_42_list.get(0);
		Assert.assertNotNull(AdditiveExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = AdditiveExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final MultiplicativeExpression MultiplicativeExpression_44_Var
		 = (MultiplicativeExpression)Expr_43_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = MultiplicativeExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final CastExpression CastExpression_45_Var
		 = (CastExpression)Expr_44_list.get(0);
		Assert.assertNotNull(CastExpression_45_Var
		);
		//45
		final UnaryExpression UnaryExpression_46_Var
		 = (UnaryExpression)CastExpression_45_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_46_Var
		);
		//46
		final PostfixExpression PostfixExpression_47_Var
		 = (PostfixExpression)UnaryExpression_46_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = PostfixExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final PrimaryExpression PrimaryExpression_48_Var
		 = (PrimaryExpression)Expr_47_list.get(0);
		Assert.assertNotNull(PrimaryExpression_48_Var
		);
		//48
		final Expression Expression_49_Var
		 = (Expression)PrimaryExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expression_49_Var
		);
		final EList<? extends EObject> ExprExpr_49_list = Expression_49_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_49_list);
		Assert.assertEquals(1, ExprExpr_49_list.size());
		//49
		final AssignmentExpression AssignmentExpression_50_Var
		 = (AssignmentExpression)ExprExpr_49_list.get(0);
		Assert.assertNotNull(AssignmentExpression_50_Var
		);
		//50
		final ConditionalExpression ConditionalExpression_51_Var
		 = (ConditionalExpression)AssignmentExpression_50_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_51_Var
		);
		//51
		final LogicalOrExpression LogicalOrExpression_52_Var
		 = (LogicalOrExpression)ConditionalExpression_51_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = LogicalOrExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final LogicalAndExpression LogicalAndExpression_53_Var
		 = (LogicalAndExpression)Expr_52_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = LogicalAndExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final InclusiveOrExpression InclusiveOrExpression_54_Var
		 = (InclusiveOrExpression)Expr_53_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = InclusiveOrExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final ExclusiveOrExpression ExclusiveOrExpression_55_Var
		 = (ExclusiveOrExpression)Expr_54_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = ExclusiveOrExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final AndExpression AndExpression_56_Var
		 = (AndExpression)Expr_55_list.get(0);
		Assert.assertNotNull(AndExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = AndExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final EqualityExpression EqualityExpression_57_Var
		 = (EqualityExpression)Expr_56_list.get(0);
		Assert.assertNotNull(EqualityExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = EqualityExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final RelationalExpression RelationalExpression_58_Var
		 = (RelationalExpression)Expr_57_list.get(0);
		Assert.assertNotNull(RelationalExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = RelationalExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final ShiftExpression ShiftExpression_59_Var
		 = (ShiftExpression)Expr_58_list.get(0);
		Assert.assertNotNull(ShiftExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = ShiftExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final AdditiveExpression AdditiveExpression_60_Var
		 = (AdditiveExpression)Expr_59_list.get(0);
		Assert.assertNotNull(AdditiveExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = AdditiveExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final MultiplicativeExpression MultiplicativeExpression_61_Var
		 = (MultiplicativeExpression)Expr_60_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = MultiplicativeExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final CastExpression CastExpression_62_Var
		 = (CastExpression)Expr_61_list.get(0);
		Assert.assertNotNull(CastExpression_62_Var
		);
		//62
		final UnaryExpression UnaryExpression_63_Var
		 = (UnaryExpression)CastExpression_62_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_63_Var
		);
		//63
		final PostfixExpression PostfixExpression_64_Var
		 = (PostfixExpression)UnaryExpression_63_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = PostfixExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final PrimaryExpression PrimaryExpression_65_Var
		 = (PrimaryExpression)Expr_64_list.get(0);
		Assert.assertNotNull(PrimaryExpression_65_Var
		);
		//65
		final Constant2 Constant2_66_Var
		 = (Constant2)PrimaryExpression_65_Var
		.getConst();
		Assert.assertNotNull(Constant2_66_Var
		);
		Assert.assertEquals("2", Constant2_66_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_31_Var
		.getSemi());
		//66
		final Statement Statement_67_Var
		 = (Statement)Statement_9_list.get(2);
		Assert.assertNotNull(Statement_67_Var
		);
		//67
		final ExpressionStatement ExpressionStatement_68_Var
		 = (ExpressionStatement)Statement_67_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_68_Var
		);
		//68
		final Expression Expression_69_Var
		 = (Expression)ExpressionStatement_68_Var
		.getExpression();
		Assert.assertNotNull(Expression_69_Var
		);
		final EList<? extends EObject> ExprExpr_69_list = Expression_69_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_69_list);
		Assert.assertEquals(1, ExprExpr_69_list.size());
		//69
		final AssignmentExpression AssignmentExpression_70_Var
		 = (AssignmentExpression)ExprExpr_69_list.get(0);
		Assert.assertNotNull(AssignmentExpression_70_Var
		);
		//70
		final ConditionalExpression ConditionalExpression_71_Var
		 = (ConditionalExpression)AssignmentExpression_70_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_71_Var
		);
		//71
		final LogicalOrExpression LogicalOrExpression_72_Var
		 = (LogicalOrExpression)ConditionalExpression_71_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = LogicalOrExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final LogicalAndExpression LogicalAndExpression_73_Var
		 = (LogicalAndExpression)Expr_72_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = LogicalAndExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final InclusiveOrExpression InclusiveOrExpression_74_Var
		 = (InclusiveOrExpression)Expr_73_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = InclusiveOrExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final ExclusiveOrExpression ExclusiveOrExpression_75_Var
		 = (ExclusiveOrExpression)Expr_74_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = ExclusiveOrExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final AndExpression AndExpression_76_Var
		 = (AndExpression)Expr_75_list.get(0);
		Assert.assertNotNull(AndExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = AndExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final EqualityExpression EqualityExpression_77_Var
		 = (EqualityExpression)Expr_76_list.get(0);
		Assert.assertNotNull(EqualityExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = EqualityExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final RelationalExpression RelationalExpression_78_Var
		 = (RelationalExpression)Expr_77_list.get(0);
		Assert.assertNotNull(RelationalExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = RelationalExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final ShiftExpression ShiftExpression_79_Var
		 = (ShiftExpression)Expr_78_list.get(0);
		Assert.assertNotNull(ShiftExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = ShiftExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final AdditiveExpression AdditiveExpression_80_Var
		 = (AdditiveExpression)Expr_79_list.get(0);
		Assert.assertNotNull(AdditiveExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = AdditiveExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final MultiplicativeExpression MultiplicativeExpression_81_Var
		 = (MultiplicativeExpression)Expr_80_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = MultiplicativeExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(2, Expr_81_list.size());
		//81
		final CastExpression CastExpression_82_Var
		 = (CastExpression)Expr_81_list.get(0);
		Assert.assertNotNull(CastExpression_82_Var
		);
		//82
		final UnaryExpression UnaryExpression_83_Var
		 = (UnaryExpression)CastExpression_82_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_83_Var
		);
		//83
		final PostfixExpression PostfixExpression_84_Var
		 = (PostfixExpression)UnaryExpression_83_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = PostfixExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final PrimaryExpression PrimaryExpression_85_Var
		 = (PrimaryExpression)Expr_84_list.get(0);
		Assert.assertNotNull(PrimaryExpression_85_Var
		);
		//85
		final Constant2 Constant2_86_Var
		 = (Constant2)PrimaryExpression_85_Var
		.getConst();
		Assert.assertNotNull(Constant2_86_Var
		);
		Assert.assertEquals("1", Constant2_86_Var
		.getDec());
		//86
		final CastExpression CastExpression_87_Var
		 = (CastExpression)Expr_81_list.get(1);
		Assert.assertNotNull(CastExpression_87_Var
		);
		//87
		final UnaryExpression UnaryExpression_88_Var
		 = (UnaryExpression)CastExpression_87_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_88_Var
		);
		//88
		final PostfixExpression PostfixExpression_89_Var
		 = (PostfixExpression)UnaryExpression_88_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = PostfixExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final PrimaryExpression PrimaryExpression_90_Var
		 = (PrimaryExpression)Expr_89_list.get(0);
		Assert.assertNotNull(PrimaryExpression_90_Var
		);
		//90
		final Constant2 Constant2_91_Var
		 = (Constant2)PrimaryExpression_90_Var
		.getConst();
		Assert.assertNotNull(Constant2_91_Var
		);
		Assert.assertEquals("2", Constant2_91_Var
		.getDec());
		Assert.assertEquals("[*]", MultiplicativeExpression_81_Var
		.getOp().toString());
		Assert.assertEquals(";", ExpressionStatement_68_Var
		.getSemi());
		//91
		final Statement Statement_92_Var
		 = (Statement)Statement_9_list.get(3);
		Assert.assertNotNull(Statement_92_Var
		);
		//92
		final ExpressionStatement ExpressionStatement_93_Var
		 = (ExpressionStatement)Statement_92_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_93_Var
		);
		//93
		final Expression Expression_94_Var
		 = (Expression)ExpressionStatement_93_Var
		.getExpression();
		Assert.assertNotNull(Expression_94_Var
		);
		final EList<? extends EObject> ExprExpr_94_list = Expression_94_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_94_list);
		Assert.assertEquals(1, ExprExpr_94_list.size());
		//94
		final AssignmentExpression AssignmentExpression_95_Var
		 = (AssignmentExpression)ExprExpr_94_list.get(0);
		Assert.assertNotNull(AssignmentExpression_95_Var
		);
		//95
		final ConditionalExpression ConditionalExpression_96_Var
		 = (ConditionalExpression)AssignmentExpression_95_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_96_Var
		);
		//96
		final LogicalOrExpression LogicalOrExpression_97_Var
		 = (LogicalOrExpression)ConditionalExpression_96_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = LogicalOrExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final LogicalAndExpression LogicalAndExpression_98_Var
		 = (LogicalAndExpression)Expr_97_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = LogicalAndExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final InclusiveOrExpression InclusiveOrExpression_99_Var
		 = (InclusiveOrExpression)Expr_98_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = InclusiveOrExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final ExclusiveOrExpression ExclusiveOrExpression_100_Var
		 = (ExclusiveOrExpression)Expr_99_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = ExclusiveOrExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final AndExpression AndExpression_101_Var
		 = (AndExpression)Expr_100_list.get(0);
		Assert.assertNotNull(AndExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = AndExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final EqualityExpression EqualityExpression_102_Var
		 = (EqualityExpression)Expr_101_list.get(0);
		Assert.assertNotNull(EqualityExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = EqualityExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final RelationalExpression RelationalExpression_103_Var
		 = (RelationalExpression)Expr_102_list.get(0);
		Assert.assertNotNull(RelationalExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = RelationalExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final ShiftExpression ShiftExpression_104_Var
		 = (ShiftExpression)Expr_103_list.get(0);
		Assert.assertNotNull(ShiftExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = ShiftExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(2, Expr_104_list.size());
		//104
		final AdditiveExpression AdditiveExpression_105_Var
		 = (AdditiveExpression)Expr_104_list.get(0);
		Assert.assertNotNull(AdditiveExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = AdditiveExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final MultiplicativeExpression MultiplicativeExpression_106_Var
		 = (MultiplicativeExpression)Expr_105_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = MultiplicativeExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final CastExpression CastExpression_107_Var
		 = (CastExpression)Expr_106_list.get(0);
		Assert.assertNotNull(CastExpression_107_Var
		);
		//107
		final UnaryExpression UnaryExpression_108_Var
		 = (UnaryExpression)CastExpression_107_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_108_Var
		);
		//108
		final PostfixExpression PostfixExpression_109_Var
		 = (PostfixExpression)UnaryExpression_108_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = PostfixExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final PrimaryExpression PrimaryExpression_110_Var
		 = (PrimaryExpression)Expr_109_list.get(0);
		Assert.assertNotNull(PrimaryExpression_110_Var
		);
		//110
		final Constant2 Constant2_111_Var
		 = (Constant2)PrimaryExpression_110_Var
		.getConst();
		Assert.assertNotNull(Constant2_111_Var
		);
		Assert.assertEquals("1", Constant2_111_Var
		.getDec());
		//111
		final AdditiveExpression AdditiveExpression_112_Var
		 = (AdditiveExpression)Expr_104_list.get(1);
		Assert.assertNotNull(AdditiveExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = AdditiveExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final MultiplicativeExpression MultiplicativeExpression_113_Var
		 = (MultiplicativeExpression)Expr_112_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = MultiplicativeExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final CastExpression CastExpression_114_Var
		 = (CastExpression)Expr_113_list.get(0);
		Assert.assertNotNull(CastExpression_114_Var
		);
		//114
		final UnaryExpression UnaryExpression_115_Var
		 = (UnaryExpression)CastExpression_114_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_115_Var
		);
		//115
		final PostfixExpression PostfixExpression_116_Var
		 = (PostfixExpression)UnaryExpression_115_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = PostfixExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final PrimaryExpression PrimaryExpression_117_Var
		 = (PrimaryExpression)Expr_116_list.get(0);
		Assert.assertNotNull(PrimaryExpression_117_Var
		);
		//117
		final Constant2 Constant2_118_Var
		 = (Constant2)PrimaryExpression_117_Var
		.getConst();
		Assert.assertNotNull(Constant2_118_Var
		);
		Assert.assertEquals("2", Constant2_118_Var
		.getDec());
		Assert.assertEquals("[<<]", ShiftExpression_104_Var
		.getOp().toString());
		Assert.assertEquals(";", ExpressionStatement_93_Var
		.getSemi());
		//118
		final Statement Statement_119_Var
		 = (Statement)Statement_9_list.get(4);
		Assert.assertNotNull(Statement_119_Var
		);
		//119
		final ExpressionStatement ExpressionStatement_120_Var
		 = (ExpressionStatement)Statement_119_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_120_Var
		);
		//120
		final Expression Expression_121_Var
		 = (Expression)ExpressionStatement_120_Var
		.getExpression();
		Assert.assertNotNull(Expression_121_Var
		);
		final EList<? extends EObject> ExprExpr_121_list = Expression_121_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_121_list);
		Assert.assertEquals(1, ExprExpr_121_list.size());
		//121
		final AssignmentExpression AssignmentExpression_122_Var
		 = (AssignmentExpression)ExprExpr_121_list.get(0);
		Assert.assertNotNull(AssignmentExpression_122_Var
		);
		//122
		final ConditionalExpression ConditionalExpression_123_Var
		 = (ConditionalExpression)AssignmentExpression_122_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_123_Var
		);
		//123
		final LogicalOrExpression LogicalOrExpression_124_Var
		 = (LogicalOrExpression)ConditionalExpression_123_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = LogicalOrExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final LogicalAndExpression LogicalAndExpression_125_Var
		 = (LogicalAndExpression)Expr_124_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = LogicalAndExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final InclusiveOrExpression InclusiveOrExpression_126_Var
		 = (InclusiveOrExpression)Expr_125_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = InclusiveOrExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final ExclusiveOrExpression ExclusiveOrExpression_127_Var
		 = (ExclusiveOrExpression)Expr_126_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = ExclusiveOrExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final AndExpression AndExpression_128_Var
		 = (AndExpression)Expr_127_list.get(0);
		Assert.assertNotNull(AndExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = AndExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final EqualityExpression EqualityExpression_129_Var
		 = (EqualityExpression)Expr_128_list.get(0);
		Assert.assertNotNull(EqualityExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = EqualityExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final RelationalExpression RelationalExpression_130_Var
		 = (RelationalExpression)Expr_129_list.get(0);
		Assert.assertNotNull(RelationalExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = RelationalExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(2, Expr_130_list.size());
		//130
		final ShiftExpression ShiftExpression_131_Var
		 = (ShiftExpression)Expr_130_list.get(0);
		Assert.assertNotNull(ShiftExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = ShiftExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final AdditiveExpression AdditiveExpression_132_Var
		 = (AdditiveExpression)Expr_131_list.get(0);
		Assert.assertNotNull(AdditiveExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = AdditiveExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final MultiplicativeExpression MultiplicativeExpression_133_Var
		 = (MultiplicativeExpression)Expr_132_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = MultiplicativeExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final CastExpression CastExpression_134_Var
		 = (CastExpression)Expr_133_list.get(0);
		Assert.assertNotNull(CastExpression_134_Var
		);
		//134
		final UnaryExpression UnaryExpression_135_Var
		 = (UnaryExpression)CastExpression_134_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_135_Var
		);
		//135
		final PostfixExpression PostfixExpression_136_Var
		 = (PostfixExpression)UnaryExpression_135_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = PostfixExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final PrimaryExpression PrimaryExpression_137_Var
		 = (PrimaryExpression)Expr_136_list.get(0);
		Assert.assertNotNull(PrimaryExpression_137_Var
		);
		//137
		final Constant2 Constant2_138_Var
		 = (Constant2)PrimaryExpression_137_Var
		.getConst();
		Assert.assertNotNull(Constant2_138_Var
		);
		Assert.assertEquals("1", Constant2_138_Var
		.getDec());
		//138
		final ShiftExpression ShiftExpression_139_Var
		 = (ShiftExpression)Expr_130_list.get(1);
		Assert.assertNotNull(ShiftExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = ShiftExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final AdditiveExpression AdditiveExpression_140_Var
		 = (AdditiveExpression)Expr_139_list.get(0);
		Assert.assertNotNull(AdditiveExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = AdditiveExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final MultiplicativeExpression MultiplicativeExpression_141_Var
		 = (MultiplicativeExpression)Expr_140_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = MultiplicativeExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final CastExpression CastExpression_142_Var
		 = (CastExpression)Expr_141_list.get(0);
		Assert.assertNotNull(CastExpression_142_Var
		);
		//142
		final UnaryExpression UnaryExpression_143_Var
		 = (UnaryExpression)CastExpression_142_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_143_Var
		);
		//143
		final PostfixExpression PostfixExpression_144_Var
		 = (PostfixExpression)UnaryExpression_143_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = PostfixExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final PrimaryExpression PrimaryExpression_145_Var
		 = (PrimaryExpression)Expr_144_list.get(0);
		Assert.assertNotNull(PrimaryExpression_145_Var
		);
		//145
		final Constant2 Constant2_146_Var
		 = (Constant2)PrimaryExpression_145_Var
		.getConst();
		Assert.assertNotNull(Constant2_146_Var
		);
		Assert.assertEquals("2", Constant2_146_Var
		.getDec());
		Assert.assertEquals("[<]", RelationalExpression_130_Var
		.getOp().toString());
		Assert.assertEquals(";", ExpressionStatement_120_Var
		.getSemi());
		//146
		final Statement Statement_147_Var
		 = (Statement)Statement_9_list.get(5);
		Assert.assertNotNull(Statement_147_Var
		);
		//147
		final ExpressionStatement ExpressionStatement_148_Var
		 = (ExpressionStatement)Statement_147_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_148_Var
		);
		//148
		final Expression Expression_149_Var
		 = (Expression)ExpressionStatement_148_Var
		.getExpression();
		Assert.assertNotNull(Expression_149_Var
		);
		final EList<? extends EObject> ExprExpr_149_list = Expression_149_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_149_list);
		Assert.assertEquals(1, ExprExpr_149_list.size());
		//149
		final AssignmentExpression AssignmentExpression_150_Var
		 = (AssignmentExpression)ExprExpr_149_list.get(0);
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
		Assert.assertEquals(2, Expr_157_list.size());
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
		//165
		final Constant2 Constant2_166_Var
		 = (Constant2)PrimaryExpression_165_Var
		.getConst();
		Assert.assertNotNull(Constant2_166_Var
		);
		Assert.assertEquals("1", Constant2_166_Var
		.getDec());
		//166
		final RelationalExpression RelationalExpression_167_Var
		 = (RelationalExpression)Expr_157_list.get(1);
		Assert.assertNotNull(RelationalExpression_167_Var
		);
		final EList<? extends EObject> Expr_167_list = RelationalExpression_167_Var
		.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(1, Expr_167_list.size());
		//167
		final ShiftExpression ShiftExpression_168_Var
		 = (ShiftExpression)Expr_167_list.get(0);
		Assert.assertNotNull(ShiftExpression_168_Var
		);
		final EList<? extends EObject> Expr_168_list = ShiftExpression_168_Var
		.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(1, Expr_168_list.size());
		//168
		final AdditiveExpression AdditiveExpression_169_Var
		 = (AdditiveExpression)Expr_168_list.get(0);
		Assert.assertNotNull(AdditiveExpression_169_Var
		);
		final EList<? extends EObject> Expr_169_list = AdditiveExpression_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		//169
		final MultiplicativeExpression MultiplicativeExpression_170_Var
		 = (MultiplicativeExpression)Expr_169_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_170_Var
		);
		final EList<? extends EObject> Expr_170_list = MultiplicativeExpression_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		//170
		final CastExpression CastExpression_171_Var
		 = (CastExpression)Expr_170_list.get(0);
		Assert.assertNotNull(CastExpression_171_Var
		);
		//171
		final UnaryExpression UnaryExpression_172_Var
		 = (UnaryExpression)CastExpression_171_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_172_Var
		);
		//172
		final PostfixExpression PostfixExpression_173_Var
		 = (PostfixExpression)UnaryExpression_172_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = PostfixExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final PrimaryExpression PrimaryExpression_174_Var
		 = (PrimaryExpression)Expr_173_list.get(0);
		Assert.assertNotNull(PrimaryExpression_174_Var
		);
		//174
		final Constant2 Constant2_175_Var
		 = (Constant2)PrimaryExpression_174_Var
		.getConst();
		Assert.assertNotNull(Constant2_175_Var
		);
		Assert.assertEquals("2", Constant2_175_Var
		.getDec());
		Assert.assertEquals("[==]", EqualityExpression_157_Var
		.getOp().toString());
		Assert.assertEquals(";", ExpressionStatement_148_Var
		.getSemi());
		//175
		final Statement Statement_176_Var
		 = (Statement)Statement_9_list.get(6);
		Assert.assertNotNull(Statement_176_Var
		);
		//176
		final ExpressionStatement ExpressionStatement_177_Var
		 = (ExpressionStatement)Statement_176_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_177_Var
		);
		//177
		final Expression Expression_178_Var
		 = (Expression)ExpressionStatement_177_Var
		.getExpression();
		Assert.assertNotNull(Expression_178_Var
		);
		final EList<? extends EObject> ExprExpr_178_list = Expression_178_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_178_list);
		Assert.assertEquals(1, ExprExpr_178_list.size());
		//178
		final AssignmentExpression AssignmentExpression_179_Var
		 = (AssignmentExpression)ExprExpr_178_list.get(0);
		Assert.assertNotNull(AssignmentExpression_179_Var
		);
		//179
		final ConditionalExpression ConditionalExpression_180_Var
		 = (ConditionalExpression)AssignmentExpression_179_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_180_Var
		);
		//180
		final LogicalOrExpression LogicalOrExpression_181_Var
		 = (LogicalOrExpression)ConditionalExpression_180_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_181_Var
		);
		final EList<? extends EObject> Expr_181_list = LogicalOrExpression_181_Var
		.getExpr();
		Assert.assertNotNull(Expr_181_list);
		Assert.assertEquals(1, Expr_181_list.size());
		//181
		final LogicalAndExpression LogicalAndExpression_182_Var
		 = (LogicalAndExpression)Expr_181_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_182_Var
		);
		final EList<? extends EObject> Expr_182_list = LogicalAndExpression_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(1, Expr_182_list.size());
		//182
		final InclusiveOrExpression InclusiveOrExpression_183_Var
		 = (InclusiveOrExpression)Expr_182_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = InclusiveOrExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final ExclusiveOrExpression ExclusiveOrExpression_184_Var
		 = (ExclusiveOrExpression)Expr_183_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = ExclusiveOrExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final AndExpression AndExpression_185_Var
		 = (AndExpression)Expr_184_list.get(0);
		Assert.assertNotNull(AndExpression_185_Var
		);
		final EList<? extends EObject> Expr_185_list = AndExpression_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(2, Expr_185_list.size());
		//185
		final EqualityExpression EqualityExpression_186_Var
		 = (EqualityExpression)Expr_185_list.get(0);
		Assert.assertNotNull(EqualityExpression_186_Var
		);
		final EList<? extends EObject> Expr_186_list = EqualityExpression_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(1, Expr_186_list.size());
		//186
		final RelationalExpression RelationalExpression_187_Var
		 = (RelationalExpression)Expr_186_list.get(0);
		Assert.assertNotNull(RelationalExpression_187_Var
		);
		final EList<? extends EObject> Expr_187_list = RelationalExpression_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(1, Expr_187_list.size());
		//187
		final ShiftExpression ShiftExpression_188_Var
		 = (ShiftExpression)Expr_187_list.get(0);
		Assert.assertNotNull(ShiftExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = ShiftExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final AdditiveExpression AdditiveExpression_189_Var
		 = (AdditiveExpression)Expr_188_list.get(0);
		Assert.assertNotNull(AdditiveExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = AdditiveExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final MultiplicativeExpression MultiplicativeExpression_190_Var
		 = (MultiplicativeExpression)Expr_189_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = MultiplicativeExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final CastExpression CastExpression_191_Var
		 = (CastExpression)Expr_190_list.get(0);
		Assert.assertNotNull(CastExpression_191_Var
		);
		//191
		final UnaryExpression UnaryExpression_192_Var
		 = (UnaryExpression)CastExpression_191_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_192_Var
		);
		//192
		final PostfixExpression PostfixExpression_193_Var
		 = (PostfixExpression)UnaryExpression_192_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = PostfixExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final PrimaryExpression PrimaryExpression_194_Var
		 = (PrimaryExpression)Expr_193_list.get(0);
		Assert.assertNotNull(PrimaryExpression_194_Var
		);
		//194
		final Constant2 Constant2_195_Var
		 = (Constant2)PrimaryExpression_194_Var
		.getConst();
		Assert.assertNotNull(Constant2_195_Var
		);
		Assert.assertEquals("1", Constant2_195_Var
		.getDec());
		//195
		final EqualityExpression EqualityExpression_196_Var
		 = (EqualityExpression)Expr_185_list.get(1);
		Assert.assertNotNull(EqualityExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = EqualityExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final RelationalExpression RelationalExpression_197_Var
		 = (RelationalExpression)Expr_196_list.get(0);
		Assert.assertNotNull(RelationalExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = RelationalExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final ShiftExpression ShiftExpression_198_Var
		 = (ShiftExpression)Expr_197_list.get(0);
		Assert.assertNotNull(ShiftExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = ShiftExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final AdditiveExpression AdditiveExpression_199_Var
		 = (AdditiveExpression)Expr_198_list.get(0);
		Assert.assertNotNull(AdditiveExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = AdditiveExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final MultiplicativeExpression MultiplicativeExpression_200_Var
		 = (MultiplicativeExpression)Expr_199_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = MultiplicativeExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final CastExpression CastExpression_201_Var
		 = (CastExpression)Expr_200_list.get(0);
		Assert.assertNotNull(CastExpression_201_Var
		);
		//201
		final UnaryExpression UnaryExpression_202_Var
		 = (UnaryExpression)CastExpression_201_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_202_Var
		);
		//202
		final PostfixExpression PostfixExpression_203_Var
		 = (PostfixExpression)UnaryExpression_202_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = PostfixExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final PrimaryExpression PrimaryExpression_204_Var
		 = (PrimaryExpression)Expr_203_list.get(0);
		Assert.assertNotNull(PrimaryExpression_204_Var
		);
		//204
		final Constant2 Constant2_205_Var
		 = (Constant2)PrimaryExpression_204_Var
		.getConst();
		Assert.assertNotNull(Constant2_205_Var
		);
		Assert.assertEquals("2", Constant2_205_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_177_Var
		.getSemi());
		//205
		final Statement Statement_206_Var
		 = (Statement)Statement_9_list.get(7);
		Assert.assertNotNull(Statement_206_Var
		);
		//206
		final ExpressionStatement ExpressionStatement_207_Var
		 = (ExpressionStatement)Statement_206_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_207_Var
		);
		//207
		final Expression Expression_208_Var
		 = (Expression)ExpressionStatement_207_Var
		.getExpression();
		Assert.assertNotNull(Expression_208_Var
		);
		final EList<? extends EObject> ExprExpr_208_list = Expression_208_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_208_list);
		Assert.assertEquals(1, ExprExpr_208_list.size());
		//208
		final AssignmentExpression AssignmentExpression_209_Var
		 = (AssignmentExpression)ExprExpr_208_list.get(0);
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
		Assert.assertEquals(2, Expr_213_list.size());
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
		//224
		final Constant2 Constant2_225_Var
		 = (Constant2)PrimaryExpression_224_Var
		.getConst();
		Assert.assertNotNull(Constant2_225_Var
		);
		Assert.assertEquals("1", Constant2_225_Var
		.getDec());
		//225
		final ExclusiveOrExpression ExclusiveOrExpression_226_Var
		 = (ExclusiveOrExpression)Expr_213_list.get(1);
		Assert.assertNotNull(ExclusiveOrExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = ExclusiveOrExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final AndExpression AndExpression_227_Var
		 = (AndExpression)Expr_226_list.get(0);
		Assert.assertNotNull(AndExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = AndExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final EqualityExpression EqualityExpression_228_Var
		 = (EqualityExpression)Expr_227_list.get(0);
		Assert.assertNotNull(EqualityExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = EqualityExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final RelationalExpression RelationalExpression_229_Var
		 = (RelationalExpression)Expr_228_list.get(0);
		Assert.assertNotNull(RelationalExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = RelationalExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final ShiftExpression ShiftExpression_230_Var
		 = (ShiftExpression)Expr_229_list.get(0);
		Assert.assertNotNull(ShiftExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = ShiftExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final AdditiveExpression AdditiveExpression_231_Var
		 = (AdditiveExpression)Expr_230_list.get(0);
		Assert.assertNotNull(AdditiveExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = AdditiveExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final MultiplicativeExpression MultiplicativeExpression_232_Var
		 = (MultiplicativeExpression)Expr_231_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = MultiplicativeExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final CastExpression CastExpression_233_Var
		 = (CastExpression)Expr_232_list.get(0);
		Assert.assertNotNull(CastExpression_233_Var
		);
		//233
		final UnaryExpression UnaryExpression_234_Var
		 = (UnaryExpression)CastExpression_233_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_234_Var
		);
		//234
		final PostfixExpression PostfixExpression_235_Var
		 = (PostfixExpression)UnaryExpression_234_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = PostfixExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final PrimaryExpression PrimaryExpression_236_Var
		 = (PrimaryExpression)Expr_235_list.get(0);
		Assert.assertNotNull(PrimaryExpression_236_Var
		);
		//236
		final Constant2 Constant2_237_Var
		 = (Constant2)PrimaryExpression_236_Var
		.getConst();
		Assert.assertNotNull(Constant2_237_Var
		);
		Assert.assertEquals("2", Constant2_237_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_207_Var
		.getSemi());
		//237
		final Statement Statement_238_Var
		 = (Statement)Statement_9_list.get(8);
		Assert.assertNotNull(Statement_238_Var
		);
		//238
		final ExpressionStatement ExpressionStatement_239_Var
		 = (ExpressionStatement)Statement_238_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_239_Var
		);
		//239
		final Expression Expression_240_Var
		 = (Expression)ExpressionStatement_239_Var
		.getExpression();
		Assert.assertNotNull(Expression_240_Var
		);
		final EList<? extends EObject> ExprExpr_240_list = Expression_240_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_240_list);
		Assert.assertEquals(1, ExprExpr_240_list.size());
		//240
		final AssignmentExpression AssignmentExpression_241_Var
		 = (AssignmentExpression)ExprExpr_240_list.get(0);
		Assert.assertNotNull(AssignmentExpression_241_Var
		);
		//241
		final ConditionalExpression ConditionalExpression_242_Var
		 = (ConditionalExpression)AssignmentExpression_241_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_242_Var
		);
		//242
		final LogicalOrExpression LogicalOrExpression_243_Var
		 = (LogicalOrExpression)ConditionalExpression_242_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = LogicalOrExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final LogicalAndExpression LogicalAndExpression_244_Var
		 = (LogicalAndExpression)Expr_243_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = LogicalAndExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final InclusiveOrExpression InclusiveOrExpression_245_Var
		 = (InclusiveOrExpression)Expr_244_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = InclusiveOrExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final ExclusiveOrExpression ExclusiveOrExpression_246_Var
		 = (ExclusiveOrExpression)Expr_245_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = ExclusiveOrExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(2, Expr_246_list.size());
		//246
		final AndExpression AndExpression_247_Var
		 = (AndExpression)Expr_246_list.get(0);
		Assert.assertNotNull(AndExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = AndExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final EqualityExpression EqualityExpression_248_Var
		 = (EqualityExpression)Expr_247_list.get(0);
		Assert.assertNotNull(EqualityExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = EqualityExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final RelationalExpression RelationalExpression_249_Var
		 = (RelationalExpression)Expr_248_list.get(0);
		Assert.assertNotNull(RelationalExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = RelationalExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final ShiftExpression ShiftExpression_250_Var
		 = (ShiftExpression)Expr_249_list.get(0);
		Assert.assertNotNull(ShiftExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = ShiftExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final AdditiveExpression AdditiveExpression_251_Var
		 = (AdditiveExpression)Expr_250_list.get(0);
		Assert.assertNotNull(AdditiveExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = AdditiveExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final MultiplicativeExpression MultiplicativeExpression_252_Var
		 = (MultiplicativeExpression)Expr_251_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_252_Var
		);
		final EList<? extends EObject> Expr_252_list = MultiplicativeExpression_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(1, Expr_252_list.size());
		//252
		final CastExpression CastExpression_253_Var
		 = (CastExpression)Expr_252_list.get(0);
		Assert.assertNotNull(CastExpression_253_Var
		);
		//253
		final UnaryExpression UnaryExpression_254_Var
		 = (UnaryExpression)CastExpression_253_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_254_Var
		);
		//254
		final PostfixExpression PostfixExpression_255_Var
		 = (PostfixExpression)UnaryExpression_254_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_255_Var
		);
		final EList<? extends EObject> Expr_255_list = PostfixExpression_255_Var
		.getExpr();
		Assert.assertNotNull(Expr_255_list);
		Assert.assertEquals(1, Expr_255_list.size());
		//255
		final PrimaryExpression PrimaryExpression_256_Var
		 = (PrimaryExpression)Expr_255_list.get(0);
		Assert.assertNotNull(PrimaryExpression_256_Var
		);
		//256
		final Constant2 Constant2_257_Var
		 = (Constant2)PrimaryExpression_256_Var
		.getConst();
		Assert.assertNotNull(Constant2_257_Var
		);
		Assert.assertEquals("1", Constant2_257_Var
		.getDec());
		//257
		final AndExpression AndExpression_258_Var
		 = (AndExpression)Expr_246_list.get(1);
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
		Assert.assertEquals("2", Constant2_268_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_239_Var
		.getSemi());
		//268
		final Statement Statement_269_Var
		 = (Statement)Statement_9_list.get(9);
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
		Assert.assertEquals(2, Expr_275_list.size());
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
		//287
		final Constant2 Constant2_288_Var
		 = (Constant2)PrimaryExpression_287_Var
		.getConst();
		Assert.assertNotNull(Constant2_288_Var
		);
		Assert.assertEquals("1", Constant2_288_Var
		.getDec());
		//288
		final InclusiveOrExpression InclusiveOrExpression_289_Var
		 = (InclusiveOrExpression)Expr_275_list.get(1);
		Assert.assertNotNull(InclusiveOrExpression_289_Var
		);
		final EList<? extends EObject> Expr_289_list = InclusiveOrExpression_289_Var
		.getExpr();
		Assert.assertNotNull(Expr_289_list);
		Assert.assertEquals(1, Expr_289_list.size());
		//289
		final ExclusiveOrExpression ExclusiveOrExpression_290_Var
		 = (ExclusiveOrExpression)Expr_289_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_290_Var
		);
		final EList<? extends EObject> Expr_290_list = ExclusiveOrExpression_290_Var
		.getExpr();
		Assert.assertNotNull(Expr_290_list);
		Assert.assertEquals(1, Expr_290_list.size());
		//290
		final AndExpression AndExpression_291_Var
		 = (AndExpression)Expr_290_list.get(0);
		Assert.assertNotNull(AndExpression_291_Var
		);
		final EList<? extends EObject> Expr_291_list = AndExpression_291_Var
		.getExpr();
		Assert.assertNotNull(Expr_291_list);
		Assert.assertEquals(1, Expr_291_list.size());
		//291
		final EqualityExpression EqualityExpression_292_Var
		 = (EqualityExpression)Expr_291_list.get(0);
		Assert.assertNotNull(EqualityExpression_292_Var
		);
		final EList<? extends EObject> Expr_292_list = EqualityExpression_292_Var
		.getExpr();
		Assert.assertNotNull(Expr_292_list);
		Assert.assertEquals(1, Expr_292_list.size());
		//292
		final RelationalExpression RelationalExpression_293_Var
		 = (RelationalExpression)Expr_292_list.get(0);
		Assert.assertNotNull(RelationalExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = RelationalExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final ShiftExpression ShiftExpression_294_Var
		 = (ShiftExpression)Expr_293_list.get(0);
		Assert.assertNotNull(ShiftExpression_294_Var
		);
		final EList<? extends EObject> Expr_294_list = ShiftExpression_294_Var
		.getExpr();
		Assert.assertNotNull(Expr_294_list);
		Assert.assertEquals(1, Expr_294_list.size());
		//294
		final AdditiveExpression AdditiveExpression_295_Var
		 = (AdditiveExpression)Expr_294_list.get(0);
		Assert.assertNotNull(AdditiveExpression_295_Var
		);
		final EList<? extends EObject> Expr_295_list = AdditiveExpression_295_Var
		.getExpr();
		Assert.assertNotNull(Expr_295_list);
		Assert.assertEquals(1, Expr_295_list.size());
		//295
		final MultiplicativeExpression MultiplicativeExpression_296_Var
		 = (MultiplicativeExpression)Expr_295_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_296_Var
		);
		final EList<? extends EObject> Expr_296_list = MultiplicativeExpression_296_Var
		.getExpr();
		Assert.assertNotNull(Expr_296_list);
		Assert.assertEquals(1, Expr_296_list.size());
		//296
		final CastExpression CastExpression_297_Var
		 = (CastExpression)Expr_296_list.get(0);
		Assert.assertNotNull(CastExpression_297_Var
		);
		//297
		final UnaryExpression UnaryExpression_298_Var
		 = (UnaryExpression)CastExpression_297_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_298_Var
		);
		//298
		final PostfixExpression PostfixExpression_299_Var
		 = (PostfixExpression)UnaryExpression_298_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_299_Var
		);
		final EList<? extends EObject> Expr_299_list = PostfixExpression_299_Var
		.getExpr();
		Assert.assertNotNull(Expr_299_list);
		Assert.assertEquals(1, Expr_299_list.size());
		//299
		final PrimaryExpression PrimaryExpression_300_Var
		 = (PrimaryExpression)Expr_299_list.get(0);
		Assert.assertNotNull(PrimaryExpression_300_Var
		);
		//300
		final Constant2 Constant2_301_Var
		 = (Constant2)PrimaryExpression_300_Var
		.getConst();
		Assert.assertNotNull(Constant2_301_Var
		);
		Assert.assertEquals("2", Constant2_301_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_270_Var
		.getSemi());
		//301
		final Statement Statement_302_Var
		 = (Statement)Statement_9_list.get(10);
		Assert.assertNotNull(Statement_302_Var
		);
		//302
		final ExpressionStatement ExpressionStatement_303_Var
		 = (ExpressionStatement)Statement_302_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_303_Var
		);
		//303
		final Expression Expression_304_Var
		 = (Expression)ExpressionStatement_303_Var
		.getExpression();
		Assert.assertNotNull(Expression_304_Var
		);
		final EList<? extends EObject> ExprExpr_304_list = Expression_304_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_304_list);
		Assert.assertEquals(1, ExprExpr_304_list.size());
		//304
		final AssignmentExpression AssignmentExpression_305_Var
		 = (AssignmentExpression)ExprExpr_304_list.get(0);
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
		Assert.assertEquals(2, Expr_307_list.size());
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
		//320
		final Constant2 Constant2_321_Var
		 = (Constant2)PrimaryExpression_320_Var
		.getConst();
		Assert.assertNotNull(Constant2_321_Var
		);
		Assert.assertEquals("1", Constant2_321_Var
		.getDec());
		//321
		final LogicalAndExpression LogicalAndExpression_322_Var
		 = (LogicalAndExpression)Expr_307_list.get(1);
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
		Assert.assertEquals("2", Constant2_335_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_303_Var
		.getSemi());
		//335
		final Statement Statement_336_Var
		 = (Statement)Statement_9_list.get(11);
		Assert.assertNotNull(Statement_336_Var
		);
		//336
		final ExpressionStatement ExpressionStatement_337_Var
		 = (ExpressionStatement)Statement_336_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_337_Var
		);
		//337
		final Expression Expression_338_Var
		 = (Expression)ExpressionStatement_337_Var
		.getExpression();
		Assert.assertNotNull(Expression_338_Var
		);
		final EList<? extends EObject> ExprExpr_338_list = Expression_338_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_338_list);
		Assert.assertEquals(1, ExprExpr_338_list.size());
		//338
		final AssignmentExpression AssignmentExpression_339_Var
		 = (AssignmentExpression)ExprExpr_338_list.get(0);
		Assert.assertNotNull(AssignmentExpression_339_Var
		);
		//339
		final ConditionalExpression ConditionalExpression_340_Var
		 = (ConditionalExpression)AssignmentExpression_339_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_340_Var
		);
		//340
		final LogicalOrExpression LogicalOrExpression_341_Var
		 = (LogicalOrExpression)ConditionalExpression_340_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_341_Var
		);
		final EList<? extends EObject> Expr_341_list = LogicalOrExpression_341_Var
		.getExpr();
		Assert.assertNotNull(Expr_341_list);
		Assert.assertEquals(1, Expr_341_list.size());
		//341
		final LogicalAndExpression LogicalAndExpression_342_Var
		 = (LogicalAndExpression)Expr_341_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_342_Var
		);
		final EList<? extends EObject> Expr_342_list = LogicalAndExpression_342_Var
		.getExpr();
		Assert.assertNotNull(Expr_342_list);
		Assert.assertEquals(1, Expr_342_list.size());
		//342
		final InclusiveOrExpression InclusiveOrExpression_343_Var
		 = (InclusiveOrExpression)Expr_342_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_343_Var
		);
		final EList<? extends EObject> Expr_343_list = InclusiveOrExpression_343_Var
		.getExpr();
		Assert.assertNotNull(Expr_343_list);
		Assert.assertEquals(1, Expr_343_list.size());
		//343
		final ExclusiveOrExpression ExclusiveOrExpression_344_Var
		 = (ExclusiveOrExpression)Expr_343_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_344_Var
		);
		final EList<? extends EObject> Expr_344_list = ExclusiveOrExpression_344_Var
		.getExpr();
		Assert.assertNotNull(Expr_344_list);
		Assert.assertEquals(1, Expr_344_list.size());
		//344
		final AndExpression AndExpression_345_Var
		 = (AndExpression)Expr_344_list.get(0);
		Assert.assertNotNull(AndExpression_345_Var
		);
		final EList<? extends EObject> Expr_345_list = AndExpression_345_Var
		.getExpr();
		Assert.assertNotNull(Expr_345_list);
		Assert.assertEquals(1, Expr_345_list.size());
		//345
		final EqualityExpression EqualityExpression_346_Var
		 = (EqualityExpression)Expr_345_list.get(0);
		Assert.assertNotNull(EqualityExpression_346_Var
		);
		final EList<? extends EObject> Expr_346_list = EqualityExpression_346_Var
		.getExpr();
		Assert.assertNotNull(Expr_346_list);
		Assert.assertEquals(1, Expr_346_list.size());
		//346
		final RelationalExpression RelationalExpression_347_Var
		 = (RelationalExpression)Expr_346_list.get(0);
		Assert.assertNotNull(RelationalExpression_347_Var
		);
		final EList<? extends EObject> Expr_347_list = RelationalExpression_347_Var
		.getExpr();
		Assert.assertNotNull(Expr_347_list);
		Assert.assertEquals(1, Expr_347_list.size());
		//347
		final ShiftExpression ShiftExpression_348_Var
		 = (ShiftExpression)Expr_347_list.get(0);
		Assert.assertNotNull(ShiftExpression_348_Var
		);
		final EList<? extends EObject> Expr_348_list = ShiftExpression_348_Var
		.getExpr();
		Assert.assertNotNull(Expr_348_list);
		Assert.assertEquals(1, Expr_348_list.size());
		//348
		final AdditiveExpression AdditiveExpression_349_Var
		 = (AdditiveExpression)Expr_348_list.get(0);
		Assert.assertNotNull(AdditiveExpression_349_Var
		);
		final EList<? extends EObject> Expr_349_list = AdditiveExpression_349_Var
		.getExpr();
		Assert.assertNotNull(Expr_349_list);
		Assert.assertEquals(1, Expr_349_list.size());
		//349
		final MultiplicativeExpression MultiplicativeExpression_350_Var
		 = (MultiplicativeExpression)Expr_349_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_350_Var
		);
		final EList<? extends EObject> Expr_350_list = MultiplicativeExpression_350_Var
		.getExpr();
		Assert.assertNotNull(Expr_350_list);
		Assert.assertEquals(1, Expr_350_list.size());
		//350
		final CastExpression CastExpression_351_Var
		 = (CastExpression)Expr_350_list.get(0);
		Assert.assertNotNull(CastExpression_351_Var
		);
		//351
		final UnaryExpression UnaryExpression_352_Var
		 = (UnaryExpression)CastExpression_351_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_352_Var
		);
		//352
		final PostfixExpression PostfixExpression_353_Var
		 = (PostfixExpression)UnaryExpression_352_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_353_Var
		);
		final EList<? extends EObject> Expr_353_list = PostfixExpression_353_Var
		.getExpr();
		Assert.assertNotNull(Expr_353_list);
		Assert.assertEquals(1, Expr_353_list.size());
		//353
		final PrimaryExpression PrimaryExpression_354_Var
		 = (PrimaryExpression)Expr_353_list.get(0);
		Assert.assertNotNull(PrimaryExpression_354_Var
		);
		//354
		final Constant2 Constant2_355_Var
		 = (Constant2)PrimaryExpression_354_Var
		.getConst();
		Assert.assertNotNull(Constant2_355_Var
		);
		Assert.assertEquals("1", Constant2_355_Var
		.getDec());
		//355
		final Expression Expression_356_Var
		 = (Expression)ConditionalExpression_340_Var
		.getQExpr();
		Assert.assertNotNull(Expression_356_Var
		);
		final EList<? extends EObject> ExprExpr_356_list = Expression_356_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_356_list);
		Assert.assertEquals(1, ExprExpr_356_list.size());
		//356
		final AssignmentExpression AssignmentExpression_357_Var
		 = (AssignmentExpression)ExprExpr_356_list.get(0);
		Assert.assertNotNull(AssignmentExpression_357_Var
		);
		//357
		final ConditionalExpression ConditionalExpression_358_Var
		 = (ConditionalExpression)AssignmentExpression_357_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_358_Var
		);
		//358
		final LogicalOrExpression LogicalOrExpression_359_Var
		 = (LogicalOrExpression)ConditionalExpression_358_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_359_Var
		);
		final EList<? extends EObject> Expr_359_list = LogicalOrExpression_359_Var
		.getExpr();
		Assert.assertNotNull(Expr_359_list);
		Assert.assertEquals(1, Expr_359_list.size());
		//359
		final LogicalAndExpression LogicalAndExpression_360_Var
		 = (LogicalAndExpression)Expr_359_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_360_Var
		);
		final EList<? extends EObject> Expr_360_list = LogicalAndExpression_360_Var
		.getExpr();
		Assert.assertNotNull(Expr_360_list);
		Assert.assertEquals(1, Expr_360_list.size());
		//360
		final InclusiveOrExpression InclusiveOrExpression_361_Var
		 = (InclusiveOrExpression)Expr_360_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_361_Var
		);
		final EList<? extends EObject> Expr_361_list = InclusiveOrExpression_361_Var
		.getExpr();
		Assert.assertNotNull(Expr_361_list);
		Assert.assertEquals(1, Expr_361_list.size());
		//361
		final ExclusiveOrExpression ExclusiveOrExpression_362_Var
		 = (ExclusiveOrExpression)Expr_361_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_362_Var
		);
		final EList<? extends EObject> Expr_362_list = ExclusiveOrExpression_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(1, Expr_362_list.size());
		//362
		final AndExpression AndExpression_363_Var
		 = (AndExpression)Expr_362_list.get(0);
		Assert.assertNotNull(AndExpression_363_Var
		);
		final EList<? extends EObject> Expr_363_list = AndExpression_363_Var
		.getExpr();
		Assert.assertNotNull(Expr_363_list);
		Assert.assertEquals(1, Expr_363_list.size());
		//363
		final EqualityExpression EqualityExpression_364_Var
		 = (EqualityExpression)Expr_363_list.get(0);
		Assert.assertNotNull(EqualityExpression_364_Var
		);
		final EList<? extends EObject> Expr_364_list = EqualityExpression_364_Var
		.getExpr();
		Assert.assertNotNull(Expr_364_list);
		Assert.assertEquals(1, Expr_364_list.size());
		//364
		final RelationalExpression RelationalExpression_365_Var
		 = (RelationalExpression)Expr_364_list.get(0);
		Assert.assertNotNull(RelationalExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = RelationalExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final ShiftExpression ShiftExpression_366_Var
		 = (ShiftExpression)Expr_365_list.get(0);
		Assert.assertNotNull(ShiftExpression_366_Var
		);
		final EList<? extends EObject> Expr_366_list = ShiftExpression_366_Var
		.getExpr();
		Assert.assertNotNull(Expr_366_list);
		Assert.assertEquals(1, Expr_366_list.size());
		//366
		final AdditiveExpression AdditiveExpression_367_Var
		 = (AdditiveExpression)Expr_366_list.get(0);
		Assert.assertNotNull(AdditiveExpression_367_Var
		);
		final EList<? extends EObject> Expr_367_list = AdditiveExpression_367_Var
		.getExpr();
		Assert.assertNotNull(Expr_367_list);
		Assert.assertEquals(1, Expr_367_list.size());
		//367
		final MultiplicativeExpression MultiplicativeExpression_368_Var
		 = (MultiplicativeExpression)Expr_367_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_368_Var
		);
		final EList<? extends EObject> Expr_368_list = MultiplicativeExpression_368_Var
		.getExpr();
		Assert.assertNotNull(Expr_368_list);
		Assert.assertEquals(1, Expr_368_list.size());
		//368
		final CastExpression CastExpression_369_Var
		 = (CastExpression)Expr_368_list.get(0);
		Assert.assertNotNull(CastExpression_369_Var
		);
		//369
		final UnaryExpression UnaryExpression_370_Var
		 = (UnaryExpression)CastExpression_369_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_370_Var
		);
		//370
		final PostfixExpression PostfixExpression_371_Var
		 = (PostfixExpression)UnaryExpression_370_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_371_Var
		);
		final EList<? extends EObject> Expr_371_list = PostfixExpression_371_Var
		.getExpr();
		Assert.assertNotNull(Expr_371_list);
		Assert.assertEquals(1, Expr_371_list.size());
		//371
		final PrimaryExpression PrimaryExpression_372_Var
		 = (PrimaryExpression)Expr_371_list.get(0);
		Assert.assertNotNull(PrimaryExpression_372_Var
		);
		//372
		final Constant2 Constant2_373_Var
		 = (Constant2)PrimaryExpression_372_Var
		.getConst();
		Assert.assertNotNull(Constant2_373_Var
		);
		Assert.assertEquals("2", Constant2_373_Var
		.getDec());
		//373
		final ConditionalExpression ConditionalExpression_374_Var
		 = (ConditionalExpression)ConditionalExpression_340_Var
		.getCExpr();
		Assert.assertNotNull(ConditionalExpression_374_Var
		);
		//374
		final LogicalOrExpression LogicalOrExpression_375_Var
		 = (LogicalOrExpression)ConditionalExpression_374_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_375_Var
		);
		final EList<? extends EObject> Expr_375_list = LogicalOrExpression_375_Var
		.getExpr();
		Assert.assertNotNull(Expr_375_list);
		Assert.assertEquals(1, Expr_375_list.size());
		//375
		final LogicalAndExpression LogicalAndExpression_376_Var
		 = (LogicalAndExpression)Expr_375_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_376_Var
		);
		final EList<? extends EObject> Expr_376_list = LogicalAndExpression_376_Var
		.getExpr();
		Assert.assertNotNull(Expr_376_list);
		Assert.assertEquals(1, Expr_376_list.size());
		//376
		final InclusiveOrExpression InclusiveOrExpression_377_Var
		 = (InclusiveOrExpression)Expr_376_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_377_Var
		);
		final EList<? extends EObject> Expr_377_list = InclusiveOrExpression_377_Var
		.getExpr();
		Assert.assertNotNull(Expr_377_list);
		Assert.assertEquals(1, Expr_377_list.size());
		//377
		final ExclusiveOrExpression ExclusiveOrExpression_378_Var
		 = (ExclusiveOrExpression)Expr_377_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_378_Var
		);
		final EList<? extends EObject> Expr_378_list = ExclusiveOrExpression_378_Var
		.getExpr();
		Assert.assertNotNull(Expr_378_list);
		Assert.assertEquals(1, Expr_378_list.size());
		//378
		final AndExpression AndExpression_379_Var
		 = (AndExpression)Expr_378_list.get(0);
		Assert.assertNotNull(AndExpression_379_Var
		);
		final EList<? extends EObject> Expr_379_list = AndExpression_379_Var
		.getExpr();
		Assert.assertNotNull(Expr_379_list);
		Assert.assertEquals(1, Expr_379_list.size());
		//379
		final EqualityExpression EqualityExpression_380_Var
		 = (EqualityExpression)Expr_379_list.get(0);
		Assert.assertNotNull(EqualityExpression_380_Var
		);
		final EList<? extends EObject> Expr_380_list = EqualityExpression_380_Var
		.getExpr();
		Assert.assertNotNull(Expr_380_list);
		Assert.assertEquals(1, Expr_380_list.size());
		//380
		final RelationalExpression RelationalExpression_381_Var
		 = (RelationalExpression)Expr_380_list.get(0);
		Assert.assertNotNull(RelationalExpression_381_Var
		);
		final EList<? extends EObject> Expr_381_list = RelationalExpression_381_Var
		.getExpr();
		Assert.assertNotNull(Expr_381_list);
		Assert.assertEquals(1, Expr_381_list.size());
		//381
		final ShiftExpression ShiftExpression_382_Var
		 = (ShiftExpression)Expr_381_list.get(0);
		Assert.assertNotNull(ShiftExpression_382_Var
		);
		final EList<? extends EObject> Expr_382_list = ShiftExpression_382_Var
		.getExpr();
		Assert.assertNotNull(Expr_382_list);
		Assert.assertEquals(1, Expr_382_list.size());
		//382
		final AdditiveExpression AdditiveExpression_383_Var
		 = (AdditiveExpression)Expr_382_list.get(0);
		Assert.assertNotNull(AdditiveExpression_383_Var
		);
		final EList<? extends EObject> Expr_383_list = AdditiveExpression_383_Var
		.getExpr();
		Assert.assertNotNull(Expr_383_list);
		Assert.assertEquals(1, Expr_383_list.size());
		//383
		final MultiplicativeExpression MultiplicativeExpression_384_Var
		 = (MultiplicativeExpression)Expr_383_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_384_Var
		);
		final EList<? extends EObject> Expr_384_list = MultiplicativeExpression_384_Var
		.getExpr();
		Assert.assertNotNull(Expr_384_list);
		Assert.assertEquals(1, Expr_384_list.size());
		//384
		final CastExpression CastExpression_385_Var
		 = (CastExpression)Expr_384_list.get(0);
		Assert.assertNotNull(CastExpression_385_Var
		);
		//385
		final UnaryExpression UnaryExpression_386_Var
		 = (UnaryExpression)CastExpression_385_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_386_Var
		);
		//386
		final PostfixExpression PostfixExpression_387_Var
		 = (PostfixExpression)UnaryExpression_386_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_387_Var
		);
		final EList<? extends EObject> Expr_387_list = PostfixExpression_387_Var
		.getExpr();
		Assert.assertNotNull(Expr_387_list);
		Assert.assertEquals(1, Expr_387_list.size());
		//387
		final PrimaryExpression PrimaryExpression_388_Var
		 = (PrimaryExpression)Expr_387_list.get(0);
		Assert.assertNotNull(PrimaryExpression_388_Var
		);
		//388
		final Constant2 Constant2_389_Var
		 = (Constant2)PrimaryExpression_388_Var
		.getConst();
		Assert.assertNotNull(Constant2_389_Var
		);
		Assert.assertEquals("3", Constant2_389_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_337_Var
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


