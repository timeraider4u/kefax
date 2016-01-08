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
import at.jku.weiner.c.parser.parser.TypeSpecifier;
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
		Assert.assertEquals("id", DirectDeclarator_14_Var
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
		.getId());
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
		final AssignmentExpression AssignmentExpression_23_Var
		 = (AssignmentExpression)DeclaratorSuffix_22_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_23_Var
		);
		//23
		final ConditionalExpression ConditionalExpression_24_Var
		 = (ConditionalExpression)AssignmentExpression_23_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_24_Var
		);
		//24
		final LogicalOrExpression LogicalOrExpression_25_Var
		 = (LogicalOrExpression)ConditionalExpression_24_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = LogicalOrExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final LogicalAndExpression LogicalAndExpression_26_Var
		 = (LogicalAndExpression)Expr_25_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = LogicalAndExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final InclusiveOrExpression InclusiveOrExpression_27_Var
		 = (InclusiveOrExpression)Expr_26_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = InclusiveOrExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final ExclusiveOrExpression ExclusiveOrExpression_28_Var
		 = (ExclusiveOrExpression)Expr_27_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = ExclusiveOrExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final AndExpression AndExpression_29_Var
		 = (AndExpression)Expr_28_list.get(0);
		Assert.assertNotNull(AndExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = AndExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final EqualityExpression EqualityExpression_30_Var
		 = (EqualityExpression)Expr_29_list.get(0);
		Assert.assertNotNull(EqualityExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = EqualityExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final RelationalExpression RelationalExpression_31_Var
		 = (RelationalExpression)Expr_30_list.get(0);
		Assert.assertNotNull(RelationalExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = RelationalExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final ShiftExpression ShiftExpression_32_Var
		 = (ShiftExpression)Expr_31_list.get(0);
		Assert.assertNotNull(ShiftExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = ShiftExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final AdditiveExpression AdditiveExpression_33_Var
		 = (AdditiveExpression)Expr_32_list.get(0);
		Assert.assertNotNull(AdditiveExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = AdditiveExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final MultiplicativeExpression MultiplicativeExpression_34_Var
		 = (MultiplicativeExpression)Expr_33_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = MultiplicativeExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final CastExpression CastExpression_35_Var
		 = (CastExpression)Expr_34_list.get(0);
		Assert.assertNotNull(CastExpression_35_Var
		);
		//35
		final UnaryExpression UnaryExpression_36_Var
		 = (UnaryExpression)CastExpression_35_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_36_Var
		);
		//36
		final PostfixExpression PostfixExpression_37_Var
		 = (PostfixExpression)UnaryExpression_36_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = PostfixExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final PrimaryExpression PrimaryExpression_38_Var
		 = (PrimaryExpression)Expr_37_list.get(0);
		Assert.assertNotNull(PrimaryExpression_38_Var
		);
		//38
		final Constant2 Constant2_39_Var
		 = (Constant2)PrimaryExpression_38_Var
		.getConst();
		Assert.assertNotNull(Constant2_39_Var
		);
		Assert.assertEquals("250", Constant2_39_Var
		.getDec());
		final EList<? extends EObject> InitDeclaratorList_39_list = Declaration_2_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_39_list);
		Assert.assertEquals(1, InitDeclaratorList_39_list.size());
		//39
		final InitDeclaratorList InitDeclaratorList_40_Var
		 = (InitDeclaratorList)InitDeclaratorList_39_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_40_Var
		);
		final EList<? extends EObject> InitDeclarator_40_list = InitDeclaratorList_40_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_40_list);
		Assert.assertEquals(1, InitDeclarator_40_list.size());
		//40
		final InitDeclarator InitDeclarator_41_Var
		 = (InitDeclarator)InitDeclarator_40_list.get(0);
		Assert.assertNotNull(InitDeclarator_41_Var
		);
		//41
		final Declarator Declarator_42_Var
		 = (Declarator)InitDeclarator_41_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_42_Var
		);
		//42
		final DirectDeclarator DirectDeclarator_43_Var
		 = (DirectDeclarator)Declarator_42_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_43_Var
		);
		Assert.assertEquals("phil", DirectDeclarator_43_Var
		.getId());
		//43
		final ExternalDeclaration ExternalDeclaration_44_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_44_Var
		);
		//44
		final Declaration Declaration_45_Var
		 = (Declaration)ExternalDeclaration_44_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_45_Var
		);
		//45
		final DeclarationSpecifiers DeclarationSpecifiers_46_Var
		 = (DeclarationSpecifiers)Declaration_45_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_46_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_46_list = DeclarationSpecifiers_46_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_46_list);
		Assert.assertEquals(1, DeclarationSpecifier_46_list.size());
		//46
		final TypeSpecifier TypeSpecifier_47_Var
		 = (TypeSpecifier)DeclarationSpecifier_46_list.get(0);
		Assert.assertNotNull(TypeSpecifier_47_Var
		);
		//47
		final StructOrUnionSpecifier StructOrUnionSpecifier_48_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_47_Var
		.getSpecifier();
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
		final EList<? extends EObject> InitDeclaratorList_49_list = Declaration_45_Var
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
		Assert.assertEquals("[\"Joe Nobody\"]", PrimaryExpression_90_Var
		.getString().toString());
		//90
		final ExternalDeclaration ExternalDeclaration_91_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_91_Var
		);
		//91
		final FunctionDefHead FunctionDefHead_92_Var
		 = (FunctionDefHead)ExternalDeclaration_91_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_92_Var
		);
		//92
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_93_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_92_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_93_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_93_list = FunctionDeclarationSpecifiers_93_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_93_list);
		Assert.assertEquals(1, DeclarationSpecifier_93_list.size());
		//93
		final TypeSpecifier TypeSpecifier_94_Var
		 = (TypeSpecifier)DeclarationSpecifier_93_list.get(0);
		Assert.assertNotNull(TypeSpecifier_94_Var
		);
		Assert.assertEquals("int", TypeSpecifier_94_Var
		.getName());
		//94
		final Declarator Declarator_95_Var
		 = (Declarator)FunctionDefHead_92_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_95_Var
		);
		//95
		final DirectDeclarator DirectDeclarator_96_Var
		 = (DirectDeclarator)Declarator_95_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_96_Var
		);
		Assert.assertEquals("main", DirectDeclarator_96_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_96_list = DirectDeclarator_96_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_96_list);
		Assert.assertEquals(1, DeclaratorSuffix_96_list.size());
		//96
		final DeclaratorSuffix DeclaratorSuffix_97_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_96_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_97_Var
		);
		//97
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_98_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_97_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_98_Var
		);
		final EList<? extends EObject> ParameterTypeList_98_list = DirectDeclaratorLastSuffix_98_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_98_list);
		Assert.assertEquals(1, ParameterTypeList_98_list.size());
		//98
		final ParameterTypeList ParameterTypeList_99_Var
		 = (ParameterTypeList)ParameterTypeList_98_list.get(0);
		Assert.assertNotNull(ParameterTypeList_99_Var
		);
		//99
		final ParameterList ParameterList_100_Var
		 = (ParameterList)ParameterTypeList_99_Var
		.getList();
		Assert.assertNotNull(ParameterList_100_Var
		);
		final EList<? extends EObject> ParameterDeclaration_100_list = ParameterList_100_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_100_list);
		Assert.assertEquals(1, ParameterDeclaration_100_list.size());
		//100
		final ParameterDeclaration ParameterDeclaration_101_Var
		 = (ParameterDeclaration)ParameterDeclaration_100_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_101_Var
		);
		//101
		final DeclarationSpecifiers DeclarationSpecifiers_102_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_101_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_102_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_102_list = DeclarationSpecifiers_102_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_102_list);
		Assert.assertEquals(1, DeclarationSpecifier_102_list.size());
		//102
		final TypeSpecifier TypeSpecifier_103_Var
		 = (TypeSpecifier)DeclarationSpecifier_102_list.get(0);
		Assert.assertNotNull(TypeSpecifier_103_Var
		);
		Assert.assertEquals("void", TypeSpecifier_103_Var
		.getName());
		//103
		final FunctionDefinition FunctionDefinition_104_Var
		 = (FunctionDefinition)ExternalDeclaration_91_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_104_Var
		);
		//104
		final BodyStatement BodyStatement_105_Var
		 = (BodyStatement)FunctionDefinition_104_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_105_Var
		);
		final EList<? extends EObject> BlockList_105_list = BodyStatement_105_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_105_list);
		Assert.assertEquals(1, BlockList_105_list.size());
		//105
		final BlockList BlockList_106_Var
		 = (BlockList)BlockList_105_list.get(0);
		Assert.assertNotNull(BlockList_106_Var
		);
		final EList<? extends EObject> Statement_106_list = BlockList_106_Var
		.getStatement();
		Assert.assertNotNull(Statement_106_list);
		Assert.assertEquals(10, Statement_106_list.size());
		//106
		final Statement Statement_107_Var
		 = (Statement)Statement_106_list.get(0);
		Assert.assertNotNull(Statement_107_Var
		);
		//107
		final ExpressionStatement ExpressionStatement_108_Var
		 = (ExpressionStatement)Statement_107_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_108_Var
		);
		//108
		final Expression Expression_109_Var
		 = (Expression)ExpressionStatement_108_Var
		.getExpression();
		Assert.assertNotNull(Expression_109_Var
		);
		final EList<? extends EObject> ExprExpr_109_list = Expression_109_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_109_list);
		Assert.assertEquals(1, ExprExpr_109_list.size());
		//109
		final AssignmentExpression AssignmentExpression_110_Var
		 = (AssignmentExpression)ExprExpr_109_list.get(0);
		Assert.assertNotNull(AssignmentExpression_110_Var
		);
		//110
		final ConditionalExpression ConditionalExpression_111_Var
		 = (ConditionalExpression)AssignmentExpression_110_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_111_Var
		);
		//111
		final LogicalOrExpression LogicalOrExpression_112_Var
		 = (LogicalOrExpression)ConditionalExpression_111_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = LogicalOrExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final LogicalAndExpression LogicalAndExpression_113_Var
		 = (LogicalAndExpression)Expr_112_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = LogicalAndExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final InclusiveOrExpression InclusiveOrExpression_114_Var
		 = (InclusiveOrExpression)Expr_113_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = InclusiveOrExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final ExclusiveOrExpression ExclusiveOrExpression_115_Var
		 = (ExclusiveOrExpression)Expr_114_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = ExclusiveOrExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final AndExpression AndExpression_116_Var
		 = (AndExpression)Expr_115_list.get(0);
		Assert.assertNotNull(AndExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = AndExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final EqualityExpression EqualityExpression_117_Var
		 = (EqualityExpression)Expr_116_list.get(0);
		Assert.assertNotNull(EqualityExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = EqualityExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final RelationalExpression RelationalExpression_118_Var
		 = (RelationalExpression)Expr_117_list.get(0);
		Assert.assertNotNull(RelationalExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = RelationalExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final ShiftExpression ShiftExpression_119_Var
		 = (ShiftExpression)Expr_118_list.get(0);
		Assert.assertNotNull(ShiftExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = ShiftExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final AdditiveExpression AdditiveExpression_120_Var
		 = (AdditiveExpression)Expr_119_list.get(0);
		Assert.assertNotNull(AdditiveExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = AdditiveExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final MultiplicativeExpression MultiplicativeExpression_121_Var
		 = (MultiplicativeExpression)Expr_120_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = MultiplicativeExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final CastExpression CastExpression_122_Var
		 = (CastExpression)Expr_121_list.get(0);
		Assert.assertNotNull(CastExpression_122_Var
		);
		//122
		final UnaryExpression UnaryExpression_123_Var
		 = (UnaryExpression)CastExpression_122_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_123_Var
		);
		//123
		final PostfixExpression PostfixExpression_124_Var
		 = (PostfixExpression)UnaryExpression_123_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = PostfixExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final PrimaryExpression PrimaryExpression_125_Var
		 = (PrimaryExpression)Expr_124_list.get(0);
		Assert.assertNotNull(PrimaryExpression_125_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_125_Var
		.getId());
		final EList<? extends EObject> Suffix_125_list = PostfixExpression_124_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_125_list);
		Assert.assertEquals(1, Suffix_125_list.size());
		//125
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_126_Var
		 = (PostfixExpressionSuffixArgument)Suffix_125_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_126_Var
		);
		//126
		final ArgumentExpressionList ArgumentExpressionList_127_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_126_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_127_Var
		);
		final EList<? extends EObject> Expr_127_list = ArgumentExpressionList_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(2, Expr_127_list.size());
		//127
		final AssignmentExpression AssignmentExpression_128_Var
		 = (AssignmentExpression)Expr_127_list.get(0);
		Assert.assertNotNull(AssignmentExpression_128_Var
		);
		//128
		final ConditionalExpression ConditionalExpression_129_Var
		 = (ConditionalExpression)AssignmentExpression_128_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_129_Var
		);
		//129
		final LogicalOrExpression LogicalOrExpression_130_Var
		 = (LogicalOrExpression)ConditionalExpression_129_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = LogicalOrExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final LogicalAndExpression LogicalAndExpression_131_Var
		 = (LogicalAndExpression)Expr_130_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = LogicalAndExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final InclusiveOrExpression InclusiveOrExpression_132_Var
		 = (InclusiveOrExpression)Expr_131_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = InclusiveOrExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final ExclusiveOrExpression ExclusiveOrExpression_133_Var
		 = (ExclusiveOrExpression)Expr_132_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = ExclusiveOrExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final AndExpression AndExpression_134_Var
		 = (AndExpression)Expr_133_list.get(0);
		Assert.assertNotNull(AndExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = AndExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final EqualityExpression EqualityExpression_135_Var
		 = (EqualityExpression)Expr_134_list.get(0);
		Assert.assertNotNull(EqualityExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = EqualityExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final RelationalExpression RelationalExpression_136_Var
		 = (RelationalExpression)Expr_135_list.get(0);
		Assert.assertNotNull(RelationalExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = RelationalExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final ShiftExpression ShiftExpression_137_Var
		 = (ShiftExpression)Expr_136_list.get(0);
		Assert.assertNotNull(ShiftExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = ShiftExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final AdditiveExpression AdditiveExpression_138_Var
		 = (AdditiveExpression)Expr_137_list.get(0);
		Assert.assertNotNull(AdditiveExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = AdditiveExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final MultiplicativeExpression MultiplicativeExpression_139_Var
		 = (MultiplicativeExpression)Expr_138_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = MultiplicativeExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final CastExpression CastExpression_140_Var
		 = (CastExpression)Expr_139_list.get(0);
		Assert.assertNotNull(CastExpression_140_Var
		);
		//140
		final UnaryExpression UnaryExpression_141_Var
		 = (UnaryExpression)CastExpression_140_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_141_Var
		);
		//141
		final PostfixExpression PostfixExpression_142_Var
		 = (PostfixExpression)UnaryExpression_141_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = PostfixExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final PrimaryExpression PrimaryExpression_143_Var
		 = (PrimaryExpression)Expr_142_list.get(0);
		Assert.assertNotNull(PrimaryExpression_143_Var
		);
		Assert.assertEquals("[\"sizeof(joe.id)=%lu\\n\"]", PrimaryExpression_143_Var
		.getString().toString());
		//143
		final AssignmentExpression AssignmentExpression_144_Var
		 = (AssignmentExpression)Expr_127_list.get(1);
		Assert.assertNotNull(AssignmentExpression_144_Var
		);
		//144
		final ConditionalExpression ConditionalExpression_145_Var
		 = (ConditionalExpression)AssignmentExpression_144_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_145_Var
		);
		//145
		final LogicalOrExpression LogicalOrExpression_146_Var
		 = (LogicalOrExpression)ConditionalExpression_145_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_146_Var
		);
		final EList<? extends EObject> Expr_146_list = LogicalOrExpression_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final LogicalAndExpression LogicalAndExpression_147_Var
		 = (LogicalAndExpression)Expr_146_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_147_Var
		);
		final EList<? extends EObject> Expr_147_list = LogicalAndExpression_147_Var
		.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(1, Expr_147_list.size());
		//147
		final InclusiveOrExpression InclusiveOrExpression_148_Var
		 = (InclusiveOrExpression)Expr_147_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_148_Var
		);
		final EList<? extends EObject> Expr_148_list = InclusiveOrExpression_148_Var
		.getExpr();
		Assert.assertNotNull(Expr_148_list);
		Assert.assertEquals(1, Expr_148_list.size());
		//148
		final ExclusiveOrExpression ExclusiveOrExpression_149_Var
		 = (ExclusiveOrExpression)Expr_148_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_149_Var
		);
		final EList<? extends EObject> Expr_149_list = ExclusiveOrExpression_149_Var
		.getExpr();
		Assert.assertNotNull(Expr_149_list);
		Assert.assertEquals(1, Expr_149_list.size());
		//149
		final AndExpression AndExpression_150_Var
		 = (AndExpression)Expr_149_list.get(0);
		Assert.assertNotNull(AndExpression_150_Var
		);
		final EList<? extends EObject> Expr_150_list = AndExpression_150_Var
		.getExpr();
		Assert.assertNotNull(Expr_150_list);
		Assert.assertEquals(1, Expr_150_list.size());
		//150
		final EqualityExpression EqualityExpression_151_Var
		 = (EqualityExpression)Expr_150_list.get(0);
		Assert.assertNotNull(EqualityExpression_151_Var
		);
		final EList<? extends EObject> Expr_151_list = EqualityExpression_151_Var
		.getExpr();
		Assert.assertNotNull(Expr_151_list);
		Assert.assertEquals(1, Expr_151_list.size());
		//151
		final RelationalExpression RelationalExpression_152_Var
		 = (RelationalExpression)Expr_151_list.get(0);
		Assert.assertNotNull(RelationalExpression_152_Var
		);
		final EList<? extends EObject> Expr_152_list = RelationalExpression_152_Var
		.getExpr();
		Assert.assertNotNull(Expr_152_list);
		Assert.assertEquals(1, Expr_152_list.size());
		//152
		final ShiftExpression ShiftExpression_153_Var
		 = (ShiftExpression)Expr_152_list.get(0);
		Assert.assertNotNull(ShiftExpression_153_Var
		);
		final EList<? extends EObject> Expr_153_list = ShiftExpression_153_Var
		.getExpr();
		Assert.assertNotNull(Expr_153_list);
		Assert.assertEquals(1, Expr_153_list.size());
		//153
		final AdditiveExpression AdditiveExpression_154_Var
		 = (AdditiveExpression)Expr_153_list.get(0);
		Assert.assertNotNull(AdditiveExpression_154_Var
		);
		final EList<? extends EObject> Expr_154_list = AdditiveExpression_154_Var
		.getExpr();
		Assert.assertNotNull(Expr_154_list);
		Assert.assertEquals(1, Expr_154_list.size());
		//154
		final MultiplicativeExpression MultiplicativeExpression_155_Var
		 = (MultiplicativeExpression)Expr_154_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_155_Var
		);
		final EList<? extends EObject> Expr_155_list = MultiplicativeExpression_155_Var
		.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		//155
		final CastExpression CastExpression_156_Var
		 = (CastExpression)Expr_155_list.get(0);
		Assert.assertNotNull(CastExpression_156_Var
		);
		//156
		final UnaryExpression UnaryExpression_157_Var
		 = (UnaryExpression)CastExpression_156_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_157_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_157_Var
		.getSizeOf());
		//157
		final UnaryExpression UnaryExpression_158_Var
		 = (UnaryExpression)UnaryExpression_157_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_158_Var
		);
		//158
		final PostfixExpression PostfixExpression_159_Var
		 = (PostfixExpression)UnaryExpression_158_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = PostfixExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final PrimaryExpression PrimaryExpression_160_Var
		 = (PrimaryExpression)Expr_159_list.get(0);
		Assert.assertNotNull(PrimaryExpression_160_Var
		);
		//160
		final Expression Expression_161_Var
		 = (Expression)PrimaryExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expression_161_Var
		);
		final EList<? extends EObject> ExprExpr_161_list = Expression_161_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_161_list);
		Assert.assertEquals(1, ExprExpr_161_list.size());
		//161
		final AssignmentExpression AssignmentExpression_162_Var
		 = (AssignmentExpression)ExprExpr_161_list.get(0);
		Assert.assertNotNull(AssignmentExpression_162_Var
		);
		//162
		final ConditionalExpression ConditionalExpression_163_Var
		 = (ConditionalExpression)AssignmentExpression_162_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_163_Var
		);
		//163
		final LogicalOrExpression LogicalOrExpression_164_Var
		 = (LogicalOrExpression)ConditionalExpression_163_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_164_Var
		);
		final EList<? extends EObject> Expr_164_list = LogicalOrExpression_164_Var
		.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		//164
		final LogicalAndExpression LogicalAndExpression_165_Var
		 = (LogicalAndExpression)Expr_164_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_165_Var
		);
		final EList<? extends EObject> Expr_165_list = LogicalAndExpression_165_Var
		.getExpr();
		Assert.assertNotNull(Expr_165_list);
		Assert.assertEquals(1, Expr_165_list.size());
		//165
		final InclusiveOrExpression InclusiveOrExpression_166_Var
		 = (InclusiveOrExpression)Expr_165_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_166_Var
		);
		final EList<? extends EObject> Expr_166_list = InclusiveOrExpression_166_Var
		.getExpr();
		Assert.assertNotNull(Expr_166_list);
		Assert.assertEquals(1, Expr_166_list.size());
		//166
		final ExclusiveOrExpression ExclusiveOrExpression_167_Var
		 = (ExclusiveOrExpression)Expr_166_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_167_Var
		);
		final EList<? extends EObject> Expr_167_list = ExclusiveOrExpression_167_Var
		.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(1, Expr_167_list.size());
		//167
		final AndExpression AndExpression_168_Var
		 = (AndExpression)Expr_167_list.get(0);
		Assert.assertNotNull(AndExpression_168_Var
		);
		final EList<? extends EObject> Expr_168_list = AndExpression_168_Var
		.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(1, Expr_168_list.size());
		//168
		final EqualityExpression EqualityExpression_169_Var
		 = (EqualityExpression)Expr_168_list.get(0);
		Assert.assertNotNull(EqualityExpression_169_Var
		);
		final EList<? extends EObject> Expr_169_list = EqualityExpression_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		//169
		final RelationalExpression RelationalExpression_170_Var
		 = (RelationalExpression)Expr_169_list.get(0);
		Assert.assertNotNull(RelationalExpression_170_Var
		);
		final EList<? extends EObject> Expr_170_list = RelationalExpression_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		//170
		final ShiftExpression ShiftExpression_171_Var
		 = (ShiftExpression)Expr_170_list.get(0);
		Assert.assertNotNull(ShiftExpression_171_Var
		);
		final EList<? extends EObject> Expr_171_list = ShiftExpression_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		//171
		final AdditiveExpression AdditiveExpression_172_Var
		 = (AdditiveExpression)Expr_171_list.get(0);
		Assert.assertNotNull(AdditiveExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = AdditiveExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final MultiplicativeExpression MultiplicativeExpression_173_Var
		 = (MultiplicativeExpression)Expr_172_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = MultiplicativeExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final CastExpression CastExpression_174_Var
		 = (CastExpression)Expr_173_list.get(0);
		Assert.assertNotNull(CastExpression_174_Var
		);
		//174
		final UnaryExpression UnaryExpression_175_Var
		 = (UnaryExpression)CastExpression_174_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_175_Var
		);
		//175
		final PostfixExpression PostfixExpression_176_Var
		 = (PostfixExpression)UnaryExpression_175_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = PostfixExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final PrimaryExpression PrimaryExpression_177_Var
		 = (PrimaryExpression)Expr_176_list.get(0);
		Assert.assertNotNull(PrimaryExpression_177_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_177_Var
		.getId());
		final EList<? extends EObject> Suffix_177_list = PostfixExpression_176_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_177_list);
		Assert.assertEquals(1, Suffix_177_list.size());
		//177
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_178_Var
		 = (PostfixExpressionSuffixDot)Suffix_177_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_178_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_178_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_108_Var
		.getSemi());
		//178
		final Statement Statement_179_Var
		 = (Statement)Statement_106_list.get(1);
		Assert.assertNotNull(Statement_179_Var
		);
		//179
		final ExpressionStatement ExpressionStatement_180_Var
		 = (ExpressionStatement)Statement_179_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_180_Var
		);
		//180
		final Expression Expression_181_Var
		 = (Expression)ExpressionStatement_180_Var
		.getExpression();
		Assert.assertNotNull(Expression_181_Var
		);
		final EList<? extends EObject> ExprExpr_181_list = Expression_181_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_181_list);
		Assert.assertEquals(1, ExprExpr_181_list.size());
		//181
		final AssignmentExpression AssignmentExpression_182_Var
		 = (AssignmentExpression)ExprExpr_181_list.get(0);
		Assert.assertNotNull(AssignmentExpression_182_Var
		);
		//182
		final ConditionalExpression ConditionalExpression_183_Var
		 = (ConditionalExpression)AssignmentExpression_182_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_183_Var
		);
		//183
		final LogicalOrExpression LogicalOrExpression_184_Var
		 = (LogicalOrExpression)ConditionalExpression_183_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = LogicalOrExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final LogicalAndExpression LogicalAndExpression_185_Var
		 = (LogicalAndExpression)Expr_184_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_185_Var
		);
		final EList<? extends EObject> Expr_185_list = LogicalAndExpression_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final InclusiveOrExpression InclusiveOrExpression_186_Var
		 = (InclusiveOrExpression)Expr_185_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_186_Var
		);
		final EList<? extends EObject> Expr_186_list = InclusiveOrExpression_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(1, Expr_186_list.size());
		//186
		final ExclusiveOrExpression ExclusiveOrExpression_187_Var
		 = (ExclusiveOrExpression)Expr_186_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_187_Var
		);
		final EList<? extends EObject> Expr_187_list = ExclusiveOrExpression_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(1, Expr_187_list.size());
		//187
		final AndExpression AndExpression_188_Var
		 = (AndExpression)Expr_187_list.get(0);
		Assert.assertNotNull(AndExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = AndExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final EqualityExpression EqualityExpression_189_Var
		 = (EqualityExpression)Expr_188_list.get(0);
		Assert.assertNotNull(EqualityExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = EqualityExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final RelationalExpression RelationalExpression_190_Var
		 = (RelationalExpression)Expr_189_list.get(0);
		Assert.assertNotNull(RelationalExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = RelationalExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final ShiftExpression ShiftExpression_191_Var
		 = (ShiftExpression)Expr_190_list.get(0);
		Assert.assertNotNull(ShiftExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = ShiftExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final AdditiveExpression AdditiveExpression_192_Var
		 = (AdditiveExpression)Expr_191_list.get(0);
		Assert.assertNotNull(AdditiveExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = AdditiveExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final MultiplicativeExpression MultiplicativeExpression_193_Var
		 = (MultiplicativeExpression)Expr_192_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = MultiplicativeExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final CastExpression CastExpression_194_Var
		 = (CastExpression)Expr_193_list.get(0);
		Assert.assertNotNull(CastExpression_194_Var
		);
		//194
		final UnaryExpression UnaryExpression_195_Var
		 = (UnaryExpression)CastExpression_194_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_195_Var
		);
		//195
		final PostfixExpression PostfixExpression_196_Var
		 = (PostfixExpression)UnaryExpression_195_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = PostfixExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final PrimaryExpression PrimaryExpression_197_Var
		 = (PrimaryExpression)Expr_196_list.get(0);
		Assert.assertNotNull(PrimaryExpression_197_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_197_Var
		.getId());
		final EList<? extends EObject> Suffix_197_list = PostfixExpression_196_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_197_list);
		Assert.assertEquals(1, Suffix_197_list.size());
		//197
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_198_Var
		 = (PostfixExpressionSuffixArgument)Suffix_197_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_198_Var
		);
		//198
		final ArgumentExpressionList ArgumentExpressionList_199_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_198_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_199_Var
		);
		final EList<? extends EObject> Expr_199_list = ArgumentExpressionList_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(2, Expr_199_list.size());
		//199
		final AssignmentExpression AssignmentExpression_200_Var
		 = (AssignmentExpression)Expr_199_list.get(0);
		Assert.assertNotNull(AssignmentExpression_200_Var
		);
		//200
		final ConditionalExpression ConditionalExpression_201_Var
		 = (ConditionalExpression)AssignmentExpression_200_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_201_Var
		);
		//201
		final LogicalOrExpression LogicalOrExpression_202_Var
		 = (LogicalOrExpression)ConditionalExpression_201_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = LogicalOrExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final LogicalAndExpression LogicalAndExpression_203_Var
		 = (LogicalAndExpression)Expr_202_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = LogicalAndExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final InclusiveOrExpression InclusiveOrExpression_204_Var
		 = (InclusiveOrExpression)Expr_203_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = InclusiveOrExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final ExclusiveOrExpression ExclusiveOrExpression_205_Var
		 = (ExclusiveOrExpression)Expr_204_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = ExclusiveOrExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final AndExpression AndExpression_206_Var
		 = (AndExpression)Expr_205_list.get(0);
		Assert.assertNotNull(AndExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = AndExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final EqualityExpression EqualityExpression_207_Var
		 = (EqualityExpression)Expr_206_list.get(0);
		Assert.assertNotNull(EqualityExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = EqualityExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final RelationalExpression RelationalExpression_208_Var
		 = (RelationalExpression)Expr_207_list.get(0);
		Assert.assertNotNull(RelationalExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = RelationalExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final ShiftExpression ShiftExpression_209_Var
		 = (ShiftExpression)Expr_208_list.get(0);
		Assert.assertNotNull(ShiftExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = ShiftExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final AdditiveExpression AdditiveExpression_210_Var
		 = (AdditiveExpression)Expr_209_list.get(0);
		Assert.assertNotNull(AdditiveExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = AdditiveExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final MultiplicativeExpression MultiplicativeExpression_211_Var
		 = (MultiplicativeExpression)Expr_210_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = MultiplicativeExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final CastExpression CastExpression_212_Var
		 = (CastExpression)Expr_211_list.get(0);
		Assert.assertNotNull(CastExpression_212_Var
		);
		//212
		final UnaryExpression UnaryExpression_213_Var
		 = (UnaryExpression)CastExpression_212_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_213_Var
		);
		//213
		final PostfixExpression PostfixExpression_214_Var
		 = (PostfixExpression)UnaryExpression_213_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = PostfixExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final PrimaryExpression PrimaryExpression_215_Var
		 = (PrimaryExpression)Expr_214_list.get(0);
		Assert.assertNotNull(PrimaryExpression_215_Var
		);
		Assert.assertEquals("[\"sizeof(joe.name)=%lu\\n\"]", PrimaryExpression_215_Var
		.getString().toString());
		//215
		final AssignmentExpression AssignmentExpression_216_Var
		 = (AssignmentExpression)Expr_199_list.get(1);
		Assert.assertNotNull(AssignmentExpression_216_Var
		);
		//216
		final ConditionalExpression ConditionalExpression_217_Var
		 = (ConditionalExpression)AssignmentExpression_216_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_217_Var
		);
		//217
		final LogicalOrExpression LogicalOrExpression_218_Var
		 = (LogicalOrExpression)ConditionalExpression_217_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = LogicalOrExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final LogicalAndExpression LogicalAndExpression_219_Var
		 = (LogicalAndExpression)Expr_218_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = LogicalAndExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final InclusiveOrExpression InclusiveOrExpression_220_Var
		 = (InclusiveOrExpression)Expr_219_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = InclusiveOrExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final ExclusiveOrExpression ExclusiveOrExpression_221_Var
		 = (ExclusiveOrExpression)Expr_220_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = ExclusiveOrExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final AndExpression AndExpression_222_Var
		 = (AndExpression)Expr_221_list.get(0);
		Assert.assertNotNull(AndExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = AndExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final EqualityExpression EqualityExpression_223_Var
		 = (EqualityExpression)Expr_222_list.get(0);
		Assert.assertNotNull(EqualityExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = EqualityExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final RelationalExpression RelationalExpression_224_Var
		 = (RelationalExpression)Expr_223_list.get(0);
		Assert.assertNotNull(RelationalExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = RelationalExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final ShiftExpression ShiftExpression_225_Var
		 = (ShiftExpression)Expr_224_list.get(0);
		Assert.assertNotNull(ShiftExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = ShiftExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final AdditiveExpression AdditiveExpression_226_Var
		 = (AdditiveExpression)Expr_225_list.get(0);
		Assert.assertNotNull(AdditiveExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = AdditiveExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final MultiplicativeExpression MultiplicativeExpression_227_Var
		 = (MultiplicativeExpression)Expr_226_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = MultiplicativeExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final CastExpression CastExpression_228_Var
		 = (CastExpression)Expr_227_list.get(0);
		Assert.assertNotNull(CastExpression_228_Var
		);
		//228
		final UnaryExpression UnaryExpression_229_Var
		 = (UnaryExpression)CastExpression_228_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_229_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_229_Var
		.getSizeOf());
		//229
		final UnaryExpression UnaryExpression_230_Var
		 = (UnaryExpression)UnaryExpression_229_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_230_Var
		);
		//230
		final PostfixExpression PostfixExpression_231_Var
		 = (PostfixExpression)UnaryExpression_230_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = PostfixExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final PrimaryExpression PrimaryExpression_232_Var
		 = (PrimaryExpression)Expr_231_list.get(0);
		Assert.assertNotNull(PrimaryExpression_232_Var
		);
		//232
		final Expression Expression_233_Var
		 = (Expression)PrimaryExpression_232_Var
		.getExpr();
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
		Assert.assertEquals("joe", PrimaryExpression_249_Var
		.getId());
		final EList<? extends EObject> Suffix_249_list = PostfixExpression_248_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_249_list);
		Assert.assertEquals(1, Suffix_249_list.size());
		//249
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_250_Var
		 = (PostfixExpressionSuffixDot)Suffix_249_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_250_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_250_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_180_Var
		.getSemi());
		//250
		final Statement Statement_251_Var
		 = (Statement)Statement_106_list.get(2);
		Assert.assertNotNull(Statement_251_Var
		);
		//251
		final ExpressionStatement ExpressionStatement_252_Var
		 = (ExpressionStatement)Statement_251_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_252_Var
		);
		//252
		final Expression Expression_253_Var
		 = (Expression)ExpressionStatement_252_Var
		.getExpression();
		Assert.assertNotNull(Expression_253_Var
		);
		final EList<? extends EObject> ExprExpr_253_list = Expression_253_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_253_list);
		Assert.assertEquals(1, ExprExpr_253_list.size());
		//253
		final AssignmentExpression AssignmentExpression_254_Var
		 = (AssignmentExpression)ExprExpr_253_list.get(0);
		Assert.assertNotNull(AssignmentExpression_254_Var
		);
		//254
		final ConditionalExpression ConditionalExpression_255_Var
		 = (ConditionalExpression)AssignmentExpression_254_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_255_Var
		);
		//255
		final LogicalOrExpression LogicalOrExpression_256_Var
		 = (LogicalOrExpression)ConditionalExpression_255_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_256_Var
		);
		final EList<? extends EObject> Expr_256_list = LogicalOrExpression_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(1, Expr_256_list.size());
		//256
		final LogicalAndExpression LogicalAndExpression_257_Var
		 = (LogicalAndExpression)Expr_256_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = LogicalAndExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final InclusiveOrExpression InclusiveOrExpression_258_Var
		 = (InclusiveOrExpression)Expr_257_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_258_Var
		);
		final EList<? extends EObject> Expr_258_list = InclusiveOrExpression_258_Var
		.getExpr();
		Assert.assertNotNull(Expr_258_list);
		Assert.assertEquals(1, Expr_258_list.size());
		//258
		final ExclusiveOrExpression ExclusiveOrExpression_259_Var
		 = (ExclusiveOrExpression)Expr_258_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_259_Var
		);
		final EList<? extends EObject> Expr_259_list = ExclusiveOrExpression_259_Var
		.getExpr();
		Assert.assertNotNull(Expr_259_list);
		Assert.assertEquals(1, Expr_259_list.size());
		//259
		final AndExpression AndExpression_260_Var
		 = (AndExpression)Expr_259_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_269_Var
		.getId());
		final EList<? extends EObject> Suffix_269_list = PostfixExpression_268_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_269_list);
		Assert.assertEquals(1, Suffix_269_list.size());
		//269
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_270_Var
		 = (PostfixExpressionSuffixArgument)Suffix_269_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_270_Var
		);
		//270
		final ArgumentExpressionList ArgumentExpressionList_271_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_270_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_271_Var
		);
		final EList<? extends EObject> Expr_271_list = ArgumentExpressionList_271_Var
		.getExpr();
		Assert.assertNotNull(Expr_271_list);
		Assert.assertEquals(2, Expr_271_list.size());
		//271
		final AssignmentExpression AssignmentExpression_272_Var
		 = (AssignmentExpression)Expr_271_list.get(0);
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
		Assert.assertEquals("[\"sizeof(joe)=%lu\\n\"]", PrimaryExpression_287_Var
		.getString().toString());
		//287
		final AssignmentExpression AssignmentExpression_288_Var
		 = (AssignmentExpression)Expr_271_list.get(1);
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
		Assert.assertEquals("sizeof", UnaryExpression_301_Var
		.getSizeOf());
		//301
		final UnaryExpression UnaryExpression_302_Var
		 = (UnaryExpression)UnaryExpression_301_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_302_Var
		);
		//302
		final PostfixExpression PostfixExpression_303_Var
		 = (PostfixExpression)UnaryExpression_302_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_303_Var
		);
		final EList<? extends EObject> Expr_303_list = PostfixExpression_303_Var
		.getExpr();
		Assert.assertNotNull(Expr_303_list);
		Assert.assertEquals(1, Expr_303_list.size());
		//303
		final PrimaryExpression PrimaryExpression_304_Var
		 = (PrimaryExpression)Expr_303_list.get(0);
		Assert.assertNotNull(PrimaryExpression_304_Var
		);
		//304
		final Expression Expression_305_Var
		 = (Expression)PrimaryExpression_304_Var
		.getExpr();
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
		Assert.assertEquals(1, Expr_308_list.size());
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
		Assert.assertEquals("joe", PrimaryExpression_321_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_252_Var
		.getSemi());
		//321
		final Statement Statement_322_Var
		 = (Statement)Statement_106_list.get(3);
		Assert.assertNotNull(Statement_322_Var
		);
		//322
		final ExpressionStatement ExpressionStatement_323_Var
		 = (ExpressionStatement)Statement_322_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_323_Var
		);
		//323
		final Expression Expression_324_Var
		 = (Expression)ExpressionStatement_323_Var
		.getExpression();
		Assert.assertNotNull(Expression_324_Var
		);
		final EList<? extends EObject> ExprExpr_324_list = Expression_324_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_324_list);
		Assert.assertEquals(1, ExprExpr_324_list.size());
		//324
		final AssignmentExpression AssignmentExpression_325_Var
		 = (AssignmentExpression)ExprExpr_324_list.get(0);
		Assert.assertNotNull(AssignmentExpression_325_Var
		);
		//325
		final UnaryExpression UnaryExpression_326_Var
		 = (UnaryExpression)AssignmentExpression_325_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_326_Var
		);
		//326
		final PostfixExpression PostfixExpression_327_Var
		 = (PostfixExpression)UnaryExpression_326_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_327_Var
		);
		final EList<? extends EObject> Expr_327_list = PostfixExpression_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final PrimaryExpression PrimaryExpression_328_Var
		 = (PrimaryExpression)Expr_327_list.get(0);
		Assert.assertNotNull(PrimaryExpression_328_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_328_Var
		.getId());
		final EList<? extends EObject> Suffix_328_list = PostfixExpression_327_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_328_list);
		Assert.assertEquals(1, Suffix_328_list.size());
		//328
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_329_Var
		 = (PostfixExpressionSuffixDot)Suffix_328_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_329_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_329_Var
		.getId());
		//329
		final AssignmentOperator AssignmentOperator_330_Var
		 = (AssignmentOperator)AssignmentExpression_325_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_330_Var
		);
		Assert.assertEquals("=", AssignmentOperator_330_Var
		.getOp());
		//330
		final AssignmentExpression AssignmentExpression_331_Var
		 = (AssignmentExpression)AssignmentExpression_325_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_331_Var
		);
		//331
		final ConditionalExpression ConditionalExpression_332_Var
		 = (ConditionalExpression)AssignmentExpression_331_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_332_Var
		);
		//332
		final LogicalOrExpression LogicalOrExpression_333_Var
		 = (LogicalOrExpression)ConditionalExpression_332_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = LogicalOrExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final LogicalAndExpression LogicalAndExpression_334_Var
		 = (LogicalAndExpression)Expr_333_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = LogicalAndExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final InclusiveOrExpression InclusiveOrExpression_335_Var
		 = (InclusiveOrExpression)Expr_334_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = InclusiveOrExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final ExclusiveOrExpression ExclusiveOrExpression_336_Var
		 = (ExclusiveOrExpression)Expr_335_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = ExclusiveOrExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final AndExpression AndExpression_337_Var
		 = (AndExpression)Expr_336_list.get(0);
		Assert.assertNotNull(AndExpression_337_Var
		);
		final EList<? extends EObject> Expr_337_list = AndExpression_337_Var
		.getExpr();
		Assert.assertNotNull(Expr_337_list);
		Assert.assertEquals(1, Expr_337_list.size());
		//337
		final EqualityExpression EqualityExpression_338_Var
		 = (EqualityExpression)Expr_337_list.get(0);
		Assert.assertNotNull(EqualityExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = EqualityExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final RelationalExpression RelationalExpression_339_Var
		 = (RelationalExpression)Expr_338_list.get(0);
		Assert.assertNotNull(RelationalExpression_339_Var
		);
		final EList<? extends EObject> Expr_339_list = RelationalExpression_339_Var
		.getExpr();
		Assert.assertNotNull(Expr_339_list);
		Assert.assertEquals(1, Expr_339_list.size());
		//339
		final ShiftExpression ShiftExpression_340_Var
		 = (ShiftExpression)Expr_339_list.get(0);
		Assert.assertNotNull(ShiftExpression_340_Var
		);
		final EList<? extends EObject> Expr_340_list = ShiftExpression_340_Var
		.getExpr();
		Assert.assertNotNull(Expr_340_list);
		Assert.assertEquals(1, Expr_340_list.size());
		//340
		final AdditiveExpression AdditiveExpression_341_Var
		 = (AdditiveExpression)Expr_340_list.get(0);
		Assert.assertNotNull(AdditiveExpression_341_Var
		);
		final EList<? extends EObject> Expr_341_list = AdditiveExpression_341_Var
		.getExpr();
		Assert.assertNotNull(Expr_341_list);
		Assert.assertEquals(1, Expr_341_list.size());
		//341
		final MultiplicativeExpression MultiplicativeExpression_342_Var
		 = (MultiplicativeExpression)Expr_341_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_342_Var
		);
		final EList<? extends EObject> Expr_342_list = MultiplicativeExpression_342_Var
		.getExpr();
		Assert.assertNotNull(Expr_342_list);
		Assert.assertEquals(1, Expr_342_list.size());
		//342
		final CastExpression CastExpression_343_Var
		 = (CastExpression)Expr_342_list.get(0);
		Assert.assertNotNull(CastExpression_343_Var
		);
		//343
		final UnaryExpression UnaryExpression_344_Var
		 = (UnaryExpression)CastExpression_343_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_344_Var
		);
		//344
		final PostfixExpression PostfixExpression_345_Var
		 = (PostfixExpression)UnaryExpression_344_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_345_Var
		);
		final EList<? extends EObject> Expr_345_list = PostfixExpression_345_Var
		.getExpr();
		Assert.assertNotNull(Expr_345_list);
		Assert.assertEquals(1, Expr_345_list.size());
		//345
		final PrimaryExpression PrimaryExpression_346_Var
		 = (PrimaryExpression)Expr_345_list.get(0);
		Assert.assertNotNull(PrimaryExpression_346_Var
		);
		//346
		final Constant2 Constant2_347_Var
		 = (Constant2)PrimaryExpression_346_Var
		.getConst();
		Assert.assertNotNull(Constant2_347_Var
		);
		Assert.assertEquals("0x008", Constant2_347_Var
		.getHex());
		Assert.assertEquals(";", ExpressionStatement_323_Var
		.getSemi());
		//347
		final Statement Statement_348_Var
		 = (Statement)Statement_106_list.get(4);
		Assert.assertNotNull(Statement_348_Var
		);
		//348
		final ExpressionStatement ExpressionStatement_349_Var
		 = (ExpressionStatement)Statement_348_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_349_Var
		);
		//349
		final Expression Expression_350_Var
		 = (Expression)ExpressionStatement_349_Var
		.getExpression();
		Assert.assertNotNull(Expression_350_Var
		);
		final EList<? extends EObject> ExprExpr_350_list = Expression_350_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_350_list);
		Assert.assertEquals(1, ExprExpr_350_list.size());
		//350
		final AssignmentExpression AssignmentExpression_351_Var
		 = (AssignmentExpression)ExprExpr_350_list.get(0);
		Assert.assertNotNull(AssignmentExpression_351_Var
		);
		//351
		final ConditionalExpression ConditionalExpression_352_Var
		 = (ConditionalExpression)AssignmentExpression_351_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_352_Var
		);
		//352
		final LogicalOrExpression LogicalOrExpression_353_Var
		 = (LogicalOrExpression)ConditionalExpression_352_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_353_Var
		);
		final EList<? extends EObject> Expr_353_list = LogicalOrExpression_353_Var
		.getExpr();
		Assert.assertNotNull(Expr_353_list);
		Assert.assertEquals(1, Expr_353_list.size());
		//353
		final LogicalAndExpression LogicalAndExpression_354_Var
		 = (LogicalAndExpression)Expr_353_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_354_Var
		);
		final EList<? extends EObject> Expr_354_list = LogicalAndExpression_354_Var
		.getExpr();
		Assert.assertNotNull(Expr_354_list);
		Assert.assertEquals(1, Expr_354_list.size());
		//354
		final InclusiveOrExpression InclusiveOrExpression_355_Var
		 = (InclusiveOrExpression)Expr_354_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_355_Var
		);
		final EList<? extends EObject> Expr_355_list = InclusiveOrExpression_355_Var
		.getExpr();
		Assert.assertNotNull(Expr_355_list);
		Assert.assertEquals(1, Expr_355_list.size());
		//355
		final ExclusiveOrExpression ExclusiveOrExpression_356_Var
		 = (ExclusiveOrExpression)Expr_355_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_356_Var
		);
		final EList<? extends EObject> Expr_356_list = ExclusiveOrExpression_356_Var
		.getExpr();
		Assert.assertNotNull(Expr_356_list);
		Assert.assertEquals(1, Expr_356_list.size());
		//356
		final AndExpression AndExpression_357_Var
		 = (AndExpression)Expr_356_list.get(0);
		Assert.assertNotNull(AndExpression_357_Var
		);
		final EList<? extends EObject> Expr_357_list = AndExpression_357_Var
		.getExpr();
		Assert.assertNotNull(Expr_357_list);
		Assert.assertEquals(1, Expr_357_list.size());
		//357
		final EqualityExpression EqualityExpression_358_Var
		 = (EqualityExpression)Expr_357_list.get(0);
		Assert.assertNotNull(EqualityExpression_358_Var
		);
		final EList<? extends EObject> Expr_358_list = EqualityExpression_358_Var
		.getExpr();
		Assert.assertNotNull(Expr_358_list);
		Assert.assertEquals(1, Expr_358_list.size());
		//358
		final RelationalExpression RelationalExpression_359_Var
		 = (RelationalExpression)Expr_358_list.get(0);
		Assert.assertNotNull(RelationalExpression_359_Var
		);
		final EList<? extends EObject> Expr_359_list = RelationalExpression_359_Var
		.getExpr();
		Assert.assertNotNull(Expr_359_list);
		Assert.assertEquals(1, Expr_359_list.size());
		//359
		final ShiftExpression ShiftExpression_360_Var
		 = (ShiftExpression)Expr_359_list.get(0);
		Assert.assertNotNull(ShiftExpression_360_Var
		);
		final EList<? extends EObject> Expr_360_list = ShiftExpression_360_Var
		.getExpr();
		Assert.assertNotNull(Expr_360_list);
		Assert.assertEquals(1, Expr_360_list.size());
		//360
		final AdditiveExpression AdditiveExpression_361_Var
		 = (AdditiveExpression)Expr_360_list.get(0);
		Assert.assertNotNull(AdditiveExpression_361_Var
		);
		final EList<? extends EObject> Expr_361_list = AdditiveExpression_361_Var
		.getExpr();
		Assert.assertNotNull(Expr_361_list);
		Assert.assertEquals(1, Expr_361_list.size());
		//361
		final MultiplicativeExpression MultiplicativeExpression_362_Var
		 = (MultiplicativeExpression)Expr_361_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_362_Var
		);
		final EList<? extends EObject> Expr_362_list = MultiplicativeExpression_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(1, Expr_362_list.size());
		//362
		final CastExpression CastExpression_363_Var
		 = (CastExpression)Expr_362_list.get(0);
		Assert.assertNotNull(CastExpression_363_Var
		);
		//363
		final UnaryExpression UnaryExpression_364_Var
		 = (UnaryExpression)CastExpression_363_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_364_Var
		);
		//364
		final PostfixExpression PostfixExpression_365_Var
		 = (PostfixExpression)UnaryExpression_364_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = PostfixExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final PrimaryExpression PrimaryExpression_366_Var
		 = (PrimaryExpression)Expr_365_list.get(0);
		Assert.assertNotNull(PrimaryExpression_366_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_366_Var
		.getId());
		final EList<? extends EObject> Suffix_366_list = PostfixExpression_365_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_366_list);
		Assert.assertEquals(1, Suffix_366_list.size());
		//366
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_367_Var
		 = (PostfixExpressionSuffixArgument)Suffix_366_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_367_Var
		);
		//367
		final ArgumentExpressionList ArgumentExpressionList_368_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_367_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_368_Var
		);
		final EList<? extends EObject> Expr_368_list = ArgumentExpressionList_368_Var
		.getExpr();
		Assert.assertNotNull(Expr_368_list);
		Assert.assertEquals(2, Expr_368_list.size());
		//368
		final AssignmentExpression AssignmentExpression_369_Var
		 = (AssignmentExpression)Expr_368_list.get(0);
		Assert.assertNotNull(AssignmentExpression_369_Var
		);
		//369
		final ConditionalExpression ConditionalExpression_370_Var
		 = (ConditionalExpression)AssignmentExpression_369_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_370_Var
		);
		//370
		final LogicalOrExpression LogicalOrExpression_371_Var
		 = (LogicalOrExpression)ConditionalExpression_370_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_371_Var
		);
		final EList<? extends EObject> Expr_371_list = LogicalOrExpression_371_Var
		.getExpr();
		Assert.assertNotNull(Expr_371_list);
		Assert.assertEquals(1, Expr_371_list.size());
		//371
		final LogicalAndExpression LogicalAndExpression_372_Var
		 = (LogicalAndExpression)Expr_371_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_372_Var
		);
		final EList<? extends EObject> Expr_372_list = LogicalAndExpression_372_Var
		.getExpr();
		Assert.assertNotNull(Expr_372_list);
		Assert.assertEquals(1, Expr_372_list.size());
		//372
		final InclusiveOrExpression InclusiveOrExpression_373_Var
		 = (InclusiveOrExpression)Expr_372_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_373_Var
		);
		final EList<? extends EObject> Expr_373_list = InclusiveOrExpression_373_Var
		.getExpr();
		Assert.assertNotNull(Expr_373_list);
		Assert.assertEquals(1, Expr_373_list.size());
		//373
		final ExclusiveOrExpression ExclusiveOrExpression_374_Var
		 = (ExclusiveOrExpression)Expr_373_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_374_Var
		);
		final EList<? extends EObject> Expr_374_list = ExclusiveOrExpression_374_Var
		.getExpr();
		Assert.assertNotNull(Expr_374_list);
		Assert.assertEquals(1, Expr_374_list.size());
		//374
		final AndExpression AndExpression_375_Var
		 = (AndExpression)Expr_374_list.get(0);
		Assert.assertNotNull(AndExpression_375_Var
		);
		final EList<? extends EObject> Expr_375_list = AndExpression_375_Var
		.getExpr();
		Assert.assertNotNull(Expr_375_list);
		Assert.assertEquals(1, Expr_375_list.size());
		//375
		final EqualityExpression EqualityExpression_376_Var
		 = (EqualityExpression)Expr_375_list.get(0);
		Assert.assertNotNull(EqualityExpression_376_Var
		);
		final EList<? extends EObject> Expr_376_list = EqualityExpression_376_Var
		.getExpr();
		Assert.assertNotNull(Expr_376_list);
		Assert.assertEquals(1, Expr_376_list.size());
		//376
		final RelationalExpression RelationalExpression_377_Var
		 = (RelationalExpression)Expr_376_list.get(0);
		Assert.assertNotNull(RelationalExpression_377_Var
		);
		final EList<? extends EObject> Expr_377_list = RelationalExpression_377_Var
		.getExpr();
		Assert.assertNotNull(Expr_377_list);
		Assert.assertEquals(1, Expr_377_list.size());
		//377
		final ShiftExpression ShiftExpression_378_Var
		 = (ShiftExpression)Expr_377_list.get(0);
		Assert.assertNotNull(ShiftExpression_378_Var
		);
		final EList<? extends EObject> Expr_378_list = ShiftExpression_378_Var
		.getExpr();
		Assert.assertNotNull(Expr_378_list);
		Assert.assertEquals(1, Expr_378_list.size());
		//378
		final AdditiveExpression AdditiveExpression_379_Var
		 = (AdditiveExpression)Expr_378_list.get(0);
		Assert.assertNotNull(AdditiveExpression_379_Var
		);
		final EList<? extends EObject> Expr_379_list = AdditiveExpression_379_Var
		.getExpr();
		Assert.assertNotNull(Expr_379_list);
		Assert.assertEquals(1, Expr_379_list.size());
		//379
		final MultiplicativeExpression MultiplicativeExpression_380_Var
		 = (MultiplicativeExpression)Expr_379_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_380_Var
		);
		final EList<? extends EObject> Expr_380_list = MultiplicativeExpression_380_Var
		.getExpr();
		Assert.assertNotNull(Expr_380_list);
		Assert.assertEquals(1, Expr_380_list.size());
		//380
		final CastExpression CastExpression_381_Var
		 = (CastExpression)Expr_380_list.get(0);
		Assert.assertNotNull(CastExpression_381_Var
		);
		//381
		final UnaryExpression UnaryExpression_382_Var
		 = (UnaryExpression)CastExpression_381_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_382_Var
		);
		//382
		final PostfixExpression PostfixExpression_383_Var
		 = (PostfixExpression)UnaryExpression_382_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_383_Var
		);
		final EList<? extends EObject> Expr_383_list = PostfixExpression_383_Var
		.getExpr();
		Assert.assertNotNull(Expr_383_list);
		Assert.assertEquals(1, Expr_383_list.size());
		//383
		final PrimaryExpression PrimaryExpression_384_Var
		 = (PrimaryExpression)Expr_383_list.get(0);
		Assert.assertNotNull(PrimaryExpression_384_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_384_Var
		.getId());
		final EList<? extends EObject> Suffix_384_list = PostfixExpression_383_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_384_list);
		Assert.assertEquals(1, Suffix_384_list.size());
		//384
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_385_Var
		 = (PostfixExpressionSuffixDot)Suffix_384_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_385_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_385_Var
		.getId());
		//385
		final AssignmentExpression AssignmentExpression_386_Var
		 = (AssignmentExpression)Expr_368_list.get(1);
		Assert.assertNotNull(AssignmentExpression_386_Var
		);
		//386
		final ConditionalExpression ConditionalExpression_387_Var
		 = (ConditionalExpression)AssignmentExpression_386_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_387_Var
		);
		//387
		final LogicalOrExpression LogicalOrExpression_388_Var
		 = (LogicalOrExpression)ConditionalExpression_387_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_388_Var
		);
		final EList<? extends EObject> Expr_388_list = LogicalOrExpression_388_Var
		.getExpr();
		Assert.assertNotNull(Expr_388_list);
		Assert.assertEquals(1, Expr_388_list.size());
		//388
		final LogicalAndExpression LogicalAndExpression_389_Var
		 = (LogicalAndExpression)Expr_388_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_389_Var
		);
		final EList<? extends EObject> Expr_389_list = LogicalAndExpression_389_Var
		.getExpr();
		Assert.assertNotNull(Expr_389_list);
		Assert.assertEquals(1, Expr_389_list.size());
		//389
		final InclusiveOrExpression InclusiveOrExpression_390_Var
		 = (InclusiveOrExpression)Expr_389_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_390_Var
		);
		final EList<? extends EObject> Expr_390_list = InclusiveOrExpression_390_Var
		.getExpr();
		Assert.assertNotNull(Expr_390_list);
		Assert.assertEquals(1, Expr_390_list.size());
		//390
		final ExclusiveOrExpression ExclusiveOrExpression_391_Var
		 = (ExclusiveOrExpression)Expr_390_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_391_Var
		);
		final EList<? extends EObject> Expr_391_list = ExclusiveOrExpression_391_Var
		.getExpr();
		Assert.assertNotNull(Expr_391_list);
		Assert.assertEquals(1, Expr_391_list.size());
		//391
		final AndExpression AndExpression_392_Var
		 = (AndExpression)Expr_391_list.get(0);
		Assert.assertNotNull(AndExpression_392_Var
		);
		final EList<? extends EObject> Expr_392_list = AndExpression_392_Var
		.getExpr();
		Assert.assertNotNull(Expr_392_list);
		Assert.assertEquals(1, Expr_392_list.size());
		//392
		final EqualityExpression EqualityExpression_393_Var
		 = (EqualityExpression)Expr_392_list.get(0);
		Assert.assertNotNull(EqualityExpression_393_Var
		);
		final EList<? extends EObject> Expr_393_list = EqualityExpression_393_Var
		.getExpr();
		Assert.assertNotNull(Expr_393_list);
		Assert.assertEquals(1, Expr_393_list.size());
		//393
		final RelationalExpression RelationalExpression_394_Var
		 = (RelationalExpression)Expr_393_list.get(0);
		Assert.assertNotNull(RelationalExpression_394_Var
		);
		final EList<? extends EObject> Expr_394_list = RelationalExpression_394_Var
		.getExpr();
		Assert.assertNotNull(Expr_394_list);
		Assert.assertEquals(1, Expr_394_list.size());
		//394
		final ShiftExpression ShiftExpression_395_Var
		 = (ShiftExpression)Expr_394_list.get(0);
		Assert.assertNotNull(ShiftExpression_395_Var
		);
		final EList<? extends EObject> Expr_395_list = ShiftExpression_395_Var
		.getExpr();
		Assert.assertNotNull(Expr_395_list);
		Assert.assertEquals(1, Expr_395_list.size());
		//395
		final AdditiveExpression AdditiveExpression_396_Var
		 = (AdditiveExpression)Expr_395_list.get(0);
		Assert.assertNotNull(AdditiveExpression_396_Var
		);
		final EList<? extends EObject> Expr_396_list = AdditiveExpression_396_Var
		.getExpr();
		Assert.assertNotNull(Expr_396_list);
		Assert.assertEquals(1, Expr_396_list.size());
		//396
		final MultiplicativeExpression MultiplicativeExpression_397_Var
		 = (MultiplicativeExpression)Expr_396_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_397_Var
		);
		final EList<? extends EObject> Expr_397_list = MultiplicativeExpression_397_Var
		.getExpr();
		Assert.assertNotNull(Expr_397_list);
		Assert.assertEquals(1, Expr_397_list.size());
		//397
		final CastExpression CastExpression_398_Var
		 = (CastExpression)Expr_397_list.get(0);
		Assert.assertNotNull(CastExpression_398_Var
		);
		//398
		final UnaryExpression UnaryExpression_399_Var
		 = (UnaryExpression)CastExpression_398_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_399_Var
		);
		//399
		final PostfixExpression PostfixExpression_400_Var
		 = (PostfixExpression)UnaryExpression_399_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_400_Var
		);
		final EList<? extends EObject> Expr_400_list = PostfixExpression_400_Var
		.getExpr();
		Assert.assertNotNull(Expr_400_list);
		Assert.assertEquals(1, Expr_400_list.size());
		//400
		final PrimaryExpression PrimaryExpression_401_Var
		 = (PrimaryExpression)Expr_400_list.get(0);
		Assert.assertNotNull(PrimaryExpression_401_Var
		);
		Assert.assertEquals("[\"Phil Morrison\"]", PrimaryExpression_401_Var
		.getString().toString());
		Assert.assertEquals(";", ExpressionStatement_349_Var
		.getSemi());
		//401
		final Statement Statement_402_Var
		 = (Statement)Statement_106_list.get(5);
		Assert.assertNotNull(Statement_402_Var
		);
		//402
		final ExpressionStatement ExpressionStatement_403_Var
		 = (ExpressionStatement)Statement_402_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_403_Var
		);
		//403
		final Expression Expression_404_Var
		 = (Expression)ExpressionStatement_403_Var
		.getExpression();
		Assert.assertNotNull(Expression_404_Var
		);
		final EList<? extends EObject> ExprExpr_404_list = Expression_404_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_404_list);
		Assert.assertEquals(1, ExprExpr_404_list.size());
		//404
		final AssignmentExpression AssignmentExpression_405_Var
		 = (AssignmentExpression)ExprExpr_404_list.get(0);
		Assert.assertNotNull(AssignmentExpression_405_Var
		);
		//405
		final ConditionalExpression ConditionalExpression_406_Var
		 = (ConditionalExpression)AssignmentExpression_405_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_406_Var
		);
		//406
		final LogicalOrExpression LogicalOrExpression_407_Var
		 = (LogicalOrExpression)ConditionalExpression_406_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_407_Var
		);
		final EList<? extends EObject> Expr_407_list = LogicalOrExpression_407_Var
		.getExpr();
		Assert.assertNotNull(Expr_407_list);
		Assert.assertEquals(1, Expr_407_list.size());
		//407
		final LogicalAndExpression LogicalAndExpression_408_Var
		 = (LogicalAndExpression)Expr_407_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_408_Var
		);
		final EList<? extends EObject> Expr_408_list = LogicalAndExpression_408_Var
		.getExpr();
		Assert.assertNotNull(Expr_408_list);
		Assert.assertEquals(1, Expr_408_list.size());
		//408
		final InclusiveOrExpression InclusiveOrExpression_409_Var
		 = (InclusiveOrExpression)Expr_408_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_409_Var
		);
		final EList<? extends EObject> Expr_409_list = InclusiveOrExpression_409_Var
		.getExpr();
		Assert.assertNotNull(Expr_409_list);
		Assert.assertEquals(1, Expr_409_list.size());
		//409
		final ExclusiveOrExpression ExclusiveOrExpression_410_Var
		 = (ExclusiveOrExpression)Expr_409_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_410_Var
		);
		final EList<? extends EObject> Expr_410_list = ExclusiveOrExpression_410_Var
		.getExpr();
		Assert.assertNotNull(Expr_410_list);
		Assert.assertEquals(1, Expr_410_list.size());
		//410
		final AndExpression AndExpression_411_Var
		 = (AndExpression)Expr_410_list.get(0);
		Assert.assertNotNull(AndExpression_411_Var
		);
		final EList<? extends EObject> Expr_411_list = AndExpression_411_Var
		.getExpr();
		Assert.assertNotNull(Expr_411_list);
		Assert.assertEquals(1, Expr_411_list.size());
		//411
		final EqualityExpression EqualityExpression_412_Var
		 = (EqualityExpression)Expr_411_list.get(0);
		Assert.assertNotNull(EqualityExpression_412_Var
		);
		final EList<? extends EObject> Expr_412_list = EqualityExpression_412_Var
		.getExpr();
		Assert.assertNotNull(Expr_412_list);
		Assert.assertEquals(1, Expr_412_list.size());
		//412
		final RelationalExpression RelationalExpression_413_Var
		 = (RelationalExpression)Expr_412_list.get(0);
		Assert.assertNotNull(RelationalExpression_413_Var
		);
		final EList<? extends EObject> Expr_413_list = RelationalExpression_413_Var
		.getExpr();
		Assert.assertNotNull(Expr_413_list);
		Assert.assertEquals(1, Expr_413_list.size());
		//413
		final ShiftExpression ShiftExpression_414_Var
		 = (ShiftExpression)Expr_413_list.get(0);
		Assert.assertNotNull(ShiftExpression_414_Var
		);
		final EList<? extends EObject> Expr_414_list = ShiftExpression_414_Var
		.getExpr();
		Assert.assertNotNull(Expr_414_list);
		Assert.assertEquals(1, Expr_414_list.size());
		//414
		final AdditiveExpression AdditiveExpression_415_Var
		 = (AdditiveExpression)Expr_414_list.get(0);
		Assert.assertNotNull(AdditiveExpression_415_Var
		);
		final EList<? extends EObject> Expr_415_list = AdditiveExpression_415_Var
		.getExpr();
		Assert.assertNotNull(Expr_415_list);
		Assert.assertEquals(1, Expr_415_list.size());
		//415
		final MultiplicativeExpression MultiplicativeExpression_416_Var
		 = (MultiplicativeExpression)Expr_415_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_416_Var
		);
		final EList<? extends EObject> Expr_416_list = MultiplicativeExpression_416_Var
		.getExpr();
		Assert.assertNotNull(Expr_416_list);
		Assert.assertEquals(1, Expr_416_list.size());
		//416
		final CastExpression CastExpression_417_Var
		 = (CastExpression)Expr_416_list.get(0);
		Assert.assertNotNull(CastExpression_417_Var
		);
		//417
		final UnaryExpression UnaryExpression_418_Var
		 = (UnaryExpression)CastExpression_417_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_418_Var
		);
		//418
		final PostfixExpression PostfixExpression_419_Var
		 = (PostfixExpression)UnaryExpression_418_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_419_Var
		);
		final EList<? extends EObject> Expr_419_list = PostfixExpression_419_Var
		.getExpr();
		Assert.assertNotNull(Expr_419_list);
		Assert.assertEquals(1, Expr_419_list.size());
		//419
		final PrimaryExpression PrimaryExpression_420_Var
		 = (PrimaryExpression)Expr_419_list.get(0);
		Assert.assertNotNull(PrimaryExpression_420_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_420_Var
		.getId());
		final EList<? extends EObject> Suffix_420_list = PostfixExpression_419_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_420_list);
		Assert.assertEquals(1, Suffix_420_list.size());
		//420
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_421_Var
		 = (PostfixExpressionSuffixArgument)Suffix_420_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_421_Var
		);
		//421
		final ArgumentExpressionList ArgumentExpressionList_422_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_421_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_422_Var
		);
		final EList<? extends EObject> Expr_422_list = ArgumentExpressionList_422_Var
		.getExpr();
		Assert.assertNotNull(Expr_422_list);
		Assert.assertEquals(2, Expr_422_list.size());
		//422
		final AssignmentExpression AssignmentExpression_423_Var
		 = (AssignmentExpression)Expr_422_list.get(0);
		Assert.assertNotNull(AssignmentExpression_423_Var
		);
		//423
		final ConditionalExpression ConditionalExpression_424_Var
		 = (ConditionalExpression)AssignmentExpression_423_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_424_Var
		);
		//424
		final LogicalOrExpression LogicalOrExpression_425_Var
		 = (LogicalOrExpression)ConditionalExpression_424_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_425_Var
		);
		final EList<? extends EObject> Expr_425_list = LogicalOrExpression_425_Var
		.getExpr();
		Assert.assertNotNull(Expr_425_list);
		Assert.assertEquals(1, Expr_425_list.size());
		//425
		final LogicalAndExpression LogicalAndExpression_426_Var
		 = (LogicalAndExpression)Expr_425_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_426_Var
		);
		final EList<? extends EObject> Expr_426_list = LogicalAndExpression_426_Var
		.getExpr();
		Assert.assertNotNull(Expr_426_list);
		Assert.assertEquals(1, Expr_426_list.size());
		//426
		final InclusiveOrExpression InclusiveOrExpression_427_Var
		 = (InclusiveOrExpression)Expr_426_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_427_Var
		);
		final EList<? extends EObject> Expr_427_list = InclusiveOrExpression_427_Var
		.getExpr();
		Assert.assertNotNull(Expr_427_list);
		Assert.assertEquals(1, Expr_427_list.size());
		//427
		final ExclusiveOrExpression ExclusiveOrExpression_428_Var
		 = (ExclusiveOrExpression)Expr_427_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_428_Var
		);
		final EList<? extends EObject> Expr_428_list = ExclusiveOrExpression_428_Var
		.getExpr();
		Assert.assertNotNull(Expr_428_list);
		Assert.assertEquals(1, Expr_428_list.size());
		//428
		final AndExpression AndExpression_429_Var
		 = (AndExpression)Expr_428_list.get(0);
		Assert.assertNotNull(AndExpression_429_Var
		);
		final EList<? extends EObject> Expr_429_list = AndExpression_429_Var
		.getExpr();
		Assert.assertNotNull(Expr_429_list);
		Assert.assertEquals(1, Expr_429_list.size());
		//429
		final EqualityExpression EqualityExpression_430_Var
		 = (EqualityExpression)Expr_429_list.get(0);
		Assert.assertNotNull(EqualityExpression_430_Var
		);
		final EList<? extends EObject> Expr_430_list = EqualityExpression_430_Var
		.getExpr();
		Assert.assertNotNull(Expr_430_list);
		Assert.assertEquals(1, Expr_430_list.size());
		//430
		final RelationalExpression RelationalExpression_431_Var
		 = (RelationalExpression)Expr_430_list.get(0);
		Assert.assertNotNull(RelationalExpression_431_Var
		);
		final EList<? extends EObject> Expr_431_list = RelationalExpression_431_Var
		.getExpr();
		Assert.assertNotNull(Expr_431_list);
		Assert.assertEquals(1, Expr_431_list.size());
		//431
		final ShiftExpression ShiftExpression_432_Var
		 = (ShiftExpression)Expr_431_list.get(0);
		Assert.assertNotNull(ShiftExpression_432_Var
		);
		final EList<? extends EObject> Expr_432_list = ShiftExpression_432_Var
		.getExpr();
		Assert.assertNotNull(Expr_432_list);
		Assert.assertEquals(1, Expr_432_list.size());
		//432
		final AdditiveExpression AdditiveExpression_433_Var
		 = (AdditiveExpression)Expr_432_list.get(0);
		Assert.assertNotNull(AdditiveExpression_433_Var
		);
		final EList<? extends EObject> Expr_433_list = AdditiveExpression_433_Var
		.getExpr();
		Assert.assertNotNull(Expr_433_list);
		Assert.assertEquals(1, Expr_433_list.size());
		//433
		final MultiplicativeExpression MultiplicativeExpression_434_Var
		 = (MultiplicativeExpression)Expr_433_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_434_Var
		);
		final EList<? extends EObject> Expr_434_list = MultiplicativeExpression_434_Var
		.getExpr();
		Assert.assertNotNull(Expr_434_list);
		Assert.assertEquals(1, Expr_434_list.size());
		//434
		final CastExpression CastExpression_435_Var
		 = (CastExpression)Expr_434_list.get(0);
		Assert.assertNotNull(CastExpression_435_Var
		);
		//435
		final UnaryExpression UnaryExpression_436_Var
		 = (UnaryExpression)CastExpression_435_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_436_Var
		);
		//436
		final PostfixExpression PostfixExpression_437_Var
		 = (PostfixExpression)UnaryExpression_436_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_437_Var
		);
		final EList<? extends EObject> Expr_437_list = PostfixExpression_437_Var
		.getExpr();
		Assert.assertNotNull(Expr_437_list);
		Assert.assertEquals(1, Expr_437_list.size());
		//437
		final PrimaryExpression PrimaryExpression_438_Var
		 = (PrimaryExpression)Expr_437_list.get(0);
		Assert.assertNotNull(PrimaryExpression_438_Var
		);
		Assert.assertEquals("[\"joe.id=%d\\n\"]", PrimaryExpression_438_Var
		.getString().toString());
		//438
		final AssignmentExpression AssignmentExpression_439_Var
		 = (AssignmentExpression)Expr_422_list.get(1);
		Assert.assertNotNull(AssignmentExpression_439_Var
		);
		//439
		final ConditionalExpression ConditionalExpression_440_Var
		 = (ConditionalExpression)AssignmentExpression_439_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_440_Var
		);
		//440
		final LogicalOrExpression LogicalOrExpression_441_Var
		 = (LogicalOrExpression)ConditionalExpression_440_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_441_Var
		);
		final EList<? extends EObject> Expr_441_list = LogicalOrExpression_441_Var
		.getExpr();
		Assert.assertNotNull(Expr_441_list);
		Assert.assertEquals(1, Expr_441_list.size());
		//441
		final LogicalAndExpression LogicalAndExpression_442_Var
		 = (LogicalAndExpression)Expr_441_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_442_Var
		);
		final EList<? extends EObject> Expr_442_list = LogicalAndExpression_442_Var
		.getExpr();
		Assert.assertNotNull(Expr_442_list);
		Assert.assertEquals(1, Expr_442_list.size());
		//442
		final InclusiveOrExpression InclusiveOrExpression_443_Var
		 = (InclusiveOrExpression)Expr_442_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_443_Var
		);
		final EList<? extends EObject> Expr_443_list = InclusiveOrExpression_443_Var
		.getExpr();
		Assert.assertNotNull(Expr_443_list);
		Assert.assertEquals(1, Expr_443_list.size());
		//443
		final ExclusiveOrExpression ExclusiveOrExpression_444_Var
		 = (ExclusiveOrExpression)Expr_443_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_444_Var
		);
		final EList<? extends EObject> Expr_444_list = ExclusiveOrExpression_444_Var
		.getExpr();
		Assert.assertNotNull(Expr_444_list);
		Assert.assertEquals(1, Expr_444_list.size());
		//444
		final AndExpression AndExpression_445_Var
		 = (AndExpression)Expr_444_list.get(0);
		Assert.assertNotNull(AndExpression_445_Var
		);
		final EList<? extends EObject> Expr_445_list = AndExpression_445_Var
		.getExpr();
		Assert.assertNotNull(Expr_445_list);
		Assert.assertEquals(1, Expr_445_list.size());
		//445
		final EqualityExpression EqualityExpression_446_Var
		 = (EqualityExpression)Expr_445_list.get(0);
		Assert.assertNotNull(EqualityExpression_446_Var
		);
		final EList<? extends EObject> Expr_446_list = EqualityExpression_446_Var
		.getExpr();
		Assert.assertNotNull(Expr_446_list);
		Assert.assertEquals(1, Expr_446_list.size());
		//446
		final RelationalExpression RelationalExpression_447_Var
		 = (RelationalExpression)Expr_446_list.get(0);
		Assert.assertNotNull(RelationalExpression_447_Var
		);
		final EList<? extends EObject> Expr_447_list = RelationalExpression_447_Var
		.getExpr();
		Assert.assertNotNull(Expr_447_list);
		Assert.assertEquals(1, Expr_447_list.size());
		//447
		final ShiftExpression ShiftExpression_448_Var
		 = (ShiftExpression)Expr_447_list.get(0);
		Assert.assertNotNull(ShiftExpression_448_Var
		);
		final EList<? extends EObject> Expr_448_list = ShiftExpression_448_Var
		.getExpr();
		Assert.assertNotNull(Expr_448_list);
		Assert.assertEquals(1, Expr_448_list.size());
		//448
		final AdditiveExpression AdditiveExpression_449_Var
		 = (AdditiveExpression)Expr_448_list.get(0);
		Assert.assertNotNull(AdditiveExpression_449_Var
		);
		final EList<? extends EObject> Expr_449_list = AdditiveExpression_449_Var
		.getExpr();
		Assert.assertNotNull(Expr_449_list);
		Assert.assertEquals(1, Expr_449_list.size());
		//449
		final MultiplicativeExpression MultiplicativeExpression_450_Var
		 = (MultiplicativeExpression)Expr_449_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_450_Var
		);
		final EList<? extends EObject> Expr_450_list = MultiplicativeExpression_450_Var
		.getExpr();
		Assert.assertNotNull(Expr_450_list);
		Assert.assertEquals(1, Expr_450_list.size());
		//450
		final CastExpression CastExpression_451_Var
		 = (CastExpression)Expr_450_list.get(0);
		Assert.assertNotNull(CastExpression_451_Var
		);
		//451
		final UnaryExpression UnaryExpression_452_Var
		 = (UnaryExpression)CastExpression_451_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_452_Var
		);
		//452
		final PostfixExpression PostfixExpression_453_Var
		 = (PostfixExpression)UnaryExpression_452_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_453_Var
		);
		final EList<? extends EObject> Expr_453_list = PostfixExpression_453_Var
		.getExpr();
		Assert.assertNotNull(Expr_453_list);
		Assert.assertEquals(1, Expr_453_list.size());
		//453
		final PrimaryExpression PrimaryExpression_454_Var
		 = (PrimaryExpression)Expr_453_list.get(0);
		Assert.assertNotNull(PrimaryExpression_454_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_454_Var
		.getId());
		final EList<? extends EObject> Suffix_454_list = PostfixExpression_453_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_454_list);
		Assert.assertEquals(1, Suffix_454_list.size());
		//454
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_455_Var
		 = (PostfixExpressionSuffixDot)Suffix_454_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_455_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_455_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_403_Var
		.getSemi());
		//455
		final Statement Statement_456_Var
		 = (Statement)Statement_106_list.get(6);
		Assert.assertNotNull(Statement_456_Var
		);
		//456
		final ExpressionStatement ExpressionStatement_457_Var
		 = (ExpressionStatement)Statement_456_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_457_Var
		);
		//457
		final Expression Expression_458_Var
		 = (Expression)ExpressionStatement_457_Var
		.getExpression();
		Assert.assertNotNull(Expression_458_Var
		);
		final EList<? extends EObject> ExprExpr_458_list = Expression_458_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_458_list);
		Assert.assertEquals(1, ExprExpr_458_list.size());
		//458
		final AssignmentExpression AssignmentExpression_459_Var
		 = (AssignmentExpression)ExprExpr_458_list.get(0);
		Assert.assertNotNull(AssignmentExpression_459_Var
		);
		//459
		final ConditionalExpression ConditionalExpression_460_Var
		 = (ConditionalExpression)AssignmentExpression_459_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_460_Var
		);
		//460
		final LogicalOrExpression LogicalOrExpression_461_Var
		 = (LogicalOrExpression)ConditionalExpression_460_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_461_Var
		);
		final EList<? extends EObject> Expr_461_list = LogicalOrExpression_461_Var
		.getExpr();
		Assert.assertNotNull(Expr_461_list);
		Assert.assertEquals(1, Expr_461_list.size());
		//461
		final LogicalAndExpression LogicalAndExpression_462_Var
		 = (LogicalAndExpression)Expr_461_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_462_Var
		);
		final EList<? extends EObject> Expr_462_list = LogicalAndExpression_462_Var
		.getExpr();
		Assert.assertNotNull(Expr_462_list);
		Assert.assertEquals(1, Expr_462_list.size());
		//462
		final InclusiveOrExpression InclusiveOrExpression_463_Var
		 = (InclusiveOrExpression)Expr_462_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_463_Var
		);
		final EList<? extends EObject> Expr_463_list = InclusiveOrExpression_463_Var
		.getExpr();
		Assert.assertNotNull(Expr_463_list);
		Assert.assertEquals(1, Expr_463_list.size());
		//463
		final ExclusiveOrExpression ExclusiveOrExpression_464_Var
		 = (ExclusiveOrExpression)Expr_463_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_464_Var
		);
		final EList<? extends EObject> Expr_464_list = ExclusiveOrExpression_464_Var
		.getExpr();
		Assert.assertNotNull(Expr_464_list);
		Assert.assertEquals(1, Expr_464_list.size());
		//464
		final AndExpression AndExpression_465_Var
		 = (AndExpression)Expr_464_list.get(0);
		Assert.assertNotNull(AndExpression_465_Var
		);
		final EList<? extends EObject> Expr_465_list = AndExpression_465_Var
		.getExpr();
		Assert.assertNotNull(Expr_465_list);
		Assert.assertEquals(1, Expr_465_list.size());
		//465
		final EqualityExpression EqualityExpression_466_Var
		 = (EqualityExpression)Expr_465_list.get(0);
		Assert.assertNotNull(EqualityExpression_466_Var
		);
		final EList<? extends EObject> Expr_466_list = EqualityExpression_466_Var
		.getExpr();
		Assert.assertNotNull(Expr_466_list);
		Assert.assertEquals(1, Expr_466_list.size());
		//466
		final RelationalExpression RelationalExpression_467_Var
		 = (RelationalExpression)Expr_466_list.get(0);
		Assert.assertNotNull(RelationalExpression_467_Var
		);
		final EList<? extends EObject> Expr_467_list = RelationalExpression_467_Var
		.getExpr();
		Assert.assertNotNull(Expr_467_list);
		Assert.assertEquals(1, Expr_467_list.size());
		//467
		final ShiftExpression ShiftExpression_468_Var
		 = (ShiftExpression)Expr_467_list.get(0);
		Assert.assertNotNull(ShiftExpression_468_Var
		);
		final EList<? extends EObject> Expr_468_list = ShiftExpression_468_Var
		.getExpr();
		Assert.assertNotNull(Expr_468_list);
		Assert.assertEquals(1, Expr_468_list.size());
		//468
		final AdditiveExpression AdditiveExpression_469_Var
		 = (AdditiveExpression)Expr_468_list.get(0);
		Assert.assertNotNull(AdditiveExpression_469_Var
		);
		final EList<? extends EObject> Expr_469_list = AdditiveExpression_469_Var
		.getExpr();
		Assert.assertNotNull(Expr_469_list);
		Assert.assertEquals(1, Expr_469_list.size());
		//469
		final MultiplicativeExpression MultiplicativeExpression_470_Var
		 = (MultiplicativeExpression)Expr_469_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_470_Var
		);
		final EList<? extends EObject> Expr_470_list = MultiplicativeExpression_470_Var
		.getExpr();
		Assert.assertNotNull(Expr_470_list);
		Assert.assertEquals(1, Expr_470_list.size());
		//470
		final CastExpression CastExpression_471_Var
		 = (CastExpression)Expr_470_list.get(0);
		Assert.assertNotNull(CastExpression_471_Var
		);
		//471
		final UnaryExpression UnaryExpression_472_Var
		 = (UnaryExpression)CastExpression_471_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_472_Var
		);
		//472
		final PostfixExpression PostfixExpression_473_Var
		 = (PostfixExpression)UnaryExpression_472_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_473_Var
		);
		final EList<? extends EObject> Expr_473_list = PostfixExpression_473_Var
		.getExpr();
		Assert.assertNotNull(Expr_473_list);
		Assert.assertEquals(1, Expr_473_list.size());
		//473
		final PrimaryExpression PrimaryExpression_474_Var
		 = (PrimaryExpression)Expr_473_list.get(0);
		Assert.assertNotNull(PrimaryExpression_474_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_474_Var
		.getId());
		final EList<? extends EObject> Suffix_474_list = PostfixExpression_473_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_474_list);
		Assert.assertEquals(1, Suffix_474_list.size());
		//474
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_475_Var
		 = (PostfixExpressionSuffixArgument)Suffix_474_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_475_Var
		);
		//475
		final ArgumentExpressionList ArgumentExpressionList_476_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_475_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_476_Var
		);
		final EList<? extends EObject> Expr_476_list = ArgumentExpressionList_476_Var
		.getExpr();
		Assert.assertNotNull(Expr_476_list);
		Assert.assertEquals(2, Expr_476_list.size());
		//476
		final AssignmentExpression AssignmentExpression_477_Var
		 = (AssignmentExpression)Expr_476_list.get(0);
		Assert.assertNotNull(AssignmentExpression_477_Var
		);
		//477
		final ConditionalExpression ConditionalExpression_478_Var
		 = (ConditionalExpression)AssignmentExpression_477_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_478_Var
		);
		//478
		final LogicalOrExpression LogicalOrExpression_479_Var
		 = (LogicalOrExpression)ConditionalExpression_478_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_479_Var
		);
		final EList<? extends EObject> Expr_479_list = LogicalOrExpression_479_Var
		.getExpr();
		Assert.assertNotNull(Expr_479_list);
		Assert.assertEquals(1, Expr_479_list.size());
		//479
		final LogicalAndExpression LogicalAndExpression_480_Var
		 = (LogicalAndExpression)Expr_479_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_480_Var
		);
		final EList<? extends EObject> Expr_480_list = LogicalAndExpression_480_Var
		.getExpr();
		Assert.assertNotNull(Expr_480_list);
		Assert.assertEquals(1, Expr_480_list.size());
		//480
		final InclusiveOrExpression InclusiveOrExpression_481_Var
		 = (InclusiveOrExpression)Expr_480_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_481_Var
		);
		final EList<? extends EObject> Expr_481_list = InclusiveOrExpression_481_Var
		.getExpr();
		Assert.assertNotNull(Expr_481_list);
		Assert.assertEquals(1, Expr_481_list.size());
		//481
		final ExclusiveOrExpression ExclusiveOrExpression_482_Var
		 = (ExclusiveOrExpression)Expr_481_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_482_Var
		);
		final EList<? extends EObject> Expr_482_list = ExclusiveOrExpression_482_Var
		.getExpr();
		Assert.assertNotNull(Expr_482_list);
		Assert.assertEquals(1, Expr_482_list.size());
		//482
		final AndExpression AndExpression_483_Var
		 = (AndExpression)Expr_482_list.get(0);
		Assert.assertNotNull(AndExpression_483_Var
		);
		final EList<? extends EObject> Expr_483_list = AndExpression_483_Var
		.getExpr();
		Assert.assertNotNull(Expr_483_list);
		Assert.assertEquals(1, Expr_483_list.size());
		//483
		final EqualityExpression EqualityExpression_484_Var
		 = (EqualityExpression)Expr_483_list.get(0);
		Assert.assertNotNull(EqualityExpression_484_Var
		);
		final EList<? extends EObject> Expr_484_list = EqualityExpression_484_Var
		.getExpr();
		Assert.assertNotNull(Expr_484_list);
		Assert.assertEquals(1, Expr_484_list.size());
		//484
		final RelationalExpression RelationalExpression_485_Var
		 = (RelationalExpression)Expr_484_list.get(0);
		Assert.assertNotNull(RelationalExpression_485_Var
		);
		final EList<? extends EObject> Expr_485_list = RelationalExpression_485_Var
		.getExpr();
		Assert.assertNotNull(Expr_485_list);
		Assert.assertEquals(1, Expr_485_list.size());
		//485
		final ShiftExpression ShiftExpression_486_Var
		 = (ShiftExpression)Expr_485_list.get(0);
		Assert.assertNotNull(ShiftExpression_486_Var
		);
		final EList<? extends EObject> Expr_486_list = ShiftExpression_486_Var
		.getExpr();
		Assert.assertNotNull(Expr_486_list);
		Assert.assertEquals(1, Expr_486_list.size());
		//486
		final AdditiveExpression AdditiveExpression_487_Var
		 = (AdditiveExpression)Expr_486_list.get(0);
		Assert.assertNotNull(AdditiveExpression_487_Var
		);
		final EList<? extends EObject> Expr_487_list = AdditiveExpression_487_Var
		.getExpr();
		Assert.assertNotNull(Expr_487_list);
		Assert.assertEquals(1, Expr_487_list.size());
		//487
		final MultiplicativeExpression MultiplicativeExpression_488_Var
		 = (MultiplicativeExpression)Expr_487_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_488_Var
		);
		final EList<? extends EObject> Expr_488_list = MultiplicativeExpression_488_Var
		.getExpr();
		Assert.assertNotNull(Expr_488_list);
		Assert.assertEquals(1, Expr_488_list.size());
		//488
		final CastExpression CastExpression_489_Var
		 = (CastExpression)Expr_488_list.get(0);
		Assert.assertNotNull(CastExpression_489_Var
		);
		//489
		final UnaryExpression UnaryExpression_490_Var
		 = (UnaryExpression)CastExpression_489_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_490_Var
		);
		//490
		final PostfixExpression PostfixExpression_491_Var
		 = (PostfixExpression)UnaryExpression_490_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_491_Var
		);
		final EList<? extends EObject> Expr_491_list = PostfixExpression_491_Var
		.getExpr();
		Assert.assertNotNull(Expr_491_list);
		Assert.assertEquals(1, Expr_491_list.size());
		//491
		final PrimaryExpression PrimaryExpression_492_Var
		 = (PrimaryExpression)Expr_491_list.get(0);
		Assert.assertNotNull(PrimaryExpression_492_Var
		);
		Assert.assertEquals("[\"joe.name=%s\\n\"]", PrimaryExpression_492_Var
		.getString().toString());
		//492
		final AssignmentExpression AssignmentExpression_493_Var
		 = (AssignmentExpression)Expr_476_list.get(1);
		Assert.assertNotNull(AssignmentExpression_493_Var
		);
		//493
		final ConditionalExpression ConditionalExpression_494_Var
		 = (ConditionalExpression)AssignmentExpression_493_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_494_Var
		);
		//494
		final LogicalOrExpression LogicalOrExpression_495_Var
		 = (LogicalOrExpression)ConditionalExpression_494_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_495_Var
		);
		final EList<? extends EObject> Expr_495_list = LogicalOrExpression_495_Var
		.getExpr();
		Assert.assertNotNull(Expr_495_list);
		Assert.assertEquals(1, Expr_495_list.size());
		//495
		final LogicalAndExpression LogicalAndExpression_496_Var
		 = (LogicalAndExpression)Expr_495_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_496_Var
		);
		final EList<? extends EObject> Expr_496_list = LogicalAndExpression_496_Var
		.getExpr();
		Assert.assertNotNull(Expr_496_list);
		Assert.assertEquals(1, Expr_496_list.size());
		//496
		final InclusiveOrExpression InclusiveOrExpression_497_Var
		 = (InclusiveOrExpression)Expr_496_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_497_Var
		);
		final EList<? extends EObject> Expr_497_list = InclusiveOrExpression_497_Var
		.getExpr();
		Assert.assertNotNull(Expr_497_list);
		Assert.assertEquals(1, Expr_497_list.size());
		//497
		final ExclusiveOrExpression ExclusiveOrExpression_498_Var
		 = (ExclusiveOrExpression)Expr_497_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_498_Var
		);
		final EList<? extends EObject> Expr_498_list = ExclusiveOrExpression_498_Var
		.getExpr();
		Assert.assertNotNull(Expr_498_list);
		Assert.assertEquals(1, Expr_498_list.size());
		//498
		final AndExpression AndExpression_499_Var
		 = (AndExpression)Expr_498_list.get(0);
		Assert.assertNotNull(AndExpression_499_Var
		);
		final EList<? extends EObject> Expr_499_list = AndExpression_499_Var
		.getExpr();
		Assert.assertNotNull(Expr_499_list);
		Assert.assertEquals(1, Expr_499_list.size());
		//499
		final EqualityExpression EqualityExpression_500_Var
		 = (EqualityExpression)Expr_499_list.get(0);
		Assert.assertNotNull(EqualityExpression_500_Var
		);
		final EList<? extends EObject> Expr_500_list = EqualityExpression_500_Var
		.getExpr();
		Assert.assertNotNull(Expr_500_list);
		Assert.assertEquals(1, Expr_500_list.size());
		//500
		final RelationalExpression RelationalExpression_501_Var
		 = (RelationalExpression)Expr_500_list.get(0);
		Assert.assertNotNull(RelationalExpression_501_Var
		);
		final EList<? extends EObject> Expr_501_list = RelationalExpression_501_Var
		.getExpr();
		Assert.assertNotNull(Expr_501_list);
		Assert.assertEquals(1, Expr_501_list.size());
		//501
		final ShiftExpression ShiftExpression_502_Var
		 = (ShiftExpression)Expr_501_list.get(0);
		Assert.assertNotNull(ShiftExpression_502_Var
		);
		final EList<? extends EObject> Expr_502_list = ShiftExpression_502_Var
		.getExpr();
		Assert.assertNotNull(Expr_502_list);
		Assert.assertEquals(1, Expr_502_list.size());
		//502
		final AdditiveExpression AdditiveExpression_503_Var
		 = (AdditiveExpression)Expr_502_list.get(0);
		Assert.assertNotNull(AdditiveExpression_503_Var
		);
		final EList<? extends EObject> Expr_503_list = AdditiveExpression_503_Var
		.getExpr();
		Assert.assertNotNull(Expr_503_list);
		Assert.assertEquals(1, Expr_503_list.size());
		//503
		final MultiplicativeExpression MultiplicativeExpression_504_Var
		 = (MultiplicativeExpression)Expr_503_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_504_Var
		);
		final EList<? extends EObject> Expr_504_list = MultiplicativeExpression_504_Var
		.getExpr();
		Assert.assertNotNull(Expr_504_list);
		Assert.assertEquals(1, Expr_504_list.size());
		//504
		final CastExpression CastExpression_505_Var
		 = (CastExpression)Expr_504_list.get(0);
		Assert.assertNotNull(CastExpression_505_Var
		);
		//505
		final UnaryExpression UnaryExpression_506_Var
		 = (UnaryExpression)CastExpression_505_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_506_Var
		);
		//506
		final PostfixExpression PostfixExpression_507_Var
		 = (PostfixExpression)UnaryExpression_506_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_507_Var
		);
		final EList<? extends EObject> Expr_507_list = PostfixExpression_507_Var
		.getExpr();
		Assert.assertNotNull(Expr_507_list);
		Assert.assertEquals(1, Expr_507_list.size());
		//507
		final PrimaryExpression PrimaryExpression_508_Var
		 = (PrimaryExpression)Expr_507_list.get(0);
		Assert.assertNotNull(PrimaryExpression_508_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_508_Var
		.getId());
		final EList<? extends EObject> Suffix_508_list = PostfixExpression_507_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_508_list);
		Assert.assertEquals(1, Suffix_508_list.size());
		//508
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_509_Var
		 = (PostfixExpressionSuffixDot)Suffix_508_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_509_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_509_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_457_Var
		.getSemi());
		//509
		final Statement Statement_510_Var
		 = (Statement)Statement_106_list.get(7);
		Assert.assertNotNull(Statement_510_Var
		);
		//510
		final ExpressionStatement ExpressionStatement_511_Var
		 = (ExpressionStatement)Statement_510_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_511_Var
		);
		//511
		final Expression Expression_512_Var
		 = (Expression)ExpressionStatement_511_Var
		.getExpression();
		Assert.assertNotNull(Expression_512_Var
		);
		final EList<? extends EObject> ExprExpr_512_list = Expression_512_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_512_list);
		Assert.assertEquals(1, ExprExpr_512_list.size());
		//512
		final AssignmentExpression AssignmentExpression_513_Var
		 = (AssignmentExpression)ExprExpr_512_list.get(0);
		Assert.assertNotNull(AssignmentExpression_513_Var
		);
		//513
		final ConditionalExpression ConditionalExpression_514_Var
		 = (ConditionalExpression)AssignmentExpression_513_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_514_Var
		);
		//514
		final LogicalOrExpression LogicalOrExpression_515_Var
		 = (LogicalOrExpression)ConditionalExpression_514_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_515_Var
		);
		final EList<? extends EObject> Expr_515_list = LogicalOrExpression_515_Var
		.getExpr();
		Assert.assertNotNull(Expr_515_list);
		Assert.assertEquals(1, Expr_515_list.size());
		//515
		final LogicalAndExpression LogicalAndExpression_516_Var
		 = (LogicalAndExpression)Expr_515_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_516_Var
		);
		final EList<? extends EObject> Expr_516_list = LogicalAndExpression_516_Var
		.getExpr();
		Assert.assertNotNull(Expr_516_list);
		Assert.assertEquals(1, Expr_516_list.size());
		//516
		final InclusiveOrExpression InclusiveOrExpression_517_Var
		 = (InclusiveOrExpression)Expr_516_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_517_Var
		);
		final EList<? extends EObject> Expr_517_list = InclusiveOrExpression_517_Var
		.getExpr();
		Assert.assertNotNull(Expr_517_list);
		Assert.assertEquals(1, Expr_517_list.size());
		//517
		final ExclusiveOrExpression ExclusiveOrExpression_518_Var
		 = (ExclusiveOrExpression)Expr_517_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_518_Var
		);
		final EList<? extends EObject> Expr_518_list = ExclusiveOrExpression_518_Var
		.getExpr();
		Assert.assertNotNull(Expr_518_list);
		Assert.assertEquals(1, Expr_518_list.size());
		//518
		final AndExpression AndExpression_519_Var
		 = (AndExpression)Expr_518_list.get(0);
		Assert.assertNotNull(AndExpression_519_Var
		);
		final EList<? extends EObject> Expr_519_list = AndExpression_519_Var
		.getExpr();
		Assert.assertNotNull(Expr_519_list);
		Assert.assertEquals(1, Expr_519_list.size());
		//519
		final EqualityExpression EqualityExpression_520_Var
		 = (EqualityExpression)Expr_519_list.get(0);
		Assert.assertNotNull(EqualityExpression_520_Var
		);
		final EList<? extends EObject> Expr_520_list = EqualityExpression_520_Var
		.getExpr();
		Assert.assertNotNull(Expr_520_list);
		Assert.assertEquals(1, Expr_520_list.size());
		//520
		final RelationalExpression RelationalExpression_521_Var
		 = (RelationalExpression)Expr_520_list.get(0);
		Assert.assertNotNull(RelationalExpression_521_Var
		);
		final EList<? extends EObject> Expr_521_list = RelationalExpression_521_Var
		.getExpr();
		Assert.assertNotNull(Expr_521_list);
		Assert.assertEquals(1, Expr_521_list.size());
		//521
		final ShiftExpression ShiftExpression_522_Var
		 = (ShiftExpression)Expr_521_list.get(0);
		Assert.assertNotNull(ShiftExpression_522_Var
		);
		final EList<? extends EObject> Expr_522_list = ShiftExpression_522_Var
		.getExpr();
		Assert.assertNotNull(Expr_522_list);
		Assert.assertEquals(1, Expr_522_list.size());
		//522
		final AdditiveExpression AdditiveExpression_523_Var
		 = (AdditiveExpression)Expr_522_list.get(0);
		Assert.assertNotNull(AdditiveExpression_523_Var
		);
		final EList<? extends EObject> Expr_523_list = AdditiveExpression_523_Var
		.getExpr();
		Assert.assertNotNull(Expr_523_list);
		Assert.assertEquals(1, Expr_523_list.size());
		//523
		final MultiplicativeExpression MultiplicativeExpression_524_Var
		 = (MultiplicativeExpression)Expr_523_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_524_Var
		);
		final EList<? extends EObject> Expr_524_list = MultiplicativeExpression_524_Var
		.getExpr();
		Assert.assertNotNull(Expr_524_list);
		Assert.assertEquals(1, Expr_524_list.size());
		//524
		final CastExpression CastExpression_525_Var
		 = (CastExpression)Expr_524_list.get(0);
		Assert.assertNotNull(CastExpression_525_Var
		);
		//525
		final UnaryExpression UnaryExpression_526_Var
		 = (UnaryExpression)CastExpression_525_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_526_Var
		);
		//526
		final PostfixExpression PostfixExpression_527_Var
		 = (PostfixExpression)UnaryExpression_526_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_527_Var
		);
		final EList<? extends EObject> Expr_527_list = PostfixExpression_527_Var
		.getExpr();
		Assert.assertNotNull(Expr_527_list);
		Assert.assertEquals(1, Expr_527_list.size());
		//527
		final PrimaryExpression PrimaryExpression_528_Var
		 = (PrimaryExpression)Expr_527_list.get(0);
		Assert.assertNotNull(PrimaryExpression_528_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_528_Var
		.getId());
		final EList<? extends EObject> Suffix_528_list = PostfixExpression_527_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_528_list);
		Assert.assertEquals(1, Suffix_528_list.size());
		//528
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_529_Var
		 = (PostfixExpressionSuffixArgument)Suffix_528_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_529_Var
		);
		//529
		final ArgumentExpressionList ArgumentExpressionList_530_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_529_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_530_Var
		);
		final EList<? extends EObject> Expr_530_list = ArgumentExpressionList_530_Var
		.getExpr();
		Assert.assertNotNull(Expr_530_list);
		Assert.assertEquals(2, Expr_530_list.size());
		//530
		final AssignmentExpression AssignmentExpression_531_Var
		 = (AssignmentExpression)Expr_530_list.get(0);
		Assert.assertNotNull(AssignmentExpression_531_Var
		);
		//531
		final ConditionalExpression ConditionalExpression_532_Var
		 = (ConditionalExpression)AssignmentExpression_531_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_532_Var
		);
		//532
		final LogicalOrExpression LogicalOrExpression_533_Var
		 = (LogicalOrExpression)ConditionalExpression_532_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_533_Var
		);
		final EList<? extends EObject> Expr_533_list = LogicalOrExpression_533_Var
		.getExpr();
		Assert.assertNotNull(Expr_533_list);
		Assert.assertEquals(1, Expr_533_list.size());
		//533
		final LogicalAndExpression LogicalAndExpression_534_Var
		 = (LogicalAndExpression)Expr_533_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_534_Var
		);
		final EList<? extends EObject> Expr_534_list = LogicalAndExpression_534_Var
		.getExpr();
		Assert.assertNotNull(Expr_534_list);
		Assert.assertEquals(1, Expr_534_list.size());
		//534
		final InclusiveOrExpression InclusiveOrExpression_535_Var
		 = (InclusiveOrExpression)Expr_534_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_535_Var
		);
		final EList<? extends EObject> Expr_535_list = InclusiveOrExpression_535_Var
		.getExpr();
		Assert.assertNotNull(Expr_535_list);
		Assert.assertEquals(1, Expr_535_list.size());
		//535
		final ExclusiveOrExpression ExclusiveOrExpression_536_Var
		 = (ExclusiveOrExpression)Expr_535_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_536_Var
		);
		final EList<? extends EObject> Expr_536_list = ExclusiveOrExpression_536_Var
		.getExpr();
		Assert.assertNotNull(Expr_536_list);
		Assert.assertEquals(1, Expr_536_list.size());
		//536
		final AndExpression AndExpression_537_Var
		 = (AndExpression)Expr_536_list.get(0);
		Assert.assertNotNull(AndExpression_537_Var
		);
		final EList<? extends EObject> Expr_537_list = AndExpression_537_Var
		.getExpr();
		Assert.assertNotNull(Expr_537_list);
		Assert.assertEquals(1, Expr_537_list.size());
		//537
		final EqualityExpression EqualityExpression_538_Var
		 = (EqualityExpression)Expr_537_list.get(0);
		Assert.assertNotNull(EqualityExpression_538_Var
		);
		final EList<? extends EObject> Expr_538_list = EqualityExpression_538_Var
		.getExpr();
		Assert.assertNotNull(Expr_538_list);
		Assert.assertEquals(1, Expr_538_list.size());
		//538
		final RelationalExpression RelationalExpression_539_Var
		 = (RelationalExpression)Expr_538_list.get(0);
		Assert.assertNotNull(RelationalExpression_539_Var
		);
		final EList<? extends EObject> Expr_539_list = RelationalExpression_539_Var
		.getExpr();
		Assert.assertNotNull(Expr_539_list);
		Assert.assertEquals(1, Expr_539_list.size());
		//539
		final ShiftExpression ShiftExpression_540_Var
		 = (ShiftExpression)Expr_539_list.get(0);
		Assert.assertNotNull(ShiftExpression_540_Var
		);
		final EList<? extends EObject> Expr_540_list = ShiftExpression_540_Var
		.getExpr();
		Assert.assertNotNull(Expr_540_list);
		Assert.assertEquals(1, Expr_540_list.size());
		//540
		final AdditiveExpression AdditiveExpression_541_Var
		 = (AdditiveExpression)Expr_540_list.get(0);
		Assert.assertNotNull(AdditiveExpression_541_Var
		);
		final EList<? extends EObject> Expr_541_list = AdditiveExpression_541_Var
		.getExpr();
		Assert.assertNotNull(Expr_541_list);
		Assert.assertEquals(1, Expr_541_list.size());
		//541
		final MultiplicativeExpression MultiplicativeExpression_542_Var
		 = (MultiplicativeExpression)Expr_541_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_542_Var
		);
		final EList<? extends EObject> Expr_542_list = MultiplicativeExpression_542_Var
		.getExpr();
		Assert.assertNotNull(Expr_542_list);
		Assert.assertEquals(1, Expr_542_list.size());
		//542
		final CastExpression CastExpression_543_Var
		 = (CastExpression)Expr_542_list.get(0);
		Assert.assertNotNull(CastExpression_543_Var
		);
		//543
		final UnaryExpression UnaryExpression_544_Var
		 = (UnaryExpression)CastExpression_543_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_544_Var
		);
		//544
		final PostfixExpression PostfixExpression_545_Var
		 = (PostfixExpression)UnaryExpression_544_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_545_Var
		);
		final EList<? extends EObject> Expr_545_list = PostfixExpression_545_Var
		.getExpr();
		Assert.assertNotNull(Expr_545_list);
		Assert.assertEquals(1, Expr_545_list.size());
		//545
		final PrimaryExpression PrimaryExpression_546_Var
		 = (PrimaryExpression)Expr_545_list.get(0);
		Assert.assertNotNull(PrimaryExpression_546_Var
		);
		Assert.assertEquals("[\"phil.id=%d\\n\"]", PrimaryExpression_546_Var
		.getString().toString());
		//546
		final AssignmentExpression AssignmentExpression_547_Var
		 = (AssignmentExpression)Expr_530_list.get(1);
		Assert.assertNotNull(AssignmentExpression_547_Var
		);
		//547
		final ConditionalExpression ConditionalExpression_548_Var
		 = (ConditionalExpression)AssignmentExpression_547_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_548_Var
		);
		//548
		final LogicalOrExpression LogicalOrExpression_549_Var
		 = (LogicalOrExpression)ConditionalExpression_548_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_549_Var
		);
		final EList<? extends EObject> Expr_549_list = LogicalOrExpression_549_Var
		.getExpr();
		Assert.assertNotNull(Expr_549_list);
		Assert.assertEquals(1, Expr_549_list.size());
		//549
		final LogicalAndExpression LogicalAndExpression_550_Var
		 = (LogicalAndExpression)Expr_549_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_550_Var
		);
		final EList<? extends EObject> Expr_550_list = LogicalAndExpression_550_Var
		.getExpr();
		Assert.assertNotNull(Expr_550_list);
		Assert.assertEquals(1, Expr_550_list.size());
		//550
		final InclusiveOrExpression InclusiveOrExpression_551_Var
		 = (InclusiveOrExpression)Expr_550_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_551_Var
		);
		final EList<? extends EObject> Expr_551_list = InclusiveOrExpression_551_Var
		.getExpr();
		Assert.assertNotNull(Expr_551_list);
		Assert.assertEquals(1, Expr_551_list.size());
		//551
		final ExclusiveOrExpression ExclusiveOrExpression_552_Var
		 = (ExclusiveOrExpression)Expr_551_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_552_Var
		);
		final EList<? extends EObject> Expr_552_list = ExclusiveOrExpression_552_Var
		.getExpr();
		Assert.assertNotNull(Expr_552_list);
		Assert.assertEquals(1, Expr_552_list.size());
		//552
		final AndExpression AndExpression_553_Var
		 = (AndExpression)Expr_552_list.get(0);
		Assert.assertNotNull(AndExpression_553_Var
		);
		final EList<? extends EObject> Expr_553_list = AndExpression_553_Var
		.getExpr();
		Assert.assertNotNull(Expr_553_list);
		Assert.assertEquals(1, Expr_553_list.size());
		//553
		final EqualityExpression EqualityExpression_554_Var
		 = (EqualityExpression)Expr_553_list.get(0);
		Assert.assertNotNull(EqualityExpression_554_Var
		);
		final EList<? extends EObject> Expr_554_list = EqualityExpression_554_Var
		.getExpr();
		Assert.assertNotNull(Expr_554_list);
		Assert.assertEquals(1, Expr_554_list.size());
		//554
		final RelationalExpression RelationalExpression_555_Var
		 = (RelationalExpression)Expr_554_list.get(0);
		Assert.assertNotNull(RelationalExpression_555_Var
		);
		final EList<? extends EObject> Expr_555_list = RelationalExpression_555_Var
		.getExpr();
		Assert.assertNotNull(Expr_555_list);
		Assert.assertEquals(1, Expr_555_list.size());
		//555
		final ShiftExpression ShiftExpression_556_Var
		 = (ShiftExpression)Expr_555_list.get(0);
		Assert.assertNotNull(ShiftExpression_556_Var
		);
		final EList<? extends EObject> Expr_556_list = ShiftExpression_556_Var
		.getExpr();
		Assert.assertNotNull(Expr_556_list);
		Assert.assertEquals(1, Expr_556_list.size());
		//556
		final AdditiveExpression AdditiveExpression_557_Var
		 = (AdditiveExpression)Expr_556_list.get(0);
		Assert.assertNotNull(AdditiveExpression_557_Var
		);
		final EList<? extends EObject> Expr_557_list = AdditiveExpression_557_Var
		.getExpr();
		Assert.assertNotNull(Expr_557_list);
		Assert.assertEquals(1, Expr_557_list.size());
		//557
		final MultiplicativeExpression MultiplicativeExpression_558_Var
		 = (MultiplicativeExpression)Expr_557_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_558_Var
		);
		final EList<? extends EObject> Expr_558_list = MultiplicativeExpression_558_Var
		.getExpr();
		Assert.assertNotNull(Expr_558_list);
		Assert.assertEquals(1, Expr_558_list.size());
		//558
		final CastExpression CastExpression_559_Var
		 = (CastExpression)Expr_558_list.get(0);
		Assert.assertNotNull(CastExpression_559_Var
		);
		//559
		final UnaryExpression UnaryExpression_560_Var
		 = (UnaryExpression)CastExpression_559_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_560_Var
		);
		//560
		final PostfixExpression PostfixExpression_561_Var
		 = (PostfixExpression)UnaryExpression_560_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_561_Var
		);
		final EList<? extends EObject> Expr_561_list = PostfixExpression_561_Var
		.getExpr();
		Assert.assertNotNull(Expr_561_list);
		Assert.assertEquals(1, Expr_561_list.size());
		//561
		final PrimaryExpression PrimaryExpression_562_Var
		 = (PrimaryExpression)Expr_561_list.get(0);
		Assert.assertNotNull(PrimaryExpression_562_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_562_Var
		.getId());
		final EList<? extends EObject> Suffix_562_list = PostfixExpression_561_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_562_list);
		Assert.assertEquals(1, Suffix_562_list.size());
		//562
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_563_Var
		 = (PostfixExpressionSuffixDot)Suffix_562_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_563_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_563_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_511_Var
		.getSemi());
		//563
		final Statement Statement_564_Var
		 = (Statement)Statement_106_list.get(8);
		Assert.assertNotNull(Statement_564_Var
		);
		//564
		final ExpressionStatement ExpressionStatement_565_Var
		 = (ExpressionStatement)Statement_564_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_565_Var
		);
		//565
		final Expression Expression_566_Var
		 = (Expression)ExpressionStatement_565_Var
		.getExpression();
		Assert.assertNotNull(Expression_566_Var
		);
		final EList<? extends EObject> ExprExpr_566_list = Expression_566_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_566_list);
		Assert.assertEquals(1, ExprExpr_566_list.size());
		//566
		final AssignmentExpression AssignmentExpression_567_Var
		 = (AssignmentExpression)ExprExpr_566_list.get(0);
		Assert.assertNotNull(AssignmentExpression_567_Var
		);
		//567
		final ConditionalExpression ConditionalExpression_568_Var
		 = (ConditionalExpression)AssignmentExpression_567_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_568_Var
		);
		//568
		final LogicalOrExpression LogicalOrExpression_569_Var
		 = (LogicalOrExpression)ConditionalExpression_568_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_569_Var
		);
		final EList<? extends EObject> Expr_569_list = LogicalOrExpression_569_Var
		.getExpr();
		Assert.assertNotNull(Expr_569_list);
		Assert.assertEquals(1, Expr_569_list.size());
		//569
		final LogicalAndExpression LogicalAndExpression_570_Var
		 = (LogicalAndExpression)Expr_569_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_570_Var
		);
		final EList<? extends EObject> Expr_570_list = LogicalAndExpression_570_Var
		.getExpr();
		Assert.assertNotNull(Expr_570_list);
		Assert.assertEquals(1, Expr_570_list.size());
		//570
		final InclusiveOrExpression InclusiveOrExpression_571_Var
		 = (InclusiveOrExpression)Expr_570_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_571_Var
		);
		final EList<? extends EObject> Expr_571_list = InclusiveOrExpression_571_Var
		.getExpr();
		Assert.assertNotNull(Expr_571_list);
		Assert.assertEquals(1, Expr_571_list.size());
		//571
		final ExclusiveOrExpression ExclusiveOrExpression_572_Var
		 = (ExclusiveOrExpression)Expr_571_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_572_Var
		);
		final EList<? extends EObject> Expr_572_list = ExclusiveOrExpression_572_Var
		.getExpr();
		Assert.assertNotNull(Expr_572_list);
		Assert.assertEquals(1, Expr_572_list.size());
		//572
		final AndExpression AndExpression_573_Var
		 = (AndExpression)Expr_572_list.get(0);
		Assert.assertNotNull(AndExpression_573_Var
		);
		final EList<? extends EObject> Expr_573_list = AndExpression_573_Var
		.getExpr();
		Assert.assertNotNull(Expr_573_list);
		Assert.assertEquals(1, Expr_573_list.size());
		//573
		final EqualityExpression EqualityExpression_574_Var
		 = (EqualityExpression)Expr_573_list.get(0);
		Assert.assertNotNull(EqualityExpression_574_Var
		);
		final EList<? extends EObject> Expr_574_list = EqualityExpression_574_Var
		.getExpr();
		Assert.assertNotNull(Expr_574_list);
		Assert.assertEquals(1, Expr_574_list.size());
		//574
		final RelationalExpression RelationalExpression_575_Var
		 = (RelationalExpression)Expr_574_list.get(0);
		Assert.assertNotNull(RelationalExpression_575_Var
		);
		final EList<? extends EObject> Expr_575_list = RelationalExpression_575_Var
		.getExpr();
		Assert.assertNotNull(Expr_575_list);
		Assert.assertEquals(1, Expr_575_list.size());
		//575
		final ShiftExpression ShiftExpression_576_Var
		 = (ShiftExpression)Expr_575_list.get(0);
		Assert.assertNotNull(ShiftExpression_576_Var
		);
		final EList<? extends EObject> Expr_576_list = ShiftExpression_576_Var
		.getExpr();
		Assert.assertNotNull(Expr_576_list);
		Assert.assertEquals(1, Expr_576_list.size());
		//576
		final AdditiveExpression AdditiveExpression_577_Var
		 = (AdditiveExpression)Expr_576_list.get(0);
		Assert.assertNotNull(AdditiveExpression_577_Var
		);
		final EList<? extends EObject> Expr_577_list = AdditiveExpression_577_Var
		.getExpr();
		Assert.assertNotNull(Expr_577_list);
		Assert.assertEquals(1, Expr_577_list.size());
		//577
		final MultiplicativeExpression MultiplicativeExpression_578_Var
		 = (MultiplicativeExpression)Expr_577_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_578_Var
		);
		final EList<? extends EObject> Expr_578_list = MultiplicativeExpression_578_Var
		.getExpr();
		Assert.assertNotNull(Expr_578_list);
		Assert.assertEquals(1, Expr_578_list.size());
		//578
		final CastExpression CastExpression_579_Var
		 = (CastExpression)Expr_578_list.get(0);
		Assert.assertNotNull(CastExpression_579_Var
		);
		//579
		final UnaryExpression UnaryExpression_580_Var
		 = (UnaryExpression)CastExpression_579_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_580_Var
		);
		//580
		final PostfixExpression PostfixExpression_581_Var
		 = (PostfixExpression)UnaryExpression_580_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_581_Var
		);
		final EList<? extends EObject> Expr_581_list = PostfixExpression_581_Var
		.getExpr();
		Assert.assertNotNull(Expr_581_list);
		Assert.assertEquals(1, Expr_581_list.size());
		//581
		final PrimaryExpression PrimaryExpression_582_Var
		 = (PrimaryExpression)Expr_581_list.get(0);
		Assert.assertNotNull(PrimaryExpression_582_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_582_Var
		.getId());
		final EList<? extends EObject> Suffix_582_list = PostfixExpression_581_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_582_list);
		Assert.assertEquals(1, Suffix_582_list.size());
		//582
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_583_Var
		 = (PostfixExpressionSuffixArgument)Suffix_582_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_583_Var
		);
		//583
		final ArgumentExpressionList ArgumentExpressionList_584_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_583_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_584_Var
		);
		final EList<? extends EObject> Expr_584_list = ArgumentExpressionList_584_Var
		.getExpr();
		Assert.assertNotNull(Expr_584_list);
		Assert.assertEquals(2, Expr_584_list.size());
		//584
		final AssignmentExpression AssignmentExpression_585_Var
		 = (AssignmentExpression)Expr_584_list.get(0);
		Assert.assertNotNull(AssignmentExpression_585_Var
		);
		//585
		final ConditionalExpression ConditionalExpression_586_Var
		 = (ConditionalExpression)AssignmentExpression_585_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_586_Var
		);
		//586
		final LogicalOrExpression LogicalOrExpression_587_Var
		 = (LogicalOrExpression)ConditionalExpression_586_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_587_Var
		);
		final EList<? extends EObject> Expr_587_list = LogicalOrExpression_587_Var
		.getExpr();
		Assert.assertNotNull(Expr_587_list);
		Assert.assertEquals(1, Expr_587_list.size());
		//587
		final LogicalAndExpression LogicalAndExpression_588_Var
		 = (LogicalAndExpression)Expr_587_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_588_Var
		);
		final EList<? extends EObject> Expr_588_list = LogicalAndExpression_588_Var
		.getExpr();
		Assert.assertNotNull(Expr_588_list);
		Assert.assertEquals(1, Expr_588_list.size());
		//588
		final InclusiveOrExpression InclusiveOrExpression_589_Var
		 = (InclusiveOrExpression)Expr_588_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_589_Var
		);
		final EList<? extends EObject> Expr_589_list = InclusiveOrExpression_589_Var
		.getExpr();
		Assert.assertNotNull(Expr_589_list);
		Assert.assertEquals(1, Expr_589_list.size());
		//589
		final ExclusiveOrExpression ExclusiveOrExpression_590_Var
		 = (ExclusiveOrExpression)Expr_589_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_590_Var
		);
		final EList<? extends EObject> Expr_590_list = ExclusiveOrExpression_590_Var
		.getExpr();
		Assert.assertNotNull(Expr_590_list);
		Assert.assertEquals(1, Expr_590_list.size());
		//590
		final AndExpression AndExpression_591_Var
		 = (AndExpression)Expr_590_list.get(0);
		Assert.assertNotNull(AndExpression_591_Var
		);
		final EList<? extends EObject> Expr_591_list = AndExpression_591_Var
		.getExpr();
		Assert.assertNotNull(Expr_591_list);
		Assert.assertEquals(1, Expr_591_list.size());
		//591
		final EqualityExpression EqualityExpression_592_Var
		 = (EqualityExpression)Expr_591_list.get(0);
		Assert.assertNotNull(EqualityExpression_592_Var
		);
		final EList<? extends EObject> Expr_592_list = EqualityExpression_592_Var
		.getExpr();
		Assert.assertNotNull(Expr_592_list);
		Assert.assertEquals(1, Expr_592_list.size());
		//592
		final RelationalExpression RelationalExpression_593_Var
		 = (RelationalExpression)Expr_592_list.get(0);
		Assert.assertNotNull(RelationalExpression_593_Var
		);
		final EList<? extends EObject> Expr_593_list = RelationalExpression_593_Var
		.getExpr();
		Assert.assertNotNull(Expr_593_list);
		Assert.assertEquals(1, Expr_593_list.size());
		//593
		final ShiftExpression ShiftExpression_594_Var
		 = (ShiftExpression)Expr_593_list.get(0);
		Assert.assertNotNull(ShiftExpression_594_Var
		);
		final EList<? extends EObject> Expr_594_list = ShiftExpression_594_Var
		.getExpr();
		Assert.assertNotNull(Expr_594_list);
		Assert.assertEquals(1, Expr_594_list.size());
		//594
		final AdditiveExpression AdditiveExpression_595_Var
		 = (AdditiveExpression)Expr_594_list.get(0);
		Assert.assertNotNull(AdditiveExpression_595_Var
		);
		final EList<? extends EObject> Expr_595_list = AdditiveExpression_595_Var
		.getExpr();
		Assert.assertNotNull(Expr_595_list);
		Assert.assertEquals(1, Expr_595_list.size());
		//595
		final MultiplicativeExpression MultiplicativeExpression_596_Var
		 = (MultiplicativeExpression)Expr_595_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_596_Var
		);
		final EList<? extends EObject> Expr_596_list = MultiplicativeExpression_596_Var
		.getExpr();
		Assert.assertNotNull(Expr_596_list);
		Assert.assertEquals(1, Expr_596_list.size());
		//596
		final CastExpression CastExpression_597_Var
		 = (CastExpression)Expr_596_list.get(0);
		Assert.assertNotNull(CastExpression_597_Var
		);
		//597
		final UnaryExpression UnaryExpression_598_Var
		 = (UnaryExpression)CastExpression_597_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_598_Var
		);
		//598
		final PostfixExpression PostfixExpression_599_Var
		 = (PostfixExpression)UnaryExpression_598_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_599_Var
		);
		final EList<? extends EObject> Expr_599_list = PostfixExpression_599_Var
		.getExpr();
		Assert.assertNotNull(Expr_599_list);
		Assert.assertEquals(1, Expr_599_list.size());
		//599
		final PrimaryExpression PrimaryExpression_600_Var
		 = (PrimaryExpression)Expr_599_list.get(0);
		Assert.assertNotNull(PrimaryExpression_600_Var
		);
		Assert.assertEquals("[\"phil.name=%s\\n\"]", PrimaryExpression_600_Var
		.getString().toString());
		//600
		final AssignmentExpression AssignmentExpression_601_Var
		 = (AssignmentExpression)Expr_584_list.get(1);
		Assert.assertNotNull(AssignmentExpression_601_Var
		);
		//601
		final ConditionalExpression ConditionalExpression_602_Var
		 = (ConditionalExpression)AssignmentExpression_601_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_602_Var
		);
		//602
		final LogicalOrExpression LogicalOrExpression_603_Var
		 = (LogicalOrExpression)ConditionalExpression_602_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_603_Var
		);
		final EList<? extends EObject> Expr_603_list = LogicalOrExpression_603_Var
		.getExpr();
		Assert.assertNotNull(Expr_603_list);
		Assert.assertEquals(1, Expr_603_list.size());
		//603
		final LogicalAndExpression LogicalAndExpression_604_Var
		 = (LogicalAndExpression)Expr_603_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_604_Var
		);
		final EList<? extends EObject> Expr_604_list = LogicalAndExpression_604_Var
		.getExpr();
		Assert.assertNotNull(Expr_604_list);
		Assert.assertEquals(1, Expr_604_list.size());
		//604
		final InclusiveOrExpression InclusiveOrExpression_605_Var
		 = (InclusiveOrExpression)Expr_604_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_605_Var
		);
		final EList<? extends EObject> Expr_605_list = InclusiveOrExpression_605_Var
		.getExpr();
		Assert.assertNotNull(Expr_605_list);
		Assert.assertEquals(1, Expr_605_list.size());
		//605
		final ExclusiveOrExpression ExclusiveOrExpression_606_Var
		 = (ExclusiveOrExpression)Expr_605_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_606_Var
		);
		final EList<? extends EObject> Expr_606_list = ExclusiveOrExpression_606_Var
		.getExpr();
		Assert.assertNotNull(Expr_606_list);
		Assert.assertEquals(1, Expr_606_list.size());
		//606
		final AndExpression AndExpression_607_Var
		 = (AndExpression)Expr_606_list.get(0);
		Assert.assertNotNull(AndExpression_607_Var
		);
		final EList<? extends EObject> Expr_607_list = AndExpression_607_Var
		.getExpr();
		Assert.assertNotNull(Expr_607_list);
		Assert.assertEquals(1, Expr_607_list.size());
		//607
		final EqualityExpression EqualityExpression_608_Var
		 = (EqualityExpression)Expr_607_list.get(0);
		Assert.assertNotNull(EqualityExpression_608_Var
		);
		final EList<? extends EObject> Expr_608_list = EqualityExpression_608_Var
		.getExpr();
		Assert.assertNotNull(Expr_608_list);
		Assert.assertEquals(1, Expr_608_list.size());
		//608
		final RelationalExpression RelationalExpression_609_Var
		 = (RelationalExpression)Expr_608_list.get(0);
		Assert.assertNotNull(RelationalExpression_609_Var
		);
		final EList<? extends EObject> Expr_609_list = RelationalExpression_609_Var
		.getExpr();
		Assert.assertNotNull(Expr_609_list);
		Assert.assertEquals(1, Expr_609_list.size());
		//609
		final ShiftExpression ShiftExpression_610_Var
		 = (ShiftExpression)Expr_609_list.get(0);
		Assert.assertNotNull(ShiftExpression_610_Var
		);
		final EList<? extends EObject> Expr_610_list = ShiftExpression_610_Var
		.getExpr();
		Assert.assertNotNull(Expr_610_list);
		Assert.assertEquals(1, Expr_610_list.size());
		//610
		final AdditiveExpression AdditiveExpression_611_Var
		 = (AdditiveExpression)Expr_610_list.get(0);
		Assert.assertNotNull(AdditiveExpression_611_Var
		);
		final EList<? extends EObject> Expr_611_list = AdditiveExpression_611_Var
		.getExpr();
		Assert.assertNotNull(Expr_611_list);
		Assert.assertEquals(1, Expr_611_list.size());
		//611
		final MultiplicativeExpression MultiplicativeExpression_612_Var
		 = (MultiplicativeExpression)Expr_611_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_612_Var
		);
		final EList<? extends EObject> Expr_612_list = MultiplicativeExpression_612_Var
		.getExpr();
		Assert.assertNotNull(Expr_612_list);
		Assert.assertEquals(1, Expr_612_list.size());
		//612
		final CastExpression CastExpression_613_Var
		 = (CastExpression)Expr_612_list.get(0);
		Assert.assertNotNull(CastExpression_613_Var
		);
		//613
		final UnaryExpression UnaryExpression_614_Var
		 = (UnaryExpression)CastExpression_613_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_614_Var
		);
		//614
		final PostfixExpression PostfixExpression_615_Var
		 = (PostfixExpression)UnaryExpression_614_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_615_Var
		);
		final EList<? extends EObject> Expr_615_list = PostfixExpression_615_Var
		.getExpr();
		Assert.assertNotNull(Expr_615_list);
		Assert.assertEquals(1, Expr_615_list.size());
		//615
		final PrimaryExpression PrimaryExpression_616_Var
		 = (PrimaryExpression)Expr_615_list.get(0);
		Assert.assertNotNull(PrimaryExpression_616_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_616_Var
		.getId());
		final EList<? extends EObject> Suffix_616_list = PostfixExpression_615_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_616_list);
		Assert.assertEquals(1, Suffix_616_list.size());
		//616
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_617_Var
		 = (PostfixExpressionSuffixDot)Suffix_616_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_617_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_617_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_565_Var
		.getSemi());
		//617
		final Statement Statement_618_Var
		 = (Statement)Statement_106_list.get(9);
		Assert.assertNotNull(Statement_618_Var
		);
		//618
		final JumpStatement JumpStatement_619_Var
		 = (JumpStatement)Statement_618_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_619_Var
		);
		//619
		final Expression Expression_620_Var
		 = (Expression)JumpStatement_619_Var
		.getExpr();
		Assert.assertNotNull(Expression_620_Var
		);
		final EList<? extends EObject> ExprExpr_620_list = Expression_620_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_620_list);
		Assert.assertEquals(1, ExprExpr_620_list.size());
		//620
		final AssignmentExpression AssignmentExpression_621_Var
		 = (AssignmentExpression)ExprExpr_620_list.get(0);
		Assert.assertNotNull(AssignmentExpression_621_Var
		);
		//621
		final ConditionalExpression ConditionalExpression_622_Var
		 = (ConditionalExpression)AssignmentExpression_621_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_622_Var
		);
		//622
		final LogicalOrExpression LogicalOrExpression_623_Var
		 = (LogicalOrExpression)ConditionalExpression_622_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_623_Var
		);
		final EList<? extends EObject> Expr_623_list = LogicalOrExpression_623_Var
		.getExpr();
		Assert.assertNotNull(Expr_623_list);
		Assert.assertEquals(1, Expr_623_list.size());
		//623
		final LogicalAndExpression LogicalAndExpression_624_Var
		 = (LogicalAndExpression)Expr_623_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_624_Var
		);
		final EList<? extends EObject> Expr_624_list = LogicalAndExpression_624_Var
		.getExpr();
		Assert.assertNotNull(Expr_624_list);
		Assert.assertEquals(1, Expr_624_list.size());
		//624
		final InclusiveOrExpression InclusiveOrExpression_625_Var
		 = (InclusiveOrExpression)Expr_624_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_625_Var
		);
		final EList<? extends EObject> Expr_625_list = InclusiveOrExpression_625_Var
		.getExpr();
		Assert.assertNotNull(Expr_625_list);
		Assert.assertEquals(1, Expr_625_list.size());
		//625
		final ExclusiveOrExpression ExclusiveOrExpression_626_Var
		 = (ExclusiveOrExpression)Expr_625_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_626_Var
		);
		final EList<? extends EObject> Expr_626_list = ExclusiveOrExpression_626_Var
		.getExpr();
		Assert.assertNotNull(Expr_626_list);
		Assert.assertEquals(1, Expr_626_list.size());
		//626
		final AndExpression AndExpression_627_Var
		 = (AndExpression)Expr_626_list.get(0);
		Assert.assertNotNull(AndExpression_627_Var
		);
		final EList<? extends EObject> Expr_627_list = AndExpression_627_Var
		.getExpr();
		Assert.assertNotNull(Expr_627_list);
		Assert.assertEquals(1, Expr_627_list.size());
		//627
		final EqualityExpression EqualityExpression_628_Var
		 = (EqualityExpression)Expr_627_list.get(0);
		Assert.assertNotNull(EqualityExpression_628_Var
		);
		final EList<? extends EObject> Expr_628_list = EqualityExpression_628_Var
		.getExpr();
		Assert.assertNotNull(Expr_628_list);
		Assert.assertEquals(1, Expr_628_list.size());
		//628
		final RelationalExpression RelationalExpression_629_Var
		 = (RelationalExpression)Expr_628_list.get(0);
		Assert.assertNotNull(RelationalExpression_629_Var
		);
		final EList<? extends EObject> Expr_629_list = RelationalExpression_629_Var
		.getExpr();
		Assert.assertNotNull(Expr_629_list);
		Assert.assertEquals(1, Expr_629_list.size());
		//629
		final ShiftExpression ShiftExpression_630_Var
		 = (ShiftExpression)Expr_629_list.get(0);
		Assert.assertNotNull(ShiftExpression_630_Var
		);
		final EList<? extends EObject> Expr_630_list = ShiftExpression_630_Var
		.getExpr();
		Assert.assertNotNull(Expr_630_list);
		Assert.assertEquals(1, Expr_630_list.size());
		//630
		final AdditiveExpression AdditiveExpression_631_Var
		 = (AdditiveExpression)Expr_630_list.get(0);
		Assert.assertNotNull(AdditiveExpression_631_Var
		);
		final EList<? extends EObject> Expr_631_list = AdditiveExpression_631_Var
		.getExpr();
		Assert.assertNotNull(Expr_631_list);
		Assert.assertEquals(1, Expr_631_list.size());
		//631
		final MultiplicativeExpression MultiplicativeExpression_632_Var
		 = (MultiplicativeExpression)Expr_631_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_632_Var
		);
		final EList<? extends EObject> Expr_632_list = MultiplicativeExpression_632_Var
		.getExpr();
		Assert.assertNotNull(Expr_632_list);
		Assert.assertEquals(1, Expr_632_list.size());
		//632
		final CastExpression CastExpression_633_Var
		 = (CastExpression)Expr_632_list.get(0);
		Assert.assertNotNull(CastExpression_633_Var
		);
		//633
		final UnaryExpression UnaryExpression_634_Var
		 = (UnaryExpression)CastExpression_633_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_634_Var
		);
		//634
		final PostfixExpression PostfixExpression_635_Var
		 = (PostfixExpression)UnaryExpression_634_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_635_Var
		);
		final EList<? extends EObject> Expr_635_list = PostfixExpression_635_Var
		.getExpr();
		Assert.assertNotNull(Expr_635_list);
		Assert.assertEquals(1, Expr_635_list.size());
		//635
		final PrimaryExpression PrimaryExpression_636_Var
		 = (PrimaryExpression)Expr_635_list.get(0);
		Assert.assertNotNull(PrimaryExpression_636_Var
		);
		//636
		final Constant2 Constant2_637_Var
		 = (Constant2)PrimaryExpression_636_Var
		.getConst();
		Assert.assertNotNull(Constant2_637_Var
		);
		Assert.assertEquals("0", Constant2_637_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_619_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_619_Var
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


