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
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.InitializerList;
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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;
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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;
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
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;
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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;
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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;
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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;
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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;
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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;
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
public class Test0037_Struct {
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
	
	@Test
	public void checkLexerTokens() throws Exception{
		final String text = this.getTextFromFile(
			"res/Test0037_Struct.c");
			//System.out.println(text);
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
	
	@Test
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0037_Struct.c");
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
		Assert.assertEquals(3, External_2_list.size());
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
		final StructOrUnionSpecifier StructOrUnionSpecifier_6_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_5_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_6_Var
		);
		//6
		final StructOrUnion StructOrUnion_7_Var
		 = (StructOrUnion)StructOrUnionSpecifier_6_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_7_Var
		);
		Assert.assertEquals("struct", StructOrUnion_7_Var
		.getName());
		Assert.assertEquals("employee", StructOrUnionSpecifier_6_Var
		.getId());
		//7
		final StructDeclarationList StructDeclarationList_8_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_6_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_8_Var
		);
		final EList<? extends EObject> StructDeclaration_8_list = StructDeclarationList_8_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_8_list);
		Assert.assertEquals(2, StructDeclaration_8_list.size());
		//8
		final StructDeclaration StructDeclaration_9_Var
		 = (StructDeclaration)StructDeclaration_8_list.get(0);
		Assert.assertNotNull(StructDeclaration_9_Var
		);
		//9
		final SpecifierQualifierList SpecifierQualifierList_10_Var
		 = (SpecifierQualifierList)StructDeclaration_9_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_10_Var
		);
		final EList<? extends EObject> TypeSpecifier_10_list = SpecifierQualifierList_10_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_10_list);
		Assert.assertEquals(1, TypeSpecifier_10_list.size());
		//10
		final TypeSpecifier TypeSpecifier_11_Var
		 = (TypeSpecifier)TypeSpecifier_10_list.get(0);
		Assert.assertNotNull(TypeSpecifier_11_Var
		);
		Assert.assertEquals("int", TypeSpecifier_11_Var
		.getName());
		//11
		final StructDeclaratorList StructDeclaratorList_12_Var
		 = (StructDeclaratorList)StructDeclaration_9_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_12_Var
		);
		final EList<? extends EObject> StructDeclarator_12_list = StructDeclaratorList_12_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_12_list);
		Assert.assertEquals(1, StructDeclarator_12_list.size());
		//12
		final StructDeclarator StructDeclarator_13_Var
		 = (StructDeclarator)StructDeclarator_12_list.get(0);
		Assert.assertNotNull(StructDeclarator_13_Var
		);
		//13
		final Declarator Declarator_14_Var
		 = (Declarator)StructDeclarator_13_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_14_Var
		);
		//14
		final DirectDeclarator DirectDeclarator_15_Var
		 = (DirectDeclarator)Declarator_14_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_15_Var
		);
		Assert.assertEquals("id", DirectDeclarator_15_Var
		.getId());
		//15
		final StructDeclaration StructDeclaration_16_Var
		 = (StructDeclaration)StructDeclaration_8_list.get(1);
		Assert.assertNotNull(StructDeclaration_16_Var
		);
		//16
		final SpecifierQualifierList SpecifierQualifierList_17_Var
		 = (SpecifierQualifierList)StructDeclaration_16_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_17_Var
		);
		final EList<? extends EObject> TypeSpecifier_17_list = SpecifierQualifierList_17_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_17_list);
		Assert.assertEquals(1, TypeSpecifier_17_list.size());
		//17
		final TypeSpecifier TypeSpecifier_18_Var
		 = (TypeSpecifier)TypeSpecifier_17_list.get(0);
		Assert.assertNotNull(TypeSpecifier_18_Var
		);
		Assert.assertEquals("char", TypeSpecifier_18_Var
		.getName());
		//18
		final StructDeclaratorList StructDeclaratorList_19_Var
		 = (StructDeclaratorList)StructDeclaration_16_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_19_Var
		);
		final EList<? extends EObject> StructDeclarator_19_list = StructDeclaratorList_19_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_19_list);
		Assert.assertEquals(1, StructDeclarator_19_list.size());
		//19
		final StructDeclarator StructDeclarator_20_Var
		 = (StructDeclarator)StructDeclarator_19_list.get(0);
		Assert.assertNotNull(StructDeclarator_20_Var
		);
		//20
		final Declarator Declarator_21_Var
		 = (Declarator)StructDeclarator_20_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_21_Var
		);
		//21
		final DirectDeclarator DirectDeclarator_22_Var
		 = (DirectDeclarator)Declarator_21_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_22_Var
		);
		Assert.assertEquals("name", DirectDeclarator_22_Var
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
		final AssignmentExpression AssignmentExpression_24_Var
		 = (AssignmentExpression)DeclaratorSuffix_23_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_24_Var
		);
		//24
		final ConditionalExpression ConditionalExpression_25_Var
		 = (ConditionalExpression)AssignmentExpression_24_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_25_Var
		);
		//25
		final LogicalOrExpression LogicalOrExpression_26_Var
		 = (LogicalOrExpression)ConditionalExpression_25_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = LogicalOrExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final LogicalAndExpression LogicalAndExpression_27_Var
		 = (LogicalAndExpression)Expr_26_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = LogicalAndExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final InclusiveOrExpression InclusiveOrExpression_28_Var
		 = (InclusiveOrExpression)Expr_27_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = InclusiveOrExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final ExclusiveOrExpression ExclusiveOrExpression_29_Var
		 = (ExclusiveOrExpression)Expr_28_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = ExclusiveOrExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final AndExpression AndExpression_30_Var
		 = (AndExpression)Expr_29_list.get(0);
		Assert.assertNotNull(AndExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = AndExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final EqualityExpression EqualityExpression_31_Var
		 = (EqualityExpression)Expr_30_list.get(0);
		Assert.assertNotNull(EqualityExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = EqualityExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final RelationalExpression RelationalExpression_32_Var
		 = (RelationalExpression)Expr_31_list.get(0);
		Assert.assertNotNull(RelationalExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = RelationalExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final ShiftExpression ShiftExpression_33_Var
		 = (ShiftExpression)Expr_32_list.get(0);
		Assert.assertNotNull(ShiftExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = ShiftExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final AdditiveExpression AdditiveExpression_34_Var
		 = (AdditiveExpression)Expr_33_list.get(0);
		Assert.assertNotNull(AdditiveExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = AdditiveExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final MultiplicativeExpression MultiplicativeExpression_35_Var
		 = (MultiplicativeExpression)Expr_34_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = MultiplicativeExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final CastExpression CastExpression_36_Var
		 = (CastExpression)Expr_35_list.get(0);
		Assert.assertNotNull(CastExpression_36_Var
		);
		//36
		final UnaryExpression UnaryExpression_37_Var
		 = (UnaryExpression)CastExpression_36_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_37_Var
		);
		//37
		final PostfixExpression PostfixExpression_38_Var
		 = (PostfixExpression)UnaryExpression_37_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = PostfixExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final PrimaryExpression PrimaryExpression_39_Var
		 = (PrimaryExpression)Expr_38_list.get(0);
		Assert.assertNotNull(PrimaryExpression_39_Var
		);
		//39
		final Constant2 Constant2_40_Var
		 = (Constant2)PrimaryExpression_39_Var
		.getConst();
		Assert.assertNotNull(Constant2_40_Var
		);
		Assert.assertEquals("250", Constant2_40_Var
		.getDec());
		final EList<? extends EObject> InitDeclaratorList_40_list = Declaration_4_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_40_list);
		Assert.assertEquals(1, InitDeclaratorList_40_list.size());
		//40
		final InitDeclaratorList InitDeclaratorList_41_Var
		 = (InitDeclaratorList)InitDeclaratorList_40_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_41_Var
		);
		final EList<? extends EObject> InitDeclarator_41_list = InitDeclaratorList_41_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_41_list);
		Assert.assertEquals(1, InitDeclarator_41_list.size());
		//41
		final InitDeclarator InitDeclarator_42_Var
		 = (InitDeclarator)InitDeclarator_41_list.get(0);
		Assert.assertNotNull(InitDeclarator_42_Var
		);
		//42
		final Declarator Declarator_43_Var
		 = (Declarator)InitDeclarator_42_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_43_Var
		);
		//43
		final DirectDeclarator DirectDeclarator_44_Var
		 = (DirectDeclarator)Declarator_43_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_44_Var
		);
		Assert.assertEquals("phil", DirectDeclarator_44_Var
		.getId());
		//44
		final ExternalDeclaration ExternalDeclaration_45_Var
		 = (ExternalDeclaration)External_2_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_45_Var
		);
		//45
		final Declaration Declaration_46_Var
		 = (Declaration)ExternalDeclaration_45_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_46_Var
		);
		//46
		final DeclarationSpecifiers DeclarationSpecifiers_47_Var
		 = (DeclarationSpecifiers)Declaration_46_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_47_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_47_list = DeclarationSpecifiers_47_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_47_list);
		Assert.assertEquals(1, DeclarationSpecifier_47_list.size());
		//47
		final StructOrUnionSpecifier StructOrUnionSpecifier_48_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_47_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_48_Var
		);
		//48
		final StructOrUnion StructOrUnion_49_Var
		 = (StructOrUnion)StructOrUnionSpecifier_48_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_49_Var
		);
		Assert.assertEquals("struct", StructOrUnion_49_Var
		.getName());
		Assert.assertEquals("employee", StructOrUnionSpecifier_48_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_49_list = Declaration_46_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_49_list);
		Assert.assertEquals(1, InitDeclaratorList_49_list.size());
		//49
		final InitDeclaratorList InitDeclaratorList_50_Var
		 = (InitDeclaratorList)InitDeclaratorList_49_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_50_Var
		);
		final EList<? extends EObject> InitDeclarator_50_list = InitDeclaratorList_50_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_50_list);
		Assert.assertEquals(1, InitDeclarator_50_list.size());
		//50
		final InitDeclarator InitDeclarator_51_Var
		 = (InitDeclarator)InitDeclarator_50_list.get(0);
		Assert.assertNotNull(InitDeclarator_51_Var
		);
		//51
		final Declarator Declarator_52_Var
		 = (Declarator)InitDeclarator_51_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_52_Var
		);
		//52
		final DirectDeclarator DirectDeclarator_53_Var
		 = (DirectDeclarator)Declarator_52_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_53_Var
		);
		Assert.assertEquals("joe", DirectDeclarator_53_Var
		.getId());
		//53
		final Initializer Initializer_54_Var
		 = (Initializer)InitDeclarator_51_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_54_Var
		);
		//54
		final InitializerList InitializerList_55_Var
		 = (InitializerList)Initializer_54_Var
		.getList();
		Assert.assertNotNull(InitializerList_55_Var
		);
		final EList<? extends EObject> Initializer_55_list = InitializerList_55_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_55_list);
		Assert.assertEquals(2, Initializer_55_list.size());
		//55
		final Initializer Initializer_56_Var
		 = (Initializer)Initializer_55_list.get(0);
		Assert.assertNotNull(Initializer_56_Var
		);
		//56
		final AssignmentExpression AssignmentExpression_57_Var
		 = (AssignmentExpression)Initializer_56_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_57_Var
		);
		//57
		final ConditionalExpression ConditionalExpression_58_Var
		 = (ConditionalExpression)AssignmentExpression_57_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_58_Var
		);
		//58
		final LogicalOrExpression LogicalOrExpression_59_Var
		 = (LogicalOrExpression)ConditionalExpression_58_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = LogicalOrExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final LogicalAndExpression LogicalAndExpression_60_Var
		 = (LogicalAndExpression)Expr_59_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = LogicalAndExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final InclusiveOrExpression InclusiveOrExpression_61_Var
		 = (InclusiveOrExpression)Expr_60_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = InclusiveOrExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final ExclusiveOrExpression ExclusiveOrExpression_62_Var
		 = (ExclusiveOrExpression)Expr_61_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = ExclusiveOrExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final AndExpression AndExpression_63_Var
		 = (AndExpression)Expr_62_list.get(0);
		Assert.assertNotNull(AndExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = AndExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final EqualityExpression EqualityExpression_64_Var
		 = (EqualityExpression)Expr_63_list.get(0);
		Assert.assertNotNull(EqualityExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = EqualityExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final RelationalExpression RelationalExpression_65_Var
		 = (RelationalExpression)Expr_64_list.get(0);
		Assert.assertNotNull(RelationalExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = RelationalExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final ShiftExpression ShiftExpression_66_Var
		 = (ShiftExpression)Expr_65_list.get(0);
		Assert.assertNotNull(ShiftExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = ShiftExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final AdditiveExpression AdditiveExpression_67_Var
		 = (AdditiveExpression)Expr_66_list.get(0);
		Assert.assertNotNull(AdditiveExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = AdditiveExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final MultiplicativeExpression MultiplicativeExpression_68_Var
		 = (MultiplicativeExpression)Expr_67_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = MultiplicativeExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final CastExpression CastExpression_69_Var
		 = (CastExpression)Expr_68_list.get(0);
		Assert.assertNotNull(CastExpression_69_Var
		);
		//69
		final UnaryExpression UnaryExpression_70_Var
		 = (UnaryExpression)CastExpression_69_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_70_Var
		);
		//70
		final PostfixExpression PostfixExpression_71_Var
		 = (PostfixExpression)UnaryExpression_70_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = PostfixExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final PrimaryExpression PrimaryExpression_72_Var
		 = (PrimaryExpression)Expr_71_list.get(0);
		Assert.assertNotNull(PrimaryExpression_72_Var
		);
		//72
		final Constant2 Constant2_73_Var
		 = (Constant2)PrimaryExpression_72_Var
		.getConst();
		Assert.assertNotNull(Constant2_73_Var
		);
		Assert.assertEquals("0x007", Constant2_73_Var
		.getHex());
		//73
		final Initializer Initializer_74_Var
		 = (Initializer)Initializer_55_list.get(1);
		Assert.assertNotNull(Initializer_74_Var
		);
		//74
		final AssignmentExpression AssignmentExpression_75_Var
		 = (AssignmentExpression)Initializer_74_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_75_Var
		);
		//75
		final ConditionalExpression ConditionalExpression_76_Var
		 = (ConditionalExpression)AssignmentExpression_75_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_76_Var
		);
		//76
		final LogicalOrExpression LogicalOrExpression_77_Var
		 = (LogicalOrExpression)ConditionalExpression_76_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = LogicalOrExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final LogicalAndExpression LogicalAndExpression_78_Var
		 = (LogicalAndExpression)Expr_77_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = LogicalAndExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final InclusiveOrExpression InclusiveOrExpression_79_Var
		 = (InclusiveOrExpression)Expr_78_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = InclusiveOrExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final ExclusiveOrExpression ExclusiveOrExpression_80_Var
		 = (ExclusiveOrExpression)Expr_79_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = ExclusiveOrExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final AndExpression AndExpression_81_Var
		 = (AndExpression)Expr_80_list.get(0);
		Assert.assertNotNull(AndExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = AndExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final EqualityExpression EqualityExpression_82_Var
		 = (EqualityExpression)Expr_81_list.get(0);
		Assert.assertNotNull(EqualityExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = EqualityExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final RelationalExpression RelationalExpression_83_Var
		 = (RelationalExpression)Expr_82_list.get(0);
		Assert.assertNotNull(RelationalExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = RelationalExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final ShiftExpression ShiftExpression_84_Var
		 = (ShiftExpression)Expr_83_list.get(0);
		Assert.assertNotNull(ShiftExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = ShiftExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final AdditiveExpression AdditiveExpression_85_Var
		 = (AdditiveExpression)Expr_84_list.get(0);
		Assert.assertNotNull(AdditiveExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = AdditiveExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final MultiplicativeExpression MultiplicativeExpression_86_Var
		 = (MultiplicativeExpression)Expr_85_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = MultiplicativeExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final CastExpression CastExpression_87_Var
		 = (CastExpression)Expr_86_list.get(0);
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
		Assert.assertEquals("\"Joe Nobody\"", Constant2_91_Var
		.getStr());
		//91
		final ExternalDeclaration ExternalDeclaration_92_Var
		 = (ExternalDeclaration)External_2_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_92_Var
		);
		//92
		final FunctionDefHead FunctionDefHead_93_Var
		 = (FunctionDefHead)ExternalDeclaration_92_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_93_Var
		);
		//93
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_94_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_93_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_94_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_94_list = FunctionDeclarationSpecifiers_94_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_94_list);
		Assert.assertEquals(1, DeclarationSpecifier_94_list.size());
		//94
		final TypeSpecifier TypeSpecifier_95_Var
		 = (TypeSpecifier)DeclarationSpecifier_94_list.get(0);
		Assert.assertNotNull(TypeSpecifier_95_Var
		);
		Assert.assertEquals("int", TypeSpecifier_95_Var
		.getName());
		//95
		final Declarator Declarator_96_Var
		 = (Declarator)FunctionDefHead_93_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_96_Var
		);
		//96
		final DirectDeclarator DirectDeclarator_97_Var
		 = (DirectDeclarator)Declarator_96_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_97_Var
		);
		Assert.assertEquals("main", DirectDeclarator_97_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_97_list = DirectDeclarator_97_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_97_list);
		Assert.assertEquals(1, DeclaratorSuffix_97_list.size());
		//97
		final DeclaratorSuffix DeclaratorSuffix_98_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_97_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_98_Var
		);
		//98
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_99_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_98_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_99_Var
		);
		final EList<? extends EObject> ParameterTypeList_99_list = DirectDeclaratorLastSuffix_99_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_99_list);
		Assert.assertEquals(1, ParameterTypeList_99_list.size());
		//99
		final ParameterTypeList ParameterTypeList_100_Var
		 = (ParameterTypeList)ParameterTypeList_99_list.get(0);
		Assert.assertNotNull(ParameterTypeList_100_Var
		);
		//100
		final ParameterList ParameterList_101_Var
		 = (ParameterList)ParameterTypeList_100_Var
		.getList();
		Assert.assertNotNull(ParameterList_101_Var
		);
		final EList<? extends EObject> ParameterDeclaration_101_list = ParameterList_101_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_101_list);
		Assert.assertEquals(1, ParameterDeclaration_101_list.size());
		//101
		final ParameterDeclaration ParameterDeclaration_102_Var
		 = (ParameterDeclaration)ParameterDeclaration_101_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_102_Var
		);
		//102
		final DeclarationSpecifiers DeclarationSpecifiers_103_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_102_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_103_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_103_list = DeclarationSpecifiers_103_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_103_list);
		Assert.assertEquals(1, DeclarationSpecifier_103_list.size());
		//103
		final TypeSpecifier TypeSpecifier_104_Var
		 = (TypeSpecifier)DeclarationSpecifier_103_list.get(0);
		Assert.assertNotNull(TypeSpecifier_104_Var
		);
		Assert.assertEquals("void", TypeSpecifier_104_Var
		.getName());
		//104
		final FunctionDefinition FunctionDefinition_105_Var
		 = (FunctionDefinition)ExternalDeclaration_92_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_105_Var
		);
		//105
		final BodyStatement BodyStatement_106_Var
		 = (BodyStatement)FunctionDefinition_105_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_106_Var
		);
		final EList<? extends EObject> BlockList_106_list = BodyStatement_106_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_106_list);
		Assert.assertEquals(1, BlockList_106_list.size());
		//106
		final BlockList BlockList_107_Var
		 = (BlockList)BlockList_106_list.get(0);
		Assert.assertNotNull(BlockList_107_Var
		);
		final EList<? extends EObject> Statement_107_list = BlockList_107_Var
		.getStatement();
		Assert.assertNotNull(Statement_107_list);
		Assert.assertEquals(10, Statement_107_list.size());
		//107
		final Statement Statement_108_Var
		 = (Statement)Statement_107_list.get(0);
		Assert.assertNotNull(Statement_108_Var
		);
		//108
		final ExpressionStatement ExpressionStatement_109_Var
		 = (ExpressionStatement)Statement_108_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_109_Var
		);
		//109
		final Expression Expression_110_Var
		 = (Expression)ExpressionStatement_109_Var
		.getExpression();
		Assert.assertNotNull(Expression_110_Var
		);
		final EList<? extends EObject> ExprExpr_110_list = Expression_110_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_110_list);
		Assert.assertEquals(1, ExprExpr_110_list.size());
		//110
		final AssignmentExpression AssignmentExpression_111_Var
		 = (AssignmentExpression)ExprExpr_110_list.get(0);
		Assert.assertNotNull(AssignmentExpression_111_Var
		);
		//111
		final ConditionalExpression ConditionalExpression_112_Var
		 = (ConditionalExpression)AssignmentExpression_111_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_112_Var
		);
		//112
		final LogicalOrExpression LogicalOrExpression_113_Var
		 = (LogicalOrExpression)ConditionalExpression_112_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = LogicalOrExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final LogicalAndExpression LogicalAndExpression_114_Var
		 = (LogicalAndExpression)Expr_113_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = LogicalAndExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final InclusiveOrExpression InclusiveOrExpression_115_Var
		 = (InclusiveOrExpression)Expr_114_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = InclusiveOrExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final ExclusiveOrExpression ExclusiveOrExpression_116_Var
		 = (ExclusiveOrExpression)Expr_115_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = ExclusiveOrExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final AndExpression AndExpression_117_Var
		 = (AndExpression)Expr_116_list.get(0);
		Assert.assertNotNull(AndExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = AndExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final EqualityExpression EqualityExpression_118_Var
		 = (EqualityExpression)Expr_117_list.get(0);
		Assert.assertNotNull(EqualityExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = EqualityExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final RelationalExpression RelationalExpression_119_Var
		 = (RelationalExpression)Expr_118_list.get(0);
		Assert.assertNotNull(RelationalExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = RelationalExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final ShiftExpression ShiftExpression_120_Var
		 = (ShiftExpression)Expr_119_list.get(0);
		Assert.assertNotNull(ShiftExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = ShiftExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final AdditiveExpression AdditiveExpression_121_Var
		 = (AdditiveExpression)Expr_120_list.get(0);
		Assert.assertNotNull(AdditiveExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = AdditiveExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final MultiplicativeExpression MultiplicativeExpression_122_Var
		 = (MultiplicativeExpression)Expr_121_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = MultiplicativeExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final CastExpression CastExpression_123_Var
		 = (CastExpression)Expr_122_list.get(0);
		Assert.assertNotNull(CastExpression_123_Var
		);
		//123
		final UnaryExpression UnaryExpression_124_Var
		 = (UnaryExpression)CastExpression_123_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_124_Var
		);
		//124
		final PostfixExpression PostfixExpression_125_Var
		 = (PostfixExpression)UnaryExpression_124_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = PostfixExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final PrimaryExpression PrimaryExpression_126_Var
		 = (PrimaryExpression)Expr_125_list.get(0);
		Assert.assertNotNull(PrimaryExpression_126_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_126_Var
		.getId());
		final EList<? extends EObject> Suffix_126_list = PostfixExpression_125_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_126_list);
		Assert.assertEquals(1, Suffix_126_list.size());
		//126
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_127_Var
		 = (PostfixExpressionSuffixArgument)Suffix_126_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_127_Var
		);
		//127
		final ArgumentExpressionList ArgumentExpressionList_128_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_127_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_128_Var
		);
		final EList<? extends EObject> Expr_128_list = ArgumentExpressionList_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(2, Expr_128_list.size());
		//128
		final AssignmentExpression AssignmentExpression_129_Var
		 = (AssignmentExpression)Expr_128_list.get(0);
		Assert.assertNotNull(AssignmentExpression_129_Var
		);
		//129
		final ConditionalExpression ConditionalExpression_130_Var
		 = (ConditionalExpression)AssignmentExpression_129_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_130_Var
		);
		//130
		final LogicalOrExpression LogicalOrExpression_131_Var
		 = (LogicalOrExpression)ConditionalExpression_130_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = LogicalOrExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final LogicalAndExpression LogicalAndExpression_132_Var
		 = (LogicalAndExpression)Expr_131_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = LogicalAndExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final InclusiveOrExpression InclusiveOrExpression_133_Var
		 = (InclusiveOrExpression)Expr_132_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = InclusiveOrExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final ExclusiveOrExpression ExclusiveOrExpression_134_Var
		 = (ExclusiveOrExpression)Expr_133_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = ExclusiveOrExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final AndExpression AndExpression_135_Var
		 = (AndExpression)Expr_134_list.get(0);
		Assert.assertNotNull(AndExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = AndExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final EqualityExpression EqualityExpression_136_Var
		 = (EqualityExpression)Expr_135_list.get(0);
		Assert.assertNotNull(EqualityExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = EqualityExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final RelationalExpression RelationalExpression_137_Var
		 = (RelationalExpression)Expr_136_list.get(0);
		Assert.assertNotNull(RelationalExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = RelationalExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final ShiftExpression ShiftExpression_138_Var
		 = (ShiftExpression)Expr_137_list.get(0);
		Assert.assertNotNull(ShiftExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = ShiftExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final AdditiveExpression AdditiveExpression_139_Var
		 = (AdditiveExpression)Expr_138_list.get(0);
		Assert.assertNotNull(AdditiveExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = AdditiveExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final MultiplicativeExpression MultiplicativeExpression_140_Var
		 = (MultiplicativeExpression)Expr_139_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = MultiplicativeExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final CastExpression CastExpression_141_Var
		 = (CastExpression)Expr_140_list.get(0);
		Assert.assertNotNull(CastExpression_141_Var
		);
		//141
		final UnaryExpression UnaryExpression_142_Var
		 = (UnaryExpression)CastExpression_141_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_142_Var
		);
		//142
		final PostfixExpression PostfixExpression_143_Var
		 = (PostfixExpression)UnaryExpression_142_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = PostfixExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final PrimaryExpression PrimaryExpression_144_Var
		 = (PrimaryExpression)Expr_143_list.get(0);
		Assert.assertNotNull(PrimaryExpression_144_Var
		);
		//144
		final Constant2 Constant2_145_Var
		 = (Constant2)PrimaryExpression_144_Var
		.getConst();
		Assert.assertNotNull(Constant2_145_Var
		);
		Assert.assertEquals("\"sizeof(joe.id)=%lu\\n\"", Constant2_145_Var
		.getStr());
		//145
		final AssignmentExpression AssignmentExpression_146_Var
		 = (AssignmentExpression)Expr_128_list.get(1);
		Assert.assertNotNull(AssignmentExpression_146_Var
		);
		//146
		final ConditionalExpression ConditionalExpression_147_Var
		 = (ConditionalExpression)AssignmentExpression_146_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_147_Var
		);
		//147
		final LogicalOrExpression LogicalOrExpression_148_Var
		 = (LogicalOrExpression)ConditionalExpression_147_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_148_Var
		);
		final EList<? extends EObject> Expr_148_list = LogicalOrExpression_148_Var
		.getExpr();
		Assert.assertNotNull(Expr_148_list);
		Assert.assertEquals(1, Expr_148_list.size());
		//148
		final LogicalAndExpression LogicalAndExpression_149_Var
		 = (LogicalAndExpression)Expr_148_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_149_Var
		);
		final EList<? extends EObject> Expr_149_list = LogicalAndExpression_149_Var
		.getExpr();
		Assert.assertNotNull(Expr_149_list);
		Assert.assertEquals(1, Expr_149_list.size());
		//149
		final InclusiveOrExpression InclusiveOrExpression_150_Var
		 = (InclusiveOrExpression)Expr_149_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_150_Var
		);
		final EList<? extends EObject> Expr_150_list = InclusiveOrExpression_150_Var
		.getExpr();
		Assert.assertNotNull(Expr_150_list);
		Assert.assertEquals(1, Expr_150_list.size());
		//150
		final ExclusiveOrExpression ExclusiveOrExpression_151_Var
		 = (ExclusiveOrExpression)Expr_150_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_151_Var
		);
		final EList<? extends EObject> Expr_151_list = ExclusiveOrExpression_151_Var
		.getExpr();
		Assert.assertNotNull(Expr_151_list);
		Assert.assertEquals(1, Expr_151_list.size());
		//151
		final AndExpression AndExpression_152_Var
		 = (AndExpression)Expr_151_list.get(0);
		Assert.assertNotNull(AndExpression_152_Var
		);
		final EList<? extends EObject> Expr_152_list = AndExpression_152_Var
		.getExpr();
		Assert.assertNotNull(Expr_152_list);
		Assert.assertEquals(1, Expr_152_list.size());
		//152
		final EqualityExpression EqualityExpression_153_Var
		 = (EqualityExpression)Expr_152_list.get(0);
		Assert.assertNotNull(EqualityExpression_153_Var
		);
		final EList<? extends EObject> Expr_153_list = EqualityExpression_153_Var
		.getExpr();
		Assert.assertNotNull(Expr_153_list);
		Assert.assertEquals(1, Expr_153_list.size());
		//153
		final RelationalExpression RelationalExpression_154_Var
		 = (RelationalExpression)Expr_153_list.get(0);
		Assert.assertNotNull(RelationalExpression_154_Var
		);
		final EList<? extends EObject> Expr_154_list = RelationalExpression_154_Var
		.getExpr();
		Assert.assertNotNull(Expr_154_list);
		Assert.assertEquals(1, Expr_154_list.size());
		//154
		final ShiftExpression ShiftExpression_155_Var
		 = (ShiftExpression)Expr_154_list.get(0);
		Assert.assertNotNull(ShiftExpression_155_Var
		);
		final EList<? extends EObject> Expr_155_list = ShiftExpression_155_Var
		.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		//155
		final AdditiveExpression AdditiveExpression_156_Var
		 = (AdditiveExpression)Expr_155_list.get(0);
		Assert.assertNotNull(AdditiveExpression_156_Var
		);
		final EList<? extends EObject> Expr_156_list = AdditiveExpression_156_Var
		.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		//156
		final MultiplicativeExpression MultiplicativeExpression_157_Var
		 = (MultiplicativeExpression)Expr_156_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = MultiplicativeExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final CastExpression CastExpression_158_Var
		 = (CastExpression)Expr_157_list.get(0);
		Assert.assertNotNull(CastExpression_158_Var
		);
		//158
		final UnaryExpression UnaryExpression_159_Var
		 = (UnaryExpression)CastExpression_158_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_159_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_159_Var
		.getSizeOf());
		//159
		final UnaryExpression UnaryExpression_160_Var
		 = (UnaryExpression)UnaryExpression_159_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_160_Var
		);
		//160
		final PostfixExpression PostfixExpression_161_Var
		 = (PostfixExpression)UnaryExpression_160_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = PostfixExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final PrimaryExpression PrimaryExpression_162_Var
		 = (PrimaryExpression)Expr_161_list.get(0);
		Assert.assertNotNull(PrimaryExpression_162_Var
		);
		//162
		final Expression Expression_163_Var
		 = (Expression)PrimaryExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expression_163_Var
		);
		final EList<? extends EObject> ExprExpr_163_list = Expression_163_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_163_list);
		Assert.assertEquals(1, ExprExpr_163_list.size());
		//163
		final AssignmentExpression AssignmentExpression_164_Var
		 = (AssignmentExpression)ExprExpr_163_list.get(0);
		Assert.assertNotNull(AssignmentExpression_164_Var
		);
		//164
		final ConditionalExpression ConditionalExpression_165_Var
		 = (ConditionalExpression)AssignmentExpression_164_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_165_Var
		);
		//165
		final LogicalOrExpression LogicalOrExpression_166_Var
		 = (LogicalOrExpression)ConditionalExpression_165_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_166_Var
		);
		final EList<? extends EObject> Expr_166_list = LogicalOrExpression_166_Var
		.getExpr();
		Assert.assertNotNull(Expr_166_list);
		Assert.assertEquals(1, Expr_166_list.size());
		//166
		final LogicalAndExpression LogicalAndExpression_167_Var
		 = (LogicalAndExpression)Expr_166_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_167_Var
		);
		final EList<? extends EObject> Expr_167_list = LogicalAndExpression_167_Var
		.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(1, Expr_167_list.size());
		//167
		final InclusiveOrExpression InclusiveOrExpression_168_Var
		 = (InclusiveOrExpression)Expr_167_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_168_Var
		);
		final EList<? extends EObject> Expr_168_list = InclusiveOrExpression_168_Var
		.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(1, Expr_168_list.size());
		//168
		final ExclusiveOrExpression ExclusiveOrExpression_169_Var
		 = (ExclusiveOrExpression)Expr_168_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_169_Var
		);
		final EList<? extends EObject> Expr_169_list = ExclusiveOrExpression_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		//169
		final AndExpression AndExpression_170_Var
		 = (AndExpression)Expr_169_list.get(0);
		Assert.assertNotNull(AndExpression_170_Var
		);
		final EList<? extends EObject> Expr_170_list = AndExpression_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		//170
		final EqualityExpression EqualityExpression_171_Var
		 = (EqualityExpression)Expr_170_list.get(0);
		Assert.assertNotNull(EqualityExpression_171_Var
		);
		final EList<? extends EObject> Expr_171_list = EqualityExpression_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		//171
		final RelationalExpression RelationalExpression_172_Var
		 = (RelationalExpression)Expr_171_list.get(0);
		Assert.assertNotNull(RelationalExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = RelationalExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final ShiftExpression ShiftExpression_173_Var
		 = (ShiftExpression)Expr_172_list.get(0);
		Assert.assertNotNull(ShiftExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = ShiftExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final AdditiveExpression AdditiveExpression_174_Var
		 = (AdditiveExpression)Expr_173_list.get(0);
		Assert.assertNotNull(AdditiveExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = AdditiveExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final MultiplicativeExpression MultiplicativeExpression_175_Var
		 = (MultiplicativeExpression)Expr_174_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = MultiplicativeExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final CastExpression CastExpression_176_Var
		 = (CastExpression)Expr_175_list.get(0);
		Assert.assertNotNull(CastExpression_176_Var
		);
		//176
		final UnaryExpression UnaryExpression_177_Var
		 = (UnaryExpression)CastExpression_176_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_177_Var
		);
		//177
		final PostfixExpression PostfixExpression_178_Var
		 = (PostfixExpression)UnaryExpression_177_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = PostfixExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final PrimaryExpression PrimaryExpression_179_Var
		 = (PrimaryExpression)Expr_178_list.get(0);
		Assert.assertNotNull(PrimaryExpression_179_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_179_Var
		.getId());
		final EList<? extends EObject> Suffix_179_list = PostfixExpression_178_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_179_list);
		Assert.assertEquals(1, Suffix_179_list.size());
		//179
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_180_Var
		 = (PostfixExpressionSuffixDot)Suffix_179_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_180_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_180_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_109_Var
		.getSemi());
		//180
		final Statement Statement_181_Var
		 = (Statement)Statement_107_list.get(1);
		Assert.assertNotNull(Statement_181_Var
		);
		//181
		final ExpressionStatement ExpressionStatement_182_Var
		 = (ExpressionStatement)Statement_181_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_182_Var
		);
		//182
		final Expression Expression_183_Var
		 = (Expression)ExpressionStatement_182_Var
		.getExpression();
		Assert.assertNotNull(Expression_183_Var
		);
		final EList<? extends EObject> ExprExpr_183_list = Expression_183_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_183_list);
		Assert.assertEquals(1, ExprExpr_183_list.size());
		//183
		final AssignmentExpression AssignmentExpression_184_Var
		 = (AssignmentExpression)ExprExpr_183_list.get(0);
		Assert.assertNotNull(AssignmentExpression_184_Var
		);
		//184
		final ConditionalExpression ConditionalExpression_185_Var
		 = (ConditionalExpression)AssignmentExpression_184_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_185_Var
		);
		//185
		final LogicalOrExpression LogicalOrExpression_186_Var
		 = (LogicalOrExpression)ConditionalExpression_185_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_186_Var
		);
		final EList<? extends EObject> Expr_186_list = LogicalOrExpression_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(1, Expr_186_list.size());
		//186
		final LogicalAndExpression LogicalAndExpression_187_Var
		 = (LogicalAndExpression)Expr_186_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_187_Var
		);
		final EList<? extends EObject> Expr_187_list = LogicalAndExpression_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(1, Expr_187_list.size());
		//187
		final InclusiveOrExpression InclusiveOrExpression_188_Var
		 = (InclusiveOrExpression)Expr_187_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = InclusiveOrExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final ExclusiveOrExpression ExclusiveOrExpression_189_Var
		 = (ExclusiveOrExpression)Expr_188_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = ExclusiveOrExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final AndExpression AndExpression_190_Var
		 = (AndExpression)Expr_189_list.get(0);
		Assert.assertNotNull(AndExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = AndExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final EqualityExpression EqualityExpression_191_Var
		 = (EqualityExpression)Expr_190_list.get(0);
		Assert.assertNotNull(EqualityExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = EqualityExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final RelationalExpression RelationalExpression_192_Var
		 = (RelationalExpression)Expr_191_list.get(0);
		Assert.assertNotNull(RelationalExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = RelationalExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final ShiftExpression ShiftExpression_193_Var
		 = (ShiftExpression)Expr_192_list.get(0);
		Assert.assertNotNull(ShiftExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = ShiftExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final AdditiveExpression AdditiveExpression_194_Var
		 = (AdditiveExpression)Expr_193_list.get(0);
		Assert.assertNotNull(AdditiveExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = AdditiveExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final MultiplicativeExpression MultiplicativeExpression_195_Var
		 = (MultiplicativeExpression)Expr_194_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = MultiplicativeExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final CastExpression CastExpression_196_Var
		 = (CastExpression)Expr_195_list.get(0);
		Assert.assertNotNull(CastExpression_196_Var
		);
		//196
		final UnaryExpression UnaryExpression_197_Var
		 = (UnaryExpression)CastExpression_196_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_197_Var
		);
		//197
		final PostfixExpression PostfixExpression_198_Var
		 = (PostfixExpression)UnaryExpression_197_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = PostfixExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final PrimaryExpression PrimaryExpression_199_Var
		 = (PrimaryExpression)Expr_198_list.get(0);
		Assert.assertNotNull(PrimaryExpression_199_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_199_Var
		.getId());
		final EList<? extends EObject> Suffix_199_list = PostfixExpression_198_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_199_list);
		Assert.assertEquals(1, Suffix_199_list.size());
		//199
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_200_Var
		 = (PostfixExpressionSuffixArgument)Suffix_199_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_200_Var
		);
		//200
		final ArgumentExpressionList ArgumentExpressionList_201_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_200_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_201_Var
		);
		final EList<? extends EObject> Expr_201_list = ArgumentExpressionList_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(2, Expr_201_list.size());
		//201
		final AssignmentExpression AssignmentExpression_202_Var
		 = (AssignmentExpression)Expr_201_list.get(0);
		Assert.assertNotNull(AssignmentExpression_202_Var
		);
		//202
		final ConditionalExpression ConditionalExpression_203_Var
		 = (ConditionalExpression)AssignmentExpression_202_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_203_Var
		);
		//203
		final LogicalOrExpression LogicalOrExpression_204_Var
		 = (LogicalOrExpression)ConditionalExpression_203_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = LogicalOrExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final LogicalAndExpression LogicalAndExpression_205_Var
		 = (LogicalAndExpression)Expr_204_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = LogicalAndExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final InclusiveOrExpression InclusiveOrExpression_206_Var
		 = (InclusiveOrExpression)Expr_205_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = InclusiveOrExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final ExclusiveOrExpression ExclusiveOrExpression_207_Var
		 = (ExclusiveOrExpression)Expr_206_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = ExclusiveOrExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final AndExpression AndExpression_208_Var
		 = (AndExpression)Expr_207_list.get(0);
		Assert.assertNotNull(AndExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = AndExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final EqualityExpression EqualityExpression_209_Var
		 = (EqualityExpression)Expr_208_list.get(0);
		Assert.assertNotNull(EqualityExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = EqualityExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final RelationalExpression RelationalExpression_210_Var
		 = (RelationalExpression)Expr_209_list.get(0);
		Assert.assertNotNull(RelationalExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = RelationalExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final ShiftExpression ShiftExpression_211_Var
		 = (ShiftExpression)Expr_210_list.get(0);
		Assert.assertNotNull(ShiftExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = ShiftExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final AdditiveExpression AdditiveExpression_212_Var
		 = (AdditiveExpression)Expr_211_list.get(0);
		Assert.assertNotNull(AdditiveExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = AdditiveExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final MultiplicativeExpression MultiplicativeExpression_213_Var
		 = (MultiplicativeExpression)Expr_212_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = MultiplicativeExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final CastExpression CastExpression_214_Var
		 = (CastExpression)Expr_213_list.get(0);
		Assert.assertNotNull(CastExpression_214_Var
		);
		//214
		final UnaryExpression UnaryExpression_215_Var
		 = (UnaryExpression)CastExpression_214_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_215_Var
		);
		//215
		final PostfixExpression PostfixExpression_216_Var
		 = (PostfixExpression)UnaryExpression_215_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = PostfixExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final PrimaryExpression PrimaryExpression_217_Var
		 = (PrimaryExpression)Expr_216_list.get(0);
		Assert.assertNotNull(PrimaryExpression_217_Var
		);
		//217
		final Constant2 Constant2_218_Var
		 = (Constant2)PrimaryExpression_217_Var
		.getConst();
		Assert.assertNotNull(Constant2_218_Var
		);
		Assert.assertEquals("\"sizeof(joe.name)=%lu\\n\"", Constant2_218_Var
		.getStr());
		//218
		final AssignmentExpression AssignmentExpression_219_Var
		 = (AssignmentExpression)Expr_201_list.get(1);
		Assert.assertNotNull(AssignmentExpression_219_Var
		);
		//219
		final ConditionalExpression ConditionalExpression_220_Var
		 = (ConditionalExpression)AssignmentExpression_219_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_220_Var
		);
		//220
		final LogicalOrExpression LogicalOrExpression_221_Var
		 = (LogicalOrExpression)ConditionalExpression_220_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = LogicalOrExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final LogicalAndExpression LogicalAndExpression_222_Var
		 = (LogicalAndExpression)Expr_221_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = LogicalAndExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final InclusiveOrExpression InclusiveOrExpression_223_Var
		 = (InclusiveOrExpression)Expr_222_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = InclusiveOrExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final ExclusiveOrExpression ExclusiveOrExpression_224_Var
		 = (ExclusiveOrExpression)Expr_223_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = ExclusiveOrExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final AndExpression AndExpression_225_Var
		 = (AndExpression)Expr_224_list.get(0);
		Assert.assertNotNull(AndExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = AndExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final EqualityExpression EqualityExpression_226_Var
		 = (EqualityExpression)Expr_225_list.get(0);
		Assert.assertNotNull(EqualityExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = EqualityExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final RelationalExpression RelationalExpression_227_Var
		 = (RelationalExpression)Expr_226_list.get(0);
		Assert.assertNotNull(RelationalExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = RelationalExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final ShiftExpression ShiftExpression_228_Var
		 = (ShiftExpression)Expr_227_list.get(0);
		Assert.assertNotNull(ShiftExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = ShiftExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final AdditiveExpression AdditiveExpression_229_Var
		 = (AdditiveExpression)Expr_228_list.get(0);
		Assert.assertNotNull(AdditiveExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = AdditiveExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final MultiplicativeExpression MultiplicativeExpression_230_Var
		 = (MultiplicativeExpression)Expr_229_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = MultiplicativeExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final CastExpression CastExpression_231_Var
		 = (CastExpression)Expr_230_list.get(0);
		Assert.assertNotNull(CastExpression_231_Var
		);
		//231
		final UnaryExpression UnaryExpression_232_Var
		 = (UnaryExpression)CastExpression_231_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_232_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_232_Var
		.getSizeOf());
		//232
		final UnaryExpression UnaryExpression_233_Var
		 = (UnaryExpression)UnaryExpression_232_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_233_Var
		);
		//233
		final PostfixExpression PostfixExpression_234_Var
		 = (PostfixExpression)UnaryExpression_233_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = PostfixExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final PrimaryExpression PrimaryExpression_235_Var
		 = (PrimaryExpression)Expr_234_list.get(0);
		Assert.assertNotNull(PrimaryExpression_235_Var
		);
		//235
		final Expression Expression_236_Var
		 = (Expression)PrimaryExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expression_236_Var
		);
		final EList<? extends EObject> ExprExpr_236_list = Expression_236_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_236_list);
		Assert.assertEquals(1, ExprExpr_236_list.size());
		//236
		final AssignmentExpression AssignmentExpression_237_Var
		 = (AssignmentExpression)ExprExpr_236_list.get(0);
		Assert.assertNotNull(AssignmentExpression_237_Var
		);
		//237
		final ConditionalExpression ConditionalExpression_238_Var
		 = (ConditionalExpression)AssignmentExpression_237_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_238_Var
		);
		//238
		final LogicalOrExpression LogicalOrExpression_239_Var
		 = (LogicalOrExpression)ConditionalExpression_238_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = LogicalOrExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final LogicalAndExpression LogicalAndExpression_240_Var
		 = (LogicalAndExpression)Expr_239_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = LogicalAndExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final InclusiveOrExpression InclusiveOrExpression_241_Var
		 = (InclusiveOrExpression)Expr_240_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = InclusiveOrExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final ExclusiveOrExpression ExclusiveOrExpression_242_Var
		 = (ExclusiveOrExpression)Expr_241_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = ExclusiveOrExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final AndExpression AndExpression_243_Var
		 = (AndExpression)Expr_242_list.get(0);
		Assert.assertNotNull(AndExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = AndExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final EqualityExpression EqualityExpression_244_Var
		 = (EqualityExpression)Expr_243_list.get(0);
		Assert.assertNotNull(EqualityExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = EqualityExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final RelationalExpression RelationalExpression_245_Var
		 = (RelationalExpression)Expr_244_list.get(0);
		Assert.assertNotNull(RelationalExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = RelationalExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final ShiftExpression ShiftExpression_246_Var
		 = (ShiftExpression)Expr_245_list.get(0);
		Assert.assertNotNull(ShiftExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = ShiftExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final AdditiveExpression AdditiveExpression_247_Var
		 = (AdditiveExpression)Expr_246_list.get(0);
		Assert.assertNotNull(AdditiveExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = AdditiveExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final MultiplicativeExpression MultiplicativeExpression_248_Var
		 = (MultiplicativeExpression)Expr_247_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = MultiplicativeExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final CastExpression CastExpression_249_Var
		 = (CastExpression)Expr_248_list.get(0);
		Assert.assertNotNull(CastExpression_249_Var
		);
		//249
		final UnaryExpression UnaryExpression_250_Var
		 = (UnaryExpression)CastExpression_249_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_250_Var
		);
		//250
		final PostfixExpression PostfixExpression_251_Var
		 = (PostfixExpression)UnaryExpression_250_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = PostfixExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final PrimaryExpression PrimaryExpression_252_Var
		 = (PrimaryExpression)Expr_251_list.get(0);
		Assert.assertNotNull(PrimaryExpression_252_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_252_Var
		.getId());
		final EList<? extends EObject> Suffix_252_list = PostfixExpression_251_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_252_list);
		Assert.assertEquals(1, Suffix_252_list.size());
		//252
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_253_Var
		 = (PostfixExpressionSuffixDot)Suffix_252_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_253_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_253_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_182_Var
		.getSemi());
		//253
		final Statement Statement_254_Var
		 = (Statement)Statement_107_list.get(2);
		Assert.assertNotNull(Statement_254_Var
		);
		//254
		final ExpressionStatement ExpressionStatement_255_Var
		 = (ExpressionStatement)Statement_254_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_255_Var
		);
		//255
		final Expression Expression_256_Var
		 = (Expression)ExpressionStatement_255_Var
		.getExpression();
		Assert.assertNotNull(Expression_256_Var
		);
		final EList<? extends EObject> ExprExpr_256_list = Expression_256_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_256_list);
		Assert.assertEquals(1, ExprExpr_256_list.size());
		//256
		final AssignmentExpression AssignmentExpression_257_Var
		 = (AssignmentExpression)ExprExpr_256_list.get(0);
		Assert.assertNotNull(AssignmentExpression_257_Var
		);
		//257
		final ConditionalExpression ConditionalExpression_258_Var
		 = (ConditionalExpression)AssignmentExpression_257_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_258_Var
		);
		//258
		final LogicalOrExpression LogicalOrExpression_259_Var
		 = (LogicalOrExpression)ConditionalExpression_258_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_259_Var
		);
		final EList<? extends EObject> Expr_259_list = LogicalOrExpression_259_Var
		.getExpr();
		Assert.assertNotNull(Expr_259_list);
		Assert.assertEquals(1, Expr_259_list.size());
		//259
		final LogicalAndExpression LogicalAndExpression_260_Var
		 = (LogicalAndExpression)Expr_259_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = LogicalAndExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final InclusiveOrExpression InclusiveOrExpression_261_Var
		 = (InclusiveOrExpression)Expr_260_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = InclusiveOrExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final ExclusiveOrExpression ExclusiveOrExpression_262_Var
		 = (ExclusiveOrExpression)Expr_261_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_262_Var
		);
		final EList<? extends EObject> Expr_262_list = ExclusiveOrExpression_262_Var
		.getExpr();
		Assert.assertNotNull(Expr_262_list);
		Assert.assertEquals(1, Expr_262_list.size());
		//262
		final AndExpression AndExpression_263_Var
		 = (AndExpression)Expr_262_list.get(0);
		Assert.assertNotNull(AndExpression_263_Var
		);
		final EList<? extends EObject> Expr_263_list = AndExpression_263_Var
		.getExpr();
		Assert.assertNotNull(Expr_263_list);
		Assert.assertEquals(1, Expr_263_list.size());
		//263
		final EqualityExpression EqualityExpression_264_Var
		 = (EqualityExpression)Expr_263_list.get(0);
		Assert.assertNotNull(EqualityExpression_264_Var
		);
		final EList<? extends EObject> Expr_264_list = EqualityExpression_264_Var
		.getExpr();
		Assert.assertNotNull(Expr_264_list);
		Assert.assertEquals(1, Expr_264_list.size());
		//264
		final RelationalExpression RelationalExpression_265_Var
		 = (RelationalExpression)Expr_264_list.get(0);
		Assert.assertNotNull(RelationalExpression_265_Var
		);
		final EList<? extends EObject> Expr_265_list = RelationalExpression_265_Var
		.getExpr();
		Assert.assertNotNull(Expr_265_list);
		Assert.assertEquals(1, Expr_265_list.size());
		//265
		final ShiftExpression ShiftExpression_266_Var
		 = (ShiftExpression)Expr_265_list.get(0);
		Assert.assertNotNull(ShiftExpression_266_Var
		);
		final EList<? extends EObject> Expr_266_list = ShiftExpression_266_Var
		.getExpr();
		Assert.assertNotNull(Expr_266_list);
		Assert.assertEquals(1, Expr_266_list.size());
		//266
		final AdditiveExpression AdditiveExpression_267_Var
		 = (AdditiveExpression)Expr_266_list.get(0);
		Assert.assertNotNull(AdditiveExpression_267_Var
		);
		final EList<? extends EObject> Expr_267_list = AdditiveExpression_267_Var
		.getExpr();
		Assert.assertNotNull(Expr_267_list);
		Assert.assertEquals(1, Expr_267_list.size());
		//267
		final MultiplicativeExpression MultiplicativeExpression_268_Var
		 = (MultiplicativeExpression)Expr_267_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_268_Var
		);
		final EList<? extends EObject> Expr_268_list = MultiplicativeExpression_268_Var
		.getExpr();
		Assert.assertNotNull(Expr_268_list);
		Assert.assertEquals(1, Expr_268_list.size());
		//268
		final CastExpression CastExpression_269_Var
		 = (CastExpression)Expr_268_list.get(0);
		Assert.assertNotNull(CastExpression_269_Var
		);
		//269
		final UnaryExpression UnaryExpression_270_Var
		 = (UnaryExpression)CastExpression_269_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_270_Var
		);
		//270
		final PostfixExpression PostfixExpression_271_Var
		 = (PostfixExpression)UnaryExpression_270_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_271_Var
		);
		final EList<? extends EObject> Expr_271_list = PostfixExpression_271_Var
		.getExpr();
		Assert.assertNotNull(Expr_271_list);
		Assert.assertEquals(1, Expr_271_list.size());
		//271
		final PrimaryExpression PrimaryExpression_272_Var
		 = (PrimaryExpression)Expr_271_list.get(0);
		Assert.assertNotNull(PrimaryExpression_272_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_272_Var
		.getId());
		final EList<? extends EObject> Suffix_272_list = PostfixExpression_271_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_272_list);
		Assert.assertEquals(1, Suffix_272_list.size());
		//272
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_273_Var
		 = (PostfixExpressionSuffixArgument)Suffix_272_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_273_Var
		);
		//273
		final ArgumentExpressionList ArgumentExpressionList_274_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_273_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_274_Var
		);
		final EList<? extends EObject> Expr_274_list = ArgumentExpressionList_274_Var
		.getExpr();
		Assert.assertNotNull(Expr_274_list);
		Assert.assertEquals(2, Expr_274_list.size());
		//274
		final AssignmentExpression AssignmentExpression_275_Var
		 = (AssignmentExpression)Expr_274_list.get(0);
		Assert.assertNotNull(AssignmentExpression_275_Var
		);
		//275
		final ConditionalExpression ConditionalExpression_276_Var
		 = (ConditionalExpression)AssignmentExpression_275_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_276_Var
		);
		//276
		final LogicalOrExpression LogicalOrExpression_277_Var
		 = (LogicalOrExpression)ConditionalExpression_276_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_277_Var
		);
		final EList<? extends EObject> Expr_277_list = LogicalOrExpression_277_Var
		.getExpr();
		Assert.assertNotNull(Expr_277_list);
		Assert.assertEquals(1, Expr_277_list.size());
		//277
		final LogicalAndExpression LogicalAndExpression_278_Var
		 = (LogicalAndExpression)Expr_277_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_278_Var
		);
		final EList<? extends EObject> Expr_278_list = LogicalAndExpression_278_Var
		.getExpr();
		Assert.assertNotNull(Expr_278_list);
		Assert.assertEquals(1, Expr_278_list.size());
		//278
		final InclusiveOrExpression InclusiveOrExpression_279_Var
		 = (InclusiveOrExpression)Expr_278_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_279_Var
		);
		final EList<? extends EObject> Expr_279_list = InclusiveOrExpression_279_Var
		.getExpr();
		Assert.assertNotNull(Expr_279_list);
		Assert.assertEquals(1, Expr_279_list.size());
		//279
		final ExclusiveOrExpression ExclusiveOrExpression_280_Var
		 = (ExclusiveOrExpression)Expr_279_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_280_Var
		);
		final EList<? extends EObject> Expr_280_list = ExclusiveOrExpression_280_Var
		.getExpr();
		Assert.assertNotNull(Expr_280_list);
		Assert.assertEquals(1, Expr_280_list.size());
		//280
		final AndExpression AndExpression_281_Var
		 = (AndExpression)Expr_280_list.get(0);
		Assert.assertNotNull(AndExpression_281_Var
		);
		final EList<? extends EObject> Expr_281_list = AndExpression_281_Var
		.getExpr();
		Assert.assertNotNull(Expr_281_list);
		Assert.assertEquals(1, Expr_281_list.size());
		//281
		final EqualityExpression EqualityExpression_282_Var
		 = (EqualityExpression)Expr_281_list.get(0);
		Assert.assertNotNull(EqualityExpression_282_Var
		);
		final EList<? extends EObject> Expr_282_list = EqualityExpression_282_Var
		.getExpr();
		Assert.assertNotNull(Expr_282_list);
		Assert.assertEquals(1, Expr_282_list.size());
		//282
		final RelationalExpression RelationalExpression_283_Var
		 = (RelationalExpression)Expr_282_list.get(0);
		Assert.assertNotNull(RelationalExpression_283_Var
		);
		final EList<? extends EObject> Expr_283_list = RelationalExpression_283_Var
		.getExpr();
		Assert.assertNotNull(Expr_283_list);
		Assert.assertEquals(1, Expr_283_list.size());
		//283
		final ShiftExpression ShiftExpression_284_Var
		 = (ShiftExpression)Expr_283_list.get(0);
		Assert.assertNotNull(ShiftExpression_284_Var
		);
		final EList<? extends EObject> Expr_284_list = ShiftExpression_284_Var
		.getExpr();
		Assert.assertNotNull(Expr_284_list);
		Assert.assertEquals(1, Expr_284_list.size());
		//284
		final AdditiveExpression AdditiveExpression_285_Var
		 = (AdditiveExpression)Expr_284_list.get(0);
		Assert.assertNotNull(AdditiveExpression_285_Var
		);
		final EList<? extends EObject> Expr_285_list = AdditiveExpression_285_Var
		.getExpr();
		Assert.assertNotNull(Expr_285_list);
		Assert.assertEquals(1, Expr_285_list.size());
		//285
		final MultiplicativeExpression MultiplicativeExpression_286_Var
		 = (MultiplicativeExpression)Expr_285_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_286_Var
		);
		final EList<? extends EObject> Expr_286_list = MultiplicativeExpression_286_Var
		.getExpr();
		Assert.assertNotNull(Expr_286_list);
		Assert.assertEquals(1, Expr_286_list.size());
		//286
		final CastExpression CastExpression_287_Var
		 = (CastExpression)Expr_286_list.get(0);
		Assert.assertNotNull(CastExpression_287_Var
		);
		//287
		final UnaryExpression UnaryExpression_288_Var
		 = (UnaryExpression)CastExpression_287_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_288_Var
		);
		//288
		final PostfixExpression PostfixExpression_289_Var
		 = (PostfixExpression)UnaryExpression_288_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_289_Var
		);
		final EList<? extends EObject> Expr_289_list = PostfixExpression_289_Var
		.getExpr();
		Assert.assertNotNull(Expr_289_list);
		Assert.assertEquals(1, Expr_289_list.size());
		//289
		final PrimaryExpression PrimaryExpression_290_Var
		 = (PrimaryExpression)Expr_289_list.get(0);
		Assert.assertNotNull(PrimaryExpression_290_Var
		);
		//290
		final Constant2 Constant2_291_Var
		 = (Constant2)PrimaryExpression_290_Var
		.getConst();
		Assert.assertNotNull(Constant2_291_Var
		);
		Assert.assertEquals("\"sizeof(joe)=%lu\\n\"", Constant2_291_Var
		.getStr());
		//291
		final AssignmentExpression AssignmentExpression_292_Var
		 = (AssignmentExpression)Expr_274_list.get(1);
		Assert.assertNotNull(AssignmentExpression_292_Var
		);
		//292
		final ConditionalExpression ConditionalExpression_293_Var
		 = (ConditionalExpression)AssignmentExpression_292_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_293_Var
		);
		//293
		final LogicalOrExpression LogicalOrExpression_294_Var
		 = (LogicalOrExpression)ConditionalExpression_293_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_294_Var
		);
		final EList<? extends EObject> Expr_294_list = LogicalOrExpression_294_Var
		.getExpr();
		Assert.assertNotNull(Expr_294_list);
		Assert.assertEquals(1, Expr_294_list.size());
		//294
		final LogicalAndExpression LogicalAndExpression_295_Var
		 = (LogicalAndExpression)Expr_294_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_295_Var
		);
		final EList<? extends EObject> Expr_295_list = LogicalAndExpression_295_Var
		.getExpr();
		Assert.assertNotNull(Expr_295_list);
		Assert.assertEquals(1, Expr_295_list.size());
		//295
		final InclusiveOrExpression InclusiveOrExpression_296_Var
		 = (InclusiveOrExpression)Expr_295_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_296_Var
		);
		final EList<? extends EObject> Expr_296_list = InclusiveOrExpression_296_Var
		.getExpr();
		Assert.assertNotNull(Expr_296_list);
		Assert.assertEquals(1, Expr_296_list.size());
		//296
		final ExclusiveOrExpression ExclusiveOrExpression_297_Var
		 = (ExclusiveOrExpression)Expr_296_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_297_Var
		);
		final EList<? extends EObject> Expr_297_list = ExclusiveOrExpression_297_Var
		.getExpr();
		Assert.assertNotNull(Expr_297_list);
		Assert.assertEquals(1, Expr_297_list.size());
		//297
		final AndExpression AndExpression_298_Var
		 = (AndExpression)Expr_297_list.get(0);
		Assert.assertNotNull(AndExpression_298_Var
		);
		final EList<? extends EObject> Expr_298_list = AndExpression_298_Var
		.getExpr();
		Assert.assertNotNull(Expr_298_list);
		Assert.assertEquals(1, Expr_298_list.size());
		//298
		final EqualityExpression EqualityExpression_299_Var
		 = (EqualityExpression)Expr_298_list.get(0);
		Assert.assertNotNull(EqualityExpression_299_Var
		);
		final EList<? extends EObject> Expr_299_list = EqualityExpression_299_Var
		.getExpr();
		Assert.assertNotNull(Expr_299_list);
		Assert.assertEquals(1, Expr_299_list.size());
		//299
		final RelationalExpression RelationalExpression_300_Var
		 = (RelationalExpression)Expr_299_list.get(0);
		Assert.assertNotNull(RelationalExpression_300_Var
		);
		final EList<? extends EObject> Expr_300_list = RelationalExpression_300_Var
		.getExpr();
		Assert.assertNotNull(Expr_300_list);
		Assert.assertEquals(1, Expr_300_list.size());
		//300
		final ShiftExpression ShiftExpression_301_Var
		 = (ShiftExpression)Expr_300_list.get(0);
		Assert.assertNotNull(ShiftExpression_301_Var
		);
		final EList<? extends EObject> Expr_301_list = ShiftExpression_301_Var
		.getExpr();
		Assert.assertNotNull(Expr_301_list);
		Assert.assertEquals(1, Expr_301_list.size());
		//301
		final AdditiveExpression AdditiveExpression_302_Var
		 = (AdditiveExpression)Expr_301_list.get(0);
		Assert.assertNotNull(AdditiveExpression_302_Var
		);
		final EList<? extends EObject> Expr_302_list = AdditiveExpression_302_Var
		.getExpr();
		Assert.assertNotNull(Expr_302_list);
		Assert.assertEquals(1, Expr_302_list.size());
		//302
		final MultiplicativeExpression MultiplicativeExpression_303_Var
		 = (MultiplicativeExpression)Expr_302_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_303_Var
		);
		final EList<? extends EObject> Expr_303_list = MultiplicativeExpression_303_Var
		.getExpr();
		Assert.assertNotNull(Expr_303_list);
		Assert.assertEquals(1, Expr_303_list.size());
		//303
		final CastExpression CastExpression_304_Var
		 = (CastExpression)Expr_303_list.get(0);
		Assert.assertNotNull(CastExpression_304_Var
		);
		//304
		final UnaryExpression UnaryExpression_305_Var
		 = (UnaryExpression)CastExpression_304_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_305_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_305_Var
		.getSizeOf());
		//305
		final UnaryExpression UnaryExpression_306_Var
		 = (UnaryExpression)UnaryExpression_305_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_306_Var
		);
		//306
		final PostfixExpression PostfixExpression_307_Var
		 = (PostfixExpression)UnaryExpression_306_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_307_Var
		);
		final EList<? extends EObject> Expr_307_list = PostfixExpression_307_Var
		.getExpr();
		Assert.assertNotNull(Expr_307_list);
		Assert.assertEquals(1, Expr_307_list.size());
		//307
		final PrimaryExpression PrimaryExpression_308_Var
		 = (PrimaryExpression)Expr_307_list.get(0);
		Assert.assertNotNull(PrimaryExpression_308_Var
		);
		//308
		final Expression Expression_309_Var
		 = (Expression)PrimaryExpression_308_Var
		.getExpr();
		Assert.assertNotNull(Expression_309_Var
		);
		final EList<? extends EObject> ExprExpr_309_list = Expression_309_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_309_list);
		Assert.assertEquals(1, ExprExpr_309_list.size());
		//309
		final AssignmentExpression AssignmentExpression_310_Var
		 = (AssignmentExpression)ExprExpr_309_list.get(0);
		Assert.assertNotNull(AssignmentExpression_310_Var
		);
		//310
		final ConditionalExpression ConditionalExpression_311_Var
		 = (ConditionalExpression)AssignmentExpression_310_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_311_Var
		);
		//311
		final LogicalOrExpression LogicalOrExpression_312_Var
		 = (LogicalOrExpression)ConditionalExpression_311_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = LogicalOrExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final LogicalAndExpression LogicalAndExpression_313_Var
		 = (LogicalAndExpression)Expr_312_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_313_Var
		);
		final EList<? extends EObject> Expr_313_list = LogicalAndExpression_313_Var
		.getExpr();
		Assert.assertNotNull(Expr_313_list);
		Assert.assertEquals(1, Expr_313_list.size());
		//313
		final InclusiveOrExpression InclusiveOrExpression_314_Var
		 = (InclusiveOrExpression)Expr_313_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = InclusiveOrExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final ExclusiveOrExpression ExclusiveOrExpression_315_Var
		 = (ExclusiveOrExpression)Expr_314_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = ExclusiveOrExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final AndExpression AndExpression_316_Var
		 = (AndExpression)Expr_315_list.get(0);
		Assert.assertNotNull(AndExpression_316_Var
		);
		final EList<? extends EObject> Expr_316_list = AndExpression_316_Var
		.getExpr();
		Assert.assertNotNull(Expr_316_list);
		Assert.assertEquals(1, Expr_316_list.size());
		//316
		final EqualityExpression EqualityExpression_317_Var
		 = (EqualityExpression)Expr_316_list.get(0);
		Assert.assertNotNull(EqualityExpression_317_Var
		);
		final EList<? extends EObject> Expr_317_list = EqualityExpression_317_Var
		.getExpr();
		Assert.assertNotNull(Expr_317_list);
		Assert.assertEquals(1, Expr_317_list.size());
		//317
		final RelationalExpression RelationalExpression_318_Var
		 = (RelationalExpression)Expr_317_list.get(0);
		Assert.assertNotNull(RelationalExpression_318_Var
		);
		final EList<? extends EObject> Expr_318_list = RelationalExpression_318_Var
		.getExpr();
		Assert.assertNotNull(Expr_318_list);
		Assert.assertEquals(1, Expr_318_list.size());
		//318
		final ShiftExpression ShiftExpression_319_Var
		 = (ShiftExpression)Expr_318_list.get(0);
		Assert.assertNotNull(ShiftExpression_319_Var
		);
		final EList<? extends EObject> Expr_319_list = ShiftExpression_319_Var
		.getExpr();
		Assert.assertNotNull(Expr_319_list);
		Assert.assertEquals(1, Expr_319_list.size());
		//319
		final AdditiveExpression AdditiveExpression_320_Var
		 = (AdditiveExpression)Expr_319_list.get(0);
		Assert.assertNotNull(AdditiveExpression_320_Var
		);
		final EList<? extends EObject> Expr_320_list = AdditiveExpression_320_Var
		.getExpr();
		Assert.assertNotNull(Expr_320_list);
		Assert.assertEquals(1, Expr_320_list.size());
		//320
		final MultiplicativeExpression MultiplicativeExpression_321_Var
		 = (MultiplicativeExpression)Expr_320_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_321_Var
		);
		final EList<? extends EObject> Expr_321_list = MultiplicativeExpression_321_Var
		.getExpr();
		Assert.assertNotNull(Expr_321_list);
		Assert.assertEquals(1, Expr_321_list.size());
		//321
		final CastExpression CastExpression_322_Var
		 = (CastExpression)Expr_321_list.get(0);
		Assert.assertNotNull(CastExpression_322_Var
		);
		//322
		final UnaryExpression UnaryExpression_323_Var
		 = (UnaryExpression)CastExpression_322_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_323_Var
		);
		//323
		final PostfixExpression PostfixExpression_324_Var
		 = (PostfixExpression)UnaryExpression_323_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_324_Var
		);
		final EList<? extends EObject> Expr_324_list = PostfixExpression_324_Var
		.getExpr();
		Assert.assertNotNull(Expr_324_list);
		Assert.assertEquals(1, Expr_324_list.size());
		//324
		final PrimaryExpression PrimaryExpression_325_Var
		 = (PrimaryExpression)Expr_324_list.get(0);
		Assert.assertNotNull(PrimaryExpression_325_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_325_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_255_Var
		.getSemi());
		//325
		final Statement Statement_326_Var
		 = (Statement)Statement_107_list.get(3);
		Assert.assertNotNull(Statement_326_Var
		);
		//326
		final ExpressionStatement ExpressionStatement_327_Var
		 = (ExpressionStatement)Statement_326_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_327_Var
		);
		//327
		final Expression Expression_328_Var
		 = (Expression)ExpressionStatement_327_Var
		.getExpression();
		Assert.assertNotNull(Expression_328_Var
		);
		final EList<? extends EObject> ExprExpr_328_list = Expression_328_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_328_list);
		Assert.assertEquals(1, ExprExpr_328_list.size());
		//328
		final AssignmentExpression AssignmentExpression_329_Var
		 = (AssignmentExpression)ExprExpr_328_list.get(0);
		Assert.assertNotNull(AssignmentExpression_329_Var
		);
		//329
		final UnaryExpression UnaryExpression_330_Var
		 = (UnaryExpression)AssignmentExpression_329_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_330_Var
		);
		//330
		final PostfixExpression PostfixExpression_331_Var
		 = (PostfixExpression)UnaryExpression_330_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = PostfixExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final PrimaryExpression PrimaryExpression_332_Var
		 = (PrimaryExpression)Expr_331_list.get(0);
		Assert.assertNotNull(PrimaryExpression_332_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_332_Var
		.getId());
		final EList<? extends EObject> Suffix_332_list = PostfixExpression_331_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_332_list);
		Assert.assertEquals(1, Suffix_332_list.size());
		//332
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_333_Var
		 = (PostfixExpressionSuffixDot)Suffix_332_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_333_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_333_Var
		.getId());
		//333
		final AssignmentOperator AssignmentOperator_334_Var
		 = (AssignmentOperator)AssignmentExpression_329_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_334_Var
		);
		Assert.assertEquals("=", AssignmentOperator_334_Var
		.getOp());
		//334
		final AssignmentExpression AssignmentExpression_335_Var
		 = (AssignmentExpression)AssignmentExpression_329_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_335_Var
		);
		//335
		final ConditionalExpression ConditionalExpression_336_Var
		 = (ConditionalExpression)AssignmentExpression_335_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_336_Var
		);
		//336
		final LogicalOrExpression LogicalOrExpression_337_Var
		 = (LogicalOrExpression)ConditionalExpression_336_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_337_Var
		);
		final EList<? extends EObject> Expr_337_list = LogicalOrExpression_337_Var
		.getExpr();
		Assert.assertNotNull(Expr_337_list);
		Assert.assertEquals(1, Expr_337_list.size());
		//337
		final LogicalAndExpression LogicalAndExpression_338_Var
		 = (LogicalAndExpression)Expr_337_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = LogicalAndExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final InclusiveOrExpression InclusiveOrExpression_339_Var
		 = (InclusiveOrExpression)Expr_338_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_339_Var
		);
		final EList<? extends EObject> Expr_339_list = InclusiveOrExpression_339_Var
		.getExpr();
		Assert.assertNotNull(Expr_339_list);
		Assert.assertEquals(1, Expr_339_list.size());
		//339
		final ExclusiveOrExpression ExclusiveOrExpression_340_Var
		 = (ExclusiveOrExpression)Expr_339_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_340_Var
		);
		final EList<? extends EObject> Expr_340_list = ExclusiveOrExpression_340_Var
		.getExpr();
		Assert.assertNotNull(Expr_340_list);
		Assert.assertEquals(1, Expr_340_list.size());
		//340
		final AndExpression AndExpression_341_Var
		 = (AndExpression)Expr_340_list.get(0);
		Assert.assertNotNull(AndExpression_341_Var
		);
		final EList<? extends EObject> Expr_341_list = AndExpression_341_Var
		.getExpr();
		Assert.assertNotNull(Expr_341_list);
		Assert.assertEquals(1, Expr_341_list.size());
		//341
		final EqualityExpression EqualityExpression_342_Var
		 = (EqualityExpression)Expr_341_list.get(0);
		Assert.assertNotNull(EqualityExpression_342_Var
		);
		final EList<? extends EObject> Expr_342_list = EqualityExpression_342_Var
		.getExpr();
		Assert.assertNotNull(Expr_342_list);
		Assert.assertEquals(1, Expr_342_list.size());
		//342
		final RelationalExpression RelationalExpression_343_Var
		 = (RelationalExpression)Expr_342_list.get(0);
		Assert.assertNotNull(RelationalExpression_343_Var
		);
		final EList<? extends EObject> Expr_343_list = RelationalExpression_343_Var
		.getExpr();
		Assert.assertNotNull(Expr_343_list);
		Assert.assertEquals(1, Expr_343_list.size());
		//343
		final ShiftExpression ShiftExpression_344_Var
		 = (ShiftExpression)Expr_343_list.get(0);
		Assert.assertNotNull(ShiftExpression_344_Var
		);
		final EList<? extends EObject> Expr_344_list = ShiftExpression_344_Var
		.getExpr();
		Assert.assertNotNull(Expr_344_list);
		Assert.assertEquals(1, Expr_344_list.size());
		//344
		final AdditiveExpression AdditiveExpression_345_Var
		 = (AdditiveExpression)Expr_344_list.get(0);
		Assert.assertNotNull(AdditiveExpression_345_Var
		);
		final EList<? extends EObject> Expr_345_list = AdditiveExpression_345_Var
		.getExpr();
		Assert.assertNotNull(Expr_345_list);
		Assert.assertEquals(1, Expr_345_list.size());
		//345
		final MultiplicativeExpression MultiplicativeExpression_346_Var
		 = (MultiplicativeExpression)Expr_345_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_346_Var
		);
		final EList<? extends EObject> Expr_346_list = MultiplicativeExpression_346_Var
		.getExpr();
		Assert.assertNotNull(Expr_346_list);
		Assert.assertEquals(1, Expr_346_list.size());
		//346
		final CastExpression CastExpression_347_Var
		 = (CastExpression)Expr_346_list.get(0);
		Assert.assertNotNull(CastExpression_347_Var
		);
		//347
		final UnaryExpression UnaryExpression_348_Var
		 = (UnaryExpression)CastExpression_347_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_348_Var
		);
		//348
		final PostfixExpression PostfixExpression_349_Var
		 = (PostfixExpression)UnaryExpression_348_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_349_Var
		);
		final EList<? extends EObject> Expr_349_list = PostfixExpression_349_Var
		.getExpr();
		Assert.assertNotNull(Expr_349_list);
		Assert.assertEquals(1, Expr_349_list.size());
		//349
		final PrimaryExpression PrimaryExpression_350_Var
		 = (PrimaryExpression)Expr_349_list.get(0);
		Assert.assertNotNull(PrimaryExpression_350_Var
		);
		//350
		final Constant2 Constant2_351_Var
		 = (Constant2)PrimaryExpression_350_Var
		.getConst();
		Assert.assertNotNull(Constant2_351_Var
		);
		Assert.assertEquals("0x008", Constant2_351_Var
		.getHex());
		Assert.assertEquals(";", ExpressionStatement_327_Var
		.getSemi());
		//351
		final Statement Statement_352_Var
		 = (Statement)Statement_107_list.get(4);
		Assert.assertNotNull(Statement_352_Var
		);
		//352
		final ExpressionStatement ExpressionStatement_353_Var
		 = (ExpressionStatement)Statement_352_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_353_Var
		);
		//353
		final Expression Expression_354_Var
		 = (Expression)ExpressionStatement_353_Var
		.getExpression();
		Assert.assertNotNull(Expression_354_Var
		);
		final EList<? extends EObject> ExprExpr_354_list = Expression_354_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_354_list);
		Assert.assertEquals(1, ExprExpr_354_list.size());
		//354
		final AssignmentExpression AssignmentExpression_355_Var
		 = (AssignmentExpression)ExprExpr_354_list.get(0);
		Assert.assertNotNull(AssignmentExpression_355_Var
		);
		//355
		final ConditionalExpression ConditionalExpression_356_Var
		 = (ConditionalExpression)AssignmentExpression_355_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_356_Var
		);
		//356
		final LogicalOrExpression LogicalOrExpression_357_Var
		 = (LogicalOrExpression)ConditionalExpression_356_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_357_Var
		);
		final EList<? extends EObject> Expr_357_list = LogicalOrExpression_357_Var
		.getExpr();
		Assert.assertNotNull(Expr_357_list);
		Assert.assertEquals(1, Expr_357_list.size());
		//357
		final LogicalAndExpression LogicalAndExpression_358_Var
		 = (LogicalAndExpression)Expr_357_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_358_Var
		);
		final EList<? extends EObject> Expr_358_list = LogicalAndExpression_358_Var
		.getExpr();
		Assert.assertNotNull(Expr_358_list);
		Assert.assertEquals(1, Expr_358_list.size());
		//358
		final InclusiveOrExpression InclusiveOrExpression_359_Var
		 = (InclusiveOrExpression)Expr_358_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_359_Var
		);
		final EList<? extends EObject> Expr_359_list = InclusiveOrExpression_359_Var
		.getExpr();
		Assert.assertNotNull(Expr_359_list);
		Assert.assertEquals(1, Expr_359_list.size());
		//359
		final ExclusiveOrExpression ExclusiveOrExpression_360_Var
		 = (ExclusiveOrExpression)Expr_359_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_360_Var
		);
		final EList<? extends EObject> Expr_360_list = ExclusiveOrExpression_360_Var
		.getExpr();
		Assert.assertNotNull(Expr_360_list);
		Assert.assertEquals(1, Expr_360_list.size());
		//360
		final AndExpression AndExpression_361_Var
		 = (AndExpression)Expr_360_list.get(0);
		Assert.assertNotNull(AndExpression_361_Var
		);
		final EList<? extends EObject> Expr_361_list = AndExpression_361_Var
		.getExpr();
		Assert.assertNotNull(Expr_361_list);
		Assert.assertEquals(1, Expr_361_list.size());
		//361
		final EqualityExpression EqualityExpression_362_Var
		 = (EqualityExpression)Expr_361_list.get(0);
		Assert.assertNotNull(EqualityExpression_362_Var
		);
		final EList<? extends EObject> Expr_362_list = EqualityExpression_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(1, Expr_362_list.size());
		//362
		final RelationalExpression RelationalExpression_363_Var
		 = (RelationalExpression)Expr_362_list.get(0);
		Assert.assertNotNull(RelationalExpression_363_Var
		);
		final EList<? extends EObject> Expr_363_list = RelationalExpression_363_Var
		.getExpr();
		Assert.assertNotNull(Expr_363_list);
		Assert.assertEquals(1, Expr_363_list.size());
		//363
		final ShiftExpression ShiftExpression_364_Var
		 = (ShiftExpression)Expr_363_list.get(0);
		Assert.assertNotNull(ShiftExpression_364_Var
		);
		final EList<? extends EObject> Expr_364_list = ShiftExpression_364_Var
		.getExpr();
		Assert.assertNotNull(Expr_364_list);
		Assert.assertEquals(1, Expr_364_list.size());
		//364
		final AdditiveExpression AdditiveExpression_365_Var
		 = (AdditiveExpression)Expr_364_list.get(0);
		Assert.assertNotNull(AdditiveExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = AdditiveExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final MultiplicativeExpression MultiplicativeExpression_366_Var
		 = (MultiplicativeExpression)Expr_365_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_366_Var
		);
		final EList<? extends EObject> Expr_366_list = MultiplicativeExpression_366_Var
		.getExpr();
		Assert.assertNotNull(Expr_366_list);
		Assert.assertEquals(1, Expr_366_list.size());
		//366
		final CastExpression CastExpression_367_Var
		 = (CastExpression)Expr_366_list.get(0);
		Assert.assertNotNull(CastExpression_367_Var
		);
		//367
		final UnaryExpression UnaryExpression_368_Var
		 = (UnaryExpression)CastExpression_367_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_368_Var
		);
		//368
		final PostfixExpression PostfixExpression_369_Var
		 = (PostfixExpression)UnaryExpression_368_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_369_Var
		);
		final EList<? extends EObject> Expr_369_list = PostfixExpression_369_Var
		.getExpr();
		Assert.assertNotNull(Expr_369_list);
		Assert.assertEquals(1, Expr_369_list.size());
		//369
		final PrimaryExpression PrimaryExpression_370_Var
		 = (PrimaryExpression)Expr_369_list.get(0);
		Assert.assertNotNull(PrimaryExpression_370_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_370_Var
		.getId());
		final EList<? extends EObject> Suffix_370_list = PostfixExpression_369_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_370_list);
		Assert.assertEquals(1, Suffix_370_list.size());
		//370
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_371_Var
		 = (PostfixExpressionSuffixArgument)Suffix_370_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_371_Var
		);
		//371
		final ArgumentExpressionList ArgumentExpressionList_372_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_371_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_372_Var
		);
		final EList<? extends EObject> Expr_372_list = ArgumentExpressionList_372_Var
		.getExpr();
		Assert.assertNotNull(Expr_372_list);
		Assert.assertEquals(2, Expr_372_list.size());
		//372
		final AssignmentExpression AssignmentExpression_373_Var
		 = (AssignmentExpression)Expr_372_list.get(0);
		Assert.assertNotNull(AssignmentExpression_373_Var
		);
		//373
		final ConditionalExpression ConditionalExpression_374_Var
		 = (ConditionalExpression)AssignmentExpression_373_Var
		.getExpr();
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
		Assert.assertEquals("phil", PrimaryExpression_388_Var
		.getId());
		final EList<? extends EObject> Suffix_388_list = PostfixExpression_387_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_388_list);
		Assert.assertEquals(1, Suffix_388_list.size());
		//388
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_389_Var
		 = (PostfixExpressionSuffixDot)Suffix_388_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_389_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_389_Var
		.getId());
		//389
		final AssignmentExpression AssignmentExpression_390_Var
		 = (AssignmentExpression)Expr_372_list.get(1);
		Assert.assertNotNull(AssignmentExpression_390_Var
		);
		//390
		final ConditionalExpression ConditionalExpression_391_Var
		 = (ConditionalExpression)AssignmentExpression_390_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_391_Var
		);
		//391
		final LogicalOrExpression LogicalOrExpression_392_Var
		 = (LogicalOrExpression)ConditionalExpression_391_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_392_Var
		);
		final EList<? extends EObject> Expr_392_list = LogicalOrExpression_392_Var
		.getExpr();
		Assert.assertNotNull(Expr_392_list);
		Assert.assertEquals(1, Expr_392_list.size());
		//392
		final LogicalAndExpression LogicalAndExpression_393_Var
		 = (LogicalAndExpression)Expr_392_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_393_Var
		);
		final EList<? extends EObject> Expr_393_list = LogicalAndExpression_393_Var
		.getExpr();
		Assert.assertNotNull(Expr_393_list);
		Assert.assertEquals(1, Expr_393_list.size());
		//393
		final InclusiveOrExpression InclusiveOrExpression_394_Var
		 = (InclusiveOrExpression)Expr_393_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_394_Var
		);
		final EList<? extends EObject> Expr_394_list = InclusiveOrExpression_394_Var
		.getExpr();
		Assert.assertNotNull(Expr_394_list);
		Assert.assertEquals(1, Expr_394_list.size());
		//394
		final ExclusiveOrExpression ExclusiveOrExpression_395_Var
		 = (ExclusiveOrExpression)Expr_394_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_395_Var
		);
		final EList<? extends EObject> Expr_395_list = ExclusiveOrExpression_395_Var
		.getExpr();
		Assert.assertNotNull(Expr_395_list);
		Assert.assertEquals(1, Expr_395_list.size());
		//395
		final AndExpression AndExpression_396_Var
		 = (AndExpression)Expr_395_list.get(0);
		Assert.assertNotNull(AndExpression_396_Var
		);
		final EList<? extends EObject> Expr_396_list = AndExpression_396_Var
		.getExpr();
		Assert.assertNotNull(Expr_396_list);
		Assert.assertEquals(1, Expr_396_list.size());
		//396
		final EqualityExpression EqualityExpression_397_Var
		 = (EqualityExpression)Expr_396_list.get(0);
		Assert.assertNotNull(EqualityExpression_397_Var
		);
		final EList<? extends EObject> Expr_397_list = EqualityExpression_397_Var
		.getExpr();
		Assert.assertNotNull(Expr_397_list);
		Assert.assertEquals(1, Expr_397_list.size());
		//397
		final RelationalExpression RelationalExpression_398_Var
		 = (RelationalExpression)Expr_397_list.get(0);
		Assert.assertNotNull(RelationalExpression_398_Var
		);
		final EList<? extends EObject> Expr_398_list = RelationalExpression_398_Var
		.getExpr();
		Assert.assertNotNull(Expr_398_list);
		Assert.assertEquals(1, Expr_398_list.size());
		//398
		final ShiftExpression ShiftExpression_399_Var
		 = (ShiftExpression)Expr_398_list.get(0);
		Assert.assertNotNull(ShiftExpression_399_Var
		);
		final EList<? extends EObject> Expr_399_list = ShiftExpression_399_Var
		.getExpr();
		Assert.assertNotNull(Expr_399_list);
		Assert.assertEquals(1, Expr_399_list.size());
		//399
		final AdditiveExpression AdditiveExpression_400_Var
		 = (AdditiveExpression)Expr_399_list.get(0);
		Assert.assertNotNull(AdditiveExpression_400_Var
		);
		final EList<? extends EObject> Expr_400_list = AdditiveExpression_400_Var
		.getExpr();
		Assert.assertNotNull(Expr_400_list);
		Assert.assertEquals(1, Expr_400_list.size());
		//400
		final MultiplicativeExpression MultiplicativeExpression_401_Var
		 = (MultiplicativeExpression)Expr_400_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_401_Var
		);
		final EList<? extends EObject> Expr_401_list = MultiplicativeExpression_401_Var
		.getExpr();
		Assert.assertNotNull(Expr_401_list);
		Assert.assertEquals(1, Expr_401_list.size());
		//401
		final CastExpression CastExpression_402_Var
		 = (CastExpression)Expr_401_list.get(0);
		Assert.assertNotNull(CastExpression_402_Var
		);
		//402
		final UnaryExpression UnaryExpression_403_Var
		 = (UnaryExpression)CastExpression_402_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_403_Var
		);
		//403
		final PostfixExpression PostfixExpression_404_Var
		 = (PostfixExpression)UnaryExpression_403_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_404_Var
		);
		final EList<? extends EObject> Expr_404_list = PostfixExpression_404_Var
		.getExpr();
		Assert.assertNotNull(Expr_404_list);
		Assert.assertEquals(1, Expr_404_list.size());
		//404
		final PrimaryExpression PrimaryExpression_405_Var
		 = (PrimaryExpression)Expr_404_list.get(0);
		Assert.assertNotNull(PrimaryExpression_405_Var
		);
		//405
		final Constant2 Constant2_406_Var
		 = (Constant2)PrimaryExpression_405_Var
		.getConst();
		Assert.assertNotNull(Constant2_406_Var
		);
		Assert.assertEquals("\"Phil Morrison\"", Constant2_406_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_353_Var
		.getSemi());
		//406
		final Statement Statement_407_Var
		 = (Statement)Statement_107_list.get(5);
		Assert.assertNotNull(Statement_407_Var
		);
		//407
		final ExpressionStatement ExpressionStatement_408_Var
		 = (ExpressionStatement)Statement_407_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_408_Var
		);
		//408
		final Expression Expression_409_Var
		 = (Expression)ExpressionStatement_408_Var
		.getExpression();
		Assert.assertNotNull(Expression_409_Var
		);
		final EList<? extends EObject> ExprExpr_409_list = Expression_409_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_409_list);
		Assert.assertEquals(1, ExprExpr_409_list.size());
		//409
		final AssignmentExpression AssignmentExpression_410_Var
		 = (AssignmentExpression)ExprExpr_409_list.get(0);
		Assert.assertNotNull(AssignmentExpression_410_Var
		);
		//410
		final ConditionalExpression ConditionalExpression_411_Var
		 = (ConditionalExpression)AssignmentExpression_410_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_411_Var
		);
		//411
		final LogicalOrExpression LogicalOrExpression_412_Var
		 = (LogicalOrExpression)ConditionalExpression_411_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_412_Var
		);
		final EList<? extends EObject> Expr_412_list = LogicalOrExpression_412_Var
		.getExpr();
		Assert.assertNotNull(Expr_412_list);
		Assert.assertEquals(1, Expr_412_list.size());
		//412
		final LogicalAndExpression LogicalAndExpression_413_Var
		 = (LogicalAndExpression)Expr_412_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_413_Var
		);
		final EList<? extends EObject> Expr_413_list = LogicalAndExpression_413_Var
		.getExpr();
		Assert.assertNotNull(Expr_413_list);
		Assert.assertEquals(1, Expr_413_list.size());
		//413
		final InclusiveOrExpression InclusiveOrExpression_414_Var
		 = (InclusiveOrExpression)Expr_413_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_414_Var
		);
		final EList<? extends EObject> Expr_414_list = InclusiveOrExpression_414_Var
		.getExpr();
		Assert.assertNotNull(Expr_414_list);
		Assert.assertEquals(1, Expr_414_list.size());
		//414
		final ExclusiveOrExpression ExclusiveOrExpression_415_Var
		 = (ExclusiveOrExpression)Expr_414_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_415_Var
		);
		final EList<? extends EObject> Expr_415_list = ExclusiveOrExpression_415_Var
		.getExpr();
		Assert.assertNotNull(Expr_415_list);
		Assert.assertEquals(1, Expr_415_list.size());
		//415
		final AndExpression AndExpression_416_Var
		 = (AndExpression)Expr_415_list.get(0);
		Assert.assertNotNull(AndExpression_416_Var
		);
		final EList<? extends EObject> Expr_416_list = AndExpression_416_Var
		.getExpr();
		Assert.assertNotNull(Expr_416_list);
		Assert.assertEquals(1, Expr_416_list.size());
		//416
		final EqualityExpression EqualityExpression_417_Var
		 = (EqualityExpression)Expr_416_list.get(0);
		Assert.assertNotNull(EqualityExpression_417_Var
		);
		final EList<? extends EObject> Expr_417_list = EqualityExpression_417_Var
		.getExpr();
		Assert.assertNotNull(Expr_417_list);
		Assert.assertEquals(1, Expr_417_list.size());
		//417
		final RelationalExpression RelationalExpression_418_Var
		 = (RelationalExpression)Expr_417_list.get(0);
		Assert.assertNotNull(RelationalExpression_418_Var
		);
		final EList<? extends EObject> Expr_418_list = RelationalExpression_418_Var
		.getExpr();
		Assert.assertNotNull(Expr_418_list);
		Assert.assertEquals(1, Expr_418_list.size());
		//418
		final ShiftExpression ShiftExpression_419_Var
		 = (ShiftExpression)Expr_418_list.get(0);
		Assert.assertNotNull(ShiftExpression_419_Var
		);
		final EList<? extends EObject> Expr_419_list = ShiftExpression_419_Var
		.getExpr();
		Assert.assertNotNull(Expr_419_list);
		Assert.assertEquals(1, Expr_419_list.size());
		//419
		final AdditiveExpression AdditiveExpression_420_Var
		 = (AdditiveExpression)Expr_419_list.get(0);
		Assert.assertNotNull(AdditiveExpression_420_Var
		);
		final EList<? extends EObject> Expr_420_list = AdditiveExpression_420_Var
		.getExpr();
		Assert.assertNotNull(Expr_420_list);
		Assert.assertEquals(1, Expr_420_list.size());
		//420
		final MultiplicativeExpression MultiplicativeExpression_421_Var
		 = (MultiplicativeExpression)Expr_420_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_421_Var
		);
		final EList<? extends EObject> Expr_421_list = MultiplicativeExpression_421_Var
		.getExpr();
		Assert.assertNotNull(Expr_421_list);
		Assert.assertEquals(1, Expr_421_list.size());
		//421
		final CastExpression CastExpression_422_Var
		 = (CastExpression)Expr_421_list.get(0);
		Assert.assertNotNull(CastExpression_422_Var
		);
		//422
		final UnaryExpression UnaryExpression_423_Var
		 = (UnaryExpression)CastExpression_422_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_423_Var
		);
		//423
		final PostfixExpression PostfixExpression_424_Var
		 = (PostfixExpression)UnaryExpression_423_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_424_Var
		);
		final EList<? extends EObject> Expr_424_list = PostfixExpression_424_Var
		.getExpr();
		Assert.assertNotNull(Expr_424_list);
		Assert.assertEquals(1, Expr_424_list.size());
		//424
		final PrimaryExpression PrimaryExpression_425_Var
		 = (PrimaryExpression)Expr_424_list.get(0);
		Assert.assertNotNull(PrimaryExpression_425_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_425_Var
		.getId());
		final EList<? extends EObject> Suffix_425_list = PostfixExpression_424_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_425_list);
		Assert.assertEquals(1, Suffix_425_list.size());
		//425
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_426_Var
		 = (PostfixExpressionSuffixArgument)Suffix_425_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_426_Var
		);
		//426
		final ArgumentExpressionList ArgumentExpressionList_427_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_426_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_427_Var
		);
		final EList<? extends EObject> Expr_427_list = ArgumentExpressionList_427_Var
		.getExpr();
		Assert.assertNotNull(Expr_427_list);
		Assert.assertEquals(2, Expr_427_list.size());
		//427
		final AssignmentExpression AssignmentExpression_428_Var
		 = (AssignmentExpression)Expr_427_list.get(0);
		Assert.assertNotNull(AssignmentExpression_428_Var
		);
		//428
		final ConditionalExpression ConditionalExpression_429_Var
		 = (ConditionalExpression)AssignmentExpression_428_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_429_Var
		);
		//429
		final LogicalOrExpression LogicalOrExpression_430_Var
		 = (LogicalOrExpression)ConditionalExpression_429_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_430_Var
		);
		final EList<? extends EObject> Expr_430_list = LogicalOrExpression_430_Var
		.getExpr();
		Assert.assertNotNull(Expr_430_list);
		Assert.assertEquals(1, Expr_430_list.size());
		//430
		final LogicalAndExpression LogicalAndExpression_431_Var
		 = (LogicalAndExpression)Expr_430_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_431_Var
		);
		final EList<? extends EObject> Expr_431_list = LogicalAndExpression_431_Var
		.getExpr();
		Assert.assertNotNull(Expr_431_list);
		Assert.assertEquals(1, Expr_431_list.size());
		//431
		final InclusiveOrExpression InclusiveOrExpression_432_Var
		 = (InclusiveOrExpression)Expr_431_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_432_Var
		);
		final EList<? extends EObject> Expr_432_list = InclusiveOrExpression_432_Var
		.getExpr();
		Assert.assertNotNull(Expr_432_list);
		Assert.assertEquals(1, Expr_432_list.size());
		//432
		final ExclusiveOrExpression ExclusiveOrExpression_433_Var
		 = (ExclusiveOrExpression)Expr_432_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_433_Var
		);
		final EList<? extends EObject> Expr_433_list = ExclusiveOrExpression_433_Var
		.getExpr();
		Assert.assertNotNull(Expr_433_list);
		Assert.assertEquals(1, Expr_433_list.size());
		//433
		final AndExpression AndExpression_434_Var
		 = (AndExpression)Expr_433_list.get(0);
		Assert.assertNotNull(AndExpression_434_Var
		);
		final EList<? extends EObject> Expr_434_list = AndExpression_434_Var
		.getExpr();
		Assert.assertNotNull(Expr_434_list);
		Assert.assertEquals(1, Expr_434_list.size());
		//434
		final EqualityExpression EqualityExpression_435_Var
		 = (EqualityExpression)Expr_434_list.get(0);
		Assert.assertNotNull(EqualityExpression_435_Var
		);
		final EList<? extends EObject> Expr_435_list = EqualityExpression_435_Var
		.getExpr();
		Assert.assertNotNull(Expr_435_list);
		Assert.assertEquals(1, Expr_435_list.size());
		//435
		final RelationalExpression RelationalExpression_436_Var
		 = (RelationalExpression)Expr_435_list.get(0);
		Assert.assertNotNull(RelationalExpression_436_Var
		);
		final EList<? extends EObject> Expr_436_list = RelationalExpression_436_Var
		.getExpr();
		Assert.assertNotNull(Expr_436_list);
		Assert.assertEquals(1, Expr_436_list.size());
		//436
		final ShiftExpression ShiftExpression_437_Var
		 = (ShiftExpression)Expr_436_list.get(0);
		Assert.assertNotNull(ShiftExpression_437_Var
		);
		final EList<? extends EObject> Expr_437_list = ShiftExpression_437_Var
		.getExpr();
		Assert.assertNotNull(Expr_437_list);
		Assert.assertEquals(1, Expr_437_list.size());
		//437
		final AdditiveExpression AdditiveExpression_438_Var
		 = (AdditiveExpression)Expr_437_list.get(0);
		Assert.assertNotNull(AdditiveExpression_438_Var
		);
		final EList<? extends EObject> Expr_438_list = AdditiveExpression_438_Var
		.getExpr();
		Assert.assertNotNull(Expr_438_list);
		Assert.assertEquals(1, Expr_438_list.size());
		//438
		final MultiplicativeExpression MultiplicativeExpression_439_Var
		 = (MultiplicativeExpression)Expr_438_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_439_Var
		);
		final EList<? extends EObject> Expr_439_list = MultiplicativeExpression_439_Var
		.getExpr();
		Assert.assertNotNull(Expr_439_list);
		Assert.assertEquals(1, Expr_439_list.size());
		//439
		final CastExpression CastExpression_440_Var
		 = (CastExpression)Expr_439_list.get(0);
		Assert.assertNotNull(CastExpression_440_Var
		);
		//440
		final UnaryExpression UnaryExpression_441_Var
		 = (UnaryExpression)CastExpression_440_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_441_Var
		);
		//441
		final PostfixExpression PostfixExpression_442_Var
		 = (PostfixExpression)UnaryExpression_441_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_442_Var
		);
		final EList<? extends EObject> Expr_442_list = PostfixExpression_442_Var
		.getExpr();
		Assert.assertNotNull(Expr_442_list);
		Assert.assertEquals(1, Expr_442_list.size());
		//442
		final PrimaryExpression PrimaryExpression_443_Var
		 = (PrimaryExpression)Expr_442_list.get(0);
		Assert.assertNotNull(PrimaryExpression_443_Var
		);
		//443
		final Constant2 Constant2_444_Var
		 = (Constant2)PrimaryExpression_443_Var
		.getConst();
		Assert.assertNotNull(Constant2_444_Var
		);
		Assert.assertEquals("\"joe.id=%d\\n\"", Constant2_444_Var
		.getStr());
		//444
		final AssignmentExpression AssignmentExpression_445_Var
		 = (AssignmentExpression)Expr_427_list.get(1);
		Assert.assertNotNull(AssignmentExpression_445_Var
		);
		//445
		final ConditionalExpression ConditionalExpression_446_Var
		 = (ConditionalExpression)AssignmentExpression_445_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_446_Var
		);
		//446
		final LogicalOrExpression LogicalOrExpression_447_Var
		 = (LogicalOrExpression)ConditionalExpression_446_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_447_Var
		);
		final EList<? extends EObject> Expr_447_list = LogicalOrExpression_447_Var
		.getExpr();
		Assert.assertNotNull(Expr_447_list);
		Assert.assertEquals(1, Expr_447_list.size());
		//447
		final LogicalAndExpression LogicalAndExpression_448_Var
		 = (LogicalAndExpression)Expr_447_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_448_Var
		);
		final EList<? extends EObject> Expr_448_list = LogicalAndExpression_448_Var
		.getExpr();
		Assert.assertNotNull(Expr_448_list);
		Assert.assertEquals(1, Expr_448_list.size());
		//448
		final InclusiveOrExpression InclusiveOrExpression_449_Var
		 = (InclusiveOrExpression)Expr_448_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_449_Var
		);
		final EList<? extends EObject> Expr_449_list = InclusiveOrExpression_449_Var
		.getExpr();
		Assert.assertNotNull(Expr_449_list);
		Assert.assertEquals(1, Expr_449_list.size());
		//449
		final ExclusiveOrExpression ExclusiveOrExpression_450_Var
		 = (ExclusiveOrExpression)Expr_449_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_450_Var
		);
		final EList<? extends EObject> Expr_450_list = ExclusiveOrExpression_450_Var
		.getExpr();
		Assert.assertNotNull(Expr_450_list);
		Assert.assertEquals(1, Expr_450_list.size());
		//450
		final AndExpression AndExpression_451_Var
		 = (AndExpression)Expr_450_list.get(0);
		Assert.assertNotNull(AndExpression_451_Var
		);
		final EList<? extends EObject> Expr_451_list = AndExpression_451_Var
		.getExpr();
		Assert.assertNotNull(Expr_451_list);
		Assert.assertEquals(1, Expr_451_list.size());
		//451
		final EqualityExpression EqualityExpression_452_Var
		 = (EqualityExpression)Expr_451_list.get(0);
		Assert.assertNotNull(EqualityExpression_452_Var
		);
		final EList<? extends EObject> Expr_452_list = EqualityExpression_452_Var
		.getExpr();
		Assert.assertNotNull(Expr_452_list);
		Assert.assertEquals(1, Expr_452_list.size());
		//452
		final RelationalExpression RelationalExpression_453_Var
		 = (RelationalExpression)Expr_452_list.get(0);
		Assert.assertNotNull(RelationalExpression_453_Var
		);
		final EList<? extends EObject> Expr_453_list = RelationalExpression_453_Var
		.getExpr();
		Assert.assertNotNull(Expr_453_list);
		Assert.assertEquals(1, Expr_453_list.size());
		//453
		final ShiftExpression ShiftExpression_454_Var
		 = (ShiftExpression)Expr_453_list.get(0);
		Assert.assertNotNull(ShiftExpression_454_Var
		);
		final EList<? extends EObject> Expr_454_list = ShiftExpression_454_Var
		.getExpr();
		Assert.assertNotNull(Expr_454_list);
		Assert.assertEquals(1, Expr_454_list.size());
		//454
		final AdditiveExpression AdditiveExpression_455_Var
		 = (AdditiveExpression)Expr_454_list.get(0);
		Assert.assertNotNull(AdditiveExpression_455_Var
		);
		final EList<? extends EObject> Expr_455_list = AdditiveExpression_455_Var
		.getExpr();
		Assert.assertNotNull(Expr_455_list);
		Assert.assertEquals(1, Expr_455_list.size());
		//455
		final MultiplicativeExpression MultiplicativeExpression_456_Var
		 = (MultiplicativeExpression)Expr_455_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_456_Var
		);
		final EList<? extends EObject> Expr_456_list = MultiplicativeExpression_456_Var
		.getExpr();
		Assert.assertNotNull(Expr_456_list);
		Assert.assertEquals(1, Expr_456_list.size());
		//456
		final CastExpression CastExpression_457_Var
		 = (CastExpression)Expr_456_list.get(0);
		Assert.assertNotNull(CastExpression_457_Var
		);
		//457
		final UnaryExpression UnaryExpression_458_Var
		 = (UnaryExpression)CastExpression_457_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_458_Var
		);
		//458
		final PostfixExpression PostfixExpression_459_Var
		 = (PostfixExpression)UnaryExpression_458_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_459_Var
		);
		final EList<? extends EObject> Expr_459_list = PostfixExpression_459_Var
		.getExpr();
		Assert.assertNotNull(Expr_459_list);
		Assert.assertEquals(1, Expr_459_list.size());
		//459
		final PrimaryExpression PrimaryExpression_460_Var
		 = (PrimaryExpression)Expr_459_list.get(0);
		Assert.assertNotNull(PrimaryExpression_460_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_460_Var
		.getId());
		final EList<? extends EObject> Suffix_460_list = PostfixExpression_459_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_460_list);
		Assert.assertEquals(1, Suffix_460_list.size());
		//460
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_461_Var
		 = (PostfixExpressionSuffixDot)Suffix_460_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_461_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_461_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_408_Var
		.getSemi());
		//461
		final Statement Statement_462_Var
		 = (Statement)Statement_107_list.get(6);
		Assert.assertNotNull(Statement_462_Var
		);
		//462
		final ExpressionStatement ExpressionStatement_463_Var
		 = (ExpressionStatement)Statement_462_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_463_Var
		);
		//463
		final Expression Expression_464_Var
		 = (Expression)ExpressionStatement_463_Var
		.getExpression();
		Assert.assertNotNull(Expression_464_Var
		);
		final EList<? extends EObject> ExprExpr_464_list = Expression_464_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_464_list);
		Assert.assertEquals(1, ExprExpr_464_list.size());
		//464
		final AssignmentExpression AssignmentExpression_465_Var
		 = (AssignmentExpression)ExprExpr_464_list.get(0);
		Assert.assertNotNull(AssignmentExpression_465_Var
		);
		//465
		final ConditionalExpression ConditionalExpression_466_Var
		 = (ConditionalExpression)AssignmentExpression_465_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_466_Var
		);
		//466
		final LogicalOrExpression LogicalOrExpression_467_Var
		 = (LogicalOrExpression)ConditionalExpression_466_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_467_Var
		);
		final EList<? extends EObject> Expr_467_list = LogicalOrExpression_467_Var
		.getExpr();
		Assert.assertNotNull(Expr_467_list);
		Assert.assertEquals(1, Expr_467_list.size());
		//467
		final LogicalAndExpression LogicalAndExpression_468_Var
		 = (LogicalAndExpression)Expr_467_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_468_Var
		);
		final EList<? extends EObject> Expr_468_list = LogicalAndExpression_468_Var
		.getExpr();
		Assert.assertNotNull(Expr_468_list);
		Assert.assertEquals(1, Expr_468_list.size());
		//468
		final InclusiveOrExpression InclusiveOrExpression_469_Var
		 = (InclusiveOrExpression)Expr_468_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_469_Var
		);
		final EList<? extends EObject> Expr_469_list = InclusiveOrExpression_469_Var
		.getExpr();
		Assert.assertNotNull(Expr_469_list);
		Assert.assertEquals(1, Expr_469_list.size());
		//469
		final ExclusiveOrExpression ExclusiveOrExpression_470_Var
		 = (ExclusiveOrExpression)Expr_469_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_470_Var
		);
		final EList<? extends EObject> Expr_470_list = ExclusiveOrExpression_470_Var
		.getExpr();
		Assert.assertNotNull(Expr_470_list);
		Assert.assertEquals(1, Expr_470_list.size());
		//470
		final AndExpression AndExpression_471_Var
		 = (AndExpression)Expr_470_list.get(0);
		Assert.assertNotNull(AndExpression_471_Var
		);
		final EList<? extends EObject> Expr_471_list = AndExpression_471_Var
		.getExpr();
		Assert.assertNotNull(Expr_471_list);
		Assert.assertEquals(1, Expr_471_list.size());
		//471
		final EqualityExpression EqualityExpression_472_Var
		 = (EqualityExpression)Expr_471_list.get(0);
		Assert.assertNotNull(EqualityExpression_472_Var
		);
		final EList<? extends EObject> Expr_472_list = EqualityExpression_472_Var
		.getExpr();
		Assert.assertNotNull(Expr_472_list);
		Assert.assertEquals(1, Expr_472_list.size());
		//472
		final RelationalExpression RelationalExpression_473_Var
		 = (RelationalExpression)Expr_472_list.get(0);
		Assert.assertNotNull(RelationalExpression_473_Var
		);
		final EList<? extends EObject> Expr_473_list = RelationalExpression_473_Var
		.getExpr();
		Assert.assertNotNull(Expr_473_list);
		Assert.assertEquals(1, Expr_473_list.size());
		//473
		final ShiftExpression ShiftExpression_474_Var
		 = (ShiftExpression)Expr_473_list.get(0);
		Assert.assertNotNull(ShiftExpression_474_Var
		);
		final EList<? extends EObject> Expr_474_list = ShiftExpression_474_Var
		.getExpr();
		Assert.assertNotNull(Expr_474_list);
		Assert.assertEquals(1, Expr_474_list.size());
		//474
		final AdditiveExpression AdditiveExpression_475_Var
		 = (AdditiveExpression)Expr_474_list.get(0);
		Assert.assertNotNull(AdditiveExpression_475_Var
		);
		final EList<? extends EObject> Expr_475_list = AdditiveExpression_475_Var
		.getExpr();
		Assert.assertNotNull(Expr_475_list);
		Assert.assertEquals(1, Expr_475_list.size());
		//475
		final MultiplicativeExpression MultiplicativeExpression_476_Var
		 = (MultiplicativeExpression)Expr_475_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_476_Var
		);
		final EList<? extends EObject> Expr_476_list = MultiplicativeExpression_476_Var
		.getExpr();
		Assert.assertNotNull(Expr_476_list);
		Assert.assertEquals(1, Expr_476_list.size());
		//476
		final CastExpression CastExpression_477_Var
		 = (CastExpression)Expr_476_list.get(0);
		Assert.assertNotNull(CastExpression_477_Var
		);
		//477
		final UnaryExpression UnaryExpression_478_Var
		 = (UnaryExpression)CastExpression_477_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_478_Var
		);
		//478
		final PostfixExpression PostfixExpression_479_Var
		 = (PostfixExpression)UnaryExpression_478_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_479_Var
		);
		final EList<? extends EObject> Expr_479_list = PostfixExpression_479_Var
		.getExpr();
		Assert.assertNotNull(Expr_479_list);
		Assert.assertEquals(1, Expr_479_list.size());
		//479
		final PrimaryExpression PrimaryExpression_480_Var
		 = (PrimaryExpression)Expr_479_list.get(0);
		Assert.assertNotNull(PrimaryExpression_480_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_480_Var
		.getId());
		final EList<? extends EObject> Suffix_480_list = PostfixExpression_479_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_480_list);
		Assert.assertEquals(1, Suffix_480_list.size());
		//480
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_481_Var
		 = (PostfixExpressionSuffixArgument)Suffix_480_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_481_Var
		);
		//481
		final ArgumentExpressionList ArgumentExpressionList_482_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_481_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_482_Var
		);
		final EList<? extends EObject> Expr_482_list = ArgumentExpressionList_482_Var
		.getExpr();
		Assert.assertNotNull(Expr_482_list);
		Assert.assertEquals(2, Expr_482_list.size());
		//482
		final AssignmentExpression AssignmentExpression_483_Var
		 = (AssignmentExpression)Expr_482_list.get(0);
		Assert.assertNotNull(AssignmentExpression_483_Var
		);
		//483
		final ConditionalExpression ConditionalExpression_484_Var
		 = (ConditionalExpression)AssignmentExpression_483_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_484_Var
		);
		//484
		final LogicalOrExpression LogicalOrExpression_485_Var
		 = (LogicalOrExpression)ConditionalExpression_484_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_485_Var
		);
		final EList<? extends EObject> Expr_485_list = LogicalOrExpression_485_Var
		.getExpr();
		Assert.assertNotNull(Expr_485_list);
		Assert.assertEquals(1, Expr_485_list.size());
		//485
		final LogicalAndExpression LogicalAndExpression_486_Var
		 = (LogicalAndExpression)Expr_485_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_486_Var
		);
		final EList<? extends EObject> Expr_486_list = LogicalAndExpression_486_Var
		.getExpr();
		Assert.assertNotNull(Expr_486_list);
		Assert.assertEquals(1, Expr_486_list.size());
		//486
		final InclusiveOrExpression InclusiveOrExpression_487_Var
		 = (InclusiveOrExpression)Expr_486_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_487_Var
		);
		final EList<? extends EObject> Expr_487_list = InclusiveOrExpression_487_Var
		.getExpr();
		Assert.assertNotNull(Expr_487_list);
		Assert.assertEquals(1, Expr_487_list.size());
		//487
		final ExclusiveOrExpression ExclusiveOrExpression_488_Var
		 = (ExclusiveOrExpression)Expr_487_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_488_Var
		);
		final EList<? extends EObject> Expr_488_list = ExclusiveOrExpression_488_Var
		.getExpr();
		Assert.assertNotNull(Expr_488_list);
		Assert.assertEquals(1, Expr_488_list.size());
		//488
		final AndExpression AndExpression_489_Var
		 = (AndExpression)Expr_488_list.get(0);
		Assert.assertNotNull(AndExpression_489_Var
		);
		final EList<? extends EObject> Expr_489_list = AndExpression_489_Var
		.getExpr();
		Assert.assertNotNull(Expr_489_list);
		Assert.assertEquals(1, Expr_489_list.size());
		//489
		final EqualityExpression EqualityExpression_490_Var
		 = (EqualityExpression)Expr_489_list.get(0);
		Assert.assertNotNull(EqualityExpression_490_Var
		);
		final EList<? extends EObject> Expr_490_list = EqualityExpression_490_Var
		.getExpr();
		Assert.assertNotNull(Expr_490_list);
		Assert.assertEquals(1, Expr_490_list.size());
		//490
		final RelationalExpression RelationalExpression_491_Var
		 = (RelationalExpression)Expr_490_list.get(0);
		Assert.assertNotNull(RelationalExpression_491_Var
		);
		final EList<? extends EObject> Expr_491_list = RelationalExpression_491_Var
		.getExpr();
		Assert.assertNotNull(Expr_491_list);
		Assert.assertEquals(1, Expr_491_list.size());
		//491
		final ShiftExpression ShiftExpression_492_Var
		 = (ShiftExpression)Expr_491_list.get(0);
		Assert.assertNotNull(ShiftExpression_492_Var
		);
		final EList<? extends EObject> Expr_492_list = ShiftExpression_492_Var
		.getExpr();
		Assert.assertNotNull(Expr_492_list);
		Assert.assertEquals(1, Expr_492_list.size());
		//492
		final AdditiveExpression AdditiveExpression_493_Var
		 = (AdditiveExpression)Expr_492_list.get(0);
		Assert.assertNotNull(AdditiveExpression_493_Var
		);
		final EList<? extends EObject> Expr_493_list = AdditiveExpression_493_Var
		.getExpr();
		Assert.assertNotNull(Expr_493_list);
		Assert.assertEquals(1, Expr_493_list.size());
		//493
		final MultiplicativeExpression MultiplicativeExpression_494_Var
		 = (MultiplicativeExpression)Expr_493_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_494_Var
		);
		final EList<? extends EObject> Expr_494_list = MultiplicativeExpression_494_Var
		.getExpr();
		Assert.assertNotNull(Expr_494_list);
		Assert.assertEquals(1, Expr_494_list.size());
		//494
		final CastExpression CastExpression_495_Var
		 = (CastExpression)Expr_494_list.get(0);
		Assert.assertNotNull(CastExpression_495_Var
		);
		//495
		final UnaryExpression UnaryExpression_496_Var
		 = (UnaryExpression)CastExpression_495_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_496_Var
		);
		//496
		final PostfixExpression PostfixExpression_497_Var
		 = (PostfixExpression)UnaryExpression_496_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_497_Var
		);
		final EList<? extends EObject> Expr_497_list = PostfixExpression_497_Var
		.getExpr();
		Assert.assertNotNull(Expr_497_list);
		Assert.assertEquals(1, Expr_497_list.size());
		//497
		final PrimaryExpression PrimaryExpression_498_Var
		 = (PrimaryExpression)Expr_497_list.get(0);
		Assert.assertNotNull(PrimaryExpression_498_Var
		);
		//498
		final Constant2 Constant2_499_Var
		 = (Constant2)PrimaryExpression_498_Var
		.getConst();
		Assert.assertNotNull(Constant2_499_Var
		);
		Assert.assertEquals("\"joe.name=%s\\n\"", Constant2_499_Var
		.getStr());
		//499
		final AssignmentExpression AssignmentExpression_500_Var
		 = (AssignmentExpression)Expr_482_list.get(1);
		Assert.assertNotNull(AssignmentExpression_500_Var
		);
		//500
		final ConditionalExpression ConditionalExpression_501_Var
		 = (ConditionalExpression)AssignmentExpression_500_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_501_Var
		);
		//501
		final LogicalOrExpression LogicalOrExpression_502_Var
		 = (LogicalOrExpression)ConditionalExpression_501_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_502_Var
		);
		final EList<? extends EObject> Expr_502_list = LogicalOrExpression_502_Var
		.getExpr();
		Assert.assertNotNull(Expr_502_list);
		Assert.assertEquals(1, Expr_502_list.size());
		//502
		final LogicalAndExpression LogicalAndExpression_503_Var
		 = (LogicalAndExpression)Expr_502_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_503_Var
		);
		final EList<? extends EObject> Expr_503_list = LogicalAndExpression_503_Var
		.getExpr();
		Assert.assertNotNull(Expr_503_list);
		Assert.assertEquals(1, Expr_503_list.size());
		//503
		final InclusiveOrExpression InclusiveOrExpression_504_Var
		 = (InclusiveOrExpression)Expr_503_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_504_Var
		);
		final EList<? extends EObject> Expr_504_list = InclusiveOrExpression_504_Var
		.getExpr();
		Assert.assertNotNull(Expr_504_list);
		Assert.assertEquals(1, Expr_504_list.size());
		//504
		final ExclusiveOrExpression ExclusiveOrExpression_505_Var
		 = (ExclusiveOrExpression)Expr_504_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_505_Var
		);
		final EList<? extends EObject> Expr_505_list = ExclusiveOrExpression_505_Var
		.getExpr();
		Assert.assertNotNull(Expr_505_list);
		Assert.assertEquals(1, Expr_505_list.size());
		//505
		final AndExpression AndExpression_506_Var
		 = (AndExpression)Expr_505_list.get(0);
		Assert.assertNotNull(AndExpression_506_Var
		);
		final EList<? extends EObject> Expr_506_list = AndExpression_506_Var
		.getExpr();
		Assert.assertNotNull(Expr_506_list);
		Assert.assertEquals(1, Expr_506_list.size());
		//506
		final EqualityExpression EqualityExpression_507_Var
		 = (EqualityExpression)Expr_506_list.get(0);
		Assert.assertNotNull(EqualityExpression_507_Var
		);
		final EList<? extends EObject> Expr_507_list = EqualityExpression_507_Var
		.getExpr();
		Assert.assertNotNull(Expr_507_list);
		Assert.assertEquals(1, Expr_507_list.size());
		//507
		final RelationalExpression RelationalExpression_508_Var
		 = (RelationalExpression)Expr_507_list.get(0);
		Assert.assertNotNull(RelationalExpression_508_Var
		);
		final EList<? extends EObject> Expr_508_list = RelationalExpression_508_Var
		.getExpr();
		Assert.assertNotNull(Expr_508_list);
		Assert.assertEquals(1, Expr_508_list.size());
		//508
		final ShiftExpression ShiftExpression_509_Var
		 = (ShiftExpression)Expr_508_list.get(0);
		Assert.assertNotNull(ShiftExpression_509_Var
		);
		final EList<? extends EObject> Expr_509_list = ShiftExpression_509_Var
		.getExpr();
		Assert.assertNotNull(Expr_509_list);
		Assert.assertEquals(1, Expr_509_list.size());
		//509
		final AdditiveExpression AdditiveExpression_510_Var
		 = (AdditiveExpression)Expr_509_list.get(0);
		Assert.assertNotNull(AdditiveExpression_510_Var
		);
		final EList<? extends EObject> Expr_510_list = AdditiveExpression_510_Var
		.getExpr();
		Assert.assertNotNull(Expr_510_list);
		Assert.assertEquals(1, Expr_510_list.size());
		//510
		final MultiplicativeExpression MultiplicativeExpression_511_Var
		 = (MultiplicativeExpression)Expr_510_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_511_Var
		);
		final EList<? extends EObject> Expr_511_list = MultiplicativeExpression_511_Var
		.getExpr();
		Assert.assertNotNull(Expr_511_list);
		Assert.assertEquals(1, Expr_511_list.size());
		//511
		final CastExpression CastExpression_512_Var
		 = (CastExpression)Expr_511_list.get(0);
		Assert.assertNotNull(CastExpression_512_Var
		);
		//512
		final UnaryExpression UnaryExpression_513_Var
		 = (UnaryExpression)CastExpression_512_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_513_Var
		);
		//513
		final PostfixExpression PostfixExpression_514_Var
		 = (PostfixExpression)UnaryExpression_513_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_514_Var
		);
		final EList<? extends EObject> Expr_514_list = PostfixExpression_514_Var
		.getExpr();
		Assert.assertNotNull(Expr_514_list);
		Assert.assertEquals(1, Expr_514_list.size());
		//514
		final PrimaryExpression PrimaryExpression_515_Var
		 = (PrimaryExpression)Expr_514_list.get(0);
		Assert.assertNotNull(PrimaryExpression_515_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_515_Var
		.getId());
		final EList<? extends EObject> Suffix_515_list = PostfixExpression_514_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_515_list);
		Assert.assertEquals(1, Suffix_515_list.size());
		//515
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_516_Var
		 = (PostfixExpressionSuffixDot)Suffix_515_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_516_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_516_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_463_Var
		.getSemi());
		//516
		final Statement Statement_517_Var
		 = (Statement)Statement_107_list.get(7);
		Assert.assertNotNull(Statement_517_Var
		);
		//517
		final ExpressionStatement ExpressionStatement_518_Var
		 = (ExpressionStatement)Statement_517_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_518_Var
		);
		//518
		final Expression Expression_519_Var
		 = (Expression)ExpressionStatement_518_Var
		.getExpression();
		Assert.assertNotNull(Expression_519_Var
		);
		final EList<? extends EObject> ExprExpr_519_list = Expression_519_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_519_list);
		Assert.assertEquals(1, ExprExpr_519_list.size());
		//519
		final AssignmentExpression AssignmentExpression_520_Var
		 = (AssignmentExpression)ExprExpr_519_list.get(0);
		Assert.assertNotNull(AssignmentExpression_520_Var
		);
		//520
		final ConditionalExpression ConditionalExpression_521_Var
		 = (ConditionalExpression)AssignmentExpression_520_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_521_Var
		);
		//521
		final LogicalOrExpression LogicalOrExpression_522_Var
		 = (LogicalOrExpression)ConditionalExpression_521_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_522_Var
		);
		final EList<? extends EObject> Expr_522_list = LogicalOrExpression_522_Var
		.getExpr();
		Assert.assertNotNull(Expr_522_list);
		Assert.assertEquals(1, Expr_522_list.size());
		//522
		final LogicalAndExpression LogicalAndExpression_523_Var
		 = (LogicalAndExpression)Expr_522_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_523_Var
		);
		final EList<? extends EObject> Expr_523_list = LogicalAndExpression_523_Var
		.getExpr();
		Assert.assertNotNull(Expr_523_list);
		Assert.assertEquals(1, Expr_523_list.size());
		//523
		final InclusiveOrExpression InclusiveOrExpression_524_Var
		 = (InclusiveOrExpression)Expr_523_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_524_Var
		);
		final EList<? extends EObject> Expr_524_list = InclusiveOrExpression_524_Var
		.getExpr();
		Assert.assertNotNull(Expr_524_list);
		Assert.assertEquals(1, Expr_524_list.size());
		//524
		final ExclusiveOrExpression ExclusiveOrExpression_525_Var
		 = (ExclusiveOrExpression)Expr_524_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_525_Var
		);
		final EList<? extends EObject> Expr_525_list = ExclusiveOrExpression_525_Var
		.getExpr();
		Assert.assertNotNull(Expr_525_list);
		Assert.assertEquals(1, Expr_525_list.size());
		//525
		final AndExpression AndExpression_526_Var
		 = (AndExpression)Expr_525_list.get(0);
		Assert.assertNotNull(AndExpression_526_Var
		);
		final EList<? extends EObject> Expr_526_list = AndExpression_526_Var
		.getExpr();
		Assert.assertNotNull(Expr_526_list);
		Assert.assertEquals(1, Expr_526_list.size());
		//526
		final EqualityExpression EqualityExpression_527_Var
		 = (EqualityExpression)Expr_526_list.get(0);
		Assert.assertNotNull(EqualityExpression_527_Var
		);
		final EList<? extends EObject> Expr_527_list = EqualityExpression_527_Var
		.getExpr();
		Assert.assertNotNull(Expr_527_list);
		Assert.assertEquals(1, Expr_527_list.size());
		//527
		final RelationalExpression RelationalExpression_528_Var
		 = (RelationalExpression)Expr_527_list.get(0);
		Assert.assertNotNull(RelationalExpression_528_Var
		);
		final EList<? extends EObject> Expr_528_list = RelationalExpression_528_Var
		.getExpr();
		Assert.assertNotNull(Expr_528_list);
		Assert.assertEquals(1, Expr_528_list.size());
		//528
		final ShiftExpression ShiftExpression_529_Var
		 = (ShiftExpression)Expr_528_list.get(0);
		Assert.assertNotNull(ShiftExpression_529_Var
		);
		final EList<? extends EObject> Expr_529_list = ShiftExpression_529_Var
		.getExpr();
		Assert.assertNotNull(Expr_529_list);
		Assert.assertEquals(1, Expr_529_list.size());
		//529
		final AdditiveExpression AdditiveExpression_530_Var
		 = (AdditiveExpression)Expr_529_list.get(0);
		Assert.assertNotNull(AdditiveExpression_530_Var
		);
		final EList<? extends EObject> Expr_530_list = AdditiveExpression_530_Var
		.getExpr();
		Assert.assertNotNull(Expr_530_list);
		Assert.assertEquals(1, Expr_530_list.size());
		//530
		final MultiplicativeExpression MultiplicativeExpression_531_Var
		 = (MultiplicativeExpression)Expr_530_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_531_Var
		);
		final EList<? extends EObject> Expr_531_list = MultiplicativeExpression_531_Var
		.getExpr();
		Assert.assertNotNull(Expr_531_list);
		Assert.assertEquals(1, Expr_531_list.size());
		//531
		final CastExpression CastExpression_532_Var
		 = (CastExpression)Expr_531_list.get(0);
		Assert.assertNotNull(CastExpression_532_Var
		);
		//532
		final UnaryExpression UnaryExpression_533_Var
		 = (UnaryExpression)CastExpression_532_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_533_Var
		);
		//533
		final PostfixExpression PostfixExpression_534_Var
		 = (PostfixExpression)UnaryExpression_533_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_534_Var
		);
		final EList<? extends EObject> Expr_534_list = PostfixExpression_534_Var
		.getExpr();
		Assert.assertNotNull(Expr_534_list);
		Assert.assertEquals(1, Expr_534_list.size());
		//534
		final PrimaryExpression PrimaryExpression_535_Var
		 = (PrimaryExpression)Expr_534_list.get(0);
		Assert.assertNotNull(PrimaryExpression_535_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_535_Var
		.getId());
		final EList<? extends EObject> Suffix_535_list = PostfixExpression_534_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_535_list);
		Assert.assertEquals(1, Suffix_535_list.size());
		//535
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_536_Var
		 = (PostfixExpressionSuffixArgument)Suffix_535_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_536_Var
		);
		//536
		final ArgumentExpressionList ArgumentExpressionList_537_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_536_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_537_Var
		);
		final EList<? extends EObject> Expr_537_list = ArgumentExpressionList_537_Var
		.getExpr();
		Assert.assertNotNull(Expr_537_list);
		Assert.assertEquals(2, Expr_537_list.size());
		//537
		final AssignmentExpression AssignmentExpression_538_Var
		 = (AssignmentExpression)Expr_537_list.get(0);
		Assert.assertNotNull(AssignmentExpression_538_Var
		);
		//538
		final ConditionalExpression ConditionalExpression_539_Var
		 = (ConditionalExpression)AssignmentExpression_538_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_539_Var
		);
		//539
		final LogicalOrExpression LogicalOrExpression_540_Var
		 = (LogicalOrExpression)ConditionalExpression_539_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_540_Var
		);
		final EList<? extends EObject> Expr_540_list = LogicalOrExpression_540_Var
		.getExpr();
		Assert.assertNotNull(Expr_540_list);
		Assert.assertEquals(1, Expr_540_list.size());
		//540
		final LogicalAndExpression LogicalAndExpression_541_Var
		 = (LogicalAndExpression)Expr_540_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_541_Var
		);
		final EList<? extends EObject> Expr_541_list = LogicalAndExpression_541_Var
		.getExpr();
		Assert.assertNotNull(Expr_541_list);
		Assert.assertEquals(1, Expr_541_list.size());
		//541
		final InclusiveOrExpression InclusiveOrExpression_542_Var
		 = (InclusiveOrExpression)Expr_541_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_542_Var
		);
		final EList<? extends EObject> Expr_542_list = InclusiveOrExpression_542_Var
		.getExpr();
		Assert.assertNotNull(Expr_542_list);
		Assert.assertEquals(1, Expr_542_list.size());
		//542
		final ExclusiveOrExpression ExclusiveOrExpression_543_Var
		 = (ExclusiveOrExpression)Expr_542_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_543_Var
		);
		final EList<? extends EObject> Expr_543_list = ExclusiveOrExpression_543_Var
		.getExpr();
		Assert.assertNotNull(Expr_543_list);
		Assert.assertEquals(1, Expr_543_list.size());
		//543
		final AndExpression AndExpression_544_Var
		 = (AndExpression)Expr_543_list.get(0);
		Assert.assertNotNull(AndExpression_544_Var
		);
		final EList<? extends EObject> Expr_544_list = AndExpression_544_Var
		.getExpr();
		Assert.assertNotNull(Expr_544_list);
		Assert.assertEquals(1, Expr_544_list.size());
		//544
		final EqualityExpression EqualityExpression_545_Var
		 = (EqualityExpression)Expr_544_list.get(0);
		Assert.assertNotNull(EqualityExpression_545_Var
		);
		final EList<? extends EObject> Expr_545_list = EqualityExpression_545_Var
		.getExpr();
		Assert.assertNotNull(Expr_545_list);
		Assert.assertEquals(1, Expr_545_list.size());
		//545
		final RelationalExpression RelationalExpression_546_Var
		 = (RelationalExpression)Expr_545_list.get(0);
		Assert.assertNotNull(RelationalExpression_546_Var
		);
		final EList<? extends EObject> Expr_546_list = RelationalExpression_546_Var
		.getExpr();
		Assert.assertNotNull(Expr_546_list);
		Assert.assertEquals(1, Expr_546_list.size());
		//546
		final ShiftExpression ShiftExpression_547_Var
		 = (ShiftExpression)Expr_546_list.get(0);
		Assert.assertNotNull(ShiftExpression_547_Var
		);
		final EList<? extends EObject> Expr_547_list = ShiftExpression_547_Var
		.getExpr();
		Assert.assertNotNull(Expr_547_list);
		Assert.assertEquals(1, Expr_547_list.size());
		//547
		final AdditiveExpression AdditiveExpression_548_Var
		 = (AdditiveExpression)Expr_547_list.get(0);
		Assert.assertNotNull(AdditiveExpression_548_Var
		);
		final EList<? extends EObject> Expr_548_list = AdditiveExpression_548_Var
		.getExpr();
		Assert.assertNotNull(Expr_548_list);
		Assert.assertEquals(1, Expr_548_list.size());
		//548
		final MultiplicativeExpression MultiplicativeExpression_549_Var
		 = (MultiplicativeExpression)Expr_548_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_549_Var
		);
		final EList<? extends EObject> Expr_549_list = MultiplicativeExpression_549_Var
		.getExpr();
		Assert.assertNotNull(Expr_549_list);
		Assert.assertEquals(1, Expr_549_list.size());
		//549
		final CastExpression CastExpression_550_Var
		 = (CastExpression)Expr_549_list.get(0);
		Assert.assertNotNull(CastExpression_550_Var
		);
		//550
		final UnaryExpression UnaryExpression_551_Var
		 = (UnaryExpression)CastExpression_550_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_551_Var
		);
		//551
		final PostfixExpression PostfixExpression_552_Var
		 = (PostfixExpression)UnaryExpression_551_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_552_Var
		);
		final EList<? extends EObject> Expr_552_list = PostfixExpression_552_Var
		.getExpr();
		Assert.assertNotNull(Expr_552_list);
		Assert.assertEquals(1, Expr_552_list.size());
		//552
		final PrimaryExpression PrimaryExpression_553_Var
		 = (PrimaryExpression)Expr_552_list.get(0);
		Assert.assertNotNull(PrimaryExpression_553_Var
		);
		//553
		final Constant2 Constant2_554_Var
		 = (Constant2)PrimaryExpression_553_Var
		.getConst();
		Assert.assertNotNull(Constant2_554_Var
		);
		Assert.assertEquals("\"phil.id=%d\\n\"", Constant2_554_Var
		.getStr());
		//554
		final AssignmentExpression AssignmentExpression_555_Var
		 = (AssignmentExpression)Expr_537_list.get(1);
		Assert.assertNotNull(AssignmentExpression_555_Var
		);
		//555
		final ConditionalExpression ConditionalExpression_556_Var
		 = (ConditionalExpression)AssignmentExpression_555_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_556_Var
		);
		//556
		final LogicalOrExpression LogicalOrExpression_557_Var
		 = (LogicalOrExpression)ConditionalExpression_556_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_557_Var
		);
		final EList<? extends EObject> Expr_557_list = LogicalOrExpression_557_Var
		.getExpr();
		Assert.assertNotNull(Expr_557_list);
		Assert.assertEquals(1, Expr_557_list.size());
		//557
		final LogicalAndExpression LogicalAndExpression_558_Var
		 = (LogicalAndExpression)Expr_557_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_558_Var
		);
		final EList<? extends EObject> Expr_558_list = LogicalAndExpression_558_Var
		.getExpr();
		Assert.assertNotNull(Expr_558_list);
		Assert.assertEquals(1, Expr_558_list.size());
		//558
		final InclusiveOrExpression InclusiveOrExpression_559_Var
		 = (InclusiveOrExpression)Expr_558_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_559_Var
		);
		final EList<? extends EObject> Expr_559_list = InclusiveOrExpression_559_Var
		.getExpr();
		Assert.assertNotNull(Expr_559_list);
		Assert.assertEquals(1, Expr_559_list.size());
		//559
		final ExclusiveOrExpression ExclusiveOrExpression_560_Var
		 = (ExclusiveOrExpression)Expr_559_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_560_Var
		);
		final EList<? extends EObject> Expr_560_list = ExclusiveOrExpression_560_Var
		.getExpr();
		Assert.assertNotNull(Expr_560_list);
		Assert.assertEquals(1, Expr_560_list.size());
		//560
		final AndExpression AndExpression_561_Var
		 = (AndExpression)Expr_560_list.get(0);
		Assert.assertNotNull(AndExpression_561_Var
		);
		final EList<? extends EObject> Expr_561_list = AndExpression_561_Var
		.getExpr();
		Assert.assertNotNull(Expr_561_list);
		Assert.assertEquals(1, Expr_561_list.size());
		//561
		final EqualityExpression EqualityExpression_562_Var
		 = (EqualityExpression)Expr_561_list.get(0);
		Assert.assertNotNull(EqualityExpression_562_Var
		);
		final EList<? extends EObject> Expr_562_list = EqualityExpression_562_Var
		.getExpr();
		Assert.assertNotNull(Expr_562_list);
		Assert.assertEquals(1, Expr_562_list.size());
		//562
		final RelationalExpression RelationalExpression_563_Var
		 = (RelationalExpression)Expr_562_list.get(0);
		Assert.assertNotNull(RelationalExpression_563_Var
		);
		final EList<? extends EObject> Expr_563_list = RelationalExpression_563_Var
		.getExpr();
		Assert.assertNotNull(Expr_563_list);
		Assert.assertEquals(1, Expr_563_list.size());
		//563
		final ShiftExpression ShiftExpression_564_Var
		 = (ShiftExpression)Expr_563_list.get(0);
		Assert.assertNotNull(ShiftExpression_564_Var
		);
		final EList<? extends EObject> Expr_564_list = ShiftExpression_564_Var
		.getExpr();
		Assert.assertNotNull(Expr_564_list);
		Assert.assertEquals(1, Expr_564_list.size());
		//564
		final AdditiveExpression AdditiveExpression_565_Var
		 = (AdditiveExpression)Expr_564_list.get(0);
		Assert.assertNotNull(AdditiveExpression_565_Var
		);
		final EList<? extends EObject> Expr_565_list = AdditiveExpression_565_Var
		.getExpr();
		Assert.assertNotNull(Expr_565_list);
		Assert.assertEquals(1, Expr_565_list.size());
		//565
		final MultiplicativeExpression MultiplicativeExpression_566_Var
		 = (MultiplicativeExpression)Expr_565_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_566_Var
		);
		final EList<? extends EObject> Expr_566_list = MultiplicativeExpression_566_Var
		.getExpr();
		Assert.assertNotNull(Expr_566_list);
		Assert.assertEquals(1, Expr_566_list.size());
		//566
		final CastExpression CastExpression_567_Var
		 = (CastExpression)Expr_566_list.get(0);
		Assert.assertNotNull(CastExpression_567_Var
		);
		//567
		final UnaryExpression UnaryExpression_568_Var
		 = (UnaryExpression)CastExpression_567_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_568_Var
		);
		//568
		final PostfixExpression PostfixExpression_569_Var
		 = (PostfixExpression)UnaryExpression_568_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_569_Var
		);
		final EList<? extends EObject> Expr_569_list = PostfixExpression_569_Var
		.getExpr();
		Assert.assertNotNull(Expr_569_list);
		Assert.assertEquals(1, Expr_569_list.size());
		//569
		final PrimaryExpression PrimaryExpression_570_Var
		 = (PrimaryExpression)Expr_569_list.get(0);
		Assert.assertNotNull(PrimaryExpression_570_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_570_Var
		.getId());
		final EList<? extends EObject> Suffix_570_list = PostfixExpression_569_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_570_list);
		Assert.assertEquals(1, Suffix_570_list.size());
		//570
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_571_Var
		 = (PostfixExpressionSuffixDot)Suffix_570_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_571_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_571_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_518_Var
		.getSemi());
		//571
		final Statement Statement_572_Var
		 = (Statement)Statement_107_list.get(8);
		Assert.assertNotNull(Statement_572_Var
		);
		//572
		final ExpressionStatement ExpressionStatement_573_Var
		 = (ExpressionStatement)Statement_572_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_573_Var
		);
		//573
		final Expression Expression_574_Var
		 = (Expression)ExpressionStatement_573_Var
		.getExpression();
		Assert.assertNotNull(Expression_574_Var
		);
		final EList<? extends EObject> ExprExpr_574_list = Expression_574_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_574_list);
		Assert.assertEquals(1, ExprExpr_574_list.size());
		//574
		final AssignmentExpression AssignmentExpression_575_Var
		 = (AssignmentExpression)ExprExpr_574_list.get(0);
		Assert.assertNotNull(AssignmentExpression_575_Var
		);
		//575
		final ConditionalExpression ConditionalExpression_576_Var
		 = (ConditionalExpression)AssignmentExpression_575_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_576_Var
		);
		//576
		final LogicalOrExpression LogicalOrExpression_577_Var
		 = (LogicalOrExpression)ConditionalExpression_576_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_577_Var
		);
		final EList<? extends EObject> Expr_577_list = LogicalOrExpression_577_Var
		.getExpr();
		Assert.assertNotNull(Expr_577_list);
		Assert.assertEquals(1, Expr_577_list.size());
		//577
		final LogicalAndExpression LogicalAndExpression_578_Var
		 = (LogicalAndExpression)Expr_577_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_578_Var
		);
		final EList<? extends EObject> Expr_578_list = LogicalAndExpression_578_Var
		.getExpr();
		Assert.assertNotNull(Expr_578_list);
		Assert.assertEquals(1, Expr_578_list.size());
		//578
		final InclusiveOrExpression InclusiveOrExpression_579_Var
		 = (InclusiveOrExpression)Expr_578_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_579_Var
		);
		final EList<? extends EObject> Expr_579_list = InclusiveOrExpression_579_Var
		.getExpr();
		Assert.assertNotNull(Expr_579_list);
		Assert.assertEquals(1, Expr_579_list.size());
		//579
		final ExclusiveOrExpression ExclusiveOrExpression_580_Var
		 = (ExclusiveOrExpression)Expr_579_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_580_Var
		);
		final EList<? extends EObject> Expr_580_list = ExclusiveOrExpression_580_Var
		.getExpr();
		Assert.assertNotNull(Expr_580_list);
		Assert.assertEquals(1, Expr_580_list.size());
		//580
		final AndExpression AndExpression_581_Var
		 = (AndExpression)Expr_580_list.get(0);
		Assert.assertNotNull(AndExpression_581_Var
		);
		final EList<? extends EObject> Expr_581_list = AndExpression_581_Var
		.getExpr();
		Assert.assertNotNull(Expr_581_list);
		Assert.assertEquals(1, Expr_581_list.size());
		//581
		final EqualityExpression EqualityExpression_582_Var
		 = (EqualityExpression)Expr_581_list.get(0);
		Assert.assertNotNull(EqualityExpression_582_Var
		);
		final EList<? extends EObject> Expr_582_list = EqualityExpression_582_Var
		.getExpr();
		Assert.assertNotNull(Expr_582_list);
		Assert.assertEquals(1, Expr_582_list.size());
		//582
		final RelationalExpression RelationalExpression_583_Var
		 = (RelationalExpression)Expr_582_list.get(0);
		Assert.assertNotNull(RelationalExpression_583_Var
		);
		final EList<? extends EObject> Expr_583_list = RelationalExpression_583_Var
		.getExpr();
		Assert.assertNotNull(Expr_583_list);
		Assert.assertEquals(1, Expr_583_list.size());
		//583
		final ShiftExpression ShiftExpression_584_Var
		 = (ShiftExpression)Expr_583_list.get(0);
		Assert.assertNotNull(ShiftExpression_584_Var
		);
		final EList<? extends EObject> Expr_584_list = ShiftExpression_584_Var
		.getExpr();
		Assert.assertNotNull(Expr_584_list);
		Assert.assertEquals(1, Expr_584_list.size());
		//584
		final AdditiveExpression AdditiveExpression_585_Var
		 = (AdditiveExpression)Expr_584_list.get(0);
		Assert.assertNotNull(AdditiveExpression_585_Var
		);
		final EList<? extends EObject> Expr_585_list = AdditiveExpression_585_Var
		.getExpr();
		Assert.assertNotNull(Expr_585_list);
		Assert.assertEquals(1, Expr_585_list.size());
		//585
		final MultiplicativeExpression MultiplicativeExpression_586_Var
		 = (MultiplicativeExpression)Expr_585_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_586_Var
		);
		final EList<? extends EObject> Expr_586_list = MultiplicativeExpression_586_Var
		.getExpr();
		Assert.assertNotNull(Expr_586_list);
		Assert.assertEquals(1, Expr_586_list.size());
		//586
		final CastExpression CastExpression_587_Var
		 = (CastExpression)Expr_586_list.get(0);
		Assert.assertNotNull(CastExpression_587_Var
		);
		//587
		final UnaryExpression UnaryExpression_588_Var
		 = (UnaryExpression)CastExpression_587_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_588_Var
		);
		//588
		final PostfixExpression PostfixExpression_589_Var
		 = (PostfixExpression)UnaryExpression_588_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_589_Var
		);
		final EList<? extends EObject> Expr_589_list = PostfixExpression_589_Var
		.getExpr();
		Assert.assertNotNull(Expr_589_list);
		Assert.assertEquals(1, Expr_589_list.size());
		//589
		final PrimaryExpression PrimaryExpression_590_Var
		 = (PrimaryExpression)Expr_589_list.get(0);
		Assert.assertNotNull(PrimaryExpression_590_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_590_Var
		.getId());
		final EList<? extends EObject> Suffix_590_list = PostfixExpression_589_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_590_list);
		Assert.assertEquals(1, Suffix_590_list.size());
		//590
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_591_Var
		 = (PostfixExpressionSuffixArgument)Suffix_590_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_591_Var
		);
		//591
		final ArgumentExpressionList ArgumentExpressionList_592_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_591_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_592_Var
		);
		final EList<? extends EObject> Expr_592_list = ArgumentExpressionList_592_Var
		.getExpr();
		Assert.assertNotNull(Expr_592_list);
		Assert.assertEquals(2, Expr_592_list.size());
		//592
		final AssignmentExpression AssignmentExpression_593_Var
		 = (AssignmentExpression)Expr_592_list.get(0);
		Assert.assertNotNull(AssignmentExpression_593_Var
		);
		//593
		final ConditionalExpression ConditionalExpression_594_Var
		 = (ConditionalExpression)AssignmentExpression_593_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_594_Var
		);
		//594
		final LogicalOrExpression LogicalOrExpression_595_Var
		 = (LogicalOrExpression)ConditionalExpression_594_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_595_Var
		);
		final EList<? extends EObject> Expr_595_list = LogicalOrExpression_595_Var
		.getExpr();
		Assert.assertNotNull(Expr_595_list);
		Assert.assertEquals(1, Expr_595_list.size());
		//595
		final LogicalAndExpression LogicalAndExpression_596_Var
		 = (LogicalAndExpression)Expr_595_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_596_Var
		);
		final EList<? extends EObject> Expr_596_list = LogicalAndExpression_596_Var
		.getExpr();
		Assert.assertNotNull(Expr_596_list);
		Assert.assertEquals(1, Expr_596_list.size());
		//596
		final InclusiveOrExpression InclusiveOrExpression_597_Var
		 = (InclusiveOrExpression)Expr_596_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_597_Var
		);
		final EList<? extends EObject> Expr_597_list = InclusiveOrExpression_597_Var
		.getExpr();
		Assert.assertNotNull(Expr_597_list);
		Assert.assertEquals(1, Expr_597_list.size());
		//597
		final ExclusiveOrExpression ExclusiveOrExpression_598_Var
		 = (ExclusiveOrExpression)Expr_597_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_598_Var
		);
		final EList<? extends EObject> Expr_598_list = ExclusiveOrExpression_598_Var
		.getExpr();
		Assert.assertNotNull(Expr_598_list);
		Assert.assertEquals(1, Expr_598_list.size());
		//598
		final AndExpression AndExpression_599_Var
		 = (AndExpression)Expr_598_list.get(0);
		Assert.assertNotNull(AndExpression_599_Var
		);
		final EList<? extends EObject> Expr_599_list = AndExpression_599_Var
		.getExpr();
		Assert.assertNotNull(Expr_599_list);
		Assert.assertEquals(1, Expr_599_list.size());
		//599
		final EqualityExpression EqualityExpression_600_Var
		 = (EqualityExpression)Expr_599_list.get(0);
		Assert.assertNotNull(EqualityExpression_600_Var
		);
		final EList<? extends EObject> Expr_600_list = EqualityExpression_600_Var
		.getExpr();
		Assert.assertNotNull(Expr_600_list);
		Assert.assertEquals(1, Expr_600_list.size());
		//600
		final RelationalExpression RelationalExpression_601_Var
		 = (RelationalExpression)Expr_600_list.get(0);
		Assert.assertNotNull(RelationalExpression_601_Var
		);
		final EList<? extends EObject> Expr_601_list = RelationalExpression_601_Var
		.getExpr();
		Assert.assertNotNull(Expr_601_list);
		Assert.assertEquals(1, Expr_601_list.size());
		//601
		final ShiftExpression ShiftExpression_602_Var
		 = (ShiftExpression)Expr_601_list.get(0);
		Assert.assertNotNull(ShiftExpression_602_Var
		);
		final EList<? extends EObject> Expr_602_list = ShiftExpression_602_Var
		.getExpr();
		Assert.assertNotNull(Expr_602_list);
		Assert.assertEquals(1, Expr_602_list.size());
		//602
		final AdditiveExpression AdditiveExpression_603_Var
		 = (AdditiveExpression)Expr_602_list.get(0);
		Assert.assertNotNull(AdditiveExpression_603_Var
		);
		final EList<? extends EObject> Expr_603_list = AdditiveExpression_603_Var
		.getExpr();
		Assert.assertNotNull(Expr_603_list);
		Assert.assertEquals(1, Expr_603_list.size());
		//603
		final MultiplicativeExpression MultiplicativeExpression_604_Var
		 = (MultiplicativeExpression)Expr_603_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_604_Var
		);
		final EList<? extends EObject> Expr_604_list = MultiplicativeExpression_604_Var
		.getExpr();
		Assert.assertNotNull(Expr_604_list);
		Assert.assertEquals(1, Expr_604_list.size());
		//604
		final CastExpression CastExpression_605_Var
		 = (CastExpression)Expr_604_list.get(0);
		Assert.assertNotNull(CastExpression_605_Var
		);
		//605
		final UnaryExpression UnaryExpression_606_Var
		 = (UnaryExpression)CastExpression_605_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_606_Var
		);
		//606
		final PostfixExpression PostfixExpression_607_Var
		 = (PostfixExpression)UnaryExpression_606_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_607_Var
		);
		final EList<? extends EObject> Expr_607_list = PostfixExpression_607_Var
		.getExpr();
		Assert.assertNotNull(Expr_607_list);
		Assert.assertEquals(1, Expr_607_list.size());
		//607
		final PrimaryExpression PrimaryExpression_608_Var
		 = (PrimaryExpression)Expr_607_list.get(0);
		Assert.assertNotNull(PrimaryExpression_608_Var
		);
		//608
		final Constant2 Constant2_609_Var
		 = (Constant2)PrimaryExpression_608_Var
		.getConst();
		Assert.assertNotNull(Constant2_609_Var
		);
		Assert.assertEquals("\"phil.name=%s\\n\"", Constant2_609_Var
		.getStr());
		//609
		final AssignmentExpression AssignmentExpression_610_Var
		 = (AssignmentExpression)Expr_592_list.get(1);
		Assert.assertNotNull(AssignmentExpression_610_Var
		);
		//610
		final ConditionalExpression ConditionalExpression_611_Var
		 = (ConditionalExpression)AssignmentExpression_610_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_611_Var
		);
		//611
		final LogicalOrExpression LogicalOrExpression_612_Var
		 = (LogicalOrExpression)ConditionalExpression_611_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_612_Var
		);
		final EList<? extends EObject> Expr_612_list = LogicalOrExpression_612_Var
		.getExpr();
		Assert.assertNotNull(Expr_612_list);
		Assert.assertEquals(1, Expr_612_list.size());
		//612
		final LogicalAndExpression LogicalAndExpression_613_Var
		 = (LogicalAndExpression)Expr_612_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_613_Var
		);
		final EList<? extends EObject> Expr_613_list = LogicalAndExpression_613_Var
		.getExpr();
		Assert.assertNotNull(Expr_613_list);
		Assert.assertEquals(1, Expr_613_list.size());
		//613
		final InclusiveOrExpression InclusiveOrExpression_614_Var
		 = (InclusiveOrExpression)Expr_613_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_614_Var
		);
		final EList<? extends EObject> Expr_614_list = InclusiveOrExpression_614_Var
		.getExpr();
		Assert.assertNotNull(Expr_614_list);
		Assert.assertEquals(1, Expr_614_list.size());
		//614
		final ExclusiveOrExpression ExclusiveOrExpression_615_Var
		 = (ExclusiveOrExpression)Expr_614_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_615_Var
		);
		final EList<? extends EObject> Expr_615_list = ExclusiveOrExpression_615_Var
		.getExpr();
		Assert.assertNotNull(Expr_615_list);
		Assert.assertEquals(1, Expr_615_list.size());
		//615
		final AndExpression AndExpression_616_Var
		 = (AndExpression)Expr_615_list.get(0);
		Assert.assertNotNull(AndExpression_616_Var
		);
		final EList<? extends EObject> Expr_616_list = AndExpression_616_Var
		.getExpr();
		Assert.assertNotNull(Expr_616_list);
		Assert.assertEquals(1, Expr_616_list.size());
		//616
		final EqualityExpression EqualityExpression_617_Var
		 = (EqualityExpression)Expr_616_list.get(0);
		Assert.assertNotNull(EqualityExpression_617_Var
		);
		final EList<? extends EObject> Expr_617_list = EqualityExpression_617_Var
		.getExpr();
		Assert.assertNotNull(Expr_617_list);
		Assert.assertEquals(1, Expr_617_list.size());
		//617
		final RelationalExpression RelationalExpression_618_Var
		 = (RelationalExpression)Expr_617_list.get(0);
		Assert.assertNotNull(RelationalExpression_618_Var
		);
		final EList<? extends EObject> Expr_618_list = RelationalExpression_618_Var
		.getExpr();
		Assert.assertNotNull(Expr_618_list);
		Assert.assertEquals(1, Expr_618_list.size());
		//618
		final ShiftExpression ShiftExpression_619_Var
		 = (ShiftExpression)Expr_618_list.get(0);
		Assert.assertNotNull(ShiftExpression_619_Var
		);
		final EList<? extends EObject> Expr_619_list = ShiftExpression_619_Var
		.getExpr();
		Assert.assertNotNull(Expr_619_list);
		Assert.assertEquals(1, Expr_619_list.size());
		//619
		final AdditiveExpression AdditiveExpression_620_Var
		 = (AdditiveExpression)Expr_619_list.get(0);
		Assert.assertNotNull(AdditiveExpression_620_Var
		);
		final EList<? extends EObject> Expr_620_list = AdditiveExpression_620_Var
		.getExpr();
		Assert.assertNotNull(Expr_620_list);
		Assert.assertEquals(1, Expr_620_list.size());
		//620
		final MultiplicativeExpression MultiplicativeExpression_621_Var
		 = (MultiplicativeExpression)Expr_620_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_621_Var
		);
		final EList<? extends EObject> Expr_621_list = MultiplicativeExpression_621_Var
		.getExpr();
		Assert.assertNotNull(Expr_621_list);
		Assert.assertEquals(1, Expr_621_list.size());
		//621
		final CastExpression CastExpression_622_Var
		 = (CastExpression)Expr_621_list.get(0);
		Assert.assertNotNull(CastExpression_622_Var
		);
		//622
		final UnaryExpression UnaryExpression_623_Var
		 = (UnaryExpression)CastExpression_622_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_623_Var
		);
		//623
		final PostfixExpression PostfixExpression_624_Var
		 = (PostfixExpression)UnaryExpression_623_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_624_Var
		);
		final EList<? extends EObject> Expr_624_list = PostfixExpression_624_Var
		.getExpr();
		Assert.assertNotNull(Expr_624_list);
		Assert.assertEquals(1, Expr_624_list.size());
		//624
		final PrimaryExpression PrimaryExpression_625_Var
		 = (PrimaryExpression)Expr_624_list.get(0);
		Assert.assertNotNull(PrimaryExpression_625_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_625_Var
		.getId());
		final EList<? extends EObject> Suffix_625_list = PostfixExpression_624_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_625_list);
		Assert.assertEquals(1, Suffix_625_list.size());
		//625
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_626_Var
		 = (PostfixExpressionSuffixDot)Suffix_625_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_626_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_626_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_573_Var
		.getSemi());
		//626
		final Statement Statement_627_Var
		 = (Statement)Statement_107_list.get(9);
		Assert.assertNotNull(Statement_627_Var
		);
		//627
		final JumpStatement JumpStatement_628_Var
		 = (JumpStatement)Statement_627_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_628_Var
		);
		//628
		final Expression Expression_629_Var
		 = (Expression)JumpStatement_628_Var
		.getExpr();
		Assert.assertNotNull(Expression_629_Var
		);
		final EList<? extends EObject> ExprExpr_629_list = Expression_629_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_629_list);
		Assert.assertEquals(1, ExprExpr_629_list.size());
		//629
		final AssignmentExpression AssignmentExpression_630_Var
		 = (AssignmentExpression)ExprExpr_629_list.get(0);
		Assert.assertNotNull(AssignmentExpression_630_Var
		);
		//630
		final ConditionalExpression ConditionalExpression_631_Var
		 = (ConditionalExpression)AssignmentExpression_630_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_631_Var
		);
		//631
		final LogicalOrExpression LogicalOrExpression_632_Var
		 = (LogicalOrExpression)ConditionalExpression_631_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_632_Var
		);
		final EList<? extends EObject> Expr_632_list = LogicalOrExpression_632_Var
		.getExpr();
		Assert.assertNotNull(Expr_632_list);
		Assert.assertEquals(1, Expr_632_list.size());
		//632
		final LogicalAndExpression LogicalAndExpression_633_Var
		 = (LogicalAndExpression)Expr_632_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_633_Var
		);
		final EList<? extends EObject> Expr_633_list = LogicalAndExpression_633_Var
		.getExpr();
		Assert.assertNotNull(Expr_633_list);
		Assert.assertEquals(1, Expr_633_list.size());
		//633
		final InclusiveOrExpression InclusiveOrExpression_634_Var
		 = (InclusiveOrExpression)Expr_633_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_634_Var
		);
		final EList<? extends EObject> Expr_634_list = InclusiveOrExpression_634_Var
		.getExpr();
		Assert.assertNotNull(Expr_634_list);
		Assert.assertEquals(1, Expr_634_list.size());
		//634
		final ExclusiveOrExpression ExclusiveOrExpression_635_Var
		 = (ExclusiveOrExpression)Expr_634_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_635_Var
		);
		final EList<? extends EObject> Expr_635_list = ExclusiveOrExpression_635_Var
		.getExpr();
		Assert.assertNotNull(Expr_635_list);
		Assert.assertEquals(1, Expr_635_list.size());
		//635
		final AndExpression AndExpression_636_Var
		 = (AndExpression)Expr_635_list.get(0);
		Assert.assertNotNull(AndExpression_636_Var
		);
		final EList<? extends EObject> Expr_636_list = AndExpression_636_Var
		.getExpr();
		Assert.assertNotNull(Expr_636_list);
		Assert.assertEquals(1, Expr_636_list.size());
		//636
		final EqualityExpression EqualityExpression_637_Var
		 = (EqualityExpression)Expr_636_list.get(0);
		Assert.assertNotNull(EqualityExpression_637_Var
		);
		final EList<? extends EObject> Expr_637_list = EqualityExpression_637_Var
		.getExpr();
		Assert.assertNotNull(Expr_637_list);
		Assert.assertEquals(1, Expr_637_list.size());
		//637
		final RelationalExpression RelationalExpression_638_Var
		 = (RelationalExpression)Expr_637_list.get(0);
		Assert.assertNotNull(RelationalExpression_638_Var
		);
		final EList<? extends EObject> Expr_638_list = RelationalExpression_638_Var
		.getExpr();
		Assert.assertNotNull(Expr_638_list);
		Assert.assertEquals(1, Expr_638_list.size());
		//638
		final ShiftExpression ShiftExpression_639_Var
		 = (ShiftExpression)Expr_638_list.get(0);
		Assert.assertNotNull(ShiftExpression_639_Var
		);
		final EList<? extends EObject> Expr_639_list = ShiftExpression_639_Var
		.getExpr();
		Assert.assertNotNull(Expr_639_list);
		Assert.assertEquals(1, Expr_639_list.size());
		//639
		final AdditiveExpression AdditiveExpression_640_Var
		 = (AdditiveExpression)Expr_639_list.get(0);
		Assert.assertNotNull(AdditiveExpression_640_Var
		);
		final EList<? extends EObject> Expr_640_list = AdditiveExpression_640_Var
		.getExpr();
		Assert.assertNotNull(Expr_640_list);
		Assert.assertEquals(1, Expr_640_list.size());
		//640
		final MultiplicativeExpression MultiplicativeExpression_641_Var
		 = (MultiplicativeExpression)Expr_640_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_641_Var
		);
		final EList<? extends EObject> Expr_641_list = MultiplicativeExpression_641_Var
		.getExpr();
		Assert.assertNotNull(Expr_641_list);
		Assert.assertEquals(1, Expr_641_list.size());
		//641
		final CastExpression CastExpression_642_Var
		 = (CastExpression)Expr_641_list.get(0);
		Assert.assertNotNull(CastExpression_642_Var
		);
		//642
		final UnaryExpression UnaryExpression_643_Var
		 = (UnaryExpression)CastExpression_642_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_643_Var
		);
		//643
		final PostfixExpression PostfixExpression_644_Var
		 = (PostfixExpression)UnaryExpression_643_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_644_Var
		);
		final EList<? extends EObject> Expr_644_list = PostfixExpression_644_Var
		.getExpr();
		Assert.assertNotNull(Expr_644_list);
		Assert.assertEquals(1, Expr_644_list.size());
		//644
		final PrimaryExpression PrimaryExpression_645_Var
		 = (PrimaryExpression)Expr_644_list.get(0);
		Assert.assertNotNull(PrimaryExpression_645_Var
		);
		//645
		final Constant2 Constant2_646_Var
		 = (Constant2)PrimaryExpression_645_Var
		.getConst();
		Assert.assertNotNull(Constant2_646_Var
		);
		Assert.assertEquals("0", Constant2_646_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_628_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_628_Var
		.getSemi());
	}
	
	@Test
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
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0037_Struct.c");
		final String expected = this.getTextFromFile(
			"res/Test0037_Struct.c"
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


