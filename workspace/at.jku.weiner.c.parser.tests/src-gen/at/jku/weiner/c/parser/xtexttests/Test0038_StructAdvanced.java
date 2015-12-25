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
import at.jku.weiner.c.parser.parser.StorageClassSpecifier;
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
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
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
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Pointer;
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
import at.jku.weiner.c.parser.parser.UnaryOperator;
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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArrow;
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
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.Pointer;
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
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.SelectionStatement;
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
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.CompoundStatement;
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
import at.jku.weiner.c.parser.parser.UnaryOperator;
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
import at.jku.weiner.c.parser.parser.UnaryOperator;
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
import at.jku.weiner.c.parser.parser.UnaryOperator;
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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArrow;
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
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArrow;
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
public class Test0038_StructAdvanced {
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
			"res/Test0038_StructAdvanced.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_LINEDIRECTIVE", 
				"RULE_NEWLINE", 
				"RULE_LINEDIRECTIVE", 
				"RULE_NEWLINE", 
				"RULE_LINEDIRECTIVE", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_TYPEDEF", 
				"RULE_WHITESPACE", 
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
				"RULE_KW_VOID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_STAR", 
				"RULE_ID", 
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
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_STAR", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
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
				"RULE_ARROW", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_SKW_RIGHTBRACE", 
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
				"RULE_WHITESPACE", 
				"RULE_SKW_STAR", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_KW_SIZEOF", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_IF", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_EQUAL", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_MINUS", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_SKW_RIGHTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_AND", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_AND", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_ARROW", 
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
				"RULE_ARROW", 
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
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
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
			"res/Test0038_StructAdvanced.c");
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
		Assert.assertEquals(5, External_0_list.size());
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
		Assert.assertEquals(2, DeclarationSpecifier_3_list.size());
		//3
		final StorageClassSpecifier StorageClassSpecifier_4_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_4_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_4_Var
		.getName());
		//4
		final StructOrUnionSpecifier StructOrUnionSpecifier_5_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_3_list.get(1);
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
		Assert.assertEquals("empStruct", StructOrUnionSpecifier_5_Var
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
		Assert.assertEquals("employee", DirectDeclarator_43_Var
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
		Assert.assertEquals("empStruct", StructOrUnionSpecifier_47_Var
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
		final Constant2 Constant2_72_Var
		 = (Constant2)PrimaryExpression_71_Var
		.getConst();
		Assert.assertNotNull(Constant2_72_Var
		);
		Assert.assertEquals("0x007", Constant2_72_Var
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
		final Constant2 Constant2_90_Var
		 = (Constant2)PrimaryExpression_89_Var
		.getConst();
		Assert.assertNotNull(Constant2_90_Var
		);
		Assert.assertEquals("\"Joe Nobody\"", Constant2_90_Var
		.getStr());
		//90
		final ExternalDeclaration ExternalDeclaration_91_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_91_Var
		);
		//91
		final Declaration Declaration_92_Var
		 = (Declaration)ExternalDeclaration_91_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_92_Var
		);
		//92
		final DeclarationSpecifiers DeclarationSpecifiers_93_Var
		 = (DeclarationSpecifiers)Declaration_92_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_93_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_93_list = DeclarationSpecifiers_93_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_93_list);
		Assert.assertEquals(1, DeclarationSpecifier_93_list.size());
		//93
		final TypeSpecifier TypeSpecifier_94_Var
		 = (TypeSpecifier)DeclarationSpecifier_93_list.get(0);
		Assert.assertNotNull(TypeSpecifier_94_Var
		);
		//94
		final TypedefName TypedefName_95_Var
		 = (TypedefName)TypeSpecifier_94_Var
		.getType();
		Assert.assertNotNull(TypedefName_95_Var
		);
		Assert.assertEquals("employee", TypedefName_95_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_95_list = Declaration_92_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_95_list);
		Assert.assertEquals(1, InitDeclaratorList_95_list.size());
		//95
		final InitDeclaratorList InitDeclaratorList_96_Var
		 = (InitDeclaratorList)InitDeclaratorList_95_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_96_Var
		);
		final EList<? extends EObject> InitDeclarator_96_list = InitDeclaratorList_96_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_96_list);
		Assert.assertEquals(1, InitDeclarator_96_list.size());
		//96
		final InitDeclarator InitDeclarator_97_Var
		 = (InitDeclarator)InitDeclarator_96_list.get(0);
		Assert.assertNotNull(InitDeclarator_97_Var
		);
		//97
		final Declarator Declarator_98_Var
		 = (Declarator)InitDeclarator_97_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_98_Var
		);
		//98
		final DirectDeclarator DirectDeclarator_99_Var
		 = (DirectDeclarator)Declarator_98_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_99_Var
		);
		Assert.assertEquals("phil", DirectDeclarator_99_Var
		.getId());
		//99
		final Initializer Initializer_100_Var
		 = (Initializer)InitDeclarator_97_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_100_Var
		);
		//100
		final InitializerList InitializerList_101_Var
		 = (InitializerList)Initializer_100_Var
		.getList();
		Assert.assertNotNull(InitializerList_101_Var
		);
		final EList<? extends EObject> Initializer_101_list = InitializerList_101_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_101_list);
		Assert.assertEquals(2, Initializer_101_list.size());
		//101
		final Initializer Initializer_102_Var
		 = (Initializer)Initializer_101_list.get(0);
		Assert.assertNotNull(Initializer_102_Var
		);
		//102
		final AssignmentExpression AssignmentExpression_103_Var
		 = (AssignmentExpression)Initializer_102_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_103_Var
		);
		//103
		final ConditionalExpression ConditionalExpression_104_Var
		 = (ConditionalExpression)AssignmentExpression_103_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_104_Var
		);
		//104
		final LogicalOrExpression LogicalOrExpression_105_Var
		 = (LogicalOrExpression)ConditionalExpression_104_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = LogicalOrExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final LogicalAndExpression LogicalAndExpression_106_Var
		 = (LogicalAndExpression)Expr_105_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = LogicalAndExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final InclusiveOrExpression InclusiveOrExpression_107_Var
		 = (InclusiveOrExpression)Expr_106_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = InclusiveOrExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final ExclusiveOrExpression ExclusiveOrExpression_108_Var
		 = (ExclusiveOrExpression)Expr_107_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = ExclusiveOrExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final AndExpression AndExpression_109_Var
		 = (AndExpression)Expr_108_list.get(0);
		Assert.assertNotNull(AndExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = AndExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final EqualityExpression EqualityExpression_110_Var
		 = (EqualityExpression)Expr_109_list.get(0);
		Assert.assertNotNull(EqualityExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = EqualityExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final RelationalExpression RelationalExpression_111_Var
		 = (RelationalExpression)Expr_110_list.get(0);
		Assert.assertNotNull(RelationalExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = RelationalExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final ShiftExpression ShiftExpression_112_Var
		 = (ShiftExpression)Expr_111_list.get(0);
		Assert.assertNotNull(ShiftExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = ShiftExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final AdditiveExpression AdditiveExpression_113_Var
		 = (AdditiveExpression)Expr_112_list.get(0);
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
		final Constant2 Constant2_119_Var
		 = (Constant2)PrimaryExpression_118_Var
		.getConst();
		Assert.assertNotNull(Constant2_119_Var
		);
		Assert.assertEquals("0x008", Constant2_119_Var
		.getHex());
		//119
		final Initializer Initializer_120_Var
		 = (Initializer)Initializer_101_list.get(1);
		Assert.assertNotNull(Initializer_120_Var
		);
		//120
		final AssignmentExpression AssignmentExpression_121_Var
		 = (AssignmentExpression)Initializer_120_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_121_Var
		);
		//121
		final ConditionalExpression ConditionalExpression_122_Var
		 = (ConditionalExpression)AssignmentExpression_121_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_122_Var
		);
		//122
		final LogicalOrExpression LogicalOrExpression_123_Var
		 = (LogicalOrExpression)ConditionalExpression_122_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = LogicalOrExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final LogicalAndExpression LogicalAndExpression_124_Var
		 = (LogicalAndExpression)Expr_123_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = LogicalAndExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final InclusiveOrExpression InclusiveOrExpression_125_Var
		 = (InclusiveOrExpression)Expr_124_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = InclusiveOrExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final ExclusiveOrExpression ExclusiveOrExpression_126_Var
		 = (ExclusiveOrExpression)Expr_125_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = ExclusiveOrExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final AndExpression AndExpression_127_Var
		 = (AndExpression)Expr_126_list.get(0);
		Assert.assertNotNull(AndExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = AndExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final EqualityExpression EqualityExpression_128_Var
		 = (EqualityExpression)Expr_127_list.get(0);
		Assert.assertNotNull(EqualityExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = EqualityExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final RelationalExpression RelationalExpression_129_Var
		 = (RelationalExpression)Expr_128_list.get(0);
		Assert.assertNotNull(RelationalExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = RelationalExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final ShiftExpression ShiftExpression_130_Var
		 = (ShiftExpression)Expr_129_list.get(0);
		Assert.assertNotNull(ShiftExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = ShiftExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final AdditiveExpression AdditiveExpression_131_Var
		 = (AdditiveExpression)Expr_130_list.get(0);
		Assert.assertNotNull(AdditiveExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = AdditiveExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final MultiplicativeExpression MultiplicativeExpression_132_Var
		 = (MultiplicativeExpression)Expr_131_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = MultiplicativeExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final CastExpression CastExpression_133_Var
		 = (CastExpression)Expr_132_list.get(0);
		Assert.assertNotNull(CastExpression_133_Var
		);
		//133
		final UnaryExpression UnaryExpression_134_Var
		 = (UnaryExpression)CastExpression_133_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_134_Var
		);
		//134
		final PostfixExpression PostfixExpression_135_Var
		 = (PostfixExpression)UnaryExpression_134_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = PostfixExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final PrimaryExpression PrimaryExpression_136_Var
		 = (PrimaryExpression)Expr_135_list.get(0);
		Assert.assertNotNull(PrimaryExpression_136_Var
		);
		//136
		final Constant2 Constant2_137_Var
		 = (Constant2)PrimaryExpression_136_Var
		.getConst();
		Assert.assertNotNull(Constant2_137_Var
		);
		Assert.assertEquals("\"Phil Morrison\"", Constant2_137_Var
		.getStr());
		//137
		final ExternalDeclaration ExternalDeclaration_138_Var
		 = (ExternalDeclaration)External_0_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_138_Var
		);
		//138
		final FunctionDefHead FunctionDefHead_139_Var
		 = (FunctionDefHead)ExternalDeclaration_138_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_139_Var
		);
		//139
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_140_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_139_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_140_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_140_list = FunctionDeclarationSpecifiers_140_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_140_list);
		Assert.assertEquals(1, DeclarationSpecifier_140_list.size());
		//140
		final TypeSpecifier TypeSpecifier_141_Var
		 = (TypeSpecifier)DeclarationSpecifier_140_list.get(0);
		Assert.assertNotNull(TypeSpecifier_141_Var
		);
		Assert.assertEquals("void", TypeSpecifier_141_Var
		.getName());
		//141
		final Declarator Declarator_142_Var
		 = (Declarator)FunctionDefHead_139_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_142_Var
		);
		//142
		final DirectDeclarator DirectDeclarator_143_Var
		 = (DirectDeclarator)Declarator_142_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_143_Var
		);
		Assert.assertEquals("print", DirectDeclarator_143_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_143_list = DirectDeclarator_143_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_143_list);
		Assert.assertEquals(1, DeclaratorSuffix_143_list.size());
		//143
		final DeclaratorSuffix DeclaratorSuffix_144_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_143_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_144_Var
		);
		//144
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_145_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_144_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_145_Var
		);
		final EList<? extends EObject> ParameterTypeList_145_list = DirectDeclaratorLastSuffix_145_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_145_list);
		Assert.assertEquals(1, ParameterTypeList_145_list.size());
		//145
		final ParameterTypeList ParameterTypeList_146_Var
		 = (ParameterTypeList)ParameterTypeList_145_list.get(0);
		Assert.assertNotNull(ParameterTypeList_146_Var
		);
		//146
		final ParameterList ParameterList_147_Var
		 = (ParameterList)ParameterTypeList_146_Var
		.getList();
		Assert.assertNotNull(ParameterList_147_Var
		);
		final EList<? extends EObject> ParameterDeclaration_147_list = ParameterList_147_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_147_list);
		Assert.assertEquals(1, ParameterDeclaration_147_list.size());
		//147
		final ParameterDeclaration ParameterDeclaration_148_Var
		 = (ParameterDeclaration)ParameterDeclaration_147_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_148_Var
		);
		//148
		final DeclarationSpecifiers DeclarationSpecifiers_149_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_148_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_149_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_149_list = DeclarationSpecifiers_149_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_149_list);
		Assert.assertEquals(1, DeclarationSpecifier_149_list.size());
		//149
		final TypeSpecifier TypeSpecifier_150_Var
		 = (TypeSpecifier)DeclarationSpecifier_149_list.get(0);
		Assert.assertNotNull(TypeSpecifier_150_Var
		);
		//150
		final TypedefName TypedefName_151_Var
		 = (TypedefName)TypeSpecifier_150_Var
		.getType();
		Assert.assertNotNull(TypedefName_151_Var
		);
		Assert.assertEquals("employee", TypedefName_151_Var
		.getId());
		//151
		final Declarator Declarator_152_Var
		 = (Declarator)ParameterDeclaration_148_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_152_Var
		);
		//152
		final DirectDeclarator DirectDeclarator_153_Var
		 = (DirectDeclarator)Declarator_152_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_153_Var
		);
		Assert.assertEquals("emp", DirectDeclarator_153_Var
		.getId());
		//153
		final Pointer Pointer_154_Var
		 = (Pointer)Declarator_152_Var
		.getPointer();
		Assert.assertNotNull(Pointer_154_Var
		);
		Assert.assertEquals("[*]", Pointer_154_Var
		.getStar().toString());
		//154
		final FunctionDefinition FunctionDefinition_155_Var
		 = (FunctionDefinition)ExternalDeclaration_138_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_155_Var
		);
		//155
		final BodyStatement BodyStatement_156_Var
		 = (BodyStatement)FunctionDefinition_155_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_156_Var
		);
		final EList<? extends EObject> BlockList_156_list = BodyStatement_156_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_156_list);
		Assert.assertEquals(1, BlockList_156_list.size());
		//156
		final BlockList BlockList_157_Var
		 = (BlockList)BlockList_156_list.get(0);
		Assert.assertNotNull(BlockList_157_Var
		);
		final EList<? extends EObject> Statement_157_list = BlockList_157_Var
		.getStatement();
		Assert.assertNotNull(Statement_157_list);
		Assert.assertEquals(2, Statement_157_list.size());
		//157
		final Statement Statement_158_Var
		 = (Statement)Statement_157_list.get(0);
		Assert.assertNotNull(Statement_158_Var
		);
		//158
		final ExpressionStatement ExpressionStatement_159_Var
		 = (ExpressionStatement)Statement_158_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_159_Var
		);
		//159
		final Expression Expression_160_Var
		 = (Expression)ExpressionStatement_159_Var
		.getExpression();
		Assert.assertNotNull(Expression_160_Var
		);
		final EList<? extends EObject> ExprExpr_160_list = Expression_160_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_160_list);
		Assert.assertEquals(1, ExprExpr_160_list.size());
		//160
		final AssignmentExpression AssignmentExpression_161_Var
		 = (AssignmentExpression)ExprExpr_160_list.get(0);
		Assert.assertNotNull(AssignmentExpression_161_Var
		);
		//161
		final ConditionalExpression ConditionalExpression_162_Var
		 = (ConditionalExpression)AssignmentExpression_161_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_162_Var
		);
		//162
		final LogicalOrExpression LogicalOrExpression_163_Var
		 = (LogicalOrExpression)ConditionalExpression_162_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_163_Var
		);
		final EList<? extends EObject> Expr_163_list = LogicalOrExpression_163_Var
		.getExpr();
		Assert.assertNotNull(Expr_163_list);
		Assert.assertEquals(1, Expr_163_list.size());
		//163
		final LogicalAndExpression LogicalAndExpression_164_Var
		 = (LogicalAndExpression)Expr_163_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_164_Var
		);
		final EList<? extends EObject> Expr_164_list = LogicalAndExpression_164_Var
		.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		//164
		final InclusiveOrExpression InclusiveOrExpression_165_Var
		 = (InclusiveOrExpression)Expr_164_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_165_Var
		);
		final EList<? extends EObject> Expr_165_list = InclusiveOrExpression_165_Var
		.getExpr();
		Assert.assertNotNull(Expr_165_list);
		Assert.assertEquals(1, Expr_165_list.size());
		//165
		final ExclusiveOrExpression ExclusiveOrExpression_166_Var
		 = (ExclusiveOrExpression)Expr_165_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_166_Var
		);
		final EList<? extends EObject> Expr_166_list = ExclusiveOrExpression_166_Var
		.getExpr();
		Assert.assertNotNull(Expr_166_list);
		Assert.assertEquals(1, Expr_166_list.size());
		//166
		final AndExpression AndExpression_167_Var
		 = (AndExpression)Expr_166_list.get(0);
		Assert.assertNotNull(AndExpression_167_Var
		);
		final EList<? extends EObject> Expr_167_list = AndExpression_167_Var
		.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(1, Expr_167_list.size());
		//167
		final EqualityExpression EqualityExpression_168_Var
		 = (EqualityExpression)Expr_167_list.get(0);
		Assert.assertNotNull(EqualityExpression_168_Var
		);
		final EList<? extends EObject> Expr_168_list = EqualityExpression_168_Var
		.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(1, Expr_168_list.size());
		//168
		final RelationalExpression RelationalExpression_169_Var
		 = (RelationalExpression)Expr_168_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_176_Var
		.getId());
		final EList<? extends EObject> Suffix_176_list = PostfixExpression_175_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_176_list);
		Assert.assertEquals(1, Suffix_176_list.size());
		//176
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_177_Var
		 = (PostfixExpressionSuffixArgument)Suffix_176_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_177_Var
		);
		//177
		final ArgumentExpressionList ArgumentExpressionList_178_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_177_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_178_Var
		);
		final EList<? extends EObject> Expr_178_list = ArgumentExpressionList_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(2, Expr_178_list.size());
		//178
		final AssignmentExpression AssignmentExpression_179_Var
		 = (AssignmentExpression)Expr_178_list.get(0);
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
		Assert.assertEquals(1, Expr_185_list.size());
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
		Assert.assertEquals("\"(*employee).id=%d\\n\"", Constant2_195_Var
		.getStr());
		//195
		final AssignmentExpression AssignmentExpression_196_Var
		 = (AssignmentExpression)Expr_178_list.get(1);
		Assert.assertNotNull(AssignmentExpression_196_Var
		);
		//196
		final ConditionalExpression ConditionalExpression_197_Var
		 = (ConditionalExpression)AssignmentExpression_196_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_197_Var
		);
		//197
		final LogicalOrExpression LogicalOrExpression_198_Var
		 = (LogicalOrExpression)ConditionalExpression_197_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = LogicalOrExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final LogicalAndExpression LogicalAndExpression_199_Var
		 = (LogicalAndExpression)Expr_198_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = LogicalAndExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final InclusiveOrExpression InclusiveOrExpression_200_Var
		 = (InclusiveOrExpression)Expr_199_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = InclusiveOrExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final ExclusiveOrExpression ExclusiveOrExpression_201_Var
		 = (ExclusiveOrExpression)Expr_200_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = ExclusiveOrExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final AndExpression AndExpression_202_Var
		 = (AndExpression)Expr_201_list.get(0);
		Assert.assertNotNull(AndExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = AndExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final EqualityExpression EqualityExpression_203_Var
		 = (EqualityExpression)Expr_202_list.get(0);
		Assert.assertNotNull(EqualityExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = EqualityExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final RelationalExpression RelationalExpression_204_Var
		 = (RelationalExpression)Expr_203_list.get(0);
		Assert.assertNotNull(RelationalExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = RelationalExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final ShiftExpression ShiftExpression_205_Var
		 = (ShiftExpression)Expr_204_list.get(0);
		Assert.assertNotNull(ShiftExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = ShiftExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final AdditiveExpression AdditiveExpression_206_Var
		 = (AdditiveExpression)Expr_205_list.get(0);
		Assert.assertNotNull(AdditiveExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = AdditiveExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final MultiplicativeExpression MultiplicativeExpression_207_Var
		 = (MultiplicativeExpression)Expr_206_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = MultiplicativeExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final CastExpression CastExpression_208_Var
		 = (CastExpression)Expr_207_list.get(0);
		Assert.assertNotNull(CastExpression_208_Var
		);
		//208
		final UnaryExpression UnaryExpression_209_Var
		 = (UnaryExpression)CastExpression_208_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_209_Var
		);
		//209
		final PostfixExpression PostfixExpression_210_Var
		 = (PostfixExpression)UnaryExpression_209_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = PostfixExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final PrimaryExpression PrimaryExpression_211_Var
		 = (PrimaryExpression)Expr_210_list.get(0);
		Assert.assertNotNull(PrimaryExpression_211_Var
		);
		//211
		final Expression Expression_212_Var
		 = (Expression)PrimaryExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expression_212_Var
		);
		final EList<? extends EObject> ExprExpr_212_list = Expression_212_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_212_list);
		Assert.assertEquals(1, ExprExpr_212_list.size());
		//212
		final AssignmentExpression AssignmentExpression_213_Var
		 = (AssignmentExpression)ExprExpr_212_list.get(0);
		Assert.assertNotNull(AssignmentExpression_213_Var
		);
		//213
		final ConditionalExpression ConditionalExpression_214_Var
		 = (ConditionalExpression)AssignmentExpression_213_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_214_Var
		);
		//214
		final LogicalOrExpression LogicalOrExpression_215_Var
		 = (LogicalOrExpression)ConditionalExpression_214_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = LogicalOrExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final LogicalAndExpression LogicalAndExpression_216_Var
		 = (LogicalAndExpression)Expr_215_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = LogicalAndExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final InclusiveOrExpression InclusiveOrExpression_217_Var
		 = (InclusiveOrExpression)Expr_216_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = InclusiveOrExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final ExclusiveOrExpression ExclusiveOrExpression_218_Var
		 = (ExclusiveOrExpression)Expr_217_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = ExclusiveOrExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final AndExpression AndExpression_219_Var
		 = (AndExpression)Expr_218_list.get(0);
		Assert.assertNotNull(AndExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = AndExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final EqualityExpression EqualityExpression_220_Var
		 = (EqualityExpression)Expr_219_list.get(0);
		Assert.assertNotNull(EqualityExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = EqualityExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final RelationalExpression RelationalExpression_221_Var
		 = (RelationalExpression)Expr_220_list.get(0);
		Assert.assertNotNull(RelationalExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = RelationalExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final ShiftExpression ShiftExpression_222_Var
		 = (ShiftExpression)Expr_221_list.get(0);
		Assert.assertNotNull(ShiftExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = ShiftExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final AdditiveExpression AdditiveExpression_223_Var
		 = (AdditiveExpression)Expr_222_list.get(0);
		Assert.assertNotNull(AdditiveExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = AdditiveExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final MultiplicativeExpression MultiplicativeExpression_224_Var
		 = (MultiplicativeExpression)Expr_223_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = MultiplicativeExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final CastExpression CastExpression_225_Var
		 = (CastExpression)Expr_224_list.get(0);
		Assert.assertNotNull(CastExpression_225_Var
		);
		//225
		final UnaryExpression UnaryExpression_226_Var
		 = (UnaryExpression)CastExpression_225_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_226_Var
		);
		//226
		final UnaryOperator UnaryOperator_227_Var
		 = (UnaryOperator)UnaryExpression_226_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_227_Var
		);
		Assert.assertEquals("*", UnaryOperator_227_Var
		.getOp());
		//227
		final CastExpression CastExpression_228_Var
		 = (CastExpression)UnaryExpression_226_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_228_Var
		);
		//228
		final UnaryExpression UnaryExpression_229_Var
		 = (UnaryExpression)CastExpression_228_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_229_Var
		);
		//229
		final PostfixExpression PostfixExpression_230_Var
		 = (PostfixExpression)UnaryExpression_229_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = PostfixExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final PrimaryExpression PrimaryExpression_231_Var
		 = (PrimaryExpression)Expr_230_list.get(0);
		Assert.assertNotNull(PrimaryExpression_231_Var
		);
		Assert.assertEquals("emp", PrimaryExpression_231_Var
		.getId());
		final EList<? extends EObject> Suffix_231_list = PostfixExpression_210_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_231_list);
		Assert.assertEquals(1, Suffix_231_list.size());
		//231
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_232_Var
		 = (PostfixExpressionSuffixDot)Suffix_231_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_232_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_232_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_159_Var
		.getSemi());
		//232
		final Statement Statement_233_Var
		 = (Statement)Statement_157_list.get(1);
		Assert.assertNotNull(Statement_233_Var
		);
		//233
		final ExpressionStatement ExpressionStatement_234_Var
		 = (ExpressionStatement)Statement_233_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_234_Var
		);
		//234
		final Expression Expression_235_Var
		 = (Expression)ExpressionStatement_234_Var
		.getExpression();
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
		Assert.assertEquals("printf", PrimaryExpression_251_Var
		.getId());
		final EList<? extends EObject> Suffix_251_list = PostfixExpression_250_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_251_list);
		Assert.assertEquals(1, Suffix_251_list.size());
		//251
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_252_Var
		 = (PostfixExpressionSuffixArgument)Suffix_251_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_252_Var
		);
		//252
		final ArgumentExpressionList ArgumentExpressionList_253_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_252_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_253_Var
		);
		final EList<? extends EObject> Expr_253_list = ArgumentExpressionList_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(2, Expr_253_list.size());
		//253
		final AssignmentExpression AssignmentExpression_254_Var
		 = (AssignmentExpression)Expr_253_list.get(0);
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
		//269
		final Constant2 Constant2_270_Var
		 = (Constant2)PrimaryExpression_269_Var
		.getConst();
		Assert.assertNotNull(Constant2_270_Var
		);
		Assert.assertEquals("\"employee->name=%s\\n\"", Constant2_270_Var
		.getStr());
		//270
		final AssignmentExpression AssignmentExpression_271_Var
		 = (AssignmentExpression)Expr_253_list.get(1);
		Assert.assertNotNull(AssignmentExpression_271_Var
		);
		//271
		final ConditionalExpression ConditionalExpression_272_Var
		 = (ConditionalExpression)AssignmentExpression_271_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_272_Var
		);
		//272
		final LogicalOrExpression LogicalOrExpression_273_Var
		 = (LogicalOrExpression)ConditionalExpression_272_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_273_Var
		);
		final EList<? extends EObject> Expr_273_list = LogicalOrExpression_273_Var
		.getExpr();
		Assert.assertNotNull(Expr_273_list);
		Assert.assertEquals(1, Expr_273_list.size());
		//273
		final LogicalAndExpression LogicalAndExpression_274_Var
		 = (LogicalAndExpression)Expr_273_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_274_Var
		);
		final EList<? extends EObject> Expr_274_list = LogicalAndExpression_274_Var
		.getExpr();
		Assert.assertNotNull(Expr_274_list);
		Assert.assertEquals(1, Expr_274_list.size());
		//274
		final InclusiveOrExpression InclusiveOrExpression_275_Var
		 = (InclusiveOrExpression)Expr_274_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_275_Var
		);
		final EList<? extends EObject> Expr_275_list = InclusiveOrExpression_275_Var
		.getExpr();
		Assert.assertNotNull(Expr_275_list);
		Assert.assertEquals(1, Expr_275_list.size());
		//275
		final ExclusiveOrExpression ExclusiveOrExpression_276_Var
		 = (ExclusiveOrExpression)Expr_275_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_276_Var
		);
		final EList<? extends EObject> Expr_276_list = ExclusiveOrExpression_276_Var
		.getExpr();
		Assert.assertNotNull(Expr_276_list);
		Assert.assertEquals(1, Expr_276_list.size());
		//276
		final AndExpression AndExpression_277_Var
		 = (AndExpression)Expr_276_list.get(0);
		Assert.assertNotNull(AndExpression_277_Var
		);
		final EList<? extends EObject> Expr_277_list = AndExpression_277_Var
		.getExpr();
		Assert.assertNotNull(Expr_277_list);
		Assert.assertEquals(1, Expr_277_list.size());
		//277
		final EqualityExpression EqualityExpression_278_Var
		 = (EqualityExpression)Expr_277_list.get(0);
		Assert.assertNotNull(EqualityExpression_278_Var
		);
		final EList<? extends EObject> Expr_278_list = EqualityExpression_278_Var
		.getExpr();
		Assert.assertNotNull(Expr_278_list);
		Assert.assertEquals(1, Expr_278_list.size());
		//278
		final RelationalExpression RelationalExpression_279_Var
		 = (RelationalExpression)Expr_278_list.get(0);
		Assert.assertNotNull(RelationalExpression_279_Var
		);
		final EList<? extends EObject> Expr_279_list = RelationalExpression_279_Var
		.getExpr();
		Assert.assertNotNull(Expr_279_list);
		Assert.assertEquals(1, Expr_279_list.size());
		//279
		final ShiftExpression ShiftExpression_280_Var
		 = (ShiftExpression)Expr_279_list.get(0);
		Assert.assertNotNull(ShiftExpression_280_Var
		);
		final EList<? extends EObject> Expr_280_list = ShiftExpression_280_Var
		.getExpr();
		Assert.assertNotNull(Expr_280_list);
		Assert.assertEquals(1, Expr_280_list.size());
		//280
		final AdditiveExpression AdditiveExpression_281_Var
		 = (AdditiveExpression)Expr_280_list.get(0);
		Assert.assertNotNull(AdditiveExpression_281_Var
		);
		final EList<? extends EObject> Expr_281_list = AdditiveExpression_281_Var
		.getExpr();
		Assert.assertNotNull(Expr_281_list);
		Assert.assertEquals(1, Expr_281_list.size());
		//281
		final MultiplicativeExpression MultiplicativeExpression_282_Var
		 = (MultiplicativeExpression)Expr_281_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_282_Var
		);
		final EList<? extends EObject> Expr_282_list = MultiplicativeExpression_282_Var
		.getExpr();
		Assert.assertNotNull(Expr_282_list);
		Assert.assertEquals(1, Expr_282_list.size());
		//282
		final CastExpression CastExpression_283_Var
		 = (CastExpression)Expr_282_list.get(0);
		Assert.assertNotNull(CastExpression_283_Var
		);
		//283
		final UnaryExpression UnaryExpression_284_Var
		 = (UnaryExpression)CastExpression_283_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_284_Var
		);
		//284
		final PostfixExpression PostfixExpression_285_Var
		 = (PostfixExpression)UnaryExpression_284_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_285_Var
		);
		final EList<? extends EObject> Expr_285_list = PostfixExpression_285_Var
		.getExpr();
		Assert.assertNotNull(Expr_285_list);
		Assert.assertEquals(1, Expr_285_list.size());
		//285
		final PrimaryExpression PrimaryExpression_286_Var
		 = (PrimaryExpression)Expr_285_list.get(0);
		Assert.assertNotNull(PrimaryExpression_286_Var
		);
		Assert.assertEquals("emp", PrimaryExpression_286_Var
		.getId());
		final EList<? extends EObject> Suffix_286_list = PostfixExpression_285_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_286_list);
		Assert.assertEquals(1, Suffix_286_list.size());
		//286
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_287_Var
		 = (PostfixExpressionSuffixArrow)Suffix_286_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArrow_287_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixArrow_287_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_234_Var
		.getSemi());
		//287
		final ExternalDeclaration ExternalDeclaration_288_Var
		 = (ExternalDeclaration)External_0_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_288_Var
		);
		//288
		final FunctionDefHead FunctionDefHead_289_Var
		 = (FunctionDefHead)ExternalDeclaration_288_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_289_Var
		);
		//289
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_290_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_289_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_290_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_290_list = FunctionDeclarationSpecifiers_290_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_290_list);
		Assert.assertEquals(1, DeclarationSpecifier_290_list.size());
		//290
		final TypeSpecifier TypeSpecifier_291_Var
		 = (TypeSpecifier)DeclarationSpecifier_290_list.get(0);
		Assert.assertNotNull(TypeSpecifier_291_Var
		);
		Assert.assertEquals("int", TypeSpecifier_291_Var
		.getName());
		//291
		final Declarator Declarator_292_Var
		 = (Declarator)FunctionDefHead_289_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_292_Var
		);
		//292
		final DirectDeclarator DirectDeclarator_293_Var
		 = (DirectDeclarator)Declarator_292_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_293_Var
		);
		Assert.assertEquals("main", DirectDeclarator_293_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_293_list = DirectDeclarator_293_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_293_list);
		Assert.assertEquals(1, DeclaratorSuffix_293_list.size());
		//293
		final DeclaratorSuffix DeclaratorSuffix_294_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_293_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_294_Var
		);
		//294
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_295_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_294_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_295_Var
		);
		final EList<? extends EObject> ParameterTypeList_295_list = DirectDeclaratorLastSuffix_295_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_295_list);
		Assert.assertEquals(1, ParameterTypeList_295_list.size());
		//295
		final ParameterTypeList ParameterTypeList_296_Var
		 = (ParameterTypeList)ParameterTypeList_295_list.get(0);
		Assert.assertNotNull(ParameterTypeList_296_Var
		);
		//296
		final ParameterList ParameterList_297_Var
		 = (ParameterList)ParameterTypeList_296_Var
		.getList();
		Assert.assertNotNull(ParameterList_297_Var
		);
		final EList<? extends EObject> ParameterDeclaration_297_list = ParameterList_297_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_297_list);
		Assert.assertEquals(1, ParameterDeclaration_297_list.size());
		//297
		final ParameterDeclaration ParameterDeclaration_298_Var
		 = (ParameterDeclaration)ParameterDeclaration_297_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_298_Var
		);
		//298
		final DeclarationSpecifiers DeclarationSpecifiers_299_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_298_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_299_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_299_list = DeclarationSpecifiers_299_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_299_list);
		Assert.assertEquals(1, DeclarationSpecifier_299_list.size());
		//299
		final TypeSpecifier TypeSpecifier_300_Var
		 = (TypeSpecifier)DeclarationSpecifier_299_list.get(0);
		Assert.assertNotNull(TypeSpecifier_300_Var
		);
		Assert.assertEquals("void", TypeSpecifier_300_Var
		.getName());
		//300
		final FunctionDefinition FunctionDefinition_301_Var
		 = (FunctionDefinition)ExternalDeclaration_288_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_301_Var
		);
		//301
		final BodyStatement BodyStatement_302_Var
		 = (BodyStatement)FunctionDefinition_301_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_302_Var
		);
		final EList<? extends EObject> BlockList_302_list = BodyStatement_302_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_302_list);
		Assert.assertEquals(1, BlockList_302_list.size());
		//302
		final BlockList BlockList_303_Var
		 = (BlockList)BlockList_302_list.get(0);
		Assert.assertNotNull(BlockList_303_Var
		);
		final EList<? extends EObject> Declaration_303_list = BlockList_303_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_303_list);
		Assert.assertEquals(1, Declaration_303_list.size());
		//303
		final Declaration Declaration_304_Var
		 = (Declaration)Declaration_303_list.get(0);
		Assert.assertNotNull(Declaration_304_Var
		);
		//304
		final DeclarationSpecifiers DeclarationSpecifiers_305_Var
		 = (DeclarationSpecifiers)Declaration_304_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_305_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_305_list = DeclarationSpecifiers_305_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_305_list);
		Assert.assertEquals(1, DeclarationSpecifier_305_list.size());
		//305
		final TypeSpecifier TypeSpecifier_306_Var
		 = (TypeSpecifier)DeclarationSpecifier_305_list.get(0);
		Assert.assertNotNull(TypeSpecifier_306_Var
		);
		//306
		final TypedefName TypedefName_307_Var
		 = (TypedefName)TypeSpecifier_306_Var
		.getType();
		Assert.assertNotNull(TypedefName_307_Var
		);
		Assert.assertEquals("employee", TypedefName_307_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_307_list = Declaration_304_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_307_list);
		Assert.assertEquals(1, InitDeclaratorList_307_list.size());
		//307
		final InitDeclaratorList InitDeclaratorList_308_Var
		 = (InitDeclaratorList)InitDeclaratorList_307_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_308_Var
		);
		final EList<? extends EObject> InitDeclarator_308_list = InitDeclaratorList_308_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_308_list);
		Assert.assertEquals(1, InitDeclarator_308_list.size());
		//308
		final InitDeclarator InitDeclarator_309_Var
		 = (InitDeclarator)InitDeclarator_308_list.get(0);
		Assert.assertNotNull(InitDeclarator_309_Var
		);
		//309
		final Declarator Declarator_310_Var
		 = (Declarator)InitDeclarator_309_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_310_Var
		);
		//310
		final Pointer Pointer_311_Var
		 = (Pointer)Declarator_310_Var
		.getPointer();
		Assert.assertNotNull(Pointer_311_Var
		);
		Assert.assertEquals("[*]", Pointer_311_Var
		.getStar().toString());
		//311
		final DirectDeclarator DirectDeclarator_312_Var
		 = (DirectDeclarator)Declarator_310_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_312_Var
		);
		Assert.assertEquals("newEmployee", DirectDeclarator_312_Var
		.getId());
		//312
		final Initializer Initializer_313_Var
		 = (Initializer)InitDeclarator_309_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_313_Var
		);
		//313
		final AssignmentExpression AssignmentExpression_314_Var
		 = (AssignmentExpression)Initializer_313_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_314_Var
		);
		//314
		final ConditionalExpression ConditionalExpression_315_Var
		 = (ConditionalExpression)AssignmentExpression_314_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_315_Var
		);
		//315
		final LogicalOrExpression LogicalOrExpression_316_Var
		 = (LogicalOrExpression)ConditionalExpression_315_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_316_Var
		);
		final EList<? extends EObject> Expr_316_list = LogicalOrExpression_316_Var
		.getExpr();
		Assert.assertNotNull(Expr_316_list);
		Assert.assertEquals(1, Expr_316_list.size());
		//316
		final LogicalAndExpression LogicalAndExpression_317_Var
		 = (LogicalAndExpression)Expr_316_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_317_Var
		);
		final EList<? extends EObject> Expr_317_list = LogicalAndExpression_317_Var
		.getExpr();
		Assert.assertNotNull(Expr_317_list);
		Assert.assertEquals(1, Expr_317_list.size());
		//317
		final InclusiveOrExpression InclusiveOrExpression_318_Var
		 = (InclusiveOrExpression)Expr_317_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_318_Var
		);
		final EList<? extends EObject> Expr_318_list = InclusiveOrExpression_318_Var
		.getExpr();
		Assert.assertNotNull(Expr_318_list);
		Assert.assertEquals(1, Expr_318_list.size());
		//318
		final ExclusiveOrExpression ExclusiveOrExpression_319_Var
		 = (ExclusiveOrExpression)Expr_318_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_319_Var
		);
		final EList<? extends EObject> Expr_319_list = ExclusiveOrExpression_319_Var
		.getExpr();
		Assert.assertNotNull(Expr_319_list);
		Assert.assertEquals(1, Expr_319_list.size());
		//319
		final AndExpression AndExpression_320_Var
		 = (AndExpression)Expr_319_list.get(0);
		Assert.assertNotNull(AndExpression_320_Var
		);
		final EList<? extends EObject> Expr_320_list = AndExpression_320_Var
		.getExpr();
		Assert.assertNotNull(Expr_320_list);
		Assert.assertEquals(1, Expr_320_list.size());
		//320
		final EqualityExpression EqualityExpression_321_Var
		 = (EqualityExpression)Expr_320_list.get(0);
		Assert.assertNotNull(EqualityExpression_321_Var
		);
		final EList<? extends EObject> Expr_321_list = EqualityExpression_321_Var
		.getExpr();
		Assert.assertNotNull(Expr_321_list);
		Assert.assertEquals(1, Expr_321_list.size());
		//321
		final RelationalExpression RelationalExpression_322_Var
		 = (RelationalExpression)Expr_321_list.get(0);
		Assert.assertNotNull(RelationalExpression_322_Var
		);
		final EList<? extends EObject> Expr_322_list = RelationalExpression_322_Var
		.getExpr();
		Assert.assertNotNull(Expr_322_list);
		Assert.assertEquals(1, Expr_322_list.size());
		//322
		final ShiftExpression ShiftExpression_323_Var
		 = (ShiftExpression)Expr_322_list.get(0);
		Assert.assertNotNull(ShiftExpression_323_Var
		);
		final EList<? extends EObject> Expr_323_list = ShiftExpression_323_Var
		.getExpr();
		Assert.assertNotNull(Expr_323_list);
		Assert.assertEquals(1, Expr_323_list.size());
		//323
		final AdditiveExpression AdditiveExpression_324_Var
		 = (AdditiveExpression)Expr_323_list.get(0);
		Assert.assertNotNull(AdditiveExpression_324_Var
		);
		final EList<? extends EObject> Expr_324_list = AdditiveExpression_324_Var
		.getExpr();
		Assert.assertNotNull(Expr_324_list);
		Assert.assertEquals(1, Expr_324_list.size());
		//324
		final MultiplicativeExpression MultiplicativeExpression_325_Var
		 = (MultiplicativeExpression)Expr_324_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_325_Var
		);
		final EList<? extends EObject> Expr_325_list = MultiplicativeExpression_325_Var
		.getExpr();
		Assert.assertNotNull(Expr_325_list);
		Assert.assertEquals(1, Expr_325_list.size());
		//325
		final CastExpression CastExpression_326_Var
		 = (CastExpression)Expr_325_list.get(0);
		Assert.assertNotNull(CastExpression_326_Var
		);
		//326
		final UnaryExpression UnaryExpression_327_Var
		 = (UnaryExpression)CastExpression_326_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_327_Var
		);
		//327
		final PostfixExpression PostfixExpression_328_Var
		 = (PostfixExpression)UnaryExpression_327_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_328_Var
		);
		final EList<? extends EObject> Expr_328_list = PostfixExpression_328_Var
		.getExpr();
		Assert.assertNotNull(Expr_328_list);
		Assert.assertEquals(1, Expr_328_list.size());
		//328
		final PrimaryExpression PrimaryExpression_329_Var
		 = (PrimaryExpression)Expr_328_list.get(0);
		Assert.assertNotNull(PrimaryExpression_329_Var
		);
		Assert.assertEquals("malloc", PrimaryExpression_329_Var
		.getId());
		final EList<? extends EObject> Suffix_329_list = PostfixExpression_328_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_329_list);
		Assert.assertEquals(1, Suffix_329_list.size());
		//329
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_330_Var
		 = (PostfixExpressionSuffixArgument)Suffix_329_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_330_Var
		);
		//330
		final ArgumentExpressionList ArgumentExpressionList_331_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_330_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_331_Var
		);
		final EList<? extends EObject> Expr_331_list = ArgumentExpressionList_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final AssignmentExpression AssignmentExpression_332_Var
		 = (AssignmentExpression)Expr_331_list.get(0);
		Assert.assertNotNull(AssignmentExpression_332_Var
		);
		//332
		final ConditionalExpression ConditionalExpression_333_Var
		 = (ConditionalExpression)AssignmentExpression_332_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_333_Var
		);
		//333
		final LogicalOrExpression LogicalOrExpression_334_Var
		 = (LogicalOrExpression)ConditionalExpression_333_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = LogicalOrExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final LogicalAndExpression LogicalAndExpression_335_Var
		 = (LogicalAndExpression)Expr_334_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = LogicalAndExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final InclusiveOrExpression InclusiveOrExpression_336_Var
		 = (InclusiveOrExpression)Expr_335_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = InclusiveOrExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final ExclusiveOrExpression ExclusiveOrExpression_337_Var
		 = (ExclusiveOrExpression)Expr_336_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_337_Var
		);
		final EList<? extends EObject> Expr_337_list = ExclusiveOrExpression_337_Var
		.getExpr();
		Assert.assertNotNull(Expr_337_list);
		Assert.assertEquals(1, Expr_337_list.size());
		//337
		final AndExpression AndExpression_338_Var
		 = (AndExpression)Expr_337_list.get(0);
		Assert.assertNotNull(AndExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = AndExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final EqualityExpression EqualityExpression_339_Var
		 = (EqualityExpression)Expr_338_list.get(0);
		Assert.assertNotNull(EqualityExpression_339_Var
		);
		final EList<? extends EObject> Expr_339_list = EqualityExpression_339_Var
		.getExpr();
		Assert.assertNotNull(Expr_339_list);
		Assert.assertEquals(1, Expr_339_list.size());
		//339
		final RelationalExpression RelationalExpression_340_Var
		 = (RelationalExpression)Expr_339_list.get(0);
		Assert.assertNotNull(RelationalExpression_340_Var
		);
		final EList<? extends EObject> Expr_340_list = RelationalExpression_340_Var
		.getExpr();
		Assert.assertNotNull(Expr_340_list);
		Assert.assertEquals(1, Expr_340_list.size());
		//340
		final ShiftExpression ShiftExpression_341_Var
		 = (ShiftExpression)Expr_340_list.get(0);
		Assert.assertNotNull(ShiftExpression_341_Var
		);
		final EList<? extends EObject> Expr_341_list = ShiftExpression_341_Var
		.getExpr();
		Assert.assertNotNull(Expr_341_list);
		Assert.assertEquals(1, Expr_341_list.size());
		//341
		final AdditiveExpression AdditiveExpression_342_Var
		 = (AdditiveExpression)Expr_341_list.get(0);
		Assert.assertNotNull(AdditiveExpression_342_Var
		);
		final EList<? extends EObject> Expr_342_list = AdditiveExpression_342_Var
		.getExpr();
		Assert.assertNotNull(Expr_342_list);
		Assert.assertEquals(1, Expr_342_list.size());
		//342
		final MultiplicativeExpression MultiplicativeExpression_343_Var
		 = (MultiplicativeExpression)Expr_342_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_343_Var
		);
		final EList<? extends EObject> Expr_343_list = MultiplicativeExpression_343_Var
		.getExpr();
		Assert.assertNotNull(Expr_343_list);
		Assert.assertEquals(1, Expr_343_list.size());
		//343
		final CastExpression CastExpression_344_Var
		 = (CastExpression)Expr_343_list.get(0);
		Assert.assertNotNull(CastExpression_344_Var
		);
		//344
		final UnaryExpression UnaryExpression_345_Var
		 = (UnaryExpression)CastExpression_344_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_345_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_345_Var
		.getSizeOf());
		//345
		final TypeName TypeName_346_Var
		 = (TypeName)UnaryExpression_345_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_346_Var
		);
		//346
		final SpecifierQualifierList SpecifierQualifierList_347_Var
		 = (SpecifierQualifierList)TypeName_346_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_347_Var
		);
		final EList<? extends EObject> TypeSpecifier_347_list = SpecifierQualifierList_347_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_347_list);
		Assert.assertEquals(1, TypeSpecifier_347_list.size());
		//347
		final TypeSpecifier TypeSpecifier_348_Var
		 = (TypeSpecifier)TypeSpecifier_347_list.get(0);
		Assert.assertNotNull(TypeSpecifier_348_Var
		);
		//348
		final TypedefName TypedefName_349_Var
		 = (TypedefName)TypeSpecifier_348_Var
		.getType();
		Assert.assertNotNull(TypedefName_349_Var
		);
		Assert.assertEquals("employee", TypedefName_349_Var
		.getId());
		final EList<? extends EObject> Statement_349_list = BlockList_303_Var
		.getStatement();
		Assert.assertNotNull(Statement_349_list);
		Assert.assertEquals(8, Statement_349_list.size());
		//349
		final Statement Statement_350_Var
		 = (Statement)Statement_349_list.get(0);
		Assert.assertNotNull(Statement_350_Var
		);
		//350
		final SelectionStatement SelectionStatement_351_Var
		 = (SelectionStatement)Statement_350_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_351_Var
		);
		Assert.assertEquals("if", SelectionStatement_351_Var
		.getIf());
		//351
		final Expression Expression_352_Var
		 = (Expression)SelectionStatement_351_Var
		.getExpr();
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
		Assert.assertEquals("[==]", EqualityExpression_360_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_360_list = EqualityExpression_360_Var
		.getExpr();
		Assert.assertNotNull(Expr_360_list);
		Assert.assertEquals(2, Expr_360_list.size());
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
		Assert.assertEquals("newEmployee", PrimaryExpression_368_Var
		.getId());
		//368
		final RelationalExpression RelationalExpression_369_Var
		 = (RelationalExpression)Expr_360_list.get(1);
		Assert.assertNotNull(RelationalExpression_369_Var
		);
		final EList<? extends EObject> Expr_369_list = RelationalExpression_369_Var
		.getExpr();
		Assert.assertNotNull(Expr_369_list);
		Assert.assertEquals(1, Expr_369_list.size());
		//369
		final ShiftExpression ShiftExpression_370_Var
		 = (ShiftExpression)Expr_369_list.get(0);
		Assert.assertNotNull(ShiftExpression_370_Var
		);
		final EList<? extends EObject> Expr_370_list = ShiftExpression_370_Var
		.getExpr();
		Assert.assertNotNull(Expr_370_list);
		Assert.assertEquals(1, Expr_370_list.size());
		//370
		final AdditiveExpression AdditiveExpression_371_Var
		 = (AdditiveExpression)Expr_370_list.get(0);
		Assert.assertNotNull(AdditiveExpression_371_Var
		);
		final EList<? extends EObject> Expr_371_list = AdditiveExpression_371_Var
		.getExpr();
		Assert.assertNotNull(Expr_371_list);
		Assert.assertEquals(1, Expr_371_list.size());
		//371
		final MultiplicativeExpression MultiplicativeExpression_372_Var
		 = (MultiplicativeExpression)Expr_371_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_372_Var
		);
		final EList<? extends EObject> Expr_372_list = MultiplicativeExpression_372_Var
		.getExpr();
		Assert.assertNotNull(Expr_372_list);
		Assert.assertEquals(1, Expr_372_list.size());
		//372
		final CastExpression CastExpression_373_Var
		 = (CastExpression)Expr_372_list.get(0);
		Assert.assertNotNull(CastExpression_373_Var
		);
		//373
		final UnaryExpression UnaryExpression_374_Var
		 = (UnaryExpression)CastExpression_373_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_374_Var
		);
		//374
		final PostfixExpression PostfixExpression_375_Var
		 = (PostfixExpression)UnaryExpression_374_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_375_Var
		);
		final EList<? extends EObject> Expr_375_list = PostfixExpression_375_Var
		.getExpr();
		Assert.assertNotNull(Expr_375_list);
		Assert.assertEquals(1, Expr_375_list.size());
		//375
		final PrimaryExpression PrimaryExpression_376_Var
		 = (PrimaryExpression)Expr_375_list.get(0);
		Assert.assertNotNull(PrimaryExpression_376_Var
		);
		Assert.assertEquals("NULL", PrimaryExpression_376_Var
		.getId());
		//376
		final Statement Statement_377_Var
		 = (Statement)SelectionStatement_351_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_377_Var
		);
		//377
		final CompoundStatement CompoundStatement_378_Var
		 = (CompoundStatement)Statement_377_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_378_Var
		);
		//378
		final BodyStatement BodyStatement_379_Var
		 = (BodyStatement)CompoundStatement_378_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_379_Var
		);
		final EList<? extends EObject> BlockList_379_list = BodyStatement_379_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_379_list);
		Assert.assertEquals(1, BlockList_379_list.size());
		//379
		final BlockList BlockList_380_Var
		 = (BlockList)BlockList_379_list.get(0);
		Assert.assertNotNull(BlockList_380_Var
		);
		final EList<? extends EObject> Statement_380_list = BlockList_380_Var
		.getStatement();
		Assert.assertNotNull(Statement_380_list);
		Assert.assertEquals(2, Statement_380_list.size());
		//380
		final Statement Statement_381_Var
		 = (Statement)Statement_380_list.get(0);
		Assert.assertNotNull(Statement_381_Var
		);
		//381
		final ExpressionStatement ExpressionStatement_382_Var
		 = (ExpressionStatement)Statement_381_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_382_Var
		);
		//382
		final Expression Expression_383_Var
		 = (Expression)ExpressionStatement_382_Var
		.getExpression();
		Assert.assertNotNull(Expression_383_Var
		);
		final EList<? extends EObject> ExprExpr_383_list = Expression_383_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_383_list);
		Assert.assertEquals(1, ExprExpr_383_list.size());
		//383
		final AssignmentExpression AssignmentExpression_384_Var
		 = (AssignmentExpression)ExprExpr_383_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_399_Var
		.getId());
		final EList<? extends EObject> Suffix_399_list = PostfixExpression_398_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_399_list);
		Assert.assertEquals(1, Suffix_399_list.size());
		//399
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_400_Var
		 = (PostfixExpressionSuffixArgument)Suffix_399_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_400_Var
		);
		//400
		final ArgumentExpressionList ArgumentExpressionList_401_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_400_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_401_Var
		);
		final EList<? extends EObject> Expr_401_list = ArgumentExpressionList_401_Var
		.getExpr();
		Assert.assertNotNull(Expr_401_list);
		Assert.assertEquals(1, Expr_401_list.size());
		//401
		final AssignmentExpression AssignmentExpression_402_Var
		 = (AssignmentExpression)Expr_401_list.get(0);
		Assert.assertNotNull(AssignmentExpression_402_Var
		);
		//402
		final ConditionalExpression ConditionalExpression_403_Var
		 = (ConditionalExpression)AssignmentExpression_402_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_403_Var
		);
		//403
		final LogicalOrExpression LogicalOrExpression_404_Var
		 = (LogicalOrExpression)ConditionalExpression_403_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_404_Var
		);
		final EList<? extends EObject> Expr_404_list = LogicalOrExpression_404_Var
		.getExpr();
		Assert.assertNotNull(Expr_404_list);
		Assert.assertEquals(1, Expr_404_list.size());
		//404
		final LogicalAndExpression LogicalAndExpression_405_Var
		 = (LogicalAndExpression)Expr_404_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_405_Var
		);
		final EList<? extends EObject> Expr_405_list = LogicalAndExpression_405_Var
		.getExpr();
		Assert.assertNotNull(Expr_405_list);
		Assert.assertEquals(1, Expr_405_list.size());
		//405
		final InclusiveOrExpression InclusiveOrExpression_406_Var
		 = (InclusiveOrExpression)Expr_405_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_406_Var
		);
		final EList<? extends EObject> Expr_406_list = InclusiveOrExpression_406_Var
		.getExpr();
		Assert.assertNotNull(Expr_406_list);
		Assert.assertEquals(1, Expr_406_list.size());
		//406
		final ExclusiveOrExpression ExclusiveOrExpression_407_Var
		 = (ExclusiveOrExpression)Expr_406_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_407_Var
		);
		final EList<? extends EObject> Expr_407_list = ExclusiveOrExpression_407_Var
		.getExpr();
		Assert.assertNotNull(Expr_407_list);
		Assert.assertEquals(1, Expr_407_list.size());
		//407
		final AndExpression AndExpression_408_Var
		 = (AndExpression)Expr_407_list.get(0);
		Assert.assertNotNull(AndExpression_408_Var
		);
		final EList<? extends EObject> Expr_408_list = AndExpression_408_Var
		.getExpr();
		Assert.assertNotNull(Expr_408_list);
		Assert.assertEquals(1, Expr_408_list.size());
		//408
		final EqualityExpression EqualityExpression_409_Var
		 = (EqualityExpression)Expr_408_list.get(0);
		Assert.assertNotNull(EqualityExpression_409_Var
		);
		final EList<? extends EObject> Expr_409_list = EqualityExpression_409_Var
		.getExpr();
		Assert.assertNotNull(Expr_409_list);
		Assert.assertEquals(1, Expr_409_list.size());
		//409
		final RelationalExpression RelationalExpression_410_Var
		 = (RelationalExpression)Expr_409_list.get(0);
		Assert.assertNotNull(RelationalExpression_410_Var
		);
		final EList<? extends EObject> Expr_410_list = RelationalExpression_410_Var
		.getExpr();
		Assert.assertNotNull(Expr_410_list);
		Assert.assertEquals(1, Expr_410_list.size());
		//410
		final ShiftExpression ShiftExpression_411_Var
		 = (ShiftExpression)Expr_410_list.get(0);
		Assert.assertNotNull(ShiftExpression_411_Var
		);
		final EList<? extends EObject> Expr_411_list = ShiftExpression_411_Var
		.getExpr();
		Assert.assertNotNull(Expr_411_list);
		Assert.assertEquals(1, Expr_411_list.size());
		//411
		final AdditiveExpression AdditiveExpression_412_Var
		 = (AdditiveExpression)Expr_411_list.get(0);
		Assert.assertNotNull(AdditiveExpression_412_Var
		);
		final EList<? extends EObject> Expr_412_list = AdditiveExpression_412_Var
		.getExpr();
		Assert.assertNotNull(Expr_412_list);
		Assert.assertEquals(1, Expr_412_list.size());
		//412
		final MultiplicativeExpression MultiplicativeExpression_413_Var
		 = (MultiplicativeExpression)Expr_412_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_413_Var
		);
		final EList<? extends EObject> Expr_413_list = MultiplicativeExpression_413_Var
		.getExpr();
		Assert.assertNotNull(Expr_413_list);
		Assert.assertEquals(1, Expr_413_list.size());
		//413
		final CastExpression CastExpression_414_Var
		 = (CastExpression)Expr_413_list.get(0);
		Assert.assertNotNull(CastExpression_414_Var
		);
		//414
		final UnaryExpression UnaryExpression_415_Var
		 = (UnaryExpression)CastExpression_414_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_415_Var
		);
		//415
		final PostfixExpression PostfixExpression_416_Var
		 = (PostfixExpression)UnaryExpression_415_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_416_Var
		);
		final EList<? extends EObject> Expr_416_list = PostfixExpression_416_Var
		.getExpr();
		Assert.assertNotNull(Expr_416_list);
		Assert.assertEquals(1, Expr_416_list.size());
		//416
		final PrimaryExpression PrimaryExpression_417_Var
		 = (PrimaryExpression)Expr_416_list.get(0);
		Assert.assertNotNull(PrimaryExpression_417_Var
		);
		//417
		final Constant2 Constant2_418_Var
		 = (Constant2)PrimaryExpression_417_Var
		.getConst();
		Assert.assertNotNull(Constant2_418_Var
		);
		Assert.assertEquals("\"Could not reserve space for new employee!\\n\"", Constant2_418_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_382_Var
		.getSemi());
		//418
		final Statement Statement_419_Var
		 = (Statement)Statement_380_list.get(1);
		Assert.assertNotNull(Statement_419_Var
		);
		//419
		final JumpStatement JumpStatement_420_Var
		 = (JumpStatement)Statement_419_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_420_Var
		);
		//420
		final Expression Expression_421_Var
		 = (Expression)JumpStatement_420_Var
		.getExpr();
		Assert.assertNotNull(Expression_421_Var
		);
		final EList<? extends EObject> ExprExpr_421_list = Expression_421_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_421_list);
		Assert.assertEquals(1, ExprExpr_421_list.size());
		//421
		final AssignmentExpression AssignmentExpression_422_Var
		 = (AssignmentExpression)ExprExpr_421_list.get(0);
		Assert.assertNotNull(AssignmentExpression_422_Var
		);
		//422
		final ConditionalExpression ConditionalExpression_423_Var
		 = (ConditionalExpression)AssignmentExpression_422_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_423_Var
		);
		//423
		final LogicalOrExpression LogicalOrExpression_424_Var
		 = (LogicalOrExpression)ConditionalExpression_423_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_424_Var
		);
		final EList<? extends EObject> Expr_424_list = LogicalOrExpression_424_Var
		.getExpr();
		Assert.assertNotNull(Expr_424_list);
		Assert.assertEquals(1, Expr_424_list.size());
		//424
		final LogicalAndExpression LogicalAndExpression_425_Var
		 = (LogicalAndExpression)Expr_424_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_425_Var
		);
		final EList<? extends EObject> Expr_425_list = LogicalAndExpression_425_Var
		.getExpr();
		Assert.assertNotNull(Expr_425_list);
		Assert.assertEquals(1, Expr_425_list.size());
		//425
		final InclusiveOrExpression InclusiveOrExpression_426_Var
		 = (InclusiveOrExpression)Expr_425_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_426_Var
		);
		final EList<? extends EObject> Expr_426_list = InclusiveOrExpression_426_Var
		.getExpr();
		Assert.assertNotNull(Expr_426_list);
		Assert.assertEquals(1, Expr_426_list.size());
		//426
		final ExclusiveOrExpression ExclusiveOrExpression_427_Var
		 = (ExclusiveOrExpression)Expr_426_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_427_Var
		);
		final EList<? extends EObject> Expr_427_list = ExclusiveOrExpression_427_Var
		.getExpr();
		Assert.assertNotNull(Expr_427_list);
		Assert.assertEquals(1, Expr_427_list.size());
		//427
		final AndExpression AndExpression_428_Var
		 = (AndExpression)Expr_427_list.get(0);
		Assert.assertNotNull(AndExpression_428_Var
		);
		final EList<? extends EObject> Expr_428_list = AndExpression_428_Var
		.getExpr();
		Assert.assertNotNull(Expr_428_list);
		Assert.assertEquals(1, Expr_428_list.size());
		//428
		final EqualityExpression EqualityExpression_429_Var
		 = (EqualityExpression)Expr_428_list.get(0);
		Assert.assertNotNull(EqualityExpression_429_Var
		);
		final EList<? extends EObject> Expr_429_list = EqualityExpression_429_Var
		.getExpr();
		Assert.assertNotNull(Expr_429_list);
		Assert.assertEquals(1, Expr_429_list.size());
		//429
		final RelationalExpression RelationalExpression_430_Var
		 = (RelationalExpression)Expr_429_list.get(0);
		Assert.assertNotNull(RelationalExpression_430_Var
		);
		final EList<? extends EObject> Expr_430_list = RelationalExpression_430_Var
		.getExpr();
		Assert.assertNotNull(Expr_430_list);
		Assert.assertEquals(1, Expr_430_list.size());
		//430
		final ShiftExpression ShiftExpression_431_Var
		 = (ShiftExpression)Expr_430_list.get(0);
		Assert.assertNotNull(ShiftExpression_431_Var
		);
		final EList<? extends EObject> Expr_431_list = ShiftExpression_431_Var
		.getExpr();
		Assert.assertNotNull(Expr_431_list);
		Assert.assertEquals(1, Expr_431_list.size());
		//431
		final AdditiveExpression AdditiveExpression_432_Var
		 = (AdditiveExpression)Expr_431_list.get(0);
		Assert.assertNotNull(AdditiveExpression_432_Var
		);
		final EList<? extends EObject> Expr_432_list = AdditiveExpression_432_Var
		.getExpr();
		Assert.assertNotNull(Expr_432_list);
		Assert.assertEquals(1, Expr_432_list.size());
		//432
		final MultiplicativeExpression MultiplicativeExpression_433_Var
		 = (MultiplicativeExpression)Expr_432_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_433_Var
		);
		final EList<? extends EObject> Expr_433_list = MultiplicativeExpression_433_Var
		.getExpr();
		Assert.assertNotNull(Expr_433_list);
		Assert.assertEquals(1, Expr_433_list.size());
		//433
		final CastExpression CastExpression_434_Var
		 = (CastExpression)Expr_433_list.get(0);
		Assert.assertNotNull(CastExpression_434_Var
		);
		//434
		final UnaryExpression UnaryExpression_435_Var
		 = (UnaryExpression)CastExpression_434_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_435_Var
		);
		//435
		final UnaryOperator UnaryOperator_436_Var
		 = (UnaryOperator)UnaryExpression_435_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_436_Var
		);
		Assert.assertEquals("-", UnaryOperator_436_Var
		.getOp());
		//436
		final CastExpression CastExpression_437_Var
		 = (CastExpression)UnaryExpression_435_Var
		.getExpr();
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
		//440
		final Constant2 Constant2_441_Var
		 = (Constant2)PrimaryExpression_440_Var
		.getConst();
		Assert.assertNotNull(Constant2_441_Var
		);
		Assert.assertEquals("1", Constant2_441_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_420_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_420_Var
		.getSemi());
		//441
		final Statement Statement_442_Var
		 = (Statement)Statement_349_list.get(1);
		Assert.assertNotNull(Statement_442_Var
		);
		//442
		final ExpressionStatement ExpressionStatement_443_Var
		 = (ExpressionStatement)Statement_442_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_443_Var
		);
		//443
		final Expression Expression_444_Var
		 = (Expression)ExpressionStatement_443_Var
		.getExpression();
		Assert.assertNotNull(Expression_444_Var
		);
		final EList<? extends EObject> ExprExpr_444_list = Expression_444_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_444_list);
		Assert.assertEquals(1, ExprExpr_444_list.size());
		//444
		final AssignmentExpression AssignmentExpression_445_Var
		 = (AssignmentExpression)ExprExpr_444_list.get(0);
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
		Assert.assertEquals("print", PrimaryExpression_460_Var
		.getId());
		final EList<? extends EObject> Suffix_460_list = PostfixExpression_459_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_460_list);
		Assert.assertEquals(1, Suffix_460_list.size());
		//460
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_461_Var
		 = (PostfixExpressionSuffixArgument)Suffix_460_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_461_Var
		);
		//461
		final ArgumentExpressionList ArgumentExpressionList_462_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_461_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_462_Var
		);
		final EList<? extends EObject> Expr_462_list = ArgumentExpressionList_462_Var
		.getExpr();
		Assert.assertNotNull(Expr_462_list);
		Assert.assertEquals(1, Expr_462_list.size());
		//462
		final AssignmentExpression AssignmentExpression_463_Var
		 = (AssignmentExpression)Expr_462_list.get(0);
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
		final UnaryOperator UnaryOperator_477_Var
		 = (UnaryOperator)UnaryExpression_476_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_477_Var
		);
		Assert.assertEquals("&", UnaryOperator_477_Var
		.getOp());
		//477
		final CastExpression CastExpression_478_Var
		 = (CastExpression)UnaryExpression_476_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_478_Var
		);
		//478
		final UnaryExpression UnaryExpression_479_Var
		 = (UnaryExpression)CastExpression_478_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_479_Var
		);
		//479
		final PostfixExpression PostfixExpression_480_Var
		 = (PostfixExpression)UnaryExpression_479_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_480_Var
		);
		final EList<? extends EObject> Expr_480_list = PostfixExpression_480_Var
		.getExpr();
		Assert.assertNotNull(Expr_480_list);
		Assert.assertEquals(1, Expr_480_list.size());
		//480
		final PrimaryExpression PrimaryExpression_481_Var
		 = (PrimaryExpression)Expr_480_list.get(0);
		Assert.assertNotNull(PrimaryExpression_481_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_481_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_443_Var
		.getSemi());
		//481
		final Statement Statement_482_Var
		 = (Statement)Statement_349_list.get(2);
		Assert.assertNotNull(Statement_482_Var
		);
		//482
		final ExpressionStatement ExpressionStatement_483_Var
		 = (ExpressionStatement)Statement_482_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_483_Var
		);
		//483
		final Expression Expression_484_Var
		 = (Expression)ExpressionStatement_483_Var
		.getExpression();
		Assert.assertNotNull(Expression_484_Var
		);
		final EList<? extends EObject> ExprExpr_484_list = Expression_484_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_484_list);
		Assert.assertEquals(1, ExprExpr_484_list.size());
		//484
		final AssignmentExpression AssignmentExpression_485_Var
		 = (AssignmentExpression)ExprExpr_484_list.get(0);
		Assert.assertNotNull(AssignmentExpression_485_Var
		);
		//485
		final ConditionalExpression ConditionalExpression_486_Var
		 = (ConditionalExpression)AssignmentExpression_485_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_486_Var
		);
		//486
		final LogicalOrExpression LogicalOrExpression_487_Var
		 = (LogicalOrExpression)ConditionalExpression_486_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_487_Var
		);
		final EList<? extends EObject> Expr_487_list = LogicalOrExpression_487_Var
		.getExpr();
		Assert.assertNotNull(Expr_487_list);
		Assert.assertEquals(1, Expr_487_list.size());
		//487
		final LogicalAndExpression LogicalAndExpression_488_Var
		 = (LogicalAndExpression)Expr_487_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_488_Var
		);
		final EList<? extends EObject> Expr_488_list = LogicalAndExpression_488_Var
		.getExpr();
		Assert.assertNotNull(Expr_488_list);
		Assert.assertEquals(1, Expr_488_list.size());
		//488
		final InclusiveOrExpression InclusiveOrExpression_489_Var
		 = (InclusiveOrExpression)Expr_488_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_489_Var
		);
		final EList<? extends EObject> Expr_489_list = InclusiveOrExpression_489_Var
		.getExpr();
		Assert.assertNotNull(Expr_489_list);
		Assert.assertEquals(1, Expr_489_list.size());
		//489
		final ExclusiveOrExpression ExclusiveOrExpression_490_Var
		 = (ExclusiveOrExpression)Expr_489_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_490_Var
		);
		final EList<? extends EObject> Expr_490_list = ExclusiveOrExpression_490_Var
		.getExpr();
		Assert.assertNotNull(Expr_490_list);
		Assert.assertEquals(1, Expr_490_list.size());
		//490
		final AndExpression AndExpression_491_Var
		 = (AndExpression)Expr_490_list.get(0);
		Assert.assertNotNull(AndExpression_491_Var
		);
		final EList<? extends EObject> Expr_491_list = AndExpression_491_Var
		.getExpr();
		Assert.assertNotNull(Expr_491_list);
		Assert.assertEquals(1, Expr_491_list.size());
		//491
		final EqualityExpression EqualityExpression_492_Var
		 = (EqualityExpression)Expr_491_list.get(0);
		Assert.assertNotNull(EqualityExpression_492_Var
		);
		final EList<? extends EObject> Expr_492_list = EqualityExpression_492_Var
		.getExpr();
		Assert.assertNotNull(Expr_492_list);
		Assert.assertEquals(1, Expr_492_list.size());
		//492
		final RelationalExpression RelationalExpression_493_Var
		 = (RelationalExpression)Expr_492_list.get(0);
		Assert.assertNotNull(RelationalExpression_493_Var
		);
		final EList<? extends EObject> Expr_493_list = RelationalExpression_493_Var
		.getExpr();
		Assert.assertNotNull(Expr_493_list);
		Assert.assertEquals(1, Expr_493_list.size());
		//493
		final ShiftExpression ShiftExpression_494_Var
		 = (ShiftExpression)Expr_493_list.get(0);
		Assert.assertNotNull(ShiftExpression_494_Var
		);
		final EList<? extends EObject> Expr_494_list = ShiftExpression_494_Var
		.getExpr();
		Assert.assertNotNull(Expr_494_list);
		Assert.assertEquals(1, Expr_494_list.size());
		//494
		final AdditiveExpression AdditiveExpression_495_Var
		 = (AdditiveExpression)Expr_494_list.get(0);
		Assert.assertNotNull(AdditiveExpression_495_Var
		);
		final EList<? extends EObject> Expr_495_list = AdditiveExpression_495_Var
		.getExpr();
		Assert.assertNotNull(Expr_495_list);
		Assert.assertEquals(1, Expr_495_list.size());
		//495
		final MultiplicativeExpression MultiplicativeExpression_496_Var
		 = (MultiplicativeExpression)Expr_495_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_496_Var
		);
		final EList<? extends EObject> Expr_496_list = MultiplicativeExpression_496_Var
		.getExpr();
		Assert.assertNotNull(Expr_496_list);
		Assert.assertEquals(1, Expr_496_list.size());
		//496
		final CastExpression CastExpression_497_Var
		 = (CastExpression)Expr_496_list.get(0);
		Assert.assertNotNull(CastExpression_497_Var
		);
		//497
		final UnaryExpression UnaryExpression_498_Var
		 = (UnaryExpression)CastExpression_497_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_498_Var
		);
		//498
		final PostfixExpression PostfixExpression_499_Var
		 = (PostfixExpression)UnaryExpression_498_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_499_Var
		);
		final EList<? extends EObject> Expr_499_list = PostfixExpression_499_Var
		.getExpr();
		Assert.assertNotNull(Expr_499_list);
		Assert.assertEquals(1, Expr_499_list.size());
		//499
		final PrimaryExpression PrimaryExpression_500_Var
		 = (PrimaryExpression)Expr_499_list.get(0);
		Assert.assertNotNull(PrimaryExpression_500_Var
		);
		Assert.assertEquals("print", PrimaryExpression_500_Var
		.getId());
		final EList<? extends EObject> Suffix_500_list = PostfixExpression_499_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_500_list);
		Assert.assertEquals(1, Suffix_500_list.size());
		//500
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_501_Var
		 = (PostfixExpressionSuffixArgument)Suffix_500_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_501_Var
		);
		//501
		final ArgumentExpressionList ArgumentExpressionList_502_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_501_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_502_Var
		);
		final EList<? extends EObject> Expr_502_list = ArgumentExpressionList_502_Var
		.getExpr();
		Assert.assertNotNull(Expr_502_list);
		Assert.assertEquals(1, Expr_502_list.size());
		//502
		final AssignmentExpression AssignmentExpression_503_Var
		 = (AssignmentExpression)Expr_502_list.get(0);
		Assert.assertNotNull(AssignmentExpression_503_Var
		);
		//503
		final ConditionalExpression ConditionalExpression_504_Var
		 = (ConditionalExpression)AssignmentExpression_503_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_504_Var
		);
		//504
		final LogicalOrExpression LogicalOrExpression_505_Var
		 = (LogicalOrExpression)ConditionalExpression_504_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_505_Var
		);
		final EList<? extends EObject> Expr_505_list = LogicalOrExpression_505_Var
		.getExpr();
		Assert.assertNotNull(Expr_505_list);
		Assert.assertEquals(1, Expr_505_list.size());
		//505
		final LogicalAndExpression LogicalAndExpression_506_Var
		 = (LogicalAndExpression)Expr_505_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_506_Var
		);
		final EList<? extends EObject> Expr_506_list = LogicalAndExpression_506_Var
		.getExpr();
		Assert.assertNotNull(Expr_506_list);
		Assert.assertEquals(1, Expr_506_list.size());
		//506
		final InclusiveOrExpression InclusiveOrExpression_507_Var
		 = (InclusiveOrExpression)Expr_506_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_507_Var
		);
		final EList<? extends EObject> Expr_507_list = InclusiveOrExpression_507_Var
		.getExpr();
		Assert.assertNotNull(Expr_507_list);
		Assert.assertEquals(1, Expr_507_list.size());
		//507
		final ExclusiveOrExpression ExclusiveOrExpression_508_Var
		 = (ExclusiveOrExpression)Expr_507_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_508_Var
		);
		final EList<? extends EObject> Expr_508_list = ExclusiveOrExpression_508_Var
		.getExpr();
		Assert.assertNotNull(Expr_508_list);
		Assert.assertEquals(1, Expr_508_list.size());
		//508
		final AndExpression AndExpression_509_Var
		 = (AndExpression)Expr_508_list.get(0);
		Assert.assertNotNull(AndExpression_509_Var
		);
		final EList<? extends EObject> Expr_509_list = AndExpression_509_Var
		.getExpr();
		Assert.assertNotNull(Expr_509_list);
		Assert.assertEquals(1, Expr_509_list.size());
		//509
		final EqualityExpression EqualityExpression_510_Var
		 = (EqualityExpression)Expr_509_list.get(0);
		Assert.assertNotNull(EqualityExpression_510_Var
		);
		final EList<? extends EObject> Expr_510_list = EqualityExpression_510_Var
		.getExpr();
		Assert.assertNotNull(Expr_510_list);
		Assert.assertEquals(1, Expr_510_list.size());
		//510
		final RelationalExpression RelationalExpression_511_Var
		 = (RelationalExpression)Expr_510_list.get(0);
		Assert.assertNotNull(RelationalExpression_511_Var
		);
		final EList<? extends EObject> Expr_511_list = RelationalExpression_511_Var
		.getExpr();
		Assert.assertNotNull(Expr_511_list);
		Assert.assertEquals(1, Expr_511_list.size());
		//511
		final ShiftExpression ShiftExpression_512_Var
		 = (ShiftExpression)Expr_511_list.get(0);
		Assert.assertNotNull(ShiftExpression_512_Var
		);
		final EList<? extends EObject> Expr_512_list = ShiftExpression_512_Var
		.getExpr();
		Assert.assertNotNull(Expr_512_list);
		Assert.assertEquals(1, Expr_512_list.size());
		//512
		final AdditiveExpression AdditiveExpression_513_Var
		 = (AdditiveExpression)Expr_512_list.get(0);
		Assert.assertNotNull(AdditiveExpression_513_Var
		);
		final EList<? extends EObject> Expr_513_list = AdditiveExpression_513_Var
		.getExpr();
		Assert.assertNotNull(Expr_513_list);
		Assert.assertEquals(1, Expr_513_list.size());
		//513
		final MultiplicativeExpression MultiplicativeExpression_514_Var
		 = (MultiplicativeExpression)Expr_513_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_514_Var
		);
		final EList<? extends EObject> Expr_514_list = MultiplicativeExpression_514_Var
		.getExpr();
		Assert.assertNotNull(Expr_514_list);
		Assert.assertEquals(1, Expr_514_list.size());
		//514
		final CastExpression CastExpression_515_Var
		 = (CastExpression)Expr_514_list.get(0);
		Assert.assertNotNull(CastExpression_515_Var
		);
		//515
		final UnaryExpression UnaryExpression_516_Var
		 = (UnaryExpression)CastExpression_515_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_516_Var
		);
		//516
		final UnaryOperator UnaryOperator_517_Var
		 = (UnaryOperator)UnaryExpression_516_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_517_Var
		);
		Assert.assertEquals("&", UnaryOperator_517_Var
		.getOp());
		//517
		final CastExpression CastExpression_518_Var
		 = (CastExpression)UnaryExpression_516_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_518_Var
		);
		//518
		final UnaryExpression UnaryExpression_519_Var
		 = (UnaryExpression)CastExpression_518_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_519_Var
		);
		//519
		final PostfixExpression PostfixExpression_520_Var
		 = (PostfixExpression)UnaryExpression_519_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_520_Var
		);
		final EList<? extends EObject> Expr_520_list = PostfixExpression_520_Var
		.getExpr();
		Assert.assertNotNull(Expr_520_list);
		Assert.assertEquals(1, Expr_520_list.size());
		//520
		final PrimaryExpression PrimaryExpression_521_Var
		 = (PrimaryExpression)Expr_520_list.get(0);
		Assert.assertNotNull(PrimaryExpression_521_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_521_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_483_Var
		.getSemi());
		//521
		final Statement Statement_522_Var
		 = (Statement)Statement_349_list.get(3);
		Assert.assertNotNull(Statement_522_Var
		);
		//522
		final ExpressionStatement ExpressionStatement_523_Var
		 = (ExpressionStatement)Statement_522_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_523_Var
		);
		//523
		final Expression Expression_524_Var
		 = (Expression)ExpressionStatement_523_Var
		.getExpression();
		Assert.assertNotNull(Expression_524_Var
		);
		final EList<? extends EObject> ExprExpr_524_list = Expression_524_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_524_list);
		Assert.assertEquals(1, ExprExpr_524_list.size());
		//524
		final AssignmentExpression AssignmentExpression_525_Var
		 = (AssignmentExpression)ExprExpr_524_list.get(0);
		Assert.assertNotNull(AssignmentExpression_525_Var
		);
		//525
		final UnaryExpression UnaryExpression_526_Var
		 = (UnaryExpression)AssignmentExpression_525_Var
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
		Assert.assertEquals("newEmployee", PrimaryExpression_528_Var
		.getId());
		final EList<? extends EObject> Suffix_528_list = PostfixExpression_527_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_528_list);
		Assert.assertEquals(1, Suffix_528_list.size());
		//528
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_529_Var
		 = (PostfixExpressionSuffixArrow)Suffix_528_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArrow_529_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixArrow_529_Var
		.getId());
		//529
		final AssignmentOperator AssignmentOperator_530_Var
		 = (AssignmentOperator)AssignmentExpression_525_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_530_Var
		);
		Assert.assertEquals("=", AssignmentOperator_530_Var
		.getOp());
		//530
		final AssignmentExpression AssignmentExpression_531_Var
		 = (AssignmentExpression)AssignmentExpression_525_Var
		.getAssignmentExpr();
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
		//546
		final Constant2 Constant2_547_Var
		 = (Constant2)PrimaryExpression_546_Var
		.getConst();
		Assert.assertNotNull(Constant2_547_Var
		);
		Assert.assertEquals("0x009", Constant2_547_Var
		.getHex());
		Assert.assertEquals(";", ExpressionStatement_523_Var
		.getSemi());
		//547
		final Statement Statement_548_Var
		 = (Statement)Statement_349_list.get(4);
		Assert.assertNotNull(Statement_548_Var
		);
		//548
		final ExpressionStatement ExpressionStatement_549_Var
		 = (ExpressionStatement)Statement_548_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_549_Var
		);
		//549
		final Expression Expression_550_Var
		 = (Expression)ExpressionStatement_549_Var
		.getExpression();
		Assert.assertNotNull(Expression_550_Var
		);
		final EList<? extends EObject> ExprExpr_550_list = Expression_550_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_550_list);
		Assert.assertEquals(1, ExprExpr_550_list.size());
		//550
		final AssignmentExpression AssignmentExpression_551_Var
		 = (AssignmentExpression)ExprExpr_550_list.get(0);
		Assert.assertNotNull(AssignmentExpression_551_Var
		);
		//551
		final ConditionalExpression ConditionalExpression_552_Var
		 = (ConditionalExpression)AssignmentExpression_551_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_552_Var
		);
		//552
		final LogicalOrExpression LogicalOrExpression_553_Var
		 = (LogicalOrExpression)ConditionalExpression_552_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_553_Var
		);
		final EList<? extends EObject> Expr_553_list = LogicalOrExpression_553_Var
		.getExpr();
		Assert.assertNotNull(Expr_553_list);
		Assert.assertEquals(1, Expr_553_list.size());
		//553
		final LogicalAndExpression LogicalAndExpression_554_Var
		 = (LogicalAndExpression)Expr_553_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_554_Var
		);
		final EList<? extends EObject> Expr_554_list = LogicalAndExpression_554_Var
		.getExpr();
		Assert.assertNotNull(Expr_554_list);
		Assert.assertEquals(1, Expr_554_list.size());
		//554
		final InclusiveOrExpression InclusiveOrExpression_555_Var
		 = (InclusiveOrExpression)Expr_554_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_555_Var
		);
		final EList<? extends EObject> Expr_555_list = InclusiveOrExpression_555_Var
		.getExpr();
		Assert.assertNotNull(Expr_555_list);
		Assert.assertEquals(1, Expr_555_list.size());
		//555
		final ExclusiveOrExpression ExclusiveOrExpression_556_Var
		 = (ExclusiveOrExpression)Expr_555_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_556_Var
		);
		final EList<? extends EObject> Expr_556_list = ExclusiveOrExpression_556_Var
		.getExpr();
		Assert.assertNotNull(Expr_556_list);
		Assert.assertEquals(1, Expr_556_list.size());
		//556
		final AndExpression AndExpression_557_Var
		 = (AndExpression)Expr_556_list.get(0);
		Assert.assertNotNull(AndExpression_557_Var
		);
		final EList<? extends EObject> Expr_557_list = AndExpression_557_Var
		.getExpr();
		Assert.assertNotNull(Expr_557_list);
		Assert.assertEquals(1, Expr_557_list.size());
		//557
		final EqualityExpression EqualityExpression_558_Var
		 = (EqualityExpression)Expr_557_list.get(0);
		Assert.assertNotNull(EqualityExpression_558_Var
		);
		final EList<? extends EObject> Expr_558_list = EqualityExpression_558_Var
		.getExpr();
		Assert.assertNotNull(Expr_558_list);
		Assert.assertEquals(1, Expr_558_list.size());
		//558
		final RelationalExpression RelationalExpression_559_Var
		 = (RelationalExpression)Expr_558_list.get(0);
		Assert.assertNotNull(RelationalExpression_559_Var
		);
		final EList<? extends EObject> Expr_559_list = RelationalExpression_559_Var
		.getExpr();
		Assert.assertNotNull(Expr_559_list);
		Assert.assertEquals(1, Expr_559_list.size());
		//559
		final ShiftExpression ShiftExpression_560_Var
		 = (ShiftExpression)Expr_559_list.get(0);
		Assert.assertNotNull(ShiftExpression_560_Var
		);
		final EList<? extends EObject> Expr_560_list = ShiftExpression_560_Var
		.getExpr();
		Assert.assertNotNull(Expr_560_list);
		Assert.assertEquals(1, Expr_560_list.size());
		//560
		final AdditiveExpression AdditiveExpression_561_Var
		 = (AdditiveExpression)Expr_560_list.get(0);
		Assert.assertNotNull(AdditiveExpression_561_Var
		);
		final EList<? extends EObject> Expr_561_list = AdditiveExpression_561_Var
		.getExpr();
		Assert.assertNotNull(Expr_561_list);
		Assert.assertEquals(1, Expr_561_list.size());
		//561
		final MultiplicativeExpression MultiplicativeExpression_562_Var
		 = (MultiplicativeExpression)Expr_561_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_562_Var
		);
		final EList<? extends EObject> Expr_562_list = MultiplicativeExpression_562_Var
		.getExpr();
		Assert.assertNotNull(Expr_562_list);
		Assert.assertEquals(1, Expr_562_list.size());
		//562
		final CastExpression CastExpression_563_Var
		 = (CastExpression)Expr_562_list.get(0);
		Assert.assertNotNull(CastExpression_563_Var
		);
		//563
		final UnaryExpression UnaryExpression_564_Var
		 = (UnaryExpression)CastExpression_563_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_564_Var
		);
		//564
		final PostfixExpression PostfixExpression_565_Var
		 = (PostfixExpression)UnaryExpression_564_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_565_Var
		);
		final EList<? extends EObject> Expr_565_list = PostfixExpression_565_Var
		.getExpr();
		Assert.assertNotNull(Expr_565_list);
		Assert.assertEquals(1, Expr_565_list.size());
		//565
		final PrimaryExpression PrimaryExpression_566_Var
		 = (PrimaryExpression)Expr_565_list.get(0);
		Assert.assertNotNull(PrimaryExpression_566_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_566_Var
		.getId());
		final EList<? extends EObject> Suffix_566_list = PostfixExpression_565_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_566_list);
		Assert.assertEquals(1, Suffix_566_list.size());
		//566
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_567_Var
		 = (PostfixExpressionSuffixArgument)Suffix_566_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_567_Var
		);
		//567
		final ArgumentExpressionList ArgumentExpressionList_568_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_567_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_568_Var
		);
		final EList<? extends EObject> Expr_568_list = ArgumentExpressionList_568_Var
		.getExpr();
		Assert.assertNotNull(Expr_568_list);
		Assert.assertEquals(2, Expr_568_list.size());
		//568
		final AssignmentExpression AssignmentExpression_569_Var
		 = (AssignmentExpression)Expr_568_list.get(0);
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
		Assert.assertEquals("newEmployee", PrimaryExpression_584_Var
		.getId());
		final EList<? extends EObject> Suffix_584_list = PostfixExpression_583_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_584_list);
		Assert.assertEquals(1, Suffix_584_list.size());
		//584
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_585_Var
		 = (PostfixExpressionSuffixArrow)Suffix_584_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArrow_585_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixArrow_585_Var
		.getId());
		//585
		final AssignmentExpression AssignmentExpression_586_Var
		 = (AssignmentExpression)Expr_568_list.get(1);
		Assert.assertNotNull(AssignmentExpression_586_Var
		);
		//586
		final ConditionalExpression ConditionalExpression_587_Var
		 = (ConditionalExpression)AssignmentExpression_586_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_587_Var
		);
		//587
		final LogicalOrExpression LogicalOrExpression_588_Var
		 = (LogicalOrExpression)ConditionalExpression_587_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_588_Var
		);
		final EList<? extends EObject> Expr_588_list = LogicalOrExpression_588_Var
		.getExpr();
		Assert.assertNotNull(Expr_588_list);
		Assert.assertEquals(1, Expr_588_list.size());
		//588
		final LogicalAndExpression LogicalAndExpression_589_Var
		 = (LogicalAndExpression)Expr_588_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_589_Var
		);
		final EList<? extends EObject> Expr_589_list = LogicalAndExpression_589_Var
		.getExpr();
		Assert.assertNotNull(Expr_589_list);
		Assert.assertEquals(1, Expr_589_list.size());
		//589
		final InclusiveOrExpression InclusiveOrExpression_590_Var
		 = (InclusiveOrExpression)Expr_589_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_590_Var
		);
		final EList<? extends EObject> Expr_590_list = InclusiveOrExpression_590_Var
		.getExpr();
		Assert.assertNotNull(Expr_590_list);
		Assert.assertEquals(1, Expr_590_list.size());
		//590
		final ExclusiveOrExpression ExclusiveOrExpression_591_Var
		 = (ExclusiveOrExpression)Expr_590_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_591_Var
		);
		final EList<? extends EObject> Expr_591_list = ExclusiveOrExpression_591_Var
		.getExpr();
		Assert.assertNotNull(Expr_591_list);
		Assert.assertEquals(1, Expr_591_list.size());
		//591
		final AndExpression AndExpression_592_Var
		 = (AndExpression)Expr_591_list.get(0);
		Assert.assertNotNull(AndExpression_592_Var
		);
		final EList<? extends EObject> Expr_592_list = AndExpression_592_Var
		.getExpr();
		Assert.assertNotNull(Expr_592_list);
		Assert.assertEquals(1, Expr_592_list.size());
		//592
		final EqualityExpression EqualityExpression_593_Var
		 = (EqualityExpression)Expr_592_list.get(0);
		Assert.assertNotNull(EqualityExpression_593_Var
		);
		final EList<? extends EObject> Expr_593_list = EqualityExpression_593_Var
		.getExpr();
		Assert.assertNotNull(Expr_593_list);
		Assert.assertEquals(1, Expr_593_list.size());
		//593
		final RelationalExpression RelationalExpression_594_Var
		 = (RelationalExpression)Expr_593_list.get(0);
		Assert.assertNotNull(RelationalExpression_594_Var
		);
		final EList<? extends EObject> Expr_594_list = RelationalExpression_594_Var
		.getExpr();
		Assert.assertNotNull(Expr_594_list);
		Assert.assertEquals(1, Expr_594_list.size());
		//594
		final ShiftExpression ShiftExpression_595_Var
		 = (ShiftExpression)Expr_594_list.get(0);
		Assert.assertNotNull(ShiftExpression_595_Var
		);
		final EList<? extends EObject> Expr_595_list = ShiftExpression_595_Var
		.getExpr();
		Assert.assertNotNull(Expr_595_list);
		Assert.assertEquals(1, Expr_595_list.size());
		//595
		final AdditiveExpression AdditiveExpression_596_Var
		 = (AdditiveExpression)Expr_595_list.get(0);
		Assert.assertNotNull(AdditiveExpression_596_Var
		);
		final EList<? extends EObject> Expr_596_list = AdditiveExpression_596_Var
		.getExpr();
		Assert.assertNotNull(Expr_596_list);
		Assert.assertEquals(1, Expr_596_list.size());
		//596
		final MultiplicativeExpression MultiplicativeExpression_597_Var
		 = (MultiplicativeExpression)Expr_596_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_597_Var
		);
		final EList<? extends EObject> Expr_597_list = MultiplicativeExpression_597_Var
		.getExpr();
		Assert.assertNotNull(Expr_597_list);
		Assert.assertEquals(1, Expr_597_list.size());
		//597
		final CastExpression CastExpression_598_Var
		 = (CastExpression)Expr_597_list.get(0);
		Assert.assertNotNull(CastExpression_598_Var
		);
		//598
		final UnaryExpression UnaryExpression_599_Var
		 = (UnaryExpression)CastExpression_598_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_599_Var
		);
		//599
		final PostfixExpression PostfixExpression_600_Var
		 = (PostfixExpression)UnaryExpression_599_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_600_Var
		);
		final EList<? extends EObject> Expr_600_list = PostfixExpression_600_Var
		.getExpr();
		Assert.assertNotNull(Expr_600_list);
		Assert.assertEquals(1, Expr_600_list.size());
		//600
		final PrimaryExpression PrimaryExpression_601_Var
		 = (PrimaryExpression)Expr_600_list.get(0);
		Assert.assertNotNull(PrimaryExpression_601_Var
		);
		//601
		final Constant2 Constant2_602_Var
		 = (Constant2)PrimaryExpression_601_Var
		.getConst();
		Assert.assertNotNull(Constant2_602_Var
		);
		Assert.assertEquals("\"Billy The Kid\"", Constant2_602_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_549_Var
		.getSemi());
		//602
		final Statement Statement_603_Var
		 = (Statement)Statement_349_list.get(5);
		Assert.assertNotNull(Statement_603_Var
		);
		//603
		final ExpressionStatement ExpressionStatement_604_Var
		 = (ExpressionStatement)Statement_603_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_604_Var
		);
		//604
		final Expression Expression_605_Var
		 = (Expression)ExpressionStatement_604_Var
		.getExpression();
		Assert.assertNotNull(Expression_605_Var
		);
		final EList<? extends EObject> ExprExpr_605_list = Expression_605_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_605_list);
		Assert.assertEquals(1, ExprExpr_605_list.size());
		//605
		final AssignmentExpression AssignmentExpression_606_Var
		 = (AssignmentExpression)ExprExpr_605_list.get(0);
		Assert.assertNotNull(AssignmentExpression_606_Var
		);
		//606
		final ConditionalExpression ConditionalExpression_607_Var
		 = (ConditionalExpression)AssignmentExpression_606_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_607_Var
		);
		//607
		final LogicalOrExpression LogicalOrExpression_608_Var
		 = (LogicalOrExpression)ConditionalExpression_607_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_608_Var
		);
		final EList<? extends EObject> Expr_608_list = LogicalOrExpression_608_Var
		.getExpr();
		Assert.assertNotNull(Expr_608_list);
		Assert.assertEquals(1, Expr_608_list.size());
		//608
		final LogicalAndExpression LogicalAndExpression_609_Var
		 = (LogicalAndExpression)Expr_608_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_609_Var
		);
		final EList<? extends EObject> Expr_609_list = LogicalAndExpression_609_Var
		.getExpr();
		Assert.assertNotNull(Expr_609_list);
		Assert.assertEquals(1, Expr_609_list.size());
		//609
		final InclusiveOrExpression InclusiveOrExpression_610_Var
		 = (InclusiveOrExpression)Expr_609_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_610_Var
		);
		final EList<? extends EObject> Expr_610_list = InclusiveOrExpression_610_Var
		.getExpr();
		Assert.assertNotNull(Expr_610_list);
		Assert.assertEquals(1, Expr_610_list.size());
		//610
		final ExclusiveOrExpression ExclusiveOrExpression_611_Var
		 = (ExclusiveOrExpression)Expr_610_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_611_Var
		);
		final EList<? extends EObject> Expr_611_list = ExclusiveOrExpression_611_Var
		.getExpr();
		Assert.assertNotNull(Expr_611_list);
		Assert.assertEquals(1, Expr_611_list.size());
		//611
		final AndExpression AndExpression_612_Var
		 = (AndExpression)Expr_611_list.get(0);
		Assert.assertNotNull(AndExpression_612_Var
		);
		final EList<? extends EObject> Expr_612_list = AndExpression_612_Var
		.getExpr();
		Assert.assertNotNull(Expr_612_list);
		Assert.assertEquals(1, Expr_612_list.size());
		//612
		final EqualityExpression EqualityExpression_613_Var
		 = (EqualityExpression)Expr_612_list.get(0);
		Assert.assertNotNull(EqualityExpression_613_Var
		);
		final EList<? extends EObject> Expr_613_list = EqualityExpression_613_Var
		.getExpr();
		Assert.assertNotNull(Expr_613_list);
		Assert.assertEquals(1, Expr_613_list.size());
		//613
		final RelationalExpression RelationalExpression_614_Var
		 = (RelationalExpression)Expr_613_list.get(0);
		Assert.assertNotNull(RelationalExpression_614_Var
		);
		final EList<? extends EObject> Expr_614_list = RelationalExpression_614_Var
		.getExpr();
		Assert.assertNotNull(Expr_614_list);
		Assert.assertEquals(1, Expr_614_list.size());
		//614
		final ShiftExpression ShiftExpression_615_Var
		 = (ShiftExpression)Expr_614_list.get(0);
		Assert.assertNotNull(ShiftExpression_615_Var
		);
		final EList<? extends EObject> Expr_615_list = ShiftExpression_615_Var
		.getExpr();
		Assert.assertNotNull(Expr_615_list);
		Assert.assertEquals(1, Expr_615_list.size());
		//615
		final AdditiveExpression AdditiveExpression_616_Var
		 = (AdditiveExpression)Expr_615_list.get(0);
		Assert.assertNotNull(AdditiveExpression_616_Var
		);
		final EList<? extends EObject> Expr_616_list = AdditiveExpression_616_Var
		.getExpr();
		Assert.assertNotNull(Expr_616_list);
		Assert.assertEquals(1, Expr_616_list.size());
		//616
		final MultiplicativeExpression MultiplicativeExpression_617_Var
		 = (MultiplicativeExpression)Expr_616_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_617_Var
		);
		final EList<? extends EObject> Expr_617_list = MultiplicativeExpression_617_Var
		.getExpr();
		Assert.assertNotNull(Expr_617_list);
		Assert.assertEquals(1, Expr_617_list.size());
		//617
		final CastExpression CastExpression_618_Var
		 = (CastExpression)Expr_617_list.get(0);
		Assert.assertNotNull(CastExpression_618_Var
		);
		//618
		final UnaryExpression UnaryExpression_619_Var
		 = (UnaryExpression)CastExpression_618_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_619_Var
		);
		//619
		final PostfixExpression PostfixExpression_620_Var
		 = (PostfixExpression)UnaryExpression_619_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_620_Var
		);
		final EList<? extends EObject> Expr_620_list = PostfixExpression_620_Var
		.getExpr();
		Assert.assertNotNull(Expr_620_list);
		Assert.assertEquals(1, Expr_620_list.size());
		//620
		final PrimaryExpression PrimaryExpression_621_Var
		 = (PrimaryExpression)Expr_620_list.get(0);
		Assert.assertNotNull(PrimaryExpression_621_Var
		);
		Assert.assertEquals("print", PrimaryExpression_621_Var
		.getId());
		final EList<? extends EObject> Suffix_621_list = PostfixExpression_620_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_621_list);
		Assert.assertEquals(1, Suffix_621_list.size());
		//621
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_622_Var
		 = (PostfixExpressionSuffixArgument)Suffix_621_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_622_Var
		);
		//622
		final ArgumentExpressionList ArgumentExpressionList_623_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_622_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_623_Var
		);
		final EList<? extends EObject> Expr_623_list = ArgumentExpressionList_623_Var
		.getExpr();
		Assert.assertNotNull(Expr_623_list);
		Assert.assertEquals(1, Expr_623_list.size());
		//623
		final AssignmentExpression AssignmentExpression_624_Var
		 = (AssignmentExpression)Expr_623_list.get(0);
		Assert.assertNotNull(AssignmentExpression_624_Var
		);
		//624
		final ConditionalExpression ConditionalExpression_625_Var
		 = (ConditionalExpression)AssignmentExpression_624_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_625_Var
		);
		//625
		final LogicalOrExpression LogicalOrExpression_626_Var
		 = (LogicalOrExpression)ConditionalExpression_625_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_626_Var
		);
		final EList<? extends EObject> Expr_626_list = LogicalOrExpression_626_Var
		.getExpr();
		Assert.assertNotNull(Expr_626_list);
		Assert.assertEquals(1, Expr_626_list.size());
		//626
		final LogicalAndExpression LogicalAndExpression_627_Var
		 = (LogicalAndExpression)Expr_626_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_627_Var
		);
		final EList<? extends EObject> Expr_627_list = LogicalAndExpression_627_Var
		.getExpr();
		Assert.assertNotNull(Expr_627_list);
		Assert.assertEquals(1, Expr_627_list.size());
		//627
		final InclusiveOrExpression InclusiveOrExpression_628_Var
		 = (InclusiveOrExpression)Expr_627_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_628_Var
		);
		final EList<? extends EObject> Expr_628_list = InclusiveOrExpression_628_Var
		.getExpr();
		Assert.assertNotNull(Expr_628_list);
		Assert.assertEquals(1, Expr_628_list.size());
		//628
		final ExclusiveOrExpression ExclusiveOrExpression_629_Var
		 = (ExclusiveOrExpression)Expr_628_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_629_Var
		);
		final EList<? extends EObject> Expr_629_list = ExclusiveOrExpression_629_Var
		.getExpr();
		Assert.assertNotNull(Expr_629_list);
		Assert.assertEquals(1, Expr_629_list.size());
		//629
		final AndExpression AndExpression_630_Var
		 = (AndExpression)Expr_629_list.get(0);
		Assert.assertNotNull(AndExpression_630_Var
		);
		final EList<? extends EObject> Expr_630_list = AndExpression_630_Var
		.getExpr();
		Assert.assertNotNull(Expr_630_list);
		Assert.assertEquals(1, Expr_630_list.size());
		//630
		final EqualityExpression EqualityExpression_631_Var
		 = (EqualityExpression)Expr_630_list.get(0);
		Assert.assertNotNull(EqualityExpression_631_Var
		);
		final EList<? extends EObject> Expr_631_list = EqualityExpression_631_Var
		.getExpr();
		Assert.assertNotNull(Expr_631_list);
		Assert.assertEquals(1, Expr_631_list.size());
		//631
		final RelationalExpression RelationalExpression_632_Var
		 = (RelationalExpression)Expr_631_list.get(0);
		Assert.assertNotNull(RelationalExpression_632_Var
		);
		final EList<? extends EObject> Expr_632_list = RelationalExpression_632_Var
		.getExpr();
		Assert.assertNotNull(Expr_632_list);
		Assert.assertEquals(1, Expr_632_list.size());
		//632
		final ShiftExpression ShiftExpression_633_Var
		 = (ShiftExpression)Expr_632_list.get(0);
		Assert.assertNotNull(ShiftExpression_633_Var
		);
		final EList<? extends EObject> Expr_633_list = ShiftExpression_633_Var
		.getExpr();
		Assert.assertNotNull(Expr_633_list);
		Assert.assertEquals(1, Expr_633_list.size());
		//633
		final AdditiveExpression AdditiveExpression_634_Var
		 = (AdditiveExpression)Expr_633_list.get(0);
		Assert.assertNotNull(AdditiveExpression_634_Var
		);
		final EList<? extends EObject> Expr_634_list = AdditiveExpression_634_Var
		.getExpr();
		Assert.assertNotNull(Expr_634_list);
		Assert.assertEquals(1, Expr_634_list.size());
		//634
		final MultiplicativeExpression MultiplicativeExpression_635_Var
		 = (MultiplicativeExpression)Expr_634_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_635_Var
		);
		final EList<? extends EObject> Expr_635_list = MultiplicativeExpression_635_Var
		.getExpr();
		Assert.assertNotNull(Expr_635_list);
		Assert.assertEquals(1, Expr_635_list.size());
		//635
		final CastExpression CastExpression_636_Var
		 = (CastExpression)Expr_635_list.get(0);
		Assert.assertNotNull(CastExpression_636_Var
		);
		//636
		final UnaryExpression UnaryExpression_637_Var
		 = (UnaryExpression)CastExpression_636_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_637_Var
		);
		//637
		final PostfixExpression PostfixExpression_638_Var
		 = (PostfixExpression)UnaryExpression_637_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_638_Var
		);
		final EList<? extends EObject> Expr_638_list = PostfixExpression_638_Var
		.getExpr();
		Assert.assertNotNull(Expr_638_list);
		Assert.assertEquals(1, Expr_638_list.size());
		//638
		final PrimaryExpression PrimaryExpression_639_Var
		 = (PrimaryExpression)Expr_638_list.get(0);
		Assert.assertNotNull(PrimaryExpression_639_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_639_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_604_Var
		.getSemi());
		//639
		final Statement Statement_640_Var
		 = (Statement)Statement_349_list.get(6);
		Assert.assertNotNull(Statement_640_Var
		);
		//640
		final ExpressionStatement ExpressionStatement_641_Var
		 = (ExpressionStatement)Statement_640_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_641_Var
		);
		//641
		final Expression Expression_642_Var
		 = (Expression)ExpressionStatement_641_Var
		.getExpression();
		Assert.assertNotNull(Expression_642_Var
		);
		final EList<? extends EObject> ExprExpr_642_list = Expression_642_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_642_list);
		Assert.assertEquals(1, ExprExpr_642_list.size());
		//642
		final AssignmentExpression AssignmentExpression_643_Var
		 = (AssignmentExpression)ExprExpr_642_list.get(0);
		Assert.assertNotNull(AssignmentExpression_643_Var
		);
		//643
		final ConditionalExpression ConditionalExpression_644_Var
		 = (ConditionalExpression)AssignmentExpression_643_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_644_Var
		);
		//644
		final LogicalOrExpression LogicalOrExpression_645_Var
		 = (LogicalOrExpression)ConditionalExpression_644_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_645_Var
		);
		final EList<? extends EObject> Expr_645_list = LogicalOrExpression_645_Var
		.getExpr();
		Assert.assertNotNull(Expr_645_list);
		Assert.assertEquals(1, Expr_645_list.size());
		//645
		final LogicalAndExpression LogicalAndExpression_646_Var
		 = (LogicalAndExpression)Expr_645_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_646_Var
		);
		final EList<? extends EObject> Expr_646_list = LogicalAndExpression_646_Var
		.getExpr();
		Assert.assertNotNull(Expr_646_list);
		Assert.assertEquals(1, Expr_646_list.size());
		//646
		final InclusiveOrExpression InclusiveOrExpression_647_Var
		 = (InclusiveOrExpression)Expr_646_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_647_Var
		);
		final EList<? extends EObject> Expr_647_list = InclusiveOrExpression_647_Var
		.getExpr();
		Assert.assertNotNull(Expr_647_list);
		Assert.assertEquals(1, Expr_647_list.size());
		//647
		final ExclusiveOrExpression ExclusiveOrExpression_648_Var
		 = (ExclusiveOrExpression)Expr_647_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_648_Var
		);
		final EList<? extends EObject> Expr_648_list = ExclusiveOrExpression_648_Var
		.getExpr();
		Assert.assertNotNull(Expr_648_list);
		Assert.assertEquals(1, Expr_648_list.size());
		//648
		final AndExpression AndExpression_649_Var
		 = (AndExpression)Expr_648_list.get(0);
		Assert.assertNotNull(AndExpression_649_Var
		);
		final EList<? extends EObject> Expr_649_list = AndExpression_649_Var
		.getExpr();
		Assert.assertNotNull(Expr_649_list);
		Assert.assertEquals(1, Expr_649_list.size());
		//649
		final EqualityExpression EqualityExpression_650_Var
		 = (EqualityExpression)Expr_649_list.get(0);
		Assert.assertNotNull(EqualityExpression_650_Var
		);
		final EList<? extends EObject> Expr_650_list = EqualityExpression_650_Var
		.getExpr();
		Assert.assertNotNull(Expr_650_list);
		Assert.assertEquals(1, Expr_650_list.size());
		//650
		final RelationalExpression RelationalExpression_651_Var
		 = (RelationalExpression)Expr_650_list.get(0);
		Assert.assertNotNull(RelationalExpression_651_Var
		);
		final EList<? extends EObject> Expr_651_list = RelationalExpression_651_Var
		.getExpr();
		Assert.assertNotNull(Expr_651_list);
		Assert.assertEquals(1, Expr_651_list.size());
		//651
		final ShiftExpression ShiftExpression_652_Var
		 = (ShiftExpression)Expr_651_list.get(0);
		Assert.assertNotNull(ShiftExpression_652_Var
		);
		final EList<? extends EObject> Expr_652_list = ShiftExpression_652_Var
		.getExpr();
		Assert.assertNotNull(Expr_652_list);
		Assert.assertEquals(1, Expr_652_list.size());
		//652
		final AdditiveExpression AdditiveExpression_653_Var
		 = (AdditiveExpression)Expr_652_list.get(0);
		Assert.assertNotNull(AdditiveExpression_653_Var
		);
		final EList<? extends EObject> Expr_653_list = AdditiveExpression_653_Var
		.getExpr();
		Assert.assertNotNull(Expr_653_list);
		Assert.assertEquals(1, Expr_653_list.size());
		//653
		final MultiplicativeExpression MultiplicativeExpression_654_Var
		 = (MultiplicativeExpression)Expr_653_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_654_Var
		);
		final EList<? extends EObject> Expr_654_list = MultiplicativeExpression_654_Var
		.getExpr();
		Assert.assertNotNull(Expr_654_list);
		Assert.assertEquals(1, Expr_654_list.size());
		//654
		final CastExpression CastExpression_655_Var
		 = (CastExpression)Expr_654_list.get(0);
		Assert.assertNotNull(CastExpression_655_Var
		);
		//655
		final UnaryExpression UnaryExpression_656_Var
		 = (UnaryExpression)CastExpression_655_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_656_Var
		);
		//656
		final PostfixExpression PostfixExpression_657_Var
		 = (PostfixExpression)UnaryExpression_656_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_657_Var
		);
		final EList<? extends EObject> Expr_657_list = PostfixExpression_657_Var
		.getExpr();
		Assert.assertNotNull(Expr_657_list);
		Assert.assertEquals(1, Expr_657_list.size());
		//657
		final PrimaryExpression PrimaryExpression_658_Var
		 = (PrimaryExpression)Expr_657_list.get(0);
		Assert.assertNotNull(PrimaryExpression_658_Var
		);
		Assert.assertEquals("free", PrimaryExpression_658_Var
		.getId());
		final EList<? extends EObject> Suffix_658_list = PostfixExpression_657_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_658_list);
		Assert.assertEquals(1, Suffix_658_list.size());
		//658
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_659_Var
		 = (PostfixExpressionSuffixArgument)Suffix_658_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_659_Var
		);
		//659
		final ArgumentExpressionList ArgumentExpressionList_660_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_659_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_660_Var
		);
		final EList<? extends EObject> Expr_660_list = ArgumentExpressionList_660_Var
		.getExpr();
		Assert.assertNotNull(Expr_660_list);
		Assert.assertEquals(1, Expr_660_list.size());
		//660
		final AssignmentExpression AssignmentExpression_661_Var
		 = (AssignmentExpression)Expr_660_list.get(0);
		Assert.assertNotNull(AssignmentExpression_661_Var
		);
		//661
		final ConditionalExpression ConditionalExpression_662_Var
		 = (ConditionalExpression)AssignmentExpression_661_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_662_Var
		);
		//662
		final LogicalOrExpression LogicalOrExpression_663_Var
		 = (LogicalOrExpression)ConditionalExpression_662_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_663_Var
		);
		final EList<? extends EObject> Expr_663_list = LogicalOrExpression_663_Var
		.getExpr();
		Assert.assertNotNull(Expr_663_list);
		Assert.assertEquals(1, Expr_663_list.size());
		//663
		final LogicalAndExpression LogicalAndExpression_664_Var
		 = (LogicalAndExpression)Expr_663_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_664_Var
		);
		final EList<? extends EObject> Expr_664_list = LogicalAndExpression_664_Var
		.getExpr();
		Assert.assertNotNull(Expr_664_list);
		Assert.assertEquals(1, Expr_664_list.size());
		//664
		final InclusiveOrExpression InclusiveOrExpression_665_Var
		 = (InclusiveOrExpression)Expr_664_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_665_Var
		);
		final EList<? extends EObject> Expr_665_list = InclusiveOrExpression_665_Var
		.getExpr();
		Assert.assertNotNull(Expr_665_list);
		Assert.assertEquals(1, Expr_665_list.size());
		//665
		final ExclusiveOrExpression ExclusiveOrExpression_666_Var
		 = (ExclusiveOrExpression)Expr_665_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_666_Var
		);
		final EList<? extends EObject> Expr_666_list = ExclusiveOrExpression_666_Var
		.getExpr();
		Assert.assertNotNull(Expr_666_list);
		Assert.assertEquals(1, Expr_666_list.size());
		//666
		final AndExpression AndExpression_667_Var
		 = (AndExpression)Expr_666_list.get(0);
		Assert.assertNotNull(AndExpression_667_Var
		);
		final EList<? extends EObject> Expr_667_list = AndExpression_667_Var
		.getExpr();
		Assert.assertNotNull(Expr_667_list);
		Assert.assertEquals(1, Expr_667_list.size());
		//667
		final EqualityExpression EqualityExpression_668_Var
		 = (EqualityExpression)Expr_667_list.get(0);
		Assert.assertNotNull(EqualityExpression_668_Var
		);
		final EList<? extends EObject> Expr_668_list = EqualityExpression_668_Var
		.getExpr();
		Assert.assertNotNull(Expr_668_list);
		Assert.assertEquals(1, Expr_668_list.size());
		//668
		final RelationalExpression RelationalExpression_669_Var
		 = (RelationalExpression)Expr_668_list.get(0);
		Assert.assertNotNull(RelationalExpression_669_Var
		);
		final EList<? extends EObject> Expr_669_list = RelationalExpression_669_Var
		.getExpr();
		Assert.assertNotNull(Expr_669_list);
		Assert.assertEquals(1, Expr_669_list.size());
		//669
		final ShiftExpression ShiftExpression_670_Var
		 = (ShiftExpression)Expr_669_list.get(0);
		Assert.assertNotNull(ShiftExpression_670_Var
		);
		final EList<? extends EObject> Expr_670_list = ShiftExpression_670_Var
		.getExpr();
		Assert.assertNotNull(Expr_670_list);
		Assert.assertEquals(1, Expr_670_list.size());
		//670
		final AdditiveExpression AdditiveExpression_671_Var
		 = (AdditiveExpression)Expr_670_list.get(0);
		Assert.assertNotNull(AdditiveExpression_671_Var
		);
		final EList<? extends EObject> Expr_671_list = AdditiveExpression_671_Var
		.getExpr();
		Assert.assertNotNull(Expr_671_list);
		Assert.assertEquals(1, Expr_671_list.size());
		//671
		final MultiplicativeExpression MultiplicativeExpression_672_Var
		 = (MultiplicativeExpression)Expr_671_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_672_Var
		);
		final EList<? extends EObject> Expr_672_list = MultiplicativeExpression_672_Var
		.getExpr();
		Assert.assertNotNull(Expr_672_list);
		Assert.assertEquals(1, Expr_672_list.size());
		//672
		final CastExpression CastExpression_673_Var
		 = (CastExpression)Expr_672_list.get(0);
		Assert.assertNotNull(CastExpression_673_Var
		);
		//673
		final UnaryExpression UnaryExpression_674_Var
		 = (UnaryExpression)CastExpression_673_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_674_Var
		);
		//674
		final PostfixExpression PostfixExpression_675_Var
		 = (PostfixExpression)UnaryExpression_674_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_675_Var
		);
		final EList<? extends EObject> Expr_675_list = PostfixExpression_675_Var
		.getExpr();
		Assert.assertNotNull(Expr_675_list);
		Assert.assertEquals(1, Expr_675_list.size());
		//675
		final PrimaryExpression PrimaryExpression_676_Var
		 = (PrimaryExpression)Expr_675_list.get(0);
		Assert.assertNotNull(PrimaryExpression_676_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_676_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_641_Var
		.getSemi());
		//676
		final Statement Statement_677_Var
		 = (Statement)Statement_349_list.get(7);
		Assert.assertNotNull(Statement_677_Var
		);
		//677
		final JumpStatement JumpStatement_678_Var
		 = (JumpStatement)Statement_677_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_678_Var
		);
		//678
		final Expression Expression_679_Var
		 = (Expression)JumpStatement_678_Var
		.getExpr();
		Assert.assertNotNull(Expression_679_Var
		);
		final EList<? extends EObject> ExprExpr_679_list = Expression_679_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_679_list);
		Assert.assertEquals(1, ExprExpr_679_list.size());
		//679
		final AssignmentExpression AssignmentExpression_680_Var
		 = (AssignmentExpression)ExprExpr_679_list.get(0);
		Assert.assertNotNull(AssignmentExpression_680_Var
		);
		//680
		final ConditionalExpression ConditionalExpression_681_Var
		 = (ConditionalExpression)AssignmentExpression_680_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_681_Var
		);
		//681
		final LogicalOrExpression LogicalOrExpression_682_Var
		 = (LogicalOrExpression)ConditionalExpression_681_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_682_Var
		);
		final EList<? extends EObject> Expr_682_list = LogicalOrExpression_682_Var
		.getExpr();
		Assert.assertNotNull(Expr_682_list);
		Assert.assertEquals(1, Expr_682_list.size());
		//682
		final LogicalAndExpression LogicalAndExpression_683_Var
		 = (LogicalAndExpression)Expr_682_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_683_Var
		);
		final EList<? extends EObject> Expr_683_list = LogicalAndExpression_683_Var
		.getExpr();
		Assert.assertNotNull(Expr_683_list);
		Assert.assertEquals(1, Expr_683_list.size());
		//683
		final InclusiveOrExpression InclusiveOrExpression_684_Var
		 = (InclusiveOrExpression)Expr_683_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_684_Var
		);
		final EList<? extends EObject> Expr_684_list = InclusiveOrExpression_684_Var
		.getExpr();
		Assert.assertNotNull(Expr_684_list);
		Assert.assertEquals(1, Expr_684_list.size());
		//684
		final ExclusiveOrExpression ExclusiveOrExpression_685_Var
		 = (ExclusiveOrExpression)Expr_684_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_685_Var
		);
		final EList<? extends EObject> Expr_685_list = ExclusiveOrExpression_685_Var
		.getExpr();
		Assert.assertNotNull(Expr_685_list);
		Assert.assertEquals(1, Expr_685_list.size());
		//685
		final AndExpression AndExpression_686_Var
		 = (AndExpression)Expr_685_list.get(0);
		Assert.assertNotNull(AndExpression_686_Var
		);
		final EList<? extends EObject> Expr_686_list = AndExpression_686_Var
		.getExpr();
		Assert.assertNotNull(Expr_686_list);
		Assert.assertEquals(1, Expr_686_list.size());
		//686
		final EqualityExpression EqualityExpression_687_Var
		 = (EqualityExpression)Expr_686_list.get(0);
		Assert.assertNotNull(EqualityExpression_687_Var
		);
		final EList<? extends EObject> Expr_687_list = EqualityExpression_687_Var
		.getExpr();
		Assert.assertNotNull(Expr_687_list);
		Assert.assertEquals(1, Expr_687_list.size());
		//687
		final RelationalExpression RelationalExpression_688_Var
		 = (RelationalExpression)Expr_687_list.get(0);
		Assert.assertNotNull(RelationalExpression_688_Var
		);
		final EList<? extends EObject> Expr_688_list = RelationalExpression_688_Var
		.getExpr();
		Assert.assertNotNull(Expr_688_list);
		Assert.assertEquals(1, Expr_688_list.size());
		//688
		final ShiftExpression ShiftExpression_689_Var
		 = (ShiftExpression)Expr_688_list.get(0);
		Assert.assertNotNull(ShiftExpression_689_Var
		);
		final EList<? extends EObject> Expr_689_list = ShiftExpression_689_Var
		.getExpr();
		Assert.assertNotNull(Expr_689_list);
		Assert.assertEquals(1, Expr_689_list.size());
		//689
		final AdditiveExpression AdditiveExpression_690_Var
		 = (AdditiveExpression)Expr_689_list.get(0);
		Assert.assertNotNull(AdditiveExpression_690_Var
		);
		final EList<? extends EObject> Expr_690_list = AdditiveExpression_690_Var
		.getExpr();
		Assert.assertNotNull(Expr_690_list);
		Assert.assertEquals(1, Expr_690_list.size());
		//690
		final MultiplicativeExpression MultiplicativeExpression_691_Var
		 = (MultiplicativeExpression)Expr_690_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_691_Var
		);
		final EList<? extends EObject> Expr_691_list = MultiplicativeExpression_691_Var
		.getExpr();
		Assert.assertNotNull(Expr_691_list);
		Assert.assertEquals(1, Expr_691_list.size());
		//691
		final CastExpression CastExpression_692_Var
		 = (CastExpression)Expr_691_list.get(0);
		Assert.assertNotNull(CastExpression_692_Var
		);
		//692
		final UnaryExpression UnaryExpression_693_Var
		 = (UnaryExpression)CastExpression_692_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_693_Var
		);
		//693
		final PostfixExpression PostfixExpression_694_Var
		 = (PostfixExpression)UnaryExpression_693_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_694_Var
		);
		final EList<? extends EObject> Expr_694_list = PostfixExpression_694_Var
		.getExpr();
		Assert.assertNotNull(Expr_694_list);
		Assert.assertEquals(1, Expr_694_list.size());
		//694
		final PrimaryExpression PrimaryExpression_695_Var
		 = (PrimaryExpression)Expr_694_list.get(0);
		Assert.assertNotNull(PrimaryExpression_695_Var
		);
		//695
		final Constant2 Constant2_696_Var
		 = (Constant2)PrimaryExpression_695_Var
		.getConst();
		Assert.assertNotNull(Constant2_696_Var
		);
		Assert.assertEquals("0", Constant2_696_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_678_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_678_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0038_StructAdvanced.c");
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
				method.invoke(this.generator, "Test0038_StructAdvanced.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0038_StructAdvanced.c");
		final String expected = this.getTextFromFile(
			"res/Test0038_StructAdvanced.c"
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


