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
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
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
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
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
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
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
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
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
public class Test0034_Union {
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
			"res/Test0034_Union.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_LINEDIRECTIVE", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_UNION", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_CHAR", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_FLOAT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_SKW_RIGHTBRACE", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_UNION", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
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
				"RULE_KW_UNSIGNED", 
				"RULE_WHITESPACE", 
				"RULE_KW_LONG", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_KW_UNSIGNED", 
				"RULE_WHITESPACE", 
				"RULE_KW_LONG", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_KW_SIZEOF", 
				"RULE_SKW_LEFTPAREN", 
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
				"RULE_KW_FLOAT", 
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
				"RULE_DECIMAL_LITERAL", 
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
				"RULE_SKW_DOT", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_FLOAT_LITERAL", 
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
			"res/Test0034_Union.c");
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
		Assert.assertEquals("union", StructOrUnion_7_Var
		.getName());
		Assert.assertEquals("num", StructOrUnionSpecifier_6_Var
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
		Assert.assertEquals("char", TypeSpecifier_11_Var
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
		Assert.assertEquals("numChar", DirectDeclarator_15_Var
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
		Assert.assertEquals("float", TypeSpecifier_18_Var
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
		Assert.assertEquals("numFloat", DirectDeclarator_22_Var
		.getId());
		//22
		final ExternalDeclaration ExternalDeclaration_23_Var
		 = (ExternalDeclaration)External_2_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_23_Var
		);
		//23
		final Declaration Declaration_24_Var
		 = (Declaration)ExternalDeclaration_23_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_24_Var
		);
		//24
		final DeclarationSpecifiers DeclarationSpecifiers_25_Var
		 = (DeclarationSpecifiers)Declaration_24_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_25_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_25_list = DeclarationSpecifiers_25_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_25_list);
		Assert.assertEquals(1, DeclarationSpecifier_25_list.size());
		//25
		final StructOrUnionSpecifier StructOrUnionSpecifier_26_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_25_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_26_Var
		);
		//26
		final StructOrUnion StructOrUnion_27_Var
		 = (StructOrUnion)StructOrUnionSpecifier_26_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_27_Var
		);
		Assert.assertEquals("union", StructOrUnion_27_Var
		.getName());
		Assert.assertEquals("num", StructOrUnionSpecifier_26_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_27_list = Declaration_24_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_27_list);
		Assert.assertEquals(1, InitDeclaratorList_27_list.size());
		//27
		final InitDeclaratorList InitDeclaratorList_28_Var
		 = (InitDeclaratorList)InitDeclaratorList_27_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_28_Var
		);
		final EList<? extends EObject> InitDeclarator_28_list = InitDeclaratorList_28_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_28_list);
		Assert.assertEquals(1, InitDeclarator_28_list.size());
		//28
		final InitDeclarator InitDeclarator_29_Var
		 = (InitDeclarator)InitDeclarator_28_list.get(0);
		Assert.assertNotNull(InitDeclarator_29_Var
		);
		//29
		final Declarator Declarator_30_Var
		 = (Declarator)InitDeclarator_29_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_30_Var
		);
		//30
		final DirectDeclarator DirectDeclarator_31_Var
		 = (DirectDeclarator)Declarator_30_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_31_Var
		);
		Assert.assertEquals("number", DirectDeclarator_31_Var
		.getId());
		//31
		final ExternalDeclaration ExternalDeclaration_32_Var
		 = (ExternalDeclaration)External_2_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_32_Var
		);
		//32
		final FunctionDefHead FunctionDefHead_33_Var
		 = (FunctionDefHead)ExternalDeclaration_32_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_33_Var
		);
		//33
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_34_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_33_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_34_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_34_list = FunctionDeclarationSpecifiers_34_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_34_list);
		Assert.assertEquals(1, DeclarationSpecifier_34_list.size());
		//34
		final TypeSpecifier TypeSpecifier_35_Var
		 = (TypeSpecifier)DeclarationSpecifier_34_list.get(0);
		Assert.assertNotNull(TypeSpecifier_35_Var
		);
		Assert.assertEquals("int", TypeSpecifier_35_Var
		.getName());
		//35
		final Declarator Declarator_36_Var
		 = (Declarator)FunctionDefHead_33_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_36_Var
		);
		//36
		final DirectDeclarator DirectDeclarator_37_Var
		 = (DirectDeclarator)Declarator_36_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_37_Var
		);
		Assert.assertEquals("main", DirectDeclarator_37_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_37_list = DirectDeclarator_37_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_37_list);
		Assert.assertEquals(1, DeclaratorSuffix_37_list.size());
		//37
		final DeclaratorSuffix DeclaratorSuffix_38_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_37_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_38_Var
		);
		//38
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_39_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_38_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_39_Var
		);
		final EList<? extends EObject> ParameterTypeList_39_list = DirectDeclaratorLastSuffix_39_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_39_list);
		Assert.assertEquals(1, ParameterTypeList_39_list.size());
		//39
		final ParameterTypeList ParameterTypeList_40_Var
		 = (ParameterTypeList)ParameterTypeList_39_list.get(0);
		Assert.assertNotNull(ParameterTypeList_40_Var
		);
		//40
		final ParameterList ParameterList_41_Var
		 = (ParameterList)ParameterTypeList_40_Var
		.getList();
		Assert.assertNotNull(ParameterList_41_Var
		);
		final EList<? extends EObject> ParameterDeclaration_41_list = ParameterList_41_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_41_list);
		Assert.assertEquals(1, ParameterDeclaration_41_list.size());
		//41
		final ParameterDeclaration ParameterDeclaration_42_Var
		 = (ParameterDeclaration)ParameterDeclaration_41_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_42_Var
		);
		//42
		final DeclarationSpecifiers DeclarationSpecifiers_43_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_42_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_43_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_43_list = DeclarationSpecifiers_43_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_43_list);
		Assert.assertEquals(1, DeclarationSpecifier_43_list.size());
		//43
		final TypeSpecifier TypeSpecifier_44_Var
		 = (TypeSpecifier)DeclarationSpecifier_43_list.get(0);
		Assert.assertNotNull(TypeSpecifier_44_Var
		);
		Assert.assertEquals("void", TypeSpecifier_44_Var
		.getName());
		//44
		final FunctionDefinition FunctionDefinition_45_Var
		 = (FunctionDefinition)ExternalDeclaration_32_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_45_Var
		);
		//45
		final BodyStatement BodyStatement_46_Var
		 = (BodyStatement)FunctionDefinition_45_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_46_Var
		);
		final EList<? extends EObject> BlockList_46_list = BodyStatement_46_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_46_list);
		Assert.assertEquals(1, BlockList_46_list.size());
		//46
		final BlockList BlockList_47_Var
		 = (BlockList)BlockList_46_list.get(0);
		Assert.assertNotNull(BlockList_47_Var
		);
		final EList<? extends EObject> Declaration_47_list = BlockList_47_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_47_list);
		Assert.assertEquals(1, Declaration_47_list.size());
		//47
		final Declaration Declaration_48_Var
		 = (Declaration)Declaration_47_list.get(0);
		Assert.assertNotNull(Declaration_48_Var
		);
		//48
		final DeclarationSpecifiers DeclarationSpecifiers_49_Var
		 = (DeclarationSpecifiers)Declaration_48_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_49_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_49_list = DeclarationSpecifiers_49_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_49_list);
		Assert.assertEquals(2, DeclarationSpecifier_49_list.size());
		//49
		final TypeSpecifier TypeSpecifier_50_Var
		 = (TypeSpecifier)DeclarationSpecifier_49_list.get(0);
		Assert.assertNotNull(TypeSpecifier_50_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_50_Var
		.getName());
		//50
		final TypeSpecifier TypeSpecifier_51_Var
		 = (TypeSpecifier)DeclarationSpecifier_49_list.get(1);
		Assert.assertNotNull(TypeSpecifier_51_Var
		);
		Assert.assertEquals("long", TypeSpecifier_51_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_51_list = Declaration_48_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_51_list);
		Assert.assertEquals(1, InitDeclaratorList_51_list.size());
		//51
		final InitDeclaratorList InitDeclaratorList_52_Var
		 = (InitDeclaratorList)InitDeclaratorList_51_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_52_Var
		);
		final EList<? extends EObject> InitDeclarator_52_list = InitDeclaratorList_52_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_52_list);
		Assert.assertEquals(1, InitDeclarator_52_list.size());
		//52
		final InitDeclarator InitDeclarator_53_Var
		 = (InitDeclarator)InitDeclarator_52_list.get(0);
		Assert.assertNotNull(InitDeclarator_53_Var
		);
		//53
		final Declarator Declarator_54_Var
		 = (Declarator)InitDeclarator_53_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_54_Var
		);
		//54
		final DirectDeclarator DirectDeclarator_55_Var
		 = (DirectDeclarator)Declarator_54_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_55_Var
		);
		Assert.assertEquals("size", DirectDeclarator_55_Var
		.getId());
		//55
		final Initializer Initializer_56_Var
		 = (Initializer)InitDeclarator_53_Var
		.getInitializer();
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
		final TypeName TypeName_70_Var
		 = (TypeName)CastExpression_69_Var
		.getType();
		Assert.assertNotNull(TypeName_70_Var
		);
		//70
		final SpecifierQualifierList SpecifierQualifierList_71_Var
		 = (SpecifierQualifierList)TypeName_70_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_71_Var
		);
		final EList<? extends EObject> TypeSpecifier_71_list = SpecifierQualifierList_71_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_71_list);
		Assert.assertEquals(2, TypeSpecifier_71_list.size());
		//71
		final TypeSpecifier TypeSpecifier_72_Var
		 = (TypeSpecifier)TypeSpecifier_71_list.get(0);
		Assert.assertNotNull(TypeSpecifier_72_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_72_Var
		.getName());
		//72
		final TypeSpecifier TypeSpecifier_73_Var
		 = (TypeSpecifier)TypeSpecifier_71_list.get(1);
		Assert.assertNotNull(TypeSpecifier_73_Var
		);
		Assert.assertEquals("long", TypeSpecifier_73_Var
		.getName());
		//73
		final CastExpression CastExpression_74_Var
		 = (CastExpression)CastExpression_69_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_74_Var
		);
		//74
		final UnaryExpression UnaryExpression_75_Var
		 = (UnaryExpression)CastExpression_74_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_75_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_75_Var
		.getSizeOf());
		//75
		final UnaryExpression UnaryExpression_76_Var
		 = (UnaryExpression)UnaryExpression_75_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_76_Var
		);
		//76
		final PostfixExpression PostfixExpression_77_Var
		 = (PostfixExpression)UnaryExpression_76_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = PostfixExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final PrimaryExpression PrimaryExpression_78_Var
		 = (PrimaryExpression)Expr_77_list.get(0);
		Assert.assertNotNull(PrimaryExpression_78_Var
		);
		//78
		final Expression Expression_79_Var
		 = (Expression)PrimaryExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expression_79_Var
		);
		final EList<? extends EObject> ExprExpr_79_list = Expression_79_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_79_list);
		Assert.assertEquals(1, ExprExpr_79_list.size());
		//79
		final AssignmentExpression AssignmentExpression_80_Var
		 = (AssignmentExpression)ExprExpr_79_list.get(0);
		Assert.assertNotNull(AssignmentExpression_80_Var
		);
		//80
		final ConditionalExpression ConditionalExpression_81_Var
		 = (ConditionalExpression)AssignmentExpression_80_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_81_Var
		);
		//81
		final LogicalOrExpression LogicalOrExpression_82_Var
		 = (LogicalOrExpression)ConditionalExpression_81_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = LogicalOrExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final LogicalAndExpression LogicalAndExpression_83_Var
		 = (LogicalAndExpression)Expr_82_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = LogicalAndExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final InclusiveOrExpression InclusiveOrExpression_84_Var
		 = (InclusiveOrExpression)Expr_83_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = InclusiveOrExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final ExclusiveOrExpression ExclusiveOrExpression_85_Var
		 = (ExclusiveOrExpression)Expr_84_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = ExclusiveOrExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final AndExpression AndExpression_86_Var
		 = (AndExpression)Expr_85_list.get(0);
		Assert.assertNotNull(AndExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = AndExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final EqualityExpression EqualityExpression_87_Var
		 = (EqualityExpression)Expr_86_list.get(0);
		Assert.assertNotNull(EqualityExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = EqualityExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final RelationalExpression RelationalExpression_88_Var
		 = (RelationalExpression)Expr_87_list.get(0);
		Assert.assertNotNull(RelationalExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = RelationalExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final ShiftExpression ShiftExpression_89_Var
		 = (ShiftExpression)Expr_88_list.get(0);
		Assert.assertNotNull(ShiftExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = ShiftExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final AdditiveExpression AdditiveExpression_90_Var
		 = (AdditiveExpression)Expr_89_list.get(0);
		Assert.assertNotNull(AdditiveExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = AdditiveExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final MultiplicativeExpression MultiplicativeExpression_91_Var
		 = (MultiplicativeExpression)Expr_90_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = MultiplicativeExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final CastExpression CastExpression_92_Var
		 = (CastExpression)Expr_91_list.get(0);
		Assert.assertNotNull(CastExpression_92_Var
		);
		//92
		final UnaryExpression UnaryExpression_93_Var
		 = (UnaryExpression)CastExpression_92_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_93_Var
		);
		//93
		final PostfixExpression PostfixExpression_94_Var
		 = (PostfixExpression)UnaryExpression_93_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = PostfixExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final PrimaryExpression PrimaryExpression_95_Var
		 = (PrimaryExpression)Expr_94_list.get(0);
		Assert.assertNotNull(PrimaryExpression_95_Var
		);
		Assert.assertEquals("number", PrimaryExpression_95_Var
		.getId());
		final EList<? extends EObject> Statement_95_list = BlockList_47_Var
		.getStatement();
		Assert.assertNotNull(Statement_95_list);
		Assert.assertEquals(11, Statement_95_list.size());
		//95
		final Statement Statement_96_Var
		 = (Statement)Statement_95_list.get(0);
		Assert.assertNotNull(Statement_96_Var
		);
		//96
		final ExpressionStatement ExpressionStatement_97_Var
		 = (ExpressionStatement)Statement_96_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_97_Var
		);
		//97
		final Expression Expression_98_Var
		 = (Expression)ExpressionStatement_97_Var
		.getExpression();
		Assert.assertNotNull(Expression_98_Var
		);
		final EList<? extends EObject> ExprExpr_98_list = Expression_98_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_98_list);
		Assert.assertEquals(1, ExprExpr_98_list.size());
		//98
		final AssignmentExpression AssignmentExpression_99_Var
		 = (AssignmentExpression)ExprExpr_98_list.get(0);
		Assert.assertNotNull(AssignmentExpression_99_Var
		);
		//99
		final ConditionalExpression ConditionalExpression_100_Var
		 = (ConditionalExpression)AssignmentExpression_99_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_100_Var
		);
		//100
		final LogicalOrExpression LogicalOrExpression_101_Var
		 = (LogicalOrExpression)ConditionalExpression_100_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = LogicalOrExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final LogicalAndExpression LogicalAndExpression_102_Var
		 = (LogicalAndExpression)Expr_101_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = LogicalAndExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final InclusiveOrExpression InclusiveOrExpression_103_Var
		 = (InclusiveOrExpression)Expr_102_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = InclusiveOrExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final ExclusiveOrExpression ExclusiveOrExpression_104_Var
		 = (ExclusiveOrExpression)Expr_103_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = ExclusiveOrExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final AndExpression AndExpression_105_Var
		 = (AndExpression)Expr_104_list.get(0);
		Assert.assertNotNull(AndExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = AndExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final EqualityExpression EqualityExpression_106_Var
		 = (EqualityExpression)Expr_105_list.get(0);
		Assert.assertNotNull(EqualityExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = EqualityExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final RelationalExpression RelationalExpression_107_Var
		 = (RelationalExpression)Expr_106_list.get(0);
		Assert.assertNotNull(RelationalExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = RelationalExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final ShiftExpression ShiftExpression_108_Var
		 = (ShiftExpression)Expr_107_list.get(0);
		Assert.assertNotNull(ShiftExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = ShiftExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final AdditiveExpression AdditiveExpression_109_Var
		 = (AdditiveExpression)Expr_108_list.get(0);
		Assert.assertNotNull(AdditiveExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = AdditiveExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final MultiplicativeExpression MultiplicativeExpression_110_Var
		 = (MultiplicativeExpression)Expr_109_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = MultiplicativeExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final CastExpression CastExpression_111_Var
		 = (CastExpression)Expr_110_list.get(0);
		Assert.assertNotNull(CastExpression_111_Var
		);
		//111
		final UnaryExpression UnaryExpression_112_Var
		 = (UnaryExpression)CastExpression_111_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_112_Var
		);
		//112
		final PostfixExpression PostfixExpression_113_Var
		 = (PostfixExpression)UnaryExpression_112_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = PostfixExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final PrimaryExpression PrimaryExpression_114_Var
		 = (PrimaryExpression)Expr_113_list.get(0);
		Assert.assertNotNull(PrimaryExpression_114_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_114_Var
		.getId());
		final EList<? extends EObject> Suffix_114_list = PostfixExpression_113_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_114_list);
		Assert.assertEquals(1, Suffix_114_list.size());
		//114
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_115_Var
		 = (PostfixExpressionSuffixArgument)Suffix_114_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_115_Var
		);
		//115
		final ArgumentExpressionList ArgumentExpressionList_116_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_115_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_116_Var
		);
		final EList<? extends EObject> Expr_116_list = ArgumentExpressionList_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(2, Expr_116_list.size());
		//116
		final AssignmentExpression AssignmentExpression_117_Var
		 = (AssignmentExpression)Expr_116_list.get(0);
		Assert.assertNotNull(AssignmentExpression_117_Var
		);
		//117
		final ConditionalExpression ConditionalExpression_118_Var
		 = (ConditionalExpression)AssignmentExpression_117_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_118_Var
		);
		//118
		final LogicalOrExpression LogicalOrExpression_119_Var
		 = (LogicalOrExpression)ConditionalExpression_118_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = LogicalOrExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final LogicalAndExpression LogicalAndExpression_120_Var
		 = (LogicalAndExpression)Expr_119_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = LogicalAndExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final InclusiveOrExpression InclusiveOrExpression_121_Var
		 = (InclusiveOrExpression)Expr_120_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = InclusiveOrExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final ExclusiveOrExpression ExclusiveOrExpression_122_Var
		 = (ExclusiveOrExpression)Expr_121_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = ExclusiveOrExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final AndExpression AndExpression_123_Var
		 = (AndExpression)Expr_122_list.get(0);
		Assert.assertNotNull(AndExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = AndExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final EqualityExpression EqualityExpression_124_Var
		 = (EqualityExpression)Expr_123_list.get(0);
		Assert.assertNotNull(EqualityExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = EqualityExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final RelationalExpression RelationalExpression_125_Var
		 = (RelationalExpression)Expr_124_list.get(0);
		Assert.assertNotNull(RelationalExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = RelationalExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final ShiftExpression ShiftExpression_126_Var
		 = (ShiftExpression)Expr_125_list.get(0);
		Assert.assertNotNull(ShiftExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = ShiftExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final AdditiveExpression AdditiveExpression_127_Var
		 = (AdditiveExpression)Expr_126_list.get(0);
		Assert.assertNotNull(AdditiveExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = AdditiveExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final MultiplicativeExpression MultiplicativeExpression_128_Var
		 = (MultiplicativeExpression)Expr_127_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = MultiplicativeExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final CastExpression CastExpression_129_Var
		 = (CastExpression)Expr_128_list.get(0);
		Assert.assertNotNull(CastExpression_129_Var
		);
		//129
		final UnaryExpression UnaryExpression_130_Var
		 = (UnaryExpression)CastExpression_129_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_130_Var
		);
		//130
		final PostfixExpression PostfixExpression_131_Var
		 = (PostfixExpression)UnaryExpression_130_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = PostfixExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final PrimaryExpression PrimaryExpression_132_Var
		 = (PrimaryExpression)Expr_131_list.get(0);
		Assert.assertNotNull(PrimaryExpression_132_Var
		);
		//132
		final Constant2 Constant2_133_Var
		 = (Constant2)PrimaryExpression_132_Var
		.getConst();
		Assert.assertNotNull(Constant2_133_Var
		);
		Assert.assertEquals("\"sizeof(number)=%lu\\n\"", Constant2_133_Var
		.getStr());
		//133
		final AssignmentExpression AssignmentExpression_134_Var
		 = (AssignmentExpression)Expr_116_list.get(1);
		Assert.assertNotNull(AssignmentExpression_134_Var
		);
		//134
		final ConditionalExpression ConditionalExpression_135_Var
		 = (ConditionalExpression)AssignmentExpression_134_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_135_Var
		);
		//135
		final LogicalOrExpression LogicalOrExpression_136_Var
		 = (LogicalOrExpression)ConditionalExpression_135_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = LogicalOrExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final LogicalAndExpression LogicalAndExpression_137_Var
		 = (LogicalAndExpression)Expr_136_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = LogicalAndExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final InclusiveOrExpression InclusiveOrExpression_138_Var
		 = (InclusiveOrExpression)Expr_137_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = InclusiveOrExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final ExclusiveOrExpression ExclusiveOrExpression_139_Var
		 = (ExclusiveOrExpression)Expr_138_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = ExclusiveOrExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final AndExpression AndExpression_140_Var
		 = (AndExpression)Expr_139_list.get(0);
		Assert.assertNotNull(AndExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = AndExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final EqualityExpression EqualityExpression_141_Var
		 = (EqualityExpression)Expr_140_list.get(0);
		Assert.assertNotNull(EqualityExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = EqualityExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final RelationalExpression RelationalExpression_142_Var
		 = (RelationalExpression)Expr_141_list.get(0);
		Assert.assertNotNull(RelationalExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = RelationalExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final ShiftExpression ShiftExpression_143_Var
		 = (ShiftExpression)Expr_142_list.get(0);
		Assert.assertNotNull(ShiftExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = ShiftExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final AdditiveExpression AdditiveExpression_144_Var
		 = (AdditiveExpression)Expr_143_list.get(0);
		Assert.assertNotNull(AdditiveExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = AdditiveExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final MultiplicativeExpression MultiplicativeExpression_145_Var
		 = (MultiplicativeExpression)Expr_144_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = MultiplicativeExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final CastExpression CastExpression_146_Var
		 = (CastExpression)Expr_145_list.get(0);
		Assert.assertNotNull(CastExpression_146_Var
		);
		//146
		final UnaryExpression UnaryExpression_147_Var
		 = (UnaryExpression)CastExpression_146_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_147_Var
		);
		//147
		final PostfixExpression PostfixExpression_148_Var
		 = (PostfixExpression)UnaryExpression_147_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_148_Var
		);
		final EList<? extends EObject> Expr_148_list = PostfixExpression_148_Var
		.getExpr();
		Assert.assertNotNull(Expr_148_list);
		Assert.assertEquals(1, Expr_148_list.size());
		//148
		final PrimaryExpression PrimaryExpression_149_Var
		 = (PrimaryExpression)Expr_148_list.get(0);
		Assert.assertNotNull(PrimaryExpression_149_Var
		);
		Assert.assertEquals("size", PrimaryExpression_149_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_97_Var
		.getSemi());
		//149
		final Statement Statement_150_Var
		 = (Statement)Statement_95_list.get(1);
		Assert.assertNotNull(Statement_150_Var
		);
		//150
		final ExpressionStatement ExpressionStatement_151_Var
		 = (ExpressionStatement)Statement_150_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_151_Var
		);
		//151
		final Expression Expression_152_Var
		 = (Expression)ExpressionStatement_151_Var
		.getExpression();
		Assert.assertNotNull(Expression_152_Var
		);
		final EList<? extends EObject> ExprExpr_152_list = Expression_152_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_152_list);
		Assert.assertEquals(1, ExprExpr_152_list.size());
		//152
		final AssignmentExpression AssignmentExpression_153_Var
		 = (AssignmentExpression)ExprExpr_152_list.get(0);
		Assert.assertNotNull(AssignmentExpression_153_Var
		);
		//153
		final ConditionalExpression ConditionalExpression_154_Var
		 = (ConditionalExpression)AssignmentExpression_153_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_154_Var
		);
		//154
		final LogicalOrExpression LogicalOrExpression_155_Var
		 = (LogicalOrExpression)ConditionalExpression_154_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_155_Var
		);
		final EList<? extends EObject> Expr_155_list = LogicalOrExpression_155_Var
		.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		//155
		final LogicalAndExpression LogicalAndExpression_156_Var
		 = (LogicalAndExpression)Expr_155_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_156_Var
		);
		final EList<? extends EObject> Expr_156_list = LogicalAndExpression_156_Var
		.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		//156
		final InclusiveOrExpression InclusiveOrExpression_157_Var
		 = (InclusiveOrExpression)Expr_156_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = InclusiveOrExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final ExclusiveOrExpression ExclusiveOrExpression_158_Var
		 = (ExclusiveOrExpression)Expr_157_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = ExclusiveOrExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final AndExpression AndExpression_159_Var
		 = (AndExpression)Expr_158_list.get(0);
		Assert.assertNotNull(AndExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = AndExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final EqualityExpression EqualityExpression_160_Var
		 = (EqualityExpression)Expr_159_list.get(0);
		Assert.assertNotNull(EqualityExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = EqualityExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final RelationalExpression RelationalExpression_161_Var
		 = (RelationalExpression)Expr_160_list.get(0);
		Assert.assertNotNull(RelationalExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = RelationalExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final ShiftExpression ShiftExpression_162_Var
		 = (ShiftExpression)Expr_161_list.get(0);
		Assert.assertNotNull(ShiftExpression_162_Var
		);
		final EList<? extends EObject> Expr_162_list = ShiftExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		//162
		final AdditiveExpression AdditiveExpression_163_Var
		 = (AdditiveExpression)Expr_162_list.get(0);
		Assert.assertNotNull(AdditiveExpression_163_Var
		);
		final EList<? extends EObject> Expr_163_list = AdditiveExpression_163_Var
		.getExpr();
		Assert.assertNotNull(Expr_163_list);
		Assert.assertEquals(1, Expr_163_list.size());
		//163
		final MultiplicativeExpression MultiplicativeExpression_164_Var
		 = (MultiplicativeExpression)Expr_163_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_164_Var
		);
		final EList<? extends EObject> Expr_164_list = MultiplicativeExpression_164_Var
		.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		//164
		final CastExpression CastExpression_165_Var
		 = (CastExpression)Expr_164_list.get(0);
		Assert.assertNotNull(CastExpression_165_Var
		);
		//165
		final UnaryExpression UnaryExpression_166_Var
		 = (UnaryExpression)CastExpression_165_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_166_Var
		);
		//166
		final PostfixExpression PostfixExpression_167_Var
		 = (PostfixExpression)UnaryExpression_166_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_167_Var
		);
		final EList<? extends EObject> Expr_167_list = PostfixExpression_167_Var
		.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(1, Expr_167_list.size());
		//167
		final PrimaryExpression PrimaryExpression_168_Var
		 = (PrimaryExpression)Expr_167_list.get(0);
		Assert.assertNotNull(PrimaryExpression_168_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_168_Var
		.getId());
		final EList<? extends EObject> Suffix_168_list = PostfixExpression_167_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_168_list);
		Assert.assertEquals(1, Suffix_168_list.size());
		//168
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_169_Var
		 = (PostfixExpressionSuffixArgument)Suffix_168_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_169_Var
		);
		//169
		final ArgumentExpressionList ArgumentExpressionList_170_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_169_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_170_Var
		);
		final EList<? extends EObject> Expr_170_list = ArgumentExpressionList_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(2, Expr_170_list.size());
		//170
		final AssignmentExpression AssignmentExpression_171_Var
		 = (AssignmentExpression)Expr_170_list.get(0);
		Assert.assertNotNull(AssignmentExpression_171_Var
		);
		//171
		final ConditionalExpression ConditionalExpression_172_Var
		 = (ConditionalExpression)AssignmentExpression_171_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_172_Var
		);
		//172
		final LogicalOrExpression LogicalOrExpression_173_Var
		 = (LogicalOrExpression)ConditionalExpression_172_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = LogicalOrExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final LogicalAndExpression LogicalAndExpression_174_Var
		 = (LogicalAndExpression)Expr_173_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = LogicalAndExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final InclusiveOrExpression InclusiveOrExpression_175_Var
		 = (InclusiveOrExpression)Expr_174_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = InclusiveOrExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final ExclusiveOrExpression ExclusiveOrExpression_176_Var
		 = (ExclusiveOrExpression)Expr_175_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = ExclusiveOrExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final AndExpression AndExpression_177_Var
		 = (AndExpression)Expr_176_list.get(0);
		Assert.assertNotNull(AndExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = AndExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final EqualityExpression EqualityExpression_178_Var
		 = (EqualityExpression)Expr_177_list.get(0);
		Assert.assertNotNull(EqualityExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = EqualityExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final RelationalExpression RelationalExpression_179_Var
		 = (RelationalExpression)Expr_178_list.get(0);
		Assert.assertNotNull(RelationalExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = RelationalExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final ShiftExpression ShiftExpression_180_Var
		 = (ShiftExpression)Expr_179_list.get(0);
		Assert.assertNotNull(ShiftExpression_180_Var
		);
		final EList<? extends EObject> Expr_180_list = ShiftExpression_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final AdditiveExpression AdditiveExpression_181_Var
		 = (AdditiveExpression)Expr_180_list.get(0);
		Assert.assertNotNull(AdditiveExpression_181_Var
		);
		final EList<? extends EObject> Expr_181_list = AdditiveExpression_181_Var
		.getExpr();
		Assert.assertNotNull(Expr_181_list);
		Assert.assertEquals(1, Expr_181_list.size());
		//181
		final MultiplicativeExpression MultiplicativeExpression_182_Var
		 = (MultiplicativeExpression)Expr_181_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_182_Var
		);
		final EList<? extends EObject> Expr_182_list = MultiplicativeExpression_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(1, Expr_182_list.size());
		//182
		final CastExpression CastExpression_183_Var
		 = (CastExpression)Expr_182_list.get(0);
		Assert.assertNotNull(CastExpression_183_Var
		);
		//183
		final UnaryExpression UnaryExpression_184_Var
		 = (UnaryExpression)CastExpression_183_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_184_Var
		);
		//184
		final PostfixExpression PostfixExpression_185_Var
		 = (PostfixExpression)UnaryExpression_184_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_185_Var
		);
		final EList<? extends EObject> Expr_185_list = PostfixExpression_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final PrimaryExpression PrimaryExpression_186_Var
		 = (PrimaryExpression)Expr_185_list.get(0);
		Assert.assertNotNull(PrimaryExpression_186_Var
		);
		//186
		final Constant2 Constant2_187_Var
		 = (Constant2)PrimaryExpression_186_Var
		.getConst();
		Assert.assertNotNull(Constant2_187_Var
		);
		Assert.assertEquals("\"sizeof(number.numChar)=%lu\\n\"", Constant2_187_Var
		.getStr());
		//187
		final AssignmentExpression AssignmentExpression_188_Var
		 = (AssignmentExpression)Expr_170_list.get(1);
		Assert.assertNotNull(AssignmentExpression_188_Var
		);
		//188
		final ConditionalExpression ConditionalExpression_189_Var
		 = (ConditionalExpression)AssignmentExpression_188_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_189_Var
		);
		//189
		final LogicalOrExpression LogicalOrExpression_190_Var
		 = (LogicalOrExpression)ConditionalExpression_189_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = LogicalOrExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final LogicalAndExpression LogicalAndExpression_191_Var
		 = (LogicalAndExpression)Expr_190_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = LogicalAndExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final InclusiveOrExpression InclusiveOrExpression_192_Var
		 = (InclusiveOrExpression)Expr_191_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = InclusiveOrExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final ExclusiveOrExpression ExclusiveOrExpression_193_Var
		 = (ExclusiveOrExpression)Expr_192_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = ExclusiveOrExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final AndExpression AndExpression_194_Var
		 = (AndExpression)Expr_193_list.get(0);
		Assert.assertNotNull(AndExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = AndExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final EqualityExpression EqualityExpression_195_Var
		 = (EqualityExpression)Expr_194_list.get(0);
		Assert.assertNotNull(EqualityExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = EqualityExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final RelationalExpression RelationalExpression_196_Var
		 = (RelationalExpression)Expr_195_list.get(0);
		Assert.assertNotNull(RelationalExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = RelationalExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final ShiftExpression ShiftExpression_197_Var
		 = (ShiftExpression)Expr_196_list.get(0);
		Assert.assertNotNull(ShiftExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = ShiftExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final AdditiveExpression AdditiveExpression_198_Var
		 = (AdditiveExpression)Expr_197_list.get(0);
		Assert.assertNotNull(AdditiveExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = AdditiveExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final MultiplicativeExpression MultiplicativeExpression_199_Var
		 = (MultiplicativeExpression)Expr_198_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = MultiplicativeExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final CastExpression CastExpression_200_Var
		 = (CastExpression)Expr_199_list.get(0);
		Assert.assertNotNull(CastExpression_200_Var
		);
		//200
		final UnaryExpression UnaryExpression_201_Var
		 = (UnaryExpression)CastExpression_200_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_201_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_201_Var
		.getSizeOf());
		//201
		final UnaryExpression UnaryExpression_202_Var
		 = (UnaryExpression)UnaryExpression_201_Var
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
		final Expression Expression_205_Var
		 = (Expression)PrimaryExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expression_205_Var
		);
		final EList<? extends EObject> ExprExpr_205_list = Expression_205_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_205_list);
		Assert.assertEquals(1, ExprExpr_205_list.size());
		//205
		final AssignmentExpression AssignmentExpression_206_Var
		 = (AssignmentExpression)ExprExpr_205_list.get(0);
		Assert.assertNotNull(AssignmentExpression_206_Var
		);
		//206
		final ConditionalExpression ConditionalExpression_207_Var
		 = (ConditionalExpression)AssignmentExpression_206_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_207_Var
		);
		//207
		final LogicalOrExpression LogicalOrExpression_208_Var
		 = (LogicalOrExpression)ConditionalExpression_207_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = LogicalOrExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final LogicalAndExpression LogicalAndExpression_209_Var
		 = (LogicalAndExpression)Expr_208_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = LogicalAndExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final InclusiveOrExpression InclusiveOrExpression_210_Var
		 = (InclusiveOrExpression)Expr_209_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = InclusiveOrExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final ExclusiveOrExpression ExclusiveOrExpression_211_Var
		 = (ExclusiveOrExpression)Expr_210_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = ExclusiveOrExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final AndExpression AndExpression_212_Var
		 = (AndExpression)Expr_211_list.get(0);
		Assert.assertNotNull(AndExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = AndExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final EqualityExpression EqualityExpression_213_Var
		 = (EqualityExpression)Expr_212_list.get(0);
		Assert.assertNotNull(EqualityExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = EqualityExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final RelationalExpression RelationalExpression_214_Var
		 = (RelationalExpression)Expr_213_list.get(0);
		Assert.assertNotNull(RelationalExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = RelationalExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final ShiftExpression ShiftExpression_215_Var
		 = (ShiftExpression)Expr_214_list.get(0);
		Assert.assertNotNull(ShiftExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = ShiftExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final AdditiveExpression AdditiveExpression_216_Var
		 = (AdditiveExpression)Expr_215_list.get(0);
		Assert.assertNotNull(AdditiveExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = AdditiveExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final MultiplicativeExpression MultiplicativeExpression_217_Var
		 = (MultiplicativeExpression)Expr_216_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = MultiplicativeExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final CastExpression CastExpression_218_Var
		 = (CastExpression)Expr_217_list.get(0);
		Assert.assertNotNull(CastExpression_218_Var
		);
		//218
		final UnaryExpression UnaryExpression_219_Var
		 = (UnaryExpression)CastExpression_218_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_219_Var
		);
		//219
		final PostfixExpression PostfixExpression_220_Var
		 = (PostfixExpression)UnaryExpression_219_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = PostfixExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final PrimaryExpression PrimaryExpression_221_Var
		 = (PrimaryExpression)Expr_220_list.get(0);
		Assert.assertNotNull(PrimaryExpression_221_Var
		);
		Assert.assertEquals("number", PrimaryExpression_221_Var
		.getId());
		final EList<? extends EObject> Suffix_221_list = PostfixExpression_220_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_221_list);
		Assert.assertEquals(1, Suffix_221_list.size());
		//221
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_222_Var
		 = (PostfixExpressionSuffixDot)Suffix_221_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_222_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_222_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_151_Var
		.getSemi());
		//222
		final Statement Statement_223_Var
		 = (Statement)Statement_95_list.get(2);
		Assert.assertNotNull(Statement_223_Var
		);
		//223
		final ExpressionStatement ExpressionStatement_224_Var
		 = (ExpressionStatement)Statement_223_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_224_Var
		);
		//224
		final Expression Expression_225_Var
		 = (Expression)ExpressionStatement_224_Var
		.getExpression();
		Assert.assertNotNull(Expression_225_Var
		);
		final EList<? extends EObject> ExprExpr_225_list = Expression_225_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_225_list);
		Assert.assertEquals(1, ExprExpr_225_list.size());
		//225
		final AssignmentExpression AssignmentExpression_226_Var
		 = (AssignmentExpression)ExprExpr_225_list.get(0);
		Assert.assertNotNull(AssignmentExpression_226_Var
		);
		//226
		final ConditionalExpression ConditionalExpression_227_Var
		 = (ConditionalExpression)AssignmentExpression_226_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_227_Var
		);
		//227
		final LogicalOrExpression LogicalOrExpression_228_Var
		 = (LogicalOrExpression)ConditionalExpression_227_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = LogicalOrExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final LogicalAndExpression LogicalAndExpression_229_Var
		 = (LogicalAndExpression)Expr_228_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = LogicalAndExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final InclusiveOrExpression InclusiveOrExpression_230_Var
		 = (InclusiveOrExpression)Expr_229_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = InclusiveOrExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final ExclusiveOrExpression ExclusiveOrExpression_231_Var
		 = (ExclusiveOrExpression)Expr_230_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = ExclusiveOrExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final AndExpression AndExpression_232_Var
		 = (AndExpression)Expr_231_list.get(0);
		Assert.assertNotNull(AndExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = AndExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final EqualityExpression EqualityExpression_233_Var
		 = (EqualityExpression)Expr_232_list.get(0);
		Assert.assertNotNull(EqualityExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = EqualityExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final RelationalExpression RelationalExpression_234_Var
		 = (RelationalExpression)Expr_233_list.get(0);
		Assert.assertNotNull(RelationalExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = RelationalExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final ShiftExpression ShiftExpression_235_Var
		 = (ShiftExpression)Expr_234_list.get(0);
		Assert.assertNotNull(ShiftExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = ShiftExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final AdditiveExpression AdditiveExpression_236_Var
		 = (AdditiveExpression)Expr_235_list.get(0);
		Assert.assertNotNull(AdditiveExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = AdditiveExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final MultiplicativeExpression MultiplicativeExpression_237_Var
		 = (MultiplicativeExpression)Expr_236_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = MultiplicativeExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final CastExpression CastExpression_238_Var
		 = (CastExpression)Expr_237_list.get(0);
		Assert.assertNotNull(CastExpression_238_Var
		);
		//238
		final UnaryExpression UnaryExpression_239_Var
		 = (UnaryExpression)CastExpression_238_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_239_Var
		);
		//239
		final PostfixExpression PostfixExpression_240_Var
		 = (PostfixExpression)UnaryExpression_239_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = PostfixExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final PrimaryExpression PrimaryExpression_241_Var
		 = (PrimaryExpression)Expr_240_list.get(0);
		Assert.assertNotNull(PrimaryExpression_241_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_241_Var
		.getId());
		final EList<? extends EObject> Suffix_241_list = PostfixExpression_240_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_241_list);
		Assert.assertEquals(1, Suffix_241_list.size());
		//241
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_242_Var
		 = (PostfixExpressionSuffixArgument)Suffix_241_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_242_Var
		);
		//242
		final ArgumentExpressionList ArgumentExpressionList_243_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_242_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_243_Var
		);
		final EList<? extends EObject> Expr_243_list = ArgumentExpressionList_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(2, Expr_243_list.size());
		//243
		final AssignmentExpression AssignmentExpression_244_Var
		 = (AssignmentExpression)Expr_243_list.get(0);
		Assert.assertNotNull(AssignmentExpression_244_Var
		);
		//244
		final ConditionalExpression ConditionalExpression_245_Var
		 = (ConditionalExpression)AssignmentExpression_244_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_245_Var
		);
		//245
		final LogicalOrExpression LogicalOrExpression_246_Var
		 = (LogicalOrExpression)ConditionalExpression_245_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = LogicalOrExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final LogicalAndExpression LogicalAndExpression_247_Var
		 = (LogicalAndExpression)Expr_246_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = LogicalAndExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final InclusiveOrExpression InclusiveOrExpression_248_Var
		 = (InclusiveOrExpression)Expr_247_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = InclusiveOrExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final ExclusiveOrExpression ExclusiveOrExpression_249_Var
		 = (ExclusiveOrExpression)Expr_248_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = ExclusiveOrExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final AndExpression AndExpression_250_Var
		 = (AndExpression)Expr_249_list.get(0);
		Assert.assertNotNull(AndExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = AndExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final EqualityExpression EqualityExpression_251_Var
		 = (EqualityExpression)Expr_250_list.get(0);
		Assert.assertNotNull(EqualityExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = EqualityExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final RelationalExpression RelationalExpression_252_Var
		 = (RelationalExpression)Expr_251_list.get(0);
		Assert.assertNotNull(RelationalExpression_252_Var
		);
		final EList<? extends EObject> Expr_252_list = RelationalExpression_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(1, Expr_252_list.size());
		//252
		final ShiftExpression ShiftExpression_253_Var
		 = (ShiftExpression)Expr_252_list.get(0);
		Assert.assertNotNull(ShiftExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = ShiftExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final AdditiveExpression AdditiveExpression_254_Var
		 = (AdditiveExpression)Expr_253_list.get(0);
		Assert.assertNotNull(AdditiveExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = AdditiveExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final MultiplicativeExpression MultiplicativeExpression_255_Var
		 = (MultiplicativeExpression)Expr_254_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_255_Var
		);
		final EList<? extends EObject> Expr_255_list = MultiplicativeExpression_255_Var
		.getExpr();
		Assert.assertNotNull(Expr_255_list);
		Assert.assertEquals(1, Expr_255_list.size());
		//255
		final CastExpression CastExpression_256_Var
		 = (CastExpression)Expr_255_list.get(0);
		Assert.assertNotNull(CastExpression_256_Var
		);
		//256
		final UnaryExpression UnaryExpression_257_Var
		 = (UnaryExpression)CastExpression_256_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_257_Var
		);
		//257
		final PostfixExpression PostfixExpression_258_Var
		 = (PostfixExpression)UnaryExpression_257_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_258_Var
		);
		final EList<? extends EObject> Expr_258_list = PostfixExpression_258_Var
		.getExpr();
		Assert.assertNotNull(Expr_258_list);
		Assert.assertEquals(1, Expr_258_list.size());
		//258
		final PrimaryExpression PrimaryExpression_259_Var
		 = (PrimaryExpression)Expr_258_list.get(0);
		Assert.assertNotNull(PrimaryExpression_259_Var
		);
		//259
		final Constant2 Constant2_260_Var
		 = (Constant2)PrimaryExpression_259_Var
		.getConst();
		Assert.assertNotNull(Constant2_260_Var
		);
		Assert.assertEquals("\"sizeof(float)=%lu\\n\"", Constant2_260_Var
		.getStr());
		//260
		final AssignmentExpression AssignmentExpression_261_Var
		 = (AssignmentExpression)Expr_243_list.get(1);
		Assert.assertNotNull(AssignmentExpression_261_Var
		);
		//261
		final ConditionalExpression ConditionalExpression_262_Var
		 = (ConditionalExpression)AssignmentExpression_261_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_262_Var
		);
		//262
		final LogicalOrExpression LogicalOrExpression_263_Var
		 = (LogicalOrExpression)ConditionalExpression_262_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_263_Var
		);
		final EList<? extends EObject> Expr_263_list = LogicalOrExpression_263_Var
		.getExpr();
		Assert.assertNotNull(Expr_263_list);
		Assert.assertEquals(1, Expr_263_list.size());
		//263
		final LogicalAndExpression LogicalAndExpression_264_Var
		 = (LogicalAndExpression)Expr_263_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_264_Var
		);
		final EList<? extends EObject> Expr_264_list = LogicalAndExpression_264_Var
		.getExpr();
		Assert.assertNotNull(Expr_264_list);
		Assert.assertEquals(1, Expr_264_list.size());
		//264
		final InclusiveOrExpression InclusiveOrExpression_265_Var
		 = (InclusiveOrExpression)Expr_264_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_265_Var
		);
		final EList<? extends EObject> Expr_265_list = InclusiveOrExpression_265_Var
		.getExpr();
		Assert.assertNotNull(Expr_265_list);
		Assert.assertEquals(1, Expr_265_list.size());
		//265
		final ExclusiveOrExpression ExclusiveOrExpression_266_Var
		 = (ExclusiveOrExpression)Expr_265_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_266_Var
		);
		final EList<? extends EObject> Expr_266_list = ExclusiveOrExpression_266_Var
		.getExpr();
		Assert.assertNotNull(Expr_266_list);
		Assert.assertEquals(1, Expr_266_list.size());
		//266
		final AndExpression AndExpression_267_Var
		 = (AndExpression)Expr_266_list.get(0);
		Assert.assertNotNull(AndExpression_267_Var
		);
		final EList<? extends EObject> Expr_267_list = AndExpression_267_Var
		.getExpr();
		Assert.assertNotNull(Expr_267_list);
		Assert.assertEquals(1, Expr_267_list.size());
		//267
		final EqualityExpression EqualityExpression_268_Var
		 = (EqualityExpression)Expr_267_list.get(0);
		Assert.assertNotNull(EqualityExpression_268_Var
		);
		final EList<? extends EObject> Expr_268_list = EqualityExpression_268_Var
		.getExpr();
		Assert.assertNotNull(Expr_268_list);
		Assert.assertEquals(1, Expr_268_list.size());
		//268
		final RelationalExpression RelationalExpression_269_Var
		 = (RelationalExpression)Expr_268_list.get(0);
		Assert.assertNotNull(RelationalExpression_269_Var
		);
		final EList<? extends EObject> Expr_269_list = RelationalExpression_269_Var
		.getExpr();
		Assert.assertNotNull(Expr_269_list);
		Assert.assertEquals(1, Expr_269_list.size());
		//269
		final ShiftExpression ShiftExpression_270_Var
		 = (ShiftExpression)Expr_269_list.get(0);
		Assert.assertNotNull(ShiftExpression_270_Var
		);
		final EList<? extends EObject> Expr_270_list = ShiftExpression_270_Var
		.getExpr();
		Assert.assertNotNull(Expr_270_list);
		Assert.assertEquals(1, Expr_270_list.size());
		//270
		final AdditiveExpression AdditiveExpression_271_Var
		 = (AdditiveExpression)Expr_270_list.get(0);
		Assert.assertNotNull(AdditiveExpression_271_Var
		);
		final EList<? extends EObject> Expr_271_list = AdditiveExpression_271_Var
		.getExpr();
		Assert.assertNotNull(Expr_271_list);
		Assert.assertEquals(1, Expr_271_list.size());
		//271
		final MultiplicativeExpression MultiplicativeExpression_272_Var
		 = (MultiplicativeExpression)Expr_271_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_272_Var
		);
		final EList<? extends EObject> Expr_272_list = MultiplicativeExpression_272_Var
		.getExpr();
		Assert.assertNotNull(Expr_272_list);
		Assert.assertEquals(1, Expr_272_list.size());
		//272
		final CastExpression CastExpression_273_Var
		 = (CastExpression)Expr_272_list.get(0);
		Assert.assertNotNull(CastExpression_273_Var
		);
		//273
		final UnaryExpression UnaryExpression_274_Var
		 = (UnaryExpression)CastExpression_273_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_274_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_274_Var
		.getSizeOf());
		//274
		final TypeName TypeName_275_Var
		 = (TypeName)UnaryExpression_274_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_275_Var
		);
		//275
		final SpecifierQualifierList SpecifierQualifierList_276_Var
		 = (SpecifierQualifierList)TypeName_275_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_276_Var
		);
		final EList<? extends EObject> TypeSpecifier_276_list = SpecifierQualifierList_276_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_276_list);
		Assert.assertEquals(1, TypeSpecifier_276_list.size());
		//276
		final TypeSpecifier TypeSpecifier_277_Var
		 = (TypeSpecifier)TypeSpecifier_276_list.get(0);
		Assert.assertNotNull(TypeSpecifier_277_Var
		);
		Assert.assertEquals("float", TypeSpecifier_277_Var
		.getName());
		Assert.assertEquals(";", ExpressionStatement_224_Var
		.getSemi());
		//277
		final Statement Statement_278_Var
		 = (Statement)Statement_95_list.get(3);
		Assert.assertNotNull(Statement_278_Var
		);
		//278
		final ExpressionStatement ExpressionStatement_279_Var
		 = (ExpressionStatement)Statement_278_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_279_Var
		);
		//279
		final Expression Expression_280_Var
		 = (Expression)ExpressionStatement_279_Var
		.getExpression();
		Assert.assertNotNull(Expression_280_Var
		);
		final EList<? extends EObject> ExprExpr_280_list = Expression_280_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_280_list);
		Assert.assertEquals(1, ExprExpr_280_list.size());
		//280
		final AssignmentExpression AssignmentExpression_281_Var
		 = (AssignmentExpression)ExprExpr_280_list.get(0);
		Assert.assertNotNull(AssignmentExpression_281_Var
		);
		//281
		final UnaryExpression UnaryExpression_282_Var
		 = (UnaryExpression)AssignmentExpression_281_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_282_Var
		);
		//282
		final PostfixExpression PostfixExpression_283_Var
		 = (PostfixExpression)UnaryExpression_282_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_283_Var
		);
		final EList<? extends EObject> Expr_283_list = PostfixExpression_283_Var
		.getExpr();
		Assert.assertNotNull(Expr_283_list);
		Assert.assertEquals(1, Expr_283_list.size());
		//283
		final PrimaryExpression PrimaryExpression_284_Var
		 = (PrimaryExpression)Expr_283_list.get(0);
		Assert.assertNotNull(PrimaryExpression_284_Var
		);
		Assert.assertEquals("number", PrimaryExpression_284_Var
		.getId());
		final EList<? extends EObject> Suffix_284_list = PostfixExpression_283_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_284_list);
		Assert.assertEquals(1, Suffix_284_list.size());
		//284
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_285_Var
		 = (PostfixExpressionSuffixDot)Suffix_284_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_285_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_285_Var
		.getId());
		//285
		final AssignmentOperator AssignmentOperator_286_Var
		 = (AssignmentOperator)AssignmentExpression_281_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_286_Var
		);
		Assert.assertEquals("=", AssignmentOperator_286_Var
		.getOp());
		//286
		final AssignmentExpression AssignmentExpression_287_Var
		 = (AssignmentExpression)AssignmentExpression_281_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_287_Var
		);
		//287
		final ConditionalExpression ConditionalExpression_288_Var
		 = (ConditionalExpression)AssignmentExpression_287_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_288_Var
		);
		//288
		final LogicalOrExpression LogicalOrExpression_289_Var
		 = (LogicalOrExpression)ConditionalExpression_288_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_289_Var
		);
		final EList<? extends EObject> Expr_289_list = LogicalOrExpression_289_Var
		.getExpr();
		Assert.assertNotNull(Expr_289_list);
		Assert.assertEquals(1, Expr_289_list.size());
		//289
		final LogicalAndExpression LogicalAndExpression_290_Var
		 = (LogicalAndExpression)Expr_289_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_290_Var
		);
		final EList<? extends EObject> Expr_290_list = LogicalAndExpression_290_Var
		.getExpr();
		Assert.assertNotNull(Expr_290_list);
		Assert.assertEquals(1, Expr_290_list.size());
		//290
		final InclusiveOrExpression InclusiveOrExpression_291_Var
		 = (InclusiveOrExpression)Expr_290_list.get(0);
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
		Assert.assertEquals("65", Constant2_303_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_279_Var
		.getSemi());
		//303
		final Statement Statement_304_Var
		 = (Statement)Statement_95_list.get(4);
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
		Assert.assertEquals("printf", PrimaryExpression_322_Var
		.getId());
		final EList<? extends EObject> Suffix_322_list = PostfixExpression_321_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_322_list);
		Assert.assertEquals(1, Suffix_322_list.size());
		//322
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_323_Var
		 = (PostfixExpressionSuffixArgument)Suffix_322_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_323_Var
		);
		//323
		final ArgumentExpressionList ArgumentExpressionList_324_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_323_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_324_Var
		);
		final EList<? extends EObject> Expr_324_list = ArgumentExpressionList_324_Var
		.getExpr();
		Assert.assertNotNull(Expr_324_list);
		Assert.assertEquals(2, Expr_324_list.size());
		//324
		final AssignmentExpression AssignmentExpression_325_Var
		 = (AssignmentExpression)Expr_324_list.get(0);
		Assert.assertNotNull(AssignmentExpression_325_Var
		);
		//325
		final ConditionalExpression ConditionalExpression_326_Var
		 = (ConditionalExpression)AssignmentExpression_325_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_326_Var
		);
		//326
		final LogicalOrExpression LogicalOrExpression_327_Var
		 = (LogicalOrExpression)ConditionalExpression_326_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_327_Var
		);
		final EList<? extends EObject> Expr_327_list = LogicalOrExpression_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final LogicalAndExpression LogicalAndExpression_328_Var
		 = (LogicalAndExpression)Expr_327_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_328_Var
		);
		final EList<? extends EObject> Expr_328_list = LogicalAndExpression_328_Var
		.getExpr();
		Assert.assertNotNull(Expr_328_list);
		Assert.assertEquals(1, Expr_328_list.size());
		//328
		final InclusiveOrExpression InclusiveOrExpression_329_Var
		 = (InclusiveOrExpression)Expr_328_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_329_Var
		);
		final EList<? extends EObject> Expr_329_list = InclusiveOrExpression_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final ExclusiveOrExpression ExclusiveOrExpression_330_Var
		 = (ExclusiveOrExpression)Expr_329_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_330_Var
		);
		final EList<? extends EObject> Expr_330_list = ExclusiveOrExpression_330_Var
		.getExpr();
		Assert.assertNotNull(Expr_330_list);
		Assert.assertEquals(1, Expr_330_list.size());
		//330
		final AndExpression AndExpression_331_Var
		 = (AndExpression)Expr_330_list.get(0);
		Assert.assertNotNull(AndExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = AndExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final EqualityExpression EqualityExpression_332_Var
		 = (EqualityExpression)Expr_331_list.get(0);
		Assert.assertNotNull(EqualityExpression_332_Var
		);
		final EList<? extends EObject> Expr_332_list = EqualityExpression_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final RelationalExpression RelationalExpression_333_Var
		 = (RelationalExpression)Expr_332_list.get(0);
		Assert.assertNotNull(RelationalExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = RelationalExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final ShiftExpression ShiftExpression_334_Var
		 = (ShiftExpression)Expr_333_list.get(0);
		Assert.assertNotNull(ShiftExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = ShiftExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final AdditiveExpression AdditiveExpression_335_Var
		 = (AdditiveExpression)Expr_334_list.get(0);
		Assert.assertNotNull(AdditiveExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = AdditiveExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final MultiplicativeExpression MultiplicativeExpression_336_Var
		 = (MultiplicativeExpression)Expr_335_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = MultiplicativeExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final CastExpression CastExpression_337_Var
		 = (CastExpression)Expr_336_list.get(0);
		Assert.assertNotNull(CastExpression_337_Var
		);
		//337
		final UnaryExpression UnaryExpression_338_Var
		 = (UnaryExpression)CastExpression_337_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_338_Var
		);
		//338
		final PostfixExpression PostfixExpression_339_Var
		 = (PostfixExpression)UnaryExpression_338_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_339_Var
		);
		final EList<? extends EObject> Expr_339_list = PostfixExpression_339_Var
		.getExpr();
		Assert.assertNotNull(Expr_339_list);
		Assert.assertEquals(1, Expr_339_list.size());
		//339
		final PrimaryExpression PrimaryExpression_340_Var
		 = (PrimaryExpression)Expr_339_list.get(0);
		Assert.assertNotNull(PrimaryExpression_340_Var
		);
		//340
		final Constant2 Constant2_341_Var
		 = (Constant2)PrimaryExpression_340_Var
		.getConst();
		Assert.assertNotNull(Constant2_341_Var
		);
		Assert.assertEquals("\"number.numChar(as decimal)=%d\\n\"", Constant2_341_Var
		.getStr());
		//341
		final AssignmentExpression AssignmentExpression_342_Var
		 = (AssignmentExpression)Expr_324_list.get(1);
		Assert.assertNotNull(AssignmentExpression_342_Var
		);
		//342
		final ConditionalExpression ConditionalExpression_343_Var
		 = (ConditionalExpression)AssignmentExpression_342_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_343_Var
		);
		//343
		final LogicalOrExpression LogicalOrExpression_344_Var
		 = (LogicalOrExpression)ConditionalExpression_343_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_344_Var
		);
		final EList<? extends EObject> Expr_344_list = LogicalOrExpression_344_Var
		.getExpr();
		Assert.assertNotNull(Expr_344_list);
		Assert.assertEquals(1, Expr_344_list.size());
		//344
		final LogicalAndExpression LogicalAndExpression_345_Var
		 = (LogicalAndExpression)Expr_344_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_345_Var
		);
		final EList<? extends EObject> Expr_345_list = LogicalAndExpression_345_Var
		.getExpr();
		Assert.assertNotNull(Expr_345_list);
		Assert.assertEquals(1, Expr_345_list.size());
		//345
		final InclusiveOrExpression InclusiveOrExpression_346_Var
		 = (InclusiveOrExpression)Expr_345_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_346_Var
		);
		final EList<? extends EObject> Expr_346_list = InclusiveOrExpression_346_Var
		.getExpr();
		Assert.assertNotNull(Expr_346_list);
		Assert.assertEquals(1, Expr_346_list.size());
		//346
		final ExclusiveOrExpression ExclusiveOrExpression_347_Var
		 = (ExclusiveOrExpression)Expr_346_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_347_Var
		);
		final EList<? extends EObject> Expr_347_list = ExclusiveOrExpression_347_Var
		.getExpr();
		Assert.assertNotNull(Expr_347_list);
		Assert.assertEquals(1, Expr_347_list.size());
		//347
		final AndExpression AndExpression_348_Var
		 = (AndExpression)Expr_347_list.get(0);
		Assert.assertNotNull(AndExpression_348_Var
		);
		final EList<? extends EObject> Expr_348_list = AndExpression_348_Var
		.getExpr();
		Assert.assertNotNull(Expr_348_list);
		Assert.assertEquals(1, Expr_348_list.size());
		//348
		final EqualityExpression EqualityExpression_349_Var
		 = (EqualityExpression)Expr_348_list.get(0);
		Assert.assertNotNull(EqualityExpression_349_Var
		);
		final EList<? extends EObject> Expr_349_list = EqualityExpression_349_Var
		.getExpr();
		Assert.assertNotNull(Expr_349_list);
		Assert.assertEquals(1, Expr_349_list.size());
		//349
		final RelationalExpression RelationalExpression_350_Var
		 = (RelationalExpression)Expr_349_list.get(0);
		Assert.assertNotNull(RelationalExpression_350_Var
		);
		final EList<? extends EObject> Expr_350_list = RelationalExpression_350_Var
		.getExpr();
		Assert.assertNotNull(Expr_350_list);
		Assert.assertEquals(1, Expr_350_list.size());
		//350
		final ShiftExpression ShiftExpression_351_Var
		 = (ShiftExpression)Expr_350_list.get(0);
		Assert.assertNotNull(ShiftExpression_351_Var
		);
		final EList<? extends EObject> Expr_351_list = ShiftExpression_351_Var
		.getExpr();
		Assert.assertNotNull(Expr_351_list);
		Assert.assertEquals(1, Expr_351_list.size());
		//351
		final AdditiveExpression AdditiveExpression_352_Var
		 = (AdditiveExpression)Expr_351_list.get(0);
		Assert.assertNotNull(AdditiveExpression_352_Var
		);
		final EList<? extends EObject> Expr_352_list = AdditiveExpression_352_Var
		.getExpr();
		Assert.assertNotNull(Expr_352_list);
		Assert.assertEquals(1, Expr_352_list.size());
		//352
		final MultiplicativeExpression MultiplicativeExpression_353_Var
		 = (MultiplicativeExpression)Expr_352_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_353_Var
		);
		final EList<? extends EObject> Expr_353_list = MultiplicativeExpression_353_Var
		.getExpr();
		Assert.assertNotNull(Expr_353_list);
		Assert.assertEquals(1, Expr_353_list.size());
		//353
		final CastExpression CastExpression_354_Var
		 = (CastExpression)Expr_353_list.get(0);
		Assert.assertNotNull(CastExpression_354_Var
		);
		//354
		final UnaryExpression UnaryExpression_355_Var
		 = (UnaryExpression)CastExpression_354_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_355_Var
		);
		//355
		final PostfixExpression PostfixExpression_356_Var
		 = (PostfixExpression)UnaryExpression_355_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_356_Var
		);
		final EList<? extends EObject> Expr_356_list = PostfixExpression_356_Var
		.getExpr();
		Assert.assertNotNull(Expr_356_list);
		Assert.assertEquals(1, Expr_356_list.size());
		//356
		final PrimaryExpression PrimaryExpression_357_Var
		 = (PrimaryExpression)Expr_356_list.get(0);
		Assert.assertNotNull(PrimaryExpression_357_Var
		);
		Assert.assertEquals("number", PrimaryExpression_357_Var
		.getId());
		final EList<? extends EObject> Suffix_357_list = PostfixExpression_356_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_357_list);
		Assert.assertEquals(1, Suffix_357_list.size());
		//357
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_358_Var
		 = (PostfixExpressionSuffixDot)Suffix_357_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_358_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_358_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_305_Var
		.getSemi());
		//358
		final Statement Statement_359_Var
		 = (Statement)Statement_95_list.get(5);
		Assert.assertNotNull(Statement_359_Var
		);
		//359
		final ExpressionStatement ExpressionStatement_360_Var
		 = (ExpressionStatement)Statement_359_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_360_Var
		);
		//360
		final Expression Expression_361_Var
		 = (Expression)ExpressionStatement_360_Var
		.getExpression();
		Assert.assertNotNull(Expression_361_Var
		);
		final EList<? extends EObject> ExprExpr_361_list = Expression_361_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_361_list);
		Assert.assertEquals(1, ExprExpr_361_list.size());
		//361
		final AssignmentExpression AssignmentExpression_362_Var
		 = (AssignmentExpression)ExprExpr_361_list.get(0);
		Assert.assertNotNull(AssignmentExpression_362_Var
		);
		//362
		final ConditionalExpression ConditionalExpression_363_Var
		 = (ConditionalExpression)AssignmentExpression_362_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_363_Var
		);
		//363
		final LogicalOrExpression LogicalOrExpression_364_Var
		 = (LogicalOrExpression)ConditionalExpression_363_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_364_Var
		);
		final EList<? extends EObject> Expr_364_list = LogicalOrExpression_364_Var
		.getExpr();
		Assert.assertNotNull(Expr_364_list);
		Assert.assertEquals(1, Expr_364_list.size());
		//364
		final LogicalAndExpression LogicalAndExpression_365_Var
		 = (LogicalAndExpression)Expr_364_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = LogicalAndExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final InclusiveOrExpression InclusiveOrExpression_366_Var
		 = (InclusiveOrExpression)Expr_365_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_366_Var
		);
		final EList<? extends EObject> Expr_366_list = InclusiveOrExpression_366_Var
		.getExpr();
		Assert.assertNotNull(Expr_366_list);
		Assert.assertEquals(1, Expr_366_list.size());
		//366
		final ExclusiveOrExpression ExclusiveOrExpression_367_Var
		 = (ExclusiveOrExpression)Expr_366_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_367_Var
		);
		final EList<? extends EObject> Expr_367_list = ExclusiveOrExpression_367_Var
		.getExpr();
		Assert.assertNotNull(Expr_367_list);
		Assert.assertEquals(1, Expr_367_list.size());
		//367
		final AndExpression AndExpression_368_Var
		 = (AndExpression)Expr_367_list.get(0);
		Assert.assertNotNull(AndExpression_368_Var
		);
		final EList<? extends EObject> Expr_368_list = AndExpression_368_Var
		.getExpr();
		Assert.assertNotNull(Expr_368_list);
		Assert.assertEquals(1, Expr_368_list.size());
		//368
		final EqualityExpression EqualityExpression_369_Var
		 = (EqualityExpression)Expr_368_list.get(0);
		Assert.assertNotNull(EqualityExpression_369_Var
		);
		final EList<? extends EObject> Expr_369_list = EqualityExpression_369_Var
		.getExpr();
		Assert.assertNotNull(Expr_369_list);
		Assert.assertEquals(1, Expr_369_list.size());
		//369
		final RelationalExpression RelationalExpression_370_Var
		 = (RelationalExpression)Expr_369_list.get(0);
		Assert.assertNotNull(RelationalExpression_370_Var
		);
		final EList<? extends EObject> Expr_370_list = RelationalExpression_370_Var
		.getExpr();
		Assert.assertNotNull(Expr_370_list);
		Assert.assertEquals(1, Expr_370_list.size());
		//370
		final ShiftExpression ShiftExpression_371_Var
		 = (ShiftExpression)Expr_370_list.get(0);
		Assert.assertNotNull(ShiftExpression_371_Var
		);
		final EList<? extends EObject> Expr_371_list = ShiftExpression_371_Var
		.getExpr();
		Assert.assertNotNull(Expr_371_list);
		Assert.assertEquals(1, Expr_371_list.size());
		//371
		final AdditiveExpression AdditiveExpression_372_Var
		 = (AdditiveExpression)Expr_371_list.get(0);
		Assert.assertNotNull(AdditiveExpression_372_Var
		);
		final EList<? extends EObject> Expr_372_list = AdditiveExpression_372_Var
		.getExpr();
		Assert.assertNotNull(Expr_372_list);
		Assert.assertEquals(1, Expr_372_list.size());
		//372
		final MultiplicativeExpression MultiplicativeExpression_373_Var
		 = (MultiplicativeExpression)Expr_372_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_373_Var
		);
		final EList<? extends EObject> Expr_373_list = MultiplicativeExpression_373_Var
		.getExpr();
		Assert.assertNotNull(Expr_373_list);
		Assert.assertEquals(1, Expr_373_list.size());
		//373
		final CastExpression CastExpression_374_Var
		 = (CastExpression)Expr_373_list.get(0);
		Assert.assertNotNull(CastExpression_374_Var
		);
		//374
		final UnaryExpression UnaryExpression_375_Var
		 = (UnaryExpression)CastExpression_374_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_375_Var
		);
		//375
		final PostfixExpression PostfixExpression_376_Var
		 = (PostfixExpression)UnaryExpression_375_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_376_Var
		);
		final EList<? extends EObject> Expr_376_list = PostfixExpression_376_Var
		.getExpr();
		Assert.assertNotNull(Expr_376_list);
		Assert.assertEquals(1, Expr_376_list.size());
		//376
		final PrimaryExpression PrimaryExpression_377_Var
		 = (PrimaryExpression)Expr_376_list.get(0);
		Assert.assertNotNull(PrimaryExpression_377_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_377_Var
		.getId());
		final EList<? extends EObject> Suffix_377_list = PostfixExpression_376_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_377_list);
		Assert.assertEquals(1, Suffix_377_list.size());
		//377
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_378_Var
		 = (PostfixExpressionSuffixArgument)Suffix_377_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_378_Var
		);
		//378
		final ArgumentExpressionList ArgumentExpressionList_379_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_378_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_379_Var
		);
		final EList<? extends EObject> Expr_379_list = ArgumentExpressionList_379_Var
		.getExpr();
		Assert.assertNotNull(Expr_379_list);
		Assert.assertEquals(2, Expr_379_list.size());
		//379
		final AssignmentExpression AssignmentExpression_380_Var
		 = (AssignmentExpression)Expr_379_list.get(0);
		Assert.assertNotNull(AssignmentExpression_380_Var
		);
		//380
		final ConditionalExpression ConditionalExpression_381_Var
		 = (ConditionalExpression)AssignmentExpression_380_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_381_Var
		);
		//381
		final LogicalOrExpression LogicalOrExpression_382_Var
		 = (LogicalOrExpression)ConditionalExpression_381_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_382_Var
		);
		final EList<? extends EObject> Expr_382_list = LogicalOrExpression_382_Var
		.getExpr();
		Assert.assertNotNull(Expr_382_list);
		Assert.assertEquals(1, Expr_382_list.size());
		//382
		final LogicalAndExpression LogicalAndExpression_383_Var
		 = (LogicalAndExpression)Expr_382_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_383_Var
		);
		final EList<? extends EObject> Expr_383_list = LogicalAndExpression_383_Var
		.getExpr();
		Assert.assertNotNull(Expr_383_list);
		Assert.assertEquals(1, Expr_383_list.size());
		//383
		final InclusiveOrExpression InclusiveOrExpression_384_Var
		 = (InclusiveOrExpression)Expr_383_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_384_Var
		);
		final EList<? extends EObject> Expr_384_list = InclusiveOrExpression_384_Var
		.getExpr();
		Assert.assertNotNull(Expr_384_list);
		Assert.assertEquals(1, Expr_384_list.size());
		//384
		final ExclusiveOrExpression ExclusiveOrExpression_385_Var
		 = (ExclusiveOrExpression)Expr_384_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_385_Var
		);
		final EList<? extends EObject> Expr_385_list = ExclusiveOrExpression_385_Var
		.getExpr();
		Assert.assertNotNull(Expr_385_list);
		Assert.assertEquals(1, Expr_385_list.size());
		//385
		final AndExpression AndExpression_386_Var
		 = (AndExpression)Expr_385_list.get(0);
		Assert.assertNotNull(AndExpression_386_Var
		);
		final EList<? extends EObject> Expr_386_list = AndExpression_386_Var
		.getExpr();
		Assert.assertNotNull(Expr_386_list);
		Assert.assertEquals(1, Expr_386_list.size());
		//386
		final EqualityExpression EqualityExpression_387_Var
		 = (EqualityExpression)Expr_386_list.get(0);
		Assert.assertNotNull(EqualityExpression_387_Var
		);
		final EList<? extends EObject> Expr_387_list = EqualityExpression_387_Var
		.getExpr();
		Assert.assertNotNull(Expr_387_list);
		Assert.assertEquals(1, Expr_387_list.size());
		//387
		final RelationalExpression RelationalExpression_388_Var
		 = (RelationalExpression)Expr_387_list.get(0);
		Assert.assertNotNull(RelationalExpression_388_Var
		);
		final EList<? extends EObject> Expr_388_list = RelationalExpression_388_Var
		.getExpr();
		Assert.assertNotNull(Expr_388_list);
		Assert.assertEquals(1, Expr_388_list.size());
		//388
		final ShiftExpression ShiftExpression_389_Var
		 = (ShiftExpression)Expr_388_list.get(0);
		Assert.assertNotNull(ShiftExpression_389_Var
		);
		final EList<? extends EObject> Expr_389_list = ShiftExpression_389_Var
		.getExpr();
		Assert.assertNotNull(Expr_389_list);
		Assert.assertEquals(1, Expr_389_list.size());
		//389
		final AdditiveExpression AdditiveExpression_390_Var
		 = (AdditiveExpression)Expr_389_list.get(0);
		Assert.assertNotNull(AdditiveExpression_390_Var
		);
		final EList<? extends EObject> Expr_390_list = AdditiveExpression_390_Var
		.getExpr();
		Assert.assertNotNull(Expr_390_list);
		Assert.assertEquals(1, Expr_390_list.size());
		//390
		final MultiplicativeExpression MultiplicativeExpression_391_Var
		 = (MultiplicativeExpression)Expr_390_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_391_Var
		);
		final EList<? extends EObject> Expr_391_list = MultiplicativeExpression_391_Var
		.getExpr();
		Assert.assertNotNull(Expr_391_list);
		Assert.assertEquals(1, Expr_391_list.size());
		//391
		final CastExpression CastExpression_392_Var
		 = (CastExpression)Expr_391_list.get(0);
		Assert.assertNotNull(CastExpression_392_Var
		);
		//392
		final UnaryExpression UnaryExpression_393_Var
		 = (UnaryExpression)CastExpression_392_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_393_Var
		);
		//393
		final PostfixExpression PostfixExpression_394_Var
		 = (PostfixExpression)UnaryExpression_393_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_394_Var
		);
		final EList<? extends EObject> Expr_394_list = PostfixExpression_394_Var
		.getExpr();
		Assert.assertNotNull(Expr_394_list);
		Assert.assertEquals(1, Expr_394_list.size());
		//394
		final PrimaryExpression PrimaryExpression_395_Var
		 = (PrimaryExpression)Expr_394_list.get(0);
		Assert.assertNotNull(PrimaryExpression_395_Var
		);
		//395
		final Constant2 Constant2_396_Var
		 = (Constant2)PrimaryExpression_395_Var
		.getConst();
		Assert.assertNotNull(Constant2_396_Var
		);
		Assert.assertEquals("\"number.numChar(as char)=%c\\n\"", Constant2_396_Var
		.getStr());
		//396
		final AssignmentExpression AssignmentExpression_397_Var
		 = (AssignmentExpression)Expr_379_list.get(1);
		Assert.assertNotNull(AssignmentExpression_397_Var
		);
		//397
		final ConditionalExpression ConditionalExpression_398_Var
		 = (ConditionalExpression)AssignmentExpression_397_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_398_Var
		);
		//398
		final LogicalOrExpression LogicalOrExpression_399_Var
		 = (LogicalOrExpression)ConditionalExpression_398_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_399_Var
		);
		final EList<? extends EObject> Expr_399_list = LogicalOrExpression_399_Var
		.getExpr();
		Assert.assertNotNull(Expr_399_list);
		Assert.assertEquals(1, Expr_399_list.size());
		//399
		final LogicalAndExpression LogicalAndExpression_400_Var
		 = (LogicalAndExpression)Expr_399_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_400_Var
		);
		final EList<? extends EObject> Expr_400_list = LogicalAndExpression_400_Var
		.getExpr();
		Assert.assertNotNull(Expr_400_list);
		Assert.assertEquals(1, Expr_400_list.size());
		//400
		final InclusiveOrExpression InclusiveOrExpression_401_Var
		 = (InclusiveOrExpression)Expr_400_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_401_Var
		);
		final EList<? extends EObject> Expr_401_list = InclusiveOrExpression_401_Var
		.getExpr();
		Assert.assertNotNull(Expr_401_list);
		Assert.assertEquals(1, Expr_401_list.size());
		//401
		final ExclusiveOrExpression ExclusiveOrExpression_402_Var
		 = (ExclusiveOrExpression)Expr_401_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_402_Var
		);
		final EList<? extends EObject> Expr_402_list = ExclusiveOrExpression_402_Var
		.getExpr();
		Assert.assertNotNull(Expr_402_list);
		Assert.assertEquals(1, Expr_402_list.size());
		//402
		final AndExpression AndExpression_403_Var
		 = (AndExpression)Expr_402_list.get(0);
		Assert.assertNotNull(AndExpression_403_Var
		);
		final EList<? extends EObject> Expr_403_list = AndExpression_403_Var
		.getExpr();
		Assert.assertNotNull(Expr_403_list);
		Assert.assertEquals(1, Expr_403_list.size());
		//403
		final EqualityExpression EqualityExpression_404_Var
		 = (EqualityExpression)Expr_403_list.get(0);
		Assert.assertNotNull(EqualityExpression_404_Var
		);
		final EList<? extends EObject> Expr_404_list = EqualityExpression_404_Var
		.getExpr();
		Assert.assertNotNull(Expr_404_list);
		Assert.assertEquals(1, Expr_404_list.size());
		//404
		final RelationalExpression RelationalExpression_405_Var
		 = (RelationalExpression)Expr_404_list.get(0);
		Assert.assertNotNull(RelationalExpression_405_Var
		);
		final EList<? extends EObject> Expr_405_list = RelationalExpression_405_Var
		.getExpr();
		Assert.assertNotNull(Expr_405_list);
		Assert.assertEquals(1, Expr_405_list.size());
		//405
		final ShiftExpression ShiftExpression_406_Var
		 = (ShiftExpression)Expr_405_list.get(0);
		Assert.assertNotNull(ShiftExpression_406_Var
		);
		final EList<? extends EObject> Expr_406_list = ShiftExpression_406_Var
		.getExpr();
		Assert.assertNotNull(Expr_406_list);
		Assert.assertEquals(1, Expr_406_list.size());
		//406
		final AdditiveExpression AdditiveExpression_407_Var
		 = (AdditiveExpression)Expr_406_list.get(0);
		Assert.assertNotNull(AdditiveExpression_407_Var
		);
		final EList<? extends EObject> Expr_407_list = AdditiveExpression_407_Var
		.getExpr();
		Assert.assertNotNull(Expr_407_list);
		Assert.assertEquals(1, Expr_407_list.size());
		//407
		final MultiplicativeExpression MultiplicativeExpression_408_Var
		 = (MultiplicativeExpression)Expr_407_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_408_Var
		);
		final EList<? extends EObject> Expr_408_list = MultiplicativeExpression_408_Var
		.getExpr();
		Assert.assertNotNull(Expr_408_list);
		Assert.assertEquals(1, Expr_408_list.size());
		//408
		final CastExpression CastExpression_409_Var
		 = (CastExpression)Expr_408_list.get(0);
		Assert.assertNotNull(CastExpression_409_Var
		);
		//409
		final UnaryExpression UnaryExpression_410_Var
		 = (UnaryExpression)CastExpression_409_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_410_Var
		);
		//410
		final PostfixExpression PostfixExpression_411_Var
		 = (PostfixExpression)UnaryExpression_410_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_411_Var
		);
		final EList<? extends EObject> Expr_411_list = PostfixExpression_411_Var
		.getExpr();
		Assert.assertNotNull(Expr_411_list);
		Assert.assertEquals(1, Expr_411_list.size());
		//411
		final PrimaryExpression PrimaryExpression_412_Var
		 = (PrimaryExpression)Expr_411_list.get(0);
		Assert.assertNotNull(PrimaryExpression_412_Var
		);
		Assert.assertEquals("number", PrimaryExpression_412_Var
		.getId());
		final EList<? extends EObject> Suffix_412_list = PostfixExpression_411_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_412_list);
		Assert.assertEquals(1, Suffix_412_list.size());
		//412
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_413_Var
		 = (PostfixExpressionSuffixDot)Suffix_412_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_413_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_413_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_360_Var
		.getSemi());
		//413
		final Statement Statement_414_Var
		 = (Statement)Statement_95_list.get(6);
		Assert.assertNotNull(Statement_414_Var
		);
		//414
		final ExpressionStatement ExpressionStatement_415_Var
		 = (ExpressionStatement)Statement_414_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_415_Var
		);
		//415
		final Expression Expression_416_Var
		 = (Expression)ExpressionStatement_415_Var
		.getExpression();
		Assert.assertNotNull(Expression_416_Var
		);
		final EList<? extends EObject> ExprExpr_416_list = Expression_416_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_416_list);
		Assert.assertEquals(1, ExprExpr_416_list.size());
		//416
		final AssignmentExpression AssignmentExpression_417_Var
		 = (AssignmentExpression)ExprExpr_416_list.get(0);
		Assert.assertNotNull(AssignmentExpression_417_Var
		);
		//417
		final ConditionalExpression ConditionalExpression_418_Var
		 = (ConditionalExpression)AssignmentExpression_417_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_418_Var
		);
		//418
		final LogicalOrExpression LogicalOrExpression_419_Var
		 = (LogicalOrExpression)ConditionalExpression_418_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_419_Var
		);
		final EList<? extends EObject> Expr_419_list = LogicalOrExpression_419_Var
		.getExpr();
		Assert.assertNotNull(Expr_419_list);
		Assert.assertEquals(1, Expr_419_list.size());
		//419
		final LogicalAndExpression LogicalAndExpression_420_Var
		 = (LogicalAndExpression)Expr_419_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_420_Var
		);
		final EList<? extends EObject> Expr_420_list = LogicalAndExpression_420_Var
		.getExpr();
		Assert.assertNotNull(Expr_420_list);
		Assert.assertEquals(1, Expr_420_list.size());
		//420
		final InclusiveOrExpression InclusiveOrExpression_421_Var
		 = (InclusiveOrExpression)Expr_420_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_421_Var
		);
		final EList<? extends EObject> Expr_421_list = InclusiveOrExpression_421_Var
		.getExpr();
		Assert.assertNotNull(Expr_421_list);
		Assert.assertEquals(1, Expr_421_list.size());
		//421
		final ExclusiveOrExpression ExclusiveOrExpression_422_Var
		 = (ExclusiveOrExpression)Expr_421_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_422_Var
		);
		final EList<? extends EObject> Expr_422_list = ExclusiveOrExpression_422_Var
		.getExpr();
		Assert.assertNotNull(Expr_422_list);
		Assert.assertEquals(1, Expr_422_list.size());
		//422
		final AndExpression AndExpression_423_Var
		 = (AndExpression)Expr_422_list.get(0);
		Assert.assertNotNull(AndExpression_423_Var
		);
		final EList<? extends EObject> Expr_423_list = AndExpression_423_Var
		.getExpr();
		Assert.assertNotNull(Expr_423_list);
		Assert.assertEquals(1, Expr_423_list.size());
		//423
		final EqualityExpression EqualityExpression_424_Var
		 = (EqualityExpression)Expr_423_list.get(0);
		Assert.assertNotNull(EqualityExpression_424_Var
		);
		final EList<? extends EObject> Expr_424_list = EqualityExpression_424_Var
		.getExpr();
		Assert.assertNotNull(Expr_424_list);
		Assert.assertEquals(1, Expr_424_list.size());
		//424
		final RelationalExpression RelationalExpression_425_Var
		 = (RelationalExpression)Expr_424_list.get(0);
		Assert.assertNotNull(RelationalExpression_425_Var
		);
		final EList<? extends EObject> Expr_425_list = RelationalExpression_425_Var
		.getExpr();
		Assert.assertNotNull(Expr_425_list);
		Assert.assertEquals(1, Expr_425_list.size());
		//425
		final ShiftExpression ShiftExpression_426_Var
		 = (ShiftExpression)Expr_425_list.get(0);
		Assert.assertNotNull(ShiftExpression_426_Var
		);
		final EList<? extends EObject> Expr_426_list = ShiftExpression_426_Var
		.getExpr();
		Assert.assertNotNull(Expr_426_list);
		Assert.assertEquals(1, Expr_426_list.size());
		//426
		final AdditiveExpression AdditiveExpression_427_Var
		 = (AdditiveExpression)Expr_426_list.get(0);
		Assert.assertNotNull(AdditiveExpression_427_Var
		);
		final EList<? extends EObject> Expr_427_list = AdditiveExpression_427_Var
		.getExpr();
		Assert.assertNotNull(Expr_427_list);
		Assert.assertEquals(1, Expr_427_list.size());
		//427
		final MultiplicativeExpression MultiplicativeExpression_428_Var
		 = (MultiplicativeExpression)Expr_427_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_428_Var
		);
		final EList<? extends EObject> Expr_428_list = MultiplicativeExpression_428_Var
		.getExpr();
		Assert.assertNotNull(Expr_428_list);
		Assert.assertEquals(1, Expr_428_list.size());
		//428
		final CastExpression CastExpression_429_Var
		 = (CastExpression)Expr_428_list.get(0);
		Assert.assertNotNull(CastExpression_429_Var
		);
		//429
		final UnaryExpression UnaryExpression_430_Var
		 = (UnaryExpression)CastExpression_429_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_430_Var
		);
		//430
		final PostfixExpression PostfixExpression_431_Var
		 = (PostfixExpression)UnaryExpression_430_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_431_Var
		);
		final EList<? extends EObject> Expr_431_list = PostfixExpression_431_Var
		.getExpr();
		Assert.assertNotNull(Expr_431_list);
		Assert.assertEquals(1, Expr_431_list.size());
		//431
		final PrimaryExpression PrimaryExpression_432_Var
		 = (PrimaryExpression)Expr_431_list.get(0);
		Assert.assertNotNull(PrimaryExpression_432_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_432_Var
		.getId());
		final EList<? extends EObject> Suffix_432_list = PostfixExpression_431_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_432_list);
		Assert.assertEquals(1, Suffix_432_list.size());
		//432
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_433_Var
		 = (PostfixExpressionSuffixArgument)Suffix_432_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_433_Var
		);
		//433
		final ArgumentExpressionList ArgumentExpressionList_434_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_433_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_434_Var
		);
		final EList<? extends EObject> Expr_434_list = ArgumentExpressionList_434_Var
		.getExpr();
		Assert.assertNotNull(Expr_434_list);
		Assert.assertEquals(2, Expr_434_list.size());
		//434
		final AssignmentExpression AssignmentExpression_435_Var
		 = (AssignmentExpression)Expr_434_list.get(0);
		Assert.assertNotNull(AssignmentExpression_435_Var
		);
		//435
		final ConditionalExpression ConditionalExpression_436_Var
		 = (ConditionalExpression)AssignmentExpression_435_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_436_Var
		);
		//436
		final LogicalOrExpression LogicalOrExpression_437_Var
		 = (LogicalOrExpression)ConditionalExpression_436_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_437_Var
		);
		final EList<? extends EObject> Expr_437_list = LogicalOrExpression_437_Var
		.getExpr();
		Assert.assertNotNull(Expr_437_list);
		Assert.assertEquals(1, Expr_437_list.size());
		//437
		final LogicalAndExpression LogicalAndExpression_438_Var
		 = (LogicalAndExpression)Expr_437_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_438_Var
		);
		final EList<? extends EObject> Expr_438_list = LogicalAndExpression_438_Var
		.getExpr();
		Assert.assertNotNull(Expr_438_list);
		Assert.assertEquals(1, Expr_438_list.size());
		//438
		final InclusiveOrExpression InclusiveOrExpression_439_Var
		 = (InclusiveOrExpression)Expr_438_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_439_Var
		);
		final EList<? extends EObject> Expr_439_list = InclusiveOrExpression_439_Var
		.getExpr();
		Assert.assertNotNull(Expr_439_list);
		Assert.assertEquals(1, Expr_439_list.size());
		//439
		final ExclusiveOrExpression ExclusiveOrExpression_440_Var
		 = (ExclusiveOrExpression)Expr_439_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_440_Var
		);
		final EList<? extends EObject> Expr_440_list = ExclusiveOrExpression_440_Var
		.getExpr();
		Assert.assertNotNull(Expr_440_list);
		Assert.assertEquals(1, Expr_440_list.size());
		//440
		final AndExpression AndExpression_441_Var
		 = (AndExpression)Expr_440_list.get(0);
		Assert.assertNotNull(AndExpression_441_Var
		);
		final EList<? extends EObject> Expr_441_list = AndExpression_441_Var
		.getExpr();
		Assert.assertNotNull(Expr_441_list);
		Assert.assertEquals(1, Expr_441_list.size());
		//441
		final EqualityExpression EqualityExpression_442_Var
		 = (EqualityExpression)Expr_441_list.get(0);
		Assert.assertNotNull(EqualityExpression_442_Var
		);
		final EList<? extends EObject> Expr_442_list = EqualityExpression_442_Var
		.getExpr();
		Assert.assertNotNull(Expr_442_list);
		Assert.assertEquals(1, Expr_442_list.size());
		//442
		final RelationalExpression RelationalExpression_443_Var
		 = (RelationalExpression)Expr_442_list.get(0);
		Assert.assertNotNull(RelationalExpression_443_Var
		);
		final EList<? extends EObject> Expr_443_list = RelationalExpression_443_Var
		.getExpr();
		Assert.assertNotNull(Expr_443_list);
		Assert.assertEquals(1, Expr_443_list.size());
		//443
		final ShiftExpression ShiftExpression_444_Var
		 = (ShiftExpression)Expr_443_list.get(0);
		Assert.assertNotNull(ShiftExpression_444_Var
		);
		final EList<? extends EObject> Expr_444_list = ShiftExpression_444_Var
		.getExpr();
		Assert.assertNotNull(Expr_444_list);
		Assert.assertEquals(1, Expr_444_list.size());
		//444
		final AdditiveExpression AdditiveExpression_445_Var
		 = (AdditiveExpression)Expr_444_list.get(0);
		Assert.assertNotNull(AdditiveExpression_445_Var
		);
		final EList<? extends EObject> Expr_445_list = AdditiveExpression_445_Var
		.getExpr();
		Assert.assertNotNull(Expr_445_list);
		Assert.assertEquals(1, Expr_445_list.size());
		//445
		final MultiplicativeExpression MultiplicativeExpression_446_Var
		 = (MultiplicativeExpression)Expr_445_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_446_Var
		);
		final EList<? extends EObject> Expr_446_list = MultiplicativeExpression_446_Var
		.getExpr();
		Assert.assertNotNull(Expr_446_list);
		Assert.assertEquals(1, Expr_446_list.size());
		//446
		final CastExpression CastExpression_447_Var
		 = (CastExpression)Expr_446_list.get(0);
		Assert.assertNotNull(CastExpression_447_Var
		);
		//447
		final UnaryExpression UnaryExpression_448_Var
		 = (UnaryExpression)CastExpression_447_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_448_Var
		);
		//448
		final PostfixExpression PostfixExpression_449_Var
		 = (PostfixExpression)UnaryExpression_448_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_449_Var
		);
		final EList<? extends EObject> Expr_449_list = PostfixExpression_449_Var
		.getExpr();
		Assert.assertNotNull(Expr_449_list);
		Assert.assertEquals(1, Expr_449_list.size());
		//449
		final PrimaryExpression PrimaryExpression_450_Var
		 = (PrimaryExpression)Expr_449_list.get(0);
		Assert.assertNotNull(PrimaryExpression_450_Var
		);
		//450
		final Constant2 Constant2_451_Var
		 = (Constant2)PrimaryExpression_450_Var
		.getConst();
		Assert.assertNotNull(Constant2_451_Var
		);
		Assert.assertEquals("\"number.numFloat=%f\\n\"", Constant2_451_Var
		.getStr());
		//451
		final AssignmentExpression AssignmentExpression_452_Var
		 = (AssignmentExpression)Expr_434_list.get(1);
		Assert.assertNotNull(AssignmentExpression_452_Var
		);
		//452
		final ConditionalExpression ConditionalExpression_453_Var
		 = (ConditionalExpression)AssignmentExpression_452_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_453_Var
		);
		//453
		final LogicalOrExpression LogicalOrExpression_454_Var
		 = (LogicalOrExpression)ConditionalExpression_453_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_454_Var
		);
		final EList<? extends EObject> Expr_454_list = LogicalOrExpression_454_Var
		.getExpr();
		Assert.assertNotNull(Expr_454_list);
		Assert.assertEquals(1, Expr_454_list.size());
		//454
		final LogicalAndExpression LogicalAndExpression_455_Var
		 = (LogicalAndExpression)Expr_454_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_455_Var
		);
		final EList<? extends EObject> Expr_455_list = LogicalAndExpression_455_Var
		.getExpr();
		Assert.assertNotNull(Expr_455_list);
		Assert.assertEquals(1, Expr_455_list.size());
		//455
		final InclusiveOrExpression InclusiveOrExpression_456_Var
		 = (InclusiveOrExpression)Expr_455_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_456_Var
		);
		final EList<? extends EObject> Expr_456_list = InclusiveOrExpression_456_Var
		.getExpr();
		Assert.assertNotNull(Expr_456_list);
		Assert.assertEquals(1, Expr_456_list.size());
		//456
		final ExclusiveOrExpression ExclusiveOrExpression_457_Var
		 = (ExclusiveOrExpression)Expr_456_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_457_Var
		);
		final EList<? extends EObject> Expr_457_list = ExclusiveOrExpression_457_Var
		.getExpr();
		Assert.assertNotNull(Expr_457_list);
		Assert.assertEquals(1, Expr_457_list.size());
		//457
		final AndExpression AndExpression_458_Var
		 = (AndExpression)Expr_457_list.get(0);
		Assert.assertNotNull(AndExpression_458_Var
		);
		final EList<? extends EObject> Expr_458_list = AndExpression_458_Var
		.getExpr();
		Assert.assertNotNull(Expr_458_list);
		Assert.assertEquals(1, Expr_458_list.size());
		//458
		final EqualityExpression EqualityExpression_459_Var
		 = (EqualityExpression)Expr_458_list.get(0);
		Assert.assertNotNull(EqualityExpression_459_Var
		);
		final EList<? extends EObject> Expr_459_list = EqualityExpression_459_Var
		.getExpr();
		Assert.assertNotNull(Expr_459_list);
		Assert.assertEquals(1, Expr_459_list.size());
		//459
		final RelationalExpression RelationalExpression_460_Var
		 = (RelationalExpression)Expr_459_list.get(0);
		Assert.assertNotNull(RelationalExpression_460_Var
		);
		final EList<? extends EObject> Expr_460_list = RelationalExpression_460_Var
		.getExpr();
		Assert.assertNotNull(Expr_460_list);
		Assert.assertEquals(1, Expr_460_list.size());
		//460
		final ShiftExpression ShiftExpression_461_Var
		 = (ShiftExpression)Expr_460_list.get(0);
		Assert.assertNotNull(ShiftExpression_461_Var
		);
		final EList<? extends EObject> Expr_461_list = ShiftExpression_461_Var
		.getExpr();
		Assert.assertNotNull(Expr_461_list);
		Assert.assertEquals(1, Expr_461_list.size());
		//461
		final AdditiveExpression AdditiveExpression_462_Var
		 = (AdditiveExpression)Expr_461_list.get(0);
		Assert.assertNotNull(AdditiveExpression_462_Var
		);
		final EList<? extends EObject> Expr_462_list = AdditiveExpression_462_Var
		.getExpr();
		Assert.assertNotNull(Expr_462_list);
		Assert.assertEquals(1, Expr_462_list.size());
		//462
		final MultiplicativeExpression MultiplicativeExpression_463_Var
		 = (MultiplicativeExpression)Expr_462_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_463_Var
		);
		final EList<? extends EObject> Expr_463_list = MultiplicativeExpression_463_Var
		.getExpr();
		Assert.assertNotNull(Expr_463_list);
		Assert.assertEquals(1, Expr_463_list.size());
		//463
		final CastExpression CastExpression_464_Var
		 = (CastExpression)Expr_463_list.get(0);
		Assert.assertNotNull(CastExpression_464_Var
		);
		//464
		final UnaryExpression UnaryExpression_465_Var
		 = (UnaryExpression)CastExpression_464_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_465_Var
		);
		//465
		final PostfixExpression PostfixExpression_466_Var
		 = (PostfixExpression)UnaryExpression_465_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_466_Var
		);
		final EList<? extends EObject> Expr_466_list = PostfixExpression_466_Var
		.getExpr();
		Assert.assertNotNull(Expr_466_list);
		Assert.assertEquals(1, Expr_466_list.size());
		//466
		final PrimaryExpression PrimaryExpression_467_Var
		 = (PrimaryExpression)Expr_466_list.get(0);
		Assert.assertNotNull(PrimaryExpression_467_Var
		);
		Assert.assertEquals("number", PrimaryExpression_467_Var
		.getId());
		final EList<? extends EObject> Suffix_467_list = PostfixExpression_466_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_467_list);
		Assert.assertEquals(1, Suffix_467_list.size());
		//467
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_468_Var
		 = (PostfixExpressionSuffixDot)Suffix_467_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_468_Var
		);
		Assert.assertEquals("numFloat", PostfixExpressionSuffixDot_468_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_415_Var
		.getSemi());
		//468
		final Statement Statement_469_Var
		 = (Statement)Statement_95_list.get(7);
		Assert.assertNotNull(Statement_469_Var
		);
		//469
		final ExpressionStatement ExpressionStatement_470_Var
		 = (ExpressionStatement)Statement_469_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_470_Var
		);
		//470
		final Expression Expression_471_Var
		 = (Expression)ExpressionStatement_470_Var
		.getExpression();
		Assert.assertNotNull(Expression_471_Var
		);
		final EList<? extends EObject> ExprExpr_471_list = Expression_471_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_471_list);
		Assert.assertEquals(1, ExprExpr_471_list.size());
		//471
		final AssignmentExpression AssignmentExpression_472_Var
		 = (AssignmentExpression)ExprExpr_471_list.get(0);
		Assert.assertNotNull(AssignmentExpression_472_Var
		);
		//472
		final UnaryExpression UnaryExpression_473_Var
		 = (UnaryExpression)AssignmentExpression_472_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_473_Var
		);
		//473
		final PostfixExpression PostfixExpression_474_Var
		 = (PostfixExpression)UnaryExpression_473_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_474_Var
		);
		final EList<? extends EObject> Expr_474_list = PostfixExpression_474_Var
		.getExpr();
		Assert.assertNotNull(Expr_474_list);
		Assert.assertEquals(1, Expr_474_list.size());
		//474
		final PrimaryExpression PrimaryExpression_475_Var
		 = (PrimaryExpression)Expr_474_list.get(0);
		Assert.assertNotNull(PrimaryExpression_475_Var
		);
		Assert.assertEquals("number", PrimaryExpression_475_Var
		.getId());
		final EList<? extends EObject> Suffix_475_list = PostfixExpression_474_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_475_list);
		Assert.assertEquals(1, Suffix_475_list.size());
		//475
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_476_Var
		 = (PostfixExpressionSuffixDot)Suffix_475_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_476_Var
		);
		Assert.assertEquals("numFloat", PostfixExpressionSuffixDot_476_Var
		.getId());
		//476
		final AssignmentOperator AssignmentOperator_477_Var
		 = (AssignmentOperator)AssignmentExpression_472_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_477_Var
		);
		Assert.assertEquals("=", AssignmentOperator_477_Var
		.getOp());
		//477
		final AssignmentExpression AssignmentExpression_478_Var
		 = (AssignmentExpression)AssignmentExpression_472_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_478_Var
		);
		//478
		final ConditionalExpression ConditionalExpression_479_Var
		 = (ConditionalExpression)AssignmentExpression_478_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_479_Var
		);
		//479
		final LogicalOrExpression LogicalOrExpression_480_Var
		 = (LogicalOrExpression)ConditionalExpression_479_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_480_Var
		);
		final EList<? extends EObject> Expr_480_list = LogicalOrExpression_480_Var
		.getExpr();
		Assert.assertNotNull(Expr_480_list);
		Assert.assertEquals(1, Expr_480_list.size());
		//480
		final LogicalAndExpression LogicalAndExpression_481_Var
		 = (LogicalAndExpression)Expr_480_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_481_Var
		);
		final EList<? extends EObject> Expr_481_list = LogicalAndExpression_481_Var
		.getExpr();
		Assert.assertNotNull(Expr_481_list);
		Assert.assertEquals(1, Expr_481_list.size());
		//481
		final InclusiveOrExpression InclusiveOrExpression_482_Var
		 = (InclusiveOrExpression)Expr_481_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_482_Var
		);
		final EList<? extends EObject> Expr_482_list = InclusiveOrExpression_482_Var
		.getExpr();
		Assert.assertNotNull(Expr_482_list);
		Assert.assertEquals(1, Expr_482_list.size());
		//482
		final ExclusiveOrExpression ExclusiveOrExpression_483_Var
		 = (ExclusiveOrExpression)Expr_482_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_483_Var
		);
		final EList<? extends EObject> Expr_483_list = ExclusiveOrExpression_483_Var
		.getExpr();
		Assert.assertNotNull(Expr_483_list);
		Assert.assertEquals(1, Expr_483_list.size());
		//483
		final AndExpression AndExpression_484_Var
		 = (AndExpression)Expr_483_list.get(0);
		Assert.assertNotNull(AndExpression_484_Var
		);
		final EList<? extends EObject> Expr_484_list = AndExpression_484_Var
		.getExpr();
		Assert.assertNotNull(Expr_484_list);
		Assert.assertEquals(1, Expr_484_list.size());
		//484
		final EqualityExpression EqualityExpression_485_Var
		 = (EqualityExpression)Expr_484_list.get(0);
		Assert.assertNotNull(EqualityExpression_485_Var
		);
		final EList<? extends EObject> Expr_485_list = EqualityExpression_485_Var
		.getExpr();
		Assert.assertNotNull(Expr_485_list);
		Assert.assertEquals(1, Expr_485_list.size());
		//485
		final RelationalExpression RelationalExpression_486_Var
		 = (RelationalExpression)Expr_485_list.get(0);
		Assert.assertNotNull(RelationalExpression_486_Var
		);
		final EList<? extends EObject> Expr_486_list = RelationalExpression_486_Var
		.getExpr();
		Assert.assertNotNull(Expr_486_list);
		Assert.assertEquals(1, Expr_486_list.size());
		//486
		final ShiftExpression ShiftExpression_487_Var
		 = (ShiftExpression)Expr_486_list.get(0);
		Assert.assertNotNull(ShiftExpression_487_Var
		);
		final EList<? extends EObject> Expr_487_list = ShiftExpression_487_Var
		.getExpr();
		Assert.assertNotNull(Expr_487_list);
		Assert.assertEquals(1, Expr_487_list.size());
		//487
		final AdditiveExpression AdditiveExpression_488_Var
		 = (AdditiveExpression)Expr_487_list.get(0);
		Assert.assertNotNull(AdditiveExpression_488_Var
		);
		final EList<? extends EObject> Expr_488_list = AdditiveExpression_488_Var
		.getExpr();
		Assert.assertNotNull(Expr_488_list);
		Assert.assertEquals(1, Expr_488_list.size());
		//488
		final MultiplicativeExpression MultiplicativeExpression_489_Var
		 = (MultiplicativeExpression)Expr_488_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_489_Var
		);
		final EList<? extends EObject> Expr_489_list = MultiplicativeExpression_489_Var
		.getExpr();
		Assert.assertNotNull(Expr_489_list);
		Assert.assertEquals(1, Expr_489_list.size());
		//489
		final CastExpression CastExpression_490_Var
		 = (CastExpression)Expr_489_list.get(0);
		Assert.assertNotNull(CastExpression_490_Var
		);
		//490
		final UnaryExpression UnaryExpression_491_Var
		 = (UnaryExpression)CastExpression_490_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_491_Var
		);
		//491
		final PostfixExpression PostfixExpression_492_Var
		 = (PostfixExpression)UnaryExpression_491_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_492_Var
		);
		final EList<? extends EObject> Expr_492_list = PostfixExpression_492_Var
		.getExpr();
		Assert.assertNotNull(Expr_492_list);
		Assert.assertEquals(1, Expr_492_list.size());
		//492
		final PrimaryExpression PrimaryExpression_493_Var
		 = (PrimaryExpression)Expr_492_list.get(0);
		Assert.assertNotNull(PrimaryExpression_493_Var
		);
		//493
		final Constant2 Constant2_494_Var
		 = (Constant2)PrimaryExpression_493_Var
		.getConst();
		Assert.assertNotNull(Constant2_494_Var
		);
		Assert.assertEquals("0.56789", Constant2_494_Var
		.getFloat());
		Assert.assertEquals(";", ExpressionStatement_470_Var
		.getSemi());
		//494
		final Statement Statement_495_Var
		 = (Statement)Statement_95_list.get(8);
		Assert.assertNotNull(Statement_495_Var
		);
		//495
		final ExpressionStatement ExpressionStatement_496_Var
		 = (ExpressionStatement)Statement_495_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_496_Var
		);
		//496
		final Expression Expression_497_Var
		 = (Expression)ExpressionStatement_496_Var
		.getExpression();
		Assert.assertNotNull(Expression_497_Var
		);
		final EList<? extends EObject> ExprExpr_497_list = Expression_497_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_497_list);
		Assert.assertEquals(1, ExprExpr_497_list.size());
		//497
		final AssignmentExpression AssignmentExpression_498_Var
		 = (AssignmentExpression)ExprExpr_497_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_513_Var
		.getId());
		final EList<? extends EObject> Suffix_513_list = PostfixExpression_512_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_513_list);
		Assert.assertEquals(1, Suffix_513_list.size());
		//513
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_514_Var
		 = (PostfixExpressionSuffixArgument)Suffix_513_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_514_Var
		);
		//514
		final ArgumentExpressionList ArgumentExpressionList_515_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_514_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_515_Var
		);
		final EList<? extends EObject> Expr_515_list = ArgumentExpressionList_515_Var
		.getExpr();
		Assert.assertNotNull(Expr_515_list);
		Assert.assertEquals(2, Expr_515_list.size());
		//515
		final AssignmentExpression AssignmentExpression_516_Var
		 = (AssignmentExpression)Expr_515_list.get(0);
		Assert.assertNotNull(AssignmentExpression_516_Var
		);
		//516
		final ConditionalExpression ConditionalExpression_517_Var
		 = (ConditionalExpression)AssignmentExpression_516_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_517_Var
		);
		//517
		final LogicalOrExpression LogicalOrExpression_518_Var
		 = (LogicalOrExpression)ConditionalExpression_517_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_518_Var
		);
		final EList<? extends EObject> Expr_518_list = LogicalOrExpression_518_Var
		.getExpr();
		Assert.assertNotNull(Expr_518_list);
		Assert.assertEquals(1, Expr_518_list.size());
		//518
		final LogicalAndExpression LogicalAndExpression_519_Var
		 = (LogicalAndExpression)Expr_518_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_519_Var
		);
		final EList<? extends EObject> Expr_519_list = LogicalAndExpression_519_Var
		.getExpr();
		Assert.assertNotNull(Expr_519_list);
		Assert.assertEquals(1, Expr_519_list.size());
		//519
		final InclusiveOrExpression InclusiveOrExpression_520_Var
		 = (InclusiveOrExpression)Expr_519_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_520_Var
		);
		final EList<? extends EObject> Expr_520_list = InclusiveOrExpression_520_Var
		.getExpr();
		Assert.assertNotNull(Expr_520_list);
		Assert.assertEquals(1, Expr_520_list.size());
		//520
		final ExclusiveOrExpression ExclusiveOrExpression_521_Var
		 = (ExclusiveOrExpression)Expr_520_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_521_Var
		);
		final EList<? extends EObject> Expr_521_list = ExclusiveOrExpression_521_Var
		.getExpr();
		Assert.assertNotNull(Expr_521_list);
		Assert.assertEquals(1, Expr_521_list.size());
		//521
		final AndExpression AndExpression_522_Var
		 = (AndExpression)Expr_521_list.get(0);
		Assert.assertNotNull(AndExpression_522_Var
		);
		final EList<? extends EObject> Expr_522_list = AndExpression_522_Var
		.getExpr();
		Assert.assertNotNull(Expr_522_list);
		Assert.assertEquals(1, Expr_522_list.size());
		//522
		final EqualityExpression EqualityExpression_523_Var
		 = (EqualityExpression)Expr_522_list.get(0);
		Assert.assertNotNull(EqualityExpression_523_Var
		);
		final EList<? extends EObject> Expr_523_list = EqualityExpression_523_Var
		.getExpr();
		Assert.assertNotNull(Expr_523_list);
		Assert.assertEquals(1, Expr_523_list.size());
		//523
		final RelationalExpression RelationalExpression_524_Var
		 = (RelationalExpression)Expr_523_list.get(0);
		Assert.assertNotNull(RelationalExpression_524_Var
		);
		final EList<? extends EObject> Expr_524_list = RelationalExpression_524_Var
		.getExpr();
		Assert.assertNotNull(Expr_524_list);
		Assert.assertEquals(1, Expr_524_list.size());
		//524
		final ShiftExpression ShiftExpression_525_Var
		 = (ShiftExpression)Expr_524_list.get(0);
		Assert.assertNotNull(ShiftExpression_525_Var
		);
		final EList<? extends EObject> Expr_525_list = ShiftExpression_525_Var
		.getExpr();
		Assert.assertNotNull(Expr_525_list);
		Assert.assertEquals(1, Expr_525_list.size());
		//525
		final AdditiveExpression AdditiveExpression_526_Var
		 = (AdditiveExpression)Expr_525_list.get(0);
		Assert.assertNotNull(AdditiveExpression_526_Var
		);
		final EList<? extends EObject> Expr_526_list = AdditiveExpression_526_Var
		.getExpr();
		Assert.assertNotNull(Expr_526_list);
		Assert.assertEquals(1, Expr_526_list.size());
		//526
		final MultiplicativeExpression MultiplicativeExpression_527_Var
		 = (MultiplicativeExpression)Expr_526_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_527_Var
		);
		final EList<? extends EObject> Expr_527_list = MultiplicativeExpression_527_Var
		.getExpr();
		Assert.assertNotNull(Expr_527_list);
		Assert.assertEquals(1, Expr_527_list.size());
		//527
		final CastExpression CastExpression_528_Var
		 = (CastExpression)Expr_527_list.get(0);
		Assert.assertNotNull(CastExpression_528_Var
		);
		//528
		final UnaryExpression UnaryExpression_529_Var
		 = (UnaryExpression)CastExpression_528_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_529_Var
		);
		//529
		final PostfixExpression PostfixExpression_530_Var
		 = (PostfixExpression)UnaryExpression_529_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_530_Var
		);
		final EList<? extends EObject> Expr_530_list = PostfixExpression_530_Var
		.getExpr();
		Assert.assertNotNull(Expr_530_list);
		Assert.assertEquals(1, Expr_530_list.size());
		//530
		final PrimaryExpression PrimaryExpression_531_Var
		 = (PrimaryExpression)Expr_530_list.get(0);
		Assert.assertNotNull(PrimaryExpression_531_Var
		);
		//531
		final Constant2 Constant2_532_Var
		 = (Constant2)PrimaryExpression_531_Var
		.getConst();
		Assert.assertNotNull(Constant2_532_Var
		);
		Assert.assertEquals("\"number.numChar(as decimal)=%d\\n\"", Constant2_532_Var
		.getStr());
		//532
		final AssignmentExpression AssignmentExpression_533_Var
		 = (AssignmentExpression)Expr_515_list.get(1);
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
		Assert.assertEquals("number", PrimaryExpression_548_Var
		.getId());
		final EList<? extends EObject> Suffix_548_list = PostfixExpression_547_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_548_list);
		Assert.assertEquals(1, Suffix_548_list.size());
		//548
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_549_Var
		 = (PostfixExpressionSuffixDot)Suffix_548_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_549_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_549_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_496_Var
		.getSemi());
		//549
		final Statement Statement_550_Var
		 = (Statement)Statement_95_list.get(9);
		Assert.assertNotNull(Statement_550_Var
		);
		//550
		final ExpressionStatement ExpressionStatement_551_Var
		 = (ExpressionStatement)Statement_550_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_551_Var
		);
		//551
		final Expression Expression_552_Var
		 = (Expression)ExpressionStatement_551_Var
		.getExpression();
		Assert.assertNotNull(Expression_552_Var
		);
		final EList<? extends EObject> ExprExpr_552_list = Expression_552_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_552_list);
		Assert.assertEquals(1, ExprExpr_552_list.size());
		//552
		final AssignmentExpression AssignmentExpression_553_Var
		 = (AssignmentExpression)ExprExpr_552_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_568_Var
		.getId());
		final EList<? extends EObject> Suffix_568_list = PostfixExpression_567_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_568_list);
		Assert.assertEquals(1, Suffix_568_list.size());
		//568
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_569_Var
		 = (PostfixExpressionSuffixArgument)Suffix_568_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_569_Var
		);
		//569
		final ArgumentExpressionList ArgumentExpressionList_570_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_569_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_570_Var
		);
		final EList<? extends EObject> Expr_570_list = ArgumentExpressionList_570_Var
		.getExpr();
		Assert.assertNotNull(Expr_570_list);
		Assert.assertEquals(2, Expr_570_list.size());
		//570
		final AssignmentExpression AssignmentExpression_571_Var
		 = (AssignmentExpression)Expr_570_list.get(0);
		Assert.assertNotNull(AssignmentExpression_571_Var
		);
		//571
		final ConditionalExpression ConditionalExpression_572_Var
		 = (ConditionalExpression)AssignmentExpression_571_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_572_Var
		);
		//572
		final LogicalOrExpression LogicalOrExpression_573_Var
		 = (LogicalOrExpression)ConditionalExpression_572_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_573_Var
		);
		final EList<? extends EObject> Expr_573_list = LogicalOrExpression_573_Var
		.getExpr();
		Assert.assertNotNull(Expr_573_list);
		Assert.assertEquals(1, Expr_573_list.size());
		//573
		final LogicalAndExpression LogicalAndExpression_574_Var
		 = (LogicalAndExpression)Expr_573_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_574_Var
		);
		final EList<? extends EObject> Expr_574_list = LogicalAndExpression_574_Var
		.getExpr();
		Assert.assertNotNull(Expr_574_list);
		Assert.assertEquals(1, Expr_574_list.size());
		//574
		final InclusiveOrExpression InclusiveOrExpression_575_Var
		 = (InclusiveOrExpression)Expr_574_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_575_Var
		);
		final EList<? extends EObject> Expr_575_list = InclusiveOrExpression_575_Var
		.getExpr();
		Assert.assertNotNull(Expr_575_list);
		Assert.assertEquals(1, Expr_575_list.size());
		//575
		final ExclusiveOrExpression ExclusiveOrExpression_576_Var
		 = (ExclusiveOrExpression)Expr_575_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_576_Var
		);
		final EList<? extends EObject> Expr_576_list = ExclusiveOrExpression_576_Var
		.getExpr();
		Assert.assertNotNull(Expr_576_list);
		Assert.assertEquals(1, Expr_576_list.size());
		//576
		final AndExpression AndExpression_577_Var
		 = (AndExpression)Expr_576_list.get(0);
		Assert.assertNotNull(AndExpression_577_Var
		);
		final EList<? extends EObject> Expr_577_list = AndExpression_577_Var
		.getExpr();
		Assert.assertNotNull(Expr_577_list);
		Assert.assertEquals(1, Expr_577_list.size());
		//577
		final EqualityExpression EqualityExpression_578_Var
		 = (EqualityExpression)Expr_577_list.get(0);
		Assert.assertNotNull(EqualityExpression_578_Var
		);
		final EList<? extends EObject> Expr_578_list = EqualityExpression_578_Var
		.getExpr();
		Assert.assertNotNull(Expr_578_list);
		Assert.assertEquals(1, Expr_578_list.size());
		//578
		final RelationalExpression RelationalExpression_579_Var
		 = (RelationalExpression)Expr_578_list.get(0);
		Assert.assertNotNull(RelationalExpression_579_Var
		);
		final EList<? extends EObject> Expr_579_list = RelationalExpression_579_Var
		.getExpr();
		Assert.assertNotNull(Expr_579_list);
		Assert.assertEquals(1, Expr_579_list.size());
		//579
		final ShiftExpression ShiftExpression_580_Var
		 = (ShiftExpression)Expr_579_list.get(0);
		Assert.assertNotNull(ShiftExpression_580_Var
		);
		final EList<? extends EObject> Expr_580_list = ShiftExpression_580_Var
		.getExpr();
		Assert.assertNotNull(Expr_580_list);
		Assert.assertEquals(1, Expr_580_list.size());
		//580
		final AdditiveExpression AdditiveExpression_581_Var
		 = (AdditiveExpression)Expr_580_list.get(0);
		Assert.assertNotNull(AdditiveExpression_581_Var
		);
		final EList<? extends EObject> Expr_581_list = AdditiveExpression_581_Var
		.getExpr();
		Assert.assertNotNull(Expr_581_list);
		Assert.assertEquals(1, Expr_581_list.size());
		//581
		final MultiplicativeExpression MultiplicativeExpression_582_Var
		 = (MultiplicativeExpression)Expr_581_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_582_Var
		);
		final EList<? extends EObject> Expr_582_list = MultiplicativeExpression_582_Var
		.getExpr();
		Assert.assertNotNull(Expr_582_list);
		Assert.assertEquals(1, Expr_582_list.size());
		//582
		final CastExpression CastExpression_583_Var
		 = (CastExpression)Expr_582_list.get(0);
		Assert.assertNotNull(CastExpression_583_Var
		);
		//583
		final UnaryExpression UnaryExpression_584_Var
		 = (UnaryExpression)CastExpression_583_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_584_Var
		);
		//584
		final PostfixExpression PostfixExpression_585_Var
		 = (PostfixExpression)UnaryExpression_584_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_585_Var
		);
		final EList<? extends EObject> Expr_585_list = PostfixExpression_585_Var
		.getExpr();
		Assert.assertNotNull(Expr_585_list);
		Assert.assertEquals(1, Expr_585_list.size());
		//585
		final PrimaryExpression PrimaryExpression_586_Var
		 = (PrimaryExpression)Expr_585_list.get(0);
		Assert.assertNotNull(PrimaryExpression_586_Var
		);
		//586
		final Constant2 Constant2_587_Var
		 = (Constant2)PrimaryExpression_586_Var
		.getConst();
		Assert.assertNotNull(Constant2_587_Var
		);
		Assert.assertEquals("\"number.numFloat=%f\\n\"", Constant2_587_Var
		.getStr());
		//587
		final AssignmentExpression AssignmentExpression_588_Var
		 = (AssignmentExpression)Expr_570_list.get(1);
		Assert.assertNotNull(AssignmentExpression_588_Var
		);
		//588
		final ConditionalExpression ConditionalExpression_589_Var
		 = (ConditionalExpression)AssignmentExpression_588_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_589_Var
		);
		//589
		final LogicalOrExpression LogicalOrExpression_590_Var
		 = (LogicalOrExpression)ConditionalExpression_589_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_590_Var
		);
		final EList<? extends EObject> Expr_590_list = LogicalOrExpression_590_Var
		.getExpr();
		Assert.assertNotNull(Expr_590_list);
		Assert.assertEquals(1, Expr_590_list.size());
		//590
		final LogicalAndExpression LogicalAndExpression_591_Var
		 = (LogicalAndExpression)Expr_590_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_591_Var
		);
		final EList<? extends EObject> Expr_591_list = LogicalAndExpression_591_Var
		.getExpr();
		Assert.assertNotNull(Expr_591_list);
		Assert.assertEquals(1, Expr_591_list.size());
		//591
		final InclusiveOrExpression InclusiveOrExpression_592_Var
		 = (InclusiveOrExpression)Expr_591_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_592_Var
		);
		final EList<? extends EObject> Expr_592_list = InclusiveOrExpression_592_Var
		.getExpr();
		Assert.assertNotNull(Expr_592_list);
		Assert.assertEquals(1, Expr_592_list.size());
		//592
		final ExclusiveOrExpression ExclusiveOrExpression_593_Var
		 = (ExclusiveOrExpression)Expr_592_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_593_Var
		);
		final EList<? extends EObject> Expr_593_list = ExclusiveOrExpression_593_Var
		.getExpr();
		Assert.assertNotNull(Expr_593_list);
		Assert.assertEquals(1, Expr_593_list.size());
		//593
		final AndExpression AndExpression_594_Var
		 = (AndExpression)Expr_593_list.get(0);
		Assert.assertNotNull(AndExpression_594_Var
		);
		final EList<? extends EObject> Expr_594_list = AndExpression_594_Var
		.getExpr();
		Assert.assertNotNull(Expr_594_list);
		Assert.assertEquals(1, Expr_594_list.size());
		//594
		final EqualityExpression EqualityExpression_595_Var
		 = (EqualityExpression)Expr_594_list.get(0);
		Assert.assertNotNull(EqualityExpression_595_Var
		);
		final EList<? extends EObject> Expr_595_list = EqualityExpression_595_Var
		.getExpr();
		Assert.assertNotNull(Expr_595_list);
		Assert.assertEquals(1, Expr_595_list.size());
		//595
		final RelationalExpression RelationalExpression_596_Var
		 = (RelationalExpression)Expr_595_list.get(0);
		Assert.assertNotNull(RelationalExpression_596_Var
		);
		final EList<? extends EObject> Expr_596_list = RelationalExpression_596_Var
		.getExpr();
		Assert.assertNotNull(Expr_596_list);
		Assert.assertEquals(1, Expr_596_list.size());
		//596
		final ShiftExpression ShiftExpression_597_Var
		 = (ShiftExpression)Expr_596_list.get(0);
		Assert.assertNotNull(ShiftExpression_597_Var
		);
		final EList<? extends EObject> Expr_597_list = ShiftExpression_597_Var
		.getExpr();
		Assert.assertNotNull(Expr_597_list);
		Assert.assertEquals(1, Expr_597_list.size());
		//597
		final AdditiveExpression AdditiveExpression_598_Var
		 = (AdditiveExpression)Expr_597_list.get(0);
		Assert.assertNotNull(AdditiveExpression_598_Var
		);
		final EList<? extends EObject> Expr_598_list = AdditiveExpression_598_Var
		.getExpr();
		Assert.assertNotNull(Expr_598_list);
		Assert.assertEquals(1, Expr_598_list.size());
		//598
		final MultiplicativeExpression MultiplicativeExpression_599_Var
		 = (MultiplicativeExpression)Expr_598_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_599_Var
		);
		final EList<? extends EObject> Expr_599_list = MultiplicativeExpression_599_Var
		.getExpr();
		Assert.assertNotNull(Expr_599_list);
		Assert.assertEquals(1, Expr_599_list.size());
		//599
		final CastExpression CastExpression_600_Var
		 = (CastExpression)Expr_599_list.get(0);
		Assert.assertNotNull(CastExpression_600_Var
		);
		//600
		final UnaryExpression UnaryExpression_601_Var
		 = (UnaryExpression)CastExpression_600_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_601_Var
		);
		//601
		final PostfixExpression PostfixExpression_602_Var
		 = (PostfixExpression)UnaryExpression_601_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_602_Var
		);
		final EList<? extends EObject> Expr_602_list = PostfixExpression_602_Var
		.getExpr();
		Assert.assertNotNull(Expr_602_list);
		Assert.assertEquals(1, Expr_602_list.size());
		//602
		final PrimaryExpression PrimaryExpression_603_Var
		 = (PrimaryExpression)Expr_602_list.get(0);
		Assert.assertNotNull(PrimaryExpression_603_Var
		);
		Assert.assertEquals("number", PrimaryExpression_603_Var
		.getId());
		final EList<? extends EObject> Suffix_603_list = PostfixExpression_602_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_603_list);
		Assert.assertEquals(1, Suffix_603_list.size());
		//603
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_604_Var
		 = (PostfixExpressionSuffixDot)Suffix_603_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_604_Var
		);
		Assert.assertEquals("numFloat", PostfixExpressionSuffixDot_604_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_551_Var
		.getSemi());
		//604
		final Statement Statement_605_Var
		 = (Statement)Statement_95_list.get(10);
		Assert.assertNotNull(Statement_605_Var
		);
		//605
		final JumpStatement JumpStatement_606_Var
		 = (JumpStatement)Statement_605_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_606_Var
		);
		//606
		final Expression Expression_607_Var
		 = (Expression)JumpStatement_606_Var
		.getExpr();
		Assert.assertNotNull(Expression_607_Var
		);
		final EList<? extends EObject> ExprExpr_607_list = Expression_607_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_607_list);
		Assert.assertEquals(1, ExprExpr_607_list.size());
		//607
		final AssignmentExpression AssignmentExpression_608_Var
		 = (AssignmentExpression)ExprExpr_607_list.get(0);
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
		//623
		final Constant2 Constant2_624_Var
		 = (Constant2)PrimaryExpression_623_Var
		.getConst();
		Assert.assertNotNull(Constant2_624_Var
		);
		Assert.assertEquals("0", Constant2_624_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_606_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_606_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0034_Union.c");
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
				method.invoke(this.generator, "Test0034_Union.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0034_Union.c");
		final String expected = this.getTextFromFile(
			"res/Test0034_Union.c"
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


