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
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
	
	@Test (timeout=1000)
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
	
	@Test (timeout=1000)
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
		Assert.assertEquals("union", StructOrUnion_6_Var
		.getName());
		Assert.assertEquals("num", StructOrUnionSpecifier_5_Var
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
		Assert.assertEquals("char", TypeSpecifier_10_Var
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
		Assert.assertEquals("numChar", DirectDeclarator_14_Var
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
		Assert.assertEquals("float", TypeSpecifier_17_Var
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
		Assert.assertEquals("numFloat", DirectDeclarator_21_Var
		.getId());
		//21
		final ExternalDeclaration ExternalDeclaration_22_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_22_Var
		);
		//22
		final Declaration Declaration_23_Var
		 = (Declaration)ExternalDeclaration_22_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_23_Var
		);
		//23
		final DeclarationSpecifiers DeclarationSpecifiers_24_Var
		 = (DeclarationSpecifiers)Declaration_23_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_24_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_24_list = DeclarationSpecifiers_24_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_24_list);
		Assert.assertEquals(1, DeclarationSpecifier_24_list.size());
		//24
		final TypeSpecifier TypeSpecifier_25_Var
		 = (TypeSpecifier)DeclarationSpecifier_24_list.get(0);
		Assert.assertNotNull(TypeSpecifier_25_Var
		);
		//25
		final StructOrUnionSpecifier StructOrUnionSpecifier_26_Var
		 = (StructOrUnionSpecifier)TypeSpecifier_25_Var
		.getSpecifier();
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
		final EList<? extends EObject> InitDeclaratorList_27_list = Declaration_23_Var
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
		 = (ExternalDeclaration)External_0_list.get(2);
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
		Assert.assertEquals("[\"sizeof(number)=%lu\\n\"]", PrimaryExpression_132_Var
		.getString().toString());
		//132
		final AssignmentExpression AssignmentExpression_133_Var
		 = (AssignmentExpression)Expr_116_list.get(1);
		Assert.assertNotNull(AssignmentExpression_133_Var
		);
		//133
		final ConditionalExpression ConditionalExpression_134_Var
		 = (ConditionalExpression)AssignmentExpression_133_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_134_Var
		);
		//134
		final LogicalOrExpression LogicalOrExpression_135_Var
		 = (LogicalOrExpression)ConditionalExpression_134_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = LogicalOrExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final LogicalAndExpression LogicalAndExpression_136_Var
		 = (LogicalAndExpression)Expr_135_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = LogicalAndExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final InclusiveOrExpression InclusiveOrExpression_137_Var
		 = (InclusiveOrExpression)Expr_136_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = InclusiveOrExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final ExclusiveOrExpression ExclusiveOrExpression_138_Var
		 = (ExclusiveOrExpression)Expr_137_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = ExclusiveOrExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final AndExpression AndExpression_139_Var
		 = (AndExpression)Expr_138_list.get(0);
		Assert.assertNotNull(AndExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = AndExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final EqualityExpression EqualityExpression_140_Var
		 = (EqualityExpression)Expr_139_list.get(0);
		Assert.assertNotNull(EqualityExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = EqualityExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final RelationalExpression RelationalExpression_141_Var
		 = (RelationalExpression)Expr_140_list.get(0);
		Assert.assertNotNull(RelationalExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = RelationalExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final ShiftExpression ShiftExpression_142_Var
		 = (ShiftExpression)Expr_141_list.get(0);
		Assert.assertNotNull(ShiftExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = ShiftExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final AdditiveExpression AdditiveExpression_143_Var
		 = (AdditiveExpression)Expr_142_list.get(0);
		Assert.assertNotNull(AdditiveExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = AdditiveExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final MultiplicativeExpression MultiplicativeExpression_144_Var
		 = (MultiplicativeExpression)Expr_143_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = MultiplicativeExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final CastExpression CastExpression_145_Var
		 = (CastExpression)Expr_144_list.get(0);
		Assert.assertNotNull(CastExpression_145_Var
		);
		//145
		final UnaryExpression UnaryExpression_146_Var
		 = (UnaryExpression)CastExpression_145_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_146_Var
		);
		//146
		final PostfixExpression PostfixExpression_147_Var
		 = (PostfixExpression)UnaryExpression_146_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_147_Var
		);
		final EList<? extends EObject> Expr_147_list = PostfixExpression_147_Var
		.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(1, Expr_147_list.size());
		//147
		final PrimaryExpression PrimaryExpression_148_Var
		 = (PrimaryExpression)Expr_147_list.get(0);
		Assert.assertNotNull(PrimaryExpression_148_Var
		);
		Assert.assertEquals("size", PrimaryExpression_148_Var
		.getId());
		//148
		final Statement Statement_149_Var
		 = (Statement)Statement_95_list.get(1);
		Assert.assertNotNull(Statement_149_Var
		);
		//149
		final ExpressionStatement ExpressionStatement_150_Var
		 = (ExpressionStatement)Statement_149_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_150_Var
		);
		//150
		final Expression Expression_151_Var
		 = (Expression)ExpressionStatement_150_Var
		.getExpression();
		Assert.assertNotNull(Expression_151_Var
		);
		final EList<? extends EObject> ExprExpr_151_list = Expression_151_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_151_list);
		Assert.assertEquals(1, ExprExpr_151_list.size());
		//151
		final AssignmentExpression AssignmentExpression_152_Var
		 = (AssignmentExpression)ExprExpr_151_list.get(0);
		Assert.assertNotNull(AssignmentExpression_152_Var
		);
		//152
		final ConditionalExpression ConditionalExpression_153_Var
		 = (ConditionalExpression)AssignmentExpression_152_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_153_Var
		);
		//153
		final LogicalOrExpression LogicalOrExpression_154_Var
		 = (LogicalOrExpression)ConditionalExpression_153_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_154_Var
		);
		final EList<? extends EObject> Expr_154_list = LogicalOrExpression_154_Var
		.getExpr();
		Assert.assertNotNull(Expr_154_list);
		Assert.assertEquals(1, Expr_154_list.size());
		//154
		final LogicalAndExpression LogicalAndExpression_155_Var
		 = (LogicalAndExpression)Expr_154_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_155_Var
		);
		final EList<? extends EObject> Expr_155_list = LogicalAndExpression_155_Var
		.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		//155
		final InclusiveOrExpression InclusiveOrExpression_156_Var
		 = (InclusiveOrExpression)Expr_155_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_156_Var
		);
		final EList<? extends EObject> Expr_156_list = InclusiveOrExpression_156_Var
		.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		//156
		final ExclusiveOrExpression ExclusiveOrExpression_157_Var
		 = (ExclusiveOrExpression)Expr_156_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = ExclusiveOrExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final AndExpression AndExpression_158_Var
		 = (AndExpression)Expr_157_list.get(0);
		Assert.assertNotNull(AndExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = AndExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final EqualityExpression EqualityExpression_159_Var
		 = (EqualityExpression)Expr_158_list.get(0);
		Assert.assertNotNull(EqualityExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = EqualityExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final RelationalExpression RelationalExpression_160_Var
		 = (RelationalExpression)Expr_159_list.get(0);
		Assert.assertNotNull(RelationalExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = RelationalExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final ShiftExpression ShiftExpression_161_Var
		 = (ShiftExpression)Expr_160_list.get(0);
		Assert.assertNotNull(ShiftExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = ShiftExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final AdditiveExpression AdditiveExpression_162_Var
		 = (AdditiveExpression)Expr_161_list.get(0);
		Assert.assertNotNull(AdditiveExpression_162_Var
		);
		final EList<? extends EObject> Expr_162_list = AdditiveExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		//162
		final MultiplicativeExpression MultiplicativeExpression_163_Var
		 = (MultiplicativeExpression)Expr_162_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_163_Var
		);
		final EList<? extends EObject> Expr_163_list = MultiplicativeExpression_163_Var
		.getExpr();
		Assert.assertNotNull(Expr_163_list);
		Assert.assertEquals(1, Expr_163_list.size());
		//163
		final CastExpression CastExpression_164_Var
		 = (CastExpression)Expr_163_list.get(0);
		Assert.assertNotNull(CastExpression_164_Var
		);
		//164
		final UnaryExpression UnaryExpression_165_Var
		 = (UnaryExpression)CastExpression_164_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_165_Var
		);
		//165
		final PostfixExpression PostfixExpression_166_Var
		 = (PostfixExpression)UnaryExpression_165_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_166_Var
		);
		final EList<? extends EObject> Expr_166_list = PostfixExpression_166_Var
		.getExpr();
		Assert.assertNotNull(Expr_166_list);
		Assert.assertEquals(1, Expr_166_list.size());
		//166
		final PrimaryExpression PrimaryExpression_167_Var
		 = (PrimaryExpression)Expr_166_list.get(0);
		Assert.assertNotNull(PrimaryExpression_167_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_167_Var
		.getId());
		final EList<? extends EObject> Suffix_167_list = PostfixExpression_166_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_167_list);
		Assert.assertEquals(1, Suffix_167_list.size());
		//167
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_168_Var
		 = (PostfixExpressionSuffixArgument)Suffix_167_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_168_Var
		);
		//168
		final ArgumentExpressionList ArgumentExpressionList_169_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_168_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_169_Var
		);
		final EList<? extends EObject> Expr_169_list = ArgumentExpressionList_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(2, Expr_169_list.size());
		//169
		final AssignmentExpression AssignmentExpression_170_Var
		 = (AssignmentExpression)Expr_169_list.get(0);
		Assert.assertNotNull(AssignmentExpression_170_Var
		);
		//170
		final ConditionalExpression ConditionalExpression_171_Var
		 = (ConditionalExpression)AssignmentExpression_170_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_171_Var
		);
		//171
		final LogicalOrExpression LogicalOrExpression_172_Var
		 = (LogicalOrExpression)ConditionalExpression_171_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = LogicalOrExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final LogicalAndExpression LogicalAndExpression_173_Var
		 = (LogicalAndExpression)Expr_172_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = LogicalAndExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final InclusiveOrExpression InclusiveOrExpression_174_Var
		 = (InclusiveOrExpression)Expr_173_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = InclusiveOrExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final ExclusiveOrExpression ExclusiveOrExpression_175_Var
		 = (ExclusiveOrExpression)Expr_174_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = ExclusiveOrExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final AndExpression AndExpression_176_Var
		 = (AndExpression)Expr_175_list.get(0);
		Assert.assertNotNull(AndExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = AndExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final EqualityExpression EqualityExpression_177_Var
		 = (EqualityExpression)Expr_176_list.get(0);
		Assert.assertNotNull(EqualityExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = EqualityExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final RelationalExpression RelationalExpression_178_Var
		 = (RelationalExpression)Expr_177_list.get(0);
		Assert.assertNotNull(RelationalExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = RelationalExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final ShiftExpression ShiftExpression_179_Var
		 = (ShiftExpression)Expr_178_list.get(0);
		Assert.assertNotNull(ShiftExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = ShiftExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final AdditiveExpression AdditiveExpression_180_Var
		 = (AdditiveExpression)Expr_179_list.get(0);
		Assert.assertNotNull(AdditiveExpression_180_Var
		);
		final EList<? extends EObject> Expr_180_list = AdditiveExpression_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final MultiplicativeExpression MultiplicativeExpression_181_Var
		 = (MultiplicativeExpression)Expr_180_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_181_Var
		);
		final EList<? extends EObject> Expr_181_list = MultiplicativeExpression_181_Var
		.getExpr();
		Assert.assertNotNull(Expr_181_list);
		Assert.assertEquals(1, Expr_181_list.size());
		//181
		final CastExpression CastExpression_182_Var
		 = (CastExpression)Expr_181_list.get(0);
		Assert.assertNotNull(CastExpression_182_Var
		);
		//182
		final UnaryExpression UnaryExpression_183_Var
		 = (UnaryExpression)CastExpression_182_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_183_Var
		);
		//183
		final PostfixExpression PostfixExpression_184_Var
		 = (PostfixExpression)UnaryExpression_183_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = PostfixExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final PrimaryExpression PrimaryExpression_185_Var
		 = (PrimaryExpression)Expr_184_list.get(0);
		Assert.assertNotNull(PrimaryExpression_185_Var
		);
		Assert.assertEquals("[\"sizeof(number.numChar)=%lu\\n\"]", PrimaryExpression_185_Var
		.getString().toString());
		//185
		final AssignmentExpression AssignmentExpression_186_Var
		 = (AssignmentExpression)Expr_169_list.get(1);
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
		//220
		final Statement Statement_221_Var
		 = (Statement)Statement_95_list.get(2);
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
		Assert.assertEquals("[\"sizeof(float)=%lu\\n\"]", PrimaryExpression_257_Var
		.getString().toString());
		//257
		final AssignmentExpression AssignmentExpression_258_Var
		 = (AssignmentExpression)Expr_241_list.get(1);
		Assert.assertNotNull(AssignmentExpression_258_Var
		);
		//258
		final ConditionalExpression ConditionalExpression_259_Var
		 = (ConditionalExpression)AssignmentExpression_258_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_259_Var
		);
		//259
		final LogicalOrExpression LogicalOrExpression_260_Var
		 = (LogicalOrExpression)ConditionalExpression_259_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = LogicalOrExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final LogicalAndExpression LogicalAndExpression_261_Var
		 = (LogicalAndExpression)Expr_260_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = LogicalAndExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final InclusiveOrExpression InclusiveOrExpression_262_Var
		 = (InclusiveOrExpression)Expr_261_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_262_Var
		);
		final EList<? extends EObject> Expr_262_list = InclusiveOrExpression_262_Var
		.getExpr();
		Assert.assertNotNull(Expr_262_list);
		Assert.assertEquals(1, Expr_262_list.size());
		//262
		final ExclusiveOrExpression ExclusiveOrExpression_263_Var
		 = (ExclusiveOrExpression)Expr_262_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_263_Var
		);
		final EList<? extends EObject> Expr_263_list = ExclusiveOrExpression_263_Var
		.getExpr();
		Assert.assertNotNull(Expr_263_list);
		Assert.assertEquals(1, Expr_263_list.size());
		//263
		final AndExpression AndExpression_264_Var
		 = (AndExpression)Expr_263_list.get(0);
		Assert.assertNotNull(AndExpression_264_Var
		);
		final EList<? extends EObject> Expr_264_list = AndExpression_264_Var
		.getExpr();
		Assert.assertNotNull(Expr_264_list);
		Assert.assertEquals(1, Expr_264_list.size());
		//264
		final EqualityExpression EqualityExpression_265_Var
		 = (EqualityExpression)Expr_264_list.get(0);
		Assert.assertNotNull(EqualityExpression_265_Var
		);
		final EList<? extends EObject> Expr_265_list = EqualityExpression_265_Var
		.getExpr();
		Assert.assertNotNull(Expr_265_list);
		Assert.assertEquals(1, Expr_265_list.size());
		//265
		final RelationalExpression RelationalExpression_266_Var
		 = (RelationalExpression)Expr_265_list.get(0);
		Assert.assertNotNull(RelationalExpression_266_Var
		);
		final EList<? extends EObject> Expr_266_list = RelationalExpression_266_Var
		.getExpr();
		Assert.assertNotNull(Expr_266_list);
		Assert.assertEquals(1, Expr_266_list.size());
		//266
		final ShiftExpression ShiftExpression_267_Var
		 = (ShiftExpression)Expr_266_list.get(0);
		Assert.assertNotNull(ShiftExpression_267_Var
		);
		final EList<? extends EObject> Expr_267_list = ShiftExpression_267_Var
		.getExpr();
		Assert.assertNotNull(Expr_267_list);
		Assert.assertEquals(1, Expr_267_list.size());
		//267
		final AdditiveExpression AdditiveExpression_268_Var
		 = (AdditiveExpression)Expr_267_list.get(0);
		Assert.assertNotNull(AdditiveExpression_268_Var
		);
		final EList<? extends EObject> Expr_268_list = AdditiveExpression_268_Var
		.getExpr();
		Assert.assertNotNull(Expr_268_list);
		Assert.assertEquals(1, Expr_268_list.size());
		//268
		final MultiplicativeExpression MultiplicativeExpression_269_Var
		 = (MultiplicativeExpression)Expr_268_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_269_Var
		);
		final EList<? extends EObject> Expr_269_list = MultiplicativeExpression_269_Var
		.getExpr();
		Assert.assertNotNull(Expr_269_list);
		Assert.assertEquals(1, Expr_269_list.size());
		//269
		final CastExpression CastExpression_270_Var
		 = (CastExpression)Expr_269_list.get(0);
		Assert.assertNotNull(CastExpression_270_Var
		);
		//270
		final UnaryExpression UnaryExpression_271_Var
		 = (UnaryExpression)CastExpression_270_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_271_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_271_Var
		.getSizeOf());
		//271
		final TypeName TypeName_272_Var
		 = (TypeName)UnaryExpression_271_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_272_Var
		);
		//272
		final SpecifierQualifierList SpecifierQualifierList_273_Var
		 = (SpecifierQualifierList)TypeName_272_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_273_Var
		);
		final EList<? extends EObject> TypeSpecifier_273_list = SpecifierQualifierList_273_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_273_list);
		Assert.assertEquals(1, TypeSpecifier_273_list.size());
		//273
		final TypeSpecifier TypeSpecifier_274_Var
		 = (TypeSpecifier)TypeSpecifier_273_list.get(0);
		Assert.assertNotNull(TypeSpecifier_274_Var
		);
		Assert.assertEquals("float", TypeSpecifier_274_Var
		.getName());
		//274
		final Statement Statement_275_Var
		 = (Statement)Statement_95_list.get(3);
		Assert.assertNotNull(Statement_275_Var
		);
		//275
		final ExpressionStatement ExpressionStatement_276_Var
		 = (ExpressionStatement)Statement_275_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_276_Var
		);
		//276
		final Expression Expression_277_Var
		 = (Expression)ExpressionStatement_276_Var
		.getExpression();
		Assert.assertNotNull(Expression_277_Var
		);
		final EList<? extends EObject> ExprExpr_277_list = Expression_277_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_277_list);
		Assert.assertEquals(1, ExprExpr_277_list.size());
		//277
		final AssignmentExpression AssignmentExpression_278_Var
		 = (AssignmentExpression)ExprExpr_277_list.get(0);
		Assert.assertNotNull(AssignmentExpression_278_Var
		);
		//278
		final UnaryExpression UnaryExpression_279_Var
		 = (UnaryExpression)AssignmentExpression_278_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_279_Var
		);
		//279
		final PostfixExpression PostfixExpression_280_Var
		 = (PostfixExpression)UnaryExpression_279_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_280_Var
		);
		final EList<? extends EObject> Expr_280_list = PostfixExpression_280_Var
		.getExpr();
		Assert.assertNotNull(Expr_280_list);
		Assert.assertEquals(1, Expr_280_list.size());
		//280
		final PrimaryExpression PrimaryExpression_281_Var
		 = (PrimaryExpression)Expr_280_list.get(0);
		Assert.assertNotNull(PrimaryExpression_281_Var
		);
		Assert.assertEquals("number", PrimaryExpression_281_Var
		.getId());
		final EList<? extends EObject> Suffix_281_list = PostfixExpression_280_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_281_list);
		Assert.assertEquals(1, Suffix_281_list.size());
		//281
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_282_Var
		 = (PostfixExpressionSuffixDot)Suffix_281_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_282_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_282_Var
		.getId());
		//282
		final AssignmentOperator AssignmentOperator_283_Var
		 = (AssignmentOperator)AssignmentExpression_278_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_283_Var
		);
		Assert.assertEquals("=", AssignmentOperator_283_Var
		.getOp());
		//283
		final AssignmentExpression AssignmentExpression_284_Var
		 = (AssignmentExpression)AssignmentExpression_278_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_284_Var
		);
		//284
		final ConditionalExpression ConditionalExpression_285_Var
		 = (ConditionalExpression)AssignmentExpression_284_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_285_Var
		);
		//285
		final LogicalOrExpression LogicalOrExpression_286_Var
		 = (LogicalOrExpression)ConditionalExpression_285_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_286_Var
		);
		final EList<? extends EObject> Expr_286_list = LogicalOrExpression_286_Var
		.getExpr();
		Assert.assertNotNull(Expr_286_list);
		Assert.assertEquals(1, Expr_286_list.size());
		//286
		final LogicalAndExpression LogicalAndExpression_287_Var
		 = (LogicalAndExpression)Expr_286_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_287_Var
		);
		final EList<? extends EObject> Expr_287_list = LogicalAndExpression_287_Var
		.getExpr();
		Assert.assertNotNull(Expr_287_list);
		Assert.assertEquals(1, Expr_287_list.size());
		//287
		final InclusiveOrExpression InclusiveOrExpression_288_Var
		 = (InclusiveOrExpression)Expr_287_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_288_Var
		);
		final EList<? extends EObject> Expr_288_list = InclusiveOrExpression_288_Var
		.getExpr();
		Assert.assertNotNull(Expr_288_list);
		Assert.assertEquals(1, Expr_288_list.size());
		//288
		final ExclusiveOrExpression ExclusiveOrExpression_289_Var
		 = (ExclusiveOrExpression)Expr_288_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_289_Var
		);
		final EList<? extends EObject> Expr_289_list = ExclusiveOrExpression_289_Var
		.getExpr();
		Assert.assertNotNull(Expr_289_list);
		Assert.assertEquals(1, Expr_289_list.size());
		//289
		final AndExpression AndExpression_290_Var
		 = (AndExpression)Expr_289_list.get(0);
		Assert.assertNotNull(AndExpression_290_Var
		);
		final EList<? extends EObject> Expr_290_list = AndExpression_290_Var
		.getExpr();
		Assert.assertNotNull(Expr_290_list);
		Assert.assertEquals(1, Expr_290_list.size());
		//290
		final EqualityExpression EqualityExpression_291_Var
		 = (EqualityExpression)Expr_290_list.get(0);
		Assert.assertNotNull(EqualityExpression_291_Var
		);
		final EList<? extends EObject> Expr_291_list = EqualityExpression_291_Var
		.getExpr();
		Assert.assertNotNull(Expr_291_list);
		Assert.assertEquals(1, Expr_291_list.size());
		//291
		final RelationalExpression RelationalExpression_292_Var
		 = (RelationalExpression)Expr_291_list.get(0);
		Assert.assertNotNull(RelationalExpression_292_Var
		);
		final EList<? extends EObject> Expr_292_list = RelationalExpression_292_Var
		.getExpr();
		Assert.assertNotNull(Expr_292_list);
		Assert.assertEquals(1, Expr_292_list.size());
		//292
		final ShiftExpression ShiftExpression_293_Var
		 = (ShiftExpression)Expr_292_list.get(0);
		Assert.assertNotNull(ShiftExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = ShiftExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final AdditiveExpression AdditiveExpression_294_Var
		 = (AdditiveExpression)Expr_293_list.get(0);
		Assert.assertNotNull(AdditiveExpression_294_Var
		);
		final EList<? extends EObject> Expr_294_list = AdditiveExpression_294_Var
		.getExpr();
		Assert.assertNotNull(Expr_294_list);
		Assert.assertEquals(1, Expr_294_list.size());
		//294
		final MultiplicativeExpression MultiplicativeExpression_295_Var
		 = (MultiplicativeExpression)Expr_294_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_295_Var
		);
		final EList<? extends EObject> Expr_295_list = MultiplicativeExpression_295_Var
		.getExpr();
		Assert.assertNotNull(Expr_295_list);
		Assert.assertEquals(1, Expr_295_list.size());
		//295
		final CastExpression CastExpression_296_Var
		 = (CastExpression)Expr_295_list.get(0);
		Assert.assertNotNull(CastExpression_296_Var
		);
		//296
		final UnaryExpression UnaryExpression_297_Var
		 = (UnaryExpression)CastExpression_296_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_297_Var
		);
		//297
		final PostfixExpression PostfixExpression_298_Var
		 = (PostfixExpression)UnaryExpression_297_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_298_Var
		);
		final EList<? extends EObject> Expr_298_list = PostfixExpression_298_Var
		.getExpr();
		Assert.assertNotNull(Expr_298_list);
		Assert.assertEquals(1, Expr_298_list.size());
		//298
		final PrimaryExpression PrimaryExpression_299_Var
		 = (PrimaryExpression)Expr_298_list.get(0);
		Assert.assertNotNull(PrimaryExpression_299_Var
		);
		//299
		final Constant2 Constant2_300_Var
		 = (Constant2)PrimaryExpression_299_Var
		.getConst();
		Assert.assertNotNull(Constant2_300_Var
		);
		Assert.assertEquals("65", Constant2_300_Var
		.getDec());
		//300
		final Statement Statement_301_Var
		 = (Statement)Statement_95_list.get(4);
		Assert.assertNotNull(Statement_301_Var
		);
		//301
		final ExpressionStatement ExpressionStatement_302_Var
		 = (ExpressionStatement)Statement_301_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_302_Var
		);
		//302
		final Expression Expression_303_Var
		 = (Expression)ExpressionStatement_302_Var
		.getExpression();
		Assert.assertNotNull(Expression_303_Var
		);
		final EList<? extends EObject> ExprExpr_303_list = Expression_303_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_303_list);
		Assert.assertEquals(1, ExprExpr_303_list.size());
		//303
		final AssignmentExpression AssignmentExpression_304_Var
		 = (AssignmentExpression)ExprExpr_303_list.get(0);
		Assert.assertNotNull(AssignmentExpression_304_Var
		);
		//304
		final ConditionalExpression ConditionalExpression_305_Var
		 = (ConditionalExpression)AssignmentExpression_304_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_305_Var
		);
		//305
		final LogicalOrExpression LogicalOrExpression_306_Var
		 = (LogicalOrExpression)ConditionalExpression_305_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_306_Var
		);
		final EList<? extends EObject> Expr_306_list = LogicalOrExpression_306_Var
		.getExpr();
		Assert.assertNotNull(Expr_306_list);
		Assert.assertEquals(1, Expr_306_list.size());
		//306
		final LogicalAndExpression LogicalAndExpression_307_Var
		 = (LogicalAndExpression)Expr_306_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_307_Var
		);
		final EList<? extends EObject> Expr_307_list = LogicalAndExpression_307_Var
		.getExpr();
		Assert.assertNotNull(Expr_307_list);
		Assert.assertEquals(1, Expr_307_list.size());
		//307
		final InclusiveOrExpression InclusiveOrExpression_308_Var
		 = (InclusiveOrExpression)Expr_307_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_308_Var
		);
		final EList<? extends EObject> Expr_308_list = InclusiveOrExpression_308_Var
		.getExpr();
		Assert.assertNotNull(Expr_308_list);
		Assert.assertEquals(1, Expr_308_list.size());
		//308
		final ExclusiveOrExpression ExclusiveOrExpression_309_Var
		 = (ExclusiveOrExpression)Expr_308_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_309_Var
		);
		final EList<? extends EObject> Expr_309_list = ExclusiveOrExpression_309_Var
		.getExpr();
		Assert.assertNotNull(Expr_309_list);
		Assert.assertEquals(1, Expr_309_list.size());
		//309
		final AndExpression AndExpression_310_Var
		 = (AndExpression)Expr_309_list.get(0);
		Assert.assertNotNull(AndExpression_310_Var
		);
		final EList<? extends EObject> Expr_310_list = AndExpression_310_Var
		.getExpr();
		Assert.assertNotNull(Expr_310_list);
		Assert.assertEquals(1, Expr_310_list.size());
		//310
		final EqualityExpression EqualityExpression_311_Var
		 = (EqualityExpression)Expr_310_list.get(0);
		Assert.assertNotNull(EqualityExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = EqualityExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final RelationalExpression RelationalExpression_312_Var
		 = (RelationalExpression)Expr_311_list.get(0);
		Assert.assertNotNull(RelationalExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = RelationalExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final ShiftExpression ShiftExpression_313_Var
		 = (ShiftExpression)Expr_312_list.get(0);
		Assert.assertNotNull(ShiftExpression_313_Var
		);
		final EList<? extends EObject> Expr_313_list = ShiftExpression_313_Var
		.getExpr();
		Assert.assertNotNull(Expr_313_list);
		Assert.assertEquals(1, Expr_313_list.size());
		//313
		final AdditiveExpression AdditiveExpression_314_Var
		 = (AdditiveExpression)Expr_313_list.get(0);
		Assert.assertNotNull(AdditiveExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = AdditiveExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final MultiplicativeExpression MultiplicativeExpression_315_Var
		 = (MultiplicativeExpression)Expr_314_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = MultiplicativeExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final CastExpression CastExpression_316_Var
		 = (CastExpression)Expr_315_list.get(0);
		Assert.assertNotNull(CastExpression_316_Var
		);
		//316
		final UnaryExpression UnaryExpression_317_Var
		 = (UnaryExpression)CastExpression_316_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_317_Var
		);
		//317
		final PostfixExpression PostfixExpression_318_Var
		 = (PostfixExpression)UnaryExpression_317_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_318_Var
		);
		final EList<? extends EObject> Expr_318_list = PostfixExpression_318_Var
		.getExpr();
		Assert.assertNotNull(Expr_318_list);
		Assert.assertEquals(1, Expr_318_list.size());
		//318
		final PrimaryExpression PrimaryExpression_319_Var
		 = (PrimaryExpression)Expr_318_list.get(0);
		Assert.assertNotNull(PrimaryExpression_319_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_319_Var
		.getId());
		final EList<? extends EObject> Suffix_319_list = PostfixExpression_318_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_319_list);
		Assert.assertEquals(1, Suffix_319_list.size());
		//319
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_320_Var
		 = (PostfixExpressionSuffixArgument)Suffix_319_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_320_Var
		);
		//320
		final ArgumentExpressionList ArgumentExpressionList_321_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_320_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_321_Var
		);
		final EList<? extends EObject> Expr_321_list = ArgumentExpressionList_321_Var
		.getExpr();
		Assert.assertNotNull(Expr_321_list);
		Assert.assertEquals(2, Expr_321_list.size());
		//321
		final AssignmentExpression AssignmentExpression_322_Var
		 = (AssignmentExpression)Expr_321_list.get(0);
		Assert.assertNotNull(AssignmentExpression_322_Var
		);
		//322
		final ConditionalExpression ConditionalExpression_323_Var
		 = (ConditionalExpression)AssignmentExpression_322_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_323_Var
		);
		//323
		final LogicalOrExpression LogicalOrExpression_324_Var
		 = (LogicalOrExpression)ConditionalExpression_323_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_324_Var
		);
		final EList<? extends EObject> Expr_324_list = LogicalOrExpression_324_Var
		.getExpr();
		Assert.assertNotNull(Expr_324_list);
		Assert.assertEquals(1, Expr_324_list.size());
		//324
		final LogicalAndExpression LogicalAndExpression_325_Var
		 = (LogicalAndExpression)Expr_324_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_325_Var
		);
		final EList<? extends EObject> Expr_325_list = LogicalAndExpression_325_Var
		.getExpr();
		Assert.assertNotNull(Expr_325_list);
		Assert.assertEquals(1, Expr_325_list.size());
		//325
		final InclusiveOrExpression InclusiveOrExpression_326_Var
		 = (InclusiveOrExpression)Expr_325_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_326_Var
		);
		final EList<? extends EObject> Expr_326_list = InclusiveOrExpression_326_Var
		.getExpr();
		Assert.assertNotNull(Expr_326_list);
		Assert.assertEquals(1, Expr_326_list.size());
		//326
		final ExclusiveOrExpression ExclusiveOrExpression_327_Var
		 = (ExclusiveOrExpression)Expr_326_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_327_Var
		);
		final EList<? extends EObject> Expr_327_list = ExclusiveOrExpression_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final AndExpression AndExpression_328_Var
		 = (AndExpression)Expr_327_list.get(0);
		Assert.assertNotNull(AndExpression_328_Var
		);
		final EList<? extends EObject> Expr_328_list = AndExpression_328_Var
		.getExpr();
		Assert.assertNotNull(Expr_328_list);
		Assert.assertEquals(1, Expr_328_list.size());
		//328
		final EqualityExpression EqualityExpression_329_Var
		 = (EqualityExpression)Expr_328_list.get(0);
		Assert.assertNotNull(EqualityExpression_329_Var
		);
		final EList<? extends EObject> Expr_329_list = EqualityExpression_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final RelationalExpression RelationalExpression_330_Var
		 = (RelationalExpression)Expr_329_list.get(0);
		Assert.assertNotNull(RelationalExpression_330_Var
		);
		final EList<? extends EObject> Expr_330_list = RelationalExpression_330_Var
		.getExpr();
		Assert.assertNotNull(Expr_330_list);
		Assert.assertEquals(1, Expr_330_list.size());
		//330
		final ShiftExpression ShiftExpression_331_Var
		 = (ShiftExpression)Expr_330_list.get(0);
		Assert.assertNotNull(ShiftExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = ShiftExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final AdditiveExpression AdditiveExpression_332_Var
		 = (AdditiveExpression)Expr_331_list.get(0);
		Assert.assertNotNull(AdditiveExpression_332_Var
		);
		final EList<? extends EObject> Expr_332_list = AdditiveExpression_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final MultiplicativeExpression MultiplicativeExpression_333_Var
		 = (MultiplicativeExpression)Expr_332_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = MultiplicativeExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final CastExpression CastExpression_334_Var
		 = (CastExpression)Expr_333_list.get(0);
		Assert.assertNotNull(CastExpression_334_Var
		);
		//334
		final UnaryExpression UnaryExpression_335_Var
		 = (UnaryExpression)CastExpression_334_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_335_Var
		);
		//335
		final PostfixExpression PostfixExpression_336_Var
		 = (PostfixExpression)UnaryExpression_335_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = PostfixExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final PrimaryExpression PrimaryExpression_337_Var
		 = (PrimaryExpression)Expr_336_list.get(0);
		Assert.assertNotNull(PrimaryExpression_337_Var
		);
		Assert.assertEquals("[\"number.numChar(as decimal)=%d\\n\"]", PrimaryExpression_337_Var
		.getString().toString());
		//337
		final AssignmentExpression AssignmentExpression_338_Var
		 = (AssignmentExpression)Expr_321_list.get(1);
		Assert.assertNotNull(AssignmentExpression_338_Var
		);
		//338
		final ConditionalExpression ConditionalExpression_339_Var
		 = (ConditionalExpression)AssignmentExpression_338_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_339_Var
		);
		//339
		final LogicalOrExpression LogicalOrExpression_340_Var
		 = (LogicalOrExpression)ConditionalExpression_339_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_340_Var
		);
		final EList<? extends EObject> Expr_340_list = LogicalOrExpression_340_Var
		.getExpr();
		Assert.assertNotNull(Expr_340_list);
		Assert.assertEquals(1, Expr_340_list.size());
		//340
		final LogicalAndExpression LogicalAndExpression_341_Var
		 = (LogicalAndExpression)Expr_340_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_341_Var
		);
		final EList<? extends EObject> Expr_341_list = LogicalAndExpression_341_Var
		.getExpr();
		Assert.assertNotNull(Expr_341_list);
		Assert.assertEquals(1, Expr_341_list.size());
		//341
		final InclusiveOrExpression InclusiveOrExpression_342_Var
		 = (InclusiveOrExpression)Expr_341_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_342_Var
		);
		final EList<? extends EObject> Expr_342_list = InclusiveOrExpression_342_Var
		.getExpr();
		Assert.assertNotNull(Expr_342_list);
		Assert.assertEquals(1, Expr_342_list.size());
		//342
		final ExclusiveOrExpression ExclusiveOrExpression_343_Var
		 = (ExclusiveOrExpression)Expr_342_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_343_Var
		);
		final EList<? extends EObject> Expr_343_list = ExclusiveOrExpression_343_Var
		.getExpr();
		Assert.assertNotNull(Expr_343_list);
		Assert.assertEquals(1, Expr_343_list.size());
		//343
		final AndExpression AndExpression_344_Var
		 = (AndExpression)Expr_343_list.get(0);
		Assert.assertNotNull(AndExpression_344_Var
		);
		final EList<? extends EObject> Expr_344_list = AndExpression_344_Var
		.getExpr();
		Assert.assertNotNull(Expr_344_list);
		Assert.assertEquals(1, Expr_344_list.size());
		//344
		final EqualityExpression EqualityExpression_345_Var
		 = (EqualityExpression)Expr_344_list.get(0);
		Assert.assertNotNull(EqualityExpression_345_Var
		);
		final EList<? extends EObject> Expr_345_list = EqualityExpression_345_Var
		.getExpr();
		Assert.assertNotNull(Expr_345_list);
		Assert.assertEquals(1, Expr_345_list.size());
		//345
		final RelationalExpression RelationalExpression_346_Var
		 = (RelationalExpression)Expr_345_list.get(0);
		Assert.assertNotNull(RelationalExpression_346_Var
		);
		final EList<? extends EObject> Expr_346_list = RelationalExpression_346_Var
		.getExpr();
		Assert.assertNotNull(Expr_346_list);
		Assert.assertEquals(1, Expr_346_list.size());
		//346
		final ShiftExpression ShiftExpression_347_Var
		 = (ShiftExpression)Expr_346_list.get(0);
		Assert.assertNotNull(ShiftExpression_347_Var
		);
		final EList<? extends EObject> Expr_347_list = ShiftExpression_347_Var
		.getExpr();
		Assert.assertNotNull(Expr_347_list);
		Assert.assertEquals(1, Expr_347_list.size());
		//347
		final AdditiveExpression AdditiveExpression_348_Var
		 = (AdditiveExpression)Expr_347_list.get(0);
		Assert.assertNotNull(AdditiveExpression_348_Var
		);
		final EList<? extends EObject> Expr_348_list = AdditiveExpression_348_Var
		.getExpr();
		Assert.assertNotNull(Expr_348_list);
		Assert.assertEquals(1, Expr_348_list.size());
		//348
		final MultiplicativeExpression MultiplicativeExpression_349_Var
		 = (MultiplicativeExpression)Expr_348_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_349_Var
		);
		final EList<? extends EObject> Expr_349_list = MultiplicativeExpression_349_Var
		.getExpr();
		Assert.assertNotNull(Expr_349_list);
		Assert.assertEquals(1, Expr_349_list.size());
		//349
		final CastExpression CastExpression_350_Var
		 = (CastExpression)Expr_349_list.get(0);
		Assert.assertNotNull(CastExpression_350_Var
		);
		//350
		final UnaryExpression UnaryExpression_351_Var
		 = (UnaryExpression)CastExpression_350_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_351_Var
		);
		//351
		final PostfixExpression PostfixExpression_352_Var
		 = (PostfixExpression)UnaryExpression_351_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_352_Var
		);
		final EList<? extends EObject> Expr_352_list = PostfixExpression_352_Var
		.getExpr();
		Assert.assertNotNull(Expr_352_list);
		Assert.assertEquals(1, Expr_352_list.size());
		//352
		final PrimaryExpression PrimaryExpression_353_Var
		 = (PrimaryExpression)Expr_352_list.get(0);
		Assert.assertNotNull(PrimaryExpression_353_Var
		);
		Assert.assertEquals("number", PrimaryExpression_353_Var
		.getId());
		final EList<? extends EObject> Suffix_353_list = PostfixExpression_352_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_353_list);
		Assert.assertEquals(1, Suffix_353_list.size());
		//353
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_354_Var
		 = (PostfixExpressionSuffixDot)Suffix_353_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_354_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_354_Var
		.getId());
		//354
		final Statement Statement_355_Var
		 = (Statement)Statement_95_list.get(5);
		Assert.assertNotNull(Statement_355_Var
		);
		//355
		final ExpressionStatement ExpressionStatement_356_Var
		 = (ExpressionStatement)Statement_355_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_356_Var
		);
		//356
		final Expression Expression_357_Var
		 = (Expression)ExpressionStatement_356_Var
		.getExpression();
		Assert.assertNotNull(Expression_357_Var
		);
		final EList<? extends EObject> ExprExpr_357_list = Expression_357_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_357_list);
		Assert.assertEquals(1, ExprExpr_357_list.size());
		//357
		final AssignmentExpression AssignmentExpression_358_Var
		 = (AssignmentExpression)ExprExpr_357_list.get(0);
		Assert.assertNotNull(AssignmentExpression_358_Var
		);
		//358
		final ConditionalExpression ConditionalExpression_359_Var
		 = (ConditionalExpression)AssignmentExpression_358_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_359_Var
		);
		//359
		final LogicalOrExpression LogicalOrExpression_360_Var
		 = (LogicalOrExpression)ConditionalExpression_359_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_360_Var
		);
		final EList<? extends EObject> Expr_360_list = LogicalOrExpression_360_Var
		.getExpr();
		Assert.assertNotNull(Expr_360_list);
		Assert.assertEquals(1, Expr_360_list.size());
		//360
		final LogicalAndExpression LogicalAndExpression_361_Var
		 = (LogicalAndExpression)Expr_360_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_361_Var
		);
		final EList<? extends EObject> Expr_361_list = LogicalAndExpression_361_Var
		.getExpr();
		Assert.assertNotNull(Expr_361_list);
		Assert.assertEquals(1, Expr_361_list.size());
		//361
		final InclusiveOrExpression InclusiveOrExpression_362_Var
		 = (InclusiveOrExpression)Expr_361_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_362_Var
		);
		final EList<? extends EObject> Expr_362_list = InclusiveOrExpression_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(1, Expr_362_list.size());
		//362
		final ExclusiveOrExpression ExclusiveOrExpression_363_Var
		 = (ExclusiveOrExpression)Expr_362_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_363_Var
		);
		final EList<? extends EObject> Expr_363_list = ExclusiveOrExpression_363_Var
		.getExpr();
		Assert.assertNotNull(Expr_363_list);
		Assert.assertEquals(1, Expr_363_list.size());
		//363
		final AndExpression AndExpression_364_Var
		 = (AndExpression)Expr_363_list.get(0);
		Assert.assertNotNull(AndExpression_364_Var
		);
		final EList<? extends EObject> Expr_364_list = AndExpression_364_Var
		.getExpr();
		Assert.assertNotNull(Expr_364_list);
		Assert.assertEquals(1, Expr_364_list.size());
		//364
		final EqualityExpression EqualityExpression_365_Var
		 = (EqualityExpression)Expr_364_list.get(0);
		Assert.assertNotNull(EqualityExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = EqualityExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final RelationalExpression RelationalExpression_366_Var
		 = (RelationalExpression)Expr_365_list.get(0);
		Assert.assertNotNull(RelationalExpression_366_Var
		);
		final EList<? extends EObject> Expr_366_list = RelationalExpression_366_Var
		.getExpr();
		Assert.assertNotNull(Expr_366_list);
		Assert.assertEquals(1, Expr_366_list.size());
		//366
		final ShiftExpression ShiftExpression_367_Var
		 = (ShiftExpression)Expr_366_list.get(0);
		Assert.assertNotNull(ShiftExpression_367_Var
		);
		final EList<? extends EObject> Expr_367_list = ShiftExpression_367_Var
		.getExpr();
		Assert.assertNotNull(Expr_367_list);
		Assert.assertEquals(1, Expr_367_list.size());
		//367
		final AdditiveExpression AdditiveExpression_368_Var
		 = (AdditiveExpression)Expr_367_list.get(0);
		Assert.assertNotNull(AdditiveExpression_368_Var
		);
		final EList<? extends EObject> Expr_368_list = AdditiveExpression_368_Var
		.getExpr();
		Assert.assertNotNull(Expr_368_list);
		Assert.assertEquals(1, Expr_368_list.size());
		//368
		final MultiplicativeExpression MultiplicativeExpression_369_Var
		 = (MultiplicativeExpression)Expr_368_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_369_Var
		);
		final EList<? extends EObject> Expr_369_list = MultiplicativeExpression_369_Var
		.getExpr();
		Assert.assertNotNull(Expr_369_list);
		Assert.assertEquals(1, Expr_369_list.size());
		//369
		final CastExpression CastExpression_370_Var
		 = (CastExpression)Expr_369_list.get(0);
		Assert.assertNotNull(CastExpression_370_Var
		);
		//370
		final UnaryExpression UnaryExpression_371_Var
		 = (UnaryExpression)CastExpression_370_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_371_Var
		);
		//371
		final PostfixExpression PostfixExpression_372_Var
		 = (PostfixExpression)UnaryExpression_371_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_372_Var
		);
		final EList<? extends EObject> Expr_372_list = PostfixExpression_372_Var
		.getExpr();
		Assert.assertNotNull(Expr_372_list);
		Assert.assertEquals(1, Expr_372_list.size());
		//372
		final PrimaryExpression PrimaryExpression_373_Var
		 = (PrimaryExpression)Expr_372_list.get(0);
		Assert.assertNotNull(PrimaryExpression_373_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_373_Var
		.getId());
		final EList<? extends EObject> Suffix_373_list = PostfixExpression_372_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_373_list);
		Assert.assertEquals(1, Suffix_373_list.size());
		//373
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_374_Var
		 = (PostfixExpressionSuffixArgument)Suffix_373_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_374_Var
		);
		//374
		final ArgumentExpressionList ArgumentExpressionList_375_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_374_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_375_Var
		);
		final EList<? extends EObject> Expr_375_list = ArgumentExpressionList_375_Var
		.getExpr();
		Assert.assertNotNull(Expr_375_list);
		Assert.assertEquals(2, Expr_375_list.size());
		//375
		final AssignmentExpression AssignmentExpression_376_Var
		 = (AssignmentExpression)Expr_375_list.get(0);
		Assert.assertNotNull(AssignmentExpression_376_Var
		);
		//376
		final ConditionalExpression ConditionalExpression_377_Var
		 = (ConditionalExpression)AssignmentExpression_376_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_377_Var
		);
		//377
		final LogicalOrExpression LogicalOrExpression_378_Var
		 = (LogicalOrExpression)ConditionalExpression_377_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_378_Var
		);
		final EList<? extends EObject> Expr_378_list = LogicalOrExpression_378_Var
		.getExpr();
		Assert.assertNotNull(Expr_378_list);
		Assert.assertEquals(1, Expr_378_list.size());
		//378
		final LogicalAndExpression LogicalAndExpression_379_Var
		 = (LogicalAndExpression)Expr_378_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_379_Var
		);
		final EList<? extends EObject> Expr_379_list = LogicalAndExpression_379_Var
		.getExpr();
		Assert.assertNotNull(Expr_379_list);
		Assert.assertEquals(1, Expr_379_list.size());
		//379
		final InclusiveOrExpression InclusiveOrExpression_380_Var
		 = (InclusiveOrExpression)Expr_379_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_380_Var
		);
		final EList<? extends EObject> Expr_380_list = InclusiveOrExpression_380_Var
		.getExpr();
		Assert.assertNotNull(Expr_380_list);
		Assert.assertEquals(1, Expr_380_list.size());
		//380
		final ExclusiveOrExpression ExclusiveOrExpression_381_Var
		 = (ExclusiveOrExpression)Expr_380_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_381_Var
		);
		final EList<? extends EObject> Expr_381_list = ExclusiveOrExpression_381_Var
		.getExpr();
		Assert.assertNotNull(Expr_381_list);
		Assert.assertEquals(1, Expr_381_list.size());
		//381
		final AndExpression AndExpression_382_Var
		 = (AndExpression)Expr_381_list.get(0);
		Assert.assertNotNull(AndExpression_382_Var
		);
		final EList<? extends EObject> Expr_382_list = AndExpression_382_Var
		.getExpr();
		Assert.assertNotNull(Expr_382_list);
		Assert.assertEquals(1, Expr_382_list.size());
		//382
		final EqualityExpression EqualityExpression_383_Var
		 = (EqualityExpression)Expr_382_list.get(0);
		Assert.assertNotNull(EqualityExpression_383_Var
		);
		final EList<? extends EObject> Expr_383_list = EqualityExpression_383_Var
		.getExpr();
		Assert.assertNotNull(Expr_383_list);
		Assert.assertEquals(1, Expr_383_list.size());
		//383
		final RelationalExpression RelationalExpression_384_Var
		 = (RelationalExpression)Expr_383_list.get(0);
		Assert.assertNotNull(RelationalExpression_384_Var
		);
		final EList<? extends EObject> Expr_384_list = RelationalExpression_384_Var
		.getExpr();
		Assert.assertNotNull(Expr_384_list);
		Assert.assertEquals(1, Expr_384_list.size());
		//384
		final ShiftExpression ShiftExpression_385_Var
		 = (ShiftExpression)Expr_384_list.get(0);
		Assert.assertNotNull(ShiftExpression_385_Var
		);
		final EList<? extends EObject> Expr_385_list = ShiftExpression_385_Var
		.getExpr();
		Assert.assertNotNull(Expr_385_list);
		Assert.assertEquals(1, Expr_385_list.size());
		//385
		final AdditiveExpression AdditiveExpression_386_Var
		 = (AdditiveExpression)Expr_385_list.get(0);
		Assert.assertNotNull(AdditiveExpression_386_Var
		);
		final EList<? extends EObject> Expr_386_list = AdditiveExpression_386_Var
		.getExpr();
		Assert.assertNotNull(Expr_386_list);
		Assert.assertEquals(1, Expr_386_list.size());
		//386
		final MultiplicativeExpression MultiplicativeExpression_387_Var
		 = (MultiplicativeExpression)Expr_386_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_387_Var
		);
		final EList<? extends EObject> Expr_387_list = MultiplicativeExpression_387_Var
		.getExpr();
		Assert.assertNotNull(Expr_387_list);
		Assert.assertEquals(1, Expr_387_list.size());
		//387
		final CastExpression CastExpression_388_Var
		 = (CastExpression)Expr_387_list.get(0);
		Assert.assertNotNull(CastExpression_388_Var
		);
		//388
		final UnaryExpression UnaryExpression_389_Var
		 = (UnaryExpression)CastExpression_388_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_389_Var
		);
		//389
		final PostfixExpression PostfixExpression_390_Var
		 = (PostfixExpression)UnaryExpression_389_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_390_Var
		);
		final EList<? extends EObject> Expr_390_list = PostfixExpression_390_Var
		.getExpr();
		Assert.assertNotNull(Expr_390_list);
		Assert.assertEquals(1, Expr_390_list.size());
		//390
		final PrimaryExpression PrimaryExpression_391_Var
		 = (PrimaryExpression)Expr_390_list.get(0);
		Assert.assertNotNull(PrimaryExpression_391_Var
		);
		Assert.assertEquals("[\"number.numChar(as char)=%c\\n\"]", PrimaryExpression_391_Var
		.getString().toString());
		//391
		final AssignmentExpression AssignmentExpression_392_Var
		 = (AssignmentExpression)Expr_375_list.get(1);
		Assert.assertNotNull(AssignmentExpression_392_Var
		);
		//392
		final ConditionalExpression ConditionalExpression_393_Var
		 = (ConditionalExpression)AssignmentExpression_392_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_393_Var
		);
		//393
		final LogicalOrExpression LogicalOrExpression_394_Var
		 = (LogicalOrExpression)ConditionalExpression_393_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_394_Var
		);
		final EList<? extends EObject> Expr_394_list = LogicalOrExpression_394_Var
		.getExpr();
		Assert.assertNotNull(Expr_394_list);
		Assert.assertEquals(1, Expr_394_list.size());
		//394
		final LogicalAndExpression LogicalAndExpression_395_Var
		 = (LogicalAndExpression)Expr_394_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_395_Var
		);
		final EList<? extends EObject> Expr_395_list = LogicalAndExpression_395_Var
		.getExpr();
		Assert.assertNotNull(Expr_395_list);
		Assert.assertEquals(1, Expr_395_list.size());
		//395
		final InclusiveOrExpression InclusiveOrExpression_396_Var
		 = (InclusiveOrExpression)Expr_395_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_396_Var
		);
		final EList<? extends EObject> Expr_396_list = InclusiveOrExpression_396_Var
		.getExpr();
		Assert.assertNotNull(Expr_396_list);
		Assert.assertEquals(1, Expr_396_list.size());
		//396
		final ExclusiveOrExpression ExclusiveOrExpression_397_Var
		 = (ExclusiveOrExpression)Expr_396_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_397_Var
		);
		final EList<? extends EObject> Expr_397_list = ExclusiveOrExpression_397_Var
		.getExpr();
		Assert.assertNotNull(Expr_397_list);
		Assert.assertEquals(1, Expr_397_list.size());
		//397
		final AndExpression AndExpression_398_Var
		 = (AndExpression)Expr_397_list.get(0);
		Assert.assertNotNull(AndExpression_398_Var
		);
		final EList<? extends EObject> Expr_398_list = AndExpression_398_Var
		.getExpr();
		Assert.assertNotNull(Expr_398_list);
		Assert.assertEquals(1, Expr_398_list.size());
		//398
		final EqualityExpression EqualityExpression_399_Var
		 = (EqualityExpression)Expr_398_list.get(0);
		Assert.assertNotNull(EqualityExpression_399_Var
		);
		final EList<? extends EObject> Expr_399_list = EqualityExpression_399_Var
		.getExpr();
		Assert.assertNotNull(Expr_399_list);
		Assert.assertEquals(1, Expr_399_list.size());
		//399
		final RelationalExpression RelationalExpression_400_Var
		 = (RelationalExpression)Expr_399_list.get(0);
		Assert.assertNotNull(RelationalExpression_400_Var
		);
		final EList<? extends EObject> Expr_400_list = RelationalExpression_400_Var
		.getExpr();
		Assert.assertNotNull(Expr_400_list);
		Assert.assertEquals(1, Expr_400_list.size());
		//400
		final ShiftExpression ShiftExpression_401_Var
		 = (ShiftExpression)Expr_400_list.get(0);
		Assert.assertNotNull(ShiftExpression_401_Var
		);
		final EList<? extends EObject> Expr_401_list = ShiftExpression_401_Var
		.getExpr();
		Assert.assertNotNull(Expr_401_list);
		Assert.assertEquals(1, Expr_401_list.size());
		//401
		final AdditiveExpression AdditiveExpression_402_Var
		 = (AdditiveExpression)Expr_401_list.get(0);
		Assert.assertNotNull(AdditiveExpression_402_Var
		);
		final EList<? extends EObject> Expr_402_list = AdditiveExpression_402_Var
		.getExpr();
		Assert.assertNotNull(Expr_402_list);
		Assert.assertEquals(1, Expr_402_list.size());
		//402
		final MultiplicativeExpression MultiplicativeExpression_403_Var
		 = (MultiplicativeExpression)Expr_402_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_403_Var
		);
		final EList<? extends EObject> Expr_403_list = MultiplicativeExpression_403_Var
		.getExpr();
		Assert.assertNotNull(Expr_403_list);
		Assert.assertEquals(1, Expr_403_list.size());
		//403
		final CastExpression CastExpression_404_Var
		 = (CastExpression)Expr_403_list.get(0);
		Assert.assertNotNull(CastExpression_404_Var
		);
		//404
		final UnaryExpression UnaryExpression_405_Var
		 = (UnaryExpression)CastExpression_404_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_405_Var
		);
		//405
		final PostfixExpression PostfixExpression_406_Var
		 = (PostfixExpression)UnaryExpression_405_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_406_Var
		);
		final EList<? extends EObject> Expr_406_list = PostfixExpression_406_Var
		.getExpr();
		Assert.assertNotNull(Expr_406_list);
		Assert.assertEquals(1, Expr_406_list.size());
		//406
		final PrimaryExpression PrimaryExpression_407_Var
		 = (PrimaryExpression)Expr_406_list.get(0);
		Assert.assertNotNull(PrimaryExpression_407_Var
		);
		Assert.assertEquals("number", PrimaryExpression_407_Var
		.getId());
		final EList<? extends EObject> Suffix_407_list = PostfixExpression_406_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_407_list);
		Assert.assertEquals(1, Suffix_407_list.size());
		//407
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_408_Var
		 = (PostfixExpressionSuffixDot)Suffix_407_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_408_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_408_Var
		.getId());
		//408
		final Statement Statement_409_Var
		 = (Statement)Statement_95_list.get(6);
		Assert.assertNotNull(Statement_409_Var
		);
		//409
		final ExpressionStatement ExpressionStatement_410_Var
		 = (ExpressionStatement)Statement_409_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_410_Var
		);
		//410
		final Expression Expression_411_Var
		 = (Expression)ExpressionStatement_410_Var
		.getExpression();
		Assert.assertNotNull(Expression_411_Var
		);
		final EList<? extends EObject> ExprExpr_411_list = Expression_411_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_411_list);
		Assert.assertEquals(1, ExprExpr_411_list.size());
		//411
		final AssignmentExpression AssignmentExpression_412_Var
		 = (AssignmentExpression)ExprExpr_411_list.get(0);
		Assert.assertNotNull(AssignmentExpression_412_Var
		);
		//412
		final ConditionalExpression ConditionalExpression_413_Var
		 = (ConditionalExpression)AssignmentExpression_412_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_413_Var
		);
		//413
		final LogicalOrExpression LogicalOrExpression_414_Var
		 = (LogicalOrExpression)ConditionalExpression_413_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_414_Var
		);
		final EList<? extends EObject> Expr_414_list = LogicalOrExpression_414_Var
		.getExpr();
		Assert.assertNotNull(Expr_414_list);
		Assert.assertEquals(1, Expr_414_list.size());
		//414
		final LogicalAndExpression LogicalAndExpression_415_Var
		 = (LogicalAndExpression)Expr_414_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_415_Var
		);
		final EList<? extends EObject> Expr_415_list = LogicalAndExpression_415_Var
		.getExpr();
		Assert.assertNotNull(Expr_415_list);
		Assert.assertEquals(1, Expr_415_list.size());
		//415
		final InclusiveOrExpression InclusiveOrExpression_416_Var
		 = (InclusiveOrExpression)Expr_415_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_416_Var
		);
		final EList<? extends EObject> Expr_416_list = InclusiveOrExpression_416_Var
		.getExpr();
		Assert.assertNotNull(Expr_416_list);
		Assert.assertEquals(1, Expr_416_list.size());
		//416
		final ExclusiveOrExpression ExclusiveOrExpression_417_Var
		 = (ExclusiveOrExpression)Expr_416_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_417_Var
		);
		final EList<? extends EObject> Expr_417_list = ExclusiveOrExpression_417_Var
		.getExpr();
		Assert.assertNotNull(Expr_417_list);
		Assert.assertEquals(1, Expr_417_list.size());
		//417
		final AndExpression AndExpression_418_Var
		 = (AndExpression)Expr_417_list.get(0);
		Assert.assertNotNull(AndExpression_418_Var
		);
		final EList<? extends EObject> Expr_418_list = AndExpression_418_Var
		.getExpr();
		Assert.assertNotNull(Expr_418_list);
		Assert.assertEquals(1, Expr_418_list.size());
		//418
		final EqualityExpression EqualityExpression_419_Var
		 = (EqualityExpression)Expr_418_list.get(0);
		Assert.assertNotNull(EqualityExpression_419_Var
		);
		final EList<? extends EObject> Expr_419_list = EqualityExpression_419_Var
		.getExpr();
		Assert.assertNotNull(Expr_419_list);
		Assert.assertEquals(1, Expr_419_list.size());
		//419
		final RelationalExpression RelationalExpression_420_Var
		 = (RelationalExpression)Expr_419_list.get(0);
		Assert.assertNotNull(RelationalExpression_420_Var
		);
		final EList<? extends EObject> Expr_420_list = RelationalExpression_420_Var
		.getExpr();
		Assert.assertNotNull(Expr_420_list);
		Assert.assertEquals(1, Expr_420_list.size());
		//420
		final ShiftExpression ShiftExpression_421_Var
		 = (ShiftExpression)Expr_420_list.get(0);
		Assert.assertNotNull(ShiftExpression_421_Var
		);
		final EList<? extends EObject> Expr_421_list = ShiftExpression_421_Var
		.getExpr();
		Assert.assertNotNull(Expr_421_list);
		Assert.assertEquals(1, Expr_421_list.size());
		//421
		final AdditiveExpression AdditiveExpression_422_Var
		 = (AdditiveExpression)Expr_421_list.get(0);
		Assert.assertNotNull(AdditiveExpression_422_Var
		);
		final EList<? extends EObject> Expr_422_list = AdditiveExpression_422_Var
		.getExpr();
		Assert.assertNotNull(Expr_422_list);
		Assert.assertEquals(1, Expr_422_list.size());
		//422
		final MultiplicativeExpression MultiplicativeExpression_423_Var
		 = (MultiplicativeExpression)Expr_422_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_423_Var
		);
		final EList<? extends EObject> Expr_423_list = MultiplicativeExpression_423_Var
		.getExpr();
		Assert.assertNotNull(Expr_423_list);
		Assert.assertEquals(1, Expr_423_list.size());
		//423
		final CastExpression CastExpression_424_Var
		 = (CastExpression)Expr_423_list.get(0);
		Assert.assertNotNull(CastExpression_424_Var
		);
		//424
		final UnaryExpression UnaryExpression_425_Var
		 = (UnaryExpression)CastExpression_424_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_425_Var
		);
		//425
		final PostfixExpression PostfixExpression_426_Var
		 = (PostfixExpression)UnaryExpression_425_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_426_Var
		);
		final EList<? extends EObject> Expr_426_list = PostfixExpression_426_Var
		.getExpr();
		Assert.assertNotNull(Expr_426_list);
		Assert.assertEquals(1, Expr_426_list.size());
		//426
		final PrimaryExpression PrimaryExpression_427_Var
		 = (PrimaryExpression)Expr_426_list.get(0);
		Assert.assertNotNull(PrimaryExpression_427_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_427_Var
		.getId());
		final EList<? extends EObject> Suffix_427_list = PostfixExpression_426_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_427_list);
		Assert.assertEquals(1, Suffix_427_list.size());
		//427
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_428_Var
		 = (PostfixExpressionSuffixArgument)Suffix_427_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_428_Var
		);
		//428
		final ArgumentExpressionList ArgumentExpressionList_429_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_428_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_429_Var
		);
		final EList<? extends EObject> Expr_429_list = ArgumentExpressionList_429_Var
		.getExpr();
		Assert.assertNotNull(Expr_429_list);
		Assert.assertEquals(2, Expr_429_list.size());
		//429
		final AssignmentExpression AssignmentExpression_430_Var
		 = (AssignmentExpression)Expr_429_list.get(0);
		Assert.assertNotNull(AssignmentExpression_430_Var
		);
		//430
		final ConditionalExpression ConditionalExpression_431_Var
		 = (ConditionalExpression)AssignmentExpression_430_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_431_Var
		);
		//431
		final LogicalOrExpression LogicalOrExpression_432_Var
		 = (LogicalOrExpression)ConditionalExpression_431_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_432_Var
		);
		final EList<? extends EObject> Expr_432_list = LogicalOrExpression_432_Var
		.getExpr();
		Assert.assertNotNull(Expr_432_list);
		Assert.assertEquals(1, Expr_432_list.size());
		//432
		final LogicalAndExpression LogicalAndExpression_433_Var
		 = (LogicalAndExpression)Expr_432_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_433_Var
		);
		final EList<? extends EObject> Expr_433_list = LogicalAndExpression_433_Var
		.getExpr();
		Assert.assertNotNull(Expr_433_list);
		Assert.assertEquals(1, Expr_433_list.size());
		//433
		final InclusiveOrExpression InclusiveOrExpression_434_Var
		 = (InclusiveOrExpression)Expr_433_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_434_Var
		);
		final EList<? extends EObject> Expr_434_list = InclusiveOrExpression_434_Var
		.getExpr();
		Assert.assertNotNull(Expr_434_list);
		Assert.assertEquals(1, Expr_434_list.size());
		//434
		final ExclusiveOrExpression ExclusiveOrExpression_435_Var
		 = (ExclusiveOrExpression)Expr_434_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_435_Var
		);
		final EList<? extends EObject> Expr_435_list = ExclusiveOrExpression_435_Var
		.getExpr();
		Assert.assertNotNull(Expr_435_list);
		Assert.assertEquals(1, Expr_435_list.size());
		//435
		final AndExpression AndExpression_436_Var
		 = (AndExpression)Expr_435_list.get(0);
		Assert.assertNotNull(AndExpression_436_Var
		);
		final EList<? extends EObject> Expr_436_list = AndExpression_436_Var
		.getExpr();
		Assert.assertNotNull(Expr_436_list);
		Assert.assertEquals(1, Expr_436_list.size());
		//436
		final EqualityExpression EqualityExpression_437_Var
		 = (EqualityExpression)Expr_436_list.get(0);
		Assert.assertNotNull(EqualityExpression_437_Var
		);
		final EList<? extends EObject> Expr_437_list = EqualityExpression_437_Var
		.getExpr();
		Assert.assertNotNull(Expr_437_list);
		Assert.assertEquals(1, Expr_437_list.size());
		//437
		final RelationalExpression RelationalExpression_438_Var
		 = (RelationalExpression)Expr_437_list.get(0);
		Assert.assertNotNull(RelationalExpression_438_Var
		);
		final EList<? extends EObject> Expr_438_list = RelationalExpression_438_Var
		.getExpr();
		Assert.assertNotNull(Expr_438_list);
		Assert.assertEquals(1, Expr_438_list.size());
		//438
		final ShiftExpression ShiftExpression_439_Var
		 = (ShiftExpression)Expr_438_list.get(0);
		Assert.assertNotNull(ShiftExpression_439_Var
		);
		final EList<? extends EObject> Expr_439_list = ShiftExpression_439_Var
		.getExpr();
		Assert.assertNotNull(Expr_439_list);
		Assert.assertEquals(1, Expr_439_list.size());
		//439
		final AdditiveExpression AdditiveExpression_440_Var
		 = (AdditiveExpression)Expr_439_list.get(0);
		Assert.assertNotNull(AdditiveExpression_440_Var
		);
		final EList<? extends EObject> Expr_440_list = AdditiveExpression_440_Var
		.getExpr();
		Assert.assertNotNull(Expr_440_list);
		Assert.assertEquals(1, Expr_440_list.size());
		//440
		final MultiplicativeExpression MultiplicativeExpression_441_Var
		 = (MultiplicativeExpression)Expr_440_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_441_Var
		);
		final EList<? extends EObject> Expr_441_list = MultiplicativeExpression_441_Var
		.getExpr();
		Assert.assertNotNull(Expr_441_list);
		Assert.assertEquals(1, Expr_441_list.size());
		//441
		final CastExpression CastExpression_442_Var
		 = (CastExpression)Expr_441_list.get(0);
		Assert.assertNotNull(CastExpression_442_Var
		);
		//442
		final UnaryExpression UnaryExpression_443_Var
		 = (UnaryExpression)CastExpression_442_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_443_Var
		);
		//443
		final PostfixExpression PostfixExpression_444_Var
		 = (PostfixExpression)UnaryExpression_443_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_444_Var
		);
		final EList<? extends EObject> Expr_444_list = PostfixExpression_444_Var
		.getExpr();
		Assert.assertNotNull(Expr_444_list);
		Assert.assertEquals(1, Expr_444_list.size());
		//444
		final PrimaryExpression PrimaryExpression_445_Var
		 = (PrimaryExpression)Expr_444_list.get(0);
		Assert.assertNotNull(PrimaryExpression_445_Var
		);
		Assert.assertEquals("[\"number.numFloat=%f\\n\"]", PrimaryExpression_445_Var
		.getString().toString());
		//445
		final AssignmentExpression AssignmentExpression_446_Var
		 = (AssignmentExpression)Expr_429_list.get(1);
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
		Assert.assertEquals("number", PrimaryExpression_461_Var
		.getId());
		final EList<? extends EObject> Suffix_461_list = PostfixExpression_460_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_461_list);
		Assert.assertEquals(1, Suffix_461_list.size());
		//461
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_462_Var
		 = (PostfixExpressionSuffixDot)Suffix_461_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_462_Var
		);
		Assert.assertEquals("numFloat", PostfixExpressionSuffixDot_462_Var
		.getId());
		//462
		final Statement Statement_463_Var
		 = (Statement)Statement_95_list.get(7);
		Assert.assertNotNull(Statement_463_Var
		);
		//463
		final ExpressionStatement ExpressionStatement_464_Var
		 = (ExpressionStatement)Statement_463_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_464_Var
		);
		//464
		final Expression Expression_465_Var
		 = (Expression)ExpressionStatement_464_Var
		.getExpression();
		Assert.assertNotNull(Expression_465_Var
		);
		final EList<? extends EObject> ExprExpr_465_list = Expression_465_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_465_list);
		Assert.assertEquals(1, ExprExpr_465_list.size());
		//465
		final AssignmentExpression AssignmentExpression_466_Var
		 = (AssignmentExpression)ExprExpr_465_list.get(0);
		Assert.assertNotNull(AssignmentExpression_466_Var
		);
		//466
		final UnaryExpression UnaryExpression_467_Var
		 = (UnaryExpression)AssignmentExpression_466_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_467_Var
		);
		//467
		final PostfixExpression PostfixExpression_468_Var
		 = (PostfixExpression)UnaryExpression_467_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_468_Var
		);
		final EList<? extends EObject> Expr_468_list = PostfixExpression_468_Var
		.getExpr();
		Assert.assertNotNull(Expr_468_list);
		Assert.assertEquals(1, Expr_468_list.size());
		//468
		final PrimaryExpression PrimaryExpression_469_Var
		 = (PrimaryExpression)Expr_468_list.get(0);
		Assert.assertNotNull(PrimaryExpression_469_Var
		);
		Assert.assertEquals("number", PrimaryExpression_469_Var
		.getId());
		final EList<? extends EObject> Suffix_469_list = PostfixExpression_468_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_469_list);
		Assert.assertEquals(1, Suffix_469_list.size());
		//469
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_470_Var
		 = (PostfixExpressionSuffixDot)Suffix_469_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_470_Var
		);
		Assert.assertEquals("numFloat", PostfixExpressionSuffixDot_470_Var
		.getId());
		//470
		final AssignmentOperator AssignmentOperator_471_Var
		 = (AssignmentOperator)AssignmentExpression_466_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_471_Var
		);
		Assert.assertEquals("=", AssignmentOperator_471_Var
		.getOp());
		//471
		final AssignmentExpression AssignmentExpression_472_Var
		 = (AssignmentExpression)AssignmentExpression_466_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_472_Var
		);
		//472
		final ConditionalExpression ConditionalExpression_473_Var
		 = (ConditionalExpression)AssignmentExpression_472_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_473_Var
		);
		//473
		final LogicalOrExpression LogicalOrExpression_474_Var
		 = (LogicalOrExpression)ConditionalExpression_473_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_474_Var
		);
		final EList<? extends EObject> Expr_474_list = LogicalOrExpression_474_Var
		.getExpr();
		Assert.assertNotNull(Expr_474_list);
		Assert.assertEquals(1, Expr_474_list.size());
		//474
		final LogicalAndExpression LogicalAndExpression_475_Var
		 = (LogicalAndExpression)Expr_474_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_475_Var
		);
		final EList<? extends EObject> Expr_475_list = LogicalAndExpression_475_Var
		.getExpr();
		Assert.assertNotNull(Expr_475_list);
		Assert.assertEquals(1, Expr_475_list.size());
		//475
		final InclusiveOrExpression InclusiveOrExpression_476_Var
		 = (InclusiveOrExpression)Expr_475_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_476_Var
		);
		final EList<? extends EObject> Expr_476_list = InclusiveOrExpression_476_Var
		.getExpr();
		Assert.assertNotNull(Expr_476_list);
		Assert.assertEquals(1, Expr_476_list.size());
		//476
		final ExclusiveOrExpression ExclusiveOrExpression_477_Var
		 = (ExclusiveOrExpression)Expr_476_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_477_Var
		);
		final EList<? extends EObject> Expr_477_list = ExclusiveOrExpression_477_Var
		.getExpr();
		Assert.assertNotNull(Expr_477_list);
		Assert.assertEquals(1, Expr_477_list.size());
		//477
		final AndExpression AndExpression_478_Var
		 = (AndExpression)Expr_477_list.get(0);
		Assert.assertNotNull(AndExpression_478_Var
		);
		final EList<? extends EObject> Expr_478_list = AndExpression_478_Var
		.getExpr();
		Assert.assertNotNull(Expr_478_list);
		Assert.assertEquals(1, Expr_478_list.size());
		//478
		final EqualityExpression EqualityExpression_479_Var
		 = (EqualityExpression)Expr_478_list.get(0);
		Assert.assertNotNull(EqualityExpression_479_Var
		);
		final EList<? extends EObject> Expr_479_list = EqualityExpression_479_Var
		.getExpr();
		Assert.assertNotNull(Expr_479_list);
		Assert.assertEquals(1, Expr_479_list.size());
		//479
		final RelationalExpression RelationalExpression_480_Var
		 = (RelationalExpression)Expr_479_list.get(0);
		Assert.assertNotNull(RelationalExpression_480_Var
		);
		final EList<? extends EObject> Expr_480_list = RelationalExpression_480_Var
		.getExpr();
		Assert.assertNotNull(Expr_480_list);
		Assert.assertEquals(1, Expr_480_list.size());
		//480
		final ShiftExpression ShiftExpression_481_Var
		 = (ShiftExpression)Expr_480_list.get(0);
		Assert.assertNotNull(ShiftExpression_481_Var
		);
		final EList<? extends EObject> Expr_481_list = ShiftExpression_481_Var
		.getExpr();
		Assert.assertNotNull(Expr_481_list);
		Assert.assertEquals(1, Expr_481_list.size());
		//481
		final AdditiveExpression AdditiveExpression_482_Var
		 = (AdditiveExpression)Expr_481_list.get(0);
		Assert.assertNotNull(AdditiveExpression_482_Var
		);
		final EList<? extends EObject> Expr_482_list = AdditiveExpression_482_Var
		.getExpr();
		Assert.assertNotNull(Expr_482_list);
		Assert.assertEquals(1, Expr_482_list.size());
		//482
		final MultiplicativeExpression MultiplicativeExpression_483_Var
		 = (MultiplicativeExpression)Expr_482_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_483_Var
		);
		final EList<? extends EObject> Expr_483_list = MultiplicativeExpression_483_Var
		.getExpr();
		Assert.assertNotNull(Expr_483_list);
		Assert.assertEquals(1, Expr_483_list.size());
		//483
		final CastExpression CastExpression_484_Var
		 = (CastExpression)Expr_483_list.get(0);
		Assert.assertNotNull(CastExpression_484_Var
		);
		//484
		final UnaryExpression UnaryExpression_485_Var
		 = (UnaryExpression)CastExpression_484_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_485_Var
		);
		//485
		final PostfixExpression PostfixExpression_486_Var
		 = (PostfixExpression)UnaryExpression_485_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_486_Var
		);
		final EList<? extends EObject> Expr_486_list = PostfixExpression_486_Var
		.getExpr();
		Assert.assertNotNull(Expr_486_list);
		Assert.assertEquals(1, Expr_486_list.size());
		//486
		final PrimaryExpression PrimaryExpression_487_Var
		 = (PrimaryExpression)Expr_486_list.get(0);
		Assert.assertNotNull(PrimaryExpression_487_Var
		);
		//487
		final Constant2 Constant2_488_Var
		 = (Constant2)PrimaryExpression_487_Var
		.getConst();
		Assert.assertNotNull(Constant2_488_Var
		);
		Assert.assertEquals("0.56789", Constant2_488_Var
		.getFloat());
		//488
		final Statement Statement_489_Var
		 = (Statement)Statement_95_list.get(8);
		Assert.assertNotNull(Statement_489_Var
		);
		//489
		final ExpressionStatement ExpressionStatement_490_Var
		 = (ExpressionStatement)Statement_489_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_490_Var
		);
		//490
		final Expression Expression_491_Var
		 = (Expression)ExpressionStatement_490_Var
		.getExpression();
		Assert.assertNotNull(Expression_491_Var
		);
		final EList<? extends EObject> ExprExpr_491_list = Expression_491_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_491_list);
		Assert.assertEquals(1, ExprExpr_491_list.size());
		//491
		final AssignmentExpression AssignmentExpression_492_Var
		 = (AssignmentExpression)ExprExpr_491_list.get(0);
		Assert.assertNotNull(AssignmentExpression_492_Var
		);
		//492
		final ConditionalExpression ConditionalExpression_493_Var
		 = (ConditionalExpression)AssignmentExpression_492_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_493_Var
		);
		//493
		final LogicalOrExpression LogicalOrExpression_494_Var
		 = (LogicalOrExpression)ConditionalExpression_493_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_494_Var
		);
		final EList<? extends EObject> Expr_494_list = LogicalOrExpression_494_Var
		.getExpr();
		Assert.assertNotNull(Expr_494_list);
		Assert.assertEquals(1, Expr_494_list.size());
		//494
		final LogicalAndExpression LogicalAndExpression_495_Var
		 = (LogicalAndExpression)Expr_494_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_495_Var
		);
		final EList<? extends EObject> Expr_495_list = LogicalAndExpression_495_Var
		.getExpr();
		Assert.assertNotNull(Expr_495_list);
		Assert.assertEquals(1, Expr_495_list.size());
		//495
		final InclusiveOrExpression InclusiveOrExpression_496_Var
		 = (InclusiveOrExpression)Expr_495_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_496_Var
		);
		final EList<? extends EObject> Expr_496_list = InclusiveOrExpression_496_Var
		.getExpr();
		Assert.assertNotNull(Expr_496_list);
		Assert.assertEquals(1, Expr_496_list.size());
		//496
		final ExclusiveOrExpression ExclusiveOrExpression_497_Var
		 = (ExclusiveOrExpression)Expr_496_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_497_Var
		);
		final EList<? extends EObject> Expr_497_list = ExclusiveOrExpression_497_Var
		.getExpr();
		Assert.assertNotNull(Expr_497_list);
		Assert.assertEquals(1, Expr_497_list.size());
		//497
		final AndExpression AndExpression_498_Var
		 = (AndExpression)Expr_497_list.get(0);
		Assert.assertNotNull(AndExpression_498_Var
		);
		final EList<? extends EObject> Expr_498_list = AndExpression_498_Var
		.getExpr();
		Assert.assertNotNull(Expr_498_list);
		Assert.assertEquals(1, Expr_498_list.size());
		//498
		final EqualityExpression EqualityExpression_499_Var
		 = (EqualityExpression)Expr_498_list.get(0);
		Assert.assertNotNull(EqualityExpression_499_Var
		);
		final EList<? extends EObject> Expr_499_list = EqualityExpression_499_Var
		.getExpr();
		Assert.assertNotNull(Expr_499_list);
		Assert.assertEquals(1, Expr_499_list.size());
		//499
		final RelationalExpression RelationalExpression_500_Var
		 = (RelationalExpression)Expr_499_list.get(0);
		Assert.assertNotNull(RelationalExpression_500_Var
		);
		final EList<? extends EObject> Expr_500_list = RelationalExpression_500_Var
		.getExpr();
		Assert.assertNotNull(Expr_500_list);
		Assert.assertEquals(1, Expr_500_list.size());
		//500
		final ShiftExpression ShiftExpression_501_Var
		 = (ShiftExpression)Expr_500_list.get(0);
		Assert.assertNotNull(ShiftExpression_501_Var
		);
		final EList<? extends EObject> Expr_501_list = ShiftExpression_501_Var
		.getExpr();
		Assert.assertNotNull(Expr_501_list);
		Assert.assertEquals(1, Expr_501_list.size());
		//501
		final AdditiveExpression AdditiveExpression_502_Var
		 = (AdditiveExpression)Expr_501_list.get(0);
		Assert.assertNotNull(AdditiveExpression_502_Var
		);
		final EList<? extends EObject> Expr_502_list = AdditiveExpression_502_Var
		.getExpr();
		Assert.assertNotNull(Expr_502_list);
		Assert.assertEquals(1, Expr_502_list.size());
		//502
		final MultiplicativeExpression MultiplicativeExpression_503_Var
		 = (MultiplicativeExpression)Expr_502_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_503_Var
		);
		final EList<? extends EObject> Expr_503_list = MultiplicativeExpression_503_Var
		.getExpr();
		Assert.assertNotNull(Expr_503_list);
		Assert.assertEquals(1, Expr_503_list.size());
		//503
		final CastExpression CastExpression_504_Var
		 = (CastExpression)Expr_503_list.get(0);
		Assert.assertNotNull(CastExpression_504_Var
		);
		//504
		final UnaryExpression UnaryExpression_505_Var
		 = (UnaryExpression)CastExpression_504_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_505_Var
		);
		//505
		final PostfixExpression PostfixExpression_506_Var
		 = (PostfixExpression)UnaryExpression_505_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_506_Var
		);
		final EList<? extends EObject> Expr_506_list = PostfixExpression_506_Var
		.getExpr();
		Assert.assertNotNull(Expr_506_list);
		Assert.assertEquals(1, Expr_506_list.size());
		//506
		final PrimaryExpression PrimaryExpression_507_Var
		 = (PrimaryExpression)Expr_506_list.get(0);
		Assert.assertNotNull(PrimaryExpression_507_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_507_Var
		.getId());
		final EList<? extends EObject> Suffix_507_list = PostfixExpression_506_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_507_list);
		Assert.assertEquals(1, Suffix_507_list.size());
		//507
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_508_Var
		 = (PostfixExpressionSuffixArgument)Suffix_507_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_508_Var
		);
		//508
		final ArgumentExpressionList ArgumentExpressionList_509_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_508_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_509_Var
		);
		final EList<? extends EObject> Expr_509_list = ArgumentExpressionList_509_Var
		.getExpr();
		Assert.assertNotNull(Expr_509_list);
		Assert.assertEquals(2, Expr_509_list.size());
		//509
		final AssignmentExpression AssignmentExpression_510_Var
		 = (AssignmentExpression)Expr_509_list.get(0);
		Assert.assertNotNull(AssignmentExpression_510_Var
		);
		//510
		final ConditionalExpression ConditionalExpression_511_Var
		 = (ConditionalExpression)AssignmentExpression_510_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_511_Var
		);
		//511
		final LogicalOrExpression LogicalOrExpression_512_Var
		 = (LogicalOrExpression)ConditionalExpression_511_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_512_Var
		);
		final EList<? extends EObject> Expr_512_list = LogicalOrExpression_512_Var
		.getExpr();
		Assert.assertNotNull(Expr_512_list);
		Assert.assertEquals(1, Expr_512_list.size());
		//512
		final LogicalAndExpression LogicalAndExpression_513_Var
		 = (LogicalAndExpression)Expr_512_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_513_Var
		);
		final EList<? extends EObject> Expr_513_list = LogicalAndExpression_513_Var
		.getExpr();
		Assert.assertNotNull(Expr_513_list);
		Assert.assertEquals(1, Expr_513_list.size());
		//513
		final InclusiveOrExpression InclusiveOrExpression_514_Var
		 = (InclusiveOrExpression)Expr_513_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_514_Var
		);
		final EList<? extends EObject> Expr_514_list = InclusiveOrExpression_514_Var
		.getExpr();
		Assert.assertNotNull(Expr_514_list);
		Assert.assertEquals(1, Expr_514_list.size());
		//514
		final ExclusiveOrExpression ExclusiveOrExpression_515_Var
		 = (ExclusiveOrExpression)Expr_514_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_515_Var
		);
		final EList<? extends EObject> Expr_515_list = ExclusiveOrExpression_515_Var
		.getExpr();
		Assert.assertNotNull(Expr_515_list);
		Assert.assertEquals(1, Expr_515_list.size());
		//515
		final AndExpression AndExpression_516_Var
		 = (AndExpression)Expr_515_list.get(0);
		Assert.assertNotNull(AndExpression_516_Var
		);
		final EList<? extends EObject> Expr_516_list = AndExpression_516_Var
		.getExpr();
		Assert.assertNotNull(Expr_516_list);
		Assert.assertEquals(1, Expr_516_list.size());
		//516
		final EqualityExpression EqualityExpression_517_Var
		 = (EqualityExpression)Expr_516_list.get(0);
		Assert.assertNotNull(EqualityExpression_517_Var
		);
		final EList<? extends EObject> Expr_517_list = EqualityExpression_517_Var
		.getExpr();
		Assert.assertNotNull(Expr_517_list);
		Assert.assertEquals(1, Expr_517_list.size());
		//517
		final RelationalExpression RelationalExpression_518_Var
		 = (RelationalExpression)Expr_517_list.get(0);
		Assert.assertNotNull(RelationalExpression_518_Var
		);
		final EList<? extends EObject> Expr_518_list = RelationalExpression_518_Var
		.getExpr();
		Assert.assertNotNull(Expr_518_list);
		Assert.assertEquals(1, Expr_518_list.size());
		//518
		final ShiftExpression ShiftExpression_519_Var
		 = (ShiftExpression)Expr_518_list.get(0);
		Assert.assertNotNull(ShiftExpression_519_Var
		);
		final EList<? extends EObject> Expr_519_list = ShiftExpression_519_Var
		.getExpr();
		Assert.assertNotNull(Expr_519_list);
		Assert.assertEquals(1, Expr_519_list.size());
		//519
		final AdditiveExpression AdditiveExpression_520_Var
		 = (AdditiveExpression)Expr_519_list.get(0);
		Assert.assertNotNull(AdditiveExpression_520_Var
		);
		final EList<? extends EObject> Expr_520_list = AdditiveExpression_520_Var
		.getExpr();
		Assert.assertNotNull(Expr_520_list);
		Assert.assertEquals(1, Expr_520_list.size());
		//520
		final MultiplicativeExpression MultiplicativeExpression_521_Var
		 = (MultiplicativeExpression)Expr_520_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_521_Var
		);
		final EList<? extends EObject> Expr_521_list = MultiplicativeExpression_521_Var
		.getExpr();
		Assert.assertNotNull(Expr_521_list);
		Assert.assertEquals(1, Expr_521_list.size());
		//521
		final CastExpression CastExpression_522_Var
		 = (CastExpression)Expr_521_list.get(0);
		Assert.assertNotNull(CastExpression_522_Var
		);
		//522
		final UnaryExpression UnaryExpression_523_Var
		 = (UnaryExpression)CastExpression_522_Var
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
		Assert.assertEquals("[\"number.numChar(as decimal)=%d\\n\"]", PrimaryExpression_525_Var
		.getString().toString());
		//525
		final AssignmentExpression AssignmentExpression_526_Var
		 = (AssignmentExpression)Expr_509_list.get(1);
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
		Assert.assertEquals("number", PrimaryExpression_541_Var
		.getId());
		final EList<? extends EObject> Suffix_541_list = PostfixExpression_540_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_541_list);
		Assert.assertEquals(1, Suffix_541_list.size());
		//541
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_542_Var
		 = (PostfixExpressionSuffixDot)Suffix_541_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_542_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_542_Var
		.getId());
		//542
		final Statement Statement_543_Var
		 = (Statement)Statement_95_list.get(9);
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
		Assert.assertEquals("printf", PrimaryExpression_561_Var
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
		Assert.assertEquals("[\"number.numFloat=%f\\n\"]", PrimaryExpression_579_Var
		.getString().toString());
		//579
		final AssignmentExpression AssignmentExpression_580_Var
		 = (AssignmentExpression)Expr_563_list.get(1);
		Assert.assertNotNull(AssignmentExpression_580_Var
		);
		//580
		final ConditionalExpression ConditionalExpression_581_Var
		 = (ConditionalExpression)AssignmentExpression_580_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_581_Var
		);
		//581
		final LogicalOrExpression LogicalOrExpression_582_Var
		 = (LogicalOrExpression)ConditionalExpression_581_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_582_Var
		);
		final EList<? extends EObject> Expr_582_list = LogicalOrExpression_582_Var
		.getExpr();
		Assert.assertNotNull(Expr_582_list);
		Assert.assertEquals(1, Expr_582_list.size());
		//582
		final LogicalAndExpression LogicalAndExpression_583_Var
		 = (LogicalAndExpression)Expr_582_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_583_Var
		);
		final EList<? extends EObject> Expr_583_list = LogicalAndExpression_583_Var
		.getExpr();
		Assert.assertNotNull(Expr_583_list);
		Assert.assertEquals(1, Expr_583_list.size());
		//583
		final InclusiveOrExpression InclusiveOrExpression_584_Var
		 = (InclusiveOrExpression)Expr_583_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_584_Var
		);
		final EList<? extends EObject> Expr_584_list = InclusiveOrExpression_584_Var
		.getExpr();
		Assert.assertNotNull(Expr_584_list);
		Assert.assertEquals(1, Expr_584_list.size());
		//584
		final ExclusiveOrExpression ExclusiveOrExpression_585_Var
		 = (ExclusiveOrExpression)Expr_584_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_585_Var
		);
		final EList<? extends EObject> Expr_585_list = ExclusiveOrExpression_585_Var
		.getExpr();
		Assert.assertNotNull(Expr_585_list);
		Assert.assertEquals(1, Expr_585_list.size());
		//585
		final AndExpression AndExpression_586_Var
		 = (AndExpression)Expr_585_list.get(0);
		Assert.assertNotNull(AndExpression_586_Var
		);
		final EList<? extends EObject> Expr_586_list = AndExpression_586_Var
		.getExpr();
		Assert.assertNotNull(Expr_586_list);
		Assert.assertEquals(1, Expr_586_list.size());
		//586
		final EqualityExpression EqualityExpression_587_Var
		 = (EqualityExpression)Expr_586_list.get(0);
		Assert.assertNotNull(EqualityExpression_587_Var
		);
		final EList<? extends EObject> Expr_587_list = EqualityExpression_587_Var
		.getExpr();
		Assert.assertNotNull(Expr_587_list);
		Assert.assertEquals(1, Expr_587_list.size());
		//587
		final RelationalExpression RelationalExpression_588_Var
		 = (RelationalExpression)Expr_587_list.get(0);
		Assert.assertNotNull(RelationalExpression_588_Var
		);
		final EList<? extends EObject> Expr_588_list = RelationalExpression_588_Var
		.getExpr();
		Assert.assertNotNull(Expr_588_list);
		Assert.assertEquals(1, Expr_588_list.size());
		//588
		final ShiftExpression ShiftExpression_589_Var
		 = (ShiftExpression)Expr_588_list.get(0);
		Assert.assertNotNull(ShiftExpression_589_Var
		);
		final EList<? extends EObject> Expr_589_list = ShiftExpression_589_Var
		.getExpr();
		Assert.assertNotNull(Expr_589_list);
		Assert.assertEquals(1, Expr_589_list.size());
		//589
		final AdditiveExpression AdditiveExpression_590_Var
		 = (AdditiveExpression)Expr_589_list.get(0);
		Assert.assertNotNull(AdditiveExpression_590_Var
		);
		final EList<? extends EObject> Expr_590_list = AdditiveExpression_590_Var
		.getExpr();
		Assert.assertNotNull(Expr_590_list);
		Assert.assertEquals(1, Expr_590_list.size());
		//590
		final MultiplicativeExpression MultiplicativeExpression_591_Var
		 = (MultiplicativeExpression)Expr_590_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_591_Var
		);
		final EList<? extends EObject> Expr_591_list = MultiplicativeExpression_591_Var
		.getExpr();
		Assert.assertNotNull(Expr_591_list);
		Assert.assertEquals(1, Expr_591_list.size());
		//591
		final CastExpression CastExpression_592_Var
		 = (CastExpression)Expr_591_list.get(0);
		Assert.assertNotNull(CastExpression_592_Var
		);
		//592
		final UnaryExpression UnaryExpression_593_Var
		 = (UnaryExpression)CastExpression_592_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_593_Var
		);
		//593
		final PostfixExpression PostfixExpression_594_Var
		 = (PostfixExpression)UnaryExpression_593_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_594_Var
		);
		final EList<? extends EObject> Expr_594_list = PostfixExpression_594_Var
		.getExpr();
		Assert.assertNotNull(Expr_594_list);
		Assert.assertEquals(1, Expr_594_list.size());
		//594
		final PrimaryExpression PrimaryExpression_595_Var
		 = (PrimaryExpression)Expr_594_list.get(0);
		Assert.assertNotNull(PrimaryExpression_595_Var
		);
		Assert.assertEquals("number", PrimaryExpression_595_Var
		.getId());
		final EList<? extends EObject> Suffix_595_list = PostfixExpression_594_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_595_list);
		Assert.assertEquals(1, Suffix_595_list.size());
		//595
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_596_Var
		 = (PostfixExpressionSuffixDot)Suffix_595_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_596_Var
		);
		Assert.assertEquals("numFloat", PostfixExpressionSuffixDot_596_Var
		.getId());
		//596
		final Statement Statement_597_Var
		 = (Statement)Statement_95_list.get(10);
		Assert.assertNotNull(Statement_597_Var
		);
		//597
		final JumpStatement JumpStatement_598_Var
		 = (JumpStatement)Statement_597_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_598_Var
		);
		//598
		final Expression Expression_599_Var
		 = (Expression)JumpStatement_598_Var
		.getExpr();
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
		//615
		final Constant2 Constant2_616_Var
		 = (Constant2)PrimaryExpression_615_Var
		.getConst();
		Assert.assertNotNull(Constant2_616_Var
		);
		Assert.assertEquals("0", Constant2_616_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_598_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
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


