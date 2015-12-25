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
		Assert.assertEquals("union", StructOrUnion_5_Var
		.getName());
		Assert.assertEquals("num", StructOrUnionSpecifier_4_Var
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
		Assert.assertEquals("char", TypeSpecifier_9_Var
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
		Assert.assertEquals("numChar", DirectDeclarator_13_Var
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
		Assert.assertEquals("float", TypeSpecifier_16_Var
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
		Assert.assertEquals("numFloat", DirectDeclarator_20_Var
		.getId());
		//20
		final ExternalDeclaration ExternalDeclaration_21_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_21_Var
		);
		//21
		final Declaration Declaration_22_Var
		 = (Declaration)ExternalDeclaration_21_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_22_Var
		);
		//22
		final DeclarationSpecifiers DeclarationSpecifiers_23_Var
		 = (DeclarationSpecifiers)Declaration_22_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_23_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_23_list = DeclarationSpecifiers_23_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_23_list);
		Assert.assertEquals(1, DeclarationSpecifier_23_list.size());
		//23
		final StructOrUnionSpecifier StructOrUnionSpecifier_24_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_23_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_24_Var
		);
		//24
		final StructOrUnion StructOrUnion_25_Var
		 = (StructOrUnion)StructOrUnionSpecifier_24_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_25_Var
		);
		Assert.assertEquals("union", StructOrUnion_25_Var
		.getName());
		Assert.assertEquals("num", StructOrUnionSpecifier_24_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_25_list = Declaration_22_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_25_list);
		Assert.assertEquals(1, InitDeclaratorList_25_list.size());
		//25
		final InitDeclaratorList InitDeclaratorList_26_Var
		 = (InitDeclaratorList)InitDeclaratorList_25_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_26_Var
		);
		final EList<? extends EObject> InitDeclarator_26_list = InitDeclaratorList_26_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_26_list);
		Assert.assertEquals(1, InitDeclarator_26_list.size());
		//26
		final InitDeclarator InitDeclarator_27_Var
		 = (InitDeclarator)InitDeclarator_26_list.get(0);
		Assert.assertNotNull(InitDeclarator_27_Var
		);
		//27
		final Declarator Declarator_28_Var
		 = (Declarator)InitDeclarator_27_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_28_Var
		);
		//28
		final DirectDeclarator DirectDeclarator_29_Var
		 = (DirectDeclarator)Declarator_28_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_29_Var
		);
		Assert.assertEquals("number", DirectDeclarator_29_Var
		.getId());
		//29
		final ExternalDeclaration ExternalDeclaration_30_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_30_Var
		);
		//30
		final FunctionDefHead FunctionDefHead_31_Var
		 = (FunctionDefHead)ExternalDeclaration_30_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_31_Var
		);
		//31
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_32_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_31_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_32_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_32_list = FunctionDeclarationSpecifiers_32_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_32_list);
		Assert.assertEquals(1, DeclarationSpecifier_32_list.size());
		//32
		final TypeSpecifier TypeSpecifier_33_Var
		 = (TypeSpecifier)DeclarationSpecifier_32_list.get(0);
		Assert.assertNotNull(TypeSpecifier_33_Var
		);
		Assert.assertEquals("int", TypeSpecifier_33_Var
		.getName());
		//33
		final Declarator Declarator_34_Var
		 = (Declarator)FunctionDefHead_31_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_34_Var
		);
		//34
		final DirectDeclarator DirectDeclarator_35_Var
		 = (DirectDeclarator)Declarator_34_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_35_Var
		);
		Assert.assertEquals("main", DirectDeclarator_35_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_35_list = DirectDeclarator_35_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_35_list);
		Assert.assertEquals(1, DeclaratorSuffix_35_list.size());
		//35
		final DeclaratorSuffix DeclaratorSuffix_36_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_35_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_36_Var
		);
		//36
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_37_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_36_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_37_Var
		);
		final EList<? extends EObject> ParameterTypeList_37_list = DirectDeclaratorLastSuffix_37_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_37_list);
		Assert.assertEquals(1, ParameterTypeList_37_list.size());
		//37
		final ParameterTypeList ParameterTypeList_38_Var
		 = (ParameterTypeList)ParameterTypeList_37_list.get(0);
		Assert.assertNotNull(ParameterTypeList_38_Var
		);
		//38
		final ParameterList ParameterList_39_Var
		 = (ParameterList)ParameterTypeList_38_Var
		.getList();
		Assert.assertNotNull(ParameterList_39_Var
		);
		final EList<? extends EObject> ParameterDeclaration_39_list = ParameterList_39_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_39_list);
		Assert.assertEquals(1, ParameterDeclaration_39_list.size());
		//39
		final ParameterDeclaration ParameterDeclaration_40_Var
		 = (ParameterDeclaration)ParameterDeclaration_39_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_40_Var
		);
		//40
		final DeclarationSpecifiers DeclarationSpecifiers_41_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_40_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_41_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_41_list = DeclarationSpecifiers_41_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_41_list);
		Assert.assertEquals(1, DeclarationSpecifier_41_list.size());
		//41
		final TypeSpecifier TypeSpecifier_42_Var
		 = (TypeSpecifier)DeclarationSpecifier_41_list.get(0);
		Assert.assertNotNull(TypeSpecifier_42_Var
		);
		Assert.assertEquals("void", TypeSpecifier_42_Var
		.getName());
		//42
		final FunctionDefinition FunctionDefinition_43_Var
		 = (FunctionDefinition)ExternalDeclaration_30_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_43_Var
		);
		//43
		final BodyStatement BodyStatement_44_Var
		 = (BodyStatement)FunctionDefinition_43_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_44_Var
		);
		final EList<? extends EObject> BlockList_44_list = BodyStatement_44_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_44_list);
		Assert.assertEquals(1, BlockList_44_list.size());
		//44
		final BlockList BlockList_45_Var
		 = (BlockList)BlockList_44_list.get(0);
		Assert.assertNotNull(BlockList_45_Var
		);
		final EList<? extends EObject> Declaration_45_list = BlockList_45_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_45_list);
		Assert.assertEquals(1, Declaration_45_list.size());
		//45
		final Declaration Declaration_46_Var
		 = (Declaration)Declaration_45_list.get(0);
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
		Assert.assertEquals(2, DeclarationSpecifier_47_list.size());
		//47
		final TypeSpecifier TypeSpecifier_48_Var
		 = (TypeSpecifier)DeclarationSpecifier_47_list.get(0);
		Assert.assertNotNull(TypeSpecifier_48_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_48_Var
		.getName());
		//48
		final TypeSpecifier TypeSpecifier_49_Var
		 = (TypeSpecifier)DeclarationSpecifier_47_list.get(1);
		Assert.assertNotNull(TypeSpecifier_49_Var
		);
		Assert.assertEquals("long", TypeSpecifier_49_Var
		.getName());
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
		Assert.assertEquals("size", DirectDeclarator_53_Var
		.getId());
		//53
		final Initializer Initializer_54_Var
		 = (Initializer)InitDeclarator_51_Var
		.getInitializer();
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
		final TypeName TypeName_68_Var
		 = (TypeName)CastExpression_67_Var
		.getType();
		Assert.assertNotNull(TypeName_68_Var
		);
		//68
		final SpecifierQualifierList SpecifierQualifierList_69_Var
		 = (SpecifierQualifierList)TypeName_68_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_69_Var
		);
		final EList<? extends EObject> TypeSpecifier_69_list = SpecifierQualifierList_69_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_69_list);
		Assert.assertEquals(2, TypeSpecifier_69_list.size());
		//69
		final TypeSpecifier TypeSpecifier_70_Var
		 = (TypeSpecifier)TypeSpecifier_69_list.get(0);
		Assert.assertNotNull(TypeSpecifier_70_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_70_Var
		.getName());
		//70
		final TypeSpecifier TypeSpecifier_71_Var
		 = (TypeSpecifier)TypeSpecifier_69_list.get(1);
		Assert.assertNotNull(TypeSpecifier_71_Var
		);
		Assert.assertEquals("long", TypeSpecifier_71_Var
		.getName());
		//71
		final CastExpression CastExpression_72_Var
		 = (CastExpression)CastExpression_67_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_72_Var
		);
		//72
		final UnaryExpression UnaryExpression_73_Var
		 = (UnaryExpression)CastExpression_72_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_73_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_73_Var
		.getSizeOf());
		//73
		final UnaryExpression UnaryExpression_74_Var
		 = (UnaryExpression)UnaryExpression_73_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_74_Var
		);
		//74
		final PostfixExpression PostfixExpression_75_Var
		 = (PostfixExpression)UnaryExpression_74_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = PostfixExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final PrimaryExpression PrimaryExpression_76_Var
		 = (PrimaryExpression)Expr_75_list.get(0);
		Assert.assertNotNull(PrimaryExpression_76_Var
		);
		//76
		final Expression Expression_77_Var
		 = (Expression)PrimaryExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expression_77_Var
		);
		final EList<? extends EObject> ExprExpr_77_list = Expression_77_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_77_list);
		Assert.assertEquals(1, ExprExpr_77_list.size());
		//77
		final AssignmentExpression AssignmentExpression_78_Var
		 = (AssignmentExpression)ExprExpr_77_list.get(0);
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
		Assert.assertEquals("number", PrimaryExpression_93_Var
		.getId());
		final EList<? extends EObject> Statement_93_list = BlockList_45_Var
		.getStatement();
		Assert.assertNotNull(Statement_93_list);
		Assert.assertEquals(11, Statement_93_list.size());
		//93
		final Statement Statement_94_Var
		 = (Statement)Statement_93_list.get(0);
		Assert.assertNotNull(Statement_94_Var
		);
		//94
		final ExpressionStatement ExpressionStatement_95_Var
		 = (ExpressionStatement)Statement_94_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_95_Var
		);
		//95
		final Expression Expression_96_Var
		 = (Expression)ExpressionStatement_95_Var
		.getExpression();
		Assert.assertNotNull(Expression_96_Var
		);
		final EList<? extends EObject> ExprExpr_96_list = Expression_96_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_96_list);
		Assert.assertEquals(1, ExprExpr_96_list.size());
		//96
		final AssignmentExpression AssignmentExpression_97_Var
		 = (AssignmentExpression)ExprExpr_96_list.get(0);
		Assert.assertNotNull(AssignmentExpression_97_Var
		);
		//97
		final ConditionalExpression ConditionalExpression_98_Var
		 = (ConditionalExpression)AssignmentExpression_97_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_98_Var
		);
		//98
		final LogicalOrExpression LogicalOrExpression_99_Var
		 = (LogicalOrExpression)ConditionalExpression_98_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = LogicalOrExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final LogicalAndExpression LogicalAndExpression_100_Var
		 = (LogicalAndExpression)Expr_99_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = LogicalAndExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final InclusiveOrExpression InclusiveOrExpression_101_Var
		 = (InclusiveOrExpression)Expr_100_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = InclusiveOrExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final ExclusiveOrExpression ExclusiveOrExpression_102_Var
		 = (ExclusiveOrExpression)Expr_101_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = ExclusiveOrExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final AndExpression AndExpression_103_Var
		 = (AndExpression)Expr_102_list.get(0);
		Assert.assertNotNull(AndExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = AndExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final EqualityExpression EqualityExpression_104_Var
		 = (EqualityExpression)Expr_103_list.get(0);
		Assert.assertNotNull(EqualityExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = EqualityExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final RelationalExpression RelationalExpression_105_Var
		 = (RelationalExpression)Expr_104_list.get(0);
		Assert.assertNotNull(RelationalExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = RelationalExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final ShiftExpression ShiftExpression_106_Var
		 = (ShiftExpression)Expr_105_list.get(0);
		Assert.assertNotNull(ShiftExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = ShiftExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final AdditiveExpression AdditiveExpression_107_Var
		 = (AdditiveExpression)Expr_106_list.get(0);
		Assert.assertNotNull(AdditiveExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = AdditiveExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final MultiplicativeExpression MultiplicativeExpression_108_Var
		 = (MultiplicativeExpression)Expr_107_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = MultiplicativeExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final CastExpression CastExpression_109_Var
		 = (CastExpression)Expr_108_list.get(0);
		Assert.assertNotNull(CastExpression_109_Var
		);
		//109
		final UnaryExpression UnaryExpression_110_Var
		 = (UnaryExpression)CastExpression_109_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_110_Var
		);
		//110
		final PostfixExpression PostfixExpression_111_Var
		 = (PostfixExpression)UnaryExpression_110_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = PostfixExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final PrimaryExpression PrimaryExpression_112_Var
		 = (PrimaryExpression)Expr_111_list.get(0);
		Assert.assertNotNull(PrimaryExpression_112_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_112_Var
		.getId());
		final EList<? extends EObject> Suffix_112_list = PostfixExpression_111_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_112_list);
		Assert.assertEquals(1, Suffix_112_list.size());
		//112
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_113_Var
		 = (PostfixExpressionSuffixArgument)Suffix_112_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_113_Var
		);
		//113
		final ArgumentExpressionList ArgumentExpressionList_114_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_113_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_114_Var
		);
		final EList<? extends EObject> Expr_114_list = ArgumentExpressionList_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(2, Expr_114_list.size());
		//114
		final AssignmentExpression AssignmentExpression_115_Var
		 = (AssignmentExpression)Expr_114_list.get(0);
		Assert.assertNotNull(AssignmentExpression_115_Var
		);
		//115
		final ConditionalExpression ConditionalExpression_116_Var
		 = (ConditionalExpression)AssignmentExpression_115_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_116_Var
		);
		//116
		final LogicalOrExpression LogicalOrExpression_117_Var
		 = (LogicalOrExpression)ConditionalExpression_116_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = LogicalOrExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final LogicalAndExpression LogicalAndExpression_118_Var
		 = (LogicalAndExpression)Expr_117_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = LogicalAndExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final InclusiveOrExpression InclusiveOrExpression_119_Var
		 = (InclusiveOrExpression)Expr_118_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = InclusiveOrExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final ExclusiveOrExpression ExclusiveOrExpression_120_Var
		 = (ExclusiveOrExpression)Expr_119_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = ExclusiveOrExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final AndExpression AndExpression_121_Var
		 = (AndExpression)Expr_120_list.get(0);
		Assert.assertNotNull(AndExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = AndExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final EqualityExpression EqualityExpression_122_Var
		 = (EqualityExpression)Expr_121_list.get(0);
		Assert.assertNotNull(EqualityExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = EqualityExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final RelationalExpression RelationalExpression_123_Var
		 = (RelationalExpression)Expr_122_list.get(0);
		Assert.assertNotNull(RelationalExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = RelationalExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final ShiftExpression ShiftExpression_124_Var
		 = (ShiftExpression)Expr_123_list.get(0);
		Assert.assertNotNull(ShiftExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = ShiftExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final AdditiveExpression AdditiveExpression_125_Var
		 = (AdditiveExpression)Expr_124_list.get(0);
		Assert.assertNotNull(AdditiveExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = AdditiveExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final MultiplicativeExpression MultiplicativeExpression_126_Var
		 = (MultiplicativeExpression)Expr_125_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = MultiplicativeExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final CastExpression CastExpression_127_Var
		 = (CastExpression)Expr_126_list.get(0);
		Assert.assertNotNull(CastExpression_127_Var
		);
		//127
		final UnaryExpression UnaryExpression_128_Var
		 = (UnaryExpression)CastExpression_127_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_128_Var
		);
		//128
		final PostfixExpression PostfixExpression_129_Var
		 = (PostfixExpression)UnaryExpression_128_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = PostfixExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final PrimaryExpression PrimaryExpression_130_Var
		 = (PrimaryExpression)Expr_129_list.get(0);
		Assert.assertNotNull(PrimaryExpression_130_Var
		);
		//130
		final Constant2 Constant2_131_Var
		 = (Constant2)PrimaryExpression_130_Var
		.getConst();
		Assert.assertNotNull(Constant2_131_Var
		);
		Assert.assertEquals("\"sizeof(number)=%lu\\n\"", Constant2_131_Var
		.getStr());
		//131
		final AssignmentExpression AssignmentExpression_132_Var
		 = (AssignmentExpression)Expr_114_list.get(1);
		Assert.assertNotNull(AssignmentExpression_132_Var
		);
		//132
		final ConditionalExpression ConditionalExpression_133_Var
		 = (ConditionalExpression)AssignmentExpression_132_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_133_Var
		);
		//133
		final LogicalOrExpression LogicalOrExpression_134_Var
		 = (LogicalOrExpression)ConditionalExpression_133_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = LogicalOrExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final LogicalAndExpression LogicalAndExpression_135_Var
		 = (LogicalAndExpression)Expr_134_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = LogicalAndExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final InclusiveOrExpression InclusiveOrExpression_136_Var
		 = (InclusiveOrExpression)Expr_135_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = InclusiveOrExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final ExclusiveOrExpression ExclusiveOrExpression_137_Var
		 = (ExclusiveOrExpression)Expr_136_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = ExclusiveOrExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final AndExpression AndExpression_138_Var
		 = (AndExpression)Expr_137_list.get(0);
		Assert.assertNotNull(AndExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = AndExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final EqualityExpression EqualityExpression_139_Var
		 = (EqualityExpression)Expr_138_list.get(0);
		Assert.assertNotNull(EqualityExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = EqualityExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final RelationalExpression RelationalExpression_140_Var
		 = (RelationalExpression)Expr_139_list.get(0);
		Assert.assertNotNull(RelationalExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = RelationalExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final ShiftExpression ShiftExpression_141_Var
		 = (ShiftExpression)Expr_140_list.get(0);
		Assert.assertNotNull(ShiftExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = ShiftExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final AdditiveExpression AdditiveExpression_142_Var
		 = (AdditiveExpression)Expr_141_list.get(0);
		Assert.assertNotNull(AdditiveExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = AdditiveExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final MultiplicativeExpression MultiplicativeExpression_143_Var
		 = (MultiplicativeExpression)Expr_142_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = MultiplicativeExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final CastExpression CastExpression_144_Var
		 = (CastExpression)Expr_143_list.get(0);
		Assert.assertNotNull(CastExpression_144_Var
		);
		//144
		final UnaryExpression UnaryExpression_145_Var
		 = (UnaryExpression)CastExpression_144_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_145_Var
		);
		//145
		final PostfixExpression PostfixExpression_146_Var
		 = (PostfixExpression)UnaryExpression_145_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_146_Var
		);
		final EList<? extends EObject> Expr_146_list = PostfixExpression_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final PrimaryExpression PrimaryExpression_147_Var
		 = (PrimaryExpression)Expr_146_list.get(0);
		Assert.assertNotNull(PrimaryExpression_147_Var
		);
		Assert.assertEquals("size", PrimaryExpression_147_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_95_Var
		.getSemi());
		//147
		final Statement Statement_148_Var
		 = (Statement)Statement_93_list.get(1);
		Assert.assertNotNull(Statement_148_Var
		);
		//148
		final ExpressionStatement ExpressionStatement_149_Var
		 = (ExpressionStatement)Statement_148_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_149_Var
		);
		//149
		final Expression Expression_150_Var
		 = (Expression)ExpressionStatement_149_Var
		.getExpression();
		Assert.assertNotNull(Expression_150_Var
		);
		final EList<? extends EObject> ExprExpr_150_list = Expression_150_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_150_list);
		Assert.assertEquals(1, ExprExpr_150_list.size());
		//150
		final AssignmentExpression AssignmentExpression_151_Var
		 = (AssignmentExpression)ExprExpr_150_list.get(0);
		Assert.assertNotNull(AssignmentExpression_151_Var
		);
		//151
		final ConditionalExpression ConditionalExpression_152_Var
		 = (ConditionalExpression)AssignmentExpression_151_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_152_Var
		);
		//152
		final LogicalOrExpression LogicalOrExpression_153_Var
		 = (LogicalOrExpression)ConditionalExpression_152_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_153_Var
		);
		final EList<? extends EObject> Expr_153_list = LogicalOrExpression_153_Var
		.getExpr();
		Assert.assertNotNull(Expr_153_list);
		Assert.assertEquals(1, Expr_153_list.size());
		//153
		final LogicalAndExpression LogicalAndExpression_154_Var
		 = (LogicalAndExpression)Expr_153_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_154_Var
		);
		final EList<? extends EObject> Expr_154_list = LogicalAndExpression_154_Var
		.getExpr();
		Assert.assertNotNull(Expr_154_list);
		Assert.assertEquals(1, Expr_154_list.size());
		//154
		final InclusiveOrExpression InclusiveOrExpression_155_Var
		 = (InclusiveOrExpression)Expr_154_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_155_Var
		);
		final EList<? extends EObject> Expr_155_list = InclusiveOrExpression_155_Var
		.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		//155
		final ExclusiveOrExpression ExclusiveOrExpression_156_Var
		 = (ExclusiveOrExpression)Expr_155_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_156_Var
		);
		final EList<? extends EObject> Expr_156_list = ExclusiveOrExpression_156_Var
		.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		//156
		final AndExpression AndExpression_157_Var
		 = (AndExpression)Expr_156_list.get(0);
		Assert.assertNotNull(AndExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = AndExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final EqualityExpression EqualityExpression_158_Var
		 = (EqualityExpression)Expr_157_list.get(0);
		Assert.assertNotNull(EqualityExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = EqualityExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final RelationalExpression RelationalExpression_159_Var
		 = (RelationalExpression)Expr_158_list.get(0);
		Assert.assertNotNull(RelationalExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = RelationalExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final ShiftExpression ShiftExpression_160_Var
		 = (ShiftExpression)Expr_159_list.get(0);
		Assert.assertNotNull(ShiftExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = ShiftExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final AdditiveExpression AdditiveExpression_161_Var
		 = (AdditiveExpression)Expr_160_list.get(0);
		Assert.assertNotNull(AdditiveExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = AdditiveExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final MultiplicativeExpression MultiplicativeExpression_162_Var
		 = (MultiplicativeExpression)Expr_161_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_162_Var
		);
		final EList<? extends EObject> Expr_162_list = MultiplicativeExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		//162
		final CastExpression CastExpression_163_Var
		 = (CastExpression)Expr_162_list.get(0);
		Assert.assertNotNull(CastExpression_163_Var
		);
		//163
		final UnaryExpression UnaryExpression_164_Var
		 = (UnaryExpression)CastExpression_163_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_164_Var
		);
		//164
		final PostfixExpression PostfixExpression_165_Var
		 = (PostfixExpression)UnaryExpression_164_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_165_Var
		);
		final EList<? extends EObject> Expr_165_list = PostfixExpression_165_Var
		.getExpr();
		Assert.assertNotNull(Expr_165_list);
		Assert.assertEquals(1, Expr_165_list.size());
		//165
		final PrimaryExpression PrimaryExpression_166_Var
		 = (PrimaryExpression)Expr_165_list.get(0);
		Assert.assertNotNull(PrimaryExpression_166_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_166_Var
		.getId());
		final EList<? extends EObject> Suffix_166_list = PostfixExpression_165_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_166_list);
		Assert.assertEquals(1, Suffix_166_list.size());
		//166
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_167_Var
		 = (PostfixExpressionSuffixArgument)Suffix_166_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_167_Var
		);
		//167
		final ArgumentExpressionList ArgumentExpressionList_168_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_167_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_168_Var
		);
		final EList<? extends EObject> Expr_168_list = ArgumentExpressionList_168_Var
		.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(2, Expr_168_list.size());
		//168
		final AssignmentExpression AssignmentExpression_169_Var
		 = (AssignmentExpression)Expr_168_list.get(0);
		Assert.assertNotNull(AssignmentExpression_169_Var
		);
		//169
		final ConditionalExpression ConditionalExpression_170_Var
		 = (ConditionalExpression)AssignmentExpression_169_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_170_Var
		);
		//170
		final LogicalOrExpression LogicalOrExpression_171_Var
		 = (LogicalOrExpression)ConditionalExpression_170_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_171_Var
		);
		final EList<? extends EObject> Expr_171_list = LogicalOrExpression_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		//171
		final LogicalAndExpression LogicalAndExpression_172_Var
		 = (LogicalAndExpression)Expr_171_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = LogicalAndExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final InclusiveOrExpression InclusiveOrExpression_173_Var
		 = (InclusiveOrExpression)Expr_172_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = InclusiveOrExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final ExclusiveOrExpression ExclusiveOrExpression_174_Var
		 = (ExclusiveOrExpression)Expr_173_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = ExclusiveOrExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final AndExpression AndExpression_175_Var
		 = (AndExpression)Expr_174_list.get(0);
		Assert.assertNotNull(AndExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = AndExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final EqualityExpression EqualityExpression_176_Var
		 = (EqualityExpression)Expr_175_list.get(0);
		Assert.assertNotNull(EqualityExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = EqualityExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final RelationalExpression RelationalExpression_177_Var
		 = (RelationalExpression)Expr_176_list.get(0);
		Assert.assertNotNull(RelationalExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = RelationalExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final ShiftExpression ShiftExpression_178_Var
		 = (ShiftExpression)Expr_177_list.get(0);
		Assert.assertNotNull(ShiftExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = ShiftExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final AdditiveExpression AdditiveExpression_179_Var
		 = (AdditiveExpression)Expr_178_list.get(0);
		Assert.assertNotNull(AdditiveExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = AdditiveExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final MultiplicativeExpression MultiplicativeExpression_180_Var
		 = (MultiplicativeExpression)Expr_179_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_180_Var
		);
		final EList<? extends EObject> Expr_180_list = MultiplicativeExpression_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final CastExpression CastExpression_181_Var
		 = (CastExpression)Expr_180_list.get(0);
		Assert.assertNotNull(CastExpression_181_Var
		);
		//181
		final UnaryExpression UnaryExpression_182_Var
		 = (UnaryExpression)CastExpression_181_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_182_Var
		);
		//182
		final PostfixExpression PostfixExpression_183_Var
		 = (PostfixExpression)UnaryExpression_182_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = PostfixExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final PrimaryExpression PrimaryExpression_184_Var
		 = (PrimaryExpression)Expr_183_list.get(0);
		Assert.assertNotNull(PrimaryExpression_184_Var
		);
		//184
		final Constant2 Constant2_185_Var
		 = (Constant2)PrimaryExpression_184_Var
		.getConst();
		Assert.assertNotNull(Constant2_185_Var
		);
		Assert.assertEquals("\"sizeof(number.numChar)=%lu\\n\"", Constant2_185_Var
		.getStr());
		//185
		final AssignmentExpression AssignmentExpression_186_Var
		 = (AssignmentExpression)Expr_168_list.get(1);
		Assert.assertNotNull(AssignmentExpression_186_Var
		);
		//186
		final ConditionalExpression ConditionalExpression_187_Var
		 = (ConditionalExpression)AssignmentExpression_186_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_187_Var
		);
		//187
		final LogicalOrExpression LogicalOrExpression_188_Var
		 = (LogicalOrExpression)ConditionalExpression_187_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = LogicalOrExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final LogicalAndExpression LogicalAndExpression_189_Var
		 = (LogicalAndExpression)Expr_188_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = LogicalAndExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final InclusiveOrExpression InclusiveOrExpression_190_Var
		 = (InclusiveOrExpression)Expr_189_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = InclusiveOrExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final ExclusiveOrExpression ExclusiveOrExpression_191_Var
		 = (ExclusiveOrExpression)Expr_190_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = ExclusiveOrExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final AndExpression AndExpression_192_Var
		 = (AndExpression)Expr_191_list.get(0);
		Assert.assertNotNull(AndExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = AndExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final EqualityExpression EqualityExpression_193_Var
		 = (EqualityExpression)Expr_192_list.get(0);
		Assert.assertNotNull(EqualityExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = EqualityExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final RelationalExpression RelationalExpression_194_Var
		 = (RelationalExpression)Expr_193_list.get(0);
		Assert.assertNotNull(RelationalExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = RelationalExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final ShiftExpression ShiftExpression_195_Var
		 = (ShiftExpression)Expr_194_list.get(0);
		Assert.assertNotNull(ShiftExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = ShiftExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final AdditiveExpression AdditiveExpression_196_Var
		 = (AdditiveExpression)Expr_195_list.get(0);
		Assert.assertNotNull(AdditiveExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = AdditiveExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final MultiplicativeExpression MultiplicativeExpression_197_Var
		 = (MultiplicativeExpression)Expr_196_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = MultiplicativeExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final CastExpression CastExpression_198_Var
		 = (CastExpression)Expr_197_list.get(0);
		Assert.assertNotNull(CastExpression_198_Var
		);
		//198
		final UnaryExpression UnaryExpression_199_Var
		 = (UnaryExpression)CastExpression_198_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_199_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_199_Var
		.getSizeOf());
		//199
		final UnaryExpression UnaryExpression_200_Var
		 = (UnaryExpression)UnaryExpression_199_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_200_Var
		);
		//200
		final PostfixExpression PostfixExpression_201_Var
		 = (PostfixExpression)UnaryExpression_200_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = PostfixExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final PrimaryExpression PrimaryExpression_202_Var
		 = (PrimaryExpression)Expr_201_list.get(0);
		Assert.assertNotNull(PrimaryExpression_202_Var
		);
		//202
		final Expression Expression_203_Var
		 = (Expression)PrimaryExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expression_203_Var
		);
		final EList<? extends EObject> ExprExpr_203_list = Expression_203_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_203_list);
		Assert.assertEquals(1, ExprExpr_203_list.size());
		//203
		final AssignmentExpression AssignmentExpression_204_Var
		 = (AssignmentExpression)ExprExpr_203_list.get(0);
		Assert.assertNotNull(AssignmentExpression_204_Var
		);
		//204
		final ConditionalExpression ConditionalExpression_205_Var
		 = (ConditionalExpression)AssignmentExpression_204_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_205_Var
		);
		//205
		final LogicalOrExpression LogicalOrExpression_206_Var
		 = (LogicalOrExpression)ConditionalExpression_205_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = LogicalOrExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final LogicalAndExpression LogicalAndExpression_207_Var
		 = (LogicalAndExpression)Expr_206_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = LogicalAndExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final InclusiveOrExpression InclusiveOrExpression_208_Var
		 = (InclusiveOrExpression)Expr_207_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = InclusiveOrExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final ExclusiveOrExpression ExclusiveOrExpression_209_Var
		 = (ExclusiveOrExpression)Expr_208_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = ExclusiveOrExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final AndExpression AndExpression_210_Var
		 = (AndExpression)Expr_209_list.get(0);
		Assert.assertNotNull(AndExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = AndExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final EqualityExpression EqualityExpression_211_Var
		 = (EqualityExpression)Expr_210_list.get(0);
		Assert.assertNotNull(EqualityExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = EqualityExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final RelationalExpression RelationalExpression_212_Var
		 = (RelationalExpression)Expr_211_list.get(0);
		Assert.assertNotNull(RelationalExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = RelationalExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final ShiftExpression ShiftExpression_213_Var
		 = (ShiftExpression)Expr_212_list.get(0);
		Assert.assertNotNull(ShiftExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = ShiftExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final AdditiveExpression AdditiveExpression_214_Var
		 = (AdditiveExpression)Expr_213_list.get(0);
		Assert.assertNotNull(AdditiveExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = AdditiveExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final MultiplicativeExpression MultiplicativeExpression_215_Var
		 = (MultiplicativeExpression)Expr_214_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = MultiplicativeExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final CastExpression CastExpression_216_Var
		 = (CastExpression)Expr_215_list.get(0);
		Assert.assertNotNull(CastExpression_216_Var
		);
		//216
		final UnaryExpression UnaryExpression_217_Var
		 = (UnaryExpression)CastExpression_216_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_217_Var
		);
		//217
		final PostfixExpression PostfixExpression_218_Var
		 = (PostfixExpression)UnaryExpression_217_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = PostfixExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final PrimaryExpression PrimaryExpression_219_Var
		 = (PrimaryExpression)Expr_218_list.get(0);
		Assert.assertNotNull(PrimaryExpression_219_Var
		);
		Assert.assertEquals("number", PrimaryExpression_219_Var
		.getId());
		final EList<? extends EObject> Suffix_219_list = PostfixExpression_218_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_219_list);
		Assert.assertEquals(1, Suffix_219_list.size());
		//219
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_220_Var
		 = (PostfixExpressionSuffixDot)Suffix_219_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_220_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_220_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_149_Var
		.getSemi());
		//220
		final Statement Statement_221_Var
		 = (Statement)Statement_93_list.get(2);
		Assert.assertNotNull(Statement_221_Var
		);
		//221
		final ExpressionStatement ExpressionStatement_222_Var
		 = (ExpressionStatement)Statement_221_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_222_Var
		);
		//222
		final Expression Expression_223_Var
		 = (Expression)ExpressionStatement_222_Var
		.getExpression();
		Assert.assertNotNull(Expression_223_Var
		);
		final EList<? extends EObject> ExprExpr_223_list = Expression_223_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_223_list);
		Assert.assertEquals(1, ExprExpr_223_list.size());
		//223
		final AssignmentExpression AssignmentExpression_224_Var
		 = (AssignmentExpression)ExprExpr_223_list.get(0);
		Assert.assertNotNull(AssignmentExpression_224_Var
		);
		//224
		final ConditionalExpression ConditionalExpression_225_Var
		 = (ConditionalExpression)AssignmentExpression_224_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_225_Var
		);
		//225
		final LogicalOrExpression LogicalOrExpression_226_Var
		 = (LogicalOrExpression)ConditionalExpression_225_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = LogicalOrExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final LogicalAndExpression LogicalAndExpression_227_Var
		 = (LogicalAndExpression)Expr_226_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = LogicalAndExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final InclusiveOrExpression InclusiveOrExpression_228_Var
		 = (InclusiveOrExpression)Expr_227_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = InclusiveOrExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final ExclusiveOrExpression ExclusiveOrExpression_229_Var
		 = (ExclusiveOrExpression)Expr_228_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = ExclusiveOrExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final AndExpression AndExpression_230_Var
		 = (AndExpression)Expr_229_list.get(0);
		Assert.assertNotNull(AndExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = AndExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final EqualityExpression EqualityExpression_231_Var
		 = (EqualityExpression)Expr_230_list.get(0);
		Assert.assertNotNull(EqualityExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = EqualityExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final RelationalExpression RelationalExpression_232_Var
		 = (RelationalExpression)Expr_231_list.get(0);
		Assert.assertNotNull(RelationalExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = RelationalExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final ShiftExpression ShiftExpression_233_Var
		 = (ShiftExpression)Expr_232_list.get(0);
		Assert.assertNotNull(ShiftExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = ShiftExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final AdditiveExpression AdditiveExpression_234_Var
		 = (AdditiveExpression)Expr_233_list.get(0);
		Assert.assertNotNull(AdditiveExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = AdditiveExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final MultiplicativeExpression MultiplicativeExpression_235_Var
		 = (MultiplicativeExpression)Expr_234_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = MultiplicativeExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final CastExpression CastExpression_236_Var
		 = (CastExpression)Expr_235_list.get(0);
		Assert.assertNotNull(CastExpression_236_Var
		);
		//236
		final UnaryExpression UnaryExpression_237_Var
		 = (UnaryExpression)CastExpression_236_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_237_Var
		);
		//237
		final PostfixExpression PostfixExpression_238_Var
		 = (PostfixExpression)UnaryExpression_237_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = PostfixExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final PrimaryExpression PrimaryExpression_239_Var
		 = (PrimaryExpression)Expr_238_list.get(0);
		Assert.assertNotNull(PrimaryExpression_239_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_239_Var
		.getId());
		final EList<? extends EObject> Suffix_239_list = PostfixExpression_238_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_239_list);
		Assert.assertEquals(1, Suffix_239_list.size());
		//239
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_240_Var
		 = (PostfixExpressionSuffixArgument)Suffix_239_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_240_Var
		);
		//240
		final ArgumentExpressionList ArgumentExpressionList_241_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_240_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_241_Var
		);
		final EList<? extends EObject> Expr_241_list = ArgumentExpressionList_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(2, Expr_241_list.size());
		//241
		final AssignmentExpression AssignmentExpression_242_Var
		 = (AssignmentExpression)Expr_241_list.get(0);
		Assert.assertNotNull(AssignmentExpression_242_Var
		);
		//242
		final ConditionalExpression ConditionalExpression_243_Var
		 = (ConditionalExpression)AssignmentExpression_242_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_243_Var
		);
		//243
		final LogicalOrExpression LogicalOrExpression_244_Var
		 = (LogicalOrExpression)ConditionalExpression_243_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = LogicalOrExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final LogicalAndExpression LogicalAndExpression_245_Var
		 = (LogicalAndExpression)Expr_244_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = LogicalAndExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final InclusiveOrExpression InclusiveOrExpression_246_Var
		 = (InclusiveOrExpression)Expr_245_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = InclusiveOrExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final ExclusiveOrExpression ExclusiveOrExpression_247_Var
		 = (ExclusiveOrExpression)Expr_246_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = ExclusiveOrExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final AndExpression AndExpression_248_Var
		 = (AndExpression)Expr_247_list.get(0);
		Assert.assertNotNull(AndExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = AndExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final EqualityExpression EqualityExpression_249_Var
		 = (EqualityExpression)Expr_248_list.get(0);
		Assert.assertNotNull(EqualityExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = EqualityExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final RelationalExpression RelationalExpression_250_Var
		 = (RelationalExpression)Expr_249_list.get(0);
		Assert.assertNotNull(RelationalExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = RelationalExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final ShiftExpression ShiftExpression_251_Var
		 = (ShiftExpression)Expr_250_list.get(0);
		Assert.assertNotNull(ShiftExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = ShiftExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final AdditiveExpression AdditiveExpression_252_Var
		 = (AdditiveExpression)Expr_251_list.get(0);
		Assert.assertNotNull(AdditiveExpression_252_Var
		);
		final EList<? extends EObject> Expr_252_list = AdditiveExpression_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(1, Expr_252_list.size());
		//252
		final MultiplicativeExpression MultiplicativeExpression_253_Var
		 = (MultiplicativeExpression)Expr_252_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = MultiplicativeExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final CastExpression CastExpression_254_Var
		 = (CastExpression)Expr_253_list.get(0);
		Assert.assertNotNull(CastExpression_254_Var
		);
		//254
		final UnaryExpression UnaryExpression_255_Var
		 = (UnaryExpression)CastExpression_254_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_255_Var
		);
		//255
		final PostfixExpression PostfixExpression_256_Var
		 = (PostfixExpression)UnaryExpression_255_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_256_Var
		);
		final EList<? extends EObject> Expr_256_list = PostfixExpression_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(1, Expr_256_list.size());
		//256
		final PrimaryExpression PrimaryExpression_257_Var
		 = (PrimaryExpression)Expr_256_list.get(0);
		Assert.assertNotNull(PrimaryExpression_257_Var
		);
		//257
		final Constant2 Constant2_258_Var
		 = (Constant2)PrimaryExpression_257_Var
		.getConst();
		Assert.assertNotNull(Constant2_258_Var
		);
		Assert.assertEquals("\"sizeof(float)=%lu\\n\"", Constant2_258_Var
		.getStr());
		//258
		final AssignmentExpression AssignmentExpression_259_Var
		 = (AssignmentExpression)Expr_241_list.get(1);
		Assert.assertNotNull(AssignmentExpression_259_Var
		);
		//259
		final ConditionalExpression ConditionalExpression_260_Var
		 = (ConditionalExpression)AssignmentExpression_259_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_260_Var
		);
		//260
		final LogicalOrExpression LogicalOrExpression_261_Var
		 = (LogicalOrExpression)ConditionalExpression_260_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = LogicalOrExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final LogicalAndExpression LogicalAndExpression_262_Var
		 = (LogicalAndExpression)Expr_261_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_262_Var
		);
		final EList<? extends EObject> Expr_262_list = LogicalAndExpression_262_Var
		.getExpr();
		Assert.assertNotNull(Expr_262_list);
		Assert.assertEquals(1, Expr_262_list.size());
		//262
		final InclusiveOrExpression InclusiveOrExpression_263_Var
		 = (InclusiveOrExpression)Expr_262_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_263_Var
		);
		final EList<? extends EObject> Expr_263_list = InclusiveOrExpression_263_Var
		.getExpr();
		Assert.assertNotNull(Expr_263_list);
		Assert.assertEquals(1, Expr_263_list.size());
		//263
		final ExclusiveOrExpression ExclusiveOrExpression_264_Var
		 = (ExclusiveOrExpression)Expr_263_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_264_Var
		);
		final EList<? extends EObject> Expr_264_list = ExclusiveOrExpression_264_Var
		.getExpr();
		Assert.assertNotNull(Expr_264_list);
		Assert.assertEquals(1, Expr_264_list.size());
		//264
		final AndExpression AndExpression_265_Var
		 = (AndExpression)Expr_264_list.get(0);
		Assert.assertNotNull(AndExpression_265_Var
		);
		final EList<? extends EObject> Expr_265_list = AndExpression_265_Var
		.getExpr();
		Assert.assertNotNull(Expr_265_list);
		Assert.assertEquals(1, Expr_265_list.size());
		//265
		final EqualityExpression EqualityExpression_266_Var
		 = (EqualityExpression)Expr_265_list.get(0);
		Assert.assertNotNull(EqualityExpression_266_Var
		);
		final EList<? extends EObject> Expr_266_list = EqualityExpression_266_Var
		.getExpr();
		Assert.assertNotNull(Expr_266_list);
		Assert.assertEquals(1, Expr_266_list.size());
		//266
		final RelationalExpression RelationalExpression_267_Var
		 = (RelationalExpression)Expr_266_list.get(0);
		Assert.assertNotNull(RelationalExpression_267_Var
		);
		final EList<? extends EObject> Expr_267_list = RelationalExpression_267_Var
		.getExpr();
		Assert.assertNotNull(Expr_267_list);
		Assert.assertEquals(1, Expr_267_list.size());
		//267
		final ShiftExpression ShiftExpression_268_Var
		 = (ShiftExpression)Expr_267_list.get(0);
		Assert.assertNotNull(ShiftExpression_268_Var
		);
		final EList<? extends EObject> Expr_268_list = ShiftExpression_268_Var
		.getExpr();
		Assert.assertNotNull(Expr_268_list);
		Assert.assertEquals(1, Expr_268_list.size());
		//268
		final AdditiveExpression AdditiveExpression_269_Var
		 = (AdditiveExpression)Expr_268_list.get(0);
		Assert.assertNotNull(AdditiveExpression_269_Var
		);
		final EList<? extends EObject> Expr_269_list = AdditiveExpression_269_Var
		.getExpr();
		Assert.assertNotNull(Expr_269_list);
		Assert.assertEquals(1, Expr_269_list.size());
		//269
		final MultiplicativeExpression MultiplicativeExpression_270_Var
		 = (MultiplicativeExpression)Expr_269_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_270_Var
		);
		final EList<? extends EObject> Expr_270_list = MultiplicativeExpression_270_Var
		.getExpr();
		Assert.assertNotNull(Expr_270_list);
		Assert.assertEquals(1, Expr_270_list.size());
		//270
		final CastExpression CastExpression_271_Var
		 = (CastExpression)Expr_270_list.get(0);
		Assert.assertNotNull(CastExpression_271_Var
		);
		//271
		final UnaryExpression UnaryExpression_272_Var
		 = (UnaryExpression)CastExpression_271_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_272_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_272_Var
		.getSizeOf());
		//272
		final TypeName TypeName_273_Var
		 = (TypeName)UnaryExpression_272_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_273_Var
		);
		//273
		final SpecifierQualifierList SpecifierQualifierList_274_Var
		 = (SpecifierQualifierList)TypeName_273_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_274_Var
		);
		final EList<? extends EObject> TypeSpecifier_274_list = SpecifierQualifierList_274_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_274_list);
		Assert.assertEquals(1, TypeSpecifier_274_list.size());
		//274
		final TypeSpecifier TypeSpecifier_275_Var
		 = (TypeSpecifier)TypeSpecifier_274_list.get(0);
		Assert.assertNotNull(TypeSpecifier_275_Var
		);
		Assert.assertEquals("float", TypeSpecifier_275_Var
		.getName());
		Assert.assertEquals(";", ExpressionStatement_222_Var
		.getSemi());
		//275
		final Statement Statement_276_Var
		 = (Statement)Statement_93_list.get(3);
		Assert.assertNotNull(Statement_276_Var
		);
		//276
		final ExpressionStatement ExpressionStatement_277_Var
		 = (ExpressionStatement)Statement_276_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_277_Var
		);
		//277
		final Expression Expression_278_Var
		 = (Expression)ExpressionStatement_277_Var
		.getExpression();
		Assert.assertNotNull(Expression_278_Var
		);
		final EList<? extends EObject> ExprExpr_278_list = Expression_278_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_278_list);
		Assert.assertEquals(1, ExprExpr_278_list.size());
		//278
		final AssignmentExpression AssignmentExpression_279_Var
		 = (AssignmentExpression)ExprExpr_278_list.get(0);
		Assert.assertNotNull(AssignmentExpression_279_Var
		);
		//279
		final UnaryExpression UnaryExpression_280_Var
		 = (UnaryExpression)AssignmentExpression_279_Var
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
		Assert.assertEquals("number", PrimaryExpression_282_Var
		.getId());
		final EList<? extends EObject> Suffix_282_list = PostfixExpression_281_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_282_list);
		Assert.assertEquals(1, Suffix_282_list.size());
		//282
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_283_Var
		 = (PostfixExpressionSuffixDot)Suffix_282_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_283_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_283_Var
		.getId());
		//283
		final AssignmentOperator AssignmentOperator_284_Var
		 = (AssignmentOperator)AssignmentExpression_279_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_284_Var
		);
		Assert.assertEquals("=", AssignmentOperator_284_Var
		.getOp());
		//284
		final AssignmentExpression AssignmentExpression_285_Var
		 = (AssignmentExpression)AssignmentExpression_279_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_285_Var
		);
		//285
		final ConditionalExpression ConditionalExpression_286_Var
		 = (ConditionalExpression)AssignmentExpression_285_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_286_Var
		);
		//286
		final LogicalOrExpression LogicalOrExpression_287_Var
		 = (LogicalOrExpression)ConditionalExpression_286_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_287_Var
		);
		final EList<? extends EObject> Expr_287_list = LogicalOrExpression_287_Var
		.getExpr();
		Assert.assertNotNull(Expr_287_list);
		Assert.assertEquals(1, Expr_287_list.size());
		//287
		final LogicalAndExpression LogicalAndExpression_288_Var
		 = (LogicalAndExpression)Expr_287_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_288_Var
		);
		final EList<? extends EObject> Expr_288_list = LogicalAndExpression_288_Var
		.getExpr();
		Assert.assertNotNull(Expr_288_list);
		Assert.assertEquals(1, Expr_288_list.size());
		//288
		final InclusiveOrExpression InclusiveOrExpression_289_Var
		 = (InclusiveOrExpression)Expr_288_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_289_Var
		);
		final EList<? extends EObject> Expr_289_list = InclusiveOrExpression_289_Var
		.getExpr();
		Assert.assertNotNull(Expr_289_list);
		Assert.assertEquals(1, Expr_289_list.size());
		//289
		final ExclusiveOrExpression ExclusiveOrExpression_290_Var
		 = (ExclusiveOrExpression)Expr_289_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_290_Var
		);
		final EList<? extends EObject> Expr_290_list = ExclusiveOrExpression_290_Var
		.getExpr();
		Assert.assertNotNull(Expr_290_list);
		Assert.assertEquals(1, Expr_290_list.size());
		//290
		final AndExpression AndExpression_291_Var
		 = (AndExpression)Expr_290_list.get(0);
		Assert.assertNotNull(AndExpression_291_Var
		);
		final EList<? extends EObject> Expr_291_list = AndExpression_291_Var
		.getExpr();
		Assert.assertNotNull(Expr_291_list);
		Assert.assertEquals(1, Expr_291_list.size());
		//291
		final EqualityExpression EqualityExpression_292_Var
		 = (EqualityExpression)Expr_291_list.get(0);
		Assert.assertNotNull(EqualityExpression_292_Var
		);
		final EList<? extends EObject> Expr_292_list = EqualityExpression_292_Var
		.getExpr();
		Assert.assertNotNull(Expr_292_list);
		Assert.assertEquals(1, Expr_292_list.size());
		//292
		final RelationalExpression RelationalExpression_293_Var
		 = (RelationalExpression)Expr_292_list.get(0);
		Assert.assertNotNull(RelationalExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = RelationalExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final ShiftExpression ShiftExpression_294_Var
		 = (ShiftExpression)Expr_293_list.get(0);
		Assert.assertNotNull(ShiftExpression_294_Var
		);
		final EList<? extends EObject> Expr_294_list = ShiftExpression_294_Var
		.getExpr();
		Assert.assertNotNull(Expr_294_list);
		Assert.assertEquals(1, Expr_294_list.size());
		//294
		final AdditiveExpression AdditiveExpression_295_Var
		 = (AdditiveExpression)Expr_294_list.get(0);
		Assert.assertNotNull(AdditiveExpression_295_Var
		);
		final EList<? extends EObject> Expr_295_list = AdditiveExpression_295_Var
		.getExpr();
		Assert.assertNotNull(Expr_295_list);
		Assert.assertEquals(1, Expr_295_list.size());
		//295
		final MultiplicativeExpression MultiplicativeExpression_296_Var
		 = (MultiplicativeExpression)Expr_295_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_296_Var
		);
		final EList<? extends EObject> Expr_296_list = MultiplicativeExpression_296_Var
		.getExpr();
		Assert.assertNotNull(Expr_296_list);
		Assert.assertEquals(1, Expr_296_list.size());
		//296
		final CastExpression CastExpression_297_Var
		 = (CastExpression)Expr_296_list.get(0);
		Assert.assertNotNull(CastExpression_297_Var
		);
		//297
		final UnaryExpression UnaryExpression_298_Var
		 = (UnaryExpression)CastExpression_297_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_298_Var
		);
		//298
		final PostfixExpression PostfixExpression_299_Var
		 = (PostfixExpression)UnaryExpression_298_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_299_Var
		);
		final EList<? extends EObject> Expr_299_list = PostfixExpression_299_Var
		.getExpr();
		Assert.assertNotNull(Expr_299_list);
		Assert.assertEquals(1, Expr_299_list.size());
		//299
		final PrimaryExpression PrimaryExpression_300_Var
		 = (PrimaryExpression)Expr_299_list.get(0);
		Assert.assertNotNull(PrimaryExpression_300_Var
		);
		//300
		final Constant2 Constant2_301_Var
		 = (Constant2)PrimaryExpression_300_Var
		.getConst();
		Assert.assertNotNull(Constant2_301_Var
		);
		Assert.assertEquals("65", Constant2_301_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_277_Var
		.getSemi());
		//301
		final Statement Statement_302_Var
		 = (Statement)Statement_93_list.get(4);
		Assert.assertNotNull(Statement_302_Var
		);
		//302
		final ExpressionStatement ExpressionStatement_303_Var
		 = (ExpressionStatement)Statement_302_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_303_Var
		);
		//303
		final Expression Expression_304_Var
		 = (Expression)ExpressionStatement_303_Var
		.getExpression();
		Assert.assertNotNull(Expression_304_Var
		);
		final EList<? extends EObject> ExprExpr_304_list = Expression_304_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_304_list);
		Assert.assertEquals(1, ExprExpr_304_list.size());
		//304
		final AssignmentExpression AssignmentExpression_305_Var
		 = (AssignmentExpression)ExprExpr_304_list.get(0);
		Assert.assertNotNull(AssignmentExpression_305_Var
		);
		//305
		final ConditionalExpression ConditionalExpression_306_Var
		 = (ConditionalExpression)AssignmentExpression_305_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_306_Var
		);
		//306
		final LogicalOrExpression LogicalOrExpression_307_Var
		 = (LogicalOrExpression)ConditionalExpression_306_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_307_Var
		);
		final EList<? extends EObject> Expr_307_list = LogicalOrExpression_307_Var
		.getExpr();
		Assert.assertNotNull(Expr_307_list);
		Assert.assertEquals(1, Expr_307_list.size());
		//307
		final LogicalAndExpression LogicalAndExpression_308_Var
		 = (LogicalAndExpression)Expr_307_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_308_Var
		);
		final EList<? extends EObject> Expr_308_list = LogicalAndExpression_308_Var
		.getExpr();
		Assert.assertNotNull(Expr_308_list);
		Assert.assertEquals(1, Expr_308_list.size());
		//308
		final InclusiveOrExpression InclusiveOrExpression_309_Var
		 = (InclusiveOrExpression)Expr_308_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_309_Var
		);
		final EList<? extends EObject> Expr_309_list = InclusiveOrExpression_309_Var
		.getExpr();
		Assert.assertNotNull(Expr_309_list);
		Assert.assertEquals(1, Expr_309_list.size());
		//309
		final ExclusiveOrExpression ExclusiveOrExpression_310_Var
		 = (ExclusiveOrExpression)Expr_309_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_310_Var
		);
		final EList<? extends EObject> Expr_310_list = ExclusiveOrExpression_310_Var
		.getExpr();
		Assert.assertNotNull(Expr_310_list);
		Assert.assertEquals(1, Expr_310_list.size());
		//310
		final AndExpression AndExpression_311_Var
		 = (AndExpression)Expr_310_list.get(0);
		Assert.assertNotNull(AndExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = AndExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final EqualityExpression EqualityExpression_312_Var
		 = (EqualityExpression)Expr_311_list.get(0);
		Assert.assertNotNull(EqualityExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = EqualityExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final RelationalExpression RelationalExpression_313_Var
		 = (RelationalExpression)Expr_312_list.get(0);
		Assert.assertNotNull(RelationalExpression_313_Var
		);
		final EList<? extends EObject> Expr_313_list = RelationalExpression_313_Var
		.getExpr();
		Assert.assertNotNull(Expr_313_list);
		Assert.assertEquals(1, Expr_313_list.size());
		//313
		final ShiftExpression ShiftExpression_314_Var
		 = (ShiftExpression)Expr_313_list.get(0);
		Assert.assertNotNull(ShiftExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = ShiftExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final AdditiveExpression AdditiveExpression_315_Var
		 = (AdditiveExpression)Expr_314_list.get(0);
		Assert.assertNotNull(AdditiveExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = AdditiveExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final MultiplicativeExpression MultiplicativeExpression_316_Var
		 = (MultiplicativeExpression)Expr_315_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_316_Var
		);
		final EList<? extends EObject> Expr_316_list = MultiplicativeExpression_316_Var
		.getExpr();
		Assert.assertNotNull(Expr_316_list);
		Assert.assertEquals(1, Expr_316_list.size());
		//316
		final CastExpression CastExpression_317_Var
		 = (CastExpression)Expr_316_list.get(0);
		Assert.assertNotNull(CastExpression_317_Var
		);
		//317
		final UnaryExpression UnaryExpression_318_Var
		 = (UnaryExpression)CastExpression_317_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_318_Var
		);
		//318
		final PostfixExpression PostfixExpression_319_Var
		 = (PostfixExpression)UnaryExpression_318_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_319_Var
		);
		final EList<? extends EObject> Expr_319_list = PostfixExpression_319_Var
		.getExpr();
		Assert.assertNotNull(Expr_319_list);
		Assert.assertEquals(1, Expr_319_list.size());
		//319
		final PrimaryExpression PrimaryExpression_320_Var
		 = (PrimaryExpression)Expr_319_list.get(0);
		Assert.assertNotNull(PrimaryExpression_320_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_320_Var
		.getId());
		final EList<? extends EObject> Suffix_320_list = PostfixExpression_319_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_320_list);
		Assert.assertEquals(1, Suffix_320_list.size());
		//320
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_321_Var
		 = (PostfixExpressionSuffixArgument)Suffix_320_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_321_Var
		);
		//321
		final ArgumentExpressionList ArgumentExpressionList_322_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_321_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_322_Var
		);
		final EList<? extends EObject> Expr_322_list = ArgumentExpressionList_322_Var
		.getExpr();
		Assert.assertNotNull(Expr_322_list);
		Assert.assertEquals(2, Expr_322_list.size());
		//322
		final AssignmentExpression AssignmentExpression_323_Var
		 = (AssignmentExpression)Expr_322_list.get(0);
		Assert.assertNotNull(AssignmentExpression_323_Var
		);
		//323
		final ConditionalExpression ConditionalExpression_324_Var
		 = (ConditionalExpression)AssignmentExpression_323_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_324_Var
		);
		//324
		final LogicalOrExpression LogicalOrExpression_325_Var
		 = (LogicalOrExpression)ConditionalExpression_324_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_325_Var
		);
		final EList<? extends EObject> Expr_325_list = LogicalOrExpression_325_Var
		.getExpr();
		Assert.assertNotNull(Expr_325_list);
		Assert.assertEquals(1, Expr_325_list.size());
		//325
		final LogicalAndExpression LogicalAndExpression_326_Var
		 = (LogicalAndExpression)Expr_325_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_326_Var
		);
		final EList<? extends EObject> Expr_326_list = LogicalAndExpression_326_Var
		.getExpr();
		Assert.assertNotNull(Expr_326_list);
		Assert.assertEquals(1, Expr_326_list.size());
		//326
		final InclusiveOrExpression InclusiveOrExpression_327_Var
		 = (InclusiveOrExpression)Expr_326_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_327_Var
		);
		final EList<? extends EObject> Expr_327_list = InclusiveOrExpression_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final ExclusiveOrExpression ExclusiveOrExpression_328_Var
		 = (ExclusiveOrExpression)Expr_327_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_328_Var
		);
		final EList<? extends EObject> Expr_328_list = ExclusiveOrExpression_328_Var
		.getExpr();
		Assert.assertNotNull(Expr_328_list);
		Assert.assertEquals(1, Expr_328_list.size());
		//328
		final AndExpression AndExpression_329_Var
		 = (AndExpression)Expr_328_list.get(0);
		Assert.assertNotNull(AndExpression_329_Var
		);
		final EList<? extends EObject> Expr_329_list = AndExpression_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final EqualityExpression EqualityExpression_330_Var
		 = (EqualityExpression)Expr_329_list.get(0);
		Assert.assertNotNull(EqualityExpression_330_Var
		);
		final EList<? extends EObject> Expr_330_list = EqualityExpression_330_Var
		.getExpr();
		Assert.assertNotNull(Expr_330_list);
		Assert.assertEquals(1, Expr_330_list.size());
		//330
		final RelationalExpression RelationalExpression_331_Var
		 = (RelationalExpression)Expr_330_list.get(0);
		Assert.assertNotNull(RelationalExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = RelationalExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final ShiftExpression ShiftExpression_332_Var
		 = (ShiftExpression)Expr_331_list.get(0);
		Assert.assertNotNull(ShiftExpression_332_Var
		);
		final EList<? extends EObject> Expr_332_list = ShiftExpression_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final AdditiveExpression AdditiveExpression_333_Var
		 = (AdditiveExpression)Expr_332_list.get(0);
		Assert.assertNotNull(AdditiveExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = AdditiveExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final MultiplicativeExpression MultiplicativeExpression_334_Var
		 = (MultiplicativeExpression)Expr_333_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = MultiplicativeExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final CastExpression CastExpression_335_Var
		 = (CastExpression)Expr_334_list.get(0);
		Assert.assertNotNull(CastExpression_335_Var
		);
		//335
		final UnaryExpression UnaryExpression_336_Var
		 = (UnaryExpression)CastExpression_335_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_336_Var
		);
		//336
		final PostfixExpression PostfixExpression_337_Var
		 = (PostfixExpression)UnaryExpression_336_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_337_Var
		);
		final EList<? extends EObject> Expr_337_list = PostfixExpression_337_Var
		.getExpr();
		Assert.assertNotNull(Expr_337_list);
		Assert.assertEquals(1, Expr_337_list.size());
		//337
		final PrimaryExpression PrimaryExpression_338_Var
		 = (PrimaryExpression)Expr_337_list.get(0);
		Assert.assertNotNull(PrimaryExpression_338_Var
		);
		//338
		final Constant2 Constant2_339_Var
		 = (Constant2)PrimaryExpression_338_Var
		.getConst();
		Assert.assertNotNull(Constant2_339_Var
		);
		Assert.assertEquals("\"number.numChar(as decimal)=%d\\n\"", Constant2_339_Var
		.getStr());
		//339
		final AssignmentExpression AssignmentExpression_340_Var
		 = (AssignmentExpression)Expr_322_list.get(1);
		Assert.assertNotNull(AssignmentExpression_340_Var
		);
		//340
		final ConditionalExpression ConditionalExpression_341_Var
		 = (ConditionalExpression)AssignmentExpression_340_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_341_Var
		);
		//341
		final LogicalOrExpression LogicalOrExpression_342_Var
		 = (LogicalOrExpression)ConditionalExpression_341_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_342_Var
		);
		final EList<? extends EObject> Expr_342_list = LogicalOrExpression_342_Var
		.getExpr();
		Assert.assertNotNull(Expr_342_list);
		Assert.assertEquals(1, Expr_342_list.size());
		//342
		final LogicalAndExpression LogicalAndExpression_343_Var
		 = (LogicalAndExpression)Expr_342_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_343_Var
		);
		final EList<? extends EObject> Expr_343_list = LogicalAndExpression_343_Var
		.getExpr();
		Assert.assertNotNull(Expr_343_list);
		Assert.assertEquals(1, Expr_343_list.size());
		//343
		final InclusiveOrExpression InclusiveOrExpression_344_Var
		 = (InclusiveOrExpression)Expr_343_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_344_Var
		);
		final EList<? extends EObject> Expr_344_list = InclusiveOrExpression_344_Var
		.getExpr();
		Assert.assertNotNull(Expr_344_list);
		Assert.assertEquals(1, Expr_344_list.size());
		//344
		final ExclusiveOrExpression ExclusiveOrExpression_345_Var
		 = (ExclusiveOrExpression)Expr_344_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_345_Var
		);
		final EList<? extends EObject> Expr_345_list = ExclusiveOrExpression_345_Var
		.getExpr();
		Assert.assertNotNull(Expr_345_list);
		Assert.assertEquals(1, Expr_345_list.size());
		//345
		final AndExpression AndExpression_346_Var
		 = (AndExpression)Expr_345_list.get(0);
		Assert.assertNotNull(AndExpression_346_Var
		);
		final EList<? extends EObject> Expr_346_list = AndExpression_346_Var
		.getExpr();
		Assert.assertNotNull(Expr_346_list);
		Assert.assertEquals(1, Expr_346_list.size());
		//346
		final EqualityExpression EqualityExpression_347_Var
		 = (EqualityExpression)Expr_346_list.get(0);
		Assert.assertNotNull(EqualityExpression_347_Var
		);
		final EList<? extends EObject> Expr_347_list = EqualityExpression_347_Var
		.getExpr();
		Assert.assertNotNull(Expr_347_list);
		Assert.assertEquals(1, Expr_347_list.size());
		//347
		final RelationalExpression RelationalExpression_348_Var
		 = (RelationalExpression)Expr_347_list.get(0);
		Assert.assertNotNull(RelationalExpression_348_Var
		);
		final EList<? extends EObject> Expr_348_list = RelationalExpression_348_Var
		.getExpr();
		Assert.assertNotNull(Expr_348_list);
		Assert.assertEquals(1, Expr_348_list.size());
		//348
		final ShiftExpression ShiftExpression_349_Var
		 = (ShiftExpression)Expr_348_list.get(0);
		Assert.assertNotNull(ShiftExpression_349_Var
		);
		final EList<? extends EObject> Expr_349_list = ShiftExpression_349_Var
		.getExpr();
		Assert.assertNotNull(Expr_349_list);
		Assert.assertEquals(1, Expr_349_list.size());
		//349
		final AdditiveExpression AdditiveExpression_350_Var
		 = (AdditiveExpression)Expr_349_list.get(0);
		Assert.assertNotNull(AdditiveExpression_350_Var
		);
		final EList<? extends EObject> Expr_350_list = AdditiveExpression_350_Var
		.getExpr();
		Assert.assertNotNull(Expr_350_list);
		Assert.assertEquals(1, Expr_350_list.size());
		//350
		final MultiplicativeExpression MultiplicativeExpression_351_Var
		 = (MultiplicativeExpression)Expr_350_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_351_Var
		);
		final EList<? extends EObject> Expr_351_list = MultiplicativeExpression_351_Var
		.getExpr();
		Assert.assertNotNull(Expr_351_list);
		Assert.assertEquals(1, Expr_351_list.size());
		//351
		final CastExpression CastExpression_352_Var
		 = (CastExpression)Expr_351_list.get(0);
		Assert.assertNotNull(CastExpression_352_Var
		);
		//352
		final UnaryExpression UnaryExpression_353_Var
		 = (UnaryExpression)CastExpression_352_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_353_Var
		);
		//353
		final PostfixExpression PostfixExpression_354_Var
		 = (PostfixExpression)UnaryExpression_353_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_354_Var
		);
		final EList<? extends EObject> Expr_354_list = PostfixExpression_354_Var
		.getExpr();
		Assert.assertNotNull(Expr_354_list);
		Assert.assertEquals(1, Expr_354_list.size());
		//354
		final PrimaryExpression PrimaryExpression_355_Var
		 = (PrimaryExpression)Expr_354_list.get(0);
		Assert.assertNotNull(PrimaryExpression_355_Var
		);
		Assert.assertEquals("number", PrimaryExpression_355_Var
		.getId());
		final EList<? extends EObject> Suffix_355_list = PostfixExpression_354_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_355_list);
		Assert.assertEquals(1, Suffix_355_list.size());
		//355
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_356_Var
		 = (PostfixExpressionSuffixDot)Suffix_355_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_356_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_356_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_303_Var
		.getSemi());
		//356
		final Statement Statement_357_Var
		 = (Statement)Statement_93_list.get(5);
		Assert.assertNotNull(Statement_357_Var
		);
		//357
		final ExpressionStatement ExpressionStatement_358_Var
		 = (ExpressionStatement)Statement_357_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_358_Var
		);
		//358
		final Expression Expression_359_Var
		 = (Expression)ExpressionStatement_358_Var
		.getExpression();
		Assert.assertNotNull(Expression_359_Var
		);
		final EList<? extends EObject> ExprExpr_359_list = Expression_359_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_359_list);
		Assert.assertEquals(1, ExprExpr_359_list.size());
		//359
		final AssignmentExpression AssignmentExpression_360_Var
		 = (AssignmentExpression)ExprExpr_359_list.get(0);
		Assert.assertNotNull(AssignmentExpression_360_Var
		);
		//360
		final ConditionalExpression ConditionalExpression_361_Var
		 = (ConditionalExpression)AssignmentExpression_360_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_361_Var
		);
		//361
		final LogicalOrExpression LogicalOrExpression_362_Var
		 = (LogicalOrExpression)ConditionalExpression_361_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_362_Var
		);
		final EList<? extends EObject> Expr_362_list = LogicalOrExpression_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(1, Expr_362_list.size());
		//362
		final LogicalAndExpression LogicalAndExpression_363_Var
		 = (LogicalAndExpression)Expr_362_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_363_Var
		);
		final EList<? extends EObject> Expr_363_list = LogicalAndExpression_363_Var
		.getExpr();
		Assert.assertNotNull(Expr_363_list);
		Assert.assertEquals(1, Expr_363_list.size());
		//363
		final InclusiveOrExpression InclusiveOrExpression_364_Var
		 = (InclusiveOrExpression)Expr_363_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_364_Var
		);
		final EList<? extends EObject> Expr_364_list = InclusiveOrExpression_364_Var
		.getExpr();
		Assert.assertNotNull(Expr_364_list);
		Assert.assertEquals(1, Expr_364_list.size());
		//364
		final ExclusiveOrExpression ExclusiveOrExpression_365_Var
		 = (ExclusiveOrExpression)Expr_364_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = ExclusiveOrExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final AndExpression AndExpression_366_Var
		 = (AndExpression)Expr_365_list.get(0);
		Assert.assertNotNull(AndExpression_366_Var
		);
		final EList<? extends EObject> Expr_366_list = AndExpression_366_Var
		.getExpr();
		Assert.assertNotNull(Expr_366_list);
		Assert.assertEquals(1, Expr_366_list.size());
		//366
		final EqualityExpression EqualityExpression_367_Var
		 = (EqualityExpression)Expr_366_list.get(0);
		Assert.assertNotNull(EqualityExpression_367_Var
		);
		final EList<? extends EObject> Expr_367_list = EqualityExpression_367_Var
		.getExpr();
		Assert.assertNotNull(Expr_367_list);
		Assert.assertEquals(1, Expr_367_list.size());
		//367
		final RelationalExpression RelationalExpression_368_Var
		 = (RelationalExpression)Expr_367_list.get(0);
		Assert.assertNotNull(RelationalExpression_368_Var
		);
		final EList<? extends EObject> Expr_368_list = RelationalExpression_368_Var
		.getExpr();
		Assert.assertNotNull(Expr_368_list);
		Assert.assertEquals(1, Expr_368_list.size());
		//368
		final ShiftExpression ShiftExpression_369_Var
		 = (ShiftExpression)Expr_368_list.get(0);
		Assert.assertNotNull(ShiftExpression_369_Var
		);
		final EList<? extends EObject> Expr_369_list = ShiftExpression_369_Var
		.getExpr();
		Assert.assertNotNull(Expr_369_list);
		Assert.assertEquals(1, Expr_369_list.size());
		//369
		final AdditiveExpression AdditiveExpression_370_Var
		 = (AdditiveExpression)Expr_369_list.get(0);
		Assert.assertNotNull(AdditiveExpression_370_Var
		);
		final EList<? extends EObject> Expr_370_list = AdditiveExpression_370_Var
		.getExpr();
		Assert.assertNotNull(Expr_370_list);
		Assert.assertEquals(1, Expr_370_list.size());
		//370
		final MultiplicativeExpression MultiplicativeExpression_371_Var
		 = (MultiplicativeExpression)Expr_370_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_371_Var
		);
		final EList<? extends EObject> Expr_371_list = MultiplicativeExpression_371_Var
		.getExpr();
		Assert.assertNotNull(Expr_371_list);
		Assert.assertEquals(1, Expr_371_list.size());
		//371
		final CastExpression CastExpression_372_Var
		 = (CastExpression)Expr_371_list.get(0);
		Assert.assertNotNull(CastExpression_372_Var
		);
		//372
		final UnaryExpression UnaryExpression_373_Var
		 = (UnaryExpression)CastExpression_372_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_373_Var
		);
		//373
		final PostfixExpression PostfixExpression_374_Var
		 = (PostfixExpression)UnaryExpression_373_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_374_Var
		);
		final EList<? extends EObject> Expr_374_list = PostfixExpression_374_Var
		.getExpr();
		Assert.assertNotNull(Expr_374_list);
		Assert.assertEquals(1, Expr_374_list.size());
		//374
		final PrimaryExpression PrimaryExpression_375_Var
		 = (PrimaryExpression)Expr_374_list.get(0);
		Assert.assertNotNull(PrimaryExpression_375_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_375_Var
		.getId());
		final EList<? extends EObject> Suffix_375_list = PostfixExpression_374_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_375_list);
		Assert.assertEquals(1, Suffix_375_list.size());
		//375
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_376_Var
		 = (PostfixExpressionSuffixArgument)Suffix_375_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_376_Var
		);
		//376
		final ArgumentExpressionList ArgumentExpressionList_377_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_376_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_377_Var
		);
		final EList<? extends EObject> Expr_377_list = ArgumentExpressionList_377_Var
		.getExpr();
		Assert.assertNotNull(Expr_377_list);
		Assert.assertEquals(2, Expr_377_list.size());
		//377
		final AssignmentExpression AssignmentExpression_378_Var
		 = (AssignmentExpression)Expr_377_list.get(0);
		Assert.assertNotNull(AssignmentExpression_378_Var
		);
		//378
		final ConditionalExpression ConditionalExpression_379_Var
		 = (ConditionalExpression)AssignmentExpression_378_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_379_Var
		);
		//379
		final LogicalOrExpression LogicalOrExpression_380_Var
		 = (LogicalOrExpression)ConditionalExpression_379_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_380_Var
		);
		final EList<? extends EObject> Expr_380_list = LogicalOrExpression_380_Var
		.getExpr();
		Assert.assertNotNull(Expr_380_list);
		Assert.assertEquals(1, Expr_380_list.size());
		//380
		final LogicalAndExpression LogicalAndExpression_381_Var
		 = (LogicalAndExpression)Expr_380_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_381_Var
		);
		final EList<? extends EObject> Expr_381_list = LogicalAndExpression_381_Var
		.getExpr();
		Assert.assertNotNull(Expr_381_list);
		Assert.assertEquals(1, Expr_381_list.size());
		//381
		final InclusiveOrExpression InclusiveOrExpression_382_Var
		 = (InclusiveOrExpression)Expr_381_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_382_Var
		);
		final EList<? extends EObject> Expr_382_list = InclusiveOrExpression_382_Var
		.getExpr();
		Assert.assertNotNull(Expr_382_list);
		Assert.assertEquals(1, Expr_382_list.size());
		//382
		final ExclusiveOrExpression ExclusiveOrExpression_383_Var
		 = (ExclusiveOrExpression)Expr_382_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_383_Var
		);
		final EList<? extends EObject> Expr_383_list = ExclusiveOrExpression_383_Var
		.getExpr();
		Assert.assertNotNull(Expr_383_list);
		Assert.assertEquals(1, Expr_383_list.size());
		//383
		final AndExpression AndExpression_384_Var
		 = (AndExpression)Expr_383_list.get(0);
		Assert.assertNotNull(AndExpression_384_Var
		);
		final EList<? extends EObject> Expr_384_list = AndExpression_384_Var
		.getExpr();
		Assert.assertNotNull(Expr_384_list);
		Assert.assertEquals(1, Expr_384_list.size());
		//384
		final EqualityExpression EqualityExpression_385_Var
		 = (EqualityExpression)Expr_384_list.get(0);
		Assert.assertNotNull(EqualityExpression_385_Var
		);
		final EList<? extends EObject> Expr_385_list = EqualityExpression_385_Var
		.getExpr();
		Assert.assertNotNull(Expr_385_list);
		Assert.assertEquals(1, Expr_385_list.size());
		//385
		final RelationalExpression RelationalExpression_386_Var
		 = (RelationalExpression)Expr_385_list.get(0);
		Assert.assertNotNull(RelationalExpression_386_Var
		);
		final EList<? extends EObject> Expr_386_list = RelationalExpression_386_Var
		.getExpr();
		Assert.assertNotNull(Expr_386_list);
		Assert.assertEquals(1, Expr_386_list.size());
		//386
		final ShiftExpression ShiftExpression_387_Var
		 = (ShiftExpression)Expr_386_list.get(0);
		Assert.assertNotNull(ShiftExpression_387_Var
		);
		final EList<? extends EObject> Expr_387_list = ShiftExpression_387_Var
		.getExpr();
		Assert.assertNotNull(Expr_387_list);
		Assert.assertEquals(1, Expr_387_list.size());
		//387
		final AdditiveExpression AdditiveExpression_388_Var
		 = (AdditiveExpression)Expr_387_list.get(0);
		Assert.assertNotNull(AdditiveExpression_388_Var
		);
		final EList<? extends EObject> Expr_388_list = AdditiveExpression_388_Var
		.getExpr();
		Assert.assertNotNull(Expr_388_list);
		Assert.assertEquals(1, Expr_388_list.size());
		//388
		final MultiplicativeExpression MultiplicativeExpression_389_Var
		 = (MultiplicativeExpression)Expr_388_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_389_Var
		);
		final EList<? extends EObject> Expr_389_list = MultiplicativeExpression_389_Var
		.getExpr();
		Assert.assertNotNull(Expr_389_list);
		Assert.assertEquals(1, Expr_389_list.size());
		//389
		final CastExpression CastExpression_390_Var
		 = (CastExpression)Expr_389_list.get(0);
		Assert.assertNotNull(CastExpression_390_Var
		);
		//390
		final UnaryExpression UnaryExpression_391_Var
		 = (UnaryExpression)CastExpression_390_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_391_Var
		);
		//391
		final PostfixExpression PostfixExpression_392_Var
		 = (PostfixExpression)UnaryExpression_391_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_392_Var
		);
		final EList<? extends EObject> Expr_392_list = PostfixExpression_392_Var
		.getExpr();
		Assert.assertNotNull(Expr_392_list);
		Assert.assertEquals(1, Expr_392_list.size());
		//392
		final PrimaryExpression PrimaryExpression_393_Var
		 = (PrimaryExpression)Expr_392_list.get(0);
		Assert.assertNotNull(PrimaryExpression_393_Var
		);
		//393
		final Constant2 Constant2_394_Var
		 = (Constant2)PrimaryExpression_393_Var
		.getConst();
		Assert.assertNotNull(Constant2_394_Var
		);
		Assert.assertEquals("\"number.numChar(as char)=%c\\n\"", Constant2_394_Var
		.getStr());
		//394
		final AssignmentExpression AssignmentExpression_395_Var
		 = (AssignmentExpression)Expr_377_list.get(1);
		Assert.assertNotNull(AssignmentExpression_395_Var
		);
		//395
		final ConditionalExpression ConditionalExpression_396_Var
		 = (ConditionalExpression)AssignmentExpression_395_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_396_Var
		);
		//396
		final LogicalOrExpression LogicalOrExpression_397_Var
		 = (LogicalOrExpression)ConditionalExpression_396_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_397_Var
		);
		final EList<? extends EObject> Expr_397_list = LogicalOrExpression_397_Var
		.getExpr();
		Assert.assertNotNull(Expr_397_list);
		Assert.assertEquals(1, Expr_397_list.size());
		//397
		final LogicalAndExpression LogicalAndExpression_398_Var
		 = (LogicalAndExpression)Expr_397_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_398_Var
		);
		final EList<? extends EObject> Expr_398_list = LogicalAndExpression_398_Var
		.getExpr();
		Assert.assertNotNull(Expr_398_list);
		Assert.assertEquals(1, Expr_398_list.size());
		//398
		final InclusiveOrExpression InclusiveOrExpression_399_Var
		 = (InclusiveOrExpression)Expr_398_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_399_Var
		);
		final EList<? extends EObject> Expr_399_list = InclusiveOrExpression_399_Var
		.getExpr();
		Assert.assertNotNull(Expr_399_list);
		Assert.assertEquals(1, Expr_399_list.size());
		//399
		final ExclusiveOrExpression ExclusiveOrExpression_400_Var
		 = (ExclusiveOrExpression)Expr_399_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_400_Var
		);
		final EList<? extends EObject> Expr_400_list = ExclusiveOrExpression_400_Var
		.getExpr();
		Assert.assertNotNull(Expr_400_list);
		Assert.assertEquals(1, Expr_400_list.size());
		//400
		final AndExpression AndExpression_401_Var
		 = (AndExpression)Expr_400_list.get(0);
		Assert.assertNotNull(AndExpression_401_Var
		);
		final EList<? extends EObject> Expr_401_list = AndExpression_401_Var
		.getExpr();
		Assert.assertNotNull(Expr_401_list);
		Assert.assertEquals(1, Expr_401_list.size());
		//401
		final EqualityExpression EqualityExpression_402_Var
		 = (EqualityExpression)Expr_401_list.get(0);
		Assert.assertNotNull(EqualityExpression_402_Var
		);
		final EList<? extends EObject> Expr_402_list = EqualityExpression_402_Var
		.getExpr();
		Assert.assertNotNull(Expr_402_list);
		Assert.assertEquals(1, Expr_402_list.size());
		//402
		final RelationalExpression RelationalExpression_403_Var
		 = (RelationalExpression)Expr_402_list.get(0);
		Assert.assertNotNull(RelationalExpression_403_Var
		);
		final EList<? extends EObject> Expr_403_list = RelationalExpression_403_Var
		.getExpr();
		Assert.assertNotNull(Expr_403_list);
		Assert.assertEquals(1, Expr_403_list.size());
		//403
		final ShiftExpression ShiftExpression_404_Var
		 = (ShiftExpression)Expr_403_list.get(0);
		Assert.assertNotNull(ShiftExpression_404_Var
		);
		final EList<? extends EObject> Expr_404_list = ShiftExpression_404_Var
		.getExpr();
		Assert.assertNotNull(Expr_404_list);
		Assert.assertEquals(1, Expr_404_list.size());
		//404
		final AdditiveExpression AdditiveExpression_405_Var
		 = (AdditiveExpression)Expr_404_list.get(0);
		Assert.assertNotNull(AdditiveExpression_405_Var
		);
		final EList<? extends EObject> Expr_405_list = AdditiveExpression_405_Var
		.getExpr();
		Assert.assertNotNull(Expr_405_list);
		Assert.assertEquals(1, Expr_405_list.size());
		//405
		final MultiplicativeExpression MultiplicativeExpression_406_Var
		 = (MultiplicativeExpression)Expr_405_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_406_Var
		);
		final EList<? extends EObject> Expr_406_list = MultiplicativeExpression_406_Var
		.getExpr();
		Assert.assertNotNull(Expr_406_list);
		Assert.assertEquals(1, Expr_406_list.size());
		//406
		final CastExpression CastExpression_407_Var
		 = (CastExpression)Expr_406_list.get(0);
		Assert.assertNotNull(CastExpression_407_Var
		);
		//407
		final UnaryExpression UnaryExpression_408_Var
		 = (UnaryExpression)CastExpression_407_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_408_Var
		);
		//408
		final PostfixExpression PostfixExpression_409_Var
		 = (PostfixExpression)UnaryExpression_408_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_409_Var
		);
		final EList<? extends EObject> Expr_409_list = PostfixExpression_409_Var
		.getExpr();
		Assert.assertNotNull(Expr_409_list);
		Assert.assertEquals(1, Expr_409_list.size());
		//409
		final PrimaryExpression PrimaryExpression_410_Var
		 = (PrimaryExpression)Expr_409_list.get(0);
		Assert.assertNotNull(PrimaryExpression_410_Var
		);
		Assert.assertEquals("number", PrimaryExpression_410_Var
		.getId());
		final EList<? extends EObject> Suffix_410_list = PostfixExpression_409_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_410_list);
		Assert.assertEquals(1, Suffix_410_list.size());
		//410
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_411_Var
		 = (PostfixExpressionSuffixDot)Suffix_410_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_411_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_411_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_358_Var
		.getSemi());
		//411
		final Statement Statement_412_Var
		 = (Statement)Statement_93_list.get(6);
		Assert.assertNotNull(Statement_412_Var
		);
		//412
		final ExpressionStatement ExpressionStatement_413_Var
		 = (ExpressionStatement)Statement_412_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_413_Var
		);
		//413
		final Expression Expression_414_Var
		 = (Expression)ExpressionStatement_413_Var
		.getExpression();
		Assert.assertNotNull(Expression_414_Var
		);
		final EList<? extends EObject> ExprExpr_414_list = Expression_414_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_414_list);
		Assert.assertEquals(1, ExprExpr_414_list.size());
		//414
		final AssignmentExpression AssignmentExpression_415_Var
		 = (AssignmentExpression)ExprExpr_414_list.get(0);
		Assert.assertNotNull(AssignmentExpression_415_Var
		);
		//415
		final ConditionalExpression ConditionalExpression_416_Var
		 = (ConditionalExpression)AssignmentExpression_415_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_416_Var
		);
		//416
		final LogicalOrExpression LogicalOrExpression_417_Var
		 = (LogicalOrExpression)ConditionalExpression_416_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_417_Var
		);
		final EList<? extends EObject> Expr_417_list = LogicalOrExpression_417_Var
		.getExpr();
		Assert.assertNotNull(Expr_417_list);
		Assert.assertEquals(1, Expr_417_list.size());
		//417
		final LogicalAndExpression LogicalAndExpression_418_Var
		 = (LogicalAndExpression)Expr_417_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_418_Var
		);
		final EList<? extends EObject> Expr_418_list = LogicalAndExpression_418_Var
		.getExpr();
		Assert.assertNotNull(Expr_418_list);
		Assert.assertEquals(1, Expr_418_list.size());
		//418
		final InclusiveOrExpression InclusiveOrExpression_419_Var
		 = (InclusiveOrExpression)Expr_418_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_419_Var
		);
		final EList<? extends EObject> Expr_419_list = InclusiveOrExpression_419_Var
		.getExpr();
		Assert.assertNotNull(Expr_419_list);
		Assert.assertEquals(1, Expr_419_list.size());
		//419
		final ExclusiveOrExpression ExclusiveOrExpression_420_Var
		 = (ExclusiveOrExpression)Expr_419_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_420_Var
		);
		final EList<? extends EObject> Expr_420_list = ExclusiveOrExpression_420_Var
		.getExpr();
		Assert.assertNotNull(Expr_420_list);
		Assert.assertEquals(1, Expr_420_list.size());
		//420
		final AndExpression AndExpression_421_Var
		 = (AndExpression)Expr_420_list.get(0);
		Assert.assertNotNull(AndExpression_421_Var
		);
		final EList<? extends EObject> Expr_421_list = AndExpression_421_Var
		.getExpr();
		Assert.assertNotNull(Expr_421_list);
		Assert.assertEquals(1, Expr_421_list.size());
		//421
		final EqualityExpression EqualityExpression_422_Var
		 = (EqualityExpression)Expr_421_list.get(0);
		Assert.assertNotNull(EqualityExpression_422_Var
		);
		final EList<? extends EObject> Expr_422_list = EqualityExpression_422_Var
		.getExpr();
		Assert.assertNotNull(Expr_422_list);
		Assert.assertEquals(1, Expr_422_list.size());
		//422
		final RelationalExpression RelationalExpression_423_Var
		 = (RelationalExpression)Expr_422_list.get(0);
		Assert.assertNotNull(RelationalExpression_423_Var
		);
		final EList<? extends EObject> Expr_423_list = RelationalExpression_423_Var
		.getExpr();
		Assert.assertNotNull(Expr_423_list);
		Assert.assertEquals(1, Expr_423_list.size());
		//423
		final ShiftExpression ShiftExpression_424_Var
		 = (ShiftExpression)Expr_423_list.get(0);
		Assert.assertNotNull(ShiftExpression_424_Var
		);
		final EList<? extends EObject> Expr_424_list = ShiftExpression_424_Var
		.getExpr();
		Assert.assertNotNull(Expr_424_list);
		Assert.assertEquals(1, Expr_424_list.size());
		//424
		final AdditiveExpression AdditiveExpression_425_Var
		 = (AdditiveExpression)Expr_424_list.get(0);
		Assert.assertNotNull(AdditiveExpression_425_Var
		);
		final EList<? extends EObject> Expr_425_list = AdditiveExpression_425_Var
		.getExpr();
		Assert.assertNotNull(Expr_425_list);
		Assert.assertEquals(1, Expr_425_list.size());
		//425
		final MultiplicativeExpression MultiplicativeExpression_426_Var
		 = (MultiplicativeExpression)Expr_425_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_426_Var
		);
		final EList<? extends EObject> Expr_426_list = MultiplicativeExpression_426_Var
		.getExpr();
		Assert.assertNotNull(Expr_426_list);
		Assert.assertEquals(1, Expr_426_list.size());
		//426
		final CastExpression CastExpression_427_Var
		 = (CastExpression)Expr_426_list.get(0);
		Assert.assertNotNull(CastExpression_427_Var
		);
		//427
		final UnaryExpression UnaryExpression_428_Var
		 = (UnaryExpression)CastExpression_427_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_428_Var
		);
		//428
		final PostfixExpression PostfixExpression_429_Var
		 = (PostfixExpression)UnaryExpression_428_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_429_Var
		);
		final EList<? extends EObject> Expr_429_list = PostfixExpression_429_Var
		.getExpr();
		Assert.assertNotNull(Expr_429_list);
		Assert.assertEquals(1, Expr_429_list.size());
		//429
		final PrimaryExpression PrimaryExpression_430_Var
		 = (PrimaryExpression)Expr_429_list.get(0);
		Assert.assertNotNull(PrimaryExpression_430_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_430_Var
		.getId());
		final EList<? extends EObject> Suffix_430_list = PostfixExpression_429_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_430_list);
		Assert.assertEquals(1, Suffix_430_list.size());
		//430
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_431_Var
		 = (PostfixExpressionSuffixArgument)Suffix_430_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_431_Var
		);
		//431
		final ArgumentExpressionList ArgumentExpressionList_432_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_431_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_432_Var
		);
		final EList<? extends EObject> Expr_432_list = ArgumentExpressionList_432_Var
		.getExpr();
		Assert.assertNotNull(Expr_432_list);
		Assert.assertEquals(2, Expr_432_list.size());
		//432
		final AssignmentExpression AssignmentExpression_433_Var
		 = (AssignmentExpression)Expr_432_list.get(0);
		Assert.assertNotNull(AssignmentExpression_433_Var
		);
		//433
		final ConditionalExpression ConditionalExpression_434_Var
		 = (ConditionalExpression)AssignmentExpression_433_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_434_Var
		);
		//434
		final LogicalOrExpression LogicalOrExpression_435_Var
		 = (LogicalOrExpression)ConditionalExpression_434_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_435_Var
		);
		final EList<? extends EObject> Expr_435_list = LogicalOrExpression_435_Var
		.getExpr();
		Assert.assertNotNull(Expr_435_list);
		Assert.assertEquals(1, Expr_435_list.size());
		//435
		final LogicalAndExpression LogicalAndExpression_436_Var
		 = (LogicalAndExpression)Expr_435_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_436_Var
		);
		final EList<? extends EObject> Expr_436_list = LogicalAndExpression_436_Var
		.getExpr();
		Assert.assertNotNull(Expr_436_list);
		Assert.assertEquals(1, Expr_436_list.size());
		//436
		final InclusiveOrExpression InclusiveOrExpression_437_Var
		 = (InclusiveOrExpression)Expr_436_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_437_Var
		);
		final EList<? extends EObject> Expr_437_list = InclusiveOrExpression_437_Var
		.getExpr();
		Assert.assertNotNull(Expr_437_list);
		Assert.assertEquals(1, Expr_437_list.size());
		//437
		final ExclusiveOrExpression ExclusiveOrExpression_438_Var
		 = (ExclusiveOrExpression)Expr_437_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_438_Var
		);
		final EList<? extends EObject> Expr_438_list = ExclusiveOrExpression_438_Var
		.getExpr();
		Assert.assertNotNull(Expr_438_list);
		Assert.assertEquals(1, Expr_438_list.size());
		//438
		final AndExpression AndExpression_439_Var
		 = (AndExpression)Expr_438_list.get(0);
		Assert.assertNotNull(AndExpression_439_Var
		);
		final EList<? extends EObject> Expr_439_list = AndExpression_439_Var
		.getExpr();
		Assert.assertNotNull(Expr_439_list);
		Assert.assertEquals(1, Expr_439_list.size());
		//439
		final EqualityExpression EqualityExpression_440_Var
		 = (EqualityExpression)Expr_439_list.get(0);
		Assert.assertNotNull(EqualityExpression_440_Var
		);
		final EList<? extends EObject> Expr_440_list = EqualityExpression_440_Var
		.getExpr();
		Assert.assertNotNull(Expr_440_list);
		Assert.assertEquals(1, Expr_440_list.size());
		//440
		final RelationalExpression RelationalExpression_441_Var
		 = (RelationalExpression)Expr_440_list.get(0);
		Assert.assertNotNull(RelationalExpression_441_Var
		);
		final EList<? extends EObject> Expr_441_list = RelationalExpression_441_Var
		.getExpr();
		Assert.assertNotNull(Expr_441_list);
		Assert.assertEquals(1, Expr_441_list.size());
		//441
		final ShiftExpression ShiftExpression_442_Var
		 = (ShiftExpression)Expr_441_list.get(0);
		Assert.assertNotNull(ShiftExpression_442_Var
		);
		final EList<? extends EObject> Expr_442_list = ShiftExpression_442_Var
		.getExpr();
		Assert.assertNotNull(Expr_442_list);
		Assert.assertEquals(1, Expr_442_list.size());
		//442
		final AdditiveExpression AdditiveExpression_443_Var
		 = (AdditiveExpression)Expr_442_list.get(0);
		Assert.assertNotNull(AdditiveExpression_443_Var
		);
		final EList<? extends EObject> Expr_443_list = AdditiveExpression_443_Var
		.getExpr();
		Assert.assertNotNull(Expr_443_list);
		Assert.assertEquals(1, Expr_443_list.size());
		//443
		final MultiplicativeExpression MultiplicativeExpression_444_Var
		 = (MultiplicativeExpression)Expr_443_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_444_Var
		);
		final EList<? extends EObject> Expr_444_list = MultiplicativeExpression_444_Var
		.getExpr();
		Assert.assertNotNull(Expr_444_list);
		Assert.assertEquals(1, Expr_444_list.size());
		//444
		final CastExpression CastExpression_445_Var
		 = (CastExpression)Expr_444_list.get(0);
		Assert.assertNotNull(CastExpression_445_Var
		);
		//445
		final UnaryExpression UnaryExpression_446_Var
		 = (UnaryExpression)CastExpression_445_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_446_Var
		);
		//446
		final PostfixExpression PostfixExpression_447_Var
		 = (PostfixExpression)UnaryExpression_446_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_447_Var
		);
		final EList<? extends EObject> Expr_447_list = PostfixExpression_447_Var
		.getExpr();
		Assert.assertNotNull(Expr_447_list);
		Assert.assertEquals(1, Expr_447_list.size());
		//447
		final PrimaryExpression PrimaryExpression_448_Var
		 = (PrimaryExpression)Expr_447_list.get(0);
		Assert.assertNotNull(PrimaryExpression_448_Var
		);
		//448
		final Constant2 Constant2_449_Var
		 = (Constant2)PrimaryExpression_448_Var
		.getConst();
		Assert.assertNotNull(Constant2_449_Var
		);
		Assert.assertEquals("\"number.numFloat=%f\\n\"", Constant2_449_Var
		.getStr());
		//449
		final AssignmentExpression AssignmentExpression_450_Var
		 = (AssignmentExpression)Expr_432_list.get(1);
		Assert.assertNotNull(AssignmentExpression_450_Var
		);
		//450
		final ConditionalExpression ConditionalExpression_451_Var
		 = (ConditionalExpression)AssignmentExpression_450_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_451_Var
		);
		//451
		final LogicalOrExpression LogicalOrExpression_452_Var
		 = (LogicalOrExpression)ConditionalExpression_451_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_452_Var
		);
		final EList<? extends EObject> Expr_452_list = LogicalOrExpression_452_Var
		.getExpr();
		Assert.assertNotNull(Expr_452_list);
		Assert.assertEquals(1, Expr_452_list.size());
		//452
		final LogicalAndExpression LogicalAndExpression_453_Var
		 = (LogicalAndExpression)Expr_452_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_453_Var
		);
		final EList<? extends EObject> Expr_453_list = LogicalAndExpression_453_Var
		.getExpr();
		Assert.assertNotNull(Expr_453_list);
		Assert.assertEquals(1, Expr_453_list.size());
		//453
		final InclusiveOrExpression InclusiveOrExpression_454_Var
		 = (InclusiveOrExpression)Expr_453_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_454_Var
		);
		final EList<? extends EObject> Expr_454_list = InclusiveOrExpression_454_Var
		.getExpr();
		Assert.assertNotNull(Expr_454_list);
		Assert.assertEquals(1, Expr_454_list.size());
		//454
		final ExclusiveOrExpression ExclusiveOrExpression_455_Var
		 = (ExclusiveOrExpression)Expr_454_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_455_Var
		);
		final EList<? extends EObject> Expr_455_list = ExclusiveOrExpression_455_Var
		.getExpr();
		Assert.assertNotNull(Expr_455_list);
		Assert.assertEquals(1, Expr_455_list.size());
		//455
		final AndExpression AndExpression_456_Var
		 = (AndExpression)Expr_455_list.get(0);
		Assert.assertNotNull(AndExpression_456_Var
		);
		final EList<? extends EObject> Expr_456_list = AndExpression_456_Var
		.getExpr();
		Assert.assertNotNull(Expr_456_list);
		Assert.assertEquals(1, Expr_456_list.size());
		//456
		final EqualityExpression EqualityExpression_457_Var
		 = (EqualityExpression)Expr_456_list.get(0);
		Assert.assertNotNull(EqualityExpression_457_Var
		);
		final EList<? extends EObject> Expr_457_list = EqualityExpression_457_Var
		.getExpr();
		Assert.assertNotNull(Expr_457_list);
		Assert.assertEquals(1, Expr_457_list.size());
		//457
		final RelationalExpression RelationalExpression_458_Var
		 = (RelationalExpression)Expr_457_list.get(0);
		Assert.assertNotNull(RelationalExpression_458_Var
		);
		final EList<? extends EObject> Expr_458_list = RelationalExpression_458_Var
		.getExpr();
		Assert.assertNotNull(Expr_458_list);
		Assert.assertEquals(1, Expr_458_list.size());
		//458
		final ShiftExpression ShiftExpression_459_Var
		 = (ShiftExpression)Expr_458_list.get(0);
		Assert.assertNotNull(ShiftExpression_459_Var
		);
		final EList<? extends EObject> Expr_459_list = ShiftExpression_459_Var
		.getExpr();
		Assert.assertNotNull(Expr_459_list);
		Assert.assertEquals(1, Expr_459_list.size());
		//459
		final AdditiveExpression AdditiveExpression_460_Var
		 = (AdditiveExpression)Expr_459_list.get(0);
		Assert.assertNotNull(AdditiveExpression_460_Var
		);
		final EList<? extends EObject> Expr_460_list = AdditiveExpression_460_Var
		.getExpr();
		Assert.assertNotNull(Expr_460_list);
		Assert.assertEquals(1, Expr_460_list.size());
		//460
		final MultiplicativeExpression MultiplicativeExpression_461_Var
		 = (MultiplicativeExpression)Expr_460_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_461_Var
		);
		final EList<? extends EObject> Expr_461_list = MultiplicativeExpression_461_Var
		.getExpr();
		Assert.assertNotNull(Expr_461_list);
		Assert.assertEquals(1, Expr_461_list.size());
		//461
		final CastExpression CastExpression_462_Var
		 = (CastExpression)Expr_461_list.get(0);
		Assert.assertNotNull(CastExpression_462_Var
		);
		//462
		final UnaryExpression UnaryExpression_463_Var
		 = (UnaryExpression)CastExpression_462_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_463_Var
		);
		//463
		final PostfixExpression PostfixExpression_464_Var
		 = (PostfixExpression)UnaryExpression_463_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_464_Var
		);
		final EList<? extends EObject> Expr_464_list = PostfixExpression_464_Var
		.getExpr();
		Assert.assertNotNull(Expr_464_list);
		Assert.assertEquals(1, Expr_464_list.size());
		//464
		final PrimaryExpression PrimaryExpression_465_Var
		 = (PrimaryExpression)Expr_464_list.get(0);
		Assert.assertNotNull(PrimaryExpression_465_Var
		);
		Assert.assertEquals("number", PrimaryExpression_465_Var
		.getId());
		final EList<? extends EObject> Suffix_465_list = PostfixExpression_464_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_465_list);
		Assert.assertEquals(1, Suffix_465_list.size());
		//465
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_466_Var
		 = (PostfixExpressionSuffixDot)Suffix_465_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_466_Var
		);
		Assert.assertEquals("numFloat", PostfixExpressionSuffixDot_466_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_413_Var
		.getSemi());
		//466
		final Statement Statement_467_Var
		 = (Statement)Statement_93_list.get(7);
		Assert.assertNotNull(Statement_467_Var
		);
		//467
		final ExpressionStatement ExpressionStatement_468_Var
		 = (ExpressionStatement)Statement_467_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_468_Var
		);
		//468
		final Expression Expression_469_Var
		 = (Expression)ExpressionStatement_468_Var
		.getExpression();
		Assert.assertNotNull(Expression_469_Var
		);
		final EList<? extends EObject> ExprExpr_469_list = Expression_469_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_469_list);
		Assert.assertEquals(1, ExprExpr_469_list.size());
		//469
		final AssignmentExpression AssignmentExpression_470_Var
		 = (AssignmentExpression)ExprExpr_469_list.get(0);
		Assert.assertNotNull(AssignmentExpression_470_Var
		);
		//470
		final UnaryExpression UnaryExpression_471_Var
		 = (UnaryExpression)AssignmentExpression_470_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_471_Var
		);
		//471
		final PostfixExpression PostfixExpression_472_Var
		 = (PostfixExpression)UnaryExpression_471_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_472_Var
		);
		final EList<? extends EObject> Expr_472_list = PostfixExpression_472_Var
		.getExpr();
		Assert.assertNotNull(Expr_472_list);
		Assert.assertEquals(1, Expr_472_list.size());
		//472
		final PrimaryExpression PrimaryExpression_473_Var
		 = (PrimaryExpression)Expr_472_list.get(0);
		Assert.assertNotNull(PrimaryExpression_473_Var
		);
		Assert.assertEquals("number", PrimaryExpression_473_Var
		.getId());
		final EList<? extends EObject> Suffix_473_list = PostfixExpression_472_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_473_list);
		Assert.assertEquals(1, Suffix_473_list.size());
		//473
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_474_Var
		 = (PostfixExpressionSuffixDot)Suffix_473_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_474_Var
		);
		Assert.assertEquals("numFloat", PostfixExpressionSuffixDot_474_Var
		.getId());
		//474
		final AssignmentOperator AssignmentOperator_475_Var
		 = (AssignmentOperator)AssignmentExpression_470_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_475_Var
		);
		Assert.assertEquals("=", AssignmentOperator_475_Var
		.getOp());
		//475
		final AssignmentExpression AssignmentExpression_476_Var
		 = (AssignmentExpression)AssignmentExpression_470_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_476_Var
		);
		//476
		final ConditionalExpression ConditionalExpression_477_Var
		 = (ConditionalExpression)AssignmentExpression_476_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_477_Var
		);
		//477
		final LogicalOrExpression LogicalOrExpression_478_Var
		 = (LogicalOrExpression)ConditionalExpression_477_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_478_Var
		);
		final EList<? extends EObject> Expr_478_list = LogicalOrExpression_478_Var
		.getExpr();
		Assert.assertNotNull(Expr_478_list);
		Assert.assertEquals(1, Expr_478_list.size());
		//478
		final LogicalAndExpression LogicalAndExpression_479_Var
		 = (LogicalAndExpression)Expr_478_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_479_Var
		);
		final EList<? extends EObject> Expr_479_list = LogicalAndExpression_479_Var
		.getExpr();
		Assert.assertNotNull(Expr_479_list);
		Assert.assertEquals(1, Expr_479_list.size());
		//479
		final InclusiveOrExpression InclusiveOrExpression_480_Var
		 = (InclusiveOrExpression)Expr_479_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_480_Var
		);
		final EList<? extends EObject> Expr_480_list = InclusiveOrExpression_480_Var
		.getExpr();
		Assert.assertNotNull(Expr_480_list);
		Assert.assertEquals(1, Expr_480_list.size());
		//480
		final ExclusiveOrExpression ExclusiveOrExpression_481_Var
		 = (ExclusiveOrExpression)Expr_480_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_481_Var
		);
		final EList<? extends EObject> Expr_481_list = ExclusiveOrExpression_481_Var
		.getExpr();
		Assert.assertNotNull(Expr_481_list);
		Assert.assertEquals(1, Expr_481_list.size());
		//481
		final AndExpression AndExpression_482_Var
		 = (AndExpression)Expr_481_list.get(0);
		Assert.assertNotNull(AndExpression_482_Var
		);
		final EList<? extends EObject> Expr_482_list = AndExpression_482_Var
		.getExpr();
		Assert.assertNotNull(Expr_482_list);
		Assert.assertEquals(1, Expr_482_list.size());
		//482
		final EqualityExpression EqualityExpression_483_Var
		 = (EqualityExpression)Expr_482_list.get(0);
		Assert.assertNotNull(EqualityExpression_483_Var
		);
		final EList<? extends EObject> Expr_483_list = EqualityExpression_483_Var
		.getExpr();
		Assert.assertNotNull(Expr_483_list);
		Assert.assertEquals(1, Expr_483_list.size());
		//483
		final RelationalExpression RelationalExpression_484_Var
		 = (RelationalExpression)Expr_483_list.get(0);
		Assert.assertNotNull(RelationalExpression_484_Var
		);
		final EList<? extends EObject> Expr_484_list = RelationalExpression_484_Var
		.getExpr();
		Assert.assertNotNull(Expr_484_list);
		Assert.assertEquals(1, Expr_484_list.size());
		//484
		final ShiftExpression ShiftExpression_485_Var
		 = (ShiftExpression)Expr_484_list.get(0);
		Assert.assertNotNull(ShiftExpression_485_Var
		);
		final EList<? extends EObject> Expr_485_list = ShiftExpression_485_Var
		.getExpr();
		Assert.assertNotNull(Expr_485_list);
		Assert.assertEquals(1, Expr_485_list.size());
		//485
		final AdditiveExpression AdditiveExpression_486_Var
		 = (AdditiveExpression)Expr_485_list.get(0);
		Assert.assertNotNull(AdditiveExpression_486_Var
		);
		final EList<? extends EObject> Expr_486_list = AdditiveExpression_486_Var
		.getExpr();
		Assert.assertNotNull(Expr_486_list);
		Assert.assertEquals(1, Expr_486_list.size());
		//486
		final MultiplicativeExpression MultiplicativeExpression_487_Var
		 = (MultiplicativeExpression)Expr_486_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_487_Var
		);
		final EList<? extends EObject> Expr_487_list = MultiplicativeExpression_487_Var
		.getExpr();
		Assert.assertNotNull(Expr_487_list);
		Assert.assertEquals(1, Expr_487_list.size());
		//487
		final CastExpression CastExpression_488_Var
		 = (CastExpression)Expr_487_list.get(0);
		Assert.assertNotNull(CastExpression_488_Var
		);
		//488
		final UnaryExpression UnaryExpression_489_Var
		 = (UnaryExpression)CastExpression_488_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_489_Var
		);
		//489
		final PostfixExpression PostfixExpression_490_Var
		 = (PostfixExpression)UnaryExpression_489_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_490_Var
		);
		final EList<? extends EObject> Expr_490_list = PostfixExpression_490_Var
		.getExpr();
		Assert.assertNotNull(Expr_490_list);
		Assert.assertEquals(1, Expr_490_list.size());
		//490
		final PrimaryExpression PrimaryExpression_491_Var
		 = (PrimaryExpression)Expr_490_list.get(0);
		Assert.assertNotNull(PrimaryExpression_491_Var
		);
		//491
		final Constant2 Constant2_492_Var
		 = (Constant2)PrimaryExpression_491_Var
		.getConst();
		Assert.assertNotNull(Constant2_492_Var
		);
		Assert.assertEquals("0.56789", Constant2_492_Var
		.getFloat());
		Assert.assertEquals(";", ExpressionStatement_468_Var
		.getSemi());
		//492
		final Statement Statement_493_Var
		 = (Statement)Statement_93_list.get(8);
		Assert.assertNotNull(Statement_493_Var
		);
		//493
		final ExpressionStatement ExpressionStatement_494_Var
		 = (ExpressionStatement)Statement_493_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_494_Var
		);
		//494
		final Expression Expression_495_Var
		 = (Expression)ExpressionStatement_494_Var
		.getExpression();
		Assert.assertNotNull(Expression_495_Var
		);
		final EList<? extends EObject> ExprExpr_495_list = Expression_495_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_495_list);
		Assert.assertEquals(1, ExprExpr_495_list.size());
		//495
		final AssignmentExpression AssignmentExpression_496_Var
		 = (AssignmentExpression)ExprExpr_495_list.get(0);
		Assert.assertNotNull(AssignmentExpression_496_Var
		);
		//496
		final ConditionalExpression ConditionalExpression_497_Var
		 = (ConditionalExpression)AssignmentExpression_496_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_497_Var
		);
		//497
		final LogicalOrExpression LogicalOrExpression_498_Var
		 = (LogicalOrExpression)ConditionalExpression_497_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_498_Var
		);
		final EList<? extends EObject> Expr_498_list = LogicalOrExpression_498_Var
		.getExpr();
		Assert.assertNotNull(Expr_498_list);
		Assert.assertEquals(1, Expr_498_list.size());
		//498
		final LogicalAndExpression LogicalAndExpression_499_Var
		 = (LogicalAndExpression)Expr_498_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_499_Var
		);
		final EList<? extends EObject> Expr_499_list = LogicalAndExpression_499_Var
		.getExpr();
		Assert.assertNotNull(Expr_499_list);
		Assert.assertEquals(1, Expr_499_list.size());
		//499
		final InclusiveOrExpression InclusiveOrExpression_500_Var
		 = (InclusiveOrExpression)Expr_499_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_500_Var
		);
		final EList<? extends EObject> Expr_500_list = InclusiveOrExpression_500_Var
		.getExpr();
		Assert.assertNotNull(Expr_500_list);
		Assert.assertEquals(1, Expr_500_list.size());
		//500
		final ExclusiveOrExpression ExclusiveOrExpression_501_Var
		 = (ExclusiveOrExpression)Expr_500_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_501_Var
		);
		final EList<? extends EObject> Expr_501_list = ExclusiveOrExpression_501_Var
		.getExpr();
		Assert.assertNotNull(Expr_501_list);
		Assert.assertEquals(1, Expr_501_list.size());
		//501
		final AndExpression AndExpression_502_Var
		 = (AndExpression)Expr_501_list.get(0);
		Assert.assertNotNull(AndExpression_502_Var
		);
		final EList<? extends EObject> Expr_502_list = AndExpression_502_Var
		.getExpr();
		Assert.assertNotNull(Expr_502_list);
		Assert.assertEquals(1, Expr_502_list.size());
		//502
		final EqualityExpression EqualityExpression_503_Var
		 = (EqualityExpression)Expr_502_list.get(0);
		Assert.assertNotNull(EqualityExpression_503_Var
		);
		final EList<? extends EObject> Expr_503_list = EqualityExpression_503_Var
		.getExpr();
		Assert.assertNotNull(Expr_503_list);
		Assert.assertEquals(1, Expr_503_list.size());
		//503
		final RelationalExpression RelationalExpression_504_Var
		 = (RelationalExpression)Expr_503_list.get(0);
		Assert.assertNotNull(RelationalExpression_504_Var
		);
		final EList<? extends EObject> Expr_504_list = RelationalExpression_504_Var
		.getExpr();
		Assert.assertNotNull(Expr_504_list);
		Assert.assertEquals(1, Expr_504_list.size());
		//504
		final ShiftExpression ShiftExpression_505_Var
		 = (ShiftExpression)Expr_504_list.get(0);
		Assert.assertNotNull(ShiftExpression_505_Var
		);
		final EList<? extends EObject> Expr_505_list = ShiftExpression_505_Var
		.getExpr();
		Assert.assertNotNull(Expr_505_list);
		Assert.assertEquals(1, Expr_505_list.size());
		//505
		final AdditiveExpression AdditiveExpression_506_Var
		 = (AdditiveExpression)Expr_505_list.get(0);
		Assert.assertNotNull(AdditiveExpression_506_Var
		);
		final EList<? extends EObject> Expr_506_list = AdditiveExpression_506_Var
		.getExpr();
		Assert.assertNotNull(Expr_506_list);
		Assert.assertEquals(1, Expr_506_list.size());
		//506
		final MultiplicativeExpression MultiplicativeExpression_507_Var
		 = (MultiplicativeExpression)Expr_506_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_507_Var
		);
		final EList<? extends EObject> Expr_507_list = MultiplicativeExpression_507_Var
		.getExpr();
		Assert.assertNotNull(Expr_507_list);
		Assert.assertEquals(1, Expr_507_list.size());
		//507
		final CastExpression CastExpression_508_Var
		 = (CastExpression)Expr_507_list.get(0);
		Assert.assertNotNull(CastExpression_508_Var
		);
		//508
		final UnaryExpression UnaryExpression_509_Var
		 = (UnaryExpression)CastExpression_508_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_509_Var
		);
		//509
		final PostfixExpression PostfixExpression_510_Var
		 = (PostfixExpression)UnaryExpression_509_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_510_Var
		);
		final EList<? extends EObject> Expr_510_list = PostfixExpression_510_Var
		.getExpr();
		Assert.assertNotNull(Expr_510_list);
		Assert.assertEquals(1, Expr_510_list.size());
		//510
		final PrimaryExpression PrimaryExpression_511_Var
		 = (PrimaryExpression)Expr_510_list.get(0);
		Assert.assertNotNull(PrimaryExpression_511_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_511_Var
		.getId());
		final EList<? extends EObject> Suffix_511_list = PostfixExpression_510_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_511_list);
		Assert.assertEquals(1, Suffix_511_list.size());
		//511
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_512_Var
		 = (PostfixExpressionSuffixArgument)Suffix_511_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_512_Var
		);
		//512
		final ArgumentExpressionList ArgumentExpressionList_513_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_512_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_513_Var
		);
		final EList<? extends EObject> Expr_513_list = ArgumentExpressionList_513_Var
		.getExpr();
		Assert.assertNotNull(Expr_513_list);
		Assert.assertEquals(2, Expr_513_list.size());
		//513
		final AssignmentExpression AssignmentExpression_514_Var
		 = (AssignmentExpression)Expr_513_list.get(0);
		Assert.assertNotNull(AssignmentExpression_514_Var
		);
		//514
		final ConditionalExpression ConditionalExpression_515_Var
		 = (ConditionalExpression)AssignmentExpression_514_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_515_Var
		);
		//515
		final LogicalOrExpression LogicalOrExpression_516_Var
		 = (LogicalOrExpression)ConditionalExpression_515_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_516_Var
		);
		final EList<? extends EObject> Expr_516_list = LogicalOrExpression_516_Var
		.getExpr();
		Assert.assertNotNull(Expr_516_list);
		Assert.assertEquals(1, Expr_516_list.size());
		//516
		final LogicalAndExpression LogicalAndExpression_517_Var
		 = (LogicalAndExpression)Expr_516_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_517_Var
		);
		final EList<? extends EObject> Expr_517_list = LogicalAndExpression_517_Var
		.getExpr();
		Assert.assertNotNull(Expr_517_list);
		Assert.assertEquals(1, Expr_517_list.size());
		//517
		final InclusiveOrExpression InclusiveOrExpression_518_Var
		 = (InclusiveOrExpression)Expr_517_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_518_Var
		);
		final EList<? extends EObject> Expr_518_list = InclusiveOrExpression_518_Var
		.getExpr();
		Assert.assertNotNull(Expr_518_list);
		Assert.assertEquals(1, Expr_518_list.size());
		//518
		final ExclusiveOrExpression ExclusiveOrExpression_519_Var
		 = (ExclusiveOrExpression)Expr_518_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_519_Var
		);
		final EList<? extends EObject> Expr_519_list = ExclusiveOrExpression_519_Var
		.getExpr();
		Assert.assertNotNull(Expr_519_list);
		Assert.assertEquals(1, Expr_519_list.size());
		//519
		final AndExpression AndExpression_520_Var
		 = (AndExpression)Expr_519_list.get(0);
		Assert.assertNotNull(AndExpression_520_Var
		);
		final EList<? extends EObject> Expr_520_list = AndExpression_520_Var
		.getExpr();
		Assert.assertNotNull(Expr_520_list);
		Assert.assertEquals(1, Expr_520_list.size());
		//520
		final EqualityExpression EqualityExpression_521_Var
		 = (EqualityExpression)Expr_520_list.get(0);
		Assert.assertNotNull(EqualityExpression_521_Var
		);
		final EList<? extends EObject> Expr_521_list = EqualityExpression_521_Var
		.getExpr();
		Assert.assertNotNull(Expr_521_list);
		Assert.assertEquals(1, Expr_521_list.size());
		//521
		final RelationalExpression RelationalExpression_522_Var
		 = (RelationalExpression)Expr_521_list.get(0);
		Assert.assertNotNull(RelationalExpression_522_Var
		);
		final EList<? extends EObject> Expr_522_list = RelationalExpression_522_Var
		.getExpr();
		Assert.assertNotNull(Expr_522_list);
		Assert.assertEquals(1, Expr_522_list.size());
		//522
		final ShiftExpression ShiftExpression_523_Var
		 = (ShiftExpression)Expr_522_list.get(0);
		Assert.assertNotNull(ShiftExpression_523_Var
		);
		final EList<? extends EObject> Expr_523_list = ShiftExpression_523_Var
		.getExpr();
		Assert.assertNotNull(Expr_523_list);
		Assert.assertEquals(1, Expr_523_list.size());
		//523
		final AdditiveExpression AdditiveExpression_524_Var
		 = (AdditiveExpression)Expr_523_list.get(0);
		Assert.assertNotNull(AdditiveExpression_524_Var
		);
		final EList<? extends EObject> Expr_524_list = AdditiveExpression_524_Var
		.getExpr();
		Assert.assertNotNull(Expr_524_list);
		Assert.assertEquals(1, Expr_524_list.size());
		//524
		final MultiplicativeExpression MultiplicativeExpression_525_Var
		 = (MultiplicativeExpression)Expr_524_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_525_Var
		);
		final EList<? extends EObject> Expr_525_list = MultiplicativeExpression_525_Var
		.getExpr();
		Assert.assertNotNull(Expr_525_list);
		Assert.assertEquals(1, Expr_525_list.size());
		//525
		final CastExpression CastExpression_526_Var
		 = (CastExpression)Expr_525_list.get(0);
		Assert.assertNotNull(CastExpression_526_Var
		);
		//526
		final UnaryExpression UnaryExpression_527_Var
		 = (UnaryExpression)CastExpression_526_Var
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
		//529
		final Constant2 Constant2_530_Var
		 = (Constant2)PrimaryExpression_529_Var
		.getConst();
		Assert.assertNotNull(Constant2_530_Var
		);
		Assert.assertEquals("\"number.numChar(as decimal)=%d\\n\"", Constant2_530_Var
		.getStr());
		//530
		final AssignmentExpression AssignmentExpression_531_Var
		 = (AssignmentExpression)Expr_513_list.get(1);
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
		Assert.assertEquals("number", PrimaryExpression_546_Var
		.getId());
		final EList<? extends EObject> Suffix_546_list = PostfixExpression_545_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_546_list);
		Assert.assertEquals(1, Suffix_546_list.size());
		//546
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_547_Var
		 = (PostfixExpressionSuffixDot)Suffix_546_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_547_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_547_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_494_Var
		.getSemi());
		//547
		final Statement Statement_548_Var
		 = (Statement)Statement_93_list.get(9);
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
		Assert.assertEquals("printf", PrimaryExpression_566_Var
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
		//584
		final Constant2 Constant2_585_Var
		 = (Constant2)PrimaryExpression_584_Var
		.getConst();
		Assert.assertNotNull(Constant2_585_Var
		);
		Assert.assertEquals("\"number.numFloat=%f\\n\"", Constant2_585_Var
		.getStr());
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
		Assert.assertEquals("number", PrimaryExpression_601_Var
		.getId());
		final EList<? extends EObject> Suffix_601_list = PostfixExpression_600_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_601_list);
		Assert.assertEquals(1, Suffix_601_list.size());
		//601
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_602_Var
		 = (PostfixExpressionSuffixDot)Suffix_601_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_602_Var
		);
		Assert.assertEquals("numFloat", PostfixExpressionSuffixDot_602_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_549_Var
		.getSemi());
		//602
		final Statement Statement_603_Var
		 = (Statement)Statement_93_list.get(10);
		Assert.assertNotNull(Statement_603_Var
		);
		//603
		final JumpStatement JumpStatement_604_Var
		 = (JumpStatement)Statement_603_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_604_Var
		);
		//604
		final Expression Expression_605_Var
		 = (Expression)JumpStatement_604_Var
		.getExpr();
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
		//621
		final Constant2 Constant2_622_Var
		 = (Constant2)PrimaryExpression_621_Var
		.getConst();
		Assert.assertNotNull(Constant2_622_Var
		);
		Assert.assertEquals("0", Constant2_622_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_604_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_604_Var
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


