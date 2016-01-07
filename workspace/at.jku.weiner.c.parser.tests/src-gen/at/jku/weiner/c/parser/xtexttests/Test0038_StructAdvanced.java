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
		Assert.assertEquals("[\"Joe Nobody\"]", PrimaryExpression_89_Var
		.getString().toString());
		//89
		final ExternalDeclaration ExternalDeclaration_90_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_90_Var
		);
		//90
		final Declaration Declaration_91_Var
		 = (Declaration)ExternalDeclaration_90_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_91_Var
		);
		//91
		final DeclarationSpecifiers DeclarationSpecifiers_92_Var
		 = (DeclarationSpecifiers)Declaration_91_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_92_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_92_list = DeclarationSpecifiers_92_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_92_list);
		Assert.assertEquals(1, DeclarationSpecifier_92_list.size());
		//92
		final TypeSpecifier TypeSpecifier_93_Var
		 = (TypeSpecifier)DeclarationSpecifier_92_list.get(0);
		Assert.assertNotNull(TypeSpecifier_93_Var
		);
		//93
		final TypedefName TypedefName_94_Var
		 = (TypedefName)TypeSpecifier_93_Var
		.getType();
		Assert.assertNotNull(TypedefName_94_Var
		);
		Assert.assertEquals("employee", TypedefName_94_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_94_list = Declaration_91_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_94_list);
		Assert.assertEquals(1, InitDeclaratorList_94_list.size());
		//94
		final InitDeclaratorList InitDeclaratorList_95_Var
		 = (InitDeclaratorList)InitDeclaratorList_94_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_95_Var
		);
		final EList<? extends EObject> InitDeclarator_95_list = InitDeclaratorList_95_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_95_list);
		Assert.assertEquals(1, InitDeclarator_95_list.size());
		//95
		final InitDeclarator InitDeclarator_96_Var
		 = (InitDeclarator)InitDeclarator_95_list.get(0);
		Assert.assertNotNull(InitDeclarator_96_Var
		);
		//96
		final Declarator Declarator_97_Var
		 = (Declarator)InitDeclarator_96_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_97_Var
		);
		//97
		final DirectDeclarator DirectDeclarator_98_Var
		 = (DirectDeclarator)Declarator_97_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_98_Var
		);
		Assert.assertEquals("phil", DirectDeclarator_98_Var
		.getId());
		//98
		final Initializer Initializer_99_Var
		 = (Initializer)InitDeclarator_96_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_99_Var
		);
		//99
		final InitializerList InitializerList_100_Var
		 = (InitializerList)Initializer_99_Var
		.getList();
		Assert.assertNotNull(InitializerList_100_Var
		);
		final EList<? extends EObject> Initializer_100_list = InitializerList_100_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_100_list);
		Assert.assertEquals(2, Initializer_100_list.size());
		//100
		final Initializer Initializer_101_Var
		 = (Initializer)Initializer_100_list.get(0);
		Assert.assertNotNull(Initializer_101_Var
		);
		//101
		final AssignmentExpression AssignmentExpression_102_Var
		 = (AssignmentExpression)Initializer_101_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_102_Var
		);
		//102
		final ConditionalExpression ConditionalExpression_103_Var
		 = (ConditionalExpression)AssignmentExpression_102_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_103_Var
		);
		//103
		final LogicalOrExpression LogicalOrExpression_104_Var
		 = (LogicalOrExpression)ConditionalExpression_103_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = LogicalOrExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final LogicalAndExpression LogicalAndExpression_105_Var
		 = (LogicalAndExpression)Expr_104_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = LogicalAndExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final InclusiveOrExpression InclusiveOrExpression_106_Var
		 = (InclusiveOrExpression)Expr_105_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = InclusiveOrExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final ExclusiveOrExpression ExclusiveOrExpression_107_Var
		 = (ExclusiveOrExpression)Expr_106_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = ExclusiveOrExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final AndExpression AndExpression_108_Var
		 = (AndExpression)Expr_107_list.get(0);
		Assert.assertNotNull(AndExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = AndExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final EqualityExpression EqualityExpression_109_Var
		 = (EqualityExpression)Expr_108_list.get(0);
		Assert.assertNotNull(EqualityExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = EqualityExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final RelationalExpression RelationalExpression_110_Var
		 = (RelationalExpression)Expr_109_list.get(0);
		Assert.assertNotNull(RelationalExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = RelationalExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final ShiftExpression ShiftExpression_111_Var
		 = (ShiftExpression)Expr_110_list.get(0);
		Assert.assertNotNull(ShiftExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = ShiftExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final AdditiveExpression AdditiveExpression_112_Var
		 = (AdditiveExpression)Expr_111_list.get(0);
		Assert.assertNotNull(AdditiveExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = AdditiveExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final MultiplicativeExpression MultiplicativeExpression_113_Var
		 = (MultiplicativeExpression)Expr_112_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = MultiplicativeExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final CastExpression CastExpression_114_Var
		 = (CastExpression)Expr_113_list.get(0);
		Assert.assertNotNull(CastExpression_114_Var
		);
		//114
		final UnaryExpression UnaryExpression_115_Var
		 = (UnaryExpression)CastExpression_114_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_115_Var
		);
		//115
		final PostfixExpression PostfixExpression_116_Var
		 = (PostfixExpression)UnaryExpression_115_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = PostfixExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final PrimaryExpression PrimaryExpression_117_Var
		 = (PrimaryExpression)Expr_116_list.get(0);
		Assert.assertNotNull(PrimaryExpression_117_Var
		);
		//117
		final Constant2 Constant2_118_Var
		 = (Constant2)PrimaryExpression_117_Var
		.getConst();
		Assert.assertNotNull(Constant2_118_Var
		);
		Assert.assertEquals("0x008", Constant2_118_Var
		.getHex());
		//118
		final Initializer Initializer_119_Var
		 = (Initializer)Initializer_100_list.get(1);
		Assert.assertNotNull(Initializer_119_Var
		);
		//119
		final AssignmentExpression AssignmentExpression_120_Var
		 = (AssignmentExpression)Initializer_119_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_120_Var
		);
		//120
		final ConditionalExpression ConditionalExpression_121_Var
		 = (ConditionalExpression)AssignmentExpression_120_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_121_Var
		);
		//121
		final LogicalOrExpression LogicalOrExpression_122_Var
		 = (LogicalOrExpression)ConditionalExpression_121_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = LogicalOrExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final LogicalAndExpression LogicalAndExpression_123_Var
		 = (LogicalAndExpression)Expr_122_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = LogicalAndExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final InclusiveOrExpression InclusiveOrExpression_124_Var
		 = (InclusiveOrExpression)Expr_123_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = InclusiveOrExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final ExclusiveOrExpression ExclusiveOrExpression_125_Var
		 = (ExclusiveOrExpression)Expr_124_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = ExclusiveOrExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final AndExpression AndExpression_126_Var
		 = (AndExpression)Expr_125_list.get(0);
		Assert.assertNotNull(AndExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = AndExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final EqualityExpression EqualityExpression_127_Var
		 = (EqualityExpression)Expr_126_list.get(0);
		Assert.assertNotNull(EqualityExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = EqualityExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final RelationalExpression RelationalExpression_128_Var
		 = (RelationalExpression)Expr_127_list.get(0);
		Assert.assertNotNull(RelationalExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = RelationalExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final ShiftExpression ShiftExpression_129_Var
		 = (ShiftExpression)Expr_128_list.get(0);
		Assert.assertNotNull(ShiftExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = ShiftExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final AdditiveExpression AdditiveExpression_130_Var
		 = (AdditiveExpression)Expr_129_list.get(0);
		Assert.assertNotNull(AdditiveExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = AdditiveExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final MultiplicativeExpression MultiplicativeExpression_131_Var
		 = (MultiplicativeExpression)Expr_130_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = MultiplicativeExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final CastExpression CastExpression_132_Var
		 = (CastExpression)Expr_131_list.get(0);
		Assert.assertNotNull(CastExpression_132_Var
		);
		//132
		final UnaryExpression UnaryExpression_133_Var
		 = (UnaryExpression)CastExpression_132_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_133_Var
		);
		//133
		final PostfixExpression PostfixExpression_134_Var
		 = (PostfixExpression)UnaryExpression_133_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = PostfixExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final PrimaryExpression PrimaryExpression_135_Var
		 = (PrimaryExpression)Expr_134_list.get(0);
		Assert.assertNotNull(PrimaryExpression_135_Var
		);
		Assert.assertEquals("[\"Phil Morrison\"]", PrimaryExpression_135_Var
		.getString().toString());
		//135
		final ExternalDeclaration ExternalDeclaration_136_Var
		 = (ExternalDeclaration)External_0_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_136_Var
		);
		//136
		final FunctionDefHead FunctionDefHead_137_Var
		 = (FunctionDefHead)ExternalDeclaration_136_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_137_Var
		);
		//137
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_138_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_137_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_138_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_138_list = FunctionDeclarationSpecifiers_138_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_138_list);
		Assert.assertEquals(1, DeclarationSpecifier_138_list.size());
		//138
		final TypeSpecifier TypeSpecifier_139_Var
		 = (TypeSpecifier)DeclarationSpecifier_138_list.get(0);
		Assert.assertNotNull(TypeSpecifier_139_Var
		);
		Assert.assertEquals("void", TypeSpecifier_139_Var
		.getName());
		//139
		final Declarator Declarator_140_Var
		 = (Declarator)FunctionDefHead_137_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_140_Var
		);
		//140
		final DirectDeclarator DirectDeclarator_141_Var
		 = (DirectDeclarator)Declarator_140_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_141_Var
		);
		Assert.assertEquals("print", DirectDeclarator_141_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_141_list = DirectDeclarator_141_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_141_list);
		Assert.assertEquals(1, DeclaratorSuffix_141_list.size());
		//141
		final DeclaratorSuffix DeclaratorSuffix_142_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_141_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_142_Var
		);
		//142
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_143_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_142_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_143_Var
		);
		final EList<? extends EObject> ParameterTypeList_143_list = DirectDeclaratorLastSuffix_143_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_143_list);
		Assert.assertEquals(1, ParameterTypeList_143_list.size());
		//143
		final ParameterTypeList ParameterTypeList_144_Var
		 = (ParameterTypeList)ParameterTypeList_143_list.get(0);
		Assert.assertNotNull(ParameterTypeList_144_Var
		);
		//144
		final ParameterList ParameterList_145_Var
		 = (ParameterList)ParameterTypeList_144_Var
		.getList();
		Assert.assertNotNull(ParameterList_145_Var
		);
		final EList<? extends EObject> ParameterDeclaration_145_list = ParameterList_145_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_145_list);
		Assert.assertEquals(1, ParameterDeclaration_145_list.size());
		//145
		final ParameterDeclaration ParameterDeclaration_146_Var
		 = (ParameterDeclaration)ParameterDeclaration_145_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_146_Var
		);
		//146
		final DeclarationSpecifiers DeclarationSpecifiers_147_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_146_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_147_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_147_list = DeclarationSpecifiers_147_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_147_list);
		Assert.assertEquals(1, DeclarationSpecifier_147_list.size());
		//147
		final TypeSpecifier TypeSpecifier_148_Var
		 = (TypeSpecifier)DeclarationSpecifier_147_list.get(0);
		Assert.assertNotNull(TypeSpecifier_148_Var
		);
		//148
		final TypedefName TypedefName_149_Var
		 = (TypedefName)TypeSpecifier_148_Var
		.getType();
		Assert.assertNotNull(TypedefName_149_Var
		);
		Assert.assertEquals("employee", TypedefName_149_Var
		.getId());
		//149
		final Declarator Declarator_150_Var
		 = (Declarator)ParameterDeclaration_146_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_150_Var
		);
		//150
		final DirectDeclarator DirectDeclarator_151_Var
		 = (DirectDeclarator)Declarator_150_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_151_Var
		);
		Assert.assertEquals("emp", DirectDeclarator_151_Var
		.getId());
		//151
		final Pointer Pointer_152_Var
		 = (Pointer)Declarator_150_Var
		.getPointer();
		Assert.assertNotNull(Pointer_152_Var
		);
		Assert.assertEquals("[*]", Pointer_152_Var
		.getStar().toString());
		//152
		final FunctionDefinition FunctionDefinition_153_Var
		 = (FunctionDefinition)ExternalDeclaration_136_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_153_Var
		);
		//153
		final BodyStatement BodyStatement_154_Var
		 = (BodyStatement)FunctionDefinition_153_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_154_Var
		);
		final EList<? extends EObject> BlockList_154_list = BodyStatement_154_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_154_list);
		Assert.assertEquals(1, BlockList_154_list.size());
		//154
		final BlockList BlockList_155_Var
		 = (BlockList)BlockList_154_list.get(0);
		Assert.assertNotNull(BlockList_155_Var
		);
		final EList<? extends EObject> Statement_155_list = BlockList_155_Var
		.getStatement();
		Assert.assertNotNull(Statement_155_list);
		Assert.assertEquals(2, Statement_155_list.size());
		//155
		final Statement Statement_156_Var
		 = (Statement)Statement_155_list.get(0);
		Assert.assertNotNull(Statement_156_Var
		);
		//156
		final ExpressionStatement ExpressionStatement_157_Var
		 = (ExpressionStatement)Statement_156_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_157_Var
		);
		//157
		final Expression Expression_158_Var
		 = (Expression)ExpressionStatement_157_Var
		.getExpression();
		Assert.assertNotNull(Expression_158_Var
		);
		final EList<? extends EObject> ExprExpr_158_list = Expression_158_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_158_list);
		Assert.assertEquals(1, ExprExpr_158_list.size());
		//158
		final AssignmentExpression AssignmentExpression_159_Var
		 = (AssignmentExpression)ExprExpr_158_list.get(0);
		Assert.assertNotNull(AssignmentExpression_159_Var
		);
		//159
		final ConditionalExpression ConditionalExpression_160_Var
		 = (ConditionalExpression)AssignmentExpression_159_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_160_Var
		);
		//160
		final LogicalOrExpression LogicalOrExpression_161_Var
		 = (LogicalOrExpression)ConditionalExpression_160_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = LogicalOrExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final LogicalAndExpression LogicalAndExpression_162_Var
		 = (LogicalAndExpression)Expr_161_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_162_Var
		);
		final EList<? extends EObject> Expr_162_list = LogicalAndExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		//162
		final InclusiveOrExpression InclusiveOrExpression_163_Var
		 = (InclusiveOrExpression)Expr_162_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_163_Var
		);
		final EList<? extends EObject> Expr_163_list = InclusiveOrExpression_163_Var
		.getExpr();
		Assert.assertNotNull(Expr_163_list);
		Assert.assertEquals(1, Expr_163_list.size());
		//163
		final ExclusiveOrExpression ExclusiveOrExpression_164_Var
		 = (ExclusiveOrExpression)Expr_163_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_164_Var
		);
		final EList<? extends EObject> Expr_164_list = ExclusiveOrExpression_164_Var
		.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		//164
		final AndExpression AndExpression_165_Var
		 = (AndExpression)Expr_164_list.get(0);
		Assert.assertNotNull(AndExpression_165_Var
		);
		final EList<? extends EObject> Expr_165_list = AndExpression_165_Var
		.getExpr();
		Assert.assertNotNull(Expr_165_list);
		Assert.assertEquals(1, Expr_165_list.size());
		//165
		final EqualityExpression EqualityExpression_166_Var
		 = (EqualityExpression)Expr_165_list.get(0);
		Assert.assertNotNull(EqualityExpression_166_Var
		);
		final EList<? extends EObject> Expr_166_list = EqualityExpression_166_Var
		.getExpr();
		Assert.assertNotNull(Expr_166_list);
		Assert.assertEquals(1, Expr_166_list.size());
		//166
		final RelationalExpression RelationalExpression_167_Var
		 = (RelationalExpression)Expr_166_list.get(0);
		Assert.assertNotNull(RelationalExpression_167_Var
		);
		final EList<? extends EObject> Expr_167_list = RelationalExpression_167_Var
		.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(1, Expr_167_list.size());
		//167
		final ShiftExpression ShiftExpression_168_Var
		 = (ShiftExpression)Expr_167_list.get(0);
		Assert.assertNotNull(ShiftExpression_168_Var
		);
		final EList<? extends EObject> Expr_168_list = ShiftExpression_168_Var
		.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(1, Expr_168_list.size());
		//168
		final AdditiveExpression AdditiveExpression_169_Var
		 = (AdditiveExpression)Expr_168_list.get(0);
		Assert.assertNotNull(AdditiveExpression_169_Var
		);
		final EList<? extends EObject> Expr_169_list = AdditiveExpression_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		//169
		final MultiplicativeExpression MultiplicativeExpression_170_Var
		 = (MultiplicativeExpression)Expr_169_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_170_Var
		);
		final EList<? extends EObject> Expr_170_list = MultiplicativeExpression_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		//170
		final CastExpression CastExpression_171_Var
		 = (CastExpression)Expr_170_list.get(0);
		Assert.assertNotNull(CastExpression_171_Var
		);
		//171
		final UnaryExpression UnaryExpression_172_Var
		 = (UnaryExpression)CastExpression_171_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_172_Var
		);
		//172
		final PostfixExpression PostfixExpression_173_Var
		 = (PostfixExpression)UnaryExpression_172_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = PostfixExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final PrimaryExpression PrimaryExpression_174_Var
		 = (PrimaryExpression)Expr_173_list.get(0);
		Assert.assertNotNull(PrimaryExpression_174_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_174_Var
		.getId());
		final EList<? extends EObject> Suffix_174_list = PostfixExpression_173_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_174_list);
		Assert.assertEquals(1, Suffix_174_list.size());
		//174
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_175_Var
		 = (PostfixExpressionSuffixArgument)Suffix_174_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_175_Var
		);
		//175
		final ArgumentExpressionList ArgumentExpressionList_176_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_175_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_176_Var
		);
		final EList<? extends EObject> Expr_176_list = ArgumentExpressionList_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(2, Expr_176_list.size());
		//176
		final AssignmentExpression AssignmentExpression_177_Var
		 = (AssignmentExpression)Expr_176_list.get(0);
		Assert.assertNotNull(AssignmentExpression_177_Var
		);
		//177
		final ConditionalExpression ConditionalExpression_178_Var
		 = (ConditionalExpression)AssignmentExpression_177_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_178_Var
		);
		//178
		final LogicalOrExpression LogicalOrExpression_179_Var
		 = (LogicalOrExpression)ConditionalExpression_178_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = LogicalOrExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final LogicalAndExpression LogicalAndExpression_180_Var
		 = (LogicalAndExpression)Expr_179_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_180_Var
		);
		final EList<? extends EObject> Expr_180_list = LogicalAndExpression_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final InclusiveOrExpression InclusiveOrExpression_181_Var
		 = (InclusiveOrExpression)Expr_180_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_181_Var
		);
		final EList<? extends EObject> Expr_181_list = InclusiveOrExpression_181_Var
		.getExpr();
		Assert.assertNotNull(Expr_181_list);
		Assert.assertEquals(1, Expr_181_list.size());
		//181
		final ExclusiveOrExpression ExclusiveOrExpression_182_Var
		 = (ExclusiveOrExpression)Expr_181_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_182_Var
		);
		final EList<? extends EObject> Expr_182_list = ExclusiveOrExpression_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(1, Expr_182_list.size());
		//182
		final AndExpression AndExpression_183_Var
		 = (AndExpression)Expr_182_list.get(0);
		Assert.assertNotNull(AndExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = AndExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final EqualityExpression EqualityExpression_184_Var
		 = (EqualityExpression)Expr_183_list.get(0);
		Assert.assertNotNull(EqualityExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = EqualityExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final RelationalExpression RelationalExpression_185_Var
		 = (RelationalExpression)Expr_184_list.get(0);
		Assert.assertNotNull(RelationalExpression_185_Var
		);
		final EList<? extends EObject> Expr_185_list = RelationalExpression_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final ShiftExpression ShiftExpression_186_Var
		 = (ShiftExpression)Expr_185_list.get(0);
		Assert.assertNotNull(ShiftExpression_186_Var
		);
		final EList<? extends EObject> Expr_186_list = ShiftExpression_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(1, Expr_186_list.size());
		//186
		final AdditiveExpression AdditiveExpression_187_Var
		 = (AdditiveExpression)Expr_186_list.get(0);
		Assert.assertNotNull(AdditiveExpression_187_Var
		);
		final EList<? extends EObject> Expr_187_list = AdditiveExpression_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(1, Expr_187_list.size());
		//187
		final MultiplicativeExpression MultiplicativeExpression_188_Var
		 = (MultiplicativeExpression)Expr_187_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = MultiplicativeExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final CastExpression CastExpression_189_Var
		 = (CastExpression)Expr_188_list.get(0);
		Assert.assertNotNull(CastExpression_189_Var
		);
		//189
		final UnaryExpression UnaryExpression_190_Var
		 = (UnaryExpression)CastExpression_189_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_190_Var
		);
		//190
		final PostfixExpression PostfixExpression_191_Var
		 = (PostfixExpression)UnaryExpression_190_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = PostfixExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final PrimaryExpression PrimaryExpression_192_Var
		 = (PrimaryExpression)Expr_191_list.get(0);
		Assert.assertNotNull(PrimaryExpression_192_Var
		);
		Assert.assertEquals("[\"(*employee).id=%d\\n\"]", PrimaryExpression_192_Var
		.getString().toString());
		//192
		final AssignmentExpression AssignmentExpression_193_Var
		 = (AssignmentExpression)Expr_176_list.get(1);
		Assert.assertNotNull(AssignmentExpression_193_Var
		);
		//193
		final ConditionalExpression ConditionalExpression_194_Var
		 = (ConditionalExpression)AssignmentExpression_193_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_194_Var
		);
		//194
		final LogicalOrExpression LogicalOrExpression_195_Var
		 = (LogicalOrExpression)ConditionalExpression_194_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = LogicalOrExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final LogicalAndExpression LogicalAndExpression_196_Var
		 = (LogicalAndExpression)Expr_195_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = LogicalAndExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final InclusiveOrExpression InclusiveOrExpression_197_Var
		 = (InclusiveOrExpression)Expr_196_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = InclusiveOrExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final ExclusiveOrExpression ExclusiveOrExpression_198_Var
		 = (ExclusiveOrExpression)Expr_197_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = ExclusiveOrExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final AndExpression AndExpression_199_Var
		 = (AndExpression)Expr_198_list.get(0);
		Assert.assertNotNull(AndExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = AndExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final EqualityExpression EqualityExpression_200_Var
		 = (EqualityExpression)Expr_199_list.get(0);
		Assert.assertNotNull(EqualityExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = EqualityExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final RelationalExpression RelationalExpression_201_Var
		 = (RelationalExpression)Expr_200_list.get(0);
		Assert.assertNotNull(RelationalExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = RelationalExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final ShiftExpression ShiftExpression_202_Var
		 = (ShiftExpression)Expr_201_list.get(0);
		Assert.assertNotNull(ShiftExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = ShiftExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final AdditiveExpression AdditiveExpression_203_Var
		 = (AdditiveExpression)Expr_202_list.get(0);
		Assert.assertNotNull(AdditiveExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = AdditiveExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final MultiplicativeExpression MultiplicativeExpression_204_Var
		 = (MultiplicativeExpression)Expr_203_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = MultiplicativeExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final CastExpression CastExpression_205_Var
		 = (CastExpression)Expr_204_list.get(0);
		Assert.assertNotNull(CastExpression_205_Var
		);
		//205
		final UnaryExpression UnaryExpression_206_Var
		 = (UnaryExpression)CastExpression_205_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_206_Var
		);
		//206
		final PostfixExpression PostfixExpression_207_Var
		 = (PostfixExpression)UnaryExpression_206_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = PostfixExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final PrimaryExpression PrimaryExpression_208_Var
		 = (PrimaryExpression)Expr_207_list.get(0);
		Assert.assertNotNull(PrimaryExpression_208_Var
		);
		//208
		final Expression Expression_209_Var
		 = (Expression)PrimaryExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expression_209_Var
		);
		final EList<? extends EObject> ExprExpr_209_list = Expression_209_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_209_list);
		Assert.assertEquals(1, ExprExpr_209_list.size());
		//209
		final AssignmentExpression AssignmentExpression_210_Var
		 = (AssignmentExpression)ExprExpr_209_list.get(0);
		Assert.assertNotNull(AssignmentExpression_210_Var
		);
		//210
		final ConditionalExpression ConditionalExpression_211_Var
		 = (ConditionalExpression)AssignmentExpression_210_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_211_Var
		);
		//211
		final LogicalOrExpression LogicalOrExpression_212_Var
		 = (LogicalOrExpression)ConditionalExpression_211_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = LogicalOrExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final LogicalAndExpression LogicalAndExpression_213_Var
		 = (LogicalAndExpression)Expr_212_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = LogicalAndExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final InclusiveOrExpression InclusiveOrExpression_214_Var
		 = (InclusiveOrExpression)Expr_213_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = InclusiveOrExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final ExclusiveOrExpression ExclusiveOrExpression_215_Var
		 = (ExclusiveOrExpression)Expr_214_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = ExclusiveOrExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final AndExpression AndExpression_216_Var
		 = (AndExpression)Expr_215_list.get(0);
		Assert.assertNotNull(AndExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = AndExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final EqualityExpression EqualityExpression_217_Var
		 = (EqualityExpression)Expr_216_list.get(0);
		Assert.assertNotNull(EqualityExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = EqualityExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final RelationalExpression RelationalExpression_218_Var
		 = (RelationalExpression)Expr_217_list.get(0);
		Assert.assertNotNull(RelationalExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = RelationalExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final ShiftExpression ShiftExpression_219_Var
		 = (ShiftExpression)Expr_218_list.get(0);
		Assert.assertNotNull(ShiftExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = ShiftExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final AdditiveExpression AdditiveExpression_220_Var
		 = (AdditiveExpression)Expr_219_list.get(0);
		Assert.assertNotNull(AdditiveExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = AdditiveExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final MultiplicativeExpression MultiplicativeExpression_221_Var
		 = (MultiplicativeExpression)Expr_220_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = MultiplicativeExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final CastExpression CastExpression_222_Var
		 = (CastExpression)Expr_221_list.get(0);
		Assert.assertNotNull(CastExpression_222_Var
		);
		//222
		final UnaryExpression UnaryExpression_223_Var
		 = (UnaryExpression)CastExpression_222_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_223_Var
		);
		//223
		final UnaryOperator UnaryOperator_224_Var
		 = (UnaryOperator)UnaryExpression_223_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_224_Var
		);
		Assert.assertEquals("*", UnaryOperator_224_Var
		.getOp());
		//224
		final CastExpression CastExpression_225_Var
		 = (CastExpression)UnaryExpression_223_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_225_Var
		);
		//225
		final UnaryExpression UnaryExpression_226_Var
		 = (UnaryExpression)CastExpression_225_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_226_Var
		);
		//226
		final PostfixExpression PostfixExpression_227_Var
		 = (PostfixExpression)UnaryExpression_226_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = PostfixExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final PrimaryExpression PrimaryExpression_228_Var
		 = (PrimaryExpression)Expr_227_list.get(0);
		Assert.assertNotNull(PrimaryExpression_228_Var
		);
		Assert.assertEquals("emp", PrimaryExpression_228_Var
		.getId());
		final EList<? extends EObject> Suffix_228_list = PostfixExpression_207_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_228_list);
		Assert.assertEquals(1, Suffix_228_list.size());
		//228
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_229_Var
		 = (PostfixExpressionSuffixDot)Suffix_228_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_229_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_229_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_157_Var
		.getSemi());
		//229
		final Statement Statement_230_Var
		 = (Statement)Statement_155_list.get(1);
		Assert.assertNotNull(Statement_230_Var
		);
		//230
		final ExpressionStatement ExpressionStatement_231_Var
		 = (ExpressionStatement)Statement_230_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_231_Var
		);
		//231
		final Expression Expression_232_Var
		 = (Expression)ExpressionStatement_231_Var
		.getExpression();
		Assert.assertNotNull(Expression_232_Var
		);
		final EList<? extends EObject> ExprExpr_232_list = Expression_232_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_232_list);
		Assert.assertEquals(1, ExprExpr_232_list.size());
		//232
		final AssignmentExpression AssignmentExpression_233_Var
		 = (AssignmentExpression)ExprExpr_232_list.get(0);
		Assert.assertNotNull(AssignmentExpression_233_Var
		);
		//233
		final ConditionalExpression ConditionalExpression_234_Var
		 = (ConditionalExpression)AssignmentExpression_233_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_234_Var
		);
		//234
		final LogicalOrExpression LogicalOrExpression_235_Var
		 = (LogicalOrExpression)ConditionalExpression_234_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = LogicalOrExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final LogicalAndExpression LogicalAndExpression_236_Var
		 = (LogicalAndExpression)Expr_235_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = LogicalAndExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final InclusiveOrExpression InclusiveOrExpression_237_Var
		 = (InclusiveOrExpression)Expr_236_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = InclusiveOrExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final ExclusiveOrExpression ExclusiveOrExpression_238_Var
		 = (ExclusiveOrExpression)Expr_237_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = ExclusiveOrExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final AndExpression AndExpression_239_Var
		 = (AndExpression)Expr_238_list.get(0);
		Assert.assertNotNull(AndExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = AndExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final EqualityExpression EqualityExpression_240_Var
		 = (EqualityExpression)Expr_239_list.get(0);
		Assert.assertNotNull(EqualityExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = EqualityExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final RelationalExpression RelationalExpression_241_Var
		 = (RelationalExpression)Expr_240_list.get(0);
		Assert.assertNotNull(RelationalExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = RelationalExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final ShiftExpression ShiftExpression_242_Var
		 = (ShiftExpression)Expr_241_list.get(0);
		Assert.assertNotNull(ShiftExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = ShiftExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final AdditiveExpression AdditiveExpression_243_Var
		 = (AdditiveExpression)Expr_242_list.get(0);
		Assert.assertNotNull(AdditiveExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = AdditiveExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final MultiplicativeExpression MultiplicativeExpression_244_Var
		 = (MultiplicativeExpression)Expr_243_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = MultiplicativeExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final CastExpression CastExpression_245_Var
		 = (CastExpression)Expr_244_list.get(0);
		Assert.assertNotNull(CastExpression_245_Var
		);
		//245
		final UnaryExpression UnaryExpression_246_Var
		 = (UnaryExpression)CastExpression_245_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_246_Var
		);
		//246
		final PostfixExpression PostfixExpression_247_Var
		 = (PostfixExpression)UnaryExpression_246_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = PostfixExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final PrimaryExpression PrimaryExpression_248_Var
		 = (PrimaryExpression)Expr_247_list.get(0);
		Assert.assertNotNull(PrimaryExpression_248_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_248_Var
		.getId());
		final EList<? extends EObject> Suffix_248_list = PostfixExpression_247_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_248_list);
		Assert.assertEquals(1, Suffix_248_list.size());
		//248
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_249_Var
		 = (PostfixExpressionSuffixArgument)Suffix_248_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_249_Var
		);
		//249
		final ArgumentExpressionList ArgumentExpressionList_250_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_249_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_250_Var
		);
		final EList<? extends EObject> Expr_250_list = ArgumentExpressionList_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(2, Expr_250_list.size());
		//250
		final AssignmentExpression AssignmentExpression_251_Var
		 = (AssignmentExpression)Expr_250_list.get(0);
		Assert.assertNotNull(AssignmentExpression_251_Var
		);
		//251
		final ConditionalExpression ConditionalExpression_252_Var
		 = (ConditionalExpression)AssignmentExpression_251_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_252_Var
		);
		//252
		final LogicalOrExpression LogicalOrExpression_253_Var
		 = (LogicalOrExpression)ConditionalExpression_252_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = LogicalOrExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final LogicalAndExpression LogicalAndExpression_254_Var
		 = (LogicalAndExpression)Expr_253_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = LogicalAndExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final InclusiveOrExpression InclusiveOrExpression_255_Var
		 = (InclusiveOrExpression)Expr_254_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_255_Var
		);
		final EList<? extends EObject> Expr_255_list = InclusiveOrExpression_255_Var
		.getExpr();
		Assert.assertNotNull(Expr_255_list);
		Assert.assertEquals(1, Expr_255_list.size());
		//255
		final ExclusiveOrExpression ExclusiveOrExpression_256_Var
		 = (ExclusiveOrExpression)Expr_255_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_256_Var
		);
		final EList<? extends EObject> Expr_256_list = ExclusiveOrExpression_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(1, Expr_256_list.size());
		//256
		final AndExpression AndExpression_257_Var
		 = (AndExpression)Expr_256_list.get(0);
		Assert.assertNotNull(AndExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = AndExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final EqualityExpression EqualityExpression_258_Var
		 = (EqualityExpression)Expr_257_list.get(0);
		Assert.assertNotNull(EqualityExpression_258_Var
		);
		final EList<? extends EObject> Expr_258_list = EqualityExpression_258_Var
		.getExpr();
		Assert.assertNotNull(Expr_258_list);
		Assert.assertEquals(1, Expr_258_list.size());
		//258
		final RelationalExpression RelationalExpression_259_Var
		 = (RelationalExpression)Expr_258_list.get(0);
		Assert.assertNotNull(RelationalExpression_259_Var
		);
		final EList<? extends EObject> Expr_259_list = RelationalExpression_259_Var
		.getExpr();
		Assert.assertNotNull(Expr_259_list);
		Assert.assertEquals(1, Expr_259_list.size());
		//259
		final ShiftExpression ShiftExpression_260_Var
		 = (ShiftExpression)Expr_259_list.get(0);
		Assert.assertNotNull(ShiftExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = ShiftExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final AdditiveExpression AdditiveExpression_261_Var
		 = (AdditiveExpression)Expr_260_list.get(0);
		Assert.assertNotNull(AdditiveExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = AdditiveExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final MultiplicativeExpression MultiplicativeExpression_262_Var
		 = (MultiplicativeExpression)Expr_261_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_262_Var
		);
		final EList<? extends EObject> Expr_262_list = MultiplicativeExpression_262_Var
		.getExpr();
		Assert.assertNotNull(Expr_262_list);
		Assert.assertEquals(1, Expr_262_list.size());
		//262
		final CastExpression CastExpression_263_Var
		 = (CastExpression)Expr_262_list.get(0);
		Assert.assertNotNull(CastExpression_263_Var
		);
		//263
		final UnaryExpression UnaryExpression_264_Var
		 = (UnaryExpression)CastExpression_263_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_264_Var
		);
		//264
		final PostfixExpression PostfixExpression_265_Var
		 = (PostfixExpression)UnaryExpression_264_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_265_Var
		);
		final EList<? extends EObject> Expr_265_list = PostfixExpression_265_Var
		.getExpr();
		Assert.assertNotNull(Expr_265_list);
		Assert.assertEquals(1, Expr_265_list.size());
		//265
		final PrimaryExpression PrimaryExpression_266_Var
		 = (PrimaryExpression)Expr_265_list.get(0);
		Assert.assertNotNull(PrimaryExpression_266_Var
		);
		Assert.assertEquals("[\"employee->name=%s\\n\"]", PrimaryExpression_266_Var
		.getString().toString());
		//266
		final AssignmentExpression AssignmentExpression_267_Var
		 = (AssignmentExpression)Expr_250_list.get(1);
		Assert.assertNotNull(AssignmentExpression_267_Var
		);
		//267
		final ConditionalExpression ConditionalExpression_268_Var
		 = (ConditionalExpression)AssignmentExpression_267_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_268_Var
		);
		//268
		final LogicalOrExpression LogicalOrExpression_269_Var
		 = (LogicalOrExpression)ConditionalExpression_268_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_269_Var
		);
		final EList<? extends EObject> Expr_269_list = LogicalOrExpression_269_Var
		.getExpr();
		Assert.assertNotNull(Expr_269_list);
		Assert.assertEquals(1, Expr_269_list.size());
		//269
		final LogicalAndExpression LogicalAndExpression_270_Var
		 = (LogicalAndExpression)Expr_269_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_270_Var
		);
		final EList<? extends EObject> Expr_270_list = LogicalAndExpression_270_Var
		.getExpr();
		Assert.assertNotNull(Expr_270_list);
		Assert.assertEquals(1, Expr_270_list.size());
		//270
		final InclusiveOrExpression InclusiveOrExpression_271_Var
		 = (InclusiveOrExpression)Expr_270_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_271_Var
		);
		final EList<? extends EObject> Expr_271_list = InclusiveOrExpression_271_Var
		.getExpr();
		Assert.assertNotNull(Expr_271_list);
		Assert.assertEquals(1, Expr_271_list.size());
		//271
		final ExclusiveOrExpression ExclusiveOrExpression_272_Var
		 = (ExclusiveOrExpression)Expr_271_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_272_Var
		);
		final EList<? extends EObject> Expr_272_list = ExclusiveOrExpression_272_Var
		.getExpr();
		Assert.assertNotNull(Expr_272_list);
		Assert.assertEquals(1, Expr_272_list.size());
		//272
		final AndExpression AndExpression_273_Var
		 = (AndExpression)Expr_272_list.get(0);
		Assert.assertNotNull(AndExpression_273_Var
		);
		final EList<? extends EObject> Expr_273_list = AndExpression_273_Var
		.getExpr();
		Assert.assertNotNull(Expr_273_list);
		Assert.assertEquals(1, Expr_273_list.size());
		//273
		final EqualityExpression EqualityExpression_274_Var
		 = (EqualityExpression)Expr_273_list.get(0);
		Assert.assertNotNull(EqualityExpression_274_Var
		);
		final EList<? extends EObject> Expr_274_list = EqualityExpression_274_Var
		.getExpr();
		Assert.assertNotNull(Expr_274_list);
		Assert.assertEquals(1, Expr_274_list.size());
		//274
		final RelationalExpression RelationalExpression_275_Var
		 = (RelationalExpression)Expr_274_list.get(0);
		Assert.assertNotNull(RelationalExpression_275_Var
		);
		final EList<? extends EObject> Expr_275_list = RelationalExpression_275_Var
		.getExpr();
		Assert.assertNotNull(Expr_275_list);
		Assert.assertEquals(1, Expr_275_list.size());
		//275
		final ShiftExpression ShiftExpression_276_Var
		 = (ShiftExpression)Expr_275_list.get(0);
		Assert.assertNotNull(ShiftExpression_276_Var
		);
		final EList<? extends EObject> Expr_276_list = ShiftExpression_276_Var
		.getExpr();
		Assert.assertNotNull(Expr_276_list);
		Assert.assertEquals(1, Expr_276_list.size());
		//276
		final AdditiveExpression AdditiveExpression_277_Var
		 = (AdditiveExpression)Expr_276_list.get(0);
		Assert.assertNotNull(AdditiveExpression_277_Var
		);
		final EList<? extends EObject> Expr_277_list = AdditiveExpression_277_Var
		.getExpr();
		Assert.assertNotNull(Expr_277_list);
		Assert.assertEquals(1, Expr_277_list.size());
		//277
		final MultiplicativeExpression MultiplicativeExpression_278_Var
		 = (MultiplicativeExpression)Expr_277_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_278_Var
		);
		final EList<? extends EObject> Expr_278_list = MultiplicativeExpression_278_Var
		.getExpr();
		Assert.assertNotNull(Expr_278_list);
		Assert.assertEquals(1, Expr_278_list.size());
		//278
		final CastExpression CastExpression_279_Var
		 = (CastExpression)Expr_278_list.get(0);
		Assert.assertNotNull(CastExpression_279_Var
		);
		//279
		final UnaryExpression UnaryExpression_280_Var
		 = (UnaryExpression)CastExpression_279_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_280_Var
		);
		//280
		final PostfixExpression PostfixExpression_281_Var
		 = (PostfixExpression)UnaryExpression_280_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_281_Var
		);
		final EList<? extends EObject> Expr_281_list = PostfixExpression_281_Var
		.getExpr();
		Assert.assertNotNull(Expr_281_list);
		Assert.assertEquals(1, Expr_281_list.size());
		//281
		final PrimaryExpression PrimaryExpression_282_Var
		 = (PrimaryExpression)Expr_281_list.get(0);
		Assert.assertNotNull(PrimaryExpression_282_Var
		);
		Assert.assertEquals("emp", PrimaryExpression_282_Var
		.getId());
		final EList<? extends EObject> Suffix_282_list = PostfixExpression_281_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_282_list);
		Assert.assertEquals(1, Suffix_282_list.size());
		//282
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_283_Var
		 = (PostfixExpressionSuffixArrow)Suffix_282_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArrow_283_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixArrow_283_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_231_Var
		.getSemi());
		//283
		final ExternalDeclaration ExternalDeclaration_284_Var
		 = (ExternalDeclaration)External_0_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_284_Var
		);
		//284
		final FunctionDefHead FunctionDefHead_285_Var
		 = (FunctionDefHead)ExternalDeclaration_284_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_285_Var
		);
		//285
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_286_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_285_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_286_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_286_list = FunctionDeclarationSpecifiers_286_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_286_list);
		Assert.assertEquals(1, DeclarationSpecifier_286_list.size());
		//286
		final TypeSpecifier TypeSpecifier_287_Var
		 = (TypeSpecifier)DeclarationSpecifier_286_list.get(0);
		Assert.assertNotNull(TypeSpecifier_287_Var
		);
		Assert.assertEquals("int", TypeSpecifier_287_Var
		.getName());
		//287
		final Declarator Declarator_288_Var
		 = (Declarator)FunctionDefHead_285_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_288_Var
		);
		//288
		final DirectDeclarator DirectDeclarator_289_Var
		 = (DirectDeclarator)Declarator_288_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_289_Var
		);
		Assert.assertEquals("main", DirectDeclarator_289_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_289_list = DirectDeclarator_289_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_289_list);
		Assert.assertEquals(1, DeclaratorSuffix_289_list.size());
		//289
		final DeclaratorSuffix DeclaratorSuffix_290_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_289_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_290_Var
		);
		//290
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_291_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_290_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_291_Var
		);
		final EList<? extends EObject> ParameterTypeList_291_list = DirectDeclaratorLastSuffix_291_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_291_list);
		Assert.assertEquals(1, ParameterTypeList_291_list.size());
		//291
		final ParameterTypeList ParameterTypeList_292_Var
		 = (ParameterTypeList)ParameterTypeList_291_list.get(0);
		Assert.assertNotNull(ParameterTypeList_292_Var
		);
		//292
		final ParameterList ParameterList_293_Var
		 = (ParameterList)ParameterTypeList_292_Var
		.getList();
		Assert.assertNotNull(ParameterList_293_Var
		);
		final EList<? extends EObject> ParameterDeclaration_293_list = ParameterList_293_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_293_list);
		Assert.assertEquals(1, ParameterDeclaration_293_list.size());
		//293
		final ParameterDeclaration ParameterDeclaration_294_Var
		 = (ParameterDeclaration)ParameterDeclaration_293_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_294_Var
		);
		//294
		final DeclarationSpecifiers DeclarationSpecifiers_295_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_294_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_295_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_295_list = DeclarationSpecifiers_295_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_295_list);
		Assert.assertEquals(1, DeclarationSpecifier_295_list.size());
		//295
		final TypeSpecifier TypeSpecifier_296_Var
		 = (TypeSpecifier)DeclarationSpecifier_295_list.get(0);
		Assert.assertNotNull(TypeSpecifier_296_Var
		);
		Assert.assertEquals("void", TypeSpecifier_296_Var
		.getName());
		//296
		final FunctionDefinition FunctionDefinition_297_Var
		 = (FunctionDefinition)ExternalDeclaration_284_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_297_Var
		);
		//297
		final BodyStatement BodyStatement_298_Var
		 = (BodyStatement)FunctionDefinition_297_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_298_Var
		);
		final EList<? extends EObject> BlockList_298_list = BodyStatement_298_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_298_list);
		Assert.assertEquals(1, BlockList_298_list.size());
		//298
		final BlockList BlockList_299_Var
		 = (BlockList)BlockList_298_list.get(0);
		Assert.assertNotNull(BlockList_299_Var
		);
		final EList<? extends EObject> Declaration_299_list = BlockList_299_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_299_list);
		Assert.assertEquals(1, Declaration_299_list.size());
		//299
		final Declaration Declaration_300_Var
		 = (Declaration)Declaration_299_list.get(0);
		Assert.assertNotNull(Declaration_300_Var
		);
		//300
		final DeclarationSpecifiers DeclarationSpecifiers_301_Var
		 = (DeclarationSpecifiers)Declaration_300_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_301_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_301_list = DeclarationSpecifiers_301_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_301_list);
		Assert.assertEquals(1, DeclarationSpecifier_301_list.size());
		//301
		final TypeSpecifier TypeSpecifier_302_Var
		 = (TypeSpecifier)DeclarationSpecifier_301_list.get(0);
		Assert.assertNotNull(TypeSpecifier_302_Var
		);
		//302
		final TypedefName TypedefName_303_Var
		 = (TypedefName)TypeSpecifier_302_Var
		.getType();
		Assert.assertNotNull(TypedefName_303_Var
		);
		Assert.assertEquals("employee", TypedefName_303_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_303_list = Declaration_300_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_303_list);
		Assert.assertEquals(1, InitDeclaratorList_303_list.size());
		//303
		final InitDeclaratorList InitDeclaratorList_304_Var
		 = (InitDeclaratorList)InitDeclaratorList_303_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_304_Var
		);
		final EList<? extends EObject> InitDeclarator_304_list = InitDeclaratorList_304_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_304_list);
		Assert.assertEquals(1, InitDeclarator_304_list.size());
		//304
		final InitDeclarator InitDeclarator_305_Var
		 = (InitDeclarator)InitDeclarator_304_list.get(0);
		Assert.assertNotNull(InitDeclarator_305_Var
		);
		//305
		final Declarator Declarator_306_Var
		 = (Declarator)InitDeclarator_305_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_306_Var
		);
		//306
		final Pointer Pointer_307_Var
		 = (Pointer)Declarator_306_Var
		.getPointer();
		Assert.assertNotNull(Pointer_307_Var
		);
		Assert.assertEquals("[*]", Pointer_307_Var
		.getStar().toString());
		//307
		final DirectDeclarator DirectDeclarator_308_Var
		 = (DirectDeclarator)Declarator_306_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_308_Var
		);
		Assert.assertEquals("newEmployee", DirectDeclarator_308_Var
		.getId());
		//308
		final Initializer Initializer_309_Var
		 = (Initializer)InitDeclarator_305_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_309_Var
		);
		//309
		final AssignmentExpression AssignmentExpression_310_Var
		 = (AssignmentExpression)Initializer_309_Var
		.getExpr();
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
		Assert.assertEquals("malloc", PrimaryExpression_325_Var
		.getId());
		final EList<? extends EObject> Suffix_325_list = PostfixExpression_324_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_325_list);
		Assert.assertEquals(1, Suffix_325_list.size());
		//325
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_326_Var
		 = (PostfixExpressionSuffixArgument)Suffix_325_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_326_Var
		);
		//326
		final ArgumentExpressionList ArgumentExpressionList_327_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_326_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_327_Var
		);
		final EList<? extends EObject> Expr_327_list = ArgumentExpressionList_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final AssignmentExpression AssignmentExpression_328_Var
		 = (AssignmentExpression)Expr_327_list.get(0);
		Assert.assertNotNull(AssignmentExpression_328_Var
		);
		//328
		final ConditionalExpression ConditionalExpression_329_Var
		 = (ConditionalExpression)AssignmentExpression_328_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_329_Var
		);
		//329
		final LogicalOrExpression LogicalOrExpression_330_Var
		 = (LogicalOrExpression)ConditionalExpression_329_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_330_Var
		);
		final EList<? extends EObject> Expr_330_list = LogicalOrExpression_330_Var
		.getExpr();
		Assert.assertNotNull(Expr_330_list);
		Assert.assertEquals(1, Expr_330_list.size());
		//330
		final LogicalAndExpression LogicalAndExpression_331_Var
		 = (LogicalAndExpression)Expr_330_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = LogicalAndExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final InclusiveOrExpression InclusiveOrExpression_332_Var
		 = (InclusiveOrExpression)Expr_331_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_332_Var
		);
		final EList<? extends EObject> Expr_332_list = InclusiveOrExpression_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final ExclusiveOrExpression ExclusiveOrExpression_333_Var
		 = (ExclusiveOrExpression)Expr_332_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = ExclusiveOrExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final AndExpression AndExpression_334_Var
		 = (AndExpression)Expr_333_list.get(0);
		Assert.assertNotNull(AndExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = AndExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final EqualityExpression EqualityExpression_335_Var
		 = (EqualityExpression)Expr_334_list.get(0);
		Assert.assertNotNull(EqualityExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = EqualityExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final RelationalExpression RelationalExpression_336_Var
		 = (RelationalExpression)Expr_335_list.get(0);
		Assert.assertNotNull(RelationalExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = RelationalExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final ShiftExpression ShiftExpression_337_Var
		 = (ShiftExpression)Expr_336_list.get(0);
		Assert.assertNotNull(ShiftExpression_337_Var
		);
		final EList<? extends EObject> Expr_337_list = ShiftExpression_337_Var
		.getExpr();
		Assert.assertNotNull(Expr_337_list);
		Assert.assertEquals(1, Expr_337_list.size());
		//337
		final AdditiveExpression AdditiveExpression_338_Var
		 = (AdditiveExpression)Expr_337_list.get(0);
		Assert.assertNotNull(AdditiveExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = AdditiveExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final MultiplicativeExpression MultiplicativeExpression_339_Var
		 = (MultiplicativeExpression)Expr_338_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_339_Var
		);
		final EList<? extends EObject> Expr_339_list = MultiplicativeExpression_339_Var
		.getExpr();
		Assert.assertNotNull(Expr_339_list);
		Assert.assertEquals(1, Expr_339_list.size());
		//339
		final CastExpression CastExpression_340_Var
		 = (CastExpression)Expr_339_list.get(0);
		Assert.assertNotNull(CastExpression_340_Var
		);
		//340
		final UnaryExpression UnaryExpression_341_Var
		 = (UnaryExpression)CastExpression_340_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_341_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_341_Var
		.getSizeOf());
		//341
		final TypeName TypeName_342_Var
		 = (TypeName)UnaryExpression_341_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_342_Var
		);
		//342
		final SpecifierQualifierList SpecifierQualifierList_343_Var
		 = (SpecifierQualifierList)TypeName_342_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_343_Var
		);
		final EList<? extends EObject> TypeSpecifier_343_list = SpecifierQualifierList_343_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_343_list);
		Assert.assertEquals(1, TypeSpecifier_343_list.size());
		//343
		final TypeSpecifier TypeSpecifier_344_Var
		 = (TypeSpecifier)TypeSpecifier_343_list.get(0);
		Assert.assertNotNull(TypeSpecifier_344_Var
		);
		//344
		final TypedefName TypedefName_345_Var
		 = (TypedefName)TypeSpecifier_344_Var
		.getType();
		Assert.assertNotNull(TypedefName_345_Var
		);
		Assert.assertEquals("employee", TypedefName_345_Var
		.getId());
		final EList<? extends EObject> Statement_345_list = BlockList_299_Var
		.getStatement();
		Assert.assertNotNull(Statement_345_list);
		Assert.assertEquals(8, Statement_345_list.size());
		//345
		final Statement Statement_346_Var
		 = (Statement)Statement_345_list.get(0);
		Assert.assertNotNull(Statement_346_Var
		);
		//346
		final SelectionStatement SelectionStatement_347_Var
		 = (SelectionStatement)Statement_346_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_347_Var
		);
		Assert.assertEquals("if", SelectionStatement_347_Var
		.getIf());
		//347
		final Expression Expression_348_Var
		 = (Expression)SelectionStatement_347_Var
		.getExpr();
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
		Assert.assertEquals("[==]", EqualityExpression_356_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_356_list = EqualityExpression_356_Var
		.getExpr();
		Assert.assertNotNull(Expr_356_list);
		Assert.assertEquals(2, Expr_356_list.size());
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
		Assert.assertEquals("newEmployee", PrimaryExpression_364_Var
		.getId());
		//364
		final RelationalExpression RelationalExpression_365_Var
		 = (RelationalExpression)Expr_356_list.get(1);
		Assert.assertNotNull(RelationalExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = RelationalExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final ShiftExpression ShiftExpression_366_Var
		 = (ShiftExpression)Expr_365_list.get(0);
		Assert.assertNotNull(ShiftExpression_366_Var
		);
		final EList<? extends EObject> Expr_366_list = ShiftExpression_366_Var
		.getExpr();
		Assert.assertNotNull(Expr_366_list);
		Assert.assertEquals(1, Expr_366_list.size());
		//366
		final AdditiveExpression AdditiveExpression_367_Var
		 = (AdditiveExpression)Expr_366_list.get(0);
		Assert.assertNotNull(AdditiveExpression_367_Var
		);
		final EList<? extends EObject> Expr_367_list = AdditiveExpression_367_Var
		.getExpr();
		Assert.assertNotNull(Expr_367_list);
		Assert.assertEquals(1, Expr_367_list.size());
		//367
		final MultiplicativeExpression MultiplicativeExpression_368_Var
		 = (MultiplicativeExpression)Expr_367_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_368_Var
		);
		final EList<? extends EObject> Expr_368_list = MultiplicativeExpression_368_Var
		.getExpr();
		Assert.assertNotNull(Expr_368_list);
		Assert.assertEquals(1, Expr_368_list.size());
		//368
		final CastExpression CastExpression_369_Var
		 = (CastExpression)Expr_368_list.get(0);
		Assert.assertNotNull(CastExpression_369_Var
		);
		//369
		final UnaryExpression UnaryExpression_370_Var
		 = (UnaryExpression)CastExpression_369_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_370_Var
		);
		//370
		final PostfixExpression PostfixExpression_371_Var
		 = (PostfixExpression)UnaryExpression_370_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_371_Var
		);
		final EList<? extends EObject> Expr_371_list = PostfixExpression_371_Var
		.getExpr();
		Assert.assertNotNull(Expr_371_list);
		Assert.assertEquals(1, Expr_371_list.size());
		//371
		final PrimaryExpression PrimaryExpression_372_Var
		 = (PrimaryExpression)Expr_371_list.get(0);
		Assert.assertNotNull(PrimaryExpression_372_Var
		);
		Assert.assertEquals("NULL", PrimaryExpression_372_Var
		.getId());
		//372
		final Statement Statement_373_Var
		 = (Statement)SelectionStatement_347_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_373_Var
		);
		//373
		final CompoundStatement CompoundStatement_374_Var
		 = (CompoundStatement)Statement_373_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_374_Var
		);
		//374
		final BodyStatement BodyStatement_375_Var
		 = (BodyStatement)CompoundStatement_374_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_375_Var
		);
		final EList<? extends EObject> BlockList_375_list = BodyStatement_375_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_375_list);
		Assert.assertEquals(1, BlockList_375_list.size());
		//375
		final BlockList BlockList_376_Var
		 = (BlockList)BlockList_375_list.get(0);
		Assert.assertNotNull(BlockList_376_Var
		);
		final EList<? extends EObject> Statement_376_list = BlockList_376_Var
		.getStatement();
		Assert.assertNotNull(Statement_376_list);
		Assert.assertEquals(2, Statement_376_list.size());
		//376
		final Statement Statement_377_Var
		 = (Statement)Statement_376_list.get(0);
		Assert.assertNotNull(Statement_377_Var
		);
		//377
		final ExpressionStatement ExpressionStatement_378_Var
		 = (ExpressionStatement)Statement_377_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_378_Var
		);
		//378
		final Expression Expression_379_Var
		 = (Expression)ExpressionStatement_378_Var
		.getExpression();
		Assert.assertNotNull(Expression_379_Var
		);
		final EList<? extends EObject> ExprExpr_379_list = Expression_379_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_379_list);
		Assert.assertEquals(1, ExprExpr_379_list.size());
		//379
		final AssignmentExpression AssignmentExpression_380_Var
		 = (AssignmentExpression)ExprExpr_379_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_395_Var
		.getId());
		final EList<? extends EObject> Suffix_395_list = PostfixExpression_394_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_395_list);
		Assert.assertEquals(1, Suffix_395_list.size());
		//395
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_396_Var
		 = (PostfixExpressionSuffixArgument)Suffix_395_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_396_Var
		);
		//396
		final ArgumentExpressionList ArgumentExpressionList_397_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_396_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_397_Var
		);
		final EList<? extends EObject> Expr_397_list = ArgumentExpressionList_397_Var
		.getExpr();
		Assert.assertNotNull(Expr_397_list);
		Assert.assertEquals(1, Expr_397_list.size());
		//397
		final AssignmentExpression AssignmentExpression_398_Var
		 = (AssignmentExpression)Expr_397_list.get(0);
		Assert.assertNotNull(AssignmentExpression_398_Var
		);
		//398
		final ConditionalExpression ConditionalExpression_399_Var
		 = (ConditionalExpression)AssignmentExpression_398_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_399_Var
		);
		//399
		final LogicalOrExpression LogicalOrExpression_400_Var
		 = (LogicalOrExpression)ConditionalExpression_399_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_400_Var
		);
		final EList<? extends EObject> Expr_400_list = LogicalOrExpression_400_Var
		.getExpr();
		Assert.assertNotNull(Expr_400_list);
		Assert.assertEquals(1, Expr_400_list.size());
		//400
		final LogicalAndExpression LogicalAndExpression_401_Var
		 = (LogicalAndExpression)Expr_400_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_401_Var
		);
		final EList<? extends EObject> Expr_401_list = LogicalAndExpression_401_Var
		.getExpr();
		Assert.assertNotNull(Expr_401_list);
		Assert.assertEquals(1, Expr_401_list.size());
		//401
		final InclusiveOrExpression InclusiveOrExpression_402_Var
		 = (InclusiveOrExpression)Expr_401_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_402_Var
		);
		final EList<? extends EObject> Expr_402_list = InclusiveOrExpression_402_Var
		.getExpr();
		Assert.assertNotNull(Expr_402_list);
		Assert.assertEquals(1, Expr_402_list.size());
		//402
		final ExclusiveOrExpression ExclusiveOrExpression_403_Var
		 = (ExclusiveOrExpression)Expr_402_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_403_Var
		);
		final EList<? extends EObject> Expr_403_list = ExclusiveOrExpression_403_Var
		.getExpr();
		Assert.assertNotNull(Expr_403_list);
		Assert.assertEquals(1, Expr_403_list.size());
		//403
		final AndExpression AndExpression_404_Var
		 = (AndExpression)Expr_403_list.get(0);
		Assert.assertNotNull(AndExpression_404_Var
		);
		final EList<? extends EObject> Expr_404_list = AndExpression_404_Var
		.getExpr();
		Assert.assertNotNull(Expr_404_list);
		Assert.assertEquals(1, Expr_404_list.size());
		//404
		final EqualityExpression EqualityExpression_405_Var
		 = (EqualityExpression)Expr_404_list.get(0);
		Assert.assertNotNull(EqualityExpression_405_Var
		);
		final EList<? extends EObject> Expr_405_list = EqualityExpression_405_Var
		.getExpr();
		Assert.assertNotNull(Expr_405_list);
		Assert.assertEquals(1, Expr_405_list.size());
		//405
		final RelationalExpression RelationalExpression_406_Var
		 = (RelationalExpression)Expr_405_list.get(0);
		Assert.assertNotNull(RelationalExpression_406_Var
		);
		final EList<? extends EObject> Expr_406_list = RelationalExpression_406_Var
		.getExpr();
		Assert.assertNotNull(Expr_406_list);
		Assert.assertEquals(1, Expr_406_list.size());
		//406
		final ShiftExpression ShiftExpression_407_Var
		 = (ShiftExpression)Expr_406_list.get(0);
		Assert.assertNotNull(ShiftExpression_407_Var
		);
		final EList<? extends EObject> Expr_407_list = ShiftExpression_407_Var
		.getExpr();
		Assert.assertNotNull(Expr_407_list);
		Assert.assertEquals(1, Expr_407_list.size());
		//407
		final AdditiveExpression AdditiveExpression_408_Var
		 = (AdditiveExpression)Expr_407_list.get(0);
		Assert.assertNotNull(AdditiveExpression_408_Var
		);
		final EList<? extends EObject> Expr_408_list = AdditiveExpression_408_Var
		.getExpr();
		Assert.assertNotNull(Expr_408_list);
		Assert.assertEquals(1, Expr_408_list.size());
		//408
		final MultiplicativeExpression MultiplicativeExpression_409_Var
		 = (MultiplicativeExpression)Expr_408_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_409_Var
		);
		final EList<? extends EObject> Expr_409_list = MultiplicativeExpression_409_Var
		.getExpr();
		Assert.assertNotNull(Expr_409_list);
		Assert.assertEquals(1, Expr_409_list.size());
		//409
		final CastExpression CastExpression_410_Var
		 = (CastExpression)Expr_409_list.get(0);
		Assert.assertNotNull(CastExpression_410_Var
		);
		//410
		final UnaryExpression UnaryExpression_411_Var
		 = (UnaryExpression)CastExpression_410_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_411_Var
		);
		//411
		final PostfixExpression PostfixExpression_412_Var
		 = (PostfixExpression)UnaryExpression_411_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_412_Var
		);
		final EList<? extends EObject> Expr_412_list = PostfixExpression_412_Var
		.getExpr();
		Assert.assertNotNull(Expr_412_list);
		Assert.assertEquals(1, Expr_412_list.size());
		//412
		final PrimaryExpression PrimaryExpression_413_Var
		 = (PrimaryExpression)Expr_412_list.get(0);
		Assert.assertNotNull(PrimaryExpression_413_Var
		);
		Assert.assertEquals("[\"Could not reserve space for new employee!\\n\"]", PrimaryExpression_413_Var
		.getString().toString());
		Assert.assertEquals(";", ExpressionStatement_378_Var
		.getSemi());
		//413
		final Statement Statement_414_Var
		 = (Statement)Statement_376_list.get(1);
		Assert.assertNotNull(Statement_414_Var
		);
		//414
		final JumpStatement JumpStatement_415_Var
		 = (JumpStatement)Statement_414_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_415_Var
		);
		//415
		final Expression Expression_416_Var
		 = (Expression)JumpStatement_415_Var
		.getExpr();
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
		final UnaryOperator UnaryOperator_431_Var
		 = (UnaryOperator)UnaryExpression_430_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_431_Var
		);
		Assert.assertEquals("-", UnaryOperator_431_Var
		.getOp());
		//431
		final CastExpression CastExpression_432_Var
		 = (CastExpression)UnaryExpression_430_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_432_Var
		);
		//432
		final UnaryExpression UnaryExpression_433_Var
		 = (UnaryExpression)CastExpression_432_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_433_Var
		);
		//433
		final PostfixExpression PostfixExpression_434_Var
		 = (PostfixExpression)UnaryExpression_433_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_434_Var
		);
		final EList<? extends EObject> Expr_434_list = PostfixExpression_434_Var
		.getExpr();
		Assert.assertNotNull(Expr_434_list);
		Assert.assertEquals(1, Expr_434_list.size());
		//434
		final PrimaryExpression PrimaryExpression_435_Var
		 = (PrimaryExpression)Expr_434_list.get(0);
		Assert.assertNotNull(PrimaryExpression_435_Var
		);
		//435
		final Constant2 Constant2_436_Var
		 = (Constant2)PrimaryExpression_435_Var
		.getConst();
		Assert.assertNotNull(Constant2_436_Var
		);
		Assert.assertEquals("1", Constant2_436_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_415_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_415_Var
		.getSemi());
		//436
		final Statement Statement_437_Var
		 = (Statement)Statement_345_list.get(1);
		Assert.assertNotNull(Statement_437_Var
		);
		//437
		final ExpressionStatement ExpressionStatement_438_Var
		 = (ExpressionStatement)Statement_437_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_438_Var
		);
		//438
		final Expression Expression_439_Var
		 = (Expression)ExpressionStatement_438_Var
		.getExpression();
		Assert.assertNotNull(Expression_439_Var
		);
		final EList<? extends EObject> ExprExpr_439_list = Expression_439_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_439_list);
		Assert.assertEquals(1, ExprExpr_439_list.size());
		//439
		final AssignmentExpression AssignmentExpression_440_Var
		 = (AssignmentExpression)ExprExpr_439_list.get(0);
		Assert.assertNotNull(AssignmentExpression_440_Var
		);
		//440
		final ConditionalExpression ConditionalExpression_441_Var
		 = (ConditionalExpression)AssignmentExpression_440_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_441_Var
		);
		//441
		final LogicalOrExpression LogicalOrExpression_442_Var
		 = (LogicalOrExpression)ConditionalExpression_441_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_442_Var
		);
		final EList<? extends EObject> Expr_442_list = LogicalOrExpression_442_Var
		.getExpr();
		Assert.assertNotNull(Expr_442_list);
		Assert.assertEquals(1, Expr_442_list.size());
		//442
		final LogicalAndExpression LogicalAndExpression_443_Var
		 = (LogicalAndExpression)Expr_442_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_443_Var
		);
		final EList<? extends EObject> Expr_443_list = LogicalAndExpression_443_Var
		.getExpr();
		Assert.assertNotNull(Expr_443_list);
		Assert.assertEquals(1, Expr_443_list.size());
		//443
		final InclusiveOrExpression InclusiveOrExpression_444_Var
		 = (InclusiveOrExpression)Expr_443_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_444_Var
		);
		final EList<? extends EObject> Expr_444_list = InclusiveOrExpression_444_Var
		.getExpr();
		Assert.assertNotNull(Expr_444_list);
		Assert.assertEquals(1, Expr_444_list.size());
		//444
		final ExclusiveOrExpression ExclusiveOrExpression_445_Var
		 = (ExclusiveOrExpression)Expr_444_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_445_Var
		);
		final EList<? extends EObject> Expr_445_list = ExclusiveOrExpression_445_Var
		.getExpr();
		Assert.assertNotNull(Expr_445_list);
		Assert.assertEquals(1, Expr_445_list.size());
		//445
		final AndExpression AndExpression_446_Var
		 = (AndExpression)Expr_445_list.get(0);
		Assert.assertNotNull(AndExpression_446_Var
		);
		final EList<? extends EObject> Expr_446_list = AndExpression_446_Var
		.getExpr();
		Assert.assertNotNull(Expr_446_list);
		Assert.assertEquals(1, Expr_446_list.size());
		//446
		final EqualityExpression EqualityExpression_447_Var
		 = (EqualityExpression)Expr_446_list.get(0);
		Assert.assertNotNull(EqualityExpression_447_Var
		);
		final EList<? extends EObject> Expr_447_list = EqualityExpression_447_Var
		.getExpr();
		Assert.assertNotNull(Expr_447_list);
		Assert.assertEquals(1, Expr_447_list.size());
		//447
		final RelationalExpression RelationalExpression_448_Var
		 = (RelationalExpression)Expr_447_list.get(0);
		Assert.assertNotNull(RelationalExpression_448_Var
		);
		final EList<? extends EObject> Expr_448_list = RelationalExpression_448_Var
		.getExpr();
		Assert.assertNotNull(Expr_448_list);
		Assert.assertEquals(1, Expr_448_list.size());
		//448
		final ShiftExpression ShiftExpression_449_Var
		 = (ShiftExpression)Expr_448_list.get(0);
		Assert.assertNotNull(ShiftExpression_449_Var
		);
		final EList<? extends EObject> Expr_449_list = ShiftExpression_449_Var
		.getExpr();
		Assert.assertNotNull(Expr_449_list);
		Assert.assertEquals(1, Expr_449_list.size());
		//449
		final AdditiveExpression AdditiveExpression_450_Var
		 = (AdditiveExpression)Expr_449_list.get(0);
		Assert.assertNotNull(AdditiveExpression_450_Var
		);
		final EList<? extends EObject> Expr_450_list = AdditiveExpression_450_Var
		.getExpr();
		Assert.assertNotNull(Expr_450_list);
		Assert.assertEquals(1, Expr_450_list.size());
		//450
		final MultiplicativeExpression MultiplicativeExpression_451_Var
		 = (MultiplicativeExpression)Expr_450_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_451_Var
		);
		final EList<? extends EObject> Expr_451_list = MultiplicativeExpression_451_Var
		.getExpr();
		Assert.assertNotNull(Expr_451_list);
		Assert.assertEquals(1, Expr_451_list.size());
		//451
		final CastExpression CastExpression_452_Var
		 = (CastExpression)Expr_451_list.get(0);
		Assert.assertNotNull(CastExpression_452_Var
		);
		//452
		final UnaryExpression UnaryExpression_453_Var
		 = (UnaryExpression)CastExpression_452_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_453_Var
		);
		//453
		final PostfixExpression PostfixExpression_454_Var
		 = (PostfixExpression)UnaryExpression_453_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_454_Var
		);
		final EList<? extends EObject> Expr_454_list = PostfixExpression_454_Var
		.getExpr();
		Assert.assertNotNull(Expr_454_list);
		Assert.assertEquals(1, Expr_454_list.size());
		//454
		final PrimaryExpression PrimaryExpression_455_Var
		 = (PrimaryExpression)Expr_454_list.get(0);
		Assert.assertNotNull(PrimaryExpression_455_Var
		);
		Assert.assertEquals("print", PrimaryExpression_455_Var
		.getId());
		final EList<? extends EObject> Suffix_455_list = PostfixExpression_454_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_455_list);
		Assert.assertEquals(1, Suffix_455_list.size());
		//455
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_456_Var
		 = (PostfixExpressionSuffixArgument)Suffix_455_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_456_Var
		);
		//456
		final ArgumentExpressionList ArgumentExpressionList_457_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_456_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_457_Var
		);
		final EList<? extends EObject> Expr_457_list = ArgumentExpressionList_457_Var
		.getExpr();
		Assert.assertNotNull(Expr_457_list);
		Assert.assertEquals(1, Expr_457_list.size());
		//457
		final AssignmentExpression AssignmentExpression_458_Var
		 = (AssignmentExpression)Expr_457_list.get(0);
		Assert.assertNotNull(AssignmentExpression_458_Var
		);
		//458
		final ConditionalExpression ConditionalExpression_459_Var
		 = (ConditionalExpression)AssignmentExpression_458_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_459_Var
		);
		//459
		final LogicalOrExpression LogicalOrExpression_460_Var
		 = (LogicalOrExpression)ConditionalExpression_459_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_460_Var
		);
		final EList<? extends EObject> Expr_460_list = LogicalOrExpression_460_Var
		.getExpr();
		Assert.assertNotNull(Expr_460_list);
		Assert.assertEquals(1, Expr_460_list.size());
		//460
		final LogicalAndExpression LogicalAndExpression_461_Var
		 = (LogicalAndExpression)Expr_460_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_461_Var
		);
		final EList<? extends EObject> Expr_461_list = LogicalAndExpression_461_Var
		.getExpr();
		Assert.assertNotNull(Expr_461_list);
		Assert.assertEquals(1, Expr_461_list.size());
		//461
		final InclusiveOrExpression InclusiveOrExpression_462_Var
		 = (InclusiveOrExpression)Expr_461_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_462_Var
		);
		final EList<? extends EObject> Expr_462_list = InclusiveOrExpression_462_Var
		.getExpr();
		Assert.assertNotNull(Expr_462_list);
		Assert.assertEquals(1, Expr_462_list.size());
		//462
		final ExclusiveOrExpression ExclusiveOrExpression_463_Var
		 = (ExclusiveOrExpression)Expr_462_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_463_Var
		);
		final EList<? extends EObject> Expr_463_list = ExclusiveOrExpression_463_Var
		.getExpr();
		Assert.assertNotNull(Expr_463_list);
		Assert.assertEquals(1, Expr_463_list.size());
		//463
		final AndExpression AndExpression_464_Var
		 = (AndExpression)Expr_463_list.get(0);
		Assert.assertNotNull(AndExpression_464_Var
		);
		final EList<? extends EObject> Expr_464_list = AndExpression_464_Var
		.getExpr();
		Assert.assertNotNull(Expr_464_list);
		Assert.assertEquals(1, Expr_464_list.size());
		//464
		final EqualityExpression EqualityExpression_465_Var
		 = (EqualityExpression)Expr_464_list.get(0);
		Assert.assertNotNull(EqualityExpression_465_Var
		);
		final EList<? extends EObject> Expr_465_list = EqualityExpression_465_Var
		.getExpr();
		Assert.assertNotNull(Expr_465_list);
		Assert.assertEquals(1, Expr_465_list.size());
		//465
		final RelationalExpression RelationalExpression_466_Var
		 = (RelationalExpression)Expr_465_list.get(0);
		Assert.assertNotNull(RelationalExpression_466_Var
		);
		final EList<? extends EObject> Expr_466_list = RelationalExpression_466_Var
		.getExpr();
		Assert.assertNotNull(Expr_466_list);
		Assert.assertEquals(1, Expr_466_list.size());
		//466
		final ShiftExpression ShiftExpression_467_Var
		 = (ShiftExpression)Expr_466_list.get(0);
		Assert.assertNotNull(ShiftExpression_467_Var
		);
		final EList<? extends EObject> Expr_467_list = ShiftExpression_467_Var
		.getExpr();
		Assert.assertNotNull(Expr_467_list);
		Assert.assertEquals(1, Expr_467_list.size());
		//467
		final AdditiveExpression AdditiveExpression_468_Var
		 = (AdditiveExpression)Expr_467_list.get(0);
		Assert.assertNotNull(AdditiveExpression_468_Var
		);
		final EList<? extends EObject> Expr_468_list = AdditiveExpression_468_Var
		.getExpr();
		Assert.assertNotNull(Expr_468_list);
		Assert.assertEquals(1, Expr_468_list.size());
		//468
		final MultiplicativeExpression MultiplicativeExpression_469_Var
		 = (MultiplicativeExpression)Expr_468_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_469_Var
		);
		final EList<? extends EObject> Expr_469_list = MultiplicativeExpression_469_Var
		.getExpr();
		Assert.assertNotNull(Expr_469_list);
		Assert.assertEquals(1, Expr_469_list.size());
		//469
		final CastExpression CastExpression_470_Var
		 = (CastExpression)Expr_469_list.get(0);
		Assert.assertNotNull(CastExpression_470_Var
		);
		//470
		final UnaryExpression UnaryExpression_471_Var
		 = (UnaryExpression)CastExpression_470_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_471_Var
		);
		//471
		final UnaryOperator UnaryOperator_472_Var
		 = (UnaryOperator)UnaryExpression_471_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_472_Var
		);
		Assert.assertEquals("&", UnaryOperator_472_Var
		.getOp());
		//472
		final CastExpression CastExpression_473_Var
		 = (CastExpression)UnaryExpression_471_Var
		.getExpr();
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
		Assert.assertEquals("joe", PrimaryExpression_476_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_438_Var
		.getSemi());
		//476
		final Statement Statement_477_Var
		 = (Statement)Statement_345_list.get(2);
		Assert.assertNotNull(Statement_477_Var
		);
		//477
		final ExpressionStatement ExpressionStatement_478_Var
		 = (ExpressionStatement)Statement_477_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_478_Var
		);
		//478
		final Expression Expression_479_Var
		 = (Expression)ExpressionStatement_478_Var
		.getExpression();
		Assert.assertNotNull(Expression_479_Var
		);
		final EList<? extends EObject> ExprExpr_479_list = Expression_479_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_479_list);
		Assert.assertEquals(1, ExprExpr_479_list.size());
		//479
		final AssignmentExpression AssignmentExpression_480_Var
		 = (AssignmentExpression)ExprExpr_479_list.get(0);
		Assert.assertNotNull(AssignmentExpression_480_Var
		);
		//480
		final ConditionalExpression ConditionalExpression_481_Var
		 = (ConditionalExpression)AssignmentExpression_480_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_481_Var
		);
		//481
		final LogicalOrExpression LogicalOrExpression_482_Var
		 = (LogicalOrExpression)ConditionalExpression_481_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_482_Var
		);
		final EList<? extends EObject> Expr_482_list = LogicalOrExpression_482_Var
		.getExpr();
		Assert.assertNotNull(Expr_482_list);
		Assert.assertEquals(1, Expr_482_list.size());
		//482
		final LogicalAndExpression LogicalAndExpression_483_Var
		 = (LogicalAndExpression)Expr_482_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_483_Var
		);
		final EList<? extends EObject> Expr_483_list = LogicalAndExpression_483_Var
		.getExpr();
		Assert.assertNotNull(Expr_483_list);
		Assert.assertEquals(1, Expr_483_list.size());
		//483
		final InclusiveOrExpression InclusiveOrExpression_484_Var
		 = (InclusiveOrExpression)Expr_483_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_484_Var
		);
		final EList<? extends EObject> Expr_484_list = InclusiveOrExpression_484_Var
		.getExpr();
		Assert.assertNotNull(Expr_484_list);
		Assert.assertEquals(1, Expr_484_list.size());
		//484
		final ExclusiveOrExpression ExclusiveOrExpression_485_Var
		 = (ExclusiveOrExpression)Expr_484_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_485_Var
		);
		final EList<? extends EObject> Expr_485_list = ExclusiveOrExpression_485_Var
		.getExpr();
		Assert.assertNotNull(Expr_485_list);
		Assert.assertEquals(1, Expr_485_list.size());
		//485
		final AndExpression AndExpression_486_Var
		 = (AndExpression)Expr_485_list.get(0);
		Assert.assertNotNull(AndExpression_486_Var
		);
		final EList<? extends EObject> Expr_486_list = AndExpression_486_Var
		.getExpr();
		Assert.assertNotNull(Expr_486_list);
		Assert.assertEquals(1, Expr_486_list.size());
		//486
		final EqualityExpression EqualityExpression_487_Var
		 = (EqualityExpression)Expr_486_list.get(0);
		Assert.assertNotNull(EqualityExpression_487_Var
		);
		final EList<? extends EObject> Expr_487_list = EqualityExpression_487_Var
		.getExpr();
		Assert.assertNotNull(Expr_487_list);
		Assert.assertEquals(1, Expr_487_list.size());
		//487
		final RelationalExpression RelationalExpression_488_Var
		 = (RelationalExpression)Expr_487_list.get(0);
		Assert.assertNotNull(RelationalExpression_488_Var
		);
		final EList<? extends EObject> Expr_488_list = RelationalExpression_488_Var
		.getExpr();
		Assert.assertNotNull(Expr_488_list);
		Assert.assertEquals(1, Expr_488_list.size());
		//488
		final ShiftExpression ShiftExpression_489_Var
		 = (ShiftExpression)Expr_488_list.get(0);
		Assert.assertNotNull(ShiftExpression_489_Var
		);
		final EList<? extends EObject> Expr_489_list = ShiftExpression_489_Var
		.getExpr();
		Assert.assertNotNull(Expr_489_list);
		Assert.assertEquals(1, Expr_489_list.size());
		//489
		final AdditiveExpression AdditiveExpression_490_Var
		 = (AdditiveExpression)Expr_489_list.get(0);
		Assert.assertNotNull(AdditiveExpression_490_Var
		);
		final EList<? extends EObject> Expr_490_list = AdditiveExpression_490_Var
		.getExpr();
		Assert.assertNotNull(Expr_490_list);
		Assert.assertEquals(1, Expr_490_list.size());
		//490
		final MultiplicativeExpression MultiplicativeExpression_491_Var
		 = (MultiplicativeExpression)Expr_490_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_491_Var
		);
		final EList<? extends EObject> Expr_491_list = MultiplicativeExpression_491_Var
		.getExpr();
		Assert.assertNotNull(Expr_491_list);
		Assert.assertEquals(1, Expr_491_list.size());
		//491
		final CastExpression CastExpression_492_Var
		 = (CastExpression)Expr_491_list.get(0);
		Assert.assertNotNull(CastExpression_492_Var
		);
		//492
		final UnaryExpression UnaryExpression_493_Var
		 = (UnaryExpression)CastExpression_492_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_493_Var
		);
		//493
		final PostfixExpression PostfixExpression_494_Var
		 = (PostfixExpression)UnaryExpression_493_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_494_Var
		);
		final EList<? extends EObject> Expr_494_list = PostfixExpression_494_Var
		.getExpr();
		Assert.assertNotNull(Expr_494_list);
		Assert.assertEquals(1, Expr_494_list.size());
		//494
		final PrimaryExpression PrimaryExpression_495_Var
		 = (PrimaryExpression)Expr_494_list.get(0);
		Assert.assertNotNull(PrimaryExpression_495_Var
		);
		Assert.assertEquals("print", PrimaryExpression_495_Var
		.getId());
		final EList<? extends EObject> Suffix_495_list = PostfixExpression_494_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_495_list);
		Assert.assertEquals(1, Suffix_495_list.size());
		//495
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_496_Var
		 = (PostfixExpressionSuffixArgument)Suffix_495_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_496_Var
		);
		//496
		final ArgumentExpressionList ArgumentExpressionList_497_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_496_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_497_Var
		);
		final EList<? extends EObject> Expr_497_list = ArgumentExpressionList_497_Var
		.getExpr();
		Assert.assertNotNull(Expr_497_list);
		Assert.assertEquals(1, Expr_497_list.size());
		//497
		final AssignmentExpression AssignmentExpression_498_Var
		 = (AssignmentExpression)Expr_497_list.get(0);
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
		final UnaryOperator UnaryOperator_512_Var
		 = (UnaryOperator)UnaryExpression_511_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_512_Var
		);
		Assert.assertEquals("&", UnaryOperator_512_Var
		.getOp());
		//512
		final CastExpression CastExpression_513_Var
		 = (CastExpression)UnaryExpression_511_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_513_Var
		);
		//513
		final UnaryExpression UnaryExpression_514_Var
		 = (UnaryExpression)CastExpression_513_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_514_Var
		);
		//514
		final PostfixExpression PostfixExpression_515_Var
		 = (PostfixExpression)UnaryExpression_514_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_515_Var
		);
		final EList<? extends EObject> Expr_515_list = PostfixExpression_515_Var
		.getExpr();
		Assert.assertNotNull(Expr_515_list);
		Assert.assertEquals(1, Expr_515_list.size());
		//515
		final PrimaryExpression PrimaryExpression_516_Var
		 = (PrimaryExpression)Expr_515_list.get(0);
		Assert.assertNotNull(PrimaryExpression_516_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_516_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_478_Var
		.getSemi());
		//516
		final Statement Statement_517_Var
		 = (Statement)Statement_345_list.get(3);
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
		final UnaryExpression UnaryExpression_521_Var
		 = (UnaryExpression)AssignmentExpression_520_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_521_Var
		);
		//521
		final PostfixExpression PostfixExpression_522_Var
		 = (PostfixExpression)UnaryExpression_521_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_522_Var
		);
		final EList<? extends EObject> Expr_522_list = PostfixExpression_522_Var
		.getExpr();
		Assert.assertNotNull(Expr_522_list);
		Assert.assertEquals(1, Expr_522_list.size());
		//522
		final PrimaryExpression PrimaryExpression_523_Var
		 = (PrimaryExpression)Expr_522_list.get(0);
		Assert.assertNotNull(PrimaryExpression_523_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_523_Var
		.getId());
		final EList<? extends EObject> Suffix_523_list = PostfixExpression_522_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_523_list);
		Assert.assertEquals(1, Suffix_523_list.size());
		//523
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_524_Var
		 = (PostfixExpressionSuffixArrow)Suffix_523_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArrow_524_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixArrow_524_Var
		.getId());
		//524
		final AssignmentOperator AssignmentOperator_525_Var
		 = (AssignmentOperator)AssignmentExpression_520_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_525_Var
		);
		Assert.assertEquals("=", AssignmentOperator_525_Var
		.getOp());
		//525
		final AssignmentExpression AssignmentExpression_526_Var
		 = (AssignmentExpression)AssignmentExpression_520_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_526_Var
		);
		//526
		final ConditionalExpression ConditionalExpression_527_Var
		 = (ConditionalExpression)AssignmentExpression_526_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_527_Var
		);
		//527
		final LogicalOrExpression LogicalOrExpression_528_Var
		 = (LogicalOrExpression)ConditionalExpression_527_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_528_Var
		);
		final EList<? extends EObject> Expr_528_list = LogicalOrExpression_528_Var
		.getExpr();
		Assert.assertNotNull(Expr_528_list);
		Assert.assertEquals(1, Expr_528_list.size());
		//528
		final LogicalAndExpression LogicalAndExpression_529_Var
		 = (LogicalAndExpression)Expr_528_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_529_Var
		);
		final EList<? extends EObject> Expr_529_list = LogicalAndExpression_529_Var
		.getExpr();
		Assert.assertNotNull(Expr_529_list);
		Assert.assertEquals(1, Expr_529_list.size());
		//529
		final InclusiveOrExpression InclusiveOrExpression_530_Var
		 = (InclusiveOrExpression)Expr_529_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_530_Var
		);
		final EList<? extends EObject> Expr_530_list = InclusiveOrExpression_530_Var
		.getExpr();
		Assert.assertNotNull(Expr_530_list);
		Assert.assertEquals(1, Expr_530_list.size());
		//530
		final ExclusiveOrExpression ExclusiveOrExpression_531_Var
		 = (ExclusiveOrExpression)Expr_530_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_531_Var
		);
		final EList<? extends EObject> Expr_531_list = ExclusiveOrExpression_531_Var
		.getExpr();
		Assert.assertNotNull(Expr_531_list);
		Assert.assertEquals(1, Expr_531_list.size());
		//531
		final AndExpression AndExpression_532_Var
		 = (AndExpression)Expr_531_list.get(0);
		Assert.assertNotNull(AndExpression_532_Var
		);
		final EList<? extends EObject> Expr_532_list = AndExpression_532_Var
		.getExpr();
		Assert.assertNotNull(Expr_532_list);
		Assert.assertEquals(1, Expr_532_list.size());
		//532
		final EqualityExpression EqualityExpression_533_Var
		 = (EqualityExpression)Expr_532_list.get(0);
		Assert.assertNotNull(EqualityExpression_533_Var
		);
		final EList<? extends EObject> Expr_533_list = EqualityExpression_533_Var
		.getExpr();
		Assert.assertNotNull(Expr_533_list);
		Assert.assertEquals(1, Expr_533_list.size());
		//533
		final RelationalExpression RelationalExpression_534_Var
		 = (RelationalExpression)Expr_533_list.get(0);
		Assert.assertNotNull(RelationalExpression_534_Var
		);
		final EList<? extends EObject> Expr_534_list = RelationalExpression_534_Var
		.getExpr();
		Assert.assertNotNull(Expr_534_list);
		Assert.assertEquals(1, Expr_534_list.size());
		//534
		final ShiftExpression ShiftExpression_535_Var
		 = (ShiftExpression)Expr_534_list.get(0);
		Assert.assertNotNull(ShiftExpression_535_Var
		);
		final EList<? extends EObject> Expr_535_list = ShiftExpression_535_Var
		.getExpr();
		Assert.assertNotNull(Expr_535_list);
		Assert.assertEquals(1, Expr_535_list.size());
		//535
		final AdditiveExpression AdditiveExpression_536_Var
		 = (AdditiveExpression)Expr_535_list.get(0);
		Assert.assertNotNull(AdditiveExpression_536_Var
		);
		final EList<? extends EObject> Expr_536_list = AdditiveExpression_536_Var
		.getExpr();
		Assert.assertNotNull(Expr_536_list);
		Assert.assertEquals(1, Expr_536_list.size());
		//536
		final MultiplicativeExpression MultiplicativeExpression_537_Var
		 = (MultiplicativeExpression)Expr_536_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_537_Var
		);
		final EList<? extends EObject> Expr_537_list = MultiplicativeExpression_537_Var
		.getExpr();
		Assert.assertNotNull(Expr_537_list);
		Assert.assertEquals(1, Expr_537_list.size());
		//537
		final CastExpression CastExpression_538_Var
		 = (CastExpression)Expr_537_list.get(0);
		Assert.assertNotNull(CastExpression_538_Var
		);
		//538
		final UnaryExpression UnaryExpression_539_Var
		 = (UnaryExpression)CastExpression_538_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_539_Var
		);
		//539
		final PostfixExpression PostfixExpression_540_Var
		 = (PostfixExpression)UnaryExpression_539_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_540_Var
		);
		final EList<? extends EObject> Expr_540_list = PostfixExpression_540_Var
		.getExpr();
		Assert.assertNotNull(Expr_540_list);
		Assert.assertEquals(1, Expr_540_list.size());
		//540
		final PrimaryExpression PrimaryExpression_541_Var
		 = (PrimaryExpression)Expr_540_list.get(0);
		Assert.assertNotNull(PrimaryExpression_541_Var
		);
		//541
		final Constant2 Constant2_542_Var
		 = (Constant2)PrimaryExpression_541_Var
		.getConst();
		Assert.assertNotNull(Constant2_542_Var
		);
		Assert.assertEquals("0x009", Constant2_542_Var
		.getHex());
		Assert.assertEquals(";", ExpressionStatement_518_Var
		.getSemi());
		//542
		final Statement Statement_543_Var
		 = (Statement)Statement_345_list.get(4);
		Assert.assertNotNull(Statement_543_Var
		);
		//543
		final ExpressionStatement ExpressionStatement_544_Var
		 = (ExpressionStatement)Statement_543_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_544_Var
		);
		//544
		final Expression Expression_545_Var
		 = (Expression)ExpressionStatement_544_Var
		.getExpression();
		Assert.assertNotNull(Expression_545_Var
		);
		final EList<? extends EObject> ExprExpr_545_list = Expression_545_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_545_list);
		Assert.assertEquals(1, ExprExpr_545_list.size());
		//545
		final AssignmentExpression AssignmentExpression_546_Var
		 = (AssignmentExpression)ExprExpr_545_list.get(0);
		Assert.assertNotNull(AssignmentExpression_546_Var
		);
		//546
		final ConditionalExpression ConditionalExpression_547_Var
		 = (ConditionalExpression)AssignmentExpression_546_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_547_Var
		);
		//547
		final LogicalOrExpression LogicalOrExpression_548_Var
		 = (LogicalOrExpression)ConditionalExpression_547_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_548_Var
		);
		final EList<? extends EObject> Expr_548_list = LogicalOrExpression_548_Var
		.getExpr();
		Assert.assertNotNull(Expr_548_list);
		Assert.assertEquals(1, Expr_548_list.size());
		//548
		final LogicalAndExpression LogicalAndExpression_549_Var
		 = (LogicalAndExpression)Expr_548_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_549_Var
		);
		final EList<? extends EObject> Expr_549_list = LogicalAndExpression_549_Var
		.getExpr();
		Assert.assertNotNull(Expr_549_list);
		Assert.assertEquals(1, Expr_549_list.size());
		//549
		final InclusiveOrExpression InclusiveOrExpression_550_Var
		 = (InclusiveOrExpression)Expr_549_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_550_Var
		);
		final EList<? extends EObject> Expr_550_list = InclusiveOrExpression_550_Var
		.getExpr();
		Assert.assertNotNull(Expr_550_list);
		Assert.assertEquals(1, Expr_550_list.size());
		//550
		final ExclusiveOrExpression ExclusiveOrExpression_551_Var
		 = (ExclusiveOrExpression)Expr_550_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_551_Var
		);
		final EList<? extends EObject> Expr_551_list = ExclusiveOrExpression_551_Var
		.getExpr();
		Assert.assertNotNull(Expr_551_list);
		Assert.assertEquals(1, Expr_551_list.size());
		//551
		final AndExpression AndExpression_552_Var
		 = (AndExpression)Expr_551_list.get(0);
		Assert.assertNotNull(AndExpression_552_Var
		);
		final EList<? extends EObject> Expr_552_list = AndExpression_552_Var
		.getExpr();
		Assert.assertNotNull(Expr_552_list);
		Assert.assertEquals(1, Expr_552_list.size());
		//552
		final EqualityExpression EqualityExpression_553_Var
		 = (EqualityExpression)Expr_552_list.get(0);
		Assert.assertNotNull(EqualityExpression_553_Var
		);
		final EList<? extends EObject> Expr_553_list = EqualityExpression_553_Var
		.getExpr();
		Assert.assertNotNull(Expr_553_list);
		Assert.assertEquals(1, Expr_553_list.size());
		//553
		final RelationalExpression RelationalExpression_554_Var
		 = (RelationalExpression)Expr_553_list.get(0);
		Assert.assertNotNull(RelationalExpression_554_Var
		);
		final EList<? extends EObject> Expr_554_list = RelationalExpression_554_Var
		.getExpr();
		Assert.assertNotNull(Expr_554_list);
		Assert.assertEquals(1, Expr_554_list.size());
		//554
		final ShiftExpression ShiftExpression_555_Var
		 = (ShiftExpression)Expr_554_list.get(0);
		Assert.assertNotNull(ShiftExpression_555_Var
		);
		final EList<? extends EObject> Expr_555_list = ShiftExpression_555_Var
		.getExpr();
		Assert.assertNotNull(Expr_555_list);
		Assert.assertEquals(1, Expr_555_list.size());
		//555
		final AdditiveExpression AdditiveExpression_556_Var
		 = (AdditiveExpression)Expr_555_list.get(0);
		Assert.assertNotNull(AdditiveExpression_556_Var
		);
		final EList<? extends EObject> Expr_556_list = AdditiveExpression_556_Var
		.getExpr();
		Assert.assertNotNull(Expr_556_list);
		Assert.assertEquals(1, Expr_556_list.size());
		//556
		final MultiplicativeExpression MultiplicativeExpression_557_Var
		 = (MultiplicativeExpression)Expr_556_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_557_Var
		);
		final EList<? extends EObject> Expr_557_list = MultiplicativeExpression_557_Var
		.getExpr();
		Assert.assertNotNull(Expr_557_list);
		Assert.assertEquals(1, Expr_557_list.size());
		//557
		final CastExpression CastExpression_558_Var
		 = (CastExpression)Expr_557_list.get(0);
		Assert.assertNotNull(CastExpression_558_Var
		);
		//558
		final UnaryExpression UnaryExpression_559_Var
		 = (UnaryExpression)CastExpression_558_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_559_Var
		);
		//559
		final PostfixExpression PostfixExpression_560_Var
		 = (PostfixExpression)UnaryExpression_559_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_560_Var
		);
		final EList<? extends EObject> Expr_560_list = PostfixExpression_560_Var
		.getExpr();
		Assert.assertNotNull(Expr_560_list);
		Assert.assertEquals(1, Expr_560_list.size());
		//560
		final PrimaryExpression PrimaryExpression_561_Var
		 = (PrimaryExpression)Expr_560_list.get(0);
		Assert.assertNotNull(PrimaryExpression_561_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_561_Var
		.getId());
		final EList<? extends EObject> Suffix_561_list = PostfixExpression_560_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_561_list);
		Assert.assertEquals(1, Suffix_561_list.size());
		//561
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_562_Var
		 = (PostfixExpressionSuffixArgument)Suffix_561_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_562_Var
		);
		//562
		final ArgumentExpressionList ArgumentExpressionList_563_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_562_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_563_Var
		);
		final EList<? extends EObject> Expr_563_list = ArgumentExpressionList_563_Var
		.getExpr();
		Assert.assertNotNull(Expr_563_list);
		Assert.assertEquals(2, Expr_563_list.size());
		//563
		final AssignmentExpression AssignmentExpression_564_Var
		 = (AssignmentExpression)Expr_563_list.get(0);
		Assert.assertNotNull(AssignmentExpression_564_Var
		);
		//564
		final ConditionalExpression ConditionalExpression_565_Var
		 = (ConditionalExpression)AssignmentExpression_564_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_565_Var
		);
		//565
		final LogicalOrExpression LogicalOrExpression_566_Var
		 = (LogicalOrExpression)ConditionalExpression_565_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_566_Var
		);
		final EList<? extends EObject> Expr_566_list = LogicalOrExpression_566_Var
		.getExpr();
		Assert.assertNotNull(Expr_566_list);
		Assert.assertEquals(1, Expr_566_list.size());
		//566
		final LogicalAndExpression LogicalAndExpression_567_Var
		 = (LogicalAndExpression)Expr_566_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_567_Var
		);
		final EList<? extends EObject> Expr_567_list = LogicalAndExpression_567_Var
		.getExpr();
		Assert.assertNotNull(Expr_567_list);
		Assert.assertEquals(1, Expr_567_list.size());
		//567
		final InclusiveOrExpression InclusiveOrExpression_568_Var
		 = (InclusiveOrExpression)Expr_567_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_568_Var
		);
		final EList<? extends EObject> Expr_568_list = InclusiveOrExpression_568_Var
		.getExpr();
		Assert.assertNotNull(Expr_568_list);
		Assert.assertEquals(1, Expr_568_list.size());
		//568
		final ExclusiveOrExpression ExclusiveOrExpression_569_Var
		 = (ExclusiveOrExpression)Expr_568_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_569_Var
		);
		final EList<? extends EObject> Expr_569_list = ExclusiveOrExpression_569_Var
		.getExpr();
		Assert.assertNotNull(Expr_569_list);
		Assert.assertEquals(1, Expr_569_list.size());
		//569
		final AndExpression AndExpression_570_Var
		 = (AndExpression)Expr_569_list.get(0);
		Assert.assertNotNull(AndExpression_570_Var
		);
		final EList<? extends EObject> Expr_570_list = AndExpression_570_Var
		.getExpr();
		Assert.assertNotNull(Expr_570_list);
		Assert.assertEquals(1, Expr_570_list.size());
		//570
		final EqualityExpression EqualityExpression_571_Var
		 = (EqualityExpression)Expr_570_list.get(0);
		Assert.assertNotNull(EqualityExpression_571_Var
		);
		final EList<? extends EObject> Expr_571_list = EqualityExpression_571_Var
		.getExpr();
		Assert.assertNotNull(Expr_571_list);
		Assert.assertEquals(1, Expr_571_list.size());
		//571
		final RelationalExpression RelationalExpression_572_Var
		 = (RelationalExpression)Expr_571_list.get(0);
		Assert.assertNotNull(RelationalExpression_572_Var
		);
		final EList<? extends EObject> Expr_572_list = RelationalExpression_572_Var
		.getExpr();
		Assert.assertNotNull(Expr_572_list);
		Assert.assertEquals(1, Expr_572_list.size());
		//572
		final ShiftExpression ShiftExpression_573_Var
		 = (ShiftExpression)Expr_572_list.get(0);
		Assert.assertNotNull(ShiftExpression_573_Var
		);
		final EList<? extends EObject> Expr_573_list = ShiftExpression_573_Var
		.getExpr();
		Assert.assertNotNull(Expr_573_list);
		Assert.assertEquals(1, Expr_573_list.size());
		//573
		final AdditiveExpression AdditiveExpression_574_Var
		 = (AdditiveExpression)Expr_573_list.get(0);
		Assert.assertNotNull(AdditiveExpression_574_Var
		);
		final EList<? extends EObject> Expr_574_list = AdditiveExpression_574_Var
		.getExpr();
		Assert.assertNotNull(Expr_574_list);
		Assert.assertEquals(1, Expr_574_list.size());
		//574
		final MultiplicativeExpression MultiplicativeExpression_575_Var
		 = (MultiplicativeExpression)Expr_574_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_575_Var
		);
		final EList<? extends EObject> Expr_575_list = MultiplicativeExpression_575_Var
		.getExpr();
		Assert.assertNotNull(Expr_575_list);
		Assert.assertEquals(1, Expr_575_list.size());
		//575
		final CastExpression CastExpression_576_Var
		 = (CastExpression)Expr_575_list.get(0);
		Assert.assertNotNull(CastExpression_576_Var
		);
		//576
		final UnaryExpression UnaryExpression_577_Var
		 = (UnaryExpression)CastExpression_576_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_577_Var
		);
		//577
		final PostfixExpression PostfixExpression_578_Var
		 = (PostfixExpression)UnaryExpression_577_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_578_Var
		);
		final EList<? extends EObject> Expr_578_list = PostfixExpression_578_Var
		.getExpr();
		Assert.assertNotNull(Expr_578_list);
		Assert.assertEquals(1, Expr_578_list.size());
		//578
		final PrimaryExpression PrimaryExpression_579_Var
		 = (PrimaryExpression)Expr_578_list.get(0);
		Assert.assertNotNull(PrimaryExpression_579_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_579_Var
		.getId());
		final EList<? extends EObject> Suffix_579_list = PostfixExpression_578_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_579_list);
		Assert.assertEquals(1, Suffix_579_list.size());
		//579
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_580_Var
		 = (PostfixExpressionSuffixArrow)Suffix_579_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArrow_580_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixArrow_580_Var
		.getId());
		//580
		final AssignmentExpression AssignmentExpression_581_Var
		 = (AssignmentExpression)Expr_563_list.get(1);
		Assert.assertNotNull(AssignmentExpression_581_Var
		);
		//581
		final ConditionalExpression ConditionalExpression_582_Var
		 = (ConditionalExpression)AssignmentExpression_581_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_582_Var
		);
		//582
		final LogicalOrExpression LogicalOrExpression_583_Var
		 = (LogicalOrExpression)ConditionalExpression_582_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_583_Var
		);
		final EList<? extends EObject> Expr_583_list = LogicalOrExpression_583_Var
		.getExpr();
		Assert.assertNotNull(Expr_583_list);
		Assert.assertEquals(1, Expr_583_list.size());
		//583
		final LogicalAndExpression LogicalAndExpression_584_Var
		 = (LogicalAndExpression)Expr_583_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_584_Var
		);
		final EList<? extends EObject> Expr_584_list = LogicalAndExpression_584_Var
		.getExpr();
		Assert.assertNotNull(Expr_584_list);
		Assert.assertEquals(1, Expr_584_list.size());
		//584
		final InclusiveOrExpression InclusiveOrExpression_585_Var
		 = (InclusiveOrExpression)Expr_584_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_585_Var
		);
		final EList<? extends EObject> Expr_585_list = InclusiveOrExpression_585_Var
		.getExpr();
		Assert.assertNotNull(Expr_585_list);
		Assert.assertEquals(1, Expr_585_list.size());
		//585
		final ExclusiveOrExpression ExclusiveOrExpression_586_Var
		 = (ExclusiveOrExpression)Expr_585_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_586_Var
		);
		final EList<? extends EObject> Expr_586_list = ExclusiveOrExpression_586_Var
		.getExpr();
		Assert.assertNotNull(Expr_586_list);
		Assert.assertEquals(1, Expr_586_list.size());
		//586
		final AndExpression AndExpression_587_Var
		 = (AndExpression)Expr_586_list.get(0);
		Assert.assertNotNull(AndExpression_587_Var
		);
		final EList<? extends EObject> Expr_587_list = AndExpression_587_Var
		.getExpr();
		Assert.assertNotNull(Expr_587_list);
		Assert.assertEquals(1, Expr_587_list.size());
		//587
		final EqualityExpression EqualityExpression_588_Var
		 = (EqualityExpression)Expr_587_list.get(0);
		Assert.assertNotNull(EqualityExpression_588_Var
		);
		final EList<? extends EObject> Expr_588_list = EqualityExpression_588_Var
		.getExpr();
		Assert.assertNotNull(Expr_588_list);
		Assert.assertEquals(1, Expr_588_list.size());
		//588
		final RelationalExpression RelationalExpression_589_Var
		 = (RelationalExpression)Expr_588_list.get(0);
		Assert.assertNotNull(RelationalExpression_589_Var
		);
		final EList<? extends EObject> Expr_589_list = RelationalExpression_589_Var
		.getExpr();
		Assert.assertNotNull(Expr_589_list);
		Assert.assertEquals(1, Expr_589_list.size());
		//589
		final ShiftExpression ShiftExpression_590_Var
		 = (ShiftExpression)Expr_589_list.get(0);
		Assert.assertNotNull(ShiftExpression_590_Var
		);
		final EList<? extends EObject> Expr_590_list = ShiftExpression_590_Var
		.getExpr();
		Assert.assertNotNull(Expr_590_list);
		Assert.assertEquals(1, Expr_590_list.size());
		//590
		final AdditiveExpression AdditiveExpression_591_Var
		 = (AdditiveExpression)Expr_590_list.get(0);
		Assert.assertNotNull(AdditiveExpression_591_Var
		);
		final EList<? extends EObject> Expr_591_list = AdditiveExpression_591_Var
		.getExpr();
		Assert.assertNotNull(Expr_591_list);
		Assert.assertEquals(1, Expr_591_list.size());
		//591
		final MultiplicativeExpression MultiplicativeExpression_592_Var
		 = (MultiplicativeExpression)Expr_591_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_592_Var
		);
		final EList<? extends EObject> Expr_592_list = MultiplicativeExpression_592_Var
		.getExpr();
		Assert.assertNotNull(Expr_592_list);
		Assert.assertEquals(1, Expr_592_list.size());
		//592
		final CastExpression CastExpression_593_Var
		 = (CastExpression)Expr_592_list.get(0);
		Assert.assertNotNull(CastExpression_593_Var
		);
		//593
		final UnaryExpression UnaryExpression_594_Var
		 = (UnaryExpression)CastExpression_593_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_594_Var
		);
		//594
		final PostfixExpression PostfixExpression_595_Var
		 = (PostfixExpression)UnaryExpression_594_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_595_Var
		);
		final EList<? extends EObject> Expr_595_list = PostfixExpression_595_Var
		.getExpr();
		Assert.assertNotNull(Expr_595_list);
		Assert.assertEquals(1, Expr_595_list.size());
		//595
		final PrimaryExpression PrimaryExpression_596_Var
		 = (PrimaryExpression)Expr_595_list.get(0);
		Assert.assertNotNull(PrimaryExpression_596_Var
		);
		Assert.assertEquals("[\"Billy The Kid\"]", PrimaryExpression_596_Var
		.getString().toString());
		Assert.assertEquals(";", ExpressionStatement_544_Var
		.getSemi());
		//596
		final Statement Statement_597_Var
		 = (Statement)Statement_345_list.get(5);
		Assert.assertNotNull(Statement_597_Var
		);
		//597
		final ExpressionStatement ExpressionStatement_598_Var
		 = (ExpressionStatement)Statement_597_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_598_Var
		);
		//598
		final Expression Expression_599_Var
		 = (Expression)ExpressionStatement_598_Var
		.getExpression();
		Assert.assertNotNull(Expression_599_Var
		);
		final EList<? extends EObject> ExprExpr_599_list = Expression_599_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_599_list);
		Assert.assertEquals(1, ExprExpr_599_list.size());
		//599
		final AssignmentExpression AssignmentExpression_600_Var
		 = (AssignmentExpression)ExprExpr_599_list.get(0);
		Assert.assertNotNull(AssignmentExpression_600_Var
		);
		//600
		final ConditionalExpression ConditionalExpression_601_Var
		 = (ConditionalExpression)AssignmentExpression_600_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_601_Var
		);
		//601
		final LogicalOrExpression LogicalOrExpression_602_Var
		 = (LogicalOrExpression)ConditionalExpression_601_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_602_Var
		);
		final EList<? extends EObject> Expr_602_list = LogicalOrExpression_602_Var
		.getExpr();
		Assert.assertNotNull(Expr_602_list);
		Assert.assertEquals(1, Expr_602_list.size());
		//602
		final LogicalAndExpression LogicalAndExpression_603_Var
		 = (LogicalAndExpression)Expr_602_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_603_Var
		);
		final EList<? extends EObject> Expr_603_list = LogicalAndExpression_603_Var
		.getExpr();
		Assert.assertNotNull(Expr_603_list);
		Assert.assertEquals(1, Expr_603_list.size());
		//603
		final InclusiveOrExpression InclusiveOrExpression_604_Var
		 = (InclusiveOrExpression)Expr_603_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_604_Var
		);
		final EList<? extends EObject> Expr_604_list = InclusiveOrExpression_604_Var
		.getExpr();
		Assert.assertNotNull(Expr_604_list);
		Assert.assertEquals(1, Expr_604_list.size());
		//604
		final ExclusiveOrExpression ExclusiveOrExpression_605_Var
		 = (ExclusiveOrExpression)Expr_604_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_605_Var
		);
		final EList<? extends EObject> Expr_605_list = ExclusiveOrExpression_605_Var
		.getExpr();
		Assert.assertNotNull(Expr_605_list);
		Assert.assertEquals(1, Expr_605_list.size());
		//605
		final AndExpression AndExpression_606_Var
		 = (AndExpression)Expr_605_list.get(0);
		Assert.assertNotNull(AndExpression_606_Var
		);
		final EList<? extends EObject> Expr_606_list = AndExpression_606_Var
		.getExpr();
		Assert.assertNotNull(Expr_606_list);
		Assert.assertEquals(1, Expr_606_list.size());
		//606
		final EqualityExpression EqualityExpression_607_Var
		 = (EqualityExpression)Expr_606_list.get(0);
		Assert.assertNotNull(EqualityExpression_607_Var
		);
		final EList<? extends EObject> Expr_607_list = EqualityExpression_607_Var
		.getExpr();
		Assert.assertNotNull(Expr_607_list);
		Assert.assertEquals(1, Expr_607_list.size());
		//607
		final RelationalExpression RelationalExpression_608_Var
		 = (RelationalExpression)Expr_607_list.get(0);
		Assert.assertNotNull(RelationalExpression_608_Var
		);
		final EList<? extends EObject> Expr_608_list = RelationalExpression_608_Var
		.getExpr();
		Assert.assertNotNull(Expr_608_list);
		Assert.assertEquals(1, Expr_608_list.size());
		//608
		final ShiftExpression ShiftExpression_609_Var
		 = (ShiftExpression)Expr_608_list.get(0);
		Assert.assertNotNull(ShiftExpression_609_Var
		);
		final EList<? extends EObject> Expr_609_list = ShiftExpression_609_Var
		.getExpr();
		Assert.assertNotNull(Expr_609_list);
		Assert.assertEquals(1, Expr_609_list.size());
		//609
		final AdditiveExpression AdditiveExpression_610_Var
		 = (AdditiveExpression)Expr_609_list.get(0);
		Assert.assertNotNull(AdditiveExpression_610_Var
		);
		final EList<? extends EObject> Expr_610_list = AdditiveExpression_610_Var
		.getExpr();
		Assert.assertNotNull(Expr_610_list);
		Assert.assertEquals(1, Expr_610_list.size());
		//610
		final MultiplicativeExpression MultiplicativeExpression_611_Var
		 = (MultiplicativeExpression)Expr_610_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_611_Var
		);
		final EList<? extends EObject> Expr_611_list = MultiplicativeExpression_611_Var
		.getExpr();
		Assert.assertNotNull(Expr_611_list);
		Assert.assertEquals(1, Expr_611_list.size());
		//611
		final CastExpression CastExpression_612_Var
		 = (CastExpression)Expr_611_list.get(0);
		Assert.assertNotNull(CastExpression_612_Var
		);
		//612
		final UnaryExpression UnaryExpression_613_Var
		 = (UnaryExpression)CastExpression_612_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_613_Var
		);
		//613
		final PostfixExpression PostfixExpression_614_Var
		 = (PostfixExpression)UnaryExpression_613_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_614_Var
		);
		final EList<? extends EObject> Expr_614_list = PostfixExpression_614_Var
		.getExpr();
		Assert.assertNotNull(Expr_614_list);
		Assert.assertEquals(1, Expr_614_list.size());
		//614
		final PrimaryExpression PrimaryExpression_615_Var
		 = (PrimaryExpression)Expr_614_list.get(0);
		Assert.assertNotNull(PrimaryExpression_615_Var
		);
		Assert.assertEquals("print", PrimaryExpression_615_Var
		.getId());
		final EList<? extends EObject> Suffix_615_list = PostfixExpression_614_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_615_list);
		Assert.assertEquals(1, Suffix_615_list.size());
		//615
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_616_Var
		 = (PostfixExpressionSuffixArgument)Suffix_615_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_616_Var
		);
		//616
		final ArgumentExpressionList ArgumentExpressionList_617_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_616_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_617_Var
		);
		final EList<? extends EObject> Expr_617_list = ArgumentExpressionList_617_Var
		.getExpr();
		Assert.assertNotNull(Expr_617_list);
		Assert.assertEquals(1, Expr_617_list.size());
		//617
		final AssignmentExpression AssignmentExpression_618_Var
		 = (AssignmentExpression)Expr_617_list.get(0);
		Assert.assertNotNull(AssignmentExpression_618_Var
		);
		//618
		final ConditionalExpression ConditionalExpression_619_Var
		 = (ConditionalExpression)AssignmentExpression_618_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_619_Var
		);
		//619
		final LogicalOrExpression LogicalOrExpression_620_Var
		 = (LogicalOrExpression)ConditionalExpression_619_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_620_Var
		);
		final EList<? extends EObject> Expr_620_list = LogicalOrExpression_620_Var
		.getExpr();
		Assert.assertNotNull(Expr_620_list);
		Assert.assertEquals(1, Expr_620_list.size());
		//620
		final LogicalAndExpression LogicalAndExpression_621_Var
		 = (LogicalAndExpression)Expr_620_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_621_Var
		);
		final EList<? extends EObject> Expr_621_list = LogicalAndExpression_621_Var
		.getExpr();
		Assert.assertNotNull(Expr_621_list);
		Assert.assertEquals(1, Expr_621_list.size());
		//621
		final InclusiveOrExpression InclusiveOrExpression_622_Var
		 = (InclusiveOrExpression)Expr_621_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_622_Var
		);
		final EList<? extends EObject> Expr_622_list = InclusiveOrExpression_622_Var
		.getExpr();
		Assert.assertNotNull(Expr_622_list);
		Assert.assertEquals(1, Expr_622_list.size());
		//622
		final ExclusiveOrExpression ExclusiveOrExpression_623_Var
		 = (ExclusiveOrExpression)Expr_622_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_623_Var
		);
		final EList<? extends EObject> Expr_623_list = ExclusiveOrExpression_623_Var
		.getExpr();
		Assert.assertNotNull(Expr_623_list);
		Assert.assertEquals(1, Expr_623_list.size());
		//623
		final AndExpression AndExpression_624_Var
		 = (AndExpression)Expr_623_list.get(0);
		Assert.assertNotNull(AndExpression_624_Var
		);
		final EList<? extends EObject> Expr_624_list = AndExpression_624_Var
		.getExpr();
		Assert.assertNotNull(Expr_624_list);
		Assert.assertEquals(1, Expr_624_list.size());
		//624
		final EqualityExpression EqualityExpression_625_Var
		 = (EqualityExpression)Expr_624_list.get(0);
		Assert.assertNotNull(EqualityExpression_625_Var
		);
		final EList<? extends EObject> Expr_625_list = EqualityExpression_625_Var
		.getExpr();
		Assert.assertNotNull(Expr_625_list);
		Assert.assertEquals(1, Expr_625_list.size());
		//625
		final RelationalExpression RelationalExpression_626_Var
		 = (RelationalExpression)Expr_625_list.get(0);
		Assert.assertNotNull(RelationalExpression_626_Var
		);
		final EList<? extends EObject> Expr_626_list = RelationalExpression_626_Var
		.getExpr();
		Assert.assertNotNull(Expr_626_list);
		Assert.assertEquals(1, Expr_626_list.size());
		//626
		final ShiftExpression ShiftExpression_627_Var
		 = (ShiftExpression)Expr_626_list.get(0);
		Assert.assertNotNull(ShiftExpression_627_Var
		);
		final EList<? extends EObject> Expr_627_list = ShiftExpression_627_Var
		.getExpr();
		Assert.assertNotNull(Expr_627_list);
		Assert.assertEquals(1, Expr_627_list.size());
		//627
		final AdditiveExpression AdditiveExpression_628_Var
		 = (AdditiveExpression)Expr_627_list.get(0);
		Assert.assertNotNull(AdditiveExpression_628_Var
		);
		final EList<? extends EObject> Expr_628_list = AdditiveExpression_628_Var
		.getExpr();
		Assert.assertNotNull(Expr_628_list);
		Assert.assertEquals(1, Expr_628_list.size());
		//628
		final MultiplicativeExpression MultiplicativeExpression_629_Var
		 = (MultiplicativeExpression)Expr_628_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_629_Var
		);
		final EList<? extends EObject> Expr_629_list = MultiplicativeExpression_629_Var
		.getExpr();
		Assert.assertNotNull(Expr_629_list);
		Assert.assertEquals(1, Expr_629_list.size());
		//629
		final CastExpression CastExpression_630_Var
		 = (CastExpression)Expr_629_list.get(0);
		Assert.assertNotNull(CastExpression_630_Var
		);
		//630
		final UnaryExpression UnaryExpression_631_Var
		 = (UnaryExpression)CastExpression_630_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_631_Var
		);
		//631
		final PostfixExpression PostfixExpression_632_Var
		 = (PostfixExpression)UnaryExpression_631_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_632_Var
		);
		final EList<? extends EObject> Expr_632_list = PostfixExpression_632_Var
		.getExpr();
		Assert.assertNotNull(Expr_632_list);
		Assert.assertEquals(1, Expr_632_list.size());
		//632
		final PrimaryExpression PrimaryExpression_633_Var
		 = (PrimaryExpression)Expr_632_list.get(0);
		Assert.assertNotNull(PrimaryExpression_633_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_633_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_598_Var
		.getSemi());
		//633
		final Statement Statement_634_Var
		 = (Statement)Statement_345_list.get(6);
		Assert.assertNotNull(Statement_634_Var
		);
		//634
		final ExpressionStatement ExpressionStatement_635_Var
		 = (ExpressionStatement)Statement_634_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_635_Var
		);
		//635
		final Expression Expression_636_Var
		 = (Expression)ExpressionStatement_635_Var
		.getExpression();
		Assert.assertNotNull(Expression_636_Var
		);
		final EList<? extends EObject> ExprExpr_636_list = Expression_636_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_636_list);
		Assert.assertEquals(1, ExprExpr_636_list.size());
		//636
		final AssignmentExpression AssignmentExpression_637_Var
		 = (AssignmentExpression)ExprExpr_636_list.get(0);
		Assert.assertNotNull(AssignmentExpression_637_Var
		);
		//637
		final ConditionalExpression ConditionalExpression_638_Var
		 = (ConditionalExpression)AssignmentExpression_637_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_638_Var
		);
		//638
		final LogicalOrExpression LogicalOrExpression_639_Var
		 = (LogicalOrExpression)ConditionalExpression_638_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_639_Var
		);
		final EList<? extends EObject> Expr_639_list = LogicalOrExpression_639_Var
		.getExpr();
		Assert.assertNotNull(Expr_639_list);
		Assert.assertEquals(1, Expr_639_list.size());
		//639
		final LogicalAndExpression LogicalAndExpression_640_Var
		 = (LogicalAndExpression)Expr_639_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_640_Var
		);
		final EList<? extends EObject> Expr_640_list = LogicalAndExpression_640_Var
		.getExpr();
		Assert.assertNotNull(Expr_640_list);
		Assert.assertEquals(1, Expr_640_list.size());
		//640
		final InclusiveOrExpression InclusiveOrExpression_641_Var
		 = (InclusiveOrExpression)Expr_640_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_641_Var
		);
		final EList<? extends EObject> Expr_641_list = InclusiveOrExpression_641_Var
		.getExpr();
		Assert.assertNotNull(Expr_641_list);
		Assert.assertEquals(1, Expr_641_list.size());
		//641
		final ExclusiveOrExpression ExclusiveOrExpression_642_Var
		 = (ExclusiveOrExpression)Expr_641_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_642_Var
		);
		final EList<? extends EObject> Expr_642_list = ExclusiveOrExpression_642_Var
		.getExpr();
		Assert.assertNotNull(Expr_642_list);
		Assert.assertEquals(1, Expr_642_list.size());
		//642
		final AndExpression AndExpression_643_Var
		 = (AndExpression)Expr_642_list.get(0);
		Assert.assertNotNull(AndExpression_643_Var
		);
		final EList<? extends EObject> Expr_643_list = AndExpression_643_Var
		.getExpr();
		Assert.assertNotNull(Expr_643_list);
		Assert.assertEquals(1, Expr_643_list.size());
		//643
		final EqualityExpression EqualityExpression_644_Var
		 = (EqualityExpression)Expr_643_list.get(0);
		Assert.assertNotNull(EqualityExpression_644_Var
		);
		final EList<? extends EObject> Expr_644_list = EqualityExpression_644_Var
		.getExpr();
		Assert.assertNotNull(Expr_644_list);
		Assert.assertEquals(1, Expr_644_list.size());
		//644
		final RelationalExpression RelationalExpression_645_Var
		 = (RelationalExpression)Expr_644_list.get(0);
		Assert.assertNotNull(RelationalExpression_645_Var
		);
		final EList<? extends EObject> Expr_645_list = RelationalExpression_645_Var
		.getExpr();
		Assert.assertNotNull(Expr_645_list);
		Assert.assertEquals(1, Expr_645_list.size());
		//645
		final ShiftExpression ShiftExpression_646_Var
		 = (ShiftExpression)Expr_645_list.get(0);
		Assert.assertNotNull(ShiftExpression_646_Var
		);
		final EList<? extends EObject> Expr_646_list = ShiftExpression_646_Var
		.getExpr();
		Assert.assertNotNull(Expr_646_list);
		Assert.assertEquals(1, Expr_646_list.size());
		//646
		final AdditiveExpression AdditiveExpression_647_Var
		 = (AdditiveExpression)Expr_646_list.get(0);
		Assert.assertNotNull(AdditiveExpression_647_Var
		);
		final EList<? extends EObject> Expr_647_list = AdditiveExpression_647_Var
		.getExpr();
		Assert.assertNotNull(Expr_647_list);
		Assert.assertEquals(1, Expr_647_list.size());
		//647
		final MultiplicativeExpression MultiplicativeExpression_648_Var
		 = (MultiplicativeExpression)Expr_647_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_648_Var
		);
		final EList<? extends EObject> Expr_648_list = MultiplicativeExpression_648_Var
		.getExpr();
		Assert.assertNotNull(Expr_648_list);
		Assert.assertEquals(1, Expr_648_list.size());
		//648
		final CastExpression CastExpression_649_Var
		 = (CastExpression)Expr_648_list.get(0);
		Assert.assertNotNull(CastExpression_649_Var
		);
		//649
		final UnaryExpression UnaryExpression_650_Var
		 = (UnaryExpression)CastExpression_649_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_650_Var
		);
		//650
		final PostfixExpression PostfixExpression_651_Var
		 = (PostfixExpression)UnaryExpression_650_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_651_Var
		);
		final EList<? extends EObject> Expr_651_list = PostfixExpression_651_Var
		.getExpr();
		Assert.assertNotNull(Expr_651_list);
		Assert.assertEquals(1, Expr_651_list.size());
		//651
		final PrimaryExpression PrimaryExpression_652_Var
		 = (PrimaryExpression)Expr_651_list.get(0);
		Assert.assertNotNull(PrimaryExpression_652_Var
		);
		Assert.assertEquals("free", PrimaryExpression_652_Var
		.getId());
		final EList<? extends EObject> Suffix_652_list = PostfixExpression_651_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_652_list);
		Assert.assertEquals(1, Suffix_652_list.size());
		//652
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_653_Var
		 = (PostfixExpressionSuffixArgument)Suffix_652_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_653_Var
		);
		//653
		final ArgumentExpressionList ArgumentExpressionList_654_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_653_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_654_Var
		);
		final EList<? extends EObject> Expr_654_list = ArgumentExpressionList_654_Var
		.getExpr();
		Assert.assertNotNull(Expr_654_list);
		Assert.assertEquals(1, Expr_654_list.size());
		//654
		final AssignmentExpression AssignmentExpression_655_Var
		 = (AssignmentExpression)Expr_654_list.get(0);
		Assert.assertNotNull(AssignmentExpression_655_Var
		);
		//655
		final ConditionalExpression ConditionalExpression_656_Var
		 = (ConditionalExpression)AssignmentExpression_655_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_656_Var
		);
		//656
		final LogicalOrExpression LogicalOrExpression_657_Var
		 = (LogicalOrExpression)ConditionalExpression_656_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_657_Var
		);
		final EList<? extends EObject> Expr_657_list = LogicalOrExpression_657_Var
		.getExpr();
		Assert.assertNotNull(Expr_657_list);
		Assert.assertEquals(1, Expr_657_list.size());
		//657
		final LogicalAndExpression LogicalAndExpression_658_Var
		 = (LogicalAndExpression)Expr_657_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_658_Var
		);
		final EList<? extends EObject> Expr_658_list = LogicalAndExpression_658_Var
		.getExpr();
		Assert.assertNotNull(Expr_658_list);
		Assert.assertEquals(1, Expr_658_list.size());
		//658
		final InclusiveOrExpression InclusiveOrExpression_659_Var
		 = (InclusiveOrExpression)Expr_658_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_659_Var
		);
		final EList<? extends EObject> Expr_659_list = InclusiveOrExpression_659_Var
		.getExpr();
		Assert.assertNotNull(Expr_659_list);
		Assert.assertEquals(1, Expr_659_list.size());
		//659
		final ExclusiveOrExpression ExclusiveOrExpression_660_Var
		 = (ExclusiveOrExpression)Expr_659_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_660_Var
		);
		final EList<? extends EObject> Expr_660_list = ExclusiveOrExpression_660_Var
		.getExpr();
		Assert.assertNotNull(Expr_660_list);
		Assert.assertEquals(1, Expr_660_list.size());
		//660
		final AndExpression AndExpression_661_Var
		 = (AndExpression)Expr_660_list.get(0);
		Assert.assertNotNull(AndExpression_661_Var
		);
		final EList<? extends EObject> Expr_661_list = AndExpression_661_Var
		.getExpr();
		Assert.assertNotNull(Expr_661_list);
		Assert.assertEquals(1, Expr_661_list.size());
		//661
		final EqualityExpression EqualityExpression_662_Var
		 = (EqualityExpression)Expr_661_list.get(0);
		Assert.assertNotNull(EqualityExpression_662_Var
		);
		final EList<? extends EObject> Expr_662_list = EqualityExpression_662_Var
		.getExpr();
		Assert.assertNotNull(Expr_662_list);
		Assert.assertEquals(1, Expr_662_list.size());
		//662
		final RelationalExpression RelationalExpression_663_Var
		 = (RelationalExpression)Expr_662_list.get(0);
		Assert.assertNotNull(RelationalExpression_663_Var
		);
		final EList<? extends EObject> Expr_663_list = RelationalExpression_663_Var
		.getExpr();
		Assert.assertNotNull(Expr_663_list);
		Assert.assertEquals(1, Expr_663_list.size());
		//663
		final ShiftExpression ShiftExpression_664_Var
		 = (ShiftExpression)Expr_663_list.get(0);
		Assert.assertNotNull(ShiftExpression_664_Var
		);
		final EList<? extends EObject> Expr_664_list = ShiftExpression_664_Var
		.getExpr();
		Assert.assertNotNull(Expr_664_list);
		Assert.assertEquals(1, Expr_664_list.size());
		//664
		final AdditiveExpression AdditiveExpression_665_Var
		 = (AdditiveExpression)Expr_664_list.get(0);
		Assert.assertNotNull(AdditiveExpression_665_Var
		);
		final EList<? extends EObject> Expr_665_list = AdditiveExpression_665_Var
		.getExpr();
		Assert.assertNotNull(Expr_665_list);
		Assert.assertEquals(1, Expr_665_list.size());
		//665
		final MultiplicativeExpression MultiplicativeExpression_666_Var
		 = (MultiplicativeExpression)Expr_665_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_666_Var
		);
		final EList<? extends EObject> Expr_666_list = MultiplicativeExpression_666_Var
		.getExpr();
		Assert.assertNotNull(Expr_666_list);
		Assert.assertEquals(1, Expr_666_list.size());
		//666
		final CastExpression CastExpression_667_Var
		 = (CastExpression)Expr_666_list.get(0);
		Assert.assertNotNull(CastExpression_667_Var
		);
		//667
		final UnaryExpression UnaryExpression_668_Var
		 = (UnaryExpression)CastExpression_667_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_668_Var
		);
		//668
		final PostfixExpression PostfixExpression_669_Var
		 = (PostfixExpression)UnaryExpression_668_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_669_Var
		);
		final EList<? extends EObject> Expr_669_list = PostfixExpression_669_Var
		.getExpr();
		Assert.assertNotNull(Expr_669_list);
		Assert.assertEquals(1, Expr_669_list.size());
		//669
		final PrimaryExpression PrimaryExpression_670_Var
		 = (PrimaryExpression)Expr_669_list.get(0);
		Assert.assertNotNull(PrimaryExpression_670_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_670_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_635_Var
		.getSemi());
		//670
		final Statement Statement_671_Var
		 = (Statement)Statement_345_list.get(7);
		Assert.assertNotNull(Statement_671_Var
		);
		//671
		final JumpStatement JumpStatement_672_Var
		 = (JumpStatement)Statement_671_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_672_Var
		);
		//672
		final Expression Expression_673_Var
		 = (Expression)JumpStatement_672_Var
		.getExpr();
		Assert.assertNotNull(Expression_673_Var
		);
		final EList<? extends EObject> ExprExpr_673_list = Expression_673_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_673_list);
		Assert.assertEquals(1, ExprExpr_673_list.size());
		//673
		final AssignmentExpression AssignmentExpression_674_Var
		 = (AssignmentExpression)ExprExpr_673_list.get(0);
		Assert.assertNotNull(AssignmentExpression_674_Var
		);
		//674
		final ConditionalExpression ConditionalExpression_675_Var
		 = (ConditionalExpression)AssignmentExpression_674_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_675_Var
		);
		//675
		final LogicalOrExpression LogicalOrExpression_676_Var
		 = (LogicalOrExpression)ConditionalExpression_675_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_676_Var
		);
		final EList<? extends EObject> Expr_676_list = LogicalOrExpression_676_Var
		.getExpr();
		Assert.assertNotNull(Expr_676_list);
		Assert.assertEquals(1, Expr_676_list.size());
		//676
		final LogicalAndExpression LogicalAndExpression_677_Var
		 = (LogicalAndExpression)Expr_676_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_677_Var
		);
		final EList<? extends EObject> Expr_677_list = LogicalAndExpression_677_Var
		.getExpr();
		Assert.assertNotNull(Expr_677_list);
		Assert.assertEquals(1, Expr_677_list.size());
		//677
		final InclusiveOrExpression InclusiveOrExpression_678_Var
		 = (InclusiveOrExpression)Expr_677_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_678_Var
		);
		final EList<? extends EObject> Expr_678_list = InclusiveOrExpression_678_Var
		.getExpr();
		Assert.assertNotNull(Expr_678_list);
		Assert.assertEquals(1, Expr_678_list.size());
		//678
		final ExclusiveOrExpression ExclusiveOrExpression_679_Var
		 = (ExclusiveOrExpression)Expr_678_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_679_Var
		);
		final EList<? extends EObject> Expr_679_list = ExclusiveOrExpression_679_Var
		.getExpr();
		Assert.assertNotNull(Expr_679_list);
		Assert.assertEquals(1, Expr_679_list.size());
		//679
		final AndExpression AndExpression_680_Var
		 = (AndExpression)Expr_679_list.get(0);
		Assert.assertNotNull(AndExpression_680_Var
		);
		final EList<? extends EObject> Expr_680_list = AndExpression_680_Var
		.getExpr();
		Assert.assertNotNull(Expr_680_list);
		Assert.assertEquals(1, Expr_680_list.size());
		//680
		final EqualityExpression EqualityExpression_681_Var
		 = (EqualityExpression)Expr_680_list.get(0);
		Assert.assertNotNull(EqualityExpression_681_Var
		);
		final EList<? extends EObject> Expr_681_list = EqualityExpression_681_Var
		.getExpr();
		Assert.assertNotNull(Expr_681_list);
		Assert.assertEquals(1, Expr_681_list.size());
		//681
		final RelationalExpression RelationalExpression_682_Var
		 = (RelationalExpression)Expr_681_list.get(0);
		Assert.assertNotNull(RelationalExpression_682_Var
		);
		final EList<? extends EObject> Expr_682_list = RelationalExpression_682_Var
		.getExpr();
		Assert.assertNotNull(Expr_682_list);
		Assert.assertEquals(1, Expr_682_list.size());
		//682
		final ShiftExpression ShiftExpression_683_Var
		 = (ShiftExpression)Expr_682_list.get(0);
		Assert.assertNotNull(ShiftExpression_683_Var
		);
		final EList<? extends EObject> Expr_683_list = ShiftExpression_683_Var
		.getExpr();
		Assert.assertNotNull(Expr_683_list);
		Assert.assertEquals(1, Expr_683_list.size());
		//683
		final AdditiveExpression AdditiveExpression_684_Var
		 = (AdditiveExpression)Expr_683_list.get(0);
		Assert.assertNotNull(AdditiveExpression_684_Var
		);
		final EList<? extends EObject> Expr_684_list = AdditiveExpression_684_Var
		.getExpr();
		Assert.assertNotNull(Expr_684_list);
		Assert.assertEquals(1, Expr_684_list.size());
		//684
		final MultiplicativeExpression MultiplicativeExpression_685_Var
		 = (MultiplicativeExpression)Expr_684_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_685_Var
		);
		final EList<? extends EObject> Expr_685_list = MultiplicativeExpression_685_Var
		.getExpr();
		Assert.assertNotNull(Expr_685_list);
		Assert.assertEquals(1, Expr_685_list.size());
		//685
		final CastExpression CastExpression_686_Var
		 = (CastExpression)Expr_685_list.get(0);
		Assert.assertNotNull(CastExpression_686_Var
		);
		//686
		final UnaryExpression UnaryExpression_687_Var
		 = (UnaryExpression)CastExpression_686_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_687_Var
		);
		//687
		final PostfixExpression PostfixExpression_688_Var
		 = (PostfixExpression)UnaryExpression_687_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_688_Var
		);
		final EList<? extends EObject> Expr_688_list = PostfixExpression_688_Var
		.getExpr();
		Assert.assertNotNull(Expr_688_list);
		Assert.assertEquals(1, Expr_688_list.size());
		//688
		final PrimaryExpression PrimaryExpression_689_Var
		 = (PrimaryExpression)Expr_688_list.get(0);
		Assert.assertNotNull(PrimaryExpression_689_Var
		);
		//689
		final Constant2 Constant2_690_Var
		 = (Constant2)PrimaryExpression_689_Var
		.getConst();
		Assert.assertNotNull(Constant2_690_Var
		);
		Assert.assertEquals("0", Constant2_690_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_672_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_672_Var
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


