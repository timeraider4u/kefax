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
import at.jku.weiner.c.parser.tests.ParserInjectorProvider;
import at.jku.weiner.c.parser.parser.antlr.ParserParser;
import at.jku.weiner.c.parser.parser.antlr.internal.InternalParserLexer;
import at.jku.weiner.c.parser.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.parser.parser.Model;
import at.jku.weiner.c.parser.parser.TranslationUnit;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
	
	@Before
	public void initialize(){
		this.testHelper = new LexerAndParserTest(lexer, 
			parser, tokenDefProvider);
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
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_CHAR", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTBRACKET", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_RIGHTBRACKET", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_RIGHTBRACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_STRUCT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_HEX_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_RIGHTBRACE", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_KW_VOID", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_KW_SIZEOF", 
				"RULE_LEFTPAREN", 
				"RULE_ID", 
				"RULE_DOT", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_KW_SIZEOF", 
				"RULE_LEFTPAREN", 
				"RULE_ID", 
				"RULE_DOT", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_KW_SIZEOF", 
				"RULE_LEFTPAREN", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_DOT", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_HEX_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_ID", 
				"RULE_DOT", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_DOT", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_DOT", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_DOT", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_DOT", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
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
			"res/Test0037_Struct.c");
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
		Assert.assertEquals(3, External_1_list.size());
		//1
		final ExternalDeclaration ExternalDeclaration_2_Var
		 = (ExternalDeclaration)External_1_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_2_Var
		);
		//2
		final Declaration Declaration_3_Var
		 = (Declaration)ExternalDeclaration_2_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_3_Var
		);
		//3
		final DeclarationSpecifiers DeclarationSpecifiers_4_Var
		 = (DeclarationSpecifiers)Declaration_3_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_4_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_4_list = DeclarationSpecifiers_4_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_4_list);
		Assert.assertEquals(1, DeclarationSpecifier_4_list.size());
		//4
		final StructOrUnionSpecifier StructOrUnionSpecifier_5_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_4_list.get(0);
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
		final Constant Constant_39_Var
		 = (Constant)PrimaryExpression_38_Var
		.getConst();
		Assert.assertNotNull(Constant_39_Var
		);
		Assert.assertEquals("250", Constant_39_Var
		.getDec());
		final EList<? extends EObject> InitDeclaratorList_39_list = Declaration_3_Var
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
		 = (ExternalDeclaration)External_1_list.get(1);
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
		final StructOrUnionSpecifier StructOrUnionSpecifier_47_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_46_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_47_Var
		);
		//47
		final StructOrUnion StructOrUnion_48_Var
		 = (StructOrUnion)StructOrUnionSpecifier_47_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_48_Var
		);
		Assert.assertEquals("struct", StructOrUnion_48_Var
		.getName());
		Assert.assertEquals("employee", StructOrUnionSpecifier_47_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_48_list = Declaration_45_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_48_list);
		Assert.assertEquals(1, InitDeclaratorList_48_list.size());
		//48
		final InitDeclaratorList InitDeclaratorList_49_Var
		 = (InitDeclaratorList)InitDeclaratorList_48_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_49_Var
		);
		final EList<? extends EObject> InitDeclarator_49_list = InitDeclaratorList_49_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_49_list);
		Assert.assertEquals(1, InitDeclarator_49_list.size());
		//49
		final InitDeclarator InitDeclarator_50_Var
		 = (InitDeclarator)InitDeclarator_49_list.get(0);
		Assert.assertNotNull(InitDeclarator_50_Var
		);
		//50
		final Declarator Declarator_51_Var
		 = (Declarator)InitDeclarator_50_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_51_Var
		);
		//51
		final DirectDeclarator DirectDeclarator_52_Var
		 = (DirectDeclarator)Declarator_51_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_52_Var
		);
		Assert.assertEquals("joe", DirectDeclarator_52_Var
		.getId());
		//52
		final Initializer Initializer_53_Var
		 = (Initializer)InitDeclarator_50_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_53_Var
		);
		//53
		final InitializerList InitializerList_54_Var
		 = (InitializerList)Initializer_53_Var
		.getList();
		Assert.assertNotNull(InitializerList_54_Var
		);
		final EList<? extends EObject> Initializer_54_list = InitializerList_54_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_54_list);
		Assert.assertEquals(2, Initializer_54_list.size());
		//54
		final Initializer Initializer_55_Var
		 = (Initializer)Initializer_54_list.get(0);
		Assert.assertNotNull(Initializer_55_Var
		);
		//55
		final AssignmentExpression AssignmentExpression_56_Var
		 = (AssignmentExpression)Initializer_55_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_56_Var
		);
		//56
		final ConditionalExpression ConditionalExpression_57_Var
		 = (ConditionalExpression)AssignmentExpression_56_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_57_Var
		);
		//57
		final LogicalOrExpression LogicalOrExpression_58_Var
		 = (LogicalOrExpression)ConditionalExpression_57_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = LogicalOrExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final LogicalAndExpression LogicalAndExpression_59_Var
		 = (LogicalAndExpression)Expr_58_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = LogicalAndExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final InclusiveOrExpression InclusiveOrExpression_60_Var
		 = (InclusiveOrExpression)Expr_59_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = InclusiveOrExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final ExclusiveOrExpression ExclusiveOrExpression_61_Var
		 = (ExclusiveOrExpression)Expr_60_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = ExclusiveOrExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final AndExpression AndExpression_62_Var
		 = (AndExpression)Expr_61_list.get(0);
		Assert.assertNotNull(AndExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = AndExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final EqualityExpression EqualityExpression_63_Var
		 = (EqualityExpression)Expr_62_list.get(0);
		Assert.assertNotNull(EqualityExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = EqualityExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final RelationalExpression RelationalExpression_64_Var
		 = (RelationalExpression)Expr_63_list.get(0);
		Assert.assertNotNull(RelationalExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = RelationalExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final ShiftExpression ShiftExpression_65_Var
		 = (ShiftExpression)Expr_64_list.get(0);
		Assert.assertNotNull(ShiftExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = ShiftExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final AdditiveExpression AdditiveExpression_66_Var
		 = (AdditiveExpression)Expr_65_list.get(0);
		Assert.assertNotNull(AdditiveExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = AdditiveExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final MultiplicativeExpression MultiplicativeExpression_67_Var
		 = (MultiplicativeExpression)Expr_66_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = MultiplicativeExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final CastExpression CastExpression_68_Var
		 = (CastExpression)Expr_67_list.get(0);
		Assert.assertNotNull(CastExpression_68_Var
		);
		//68
		final UnaryExpression UnaryExpression_69_Var
		 = (UnaryExpression)CastExpression_68_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_69_Var
		);
		//69
		final PostfixExpression PostfixExpression_70_Var
		 = (PostfixExpression)UnaryExpression_69_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = PostfixExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final PrimaryExpression PrimaryExpression_71_Var
		 = (PrimaryExpression)Expr_70_list.get(0);
		Assert.assertNotNull(PrimaryExpression_71_Var
		);
		//71
		final Constant Constant_72_Var
		 = (Constant)PrimaryExpression_71_Var
		.getConst();
		Assert.assertNotNull(Constant_72_Var
		);
		Assert.assertEquals("0x007", Constant_72_Var
		.getHex());
		//72
		final Initializer Initializer_73_Var
		 = (Initializer)Initializer_54_list.get(1);
		Assert.assertNotNull(Initializer_73_Var
		);
		//73
		final AssignmentExpression AssignmentExpression_74_Var
		 = (AssignmentExpression)Initializer_73_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_74_Var
		);
		//74
		final ConditionalExpression ConditionalExpression_75_Var
		 = (ConditionalExpression)AssignmentExpression_74_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_75_Var
		);
		//75
		final LogicalOrExpression LogicalOrExpression_76_Var
		 = (LogicalOrExpression)ConditionalExpression_75_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = LogicalOrExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final LogicalAndExpression LogicalAndExpression_77_Var
		 = (LogicalAndExpression)Expr_76_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = LogicalAndExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final InclusiveOrExpression InclusiveOrExpression_78_Var
		 = (InclusiveOrExpression)Expr_77_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = InclusiveOrExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final ExclusiveOrExpression ExclusiveOrExpression_79_Var
		 = (ExclusiveOrExpression)Expr_78_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = ExclusiveOrExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final AndExpression AndExpression_80_Var
		 = (AndExpression)Expr_79_list.get(0);
		Assert.assertNotNull(AndExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = AndExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final EqualityExpression EqualityExpression_81_Var
		 = (EqualityExpression)Expr_80_list.get(0);
		Assert.assertNotNull(EqualityExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = EqualityExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final RelationalExpression RelationalExpression_82_Var
		 = (RelationalExpression)Expr_81_list.get(0);
		Assert.assertNotNull(RelationalExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = RelationalExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final ShiftExpression ShiftExpression_83_Var
		 = (ShiftExpression)Expr_82_list.get(0);
		Assert.assertNotNull(ShiftExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = ShiftExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final AdditiveExpression AdditiveExpression_84_Var
		 = (AdditiveExpression)Expr_83_list.get(0);
		Assert.assertNotNull(AdditiveExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = AdditiveExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final MultiplicativeExpression MultiplicativeExpression_85_Var
		 = (MultiplicativeExpression)Expr_84_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = MultiplicativeExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final CastExpression CastExpression_86_Var
		 = (CastExpression)Expr_85_list.get(0);
		Assert.assertNotNull(CastExpression_86_Var
		);
		//86
		final UnaryExpression UnaryExpression_87_Var
		 = (UnaryExpression)CastExpression_86_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_87_Var
		);
		//87
		final PostfixExpression PostfixExpression_88_Var
		 = (PostfixExpression)UnaryExpression_87_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = PostfixExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final PrimaryExpression PrimaryExpression_89_Var
		 = (PrimaryExpression)Expr_88_list.get(0);
		Assert.assertNotNull(PrimaryExpression_89_Var
		);
		//89
		final Constant Constant_90_Var
		 = (Constant)PrimaryExpression_89_Var
		.getConst();
		Assert.assertNotNull(Constant_90_Var
		);
		Assert.assertEquals("\"Joe Nobody\"", Constant_90_Var
		.getStr());
		//90
		final ExternalDeclaration ExternalDeclaration_91_Var
		 = (ExternalDeclaration)External_1_list.get(2);
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
		//143
		final Constant Constant_144_Var
		 = (Constant)PrimaryExpression_143_Var
		.getConst();
		Assert.assertNotNull(Constant_144_Var
		);
		Assert.assertEquals("\"sizeof(joe.id)=%lu\\n\"", Constant_144_Var
		.getStr());
		//144
		final AssignmentExpression AssignmentExpression_145_Var
		 = (AssignmentExpression)Expr_127_list.get(1);
		Assert.assertNotNull(AssignmentExpression_145_Var
		);
		//145
		final ConditionalExpression ConditionalExpression_146_Var
		 = (ConditionalExpression)AssignmentExpression_145_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_146_Var
		);
		//146
		final LogicalOrExpression LogicalOrExpression_147_Var
		 = (LogicalOrExpression)ConditionalExpression_146_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_147_Var
		);
		final EList<? extends EObject> Expr_147_list = LogicalOrExpression_147_Var
		.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(1, Expr_147_list.size());
		//147
		final LogicalAndExpression LogicalAndExpression_148_Var
		 = (LogicalAndExpression)Expr_147_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_148_Var
		);
		final EList<? extends EObject> Expr_148_list = LogicalAndExpression_148_Var
		.getExpr();
		Assert.assertNotNull(Expr_148_list);
		Assert.assertEquals(1, Expr_148_list.size());
		//148
		final InclusiveOrExpression InclusiveOrExpression_149_Var
		 = (InclusiveOrExpression)Expr_148_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_149_Var
		);
		final EList<? extends EObject> Expr_149_list = InclusiveOrExpression_149_Var
		.getExpr();
		Assert.assertNotNull(Expr_149_list);
		Assert.assertEquals(1, Expr_149_list.size());
		//149
		final ExclusiveOrExpression ExclusiveOrExpression_150_Var
		 = (ExclusiveOrExpression)Expr_149_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_150_Var
		);
		final EList<? extends EObject> Expr_150_list = ExclusiveOrExpression_150_Var
		.getExpr();
		Assert.assertNotNull(Expr_150_list);
		Assert.assertEquals(1, Expr_150_list.size());
		//150
		final AndExpression AndExpression_151_Var
		 = (AndExpression)Expr_150_list.get(0);
		Assert.assertNotNull(AndExpression_151_Var
		);
		final EList<? extends EObject> Expr_151_list = AndExpression_151_Var
		.getExpr();
		Assert.assertNotNull(Expr_151_list);
		Assert.assertEquals(1, Expr_151_list.size());
		//151
		final EqualityExpression EqualityExpression_152_Var
		 = (EqualityExpression)Expr_151_list.get(0);
		Assert.assertNotNull(EqualityExpression_152_Var
		);
		final EList<? extends EObject> Expr_152_list = EqualityExpression_152_Var
		.getExpr();
		Assert.assertNotNull(Expr_152_list);
		Assert.assertEquals(1, Expr_152_list.size());
		//152
		final RelationalExpression RelationalExpression_153_Var
		 = (RelationalExpression)Expr_152_list.get(0);
		Assert.assertNotNull(RelationalExpression_153_Var
		);
		final EList<? extends EObject> Expr_153_list = RelationalExpression_153_Var
		.getExpr();
		Assert.assertNotNull(Expr_153_list);
		Assert.assertEquals(1, Expr_153_list.size());
		//153
		final ShiftExpression ShiftExpression_154_Var
		 = (ShiftExpression)Expr_153_list.get(0);
		Assert.assertNotNull(ShiftExpression_154_Var
		);
		final EList<? extends EObject> Expr_154_list = ShiftExpression_154_Var
		.getExpr();
		Assert.assertNotNull(Expr_154_list);
		Assert.assertEquals(1, Expr_154_list.size());
		//154
		final AdditiveExpression AdditiveExpression_155_Var
		 = (AdditiveExpression)Expr_154_list.get(0);
		Assert.assertNotNull(AdditiveExpression_155_Var
		);
		final EList<? extends EObject> Expr_155_list = AdditiveExpression_155_Var
		.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		//155
		final MultiplicativeExpression MultiplicativeExpression_156_Var
		 = (MultiplicativeExpression)Expr_155_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_156_Var
		);
		final EList<? extends EObject> Expr_156_list = MultiplicativeExpression_156_Var
		.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		//156
		final CastExpression CastExpression_157_Var
		 = (CastExpression)Expr_156_list.get(0);
		Assert.assertNotNull(CastExpression_157_Var
		);
		//157
		final UnaryExpression UnaryExpression_158_Var
		 = (UnaryExpression)CastExpression_157_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_158_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_158_Var
		.getSizeOf());
		//158
		final UnaryExpression UnaryExpression_159_Var
		 = (UnaryExpression)UnaryExpression_158_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_159_Var
		);
		//159
		final PostfixExpression PostfixExpression_160_Var
		 = (PostfixExpression)UnaryExpression_159_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = PostfixExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final PrimaryExpression PrimaryExpression_161_Var
		 = (PrimaryExpression)Expr_160_list.get(0);
		Assert.assertNotNull(PrimaryExpression_161_Var
		);
		//161
		final Expression Expression_162_Var
		 = (Expression)PrimaryExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expression_162_Var
		);
		final EList<? extends EObject> ExprExpr_162_list = Expression_162_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_162_list);
		Assert.assertEquals(1, ExprExpr_162_list.size());
		//162
		final AssignmentExpression AssignmentExpression_163_Var
		 = (AssignmentExpression)ExprExpr_162_list.get(0);
		Assert.assertNotNull(AssignmentExpression_163_Var
		);
		//163
		final ConditionalExpression ConditionalExpression_164_Var
		 = (ConditionalExpression)AssignmentExpression_163_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_164_Var
		);
		//164
		final LogicalOrExpression LogicalOrExpression_165_Var
		 = (LogicalOrExpression)ConditionalExpression_164_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_165_Var
		);
		final EList<? extends EObject> Expr_165_list = LogicalOrExpression_165_Var
		.getExpr();
		Assert.assertNotNull(Expr_165_list);
		Assert.assertEquals(1, Expr_165_list.size());
		//165
		final LogicalAndExpression LogicalAndExpression_166_Var
		 = (LogicalAndExpression)Expr_165_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_166_Var
		);
		final EList<? extends EObject> Expr_166_list = LogicalAndExpression_166_Var
		.getExpr();
		Assert.assertNotNull(Expr_166_list);
		Assert.assertEquals(1, Expr_166_list.size());
		//166
		final InclusiveOrExpression InclusiveOrExpression_167_Var
		 = (InclusiveOrExpression)Expr_166_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_167_Var
		);
		final EList<? extends EObject> Expr_167_list = InclusiveOrExpression_167_Var
		.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(1, Expr_167_list.size());
		//167
		final ExclusiveOrExpression ExclusiveOrExpression_168_Var
		 = (ExclusiveOrExpression)Expr_167_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_168_Var
		);
		final EList<? extends EObject> Expr_168_list = ExclusiveOrExpression_168_Var
		.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(1, Expr_168_list.size());
		//168
		final AndExpression AndExpression_169_Var
		 = (AndExpression)Expr_168_list.get(0);
		Assert.assertNotNull(AndExpression_169_Var
		);
		final EList<? extends EObject> Expr_169_list = AndExpression_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		//169
		final EqualityExpression EqualityExpression_170_Var
		 = (EqualityExpression)Expr_169_list.get(0);
		Assert.assertNotNull(EqualityExpression_170_Var
		);
		final EList<? extends EObject> Expr_170_list = EqualityExpression_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		//170
		final RelationalExpression RelationalExpression_171_Var
		 = (RelationalExpression)Expr_170_list.get(0);
		Assert.assertNotNull(RelationalExpression_171_Var
		);
		final EList<? extends EObject> Expr_171_list = RelationalExpression_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		//171
		final ShiftExpression ShiftExpression_172_Var
		 = (ShiftExpression)Expr_171_list.get(0);
		Assert.assertNotNull(ShiftExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = ShiftExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final AdditiveExpression AdditiveExpression_173_Var
		 = (AdditiveExpression)Expr_172_list.get(0);
		Assert.assertNotNull(AdditiveExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = AdditiveExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final MultiplicativeExpression MultiplicativeExpression_174_Var
		 = (MultiplicativeExpression)Expr_173_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = MultiplicativeExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final CastExpression CastExpression_175_Var
		 = (CastExpression)Expr_174_list.get(0);
		Assert.assertNotNull(CastExpression_175_Var
		);
		//175
		final UnaryExpression UnaryExpression_176_Var
		 = (UnaryExpression)CastExpression_175_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_176_Var
		);
		//176
		final PostfixExpression PostfixExpression_177_Var
		 = (PostfixExpression)UnaryExpression_176_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = PostfixExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final PrimaryExpression PrimaryExpression_178_Var
		 = (PrimaryExpression)Expr_177_list.get(0);
		Assert.assertNotNull(PrimaryExpression_178_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_178_Var
		.getId());
		final EList<? extends EObject> Suffix_178_list = PostfixExpression_177_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_178_list);
		Assert.assertEquals(1, Suffix_178_list.size());
		//178
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_179_Var
		 = (PostfixExpressionSuffixDot)Suffix_178_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_179_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_179_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_108_Var
		.getSemi());
		//179
		final Statement Statement_180_Var
		 = (Statement)Statement_106_list.get(1);
		Assert.assertNotNull(Statement_180_Var
		);
		//180
		final ExpressionStatement ExpressionStatement_181_Var
		 = (ExpressionStatement)Statement_180_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_181_Var
		);
		//181
		final Expression Expression_182_Var
		 = (Expression)ExpressionStatement_181_Var
		.getExpression();
		Assert.assertNotNull(Expression_182_Var
		);
		final EList<? extends EObject> ExprExpr_182_list = Expression_182_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_182_list);
		Assert.assertEquals(1, ExprExpr_182_list.size());
		//182
		final AssignmentExpression AssignmentExpression_183_Var
		 = (AssignmentExpression)ExprExpr_182_list.get(0);
		Assert.assertNotNull(AssignmentExpression_183_Var
		);
		//183
		final ConditionalExpression ConditionalExpression_184_Var
		 = (ConditionalExpression)AssignmentExpression_183_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_184_Var
		);
		//184
		final LogicalOrExpression LogicalOrExpression_185_Var
		 = (LogicalOrExpression)ConditionalExpression_184_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_185_Var
		);
		final EList<? extends EObject> Expr_185_list = LogicalOrExpression_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final LogicalAndExpression LogicalAndExpression_186_Var
		 = (LogicalAndExpression)Expr_185_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_186_Var
		);
		final EList<? extends EObject> Expr_186_list = LogicalAndExpression_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(1, Expr_186_list.size());
		//186
		final InclusiveOrExpression InclusiveOrExpression_187_Var
		 = (InclusiveOrExpression)Expr_186_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_187_Var
		);
		final EList<? extends EObject> Expr_187_list = InclusiveOrExpression_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(1, Expr_187_list.size());
		//187
		final ExclusiveOrExpression ExclusiveOrExpression_188_Var
		 = (ExclusiveOrExpression)Expr_187_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = ExclusiveOrExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final AndExpression AndExpression_189_Var
		 = (AndExpression)Expr_188_list.get(0);
		Assert.assertNotNull(AndExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = AndExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final EqualityExpression EqualityExpression_190_Var
		 = (EqualityExpression)Expr_189_list.get(0);
		Assert.assertNotNull(EqualityExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = EqualityExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final RelationalExpression RelationalExpression_191_Var
		 = (RelationalExpression)Expr_190_list.get(0);
		Assert.assertNotNull(RelationalExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = RelationalExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final ShiftExpression ShiftExpression_192_Var
		 = (ShiftExpression)Expr_191_list.get(0);
		Assert.assertNotNull(ShiftExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = ShiftExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final AdditiveExpression AdditiveExpression_193_Var
		 = (AdditiveExpression)Expr_192_list.get(0);
		Assert.assertNotNull(AdditiveExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = AdditiveExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final MultiplicativeExpression MultiplicativeExpression_194_Var
		 = (MultiplicativeExpression)Expr_193_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = MultiplicativeExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final CastExpression CastExpression_195_Var
		 = (CastExpression)Expr_194_list.get(0);
		Assert.assertNotNull(CastExpression_195_Var
		);
		//195
		final UnaryExpression UnaryExpression_196_Var
		 = (UnaryExpression)CastExpression_195_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_196_Var
		);
		//196
		final PostfixExpression PostfixExpression_197_Var
		 = (PostfixExpression)UnaryExpression_196_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = PostfixExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final PrimaryExpression PrimaryExpression_198_Var
		 = (PrimaryExpression)Expr_197_list.get(0);
		Assert.assertNotNull(PrimaryExpression_198_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_198_Var
		.getId());
		final EList<? extends EObject> Suffix_198_list = PostfixExpression_197_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_198_list);
		Assert.assertEquals(1, Suffix_198_list.size());
		//198
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_199_Var
		 = (PostfixExpressionSuffixArgument)Suffix_198_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_199_Var
		);
		//199
		final ArgumentExpressionList ArgumentExpressionList_200_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_199_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_200_Var
		);
		final EList<? extends EObject> Expr_200_list = ArgumentExpressionList_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(2, Expr_200_list.size());
		//200
		final AssignmentExpression AssignmentExpression_201_Var
		 = (AssignmentExpression)Expr_200_list.get(0);
		Assert.assertNotNull(AssignmentExpression_201_Var
		);
		//201
		final ConditionalExpression ConditionalExpression_202_Var
		 = (ConditionalExpression)AssignmentExpression_201_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_202_Var
		);
		//202
		final LogicalOrExpression LogicalOrExpression_203_Var
		 = (LogicalOrExpression)ConditionalExpression_202_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = LogicalOrExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final LogicalAndExpression LogicalAndExpression_204_Var
		 = (LogicalAndExpression)Expr_203_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = LogicalAndExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final InclusiveOrExpression InclusiveOrExpression_205_Var
		 = (InclusiveOrExpression)Expr_204_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = InclusiveOrExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final ExclusiveOrExpression ExclusiveOrExpression_206_Var
		 = (ExclusiveOrExpression)Expr_205_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = ExclusiveOrExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final AndExpression AndExpression_207_Var
		 = (AndExpression)Expr_206_list.get(0);
		Assert.assertNotNull(AndExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = AndExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final EqualityExpression EqualityExpression_208_Var
		 = (EqualityExpression)Expr_207_list.get(0);
		Assert.assertNotNull(EqualityExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = EqualityExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final RelationalExpression RelationalExpression_209_Var
		 = (RelationalExpression)Expr_208_list.get(0);
		Assert.assertNotNull(RelationalExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = RelationalExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final ShiftExpression ShiftExpression_210_Var
		 = (ShiftExpression)Expr_209_list.get(0);
		Assert.assertNotNull(ShiftExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = ShiftExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final AdditiveExpression AdditiveExpression_211_Var
		 = (AdditiveExpression)Expr_210_list.get(0);
		Assert.assertNotNull(AdditiveExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = AdditiveExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final MultiplicativeExpression MultiplicativeExpression_212_Var
		 = (MultiplicativeExpression)Expr_211_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = MultiplicativeExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final CastExpression CastExpression_213_Var
		 = (CastExpression)Expr_212_list.get(0);
		Assert.assertNotNull(CastExpression_213_Var
		);
		//213
		final UnaryExpression UnaryExpression_214_Var
		 = (UnaryExpression)CastExpression_213_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_214_Var
		);
		//214
		final PostfixExpression PostfixExpression_215_Var
		 = (PostfixExpression)UnaryExpression_214_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = PostfixExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final PrimaryExpression PrimaryExpression_216_Var
		 = (PrimaryExpression)Expr_215_list.get(0);
		Assert.assertNotNull(PrimaryExpression_216_Var
		);
		//216
		final Constant Constant_217_Var
		 = (Constant)PrimaryExpression_216_Var
		.getConst();
		Assert.assertNotNull(Constant_217_Var
		);
		Assert.assertEquals("\"sizeof(joe.name)=%lu\\n\"", Constant_217_Var
		.getStr());
		//217
		final AssignmentExpression AssignmentExpression_218_Var
		 = (AssignmentExpression)Expr_200_list.get(1);
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
		Assert.assertEquals(";", ExpressionStatement_181_Var
		.getSemi());
		//252
		final Statement Statement_253_Var
		 = (Statement)Statement_106_list.get(2);
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
		//289
		final Constant Constant_290_Var
		 = (Constant)PrimaryExpression_289_Var
		.getConst();
		Assert.assertNotNull(Constant_290_Var
		);
		Assert.assertEquals("\"sizeof(joe)=%lu\\n\"", Constant_290_Var
		.getStr());
		//290
		final AssignmentExpression AssignmentExpression_291_Var
		 = (AssignmentExpression)Expr_273_list.get(1);
		Assert.assertNotNull(AssignmentExpression_291_Var
		);
		//291
		final ConditionalExpression ConditionalExpression_292_Var
		 = (ConditionalExpression)AssignmentExpression_291_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_292_Var
		);
		//292
		final LogicalOrExpression LogicalOrExpression_293_Var
		 = (LogicalOrExpression)ConditionalExpression_292_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = LogicalOrExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final LogicalAndExpression LogicalAndExpression_294_Var
		 = (LogicalAndExpression)Expr_293_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_294_Var
		);
		final EList<? extends EObject> Expr_294_list = LogicalAndExpression_294_Var
		.getExpr();
		Assert.assertNotNull(Expr_294_list);
		Assert.assertEquals(1, Expr_294_list.size());
		//294
		final InclusiveOrExpression InclusiveOrExpression_295_Var
		 = (InclusiveOrExpression)Expr_294_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_295_Var
		);
		final EList<? extends EObject> Expr_295_list = InclusiveOrExpression_295_Var
		.getExpr();
		Assert.assertNotNull(Expr_295_list);
		Assert.assertEquals(1, Expr_295_list.size());
		//295
		final ExclusiveOrExpression ExclusiveOrExpression_296_Var
		 = (ExclusiveOrExpression)Expr_295_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_296_Var
		);
		final EList<? extends EObject> Expr_296_list = ExclusiveOrExpression_296_Var
		.getExpr();
		Assert.assertNotNull(Expr_296_list);
		Assert.assertEquals(1, Expr_296_list.size());
		//296
		final AndExpression AndExpression_297_Var
		 = (AndExpression)Expr_296_list.get(0);
		Assert.assertNotNull(AndExpression_297_Var
		);
		final EList<? extends EObject> Expr_297_list = AndExpression_297_Var
		.getExpr();
		Assert.assertNotNull(Expr_297_list);
		Assert.assertEquals(1, Expr_297_list.size());
		//297
		final EqualityExpression EqualityExpression_298_Var
		 = (EqualityExpression)Expr_297_list.get(0);
		Assert.assertNotNull(EqualityExpression_298_Var
		);
		final EList<? extends EObject> Expr_298_list = EqualityExpression_298_Var
		.getExpr();
		Assert.assertNotNull(Expr_298_list);
		Assert.assertEquals(1, Expr_298_list.size());
		//298
		final RelationalExpression RelationalExpression_299_Var
		 = (RelationalExpression)Expr_298_list.get(0);
		Assert.assertNotNull(RelationalExpression_299_Var
		);
		final EList<? extends EObject> Expr_299_list = RelationalExpression_299_Var
		.getExpr();
		Assert.assertNotNull(Expr_299_list);
		Assert.assertEquals(1, Expr_299_list.size());
		//299
		final ShiftExpression ShiftExpression_300_Var
		 = (ShiftExpression)Expr_299_list.get(0);
		Assert.assertNotNull(ShiftExpression_300_Var
		);
		final EList<? extends EObject> Expr_300_list = ShiftExpression_300_Var
		.getExpr();
		Assert.assertNotNull(Expr_300_list);
		Assert.assertEquals(1, Expr_300_list.size());
		//300
		final AdditiveExpression AdditiveExpression_301_Var
		 = (AdditiveExpression)Expr_300_list.get(0);
		Assert.assertNotNull(AdditiveExpression_301_Var
		);
		final EList<? extends EObject> Expr_301_list = AdditiveExpression_301_Var
		.getExpr();
		Assert.assertNotNull(Expr_301_list);
		Assert.assertEquals(1, Expr_301_list.size());
		//301
		final MultiplicativeExpression MultiplicativeExpression_302_Var
		 = (MultiplicativeExpression)Expr_301_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_302_Var
		);
		final EList<? extends EObject> Expr_302_list = MultiplicativeExpression_302_Var
		.getExpr();
		Assert.assertNotNull(Expr_302_list);
		Assert.assertEquals(1, Expr_302_list.size());
		//302
		final CastExpression CastExpression_303_Var
		 = (CastExpression)Expr_302_list.get(0);
		Assert.assertNotNull(CastExpression_303_Var
		);
		//303
		final UnaryExpression UnaryExpression_304_Var
		 = (UnaryExpression)CastExpression_303_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_304_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_304_Var
		.getSizeOf());
		//304
		final UnaryExpression UnaryExpression_305_Var
		 = (UnaryExpression)UnaryExpression_304_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_305_Var
		);
		//305
		final PostfixExpression PostfixExpression_306_Var
		 = (PostfixExpression)UnaryExpression_305_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_306_Var
		);
		final EList<? extends EObject> Expr_306_list = PostfixExpression_306_Var
		.getExpr();
		Assert.assertNotNull(Expr_306_list);
		Assert.assertEquals(1, Expr_306_list.size());
		//306
		final PrimaryExpression PrimaryExpression_307_Var
		 = (PrimaryExpression)Expr_306_list.get(0);
		Assert.assertNotNull(PrimaryExpression_307_Var
		);
		//307
		final Expression Expression_308_Var
		 = (Expression)PrimaryExpression_307_Var
		.getExpr();
		Assert.assertNotNull(Expression_308_Var
		);
		final EList<? extends EObject> ExprExpr_308_list = Expression_308_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_308_list);
		Assert.assertEquals(1, ExprExpr_308_list.size());
		//308
		final AssignmentExpression AssignmentExpression_309_Var
		 = (AssignmentExpression)ExprExpr_308_list.get(0);
		Assert.assertNotNull(AssignmentExpression_309_Var
		);
		//309
		final ConditionalExpression ConditionalExpression_310_Var
		 = (ConditionalExpression)AssignmentExpression_309_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_310_Var
		);
		//310
		final LogicalOrExpression LogicalOrExpression_311_Var
		 = (LogicalOrExpression)ConditionalExpression_310_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = LogicalOrExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final LogicalAndExpression LogicalAndExpression_312_Var
		 = (LogicalAndExpression)Expr_311_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = LogicalAndExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final InclusiveOrExpression InclusiveOrExpression_313_Var
		 = (InclusiveOrExpression)Expr_312_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_313_Var
		);
		final EList<? extends EObject> Expr_313_list = InclusiveOrExpression_313_Var
		.getExpr();
		Assert.assertNotNull(Expr_313_list);
		Assert.assertEquals(1, Expr_313_list.size());
		//313
		final ExclusiveOrExpression ExclusiveOrExpression_314_Var
		 = (ExclusiveOrExpression)Expr_313_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = ExclusiveOrExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final AndExpression AndExpression_315_Var
		 = (AndExpression)Expr_314_list.get(0);
		Assert.assertNotNull(AndExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = AndExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final EqualityExpression EqualityExpression_316_Var
		 = (EqualityExpression)Expr_315_list.get(0);
		Assert.assertNotNull(EqualityExpression_316_Var
		);
		final EList<? extends EObject> Expr_316_list = EqualityExpression_316_Var
		.getExpr();
		Assert.assertNotNull(Expr_316_list);
		Assert.assertEquals(1, Expr_316_list.size());
		//316
		final RelationalExpression RelationalExpression_317_Var
		 = (RelationalExpression)Expr_316_list.get(0);
		Assert.assertNotNull(RelationalExpression_317_Var
		);
		final EList<? extends EObject> Expr_317_list = RelationalExpression_317_Var
		.getExpr();
		Assert.assertNotNull(Expr_317_list);
		Assert.assertEquals(1, Expr_317_list.size());
		//317
		final ShiftExpression ShiftExpression_318_Var
		 = (ShiftExpression)Expr_317_list.get(0);
		Assert.assertNotNull(ShiftExpression_318_Var
		);
		final EList<? extends EObject> Expr_318_list = ShiftExpression_318_Var
		.getExpr();
		Assert.assertNotNull(Expr_318_list);
		Assert.assertEquals(1, Expr_318_list.size());
		//318
		final AdditiveExpression AdditiveExpression_319_Var
		 = (AdditiveExpression)Expr_318_list.get(0);
		Assert.assertNotNull(AdditiveExpression_319_Var
		);
		final EList<? extends EObject> Expr_319_list = AdditiveExpression_319_Var
		.getExpr();
		Assert.assertNotNull(Expr_319_list);
		Assert.assertEquals(1, Expr_319_list.size());
		//319
		final MultiplicativeExpression MultiplicativeExpression_320_Var
		 = (MultiplicativeExpression)Expr_319_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_320_Var
		);
		final EList<? extends EObject> Expr_320_list = MultiplicativeExpression_320_Var
		.getExpr();
		Assert.assertNotNull(Expr_320_list);
		Assert.assertEquals(1, Expr_320_list.size());
		//320
		final CastExpression CastExpression_321_Var
		 = (CastExpression)Expr_320_list.get(0);
		Assert.assertNotNull(CastExpression_321_Var
		);
		//321
		final UnaryExpression UnaryExpression_322_Var
		 = (UnaryExpression)CastExpression_321_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_322_Var
		);
		//322
		final PostfixExpression PostfixExpression_323_Var
		 = (PostfixExpression)UnaryExpression_322_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_323_Var
		);
		final EList<? extends EObject> Expr_323_list = PostfixExpression_323_Var
		.getExpr();
		Assert.assertNotNull(Expr_323_list);
		Assert.assertEquals(1, Expr_323_list.size());
		//323
		final PrimaryExpression PrimaryExpression_324_Var
		 = (PrimaryExpression)Expr_323_list.get(0);
		Assert.assertNotNull(PrimaryExpression_324_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_324_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_254_Var
		.getSemi());
		//324
		final Statement Statement_325_Var
		 = (Statement)Statement_106_list.get(3);
		Assert.assertNotNull(Statement_325_Var
		);
		//325
		final ExpressionStatement ExpressionStatement_326_Var
		 = (ExpressionStatement)Statement_325_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_326_Var
		);
		//326
		final Expression Expression_327_Var
		 = (Expression)ExpressionStatement_326_Var
		.getExpression();
		Assert.assertNotNull(Expression_327_Var
		);
		final EList<? extends EObject> ExprExpr_327_list = Expression_327_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_327_list);
		Assert.assertEquals(1, ExprExpr_327_list.size());
		//327
		final AssignmentExpression AssignmentExpression_328_Var
		 = (AssignmentExpression)ExprExpr_327_list.get(0);
		Assert.assertNotNull(AssignmentExpression_328_Var
		);
		//328
		final UnaryExpression UnaryExpression_329_Var
		 = (UnaryExpression)AssignmentExpression_328_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_329_Var
		);
		//329
		final PostfixExpression PostfixExpression_330_Var
		 = (PostfixExpression)UnaryExpression_329_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_330_Var
		);
		final EList<? extends EObject> Expr_330_list = PostfixExpression_330_Var
		.getExpr();
		Assert.assertNotNull(Expr_330_list);
		Assert.assertEquals(1, Expr_330_list.size());
		//330
		final PrimaryExpression PrimaryExpression_331_Var
		 = (PrimaryExpression)Expr_330_list.get(0);
		Assert.assertNotNull(PrimaryExpression_331_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_331_Var
		.getId());
		final EList<? extends EObject> Suffix_331_list = PostfixExpression_330_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_331_list);
		Assert.assertEquals(1, Suffix_331_list.size());
		//331
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_332_Var
		 = (PostfixExpressionSuffixDot)Suffix_331_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_332_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_332_Var
		.getId());
		//332
		final AssignmentOperator AssignmentOperator_333_Var
		 = (AssignmentOperator)AssignmentExpression_328_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_333_Var
		);
		Assert.assertEquals("=", AssignmentOperator_333_Var
		.getOp());
		//333
		final AssignmentExpression AssignmentExpression_334_Var
		 = (AssignmentExpression)AssignmentExpression_328_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_334_Var
		);
		//334
		final ConditionalExpression ConditionalExpression_335_Var
		 = (ConditionalExpression)AssignmentExpression_334_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_335_Var
		);
		//335
		final LogicalOrExpression LogicalOrExpression_336_Var
		 = (LogicalOrExpression)ConditionalExpression_335_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = LogicalOrExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final LogicalAndExpression LogicalAndExpression_337_Var
		 = (LogicalAndExpression)Expr_336_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_337_Var
		);
		final EList<? extends EObject> Expr_337_list = LogicalAndExpression_337_Var
		.getExpr();
		Assert.assertNotNull(Expr_337_list);
		Assert.assertEquals(1, Expr_337_list.size());
		//337
		final InclusiveOrExpression InclusiveOrExpression_338_Var
		 = (InclusiveOrExpression)Expr_337_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = InclusiveOrExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final ExclusiveOrExpression ExclusiveOrExpression_339_Var
		 = (ExclusiveOrExpression)Expr_338_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_339_Var
		);
		final EList<? extends EObject> Expr_339_list = ExclusiveOrExpression_339_Var
		.getExpr();
		Assert.assertNotNull(Expr_339_list);
		Assert.assertEquals(1, Expr_339_list.size());
		//339
		final AndExpression AndExpression_340_Var
		 = (AndExpression)Expr_339_list.get(0);
		Assert.assertNotNull(AndExpression_340_Var
		);
		final EList<? extends EObject> Expr_340_list = AndExpression_340_Var
		.getExpr();
		Assert.assertNotNull(Expr_340_list);
		Assert.assertEquals(1, Expr_340_list.size());
		//340
		final EqualityExpression EqualityExpression_341_Var
		 = (EqualityExpression)Expr_340_list.get(0);
		Assert.assertNotNull(EqualityExpression_341_Var
		);
		final EList<? extends EObject> Expr_341_list = EqualityExpression_341_Var
		.getExpr();
		Assert.assertNotNull(Expr_341_list);
		Assert.assertEquals(1, Expr_341_list.size());
		//341
		final RelationalExpression RelationalExpression_342_Var
		 = (RelationalExpression)Expr_341_list.get(0);
		Assert.assertNotNull(RelationalExpression_342_Var
		);
		final EList<? extends EObject> Expr_342_list = RelationalExpression_342_Var
		.getExpr();
		Assert.assertNotNull(Expr_342_list);
		Assert.assertEquals(1, Expr_342_list.size());
		//342
		final ShiftExpression ShiftExpression_343_Var
		 = (ShiftExpression)Expr_342_list.get(0);
		Assert.assertNotNull(ShiftExpression_343_Var
		);
		final EList<? extends EObject> Expr_343_list = ShiftExpression_343_Var
		.getExpr();
		Assert.assertNotNull(Expr_343_list);
		Assert.assertEquals(1, Expr_343_list.size());
		//343
		final AdditiveExpression AdditiveExpression_344_Var
		 = (AdditiveExpression)Expr_343_list.get(0);
		Assert.assertNotNull(AdditiveExpression_344_Var
		);
		final EList<? extends EObject> Expr_344_list = AdditiveExpression_344_Var
		.getExpr();
		Assert.assertNotNull(Expr_344_list);
		Assert.assertEquals(1, Expr_344_list.size());
		//344
		final MultiplicativeExpression MultiplicativeExpression_345_Var
		 = (MultiplicativeExpression)Expr_344_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_345_Var
		);
		final EList<? extends EObject> Expr_345_list = MultiplicativeExpression_345_Var
		.getExpr();
		Assert.assertNotNull(Expr_345_list);
		Assert.assertEquals(1, Expr_345_list.size());
		//345
		final CastExpression CastExpression_346_Var
		 = (CastExpression)Expr_345_list.get(0);
		Assert.assertNotNull(CastExpression_346_Var
		);
		//346
		final UnaryExpression UnaryExpression_347_Var
		 = (UnaryExpression)CastExpression_346_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_347_Var
		);
		//347
		final PostfixExpression PostfixExpression_348_Var
		 = (PostfixExpression)UnaryExpression_347_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_348_Var
		);
		final EList<? extends EObject> Expr_348_list = PostfixExpression_348_Var
		.getExpr();
		Assert.assertNotNull(Expr_348_list);
		Assert.assertEquals(1, Expr_348_list.size());
		//348
		final PrimaryExpression PrimaryExpression_349_Var
		 = (PrimaryExpression)Expr_348_list.get(0);
		Assert.assertNotNull(PrimaryExpression_349_Var
		);
		//349
		final Constant Constant_350_Var
		 = (Constant)PrimaryExpression_349_Var
		.getConst();
		Assert.assertNotNull(Constant_350_Var
		);
		Assert.assertEquals("0x008", Constant_350_Var
		.getHex());
		Assert.assertEquals(";", ExpressionStatement_326_Var
		.getSemi());
		//350
		final Statement Statement_351_Var
		 = (Statement)Statement_106_list.get(4);
		Assert.assertNotNull(Statement_351_Var
		);
		//351
		final ExpressionStatement ExpressionStatement_352_Var
		 = (ExpressionStatement)Statement_351_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_352_Var
		);
		//352
		final Expression Expression_353_Var
		 = (Expression)ExpressionStatement_352_Var
		.getExpression();
		Assert.assertNotNull(Expression_353_Var
		);
		final EList<? extends EObject> ExprExpr_353_list = Expression_353_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_353_list);
		Assert.assertEquals(1, ExprExpr_353_list.size());
		//353
		final AssignmentExpression AssignmentExpression_354_Var
		 = (AssignmentExpression)ExprExpr_353_list.get(0);
		Assert.assertNotNull(AssignmentExpression_354_Var
		);
		//354
		final ConditionalExpression ConditionalExpression_355_Var
		 = (ConditionalExpression)AssignmentExpression_354_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_355_Var
		);
		//355
		final LogicalOrExpression LogicalOrExpression_356_Var
		 = (LogicalOrExpression)ConditionalExpression_355_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_356_Var
		);
		final EList<? extends EObject> Expr_356_list = LogicalOrExpression_356_Var
		.getExpr();
		Assert.assertNotNull(Expr_356_list);
		Assert.assertEquals(1, Expr_356_list.size());
		//356
		final LogicalAndExpression LogicalAndExpression_357_Var
		 = (LogicalAndExpression)Expr_356_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_357_Var
		);
		final EList<? extends EObject> Expr_357_list = LogicalAndExpression_357_Var
		.getExpr();
		Assert.assertNotNull(Expr_357_list);
		Assert.assertEquals(1, Expr_357_list.size());
		//357
		final InclusiveOrExpression InclusiveOrExpression_358_Var
		 = (InclusiveOrExpression)Expr_357_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_358_Var
		);
		final EList<? extends EObject> Expr_358_list = InclusiveOrExpression_358_Var
		.getExpr();
		Assert.assertNotNull(Expr_358_list);
		Assert.assertEquals(1, Expr_358_list.size());
		//358
		final ExclusiveOrExpression ExclusiveOrExpression_359_Var
		 = (ExclusiveOrExpression)Expr_358_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_359_Var
		);
		final EList<? extends EObject> Expr_359_list = ExclusiveOrExpression_359_Var
		.getExpr();
		Assert.assertNotNull(Expr_359_list);
		Assert.assertEquals(1, Expr_359_list.size());
		//359
		final AndExpression AndExpression_360_Var
		 = (AndExpression)Expr_359_list.get(0);
		Assert.assertNotNull(AndExpression_360_Var
		);
		final EList<? extends EObject> Expr_360_list = AndExpression_360_Var
		.getExpr();
		Assert.assertNotNull(Expr_360_list);
		Assert.assertEquals(1, Expr_360_list.size());
		//360
		final EqualityExpression EqualityExpression_361_Var
		 = (EqualityExpression)Expr_360_list.get(0);
		Assert.assertNotNull(EqualityExpression_361_Var
		);
		final EList<? extends EObject> Expr_361_list = EqualityExpression_361_Var
		.getExpr();
		Assert.assertNotNull(Expr_361_list);
		Assert.assertEquals(1, Expr_361_list.size());
		//361
		final RelationalExpression RelationalExpression_362_Var
		 = (RelationalExpression)Expr_361_list.get(0);
		Assert.assertNotNull(RelationalExpression_362_Var
		);
		final EList<? extends EObject> Expr_362_list = RelationalExpression_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(1, Expr_362_list.size());
		//362
		final ShiftExpression ShiftExpression_363_Var
		 = (ShiftExpression)Expr_362_list.get(0);
		Assert.assertNotNull(ShiftExpression_363_Var
		);
		final EList<? extends EObject> Expr_363_list = ShiftExpression_363_Var
		.getExpr();
		Assert.assertNotNull(Expr_363_list);
		Assert.assertEquals(1, Expr_363_list.size());
		//363
		final AdditiveExpression AdditiveExpression_364_Var
		 = (AdditiveExpression)Expr_363_list.get(0);
		Assert.assertNotNull(AdditiveExpression_364_Var
		);
		final EList<? extends EObject> Expr_364_list = AdditiveExpression_364_Var
		.getExpr();
		Assert.assertNotNull(Expr_364_list);
		Assert.assertEquals(1, Expr_364_list.size());
		//364
		final MultiplicativeExpression MultiplicativeExpression_365_Var
		 = (MultiplicativeExpression)Expr_364_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = MultiplicativeExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final CastExpression CastExpression_366_Var
		 = (CastExpression)Expr_365_list.get(0);
		Assert.assertNotNull(CastExpression_366_Var
		);
		//366
		final UnaryExpression UnaryExpression_367_Var
		 = (UnaryExpression)CastExpression_366_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_367_Var
		);
		//367
		final PostfixExpression PostfixExpression_368_Var
		 = (PostfixExpression)UnaryExpression_367_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_368_Var
		);
		final EList<? extends EObject> Expr_368_list = PostfixExpression_368_Var
		.getExpr();
		Assert.assertNotNull(Expr_368_list);
		Assert.assertEquals(1, Expr_368_list.size());
		//368
		final PrimaryExpression PrimaryExpression_369_Var
		 = (PrimaryExpression)Expr_368_list.get(0);
		Assert.assertNotNull(PrimaryExpression_369_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_369_Var
		.getId());
		final EList<? extends EObject> Suffix_369_list = PostfixExpression_368_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_369_list);
		Assert.assertEquals(1, Suffix_369_list.size());
		//369
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_370_Var
		 = (PostfixExpressionSuffixArgument)Suffix_369_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_370_Var
		);
		//370
		final ArgumentExpressionList ArgumentExpressionList_371_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_370_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_371_Var
		);
		final EList<? extends EObject> Expr_371_list = ArgumentExpressionList_371_Var
		.getExpr();
		Assert.assertNotNull(Expr_371_list);
		Assert.assertEquals(2, Expr_371_list.size());
		//371
		final AssignmentExpression AssignmentExpression_372_Var
		 = (AssignmentExpression)Expr_371_list.get(0);
		Assert.assertNotNull(AssignmentExpression_372_Var
		);
		//372
		final ConditionalExpression ConditionalExpression_373_Var
		 = (ConditionalExpression)AssignmentExpression_372_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_373_Var
		);
		//373
		final LogicalOrExpression LogicalOrExpression_374_Var
		 = (LogicalOrExpression)ConditionalExpression_373_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_374_Var
		);
		final EList<? extends EObject> Expr_374_list = LogicalOrExpression_374_Var
		.getExpr();
		Assert.assertNotNull(Expr_374_list);
		Assert.assertEquals(1, Expr_374_list.size());
		//374
		final LogicalAndExpression LogicalAndExpression_375_Var
		 = (LogicalAndExpression)Expr_374_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_375_Var
		);
		final EList<? extends EObject> Expr_375_list = LogicalAndExpression_375_Var
		.getExpr();
		Assert.assertNotNull(Expr_375_list);
		Assert.assertEquals(1, Expr_375_list.size());
		//375
		final InclusiveOrExpression InclusiveOrExpression_376_Var
		 = (InclusiveOrExpression)Expr_375_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_376_Var
		);
		final EList<? extends EObject> Expr_376_list = InclusiveOrExpression_376_Var
		.getExpr();
		Assert.assertNotNull(Expr_376_list);
		Assert.assertEquals(1, Expr_376_list.size());
		//376
		final ExclusiveOrExpression ExclusiveOrExpression_377_Var
		 = (ExclusiveOrExpression)Expr_376_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_377_Var
		);
		final EList<? extends EObject> Expr_377_list = ExclusiveOrExpression_377_Var
		.getExpr();
		Assert.assertNotNull(Expr_377_list);
		Assert.assertEquals(1, Expr_377_list.size());
		//377
		final AndExpression AndExpression_378_Var
		 = (AndExpression)Expr_377_list.get(0);
		Assert.assertNotNull(AndExpression_378_Var
		);
		final EList<? extends EObject> Expr_378_list = AndExpression_378_Var
		.getExpr();
		Assert.assertNotNull(Expr_378_list);
		Assert.assertEquals(1, Expr_378_list.size());
		//378
		final EqualityExpression EqualityExpression_379_Var
		 = (EqualityExpression)Expr_378_list.get(0);
		Assert.assertNotNull(EqualityExpression_379_Var
		);
		final EList<? extends EObject> Expr_379_list = EqualityExpression_379_Var
		.getExpr();
		Assert.assertNotNull(Expr_379_list);
		Assert.assertEquals(1, Expr_379_list.size());
		//379
		final RelationalExpression RelationalExpression_380_Var
		 = (RelationalExpression)Expr_379_list.get(0);
		Assert.assertNotNull(RelationalExpression_380_Var
		);
		final EList<? extends EObject> Expr_380_list = RelationalExpression_380_Var
		.getExpr();
		Assert.assertNotNull(Expr_380_list);
		Assert.assertEquals(1, Expr_380_list.size());
		//380
		final ShiftExpression ShiftExpression_381_Var
		 = (ShiftExpression)Expr_380_list.get(0);
		Assert.assertNotNull(ShiftExpression_381_Var
		);
		final EList<? extends EObject> Expr_381_list = ShiftExpression_381_Var
		.getExpr();
		Assert.assertNotNull(Expr_381_list);
		Assert.assertEquals(1, Expr_381_list.size());
		//381
		final AdditiveExpression AdditiveExpression_382_Var
		 = (AdditiveExpression)Expr_381_list.get(0);
		Assert.assertNotNull(AdditiveExpression_382_Var
		);
		final EList<? extends EObject> Expr_382_list = AdditiveExpression_382_Var
		.getExpr();
		Assert.assertNotNull(Expr_382_list);
		Assert.assertEquals(1, Expr_382_list.size());
		//382
		final MultiplicativeExpression MultiplicativeExpression_383_Var
		 = (MultiplicativeExpression)Expr_382_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_383_Var
		);
		final EList<? extends EObject> Expr_383_list = MultiplicativeExpression_383_Var
		.getExpr();
		Assert.assertNotNull(Expr_383_list);
		Assert.assertEquals(1, Expr_383_list.size());
		//383
		final CastExpression CastExpression_384_Var
		 = (CastExpression)Expr_383_list.get(0);
		Assert.assertNotNull(CastExpression_384_Var
		);
		//384
		final UnaryExpression UnaryExpression_385_Var
		 = (UnaryExpression)CastExpression_384_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_385_Var
		);
		//385
		final PostfixExpression PostfixExpression_386_Var
		 = (PostfixExpression)UnaryExpression_385_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_386_Var
		);
		final EList<? extends EObject> Expr_386_list = PostfixExpression_386_Var
		.getExpr();
		Assert.assertNotNull(Expr_386_list);
		Assert.assertEquals(1, Expr_386_list.size());
		//386
		final PrimaryExpression PrimaryExpression_387_Var
		 = (PrimaryExpression)Expr_386_list.get(0);
		Assert.assertNotNull(PrimaryExpression_387_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_387_Var
		.getId());
		final EList<? extends EObject> Suffix_387_list = PostfixExpression_386_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_387_list);
		Assert.assertEquals(1, Suffix_387_list.size());
		//387
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_388_Var
		 = (PostfixExpressionSuffixDot)Suffix_387_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_388_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_388_Var
		.getId());
		//388
		final AssignmentExpression AssignmentExpression_389_Var
		 = (AssignmentExpression)Expr_371_list.get(1);
		Assert.assertNotNull(AssignmentExpression_389_Var
		);
		//389
		final ConditionalExpression ConditionalExpression_390_Var
		 = (ConditionalExpression)AssignmentExpression_389_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_390_Var
		);
		//390
		final LogicalOrExpression LogicalOrExpression_391_Var
		 = (LogicalOrExpression)ConditionalExpression_390_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_391_Var
		);
		final EList<? extends EObject> Expr_391_list = LogicalOrExpression_391_Var
		.getExpr();
		Assert.assertNotNull(Expr_391_list);
		Assert.assertEquals(1, Expr_391_list.size());
		//391
		final LogicalAndExpression LogicalAndExpression_392_Var
		 = (LogicalAndExpression)Expr_391_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_392_Var
		);
		final EList<? extends EObject> Expr_392_list = LogicalAndExpression_392_Var
		.getExpr();
		Assert.assertNotNull(Expr_392_list);
		Assert.assertEquals(1, Expr_392_list.size());
		//392
		final InclusiveOrExpression InclusiveOrExpression_393_Var
		 = (InclusiveOrExpression)Expr_392_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_393_Var
		);
		final EList<? extends EObject> Expr_393_list = InclusiveOrExpression_393_Var
		.getExpr();
		Assert.assertNotNull(Expr_393_list);
		Assert.assertEquals(1, Expr_393_list.size());
		//393
		final ExclusiveOrExpression ExclusiveOrExpression_394_Var
		 = (ExclusiveOrExpression)Expr_393_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_394_Var
		);
		final EList<? extends EObject> Expr_394_list = ExclusiveOrExpression_394_Var
		.getExpr();
		Assert.assertNotNull(Expr_394_list);
		Assert.assertEquals(1, Expr_394_list.size());
		//394
		final AndExpression AndExpression_395_Var
		 = (AndExpression)Expr_394_list.get(0);
		Assert.assertNotNull(AndExpression_395_Var
		);
		final EList<? extends EObject> Expr_395_list = AndExpression_395_Var
		.getExpr();
		Assert.assertNotNull(Expr_395_list);
		Assert.assertEquals(1, Expr_395_list.size());
		//395
		final EqualityExpression EqualityExpression_396_Var
		 = (EqualityExpression)Expr_395_list.get(0);
		Assert.assertNotNull(EqualityExpression_396_Var
		);
		final EList<? extends EObject> Expr_396_list = EqualityExpression_396_Var
		.getExpr();
		Assert.assertNotNull(Expr_396_list);
		Assert.assertEquals(1, Expr_396_list.size());
		//396
		final RelationalExpression RelationalExpression_397_Var
		 = (RelationalExpression)Expr_396_list.get(0);
		Assert.assertNotNull(RelationalExpression_397_Var
		);
		final EList<? extends EObject> Expr_397_list = RelationalExpression_397_Var
		.getExpr();
		Assert.assertNotNull(Expr_397_list);
		Assert.assertEquals(1, Expr_397_list.size());
		//397
		final ShiftExpression ShiftExpression_398_Var
		 = (ShiftExpression)Expr_397_list.get(0);
		Assert.assertNotNull(ShiftExpression_398_Var
		);
		final EList<? extends EObject> Expr_398_list = ShiftExpression_398_Var
		.getExpr();
		Assert.assertNotNull(Expr_398_list);
		Assert.assertEquals(1, Expr_398_list.size());
		//398
		final AdditiveExpression AdditiveExpression_399_Var
		 = (AdditiveExpression)Expr_398_list.get(0);
		Assert.assertNotNull(AdditiveExpression_399_Var
		);
		final EList<? extends EObject> Expr_399_list = AdditiveExpression_399_Var
		.getExpr();
		Assert.assertNotNull(Expr_399_list);
		Assert.assertEquals(1, Expr_399_list.size());
		//399
		final MultiplicativeExpression MultiplicativeExpression_400_Var
		 = (MultiplicativeExpression)Expr_399_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_400_Var
		);
		final EList<? extends EObject> Expr_400_list = MultiplicativeExpression_400_Var
		.getExpr();
		Assert.assertNotNull(Expr_400_list);
		Assert.assertEquals(1, Expr_400_list.size());
		//400
		final CastExpression CastExpression_401_Var
		 = (CastExpression)Expr_400_list.get(0);
		Assert.assertNotNull(CastExpression_401_Var
		);
		//401
		final UnaryExpression UnaryExpression_402_Var
		 = (UnaryExpression)CastExpression_401_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_402_Var
		);
		//402
		final PostfixExpression PostfixExpression_403_Var
		 = (PostfixExpression)UnaryExpression_402_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_403_Var
		);
		final EList<? extends EObject> Expr_403_list = PostfixExpression_403_Var
		.getExpr();
		Assert.assertNotNull(Expr_403_list);
		Assert.assertEquals(1, Expr_403_list.size());
		//403
		final PrimaryExpression PrimaryExpression_404_Var
		 = (PrimaryExpression)Expr_403_list.get(0);
		Assert.assertNotNull(PrimaryExpression_404_Var
		);
		//404
		final Constant Constant_405_Var
		 = (Constant)PrimaryExpression_404_Var
		.getConst();
		Assert.assertNotNull(Constant_405_Var
		);
		Assert.assertEquals("\"Phil Morrison\"", Constant_405_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_352_Var
		.getSemi());
		//405
		final Statement Statement_406_Var
		 = (Statement)Statement_106_list.get(5);
		Assert.assertNotNull(Statement_406_Var
		);
		//406
		final ExpressionStatement ExpressionStatement_407_Var
		 = (ExpressionStatement)Statement_406_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_407_Var
		);
		//407
		final Expression Expression_408_Var
		 = (Expression)ExpressionStatement_407_Var
		.getExpression();
		Assert.assertNotNull(Expression_408_Var
		);
		final EList<? extends EObject> ExprExpr_408_list = Expression_408_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_408_list);
		Assert.assertEquals(1, ExprExpr_408_list.size());
		//408
		final AssignmentExpression AssignmentExpression_409_Var
		 = (AssignmentExpression)ExprExpr_408_list.get(0);
		Assert.assertNotNull(AssignmentExpression_409_Var
		);
		//409
		final ConditionalExpression ConditionalExpression_410_Var
		 = (ConditionalExpression)AssignmentExpression_409_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_410_Var
		);
		//410
		final LogicalOrExpression LogicalOrExpression_411_Var
		 = (LogicalOrExpression)ConditionalExpression_410_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_411_Var
		);
		final EList<? extends EObject> Expr_411_list = LogicalOrExpression_411_Var
		.getExpr();
		Assert.assertNotNull(Expr_411_list);
		Assert.assertEquals(1, Expr_411_list.size());
		//411
		final LogicalAndExpression LogicalAndExpression_412_Var
		 = (LogicalAndExpression)Expr_411_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_412_Var
		);
		final EList<? extends EObject> Expr_412_list = LogicalAndExpression_412_Var
		.getExpr();
		Assert.assertNotNull(Expr_412_list);
		Assert.assertEquals(1, Expr_412_list.size());
		//412
		final InclusiveOrExpression InclusiveOrExpression_413_Var
		 = (InclusiveOrExpression)Expr_412_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_413_Var
		);
		final EList<? extends EObject> Expr_413_list = InclusiveOrExpression_413_Var
		.getExpr();
		Assert.assertNotNull(Expr_413_list);
		Assert.assertEquals(1, Expr_413_list.size());
		//413
		final ExclusiveOrExpression ExclusiveOrExpression_414_Var
		 = (ExclusiveOrExpression)Expr_413_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_414_Var
		);
		final EList<? extends EObject> Expr_414_list = ExclusiveOrExpression_414_Var
		.getExpr();
		Assert.assertNotNull(Expr_414_list);
		Assert.assertEquals(1, Expr_414_list.size());
		//414
		final AndExpression AndExpression_415_Var
		 = (AndExpression)Expr_414_list.get(0);
		Assert.assertNotNull(AndExpression_415_Var
		);
		final EList<? extends EObject> Expr_415_list = AndExpression_415_Var
		.getExpr();
		Assert.assertNotNull(Expr_415_list);
		Assert.assertEquals(1, Expr_415_list.size());
		//415
		final EqualityExpression EqualityExpression_416_Var
		 = (EqualityExpression)Expr_415_list.get(0);
		Assert.assertNotNull(EqualityExpression_416_Var
		);
		final EList<? extends EObject> Expr_416_list = EqualityExpression_416_Var
		.getExpr();
		Assert.assertNotNull(Expr_416_list);
		Assert.assertEquals(1, Expr_416_list.size());
		//416
		final RelationalExpression RelationalExpression_417_Var
		 = (RelationalExpression)Expr_416_list.get(0);
		Assert.assertNotNull(RelationalExpression_417_Var
		);
		final EList<? extends EObject> Expr_417_list = RelationalExpression_417_Var
		.getExpr();
		Assert.assertNotNull(Expr_417_list);
		Assert.assertEquals(1, Expr_417_list.size());
		//417
		final ShiftExpression ShiftExpression_418_Var
		 = (ShiftExpression)Expr_417_list.get(0);
		Assert.assertNotNull(ShiftExpression_418_Var
		);
		final EList<? extends EObject> Expr_418_list = ShiftExpression_418_Var
		.getExpr();
		Assert.assertNotNull(Expr_418_list);
		Assert.assertEquals(1, Expr_418_list.size());
		//418
		final AdditiveExpression AdditiveExpression_419_Var
		 = (AdditiveExpression)Expr_418_list.get(0);
		Assert.assertNotNull(AdditiveExpression_419_Var
		);
		final EList<? extends EObject> Expr_419_list = AdditiveExpression_419_Var
		.getExpr();
		Assert.assertNotNull(Expr_419_list);
		Assert.assertEquals(1, Expr_419_list.size());
		//419
		final MultiplicativeExpression MultiplicativeExpression_420_Var
		 = (MultiplicativeExpression)Expr_419_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_420_Var
		);
		final EList<? extends EObject> Expr_420_list = MultiplicativeExpression_420_Var
		.getExpr();
		Assert.assertNotNull(Expr_420_list);
		Assert.assertEquals(1, Expr_420_list.size());
		//420
		final CastExpression CastExpression_421_Var
		 = (CastExpression)Expr_420_list.get(0);
		Assert.assertNotNull(CastExpression_421_Var
		);
		//421
		final UnaryExpression UnaryExpression_422_Var
		 = (UnaryExpression)CastExpression_421_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_422_Var
		);
		//422
		final PostfixExpression PostfixExpression_423_Var
		 = (PostfixExpression)UnaryExpression_422_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_423_Var
		);
		final EList<? extends EObject> Expr_423_list = PostfixExpression_423_Var
		.getExpr();
		Assert.assertNotNull(Expr_423_list);
		Assert.assertEquals(1, Expr_423_list.size());
		//423
		final PrimaryExpression PrimaryExpression_424_Var
		 = (PrimaryExpression)Expr_423_list.get(0);
		Assert.assertNotNull(PrimaryExpression_424_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_424_Var
		.getId());
		final EList<? extends EObject> Suffix_424_list = PostfixExpression_423_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_424_list);
		Assert.assertEquals(1, Suffix_424_list.size());
		//424
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_425_Var
		 = (PostfixExpressionSuffixArgument)Suffix_424_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_425_Var
		);
		//425
		final ArgumentExpressionList ArgumentExpressionList_426_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_425_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_426_Var
		);
		final EList<? extends EObject> Expr_426_list = ArgumentExpressionList_426_Var
		.getExpr();
		Assert.assertNotNull(Expr_426_list);
		Assert.assertEquals(2, Expr_426_list.size());
		//426
		final AssignmentExpression AssignmentExpression_427_Var
		 = (AssignmentExpression)Expr_426_list.get(0);
		Assert.assertNotNull(AssignmentExpression_427_Var
		);
		//427
		final ConditionalExpression ConditionalExpression_428_Var
		 = (ConditionalExpression)AssignmentExpression_427_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_428_Var
		);
		//428
		final LogicalOrExpression LogicalOrExpression_429_Var
		 = (LogicalOrExpression)ConditionalExpression_428_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_429_Var
		);
		final EList<? extends EObject> Expr_429_list = LogicalOrExpression_429_Var
		.getExpr();
		Assert.assertNotNull(Expr_429_list);
		Assert.assertEquals(1, Expr_429_list.size());
		//429
		final LogicalAndExpression LogicalAndExpression_430_Var
		 = (LogicalAndExpression)Expr_429_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_430_Var
		);
		final EList<? extends EObject> Expr_430_list = LogicalAndExpression_430_Var
		.getExpr();
		Assert.assertNotNull(Expr_430_list);
		Assert.assertEquals(1, Expr_430_list.size());
		//430
		final InclusiveOrExpression InclusiveOrExpression_431_Var
		 = (InclusiveOrExpression)Expr_430_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_431_Var
		);
		final EList<? extends EObject> Expr_431_list = InclusiveOrExpression_431_Var
		.getExpr();
		Assert.assertNotNull(Expr_431_list);
		Assert.assertEquals(1, Expr_431_list.size());
		//431
		final ExclusiveOrExpression ExclusiveOrExpression_432_Var
		 = (ExclusiveOrExpression)Expr_431_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_432_Var
		);
		final EList<? extends EObject> Expr_432_list = ExclusiveOrExpression_432_Var
		.getExpr();
		Assert.assertNotNull(Expr_432_list);
		Assert.assertEquals(1, Expr_432_list.size());
		//432
		final AndExpression AndExpression_433_Var
		 = (AndExpression)Expr_432_list.get(0);
		Assert.assertNotNull(AndExpression_433_Var
		);
		final EList<? extends EObject> Expr_433_list = AndExpression_433_Var
		.getExpr();
		Assert.assertNotNull(Expr_433_list);
		Assert.assertEquals(1, Expr_433_list.size());
		//433
		final EqualityExpression EqualityExpression_434_Var
		 = (EqualityExpression)Expr_433_list.get(0);
		Assert.assertNotNull(EqualityExpression_434_Var
		);
		final EList<? extends EObject> Expr_434_list = EqualityExpression_434_Var
		.getExpr();
		Assert.assertNotNull(Expr_434_list);
		Assert.assertEquals(1, Expr_434_list.size());
		//434
		final RelationalExpression RelationalExpression_435_Var
		 = (RelationalExpression)Expr_434_list.get(0);
		Assert.assertNotNull(RelationalExpression_435_Var
		);
		final EList<? extends EObject> Expr_435_list = RelationalExpression_435_Var
		.getExpr();
		Assert.assertNotNull(Expr_435_list);
		Assert.assertEquals(1, Expr_435_list.size());
		//435
		final ShiftExpression ShiftExpression_436_Var
		 = (ShiftExpression)Expr_435_list.get(0);
		Assert.assertNotNull(ShiftExpression_436_Var
		);
		final EList<? extends EObject> Expr_436_list = ShiftExpression_436_Var
		.getExpr();
		Assert.assertNotNull(Expr_436_list);
		Assert.assertEquals(1, Expr_436_list.size());
		//436
		final AdditiveExpression AdditiveExpression_437_Var
		 = (AdditiveExpression)Expr_436_list.get(0);
		Assert.assertNotNull(AdditiveExpression_437_Var
		);
		final EList<? extends EObject> Expr_437_list = AdditiveExpression_437_Var
		.getExpr();
		Assert.assertNotNull(Expr_437_list);
		Assert.assertEquals(1, Expr_437_list.size());
		//437
		final MultiplicativeExpression MultiplicativeExpression_438_Var
		 = (MultiplicativeExpression)Expr_437_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_438_Var
		);
		final EList<? extends EObject> Expr_438_list = MultiplicativeExpression_438_Var
		.getExpr();
		Assert.assertNotNull(Expr_438_list);
		Assert.assertEquals(1, Expr_438_list.size());
		//438
		final CastExpression CastExpression_439_Var
		 = (CastExpression)Expr_438_list.get(0);
		Assert.assertNotNull(CastExpression_439_Var
		);
		//439
		final UnaryExpression UnaryExpression_440_Var
		 = (UnaryExpression)CastExpression_439_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_440_Var
		);
		//440
		final PostfixExpression PostfixExpression_441_Var
		 = (PostfixExpression)UnaryExpression_440_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_441_Var
		);
		final EList<? extends EObject> Expr_441_list = PostfixExpression_441_Var
		.getExpr();
		Assert.assertNotNull(Expr_441_list);
		Assert.assertEquals(1, Expr_441_list.size());
		//441
		final PrimaryExpression PrimaryExpression_442_Var
		 = (PrimaryExpression)Expr_441_list.get(0);
		Assert.assertNotNull(PrimaryExpression_442_Var
		);
		//442
		final Constant Constant_443_Var
		 = (Constant)PrimaryExpression_442_Var
		.getConst();
		Assert.assertNotNull(Constant_443_Var
		);
		Assert.assertEquals("\"joe.id=%d\\n\"", Constant_443_Var
		.getStr());
		//443
		final AssignmentExpression AssignmentExpression_444_Var
		 = (AssignmentExpression)Expr_426_list.get(1);
		Assert.assertNotNull(AssignmentExpression_444_Var
		);
		//444
		final ConditionalExpression ConditionalExpression_445_Var
		 = (ConditionalExpression)AssignmentExpression_444_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_445_Var
		);
		//445
		final LogicalOrExpression LogicalOrExpression_446_Var
		 = (LogicalOrExpression)ConditionalExpression_445_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_446_Var
		);
		final EList<? extends EObject> Expr_446_list = LogicalOrExpression_446_Var
		.getExpr();
		Assert.assertNotNull(Expr_446_list);
		Assert.assertEquals(1, Expr_446_list.size());
		//446
		final LogicalAndExpression LogicalAndExpression_447_Var
		 = (LogicalAndExpression)Expr_446_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_447_Var
		);
		final EList<? extends EObject> Expr_447_list = LogicalAndExpression_447_Var
		.getExpr();
		Assert.assertNotNull(Expr_447_list);
		Assert.assertEquals(1, Expr_447_list.size());
		//447
		final InclusiveOrExpression InclusiveOrExpression_448_Var
		 = (InclusiveOrExpression)Expr_447_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_448_Var
		);
		final EList<? extends EObject> Expr_448_list = InclusiveOrExpression_448_Var
		.getExpr();
		Assert.assertNotNull(Expr_448_list);
		Assert.assertEquals(1, Expr_448_list.size());
		//448
		final ExclusiveOrExpression ExclusiveOrExpression_449_Var
		 = (ExclusiveOrExpression)Expr_448_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_449_Var
		);
		final EList<? extends EObject> Expr_449_list = ExclusiveOrExpression_449_Var
		.getExpr();
		Assert.assertNotNull(Expr_449_list);
		Assert.assertEquals(1, Expr_449_list.size());
		//449
		final AndExpression AndExpression_450_Var
		 = (AndExpression)Expr_449_list.get(0);
		Assert.assertNotNull(AndExpression_450_Var
		);
		final EList<? extends EObject> Expr_450_list = AndExpression_450_Var
		.getExpr();
		Assert.assertNotNull(Expr_450_list);
		Assert.assertEquals(1, Expr_450_list.size());
		//450
		final EqualityExpression EqualityExpression_451_Var
		 = (EqualityExpression)Expr_450_list.get(0);
		Assert.assertNotNull(EqualityExpression_451_Var
		);
		final EList<? extends EObject> Expr_451_list = EqualityExpression_451_Var
		.getExpr();
		Assert.assertNotNull(Expr_451_list);
		Assert.assertEquals(1, Expr_451_list.size());
		//451
		final RelationalExpression RelationalExpression_452_Var
		 = (RelationalExpression)Expr_451_list.get(0);
		Assert.assertNotNull(RelationalExpression_452_Var
		);
		final EList<? extends EObject> Expr_452_list = RelationalExpression_452_Var
		.getExpr();
		Assert.assertNotNull(Expr_452_list);
		Assert.assertEquals(1, Expr_452_list.size());
		//452
		final ShiftExpression ShiftExpression_453_Var
		 = (ShiftExpression)Expr_452_list.get(0);
		Assert.assertNotNull(ShiftExpression_453_Var
		);
		final EList<? extends EObject> Expr_453_list = ShiftExpression_453_Var
		.getExpr();
		Assert.assertNotNull(Expr_453_list);
		Assert.assertEquals(1, Expr_453_list.size());
		//453
		final AdditiveExpression AdditiveExpression_454_Var
		 = (AdditiveExpression)Expr_453_list.get(0);
		Assert.assertNotNull(AdditiveExpression_454_Var
		);
		final EList<? extends EObject> Expr_454_list = AdditiveExpression_454_Var
		.getExpr();
		Assert.assertNotNull(Expr_454_list);
		Assert.assertEquals(1, Expr_454_list.size());
		//454
		final MultiplicativeExpression MultiplicativeExpression_455_Var
		 = (MultiplicativeExpression)Expr_454_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_455_Var
		);
		final EList<? extends EObject> Expr_455_list = MultiplicativeExpression_455_Var
		.getExpr();
		Assert.assertNotNull(Expr_455_list);
		Assert.assertEquals(1, Expr_455_list.size());
		//455
		final CastExpression CastExpression_456_Var
		 = (CastExpression)Expr_455_list.get(0);
		Assert.assertNotNull(CastExpression_456_Var
		);
		//456
		final UnaryExpression UnaryExpression_457_Var
		 = (UnaryExpression)CastExpression_456_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_457_Var
		);
		//457
		final PostfixExpression PostfixExpression_458_Var
		 = (PostfixExpression)UnaryExpression_457_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_458_Var
		);
		final EList<? extends EObject> Expr_458_list = PostfixExpression_458_Var
		.getExpr();
		Assert.assertNotNull(Expr_458_list);
		Assert.assertEquals(1, Expr_458_list.size());
		//458
		final PrimaryExpression PrimaryExpression_459_Var
		 = (PrimaryExpression)Expr_458_list.get(0);
		Assert.assertNotNull(PrimaryExpression_459_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_459_Var
		.getId());
		final EList<? extends EObject> Suffix_459_list = PostfixExpression_458_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_459_list);
		Assert.assertEquals(1, Suffix_459_list.size());
		//459
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_460_Var
		 = (PostfixExpressionSuffixDot)Suffix_459_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_460_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_460_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_407_Var
		.getSemi());
		//460
		final Statement Statement_461_Var
		 = (Statement)Statement_106_list.get(6);
		Assert.assertNotNull(Statement_461_Var
		);
		//461
		final ExpressionStatement ExpressionStatement_462_Var
		 = (ExpressionStatement)Statement_461_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_462_Var
		);
		//462
		final Expression Expression_463_Var
		 = (Expression)ExpressionStatement_462_Var
		.getExpression();
		Assert.assertNotNull(Expression_463_Var
		);
		final EList<? extends EObject> ExprExpr_463_list = Expression_463_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_463_list);
		Assert.assertEquals(1, ExprExpr_463_list.size());
		//463
		final AssignmentExpression AssignmentExpression_464_Var
		 = (AssignmentExpression)ExprExpr_463_list.get(0);
		Assert.assertNotNull(AssignmentExpression_464_Var
		);
		//464
		final ConditionalExpression ConditionalExpression_465_Var
		 = (ConditionalExpression)AssignmentExpression_464_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_465_Var
		);
		//465
		final LogicalOrExpression LogicalOrExpression_466_Var
		 = (LogicalOrExpression)ConditionalExpression_465_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_466_Var
		);
		final EList<? extends EObject> Expr_466_list = LogicalOrExpression_466_Var
		.getExpr();
		Assert.assertNotNull(Expr_466_list);
		Assert.assertEquals(1, Expr_466_list.size());
		//466
		final LogicalAndExpression LogicalAndExpression_467_Var
		 = (LogicalAndExpression)Expr_466_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_467_Var
		);
		final EList<? extends EObject> Expr_467_list = LogicalAndExpression_467_Var
		.getExpr();
		Assert.assertNotNull(Expr_467_list);
		Assert.assertEquals(1, Expr_467_list.size());
		//467
		final InclusiveOrExpression InclusiveOrExpression_468_Var
		 = (InclusiveOrExpression)Expr_467_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_468_Var
		);
		final EList<? extends EObject> Expr_468_list = InclusiveOrExpression_468_Var
		.getExpr();
		Assert.assertNotNull(Expr_468_list);
		Assert.assertEquals(1, Expr_468_list.size());
		//468
		final ExclusiveOrExpression ExclusiveOrExpression_469_Var
		 = (ExclusiveOrExpression)Expr_468_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_469_Var
		);
		final EList<? extends EObject> Expr_469_list = ExclusiveOrExpression_469_Var
		.getExpr();
		Assert.assertNotNull(Expr_469_list);
		Assert.assertEquals(1, Expr_469_list.size());
		//469
		final AndExpression AndExpression_470_Var
		 = (AndExpression)Expr_469_list.get(0);
		Assert.assertNotNull(AndExpression_470_Var
		);
		final EList<? extends EObject> Expr_470_list = AndExpression_470_Var
		.getExpr();
		Assert.assertNotNull(Expr_470_list);
		Assert.assertEquals(1, Expr_470_list.size());
		//470
		final EqualityExpression EqualityExpression_471_Var
		 = (EqualityExpression)Expr_470_list.get(0);
		Assert.assertNotNull(EqualityExpression_471_Var
		);
		final EList<? extends EObject> Expr_471_list = EqualityExpression_471_Var
		.getExpr();
		Assert.assertNotNull(Expr_471_list);
		Assert.assertEquals(1, Expr_471_list.size());
		//471
		final RelationalExpression RelationalExpression_472_Var
		 = (RelationalExpression)Expr_471_list.get(0);
		Assert.assertNotNull(RelationalExpression_472_Var
		);
		final EList<? extends EObject> Expr_472_list = RelationalExpression_472_Var
		.getExpr();
		Assert.assertNotNull(Expr_472_list);
		Assert.assertEquals(1, Expr_472_list.size());
		//472
		final ShiftExpression ShiftExpression_473_Var
		 = (ShiftExpression)Expr_472_list.get(0);
		Assert.assertNotNull(ShiftExpression_473_Var
		);
		final EList<? extends EObject> Expr_473_list = ShiftExpression_473_Var
		.getExpr();
		Assert.assertNotNull(Expr_473_list);
		Assert.assertEquals(1, Expr_473_list.size());
		//473
		final AdditiveExpression AdditiveExpression_474_Var
		 = (AdditiveExpression)Expr_473_list.get(0);
		Assert.assertNotNull(AdditiveExpression_474_Var
		);
		final EList<? extends EObject> Expr_474_list = AdditiveExpression_474_Var
		.getExpr();
		Assert.assertNotNull(Expr_474_list);
		Assert.assertEquals(1, Expr_474_list.size());
		//474
		final MultiplicativeExpression MultiplicativeExpression_475_Var
		 = (MultiplicativeExpression)Expr_474_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_475_Var
		);
		final EList<? extends EObject> Expr_475_list = MultiplicativeExpression_475_Var
		.getExpr();
		Assert.assertNotNull(Expr_475_list);
		Assert.assertEquals(1, Expr_475_list.size());
		//475
		final CastExpression CastExpression_476_Var
		 = (CastExpression)Expr_475_list.get(0);
		Assert.assertNotNull(CastExpression_476_Var
		);
		//476
		final UnaryExpression UnaryExpression_477_Var
		 = (UnaryExpression)CastExpression_476_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_477_Var
		);
		//477
		final PostfixExpression PostfixExpression_478_Var
		 = (PostfixExpression)UnaryExpression_477_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_478_Var
		);
		final EList<? extends EObject> Expr_478_list = PostfixExpression_478_Var
		.getExpr();
		Assert.assertNotNull(Expr_478_list);
		Assert.assertEquals(1, Expr_478_list.size());
		//478
		final PrimaryExpression PrimaryExpression_479_Var
		 = (PrimaryExpression)Expr_478_list.get(0);
		Assert.assertNotNull(PrimaryExpression_479_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_479_Var
		.getId());
		final EList<? extends EObject> Suffix_479_list = PostfixExpression_478_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_479_list);
		Assert.assertEquals(1, Suffix_479_list.size());
		//479
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_480_Var
		 = (PostfixExpressionSuffixArgument)Suffix_479_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_480_Var
		);
		//480
		final ArgumentExpressionList ArgumentExpressionList_481_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_480_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_481_Var
		);
		final EList<? extends EObject> Expr_481_list = ArgumentExpressionList_481_Var
		.getExpr();
		Assert.assertNotNull(Expr_481_list);
		Assert.assertEquals(2, Expr_481_list.size());
		//481
		final AssignmentExpression AssignmentExpression_482_Var
		 = (AssignmentExpression)Expr_481_list.get(0);
		Assert.assertNotNull(AssignmentExpression_482_Var
		);
		//482
		final ConditionalExpression ConditionalExpression_483_Var
		 = (ConditionalExpression)AssignmentExpression_482_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_483_Var
		);
		//483
		final LogicalOrExpression LogicalOrExpression_484_Var
		 = (LogicalOrExpression)ConditionalExpression_483_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_484_Var
		);
		final EList<? extends EObject> Expr_484_list = LogicalOrExpression_484_Var
		.getExpr();
		Assert.assertNotNull(Expr_484_list);
		Assert.assertEquals(1, Expr_484_list.size());
		//484
		final LogicalAndExpression LogicalAndExpression_485_Var
		 = (LogicalAndExpression)Expr_484_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_485_Var
		);
		final EList<? extends EObject> Expr_485_list = LogicalAndExpression_485_Var
		.getExpr();
		Assert.assertNotNull(Expr_485_list);
		Assert.assertEquals(1, Expr_485_list.size());
		//485
		final InclusiveOrExpression InclusiveOrExpression_486_Var
		 = (InclusiveOrExpression)Expr_485_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_486_Var
		);
		final EList<? extends EObject> Expr_486_list = InclusiveOrExpression_486_Var
		.getExpr();
		Assert.assertNotNull(Expr_486_list);
		Assert.assertEquals(1, Expr_486_list.size());
		//486
		final ExclusiveOrExpression ExclusiveOrExpression_487_Var
		 = (ExclusiveOrExpression)Expr_486_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_487_Var
		);
		final EList<? extends EObject> Expr_487_list = ExclusiveOrExpression_487_Var
		.getExpr();
		Assert.assertNotNull(Expr_487_list);
		Assert.assertEquals(1, Expr_487_list.size());
		//487
		final AndExpression AndExpression_488_Var
		 = (AndExpression)Expr_487_list.get(0);
		Assert.assertNotNull(AndExpression_488_Var
		);
		final EList<? extends EObject> Expr_488_list = AndExpression_488_Var
		.getExpr();
		Assert.assertNotNull(Expr_488_list);
		Assert.assertEquals(1, Expr_488_list.size());
		//488
		final EqualityExpression EqualityExpression_489_Var
		 = (EqualityExpression)Expr_488_list.get(0);
		Assert.assertNotNull(EqualityExpression_489_Var
		);
		final EList<? extends EObject> Expr_489_list = EqualityExpression_489_Var
		.getExpr();
		Assert.assertNotNull(Expr_489_list);
		Assert.assertEquals(1, Expr_489_list.size());
		//489
		final RelationalExpression RelationalExpression_490_Var
		 = (RelationalExpression)Expr_489_list.get(0);
		Assert.assertNotNull(RelationalExpression_490_Var
		);
		final EList<? extends EObject> Expr_490_list = RelationalExpression_490_Var
		.getExpr();
		Assert.assertNotNull(Expr_490_list);
		Assert.assertEquals(1, Expr_490_list.size());
		//490
		final ShiftExpression ShiftExpression_491_Var
		 = (ShiftExpression)Expr_490_list.get(0);
		Assert.assertNotNull(ShiftExpression_491_Var
		);
		final EList<? extends EObject> Expr_491_list = ShiftExpression_491_Var
		.getExpr();
		Assert.assertNotNull(Expr_491_list);
		Assert.assertEquals(1, Expr_491_list.size());
		//491
		final AdditiveExpression AdditiveExpression_492_Var
		 = (AdditiveExpression)Expr_491_list.get(0);
		Assert.assertNotNull(AdditiveExpression_492_Var
		);
		final EList<? extends EObject> Expr_492_list = AdditiveExpression_492_Var
		.getExpr();
		Assert.assertNotNull(Expr_492_list);
		Assert.assertEquals(1, Expr_492_list.size());
		//492
		final MultiplicativeExpression MultiplicativeExpression_493_Var
		 = (MultiplicativeExpression)Expr_492_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_493_Var
		);
		final EList<? extends EObject> Expr_493_list = MultiplicativeExpression_493_Var
		.getExpr();
		Assert.assertNotNull(Expr_493_list);
		Assert.assertEquals(1, Expr_493_list.size());
		//493
		final CastExpression CastExpression_494_Var
		 = (CastExpression)Expr_493_list.get(0);
		Assert.assertNotNull(CastExpression_494_Var
		);
		//494
		final UnaryExpression UnaryExpression_495_Var
		 = (UnaryExpression)CastExpression_494_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_495_Var
		);
		//495
		final PostfixExpression PostfixExpression_496_Var
		 = (PostfixExpression)UnaryExpression_495_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_496_Var
		);
		final EList<? extends EObject> Expr_496_list = PostfixExpression_496_Var
		.getExpr();
		Assert.assertNotNull(Expr_496_list);
		Assert.assertEquals(1, Expr_496_list.size());
		//496
		final PrimaryExpression PrimaryExpression_497_Var
		 = (PrimaryExpression)Expr_496_list.get(0);
		Assert.assertNotNull(PrimaryExpression_497_Var
		);
		//497
		final Constant Constant_498_Var
		 = (Constant)PrimaryExpression_497_Var
		.getConst();
		Assert.assertNotNull(Constant_498_Var
		);
		Assert.assertEquals("\"joe.name=%s\\n\"", Constant_498_Var
		.getStr());
		//498
		final AssignmentExpression AssignmentExpression_499_Var
		 = (AssignmentExpression)Expr_481_list.get(1);
		Assert.assertNotNull(AssignmentExpression_499_Var
		);
		//499
		final ConditionalExpression ConditionalExpression_500_Var
		 = (ConditionalExpression)AssignmentExpression_499_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_500_Var
		);
		//500
		final LogicalOrExpression LogicalOrExpression_501_Var
		 = (LogicalOrExpression)ConditionalExpression_500_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_501_Var
		);
		final EList<? extends EObject> Expr_501_list = LogicalOrExpression_501_Var
		.getExpr();
		Assert.assertNotNull(Expr_501_list);
		Assert.assertEquals(1, Expr_501_list.size());
		//501
		final LogicalAndExpression LogicalAndExpression_502_Var
		 = (LogicalAndExpression)Expr_501_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_502_Var
		);
		final EList<? extends EObject> Expr_502_list = LogicalAndExpression_502_Var
		.getExpr();
		Assert.assertNotNull(Expr_502_list);
		Assert.assertEquals(1, Expr_502_list.size());
		//502
		final InclusiveOrExpression InclusiveOrExpression_503_Var
		 = (InclusiveOrExpression)Expr_502_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_503_Var
		);
		final EList<? extends EObject> Expr_503_list = InclusiveOrExpression_503_Var
		.getExpr();
		Assert.assertNotNull(Expr_503_list);
		Assert.assertEquals(1, Expr_503_list.size());
		//503
		final ExclusiveOrExpression ExclusiveOrExpression_504_Var
		 = (ExclusiveOrExpression)Expr_503_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_504_Var
		);
		final EList<? extends EObject> Expr_504_list = ExclusiveOrExpression_504_Var
		.getExpr();
		Assert.assertNotNull(Expr_504_list);
		Assert.assertEquals(1, Expr_504_list.size());
		//504
		final AndExpression AndExpression_505_Var
		 = (AndExpression)Expr_504_list.get(0);
		Assert.assertNotNull(AndExpression_505_Var
		);
		final EList<? extends EObject> Expr_505_list = AndExpression_505_Var
		.getExpr();
		Assert.assertNotNull(Expr_505_list);
		Assert.assertEquals(1, Expr_505_list.size());
		//505
		final EqualityExpression EqualityExpression_506_Var
		 = (EqualityExpression)Expr_505_list.get(0);
		Assert.assertNotNull(EqualityExpression_506_Var
		);
		final EList<? extends EObject> Expr_506_list = EqualityExpression_506_Var
		.getExpr();
		Assert.assertNotNull(Expr_506_list);
		Assert.assertEquals(1, Expr_506_list.size());
		//506
		final RelationalExpression RelationalExpression_507_Var
		 = (RelationalExpression)Expr_506_list.get(0);
		Assert.assertNotNull(RelationalExpression_507_Var
		);
		final EList<? extends EObject> Expr_507_list = RelationalExpression_507_Var
		.getExpr();
		Assert.assertNotNull(Expr_507_list);
		Assert.assertEquals(1, Expr_507_list.size());
		//507
		final ShiftExpression ShiftExpression_508_Var
		 = (ShiftExpression)Expr_507_list.get(0);
		Assert.assertNotNull(ShiftExpression_508_Var
		);
		final EList<? extends EObject> Expr_508_list = ShiftExpression_508_Var
		.getExpr();
		Assert.assertNotNull(Expr_508_list);
		Assert.assertEquals(1, Expr_508_list.size());
		//508
		final AdditiveExpression AdditiveExpression_509_Var
		 = (AdditiveExpression)Expr_508_list.get(0);
		Assert.assertNotNull(AdditiveExpression_509_Var
		);
		final EList<? extends EObject> Expr_509_list = AdditiveExpression_509_Var
		.getExpr();
		Assert.assertNotNull(Expr_509_list);
		Assert.assertEquals(1, Expr_509_list.size());
		//509
		final MultiplicativeExpression MultiplicativeExpression_510_Var
		 = (MultiplicativeExpression)Expr_509_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_510_Var
		);
		final EList<? extends EObject> Expr_510_list = MultiplicativeExpression_510_Var
		.getExpr();
		Assert.assertNotNull(Expr_510_list);
		Assert.assertEquals(1, Expr_510_list.size());
		//510
		final CastExpression CastExpression_511_Var
		 = (CastExpression)Expr_510_list.get(0);
		Assert.assertNotNull(CastExpression_511_Var
		);
		//511
		final UnaryExpression UnaryExpression_512_Var
		 = (UnaryExpression)CastExpression_511_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_512_Var
		);
		//512
		final PostfixExpression PostfixExpression_513_Var
		 = (PostfixExpression)UnaryExpression_512_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_513_Var
		);
		final EList<? extends EObject> Expr_513_list = PostfixExpression_513_Var
		.getExpr();
		Assert.assertNotNull(Expr_513_list);
		Assert.assertEquals(1, Expr_513_list.size());
		//513
		final PrimaryExpression PrimaryExpression_514_Var
		 = (PrimaryExpression)Expr_513_list.get(0);
		Assert.assertNotNull(PrimaryExpression_514_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_514_Var
		.getId());
		final EList<? extends EObject> Suffix_514_list = PostfixExpression_513_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_514_list);
		Assert.assertEquals(1, Suffix_514_list.size());
		//514
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_515_Var
		 = (PostfixExpressionSuffixDot)Suffix_514_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_515_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_515_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_462_Var
		.getSemi());
		//515
		final Statement Statement_516_Var
		 = (Statement)Statement_106_list.get(7);
		Assert.assertNotNull(Statement_516_Var
		);
		//516
		final ExpressionStatement ExpressionStatement_517_Var
		 = (ExpressionStatement)Statement_516_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_517_Var
		);
		//517
		final Expression Expression_518_Var
		 = (Expression)ExpressionStatement_517_Var
		.getExpression();
		Assert.assertNotNull(Expression_518_Var
		);
		final EList<? extends EObject> ExprExpr_518_list = Expression_518_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_518_list);
		Assert.assertEquals(1, ExprExpr_518_list.size());
		//518
		final AssignmentExpression AssignmentExpression_519_Var
		 = (AssignmentExpression)ExprExpr_518_list.get(0);
		Assert.assertNotNull(AssignmentExpression_519_Var
		);
		//519
		final ConditionalExpression ConditionalExpression_520_Var
		 = (ConditionalExpression)AssignmentExpression_519_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_520_Var
		);
		//520
		final LogicalOrExpression LogicalOrExpression_521_Var
		 = (LogicalOrExpression)ConditionalExpression_520_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_521_Var
		);
		final EList<? extends EObject> Expr_521_list = LogicalOrExpression_521_Var
		.getExpr();
		Assert.assertNotNull(Expr_521_list);
		Assert.assertEquals(1, Expr_521_list.size());
		//521
		final LogicalAndExpression LogicalAndExpression_522_Var
		 = (LogicalAndExpression)Expr_521_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_522_Var
		);
		final EList<? extends EObject> Expr_522_list = LogicalAndExpression_522_Var
		.getExpr();
		Assert.assertNotNull(Expr_522_list);
		Assert.assertEquals(1, Expr_522_list.size());
		//522
		final InclusiveOrExpression InclusiveOrExpression_523_Var
		 = (InclusiveOrExpression)Expr_522_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_523_Var
		);
		final EList<? extends EObject> Expr_523_list = InclusiveOrExpression_523_Var
		.getExpr();
		Assert.assertNotNull(Expr_523_list);
		Assert.assertEquals(1, Expr_523_list.size());
		//523
		final ExclusiveOrExpression ExclusiveOrExpression_524_Var
		 = (ExclusiveOrExpression)Expr_523_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_524_Var
		);
		final EList<? extends EObject> Expr_524_list = ExclusiveOrExpression_524_Var
		.getExpr();
		Assert.assertNotNull(Expr_524_list);
		Assert.assertEquals(1, Expr_524_list.size());
		//524
		final AndExpression AndExpression_525_Var
		 = (AndExpression)Expr_524_list.get(0);
		Assert.assertNotNull(AndExpression_525_Var
		);
		final EList<? extends EObject> Expr_525_list = AndExpression_525_Var
		.getExpr();
		Assert.assertNotNull(Expr_525_list);
		Assert.assertEquals(1, Expr_525_list.size());
		//525
		final EqualityExpression EqualityExpression_526_Var
		 = (EqualityExpression)Expr_525_list.get(0);
		Assert.assertNotNull(EqualityExpression_526_Var
		);
		final EList<? extends EObject> Expr_526_list = EqualityExpression_526_Var
		.getExpr();
		Assert.assertNotNull(Expr_526_list);
		Assert.assertEquals(1, Expr_526_list.size());
		//526
		final RelationalExpression RelationalExpression_527_Var
		 = (RelationalExpression)Expr_526_list.get(0);
		Assert.assertNotNull(RelationalExpression_527_Var
		);
		final EList<? extends EObject> Expr_527_list = RelationalExpression_527_Var
		.getExpr();
		Assert.assertNotNull(Expr_527_list);
		Assert.assertEquals(1, Expr_527_list.size());
		//527
		final ShiftExpression ShiftExpression_528_Var
		 = (ShiftExpression)Expr_527_list.get(0);
		Assert.assertNotNull(ShiftExpression_528_Var
		);
		final EList<? extends EObject> Expr_528_list = ShiftExpression_528_Var
		.getExpr();
		Assert.assertNotNull(Expr_528_list);
		Assert.assertEquals(1, Expr_528_list.size());
		//528
		final AdditiveExpression AdditiveExpression_529_Var
		 = (AdditiveExpression)Expr_528_list.get(0);
		Assert.assertNotNull(AdditiveExpression_529_Var
		);
		final EList<? extends EObject> Expr_529_list = AdditiveExpression_529_Var
		.getExpr();
		Assert.assertNotNull(Expr_529_list);
		Assert.assertEquals(1, Expr_529_list.size());
		//529
		final MultiplicativeExpression MultiplicativeExpression_530_Var
		 = (MultiplicativeExpression)Expr_529_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_530_Var
		);
		final EList<? extends EObject> Expr_530_list = MultiplicativeExpression_530_Var
		.getExpr();
		Assert.assertNotNull(Expr_530_list);
		Assert.assertEquals(1, Expr_530_list.size());
		//530
		final CastExpression CastExpression_531_Var
		 = (CastExpression)Expr_530_list.get(0);
		Assert.assertNotNull(CastExpression_531_Var
		);
		//531
		final UnaryExpression UnaryExpression_532_Var
		 = (UnaryExpression)CastExpression_531_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_532_Var
		);
		//532
		final PostfixExpression PostfixExpression_533_Var
		 = (PostfixExpression)UnaryExpression_532_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_533_Var
		);
		final EList<? extends EObject> Expr_533_list = PostfixExpression_533_Var
		.getExpr();
		Assert.assertNotNull(Expr_533_list);
		Assert.assertEquals(1, Expr_533_list.size());
		//533
		final PrimaryExpression PrimaryExpression_534_Var
		 = (PrimaryExpression)Expr_533_list.get(0);
		Assert.assertNotNull(PrimaryExpression_534_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_534_Var
		.getId());
		final EList<? extends EObject> Suffix_534_list = PostfixExpression_533_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_534_list);
		Assert.assertEquals(1, Suffix_534_list.size());
		//534
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_535_Var
		 = (PostfixExpressionSuffixArgument)Suffix_534_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_535_Var
		);
		//535
		final ArgumentExpressionList ArgumentExpressionList_536_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_535_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_536_Var
		);
		final EList<? extends EObject> Expr_536_list = ArgumentExpressionList_536_Var
		.getExpr();
		Assert.assertNotNull(Expr_536_list);
		Assert.assertEquals(2, Expr_536_list.size());
		//536
		final AssignmentExpression AssignmentExpression_537_Var
		 = (AssignmentExpression)Expr_536_list.get(0);
		Assert.assertNotNull(AssignmentExpression_537_Var
		);
		//537
		final ConditionalExpression ConditionalExpression_538_Var
		 = (ConditionalExpression)AssignmentExpression_537_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_538_Var
		);
		//538
		final LogicalOrExpression LogicalOrExpression_539_Var
		 = (LogicalOrExpression)ConditionalExpression_538_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_539_Var
		);
		final EList<? extends EObject> Expr_539_list = LogicalOrExpression_539_Var
		.getExpr();
		Assert.assertNotNull(Expr_539_list);
		Assert.assertEquals(1, Expr_539_list.size());
		//539
		final LogicalAndExpression LogicalAndExpression_540_Var
		 = (LogicalAndExpression)Expr_539_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_540_Var
		);
		final EList<? extends EObject> Expr_540_list = LogicalAndExpression_540_Var
		.getExpr();
		Assert.assertNotNull(Expr_540_list);
		Assert.assertEquals(1, Expr_540_list.size());
		//540
		final InclusiveOrExpression InclusiveOrExpression_541_Var
		 = (InclusiveOrExpression)Expr_540_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_541_Var
		);
		final EList<? extends EObject> Expr_541_list = InclusiveOrExpression_541_Var
		.getExpr();
		Assert.assertNotNull(Expr_541_list);
		Assert.assertEquals(1, Expr_541_list.size());
		//541
		final ExclusiveOrExpression ExclusiveOrExpression_542_Var
		 = (ExclusiveOrExpression)Expr_541_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_542_Var
		);
		final EList<? extends EObject> Expr_542_list = ExclusiveOrExpression_542_Var
		.getExpr();
		Assert.assertNotNull(Expr_542_list);
		Assert.assertEquals(1, Expr_542_list.size());
		//542
		final AndExpression AndExpression_543_Var
		 = (AndExpression)Expr_542_list.get(0);
		Assert.assertNotNull(AndExpression_543_Var
		);
		final EList<? extends EObject> Expr_543_list = AndExpression_543_Var
		.getExpr();
		Assert.assertNotNull(Expr_543_list);
		Assert.assertEquals(1, Expr_543_list.size());
		//543
		final EqualityExpression EqualityExpression_544_Var
		 = (EqualityExpression)Expr_543_list.get(0);
		Assert.assertNotNull(EqualityExpression_544_Var
		);
		final EList<? extends EObject> Expr_544_list = EqualityExpression_544_Var
		.getExpr();
		Assert.assertNotNull(Expr_544_list);
		Assert.assertEquals(1, Expr_544_list.size());
		//544
		final RelationalExpression RelationalExpression_545_Var
		 = (RelationalExpression)Expr_544_list.get(0);
		Assert.assertNotNull(RelationalExpression_545_Var
		);
		final EList<? extends EObject> Expr_545_list = RelationalExpression_545_Var
		.getExpr();
		Assert.assertNotNull(Expr_545_list);
		Assert.assertEquals(1, Expr_545_list.size());
		//545
		final ShiftExpression ShiftExpression_546_Var
		 = (ShiftExpression)Expr_545_list.get(0);
		Assert.assertNotNull(ShiftExpression_546_Var
		);
		final EList<? extends EObject> Expr_546_list = ShiftExpression_546_Var
		.getExpr();
		Assert.assertNotNull(Expr_546_list);
		Assert.assertEquals(1, Expr_546_list.size());
		//546
		final AdditiveExpression AdditiveExpression_547_Var
		 = (AdditiveExpression)Expr_546_list.get(0);
		Assert.assertNotNull(AdditiveExpression_547_Var
		);
		final EList<? extends EObject> Expr_547_list = AdditiveExpression_547_Var
		.getExpr();
		Assert.assertNotNull(Expr_547_list);
		Assert.assertEquals(1, Expr_547_list.size());
		//547
		final MultiplicativeExpression MultiplicativeExpression_548_Var
		 = (MultiplicativeExpression)Expr_547_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_548_Var
		);
		final EList<? extends EObject> Expr_548_list = MultiplicativeExpression_548_Var
		.getExpr();
		Assert.assertNotNull(Expr_548_list);
		Assert.assertEquals(1, Expr_548_list.size());
		//548
		final CastExpression CastExpression_549_Var
		 = (CastExpression)Expr_548_list.get(0);
		Assert.assertNotNull(CastExpression_549_Var
		);
		//549
		final UnaryExpression UnaryExpression_550_Var
		 = (UnaryExpression)CastExpression_549_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_550_Var
		);
		//550
		final PostfixExpression PostfixExpression_551_Var
		 = (PostfixExpression)UnaryExpression_550_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_551_Var
		);
		final EList<? extends EObject> Expr_551_list = PostfixExpression_551_Var
		.getExpr();
		Assert.assertNotNull(Expr_551_list);
		Assert.assertEquals(1, Expr_551_list.size());
		//551
		final PrimaryExpression PrimaryExpression_552_Var
		 = (PrimaryExpression)Expr_551_list.get(0);
		Assert.assertNotNull(PrimaryExpression_552_Var
		);
		//552
		final Constant Constant_553_Var
		 = (Constant)PrimaryExpression_552_Var
		.getConst();
		Assert.assertNotNull(Constant_553_Var
		);
		Assert.assertEquals("\"phil.id=%d\\n\"", Constant_553_Var
		.getStr());
		//553
		final AssignmentExpression AssignmentExpression_554_Var
		 = (AssignmentExpression)Expr_536_list.get(1);
		Assert.assertNotNull(AssignmentExpression_554_Var
		);
		//554
		final ConditionalExpression ConditionalExpression_555_Var
		 = (ConditionalExpression)AssignmentExpression_554_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_555_Var
		);
		//555
		final LogicalOrExpression LogicalOrExpression_556_Var
		 = (LogicalOrExpression)ConditionalExpression_555_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_556_Var
		);
		final EList<? extends EObject> Expr_556_list = LogicalOrExpression_556_Var
		.getExpr();
		Assert.assertNotNull(Expr_556_list);
		Assert.assertEquals(1, Expr_556_list.size());
		//556
		final LogicalAndExpression LogicalAndExpression_557_Var
		 = (LogicalAndExpression)Expr_556_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_557_Var
		);
		final EList<? extends EObject> Expr_557_list = LogicalAndExpression_557_Var
		.getExpr();
		Assert.assertNotNull(Expr_557_list);
		Assert.assertEquals(1, Expr_557_list.size());
		//557
		final InclusiveOrExpression InclusiveOrExpression_558_Var
		 = (InclusiveOrExpression)Expr_557_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_558_Var
		);
		final EList<? extends EObject> Expr_558_list = InclusiveOrExpression_558_Var
		.getExpr();
		Assert.assertNotNull(Expr_558_list);
		Assert.assertEquals(1, Expr_558_list.size());
		//558
		final ExclusiveOrExpression ExclusiveOrExpression_559_Var
		 = (ExclusiveOrExpression)Expr_558_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_559_Var
		);
		final EList<? extends EObject> Expr_559_list = ExclusiveOrExpression_559_Var
		.getExpr();
		Assert.assertNotNull(Expr_559_list);
		Assert.assertEquals(1, Expr_559_list.size());
		//559
		final AndExpression AndExpression_560_Var
		 = (AndExpression)Expr_559_list.get(0);
		Assert.assertNotNull(AndExpression_560_Var
		);
		final EList<? extends EObject> Expr_560_list = AndExpression_560_Var
		.getExpr();
		Assert.assertNotNull(Expr_560_list);
		Assert.assertEquals(1, Expr_560_list.size());
		//560
		final EqualityExpression EqualityExpression_561_Var
		 = (EqualityExpression)Expr_560_list.get(0);
		Assert.assertNotNull(EqualityExpression_561_Var
		);
		final EList<? extends EObject> Expr_561_list = EqualityExpression_561_Var
		.getExpr();
		Assert.assertNotNull(Expr_561_list);
		Assert.assertEquals(1, Expr_561_list.size());
		//561
		final RelationalExpression RelationalExpression_562_Var
		 = (RelationalExpression)Expr_561_list.get(0);
		Assert.assertNotNull(RelationalExpression_562_Var
		);
		final EList<? extends EObject> Expr_562_list = RelationalExpression_562_Var
		.getExpr();
		Assert.assertNotNull(Expr_562_list);
		Assert.assertEquals(1, Expr_562_list.size());
		//562
		final ShiftExpression ShiftExpression_563_Var
		 = (ShiftExpression)Expr_562_list.get(0);
		Assert.assertNotNull(ShiftExpression_563_Var
		);
		final EList<? extends EObject> Expr_563_list = ShiftExpression_563_Var
		.getExpr();
		Assert.assertNotNull(Expr_563_list);
		Assert.assertEquals(1, Expr_563_list.size());
		//563
		final AdditiveExpression AdditiveExpression_564_Var
		 = (AdditiveExpression)Expr_563_list.get(0);
		Assert.assertNotNull(AdditiveExpression_564_Var
		);
		final EList<? extends EObject> Expr_564_list = AdditiveExpression_564_Var
		.getExpr();
		Assert.assertNotNull(Expr_564_list);
		Assert.assertEquals(1, Expr_564_list.size());
		//564
		final MultiplicativeExpression MultiplicativeExpression_565_Var
		 = (MultiplicativeExpression)Expr_564_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_565_Var
		);
		final EList<? extends EObject> Expr_565_list = MultiplicativeExpression_565_Var
		.getExpr();
		Assert.assertNotNull(Expr_565_list);
		Assert.assertEquals(1, Expr_565_list.size());
		//565
		final CastExpression CastExpression_566_Var
		 = (CastExpression)Expr_565_list.get(0);
		Assert.assertNotNull(CastExpression_566_Var
		);
		//566
		final UnaryExpression UnaryExpression_567_Var
		 = (UnaryExpression)CastExpression_566_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_567_Var
		);
		//567
		final PostfixExpression PostfixExpression_568_Var
		 = (PostfixExpression)UnaryExpression_567_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_568_Var
		);
		final EList<? extends EObject> Expr_568_list = PostfixExpression_568_Var
		.getExpr();
		Assert.assertNotNull(Expr_568_list);
		Assert.assertEquals(1, Expr_568_list.size());
		//568
		final PrimaryExpression PrimaryExpression_569_Var
		 = (PrimaryExpression)Expr_568_list.get(0);
		Assert.assertNotNull(PrimaryExpression_569_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_569_Var
		.getId());
		final EList<? extends EObject> Suffix_569_list = PostfixExpression_568_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_569_list);
		Assert.assertEquals(1, Suffix_569_list.size());
		//569
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_570_Var
		 = (PostfixExpressionSuffixDot)Suffix_569_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_570_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_570_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_517_Var
		.getSemi());
		//570
		final Statement Statement_571_Var
		 = (Statement)Statement_106_list.get(8);
		Assert.assertNotNull(Statement_571_Var
		);
		//571
		final ExpressionStatement ExpressionStatement_572_Var
		 = (ExpressionStatement)Statement_571_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_572_Var
		);
		//572
		final Expression Expression_573_Var
		 = (Expression)ExpressionStatement_572_Var
		.getExpression();
		Assert.assertNotNull(Expression_573_Var
		);
		final EList<? extends EObject> ExprExpr_573_list = Expression_573_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_573_list);
		Assert.assertEquals(1, ExprExpr_573_list.size());
		//573
		final AssignmentExpression AssignmentExpression_574_Var
		 = (AssignmentExpression)ExprExpr_573_list.get(0);
		Assert.assertNotNull(AssignmentExpression_574_Var
		);
		//574
		final ConditionalExpression ConditionalExpression_575_Var
		 = (ConditionalExpression)AssignmentExpression_574_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_575_Var
		);
		//575
		final LogicalOrExpression LogicalOrExpression_576_Var
		 = (LogicalOrExpression)ConditionalExpression_575_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_576_Var
		);
		final EList<? extends EObject> Expr_576_list = LogicalOrExpression_576_Var
		.getExpr();
		Assert.assertNotNull(Expr_576_list);
		Assert.assertEquals(1, Expr_576_list.size());
		//576
		final LogicalAndExpression LogicalAndExpression_577_Var
		 = (LogicalAndExpression)Expr_576_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_577_Var
		);
		final EList<? extends EObject> Expr_577_list = LogicalAndExpression_577_Var
		.getExpr();
		Assert.assertNotNull(Expr_577_list);
		Assert.assertEquals(1, Expr_577_list.size());
		//577
		final InclusiveOrExpression InclusiveOrExpression_578_Var
		 = (InclusiveOrExpression)Expr_577_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_578_Var
		);
		final EList<? extends EObject> Expr_578_list = InclusiveOrExpression_578_Var
		.getExpr();
		Assert.assertNotNull(Expr_578_list);
		Assert.assertEquals(1, Expr_578_list.size());
		//578
		final ExclusiveOrExpression ExclusiveOrExpression_579_Var
		 = (ExclusiveOrExpression)Expr_578_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_579_Var
		);
		final EList<? extends EObject> Expr_579_list = ExclusiveOrExpression_579_Var
		.getExpr();
		Assert.assertNotNull(Expr_579_list);
		Assert.assertEquals(1, Expr_579_list.size());
		//579
		final AndExpression AndExpression_580_Var
		 = (AndExpression)Expr_579_list.get(0);
		Assert.assertNotNull(AndExpression_580_Var
		);
		final EList<? extends EObject> Expr_580_list = AndExpression_580_Var
		.getExpr();
		Assert.assertNotNull(Expr_580_list);
		Assert.assertEquals(1, Expr_580_list.size());
		//580
		final EqualityExpression EqualityExpression_581_Var
		 = (EqualityExpression)Expr_580_list.get(0);
		Assert.assertNotNull(EqualityExpression_581_Var
		);
		final EList<? extends EObject> Expr_581_list = EqualityExpression_581_Var
		.getExpr();
		Assert.assertNotNull(Expr_581_list);
		Assert.assertEquals(1, Expr_581_list.size());
		//581
		final RelationalExpression RelationalExpression_582_Var
		 = (RelationalExpression)Expr_581_list.get(0);
		Assert.assertNotNull(RelationalExpression_582_Var
		);
		final EList<? extends EObject> Expr_582_list = RelationalExpression_582_Var
		.getExpr();
		Assert.assertNotNull(Expr_582_list);
		Assert.assertEquals(1, Expr_582_list.size());
		//582
		final ShiftExpression ShiftExpression_583_Var
		 = (ShiftExpression)Expr_582_list.get(0);
		Assert.assertNotNull(ShiftExpression_583_Var
		);
		final EList<? extends EObject> Expr_583_list = ShiftExpression_583_Var
		.getExpr();
		Assert.assertNotNull(Expr_583_list);
		Assert.assertEquals(1, Expr_583_list.size());
		//583
		final AdditiveExpression AdditiveExpression_584_Var
		 = (AdditiveExpression)Expr_583_list.get(0);
		Assert.assertNotNull(AdditiveExpression_584_Var
		);
		final EList<? extends EObject> Expr_584_list = AdditiveExpression_584_Var
		.getExpr();
		Assert.assertNotNull(Expr_584_list);
		Assert.assertEquals(1, Expr_584_list.size());
		//584
		final MultiplicativeExpression MultiplicativeExpression_585_Var
		 = (MultiplicativeExpression)Expr_584_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_585_Var
		);
		final EList<? extends EObject> Expr_585_list = MultiplicativeExpression_585_Var
		.getExpr();
		Assert.assertNotNull(Expr_585_list);
		Assert.assertEquals(1, Expr_585_list.size());
		//585
		final CastExpression CastExpression_586_Var
		 = (CastExpression)Expr_585_list.get(0);
		Assert.assertNotNull(CastExpression_586_Var
		);
		//586
		final UnaryExpression UnaryExpression_587_Var
		 = (UnaryExpression)CastExpression_586_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_587_Var
		);
		//587
		final PostfixExpression PostfixExpression_588_Var
		 = (PostfixExpression)UnaryExpression_587_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_588_Var
		);
		final EList<? extends EObject> Expr_588_list = PostfixExpression_588_Var
		.getExpr();
		Assert.assertNotNull(Expr_588_list);
		Assert.assertEquals(1, Expr_588_list.size());
		//588
		final PrimaryExpression PrimaryExpression_589_Var
		 = (PrimaryExpression)Expr_588_list.get(0);
		Assert.assertNotNull(PrimaryExpression_589_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_589_Var
		.getId());
		final EList<? extends EObject> Suffix_589_list = PostfixExpression_588_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_589_list);
		Assert.assertEquals(1, Suffix_589_list.size());
		//589
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_590_Var
		 = (PostfixExpressionSuffixArgument)Suffix_589_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_590_Var
		);
		//590
		final ArgumentExpressionList ArgumentExpressionList_591_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_590_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_591_Var
		);
		final EList<? extends EObject> Expr_591_list = ArgumentExpressionList_591_Var
		.getExpr();
		Assert.assertNotNull(Expr_591_list);
		Assert.assertEquals(2, Expr_591_list.size());
		//591
		final AssignmentExpression AssignmentExpression_592_Var
		 = (AssignmentExpression)Expr_591_list.get(0);
		Assert.assertNotNull(AssignmentExpression_592_Var
		);
		//592
		final ConditionalExpression ConditionalExpression_593_Var
		 = (ConditionalExpression)AssignmentExpression_592_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_593_Var
		);
		//593
		final LogicalOrExpression LogicalOrExpression_594_Var
		 = (LogicalOrExpression)ConditionalExpression_593_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_594_Var
		);
		final EList<? extends EObject> Expr_594_list = LogicalOrExpression_594_Var
		.getExpr();
		Assert.assertNotNull(Expr_594_list);
		Assert.assertEquals(1, Expr_594_list.size());
		//594
		final LogicalAndExpression LogicalAndExpression_595_Var
		 = (LogicalAndExpression)Expr_594_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_595_Var
		);
		final EList<? extends EObject> Expr_595_list = LogicalAndExpression_595_Var
		.getExpr();
		Assert.assertNotNull(Expr_595_list);
		Assert.assertEquals(1, Expr_595_list.size());
		//595
		final InclusiveOrExpression InclusiveOrExpression_596_Var
		 = (InclusiveOrExpression)Expr_595_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_596_Var
		);
		final EList<? extends EObject> Expr_596_list = InclusiveOrExpression_596_Var
		.getExpr();
		Assert.assertNotNull(Expr_596_list);
		Assert.assertEquals(1, Expr_596_list.size());
		//596
		final ExclusiveOrExpression ExclusiveOrExpression_597_Var
		 = (ExclusiveOrExpression)Expr_596_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_597_Var
		);
		final EList<? extends EObject> Expr_597_list = ExclusiveOrExpression_597_Var
		.getExpr();
		Assert.assertNotNull(Expr_597_list);
		Assert.assertEquals(1, Expr_597_list.size());
		//597
		final AndExpression AndExpression_598_Var
		 = (AndExpression)Expr_597_list.get(0);
		Assert.assertNotNull(AndExpression_598_Var
		);
		final EList<? extends EObject> Expr_598_list = AndExpression_598_Var
		.getExpr();
		Assert.assertNotNull(Expr_598_list);
		Assert.assertEquals(1, Expr_598_list.size());
		//598
		final EqualityExpression EqualityExpression_599_Var
		 = (EqualityExpression)Expr_598_list.get(0);
		Assert.assertNotNull(EqualityExpression_599_Var
		);
		final EList<? extends EObject> Expr_599_list = EqualityExpression_599_Var
		.getExpr();
		Assert.assertNotNull(Expr_599_list);
		Assert.assertEquals(1, Expr_599_list.size());
		//599
		final RelationalExpression RelationalExpression_600_Var
		 = (RelationalExpression)Expr_599_list.get(0);
		Assert.assertNotNull(RelationalExpression_600_Var
		);
		final EList<? extends EObject> Expr_600_list = RelationalExpression_600_Var
		.getExpr();
		Assert.assertNotNull(Expr_600_list);
		Assert.assertEquals(1, Expr_600_list.size());
		//600
		final ShiftExpression ShiftExpression_601_Var
		 = (ShiftExpression)Expr_600_list.get(0);
		Assert.assertNotNull(ShiftExpression_601_Var
		);
		final EList<? extends EObject> Expr_601_list = ShiftExpression_601_Var
		.getExpr();
		Assert.assertNotNull(Expr_601_list);
		Assert.assertEquals(1, Expr_601_list.size());
		//601
		final AdditiveExpression AdditiveExpression_602_Var
		 = (AdditiveExpression)Expr_601_list.get(0);
		Assert.assertNotNull(AdditiveExpression_602_Var
		);
		final EList<? extends EObject> Expr_602_list = AdditiveExpression_602_Var
		.getExpr();
		Assert.assertNotNull(Expr_602_list);
		Assert.assertEquals(1, Expr_602_list.size());
		//602
		final MultiplicativeExpression MultiplicativeExpression_603_Var
		 = (MultiplicativeExpression)Expr_602_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_603_Var
		);
		final EList<? extends EObject> Expr_603_list = MultiplicativeExpression_603_Var
		.getExpr();
		Assert.assertNotNull(Expr_603_list);
		Assert.assertEquals(1, Expr_603_list.size());
		//603
		final CastExpression CastExpression_604_Var
		 = (CastExpression)Expr_603_list.get(0);
		Assert.assertNotNull(CastExpression_604_Var
		);
		//604
		final UnaryExpression UnaryExpression_605_Var
		 = (UnaryExpression)CastExpression_604_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_605_Var
		);
		//605
		final PostfixExpression PostfixExpression_606_Var
		 = (PostfixExpression)UnaryExpression_605_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_606_Var
		);
		final EList<? extends EObject> Expr_606_list = PostfixExpression_606_Var
		.getExpr();
		Assert.assertNotNull(Expr_606_list);
		Assert.assertEquals(1, Expr_606_list.size());
		//606
		final PrimaryExpression PrimaryExpression_607_Var
		 = (PrimaryExpression)Expr_606_list.get(0);
		Assert.assertNotNull(PrimaryExpression_607_Var
		);
		//607
		final Constant Constant_608_Var
		 = (Constant)PrimaryExpression_607_Var
		.getConst();
		Assert.assertNotNull(Constant_608_Var
		);
		Assert.assertEquals("\"phil.name=%s\\n\"", Constant_608_Var
		.getStr());
		//608
		final AssignmentExpression AssignmentExpression_609_Var
		 = (AssignmentExpression)Expr_591_list.get(1);
		Assert.assertNotNull(AssignmentExpression_609_Var
		);
		//609
		final ConditionalExpression ConditionalExpression_610_Var
		 = (ConditionalExpression)AssignmentExpression_609_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_610_Var
		);
		//610
		final LogicalOrExpression LogicalOrExpression_611_Var
		 = (LogicalOrExpression)ConditionalExpression_610_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_611_Var
		);
		final EList<? extends EObject> Expr_611_list = LogicalOrExpression_611_Var
		.getExpr();
		Assert.assertNotNull(Expr_611_list);
		Assert.assertEquals(1, Expr_611_list.size());
		//611
		final LogicalAndExpression LogicalAndExpression_612_Var
		 = (LogicalAndExpression)Expr_611_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_612_Var
		);
		final EList<? extends EObject> Expr_612_list = LogicalAndExpression_612_Var
		.getExpr();
		Assert.assertNotNull(Expr_612_list);
		Assert.assertEquals(1, Expr_612_list.size());
		//612
		final InclusiveOrExpression InclusiveOrExpression_613_Var
		 = (InclusiveOrExpression)Expr_612_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_613_Var
		);
		final EList<? extends EObject> Expr_613_list = InclusiveOrExpression_613_Var
		.getExpr();
		Assert.assertNotNull(Expr_613_list);
		Assert.assertEquals(1, Expr_613_list.size());
		//613
		final ExclusiveOrExpression ExclusiveOrExpression_614_Var
		 = (ExclusiveOrExpression)Expr_613_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_614_Var
		);
		final EList<? extends EObject> Expr_614_list = ExclusiveOrExpression_614_Var
		.getExpr();
		Assert.assertNotNull(Expr_614_list);
		Assert.assertEquals(1, Expr_614_list.size());
		//614
		final AndExpression AndExpression_615_Var
		 = (AndExpression)Expr_614_list.get(0);
		Assert.assertNotNull(AndExpression_615_Var
		);
		final EList<? extends EObject> Expr_615_list = AndExpression_615_Var
		.getExpr();
		Assert.assertNotNull(Expr_615_list);
		Assert.assertEquals(1, Expr_615_list.size());
		//615
		final EqualityExpression EqualityExpression_616_Var
		 = (EqualityExpression)Expr_615_list.get(0);
		Assert.assertNotNull(EqualityExpression_616_Var
		);
		final EList<? extends EObject> Expr_616_list = EqualityExpression_616_Var
		.getExpr();
		Assert.assertNotNull(Expr_616_list);
		Assert.assertEquals(1, Expr_616_list.size());
		//616
		final RelationalExpression RelationalExpression_617_Var
		 = (RelationalExpression)Expr_616_list.get(0);
		Assert.assertNotNull(RelationalExpression_617_Var
		);
		final EList<? extends EObject> Expr_617_list = RelationalExpression_617_Var
		.getExpr();
		Assert.assertNotNull(Expr_617_list);
		Assert.assertEquals(1, Expr_617_list.size());
		//617
		final ShiftExpression ShiftExpression_618_Var
		 = (ShiftExpression)Expr_617_list.get(0);
		Assert.assertNotNull(ShiftExpression_618_Var
		);
		final EList<? extends EObject> Expr_618_list = ShiftExpression_618_Var
		.getExpr();
		Assert.assertNotNull(Expr_618_list);
		Assert.assertEquals(1, Expr_618_list.size());
		//618
		final AdditiveExpression AdditiveExpression_619_Var
		 = (AdditiveExpression)Expr_618_list.get(0);
		Assert.assertNotNull(AdditiveExpression_619_Var
		);
		final EList<? extends EObject> Expr_619_list = AdditiveExpression_619_Var
		.getExpr();
		Assert.assertNotNull(Expr_619_list);
		Assert.assertEquals(1, Expr_619_list.size());
		//619
		final MultiplicativeExpression MultiplicativeExpression_620_Var
		 = (MultiplicativeExpression)Expr_619_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_620_Var
		);
		final EList<? extends EObject> Expr_620_list = MultiplicativeExpression_620_Var
		.getExpr();
		Assert.assertNotNull(Expr_620_list);
		Assert.assertEquals(1, Expr_620_list.size());
		//620
		final CastExpression CastExpression_621_Var
		 = (CastExpression)Expr_620_list.get(0);
		Assert.assertNotNull(CastExpression_621_Var
		);
		//621
		final UnaryExpression UnaryExpression_622_Var
		 = (UnaryExpression)CastExpression_621_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_622_Var
		);
		//622
		final PostfixExpression PostfixExpression_623_Var
		 = (PostfixExpression)UnaryExpression_622_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_623_Var
		);
		final EList<? extends EObject> Expr_623_list = PostfixExpression_623_Var
		.getExpr();
		Assert.assertNotNull(Expr_623_list);
		Assert.assertEquals(1, Expr_623_list.size());
		//623
		final PrimaryExpression PrimaryExpression_624_Var
		 = (PrimaryExpression)Expr_623_list.get(0);
		Assert.assertNotNull(PrimaryExpression_624_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_624_Var
		.getId());
		final EList<? extends EObject> Suffix_624_list = PostfixExpression_623_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_624_list);
		Assert.assertEquals(1, Suffix_624_list.size());
		//624
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_625_Var
		 = (PostfixExpressionSuffixDot)Suffix_624_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_625_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixDot_625_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_572_Var
		.getSemi());
		//625
		final Statement Statement_626_Var
		 = (Statement)Statement_106_list.get(9);
		Assert.assertNotNull(Statement_626_Var
		);
		//626
		final JumpStatement JumpStatement_627_Var
		 = (JumpStatement)Statement_626_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_627_Var
		);
		//627
		final Expression Expression_628_Var
		 = (Expression)JumpStatement_627_Var
		.getExpr();
		Assert.assertNotNull(Expression_628_Var
		);
		final EList<? extends EObject> ExprExpr_628_list = Expression_628_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_628_list);
		Assert.assertEquals(1, ExprExpr_628_list.size());
		//628
		final AssignmentExpression AssignmentExpression_629_Var
		 = (AssignmentExpression)ExprExpr_628_list.get(0);
		Assert.assertNotNull(AssignmentExpression_629_Var
		);
		//629
		final ConditionalExpression ConditionalExpression_630_Var
		 = (ConditionalExpression)AssignmentExpression_629_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_630_Var
		);
		//630
		final LogicalOrExpression LogicalOrExpression_631_Var
		 = (LogicalOrExpression)ConditionalExpression_630_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_631_Var
		);
		final EList<? extends EObject> Expr_631_list = LogicalOrExpression_631_Var
		.getExpr();
		Assert.assertNotNull(Expr_631_list);
		Assert.assertEquals(1, Expr_631_list.size());
		//631
		final LogicalAndExpression LogicalAndExpression_632_Var
		 = (LogicalAndExpression)Expr_631_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_632_Var
		);
		final EList<? extends EObject> Expr_632_list = LogicalAndExpression_632_Var
		.getExpr();
		Assert.assertNotNull(Expr_632_list);
		Assert.assertEquals(1, Expr_632_list.size());
		//632
		final InclusiveOrExpression InclusiveOrExpression_633_Var
		 = (InclusiveOrExpression)Expr_632_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_633_Var
		);
		final EList<? extends EObject> Expr_633_list = InclusiveOrExpression_633_Var
		.getExpr();
		Assert.assertNotNull(Expr_633_list);
		Assert.assertEquals(1, Expr_633_list.size());
		//633
		final ExclusiveOrExpression ExclusiveOrExpression_634_Var
		 = (ExclusiveOrExpression)Expr_633_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_634_Var
		);
		final EList<? extends EObject> Expr_634_list = ExclusiveOrExpression_634_Var
		.getExpr();
		Assert.assertNotNull(Expr_634_list);
		Assert.assertEquals(1, Expr_634_list.size());
		//634
		final AndExpression AndExpression_635_Var
		 = (AndExpression)Expr_634_list.get(0);
		Assert.assertNotNull(AndExpression_635_Var
		);
		final EList<? extends EObject> Expr_635_list = AndExpression_635_Var
		.getExpr();
		Assert.assertNotNull(Expr_635_list);
		Assert.assertEquals(1, Expr_635_list.size());
		//635
		final EqualityExpression EqualityExpression_636_Var
		 = (EqualityExpression)Expr_635_list.get(0);
		Assert.assertNotNull(EqualityExpression_636_Var
		);
		final EList<? extends EObject> Expr_636_list = EqualityExpression_636_Var
		.getExpr();
		Assert.assertNotNull(Expr_636_list);
		Assert.assertEquals(1, Expr_636_list.size());
		//636
		final RelationalExpression RelationalExpression_637_Var
		 = (RelationalExpression)Expr_636_list.get(0);
		Assert.assertNotNull(RelationalExpression_637_Var
		);
		final EList<? extends EObject> Expr_637_list = RelationalExpression_637_Var
		.getExpr();
		Assert.assertNotNull(Expr_637_list);
		Assert.assertEquals(1, Expr_637_list.size());
		//637
		final ShiftExpression ShiftExpression_638_Var
		 = (ShiftExpression)Expr_637_list.get(0);
		Assert.assertNotNull(ShiftExpression_638_Var
		);
		final EList<? extends EObject> Expr_638_list = ShiftExpression_638_Var
		.getExpr();
		Assert.assertNotNull(Expr_638_list);
		Assert.assertEquals(1, Expr_638_list.size());
		//638
		final AdditiveExpression AdditiveExpression_639_Var
		 = (AdditiveExpression)Expr_638_list.get(0);
		Assert.assertNotNull(AdditiveExpression_639_Var
		);
		final EList<? extends EObject> Expr_639_list = AdditiveExpression_639_Var
		.getExpr();
		Assert.assertNotNull(Expr_639_list);
		Assert.assertEquals(1, Expr_639_list.size());
		//639
		final MultiplicativeExpression MultiplicativeExpression_640_Var
		 = (MultiplicativeExpression)Expr_639_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_640_Var
		);
		final EList<? extends EObject> Expr_640_list = MultiplicativeExpression_640_Var
		.getExpr();
		Assert.assertNotNull(Expr_640_list);
		Assert.assertEquals(1, Expr_640_list.size());
		//640
		final CastExpression CastExpression_641_Var
		 = (CastExpression)Expr_640_list.get(0);
		Assert.assertNotNull(CastExpression_641_Var
		);
		//641
		final UnaryExpression UnaryExpression_642_Var
		 = (UnaryExpression)CastExpression_641_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_642_Var
		);
		//642
		final PostfixExpression PostfixExpression_643_Var
		 = (PostfixExpression)UnaryExpression_642_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_643_Var
		);
		final EList<? extends EObject> Expr_643_list = PostfixExpression_643_Var
		.getExpr();
		Assert.assertNotNull(Expr_643_list);
		Assert.assertEquals(1, Expr_643_list.size());
		//643
		final PrimaryExpression PrimaryExpression_644_Var
		 = (PrimaryExpression)Expr_643_list.get(0);
		Assert.assertNotNull(PrimaryExpression_644_Var
		);
		//644
		final Constant Constant_645_Var
		 = (Constant)PrimaryExpression_644_Var
		.getConst();
		Assert.assertNotNull(Constant_645_Var
		);
		Assert.assertEquals("0", Constant_645_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_627_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_627_Var
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


