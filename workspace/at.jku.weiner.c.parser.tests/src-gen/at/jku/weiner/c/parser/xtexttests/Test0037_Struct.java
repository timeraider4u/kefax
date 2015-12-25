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
		//88
		final Constant2 Constant2_89_Var
		 = (Constant2)PrimaryExpression_88_Var
		.getConst();
		Assert.assertNotNull(Constant2_89_Var
		);
		Assert.assertEquals("\"Joe Nobody\"", Constant2_89_Var
		.getStr());
		//89
		final ExternalDeclaration ExternalDeclaration_90_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_90_Var
		);
		//90
		final FunctionDefHead FunctionDefHead_91_Var
		 = (FunctionDefHead)ExternalDeclaration_90_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_91_Var
		);
		//91
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_92_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_91_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_92_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_92_list = FunctionDeclarationSpecifiers_92_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_92_list);
		Assert.assertEquals(1, DeclarationSpecifier_92_list.size());
		//92
		final TypeSpecifier TypeSpecifier_93_Var
		 = (TypeSpecifier)DeclarationSpecifier_92_list.get(0);
		Assert.assertNotNull(TypeSpecifier_93_Var
		);
		Assert.assertEquals("int", TypeSpecifier_93_Var
		.getName());
		//93
		final Declarator Declarator_94_Var
		 = (Declarator)FunctionDefHead_91_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_94_Var
		);
		//94
		final DirectDeclarator DirectDeclarator_95_Var
		 = (DirectDeclarator)Declarator_94_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_95_Var
		);
		Assert.assertEquals("main", DirectDeclarator_95_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_95_list = DirectDeclarator_95_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_95_list);
		Assert.assertEquals(1, DeclaratorSuffix_95_list.size());
		//95
		final DeclaratorSuffix DeclaratorSuffix_96_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_95_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_96_Var
		);
		//96
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_97_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_96_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_97_Var
		);
		final EList<? extends EObject> ParameterTypeList_97_list = DirectDeclaratorLastSuffix_97_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_97_list);
		Assert.assertEquals(1, ParameterTypeList_97_list.size());
		//97
		final ParameterTypeList ParameterTypeList_98_Var
		 = (ParameterTypeList)ParameterTypeList_97_list.get(0);
		Assert.assertNotNull(ParameterTypeList_98_Var
		);
		//98
		final ParameterList ParameterList_99_Var
		 = (ParameterList)ParameterTypeList_98_Var
		.getList();
		Assert.assertNotNull(ParameterList_99_Var
		);
		final EList<? extends EObject> ParameterDeclaration_99_list = ParameterList_99_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_99_list);
		Assert.assertEquals(1, ParameterDeclaration_99_list.size());
		//99
		final ParameterDeclaration ParameterDeclaration_100_Var
		 = (ParameterDeclaration)ParameterDeclaration_99_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_100_Var
		);
		//100
		final DeclarationSpecifiers DeclarationSpecifiers_101_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_100_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_101_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_101_list = DeclarationSpecifiers_101_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_101_list);
		Assert.assertEquals(1, DeclarationSpecifier_101_list.size());
		//101
		final TypeSpecifier TypeSpecifier_102_Var
		 = (TypeSpecifier)DeclarationSpecifier_101_list.get(0);
		Assert.assertNotNull(TypeSpecifier_102_Var
		);
		Assert.assertEquals("void", TypeSpecifier_102_Var
		.getName());
		//102
		final FunctionDefinition FunctionDefinition_103_Var
		 = (FunctionDefinition)ExternalDeclaration_90_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_103_Var
		);
		//103
		final BodyStatement BodyStatement_104_Var
		 = (BodyStatement)FunctionDefinition_103_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_104_Var
		);
		final EList<? extends EObject> BlockList_104_list = BodyStatement_104_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_104_list);
		Assert.assertEquals(1, BlockList_104_list.size());
		//104
		final BlockList BlockList_105_Var
		 = (BlockList)BlockList_104_list.get(0);
		Assert.assertNotNull(BlockList_105_Var
		);
		final EList<? extends EObject> Statement_105_list = BlockList_105_Var
		.getStatement();
		Assert.assertNotNull(Statement_105_list);
		Assert.assertEquals(10, Statement_105_list.size());
		//105
		final Statement Statement_106_Var
		 = (Statement)Statement_105_list.get(0);
		Assert.assertNotNull(Statement_106_Var
		);
		//106
		final ExpressionStatement ExpressionStatement_107_Var
		 = (ExpressionStatement)Statement_106_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_107_Var
		);
		//107
		final Expression Expression_108_Var
		 = (Expression)ExpressionStatement_107_Var
		.getExpression();
		Assert.assertNotNull(Expression_108_Var
		);
		final EList<? extends EObject> ExprExpr_108_list = Expression_108_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_108_list);
		Assert.assertEquals(1, ExprExpr_108_list.size());
		//108
		final AssignmentExpression AssignmentExpression_109_Var
		 = (AssignmentExpression)ExprExpr_108_list.get(0);
		Assert.assertNotNull(AssignmentExpression_109_Var
		);
		//109
		final ConditionalExpression ConditionalExpression_110_Var
		 = (ConditionalExpression)AssignmentExpression_109_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_110_Var
		);
		//110
		final LogicalOrExpression LogicalOrExpression_111_Var
		 = (LogicalOrExpression)ConditionalExpression_110_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = LogicalOrExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final LogicalAndExpression LogicalAndExpression_112_Var
		 = (LogicalAndExpression)Expr_111_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = LogicalAndExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final InclusiveOrExpression InclusiveOrExpression_113_Var
		 = (InclusiveOrExpression)Expr_112_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = InclusiveOrExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final ExclusiveOrExpression ExclusiveOrExpression_114_Var
		 = (ExclusiveOrExpression)Expr_113_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = ExclusiveOrExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final AndExpression AndExpression_115_Var
		 = (AndExpression)Expr_114_list.get(0);
		Assert.assertNotNull(AndExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = AndExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final EqualityExpression EqualityExpression_116_Var
		 = (EqualityExpression)Expr_115_list.get(0);
		Assert.assertNotNull(EqualityExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = EqualityExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final RelationalExpression RelationalExpression_117_Var
		 = (RelationalExpression)Expr_116_list.get(0);
		Assert.assertNotNull(RelationalExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = RelationalExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final ShiftExpression ShiftExpression_118_Var
		 = (ShiftExpression)Expr_117_list.get(0);
		Assert.assertNotNull(ShiftExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = ShiftExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final AdditiveExpression AdditiveExpression_119_Var
		 = (AdditiveExpression)Expr_118_list.get(0);
		Assert.assertNotNull(AdditiveExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = AdditiveExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final MultiplicativeExpression MultiplicativeExpression_120_Var
		 = (MultiplicativeExpression)Expr_119_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = MultiplicativeExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final CastExpression CastExpression_121_Var
		 = (CastExpression)Expr_120_list.get(0);
		Assert.assertNotNull(CastExpression_121_Var
		);
		//121
		final UnaryExpression UnaryExpression_122_Var
		 = (UnaryExpression)CastExpression_121_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_122_Var
		);
		//122
		final PostfixExpression PostfixExpression_123_Var
		 = (PostfixExpression)UnaryExpression_122_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = PostfixExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final PrimaryExpression PrimaryExpression_124_Var
		 = (PrimaryExpression)Expr_123_list.get(0);
		Assert.assertNotNull(PrimaryExpression_124_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_124_Var
		.getId());
		final EList<? extends EObject> Suffix_124_list = PostfixExpression_123_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_124_list);
		Assert.assertEquals(1, Suffix_124_list.size());
		//124
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_125_Var
		 = (PostfixExpressionSuffixArgument)Suffix_124_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_125_Var
		);
		//125
		final ArgumentExpressionList ArgumentExpressionList_126_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_125_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_126_Var
		);
		final EList<? extends EObject> Expr_126_list = ArgumentExpressionList_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(2, Expr_126_list.size());
		//126
		final AssignmentExpression AssignmentExpression_127_Var
		 = (AssignmentExpression)Expr_126_list.get(0);
		Assert.assertNotNull(AssignmentExpression_127_Var
		);
		//127
		final ConditionalExpression ConditionalExpression_128_Var
		 = (ConditionalExpression)AssignmentExpression_127_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_128_Var
		);
		//128
		final LogicalOrExpression LogicalOrExpression_129_Var
		 = (LogicalOrExpression)ConditionalExpression_128_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = LogicalOrExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final LogicalAndExpression LogicalAndExpression_130_Var
		 = (LogicalAndExpression)Expr_129_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = LogicalAndExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final InclusiveOrExpression InclusiveOrExpression_131_Var
		 = (InclusiveOrExpression)Expr_130_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = InclusiveOrExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final ExclusiveOrExpression ExclusiveOrExpression_132_Var
		 = (ExclusiveOrExpression)Expr_131_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = ExclusiveOrExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final AndExpression AndExpression_133_Var
		 = (AndExpression)Expr_132_list.get(0);
		Assert.assertNotNull(AndExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = AndExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final EqualityExpression EqualityExpression_134_Var
		 = (EqualityExpression)Expr_133_list.get(0);
		Assert.assertNotNull(EqualityExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = EqualityExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final RelationalExpression RelationalExpression_135_Var
		 = (RelationalExpression)Expr_134_list.get(0);
		Assert.assertNotNull(RelationalExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = RelationalExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final ShiftExpression ShiftExpression_136_Var
		 = (ShiftExpression)Expr_135_list.get(0);
		Assert.assertNotNull(ShiftExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = ShiftExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final AdditiveExpression AdditiveExpression_137_Var
		 = (AdditiveExpression)Expr_136_list.get(0);
		Assert.assertNotNull(AdditiveExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = AdditiveExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final MultiplicativeExpression MultiplicativeExpression_138_Var
		 = (MultiplicativeExpression)Expr_137_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = MultiplicativeExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final CastExpression CastExpression_139_Var
		 = (CastExpression)Expr_138_list.get(0);
		Assert.assertNotNull(CastExpression_139_Var
		);
		//139
		final UnaryExpression UnaryExpression_140_Var
		 = (UnaryExpression)CastExpression_139_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_140_Var
		);
		//140
		final PostfixExpression PostfixExpression_141_Var
		 = (PostfixExpression)UnaryExpression_140_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = PostfixExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final PrimaryExpression PrimaryExpression_142_Var
		 = (PrimaryExpression)Expr_141_list.get(0);
		Assert.assertNotNull(PrimaryExpression_142_Var
		);
		//142
		final Constant2 Constant2_143_Var
		 = (Constant2)PrimaryExpression_142_Var
		.getConst();
		Assert.assertNotNull(Constant2_143_Var
		);
		Assert.assertEquals("\"sizeof(joe.id)=%lu\\n\"", Constant2_143_Var
		.getStr());
		//143
		final AssignmentExpression AssignmentExpression_144_Var
		 = (AssignmentExpression)Expr_126_list.get(1);
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
		Assert.assertEquals(";", ExpressionStatement_107_Var
		.getSemi());
		//178
		final Statement Statement_179_Var
		 = (Statement)Statement_105_list.get(1);
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
		//215
		final Constant2 Constant2_216_Var
		 = (Constant2)PrimaryExpression_215_Var
		.getConst();
		Assert.assertNotNull(Constant2_216_Var
		);
		Assert.assertEquals("\"sizeof(joe.name)=%lu\\n\"", Constant2_216_Var
		.getStr());
		//216
		final AssignmentExpression AssignmentExpression_217_Var
		 = (AssignmentExpression)Expr_199_list.get(1);
		Assert.assertNotNull(AssignmentExpression_217_Var
		);
		//217
		final ConditionalExpression ConditionalExpression_218_Var
		 = (ConditionalExpression)AssignmentExpression_217_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_218_Var
		);
		//218
		final LogicalOrExpression LogicalOrExpression_219_Var
		 = (LogicalOrExpression)ConditionalExpression_218_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = LogicalOrExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final LogicalAndExpression LogicalAndExpression_220_Var
		 = (LogicalAndExpression)Expr_219_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = LogicalAndExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final InclusiveOrExpression InclusiveOrExpression_221_Var
		 = (InclusiveOrExpression)Expr_220_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = InclusiveOrExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final ExclusiveOrExpression ExclusiveOrExpression_222_Var
		 = (ExclusiveOrExpression)Expr_221_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = ExclusiveOrExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final AndExpression AndExpression_223_Var
		 = (AndExpression)Expr_222_list.get(0);
		Assert.assertNotNull(AndExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = AndExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final EqualityExpression EqualityExpression_224_Var
		 = (EqualityExpression)Expr_223_list.get(0);
		Assert.assertNotNull(EqualityExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = EqualityExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final RelationalExpression RelationalExpression_225_Var
		 = (RelationalExpression)Expr_224_list.get(0);
		Assert.assertNotNull(RelationalExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = RelationalExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final ShiftExpression ShiftExpression_226_Var
		 = (ShiftExpression)Expr_225_list.get(0);
		Assert.assertNotNull(ShiftExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = ShiftExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final AdditiveExpression AdditiveExpression_227_Var
		 = (AdditiveExpression)Expr_226_list.get(0);
		Assert.assertNotNull(AdditiveExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = AdditiveExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final MultiplicativeExpression MultiplicativeExpression_228_Var
		 = (MultiplicativeExpression)Expr_227_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = MultiplicativeExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final CastExpression CastExpression_229_Var
		 = (CastExpression)Expr_228_list.get(0);
		Assert.assertNotNull(CastExpression_229_Var
		);
		//229
		final UnaryExpression UnaryExpression_230_Var
		 = (UnaryExpression)CastExpression_229_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_230_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_230_Var
		.getSizeOf());
		//230
		final UnaryExpression UnaryExpression_231_Var
		 = (UnaryExpression)UnaryExpression_230_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_231_Var
		);
		//231
		final PostfixExpression PostfixExpression_232_Var
		 = (PostfixExpression)UnaryExpression_231_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = PostfixExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final PrimaryExpression PrimaryExpression_233_Var
		 = (PrimaryExpression)Expr_232_list.get(0);
		Assert.assertNotNull(PrimaryExpression_233_Var
		);
		//233
		final Expression Expression_234_Var
		 = (Expression)PrimaryExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expression_234_Var
		);
		final EList<? extends EObject> ExprExpr_234_list = Expression_234_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_234_list);
		Assert.assertEquals(1, ExprExpr_234_list.size());
		//234
		final AssignmentExpression AssignmentExpression_235_Var
		 = (AssignmentExpression)ExprExpr_234_list.get(0);
		Assert.assertNotNull(AssignmentExpression_235_Var
		);
		//235
		final ConditionalExpression ConditionalExpression_236_Var
		 = (ConditionalExpression)AssignmentExpression_235_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_236_Var
		);
		//236
		final LogicalOrExpression LogicalOrExpression_237_Var
		 = (LogicalOrExpression)ConditionalExpression_236_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = LogicalOrExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final LogicalAndExpression LogicalAndExpression_238_Var
		 = (LogicalAndExpression)Expr_237_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = LogicalAndExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final InclusiveOrExpression InclusiveOrExpression_239_Var
		 = (InclusiveOrExpression)Expr_238_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = InclusiveOrExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final ExclusiveOrExpression ExclusiveOrExpression_240_Var
		 = (ExclusiveOrExpression)Expr_239_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = ExclusiveOrExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final AndExpression AndExpression_241_Var
		 = (AndExpression)Expr_240_list.get(0);
		Assert.assertNotNull(AndExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = AndExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final EqualityExpression EqualityExpression_242_Var
		 = (EqualityExpression)Expr_241_list.get(0);
		Assert.assertNotNull(EqualityExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = EqualityExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final RelationalExpression RelationalExpression_243_Var
		 = (RelationalExpression)Expr_242_list.get(0);
		Assert.assertNotNull(RelationalExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = RelationalExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final ShiftExpression ShiftExpression_244_Var
		 = (ShiftExpression)Expr_243_list.get(0);
		Assert.assertNotNull(ShiftExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = ShiftExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final AdditiveExpression AdditiveExpression_245_Var
		 = (AdditiveExpression)Expr_244_list.get(0);
		Assert.assertNotNull(AdditiveExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = AdditiveExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final MultiplicativeExpression MultiplicativeExpression_246_Var
		 = (MultiplicativeExpression)Expr_245_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = MultiplicativeExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final CastExpression CastExpression_247_Var
		 = (CastExpression)Expr_246_list.get(0);
		Assert.assertNotNull(CastExpression_247_Var
		);
		//247
		final UnaryExpression UnaryExpression_248_Var
		 = (UnaryExpression)CastExpression_247_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_248_Var
		);
		//248
		final PostfixExpression PostfixExpression_249_Var
		 = (PostfixExpression)UnaryExpression_248_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = PostfixExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final PrimaryExpression PrimaryExpression_250_Var
		 = (PrimaryExpression)Expr_249_list.get(0);
		Assert.assertNotNull(PrimaryExpression_250_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_250_Var
		.getId());
		final EList<? extends EObject> Suffix_250_list = PostfixExpression_249_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_250_list);
		Assert.assertEquals(1, Suffix_250_list.size());
		//250
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_251_Var
		 = (PostfixExpressionSuffixDot)Suffix_250_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_251_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_251_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_180_Var
		.getSemi());
		//251
		final Statement Statement_252_Var
		 = (Statement)Statement_105_list.get(2);
		Assert.assertNotNull(Statement_252_Var
		);
		//252
		final ExpressionStatement ExpressionStatement_253_Var
		 = (ExpressionStatement)Statement_252_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_253_Var
		);
		//253
		final Expression Expression_254_Var
		 = (Expression)ExpressionStatement_253_Var
		.getExpression();
		Assert.assertNotNull(Expression_254_Var
		);
		final EList<? extends EObject> ExprExpr_254_list = Expression_254_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_254_list);
		Assert.assertEquals(1, ExprExpr_254_list.size());
		//254
		final AssignmentExpression AssignmentExpression_255_Var
		 = (AssignmentExpression)ExprExpr_254_list.get(0);
		Assert.assertNotNull(AssignmentExpression_255_Var
		);
		//255
		final ConditionalExpression ConditionalExpression_256_Var
		 = (ConditionalExpression)AssignmentExpression_255_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_256_Var
		);
		//256
		final LogicalOrExpression LogicalOrExpression_257_Var
		 = (LogicalOrExpression)ConditionalExpression_256_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = LogicalOrExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final LogicalAndExpression LogicalAndExpression_258_Var
		 = (LogicalAndExpression)Expr_257_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_258_Var
		);
		final EList<? extends EObject> Expr_258_list = LogicalAndExpression_258_Var
		.getExpr();
		Assert.assertNotNull(Expr_258_list);
		Assert.assertEquals(1, Expr_258_list.size());
		//258
		final InclusiveOrExpression InclusiveOrExpression_259_Var
		 = (InclusiveOrExpression)Expr_258_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_259_Var
		);
		final EList<? extends EObject> Expr_259_list = InclusiveOrExpression_259_Var
		.getExpr();
		Assert.assertNotNull(Expr_259_list);
		Assert.assertEquals(1, Expr_259_list.size());
		//259
		final ExclusiveOrExpression ExclusiveOrExpression_260_Var
		 = (ExclusiveOrExpression)Expr_259_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = ExclusiveOrExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final AndExpression AndExpression_261_Var
		 = (AndExpression)Expr_260_list.get(0);
		Assert.assertNotNull(AndExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = AndExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final EqualityExpression EqualityExpression_262_Var
		 = (EqualityExpression)Expr_261_list.get(0);
		Assert.assertNotNull(EqualityExpression_262_Var
		);
		final EList<? extends EObject> Expr_262_list = EqualityExpression_262_Var
		.getExpr();
		Assert.assertNotNull(Expr_262_list);
		Assert.assertEquals(1, Expr_262_list.size());
		//262
		final RelationalExpression RelationalExpression_263_Var
		 = (RelationalExpression)Expr_262_list.get(0);
		Assert.assertNotNull(RelationalExpression_263_Var
		);
		final EList<? extends EObject> Expr_263_list = RelationalExpression_263_Var
		.getExpr();
		Assert.assertNotNull(Expr_263_list);
		Assert.assertEquals(1, Expr_263_list.size());
		//263
		final ShiftExpression ShiftExpression_264_Var
		 = (ShiftExpression)Expr_263_list.get(0);
		Assert.assertNotNull(ShiftExpression_264_Var
		);
		final EList<? extends EObject> Expr_264_list = ShiftExpression_264_Var
		.getExpr();
		Assert.assertNotNull(Expr_264_list);
		Assert.assertEquals(1, Expr_264_list.size());
		//264
		final AdditiveExpression AdditiveExpression_265_Var
		 = (AdditiveExpression)Expr_264_list.get(0);
		Assert.assertNotNull(AdditiveExpression_265_Var
		);
		final EList<? extends EObject> Expr_265_list = AdditiveExpression_265_Var
		.getExpr();
		Assert.assertNotNull(Expr_265_list);
		Assert.assertEquals(1, Expr_265_list.size());
		//265
		final MultiplicativeExpression MultiplicativeExpression_266_Var
		 = (MultiplicativeExpression)Expr_265_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_266_Var
		);
		final EList<? extends EObject> Expr_266_list = MultiplicativeExpression_266_Var
		.getExpr();
		Assert.assertNotNull(Expr_266_list);
		Assert.assertEquals(1, Expr_266_list.size());
		//266
		final CastExpression CastExpression_267_Var
		 = (CastExpression)Expr_266_list.get(0);
		Assert.assertNotNull(CastExpression_267_Var
		);
		//267
		final UnaryExpression UnaryExpression_268_Var
		 = (UnaryExpression)CastExpression_267_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_268_Var
		);
		//268
		final PostfixExpression PostfixExpression_269_Var
		 = (PostfixExpression)UnaryExpression_268_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_269_Var
		);
		final EList<? extends EObject> Expr_269_list = PostfixExpression_269_Var
		.getExpr();
		Assert.assertNotNull(Expr_269_list);
		Assert.assertEquals(1, Expr_269_list.size());
		//269
		final PrimaryExpression PrimaryExpression_270_Var
		 = (PrimaryExpression)Expr_269_list.get(0);
		Assert.assertNotNull(PrimaryExpression_270_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_270_Var
		.getId());
		final EList<? extends EObject> Suffix_270_list = PostfixExpression_269_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_270_list);
		Assert.assertEquals(1, Suffix_270_list.size());
		//270
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_271_Var
		 = (PostfixExpressionSuffixArgument)Suffix_270_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_271_Var
		);
		//271
		final ArgumentExpressionList ArgumentExpressionList_272_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_271_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_272_Var
		);
		final EList<? extends EObject> Expr_272_list = ArgumentExpressionList_272_Var
		.getExpr();
		Assert.assertNotNull(Expr_272_list);
		Assert.assertEquals(2, Expr_272_list.size());
		//272
		final AssignmentExpression AssignmentExpression_273_Var
		 = (AssignmentExpression)Expr_272_list.get(0);
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
		Assert.assertEquals(1, Expr_276_list.size());
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
		final Constant2 Constant2_289_Var
		 = (Constant2)PrimaryExpression_288_Var
		.getConst();
		Assert.assertNotNull(Constant2_289_Var
		);
		Assert.assertEquals("\"sizeof(joe)=%lu\\n\"", Constant2_289_Var
		.getStr());
		//289
		final AssignmentExpression AssignmentExpression_290_Var
		 = (AssignmentExpression)Expr_272_list.get(1);
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
		Assert.assertEquals("sizeof", UnaryExpression_303_Var
		.getSizeOf());
		//303
		final UnaryExpression UnaryExpression_304_Var
		 = (UnaryExpression)UnaryExpression_303_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_304_Var
		);
		//304
		final PostfixExpression PostfixExpression_305_Var
		 = (PostfixExpression)UnaryExpression_304_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_305_Var
		);
		final EList<? extends EObject> Expr_305_list = PostfixExpression_305_Var
		.getExpr();
		Assert.assertNotNull(Expr_305_list);
		Assert.assertEquals(1, Expr_305_list.size());
		//305
		final PrimaryExpression PrimaryExpression_306_Var
		 = (PrimaryExpression)Expr_305_list.get(0);
		Assert.assertNotNull(PrimaryExpression_306_Var
		);
		//306
		final Expression Expression_307_Var
		 = (Expression)PrimaryExpression_306_Var
		.getExpr();
		Assert.assertNotNull(Expression_307_Var
		);
		final EList<? extends EObject> ExprExpr_307_list = Expression_307_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_307_list);
		Assert.assertEquals(1, ExprExpr_307_list.size());
		//307
		final AssignmentExpression AssignmentExpression_308_Var
		 = (AssignmentExpression)ExprExpr_307_list.get(0);
		Assert.assertNotNull(AssignmentExpression_308_Var
		);
		//308
		final ConditionalExpression ConditionalExpression_309_Var
		 = (ConditionalExpression)AssignmentExpression_308_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_309_Var
		);
		//309
		final LogicalOrExpression LogicalOrExpression_310_Var
		 = (LogicalOrExpression)ConditionalExpression_309_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_310_Var
		);
		final EList<? extends EObject> Expr_310_list = LogicalOrExpression_310_Var
		.getExpr();
		Assert.assertNotNull(Expr_310_list);
		Assert.assertEquals(1, Expr_310_list.size());
		//310
		final LogicalAndExpression LogicalAndExpression_311_Var
		 = (LogicalAndExpression)Expr_310_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = LogicalAndExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final InclusiveOrExpression InclusiveOrExpression_312_Var
		 = (InclusiveOrExpression)Expr_311_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = InclusiveOrExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final ExclusiveOrExpression ExclusiveOrExpression_313_Var
		 = (ExclusiveOrExpression)Expr_312_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_313_Var
		);
		final EList<? extends EObject> Expr_313_list = ExclusiveOrExpression_313_Var
		.getExpr();
		Assert.assertNotNull(Expr_313_list);
		Assert.assertEquals(1, Expr_313_list.size());
		//313
		final AndExpression AndExpression_314_Var
		 = (AndExpression)Expr_313_list.get(0);
		Assert.assertNotNull(AndExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = AndExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final EqualityExpression EqualityExpression_315_Var
		 = (EqualityExpression)Expr_314_list.get(0);
		Assert.assertNotNull(EqualityExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = EqualityExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final RelationalExpression RelationalExpression_316_Var
		 = (RelationalExpression)Expr_315_list.get(0);
		Assert.assertNotNull(RelationalExpression_316_Var
		);
		final EList<? extends EObject> Expr_316_list = RelationalExpression_316_Var
		.getExpr();
		Assert.assertNotNull(Expr_316_list);
		Assert.assertEquals(1, Expr_316_list.size());
		//316
		final ShiftExpression ShiftExpression_317_Var
		 = (ShiftExpression)Expr_316_list.get(0);
		Assert.assertNotNull(ShiftExpression_317_Var
		);
		final EList<? extends EObject> Expr_317_list = ShiftExpression_317_Var
		.getExpr();
		Assert.assertNotNull(Expr_317_list);
		Assert.assertEquals(1, Expr_317_list.size());
		//317
		final AdditiveExpression AdditiveExpression_318_Var
		 = (AdditiveExpression)Expr_317_list.get(0);
		Assert.assertNotNull(AdditiveExpression_318_Var
		);
		final EList<? extends EObject> Expr_318_list = AdditiveExpression_318_Var
		.getExpr();
		Assert.assertNotNull(Expr_318_list);
		Assert.assertEquals(1, Expr_318_list.size());
		//318
		final MultiplicativeExpression MultiplicativeExpression_319_Var
		 = (MultiplicativeExpression)Expr_318_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_319_Var
		);
		final EList<? extends EObject> Expr_319_list = MultiplicativeExpression_319_Var
		.getExpr();
		Assert.assertNotNull(Expr_319_list);
		Assert.assertEquals(1, Expr_319_list.size());
		//319
		final CastExpression CastExpression_320_Var
		 = (CastExpression)Expr_319_list.get(0);
		Assert.assertNotNull(CastExpression_320_Var
		);
		//320
		final UnaryExpression UnaryExpression_321_Var
		 = (UnaryExpression)CastExpression_320_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_321_Var
		);
		//321
		final PostfixExpression PostfixExpression_322_Var
		 = (PostfixExpression)UnaryExpression_321_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_322_Var
		);
		final EList<? extends EObject> Expr_322_list = PostfixExpression_322_Var
		.getExpr();
		Assert.assertNotNull(Expr_322_list);
		Assert.assertEquals(1, Expr_322_list.size());
		//322
		final PrimaryExpression PrimaryExpression_323_Var
		 = (PrimaryExpression)Expr_322_list.get(0);
		Assert.assertNotNull(PrimaryExpression_323_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_323_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_253_Var
		.getSemi());
		//323
		final Statement Statement_324_Var
		 = (Statement)Statement_105_list.get(3);
		Assert.assertNotNull(Statement_324_Var
		);
		//324
		final ExpressionStatement ExpressionStatement_325_Var
		 = (ExpressionStatement)Statement_324_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_325_Var
		);
		//325
		final Expression Expression_326_Var
		 = (Expression)ExpressionStatement_325_Var
		.getExpression();
		Assert.assertNotNull(Expression_326_Var
		);
		final EList<? extends EObject> ExprExpr_326_list = Expression_326_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_326_list);
		Assert.assertEquals(1, ExprExpr_326_list.size());
		//326
		final AssignmentExpression AssignmentExpression_327_Var
		 = (AssignmentExpression)ExprExpr_326_list.get(0);
		Assert.assertNotNull(AssignmentExpression_327_Var
		);
		//327
		final UnaryExpression UnaryExpression_328_Var
		 = (UnaryExpression)AssignmentExpression_327_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_328_Var
		);
		//328
		final PostfixExpression PostfixExpression_329_Var
		 = (PostfixExpression)UnaryExpression_328_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_329_Var
		);
		final EList<? extends EObject> Expr_329_list = PostfixExpression_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final PrimaryExpression PrimaryExpression_330_Var
		 = (PrimaryExpression)Expr_329_list.get(0);
		Assert.assertNotNull(PrimaryExpression_330_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_330_Var
		.getId());
		final EList<? extends EObject> Suffix_330_list = PostfixExpression_329_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_330_list);
		Assert.assertEquals(1, Suffix_330_list.size());
		//330
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_331_Var
		 = (PostfixExpressionSuffixDot)Suffix_330_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_331_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_331_Var
		.getId());
		//331
		final AssignmentOperator AssignmentOperator_332_Var
		 = (AssignmentOperator)AssignmentExpression_327_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_332_Var
		);
		Assert.assertEquals("=", AssignmentOperator_332_Var
		.getOp());
		//332
		final AssignmentExpression AssignmentExpression_333_Var
		 = (AssignmentExpression)AssignmentExpression_327_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_333_Var
		);
		//333
		final ConditionalExpression ConditionalExpression_334_Var
		 = (ConditionalExpression)AssignmentExpression_333_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_334_Var
		);
		//334
		final LogicalOrExpression LogicalOrExpression_335_Var
		 = (LogicalOrExpression)ConditionalExpression_334_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = LogicalOrExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final LogicalAndExpression LogicalAndExpression_336_Var
		 = (LogicalAndExpression)Expr_335_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = LogicalAndExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final InclusiveOrExpression InclusiveOrExpression_337_Var
		 = (InclusiveOrExpression)Expr_336_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_337_Var
		);
		final EList<? extends EObject> Expr_337_list = InclusiveOrExpression_337_Var
		.getExpr();
		Assert.assertNotNull(Expr_337_list);
		Assert.assertEquals(1, Expr_337_list.size());
		//337
		final ExclusiveOrExpression ExclusiveOrExpression_338_Var
		 = (ExclusiveOrExpression)Expr_337_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = ExclusiveOrExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final AndExpression AndExpression_339_Var
		 = (AndExpression)Expr_338_list.get(0);
		Assert.assertNotNull(AndExpression_339_Var
		);
		final EList<? extends EObject> Expr_339_list = AndExpression_339_Var
		.getExpr();
		Assert.assertNotNull(Expr_339_list);
		Assert.assertEquals(1, Expr_339_list.size());
		//339
		final EqualityExpression EqualityExpression_340_Var
		 = (EqualityExpression)Expr_339_list.get(0);
		Assert.assertNotNull(EqualityExpression_340_Var
		);
		final EList<? extends EObject> Expr_340_list = EqualityExpression_340_Var
		.getExpr();
		Assert.assertNotNull(Expr_340_list);
		Assert.assertEquals(1, Expr_340_list.size());
		//340
		final RelationalExpression RelationalExpression_341_Var
		 = (RelationalExpression)Expr_340_list.get(0);
		Assert.assertNotNull(RelationalExpression_341_Var
		);
		final EList<? extends EObject> Expr_341_list = RelationalExpression_341_Var
		.getExpr();
		Assert.assertNotNull(Expr_341_list);
		Assert.assertEquals(1, Expr_341_list.size());
		//341
		final ShiftExpression ShiftExpression_342_Var
		 = (ShiftExpression)Expr_341_list.get(0);
		Assert.assertNotNull(ShiftExpression_342_Var
		);
		final EList<? extends EObject> Expr_342_list = ShiftExpression_342_Var
		.getExpr();
		Assert.assertNotNull(Expr_342_list);
		Assert.assertEquals(1, Expr_342_list.size());
		//342
		final AdditiveExpression AdditiveExpression_343_Var
		 = (AdditiveExpression)Expr_342_list.get(0);
		Assert.assertNotNull(AdditiveExpression_343_Var
		);
		final EList<? extends EObject> Expr_343_list = AdditiveExpression_343_Var
		.getExpr();
		Assert.assertNotNull(Expr_343_list);
		Assert.assertEquals(1, Expr_343_list.size());
		//343
		final MultiplicativeExpression MultiplicativeExpression_344_Var
		 = (MultiplicativeExpression)Expr_343_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_344_Var
		);
		final EList<? extends EObject> Expr_344_list = MultiplicativeExpression_344_Var
		.getExpr();
		Assert.assertNotNull(Expr_344_list);
		Assert.assertEquals(1, Expr_344_list.size());
		//344
		final CastExpression CastExpression_345_Var
		 = (CastExpression)Expr_344_list.get(0);
		Assert.assertNotNull(CastExpression_345_Var
		);
		//345
		final UnaryExpression UnaryExpression_346_Var
		 = (UnaryExpression)CastExpression_345_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_346_Var
		);
		//346
		final PostfixExpression PostfixExpression_347_Var
		 = (PostfixExpression)UnaryExpression_346_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_347_Var
		);
		final EList<? extends EObject> Expr_347_list = PostfixExpression_347_Var
		.getExpr();
		Assert.assertNotNull(Expr_347_list);
		Assert.assertEquals(1, Expr_347_list.size());
		//347
		final PrimaryExpression PrimaryExpression_348_Var
		 = (PrimaryExpression)Expr_347_list.get(0);
		Assert.assertNotNull(PrimaryExpression_348_Var
		);
		//348
		final Constant2 Constant2_349_Var
		 = (Constant2)PrimaryExpression_348_Var
		.getConst();
		Assert.assertNotNull(Constant2_349_Var
		);
		Assert.assertEquals("0x008", Constant2_349_Var
		.getHex());
		Assert.assertEquals(";", ExpressionStatement_325_Var
		.getSemi());
		//349
		final Statement Statement_350_Var
		 = (Statement)Statement_105_list.get(4);
		Assert.assertNotNull(Statement_350_Var
		);
		//350
		final ExpressionStatement ExpressionStatement_351_Var
		 = (ExpressionStatement)Statement_350_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_351_Var
		);
		//351
		final Expression Expression_352_Var
		 = (Expression)ExpressionStatement_351_Var
		.getExpression();
		Assert.assertNotNull(Expression_352_Var
		);
		final EList<? extends EObject> ExprExpr_352_list = Expression_352_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_352_list);
		Assert.assertEquals(1, ExprExpr_352_list.size());
		//352
		final AssignmentExpression AssignmentExpression_353_Var
		 = (AssignmentExpression)ExprExpr_352_list.get(0);
		Assert.assertNotNull(AssignmentExpression_353_Var
		);
		//353
		final ConditionalExpression ConditionalExpression_354_Var
		 = (ConditionalExpression)AssignmentExpression_353_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_354_Var
		);
		//354
		final LogicalOrExpression LogicalOrExpression_355_Var
		 = (LogicalOrExpression)ConditionalExpression_354_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_355_Var
		);
		final EList<? extends EObject> Expr_355_list = LogicalOrExpression_355_Var
		.getExpr();
		Assert.assertNotNull(Expr_355_list);
		Assert.assertEquals(1, Expr_355_list.size());
		//355
		final LogicalAndExpression LogicalAndExpression_356_Var
		 = (LogicalAndExpression)Expr_355_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_356_Var
		);
		final EList<? extends EObject> Expr_356_list = LogicalAndExpression_356_Var
		.getExpr();
		Assert.assertNotNull(Expr_356_list);
		Assert.assertEquals(1, Expr_356_list.size());
		//356
		final InclusiveOrExpression InclusiveOrExpression_357_Var
		 = (InclusiveOrExpression)Expr_356_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_357_Var
		);
		final EList<? extends EObject> Expr_357_list = InclusiveOrExpression_357_Var
		.getExpr();
		Assert.assertNotNull(Expr_357_list);
		Assert.assertEquals(1, Expr_357_list.size());
		//357
		final ExclusiveOrExpression ExclusiveOrExpression_358_Var
		 = (ExclusiveOrExpression)Expr_357_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_358_Var
		);
		final EList<? extends EObject> Expr_358_list = ExclusiveOrExpression_358_Var
		.getExpr();
		Assert.assertNotNull(Expr_358_list);
		Assert.assertEquals(1, Expr_358_list.size());
		//358
		final AndExpression AndExpression_359_Var
		 = (AndExpression)Expr_358_list.get(0);
		Assert.assertNotNull(AndExpression_359_Var
		);
		final EList<? extends EObject> Expr_359_list = AndExpression_359_Var
		.getExpr();
		Assert.assertNotNull(Expr_359_list);
		Assert.assertEquals(1, Expr_359_list.size());
		//359
		final EqualityExpression EqualityExpression_360_Var
		 = (EqualityExpression)Expr_359_list.get(0);
		Assert.assertNotNull(EqualityExpression_360_Var
		);
		final EList<? extends EObject> Expr_360_list = EqualityExpression_360_Var
		.getExpr();
		Assert.assertNotNull(Expr_360_list);
		Assert.assertEquals(1, Expr_360_list.size());
		//360
		final RelationalExpression RelationalExpression_361_Var
		 = (RelationalExpression)Expr_360_list.get(0);
		Assert.assertNotNull(RelationalExpression_361_Var
		);
		final EList<? extends EObject> Expr_361_list = RelationalExpression_361_Var
		.getExpr();
		Assert.assertNotNull(Expr_361_list);
		Assert.assertEquals(1, Expr_361_list.size());
		//361
		final ShiftExpression ShiftExpression_362_Var
		 = (ShiftExpression)Expr_361_list.get(0);
		Assert.assertNotNull(ShiftExpression_362_Var
		);
		final EList<? extends EObject> Expr_362_list = ShiftExpression_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(1, Expr_362_list.size());
		//362
		final AdditiveExpression AdditiveExpression_363_Var
		 = (AdditiveExpression)Expr_362_list.get(0);
		Assert.assertNotNull(AdditiveExpression_363_Var
		);
		final EList<? extends EObject> Expr_363_list = AdditiveExpression_363_Var
		.getExpr();
		Assert.assertNotNull(Expr_363_list);
		Assert.assertEquals(1, Expr_363_list.size());
		//363
		final MultiplicativeExpression MultiplicativeExpression_364_Var
		 = (MultiplicativeExpression)Expr_363_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_364_Var
		);
		final EList<? extends EObject> Expr_364_list = MultiplicativeExpression_364_Var
		.getExpr();
		Assert.assertNotNull(Expr_364_list);
		Assert.assertEquals(1, Expr_364_list.size());
		//364
		final CastExpression CastExpression_365_Var
		 = (CastExpression)Expr_364_list.get(0);
		Assert.assertNotNull(CastExpression_365_Var
		);
		//365
		final UnaryExpression UnaryExpression_366_Var
		 = (UnaryExpression)CastExpression_365_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_366_Var
		);
		//366
		final PostfixExpression PostfixExpression_367_Var
		 = (PostfixExpression)UnaryExpression_366_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_367_Var
		);
		final EList<? extends EObject> Expr_367_list = PostfixExpression_367_Var
		.getExpr();
		Assert.assertNotNull(Expr_367_list);
		Assert.assertEquals(1, Expr_367_list.size());
		//367
		final PrimaryExpression PrimaryExpression_368_Var
		 = (PrimaryExpression)Expr_367_list.get(0);
		Assert.assertNotNull(PrimaryExpression_368_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_368_Var
		.getId());
		final EList<? extends EObject> Suffix_368_list = PostfixExpression_367_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_368_list);
		Assert.assertEquals(1, Suffix_368_list.size());
		//368
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_369_Var
		 = (PostfixExpressionSuffixArgument)Suffix_368_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_369_Var
		);
		//369
		final ArgumentExpressionList ArgumentExpressionList_370_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_369_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_370_Var
		);
		final EList<? extends EObject> Expr_370_list = ArgumentExpressionList_370_Var
		.getExpr();
		Assert.assertNotNull(Expr_370_list);
		Assert.assertEquals(2, Expr_370_list.size());
		//370
		final AssignmentExpression AssignmentExpression_371_Var
		 = (AssignmentExpression)Expr_370_list.get(0);
		Assert.assertNotNull(AssignmentExpression_371_Var
		);
		//371
		final ConditionalExpression ConditionalExpression_372_Var
		 = (ConditionalExpression)AssignmentExpression_371_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_372_Var
		);
		//372
		final LogicalOrExpression LogicalOrExpression_373_Var
		 = (LogicalOrExpression)ConditionalExpression_372_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_373_Var
		);
		final EList<? extends EObject> Expr_373_list = LogicalOrExpression_373_Var
		.getExpr();
		Assert.assertNotNull(Expr_373_list);
		Assert.assertEquals(1, Expr_373_list.size());
		//373
		final LogicalAndExpression LogicalAndExpression_374_Var
		 = (LogicalAndExpression)Expr_373_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_374_Var
		);
		final EList<? extends EObject> Expr_374_list = LogicalAndExpression_374_Var
		.getExpr();
		Assert.assertNotNull(Expr_374_list);
		Assert.assertEquals(1, Expr_374_list.size());
		//374
		final InclusiveOrExpression InclusiveOrExpression_375_Var
		 = (InclusiveOrExpression)Expr_374_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_375_Var
		);
		final EList<? extends EObject> Expr_375_list = InclusiveOrExpression_375_Var
		.getExpr();
		Assert.assertNotNull(Expr_375_list);
		Assert.assertEquals(1, Expr_375_list.size());
		//375
		final ExclusiveOrExpression ExclusiveOrExpression_376_Var
		 = (ExclusiveOrExpression)Expr_375_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_376_Var
		);
		final EList<? extends EObject> Expr_376_list = ExclusiveOrExpression_376_Var
		.getExpr();
		Assert.assertNotNull(Expr_376_list);
		Assert.assertEquals(1, Expr_376_list.size());
		//376
		final AndExpression AndExpression_377_Var
		 = (AndExpression)Expr_376_list.get(0);
		Assert.assertNotNull(AndExpression_377_Var
		);
		final EList<? extends EObject> Expr_377_list = AndExpression_377_Var
		.getExpr();
		Assert.assertNotNull(Expr_377_list);
		Assert.assertEquals(1, Expr_377_list.size());
		//377
		final EqualityExpression EqualityExpression_378_Var
		 = (EqualityExpression)Expr_377_list.get(0);
		Assert.assertNotNull(EqualityExpression_378_Var
		);
		final EList<? extends EObject> Expr_378_list = EqualityExpression_378_Var
		.getExpr();
		Assert.assertNotNull(Expr_378_list);
		Assert.assertEquals(1, Expr_378_list.size());
		//378
		final RelationalExpression RelationalExpression_379_Var
		 = (RelationalExpression)Expr_378_list.get(0);
		Assert.assertNotNull(RelationalExpression_379_Var
		);
		final EList<? extends EObject> Expr_379_list = RelationalExpression_379_Var
		.getExpr();
		Assert.assertNotNull(Expr_379_list);
		Assert.assertEquals(1, Expr_379_list.size());
		//379
		final ShiftExpression ShiftExpression_380_Var
		 = (ShiftExpression)Expr_379_list.get(0);
		Assert.assertNotNull(ShiftExpression_380_Var
		);
		final EList<? extends EObject> Expr_380_list = ShiftExpression_380_Var
		.getExpr();
		Assert.assertNotNull(Expr_380_list);
		Assert.assertEquals(1, Expr_380_list.size());
		//380
		final AdditiveExpression AdditiveExpression_381_Var
		 = (AdditiveExpression)Expr_380_list.get(0);
		Assert.assertNotNull(AdditiveExpression_381_Var
		);
		final EList<? extends EObject> Expr_381_list = AdditiveExpression_381_Var
		.getExpr();
		Assert.assertNotNull(Expr_381_list);
		Assert.assertEquals(1, Expr_381_list.size());
		//381
		final MultiplicativeExpression MultiplicativeExpression_382_Var
		 = (MultiplicativeExpression)Expr_381_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_382_Var
		);
		final EList<? extends EObject> Expr_382_list = MultiplicativeExpression_382_Var
		.getExpr();
		Assert.assertNotNull(Expr_382_list);
		Assert.assertEquals(1, Expr_382_list.size());
		//382
		final CastExpression CastExpression_383_Var
		 = (CastExpression)Expr_382_list.get(0);
		Assert.assertNotNull(CastExpression_383_Var
		);
		//383
		final UnaryExpression UnaryExpression_384_Var
		 = (UnaryExpression)CastExpression_383_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_384_Var
		);
		//384
		final PostfixExpression PostfixExpression_385_Var
		 = (PostfixExpression)UnaryExpression_384_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_385_Var
		);
		final EList<? extends EObject> Expr_385_list = PostfixExpression_385_Var
		.getExpr();
		Assert.assertNotNull(Expr_385_list);
		Assert.assertEquals(1, Expr_385_list.size());
		//385
		final PrimaryExpression PrimaryExpression_386_Var
		 = (PrimaryExpression)Expr_385_list.get(0);
		Assert.assertNotNull(PrimaryExpression_386_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_386_Var
		.getId());
		final EList<? extends EObject> Suffix_386_list = PostfixExpression_385_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_386_list);
		Assert.assertEquals(1, Suffix_386_list.size());
		//386
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_387_Var
		 = (PostfixExpressionSuffixDot)Suffix_386_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_387_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_387_Var
		.getId());
		//387
		final AssignmentExpression AssignmentExpression_388_Var
		 = (AssignmentExpression)Expr_370_list.get(1);
		Assert.assertNotNull(AssignmentExpression_388_Var
		);
		//388
		final ConditionalExpression ConditionalExpression_389_Var
		 = (ConditionalExpression)AssignmentExpression_388_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_389_Var
		);
		//389
		final LogicalOrExpression LogicalOrExpression_390_Var
		 = (LogicalOrExpression)ConditionalExpression_389_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_390_Var
		);
		final EList<? extends EObject> Expr_390_list = LogicalOrExpression_390_Var
		.getExpr();
		Assert.assertNotNull(Expr_390_list);
		Assert.assertEquals(1, Expr_390_list.size());
		//390
		final LogicalAndExpression LogicalAndExpression_391_Var
		 = (LogicalAndExpression)Expr_390_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_391_Var
		);
		final EList<? extends EObject> Expr_391_list = LogicalAndExpression_391_Var
		.getExpr();
		Assert.assertNotNull(Expr_391_list);
		Assert.assertEquals(1, Expr_391_list.size());
		//391
		final InclusiveOrExpression InclusiveOrExpression_392_Var
		 = (InclusiveOrExpression)Expr_391_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_392_Var
		);
		final EList<? extends EObject> Expr_392_list = InclusiveOrExpression_392_Var
		.getExpr();
		Assert.assertNotNull(Expr_392_list);
		Assert.assertEquals(1, Expr_392_list.size());
		//392
		final ExclusiveOrExpression ExclusiveOrExpression_393_Var
		 = (ExclusiveOrExpression)Expr_392_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_393_Var
		);
		final EList<? extends EObject> Expr_393_list = ExclusiveOrExpression_393_Var
		.getExpr();
		Assert.assertNotNull(Expr_393_list);
		Assert.assertEquals(1, Expr_393_list.size());
		//393
		final AndExpression AndExpression_394_Var
		 = (AndExpression)Expr_393_list.get(0);
		Assert.assertNotNull(AndExpression_394_Var
		);
		final EList<? extends EObject> Expr_394_list = AndExpression_394_Var
		.getExpr();
		Assert.assertNotNull(Expr_394_list);
		Assert.assertEquals(1, Expr_394_list.size());
		//394
		final EqualityExpression EqualityExpression_395_Var
		 = (EqualityExpression)Expr_394_list.get(0);
		Assert.assertNotNull(EqualityExpression_395_Var
		);
		final EList<? extends EObject> Expr_395_list = EqualityExpression_395_Var
		.getExpr();
		Assert.assertNotNull(Expr_395_list);
		Assert.assertEquals(1, Expr_395_list.size());
		//395
		final RelationalExpression RelationalExpression_396_Var
		 = (RelationalExpression)Expr_395_list.get(0);
		Assert.assertNotNull(RelationalExpression_396_Var
		);
		final EList<? extends EObject> Expr_396_list = RelationalExpression_396_Var
		.getExpr();
		Assert.assertNotNull(Expr_396_list);
		Assert.assertEquals(1, Expr_396_list.size());
		//396
		final ShiftExpression ShiftExpression_397_Var
		 = (ShiftExpression)Expr_396_list.get(0);
		Assert.assertNotNull(ShiftExpression_397_Var
		);
		final EList<? extends EObject> Expr_397_list = ShiftExpression_397_Var
		.getExpr();
		Assert.assertNotNull(Expr_397_list);
		Assert.assertEquals(1, Expr_397_list.size());
		//397
		final AdditiveExpression AdditiveExpression_398_Var
		 = (AdditiveExpression)Expr_397_list.get(0);
		Assert.assertNotNull(AdditiveExpression_398_Var
		);
		final EList<? extends EObject> Expr_398_list = AdditiveExpression_398_Var
		.getExpr();
		Assert.assertNotNull(Expr_398_list);
		Assert.assertEquals(1, Expr_398_list.size());
		//398
		final MultiplicativeExpression MultiplicativeExpression_399_Var
		 = (MultiplicativeExpression)Expr_398_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_399_Var
		);
		final EList<? extends EObject> Expr_399_list = MultiplicativeExpression_399_Var
		.getExpr();
		Assert.assertNotNull(Expr_399_list);
		Assert.assertEquals(1, Expr_399_list.size());
		//399
		final CastExpression CastExpression_400_Var
		 = (CastExpression)Expr_399_list.get(0);
		Assert.assertNotNull(CastExpression_400_Var
		);
		//400
		final UnaryExpression UnaryExpression_401_Var
		 = (UnaryExpression)CastExpression_400_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_401_Var
		);
		//401
		final PostfixExpression PostfixExpression_402_Var
		 = (PostfixExpression)UnaryExpression_401_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_402_Var
		);
		final EList<? extends EObject> Expr_402_list = PostfixExpression_402_Var
		.getExpr();
		Assert.assertNotNull(Expr_402_list);
		Assert.assertEquals(1, Expr_402_list.size());
		//402
		final PrimaryExpression PrimaryExpression_403_Var
		 = (PrimaryExpression)Expr_402_list.get(0);
		Assert.assertNotNull(PrimaryExpression_403_Var
		);
		//403
		final Constant2 Constant2_404_Var
		 = (Constant2)PrimaryExpression_403_Var
		.getConst();
		Assert.assertNotNull(Constant2_404_Var
		);
		Assert.assertEquals("\"Phil Morrison\"", Constant2_404_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_351_Var
		.getSemi());
		//404
		final Statement Statement_405_Var
		 = (Statement)Statement_105_list.get(5);
		Assert.assertNotNull(Statement_405_Var
		);
		//405
		final ExpressionStatement ExpressionStatement_406_Var
		 = (ExpressionStatement)Statement_405_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_406_Var
		);
		//406
		final Expression Expression_407_Var
		 = (Expression)ExpressionStatement_406_Var
		.getExpression();
		Assert.assertNotNull(Expression_407_Var
		);
		final EList<? extends EObject> ExprExpr_407_list = Expression_407_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_407_list);
		Assert.assertEquals(1, ExprExpr_407_list.size());
		//407
		final AssignmentExpression AssignmentExpression_408_Var
		 = (AssignmentExpression)ExprExpr_407_list.get(0);
		Assert.assertNotNull(AssignmentExpression_408_Var
		);
		//408
		final ConditionalExpression ConditionalExpression_409_Var
		 = (ConditionalExpression)AssignmentExpression_408_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_409_Var
		);
		//409
		final LogicalOrExpression LogicalOrExpression_410_Var
		 = (LogicalOrExpression)ConditionalExpression_409_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_410_Var
		);
		final EList<? extends EObject> Expr_410_list = LogicalOrExpression_410_Var
		.getExpr();
		Assert.assertNotNull(Expr_410_list);
		Assert.assertEquals(1, Expr_410_list.size());
		//410
		final LogicalAndExpression LogicalAndExpression_411_Var
		 = (LogicalAndExpression)Expr_410_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_411_Var
		);
		final EList<? extends EObject> Expr_411_list = LogicalAndExpression_411_Var
		.getExpr();
		Assert.assertNotNull(Expr_411_list);
		Assert.assertEquals(1, Expr_411_list.size());
		//411
		final InclusiveOrExpression InclusiveOrExpression_412_Var
		 = (InclusiveOrExpression)Expr_411_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_412_Var
		);
		final EList<? extends EObject> Expr_412_list = InclusiveOrExpression_412_Var
		.getExpr();
		Assert.assertNotNull(Expr_412_list);
		Assert.assertEquals(1, Expr_412_list.size());
		//412
		final ExclusiveOrExpression ExclusiveOrExpression_413_Var
		 = (ExclusiveOrExpression)Expr_412_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_413_Var
		);
		final EList<? extends EObject> Expr_413_list = ExclusiveOrExpression_413_Var
		.getExpr();
		Assert.assertNotNull(Expr_413_list);
		Assert.assertEquals(1, Expr_413_list.size());
		//413
		final AndExpression AndExpression_414_Var
		 = (AndExpression)Expr_413_list.get(0);
		Assert.assertNotNull(AndExpression_414_Var
		);
		final EList<? extends EObject> Expr_414_list = AndExpression_414_Var
		.getExpr();
		Assert.assertNotNull(Expr_414_list);
		Assert.assertEquals(1, Expr_414_list.size());
		//414
		final EqualityExpression EqualityExpression_415_Var
		 = (EqualityExpression)Expr_414_list.get(0);
		Assert.assertNotNull(EqualityExpression_415_Var
		);
		final EList<? extends EObject> Expr_415_list = EqualityExpression_415_Var
		.getExpr();
		Assert.assertNotNull(Expr_415_list);
		Assert.assertEquals(1, Expr_415_list.size());
		//415
		final RelationalExpression RelationalExpression_416_Var
		 = (RelationalExpression)Expr_415_list.get(0);
		Assert.assertNotNull(RelationalExpression_416_Var
		);
		final EList<? extends EObject> Expr_416_list = RelationalExpression_416_Var
		.getExpr();
		Assert.assertNotNull(Expr_416_list);
		Assert.assertEquals(1, Expr_416_list.size());
		//416
		final ShiftExpression ShiftExpression_417_Var
		 = (ShiftExpression)Expr_416_list.get(0);
		Assert.assertNotNull(ShiftExpression_417_Var
		);
		final EList<? extends EObject> Expr_417_list = ShiftExpression_417_Var
		.getExpr();
		Assert.assertNotNull(Expr_417_list);
		Assert.assertEquals(1, Expr_417_list.size());
		//417
		final AdditiveExpression AdditiveExpression_418_Var
		 = (AdditiveExpression)Expr_417_list.get(0);
		Assert.assertNotNull(AdditiveExpression_418_Var
		);
		final EList<? extends EObject> Expr_418_list = AdditiveExpression_418_Var
		.getExpr();
		Assert.assertNotNull(Expr_418_list);
		Assert.assertEquals(1, Expr_418_list.size());
		//418
		final MultiplicativeExpression MultiplicativeExpression_419_Var
		 = (MultiplicativeExpression)Expr_418_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_419_Var
		);
		final EList<? extends EObject> Expr_419_list = MultiplicativeExpression_419_Var
		.getExpr();
		Assert.assertNotNull(Expr_419_list);
		Assert.assertEquals(1, Expr_419_list.size());
		//419
		final CastExpression CastExpression_420_Var
		 = (CastExpression)Expr_419_list.get(0);
		Assert.assertNotNull(CastExpression_420_Var
		);
		//420
		final UnaryExpression UnaryExpression_421_Var
		 = (UnaryExpression)CastExpression_420_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_421_Var
		);
		//421
		final PostfixExpression PostfixExpression_422_Var
		 = (PostfixExpression)UnaryExpression_421_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_422_Var
		);
		final EList<? extends EObject> Expr_422_list = PostfixExpression_422_Var
		.getExpr();
		Assert.assertNotNull(Expr_422_list);
		Assert.assertEquals(1, Expr_422_list.size());
		//422
		final PrimaryExpression PrimaryExpression_423_Var
		 = (PrimaryExpression)Expr_422_list.get(0);
		Assert.assertNotNull(PrimaryExpression_423_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_423_Var
		.getId());
		final EList<? extends EObject> Suffix_423_list = PostfixExpression_422_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_423_list);
		Assert.assertEquals(1, Suffix_423_list.size());
		//423
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_424_Var
		 = (PostfixExpressionSuffixArgument)Suffix_423_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_424_Var
		);
		//424
		final ArgumentExpressionList ArgumentExpressionList_425_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_424_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_425_Var
		);
		final EList<? extends EObject> Expr_425_list = ArgumentExpressionList_425_Var
		.getExpr();
		Assert.assertNotNull(Expr_425_list);
		Assert.assertEquals(2, Expr_425_list.size());
		//425
		final AssignmentExpression AssignmentExpression_426_Var
		 = (AssignmentExpression)Expr_425_list.get(0);
		Assert.assertNotNull(AssignmentExpression_426_Var
		);
		//426
		final ConditionalExpression ConditionalExpression_427_Var
		 = (ConditionalExpression)AssignmentExpression_426_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_427_Var
		);
		//427
		final LogicalOrExpression LogicalOrExpression_428_Var
		 = (LogicalOrExpression)ConditionalExpression_427_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_428_Var
		);
		final EList<? extends EObject> Expr_428_list = LogicalOrExpression_428_Var
		.getExpr();
		Assert.assertNotNull(Expr_428_list);
		Assert.assertEquals(1, Expr_428_list.size());
		//428
		final LogicalAndExpression LogicalAndExpression_429_Var
		 = (LogicalAndExpression)Expr_428_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_429_Var
		);
		final EList<? extends EObject> Expr_429_list = LogicalAndExpression_429_Var
		.getExpr();
		Assert.assertNotNull(Expr_429_list);
		Assert.assertEquals(1, Expr_429_list.size());
		//429
		final InclusiveOrExpression InclusiveOrExpression_430_Var
		 = (InclusiveOrExpression)Expr_429_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_430_Var
		);
		final EList<? extends EObject> Expr_430_list = InclusiveOrExpression_430_Var
		.getExpr();
		Assert.assertNotNull(Expr_430_list);
		Assert.assertEquals(1, Expr_430_list.size());
		//430
		final ExclusiveOrExpression ExclusiveOrExpression_431_Var
		 = (ExclusiveOrExpression)Expr_430_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_431_Var
		);
		final EList<? extends EObject> Expr_431_list = ExclusiveOrExpression_431_Var
		.getExpr();
		Assert.assertNotNull(Expr_431_list);
		Assert.assertEquals(1, Expr_431_list.size());
		//431
		final AndExpression AndExpression_432_Var
		 = (AndExpression)Expr_431_list.get(0);
		Assert.assertNotNull(AndExpression_432_Var
		);
		final EList<? extends EObject> Expr_432_list = AndExpression_432_Var
		.getExpr();
		Assert.assertNotNull(Expr_432_list);
		Assert.assertEquals(1, Expr_432_list.size());
		//432
		final EqualityExpression EqualityExpression_433_Var
		 = (EqualityExpression)Expr_432_list.get(0);
		Assert.assertNotNull(EqualityExpression_433_Var
		);
		final EList<? extends EObject> Expr_433_list = EqualityExpression_433_Var
		.getExpr();
		Assert.assertNotNull(Expr_433_list);
		Assert.assertEquals(1, Expr_433_list.size());
		//433
		final RelationalExpression RelationalExpression_434_Var
		 = (RelationalExpression)Expr_433_list.get(0);
		Assert.assertNotNull(RelationalExpression_434_Var
		);
		final EList<? extends EObject> Expr_434_list = RelationalExpression_434_Var
		.getExpr();
		Assert.assertNotNull(Expr_434_list);
		Assert.assertEquals(1, Expr_434_list.size());
		//434
		final ShiftExpression ShiftExpression_435_Var
		 = (ShiftExpression)Expr_434_list.get(0);
		Assert.assertNotNull(ShiftExpression_435_Var
		);
		final EList<? extends EObject> Expr_435_list = ShiftExpression_435_Var
		.getExpr();
		Assert.assertNotNull(Expr_435_list);
		Assert.assertEquals(1, Expr_435_list.size());
		//435
		final AdditiveExpression AdditiveExpression_436_Var
		 = (AdditiveExpression)Expr_435_list.get(0);
		Assert.assertNotNull(AdditiveExpression_436_Var
		);
		final EList<? extends EObject> Expr_436_list = AdditiveExpression_436_Var
		.getExpr();
		Assert.assertNotNull(Expr_436_list);
		Assert.assertEquals(1, Expr_436_list.size());
		//436
		final MultiplicativeExpression MultiplicativeExpression_437_Var
		 = (MultiplicativeExpression)Expr_436_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_437_Var
		);
		final EList<? extends EObject> Expr_437_list = MultiplicativeExpression_437_Var
		.getExpr();
		Assert.assertNotNull(Expr_437_list);
		Assert.assertEquals(1, Expr_437_list.size());
		//437
		final CastExpression CastExpression_438_Var
		 = (CastExpression)Expr_437_list.get(0);
		Assert.assertNotNull(CastExpression_438_Var
		);
		//438
		final UnaryExpression UnaryExpression_439_Var
		 = (UnaryExpression)CastExpression_438_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_439_Var
		);
		//439
		final PostfixExpression PostfixExpression_440_Var
		 = (PostfixExpression)UnaryExpression_439_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_440_Var
		);
		final EList<? extends EObject> Expr_440_list = PostfixExpression_440_Var
		.getExpr();
		Assert.assertNotNull(Expr_440_list);
		Assert.assertEquals(1, Expr_440_list.size());
		//440
		final PrimaryExpression PrimaryExpression_441_Var
		 = (PrimaryExpression)Expr_440_list.get(0);
		Assert.assertNotNull(PrimaryExpression_441_Var
		);
		//441
		final Constant2 Constant2_442_Var
		 = (Constant2)PrimaryExpression_441_Var
		.getConst();
		Assert.assertNotNull(Constant2_442_Var
		);
		Assert.assertEquals("\"joe.id=%d\\n\"", Constant2_442_Var
		.getStr());
		//442
		final AssignmentExpression AssignmentExpression_443_Var
		 = (AssignmentExpression)Expr_425_list.get(1);
		Assert.assertNotNull(AssignmentExpression_443_Var
		);
		//443
		final ConditionalExpression ConditionalExpression_444_Var
		 = (ConditionalExpression)AssignmentExpression_443_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_444_Var
		);
		//444
		final LogicalOrExpression LogicalOrExpression_445_Var
		 = (LogicalOrExpression)ConditionalExpression_444_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_445_Var
		);
		final EList<? extends EObject> Expr_445_list = LogicalOrExpression_445_Var
		.getExpr();
		Assert.assertNotNull(Expr_445_list);
		Assert.assertEquals(1, Expr_445_list.size());
		//445
		final LogicalAndExpression LogicalAndExpression_446_Var
		 = (LogicalAndExpression)Expr_445_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_446_Var
		);
		final EList<? extends EObject> Expr_446_list = LogicalAndExpression_446_Var
		.getExpr();
		Assert.assertNotNull(Expr_446_list);
		Assert.assertEquals(1, Expr_446_list.size());
		//446
		final InclusiveOrExpression InclusiveOrExpression_447_Var
		 = (InclusiveOrExpression)Expr_446_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_447_Var
		);
		final EList<? extends EObject> Expr_447_list = InclusiveOrExpression_447_Var
		.getExpr();
		Assert.assertNotNull(Expr_447_list);
		Assert.assertEquals(1, Expr_447_list.size());
		//447
		final ExclusiveOrExpression ExclusiveOrExpression_448_Var
		 = (ExclusiveOrExpression)Expr_447_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_448_Var
		);
		final EList<? extends EObject> Expr_448_list = ExclusiveOrExpression_448_Var
		.getExpr();
		Assert.assertNotNull(Expr_448_list);
		Assert.assertEquals(1, Expr_448_list.size());
		//448
		final AndExpression AndExpression_449_Var
		 = (AndExpression)Expr_448_list.get(0);
		Assert.assertNotNull(AndExpression_449_Var
		);
		final EList<? extends EObject> Expr_449_list = AndExpression_449_Var
		.getExpr();
		Assert.assertNotNull(Expr_449_list);
		Assert.assertEquals(1, Expr_449_list.size());
		//449
		final EqualityExpression EqualityExpression_450_Var
		 = (EqualityExpression)Expr_449_list.get(0);
		Assert.assertNotNull(EqualityExpression_450_Var
		);
		final EList<? extends EObject> Expr_450_list = EqualityExpression_450_Var
		.getExpr();
		Assert.assertNotNull(Expr_450_list);
		Assert.assertEquals(1, Expr_450_list.size());
		//450
		final RelationalExpression RelationalExpression_451_Var
		 = (RelationalExpression)Expr_450_list.get(0);
		Assert.assertNotNull(RelationalExpression_451_Var
		);
		final EList<? extends EObject> Expr_451_list = RelationalExpression_451_Var
		.getExpr();
		Assert.assertNotNull(Expr_451_list);
		Assert.assertEquals(1, Expr_451_list.size());
		//451
		final ShiftExpression ShiftExpression_452_Var
		 = (ShiftExpression)Expr_451_list.get(0);
		Assert.assertNotNull(ShiftExpression_452_Var
		);
		final EList<? extends EObject> Expr_452_list = ShiftExpression_452_Var
		.getExpr();
		Assert.assertNotNull(Expr_452_list);
		Assert.assertEquals(1, Expr_452_list.size());
		//452
		final AdditiveExpression AdditiveExpression_453_Var
		 = (AdditiveExpression)Expr_452_list.get(0);
		Assert.assertNotNull(AdditiveExpression_453_Var
		);
		final EList<? extends EObject> Expr_453_list = AdditiveExpression_453_Var
		.getExpr();
		Assert.assertNotNull(Expr_453_list);
		Assert.assertEquals(1, Expr_453_list.size());
		//453
		final MultiplicativeExpression MultiplicativeExpression_454_Var
		 = (MultiplicativeExpression)Expr_453_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_454_Var
		);
		final EList<? extends EObject> Expr_454_list = MultiplicativeExpression_454_Var
		.getExpr();
		Assert.assertNotNull(Expr_454_list);
		Assert.assertEquals(1, Expr_454_list.size());
		//454
		final CastExpression CastExpression_455_Var
		 = (CastExpression)Expr_454_list.get(0);
		Assert.assertNotNull(CastExpression_455_Var
		);
		//455
		final UnaryExpression UnaryExpression_456_Var
		 = (UnaryExpression)CastExpression_455_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_456_Var
		);
		//456
		final PostfixExpression PostfixExpression_457_Var
		 = (PostfixExpression)UnaryExpression_456_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_457_Var
		);
		final EList<? extends EObject> Expr_457_list = PostfixExpression_457_Var
		.getExpr();
		Assert.assertNotNull(Expr_457_list);
		Assert.assertEquals(1, Expr_457_list.size());
		//457
		final PrimaryExpression PrimaryExpression_458_Var
		 = (PrimaryExpression)Expr_457_list.get(0);
		Assert.assertNotNull(PrimaryExpression_458_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_458_Var
		.getId());
		final EList<? extends EObject> Suffix_458_list = PostfixExpression_457_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_458_list);
		Assert.assertEquals(1, Suffix_458_list.size());
		//458
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_459_Var
		 = (PostfixExpressionSuffixDot)Suffix_458_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_459_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_459_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_406_Var
		.getSemi());
		//459
		final Statement Statement_460_Var
		 = (Statement)Statement_105_list.get(6);
		Assert.assertNotNull(Statement_460_Var
		);
		//460
		final ExpressionStatement ExpressionStatement_461_Var
		 = (ExpressionStatement)Statement_460_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_461_Var
		);
		//461
		final Expression Expression_462_Var
		 = (Expression)ExpressionStatement_461_Var
		.getExpression();
		Assert.assertNotNull(Expression_462_Var
		);
		final EList<? extends EObject> ExprExpr_462_list = Expression_462_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_462_list);
		Assert.assertEquals(1, ExprExpr_462_list.size());
		//462
		final AssignmentExpression AssignmentExpression_463_Var
		 = (AssignmentExpression)ExprExpr_462_list.get(0);
		Assert.assertNotNull(AssignmentExpression_463_Var
		);
		//463
		final ConditionalExpression ConditionalExpression_464_Var
		 = (ConditionalExpression)AssignmentExpression_463_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_464_Var
		);
		//464
		final LogicalOrExpression LogicalOrExpression_465_Var
		 = (LogicalOrExpression)ConditionalExpression_464_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_465_Var
		);
		final EList<? extends EObject> Expr_465_list = LogicalOrExpression_465_Var
		.getExpr();
		Assert.assertNotNull(Expr_465_list);
		Assert.assertEquals(1, Expr_465_list.size());
		//465
		final LogicalAndExpression LogicalAndExpression_466_Var
		 = (LogicalAndExpression)Expr_465_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_466_Var
		);
		final EList<? extends EObject> Expr_466_list = LogicalAndExpression_466_Var
		.getExpr();
		Assert.assertNotNull(Expr_466_list);
		Assert.assertEquals(1, Expr_466_list.size());
		//466
		final InclusiveOrExpression InclusiveOrExpression_467_Var
		 = (InclusiveOrExpression)Expr_466_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_467_Var
		);
		final EList<? extends EObject> Expr_467_list = InclusiveOrExpression_467_Var
		.getExpr();
		Assert.assertNotNull(Expr_467_list);
		Assert.assertEquals(1, Expr_467_list.size());
		//467
		final ExclusiveOrExpression ExclusiveOrExpression_468_Var
		 = (ExclusiveOrExpression)Expr_467_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_468_Var
		);
		final EList<? extends EObject> Expr_468_list = ExclusiveOrExpression_468_Var
		.getExpr();
		Assert.assertNotNull(Expr_468_list);
		Assert.assertEquals(1, Expr_468_list.size());
		//468
		final AndExpression AndExpression_469_Var
		 = (AndExpression)Expr_468_list.get(0);
		Assert.assertNotNull(AndExpression_469_Var
		);
		final EList<? extends EObject> Expr_469_list = AndExpression_469_Var
		.getExpr();
		Assert.assertNotNull(Expr_469_list);
		Assert.assertEquals(1, Expr_469_list.size());
		//469
		final EqualityExpression EqualityExpression_470_Var
		 = (EqualityExpression)Expr_469_list.get(0);
		Assert.assertNotNull(EqualityExpression_470_Var
		);
		final EList<? extends EObject> Expr_470_list = EqualityExpression_470_Var
		.getExpr();
		Assert.assertNotNull(Expr_470_list);
		Assert.assertEquals(1, Expr_470_list.size());
		//470
		final RelationalExpression RelationalExpression_471_Var
		 = (RelationalExpression)Expr_470_list.get(0);
		Assert.assertNotNull(RelationalExpression_471_Var
		);
		final EList<? extends EObject> Expr_471_list = RelationalExpression_471_Var
		.getExpr();
		Assert.assertNotNull(Expr_471_list);
		Assert.assertEquals(1, Expr_471_list.size());
		//471
		final ShiftExpression ShiftExpression_472_Var
		 = (ShiftExpression)Expr_471_list.get(0);
		Assert.assertNotNull(ShiftExpression_472_Var
		);
		final EList<? extends EObject> Expr_472_list = ShiftExpression_472_Var
		.getExpr();
		Assert.assertNotNull(Expr_472_list);
		Assert.assertEquals(1, Expr_472_list.size());
		//472
		final AdditiveExpression AdditiveExpression_473_Var
		 = (AdditiveExpression)Expr_472_list.get(0);
		Assert.assertNotNull(AdditiveExpression_473_Var
		);
		final EList<? extends EObject> Expr_473_list = AdditiveExpression_473_Var
		.getExpr();
		Assert.assertNotNull(Expr_473_list);
		Assert.assertEquals(1, Expr_473_list.size());
		//473
		final MultiplicativeExpression MultiplicativeExpression_474_Var
		 = (MultiplicativeExpression)Expr_473_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_474_Var
		);
		final EList<? extends EObject> Expr_474_list = MultiplicativeExpression_474_Var
		.getExpr();
		Assert.assertNotNull(Expr_474_list);
		Assert.assertEquals(1, Expr_474_list.size());
		//474
		final CastExpression CastExpression_475_Var
		 = (CastExpression)Expr_474_list.get(0);
		Assert.assertNotNull(CastExpression_475_Var
		);
		//475
		final UnaryExpression UnaryExpression_476_Var
		 = (UnaryExpression)CastExpression_475_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_476_Var
		);
		//476
		final PostfixExpression PostfixExpression_477_Var
		 = (PostfixExpression)UnaryExpression_476_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_477_Var
		);
		final EList<? extends EObject> Expr_477_list = PostfixExpression_477_Var
		.getExpr();
		Assert.assertNotNull(Expr_477_list);
		Assert.assertEquals(1, Expr_477_list.size());
		//477
		final PrimaryExpression PrimaryExpression_478_Var
		 = (PrimaryExpression)Expr_477_list.get(0);
		Assert.assertNotNull(PrimaryExpression_478_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_478_Var
		.getId());
		final EList<? extends EObject> Suffix_478_list = PostfixExpression_477_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_478_list);
		Assert.assertEquals(1, Suffix_478_list.size());
		//478
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_479_Var
		 = (PostfixExpressionSuffixArgument)Suffix_478_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_479_Var
		);
		//479
		final ArgumentExpressionList ArgumentExpressionList_480_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_479_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_480_Var
		);
		final EList<? extends EObject> Expr_480_list = ArgumentExpressionList_480_Var
		.getExpr();
		Assert.assertNotNull(Expr_480_list);
		Assert.assertEquals(2, Expr_480_list.size());
		//480
		final AssignmentExpression AssignmentExpression_481_Var
		 = (AssignmentExpression)Expr_480_list.get(0);
		Assert.assertNotNull(AssignmentExpression_481_Var
		);
		//481
		final ConditionalExpression ConditionalExpression_482_Var
		 = (ConditionalExpression)AssignmentExpression_481_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_482_Var
		);
		//482
		final LogicalOrExpression LogicalOrExpression_483_Var
		 = (LogicalOrExpression)ConditionalExpression_482_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_483_Var
		);
		final EList<? extends EObject> Expr_483_list = LogicalOrExpression_483_Var
		.getExpr();
		Assert.assertNotNull(Expr_483_list);
		Assert.assertEquals(1, Expr_483_list.size());
		//483
		final LogicalAndExpression LogicalAndExpression_484_Var
		 = (LogicalAndExpression)Expr_483_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_484_Var
		);
		final EList<? extends EObject> Expr_484_list = LogicalAndExpression_484_Var
		.getExpr();
		Assert.assertNotNull(Expr_484_list);
		Assert.assertEquals(1, Expr_484_list.size());
		//484
		final InclusiveOrExpression InclusiveOrExpression_485_Var
		 = (InclusiveOrExpression)Expr_484_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_485_Var
		);
		final EList<? extends EObject> Expr_485_list = InclusiveOrExpression_485_Var
		.getExpr();
		Assert.assertNotNull(Expr_485_list);
		Assert.assertEquals(1, Expr_485_list.size());
		//485
		final ExclusiveOrExpression ExclusiveOrExpression_486_Var
		 = (ExclusiveOrExpression)Expr_485_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_486_Var
		);
		final EList<? extends EObject> Expr_486_list = ExclusiveOrExpression_486_Var
		.getExpr();
		Assert.assertNotNull(Expr_486_list);
		Assert.assertEquals(1, Expr_486_list.size());
		//486
		final AndExpression AndExpression_487_Var
		 = (AndExpression)Expr_486_list.get(0);
		Assert.assertNotNull(AndExpression_487_Var
		);
		final EList<? extends EObject> Expr_487_list = AndExpression_487_Var
		.getExpr();
		Assert.assertNotNull(Expr_487_list);
		Assert.assertEquals(1, Expr_487_list.size());
		//487
		final EqualityExpression EqualityExpression_488_Var
		 = (EqualityExpression)Expr_487_list.get(0);
		Assert.assertNotNull(EqualityExpression_488_Var
		);
		final EList<? extends EObject> Expr_488_list = EqualityExpression_488_Var
		.getExpr();
		Assert.assertNotNull(Expr_488_list);
		Assert.assertEquals(1, Expr_488_list.size());
		//488
		final RelationalExpression RelationalExpression_489_Var
		 = (RelationalExpression)Expr_488_list.get(0);
		Assert.assertNotNull(RelationalExpression_489_Var
		);
		final EList<? extends EObject> Expr_489_list = RelationalExpression_489_Var
		.getExpr();
		Assert.assertNotNull(Expr_489_list);
		Assert.assertEquals(1, Expr_489_list.size());
		//489
		final ShiftExpression ShiftExpression_490_Var
		 = (ShiftExpression)Expr_489_list.get(0);
		Assert.assertNotNull(ShiftExpression_490_Var
		);
		final EList<? extends EObject> Expr_490_list = ShiftExpression_490_Var
		.getExpr();
		Assert.assertNotNull(Expr_490_list);
		Assert.assertEquals(1, Expr_490_list.size());
		//490
		final AdditiveExpression AdditiveExpression_491_Var
		 = (AdditiveExpression)Expr_490_list.get(0);
		Assert.assertNotNull(AdditiveExpression_491_Var
		);
		final EList<? extends EObject> Expr_491_list = AdditiveExpression_491_Var
		.getExpr();
		Assert.assertNotNull(Expr_491_list);
		Assert.assertEquals(1, Expr_491_list.size());
		//491
		final MultiplicativeExpression MultiplicativeExpression_492_Var
		 = (MultiplicativeExpression)Expr_491_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_492_Var
		);
		final EList<? extends EObject> Expr_492_list = MultiplicativeExpression_492_Var
		.getExpr();
		Assert.assertNotNull(Expr_492_list);
		Assert.assertEquals(1, Expr_492_list.size());
		//492
		final CastExpression CastExpression_493_Var
		 = (CastExpression)Expr_492_list.get(0);
		Assert.assertNotNull(CastExpression_493_Var
		);
		//493
		final UnaryExpression UnaryExpression_494_Var
		 = (UnaryExpression)CastExpression_493_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_494_Var
		);
		//494
		final PostfixExpression PostfixExpression_495_Var
		 = (PostfixExpression)UnaryExpression_494_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_495_Var
		);
		final EList<? extends EObject> Expr_495_list = PostfixExpression_495_Var
		.getExpr();
		Assert.assertNotNull(Expr_495_list);
		Assert.assertEquals(1, Expr_495_list.size());
		//495
		final PrimaryExpression PrimaryExpression_496_Var
		 = (PrimaryExpression)Expr_495_list.get(0);
		Assert.assertNotNull(PrimaryExpression_496_Var
		);
		//496
		final Constant2 Constant2_497_Var
		 = (Constant2)PrimaryExpression_496_Var
		.getConst();
		Assert.assertNotNull(Constant2_497_Var
		);
		Assert.assertEquals("\"joe.name=%s\\n\"", Constant2_497_Var
		.getStr());
		//497
		final AssignmentExpression AssignmentExpression_498_Var
		 = (AssignmentExpression)Expr_480_list.get(1);
		Assert.assertNotNull(AssignmentExpression_498_Var
		);
		//498
		final ConditionalExpression ConditionalExpression_499_Var
		 = (ConditionalExpression)AssignmentExpression_498_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_499_Var
		);
		//499
		final LogicalOrExpression LogicalOrExpression_500_Var
		 = (LogicalOrExpression)ConditionalExpression_499_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_500_Var
		);
		final EList<? extends EObject> Expr_500_list = LogicalOrExpression_500_Var
		.getExpr();
		Assert.assertNotNull(Expr_500_list);
		Assert.assertEquals(1, Expr_500_list.size());
		//500
		final LogicalAndExpression LogicalAndExpression_501_Var
		 = (LogicalAndExpression)Expr_500_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_501_Var
		);
		final EList<? extends EObject> Expr_501_list = LogicalAndExpression_501_Var
		.getExpr();
		Assert.assertNotNull(Expr_501_list);
		Assert.assertEquals(1, Expr_501_list.size());
		//501
		final InclusiveOrExpression InclusiveOrExpression_502_Var
		 = (InclusiveOrExpression)Expr_501_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_502_Var
		);
		final EList<? extends EObject> Expr_502_list = InclusiveOrExpression_502_Var
		.getExpr();
		Assert.assertNotNull(Expr_502_list);
		Assert.assertEquals(1, Expr_502_list.size());
		//502
		final ExclusiveOrExpression ExclusiveOrExpression_503_Var
		 = (ExclusiveOrExpression)Expr_502_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_503_Var
		);
		final EList<? extends EObject> Expr_503_list = ExclusiveOrExpression_503_Var
		.getExpr();
		Assert.assertNotNull(Expr_503_list);
		Assert.assertEquals(1, Expr_503_list.size());
		//503
		final AndExpression AndExpression_504_Var
		 = (AndExpression)Expr_503_list.get(0);
		Assert.assertNotNull(AndExpression_504_Var
		);
		final EList<? extends EObject> Expr_504_list = AndExpression_504_Var
		.getExpr();
		Assert.assertNotNull(Expr_504_list);
		Assert.assertEquals(1, Expr_504_list.size());
		//504
		final EqualityExpression EqualityExpression_505_Var
		 = (EqualityExpression)Expr_504_list.get(0);
		Assert.assertNotNull(EqualityExpression_505_Var
		);
		final EList<? extends EObject> Expr_505_list = EqualityExpression_505_Var
		.getExpr();
		Assert.assertNotNull(Expr_505_list);
		Assert.assertEquals(1, Expr_505_list.size());
		//505
		final RelationalExpression RelationalExpression_506_Var
		 = (RelationalExpression)Expr_505_list.get(0);
		Assert.assertNotNull(RelationalExpression_506_Var
		);
		final EList<? extends EObject> Expr_506_list = RelationalExpression_506_Var
		.getExpr();
		Assert.assertNotNull(Expr_506_list);
		Assert.assertEquals(1, Expr_506_list.size());
		//506
		final ShiftExpression ShiftExpression_507_Var
		 = (ShiftExpression)Expr_506_list.get(0);
		Assert.assertNotNull(ShiftExpression_507_Var
		);
		final EList<? extends EObject> Expr_507_list = ShiftExpression_507_Var
		.getExpr();
		Assert.assertNotNull(Expr_507_list);
		Assert.assertEquals(1, Expr_507_list.size());
		//507
		final AdditiveExpression AdditiveExpression_508_Var
		 = (AdditiveExpression)Expr_507_list.get(0);
		Assert.assertNotNull(AdditiveExpression_508_Var
		);
		final EList<? extends EObject> Expr_508_list = AdditiveExpression_508_Var
		.getExpr();
		Assert.assertNotNull(Expr_508_list);
		Assert.assertEquals(1, Expr_508_list.size());
		//508
		final MultiplicativeExpression MultiplicativeExpression_509_Var
		 = (MultiplicativeExpression)Expr_508_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_509_Var
		);
		final EList<? extends EObject> Expr_509_list = MultiplicativeExpression_509_Var
		.getExpr();
		Assert.assertNotNull(Expr_509_list);
		Assert.assertEquals(1, Expr_509_list.size());
		//509
		final CastExpression CastExpression_510_Var
		 = (CastExpression)Expr_509_list.get(0);
		Assert.assertNotNull(CastExpression_510_Var
		);
		//510
		final UnaryExpression UnaryExpression_511_Var
		 = (UnaryExpression)CastExpression_510_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_511_Var
		);
		//511
		final PostfixExpression PostfixExpression_512_Var
		 = (PostfixExpression)UnaryExpression_511_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_512_Var
		);
		final EList<? extends EObject> Expr_512_list = PostfixExpression_512_Var
		.getExpr();
		Assert.assertNotNull(Expr_512_list);
		Assert.assertEquals(1, Expr_512_list.size());
		//512
		final PrimaryExpression PrimaryExpression_513_Var
		 = (PrimaryExpression)Expr_512_list.get(0);
		Assert.assertNotNull(PrimaryExpression_513_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_513_Var
		.getId());
		final EList<? extends EObject> Suffix_513_list = PostfixExpression_512_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_513_list);
		Assert.assertEquals(1, Suffix_513_list.size());
		//513
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_514_Var
		 = (PostfixExpressionSuffixDot)Suffix_513_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_514_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_514_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_461_Var
		.getSemi());
		//514
		final Statement Statement_515_Var
		 = (Statement)Statement_105_list.get(7);
		Assert.assertNotNull(Statement_515_Var
		);
		//515
		final ExpressionStatement ExpressionStatement_516_Var
		 = (ExpressionStatement)Statement_515_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_516_Var
		);
		//516
		final Expression Expression_517_Var
		 = (Expression)ExpressionStatement_516_Var
		.getExpression();
		Assert.assertNotNull(Expression_517_Var
		);
		final EList<? extends EObject> ExprExpr_517_list = Expression_517_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_517_list);
		Assert.assertEquals(1, ExprExpr_517_list.size());
		//517
		final AssignmentExpression AssignmentExpression_518_Var
		 = (AssignmentExpression)ExprExpr_517_list.get(0);
		Assert.assertNotNull(AssignmentExpression_518_Var
		);
		//518
		final ConditionalExpression ConditionalExpression_519_Var
		 = (ConditionalExpression)AssignmentExpression_518_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_519_Var
		);
		//519
		final LogicalOrExpression LogicalOrExpression_520_Var
		 = (LogicalOrExpression)ConditionalExpression_519_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_520_Var
		);
		final EList<? extends EObject> Expr_520_list = LogicalOrExpression_520_Var
		.getExpr();
		Assert.assertNotNull(Expr_520_list);
		Assert.assertEquals(1, Expr_520_list.size());
		//520
		final LogicalAndExpression LogicalAndExpression_521_Var
		 = (LogicalAndExpression)Expr_520_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_521_Var
		);
		final EList<? extends EObject> Expr_521_list = LogicalAndExpression_521_Var
		.getExpr();
		Assert.assertNotNull(Expr_521_list);
		Assert.assertEquals(1, Expr_521_list.size());
		//521
		final InclusiveOrExpression InclusiveOrExpression_522_Var
		 = (InclusiveOrExpression)Expr_521_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_522_Var
		);
		final EList<? extends EObject> Expr_522_list = InclusiveOrExpression_522_Var
		.getExpr();
		Assert.assertNotNull(Expr_522_list);
		Assert.assertEquals(1, Expr_522_list.size());
		//522
		final ExclusiveOrExpression ExclusiveOrExpression_523_Var
		 = (ExclusiveOrExpression)Expr_522_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_523_Var
		);
		final EList<? extends EObject> Expr_523_list = ExclusiveOrExpression_523_Var
		.getExpr();
		Assert.assertNotNull(Expr_523_list);
		Assert.assertEquals(1, Expr_523_list.size());
		//523
		final AndExpression AndExpression_524_Var
		 = (AndExpression)Expr_523_list.get(0);
		Assert.assertNotNull(AndExpression_524_Var
		);
		final EList<? extends EObject> Expr_524_list = AndExpression_524_Var
		.getExpr();
		Assert.assertNotNull(Expr_524_list);
		Assert.assertEquals(1, Expr_524_list.size());
		//524
		final EqualityExpression EqualityExpression_525_Var
		 = (EqualityExpression)Expr_524_list.get(0);
		Assert.assertNotNull(EqualityExpression_525_Var
		);
		final EList<? extends EObject> Expr_525_list = EqualityExpression_525_Var
		.getExpr();
		Assert.assertNotNull(Expr_525_list);
		Assert.assertEquals(1, Expr_525_list.size());
		//525
		final RelationalExpression RelationalExpression_526_Var
		 = (RelationalExpression)Expr_525_list.get(0);
		Assert.assertNotNull(RelationalExpression_526_Var
		);
		final EList<? extends EObject> Expr_526_list = RelationalExpression_526_Var
		.getExpr();
		Assert.assertNotNull(Expr_526_list);
		Assert.assertEquals(1, Expr_526_list.size());
		//526
		final ShiftExpression ShiftExpression_527_Var
		 = (ShiftExpression)Expr_526_list.get(0);
		Assert.assertNotNull(ShiftExpression_527_Var
		);
		final EList<? extends EObject> Expr_527_list = ShiftExpression_527_Var
		.getExpr();
		Assert.assertNotNull(Expr_527_list);
		Assert.assertEquals(1, Expr_527_list.size());
		//527
		final AdditiveExpression AdditiveExpression_528_Var
		 = (AdditiveExpression)Expr_527_list.get(0);
		Assert.assertNotNull(AdditiveExpression_528_Var
		);
		final EList<? extends EObject> Expr_528_list = AdditiveExpression_528_Var
		.getExpr();
		Assert.assertNotNull(Expr_528_list);
		Assert.assertEquals(1, Expr_528_list.size());
		//528
		final MultiplicativeExpression MultiplicativeExpression_529_Var
		 = (MultiplicativeExpression)Expr_528_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_529_Var
		);
		final EList<? extends EObject> Expr_529_list = MultiplicativeExpression_529_Var
		.getExpr();
		Assert.assertNotNull(Expr_529_list);
		Assert.assertEquals(1, Expr_529_list.size());
		//529
		final CastExpression CastExpression_530_Var
		 = (CastExpression)Expr_529_list.get(0);
		Assert.assertNotNull(CastExpression_530_Var
		);
		//530
		final UnaryExpression UnaryExpression_531_Var
		 = (UnaryExpression)CastExpression_530_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_531_Var
		);
		//531
		final PostfixExpression PostfixExpression_532_Var
		 = (PostfixExpression)UnaryExpression_531_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_532_Var
		);
		final EList<? extends EObject> Expr_532_list = PostfixExpression_532_Var
		.getExpr();
		Assert.assertNotNull(Expr_532_list);
		Assert.assertEquals(1, Expr_532_list.size());
		//532
		final PrimaryExpression PrimaryExpression_533_Var
		 = (PrimaryExpression)Expr_532_list.get(0);
		Assert.assertNotNull(PrimaryExpression_533_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_533_Var
		.getId());
		final EList<? extends EObject> Suffix_533_list = PostfixExpression_532_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_533_list);
		Assert.assertEquals(1, Suffix_533_list.size());
		//533
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_534_Var
		 = (PostfixExpressionSuffixArgument)Suffix_533_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_534_Var
		);
		//534
		final ArgumentExpressionList ArgumentExpressionList_535_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_534_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_535_Var
		);
		final EList<? extends EObject> Expr_535_list = ArgumentExpressionList_535_Var
		.getExpr();
		Assert.assertNotNull(Expr_535_list);
		Assert.assertEquals(2, Expr_535_list.size());
		//535
		final AssignmentExpression AssignmentExpression_536_Var
		 = (AssignmentExpression)Expr_535_list.get(0);
		Assert.assertNotNull(AssignmentExpression_536_Var
		);
		//536
		final ConditionalExpression ConditionalExpression_537_Var
		 = (ConditionalExpression)AssignmentExpression_536_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_537_Var
		);
		//537
		final LogicalOrExpression LogicalOrExpression_538_Var
		 = (LogicalOrExpression)ConditionalExpression_537_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_538_Var
		);
		final EList<? extends EObject> Expr_538_list = LogicalOrExpression_538_Var
		.getExpr();
		Assert.assertNotNull(Expr_538_list);
		Assert.assertEquals(1, Expr_538_list.size());
		//538
		final LogicalAndExpression LogicalAndExpression_539_Var
		 = (LogicalAndExpression)Expr_538_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_539_Var
		);
		final EList<? extends EObject> Expr_539_list = LogicalAndExpression_539_Var
		.getExpr();
		Assert.assertNotNull(Expr_539_list);
		Assert.assertEquals(1, Expr_539_list.size());
		//539
		final InclusiveOrExpression InclusiveOrExpression_540_Var
		 = (InclusiveOrExpression)Expr_539_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_540_Var
		);
		final EList<? extends EObject> Expr_540_list = InclusiveOrExpression_540_Var
		.getExpr();
		Assert.assertNotNull(Expr_540_list);
		Assert.assertEquals(1, Expr_540_list.size());
		//540
		final ExclusiveOrExpression ExclusiveOrExpression_541_Var
		 = (ExclusiveOrExpression)Expr_540_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_541_Var
		);
		final EList<? extends EObject> Expr_541_list = ExclusiveOrExpression_541_Var
		.getExpr();
		Assert.assertNotNull(Expr_541_list);
		Assert.assertEquals(1, Expr_541_list.size());
		//541
		final AndExpression AndExpression_542_Var
		 = (AndExpression)Expr_541_list.get(0);
		Assert.assertNotNull(AndExpression_542_Var
		);
		final EList<? extends EObject> Expr_542_list = AndExpression_542_Var
		.getExpr();
		Assert.assertNotNull(Expr_542_list);
		Assert.assertEquals(1, Expr_542_list.size());
		//542
		final EqualityExpression EqualityExpression_543_Var
		 = (EqualityExpression)Expr_542_list.get(0);
		Assert.assertNotNull(EqualityExpression_543_Var
		);
		final EList<? extends EObject> Expr_543_list = EqualityExpression_543_Var
		.getExpr();
		Assert.assertNotNull(Expr_543_list);
		Assert.assertEquals(1, Expr_543_list.size());
		//543
		final RelationalExpression RelationalExpression_544_Var
		 = (RelationalExpression)Expr_543_list.get(0);
		Assert.assertNotNull(RelationalExpression_544_Var
		);
		final EList<? extends EObject> Expr_544_list = RelationalExpression_544_Var
		.getExpr();
		Assert.assertNotNull(Expr_544_list);
		Assert.assertEquals(1, Expr_544_list.size());
		//544
		final ShiftExpression ShiftExpression_545_Var
		 = (ShiftExpression)Expr_544_list.get(0);
		Assert.assertNotNull(ShiftExpression_545_Var
		);
		final EList<? extends EObject> Expr_545_list = ShiftExpression_545_Var
		.getExpr();
		Assert.assertNotNull(Expr_545_list);
		Assert.assertEquals(1, Expr_545_list.size());
		//545
		final AdditiveExpression AdditiveExpression_546_Var
		 = (AdditiveExpression)Expr_545_list.get(0);
		Assert.assertNotNull(AdditiveExpression_546_Var
		);
		final EList<? extends EObject> Expr_546_list = AdditiveExpression_546_Var
		.getExpr();
		Assert.assertNotNull(Expr_546_list);
		Assert.assertEquals(1, Expr_546_list.size());
		//546
		final MultiplicativeExpression MultiplicativeExpression_547_Var
		 = (MultiplicativeExpression)Expr_546_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_547_Var
		);
		final EList<? extends EObject> Expr_547_list = MultiplicativeExpression_547_Var
		.getExpr();
		Assert.assertNotNull(Expr_547_list);
		Assert.assertEquals(1, Expr_547_list.size());
		//547
		final CastExpression CastExpression_548_Var
		 = (CastExpression)Expr_547_list.get(0);
		Assert.assertNotNull(CastExpression_548_Var
		);
		//548
		final UnaryExpression UnaryExpression_549_Var
		 = (UnaryExpression)CastExpression_548_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_549_Var
		);
		//549
		final PostfixExpression PostfixExpression_550_Var
		 = (PostfixExpression)UnaryExpression_549_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_550_Var
		);
		final EList<? extends EObject> Expr_550_list = PostfixExpression_550_Var
		.getExpr();
		Assert.assertNotNull(Expr_550_list);
		Assert.assertEquals(1, Expr_550_list.size());
		//550
		final PrimaryExpression PrimaryExpression_551_Var
		 = (PrimaryExpression)Expr_550_list.get(0);
		Assert.assertNotNull(PrimaryExpression_551_Var
		);
		//551
		final Constant2 Constant2_552_Var
		 = (Constant2)PrimaryExpression_551_Var
		.getConst();
		Assert.assertNotNull(Constant2_552_Var
		);
		Assert.assertEquals("\"phil.id=%d\\n\"", Constant2_552_Var
		.getStr());
		//552
		final AssignmentExpression AssignmentExpression_553_Var
		 = (AssignmentExpression)Expr_535_list.get(1);
		Assert.assertNotNull(AssignmentExpression_553_Var
		);
		//553
		final ConditionalExpression ConditionalExpression_554_Var
		 = (ConditionalExpression)AssignmentExpression_553_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_554_Var
		);
		//554
		final LogicalOrExpression LogicalOrExpression_555_Var
		 = (LogicalOrExpression)ConditionalExpression_554_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_555_Var
		);
		final EList<? extends EObject> Expr_555_list = LogicalOrExpression_555_Var
		.getExpr();
		Assert.assertNotNull(Expr_555_list);
		Assert.assertEquals(1, Expr_555_list.size());
		//555
		final LogicalAndExpression LogicalAndExpression_556_Var
		 = (LogicalAndExpression)Expr_555_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_556_Var
		);
		final EList<? extends EObject> Expr_556_list = LogicalAndExpression_556_Var
		.getExpr();
		Assert.assertNotNull(Expr_556_list);
		Assert.assertEquals(1, Expr_556_list.size());
		//556
		final InclusiveOrExpression InclusiveOrExpression_557_Var
		 = (InclusiveOrExpression)Expr_556_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_557_Var
		);
		final EList<? extends EObject> Expr_557_list = InclusiveOrExpression_557_Var
		.getExpr();
		Assert.assertNotNull(Expr_557_list);
		Assert.assertEquals(1, Expr_557_list.size());
		//557
		final ExclusiveOrExpression ExclusiveOrExpression_558_Var
		 = (ExclusiveOrExpression)Expr_557_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_558_Var
		);
		final EList<? extends EObject> Expr_558_list = ExclusiveOrExpression_558_Var
		.getExpr();
		Assert.assertNotNull(Expr_558_list);
		Assert.assertEquals(1, Expr_558_list.size());
		//558
		final AndExpression AndExpression_559_Var
		 = (AndExpression)Expr_558_list.get(0);
		Assert.assertNotNull(AndExpression_559_Var
		);
		final EList<? extends EObject> Expr_559_list = AndExpression_559_Var
		.getExpr();
		Assert.assertNotNull(Expr_559_list);
		Assert.assertEquals(1, Expr_559_list.size());
		//559
		final EqualityExpression EqualityExpression_560_Var
		 = (EqualityExpression)Expr_559_list.get(0);
		Assert.assertNotNull(EqualityExpression_560_Var
		);
		final EList<? extends EObject> Expr_560_list = EqualityExpression_560_Var
		.getExpr();
		Assert.assertNotNull(Expr_560_list);
		Assert.assertEquals(1, Expr_560_list.size());
		//560
		final RelationalExpression RelationalExpression_561_Var
		 = (RelationalExpression)Expr_560_list.get(0);
		Assert.assertNotNull(RelationalExpression_561_Var
		);
		final EList<? extends EObject> Expr_561_list = RelationalExpression_561_Var
		.getExpr();
		Assert.assertNotNull(Expr_561_list);
		Assert.assertEquals(1, Expr_561_list.size());
		//561
		final ShiftExpression ShiftExpression_562_Var
		 = (ShiftExpression)Expr_561_list.get(0);
		Assert.assertNotNull(ShiftExpression_562_Var
		);
		final EList<? extends EObject> Expr_562_list = ShiftExpression_562_Var
		.getExpr();
		Assert.assertNotNull(Expr_562_list);
		Assert.assertEquals(1, Expr_562_list.size());
		//562
		final AdditiveExpression AdditiveExpression_563_Var
		 = (AdditiveExpression)Expr_562_list.get(0);
		Assert.assertNotNull(AdditiveExpression_563_Var
		);
		final EList<? extends EObject> Expr_563_list = AdditiveExpression_563_Var
		.getExpr();
		Assert.assertNotNull(Expr_563_list);
		Assert.assertEquals(1, Expr_563_list.size());
		//563
		final MultiplicativeExpression MultiplicativeExpression_564_Var
		 = (MultiplicativeExpression)Expr_563_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_564_Var
		);
		final EList<? extends EObject> Expr_564_list = MultiplicativeExpression_564_Var
		.getExpr();
		Assert.assertNotNull(Expr_564_list);
		Assert.assertEquals(1, Expr_564_list.size());
		//564
		final CastExpression CastExpression_565_Var
		 = (CastExpression)Expr_564_list.get(0);
		Assert.assertNotNull(CastExpression_565_Var
		);
		//565
		final UnaryExpression UnaryExpression_566_Var
		 = (UnaryExpression)CastExpression_565_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_566_Var
		);
		//566
		final PostfixExpression PostfixExpression_567_Var
		 = (PostfixExpression)UnaryExpression_566_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_567_Var
		);
		final EList<? extends EObject> Expr_567_list = PostfixExpression_567_Var
		.getExpr();
		Assert.assertNotNull(Expr_567_list);
		Assert.assertEquals(1, Expr_567_list.size());
		//567
		final PrimaryExpression PrimaryExpression_568_Var
		 = (PrimaryExpression)Expr_567_list.get(0);
		Assert.assertNotNull(PrimaryExpression_568_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_568_Var
		.getId());
		final EList<? extends EObject> Suffix_568_list = PostfixExpression_567_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_568_list);
		Assert.assertEquals(1, Suffix_568_list.size());
		//568
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_569_Var
		 = (PostfixExpressionSuffixDot)Suffix_568_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_569_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_569_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_516_Var
		.getSemi());
		//569
		final Statement Statement_570_Var
		 = (Statement)Statement_105_list.get(8);
		Assert.assertNotNull(Statement_570_Var
		);
		//570
		final ExpressionStatement ExpressionStatement_571_Var
		 = (ExpressionStatement)Statement_570_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_571_Var
		);
		//571
		final Expression Expression_572_Var
		 = (Expression)ExpressionStatement_571_Var
		.getExpression();
		Assert.assertNotNull(Expression_572_Var
		);
		final EList<? extends EObject> ExprExpr_572_list = Expression_572_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_572_list);
		Assert.assertEquals(1, ExprExpr_572_list.size());
		//572
		final AssignmentExpression AssignmentExpression_573_Var
		 = (AssignmentExpression)ExprExpr_572_list.get(0);
		Assert.assertNotNull(AssignmentExpression_573_Var
		);
		//573
		final ConditionalExpression ConditionalExpression_574_Var
		 = (ConditionalExpression)AssignmentExpression_573_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_574_Var
		);
		//574
		final LogicalOrExpression LogicalOrExpression_575_Var
		 = (LogicalOrExpression)ConditionalExpression_574_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_575_Var
		);
		final EList<? extends EObject> Expr_575_list = LogicalOrExpression_575_Var
		.getExpr();
		Assert.assertNotNull(Expr_575_list);
		Assert.assertEquals(1, Expr_575_list.size());
		//575
		final LogicalAndExpression LogicalAndExpression_576_Var
		 = (LogicalAndExpression)Expr_575_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_576_Var
		);
		final EList<? extends EObject> Expr_576_list = LogicalAndExpression_576_Var
		.getExpr();
		Assert.assertNotNull(Expr_576_list);
		Assert.assertEquals(1, Expr_576_list.size());
		//576
		final InclusiveOrExpression InclusiveOrExpression_577_Var
		 = (InclusiveOrExpression)Expr_576_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_577_Var
		);
		final EList<? extends EObject> Expr_577_list = InclusiveOrExpression_577_Var
		.getExpr();
		Assert.assertNotNull(Expr_577_list);
		Assert.assertEquals(1, Expr_577_list.size());
		//577
		final ExclusiveOrExpression ExclusiveOrExpression_578_Var
		 = (ExclusiveOrExpression)Expr_577_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_578_Var
		);
		final EList<? extends EObject> Expr_578_list = ExclusiveOrExpression_578_Var
		.getExpr();
		Assert.assertNotNull(Expr_578_list);
		Assert.assertEquals(1, Expr_578_list.size());
		//578
		final AndExpression AndExpression_579_Var
		 = (AndExpression)Expr_578_list.get(0);
		Assert.assertNotNull(AndExpression_579_Var
		);
		final EList<? extends EObject> Expr_579_list = AndExpression_579_Var
		.getExpr();
		Assert.assertNotNull(Expr_579_list);
		Assert.assertEquals(1, Expr_579_list.size());
		//579
		final EqualityExpression EqualityExpression_580_Var
		 = (EqualityExpression)Expr_579_list.get(0);
		Assert.assertNotNull(EqualityExpression_580_Var
		);
		final EList<? extends EObject> Expr_580_list = EqualityExpression_580_Var
		.getExpr();
		Assert.assertNotNull(Expr_580_list);
		Assert.assertEquals(1, Expr_580_list.size());
		//580
		final RelationalExpression RelationalExpression_581_Var
		 = (RelationalExpression)Expr_580_list.get(0);
		Assert.assertNotNull(RelationalExpression_581_Var
		);
		final EList<? extends EObject> Expr_581_list = RelationalExpression_581_Var
		.getExpr();
		Assert.assertNotNull(Expr_581_list);
		Assert.assertEquals(1, Expr_581_list.size());
		//581
		final ShiftExpression ShiftExpression_582_Var
		 = (ShiftExpression)Expr_581_list.get(0);
		Assert.assertNotNull(ShiftExpression_582_Var
		);
		final EList<? extends EObject> Expr_582_list = ShiftExpression_582_Var
		.getExpr();
		Assert.assertNotNull(Expr_582_list);
		Assert.assertEquals(1, Expr_582_list.size());
		//582
		final AdditiveExpression AdditiveExpression_583_Var
		 = (AdditiveExpression)Expr_582_list.get(0);
		Assert.assertNotNull(AdditiveExpression_583_Var
		);
		final EList<? extends EObject> Expr_583_list = AdditiveExpression_583_Var
		.getExpr();
		Assert.assertNotNull(Expr_583_list);
		Assert.assertEquals(1, Expr_583_list.size());
		//583
		final MultiplicativeExpression MultiplicativeExpression_584_Var
		 = (MultiplicativeExpression)Expr_583_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_584_Var
		);
		final EList<? extends EObject> Expr_584_list = MultiplicativeExpression_584_Var
		.getExpr();
		Assert.assertNotNull(Expr_584_list);
		Assert.assertEquals(1, Expr_584_list.size());
		//584
		final CastExpression CastExpression_585_Var
		 = (CastExpression)Expr_584_list.get(0);
		Assert.assertNotNull(CastExpression_585_Var
		);
		//585
		final UnaryExpression UnaryExpression_586_Var
		 = (UnaryExpression)CastExpression_585_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_586_Var
		);
		//586
		final PostfixExpression PostfixExpression_587_Var
		 = (PostfixExpression)UnaryExpression_586_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_587_Var
		);
		final EList<? extends EObject> Expr_587_list = PostfixExpression_587_Var
		.getExpr();
		Assert.assertNotNull(Expr_587_list);
		Assert.assertEquals(1, Expr_587_list.size());
		//587
		final PrimaryExpression PrimaryExpression_588_Var
		 = (PrimaryExpression)Expr_587_list.get(0);
		Assert.assertNotNull(PrimaryExpression_588_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_588_Var
		.getId());
		final EList<? extends EObject> Suffix_588_list = PostfixExpression_587_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_588_list);
		Assert.assertEquals(1, Suffix_588_list.size());
		//588
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_589_Var
		 = (PostfixExpressionSuffixArgument)Suffix_588_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_589_Var
		);
		//589
		final ArgumentExpressionList ArgumentExpressionList_590_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_589_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_590_Var
		);
		final EList<? extends EObject> Expr_590_list = ArgumentExpressionList_590_Var
		.getExpr();
		Assert.assertNotNull(Expr_590_list);
		Assert.assertEquals(2, Expr_590_list.size());
		//590
		final AssignmentExpression AssignmentExpression_591_Var
		 = (AssignmentExpression)Expr_590_list.get(0);
		Assert.assertNotNull(AssignmentExpression_591_Var
		);
		//591
		final ConditionalExpression ConditionalExpression_592_Var
		 = (ConditionalExpression)AssignmentExpression_591_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_592_Var
		);
		//592
		final LogicalOrExpression LogicalOrExpression_593_Var
		 = (LogicalOrExpression)ConditionalExpression_592_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_593_Var
		);
		final EList<? extends EObject> Expr_593_list = LogicalOrExpression_593_Var
		.getExpr();
		Assert.assertNotNull(Expr_593_list);
		Assert.assertEquals(1, Expr_593_list.size());
		//593
		final LogicalAndExpression LogicalAndExpression_594_Var
		 = (LogicalAndExpression)Expr_593_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_594_Var
		);
		final EList<? extends EObject> Expr_594_list = LogicalAndExpression_594_Var
		.getExpr();
		Assert.assertNotNull(Expr_594_list);
		Assert.assertEquals(1, Expr_594_list.size());
		//594
		final InclusiveOrExpression InclusiveOrExpression_595_Var
		 = (InclusiveOrExpression)Expr_594_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_595_Var
		);
		final EList<? extends EObject> Expr_595_list = InclusiveOrExpression_595_Var
		.getExpr();
		Assert.assertNotNull(Expr_595_list);
		Assert.assertEquals(1, Expr_595_list.size());
		//595
		final ExclusiveOrExpression ExclusiveOrExpression_596_Var
		 = (ExclusiveOrExpression)Expr_595_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_596_Var
		);
		final EList<? extends EObject> Expr_596_list = ExclusiveOrExpression_596_Var
		.getExpr();
		Assert.assertNotNull(Expr_596_list);
		Assert.assertEquals(1, Expr_596_list.size());
		//596
		final AndExpression AndExpression_597_Var
		 = (AndExpression)Expr_596_list.get(0);
		Assert.assertNotNull(AndExpression_597_Var
		);
		final EList<? extends EObject> Expr_597_list = AndExpression_597_Var
		.getExpr();
		Assert.assertNotNull(Expr_597_list);
		Assert.assertEquals(1, Expr_597_list.size());
		//597
		final EqualityExpression EqualityExpression_598_Var
		 = (EqualityExpression)Expr_597_list.get(0);
		Assert.assertNotNull(EqualityExpression_598_Var
		);
		final EList<? extends EObject> Expr_598_list = EqualityExpression_598_Var
		.getExpr();
		Assert.assertNotNull(Expr_598_list);
		Assert.assertEquals(1, Expr_598_list.size());
		//598
		final RelationalExpression RelationalExpression_599_Var
		 = (RelationalExpression)Expr_598_list.get(0);
		Assert.assertNotNull(RelationalExpression_599_Var
		);
		final EList<? extends EObject> Expr_599_list = RelationalExpression_599_Var
		.getExpr();
		Assert.assertNotNull(Expr_599_list);
		Assert.assertEquals(1, Expr_599_list.size());
		//599
		final ShiftExpression ShiftExpression_600_Var
		 = (ShiftExpression)Expr_599_list.get(0);
		Assert.assertNotNull(ShiftExpression_600_Var
		);
		final EList<? extends EObject> Expr_600_list = ShiftExpression_600_Var
		.getExpr();
		Assert.assertNotNull(Expr_600_list);
		Assert.assertEquals(1, Expr_600_list.size());
		//600
		final AdditiveExpression AdditiveExpression_601_Var
		 = (AdditiveExpression)Expr_600_list.get(0);
		Assert.assertNotNull(AdditiveExpression_601_Var
		);
		final EList<? extends EObject> Expr_601_list = AdditiveExpression_601_Var
		.getExpr();
		Assert.assertNotNull(Expr_601_list);
		Assert.assertEquals(1, Expr_601_list.size());
		//601
		final MultiplicativeExpression MultiplicativeExpression_602_Var
		 = (MultiplicativeExpression)Expr_601_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_602_Var
		);
		final EList<? extends EObject> Expr_602_list = MultiplicativeExpression_602_Var
		.getExpr();
		Assert.assertNotNull(Expr_602_list);
		Assert.assertEquals(1, Expr_602_list.size());
		//602
		final CastExpression CastExpression_603_Var
		 = (CastExpression)Expr_602_list.get(0);
		Assert.assertNotNull(CastExpression_603_Var
		);
		//603
		final UnaryExpression UnaryExpression_604_Var
		 = (UnaryExpression)CastExpression_603_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_604_Var
		);
		//604
		final PostfixExpression PostfixExpression_605_Var
		 = (PostfixExpression)UnaryExpression_604_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_605_Var
		);
		final EList<? extends EObject> Expr_605_list = PostfixExpression_605_Var
		.getExpr();
		Assert.assertNotNull(Expr_605_list);
		Assert.assertEquals(1, Expr_605_list.size());
		//605
		final PrimaryExpression PrimaryExpression_606_Var
		 = (PrimaryExpression)Expr_605_list.get(0);
		Assert.assertNotNull(PrimaryExpression_606_Var
		);
		//606
		final Constant2 Constant2_607_Var
		 = (Constant2)PrimaryExpression_606_Var
		.getConst();
		Assert.assertNotNull(Constant2_607_Var
		);
		Assert.assertEquals("\"phil.name=%s\\n\"", Constant2_607_Var
		.getStr());
		//607
		final AssignmentExpression AssignmentExpression_608_Var
		 = (AssignmentExpression)Expr_590_list.get(1);
		Assert.assertNotNull(AssignmentExpression_608_Var
		);
		//608
		final ConditionalExpression ConditionalExpression_609_Var
		 = (ConditionalExpression)AssignmentExpression_608_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_609_Var
		);
		//609
		final LogicalOrExpression LogicalOrExpression_610_Var
		 = (LogicalOrExpression)ConditionalExpression_609_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_610_Var
		);
		final EList<? extends EObject> Expr_610_list = LogicalOrExpression_610_Var
		.getExpr();
		Assert.assertNotNull(Expr_610_list);
		Assert.assertEquals(1, Expr_610_list.size());
		//610
		final LogicalAndExpression LogicalAndExpression_611_Var
		 = (LogicalAndExpression)Expr_610_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_611_Var
		);
		final EList<? extends EObject> Expr_611_list = LogicalAndExpression_611_Var
		.getExpr();
		Assert.assertNotNull(Expr_611_list);
		Assert.assertEquals(1, Expr_611_list.size());
		//611
		final InclusiveOrExpression InclusiveOrExpression_612_Var
		 = (InclusiveOrExpression)Expr_611_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_612_Var
		);
		final EList<? extends EObject> Expr_612_list = InclusiveOrExpression_612_Var
		.getExpr();
		Assert.assertNotNull(Expr_612_list);
		Assert.assertEquals(1, Expr_612_list.size());
		//612
		final ExclusiveOrExpression ExclusiveOrExpression_613_Var
		 = (ExclusiveOrExpression)Expr_612_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_613_Var
		);
		final EList<? extends EObject> Expr_613_list = ExclusiveOrExpression_613_Var
		.getExpr();
		Assert.assertNotNull(Expr_613_list);
		Assert.assertEquals(1, Expr_613_list.size());
		//613
		final AndExpression AndExpression_614_Var
		 = (AndExpression)Expr_613_list.get(0);
		Assert.assertNotNull(AndExpression_614_Var
		);
		final EList<? extends EObject> Expr_614_list = AndExpression_614_Var
		.getExpr();
		Assert.assertNotNull(Expr_614_list);
		Assert.assertEquals(1, Expr_614_list.size());
		//614
		final EqualityExpression EqualityExpression_615_Var
		 = (EqualityExpression)Expr_614_list.get(0);
		Assert.assertNotNull(EqualityExpression_615_Var
		);
		final EList<? extends EObject> Expr_615_list = EqualityExpression_615_Var
		.getExpr();
		Assert.assertNotNull(Expr_615_list);
		Assert.assertEquals(1, Expr_615_list.size());
		//615
		final RelationalExpression RelationalExpression_616_Var
		 = (RelationalExpression)Expr_615_list.get(0);
		Assert.assertNotNull(RelationalExpression_616_Var
		);
		final EList<? extends EObject> Expr_616_list = RelationalExpression_616_Var
		.getExpr();
		Assert.assertNotNull(Expr_616_list);
		Assert.assertEquals(1, Expr_616_list.size());
		//616
		final ShiftExpression ShiftExpression_617_Var
		 = (ShiftExpression)Expr_616_list.get(0);
		Assert.assertNotNull(ShiftExpression_617_Var
		);
		final EList<? extends EObject> Expr_617_list = ShiftExpression_617_Var
		.getExpr();
		Assert.assertNotNull(Expr_617_list);
		Assert.assertEquals(1, Expr_617_list.size());
		//617
		final AdditiveExpression AdditiveExpression_618_Var
		 = (AdditiveExpression)Expr_617_list.get(0);
		Assert.assertNotNull(AdditiveExpression_618_Var
		);
		final EList<? extends EObject> Expr_618_list = AdditiveExpression_618_Var
		.getExpr();
		Assert.assertNotNull(Expr_618_list);
		Assert.assertEquals(1, Expr_618_list.size());
		//618
		final MultiplicativeExpression MultiplicativeExpression_619_Var
		 = (MultiplicativeExpression)Expr_618_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_619_Var
		);
		final EList<? extends EObject> Expr_619_list = MultiplicativeExpression_619_Var
		.getExpr();
		Assert.assertNotNull(Expr_619_list);
		Assert.assertEquals(1, Expr_619_list.size());
		//619
		final CastExpression CastExpression_620_Var
		 = (CastExpression)Expr_619_list.get(0);
		Assert.assertNotNull(CastExpression_620_Var
		);
		//620
		final UnaryExpression UnaryExpression_621_Var
		 = (UnaryExpression)CastExpression_620_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_621_Var
		);
		//621
		final PostfixExpression PostfixExpression_622_Var
		 = (PostfixExpression)UnaryExpression_621_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_622_Var
		);
		final EList<? extends EObject> Expr_622_list = PostfixExpression_622_Var
		.getExpr();
		Assert.assertNotNull(Expr_622_list);
		Assert.assertEquals(1, Expr_622_list.size());
		//622
		final PrimaryExpression PrimaryExpression_623_Var
		 = (PrimaryExpression)Expr_622_list.get(0);
		Assert.assertNotNull(PrimaryExpression_623_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_623_Var
		.getId());
		final EList<? extends EObject> Suffix_623_list = PostfixExpression_622_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_623_list);
		Assert.assertEquals(1, Suffix_623_list.size());
		//623
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_624_Var
		 = (PostfixExpressionSuffixDot)Suffix_623_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_624_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_624_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_571_Var
		.getSemi());
		//624
		final Statement Statement_625_Var
		 = (Statement)Statement_105_list.get(9);
		Assert.assertNotNull(Statement_625_Var
		);
		//625
		final JumpStatement JumpStatement_626_Var
		 = (JumpStatement)Statement_625_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_626_Var
		);
		//626
		final Expression Expression_627_Var
		 = (Expression)JumpStatement_626_Var
		.getExpr();
		Assert.assertNotNull(Expression_627_Var
		);
		final EList<? extends EObject> ExprExpr_627_list = Expression_627_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_627_list);
		Assert.assertEquals(1, ExprExpr_627_list.size());
		//627
		final AssignmentExpression AssignmentExpression_628_Var
		 = (AssignmentExpression)ExprExpr_627_list.get(0);
		Assert.assertNotNull(AssignmentExpression_628_Var
		);
		//628
		final ConditionalExpression ConditionalExpression_629_Var
		 = (ConditionalExpression)AssignmentExpression_628_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_629_Var
		);
		//629
		final LogicalOrExpression LogicalOrExpression_630_Var
		 = (LogicalOrExpression)ConditionalExpression_629_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_630_Var
		);
		final EList<? extends EObject> Expr_630_list = LogicalOrExpression_630_Var
		.getExpr();
		Assert.assertNotNull(Expr_630_list);
		Assert.assertEquals(1, Expr_630_list.size());
		//630
		final LogicalAndExpression LogicalAndExpression_631_Var
		 = (LogicalAndExpression)Expr_630_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_631_Var
		);
		final EList<? extends EObject> Expr_631_list = LogicalAndExpression_631_Var
		.getExpr();
		Assert.assertNotNull(Expr_631_list);
		Assert.assertEquals(1, Expr_631_list.size());
		//631
		final InclusiveOrExpression InclusiveOrExpression_632_Var
		 = (InclusiveOrExpression)Expr_631_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_632_Var
		);
		final EList<? extends EObject> Expr_632_list = InclusiveOrExpression_632_Var
		.getExpr();
		Assert.assertNotNull(Expr_632_list);
		Assert.assertEquals(1, Expr_632_list.size());
		//632
		final ExclusiveOrExpression ExclusiveOrExpression_633_Var
		 = (ExclusiveOrExpression)Expr_632_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_633_Var
		);
		final EList<? extends EObject> Expr_633_list = ExclusiveOrExpression_633_Var
		.getExpr();
		Assert.assertNotNull(Expr_633_list);
		Assert.assertEquals(1, Expr_633_list.size());
		//633
		final AndExpression AndExpression_634_Var
		 = (AndExpression)Expr_633_list.get(0);
		Assert.assertNotNull(AndExpression_634_Var
		);
		final EList<? extends EObject> Expr_634_list = AndExpression_634_Var
		.getExpr();
		Assert.assertNotNull(Expr_634_list);
		Assert.assertEquals(1, Expr_634_list.size());
		//634
		final EqualityExpression EqualityExpression_635_Var
		 = (EqualityExpression)Expr_634_list.get(0);
		Assert.assertNotNull(EqualityExpression_635_Var
		);
		final EList<? extends EObject> Expr_635_list = EqualityExpression_635_Var
		.getExpr();
		Assert.assertNotNull(Expr_635_list);
		Assert.assertEquals(1, Expr_635_list.size());
		//635
		final RelationalExpression RelationalExpression_636_Var
		 = (RelationalExpression)Expr_635_list.get(0);
		Assert.assertNotNull(RelationalExpression_636_Var
		);
		final EList<? extends EObject> Expr_636_list = RelationalExpression_636_Var
		.getExpr();
		Assert.assertNotNull(Expr_636_list);
		Assert.assertEquals(1, Expr_636_list.size());
		//636
		final ShiftExpression ShiftExpression_637_Var
		 = (ShiftExpression)Expr_636_list.get(0);
		Assert.assertNotNull(ShiftExpression_637_Var
		);
		final EList<? extends EObject> Expr_637_list = ShiftExpression_637_Var
		.getExpr();
		Assert.assertNotNull(Expr_637_list);
		Assert.assertEquals(1, Expr_637_list.size());
		//637
		final AdditiveExpression AdditiveExpression_638_Var
		 = (AdditiveExpression)Expr_637_list.get(0);
		Assert.assertNotNull(AdditiveExpression_638_Var
		);
		final EList<? extends EObject> Expr_638_list = AdditiveExpression_638_Var
		.getExpr();
		Assert.assertNotNull(Expr_638_list);
		Assert.assertEquals(1, Expr_638_list.size());
		//638
		final MultiplicativeExpression MultiplicativeExpression_639_Var
		 = (MultiplicativeExpression)Expr_638_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_639_Var
		);
		final EList<? extends EObject> Expr_639_list = MultiplicativeExpression_639_Var
		.getExpr();
		Assert.assertNotNull(Expr_639_list);
		Assert.assertEquals(1, Expr_639_list.size());
		//639
		final CastExpression CastExpression_640_Var
		 = (CastExpression)Expr_639_list.get(0);
		Assert.assertNotNull(CastExpression_640_Var
		);
		//640
		final UnaryExpression UnaryExpression_641_Var
		 = (UnaryExpression)CastExpression_640_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_641_Var
		);
		//641
		final PostfixExpression PostfixExpression_642_Var
		 = (PostfixExpression)UnaryExpression_641_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_642_Var
		);
		final EList<? extends EObject> Expr_642_list = PostfixExpression_642_Var
		.getExpr();
		Assert.assertNotNull(Expr_642_list);
		Assert.assertEquals(1, Expr_642_list.size());
		//642
		final PrimaryExpression PrimaryExpression_643_Var
		 = (PrimaryExpression)Expr_642_list.get(0);
		Assert.assertNotNull(PrimaryExpression_643_Var
		);
		//643
		final Constant2 Constant2_644_Var
		 = (Constant2)PrimaryExpression_643_Var
		.getConst();
		Assert.assertNotNull(Constant2_644_Var
		);
		Assert.assertEquals("0", Constant2_644_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_626_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_626_Var
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


