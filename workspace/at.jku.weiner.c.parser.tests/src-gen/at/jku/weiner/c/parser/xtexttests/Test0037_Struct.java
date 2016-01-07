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
		Assert.assertEquals("employee", StructOrUnionSpecifier_4_Var
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
		Assert.assertEquals(2, StructDeclaration_6_list.size());
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
		Assert.assertEquals("id", DirectDeclarator_13_Var
		.getId());
		//13
		final StructDeclaration StructDeclaration_14_Var
		 = (StructDeclaration)StructDeclaration_6_list.get(1);
		Assert.assertNotNull(StructDeclaration_14_Var
		);
		//14
		final SpecifierQualifierList SpecifierQualifierList_15_Var
		 = (SpecifierQualifierList)StructDeclaration_14_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_15_Var
		);
		final EList<? extends EObject> TypeSpecifier_15_list = SpecifierQualifierList_15_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_15_list);
		Assert.assertEquals(1, TypeSpecifier_15_list.size());
		//15
		final TypeSpecifier TypeSpecifier_16_Var
		 = (TypeSpecifier)TypeSpecifier_15_list.get(0);
		Assert.assertNotNull(TypeSpecifier_16_Var
		);
		Assert.assertEquals("char", TypeSpecifier_16_Var
		.getName());
		//16
		final StructDeclaratorList StructDeclaratorList_17_Var
		 = (StructDeclaratorList)StructDeclaration_14_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_17_Var
		);
		final EList<? extends EObject> StructDeclarator_17_list = StructDeclaratorList_17_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_17_list);
		Assert.assertEquals(1, StructDeclarator_17_list.size());
		//17
		final StructDeclarator StructDeclarator_18_Var
		 = (StructDeclarator)StructDeclarator_17_list.get(0);
		Assert.assertNotNull(StructDeclarator_18_Var
		);
		//18
		final Declarator Declarator_19_Var
		 = (Declarator)StructDeclarator_18_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_19_Var
		);
		//19
		final DirectDeclarator DirectDeclarator_20_Var
		 = (DirectDeclarator)Declarator_19_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_20_Var
		);
		Assert.assertEquals("name", DirectDeclarator_20_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_20_list = DirectDeclarator_20_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_20_list);
		Assert.assertEquals(1, DeclaratorSuffix_20_list.size());
		//20
		final DeclaratorSuffix DeclaratorSuffix_21_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_20_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_21_Var
		);
		//21
		final AssignmentExpression AssignmentExpression_22_Var
		 = (AssignmentExpression)DeclaratorSuffix_21_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_22_Var
		);
		//22
		final ConditionalExpression ConditionalExpression_23_Var
		 = (ConditionalExpression)AssignmentExpression_22_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_23_Var
		);
		//23
		final LogicalOrExpression LogicalOrExpression_24_Var
		 = (LogicalOrExpression)ConditionalExpression_23_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = LogicalOrExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final LogicalAndExpression LogicalAndExpression_25_Var
		 = (LogicalAndExpression)Expr_24_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = LogicalAndExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final InclusiveOrExpression InclusiveOrExpression_26_Var
		 = (InclusiveOrExpression)Expr_25_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = InclusiveOrExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final ExclusiveOrExpression ExclusiveOrExpression_27_Var
		 = (ExclusiveOrExpression)Expr_26_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = ExclusiveOrExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final AndExpression AndExpression_28_Var
		 = (AndExpression)Expr_27_list.get(0);
		Assert.assertNotNull(AndExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = AndExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final EqualityExpression EqualityExpression_29_Var
		 = (EqualityExpression)Expr_28_list.get(0);
		Assert.assertNotNull(EqualityExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = EqualityExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final RelationalExpression RelationalExpression_30_Var
		 = (RelationalExpression)Expr_29_list.get(0);
		Assert.assertNotNull(RelationalExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = RelationalExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final ShiftExpression ShiftExpression_31_Var
		 = (ShiftExpression)Expr_30_list.get(0);
		Assert.assertNotNull(ShiftExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = ShiftExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final AdditiveExpression AdditiveExpression_32_Var
		 = (AdditiveExpression)Expr_31_list.get(0);
		Assert.assertNotNull(AdditiveExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = AdditiveExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final MultiplicativeExpression MultiplicativeExpression_33_Var
		 = (MultiplicativeExpression)Expr_32_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = MultiplicativeExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final CastExpression CastExpression_34_Var
		 = (CastExpression)Expr_33_list.get(0);
		Assert.assertNotNull(CastExpression_34_Var
		);
		//34
		final UnaryExpression UnaryExpression_35_Var
		 = (UnaryExpression)CastExpression_34_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_35_Var
		);
		//35
		final PostfixExpression PostfixExpression_36_Var
		 = (PostfixExpression)UnaryExpression_35_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = PostfixExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final PrimaryExpression PrimaryExpression_37_Var
		 = (PrimaryExpression)Expr_36_list.get(0);
		Assert.assertNotNull(PrimaryExpression_37_Var
		);
		//37
		final Constant2 Constant2_38_Var
		 = (Constant2)PrimaryExpression_37_Var
		.getConst();
		Assert.assertNotNull(Constant2_38_Var
		);
		Assert.assertEquals("250", Constant2_38_Var
		.getDec());
		final EList<? extends EObject> InitDeclaratorList_38_list = Declaration_2_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_38_list);
		Assert.assertEquals(1, InitDeclaratorList_38_list.size());
		//38
		final InitDeclaratorList InitDeclaratorList_39_Var
		 = (InitDeclaratorList)InitDeclaratorList_38_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_39_Var
		);
		final EList<? extends EObject> InitDeclarator_39_list = InitDeclaratorList_39_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_39_list);
		Assert.assertEquals(1, InitDeclarator_39_list.size());
		//39
		final InitDeclarator InitDeclarator_40_Var
		 = (InitDeclarator)InitDeclarator_39_list.get(0);
		Assert.assertNotNull(InitDeclarator_40_Var
		);
		//40
		final Declarator Declarator_41_Var
		 = (Declarator)InitDeclarator_40_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_41_Var
		);
		//41
		final DirectDeclarator DirectDeclarator_42_Var
		 = (DirectDeclarator)Declarator_41_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_42_Var
		);
		Assert.assertEquals("phil", DirectDeclarator_42_Var
		.getId());
		//42
		final ExternalDeclaration ExternalDeclaration_43_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_43_Var
		);
		//43
		final Declaration Declaration_44_Var
		 = (Declaration)ExternalDeclaration_43_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_44_Var
		);
		//44
		final DeclarationSpecifiers DeclarationSpecifiers_45_Var
		 = (DeclarationSpecifiers)Declaration_44_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_45_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_45_list = DeclarationSpecifiers_45_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_45_list);
		Assert.assertEquals(1, DeclarationSpecifier_45_list.size());
		//45
		final StructOrUnionSpecifier StructOrUnionSpecifier_46_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_45_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_46_Var
		);
		//46
		final StructOrUnion StructOrUnion_47_Var
		 = (StructOrUnion)StructOrUnionSpecifier_46_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_47_Var
		);
		Assert.assertEquals("struct", StructOrUnion_47_Var
		.getName());
		Assert.assertEquals("employee", StructOrUnionSpecifier_46_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_47_list = Declaration_44_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_47_list);
		Assert.assertEquals(1, InitDeclaratorList_47_list.size());
		//47
		final InitDeclaratorList InitDeclaratorList_48_Var
		 = (InitDeclaratorList)InitDeclaratorList_47_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_48_Var
		);
		final EList<? extends EObject> InitDeclarator_48_list = InitDeclaratorList_48_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_48_list);
		Assert.assertEquals(1, InitDeclarator_48_list.size());
		//48
		final InitDeclarator InitDeclarator_49_Var
		 = (InitDeclarator)InitDeclarator_48_list.get(0);
		Assert.assertNotNull(InitDeclarator_49_Var
		);
		//49
		final Declarator Declarator_50_Var
		 = (Declarator)InitDeclarator_49_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_50_Var
		);
		//50
		final DirectDeclarator DirectDeclarator_51_Var
		 = (DirectDeclarator)Declarator_50_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_51_Var
		);
		Assert.assertEquals("joe", DirectDeclarator_51_Var
		.getId());
		//51
		final Initializer Initializer_52_Var
		 = (Initializer)InitDeclarator_49_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_52_Var
		);
		//52
		final InitializerList InitializerList_53_Var
		 = (InitializerList)Initializer_52_Var
		.getList();
		Assert.assertNotNull(InitializerList_53_Var
		);
		final EList<? extends EObject> Initializer_53_list = InitializerList_53_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_53_list);
		Assert.assertEquals(2, Initializer_53_list.size());
		//53
		final Initializer Initializer_54_Var
		 = (Initializer)Initializer_53_list.get(0);
		Assert.assertNotNull(Initializer_54_Var
		);
		//54
		final AssignmentExpression AssignmentExpression_55_Var
		 = (AssignmentExpression)Initializer_54_Var
		.getExpr();
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
		//70
		final Constant2 Constant2_71_Var
		 = (Constant2)PrimaryExpression_70_Var
		.getConst();
		Assert.assertNotNull(Constant2_71_Var
		);
		Assert.assertEquals("0x007", Constant2_71_Var
		.getHex());
		//71
		final Initializer Initializer_72_Var
		 = (Initializer)Initializer_53_list.get(1);
		Assert.assertNotNull(Initializer_72_Var
		);
		//72
		final AssignmentExpression AssignmentExpression_73_Var
		 = (AssignmentExpression)Initializer_72_Var
		.getExpr();
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
		Assert.assertEquals("[\"Joe Nobody\"]", PrimaryExpression_88_Var
		.getString().toString());
		//88
		final ExternalDeclaration ExternalDeclaration_89_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_89_Var
		);
		//89
		final FunctionDefHead FunctionDefHead_90_Var
		 = (FunctionDefHead)ExternalDeclaration_89_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_90_Var
		);
		//90
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_91_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_90_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_91_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_91_list = FunctionDeclarationSpecifiers_91_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_91_list);
		Assert.assertEquals(1, DeclarationSpecifier_91_list.size());
		//91
		final TypeSpecifier TypeSpecifier_92_Var
		 = (TypeSpecifier)DeclarationSpecifier_91_list.get(0);
		Assert.assertNotNull(TypeSpecifier_92_Var
		);
		Assert.assertEquals("int", TypeSpecifier_92_Var
		.getName());
		//92
		final Declarator Declarator_93_Var
		 = (Declarator)FunctionDefHead_90_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_93_Var
		);
		//93
		final DirectDeclarator DirectDeclarator_94_Var
		 = (DirectDeclarator)Declarator_93_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_94_Var
		);
		Assert.assertEquals("main", DirectDeclarator_94_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_94_list = DirectDeclarator_94_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_94_list);
		Assert.assertEquals(1, DeclaratorSuffix_94_list.size());
		//94
		final DeclaratorSuffix DeclaratorSuffix_95_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_94_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_95_Var
		);
		//95
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_96_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_95_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_96_Var
		);
		final EList<? extends EObject> ParameterTypeList_96_list = DirectDeclaratorLastSuffix_96_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_96_list);
		Assert.assertEquals(1, ParameterTypeList_96_list.size());
		//96
		final ParameterTypeList ParameterTypeList_97_Var
		 = (ParameterTypeList)ParameterTypeList_96_list.get(0);
		Assert.assertNotNull(ParameterTypeList_97_Var
		);
		//97
		final ParameterList ParameterList_98_Var
		 = (ParameterList)ParameterTypeList_97_Var
		.getList();
		Assert.assertNotNull(ParameterList_98_Var
		);
		final EList<? extends EObject> ParameterDeclaration_98_list = ParameterList_98_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_98_list);
		Assert.assertEquals(1, ParameterDeclaration_98_list.size());
		//98
		final ParameterDeclaration ParameterDeclaration_99_Var
		 = (ParameterDeclaration)ParameterDeclaration_98_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_99_Var
		);
		//99
		final DeclarationSpecifiers DeclarationSpecifiers_100_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_99_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_100_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_100_list = DeclarationSpecifiers_100_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_100_list);
		Assert.assertEquals(1, DeclarationSpecifier_100_list.size());
		//100
		final TypeSpecifier TypeSpecifier_101_Var
		 = (TypeSpecifier)DeclarationSpecifier_100_list.get(0);
		Assert.assertNotNull(TypeSpecifier_101_Var
		);
		Assert.assertEquals("void", TypeSpecifier_101_Var
		.getName());
		//101
		final FunctionDefinition FunctionDefinition_102_Var
		 = (FunctionDefinition)ExternalDeclaration_89_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_102_Var
		);
		//102
		final BodyStatement BodyStatement_103_Var
		 = (BodyStatement)FunctionDefinition_102_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_103_Var
		);
		final EList<? extends EObject> BlockList_103_list = BodyStatement_103_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_103_list);
		Assert.assertEquals(1, BlockList_103_list.size());
		//103
		final BlockList BlockList_104_Var
		 = (BlockList)BlockList_103_list.get(0);
		Assert.assertNotNull(BlockList_104_Var
		);
		final EList<? extends EObject> Statement_104_list = BlockList_104_Var
		.getStatement();
		Assert.assertNotNull(Statement_104_list);
		Assert.assertEquals(10, Statement_104_list.size());
		//104
		final Statement Statement_105_Var
		 = (Statement)Statement_104_list.get(0);
		Assert.assertNotNull(Statement_105_Var
		);
		//105
		final ExpressionStatement ExpressionStatement_106_Var
		 = (ExpressionStatement)Statement_105_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_106_Var
		);
		//106
		final Expression Expression_107_Var
		 = (Expression)ExpressionStatement_106_Var
		.getExpression();
		Assert.assertNotNull(Expression_107_Var
		);
		final EList<? extends EObject> ExprExpr_107_list = Expression_107_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_107_list);
		Assert.assertEquals(1, ExprExpr_107_list.size());
		//107
		final AssignmentExpression AssignmentExpression_108_Var
		 = (AssignmentExpression)ExprExpr_107_list.get(0);
		Assert.assertNotNull(AssignmentExpression_108_Var
		);
		//108
		final ConditionalExpression ConditionalExpression_109_Var
		 = (ConditionalExpression)AssignmentExpression_108_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_109_Var
		);
		//109
		final LogicalOrExpression LogicalOrExpression_110_Var
		 = (LogicalOrExpression)ConditionalExpression_109_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = LogicalOrExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final LogicalAndExpression LogicalAndExpression_111_Var
		 = (LogicalAndExpression)Expr_110_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = LogicalAndExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final InclusiveOrExpression InclusiveOrExpression_112_Var
		 = (InclusiveOrExpression)Expr_111_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = InclusiveOrExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final ExclusiveOrExpression ExclusiveOrExpression_113_Var
		 = (ExclusiveOrExpression)Expr_112_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = ExclusiveOrExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final AndExpression AndExpression_114_Var
		 = (AndExpression)Expr_113_list.get(0);
		Assert.assertNotNull(AndExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = AndExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final EqualityExpression EqualityExpression_115_Var
		 = (EqualityExpression)Expr_114_list.get(0);
		Assert.assertNotNull(EqualityExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = EqualityExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final RelationalExpression RelationalExpression_116_Var
		 = (RelationalExpression)Expr_115_list.get(0);
		Assert.assertNotNull(RelationalExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = RelationalExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final ShiftExpression ShiftExpression_117_Var
		 = (ShiftExpression)Expr_116_list.get(0);
		Assert.assertNotNull(ShiftExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = ShiftExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final AdditiveExpression AdditiveExpression_118_Var
		 = (AdditiveExpression)Expr_117_list.get(0);
		Assert.assertNotNull(AdditiveExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = AdditiveExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final MultiplicativeExpression MultiplicativeExpression_119_Var
		 = (MultiplicativeExpression)Expr_118_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = MultiplicativeExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final CastExpression CastExpression_120_Var
		 = (CastExpression)Expr_119_list.get(0);
		Assert.assertNotNull(CastExpression_120_Var
		);
		//120
		final UnaryExpression UnaryExpression_121_Var
		 = (UnaryExpression)CastExpression_120_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_121_Var
		);
		//121
		final PostfixExpression PostfixExpression_122_Var
		 = (PostfixExpression)UnaryExpression_121_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = PostfixExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final PrimaryExpression PrimaryExpression_123_Var
		 = (PrimaryExpression)Expr_122_list.get(0);
		Assert.assertNotNull(PrimaryExpression_123_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_123_Var
		.getId());
		final EList<? extends EObject> Suffix_123_list = PostfixExpression_122_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_123_list);
		Assert.assertEquals(1, Suffix_123_list.size());
		//123
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_124_Var
		 = (PostfixExpressionSuffixArgument)Suffix_123_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_124_Var
		);
		//124
		final ArgumentExpressionList ArgumentExpressionList_125_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_124_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_125_Var
		);
		final EList<? extends EObject> Expr_125_list = ArgumentExpressionList_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(2, Expr_125_list.size());
		//125
		final AssignmentExpression AssignmentExpression_126_Var
		 = (AssignmentExpression)Expr_125_list.get(0);
		Assert.assertNotNull(AssignmentExpression_126_Var
		);
		//126
		final ConditionalExpression ConditionalExpression_127_Var
		 = (ConditionalExpression)AssignmentExpression_126_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_127_Var
		);
		//127
		final LogicalOrExpression LogicalOrExpression_128_Var
		 = (LogicalOrExpression)ConditionalExpression_127_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = LogicalOrExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final LogicalAndExpression LogicalAndExpression_129_Var
		 = (LogicalAndExpression)Expr_128_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = LogicalAndExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final InclusiveOrExpression InclusiveOrExpression_130_Var
		 = (InclusiveOrExpression)Expr_129_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = InclusiveOrExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final ExclusiveOrExpression ExclusiveOrExpression_131_Var
		 = (ExclusiveOrExpression)Expr_130_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = ExclusiveOrExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final AndExpression AndExpression_132_Var
		 = (AndExpression)Expr_131_list.get(0);
		Assert.assertNotNull(AndExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = AndExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final EqualityExpression EqualityExpression_133_Var
		 = (EqualityExpression)Expr_132_list.get(0);
		Assert.assertNotNull(EqualityExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = EqualityExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final RelationalExpression RelationalExpression_134_Var
		 = (RelationalExpression)Expr_133_list.get(0);
		Assert.assertNotNull(RelationalExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = RelationalExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final ShiftExpression ShiftExpression_135_Var
		 = (ShiftExpression)Expr_134_list.get(0);
		Assert.assertNotNull(ShiftExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = ShiftExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final AdditiveExpression AdditiveExpression_136_Var
		 = (AdditiveExpression)Expr_135_list.get(0);
		Assert.assertNotNull(AdditiveExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = AdditiveExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final MultiplicativeExpression MultiplicativeExpression_137_Var
		 = (MultiplicativeExpression)Expr_136_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = MultiplicativeExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final CastExpression CastExpression_138_Var
		 = (CastExpression)Expr_137_list.get(0);
		Assert.assertNotNull(CastExpression_138_Var
		);
		//138
		final UnaryExpression UnaryExpression_139_Var
		 = (UnaryExpression)CastExpression_138_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_139_Var
		);
		//139
		final PostfixExpression PostfixExpression_140_Var
		 = (PostfixExpression)UnaryExpression_139_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = PostfixExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final PrimaryExpression PrimaryExpression_141_Var
		 = (PrimaryExpression)Expr_140_list.get(0);
		Assert.assertNotNull(PrimaryExpression_141_Var
		);
		Assert.assertEquals("[\"sizeof(joe.id)=%lu\\n\"]", PrimaryExpression_141_Var
		.getString().toString());
		//141
		final AssignmentExpression AssignmentExpression_142_Var
		 = (AssignmentExpression)Expr_125_list.get(1);
		Assert.assertNotNull(AssignmentExpression_142_Var
		);
		//142
		final ConditionalExpression ConditionalExpression_143_Var
		 = (ConditionalExpression)AssignmentExpression_142_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_143_Var
		);
		//143
		final LogicalOrExpression LogicalOrExpression_144_Var
		 = (LogicalOrExpression)ConditionalExpression_143_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = LogicalOrExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final LogicalAndExpression LogicalAndExpression_145_Var
		 = (LogicalAndExpression)Expr_144_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = LogicalAndExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final InclusiveOrExpression InclusiveOrExpression_146_Var
		 = (InclusiveOrExpression)Expr_145_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_146_Var
		);
		final EList<? extends EObject> Expr_146_list = InclusiveOrExpression_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final ExclusiveOrExpression ExclusiveOrExpression_147_Var
		 = (ExclusiveOrExpression)Expr_146_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_147_Var
		);
		final EList<? extends EObject> Expr_147_list = ExclusiveOrExpression_147_Var
		.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(1, Expr_147_list.size());
		//147
		final AndExpression AndExpression_148_Var
		 = (AndExpression)Expr_147_list.get(0);
		Assert.assertNotNull(AndExpression_148_Var
		);
		final EList<? extends EObject> Expr_148_list = AndExpression_148_Var
		.getExpr();
		Assert.assertNotNull(Expr_148_list);
		Assert.assertEquals(1, Expr_148_list.size());
		//148
		final EqualityExpression EqualityExpression_149_Var
		 = (EqualityExpression)Expr_148_list.get(0);
		Assert.assertNotNull(EqualityExpression_149_Var
		);
		final EList<? extends EObject> Expr_149_list = EqualityExpression_149_Var
		.getExpr();
		Assert.assertNotNull(Expr_149_list);
		Assert.assertEquals(1, Expr_149_list.size());
		//149
		final RelationalExpression RelationalExpression_150_Var
		 = (RelationalExpression)Expr_149_list.get(0);
		Assert.assertNotNull(RelationalExpression_150_Var
		);
		final EList<? extends EObject> Expr_150_list = RelationalExpression_150_Var
		.getExpr();
		Assert.assertNotNull(Expr_150_list);
		Assert.assertEquals(1, Expr_150_list.size());
		//150
		final ShiftExpression ShiftExpression_151_Var
		 = (ShiftExpression)Expr_150_list.get(0);
		Assert.assertNotNull(ShiftExpression_151_Var
		);
		final EList<? extends EObject> Expr_151_list = ShiftExpression_151_Var
		.getExpr();
		Assert.assertNotNull(Expr_151_list);
		Assert.assertEquals(1, Expr_151_list.size());
		//151
		final AdditiveExpression AdditiveExpression_152_Var
		 = (AdditiveExpression)Expr_151_list.get(0);
		Assert.assertNotNull(AdditiveExpression_152_Var
		);
		final EList<? extends EObject> Expr_152_list = AdditiveExpression_152_Var
		.getExpr();
		Assert.assertNotNull(Expr_152_list);
		Assert.assertEquals(1, Expr_152_list.size());
		//152
		final MultiplicativeExpression MultiplicativeExpression_153_Var
		 = (MultiplicativeExpression)Expr_152_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_153_Var
		);
		final EList<? extends EObject> Expr_153_list = MultiplicativeExpression_153_Var
		.getExpr();
		Assert.assertNotNull(Expr_153_list);
		Assert.assertEquals(1, Expr_153_list.size());
		//153
		final CastExpression CastExpression_154_Var
		 = (CastExpression)Expr_153_list.get(0);
		Assert.assertNotNull(CastExpression_154_Var
		);
		//154
		final UnaryExpression UnaryExpression_155_Var
		 = (UnaryExpression)CastExpression_154_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_155_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_155_Var
		.getSizeOf());
		//155
		final UnaryExpression UnaryExpression_156_Var
		 = (UnaryExpression)UnaryExpression_155_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_156_Var
		);
		//156
		final PostfixExpression PostfixExpression_157_Var
		 = (PostfixExpression)UnaryExpression_156_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = PostfixExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final PrimaryExpression PrimaryExpression_158_Var
		 = (PrimaryExpression)Expr_157_list.get(0);
		Assert.assertNotNull(PrimaryExpression_158_Var
		);
		//158
		final Expression Expression_159_Var
		 = (Expression)PrimaryExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expression_159_Var
		);
		final EList<? extends EObject> ExprExpr_159_list = Expression_159_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_159_list);
		Assert.assertEquals(1, ExprExpr_159_list.size());
		//159
		final AssignmentExpression AssignmentExpression_160_Var
		 = (AssignmentExpression)ExprExpr_159_list.get(0);
		Assert.assertNotNull(AssignmentExpression_160_Var
		);
		//160
		final ConditionalExpression ConditionalExpression_161_Var
		 = (ConditionalExpression)AssignmentExpression_160_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_161_Var
		);
		//161
		final LogicalOrExpression LogicalOrExpression_162_Var
		 = (LogicalOrExpression)ConditionalExpression_161_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_162_Var
		);
		final EList<? extends EObject> Expr_162_list = LogicalOrExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		//162
		final LogicalAndExpression LogicalAndExpression_163_Var
		 = (LogicalAndExpression)Expr_162_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_163_Var
		);
		final EList<? extends EObject> Expr_163_list = LogicalAndExpression_163_Var
		.getExpr();
		Assert.assertNotNull(Expr_163_list);
		Assert.assertEquals(1, Expr_163_list.size());
		//163
		final InclusiveOrExpression InclusiveOrExpression_164_Var
		 = (InclusiveOrExpression)Expr_163_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_164_Var
		);
		final EList<? extends EObject> Expr_164_list = InclusiveOrExpression_164_Var
		.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		//164
		final ExclusiveOrExpression ExclusiveOrExpression_165_Var
		 = (ExclusiveOrExpression)Expr_164_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_165_Var
		);
		final EList<? extends EObject> Expr_165_list = ExclusiveOrExpression_165_Var
		.getExpr();
		Assert.assertNotNull(Expr_165_list);
		Assert.assertEquals(1, Expr_165_list.size());
		//165
		final AndExpression AndExpression_166_Var
		 = (AndExpression)Expr_165_list.get(0);
		Assert.assertNotNull(AndExpression_166_Var
		);
		final EList<? extends EObject> Expr_166_list = AndExpression_166_Var
		.getExpr();
		Assert.assertNotNull(Expr_166_list);
		Assert.assertEquals(1, Expr_166_list.size());
		//166
		final EqualityExpression EqualityExpression_167_Var
		 = (EqualityExpression)Expr_166_list.get(0);
		Assert.assertNotNull(EqualityExpression_167_Var
		);
		final EList<? extends EObject> Expr_167_list = EqualityExpression_167_Var
		.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(1, Expr_167_list.size());
		//167
		final RelationalExpression RelationalExpression_168_Var
		 = (RelationalExpression)Expr_167_list.get(0);
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
		Assert.assertEquals("joe", PrimaryExpression_175_Var
		.getId());
		final EList<? extends EObject> Suffix_175_list = PostfixExpression_174_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_175_list);
		Assert.assertEquals(1, Suffix_175_list.size());
		//175
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_176_Var
		 = (PostfixExpressionSuffixDot)Suffix_175_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_176_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_176_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_106_Var
		.getSemi());
		//176
		final Statement Statement_177_Var
		 = (Statement)Statement_104_list.get(1);
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
		Assert.assertEquals(1, Expr_186_list.size());
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
		Assert.assertEquals("printf", PrimaryExpression_195_Var
		.getId());
		final EList<? extends EObject> Suffix_195_list = PostfixExpression_194_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_195_list);
		Assert.assertEquals(1, Suffix_195_list.size());
		//195
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_196_Var
		 = (PostfixExpressionSuffixArgument)Suffix_195_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_196_Var
		);
		//196
		final ArgumentExpressionList ArgumentExpressionList_197_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_196_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_197_Var
		);
		final EList<? extends EObject> Expr_197_list = ArgumentExpressionList_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(2, Expr_197_list.size());
		//197
		final AssignmentExpression AssignmentExpression_198_Var
		 = (AssignmentExpression)Expr_197_list.get(0);
		Assert.assertNotNull(AssignmentExpression_198_Var
		);
		//198
		final ConditionalExpression ConditionalExpression_199_Var
		 = (ConditionalExpression)AssignmentExpression_198_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_199_Var
		);
		//199
		final LogicalOrExpression LogicalOrExpression_200_Var
		 = (LogicalOrExpression)ConditionalExpression_199_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = LogicalOrExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final LogicalAndExpression LogicalAndExpression_201_Var
		 = (LogicalAndExpression)Expr_200_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = LogicalAndExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final InclusiveOrExpression InclusiveOrExpression_202_Var
		 = (InclusiveOrExpression)Expr_201_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = InclusiveOrExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final ExclusiveOrExpression ExclusiveOrExpression_203_Var
		 = (ExclusiveOrExpression)Expr_202_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = ExclusiveOrExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final AndExpression AndExpression_204_Var
		 = (AndExpression)Expr_203_list.get(0);
		Assert.assertNotNull(AndExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = AndExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final EqualityExpression EqualityExpression_205_Var
		 = (EqualityExpression)Expr_204_list.get(0);
		Assert.assertNotNull(EqualityExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = EqualityExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final RelationalExpression RelationalExpression_206_Var
		 = (RelationalExpression)Expr_205_list.get(0);
		Assert.assertNotNull(RelationalExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = RelationalExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final ShiftExpression ShiftExpression_207_Var
		 = (ShiftExpression)Expr_206_list.get(0);
		Assert.assertNotNull(ShiftExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = ShiftExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final AdditiveExpression AdditiveExpression_208_Var
		 = (AdditiveExpression)Expr_207_list.get(0);
		Assert.assertNotNull(AdditiveExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = AdditiveExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final MultiplicativeExpression MultiplicativeExpression_209_Var
		 = (MultiplicativeExpression)Expr_208_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = MultiplicativeExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final CastExpression CastExpression_210_Var
		 = (CastExpression)Expr_209_list.get(0);
		Assert.assertNotNull(CastExpression_210_Var
		);
		//210
		final UnaryExpression UnaryExpression_211_Var
		 = (UnaryExpression)CastExpression_210_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_211_Var
		);
		//211
		final PostfixExpression PostfixExpression_212_Var
		 = (PostfixExpression)UnaryExpression_211_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = PostfixExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final PrimaryExpression PrimaryExpression_213_Var
		 = (PrimaryExpression)Expr_212_list.get(0);
		Assert.assertNotNull(PrimaryExpression_213_Var
		);
		Assert.assertEquals("[\"sizeof(joe.name)=%lu\\n\"]", PrimaryExpression_213_Var
		.getString().toString());
		//213
		final AssignmentExpression AssignmentExpression_214_Var
		 = (AssignmentExpression)Expr_197_list.get(1);
		Assert.assertNotNull(AssignmentExpression_214_Var
		);
		//214
		final ConditionalExpression ConditionalExpression_215_Var
		 = (ConditionalExpression)AssignmentExpression_214_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_215_Var
		);
		//215
		final LogicalOrExpression LogicalOrExpression_216_Var
		 = (LogicalOrExpression)ConditionalExpression_215_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = LogicalOrExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final LogicalAndExpression LogicalAndExpression_217_Var
		 = (LogicalAndExpression)Expr_216_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = LogicalAndExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final InclusiveOrExpression InclusiveOrExpression_218_Var
		 = (InclusiveOrExpression)Expr_217_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = InclusiveOrExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final ExclusiveOrExpression ExclusiveOrExpression_219_Var
		 = (ExclusiveOrExpression)Expr_218_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = ExclusiveOrExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final AndExpression AndExpression_220_Var
		 = (AndExpression)Expr_219_list.get(0);
		Assert.assertNotNull(AndExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = AndExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final EqualityExpression EqualityExpression_221_Var
		 = (EqualityExpression)Expr_220_list.get(0);
		Assert.assertNotNull(EqualityExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = EqualityExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final RelationalExpression RelationalExpression_222_Var
		 = (RelationalExpression)Expr_221_list.get(0);
		Assert.assertNotNull(RelationalExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = RelationalExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final ShiftExpression ShiftExpression_223_Var
		 = (ShiftExpression)Expr_222_list.get(0);
		Assert.assertNotNull(ShiftExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = ShiftExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final AdditiveExpression AdditiveExpression_224_Var
		 = (AdditiveExpression)Expr_223_list.get(0);
		Assert.assertNotNull(AdditiveExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = AdditiveExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final MultiplicativeExpression MultiplicativeExpression_225_Var
		 = (MultiplicativeExpression)Expr_224_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = MultiplicativeExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final CastExpression CastExpression_226_Var
		 = (CastExpression)Expr_225_list.get(0);
		Assert.assertNotNull(CastExpression_226_Var
		);
		//226
		final UnaryExpression UnaryExpression_227_Var
		 = (UnaryExpression)CastExpression_226_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_227_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_227_Var
		.getSizeOf());
		//227
		final UnaryExpression UnaryExpression_228_Var
		 = (UnaryExpression)UnaryExpression_227_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_228_Var
		);
		//228
		final PostfixExpression PostfixExpression_229_Var
		 = (PostfixExpression)UnaryExpression_228_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = PostfixExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final PrimaryExpression PrimaryExpression_230_Var
		 = (PrimaryExpression)Expr_229_list.get(0);
		Assert.assertNotNull(PrimaryExpression_230_Var
		);
		//230
		final Expression Expression_231_Var
		 = (Expression)PrimaryExpression_230_Var
		.getExpr();
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
		Assert.assertEquals("joe", PrimaryExpression_247_Var
		.getId());
		final EList<? extends EObject> Suffix_247_list = PostfixExpression_246_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_247_list);
		Assert.assertEquals(1, Suffix_247_list.size());
		//247
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_248_Var
		 = (PostfixExpressionSuffixDot)Suffix_247_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_248_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_248_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_178_Var
		.getSemi());
		//248
		final Statement Statement_249_Var
		 = (Statement)Statement_104_list.get(2);
		Assert.assertNotNull(Statement_249_Var
		);
		//249
		final ExpressionStatement ExpressionStatement_250_Var
		 = (ExpressionStatement)Statement_249_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_250_Var
		);
		//250
		final Expression Expression_251_Var
		 = (Expression)ExpressionStatement_250_Var
		.getExpression();
		Assert.assertNotNull(Expression_251_Var
		);
		final EList<? extends EObject> ExprExpr_251_list = Expression_251_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_251_list);
		Assert.assertEquals(1, ExprExpr_251_list.size());
		//251
		final AssignmentExpression AssignmentExpression_252_Var
		 = (AssignmentExpression)ExprExpr_251_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_267_Var
		.getId());
		final EList<? extends EObject> Suffix_267_list = PostfixExpression_266_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_267_list);
		Assert.assertEquals(1, Suffix_267_list.size());
		//267
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_268_Var
		 = (PostfixExpressionSuffixArgument)Suffix_267_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_268_Var
		);
		//268
		final ArgumentExpressionList ArgumentExpressionList_269_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_268_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_269_Var
		);
		final EList<? extends EObject> Expr_269_list = ArgumentExpressionList_269_Var
		.getExpr();
		Assert.assertNotNull(Expr_269_list);
		Assert.assertEquals(2, Expr_269_list.size());
		//269
		final AssignmentExpression AssignmentExpression_270_Var
		 = (AssignmentExpression)Expr_269_list.get(0);
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
		Assert.assertEquals("[\"sizeof(joe)=%lu\\n\"]", PrimaryExpression_285_Var
		.getString().toString());
		//285
		final AssignmentExpression AssignmentExpression_286_Var
		 = (AssignmentExpression)Expr_269_list.get(1);
		Assert.assertNotNull(AssignmentExpression_286_Var
		);
		//286
		final ConditionalExpression ConditionalExpression_287_Var
		 = (ConditionalExpression)AssignmentExpression_286_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_287_Var
		);
		//287
		final LogicalOrExpression LogicalOrExpression_288_Var
		 = (LogicalOrExpression)ConditionalExpression_287_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_288_Var
		);
		final EList<? extends EObject> Expr_288_list = LogicalOrExpression_288_Var
		.getExpr();
		Assert.assertNotNull(Expr_288_list);
		Assert.assertEquals(1, Expr_288_list.size());
		//288
		final LogicalAndExpression LogicalAndExpression_289_Var
		 = (LogicalAndExpression)Expr_288_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_289_Var
		);
		final EList<? extends EObject> Expr_289_list = LogicalAndExpression_289_Var
		.getExpr();
		Assert.assertNotNull(Expr_289_list);
		Assert.assertEquals(1, Expr_289_list.size());
		//289
		final InclusiveOrExpression InclusiveOrExpression_290_Var
		 = (InclusiveOrExpression)Expr_289_list.get(0);
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
		Assert.assertEquals("sizeof", UnaryExpression_299_Var
		.getSizeOf());
		//299
		final UnaryExpression UnaryExpression_300_Var
		 = (UnaryExpression)UnaryExpression_299_Var
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
		final Expression Expression_303_Var
		 = (Expression)PrimaryExpression_302_Var
		.getExpr();
		Assert.assertNotNull(Expression_303_Var
		);
		final EList<? extends EObject> ExprExpr_303_list = Expression_303_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_303_list);
		Assert.assertEquals(1, ExprExpr_303_list.size());
		//303
		final AssignmentExpression AssignmentExpression_304_Var
		 = (AssignmentExpression)ExprExpr_303_list.get(0);
		Assert.assertNotNull(AssignmentExpression_304_Var
		);
		//304
		final ConditionalExpression ConditionalExpression_305_Var
		 = (ConditionalExpression)AssignmentExpression_304_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_305_Var
		);
		//305
		final LogicalOrExpression LogicalOrExpression_306_Var
		 = (LogicalOrExpression)ConditionalExpression_305_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_306_Var
		);
		final EList<? extends EObject> Expr_306_list = LogicalOrExpression_306_Var
		.getExpr();
		Assert.assertNotNull(Expr_306_list);
		Assert.assertEquals(1, Expr_306_list.size());
		//306
		final LogicalAndExpression LogicalAndExpression_307_Var
		 = (LogicalAndExpression)Expr_306_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_307_Var
		);
		final EList<? extends EObject> Expr_307_list = LogicalAndExpression_307_Var
		.getExpr();
		Assert.assertNotNull(Expr_307_list);
		Assert.assertEquals(1, Expr_307_list.size());
		//307
		final InclusiveOrExpression InclusiveOrExpression_308_Var
		 = (InclusiveOrExpression)Expr_307_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_308_Var
		);
		final EList<? extends EObject> Expr_308_list = InclusiveOrExpression_308_Var
		.getExpr();
		Assert.assertNotNull(Expr_308_list);
		Assert.assertEquals(1, Expr_308_list.size());
		//308
		final ExclusiveOrExpression ExclusiveOrExpression_309_Var
		 = (ExclusiveOrExpression)Expr_308_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_309_Var
		);
		final EList<? extends EObject> Expr_309_list = ExclusiveOrExpression_309_Var
		.getExpr();
		Assert.assertNotNull(Expr_309_list);
		Assert.assertEquals(1, Expr_309_list.size());
		//309
		final AndExpression AndExpression_310_Var
		 = (AndExpression)Expr_309_list.get(0);
		Assert.assertNotNull(AndExpression_310_Var
		);
		final EList<? extends EObject> Expr_310_list = AndExpression_310_Var
		.getExpr();
		Assert.assertNotNull(Expr_310_list);
		Assert.assertEquals(1, Expr_310_list.size());
		//310
		final EqualityExpression EqualityExpression_311_Var
		 = (EqualityExpression)Expr_310_list.get(0);
		Assert.assertNotNull(EqualityExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = EqualityExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final RelationalExpression RelationalExpression_312_Var
		 = (RelationalExpression)Expr_311_list.get(0);
		Assert.assertNotNull(RelationalExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = RelationalExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final ShiftExpression ShiftExpression_313_Var
		 = (ShiftExpression)Expr_312_list.get(0);
		Assert.assertNotNull(ShiftExpression_313_Var
		);
		final EList<? extends EObject> Expr_313_list = ShiftExpression_313_Var
		.getExpr();
		Assert.assertNotNull(Expr_313_list);
		Assert.assertEquals(1, Expr_313_list.size());
		//313
		final AdditiveExpression AdditiveExpression_314_Var
		 = (AdditiveExpression)Expr_313_list.get(0);
		Assert.assertNotNull(AdditiveExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = AdditiveExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final MultiplicativeExpression MultiplicativeExpression_315_Var
		 = (MultiplicativeExpression)Expr_314_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = MultiplicativeExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final CastExpression CastExpression_316_Var
		 = (CastExpression)Expr_315_list.get(0);
		Assert.assertNotNull(CastExpression_316_Var
		);
		//316
		final UnaryExpression UnaryExpression_317_Var
		 = (UnaryExpression)CastExpression_316_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_317_Var
		);
		//317
		final PostfixExpression PostfixExpression_318_Var
		 = (PostfixExpression)UnaryExpression_317_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_318_Var
		);
		final EList<? extends EObject> Expr_318_list = PostfixExpression_318_Var
		.getExpr();
		Assert.assertNotNull(Expr_318_list);
		Assert.assertEquals(1, Expr_318_list.size());
		//318
		final PrimaryExpression PrimaryExpression_319_Var
		 = (PrimaryExpression)Expr_318_list.get(0);
		Assert.assertNotNull(PrimaryExpression_319_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_319_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_250_Var
		.getSemi());
		//319
		final Statement Statement_320_Var
		 = (Statement)Statement_104_list.get(3);
		Assert.assertNotNull(Statement_320_Var
		);
		//320
		final ExpressionStatement ExpressionStatement_321_Var
		 = (ExpressionStatement)Statement_320_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_321_Var
		);
		//321
		final Expression Expression_322_Var
		 = (Expression)ExpressionStatement_321_Var
		.getExpression();
		Assert.assertNotNull(Expression_322_Var
		);
		final EList<? extends EObject> ExprExpr_322_list = Expression_322_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_322_list);
		Assert.assertEquals(1, ExprExpr_322_list.size());
		//322
		final AssignmentExpression AssignmentExpression_323_Var
		 = (AssignmentExpression)ExprExpr_322_list.get(0);
		Assert.assertNotNull(AssignmentExpression_323_Var
		);
		//323
		final UnaryExpression UnaryExpression_324_Var
		 = (UnaryExpression)AssignmentExpression_323_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_324_Var
		);
		//324
		final PostfixExpression PostfixExpression_325_Var
		 = (PostfixExpression)UnaryExpression_324_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_325_Var
		);
		final EList<? extends EObject> Expr_325_list = PostfixExpression_325_Var
		.getExpr();
		Assert.assertNotNull(Expr_325_list);
		Assert.assertEquals(1, Expr_325_list.size());
		//325
		final PrimaryExpression PrimaryExpression_326_Var
		 = (PrimaryExpression)Expr_325_list.get(0);
		Assert.assertNotNull(PrimaryExpression_326_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_326_Var
		.getId());
		final EList<? extends EObject> Suffix_326_list = PostfixExpression_325_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_326_list);
		Assert.assertEquals(1, Suffix_326_list.size());
		//326
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_327_Var
		 = (PostfixExpressionSuffixDot)Suffix_326_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_327_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_327_Var
		.getId());
		//327
		final AssignmentOperator AssignmentOperator_328_Var
		 = (AssignmentOperator)AssignmentExpression_323_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_328_Var
		);
		Assert.assertEquals("=", AssignmentOperator_328_Var
		.getOp());
		//328
		final AssignmentExpression AssignmentExpression_329_Var
		 = (AssignmentExpression)AssignmentExpression_323_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_329_Var
		);
		//329
		final ConditionalExpression ConditionalExpression_330_Var
		 = (ConditionalExpression)AssignmentExpression_329_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_330_Var
		);
		//330
		final LogicalOrExpression LogicalOrExpression_331_Var
		 = (LogicalOrExpression)ConditionalExpression_330_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = LogicalOrExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final LogicalAndExpression LogicalAndExpression_332_Var
		 = (LogicalAndExpression)Expr_331_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_332_Var
		);
		final EList<? extends EObject> Expr_332_list = LogicalAndExpression_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final InclusiveOrExpression InclusiveOrExpression_333_Var
		 = (InclusiveOrExpression)Expr_332_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = InclusiveOrExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final ExclusiveOrExpression ExclusiveOrExpression_334_Var
		 = (ExclusiveOrExpression)Expr_333_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = ExclusiveOrExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final AndExpression AndExpression_335_Var
		 = (AndExpression)Expr_334_list.get(0);
		Assert.assertNotNull(AndExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = AndExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final EqualityExpression EqualityExpression_336_Var
		 = (EqualityExpression)Expr_335_list.get(0);
		Assert.assertNotNull(EqualityExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = EqualityExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final RelationalExpression RelationalExpression_337_Var
		 = (RelationalExpression)Expr_336_list.get(0);
		Assert.assertNotNull(RelationalExpression_337_Var
		);
		final EList<? extends EObject> Expr_337_list = RelationalExpression_337_Var
		.getExpr();
		Assert.assertNotNull(Expr_337_list);
		Assert.assertEquals(1, Expr_337_list.size());
		//337
		final ShiftExpression ShiftExpression_338_Var
		 = (ShiftExpression)Expr_337_list.get(0);
		Assert.assertNotNull(ShiftExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = ShiftExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final AdditiveExpression AdditiveExpression_339_Var
		 = (AdditiveExpression)Expr_338_list.get(0);
		Assert.assertNotNull(AdditiveExpression_339_Var
		);
		final EList<? extends EObject> Expr_339_list = AdditiveExpression_339_Var
		.getExpr();
		Assert.assertNotNull(Expr_339_list);
		Assert.assertEquals(1, Expr_339_list.size());
		//339
		final MultiplicativeExpression MultiplicativeExpression_340_Var
		 = (MultiplicativeExpression)Expr_339_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_340_Var
		);
		final EList<? extends EObject> Expr_340_list = MultiplicativeExpression_340_Var
		.getExpr();
		Assert.assertNotNull(Expr_340_list);
		Assert.assertEquals(1, Expr_340_list.size());
		//340
		final CastExpression CastExpression_341_Var
		 = (CastExpression)Expr_340_list.get(0);
		Assert.assertNotNull(CastExpression_341_Var
		);
		//341
		final UnaryExpression UnaryExpression_342_Var
		 = (UnaryExpression)CastExpression_341_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_342_Var
		);
		//342
		final PostfixExpression PostfixExpression_343_Var
		 = (PostfixExpression)UnaryExpression_342_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_343_Var
		);
		final EList<? extends EObject> Expr_343_list = PostfixExpression_343_Var
		.getExpr();
		Assert.assertNotNull(Expr_343_list);
		Assert.assertEquals(1, Expr_343_list.size());
		//343
		final PrimaryExpression PrimaryExpression_344_Var
		 = (PrimaryExpression)Expr_343_list.get(0);
		Assert.assertNotNull(PrimaryExpression_344_Var
		);
		//344
		final Constant2 Constant2_345_Var
		 = (Constant2)PrimaryExpression_344_Var
		.getConst();
		Assert.assertNotNull(Constant2_345_Var
		);
		Assert.assertEquals("0x008", Constant2_345_Var
		.getHex());
		Assert.assertEquals(";", ExpressionStatement_321_Var
		.getSemi());
		//345
		final Statement Statement_346_Var
		 = (Statement)Statement_104_list.get(4);
		Assert.assertNotNull(Statement_346_Var
		);
		//346
		final ExpressionStatement ExpressionStatement_347_Var
		 = (ExpressionStatement)Statement_346_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_347_Var
		);
		//347
		final Expression Expression_348_Var
		 = (Expression)ExpressionStatement_347_Var
		.getExpression();
		Assert.assertNotNull(Expression_348_Var
		);
		final EList<? extends EObject> ExprExpr_348_list = Expression_348_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_348_list);
		Assert.assertEquals(1, ExprExpr_348_list.size());
		//348
		final AssignmentExpression AssignmentExpression_349_Var
		 = (AssignmentExpression)ExprExpr_348_list.get(0);
		Assert.assertNotNull(AssignmentExpression_349_Var
		);
		//349
		final ConditionalExpression ConditionalExpression_350_Var
		 = (ConditionalExpression)AssignmentExpression_349_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_350_Var
		);
		//350
		final LogicalOrExpression LogicalOrExpression_351_Var
		 = (LogicalOrExpression)ConditionalExpression_350_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_351_Var
		);
		final EList<? extends EObject> Expr_351_list = LogicalOrExpression_351_Var
		.getExpr();
		Assert.assertNotNull(Expr_351_list);
		Assert.assertEquals(1, Expr_351_list.size());
		//351
		final LogicalAndExpression LogicalAndExpression_352_Var
		 = (LogicalAndExpression)Expr_351_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_352_Var
		);
		final EList<? extends EObject> Expr_352_list = LogicalAndExpression_352_Var
		.getExpr();
		Assert.assertNotNull(Expr_352_list);
		Assert.assertEquals(1, Expr_352_list.size());
		//352
		final InclusiveOrExpression InclusiveOrExpression_353_Var
		 = (InclusiveOrExpression)Expr_352_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_353_Var
		);
		final EList<? extends EObject> Expr_353_list = InclusiveOrExpression_353_Var
		.getExpr();
		Assert.assertNotNull(Expr_353_list);
		Assert.assertEquals(1, Expr_353_list.size());
		//353
		final ExclusiveOrExpression ExclusiveOrExpression_354_Var
		 = (ExclusiveOrExpression)Expr_353_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_354_Var
		);
		final EList<? extends EObject> Expr_354_list = ExclusiveOrExpression_354_Var
		.getExpr();
		Assert.assertNotNull(Expr_354_list);
		Assert.assertEquals(1, Expr_354_list.size());
		//354
		final AndExpression AndExpression_355_Var
		 = (AndExpression)Expr_354_list.get(0);
		Assert.assertNotNull(AndExpression_355_Var
		);
		final EList<? extends EObject> Expr_355_list = AndExpression_355_Var
		.getExpr();
		Assert.assertNotNull(Expr_355_list);
		Assert.assertEquals(1, Expr_355_list.size());
		//355
		final EqualityExpression EqualityExpression_356_Var
		 = (EqualityExpression)Expr_355_list.get(0);
		Assert.assertNotNull(EqualityExpression_356_Var
		);
		final EList<? extends EObject> Expr_356_list = EqualityExpression_356_Var
		.getExpr();
		Assert.assertNotNull(Expr_356_list);
		Assert.assertEquals(1, Expr_356_list.size());
		//356
		final RelationalExpression RelationalExpression_357_Var
		 = (RelationalExpression)Expr_356_list.get(0);
		Assert.assertNotNull(RelationalExpression_357_Var
		);
		final EList<? extends EObject> Expr_357_list = RelationalExpression_357_Var
		.getExpr();
		Assert.assertNotNull(Expr_357_list);
		Assert.assertEquals(1, Expr_357_list.size());
		//357
		final ShiftExpression ShiftExpression_358_Var
		 = (ShiftExpression)Expr_357_list.get(0);
		Assert.assertNotNull(ShiftExpression_358_Var
		);
		final EList<? extends EObject> Expr_358_list = ShiftExpression_358_Var
		.getExpr();
		Assert.assertNotNull(Expr_358_list);
		Assert.assertEquals(1, Expr_358_list.size());
		//358
		final AdditiveExpression AdditiveExpression_359_Var
		 = (AdditiveExpression)Expr_358_list.get(0);
		Assert.assertNotNull(AdditiveExpression_359_Var
		);
		final EList<? extends EObject> Expr_359_list = AdditiveExpression_359_Var
		.getExpr();
		Assert.assertNotNull(Expr_359_list);
		Assert.assertEquals(1, Expr_359_list.size());
		//359
		final MultiplicativeExpression MultiplicativeExpression_360_Var
		 = (MultiplicativeExpression)Expr_359_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_360_Var
		);
		final EList<? extends EObject> Expr_360_list = MultiplicativeExpression_360_Var
		.getExpr();
		Assert.assertNotNull(Expr_360_list);
		Assert.assertEquals(1, Expr_360_list.size());
		//360
		final CastExpression CastExpression_361_Var
		 = (CastExpression)Expr_360_list.get(0);
		Assert.assertNotNull(CastExpression_361_Var
		);
		//361
		final UnaryExpression UnaryExpression_362_Var
		 = (UnaryExpression)CastExpression_361_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_362_Var
		);
		//362
		final PostfixExpression PostfixExpression_363_Var
		 = (PostfixExpression)UnaryExpression_362_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_363_Var
		);
		final EList<? extends EObject> Expr_363_list = PostfixExpression_363_Var
		.getExpr();
		Assert.assertNotNull(Expr_363_list);
		Assert.assertEquals(1, Expr_363_list.size());
		//363
		final PrimaryExpression PrimaryExpression_364_Var
		 = (PrimaryExpression)Expr_363_list.get(0);
		Assert.assertNotNull(PrimaryExpression_364_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_364_Var
		.getId());
		final EList<? extends EObject> Suffix_364_list = PostfixExpression_363_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_364_list);
		Assert.assertEquals(1, Suffix_364_list.size());
		//364
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_365_Var
		 = (PostfixExpressionSuffixArgument)Suffix_364_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_365_Var
		);
		//365
		final ArgumentExpressionList ArgumentExpressionList_366_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_365_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_366_Var
		);
		final EList<? extends EObject> Expr_366_list = ArgumentExpressionList_366_Var
		.getExpr();
		Assert.assertNotNull(Expr_366_list);
		Assert.assertEquals(2, Expr_366_list.size());
		//366
		final AssignmentExpression AssignmentExpression_367_Var
		 = (AssignmentExpression)Expr_366_list.get(0);
		Assert.assertNotNull(AssignmentExpression_367_Var
		);
		//367
		final ConditionalExpression ConditionalExpression_368_Var
		 = (ConditionalExpression)AssignmentExpression_367_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_368_Var
		);
		//368
		final LogicalOrExpression LogicalOrExpression_369_Var
		 = (LogicalOrExpression)ConditionalExpression_368_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_369_Var
		);
		final EList<? extends EObject> Expr_369_list = LogicalOrExpression_369_Var
		.getExpr();
		Assert.assertNotNull(Expr_369_list);
		Assert.assertEquals(1, Expr_369_list.size());
		//369
		final LogicalAndExpression LogicalAndExpression_370_Var
		 = (LogicalAndExpression)Expr_369_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_370_Var
		);
		final EList<? extends EObject> Expr_370_list = LogicalAndExpression_370_Var
		.getExpr();
		Assert.assertNotNull(Expr_370_list);
		Assert.assertEquals(1, Expr_370_list.size());
		//370
		final InclusiveOrExpression InclusiveOrExpression_371_Var
		 = (InclusiveOrExpression)Expr_370_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_371_Var
		);
		final EList<? extends EObject> Expr_371_list = InclusiveOrExpression_371_Var
		.getExpr();
		Assert.assertNotNull(Expr_371_list);
		Assert.assertEquals(1, Expr_371_list.size());
		//371
		final ExclusiveOrExpression ExclusiveOrExpression_372_Var
		 = (ExclusiveOrExpression)Expr_371_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_372_Var
		);
		final EList<? extends EObject> Expr_372_list = ExclusiveOrExpression_372_Var
		.getExpr();
		Assert.assertNotNull(Expr_372_list);
		Assert.assertEquals(1, Expr_372_list.size());
		//372
		final AndExpression AndExpression_373_Var
		 = (AndExpression)Expr_372_list.get(0);
		Assert.assertNotNull(AndExpression_373_Var
		);
		final EList<? extends EObject> Expr_373_list = AndExpression_373_Var
		.getExpr();
		Assert.assertNotNull(Expr_373_list);
		Assert.assertEquals(1, Expr_373_list.size());
		//373
		final EqualityExpression EqualityExpression_374_Var
		 = (EqualityExpression)Expr_373_list.get(0);
		Assert.assertNotNull(EqualityExpression_374_Var
		);
		final EList<? extends EObject> Expr_374_list = EqualityExpression_374_Var
		.getExpr();
		Assert.assertNotNull(Expr_374_list);
		Assert.assertEquals(1, Expr_374_list.size());
		//374
		final RelationalExpression RelationalExpression_375_Var
		 = (RelationalExpression)Expr_374_list.get(0);
		Assert.assertNotNull(RelationalExpression_375_Var
		);
		final EList<? extends EObject> Expr_375_list = RelationalExpression_375_Var
		.getExpr();
		Assert.assertNotNull(Expr_375_list);
		Assert.assertEquals(1, Expr_375_list.size());
		//375
		final ShiftExpression ShiftExpression_376_Var
		 = (ShiftExpression)Expr_375_list.get(0);
		Assert.assertNotNull(ShiftExpression_376_Var
		);
		final EList<? extends EObject> Expr_376_list = ShiftExpression_376_Var
		.getExpr();
		Assert.assertNotNull(Expr_376_list);
		Assert.assertEquals(1, Expr_376_list.size());
		//376
		final AdditiveExpression AdditiveExpression_377_Var
		 = (AdditiveExpression)Expr_376_list.get(0);
		Assert.assertNotNull(AdditiveExpression_377_Var
		);
		final EList<? extends EObject> Expr_377_list = AdditiveExpression_377_Var
		.getExpr();
		Assert.assertNotNull(Expr_377_list);
		Assert.assertEquals(1, Expr_377_list.size());
		//377
		final MultiplicativeExpression MultiplicativeExpression_378_Var
		 = (MultiplicativeExpression)Expr_377_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_378_Var
		);
		final EList<? extends EObject> Expr_378_list = MultiplicativeExpression_378_Var
		.getExpr();
		Assert.assertNotNull(Expr_378_list);
		Assert.assertEquals(1, Expr_378_list.size());
		//378
		final CastExpression CastExpression_379_Var
		 = (CastExpression)Expr_378_list.get(0);
		Assert.assertNotNull(CastExpression_379_Var
		);
		//379
		final UnaryExpression UnaryExpression_380_Var
		 = (UnaryExpression)CastExpression_379_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_380_Var
		);
		//380
		final PostfixExpression PostfixExpression_381_Var
		 = (PostfixExpression)UnaryExpression_380_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_381_Var
		);
		final EList<? extends EObject> Expr_381_list = PostfixExpression_381_Var
		.getExpr();
		Assert.assertNotNull(Expr_381_list);
		Assert.assertEquals(1, Expr_381_list.size());
		//381
		final PrimaryExpression PrimaryExpression_382_Var
		 = (PrimaryExpression)Expr_381_list.get(0);
		Assert.assertNotNull(PrimaryExpression_382_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_382_Var
		.getId());
		final EList<? extends EObject> Suffix_382_list = PostfixExpression_381_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_382_list);
		Assert.assertEquals(1, Suffix_382_list.size());
		//382
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_383_Var
		 = (PostfixExpressionSuffixDot)Suffix_382_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_383_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_383_Var
		.getId());
		//383
		final AssignmentExpression AssignmentExpression_384_Var
		 = (AssignmentExpression)Expr_366_list.get(1);
		Assert.assertNotNull(AssignmentExpression_384_Var
		);
		//384
		final ConditionalExpression ConditionalExpression_385_Var
		 = (ConditionalExpression)AssignmentExpression_384_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_385_Var
		);
		//385
		final LogicalOrExpression LogicalOrExpression_386_Var
		 = (LogicalOrExpression)ConditionalExpression_385_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_386_Var
		);
		final EList<? extends EObject> Expr_386_list = LogicalOrExpression_386_Var
		.getExpr();
		Assert.assertNotNull(Expr_386_list);
		Assert.assertEquals(1, Expr_386_list.size());
		//386
		final LogicalAndExpression LogicalAndExpression_387_Var
		 = (LogicalAndExpression)Expr_386_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_387_Var
		);
		final EList<? extends EObject> Expr_387_list = LogicalAndExpression_387_Var
		.getExpr();
		Assert.assertNotNull(Expr_387_list);
		Assert.assertEquals(1, Expr_387_list.size());
		//387
		final InclusiveOrExpression InclusiveOrExpression_388_Var
		 = (InclusiveOrExpression)Expr_387_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_388_Var
		);
		final EList<? extends EObject> Expr_388_list = InclusiveOrExpression_388_Var
		.getExpr();
		Assert.assertNotNull(Expr_388_list);
		Assert.assertEquals(1, Expr_388_list.size());
		//388
		final ExclusiveOrExpression ExclusiveOrExpression_389_Var
		 = (ExclusiveOrExpression)Expr_388_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_389_Var
		);
		final EList<? extends EObject> Expr_389_list = ExclusiveOrExpression_389_Var
		.getExpr();
		Assert.assertNotNull(Expr_389_list);
		Assert.assertEquals(1, Expr_389_list.size());
		//389
		final AndExpression AndExpression_390_Var
		 = (AndExpression)Expr_389_list.get(0);
		Assert.assertNotNull(AndExpression_390_Var
		);
		final EList<? extends EObject> Expr_390_list = AndExpression_390_Var
		.getExpr();
		Assert.assertNotNull(Expr_390_list);
		Assert.assertEquals(1, Expr_390_list.size());
		//390
		final EqualityExpression EqualityExpression_391_Var
		 = (EqualityExpression)Expr_390_list.get(0);
		Assert.assertNotNull(EqualityExpression_391_Var
		);
		final EList<? extends EObject> Expr_391_list = EqualityExpression_391_Var
		.getExpr();
		Assert.assertNotNull(Expr_391_list);
		Assert.assertEquals(1, Expr_391_list.size());
		//391
		final RelationalExpression RelationalExpression_392_Var
		 = (RelationalExpression)Expr_391_list.get(0);
		Assert.assertNotNull(RelationalExpression_392_Var
		);
		final EList<? extends EObject> Expr_392_list = RelationalExpression_392_Var
		.getExpr();
		Assert.assertNotNull(Expr_392_list);
		Assert.assertEquals(1, Expr_392_list.size());
		//392
		final ShiftExpression ShiftExpression_393_Var
		 = (ShiftExpression)Expr_392_list.get(0);
		Assert.assertNotNull(ShiftExpression_393_Var
		);
		final EList<? extends EObject> Expr_393_list = ShiftExpression_393_Var
		.getExpr();
		Assert.assertNotNull(Expr_393_list);
		Assert.assertEquals(1, Expr_393_list.size());
		//393
		final AdditiveExpression AdditiveExpression_394_Var
		 = (AdditiveExpression)Expr_393_list.get(0);
		Assert.assertNotNull(AdditiveExpression_394_Var
		);
		final EList<? extends EObject> Expr_394_list = AdditiveExpression_394_Var
		.getExpr();
		Assert.assertNotNull(Expr_394_list);
		Assert.assertEquals(1, Expr_394_list.size());
		//394
		final MultiplicativeExpression MultiplicativeExpression_395_Var
		 = (MultiplicativeExpression)Expr_394_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_395_Var
		);
		final EList<? extends EObject> Expr_395_list = MultiplicativeExpression_395_Var
		.getExpr();
		Assert.assertNotNull(Expr_395_list);
		Assert.assertEquals(1, Expr_395_list.size());
		//395
		final CastExpression CastExpression_396_Var
		 = (CastExpression)Expr_395_list.get(0);
		Assert.assertNotNull(CastExpression_396_Var
		);
		//396
		final UnaryExpression UnaryExpression_397_Var
		 = (UnaryExpression)CastExpression_396_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_397_Var
		);
		//397
		final PostfixExpression PostfixExpression_398_Var
		 = (PostfixExpression)UnaryExpression_397_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_398_Var
		);
		final EList<? extends EObject> Expr_398_list = PostfixExpression_398_Var
		.getExpr();
		Assert.assertNotNull(Expr_398_list);
		Assert.assertEquals(1, Expr_398_list.size());
		//398
		final PrimaryExpression PrimaryExpression_399_Var
		 = (PrimaryExpression)Expr_398_list.get(0);
		Assert.assertNotNull(PrimaryExpression_399_Var
		);
		Assert.assertEquals("[\"Phil Morrison\"]", PrimaryExpression_399_Var
		.getString().toString());
		Assert.assertEquals(";", ExpressionStatement_347_Var
		.getSemi());
		//399
		final Statement Statement_400_Var
		 = (Statement)Statement_104_list.get(5);
		Assert.assertNotNull(Statement_400_Var
		);
		//400
		final ExpressionStatement ExpressionStatement_401_Var
		 = (ExpressionStatement)Statement_400_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_401_Var
		);
		//401
		final Expression Expression_402_Var
		 = (Expression)ExpressionStatement_401_Var
		.getExpression();
		Assert.assertNotNull(Expression_402_Var
		);
		final EList<? extends EObject> ExprExpr_402_list = Expression_402_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_402_list);
		Assert.assertEquals(1, ExprExpr_402_list.size());
		//402
		final AssignmentExpression AssignmentExpression_403_Var
		 = (AssignmentExpression)ExprExpr_402_list.get(0);
		Assert.assertNotNull(AssignmentExpression_403_Var
		);
		//403
		final ConditionalExpression ConditionalExpression_404_Var
		 = (ConditionalExpression)AssignmentExpression_403_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_404_Var
		);
		//404
		final LogicalOrExpression LogicalOrExpression_405_Var
		 = (LogicalOrExpression)ConditionalExpression_404_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_405_Var
		);
		final EList<? extends EObject> Expr_405_list = LogicalOrExpression_405_Var
		.getExpr();
		Assert.assertNotNull(Expr_405_list);
		Assert.assertEquals(1, Expr_405_list.size());
		//405
		final LogicalAndExpression LogicalAndExpression_406_Var
		 = (LogicalAndExpression)Expr_405_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_406_Var
		);
		final EList<? extends EObject> Expr_406_list = LogicalAndExpression_406_Var
		.getExpr();
		Assert.assertNotNull(Expr_406_list);
		Assert.assertEquals(1, Expr_406_list.size());
		//406
		final InclusiveOrExpression InclusiveOrExpression_407_Var
		 = (InclusiveOrExpression)Expr_406_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_407_Var
		);
		final EList<? extends EObject> Expr_407_list = InclusiveOrExpression_407_Var
		.getExpr();
		Assert.assertNotNull(Expr_407_list);
		Assert.assertEquals(1, Expr_407_list.size());
		//407
		final ExclusiveOrExpression ExclusiveOrExpression_408_Var
		 = (ExclusiveOrExpression)Expr_407_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_408_Var
		);
		final EList<? extends EObject> Expr_408_list = ExclusiveOrExpression_408_Var
		.getExpr();
		Assert.assertNotNull(Expr_408_list);
		Assert.assertEquals(1, Expr_408_list.size());
		//408
		final AndExpression AndExpression_409_Var
		 = (AndExpression)Expr_408_list.get(0);
		Assert.assertNotNull(AndExpression_409_Var
		);
		final EList<? extends EObject> Expr_409_list = AndExpression_409_Var
		.getExpr();
		Assert.assertNotNull(Expr_409_list);
		Assert.assertEquals(1, Expr_409_list.size());
		//409
		final EqualityExpression EqualityExpression_410_Var
		 = (EqualityExpression)Expr_409_list.get(0);
		Assert.assertNotNull(EqualityExpression_410_Var
		);
		final EList<? extends EObject> Expr_410_list = EqualityExpression_410_Var
		.getExpr();
		Assert.assertNotNull(Expr_410_list);
		Assert.assertEquals(1, Expr_410_list.size());
		//410
		final RelationalExpression RelationalExpression_411_Var
		 = (RelationalExpression)Expr_410_list.get(0);
		Assert.assertNotNull(RelationalExpression_411_Var
		);
		final EList<? extends EObject> Expr_411_list = RelationalExpression_411_Var
		.getExpr();
		Assert.assertNotNull(Expr_411_list);
		Assert.assertEquals(1, Expr_411_list.size());
		//411
		final ShiftExpression ShiftExpression_412_Var
		 = (ShiftExpression)Expr_411_list.get(0);
		Assert.assertNotNull(ShiftExpression_412_Var
		);
		final EList<? extends EObject> Expr_412_list = ShiftExpression_412_Var
		.getExpr();
		Assert.assertNotNull(Expr_412_list);
		Assert.assertEquals(1, Expr_412_list.size());
		//412
		final AdditiveExpression AdditiveExpression_413_Var
		 = (AdditiveExpression)Expr_412_list.get(0);
		Assert.assertNotNull(AdditiveExpression_413_Var
		);
		final EList<? extends EObject> Expr_413_list = AdditiveExpression_413_Var
		.getExpr();
		Assert.assertNotNull(Expr_413_list);
		Assert.assertEquals(1, Expr_413_list.size());
		//413
		final MultiplicativeExpression MultiplicativeExpression_414_Var
		 = (MultiplicativeExpression)Expr_413_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_414_Var
		);
		final EList<? extends EObject> Expr_414_list = MultiplicativeExpression_414_Var
		.getExpr();
		Assert.assertNotNull(Expr_414_list);
		Assert.assertEquals(1, Expr_414_list.size());
		//414
		final CastExpression CastExpression_415_Var
		 = (CastExpression)Expr_414_list.get(0);
		Assert.assertNotNull(CastExpression_415_Var
		);
		//415
		final UnaryExpression UnaryExpression_416_Var
		 = (UnaryExpression)CastExpression_415_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_416_Var
		);
		//416
		final PostfixExpression PostfixExpression_417_Var
		 = (PostfixExpression)UnaryExpression_416_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_417_Var
		);
		final EList<? extends EObject> Expr_417_list = PostfixExpression_417_Var
		.getExpr();
		Assert.assertNotNull(Expr_417_list);
		Assert.assertEquals(1, Expr_417_list.size());
		//417
		final PrimaryExpression PrimaryExpression_418_Var
		 = (PrimaryExpression)Expr_417_list.get(0);
		Assert.assertNotNull(PrimaryExpression_418_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_418_Var
		.getId());
		final EList<? extends EObject> Suffix_418_list = PostfixExpression_417_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_418_list);
		Assert.assertEquals(1, Suffix_418_list.size());
		//418
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_419_Var
		 = (PostfixExpressionSuffixArgument)Suffix_418_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_419_Var
		);
		//419
		final ArgumentExpressionList ArgumentExpressionList_420_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_419_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_420_Var
		);
		final EList<? extends EObject> Expr_420_list = ArgumentExpressionList_420_Var
		.getExpr();
		Assert.assertNotNull(Expr_420_list);
		Assert.assertEquals(2, Expr_420_list.size());
		//420
		final AssignmentExpression AssignmentExpression_421_Var
		 = (AssignmentExpression)Expr_420_list.get(0);
		Assert.assertNotNull(AssignmentExpression_421_Var
		);
		//421
		final ConditionalExpression ConditionalExpression_422_Var
		 = (ConditionalExpression)AssignmentExpression_421_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_422_Var
		);
		//422
		final LogicalOrExpression LogicalOrExpression_423_Var
		 = (LogicalOrExpression)ConditionalExpression_422_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_423_Var
		);
		final EList<? extends EObject> Expr_423_list = LogicalOrExpression_423_Var
		.getExpr();
		Assert.assertNotNull(Expr_423_list);
		Assert.assertEquals(1, Expr_423_list.size());
		//423
		final LogicalAndExpression LogicalAndExpression_424_Var
		 = (LogicalAndExpression)Expr_423_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_424_Var
		);
		final EList<? extends EObject> Expr_424_list = LogicalAndExpression_424_Var
		.getExpr();
		Assert.assertNotNull(Expr_424_list);
		Assert.assertEquals(1, Expr_424_list.size());
		//424
		final InclusiveOrExpression InclusiveOrExpression_425_Var
		 = (InclusiveOrExpression)Expr_424_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_425_Var
		);
		final EList<? extends EObject> Expr_425_list = InclusiveOrExpression_425_Var
		.getExpr();
		Assert.assertNotNull(Expr_425_list);
		Assert.assertEquals(1, Expr_425_list.size());
		//425
		final ExclusiveOrExpression ExclusiveOrExpression_426_Var
		 = (ExclusiveOrExpression)Expr_425_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_426_Var
		);
		final EList<? extends EObject> Expr_426_list = ExclusiveOrExpression_426_Var
		.getExpr();
		Assert.assertNotNull(Expr_426_list);
		Assert.assertEquals(1, Expr_426_list.size());
		//426
		final AndExpression AndExpression_427_Var
		 = (AndExpression)Expr_426_list.get(0);
		Assert.assertNotNull(AndExpression_427_Var
		);
		final EList<? extends EObject> Expr_427_list = AndExpression_427_Var
		.getExpr();
		Assert.assertNotNull(Expr_427_list);
		Assert.assertEquals(1, Expr_427_list.size());
		//427
		final EqualityExpression EqualityExpression_428_Var
		 = (EqualityExpression)Expr_427_list.get(0);
		Assert.assertNotNull(EqualityExpression_428_Var
		);
		final EList<? extends EObject> Expr_428_list = EqualityExpression_428_Var
		.getExpr();
		Assert.assertNotNull(Expr_428_list);
		Assert.assertEquals(1, Expr_428_list.size());
		//428
		final RelationalExpression RelationalExpression_429_Var
		 = (RelationalExpression)Expr_428_list.get(0);
		Assert.assertNotNull(RelationalExpression_429_Var
		);
		final EList<? extends EObject> Expr_429_list = RelationalExpression_429_Var
		.getExpr();
		Assert.assertNotNull(Expr_429_list);
		Assert.assertEquals(1, Expr_429_list.size());
		//429
		final ShiftExpression ShiftExpression_430_Var
		 = (ShiftExpression)Expr_429_list.get(0);
		Assert.assertNotNull(ShiftExpression_430_Var
		);
		final EList<? extends EObject> Expr_430_list = ShiftExpression_430_Var
		.getExpr();
		Assert.assertNotNull(Expr_430_list);
		Assert.assertEquals(1, Expr_430_list.size());
		//430
		final AdditiveExpression AdditiveExpression_431_Var
		 = (AdditiveExpression)Expr_430_list.get(0);
		Assert.assertNotNull(AdditiveExpression_431_Var
		);
		final EList<? extends EObject> Expr_431_list = AdditiveExpression_431_Var
		.getExpr();
		Assert.assertNotNull(Expr_431_list);
		Assert.assertEquals(1, Expr_431_list.size());
		//431
		final MultiplicativeExpression MultiplicativeExpression_432_Var
		 = (MultiplicativeExpression)Expr_431_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_432_Var
		);
		final EList<? extends EObject> Expr_432_list = MultiplicativeExpression_432_Var
		.getExpr();
		Assert.assertNotNull(Expr_432_list);
		Assert.assertEquals(1, Expr_432_list.size());
		//432
		final CastExpression CastExpression_433_Var
		 = (CastExpression)Expr_432_list.get(0);
		Assert.assertNotNull(CastExpression_433_Var
		);
		//433
		final UnaryExpression UnaryExpression_434_Var
		 = (UnaryExpression)CastExpression_433_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_434_Var
		);
		//434
		final PostfixExpression PostfixExpression_435_Var
		 = (PostfixExpression)UnaryExpression_434_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_435_Var
		);
		final EList<? extends EObject> Expr_435_list = PostfixExpression_435_Var
		.getExpr();
		Assert.assertNotNull(Expr_435_list);
		Assert.assertEquals(1, Expr_435_list.size());
		//435
		final PrimaryExpression PrimaryExpression_436_Var
		 = (PrimaryExpression)Expr_435_list.get(0);
		Assert.assertNotNull(PrimaryExpression_436_Var
		);
		Assert.assertEquals("[\"joe.id=%d\\n\"]", PrimaryExpression_436_Var
		.getString().toString());
		//436
		final AssignmentExpression AssignmentExpression_437_Var
		 = (AssignmentExpression)Expr_420_list.get(1);
		Assert.assertNotNull(AssignmentExpression_437_Var
		);
		//437
		final ConditionalExpression ConditionalExpression_438_Var
		 = (ConditionalExpression)AssignmentExpression_437_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_438_Var
		);
		//438
		final LogicalOrExpression LogicalOrExpression_439_Var
		 = (LogicalOrExpression)ConditionalExpression_438_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_439_Var
		);
		final EList<? extends EObject> Expr_439_list = LogicalOrExpression_439_Var
		.getExpr();
		Assert.assertNotNull(Expr_439_list);
		Assert.assertEquals(1, Expr_439_list.size());
		//439
		final LogicalAndExpression LogicalAndExpression_440_Var
		 = (LogicalAndExpression)Expr_439_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_440_Var
		);
		final EList<? extends EObject> Expr_440_list = LogicalAndExpression_440_Var
		.getExpr();
		Assert.assertNotNull(Expr_440_list);
		Assert.assertEquals(1, Expr_440_list.size());
		//440
		final InclusiveOrExpression InclusiveOrExpression_441_Var
		 = (InclusiveOrExpression)Expr_440_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_441_Var
		);
		final EList<? extends EObject> Expr_441_list = InclusiveOrExpression_441_Var
		.getExpr();
		Assert.assertNotNull(Expr_441_list);
		Assert.assertEquals(1, Expr_441_list.size());
		//441
		final ExclusiveOrExpression ExclusiveOrExpression_442_Var
		 = (ExclusiveOrExpression)Expr_441_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_442_Var
		);
		final EList<? extends EObject> Expr_442_list = ExclusiveOrExpression_442_Var
		.getExpr();
		Assert.assertNotNull(Expr_442_list);
		Assert.assertEquals(1, Expr_442_list.size());
		//442
		final AndExpression AndExpression_443_Var
		 = (AndExpression)Expr_442_list.get(0);
		Assert.assertNotNull(AndExpression_443_Var
		);
		final EList<? extends EObject> Expr_443_list = AndExpression_443_Var
		.getExpr();
		Assert.assertNotNull(Expr_443_list);
		Assert.assertEquals(1, Expr_443_list.size());
		//443
		final EqualityExpression EqualityExpression_444_Var
		 = (EqualityExpression)Expr_443_list.get(0);
		Assert.assertNotNull(EqualityExpression_444_Var
		);
		final EList<? extends EObject> Expr_444_list = EqualityExpression_444_Var
		.getExpr();
		Assert.assertNotNull(Expr_444_list);
		Assert.assertEquals(1, Expr_444_list.size());
		//444
		final RelationalExpression RelationalExpression_445_Var
		 = (RelationalExpression)Expr_444_list.get(0);
		Assert.assertNotNull(RelationalExpression_445_Var
		);
		final EList<? extends EObject> Expr_445_list = RelationalExpression_445_Var
		.getExpr();
		Assert.assertNotNull(Expr_445_list);
		Assert.assertEquals(1, Expr_445_list.size());
		//445
		final ShiftExpression ShiftExpression_446_Var
		 = (ShiftExpression)Expr_445_list.get(0);
		Assert.assertNotNull(ShiftExpression_446_Var
		);
		final EList<? extends EObject> Expr_446_list = ShiftExpression_446_Var
		.getExpr();
		Assert.assertNotNull(Expr_446_list);
		Assert.assertEquals(1, Expr_446_list.size());
		//446
		final AdditiveExpression AdditiveExpression_447_Var
		 = (AdditiveExpression)Expr_446_list.get(0);
		Assert.assertNotNull(AdditiveExpression_447_Var
		);
		final EList<? extends EObject> Expr_447_list = AdditiveExpression_447_Var
		.getExpr();
		Assert.assertNotNull(Expr_447_list);
		Assert.assertEquals(1, Expr_447_list.size());
		//447
		final MultiplicativeExpression MultiplicativeExpression_448_Var
		 = (MultiplicativeExpression)Expr_447_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_448_Var
		);
		final EList<? extends EObject> Expr_448_list = MultiplicativeExpression_448_Var
		.getExpr();
		Assert.assertNotNull(Expr_448_list);
		Assert.assertEquals(1, Expr_448_list.size());
		//448
		final CastExpression CastExpression_449_Var
		 = (CastExpression)Expr_448_list.get(0);
		Assert.assertNotNull(CastExpression_449_Var
		);
		//449
		final UnaryExpression UnaryExpression_450_Var
		 = (UnaryExpression)CastExpression_449_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_450_Var
		);
		//450
		final PostfixExpression PostfixExpression_451_Var
		 = (PostfixExpression)UnaryExpression_450_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_451_Var
		);
		final EList<? extends EObject> Expr_451_list = PostfixExpression_451_Var
		.getExpr();
		Assert.assertNotNull(Expr_451_list);
		Assert.assertEquals(1, Expr_451_list.size());
		//451
		final PrimaryExpression PrimaryExpression_452_Var
		 = (PrimaryExpression)Expr_451_list.get(0);
		Assert.assertNotNull(PrimaryExpression_452_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_452_Var
		.getId());
		final EList<? extends EObject> Suffix_452_list = PostfixExpression_451_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_452_list);
		Assert.assertEquals(1, Suffix_452_list.size());
		//452
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_453_Var
		 = (PostfixExpressionSuffixDot)Suffix_452_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_453_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_453_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_401_Var
		.getSemi());
		//453
		final Statement Statement_454_Var
		 = (Statement)Statement_104_list.get(6);
		Assert.assertNotNull(Statement_454_Var
		);
		//454
		final ExpressionStatement ExpressionStatement_455_Var
		 = (ExpressionStatement)Statement_454_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_455_Var
		);
		//455
		final Expression Expression_456_Var
		 = (Expression)ExpressionStatement_455_Var
		.getExpression();
		Assert.assertNotNull(Expression_456_Var
		);
		final EList<? extends EObject> ExprExpr_456_list = Expression_456_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_456_list);
		Assert.assertEquals(1, ExprExpr_456_list.size());
		//456
		final AssignmentExpression AssignmentExpression_457_Var
		 = (AssignmentExpression)ExprExpr_456_list.get(0);
		Assert.assertNotNull(AssignmentExpression_457_Var
		);
		//457
		final ConditionalExpression ConditionalExpression_458_Var
		 = (ConditionalExpression)AssignmentExpression_457_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_458_Var
		);
		//458
		final LogicalOrExpression LogicalOrExpression_459_Var
		 = (LogicalOrExpression)ConditionalExpression_458_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_459_Var
		);
		final EList<? extends EObject> Expr_459_list = LogicalOrExpression_459_Var
		.getExpr();
		Assert.assertNotNull(Expr_459_list);
		Assert.assertEquals(1, Expr_459_list.size());
		//459
		final LogicalAndExpression LogicalAndExpression_460_Var
		 = (LogicalAndExpression)Expr_459_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_460_Var
		);
		final EList<? extends EObject> Expr_460_list = LogicalAndExpression_460_Var
		.getExpr();
		Assert.assertNotNull(Expr_460_list);
		Assert.assertEquals(1, Expr_460_list.size());
		//460
		final InclusiveOrExpression InclusiveOrExpression_461_Var
		 = (InclusiveOrExpression)Expr_460_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_461_Var
		);
		final EList<? extends EObject> Expr_461_list = InclusiveOrExpression_461_Var
		.getExpr();
		Assert.assertNotNull(Expr_461_list);
		Assert.assertEquals(1, Expr_461_list.size());
		//461
		final ExclusiveOrExpression ExclusiveOrExpression_462_Var
		 = (ExclusiveOrExpression)Expr_461_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_462_Var
		);
		final EList<? extends EObject> Expr_462_list = ExclusiveOrExpression_462_Var
		.getExpr();
		Assert.assertNotNull(Expr_462_list);
		Assert.assertEquals(1, Expr_462_list.size());
		//462
		final AndExpression AndExpression_463_Var
		 = (AndExpression)Expr_462_list.get(0);
		Assert.assertNotNull(AndExpression_463_Var
		);
		final EList<? extends EObject> Expr_463_list = AndExpression_463_Var
		.getExpr();
		Assert.assertNotNull(Expr_463_list);
		Assert.assertEquals(1, Expr_463_list.size());
		//463
		final EqualityExpression EqualityExpression_464_Var
		 = (EqualityExpression)Expr_463_list.get(0);
		Assert.assertNotNull(EqualityExpression_464_Var
		);
		final EList<? extends EObject> Expr_464_list = EqualityExpression_464_Var
		.getExpr();
		Assert.assertNotNull(Expr_464_list);
		Assert.assertEquals(1, Expr_464_list.size());
		//464
		final RelationalExpression RelationalExpression_465_Var
		 = (RelationalExpression)Expr_464_list.get(0);
		Assert.assertNotNull(RelationalExpression_465_Var
		);
		final EList<? extends EObject> Expr_465_list = RelationalExpression_465_Var
		.getExpr();
		Assert.assertNotNull(Expr_465_list);
		Assert.assertEquals(1, Expr_465_list.size());
		//465
		final ShiftExpression ShiftExpression_466_Var
		 = (ShiftExpression)Expr_465_list.get(0);
		Assert.assertNotNull(ShiftExpression_466_Var
		);
		final EList<? extends EObject> Expr_466_list = ShiftExpression_466_Var
		.getExpr();
		Assert.assertNotNull(Expr_466_list);
		Assert.assertEquals(1, Expr_466_list.size());
		//466
		final AdditiveExpression AdditiveExpression_467_Var
		 = (AdditiveExpression)Expr_466_list.get(0);
		Assert.assertNotNull(AdditiveExpression_467_Var
		);
		final EList<? extends EObject> Expr_467_list = AdditiveExpression_467_Var
		.getExpr();
		Assert.assertNotNull(Expr_467_list);
		Assert.assertEquals(1, Expr_467_list.size());
		//467
		final MultiplicativeExpression MultiplicativeExpression_468_Var
		 = (MultiplicativeExpression)Expr_467_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_468_Var
		);
		final EList<? extends EObject> Expr_468_list = MultiplicativeExpression_468_Var
		.getExpr();
		Assert.assertNotNull(Expr_468_list);
		Assert.assertEquals(1, Expr_468_list.size());
		//468
		final CastExpression CastExpression_469_Var
		 = (CastExpression)Expr_468_list.get(0);
		Assert.assertNotNull(CastExpression_469_Var
		);
		//469
		final UnaryExpression UnaryExpression_470_Var
		 = (UnaryExpression)CastExpression_469_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_470_Var
		);
		//470
		final PostfixExpression PostfixExpression_471_Var
		 = (PostfixExpression)UnaryExpression_470_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_471_Var
		);
		final EList<? extends EObject> Expr_471_list = PostfixExpression_471_Var
		.getExpr();
		Assert.assertNotNull(Expr_471_list);
		Assert.assertEquals(1, Expr_471_list.size());
		//471
		final PrimaryExpression PrimaryExpression_472_Var
		 = (PrimaryExpression)Expr_471_list.get(0);
		Assert.assertNotNull(PrimaryExpression_472_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_472_Var
		.getId());
		final EList<? extends EObject> Suffix_472_list = PostfixExpression_471_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_472_list);
		Assert.assertEquals(1, Suffix_472_list.size());
		//472
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_473_Var
		 = (PostfixExpressionSuffixArgument)Suffix_472_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_473_Var
		);
		//473
		final ArgumentExpressionList ArgumentExpressionList_474_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_473_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_474_Var
		);
		final EList<? extends EObject> Expr_474_list = ArgumentExpressionList_474_Var
		.getExpr();
		Assert.assertNotNull(Expr_474_list);
		Assert.assertEquals(2, Expr_474_list.size());
		//474
		final AssignmentExpression AssignmentExpression_475_Var
		 = (AssignmentExpression)Expr_474_list.get(0);
		Assert.assertNotNull(AssignmentExpression_475_Var
		);
		//475
		final ConditionalExpression ConditionalExpression_476_Var
		 = (ConditionalExpression)AssignmentExpression_475_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_476_Var
		);
		//476
		final LogicalOrExpression LogicalOrExpression_477_Var
		 = (LogicalOrExpression)ConditionalExpression_476_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_477_Var
		);
		final EList<? extends EObject> Expr_477_list = LogicalOrExpression_477_Var
		.getExpr();
		Assert.assertNotNull(Expr_477_list);
		Assert.assertEquals(1, Expr_477_list.size());
		//477
		final LogicalAndExpression LogicalAndExpression_478_Var
		 = (LogicalAndExpression)Expr_477_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_478_Var
		);
		final EList<? extends EObject> Expr_478_list = LogicalAndExpression_478_Var
		.getExpr();
		Assert.assertNotNull(Expr_478_list);
		Assert.assertEquals(1, Expr_478_list.size());
		//478
		final InclusiveOrExpression InclusiveOrExpression_479_Var
		 = (InclusiveOrExpression)Expr_478_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_479_Var
		);
		final EList<? extends EObject> Expr_479_list = InclusiveOrExpression_479_Var
		.getExpr();
		Assert.assertNotNull(Expr_479_list);
		Assert.assertEquals(1, Expr_479_list.size());
		//479
		final ExclusiveOrExpression ExclusiveOrExpression_480_Var
		 = (ExclusiveOrExpression)Expr_479_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_480_Var
		);
		final EList<? extends EObject> Expr_480_list = ExclusiveOrExpression_480_Var
		.getExpr();
		Assert.assertNotNull(Expr_480_list);
		Assert.assertEquals(1, Expr_480_list.size());
		//480
		final AndExpression AndExpression_481_Var
		 = (AndExpression)Expr_480_list.get(0);
		Assert.assertNotNull(AndExpression_481_Var
		);
		final EList<? extends EObject> Expr_481_list = AndExpression_481_Var
		.getExpr();
		Assert.assertNotNull(Expr_481_list);
		Assert.assertEquals(1, Expr_481_list.size());
		//481
		final EqualityExpression EqualityExpression_482_Var
		 = (EqualityExpression)Expr_481_list.get(0);
		Assert.assertNotNull(EqualityExpression_482_Var
		);
		final EList<? extends EObject> Expr_482_list = EqualityExpression_482_Var
		.getExpr();
		Assert.assertNotNull(Expr_482_list);
		Assert.assertEquals(1, Expr_482_list.size());
		//482
		final RelationalExpression RelationalExpression_483_Var
		 = (RelationalExpression)Expr_482_list.get(0);
		Assert.assertNotNull(RelationalExpression_483_Var
		);
		final EList<? extends EObject> Expr_483_list = RelationalExpression_483_Var
		.getExpr();
		Assert.assertNotNull(Expr_483_list);
		Assert.assertEquals(1, Expr_483_list.size());
		//483
		final ShiftExpression ShiftExpression_484_Var
		 = (ShiftExpression)Expr_483_list.get(0);
		Assert.assertNotNull(ShiftExpression_484_Var
		);
		final EList<? extends EObject> Expr_484_list = ShiftExpression_484_Var
		.getExpr();
		Assert.assertNotNull(Expr_484_list);
		Assert.assertEquals(1, Expr_484_list.size());
		//484
		final AdditiveExpression AdditiveExpression_485_Var
		 = (AdditiveExpression)Expr_484_list.get(0);
		Assert.assertNotNull(AdditiveExpression_485_Var
		);
		final EList<? extends EObject> Expr_485_list = AdditiveExpression_485_Var
		.getExpr();
		Assert.assertNotNull(Expr_485_list);
		Assert.assertEquals(1, Expr_485_list.size());
		//485
		final MultiplicativeExpression MultiplicativeExpression_486_Var
		 = (MultiplicativeExpression)Expr_485_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_486_Var
		);
		final EList<? extends EObject> Expr_486_list = MultiplicativeExpression_486_Var
		.getExpr();
		Assert.assertNotNull(Expr_486_list);
		Assert.assertEquals(1, Expr_486_list.size());
		//486
		final CastExpression CastExpression_487_Var
		 = (CastExpression)Expr_486_list.get(0);
		Assert.assertNotNull(CastExpression_487_Var
		);
		//487
		final UnaryExpression UnaryExpression_488_Var
		 = (UnaryExpression)CastExpression_487_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_488_Var
		);
		//488
		final PostfixExpression PostfixExpression_489_Var
		 = (PostfixExpression)UnaryExpression_488_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_489_Var
		);
		final EList<? extends EObject> Expr_489_list = PostfixExpression_489_Var
		.getExpr();
		Assert.assertNotNull(Expr_489_list);
		Assert.assertEquals(1, Expr_489_list.size());
		//489
		final PrimaryExpression PrimaryExpression_490_Var
		 = (PrimaryExpression)Expr_489_list.get(0);
		Assert.assertNotNull(PrimaryExpression_490_Var
		);
		Assert.assertEquals("[\"joe.name=%s\\n\"]", PrimaryExpression_490_Var
		.getString().toString());
		//490
		final AssignmentExpression AssignmentExpression_491_Var
		 = (AssignmentExpression)Expr_474_list.get(1);
		Assert.assertNotNull(AssignmentExpression_491_Var
		);
		//491
		final ConditionalExpression ConditionalExpression_492_Var
		 = (ConditionalExpression)AssignmentExpression_491_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_492_Var
		);
		//492
		final LogicalOrExpression LogicalOrExpression_493_Var
		 = (LogicalOrExpression)ConditionalExpression_492_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_493_Var
		);
		final EList<? extends EObject> Expr_493_list = LogicalOrExpression_493_Var
		.getExpr();
		Assert.assertNotNull(Expr_493_list);
		Assert.assertEquals(1, Expr_493_list.size());
		//493
		final LogicalAndExpression LogicalAndExpression_494_Var
		 = (LogicalAndExpression)Expr_493_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_494_Var
		);
		final EList<? extends EObject> Expr_494_list = LogicalAndExpression_494_Var
		.getExpr();
		Assert.assertNotNull(Expr_494_list);
		Assert.assertEquals(1, Expr_494_list.size());
		//494
		final InclusiveOrExpression InclusiveOrExpression_495_Var
		 = (InclusiveOrExpression)Expr_494_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_495_Var
		);
		final EList<? extends EObject> Expr_495_list = InclusiveOrExpression_495_Var
		.getExpr();
		Assert.assertNotNull(Expr_495_list);
		Assert.assertEquals(1, Expr_495_list.size());
		//495
		final ExclusiveOrExpression ExclusiveOrExpression_496_Var
		 = (ExclusiveOrExpression)Expr_495_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_496_Var
		);
		final EList<? extends EObject> Expr_496_list = ExclusiveOrExpression_496_Var
		.getExpr();
		Assert.assertNotNull(Expr_496_list);
		Assert.assertEquals(1, Expr_496_list.size());
		//496
		final AndExpression AndExpression_497_Var
		 = (AndExpression)Expr_496_list.get(0);
		Assert.assertNotNull(AndExpression_497_Var
		);
		final EList<? extends EObject> Expr_497_list = AndExpression_497_Var
		.getExpr();
		Assert.assertNotNull(Expr_497_list);
		Assert.assertEquals(1, Expr_497_list.size());
		//497
		final EqualityExpression EqualityExpression_498_Var
		 = (EqualityExpression)Expr_497_list.get(0);
		Assert.assertNotNull(EqualityExpression_498_Var
		);
		final EList<? extends EObject> Expr_498_list = EqualityExpression_498_Var
		.getExpr();
		Assert.assertNotNull(Expr_498_list);
		Assert.assertEquals(1, Expr_498_list.size());
		//498
		final RelationalExpression RelationalExpression_499_Var
		 = (RelationalExpression)Expr_498_list.get(0);
		Assert.assertNotNull(RelationalExpression_499_Var
		);
		final EList<? extends EObject> Expr_499_list = RelationalExpression_499_Var
		.getExpr();
		Assert.assertNotNull(Expr_499_list);
		Assert.assertEquals(1, Expr_499_list.size());
		//499
		final ShiftExpression ShiftExpression_500_Var
		 = (ShiftExpression)Expr_499_list.get(0);
		Assert.assertNotNull(ShiftExpression_500_Var
		);
		final EList<? extends EObject> Expr_500_list = ShiftExpression_500_Var
		.getExpr();
		Assert.assertNotNull(Expr_500_list);
		Assert.assertEquals(1, Expr_500_list.size());
		//500
		final AdditiveExpression AdditiveExpression_501_Var
		 = (AdditiveExpression)Expr_500_list.get(0);
		Assert.assertNotNull(AdditiveExpression_501_Var
		);
		final EList<? extends EObject> Expr_501_list = AdditiveExpression_501_Var
		.getExpr();
		Assert.assertNotNull(Expr_501_list);
		Assert.assertEquals(1, Expr_501_list.size());
		//501
		final MultiplicativeExpression MultiplicativeExpression_502_Var
		 = (MultiplicativeExpression)Expr_501_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_502_Var
		);
		final EList<? extends EObject> Expr_502_list = MultiplicativeExpression_502_Var
		.getExpr();
		Assert.assertNotNull(Expr_502_list);
		Assert.assertEquals(1, Expr_502_list.size());
		//502
		final CastExpression CastExpression_503_Var
		 = (CastExpression)Expr_502_list.get(0);
		Assert.assertNotNull(CastExpression_503_Var
		);
		//503
		final UnaryExpression UnaryExpression_504_Var
		 = (UnaryExpression)CastExpression_503_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_504_Var
		);
		//504
		final PostfixExpression PostfixExpression_505_Var
		 = (PostfixExpression)UnaryExpression_504_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_505_Var
		);
		final EList<? extends EObject> Expr_505_list = PostfixExpression_505_Var
		.getExpr();
		Assert.assertNotNull(Expr_505_list);
		Assert.assertEquals(1, Expr_505_list.size());
		//505
		final PrimaryExpression PrimaryExpression_506_Var
		 = (PrimaryExpression)Expr_505_list.get(0);
		Assert.assertNotNull(PrimaryExpression_506_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_506_Var
		.getId());
		final EList<? extends EObject> Suffix_506_list = PostfixExpression_505_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_506_list);
		Assert.assertEquals(1, Suffix_506_list.size());
		//506
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_507_Var
		 = (PostfixExpressionSuffixDot)Suffix_506_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_507_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_507_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_455_Var
		.getSemi());
		//507
		final Statement Statement_508_Var
		 = (Statement)Statement_104_list.get(7);
		Assert.assertNotNull(Statement_508_Var
		);
		//508
		final ExpressionStatement ExpressionStatement_509_Var
		 = (ExpressionStatement)Statement_508_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_509_Var
		);
		//509
		final Expression Expression_510_Var
		 = (Expression)ExpressionStatement_509_Var
		.getExpression();
		Assert.assertNotNull(Expression_510_Var
		);
		final EList<? extends EObject> ExprExpr_510_list = Expression_510_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_510_list);
		Assert.assertEquals(1, ExprExpr_510_list.size());
		//510
		final AssignmentExpression AssignmentExpression_511_Var
		 = (AssignmentExpression)ExprExpr_510_list.get(0);
		Assert.assertNotNull(AssignmentExpression_511_Var
		);
		//511
		final ConditionalExpression ConditionalExpression_512_Var
		 = (ConditionalExpression)AssignmentExpression_511_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_512_Var
		);
		//512
		final LogicalOrExpression LogicalOrExpression_513_Var
		 = (LogicalOrExpression)ConditionalExpression_512_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_513_Var
		);
		final EList<? extends EObject> Expr_513_list = LogicalOrExpression_513_Var
		.getExpr();
		Assert.assertNotNull(Expr_513_list);
		Assert.assertEquals(1, Expr_513_list.size());
		//513
		final LogicalAndExpression LogicalAndExpression_514_Var
		 = (LogicalAndExpression)Expr_513_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_514_Var
		);
		final EList<? extends EObject> Expr_514_list = LogicalAndExpression_514_Var
		.getExpr();
		Assert.assertNotNull(Expr_514_list);
		Assert.assertEquals(1, Expr_514_list.size());
		//514
		final InclusiveOrExpression InclusiveOrExpression_515_Var
		 = (InclusiveOrExpression)Expr_514_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_515_Var
		);
		final EList<? extends EObject> Expr_515_list = InclusiveOrExpression_515_Var
		.getExpr();
		Assert.assertNotNull(Expr_515_list);
		Assert.assertEquals(1, Expr_515_list.size());
		//515
		final ExclusiveOrExpression ExclusiveOrExpression_516_Var
		 = (ExclusiveOrExpression)Expr_515_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_516_Var
		);
		final EList<? extends EObject> Expr_516_list = ExclusiveOrExpression_516_Var
		.getExpr();
		Assert.assertNotNull(Expr_516_list);
		Assert.assertEquals(1, Expr_516_list.size());
		//516
		final AndExpression AndExpression_517_Var
		 = (AndExpression)Expr_516_list.get(0);
		Assert.assertNotNull(AndExpression_517_Var
		);
		final EList<? extends EObject> Expr_517_list = AndExpression_517_Var
		.getExpr();
		Assert.assertNotNull(Expr_517_list);
		Assert.assertEquals(1, Expr_517_list.size());
		//517
		final EqualityExpression EqualityExpression_518_Var
		 = (EqualityExpression)Expr_517_list.get(0);
		Assert.assertNotNull(EqualityExpression_518_Var
		);
		final EList<? extends EObject> Expr_518_list = EqualityExpression_518_Var
		.getExpr();
		Assert.assertNotNull(Expr_518_list);
		Assert.assertEquals(1, Expr_518_list.size());
		//518
		final RelationalExpression RelationalExpression_519_Var
		 = (RelationalExpression)Expr_518_list.get(0);
		Assert.assertNotNull(RelationalExpression_519_Var
		);
		final EList<? extends EObject> Expr_519_list = RelationalExpression_519_Var
		.getExpr();
		Assert.assertNotNull(Expr_519_list);
		Assert.assertEquals(1, Expr_519_list.size());
		//519
		final ShiftExpression ShiftExpression_520_Var
		 = (ShiftExpression)Expr_519_list.get(0);
		Assert.assertNotNull(ShiftExpression_520_Var
		);
		final EList<? extends EObject> Expr_520_list = ShiftExpression_520_Var
		.getExpr();
		Assert.assertNotNull(Expr_520_list);
		Assert.assertEquals(1, Expr_520_list.size());
		//520
		final AdditiveExpression AdditiveExpression_521_Var
		 = (AdditiveExpression)Expr_520_list.get(0);
		Assert.assertNotNull(AdditiveExpression_521_Var
		);
		final EList<? extends EObject> Expr_521_list = AdditiveExpression_521_Var
		.getExpr();
		Assert.assertNotNull(Expr_521_list);
		Assert.assertEquals(1, Expr_521_list.size());
		//521
		final MultiplicativeExpression MultiplicativeExpression_522_Var
		 = (MultiplicativeExpression)Expr_521_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_522_Var
		);
		final EList<? extends EObject> Expr_522_list = MultiplicativeExpression_522_Var
		.getExpr();
		Assert.assertNotNull(Expr_522_list);
		Assert.assertEquals(1, Expr_522_list.size());
		//522
		final CastExpression CastExpression_523_Var
		 = (CastExpression)Expr_522_list.get(0);
		Assert.assertNotNull(CastExpression_523_Var
		);
		//523
		final UnaryExpression UnaryExpression_524_Var
		 = (UnaryExpression)CastExpression_523_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_524_Var
		);
		//524
		final PostfixExpression PostfixExpression_525_Var
		 = (PostfixExpression)UnaryExpression_524_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_525_Var
		);
		final EList<? extends EObject> Expr_525_list = PostfixExpression_525_Var
		.getExpr();
		Assert.assertNotNull(Expr_525_list);
		Assert.assertEquals(1, Expr_525_list.size());
		//525
		final PrimaryExpression PrimaryExpression_526_Var
		 = (PrimaryExpression)Expr_525_list.get(0);
		Assert.assertNotNull(PrimaryExpression_526_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_526_Var
		.getId());
		final EList<? extends EObject> Suffix_526_list = PostfixExpression_525_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_526_list);
		Assert.assertEquals(1, Suffix_526_list.size());
		//526
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_527_Var
		 = (PostfixExpressionSuffixArgument)Suffix_526_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_527_Var
		);
		//527
		final ArgumentExpressionList ArgumentExpressionList_528_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_527_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_528_Var
		);
		final EList<? extends EObject> Expr_528_list = ArgumentExpressionList_528_Var
		.getExpr();
		Assert.assertNotNull(Expr_528_list);
		Assert.assertEquals(2, Expr_528_list.size());
		//528
		final AssignmentExpression AssignmentExpression_529_Var
		 = (AssignmentExpression)Expr_528_list.get(0);
		Assert.assertNotNull(AssignmentExpression_529_Var
		);
		//529
		final ConditionalExpression ConditionalExpression_530_Var
		 = (ConditionalExpression)AssignmentExpression_529_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_530_Var
		);
		//530
		final LogicalOrExpression LogicalOrExpression_531_Var
		 = (LogicalOrExpression)ConditionalExpression_530_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_531_Var
		);
		final EList<? extends EObject> Expr_531_list = LogicalOrExpression_531_Var
		.getExpr();
		Assert.assertNotNull(Expr_531_list);
		Assert.assertEquals(1, Expr_531_list.size());
		//531
		final LogicalAndExpression LogicalAndExpression_532_Var
		 = (LogicalAndExpression)Expr_531_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_532_Var
		);
		final EList<? extends EObject> Expr_532_list = LogicalAndExpression_532_Var
		.getExpr();
		Assert.assertNotNull(Expr_532_list);
		Assert.assertEquals(1, Expr_532_list.size());
		//532
		final InclusiveOrExpression InclusiveOrExpression_533_Var
		 = (InclusiveOrExpression)Expr_532_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_533_Var
		);
		final EList<? extends EObject> Expr_533_list = InclusiveOrExpression_533_Var
		.getExpr();
		Assert.assertNotNull(Expr_533_list);
		Assert.assertEquals(1, Expr_533_list.size());
		//533
		final ExclusiveOrExpression ExclusiveOrExpression_534_Var
		 = (ExclusiveOrExpression)Expr_533_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_534_Var
		);
		final EList<? extends EObject> Expr_534_list = ExclusiveOrExpression_534_Var
		.getExpr();
		Assert.assertNotNull(Expr_534_list);
		Assert.assertEquals(1, Expr_534_list.size());
		//534
		final AndExpression AndExpression_535_Var
		 = (AndExpression)Expr_534_list.get(0);
		Assert.assertNotNull(AndExpression_535_Var
		);
		final EList<? extends EObject> Expr_535_list = AndExpression_535_Var
		.getExpr();
		Assert.assertNotNull(Expr_535_list);
		Assert.assertEquals(1, Expr_535_list.size());
		//535
		final EqualityExpression EqualityExpression_536_Var
		 = (EqualityExpression)Expr_535_list.get(0);
		Assert.assertNotNull(EqualityExpression_536_Var
		);
		final EList<? extends EObject> Expr_536_list = EqualityExpression_536_Var
		.getExpr();
		Assert.assertNotNull(Expr_536_list);
		Assert.assertEquals(1, Expr_536_list.size());
		//536
		final RelationalExpression RelationalExpression_537_Var
		 = (RelationalExpression)Expr_536_list.get(0);
		Assert.assertNotNull(RelationalExpression_537_Var
		);
		final EList<? extends EObject> Expr_537_list = RelationalExpression_537_Var
		.getExpr();
		Assert.assertNotNull(Expr_537_list);
		Assert.assertEquals(1, Expr_537_list.size());
		//537
		final ShiftExpression ShiftExpression_538_Var
		 = (ShiftExpression)Expr_537_list.get(0);
		Assert.assertNotNull(ShiftExpression_538_Var
		);
		final EList<? extends EObject> Expr_538_list = ShiftExpression_538_Var
		.getExpr();
		Assert.assertNotNull(Expr_538_list);
		Assert.assertEquals(1, Expr_538_list.size());
		//538
		final AdditiveExpression AdditiveExpression_539_Var
		 = (AdditiveExpression)Expr_538_list.get(0);
		Assert.assertNotNull(AdditiveExpression_539_Var
		);
		final EList<? extends EObject> Expr_539_list = AdditiveExpression_539_Var
		.getExpr();
		Assert.assertNotNull(Expr_539_list);
		Assert.assertEquals(1, Expr_539_list.size());
		//539
		final MultiplicativeExpression MultiplicativeExpression_540_Var
		 = (MultiplicativeExpression)Expr_539_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_540_Var
		);
		final EList<? extends EObject> Expr_540_list = MultiplicativeExpression_540_Var
		.getExpr();
		Assert.assertNotNull(Expr_540_list);
		Assert.assertEquals(1, Expr_540_list.size());
		//540
		final CastExpression CastExpression_541_Var
		 = (CastExpression)Expr_540_list.get(0);
		Assert.assertNotNull(CastExpression_541_Var
		);
		//541
		final UnaryExpression UnaryExpression_542_Var
		 = (UnaryExpression)CastExpression_541_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_542_Var
		);
		//542
		final PostfixExpression PostfixExpression_543_Var
		 = (PostfixExpression)UnaryExpression_542_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_543_Var
		);
		final EList<? extends EObject> Expr_543_list = PostfixExpression_543_Var
		.getExpr();
		Assert.assertNotNull(Expr_543_list);
		Assert.assertEquals(1, Expr_543_list.size());
		//543
		final PrimaryExpression PrimaryExpression_544_Var
		 = (PrimaryExpression)Expr_543_list.get(0);
		Assert.assertNotNull(PrimaryExpression_544_Var
		);
		Assert.assertEquals("[\"phil.id=%d\\n\"]", PrimaryExpression_544_Var
		.getString().toString());
		//544
		final AssignmentExpression AssignmentExpression_545_Var
		 = (AssignmentExpression)Expr_528_list.get(1);
		Assert.assertNotNull(AssignmentExpression_545_Var
		);
		//545
		final ConditionalExpression ConditionalExpression_546_Var
		 = (ConditionalExpression)AssignmentExpression_545_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_546_Var
		);
		//546
		final LogicalOrExpression LogicalOrExpression_547_Var
		 = (LogicalOrExpression)ConditionalExpression_546_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_547_Var
		);
		final EList<? extends EObject> Expr_547_list = LogicalOrExpression_547_Var
		.getExpr();
		Assert.assertNotNull(Expr_547_list);
		Assert.assertEquals(1, Expr_547_list.size());
		//547
		final LogicalAndExpression LogicalAndExpression_548_Var
		 = (LogicalAndExpression)Expr_547_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_548_Var
		);
		final EList<? extends EObject> Expr_548_list = LogicalAndExpression_548_Var
		.getExpr();
		Assert.assertNotNull(Expr_548_list);
		Assert.assertEquals(1, Expr_548_list.size());
		//548
		final InclusiveOrExpression InclusiveOrExpression_549_Var
		 = (InclusiveOrExpression)Expr_548_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_549_Var
		);
		final EList<? extends EObject> Expr_549_list = InclusiveOrExpression_549_Var
		.getExpr();
		Assert.assertNotNull(Expr_549_list);
		Assert.assertEquals(1, Expr_549_list.size());
		//549
		final ExclusiveOrExpression ExclusiveOrExpression_550_Var
		 = (ExclusiveOrExpression)Expr_549_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_550_Var
		);
		final EList<? extends EObject> Expr_550_list = ExclusiveOrExpression_550_Var
		.getExpr();
		Assert.assertNotNull(Expr_550_list);
		Assert.assertEquals(1, Expr_550_list.size());
		//550
		final AndExpression AndExpression_551_Var
		 = (AndExpression)Expr_550_list.get(0);
		Assert.assertNotNull(AndExpression_551_Var
		);
		final EList<? extends EObject> Expr_551_list = AndExpression_551_Var
		.getExpr();
		Assert.assertNotNull(Expr_551_list);
		Assert.assertEquals(1, Expr_551_list.size());
		//551
		final EqualityExpression EqualityExpression_552_Var
		 = (EqualityExpression)Expr_551_list.get(0);
		Assert.assertNotNull(EqualityExpression_552_Var
		);
		final EList<? extends EObject> Expr_552_list = EqualityExpression_552_Var
		.getExpr();
		Assert.assertNotNull(Expr_552_list);
		Assert.assertEquals(1, Expr_552_list.size());
		//552
		final RelationalExpression RelationalExpression_553_Var
		 = (RelationalExpression)Expr_552_list.get(0);
		Assert.assertNotNull(RelationalExpression_553_Var
		);
		final EList<? extends EObject> Expr_553_list = RelationalExpression_553_Var
		.getExpr();
		Assert.assertNotNull(Expr_553_list);
		Assert.assertEquals(1, Expr_553_list.size());
		//553
		final ShiftExpression ShiftExpression_554_Var
		 = (ShiftExpression)Expr_553_list.get(0);
		Assert.assertNotNull(ShiftExpression_554_Var
		);
		final EList<? extends EObject> Expr_554_list = ShiftExpression_554_Var
		.getExpr();
		Assert.assertNotNull(Expr_554_list);
		Assert.assertEquals(1, Expr_554_list.size());
		//554
		final AdditiveExpression AdditiveExpression_555_Var
		 = (AdditiveExpression)Expr_554_list.get(0);
		Assert.assertNotNull(AdditiveExpression_555_Var
		);
		final EList<? extends EObject> Expr_555_list = AdditiveExpression_555_Var
		.getExpr();
		Assert.assertNotNull(Expr_555_list);
		Assert.assertEquals(1, Expr_555_list.size());
		//555
		final MultiplicativeExpression MultiplicativeExpression_556_Var
		 = (MultiplicativeExpression)Expr_555_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_556_Var
		);
		final EList<? extends EObject> Expr_556_list = MultiplicativeExpression_556_Var
		.getExpr();
		Assert.assertNotNull(Expr_556_list);
		Assert.assertEquals(1, Expr_556_list.size());
		//556
		final CastExpression CastExpression_557_Var
		 = (CastExpression)Expr_556_list.get(0);
		Assert.assertNotNull(CastExpression_557_Var
		);
		//557
		final UnaryExpression UnaryExpression_558_Var
		 = (UnaryExpression)CastExpression_557_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_558_Var
		);
		//558
		final PostfixExpression PostfixExpression_559_Var
		 = (PostfixExpression)UnaryExpression_558_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_559_Var
		);
		final EList<? extends EObject> Expr_559_list = PostfixExpression_559_Var
		.getExpr();
		Assert.assertNotNull(Expr_559_list);
		Assert.assertEquals(1, Expr_559_list.size());
		//559
		final PrimaryExpression PrimaryExpression_560_Var
		 = (PrimaryExpression)Expr_559_list.get(0);
		Assert.assertNotNull(PrimaryExpression_560_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_560_Var
		.getId());
		final EList<? extends EObject> Suffix_560_list = PostfixExpression_559_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_560_list);
		Assert.assertEquals(1, Suffix_560_list.size());
		//560
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_561_Var
		 = (PostfixExpressionSuffixDot)Suffix_560_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_561_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_561_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_509_Var
		.getSemi());
		//561
		final Statement Statement_562_Var
		 = (Statement)Statement_104_list.get(8);
		Assert.assertNotNull(Statement_562_Var
		);
		//562
		final ExpressionStatement ExpressionStatement_563_Var
		 = (ExpressionStatement)Statement_562_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_563_Var
		);
		//563
		final Expression Expression_564_Var
		 = (Expression)ExpressionStatement_563_Var
		.getExpression();
		Assert.assertNotNull(Expression_564_Var
		);
		final EList<? extends EObject> ExprExpr_564_list = Expression_564_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_564_list);
		Assert.assertEquals(1, ExprExpr_564_list.size());
		//564
		final AssignmentExpression AssignmentExpression_565_Var
		 = (AssignmentExpression)ExprExpr_564_list.get(0);
		Assert.assertNotNull(AssignmentExpression_565_Var
		);
		//565
		final ConditionalExpression ConditionalExpression_566_Var
		 = (ConditionalExpression)AssignmentExpression_565_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_566_Var
		);
		//566
		final LogicalOrExpression LogicalOrExpression_567_Var
		 = (LogicalOrExpression)ConditionalExpression_566_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_567_Var
		);
		final EList<? extends EObject> Expr_567_list = LogicalOrExpression_567_Var
		.getExpr();
		Assert.assertNotNull(Expr_567_list);
		Assert.assertEquals(1, Expr_567_list.size());
		//567
		final LogicalAndExpression LogicalAndExpression_568_Var
		 = (LogicalAndExpression)Expr_567_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_568_Var
		);
		final EList<? extends EObject> Expr_568_list = LogicalAndExpression_568_Var
		.getExpr();
		Assert.assertNotNull(Expr_568_list);
		Assert.assertEquals(1, Expr_568_list.size());
		//568
		final InclusiveOrExpression InclusiveOrExpression_569_Var
		 = (InclusiveOrExpression)Expr_568_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_569_Var
		);
		final EList<? extends EObject> Expr_569_list = InclusiveOrExpression_569_Var
		.getExpr();
		Assert.assertNotNull(Expr_569_list);
		Assert.assertEquals(1, Expr_569_list.size());
		//569
		final ExclusiveOrExpression ExclusiveOrExpression_570_Var
		 = (ExclusiveOrExpression)Expr_569_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_570_Var
		);
		final EList<? extends EObject> Expr_570_list = ExclusiveOrExpression_570_Var
		.getExpr();
		Assert.assertNotNull(Expr_570_list);
		Assert.assertEquals(1, Expr_570_list.size());
		//570
		final AndExpression AndExpression_571_Var
		 = (AndExpression)Expr_570_list.get(0);
		Assert.assertNotNull(AndExpression_571_Var
		);
		final EList<? extends EObject> Expr_571_list = AndExpression_571_Var
		.getExpr();
		Assert.assertNotNull(Expr_571_list);
		Assert.assertEquals(1, Expr_571_list.size());
		//571
		final EqualityExpression EqualityExpression_572_Var
		 = (EqualityExpression)Expr_571_list.get(0);
		Assert.assertNotNull(EqualityExpression_572_Var
		);
		final EList<? extends EObject> Expr_572_list = EqualityExpression_572_Var
		.getExpr();
		Assert.assertNotNull(Expr_572_list);
		Assert.assertEquals(1, Expr_572_list.size());
		//572
		final RelationalExpression RelationalExpression_573_Var
		 = (RelationalExpression)Expr_572_list.get(0);
		Assert.assertNotNull(RelationalExpression_573_Var
		);
		final EList<? extends EObject> Expr_573_list = RelationalExpression_573_Var
		.getExpr();
		Assert.assertNotNull(Expr_573_list);
		Assert.assertEquals(1, Expr_573_list.size());
		//573
		final ShiftExpression ShiftExpression_574_Var
		 = (ShiftExpression)Expr_573_list.get(0);
		Assert.assertNotNull(ShiftExpression_574_Var
		);
		final EList<? extends EObject> Expr_574_list = ShiftExpression_574_Var
		.getExpr();
		Assert.assertNotNull(Expr_574_list);
		Assert.assertEquals(1, Expr_574_list.size());
		//574
		final AdditiveExpression AdditiveExpression_575_Var
		 = (AdditiveExpression)Expr_574_list.get(0);
		Assert.assertNotNull(AdditiveExpression_575_Var
		);
		final EList<? extends EObject> Expr_575_list = AdditiveExpression_575_Var
		.getExpr();
		Assert.assertNotNull(Expr_575_list);
		Assert.assertEquals(1, Expr_575_list.size());
		//575
		final MultiplicativeExpression MultiplicativeExpression_576_Var
		 = (MultiplicativeExpression)Expr_575_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_576_Var
		);
		final EList<? extends EObject> Expr_576_list = MultiplicativeExpression_576_Var
		.getExpr();
		Assert.assertNotNull(Expr_576_list);
		Assert.assertEquals(1, Expr_576_list.size());
		//576
		final CastExpression CastExpression_577_Var
		 = (CastExpression)Expr_576_list.get(0);
		Assert.assertNotNull(CastExpression_577_Var
		);
		//577
		final UnaryExpression UnaryExpression_578_Var
		 = (UnaryExpression)CastExpression_577_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_578_Var
		);
		//578
		final PostfixExpression PostfixExpression_579_Var
		 = (PostfixExpression)UnaryExpression_578_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_579_Var
		);
		final EList<? extends EObject> Expr_579_list = PostfixExpression_579_Var
		.getExpr();
		Assert.assertNotNull(Expr_579_list);
		Assert.assertEquals(1, Expr_579_list.size());
		//579
		final PrimaryExpression PrimaryExpression_580_Var
		 = (PrimaryExpression)Expr_579_list.get(0);
		Assert.assertNotNull(PrimaryExpression_580_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_580_Var
		.getId());
		final EList<? extends EObject> Suffix_580_list = PostfixExpression_579_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_580_list);
		Assert.assertEquals(1, Suffix_580_list.size());
		//580
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_581_Var
		 = (PostfixExpressionSuffixArgument)Suffix_580_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_581_Var
		);
		//581
		final ArgumentExpressionList ArgumentExpressionList_582_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_581_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_582_Var
		);
		final EList<? extends EObject> Expr_582_list = ArgumentExpressionList_582_Var
		.getExpr();
		Assert.assertNotNull(Expr_582_list);
		Assert.assertEquals(2, Expr_582_list.size());
		//582
		final AssignmentExpression AssignmentExpression_583_Var
		 = (AssignmentExpression)Expr_582_list.get(0);
		Assert.assertNotNull(AssignmentExpression_583_Var
		);
		//583
		final ConditionalExpression ConditionalExpression_584_Var
		 = (ConditionalExpression)AssignmentExpression_583_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_584_Var
		);
		//584
		final LogicalOrExpression LogicalOrExpression_585_Var
		 = (LogicalOrExpression)ConditionalExpression_584_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_585_Var
		);
		final EList<? extends EObject> Expr_585_list = LogicalOrExpression_585_Var
		.getExpr();
		Assert.assertNotNull(Expr_585_list);
		Assert.assertEquals(1, Expr_585_list.size());
		//585
		final LogicalAndExpression LogicalAndExpression_586_Var
		 = (LogicalAndExpression)Expr_585_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_586_Var
		);
		final EList<? extends EObject> Expr_586_list = LogicalAndExpression_586_Var
		.getExpr();
		Assert.assertNotNull(Expr_586_list);
		Assert.assertEquals(1, Expr_586_list.size());
		//586
		final InclusiveOrExpression InclusiveOrExpression_587_Var
		 = (InclusiveOrExpression)Expr_586_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_587_Var
		);
		final EList<? extends EObject> Expr_587_list = InclusiveOrExpression_587_Var
		.getExpr();
		Assert.assertNotNull(Expr_587_list);
		Assert.assertEquals(1, Expr_587_list.size());
		//587
		final ExclusiveOrExpression ExclusiveOrExpression_588_Var
		 = (ExclusiveOrExpression)Expr_587_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_588_Var
		);
		final EList<? extends EObject> Expr_588_list = ExclusiveOrExpression_588_Var
		.getExpr();
		Assert.assertNotNull(Expr_588_list);
		Assert.assertEquals(1, Expr_588_list.size());
		//588
		final AndExpression AndExpression_589_Var
		 = (AndExpression)Expr_588_list.get(0);
		Assert.assertNotNull(AndExpression_589_Var
		);
		final EList<? extends EObject> Expr_589_list = AndExpression_589_Var
		.getExpr();
		Assert.assertNotNull(Expr_589_list);
		Assert.assertEquals(1, Expr_589_list.size());
		//589
		final EqualityExpression EqualityExpression_590_Var
		 = (EqualityExpression)Expr_589_list.get(0);
		Assert.assertNotNull(EqualityExpression_590_Var
		);
		final EList<? extends EObject> Expr_590_list = EqualityExpression_590_Var
		.getExpr();
		Assert.assertNotNull(Expr_590_list);
		Assert.assertEquals(1, Expr_590_list.size());
		//590
		final RelationalExpression RelationalExpression_591_Var
		 = (RelationalExpression)Expr_590_list.get(0);
		Assert.assertNotNull(RelationalExpression_591_Var
		);
		final EList<? extends EObject> Expr_591_list = RelationalExpression_591_Var
		.getExpr();
		Assert.assertNotNull(Expr_591_list);
		Assert.assertEquals(1, Expr_591_list.size());
		//591
		final ShiftExpression ShiftExpression_592_Var
		 = (ShiftExpression)Expr_591_list.get(0);
		Assert.assertNotNull(ShiftExpression_592_Var
		);
		final EList<? extends EObject> Expr_592_list = ShiftExpression_592_Var
		.getExpr();
		Assert.assertNotNull(Expr_592_list);
		Assert.assertEquals(1, Expr_592_list.size());
		//592
		final AdditiveExpression AdditiveExpression_593_Var
		 = (AdditiveExpression)Expr_592_list.get(0);
		Assert.assertNotNull(AdditiveExpression_593_Var
		);
		final EList<? extends EObject> Expr_593_list = AdditiveExpression_593_Var
		.getExpr();
		Assert.assertNotNull(Expr_593_list);
		Assert.assertEquals(1, Expr_593_list.size());
		//593
		final MultiplicativeExpression MultiplicativeExpression_594_Var
		 = (MultiplicativeExpression)Expr_593_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_594_Var
		);
		final EList<? extends EObject> Expr_594_list = MultiplicativeExpression_594_Var
		.getExpr();
		Assert.assertNotNull(Expr_594_list);
		Assert.assertEquals(1, Expr_594_list.size());
		//594
		final CastExpression CastExpression_595_Var
		 = (CastExpression)Expr_594_list.get(0);
		Assert.assertNotNull(CastExpression_595_Var
		);
		//595
		final UnaryExpression UnaryExpression_596_Var
		 = (UnaryExpression)CastExpression_595_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_596_Var
		);
		//596
		final PostfixExpression PostfixExpression_597_Var
		 = (PostfixExpression)UnaryExpression_596_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_597_Var
		);
		final EList<? extends EObject> Expr_597_list = PostfixExpression_597_Var
		.getExpr();
		Assert.assertNotNull(Expr_597_list);
		Assert.assertEquals(1, Expr_597_list.size());
		//597
		final PrimaryExpression PrimaryExpression_598_Var
		 = (PrimaryExpression)Expr_597_list.get(0);
		Assert.assertNotNull(PrimaryExpression_598_Var
		);
		Assert.assertEquals("[\"phil.name=%s\\n\"]", PrimaryExpression_598_Var
		.getString().toString());
		//598
		final AssignmentExpression AssignmentExpression_599_Var
		 = (AssignmentExpression)Expr_582_list.get(1);
		Assert.assertNotNull(AssignmentExpression_599_Var
		);
		//599
		final ConditionalExpression ConditionalExpression_600_Var
		 = (ConditionalExpression)AssignmentExpression_599_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_600_Var
		);
		//600
		final LogicalOrExpression LogicalOrExpression_601_Var
		 = (LogicalOrExpression)ConditionalExpression_600_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_601_Var
		);
		final EList<? extends EObject> Expr_601_list = LogicalOrExpression_601_Var
		.getExpr();
		Assert.assertNotNull(Expr_601_list);
		Assert.assertEquals(1, Expr_601_list.size());
		//601
		final LogicalAndExpression LogicalAndExpression_602_Var
		 = (LogicalAndExpression)Expr_601_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_602_Var
		);
		final EList<? extends EObject> Expr_602_list = LogicalAndExpression_602_Var
		.getExpr();
		Assert.assertNotNull(Expr_602_list);
		Assert.assertEquals(1, Expr_602_list.size());
		//602
		final InclusiveOrExpression InclusiveOrExpression_603_Var
		 = (InclusiveOrExpression)Expr_602_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_603_Var
		);
		final EList<? extends EObject> Expr_603_list = InclusiveOrExpression_603_Var
		.getExpr();
		Assert.assertNotNull(Expr_603_list);
		Assert.assertEquals(1, Expr_603_list.size());
		//603
		final ExclusiveOrExpression ExclusiveOrExpression_604_Var
		 = (ExclusiveOrExpression)Expr_603_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_604_Var
		);
		final EList<? extends EObject> Expr_604_list = ExclusiveOrExpression_604_Var
		.getExpr();
		Assert.assertNotNull(Expr_604_list);
		Assert.assertEquals(1, Expr_604_list.size());
		//604
		final AndExpression AndExpression_605_Var
		 = (AndExpression)Expr_604_list.get(0);
		Assert.assertNotNull(AndExpression_605_Var
		);
		final EList<? extends EObject> Expr_605_list = AndExpression_605_Var
		.getExpr();
		Assert.assertNotNull(Expr_605_list);
		Assert.assertEquals(1, Expr_605_list.size());
		//605
		final EqualityExpression EqualityExpression_606_Var
		 = (EqualityExpression)Expr_605_list.get(0);
		Assert.assertNotNull(EqualityExpression_606_Var
		);
		final EList<? extends EObject> Expr_606_list = EqualityExpression_606_Var
		.getExpr();
		Assert.assertNotNull(Expr_606_list);
		Assert.assertEquals(1, Expr_606_list.size());
		//606
		final RelationalExpression RelationalExpression_607_Var
		 = (RelationalExpression)Expr_606_list.get(0);
		Assert.assertNotNull(RelationalExpression_607_Var
		);
		final EList<? extends EObject> Expr_607_list = RelationalExpression_607_Var
		.getExpr();
		Assert.assertNotNull(Expr_607_list);
		Assert.assertEquals(1, Expr_607_list.size());
		//607
		final ShiftExpression ShiftExpression_608_Var
		 = (ShiftExpression)Expr_607_list.get(0);
		Assert.assertNotNull(ShiftExpression_608_Var
		);
		final EList<? extends EObject> Expr_608_list = ShiftExpression_608_Var
		.getExpr();
		Assert.assertNotNull(Expr_608_list);
		Assert.assertEquals(1, Expr_608_list.size());
		//608
		final AdditiveExpression AdditiveExpression_609_Var
		 = (AdditiveExpression)Expr_608_list.get(0);
		Assert.assertNotNull(AdditiveExpression_609_Var
		);
		final EList<? extends EObject> Expr_609_list = AdditiveExpression_609_Var
		.getExpr();
		Assert.assertNotNull(Expr_609_list);
		Assert.assertEquals(1, Expr_609_list.size());
		//609
		final MultiplicativeExpression MultiplicativeExpression_610_Var
		 = (MultiplicativeExpression)Expr_609_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_610_Var
		);
		final EList<? extends EObject> Expr_610_list = MultiplicativeExpression_610_Var
		.getExpr();
		Assert.assertNotNull(Expr_610_list);
		Assert.assertEquals(1, Expr_610_list.size());
		//610
		final CastExpression CastExpression_611_Var
		 = (CastExpression)Expr_610_list.get(0);
		Assert.assertNotNull(CastExpression_611_Var
		);
		//611
		final UnaryExpression UnaryExpression_612_Var
		 = (UnaryExpression)CastExpression_611_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_612_Var
		);
		//612
		final PostfixExpression PostfixExpression_613_Var
		 = (PostfixExpression)UnaryExpression_612_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_613_Var
		);
		final EList<? extends EObject> Expr_613_list = PostfixExpression_613_Var
		.getExpr();
		Assert.assertNotNull(Expr_613_list);
		Assert.assertEquals(1, Expr_613_list.size());
		//613
		final PrimaryExpression PrimaryExpression_614_Var
		 = (PrimaryExpression)Expr_613_list.get(0);
		Assert.assertNotNull(PrimaryExpression_614_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_614_Var
		.getId());
		final EList<? extends EObject> Suffix_614_list = PostfixExpression_613_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_614_list);
		Assert.assertEquals(1, Suffix_614_list.size());
		//614
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_615_Var
		 = (PostfixExpressionSuffixDot)Suffix_614_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_615_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_615_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_563_Var
		.getSemi());
		//615
		final Statement Statement_616_Var
		 = (Statement)Statement_104_list.get(9);
		Assert.assertNotNull(Statement_616_Var
		);
		//616
		final JumpStatement JumpStatement_617_Var
		 = (JumpStatement)Statement_616_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_617_Var
		);
		//617
		final Expression Expression_618_Var
		 = (Expression)JumpStatement_617_Var
		.getExpr();
		Assert.assertNotNull(Expression_618_Var
		);
		final EList<? extends EObject> ExprExpr_618_list = Expression_618_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_618_list);
		Assert.assertEquals(1, ExprExpr_618_list.size());
		//618
		final AssignmentExpression AssignmentExpression_619_Var
		 = (AssignmentExpression)ExprExpr_618_list.get(0);
		Assert.assertNotNull(AssignmentExpression_619_Var
		);
		//619
		final ConditionalExpression ConditionalExpression_620_Var
		 = (ConditionalExpression)AssignmentExpression_619_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_620_Var
		);
		//620
		final LogicalOrExpression LogicalOrExpression_621_Var
		 = (LogicalOrExpression)ConditionalExpression_620_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_621_Var
		);
		final EList<? extends EObject> Expr_621_list = LogicalOrExpression_621_Var
		.getExpr();
		Assert.assertNotNull(Expr_621_list);
		Assert.assertEquals(1, Expr_621_list.size());
		//621
		final LogicalAndExpression LogicalAndExpression_622_Var
		 = (LogicalAndExpression)Expr_621_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_622_Var
		);
		final EList<? extends EObject> Expr_622_list = LogicalAndExpression_622_Var
		.getExpr();
		Assert.assertNotNull(Expr_622_list);
		Assert.assertEquals(1, Expr_622_list.size());
		//622
		final InclusiveOrExpression InclusiveOrExpression_623_Var
		 = (InclusiveOrExpression)Expr_622_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_623_Var
		);
		final EList<? extends EObject> Expr_623_list = InclusiveOrExpression_623_Var
		.getExpr();
		Assert.assertNotNull(Expr_623_list);
		Assert.assertEquals(1, Expr_623_list.size());
		//623
		final ExclusiveOrExpression ExclusiveOrExpression_624_Var
		 = (ExclusiveOrExpression)Expr_623_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_624_Var
		);
		final EList<? extends EObject> Expr_624_list = ExclusiveOrExpression_624_Var
		.getExpr();
		Assert.assertNotNull(Expr_624_list);
		Assert.assertEquals(1, Expr_624_list.size());
		//624
		final AndExpression AndExpression_625_Var
		 = (AndExpression)Expr_624_list.get(0);
		Assert.assertNotNull(AndExpression_625_Var
		);
		final EList<? extends EObject> Expr_625_list = AndExpression_625_Var
		.getExpr();
		Assert.assertNotNull(Expr_625_list);
		Assert.assertEquals(1, Expr_625_list.size());
		//625
		final EqualityExpression EqualityExpression_626_Var
		 = (EqualityExpression)Expr_625_list.get(0);
		Assert.assertNotNull(EqualityExpression_626_Var
		);
		final EList<? extends EObject> Expr_626_list = EqualityExpression_626_Var
		.getExpr();
		Assert.assertNotNull(Expr_626_list);
		Assert.assertEquals(1, Expr_626_list.size());
		//626
		final RelationalExpression RelationalExpression_627_Var
		 = (RelationalExpression)Expr_626_list.get(0);
		Assert.assertNotNull(RelationalExpression_627_Var
		);
		final EList<? extends EObject> Expr_627_list = RelationalExpression_627_Var
		.getExpr();
		Assert.assertNotNull(Expr_627_list);
		Assert.assertEquals(1, Expr_627_list.size());
		//627
		final ShiftExpression ShiftExpression_628_Var
		 = (ShiftExpression)Expr_627_list.get(0);
		Assert.assertNotNull(ShiftExpression_628_Var
		);
		final EList<? extends EObject> Expr_628_list = ShiftExpression_628_Var
		.getExpr();
		Assert.assertNotNull(Expr_628_list);
		Assert.assertEquals(1, Expr_628_list.size());
		//628
		final AdditiveExpression AdditiveExpression_629_Var
		 = (AdditiveExpression)Expr_628_list.get(0);
		Assert.assertNotNull(AdditiveExpression_629_Var
		);
		final EList<? extends EObject> Expr_629_list = AdditiveExpression_629_Var
		.getExpr();
		Assert.assertNotNull(Expr_629_list);
		Assert.assertEquals(1, Expr_629_list.size());
		//629
		final MultiplicativeExpression MultiplicativeExpression_630_Var
		 = (MultiplicativeExpression)Expr_629_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_630_Var
		);
		final EList<? extends EObject> Expr_630_list = MultiplicativeExpression_630_Var
		.getExpr();
		Assert.assertNotNull(Expr_630_list);
		Assert.assertEquals(1, Expr_630_list.size());
		//630
		final CastExpression CastExpression_631_Var
		 = (CastExpression)Expr_630_list.get(0);
		Assert.assertNotNull(CastExpression_631_Var
		);
		//631
		final UnaryExpression UnaryExpression_632_Var
		 = (UnaryExpression)CastExpression_631_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_632_Var
		);
		//632
		final PostfixExpression PostfixExpression_633_Var
		 = (PostfixExpression)UnaryExpression_632_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_633_Var
		);
		final EList<? extends EObject> Expr_633_list = PostfixExpression_633_Var
		.getExpr();
		Assert.assertNotNull(Expr_633_list);
		Assert.assertEquals(1, Expr_633_list.size());
		//633
		final PrimaryExpression PrimaryExpression_634_Var
		 = (PrimaryExpression)Expr_633_list.get(0);
		Assert.assertNotNull(PrimaryExpression_634_Var
		);
		//634
		final Constant2 Constant2_635_Var
		 = (Constant2)PrimaryExpression_634_Var
		.getConst();
		Assert.assertNotNull(Constant2_635_Var
		);
		Assert.assertEquals("0", Constant2_635_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_617_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_617_Var
		.getSemi());
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


