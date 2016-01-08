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
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
	
	@Test (timeout=1000)
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
	
	@Test (timeout=1000)
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
		final TypeSpecifier TypeSpecifier_5_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(1);
		Assert.assertNotNull(TypeSpecifier_5_Var
		);
		//5
		final StructOrUnionSpecifier StructOrUnionSpecifier_6_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_5_Var
		.getSpecifier();
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
		Assert.assertEquals("empStruct", StructOrUnionSpecifier_6_Var
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
		final EList<? extends EObject> InitDeclaratorList_40_list = Declaration_2_Var
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
		Assert.assertEquals("employee", DirectDeclarator_44_Var
		.getId());
		//44
		final ExternalDeclaration ExternalDeclaration_45_Var
		 = (ExternalDeclaration)External_0_list.get(1);
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
		final TypeSpecifier TypeSpecifier_48_Var
		 = (TypeSpecifier)DeclarationSpecifier_47_list.get(0);
		Assert.assertNotNull(TypeSpecifier_48_Var
		);
		//48
		final StructOrUnionSpecifier StructOrUnionSpecifier_49_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_48_Var
		.getSpecifier();
		Assert.assertNotNull(StructOrUnionSpecifier_49_Var
		);
		//49
		final StructOrUnion StructOrUnion_50_Var
		 = (StructOrUnion)StructOrUnionSpecifier_49_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_50_Var
		);
		Assert.assertEquals("struct", StructOrUnion_50_Var
		.getName());
		Assert.assertEquals("empStruct", StructOrUnionSpecifier_49_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_50_list = Declaration_46_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_50_list);
		Assert.assertEquals(1, InitDeclaratorList_50_list.size());
		//50
		final InitDeclaratorList InitDeclaratorList_51_Var
		 = (InitDeclaratorList)InitDeclaratorList_50_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_51_Var
		);
		final EList<? extends EObject> InitDeclarator_51_list = InitDeclaratorList_51_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_51_list);
		Assert.assertEquals(1, InitDeclarator_51_list.size());
		//51
		final InitDeclarator InitDeclarator_52_Var
		 = (InitDeclarator)InitDeclarator_51_list.get(0);
		Assert.assertNotNull(InitDeclarator_52_Var
		);
		//52
		final Declarator Declarator_53_Var
		 = (Declarator)InitDeclarator_52_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_53_Var
		);
		//53
		final DirectDeclarator DirectDeclarator_54_Var
		 = (DirectDeclarator)Declarator_53_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_54_Var
		);
		Assert.assertEquals("joe", DirectDeclarator_54_Var
		.getId());
		//54
		final Initializer Initializer_55_Var
		 = (Initializer)InitDeclarator_52_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_55_Var
		);
		//55
		final InitializerList InitializerList_56_Var
		 = (InitializerList)Initializer_55_Var
		.getList();
		Assert.assertNotNull(InitializerList_56_Var
		);
		final EList<? extends EObject> Initializer_56_list = InitializerList_56_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_56_list);
		Assert.assertEquals(2, Initializer_56_list.size());
		//56
		final Initializer Initializer_57_Var
		 = (Initializer)Initializer_56_list.get(0);
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
		final Initializer Initializer_75_Var
		 = (Initializer)Initializer_56_list.get(1);
		Assert.assertNotNull(Initializer_75_Var
		);
		//75
		final AssignmentExpression AssignmentExpression_76_Var
		 = (AssignmentExpression)Initializer_75_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_76_Var
		);
		//76
		final ConditionalExpression ConditionalExpression_77_Var
		 = (ConditionalExpression)AssignmentExpression_76_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_77_Var
		);
		//77
		final LogicalOrExpression LogicalOrExpression_78_Var
		 = (LogicalOrExpression)ConditionalExpression_77_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = LogicalOrExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final LogicalAndExpression LogicalAndExpression_79_Var
		 = (LogicalAndExpression)Expr_78_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = LogicalAndExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final InclusiveOrExpression InclusiveOrExpression_80_Var
		 = (InclusiveOrExpression)Expr_79_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = InclusiveOrExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final ExclusiveOrExpression ExclusiveOrExpression_81_Var
		 = (ExclusiveOrExpression)Expr_80_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = ExclusiveOrExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final AndExpression AndExpression_82_Var
		 = (AndExpression)Expr_81_list.get(0);
		Assert.assertNotNull(AndExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = AndExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final EqualityExpression EqualityExpression_83_Var
		 = (EqualityExpression)Expr_82_list.get(0);
		Assert.assertNotNull(EqualityExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = EqualityExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final RelationalExpression RelationalExpression_84_Var
		 = (RelationalExpression)Expr_83_list.get(0);
		Assert.assertNotNull(RelationalExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = RelationalExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final ShiftExpression ShiftExpression_85_Var
		 = (ShiftExpression)Expr_84_list.get(0);
		Assert.assertNotNull(ShiftExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = ShiftExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final AdditiveExpression AdditiveExpression_86_Var
		 = (AdditiveExpression)Expr_85_list.get(0);
		Assert.assertNotNull(AdditiveExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = AdditiveExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final MultiplicativeExpression MultiplicativeExpression_87_Var
		 = (MultiplicativeExpression)Expr_86_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = MultiplicativeExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final CastExpression CastExpression_88_Var
		 = (CastExpression)Expr_87_list.get(0);
		Assert.assertNotNull(CastExpression_88_Var
		);
		//88
		final UnaryExpression UnaryExpression_89_Var
		 = (UnaryExpression)CastExpression_88_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_89_Var
		);
		//89
		final PostfixExpression PostfixExpression_90_Var
		 = (PostfixExpression)UnaryExpression_89_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = PostfixExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final PrimaryExpression PrimaryExpression_91_Var
		 = (PrimaryExpression)Expr_90_list.get(0);
		Assert.assertNotNull(PrimaryExpression_91_Var
		);
		Assert.assertEquals("[\"Joe Nobody\"]", PrimaryExpression_91_Var
		.getString().toString());
		//91
		final ExternalDeclaration ExternalDeclaration_92_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_92_Var
		);
		//92
		final Declaration Declaration_93_Var
		 = (Declaration)ExternalDeclaration_92_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_93_Var
		);
		//93
		final DeclarationSpecifiers DeclarationSpecifiers_94_Var
		 = (DeclarationSpecifiers)Declaration_93_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_94_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_94_list = DeclarationSpecifiers_94_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_94_list);
		Assert.assertEquals(1, DeclarationSpecifier_94_list.size());
		//94
		final TypeSpecifier TypeSpecifier_95_Var
		 = (TypeSpecifier)DeclarationSpecifier_94_list.get(0);
		Assert.assertNotNull(TypeSpecifier_95_Var
		);
		//95
		final TypedefName TypedefName_96_Var
		 = (TypedefName)TypeSpecifier_95_Var
		.getType();
		Assert.assertNotNull(TypedefName_96_Var
		);
		Assert.assertEquals("employee", TypedefName_96_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_96_list = Declaration_93_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_96_list);
		Assert.assertEquals(1, InitDeclaratorList_96_list.size());
		//96
		final InitDeclaratorList InitDeclaratorList_97_Var
		 = (InitDeclaratorList)InitDeclaratorList_96_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_97_Var
		);
		final EList<? extends EObject> InitDeclarator_97_list = InitDeclaratorList_97_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_97_list);
		Assert.assertEquals(1, InitDeclarator_97_list.size());
		//97
		final InitDeclarator InitDeclarator_98_Var
		 = (InitDeclarator)InitDeclarator_97_list.get(0);
		Assert.assertNotNull(InitDeclarator_98_Var
		);
		//98
		final Declarator Declarator_99_Var
		 = (Declarator)InitDeclarator_98_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_99_Var
		);
		//99
		final DirectDeclarator DirectDeclarator_100_Var
		 = (DirectDeclarator)Declarator_99_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_100_Var
		);
		Assert.assertEquals("phil", DirectDeclarator_100_Var
		.getId());
		//100
		final Initializer Initializer_101_Var
		 = (Initializer)InitDeclarator_98_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_101_Var
		);
		//101
		final InitializerList InitializerList_102_Var
		 = (InitializerList)Initializer_101_Var
		.getList();
		Assert.assertNotNull(InitializerList_102_Var
		);
		final EList<? extends EObject> Initializer_102_list = InitializerList_102_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_102_list);
		Assert.assertEquals(2, Initializer_102_list.size());
		//102
		final Initializer Initializer_103_Var
		 = (Initializer)Initializer_102_list.get(0);
		Assert.assertNotNull(Initializer_103_Var
		);
		//103
		final AssignmentExpression AssignmentExpression_104_Var
		 = (AssignmentExpression)Initializer_103_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_104_Var
		);
		//104
		final ConditionalExpression ConditionalExpression_105_Var
		 = (ConditionalExpression)AssignmentExpression_104_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_105_Var
		);
		//105
		final LogicalOrExpression LogicalOrExpression_106_Var
		 = (LogicalOrExpression)ConditionalExpression_105_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = LogicalOrExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final LogicalAndExpression LogicalAndExpression_107_Var
		 = (LogicalAndExpression)Expr_106_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = LogicalAndExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final InclusiveOrExpression InclusiveOrExpression_108_Var
		 = (InclusiveOrExpression)Expr_107_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = InclusiveOrExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final ExclusiveOrExpression ExclusiveOrExpression_109_Var
		 = (ExclusiveOrExpression)Expr_108_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = ExclusiveOrExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final AndExpression AndExpression_110_Var
		 = (AndExpression)Expr_109_list.get(0);
		Assert.assertNotNull(AndExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = AndExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final EqualityExpression EqualityExpression_111_Var
		 = (EqualityExpression)Expr_110_list.get(0);
		Assert.assertNotNull(EqualityExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = EqualityExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final RelationalExpression RelationalExpression_112_Var
		 = (RelationalExpression)Expr_111_list.get(0);
		Assert.assertNotNull(RelationalExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = RelationalExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final ShiftExpression ShiftExpression_113_Var
		 = (ShiftExpression)Expr_112_list.get(0);
		Assert.assertNotNull(ShiftExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = ShiftExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final AdditiveExpression AdditiveExpression_114_Var
		 = (AdditiveExpression)Expr_113_list.get(0);
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
		Assert.assertEquals("0x008", Constant2_120_Var
		.getHex());
		//120
		final Initializer Initializer_121_Var
		 = (Initializer)Initializer_102_list.get(1);
		Assert.assertNotNull(Initializer_121_Var
		);
		//121
		final AssignmentExpression AssignmentExpression_122_Var
		 = (AssignmentExpression)Initializer_121_Var
		.getExpr();
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
		Assert.assertEquals(1, Expr_130_list.size());
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
		Assert.assertEquals("[\"Phil Morrison\"]", PrimaryExpression_137_Var
		.getString().toString());
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
		Assert.assertEquals("[\"(*employee).id=%d\\n\"]", PrimaryExpression_194_Var
		.getString().toString());
		//194
		final AssignmentExpression AssignmentExpression_195_Var
		 = (AssignmentExpression)Expr_178_list.get(1);
		Assert.assertNotNull(AssignmentExpression_195_Var
		);
		//195
		final ConditionalExpression ConditionalExpression_196_Var
		 = (ConditionalExpression)AssignmentExpression_195_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_196_Var
		);
		//196
		final LogicalOrExpression LogicalOrExpression_197_Var
		 = (LogicalOrExpression)ConditionalExpression_196_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = LogicalOrExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final LogicalAndExpression LogicalAndExpression_198_Var
		 = (LogicalAndExpression)Expr_197_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = LogicalAndExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final InclusiveOrExpression InclusiveOrExpression_199_Var
		 = (InclusiveOrExpression)Expr_198_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = InclusiveOrExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final ExclusiveOrExpression ExclusiveOrExpression_200_Var
		 = (ExclusiveOrExpression)Expr_199_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = ExclusiveOrExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final AndExpression AndExpression_201_Var
		 = (AndExpression)Expr_200_list.get(0);
		Assert.assertNotNull(AndExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = AndExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final EqualityExpression EqualityExpression_202_Var
		 = (EqualityExpression)Expr_201_list.get(0);
		Assert.assertNotNull(EqualityExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = EqualityExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final RelationalExpression RelationalExpression_203_Var
		 = (RelationalExpression)Expr_202_list.get(0);
		Assert.assertNotNull(RelationalExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = RelationalExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final ShiftExpression ShiftExpression_204_Var
		 = (ShiftExpression)Expr_203_list.get(0);
		Assert.assertNotNull(ShiftExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = ShiftExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final AdditiveExpression AdditiveExpression_205_Var
		 = (AdditiveExpression)Expr_204_list.get(0);
		Assert.assertNotNull(AdditiveExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = AdditiveExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final MultiplicativeExpression MultiplicativeExpression_206_Var
		 = (MultiplicativeExpression)Expr_205_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = MultiplicativeExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final CastExpression CastExpression_207_Var
		 = (CastExpression)Expr_206_list.get(0);
		Assert.assertNotNull(CastExpression_207_Var
		);
		//207
		final UnaryExpression UnaryExpression_208_Var
		 = (UnaryExpression)CastExpression_207_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_208_Var
		);
		//208
		final PostfixExpression PostfixExpression_209_Var
		 = (PostfixExpression)UnaryExpression_208_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = PostfixExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final PrimaryExpression PrimaryExpression_210_Var
		 = (PrimaryExpression)Expr_209_list.get(0);
		Assert.assertNotNull(PrimaryExpression_210_Var
		);
		//210
		final Expression Expression_211_Var
		 = (Expression)PrimaryExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expression_211_Var
		);
		final EList<? extends EObject> ExprExpr_211_list = Expression_211_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_211_list);
		Assert.assertEquals(1, ExprExpr_211_list.size());
		//211
		final AssignmentExpression AssignmentExpression_212_Var
		 = (AssignmentExpression)ExprExpr_211_list.get(0);
		Assert.assertNotNull(AssignmentExpression_212_Var
		);
		//212
		final ConditionalExpression ConditionalExpression_213_Var
		 = (ConditionalExpression)AssignmentExpression_212_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_213_Var
		);
		//213
		final LogicalOrExpression LogicalOrExpression_214_Var
		 = (LogicalOrExpression)ConditionalExpression_213_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = LogicalOrExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final LogicalAndExpression LogicalAndExpression_215_Var
		 = (LogicalAndExpression)Expr_214_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = LogicalAndExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final InclusiveOrExpression InclusiveOrExpression_216_Var
		 = (InclusiveOrExpression)Expr_215_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = InclusiveOrExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final ExclusiveOrExpression ExclusiveOrExpression_217_Var
		 = (ExclusiveOrExpression)Expr_216_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = ExclusiveOrExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final AndExpression AndExpression_218_Var
		 = (AndExpression)Expr_217_list.get(0);
		Assert.assertNotNull(AndExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = AndExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final EqualityExpression EqualityExpression_219_Var
		 = (EqualityExpression)Expr_218_list.get(0);
		Assert.assertNotNull(EqualityExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = EqualityExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final RelationalExpression RelationalExpression_220_Var
		 = (RelationalExpression)Expr_219_list.get(0);
		Assert.assertNotNull(RelationalExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = RelationalExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final ShiftExpression ShiftExpression_221_Var
		 = (ShiftExpression)Expr_220_list.get(0);
		Assert.assertNotNull(ShiftExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = ShiftExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final AdditiveExpression AdditiveExpression_222_Var
		 = (AdditiveExpression)Expr_221_list.get(0);
		Assert.assertNotNull(AdditiveExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = AdditiveExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final MultiplicativeExpression MultiplicativeExpression_223_Var
		 = (MultiplicativeExpression)Expr_222_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = MultiplicativeExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final CastExpression CastExpression_224_Var
		 = (CastExpression)Expr_223_list.get(0);
		Assert.assertNotNull(CastExpression_224_Var
		);
		//224
		final UnaryExpression UnaryExpression_225_Var
		 = (UnaryExpression)CastExpression_224_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_225_Var
		);
		//225
		final UnaryOperator UnaryOperator_226_Var
		 = (UnaryOperator)UnaryExpression_225_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_226_Var
		);
		Assert.assertEquals("*", UnaryOperator_226_Var
		.getOp());
		//226
		final CastExpression CastExpression_227_Var
		 = (CastExpression)UnaryExpression_225_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_227_Var
		);
		//227
		final UnaryExpression UnaryExpression_228_Var
		 = (UnaryExpression)CastExpression_227_Var
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
		Assert.assertEquals("emp", PrimaryExpression_230_Var
		.getId());
		final EList<? extends EObject> Suffix_230_list = PostfixExpression_209_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_230_list);
		Assert.assertEquals(1, Suffix_230_list.size());
		//230
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_231_Var
		 = (PostfixExpressionSuffixDot)Suffix_230_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_231_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_231_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_159_Var
		.getSemi());
		//231
		final Statement Statement_232_Var
		 = (Statement)Statement_157_list.get(1);
		Assert.assertNotNull(Statement_232_Var
		);
		//232
		final ExpressionStatement ExpressionStatement_233_Var
		 = (ExpressionStatement)Statement_232_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_233_Var
		);
		//233
		final Expression Expression_234_Var
		 = (Expression)ExpressionStatement_233_Var
		.getExpression();
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
		Assert.assertEquals("printf", PrimaryExpression_250_Var
		.getId());
		final EList<? extends EObject> Suffix_250_list = PostfixExpression_249_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_250_list);
		Assert.assertEquals(1, Suffix_250_list.size());
		//250
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_251_Var
		 = (PostfixExpressionSuffixArgument)Suffix_250_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_251_Var
		);
		//251
		final ArgumentExpressionList ArgumentExpressionList_252_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_251_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_252_Var
		);
		final EList<? extends EObject> Expr_252_list = ArgumentExpressionList_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(2, Expr_252_list.size());
		//252
		final AssignmentExpression AssignmentExpression_253_Var
		 = (AssignmentExpression)Expr_252_list.get(0);
		Assert.assertNotNull(AssignmentExpression_253_Var
		);
		//253
		final ConditionalExpression ConditionalExpression_254_Var
		 = (ConditionalExpression)AssignmentExpression_253_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_254_Var
		);
		//254
		final LogicalOrExpression LogicalOrExpression_255_Var
		 = (LogicalOrExpression)ConditionalExpression_254_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_255_Var
		);
		final EList<? extends EObject> Expr_255_list = LogicalOrExpression_255_Var
		.getExpr();
		Assert.assertNotNull(Expr_255_list);
		Assert.assertEquals(1, Expr_255_list.size());
		//255
		final LogicalAndExpression LogicalAndExpression_256_Var
		 = (LogicalAndExpression)Expr_255_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_256_Var
		);
		final EList<? extends EObject> Expr_256_list = LogicalAndExpression_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(1, Expr_256_list.size());
		//256
		final InclusiveOrExpression InclusiveOrExpression_257_Var
		 = (InclusiveOrExpression)Expr_256_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = InclusiveOrExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final ExclusiveOrExpression ExclusiveOrExpression_258_Var
		 = (ExclusiveOrExpression)Expr_257_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_258_Var
		);
		final EList<? extends EObject> Expr_258_list = ExclusiveOrExpression_258_Var
		.getExpr();
		Assert.assertNotNull(Expr_258_list);
		Assert.assertEquals(1, Expr_258_list.size());
		//258
		final AndExpression AndExpression_259_Var
		 = (AndExpression)Expr_258_list.get(0);
		Assert.assertNotNull(AndExpression_259_Var
		);
		final EList<? extends EObject> Expr_259_list = AndExpression_259_Var
		.getExpr();
		Assert.assertNotNull(Expr_259_list);
		Assert.assertEquals(1, Expr_259_list.size());
		//259
		final EqualityExpression EqualityExpression_260_Var
		 = (EqualityExpression)Expr_259_list.get(0);
		Assert.assertNotNull(EqualityExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = EqualityExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final RelationalExpression RelationalExpression_261_Var
		 = (RelationalExpression)Expr_260_list.get(0);
		Assert.assertNotNull(RelationalExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = RelationalExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final ShiftExpression ShiftExpression_262_Var
		 = (ShiftExpression)Expr_261_list.get(0);
		Assert.assertNotNull(ShiftExpression_262_Var
		);
		final EList<? extends EObject> Expr_262_list = ShiftExpression_262_Var
		.getExpr();
		Assert.assertNotNull(Expr_262_list);
		Assert.assertEquals(1, Expr_262_list.size());
		//262
		final AdditiveExpression AdditiveExpression_263_Var
		 = (AdditiveExpression)Expr_262_list.get(0);
		Assert.assertNotNull(AdditiveExpression_263_Var
		);
		final EList<? extends EObject> Expr_263_list = AdditiveExpression_263_Var
		.getExpr();
		Assert.assertNotNull(Expr_263_list);
		Assert.assertEquals(1, Expr_263_list.size());
		//263
		final MultiplicativeExpression MultiplicativeExpression_264_Var
		 = (MultiplicativeExpression)Expr_263_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_264_Var
		);
		final EList<? extends EObject> Expr_264_list = MultiplicativeExpression_264_Var
		.getExpr();
		Assert.assertNotNull(Expr_264_list);
		Assert.assertEquals(1, Expr_264_list.size());
		//264
		final CastExpression CastExpression_265_Var
		 = (CastExpression)Expr_264_list.get(0);
		Assert.assertNotNull(CastExpression_265_Var
		);
		//265
		final UnaryExpression UnaryExpression_266_Var
		 = (UnaryExpression)CastExpression_265_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_266_Var
		);
		//266
		final PostfixExpression PostfixExpression_267_Var
		 = (PostfixExpression)UnaryExpression_266_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_267_Var
		);
		final EList<? extends EObject> Expr_267_list = PostfixExpression_267_Var
		.getExpr();
		Assert.assertNotNull(Expr_267_list);
		Assert.assertEquals(1, Expr_267_list.size());
		//267
		final PrimaryExpression PrimaryExpression_268_Var
		 = (PrimaryExpression)Expr_267_list.get(0);
		Assert.assertNotNull(PrimaryExpression_268_Var
		);
		Assert.assertEquals("[\"employee->name=%s\\n\"]", PrimaryExpression_268_Var
		.getString().toString());
		//268
		final AssignmentExpression AssignmentExpression_269_Var
		 = (AssignmentExpression)Expr_252_list.get(1);
		Assert.assertNotNull(AssignmentExpression_269_Var
		);
		//269
		final ConditionalExpression ConditionalExpression_270_Var
		 = (ConditionalExpression)AssignmentExpression_269_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_270_Var
		);
		//270
		final LogicalOrExpression LogicalOrExpression_271_Var
		 = (LogicalOrExpression)ConditionalExpression_270_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_271_Var
		);
		final EList<? extends EObject> Expr_271_list = LogicalOrExpression_271_Var
		.getExpr();
		Assert.assertNotNull(Expr_271_list);
		Assert.assertEquals(1, Expr_271_list.size());
		//271
		final LogicalAndExpression LogicalAndExpression_272_Var
		 = (LogicalAndExpression)Expr_271_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_272_Var
		);
		final EList<? extends EObject> Expr_272_list = LogicalAndExpression_272_Var
		.getExpr();
		Assert.assertNotNull(Expr_272_list);
		Assert.assertEquals(1, Expr_272_list.size());
		//272
		final InclusiveOrExpression InclusiveOrExpression_273_Var
		 = (InclusiveOrExpression)Expr_272_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_273_Var
		);
		final EList<? extends EObject> Expr_273_list = InclusiveOrExpression_273_Var
		.getExpr();
		Assert.assertNotNull(Expr_273_list);
		Assert.assertEquals(1, Expr_273_list.size());
		//273
		final ExclusiveOrExpression ExclusiveOrExpression_274_Var
		 = (ExclusiveOrExpression)Expr_273_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_274_Var
		);
		final EList<? extends EObject> Expr_274_list = ExclusiveOrExpression_274_Var
		.getExpr();
		Assert.assertNotNull(Expr_274_list);
		Assert.assertEquals(1, Expr_274_list.size());
		//274
		final AndExpression AndExpression_275_Var
		 = (AndExpression)Expr_274_list.get(0);
		Assert.assertNotNull(AndExpression_275_Var
		);
		final EList<? extends EObject> Expr_275_list = AndExpression_275_Var
		.getExpr();
		Assert.assertNotNull(Expr_275_list);
		Assert.assertEquals(1, Expr_275_list.size());
		//275
		final EqualityExpression EqualityExpression_276_Var
		 = (EqualityExpression)Expr_275_list.get(0);
		Assert.assertNotNull(EqualityExpression_276_Var
		);
		final EList<? extends EObject> Expr_276_list = EqualityExpression_276_Var
		.getExpr();
		Assert.assertNotNull(Expr_276_list);
		Assert.assertEquals(1, Expr_276_list.size());
		//276
		final RelationalExpression RelationalExpression_277_Var
		 = (RelationalExpression)Expr_276_list.get(0);
		Assert.assertNotNull(RelationalExpression_277_Var
		);
		final EList<? extends EObject> Expr_277_list = RelationalExpression_277_Var
		.getExpr();
		Assert.assertNotNull(Expr_277_list);
		Assert.assertEquals(1, Expr_277_list.size());
		//277
		final ShiftExpression ShiftExpression_278_Var
		 = (ShiftExpression)Expr_277_list.get(0);
		Assert.assertNotNull(ShiftExpression_278_Var
		);
		final EList<? extends EObject> Expr_278_list = ShiftExpression_278_Var
		.getExpr();
		Assert.assertNotNull(Expr_278_list);
		Assert.assertEquals(1, Expr_278_list.size());
		//278
		final AdditiveExpression AdditiveExpression_279_Var
		 = (AdditiveExpression)Expr_278_list.get(0);
		Assert.assertNotNull(AdditiveExpression_279_Var
		);
		final EList<? extends EObject> Expr_279_list = AdditiveExpression_279_Var
		.getExpr();
		Assert.assertNotNull(Expr_279_list);
		Assert.assertEquals(1, Expr_279_list.size());
		//279
		final MultiplicativeExpression MultiplicativeExpression_280_Var
		 = (MultiplicativeExpression)Expr_279_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_280_Var
		);
		final EList<? extends EObject> Expr_280_list = MultiplicativeExpression_280_Var
		.getExpr();
		Assert.assertNotNull(Expr_280_list);
		Assert.assertEquals(1, Expr_280_list.size());
		//280
		final CastExpression CastExpression_281_Var
		 = (CastExpression)Expr_280_list.get(0);
		Assert.assertNotNull(CastExpression_281_Var
		);
		//281
		final UnaryExpression UnaryExpression_282_Var
		 = (UnaryExpression)CastExpression_281_Var
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
		Assert.assertEquals("emp", PrimaryExpression_284_Var
		.getId());
		final EList<? extends EObject> Suffix_284_list = PostfixExpression_283_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_284_list);
		Assert.assertEquals(1, Suffix_284_list.size());
		//284
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_285_Var
		 = (PostfixExpressionSuffixArrow)Suffix_284_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArrow_285_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixArrow_285_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_233_Var
		.getSemi());
		//285
		final ExternalDeclaration ExternalDeclaration_286_Var
		 = (ExternalDeclaration)External_0_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_286_Var
		);
		//286
		final FunctionDefHead FunctionDefHead_287_Var
		 = (FunctionDefHead)ExternalDeclaration_286_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_287_Var
		);
		//287
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_288_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_287_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_288_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_288_list = FunctionDeclarationSpecifiers_288_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_288_list);
		Assert.assertEquals(1, DeclarationSpecifier_288_list.size());
		//288
		final TypeSpecifier TypeSpecifier_289_Var
		 = (TypeSpecifier)DeclarationSpecifier_288_list.get(0);
		Assert.assertNotNull(TypeSpecifier_289_Var
		);
		Assert.assertEquals("int", TypeSpecifier_289_Var
		.getName());
		//289
		final Declarator Declarator_290_Var
		 = (Declarator)FunctionDefHead_287_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_290_Var
		);
		//290
		final DirectDeclarator DirectDeclarator_291_Var
		 = (DirectDeclarator)Declarator_290_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_291_Var
		);
		Assert.assertEquals("main", DirectDeclarator_291_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_291_list = DirectDeclarator_291_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_291_list);
		Assert.assertEquals(1, DeclaratorSuffix_291_list.size());
		//291
		final DeclaratorSuffix DeclaratorSuffix_292_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_291_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_292_Var
		);
		//292
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_293_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_292_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_293_Var
		);
		final EList<? extends EObject> ParameterTypeList_293_list = DirectDeclaratorLastSuffix_293_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_293_list);
		Assert.assertEquals(1, ParameterTypeList_293_list.size());
		//293
		final ParameterTypeList ParameterTypeList_294_Var
		 = (ParameterTypeList)ParameterTypeList_293_list.get(0);
		Assert.assertNotNull(ParameterTypeList_294_Var
		);
		//294
		final ParameterList ParameterList_295_Var
		 = (ParameterList)ParameterTypeList_294_Var
		.getList();
		Assert.assertNotNull(ParameterList_295_Var
		);
		final EList<? extends EObject> ParameterDeclaration_295_list = ParameterList_295_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_295_list);
		Assert.assertEquals(1, ParameterDeclaration_295_list.size());
		//295
		final ParameterDeclaration ParameterDeclaration_296_Var
		 = (ParameterDeclaration)ParameterDeclaration_295_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_296_Var
		);
		//296
		final DeclarationSpecifiers DeclarationSpecifiers_297_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_296_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_297_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_297_list = DeclarationSpecifiers_297_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_297_list);
		Assert.assertEquals(1, DeclarationSpecifier_297_list.size());
		//297
		final TypeSpecifier TypeSpecifier_298_Var
		 = (TypeSpecifier)DeclarationSpecifier_297_list.get(0);
		Assert.assertNotNull(TypeSpecifier_298_Var
		);
		Assert.assertEquals("void", TypeSpecifier_298_Var
		.getName());
		//298
		final FunctionDefinition FunctionDefinition_299_Var
		 = (FunctionDefinition)ExternalDeclaration_286_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_299_Var
		);
		//299
		final BodyStatement BodyStatement_300_Var
		 = (BodyStatement)FunctionDefinition_299_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_300_Var
		);
		final EList<? extends EObject> BlockList_300_list = BodyStatement_300_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_300_list);
		Assert.assertEquals(1, BlockList_300_list.size());
		//300
		final BlockList BlockList_301_Var
		 = (BlockList)BlockList_300_list.get(0);
		Assert.assertNotNull(BlockList_301_Var
		);
		final EList<? extends EObject> Declaration_301_list = BlockList_301_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_301_list);
		Assert.assertEquals(1, Declaration_301_list.size());
		//301
		final Declaration Declaration_302_Var
		 = (Declaration)Declaration_301_list.get(0);
		Assert.assertNotNull(Declaration_302_Var
		);
		//302
		final DeclarationSpecifiers DeclarationSpecifiers_303_Var
		 = (DeclarationSpecifiers)Declaration_302_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_303_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_303_list = DeclarationSpecifiers_303_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_303_list);
		Assert.assertEquals(1, DeclarationSpecifier_303_list.size());
		//303
		final TypeSpecifier TypeSpecifier_304_Var
		 = (TypeSpecifier)DeclarationSpecifier_303_list.get(0);
		Assert.assertNotNull(TypeSpecifier_304_Var
		);
		//304
		final TypedefName TypedefName_305_Var
		 = (TypedefName)TypeSpecifier_304_Var
		.getType();
		Assert.assertNotNull(TypedefName_305_Var
		);
		Assert.assertEquals("employee", TypedefName_305_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_305_list = Declaration_302_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_305_list);
		Assert.assertEquals(1, InitDeclaratorList_305_list.size());
		//305
		final InitDeclaratorList InitDeclaratorList_306_Var
		 = (InitDeclaratorList)InitDeclaratorList_305_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_306_Var
		);
		final EList<? extends EObject> InitDeclarator_306_list = InitDeclaratorList_306_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_306_list);
		Assert.assertEquals(1, InitDeclarator_306_list.size());
		//306
		final InitDeclarator InitDeclarator_307_Var
		 = (InitDeclarator)InitDeclarator_306_list.get(0);
		Assert.assertNotNull(InitDeclarator_307_Var
		);
		//307
		final Declarator Declarator_308_Var
		 = (Declarator)InitDeclarator_307_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_308_Var
		);
		//308
		final Pointer Pointer_309_Var
		 = (Pointer)Declarator_308_Var
		.getPointer();
		Assert.assertNotNull(Pointer_309_Var
		);
		Assert.assertEquals("[*]", Pointer_309_Var
		.getStar().toString());
		//309
		final DirectDeclarator DirectDeclarator_310_Var
		 = (DirectDeclarator)Declarator_308_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_310_Var
		);
		Assert.assertEquals("newEmployee", DirectDeclarator_310_Var
		.getId());
		//310
		final Initializer Initializer_311_Var
		 = (Initializer)InitDeclarator_307_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_311_Var
		);
		//311
		final AssignmentExpression AssignmentExpression_312_Var
		 = (AssignmentExpression)Initializer_311_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_312_Var
		);
		//312
		final ConditionalExpression ConditionalExpression_313_Var
		 = (ConditionalExpression)AssignmentExpression_312_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_313_Var
		);
		//313
		final LogicalOrExpression LogicalOrExpression_314_Var
		 = (LogicalOrExpression)ConditionalExpression_313_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = LogicalOrExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final LogicalAndExpression LogicalAndExpression_315_Var
		 = (LogicalAndExpression)Expr_314_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = LogicalAndExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final InclusiveOrExpression InclusiveOrExpression_316_Var
		 = (InclusiveOrExpression)Expr_315_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_316_Var
		);
		final EList<? extends EObject> Expr_316_list = InclusiveOrExpression_316_Var
		.getExpr();
		Assert.assertNotNull(Expr_316_list);
		Assert.assertEquals(1, Expr_316_list.size());
		//316
		final ExclusiveOrExpression ExclusiveOrExpression_317_Var
		 = (ExclusiveOrExpression)Expr_316_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_317_Var
		);
		final EList<? extends EObject> Expr_317_list = ExclusiveOrExpression_317_Var
		.getExpr();
		Assert.assertNotNull(Expr_317_list);
		Assert.assertEquals(1, Expr_317_list.size());
		//317
		final AndExpression AndExpression_318_Var
		 = (AndExpression)Expr_317_list.get(0);
		Assert.assertNotNull(AndExpression_318_Var
		);
		final EList<? extends EObject> Expr_318_list = AndExpression_318_Var
		.getExpr();
		Assert.assertNotNull(Expr_318_list);
		Assert.assertEquals(1, Expr_318_list.size());
		//318
		final EqualityExpression EqualityExpression_319_Var
		 = (EqualityExpression)Expr_318_list.get(0);
		Assert.assertNotNull(EqualityExpression_319_Var
		);
		final EList<? extends EObject> Expr_319_list = EqualityExpression_319_Var
		.getExpr();
		Assert.assertNotNull(Expr_319_list);
		Assert.assertEquals(1, Expr_319_list.size());
		//319
		final RelationalExpression RelationalExpression_320_Var
		 = (RelationalExpression)Expr_319_list.get(0);
		Assert.assertNotNull(RelationalExpression_320_Var
		);
		final EList<? extends EObject> Expr_320_list = RelationalExpression_320_Var
		.getExpr();
		Assert.assertNotNull(Expr_320_list);
		Assert.assertEquals(1, Expr_320_list.size());
		//320
		final ShiftExpression ShiftExpression_321_Var
		 = (ShiftExpression)Expr_320_list.get(0);
		Assert.assertNotNull(ShiftExpression_321_Var
		);
		final EList<? extends EObject> Expr_321_list = ShiftExpression_321_Var
		.getExpr();
		Assert.assertNotNull(Expr_321_list);
		Assert.assertEquals(1, Expr_321_list.size());
		//321
		final AdditiveExpression AdditiveExpression_322_Var
		 = (AdditiveExpression)Expr_321_list.get(0);
		Assert.assertNotNull(AdditiveExpression_322_Var
		);
		final EList<? extends EObject> Expr_322_list = AdditiveExpression_322_Var
		.getExpr();
		Assert.assertNotNull(Expr_322_list);
		Assert.assertEquals(1, Expr_322_list.size());
		//322
		final MultiplicativeExpression MultiplicativeExpression_323_Var
		 = (MultiplicativeExpression)Expr_322_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_323_Var
		);
		final EList<? extends EObject> Expr_323_list = MultiplicativeExpression_323_Var
		.getExpr();
		Assert.assertNotNull(Expr_323_list);
		Assert.assertEquals(1, Expr_323_list.size());
		//323
		final CastExpression CastExpression_324_Var
		 = (CastExpression)Expr_323_list.get(0);
		Assert.assertNotNull(CastExpression_324_Var
		);
		//324
		final UnaryExpression UnaryExpression_325_Var
		 = (UnaryExpression)CastExpression_324_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_325_Var
		);
		//325
		final PostfixExpression PostfixExpression_326_Var
		 = (PostfixExpression)UnaryExpression_325_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_326_Var
		);
		final EList<? extends EObject> Expr_326_list = PostfixExpression_326_Var
		.getExpr();
		Assert.assertNotNull(Expr_326_list);
		Assert.assertEquals(1, Expr_326_list.size());
		//326
		final PrimaryExpression PrimaryExpression_327_Var
		 = (PrimaryExpression)Expr_326_list.get(0);
		Assert.assertNotNull(PrimaryExpression_327_Var
		);
		Assert.assertEquals("malloc", PrimaryExpression_327_Var
		.getId());
		final EList<? extends EObject> Suffix_327_list = PostfixExpression_326_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_327_list);
		Assert.assertEquals(1, Suffix_327_list.size());
		//327
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_328_Var
		 = (PostfixExpressionSuffixArgument)Suffix_327_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_328_Var
		);
		//328
		final ArgumentExpressionList ArgumentExpressionList_329_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_328_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_329_Var
		);
		final EList<? extends EObject> Expr_329_list = ArgumentExpressionList_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final AssignmentExpression AssignmentExpression_330_Var
		 = (AssignmentExpression)Expr_329_list.get(0);
		Assert.assertNotNull(AssignmentExpression_330_Var
		);
		//330
		final ConditionalExpression ConditionalExpression_331_Var
		 = (ConditionalExpression)AssignmentExpression_330_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_331_Var
		);
		//331
		final LogicalOrExpression LogicalOrExpression_332_Var
		 = (LogicalOrExpression)ConditionalExpression_331_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_332_Var
		);
		final EList<? extends EObject> Expr_332_list = LogicalOrExpression_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final LogicalAndExpression LogicalAndExpression_333_Var
		 = (LogicalAndExpression)Expr_332_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = LogicalAndExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final InclusiveOrExpression InclusiveOrExpression_334_Var
		 = (InclusiveOrExpression)Expr_333_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = InclusiveOrExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final ExclusiveOrExpression ExclusiveOrExpression_335_Var
		 = (ExclusiveOrExpression)Expr_334_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = ExclusiveOrExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final AndExpression AndExpression_336_Var
		 = (AndExpression)Expr_335_list.get(0);
		Assert.assertNotNull(AndExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = AndExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final EqualityExpression EqualityExpression_337_Var
		 = (EqualityExpression)Expr_336_list.get(0);
		Assert.assertNotNull(EqualityExpression_337_Var
		);
		final EList<? extends EObject> Expr_337_list = EqualityExpression_337_Var
		.getExpr();
		Assert.assertNotNull(Expr_337_list);
		Assert.assertEquals(1, Expr_337_list.size());
		//337
		final RelationalExpression RelationalExpression_338_Var
		 = (RelationalExpression)Expr_337_list.get(0);
		Assert.assertNotNull(RelationalExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = RelationalExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final ShiftExpression ShiftExpression_339_Var
		 = (ShiftExpression)Expr_338_list.get(0);
		Assert.assertNotNull(ShiftExpression_339_Var
		);
		final EList<? extends EObject> Expr_339_list = ShiftExpression_339_Var
		.getExpr();
		Assert.assertNotNull(Expr_339_list);
		Assert.assertEquals(1, Expr_339_list.size());
		//339
		final AdditiveExpression AdditiveExpression_340_Var
		 = (AdditiveExpression)Expr_339_list.get(0);
		Assert.assertNotNull(AdditiveExpression_340_Var
		);
		final EList<? extends EObject> Expr_340_list = AdditiveExpression_340_Var
		.getExpr();
		Assert.assertNotNull(Expr_340_list);
		Assert.assertEquals(1, Expr_340_list.size());
		//340
		final MultiplicativeExpression MultiplicativeExpression_341_Var
		 = (MultiplicativeExpression)Expr_340_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_341_Var
		);
		final EList<? extends EObject> Expr_341_list = MultiplicativeExpression_341_Var
		.getExpr();
		Assert.assertNotNull(Expr_341_list);
		Assert.assertEquals(1, Expr_341_list.size());
		//341
		final CastExpression CastExpression_342_Var
		 = (CastExpression)Expr_341_list.get(0);
		Assert.assertNotNull(CastExpression_342_Var
		);
		//342
		final UnaryExpression UnaryExpression_343_Var
		 = (UnaryExpression)CastExpression_342_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_343_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_343_Var
		.getSizeOf());
		//343
		final TypeName TypeName_344_Var
		 = (TypeName)UnaryExpression_343_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_344_Var
		);
		//344
		final SpecifierQualifierList SpecifierQualifierList_345_Var
		 = (SpecifierQualifierList)TypeName_344_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_345_Var
		);
		final EList<? extends EObject> TypeSpecifier_345_list = SpecifierQualifierList_345_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_345_list);
		Assert.assertEquals(1, TypeSpecifier_345_list.size());
		//345
		final TypeSpecifier TypeSpecifier_346_Var
		 = (TypeSpecifier)TypeSpecifier_345_list.get(0);
		Assert.assertNotNull(TypeSpecifier_346_Var
		);
		//346
		final TypedefName TypedefName_347_Var
		 = (TypedefName)TypeSpecifier_346_Var
		.getType();
		Assert.assertNotNull(TypedefName_347_Var
		);
		Assert.assertEquals("employee", TypedefName_347_Var
		.getId());
		final EList<? extends EObject> Statement_347_list = BlockList_301_Var
		.getStatement();
		Assert.assertNotNull(Statement_347_list);
		Assert.assertEquals(8, Statement_347_list.size());
		//347
		final Statement Statement_348_Var
		 = (Statement)Statement_347_list.get(0);
		Assert.assertNotNull(Statement_348_Var
		);
		//348
		final SelectionStatement SelectionStatement_349_Var
		 = (SelectionStatement)Statement_348_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_349_Var
		);
		Assert.assertEquals("if", SelectionStatement_349_Var
		.getIf());
		//349
		final Expression Expression_350_Var
		 = (Expression)SelectionStatement_349_Var
		.getExpr();
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
		Assert.assertEquals("[==]", EqualityExpression_358_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_358_list = EqualityExpression_358_Var
		.getExpr();
		Assert.assertNotNull(Expr_358_list);
		Assert.assertEquals(2, Expr_358_list.size());
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
		Assert.assertEquals("newEmployee", PrimaryExpression_366_Var
		.getId());
		//366
		final RelationalExpression RelationalExpression_367_Var
		 = (RelationalExpression)Expr_358_list.get(1);
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
		Assert.assertEquals("NULL", PrimaryExpression_374_Var
		.getId());
		//374
		final Statement Statement_375_Var
		 = (Statement)SelectionStatement_349_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_375_Var
		);
		//375
		final CompoundStatement CompoundStatement_376_Var
		 = (CompoundStatement)Statement_375_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_376_Var
		);
		//376
		final BodyStatement BodyStatement_377_Var
		 = (BodyStatement)CompoundStatement_376_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_377_Var
		);
		final EList<? extends EObject> BlockList_377_list = BodyStatement_377_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_377_list);
		Assert.assertEquals(1, BlockList_377_list.size());
		//377
		final BlockList BlockList_378_Var
		 = (BlockList)BlockList_377_list.get(0);
		Assert.assertNotNull(BlockList_378_Var
		);
		final EList<? extends EObject> Statement_378_list = BlockList_378_Var
		.getStatement();
		Assert.assertNotNull(Statement_378_list);
		Assert.assertEquals(2, Statement_378_list.size());
		//378
		final Statement Statement_379_Var
		 = (Statement)Statement_378_list.get(0);
		Assert.assertNotNull(Statement_379_Var
		);
		//379
		final ExpressionStatement ExpressionStatement_380_Var
		 = (ExpressionStatement)Statement_379_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_380_Var
		);
		//380
		final Expression Expression_381_Var
		 = (Expression)ExpressionStatement_380_Var
		.getExpression();
		Assert.assertNotNull(Expression_381_Var
		);
		final EList<? extends EObject> ExprExpr_381_list = Expression_381_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_381_list);
		Assert.assertEquals(1, ExprExpr_381_list.size());
		//381
		final AssignmentExpression AssignmentExpression_382_Var
		 = (AssignmentExpression)ExprExpr_381_list.get(0);
		Assert.assertNotNull(AssignmentExpression_382_Var
		);
		//382
		final ConditionalExpression ConditionalExpression_383_Var
		 = (ConditionalExpression)AssignmentExpression_382_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_383_Var
		);
		//383
		final LogicalOrExpression LogicalOrExpression_384_Var
		 = (LogicalOrExpression)ConditionalExpression_383_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_384_Var
		);
		final EList<? extends EObject> Expr_384_list = LogicalOrExpression_384_Var
		.getExpr();
		Assert.assertNotNull(Expr_384_list);
		Assert.assertEquals(1, Expr_384_list.size());
		//384
		final LogicalAndExpression LogicalAndExpression_385_Var
		 = (LogicalAndExpression)Expr_384_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_385_Var
		);
		final EList<? extends EObject> Expr_385_list = LogicalAndExpression_385_Var
		.getExpr();
		Assert.assertNotNull(Expr_385_list);
		Assert.assertEquals(1, Expr_385_list.size());
		//385
		final InclusiveOrExpression InclusiveOrExpression_386_Var
		 = (InclusiveOrExpression)Expr_385_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_386_Var
		);
		final EList<? extends EObject> Expr_386_list = InclusiveOrExpression_386_Var
		.getExpr();
		Assert.assertNotNull(Expr_386_list);
		Assert.assertEquals(1, Expr_386_list.size());
		//386
		final ExclusiveOrExpression ExclusiveOrExpression_387_Var
		 = (ExclusiveOrExpression)Expr_386_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_387_Var
		);
		final EList<? extends EObject> Expr_387_list = ExclusiveOrExpression_387_Var
		.getExpr();
		Assert.assertNotNull(Expr_387_list);
		Assert.assertEquals(1, Expr_387_list.size());
		//387
		final AndExpression AndExpression_388_Var
		 = (AndExpression)Expr_387_list.get(0);
		Assert.assertNotNull(AndExpression_388_Var
		);
		final EList<? extends EObject> Expr_388_list = AndExpression_388_Var
		.getExpr();
		Assert.assertNotNull(Expr_388_list);
		Assert.assertEquals(1, Expr_388_list.size());
		//388
		final EqualityExpression EqualityExpression_389_Var
		 = (EqualityExpression)Expr_388_list.get(0);
		Assert.assertNotNull(EqualityExpression_389_Var
		);
		final EList<? extends EObject> Expr_389_list = EqualityExpression_389_Var
		.getExpr();
		Assert.assertNotNull(Expr_389_list);
		Assert.assertEquals(1, Expr_389_list.size());
		//389
		final RelationalExpression RelationalExpression_390_Var
		 = (RelationalExpression)Expr_389_list.get(0);
		Assert.assertNotNull(RelationalExpression_390_Var
		);
		final EList<? extends EObject> Expr_390_list = RelationalExpression_390_Var
		.getExpr();
		Assert.assertNotNull(Expr_390_list);
		Assert.assertEquals(1, Expr_390_list.size());
		//390
		final ShiftExpression ShiftExpression_391_Var
		 = (ShiftExpression)Expr_390_list.get(0);
		Assert.assertNotNull(ShiftExpression_391_Var
		);
		final EList<? extends EObject> Expr_391_list = ShiftExpression_391_Var
		.getExpr();
		Assert.assertNotNull(Expr_391_list);
		Assert.assertEquals(1, Expr_391_list.size());
		//391
		final AdditiveExpression AdditiveExpression_392_Var
		 = (AdditiveExpression)Expr_391_list.get(0);
		Assert.assertNotNull(AdditiveExpression_392_Var
		);
		final EList<? extends EObject> Expr_392_list = AdditiveExpression_392_Var
		.getExpr();
		Assert.assertNotNull(Expr_392_list);
		Assert.assertEquals(1, Expr_392_list.size());
		//392
		final MultiplicativeExpression MultiplicativeExpression_393_Var
		 = (MultiplicativeExpression)Expr_392_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_393_Var
		);
		final EList<? extends EObject> Expr_393_list = MultiplicativeExpression_393_Var
		.getExpr();
		Assert.assertNotNull(Expr_393_list);
		Assert.assertEquals(1, Expr_393_list.size());
		//393
		final CastExpression CastExpression_394_Var
		 = (CastExpression)Expr_393_list.get(0);
		Assert.assertNotNull(CastExpression_394_Var
		);
		//394
		final UnaryExpression UnaryExpression_395_Var
		 = (UnaryExpression)CastExpression_394_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_395_Var
		);
		//395
		final PostfixExpression PostfixExpression_396_Var
		 = (PostfixExpression)UnaryExpression_395_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_396_Var
		);
		final EList<? extends EObject> Expr_396_list = PostfixExpression_396_Var
		.getExpr();
		Assert.assertNotNull(Expr_396_list);
		Assert.assertEquals(1, Expr_396_list.size());
		//396
		final PrimaryExpression PrimaryExpression_397_Var
		 = (PrimaryExpression)Expr_396_list.get(0);
		Assert.assertNotNull(PrimaryExpression_397_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_397_Var
		.getId());
		final EList<? extends EObject> Suffix_397_list = PostfixExpression_396_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_397_list);
		Assert.assertEquals(1, Suffix_397_list.size());
		//397
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_398_Var
		 = (PostfixExpressionSuffixArgument)Suffix_397_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_398_Var
		);
		//398
		final ArgumentExpressionList ArgumentExpressionList_399_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_398_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_399_Var
		);
		final EList<? extends EObject> Expr_399_list = ArgumentExpressionList_399_Var
		.getExpr();
		Assert.assertNotNull(Expr_399_list);
		Assert.assertEquals(1, Expr_399_list.size());
		//399
		final AssignmentExpression AssignmentExpression_400_Var
		 = (AssignmentExpression)Expr_399_list.get(0);
		Assert.assertNotNull(AssignmentExpression_400_Var
		);
		//400
		final ConditionalExpression ConditionalExpression_401_Var
		 = (ConditionalExpression)AssignmentExpression_400_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_401_Var
		);
		//401
		final LogicalOrExpression LogicalOrExpression_402_Var
		 = (LogicalOrExpression)ConditionalExpression_401_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_402_Var
		);
		final EList<? extends EObject> Expr_402_list = LogicalOrExpression_402_Var
		.getExpr();
		Assert.assertNotNull(Expr_402_list);
		Assert.assertEquals(1, Expr_402_list.size());
		//402
		final LogicalAndExpression LogicalAndExpression_403_Var
		 = (LogicalAndExpression)Expr_402_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_403_Var
		);
		final EList<? extends EObject> Expr_403_list = LogicalAndExpression_403_Var
		.getExpr();
		Assert.assertNotNull(Expr_403_list);
		Assert.assertEquals(1, Expr_403_list.size());
		//403
		final InclusiveOrExpression InclusiveOrExpression_404_Var
		 = (InclusiveOrExpression)Expr_403_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_404_Var
		);
		final EList<? extends EObject> Expr_404_list = InclusiveOrExpression_404_Var
		.getExpr();
		Assert.assertNotNull(Expr_404_list);
		Assert.assertEquals(1, Expr_404_list.size());
		//404
		final ExclusiveOrExpression ExclusiveOrExpression_405_Var
		 = (ExclusiveOrExpression)Expr_404_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_405_Var
		);
		final EList<? extends EObject> Expr_405_list = ExclusiveOrExpression_405_Var
		.getExpr();
		Assert.assertNotNull(Expr_405_list);
		Assert.assertEquals(1, Expr_405_list.size());
		//405
		final AndExpression AndExpression_406_Var
		 = (AndExpression)Expr_405_list.get(0);
		Assert.assertNotNull(AndExpression_406_Var
		);
		final EList<? extends EObject> Expr_406_list = AndExpression_406_Var
		.getExpr();
		Assert.assertNotNull(Expr_406_list);
		Assert.assertEquals(1, Expr_406_list.size());
		//406
		final EqualityExpression EqualityExpression_407_Var
		 = (EqualityExpression)Expr_406_list.get(0);
		Assert.assertNotNull(EqualityExpression_407_Var
		);
		final EList<? extends EObject> Expr_407_list = EqualityExpression_407_Var
		.getExpr();
		Assert.assertNotNull(Expr_407_list);
		Assert.assertEquals(1, Expr_407_list.size());
		//407
		final RelationalExpression RelationalExpression_408_Var
		 = (RelationalExpression)Expr_407_list.get(0);
		Assert.assertNotNull(RelationalExpression_408_Var
		);
		final EList<? extends EObject> Expr_408_list = RelationalExpression_408_Var
		.getExpr();
		Assert.assertNotNull(Expr_408_list);
		Assert.assertEquals(1, Expr_408_list.size());
		//408
		final ShiftExpression ShiftExpression_409_Var
		 = (ShiftExpression)Expr_408_list.get(0);
		Assert.assertNotNull(ShiftExpression_409_Var
		);
		final EList<? extends EObject> Expr_409_list = ShiftExpression_409_Var
		.getExpr();
		Assert.assertNotNull(Expr_409_list);
		Assert.assertEquals(1, Expr_409_list.size());
		//409
		final AdditiveExpression AdditiveExpression_410_Var
		 = (AdditiveExpression)Expr_409_list.get(0);
		Assert.assertNotNull(AdditiveExpression_410_Var
		);
		final EList<? extends EObject> Expr_410_list = AdditiveExpression_410_Var
		.getExpr();
		Assert.assertNotNull(Expr_410_list);
		Assert.assertEquals(1, Expr_410_list.size());
		//410
		final MultiplicativeExpression MultiplicativeExpression_411_Var
		 = (MultiplicativeExpression)Expr_410_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_411_Var
		);
		final EList<? extends EObject> Expr_411_list = MultiplicativeExpression_411_Var
		.getExpr();
		Assert.assertNotNull(Expr_411_list);
		Assert.assertEquals(1, Expr_411_list.size());
		//411
		final CastExpression CastExpression_412_Var
		 = (CastExpression)Expr_411_list.get(0);
		Assert.assertNotNull(CastExpression_412_Var
		);
		//412
		final UnaryExpression UnaryExpression_413_Var
		 = (UnaryExpression)CastExpression_412_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_413_Var
		);
		//413
		final PostfixExpression PostfixExpression_414_Var
		 = (PostfixExpression)UnaryExpression_413_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_414_Var
		);
		final EList<? extends EObject> Expr_414_list = PostfixExpression_414_Var
		.getExpr();
		Assert.assertNotNull(Expr_414_list);
		Assert.assertEquals(1, Expr_414_list.size());
		//414
		final PrimaryExpression PrimaryExpression_415_Var
		 = (PrimaryExpression)Expr_414_list.get(0);
		Assert.assertNotNull(PrimaryExpression_415_Var
		);
		Assert.assertEquals("[\"Could not reserve space for new employee!\\n\"]", PrimaryExpression_415_Var
		.getString().toString());
		Assert.assertEquals(";", ExpressionStatement_380_Var
		.getSemi());
		//415
		final Statement Statement_416_Var
		 = (Statement)Statement_378_list.get(1);
		Assert.assertNotNull(Statement_416_Var
		);
		//416
		final JumpStatement JumpStatement_417_Var
		 = (JumpStatement)Statement_416_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_417_Var
		);
		//417
		final Expression Expression_418_Var
		 = (Expression)JumpStatement_417_Var
		.getExpr();
		Assert.assertNotNull(Expression_418_Var
		);
		final EList<? extends EObject> ExprExpr_418_list = Expression_418_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_418_list);
		Assert.assertEquals(1, ExprExpr_418_list.size());
		//418
		final AssignmentExpression AssignmentExpression_419_Var
		 = (AssignmentExpression)ExprExpr_418_list.get(0);
		Assert.assertNotNull(AssignmentExpression_419_Var
		);
		//419
		final ConditionalExpression ConditionalExpression_420_Var
		 = (ConditionalExpression)AssignmentExpression_419_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_420_Var
		);
		//420
		final LogicalOrExpression LogicalOrExpression_421_Var
		 = (LogicalOrExpression)ConditionalExpression_420_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_421_Var
		);
		final EList<? extends EObject> Expr_421_list = LogicalOrExpression_421_Var
		.getExpr();
		Assert.assertNotNull(Expr_421_list);
		Assert.assertEquals(1, Expr_421_list.size());
		//421
		final LogicalAndExpression LogicalAndExpression_422_Var
		 = (LogicalAndExpression)Expr_421_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_422_Var
		);
		final EList<? extends EObject> Expr_422_list = LogicalAndExpression_422_Var
		.getExpr();
		Assert.assertNotNull(Expr_422_list);
		Assert.assertEquals(1, Expr_422_list.size());
		//422
		final InclusiveOrExpression InclusiveOrExpression_423_Var
		 = (InclusiveOrExpression)Expr_422_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_423_Var
		);
		final EList<? extends EObject> Expr_423_list = InclusiveOrExpression_423_Var
		.getExpr();
		Assert.assertNotNull(Expr_423_list);
		Assert.assertEquals(1, Expr_423_list.size());
		//423
		final ExclusiveOrExpression ExclusiveOrExpression_424_Var
		 = (ExclusiveOrExpression)Expr_423_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_424_Var
		);
		final EList<? extends EObject> Expr_424_list = ExclusiveOrExpression_424_Var
		.getExpr();
		Assert.assertNotNull(Expr_424_list);
		Assert.assertEquals(1, Expr_424_list.size());
		//424
		final AndExpression AndExpression_425_Var
		 = (AndExpression)Expr_424_list.get(0);
		Assert.assertNotNull(AndExpression_425_Var
		);
		final EList<? extends EObject> Expr_425_list = AndExpression_425_Var
		.getExpr();
		Assert.assertNotNull(Expr_425_list);
		Assert.assertEquals(1, Expr_425_list.size());
		//425
		final EqualityExpression EqualityExpression_426_Var
		 = (EqualityExpression)Expr_425_list.get(0);
		Assert.assertNotNull(EqualityExpression_426_Var
		);
		final EList<? extends EObject> Expr_426_list = EqualityExpression_426_Var
		.getExpr();
		Assert.assertNotNull(Expr_426_list);
		Assert.assertEquals(1, Expr_426_list.size());
		//426
		final RelationalExpression RelationalExpression_427_Var
		 = (RelationalExpression)Expr_426_list.get(0);
		Assert.assertNotNull(RelationalExpression_427_Var
		);
		final EList<? extends EObject> Expr_427_list = RelationalExpression_427_Var
		.getExpr();
		Assert.assertNotNull(Expr_427_list);
		Assert.assertEquals(1, Expr_427_list.size());
		//427
		final ShiftExpression ShiftExpression_428_Var
		 = (ShiftExpression)Expr_427_list.get(0);
		Assert.assertNotNull(ShiftExpression_428_Var
		);
		final EList<? extends EObject> Expr_428_list = ShiftExpression_428_Var
		.getExpr();
		Assert.assertNotNull(Expr_428_list);
		Assert.assertEquals(1, Expr_428_list.size());
		//428
		final AdditiveExpression AdditiveExpression_429_Var
		 = (AdditiveExpression)Expr_428_list.get(0);
		Assert.assertNotNull(AdditiveExpression_429_Var
		);
		final EList<? extends EObject> Expr_429_list = AdditiveExpression_429_Var
		.getExpr();
		Assert.assertNotNull(Expr_429_list);
		Assert.assertEquals(1, Expr_429_list.size());
		//429
		final MultiplicativeExpression MultiplicativeExpression_430_Var
		 = (MultiplicativeExpression)Expr_429_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_430_Var
		);
		final EList<? extends EObject> Expr_430_list = MultiplicativeExpression_430_Var
		.getExpr();
		Assert.assertNotNull(Expr_430_list);
		Assert.assertEquals(1, Expr_430_list.size());
		//430
		final CastExpression CastExpression_431_Var
		 = (CastExpression)Expr_430_list.get(0);
		Assert.assertNotNull(CastExpression_431_Var
		);
		//431
		final UnaryExpression UnaryExpression_432_Var
		 = (UnaryExpression)CastExpression_431_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_432_Var
		);
		//432
		final UnaryOperator UnaryOperator_433_Var
		 = (UnaryOperator)UnaryExpression_432_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_433_Var
		);
		Assert.assertEquals("-", UnaryOperator_433_Var
		.getOp());
		//433
		final CastExpression CastExpression_434_Var
		 = (CastExpression)UnaryExpression_432_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_434_Var
		);
		//434
		final UnaryExpression UnaryExpression_435_Var
		 = (UnaryExpression)CastExpression_434_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_435_Var
		);
		//435
		final PostfixExpression PostfixExpression_436_Var
		 = (PostfixExpression)UnaryExpression_435_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_436_Var
		);
		final EList<? extends EObject> Expr_436_list = PostfixExpression_436_Var
		.getExpr();
		Assert.assertNotNull(Expr_436_list);
		Assert.assertEquals(1, Expr_436_list.size());
		//436
		final PrimaryExpression PrimaryExpression_437_Var
		 = (PrimaryExpression)Expr_436_list.get(0);
		Assert.assertNotNull(PrimaryExpression_437_Var
		);
		//437
		final Constant2 Constant2_438_Var
		 = (Constant2)PrimaryExpression_437_Var
		.getConst();
		Assert.assertNotNull(Constant2_438_Var
		);
		Assert.assertEquals("1", Constant2_438_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_417_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_417_Var
		.getSemi());
		//438
		final Statement Statement_439_Var
		 = (Statement)Statement_347_list.get(1);
		Assert.assertNotNull(Statement_439_Var
		);
		//439
		final ExpressionStatement ExpressionStatement_440_Var
		 = (ExpressionStatement)Statement_439_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_440_Var
		);
		//440
		final Expression Expression_441_Var
		 = (Expression)ExpressionStatement_440_Var
		.getExpression();
		Assert.assertNotNull(Expression_441_Var
		);
		final EList<? extends EObject> ExprExpr_441_list = Expression_441_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_441_list);
		Assert.assertEquals(1, ExprExpr_441_list.size());
		//441
		final AssignmentExpression AssignmentExpression_442_Var
		 = (AssignmentExpression)ExprExpr_441_list.get(0);
		Assert.assertNotNull(AssignmentExpression_442_Var
		);
		//442
		final ConditionalExpression ConditionalExpression_443_Var
		 = (ConditionalExpression)AssignmentExpression_442_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_443_Var
		);
		//443
		final LogicalOrExpression LogicalOrExpression_444_Var
		 = (LogicalOrExpression)ConditionalExpression_443_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_444_Var
		);
		final EList<? extends EObject> Expr_444_list = LogicalOrExpression_444_Var
		.getExpr();
		Assert.assertNotNull(Expr_444_list);
		Assert.assertEquals(1, Expr_444_list.size());
		//444
		final LogicalAndExpression LogicalAndExpression_445_Var
		 = (LogicalAndExpression)Expr_444_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_445_Var
		);
		final EList<? extends EObject> Expr_445_list = LogicalAndExpression_445_Var
		.getExpr();
		Assert.assertNotNull(Expr_445_list);
		Assert.assertEquals(1, Expr_445_list.size());
		//445
		final InclusiveOrExpression InclusiveOrExpression_446_Var
		 = (InclusiveOrExpression)Expr_445_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_446_Var
		);
		final EList<? extends EObject> Expr_446_list = InclusiveOrExpression_446_Var
		.getExpr();
		Assert.assertNotNull(Expr_446_list);
		Assert.assertEquals(1, Expr_446_list.size());
		//446
		final ExclusiveOrExpression ExclusiveOrExpression_447_Var
		 = (ExclusiveOrExpression)Expr_446_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_447_Var
		);
		final EList<? extends EObject> Expr_447_list = ExclusiveOrExpression_447_Var
		.getExpr();
		Assert.assertNotNull(Expr_447_list);
		Assert.assertEquals(1, Expr_447_list.size());
		//447
		final AndExpression AndExpression_448_Var
		 = (AndExpression)Expr_447_list.get(0);
		Assert.assertNotNull(AndExpression_448_Var
		);
		final EList<? extends EObject> Expr_448_list = AndExpression_448_Var
		.getExpr();
		Assert.assertNotNull(Expr_448_list);
		Assert.assertEquals(1, Expr_448_list.size());
		//448
		final EqualityExpression EqualityExpression_449_Var
		 = (EqualityExpression)Expr_448_list.get(0);
		Assert.assertNotNull(EqualityExpression_449_Var
		);
		final EList<? extends EObject> Expr_449_list = EqualityExpression_449_Var
		.getExpr();
		Assert.assertNotNull(Expr_449_list);
		Assert.assertEquals(1, Expr_449_list.size());
		//449
		final RelationalExpression RelationalExpression_450_Var
		 = (RelationalExpression)Expr_449_list.get(0);
		Assert.assertNotNull(RelationalExpression_450_Var
		);
		final EList<? extends EObject> Expr_450_list = RelationalExpression_450_Var
		.getExpr();
		Assert.assertNotNull(Expr_450_list);
		Assert.assertEquals(1, Expr_450_list.size());
		//450
		final ShiftExpression ShiftExpression_451_Var
		 = (ShiftExpression)Expr_450_list.get(0);
		Assert.assertNotNull(ShiftExpression_451_Var
		);
		final EList<? extends EObject> Expr_451_list = ShiftExpression_451_Var
		.getExpr();
		Assert.assertNotNull(Expr_451_list);
		Assert.assertEquals(1, Expr_451_list.size());
		//451
		final AdditiveExpression AdditiveExpression_452_Var
		 = (AdditiveExpression)Expr_451_list.get(0);
		Assert.assertNotNull(AdditiveExpression_452_Var
		);
		final EList<? extends EObject> Expr_452_list = AdditiveExpression_452_Var
		.getExpr();
		Assert.assertNotNull(Expr_452_list);
		Assert.assertEquals(1, Expr_452_list.size());
		//452
		final MultiplicativeExpression MultiplicativeExpression_453_Var
		 = (MultiplicativeExpression)Expr_452_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_453_Var
		);
		final EList<? extends EObject> Expr_453_list = MultiplicativeExpression_453_Var
		.getExpr();
		Assert.assertNotNull(Expr_453_list);
		Assert.assertEquals(1, Expr_453_list.size());
		//453
		final CastExpression CastExpression_454_Var
		 = (CastExpression)Expr_453_list.get(0);
		Assert.assertNotNull(CastExpression_454_Var
		);
		//454
		final UnaryExpression UnaryExpression_455_Var
		 = (UnaryExpression)CastExpression_454_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_455_Var
		);
		//455
		final PostfixExpression PostfixExpression_456_Var
		 = (PostfixExpression)UnaryExpression_455_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_456_Var
		);
		final EList<? extends EObject> Expr_456_list = PostfixExpression_456_Var
		.getExpr();
		Assert.assertNotNull(Expr_456_list);
		Assert.assertEquals(1, Expr_456_list.size());
		//456
		final PrimaryExpression PrimaryExpression_457_Var
		 = (PrimaryExpression)Expr_456_list.get(0);
		Assert.assertNotNull(PrimaryExpression_457_Var
		);
		Assert.assertEquals("print", PrimaryExpression_457_Var
		.getId());
		final EList<? extends EObject> Suffix_457_list = PostfixExpression_456_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_457_list);
		Assert.assertEquals(1, Suffix_457_list.size());
		//457
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_458_Var
		 = (PostfixExpressionSuffixArgument)Suffix_457_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_458_Var
		);
		//458
		final ArgumentExpressionList ArgumentExpressionList_459_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_458_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_459_Var
		);
		final EList<? extends EObject> Expr_459_list = ArgumentExpressionList_459_Var
		.getExpr();
		Assert.assertNotNull(Expr_459_list);
		Assert.assertEquals(1, Expr_459_list.size());
		//459
		final AssignmentExpression AssignmentExpression_460_Var
		 = (AssignmentExpression)Expr_459_list.get(0);
		Assert.assertNotNull(AssignmentExpression_460_Var
		);
		//460
		final ConditionalExpression ConditionalExpression_461_Var
		 = (ConditionalExpression)AssignmentExpression_460_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_461_Var
		);
		//461
		final LogicalOrExpression LogicalOrExpression_462_Var
		 = (LogicalOrExpression)ConditionalExpression_461_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_462_Var
		);
		final EList<? extends EObject> Expr_462_list = LogicalOrExpression_462_Var
		.getExpr();
		Assert.assertNotNull(Expr_462_list);
		Assert.assertEquals(1, Expr_462_list.size());
		//462
		final LogicalAndExpression LogicalAndExpression_463_Var
		 = (LogicalAndExpression)Expr_462_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_463_Var
		);
		final EList<? extends EObject> Expr_463_list = LogicalAndExpression_463_Var
		.getExpr();
		Assert.assertNotNull(Expr_463_list);
		Assert.assertEquals(1, Expr_463_list.size());
		//463
		final InclusiveOrExpression InclusiveOrExpression_464_Var
		 = (InclusiveOrExpression)Expr_463_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_464_Var
		);
		final EList<? extends EObject> Expr_464_list = InclusiveOrExpression_464_Var
		.getExpr();
		Assert.assertNotNull(Expr_464_list);
		Assert.assertEquals(1, Expr_464_list.size());
		//464
		final ExclusiveOrExpression ExclusiveOrExpression_465_Var
		 = (ExclusiveOrExpression)Expr_464_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_465_Var
		);
		final EList<? extends EObject> Expr_465_list = ExclusiveOrExpression_465_Var
		.getExpr();
		Assert.assertNotNull(Expr_465_list);
		Assert.assertEquals(1, Expr_465_list.size());
		//465
		final AndExpression AndExpression_466_Var
		 = (AndExpression)Expr_465_list.get(0);
		Assert.assertNotNull(AndExpression_466_Var
		);
		final EList<? extends EObject> Expr_466_list = AndExpression_466_Var
		.getExpr();
		Assert.assertNotNull(Expr_466_list);
		Assert.assertEquals(1, Expr_466_list.size());
		//466
		final EqualityExpression EqualityExpression_467_Var
		 = (EqualityExpression)Expr_466_list.get(0);
		Assert.assertNotNull(EqualityExpression_467_Var
		);
		final EList<? extends EObject> Expr_467_list = EqualityExpression_467_Var
		.getExpr();
		Assert.assertNotNull(Expr_467_list);
		Assert.assertEquals(1, Expr_467_list.size());
		//467
		final RelationalExpression RelationalExpression_468_Var
		 = (RelationalExpression)Expr_467_list.get(0);
		Assert.assertNotNull(RelationalExpression_468_Var
		);
		final EList<? extends EObject> Expr_468_list = RelationalExpression_468_Var
		.getExpr();
		Assert.assertNotNull(Expr_468_list);
		Assert.assertEquals(1, Expr_468_list.size());
		//468
		final ShiftExpression ShiftExpression_469_Var
		 = (ShiftExpression)Expr_468_list.get(0);
		Assert.assertNotNull(ShiftExpression_469_Var
		);
		final EList<? extends EObject> Expr_469_list = ShiftExpression_469_Var
		.getExpr();
		Assert.assertNotNull(Expr_469_list);
		Assert.assertEquals(1, Expr_469_list.size());
		//469
		final AdditiveExpression AdditiveExpression_470_Var
		 = (AdditiveExpression)Expr_469_list.get(0);
		Assert.assertNotNull(AdditiveExpression_470_Var
		);
		final EList<? extends EObject> Expr_470_list = AdditiveExpression_470_Var
		.getExpr();
		Assert.assertNotNull(Expr_470_list);
		Assert.assertEquals(1, Expr_470_list.size());
		//470
		final MultiplicativeExpression MultiplicativeExpression_471_Var
		 = (MultiplicativeExpression)Expr_470_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_471_Var
		);
		final EList<? extends EObject> Expr_471_list = MultiplicativeExpression_471_Var
		.getExpr();
		Assert.assertNotNull(Expr_471_list);
		Assert.assertEquals(1, Expr_471_list.size());
		//471
		final CastExpression CastExpression_472_Var
		 = (CastExpression)Expr_471_list.get(0);
		Assert.assertNotNull(CastExpression_472_Var
		);
		//472
		final UnaryExpression UnaryExpression_473_Var
		 = (UnaryExpression)CastExpression_472_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_473_Var
		);
		//473
		final UnaryOperator UnaryOperator_474_Var
		 = (UnaryOperator)UnaryExpression_473_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_474_Var
		);
		Assert.assertEquals("&", UnaryOperator_474_Var
		.getOp());
		//474
		final CastExpression CastExpression_475_Var
		 = (CastExpression)UnaryExpression_473_Var
		.getExpr();
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
		Assert.assertEquals("joe", PrimaryExpression_478_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_440_Var
		.getSemi());
		//478
		final Statement Statement_479_Var
		 = (Statement)Statement_347_list.get(2);
		Assert.assertNotNull(Statement_479_Var
		);
		//479
		final ExpressionStatement ExpressionStatement_480_Var
		 = (ExpressionStatement)Statement_479_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_480_Var
		);
		//480
		final Expression Expression_481_Var
		 = (Expression)ExpressionStatement_480_Var
		.getExpression();
		Assert.assertNotNull(Expression_481_Var
		);
		final EList<? extends EObject> ExprExpr_481_list = Expression_481_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_481_list);
		Assert.assertEquals(1, ExprExpr_481_list.size());
		//481
		final AssignmentExpression AssignmentExpression_482_Var
		 = (AssignmentExpression)ExprExpr_481_list.get(0);
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
		Assert.assertEquals("print", PrimaryExpression_497_Var
		.getId());
		final EList<? extends EObject> Suffix_497_list = PostfixExpression_496_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_497_list);
		Assert.assertEquals(1, Suffix_497_list.size());
		//497
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_498_Var
		 = (PostfixExpressionSuffixArgument)Suffix_497_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_498_Var
		);
		//498
		final ArgumentExpressionList ArgumentExpressionList_499_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_498_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_499_Var
		);
		final EList<? extends EObject> Expr_499_list = ArgumentExpressionList_499_Var
		.getExpr();
		Assert.assertNotNull(Expr_499_list);
		Assert.assertEquals(1, Expr_499_list.size());
		//499
		final AssignmentExpression AssignmentExpression_500_Var
		 = (AssignmentExpression)Expr_499_list.get(0);
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
		final UnaryOperator UnaryOperator_514_Var
		 = (UnaryOperator)UnaryExpression_513_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_514_Var
		);
		Assert.assertEquals("&", UnaryOperator_514_Var
		.getOp());
		//514
		final CastExpression CastExpression_515_Var
		 = (CastExpression)UnaryExpression_513_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_515_Var
		);
		//515
		final UnaryExpression UnaryExpression_516_Var
		 = (UnaryExpression)CastExpression_515_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_516_Var
		);
		//516
		final PostfixExpression PostfixExpression_517_Var
		 = (PostfixExpression)UnaryExpression_516_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_517_Var
		);
		final EList<? extends EObject> Expr_517_list = PostfixExpression_517_Var
		.getExpr();
		Assert.assertNotNull(Expr_517_list);
		Assert.assertEquals(1, Expr_517_list.size());
		//517
		final PrimaryExpression PrimaryExpression_518_Var
		 = (PrimaryExpression)Expr_517_list.get(0);
		Assert.assertNotNull(PrimaryExpression_518_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_518_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_480_Var
		.getSemi());
		//518
		final Statement Statement_519_Var
		 = (Statement)Statement_347_list.get(3);
		Assert.assertNotNull(Statement_519_Var
		);
		//519
		final ExpressionStatement ExpressionStatement_520_Var
		 = (ExpressionStatement)Statement_519_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_520_Var
		);
		//520
		final Expression Expression_521_Var
		 = (Expression)ExpressionStatement_520_Var
		.getExpression();
		Assert.assertNotNull(Expression_521_Var
		);
		final EList<? extends EObject> ExprExpr_521_list = Expression_521_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_521_list);
		Assert.assertEquals(1, ExprExpr_521_list.size());
		//521
		final AssignmentExpression AssignmentExpression_522_Var
		 = (AssignmentExpression)ExprExpr_521_list.get(0);
		Assert.assertNotNull(AssignmentExpression_522_Var
		);
		//522
		final UnaryExpression UnaryExpression_523_Var
		 = (UnaryExpression)AssignmentExpression_522_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_523_Var
		);
		//523
		final PostfixExpression PostfixExpression_524_Var
		 = (PostfixExpression)UnaryExpression_523_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_524_Var
		);
		final EList<? extends EObject> Expr_524_list = PostfixExpression_524_Var
		.getExpr();
		Assert.assertNotNull(Expr_524_list);
		Assert.assertEquals(1, Expr_524_list.size());
		//524
		final PrimaryExpression PrimaryExpression_525_Var
		 = (PrimaryExpression)Expr_524_list.get(0);
		Assert.assertNotNull(PrimaryExpression_525_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_525_Var
		.getId());
		final EList<? extends EObject> Suffix_525_list = PostfixExpression_524_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_525_list);
		Assert.assertEquals(1, Suffix_525_list.size());
		//525
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_526_Var
		 = (PostfixExpressionSuffixArrow)Suffix_525_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArrow_526_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixArrow_526_Var
		.getId());
		//526
		final AssignmentOperator AssignmentOperator_527_Var
		 = (AssignmentOperator)AssignmentExpression_522_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_527_Var
		);
		Assert.assertEquals("=", AssignmentOperator_527_Var
		.getOp());
		//527
		final AssignmentExpression AssignmentExpression_528_Var
		 = (AssignmentExpression)AssignmentExpression_522_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_528_Var
		);
		//528
		final ConditionalExpression ConditionalExpression_529_Var
		 = (ConditionalExpression)AssignmentExpression_528_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_529_Var
		);
		//529
		final LogicalOrExpression LogicalOrExpression_530_Var
		 = (LogicalOrExpression)ConditionalExpression_529_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_530_Var
		);
		final EList<? extends EObject> Expr_530_list = LogicalOrExpression_530_Var
		.getExpr();
		Assert.assertNotNull(Expr_530_list);
		Assert.assertEquals(1, Expr_530_list.size());
		//530
		final LogicalAndExpression LogicalAndExpression_531_Var
		 = (LogicalAndExpression)Expr_530_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_531_Var
		);
		final EList<? extends EObject> Expr_531_list = LogicalAndExpression_531_Var
		.getExpr();
		Assert.assertNotNull(Expr_531_list);
		Assert.assertEquals(1, Expr_531_list.size());
		//531
		final InclusiveOrExpression InclusiveOrExpression_532_Var
		 = (InclusiveOrExpression)Expr_531_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_532_Var
		);
		final EList<? extends EObject> Expr_532_list = InclusiveOrExpression_532_Var
		.getExpr();
		Assert.assertNotNull(Expr_532_list);
		Assert.assertEquals(1, Expr_532_list.size());
		//532
		final ExclusiveOrExpression ExclusiveOrExpression_533_Var
		 = (ExclusiveOrExpression)Expr_532_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_533_Var
		);
		final EList<? extends EObject> Expr_533_list = ExclusiveOrExpression_533_Var
		.getExpr();
		Assert.assertNotNull(Expr_533_list);
		Assert.assertEquals(1, Expr_533_list.size());
		//533
		final AndExpression AndExpression_534_Var
		 = (AndExpression)Expr_533_list.get(0);
		Assert.assertNotNull(AndExpression_534_Var
		);
		final EList<? extends EObject> Expr_534_list = AndExpression_534_Var
		.getExpr();
		Assert.assertNotNull(Expr_534_list);
		Assert.assertEquals(1, Expr_534_list.size());
		//534
		final EqualityExpression EqualityExpression_535_Var
		 = (EqualityExpression)Expr_534_list.get(0);
		Assert.assertNotNull(EqualityExpression_535_Var
		);
		final EList<? extends EObject> Expr_535_list = EqualityExpression_535_Var
		.getExpr();
		Assert.assertNotNull(Expr_535_list);
		Assert.assertEquals(1, Expr_535_list.size());
		//535
		final RelationalExpression RelationalExpression_536_Var
		 = (RelationalExpression)Expr_535_list.get(0);
		Assert.assertNotNull(RelationalExpression_536_Var
		);
		final EList<? extends EObject> Expr_536_list = RelationalExpression_536_Var
		.getExpr();
		Assert.assertNotNull(Expr_536_list);
		Assert.assertEquals(1, Expr_536_list.size());
		//536
		final ShiftExpression ShiftExpression_537_Var
		 = (ShiftExpression)Expr_536_list.get(0);
		Assert.assertNotNull(ShiftExpression_537_Var
		);
		final EList<? extends EObject> Expr_537_list = ShiftExpression_537_Var
		.getExpr();
		Assert.assertNotNull(Expr_537_list);
		Assert.assertEquals(1, Expr_537_list.size());
		//537
		final AdditiveExpression AdditiveExpression_538_Var
		 = (AdditiveExpression)Expr_537_list.get(0);
		Assert.assertNotNull(AdditiveExpression_538_Var
		);
		final EList<? extends EObject> Expr_538_list = AdditiveExpression_538_Var
		.getExpr();
		Assert.assertNotNull(Expr_538_list);
		Assert.assertEquals(1, Expr_538_list.size());
		//538
		final MultiplicativeExpression MultiplicativeExpression_539_Var
		 = (MultiplicativeExpression)Expr_538_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_539_Var
		);
		final EList<? extends EObject> Expr_539_list = MultiplicativeExpression_539_Var
		.getExpr();
		Assert.assertNotNull(Expr_539_list);
		Assert.assertEquals(1, Expr_539_list.size());
		//539
		final CastExpression CastExpression_540_Var
		 = (CastExpression)Expr_539_list.get(0);
		Assert.assertNotNull(CastExpression_540_Var
		);
		//540
		final UnaryExpression UnaryExpression_541_Var
		 = (UnaryExpression)CastExpression_540_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_541_Var
		);
		//541
		final PostfixExpression PostfixExpression_542_Var
		 = (PostfixExpression)UnaryExpression_541_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_542_Var
		);
		final EList<? extends EObject> Expr_542_list = PostfixExpression_542_Var
		.getExpr();
		Assert.assertNotNull(Expr_542_list);
		Assert.assertEquals(1, Expr_542_list.size());
		//542
		final PrimaryExpression PrimaryExpression_543_Var
		 = (PrimaryExpression)Expr_542_list.get(0);
		Assert.assertNotNull(PrimaryExpression_543_Var
		);
		//543
		final Constant2 Constant2_544_Var
		 = (Constant2)PrimaryExpression_543_Var
		.getConst();
		Assert.assertNotNull(Constant2_544_Var
		);
		Assert.assertEquals("0x009", Constant2_544_Var
		.getHex());
		Assert.assertEquals(";", ExpressionStatement_520_Var
		.getSemi());
		//544
		final Statement Statement_545_Var
		 = (Statement)Statement_347_list.get(4);
		Assert.assertNotNull(Statement_545_Var
		);
		//545
		final ExpressionStatement ExpressionStatement_546_Var
		 = (ExpressionStatement)Statement_545_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_546_Var
		);
		//546
		final Expression Expression_547_Var
		 = (Expression)ExpressionStatement_546_Var
		.getExpression();
		Assert.assertNotNull(Expression_547_Var
		);
		final EList<? extends EObject> ExprExpr_547_list = Expression_547_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_547_list);
		Assert.assertEquals(1, ExprExpr_547_list.size());
		//547
		final AssignmentExpression AssignmentExpression_548_Var
		 = (AssignmentExpression)ExprExpr_547_list.get(0);
		Assert.assertNotNull(AssignmentExpression_548_Var
		);
		//548
		final ConditionalExpression ConditionalExpression_549_Var
		 = (ConditionalExpression)AssignmentExpression_548_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_549_Var
		);
		//549
		final LogicalOrExpression LogicalOrExpression_550_Var
		 = (LogicalOrExpression)ConditionalExpression_549_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_550_Var
		);
		final EList<? extends EObject> Expr_550_list = LogicalOrExpression_550_Var
		.getExpr();
		Assert.assertNotNull(Expr_550_list);
		Assert.assertEquals(1, Expr_550_list.size());
		//550
		final LogicalAndExpression LogicalAndExpression_551_Var
		 = (LogicalAndExpression)Expr_550_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_551_Var
		);
		final EList<? extends EObject> Expr_551_list = LogicalAndExpression_551_Var
		.getExpr();
		Assert.assertNotNull(Expr_551_list);
		Assert.assertEquals(1, Expr_551_list.size());
		//551
		final InclusiveOrExpression InclusiveOrExpression_552_Var
		 = (InclusiveOrExpression)Expr_551_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_552_Var
		);
		final EList<? extends EObject> Expr_552_list = InclusiveOrExpression_552_Var
		.getExpr();
		Assert.assertNotNull(Expr_552_list);
		Assert.assertEquals(1, Expr_552_list.size());
		//552
		final ExclusiveOrExpression ExclusiveOrExpression_553_Var
		 = (ExclusiveOrExpression)Expr_552_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_553_Var
		);
		final EList<? extends EObject> Expr_553_list = ExclusiveOrExpression_553_Var
		.getExpr();
		Assert.assertNotNull(Expr_553_list);
		Assert.assertEquals(1, Expr_553_list.size());
		//553
		final AndExpression AndExpression_554_Var
		 = (AndExpression)Expr_553_list.get(0);
		Assert.assertNotNull(AndExpression_554_Var
		);
		final EList<? extends EObject> Expr_554_list = AndExpression_554_Var
		.getExpr();
		Assert.assertNotNull(Expr_554_list);
		Assert.assertEquals(1, Expr_554_list.size());
		//554
		final EqualityExpression EqualityExpression_555_Var
		 = (EqualityExpression)Expr_554_list.get(0);
		Assert.assertNotNull(EqualityExpression_555_Var
		);
		final EList<? extends EObject> Expr_555_list = EqualityExpression_555_Var
		.getExpr();
		Assert.assertNotNull(Expr_555_list);
		Assert.assertEquals(1, Expr_555_list.size());
		//555
		final RelationalExpression RelationalExpression_556_Var
		 = (RelationalExpression)Expr_555_list.get(0);
		Assert.assertNotNull(RelationalExpression_556_Var
		);
		final EList<? extends EObject> Expr_556_list = RelationalExpression_556_Var
		.getExpr();
		Assert.assertNotNull(Expr_556_list);
		Assert.assertEquals(1, Expr_556_list.size());
		//556
		final ShiftExpression ShiftExpression_557_Var
		 = (ShiftExpression)Expr_556_list.get(0);
		Assert.assertNotNull(ShiftExpression_557_Var
		);
		final EList<? extends EObject> Expr_557_list = ShiftExpression_557_Var
		.getExpr();
		Assert.assertNotNull(Expr_557_list);
		Assert.assertEquals(1, Expr_557_list.size());
		//557
		final AdditiveExpression AdditiveExpression_558_Var
		 = (AdditiveExpression)Expr_557_list.get(0);
		Assert.assertNotNull(AdditiveExpression_558_Var
		);
		final EList<? extends EObject> Expr_558_list = AdditiveExpression_558_Var
		.getExpr();
		Assert.assertNotNull(Expr_558_list);
		Assert.assertEquals(1, Expr_558_list.size());
		//558
		final MultiplicativeExpression MultiplicativeExpression_559_Var
		 = (MultiplicativeExpression)Expr_558_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_559_Var
		);
		final EList<? extends EObject> Expr_559_list = MultiplicativeExpression_559_Var
		.getExpr();
		Assert.assertNotNull(Expr_559_list);
		Assert.assertEquals(1, Expr_559_list.size());
		//559
		final CastExpression CastExpression_560_Var
		 = (CastExpression)Expr_559_list.get(0);
		Assert.assertNotNull(CastExpression_560_Var
		);
		//560
		final UnaryExpression UnaryExpression_561_Var
		 = (UnaryExpression)CastExpression_560_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_561_Var
		);
		//561
		final PostfixExpression PostfixExpression_562_Var
		 = (PostfixExpression)UnaryExpression_561_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_562_Var
		);
		final EList<? extends EObject> Expr_562_list = PostfixExpression_562_Var
		.getExpr();
		Assert.assertNotNull(Expr_562_list);
		Assert.assertEquals(1, Expr_562_list.size());
		//562
		final PrimaryExpression PrimaryExpression_563_Var
		 = (PrimaryExpression)Expr_562_list.get(0);
		Assert.assertNotNull(PrimaryExpression_563_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_563_Var
		.getId());
		final EList<? extends EObject> Suffix_563_list = PostfixExpression_562_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_563_list);
		Assert.assertEquals(1, Suffix_563_list.size());
		//563
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_564_Var
		 = (PostfixExpressionSuffixArgument)Suffix_563_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_564_Var
		);
		//564
		final ArgumentExpressionList ArgumentExpressionList_565_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_564_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_565_Var
		);
		final EList<? extends EObject> Expr_565_list = ArgumentExpressionList_565_Var
		.getExpr();
		Assert.assertNotNull(Expr_565_list);
		Assert.assertEquals(2, Expr_565_list.size());
		//565
		final AssignmentExpression AssignmentExpression_566_Var
		 = (AssignmentExpression)Expr_565_list.get(0);
		Assert.assertNotNull(AssignmentExpression_566_Var
		);
		//566
		final ConditionalExpression ConditionalExpression_567_Var
		 = (ConditionalExpression)AssignmentExpression_566_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_567_Var
		);
		//567
		final LogicalOrExpression LogicalOrExpression_568_Var
		 = (LogicalOrExpression)ConditionalExpression_567_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_568_Var
		);
		final EList<? extends EObject> Expr_568_list = LogicalOrExpression_568_Var
		.getExpr();
		Assert.assertNotNull(Expr_568_list);
		Assert.assertEquals(1, Expr_568_list.size());
		//568
		final LogicalAndExpression LogicalAndExpression_569_Var
		 = (LogicalAndExpression)Expr_568_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_569_Var
		);
		final EList<? extends EObject> Expr_569_list = LogicalAndExpression_569_Var
		.getExpr();
		Assert.assertNotNull(Expr_569_list);
		Assert.assertEquals(1, Expr_569_list.size());
		//569
		final InclusiveOrExpression InclusiveOrExpression_570_Var
		 = (InclusiveOrExpression)Expr_569_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_570_Var
		);
		final EList<? extends EObject> Expr_570_list = InclusiveOrExpression_570_Var
		.getExpr();
		Assert.assertNotNull(Expr_570_list);
		Assert.assertEquals(1, Expr_570_list.size());
		//570
		final ExclusiveOrExpression ExclusiveOrExpression_571_Var
		 = (ExclusiveOrExpression)Expr_570_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_571_Var
		);
		final EList<? extends EObject> Expr_571_list = ExclusiveOrExpression_571_Var
		.getExpr();
		Assert.assertNotNull(Expr_571_list);
		Assert.assertEquals(1, Expr_571_list.size());
		//571
		final AndExpression AndExpression_572_Var
		 = (AndExpression)Expr_571_list.get(0);
		Assert.assertNotNull(AndExpression_572_Var
		);
		final EList<? extends EObject> Expr_572_list = AndExpression_572_Var
		.getExpr();
		Assert.assertNotNull(Expr_572_list);
		Assert.assertEquals(1, Expr_572_list.size());
		//572
		final EqualityExpression EqualityExpression_573_Var
		 = (EqualityExpression)Expr_572_list.get(0);
		Assert.assertNotNull(EqualityExpression_573_Var
		);
		final EList<? extends EObject> Expr_573_list = EqualityExpression_573_Var
		.getExpr();
		Assert.assertNotNull(Expr_573_list);
		Assert.assertEquals(1, Expr_573_list.size());
		//573
		final RelationalExpression RelationalExpression_574_Var
		 = (RelationalExpression)Expr_573_list.get(0);
		Assert.assertNotNull(RelationalExpression_574_Var
		);
		final EList<? extends EObject> Expr_574_list = RelationalExpression_574_Var
		.getExpr();
		Assert.assertNotNull(Expr_574_list);
		Assert.assertEquals(1, Expr_574_list.size());
		//574
		final ShiftExpression ShiftExpression_575_Var
		 = (ShiftExpression)Expr_574_list.get(0);
		Assert.assertNotNull(ShiftExpression_575_Var
		);
		final EList<? extends EObject> Expr_575_list = ShiftExpression_575_Var
		.getExpr();
		Assert.assertNotNull(Expr_575_list);
		Assert.assertEquals(1, Expr_575_list.size());
		//575
		final AdditiveExpression AdditiveExpression_576_Var
		 = (AdditiveExpression)Expr_575_list.get(0);
		Assert.assertNotNull(AdditiveExpression_576_Var
		);
		final EList<? extends EObject> Expr_576_list = AdditiveExpression_576_Var
		.getExpr();
		Assert.assertNotNull(Expr_576_list);
		Assert.assertEquals(1, Expr_576_list.size());
		//576
		final MultiplicativeExpression MultiplicativeExpression_577_Var
		 = (MultiplicativeExpression)Expr_576_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_577_Var
		);
		final EList<? extends EObject> Expr_577_list = MultiplicativeExpression_577_Var
		.getExpr();
		Assert.assertNotNull(Expr_577_list);
		Assert.assertEquals(1, Expr_577_list.size());
		//577
		final CastExpression CastExpression_578_Var
		 = (CastExpression)Expr_577_list.get(0);
		Assert.assertNotNull(CastExpression_578_Var
		);
		//578
		final UnaryExpression UnaryExpression_579_Var
		 = (UnaryExpression)CastExpression_578_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_579_Var
		);
		//579
		final PostfixExpression PostfixExpression_580_Var
		 = (PostfixExpression)UnaryExpression_579_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_580_Var
		);
		final EList<? extends EObject> Expr_580_list = PostfixExpression_580_Var
		.getExpr();
		Assert.assertNotNull(Expr_580_list);
		Assert.assertEquals(1, Expr_580_list.size());
		//580
		final PrimaryExpression PrimaryExpression_581_Var
		 = (PrimaryExpression)Expr_580_list.get(0);
		Assert.assertNotNull(PrimaryExpression_581_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_581_Var
		.getId());
		final EList<? extends EObject> Suffix_581_list = PostfixExpression_580_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_581_list);
		Assert.assertEquals(1, Suffix_581_list.size());
		//581
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_582_Var
		 = (PostfixExpressionSuffixArrow)Suffix_581_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArrow_582_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixArrow_582_Var
		.getId());
		//582
		final AssignmentExpression AssignmentExpression_583_Var
		 = (AssignmentExpression)Expr_565_list.get(1);
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
		Assert.assertEquals("[\"Billy The Kid\"]", PrimaryExpression_598_Var
		.getString().toString());
		Assert.assertEquals(";", ExpressionStatement_546_Var
		.getSemi());
		//598
		final Statement Statement_599_Var
		 = (Statement)Statement_347_list.get(5);
		Assert.assertNotNull(Statement_599_Var
		);
		//599
		final ExpressionStatement ExpressionStatement_600_Var
		 = (ExpressionStatement)Statement_599_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_600_Var
		);
		//600
		final Expression Expression_601_Var
		 = (Expression)ExpressionStatement_600_Var
		.getExpression();
		Assert.assertNotNull(Expression_601_Var
		);
		final EList<? extends EObject> ExprExpr_601_list = Expression_601_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_601_list);
		Assert.assertEquals(1, ExprExpr_601_list.size());
		//601
		final AssignmentExpression AssignmentExpression_602_Var
		 = (AssignmentExpression)ExprExpr_601_list.get(0);
		Assert.assertNotNull(AssignmentExpression_602_Var
		);
		//602
		final ConditionalExpression ConditionalExpression_603_Var
		 = (ConditionalExpression)AssignmentExpression_602_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_603_Var
		);
		//603
		final LogicalOrExpression LogicalOrExpression_604_Var
		 = (LogicalOrExpression)ConditionalExpression_603_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_604_Var
		);
		final EList<? extends EObject> Expr_604_list = LogicalOrExpression_604_Var
		.getExpr();
		Assert.assertNotNull(Expr_604_list);
		Assert.assertEquals(1, Expr_604_list.size());
		//604
		final LogicalAndExpression LogicalAndExpression_605_Var
		 = (LogicalAndExpression)Expr_604_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_605_Var
		);
		final EList<? extends EObject> Expr_605_list = LogicalAndExpression_605_Var
		.getExpr();
		Assert.assertNotNull(Expr_605_list);
		Assert.assertEquals(1, Expr_605_list.size());
		//605
		final InclusiveOrExpression InclusiveOrExpression_606_Var
		 = (InclusiveOrExpression)Expr_605_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_606_Var
		);
		final EList<? extends EObject> Expr_606_list = InclusiveOrExpression_606_Var
		.getExpr();
		Assert.assertNotNull(Expr_606_list);
		Assert.assertEquals(1, Expr_606_list.size());
		//606
		final ExclusiveOrExpression ExclusiveOrExpression_607_Var
		 = (ExclusiveOrExpression)Expr_606_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_607_Var
		);
		final EList<? extends EObject> Expr_607_list = ExclusiveOrExpression_607_Var
		.getExpr();
		Assert.assertNotNull(Expr_607_list);
		Assert.assertEquals(1, Expr_607_list.size());
		//607
		final AndExpression AndExpression_608_Var
		 = (AndExpression)Expr_607_list.get(0);
		Assert.assertNotNull(AndExpression_608_Var
		);
		final EList<? extends EObject> Expr_608_list = AndExpression_608_Var
		.getExpr();
		Assert.assertNotNull(Expr_608_list);
		Assert.assertEquals(1, Expr_608_list.size());
		//608
		final EqualityExpression EqualityExpression_609_Var
		 = (EqualityExpression)Expr_608_list.get(0);
		Assert.assertNotNull(EqualityExpression_609_Var
		);
		final EList<? extends EObject> Expr_609_list = EqualityExpression_609_Var
		.getExpr();
		Assert.assertNotNull(Expr_609_list);
		Assert.assertEquals(1, Expr_609_list.size());
		//609
		final RelationalExpression RelationalExpression_610_Var
		 = (RelationalExpression)Expr_609_list.get(0);
		Assert.assertNotNull(RelationalExpression_610_Var
		);
		final EList<? extends EObject> Expr_610_list = RelationalExpression_610_Var
		.getExpr();
		Assert.assertNotNull(Expr_610_list);
		Assert.assertEquals(1, Expr_610_list.size());
		//610
		final ShiftExpression ShiftExpression_611_Var
		 = (ShiftExpression)Expr_610_list.get(0);
		Assert.assertNotNull(ShiftExpression_611_Var
		);
		final EList<? extends EObject> Expr_611_list = ShiftExpression_611_Var
		.getExpr();
		Assert.assertNotNull(Expr_611_list);
		Assert.assertEquals(1, Expr_611_list.size());
		//611
		final AdditiveExpression AdditiveExpression_612_Var
		 = (AdditiveExpression)Expr_611_list.get(0);
		Assert.assertNotNull(AdditiveExpression_612_Var
		);
		final EList<? extends EObject> Expr_612_list = AdditiveExpression_612_Var
		.getExpr();
		Assert.assertNotNull(Expr_612_list);
		Assert.assertEquals(1, Expr_612_list.size());
		//612
		final MultiplicativeExpression MultiplicativeExpression_613_Var
		 = (MultiplicativeExpression)Expr_612_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_613_Var
		);
		final EList<? extends EObject> Expr_613_list = MultiplicativeExpression_613_Var
		.getExpr();
		Assert.assertNotNull(Expr_613_list);
		Assert.assertEquals(1, Expr_613_list.size());
		//613
		final CastExpression CastExpression_614_Var
		 = (CastExpression)Expr_613_list.get(0);
		Assert.assertNotNull(CastExpression_614_Var
		);
		//614
		final UnaryExpression UnaryExpression_615_Var
		 = (UnaryExpression)CastExpression_614_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_615_Var
		);
		//615
		final PostfixExpression PostfixExpression_616_Var
		 = (PostfixExpression)UnaryExpression_615_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_616_Var
		);
		final EList<? extends EObject> Expr_616_list = PostfixExpression_616_Var
		.getExpr();
		Assert.assertNotNull(Expr_616_list);
		Assert.assertEquals(1, Expr_616_list.size());
		//616
		final PrimaryExpression PrimaryExpression_617_Var
		 = (PrimaryExpression)Expr_616_list.get(0);
		Assert.assertNotNull(PrimaryExpression_617_Var
		);
		Assert.assertEquals("print", PrimaryExpression_617_Var
		.getId());
		final EList<? extends EObject> Suffix_617_list = PostfixExpression_616_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_617_list);
		Assert.assertEquals(1, Suffix_617_list.size());
		//617
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_618_Var
		 = (PostfixExpressionSuffixArgument)Suffix_617_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_618_Var
		);
		//618
		final ArgumentExpressionList ArgumentExpressionList_619_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_618_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_619_Var
		);
		final EList<? extends EObject> Expr_619_list = ArgumentExpressionList_619_Var
		.getExpr();
		Assert.assertNotNull(Expr_619_list);
		Assert.assertEquals(1, Expr_619_list.size());
		//619
		final AssignmentExpression AssignmentExpression_620_Var
		 = (AssignmentExpression)Expr_619_list.get(0);
		Assert.assertNotNull(AssignmentExpression_620_Var
		);
		//620
		final ConditionalExpression ConditionalExpression_621_Var
		 = (ConditionalExpression)AssignmentExpression_620_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_621_Var
		);
		//621
		final LogicalOrExpression LogicalOrExpression_622_Var
		 = (LogicalOrExpression)ConditionalExpression_621_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_622_Var
		);
		final EList<? extends EObject> Expr_622_list = LogicalOrExpression_622_Var
		.getExpr();
		Assert.assertNotNull(Expr_622_list);
		Assert.assertEquals(1, Expr_622_list.size());
		//622
		final LogicalAndExpression LogicalAndExpression_623_Var
		 = (LogicalAndExpression)Expr_622_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_623_Var
		);
		final EList<? extends EObject> Expr_623_list = LogicalAndExpression_623_Var
		.getExpr();
		Assert.assertNotNull(Expr_623_list);
		Assert.assertEquals(1, Expr_623_list.size());
		//623
		final InclusiveOrExpression InclusiveOrExpression_624_Var
		 = (InclusiveOrExpression)Expr_623_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_624_Var
		);
		final EList<? extends EObject> Expr_624_list = InclusiveOrExpression_624_Var
		.getExpr();
		Assert.assertNotNull(Expr_624_list);
		Assert.assertEquals(1, Expr_624_list.size());
		//624
		final ExclusiveOrExpression ExclusiveOrExpression_625_Var
		 = (ExclusiveOrExpression)Expr_624_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_625_Var
		);
		final EList<? extends EObject> Expr_625_list = ExclusiveOrExpression_625_Var
		.getExpr();
		Assert.assertNotNull(Expr_625_list);
		Assert.assertEquals(1, Expr_625_list.size());
		//625
		final AndExpression AndExpression_626_Var
		 = (AndExpression)Expr_625_list.get(0);
		Assert.assertNotNull(AndExpression_626_Var
		);
		final EList<? extends EObject> Expr_626_list = AndExpression_626_Var
		.getExpr();
		Assert.assertNotNull(Expr_626_list);
		Assert.assertEquals(1, Expr_626_list.size());
		//626
		final EqualityExpression EqualityExpression_627_Var
		 = (EqualityExpression)Expr_626_list.get(0);
		Assert.assertNotNull(EqualityExpression_627_Var
		);
		final EList<? extends EObject> Expr_627_list = EqualityExpression_627_Var
		.getExpr();
		Assert.assertNotNull(Expr_627_list);
		Assert.assertEquals(1, Expr_627_list.size());
		//627
		final RelationalExpression RelationalExpression_628_Var
		 = (RelationalExpression)Expr_627_list.get(0);
		Assert.assertNotNull(RelationalExpression_628_Var
		);
		final EList<? extends EObject> Expr_628_list = RelationalExpression_628_Var
		.getExpr();
		Assert.assertNotNull(Expr_628_list);
		Assert.assertEquals(1, Expr_628_list.size());
		//628
		final ShiftExpression ShiftExpression_629_Var
		 = (ShiftExpression)Expr_628_list.get(0);
		Assert.assertNotNull(ShiftExpression_629_Var
		);
		final EList<? extends EObject> Expr_629_list = ShiftExpression_629_Var
		.getExpr();
		Assert.assertNotNull(Expr_629_list);
		Assert.assertEquals(1, Expr_629_list.size());
		//629
		final AdditiveExpression AdditiveExpression_630_Var
		 = (AdditiveExpression)Expr_629_list.get(0);
		Assert.assertNotNull(AdditiveExpression_630_Var
		);
		final EList<? extends EObject> Expr_630_list = AdditiveExpression_630_Var
		.getExpr();
		Assert.assertNotNull(Expr_630_list);
		Assert.assertEquals(1, Expr_630_list.size());
		//630
		final MultiplicativeExpression MultiplicativeExpression_631_Var
		 = (MultiplicativeExpression)Expr_630_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_631_Var
		);
		final EList<? extends EObject> Expr_631_list = MultiplicativeExpression_631_Var
		.getExpr();
		Assert.assertNotNull(Expr_631_list);
		Assert.assertEquals(1, Expr_631_list.size());
		//631
		final CastExpression CastExpression_632_Var
		 = (CastExpression)Expr_631_list.get(0);
		Assert.assertNotNull(CastExpression_632_Var
		);
		//632
		final UnaryExpression UnaryExpression_633_Var
		 = (UnaryExpression)CastExpression_632_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_633_Var
		);
		//633
		final PostfixExpression PostfixExpression_634_Var
		 = (PostfixExpression)UnaryExpression_633_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_634_Var
		);
		final EList<? extends EObject> Expr_634_list = PostfixExpression_634_Var
		.getExpr();
		Assert.assertNotNull(Expr_634_list);
		Assert.assertEquals(1, Expr_634_list.size());
		//634
		final PrimaryExpression PrimaryExpression_635_Var
		 = (PrimaryExpression)Expr_634_list.get(0);
		Assert.assertNotNull(PrimaryExpression_635_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_635_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_600_Var
		.getSemi());
		//635
		final Statement Statement_636_Var
		 = (Statement)Statement_347_list.get(6);
		Assert.assertNotNull(Statement_636_Var
		);
		//636
		final ExpressionStatement ExpressionStatement_637_Var
		 = (ExpressionStatement)Statement_636_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_637_Var
		);
		//637
		final Expression Expression_638_Var
		 = (Expression)ExpressionStatement_637_Var
		.getExpression();
		Assert.assertNotNull(Expression_638_Var
		);
		final EList<? extends EObject> ExprExpr_638_list = Expression_638_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_638_list);
		Assert.assertEquals(1, ExprExpr_638_list.size());
		//638
		final AssignmentExpression AssignmentExpression_639_Var
		 = (AssignmentExpression)ExprExpr_638_list.get(0);
		Assert.assertNotNull(AssignmentExpression_639_Var
		);
		//639
		final ConditionalExpression ConditionalExpression_640_Var
		 = (ConditionalExpression)AssignmentExpression_639_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_640_Var
		);
		//640
		final LogicalOrExpression LogicalOrExpression_641_Var
		 = (LogicalOrExpression)ConditionalExpression_640_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_641_Var
		);
		final EList<? extends EObject> Expr_641_list = LogicalOrExpression_641_Var
		.getExpr();
		Assert.assertNotNull(Expr_641_list);
		Assert.assertEquals(1, Expr_641_list.size());
		//641
		final LogicalAndExpression LogicalAndExpression_642_Var
		 = (LogicalAndExpression)Expr_641_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_642_Var
		);
		final EList<? extends EObject> Expr_642_list = LogicalAndExpression_642_Var
		.getExpr();
		Assert.assertNotNull(Expr_642_list);
		Assert.assertEquals(1, Expr_642_list.size());
		//642
		final InclusiveOrExpression InclusiveOrExpression_643_Var
		 = (InclusiveOrExpression)Expr_642_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_643_Var
		);
		final EList<? extends EObject> Expr_643_list = InclusiveOrExpression_643_Var
		.getExpr();
		Assert.assertNotNull(Expr_643_list);
		Assert.assertEquals(1, Expr_643_list.size());
		//643
		final ExclusiveOrExpression ExclusiveOrExpression_644_Var
		 = (ExclusiveOrExpression)Expr_643_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_644_Var
		);
		final EList<? extends EObject> Expr_644_list = ExclusiveOrExpression_644_Var
		.getExpr();
		Assert.assertNotNull(Expr_644_list);
		Assert.assertEquals(1, Expr_644_list.size());
		//644
		final AndExpression AndExpression_645_Var
		 = (AndExpression)Expr_644_list.get(0);
		Assert.assertNotNull(AndExpression_645_Var
		);
		final EList<? extends EObject> Expr_645_list = AndExpression_645_Var
		.getExpr();
		Assert.assertNotNull(Expr_645_list);
		Assert.assertEquals(1, Expr_645_list.size());
		//645
		final EqualityExpression EqualityExpression_646_Var
		 = (EqualityExpression)Expr_645_list.get(0);
		Assert.assertNotNull(EqualityExpression_646_Var
		);
		final EList<? extends EObject> Expr_646_list = EqualityExpression_646_Var
		.getExpr();
		Assert.assertNotNull(Expr_646_list);
		Assert.assertEquals(1, Expr_646_list.size());
		//646
		final RelationalExpression RelationalExpression_647_Var
		 = (RelationalExpression)Expr_646_list.get(0);
		Assert.assertNotNull(RelationalExpression_647_Var
		);
		final EList<? extends EObject> Expr_647_list = RelationalExpression_647_Var
		.getExpr();
		Assert.assertNotNull(Expr_647_list);
		Assert.assertEquals(1, Expr_647_list.size());
		//647
		final ShiftExpression ShiftExpression_648_Var
		 = (ShiftExpression)Expr_647_list.get(0);
		Assert.assertNotNull(ShiftExpression_648_Var
		);
		final EList<? extends EObject> Expr_648_list = ShiftExpression_648_Var
		.getExpr();
		Assert.assertNotNull(Expr_648_list);
		Assert.assertEquals(1, Expr_648_list.size());
		//648
		final AdditiveExpression AdditiveExpression_649_Var
		 = (AdditiveExpression)Expr_648_list.get(0);
		Assert.assertNotNull(AdditiveExpression_649_Var
		);
		final EList<? extends EObject> Expr_649_list = AdditiveExpression_649_Var
		.getExpr();
		Assert.assertNotNull(Expr_649_list);
		Assert.assertEquals(1, Expr_649_list.size());
		//649
		final MultiplicativeExpression MultiplicativeExpression_650_Var
		 = (MultiplicativeExpression)Expr_649_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_650_Var
		);
		final EList<? extends EObject> Expr_650_list = MultiplicativeExpression_650_Var
		.getExpr();
		Assert.assertNotNull(Expr_650_list);
		Assert.assertEquals(1, Expr_650_list.size());
		//650
		final CastExpression CastExpression_651_Var
		 = (CastExpression)Expr_650_list.get(0);
		Assert.assertNotNull(CastExpression_651_Var
		);
		//651
		final UnaryExpression UnaryExpression_652_Var
		 = (UnaryExpression)CastExpression_651_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_652_Var
		);
		//652
		final PostfixExpression PostfixExpression_653_Var
		 = (PostfixExpression)UnaryExpression_652_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_653_Var
		);
		final EList<? extends EObject> Expr_653_list = PostfixExpression_653_Var
		.getExpr();
		Assert.assertNotNull(Expr_653_list);
		Assert.assertEquals(1, Expr_653_list.size());
		//653
		final PrimaryExpression PrimaryExpression_654_Var
		 = (PrimaryExpression)Expr_653_list.get(0);
		Assert.assertNotNull(PrimaryExpression_654_Var
		);
		Assert.assertEquals("free", PrimaryExpression_654_Var
		.getId());
		final EList<? extends EObject> Suffix_654_list = PostfixExpression_653_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_654_list);
		Assert.assertEquals(1, Suffix_654_list.size());
		//654
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_655_Var
		 = (PostfixExpressionSuffixArgument)Suffix_654_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_655_Var
		);
		//655
		final ArgumentExpressionList ArgumentExpressionList_656_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_655_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_656_Var
		);
		final EList<? extends EObject> Expr_656_list = ArgumentExpressionList_656_Var
		.getExpr();
		Assert.assertNotNull(Expr_656_list);
		Assert.assertEquals(1, Expr_656_list.size());
		//656
		final AssignmentExpression AssignmentExpression_657_Var
		 = (AssignmentExpression)Expr_656_list.get(0);
		Assert.assertNotNull(AssignmentExpression_657_Var
		);
		//657
		final ConditionalExpression ConditionalExpression_658_Var
		 = (ConditionalExpression)AssignmentExpression_657_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_658_Var
		);
		//658
		final LogicalOrExpression LogicalOrExpression_659_Var
		 = (LogicalOrExpression)ConditionalExpression_658_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_659_Var
		);
		final EList<? extends EObject> Expr_659_list = LogicalOrExpression_659_Var
		.getExpr();
		Assert.assertNotNull(Expr_659_list);
		Assert.assertEquals(1, Expr_659_list.size());
		//659
		final LogicalAndExpression LogicalAndExpression_660_Var
		 = (LogicalAndExpression)Expr_659_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_660_Var
		);
		final EList<? extends EObject> Expr_660_list = LogicalAndExpression_660_Var
		.getExpr();
		Assert.assertNotNull(Expr_660_list);
		Assert.assertEquals(1, Expr_660_list.size());
		//660
		final InclusiveOrExpression InclusiveOrExpression_661_Var
		 = (InclusiveOrExpression)Expr_660_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_661_Var
		);
		final EList<? extends EObject> Expr_661_list = InclusiveOrExpression_661_Var
		.getExpr();
		Assert.assertNotNull(Expr_661_list);
		Assert.assertEquals(1, Expr_661_list.size());
		//661
		final ExclusiveOrExpression ExclusiveOrExpression_662_Var
		 = (ExclusiveOrExpression)Expr_661_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_662_Var
		);
		final EList<? extends EObject> Expr_662_list = ExclusiveOrExpression_662_Var
		.getExpr();
		Assert.assertNotNull(Expr_662_list);
		Assert.assertEquals(1, Expr_662_list.size());
		//662
		final AndExpression AndExpression_663_Var
		 = (AndExpression)Expr_662_list.get(0);
		Assert.assertNotNull(AndExpression_663_Var
		);
		final EList<? extends EObject> Expr_663_list = AndExpression_663_Var
		.getExpr();
		Assert.assertNotNull(Expr_663_list);
		Assert.assertEquals(1, Expr_663_list.size());
		//663
		final EqualityExpression EqualityExpression_664_Var
		 = (EqualityExpression)Expr_663_list.get(0);
		Assert.assertNotNull(EqualityExpression_664_Var
		);
		final EList<? extends EObject> Expr_664_list = EqualityExpression_664_Var
		.getExpr();
		Assert.assertNotNull(Expr_664_list);
		Assert.assertEquals(1, Expr_664_list.size());
		//664
		final RelationalExpression RelationalExpression_665_Var
		 = (RelationalExpression)Expr_664_list.get(0);
		Assert.assertNotNull(RelationalExpression_665_Var
		);
		final EList<? extends EObject> Expr_665_list = RelationalExpression_665_Var
		.getExpr();
		Assert.assertNotNull(Expr_665_list);
		Assert.assertEquals(1, Expr_665_list.size());
		//665
		final ShiftExpression ShiftExpression_666_Var
		 = (ShiftExpression)Expr_665_list.get(0);
		Assert.assertNotNull(ShiftExpression_666_Var
		);
		final EList<? extends EObject> Expr_666_list = ShiftExpression_666_Var
		.getExpr();
		Assert.assertNotNull(Expr_666_list);
		Assert.assertEquals(1, Expr_666_list.size());
		//666
		final AdditiveExpression AdditiveExpression_667_Var
		 = (AdditiveExpression)Expr_666_list.get(0);
		Assert.assertNotNull(AdditiveExpression_667_Var
		);
		final EList<? extends EObject> Expr_667_list = AdditiveExpression_667_Var
		.getExpr();
		Assert.assertNotNull(Expr_667_list);
		Assert.assertEquals(1, Expr_667_list.size());
		//667
		final MultiplicativeExpression MultiplicativeExpression_668_Var
		 = (MultiplicativeExpression)Expr_667_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_668_Var
		);
		final EList<? extends EObject> Expr_668_list = MultiplicativeExpression_668_Var
		.getExpr();
		Assert.assertNotNull(Expr_668_list);
		Assert.assertEquals(1, Expr_668_list.size());
		//668
		final CastExpression CastExpression_669_Var
		 = (CastExpression)Expr_668_list.get(0);
		Assert.assertNotNull(CastExpression_669_Var
		);
		//669
		final UnaryExpression UnaryExpression_670_Var
		 = (UnaryExpression)CastExpression_669_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_670_Var
		);
		//670
		final PostfixExpression PostfixExpression_671_Var
		 = (PostfixExpression)UnaryExpression_670_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_671_Var
		);
		final EList<? extends EObject> Expr_671_list = PostfixExpression_671_Var
		.getExpr();
		Assert.assertNotNull(Expr_671_list);
		Assert.assertEquals(1, Expr_671_list.size());
		//671
		final PrimaryExpression PrimaryExpression_672_Var
		 = (PrimaryExpression)Expr_671_list.get(0);
		Assert.assertNotNull(PrimaryExpression_672_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_672_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_637_Var
		.getSemi());
		//672
		final Statement Statement_673_Var
		 = (Statement)Statement_347_list.get(7);
		Assert.assertNotNull(Statement_673_Var
		);
		//673
		final JumpStatement JumpStatement_674_Var
		 = (JumpStatement)Statement_673_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_674_Var
		);
		//674
		final Expression Expression_675_Var
		 = (Expression)JumpStatement_674_Var
		.getExpr();
		Assert.assertNotNull(Expression_675_Var
		);
		final EList<? extends EObject> ExprExpr_675_list = Expression_675_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_675_list);
		Assert.assertEquals(1, ExprExpr_675_list.size());
		//675
		final AssignmentExpression AssignmentExpression_676_Var
		 = (AssignmentExpression)ExprExpr_675_list.get(0);
		Assert.assertNotNull(AssignmentExpression_676_Var
		);
		//676
		final ConditionalExpression ConditionalExpression_677_Var
		 = (ConditionalExpression)AssignmentExpression_676_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_677_Var
		);
		//677
		final LogicalOrExpression LogicalOrExpression_678_Var
		 = (LogicalOrExpression)ConditionalExpression_677_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_678_Var
		);
		final EList<? extends EObject> Expr_678_list = LogicalOrExpression_678_Var
		.getExpr();
		Assert.assertNotNull(Expr_678_list);
		Assert.assertEquals(1, Expr_678_list.size());
		//678
		final LogicalAndExpression LogicalAndExpression_679_Var
		 = (LogicalAndExpression)Expr_678_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_679_Var
		);
		final EList<? extends EObject> Expr_679_list = LogicalAndExpression_679_Var
		.getExpr();
		Assert.assertNotNull(Expr_679_list);
		Assert.assertEquals(1, Expr_679_list.size());
		//679
		final InclusiveOrExpression InclusiveOrExpression_680_Var
		 = (InclusiveOrExpression)Expr_679_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_680_Var
		);
		final EList<? extends EObject> Expr_680_list = InclusiveOrExpression_680_Var
		.getExpr();
		Assert.assertNotNull(Expr_680_list);
		Assert.assertEquals(1, Expr_680_list.size());
		//680
		final ExclusiveOrExpression ExclusiveOrExpression_681_Var
		 = (ExclusiveOrExpression)Expr_680_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_681_Var
		);
		final EList<? extends EObject> Expr_681_list = ExclusiveOrExpression_681_Var
		.getExpr();
		Assert.assertNotNull(Expr_681_list);
		Assert.assertEquals(1, Expr_681_list.size());
		//681
		final AndExpression AndExpression_682_Var
		 = (AndExpression)Expr_681_list.get(0);
		Assert.assertNotNull(AndExpression_682_Var
		);
		final EList<? extends EObject> Expr_682_list = AndExpression_682_Var
		.getExpr();
		Assert.assertNotNull(Expr_682_list);
		Assert.assertEquals(1, Expr_682_list.size());
		//682
		final EqualityExpression EqualityExpression_683_Var
		 = (EqualityExpression)Expr_682_list.get(0);
		Assert.assertNotNull(EqualityExpression_683_Var
		);
		final EList<? extends EObject> Expr_683_list = EqualityExpression_683_Var
		.getExpr();
		Assert.assertNotNull(Expr_683_list);
		Assert.assertEquals(1, Expr_683_list.size());
		//683
		final RelationalExpression RelationalExpression_684_Var
		 = (RelationalExpression)Expr_683_list.get(0);
		Assert.assertNotNull(RelationalExpression_684_Var
		);
		final EList<? extends EObject> Expr_684_list = RelationalExpression_684_Var
		.getExpr();
		Assert.assertNotNull(Expr_684_list);
		Assert.assertEquals(1, Expr_684_list.size());
		//684
		final ShiftExpression ShiftExpression_685_Var
		 = (ShiftExpression)Expr_684_list.get(0);
		Assert.assertNotNull(ShiftExpression_685_Var
		);
		final EList<? extends EObject> Expr_685_list = ShiftExpression_685_Var
		.getExpr();
		Assert.assertNotNull(Expr_685_list);
		Assert.assertEquals(1, Expr_685_list.size());
		//685
		final AdditiveExpression AdditiveExpression_686_Var
		 = (AdditiveExpression)Expr_685_list.get(0);
		Assert.assertNotNull(AdditiveExpression_686_Var
		);
		final EList<? extends EObject> Expr_686_list = AdditiveExpression_686_Var
		.getExpr();
		Assert.assertNotNull(Expr_686_list);
		Assert.assertEquals(1, Expr_686_list.size());
		//686
		final MultiplicativeExpression MultiplicativeExpression_687_Var
		 = (MultiplicativeExpression)Expr_686_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_687_Var
		);
		final EList<? extends EObject> Expr_687_list = MultiplicativeExpression_687_Var
		.getExpr();
		Assert.assertNotNull(Expr_687_list);
		Assert.assertEquals(1, Expr_687_list.size());
		//687
		final CastExpression CastExpression_688_Var
		 = (CastExpression)Expr_687_list.get(0);
		Assert.assertNotNull(CastExpression_688_Var
		);
		//688
		final UnaryExpression UnaryExpression_689_Var
		 = (UnaryExpression)CastExpression_688_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_689_Var
		);
		//689
		final PostfixExpression PostfixExpression_690_Var
		 = (PostfixExpression)UnaryExpression_689_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_690_Var
		);
		final EList<? extends EObject> Expr_690_list = PostfixExpression_690_Var
		.getExpr();
		Assert.assertNotNull(Expr_690_list);
		Assert.assertEquals(1, Expr_690_list.size());
		//690
		final PrimaryExpression PrimaryExpression_691_Var
		 = (PrimaryExpression)Expr_690_list.get(0);
		Assert.assertNotNull(PrimaryExpression_691_Var
		);
		//691
		final Constant2 Constant2_692_Var
		 = (Constant2)PrimaryExpression_691_Var
		.getConst();
		Assert.assertNotNull(Constant2_692_Var
		);
		Assert.assertEquals("0", Constant2_692_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_674_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_674_Var
		.getSemi());
	}
	
	@Test
	(timeout=1000
	)
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


