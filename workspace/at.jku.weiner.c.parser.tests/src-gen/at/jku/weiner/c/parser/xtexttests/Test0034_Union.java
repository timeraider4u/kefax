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
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
		Assert.assertEquals("[\"sizeof(number)=%lu\\n\"]", PrimaryExpression_130_Var
		.getString().toString());
		//130
		final AssignmentExpression AssignmentExpression_131_Var
		 = (AssignmentExpression)Expr_114_list.get(1);
		Assert.assertNotNull(AssignmentExpression_131_Var
		);
		//131
		final ConditionalExpression ConditionalExpression_132_Var
		 = (ConditionalExpression)AssignmentExpression_131_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_132_Var
		);
		//132
		final LogicalOrExpression LogicalOrExpression_133_Var
		 = (LogicalOrExpression)ConditionalExpression_132_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = LogicalOrExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final LogicalAndExpression LogicalAndExpression_134_Var
		 = (LogicalAndExpression)Expr_133_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = LogicalAndExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final InclusiveOrExpression InclusiveOrExpression_135_Var
		 = (InclusiveOrExpression)Expr_134_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = InclusiveOrExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final ExclusiveOrExpression ExclusiveOrExpression_136_Var
		 = (ExclusiveOrExpression)Expr_135_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = ExclusiveOrExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final AndExpression AndExpression_137_Var
		 = (AndExpression)Expr_136_list.get(0);
		Assert.assertNotNull(AndExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = AndExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final EqualityExpression EqualityExpression_138_Var
		 = (EqualityExpression)Expr_137_list.get(0);
		Assert.assertNotNull(EqualityExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = EqualityExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final RelationalExpression RelationalExpression_139_Var
		 = (RelationalExpression)Expr_138_list.get(0);
		Assert.assertNotNull(RelationalExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = RelationalExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final ShiftExpression ShiftExpression_140_Var
		 = (ShiftExpression)Expr_139_list.get(0);
		Assert.assertNotNull(ShiftExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = ShiftExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final AdditiveExpression AdditiveExpression_141_Var
		 = (AdditiveExpression)Expr_140_list.get(0);
		Assert.assertNotNull(AdditiveExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = AdditiveExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final MultiplicativeExpression MultiplicativeExpression_142_Var
		 = (MultiplicativeExpression)Expr_141_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = MultiplicativeExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final CastExpression CastExpression_143_Var
		 = (CastExpression)Expr_142_list.get(0);
		Assert.assertNotNull(CastExpression_143_Var
		);
		//143
		final UnaryExpression UnaryExpression_144_Var
		 = (UnaryExpression)CastExpression_143_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_144_Var
		);
		//144
		final PostfixExpression PostfixExpression_145_Var
		 = (PostfixExpression)UnaryExpression_144_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = PostfixExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final PrimaryExpression PrimaryExpression_146_Var
		 = (PrimaryExpression)Expr_145_list.get(0);
		Assert.assertNotNull(PrimaryExpression_146_Var
		);
		Assert.assertEquals("size", PrimaryExpression_146_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_95_Var
		.getSemi());
		//146
		final Statement Statement_147_Var
		 = (Statement)Statement_93_list.get(1);
		Assert.assertNotNull(Statement_147_Var
		);
		//147
		final ExpressionStatement ExpressionStatement_148_Var
		 = (ExpressionStatement)Statement_147_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_148_Var
		);
		//148
		final Expression Expression_149_Var
		 = (Expression)ExpressionStatement_148_Var
		.getExpression();
		Assert.assertNotNull(Expression_149_Var
		);
		final EList<? extends EObject> ExprExpr_149_list = Expression_149_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_149_list);
		Assert.assertEquals(1, ExprExpr_149_list.size());
		//149
		final AssignmentExpression AssignmentExpression_150_Var
		 = (AssignmentExpression)ExprExpr_149_list.get(0);
		Assert.assertNotNull(AssignmentExpression_150_Var
		);
		//150
		final ConditionalExpression ConditionalExpression_151_Var
		 = (ConditionalExpression)AssignmentExpression_150_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_151_Var
		);
		//151
		final LogicalOrExpression LogicalOrExpression_152_Var
		 = (LogicalOrExpression)ConditionalExpression_151_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_152_Var
		);
		final EList<? extends EObject> Expr_152_list = LogicalOrExpression_152_Var
		.getExpr();
		Assert.assertNotNull(Expr_152_list);
		Assert.assertEquals(1, Expr_152_list.size());
		//152
		final LogicalAndExpression LogicalAndExpression_153_Var
		 = (LogicalAndExpression)Expr_152_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_153_Var
		);
		final EList<? extends EObject> Expr_153_list = LogicalAndExpression_153_Var
		.getExpr();
		Assert.assertNotNull(Expr_153_list);
		Assert.assertEquals(1, Expr_153_list.size());
		//153
		final InclusiveOrExpression InclusiveOrExpression_154_Var
		 = (InclusiveOrExpression)Expr_153_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_154_Var
		);
		final EList<? extends EObject> Expr_154_list = InclusiveOrExpression_154_Var
		.getExpr();
		Assert.assertNotNull(Expr_154_list);
		Assert.assertEquals(1, Expr_154_list.size());
		//154
		final ExclusiveOrExpression ExclusiveOrExpression_155_Var
		 = (ExclusiveOrExpression)Expr_154_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_155_Var
		);
		final EList<? extends EObject> Expr_155_list = ExclusiveOrExpression_155_Var
		.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		//155
		final AndExpression AndExpression_156_Var
		 = (AndExpression)Expr_155_list.get(0);
		Assert.assertNotNull(AndExpression_156_Var
		);
		final EList<? extends EObject> Expr_156_list = AndExpression_156_Var
		.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		//156
		final EqualityExpression EqualityExpression_157_Var
		 = (EqualityExpression)Expr_156_list.get(0);
		Assert.assertNotNull(EqualityExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = EqualityExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final RelationalExpression RelationalExpression_158_Var
		 = (RelationalExpression)Expr_157_list.get(0);
		Assert.assertNotNull(RelationalExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = RelationalExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final ShiftExpression ShiftExpression_159_Var
		 = (ShiftExpression)Expr_158_list.get(0);
		Assert.assertNotNull(ShiftExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = ShiftExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final AdditiveExpression AdditiveExpression_160_Var
		 = (AdditiveExpression)Expr_159_list.get(0);
		Assert.assertNotNull(AdditiveExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = AdditiveExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final MultiplicativeExpression MultiplicativeExpression_161_Var
		 = (MultiplicativeExpression)Expr_160_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = MultiplicativeExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final CastExpression CastExpression_162_Var
		 = (CastExpression)Expr_161_list.get(0);
		Assert.assertNotNull(CastExpression_162_Var
		);
		//162
		final UnaryExpression UnaryExpression_163_Var
		 = (UnaryExpression)CastExpression_162_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_163_Var
		);
		//163
		final PostfixExpression PostfixExpression_164_Var
		 = (PostfixExpression)UnaryExpression_163_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_164_Var
		);
		final EList<? extends EObject> Expr_164_list = PostfixExpression_164_Var
		.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		//164
		final PrimaryExpression PrimaryExpression_165_Var
		 = (PrimaryExpression)Expr_164_list.get(0);
		Assert.assertNotNull(PrimaryExpression_165_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_165_Var
		.getId());
		final EList<? extends EObject> Suffix_165_list = PostfixExpression_164_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_165_list);
		Assert.assertEquals(1, Suffix_165_list.size());
		//165
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_166_Var
		 = (PostfixExpressionSuffixArgument)Suffix_165_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_166_Var
		);
		//166
		final ArgumentExpressionList ArgumentExpressionList_167_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_166_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_167_Var
		);
		final EList<? extends EObject> Expr_167_list = ArgumentExpressionList_167_Var
		.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(2, Expr_167_list.size());
		//167
		final AssignmentExpression AssignmentExpression_168_Var
		 = (AssignmentExpression)Expr_167_list.get(0);
		Assert.assertNotNull(AssignmentExpression_168_Var
		);
		//168
		final ConditionalExpression ConditionalExpression_169_Var
		 = (ConditionalExpression)AssignmentExpression_168_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_169_Var
		);
		//169
		final LogicalOrExpression LogicalOrExpression_170_Var
		 = (LogicalOrExpression)ConditionalExpression_169_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_170_Var
		);
		final EList<? extends EObject> Expr_170_list = LogicalOrExpression_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		//170
		final LogicalAndExpression LogicalAndExpression_171_Var
		 = (LogicalAndExpression)Expr_170_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_171_Var
		);
		final EList<? extends EObject> Expr_171_list = LogicalAndExpression_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		//171
		final InclusiveOrExpression InclusiveOrExpression_172_Var
		 = (InclusiveOrExpression)Expr_171_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = InclusiveOrExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final ExclusiveOrExpression ExclusiveOrExpression_173_Var
		 = (ExclusiveOrExpression)Expr_172_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = ExclusiveOrExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final AndExpression AndExpression_174_Var
		 = (AndExpression)Expr_173_list.get(0);
		Assert.assertNotNull(AndExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = AndExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final EqualityExpression EqualityExpression_175_Var
		 = (EqualityExpression)Expr_174_list.get(0);
		Assert.assertNotNull(EqualityExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = EqualityExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final RelationalExpression RelationalExpression_176_Var
		 = (RelationalExpression)Expr_175_list.get(0);
		Assert.assertNotNull(RelationalExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = RelationalExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final ShiftExpression ShiftExpression_177_Var
		 = (ShiftExpression)Expr_176_list.get(0);
		Assert.assertNotNull(ShiftExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = ShiftExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final AdditiveExpression AdditiveExpression_178_Var
		 = (AdditiveExpression)Expr_177_list.get(0);
		Assert.assertNotNull(AdditiveExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = AdditiveExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final MultiplicativeExpression MultiplicativeExpression_179_Var
		 = (MultiplicativeExpression)Expr_178_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = MultiplicativeExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final CastExpression CastExpression_180_Var
		 = (CastExpression)Expr_179_list.get(0);
		Assert.assertNotNull(CastExpression_180_Var
		);
		//180
		final UnaryExpression UnaryExpression_181_Var
		 = (UnaryExpression)CastExpression_180_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_181_Var
		);
		//181
		final PostfixExpression PostfixExpression_182_Var
		 = (PostfixExpression)UnaryExpression_181_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_182_Var
		);
		final EList<? extends EObject> Expr_182_list = PostfixExpression_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(1, Expr_182_list.size());
		//182
		final PrimaryExpression PrimaryExpression_183_Var
		 = (PrimaryExpression)Expr_182_list.get(0);
		Assert.assertNotNull(PrimaryExpression_183_Var
		);
		Assert.assertEquals("[\"sizeof(number.numChar)=%lu\\n\"]", PrimaryExpression_183_Var
		.getString().toString());
		//183
		final AssignmentExpression AssignmentExpression_184_Var
		 = (AssignmentExpression)Expr_167_list.get(1);
		Assert.assertNotNull(AssignmentExpression_184_Var
		);
		//184
		final ConditionalExpression ConditionalExpression_185_Var
		 = (ConditionalExpression)AssignmentExpression_184_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_185_Var
		);
		//185
		final LogicalOrExpression LogicalOrExpression_186_Var
		 = (LogicalOrExpression)ConditionalExpression_185_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_186_Var
		);
		final EList<? extends EObject> Expr_186_list = LogicalOrExpression_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(1, Expr_186_list.size());
		//186
		final LogicalAndExpression LogicalAndExpression_187_Var
		 = (LogicalAndExpression)Expr_186_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_187_Var
		);
		final EList<? extends EObject> Expr_187_list = LogicalAndExpression_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(1, Expr_187_list.size());
		//187
		final InclusiveOrExpression InclusiveOrExpression_188_Var
		 = (InclusiveOrExpression)Expr_187_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = InclusiveOrExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final ExclusiveOrExpression ExclusiveOrExpression_189_Var
		 = (ExclusiveOrExpression)Expr_188_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = ExclusiveOrExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final AndExpression AndExpression_190_Var
		 = (AndExpression)Expr_189_list.get(0);
		Assert.assertNotNull(AndExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = AndExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final EqualityExpression EqualityExpression_191_Var
		 = (EqualityExpression)Expr_190_list.get(0);
		Assert.assertNotNull(EqualityExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = EqualityExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final RelationalExpression RelationalExpression_192_Var
		 = (RelationalExpression)Expr_191_list.get(0);
		Assert.assertNotNull(RelationalExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = RelationalExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final ShiftExpression ShiftExpression_193_Var
		 = (ShiftExpression)Expr_192_list.get(0);
		Assert.assertNotNull(ShiftExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = ShiftExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final AdditiveExpression AdditiveExpression_194_Var
		 = (AdditiveExpression)Expr_193_list.get(0);
		Assert.assertNotNull(AdditiveExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = AdditiveExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final MultiplicativeExpression MultiplicativeExpression_195_Var
		 = (MultiplicativeExpression)Expr_194_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = MultiplicativeExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final CastExpression CastExpression_196_Var
		 = (CastExpression)Expr_195_list.get(0);
		Assert.assertNotNull(CastExpression_196_Var
		);
		//196
		final UnaryExpression UnaryExpression_197_Var
		 = (UnaryExpression)CastExpression_196_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_197_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_197_Var
		.getSizeOf());
		//197
		final UnaryExpression UnaryExpression_198_Var
		 = (UnaryExpression)UnaryExpression_197_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_198_Var
		);
		//198
		final PostfixExpression PostfixExpression_199_Var
		 = (PostfixExpression)UnaryExpression_198_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = PostfixExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final PrimaryExpression PrimaryExpression_200_Var
		 = (PrimaryExpression)Expr_199_list.get(0);
		Assert.assertNotNull(PrimaryExpression_200_Var
		);
		//200
		final Expression Expression_201_Var
		 = (Expression)PrimaryExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expression_201_Var
		);
		final EList<? extends EObject> ExprExpr_201_list = Expression_201_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_201_list);
		Assert.assertEquals(1, ExprExpr_201_list.size());
		//201
		final AssignmentExpression AssignmentExpression_202_Var
		 = (AssignmentExpression)ExprExpr_201_list.get(0);
		Assert.assertNotNull(AssignmentExpression_202_Var
		);
		//202
		final ConditionalExpression ConditionalExpression_203_Var
		 = (ConditionalExpression)AssignmentExpression_202_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_203_Var
		);
		//203
		final LogicalOrExpression LogicalOrExpression_204_Var
		 = (LogicalOrExpression)ConditionalExpression_203_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = LogicalOrExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final LogicalAndExpression LogicalAndExpression_205_Var
		 = (LogicalAndExpression)Expr_204_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = LogicalAndExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final InclusiveOrExpression InclusiveOrExpression_206_Var
		 = (InclusiveOrExpression)Expr_205_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = InclusiveOrExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final ExclusiveOrExpression ExclusiveOrExpression_207_Var
		 = (ExclusiveOrExpression)Expr_206_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = ExclusiveOrExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final AndExpression AndExpression_208_Var
		 = (AndExpression)Expr_207_list.get(0);
		Assert.assertNotNull(AndExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = AndExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final EqualityExpression EqualityExpression_209_Var
		 = (EqualityExpression)Expr_208_list.get(0);
		Assert.assertNotNull(EqualityExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = EqualityExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final RelationalExpression RelationalExpression_210_Var
		 = (RelationalExpression)Expr_209_list.get(0);
		Assert.assertNotNull(RelationalExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = RelationalExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final ShiftExpression ShiftExpression_211_Var
		 = (ShiftExpression)Expr_210_list.get(0);
		Assert.assertNotNull(ShiftExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = ShiftExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final AdditiveExpression AdditiveExpression_212_Var
		 = (AdditiveExpression)Expr_211_list.get(0);
		Assert.assertNotNull(AdditiveExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = AdditiveExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final MultiplicativeExpression MultiplicativeExpression_213_Var
		 = (MultiplicativeExpression)Expr_212_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = MultiplicativeExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final CastExpression CastExpression_214_Var
		 = (CastExpression)Expr_213_list.get(0);
		Assert.assertNotNull(CastExpression_214_Var
		);
		//214
		final UnaryExpression UnaryExpression_215_Var
		 = (UnaryExpression)CastExpression_214_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_215_Var
		);
		//215
		final PostfixExpression PostfixExpression_216_Var
		 = (PostfixExpression)UnaryExpression_215_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = PostfixExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final PrimaryExpression PrimaryExpression_217_Var
		 = (PrimaryExpression)Expr_216_list.get(0);
		Assert.assertNotNull(PrimaryExpression_217_Var
		);
		Assert.assertEquals("number", PrimaryExpression_217_Var
		.getId());
		final EList<? extends EObject> Suffix_217_list = PostfixExpression_216_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_217_list);
		Assert.assertEquals(1, Suffix_217_list.size());
		//217
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_218_Var
		 = (PostfixExpressionSuffixDot)Suffix_217_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_218_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_218_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_148_Var
		.getSemi());
		//218
		final Statement Statement_219_Var
		 = (Statement)Statement_93_list.get(2);
		Assert.assertNotNull(Statement_219_Var
		);
		//219
		final ExpressionStatement ExpressionStatement_220_Var
		 = (ExpressionStatement)Statement_219_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_220_Var
		);
		//220
		final Expression Expression_221_Var
		 = (Expression)ExpressionStatement_220_Var
		.getExpression();
		Assert.assertNotNull(Expression_221_Var
		);
		final EList<? extends EObject> ExprExpr_221_list = Expression_221_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_221_list);
		Assert.assertEquals(1, ExprExpr_221_list.size());
		//221
		final AssignmentExpression AssignmentExpression_222_Var
		 = (AssignmentExpression)ExprExpr_221_list.get(0);
		Assert.assertNotNull(AssignmentExpression_222_Var
		);
		//222
		final ConditionalExpression ConditionalExpression_223_Var
		 = (ConditionalExpression)AssignmentExpression_222_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_223_Var
		);
		//223
		final LogicalOrExpression LogicalOrExpression_224_Var
		 = (LogicalOrExpression)ConditionalExpression_223_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = LogicalOrExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final LogicalAndExpression LogicalAndExpression_225_Var
		 = (LogicalAndExpression)Expr_224_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = LogicalAndExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final InclusiveOrExpression InclusiveOrExpression_226_Var
		 = (InclusiveOrExpression)Expr_225_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = InclusiveOrExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final ExclusiveOrExpression ExclusiveOrExpression_227_Var
		 = (ExclusiveOrExpression)Expr_226_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = ExclusiveOrExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final AndExpression AndExpression_228_Var
		 = (AndExpression)Expr_227_list.get(0);
		Assert.assertNotNull(AndExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = AndExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final EqualityExpression EqualityExpression_229_Var
		 = (EqualityExpression)Expr_228_list.get(0);
		Assert.assertNotNull(EqualityExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = EqualityExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final RelationalExpression RelationalExpression_230_Var
		 = (RelationalExpression)Expr_229_list.get(0);
		Assert.assertNotNull(RelationalExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = RelationalExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final ShiftExpression ShiftExpression_231_Var
		 = (ShiftExpression)Expr_230_list.get(0);
		Assert.assertNotNull(ShiftExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = ShiftExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final AdditiveExpression AdditiveExpression_232_Var
		 = (AdditiveExpression)Expr_231_list.get(0);
		Assert.assertNotNull(AdditiveExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = AdditiveExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final MultiplicativeExpression MultiplicativeExpression_233_Var
		 = (MultiplicativeExpression)Expr_232_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = MultiplicativeExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final CastExpression CastExpression_234_Var
		 = (CastExpression)Expr_233_list.get(0);
		Assert.assertNotNull(CastExpression_234_Var
		);
		//234
		final UnaryExpression UnaryExpression_235_Var
		 = (UnaryExpression)CastExpression_234_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_235_Var
		);
		//235
		final PostfixExpression PostfixExpression_236_Var
		 = (PostfixExpression)UnaryExpression_235_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = PostfixExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final PrimaryExpression PrimaryExpression_237_Var
		 = (PrimaryExpression)Expr_236_list.get(0);
		Assert.assertNotNull(PrimaryExpression_237_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_237_Var
		.getId());
		final EList<? extends EObject> Suffix_237_list = PostfixExpression_236_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_237_list);
		Assert.assertEquals(1, Suffix_237_list.size());
		//237
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_238_Var
		 = (PostfixExpressionSuffixArgument)Suffix_237_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_238_Var
		);
		//238
		final ArgumentExpressionList ArgumentExpressionList_239_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_238_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_239_Var
		);
		final EList<? extends EObject> Expr_239_list = ArgumentExpressionList_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(2, Expr_239_list.size());
		//239
		final AssignmentExpression AssignmentExpression_240_Var
		 = (AssignmentExpression)Expr_239_list.get(0);
		Assert.assertNotNull(AssignmentExpression_240_Var
		);
		//240
		final ConditionalExpression ConditionalExpression_241_Var
		 = (ConditionalExpression)AssignmentExpression_240_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_241_Var
		);
		//241
		final LogicalOrExpression LogicalOrExpression_242_Var
		 = (LogicalOrExpression)ConditionalExpression_241_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = LogicalOrExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final LogicalAndExpression LogicalAndExpression_243_Var
		 = (LogicalAndExpression)Expr_242_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = LogicalAndExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final InclusiveOrExpression InclusiveOrExpression_244_Var
		 = (InclusiveOrExpression)Expr_243_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = InclusiveOrExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final ExclusiveOrExpression ExclusiveOrExpression_245_Var
		 = (ExclusiveOrExpression)Expr_244_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = ExclusiveOrExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final AndExpression AndExpression_246_Var
		 = (AndExpression)Expr_245_list.get(0);
		Assert.assertNotNull(AndExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = AndExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final EqualityExpression EqualityExpression_247_Var
		 = (EqualityExpression)Expr_246_list.get(0);
		Assert.assertNotNull(EqualityExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = EqualityExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final RelationalExpression RelationalExpression_248_Var
		 = (RelationalExpression)Expr_247_list.get(0);
		Assert.assertNotNull(RelationalExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = RelationalExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final ShiftExpression ShiftExpression_249_Var
		 = (ShiftExpression)Expr_248_list.get(0);
		Assert.assertNotNull(ShiftExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = ShiftExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final AdditiveExpression AdditiveExpression_250_Var
		 = (AdditiveExpression)Expr_249_list.get(0);
		Assert.assertNotNull(AdditiveExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = AdditiveExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final MultiplicativeExpression MultiplicativeExpression_251_Var
		 = (MultiplicativeExpression)Expr_250_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = MultiplicativeExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final CastExpression CastExpression_252_Var
		 = (CastExpression)Expr_251_list.get(0);
		Assert.assertNotNull(CastExpression_252_Var
		);
		//252
		final UnaryExpression UnaryExpression_253_Var
		 = (UnaryExpression)CastExpression_252_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_253_Var
		);
		//253
		final PostfixExpression PostfixExpression_254_Var
		 = (PostfixExpression)UnaryExpression_253_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = PostfixExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final PrimaryExpression PrimaryExpression_255_Var
		 = (PrimaryExpression)Expr_254_list.get(0);
		Assert.assertNotNull(PrimaryExpression_255_Var
		);
		Assert.assertEquals("[\"sizeof(float)=%lu\\n\"]", PrimaryExpression_255_Var
		.getString().toString());
		//255
		final AssignmentExpression AssignmentExpression_256_Var
		 = (AssignmentExpression)Expr_239_list.get(1);
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
		Assert.assertEquals("sizeof", UnaryExpression_269_Var
		.getSizeOf());
		//269
		final TypeName TypeName_270_Var
		 = (TypeName)UnaryExpression_269_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_270_Var
		);
		//270
		final SpecifierQualifierList SpecifierQualifierList_271_Var
		 = (SpecifierQualifierList)TypeName_270_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_271_Var
		);
		final EList<? extends EObject> TypeSpecifier_271_list = SpecifierQualifierList_271_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_271_list);
		Assert.assertEquals(1, TypeSpecifier_271_list.size());
		//271
		final TypeSpecifier TypeSpecifier_272_Var
		 = (TypeSpecifier)TypeSpecifier_271_list.get(0);
		Assert.assertNotNull(TypeSpecifier_272_Var
		);
		Assert.assertEquals("float", TypeSpecifier_272_Var
		.getName());
		Assert.assertEquals(";", ExpressionStatement_220_Var
		.getSemi());
		//272
		final Statement Statement_273_Var
		 = (Statement)Statement_93_list.get(3);
		Assert.assertNotNull(Statement_273_Var
		);
		//273
		final ExpressionStatement ExpressionStatement_274_Var
		 = (ExpressionStatement)Statement_273_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_274_Var
		);
		//274
		final Expression Expression_275_Var
		 = (Expression)ExpressionStatement_274_Var
		.getExpression();
		Assert.assertNotNull(Expression_275_Var
		);
		final EList<? extends EObject> ExprExpr_275_list = Expression_275_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_275_list);
		Assert.assertEquals(1, ExprExpr_275_list.size());
		//275
		final AssignmentExpression AssignmentExpression_276_Var
		 = (AssignmentExpression)ExprExpr_275_list.get(0);
		Assert.assertNotNull(AssignmentExpression_276_Var
		);
		//276
		final UnaryExpression UnaryExpression_277_Var
		 = (UnaryExpression)AssignmentExpression_276_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_277_Var
		);
		//277
		final PostfixExpression PostfixExpression_278_Var
		 = (PostfixExpression)UnaryExpression_277_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_278_Var
		);
		final EList<? extends EObject> Expr_278_list = PostfixExpression_278_Var
		.getExpr();
		Assert.assertNotNull(Expr_278_list);
		Assert.assertEquals(1, Expr_278_list.size());
		//278
		final PrimaryExpression PrimaryExpression_279_Var
		 = (PrimaryExpression)Expr_278_list.get(0);
		Assert.assertNotNull(PrimaryExpression_279_Var
		);
		Assert.assertEquals("number", PrimaryExpression_279_Var
		.getId());
		final EList<? extends EObject> Suffix_279_list = PostfixExpression_278_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_279_list);
		Assert.assertEquals(1, Suffix_279_list.size());
		//279
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_280_Var
		 = (PostfixExpressionSuffixDot)Suffix_279_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_280_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_280_Var
		.getId());
		//280
		final AssignmentOperator AssignmentOperator_281_Var
		 = (AssignmentOperator)AssignmentExpression_276_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_281_Var
		);
		Assert.assertEquals("=", AssignmentOperator_281_Var
		.getOp());
		//281
		final AssignmentExpression AssignmentExpression_282_Var
		 = (AssignmentExpression)AssignmentExpression_276_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_282_Var
		);
		//282
		final ConditionalExpression ConditionalExpression_283_Var
		 = (ConditionalExpression)AssignmentExpression_282_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_283_Var
		);
		//283
		final LogicalOrExpression LogicalOrExpression_284_Var
		 = (LogicalOrExpression)ConditionalExpression_283_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_284_Var
		);
		final EList<? extends EObject> Expr_284_list = LogicalOrExpression_284_Var
		.getExpr();
		Assert.assertNotNull(Expr_284_list);
		Assert.assertEquals(1, Expr_284_list.size());
		//284
		final LogicalAndExpression LogicalAndExpression_285_Var
		 = (LogicalAndExpression)Expr_284_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_285_Var
		);
		final EList<? extends EObject> Expr_285_list = LogicalAndExpression_285_Var
		.getExpr();
		Assert.assertNotNull(Expr_285_list);
		Assert.assertEquals(1, Expr_285_list.size());
		//285
		final InclusiveOrExpression InclusiveOrExpression_286_Var
		 = (InclusiveOrExpression)Expr_285_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_286_Var
		);
		final EList<? extends EObject> Expr_286_list = InclusiveOrExpression_286_Var
		.getExpr();
		Assert.assertNotNull(Expr_286_list);
		Assert.assertEquals(1, Expr_286_list.size());
		//286
		final ExclusiveOrExpression ExclusiveOrExpression_287_Var
		 = (ExclusiveOrExpression)Expr_286_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_287_Var
		);
		final EList<? extends EObject> Expr_287_list = ExclusiveOrExpression_287_Var
		.getExpr();
		Assert.assertNotNull(Expr_287_list);
		Assert.assertEquals(1, Expr_287_list.size());
		//287
		final AndExpression AndExpression_288_Var
		 = (AndExpression)Expr_287_list.get(0);
		Assert.assertNotNull(AndExpression_288_Var
		);
		final EList<? extends EObject> Expr_288_list = AndExpression_288_Var
		.getExpr();
		Assert.assertNotNull(Expr_288_list);
		Assert.assertEquals(1, Expr_288_list.size());
		//288
		final EqualityExpression EqualityExpression_289_Var
		 = (EqualityExpression)Expr_288_list.get(0);
		Assert.assertNotNull(EqualityExpression_289_Var
		);
		final EList<? extends EObject> Expr_289_list = EqualityExpression_289_Var
		.getExpr();
		Assert.assertNotNull(Expr_289_list);
		Assert.assertEquals(1, Expr_289_list.size());
		//289
		final RelationalExpression RelationalExpression_290_Var
		 = (RelationalExpression)Expr_289_list.get(0);
		Assert.assertNotNull(RelationalExpression_290_Var
		);
		final EList<? extends EObject> Expr_290_list = RelationalExpression_290_Var
		.getExpr();
		Assert.assertNotNull(Expr_290_list);
		Assert.assertEquals(1, Expr_290_list.size());
		//290
		final ShiftExpression ShiftExpression_291_Var
		 = (ShiftExpression)Expr_290_list.get(0);
		Assert.assertNotNull(ShiftExpression_291_Var
		);
		final EList<? extends EObject> Expr_291_list = ShiftExpression_291_Var
		.getExpr();
		Assert.assertNotNull(Expr_291_list);
		Assert.assertEquals(1, Expr_291_list.size());
		//291
		final AdditiveExpression AdditiveExpression_292_Var
		 = (AdditiveExpression)Expr_291_list.get(0);
		Assert.assertNotNull(AdditiveExpression_292_Var
		);
		final EList<? extends EObject> Expr_292_list = AdditiveExpression_292_Var
		.getExpr();
		Assert.assertNotNull(Expr_292_list);
		Assert.assertEquals(1, Expr_292_list.size());
		//292
		final MultiplicativeExpression MultiplicativeExpression_293_Var
		 = (MultiplicativeExpression)Expr_292_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = MultiplicativeExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final CastExpression CastExpression_294_Var
		 = (CastExpression)Expr_293_list.get(0);
		Assert.assertNotNull(CastExpression_294_Var
		);
		//294
		final UnaryExpression UnaryExpression_295_Var
		 = (UnaryExpression)CastExpression_294_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_295_Var
		);
		//295
		final PostfixExpression PostfixExpression_296_Var
		 = (PostfixExpression)UnaryExpression_295_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_296_Var
		);
		final EList<? extends EObject> Expr_296_list = PostfixExpression_296_Var
		.getExpr();
		Assert.assertNotNull(Expr_296_list);
		Assert.assertEquals(1, Expr_296_list.size());
		//296
		final PrimaryExpression PrimaryExpression_297_Var
		 = (PrimaryExpression)Expr_296_list.get(0);
		Assert.assertNotNull(PrimaryExpression_297_Var
		);
		//297
		final Constant2 Constant2_298_Var
		 = (Constant2)PrimaryExpression_297_Var
		.getConst();
		Assert.assertNotNull(Constant2_298_Var
		);
		Assert.assertEquals("65", Constant2_298_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_274_Var
		.getSemi());
		//298
		final Statement Statement_299_Var
		 = (Statement)Statement_93_list.get(4);
		Assert.assertNotNull(Statement_299_Var
		);
		//299
		final ExpressionStatement ExpressionStatement_300_Var
		 = (ExpressionStatement)Statement_299_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_300_Var
		);
		//300
		final Expression Expression_301_Var
		 = (Expression)ExpressionStatement_300_Var
		.getExpression();
		Assert.assertNotNull(Expression_301_Var
		);
		final EList<? extends EObject> ExprExpr_301_list = Expression_301_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_301_list);
		Assert.assertEquals(1, ExprExpr_301_list.size());
		//301
		final AssignmentExpression AssignmentExpression_302_Var
		 = (AssignmentExpression)ExprExpr_301_list.get(0);
		Assert.assertNotNull(AssignmentExpression_302_Var
		);
		//302
		final ConditionalExpression ConditionalExpression_303_Var
		 = (ConditionalExpression)AssignmentExpression_302_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_303_Var
		);
		//303
		final LogicalOrExpression LogicalOrExpression_304_Var
		 = (LogicalOrExpression)ConditionalExpression_303_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_304_Var
		);
		final EList<? extends EObject> Expr_304_list = LogicalOrExpression_304_Var
		.getExpr();
		Assert.assertNotNull(Expr_304_list);
		Assert.assertEquals(1, Expr_304_list.size());
		//304
		final LogicalAndExpression LogicalAndExpression_305_Var
		 = (LogicalAndExpression)Expr_304_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_305_Var
		);
		final EList<? extends EObject> Expr_305_list = LogicalAndExpression_305_Var
		.getExpr();
		Assert.assertNotNull(Expr_305_list);
		Assert.assertEquals(1, Expr_305_list.size());
		//305
		final InclusiveOrExpression InclusiveOrExpression_306_Var
		 = (InclusiveOrExpression)Expr_305_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_306_Var
		);
		final EList<? extends EObject> Expr_306_list = InclusiveOrExpression_306_Var
		.getExpr();
		Assert.assertNotNull(Expr_306_list);
		Assert.assertEquals(1, Expr_306_list.size());
		//306
		final ExclusiveOrExpression ExclusiveOrExpression_307_Var
		 = (ExclusiveOrExpression)Expr_306_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_307_Var
		);
		final EList<? extends EObject> Expr_307_list = ExclusiveOrExpression_307_Var
		.getExpr();
		Assert.assertNotNull(Expr_307_list);
		Assert.assertEquals(1, Expr_307_list.size());
		//307
		final AndExpression AndExpression_308_Var
		 = (AndExpression)Expr_307_list.get(0);
		Assert.assertNotNull(AndExpression_308_Var
		);
		final EList<? extends EObject> Expr_308_list = AndExpression_308_Var
		.getExpr();
		Assert.assertNotNull(Expr_308_list);
		Assert.assertEquals(1, Expr_308_list.size());
		//308
		final EqualityExpression EqualityExpression_309_Var
		 = (EqualityExpression)Expr_308_list.get(0);
		Assert.assertNotNull(EqualityExpression_309_Var
		);
		final EList<? extends EObject> Expr_309_list = EqualityExpression_309_Var
		.getExpr();
		Assert.assertNotNull(Expr_309_list);
		Assert.assertEquals(1, Expr_309_list.size());
		//309
		final RelationalExpression RelationalExpression_310_Var
		 = (RelationalExpression)Expr_309_list.get(0);
		Assert.assertNotNull(RelationalExpression_310_Var
		);
		final EList<? extends EObject> Expr_310_list = RelationalExpression_310_Var
		.getExpr();
		Assert.assertNotNull(Expr_310_list);
		Assert.assertEquals(1, Expr_310_list.size());
		//310
		final ShiftExpression ShiftExpression_311_Var
		 = (ShiftExpression)Expr_310_list.get(0);
		Assert.assertNotNull(ShiftExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = ShiftExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final AdditiveExpression AdditiveExpression_312_Var
		 = (AdditiveExpression)Expr_311_list.get(0);
		Assert.assertNotNull(AdditiveExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = AdditiveExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final MultiplicativeExpression MultiplicativeExpression_313_Var
		 = (MultiplicativeExpression)Expr_312_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_313_Var
		);
		final EList<? extends EObject> Expr_313_list = MultiplicativeExpression_313_Var
		.getExpr();
		Assert.assertNotNull(Expr_313_list);
		Assert.assertEquals(1, Expr_313_list.size());
		//313
		final CastExpression CastExpression_314_Var
		 = (CastExpression)Expr_313_list.get(0);
		Assert.assertNotNull(CastExpression_314_Var
		);
		//314
		final UnaryExpression UnaryExpression_315_Var
		 = (UnaryExpression)CastExpression_314_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_315_Var
		);
		//315
		final PostfixExpression PostfixExpression_316_Var
		 = (PostfixExpression)UnaryExpression_315_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_316_Var
		);
		final EList<? extends EObject> Expr_316_list = PostfixExpression_316_Var
		.getExpr();
		Assert.assertNotNull(Expr_316_list);
		Assert.assertEquals(1, Expr_316_list.size());
		//316
		final PrimaryExpression PrimaryExpression_317_Var
		 = (PrimaryExpression)Expr_316_list.get(0);
		Assert.assertNotNull(PrimaryExpression_317_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_317_Var
		.getId());
		final EList<? extends EObject> Suffix_317_list = PostfixExpression_316_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_317_list);
		Assert.assertEquals(1, Suffix_317_list.size());
		//317
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_318_Var
		 = (PostfixExpressionSuffixArgument)Suffix_317_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_318_Var
		);
		//318
		final ArgumentExpressionList ArgumentExpressionList_319_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_318_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_319_Var
		);
		final EList<? extends EObject> Expr_319_list = ArgumentExpressionList_319_Var
		.getExpr();
		Assert.assertNotNull(Expr_319_list);
		Assert.assertEquals(2, Expr_319_list.size());
		//319
		final AssignmentExpression AssignmentExpression_320_Var
		 = (AssignmentExpression)Expr_319_list.get(0);
		Assert.assertNotNull(AssignmentExpression_320_Var
		);
		//320
		final ConditionalExpression ConditionalExpression_321_Var
		 = (ConditionalExpression)AssignmentExpression_320_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_321_Var
		);
		//321
		final LogicalOrExpression LogicalOrExpression_322_Var
		 = (LogicalOrExpression)ConditionalExpression_321_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_322_Var
		);
		final EList<? extends EObject> Expr_322_list = LogicalOrExpression_322_Var
		.getExpr();
		Assert.assertNotNull(Expr_322_list);
		Assert.assertEquals(1, Expr_322_list.size());
		//322
		final LogicalAndExpression LogicalAndExpression_323_Var
		 = (LogicalAndExpression)Expr_322_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_323_Var
		);
		final EList<? extends EObject> Expr_323_list = LogicalAndExpression_323_Var
		.getExpr();
		Assert.assertNotNull(Expr_323_list);
		Assert.assertEquals(1, Expr_323_list.size());
		//323
		final InclusiveOrExpression InclusiveOrExpression_324_Var
		 = (InclusiveOrExpression)Expr_323_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_324_Var
		);
		final EList<? extends EObject> Expr_324_list = InclusiveOrExpression_324_Var
		.getExpr();
		Assert.assertNotNull(Expr_324_list);
		Assert.assertEquals(1, Expr_324_list.size());
		//324
		final ExclusiveOrExpression ExclusiveOrExpression_325_Var
		 = (ExclusiveOrExpression)Expr_324_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_325_Var
		);
		final EList<? extends EObject> Expr_325_list = ExclusiveOrExpression_325_Var
		.getExpr();
		Assert.assertNotNull(Expr_325_list);
		Assert.assertEquals(1, Expr_325_list.size());
		//325
		final AndExpression AndExpression_326_Var
		 = (AndExpression)Expr_325_list.get(0);
		Assert.assertNotNull(AndExpression_326_Var
		);
		final EList<? extends EObject> Expr_326_list = AndExpression_326_Var
		.getExpr();
		Assert.assertNotNull(Expr_326_list);
		Assert.assertEquals(1, Expr_326_list.size());
		//326
		final EqualityExpression EqualityExpression_327_Var
		 = (EqualityExpression)Expr_326_list.get(0);
		Assert.assertNotNull(EqualityExpression_327_Var
		);
		final EList<? extends EObject> Expr_327_list = EqualityExpression_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final RelationalExpression RelationalExpression_328_Var
		 = (RelationalExpression)Expr_327_list.get(0);
		Assert.assertNotNull(RelationalExpression_328_Var
		);
		final EList<? extends EObject> Expr_328_list = RelationalExpression_328_Var
		.getExpr();
		Assert.assertNotNull(Expr_328_list);
		Assert.assertEquals(1, Expr_328_list.size());
		//328
		final ShiftExpression ShiftExpression_329_Var
		 = (ShiftExpression)Expr_328_list.get(0);
		Assert.assertNotNull(ShiftExpression_329_Var
		);
		final EList<? extends EObject> Expr_329_list = ShiftExpression_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final AdditiveExpression AdditiveExpression_330_Var
		 = (AdditiveExpression)Expr_329_list.get(0);
		Assert.assertNotNull(AdditiveExpression_330_Var
		);
		final EList<? extends EObject> Expr_330_list = AdditiveExpression_330_Var
		.getExpr();
		Assert.assertNotNull(Expr_330_list);
		Assert.assertEquals(1, Expr_330_list.size());
		//330
		final MultiplicativeExpression MultiplicativeExpression_331_Var
		 = (MultiplicativeExpression)Expr_330_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = MultiplicativeExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final CastExpression CastExpression_332_Var
		 = (CastExpression)Expr_331_list.get(0);
		Assert.assertNotNull(CastExpression_332_Var
		);
		//332
		final UnaryExpression UnaryExpression_333_Var
		 = (UnaryExpression)CastExpression_332_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_333_Var
		);
		//333
		final PostfixExpression PostfixExpression_334_Var
		 = (PostfixExpression)UnaryExpression_333_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = PostfixExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final PrimaryExpression PrimaryExpression_335_Var
		 = (PrimaryExpression)Expr_334_list.get(0);
		Assert.assertNotNull(PrimaryExpression_335_Var
		);
		Assert.assertEquals("[\"number.numChar(as decimal)=%d\\n\"]", PrimaryExpression_335_Var
		.getString().toString());
		//335
		final AssignmentExpression AssignmentExpression_336_Var
		 = (AssignmentExpression)Expr_319_list.get(1);
		Assert.assertNotNull(AssignmentExpression_336_Var
		);
		//336
		final ConditionalExpression ConditionalExpression_337_Var
		 = (ConditionalExpression)AssignmentExpression_336_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_337_Var
		);
		//337
		final LogicalOrExpression LogicalOrExpression_338_Var
		 = (LogicalOrExpression)ConditionalExpression_337_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = LogicalOrExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final LogicalAndExpression LogicalAndExpression_339_Var
		 = (LogicalAndExpression)Expr_338_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_339_Var
		);
		final EList<? extends EObject> Expr_339_list = LogicalAndExpression_339_Var
		.getExpr();
		Assert.assertNotNull(Expr_339_list);
		Assert.assertEquals(1, Expr_339_list.size());
		//339
		final InclusiveOrExpression InclusiveOrExpression_340_Var
		 = (InclusiveOrExpression)Expr_339_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_340_Var
		);
		final EList<? extends EObject> Expr_340_list = InclusiveOrExpression_340_Var
		.getExpr();
		Assert.assertNotNull(Expr_340_list);
		Assert.assertEquals(1, Expr_340_list.size());
		//340
		final ExclusiveOrExpression ExclusiveOrExpression_341_Var
		 = (ExclusiveOrExpression)Expr_340_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_341_Var
		);
		final EList<? extends EObject> Expr_341_list = ExclusiveOrExpression_341_Var
		.getExpr();
		Assert.assertNotNull(Expr_341_list);
		Assert.assertEquals(1, Expr_341_list.size());
		//341
		final AndExpression AndExpression_342_Var
		 = (AndExpression)Expr_341_list.get(0);
		Assert.assertNotNull(AndExpression_342_Var
		);
		final EList<? extends EObject> Expr_342_list = AndExpression_342_Var
		.getExpr();
		Assert.assertNotNull(Expr_342_list);
		Assert.assertEquals(1, Expr_342_list.size());
		//342
		final EqualityExpression EqualityExpression_343_Var
		 = (EqualityExpression)Expr_342_list.get(0);
		Assert.assertNotNull(EqualityExpression_343_Var
		);
		final EList<? extends EObject> Expr_343_list = EqualityExpression_343_Var
		.getExpr();
		Assert.assertNotNull(Expr_343_list);
		Assert.assertEquals(1, Expr_343_list.size());
		//343
		final RelationalExpression RelationalExpression_344_Var
		 = (RelationalExpression)Expr_343_list.get(0);
		Assert.assertNotNull(RelationalExpression_344_Var
		);
		final EList<? extends EObject> Expr_344_list = RelationalExpression_344_Var
		.getExpr();
		Assert.assertNotNull(Expr_344_list);
		Assert.assertEquals(1, Expr_344_list.size());
		//344
		final ShiftExpression ShiftExpression_345_Var
		 = (ShiftExpression)Expr_344_list.get(0);
		Assert.assertNotNull(ShiftExpression_345_Var
		);
		final EList<? extends EObject> Expr_345_list = ShiftExpression_345_Var
		.getExpr();
		Assert.assertNotNull(Expr_345_list);
		Assert.assertEquals(1, Expr_345_list.size());
		//345
		final AdditiveExpression AdditiveExpression_346_Var
		 = (AdditiveExpression)Expr_345_list.get(0);
		Assert.assertNotNull(AdditiveExpression_346_Var
		);
		final EList<? extends EObject> Expr_346_list = AdditiveExpression_346_Var
		.getExpr();
		Assert.assertNotNull(Expr_346_list);
		Assert.assertEquals(1, Expr_346_list.size());
		//346
		final MultiplicativeExpression MultiplicativeExpression_347_Var
		 = (MultiplicativeExpression)Expr_346_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_347_Var
		);
		final EList<? extends EObject> Expr_347_list = MultiplicativeExpression_347_Var
		.getExpr();
		Assert.assertNotNull(Expr_347_list);
		Assert.assertEquals(1, Expr_347_list.size());
		//347
		final CastExpression CastExpression_348_Var
		 = (CastExpression)Expr_347_list.get(0);
		Assert.assertNotNull(CastExpression_348_Var
		);
		//348
		final UnaryExpression UnaryExpression_349_Var
		 = (UnaryExpression)CastExpression_348_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_349_Var
		);
		//349
		final PostfixExpression PostfixExpression_350_Var
		 = (PostfixExpression)UnaryExpression_349_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_350_Var
		);
		final EList<? extends EObject> Expr_350_list = PostfixExpression_350_Var
		.getExpr();
		Assert.assertNotNull(Expr_350_list);
		Assert.assertEquals(1, Expr_350_list.size());
		//350
		final PrimaryExpression PrimaryExpression_351_Var
		 = (PrimaryExpression)Expr_350_list.get(0);
		Assert.assertNotNull(PrimaryExpression_351_Var
		);
		Assert.assertEquals("number", PrimaryExpression_351_Var
		.getId());
		final EList<? extends EObject> Suffix_351_list = PostfixExpression_350_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_351_list);
		Assert.assertEquals(1, Suffix_351_list.size());
		//351
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_352_Var
		 = (PostfixExpressionSuffixDot)Suffix_351_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_352_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_352_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_300_Var
		.getSemi());
		//352
		final Statement Statement_353_Var
		 = (Statement)Statement_93_list.get(5);
		Assert.assertNotNull(Statement_353_Var
		);
		//353
		final ExpressionStatement ExpressionStatement_354_Var
		 = (ExpressionStatement)Statement_353_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_354_Var
		);
		//354
		final Expression Expression_355_Var
		 = (Expression)ExpressionStatement_354_Var
		.getExpression();
		Assert.assertNotNull(Expression_355_Var
		);
		final EList<? extends EObject> ExprExpr_355_list = Expression_355_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_355_list);
		Assert.assertEquals(1, ExprExpr_355_list.size());
		//355
		final AssignmentExpression AssignmentExpression_356_Var
		 = (AssignmentExpression)ExprExpr_355_list.get(0);
		Assert.assertNotNull(AssignmentExpression_356_Var
		);
		//356
		final ConditionalExpression ConditionalExpression_357_Var
		 = (ConditionalExpression)AssignmentExpression_356_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_357_Var
		);
		//357
		final LogicalOrExpression LogicalOrExpression_358_Var
		 = (LogicalOrExpression)ConditionalExpression_357_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_358_Var
		);
		final EList<? extends EObject> Expr_358_list = LogicalOrExpression_358_Var
		.getExpr();
		Assert.assertNotNull(Expr_358_list);
		Assert.assertEquals(1, Expr_358_list.size());
		//358
		final LogicalAndExpression LogicalAndExpression_359_Var
		 = (LogicalAndExpression)Expr_358_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_359_Var
		);
		final EList<? extends EObject> Expr_359_list = LogicalAndExpression_359_Var
		.getExpr();
		Assert.assertNotNull(Expr_359_list);
		Assert.assertEquals(1, Expr_359_list.size());
		//359
		final InclusiveOrExpression InclusiveOrExpression_360_Var
		 = (InclusiveOrExpression)Expr_359_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_360_Var
		);
		final EList<? extends EObject> Expr_360_list = InclusiveOrExpression_360_Var
		.getExpr();
		Assert.assertNotNull(Expr_360_list);
		Assert.assertEquals(1, Expr_360_list.size());
		//360
		final ExclusiveOrExpression ExclusiveOrExpression_361_Var
		 = (ExclusiveOrExpression)Expr_360_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_361_Var
		);
		final EList<? extends EObject> Expr_361_list = ExclusiveOrExpression_361_Var
		.getExpr();
		Assert.assertNotNull(Expr_361_list);
		Assert.assertEquals(1, Expr_361_list.size());
		//361
		final AndExpression AndExpression_362_Var
		 = (AndExpression)Expr_361_list.get(0);
		Assert.assertNotNull(AndExpression_362_Var
		);
		final EList<? extends EObject> Expr_362_list = AndExpression_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(1, Expr_362_list.size());
		//362
		final EqualityExpression EqualityExpression_363_Var
		 = (EqualityExpression)Expr_362_list.get(0);
		Assert.assertNotNull(EqualityExpression_363_Var
		);
		final EList<? extends EObject> Expr_363_list = EqualityExpression_363_Var
		.getExpr();
		Assert.assertNotNull(Expr_363_list);
		Assert.assertEquals(1, Expr_363_list.size());
		//363
		final RelationalExpression RelationalExpression_364_Var
		 = (RelationalExpression)Expr_363_list.get(0);
		Assert.assertNotNull(RelationalExpression_364_Var
		);
		final EList<? extends EObject> Expr_364_list = RelationalExpression_364_Var
		.getExpr();
		Assert.assertNotNull(Expr_364_list);
		Assert.assertEquals(1, Expr_364_list.size());
		//364
		final ShiftExpression ShiftExpression_365_Var
		 = (ShiftExpression)Expr_364_list.get(0);
		Assert.assertNotNull(ShiftExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = ShiftExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final AdditiveExpression AdditiveExpression_366_Var
		 = (AdditiveExpression)Expr_365_list.get(0);
		Assert.assertNotNull(AdditiveExpression_366_Var
		);
		final EList<? extends EObject> Expr_366_list = AdditiveExpression_366_Var
		.getExpr();
		Assert.assertNotNull(Expr_366_list);
		Assert.assertEquals(1, Expr_366_list.size());
		//366
		final MultiplicativeExpression MultiplicativeExpression_367_Var
		 = (MultiplicativeExpression)Expr_366_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_367_Var
		);
		final EList<? extends EObject> Expr_367_list = MultiplicativeExpression_367_Var
		.getExpr();
		Assert.assertNotNull(Expr_367_list);
		Assert.assertEquals(1, Expr_367_list.size());
		//367
		final CastExpression CastExpression_368_Var
		 = (CastExpression)Expr_367_list.get(0);
		Assert.assertNotNull(CastExpression_368_Var
		);
		//368
		final UnaryExpression UnaryExpression_369_Var
		 = (UnaryExpression)CastExpression_368_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_369_Var
		);
		//369
		final PostfixExpression PostfixExpression_370_Var
		 = (PostfixExpression)UnaryExpression_369_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_370_Var
		);
		final EList<? extends EObject> Expr_370_list = PostfixExpression_370_Var
		.getExpr();
		Assert.assertNotNull(Expr_370_list);
		Assert.assertEquals(1, Expr_370_list.size());
		//370
		final PrimaryExpression PrimaryExpression_371_Var
		 = (PrimaryExpression)Expr_370_list.get(0);
		Assert.assertNotNull(PrimaryExpression_371_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_371_Var
		.getId());
		final EList<? extends EObject> Suffix_371_list = PostfixExpression_370_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_371_list);
		Assert.assertEquals(1, Suffix_371_list.size());
		//371
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_372_Var
		 = (PostfixExpressionSuffixArgument)Suffix_371_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_372_Var
		);
		//372
		final ArgumentExpressionList ArgumentExpressionList_373_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_372_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_373_Var
		);
		final EList<? extends EObject> Expr_373_list = ArgumentExpressionList_373_Var
		.getExpr();
		Assert.assertNotNull(Expr_373_list);
		Assert.assertEquals(2, Expr_373_list.size());
		//373
		final AssignmentExpression AssignmentExpression_374_Var
		 = (AssignmentExpression)Expr_373_list.get(0);
		Assert.assertNotNull(AssignmentExpression_374_Var
		);
		//374
		final ConditionalExpression ConditionalExpression_375_Var
		 = (ConditionalExpression)AssignmentExpression_374_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_375_Var
		);
		//375
		final LogicalOrExpression LogicalOrExpression_376_Var
		 = (LogicalOrExpression)ConditionalExpression_375_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_376_Var
		);
		final EList<? extends EObject> Expr_376_list = LogicalOrExpression_376_Var
		.getExpr();
		Assert.assertNotNull(Expr_376_list);
		Assert.assertEquals(1, Expr_376_list.size());
		//376
		final LogicalAndExpression LogicalAndExpression_377_Var
		 = (LogicalAndExpression)Expr_376_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_377_Var
		);
		final EList<? extends EObject> Expr_377_list = LogicalAndExpression_377_Var
		.getExpr();
		Assert.assertNotNull(Expr_377_list);
		Assert.assertEquals(1, Expr_377_list.size());
		//377
		final InclusiveOrExpression InclusiveOrExpression_378_Var
		 = (InclusiveOrExpression)Expr_377_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_378_Var
		);
		final EList<? extends EObject> Expr_378_list = InclusiveOrExpression_378_Var
		.getExpr();
		Assert.assertNotNull(Expr_378_list);
		Assert.assertEquals(1, Expr_378_list.size());
		//378
		final ExclusiveOrExpression ExclusiveOrExpression_379_Var
		 = (ExclusiveOrExpression)Expr_378_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_379_Var
		);
		final EList<? extends EObject> Expr_379_list = ExclusiveOrExpression_379_Var
		.getExpr();
		Assert.assertNotNull(Expr_379_list);
		Assert.assertEquals(1, Expr_379_list.size());
		//379
		final AndExpression AndExpression_380_Var
		 = (AndExpression)Expr_379_list.get(0);
		Assert.assertNotNull(AndExpression_380_Var
		);
		final EList<? extends EObject> Expr_380_list = AndExpression_380_Var
		.getExpr();
		Assert.assertNotNull(Expr_380_list);
		Assert.assertEquals(1, Expr_380_list.size());
		//380
		final EqualityExpression EqualityExpression_381_Var
		 = (EqualityExpression)Expr_380_list.get(0);
		Assert.assertNotNull(EqualityExpression_381_Var
		);
		final EList<? extends EObject> Expr_381_list = EqualityExpression_381_Var
		.getExpr();
		Assert.assertNotNull(Expr_381_list);
		Assert.assertEquals(1, Expr_381_list.size());
		//381
		final RelationalExpression RelationalExpression_382_Var
		 = (RelationalExpression)Expr_381_list.get(0);
		Assert.assertNotNull(RelationalExpression_382_Var
		);
		final EList<? extends EObject> Expr_382_list = RelationalExpression_382_Var
		.getExpr();
		Assert.assertNotNull(Expr_382_list);
		Assert.assertEquals(1, Expr_382_list.size());
		//382
		final ShiftExpression ShiftExpression_383_Var
		 = (ShiftExpression)Expr_382_list.get(0);
		Assert.assertNotNull(ShiftExpression_383_Var
		);
		final EList<? extends EObject> Expr_383_list = ShiftExpression_383_Var
		.getExpr();
		Assert.assertNotNull(Expr_383_list);
		Assert.assertEquals(1, Expr_383_list.size());
		//383
		final AdditiveExpression AdditiveExpression_384_Var
		 = (AdditiveExpression)Expr_383_list.get(0);
		Assert.assertNotNull(AdditiveExpression_384_Var
		);
		final EList<? extends EObject> Expr_384_list = AdditiveExpression_384_Var
		.getExpr();
		Assert.assertNotNull(Expr_384_list);
		Assert.assertEquals(1, Expr_384_list.size());
		//384
		final MultiplicativeExpression MultiplicativeExpression_385_Var
		 = (MultiplicativeExpression)Expr_384_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_385_Var
		);
		final EList<? extends EObject> Expr_385_list = MultiplicativeExpression_385_Var
		.getExpr();
		Assert.assertNotNull(Expr_385_list);
		Assert.assertEquals(1, Expr_385_list.size());
		//385
		final CastExpression CastExpression_386_Var
		 = (CastExpression)Expr_385_list.get(0);
		Assert.assertNotNull(CastExpression_386_Var
		);
		//386
		final UnaryExpression UnaryExpression_387_Var
		 = (UnaryExpression)CastExpression_386_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_387_Var
		);
		//387
		final PostfixExpression PostfixExpression_388_Var
		 = (PostfixExpression)UnaryExpression_387_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_388_Var
		);
		final EList<? extends EObject> Expr_388_list = PostfixExpression_388_Var
		.getExpr();
		Assert.assertNotNull(Expr_388_list);
		Assert.assertEquals(1, Expr_388_list.size());
		//388
		final PrimaryExpression PrimaryExpression_389_Var
		 = (PrimaryExpression)Expr_388_list.get(0);
		Assert.assertNotNull(PrimaryExpression_389_Var
		);
		Assert.assertEquals("[\"number.numChar(as char)=%c\\n\"]", PrimaryExpression_389_Var
		.getString().toString());
		//389
		final AssignmentExpression AssignmentExpression_390_Var
		 = (AssignmentExpression)Expr_373_list.get(1);
		Assert.assertNotNull(AssignmentExpression_390_Var
		);
		//390
		final ConditionalExpression ConditionalExpression_391_Var
		 = (ConditionalExpression)AssignmentExpression_390_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_391_Var
		);
		//391
		final LogicalOrExpression LogicalOrExpression_392_Var
		 = (LogicalOrExpression)ConditionalExpression_391_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_392_Var
		);
		final EList<? extends EObject> Expr_392_list = LogicalOrExpression_392_Var
		.getExpr();
		Assert.assertNotNull(Expr_392_list);
		Assert.assertEquals(1, Expr_392_list.size());
		//392
		final LogicalAndExpression LogicalAndExpression_393_Var
		 = (LogicalAndExpression)Expr_392_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_393_Var
		);
		final EList<? extends EObject> Expr_393_list = LogicalAndExpression_393_Var
		.getExpr();
		Assert.assertNotNull(Expr_393_list);
		Assert.assertEquals(1, Expr_393_list.size());
		//393
		final InclusiveOrExpression InclusiveOrExpression_394_Var
		 = (InclusiveOrExpression)Expr_393_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_394_Var
		);
		final EList<? extends EObject> Expr_394_list = InclusiveOrExpression_394_Var
		.getExpr();
		Assert.assertNotNull(Expr_394_list);
		Assert.assertEquals(1, Expr_394_list.size());
		//394
		final ExclusiveOrExpression ExclusiveOrExpression_395_Var
		 = (ExclusiveOrExpression)Expr_394_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_395_Var
		);
		final EList<? extends EObject> Expr_395_list = ExclusiveOrExpression_395_Var
		.getExpr();
		Assert.assertNotNull(Expr_395_list);
		Assert.assertEquals(1, Expr_395_list.size());
		//395
		final AndExpression AndExpression_396_Var
		 = (AndExpression)Expr_395_list.get(0);
		Assert.assertNotNull(AndExpression_396_Var
		);
		final EList<? extends EObject> Expr_396_list = AndExpression_396_Var
		.getExpr();
		Assert.assertNotNull(Expr_396_list);
		Assert.assertEquals(1, Expr_396_list.size());
		//396
		final EqualityExpression EqualityExpression_397_Var
		 = (EqualityExpression)Expr_396_list.get(0);
		Assert.assertNotNull(EqualityExpression_397_Var
		);
		final EList<? extends EObject> Expr_397_list = EqualityExpression_397_Var
		.getExpr();
		Assert.assertNotNull(Expr_397_list);
		Assert.assertEquals(1, Expr_397_list.size());
		//397
		final RelationalExpression RelationalExpression_398_Var
		 = (RelationalExpression)Expr_397_list.get(0);
		Assert.assertNotNull(RelationalExpression_398_Var
		);
		final EList<? extends EObject> Expr_398_list = RelationalExpression_398_Var
		.getExpr();
		Assert.assertNotNull(Expr_398_list);
		Assert.assertEquals(1, Expr_398_list.size());
		//398
		final ShiftExpression ShiftExpression_399_Var
		 = (ShiftExpression)Expr_398_list.get(0);
		Assert.assertNotNull(ShiftExpression_399_Var
		);
		final EList<? extends EObject> Expr_399_list = ShiftExpression_399_Var
		.getExpr();
		Assert.assertNotNull(Expr_399_list);
		Assert.assertEquals(1, Expr_399_list.size());
		//399
		final AdditiveExpression AdditiveExpression_400_Var
		 = (AdditiveExpression)Expr_399_list.get(0);
		Assert.assertNotNull(AdditiveExpression_400_Var
		);
		final EList<? extends EObject> Expr_400_list = AdditiveExpression_400_Var
		.getExpr();
		Assert.assertNotNull(Expr_400_list);
		Assert.assertEquals(1, Expr_400_list.size());
		//400
		final MultiplicativeExpression MultiplicativeExpression_401_Var
		 = (MultiplicativeExpression)Expr_400_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_401_Var
		);
		final EList<? extends EObject> Expr_401_list = MultiplicativeExpression_401_Var
		.getExpr();
		Assert.assertNotNull(Expr_401_list);
		Assert.assertEquals(1, Expr_401_list.size());
		//401
		final CastExpression CastExpression_402_Var
		 = (CastExpression)Expr_401_list.get(0);
		Assert.assertNotNull(CastExpression_402_Var
		);
		//402
		final UnaryExpression UnaryExpression_403_Var
		 = (UnaryExpression)CastExpression_402_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_403_Var
		);
		//403
		final PostfixExpression PostfixExpression_404_Var
		 = (PostfixExpression)UnaryExpression_403_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_404_Var
		);
		final EList<? extends EObject> Expr_404_list = PostfixExpression_404_Var
		.getExpr();
		Assert.assertNotNull(Expr_404_list);
		Assert.assertEquals(1, Expr_404_list.size());
		//404
		final PrimaryExpression PrimaryExpression_405_Var
		 = (PrimaryExpression)Expr_404_list.get(0);
		Assert.assertNotNull(PrimaryExpression_405_Var
		);
		Assert.assertEquals("number", PrimaryExpression_405_Var
		.getId());
		final EList<? extends EObject> Suffix_405_list = PostfixExpression_404_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_405_list);
		Assert.assertEquals(1, Suffix_405_list.size());
		//405
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_406_Var
		 = (PostfixExpressionSuffixDot)Suffix_405_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_406_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_406_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_354_Var
		.getSemi());
		//406
		final Statement Statement_407_Var
		 = (Statement)Statement_93_list.get(6);
		Assert.assertNotNull(Statement_407_Var
		);
		//407
		final ExpressionStatement ExpressionStatement_408_Var
		 = (ExpressionStatement)Statement_407_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_408_Var
		);
		//408
		final Expression Expression_409_Var
		 = (Expression)ExpressionStatement_408_Var
		.getExpression();
		Assert.assertNotNull(Expression_409_Var
		);
		final EList<? extends EObject> ExprExpr_409_list = Expression_409_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_409_list);
		Assert.assertEquals(1, ExprExpr_409_list.size());
		//409
		final AssignmentExpression AssignmentExpression_410_Var
		 = (AssignmentExpression)ExprExpr_409_list.get(0);
		Assert.assertNotNull(AssignmentExpression_410_Var
		);
		//410
		final ConditionalExpression ConditionalExpression_411_Var
		 = (ConditionalExpression)AssignmentExpression_410_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_411_Var
		);
		//411
		final LogicalOrExpression LogicalOrExpression_412_Var
		 = (LogicalOrExpression)ConditionalExpression_411_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_412_Var
		);
		final EList<? extends EObject> Expr_412_list = LogicalOrExpression_412_Var
		.getExpr();
		Assert.assertNotNull(Expr_412_list);
		Assert.assertEquals(1, Expr_412_list.size());
		//412
		final LogicalAndExpression LogicalAndExpression_413_Var
		 = (LogicalAndExpression)Expr_412_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_413_Var
		);
		final EList<? extends EObject> Expr_413_list = LogicalAndExpression_413_Var
		.getExpr();
		Assert.assertNotNull(Expr_413_list);
		Assert.assertEquals(1, Expr_413_list.size());
		//413
		final InclusiveOrExpression InclusiveOrExpression_414_Var
		 = (InclusiveOrExpression)Expr_413_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_414_Var
		);
		final EList<? extends EObject> Expr_414_list = InclusiveOrExpression_414_Var
		.getExpr();
		Assert.assertNotNull(Expr_414_list);
		Assert.assertEquals(1, Expr_414_list.size());
		//414
		final ExclusiveOrExpression ExclusiveOrExpression_415_Var
		 = (ExclusiveOrExpression)Expr_414_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_415_Var
		);
		final EList<? extends EObject> Expr_415_list = ExclusiveOrExpression_415_Var
		.getExpr();
		Assert.assertNotNull(Expr_415_list);
		Assert.assertEquals(1, Expr_415_list.size());
		//415
		final AndExpression AndExpression_416_Var
		 = (AndExpression)Expr_415_list.get(0);
		Assert.assertNotNull(AndExpression_416_Var
		);
		final EList<? extends EObject> Expr_416_list = AndExpression_416_Var
		.getExpr();
		Assert.assertNotNull(Expr_416_list);
		Assert.assertEquals(1, Expr_416_list.size());
		//416
		final EqualityExpression EqualityExpression_417_Var
		 = (EqualityExpression)Expr_416_list.get(0);
		Assert.assertNotNull(EqualityExpression_417_Var
		);
		final EList<? extends EObject> Expr_417_list = EqualityExpression_417_Var
		.getExpr();
		Assert.assertNotNull(Expr_417_list);
		Assert.assertEquals(1, Expr_417_list.size());
		//417
		final RelationalExpression RelationalExpression_418_Var
		 = (RelationalExpression)Expr_417_list.get(0);
		Assert.assertNotNull(RelationalExpression_418_Var
		);
		final EList<? extends EObject> Expr_418_list = RelationalExpression_418_Var
		.getExpr();
		Assert.assertNotNull(Expr_418_list);
		Assert.assertEquals(1, Expr_418_list.size());
		//418
		final ShiftExpression ShiftExpression_419_Var
		 = (ShiftExpression)Expr_418_list.get(0);
		Assert.assertNotNull(ShiftExpression_419_Var
		);
		final EList<? extends EObject> Expr_419_list = ShiftExpression_419_Var
		.getExpr();
		Assert.assertNotNull(Expr_419_list);
		Assert.assertEquals(1, Expr_419_list.size());
		//419
		final AdditiveExpression AdditiveExpression_420_Var
		 = (AdditiveExpression)Expr_419_list.get(0);
		Assert.assertNotNull(AdditiveExpression_420_Var
		);
		final EList<? extends EObject> Expr_420_list = AdditiveExpression_420_Var
		.getExpr();
		Assert.assertNotNull(Expr_420_list);
		Assert.assertEquals(1, Expr_420_list.size());
		//420
		final MultiplicativeExpression MultiplicativeExpression_421_Var
		 = (MultiplicativeExpression)Expr_420_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_421_Var
		);
		final EList<? extends EObject> Expr_421_list = MultiplicativeExpression_421_Var
		.getExpr();
		Assert.assertNotNull(Expr_421_list);
		Assert.assertEquals(1, Expr_421_list.size());
		//421
		final CastExpression CastExpression_422_Var
		 = (CastExpression)Expr_421_list.get(0);
		Assert.assertNotNull(CastExpression_422_Var
		);
		//422
		final UnaryExpression UnaryExpression_423_Var
		 = (UnaryExpression)CastExpression_422_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_423_Var
		);
		//423
		final PostfixExpression PostfixExpression_424_Var
		 = (PostfixExpression)UnaryExpression_423_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_424_Var
		);
		final EList<? extends EObject> Expr_424_list = PostfixExpression_424_Var
		.getExpr();
		Assert.assertNotNull(Expr_424_list);
		Assert.assertEquals(1, Expr_424_list.size());
		//424
		final PrimaryExpression PrimaryExpression_425_Var
		 = (PrimaryExpression)Expr_424_list.get(0);
		Assert.assertNotNull(PrimaryExpression_425_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_425_Var
		.getId());
		final EList<? extends EObject> Suffix_425_list = PostfixExpression_424_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_425_list);
		Assert.assertEquals(1, Suffix_425_list.size());
		//425
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_426_Var
		 = (PostfixExpressionSuffixArgument)Suffix_425_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_426_Var
		);
		//426
		final ArgumentExpressionList ArgumentExpressionList_427_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_426_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_427_Var
		);
		final EList<? extends EObject> Expr_427_list = ArgumentExpressionList_427_Var
		.getExpr();
		Assert.assertNotNull(Expr_427_list);
		Assert.assertEquals(2, Expr_427_list.size());
		//427
		final AssignmentExpression AssignmentExpression_428_Var
		 = (AssignmentExpression)Expr_427_list.get(0);
		Assert.assertNotNull(AssignmentExpression_428_Var
		);
		//428
		final ConditionalExpression ConditionalExpression_429_Var
		 = (ConditionalExpression)AssignmentExpression_428_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_429_Var
		);
		//429
		final LogicalOrExpression LogicalOrExpression_430_Var
		 = (LogicalOrExpression)ConditionalExpression_429_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_430_Var
		);
		final EList<? extends EObject> Expr_430_list = LogicalOrExpression_430_Var
		.getExpr();
		Assert.assertNotNull(Expr_430_list);
		Assert.assertEquals(1, Expr_430_list.size());
		//430
		final LogicalAndExpression LogicalAndExpression_431_Var
		 = (LogicalAndExpression)Expr_430_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_431_Var
		);
		final EList<? extends EObject> Expr_431_list = LogicalAndExpression_431_Var
		.getExpr();
		Assert.assertNotNull(Expr_431_list);
		Assert.assertEquals(1, Expr_431_list.size());
		//431
		final InclusiveOrExpression InclusiveOrExpression_432_Var
		 = (InclusiveOrExpression)Expr_431_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_432_Var
		);
		final EList<? extends EObject> Expr_432_list = InclusiveOrExpression_432_Var
		.getExpr();
		Assert.assertNotNull(Expr_432_list);
		Assert.assertEquals(1, Expr_432_list.size());
		//432
		final ExclusiveOrExpression ExclusiveOrExpression_433_Var
		 = (ExclusiveOrExpression)Expr_432_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_433_Var
		);
		final EList<? extends EObject> Expr_433_list = ExclusiveOrExpression_433_Var
		.getExpr();
		Assert.assertNotNull(Expr_433_list);
		Assert.assertEquals(1, Expr_433_list.size());
		//433
		final AndExpression AndExpression_434_Var
		 = (AndExpression)Expr_433_list.get(0);
		Assert.assertNotNull(AndExpression_434_Var
		);
		final EList<? extends EObject> Expr_434_list = AndExpression_434_Var
		.getExpr();
		Assert.assertNotNull(Expr_434_list);
		Assert.assertEquals(1, Expr_434_list.size());
		//434
		final EqualityExpression EqualityExpression_435_Var
		 = (EqualityExpression)Expr_434_list.get(0);
		Assert.assertNotNull(EqualityExpression_435_Var
		);
		final EList<? extends EObject> Expr_435_list = EqualityExpression_435_Var
		.getExpr();
		Assert.assertNotNull(Expr_435_list);
		Assert.assertEquals(1, Expr_435_list.size());
		//435
		final RelationalExpression RelationalExpression_436_Var
		 = (RelationalExpression)Expr_435_list.get(0);
		Assert.assertNotNull(RelationalExpression_436_Var
		);
		final EList<? extends EObject> Expr_436_list = RelationalExpression_436_Var
		.getExpr();
		Assert.assertNotNull(Expr_436_list);
		Assert.assertEquals(1, Expr_436_list.size());
		//436
		final ShiftExpression ShiftExpression_437_Var
		 = (ShiftExpression)Expr_436_list.get(0);
		Assert.assertNotNull(ShiftExpression_437_Var
		);
		final EList<? extends EObject> Expr_437_list = ShiftExpression_437_Var
		.getExpr();
		Assert.assertNotNull(Expr_437_list);
		Assert.assertEquals(1, Expr_437_list.size());
		//437
		final AdditiveExpression AdditiveExpression_438_Var
		 = (AdditiveExpression)Expr_437_list.get(0);
		Assert.assertNotNull(AdditiveExpression_438_Var
		);
		final EList<? extends EObject> Expr_438_list = AdditiveExpression_438_Var
		.getExpr();
		Assert.assertNotNull(Expr_438_list);
		Assert.assertEquals(1, Expr_438_list.size());
		//438
		final MultiplicativeExpression MultiplicativeExpression_439_Var
		 = (MultiplicativeExpression)Expr_438_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_439_Var
		);
		final EList<? extends EObject> Expr_439_list = MultiplicativeExpression_439_Var
		.getExpr();
		Assert.assertNotNull(Expr_439_list);
		Assert.assertEquals(1, Expr_439_list.size());
		//439
		final CastExpression CastExpression_440_Var
		 = (CastExpression)Expr_439_list.get(0);
		Assert.assertNotNull(CastExpression_440_Var
		);
		//440
		final UnaryExpression UnaryExpression_441_Var
		 = (UnaryExpression)CastExpression_440_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_441_Var
		);
		//441
		final PostfixExpression PostfixExpression_442_Var
		 = (PostfixExpression)UnaryExpression_441_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_442_Var
		);
		final EList<? extends EObject> Expr_442_list = PostfixExpression_442_Var
		.getExpr();
		Assert.assertNotNull(Expr_442_list);
		Assert.assertEquals(1, Expr_442_list.size());
		//442
		final PrimaryExpression PrimaryExpression_443_Var
		 = (PrimaryExpression)Expr_442_list.get(0);
		Assert.assertNotNull(PrimaryExpression_443_Var
		);
		Assert.assertEquals("[\"number.numFloat=%f\\n\"]", PrimaryExpression_443_Var
		.getString().toString());
		//443
		final AssignmentExpression AssignmentExpression_444_Var
		 = (AssignmentExpression)Expr_427_list.get(1);
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
		Assert.assertEquals("number", PrimaryExpression_459_Var
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
		Assert.assertEquals("numFloat", PostfixExpressionSuffixDot_460_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_408_Var
		.getSemi());
		//460
		final Statement Statement_461_Var
		 = (Statement)Statement_93_list.get(7);
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
		final UnaryExpression UnaryExpression_465_Var
		 = (UnaryExpression)AssignmentExpression_464_Var
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
		//468
		final AssignmentOperator AssignmentOperator_469_Var
		 = (AssignmentOperator)AssignmentExpression_464_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_469_Var
		);
		Assert.assertEquals("=", AssignmentOperator_469_Var
		.getOp());
		//469
		final AssignmentExpression AssignmentExpression_470_Var
		 = (AssignmentExpression)AssignmentExpression_464_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_470_Var
		);
		//470
		final ConditionalExpression ConditionalExpression_471_Var
		 = (ConditionalExpression)AssignmentExpression_470_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_471_Var
		);
		//471
		final LogicalOrExpression LogicalOrExpression_472_Var
		 = (LogicalOrExpression)ConditionalExpression_471_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_472_Var
		);
		final EList<? extends EObject> Expr_472_list = LogicalOrExpression_472_Var
		.getExpr();
		Assert.assertNotNull(Expr_472_list);
		Assert.assertEquals(1, Expr_472_list.size());
		//472
		final LogicalAndExpression LogicalAndExpression_473_Var
		 = (LogicalAndExpression)Expr_472_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_473_Var
		);
		final EList<? extends EObject> Expr_473_list = LogicalAndExpression_473_Var
		.getExpr();
		Assert.assertNotNull(Expr_473_list);
		Assert.assertEquals(1, Expr_473_list.size());
		//473
		final InclusiveOrExpression InclusiveOrExpression_474_Var
		 = (InclusiveOrExpression)Expr_473_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_474_Var
		);
		final EList<? extends EObject> Expr_474_list = InclusiveOrExpression_474_Var
		.getExpr();
		Assert.assertNotNull(Expr_474_list);
		Assert.assertEquals(1, Expr_474_list.size());
		//474
		final ExclusiveOrExpression ExclusiveOrExpression_475_Var
		 = (ExclusiveOrExpression)Expr_474_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_475_Var
		);
		final EList<? extends EObject> Expr_475_list = ExclusiveOrExpression_475_Var
		.getExpr();
		Assert.assertNotNull(Expr_475_list);
		Assert.assertEquals(1, Expr_475_list.size());
		//475
		final AndExpression AndExpression_476_Var
		 = (AndExpression)Expr_475_list.get(0);
		Assert.assertNotNull(AndExpression_476_Var
		);
		final EList<? extends EObject> Expr_476_list = AndExpression_476_Var
		.getExpr();
		Assert.assertNotNull(Expr_476_list);
		Assert.assertEquals(1, Expr_476_list.size());
		//476
		final EqualityExpression EqualityExpression_477_Var
		 = (EqualityExpression)Expr_476_list.get(0);
		Assert.assertNotNull(EqualityExpression_477_Var
		);
		final EList<? extends EObject> Expr_477_list = EqualityExpression_477_Var
		.getExpr();
		Assert.assertNotNull(Expr_477_list);
		Assert.assertEquals(1, Expr_477_list.size());
		//477
		final RelationalExpression RelationalExpression_478_Var
		 = (RelationalExpression)Expr_477_list.get(0);
		Assert.assertNotNull(RelationalExpression_478_Var
		);
		final EList<? extends EObject> Expr_478_list = RelationalExpression_478_Var
		.getExpr();
		Assert.assertNotNull(Expr_478_list);
		Assert.assertEquals(1, Expr_478_list.size());
		//478
		final ShiftExpression ShiftExpression_479_Var
		 = (ShiftExpression)Expr_478_list.get(0);
		Assert.assertNotNull(ShiftExpression_479_Var
		);
		final EList<? extends EObject> Expr_479_list = ShiftExpression_479_Var
		.getExpr();
		Assert.assertNotNull(Expr_479_list);
		Assert.assertEquals(1, Expr_479_list.size());
		//479
		final AdditiveExpression AdditiveExpression_480_Var
		 = (AdditiveExpression)Expr_479_list.get(0);
		Assert.assertNotNull(AdditiveExpression_480_Var
		);
		final EList<? extends EObject> Expr_480_list = AdditiveExpression_480_Var
		.getExpr();
		Assert.assertNotNull(Expr_480_list);
		Assert.assertEquals(1, Expr_480_list.size());
		//480
		final MultiplicativeExpression MultiplicativeExpression_481_Var
		 = (MultiplicativeExpression)Expr_480_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_481_Var
		);
		final EList<? extends EObject> Expr_481_list = MultiplicativeExpression_481_Var
		.getExpr();
		Assert.assertNotNull(Expr_481_list);
		Assert.assertEquals(1, Expr_481_list.size());
		//481
		final CastExpression CastExpression_482_Var
		 = (CastExpression)Expr_481_list.get(0);
		Assert.assertNotNull(CastExpression_482_Var
		);
		//482
		final UnaryExpression UnaryExpression_483_Var
		 = (UnaryExpression)CastExpression_482_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_483_Var
		);
		//483
		final PostfixExpression PostfixExpression_484_Var
		 = (PostfixExpression)UnaryExpression_483_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_484_Var
		);
		final EList<? extends EObject> Expr_484_list = PostfixExpression_484_Var
		.getExpr();
		Assert.assertNotNull(Expr_484_list);
		Assert.assertEquals(1, Expr_484_list.size());
		//484
		final PrimaryExpression PrimaryExpression_485_Var
		 = (PrimaryExpression)Expr_484_list.get(0);
		Assert.assertNotNull(PrimaryExpression_485_Var
		);
		//485
		final Constant2 Constant2_486_Var
		 = (Constant2)PrimaryExpression_485_Var
		.getConst();
		Assert.assertNotNull(Constant2_486_Var
		);
		Assert.assertEquals("0.56789", Constant2_486_Var
		.getFloat());
		Assert.assertEquals(";", ExpressionStatement_462_Var
		.getSemi());
		//486
		final Statement Statement_487_Var
		 = (Statement)Statement_93_list.get(8);
		Assert.assertNotNull(Statement_487_Var
		);
		//487
		final ExpressionStatement ExpressionStatement_488_Var
		 = (ExpressionStatement)Statement_487_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_488_Var
		);
		//488
		final Expression Expression_489_Var
		 = (Expression)ExpressionStatement_488_Var
		.getExpression();
		Assert.assertNotNull(Expression_489_Var
		);
		final EList<? extends EObject> ExprExpr_489_list = Expression_489_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_489_list);
		Assert.assertEquals(1, ExprExpr_489_list.size());
		//489
		final AssignmentExpression AssignmentExpression_490_Var
		 = (AssignmentExpression)ExprExpr_489_list.get(0);
		Assert.assertNotNull(AssignmentExpression_490_Var
		);
		//490
		final ConditionalExpression ConditionalExpression_491_Var
		 = (ConditionalExpression)AssignmentExpression_490_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_491_Var
		);
		//491
		final LogicalOrExpression LogicalOrExpression_492_Var
		 = (LogicalOrExpression)ConditionalExpression_491_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_492_Var
		);
		final EList<? extends EObject> Expr_492_list = LogicalOrExpression_492_Var
		.getExpr();
		Assert.assertNotNull(Expr_492_list);
		Assert.assertEquals(1, Expr_492_list.size());
		//492
		final LogicalAndExpression LogicalAndExpression_493_Var
		 = (LogicalAndExpression)Expr_492_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_493_Var
		);
		final EList<? extends EObject> Expr_493_list = LogicalAndExpression_493_Var
		.getExpr();
		Assert.assertNotNull(Expr_493_list);
		Assert.assertEquals(1, Expr_493_list.size());
		//493
		final InclusiveOrExpression InclusiveOrExpression_494_Var
		 = (InclusiveOrExpression)Expr_493_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_494_Var
		);
		final EList<? extends EObject> Expr_494_list = InclusiveOrExpression_494_Var
		.getExpr();
		Assert.assertNotNull(Expr_494_list);
		Assert.assertEquals(1, Expr_494_list.size());
		//494
		final ExclusiveOrExpression ExclusiveOrExpression_495_Var
		 = (ExclusiveOrExpression)Expr_494_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_495_Var
		);
		final EList<? extends EObject> Expr_495_list = ExclusiveOrExpression_495_Var
		.getExpr();
		Assert.assertNotNull(Expr_495_list);
		Assert.assertEquals(1, Expr_495_list.size());
		//495
		final AndExpression AndExpression_496_Var
		 = (AndExpression)Expr_495_list.get(0);
		Assert.assertNotNull(AndExpression_496_Var
		);
		final EList<? extends EObject> Expr_496_list = AndExpression_496_Var
		.getExpr();
		Assert.assertNotNull(Expr_496_list);
		Assert.assertEquals(1, Expr_496_list.size());
		//496
		final EqualityExpression EqualityExpression_497_Var
		 = (EqualityExpression)Expr_496_list.get(0);
		Assert.assertNotNull(EqualityExpression_497_Var
		);
		final EList<? extends EObject> Expr_497_list = EqualityExpression_497_Var
		.getExpr();
		Assert.assertNotNull(Expr_497_list);
		Assert.assertEquals(1, Expr_497_list.size());
		//497
		final RelationalExpression RelationalExpression_498_Var
		 = (RelationalExpression)Expr_497_list.get(0);
		Assert.assertNotNull(RelationalExpression_498_Var
		);
		final EList<? extends EObject> Expr_498_list = RelationalExpression_498_Var
		.getExpr();
		Assert.assertNotNull(Expr_498_list);
		Assert.assertEquals(1, Expr_498_list.size());
		//498
		final ShiftExpression ShiftExpression_499_Var
		 = (ShiftExpression)Expr_498_list.get(0);
		Assert.assertNotNull(ShiftExpression_499_Var
		);
		final EList<? extends EObject> Expr_499_list = ShiftExpression_499_Var
		.getExpr();
		Assert.assertNotNull(Expr_499_list);
		Assert.assertEquals(1, Expr_499_list.size());
		//499
		final AdditiveExpression AdditiveExpression_500_Var
		 = (AdditiveExpression)Expr_499_list.get(0);
		Assert.assertNotNull(AdditiveExpression_500_Var
		);
		final EList<? extends EObject> Expr_500_list = AdditiveExpression_500_Var
		.getExpr();
		Assert.assertNotNull(Expr_500_list);
		Assert.assertEquals(1, Expr_500_list.size());
		//500
		final MultiplicativeExpression MultiplicativeExpression_501_Var
		 = (MultiplicativeExpression)Expr_500_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_501_Var
		);
		final EList<? extends EObject> Expr_501_list = MultiplicativeExpression_501_Var
		.getExpr();
		Assert.assertNotNull(Expr_501_list);
		Assert.assertEquals(1, Expr_501_list.size());
		//501
		final CastExpression CastExpression_502_Var
		 = (CastExpression)Expr_501_list.get(0);
		Assert.assertNotNull(CastExpression_502_Var
		);
		//502
		final UnaryExpression UnaryExpression_503_Var
		 = (UnaryExpression)CastExpression_502_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_503_Var
		);
		//503
		final PostfixExpression PostfixExpression_504_Var
		 = (PostfixExpression)UnaryExpression_503_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_504_Var
		);
		final EList<? extends EObject> Expr_504_list = PostfixExpression_504_Var
		.getExpr();
		Assert.assertNotNull(Expr_504_list);
		Assert.assertEquals(1, Expr_504_list.size());
		//504
		final PrimaryExpression PrimaryExpression_505_Var
		 = (PrimaryExpression)Expr_504_list.get(0);
		Assert.assertNotNull(PrimaryExpression_505_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_505_Var
		.getId());
		final EList<? extends EObject> Suffix_505_list = PostfixExpression_504_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_505_list);
		Assert.assertEquals(1, Suffix_505_list.size());
		//505
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_506_Var
		 = (PostfixExpressionSuffixArgument)Suffix_505_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_506_Var
		);
		//506
		final ArgumentExpressionList ArgumentExpressionList_507_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_506_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_507_Var
		);
		final EList<? extends EObject> Expr_507_list = ArgumentExpressionList_507_Var
		.getExpr();
		Assert.assertNotNull(Expr_507_list);
		Assert.assertEquals(2, Expr_507_list.size());
		//507
		final AssignmentExpression AssignmentExpression_508_Var
		 = (AssignmentExpression)Expr_507_list.get(0);
		Assert.assertNotNull(AssignmentExpression_508_Var
		);
		//508
		final ConditionalExpression ConditionalExpression_509_Var
		 = (ConditionalExpression)AssignmentExpression_508_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_509_Var
		);
		//509
		final LogicalOrExpression LogicalOrExpression_510_Var
		 = (LogicalOrExpression)ConditionalExpression_509_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_510_Var
		);
		final EList<? extends EObject> Expr_510_list = LogicalOrExpression_510_Var
		.getExpr();
		Assert.assertNotNull(Expr_510_list);
		Assert.assertEquals(1, Expr_510_list.size());
		//510
		final LogicalAndExpression LogicalAndExpression_511_Var
		 = (LogicalAndExpression)Expr_510_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_511_Var
		);
		final EList<? extends EObject> Expr_511_list = LogicalAndExpression_511_Var
		.getExpr();
		Assert.assertNotNull(Expr_511_list);
		Assert.assertEquals(1, Expr_511_list.size());
		//511
		final InclusiveOrExpression InclusiveOrExpression_512_Var
		 = (InclusiveOrExpression)Expr_511_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_512_Var
		);
		final EList<? extends EObject> Expr_512_list = InclusiveOrExpression_512_Var
		.getExpr();
		Assert.assertNotNull(Expr_512_list);
		Assert.assertEquals(1, Expr_512_list.size());
		//512
		final ExclusiveOrExpression ExclusiveOrExpression_513_Var
		 = (ExclusiveOrExpression)Expr_512_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_513_Var
		);
		final EList<? extends EObject> Expr_513_list = ExclusiveOrExpression_513_Var
		.getExpr();
		Assert.assertNotNull(Expr_513_list);
		Assert.assertEquals(1, Expr_513_list.size());
		//513
		final AndExpression AndExpression_514_Var
		 = (AndExpression)Expr_513_list.get(0);
		Assert.assertNotNull(AndExpression_514_Var
		);
		final EList<? extends EObject> Expr_514_list = AndExpression_514_Var
		.getExpr();
		Assert.assertNotNull(Expr_514_list);
		Assert.assertEquals(1, Expr_514_list.size());
		//514
		final EqualityExpression EqualityExpression_515_Var
		 = (EqualityExpression)Expr_514_list.get(0);
		Assert.assertNotNull(EqualityExpression_515_Var
		);
		final EList<? extends EObject> Expr_515_list = EqualityExpression_515_Var
		.getExpr();
		Assert.assertNotNull(Expr_515_list);
		Assert.assertEquals(1, Expr_515_list.size());
		//515
		final RelationalExpression RelationalExpression_516_Var
		 = (RelationalExpression)Expr_515_list.get(0);
		Assert.assertNotNull(RelationalExpression_516_Var
		);
		final EList<? extends EObject> Expr_516_list = RelationalExpression_516_Var
		.getExpr();
		Assert.assertNotNull(Expr_516_list);
		Assert.assertEquals(1, Expr_516_list.size());
		//516
		final ShiftExpression ShiftExpression_517_Var
		 = (ShiftExpression)Expr_516_list.get(0);
		Assert.assertNotNull(ShiftExpression_517_Var
		);
		final EList<? extends EObject> Expr_517_list = ShiftExpression_517_Var
		.getExpr();
		Assert.assertNotNull(Expr_517_list);
		Assert.assertEquals(1, Expr_517_list.size());
		//517
		final AdditiveExpression AdditiveExpression_518_Var
		 = (AdditiveExpression)Expr_517_list.get(0);
		Assert.assertNotNull(AdditiveExpression_518_Var
		);
		final EList<? extends EObject> Expr_518_list = AdditiveExpression_518_Var
		.getExpr();
		Assert.assertNotNull(Expr_518_list);
		Assert.assertEquals(1, Expr_518_list.size());
		//518
		final MultiplicativeExpression MultiplicativeExpression_519_Var
		 = (MultiplicativeExpression)Expr_518_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_519_Var
		);
		final EList<? extends EObject> Expr_519_list = MultiplicativeExpression_519_Var
		.getExpr();
		Assert.assertNotNull(Expr_519_list);
		Assert.assertEquals(1, Expr_519_list.size());
		//519
		final CastExpression CastExpression_520_Var
		 = (CastExpression)Expr_519_list.get(0);
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
		Assert.assertEquals("[\"number.numChar(as decimal)=%d\\n\"]", PrimaryExpression_523_Var
		.getString().toString());
		//523
		final AssignmentExpression AssignmentExpression_524_Var
		 = (AssignmentExpression)Expr_507_list.get(1);
		Assert.assertNotNull(AssignmentExpression_524_Var
		);
		//524
		final ConditionalExpression ConditionalExpression_525_Var
		 = (ConditionalExpression)AssignmentExpression_524_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_525_Var
		);
		//525
		final LogicalOrExpression LogicalOrExpression_526_Var
		 = (LogicalOrExpression)ConditionalExpression_525_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_526_Var
		);
		final EList<? extends EObject> Expr_526_list = LogicalOrExpression_526_Var
		.getExpr();
		Assert.assertNotNull(Expr_526_list);
		Assert.assertEquals(1, Expr_526_list.size());
		//526
		final LogicalAndExpression LogicalAndExpression_527_Var
		 = (LogicalAndExpression)Expr_526_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_527_Var
		);
		final EList<? extends EObject> Expr_527_list = LogicalAndExpression_527_Var
		.getExpr();
		Assert.assertNotNull(Expr_527_list);
		Assert.assertEquals(1, Expr_527_list.size());
		//527
		final InclusiveOrExpression InclusiveOrExpression_528_Var
		 = (InclusiveOrExpression)Expr_527_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_528_Var
		);
		final EList<? extends EObject> Expr_528_list = InclusiveOrExpression_528_Var
		.getExpr();
		Assert.assertNotNull(Expr_528_list);
		Assert.assertEquals(1, Expr_528_list.size());
		//528
		final ExclusiveOrExpression ExclusiveOrExpression_529_Var
		 = (ExclusiveOrExpression)Expr_528_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_529_Var
		);
		final EList<? extends EObject> Expr_529_list = ExclusiveOrExpression_529_Var
		.getExpr();
		Assert.assertNotNull(Expr_529_list);
		Assert.assertEquals(1, Expr_529_list.size());
		//529
		final AndExpression AndExpression_530_Var
		 = (AndExpression)Expr_529_list.get(0);
		Assert.assertNotNull(AndExpression_530_Var
		);
		final EList<? extends EObject> Expr_530_list = AndExpression_530_Var
		.getExpr();
		Assert.assertNotNull(Expr_530_list);
		Assert.assertEquals(1, Expr_530_list.size());
		//530
		final EqualityExpression EqualityExpression_531_Var
		 = (EqualityExpression)Expr_530_list.get(0);
		Assert.assertNotNull(EqualityExpression_531_Var
		);
		final EList<? extends EObject> Expr_531_list = EqualityExpression_531_Var
		.getExpr();
		Assert.assertNotNull(Expr_531_list);
		Assert.assertEquals(1, Expr_531_list.size());
		//531
		final RelationalExpression RelationalExpression_532_Var
		 = (RelationalExpression)Expr_531_list.get(0);
		Assert.assertNotNull(RelationalExpression_532_Var
		);
		final EList<? extends EObject> Expr_532_list = RelationalExpression_532_Var
		.getExpr();
		Assert.assertNotNull(Expr_532_list);
		Assert.assertEquals(1, Expr_532_list.size());
		//532
		final ShiftExpression ShiftExpression_533_Var
		 = (ShiftExpression)Expr_532_list.get(0);
		Assert.assertNotNull(ShiftExpression_533_Var
		);
		final EList<? extends EObject> Expr_533_list = ShiftExpression_533_Var
		.getExpr();
		Assert.assertNotNull(Expr_533_list);
		Assert.assertEquals(1, Expr_533_list.size());
		//533
		final AdditiveExpression AdditiveExpression_534_Var
		 = (AdditiveExpression)Expr_533_list.get(0);
		Assert.assertNotNull(AdditiveExpression_534_Var
		);
		final EList<? extends EObject> Expr_534_list = AdditiveExpression_534_Var
		.getExpr();
		Assert.assertNotNull(Expr_534_list);
		Assert.assertEquals(1, Expr_534_list.size());
		//534
		final MultiplicativeExpression MultiplicativeExpression_535_Var
		 = (MultiplicativeExpression)Expr_534_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_535_Var
		);
		final EList<? extends EObject> Expr_535_list = MultiplicativeExpression_535_Var
		.getExpr();
		Assert.assertNotNull(Expr_535_list);
		Assert.assertEquals(1, Expr_535_list.size());
		//535
		final CastExpression CastExpression_536_Var
		 = (CastExpression)Expr_535_list.get(0);
		Assert.assertNotNull(CastExpression_536_Var
		);
		//536
		final UnaryExpression UnaryExpression_537_Var
		 = (UnaryExpression)CastExpression_536_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_537_Var
		);
		//537
		final PostfixExpression PostfixExpression_538_Var
		 = (PostfixExpression)UnaryExpression_537_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_538_Var
		);
		final EList<? extends EObject> Expr_538_list = PostfixExpression_538_Var
		.getExpr();
		Assert.assertNotNull(Expr_538_list);
		Assert.assertEquals(1, Expr_538_list.size());
		//538
		final PrimaryExpression PrimaryExpression_539_Var
		 = (PrimaryExpression)Expr_538_list.get(0);
		Assert.assertNotNull(PrimaryExpression_539_Var
		);
		Assert.assertEquals("number", PrimaryExpression_539_Var
		.getId());
		final EList<? extends EObject> Suffix_539_list = PostfixExpression_538_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_539_list);
		Assert.assertEquals(1, Suffix_539_list.size());
		//539
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_540_Var
		 = (PostfixExpressionSuffixDot)Suffix_539_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_540_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_540_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_488_Var
		.getSemi());
		//540
		final Statement Statement_541_Var
		 = (Statement)Statement_93_list.get(9);
		Assert.assertNotNull(Statement_541_Var
		);
		//541
		final ExpressionStatement ExpressionStatement_542_Var
		 = (ExpressionStatement)Statement_541_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_542_Var
		);
		//542
		final Expression Expression_543_Var
		 = (Expression)ExpressionStatement_542_Var
		.getExpression();
		Assert.assertNotNull(Expression_543_Var
		);
		final EList<? extends EObject> ExprExpr_543_list = Expression_543_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_543_list);
		Assert.assertEquals(1, ExprExpr_543_list.size());
		//543
		final AssignmentExpression AssignmentExpression_544_Var
		 = (AssignmentExpression)ExprExpr_543_list.get(0);
		Assert.assertNotNull(AssignmentExpression_544_Var
		);
		//544
		final ConditionalExpression ConditionalExpression_545_Var
		 = (ConditionalExpression)AssignmentExpression_544_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_545_Var
		);
		//545
		final LogicalOrExpression LogicalOrExpression_546_Var
		 = (LogicalOrExpression)ConditionalExpression_545_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_546_Var
		);
		final EList<? extends EObject> Expr_546_list = LogicalOrExpression_546_Var
		.getExpr();
		Assert.assertNotNull(Expr_546_list);
		Assert.assertEquals(1, Expr_546_list.size());
		//546
		final LogicalAndExpression LogicalAndExpression_547_Var
		 = (LogicalAndExpression)Expr_546_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_547_Var
		);
		final EList<? extends EObject> Expr_547_list = LogicalAndExpression_547_Var
		.getExpr();
		Assert.assertNotNull(Expr_547_list);
		Assert.assertEquals(1, Expr_547_list.size());
		//547
		final InclusiveOrExpression InclusiveOrExpression_548_Var
		 = (InclusiveOrExpression)Expr_547_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_548_Var
		);
		final EList<? extends EObject> Expr_548_list = InclusiveOrExpression_548_Var
		.getExpr();
		Assert.assertNotNull(Expr_548_list);
		Assert.assertEquals(1, Expr_548_list.size());
		//548
		final ExclusiveOrExpression ExclusiveOrExpression_549_Var
		 = (ExclusiveOrExpression)Expr_548_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_549_Var
		);
		final EList<? extends EObject> Expr_549_list = ExclusiveOrExpression_549_Var
		.getExpr();
		Assert.assertNotNull(Expr_549_list);
		Assert.assertEquals(1, Expr_549_list.size());
		//549
		final AndExpression AndExpression_550_Var
		 = (AndExpression)Expr_549_list.get(0);
		Assert.assertNotNull(AndExpression_550_Var
		);
		final EList<? extends EObject> Expr_550_list = AndExpression_550_Var
		.getExpr();
		Assert.assertNotNull(Expr_550_list);
		Assert.assertEquals(1, Expr_550_list.size());
		//550
		final EqualityExpression EqualityExpression_551_Var
		 = (EqualityExpression)Expr_550_list.get(0);
		Assert.assertNotNull(EqualityExpression_551_Var
		);
		final EList<? extends EObject> Expr_551_list = EqualityExpression_551_Var
		.getExpr();
		Assert.assertNotNull(Expr_551_list);
		Assert.assertEquals(1, Expr_551_list.size());
		//551
		final RelationalExpression RelationalExpression_552_Var
		 = (RelationalExpression)Expr_551_list.get(0);
		Assert.assertNotNull(RelationalExpression_552_Var
		);
		final EList<? extends EObject> Expr_552_list = RelationalExpression_552_Var
		.getExpr();
		Assert.assertNotNull(Expr_552_list);
		Assert.assertEquals(1, Expr_552_list.size());
		//552
		final ShiftExpression ShiftExpression_553_Var
		 = (ShiftExpression)Expr_552_list.get(0);
		Assert.assertNotNull(ShiftExpression_553_Var
		);
		final EList<? extends EObject> Expr_553_list = ShiftExpression_553_Var
		.getExpr();
		Assert.assertNotNull(Expr_553_list);
		Assert.assertEquals(1, Expr_553_list.size());
		//553
		final AdditiveExpression AdditiveExpression_554_Var
		 = (AdditiveExpression)Expr_553_list.get(0);
		Assert.assertNotNull(AdditiveExpression_554_Var
		);
		final EList<? extends EObject> Expr_554_list = AdditiveExpression_554_Var
		.getExpr();
		Assert.assertNotNull(Expr_554_list);
		Assert.assertEquals(1, Expr_554_list.size());
		//554
		final MultiplicativeExpression MultiplicativeExpression_555_Var
		 = (MultiplicativeExpression)Expr_554_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_555_Var
		);
		final EList<? extends EObject> Expr_555_list = MultiplicativeExpression_555_Var
		.getExpr();
		Assert.assertNotNull(Expr_555_list);
		Assert.assertEquals(1, Expr_555_list.size());
		//555
		final CastExpression CastExpression_556_Var
		 = (CastExpression)Expr_555_list.get(0);
		Assert.assertNotNull(CastExpression_556_Var
		);
		//556
		final UnaryExpression UnaryExpression_557_Var
		 = (UnaryExpression)CastExpression_556_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_557_Var
		);
		//557
		final PostfixExpression PostfixExpression_558_Var
		 = (PostfixExpression)UnaryExpression_557_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_558_Var
		);
		final EList<? extends EObject> Expr_558_list = PostfixExpression_558_Var
		.getExpr();
		Assert.assertNotNull(Expr_558_list);
		Assert.assertEquals(1, Expr_558_list.size());
		//558
		final PrimaryExpression PrimaryExpression_559_Var
		 = (PrimaryExpression)Expr_558_list.get(0);
		Assert.assertNotNull(PrimaryExpression_559_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_559_Var
		.getId());
		final EList<? extends EObject> Suffix_559_list = PostfixExpression_558_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_559_list);
		Assert.assertEquals(1, Suffix_559_list.size());
		//559
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_560_Var
		 = (PostfixExpressionSuffixArgument)Suffix_559_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_560_Var
		);
		//560
		final ArgumentExpressionList ArgumentExpressionList_561_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_560_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_561_Var
		);
		final EList<? extends EObject> Expr_561_list = ArgumentExpressionList_561_Var
		.getExpr();
		Assert.assertNotNull(Expr_561_list);
		Assert.assertEquals(2, Expr_561_list.size());
		//561
		final AssignmentExpression AssignmentExpression_562_Var
		 = (AssignmentExpression)Expr_561_list.get(0);
		Assert.assertNotNull(AssignmentExpression_562_Var
		);
		//562
		final ConditionalExpression ConditionalExpression_563_Var
		 = (ConditionalExpression)AssignmentExpression_562_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_563_Var
		);
		//563
		final LogicalOrExpression LogicalOrExpression_564_Var
		 = (LogicalOrExpression)ConditionalExpression_563_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_564_Var
		);
		final EList<? extends EObject> Expr_564_list = LogicalOrExpression_564_Var
		.getExpr();
		Assert.assertNotNull(Expr_564_list);
		Assert.assertEquals(1, Expr_564_list.size());
		//564
		final LogicalAndExpression LogicalAndExpression_565_Var
		 = (LogicalAndExpression)Expr_564_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_565_Var
		);
		final EList<? extends EObject> Expr_565_list = LogicalAndExpression_565_Var
		.getExpr();
		Assert.assertNotNull(Expr_565_list);
		Assert.assertEquals(1, Expr_565_list.size());
		//565
		final InclusiveOrExpression InclusiveOrExpression_566_Var
		 = (InclusiveOrExpression)Expr_565_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_566_Var
		);
		final EList<? extends EObject> Expr_566_list = InclusiveOrExpression_566_Var
		.getExpr();
		Assert.assertNotNull(Expr_566_list);
		Assert.assertEquals(1, Expr_566_list.size());
		//566
		final ExclusiveOrExpression ExclusiveOrExpression_567_Var
		 = (ExclusiveOrExpression)Expr_566_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_567_Var
		);
		final EList<? extends EObject> Expr_567_list = ExclusiveOrExpression_567_Var
		.getExpr();
		Assert.assertNotNull(Expr_567_list);
		Assert.assertEquals(1, Expr_567_list.size());
		//567
		final AndExpression AndExpression_568_Var
		 = (AndExpression)Expr_567_list.get(0);
		Assert.assertNotNull(AndExpression_568_Var
		);
		final EList<? extends EObject> Expr_568_list = AndExpression_568_Var
		.getExpr();
		Assert.assertNotNull(Expr_568_list);
		Assert.assertEquals(1, Expr_568_list.size());
		//568
		final EqualityExpression EqualityExpression_569_Var
		 = (EqualityExpression)Expr_568_list.get(0);
		Assert.assertNotNull(EqualityExpression_569_Var
		);
		final EList<? extends EObject> Expr_569_list = EqualityExpression_569_Var
		.getExpr();
		Assert.assertNotNull(Expr_569_list);
		Assert.assertEquals(1, Expr_569_list.size());
		//569
		final RelationalExpression RelationalExpression_570_Var
		 = (RelationalExpression)Expr_569_list.get(0);
		Assert.assertNotNull(RelationalExpression_570_Var
		);
		final EList<? extends EObject> Expr_570_list = RelationalExpression_570_Var
		.getExpr();
		Assert.assertNotNull(Expr_570_list);
		Assert.assertEquals(1, Expr_570_list.size());
		//570
		final ShiftExpression ShiftExpression_571_Var
		 = (ShiftExpression)Expr_570_list.get(0);
		Assert.assertNotNull(ShiftExpression_571_Var
		);
		final EList<? extends EObject> Expr_571_list = ShiftExpression_571_Var
		.getExpr();
		Assert.assertNotNull(Expr_571_list);
		Assert.assertEquals(1, Expr_571_list.size());
		//571
		final AdditiveExpression AdditiveExpression_572_Var
		 = (AdditiveExpression)Expr_571_list.get(0);
		Assert.assertNotNull(AdditiveExpression_572_Var
		);
		final EList<? extends EObject> Expr_572_list = AdditiveExpression_572_Var
		.getExpr();
		Assert.assertNotNull(Expr_572_list);
		Assert.assertEquals(1, Expr_572_list.size());
		//572
		final MultiplicativeExpression MultiplicativeExpression_573_Var
		 = (MultiplicativeExpression)Expr_572_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_573_Var
		);
		final EList<? extends EObject> Expr_573_list = MultiplicativeExpression_573_Var
		.getExpr();
		Assert.assertNotNull(Expr_573_list);
		Assert.assertEquals(1, Expr_573_list.size());
		//573
		final CastExpression CastExpression_574_Var
		 = (CastExpression)Expr_573_list.get(0);
		Assert.assertNotNull(CastExpression_574_Var
		);
		//574
		final UnaryExpression UnaryExpression_575_Var
		 = (UnaryExpression)CastExpression_574_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_575_Var
		);
		//575
		final PostfixExpression PostfixExpression_576_Var
		 = (PostfixExpression)UnaryExpression_575_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_576_Var
		);
		final EList<? extends EObject> Expr_576_list = PostfixExpression_576_Var
		.getExpr();
		Assert.assertNotNull(Expr_576_list);
		Assert.assertEquals(1, Expr_576_list.size());
		//576
		final PrimaryExpression PrimaryExpression_577_Var
		 = (PrimaryExpression)Expr_576_list.get(0);
		Assert.assertNotNull(PrimaryExpression_577_Var
		);
		Assert.assertEquals("[\"number.numFloat=%f\\n\"]", PrimaryExpression_577_Var
		.getString().toString());
		//577
		final AssignmentExpression AssignmentExpression_578_Var
		 = (AssignmentExpression)Expr_561_list.get(1);
		Assert.assertNotNull(AssignmentExpression_578_Var
		);
		//578
		final ConditionalExpression ConditionalExpression_579_Var
		 = (ConditionalExpression)AssignmentExpression_578_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_579_Var
		);
		//579
		final LogicalOrExpression LogicalOrExpression_580_Var
		 = (LogicalOrExpression)ConditionalExpression_579_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_580_Var
		);
		final EList<? extends EObject> Expr_580_list = LogicalOrExpression_580_Var
		.getExpr();
		Assert.assertNotNull(Expr_580_list);
		Assert.assertEquals(1, Expr_580_list.size());
		//580
		final LogicalAndExpression LogicalAndExpression_581_Var
		 = (LogicalAndExpression)Expr_580_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_581_Var
		);
		final EList<? extends EObject> Expr_581_list = LogicalAndExpression_581_Var
		.getExpr();
		Assert.assertNotNull(Expr_581_list);
		Assert.assertEquals(1, Expr_581_list.size());
		//581
		final InclusiveOrExpression InclusiveOrExpression_582_Var
		 = (InclusiveOrExpression)Expr_581_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_582_Var
		);
		final EList<? extends EObject> Expr_582_list = InclusiveOrExpression_582_Var
		.getExpr();
		Assert.assertNotNull(Expr_582_list);
		Assert.assertEquals(1, Expr_582_list.size());
		//582
		final ExclusiveOrExpression ExclusiveOrExpression_583_Var
		 = (ExclusiveOrExpression)Expr_582_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_583_Var
		);
		final EList<? extends EObject> Expr_583_list = ExclusiveOrExpression_583_Var
		.getExpr();
		Assert.assertNotNull(Expr_583_list);
		Assert.assertEquals(1, Expr_583_list.size());
		//583
		final AndExpression AndExpression_584_Var
		 = (AndExpression)Expr_583_list.get(0);
		Assert.assertNotNull(AndExpression_584_Var
		);
		final EList<? extends EObject> Expr_584_list = AndExpression_584_Var
		.getExpr();
		Assert.assertNotNull(Expr_584_list);
		Assert.assertEquals(1, Expr_584_list.size());
		//584
		final EqualityExpression EqualityExpression_585_Var
		 = (EqualityExpression)Expr_584_list.get(0);
		Assert.assertNotNull(EqualityExpression_585_Var
		);
		final EList<? extends EObject> Expr_585_list = EqualityExpression_585_Var
		.getExpr();
		Assert.assertNotNull(Expr_585_list);
		Assert.assertEquals(1, Expr_585_list.size());
		//585
		final RelationalExpression RelationalExpression_586_Var
		 = (RelationalExpression)Expr_585_list.get(0);
		Assert.assertNotNull(RelationalExpression_586_Var
		);
		final EList<? extends EObject> Expr_586_list = RelationalExpression_586_Var
		.getExpr();
		Assert.assertNotNull(Expr_586_list);
		Assert.assertEquals(1, Expr_586_list.size());
		//586
		final ShiftExpression ShiftExpression_587_Var
		 = (ShiftExpression)Expr_586_list.get(0);
		Assert.assertNotNull(ShiftExpression_587_Var
		);
		final EList<? extends EObject> Expr_587_list = ShiftExpression_587_Var
		.getExpr();
		Assert.assertNotNull(Expr_587_list);
		Assert.assertEquals(1, Expr_587_list.size());
		//587
		final AdditiveExpression AdditiveExpression_588_Var
		 = (AdditiveExpression)Expr_587_list.get(0);
		Assert.assertNotNull(AdditiveExpression_588_Var
		);
		final EList<? extends EObject> Expr_588_list = AdditiveExpression_588_Var
		.getExpr();
		Assert.assertNotNull(Expr_588_list);
		Assert.assertEquals(1, Expr_588_list.size());
		//588
		final MultiplicativeExpression MultiplicativeExpression_589_Var
		 = (MultiplicativeExpression)Expr_588_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_589_Var
		);
		final EList<? extends EObject> Expr_589_list = MultiplicativeExpression_589_Var
		.getExpr();
		Assert.assertNotNull(Expr_589_list);
		Assert.assertEquals(1, Expr_589_list.size());
		//589
		final CastExpression CastExpression_590_Var
		 = (CastExpression)Expr_589_list.get(0);
		Assert.assertNotNull(CastExpression_590_Var
		);
		//590
		final UnaryExpression UnaryExpression_591_Var
		 = (UnaryExpression)CastExpression_590_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_591_Var
		);
		//591
		final PostfixExpression PostfixExpression_592_Var
		 = (PostfixExpression)UnaryExpression_591_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_592_Var
		);
		final EList<? extends EObject> Expr_592_list = PostfixExpression_592_Var
		.getExpr();
		Assert.assertNotNull(Expr_592_list);
		Assert.assertEquals(1, Expr_592_list.size());
		//592
		final PrimaryExpression PrimaryExpression_593_Var
		 = (PrimaryExpression)Expr_592_list.get(0);
		Assert.assertNotNull(PrimaryExpression_593_Var
		);
		Assert.assertEquals("number", PrimaryExpression_593_Var
		.getId());
		final EList<? extends EObject> Suffix_593_list = PostfixExpression_592_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_593_list);
		Assert.assertEquals(1, Suffix_593_list.size());
		//593
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_594_Var
		 = (PostfixExpressionSuffixDot)Suffix_593_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_594_Var
		);
		Assert.assertEquals("numFloat", PostfixExpressionSuffixDot_594_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_542_Var
		.getSemi());
		//594
		final Statement Statement_595_Var
		 = (Statement)Statement_93_list.get(10);
		Assert.assertNotNull(Statement_595_Var
		);
		//595
		final JumpStatement JumpStatement_596_Var
		 = (JumpStatement)Statement_595_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_596_Var
		);
		//596
		final Expression Expression_597_Var
		 = (Expression)JumpStatement_596_Var
		.getExpr();
		Assert.assertNotNull(Expression_597_Var
		);
		final EList<? extends EObject> ExprExpr_597_list = Expression_597_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_597_list);
		Assert.assertEquals(1, ExprExpr_597_list.size());
		//597
		final AssignmentExpression AssignmentExpression_598_Var
		 = (AssignmentExpression)ExprExpr_597_list.get(0);
		Assert.assertNotNull(AssignmentExpression_598_Var
		);
		//598
		final ConditionalExpression ConditionalExpression_599_Var
		 = (ConditionalExpression)AssignmentExpression_598_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_599_Var
		);
		//599
		final LogicalOrExpression LogicalOrExpression_600_Var
		 = (LogicalOrExpression)ConditionalExpression_599_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_600_Var
		);
		final EList<? extends EObject> Expr_600_list = LogicalOrExpression_600_Var
		.getExpr();
		Assert.assertNotNull(Expr_600_list);
		Assert.assertEquals(1, Expr_600_list.size());
		//600
		final LogicalAndExpression LogicalAndExpression_601_Var
		 = (LogicalAndExpression)Expr_600_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_601_Var
		);
		final EList<? extends EObject> Expr_601_list = LogicalAndExpression_601_Var
		.getExpr();
		Assert.assertNotNull(Expr_601_list);
		Assert.assertEquals(1, Expr_601_list.size());
		//601
		final InclusiveOrExpression InclusiveOrExpression_602_Var
		 = (InclusiveOrExpression)Expr_601_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_602_Var
		);
		final EList<? extends EObject> Expr_602_list = InclusiveOrExpression_602_Var
		.getExpr();
		Assert.assertNotNull(Expr_602_list);
		Assert.assertEquals(1, Expr_602_list.size());
		//602
		final ExclusiveOrExpression ExclusiveOrExpression_603_Var
		 = (ExclusiveOrExpression)Expr_602_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_603_Var
		);
		final EList<? extends EObject> Expr_603_list = ExclusiveOrExpression_603_Var
		.getExpr();
		Assert.assertNotNull(Expr_603_list);
		Assert.assertEquals(1, Expr_603_list.size());
		//603
		final AndExpression AndExpression_604_Var
		 = (AndExpression)Expr_603_list.get(0);
		Assert.assertNotNull(AndExpression_604_Var
		);
		final EList<? extends EObject> Expr_604_list = AndExpression_604_Var
		.getExpr();
		Assert.assertNotNull(Expr_604_list);
		Assert.assertEquals(1, Expr_604_list.size());
		//604
		final EqualityExpression EqualityExpression_605_Var
		 = (EqualityExpression)Expr_604_list.get(0);
		Assert.assertNotNull(EqualityExpression_605_Var
		);
		final EList<? extends EObject> Expr_605_list = EqualityExpression_605_Var
		.getExpr();
		Assert.assertNotNull(Expr_605_list);
		Assert.assertEquals(1, Expr_605_list.size());
		//605
		final RelationalExpression RelationalExpression_606_Var
		 = (RelationalExpression)Expr_605_list.get(0);
		Assert.assertNotNull(RelationalExpression_606_Var
		);
		final EList<? extends EObject> Expr_606_list = RelationalExpression_606_Var
		.getExpr();
		Assert.assertNotNull(Expr_606_list);
		Assert.assertEquals(1, Expr_606_list.size());
		//606
		final ShiftExpression ShiftExpression_607_Var
		 = (ShiftExpression)Expr_606_list.get(0);
		Assert.assertNotNull(ShiftExpression_607_Var
		);
		final EList<? extends EObject> Expr_607_list = ShiftExpression_607_Var
		.getExpr();
		Assert.assertNotNull(Expr_607_list);
		Assert.assertEquals(1, Expr_607_list.size());
		//607
		final AdditiveExpression AdditiveExpression_608_Var
		 = (AdditiveExpression)Expr_607_list.get(0);
		Assert.assertNotNull(AdditiveExpression_608_Var
		);
		final EList<? extends EObject> Expr_608_list = AdditiveExpression_608_Var
		.getExpr();
		Assert.assertNotNull(Expr_608_list);
		Assert.assertEquals(1, Expr_608_list.size());
		//608
		final MultiplicativeExpression MultiplicativeExpression_609_Var
		 = (MultiplicativeExpression)Expr_608_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_609_Var
		);
		final EList<? extends EObject> Expr_609_list = MultiplicativeExpression_609_Var
		.getExpr();
		Assert.assertNotNull(Expr_609_list);
		Assert.assertEquals(1, Expr_609_list.size());
		//609
		final CastExpression CastExpression_610_Var
		 = (CastExpression)Expr_609_list.get(0);
		Assert.assertNotNull(CastExpression_610_Var
		);
		//610
		final UnaryExpression UnaryExpression_611_Var
		 = (UnaryExpression)CastExpression_610_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_611_Var
		);
		//611
		final PostfixExpression PostfixExpression_612_Var
		 = (PostfixExpression)UnaryExpression_611_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_612_Var
		);
		final EList<? extends EObject> Expr_612_list = PostfixExpression_612_Var
		.getExpr();
		Assert.assertNotNull(Expr_612_list);
		Assert.assertEquals(1, Expr_612_list.size());
		//612
		final PrimaryExpression PrimaryExpression_613_Var
		 = (PrimaryExpression)Expr_612_list.get(0);
		Assert.assertNotNull(PrimaryExpression_613_Var
		);
		//613
		final Constant2 Constant2_614_Var
		 = (Constant2)PrimaryExpression_613_Var
		.getConst();
		Assert.assertNotNull(Constant2_614_Var
		);
		Assert.assertEquals("0", Constant2_614_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_596_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_596_Var
		.getSemi());
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


