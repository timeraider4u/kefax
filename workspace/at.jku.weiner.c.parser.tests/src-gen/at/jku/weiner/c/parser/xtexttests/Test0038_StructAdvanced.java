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
		Assert.assertEquals(5, External_2_list.size());
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
		Assert.assertEquals(2, DeclarationSpecifier_5_list.size());
		//5
		final StorageClassSpecifier StorageClassSpecifier_6_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_5_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_6_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_6_Var
		.getName());
		//6
		final StructOrUnionSpecifier StructOrUnionSpecifier_7_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_5_list.get(1);
		Assert.assertNotNull(StructOrUnionSpecifier_7_Var
		);
		//7
		final StructOrUnion StructOrUnion_8_Var
		 = (StructOrUnion)StructOrUnionSpecifier_7_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_8_Var
		);
		Assert.assertEquals("struct", StructOrUnion_8_Var
		.getName());
		Assert.assertEquals("empStruct", StructOrUnionSpecifier_7_Var
		.getId());
		//8
		final StructDeclarationList StructDeclarationList_9_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_7_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_9_Var
		);
		final EList<? extends EObject> StructDeclaration_9_list = StructDeclarationList_9_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_9_list);
		Assert.assertEquals(2, StructDeclaration_9_list.size());
		//9
		final StructDeclaration StructDeclaration_10_Var
		 = (StructDeclaration)StructDeclaration_9_list.get(0);
		Assert.assertNotNull(StructDeclaration_10_Var
		);
		//10
		final SpecifierQualifierList SpecifierQualifierList_11_Var
		 = (SpecifierQualifierList)StructDeclaration_10_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_11_Var
		);
		final EList<? extends EObject> TypeSpecifier_11_list = SpecifierQualifierList_11_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_11_list);
		Assert.assertEquals(1, TypeSpecifier_11_list.size());
		//11
		final TypeSpecifier TypeSpecifier_12_Var
		 = (TypeSpecifier)TypeSpecifier_11_list.get(0);
		Assert.assertNotNull(TypeSpecifier_12_Var
		);
		Assert.assertEquals("int", TypeSpecifier_12_Var
		.getName());
		//12
		final StructDeclaratorList StructDeclaratorList_13_Var
		 = (StructDeclaratorList)StructDeclaration_10_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_13_Var
		);
		final EList<? extends EObject> StructDeclarator_13_list = StructDeclaratorList_13_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_13_list);
		Assert.assertEquals(1, StructDeclarator_13_list.size());
		//13
		final StructDeclarator StructDeclarator_14_Var
		 = (StructDeclarator)StructDeclarator_13_list.get(0);
		Assert.assertNotNull(StructDeclarator_14_Var
		);
		//14
		final Declarator Declarator_15_Var
		 = (Declarator)StructDeclarator_14_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_15_Var
		);
		//15
		final DirectDeclarator DirectDeclarator_16_Var
		 = (DirectDeclarator)Declarator_15_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_16_Var
		);
		Assert.assertEquals("id", DirectDeclarator_16_Var
		.getId());
		//16
		final StructDeclaration StructDeclaration_17_Var
		 = (StructDeclaration)StructDeclaration_9_list.get(1);
		Assert.assertNotNull(StructDeclaration_17_Var
		);
		//17
		final SpecifierQualifierList SpecifierQualifierList_18_Var
		 = (SpecifierQualifierList)StructDeclaration_17_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_18_Var
		);
		final EList<? extends EObject> TypeSpecifier_18_list = SpecifierQualifierList_18_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_18_list);
		Assert.assertEquals(1, TypeSpecifier_18_list.size());
		//18
		final TypeSpecifier TypeSpecifier_19_Var
		 = (TypeSpecifier)TypeSpecifier_18_list.get(0);
		Assert.assertNotNull(TypeSpecifier_19_Var
		);
		Assert.assertEquals("char", TypeSpecifier_19_Var
		.getName());
		//19
		final StructDeclaratorList StructDeclaratorList_20_Var
		 = (StructDeclaratorList)StructDeclaration_17_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_20_Var
		);
		final EList<? extends EObject> StructDeclarator_20_list = StructDeclaratorList_20_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_20_list);
		Assert.assertEquals(1, StructDeclarator_20_list.size());
		//20
		final StructDeclarator StructDeclarator_21_Var
		 = (StructDeclarator)StructDeclarator_20_list.get(0);
		Assert.assertNotNull(StructDeclarator_21_Var
		);
		//21
		final Declarator Declarator_22_Var
		 = (Declarator)StructDeclarator_21_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_22_Var
		);
		//22
		final DirectDeclarator DirectDeclarator_23_Var
		 = (DirectDeclarator)Declarator_22_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_23_Var
		);
		Assert.assertEquals("name", DirectDeclarator_23_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_23_list = DirectDeclarator_23_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_23_list);
		Assert.assertEquals(1, DeclaratorSuffix_23_list.size());
		//23
		final DeclaratorSuffix DeclaratorSuffix_24_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_23_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_24_Var
		);
		//24
		final AssignmentExpression AssignmentExpression_25_Var
		 = (AssignmentExpression)DeclaratorSuffix_24_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_25_Var
		);
		//25
		final ConditionalExpression ConditionalExpression_26_Var
		 = (ConditionalExpression)AssignmentExpression_25_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_26_Var
		);
		//26
		final LogicalOrExpression LogicalOrExpression_27_Var
		 = (LogicalOrExpression)ConditionalExpression_26_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = LogicalOrExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final LogicalAndExpression LogicalAndExpression_28_Var
		 = (LogicalAndExpression)Expr_27_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = LogicalAndExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final InclusiveOrExpression InclusiveOrExpression_29_Var
		 = (InclusiveOrExpression)Expr_28_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = InclusiveOrExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final ExclusiveOrExpression ExclusiveOrExpression_30_Var
		 = (ExclusiveOrExpression)Expr_29_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = ExclusiveOrExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final AndExpression AndExpression_31_Var
		 = (AndExpression)Expr_30_list.get(0);
		Assert.assertNotNull(AndExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = AndExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final EqualityExpression EqualityExpression_32_Var
		 = (EqualityExpression)Expr_31_list.get(0);
		Assert.assertNotNull(EqualityExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = EqualityExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final RelationalExpression RelationalExpression_33_Var
		 = (RelationalExpression)Expr_32_list.get(0);
		Assert.assertNotNull(RelationalExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = RelationalExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final ShiftExpression ShiftExpression_34_Var
		 = (ShiftExpression)Expr_33_list.get(0);
		Assert.assertNotNull(ShiftExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = ShiftExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final AdditiveExpression AdditiveExpression_35_Var
		 = (AdditiveExpression)Expr_34_list.get(0);
		Assert.assertNotNull(AdditiveExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = AdditiveExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final MultiplicativeExpression MultiplicativeExpression_36_Var
		 = (MultiplicativeExpression)Expr_35_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = MultiplicativeExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final CastExpression CastExpression_37_Var
		 = (CastExpression)Expr_36_list.get(0);
		Assert.assertNotNull(CastExpression_37_Var
		);
		//37
		final UnaryExpression UnaryExpression_38_Var
		 = (UnaryExpression)CastExpression_37_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_38_Var
		);
		//38
		final PostfixExpression PostfixExpression_39_Var
		 = (PostfixExpression)UnaryExpression_38_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = PostfixExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final PrimaryExpression PrimaryExpression_40_Var
		 = (PrimaryExpression)Expr_39_list.get(0);
		Assert.assertNotNull(PrimaryExpression_40_Var
		);
		//40
		final Constant2 Constant2_41_Var
		 = (Constant2)PrimaryExpression_40_Var
		.getConst();
		Assert.assertNotNull(Constant2_41_Var
		);
		Assert.assertEquals("250", Constant2_41_Var
		.getDec());
		final EList<? extends EObject> InitDeclaratorList_41_list = Declaration_4_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_41_list);
		Assert.assertEquals(1, InitDeclaratorList_41_list.size());
		//41
		final InitDeclaratorList InitDeclaratorList_42_Var
		 = (InitDeclaratorList)InitDeclaratorList_41_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_42_Var
		);
		final EList<? extends EObject> InitDeclarator_42_list = InitDeclaratorList_42_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_42_list);
		Assert.assertEquals(1, InitDeclarator_42_list.size());
		//42
		final InitDeclarator InitDeclarator_43_Var
		 = (InitDeclarator)InitDeclarator_42_list.get(0);
		Assert.assertNotNull(InitDeclarator_43_Var
		);
		//43
		final Declarator Declarator_44_Var
		 = (Declarator)InitDeclarator_43_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_44_Var
		);
		//44
		final DirectDeclarator DirectDeclarator_45_Var
		 = (DirectDeclarator)Declarator_44_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_45_Var
		);
		Assert.assertEquals("employee", DirectDeclarator_45_Var
		.getId());
		//45
		final ExternalDeclaration ExternalDeclaration_46_Var
		 = (ExternalDeclaration)External_2_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_46_Var
		);
		//46
		final Declaration Declaration_47_Var
		 = (Declaration)ExternalDeclaration_46_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_47_Var
		);
		//47
		final DeclarationSpecifiers DeclarationSpecifiers_48_Var
		 = (DeclarationSpecifiers)Declaration_47_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_48_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_48_list = DeclarationSpecifiers_48_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_48_list);
		Assert.assertEquals(1, DeclarationSpecifier_48_list.size());
		//48
		final StructOrUnionSpecifier StructOrUnionSpecifier_49_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_48_list.get(0);
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
		final EList<? extends EObject> InitDeclaratorList_50_list = Declaration_47_Var
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
		//91
		final Constant2 Constant2_92_Var
		 = (Constant2)PrimaryExpression_91_Var
		.getConst();
		Assert.assertNotNull(Constant2_92_Var
		);
		Assert.assertEquals("\"Joe Nobody\"", Constant2_92_Var
		.getStr());
		//92
		final ExternalDeclaration ExternalDeclaration_93_Var
		 = (ExternalDeclaration)External_2_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_93_Var
		);
		//93
		final Declaration Declaration_94_Var
		 = (Declaration)ExternalDeclaration_93_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_94_Var
		);
		//94
		final DeclarationSpecifiers DeclarationSpecifiers_95_Var
		 = (DeclarationSpecifiers)Declaration_94_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_95_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_95_list = DeclarationSpecifiers_95_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_95_list);
		Assert.assertEquals(1, DeclarationSpecifier_95_list.size());
		//95
		final TypeSpecifier TypeSpecifier_96_Var
		 = (TypeSpecifier)DeclarationSpecifier_95_list.get(0);
		Assert.assertNotNull(TypeSpecifier_96_Var
		);
		//96
		final TypedefName TypedefName_97_Var
		 = (TypedefName)TypeSpecifier_96_Var
		.getType();
		Assert.assertNotNull(TypedefName_97_Var
		);
		Assert.assertEquals("employee", TypedefName_97_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_97_list = Declaration_94_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_97_list);
		Assert.assertEquals(1, InitDeclaratorList_97_list.size());
		//97
		final InitDeclaratorList InitDeclaratorList_98_Var
		 = (InitDeclaratorList)InitDeclaratorList_97_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_98_Var
		);
		final EList<? extends EObject> InitDeclarator_98_list = InitDeclaratorList_98_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_98_list);
		Assert.assertEquals(1, InitDeclarator_98_list.size());
		//98
		final InitDeclarator InitDeclarator_99_Var
		 = (InitDeclarator)InitDeclarator_98_list.get(0);
		Assert.assertNotNull(InitDeclarator_99_Var
		);
		//99
		final Declarator Declarator_100_Var
		 = (Declarator)InitDeclarator_99_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_100_Var
		);
		//100
		final DirectDeclarator DirectDeclarator_101_Var
		 = (DirectDeclarator)Declarator_100_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_101_Var
		);
		Assert.assertEquals("phil", DirectDeclarator_101_Var
		.getId());
		//101
		final Initializer Initializer_102_Var
		 = (Initializer)InitDeclarator_99_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_102_Var
		);
		//102
		final InitializerList InitializerList_103_Var
		 = (InitializerList)Initializer_102_Var
		.getList();
		Assert.assertNotNull(InitializerList_103_Var
		);
		final EList<? extends EObject> Initializer_103_list = InitializerList_103_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_103_list);
		Assert.assertEquals(2, Initializer_103_list.size());
		//103
		final Initializer Initializer_104_Var
		 = (Initializer)Initializer_103_list.get(0);
		Assert.assertNotNull(Initializer_104_Var
		);
		//104
		final AssignmentExpression AssignmentExpression_105_Var
		 = (AssignmentExpression)Initializer_104_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_105_Var
		);
		//105
		final ConditionalExpression ConditionalExpression_106_Var
		 = (ConditionalExpression)AssignmentExpression_105_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_106_Var
		);
		//106
		final LogicalOrExpression LogicalOrExpression_107_Var
		 = (LogicalOrExpression)ConditionalExpression_106_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = LogicalOrExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final LogicalAndExpression LogicalAndExpression_108_Var
		 = (LogicalAndExpression)Expr_107_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = LogicalAndExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final InclusiveOrExpression InclusiveOrExpression_109_Var
		 = (InclusiveOrExpression)Expr_108_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = InclusiveOrExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final ExclusiveOrExpression ExclusiveOrExpression_110_Var
		 = (ExclusiveOrExpression)Expr_109_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = ExclusiveOrExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final AndExpression AndExpression_111_Var
		 = (AndExpression)Expr_110_list.get(0);
		Assert.assertNotNull(AndExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = AndExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final EqualityExpression EqualityExpression_112_Var
		 = (EqualityExpression)Expr_111_list.get(0);
		Assert.assertNotNull(EqualityExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = EqualityExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final RelationalExpression RelationalExpression_113_Var
		 = (RelationalExpression)Expr_112_list.get(0);
		Assert.assertNotNull(RelationalExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = RelationalExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final ShiftExpression ShiftExpression_114_Var
		 = (ShiftExpression)Expr_113_list.get(0);
		Assert.assertNotNull(ShiftExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = ShiftExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final AdditiveExpression AdditiveExpression_115_Var
		 = (AdditiveExpression)Expr_114_list.get(0);
		Assert.assertNotNull(AdditiveExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = AdditiveExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final MultiplicativeExpression MultiplicativeExpression_116_Var
		 = (MultiplicativeExpression)Expr_115_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = MultiplicativeExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final CastExpression CastExpression_117_Var
		 = (CastExpression)Expr_116_list.get(0);
		Assert.assertNotNull(CastExpression_117_Var
		);
		//117
		final UnaryExpression UnaryExpression_118_Var
		 = (UnaryExpression)CastExpression_117_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_118_Var
		);
		//118
		final PostfixExpression PostfixExpression_119_Var
		 = (PostfixExpression)UnaryExpression_118_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = PostfixExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final PrimaryExpression PrimaryExpression_120_Var
		 = (PrimaryExpression)Expr_119_list.get(0);
		Assert.assertNotNull(PrimaryExpression_120_Var
		);
		//120
		final Constant2 Constant2_121_Var
		 = (Constant2)PrimaryExpression_120_Var
		.getConst();
		Assert.assertNotNull(Constant2_121_Var
		);
		Assert.assertEquals("0x008", Constant2_121_Var
		.getHex());
		//121
		final Initializer Initializer_122_Var
		 = (Initializer)Initializer_103_list.get(1);
		Assert.assertNotNull(Initializer_122_Var
		);
		//122
		final AssignmentExpression AssignmentExpression_123_Var
		 = (AssignmentExpression)Initializer_122_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_123_Var
		);
		//123
		final ConditionalExpression ConditionalExpression_124_Var
		 = (ConditionalExpression)AssignmentExpression_123_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_124_Var
		);
		//124
		final LogicalOrExpression LogicalOrExpression_125_Var
		 = (LogicalOrExpression)ConditionalExpression_124_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = LogicalOrExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final LogicalAndExpression LogicalAndExpression_126_Var
		 = (LogicalAndExpression)Expr_125_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = LogicalAndExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final InclusiveOrExpression InclusiveOrExpression_127_Var
		 = (InclusiveOrExpression)Expr_126_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = InclusiveOrExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final ExclusiveOrExpression ExclusiveOrExpression_128_Var
		 = (ExclusiveOrExpression)Expr_127_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = ExclusiveOrExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final AndExpression AndExpression_129_Var
		 = (AndExpression)Expr_128_list.get(0);
		Assert.assertNotNull(AndExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = AndExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final EqualityExpression EqualityExpression_130_Var
		 = (EqualityExpression)Expr_129_list.get(0);
		Assert.assertNotNull(EqualityExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = EqualityExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final RelationalExpression RelationalExpression_131_Var
		 = (RelationalExpression)Expr_130_list.get(0);
		Assert.assertNotNull(RelationalExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = RelationalExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final ShiftExpression ShiftExpression_132_Var
		 = (ShiftExpression)Expr_131_list.get(0);
		Assert.assertNotNull(ShiftExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = ShiftExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final AdditiveExpression AdditiveExpression_133_Var
		 = (AdditiveExpression)Expr_132_list.get(0);
		Assert.assertNotNull(AdditiveExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = AdditiveExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final MultiplicativeExpression MultiplicativeExpression_134_Var
		 = (MultiplicativeExpression)Expr_133_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = MultiplicativeExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final CastExpression CastExpression_135_Var
		 = (CastExpression)Expr_134_list.get(0);
		Assert.assertNotNull(CastExpression_135_Var
		);
		//135
		final UnaryExpression UnaryExpression_136_Var
		 = (UnaryExpression)CastExpression_135_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_136_Var
		);
		//136
		final PostfixExpression PostfixExpression_137_Var
		 = (PostfixExpression)UnaryExpression_136_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = PostfixExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final PrimaryExpression PrimaryExpression_138_Var
		 = (PrimaryExpression)Expr_137_list.get(0);
		Assert.assertNotNull(PrimaryExpression_138_Var
		);
		//138
		final Constant2 Constant2_139_Var
		 = (Constant2)PrimaryExpression_138_Var
		.getConst();
		Assert.assertNotNull(Constant2_139_Var
		);
		Assert.assertEquals("\"Phil Morrison\"", Constant2_139_Var
		.getStr());
		//139
		final ExternalDeclaration ExternalDeclaration_140_Var
		 = (ExternalDeclaration)External_2_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_140_Var
		);
		//140
		final FunctionDefHead FunctionDefHead_141_Var
		 = (FunctionDefHead)ExternalDeclaration_140_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_141_Var
		);
		//141
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_142_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_141_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_142_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_142_list = FunctionDeclarationSpecifiers_142_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_142_list);
		Assert.assertEquals(1, DeclarationSpecifier_142_list.size());
		//142
		final TypeSpecifier TypeSpecifier_143_Var
		 = (TypeSpecifier)DeclarationSpecifier_142_list.get(0);
		Assert.assertNotNull(TypeSpecifier_143_Var
		);
		Assert.assertEquals("void", TypeSpecifier_143_Var
		.getName());
		//143
		final Declarator Declarator_144_Var
		 = (Declarator)FunctionDefHead_141_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_144_Var
		);
		//144
		final DirectDeclarator DirectDeclarator_145_Var
		 = (DirectDeclarator)Declarator_144_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_145_Var
		);
		Assert.assertEquals("print", DirectDeclarator_145_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_145_list = DirectDeclarator_145_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_145_list);
		Assert.assertEquals(1, DeclaratorSuffix_145_list.size());
		//145
		final DeclaratorSuffix DeclaratorSuffix_146_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_145_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_146_Var
		);
		//146
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_147_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_146_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_147_Var
		);
		final EList<? extends EObject> ParameterTypeList_147_list = DirectDeclaratorLastSuffix_147_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_147_list);
		Assert.assertEquals(1, ParameterTypeList_147_list.size());
		//147
		final ParameterTypeList ParameterTypeList_148_Var
		 = (ParameterTypeList)ParameterTypeList_147_list.get(0);
		Assert.assertNotNull(ParameterTypeList_148_Var
		);
		//148
		final ParameterList ParameterList_149_Var
		 = (ParameterList)ParameterTypeList_148_Var
		.getList();
		Assert.assertNotNull(ParameterList_149_Var
		);
		final EList<? extends EObject> ParameterDeclaration_149_list = ParameterList_149_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_149_list);
		Assert.assertEquals(1, ParameterDeclaration_149_list.size());
		//149
		final ParameterDeclaration ParameterDeclaration_150_Var
		 = (ParameterDeclaration)ParameterDeclaration_149_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_150_Var
		);
		//150
		final DeclarationSpecifiers DeclarationSpecifiers_151_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_150_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_151_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_151_list = DeclarationSpecifiers_151_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_151_list);
		Assert.assertEquals(1, DeclarationSpecifier_151_list.size());
		//151
		final TypeSpecifier TypeSpecifier_152_Var
		 = (TypeSpecifier)DeclarationSpecifier_151_list.get(0);
		Assert.assertNotNull(TypeSpecifier_152_Var
		);
		//152
		final TypedefName TypedefName_153_Var
		 = (TypedefName)TypeSpecifier_152_Var
		.getType();
		Assert.assertNotNull(TypedefName_153_Var
		);
		Assert.assertEquals("employee", TypedefName_153_Var
		.getId());
		//153
		final Declarator Declarator_154_Var
		 = (Declarator)ParameterDeclaration_150_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_154_Var
		);
		//154
		final DirectDeclarator DirectDeclarator_155_Var
		 = (DirectDeclarator)Declarator_154_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_155_Var
		);
		Assert.assertEquals("emp", DirectDeclarator_155_Var
		.getId());
		//155
		final Pointer Pointer_156_Var
		 = (Pointer)Declarator_154_Var
		.getPointer();
		Assert.assertNotNull(Pointer_156_Var
		);
		Assert.assertEquals("[*]", Pointer_156_Var
		.getStar().toString());
		//156
		final FunctionDefinition FunctionDefinition_157_Var
		 = (FunctionDefinition)ExternalDeclaration_140_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_157_Var
		);
		//157
		final BodyStatement BodyStatement_158_Var
		 = (BodyStatement)FunctionDefinition_157_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_158_Var
		);
		final EList<? extends EObject> BlockList_158_list = BodyStatement_158_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_158_list);
		Assert.assertEquals(1, BlockList_158_list.size());
		//158
		final BlockList BlockList_159_Var
		 = (BlockList)BlockList_158_list.get(0);
		Assert.assertNotNull(BlockList_159_Var
		);
		final EList<? extends EObject> Statement_159_list = BlockList_159_Var
		.getStatement();
		Assert.assertNotNull(Statement_159_list);
		Assert.assertEquals(2, Statement_159_list.size());
		//159
		final Statement Statement_160_Var
		 = (Statement)Statement_159_list.get(0);
		Assert.assertNotNull(Statement_160_Var
		);
		//160
		final ExpressionStatement ExpressionStatement_161_Var
		 = (ExpressionStatement)Statement_160_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_161_Var
		);
		//161
		final Expression Expression_162_Var
		 = (Expression)ExpressionStatement_161_Var
		.getExpression();
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
		Assert.assertEquals("printf", PrimaryExpression_178_Var
		.getId());
		final EList<? extends EObject> Suffix_178_list = PostfixExpression_177_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_178_list);
		Assert.assertEquals(1, Suffix_178_list.size());
		//178
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_179_Var
		 = (PostfixExpressionSuffixArgument)Suffix_178_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_179_Var
		);
		//179
		final ArgumentExpressionList ArgumentExpressionList_180_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_179_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_180_Var
		);
		final EList<? extends EObject> Expr_180_list = ArgumentExpressionList_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(2, Expr_180_list.size());
		//180
		final AssignmentExpression AssignmentExpression_181_Var
		 = (AssignmentExpression)Expr_180_list.get(0);
		Assert.assertNotNull(AssignmentExpression_181_Var
		);
		//181
		final ConditionalExpression ConditionalExpression_182_Var
		 = (ConditionalExpression)AssignmentExpression_181_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_182_Var
		);
		//182
		final LogicalOrExpression LogicalOrExpression_183_Var
		 = (LogicalOrExpression)ConditionalExpression_182_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = LogicalOrExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final LogicalAndExpression LogicalAndExpression_184_Var
		 = (LogicalAndExpression)Expr_183_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = LogicalAndExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final InclusiveOrExpression InclusiveOrExpression_185_Var
		 = (InclusiveOrExpression)Expr_184_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_185_Var
		);
		final EList<? extends EObject> Expr_185_list = InclusiveOrExpression_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final ExclusiveOrExpression ExclusiveOrExpression_186_Var
		 = (ExclusiveOrExpression)Expr_185_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_186_Var
		);
		final EList<? extends EObject> Expr_186_list = ExclusiveOrExpression_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(1, Expr_186_list.size());
		//186
		final AndExpression AndExpression_187_Var
		 = (AndExpression)Expr_186_list.get(0);
		Assert.assertNotNull(AndExpression_187_Var
		);
		final EList<? extends EObject> Expr_187_list = AndExpression_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(1, Expr_187_list.size());
		//187
		final EqualityExpression EqualityExpression_188_Var
		 = (EqualityExpression)Expr_187_list.get(0);
		Assert.assertNotNull(EqualityExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = EqualityExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final RelationalExpression RelationalExpression_189_Var
		 = (RelationalExpression)Expr_188_list.get(0);
		Assert.assertNotNull(RelationalExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = RelationalExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final ShiftExpression ShiftExpression_190_Var
		 = (ShiftExpression)Expr_189_list.get(0);
		Assert.assertNotNull(ShiftExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = ShiftExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final AdditiveExpression AdditiveExpression_191_Var
		 = (AdditiveExpression)Expr_190_list.get(0);
		Assert.assertNotNull(AdditiveExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = AdditiveExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final MultiplicativeExpression MultiplicativeExpression_192_Var
		 = (MultiplicativeExpression)Expr_191_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = MultiplicativeExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final CastExpression CastExpression_193_Var
		 = (CastExpression)Expr_192_list.get(0);
		Assert.assertNotNull(CastExpression_193_Var
		);
		//193
		final UnaryExpression UnaryExpression_194_Var
		 = (UnaryExpression)CastExpression_193_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_194_Var
		);
		//194
		final PostfixExpression PostfixExpression_195_Var
		 = (PostfixExpression)UnaryExpression_194_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = PostfixExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final PrimaryExpression PrimaryExpression_196_Var
		 = (PrimaryExpression)Expr_195_list.get(0);
		Assert.assertNotNull(PrimaryExpression_196_Var
		);
		//196
		final Constant2 Constant2_197_Var
		 = (Constant2)PrimaryExpression_196_Var
		.getConst();
		Assert.assertNotNull(Constant2_197_Var
		);
		Assert.assertEquals("\"(*employee).id=%d\\n\"", Constant2_197_Var
		.getStr());
		//197
		final AssignmentExpression AssignmentExpression_198_Var
		 = (AssignmentExpression)Expr_180_list.get(1);
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
		//213
		final Expression Expression_214_Var
		 = (Expression)PrimaryExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expression_214_Var
		);
		final EList<? extends EObject> ExprExpr_214_list = Expression_214_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_214_list);
		Assert.assertEquals(1, ExprExpr_214_list.size());
		//214
		final AssignmentExpression AssignmentExpression_215_Var
		 = (AssignmentExpression)ExprExpr_214_list.get(0);
		Assert.assertNotNull(AssignmentExpression_215_Var
		);
		//215
		final ConditionalExpression ConditionalExpression_216_Var
		 = (ConditionalExpression)AssignmentExpression_215_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_216_Var
		);
		//216
		final LogicalOrExpression LogicalOrExpression_217_Var
		 = (LogicalOrExpression)ConditionalExpression_216_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = LogicalOrExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final LogicalAndExpression LogicalAndExpression_218_Var
		 = (LogicalAndExpression)Expr_217_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = LogicalAndExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final InclusiveOrExpression InclusiveOrExpression_219_Var
		 = (InclusiveOrExpression)Expr_218_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = InclusiveOrExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final ExclusiveOrExpression ExclusiveOrExpression_220_Var
		 = (ExclusiveOrExpression)Expr_219_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = ExclusiveOrExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final AndExpression AndExpression_221_Var
		 = (AndExpression)Expr_220_list.get(0);
		Assert.assertNotNull(AndExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = AndExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final EqualityExpression EqualityExpression_222_Var
		 = (EqualityExpression)Expr_221_list.get(0);
		Assert.assertNotNull(EqualityExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = EqualityExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final RelationalExpression RelationalExpression_223_Var
		 = (RelationalExpression)Expr_222_list.get(0);
		Assert.assertNotNull(RelationalExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = RelationalExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final ShiftExpression ShiftExpression_224_Var
		 = (ShiftExpression)Expr_223_list.get(0);
		Assert.assertNotNull(ShiftExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = ShiftExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final AdditiveExpression AdditiveExpression_225_Var
		 = (AdditiveExpression)Expr_224_list.get(0);
		Assert.assertNotNull(AdditiveExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = AdditiveExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final MultiplicativeExpression MultiplicativeExpression_226_Var
		 = (MultiplicativeExpression)Expr_225_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = MultiplicativeExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final CastExpression CastExpression_227_Var
		 = (CastExpression)Expr_226_list.get(0);
		Assert.assertNotNull(CastExpression_227_Var
		);
		//227
		final UnaryExpression UnaryExpression_228_Var
		 = (UnaryExpression)CastExpression_227_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_228_Var
		);
		//228
		final UnaryOperator UnaryOperator_229_Var
		 = (UnaryOperator)UnaryExpression_228_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_229_Var
		);
		Assert.assertEquals("*", UnaryOperator_229_Var
		.getOp());
		//229
		final CastExpression CastExpression_230_Var
		 = (CastExpression)UnaryExpression_228_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_230_Var
		);
		//230
		final UnaryExpression UnaryExpression_231_Var
		 = (UnaryExpression)CastExpression_230_Var
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
		Assert.assertEquals("emp", PrimaryExpression_233_Var
		.getId());
		final EList<? extends EObject> Suffix_233_list = PostfixExpression_212_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_233_list);
		Assert.assertEquals(1, Suffix_233_list.size());
		//233
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_234_Var
		 = (PostfixExpressionSuffixDot)Suffix_233_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_234_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_234_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_161_Var
		.getSemi());
		//234
		final Statement Statement_235_Var
		 = (Statement)Statement_159_list.get(1);
		Assert.assertNotNull(Statement_235_Var
		);
		//235
		final ExpressionStatement ExpressionStatement_236_Var
		 = (ExpressionStatement)Statement_235_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_236_Var
		);
		//236
		final Expression Expression_237_Var
		 = (Expression)ExpressionStatement_236_Var
		.getExpression();
		Assert.assertNotNull(Expression_237_Var
		);
		final EList<? extends EObject> ExprExpr_237_list = Expression_237_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_237_list);
		Assert.assertEquals(1, ExprExpr_237_list.size());
		//237
		final AssignmentExpression AssignmentExpression_238_Var
		 = (AssignmentExpression)ExprExpr_237_list.get(0);
		Assert.assertNotNull(AssignmentExpression_238_Var
		);
		//238
		final ConditionalExpression ConditionalExpression_239_Var
		 = (ConditionalExpression)AssignmentExpression_238_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_239_Var
		);
		//239
		final LogicalOrExpression LogicalOrExpression_240_Var
		 = (LogicalOrExpression)ConditionalExpression_239_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = LogicalOrExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final LogicalAndExpression LogicalAndExpression_241_Var
		 = (LogicalAndExpression)Expr_240_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = LogicalAndExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final InclusiveOrExpression InclusiveOrExpression_242_Var
		 = (InclusiveOrExpression)Expr_241_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = InclusiveOrExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final ExclusiveOrExpression ExclusiveOrExpression_243_Var
		 = (ExclusiveOrExpression)Expr_242_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = ExclusiveOrExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final AndExpression AndExpression_244_Var
		 = (AndExpression)Expr_243_list.get(0);
		Assert.assertNotNull(AndExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = AndExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final EqualityExpression EqualityExpression_245_Var
		 = (EqualityExpression)Expr_244_list.get(0);
		Assert.assertNotNull(EqualityExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = EqualityExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final RelationalExpression RelationalExpression_246_Var
		 = (RelationalExpression)Expr_245_list.get(0);
		Assert.assertNotNull(RelationalExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = RelationalExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final ShiftExpression ShiftExpression_247_Var
		 = (ShiftExpression)Expr_246_list.get(0);
		Assert.assertNotNull(ShiftExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = ShiftExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final AdditiveExpression AdditiveExpression_248_Var
		 = (AdditiveExpression)Expr_247_list.get(0);
		Assert.assertNotNull(AdditiveExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = AdditiveExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final MultiplicativeExpression MultiplicativeExpression_249_Var
		 = (MultiplicativeExpression)Expr_248_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = MultiplicativeExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final CastExpression CastExpression_250_Var
		 = (CastExpression)Expr_249_list.get(0);
		Assert.assertNotNull(CastExpression_250_Var
		);
		//250
		final UnaryExpression UnaryExpression_251_Var
		 = (UnaryExpression)CastExpression_250_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_251_Var
		);
		//251
		final PostfixExpression PostfixExpression_252_Var
		 = (PostfixExpression)UnaryExpression_251_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_252_Var
		);
		final EList<? extends EObject> Expr_252_list = PostfixExpression_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(1, Expr_252_list.size());
		//252
		final PrimaryExpression PrimaryExpression_253_Var
		 = (PrimaryExpression)Expr_252_list.get(0);
		Assert.assertNotNull(PrimaryExpression_253_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_253_Var
		.getId());
		final EList<? extends EObject> Suffix_253_list = PostfixExpression_252_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_253_list);
		Assert.assertEquals(1, Suffix_253_list.size());
		//253
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_254_Var
		 = (PostfixExpressionSuffixArgument)Suffix_253_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_254_Var
		);
		//254
		final ArgumentExpressionList ArgumentExpressionList_255_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_254_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_255_Var
		);
		final EList<? extends EObject> Expr_255_list = ArgumentExpressionList_255_Var
		.getExpr();
		Assert.assertNotNull(Expr_255_list);
		Assert.assertEquals(2, Expr_255_list.size());
		//255
		final AssignmentExpression AssignmentExpression_256_Var
		 = (AssignmentExpression)Expr_255_list.get(0);
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
		//271
		final Constant2 Constant2_272_Var
		 = (Constant2)PrimaryExpression_271_Var
		.getConst();
		Assert.assertNotNull(Constant2_272_Var
		);
		Assert.assertEquals("\"employee->name=%s\\n\"", Constant2_272_Var
		.getStr());
		//272
		final AssignmentExpression AssignmentExpression_273_Var
		 = (AssignmentExpression)Expr_255_list.get(1);
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
		Assert.assertEquals("emp", PrimaryExpression_288_Var
		.getId());
		final EList<? extends EObject> Suffix_288_list = PostfixExpression_287_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_288_list);
		Assert.assertEquals(1, Suffix_288_list.size());
		//288
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_289_Var
		 = (PostfixExpressionSuffixArrow)Suffix_288_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArrow_289_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixArrow_289_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_236_Var
		.getSemi());
		//289
		final ExternalDeclaration ExternalDeclaration_290_Var
		 = (ExternalDeclaration)External_2_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_290_Var
		);
		//290
		final FunctionDefHead FunctionDefHead_291_Var
		 = (FunctionDefHead)ExternalDeclaration_290_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_291_Var
		);
		//291
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_292_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_291_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_292_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_292_list = FunctionDeclarationSpecifiers_292_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_292_list);
		Assert.assertEquals(1, DeclarationSpecifier_292_list.size());
		//292
		final TypeSpecifier TypeSpecifier_293_Var
		 = (TypeSpecifier)DeclarationSpecifier_292_list.get(0);
		Assert.assertNotNull(TypeSpecifier_293_Var
		);
		Assert.assertEquals("int", TypeSpecifier_293_Var
		.getName());
		//293
		final Declarator Declarator_294_Var
		 = (Declarator)FunctionDefHead_291_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_294_Var
		);
		//294
		final DirectDeclarator DirectDeclarator_295_Var
		 = (DirectDeclarator)Declarator_294_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_295_Var
		);
		Assert.assertEquals("main", DirectDeclarator_295_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_295_list = DirectDeclarator_295_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_295_list);
		Assert.assertEquals(1, DeclaratorSuffix_295_list.size());
		//295
		final DeclaratorSuffix DeclaratorSuffix_296_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_295_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_296_Var
		);
		//296
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_297_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_296_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_297_Var
		);
		final EList<? extends EObject> ParameterTypeList_297_list = DirectDeclaratorLastSuffix_297_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_297_list);
		Assert.assertEquals(1, ParameterTypeList_297_list.size());
		//297
		final ParameterTypeList ParameterTypeList_298_Var
		 = (ParameterTypeList)ParameterTypeList_297_list.get(0);
		Assert.assertNotNull(ParameterTypeList_298_Var
		);
		//298
		final ParameterList ParameterList_299_Var
		 = (ParameterList)ParameterTypeList_298_Var
		.getList();
		Assert.assertNotNull(ParameterList_299_Var
		);
		final EList<? extends EObject> ParameterDeclaration_299_list = ParameterList_299_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_299_list);
		Assert.assertEquals(1, ParameterDeclaration_299_list.size());
		//299
		final ParameterDeclaration ParameterDeclaration_300_Var
		 = (ParameterDeclaration)ParameterDeclaration_299_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_300_Var
		);
		//300
		final DeclarationSpecifiers DeclarationSpecifiers_301_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_300_Var
		.getDeclSpecifiers();
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
		Assert.assertEquals("void", TypeSpecifier_302_Var
		.getName());
		//302
		final FunctionDefinition FunctionDefinition_303_Var
		 = (FunctionDefinition)ExternalDeclaration_290_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_303_Var
		);
		//303
		final BodyStatement BodyStatement_304_Var
		 = (BodyStatement)FunctionDefinition_303_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_304_Var
		);
		final EList<? extends EObject> BlockList_304_list = BodyStatement_304_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_304_list);
		Assert.assertEquals(1, BlockList_304_list.size());
		//304
		final BlockList BlockList_305_Var
		 = (BlockList)BlockList_304_list.get(0);
		Assert.assertNotNull(BlockList_305_Var
		);
		final EList<? extends EObject> Declaration_305_list = BlockList_305_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_305_list);
		Assert.assertEquals(1, Declaration_305_list.size());
		//305
		final Declaration Declaration_306_Var
		 = (Declaration)Declaration_305_list.get(0);
		Assert.assertNotNull(Declaration_306_Var
		);
		//306
		final DeclarationSpecifiers DeclarationSpecifiers_307_Var
		 = (DeclarationSpecifiers)Declaration_306_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_307_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_307_list = DeclarationSpecifiers_307_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_307_list);
		Assert.assertEquals(1, DeclarationSpecifier_307_list.size());
		//307
		final TypeSpecifier TypeSpecifier_308_Var
		 = (TypeSpecifier)DeclarationSpecifier_307_list.get(0);
		Assert.assertNotNull(TypeSpecifier_308_Var
		);
		//308
		final TypedefName TypedefName_309_Var
		 = (TypedefName)TypeSpecifier_308_Var
		.getType();
		Assert.assertNotNull(TypedefName_309_Var
		);
		Assert.assertEquals("employee", TypedefName_309_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_309_list = Declaration_306_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_309_list);
		Assert.assertEquals(1, InitDeclaratorList_309_list.size());
		//309
		final InitDeclaratorList InitDeclaratorList_310_Var
		 = (InitDeclaratorList)InitDeclaratorList_309_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_310_Var
		);
		final EList<? extends EObject> InitDeclarator_310_list = InitDeclaratorList_310_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_310_list);
		Assert.assertEquals(1, InitDeclarator_310_list.size());
		//310
		final InitDeclarator InitDeclarator_311_Var
		 = (InitDeclarator)InitDeclarator_310_list.get(0);
		Assert.assertNotNull(InitDeclarator_311_Var
		);
		//311
		final Declarator Declarator_312_Var
		 = (Declarator)InitDeclarator_311_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_312_Var
		);
		//312
		final Pointer Pointer_313_Var
		 = (Pointer)Declarator_312_Var
		.getPointer();
		Assert.assertNotNull(Pointer_313_Var
		);
		Assert.assertEquals("[*]", Pointer_313_Var
		.getStar().toString());
		//313
		final DirectDeclarator DirectDeclarator_314_Var
		 = (DirectDeclarator)Declarator_312_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_314_Var
		);
		Assert.assertEquals("newEmployee", DirectDeclarator_314_Var
		.getId());
		//314
		final Initializer Initializer_315_Var
		 = (Initializer)InitDeclarator_311_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_315_Var
		);
		//315
		final AssignmentExpression AssignmentExpression_316_Var
		 = (AssignmentExpression)Initializer_315_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_316_Var
		);
		//316
		final ConditionalExpression ConditionalExpression_317_Var
		 = (ConditionalExpression)AssignmentExpression_316_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_317_Var
		);
		//317
		final LogicalOrExpression LogicalOrExpression_318_Var
		 = (LogicalOrExpression)ConditionalExpression_317_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_318_Var
		);
		final EList<? extends EObject> Expr_318_list = LogicalOrExpression_318_Var
		.getExpr();
		Assert.assertNotNull(Expr_318_list);
		Assert.assertEquals(1, Expr_318_list.size());
		//318
		final LogicalAndExpression LogicalAndExpression_319_Var
		 = (LogicalAndExpression)Expr_318_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_319_Var
		);
		final EList<? extends EObject> Expr_319_list = LogicalAndExpression_319_Var
		.getExpr();
		Assert.assertNotNull(Expr_319_list);
		Assert.assertEquals(1, Expr_319_list.size());
		//319
		final InclusiveOrExpression InclusiveOrExpression_320_Var
		 = (InclusiveOrExpression)Expr_319_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_320_Var
		);
		final EList<? extends EObject> Expr_320_list = InclusiveOrExpression_320_Var
		.getExpr();
		Assert.assertNotNull(Expr_320_list);
		Assert.assertEquals(1, Expr_320_list.size());
		//320
		final ExclusiveOrExpression ExclusiveOrExpression_321_Var
		 = (ExclusiveOrExpression)Expr_320_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_321_Var
		);
		final EList<? extends EObject> Expr_321_list = ExclusiveOrExpression_321_Var
		.getExpr();
		Assert.assertNotNull(Expr_321_list);
		Assert.assertEquals(1, Expr_321_list.size());
		//321
		final AndExpression AndExpression_322_Var
		 = (AndExpression)Expr_321_list.get(0);
		Assert.assertNotNull(AndExpression_322_Var
		);
		final EList<? extends EObject> Expr_322_list = AndExpression_322_Var
		.getExpr();
		Assert.assertNotNull(Expr_322_list);
		Assert.assertEquals(1, Expr_322_list.size());
		//322
		final EqualityExpression EqualityExpression_323_Var
		 = (EqualityExpression)Expr_322_list.get(0);
		Assert.assertNotNull(EqualityExpression_323_Var
		);
		final EList<? extends EObject> Expr_323_list = EqualityExpression_323_Var
		.getExpr();
		Assert.assertNotNull(Expr_323_list);
		Assert.assertEquals(1, Expr_323_list.size());
		//323
		final RelationalExpression RelationalExpression_324_Var
		 = (RelationalExpression)Expr_323_list.get(0);
		Assert.assertNotNull(RelationalExpression_324_Var
		);
		final EList<? extends EObject> Expr_324_list = RelationalExpression_324_Var
		.getExpr();
		Assert.assertNotNull(Expr_324_list);
		Assert.assertEquals(1, Expr_324_list.size());
		//324
		final ShiftExpression ShiftExpression_325_Var
		 = (ShiftExpression)Expr_324_list.get(0);
		Assert.assertNotNull(ShiftExpression_325_Var
		);
		final EList<? extends EObject> Expr_325_list = ShiftExpression_325_Var
		.getExpr();
		Assert.assertNotNull(Expr_325_list);
		Assert.assertEquals(1, Expr_325_list.size());
		//325
		final AdditiveExpression AdditiveExpression_326_Var
		 = (AdditiveExpression)Expr_325_list.get(0);
		Assert.assertNotNull(AdditiveExpression_326_Var
		);
		final EList<? extends EObject> Expr_326_list = AdditiveExpression_326_Var
		.getExpr();
		Assert.assertNotNull(Expr_326_list);
		Assert.assertEquals(1, Expr_326_list.size());
		//326
		final MultiplicativeExpression MultiplicativeExpression_327_Var
		 = (MultiplicativeExpression)Expr_326_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_327_Var
		);
		final EList<? extends EObject> Expr_327_list = MultiplicativeExpression_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final CastExpression CastExpression_328_Var
		 = (CastExpression)Expr_327_list.get(0);
		Assert.assertNotNull(CastExpression_328_Var
		);
		//328
		final UnaryExpression UnaryExpression_329_Var
		 = (UnaryExpression)CastExpression_328_Var
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
		Assert.assertEquals("malloc", PrimaryExpression_331_Var
		.getId());
		final EList<? extends EObject> Suffix_331_list = PostfixExpression_330_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_331_list);
		Assert.assertEquals(1, Suffix_331_list.size());
		//331
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_332_Var
		 = (PostfixExpressionSuffixArgument)Suffix_331_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_332_Var
		);
		//332
		final ArgumentExpressionList ArgumentExpressionList_333_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_332_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_333_Var
		);
		final EList<? extends EObject> Expr_333_list = ArgumentExpressionList_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final AssignmentExpression AssignmentExpression_334_Var
		 = (AssignmentExpression)Expr_333_list.get(0);
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
		Assert.assertEquals("sizeof", UnaryExpression_347_Var
		.getSizeOf());
		//347
		final TypeName TypeName_348_Var
		 = (TypeName)UnaryExpression_347_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_348_Var
		);
		//348
		final SpecifierQualifierList SpecifierQualifierList_349_Var
		 = (SpecifierQualifierList)TypeName_348_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_349_Var
		);
		final EList<? extends EObject> TypeSpecifier_349_list = SpecifierQualifierList_349_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_349_list);
		Assert.assertEquals(1, TypeSpecifier_349_list.size());
		//349
		final TypeSpecifier TypeSpecifier_350_Var
		 = (TypeSpecifier)TypeSpecifier_349_list.get(0);
		Assert.assertNotNull(TypeSpecifier_350_Var
		);
		//350
		final TypedefName TypedefName_351_Var
		 = (TypedefName)TypeSpecifier_350_Var
		.getType();
		Assert.assertNotNull(TypedefName_351_Var
		);
		Assert.assertEquals("employee", TypedefName_351_Var
		.getId());
		final EList<? extends EObject> Statement_351_list = BlockList_305_Var
		.getStatement();
		Assert.assertNotNull(Statement_351_list);
		Assert.assertEquals(8, Statement_351_list.size());
		//351
		final Statement Statement_352_Var
		 = (Statement)Statement_351_list.get(0);
		Assert.assertNotNull(Statement_352_Var
		);
		//352
		final SelectionStatement SelectionStatement_353_Var
		 = (SelectionStatement)Statement_352_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_353_Var
		);
		Assert.assertEquals("if", SelectionStatement_353_Var
		.getIf());
		//353
		final Expression Expression_354_Var
		 = (Expression)SelectionStatement_353_Var
		.getExpr();
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
		Assert.assertEquals("[==]", EqualityExpression_362_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_362_list = EqualityExpression_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(2, Expr_362_list.size());
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
		Assert.assertEquals("newEmployee", PrimaryExpression_370_Var
		.getId());
		//370
		final RelationalExpression RelationalExpression_371_Var
		 = (RelationalExpression)Expr_362_list.get(1);
		Assert.assertNotNull(RelationalExpression_371_Var
		);
		final EList<? extends EObject> Expr_371_list = RelationalExpression_371_Var
		.getExpr();
		Assert.assertNotNull(Expr_371_list);
		Assert.assertEquals(1, Expr_371_list.size());
		//371
		final ShiftExpression ShiftExpression_372_Var
		 = (ShiftExpression)Expr_371_list.get(0);
		Assert.assertNotNull(ShiftExpression_372_Var
		);
		final EList<? extends EObject> Expr_372_list = ShiftExpression_372_Var
		.getExpr();
		Assert.assertNotNull(Expr_372_list);
		Assert.assertEquals(1, Expr_372_list.size());
		//372
		final AdditiveExpression AdditiveExpression_373_Var
		 = (AdditiveExpression)Expr_372_list.get(0);
		Assert.assertNotNull(AdditiveExpression_373_Var
		);
		final EList<? extends EObject> Expr_373_list = AdditiveExpression_373_Var
		.getExpr();
		Assert.assertNotNull(Expr_373_list);
		Assert.assertEquals(1, Expr_373_list.size());
		//373
		final MultiplicativeExpression MultiplicativeExpression_374_Var
		 = (MultiplicativeExpression)Expr_373_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_374_Var
		);
		final EList<? extends EObject> Expr_374_list = MultiplicativeExpression_374_Var
		.getExpr();
		Assert.assertNotNull(Expr_374_list);
		Assert.assertEquals(1, Expr_374_list.size());
		//374
		final CastExpression CastExpression_375_Var
		 = (CastExpression)Expr_374_list.get(0);
		Assert.assertNotNull(CastExpression_375_Var
		);
		//375
		final UnaryExpression UnaryExpression_376_Var
		 = (UnaryExpression)CastExpression_375_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_376_Var
		);
		//376
		final PostfixExpression PostfixExpression_377_Var
		 = (PostfixExpression)UnaryExpression_376_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_377_Var
		);
		final EList<? extends EObject> Expr_377_list = PostfixExpression_377_Var
		.getExpr();
		Assert.assertNotNull(Expr_377_list);
		Assert.assertEquals(1, Expr_377_list.size());
		//377
		final PrimaryExpression PrimaryExpression_378_Var
		 = (PrimaryExpression)Expr_377_list.get(0);
		Assert.assertNotNull(PrimaryExpression_378_Var
		);
		Assert.assertEquals("NULL", PrimaryExpression_378_Var
		.getId());
		//378
		final Statement Statement_379_Var
		 = (Statement)SelectionStatement_353_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_379_Var
		);
		//379
		final CompoundStatement CompoundStatement_380_Var
		 = (CompoundStatement)Statement_379_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_380_Var
		);
		//380
		final BodyStatement BodyStatement_381_Var
		 = (BodyStatement)CompoundStatement_380_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_381_Var
		);
		final EList<? extends EObject> BlockList_381_list = BodyStatement_381_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_381_list);
		Assert.assertEquals(1, BlockList_381_list.size());
		//381
		final BlockList BlockList_382_Var
		 = (BlockList)BlockList_381_list.get(0);
		Assert.assertNotNull(BlockList_382_Var
		);
		final EList<? extends EObject> Statement_382_list = BlockList_382_Var
		.getStatement();
		Assert.assertNotNull(Statement_382_list);
		Assert.assertEquals(2, Statement_382_list.size());
		//382
		final Statement Statement_383_Var
		 = (Statement)Statement_382_list.get(0);
		Assert.assertNotNull(Statement_383_Var
		);
		//383
		final ExpressionStatement ExpressionStatement_384_Var
		 = (ExpressionStatement)Statement_383_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_384_Var
		);
		//384
		final Expression Expression_385_Var
		 = (Expression)ExpressionStatement_384_Var
		.getExpression();
		Assert.assertNotNull(Expression_385_Var
		);
		final EList<? extends EObject> ExprExpr_385_list = Expression_385_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_385_list);
		Assert.assertEquals(1, ExprExpr_385_list.size());
		//385
		final AssignmentExpression AssignmentExpression_386_Var
		 = (AssignmentExpression)ExprExpr_385_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_401_Var
		.getId());
		final EList<? extends EObject> Suffix_401_list = PostfixExpression_400_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_401_list);
		Assert.assertEquals(1, Suffix_401_list.size());
		//401
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_402_Var
		 = (PostfixExpressionSuffixArgument)Suffix_401_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_402_Var
		);
		//402
		final ArgumentExpressionList ArgumentExpressionList_403_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_402_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_403_Var
		);
		final EList<? extends EObject> Expr_403_list = ArgumentExpressionList_403_Var
		.getExpr();
		Assert.assertNotNull(Expr_403_list);
		Assert.assertEquals(1, Expr_403_list.size());
		//403
		final AssignmentExpression AssignmentExpression_404_Var
		 = (AssignmentExpression)Expr_403_list.get(0);
		Assert.assertNotNull(AssignmentExpression_404_Var
		);
		//404
		final ConditionalExpression ConditionalExpression_405_Var
		 = (ConditionalExpression)AssignmentExpression_404_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_405_Var
		);
		//405
		final LogicalOrExpression LogicalOrExpression_406_Var
		 = (LogicalOrExpression)ConditionalExpression_405_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_406_Var
		);
		final EList<? extends EObject> Expr_406_list = LogicalOrExpression_406_Var
		.getExpr();
		Assert.assertNotNull(Expr_406_list);
		Assert.assertEquals(1, Expr_406_list.size());
		//406
		final LogicalAndExpression LogicalAndExpression_407_Var
		 = (LogicalAndExpression)Expr_406_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_407_Var
		);
		final EList<? extends EObject> Expr_407_list = LogicalAndExpression_407_Var
		.getExpr();
		Assert.assertNotNull(Expr_407_list);
		Assert.assertEquals(1, Expr_407_list.size());
		//407
		final InclusiveOrExpression InclusiveOrExpression_408_Var
		 = (InclusiveOrExpression)Expr_407_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_408_Var
		);
		final EList<? extends EObject> Expr_408_list = InclusiveOrExpression_408_Var
		.getExpr();
		Assert.assertNotNull(Expr_408_list);
		Assert.assertEquals(1, Expr_408_list.size());
		//408
		final ExclusiveOrExpression ExclusiveOrExpression_409_Var
		 = (ExclusiveOrExpression)Expr_408_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_409_Var
		);
		final EList<? extends EObject> Expr_409_list = ExclusiveOrExpression_409_Var
		.getExpr();
		Assert.assertNotNull(Expr_409_list);
		Assert.assertEquals(1, Expr_409_list.size());
		//409
		final AndExpression AndExpression_410_Var
		 = (AndExpression)Expr_409_list.get(0);
		Assert.assertNotNull(AndExpression_410_Var
		);
		final EList<? extends EObject> Expr_410_list = AndExpression_410_Var
		.getExpr();
		Assert.assertNotNull(Expr_410_list);
		Assert.assertEquals(1, Expr_410_list.size());
		//410
		final EqualityExpression EqualityExpression_411_Var
		 = (EqualityExpression)Expr_410_list.get(0);
		Assert.assertNotNull(EqualityExpression_411_Var
		);
		final EList<? extends EObject> Expr_411_list = EqualityExpression_411_Var
		.getExpr();
		Assert.assertNotNull(Expr_411_list);
		Assert.assertEquals(1, Expr_411_list.size());
		//411
		final RelationalExpression RelationalExpression_412_Var
		 = (RelationalExpression)Expr_411_list.get(0);
		Assert.assertNotNull(RelationalExpression_412_Var
		);
		final EList<? extends EObject> Expr_412_list = RelationalExpression_412_Var
		.getExpr();
		Assert.assertNotNull(Expr_412_list);
		Assert.assertEquals(1, Expr_412_list.size());
		//412
		final ShiftExpression ShiftExpression_413_Var
		 = (ShiftExpression)Expr_412_list.get(0);
		Assert.assertNotNull(ShiftExpression_413_Var
		);
		final EList<? extends EObject> Expr_413_list = ShiftExpression_413_Var
		.getExpr();
		Assert.assertNotNull(Expr_413_list);
		Assert.assertEquals(1, Expr_413_list.size());
		//413
		final AdditiveExpression AdditiveExpression_414_Var
		 = (AdditiveExpression)Expr_413_list.get(0);
		Assert.assertNotNull(AdditiveExpression_414_Var
		);
		final EList<? extends EObject> Expr_414_list = AdditiveExpression_414_Var
		.getExpr();
		Assert.assertNotNull(Expr_414_list);
		Assert.assertEquals(1, Expr_414_list.size());
		//414
		final MultiplicativeExpression MultiplicativeExpression_415_Var
		 = (MultiplicativeExpression)Expr_414_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_415_Var
		);
		final EList<? extends EObject> Expr_415_list = MultiplicativeExpression_415_Var
		.getExpr();
		Assert.assertNotNull(Expr_415_list);
		Assert.assertEquals(1, Expr_415_list.size());
		//415
		final CastExpression CastExpression_416_Var
		 = (CastExpression)Expr_415_list.get(0);
		Assert.assertNotNull(CastExpression_416_Var
		);
		//416
		final UnaryExpression UnaryExpression_417_Var
		 = (UnaryExpression)CastExpression_416_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_417_Var
		);
		//417
		final PostfixExpression PostfixExpression_418_Var
		 = (PostfixExpression)UnaryExpression_417_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_418_Var
		);
		final EList<? extends EObject> Expr_418_list = PostfixExpression_418_Var
		.getExpr();
		Assert.assertNotNull(Expr_418_list);
		Assert.assertEquals(1, Expr_418_list.size());
		//418
		final PrimaryExpression PrimaryExpression_419_Var
		 = (PrimaryExpression)Expr_418_list.get(0);
		Assert.assertNotNull(PrimaryExpression_419_Var
		);
		//419
		final Constant2 Constant2_420_Var
		 = (Constant2)PrimaryExpression_419_Var
		.getConst();
		Assert.assertNotNull(Constant2_420_Var
		);
		Assert.assertEquals("\"Could not reserve space for new employee!\\n\"", Constant2_420_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_384_Var
		.getSemi());
		//420
		final Statement Statement_421_Var
		 = (Statement)Statement_382_list.get(1);
		Assert.assertNotNull(Statement_421_Var
		);
		//421
		final JumpStatement JumpStatement_422_Var
		 = (JumpStatement)Statement_421_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_422_Var
		);
		//422
		final Expression Expression_423_Var
		 = (Expression)JumpStatement_422_Var
		.getExpr();
		Assert.assertNotNull(Expression_423_Var
		);
		final EList<? extends EObject> ExprExpr_423_list = Expression_423_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_423_list);
		Assert.assertEquals(1, ExprExpr_423_list.size());
		//423
		final AssignmentExpression AssignmentExpression_424_Var
		 = (AssignmentExpression)ExprExpr_423_list.get(0);
		Assert.assertNotNull(AssignmentExpression_424_Var
		);
		//424
		final ConditionalExpression ConditionalExpression_425_Var
		 = (ConditionalExpression)AssignmentExpression_424_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_425_Var
		);
		//425
		final LogicalOrExpression LogicalOrExpression_426_Var
		 = (LogicalOrExpression)ConditionalExpression_425_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_426_Var
		);
		final EList<? extends EObject> Expr_426_list = LogicalOrExpression_426_Var
		.getExpr();
		Assert.assertNotNull(Expr_426_list);
		Assert.assertEquals(1, Expr_426_list.size());
		//426
		final LogicalAndExpression LogicalAndExpression_427_Var
		 = (LogicalAndExpression)Expr_426_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_427_Var
		);
		final EList<? extends EObject> Expr_427_list = LogicalAndExpression_427_Var
		.getExpr();
		Assert.assertNotNull(Expr_427_list);
		Assert.assertEquals(1, Expr_427_list.size());
		//427
		final InclusiveOrExpression InclusiveOrExpression_428_Var
		 = (InclusiveOrExpression)Expr_427_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_428_Var
		);
		final EList<? extends EObject> Expr_428_list = InclusiveOrExpression_428_Var
		.getExpr();
		Assert.assertNotNull(Expr_428_list);
		Assert.assertEquals(1, Expr_428_list.size());
		//428
		final ExclusiveOrExpression ExclusiveOrExpression_429_Var
		 = (ExclusiveOrExpression)Expr_428_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_429_Var
		);
		final EList<? extends EObject> Expr_429_list = ExclusiveOrExpression_429_Var
		.getExpr();
		Assert.assertNotNull(Expr_429_list);
		Assert.assertEquals(1, Expr_429_list.size());
		//429
		final AndExpression AndExpression_430_Var
		 = (AndExpression)Expr_429_list.get(0);
		Assert.assertNotNull(AndExpression_430_Var
		);
		final EList<? extends EObject> Expr_430_list = AndExpression_430_Var
		.getExpr();
		Assert.assertNotNull(Expr_430_list);
		Assert.assertEquals(1, Expr_430_list.size());
		//430
		final EqualityExpression EqualityExpression_431_Var
		 = (EqualityExpression)Expr_430_list.get(0);
		Assert.assertNotNull(EqualityExpression_431_Var
		);
		final EList<? extends EObject> Expr_431_list = EqualityExpression_431_Var
		.getExpr();
		Assert.assertNotNull(Expr_431_list);
		Assert.assertEquals(1, Expr_431_list.size());
		//431
		final RelationalExpression RelationalExpression_432_Var
		 = (RelationalExpression)Expr_431_list.get(0);
		Assert.assertNotNull(RelationalExpression_432_Var
		);
		final EList<? extends EObject> Expr_432_list = RelationalExpression_432_Var
		.getExpr();
		Assert.assertNotNull(Expr_432_list);
		Assert.assertEquals(1, Expr_432_list.size());
		//432
		final ShiftExpression ShiftExpression_433_Var
		 = (ShiftExpression)Expr_432_list.get(0);
		Assert.assertNotNull(ShiftExpression_433_Var
		);
		final EList<? extends EObject> Expr_433_list = ShiftExpression_433_Var
		.getExpr();
		Assert.assertNotNull(Expr_433_list);
		Assert.assertEquals(1, Expr_433_list.size());
		//433
		final AdditiveExpression AdditiveExpression_434_Var
		 = (AdditiveExpression)Expr_433_list.get(0);
		Assert.assertNotNull(AdditiveExpression_434_Var
		);
		final EList<? extends EObject> Expr_434_list = AdditiveExpression_434_Var
		.getExpr();
		Assert.assertNotNull(Expr_434_list);
		Assert.assertEquals(1, Expr_434_list.size());
		//434
		final MultiplicativeExpression MultiplicativeExpression_435_Var
		 = (MultiplicativeExpression)Expr_434_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_435_Var
		);
		final EList<? extends EObject> Expr_435_list = MultiplicativeExpression_435_Var
		.getExpr();
		Assert.assertNotNull(Expr_435_list);
		Assert.assertEquals(1, Expr_435_list.size());
		//435
		final CastExpression CastExpression_436_Var
		 = (CastExpression)Expr_435_list.get(0);
		Assert.assertNotNull(CastExpression_436_Var
		);
		//436
		final UnaryExpression UnaryExpression_437_Var
		 = (UnaryExpression)CastExpression_436_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_437_Var
		);
		//437
		final UnaryOperator UnaryOperator_438_Var
		 = (UnaryOperator)UnaryExpression_437_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_438_Var
		);
		Assert.assertEquals("-", UnaryOperator_438_Var
		.getOp());
		//438
		final CastExpression CastExpression_439_Var
		 = (CastExpression)UnaryExpression_437_Var
		.getExpr();
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
		final Constant2 Constant2_443_Var
		 = (Constant2)PrimaryExpression_442_Var
		.getConst();
		Assert.assertNotNull(Constant2_443_Var
		);
		Assert.assertEquals("1", Constant2_443_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_422_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_422_Var
		.getSemi());
		//443
		final Statement Statement_444_Var
		 = (Statement)Statement_351_list.get(1);
		Assert.assertNotNull(Statement_444_Var
		);
		//444
		final ExpressionStatement ExpressionStatement_445_Var
		 = (ExpressionStatement)Statement_444_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_445_Var
		);
		//445
		final Expression Expression_446_Var
		 = (Expression)ExpressionStatement_445_Var
		.getExpression();
		Assert.assertNotNull(Expression_446_Var
		);
		final EList<? extends EObject> ExprExpr_446_list = Expression_446_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_446_list);
		Assert.assertEquals(1, ExprExpr_446_list.size());
		//446
		final AssignmentExpression AssignmentExpression_447_Var
		 = (AssignmentExpression)ExprExpr_446_list.get(0);
		Assert.assertNotNull(AssignmentExpression_447_Var
		);
		//447
		final ConditionalExpression ConditionalExpression_448_Var
		 = (ConditionalExpression)AssignmentExpression_447_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_448_Var
		);
		//448
		final LogicalOrExpression LogicalOrExpression_449_Var
		 = (LogicalOrExpression)ConditionalExpression_448_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_449_Var
		);
		final EList<? extends EObject> Expr_449_list = LogicalOrExpression_449_Var
		.getExpr();
		Assert.assertNotNull(Expr_449_list);
		Assert.assertEquals(1, Expr_449_list.size());
		//449
		final LogicalAndExpression LogicalAndExpression_450_Var
		 = (LogicalAndExpression)Expr_449_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_450_Var
		);
		final EList<? extends EObject> Expr_450_list = LogicalAndExpression_450_Var
		.getExpr();
		Assert.assertNotNull(Expr_450_list);
		Assert.assertEquals(1, Expr_450_list.size());
		//450
		final InclusiveOrExpression InclusiveOrExpression_451_Var
		 = (InclusiveOrExpression)Expr_450_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_451_Var
		);
		final EList<? extends EObject> Expr_451_list = InclusiveOrExpression_451_Var
		.getExpr();
		Assert.assertNotNull(Expr_451_list);
		Assert.assertEquals(1, Expr_451_list.size());
		//451
		final ExclusiveOrExpression ExclusiveOrExpression_452_Var
		 = (ExclusiveOrExpression)Expr_451_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_452_Var
		);
		final EList<? extends EObject> Expr_452_list = ExclusiveOrExpression_452_Var
		.getExpr();
		Assert.assertNotNull(Expr_452_list);
		Assert.assertEquals(1, Expr_452_list.size());
		//452
		final AndExpression AndExpression_453_Var
		 = (AndExpression)Expr_452_list.get(0);
		Assert.assertNotNull(AndExpression_453_Var
		);
		final EList<? extends EObject> Expr_453_list = AndExpression_453_Var
		.getExpr();
		Assert.assertNotNull(Expr_453_list);
		Assert.assertEquals(1, Expr_453_list.size());
		//453
		final EqualityExpression EqualityExpression_454_Var
		 = (EqualityExpression)Expr_453_list.get(0);
		Assert.assertNotNull(EqualityExpression_454_Var
		);
		final EList<? extends EObject> Expr_454_list = EqualityExpression_454_Var
		.getExpr();
		Assert.assertNotNull(Expr_454_list);
		Assert.assertEquals(1, Expr_454_list.size());
		//454
		final RelationalExpression RelationalExpression_455_Var
		 = (RelationalExpression)Expr_454_list.get(0);
		Assert.assertNotNull(RelationalExpression_455_Var
		);
		final EList<? extends EObject> Expr_455_list = RelationalExpression_455_Var
		.getExpr();
		Assert.assertNotNull(Expr_455_list);
		Assert.assertEquals(1, Expr_455_list.size());
		//455
		final ShiftExpression ShiftExpression_456_Var
		 = (ShiftExpression)Expr_455_list.get(0);
		Assert.assertNotNull(ShiftExpression_456_Var
		);
		final EList<? extends EObject> Expr_456_list = ShiftExpression_456_Var
		.getExpr();
		Assert.assertNotNull(Expr_456_list);
		Assert.assertEquals(1, Expr_456_list.size());
		//456
		final AdditiveExpression AdditiveExpression_457_Var
		 = (AdditiveExpression)Expr_456_list.get(0);
		Assert.assertNotNull(AdditiveExpression_457_Var
		);
		final EList<? extends EObject> Expr_457_list = AdditiveExpression_457_Var
		.getExpr();
		Assert.assertNotNull(Expr_457_list);
		Assert.assertEquals(1, Expr_457_list.size());
		//457
		final MultiplicativeExpression MultiplicativeExpression_458_Var
		 = (MultiplicativeExpression)Expr_457_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_458_Var
		);
		final EList<? extends EObject> Expr_458_list = MultiplicativeExpression_458_Var
		.getExpr();
		Assert.assertNotNull(Expr_458_list);
		Assert.assertEquals(1, Expr_458_list.size());
		//458
		final CastExpression CastExpression_459_Var
		 = (CastExpression)Expr_458_list.get(0);
		Assert.assertNotNull(CastExpression_459_Var
		);
		//459
		final UnaryExpression UnaryExpression_460_Var
		 = (UnaryExpression)CastExpression_459_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_460_Var
		);
		//460
		final PostfixExpression PostfixExpression_461_Var
		 = (PostfixExpression)UnaryExpression_460_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_461_Var
		);
		final EList<? extends EObject> Expr_461_list = PostfixExpression_461_Var
		.getExpr();
		Assert.assertNotNull(Expr_461_list);
		Assert.assertEquals(1, Expr_461_list.size());
		//461
		final PrimaryExpression PrimaryExpression_462_Var
		 = (PrimaryExpression)Expr_461_list.get(0);
		Assert.assertNotNull(PrimaryExpression_462_Var
		);
		Assert.assertEquals("print", PrimaryExpression_462_Var
		.getId());
		final EList<? extends EObject> Suffix_462_list = PostfixExpression_461_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_462_list);
		Assert.assertEquals(1, Suffix_462_list.size());
		//462
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_463_Var
		 = (PostfixExpressionSuffixArgument)Suffix_462_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_463_Var
		);
		//463
		final ArgumentExpressionList ArgumentExpressionList_464_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_463_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_464_Var
		);
		final EList<? extends EObject> Expr_464_list = ArgumentExpressionList_464_Var
		.getExpr();
		Assert.assertNotNull(Expr_464_list);
		Assert.assertEquals(1, Expr_464_list.size());
		//464
		final AssignmentExpression AssignmentExpression_465_Var
		 = (AssignmentExpression)Expr_464_list.get(0);
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
		final UnaryOperator UnaryOperator_479_Var
		 = (UnaryOperator)UnaryExpression_478_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_479_Var
		);
		Assert.assertEquals("&", UnaryOperator_479_Var
		.getOp());
		//479
		final CastExpression CastExpression_480_Var
		 = (CastExpression)UnaryExpression_478_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_480_Var
		);
		//480
		final UnaryExpression UnaryExpression_481_Var
		 = (UnaryExpression)CastExpression_480_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_481_Var
		);
		//481
		final PostfixExpression PostfixExpression_482_Var
		 = (PostfixExpression)UnaryExpression_481_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_482_Var
		);
		final EList<? extends EObject> Expr_482_list = PostfixExpression_482_Var
		.getExpr();
		Assert.assertNotNull(Expr_482_list);
		Assert.assertEquals(1, Expr_482_list.size());
		//482
		final PrimaryExpression PrimaryExpression_483_Var
		 = (PrimaryExpression)Expr_482_list.get(0);
		Assert.assertNotNull(PrimaryExpression_483_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_483_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_445_Var
		.getSemi());
		//483
		final Statement Statement_484_Var
		 = (Statement)Statement_351_list.get(2);
		Assert.assertNotNull(Statement_484_Var
		);
		//484
		final ExpressionStatement ExpressionStatement_485_Var
		 = (ExpressionStatement)Statement_484_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_485_Var
		);
		//485
		final Expression Expression_486_Var
		 = (Expression)ExpressionStatement_485_Var
		.getExpression();
		Assert.assertNotNull(Expression_486_Var
		);
		final EList<? extends EObject> ExprExpr_486_list = Expression_486_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_486_list);
		Assert.assertEquals(1, ExprExpr_486_list.size());
		//486
		final AssignmentExpression AssignmentExpression_487_Var
		 = (AssignmentExpression)ExprExpr_486_list.get(0);
		Assert.assertNotNull(AssignmentExpression_487_Var
		);
		//487
		final ConditionalExpression ConditionalExpression_488_Var
		 = (ConditionalExpression)AssignmentExpression_487_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_488_Var
		);
		//488
		final LogicalOrExpression LogicalOrExpression_489_Var
		 = (LogicalOrExpression)ConditionalExpression_488_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_489_Var
		);
		final EList<? extends EObject> Expr_489_list = LogicalOrExpression_489_Var
		.getExpr();
		Assert.assertNotNull(Expr_489_list);
		Assert.assertEquals(1, Expr_489_list.size());
		//489
		final LogicalAndExpression LogicalAndExpression_490_Var
		 = (LogicalAndExpression)Expr_489_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_490_Var
		);
		final EList<? extends EObject> Expr_490_list = LogicalAndExpression_490_Var
		.getExpr();
		Assert.assertNotNull(Expr_490_list);
		Assert.assertEquals(1, Expr_490_list.size());
		//490
		final InclusiveOrExpression InclusiveOrExpression_491_Var
		 = (InclusiveOrExpression)Expr_490_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_491_Var
		);
		final EList<? extends EObject> Expr_491_list = InclusiveOrExpression_491_Var
		.getExpr();
		Assert.assertNotNull(Expr_491_list);
		Assert.assertEquals(1, Expr_491_list.size());
		//491
		final ExclusiveOrExpression ExclusiveOrExpression_492_Var
		 = (ExclusiveOrExpression)Expr_491_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_492_Var
		);
		final EList<? extends EObject> Expr_492_list = ExclusiveOrExpression_492_Var
		.getExpr();
		Assert.assertNotNull(Expr_492_list);
		Assert.assertEquals(1, Expr_492_list.size());
		//492
		final AndExpression AndExpression_493_Var
		 = (AndExpression)Expr_492_list.get(0);
		Assert.assertNotNull(AndExpression_493_Var
		);
		final EList<? extends EObject> Expr_493_list = AndExpression_493_Var
		.getExpr();
		Assert.assertNotNull(Expr_493_list);
		Assert.assertEquals(1, Expr_493_list.size());
		//493
		final EqualityExpression EqualityExpression_494_Var
		 = (EqualityExpression)Expr_493_list.get(0);
		Assert.assertNotNull(EqualityExpression_494_Var
		);
		final EList<? extends EObject> Expr_494_list = EqualityExpression_494_Var
		.getExpr();
		Assert.assertNotNull(Expr_494_list);
		Assert.assertEquals(1, Expr_494_list.size());
		//494
		final RelationalExpression RelationalExpression_495_Var
		 = (RelationalExpression)Expr_494_list.get(0);
		Assert.assertNotNull(RelationalExpression_495_Var
		);
		final EList<? extends EObject> Expr_495_list = RelationalExpression_495_Var
		.getExpr();
		Assert.assertNotNull(Expr_495_list);
		Assert.assertEquals(1, Expr_495_list.size());
		//495
		final ShiftExpression ShiftExpression_496_Var
		 = (ShiftExpression)Expr_495_list.get(0);
		Assert.assertNotNull(ShiftExpression_496_Var
		);
		final EList<? extends EObject> Expr_496_list = ShiftExpression_496_Var
		.getExpr();
		Assert.assertNotNull(Expr_496_list);
		Assert.assertEquals(1, Expr_496_list.size());
		//496
		final AdditiveExpression AdditiveExpression_497_Var
		 = (AdditiveExpression)Expr_496_list.get(0);
		Assert.assertNotNull(AdditiveExpression_497_Var
		);
		final EList<? extends EObject> Expr_497_list = AdditiveExpression_497_Var
		.getExpr();
		Assert.assertNotNull(Expr_497_list);
		Assert.assertEquals(1, Expr_497_list.size());
		//497
		final MultiplicativeExpression MultiplicativeExpression_498_Var
		 = (MultiplicativeExpression)Expr_497_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_498_Var
		);
		final EList<? extends EObject> Expr_498_list = MultiplicativeExpression_498_Var
		.getExpr();
		Assert.assertNotNull(Expr_498_list);
		Assert.assertEquals(1, Expr_498_list.size());
		//498
		final CastExpression CastExpression_499_Var
		 = (CastExpression)Expr_498_list.get(0);
		Assert.assertNotNull(CastExpression_499_Var
		);
		//499
		final UnaryExpression UnaryExpression_500_Var
		 = (UnaryExpression)CastExpression_499_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_500_Var
		);
		//500
		final PostfixExpression PostfixExpression_501_Var
		 = (PostfixExpression)UnaryExpression_500_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_501_Var
		);
		final EList<? extends EObject> Expr_501_list = PostfixExpression_501_Var
		.getExpr();
		Assert.assertNotNull(Expr_501_list);
		Assert.assertEquals(1, Expr_501_list.size());
		//501
		final PrimaryExpression PrimaryExpression_502_Var
		 = (PrimaryExpression)Expr_501_list.get(0);
		Assert.assertNotNull(PrimaryExpression_502_Var
		);
		Assert.assertEquals("print", PrimaryExpression_502_Var
		.getId());
		final EList<? extends EObject> Suffix_502_list = PostfixExpression_501_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_502_list);
		Assert.assertEquals(1, Suffix_502_list.size());
		//502
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_503_Var
		 = (PostfixExpressionSuffixArgument)Suffix_502_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_503_Var
		);
		//503
		final ArgumentExpressionList ArgumentExpressionList_504_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_503_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_504_Var
		);
		final EList<? extends EObject> Expr_504_list = ArgumentExpressionList_504_Var
		.getExpr();
		Assert.assertNotNull(Expr_504_list);
		Assert.assertEquals(1, Expr_504_list.size());
		//504
		final AssignmentExpression AssignmentExpression_505_Var
		 = (AssignmentExpression)Expr_504_list.get(0);
		Assert.assertNotNull(AssignmentExpression_505_Var
		);
		//505
		final ConditionalExpression ConditionalExpression_506_Var
		 = (ConditionalExpression)AssignmentExpression_505_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_506_Var
		);
		//506
		final LogicalOrExpression LogicalOrExpression_507_Var
		 = (LogicalOrExpression)ConditionalExpression_506_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_507_Var
		);
		final EList<? extends EObject> Expr_507_list = LogicalOrExpression_507_Var
		.getExpr();
		Assert.assertNotNull(Expr_507_list);
		Assert.assertEquals(1, Expr_507_list.size());
		//507
		final LogicalAndExpression LogicalAndExpression_508_Var
		 = (LogicalAndExpression)Expr_507_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_508_Var
		);
		final EList<? extends EObject> Expr_508_list = LogicalAndExpression_508_Var
		.getExpr();
		Assert.assertNotNull(Expr_508_list);
		Assert.assertEquals(1, Expr_508_list.size());
		//508
		final InclusiveOrExpression InclusiveOrExpression_509_Var
		 = (InclusiveOrExpression)Expr_508_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_509_Var
		);
		final EList<? extends EObject> Expr_509_list = InclusiveOrExpression_509_Var
		.getExpr();
		Assert.assertNotNull(Expr_509_list);
		Assert.assertEquals(1, Expr_509_list.size());
		//509
		final ExclusiveOrExpression ExclusiveOrExpression_510_Var
		 = (ExclusiveOrExpression)Expr_509_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_510_Var
		);
		final EList<? extends EObject> Expr_510_list = ExclusiveOrExpression_510_Var
		.getExpr();
		Assert.assertNotNull(Expr_510_list);
		Assert.assertEquals(1, Expr_510_list.size());
		//510
		final AndExpression AndExpression_511_Var
		 = (AndExpression)Expr_510_list.get(0);
		Assert.assertNotNull(AndExpression_511_Var
		);
		final EList<? extends EObject> Expr_511_list = AndExpression_511_Var
		.getExpr();
		Assert.assertNotNull(Expr_511_list);
		Assert.assertEquals(1, Expr_511_list.size());
		//511
		final EqualityExpression EqualityExpression_512_Var
		 = (EqualityExpression)Expr_511_list.get(0);
		Assert.assertNotNull(EqualityExpression_512_Var
		);
		final EList<? extends EObject> Expr_512_list = EqualityExpression_512_Var
		.getExpr();
		Assert.assertNotNull(Expr_512_list);
		Assert.assertEquals(1, Expr_512_list.size());
		//512
		final RelationalExpression RelationalExpression_513_Var
		 = (RelationalExpression)Expr_512_list.get(0);
		Assert.assertNotNull(RelationalExpression_513_Var
		);
		final EList<? extends EObject> Expr_513_list = RelationalExpression_513_Var
		.getExpr();
		Assert.assertNotNull(Expr_513_list);
		Assert.assertEquals(1, Expr_513_list.size());
		//513
		final ShiftExpression ShiftExpression_514_Var
		 = (ShiftExpression)Expr_513_list.get(0);
		Assert.assertNotNull(ShiftExpression_514_Var
		);
		final EList<? extends EObject> Expr_514_list = ShiftExpression_514_Var
		.getExpr();
		Assert.assertNotNull(Expr_514_list);
		Assert.assertEquals(1, Expr_514_list.size());
		//514
		final AdditiveExpression AdditiveExpression_515_Var
		 = (AdditiveExpression)Expr_514_list.get(0);
		Assert.assertNotNull(AdditiveExpression_515_Var
		);
		final EList<? extends EObject> Expr_515_list = AdditiveExpression_515_Var
		.getExpr();
		Assert.assertNotNull(Expr_515_list);
		Assert.assertEquals(1, Expr_515_list.size());
		//515
		final MultiplicativeExpression MultiplicativeExpression_516_Var
		 = (MultiplicativeExpression)Expr_515_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_516_Var
		);
		final EList<? extends EObject> Expr_516_list = MultiplicativeExpression_516_Var
		.getExpr();
		Assert.assertNotNull(Expr_516_list);
		Assert.assertEquals(1, Expr_516_list.size());
		//516
		final CastExpression CastExpression_517_Var
		 = (CastExpression)Expr_516_list.get(0);
		Assert.assertNotNull(CastExpression_517_Var
		);
		//517
		final UnaryExpression UnaryExpression_518_Var
		 = (UnaryExpression)CastExpression_517_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_518_Var
		);
		//518
		final UnaryOperator UnaryOperator_519_Var
		 = (UnaryOperator)UnaryExpression_518_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_519_Var
		);
		Assert.assertEquals("&", UnaryOperator_519_Var
		.getOp());
		//519
		final CastExpression CastExpression_520_Var
		 = (CastExpression)UnaryExpression_518_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_520_Var
		);
		//520
		final UnaryExpression UnaryExpression_521_Var
		 = (UnaryExpression)CastExpression_520_Var
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
		Assert.assertEquals("phil", PrimaryExpression_523_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_485_Var
		.getSemi());
		//523
		final Statement Statement_524_Var
		 = (Statement)Statement_351_list.get(3);
		Assert.assertNotNull(Statement_524_Var
		);
		//524
		final ExpressionStatement ExpressionStatement_525_Var
		 = (ExpressionStatement)Statement_524_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_525_Var
		);
		//525
		final Expression Expression_526_Var
		 = (Expression)ExpressionStatement_525_Var
		.getExpression();
		Assert.assertNotNull(Expression_526_Var
		);
		final EList<? extends EObject> ExprExpr_526_list = Expression_526_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_526_list);
		Assert.assertEquals(1, ExprExpr_526_list.size());
		//526
		final AssignmentExpression AssignmentExpression_527_Var
		 = (AssignmentExpression)ExprExpr_526_list.get(0);
		Assert.assertNotNull(AssignmentExpression_527_Var
		);
		//527
		final UnaryExpression UnaryExpression_528_Var
		 = (UnaryExpression)AssignmentExpression_527_Var
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
		Assert.assertEquals("newEmployee", PrimaryExpression_530_Var
		.getId());
		final EList<? extends EObject> Suffix_530_list = PostfixExpression_529_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_530_list);
		Assert.assertEquals(1, Suffix_530_list.size());
		//530
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_531_Var
		 = (PostfixExpressionSuffixArrow)Suffix_530_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArrow_531_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixArrow_531_Var
		.getId());
		//531
		final AssignmentOperator AssignmentOperator_532_Var
		 = (AssignmentOperator)AssignmentExpression_527_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_532_Var
		);
		Assert.assertEquals("=", AssignmentOperator_532_Var
		.getOp());
		//532
		final AssignmentExpression AssignmentExpression_533_Var
		 = (AssignmentExpression)AssignmentExpression_527_Var
		.getAssignmentExpr();
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
		//548
		final Constant2 Constant2_549_Var
		 = (Constant2)PrimaryExpression_548_Var
		.getConst();
		Assert.assertNotNull(Constant2_549_Var
		);
		Assert.assertEquals("0x009", Constant2_549_Var
		.getHex());
		Assert.assertEquals(";", ExpressionStatement_525_Var
		.getSemi());
		//549
		final Statement Statement_550_Var
		 = (Statement)Statement_351_list.get(4);
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
		Assert.assertEquals("strcpy", PrimaryExpression_568_Var
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
		Assert.assertEquals("newEmployee", PrimaryExpression_586_Var
		.getId());
		final EList<? extends EObject> Suffix_586_list = PostfixExpression_585_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_586_list);
		Assert.assertEquals(1, Suffix_586_list.size());
		//586
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_587_Var
		 = (PostfixExpressionSuffixArrow)Suffix_586_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArrow_587_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixArrow_587_Var
		.getId());
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
		//603
		final Constant2 Constant2_604_Var
		 = (Constant2)PrimaryExpression_603_Var
		.getConst();
		Assert.assertNotNull(Constant2_604_Var
		);
		Assert.assertEquals("\"Billy The Kid\"", Constant2_604_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_551_Var
		.getSemi());
		//604
		final Statement Statement_605_Var
		 = (Statement)Statement_351_list.get(5);
		Assert.assertNotNull(Statement_605_Var
		);
		//605
		final ExpressionStatement ExpressionStatement_606_Var
		 = (ExpressionStatement)Statement_605_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_606_Var
		);
		//606
		final Expression Expression_607_Var
		 = (Expression)ExpressionStatement_606_Var
		.getExpression();
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
		Assert.assertEquals("print", PrimaryExpression_623_Var
		.getId());
		final EList<? extends EObject> Suffix_623_list = PostfixExpression_622_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_623_list);
		Assert.assertEquals(1, Suffix_623_list.size());
		//623
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_624_Var
		 = (PostfixExpressionSuffixArgument)Suffix_623_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_624_Var
		);
		//624
		final ArgumentExpressionList ArgumentExpressionList_625_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_624_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_625_Var
		);
		final EList<? extends EObject> Expr_625_list = ArgumentExpressionList_625_Var
		.getExpr();
		Assert.assertNotNull(Expr_625_list);
		Assert.assertEquals(1, Expr_625_list.size());
		//625
		final AssignmentExpression AssignmentExpression_626_Var
		 = (AssignmentExpression)Expr_625_list.get(0);
		Assert.assertNotNull(AssignmentExpression_626_Var
		);
		//626
		final ConditionalExpression ConditionalExpression_627_Var
		 = (ConditionalExpression)AssignmentExpression_626_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_627_Var
		);
		//627
		final LogicalOrExpression LogicalOrExpression_628_Var
		 = (LogicalOrExpression)ConditionalExpression_627_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_628_Var
		);
		final EList<? extends EObject> Expr_628_list = LogicalOrExpression_628_Var
		.getExpr();
		Assert.assertNotNull(Expr_628_list);
		Assert.assertEquals(1, Expr_628_list.size());
		//628
		final LogicalAndExpression LogicalAndExpression_629_Var
		 = (LogicalAndExpression)Expr_628_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_629_Var
		);
		final EList<? extends EObject> Expr_629_list = LogicalAndExpression_629_Var
		.getExpr();
		Assert.assertNotNull(Expr_629_list);
		Assert.assertEquals(1, Expr_629_list.size());
		//629
		final InclusiveOrExpression InclusiveOrExpression_630_Var
		 = (InclusiveOrExpression)Expr_629_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_630_Var
		);
		final EList<? extends EObject> Expr_630_list = InclusiveOrExpression_630_Var
		.getExpr();
		Assert.assertNotNull(Expr_630_list);
		Assert.assertEquals(1, Expr_630_list.size());
		//630
		final ExclusiveOrExpression ExclusiveOrExpression_631_Var
		 = (ExclusiveOrExpression)Expr_630_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_631_Var
		);
		final EList<? extends EObject> Expr_631_list = ExclusiveOrExpression_631_Var
		.getExpr();
		Assert.assertNotNull(Expr_631_list);
		Assert.assertEquals(1, Expr_631_list.size());
		//631
		final AndExpression AndExpression_632_Var
		 = (AndExpression)Expr_631_list.get(0);
		Assert.assertNotNull(AndExpression_632_Var
		);
		final EList<? extends EObject> Expr_632_list = AndExpression_632_Var
		.getExpr();
		Assert.assertNotNull(Expr_632_list);
		Assert.assertEquals(1, Expr_632_list.size());
		//632
		final EqualityExpression EqualityExpression_633_Var
		 = (EqualityExpression)Expr_632_list.get(0);
		Assert.assertNotNull(EqualityExpression_633_Var
		);
		final EList<? extends EObject> Expr_633_list = EqualityExpression_633_Var
		.getExpr();
		Assert.assertNotNull(Expr_633_list);
		Assert.assertEquals(1, Expr_633_list.size());
		//633
		final RelationalExpression RelationalExpression_634_Var
		 = (RelationalExpression)Expr_633_list.get(0);
		Assert.assertNotNull(RelationalExpression_634_Var
		);
		final EList<? extends EObject> Expr_634_list = RelationalExpression_634_Var
		.getExpr();
		Assert.assertNotNull(Expr_634_list);
		Assert.assertEquals(1, Expr_634_list.size());
		//634
		final ShiftExpression ShiftExpression_635_Var
		 = (ShiftExpression)Expr_634_list.get(0);
		Assert.assertNotNull(ShiftExpression_635_Var
		);
		final EList<? extends EObject> Expr_635_list = ShiftExpression_635_Var
		.getExpr();
		Assert.assertNotNull(Expr_635_list);
		Assert.assertEquals(1, Expr_635_list.size());
		//635
		final AdditiveExpression AdditiveExpression_636_Var
		 = (AdditiveExpression)Expr_635_list.get(0);
		Assert.assertNotNull(AdditiveExpression_636_Var
		);
		final EList<? extends EObject> Expr_636_list = AdditiveExpression_636_Var
		.getExpr();
		Assert.assertNotNull(Expr_636_list);
		Assert.assertEquals(1, Expr_636_list.size());
		//636
		final MultiplicativeExpression MultiplicativeExpression_637_Var
		 = (MultiplicativeExpression)Expr_636_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_637_Var
		);
		final EList<? extends EObject> Expr_637_list = MultiplicativeExpression_637_Var
		.getExpr();
		Assert.assertNotNull(Expr_637_list);
		Assert.assertEquals(1, Expr_637_list.size());
		//637
		final CastExpression CastExpression_638_Var
		 = (CastExpression)Expr_637_list.get(0);
		Assert.assertNotNull(CastExpression_638_Var
		);
		//638
		final UnaryExpression UnaryExpression_639_Var
		 = (UnaryExpression)CastExpression_638_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_639_Var
		);
		//639
		final PostfixExpression PostfixExpression_640_Var
		 = (PostfixExpression)UnaryExpression_639_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_640_Var
		);
		final EList<? extends EObject> Expr_640_list = PostfixExpression_640_Var
		.getExpr();
		Assert.assertNotNull(Expr_640_list);
		Assert.assertEquals(1, Expr_640_list.size());
		//640
		final PrimaryExpression PrimaryExpression_641_Var
		 = (PrimaryExpression)Expr_640_list.get(0);
		Assert.assertNotNull(PrimaryExpression_641_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_641_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_606_Var
		.getSemi());
		//641
		final Statement Statement_642_Var
		 = (Statement)Statement_351_list.get(6);
		Assert.assertNotNull(Statement_642_Var
		);
		//642
		final ExpressionStatement ExpressionStatement_643_Var
		 = (ExpressionStatement)Statement_642_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_643_Var
		);
		//643
		final Expression Expression_644_Var
		 = (Expression)ExpressionStatement_643_Var
		.getExpression();
		Assert.assertNotNull(Expression_644_Var
		);
		final EList<? extends EObject> ExprExpr_644_list = Expression_644_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_644_list);
		Assert.assertEquals(1, ExprExpr_644_list.size());
		//644
		final AssignmentExpression AssignmentExpression_645_Var
		 = (AssignmentExpression)ExprExpr_644_list.get(0);
		Assert.assertNotNull(AssignmentExpression_645_Var
		);
		//645
		final ConditionalExpression ConditionalExpression_646_Var
		 = (ConditionalExpression)AssignmentExpression_645_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_646_Var
		);
		//646
		final LogicalOrExpression LogicalOrExpression_647_Var
		 = (LogicalOrExpression)ConditionalExpression_646_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_647_Var
		);
		final EList<? extends EObject> Expr_647_list = LogicalOrExpression_647_Var
		.getExpr();
		Assert.assertNotNull(Expr_647_list);
		Assert.assertEquals(1, Expr_647_list.size());
		//647
		final LogicalAndExpression LogicalAndExpression_648_Var
		 = (LogicalAndExpression)Expr_647_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_648_Var
		);
		final EList<? extends EObject> Expr_648_list = LogicalAndExpression_648_Var
		.getExpr();
		Assert.assertNotNull(Expr_648_list);
		Assert.assertEquals(1, Expr_648_list.size());
		//648
		final InclusiveOrExpression InclusiveOrExpression_649_Var
		 = (InclusiveOrExpression)Expr_648_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_649_Var
		);
		final EList<? extends EObject> Expr_649_list = InclusiveOrExpression_649_Var
		.getExpr();
		Assert.assertNotNull(Expr_649_list);
		Assert.assertEquals(1, Expr_649_list.size());
		//649
		final ExclusiveOrExpression ExclusiveOrExpression_650_Var
		 = (ExclusiveOrExpression)Expr_649_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_650_Var
		);
		final EList<? extends EObject> Expr_650_list = ExclusiveOrExpression_650_Var
		.getExpr();
		Assert.assertNotNull(Expr_650_list);
		Assert.assertEquals(1, Expr_650_list.size());
		//650
		final AndExpression AndExpression_651_Var
		 = (AndExpression)Expr_650_list.get(0);
		Assert.assertNotNull(AndExpression_651_Var
		);
		final EList<? extends EObject> Expr_651_list = AndExpression_651_Var
		.getExpr();
		Assert.assertNotNull(Expr_651_list);
		Assert.assertEquals(1, Expr_651_list.size());
		//651
		final EqualityExpression EqualityExpression_652_Var
		 = (EqualityExpression)Expr_651_list.get(0);
		Assert.assertNotNull(EqualityExpression_652_Var
		);
		final EList<? extends EObject> Expr_652_list = EqualityExpression_652_Var
		.getExpr();
		Assert.assertNotNull(Expr_652_list);
		Assert.assertEquals(1, Expr_652_list.size());
		//652
		final RelationalExpression RelationalExpression_653_Var
		 = (RelationalExpression)Expr_652_list.get(0);
		Assert.assertNotNull(RelationalExpression_653_Var
		);
		final EList<? extends EObject> Expr_653_list = RelationalExpression_653_Var
		.getExpr();
		Assert.assertNotNull(Expr_653_list);
		Assert.assertEquals(1, Expr_653_list.size());
		//653
		final ShiftExpression ShiftExpression_654_Var
		 = (ShiftExpression)Expr_653_list.get(0);
		Assert.assertNotNull(ShiftExpression_654_Var
		);
		final EList<? extends EObject> Expr_654_list = ShiftExpression_654_Var
		.getExpr();
		Assert.assertNotNull(Expr_654_list);
		Assert.assertEquals(1, Expr_654_list.size());
		//654
		final AdditiveExpression AdditiveExpression_655_Var
		 = (AdditiveExpression)Expr_654_list.get(0);
		Assert.assertNotNull(AdditiveExpression_655_Var
		);
		final EList<? extends EObject> Expr_655_list = AdditiveExpression_655_Var
		.getExpr();
		Assert.assertNotNull(Expr_655_list);
		Assert.assertEquals(1, Expr_655_list.size());
		//655
		final MultiplicativeExpression MultiplicativeExpression_656_Var
		 = (MultiplicativeExpression)Expr_655_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_656_Var
		);
		final EList<? extends EObject> Expr_656_list = MultiplicativeExpression_656_Var
		.getExpr();
		Assert.assertNotNull(Expr_656_list);
		Assert.assertEquals(1, Expr_656_list.size());
		//656
		final CastExpression CastExpression_657_Var
		 = (CastExpression)Expr_656_list.get(0);
		Assert.assertNotNull(CastExpression_657_Var
		);
		//657
		final UnaryExpression UnaryExpression_658_Var
		 = (UnaryExpression)CastExpression_657_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_658_Var
		);
		//658
		final PostfixExpression PostfixExpression_659_Var
		 = (PostfixExpression)UnaryExpression_658_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_659_Var
		);
		final EList<? extends EObject> Expr_659_list = PostfixExpression_659_Var
		.getExpr();
		Assert.assertNotNull(Expr_659_list);
		Assert.assertEquals(1, Expr_659_list.size());
		//659
		final PrimaryExpression PrimaryExpression_660_Var
		 = (PrimaryExpression)Expr_659_list.get(0);
		Assert.assertNotNull(PrimaryExpression_660_Var
		);
		Assert.assertEquals("free", PrimaryExpression_660_Var
		.getId());
		final EList<? extends EObject> Suffix_660_list = PostfixExpression_659_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_660_list);
		Assert.assertEquals(1, Suffix_660_list.size());
		//660
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_661_Var
		 = (PostfixExpressionSuffixArgument)Suffix_660_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_661_Var
		);
		//661
		final ArgumentExpressionList ArgumentExpressionList_662_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_661_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_662_Var
		);
		final EList<? extends EObject> Expr_662_list = ArgumentExpressionList_662_Var
		.getExpr();
		Assert.assertNotNull(Expr_662_list);
		Assert.assertEquals(1, Expr_662_list.size());
		//662
		final AssignmentExpression AssignmentExpression_663_Var
		 = (AssignmentExpression)Expr_662_list.get(0);
		Assert.assertNotNull(AssignmentExpression_663_Var
		);
		//663
		final ConditionalExpression ConditionalExpression_664_Var
		 = (ConditionalExpression)AssignmentExpression_663_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_664_Var
		);
		//664
		final LogicalOrExpression LogicalOrExpression_665_Var
		 = (LogicalOrExpression)ConditionalExpression_664_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_665_Var
		);
		final EList<? extends EObject> Expr_665_list = LogicalOrExpression_665_Var
		.getExpr();
		Assert.assertNotNull(Expr_665_list);
		Assert.assertEquals(1, Expr_665_list.size());
		//665
		final LogicalAndExpression LogicalAndExpression_666_Var
		 = (LogicalAndExpression)Expr_665_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_666_Var
		);
		final EList<? extends EObject> Expr_666_list = LogicalAndExpression_666_Var
		.getExpr();
		Assert.assertNotNull(Expr_666_list);
		Assert.assertEquals(1, Expr_666_list.size());
		//666
		final InclusiveOrExpression InclusiveOrExpression_667_Var
		 = (InclusiveOrExpression)Expr_666_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_667_Var
		);
		final EList<? extends EObject> Expr_667_list = InclusiveOrExpression_667_Var
		.getExpr();
		Assert.assertNotNull(Expr_667_list);
		Assert.assertEquals(1, Expr_667_list.size());
		//667
		final ExclusiveOrExpression ExclusiveOrExpression_668_Var
		 = (ExclusiveOrExpression)Expr_667_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_668_Var
		);
		final EList<? extends EObject> Expr_668_list = ExclusiveOrExpression_668_Var
		.getExpr();
		Assert.assertNotNull(Expr_668_list);
		Assert.assertEquals(1, Expr_668_list.size());
		//668
		final AndExpression AndExpression_669_Var
		 = (AndExpression)Expr_668_list.get(0);
		Assert.assertNotNull(AndExpression_669_Var
		);
		final EList<? extends EObject> Expr_669_list = AndExpression_669_Var
		.getExpr();
		Assert.assertNotNull(Expr_669_list);
		Assert.assertEquals(1, Expr_669_list.size());
		//669
		final EqualityExpression EqualityExpression_670_Var
		 = (EqualityExpression)Expr_669_list.get(0);
		Assert.assertNotNull(EqualityExpression_670_Var
		);
		final EList<? extends EObject> Expr_670_list = EqualityExpression_670_Var
		.getExpr();
		Assert.assertNotNull(Expr_670_list);
		Assert.assertEquals(1, Expr_670_list.size());
		//670
		final RelationalExpression RelationalExpression_671_Var
		 = (RelationalExpression)Expr_670_list.get(0);
		Assert.assertNotNull(RelationalExpression_671_Var
		);
		final EList<? extends EObject> Expr_671_list = RelationalExpression_671_Var
		.getExpr();
		Assert.assertNotNull(Expr_671_list);
		Assert.assertEquals(1, Expr_671_list.size());
		//671
		final ShiftExpression ShiftExpression_672_Var
		 = (ShiftExpression)Expr_671_list.get(0);
		Assert.assertNotNull(ShiftExpression_672_Var
		);
		final EList<? extends EObject> Expr_672_list = ShiftExpression_672_Var
		.getExpr();
		Assert.assertNotNull(Expr_672_list);
		Assert.assertEquals(1, Expr_672_list.size());
		//672
		final AdditiveExpression AdditiveExpression_673_Var
		 = (AdditiveExpression)Expr_672_list.get(0);
		Assert.assertNotNull(AdditiveExpression_673_Var
		);
		final EList<? extends EObject> Expr_673_list = AdditiveExpression_673_Var
		.getExpr();
		Assert.assertNotNull(Expr_673_list);
		Assert.assertEquals(1, Expr_673_list.size());
		//673
		final MultiplicativeExpression MultiplicativeExpression_674_Var
		 = (MultiplicativeExpression)Expr_673_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_674_Var
		);
		final EList<? extends EObject> Expr_674_list = MultiplicativeExpression_674_Var
		.getExpr();
		Assert.assertNotNull(Expr_674_list);
		Assert.assertEquals(1, Expr_674_list.size());
		//674
		final CastExpression CastExpression_675_Var
		 = (CastExpression)Expr_674_list.get(0);
		Assert.assertNotNull(CastExpression_675_Var
		);
		//675
		final UnaryExpression UnaryExpression_676_Var
		 = (UnaryExpression)CastExpression_675_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_676_Var
		);
		//676
		final PostfixExpression PostfixExpression_677_Var
		 = (PostfixExpression)UnaryExpression_676_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_677_Var
		);
		final EList<? extends EObject> Expr_677_list = PostfixExpression_677_Var
		.getExpr();
		Assert.assertNotNull(Expr_677_list);
		Assert.assertEquals(1, Expr_677_list.size());
		//677
		final PrimaryExpression PrimaryExpression_678_Var
		 = (PrimaryExpression)Expr_677_list.get(0);
		Assert.assertNotNull(PrimaryExpression_678_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_678_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_643_Var
		.getSemi());
		//678
		final Statement Statement_679_Var
		 = (Statement)Statement_351_list.get(7);
		Assert.assertNotNull(Statement_679_Var
		);
		//679
		final JumpStatement JumpStatement_680_Var
		 = (JumpStatement)Statement_679_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_680_Var
		);
		//680
		final Expression Expression_681_Var
		 = (Expression)JumpStatement_680_Var
		.getExpr();
		Assert.assertNotNull(Expression_681_Var
		);
		final EList<? extends EObject> ExprExpr_681_list = Expression_681_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_681_list);
		Assert.assertEquals(1, ExprExpr_681_list.size());
		//681
		final AssignmentExpression AssignmentExpression_682_Var
		 = (AssignmentExpression)ExprExpr_681_list.get(0);
		Assert.assertNotNull(AssignmentExpression_682_Var
		);
		//682
		final ConditionalExpression ConditionalExpression_683_Var
		 = (ConditionalExpression)AssignmentExpression_682_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_683_Var
		);
		//683
		final LogicalOrExpression LogicalOrExpression_684_Var
		 = (LogicalOrExpression)ConditionalExpression_683_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_684_Var
		);
		final EList<? extends EObject> Expr_684_list = LogicalOrExpression_684_Var
		.getExpr();
		Assert.assertNotNull(Expr_684_list);
		Assert.assertEquals(1, Expr_684_list.size());
		//684
		final LogicalAndExpression LogicalAndExpression_685_Var
		 = (LogicalAndExpression)Expr_684_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_685_Var
		);
		final EList<? extends EObject> Expr_685_list = LogicalAndExpression_685_Var
		.getExpr();
		Assert.assertNotNull(Expr_685_list);
		Assert.assertEquals(1, Expr_685_list.size());
		//685
		final InclusiveOrExpression InclusiveOrExpression_686_Var
		 = (InclusiveOrExpression)Expr_685_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_686_Var
		);
		final EList<? extends EObject> Expr_686_list = InclusiveOrExpression_686_Var
		.getExpr();
		Assert.assertNotNull(Expr_686_list);
		Assert.assertEquals(1, Expr_686_list.size());
		//686
		final ExclusiveOrExpression ExclusiveOrExpression_687_Var
		 = (ExclusiveOrExpression)Expr_686_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_687_Var
		);
		final EList<? extends EObject> Expr_687_list = ExclusiveOrExpression_687_Var
		.getExpr();
		Assert.assertNotNull(Expr_687_list);
		Assert.assertEquals(1, Expr_687_list.size());
		//687
		final AndExpression AndExpression_688_Var
		 = (AndExpression)Expr_687_list.get(0);
		Assert.assertNotNull(AndExpression_688_Var
		);
		final EList<? extends EObject> Expr_688_list = AndExpression_688_Var
		.getExpr();
		Assert.assertNotNull(Expr_688_list);
		Assert.assertEquals(1, Expr_688_list.size());
		//688
		final EqualityExpression EqualityExpression_689_Var
		 = (EqualityExpression)Expr_688_list.get(0);
		Assert.assertNotNull(EqualityExpression_689_Var
		);
		final EList<? extends EObject> Expr_689_list = EqualityExpression_689_Var
		.getExpr();
		Assert.assertNotNull(Expr_689_list);
		Assert.assertEquals(1, Expr_689_list.size());
		//689
		final RelationalExpression RelationalExpression_690_Var
		 = (RelationalExpression)Expr_689_list.get(0);
		Assert.assertNotNull(RelationalExpression_690_Var
		);
		final EList<? extends EObject> Expr_690_list = RelationalExpression_690_Var
		.getExpr();
		Assert.assertNotNull(Expr_690_list);
		Assert.assertEquals(1, Expr_690_list.size());
		//690
		final ShiftExpression ShiftExpression_691_Var
		 = (ShiftExpression)Expr_690_list.get(0);
		Assert.assertNotNull(ShiftExpression_691_Var
		);
		final EList<? extends EObject> Expr_691_list = ShiftExpression_691_Var
		.getExpr();
		Assert.assertNotNull(Expr_691_list);
		Assert.assertEquals(1, Expr_691_list.size());
		//691
		final AdditiveExpression AdditiveExpression_692_Var
		 = (AdditiveExpression)Expr_691_list.get(0);
		Assert.assertNotNull(AdditiveExpression_692_Var
		);
		final EList<? extends EObject> Expr_692_list = AdditiveExpression_692_Var
		.getExpr();
		Assert.assertNotNull(Expr_692_list);
		Assert.assertEquals(1, Expr_692_list.size());
		//692
		final MultiplicativeExpression MultiplicativeExpression_693_Var
		 = (MultiplicativeExpression)Expr_692_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_693_Var
		);
		final EList<? extends EObject> Expr_693_list = MultiplicativeExpression_693_Var
		.getExpr();
		Assert.assertNotNull(Expr_693_list);
		Assert.assertEquals(1, Expr_693_list.size());
		//693
		final CastExpression CastExpression_694_Var
		 = (CastExpression)Expr_693_list.get(0);
		Assert.assertNotNull(CastExpression_694_Var
		);
		//694
		final UnaryExpression UnaryExpression_695_Var
		 = (UnaryExpression)CastExpression_694_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_695_Var
		);
		//695
		final PostfixExpression PostfixExpression_696_Var
		 = (PostfixExpression)UnaryExpression_695_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_696_Var
		);
		final EList<? extends EObject> Expr_696_list = PostfixExpression_696_Var
		.getExpr();
		Assert.assertNotNull(Expr_696_list);
		Assert.assertEquals(1, Expr_696_list.size());
		//696
		final PrimaryExpression PrimaryExpression_697_Var
		 = (PrimaryExpression)Expr_696_list.get(0);
		Assert.assertNotNull(PrimaryExpression_697_Var
		);
		//697
		final Constant2 Constant2_698_Var
		 = (Constant2)PrimaryExpression_697_Var
		.getConst();
		Assert.assertNotNull(Constant2_698_Var
		);
		Assert.assertEquals("0", Constant2_698_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_680_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_680_Var
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


