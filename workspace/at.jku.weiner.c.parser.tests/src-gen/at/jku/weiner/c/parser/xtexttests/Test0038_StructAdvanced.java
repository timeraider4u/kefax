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
		final EList<? extends EObject> Init_56_list = InitializerList_56_Var
		.getInit();
		Assert.assertNotNull(Init_56_list);
		Assert.assertEquals(2, Init_56_list.size());
		//56
		final Init Init_57_Var
		 = (Init)Init_56_list.get(0);
		Assert.assertNotNull(Init_57_Var
		);
		//57
		final Initializer Initializer_58_Var
		 = (Initializer)Init_57_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_58_Var
		);
		//58
		final AssignmentExpression AssignmentExpression_59_Var
		 = (AssignmentExpression)Initializer_58_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_59_Var
		);
		//59
		final ConditionalExpression ConditionalExpression_60_Var
		 = (ConditionalExpression)AssignmentExpression_59_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_60_Var
		);
		//60
		final LogicalOrExpression LogicalOrExpression_61_Var
		 = (LogicalOrExpression)ConditionalExpression_60_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = LogicalOrExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final LogicalAndExpression LogicalAndExpression_62_Var
		 = (LogicalAndExpression)Expr_61_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = LogicalAndExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final InclusiveOrExpression InclusiveOrExpression_63_Var
		 = (InclusiveOrExpression)Expr_62_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = InclusiveOrExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final ExclusiveOrExpression ExclusiveOrExpression_64_Var
		 = (ExclusiveOrExpression)Expr_63_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = ExclusiveOrExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final AndExpression AndExpression_65_Var
		 = (AndExpression)Expr_64_list.get(0);
		Assert.assertNotNull(AndExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = AndExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final EqualityExpression EqualityExpression_66_Var
		 = (EqualityExpression)Expr_65_list.get(0);
		Assert.assertNotNull(EqualityExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = EqualityExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final RelationalExpression RelationalExpression_67_Var
		 = (RelationalExpression)Expr_66_list.get(0);
		Assert.assertNotNull(RelationalExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = RelationalExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final ShiftExpression ShiftExpression_68_Var
		 = (ShiftExpression)Expr_67_list.get(0);
		Assert.assertNotNull(ShiftExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = ShiftExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final AdditiveExpression AdditiveExpression_69_Var
		 = (AdditiveExpression)Expr_68_list.get(0);
		Assert.assertNotNull(AdditiveExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = AdditiveExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final MultiplicativeExpression MultiplicativeExpression_70_Var
		 = (MultiplicativeExpression)Expr_69_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = MultiplicativeExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final CastExpression CastExpression_71_Var
		 = (CastExpression)Expr_70_list.get(0);
		Assert.assertNotNull(CastExpression_71_Var
		);
		//71
		final UnaryExpression UnaryExpression_72_Var
		 = (UnaryExpression)CastExpression_71_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_72_Var
		);
		//72
		final PostfixExpression PostfixExpression_73_Var
		 = (PostfixExpression)UnaryExpression_72_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = PostfixExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final PrimaryExpression PrimaryExpression_74_Var
		 = (PrimaryExpression)Expr_73_list.get(0);
		Assert.assertNotNull(PrimaryExpression_74_Var
		);
		//74
		final Constant2 Constant2_75_Var
		 = (Constant2)PrimaryExpression_74_Var
		.getConst();
		Assert.assertNotNull(Constant2_75_Var
		);
		Assert.assertEquals("0x007", Constant2_75_Var
		.getHex());
		//75
		final Init Init_76_Var
		 = (Init)Init_56_list.get(1);
		Assert.assertNotNull(Init_76_Var
		);
		//76
		final Initializer Initializer_77_Var
		 = (Initializer)Init_76_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_77_Var
		);
		//77
		final AssignmentExpression AssignmentExpression_78_Var
		 = (AssignmentExpression)Initializer_77_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_78_Var
		);
		//78
		final ConditionalExpression ConditionalExpression_79_Var
		 = (ConditionalExpression)AssignmentExpression_78_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_79_Var
		);
		//79
		final LogicalOrExpression LogicalOrExpression_80_Var
		 = (LogicalOrExpression)ConditionalExpression_79_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = LogicalOrExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final LogicalAndExpression LogicalAndExpression_81_Var
		 = (LogicalAndExpression)Expr_80_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = LogicalAndExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final InclusiveOrExpression InclusiveOrExpression_82_Var
		 = (InclusiveOrExpression)Expr_81_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = InclusiveOrExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final ExclusiveOrExpression ExclusiveOrExpression_83_Var
		 = (ExclusiveOrExpression)Expr_82_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = ExclusiveOrExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final AndExpression AndExpression_84_Var
		 = (AndExpression)Expr_83_list.get(0);
		Assert.assertNotNull(AndExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = AndExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final EqualityExpression EqualityExpression_85_Var
		 = (EqualityExpression)Expr_84_list.get(0);
		Assert.assertNotNull(EqualityExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = EqualityExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final RelationalExpression RelationalExpression_86_Var
		 = (RelationalExpression)Expr_85_list.get(0);
		Assert.assertNotNull(RelationalExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = RelationalExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final ShiftExpression ShiftExpression_87_Var
		 = (ShiftExpression)Expr_86_list.get(0);
		Assert.assertNotNull(ShiftExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = ShiftExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final AdditiveExpression AdditiveExpression_88_Var
		 = (AdditiveExpression)Expr_87_list.get(0);
		Assert.assertNotNull(AdditiveExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = AdditiveExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final MultiplicativeExpression MultiplicativeExpression_89_Var
		 = (MultiplicativeExpression)Expr_88_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = MultiplicativeExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final CastExpression CastExpression_90_Var
		 = (CastExpression)Expr_89_list.get(0);
		Assert.assertNotNull(CastExpression_90_Var
		);
		//90
		final UnaryExpression UnaryExpression_91_Var
		 = (UnaryExpression)CastExpression_90_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_91_Var
		);
		//91
		final PostfixExpression PostfixExpression_92_Var
		 = (PostfixExpression)UnaryExpression_91_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = PostfixExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final PrimaryExpression PrimaryExpression_93_Var
		 = (PrimaryExpression)Expr_92_list.get(0);
		Assert.assertNotNull(PrimaryExpression_93_Var
		);
		Assert.assertEquals("[\"Joe Nobody\"]", PrimaryExpression_93_Var
		.getString().toString());
		//93
		final ExternalDeclaration ExternalDeclaration_94_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_94_Var
		);
		//94
		final Declaration Declaration_95_Var
		 = (Declaration)ExternalDeclaration_94_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_95_Var
		);
		//95
		final DeclarationSpecifiers DeclarationSpecifiers_96_Var
		 = (DeclarationSpecifiers)Declaration_95_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_96_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_96_list = DeclarationSpecifiers_96_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_96_list);
		Assert.assertEquals(1, DeclarationSpecifier_96_list.size());
		//96
		final TypeSpecifier TypeSpecifier_97_Var
		 = (TypeSpecifier)DeclarationSpecifier_96_list.get(0);
		Assert.assertNotNull(TypeSpecifier_97_Var
		);
		//97
		final TypedefName TypedefName_98_Var
		 = (TypedefName)TypeSpecifier_97_Var
		.getType();
		Assert.assertNotNull(TypedefName_98_Var
		);
		Assert.assertEquals("employee", TypedefName_98_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_98_list = Declaration_95_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_98_list);
		Assert.assertEquals(1, InitDeclaratorList_98_list.size());
		//98
		final InitDeclaratorList InitDeclaratorList_99_Var
		 = (InitDeclaratorList)InitDeclaratorList_98_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_99_Var
		);
		final EList<? extends EObject> InitDeclarator_99_list = InitDeclaratorList_99_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_99_list);
		Assert.assertEquals(1, InitDeclarator_99_list.size());
		//99
		final InitDeclarator InitDeclarator_100_Var
		 = (InitDeclarator)InitDeclarator_99_list.get(0);
		Assert.assertNotNull(InitDeclarator_100_Var
		);
		//100
		final Declarator Declarator_101_Var
		 = (Declarator)InitDeclarator_100_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_101_Var
		);
		//101
		final DirectDeclarator DirectDeclarator_102_Var
		 = (DirectDeclarator)Declarator_101_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_102_Var
		);
		Assert.assertEquals("phil", DirectDeclarator_102_Var
		.getId());
		//102
		final Initializer Initializer_103_Var
		 = (Initializer)InitDeclarator_100_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_103_Var
		);
		//103
		final InitializerList InitializerList_104_Var
		 = (InitializerList)Initializer_103_Var
		.getList();
		Assert.assertNotNull(InitializerList_104_Var
		);
		final EList<? extends EObject> Init_104_list = InitializerList_104_Var
		.getInit();
		Assert.assertNotNull(Init_104_list);
		Assert.assertEquals(2, Init_104_list.size());
		//104
		final Init Init_105_Var
		 = (Init)Init_104_list.get(0);
		Assert.assertNotNull(Init_105_Var
		);
		//105
		final Initializer Initializer_106_Var
		 = (Initializer)Init_105_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_106_Var
		);
		//106
		final AssignmentExpression AssignmentExpression_107_Var
		 = (AssignmentExpression)Initializer_106_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_107_Var
		);
		//107
		final ConditionalExpression ConditionalExpression_108_Var
		 = (ConditionalExpression)AssignmentExpression_107_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_108_Var
		);
		//108
		final LogicalOrExpression LogicalOrExpression_109_Var
		 = (LogicalOrExpression)ConditionalExpression_108_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = LogicalOrExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final LogicalAndExpression LogicalAndExpression_110_Var
		 = (LogicalAndExpression)Expr_109_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = LogicalAndExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final InclusiveOrExpression InclusiveOrExpression_111_Var
		 = (InclusiveOrExpression)Expr_110_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = InclusiveOrExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final ExclusiveOrExpression ExclusiveOrExpression_112_Var
		 = (ExclusiveOrExpression)Expr_111_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = ExclusiveOrExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final AndExpression AndExpression_113_Var
		 = (AndExpression)Expr_112_list.get(0);
		Assert.assertNotNull(AndExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = AndExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final EqualityExpression EqualityExpression_114_Var
		 = (EqualityExpression)Expr_113_list.get(0);
		Assert.assertNotNull(EqualityExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = EqualityExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final RelationalExpression RelationalExpression_115_Var
		 = (RelationalExpression)Expr_114_list.get(0);
		Assert.assertNotNull(RelationalExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = RelationalExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final ShiftExpression ShiftExpression_116_Var
		 = (ShiftExpression)Expr_115_list.get(0);
		Assert.assertNotNull(ShiftExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = ShiftExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final AdditiveExpression AdditiveExpression_117_Var
		 = (AdditiveExpression)Expr_116_list.get(0);
		Assert.assertNotNull(AdditiveExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = AdditiveExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final MultiplicativeExpression MultiplicativeExpression_118_Var
		 = (MultiplicativeExpression)Expr_117_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = MultiplicativeExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final CastExpression CastExpression_119_Var
		 = (CastExpression)Expr_118_list.get(0);
		Assert.assertNotNull(CastExpression_119_Var
		);
		//119
		final UnaryExpression UnaryExpression_120_Var
		 = (UnaryExpression)CastExpression_119_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_120_Var
		);
		//120
		final PostfixExpression PostfixExpression_121_Var
		 = (PostfixExpression)UnaryExpression_120_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = PostfixExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final PrimaryExpression PrimaryExpression_122_Var
		 = (PrimaryExpression)Expr_121_list.get(0);
		Assert.assertNotNull(PrimaryExpression_122_Var
		);
		//122
		final Constant2 Constant2_123_Var
		 = (Constant2)PrimaryExpression_122_Var
		.getConst();
		Assert.assertNotNull(Constant2_123_Var
		);
		Assert.assertEquals("0x008", Constant2_123_Var
		.getHex());
		//123
		final Init Init_124_Var
		 = (Init)Init_104_list.get(1);
		Assert.assertNotNull(Init_124_Var
		);
		//124
		final Initializer Initializer_125_Var
		 = (Initializer)Init_124_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_125_Var
		);
		//125
		final AssignmentExpression AssignmentExpression_126_Var
		 = (AssignmentExpression)Initializer_125_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_126_Var
		);
		//126
		final ConditionalExpression ConditionalExpression_127_Var
		 = (ConditionalExpression)AssignmentExpression_126_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_127_Var
		);
		//127
		final LogicalOrExpression LogicalOrExpression_128_Var
		 = (LogicalOrExpression)ConditionalExpression_127_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = LogicalOrExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final LogicalAndExpression LogicalAndExpression_129_Var
		 = (LogicalAndExpression)Expr_128_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = LogicalAndExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final InclusiveOrExpression InclusiveOrExpression_130_Var
		 = (InclusiveOrExpression)Expr_129_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = InclusiveOrExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final ExclusiveOrExpression ExclusiveOrExpression_131_Var
		 = (ExclusiveOrExpression)Expr_130_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = ExclusiveOrExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final AndExpression AndExpression_132_Var
		 = (AndExpression)Expr_131_list.get(0);
		Assert.assertNotNull(AndExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = AndExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final EqualityExpression EqualityExpression_133_Var
		 = (EqualityExpression)Expr_132_list.get(0);
		Assert.assertNotNull(EqualityExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = EqualityExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final RelationalExpression RelationalExpression_134_Var
		 = (RelationalExpression)Expr_133_list.get(0);
		Assert.assertNotNull(RelationalExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = RelationalExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final ShiftExpression ShiftExpression_135_Var
		 = (ShiftExpression)Expr_134_list.get(0);
		Assert.assertNotNull(ShiftExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = ShiftExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final AdditiveExpression AdditiveExpression_136_Var
		 = (AdditiveExpression)Expr_135_list.get(0);
		Assert.assertNotNull(AdditiveExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = AdditiveExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final MultiplicativeExpression MultiplicativeExpression_137_Var
		 = (MultiplicativeExpression)Expr_136_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = MultiplicativeExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final CastExpression CastExpression_138_Var
		 = (CastExpression)Expr_137_list.get(0);
		Assert.assertNotNull(CastExpression_138_Var
		);
		//138
		final UnaryExpression UnaryExpression_139_Var
		 = (UnaryExpression)CastExpression_138_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_139_Var
		);
		//139
		final PostfixExpression PostfixExpression_140_Var
		 = (PostfixExpression)UnaryExpression_139_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = PostfixExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final PrimaryExpression PrimaryExpression_141_Var
		 = (PrimaryExpression)Expr_140_list.get(0);
		Assert.assertNotNull(PrimaryExpression_141_Var
		);
		Assert.assertEquals("[\"Phil Morrison\"]", PrimaryExpression_141_Var
		.getString().toString());
		//141
		final ExternalDeclaration ExternalDeclaration_142_Var
		 = (ExternalDeclaration)External_0_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_142_Var
		);
		//142
		final FunctionDefHead FunctionDefHead_143_Var
		 = (FunctionDefHead)ExternalDeclaration_142_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_143_Var
		);
		//143
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_144_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_143_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_144_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_144_list = FunctionDeclarationSpecifiers_144_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_144_list);
		Assert.assertEquals(1, DeclarationSpecifier_144_list.size());
		//144
		final TypeSpecifier TypeSpecifier_145_Var
		 = (TypeSpecifier)DeclarationSpecifier_144_list.get(0);
		Assert.assertNotNull(TypeSpecifier_145_Var
		);
		Assert.assertEquals("void", TypeSpecifier_145_Var
		.getName());
		//145
		final Declarator Declarator_146_Var
		 = (Declarator)FunctionDefHead_143_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_146_Var
		);
		//146
		final DirectDeclarator DirectDeclarator_147_Var
		 = (DirectDeclarator)Declarator_146_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_147_Var
		);
		Assert.assertEquals("print", DirectDeclarator_147_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_147_list = DirectDeclarator_147_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_147_list);
		Assert.assertEquals(1, DeclaratorSuffix_147_list.size());
		//147
		final DeclaratorSuffix DeclaratorSuffix_148_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_147_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_148_Var
		);
		//148
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_149_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_148_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_149_Var
		);
		final EList<? extends EObject> ParameterTypeList_149_list = DirectDeclaratorLastSuffix_149_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_149_list);
		Assert.assertEquals(1, ParameterTypeList_149_list.size());
		//149
		final ParameterTypeList ParameterTypeList_150_Var
		 = (ParameterTypeList)ParameterTypeList_149_list.get(0);
		Assert.assertNotNull(ParameterTypeList_150_Var
		);
		//150
		final ParameterList ParameterList_151_Var
		 = (ParameterList)ParameterTypeList_150_Var
		.getList();
		Assert.assertNotNull(ParameterList_151_Var
		);
		final EList<? extends EObject> ParameterDeclaration_151_list = ParameterList_151_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_151_list);
		Assert.assertEquals(1, ParameterDeclaration_151_list.size());
		//151
		final ParameterDeclaration ParameterDeclaration_152_Var
		 = (ParameterDeclaration)ParameterDeclaration_151_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_152_Var
		);
		//152
		final DeclarationSpecifiers DeclarationSpecifiers_153_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_152_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_153_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_153_list = DeclarationSpecifiers_153_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_153_list);
		Assert.assertEquals(1, DeclarationSpecifier_153_list.size());
		//153
		final TypeSpecifier TypeSpecifier_154_Var
		 = (TypeSpecifier)DeclarationSpecifier_153_list.get(0);
		Assert.assertNotNull(TypeSpecifier_154_Var
		);
		//154
		final TypedefName TypedefName_155_Var
		 = (TypedefName)TypeSpecifier_154_Var
		.getType();
		Assert.assertNotNull(TypedefName_155_Var
		);
		Assert.assertEquals("employee", TypedefName_155_Var
		.getId());
		//155
		final Declarator Declarator_156_Var
		 = (Declarator)ParameterDeclaration_152_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_156_Var
		);
		//156
		final DirectDeclarator DirectDeclarator_157_Var
		 = (DirectDeclarator)Declarator_156_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_157_Var
		);
		Assert.assertEquals("emp", DirectDeclarator_157_Var
		.getId());
		//157
		final Pointer Pointer_158_Var
		 = (Pointer)Declarator_156_Var
		.getPointer();
		Assert.assertNotNull(Pointer_158_Var
		);
		Assert.assertEquals("[*]", Pointer_158_Var
		.getStar().toString());
		//158
		final FunctionDefinition FunctionDefinition_159_Var
		 = (FunctionDefinition)ExternalDeclaration_142_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_159_Var
		);
		//159
		final BodyStatement BodyStatement_160_Var
		 = (BodyStatement)FunctionDefinition_159_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_160_Var
		);
		final EList<? extends EObject> BlockList_160_list = BodyStatement_160_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_160_list);
		Assert.assertEquals(1, BlockList_160_list.size());
		//160
		final BlockList BlockList_161_Var
		 = (BlockList)BlockList_160_list.get(0);
		Assert.assertNotNull(BlockList_161_Var
		);
		final EList<? extends EObject> Statement_161_list = BlockList_161_Var
		.getStatement();
		Assert.assertNotNull(Statement_161_list);
		Assert.assertEquals(2, Statement_161_list.size());
		//161
		final Statement Statement_162_Var
		 = (Statement)Statement_161_list.get(0);
		Assert.assertNotNull(Statement_162_Var
		);
		//162
		final ExpressionStatement ExpressionStatement_163_Var
		 = (ExpressionStatement)Statement_162_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_163_Var
		);
		//163
		final Expression Expression_164_Var
		 = (Expression)ExpressionStatement_163_Var
		.getExpression();
		Assert.assertNotNull(Expression_164_Var
		);
		final EList<? extends EObject> ExprExpr_164_list = Expression_164_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_164_list);
		Assert.assertEquals(1, ExprExpr_164_list.size());
		//164
		final AssignmentExpression AssignmentExpression_165_Var
		 = (AssignmentExpression)ExprExpr_164_list.get(0);
		Assert.assertNotNull(AssignmentExpression_165_Var
		);
		//165
		final ConditionalExpression ConditionalExpression_166_Var
		 = (ConditionalExpression)AssignmentExpression_165_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_166_Var
		);
		//166
		final LogicalOrExpression LogicalOrExpression_167_Var
		 = (LogicalOrExpression)ConditionalExpression_166_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_167_Var
		);
		final EList<? extends EObject> Expr_167_list = LogicalOrExpression_167_Var
		.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(1, Expr_167_list.size());
		//167
		final LogicalAndExpression LogicalAndExpression_168_Var
		 = (LogicalAndExpression)Expr_167_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_168_Var
		);
		final EList<? extends EObject> Expr_168_list = LogicalAndExpression_168_Var
		.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(1, Expr_168_list.size());
		//168
		final InclusiveOrExpression InclusiveOrExpression_169_Var
		 = (InclusiveOrExpression)Expr_168_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_169_Var
		);
		final EList<? extends EObject> Expr_169_list = InclusiveOrExpression_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		//169
		final ExclusiveOrExpression ExclusiveOrExpression_170_Var
		 = (ExclusiveOrExpression)Expr_169_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_170_Var
		);
		final EList<? extends EObject> Expr_170_list = ExclusiveOrExpression_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		//170
		final AndExpression AndExpression_171_Var
		 = (AndExpression)Expr_170_list.get(0);
		Assert.assertNotNull(AndExpression_171_Var
		);
		final EList<? extends EObject> Expr_171_list = AndExpression_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		//171
		final EqualityExpression EqualityExpression_172_Var
		 = (EqualityExpression)Expr_171_list.get(0);
		Assert.assertNotNull(EqualityExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = EqualityExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final RelationalExpression RelationalExpression_173_Var
		 = (RelationalExpression)Expr_172_list.get(0);
		Assert.assertNotNull(RelationalExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = RelationalExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final ShiftExpression ShiftExpression_174_Var
		 = (ShiftExpression)Expr_173_list.get(0);
		Assert.assertNotNull(ShiftExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = ShiftExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final AdditiveExpression AdditiveExpression_175_Var
		 = (AdditiveExpression)Expr_174_list.get(0);
		Assert.assertNotNull(AdditiveExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = AdditiveExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final MultiplicativeExpression MultiplicativeExpression_176_Var
		 = (MultiplicativeExpression)Expr_175_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = MultiplicativeExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final CastExpression CastExpression_177_Var
		 = (CastExpression)Expr_176_list.get(0);
		Assert.assertNotNull(CastExpression_177_Var
		);
		//177
		final UnaryExpression UnaryExpression_178_Var
		 = (UnaryExpression)CastExpression_177_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_178_Var
		);
		//178
		final PostfixExpression PostfixExpression_179_Var
		 = (PostfixExpression)UnaryExpression_178_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = PostfixExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final PrimaryExpression PrimaryExpression_180_Var
		 = (PrimaryExpression)Expr_179_list.get(0);
		Assert.assertNotNull(PrimaryExpression_180_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_180_Var
		.getId());
		final EList<? extends EObject> Suffix_180_list = PostfixExpression_179_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_180_list);
		Assert.assertEquals(1, Suffix_180_list.size());
		//180
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_181_Var
		 = (PostfixExpressionSuffixArgument)Suffix_180_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_181_Var
		);
		//181
		final ArgumentExpressionList ArgumentExpressionList_182_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_181_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_182_Var
		);
		final EList<? extends EObject> Expr_182_list = ArgumentExpressionList_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(2, Expr_182_list.size());
		//182
		final AssignmentExpression AssignmentExpression_183_Var
		 = (AssignmentExpression)Expr_182_list.get(0);
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
		Assert.assertEquals("[\"(*employee).id=%d\\n\"]", PrimaryExpression_198_Var
		.getString().toString());
		//198
		final AssignmentExpression AssignmentExpression_199_Var
		 = (AssignmentExpression)Expr_182_list.get(1);
		Assert.assertNotNull(AssignmentExpression_199_Var
		);
		//199
		final ConditionalExpression ConditionalExpression_200_Var
		 = (ConditionalExpression)AssignmentExpression_199_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_200_Var
		);
		//200
		final LogicalOrExpression LogicalOrExpression_201_Var
		 = (LogicalOrExpression)ConditionalExpression_200_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = LogicalOrExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final LogicalAndExpression LogicalAndExpression_202_Var
		 = (LogicalAndExpression)Expr_201_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = LogicalAndExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final InclusiveOrExpression InclusiveOrExpression_203_Var
		 = (InclusiveOrExpression)Expr_202_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = InclusiveOrExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final ExclusiveOrExpression ExclusiveOrExpression_204_Var
		 = (ExclusiveOrExpression)Expr_203_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = ExclusiveOrExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final AndExpression AndExpression_205_Var
		 = (AndExpression)Expr_204_list.get(0);
		Assert.assertNotNull(AndExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = AndExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final EqualityExpression EqualityExpression_206_Var
		 = (EqualityExpression)Expr_205_list.get(0);
		Assert.assertNotNull(EqualityExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = EqualityExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final RelationalExpression RelationalExpression_207_Var
		 = (RelationalExpression)Expr_206_list.get(0);
		Assert.assertNotNull(RelationalExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = RelationalExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final ShiftExpression ShiftExpression_208_Var
		 = (ShiftExpression)Expr_207_list.get(0);
		Assert.assertNotNull(ShiftExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = ShiftExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final AdditiveExpression AdditiveExpression_209_Var
		 = (AdditiveExpression)Expr_208_list.get(0);
		Assert.assertNotNull(AdditiveExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = AdditiveExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final MultiplicativeExpression MultiplicativeExpression_210_Var
		 = (MultiplicativeExpression)Expr_209_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = MultiplicativeExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final CastExpression CastExpression_211_Var
		 = (CastExpression)Expr_210_list.get(0);
		Assert.assertNotNull(CastExpression_211_Var
		);
		//211
		final UnaryExpression UnaryExpression_212_Var
		 = (UnaryExpression)CastExpression_211_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_212_Var
		);
		//212
		final PostfixExpression PostfixExpression_213_Var
		 = (PostfixExpression)UnaryExpression_212_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = PostfixExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final PrimaryExpression PrimaryExpression_214_Var
		 = (PrimaryExpression)Expr_213_list.get(0);
		Assert.assertNotNull(PrimaryExpression_214_Var
		);
		//214
		final Expression Expression_215_Var
		 = (Expression)PrimaryExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expression_215_Var
		);
		final EList<? extends EObject> ExprExpr_215_list = Expression_215_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_215_list);
		Assert.assertEquals(1, ExprExpr_215_list.size());
		//215
		final AssignmentExpression AssignmentExpression_216_Var
		 = (AssignmentExpression)ExprExpr_215_list.get(0);
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
		//229
		final UnaryOperator UnaryOperator_230_Var
		 = (UnaryOperator)UnaryExpression_229_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_230_Var
		);
		Assert.assertEquals("*", UnaryOperator_230_Var
		.getOp());
		//230
		final CastExpression CastExpression_231_Var
		 = (CastExpression)UnaryExpression_229_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_231_Var
		);
		//231
		final UnaryExpression UnaryExpression_232_Var
		 = (UnaryExpression)CastExpression_231_Var
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
		Assert.assertEquals("emp", PrimaryExpression_234_Var
		.getId());
		final EList<? extends EObject> Suffix_234_list = PostfixExpression_213_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_234_list);
		Assert.assertEquals(1, Suffix_234_list.size());
		//234
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_235_Var
		 = (PostfixExpressionSuffixDot)Suffix_234_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_235_Var
		);
		Assert.assertEquals("id", PostfixExpressionSuffixDot_235_Var
		.getId());
		//235
		final Statement Statement_236_Var
		 = (Statement)Statement_161_list.get(1);
		Assert.assertNotNull(Statement_236_Var
		);
		//236
		final ExpressionStatement ExpressionStatement_237_Var
		 = (ExpressionStatement)Statement_236_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_237_Var
		);
		//237
		final Expression Expression_238_Var
		 = (Expression)ExpressionStatement_237_Var
		.getExpression();
		Assert.assertNotNull(Expression_238_Var
		);
		final EList<? extends EObject> ExprExpr_238_list = Expression_238_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_238_list);
		Assert.assertEquals(1, ExprExpr_238_list.size());
		//238
		final AssignmentExpression AssignmentExpression_239_Var
		 = (AssignmentExpression)ExprExpr_238_list.get(0);
		Assert.assertNotNull(AssignmentExpression_239_Var
		);
		//239
		final ConditionalExpression ConditionalExpression_240_Var
		 = (ConditionalExpression)AssignmentExpression_239_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_240_Var
		);
		//240
		final LogicalOrExpression LogicalOrExpression_241_Var
		 = (LogicalOrExpression)ConditionalExpression_240_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = LogicalOrExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final LogicalAndExpression LogicalAndExpression_242_Var
		 = (LogicalAndExpression)Expr_241_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = LogicalAndExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final InclusiveOrExpression InclusiveOrExpression_243_Var
		 = (InclusiveOrExpression)Expr_242_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = InclusiveOrExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final ExclusiveOrExpression ExclusiveOrExpression_244_Var
		 = (ExclusiveOrExpression)Expr_243_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = ExclusiveOrExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final AndExpression AndExpression_245_Var
		 = (AndExpression)Expr_244_list.get(0);
		Assert.assertNotNull(AndExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = AndExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final EqualityExpression EqualityExpression_246_Var
		 = (EqualityExpression)Expr_245_list.get(0);
		Assert.assertNotNull(EqualityExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = EqualityExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final RelationalExpression RelationalExpression_247_Var
		 = (RelationalExpression)Expr_246_list.get(0);
		Assert.assertNotNull(RelationalExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = RelationalExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final ShiftExpression ShiftExpression_248_Var
		 = (ShiftExpression)Expr_247_list.get(0);
		Assert.assertNotNull(ShiftExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = ShiftExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final AdditiveExpression AdditiveExpression_249_Var
		 = (AdditiveExpression)Expr_248_list.get(0);
		Assert.assertNotNull(AdditiveExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = AdditiveExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final MultiplicativeExpression MultiplicativeExpression_250_Var
		 = (MultiplicativeExpression)Expr_249_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = MultiplicativeExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final CastExpression CastExpression_251_Var
		 = (CastExpression)Expr_250_list.get(0);
		Assert.assertNotNull(CastExpression_251_Var
		);
		//251
		final UnaryExpression UnaryExpression_252_Var
		 = (UnaryExpression)CastExpression_251_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_252_Var
		);
		//252
		final PostfixExpression PostfixExpression_253_Var
		 = (PostfixExpression)UnaryExpression_252_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = PostfixExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final PrimaryExpression PrimaryExpression_254_Var
		 = (PrimaryExpression)Expr_253_list.get(0);
		Assert.assertNotNull(PrimaryExpression_254_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_254_Var
		.getId());
		final EList<? extends EObject> Suffix_254_list = PostfixExpression_253_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_254_list);
		Assert.assertEquals(1, Suffix_254_list.size());
		//254
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_255_Var
		 = (PostfixExpressionSuffixArgument)Suffix_254_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_255_Var
		);
		//255
		final ArgumentExpressionList ArgumentExpressionList_256_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_255_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_256_Var
		);
		final EList<? extends EObject> Expr_256_list = ArgumentExpressionList_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(2, Expr_256_list.size());
		//256
		final AssignmentExpression AssignmentExpression_257_Var
		 = (AssignmentExpression)Expr_256_list.get(0);
		Assert.assertNotNull(AssignmentExpression_257_Var
		);
		//257
		final ConditionalExpression ConditionalExpression_258_Var
		 = (ConditionalExpression)AssignmentExpression_257_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_258_Var
		);
		//258
		final LogicalOrExpression LogicalOrExpression_259_Var
		 = (LogicalOrExpression)ConditionalExpression_258_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_259_Var
		);
		final EList<? extends EObject> Expr_259_list = LogicalOrExpression_259_Var
		.getExpr();
		Assert.assertNotNull(Expr_259_list);
		Assert.assertEquals(1, Expr_259_list.size());
		//259
		final LogicalAndExpression LogicalAndExpression_260_Var
		 = (LogicalAndExpression)Expr_259_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = LogicalAndExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final InclusiveOrExpression InclusiveOrExpression_261_Var
		 = (InclusiveOrExpression)Expr_260_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = InclusiveOrExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final ExclusiveOrExpression ExclusiveOrExpression_262_Var
		 = (ExclusiveOrExpression)Expr_261_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_262_Var
		);
		final EList<? extends EObject> Expr_262_list = ExclusiveOrExpression_262_Var
		.getExpr();
		Assert.assertNotNull(Expr_262_list);
		Assert.assertEquals(1, Expr_262_list.size());
		//262
		final AndExpression AndExpression_263_Var
		 = (AndExpression)Expr_262_list.get(0);
		Assert.assertNotNull(AndExpression_263_Var
		);
		final EList<? extends EObject> Expr_263_list = AndExpression_263_Var
		.getExpr();
		Assert.assertNotNull(Expr_263_list);
		Assert.assertEquals(1, Expr_263_list.size());
		//263
		final EqualityExpression EqualityExpression_264_Var
		 = (EqualityExpression)Expr_263_list.get(0);
		Assert.assertNotNull(EqualityExpression_264_Var
		);
		final EList<? extends EObject> Expr_264_list = EqualityExpression_264_Var
		.getExpr();
		Assert.assertNotNull(Expr_264_list);
		Assert.assertEquals(1, Expr_264_list.size());
		//264
		final RelationalExpression RelationalExpression_265_Var
		 = (RelationalExpression)Expr_264_list.get(0);
		Assert.assertNotNull(RelationalExpression_265_Var
		);
		final EList<? extends EObject> Expr_265_list = RelationalExpression_265_Var
		.getExpr();
		Assert.assertNotNull(Expr_265_list);
		Assert.assertEquals(1, Expr_265_list.size());
		//265
		final ShiftExpression ShiftExpression_266_Var
		 = (ShiftExpression)Expr_265_list.get(0);
		Assert.assertNotNull(ShiftExpression_266_Var
		);
		final EList<? extends EObject> Expr_266_list = ShiftExpression_266_Var
		.getExpr();
		Assert.assertNotNull(Expr_266_list);
		Assert.assertEquals(1, Expr_266_list.size());
		//266
		final AdditiveExpression AdditiveExpression_267_Var
		 = (AdditiveExpression)Expr_266_list.get(0);
		Assert.assertNotNull(AdditiveExpression_267_Var
		);
		final EList<? extends EObject> Expr_267_list = AdditiveExpression_267_Var
		.getExpr();
		Assert.assertNotNull(Expr_267_list);
		Assert.assertEquals(1, Expr_267_list.size());
		//267
		final MultiplicativeExpression MultiplicativeExpression_268_Var
		 = (MultiplicativeExpression)Expr_267_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_268_Var
		);
		final EList<? extends EObject> Expr_268_list = MultiplicativeExpression_268_Var
		.getExpr();
		Assert.assertNotNull(Expr_268_list);
		Assert.assertEquals(1, Expr_268_list.size());
		//268
		final CastExpression CastExpression_269_Var
		 = (CastExpression)Expr_268_list.get(0);
		Assert.assertNotNull(CastExpression_269_Var
		);
		//269
		final UnaryExpression UnaryExpression_270_Var
		 = (UnaryExpression)CastExpression_269_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_270_Var
		);
		//270
		final PostfixExpression PostfixExpression_271_Var
		 = (PostfixExpression)UnaryExpression_270_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_271_Var
		);
		final EList<? extends EObject> Expr_271_list = PostfixExpression_271_Var
		.getExpr();
		Assert.assertNotNull(Expr_271_list);
		Assert.assertEquals(1, Expr_271_list.size());
		//271
		final PrimaryExpression PrimaryExpression_272_Var
		 = (PrimaryExpression)Expr_271_list.get(0);
		Assert.assertNotNull(PrimaryExpression_272_Var
		);
		Assert.assertEquals("[\"employee->name=%s\\n\"]", PrimaryExpression_272_Var
		.getString().toString());
		//272
		final AssignmentExpression AssignmentExpression_273_Var
		 = (AssignmentExpression)Expr_256_list.get(1);
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
		//289
		final ExternalDeclaration ExternalDeclaration_290_Var
		 = (ExternalDeclaration)External_0_list.get(4);
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
		Assert.assertEquals("[\"Could not reserve space for new employee!\\n\"]", PrimaryExpression_419_Var
		.getString().toString());
		//419
		final Statement Statement_420_Var
		 = (Statement)Statement_382_list.get(1);
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
		final Constant2 Constant2_442_Var
		 = (Constant2)PrimaryExpression_441_Var
		.getConst();
		Assert.assertNotNull(Constant2_442_Var
		);
		Assert.assertEquals("1", Constant2_442_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_421_Var
		.getReturn());
		//442
		final Statement Statement_443_Var
		 = (Statement)Statement_351_list.get(1);
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
		//482
		final Statement Statement_483_Var
		 = (Statement)Statement_351_list.get(2);
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
		//522
		final Statement Statement_523_Var
		 = (Statement)Statement_351_list.get(3);
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
		final Constant2 Constant2_548_Var
		 = (Constant2)PrimaryExpression_547_Var
		.getConst();
		Assert.assertNotNull(Constant2_548_Var
		);
		Assert.assertEquals("0x009", Constant2_548_Var
		.getHex());
		//548
		final Statement Statement_549_Var
		 = (Statement)Statement_351_list.get(4);
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
		Assert.assertEquals("[\"Billy The Kid\"]", PrimaryExpression_602_Var
		.getString().toString());
		//602
		final Statement Statement_603_Var
		 = (Statement)Statement_351_list.get(5);
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
		//639
		final Statement Statement_640_Var
		 = (Statement)Statement_351_list.get(6);
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
		//676
		final Statement Statement_677_Var
		 = (Statement)Statement_351_list.get(7);
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


