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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
		Assert.assertEquals(5, External_1_list.size());
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
		Assert.assertEquals(2, DeclarationSpecifier_4_list.size());
		//4
		final StorageClassSpecifier StorageClassSpecifier_5_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_4_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_5_Var
		);
		Assert.assertEquals("typedef", StorageClassSpecifier_5_Var
		.getName());
		//5
		final StructOrUnionSpecifier StructOrUnionSpecifier_6_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_4_list.get(1);
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
		final Constant Constant_40_Var
		 = (Constant)PrimaryExpression_39_Var
		.getConst();
		Assert.assertNotNull(Constant_40_Var
		);
		Assert.assertEquals("250", Constant_40_Var
		.getDec());
		final EList<? extends EObject> InitDeclaratorList_40_list = Declaration_3_Var
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
		 = (ExternalDeclaration)External_1_list.get(1);
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
		final StructOrUnionSpecifier StructOrUnionSpecifier_48_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_47_list.get(0);
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
		Assert.assertEquals("empStruct", StructOrUnionSpecifier_48_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_49_list = Declaration_46_Var
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
		final Constant Constant_73_Var
		 = (Constant)PrimaryExpression_72_Var
		.getConst();
		Assert.assertNotNull(Constant_73_Var
		);
		Assert.assertEquals("0x007", Constant_73_Var
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
		//90
		final Constant Constant_91_Var
		 = (Constant)PrimaryExpression_90_Var
		.getConst();
		Assert.assertNotNull(Constant_91_Var
		);
		Assert.assertEquals("\"Joe Nobody\"", Constant_91_Var
		.getStr());
		//91
		final ExternalDeclaration ExternalDeclaration_92_Var
		 = (ExternalDeclaration)External_1_list.get(2);
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
		final Constant Constant_120_Var
		 = (Constant)PrimaryExpression_119_Var
		.getConst();
		Assert.assertNotNull(Constant_120_Var
		);
		Assert.assertEquals("0x008", Constant_120_Var
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
		//137
		final Constant Constant_138_Var
		 = (Constant)PrimaryExpression_137_Var
		.getConst();
		Assert.assertNotNull(Constant_138_Var
		);
		Assert.assertEquals("\"Phil Morrison\"", Constant_138_Var
		.getStr());
		//138
		final ExternalDeclaration ExternalDeclaration_139_Var
		 = (ExternalDeclaration)External_1_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_139_Var
		);
		//139
		final FunctionDefHead FunctionDefHead_140_Var
		 = (FunctionDefHead)ExternalDeclaration_139_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_140_Var
		);
		//140
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_141_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_140_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_141_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_141_list = FunctionDeclarationSpecifiers_141_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_141_list);
		Assert.assertEquals(1, DeclarationSpecifier_141_list.size());
		//141
		final TypeSpecifier TypeSpecifier_142_Var
		 = (TypeSpecifier)DeclarationSpecifier_141_list.get(0);
		Assert.assertNotNull(TypeSpecifier_142_Var
		);
		Assert.assertEquals("void", TypeSpecifier_142_Var
		.getName());
		//142
		final Declarator Declarator_143_Var
		 = (Declarator)FunctionDefHead_140_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_143_Var
		);
		//143
		final DirectDeclarator DirectDeclarator_144_Var
		 = (DirectDeclarator)Declarator_143_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_144_Var
		);
		Assert.assertEquals("print", DirectDeclarator_144_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_144_list = DirectDeclarator_144_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_144_list);
		Assert.assertEquals(1, DeclaratorSuffix_144_list.size());
		//144
		final DeclaratorSuffix DeclaratorSuffix_145_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_144_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_145_Var
		);
		//145
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_146_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_145_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_146_Var
		);
		final EList<? extends EObject> ParameterTypeList_146_list = DirectDeclaratorLastSuffix_146_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_146_list);
		Assert.assertEquals(1, ParameterTypeList_146_list.size());
		//146
		final ParameterTypeList ParameterTypeList_147_Var
		 = (ParameterTypeList)ParameterTypeList_146_list.get(0);
		Assert.assertNotNull(ParameterTypeList_147_Var
		);
		//147
		final ParameterList ParameterList_148_Var
		 = (ParameterList)ParameterTypeList_147_Var
		.getList();
		Assert.assertNotNull(ParameterList_148_Var
		);
		final EList<? extends EObject> ParameterDeclaration_148_list = ParameterList_148_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_148_list);
		Assert.assertEquals(1, ParameterDeclaration_148_list.size());
		//148
		final ParameterDeclaration ParameterDeclaration_149_Var
		 = (ParameterDeclaration)ParameterDeclaration_148_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_149_Var
		);
		//149
		final DeclarationSpecifiers DeclarationSpecifiers_150_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_149_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_150_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_150_list = DeclarationSpecifiers_150_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_150_list);
		Assert.assertEquals(1, DeclarationSpecifier_150_list.size());
		//150
		final TypeSpecifier TypeSpecifier_151_Var
		 = (TypeSpecifier)DeclarationSpecifier_150_list.get(0);
		Assert.assertNotNull(TypeSpecifier_151_Var
		);
		//151
		final TypedefName TypedefName_152_Var
		 = (TypedefName)TypeSpecifier_151_Var
		.getType();
		Assert.assertNotNull(TypedefName_152_Var
		);
		Assert.assertEquals("employee", TypedefName_152_Var
		.getId());
		//152
		final Declarator Declarator_153_Var
		 = (Declarator)ParameterDeclaration_149_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_153_Var
		);
		//153
		final DirectDeclarator DirectDeclarator_154_Var
		 = (DirectDeclarator)Declarator_153_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_154_Var
		);
		Assert.assertEquals("emp", DirectDeclarator_154_Var
		.getId());
		//154
		final Pointer Pointer_155_Var
		 = (Pointer)Declarator_153_Var
		.getPointer();
		Assert.assertNotNull(Pointer_155_Var
		);
		Assert.assertEquals("[*]", Pointer_155_Var
		.getStar().toString());
		//155
		final FunctionDefinition FunctionDefinition_156_Var
		 = (FunctionDefinition)ExternalDeclaration_139_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_156_Var
		);
		//156
		final BodyStatement BodyStatement_157_Var
		 = (BodyStatement)FunctionDefinition_156_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_157_Var
		);
		final EList<? extends EObject> BlockList_157_list = BodyStatement_157_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_157_list);
		Assert.assertEquals(1, BlockList_157_list.size());
		//157
		final BlockList BlockList_158_Var
		 = (BlockList)BlockList_157_list.get(0);
		Assert.assertNotNull(BlockList_158_Var
		);
		final EList<? extends EObject> Statement_158_list = BlockList_158_Var
		.getStatement();
		Assert.assertNotNull(Statement_158_list);
		Assert.assertEquals(2, Statement_158_list.size());
		//158
		final Statement Statement_159_Var
		 = (Statement)Statement_158_list.get(0);
		Assert.assertNotNull(Statement_159_Var
		);
		//159
		final ExpressionStatement ExpressionStatement_160_Var
		 = (ExpressionStatement)Statement_159_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_160_Var
		);
		//160
		final Expression Expression_161_Var
		 = (Expression)ExpressionStatement_160_Var
		.getExpression();
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
		Assert.assertEquals("printf", PrimaryExpression_177_Var
		.getId());
		final EList<? extends EObject> Suffix_177_list = PostfixExpression_176_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_177_list);
		Assert.assertEquals(1, Suffix_177_list.size());
		//177
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_178_Var
		 = (PostfixExpressionSuffixArgument)Suffix_177_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_178_Var
		);
		//178
		final ArgumentExpressionList ArgumentExpressionList_179_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_178_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_179_Var
		);
		final EList<? extends EObject> Expr_179_list = ArgumentExpressionList_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(2, Expr_179_list.size());
		//179
		final AssignmentExpression AssignmentExpression_180_Var
		 = (AssignmentExpression)Expr_179_list.get(0);
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
		//195
		final Constant Constant_196_Var
		 = (Constant)PrimaryExpression_195_Var
		.getConst();
		Assert.assertNotNull(Constant_196_Var
		);
		Assert.assertEquals("\"(*employee).id=%d\\n\"", Constant_196_Var
		.getStr());
		//196
		final AssignmentExpression AssignmentExpression_197_Var
		 = (AssignmentExpression)Expr_179_list.get(1);
		Assert.assertNotNull(AssignmentExpression_197_Var
		);
		//197
		final ConditionalExpression ConditionalExpression_198_Var
		 = (ConditionalExpression)AssignmentExpression_197_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_198_Var
		);
		//198
		final LogicalOrExpression LogicalOrExpression_199_Var
		 = (LogicalOrExpression)ConditionalExpression_198_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = LogicalOrExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final LogicalAndExpression LogicalAndExpression_200_Var
		 = (LogicalAndExpression)Expr_199_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = LogicalAndExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final InclusiveOrExpression InclusiveOrExpression_201_Var
		 = (InclusiveOrExpression)Expr_200_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = InclusiveOrExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final ExclusiveOrExpression ExclusiveOrExpression_202_Var
		 = (ExclusiveOrExpression)Expr_201_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = ExclusiveOrExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final AndExpression AndExpression_203_Var
		 = (AndExpression)Expr_202_list.get(0);
		Assert.assertNotNull(AndExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = AndExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final EqualityExpression EqualityExpression_204_Var
		 = (EqualityExpression)Expr_203_list.get(0);
		Assert.assertNotNull(EqualityExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = EqualityExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final RelationalExpression RelationalExpression_205_Var
		 = (RelationalExpression)Expr_204_list.get(0);
		Assert.assertNotNull(RelationalExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = RelationalExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final ShiftExpression ShiftExpression_206_Var
		 = (ShiftExpression)Expr_205_list.get(0);
		Assert.assertNotNull(ShiftExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = ShiftExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final AdditiveExpression AdditiveExpression_207_Var
		 = (AdditiveExpression)Expr_206_list.get(0);
		Assert.assertNotNull(AdditiveExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = AdditiveExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final MultiplicativeExpression MultiplicativeExpression_208_Var
		 = (MultiplicativeExpression)Expr_207_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = MultiplicativeExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final CastExpression CastExpression_209_Var
		 = (CastExpression)Expr_208_list.get(0);
		Assert.assertNotNull(CastExpression_209_Var
		);
		//209
		final UnaryExpression UnaryExpression_210_Var
		 = (UnaryExpression)CastExpression_209_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_210_Var
		);
		//210
		final PostfixExpression PostfixExpression_211_Var
		 = (PostfixExpression)UnaryExpression_210_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = PostfixExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final PrimaryExpression PrimaryExpression_212_Var
		 = (PrimaryExpression)Expr_211_list.get(0);
		Assert.assertNotNull(PrimaryExpression_212_Var
		);
		//212
		final Expression Expression_213_Var
		 = (Expression)PrimaryExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expression_213_Var
		);
		final EList<? extends EObject> ExprExpr_213_list = Expression_213_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_213_list);
		Assert.assertEquals(1, ExprExpr_213_list.size());
		//213
		final AssignmentExpression AssignmentExpression_214_Var
		 = (AssignmentExpression)ExprExpr_213_list.get(0);
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
		//227
		final UnaryOperator UnaryOperator_228_Var
		 = (UnaryOperator)UnaryExpression_227_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_228_Var
		);
		Assert.assertEquals("*", UnaryOperator_228_Var
		.getOp());
		//228
		final CastExpression CastExpression_229_Var
		 = (CastExpression)UnaryExpression_227_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_229_Var
		);
		//229
		final UnaryExpression UnaryExpression_230_Var
		 = (UnaryExpression)CastExpression_229_Var
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
		Assert.assertEquals("emp", PrimaryExpression_232_Var
		.getId());
		final EList<? extends EObject> Suffix_232_list = PostfixExpression_211_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_232_list);
		Assert.assertEquals(1, Suffix_232_list.size());
		//232
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_233_Var
		 = (PostfixExpressionSuffixDot)Suffix_232_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_233_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_233_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_160_Var
		.getSemi());
		//233
		final Statement Statement_234_Var
		 = (Statement)Statement_158_list.get(1);
		Assert.assertNotNull(Statement_234_Var
		);
		//234
		final ExpressionStatement ExpressionStatement_235_Var
		 = (ExpressionStatement)Statement_234_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_235_Var
		);
		//235
		final Expression Expression_236_Var
		 = (Expression)ExpressionStatement_235_Var
		.getExpression();
		Assert.assertNotNull(Expression_236_Var
		);
		final EList<? extends EObject> ExprExpr_236_list = Expression_236_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_236_list);
		Assert.assertEquals(1, ExprExpr_236_list.size());
		//236
		final AssignmentExpression AssignmentExpression_237_Var
		 = (AssignmentExpression)ExprExpr_236_list.get(0);
		Assert.assertNotNull(AssignmentExpression_237_Var
		);
		//237
		final ConditionalExpression ConditionalExpression_238_Var
		 = (ConditionalExpression)AssignmentExpression_237_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_238_Var
		);
		//238
		final LogicalOrExpression LogicalOrExpression_239_Var
		 = (LogicalOrExpression)ConditionalExpression_238_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = LogicalOrExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final LogicalAndExpression LogicalAndExpression_240_Var
		 = (LogicalAndExpression)Expr_239_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = LogicalAndExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final InclusiveOrExpression InclusiveOrExpression_241_Var
		 = (InclusiveOrExpression)Expr_240_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = InclusiveOrExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final ExclusiveOrExpression ExclusiveOrExpression_242_Var
		 = (ExclusiveOrExpression)Expr_241_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = ExclusiveOrExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final AndExpression AndExpression_243_Var
		 = (AndExpression)Expr_242_list.get(0);
		Assert.assertNotNull(AndExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = AndExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final EqualityExpression EqualityExpression_244_Var
		 = (EqualityExpression)Expr_243_list.get(0);
		Assert.assertNotNull(EqualityExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = EqualityExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final RelationalExpression RelationalExpression_245_Var
		 = (RelationalExpression)Expr_244_list.get(0);
		Assert.assertNotNull(RelationalExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = RelationalExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final ShiftExpression ShiftExpression_246_Var
		 = (ShiftExpression)Expr_245_list.get(0);
		Assert.assertNotNull(ShiftExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = ShiftExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final AdditiveExpression AdditiveExpression_247_Var
		 = (AdditiveExpression)Expr_246_list.get(0);
		Assert.assertNotNull(AdditiveExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = AdditiveExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final MultiplicativeExpression MultiplicativeExpression_248_Var
		 = (MultiplicativeExpression)Expr_247_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = MultiplicativeExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final CastExpression CastExpression_249_Var
		 = (CastExpression)Expr_248_list.get(0);
		Assert.assertNotNull(CastExpression_249_Var
		);
		//249
		final UnaryExpression UnaryExpression_250_Var
		 = (UnaryExpression)CastExpression_249_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_250_Var
		);
		//250
		final PostfixExpression PostfixExpression_251_Var
		 = (PostfixExpression)UnaryExpression_250_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = PostfixExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final PrimaryExpression PrimaryExpression_252_Var
		 = (PrimaryExpression)Expr_251_list.get(0);
		Assert.assertNotNull(PrimaryExpression_252_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_252_Var
		.getId());
		final EList<? extends EObject> Suffix_252_list = PostfixExpression_251_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_252_list);
		Assert.assertEquals(1, Suffix_252_list.size());
		//252
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_253_Var
		 = (PostfixExpressionSuffixArgument)Suffix_252_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_253_Var
		);
		//253
		final ArgumentExpressionList ArgumentExpressionList_254_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_253_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_254_Var
		);
		final EList<? extends EObject> Expr_254_list = ArgumentExpressionList_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(2, Expr_254_list.size());
		//254
		final AssignmentExpression AssignmentExpression_255_Var
		 = (AssignmentExpression)Expr_254_list.get(0);
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
		//270
		final Constant Constant_271_Var
		 = (Constant)PrimaryExpression_270_Var
		.getConst();
		Assert.assertNotNull(Constant_271_Var
		);
		Assert.assertEquals("\"employee->name=%s\\n\"", Constant_271_Var
		.getStr());
		//271
		final AssignmentExpression AssignmentExpression_272_Var
		 = (AssignmentExpression)Expr_254_list.get(1);
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
		Assert.assertEquals("emp", PrimaryExpression_287_Var
		.getId());
		final EList<? extends EObject> Suffix_287_list = PostfixExpression_286_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_287_list);
		Assert.assertEquals(1, Suffix_287_list.size());
		//287
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_288_Var
		 = (PostfixExpressionSuffixArrow)Suffix_287_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArrow_288_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixArrow_288_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_235_Var
		.getSemi());
		//288
		final ExternalDeclaration ExternalDeclaration_289_Var
		 = (ExternalDeclaration)External_1_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_289_Var
		);
		//289
		final FunctionDefHead FunctionDefHead_290_Var
		 = (FunctionDefHead)ExternalDeclaration_289_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_290_Var
		);
		//290
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_291_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_290_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_291_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_291_list = FunctionDeclarationSpecifiers_291_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_291_list);
		Assert.assertEquals(1, DeclarationSpecifier_291_list.size());
		//291
		final TypeSpecifier TypeSpecifier_292_Var
		 = (TypeSpecifier)DeclarationSpecifier_291_list.get(0);
		Assert.assertNotNull(TypeSpecifier_292_Var
		);
		Assert.assertEquals("int", TypeSpecifier_292_Var
		.getName());
		//292
		final Declarator Declarator_293_Var
		 = (Declarator)FunctionDefHead_290_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_293_Var
		);
		//293
		final DirectDeclarator DirectDeclarator_294_Var
		 = (DirectDeclarator)Declarator_293_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_294_Var
		);
		Assert.assertEquals("main", DirectDeclarator_294_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_294_list = DirectDeclarator_294_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_294_list);
		Assert.assertEquals(1, DeclaratorSuffix_294_list.size());
		//294
		final DeclaratorSuffix DeclaratorSuffix_295_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_294_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_295_Var
		);
		//295
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_296_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_295_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_296_Var
		);
		final EList<? extends EObject> ParameterTypeList_296_list = DirectDeclaratorLastSuffix_296_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_296_list);
		Assert.assertEquals(1, ParameterTypeList_296_list.size());
		//296
		final ParameterTypeList ParameterTypeList_297_Var
		 = (ParameterTypeList)ParameterTypeList_296_list.get(0);
		Assert.assertNotNull(ParameterTypeList_297_Var
		);
		//297
		final ParameterList ParameterList_298_Var
		 = (ParameterList)ParameterTypeList_297_Var
		.getList();
		Assert.assertNotNull(ParameterList_298_Var
		);
		final EList<? extends EObject> ParameterDeclaration_298_list = ParameterList_298_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_298_list);
		Assert.assertEquals(1, ParameterDeclaration_298_list.size());
		//298
		final ParameterDeclaration ParameterDeclaration_299_Var
		 = (ParameterDeclaration)ParameterDeclaration_298_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_299_Var
		);
		//299
		final DeclarationSpecifiers DeclarationSpecifiers_300_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_299_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_300_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_300_list = DeclarationSpecifiers_300_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_300_list);
		Assert.assertEquals(1, DeclarationSpecifier_300_list.size());
		//300
		final TypeSpecifier TypeSpecifier_301_Var
		 = (TypeSpecifier)DeclarationSpecifier_300_list.get(0);
		Assert.assertNotNull(TypeSpecifier_301_Var
		);
		Assert.assertEquals("void", TypeSpecifier_301_Var
		.getName());
		//301
		final FunctionDefinition FunctionDefinition_302_Var
		 = (FunctionDefinition)ExternalDeclaration_289_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_302_Var
		);
		//302
		final BodyStatement BodyStatement_303_Var
		 = (BodyStatement)FunctionDefinition_302_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_303_Var
		);
		final EList<? extends EObject> BlockList_303_list = BodyStatement_303_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_303_list);
		Assert.assertEquals(1, BlockList_303_list.size());
		//303
		final BlockList BlockList_304_Var
		 = (BlockList)BlockList_303_list.get(0);
		Assert.assertNotNull(BlockList_304_Var
		);
		final EList<? extends EObject> Declaration_304_list = BlockList_304_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_304_list);
		Assert.assertEquals(1, Declaration_304_list.size());
		//304
		final Declaration Declaration_305_Var
		 = (Declaration)Declaration_304_list.get(0);
		Assert.assertNotNull(Declaration_305_Var
		);
		//305
		final DeclarationSpecifiers DeclarationSpecifiers_306_Var
		 = (DeclarationSpecifiers)Declaration_305_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_306_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_306_list = DeclarationSpecifiers_306_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_306_list);
		Assert.assertEquals(1, DeclarationSpecifier_306_list.size());
		//306
		final TypeSpecifier TypeSpecifier_307_Var
		 = (TypeSpecifier)DeclarationSpecifier_306_list.get(0);
		Assert.assertNotNull(TypeSpecifier_307_Var
		);
		//307
		final TypedefName TypedefName_308_Var
		 = (TypedefName)TypeSpecifier_307_Var
		.getType();
		Assert.assertNotNull(TypedefName_308_Var
		);
		Assert.assertEquals("employee", TypedefName_308_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_308_list = Declaration_305_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_308_list);
		Assert.assertEquals(1, InitDeclaratorList_308_list.size());
		//308
		final InitDeclaratorList InitDeclaratorList_309_Var
		 = (InitDeclaratorList)InitDeclaratorList_308_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_309_Var
		);
		final EList<? extends EObject> InitDeclarator_309_list = InitDeclaratorList_309_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_309_list);
		Assert.assertEquals(1, InitDeclarator_309_list.size());
		//309
		final InitDeclarator InitDeclarator_310_Var
		 = (InitDeclarator)InitDeclarator_309_list.get(0);
		Assert.assertNotNull(InitDeclarator_310_Var
		);
		//310
		final Declarator Declarator_311_Var
		 = (Declarator)InitDeclarator_310_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_311_Var
		);
		//311
		final Pointer Pointer_312_Var
		 = (Pointer)Declarator_311_Var
		.getPointer();
		Assert.assertNotNull(Pointer_312_Var
		);
		Assert.assertEquals("[*]", Pointer_312_Var
		.getStar().toString());
		//312
		final DirectDeclarator DirectDeclarator_313_Var
		 = (DirectDeclarator)Declarator_311_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_313_Var
		);
		Assert.assertEquals("newEmployee", DirectDeclarator_313_Var
		.getId());
		//313
		final Initializer Initializer_314_Var
		 = (Initializer)InitDeclarator_310_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_314_Var
		);
		//314
		final AssignmentExpression AssignmentExpression_315_Var
		 = (AssignmentExpression)Initializer_314_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_315_Var
		);
		//315
		final ConditionalExpression ConditionalExpression_316_Var
		 = (ConditionalExpression)AssignmentExpression_315_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_316_Var
		);
		//316
		final LogicalOrExpression LogicalOrExpression_317_Var
		 = (LogicalOrExpression)ConditionalExpression_316_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_317_Var
		);
		final EList<? extends EObject> Expr_317_list = LogicalOrExpression_317_Var
		.getExpr();
		Assert.assertNotNull(Expr_317_list);
		Assert.assertEquals(1, Expr_317_list.size());
		//317
		final LogicalAndExpression LogicalAndExpression_318_Var
		 = (LogicalAndExpression)Expr_317_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_318_Var
		);
		final EList<? extends EObject> Expr_318_list = LogicalAndExpression_318_Var
		.getExpr();
		Assert.assertNotNull(Expr_318_list);
		Assert.assertEquals(1, Expr_318_list.size());
		//318
		final InclusiveOrExpression InclusiveOrExpression_319_Var
		 = (InclusiveOrExpression)Expr_318_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_319_Var
		);
		final EList<? extends EObject> Expr_319_list = InclusiveOrExpression_319_Var
		.getExpr();
		Assert.assertNotNull(Expr_319_list);
		Assert.assertEquals(1, Expr_319_list.size());
		//319
		final ExclusiveOrExpression ExclusiveOrExpression_320_Var
		 = (ExclusiveOrExpression)Expr_319_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_320_Var
		);
		final EList<? extends EObject> Expr_320_list = ExclusiveOrExpression_320_Var
		.getExpr();
		Assert.assertNotNull(Expr_320_list);
		Assert.assertEquals(1, Expr_320_list.size());
		//320
		final AndExpression AndExpression_321_Var
		 = (AndExpression)Expr_320_list.get(0);
		Assert.assertNotNull(AndExpression_321_Var
		);
		final EList<? extends EObject> Expr_321_list = AndExpression_321_Var
		.getExpr();
		Assert.assertNotNull(Expr_321_list);
		Assert.assertEquals(1, Expr_321_list.size());
		//321
		final EqualityExpression EqualityExpression_322_Var
		 = (EqualityExpression)Expr_321_list.get(0);
		Assert.assertNotNull(EqualityExpression_322_Var
		);
		final EList<? extends EObject> Expr_322_list = EqualityExpression_322_Var
		.getExpr();
		Assert.assertNotNull(Expr_322_list);
		Assert.assertEquals(1, Expr_322_list.size());
		//322
		final RelationalExpression RelationalExpression_323_Var
		 = (RelationalExpression)Expr_322_list.get(0);
		Assert.assertNotNull(RelationalExpression_323_Var
		);
		final EList<? extends EObject> Expr_323_list = RelationalExpression_323_Var
		.getExpr();
		Assert.assertNotNull(Expr_323_list);
		Assert.assertEquals(1, Expr_323_list.size());
		//323
		final ShiftExpression ShiftExpression_324_Var
		 = (ShiftExpression)Expr_323_list.get(0);
		Assert.assertNotNull(ShiftExpression_324_Var
		);
		final EList<? extends EObject> Expr_324_list = ShiftExpression_324_Var
		.getExpr();
		Assert.assertNotNull(Expr_324_list);
		Assert.assertEquals(1, Expr_324_list.size());
		//324
		final AdditiveExpression AdditiveExpression_325_Var
		 = (AdditiveExpression)Expr_324_list.get(0);
		Assert.assertNotNull(AdditiveExpression_325_Var
		);
		final EList<? extends EObject> Expr_325_list = AdditiveExpression_325_Var
		.getExpr();
		Assert.assertNotNull(Expr_325_list);
		Assert.assertEquals(1, Expr_325_list.size());
		//325
		final MultiplicativeExpression MultiplicativeExpression_326_Var
		 = (MultiplicativeExpression)Expr_325_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_326_Var
		);
		final EList<? extends EObject> Expr_326_list = MultiplicativeExpression_326_Var
		.getExpr();
		Assert.assertNotNull(Expr_326_list);
		Assert.assertEquals(1, Expr_326_list.size());
		//326
		final CastExpression CastExpression_327_Var
		 = (CastExpression)Expr_326_list.get(0);
		Assert.assertNotNull(CastExpression_327_Var
		);
		//327
		final UnaryExpression UnaryExpression_328_Var
		 = (UnaryExpression)CastExpression_327_Var
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
		Assert.assertEquals("malloc", PrimaryExpression_330_Var
		.getId());
		final EList<? extends EObject> Suffix_330_list = PostfixExpression_329_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_330_list);
		Assert.assertEquals(1, Suffix_330_list.size());
		//330
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_331_Var
		 = (PostfixExpressionSuffixArgument)Suffix_330_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_331_Var
		);
		//331
		final ArgumentExpressionList ArgumentExpressionList_332_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_331_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_332_Var
		);
		final EList<? extends EObject> Expr_332_list = ArgumentExpressionList_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final AssignmentExpression AssignmentExpression_333_Var
		 = (AssignmentExpression)Expr_332_list.get(0);
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
		Assert.assertEquals("sizeof", UnaryExpression_346_Var
		.getSizeOf());
		//346
		final TypeName TypeName_347_Var
		 = (TypeName)UnaryExpression_346_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_347_Var
		);
		//347
		final SpecifierQualifierList SpecifierQualifierList_348_Var
		 = (SpecifierQualifierList)TypeName_347_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_348_Var
		);
		final EList<? extends EObject> TypeSpecifier_348_list = SpecifierQualifierList_348_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_348_list);
		Assert.assertEquals(1, TypeSpecifier_348_list.size());
		//348
		final TypeSpecifier TypeSpecifier_349_Var
		 = (TypeSpecifier)TypeSpecifier_348_list.get(0);
		Assert.assertNotNull(TypeSpecifier_349_Var
		);
		//349
		final TypedefName TypedefName_350_Var
		 = (TypedefName)TypeSpecifier_349_Var
		.getType();
		Assert.assertNotNull(TypedefName_350_Var
		);
		Assert.assertEquals("employee", TypedefName_350_Var
		.getId());
		final EList<? extends EObject> Statement_350_list = BlockList_304_Var
		.getStatement();
		Assert.assertNotNull(Statement_350_list);
		Assert.assertEquals(8, Statement_350_list.size());
		//350
		final Statement Statement_351_Var
		 = (Statement)Statement_350_list.get(0);
		Assert.assertNotNull(Statement_351_Var
		);
		//351
		final SelectionStatement SelectionStatement_352_Var
		 = (SelectionStatement)Statement_351_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_352_Var
		);
		Assert.assertEquals("if", SelectionStatement_352_Var
		.getIf());
		//352
		final Expression Expression_353_Var
		 = (Expression)SelectionStatement_352_Var
		.getExpr();
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
		Assert.assertEquals("[==]", EqualityExpression_361_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_361_list = EqualityExpression_361_Var
		.getExpr();
		Assert.assertNotNull(Expr_361_list);
		Assert.assertEquals(2, Expr_361_list.size());
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
		Assert.assertEquals("newEmployee", PrimaryExpression_369_Var
		.getId());
		//369
		final RelationalExpression RelationalExpression_370_Var
		 = (RelationalExpression)Expr_361_list.get(1);
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
		Assert.assertEquals("NULL", PrimaryExpression_377_Var
		.getId());
		//377
		final Statement Statement_378_Var
		 = (Statement)SelectionStatement_352_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_378_Var
		);
		//378
		final CompoundStatement CompoundStatement_379_Var
		 = (CompoundStatement)Statement_378_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_379_Var
		);
		//379
		final BodyStatement BodyStatement_380_Var
		 = (BodyStatement)CompoundStatement_379_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_380_Var
		);
		final EList<? extends EObject> BlockList_380_list = BodyStatement_380_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_380_list);
		Assert.assertEquals(1, BlockList_380_list.size());
		//380
		final BlockList BlockList_381_Var
		 = (BlockList)BlockList_380_list.get(0);
		Assert.assertNotNull(BlockList_381_Var
		);
		final EList<? extends EObject> Statement_381_list = BlockList_381_Var
		.getStatement();
		Assert.assertNotNull(Statement_381_list);
		Assert.assertEquals(2, Statement_381_list.size());
		//381
		final Statement Statement_382_Var
		 = (Statement)Statement_381_list.get(0);
		Assert.assertNotNull(Statement_382_Var
		);
		//382
		final ExpressionStatement ExpressionStatement_383_Var
		 = (ExpressionStatement)Statement_382_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_383_Var
		);
		//383
		final Expression Expression_384_Var
		 = (Expression)ExpressionStatement_383_Var
		.getExpression();
		Assert.assertNotNull(Expression_384_Var
		);
		final EList<? extends EObject> ExprExpr_384_list = Expression_384_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_384_list);
		Assert.assertEquals(1, ExprExpr_384_list.size());
		//384
		final AssignmentExpression AssignmentExpression_385_Var
		 = (AssignmentExpression)ExprExpr_384_list.get(0);
		Assert.assertNotNull(AssignmentExpression_385_Var
		);
		//385
		final ConditionalExpression ConditionalExpression_386_Var
		 = (ConditionalExpression)AssignmentExpression_385_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_386_Var
		);
		//386
		final LogicalOrExpression LogicalOrExpression_387_Var
		 = (LogicalOrExpression)ConditionalExpression_386_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_387_Var
		);
		final EList<? extends EObject> Expr_387_list = LogicalOrExpression_387_Var
		.getExpr();
		Assert.assertNotNull(Expr_387_list);
		Assert.assertEquals(1, Expr_387_list.size());
		//387
		final LogicalAndExpression LogicalAndExpression_388_Var
		 = (LogicalAndExpression)Expr_387_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_388_Var
		);
		final EList<? extends EObject> Expr_388_list = LogicalAndExpression_388_Var
		.getExpr();
		Assert.assertNotNull(Expr_388_list);
		Assert.assertEquals(1, Expr_388_list.size());
		//388
		final InclusiveOrExpression InclusiveOrExpression_389_Var
		 = (InclusiveOrExpression)Expr_388_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_389_Var
		);
		final EList<? extends EObject> Expr_389_list = InclusiveOrExpression_389_Var
		.getExpr();
		Assert.assertNotNull(Expr_389_list);
		Assert.assertEquals(1, Expr_389_list.size());
		//389
		final ExclusiveOrExpression ExclusiveOrExpression_390_Var
		 = (ExclusiveOrExpression)Expr_389_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_390_Var
		);
		final EList<? extends EObject> Expr_390_list = ExclusiveOrExpression_390_Var
		.getExpr();
		Assert.assertNotNull(Expr_390_list);
		Assert.assertEquals(1, Expr_390_list.size());
		//390
		final AndExpression AndExpression_391_Var
		 = (AndExpression)Expr_390_list.get(0);
		Assert.assertNotNull(AndExpression_391_Var
		);
		final EList<? extends EObject> Expr_391_list = AndExpression_391_Var
		.getExpr();
		Assert.assertNotNull(Expr_391_list);
		Assert.assertEquals(1, Expr_391_list.size());
		//391
		final EqualityExpression EqualityExpression_392_Var
		 = (EqualityExpression)Expr_391_list.get(0);
		Assert.assertNotNull(EqualityExpression_392_Var
		);
		final EList<? extends EObject> Expr_392_list = EqualityExpression_392_Var
		.getExpr();
		Assert.assertNotNull(Expr_392_list);
		Assert.assertEquals(1, Expr_392_list.size());
		//392
		final RelationalExpression RelationalExpression_393_Var
		 = (RelationalExpression)Expr_392_list.get(0);
		Assert.assertNotNull(RelationalExpression_393_Var
		);
		final EList<? extends EObject> Expr_393_list = RelationalExpression_393_Var
		.getExpr();
		Assert.assertNotNull(Expr_393_list);
		Assert.assertEquals(1, Expr_393_list.size());
		//393
		final ShiftExpression ShiftExpression_394_Var
		 = (ShiftExpression)Expr_393_list.get(0);
		Assert.assertNotNull(ShiftExpression_394_Var
		);
		final EList<? extends EObject> Expr_394_list = ShiftExpression_394_Var
		.getExpr();
		Assert.assertNotNull(Expr_394_list);
		Assert.assertEquals(1, Expr_394_list.size());
		//394
		final AdditiveExpression AdditiveExpression_395_Var
		 = (AdditiveExpression)Expr_394_list.get(0);
		Assert.assertNotNull(AdditiveExpression_395_Var
		);
		final EList<? extends EObject> Expr_395_list = AdditiveExpression_395_Var
		.getExpr();
		Assert.assertNotNull(Expr_395_list);
		Assert.assertEquals(1, Expr_395_list.size());
		//395
		final MultiplicativeExpression MultiplicativeExpression_396_Var
		 = (MultiplicativeExpression)Expr_395_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_396_Var
		);
		final EList<? extends EObject> Expr_396_list = MultiplicativeExpression_396_Var
		.getExpr();
		Assert.assertNotNull(Expr_396_list);
		Assert.assertEquals(1, Expr_396_list.size());
		//396
		final CastExpression CastExpression_397_Var
		 = (CastExpression)Expr_396_list.get(0);
		Assert.assertNotNull(CastExpression_397_Var
		);
		//397
		final UnaryExpression UnaryExpression_398_Var
		 = (UnaryExpression)CastExpression_397_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_398_Var
		);
		//398
		final PostfixExpression PostfixExpression_399_Var
		 = (PostfixExpression)UnaryExpression_398_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_399_Var
		);
		final EList<? extends EObject> Expr_399_list = PostfixExpression_399_Var
		.getExpr();
		Assert.assertNotNull(Expr_399_list);
		Assert.assertEquals(1, Expr_399_list.size());
		//399
		final PrimaryExpression PrimaryExpression_400_Var
		 = (PrimaryExpression)Expr_399_list.get(0);
		Assert.assertNotNull(PrimaryExpression_400_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_400_Var
		.getId());
		final EList<? extends EObject> Suffix_400_list = PostfixExpression_399_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_400_list);
		Assert.assertEquals(1, Suffix_400_list.size());
		//400
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_401_Var
		 = (PostfixExpressionSuffixArgument)Suffix_400_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_401_Var
		);
		//401
		final ArgumentExpressionList ArgumentExpressionList_402_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_401_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_402_Var
		);
		final EList<? extends EObject> Expr_402_list = ArgumentExpressionList_402_Var
		.getExpr();
		Assert.assertNotNull(Expr_402_list);
		Assert.assertEquals(1, Expr_402_list.size());
		//402
		final AssignmentExpression AssignmentExpression_403_Var
		 = (AssignmentExpression)Expr_402_list.get(0);
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
		//418
		final Constant Constant_419_Var
		 = (Constant)PrimaryExpression_418_Var
		.getConst();
		Assert.assertNotNull(Constant_419_Var
		);
		Assert.assertEquals("\"Could not reserve space for new employee!\\n\"", Constant_419_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_383_Var
		.getSemi());
		//419
		final Statement Statement_420_Var
		 = (Statement)Statement_381_list.get(1);
		Assert.assertNotNull(Statement_420_Var
		);
		//420
		final JumpStatement JumpStatement_421_Var
		 = (JumpStatement)Statement_420_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_421_Var
		);
		//421
		final Expression Expression_422_Var
		 = (Expression)JumpStatement_421_Var
		.getExpr();
		Assert.assertNotNull(Expression_422_Var
		);
		final EList<? extends EObject> ExprExpr_422_list = Expression_422_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_422_list);
		Assert.assertEquals(1, ExprExpr_422_list.size());
		//422
		final AssignmentExpression AssignmentExpression_423_Var
		 = (AssignmentExpression)ExprExpr_422_list.get(0);
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
		final UnaryOperator UnaryOperator_437_Var
		 = (UnaryOperator)UnaryExpression_436_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_437_Var
		);
		Assert.assertEquals("-", UnaryOperator_437_Var
		.getOp());
		//437
		final CastExpression CastExpression_438_Var
		 = (CastExpression)UnaryExpression_436_Var
		.getExpr();
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
		final Constant Constant_442_Var
		 = (Constant)PrimaryExpression_441_Var
		.getConst();
		Assert.assertNotNull(Constant_442_Var
		);
		Assert.assertEquals("1", Constant_442_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_421_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_421_Var
		.getSemi());
		//442
		final Statement Statement_443_Var
		 = (Statement)Statement_350_list.get(1);
		Assert.assertNotNull(Statement_443_Var
		);
		//443
		final ExpressionStatement ExpressionStatement_444_Var
		 = (ExpressionStatement)Statement_443_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_444_Var
		);
		//444
		final Expression Expression_445_Var
		 = (Expression)ExpressionStatement_444_Var
		.getExpression();
		Assert.assertNotNull(Expression_445_Var
		);
		final EList<? extends EObject> ExprExpr_445_list = Expression_445_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_445_list);
		Assert.assertEquals(1, ExprExpr_445_list.size());
		//445
		final AssignmentExpression AssignmentExpression_446_Var
		 = (AssignmentExpression)ExprExpr_445_list.get(0);
		Assert.assertNotNull(AssignmentExpression_446_Var
		);
		//446
		final ConditionalExpression ConditionalExpression_447_Var
		 = (ConditionalExpression)AssignmentExpression_446_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_447_Var
		);
		//447
		final LogicalOrExpression LogicalOrExpression_448_Var
		 = (LogicalOrExpression)ConditionalExpression_447_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_448_Var
		);
		final EList<? extends EObject> Expr_448_list = LogicalOrExpression_448_Var
		.getExpr();
		Assert.assertNotNull(Expr_448_list);
		Assert.assertEquals(1, Expr_448_list.size());
		//448
		final LogicalAndExpression LogicalAndExpression_449_Var
		 = (LogicalAndExpression)Expr_448_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_449_Var
		);
		final EList<? extends EObject> Expr_449_list = LogicalAndExpression_449_Var
		.getExpr();
		Assert.assertNotNull(Expr_449_list);
		Assert.assertEquals(1, Expr_449_list.size());
		//449
		final InclusiveOrExpression InclusiveOrExpression_450_Var
		 = (InclusiveOrExpression)Expr_449_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_450_Var
		);
		final EList<? extends EObject> Expr_450_list = InclusiveOrExpression_450_Var
		.getExpr();
		Assert.assertNotNull(Expr_450_list);
		Assert.assertEquals(1, Expr_450_list.size());
		//450
		final ExclusiveOrExpression ExclusiveOrExpression_451_Var
		 = (ExclusiveOrExpression)Expr_450_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_451_Var
		);
		final EList<? extends EObject> Expr_451_list = ExclusiveOrExpression_451_Var
		.getExpr();
		Assert.assertNotNull(Expr_451_list);
		Assert.assertEquals(1, Expr_451_list.size());
		//451
		final AndExpression AndExpression_452_Var
		 = (AndExpression)Expr_451_list.get(0);
		Assert.assertNotNull(AndExpression_452_Var
		);
		final EList<? extends EObject> Expr_452_list = AndExpression_452_Var
		.getExpr();
		Assert.assertNotNull(Expr_452_list);
		Assert.assertEquals(1, Expr_452_list.size());
		//452
		final EqualityExpression EqualityExpression_453_Var
		 = (EqualityExpression)Expr_452_list.get(0);
		Assert.assertNotNull(EqualityExpression_453_Var
		);
		final EList<? extends EObject> Expr_453_list = EqualityExpression_453_Var
		.getExpr();
		Assert.assertNotNull(Expr_453_list);
		Assert.assertEquals(1, Expr_453_list.size());
		//453
		final RelationalExpression RelationalExpression_454_Var
		 = (RelationalExpression)Expr_453_list.get(0);
		Assert.assertNotNull(RelationalExpression_454_Var
		);
		final EList<? extends EObject> Expr_454_list = RelationalExpression_454_Var
		.getExpr();
		Assert.assertNotNull(Expr_454_list);
		Assert.assertEquals(1, Expr_454_list.size());
		//454
		final ShiftExpression ShiftExpression_455_Var
		 = (ShiftExpression)Expr_454_list.get(0);
		Assert.assertNotNull(ShiftExpression_455_Var
		);
		final EList<? extends EObject> Expr_455_list = ShiftExpression_455_Var
		.getExpr();
		Assert.assertNotNull(Expr_455_list);
		Assert.assertEquals(1, Expr_455_list.size());
		//455
		final AdditiveExpression AdditiveExpression_456_Var
		 = (AdditiveExpression)Expr_455_list.get(0);
		Assert.assertNotNull(AdditiveExpression_456_Var
		);
		final EList<? extends EObject> Expr_456_list = AdditiveExpression_456_Var
		.getExpr();
		Assert.assertNotNull(Expr_456_list);
		Assert.assertEquals(1, Expr_456_list.size());
		//456
		final MultiplicativeExpression MultiplicativeExpression_457_Var
		 = (MultiplicativeExpression)Expr_456_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_457_Var
		);
		final EList<? extends EObject> Expr_457_list = MultiplicativeExpression_457_Var
		.getExpr();
		Assert.assertNotNull(Expr_457_list);
		Assert.assertEquals(1, Expr_457_list.size());
		//457
		final CastExpression CastExpression_458_Var
		 = (CastExpression)Expr_457_list.get(0);
		Assert.assertNotNull(CastExpression_458_Var
		);
		//458
		final UnaryExpression UnaryExpression_459_Var
		 = (UnaryExpression)CastExpression_458_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_459_Var
		);
		//459
		final PostfixExpression PostfixExpression_460_Var
		 = (PostfixExpression)UnaryExpression_459_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_460_Var
		);
		final EList<? extends EObject> Expr_460_list = PostfixExpression_460_Var
		.getExpr();
		Assert.assertNotNull(Expr_460_list);
		Assert.assertEquals(1, Expr_460_list.size());
		//460
		final PrimaryExpression PrimaryExpression_461_Var
		 = (PrimaryExpression)Expr_460_list.get(0);
		Assert.assertNotNull(PrimaryExpression_461_Var
		);
		Assert.assertEquals("print", PrimaryExpression_461_Var
		.getId());
		final EList<? extends EObject> Suffix_461_list = PostfixExpression_460_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_461_list);
		Assert.assertEquals(1, Suffix_461_list.size());
		//461
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_462_Var
		 = (PostfixExpressionSuffixArgument)Suffix_461_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_462_Var
		);
		//462
		final ArgumentExpressionList ArgumentExpressionList_463_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_462_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_463_Var
		);
		final EList<? extends EObject> Expr_463_list = ArgumentExpressionList_463_Var
		.getExpr();
		Assert.assertNotNull(Expr_463_list);
		Assert.assertEquals(1, Expr_463_list.size());
		//463
		final AssignmentExpression AssignmentExpression_464_Var
		 = (AssignmentExpression)Expr_463_list.get(0);
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
		final UnaryOperator UnaryOperator_478_Var
		 = (UnaryOperator)UnaryExpression_477_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_478_Var
		);
		Assert.assertEquals("&", UnaryOperator_478_Var
		.getOp());
		//478
		final CastExpression CastExpression_479_Var
		 = (CastExpression)UnaryExpression_477_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_479_Var
		);
		//479
		final UnaryExpression UnaryExpression_480_Var
		 = (UnaryExpression)CastExpression_479_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_480_Var
		);
		//480
		final PostfixExpression PostfixExpression_481_Var
		 = (PostfixExpression)UnaryExpression_480_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_481_Var
		);
		final EList<? extends EObject> Expr_481_list = PostfixExpression_481_Var
		.getExpr();
		Assert.assertNotNull(Expr_481_list);
		Assert.assertEquals(1, Expr_481_list.size());
		//481
		final PrimaryExpression PrimaryExpression_482_Var
		 = (PrimaryExpression)Expr_481_list.get(0);
		Assert.assertNotNull(PrimaryExpression_482_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_482_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_444_Var
		.getSemi());
		//482
		final Statement Statement_483_Var
		 = (Statement)Statement_350_list.get(2);
		Assert.assertNotNull(Statement_483_Var
		);
		//483
		final ExpressionStatement ExpressionStatement_484_Var
		 = (ExpressionStatement)Statement_483_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_484_Var
		);
		//484
		final Expression Expression_485_Var
		 = (Expression)ExpressionStatement_484_Var
		.getExpression();
		Assert.assertNotNull(Expression_485_Var
		);
		final EList<? extends EObject> ExprExpr_485_list = Expression_485_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_485_list);
		Assert.assertEquals(1, ExprExpr_485_list.size());
		//485
		final AssignmentExpression AssignmentExpression_486_Var
		 = (AssignmentExpression)ExprExpr_485_list.get(0);
		Assert.assertNotNull(AssignmentExpression_486_Var
		);
		//486
		final ConditionalExpression ConditionalExpression_487_Var
		 = (ConditionalExpression)AssignmentExpression_486_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_487_Var
		);
		//487
		final LogicalOrExpression LogicalOrExpression_488_Var
		 = (LogicalOrExpression)ConditionalExpression_487_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_488_Var
		);
		final EList<? extends EObject> Expr_488_list = LogicalOrExpression_488_Var
		.getExpr();
		Assert.assertNotNull(Expr_488_list);
		Assert.assertEquals(1, Expr_488_list.size());
		//488
		final LogicalAndExpression LogicalAndExpression_489_Var
		 = (LogicalAndExpression)Expr_488_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_489_Var
		);
		final EList<? extends EObject> Expr_489_list = LogicalAndExpression_489_Var
		.getExpr();
		Assert.assertNotNull(Expr_489_list);
		Assert.assertEquals(1, Expr_489_list.size());
		//489
		final InclusiveOrExpression InclusiveOrExpression_490_Var
		 = (InclusiveOrExpression)Expr_489_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_490_Var
		);
		final EList<? extends EObject> Expr_490_list = InclusiveOrExpression_490_Var
		.getExpr();
		Assert.assertNotNull(Expr_490_list);
		Assert.assertEquals(1, Expr_490_list.size());
		//490
		final ExclusiveOrExpression ExclusiveOrExpression_491_Var
		 = (ExclusiveOrExpression)Expr_490_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_491_Var
		);
		final EList<? extends EObject> Expr_491_list = ExclusiveOrExpression_491_Var
		.getExpr();
		Assert.assertNotNull(Expr_491_list);
		Assert.assertEquals(1, Expr_491_list.size());
		//491
		final AndExpression AndExpression_492_Var
		 = (AndExpression)Expr_491_list.get(0);
		Assert.assertNotNull(AndExpression_492_Var
		);
		final EList<? extends EObject> Expr_492_list = AndExpression_492_Var
		.getExpr();
		Assert.assertNotNull(Expr_492_list);
		Assert.assertEquals(1, Expr_492_list.size());
		//492
		final EqualityExpression EqualityExpression_493_Var
		 = (EqualityExpression)Expr_492_list.get(0);
		Assert.assertNotNull(EqualityExpression_493_Var
		);
		final EList<? extends EObject> Expr_493_list = EqualityExpression_493_Var
		.getExpr();
		Assert.assertNotNull(Expr_493_list);
		Assert.assertEquals(1, Expr_493_list.size());
		//493
		final RelationalExpression RelationalExpression_494_Var
		 = (RelationalExpression)Expr_493_list.get(0);
		Assert.assertNotNull(RelationalExpression_494_Var
		);
		final EList<? extends EObject> Expr_494_list = RelationalExpression_494_Var
		.getExpr();
		Assert.assertNotNull(Expr_494_list);
		Assert.assertEquals(1, Expr_494_list.size());
		//494
		final ShiftExpression ShiftExpression_495_Var
		 = (ShiftExpression)Expr_494_list.get(0);
		Assert.assertNotNull(ShiftExpression_495_Var
		);
		final EList<? extends EObject> Expr_495_list = ShiftExpression_495_Var
		.getExpr();
		Assert.assertNotNull(Expr_495_list);
		Assert.assertEquals(1, Expr_495_list.size());
		//495
		final AdditiveExpression AdditiveExpression_496_Var
		 = (AdditiveExpression)Expr_495_list.get(0);
		Assert.assertNotNull(AdditiveExpression_496_Var
		);
		final EList<? extends EObject> Expr_496_list = AdditiveExpression_496_Var
		.getExpr();
		Assert.assertNotNull(Expr_496_list);
		Assert.assertEquals(1, Expr_496_list.size());
		//496
		final MultiplicativeExpression MultiplicativeExpression_497_Var
		 = (MultiplicativeExpression)Expr_496_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_497_Var
		);
		final EList<? extends EObject> Expr_497_list = MultiplicativeExpression_497_Var
		.getExpr();
		Assert.assertNotNull(Expr_497_list);
		Assert.assertEquals(1, Expr_497_list.size());
		//497
		final CastExpression CastExpression_498_Var
		 = (CastExpression)Expr_497_list.get(0);
		Assert.assertNotNull(CastExpression_498_Var
		);
		//498
		final UnaryExpression UnaryExpression_499_Var
		 = (UnaryExpression)CastExpression_498_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_499_Var
		);
		//499
		final PostfixExpression PostfixExpression_500_Var
		 = (PostfixExpression)UnaryExpression_499_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_500_Var
		);
		final EList<? extends EObject> Expr_500_list = PostfixExpression_500_Var
		.getExpr();
		Assert.assertNotNull(Expr_500_list);
		Assert.assertEquals(1, Expr_500_list.size());
		//500
		final PrimaryExpression PrimaryExpression_501_Var
		 = (PrimaryExpression)Expr_500_list.get(0);
		Assert.assertNotNull(PrimaryExpression_501_Var
		);
		Assert.assertEquals("print", PrimaryExpression_501_Var
		.getId());
		final EList<? extends EObject> Suffix_501_list = PostfixExpression_500_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_501_list);
		Assert.assertEquals(1, Suffix_501_list.size());
		//501
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_502_Var
		 = (PostfixExpressionSuffixArgument)Suffix_501_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_502_Var
		);
		//502
		final ArgumentExpressionList ArgumentExpressionList_503_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_502_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_503_Var
		);
		final EList<? extends EObject> Expr_503_list = ArgumentExpressionList_503_Var
		.getExpr();
		Assert.assertNotNull(Expr_503_list);
		Assert.assertEquals(1, Expr_503_list.size());
		//503
		final AssignmentExpression AssignmentExpression_504_Var
		 = (AssignmentExpression)Expr_503_list.get(0);
		Assert.assertNotNull(AssignmentExpression_504_Var
		);
		//504
		final ConditionalExpression ConditionalExpression_505_Var
		 = (ConditionalExpression)AssignmentExpression_504_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_505_Var
		);
		//505
		final LogicalOrExpression LogicalOrExpression_506_Var
		 = (LogicalOrExpression)ConditionalExpression_505_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_506_Var
		);
		final EList<? extends EObject> Expr_506_list = LogicalOrExpression_506_Var
		.getExpr();
		Assert.assertNotNull(Expr_506_list);
		Assert.assertEquals(1, Expr_506_list.size());
		//506
		final LogicalAndExpression LogicalAndExpression_507_Var
		 = (LogicalAndExpression)Expr_506_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_507_Var
		);
		final EList<? extends EObject> Expr_507_list = LogicalAndExpression_507_Var
		.getExpr();
		Assert.assertNotNull(Expr_507_list);
		Assert.assertEquals(1, Expr_507_list.size());
		//507
		final InclusiveOrExpression InclusiveOrExpression_508_Var
		 = (InclusiveOrExpression)Expr_507_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_508_Var
		);
		final EList<? extends EObject> Expr_508_list = InclusiveOrExpression_508_Var
		.getExpr();
		Assert.assertNotNull(Expr_508_list);
		Assert.assertEquals(1, Expr_508_list.size());
		//508
		final ExclusiveOrExpression ExclusiveOrExpression_509_Var
		 = (ExclusiveOrExpression)Expr_508_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_509_Var
		);
		final EList<? extends EObject> Expr_509_list = ExclusiveOrExpression_509_Var
		.getExpr();
		Assert.assertNotNull(Expr_509_list);
		Assert.assertEquals(1, Expr_509_list.size());
		//509
		final AndExpression AndExpression_510_Var
		 = (AndExpression)Expr_509_list.get(0);
		Assert.assertNotNull(AndExpression_510_Var
		);
		final EList<? extends EObject> Expr_510_list = AndExpression_510_Var
		.getExpr();
		Assert.assertNotNull(Expr_510_list);
		Assert.assertEquals(1, Expr_510_list.size());
		//510
		final EqualityExpression EqualityExpression_511_Var
		 = (EqualityExpression)Expr_510_list.get(0);
		Assert.assertNotNull(EqualityExpression_511_Var
		);
		final EList<? extends EObject> Expr_511_list = EqualityExpression_511_Var
		.getExpr();
		Assert.assertNotNull(Expr_511_list);
		Assert.assertEquals(1, Expr_511_list.size());
		//511
		final RelationalExpression RelationalExpression_512_Var
		 = (RelationalExpression)Expr_511_list.get(0);
		Assert.assertNotNull(RelationalExpression_512_Var
		);
		final EList<? extends EObject> Expr_512_list = RelationalExpression_512_Var
		.getExpr();
		Assert.assertNotNull(Expr_512_list);
		Assert.assertEquals(1, Expr_512_list.size());
		//512
		final ShiftExpression ShiftExpression_513_Var
		 = (ShiftExpression)Expr_512_list.get(0);
		Assert.assertNotNull(ShiftExpression_513_Var
		);
		final EList<? extends EObject> Expr_513_list = ShiftExpression_513_Var
		.getExpr();
		Assert.assertNotNull(Expr_513_list);
		Assert.assertEquals(1, Expr_513_list.size());
		//513
		final AdditiveExpression AdditiveExpression_514_Var
		 = (AdditiveExpression)Expr_513_list.get(0);
		Assert.assertNotNull(AdditiveExpression_514_Var
		);
		final EList<? extends EObject> Expr_514_list = AdditiveExpression_514_Var
		.getExpr();
		Assert.assertNotNull(Expr_514_list);
		Assert.assertEquals(1, Expr_514_list.size());
		//514
		final MultiplicativeExpression MultiplicativeExpression_515_Var
		 = (MultiplicativeExpression)Expr_514_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_515_Var
		);
		final EList<? extends EObject> Expr_515_list = MultiplicativeExpression_515_Var
		.getExpr();
		Assert.assertNotNull(Expr_515_list);
		Assert.assertEquals(1, Expr_515_list.size());
		//515
		final CastExpression CastExpression_516_Var
		 = (CastExpression)Expr_515_list.get(0);
		Assert.assertNotNull(CastExpression_516_Var
		);
		//516
		final UnaryExpression UnaryExpression_517_Var
		 = (UnaryExpression)CastExpression_516_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_517_Var
		);
		//517
		final UnaryOperator UnaryOperator_518_Var
		 = (UnaryOperator)UnaryExpression_517_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_518_Var
		);
		Assert.assertEquals("&", UnaryOperator_518_Var
		.getOp());
		//518
		final CastExpression CastExpression_519_Var
		 = (CastExpression)UnaryExpression_517_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_519_Var
		);
		//519
		final UnaryExpression UnaryExpression_520_Var
		 = (UnaryExpression)CastExpression_519_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_520_Var
		);
		//520
		final PostfixExpression PostfixExpression_521_Var
		 = (PostfixExpression)UnaryExpression_520_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_521_Var
		);
		final EList<? extends EObject> Expr_521_list = PostfixExpression_521_Var
		.getExpr();
		Assert.assertNotNull(Expr_521_list);
		Assert.assertEquals(1, Expr_521_list.size());
		//521
		final PrimaryExpression PrimaryExpression_522_Var
		 = (PrimaryExpression)Expr_521_list.get(0);
		Assert.assertNotNull(PrimaryExpression_522_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_522_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_484_Var
		.getSemi());
		//522
		final Statement Statement_523_Var
		 = (Statement)Statement_350_list.get(3);
		Assert.assertNotNull(Statement_523_Var
		);
		//523
		final ExpressionStatement ExpressionStatement_524_Var
		 = (ExpressionStatement)Statement_523_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_524_Var
		);
		//524
		final Expression Expression_525_Var
		 = (Expression)ExpressionStatement_524_Var
		.getExpression();
		Assert.assertNotNull(Expression_525_Var
		);
		final EList<? extends EObject> ExprExpr_525_list = Expression_525_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_525_list);
		Assert.assertEquals(1, ExprExpr_525_list.size());
		//525
		final AssignmentExpression AssignmentExpression_526_Var
		 = (AssignmentExpression)ExprExpr_525_list.get(0);
		Assert.assertNotNull(AssignmentExpression_526_Var
		);
		//526
		final UnaryExpression UnaryExpression_527_Var
		 = (UnaryExpression)AssignmentExpression_526_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_527_Var
		);
		//527
		final PostfixExpression PostfixExpression_528_Var
		 = (PostfixExpression)UnaryExpression_527_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_528_Var
		);
		final EList<? extends EObject> Expr_528_list = PostfixExpression_528_Var
		.getExpr();
		Assert.assertNotNull(Expr_528_list);
		Assert.assertEquals(1, Expr_528_list.size());
		//528
		final PrimaryExpression PrimaryExpression_529_Var
		 = (PrimaryExpression)Expr_528_list.get(0);
		Assert.assertNotNull(PrimaryExpression_529_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_529_Var
		.getId());
		final EList<? extends EObject> Suffix_529_list = PostfixExpression_528_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_529_list);
		Assert.assertEquals(1, Suffix_529_list.size());
		//529
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_530_Var
		 = (PostfixExpressionSuffixArrow)Suffix_529_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArrow_530_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixArrow_530_Var
		.getId());
		//530
		final AssignmentOperator AssignmentOperator_531_Var
		 = (AssignmentOperator)AssignmentExpression_526_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_531_Var
		);
		Assert.assertEquals("=", AssignmentOperator_531_Var
		.getOp());
		//531
		final AssignmentExpression AssignmentExpression_532_Var
		 = (AssignmentExpression)AssignmentExpression_526_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_532_Var
		);
		//532
		final ConditionalExpression ConditionalExpression_533_Var
		 = (ConditionalExpression)AssignmentExpression_532_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_533_Var
		);
		//533
		final LogicalOrExpression LogicalOrExpression_534_Var
		 = (LogicalOrExpression)ConditionalExpression_533_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_534_Var
		);
		final EList<? extends EObject> Expr_534_list = LogicalOrExpression_534_Var
		.getExpr();
		Assert.assertNotNull(Expr_534_list);
		Assert.assertEquals(1, Expr_534_list.size());
		//534
		final LogicalAndExpression LogicalAndExpression_535_Var
		 = (LogicalAndExpression)Expr_534_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_535_Var
		);
		final EList<? extends EObject> Expr_535_list = LogicalAndExpression_535_Var
		.getExpr();
		Assert.assertNotNull(Expr_535_list);
		Assert.assertEquals(1, Expr_535_list.size());
		//535
		final InclusiveOrExpression InclusiveOrExpression_536_Var
		 = (InclusiveOrExpression)Expr_535_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_536_Var
		);
		final EList<? extends EObject> Expr_536_list = InclusiveOrExpression_536_Var
		.getExpr();
		Assert.assertNotNull(Expr_536_list);
		Assert.assertEquals(1, Expr_536_list.size());
		//536
		final ExclusiveOrExpression ExclusiveOrExpression_537_Var
		 = (ExclusiveOrExpression)Expr_536_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_537_Var
		);
		final EList<? extends EObject> Expr_537_list = ExclusiveOrExpression_537_Var
		.getExpr();
		Assert.assertNotNull(Expr_537_list);
		Assert.assertEquals(1, Expr_537_list.size());
		//537
		final AndExpression AndExpression_538_Var
		 = (AndExpression)Expr_537_list.get(0);
		Assert.assertNotNull(AndExpression_538_Var
		);
		final EList<? extends EObject> Expr_538_list = AndExpression_538_Var
		.getExpr();
		Assert.assertNotNull(Expr_538_list);
		Assert.assertEquals(1, Expr_538_list.size());
		//538
		final EqualityExpression EqualityExpression_539_Var
		 = (EqualityExpression)Expr_538_list.get(0);
		Assert.assertNotNull(EqualityExpression_539_Var
		);
		final EList<? extends EObject> Expr_539_list = EqualityExpression_539_Var
		.getExpr();
		Assert.assertNotNull(Expr_539_list);
		Assert.assertEquals(1, Expr_539_list.size());
		//539
		final RelationalExpression RelationalExpression_540_Var
		 = (RelationalExpression)Expr_539_list.get(0);
		Assert.assertNotNull(RelationalExpression_540_Var
		);
		final EList<? extends EObject> Expr_540_list = RelationalExpression_540_Var
		.getExpr();
		Assert.assertNotNull(Expr_540_list);
		Assert.assertEquals(1, Expr_540_list.size());
		//540
		final ShiftExpression ShiftExpression_541_Var
		 = (ShiftExpression)Expr_540_list.get(0);
		Assert.assertNotNull(ShiftExpression_541_Var
		);
		final EList<? extends EObject> Expr_541_list = ShiftExpression_541_Var
		.getExpr();
		Assert.assertNotNull(Expr_541_list);
		Assert.assertEquals(1, Expr_541_list.size());
		//541
		final AdditiveExpression AdditiveExpression_542_Var
		 = (AdditiveExpression)Expr_541_list.get(0);
		Assert.assertNotNull(AdditiveExpression_542_Var
		);
		final EList<? extends EObject> Expr_542_list = AdditiveExpression_542_Var
		.getExpr();
		Assert.assertNotNull(Expr_542_list);
		Assert.assertEquals(1, Expr_542_list.size());
		//542
		final MultiplicativeExpression MultiplicativeExpression_543_Var
		 = (MultiplicativeExpression)Expr_542_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_543_Var
		);
		final EList<? extends EObject> Expr_543_list = MultiplicativeExpression_543_Var
		.getExpr();
		Assert.assertNotNull(Expr_543_list);
		Assert.assertEquals(1, Expr_543_list.size());
		//543
		final CastExpression CastExpression_544_Var
		 = (CastExpression)Expr_543_list.get(0);
		Assert.assertNotNull(CastExpression_544_Var
		);
		//544
		final UnaryExpression UnaryExpression_545_Var
		 = (UnaryExpression)CastExpression_544_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_545_Var
		);
		//545
		final PostfixExpression PostfixExpression_546_Var
		 = (PostfixExpression)UnaryExpression_545_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_546_Var
		);
		final EList<? extends EObject> Expr_546_list = PostfixExpression_546_Var
		.getExpr();
		Assert.assertNotNull(Expr_546_list);
		Assert.assertEquals(1, Expr_546_list.size());
		//546
		final PrimaryExpression PrimaryExpression_547_Var
		 = (PrimaryExpression)Expr_546_list.get(0);
		Assert.assertNotNull(PrimaryExpression_547_Var
		);
		//547
		final Constant Constant_548_Var
		 = (Constant)PrimaryExpression_547_Var
		.getConst();
		Assert.assertNotNull(Constant_548_Var
		);
		Assert.assertEquals("0x009", Constant_548_Var
		.getHex());
		Assert.assertEquals(";", ExpressionStatement_524_Var
		.getSemi());
		//548
		final Statement Statement_549_Var
		 = (Statement)Statement_350_list.get(4);
		Assert.assertNotNull(Statement_549_Var
		);
		//549
		final ExpressionStatement ExpressionStatement_550_Var
		 = (ExpressionStatement)Statement_549_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_550_Var
		);
		//550
		final Expression Expression_551_Var
		 = (Expression)ExpressionStatement_550_Var
		.getExpression();
		Assert.assertNotNull(Expression_551_Var
		);
		final EList<? extends EObject> ExprExpr_551_list = Expression_551_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_551_list);
		Assert.assertEquals(1, ExprExpr_551_list.size());
		//551
		final AssignmentExpression AssignmentExpression_552_Var
		 = (AssignmentExpression)ExprExpr_551_list.get(0);
		Assert.assertNotNull(AssignmentExpression_552_Var
		);
		//552
		final ConditionalExpression ConditionalExpression_553_Var
		 = (ConditionalExpression)AssignmentExpression_552_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_553_Var
		);
		//553
		final LogicalOrExpression LogicalOrExpression_554_Var
		 = (LogicalOrExpression)ConditionalExpression_553_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_554_Var
		);
		final EList<? extends EObject> Expr_554_list = LogicalOrExpression_554_Var
		.getExpr();
		Assert.assertNotNull(Expr_554_list);
		Assert.assertEquals(1, Expr_554_list.size());
		//554
		final LogicalAndExpression LogicalAndExpression_555_Var
		 = (LogicalAndExpression)Expr_554_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_555_Var
		);
		final EList<? extends EObject> Expr_555_list = LogicalAndExpression_555_Var
		.getExpr();
		Assert.assertNotNull(Expr_555_list);
		Assert.assertEquals(1, Expr_555_list.size());
		//555
		final InclusiveOrExpression InclusiveOrExpression_556_Var
		 = (InclusiveOrExpression)Expr_555_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_556_Var
		);
		final EList<? extends EObject> Expr_556_list = InclusiveOrExpression_556_Var
		.getExpr();
		Assert.assertNotNull(Expr_556_list);
		Assert.assertEquals(1, Expr_556_list.size());
		//556
		final ExclusiveOrExpression ExclusiveOrExpression_557_Var
		 = (ExclusiveOrExpression)Expr_556_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_557_Var
		);
		final EList<? extends EObject> Expr_557_list = ExclusiveOrExpression_557_Var
		.getExpr();
		Assert.assertNotNull(Expr_557_list);
		Assert.assertEquals(1, Expr_557_list.size());
		//557
		final AndExpression AndExpression_558_Var
		 = (AndExpression)Expr_557_list.get(0);
		Assert.assertNotNull(AndExpression_558_Var
		);
		final EList<? extends EObject> Expr_558_list = AndExpression_558_Var
		.getExpr();
		Assert.assertNotNull(Expr_558_list);
		Assert.assertEquals(1, Expr_558_list.size());
		//558
		final EqualityExpression EqualityExpression_559_Var
		 = (EqualityExpression)Expr_558_list.get(0);
		Assert.assertNotNull(EqualityExpression_559_Var
		);
		final EList<? extends EObject> Expr_559_list = EqualityExpression_559_Var
		.getExpr();
		Assert.assertNotNull(Expr_559_list);
		Assert.assertEquals(1, Expr_559_list.size());
		//559
		final RelationalExpression RelationalExpression_560_Var
		 = (RelationalExpression)Expr_559_list.get(0);
		Assert.assertNotNull(RelationalExpression_560_Var
		);
		final EList<? extends EObject> Expr_560_list = RelationalExpression_560_Var
		.getExpr();
		Assert.assertNotNull(Expr_560_list);
		Assert.assertEquals(1, Expr_560_list.size());
		//560
		final ShiftExpression ShiftExpression_561_Var
		 = (ShiftExpression)Expr_560_list.get(0);
		Assert.assertNotNull(ShiftExpression_561_Var
		);
		final EList<? extends EObject> Expr_561_list = ShiftExpression_561_Var
		.getExpr();
		Assert.assertNotNull(Expr_561_list);
		Assert.assertEquals(1, Expr_561_list.size());
		//561
		final AdditiveExpression AdditiveExpression_562_Var
		 = (AdditiveExpression)Expr_561_list.get(0);
		Assert.assertNotNull(AdditiveExpression_562_Var
		);
		final EList<? extends EObject> Expr_562_list = AdditiveExpression_562_Var
		.getExpr();
		Assert.assertNotNull(Expr_562_list);
		Assert.assertEquals(1, Expr_562_list.size());
		//562
		final MultiplicativeExpression MultiplicativeExpression_563_Var
		 = (MultiplicativeExpression)Expr_562_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_563_Var
		);
		final EList<? extends EObject> Expr_563_list = MultiplicativeExpression_563_Var
		.getExpr();
		Assert.assertNotNull(Expr_563_list);
		Assert.assertEquals(1, Expr_563_list.size());
		//563
		final CastExpression CastExpression_564_Var
		 = (CastExpression)Expr_563_list.get(0);
		Assert.assertNotNull(CastExpression_564_Var
		);
		//564
		final UnaryExpression UnaryExpression_565_Var
		 = (UnaryExpression)CastExpression_564_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_565_Var
		);
		//565
		final PostfixExpression PostfixExpression_566_Var
		 = (PostfixExpression)UnaryExpression_565_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_566_Var
		);
		final EList<? extends EObject> Expr_566_list = PostfixExpression_566_Var
		.getExpr();
		Assert.assertNotNull(Expr_566_list);
		Assert.assertEquals(1, Expr_566_list.size());
		//566
		final PrimaryExpression PrimaryExpression_567_Var
		 = (PrimaryExpression)Expr_566_list.get(0);
		Assert.assertNotNull(PrimaryExpression_567_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_567_Var
		.getId());
		final EList<? extends EObject> Suffix_567_list = PostfixExpression_566_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_567_list);
		Assert.assertEquals(1, Suffix_567_list.size());
		//567
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_568_Var
		 = (PostfixExpressionSuffixArgument)Suffix_567_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_568_Var
		);
		//568
		final ArgumentExpressionList ArgumentExpressionList_569_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_568_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_569_Var
		);
		final EList<? extends EObject> Expr_569_list = ArgumentExpressionList_569_Var
		.getExpr();
		Assert.assertNotNull(Expr_569_list);
		Assert.assertEquals(2, Expr_569_list.size());
		//569
		final AssignmentExpression AssignmentExpression_570_Var
		 = (AssignmentExpression)Expr_569_list.get(0);
		Assert.assertNotNull(AssignmentExpression_570_Var
		);
		//570
		final ConditionalExpression ConditionalExpression_571_Var
		 = (ConditionalExpression)AssignmentExpression_570_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_571_Var
		);
		//571
		final LogicalOrExpression LogicalOrExpression_572_Var
		 = (LogicalOrExpression)ConditionalExpression_571_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_572_Var
		);
		final EList<? extends EObject> Expr_572_list = LogicalOrExpression_572_Var
		.getExpr();
		Assert.assertNotNull(Expr_572_list);
		Assert.assertEquals(1, Expr_572_list.size());
		//572
		final LogicalAndExpression LogicalAndExpression_573_Var
		 = (LogicalAndExpression)Expr_572_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_573_Var
		);
		final EList<? extends EObject> Expr_573_list = LogicalAndExpression_573_Var
		.getExpr();
		Assert.assertNotNull(Expr_573_list);
		Assert.assertEquals(1, Expr_573_list.size());
		//573
		final InclusiveOrExpression InclusiveOrExpression_574_Var
		 = (InclusiveOrExpression)Expr_573_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_574_Var
		);
		final EList<? extends EObject> Expr_574_list = InclusiveOrExpression_574_Var
		.getExpr();
		Assert.assertNotNull(Expr_574_list);
		Assert.assertEquals(1, Expr_574_list.size());
		//574
		final ExclusiveOrExpression ExclusiveOrExpression_575_Var
		 = (ExclusiveOrExpression)Expr_574_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_575_Var
		);
		final EList<? extends EObject> Expr_575_list = ExclusiveOrExpression_575_Var
		.getExpr();
		Assert.assertNotNull(Expr_575_list);
		Assert.assertEquals(1, Expr_575_list.size());
		//575
		final AndExpression AndExpression_576_Var
		 = (AndExpression)Expr_575_list.get(0);
		Assert.assertNotNull(AndExpression_576_Var
		);
		final EList<? extends EObject> Expr_576_list = AndExpression_576_Var
		.getExpr();
		Assert.assertNotNull(Expr_576_list);
		Assert.assertEquals(1, Expr_576_list.size());
		//576
		final EqualityExpression EqualityExpression_577_Var
		 = (EqualityExpression)Expr_576_list.get(0);
		Assert.assertNotNull(EqualityExpression_577_Var
		);
		final EList<? extends EObject> Expr_577_list = EqualityExpression_577_Var
		.getExpr();
		Assert.assertNotNull(Expr_577_list);
		Assert.assertEquals(1, Expr_577_list.size());
		//577
		final RelationalExpression RelationalExpression_578_Var
		 = (RelationalExpression)Expr_577_list.get(0);
		Assert.assertNotNull(RelationalExpression_578_Var
		);
		final EList<? extends EObject> Expr_578_list = RelationalExpression_578_Var
		.getExpr();
		Assert.assertNotNull(Expr_578_list);
		Assert.assertEquals(1, Expr_578_list.size());
		//578
		final ShiftExpression ShiftExpression_579_Var
		 = (ShiftExpression)Expr_578_list.get(0);
		Assert.assertNotNull(ShiftExpression_579_Var
		);
		final EList<? extends EObject> Expr_579_list = ShiftExpression_579_Var
		.getExpr();
		Assert.assertNotNull(Expr_579_list);
		Assert.assertEquals(1, Expr_579_list.size());
		//579
		final AdditiveExpression AdditiveExpression_580_Var
		 = (AdditiveExpression)Expr_579_list.get(0);
		Assert.assertNotNull(AdditiveExpression_580_Var
		);
		final EList<? extends EObject> Expr_580_list = AdditiveExpression_580_Var
		.getExpr();
		Assert.assertNotNull(Expr_580_list);
		Assert.assertEquals(1, Expr_580_list.size());
		//580
		final MultiplicativeExpression MultiplicativeExpression_581_Var
		 = (MultiplicativeExpression)Expr_580_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_581_Var
		);
		final EList<? extends EObject> Expr_581_list = MultiplicativeExpression_581_Var
		.getExpr();
		Assert.assertNotNull(Expr_581_list);
		Assert.assertEquals(1, Expr_581_list.size());
		//581
		final CastExpression CastExpression_582_Var
		 = (CastExpression)Expr_581_list.get(0);
		Assert.assertNotNull(CastExpression_582_Var
		);
		//582
		final UnaryExpression UnaryExpression_583_Var
		 = (UnaryExpression)CastExpression_582_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_583_Var
		);
		//583
		final PostfixExpression PostfixExpression_584_Var
		 = (PostfixExpression)UnaryExpression_583_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_584_Var
		);
		final EList<? extends EObject> Expr_584_list = PostfixExpression_584_Var
		.getExpr();
		Assert.assertNotNull(Expr_584_list);
		Assert.assertEquals(1, Expr_584_list.size());
		//584
		final PrimaryExpression PrimaryExpression_585_Var
		 = (PrimaryExpression)Expr_584_list.get(0);
		Assert.assertNotNull(PrimaryExpression_585_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_585_Var
		.getId());
		final EList<? extends EObject> Suffix_585_list = PostfixExpression_584_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_585_list);
		Assert.assertEquals(1, Suffix_585_list.size());
		//585
		final PostfixExpressionSuffixArrow PostfixExpressionSuffixArrow_586_Var
		 = (PostfixExpressionSuffixArrow)Suffix_585_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArrow_586_Var
		);
		Assert.assertEquals("name", PostfixExpressionSuffixArrow_586_Var
		.getId());
		//586
		final AssignmentExpression AssignmentExpression_587_Var
		 = (AssignmentExpression)Expr_569_list.get(1);
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
		//602
		final Constant Constant_603_Var
		 = (Constant)PrimaryExpression_602_Var
		.getConst();
		Assert.assertNotNull(Constant_603_Var
		);
		Assert.assertEquals("\"Billy The Kid\"", Constant_603_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_550_Var
		.getSemi());
		//603
		final Statement Statement_604_Var
		 = (Statement)Statement_350_list.get(5);
		Assert.assertNotNull(Statement_604_Var
		);
		//604
		final ExpressionStatement ExpressionStatement_605_Var
		 = (ExpressionStatement)Statement_604_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_605_Var
		);
		//605
		final Expression Expression_606_Var
		 = (Expression)ExpressionStatement_605_Var
		.getExpression();
		Assert.assertNotNull(Expression_606_Var
		);
		final EList<? extends EObject> ExprExpr_606_list = Expression_606_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_606_list);
		Assert.assertEquals(1, ExprExpr_606_list.size());
		//606
		final AssignmentExpression AssignmentExpression_607_Var
		 = (AssignmentExpression)ExprExpr_606_list.get(0);
		Assert.assertNotNull(AssignmentExpression_607_Var
		);
		//607
		final ConditionalExpression ConditionalExpression_608_Var
		 = (ConditionalExpression)AssignmentExpression_607_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_608_Var
		);
		//608
		final LogicalOrExpression LogicalOrExpression_609_Var
		 = (LogicalOrExpression)ConditionalExpression_608_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_609_Var
		);
		final EList<? extends EObject> Expr_609_list = LogicalOrExpression_609_Var
		.getExpr();
		Assert.assertNotNull(Expr_609_list);
		Assert.assertEquals(1, Expr_609_list.size());
		//609
		final LogicalAndExpression LogicalAndExpression_610_Var
		 = (LogicalAndExpression)Expr_609_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_610_Var
		);
		final EList<? extends EObject> Expr_610_list = LogicalAndExpression_610_Var
		.getExpr();
		Assert.assertNotNull(Expr_610_list);
		Assert.assertEquals(1, Expr_610_list.size());
		//610
		final InclusiveOrExpression InclusiveOrExpression_611_Var
		 = (InclusiveOrExpression)Expr_610_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_611_Var
		);
		final EList<? extends EObject> Expr_611_list = InclusiveOrExpression_611_Var
		.getExpr();
		Assert.assertNotNull(Expr_611_list);
		Assert.assertEquals(1, Expr_611_list.size());
		//611
		final ExclusiveOrExpression ExclusiveOrExpression_612_Var
		 = (ExclusiveOrExpression)Expr_611_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_612_Var
		);
		final EList<? extends EObject> Expr_612_list = ExclusiveOrExpression_612_Var
		.getExpr();
		Assert.assertNotNull(Expr_612_list);
		Assert.assertEquals(1, Expr_612_list.size());
		//612
		final AndExpression AndExpression_613_Var
		 = (AndExpression)Expr_612_list.get(0);
		Assert.assertNotNull(AndExpression_613_Var
		);
		final EList<? extends EObject> Expr_613_list = AndExpression_613_Var
		.getExpr();
		Assert.assertNotNull(Expr_613_list);
		Assert.assertEquals(1, Expr_613_list.size());
		//613
		final EqualityExpression EqualityExpression_614_Var
		 = (EqualityExpression)Expr_613_list.get(0);
		Assert.assertNotNull(EqualityExpression_614_Var
		);
		final EList<? extends EObject> Expr_614_list = EqualityExpression_614_Var
		.getExpr();
		Assert.assertNotNull(Expr_614_list);
		Assert.assertEquals(1, Expr_614_list.size());
		//614
		final RelationalExpression RelationalExpression_615_Var
		 = (RelationalExpression)Expr_614_list.get(0);
		Assert.assertNotNull(RelationalExpression_615_Var
		);
		final EList<? extends EObject> Expr_615_list = RelationalExpression_615_Var
		.getExpr();
		Assert.assertNotNull(Expr_615_list);
		Assert.assertEquals(1, Expr_615_list.size());
		//615
		final ShiftExpression ShiftExpression_616_Var
		 = (ShiftExpression)Expr_615_list.get(0);
		Assert.assertNotNull(ShiftExpression_616_Var
		);
		final EList<? extends EObject> Expr_616_list = ShiftExpression_616_Var
		.getExpr();
		Assert.assertNotNull(Expr_616_list);
		Assert.assertEquals(1, Expr_616_list.size());
		//616
		final AdditiveExpression AdditiveExpression_617_Var
		 = (AdditiveExpression)Expr_616_list.get(0);
		Assert.assertNotNull(AdditiveExpression_617_Var
		);
		final EList<? extends EObject> Expr_617_list = AdditiveExpression_617_Var
		.getExpr();
		Assert.assertNotNull(Expr_617_list);
		Assert.assertEquals(1, Expr_617_list.size());
		//617
		final MultiplicativeExpression MultiplicativeExpression_618_Var
		 = (MultiplicativeExpression)Expr_617_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_618_Var
		);
		final EList<? extends EObject> Expr_618_list = MultiplicativeExpression_618_Var
		.getExpr();
		Assert.assertNotNull(Expr_618_list);
		Assert.assertEquals(1, Expr_618_list.size());
		//618
		final CastExpression CastExpression_619_Var
		 = (CastExpression)Expr_618_list.get(0);
		Assert.assertNotNull(CastExpression_619_Var
		);
		//619
		final UnaryExpression UnaryExpression_620_Var
		 = (UnaryExpression)CastExpression_619_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_620_Var
		);
		//620
		final PostfixExpression PostfixExpression_621_Var
		 = (PostfixExpression)UnaryExpression_620_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_621_Var
		);
		final EList<? extends EObject> Expr_621_list = PostfixExpression_621_Var
		.getExpr();
		Assert.assertNotNull(Expr_621_list);
		Assert.assertEquals(1, Expr_621_list.size());
		//621
		final PrimaryExpression PrimaryExpression_622_Var
		 = (PrimaryExpression)Expr_621_list.get(0);
		Assert.assertNotNull(PrimaryExpression_622_Var
		);
		Assert.assertEquals("print", PrimaryExpression_622_Var
		.getId());
		final EList<? extends EObject> Suffix_622_list = PostfixExpression_621_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_622_list);
		Assert.assertEquals(1, Suffix_622_list.size());
		//622
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_623_Var
		 = (PostfixExpressionSuffixArgument)Suffix_622_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_623_Var
		);
		//623
		final ArgumentExpressionList ArgumentExpressionList_624_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_623_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_624_Var
		);
		final EList<? extends EObject> Expr_624_list = ArgumentExpressionList_624_Var
		.getExpr();
		Assert.assertNotNull(Expr_624_list);
		Assert.assertEquals(1, Expr_624_list.size());
		//624
		final AssignmentExpression AssignmentExpression_625_Var
		 = (AssignmentExpression)Expr_624_list.get(0);
		Assert.assertNotNull(AssignmentExpression_625_Var
		);
		//625
		final ConditionalExpression ConditionalExpression_626_Var
		 = (ConditionalExpression)AssignmentExpression_625_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_626_Var
		);
		//626
		final LogicalOrExpression LogicalOrExpression_627_Var
		 = (LogicalOrExpression)ConditionalExpression_626_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_627_Var
		);
		final EList<? extends EObject> Expr_627_list = LogicalOrExpression_627_Var
		.getExpr();
		Assert.assertNotNull(Expr_627_list);
		Assert.assertEquals(1, Expr_627_list.size());
		//627
		final LogicalAndExpression LogicalAndExpression_628_Var
		 = (LogicalAndExpression)Expr_627_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_628_Var
		);
		final EList<? extends EObject> Expr_628_list = LogicalAndExpression_628_Var
		.getExpr();
		Assert.assertNotNull(Expr_628_list);
		Assert.assertEquals(1, Expr_628_list.size());
		//628
		final InclusiveOrExpression InclusiveOrExpression_629_Var
		 = (InclusiveOrExpression)Expr_628_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_629_Var
		);
		final EList<? extends EObject> Expr_629_list = InclusiveOrExpression_629_Var
		.getExpr();
		Assert.assertNotNull(Expr_629_list);
		Assert.assertEquals(1, Expr_629_list.size());
		//629
		final ExclusiveOrExpression ExclusiveOrExpression_630_Var
		 = (ExclusiveOrExpression)Expr_629_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_630_Var
		);
		final EList<? extends EObject> Expr_630_list = ExclusiveOrExpression_630_Var
		.getExpr();
		Assert.assertNotNull(Expr_630_list);
		Assert.assertEquals(1, Expr_630_list.size());
		//630
		final AndExpression AndExpression_631_Var
		 = (AndExpression)Expr_630_list.get(0);
		Assert.assertNotNull(AndExpression_631_Var
		);
		final EList<? extends EObject> Expr_631_list = AndExpression_631_Var
		.getExpr();
		Assert.assertNotNull(Expr_631_list);
		Assert.assertEquals(1, Expr_631_list.size());
		//631
		final EqualityExpression EqualityExpression_632_Var
		 = (EqualityExpression)Expr_631_list.get(0);
		Assert.assertNotNull(EqualityExpression_632_Var
		);
		final EList<? extends EObject> Expr_632_list = EqualityExpression_632_Var
		.getExpr();
		Assert.assertNotNull(Expr_632_list);
		Assert.assertEquals(1, Expr_632_list.size());
		//632
		final RelationalExpression RelationalExpression_633_Var
		 = (RelationalExpression)Expr_632_list.get(0);
		Assert.assertNotNull(RelationalExpression_633_Var
		);
		final EList<? extends EObject> Expr_633_list = RelationalExpression_633_Var
		.getExpr();
		Assert.assertNotNull(Expr_633_list);
		Assert.assertEquals(1, Expr_633_list.size());
		//633
		final ShiftExpression ShiftExpression_634_Var
		 = (ShiftExpression)Expr_633_list.get(0);
		Assert.assertNotNull(ShiftExpression_634_Var
		);
		final EList<? extends EObject> Expr_634_list = ShiftExpression_634_Var
		.getExpr();
		Assert.assertNotNull(Expr_634_list);
		Assert.assertEquals(1, Expr_634_list.size());
		//634
		final AdditiveExpression AdditiveExpression_635_Var
		 = (AdditiveExpression)Expr_634_list.get(0);
		Assert.assertNotNull(AdditiveExpression_635_Var
		);
		final EList<? extends EObject> Expr_635_list = AdditiveExpression_635_Var
		.getExpr();
		Assert.assertNotNull(Expr_635_list);
		Assert.assertEquals(1, Expr_635_list.size());
		//635
		final MultiplicativeExpression MultiplicativeExpression_636_Var
		 = (MultiplicativeExpression)Expr_635_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_636_Var
		);
		final EList<? extends EObject> Expr_636_list = MultiplicativeExpression_636_Var
		.getExpr();
		Assert.assertNotNull(Expr_636_list);
		Assert.assertEquals(1, Expr_636_list.size());
		//636
		final CastExpression CastExpression_637_Var
		 = (CastExpression)Expr_636_list.get(0);
		Assert.assertNotNull(CastExpression_637_Var
		);
		//637
		final UnaryExpression UnaryExpression_638_Var
		 = (UnaryExpression)CastExpression_637_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_638_Var
		);
		//638
		final PostfixExpression PostfixExpression_639_Var
		 = (PostfixExpression)UnaryExpression_638_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_639_Var
		);
		final EList<? extends EObject> Expr_639_list = PostfixExpression_639_Var
		.getExpr();
		Assert.assertNotNull(Expr_639_list);
		Assert.assertEquals(1, Expr_639_list.size());
		//639
		final PrimaryExpression PrimaryExpression_640_Var
		 = (PrimaryExpression)Expr_639_list.get(0);
		Assert.assertNotNull(PrimaryExpression_640_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_640_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_605_Var
		.getSemi());
		//640
		final Statement Statement_641_Var
		 = (Statement)Statement_350_list.get(6);
		Assert.assertNotNull(Statement_641_Var
		);
		//641
		final ExpressionStatement ExpressionStatement_642_Var
		 = (ExpressionStatement)Statement_641_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_642_Var
		);
		//642
		final Expression Expression_643_Var
		 = (Expression)ExpressionStatement_642_Var
		.getExpression();
		Assert.assertNotNull(Expression_643_Var
		);
		final EList<? extends EObject> ExprExpr_643_list = Expression_643_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_643_list);
		Assert.assertEquals(1, ExprExpr_643_list.size());
		//643
		final AssignmentExpression AssignmentExpression_644_Var
		 = (AssignmentExpression)ExprExpr_643_list.get(0);
		Assert.assertNotNull(AssignmentExpression_644_Var
		);
		//644
		final ConditionalExpression ConditionalExpression_645_Var
		 = (ConditionalExpression)AssignmentExpression_644_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_645_Var
		);
		//645
		final LogicalOrExpression LogicalOrExpression_646_Var
		 = (LogicalOrExpression)ConditionalExpression_645_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_646_Var
		);
		final EList<? extends EObject> Expr_646_list = LogicalOrExpression_646_Var
		.getExpr();
		Assert.assertNotNull(Expr_646_list);
		Assert.assertEquals(1, Expr_646_list.size());
		//646
		final LogicalAndExpression LogicalAndExpression_647_Var
		 = (LogicalAndExpression)Expr_646_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_647_Var
		);
		final EList<? extends EObject> Expr_647_list = LogicalAndExpression_647_Var
		.getExpr();
		Assert.assertNotNull(Expr_647_list);
		Assert.assertEquals(1, Expr_647_list.size());
		//647
		final InclusiveOrExpression InclusiveOrExpression_648_Var
		 = (InclusiveOrExpression)Expr_647_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_648_Var
		);
		final EList<? extends EObject> Expr_648_list = InclusiveOrExpression_648_Var
		.getExpr();
		Assert.assertNotNull(Expr_648_list);
		Assert.assertEquals(1, Expr_648_list.size());
		//648
		final ExclusiveOrExpression ExclusiveOrExpression_649_Var
		 = (ExclusiveOrExpression)Expr_648_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_649_Var
		);
		final EList<? extends EObject> Expr_649_list = ExclusiveOrExpression_649_Var
		.getExpr();
		Assert.assertNotNull(Expr_649_list);
		Assert.assertEquals(1, Expr_649_list.size());
		//649
		final AndExpression AndExpression_650_Var
		 = (AndExpression)Expr_649_list.get(0);
		Assert.assertNotNull(AndExpression_650_Var
		);
		final EList<? extends EObject> Expr_650_list = AndExpression_650_Var
		.getExpr();
		Assert.assertNotNull(Expr_650_list);
		Assert.assertEquals(1, Expr_650_list.size());
		//650
		final EqualityExpression EqualityExpression_651_Var
		 = (EqualityExpression)Expr_650_list.get(0);
		Assert.assertNotNull(EqualityExpression_651_Var
		);
		final EList<? extends EObject> Expr_651_list = EqualityExpression_651_Var
		.getExpr();
		Assert.assertNotNull(Expr_651_list);
		Assert.assertEquals(1, Expr_651_list.size());
		//651
		final RelationalExpression RelationalExpression_652_Var
		 = (RelationalExpression)Expr_651_list.get(0);
		Assert.assertNotNull(RelationalExpression_652_Var
		);
		final EList<? extends EObject> Expr_652_list = RelationalExpression_652_Var
		.getExpr();
		Assert.assertNotNull(Expr_652_list);
		Assert.assertEquals(1, Expr_652_list.size());
		//652
		final ShiftExpression ShiftExpression_653_Var
		 = (ShiftExpression)Expr_652_list.get(0);
		Assert.assertNotNull(ShiftExpression_653_Var
		);
		final EList<? extends EObject> Expr_653_list = ShiftExpression_653_Var
		.getExpr();
		Assert.assertNotNull(Expr_653_list);
		Assert.assertEquals(1, Expr_653_list.size());
		//653
		final AdditiveExpression AdditiveExpression_654_Var
		 = (AdditiveExpression)Expr_653_list.get(0);
		Assert.assertNotNull(AdditiveExpression_654_Var
		);
		final EList<? extends EObject> Expr_654_list = AdditiveExpression_654_Var
		.getExpr();
		Assert.assertNotNull(Expr_654_list);
		Assert.assertEquals(1, Expr_654_list.size());
		//654
		final MultiplicativeExpression MultiplicativeExpression_655_Var
		 = (MultiplicativeExpression)Expr_654_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_655_Var
		);
		final EList<? extends EObject> Expr_655_list = MultiplicativeExpression_655_Var
		.getExpr();
		Assert.assertNotNull(Expr_655_list);
		Assert.assertEquals(1, Expr_655_list.size());
		//655
		final CastExpression CastExpression_656_Var
		 = (CastExpression)Expr_655_list.get(0);
		Assert.assertNotNull(CastExpression_656_Var
		);
		//656
		final UnaryExpression UnaryExpression_657_Var
		 = (UnaryExpression)CastExpression_656_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_657_Var
		);
		//657
		final PostfixExpression PostfixExpression_658_Var
		 = (PostfixExpression)UnaryExpression_657_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_658_Var
		);
		final EList<? extends EObject> Expr_658_list = PostfixExpression_658_Var
		.getExpr();
		Assert.assertNotNull(Expr_658_list);
		Assert.assertEquals(1, Expr_658_list.size());
		//658
		final PrimaryExpression PrimaryExpression_659_Var
		 = (PrimaryExpression)Expr_658_list.get(0);
		Assert.assertNotNull(PrimaryExpression_659_Var
		);
		Assert.assertEquals("free", PrimaryExpression_659_Var
		.getId());
		final EList<? extends EObject> Suffix_659_list = PostfixExpression_658_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_659_list);
		Assert.assertEquals(1, Suffix_659_list.size());
		//659
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_660_Var
		 = (PostfixExpressionSuffixArgument)Suffix_659_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_660_Var
		);
		//660
		final ArgumentExpressionList ArgumentExpressionList_661_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_660_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_661_Var
		);
		final EList<? extends EObject> Expr_661_list = ArgumentExpressionList_661_Var
		.getExpr();
		Assert.assertNotNull(Expr_661_list);
		Assert.assertEquals(1, Expr_661_list.size());
		//661
		final AssignmentExpression AssignmentExpression_662_Var
		 = (AssignmentExpression)Expr_661_list.get(0);
		Assert.assertNotNull(AssignmentExpression_662_Var
		);
		//662
		final ConditionalExpression ConditionalExpression_663_Var
		 = (ConditionalExpression)AssignmentExpression_662_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_663_Var
		);
		//663
		final LogicalOrExpression LogicalOrExpression_664_Var
		 = (LogicalOrExpression)ConditionalExpression_663_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_664_Var
		);
		final EList<? extends EObject> Expr_664_list = LogicalOrExpression_664_Var
		.getExpr();
		Assert.assertNotNull(Expr_664_list);
		Assert.assertEquals(1, Expr_664_list.size());
		//664
		final LogicalAndExpression LogicalAndExpression_665_Var
		 = (LogicalAndExpression)Expr_664_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_665_Var
		);
		final EList<? extends EObject> Expr_665_list = LogicalAndExpression_665_Var
		.getExpr();
		Assert.assertNotNull(Expr_665_list);
		Assert.assertEquals(1, Expr_665_list.size());
		//665
		final InclusiveOrExpression InclusiveOrExpression_666_Var
		 = (InclusiveOrExpression)Expr_665_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_666_Var
		);
		final EList<? extends EObject> Expr_666_list = InclusiveOrExpression_666_Var
		.getExpr();
		Assert.assertNotNull(Expr_666_list);
		Assert.assertEquals(1, Expr_666_list.size());
		//666
		final ExclusiveOrExpression ExclusiveOrExpression_667_Var
		 = (ExclusiveOrExpression)Expr_666_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_667_Var
		);
		final EList<? extends EObject> Expr_667_list = ExclusiveOrExpression_667_Var
		.getExpr();
		Assert.assertNotNull(Expr_667_list);
		Assert.assertEquals(1, Expr_667_list.size());
		//667
		final AndExpression AndExpression_668_Var
		 = (AndExpression)Expr_667_list.get(0);
		Assert.assertNotNull(AndExpression_668_Var
		);
		final EList<? extends EObject> Expr_668_list = AndExpression_668_Var
		.getExpr();
		Assert.assertNotNull(Expr_668_list);
		Assert.assertEquals(1, Expr_668_list.size());
		//668
		final EqualityExpression EqualityExpression_669_Var
		 = (EqualityExpression)Expr_668_list.get(0);
		Assert.assertNotNull(EqualityExpression_669_Var
		);
		final EList<? extends EObject> Expr_669_list = EqualityExpression_669_Var
		.getExpr();
		Assert.assertNotNull(Expr_669_list);
		Assert.assertEquals(1, Expr_669_list.size());
		//669
		final RelationalExpression RelationalExpression_670_Var
		 = (RelationalExpression)Expr_669_list.get(0);
		Assert.assertNotNull(RelationalExpression_670_Var
		);
		final EList<? extends EObject> Expr_670_list = RelationalExpression_670_Var
		.getExpr();
		Assert.assertNotNull(Expr_670_list);
		Assert.assertEquals(1, Expr_670_list.size());
		//670
		final ShiftExpression ShiftExpression_671_Var
		 = (ShiftExpression)Expr_670_list.get(0);
		Assert.assertNotNull(ShiftExpression_671_Var
		);
		final EList<? extends EObject> Expr_671_list = ShiftExpression_671_Var
		.getExpr();
		Assert.assertNotNull(Expr_671_list);
		Assert.assertEquals(1, Expr_671_list.size());
		//671
		final AdditiveExpression AdditiveExpression_672_Var
		 = (AdditiveExpression)Expr_671_list.get(0);
		Assert.assertNotNull(AdditiveExpression_672_Var
		);
		final EList<? extends EObject> Expr_672_list = AdditiveExpression_672_Var
		.getExpr();
		Assert.assertNotNull(Expr_672_list);
		Assert.assertEquals(1, Expr_672_list.size());
		//672
		final MultiplicativeExpression MultiplicativeExpression_673_Var
		 = (MultiplicativeExpression)Expr_672_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_673_Var
		);
		final EList<? extends EObject> Expr_673_list = MultiplicativeExpression_673_Var
		.getExpr();
		Assert.assertNotNull(Expr_673_list);
		Assert.assertEquals(1, Expr_673_list.size());
		//673
		final CastExpression CastExpression_674_Var
		 = (CastExpression)Expr_673_list.get(0);
		Assert.assertNotNull(CastExpression_674_Var
		);
		//674
		final UnaryExpression UnaryExpression_675_Var
		 = (UnaryExpression)CastExpression_674_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_675_Var
		);
		//675
		final PostfixExpression PostfixExpression_676_Var
		 = (PostfixExpression)UnaryExpression_675_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_676_Var
		);
		final EList<? extends EObject> Expr_676_list = PostfixExpression_676_Var
		.getExpr();
		Assert.assertNotNull(Expr_676_list);
		Assert.assertEquals(1, Expr_676_list.size());
		//676
		final PrimaryExpression PrimaryExpression_677_Var
		 = (PrimaryExpression)Expr_676_list.get(0);
		Assert.assertNotNull(PrimaryExpression_677_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_677_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_642_Var
		.getSemi());
		//677
		final Statement Statement_678_Var
		 = (Statement)Statement_350_list.get(7);
		Assert.assertNotNull(Statement_678_Var
		);
		//678
		final JumpStatement JumpStatement_679_Var
		 = (JumpStatement)Statement_678_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_679_Var
		);
		//679
		final Expression Expression_680_Var
		 = (Expression)JumpStatement_679_Var
		.getExpr();
		Assert.assertNotNull(Expression_680_Var
		);
		final EList<? extends EObject> ExprExpr_680_list = Expression_680_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_680_list);
		Assert.assertEquals(1, ExprExpr_680_list.size());
		//680
		final AssignmentExpression AssignmentExpression_681_Var
		 = (AssignmentExpression)ExprExpr_680_list.get(0);
		Assert.assertNotNull(AssignmentExpression_681_Var
		);
		//681
		final ConditionalExpression ConditionalExpression_682_Var
		 = (ConditionalExpression)AssignmentExpression_681_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_682_Var
		);
		//682
		final LogicalOrExpression LogicalOrExpression_683_Var
		 = (LogicalOrExpression)ConditionalExpression_682_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_683_Var
		);
		final EList<? extends EObject> Expr_683_list = LogicalOrExpression_683_Var
		.getExpr();
		Assert.assertNotNull(Expr_683_list);
		Assert.assertEquals(1, Expr_683_list.size());
		//683
		final LogicalAndExpression LogicalAndExpression_684_Var
		 = (LogicalAndExpression)Expr_683_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_684_Var
		);
		final EList<? extends EObject> Expr_684_list = LogicalAndExpression_684_Var
		.getExpr();
		Assert.assertNotNull(Expr_684_list);
		Assert.assertEquals(1, Expr_684_list.size());
		//684
		final InclusiveOrExpression InclusiveOrExpression_685_Var
		 = (InclusiveOrExpression)Expr_684_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_685_Var
		);
		final EList<? extends EObject> Expr_685_list = InclusiveOrExpression_685_Var
		.getExpr();
		Assert.assertNotNull(Expr_685_list);
		Assert.assertEquals(1, Expr_685_list.size());
		//685
		final ExclusiveOrExpression ExclusiveOrExpression_686_Var
		 = (ExclusiveOrExpression)Expr_685_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_686_Var
		);
		final EList<? extends EObject> Expr_686_list = ExclusiveOrExpression_686_Var
		.getExpr();
		Assert.assertNotNull(Expr_686_list);
		Assert.assertEquals(1, Expr_686_list.size());
		//686
		final AndExpression AndExpression_687_Var
		 = (AndExpression)Expr_686_list.get(0);
		Assert.assertNotNull(AndExpression_687_Var
		);
		final EList<? extends EObject> Expr_687_list = AndExpression_687_Var
		.getExpr();
		Assert.assertNotNull(Expr_687_list);
		Assert.assertEquals(1, Expr_687_list.size());
		//687
		final EqualityExpression EqualityExpression_688_Var
		 = (EqualityExpression)Expr_687_list.get(0);
		Assert.assertNotNull(EqualityExpression_688_Var
		);
		final EList<? extends EObject> Expr_688_list = EqualityExpression_688_Var
		.getExpr();
		Assert.assertNotNull(Expr_688_list);
		Assert.assertEquals(1, Expr_688_list.size());
		//688
		final RelationalExpression RelationalExpression_689_Var
		 = (RelationalExpression)Expr_688_list.get(0);
		Assert.assertNotNull(RelationalExpression_689_Var
		);
		final EList<? extends EObject> Expr_689_list = RelationalExpression_689_Var
		.getExpr();
		Assert.assertNotNull(Expr_689_list);
		Assert.assertEquals(1, Expr_689_list.size());
		//689
		final ShiftExpression ShiftExpression_690_Var
		 = (ShiftExpression)Expr_689_list.get(0);
		Assert.assertNotNull(ShiftExpression_690_Var
		);
		final EList<? extends EObject> Expr_690_list = ShiftExpression_690_Var
		.getExpr();
		Assert.assertNotNull(Expr_690_list);
		Assert.assertEquals(1, Expr_690_list.size());
		//690
		final AdditiveExpression AdditiveExpression_691_Var
		 = (AdditiveExpression)Expr_690_list.get(0);
		Assert.assertNotNull(AdditiveExpression_691_Var
		);
		final EList<? extends EObject> Expr_691_list = AdditiveExpression_691_Var
		.getExpr();
		Assert.assertNotNull(Expr_691_list);
		Assert.assertEquals(1, Expr_691_list.size());
		//691
		final MultiplicativeExpression MultiplicativeExpression_692_Var
		 = (MultiplicativeExpression)Expr_691_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_692_Var
		);
		final EList<? extends EObject> Expr_692_list = MultiplicativeExpression_692_Var
		.getExpr();
		Assert.assertNotNull(Expr_692_list);
		Assert.assertEquals(1, Expr_692_list.size());
		//692
		final CastExpression CastExpression_693_Var
		 = (CastExpression)Expr_692_list.get(0);
		Assert.assertNotNull(CastExpression_693_Var
		);
		//693
		final UnaryExpression UnaryExpression_694_Var
		 = (UnaryExpression)CastExpression_693_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_694_Var
		);
		//694
		final PostfixExpression PostfixExpression_695_Var
		 = (PostfixExpression)UnaryExpression_694_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_695_Var
		);
		final EList<? extends EObject> Expr_695_list = PostfixExpression_695_Var
		.getExpr();
		Assert.assertNotNull(Expr_695_list);
		Assert.assertEquals(1, Expr_695_list.size());
		//695
		final PrimaryExpression PrimaryExpression_696_Var
		 = (PrimaryExpression)Expr_695_list.get(0);
		Assert.assertNotNull(PrimaryExpression_696_Var
		);
		//696
		final Constant Constant_697_Var
		 = (Constant)PrimaryExpression_696_Var
		.getConst();
		Assert.assertNotNull(Constant_697_Var
		);
		Assert.assertEquals("0", Constant_697_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_679_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_679_Var
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


