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
import at.jku.weiner.c.parser.parser.Init;
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
import at.jku.weiner.c.parser.parser.Init;
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
		final EList<? extends EObject> Init_55_list = InitializerList_55_Var
		.getInit();
		Assert.assertNotNull(Init_55_list);
		Assert.assertEquals(2, Init_55_list.size());
		//55
		final Init Init_56_Var
		 = (Init)Init_55_list.get(0);
		Assert.assertNotNull(Init_56_Var
		);
		//56
		final Initializer Initializer_57_Var
		 = (Initializer)Init_56_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_57_Var
		);
		//57
		final AssignmentExpression AssignmentExpression_58_Var
		 = (AssignmentExpression)Initializer_57_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_58_Var
		);
		//58
		final ConditionalExpression ConditionalExpression_59_Var
		 = (ConditionalExpression)AssignmentExpression_58_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_59_Var
		);
		//59
		final LogicalOrExpression LogicalOrExpression_60_Var
		 = (LogicalOrExpression)ConditionalExpression_59_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = LogicalOrExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final LogicalAndExpression LogicalAndExpression_61_Var
		 = (LogicalAndExpression)Expr_60_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = LogicalAndExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final InclusiveOrExpression InclusiveOrExpression_62_Var
		 = (InclusiveOrExpression)Expr_61_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = InclusiveOrExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final ExclusiveOrExpression ExclusiveOrExpression_63_Var
		 = (ExclusiveOrExpression)Expr_62_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = ExclusiveOrExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final AndExpression AndExpression_64_Var
		 = (AndExpression)Expr_63_list.get(0);
		Assert.assertNotNull(AndExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = AndExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final EqualityExpression EqualityExpression_65_Var
		 = (EqualityExpression)Expr_64_list.get(0);
		Assert.assertNotNull(EqualityExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = EqualityExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final RelationalExpression RelationalExpression_66_Var
		 = (RelationalExpression)Expr_65_list.get(0);
		Assert.assertNotNull(RelationalExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = RelationalExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final ShiftExpression ShiftExpression_67_Var
		 = (ShiftExpression)Expr_66_list.get(0);
		Assert.assertNotNull(ShiftExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = ShiftExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final AdditiveExpression AdditiveExpression_68_Var
		 = (AdditiveExpression)Expr_67_list.get(0);
		Assert.assertNotNull(AdditiveExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = AdditiveExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final MultiplicativeExpression MultiplicativeExpression_69_Var
		 = (MultiplicativeExpression)Expr_68_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = MultiplicativeExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final CastExpression CastExpression_70_Var
		 = (CastExpression)Expr_69_list.get(0);
		Assert.assertNotNull(CastExpression_70_Var
		);
		//70
		final UnaryExpression UnaryExpression_71_Var
		 = (UnaryExpression)CastExpression_70_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_71_Var
		);
		//71
		final PostfixExpression PostfixExpression_72_Var
		 = (PostfixExpression)UnaryExpression_71_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = PostfixExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final PrimaryExpression PrimaryExpression_73_Var
		 = (PrimaryExpression)Expr_72_list.get(0);
		Assert.assertNotNull(PrimaryExpression_73_Var
		);
		//73
		final Constant2 Constant2_74_Var
		 = (Constant2)PrimaryExpression_73_Var
		.getConst();
		Assert.assertNotNull(Constant2_74_Var
		);
		Assert.assertEquals("0x007", Constant2_74_Var
		.getHex());
		//74
		final Init Init_75_Var
		 = (Init)Init_55_list.get(1);
		Assert.assertNotNull(Init_75_Var
		);
		//75
		final Initializer Initializer_76_Var
		 = (Initializer)Init_75_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_76_Var
		);
		//76
		final AssignmentExpression AssignmentExpression_77_Var
		 = (AssignmentExpression)Initializer_76_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_77_Var
		);
		//77
		final ConditionalExpression ConditionalExpression_78_Var
		 = (ConditionalExpression)AssignmentExpression_77_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_78_Var
		);
		//78
		final LogicalOrExpression LogicalOrExpression_79_Var
		 = (LogicalOrExpression)ConditionalExpression_78_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = LogicalOrExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final LogicalAndExpression LogicalAndExpression_80_Var
		 = (LogicalAndExpression)Expr_79_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = LogicalAndExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final InclusiveOrExpression InclusiveOrExpression_81_Var
		 = (InclusiveOrExpression)Expr_80_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = InclusiveOrExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final ExclusiveOrExpression ExclusiveOrExpression_82_Var
		 = (ExclusiveOrExpression)Expr_81_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = ExclusiveOrExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final AndExpression AndExpression_83_Var
		 = (AndExpression)Expr_82_list.get(0);
		Assert.assertNotNull(AndExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = AndExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final EqualityExpression EqualityExpression_84_Var
		 = (EqualityExpression)Expr_83_list.get(0);
		Assert.assertNotNull(EqualityExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = EqualityExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final RelationalExpression RelationalExpression_85_Var
		 = (RelationalExpression)Expr_84_list.get(0);
		Assert.assertNotNull(RelationalExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = RelationalExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final ShiftExpression ShiftExpression_86_Var
		 = (ShiftExpression)Expr_85_list.get(0);
		Assert.assertNotNull(ShiftExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = ShiftExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final AdditiveExpression AdditiveExpression_87_Var
		 = (AdditiveExpression)Expr_86_list.get(0);
		Assert.assertNotNull(AdditiveExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = AdditiveExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final MultiplicativeExpression MultiplicativeExpression_88_Var
		 = (MultiplicativeExpression)Expr_87_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = MultiplicativeExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final CastExpression CastExpression_89_Var
		 = (CastExpression)Expr_88_list.get(0);
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
		Assert.assertEquals("[\"Joe Nobody\"]", PrimaryExpression_92_Var
		.getString().toString());
		//92
		final ExternalDeclaration ExternalDeclaration_93_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_93_Var
		);
		//93
		final FunctionDefHead FunctionDefHead_94_Var
		 = (FunctionDefHead)ExternalDeclaration_93_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_94_Var
		);
		//94
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_95_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_94_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_95_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_95_list = FunctionDeclarationSpecifiers_95_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_95_list);
		Assert.assertEquals(1, DeclarationSpecifier_95_list.size());
		//95
		final TypeSpecifier TypeSpecifier_96_Var
		 = (TypeSpecifier)DeclarationSpecifier_95_list.get(0);
		Assert.assertNotNull(TypeSpecifier_96_Var
		);
		Assert.assertEquals("int", TypeSpecifier_96_Var
		.getName());
		//96
		final Declarator Declarator_97_Var
		 = (Declarator)FunctionDefHead_94_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_97_Var
		);
		//97
		final DirectDeclarator DirectDeclarator_98_Var
		 = (DirectDeclarator)Declarator_97_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_98_Var
		);
		Assert.assertEquals("main", DirectDeclarator_98_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_98_list = DirectDeclarator_98_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_98_list);
		Assert.assertEquals(1, DeclaratorSuffix_98_list.size());
		//98
		final DeclaratorSuffix DeclaratorSuffix_99_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_98_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_99_Var
		);
		//99
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_100_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_99_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_100_Var
		);
		final EList<? extends EObject> ParameterTypeList_100_list = DirectDeclaratorLastSuffix_100_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_100_list);
		Assert.assertEquals(1, ParameterTypeList_100_list.size());
		//100
		final ParameterTypeList ParameterTypeList_101_Var
		 = (ParameterTypeList)ParameterTypeList_100_list.get(0);
		Assert.assertNotNull(ParameterTypeList_101_Var
		);
		//101
		final ParameterList ParameterList_102_Var
		 = (ParameterList)ParameterTypeList_101_Var
		.getList();
		Assert.assertNotNull(ParameterList_102_Var
		);
		final EList<? extends EObject> ParameterDeclaration_102_list = ParameterList_102_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_102_list);
		Assert.assertEquals(1, ParameterDeclaration_102_list.size());
		//102
		final ParameterDeclaration ParameterDeclaration_103_Var
		 = (ParameterDeclaration)ParameterDeclaration_102_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_103_Var
		);
		//103
		final DeclarationSpecifiers DeclarationSpecifiers_104_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_103_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_104_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_104_list = DeclarationSpecifiers_104_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_104_list);
		Assert.assertEquals(1, DeclarationSpecifier_104_list.size());
		//104
		final TypeSpecifier TypeSpecifier_105_Var
		 = (TypeSpecifier)DeclarationSpecifier_104_list.get(0);
		Assert.assertNotNull(TypeSpecifier_105_Var
		);
		Assert.assertEquals("void", TypeSpecifier_105_Var
		.getName());
		//105
		final FunctionDefinition FunctionDefinition_106_Var
		 = (FunctionDefinition)ExternalDeclaration_93_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_106_Var
		);
		//106
		final BodyStatement BodyStatement_107_Var
		 = (BodyStatement)FunctionDefinition_106_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_107_Var
		);
		final EList<? extends EObject> BlockList_107_list = BodyStatement_107_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_107_list);
		Assert.assertEquals(1, BlockList_107_list.size());
		//107
		final BlockList BlockList_108_Var
		 = (BlockList)BlockList_107_list.get(0);
		Assert.assertNotNull(BlockList_108_Var
		);
		final EList<? extends EObject> Statement_108_list = BlockList_108_Var
		.getStatement();
		Assert.assertNotNull(Statement_108_list);
		Assert.assertEquals(10, Statement_108_list.size());
		//108
		final Statement Statement_109_Var
		 = (Statement)Statement_108_list.get(0);
		Assert.assertNotNull(Statement_109_Var
		);
		//109
		final ExpressionStatement ExpressionStatement_110_Var
		 = (ExpressionStatement)Statement_109_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_110_Var
		);
		//110
		final Expression Expression_111_Var
		 = (Expression)ExpressionStatement_110_Var
		.getExpression();
		Assert.assertNotNull(Expression_111_Var
		);
		final EList<? extends EObject> ExprExpr_111_list = Expression_111_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_111_list);
		Assert.assertEquals(1, ExprExpr_111_list.size());
		//111
		final AssignmentExpression AssignmentExpression_112_Var
		 = (AssignmentExpression)ExprExpr_111_list.get(0);
		Assert.assertNotNull(AssignmentExpression_112_Var
		);
		//112
		final ConditionalExpression ConditionalExpression_113_Var
		 = (ConditionalExpression)AssignmentExpression_112_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_113_Var
		);
		//113
		final LogicalOrExpression LogicalOrExpression_114_Var
		 = (LogicalOrExpression)ConditionalExpression_113_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = LogicalOrExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final LogicalAndExpression LogicalAndExpression_115_Var
		 = (LogicalAndExpression)Expr_114_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = LogicalAndExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final InclusiveOrExpression InclusiveOrExpression_116_Var
		 = (InclusiveOrExpression)Expr_115_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = InclusiveOrExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final ExclusiveOrExpression ExclusiveOrExpression_117_Var
		 = (ExclusiveOrExpression)Expr_116_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = ExclusiveOrExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final AndExpression AndExpression_118_Var
		 = (AndExpression)Expr_117_list.get(0);
		Assert.assertNotNull(AndExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = AndExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final EqualityExpression EqualityExpression_119_Var
		 = (EqualityExpression)Expr_118_list.get(0);
		Assert.assertNotNull(EqualityExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = EqualityExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final RelationalExpression RelationalExpression_120_Var
		 = (RelationalExpression)Expr_119_list.get(0);
		Assert.assertNotNull(RelationalExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = RelationalExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final ShiftExpression ShiftExpression_121_Var
		 = (ShiftExpression)Expr_120_list.get(0);
		Assert.assertNotNull(ShiftExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = ShiftExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final AdditiveExpression AdditiveExpression_122_Var
		 = (AdditiveExpression)Expr_121_list.get(0);
		Assert.assertNotNull(AdditiveExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = AdditiveExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final MultiplicativeExpression MultiplicativeExpression_123_Var
		 = (MultiplicativeExpression)Expr_122_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = MultiplicativeExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final CastExpression CastExpression_124_Var
		 = (CastExpression)Expr_123_list.get(0);
		Assert.assertNotNull(CastExpression_124_Var
		);
		//124
		final UnaryExpression UnaryExpression_125_Var
		 = (UnaryExpression)CastExpression_124_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_125_Var
		);
		//125
		final PostfixExpression PostfixExpression_126_Var
		 = (PostfixExpression)UnaryExpression_125_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = PostfixExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final PrimaryExpression PrimaryExpression_127_Var
		 = (PrimaryExpression)Expr_126_list.get(0);
		Assert.assertNotNull(PrimaryExpression_127_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_127_Var
		.getId());
		final EList<? extends EObject> Suffix_127_list = PostfixExpression_126_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_127_list);
		Assert.assertEquals(1, Suffix_127_list.size());
		//127
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_128_Var
		 = (PostfixExpressionSuffixArgument)Suffix_127_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_128_Var
		);
		//128
		final ArgumentExpressionList ArgumentExpressionList_129_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_128_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_129_Var
		);
		final EList<? extends EObject> Expr_129_list = ArgumentExpressionList_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(2, Expr_129_list.size());
		//129
		final AssignmentExpression AssignmentExpression_130_Var
		 = (AssignmentExpression)Expr_129_list.get(0);
		Assert.assertNotNull(AssignmentExpression_130_Var
		);
		//130
		final ConditionalExpression ConditionalExpression_131_Var
		 = (ConditionalExpression)AssignmentExpression_130_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_131_Var
		);
		//131
		final LogicalOrExpression LogicalOrExpression_132_Var
		 = (LogicalOrExpression)ConditionalExpression_131_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = LogicalOrExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final LogicalAndExpression LogicalAndExpression_133_Var
		 = (LogicalAndExpression)Expr_132_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = LogicalAndExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final InclusiveOrExpression InclusiveOrExpression_134_Var
		 = (InclusiveOrExpression)Expr_133_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = InclusiveOrExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final ExclusiveOrExpression ExclusiveOrExpression_135_Var
		 = (ExclusiveOrExpression)Expr_134_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = ExclusiveOrExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final AndExpression AndExpression_136_Var
		 = (AndExpression)Expr_135_list.get(0);
		Assert.assertNotNull(AndExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = AndExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final EqualityExpression EqualityExpression_137_Var
		 = (EqualityExpression)Expr_136_list.get(0);
		Assert.assertNotNull(EqualityExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = EqualityExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final RelationalExpression RelationalExpression_138_Var
		 = (RelationalExpression)Expr_137_list.get(0);
		Assert.assertNotNull(RelationalExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = RelationalExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final ShiftExpression ShiftExpression_139_Var
		 = (ShiftExpression)Expr_138_list.get(0);
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
		Assert.assertEquals("[\"sizeof(joe.id)=%lu\\n\"]", PrimaryExpression_145_Var
		.getString().toString());
		//145
		final AssignmentExpression AssignmentExpression_146_Var
		 = (AssignmentExpression)Expr_129_list.get(1);
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
		//180
		final Statement Statement_181_Var
		 = (Statement)Statement_108_list.get(1);
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
		Assert.assertEquals("[\"sizeof(joe.name)=%lu\\n\"]", PrimaryExpression_217_Var
		.getString().toString());
		//217
		final AssignmentExpression AssignmentExpression_218_Var
		 = (AssignmentExpression)Expr_201_list.get(1);
		Assert.assertNotNull(AssignmentExpression_218_Var
		);
		//218
		final ConditionalExpression ConditionalExpression_219_Var
		 = (ConditionalExpression)AssignmentExpression_218_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_219_Var
		);
		//219
		final LogicalOrExpression LogicalOrExpression_220_Var
		 = (LogicalOrExpression)ConditionalExpression_219_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = LogicalOrExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final LogicalAndExpression LogicalAndExpression_221_Var
		 = (LogicalAndExpression)Expr_220_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = LogicalAndExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final InclusiveOrExpression InclusiveOrExpression_222_Var
		 = (InclusiveOrExpression)Expr_221_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = InclusiveOrExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final ExclusiveOrExpression ExclusiveOrExpression_223_Var
		 = (ExclusiveOrExpression)Expr_222_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = ExclusiveOrExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final AndExpression AndExpression_224_Var
		 = (AndExpression)Expr_223_list.get(0);
		Assert.assertNotNull(AndExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = AndExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final EqualityExpression EqualityExpression_225_Var
		 = (EqualityExpression)Expr_224_list.get(0);
		Assert.assertNotNull(EqualityExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = EqualityExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final RelationalExpression RelationalExpression_226_Var
		 = (RelationalExpression)Expr_225_list.get(0);
		Assert.assertNotNull(RelationalExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = RelationalExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final ShiftExpression ShiftExpression_227_Var
		 = (ShiftExpression)Expr_226_list.get(0);
		Assert.assertNotNull(ShiftExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = ShiftExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final AdditiveExpression AdditiveExpression_228_Var
		 = (AdditiveExpression)Expr_227_list.get(0);
		Assert.assertNotNull(AdditiveExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = AdditiveExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final MultiplicativeExpression MultiplicativeExpression_229_Var
		 = (MultiplicativeExpression)Expr_228_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = MultiplicativeExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final CastExpression CastExpression_230_Var
		 = (CastExpression)Expr_229_list.get(0);
		Assert.assertNotNull(CastExpression_230_Var
		);
		//230
		final UnaryExpression UnaryExpression_231_Var
		 = (UnaryExpression)CastExpression_230_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_231_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_231_Var
		.getSizeOf());
		//231
		final UnaryExpression UnaryExpression_232_Var
		 = (UnaryExpression)UnaryExpression_231_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_232_Var
		);
		//232
		final PostfixExpression PostfixExpression_233_Var
		 = (PostfixExpression)UnaryExpression_232_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = PostfixExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final PrimaryExpression PrimaryExpression_234_Var
		 = (PrimaryExpression)Expr_233_list.get(0);
		Assert.assertNotNull(PrimaryExpression_234_Var
		);
		//234
		final Expression Expression_235_Var
		 = (Expression)PrimaryExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expression_235_Var
		);
		final EList<? extends EObject> ExprExpr_235_list = Expression_235_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_235_list);
		Assert.assertEquals(1, ExprExpr_235_list.size());
		//235
		final AssignmentExpression AssignmentExpression_236_Var
		 = (AssignmentExpression)ExprExpr_235_list.get(0);
		Assert.assertNotNull(AssignmentExpression_236_Var
		);
		//236
		final ConditionalExpression ConditionalExpression_237_Var
		 = (ConditionalExpression)AssignmentExpression_236_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_237_Var
		);
		//237
		final LogicalOrExpression LogicalOrExpression_238_Var
		 = (LogicalOrExpression)ConditionalExpression_237_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = LogicalOrExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final LogicalAndExpression LogicalAndExpression_239_Var
		 = (LogicalAndExpression)Expr_238_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = LogicalAndExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final InclusiveOrExpression InclusiveOrExpression_240_Var
		 = (InclusiveOrExpression)Expr_239_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = InclusiveOrExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final ExclusiveOrExpression ExclusiveOrExpression_241_Var
		 = (ExclusiveOrExpression)Expr_240_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = ExclusiveOrExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final AndExpression AndExpression_242_Var
		 = (AndExpression)Expr_241_list.get(0);
		Assert.assertNotNull(AndExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = AndExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final EqualityExpression EqualityExpression_243_Var
		 = (EqualityExpression)Expr_242_list.get(0);
		Assert.assertNotNull(EqualityExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = EqualityExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final RelationalExpression RelationalExpression_244_Var
		 = (RelationalExpression)Expr_243_list.get(0);
		Assert.assertNotNull(RelationalExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = RelationalExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final ShiftExpression ShiftExpression_245_Var
		 = (ShiftExpression)Expr_244_list.get(0);
		Assert.assertNotNull(ShiftExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = ShiftExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final AdditiveExpression AdditiveExpression_246_Var
		 = (AdditiveExpression)Expr_245_list.get(0);
		Assert.assertNotNull(AdditiveExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = AdditiveExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final MultiplicativeExpression MultiplicativeExpression_247_Var
		 = (MultiplicativeExpression)Expr_246_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = MultiplicativeExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final CastExpression CastExpression_248_Var
		 = (CastExpression)Expr_247_list.get(0);
		Assert.assertNotNull(CastExpression_248_Var
		);
		//248
		final UnaryExpression UnaryExpression_249_Var
		 = (UnaryExpression)CastExpression_248_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_249_Var
		);
		//249
		final PostfixExpression PostfixExpression_250_Var
		 = (PostfixExpression)UnaryExpression_249_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = PostfixExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final PrimaryExpression PrimaryExpression_251_Var
		 = (PrimaryExpression)Expr_250_list.get(0);
		Assert.assertNotNull(PrimaryExpression_251_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_251_Var
		.getId());
		final EList<? extends EObject> Suffix_251_list = PostfixExpression_250_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_251_list);
		Assert.assertEquals(1, Suffix_251_list.size());
		//251
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_252_Var
		 = (PostfixExpressionSuffixDot)Suffix_251_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_252_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_252_Var
		.getId());
		//252
		final Statement Statement_253_Var
		 = (Statement)Statement_108_list.get(2);
		Assert.assertNotNull(Statement_253_Var
		);
		//253
		final ExpressionStatement ExpressionStatement_254_Var
		 = (ExpressionStatement)Statement_253_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_254_Var
		);
		//254
		final Expression Expression_255_Var
		 = (Expression)ExpressionStatement_254_Var
		.getExpression();
		Assert.assertNotNull(Expression_255_Var
		);
		final EList<? extends EObject> ExprExpr_255_list = Expression_255_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_255_list);
		Assert.assertEquals(1, ExprExpr_255_list.size());
		//255
		final AssignmentExpression AssignmentExpression_256_Var
		 = (AssignmentExpression)ExprExpr_255_list.get(0);
		Assert.assertNotNull(AssignmentExpression_256_Var
		);
		//256
		final ConditionalExpression ConditionalExpression_257_Var
		 = (ConditionalExpression)AssignmentExpression_256_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_257_Var
		);
		//257
		final LogicalOrExpression LogicalOrExpression_258_Var
		 = (LogicalOrExpression)ConditionalExpression_257_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_258_Var
		);
		final EList<? extends EObject> Expr_258_list = LogicalOrExpression_258_Var
		.getExpr();
		Assert.assertNotNull(Expr_258_list);
		Assert.assertEquals(1, Expr_258_list.size());
		//258
		final LogicalAndExpression LogicalAndExpression_259_Var
		 = (LogicalAndExpression)Expr_258_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_259_Var
		);
		final EList<? extends EObject> Expr_259_list = LogicalAndExpression_259_Var
		.getExpr();
		Assert.assertNotNull(Expr_259_list);
		Assert.assertEquals(1, Expr_259_list.size());
		//259
		final InclusiveOrExpression InclusiveOrExpression_260_Var
		 = (InclusiveOrExpression)Expr_259_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = InclusiveOrExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final ExclusiveOrExpression ExclusiveOrExpression_261_Var
		 = (ExclusiveOrExpression)Expr_260_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = ExclusiveOrExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final AndExpression AndExpression_262_Var
		 = (AndExpression)Expr_261_list.get(0);
		Assert.assertNotNull(AndExpression_262_Var
		);
		final EList<? extends EObject> Expr_262_list = AndExpression_262_Var
		.getExpr();
		Assert.assertNotNull(Expr_262_list);
		Assert.assertEquals(1, Expr_262_list.size());
		//262
		final EqualityExpression EqualityExpression_263_Var
		 = (EqualityExpression)Expr_262_list.get(0);
		Assert.assertNotNull(EqualityExpression_263_Var
		);
		final EList<? extends EObject> Expr_263_list = EqualityExpression_263_Var
		.getExpr();
		Assert.assertNotNull(Expr_263_list);
		Assert.assertEquals(1, Expr_263_list.size());
		//263
		final RelationalExpression RelationalExpression_264_Var
		 = (RelationalExpression)Expr_263_list.get(0);
		Assert.assertNotNull(RelationalExpression_264_Var
		);
		final EList<? extends EObject> Expr_264_list = RelationalExpression_264_Var
		.getExpr();
		Assert.assertNotNull(Expr_264_list);
		Assert.assertEquals(1, Expr_264_list.size());
		//264
		final ShiftExpression ShiftExpression_265_Var
		 = (ShiftExpression)Expr_264_list.get(0);
		Assert.assertNotNull(ShiftExpression_265_Var
		);
		final EList<? extends EObject> Expr_265_list = ShiftExpression_265_Var
		.getExpr();
		Assert.assertNotNull(Expr_265_list);
		Assert.assertEquals(1, Expr_265_list.size());
		//265
		final AdditiveExpression AdditiveExpression_266_Var
		 = (AdditiveExpression)Expr_265_list.get(0);
		Assert.assertNotNull(AdditiveExpression_266_Var
		);
		final EList<? extends EObject> Expr_266_list = AdditiveExpression_266_Var
		.getExpr();
		Assert.assertNotNull(Expr_266_list);
		Assert.assertEquals(1, Expr_266_list.size());
		//266
		final MultiplicativeExpression MultiplicativeExpression_267_Var
		 = (MultiplicativeExpression)Expr_266_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_267_Var
		);
		final EList<? extends EObject> Expr_267_list = MultiplicativeExpression_267_Var
		.getExpr();
		Assert.assertNotNull(Expr_267_list);
		Assert.assertEquals(1, Expr_267_list.size());
		//267
		final CastExpression CastExpression_268_Var
		 = (CastExpression)Expr_267_list.get(0);
		Assert.assertNotNull(CastExpression_268_Var
		);
		//268
		final UnaryExpression UnaryExpression_269_Var
		 = (UnaryExpression)CastExpression_268_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_269_Var
		);
		//269
		final PostfixExpression PostfixExpression_270_Var
		 = (PostfixExpression)UnaryExpression_269_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_270_Var
		);
		final EList<? extends EObject> Expr_270_list = PostfixExpression_270_Var
		.getExpr();
		Assert.assertNotNull(Expr_270_list);
		Assert.assertEquals(1, Expr_270_list.size());
		//270
		final PrimaryExpression PrimaryExpression_271_Var
		 = (PrimaryExpression)Expr_270_list.get(0);
		Assert.assertNotNull(PrimaryExpression_271_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_271_Var
		.getId());
		final EList<? extends EObject> Suffix_271_list = PostfixExpression_270_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_271_list);
		Assert.assertEquals(1, Suffix_271_list.size());
		//271
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_272_Var
		 = (PostfixExpressionSuffixArgument)Suffix_271_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_272_Var
		);
		//272
		final ArgumentExpressionList ArgumentExpressionList_273_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_272_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_273_Var
		);
		final EList<? extends EObject> Expr_273_list = ArgumentExpressionList_273_Var
		.getExpr();
		Assert.assertNotNull(Expr_273_list);
		Assert.assertEquals(2, Expr_273_list.size());
		//273
		final AssignmentExpression AssignmentExpression_274_Var
		 = (AssignmentExpression)Expr_273_list.get(0);
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
		Assert.assertEquals(1, Expr_277_list.size());
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
		Assert.assertEquals("[\"sizeof(joe)=%lu\\n\"]", PrimaryExpression_289_Var
		.getString().toString());
		//289
		final AssignmentExpression AssignmentExpression_290_Var
		 = (AssignmentExpression)Expr_273_list.get(1);
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
		//323
		final Statement Statement_324_Var
		 = (Statement)Statement_108_list.get(3);
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
		//349
		final Statement Statement_350_Var
		 = (Statement)Statement_108_list.get(4);
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
		Assert.assertEquals("[\"Phil Morrison\"]", PrimaryExpression_403_Var
		.getString().toString());
		//403
		final Statement Statement_404_Var
		 = (Statement)Statement_108_list.get(5);
		Assert.assertNotNull(Statement_404_Var
		);
		//404
		final ExpressionStatement ExpressionStatement_405_Var
		 = (ExpressionStatement)Statement_404_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_405_Var
		);
		//405
		final Expression Expression_406_Var
		 = (Expression)ExpressionStatement_405_Var
		.getExpression();
		Assert.assertNotNull(Expression_406_Var
		);
		final EList<? extends EObject> ExprExpr_406_list = Expression_406_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_406_list);
		Assert.assertEquals(1, ExprExpr_406_list.size());
		//406
		final AssignmentExpression AssignmentExpression_407_Var
		 = (AssignmentExpression)ExprExpr_406_list.get(0);
		Assert.assertNotNull(AssignmentExpression_407_Var
		);
		//407
		final ConditionalExpression ConditionalExpression_408_Var
		 = (ConditionalExpression)AssignmentExpression_407_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_408_Var
		);
		//408
		final LogicalOrExpression LogicalOrExpression_409_Var
		 = (LogicalOrExpression)ConditionalExpression_408_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_409_Var
		);
		final EList<? extends EObject> Expr_409_list = LogicalOrExpression_409_Var
		.getExpr();
		Assert.assertNotNull(Expr_409_list);
		Assert.assertEquals(1, Expr_409_list.size());
		//409
		final LogicalAndExpression LogicalAndExpression_410_Var
		 = (LogicalAndExpression)Expr_409_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_410_Var
		);
		final EList<? extends EObject> Expr_410_list = LogicalAndExpression_410_Var
		.getExpr();
		Assert.assertNotNull(Expr_410_list);
		Assert.assertEquals(1, Expr_410_list.size());
		//410
		final InclusiveOrExpression InclusiveOrExpression_411_Var
		 = (InclusiveOrExpression)Expr_410_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_411_Var
		);
		final EList<? extends EObject> Expr_411_list = InclusiveOrExpression_411_Var
		.getExpr();
		Assert.assertNotNull(Expr_411_list);
		Assert.assertEquals(1, Expr_411_list.size());
		//411
		final ExclusiveOrExpression ExclusiveOrExpression_412_Var
		 = (ExclusiveOrExpression)Expr_411_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_412_Var
		);
		final EList<? extends EObject> Expr_412_list = ExclusiveOrExpression_412_Var
		.getExpr();
		Assert.assertNotNull(Expr_412_list);
		Assert.assertEquals(1, Expr_412_list.size());
		//412
		final AndExpression AndExpression_413_Var
		 = (AndExpression)Expr_412_list.get(0);
		Assert.assertNotNull(AndExpression_413_Var
		);
		final EList<? extends EObject> Expr_413_list = AndExpression_413_Var
		.getExpr();
		Assert.assertNotNull(Expr_413_list);
		Assert.assertEquals(1, Expr_413_list.size());
		//413
		final EqualityExpression EqualityExpression_414_Var
		 = (EqualityExpression)Expr_413_list.get(0);
		Assert.assertNotNull(EqualityExpression_414_Var
		);
		final EList<? extends EObject> Expr_414_list = EqualityExpression_414_Var
		.getExpr();
		Assert.assertNotNull(Expr_414_list);
		Assert.assertEquals(1, Expr_414_list.size());
		//414
		final RelationalExpression RelationalExpression_415_Var
		 = (RelationalExpression)Expr_414_list.get(0);
		Assert.assertNotNull(RelationalExpression_415_Var
		);
		final EList<? extends EObject> Expr_415_list = RelationalExpression_415_Var
		.getExpr();
		Assert.assertNotNull(Expr_415_list);
		Assert.assertEquals(1, Expr_415_list.size());
		//415
		final ShiftExpression ShiftExpression_416_Var
		 = (ShiftExpression)Expr_415_list.get(0);
		Assert.assertNotNull(ShiftExpression_416_Var
		);
		final EList<? extends EObject> Expr_416_list = ShiftExpression_416_Var
		.getExpr();
		Assert.assertNotNull(Expr_416_list);
		Assert.assertEquals(1, Expr_416_list.size());
		//416
		final AdditiveExpression AdditiveExpression_417_Var
		 = (AdditiveExpression)Expr_416_list.get(0);
		Assert.assertNotNull(AdditiveExpression_417_Var
		);
		final EList<? extends EObject> Expr_417_list = AdditiveExpression_417_Var
		.getExpr();
		Assert.assertNotNull(Expr_417_list);
		Assert.assertEquals(1, Expr_417_list.size());
		//417
		final MultiplicativeExpression MultiplicativeExpression_418_Var
		 = (MultiplicativeExpression)Expr_417_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_418_Var
		);
		final EList<? extends EObject> Expr_418_list = MultiplicativeExpression_418_Var
		.getExpr();
		Assert.assertNotNull(Expr_418_list);
		Assert.assertEquals(1, Expr_418_list.size());
		//418
		final CastExpression CastExpression_419_Var
		 = (CastExpression)Expr_418_list.get(0);
		Assert.assertNotNull(CastExpression_419_Var
		);
		//419
		final UnaryExpression UnaryExpression_420_Var
		 = (UnaryExpression)CastExpression_419_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_420_Var
		);
		//420
		final PostfixExpression PostfixExpression_421_Var
		 = (PostfixExpression)UnaryExpression_420_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_421_Var
		);
		final EList<? extends EObject> Expr_421_list = PostfixExpression_421_Var
		.getExpr();
		Assert.assertNotNull(Expr_421_list);
		Assert.assertEquals(1, Expr_421_list.size());
		//421
		final PrimaryExpression PrimaryExpression_422_Var
		 = (PrimaryExpression)Expr_421_list.get(0);
		Assert.assertNotNull(PrimaryExpression_422_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_422_Var
		.getId());
		final EList<? extends EObject> Suffix_422_list = PostfixExpression_421_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_422_list);
		Assert.assertEquals(1, Suffix_422_list.size());
		//422
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_423_Var
		 = (PostfixExpressionSuffixArgument)Suffix_422_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_423_Var
		);
		//423
		final ArgumentExpressionList ArgumentExpressionList_424_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_423_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_424_Var
		);
		final EList<? extends EObject> Expr_424_list = ArgumentExpressionList_424_Var
		.getExpr();
		Assert.assertNotNull(Expr_424_list);
		Assert.assertEquals(2, Expr_424_list.size());
		//424
		final AssignmentExpression AssignmentExpression_425_Var
		 = (AssignmentExpression)Expr_424_list.get(0);
		Assert.assertNotNull(AssignmentExpression_425_Var
		);
		//425
		final ConditionalExpression ConditionalExpression_426_Var
		 = (ConditionalExpression)AssignmentExpression_425_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_426_Var
		);
		//426
		final LogicalOrExpression LogicalOrExpression_427_Var
		 = (LogicalOrExpression)ConditionalExpression_426_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_427_Var
		);
		final EList<? extends EObject> Expr_427_list = LogicalOrExpression_427_Var
		.getExpr();
		Assert.assertNotNull(Expr_427_list);
		Assert.assertEquals(1, Expr_427_list.size());
		//427
		final LogicalAndExpression LogicalAndExpression_428_Var
		 = (LogicalAndExpression)Expr_427_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_428_Var
		);
		final EList<? extends EObject> Expr_428_list = LogicalAndExpression_428_Var
		.getExpr();
		Assert.assertNotNull(Expr_428_list);
		Assert.assertEquals(1, Expr_428_list.size());
		//428
		final InclusiveOrExpression InclusiveOrExpression_429_Var
		 = (InclusiveOrExpression)Expr_428_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_429_Var
		);
		final EList<? extends EObject> Expr_429_list = InclusiveOrExpression_429_Var
		.getExpr();
		Assert.assertNotNull(Expr_429_list);
		Assert.assertEquals(1, Expr_429_list.size());
		//429
		final ExclusiveOrExpression ExclusiveOrExpression_430_Var
		 = (ExclusiveOrExpression)Expr_429_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_430_Var
		);
		final EList<? extends EObject> Expr_430_list = ExclusiveOrExpression_430_Var
		.getExpr();
		Assert.assertNotNull(Expr_430_list);
		Assert.assertEquals(1, Expr_430_list.size());
		//430
		final AndExpression AndExpression_431_Var
		 = (AndExpression)Expr_430_list.get(0);
		Assert.assertNotNull(AndExpression_431_Var
		);
		final EList<? extends EObject> Expr_431_list = AndExpression_431_Var
		.getExpr();
		Assert.assertNotNull(Expr_431_list);
		Assert.assertEquals(1, Expr_431_list.size());
		//431
		final EqualityExpression EqualityExpression_432_Var
		 = (EqualityExpression)Expr_431_list.get(0);
		Assert.assertNotNull(EqualityExpression_432_Var
		);
		final EList<? extends EObject> Expr_432_list = EqualityExpression_432_Var
		.getExpr();
		Assert.assertNotNull(Expr_432_list);
		Assert.assertEquals(1, Expr_432_list.size());
		//432
		final RelationalExpression RelationalExpression_433_Var
		 = (RelationalExpression)Expr_432_list.get(0);
		Assert.assertNotNull(RelationalExpression_433_Var
		);
		final EList<? extends EObject> Expr_433_list = RelationalExpression_433_Var
		.getExpr();
		Assert.assertNotNull(Expr_433_list);
		Assert.assertEquals(1, Expr_433_list.size());
		//433
		final ShiftExpression ShiftExpression_434_Var
		 = (ShiftExpression)Expr_433_list.get(0);
		Assert.assertNotNull(ShiftExpression_434_Var
		);
		final EList<? extends EObject> Expr_434_list = ShiftExpression_434_Var
		.getExpr();
		Assert.assertNotNull(Expr_434_list);
		Assert.assertEquals(1, Expr_434_list.size());
		//434
		final AdditiveExpression AdditiveExpression_435_Var
		 = (AdditiveExpression)Expr_434_list.get(0);
		Assert.assertNotNull(AdditiveExpression_435_Var
		);
		final EList<? extends EObject> Expr_435_list = AdditiveExpression_435_Var
		.getExpr();
		Assert.assertNotNull(Expr_435_list);
		Assert.assertEquals(1, Expr_435_list.size());
		//435
		final MultiplicativeExpression MultiplicativeExpression_436_Var
		 = (MultiplicativeExpression)Expr_435_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_436_Var
		);
		final EList<? extends EObject> Expr_436_list = MultiplicativeExpression_436_Var
		.getExpr();
		Assert.assertNotNull(Expr_436_list);
		Assert.assertEquals(1, Expr_436_list.size());
		//436
		final CastExpression CastExpression_437_Var
		 = (CastExpression)Expr_436_list.get(0);
		Assert.assertNotNull(CastExpression_437_Var
		);
		//437
		final UnaryExpression UnaryExpression_438_Var
		 = (UnaryExpression)CastExpression_437_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_438_Var
		);
		//438
		final PostfixExpression PostfixExpression_439_Var
		 = (PostfixExpression)UnaryExpression_438_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_439_Var
		);
		final EList<? extends EObject> Expr_439_list = PostfixExpression_439_Var
		.getExpr();
		Assert.assertNotNull(Expr_439_list);
		Assert.assertEquals(1, Expr_439_list.size());
		//439
		final PrimaryExpression PrimaryExpression_440_Var
		 = (PrimaryExpression)Expr_439_list.get(0);
		Assert.assertNotNull(PrimaryExpression_440_Var
		);
		Assert.assertEquals("[\"joe.id=%d\\n\"]", PrimaryExpression_440_Var
		.getString().toString());
		//440
		final AssignmentExpression AssignmentExpression_441_Var
		 = (AssignmentExpression)Expr_424_list.get(1);
		Assert.assertNotNull(AssignmentExpression_441_Var
		);
		//441
		final ConditionalExpression ConditionalExpression_442_Var
		 = (ConditionalExpression)AssignmentExpression_441_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_442_Var
		);
		//442
		final LogicalOrExpression LogicalOrExpression_443_Var
		 = (LogicalOrExpression)ConditionalExpression_442_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_443_Var
		);
		final EList<? extends EObject> Expr_443_list = LogicalOrExpression_443_Var
		.getExpr();
		Assert.assertNotNull(Expr_443_list);
		Assert.assertEquals(1, Expr_443_list.size());
		//443
		final LogicalAndExpression LogicalAndExpression_444_Var
		 = (LogicalAndExpression)Expr_443_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_444_Var
		);
		final EList<? extends EObject> Expr_444_list = LogicalAndExpression_444_Var
		.getExpr();
		Assert.assertNotNull(Expr_444_list);
		Assert.assertEquals(1, Expr_444_list.size());
		//444
		final InclusiveOrExpression InclusiveOrExpression_445_Var
		 = (InclusiveOrExpression)Expr_444_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_445_Var
		);
		final EList<? extends EObject> Expr_445_list = InclusiveOrExpression_445_Var
		.getExpr();
		Assert.assertNotNull(Expr_445_list);
		Assert.assertEquals(1, Expr_445_list.size());
		//445
		final ExclusiveOrExpression ExclusiveOrExpression_446_Var
		 = (ExclusiveOrExpression)Expr_445_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_446_Var
		);
		final EList<? extends EObject> Expr_446_list = ExclusiveOrExpression_446_Var
		.getExpr();
		Assert.assertNotNull(Expr_446_list);
		Assert.assertEquals(1, Expr_446_list.size());
		//446
		final AndExpression AndExpression_447_Var
		 = (AndExpression)Expr_446_list.get(0);
		Assert.assertNotNull(AndExpression_447_Var
		);
		final EList<? extends EObject> Expr_447_list = AndExpression_447_Var
		.getExpr();
		Assert.assertNotNull(Expr_447_list);
		Assert.assertEquals(1, Expr_447_list.size());
		//447
		final EqualityExpression EqualityExpression_448_Var
		 = (EqualityExpression)Expr_447_list.get(0);
		Assert.assertNotNull(EqualityExpression_448_Var
		);
		final EList<? extends EObject> Expr_448_list = EqualityExpression_448_Var
		.getExpr();
		Assert.assertNotNull(Expr_448_list);
		Assert.assertEquals(1, Expr_448_list.size());
		//448
		final RelationalExpression RelationalExpression_449_Var
		 = (RelationalExpression)Expr_448_list.get(0);
		Assert.assertNotNull(RelationalExpression_449_Var
		);
		final EList<? extends EObject> Expr_449_list = RelationalExpression_449_Var
		.getExpr();
		Assert.assertNotNull(Expr_449_list);
		Assert.assertEquals(1, Expr_449_list.size());
		//449
		final ShiftExpression ShiftExpression_450_Var
		 = (ShiftExpression)Expr_449_list.get(0);
		Assert.assertNotNull(ShiftExpression_450_Var
		);
		final EList<? extends EObject> Expr_450_list = ShiftExpression_450_Var
		.getExpr();
		Assert.assertNotNull(Expr_450_list);
		Assert.assertEquals(1, Expr_450_list.size());
		//450
		final AdditiveExpression AdditiveExpression_451_Var
		 = (AdditiveExpression)Expr_450_list.get(0);
		Assert.assertNotNull(AdditiveExpression_451_Var
		);
		final EList<? extends EObject> Expr_451_list = AdditiveExpression_451_Var
		.getExpr();
		Assert.assertNotNull(Expr_451_list);
		Assert.assertEquals(1, Expr_451_list.size());
		//451
		final MultiplicativeExpression MultiplicativeExpression_452_Var
		 = (MultiplicativeExpression)Expr_451_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_452_Var
		);
		final EList<? extends EObject> Expr_452_list = MultiplicativeExpression_452_Var
		.getExpr();
		Assert.assertNotNull(Expr_452_list);
		Assert.assertEquals(1, Expr_452_list.size());
		//452
		final CastExpression CastExpression_453_Var
		 = (CastExpression)Expr_452_list.get(0);
		Assert.assertNotNull(CastExpression_453_Var
		);
		//453
		final UnaryExpression UnaryExpression_454_Var
		 = (UnaryExpression)CastExpression_453_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_454_Var
		);
		//454
		final PostfixExpression PostfixExpression_455_Var
		 = (PostfixExpression)UnaryExpression_454_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_455_Var
		);
		final EList<? extends EObject> Expr_455_list = PostfixExpression_455_Var
		.getExpr();
		Assert.assertNotNull(Expr_455_list);
		Assert.assertEquals(1, Expr_455_list.size());
		//455
		final PrimaryExpression PrimaryExpression_456_Var
		 = (PrimaryExpression)Expr_455_list.get(0);
		Assert.assertNotNull(PrimaryExpression_456_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_456_Var
		.getId());
		final EList<? extends EObject> Suffix_456_list = PostfixExpression_455_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_456_list);
		Assert.assertEquals(1, Suffix_456_list.size());
		//456
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_457_Var
		 = (PostfixExpressionSuffixDot)Suffix_456_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_457_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_457_Var
		.getId());
		//457
		final Statement Statement_458_Var
		 = (Statement)Statement_108_list.get(6);
		Assert.assertNotNull(Statement_458_Var
		);
		//458
		final ExpressionStatement ExpressionStatement_459_Var
		 = (ExpressionStatement)Statement_458_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_459_Var
		);
		//459
		final Expression Expression_460_Var
		 = (Expression)ExpressionStatement_459_Var
		.getExpression();
		Assert.assertNotNull(Expression_460_Var
		);
		final EList<? extends EObject> ExprExpr_460_list = Expression_460_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_460_list);
		Assert.assertEquals(1, ExprExpr_460_list.size());
		//460
		final AssignmentExpression AssignmentExpression_461_Var
		 = (AssignmentExpression)ExprExpr_460_list.get(0);
		Assert.assertNotNull(AssignmentExpression_461_Var
		);
		//461
		final ConditionalExpression ConditionalExpression_462_Var
		 = (ConditionalExpression)AssignmentExpression_461_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_462_Var
		);
		//462
		final LogicalOrExpression LogicalOrExpression_463_Var
		 = (LogicalOrExpression)ConditionalExpression_462_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_463_Var
		);
		final EList<? extends EObject> Expr_463_list = LogicalOrExpression_463_Var
		.getExpr();
		Assert.assertNotNull(Expr_463_list);
		Assert.assertEquals(1, Expr_463_list.size());
		//463
		final LogicalAndExpression LogicalAndExpression_464_Var
		 = (LogicalAndExpression)Expr_463_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_464_Var
		);
		final EList<? extends EObject> Expr_464_list = LogicalAndExpression_464_Var
		.getExpr();
		Assert.assertNotNull(Expr_464_list);
		Assert.assertEquals(1, Expr_464_list.size());
		//464
		final InclusiveOrExpression InclusiveOrExpression_465_Var
		 = (InclusiveOrExpression)Expr_464_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_465_Var
		);
		final EList<? extends EObject> Expr_465_list = InclusiveOrExpression_465_Var
		.getExpr();
		Assert.assertNotNull(Expr_465_list);
		Assert.assertEquals(1, Expr_465_list.size());
		//465
		final ExclusiveOrExpression ExclusiveOrExpression_466_Var
		 = (ExclusiveOrExpression)Expr_465_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_466_Var
		);
		final EList<? extends EObject> Expr_466_list = ExclusiveOrExpression_466_Var
		.getExpr();
		Assert.assertNotNull(Expr_466_list);
		Assert.assertEquals(1, Expr_466_list.size());
		//466
		final AndExpression AndExpression_467_Var
		 = (AndExpression)Expr_466_list.get(0);
		Assert.assertNotNull(AndExpression_467_Var
		);
		final EList<? extends EObject> Expr_467_list = AndExpression_467_Var
		.getExpr();
		Assert.assertNotNull(Expr_467_list);
		Assert.assertEquals(1, Expr_467_list.size());
		//467
		final EqualityExpression EqualityExpression_468_Var
		 = (EqualityExpression)Expr_467_list.get(0);
		Assert.assertNotNull(EqualityExpression_468_Var
		);
		final EList<? extends EObject> Expr_468_list = EqualityExpression_468_Var
		.getExpr();
		Assert.assertNotNull(Expr_468_list);
		Assert.assertEquals(1, Expr_468_list.size());
		//468
		final RelationalExpression RelationalExpression_469_Var
		 = (RelationalExpression)Expr_468_list.get(0);
		Assert.assertNotNull(RelationalExpression_469_Var
		);
		final EList<? extends EObject> Expr_469_list = RelationalExpression_469_Var
		.getExpr();
		Assert.assertNotNull(Expr_469_list);
		Assert.assertEquals(1, Expr_469_list.size());
		//469
		final ShiftExpression ShiftExpression_470_Var
		 = (ShiftExpression)Expr_469_list.get(0);
		Assert.assertNotNull(ShiftExpression_470_Var
		);
		final EList<? extends EObject> Expr_470_list = ShiftExpression_470_Var
		.getExpr();
		Assert.assertNotNull(Expr_470_list);
		Assert.assertEquals(1, Expr_470_list.size());
		//470
		final AdditiveExpression AdditiveExpression_471_Var
		 = (AdditiveExpression)Expr_470_list.get(0);
		Assert.assertNotNull(AdditiveExpression_471_Var
		);
		final EList<? extends EObject> Expr_471_list = AdditiveExpression_471_Var
		.getExpr();
		Assert.assertNotNull(Expr_471_list);
		Assert.assertEquals(1, Expr_471_list.size());
		//471
		final MultiplicativeExpression MultiplicativeExpression_472_Var
		 = (MultiplicativeExpression)Expr_471_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_472_Var
		);
		final EList<? extends EObject> Expr_472_list = MultiplicativeExpression_472_Var
		.getExpr();
		Assert.assertNotNull(Expr_472_list);
		Assert.assertEquals(1, Expr_472_list.size());
		//472
		final CastExpression CastExpression_473_Var
		 = (CastExpression)Expr_472_list.get(0);
		Assert.assertNotNull(CastExpression_473_Var
		);
		//473
		final UnaryExpression UnaryExpression_474_Var
		 = (UnaryExpression)CastExpression_473_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_474_Var
		);
		//474
		final PostfixExpression PostfixExpression_475_Var
		 = (PostfixExpression)UnaryExpression_474_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_475_Var
		);
		final EList<? extends EObject> Expr_475_list = PostfixExpression_475_Var
		.getExpr();
		Assert.assertNotNull(Expr_475_list);
		Assert.assertEquals(1, Expr_475_list.size());
		//475
		final PrimaryExpression PrimaryExpression_476_Var
		 = (PrimaryExpression)Expr_475_list.get(0);
		Assert.assertNotNull(PrimaryExpression_476_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_476_Var
		.getId());
		final EList<? extends EObject> Suffix_476_list = PostfixExpression_475_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_476_list);
		Assert.assertEquals(1, Suffix_476_list.size());
		//476
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_477_Var
		 = (PostfixExpressionSuffixArgument)Suffix_476_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_477_Var
		);
		//477
		final ArgumentExpressionList ArgumentExpressionList_478_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_477_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_478_Var
		);
		final EList<? extends EObject> Expr_478_list = ArgumentExpressionList_478_Var
		.getExpr();
		Assert.assertNotNull(Expr_478_list);
		Assert.assertEquals(2, Expr_478_list.size());
		//478
		final AssignmentExpression AssignmentExpression_479_Var
		 = (AssignmentExpression)Expr_478_list.get(0);
		Assert.assertNotNull(AssignmentExpression_479_Var
		);
		//479
		final ConditionalExpression ConditionalExpression_480_Var
		 = (ConditionalExpression)AssignmentExpression_479_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_480_Var
		);
		//480
		final LogicalOrExpression LogicalOrExpression_481_Var
		 = (LogicalOrExpression)ConditionalExpression_480_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_481_Var
		);
		final EList<? extends EObject> Expr_481_list = LogicalOrExpression_481_Var
		.getExpr();
		Assert.assertNotNull(Expr_481_list);
		Assert.assertEquals(1, Expr_481_list.size());
		//481
		final LogicalAndExpression LogicalAndExpression_482_Var
		 = (LogicalAndExpression)Expr_481_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_482_Var
		);
		final EList<? extends EObject> Expr_482_list = LogicalAndExpression_482_Var
		.getExpr();
		Assert.assertNotNull(Expr_482_list);
		Assert.assertEquals(1, Expr_482_list.size());
		//482
		final InclusiveOrExpression InclusiveOrExpression_483_Var
		 = (InclusiveOrExpression)Expr_482_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_483_Var
		);
		final EList<? extends EObject> Expr_483_list = InclusiveOrExpression_483_Var
		.getExpr();
		Assert.assertNotNull(Expr_483_list);
		Assert.assertEquals(1, Expr_483_list.size());
		//483
		final ExclusiveOrExpression ExclusiveOrExpression_484_Var
		 = (ExclusiveOrExpression)Expr_483_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_484_Var
		);
		final EList<? extends EObject> Expr_484_list = ExclusiveOrExpression_484_Var
		.getExpr();
		Assert.assertNotNull(Expr_484_list);
		Assert.assertEquals(1, Expr_484_list.size());
		//484
		final AndExpression AndExpression_485_Var
		 = (AndExpression)Expr_484_list.get(0);
		Assert.assertNotNull(AndExpression_485_Var
		);
		final EList<? extends EObject> Expr_485_list = AndExpression_485_Var
		.getExpr();
		Assert.assertNotNull(Expr_485_list);
		Assert.assertEquals(1, Expr_485_list.size());
		//485
		final EqualityExpression EqualityExpression_486_Var
		 = (EqualityExpression)Expr_485_list.get(0);
		Assert.assertNotNull(EqualityExpression_486_Var
		);
		final EList<? extends EObject> Expr_486_list = EqualityExpression_486_Var
		.getExpr();
		Assert.assertNotNull(Expr_486_list);
		Assert.assertEquals(1, Expr_486_list.size());
		//486
		final RelationalExpression RelationalExpression_487_Var
		 = (RelationalExpression)Expr_486_list.get(0);
		Assert.assertNotNull(RelationalExpression_487_Var
		);
		final EList<? extends EObject> Expr_487_list = RelationalExpression_487_Var
		.getExpr();
		Assert.assertNotNull(Expr_487_list);
		Assert.assertEquals(1, Expr_487_list.size());
		//487
		final ShiftExpression ShiftExpression_488_Var
		 = (ShiftExpression)Expr_487_list.get(0);
		Assert.assertNotNull(ShiftExpression_488_Var
		);
		final EList<? extends EObject> Expr_488_list = ShiftExpression_488_Var
		.getExpr();
		Assert.assertNotNull(Expr_488_list);
		Assert.assertEquals(1, Expr_488_list.size());
		//488
		final AdditiveExpression AdditiveExpression_489_Var
		 = (AdditiveExpression)Expr_488_list.get(0);
		Assert.assertNotNull(AdditiveExpression_489_Var
		);
		final EList<? extends EObject> Expr_489_list = AdditiveExpression_489_Var
		.getExpr();
		Assert.assertNotNull(Expr_489_list);
		Assert.assertEquals(1, Expr_489_list.size());
		//489
		final MultiplicativeExpression MultiplicativeExpression_490_Var
		 = (MultiplicativeExpression)Expr_489_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_490_Var
		);
		final EList<? extends EObject> Expr_490_list = MultiplicativeExpression_490_Var
		.getExpr();
		Assert.assertNotNull(Expr_490_list);
		Assert.assertEquals(1, Expr_490_list.size());
		//490
		final CastExpression CastExpression_491_Var
		 = (CastExpression)Expr_490_list.get(0);
		Assert.assertNotNull(CastExpression_491_Var
		);
		//491
		final UnaryExpression UnaryExpression_492_Var
		 = (UnaryExpression)CastExpression_491_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_492_Var
		);
		//492
		final PostfixExpression PostfixExpression_493_Var
		 = (PostfixExpression)UnaryExpression_492_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_493_Var
		);
		final EList<? extends EObject> Expr_493_list = PostfixExpression_493_Var
		.getExpr();
		Assert.assertNotNull(Expr_493_list);
		Assert.assertEquals(1, Expr_493_list.size());
		//493
		final PrimaryExpression PrimaryExpression_494_Var
		 = (PrimaryExpression)Expr_493_list.get(0);
		Assert.assertNotNull(PrimaryExpression_494_Var
		);
		Assert.assertEquals("[\"joe.name=%s\\n\"]", PrimaryExpression_494_Var
		.getString().toString());
		//494
		final AssignmentExpression AssignmentExpression_495_Var
		 = (AssignmentExpression)Expr_478_list.get(1);
		Assert.assertNotNull(AssignmentExpression_495_Var
		);
		//495
		final ConditionalExpression ConditionalExpression_496_Var
		 = (ConditionalExpression)AssignmentExpression_495_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_496_Var
		);
		//496
		final LogicalOrExpression LogicalOrExpression_497_Var
		 = (LogicalOrExpression)ConditionalExpression_496_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_497_Var
		);
		final EList<? extends EObject> Expr_497_list = LogicalOrExpression_497_Var
		.getExpr();
		Assert.assertNotNull(Expr_497_list);
		Assert.assertEquals(1, Expr_497_list.size());
		//497
		final LogicalAndExpression LogicalAndExpression_498_Var
		 = (LogicalAndExpression)Expr_497_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_498_Var
		);
		final EList<? extends EObject> Expr_498_list = LogicalAndExpression_498_Var
		.getExpr();
		Assert.assertNotNull(Expr_498_list);
		Assert.assertEquals(1, Expr_498_list.size());
		//498
		final InclusiveOrExpression InclusiveOrExpression_499_Var
		 = (InclusiveOrExpression)Expr_498_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_499_Var
		);
		final EList<? extends EObject> Expr_499_list = InclusiveOrExpression_499_Var
		.getExpr();
		Assert.assertNotNull(Expr_499_list);
		Assert.assertEquals(1, Expr_499_list.size());
		//499
		final ExclusiveOrExpression ExclusiveOrExpression_500_Var
		 = (ExclusiveOrExpression)Expr_499_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_500_Var
		);
		final EList<? extends EObject> Expr_500_list = ExclusiveOrExpression_500_Var
		.getExpr();
		Assert.assertNotNull(Expr_500_list);
		Assert.assertEquals(1, Expr_500_list.size());
		//500
		final AndExpression AndExpression_501_Var
		 = (AndExpression)Expr_500_list.get(0);
		Assert.assertNotNull(AndExpression_501_Var
		);
		final EList<? extends EObject> Expr_501_list = AndExpression_501_Var
		.getExpr();
		Assert.assertNotNull(Expr_501_list);
		Assert.assertEquals(1, Expr_501_list.size());
		//501
		final EqualityExpression EqualityExpression_502_Var
		 = (EqualityExpression)Expr_501_list.get(0);
		Assert.assertNotNull(EqualityExpression_502_Var
		);
		final EList<? extends EObject> Expr_502_list = EqualityExpression_502_Var
		.getExpr();
		Assert.assertNotNull(Expr_502_list);
		Assert.assertEquals(1, Expr_502_list.size());
		//502
		final RelationalExpression RelationalExpression_503_Var
		 = (RelationalExpression)Expr_502_list.get(0);
		Assert.assertNotNull(RelationalExpression_503_Var
		);
		final EList<? extends EObject> Expr_503_list = RelationalExpression_503_Var
		.getExpr();
		Assert.assertNotNull(Expr_503_list);
		Assert.assertEquals(1, Expr_503_list.size());
		//503
		final ShiftExpression ShiftExpression_504_Var
		 = (ShiftExpression)Expr_503_list.get(0);
		Assert.assertNotNull(ShiftExpression_504_Var
		);
		final EList<? extends EObject> Expr_504_list = ShiftExpression_504_Var
		.getExpr();
		Assert.assertNotNull(Expr_504_list);
		Assert.assertEquals(1, Expr_504_list.size());
		//504
		final AdditiveExpression AdditiveExpression_505_Var
		 = (AdditiveExpression)Expr_504_list.get(0);
		Assert.assertNotNull(AdditiveExpression_505_Var
		);
		final EList<? extends EObject> Expr_505_list = AdditiveExpression_505_Var
		.getExpr();
		Assert.assertNotNull(Expr_505_list);
		Assert.assertEquals(1, Expr_505_list.size());
		//505
		final MultiplicativeExpression MultiplicativeExpression_506_Var
		 = (MultiplicativeExpression)Expr_505_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_506_Var
		);
		final EList<? extends EObject> Expr_506_list = MultiplicativeExpression_506_Var
		.getExpr();
		Assert.assertNotNull(Expr_506_list);
		Assert.assertEquals(1, Expr_506_list.size());
		//506
		final CastExpression CastExpression_507_Var
		 = (CastExpression)Expr_506_list.get(0);
		Assert.assertNotNull(CastExpression_507_Var
		);
		//507
		final UnaryExpression UnaryExpression_508_Var
		 = (UnaryExpression)CastExpression_507_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_508_Var
		);
		//508
		final PostfixExpression PostfixExpression_509_Var
		 = (PostfixExpression)UnaryExpression_508_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_509_Var
		);
		final EList<? extends EObject> Expr_509_list = PostfixExpression_509_Var
		.getExpr();
		Assert.assertNotNull(Expr_509_list);
		Assert.assertEquals(1, Expr_509_list.size());
		//509
		final PrimaryExpression PrimaryExpression_510_Var
		 = (PrimaryExpression)Expr_509_list.get(0);
		Assert.assertNotNull(PrimaryExpression_510_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_510_Var
		.getId());
		final EList<? extends EObject> Suffix_510_list = PostfixExpression_509_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_510_list);
		Assert.assertEquals(1, Suffix_510_list.size());
		//510
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_511_Var
		 = (PostfixExpressionSuffixDot)Suffix_510_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_511_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_511_Var
		.getId());
		//511
		final Statement Statement_512_Var
		 = (Statement)Statement_108_list.get(7);
		Assert.assertNotNull(Statement_512_Var
		);
		//512
		final ExpressionStatement ExpressionStatement_513_Var
		 = (ExpressionStatement)Statement_512_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_513_Var
		);
		//513
		final Expression Expression_514_Var
		 = (Expression)ExpressionStatement_513_Var
		.getExpression();
		Assert.assertNotNull(Expression_514_Var
		);
		final EList<? extends EObject> ExprExpr_514_list = Expression_514_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_514_list);
		Assert.assertEquals(1, ExprExpr_514_list.size());
		//514
		final AssignmentExpression AssignmentExpression_515_Var
		 = (AssignmentExpression)ExprExpr_514_list.get(0);
		Assert.assertNotNull(AssignmentExpression_515_Var
		);
		//515
		final ConditionalExpression ConditionalExpression_516_Var
		 = (ConditionalExpression)AssignmentExpression_515_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_516_Var
		);
		//516
		final LogicalOrExpression LogicalOrExpression_517_Var
		 = (LogicalOrExpression)ConditionalExpression_516_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_517_Var
		);
		final EList<? extends EObject> Expr_517_list = LogicalOrExpression_517_Var
		.getExpr();
		Assert.assertNotNull(Expr_517_list);
		Assert.assertEquals(1, Expr_517_list.size());
		//517
		final LogicalAndExpression LogicalAndExpression_518_Var
		 = (LogicalAndExpression)Expr_517_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_518_Var
		);
		final EList<? extends EObject> Expr_518_list = LogicalAndExpression_518_Var
		.getExpr();
		Assert.assertNotNull(Expr_518_list);
		Assert.assertEquals(1, Expr_518_list.size());
		//518
		final InclusiveOrExpression InclusiveOrExpression_519_Var
		 = (InclusiveOrExpression)Expr_518_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_519_Var
		);
		final EList<? extends EObject> Expr_519_list = InclusiveOrExpression_519_Var
		.getExpr();
		Assert.assertNotNull(Expr_519_list);
		Assert.assertEquals(1, Expr_519_list.size());
		//519
		final ExclusiveOrExpression ExclusiveOrExpression_520_Var
		 = (ExclusiveOrExpression)Expr_519_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_520_Var
		);
		final EList<? extends EObject> Expr_520_list = ExclusiveOrExpression_520_Var
		.getExpr();
		Assert.assertNotNull(Expr_520_list);
		Assert.assertEquals(1, Expr_520_list.size());
		//520
		final AndExpression AndExpression_521_Var
		 = (AndExpression)Expr_520_list.get(0);
		Assert.assertNotNull(AndExpression_521_Var
		);
		final EList<? extends EObject> Expr_521_list = AndExpression_521_Var
		.getExpr();
		Assert.assertNotNull(Expr_521_list);
		Assert.assertEquals(1, Expr_521_list.size());
		//521
		final EqualityExpression EqualityExpression_522_Var
		 = (EqualityExpression)Expr_521_list.get(0);
		Assert.assertNotNull(EqualityExpression_522_Var
		);
		final EList<? extends EObject> Expr_522_list = EqualityExpression_522_Var
		.getExpr();
		Assert.assertNotNull(Expr_522_list);
		Assert.assertEquals(1, Expr_522_list.size());
		//522
		final RelationalExpression RelationalExpression_523_Var
		 = (RelationalExpression)Expr_522_list.get(0);
		Assert.assertNotNull(RelationalExpression_523_Var
		);
		final EList<? extends EObject> Expr_523_list = RelationalExpression_523_Var
		.getExpr();
		Assert.assertNotNull(Expr_523_list);
		Assert.assertEquals(1, Expr_523_list.size());
		//523
		final ShiftExpression ShiftExpression_524_Var
		 = (ShiftExpression)Expr_523_list.get(0);
		Assert.assertNotNull(ShiftExpression_524_Var
		);
		final EList<? extends EObject> Expr_524_list = ShiftExpression_524_Var
		.getExpr();
		Assert.assertNotNull(Expr_524_list);
		Assert.assertEquals(1, Expr_524_list.size());
		//524
		final AdditiveExpression AdditiveExpression_525_Var
		 = (AdditiveExpression)Expr_524_list.get(0);
		Assert.assertNotNull(AdditiveExpression_525_Var
		);
		final EList<? extends EObject> Expr_525_list = AdditiveExpression_525_Var
		.getExpr();
		Assert.assertNotNull(Expr_525_list);
		Assert.assertEquals(1, Expr_525_list.size());
		//525
		final MultiplicativeExpression MultiplicativeExpression_526_Var
		 = (MultiplicativeExpression)Expr_525_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_526_Var
		);
		final EList<? extends EObject> Expr_526_list = MultiplicativeExpression_526_Var
		.getExpr();
		Assert.assertNotNull(Expr_526_list);
		Assert.assertEquals(1, Expr_526_list.size());
		//526
		final CastExpression CastExpression_527_Var
		 = (CastExpression)Expr_526_list.get(0);
		Assert.assertNotNull(CastExpression_527_Var
		);
		//527
		final UnaryExpression UnaryExpression_528_Var
		 = (UnaryExpression)CastExpression_527_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_528_Var
		);
		//528
		final PostfixExpression PostfixExpression_529_Var
		 = (PostfixExpression)UnaryExpression_528_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_529_Var
		);
		final EList<? extends EObject> Expr_529_list = PostfixExpression_529_Var
		.getExpr();
		Assert.assertNotNull(Expr_529_list);
		Assert.assertEquals(1, Expr_529_list.size());
		//529
		final PrimaryExpression PrimaryExpression_530_Var
		 = (PrimaryExpression)Expr_529_list.get(0);
		Assert.assertNotNull(PrimaryExpression_530_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_530_Var
		.getId());
		final EList<? extends EObject> Suffix_530_list = PostfixExpression_529_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_530_list);
		Assert.assertEquals(1, Suffix_530_list.size());
		//530
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_531_Var
		 = (PostfixExpressionSuffixArgument)Suffix_530_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_531_Var
		);
		//531
		final ArgumentExpressionList ArgumentExpressionList_532_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_531_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_532_Var
		);
		final EList<? extends EObject> Expr_532_list = ArgumentExpressionList_532_Var
		.getExpr();
		Assert.assertNotNull(Expr_532_list);
		Assert.assertEquals(2, Expr_532_list.size());
		//532
		final AssignmentExpression AssignmentExpression_533_Var
		 = (AssignmentExpression)Expr_532_list.get(0);
		Assert.assertNotNull(AssignmentExpression_533_Var
		);
		//533
		final ConditionalExpression ConditionalExpression_534_Var
		 = (ConditionalExpression)AssignmentExpression_533_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_534_Var
		);
		//534
		final LogicalOrExpression LogicalOrExpression_535_Var
		 = (LogicalOrExpression)ConditionalExpression_534_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_535_Var
		);
		final EList<? extends EObject> Expr_535_list = LogicalOrExpression_535_Var
		.getExpr();
		Assert.assertNotNull(Expr_535_list);
		Assert.assertEquals(1, Expr_535_list.size());
		//535
		final LogicalAndExpression LogicalAndExpression_536_Var
		 = (LogicalAndExpression)Expr_535_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_536_Var
		);
		final EList<? extends EObject> Expr_536_list = LogicalAndExpression_536_Var
		.getExpr();
		Assert.assertNotNull(Expr_536_list);
		Assert.assertEquals(1, Expr_536_list.size());
		//536
		final InclusiveOrExpression InclusiveOrExpression_537_Var
		 = (InclusiveOrExpression)Expr_536_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_537_Var
		);
		final EList<? extends EObject> Expr_537_list = InclusiveOrExpression_537_Var
		.getExpr();
		Assert.assertNotNull(Expr_537_list);
		Assert.assertEquals(1, Expr_537_list.size());
		//537
		final ExclusiveOrExpression ExclusiveOrExpression_538_Var
		 = (ExclusiveOrExpression)Expr_537_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_538_Var
		);
		final EList<? extends EObject> Expr_538_list = ExclusiveOrExpression_538_Var
		.getExpr();
		Assert.assertNotNull(Expr_538_list);
		Assert.assertEquals(1, Expr_538_list.size());
		//538
		final AndExpression AndExpression_539_Var
		 = (AndExpression)Expr_538_list.get(0);
		Assert.assertNotNull(AndExpression_539_Var
		);
		final EList<? extends EObject> Expr_539_list = AndExpression_539_Var
		.getExpr();
		Assert.assertNotNull(Expr_539_list);
		Assert.assertEquals(1, Expr_539_list.size());
		//539
		final EqualityExpression EqualityExpression_540_Var
		 = (EqualityExpression)Expr_539_list.get(0);
		Assert.assertNotNull(EqualityExpression_540_Var
		);
		final EList<? extends EObject> Expr_540_list = EqualityExpression_540_Var
		.getExpr();
		Assert.assertNotNull(Expr_540_list);
		Assert.assertEquals(1, Expr_540_list.size());
		//540
		final RelationalExpression RelationalExpression_541_Var
		 = (RelationalExpression)Expr_540_list.get(0);
		Assert.assertNotNull(RelationalExpression_541_Var
		);
		final EList<? extends EObject> Expr_541_list = RelationalExpression_541_Var
		.getExpr();
		Assert.assertNotNull(Expr_541_list);
		Assert.assertEquals(1, Expr_541_list.size());
		//541
		final ShiftExpression ShiftExpression_542_Var
		 = (ShiftExpression)Expr_541_list.get(0);
		Assert.assertNotNull(ShiftExpression_542_Var
		);
		final EList<? extends EObject> Expr_542_list = ShiftExpression_542_Var
		.getExpr();
		Assert.assertNotNull(Expr_542_list);
		Assert.assertEquals(1, Expr_542_list.size());
		//542
		final AdditiveExpression AdditiveExpression_543_Var
		 = (AdditiveExpression)Expr_542_list.get(0);
		Assert.assertNotNull(AdditiveExpression_543_Var
		);
		final EList<? extends EObject> Expr_543_list = AdditiveExpression_543_Var
		.getExpr();
		Assert.assertNotNull(Expr_543_list);
		Assert.assertEquals(1, Expr_543_list.size());
		//543
		final MultiplicativeExpression MultiplicativeExpression_544_Var
		 = (MultiplicativeExpression)Expr_543_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_544_Var
		);
		final EList<? extends EObject> Expr_544_list = MultiplicativeExpression_544_Var
		.getExpr();
		Assert.assertNotNull(Expr_544_list);
		Assert.assertEquals(1, Expr_544_list.size());
		//544
		final CastExpression CastExpression_545_Var
		 = (CastExpression)Expr_544_list.get(0);
		Assert.assertNotNull(CastExpression_545_Var
		);
		//545
		final UnaryExpression UnaryExpression_546_Var
		 = (UnaryExpression)CastExpression_545_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_546_Var
		);
		//546
		final PostfixExpression PostfixExpression_547_Var
		 = (PostfixExpression)UnaryExpression_546_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_547_Var
		);
		final EList<? extends EObject> Expr_547_list = PostfixExpression_547_Var
		.getExpr();
		Assert.assertNotNull(Expr_547_list);
		Assert.assertEquals(1, Expr_547_list.size());
		//547
		final PrimaryExpression PrimaryExpression_548_Var
		 = (PrimaryExpression)Expr_547_list.get(0);
		Assert.assertNotNull(PrimaryExpression_548_Var
		);
		Assert.assertEquals("[\"phil.id=%d\\n\"]", PrimaryExpression_548_Var
		.getString().toString());
		//548
		final AssignmentExpression AssignmentExpression_549_Var
		 = (AssignmentExpression)Expr_532_list.get(1);
		Assert.assertNotNull(AssignmentExpression_549_Var
		);
		//549
		final ConditionalExpression ConditionalExpression_550_Var
		 = (ConditionalExpression)AssignmentExpression_549_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_550_Var
		);
		//550
		final LogicalOrExpression LogicalOrExpression_551_Var
		 = (LogicalOrExpression)ConditionalExpression_550_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_551_Var
		);
		final EList<? extends EObject> Expr_551_list = LogicalOrExpression_551_Var
		.getExpr();
		Assert.assertNotNull(Expr_551_list);
		Assert.assertEquals(1, Expr_551_list.size());
		//551
		final LogicalAndExpression LogicalAndExpression_552_Var
		 = (LogicalAndExpression)Expr_551_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_552_Var
		);
		final EList<? extends EObject> Expr_552_list = LogicalAndExpression_552_Var
		.getExpr();
		Assert.assertNotNull(Expr_552_list);
		Assert.assertEquals(1, Expr_552_list.size());
		//552
		final InclusiveOrExpression InclusiveOrExpression_553_Var
		 = (InclusiveOrExpression)Expr_552_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_553_Var
		);
		final EList<? extends EObject> Expr_553_list = InclusiveOrExpression_553_Var
		.getExpr();
		Assert.assertNotNull(Expr_553_list);
		Assert.assertEquals(1, Expr_553_list.size());
		//553
		final ExclusiveOrExpression ExclusiveOrExpression_554_Var
		 = (ExclusiveOrExpression)Expr_553_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_554_Var
		);
		final EList<? extends EObject> Expr_554_list = ExclusiveOrExpression_554_Var
		.getExpr();
		Assert.assertNotNull(Expr_554_list);
		Assert.assertEquals(1, Expr_554_list.size());
		//554
		final AndExpression AndExpression_555_Var
		 = (AndExpression)Expr_554_list.get(0);
		Assert.assertNotNull(AndExpression_555_Var
		);
		final EList<? extends EObject> Expr_555_list = AndExpression_555_Var
		.getExpr();
		Assert.assertNotNull(Expr_555_list);
		Assert.assertEquals(1, Expr_555_list.size());
		//555
		final EqualityExpression EqualityExpression_556_Var
		 = (EqualityExpression)Expr_555_list.get(0);
		Assert.assertNotNull(EqualityExpression_556_Var
		);
		final EList<? extends EObject> Expr_556_list = EqualityExpression_556_Var
		.getExpr();
		Assert.assertNotNull(Expr_556_list);
		Assert.assertEquals(1, Expr_556_list.size());
		//556
		final RelationalExpression RelationalExpression_557_Var
		 = (RelationalExpression)Expr_556_list.get(0);
		Assert.assertNotNull(RelationalExpression_557_Var
		);
		final EList<? extends EObject> Expr_557_list = RelationalExpression_557_Var
		.getExpr();
		Assert.assertNotNull(Expr_557_list);
		Assert.assertEquals(1, Expr_557_list.size());
		//557
		final ShiftExpression ShiftExpression_558_Var
		 = (ShiftExpression)Expr_557_list.get(0);
		Assert.assertNotNull(ShiftExpression_558_Var
		);
		final EList<? extends EObject> Expr_558_list = ShiftExpression_558_Var
		.getExpr();
		Assert.assertNotNull(Expr_558_list);
		Assert.assertEquals(1, Expr_558_list.size());
		//558
		final AdditiveExpression AdditiveExpression_559_Var
		 = (AdditiveExpression)Expr_558_list.get(0);
		Assert.assertNotNull(AdditiveExpression_559_Var
		);
		final EList<? extends EObject> Expr_559_list = AdditiveExpression_559_Var
		.getExpr();
		Assert.assertNotNull(Expr_559_list);
		Assert.assertEquals(1, Expr_559_list.size());
		//559
		final MultiplicativeExpression MultiplicativeExpression_560_Var
		 = (MultiplicativeExpression)Expr_559_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_560_Var
		);
		final EList<? extends EObject> Expr_560_list = MultiplicativeExpression_560_Var
		.getExpr();
		Assert.assertNotNull(Expr_560_list);
		Assert.assertEquals(1, Expr_560_list.size());
		//560
		final CastExpression CastExpression_561_Var
		 = (CastExpression)Expr_560_list.get(0);
		Assert.assertNotNull(CastExpression_561_Var
		);
		//561
		final UnaryExpression UnaryExpression_562_Var
		 = (UnaryExpression)CastExpression_561_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_562_Var
		);
		//562
		final PostfixExpression PostfixExpression_563_Var
		 = (PostfixExpression)UnaryExpression_562_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_563_Var
		);
		final EList<? extends EObject> Expr_563_list = PostfixExpression_563_Var
		.getExpr();
		Assert.assertNotNull(Expr_563_list);
		Assert.assertEquals(1, Expr_563_list.size());
		//563
		final PrimaryExpression PrimaryExpression_564_Var
		 = (PrimaryExpression)Expr_563_list.get(0);
		Assert.assertNotNull(PrimaryExpression_564_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_564_Var
		.getId());
		final EList<? extends EObject> Suffix_564_list = PostfixExpression_563_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_564_list);
		Assert.assertEquals(1, Suffix_564_list.size());
		//564
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_565_Var
		 = (PostfixExpressionSuffixDot)Suffix_564_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_565_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_565_Var
		.getId());
		//565
		final Statement Statement_566_Var
		 = (Statement)Statement_108_list.get(8);
		Assert.assertNotNull(Statement_566_Var
		);
		//566
		final ExpressionStatement ExpressionStatement_567_Var
		 = (ExpressionStatement)Statement_566_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_567_Var
		);
		//567
		final Expression Expression_568_Var
		 = (Expression)ExpressionStatement_567_Var
		.getExpression();
		Assert.assertNotNull(Expression_568_Var
		);
		final EList<? extends EObject> ExprExpr_568_list = Expression_568_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_568_list);
		Assert.assertEquals(1, ExprExpr_568_list.size());
		//568
		final AssignmentExpression AssignmentExpression_569_Var
		 = (AssignmentExpression)ExprExpr_568_list.get(0);
		Assert.assertNotNull(AssignmentExpression_569_Var
		);
		//569
		final ConditionalExpression ConditionalExpression_570_Var
		 = (ConditionalExpression)AssignmentExpression_569_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_570_Var
		);
		//570
		final LogicalOrExpression LogicalOrExpression_571_Var
		 = (LogicalOrExpression)ConditionalExpression_570_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_571_Var
		);
		final EList<? extends EObject> Expr_571_list = LogicalOrExpression_571_Var
		.getExpr();
		Assert.assertNotNull(Expr_571_list);
		Assert.assertEquals(1, Expr_571_list.size());
		//571
		final LogicalAndExpression LogicalAndExpression_572_Var
		 = (LogicalAndExpression)Expr_571_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_572_Var
		);
		final EList<? extends EObject> Expr_572_list = LogicalAndExpression_572_Var
		.getExpr();
		Assert.assertNotNull(Expr_572_list);
		Assert.assertEquals(1, Expr_572_list.size());
		//572
		final InclusiveOrExpression InclusiveOrExpression_573_Var
		 = (InclusiveOrExpression)Expr_572_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_573_Var
		);
		final EList<? extends EObject> Expr_573_list = InclusiveOrExpression_573_Var
		.getExpr();
		Assert.assertNotNull(Expr_573_list);
		Assert.assertEquals(1, Expr_573_list.size());
		//573
		final ExclusiveOrExpression ExclusiveOrExpression_574_Var
		 = (ExclusiveOrExpression)Expr_573_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_574_Var
		);
		final EList<? extends EObject> Expr_574_list = ExclusiveOrExpression_574_Var
		.getExpr();
		Assert.assertNotNull(Expr_574_list);
		Assert.assertEquals(1, Expr_574_list.size());
		//574
		final AndExpression AndExpression_575_Var
		 = (AndExpression)Expr_574_list.get(0);
		Assert.assertNotNull(AndExpression_575_Var
		);
		final EList<? extends EObject> Expr_575_list = AndExpression_575_Var
		.getExpr();
		Assert.assertNotNull(Expr_575_list);
		Assert.assertEquals(1, Expr_575_list.size());
		//575
		final EqualityExpression EqualityExpression_576_Var
		 = (EqualityExpression)Expr_575_list.get(0);
		Assert.assertNotNull(EqualityExpression_576_Var
		);
		final EList<? extends EObject> Expr_576_list = EqualityExpression_576_Var
		.getExpr();
		Assert.assertNotNull(Expr_576_list);
		Assert.assertEquals(1, Expr_576_list.size());
		//576
		final RelationalExpression RelationalExpression_577_Var
		 = (RelationalExpression)Expr_576_list.get(0);
		Assert.assertNotNull(RelationalExpression_577_Var
		);
		final EList<? extends EObject> Expr_577_list = RelationalExpression_577_Var
		.getExpr();
		Assert.assertNotNull(Expr_577_list);
		Assert.assertEquals(1, Expr_577_list.size());
		//577
		final ShiftExpression ShiftExpression_578_Var
		 = (ShiftExpression)Expr_577_list.get(0);
		Assert.assertNotNull(ShiftExpression_578_Var
		);
		final EList<? extends EObject> Expr_578_list = ShiftExpression_578_Var
		.getExpr();
		Assert.assertNotNull(Expr_578_list);
		Assert.assertEquals(1, Expr_578_list.size());
		//578
		final AdditiveExpression AdditiveExpression_579_Var
		 = (AdditiveExpression)Expr_578_list.get(0);
		Assert.assertNotNull(AdditiveExpression_579_Var
		);
		final EList<? extends EObject> Expr_579_list = AdditiveExpression_579_Var
		.getExpr();
		Assert.assertNotNull(Expr_579_list);
		Assert.assertEquals(1, Expr_579_list.size());
		//579
		final MultiplicativeExpression MultiplicativeExpression_580_Var
		 = (MultiplicativeExpression)Expr_579_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_580_Var
		);
		final EList<? extends EObject> Expr_580_list = MultiplicativeExpression_580_Var
		.getExpr();
		Assert.assertNotNull(Expr_580_list);
		Assert.assertEquals(1, Expr_580_list.size());
		//580
		final CastExpression CastExpression_581_Var
		 = (CastExpression)Expr_580_list.get(0);
		Assert.assertNotNull(CastExpression_581_Var
		);
		//581
		final UnaryExpression UnaryExpression_582_Var
		 = (UnaryExpression)CastExpression_581_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_582_Var
		);
		//582
		final PostfixExpression PostfixExpression_583_Var
		 = (PostfixExpression)UnaryExpression_582_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_583_Var
		);
		final EList<? extends EObject> Expr_583_list = PostfixExpression_583_Var
		.getExpr();
		Assert.assertNotNull(Expr_583_list);
		Assert.assertEquals(1, Expr_583_list.size());
		//583
		final PrimaryExpression PrimaryExpression_584_Var
		 = (PrimaryExpression)Expr_583_list.get(0);
		Assert.assertNotNull(PrimaryExpression_584_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_584_Var
		.getId());
		final EList<? extends EObject> Suffix_584_list = PostfixExpression_583_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_584_list);
		Assert.assertEquals(1, Suffix_584_list.size());
		//584
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_585_Var
		 = (PostfixExpressionSuffixArgument)Suffix_584_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_585_Var
		);
		//585
		final ArgumentExpressionList ArgumentExpressionList_586_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_585_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_586_Var
		);
		final EList<? extends EObject> Expr_586_list = ArgumentExpressionList_586_Var
		.getExpr();
		Assert.assertNotNull(Expr_586_list);
		Assert.assertEquals(2, Expr_586_list.size());
		//586
		final AssignmentExpression AssignmentExpression_587_Var
		 = (AssignmentExpression)Expr_586_list.get(0);
		Assert.assertNotNull(AssignmentExpression_587_Var
		);
		//587
		final ConditionalExpression ConditionalExpression_588_Var
		 = (ConditionalExpression)AssignmentExpression_587_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_588_Var
		);
		//588
		final LogicalOrExpression LogicalOrExpression_589_Var
		 = (LogicalOrExpression)ConditionalExpression_588_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_589_Var
		);
		final EList<? extends EObject> Expr_589_list = LogicalOrExpression_589_Var
		.getExpr();
		Assert.assertNotNull(Expr_589_list);
		Assert.assertEquals(1, Expr_589_list.size());
		//589
		final LogicalAndExpression LogicalAndExpression_590_Var
		 = (LogicalAndExpression)Expr_589_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_590_Var
		);
		final EList<? extends EObject> Expr_590_list = LogicalAndExpression_590_Var
		.getExpr();
		Assert.assertNotNull(Expr_590_list);
		Assert.assertEquals(1, Expr_590_list.size());
		//590
		final InclusiveOrExpression InclusiveOrExpression_591_Var
		 = (InclusiveOrExpression)Expr_590_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_591_Var
		);
		final EList<? extends EObject> Expr_591_list = InclusiveOrExpression_591_Var
		.getExpr();
		Assert.assertNotNull(Expr_591_list);
		Assert.assertEquals(1, Expr_591_list.size());
		//591
		final ExclusiveOrExpression ExclusiveOrExpression_592_Var
		 = (ExclusiveOrExpression)Expr_591_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_592_Var
		);
		final EList<? extends EObject> Expr_592_list = ExclusiveOrExpression_592_Var
		.getExpr();
		Assert.assertNotNull(Expr_592_list);
		Assert.assertEquals(1, Expr_592_list.size());
		//592
		final AndExpression AndExpression_593_Var
		 = (AndExpression)Expr_592_list.get(0);
		Assert.assertNotNull(AndExpression_593_Var
		);
		final EList<? extends EObject> Expr_593_list = AndExpression_593_Var
		.getExpr();
		Assert.assertNotNull(Expr_593_list);
		Assert.assertEquals(1, Expr_593_list.size());
		//593
		final EqualityExpression EqualityExpression_594_Var
		 = (EqualityExpression)Expr_593_list.get(0);
		Assert.assertNotNull(EqualityExpression_594_Var
		);
		final EList<? extends EObject> Expr_594_list = EqualityExpression_594_Var
		.getExpr();
		Assert.assertNotNull(Expr_594_list);
		Assert.assertEquals(1, Expr_594_list.size());
		//594
		final RelationalExpression RelationalExpression_595_Var
		 = (RelationalExpression)Expr_594_list.get(0);
		Assert.assertNotNull(RelationalExpression_595_Var
		);
		final EList<? extends EObject> Expr_595_list = RelationalExpression_595_Var
		.getExpr();
		Assert.assertNotNull(Expr_595_list);
		Assert.assertEquals(1, Expr_595_list.size());
		//595
		final ShiftExpression ShiftExpression_596_Var
		 = (ShiftExpression)Expr_595_list.get(0);
		Assert.assertNotNull(ShiftExpression_596_Var
		);
		final EList<? extends EObject> Expr_596_list = ShiftExpression_596_Var
		.getExpr();
		Assert.assertNotNull(Expr_596_list);
		Assert.assertEquals(1, Expr_596_list.size());
		//596
		final AdditiveExpression AdditiveExpression_597_Var
		 = (AdditiveExpression)Expr_596_list.get(0);
		Assert.assertNotNull(AdditiveExpression_597_Var
		);
		final EList<? extends EObject> Expr_597_list = AdditiveExpression_597_Var
		.getExpr();
		Assert.assertNotNull(Expr_597_list);
		Assert.assertEquals(1, Expr_597_list.size());
		//597
		final MultiplicativeExpression MultiplicativeExpression_598_Var
		 = (MultiplicativeExpression)Expr_597_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_598_Var
		);
		final EList<? extends EObject> Expr_598_list = MultiplicativeExpression_598_Var
		.getExpr();
		Assert.assertNotNull(Expr_598_list);
		Assert.assertEquals(1, Expr_598_list.size());
		//598
		final CastExpression CastExpression_599_Var
		 = (CastExpression)Expr_598_list.get(0);
		Assert.assertNotNull(CastExpression_599_Var
		);
		//599
		final UnaryExpression UnaryExpression_600_Var
		 = (UnaryExpression)CastExpression_599_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_600_Var
		);
		//600
		final PostfixExpression PostfixExpression_601_Var
		 = (PostfixExpression)UnaryExpression_600_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_601_Var
		);
		final EList<? extends EObject> Expr_601_list = PostfixExpression_601_Var
		.getExpr();
		Assert.assertNotNull(Expr_601_list);
		Assert.assertEquals(1, Expr_601_list.size());
		//601
		final PrimaryExpression PrimaryExpression_602_Var
		 = (PrimaryExpression)Expr_601_list.get(0);
		Assert.assertNotNull(PrimaryExpression_602_Var
		);
		Assert.assertEquals("[\"phil.name=%s\\n\"]", PrimaryExpression_602_Var
		.getString().toString());
		//602
		final AssignmentExpression AssignmentExpression_603_Var
		 = (AssignmentExpression)Expr_586_list.get(1);
		Assert.assertNotNull(AssignmentExpression_603_Var
		);
		//603
		final ConditionalExpression ConditionalExpression_604_Var
		 = (ConditionalExpression)AssignmentExpression_603_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_604_Var
		);
		//604
		final LogicalOrExpression LogicalOrExpression_605_Var
		 = (LogicalOrExpression)ConditionalExpression_604_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_605_Var
		);
		final EList<? extends EObject> Expr_605_list = LogicalOrExpression_605_Var
		.getExpr();
		Assert.assertNotNull(Expr_605_list);
		Assert.assertEquals(1, Expr_605_list.size());
		//605
		final LogicalAndExpression LogicalAndExpression_606_Var
		 = (LogicalAndExpression)Expr_605_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_606_Var
		);
		final EList<? extends EObject> Expr_606_list = LogicalAndExpression_606_Var
		.getExpr();
		Assert.assertNotNull(Expr_606_list);
		Assert.assertEquals(1, Expr_606_list.size());
		//606
		final InclusiveOrExpression InclusiveOrExpression_607_Var
		 = (InclusiveOrExpression)Expr_606_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_607_Var
		);
		final EList<? extends EObject> Expr_607_list = InclusiveOrExpression_607_Var
		.getExpr();
		Assert.assertNotNull(Expr_607_list);
		Assert.assertEquals(1, Expr_607_list.size());
		//607
		final ExclusiveOrExpression ExclusiveOrExpression_608_Var
		 = (ExclusiveOrExpression)Expr_607_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_608_Var
		);
		final EList<? extends EObject> Expr_608_list = ExclusiveOrExpression_608_Var
		.getExpr();
		Assert.assertNotNull(Expr_608_list);
		Assert.assertEquals(1, Expr_608_list.size());
		//608
		final AndExpression AndExpression_609_Var
		 = (AndExpression)Expr_608_list.get(0);
		Assert.assertNotNull(AndExpression_609_Var
		);
		final EList<? extends EObject> Expr_609_list = AndExpression_609_Var
		.getExpr();
		Assert.assertNotNull(Expr_609_list);
		Assert.assertEquals(1, Expr_609_list.size());
		//609
		final EqualityExpression EqualityExpression_610_Var
		 = (EqualityExpression)Expr_609_list.get(0);
		Assert.assertNotNull(EqualityExpression_610_Var
		);
		final EList<? extends EObject> Expr_610_list = EqualityExpression_610_Var
		.getExpr();
		Assert.assertNotNull(Expr_610_list);
		Assert.assertEquals(1, Expr_610_list.size());
		//610
		final RelationalExpression RelationalExpression_611_Var
		 = (RelationalExpression)Expr_610_list.get(0);
		Assert.assertNotNull(RelationalExpression_611_Var
		);
		final EList<? extends EObject> Expr_611_list = RelationalExpression_611_Var
		.getExpr();
		Assert.assertNotNull(Expr_611_list);
		Assert.assertEquals(1, Expr_611_list.size());
		//611
		final ShiftExpression ShiftExpression_612_Var
		 = (ShiftExpression)Expr_611_list.get(0);
		Assert.assertNotNull(ShiftExpression_612_Var
		);
		final EList<? extends EObject> Expr_612_list = ShiftExpression_612_Var
		.getExpr();
		Assert.assertNotNull(Expr_612_list);
		Assert.assertEquals(1, Expr_612_list.size());
		//612
		final AdditiveExpression AdditiveExpression_613_Var
		 = (AdditiveExpression)Expr_612_list.get(0);
		Assert.assertNotNull(AdditiveExpression_613_Var
		);
		final EList<? extends EObject> Expr_613_list = AdditiveExpression_613_Var
		.getExpr();
		Assert.assertNotNull(Expr_613_list);
		Assert.assertEquals(1, Expr_613_list.size());
		//613
		final MultiplicativeExpression MultiplicativeExpression_614_Var
		 = (MultiplicativeExpression)Expr_613_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_614_Var
		);
		final EList<? extends EObject> Expr_614_list = MultiplicativeExpression_614_Var
		.getExpr();
		Assert.assertNotNull(Expr_614_list);
		Assert.assertEquals(1, Expr_614_list.size());
		//614
		final CastExpression CastExpression_615_Var
		 = (CastExpression)Expr_614_list.get(0);
		Assert.assertNotNull(CastExpression_615_Var
		);
		//615
		final UnaryExpression UnaryExpression_616_Var
		 = (UnaryExpression)CastExpression_615_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_616_Var
		);
		//616
		final PostfixExpression PostfixExpression_617_Var
		 = (PostfixExpression)UnaryExpression_616_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_617_Var
		);
		final EList<? extends EObject> Expr_617_list = PostfixExpression_617_Var
		.getExpr();
		Assert.assertNotNull(Expr_617_list);
		Assert.assertEquals(1, Expr_617_list.size());
		//617
		final PrimaryExpression PrimaryExpression_618_Var
		 = (PrimaryExpression)Expr_617_list.get(0);
		Assert.assertNotNull(PrimaryExpression_618_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_618_Var
		.getId());
		final EList<? extends EObject> Suffix_618_list = PostfixExpression_617_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_618_list);
		Assert.assertEquals(1, Suffix_618_list.size());
		//618
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_619_Var
		 = (PostfixExpressionSuffixDot)Suffix_618_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_619_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_619_Var
		.getId());
		//619
		final Statement Statement_620_Var
		 = (Statement)Statement_108_list.get(9);
		Assert.assertNotNull(Statement_620_Var
		);
		//620
		final JumpStatement JumpStatement_621_Var
		 = (JumpStatement)Statement_620_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_621_Var
		);
		//621
		final Expression Expression_622_Var
		 = (Expression)JumpStatement_621_Var
		.getExpr();
		Assert.assertNotNull(Expression_622_Var
		);
		final EList<? extends EObject> ExprExpr_622_list = Expression_622_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_622_list);
		Assert.assertEquals(1, ExprExpr_622_list.size());
		//622
		final AssignmentExpression AssignmentExpression_623_Var
		 = (AssignmentExpression)ExprExpr_622_list.get(0);
		Assert.assertNotNull(AssignmentExpression_623_Var
		);
		//623
		final ConditionalExpression ConditionalExpression_624_Var
		 = (ConditionalExpression)AssignmentExpression_623_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_624_Var
		);
		//624
		final LogicalOrExpression LogicalOrExpression_625_Var
		 = (LogicalOrExpression)ConditionalExpression_624_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_625_Var
		);
		final EList<? extends EObject> Expr_625_list = LogicalOrExpression_625_Var
		.getExpr();
		Assert.assertNotNull(Expr_625_list);
		Assert.assertEquals(1, Expr_625_list.size());
		//625
		final LogicalAndExpression LogicalAndExpression_626_Var
		 = (LogicalAndExpression)Expr_625_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_626_Var
		);
		final EList<? extends EObject> Expr_626_list = LogicalAndExpression_626_Var
		.getExpr();
		Assert.assertNotNull(Expr_626_list);
		Assert.assertEquals(1, Expr_626_list.size());
		//626
		final InclusiveOrExpression InclusiveOrExpression_627_Var
		 = (InclusiveOrExpression)Expr_626_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_627_Var
		);
		final EList<? extends EObject> Expr_627_list = InclusiveOrExpression_627_Var
		.getExpr();
		Assert.assertNotNull(Expr_627_list);
		Assert.assertEquals(1, Expr_627_list.size());
		//627
		final ExclusiveOrExpression ExclusiveOrExpression_628_Var
		 = (ExclusiveOrExpression)Expr_627_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_628_Var
		);
		final EList<? extends EObject> Expr_628_list = ExclusiveOrExpression_628_Var
		.getExpr();
		Assert.assertNotNull(Expr_628_list);
		Assert.assertEquals(1, Expr_628_list.size());
		//628
		final AndExpression AndExpression_629_Var
		 = (AndExpression)Expr_628_list.get(0);
		Assert.assertNotNull(AndExpression_629_Var
		);
		final EList<? extends EObject> Expr_629_list = AndExpression_629_Var
		.getExpr();
		Assert.assertNotNull(Expr_629_list);
		Assert.assertEquals(1, Expr_629_list.size());
		//629
		final EqualityExpression EqualityExpression_630_Var
		 = (EqualityExpression)Expr_629_list.get(0);
		Assert.assertNotNull(EqualityExpression_630_Var
		);
		final EList<? extends EObject> Expr_630_list = EqualityExpression_630_Var
		.getExpr();
		Assert.assertNotNull(Expr_630_list);
		Assert.assertEquals(1, Expr_630_list.size());
		//630
		final RelationalExpression RelationalExpression_631_Var
		 = (RelationalExpression)Expr_630_list.get(0);
		Assert.assertNotNull(RelationalExpression_631_Var
		);
		final EList<? extends EObject> Expr_631_list = RelationalExpression_631_Var
		.getExpr();
		Assert.assertNotNull(Expr_631_list);
		Assert.assertEquals(1, Expr_631_list.size());
		//631
		final ShiftExpression ShiftExpression_632_Var
		 = (ShiftExpression)Expr_631_list.get(0);
		Assert.assertNotNull(ShiftExpression_632_Var
		);
		final EList<? extends EObject> Expr_632_list = ShiftExpression_632_Var
		.getExpr();
		Assert.assertNotNull(Expr_632_list);
		Assert.assertEquals(1, Expr_632_list.size());
		//632
		final AdditiveExpression AdditiveExpression_633_Var
		 = (AdditiveExpression)Expr_632_list.get(0);
		Assert.assertNotNull(AdditiveExpression_633_Var
		);
		final EList<? extends EObject> Expr_633_list = AdditiveExpression_633_Var
		.getExpr();
		Assert.assertNotNull(Expr_633_list);
		Assert.assertEquals(1, Expr_633_list.size());
		//633
		final MultiplicativeExpression MultiplicativeExpression_634_Var
		 = (MultiplicativeExpression)Expr_633_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_634_Var
		);
		final EList<? extends EObject> Expr_634_list = MultiplicativeExpression_634_Var
		.getExpr();
		Assert.assertNotNull(Expr_634_list);
		Assert.assertEquals(1, Expr_634_list.size());
		//634
		final CastExpression CastExpression_635_Var
		 = (CastExpression)Expr_634_list.get(0);
		Assert.assertNotNull(CastExpression_635_Var
		);
		//635
		final UnaryExpression UnaryExpression_636_Var
		 = (UnaryExpression)CastExpression_635_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_636_Var
		);
		//636
		final PostfixExpression PostfixExpression_637_Var
		 = (PostfixExpression)UnaryExpression_636_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_637_Var
		);
		final EList<? extends EObject> Expr_637_list = PostfixExpression_637_Var
		.getExpr();
		Assert.assertNotNull(Expr_637_list);
		Assert.assertEquals(1, Expr_637_list.size());
		//637
		final PrimaryExpression PrimaryExpression_638_Var
		 = (PrimaryExpression)Expr_637_list.get(0);
		Assert.assertNotNull(PrimaryExpression_638_Var
		);
		//638
		final Constant2 Constant2_639_Var
		 = (Constant2)PrimaryExpression_638_Var
		.getConst();
		Assert.assertNotNull(Constant2_639_Var
		);
		Assert.assertEquals("0", Constant2_639_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_621_Var
		.getReturn());
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


