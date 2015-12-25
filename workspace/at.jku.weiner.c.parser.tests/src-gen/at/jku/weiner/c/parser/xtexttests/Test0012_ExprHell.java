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
		Assert.assertEquals(1, External_2_list.size());
		//2
		final ExternalDeclaration ExternalDeclaration_3_Var
		 = (ExternalDeclaration)External_2_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_3_Var
		);
		//3
		final FunctionDefHead FunctionDefHead_4_Var
		 = (FunctionDefHead)ExternalDeclaration_3_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_4_Var
		);
		//4
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_5_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_4_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_5_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_5_list = FunctionDeclarationSpecifiers_5_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_5_list);
		Assert.assertEquals(1, DeclarationSpecifier_5_list.size());
		//5
		final TypeSpecifier TypeSpecifier_6_Var
		 = (TypeSpecifier)DeclarationSpecifier_5_list.get(0);
		Assert.assertNotNull(TypeSpecifier_6_Var
		);
		Assert.assertEquals("void", TypeSpecifier_6_Var
		.getName());
		//6
		final Declarator Declarator_7_Var
		 = (Declarator)FunctionDefHead_4_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_7_Var
		);
		//7
		final DirectDeclarator DirectDeclarator_8_Var
		 = (DirectDeclarator)Declarator_7_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_8_Var
		);
		Assert.assertEquals("doSomething", DirectDeclarator_8_Var
		.getId());
		//8
		final FunctionDefinition FunctionDefinition_9_Var
		 = (FunctionDefinition)ExternalDeclaration_3_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_9_Var
		);
		//9
		final BodyStatement BodyStatement_10_Var
		 = (BodyStatement)FunctionDefinition_9_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_10_Var
		);
		final EList<? extends EObject> BlockList_10_list = BodyStatement_10_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_10_list);
		Assert.assertEquals(1, BlockList_10_list.size());
		//10
		final BlockList BlockList_11_Var
		 = (BlockList)BlockList_10_list.get(0);
		Assert.assertNotNull(BlockList_11_Var
		);
		final EList<? extends EObject> Statement_11_list = BlockList_11_Var
		.getStatement();
		Assert.assertNotNull(Statement_11_list);
		Assert.assertEquals(12, Statement_11_list.size());
		//11
		final Statement Statement_12_Var
		 = (Statement)Statement_11_list.get(0);
		Assert.assertNotNull(Statement_12_Var
		);
		//12
		final ExpressionStatement ExpressionStatement_13_Var
		 = (ExpressionStatement)Statement_12_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_13_Var
		);
		//13
		final Expression Expression_14_Var
		 = (Expression)ExpressionStatement_13_Var
		.getExpression();
		Assert.assertNotNull(Expression_14_Var
		);
		final EList<? extends EObject> ExprExpr_14_list = Expression_14_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_14_list);
		Assert.assertEquals(1, ExprExpr_14_list.size());
		//14
		final AssignmentExpression AssignmentExpression_15_Var
		 = (AssignmentExpression)ExprExpr_14_list.get(0);
		Assert.assertNotNull(AssignmentExpression_15_Var
		);
		//15
		final ConditionalExpression ConditionalExpression_16_Var
		 = (ConditionalExpression)AssignmentExpression_15_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_16_Var
		);
		//16
		final LogicalOrExpression LogicalOrExpression_17_Var
		 = (LogicalOrExpression)ConditionalExpression_16_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = LogicalOrExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final LogicalAndExpression LogicalAndExpression_18_Var
		 = (LogicalAndExpression)Expr_17_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = LogicalAndExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final InclusiveOrExpression InclusiveOrExpression_19_Var
		 = (InclusiveOrExpression)Expr_18_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = InclusiveOrExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final ExclusiveOrExpression ExclusiveOrExpression_20_Var
		 = (ExclusiveOrExpression)Expr_19_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = ExclusiveOrExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final AndExpression AndExpression_21_Var
		 = (AndExpression)Expr_20_list.get(0);
		Assert.assertNotNull(AndExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = AndExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final EqualityExpression EqualityExpression_22_Var
		 = (EqualityExpression)Expr_21_list.get(0);
		Assert.assertNotNull(EqualityExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = EqualityExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final RelationalExpression RelationalExpression_23_Var
		 = (RelationalExpression)Expr_22_list.get(0);
		Assert.assertNotNull(RelationalExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = RelationalExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final ShiftExpression ShiftExpression_24_Var
		 = (ShiftExpression)Expr_23_list.get(0);
		Assert.assertNotNull(ShiftExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = ShiftExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final AdditiveExpression AdditiveExpression_25_Var
		 = (AdditiveExpression)Expr_24_list.get(0);
		Assert.assertNotNull(AdditiveExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = AdditiveExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final MultiplicativeExpression MultiplicativeExpression_26_Var
		 = (MultiplicativeExpression)Expr_25_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = MultiplicativeExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final CastExpression CastExpression_27_Var
		 = (CastExpression)Expr_26_list.get(0);
		Assert.assertNotNull(CastExpression_27_Var
		);
		//27
		final UnaryExpression UnaryExpression_28_Var
		 = (UnaryExpression)CastExpression_27_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_28_Var
		);
		//28
		final PostfixExpression PostfixExpression_29_Var
		 = (PostfixExpression)UnaryExpression_28_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = PostfixExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final PrimaryExpression PrimaryExpression_30_Var
		 = (PrimaryExpression)Expr_29_list.get(0);
		Assert.assertNotNull(PrimaryExpression_30_Var
		);
		//30
		final Constant2 Constant2_31_Var
		 = (Constant2)PrimaryExpression_30_Var
		.getConst();
		Assert.assertNotNull(Constant2_31_Var
		);
		Assert.assertEquals("1", Constant2_31_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_13_Var
		.getSemi());
		//31
		final Statement Statement_32_Var
		 = (Statement)Statement_11_list.get(1);
		Assert.assertNotNull(Statement_32_Var
		);
		//32
		final ExpressionStatement ExpressionStatement_33_Var
		 = (ExpressionStatement)Statement_32_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_33_Var
		);
		//33
		final Expression Expression_34_Var
		 = (Expression)ExpressionStatement_33_Var
		.getExpression();
		Assert.assertNotNull(Expression_34_Var
		);
		final EList<? extends EObject> ExprExpr_34_list = Expression_34_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_34_list);
		Assert.assertEquals(1, ExprExpr_34_list.size());
		//34
		final AssignmentExpression AssignmentExpression_35_Var
		 = (AssignmentExpression)ExprExpr_34_list.get(0);
		Assert.assertNotNull(AssignmentExpression_35_Var
		);
		//35
		final ConditionalExpression ConditionalExpression_36_Var
		 = (ConditionalExpression)AssignmentExpression_35_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_36_Var
		);
		//36
		final LogicalOrExpression LogicalOrExpression_37_Var
		 = (LogicalOrExpression)ConditionalExpression_36_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = LogicalOrExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final LogicalAndExpression LogicalAndExpression_38_Var
		 = (LogicalAndExpression)Expr_37_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = LogicalAndExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final InclusiveOrExpression InclusiveOrExpression_39_Var
		 = (InclusiveOrExpression)Expr_38_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = InclusiveOrExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final ExclusiveOrExpression ExclusiveOrExpression_40_Var
		 = (ExclusiveOrExpression)Expr_39_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = ExclusiveOrExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final AndExpression AndExpression_41_Var
		 = (AndExpression)Expr_40_list.get(0);
		Assert.assertNotNull(AndExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = AndExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final EqualityExpression EqualityExpression_42_Var
		 = (EqualityExpression)Expr_41_list.get(0);
		Assert.assertNotNull(EqualityExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = EqualityExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final RelationalExpression RelationalExpression_43_Var
		 = (RelationalExpression)Expr_42_list.get(0);
		Assert.assertNotNull(RelationalExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = RelationalExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final ShiftExpression ShiftExpression_44_Var
		 = (ShiftExpression)Expr_43_list.get(0);
		Assert.assertNotNull(ShiftExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = ShiftExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final AdditiveExpression AdditiveExpression_45_Var
		 = (AdditiveExpression)Expr_44_list.get(0);
		Assert.assertNotNull(AdditiveExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = AdditiveExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final MultiplicativeExpression MultiplicativeExpression_46_Var
		 = (MultiplicativeExpression)Expr_45_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = MultiplicativeExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final CastExpression CastExpression_47_Var
		 = (CastExpression)Expr_46_list.get(0);
		Assert.assertNotNull(CastExpression_47_Var
		);
		//47
		final UnaryExpression UnaryExpression_48_Var
		 = (UnaryExpression)CastExpression_47_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_48_Var
		);
		//48
		final PostfixExpression PostfixExpression_49_Var
		 = (PostfixExpression)UnaryExpression_48_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = PostfixExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final PrimaryExpression PrimaryExpression_50_Var
		 = (PrimaryExpression)Expr_49_list.get(0);
		Assert.assertNotNull(PrimaryExpression_50_Var
		);
		//50
		final Expression Expression_51_Var
		 = (Expression)PrimaryExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expression_51_Var
		);
		final EList<? extends EObject> ExprExpr_51_list = Expression_51_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_51_list);
		Assert.assertEquals(1, ExprExpr_51_list.size());
		//51
		final AssignmentExpression AssignmentExpression_52_Var
		 = (AssignmentExpression)ExprExpr_51_list.get(0);
		Assert.assertNotNull(AssignmentExpression_52_Var
		);
		//52
		final ConditionalExpression ConditionalExpression_53_Var
		 = (ConditionalExpression)AssignmentExpression_52_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_53_Var
		);
		//53
		final LogicalOrExpression LogicalOrExpression_54_Var
		 = (LogicalOrExpression)ConditionalExpression_53_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = LogicalOrExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final LogicalAndExpression LogicalAndExpression_55_Var
		 = (LogicalAndExpression)Expr_54_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = LogicalAndExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final InclusiveOrExpression InclusiveOrExpression_56_Var
		 = (InclusiveOrExpression)Expr_55_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = InclusiveOrExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final ExclusiveOrExpression ExclusiveOrExpression_57_Var
		 = (ExclusiveOrExpression)Expr_56_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = ExclusiveOrExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final AndExpression AndExpression_58_Var
		 = (AndExpression)Expr_57_list.get(0);
		Assert.assertNotNull(AndExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = AndExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final EqualityExpression EqualityExpression_59_Var
		 = (EqualityExpression)Expr_58_list.get(0);
		Assert.assertNotNull(EqualityExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = EqualityExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final RelationalExpression RelationalExpression_60_Var
		 = (RelationalExpression)Expr_59_list.get(0);
		Assert.assertNotNull(RelationalExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = RelationalExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final ShiftExpression ShiftExpression_61_Var
		 = (ShiftExpression)Expr_60_list.get(0);
		Assert.assertNotNull(ShiftExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = ShiftExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final AdditiveExpression AdditiveExpression_62_Var
		 = (AdditiveExpression)Expr_61_list.get(0);
		Assert.assertNotNull(AdditiveExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = AdditiveExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final MultiplicativeExpression MultiplicativeExpression_63_Var
		 = (MultiplicativeExpression)Expr_62_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = MultiplicativeExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final CastExpression CastExpression_64_Var
		 = (CastExpression)Expr_63_list.get(0);
		Assert.assertNotNull(CastExpression_64_Var
		);
		//64
		final UnaryExpression UnaryExpression_65_Var
		 = (UnaryExpression)CastExpression_64_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_65_Var
		);
		//65
		final PostfixExpression PostfixExpression_66_Var
		 = (PostfixExpression)UnaryExpression_65_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = PostfixExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final PrimaryExpression PrimaryExpression_67_Var
		 = (PrimaryExpression)Expr_66_list.get(0);
		Assert.assertNotNull(PrimaryExpression_67_Var
		);
		//67
		final Constant2 Constant2_68_Var
		 = (Constant2)PrimaryExpression_67_Var
		.getConst();
		Assert.assertNotNull(Constant2_68_Var
		);
		Assert.assertEquals("2", Constant2_68_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_33_Var
		.getSemi());
		//68
		final Statement Statement_69_Var
		 = (Statement)Statement_11_list.get(2);
		Assert.assertNotNull(Statement_69_Var
		);
		//69
		final ExpressionStatement ExpressionStatement_70_Var
		 = (ExpressionStatement)Statement_69_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_70_Var
		);
		//70
		final Expression Expression_71_Var
		 = (Expression)ExpressionStatement_70_Var
		.getExpression();
		Assert.assertNotNull(Expression_71_Var
		);
		final EList<? extends EObject> ExprExpr_71_list = Expression_71_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_71_list);
		Assert.assertEquals(1, ExprExpr_71_list.size());
		//71
		final AssignmentExpression AssignmentExpression_72_Var
		 = (AssignmentExpression)ExprExpr_71_list.get(0);
		Assert.assertNotNull(AssignmentExpression_72_Var
		);
		//72
		final ConditionalExpression ConditionalExpression_73_Var
		 = (ConditionalExpression)AssignmentExpression_72_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_73_Var
		);
		//73
		final LogicalOrExpression LogicalOrExpression_74_Var
		 = (LogicalOrExpression)ConditionalExpression_73_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = LogicalOrExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final LogicalAndExpression LogicalAndExpression_75_Var
		 = (LogicalAndExpression)Expr_74_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = LogicalAndExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final InclusiveOrExpression InclusiveOrExpression_76_Var
		 = (InclusiveOrExpression)Expr_75_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = InclusiveOrExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final ExclusiveOrExpression ExclusiveOrExpression_77_Var
		 = (ExclusiveOrExpression)Expr_76_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = ExclusiveOrExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final AndExpression AndExpression_78_Var
		 = (AndExpression)Expr_77_list.get(0);
		Assert.assertNotNull(AndExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = AndExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final EqualityExpression EqualityExpression_79_Var
		 = (EqualityExpression)Expr_78_list.get(0);
		Assert.assertNotNull(EqualityExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = EqualityExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final RelationalExpression RelationalExpression_80_Var
		 = (RelationalExpression)Expr_79_list.get(0);
		Assert.assertNotNull(RelationalExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = RelationalExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final ShiftExpression ShiftExpression_81_Var
		 = (ShiftExpression)Expr_80_list.get(0);
		Assert.assertNotNull(ShiftExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = ShiftExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final AdditiveExpression AdditiveExpression_82_Var
		 = (AdditiveExpression)Expr_81_list.get(0);
		Assert.assertNotNull(AdditiveExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = AdditiveExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final MultiplicativeExpression MultiplicativeExpression_83_Var
		 = (MultiplicativeExpression)Expr_82_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = MultiplicativeExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(2, Expr_83_list.size());
		//83
		final CastExpression CastExpression_84_Var
		 = (CastExpression)Expr_83_list.get(0);
		Assert.assertNotNull(CastExpression_84_Var
		);
		//84
		final UnaryExpression UnaryExpression_85_Var
		 = (UnaryExpression)CastExpression_84_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_85_Var
		);
		//85
		final PostfixExpression PostfixExpression_86_Var
		 = (PostfixExpression)UnaryExpression_85_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = PostfixExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final PrimaryExpression PrimaryExpression_87_Var
		 = (PrimaryExpression)Expr_86_list.get(0);
		Assert.assertNotNull(PrimaryExpression_87_Var
		);
		//87
		final Constant2 Constant2_88_Var
		 = (Constant2)PrimaryExpression_87_Var
		.getConst();
		Assert.assertNotNull(Constant2_88_Var
		);
		Assert.assertEquals("1", Constant2_88_Var
		.getDec());
		//88
		final CastExpression CastExpression_89_Var
		 = (CastExpression)Expr_83_list.get(1);
		Assert.assertNotNull(CastExpression_89_Var
		);
		//89
		final UnaryExpression UnaryExpression_90_Var
		 = (UnaryExpression)CastExpression_89_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_90_Var
		);
		//90
		final PostfixExpression PostfixExpression_91_Var
		 = (PostfixExpression)UnaryExpression_90_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = PostfixExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final PrimaryExpression PrimaryExpression_92_Var
		 = (PrimaryExpression)Expr_91_list.get(0);
		Assert.assertNotNull(PrimaryExpression_92_Var
		);
		//92
		final Constant2 Constant2_93_Var
		 = (Constant2)PrimaryExpression_92_Var
		.getConst();
		Assert.assertNotNull(Constant2_93_Var
		);
		Assert.assertEquals("2", Constant2_93_Var
		.getDec());
		Assert.assertEquals("[*]", MultiplicativeExpression_83_Var
		.getOp().toString());
		Assert.assertEquals(";", ExpressionStatement_70_Var
		.getSemi());
		//93
		final Statement Statement_94_Var
		 = (Statement)Statement_11_list.get(3);
		Assert.assertNotNull(Statement_94_Var
		);
		//94
		final ExpressionStatement ExpressionStatement_95_Var
		 = (ExpressionStatement)Statement_94_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_95_Var
		);
		//95
		final Expression Expression_96_Var
		 = (Expression)ExpressionStatement_95_Var
		.getExpression();
		Assert.assertNotNull(Expression_96_Var
		);
		final EList<? extends EObject> ExprExpr_96_list = Expression_96_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_96_list);
		Assert.assertEquals(1, ExprExpr_96_list.size());
		//96
		final AssignmentExpression AssignmentExpression_97_Var
		 = (AssignmentExpression)ExprExpr_96_list.get(0);
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
		Assert.assertEquals(2, Expr_106_list.size());
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
		//112
		final Constant2 Constant2_113_Var
		 = (Constant2)PrimaryExpression_112_Var
		.getConst();
		Assert.assertNotNull(Constant2_113_Var
		);
		Assert.assertEquals("1", Constant2_113_Var
		.getDec());
		//113
		final AdditiveExpression AdditiveExpression_114_Var
		 = (AdditiveExpression)Expr_106_list.get(1);
		Assert.assertNotNull(AdditiveExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = AdditiveExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final MultiplicativeExpression MultiplicativeExpression_115_Var
		 = (MultiplicativeExpression)Expr_114_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = MultiplicativeExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final CastExpression CastExpression_116_Var
		 = (CastExpression)Expr_115_list.get(0);
		Assert.assertNotNull(CastExpression_116_Var
		);
		//116
		final UnaryExpression UnaryExpression_117_Var
		 = (UnaryExpression)CastExpression_116_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_117_Var
		);
		//117
		final PostfixExpression PostfixExpression_118_Var
		 = (PostfixExpression)UnaryExpression_117_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = PostfixExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final PrimaryExpression PrimaryExpression_119_Var
		 = (PrimaryExpression)Expr_118_list.get(0);
		Assert.assertNotNull(PrimaryExpression_119_Var
		);
		//119
		final Constant2 Constant2_120_Var
		 = (Constant2)PrimaryExpression_119_Var
		.getConst();
		Assert.assertNotNull(Constant2_120_Var
		);
		Assert.assertEquals("2", Constant2_120_Var
		.getDec());
		Assert.assertEquals("[<<]", ShiftExpression_106_Var
		.getOp().toString());
		Assert.assertEquals(";", ExpressionStatement_95_Var
		.getSemi());
		//120
		final Statement Statement_121_Var
		 = (Statement)Statement_11_list.get(4);
		Assert.assertNotNull(Statement_121_Var
		);
		//121
		final ExpressionStatement ExpressionStatement_122_Var
		 = (ExpressionStatement)Statement_121_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_122_Var
		);
		//122
		final Expression Expression_123_Var
		 = (Expression)ExpressionStatement_122_Var
		.getExpression();
		Assert.assertNotNull(Expression_123_Var
		);
		final EList<? extends EObject> ExprExpr_123_list = Expression_123_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_123_list);
		Assert.assertEquals(1, ExprExpr_123_list.size());
		//123
		final AssignmentExpression AssignmentExpression_124_Var
		 = (AssignmentExpression)ExprExpr_123_list.get(0);
		Assert.assertNotNull(AssignmentExpression_124_Var
		);
		//124
		final ConditionalExpression ConditionalExpression_125_Var
		 = (ConditionalExpression)AssignmentExpression_124_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_125_Var
		);
		//125
		final LogicalOrExpression LogicalOrExpression_126_Var
		 = (LogicalOrExpression)ConditionalExpression_125_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = LogicalOrExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final LogicalAndExpression LogicalAndExpression_127_Var
		 = (LogicalAndExpression)Expr_126_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = LogicalAndExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final InclusiveOrExpression InclusiveOrExpression_128_Var
		 = (InclusiveOrExpression)Expr_127_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = InclusiveOrExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final ExclusiveOrExpression ExclusiveOrExpression_129_Var
		 = (ExclusiveOrExpression)Expr_128_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = ExclusiveOrExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final AndExpression AndExpression_130_Var
		 = (AndExpression)Expr_129_list.get(0);
		Assert.assertNotNull(AndExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = AndExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final EqualityExpression EqualityExpression_131_Var
		 = (EqualityExpression)Expr_130_list.get(0);
		Assert.assertNotNull(EqualityExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = EqualityExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final RelationalExpression RelationalExpression_132_Var
		 = (RelationalExpression)Expr_131_list.get(0);
		Assert.assertNotNull(RelationalExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = RelationalExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(2, Expr_132_list.size());
		//132
		final ShiftExpression ShiftExpression_133_Var
		 = (ShiftExpression)Expr_132_list.get(0);
		Assert.assertNotNull(ShiftExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = ShiftExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final AdditiveExpression AdditiveExpression_134_Var
		 = (AdditiveExpression)Expr_133_list.get(0);
		Assert.assertNotNull(AdditiveExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = AdditiveExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final MultiplicativeExpression MultiplicativeExpression_135_Var
		 = (MultiplicativeExpression)Expr_134_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = MultiplicativeExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final CastExpression CastExpression_136_Var
		 = (CastExpression)Expr_135_list.get(0);
		Assert.assertNotNull(CastExpression_136_Var
		);
		//136
		final UnaryExpression UnaryExpression_137_Var
		 = (UnaryExpression)CastExpression_136_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_137_Var
		);
		//137
		final PostfixExpression PostfixExpression_138_Var
		 = (PostfixExpression)UnaryExpression_137_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = PostfixExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final PrimaryExpression PrimaryExpression_139_Var
		 = (PrimaryExpression)Expr_138_list.get(0);
		Assert.assertNotNull(PrimaryExpression_139_Var
		);
		//139
		final Constant2 Constant2_140_Var
		 = (Constant2)PrimaryExpression_139_Var
		.getConst();
		Assert.assertNotNull(Constant2_140_Var
		);
		Assert.assertEquals("1", Constant2_140_Var
		.getDec());
		//140
		final ShiftExpression ShiftExpression_141_Var
		 = (ShiftExpression)Expr_132_list.get(1);
		Assert.assertNotNull(ShiftExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = ShiftExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final AdditiveExpression AdditiveExpression_142_Var
		 = (AdditiveExpression)Expr_141_list.get(0);
		Assert.assertNotNull(AdditiveExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = AdditiveExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final MultiplicativeExpression MultiplicativeExpression_143_Var
		 = (MultiplicativeExpression)Expr_142_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = MultiplicativeExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final CastExpression CastExpression_144_Var
		 = (CastExpression)Expr_143_list.get(0);
		Assert.assertNotNull(CastExpression_144_Var
		);
		//144
		final UnaryExpression UnaryExpression_145_Var
		 = (UnaryExpression)CastExpression_144_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_145_Var
		);
		//145
		final PostfixExpression PostfixExpression_146_Var
		 = (PostfixExpression)UnaryExpression_145_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_146_Var
		);
		final EList<? extends EObject> Expr_146_list = PostfixExpression_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final PrimaryExpression PrimaryExpression_147_Var
		 = (PrimaryExpression)Expr_146_list.get(0);
		Assert.assertNotNull(PrimaryExpression_147_Var
		);
		//147
		final Constant2 Constant2_148_Var
		 = (Constant2)PrimaryExpression_147_Var
		.getConst();
		Assert.assertNotNull(Constant2_148_Var
		);
		Assert.assertEquals("2", Constant2_148_Var
		.getDec());
		Assert.assertEquals("[<]", RelationalExpression_132_Var
		.getOp().toString());
		Assert.assertEquals(";", ExpressionStatement_122_Var
		.getSemi());
		//148
		final Statement Statement_149_Var
		 = (Statement)Statement_11_list.get(5);
		Assert.assertNotNull(Statement_149_Var
		);
		//149
		final ExpressionStatement ExpressionStatement_150_Var
		 = (ExpressionStatement)Statement_149_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_150_Var
		);
		//150
		final Expression Expression_151_Var
		 = (Expression)ExpressionStatement_150_Var
		.getExpression();
		Assert.assertNotNull(Expression_151_Var
		);
		final EList<? extends EObject> ExprExpr_151_list = Expression_151_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_151_list);
		Assert.assertEquals(1, ExprExpr_151_list.size());
		//151
		final AssignmentExpression AssignmentExpression_152_Var
		 = (AssignmentExpression)ExprExpr_151_list.get(0);
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
		Assert.assertEquals(2, Expr_159_list.size());
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
		Assert.assertEquals("1", Constant2_168_Var
		.getDec());
		//168
		final RelationalExpression RelationalExpression_169_Var
		 = (RelationalExpression)Expr_159_list.get(1);
		Assert.assertNotNull(RelationalExpression_169_Var
		);
		final EList<? extends EObject> Expr_169_list = RelationalExpression_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		//169
		final ShiftExpression ShiftExpression_170_Var
		 = (ShiftExpression)Expr_169_list.get(0);
		Assert.assertNotNull(ShiftExpression_170_Var
		);
		final EList<? extends EObject> Expr_170_list = ShiftExpression_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		//170
		final AdditiveExpression AdditiveExpression_171_Var
		 = (AdditiveExpression)Expr_170_list.get(0);
		Assert.assertNotNull(AdditiveExpression_171_Var
		);
		final EList<? extends EObject> Expr_171_list = AdditiveExpression_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		//171
		final MultiplicativeExpression MultiplicativeExpression_172_Var
		 = (MultiplicativeExpression)Expr_171_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = MultiplicativeExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final CastExpression CastExpression_173_Var
		 = (CastExpression)Expr_172_list.get(0);
		Assert.assertNotNull(CastExpression_173_Var
		);
		//173
		final UnaryExpression UnaryExpression_174_Var
		 = (UnaryExpression)CastExpression_173_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_174_Var
		);
		//174
		final PostfixExpression PostfixExpression_175_Var
		 = (PostfixExpression)UnaryExpression_174_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = PostfixExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final PrimaryExpression PrimaryExpression_176_Var
		 = (PrimaryExpression)Expr_175_list.get(0);
		Assert.assertNotNull(PrimaryExpression_176_Var
		);
		//176
		final Constant2 Constant2_177_Var
		 = (Constant2)PrimaryExpression_176_Var
		.getConst();
		Assert.assertNotNull(Constant2_177_Var
		);
		Assert.assertEquals("2", Constant2_177_Var
		.getDec());
		Assert.assertEquals("[==]", EqualityExpression_159_Var
		.getOp().toString());
		Assert.assertEquals(";", ExpressionStatement_150_Var
		.getSemi());
		//177
		final Statement Statement_178_Var
		 = (Statement)Statement_11_list.get(6);
		Assert.assertNotNull(Statement_178_Var
		);
		//178
		final ExpressionStatement ExpressionStatement_179_Var
		 = (ExpressionStatement)Statement_178_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_179_Var
		);
		//179
		final Expression Expression_180_Var
		 = (Expression)ExpressionStatement_179_Var
		.getExpression();
		Assert.assertNotNull(Expression_180_Var
		);
		final EList<? extends EObject> ExprExpr_180_list = Expression_180_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_180_list);
		Assert.assertEquals(1, ExprExpr_180_list.size());
		//180
		final AssignmentExpression AssignmentExpression_181_Var
		 = (AssignmentExpression)ExprExpr_180_list.get(0);
		Assert.assertNotNull(AssignmentExpression_181_Var
		);
		//181
		final ConditionalExpression ConditionalExpression_182_Var
		 = (ConditionalExpression)AssignmentExpression_181_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_182_Var
		);
		//182
		final LogicalOrExpression LogicalOrExpression_183_Var
		 = (LogicalOrExpression)ConditionalExpression_182_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = LogicalOrExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final LogicalAndExpression LogicalAndExpression_184_Var
		 = (LogicalAndExpression)Expr_183_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = LogicalAndExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final InclusiveOrExpression InclusiveOrExpression_185_Var
		 = (InclusiveOrExpression)Expr_184_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_185_Var
		);
		final EList<? extends EObject> Expr_185_list = InclusiveOrExpression_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final ExclusiveOrExpression ExclusiveOrExpression_186_Var
		 = (ExclusiveOrExpression)Expr_185_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_186_Var
		);
		final EList<? extends EObject> Expr_186_list = ExclusiveOrExpression_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(1, Expr_186_list.size());
		//186
		final AndExpression AndExpression_187_Var
		 = (AndExpression)Expr_186_list.get(0);
		Assert.assertNotNull(AndExpression_187_Var
		);
		final EList<? extends EObject> Expr_187_list = AndExpression_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(2, Expr_187_list.size());
		//187
		final EqualityExpression EqualityExpression_188_Var
		 = (EqualityExpression)Expr_187_list.get(0);
		Assert.assertNotNull(EqualityExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = EqualityExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final RelationalExpression RelationalExpression_189_Var
		 = (RelationalExpression)Expr_188_list.get(0);
		Assert.assertNotNull(RelationalExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = RelationalExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final ShiftExpression ShiftExpression_190_Var
		 = (ShiftExpression)Expr_189_list.get(0);
		Assert.assertNotNull(ShiftExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = ShiftExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final AdditiveExpression AdditiveExpression_191_Var
		 = (AdditiveExpression)Expr_190_list.get(0);
		Assert.assertNotNull(AdditiveExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = AdditiveExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final MultiplicativeExpression MultiplicativeExpression_192_Var
		 = (MultiplicativeExpression)Expr_191_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = MultiplicativeExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final CastExpression CastExpression_193_Var
		 = (CastExpression)Expr_192_list.get(0);
		Assert.assertNotNull(CastExpression_193_Var
		);
		//193
		final UnaryExpression UnaryExpression_194_Var
		 = (UnaryExpression)CastExpression_193_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_194_Var
		);
		//194
		final PostfixExpression PostfixExpression_195_Var
		 = (PostfixExpression)UnaryExpression_194_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = PostfixExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final PrimaryExpression PrimaryExpression_196_Var
		 = (PrimaryExpression)Expr_195_list.get(0);
		Assert.assertNotNull(PrimaryExpression_196_Var
		);
		//196
		final Constant2 Constant2_197_Var
		 = (Constant2)PrimaryExpression_196_Var
		.getConst();
		Assert.assertNotNull(Constant2_197_Var
		);
		Assert.assertEquals("1", Constant2_197_Var
		.getDec());
		//197
		final EqualityExpression EqualityExpression_198_Var
		 = (EqualityExpression)Expr_187_list.get(1);
		Assert.assertNotNull(EqualityExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = EqualityExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final RelationalExpression RelationalExpression_199_Var
		 = (RelationalExpression)Expr_198_list.get(0);
		Assert.assertNotNull(RelationalExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = RelationalExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final ShiftExpression ShiftExpression_200_Var
		 = (ShiftExpression)Expr_199_list.get(0);
		Assert.assertNotNull(ShiftExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = ShiftExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final AdditiveExpression AdditiveExpression_201_Var
		 = (AdditiveExpression)Expr_200_list.get(0);
		Assert.assertNotNull(AdditiveExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = AdditiveExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final MultiplicativeExpression MultiplicativeExpression_202_Var
		 = (MultiplicativeExpression)Expr_201_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = MultiplicativeExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final CastExpression CastExpression_203_Var
		 = (CastExpression)Expr_202_list.get(0);
		Assert.assertNotNull(CastExpression_203_Var
		);
		//203
		final UnaryExpression UnaryExpression_204_Var
		 = (UnaryExpression)CastExpression_203_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_204_Var
		);
		//204
		final PostfixExpression PostfixExpression_205_Var
		 = (PostfixExpression)UnaryExpression_204_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = PostfixExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final PrimaryExpression PrimaryExpression_206_Var
		 = (PrimaryExpression)Expr_205_list.get(0);
		Assert.assertNotNull(PrimaryExpression_206_Var
		);
		//206
		final Constant2 Constant2_207_Var
		 = (Constant2)PrimaryExpression_206_Var
		.getConst();
		Assert.assertNotNull(Constant2_207_Var
		);
		Assert.assertEquals("2", Constant2_207_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_179_Var
		.getSemi());
		//207
		final Statement Statement_208_Var
		 = (Statement)Statement_11_list.get(7);
		Assert.assertNotNull(Statement_208_Var
		);
		//208
		final ExpressionStatement ExpressionStatement_209_Var
		 = (ExpressionStatement)Statement_208_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_209_Var
		);
		//209
		final Expression Expression_210_Var
		 = (Expression)ExpressionStatement_209_Var
		.getExpression();
		Assert.assertNotNull(Expression_210_Var
		);
		final EList<? extends EObject> ExprExpr_210_list = Expression_210_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_210_list);
		Assert.assertEquals(1, ExprExpr_210_list.size());
		//210
		final AssignmentExpression AssignmentExpression_211_Var
		 = (AssignmentExpression)ExprExpr_210_list.get(0);
		Assert.assertNotNull(AssignmentExpression_211_Var
		);
		//211
		final ConditionalExpression ConditionalExpression_212_Var
		 = (ConditionalExpression)AssignmentExpression_211_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_212_Var
		);
		//212
		final LogicalOrExpression LogicalOrExpression_213_Var
		 = (LogicalOrExpression)ConditionalExpression_212_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = LogicalOrExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final LogicalAndExpression LogicalAndExpression_214_Var
		 = (LogicalAndExpression)Expr_213_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = LogicalAndExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final InclusiveOrExpression InclusiveOrExpression_215_Var
		 = (InclusiveOrExpression)Expr_214_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = InclusiveOrExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(2, Expr_215_list.size());
		//215
		final ExclusiveOrExpression ExclusiveOrExpression_216_Var
		 = (ExclusiveOrExpression)Expr_215_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = ExclusiveOrExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final AndExpression AndExpression_217_Var
		 = (AndExpression)Expr_216_list.get(0);
		Assert.assertNotNull(AndExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = AndExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final EqualityExpression EqualityExpression_218_Var
		 = (EqualityExpression)Expr_217_list.get(0);
		Assert.assertNotNull(EqualityExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = EqualityExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final RelationalExpression RelationalExpression_219_Var
		 = (RelationalExpression)Expr_218_list.get(0);
		Assert.assertNotNull(RelationalExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = RelationalExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final ShiftExpression ShiftExpression_220_Var
		 = (ShiftExpression)Expr_219_list.get(0);
		Assert.assertNotNull(ShiftExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = ShiftExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final AdditiveExpression AdditiveExpression_221_Var
		 = (AdditiveExpression)Expr_220_list.get(0);
		Assert.assertNotNull(AdditiveExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = AdditiveExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final MultiplicativeExpression MultiplicativeExpression_222_Var
		 = (MultiplicativeExpression)Expr_221_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = MultiplicativeExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final CastExpression CastExpression_223_Var
		 = (CastExpression)Expr_222_list.get(0);
		Assert.assertNotNull(CastExpression_223_Var
		);
		//223
		final UnaryExpression UnaryExpression_224_Var
		 = (UnaryExpression)CastExpression_223_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_224_Var
		);
		//224
		final PostfixExpression PostfixExpression_225_Var
		 = (PostfixExpression)UnaryExpression_224_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = PostfixExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final PrimaryExpression PrimaryExpression_226_Var
		 = (PrimaryExpression)Expr_225_list.get(0);
		Assert.assertNotNull(PrimaryExpression_226_Var
		);
		//226
		final Constant2 Constant2_227_Var
		 = (Constant2)PrimaryExpression_226_Var
		.getConst();
		Assert.assertNotNull(Constant2_227_Var
		);
		Assert.assertEquals("1", Constant2_227_Var
		.getDec());
		//227
		final ExclusiveOrExpression ExclusiveOrExpression_228_Var
		 = (ExclusiveOrExpression)Expr_215_list.get(1);
		Assert.assertNotNull(ExclusiveOrExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = ExclusiveOrExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final AndExpression AndExpression_229_Var
		 = (AndExpression)Expr_228_list.get(0);
		Assert.assertNotNull(AndExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = AndExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final EqualityExpression EqualityExpression_230_Var
		 = (EqualityExpression)Expr_229_list.get(0);
		Assert.assertNotNull(EqualityExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = EqualityExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final RelationalExpression RelationalExpression_231_Var
		 = (RelationalExpression)Expr_230_list.get(0);
		Assert.assertNotNull(RelationalExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = RelationalExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final ShiftExpression ShiftExpression_232_Var
		 = (ShiftExpression)Expr_231_list.get(0);
		Assert.assertNotNull(ShiftExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = ShiftExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final AdditiveExpression AdditiveExpression_233_Var
		 = (AdditiveExpression)Expr_232_list.get(0);
		Assert.assertNotNull(AdditiveExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = AdditiveExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final MultiplicativeExpression MultiplicativeExpression_234_Var
		 = (MultiplicativeExpression)Expr_233_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = MultiplicativeExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final CastExpression CastExpression_235_Var
		 = (CastExpression)Expr_234_list.get(0);
		Assert.assertNotNull(CastExpression_235_Var
		);
		//235
		final UnaryExpression UnaryExpression_236_Var
		 = (UnaryExpression)CastExpression_235_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_236_Var
		);
		//236
		final PostfixExpression PostfixExpression_237_Var
		 = (PostfixExpression)UnaryExpression_236_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = PostfixExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final PrimaryExpression PrimaryExpression_238_Var
		 = (PrimaryExpression)Expr_237_list.get(0);
		Assert.assertNotNull(PrimaryExpression_238_Var
		);
		//238
		final Constant2 Constant2_239_Var
		 = (Constant2)PrimaryExpression_238_Var
		.getConst();
		Assert.assertNotNull(Constant2_239_Var
		);
		Assert.assertEquals("2", Constant2_239_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_209_Var
		.getSemi());
		//239
		final Statement Statement_240_Var
		 = (Statement)Statement_11_list.get(8);
		Assert.assertNotNull(Statement_240_Var
		);
		//240
		final ExpressionStatement ExpressionStatement_241_Var
		 = (ExpressionStatement)Statement_240_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_241_Var
		);
		//241
		final Expression Expression_242_Var
		 = (Expression)ExpressionStatement_241_Var
		.getExpression();
		Assert.assertNotNull(Expression_242_Var
		);
		final EList<? extends EObject> ExprExpr_242_list = Expression_242_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_242_list);
		Assert.assertEquals(1, ExprExpr_242_list.size());
		//242
		final AssignmentExpression AssignmentExpression_243_Var
		 = (AssignmentExpression)ExprExpr_242_list.get(0);
		Assert.assertNotNull(AssignmentExpression_243_Var
		);
		//243
		final ConditionalExpression ConditionalExpression_244_Var
		 = (ConditionalExpression)AssignmentExpression_243_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_244_Var
		);
		//244
		final LogicalOrExpression LogicalOrExpression_245_Var
		 = (LogicalOrExpression)ConditionalExpression_244_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = LogicalOrExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final LogicalAndExpression LogicalAndExpression_246_Var
		 = (LogicalAndExpression)Expr_245_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = LogicalAndExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final InclusiveOrExpression InclusiveOrExpression_247_Var
		 = (InclusiveOrExpression)Expr_246_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = InclusiveOrExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final ExclusiveOrExpression ExclusiveOrExpression_248_Var
		 = (ExclusiveOrExpression)Expr_247_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = ExclusiveOrExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(2, Expr_248_list.size());
		//248
		final AndExpression AndExpression_249_Var
		 = (AndExpression)Expr_248_list.get(0);
		Assert.assertNotNull(AndExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = AndExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final EqualityExpression EqualityExpression_250_Var
		 = (EqualityExpression)Expr_249_list.get(0);
		Assert.assertNotNull(EqualityExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = EqualityExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final RelationalExpression RelationalExpression_251_Var
		 = (RelationalExpression)Expr_250_list.get(0);
		Assert.assertNotNull(RelationalExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = RelationalExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final ShiftExpression ShiftExpression_252_Var
		 = (ShiftExpression)Expr_251_list.get(0);
		Assert.assertNotNull(ShiftExpression_252_Var
		);
		final EList<? extends EObject> Expr_252_list = ShiftExpression_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(1, Expr_252_list.size());
		//252
		final AdditiveExpression AdditiveExpression_253_Var
		 = (AdditiveExpression)Expr_252_list.get(0);
		Assert.assertNotNull(AdditiveExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = AdditiveExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final MultiplicativeExpression MultiplicativeExpression_254_Var
		 = (MultiplicativeExpression)Expr_253_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = MultiplicativeExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final CastExpression CastExpression_255_Var
		 = (CastExpression)Expr_254_list.get(0);
		Assert.assertNotNull(CastExpression_255_Var
		);
		//255
		final UnaryExpression UnaryExpression_256_Var
		 = (UnaryExpression)CastExpression_255_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_256_Var
		);
		//256
		final PostfixExpression PostfixExpression_257_Var
		 = (PostfixExpression)UnaryExpression_256_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = PostfixExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final PrimaryExpression PrimaryExpression_258_Var
		 = (PrimaryExpression)Expr_257_list.get(0);
		Assert.assertNotNull(PrimaryExpression_258_Var
		);
		//258
		final Constant2 Constant2_259_Var
		 = (Constant2)PrimaryExpression_258_Var
		.getConst();
		Assert.assertNotNull(Constant2_259_Var
		);
		Assert.assertEquals("1", Constant2_259_Var
		.getDec());
		//259
		final AndExpression AndExpression_260_Var
		 = (AndExpression)Expr_248_list.get(1);
		Assert.assertNotNull(AndExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = AndExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final EqualityExpression EqualityExpression_261_Var
		 = (EqualityExpression)Expr_260_list.get(0);
		Assert.assertNotNull(EqualityExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = EqualityExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final RelationalExpression RelationalExpression_262_Var
		 = (RelationalExpression)Expr_261_list.get(0);
		Assert.assertNotNull(RelationalExpression_262_Var
		);
		final EList<? extends EObject> Expr_262_list = RelationalExpression_262_Var
		.getExpr();
		Assert.assertNotNull(Expr_262_list);
		Assert.assertEquals(1, Expr_262_list.size());
		//262
		final ShiftExpression ShiftExpression_263_Var
		 = (ShiftExpression)Expr_262_list.get(0);
		Assert.assertNotNull(ShiftExpression_263_Var
		);
		final EList<? extends EObject> Expr_263_list = ShiftExpression_263_Var
		.getExpr();
		Assert.assertNotNull(Expr_263_list);
		Assert.assertEquals(1, Expr_263_list.size());
		//263
		final AdditiveExpression AdditiveExpression_264_Var
		 = (AdditiveExpression)Expr_263_list.get(0);
		Assert.assertNotNull(AdditiveExpression_264_Var
		);
		final EList<? extends EObject> Expr_264_list = AdditiveExpression_264_Var
		.getExpr();
		Assert.assertNotNull(Expr_264_list);
		Assert.assertEquals(1, Expr_264_list.size());
		//264
		final MultiplicativeExpression MultiplicativeExpression_265_Var
		 = (MultiplicativeExpression)Expr_264_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_265_Var
		);
		final EList<? extends EObject> Expr_265_list = MultiplicativeExpression_265_Var
		.getExpr();
		Assert.assertNotNull(Expr_265_list);
		Assert.assertEquals(1, Expr_265_list.size());
		//265
		final CastExpression CastExpression_266_Var
		 = (CastExpression)Expr_265_list.get(0);
		Assert.assertNotNull(CastExpression_266_Var
		);
		//266
		final UnaryExpression UnaryExpression_267_Var
		 = (UnaryExpression)CastExpression_266_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_267_Var
		);
		//267
		final PostfixExpression PostfixExpression_268_Var
		 = (PostfixExpression)UnaryExpression_267_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_268_Var
		);
		final EList<? extends EObject> Expr_268_list = PostfixExpression_268_Var
		.getExpr();
		Assert.assertNotNull(Expr_268_list);
		Assert.assertEquals(1, Expr_268_list.size());
		//268
		final PrimaryExpression PrimaryExpression_269_Var
		 = (PrimaryExpression)Expr_268_list.get(0);
		Assert.assertNotNull(PrimaryExpression_269_Var
		);
		//269
		final Constant2 Constant2_270_Var
		 = (Constant2)PrimaryExpression_269_Var
		.getConst();
		Assert.assertNotNull(Constant2_270_Var
		);
		Assert.assertEquals("2", Constant2_270_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_241_Var
		.getSemi());
		//270
		final Statement Statement_271_Var
		 = (Statement)Statement_11_list.get(9);
		Assert.assertNotNull(Statement_271_Var
		);
		//271
		final ExpressionStatement ExpressionStatement_272_Var
		 = (ExpressionStatement)Statement_271_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_272_Var
		);
		//272
		final Expression Expression_273_Var
		 = (Expression)ExpressionStatement_272_Var
		.getExpression();
		Assert.assertNotNull(Expression_273_Var
		);
		final EList<? extends EObject> ExprExpr_273_list = Expression_273_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_273_list);
		Assert.assertEquals(1, ExprExpr_273_list.size());
		//273
		final AssignmentExpression AssignmentExpression_274_Var
		 = (AssignmentExpression)ExprExpr_273_list.get(0);
		Assert.assertNotNull(AssignmentExpression_274_Var
		);
		//274
		final ConditionalExpression ConditionalExpression_275_Var
		 = (ConditionalExpression)AssignmentExpression_274_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_275_Var
		);
		//275
		final LogicalOrExpression LogicalOrExpression_276_Var
		 = (LogicalOrExpression)ConditionalExpression_275_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_276_Var
		);
		final EList<? extends EObject> Expr_276_list = LogicalOrExpression_276_Var
		.getExpr();
		Assert.assertNotNull(Expr_276_list);
		Assert.assertEquals(1, Expr_276_list.size());
		//276
		final LogicalAndExpression LogicalAndExpression_277_Var
		 = (LogicalAndExpression)Expr_276_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_277_Var
		);
		final EList<? extends EObject> Expr_277_list = LogicalAndExpression_277_Var
		.getExpr();
		Assert.assertNotNull(Expr_277_list);
		Assert.assertEquals(2, Expr_277_list.size());
		//277
		final InclusiveOrExpression InclusiveOrExpression_278_Var
		 = (InclusiveOrExpression)Expr_277_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_278_Var
		);
		final EList<? extends EObject> Expr_278_list = InclusiveOrExpression_278_Var
		.getExpr();
		Assert.assertNotNull(Expr_278_list);
		Assert.assertEquals(1, Expr_278_list.size());
		//278
		final ExclusiveOrExpression ExclusiveOrExpression_279_Var
		 = (ExclusiveOrExpression)Expr_278_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_279_Var
		);
		final EList<? extends EObject> Expr_279_list = ExclusiveOrExpression_279_Var
		.getExpr();
		Assert.assertNotNull(Expr_279_list);
		Assert.assertEquals(1, Expr_279_list.size());
		//279
		final AndExpression AndExpression_280_Var
		 = (AndExpression)Expr_279_list.get(0);
		Assert.assertNotNull(AndExpression_280_Var
		);
		final EList<? extends EObject> Expr_280_list = AndExpression_280_Var
		.getExpr();
		Assert.assertNotNull(Expr_280_list);
		Assert.assertEquals(1, Expr_280_list.size());
		//280
		final EqualityExpression EqualityExpression_281_Var
		 = (EqualityExpression)Expr_280_list.get(0);
		Assert.assertNotNull(EqualityExpression_281_Var
		);
		final EList<? extends EObject> Expr_281_list = EqualityExpression_281_Var
		.getExpr();
		Assert.assertNotNull(Expr_281_list);
		Assert.assertEquals(1, Expr_281_list.size());
		//281
		final RelationalExpression RelationalExpression_282_Var
		 = (RelationalExpression)Expr_281_list.get(0);
		Assert.assertNotNull(RelationalExpression_282_Var
		);
		final EList<? extends EObject> Expr_282_list = RelationalExpression_282_Var
		.getExpr();
		Assert.assertNotNull(Expr_282_list);
		Assert.assertEquals(1, Expr_282_list.size());
		//282
		final ShiftExpression ShiftExpression_283_Var
		 = (ShiftExpression)Expr_282_list.get(0);
		Assert.assertNotNull(ShiftExpression_283_Var
		);
		final EList<? extends EObject> Expr_283_list = ShiftExpression_283_Var
		.getExpr();
		Assert.assertNotNull(Expr_283_list);
		Assert.assertEquals(1, Expr_283_list.size());
		//283
		final AdditiveExpression AdditiveExpression_284_Var
		 = (AdditiveExpression)Expr_283_list.get(0);
		Assert.assertNotNull(AdditiveExpression_284_Var
		);
		final EList<? extends EObject> Expr_284_list = AdditiveExpression_284_Var
		.getExpr();
		Assert.assertNotNull(Expr_284_list);
		Assert.assertEquals(1, Expr_284_list.size());
		//284
		final MultiplicativeExpression MultiplicativeExpression_285_Var
		 = (MultiplicativeExpression)Expr_284_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_285_Var
		);
		final EList<? extends EObject> Expr_285_list = MultiplicativeExpression_285_Var
		.getExpr();
		Assert.assertNotNull(Expr_285_list);
		Assert.assertEquals(1, Expr_285_list.size());
		//285
		final CastExpression CastExpression_286_Var
		 = (CastExpression)Expr_285_list.get(0);
		Assert.assertNotNull(CastExpression_286_Var
		);
		//286
		final UnaryExpression UnaryExpression_287_Var
		 = (UnaryExpression)CastExpression_286_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_287_Var
		);
		//287
		final PostfixExpression PostfixExpression_288_Var
		 = (PostfixExpression)UnaryExpression_287_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_288_Var
		);
		final EList<? extends EObject> Expr_288_list = PostfixExpression_288_Var
		.getExpr();
		Assert.assertNotNull(Expr_288_list);
		Assert.assertEquals(1, Expr_288_list.size());
		//288
		final PrimaryExpression PrimaryExpression_289_Var
		 = (PrimaryExpression)Expr_288_list.get(0);
		Assert.assertNotNull(PrimaryExpression_289_Var
		);
		//289
		final Constant2 Constant2_290_Var
		 = (Constant2)PrimaryExpression_289_Var
		.getConst();
		Assert.assertNotNull(Constant2_290_Var
		);
		Assert.assertEquals("1", Constant2_290_Var
		.getDec());
		//290
		final InclusiveOrExpression InclusiveOrExpression_291_Var
		 = (InclusiveOrExpression)Expr_277_list.get(1);
		Assert.assertNotNull(InclusiveOrExpression_291_Var
		);
		final EList<? extends EObject> Expr_291_list = InclusiveOrExpression_291_Var
		.getExpr();
		Assert.assertNotNull(Expr_291_list);
		Assert.assertEquals(1, Expr_291_list.size());
		//291
		final ExclusiveOrExpression ExclusiveOrExpression_292_Var
		 = (ExclusiveOrExpression)Expr_291_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_292_Var
		);
		final EList<? extends EObject> Expr_292_list = ExclusiveOrExpression_292_Var
		.getExpr();
		Assert.assertNotNull(Expr_292_list);
		Assert.assertEquals(1, Expr_292_list.size());
		//292
		final AndExpression AndExpression_293_Var
		 = (AndExpression)Expr_292_list.get(0);
		Assert.assertNotNull(AndExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = AndExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final EqualityExpression EqualityExpression_294_Var
		 = (EqualityExpression)Expr_293_list.get(0);
		Assert.assertNotNull(EqualityExpression_294_Var
		);
		final EList<? extends EObject> Expr_294_list = EqualityExpression_294_Var
		.getExpr();
		Assert.assertNotNull(Expr_294_list);
		Assert.assertEquals(1, Expr_294_list.size());
		//294
		final RelationalExpression RelationalExpression_295_Var
		 = (RelationalExpression)Expr_294_list.get(0);
		Assert.assertNotNull(RelationalExpression_295_Var
		);
		final EList<? extends EObject> Expr_295_list = RelationalExpression_295_Var
		.getExpr();
		Assert.assertNotNull(Expr_295_list);
		Assert.assertEquals(1, Expr_295_list.size());
		//295
		final ShiftExpression ShiftExpression_296_Var
		 = (ShiftExpression)Expr_295_list.get(0);
		Assert.assertNotNull(ShiftExpression_296_Var
		);
		final EList<? extends EObject> Expr_296_list = ShiftExpression_296_Var
		.getExpr();
		Assert.assertNotNull(Expr_296_list);
		Assert.assertEquals(1, Expr_296_list.size());
		//296
		final AdditiveExpression AdditiveExpression_297_Var
		 = (AdditiveExpression)Expr_296_list.get(0);
		Assert.assertNotNull(AdditiveExpression_297_Var
		);
		final EList<? extends EObject> Expr_297_list = AdditiveExpression_297_Var
		.getExpr();
		Assert.assertNotNull(Expr_297_list);
		Assert.assertEquals(1, Expr_297_list.size());
		//297
		final MultiplicativeExpression MultiplicativeExpression_298_Var
		 = (MultiplicativeExpression)Expr_297_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_298_Var
		);
		final EList<? extends EObject> Expr_298_list = MultiplicativeExpression_298_Var
		.getExpr();
		Assert.assertNotNull(Expr_298_list);
		Assert.assertEquals(1, Expr_298_list.size());
		//298
		final CastExpression CastExpression_299_Var
		 = (CastExpression)Expr_298_list.get(0);
		Assert.assertNotNull(CastExpression_299_Var
		);
		//299
		final UnaryExpression UnaryExpression_300_Var
		 = (UnaryExpression)CastExpression_299_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_300_Var
		);
		//300
		final PostfixExpression PostfixExpression_301_Var
		 = (PostfixExpression)UnaryExpression_300_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_301_Var
		);
		final EList<? extends EObject> Expr_301_list = PostfixExpression_301_Var
		.getExpr();
		Assert.assertNotNull(Expr_301_list);
		Assert.assertEquals(1, Expr_301_list.size());
		//301
		final PrimaryExpression PrimaryExpression_302_Var
		 = (PrimaryExpression)Expr_301_list.get(0);
		Assert.assertNotNull(PrimaryExpression_302_Var
		);
		//302
		final Constant2 Constant2_303_Var
		 = (Constant2)PrimaryExpression_302_Var
		.getConst();
		Assert.assertNotNull(Constant2_303_Var
		);
		Assert.assertEquals("2", Constant2_303_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_272_Var
		.getSemi());
		//303
		final Statement Statement_304_Var
		 = (Statement)Statement_11_list.get(10);
		Assert.assertNotNull(Statement_304_Var
		);
		//304
		final ExpressionStatement ExpressionStatement_305_Var
		 = (ExpressionStatement)Statement_304_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_305_Var
		);
		//305
		final Expression Expression_306_Var
		 = (Expression)ExpressionStatement_305_Var
		.getExpression();
		Assert.assertNotNull(Expression_306_Var
		);
		final EList<? extends EObject> ExprExpr_306_list = Expression_306_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_306_list);
		Assert.assertEquals(1, ExprExpr_306_list.size());
		//306
		final AssignmentExpression AssignmentExpression_307_Var
		 = (AssignmentExpression)ExprExpr_306_list.get(0);
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
		Assert.assertEquals(2, Expr_309_list.size());
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
		//322
		final Constant2 Constant2_323_Var
		 = (Constant2)PrimaryExpression_322_Var
		.getConst();
		Assert.assertNotNull(Constant2_323_Var
		);
		Assert.assertEquals("1", Constant2_323_Var
		.getDec());
		//323
		final LogicalAndExpression LogicalAndExpression_324_Var
		 = (LogicalAndExpression)Expr_309_list.get(1);
		Assert.assertNotNull(LogicalAndExpression_324_Var
		);
		final EList<? extends EObject> Expr_324_list = LogicalAndExpression_324_Var
		.getExpr();
		Assert.assertNotNull(Expr_324_list);
		Assert.assertEquals(1, Expr_324_list.size());
		//324
		final InclusiveOrExpression InclusiveOrExpression_325_Var
		 = (InclusiveOrExpression)Expr_324_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_325_Var
		);
		final EList<? extends EObject> Expr_325_list = InclusiveOrExpression_325_Var
		.getExpr();
		Assert.assertNotNull(Expr_325_list);
		Assert.assertEquals(1, Expr_325_list.size());
		//325
		final ExclusiveOrExpression ExclusiveOrExpression_326_Var
		 = (ExclusiveOrExpression)Expr_325_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_326_Var
		);
		final EList<? extends EObject> Expr_326_list = ExclusiveOrExpression_326_Var
		.getExpr();
		Assert.assertNotNull(Expr_326_list);
		Assert.assertEquals(1, Expr_326_list.size());
		//326
		final AndExpression AndExpression_327_Var
		 = (AndExpression)Expr_326_list.get(0);
		Assert.assertNotNull(AndExpression_327_Var
		);
		final EList<? extends EObject> Expr_327_list = AndExpression_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final EqualityExpression EqualityExpression_328_Var
		 = (EqualityExpression)Expr_327_list.get(0);
		Assert.assertNotNull(EqualityExpression_328_Var
		);
		final EList<? extends EObject> Expr_328_list = EqualityExpression_328_Var
		.getExpr();
		Assert.assertNotNull(Expr_328_list);
		Assert.assertEquals(1, Expr_328_list.size());
		//328
		final RelationalExpression RelationalExpression_329_Var
		 = (RelationalExpression)Expr_328_list.get(0);
		Assert.assertNotNull(RelationalExpression_329_Var
		);
		final EList<? extends EObject> Expr_329_list = RelationalExpression_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final ShiftExpression ShiftExpression_330_Var
		 = (ShiftExpression)Expr_329_list.get(0);
		Assert.assertNotNull(ShiftExpression_330_Var
		);
		final EList<? extends EObject> Expr_330_list = ShiftExpression_330_Var
		.getExpr();
		Assert.assertNotNull(Expr_330_list);
		Assert.assertEquals(1, Expr_330_list.size());
		//330
		final AdditiveExpression AdditiveExpression_331_Var
		 = (AdditiveExpression)Expr_330_list.get(0);
		Assert.assertNotNull(AdditiveExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = AdditiveExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final MultiplicativeExpression MultiplicativeExpression_332_Var
		 = (MultiplicativeExpression)Expr_331_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_332_Var
		);
		final EList<? extends EObject> Expr_332_list = MultiplicativeExpression_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final CastExpression CastExpression_333_Var
		 = (CastExpression)Expr_332_list.get(0);
		Assert.assertNotNull(CastExpression_333_Var
		);
		//333
		final UnaryExpression UnaryExpression_334_Var
		 = (UnaryExpression)CastExpression_333_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_334_Var
		);
		//334
		final PostfixExpression PostfixExpression_335_Var
		 = (PostfixExpression)UnaryExpression_334_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = PostfixExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final PrimaryExpression PrimaryExpression_336_Var
		 = (PrimaryExpression)Expr_335_list.get(0);
		Assert.assertNotNull(PrimaryExpression_336_Var
		);
		//336
		final Constant2 Constant2_337_Var
		 = (Constant2)PrimaryExpression_336_Var
		.getConst();
		Assert.assertNotNull(Constant2_337_Var
		);
		Assert.assertEquals("2", Constant2_337_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_305_Var
		.getSemi());
		//337
		final Statement Statement_338_Var
		 = (Statement)Statement_11_list.get(11);
		Assert.assertNotNull(Statement_338_Var
		);
		//338
		final ExpressionStatement ExpressionStatement_339_Var
		 = (ExpressionStatement)Statement_338_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_339_Var
		);
		//339
		final Expression Expression_340_Var
		 = (Expression)ExpressionStatement_339_Var
		.getExpression();
		Assert.assertNotNull(Expression_340_Var
		);
		final EList<? extends EObject> ExprExpr_340_list = Expression_340_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_340_list);
		Assert.assertEquals(1, ExprExpr_340_list.size());
		//340
		final AssignmentExpression AssignmentExpression_341_Var
		 = (AssignmentExpression)ExprExpr_340_list.get(0);
		Assert.assertNotNull(AssignmentExpression_341_Var
		);
		//341
		final ConditionalExpression ConditionalExpression_342_Var
		 = (ConditionalExpression)AssignmentExpression_341_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_342_Var
		);
		//342
		final LogicalOrExpression LogicalOrExpression_343_Var
		 = (LogicalOrExpression)ConditionalExpression_342_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_343_Var
		);
		final EList<? extends EObject> Expr_343_list = LogicalOrExpression_343_Var
		.getExpr();
		Assert.assertNotNull(Expr_343_list);
		Assert.assertEquals(1, Expr_343_list.size());
		//343
		final LogicalAndExpression LogicalAndExpression_344_Var
		 = (LogicalAndExpression)Expr_343_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_344_Var
		);
		final EList<? extends EObject> Expr_344_list = LogicalAndExpression_344_Var
		.getExpr();
		Assert.assertNotNull(Expr_344_list);
		Assert.assertEquals(1, Expr_344_list.size());
		//344
		final InclusiveOrExpression InclusiveOrExpression_345_Var
		 = (InclusiveOrExpression)Expr_344_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_345_Var
		);
		final EList<? extends EObject> Expr_345_list = InclusiveOrExpression_345_Var
		.getExpr();
		Assert.assertNotNull(Expr_345_list);
		Assert.assertEquals(1, Expr_345_list.size());
		//345
		final ExclusiveOrExpression ExclusiveOrExpression_346_Var
		 = (ExclusiveOrExpression)Expr_345_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_346_Var
		);
		final EList<? extends EObject> Expr_346_list = ExclusiveOrExpression_346_Var
		.getExpr();
		Assert.assertNotNull(Expr_346_list);
		Assert.assertEquals(1, Expr_346_list.size());
		//346
		final AndExpression AndExpression_347_Var
		 = (AndExpression)Expr_346_list.get(0);
		Assert.assertNotNull(AndExpression_347_Var
		);
		final EList<? extends EObject> Expr_347_list = AndExpression_347_Var
		.getExpr();
		Assert.assertNotNull(Expr_347_list);
		Assert.assertEquals(1, Expr_347_list.size());
		//347
		final EqualityExpression EqualityExpression_348_Var
		 = (EqualityExpression)Expr_347_list.get(0);
		Assert.assertNotNull(EqualityExpression_348_Var
		);
		final EList<? extends EObject> Expr_348_list = EqualityExpression_348_Var
		.getExpr();
		Assert.assertNotNull(Expr_348_list);
		Assert.assertEquals(1, Expr_348_list.size());
		//348
		final RelationalExpression RelationalExpression_349_Var
		 = (RelationalExpression)Expr_348_list.get(0);
		Assert.assertNotNull(RelationalExpression_349_Var
		);
		final EList<? extends EObject> Expr_349_list = RelationalExpression_349_Var
		.getExpr();
		Assert.assertNotNull(Expr_349_list);
		Assert.assertEquals(1, Expr_349_list.size());
		//349
		final ShiftExpression ShiftExpression_350_Var
		 = (ShiftExpression)Expr_349_list.get(0);
		Assert.assertNotNull(ShiftExpression_350_Var
		);
		final EList<? extends EObject> Expr_350_list = ShiftExpression_350_Var
		.getExpr();
		Assert.assertNotNull(Expr_350_list);
		Assert.assertEquals(1, Expr_350_list.size());
		//350
		final AdditiveExpression AdditiveExpression_351_Var
		 = (AdditiveExpression)Expr_350_list.get(0);
		Assert.assertNotNull(AdditiveExpression_351_Var
		);
		final EList<? extends EObject> Expr_351_list = AdditiveExpression_351_Var
		.getExpr();
		Assert.assertNotNull(Expr_351_list);
		Assert.assertEquals(1, Expr_351_list.size());
		//351
		final MultiplicativeExpression MultiplicativeExpression_352_Var
		 = (MultiplicativeExpression)Expr_351_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_352_Var
		);
		final EList<? extends EObject> Expr_352_list = MultiplicativeExpression_352_Var
		.getExpr();
		Assert.assertNotNull(Expr_352_list);
		Assert.assertEquals(1, Expr_352_list.size());
		//352
		final CastExpression CastExpression_353_Var
		 = (CastExpression)Expr_352_list.get(0);
		Assert.assertNotNull(CastExpression_353_Var
		);
		//353
		final UnaryExpression UnaryExpression_354_Var
		 = (UnaryExpression)CastExpression_353_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_354_Var
		);
		//354
		final PostfixExpression PostfixExpression_355_Var
		 = (PostfixExpression)UnaryExpression_354_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_355_Var
		);
		final EList<? extends EObject> Expr_355_list = PostfixExpression_355_Var
		.getExpr();
		Assert.assertNotNull(Expr_355_list);
		Assert.assertEquals(1, Expr_355_list.size());
		//355
		final PrimaryExpression PrimaryExpression_356_Var
		 = (PrimaryExpression)Expr_355_list.get(0);
		Assert.assertNotNull(PrimaryExpression_356_Var
		);
		//356
		final Constant2 Constant2_357_Var
		 = (Constant2)PrimaryExpression_356_Var
		.getConst();
		Assert.assertNotNull(Constant2_357_Var
		);
		Assert.assertEquals("1", Constant2_357_Var
		.getDec());
		//357
		final Expression Expression_358_Var
		 = (Expression)ConditionalExpression_342_Var
		.getQExpr();
		Assert.assertNotNull(Expression_358_Var
		);
		final EList<? extends EObject> ExprExpr_358_list = Expression_358_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_358_list);
		Assert.assertEquals(1, ExprExpr_358_list.size());
		//358
		final AssignmentExpression AssignmentExpression_359_Var
		 = (AssignmentExpression)ExprExpr_358_list.get(0);
		Assert.assertNotNull(AssignmentExpression_359_Var
		);
		//359
		final ConditionalExpression ConditionalExpression_360_Var
		 = (ConditionalExpression)AssignmentExpression_359_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_360_Var
		);
		//360
		final LogicalOrExpression LogicalOrExpression_361_Var
		 = (LogicalOrExpression)ConditionalExpression_360_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_361_Var
		);
		final EList<? extends EObject> Expr_361_list = LogicalOrExpression_361_Var
		.getExpr();
		Assert.assertNotNull(Expr_361_list);
		Assert.assertEquals(1, Expr_361_list.size());
		//361
		final LogicalAndExpression LogicalAndExpression_362_Var
		 = (LogicalAndExpression)Expr_361_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_362_Var
		);
		final EList<? extends EObject> Expr_362_list = LogicalAndExpression_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(1, Expr_362_list.size());
		//362
		final InclusiveOrExpression InclusiveOrExpression_363_Var
		 = (InclusiveOrExpression)Expr_362_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_363_Var
		);
		final EList<? extends EObject> Expr_363_list = InclusiveOrExpression_363_Var
		.getExpr();
		Assert.assertNotNull(Expr_363_list);
		Assert.assertEquals(1, Expr_363_list.size());
		//363
		final ExclusiveOrExpression ExclusiveOrExpression_364_Var
		 = (ExclusiveOrExpression)Expr_363_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_364_Var
		);
		final EList<? extends EObject> Expr_364_list = ExclusiveOrExpression_364_Var
		.getExpr();
		Assert.assertNotNull(Expr_364_list);
		Assert.assertEquals(1, Expr_364_list.size());
		//364
		final AndExpression AndExpression_365_Var
		 = (AndExpression)Expr_364_list.get(0);
		Assert.assertNotNull(AndExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = AndExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final EqualityExpression EqualityExpression_366_Var
		 = (EqualityExpression)Expr_365_list.get(0);
		Assert.assertNotNull(EqualityExpression_366_Var
		);
		final EList<? extends EObject> Expr_366_list = EqualityExpression_366_Var
		.getExpr();
		Assert.assertNotNull(Expr_366_list);
		Assert.assertEquals(1, Expr_366_list.size());
		//366
		final RelationalExpression RelationalExpression_367_Var
		 = (RelationalExpression)Expr_366_list.get(0);
		Assert.assertNotNull(RelationalExpression_367_Var
		);
		final EList<? extends EObject> Expr_367_list = RelationalExpression_367_Var
		.getExpr();
		Assert.assertNotNull(Expr_367_list);
		Assert.assertEquals(1, Expr_367_list.size());
		//367
		final ShiftExpression ShiftExpression_368_Var
		 = (ShiftExpression)Expr_367_list.get(0);
		Assert.assertNotNull(ShiftExpression_368_Var
		);
		final EList<? extends EObject> Expr_368_list = ShiftExpression_368_Var
		.getExpr();
		Assert.assertNotNull(Expr_368_list);
		Assert.assertEquals(1, Expr_368_list.size());
		//368
		final AdditiveExpression AdditiveExpression_369_Var
		 = (AdditiveExpression)Expr_368_list.get(0);
		Assert.assertNotNull(AdditiveExpression_369_Var
		);
		final EList<? extends EObject> Expr_369_list = AdditiveExpression_369_Var
		.getExpr();
		Assert.assertNotNull(Expr_369_list);
		Assert.assertEquals(1, Expr_369_list.size());
		//369
		final MultiplicativeExpression MultiplicativeExpression_370_Var
		 = (MultiplicativeExpression)Expr_369_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_370_Var
		);
		final EList<? extends EObject> Expr_370_list = MultiplicativeExpression_370_Var
		.getExpr();
		Assert.assertNotNull(Expr_370_list);
		Assert.assertEquals(1, Expr_370_list.size());
		//370
		final CastExpression CastExpression_371_Var
		 = (CastExpression)Expr_370_list.get(0);
		Assert.assertNotNull(CastExpression_371_Var
		);
		//371
		final UnaryExpression UnaryExpression_372_Var
		 = (UnaryExpression)CastExpression_371_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_372_Var
		);
		//372
		final PostfixExpression PostfixExpression_373_Var
		 = (PostfixExpression)UnaryExpression_372_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_373_Var
		);
		final EList<? extends EObject> Expr_373_list = PostfixExpression_373_Var
		.getExpr();
		Assert.assertNotNull(Expr_373_list);
		Assert.assertEquals(1, Expr_373_list.size());
		//373
		final PrimaryExpression PrimaryExpression_374_Var
		 = (PrimaryExpression)Expr_373_list.get(0);
		Assert.assertNotNull(PrimaryExpression_374_Var
		);
		//374
		final Constant2 Constant2_375_Var
		 = (Constant2)PrimaryExpression_374_Var
		.getConst();
		Assert.assertNotNull(Constant2_375_Var
		);
		Assert.assertEquals("2", Constant2_375_Var
		.getDec());
		//375
		final ConditionalExpression ConditionalExpression_376_Var
		 = (ConditionalExpression)ConditionalExpression_342_Var
		.getCExpr();
		Assert.assertNotNull(ConditionalExpression_376_Var
		);
		//376
		final LogicalOrExpression LogicalOrExpression_377_Var
		 = (LogicalOrExpression)ConditionalExpression_376_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_377_Var
		);
		final EList<? extends EObject> Expr_377_list = LogicalOrExpression_377_Var
		.getExpr();
		Assert.assertNotNull(Expr_377_list);
		Assert.assertEquals(1, Expr_377_list.size());
		//377
		final LogicalAndExpression LogicalAndExpression_378_Var
		 = (LogicalAndExpression)Expr_377_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_378_Var
		);
		final EList<? extends EObject> Expr_378_list = LogicalAndExpression_378_Var
		.getExpr();
		Assert.assertNotNull(Expr_378_list);
		Assert.assertEquals(1, Expr_378_list.size());
		//378
		final InclusiveOrExpression InclusiveOrExpression_379_Var
		 = (InclusiveOrExpression)Expr_378_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_379_Var
		);
		final EList<? extends EObject> Expr_379_list = InclusiveOrExpression_379_Var
		.getExpr();
		Assert.assertNotNull(Expr_379_list);
		Assert.assertEquals(1, Expr_379_list.size());
		//379
		final ExclusiveOrExpression ExclusiveOrExpression_380_Var
		 = (ExclusiveOrExpression)Expr_379_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_380_Var
		);
		final EList<? extends EObject> Expr_380_list = ExclusiveOrExpression_380_Var
		.getExpr();
		Assert.assertNotNull(Expr_380_list);
		Assert.assertEquals(1, Expr_380_list.size());
		//380
		final AndExpression AndExpression_381_Var
		 = (AndExpression)Expr_380_list.get(0);
		Assert.assertNotNull(AndExpression_381_Var
		);
		final EList<? extends EObject> Expr_381_list = AndExpression_381_Var
		.getExpr();
		Assert.assertNotNull(Expr_381_list);
		Assert.assertEquals(1, Expr_381_list.size());
		//381
		final EqualityExpression EqualityExpression_382_Var
		 = (EqualityExpression)Expr_381_list.get(0);
		Assert.assertNotNull(EqualityExpression_382_Var
		);
		final EList<? extends EObject> Expr_382_list = EqualityExpression_382_Var
		.getExpr();
		Assert.assertNotNull(Expr_382_list);
		Assert.assertEquals(1, Expr_382_list.size());
		//382
		final RelationalExpression RelationalExpression_383_Var
		 = (RelationalExpression)Expr_382_list.get(0);
		Assert.assertNotNull(RelationalExpression_383_Var
		);
		final EList<? extends EObject> Expr_383_list = RelationalExpression_383_Var
		.getExpr();
		Assert.assertNotNull(Expr_383_list);
		Assert.assertEquals(1, Expr_383_list.size());
		//383
		final ShiftExpression ShiftExpression_384_Var
		 = (ShiftExpression)Expr_383_list.get(0);
		Assert.assertNotNull(ShiftExpression_384_Var
		);
		final EList<? extends EObject> Expr_384_list = ShiftExpression_384_Var
		.getExpr();
		Assert.assertNotNull(Expr_384_list);
		Assert.assertEquals(1, Expr_384_list.size());
		//384
		final AdditiveExpression AdditiveExpression_385_Var
		 = (AdditiveExpression)Expr_384_list.get(0);
		Assert.assertNotNull(AdditiveExpression_385_Var
		);
		final EList<? extends EObject> Expr_385_list = AdditiveExpression_385_Var
		.getExpr();
		Assert.assertNotNull(Expr_385_list);
		Assert.assertEquals(1, Expr_385_list.size());
		//385
		final MultiplicativeExpression MultiplicativeExpression_386_Var
		 = (MultiplicativeExpression)Expr_385_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_386_Var
		);
		final EList<? extends EObject> Expr_386_list = MultiplicativeExpression_386_Var
		.getExpr();
		Assert.assertNotNull(Expr_386_list);
		Assert.assertEquals(1, Expr_386_list.size());
		//386
		final CastExpression CastExpression_387_Var
		 = (CastExpression)Expr_386_list.get(0);
		Assert.assertNotNull(CastExpression_387_Var
		);
		//387
		final UnaryExpression UnaryExpression_388_Var
		 = (UnaryExpression)CastExpression_387_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_388_Var
		);
		//388
		final PostfixExpression PostfixExpression_389_Var
		 = (PostfixExpression)UnaryExpression_388_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_389_Var
		);
		final EList<? extends EObject> Expr_389_list = PostfixExpression_389_Var
		.getExpr();
		Assert.assertNotNull(Expr_389_list);
		Assert.assertEquals(1, Expr_389_list.size());
		//389
		final PrimaryExpression PrimaryExpression_390_Var
		 = (PrimaryExpression)Expr_389_list.get(0);
		Assert.assertNotNull(PrimaryExpression_390_Var
		);
		//390
		final Constant2 Constant2_391_Var
		 = (Constant2)PrimaryExpression_390_Var
		.getConst();
		Assert.assertNotNull(Constant2_391_Var
		);
		Assert.assertEquals("3", Constant2_391_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_339_Var
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


