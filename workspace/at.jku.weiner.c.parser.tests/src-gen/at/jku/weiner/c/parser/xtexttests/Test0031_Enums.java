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
import at.jku.weiner.c.parser.parser.TypeQualifier;
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
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
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
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.EnumSpecifier;
import at.jku.weiner.c.parser.parser.EnumeratorList;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.ConstantExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.EnumSpecifier;
import at.jku.weiner.c.parser.parser.EnumeratorList;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.ConstantExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.EnumSpecifier;
import at.jku.weiner.c.parser.parser.EnumeratorList;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.ConstantExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.EnumSpecifier;
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
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
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
public class Test0031_Enums {
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
			"res/Test0031_Enums.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_LINEDIRECTIVE", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_CONST", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_ENUM", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_ASSIGN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_RIGHTBRACE", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_ENUM", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_ASSIGN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_RIGHTBRACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_ENUM", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_ASSIGN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_RIGHTBRACE", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_KW_ENUM", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
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
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
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
			"res/Test0031_Enums.c");
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
		Assert.assertEquals(6, External_0_list.size());
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
		final TypeQualifier TypeQualifier_4_Var
		 = (TypeQualifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(TypeQualifier_4_Var
		);
		Assert.assertEquals("const", TypeQualifier_4_Var
		.getType());
		//4
		final TypeSpecifier TypeSpecifier_5_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(1);
		Assert.assertNotNull(TypeSpecifier_5_Var
		);
		Assert.assertEquals("int", TypeSpecifier_5_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_5_list = Declaration_2_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_5_list);
		Assert.assertEquals(1, InitDeclaratorList_5_list.size());
		//5
		final InitDeclaratorList InitDeclaratorList_6_Var
		 = (InitDeclaratorList)InitDeclaratorList_5_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_6_Var
		);
		final EList<? extends EObject> InitDeclarator_6_list = InitDeclaratorList_6_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_6_list);
		Assert.assertEquals(7, InitDeclarator_6_list.size());
		//6
		final InitDeclarator InitDeclarator_7_Var
		 = (InitDeclarator)InitDeclarator_6_list.get(0);
		Assert.assertNotNull(InitDeclarator_7_Var
		);
		//7
		final Declarator Declarator_8_Var
		 = (Declarator)InitDeclarator_7_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_8_Var
		);
		//8
		final DirectDeclarator DirectDeclarator_9_Var
		 = (DirectDeclarator)Declarator_8_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_9_Var
		);
		Assert.assertEquals("W_MONDAY", DirectDeclarator_9_Var
		.getId());
		//9
		final Initializer Initializer_10_Var
		 = (Initializer)InitDeclarator_7_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_10_Var
		);
		//10
		final AssignmentExpression AssignmentExpression_11_Var
		 = (AssignmentExpression)Initializer_10_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_11_Var
		);
		//11
		final ConditionalExpression ConditionalExpression_12_Var
		 = (ConditionalExpression)AssignmentExpression_11_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_12_Var
		);
		//12
		final LogicalOrExpression LogicalOrExpression_13_Var
		 = (LogicalOrExpression)ConditionalExpression_12_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_13_Var
		);
		final EList<? extends EObject> Expr_13_list = LogicalOrExpression_13_Var
		.getExpr();
		Assert.assertNotNull(Expr_13_list);
		Assert.assertEquals(1, Expr_13_list.size());
		//13
		final LogicalAndExpression LogicalAndExpression_14_Var
		 = (LogicalAndExpression)Expr_13_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = LogicalAndExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		//14
		final InclusiveOrExpression InclusiveOrExpression_15_Var
		 = (InclusiveOrExpression)Expr_14_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = InclusiveOrExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final ExclusiveOrExpression ExclusiveOrExpression_16_Var
		 = (ExclusiveOrExpression)Expr_15_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = ExclusiveOrExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final AndExpression AndExpression_17_Var
		 = (AndExpression)Expr_16_list.get(0);
		Assert.assertNotNull(AndExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = AndExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final EqualityExpression EqualityExpression_18_Var
		 = (EqualityExpression)Expr_17_list.get(0);
		Assert.assertNotNull(EqualityExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = EqualityExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final RelationalExpression RelationalExpression_19_Var
		 = (RelationalExpression)Expr_18_list.get(0);
		Assert.assertNotNull(RelationalExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = RelationalExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final ShiftExpression ShiftExpression_20_Var
		 = (ShiftExpression)Expr_19_list.get(0);
		Assert.assertNotNull(ShiftExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = ShiftExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final AdditiveExpression AdditiveExpression_21_Var
		 = (AdditiveExpression)Expr_20_list.get(0);
		Assert.assertNotNull(AdditiveExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = AdditiveExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final MultiplicativeExpression MultiplicativeExpression_22_Var
		 = (MultiplicativeExpression)Expr_21_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = MultiplicativeExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final CastExpression CastExpression_23_Var
		 = (CastExpression)Expr_22_list.get(0);
		Assert.assertNotNull(CastExpression_23_Var
		);
		//23
		final UnaryExpression UnaryExpression_24_Var
		 = (UnaryExpression)CastExpression_23_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_24_Var
		);
		//24
		final PostfixExpression PostfixExpression_25_Var
		 = (PostfixExpression)UnaryExpression_24_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = PostfixExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final PrimaryExpression PrimaryExpression_26_Var
		 = (PrimaryExpression)Expr_25_list.get(0);
		Assert.assertNotNull(PrimaryExpression_26_Var
		);
		//26
		final Constant2 Constant2_27_Var
		 = (Constant2)PrimaryExpression_26_Var
		.getConst();
		Assert.assertNotNull(Constant2_27_Var
		);
		Assert.assertEquals("1", Constant2_27_Var
		.getDec());
		//27
		final InitDeclarator InitDeclarator_28_Var
		 = (InitDeclarator)InitDeclarator_6_list.get(1);
		Assert.assertNotNull(InitDeclarator_28_Var
		);
		//28
		final Declarator Declarator_29_Var
		 = (Declarator)InitDeclarator_28_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_29_Var
		);
		//29
		final DirectDeclarator DirectDeclarator_30_Var
		 = (DirectDeclarator)Declarator_29_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_30_Var
		);
		Assert.assertEquals("W_TUESDAY", DirectDeclarator_30_Var
		.getId());
		//30
		final Initializer Initializer_31_Var
		 = (Initializer)InitDeclarator_28_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_31_Var
		);
		//31
		final AssignmentExpression AssignmentExpression_32_Var
		 = (AssignmentExpression)Initializer_31_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_32_Var
		);
		//32
		final ConditionalExpression ConditionalExpression_33_Var
		 = (ConditionalExpression)AssignmentExpression_32_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_33_Var
		);
		//33
		final LogicalOrExpression LogicalOrExpression_34_Var
		 = (LogicalOrExpression)ConditionalExpression_33_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = LogicalOrExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final LogicalAndExpression LogicalAndExpression_35_Var
		 = (LogicalAndExpression)Expr_34_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = LogicalAndExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final InclusiveOrExpression InclusiveOrExpression_36_Var
		 = (InclusiveOrExpression)Expr_35_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = InclusiveOrExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final ExclusiveOrExpression ExclusiveOrExpression_37_Var
		 = (ExclusiveOrExpression)Expr_36_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = ExclusiveOrExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final AndExpression AndExpression_38_Var
		 = (AndExpression)Expr_37_list.get(0);
		Assert.assertNotNull(AndExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = AndExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final EqualityExpression EqualityExpression_39_Var
		 = (EqualityExpression)Expr_38_list.get(0);
		Assert.assertNotNull(EqualityExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = EqualityExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final RelationalExpression RelationalExpression_40_Var
		 = (RelationalExpression)Expr_39_list.get(0);
		Assert.assertNotNull(RelationalExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = RelationalExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final ShiftExpression ShiftExpression_41_Var
		 = (ShiftExpression)Expr_40_list.get(0);
		Assert.assertNotNull(ShiftExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = ShiftExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final AdditiveExpression AdditiveExpression_42_Var
		 = (AdditiveExpression)Expr_41_list.get(0);
		Assert.assertNotNull(AdditiveExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = AdditiveExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final MultiplicativeExpression MultiplicativeExpression_43_Var
		 = (MultiplicativeExpression)Expr_42_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = MultiplicativeExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final CastExpression CastExpression_44_Var
		 = (CastExpression)Expr_43_list.get(0);
		Assert.assertNotNull(CastExpression_44_Var
		);
		//44
		final UnaryExpression UnaryExpression_45_Var
		 = (UnaryExpression)CastExpression_44_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_45_Var
		);
		//45
		final PostfixExpression PostfixExpression_46_Var
		 = (PostfixExpression)UnaryExpression_45_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_46_Var
		);
		final EList<? extends EObject> Expr_46_list = PostfixExpression_46_Var
		.getExpr();
		Assert.assertNotNull(Expr_46_list);
		Assert.assertEquals(1, Expr_46_list.size());
		//46
		final PrimaryExpression PrimaryExpression_47_Var
		 = (PrimaryExpression)Expr_46_list.get(0);
		Assert.assertNotNull(PrimaryExpression_47_Var
		);
		//47
		final Constant2 Constant2_48_Var
		 = (Constant2)PrimaryExpression_47_Var
		.getConst();
		Assert.assertNotNull(Constant2_48_Var
		);
		Assert.assertEquals("2", Constant2_48_Var
		.getDec());
		//48
		final InitDeclarator InitDeclarator_49_Var
		 = (InitDeclarator)InitDeclarator_6_list.get(2);
		Assert.assertNotNull(InitDeclarator_49_Var
		);
		//49
		final Declarator Declarator_50_Var
		 = (Declarator)InitDeclarator_49_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_50_Var
		);
		//50
		final DirectDeclarator DirectDeclarator_51_Var
		 = (DirectDeclarator)Declarator_50_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_51_Var
		);
		Assert.assertEquals("W_WEDNESDAY", DirectDeclarator_51_Var
		.getId());
		//51
		final Initializer Initializer_52_Var
		 = (Initializer)InitDeclarator_49_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_52_Var
		);
		//52
		final AssignmentExpression AssignmentExpression_53_Var
		 = (AssignmentExpression)Initializer_52_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_53_Var
		);
		//53
		final ConditionalExpression ConditionalExpression_54_Var
		 = (ConditionalExpression)AssignmentExpression_53_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_54_Var
		);
		//54
		final LogicalOrExpression LogicalOrExpression_55_Var
		 = (LogicalOrExpression)ConditionalExpression_54_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = LogicalOrExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final LogicalAndExpression LogicalAndExpression_56_Var
		 = (LogicalAndExpression)Expr_55_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = LogicalAndExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final InclusiveOrExpression InclusiveOrExpression_57_Var
		 = (InclusiveOrExpression)Expr_56_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = InclusiveOrExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final ExclusiveOrExpression ExclusiveOrExpression_58_Var
		 = (ExclusiveOrExpression)Expr_57_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = ExclusiveOrExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final AndExpression AndExpression_59_Var
		 = (AndExpression)Expr_58_list.get(0);
		Assert.assertNotNull(AndExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = AndExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final EqualityExpression EqualityExpression_60_Var
		 = (EqualityExpression)Expr_59_list.get(0);
		Assert.assertNotNull(EqualityExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = EqualityExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final RelationalExpression RelationalExpression_61_Var
		 = (RelationalExpression)Expr_60_list.get(0);
		Assert.assertNotNull(RelationalExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = RelationalExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final ShiftExpression ShiftExpression_62_Var
		 = (ShiftExpression)Expr_61_list.get(0);
		Assert.assertNotNull(ShiftExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = ShiftExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final AdditiveExpression AdditiveExpression_63_Var
		 = (AdditiveExpression)Expr_62_list.get(0);
		Assert.assertNotNull(AdditiveExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = AdditiveExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final MultiplicativeExpression MultiplicativeExpression_64_Var
		 = (MultiplicativeExpression)Expr_63_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = MultiplicativeExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final CastExpression CastExpression_65_Var
		 = (CastExpression)Expr_64_list.get(0);
		Assert.assertNotNull(CastExpression_65_Var
		);
		//65
		final UnaryExpression UnaryExpression_66_Var
		 = (UnaryExpression)CastExpression_65_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_66_Var
		);
		//66
		final PostfixExpression PostfixExpression_67_Var
		 = (PostfixExpression)UnaryExpression_66_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = PostfixExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final PrimaryExpression PrimaryExpression_68_Var
		 = (PrimaryExpression)Expr_67_list.get(0);
		Assert.assertNotNull(PrimaryExpression_68_Var
		);
		//68
		final Constant2 Constant2_69_Var
		 = (Constant2)PrimaryExpression_68_Var
		.getConst();
		Assert.assertNotNull(Constant2_69_Var
		);
		Assert.assertEquals("3", Constant2_69_Var
		.getDec());
		//69
		final InitDeclarator InitDeclarator_70_Var
		 = (InitDeclarator)InitDeclarator_6_list.get(3);
		Assert.assertNotNull(InitDeclarator_70_Var
		);
		//70
		final Declarator Declarator_71_Var
		 = (Declarator)InitDeclarator_70_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_71_Var
		);
		//71
		final DirectDeclarator DirectDeclarator_72_Var
		 = (DirectDeclarator)Declarator_71_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_72_Var
		);
		Assert.assertEquals("W_THURSDAY", DirectDeclarator_72_Var
		.getId());
		//72
		final Initializer Initializer_73_Var
		 = (Initializer)InitDeclarator_70_Var
		.getInitializer();
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
		Assert.assertEquals("4", Constant2_90_Var
		.getDec());
		//90
		final InitDeclarator InitDeclarator_91_Var
		 = (InitDeclarator)InitDeclarator_6_list.get(4);
		Assert.assertNotNull(InitDeclarator_91_Var
		);
		//91
		final Declarator Declarator_92_Var
		 = (Declarator)InitDeclarator_91_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_92_Var
		);
		//92
		final DirectDeclarator DirectDeclarator_93_Var
		 = (DirectDeclarator)Declarator_92_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_93_Var
		);
		Assert.assertEquals("W_FRIDAY", DirectDeclarator_93_Var
		.getId());
		//93
		final Initializer Initializer_94_Var
		 = (Initializer)InitDeclarator_91_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_94_Var
		);
		//94
		final AssignmentExpression AssignmentExpression_95_Var
		 = (AssignmentExpression)Initializer_94_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_95_Var
		);
		//95
		final ConditionalExpression ConditionalExpression_96_Var
		 = (ConditionalExpression)AssignmentExpression_95_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_96_Var
		);
		//96
		final LogicalOrExpression LogicalOrExpression_97_Var
		 = (LogicalOrExpression)ConditionalExpression_96_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = LogicalOrExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final LogicalAndExpression LogicalAndExpression_98_Var
		 = (LogicalAndExpression)Expr_97_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = LogicalAndExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final InclusiveOrExpression InclusiveOrExpression_99_Var
		 = (InclusiveOrExpression)Expr_98_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = InclusiveOrExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final ExclusiveOrExpression ExclusiveOrExpression_100_Var
		 = (ExclusiveOrExpression)Expr_99_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = ExclusiveOrExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final AndExpression AndExpression_101_Var
		 = (AndExpression)Expr_100_list.get(0);
		Assert.assertNotNull(AndExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = AndExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final EqualityExpression EqualityExpression_102_Var
		 = (EqualityExpression)Expr_101_list.get(0);
		Assert.assertNotNull(EqualityExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = EqualityExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final RelationalExpression RelationalExpression_103_Var
		 = (RelationalExpression)Expr_102_list.get(0);
		Assert.assertNotNull(RelationalExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = RelationalExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final ShiftExpression ShiftExpression_104_Var
		 = (ShiftExpression)Expr_103_list.get(0);
		Assert.assertNotNull(ShiftExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = ShiftExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final AdditiveExpression AdditiveExpression_105_Var
		 = (AdditiveExpression)Expr_104_list.get(0);
		Assert.assertNotNull(AdditiveExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = AdditiveExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final MultiplicativeExpression MultiplicativeExpression_106_Var
		 = (MultiplicativeExpression)Expr_105_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = MultiplicativeExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final CastExpression CastExpression_107_Var
		 = (CastExpression)Expr_106_list.get(0);
		Assert.assertNotNull(CastExpression_107_Var
		);
		//107
		final UnaryExpression UnaryExpression_108_Var
		 = (UnaryExpression)CastExpression_107_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_108_Var
		);
		//108
		final PostfixExpression PostfixExpression_109_Var
		 = (PostfixExpression)UnaryExpression_108_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = PostfixExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final PrimaryExpression PrimaryExpression_110_Var
		 = (PrimaryExpression)Expr_109_list.get(0);
		Assert.assertNotNull(PrimaryExpression_110_Var
		);
		//110
		final Constant2 Constant2_111_Var
		 = (Constant2)PrimaryExpression_110_Var
		.getConst();
		Assert.assertNotNull(Constant2_111_Var
		);
		Assert.assertEquals("5", Constant2_111_Var
		.getDec());
		//111
		final InitDeclarator InitDeclarator_112_Var
		 = (InitDeclarator)InitDeclarator_6_list.get(5);
		Assert.assertNotNull(InitDeclarator_112_Var
		);
		//112
		final Declarator Declarator_113_Var
		 = (Declarator)InitDeclarator_112_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_113_Var
		);
		//113
		final DirectDeclarator DirectDeclarator_114_Var
		 = (DirectDeclarator)Declarator_113_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_114_Var
		);
		Assert.assertEquals("W_SATURDAY", DirectDeclarator_114_Var
		.getId());
		//114
		final Initializer Initializer_115_Var
		 = (Initializer)InitDeclarator_112_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_115_Var
		);
		//115
		final AssignmentExpression AssignmentExpression_116_Var
		 = (AssignmentExpression)Initializer_115_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_116_Var
		);
		//116
		final ConditionalExpression ConditionalExpression_117_Var
		 = (ConditionalExpression)AssignmentExpression_116_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_117_Var
		);
		//117
		final LogicalOrExpression LogicalOrExpression_118_Var
		 = (LogicalOrExpression)ConditionalExpression_117_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = LogicalOrExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final LogicalAndExpression LogicalAndExpression_119_Var
		 = (LogicalAndExpression)Expr_118_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = LogicalAndExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final InclusiveOrExpression InclusiveOrExpression_120_Var
		 = (InclusiveOrExpression)Expr_119_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = InclusiveOrExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final ExclusiveOrExpression ExclusiveOrExpression_121_Var
		 = (ExclusiveOrExpression)Expr_120_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = ExclusiveOrExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final AndExpression AndExpression_122_Var
		 = (AndExpression)Expr_121_list.get(0);
		Assert.assertNotNull(AndExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = AndExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final EqualityExpression EqualityExpression_123_Var
		 = (EqualityExpression)Expr_122_list.get(0);
		Assert.assertNotNull(EqualityExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = EqualityExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final RelationalExpression RelationalExpression_124_Var
		 = (RelationalExpression)Expr_123_list.get(0);
		Assert.assertNotNull(RelationalExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = RelationalExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final ShiftExpression ShiftExpression_125_Var
		 = (ShiftExpression)Expr_124_list.get(0);
		Assert.assertNotNull(ShiftExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = ShiftExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final AdditiveExpression AdditiveExpression_126_Var
		 = (AdditiveExpression)Expr_125_list.get(0);
		Assert.assertNotNull(AdditiveExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = AdditiveExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final MultiplicativeExpression MultiplicativeExpression_127_Var
		 = (MultiplicativeExpression)Expr_126_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = MultiplicativeExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final CastExpression CastExpression_128_Var
		 = (CastExpression)Expr_127_list.get(0);
		Assert.assertNotNull(CastExpression_128_Var
		);
		//128
		final UnaryExpression UnaryExpression_129_Var
		 = (UnaryExpression)CastExpression_128_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_129_Var
		);
		//129
		final PostfixExpression PostfixExpression_130_Var
		 = (PostfixExpression)UnaryExpression_129_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = PostfixExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final PrimaryExpression PrimaryExpression_131_Var
		 = (PrimaryExpression)Expr_130_list.get(0);
		Assert.assertNotNull(PrimaryExpression_131_Var
		);
		//131
		final Constant2 Constant2_132_Var
		 = (Constant2)PrimaryExpression_131_Var
		.getConst();
		Assert.assertNotNull(Constant2_132_Var
		);
		Assert.assertEquals("6", Constant2_132_Var
		.getDec());
		//132
		final InitDeclarator InitDeclarator_133_Var
		 = (InitDeclarator)InitDeclarator_6_list.get(6);
		Assert.assertNotNull(InitDeclarator_133_Var
		);
		//133
		final Declarator Declarator_134_Var
		 = (Declarator)InitDeclarator_133_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_134_Var
		);
		//134
		final DirectDeclarator DirectDeclarator_135_Var
		 = (DirectDeclarator)Declarator_134_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_135_Var
		);
		Assert.assertEquals("W_SUNDAY", DirectDeclarator_135_Var
		.getId());
		//135
		final Initializer Initializer_136_Var
		 = (Initializer)InitDeclarator_133_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_136_Var
		);
		//136
		final AssignmentExpression AssignmentExpression_137_Var
		 = (AssignmentExpression)Initializer_136_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_137_Var
		);
		//137
		final ConditionalExpression ConditionalExpression_138_Var
		 = (ConditionalExpression)AssignmentExpression_137_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_138_Var
		);
		//138
		final LogicalOrExpression LogicalOrExpression_139_Var
		 = (LogicalOrExpression)ConditionalExpression_138_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = LogicalOrExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final LogicalAndExpression LogicalAndExpression_140_Var
		 = (LogicalAndExpression)Expr_139_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = LogicalAndExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final InclusiveOrExpression InclusiveOrExpression_141_Var
		 = (InclusiveOrExpression)Expr_140_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = InclusiveOrExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final ExclusiveOrExpression ExclusiveOrExpression_142_Var
		 = (ExclusiveOrExpression)Expr_141_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = ExclusiveOrExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final AndExpression AndExpression_143_Var
		 = (AndExpression)Expr_142_list.get(0);
		Assert.assertNotNull(AndExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = AndExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final EqualityExpression EqualityExpression_144_Var
		 = (EqualityExpression)Expr_143_list.get(0);
		Assert.assertNotNull(EqualityExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = EqualityExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final RelationalExpression RelationalExpression_145_Var
		 = (RelationalExpression)Expr_144_list.get(0);
		Assert.assertNotNull(RelationalExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = RelationalExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final ShiftExpression ShiftExpression_146_Var
		 = (ShiftExpression)Expr_145_list.get(0);
		Assert.assertNotNull(ShiftExpression_146_Var
		);
		final EList<? extends EObject> Expr_146_list = ShiftExpression_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final AdditiveExpression AdditiveExpression_147_Var
		 = (AdditiveExpression)Expr_146_list.get(0);
		Assert.assertNotNull(AdditiveExpression_147_Var
		);
		final EList<? extends EObject> Expr_147_list = AdditiveExpression_147_Var
		.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(1, Expr_147_list.size());
		//147
		final MultiplicativeExpression MultiplicativeExpression_148_Var
		 = (MultiplicativeExpression)Expr_147_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_148_Var
		);
		final EList<? extends EObject> Expr_148_list = MultiplicativeExpression_148_Var
		.getExpr();
		Assert.assertNotNull(Expr_148_list);
		Assert.assertEquals(1, Expr_148_list.size());
		//148
		final CastExpression CastExpression_149_Var
		 = (CastExpression)Expr_148_list.get(0);
		Assert.assertNotNull(CastExpression_149_Var
		);
		//149
		final UnaryExpression UnaryExpression_150_Var
		 = (UnaryExpression)CastExpression_149_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_150_Var
		);
		//150
		final PostfixExpression PostfixExpression_151_Var
		 = (PostfixExpression)UnaryExpression_150_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_151_Var
		);
		final EList<? extends EObject> Expr_151_list = PostfixExpression_151_Var
		.getExpr();
		Assert.assertNotNull(Expr_151_list);
		Assert.assertEquals(1, Expr_151_list.size());
		//151
		final PrimaryExpression PrimaryExpression_152_Var
		 = (PrimaryExpression)Expr_151_list.get(0);
		Assert.assertNotNull(PrimaryExpression_152_Var
		);
		//152
		final Constant2 Constant2_153_Var
		 = (Constant2)PrimaryExpression_152_Var
		.getConst();
		Assert.assertNotNull(Constant2_153_Var
		);
		Assert.assertEquals("7", Constant2_153_Var
		.getDec());
		Assert.assertEquals(";", Declaration_2_Var
		.getSemi());
		//153
		final ExternalDeclaration ExternalDeclaration_154_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_154_Var
		);
		//154
		final Declaration Declaration_155_Var
		 = (Declaration)ExternalDeclaration_154_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_155_Var
		);
		//155
		final DeclarationSpecifiers DeclarationSpecifiers_156_Var
		 = (DeclarationSpecifiers)Declaration_155_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_156_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_156_list = DeclarationSpecifiers_156_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_156_list);
		Assert.assertEquals(1, DeclarationSpecifier_156_list.size());
		//156
		final TypeSpecifier TypeSpecifier_157_Var
		 = (TypeSpecifier)DeclarationSpecifier_156_list.get(0);
		Assert.assertNotNull(TypeSpecifier_157_Var
		);
		//157
		final EnumSpecifier EnumSpecifier_158_Var
		 = (EnumSpecifier)TypeSpecifier_157_Var
		.getSpecifier();
		Assert.assertNotNull(EnumSpecifier_158_Var
		);
		//158
		final EnumeratorList EnumeratorList_159_Var
		 = (EnumeratorList)EnumSpecifier_158_Var
		.getEnumList();
		Assert.assertNotNull(EnumeratorList_159_Var
		);
		final EList<? extends EObject> Enumerator_159_list = EnumeratorList_159_Var
		.getEnumerator();
		Assert.assertNotNull(Enumerator_159_list);
		Assert.assertEquals(7, Enumerator_159_list.size());
		//159
		final Enumerator Enumerator_160_Var
		 = (Enumerator)Enumerator_159_list.get(0);
		Assert.assertNotNull(Enumerator_160_Var
		);
		Assert.assertEquals("MONDAY", Enumerator_160_Var
		.getId());
		//160
		final ConstantExpression ConstantExpression_161_Var
		 = (ConstantExpression)Enumerator_160_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_161_Var
		);
		//161
		final ConditionalExpression ConditionalExpression_162_Var
		 = (ConditionalExpression)ConstantExpression_161_Var
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
		//176
		final Constant2 Constant2_177_Var
		 = (Constant2)PrimaryExpression_176_Var
		.getConst();
		Assert.assertNotNull(Constant2_177_Var
		);
		Assert.assertEquals("1", Constant2_177_Var
		.getDec());
		//177
		final Enumerator Enumerator_178_Var
		 = (Enumerator)Enumerator_159_list.get(1);
		Assert.assertNotNull(Enumerator_178_Var
		);
		Assert.assertEquals("TUESDAY", Enumerator_178_Var
		.getId());
		//178
		final Enumerator Enumerator_179_Var
		 = (Enumerator)Enumerator_159_list.get(2);
		Assert.assertNotNull(Enumerator_179_Var
		);
		Assert.assertEquals("WEDNESDAY", Enumerator_179_Var
		.getId());
		//179
		final Enumerator Enumerator_180_Var
		 = (Enumerator)Enumerator_159_list.get(3);
		Assert.assertNotNull(Enumerator_180_Var
		);
		Assert.assertEquals("THURSDAY", Enumerator_180_Var
		.getId());
		//180
		final Enumerator Enumerator_181_Var
		 = (Enumerator)Enumerator_159_list.get(4);
		Assert.assertNotNull(Enumerator_181_Var
		);
		Assert.assertEquals("FRIDAY", Enumerator_181_Var
		.getId());
		//181
		final Enumerator Enumerator_182_Var
		 = (Enumerator)Enumerator_159_list.get(5);
		Assert.assertNotNull(Enumerator_182_Var
		);
		Assert.assertEquals("SATURDAY", Enumerator_182_Var
		.getId());
		//182
		final Enumerator Enumerator_183_Var
		 = (Enumerator)Enumerator_159_list.get(6);
		Assert.assertNotNull(Enumerator_183_Var
		);
		Assert.assertEquals("SUNDAY", Enumerator_183_Var
		.getId());
		//183
		final ExternalDeclaration ExternalDeclaration_184_Var
		 = (ExternalDeclaration)External_0_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_184_Var
		);
		//184
		final Declaration Declaration_185_Var
		 = (Declaration)ExternalDeclaration_184_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_185_Var
		);
		//185
		final DeclarationSpecifiers DeclarationSpecifiers_186_Var
		 = (DeclarationSpecifiers)Declaration_185_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_186_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_186_list = DeclarationSpecifiers_186_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_186_list);
		Assert.assertEquals(1, DeclarationSpecifier_186_list.size());
		//186
		final TypeSpecifier TypeSpecifier_187_Var
		 = (TypeSpecifier)DeclarationSpecifier_186_list.get(0);
		Assert.assertNotNull(TypeSpecifier_187_Var
		);
		//187
		final EnumSpecifier EnumSpecifier_188_Var
		 = (EnumSpecifier)TypeSpecifier_187_Var
		.getSpecifier();
		Assert.assertNotNull(EnumSpecifier_188_Var
		);
		//188
		final EnumeratorList EnumeratorList_189_Var
		 = (EnumeratorList)EnumSpecifier_188_Var
		.getEnumList();
		Assert.assertNotNull(EnumeratorList_189_Var
		);
		final EList<? extends EObject> Enumerator_189_list = EnumeratorList_189_Var
		.getEnumerator();
		Assert.assertNotNull(Enumerator_189_list);
		Assert.assertEquals(7, Enumerator_189_list.size());
		//189
		final Enumerator Enumerator_190_Var
		 = (Enumerator)Enumerator_189_list.get(0);
		Assert.assertNotNull(Enumerator_190_Var
		);
		Assert.assertEquals("I_MONDAY", Enumerator_190_Var
		.getId());
		//190
		final ConstantExpression ConstantExpression_191_Var
		 = (ConstantExpression)Enumerator_190_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_191_Var
		);
		//191
		final ConditionalExpression ConditionalExpression_192_Var
		 = (ConditionalExpression)ConstantExpression_191_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_192_Var
		);
		//192
		final LogicalOrExpression LogicalOrExpression_193_Var
		 = (LogicalOrExpression)ConditionalExpression_192_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = LogicalOrExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final LogicalAndExpression LogicalAndExpression_194_Var
		 = (LogicalAndExpression)Expr_193_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = LogicalAndExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final InclusiveOrExpression InclusiveOrExpression_195_Var
		 = (InclusiveOrExpression)Expr_194_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = InclusiveOrExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final ExclusiveOrExpression ExclusiveOrExpression_196_Var
		 = (ExclusiveOrExpression)Expr_195_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = ExclusiveOrExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final AndExpression AndExpression_197_Var
		 = (AndExpression)Expr_196_list.get(0);
		Assert.assertNotNull(AndExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = AndExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final EqualityExpression EqualityExpression_198_Var
		 = (EqualityExpression)Expr_197_list.get(0);
		Assert.assertNotNull(EqualityExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = EqualityExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final RelationalExpression RelationalExpression_199_Var
		 = (RelationalExpression)Expr_198_list.get(0);
		Assert.assertNotNull(RelationalExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = RelationalExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final ShiftExpression ShiftExpression_200_Var
		 = (ShiftExpression)Expr_199_list.get(0);
		Assert.assertNotNull(ShiftExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = ShiftExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final AdditiveExpression AdditiveExpression_201_Var
		 = (AdditiveExpression)Expr_200_list.get(0);
		Assert.assertNotNull(AdditiveExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = AdditiveExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final MultiplicativeExpression MultiplicativeExpression_202_Var
		 = (MultiplicativeExpression)Expr_201_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = MultiplicativeExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final CastExpression CastExpression_203_Var
		 = (CastExpression)Expr_202_list.get(0);
		Assert.assertNotNull(CastExpression_203_Var
		);
		//203
		final UnaryExpression UnaryExpression_204_Var
		 = (UnaryExpression)CastExpression_203_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_204_Var
		);
		//204
		final PostfixExpression PostfixExpression_205_Var
		 = (PostfixExpression)UnaryExpression_204_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = PostfixExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final PrimaryExpression PrimaryExpression_206_Var
		 = (PrimaryExpression)Expr_205_list.get(0);
		Assert.assertNotNull(PrimaryExpression_206_Var
		);
		//206
		final Constant2 Constant2_207_Var
		 = (Constant2)PrimaryExpression_206_Var
		.getConst();
		Assert.assertNotNull(Constant2_207_Var
		);
		Assert.assertEquals("1", Constant2_207_Var
		.getDec());
		//207
		final Enumerator Enumerator_208_Var
		 = (Enumerator)Enumerator_189_list.get(1);
		Assert.assertNotNull(Enumerator_208_Var
		);
		Assert.assertEquals("I_TUESDAY", Enumerator_208_Var
		.getId());
		//208
		final Enumerator Enumerator_209_Var
		 = (Enumerator)Enumerator_189_list.get(2);
		Assert.assertNotNull(Enumerator_209_Var
		);
		Assert.assertEquals("I_WEDNESDAY", Enumerator_209_Var
		.getId());
		//209
		final Enumerator Enumerator_210_Var
		 = (Enumerator)Enumerator_189_list.get(3);
		Assert.assertNotNull(Enumerator_210_Var
		);
		Assert.assertEquals("I_THURSDAY", Enumerator_210_Var
		.getId());
		//210
		final Enumerator Enumerator_211_Var
		 = (Enumerator)Enumerator_189_list.get(4);
		Assert.assertNotNull(Enumerator_211_Var
		);
		Assert.assertEquals("I_FRIDAY", Enumerator_211_Var
		.getId());
		//211
		final Enumerator Enumerator_212_Var
		 = (Enumerator)Enumerator_189_list.get(5);
		Assert.assertNotNull(Enumerator_212_Var
		);
		Assert.assertEquals("I_SATURDAY", Enumerator_212_Var
		.getId());
		//212
		final Enumerator Enumerator_213_Var
		 = (Enumerator)Enumerator_189_list.get(6);
		Assert.assertNotNull(Enumerator_213_Var
		);
		Assert.assertEquals("I_SUNDAY", Enumerator_213_Var
		.getId());
		//213
		final ExternalDeclaration ExternalDeclaration_214_Var
		 = (ExternalDeclaration)External_0_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_214_Var
		);
		//214
		final Declaration Declaration_215_Var
		 = (Declaration)ExternalDeclaration_214_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_215_Var
		);
		//215
		final DeclarationSpecifiers DeclarationSpecifiers_216_Var
		 = (DeclarationSpecifiers)Declaration_215_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_216_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_216_list = DeclarationSpecifiers_216_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_216_list);
		Assert.assertEquals(1, DeclarationSpecifier_216_list.size());
		//216
		final TypeSpecifier TypeSpecifier_217_Var
		 = (TypeSpecifier)DeclarationSpecifier_216_list.get(0);
		Assert.assertNotNull(TypeSpecifier_217_Var
		);
		//217
		final EnumSpecifier EnumSpecifier_218_Var
		 = (EnumSpecifier)TypeSpecifier_217_Var
		.getSpecifier();
		Assert.assertNotNull(EnumSpecifier_218_Var
		);
		Assert.assertEquals("weekdays", EnumSpecifier_218_Var
		.getId());
		//218
		final EnumeratorList EnumeratorList_219_Var
		 = (EnumeratorList)EnumSpecifier_218_Var
		.getEnumList();
		Assert.assertNotNull(EnumeratorList_219_Var
		);
		final EList<? extends EObject> Enumerator_219_list = EnumeratorList_219_Var
		.getEnumerator();
		Assert.assertNotNull(Enumerator_219_list);
		Assert.assertEquals(7, Enumerator_219_list.size());
		//219
		final Enumerator Enumerator_220_Var
		 = (Enumerator)Enumerator_219_list.get(0);
		Assert.assertNotNull(Enumerator_220_Var
		);
		Assert.assertEquals("M_MONDAY", Enumerator_220_Var
		.getId());
		//220
		final ConstantExpression ConstantExpression_221_Var
		 = (ConstantExpression)Enumerator_220_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_221_Var
		);
		//221
		final ConditionalExpression ConditionalExpression_222_Var
		 = (ConditionalExpression)ConstantExpression_221_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_222_Var
		);
		//222
		final LogicalOrExpression LogicalOrExpression_223_Var
		 = (LogicalOrExpression)ConditionalExpression_222_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = LogicalOrExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final LogicalAndExpression LogicalAndExpression_224_Var
		 = (LogicalAndExpression)Expr_223_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = LogicalAndExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final InclusiveOrExpression InclusiveOrExpression_225_Var
		 = (InclusiveOrExpression)Expr_224_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = InclusiveOrExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final ExclusiveOrExpression ExclusiveOrExpression_226_Var
		 = (ExclusiveOrExpression)Expr_225_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = ExclusiveOrExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final AndExpression AndExpression_227_Var
		 = (AndExpression)Expr_226_list.get(0);
		Assert.assertNotNull(AndExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = AndExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final EqualityExpression EqualityExpression_228_Var
		 = (EqualityExpression)Expr_227_list.get(0);
		Assert.assertNotNull(EqualityExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = EqualityExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final RelationalExpression RelationalExpression_229_Var
		 = (RelationalExpression)Expr_228_list.get(0);
		Assert.assertNotNull(RelationalExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = RelationalExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final ShiftExpression ShiftExpression_230_Var
		 = (ShiftExpression)Expr_229_list.get(0);
		Assert.assertNotNull(ShiftExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = ShiftExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final AdditiveExpression AdditiveExpression_231_Var
		 = (AdditiveExpression)Expr_230_list.get(0);
		Assert.assertNotNull(AdditiveExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = AdditiveExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final MultiplicativeExpression MultiplicativeExpression_232_Var
		 = (MultiplicativeExpression)Expr_231_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = MultiplicativeExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final CastExpression CastExpression_233_Var
		 = (CastExpression)Expr_232_list.get(0);
		Assert.assertNotNull(CastExpression_233_Var
		);
		//233
		final UnaryExpression UnaryExpression_234_Var
		 = (UnaryExpression)CastExpression_233_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_234_Var
		);
		//234
		final PostfixExpression PostfixExpression_235_Var
		 = (PostfixExpression)UnaryExpression_234_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = PostfixExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final PrimaryExpression PrimaryExpression_236_Var
		 = (PrimaryExpression)Expr_235_list.get(0);
		Assert.assertNotNull(PrimaryExpression_236_Var
		);
		//236
		final Constant2 Constant2_237_Var
		 = (Constant2)PrimaryExpression_236_Var
		.getConst();
		Assert.assertNotNull(Constant2_237_Var
		);
		Assert.assertEquals("1", Constant2_237_Var
		.getDec());
		//237
		final Enumerator Enumerator_238_Var
		 = (Enumerator)Enumerator_219_list.get(1);
		Assert.assertNotNull(Enumerator_238_Var
		);
		Assert.assertEquals("M_TUESDAY", Enumerator_238_Var
		.getId());
		//238
		final Enumerator Enumerator_239_Var
		 = (Enumerator)Enumerator_219_list.get(2);
		Assert.assertNotNull(Enumerator_239_Var
		);
		Assert.assertEquals("M_WEDNESDAY", Enumerator_239_Var
		.getId());
		//239
		final Enumerator Enumerator_240_Var
		 = (Enumerator)Enumerator_219_list.get(3);
		Assert.assertNotNull(Enumerator_240_Var
		);
		Assert.assertEquals("M_THURSDAY", Enumerator_240_Var
		.getId());
		//240
		final Enumerator Enumerator_241_Var
		 = (Enumerator)Enumerator_219_list.get(4);
		Assert.assertNotNull(Enumerator_241_Var
		);
		Assert.assertEquals("M_FRIDAY", Enumerator_241_Var
		.getId());
		//241
		final Enumerator Enumerator_242_Var
		 = (Enumerator)Enumerator_219_list.get(5);
		Assert.assertNotNull(Enumerator_242_Var
		);
		Assert.assertEquals("M_SATURDAY", Enumerator_242_Var
		.getId());
		//242
		final Enumerator Enumerator_243_Var
		 = (Enumerator)Enumerator_219_list.get(6);
		Assert.assertNotNull(Enumerator_243_Var
		);
		Assert.assertEquals("M_SUNDAY", Enumerator_243_Var
		.getId());
		//243
		final ExternalDeclaration ExternalDeclaration_244_Var
		 = (ExternalDeclaration)External_0_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_244_Var
		);
		//244
		final Declaration Declaration_245_Var
		 = (Declaration)ExternalDeclaration_244_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_245_Var
		);
		//245
		final DeclarationSpecifiers DeclarationSpecifiers_246_Var
		 = (DeclarationSpecifiers)Declaration_245_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_246_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_246_list = DeclarationSpecifiers_246_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_246_list);
		Assert.assertEquals(1, DeclarationSpecifier_246_list.size());
		//246
		final TypeSpecifier TypeSpecifier_247_Var
		 = (TypeSpecifier)DeclarationSpecifier_246_list.get(0);
		Assert.assertNotNull(TypeSpecifier_247_Var
		);
		//247
		final EnumSpecifier EnumSpecifier_248_Var
		 = (EnumSpecifier)TypeSpecifier_247_Var
		.getSpecifier();
		Assert.assertNotNull(EnumSpecifier_248_Var
		);
		Assert.assertEquals("weekdays", EnumSpecifier_248_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_248_list = Declaration_245_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_248_list);
		Assert.assertEquals(1, InitDeclaratorList_248_list.size());
		//248
		final InitDeclaratorList InitDeclaratorList_249_Var
		 = (InitDeclaratorList)InitDeclaratorList_248_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_249_Var
		);
		final EList<? extends EObject> InitDeclarator_249_list = InitDeclaratorList_249_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_249_list);
		Assert.assertEquals(1, InitDeclarator_249_list.size());
		//249
		final InitDeclarator InitDeclarator_250_Var
		 = (InitDeclarator)InitDeclarator_249_list.get(0);
		Assert.assertNotNull(InitDeclarator_250_Var
		);
		//250
		final Declarator Declarator_251_Var
		 = (Declarator)InitDeclarator_250_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_251_Var
		);
		//251
		final DirectDeclarator DirectDeclarator_252_Var
		 = (DirectDeclarator)Declarator_251_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_252_Var
		);
		Assert.assertEquals("my_weekday", DirectDeclarator_252_Var
		.getId());
		//252
		final Initializer Initializer_253_Var
		 = (Initializer)InitDeclarator_250_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_253_Var
		);
		//253
		final AssignmentExpression AssignmentExpression_254_Var
		 = (AssignmentExpression)Initializer_253_Var
		.getExpr();
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
		Assert.assertEquals("M_FRIDAY", PrimaryExpression_269_Var
		.getId());
		//269
		final ExternalDeclaration ExternalDeclaration_270_Var
		 = (ExternalDeclaration)External_0_list.get(5);
		Assert.assertNotNull(ExternalDeclaration_270_Var
		);
		//270
		final FunctionDefHead FunctionDefHead_271_Var
		 = (FunctionDefHead)ExternalDeclaration_270_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_271_Var
		);
		//271
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_272_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_271_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_272_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_272_list = FunctionDeclarationSpecifiers_272_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_272_list);
		Assert.assertEquals(1, DeclarationSpecifier_272_list.size());
		//272
		final TypeSpecifier TypeSpecifier_273_Var
		 = (TypeSpecifier)DeclarationSpecifier_272_list.get(0);
		Assert.assertNotNull(TypeSpecifier_273_Var
		);
		Assert.assertEquals("int", TypeSpecifier_273_Var
		.getName());
		//273
		final Declarator Declarator_274_Var
		 = (Declarator)FunctionDefHead_271_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_274_Var
		);
		//274
		final DirectDeclarator DirectDeclarator_275_Var
		 = (DirectDeclarator)Declarator_274_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_275_Var
		);
		Assert.assertEquals("main", DirectDeclarator_275_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_275_list = DirectDeclarator_275_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_275_list);
		Assert.assertEquals(1, DeclaratorSuffix_275_list.size());
		//275
		final DeclaratorSuffix DeclaratorSuffix_276_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_275_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_276_Var
		);
		//276
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_277_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_276_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_277_Var
		);
		final EList<? extends EObject> ParameterTypeList_277_list = DirectDeclaratorLastSuffix_277_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_277_list);
		Assert.assertEquals(1, ParameterTypeList_277_list.size());
		//277
		final ParameterTypeList ParameterTypeList_278_Var
		 = (ParameterTypeList)ParameterTypeList_277_list.get(0);
		Assert.assertNotNull(ParameterTypeList_278_Var
		);
		//278
		final ParameterList ParameterList_279_Var
		 = (ParameterList)ParameterTypeList_278_Var
		.getList();
		Assert.assertNotNull(ParameterList_279_Var
		);
		final EList<? extends EObject> ParameterDeclaration_279_list = ParameterList_279_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_279_list);
		Assert.assertEquals(1, ParameterDeclaration_279_list.size());
		//279
		final ParameterDeclaration ParameterDeclaration_280_Var
		 = (ParameterDeclaration)ParameterDeclaration_279_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_280_Var
		);
		//280
		final DeclarationSpecifiers DeclarationSpecifiers_281_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_280_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_281_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_281_list = DeclarationSpecifiers_281_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_281_list);
		Assert.assertEquals(1, DeclarationSpecifier_281_list.size());
		//281
		final TypeSpecifier TypeSpecifier_282_Var
		 = (TypeSpecifier)DeclarationSpecifier_281_list.get(0);
		Assert.assertNotNull(TypeSpecifier_282_Var
		);
		Assert.assertEquals("void", TypeSpecifier_282_Var
		.getName());
		//282
		final FunctionDefinition FunctionDefinition_283_Var
		 = (FunctionDefinition)ExternalDeclaration_270_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_283_Var
		);
		//283
		final BodyStatement BodyStatement_284_Var
		 = (BodyStatement)FunctionDefinition_283_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_284_Var
		);
		final EList<? extends EObject> BlockList_284_list = BodyStatement_284_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_284_list);
		Assert.assertEquals(1, BlockList_284_list.size());
		//284
		final BlockList BlockList_285_Var
		 = (BlockList)BlockList_284_list.get(0);
		Assert.assertNotNull(BlockList_285_Var
		);
		final EList<? extends EObject> Statement_285_list = BlockList_285_Var
		.getStatement();
		Assert.assertNotNull(Statement_285_list);
		Assert.assertEquals(8, Statement_285_list.size());
		//285
		final Statement Statement_286_Var
		 = (Statement)Statement_285_list.get(0);
		Assert.assertNotNull(Statement_286_Var
		);
		//286
		final ExpressionStatement ExpressionStatement_287_Var
		 = (ExpressionStatement)Statement_286_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_287_Var
		);
		//287
		final Expression Expression_288_Var
		 = (Expression)ExpressionStatement_287_Var
		.getExpression();
		Assert.assertNotNull(Expression_288_Var
		);
		final EList<? extends EObject> ExprExpr_288_list = Expression_288_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_288_list);
		Assert.assertEquals(1, ExprExpr_288_list.size());
		//288
		final AssignmentExpression AssignmentExpression_289_Var
		 = (AssignmentExpression)ExprExpr_288_list.get(0);
		Assert.assertNotNull(AssignmentExpression_289_Var
		);
		//289
		final ConditionalExpression ConditionalExpression_290_Var
		 = (ConditionalExpression)AssignmentExpression_289_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_290_Var
		);
		//290
		final LogicalOrExpression LogicalOrExpression_291_Var
		 = (LogicalOrExpression)ConditionalExpression_290_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_291_Var
		);
		final EList<? extends EObject> Expr_291_list = LogicalOrExpression_291_Var
		.getExpr();
		Assert.assertNotNull(Expr_291_list);
		Assert.assertEquals(1, Expr_291_list.size());
		//291
		final LogicalAndExpression LogicalAndExpression_292_Var
		 = (LogicalAndExpression)Expr_291_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_292_Var
		);
		final EList<? extends EObject> Expr_292_list = LogicalAndExpression_292_Var
		.getExpr();
		Assert.assertNotNull(Expr_292_list);
		Assert.assertEquals(1, Expr_292_list.size());
		//292
		final InclusiveOrExpression InclusiveOrExpression_293_Var
		 = (InclusiveOrExpression)Expr_292_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = InclusiveOrExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final ExclusiveOrExpression ExclusiveOrExpression_294_Var
		 = (ExclusiveOrExpression)Expr_293_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_294_Var
		);
		final EList<? extends EObject> Expr_294_list = ExclusiveOrExpression_294_Var
		.getExpr();
		Assert.assertNotNull(Expr_294_list);
		Assert.assertEquals(1, Expr_294_list.size());
		//294
		final AndExpression AndExpression_295_Var
		 = (AndExpression)Expr_294_list.get(0);
		Assert.assertNotNull(AndExpression_295_Var
		);
		final EList<? extends EObject> Expr_295_list = AndExpression_295_Var
		.getExpr();
		Assert.assertNotNull(Expr_295_list);
		Assert.assertEquals(1, Expr_295_list.size());
		//295
		final EqualityExpression EqualityExpression_296_Var
		 = (EqualityExpression)Expr_295_list.get(0);
		Assert.assertNotNull(EqualityExpression_296_Var
		);
		final EList<? extends EObject> Expr_296_list = EqualityExpression_296_Var
		.getExpr();
		Assert.assertNotNull(Expr_296_list);
		Assert.assertEquals(1, Expr_296_list.size());
		//296
		final RelationalExpression RelationalExpression_297_Var
		 = (RelationalExpression)Expr_296_list.get(0);
		Assert.assertNotNull(RelationalExpression_297_Var
		);
		final EList<? extends EObject> Expr_297_list = RelationalExpression_297_Var
		.getExpr();
		Assert.assertNotNull(Expr_297_list);
		Assert.assertEquals(1, Expr_297_list.size());
		//297
		final ShiftExpression ShiftExpression_298_Var
		 = (ShiftExpression)Expr_297_list.get(0);
		Assert.assertNotNull(ShiftExpression_298_Var
		);
		final EList<? extends EObject> Expr_298_list = ShiftExpression_298_Var
		.getExpr();
		Assert.assertNotNull(Expr_298_list);
		Assert.assertEquals(1, Expr_298_list.size());
		//298
		final AdditiveExpression AdditiveExpression_299_Var
		 = (AdditiveExpression)Expr_298_list.get(0);
		Assert.assertNotNull(AdditiveExpression_299_Var
		);
		final EList<? extends EObject> Expr_299_list = AdditiveExpression_299_Var
		.getExpr();
		Assert.assertNotNull(Expr_299_list);
		Assert.assertEquals(1, Expr_299_list.size());
		//299
		final MultiplicativeExpression MultiplicativeExpression_300_Var
		 = (MultiplicativeExpression)Expr_299_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_300_Var
		);
		final EList<? extends EObject> Expr_300_list = MultiplicativeExpression_300_Var
		.getExpr();
		Assert.assertNotNull(Expr_300_list);
		Assert.assertEquals(1, Expr_300_list.size());
		//300
		final CastExpression CastExpression_301_Var
		 = (CastExpression)Expr_300_list.get(0);
		Assert.assertNotNull(CastExpression_301_Var
		);
		//301
		final UnaryExpression UnaryExpression_302_Var
		 = (UnaryExpression)CastExpression_301_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_302_Var
		);
		//302
		final PostfixExpression PostfixExpression_303_Var
		 = (PostfixExpression)UnaryExpression_302_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_303_Var
		);
		final EList<? extends EObject> Expr_303_list = PostfixExpression_303_Var
		.getExpr();
		Assert.assertNotNull(Expr_303_list);
		Assert.assertEquals(1, Expr_303_list.size());
		//303
		final PrimaryExpression PrimaryExpression_304_Var
		 = (PrimaryExpression)Expr_303_list.get(0);
		Assert.assertNotNull(PrimaryExpression_304_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_304_Var
		.getId());
		final EList<? extends EObject> Suffix_304_list = PostfixExpression_303_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_304_list);
		Assert.assertEquals(1, Suffix_304_list.size());
		//304
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_305_Var
		 = (PostfixExpressionSuffixArgument)Suffix_304_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_305_Var
		);
		//305
		final ArgumentExpressionList ArgumentExpressionList_306_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_305_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_306_Var
		);
		final EList<? extends EObject> Expr_306_list = ArgumentExpressionList_306_Var
		.getExpr();
		Assert.assertNotNull(Expr_306_list);
		Assert.assertEquals(2, Expr_306_list.size());
		//306
		final AssignmentExpression AssignmentExpression_307_Var
		 = (AssignmentExpression)Expr_306_list.get(0);
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
		//322
		final Constant2 Constant2_323_Var
		 = (Constant2)PrimaryExpression_322_Var
		.getConst();
		Assert.assertNotNull(Constant2_323_Var
		);
		Assert.assertEquals("\"Monday is %d. day of week\\n\"", Constant2_323_Var
		.getStr());
		//323
		final AssignmentExpression AssignmentExpression_324_Var
		 = (AssignmentExpression)Expr_306_list.get(1);
		Assert.assertNotNull(AssignmentExpression_324_Var
		);
		//324
		final ConditionalExpression ConditionalExpression_325_Var
		 = (ConditionalExpression)AssignmentExpression_324_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_325_Var
		);
		//325
		final LogicalOrExpression LogicalOrExpression_326_Var
		 = (LogicalOrExpression)ConditionalExpression_325_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_326_Var
		);
		final EList<? extends EObject> Expr_326_list = LogicalOrExpression_326_Var
		.getExpr();
		Assert.assertNotNull(Expr_326_list);
		Assert.assertEquals(1, Expr_326_list.size());
		//326
		final LogicalAndExpression LogicalAndExpression_327_Var
		 = (LogicalAndExpression)Expr_326_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_327_Var
		);
		final EList<? extends EObject> Expr_327_list = LogicalAndExpression_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final InclusiveOrExpression InclusiveOrExpression_328_Var
		 = (InclusiveOrExpression)Expr_327_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_328_Var
		);
		final EList<? extends EObject> Expr_328_list = InclusiveOrExpression_328_Var
		.getExpr();
		Assert.assertNotNull(Expr_328_list);
		Assert.assertEquals(1, Expr_328_list.size());
		//328
		final ExclusiveOrExpression ExclusiveOrExpression_329_Var
		 = (ExclusiveOrExpression)Expr_328_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_329_Var
		);
		final EList<? extends EObject> Expr_329_list = ExclusiveOrExpression_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final AndExpression AndExpression_330_Var
		 = (AndExpression)Expr_329_list.get(0);
		Assert.assertNotNull(AndExpression_330_Var
		);
		final EList<? extends EObject> Expr_330_list = AndExpression_330_Var
		.getExpr();
		Assert.assertNotNull(Expr_330_list);
		Assert.assertEquals(1, Expr_330_list.size());
		//330
		final EqualityExpression EqualityExpression_331_Var
		 = (EqualityExpression)Expr_330_list.get(0);
		Assert.assertNotNull(EqualityExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = EqualityExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final RelationalExpression RelationalExpression_332_Var
		 = (RelationalExpression)Expr_331_list.get(0);
		Assert.assertNotNull(RelationalExpression_332_Var
		);
		final EList<? extends EObject> Expr_332_list = RelationalExpression_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final ShiftExpression ShiftExpression_333_Var
		 = (ShiftExpression)Expr_332_list.get(0);
		Assert.assertNotNull(ShiftExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = ShiftExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final AdditiveExpression AdditiveExpression_334_Var
		 = (AdditiveExpression)Expr_333_list.get(0);
		Assert.assertNotNull(AdditiveExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = AdditiveExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final MultiplicativeExpression MultiplicativeExpression_335_Var
		 = (MultiplicativeExpression)Expr_334_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = MultiplicativeExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final CastExpression CastExpression_336_Var
		 = (CastExpression)Expr_335_list.get(0);
		Assert.assertNotNull(CastExpression_336_Var
		);
		//336
		final UnaryExpression UnaryExpression_337_Var
		 = (UnaryExpression)CastExpression_336_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_337_Var
		);
		//337
		final PostfixExpression PostfixExpression_338_Var
		 = (PostfixExpression)UnaryExpression_337_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = PostfixExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final PrimaryExpression PrimaryExpression_339_Var
		 = (PrimaryExpression)Expr_338_list.get(0);
		Assert.assertNotNull(PrimaryExpression_339_Var
		);
		Assert.assertEquals("W_MONDAY", PrimaryExpression_339_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_287_Var
		.getSemi());
		//339
		final Statement Statement_340_Var
		 = (Statement)Statement_285_list.get(1);
		Assert.assertNotNull(Statement_340_Var
		);
		//340
		final ExpressionStatement ExpressionStatement_341_Var
		 = (ExpressionStatement)Statement_340_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_341_Var
		);
		//341
		final Expression Expression_342_Var
		 = (Expression)ExpressionStatement_341_Var
		.getExpression();
		Assert.assertNotNull(Expression_342_Var
		);
		final EList<? extends EObject> ExprExpr_342_list = Expression_342_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_342_list);
		Assert.assertEquals(1, ExprExpr_342_list.size());
		//342
		final AssignmentExpression AssignmentExpression_343_Var
		 = (AssignmentExpression)ExprExpr_342_list.get(0);
		Assert.assertNotNull(AssignmentExpression_343_Var
		);
		//343
		final ConditionalExpression ConditionalExpression_344_Var
		 = (ConditionalExpression)AssignmentExpression_343_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_344_Var
		);
		//344
		final LogicalOrExpression LogicalOrExpression_345_Var
		 = (LogicalOrExpression)ConditionalExpression_344_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_345_Var
		);
		final EList<? extends EObject> Expr_345_list = LogicalOrExpression_345_Var
		.getExpr();
		Assert.assertNotNull(Expr_345_list);
		Assert.assertEquals(1, Expr_345_list.size());
		//345
		final LogicalAndExpression LogicalAndExpression_346_Var
		 = (LogicalAndExpression)Expr_345_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_346_Var
		);
		final EList<? extends EObject> Expr_346_list = LogicalAndExpression_346_Var
		.getExpr();
		Assert.assertNotNull(Expr_346_list);
		Assert.assertEquals(1, Expr_346_list.size());
		//346
		final InclusiveOrExpression InclusiveOrExpression_347_Var
		 = (InclusiveOrExpression)Expr_346_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_347_Var
		);
		final EList<? extends EObject> Expr_347_list = InclusiveOrExpression_347_Var
		.getExpr();
		Assert.assertNotNull(Expr_347_list);
		Assert.assertEquals(1, Expr_347_list.size());
		//347
		final ExclusiveOrExpression ExclusiveOrExpression_348_Var
		 = (ExclusiveOrExpression)Expr_347_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_348_Var
		);
		final EList<? extends EObject> Expr_348_list = ExclusiveOrExpression_348_Var
		.getExpr();
		Assert.assertNotNull(Expr_348_list);
		Assert.assertEquals(1, Expr_348_list.size());
		//348
		final AndExpression AndExpression_349_Var
		 = (AndExpression)Expr_348_list.get(0);
		Assert.assertNotNull(AndExpression_349_Var
		);
		final EList<? extends EObject> Expr_349_list = AndExpression_349_Var
		.getExpr();
		Assert.assertNotNull(Expr_349_list);
		Assert.assertEquals(1, Expr_349_list.size());
		//349
		final EqualityExpression EqualityExpression_350_Var
		 = (EqualityExpression)Expr_349_list.get(0);
		Assert.assertNotNull(EqualityExpression_350_Var
		);
		final EList<? extends EObject> Expr_350_list = EqualityExpression_350_Var
		.getExpr();
		Assert.assertNotNull(Expr_350_list);
		Assert.assertEquals(1, Expr_350_list.size());
		//350
		final RelationalExpression RelationalExpression_351_Var
		 = (RelationalExpression)Expr_350_list.get(0);
		Assert.assertNotNull(RelationalExpression_351_Var
		);
		final EList<? extends EObject> Expr_351_list = RelationalExpression_351_Var
		.getExpr();
		Assert.assertNotNull(Expr_351_list);
		Assert.assertEquals(1, Expr_351_list.size());
		//351
		final ShiftExpression ShiftExpression_352_Var
		 = (ShiftExpression)Expr_351_list.get(0);
		Assert.assertNotNull(ShiftExpression_352_Var
		);
		final EList<? extends EObject> Expr_352_list = ShiftExpression_352_Var
		.getExpr();
		Assert.assertNotNull(Expr_352_list);
		Assert.assertEquals(1, Expr_352_list.size());
		//352
		final AdditiveExpression AdditiveExpression_353_Var
		 = (AdditiveExpression)Expr_352_list.get(0);
		Assert.assertNotNull(AdditiveExpression_353_Var
		);
		final EList<? extends EObject> Expr_353_list = AdditiveExpression_353_Var
		.getExpr();
		Assert.assertNotNull(Expr_353_list);
		Assert.assertEquals(1, Expr_353_list.size());
		//353
		final MultiplicativeExpression MultiplicativeExpression_354_Var
		 = (MultiplicativeExpression)Expr_353_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_354_Var
		);
		final EList<? extends EObject> Expr_354_list = MultiplicativeExpression_354_Var
		.getExpr();
		Assert.assertNotNull(Expr_354_list);
		Assert.assertEquals(1, Expr_354_list.size());
		//354
		final CastExpression CastExpression_355_Var
		 = (CastExpression)Expr_354_list.get(0);
		Assert.assertNotNull(CastExpression_355_Var
		);
		//355
		final UnaryExpression UnaryExpression_356_Var
		 = (UnaryExpression)CastExpression_355_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_356_Var
		);
		//356
		final PostfixExpression PostfixExpression_357_Var
		 = (PostfixExpression)UnaryExpression_356_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_357_Var
		);
		final EList<? extends EObject> Expr_357_list = PostfixExpression_357_Var
		.getExpr();
		Assert.assertNotNull(Expr_357_list);
		Assert.assertEquals(1, Expr_357_list.size());
		//357
		final PrimaryExpression PrimaryExpression_358_Var
		 = (PrimaryExpression)Expr_357_list.get(0);
		Assert.assertNotNull(PrimaryExpression_358_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_358_Var
		.getId());
		final EList<? extends EObject> Suffix_358_list = PostfixExpression_357_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_358_list);
		Assert.assertEquals(1, Suffix_358_list.size());
		//358
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_359_Var
		 = (PostfixExpressionSuffixArgument)Suffix_358_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_359_Var
		);
		//359
		final ArgumentExpressionList ArgumentExpressionList_360_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_359_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_360_Var
		);
		final EList<? extends EObject> Expr_360_list = ArgumentExpressionList_360_Var
		.getExpr();
		Assert.assertNotNull(Expr_360_list);
		Assert.assertEquals(2, Expr_360_list.size());
		//360
		final AssignmentExpression AssignmentExpression_361_Var
		 = (AssignmentExpression)Expr_360_list.get(0);
		Assert.assertNotNull(AssignmentExpression_361_Var
		);
		//361
		final ConditionalExpression ConditionalExpression_362_Var
		 = (ConditionalExpression)AssignmentExpression_361_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_362_Var
		);
		//362
		final LogicalOrExpression LogicalOrExpression_363_Var
		 = (LogicalOrExpression)ConditionalExpression_362_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_363_Var
		);
		final EList<? extends EObject> Expr_363_list = LogicalOrExpression_363_Var
		.getExpr();
		Assert.assertNotNull(Expr_363_list);
		Assert.assertEquals(1, Expr_363_list.size());
		//363
		final LogicalAndExpression LogicalAndExpression_364_Var
		 = (LogicalAndExpression)Expr_363_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_364_Var
		);
		final EList<? extends EObject> Expr_364_list = LogicalAndExpression_364_Var
		.getExpr();
		Assert.assertNotNull(Expr_364_list);
		Assert.assertEquals(1, Expr_364_list.size());
		//364
		final InclusiveOrExpression InclusiveOrExpression_365_Var
		 = (InclusiveOrExpression)Expr_364_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = InclusiveOrExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final ExclusiveOrExpression ExclusiveOrExpression_366_Var
		 = (ExclusiveOrExpression)Expr_365_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_366_Var
		);
		final EList<? extends EObject> Expr_366_list = ExclusiveOrExpression_366_Var
		.getExpr();
		Assert.assertNotNull(Expr_366_list);
		Assert.assertEquals(1, Expr_366_list.size());
		//366
		final AndExpression AndExpression_367_Var
		 = (AndExpression)Expr_366_list.get(0);
		Assert.assertNotNull(AndExpression_367_Var
		);
		final EList<? extends EObject> Expr_367_list = AndExpression_367_Var
		.getExpr();
		Assert.assertNotNull(Expr_367_list);
		Assert.assertEquals(1, Expr_367_list.size());
		//367
		final EqualityExpression EqualityExpression_368_Var
		 = (EqualityExpression)Expr_367_list.get(0);
		Assert.assertNotNull(EqualityExpression_368_Var
		);
		final EList<? extends EObject> Expr_368_list = EqualityExpression_368_Var
		.getExpr();
		Assert.assertNotNull(Expr_368_list);
		Assert.assertEquals(1, Expr_368_list.size());
		//368
		final RelationalExpression RelationalExpression_369_Var
		 = (RelationalExpression)Expr_368_list.get(0);
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
		//376
		final Constant2 Constant2_377_Var
		 = (Constant2)PrimaryExpression_376_Var
		.getConst();
		Assert.assertNotNull(Constant2_377_Var
		);
		Assert.assertEquals("\"Monday is %d. day of week\\n\"", Constant2_377_Var
		.getStr());
		//377
		final AssignmentExpression AssignmentExpression_378_Var
		 = (AssignmentExpression)Expr_360_list.get(1);
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
		Assert.assertEquals("MONDAY", PrimaryExpression_393_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_341_Var
		.getSemi());
		//393
		final Statement Statement_394_Var
		 = (Statement)Statement_285_list.get(2);
		Assert.assertNotNull(Statement_394_Var
		);
		//394
		final ExpressionStatement ExpressionStatement_395_Var
		 = (ExpressionStatement)Statement_394_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_395_Var
		);
		//395
		final Expression Expression_396_Var
		 = (Expression)ExpressionStatement_395_Var
		.getExpression();
		Assert.assertNotNull(Expression_396_Var
		);
		final EList<? extends EObject> ExprExpr_396_list = Expression_396_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_396_list);
		Assert.assertEquals(1, ExprExpr_396_list.size());
		//396
		final AssignmentExpression AssignmentExpression_397_Var
		 = (AssignmentExpression)ExprExpr_396_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_412_Var
		.getId());
		final EList<? extends EObject> Suffix_412_list = PostfixExpression_411_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_412_list);
		Assert.assertEquals(1, Suffix_412_list.size());
		//412
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_413_Var
		 = (PostfixExpressionSuffixArgument)Suffix_412_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_413_Var
		);
		//413
		final ArgumentExpressionList ArgumentExpressionList_414_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_413_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_414_Var
		);
		final EList<? extends EObject> Expr_414_list = ArgumentExpressionList_414_Var
		.getExpr();
		Assert.assertNotNull(Expr_414_list);
		Assert.assertEquals(2, Expr_414_list.size());
		//414
		final AssignmentExpression AssignmentExpression_415_Var
		 = (AssignmentExpression)Expr_414_list.get(0);
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
		//430
		final Constant2 Constant2_431_Var
		 = (Constant2)PrimaryExpression_430_Var
		.getConst();
		Assert.assertNotNull(Constant2_431_Var
		);
		Assert.assertEquals("\"Sunday is %d. day of week\\n\"", Constant2_431_Var
		.getStr());
		//431
		final AssignmentExpression AssignmentExpression_432_Var
		 = (AssignmentExpression)Expr_414_list.get(1);
		Assert.assertNotNull(AssignmentExpression_432_Var
		);
		//432
		final ConditionalExpression ConditionalExpression_433_Var
		 = (ConditionalExpression)AssignmentExpression_432_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_433_Var
		);
		//433
		final LogicalOrExpression LogicalOrExpression_434_Var
		 = (LogicalOrExpression)ConditionalExpression_433_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_434_Var
		);
		final EList<? extends EObject> Expr_434_list = LogicalOrExpression_434_Var
		.getExpr();
		Assert.assertNotNull(Expr_434_list);
		Assert.assertEquals(1, Expr_434_list.size());
		//434
		final LogicalAndExpression LogicalAndExpression_435_Var
		 = (LogicalAndExpression)Expr_434_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_435_Var
		);
		final EList<? extends EObject> Expr_435_list = LogicalAndExpression_435_Var
		.getExpr();
		Assert.assertNotNull(Expr_435_list);
		Assert.assertEquals(1, Expr_435_list.size());
		//435
		final InclusiveOrExpression InclusiveOrExpression_436_Var
		 = (InclusiveOrExpression)Expr_435_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_436_Var
		);
		final EList<? extends EObject> Expr_436_list = InclusiveOrExpression_436_Var
		.getExpr();
		Assert.assertNotNull(Expr_436_list);
		Assert.assertEquals(1, Expr_436_list.size());
		//436
		final ExclusiveOrExpression ExclusiveOrExpression_437_Var
		 = (ExclusiveOrExpression)Expr_436_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_437_Var
		);
		final EList<? extends EObject> Expr_437_list = ExclusiveOrExpression_437_Var
		.getExpr();
		Assert.assertNotNull(Expr_437_list);
		Assert.assertEquals(1, Expr_437_list.size());
		//437
		final AndExpression AndExpression_438_Var
		 = (AndExpression)Expr_437_list.get(0);
		Assert.assertNotNull(AndExpression_438_Var
		);
		final EList<? extends EObject> Expr_438_list = AndExpression_438_Var
		.getExpr();
		Assert.assertNotNull(Expr_438_list);
		Assert.assertEquals(1, Expr_438_list.size());
		//438
		final EqualityExpression EqualityExpression_439_Var
		 = (EqualityExpression)Expr_438_list.get(0);
		Assert.assertNotNull(EqualityExpression_439_Var
		);
		final EList<? extends EObject> Expr_439_list = EqualityExpression_439_Var
		.getExpr();
		Assert.assertNotNull(Expr_439_list);
		Assert.assertEquals(1, Expr_439_list.size());
		//439
		final RelationalExpression RelationalExpression_440_Var
		 = (RelationalExpression)Expr_439_list.get(0);
		Assert.assertNotNull(RelationalExpression_440_Var
		);
		final EList<? extends EObject> Expr_440_list = RelationalExpression_440_Var
		.getExpr();
		Assert.assertNotNull(Expr_440_list);
		Assert.assertEquals(1, Expr_440_list.size());
		//440
		final ShiftExpression ShiftExpression_441_Var
		 = (ShiftExpression)Expr_440_list.get(0);
		Assert.assertNotNull(ShiftExpression_441_Var
		);
		final EList<? extends EObject> Expr_441_list = ShiftExpression_441_Var
		.getExpr();
		Assert.assertNotNull(Expr_441_list);
		Assert.assertEquals(1, Expr_441_list.size());
		//441
		final AdditiveExpression AdditiveExpression_442_Var
		 = (AdditiveExpression)Expr_441_list.get(0);
		Assert.assertNotNull(AdditiveExpression_442_Var
		);
		final EList<? extends EObject> Expr_442_list = AdditiveExpression_442_Var
		.getExpr();
		Assert.assertNotNull(Expr_442_list);
		Assert.assertEquals(1, Expr_442_list.size());
		//442
		final MultiplicativeExpression MultiplicativeExpression_443_Var
		 = (MultiplicativeExpression)Expr_442_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_443_Var
		);
		final EList<? extends EObject> Expr_443_list = MultiplicativeExpression_443_Var
		.getExpr();
		Assert.assertNotNull(Expr_443_list);
		Assert.assertEquals(1, Expr_443_list.size());
		//443
		final CastExpression CastExpression_444_Var
		 = (CastExpression)Expr_443_list.get(0);
		Assert.assertNotNull(CastExpression_444_Var
		);
		//444
		final UnaryExpression UnaryExpression_445_Var
		 = (UnaryExpression)CastExpression_444_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_445_Var
		);
		//445
		final PostfixExpression PostfixExpression_446_Var
		 = (PostfixExpression)UnaryExpression_445_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_446_Var
		);
		final EList<? extends EObject> Expr_446_list = PostfixExpression_446_Var
		.getExpr();
		Assert.assertNotNull(Expr_446_list);
		Assert.assertEquals(1, Expr_446_list.size());
		//446
		final PrimaryExpression PrimaryExpression_447_Var
		 = (PrimaryExpression)Expr_446_list.get(0);
		Assert.assertNotNull(PrimaryExpression_447_Var
		);
		Assert.assertEquals("W_SUNDAY", PrimaryExpression_447_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_395_Var
		.getSemi());
		//447
		final Statement Statement_448_Var
		 = (Statement)Statement_285_list.get(3);
		Assert.assertNotNull(Statement_448_Var
		);
		//448
		final ExpressionStatement ExpressionStatement_449_Var
		 = (ExpressionStatement)Statement_448_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_449_Var
		);
		//449
		final Expression Expression_450_Var
		 = (Expression)ExpressionStatement_449_Var
		.getExpression();
		Assert.assertNotNull(Expression_450_Var
		);
		final EList<? extends EObject> ExprExpr_450_list = Expression_450_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_450_list);
		Assert.assertEquals(1, ExprExpr_450_list.size());
		//450
		final AssignmentExpression AssignmentExpression_451_Var
		 = (AssignmentExpression)ExprExpr_450_list.get(0);
		Assert.assertNotNull(AssignmentExpression_451_Var
		);
		//451
		final ConditionalExpression ConditionalExpression_452_Var
		 = (ConditionalExpression)AssignmentExpression_451_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_452_Var
		);
		//452
		final LogicalOrExpression LogicalOrExpression_453_Var
		 = (LogicalOrExpression)ConditionalExpression_452_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_453_Var
		);
		final EList<? extends EObject> Expr_453_list = LogicalOrExpression_453_Var
		.getExpr();
		Assert.assertNotNull(Expr_453_list);
		Assert.assertEquals(1, Expr_453_list.size());
		//453
		final LogicalAndExpression LogicalAndExpression_454_Var
		 = (LogicalAndExpression)Expr_453_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_454_Var
		);
		final EList<? extends EObject> Expr_454_list = LogicalAndExpression_454_Var
		.getExpr();
		Assert.assertNotNull(Expr_454_list);
		Assert.assertEquals(1, Expr_454_list.size());
		//454
		final InclusiveOrExpression InclusiveOrExpression_455_Var
		 = (InclusiveOrExpression)Expr_454_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_455_Var
		);
		final EList<? extends EObject> Expr_455_list = InclusiveOrExpression_455_Var
		.getExpr();
		Assert.assertNotNull(Expr_455_list);
		Assert.assertEquals(1, Expr_455_list.size());
		//455
		final ExclusiveOrExpression ExclusiveOrExpression_456_Var
		 = (ExclusiveOrExpression)Expr_455_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_456_Var
		);
		final EList<? extends EObject> Expr_456_list = ExclusiveOrExpression_456_Var
		.getExpr();
		Assert.assertNotNull(Expr_456_list);
		Assert.assertEquals(1, Expr_456_list.size());
		//456
		final AndExpression AndExpression_457_Var
		 = (AndExpression)Expr_456_list.get(0);
		Assert.assertNotNull(AndExpression_457_Var
		);
		final EList<? extends EObject> Expr_457_list = AndExpression_457_Var
		.getExpr();
		Assert.assertNotNull(Expr_457_list);
		Assert.assertEquals(1, Expr_457_list.size());
		//457
		final EqualityExpression EqualityExpression_458_Var
		 = (EqualityExpression)Expr_457_list.get(0);
		Assert.assertNotNull(EqualityExpression_458_Var
		);
		final EList<? extends EObject> Expr_458_list = EqualityExpression_458_Var
		.getExpr();
		Assert.assertNotNull(Expr_458_list);
		Assert.assertEquals(1, Expr_458_list.size());
		//458
		final RelationalExpression RelationalExpression_459_Var
		 = (RelationalExpression)Expr_458_list.get(0);
		Assert.assertNotNull(RelationalExpression_459_Var
		);
		final EList<? extends EObject> Expr_459_list = RelationalExpression_459_Var
		.getExpr();
		Assert.assertNotNull(Expr_459_list);
		Assert.assertEquals(1, Expr_459_list.size());
		//459
		final ShiftExpression ShiftExpression_460_Var
		 = (ShiftExpression)Expr_459_list.get(0);
		Assert.assertNotNull(ShiftExpression_460_Var
		);
		final EList<? extends EObject> Expr_460_list = ShiftExpression_460_Var
		.getExpr();
		Assert.assertNotNull(Expr_460_list);
		Assert.assertEquals(1, Expr_460_list.size());
		//460
		final AdditiveExpression AdditiveExpression_461_Var
		 = (AdditiveExpression)Expr_460_list.get(0);
		Assert.assertNotNull(AdditiveExpression_461_Var
		);
		final EList<? extends EObject> Expr_461_list = AdditiveExpression_461_Var
		.getExpr();
		Assert.assertNotNull(Expr_461_list);
		Assert.assertEquals(1, Expr_461_list.size());
		//461
		final MultiplicativeExpression MultiplicativeExpression_462_Var
		 = (MultiplicativeExpression)Expr_461_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_462_Var
		);
		final EList<? extends EObject> Expr_462_list = MultiplicativeExpression_462_Var
		.getExpr();
		Assert.assertNotNull(Expr_462_list);
		Assert.assertEquals(1, Expr_462_list.size());
		//462
		final CastExpression CastExpression_463_Var
		 = (CastExpression)Expr_462_list.get(0);
		Assert.assertNotNull(CastExpression_463_Var
		);
		//463
		final UnaryExpression UnaryExpression_464_Var
		 = (UnaryExpression)CastExpression_463_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_464_Var
		);
		//464
		final PostfixExpression PostfixExpression_465_Var
		 = (PostfixExpression)UnaryExpression_464_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_465_Var
		);
		final EList<? extends EObject> Expr_465_list = PostfixExpression_465_Var
		.getExpr();
		Assert.assertNotNull(Expr_465_list);
		Assert.assertEquals(1, Expr_465_list.size());
		//465
		final PrimaryExpression PrimaryExpression_466_Var
		 = (PrimaryExpression)Expr_465_list.get(0);
		Assert.assertNotNull(PrimaryExpression_466_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_466_Var
		.getId());
		final EList<? extends EObject> Suffix_466_list = PostfixExpression_465_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_466_list);
		Assert.assertEquals(1, Suffix_466_list.size());
		//466
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_467_Var
		 = (PostfixExpressionSuffixArgument)Suffix_466_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_467_Var
		);
		//467
		final ArgumentExpressionList ArgumentExpressionList_468_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_467_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_468_Var
		);
		final EList<? extends EObject> Expr_468_list = ArgumentExpressionList_468_Var
		.getExpr();
		Assert.assertNotNull(Expr_468_list);
		Assert.assertEquals(2, Expr_468_list.size());
		//468
		final AssignmentExpression AssignmentExpression_469_Var
		 = (AssignmentExpression)Expr_468_list.get(0);
		Assert.assertNotNull(AssignmentExpression_469_Var
		);
		//469
		final ConditionalExpression ConditionalExpression_470_Var
		 = (ConditionalExpression)AssignmentExpression_469_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_470_Var
		);
		//470
		final LogicalOrExpression LogicalOrExpression_471_Var
		 = (LogicalOrExpression)ConditionalExpression_470_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_471_Var
		);
		final EList<? extends EObject> Expr_471_list = LogicalOrExpression_471_Var
		.getExpr();
		Assert.assertNotNull(Expr_471_list);
		Assert.assertEquals(1, Expr_471_list.size());
		//471
		final LogicalAndExpression LogicalAndExpression_472_Var
		 = (LogicalAndExpression)Expr_471_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_472_Var
		);
		final EList<? extends EObject> Expr_472_list = LogicalAndExpression_472_Var
		.getExpr();
		Assert.assertNotNull(Expr_472_list);
		Assert.assertEquals(1, Expr_472_list.size());
		//472
		final InclusiveOrExpression InclusiveOrExpression_473_Var
		 = (InclusiveOrExpression)Expr_472_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_473_Var
		);
		final EList<? extends EObject> Expr_473_list = InclusiveOrExpression_473_Var
		.getExpr();
		Assert.assertNotNull(Expr_473_list);
		Assert.assertEquals(1, Expr_473_list.size());
		//473
		final ExclusiveOrExpression ExclusiveOrExpression_474_Var
		 = (ExclusiveOrExpression)Expr_473_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_474_Var
		);
		final EList<? extends EObject> Expr_474_list = ExclusiveOrExpression_474_Var
		.getExpr();
		Assert.assertNotNull(Expr_474_list);
		Assert.assertEquals(1, Expr_474_list.size());
		//474
		final AndExpression AndExpression_475_Var
		 = (AndExpression)Expr_474_list.get(0);
		Assert.assertNotNull(AndExpression_475_Var
		);
		final EList<? extends EObject> Expr_475_list = AndExpression_475_Var
		.getExpr();
		Assert.assertNotNull(Expr_475_list);
		Assert.assertEquals(1, Expr_475_list.size());
		//475
		final EqualityExpression EqualityExpression_476_Var
		 = (EqualityExpression)Expr_475_list.get(0);
		Assert.assertNotNull(EqualityExpression_476_Var
		);
		final EList<? extends EObject> Expr_476_list = EqualityExpression_476_Var
		.getExpr();
		Assert.assertNotNull(Expr_476_list);
		Assert.assertEquals(1, Expr_476_list.size());
		//476
		final RelationalExpression RelationalExpression_477_Var
		 = (RelationalExpression)Expr_476_list.get(0);
		Assert.assertNotNull(RelationalExpression_477_Var
		);
		final EList<? extends EObject> Expr_477_list = RelationalExpression_477_Var
		.getExpr();
		Assert.assertNotNull(Expr_477_list);
		Assert.assertEquals(1, Expr_477_list.size());
		//477
		final ShiftExpression ShiftExpression_478_Var
		 = (ShiftExpression)Expr_477_list.get(0);
		Assert.assertNotNull(ShiftExpression_478_Var
		);
		final EList<? extends EObject> Expr_478_list = ShiftExpression_478_Var
		.getExpr();
		Assert.assertNotNull(Expr_478_list);
		Assert.assertEquals(1, Expr_478_list.size());
		//478
		final AdditiveExpression AdditiveExpression_479_Var
		 = (AdditiveExpression)Expr_478_list.get(0);
		Assert.assertNotNull(AdditiveExpression_479_Var
		);
		final EList<? extends EObject> Expr_479_list = AdditiveExpression_479_Var
		.getExpr();
		Assert.assertNotNull(Expr_479_list);
		Assert.assertEquals(1, Expr_479_list.size());
		//479
		final MultiplicativeExpression MultiplicativeExpression_480_Var
		 = (MultiplicativeExpression)Expr_479_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_480_Var
		);
		final EList<? extends EObject> Expr_480_list = MultiplicativeExpression_480_Var
		.getExpr();
		Assert.assertNotNull(Expr_480_list);
		Assert.assertEquals(1, Expr_480_list.size());
		//480
		final CastExpression CastExpression_481_Var
		 = (CastExpression)Expr_480_list.get(0);
		Assert.assertNotNull(CastExpression_481_Var
		);
		//481
		final UnaryExpression UnaryExpression_482_Var
		 = (UnaryExpression)CastExpression_481_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_482_Var
		);
		//482
		final PostfixExpression PostfixExpression_483_Var
		 = (PostfixExpression)UnaryExpression_482_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_483_Var
		);
		final EList<? extends EObject> Expr_483_list = PostfixExpression_483_Var
		.getExpr();
		Assert.assertNotNull(Expr_483_list);
		Assert.assertEquals(1, Expr_483_list.size());
		//483
		final PrimaryExpression PrimaryExpression_484_Var
		 = (PrimaryExpression)Expr_483_list.get(0);
		Assert.assertNotNull(PrimaryExpression_484_Var
		);
		//484
		final Constant2 Constant2_485_Var
		 = (Constant2)PrimaryExpression_484_Var
		.getConst();
		Assert.assertNotNull(Constant2_485_Var
		);
		Assert.assertEquals("\"Sunday is %d. day of week\\n\"", Constant2_485_Var
		.getStr());
		//485
		final AssignmentExpression AssignmentExpression_486_Var
		 = (AssignmentExpression)Expr_468_list.get(1);
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
		Assert.assertEquals("SUNDAY", PrimaryExpression_501_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_449_Var
		.getSemi());
		//501
		final Statement Statement_502_Var
		 = (Statement)Statement_285_list.get(4);
		Assert.assertNotNull(Statement_502_Var
		);
		//502
		final ExpressionStatement ExpressionStatement_503_Var
		 = (ExpressionStatement)Statement_502_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_503_Var
		);
		//503
		final Expression Expression_504_Var
		 = (Expression)ExpressionStatement_503_Var
		.getExpression();
		Assert.assertNotNull(Expression_504_Var
		);
		final EList<? extends EObject> ExprExpr_504_list = Expression_504_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_504_list);
		Assert.assertEquals(1, ExprExpr_504_list.size());
		//504
		final AssignmentExpression AssignmentExpression_505_Var
		 = (AssignmentExpression)ExprExpr_504_list.get(0);
		Assert.assertNotNull(AssignmentExpression_505_Var
		);
		//505
		final UnaryExpression UnaryExpression_506_Var
		 = (UnaryExpression)AssignmentExpression_505_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_506_Var
		);
		//506
		final PostfixExpression PostfixExpression_507_Var
		 = (PostfixExpression)UnaryExpression_506_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_507_Var
		);
		final EList<? extends EObject> Expr_507_list = PostfixExpression_507_Var
		.getExpr();
		Assert.assertNotNull(Expr_507_list);
		Assert.assertEquals(1, Expr_507_list.size());
		//507
		final PrimaryExpression PrimaryExpression_508_Var
		 = (PrimaryExpression)Expr_507_list.get(0);
		Assert.assertNotNull(PrimaryExpression_508_Var
		);
		Assert.assertEquals("iAmInLove", PrimaryExpression_508_Var
		.getId());
		//508
		final AssignmentOperator AssignmentOperator_509_Var
		 = (AssignmentOperator)AssignmentExpression_505_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_509_Var
		);
		Assert.assertEquals("=", AssignmentOperator_509_Var
		.getOp());
		//509
		final AssignmentExpression AssignmentExpression_510_Var
		 = (AssignmentExpression)AssignmentExpression_505_Var
		.getAssignmentExpr();
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
		Assert.assertEquals("I_FRIDAY", PrimaryExpression_525_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_503_Var
		.getSemi());
		//525
		final Statement Statement_526_Var
		 = (Statement)Statement_285_list.get(5);
		Assert.assertNotNull(Statement_526_Var
		);
		//526
		final ExpressionStatement ExpressionStatement_527_Var
		 = (ExpressionStatement)Statement_526_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_527_Var
		);
		//527
		final Expression Expression_528_Var
		 = (Expression)ExpressionStatement_527_Var
		.getExpression();
		Assert.assertNotNull(Expression_528_Var
		);
		final EList<? extends EObject> ExprExpr_528_list = Expression_528_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_528_list);
		Assert.assertEquals(1, ExprExpr_528_list.size());
		//528
		final AssignmentExpression AssignmentExpression_529_Var
		 = (AssignmentExpression)ExprExpr_528_list.get(0);
		Assert.assertNotNull(AssignmentExpression_529_Var
		);
		//529
		final ConditionalExpression ConditionalExpression_530_Var
		 = (ConditionalExpression)AssignmentExpression_529_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_530_Var
		);
		//530
		final LogicalOrExpression LogicalOrExpression_531_Var
		 = (LogicalOrExpression)ConditionalExpression_530_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_531_Var
		);
		final EList<? extends EObject> Expr_531_list = LogicalOrExpression_531_Var
		.getExpr();
		Assert.assertNotNull(Expr_531_list);
		Assert.assertEquals(1, Expr_531_list.size());
		//531
		final LogicalAndExpression LogicalAndExpression_532_Var
		 = (LogicalAndExpression)Expr_531_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_532_Var
		);
		final EList<? extends EObject> Expr_532_list = LogicalAndExpression_532_Var
		.getExpr();
		Assert.assertNotNull(Expr_532_list);
		Assert.assertEquals(1, Expr_532_list.size());
		//532
		final InclusiveOrExpression InclusiveOrExpression_533_Var
		 = (InclusiveOrExpression)Expr_532_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_533_Var
		);
		final EList<? extends EObject> Expr_533_list = InclusiveOrExpression_533_Var
		.getExpr();
		Assert.assertNotNull(Expr_533_list);
		Assert.assertEquals(1, Expr_533_list.size());
		//533
		final ExclusiveOrExpression ExclusiveOrExpression_534_Var
		 = (ExclusiveOrExpression)Expr_533_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_534_Var
		);
		final EList<? extends EObject> Expr_534_list = ExclusiveOrExpression_534_Var
		.getExpr();
		Assert.assertNotNull(Expr_534_list);
		Assert.assertEquals(1, Expr_534_list.size());
		//534
		final AndExpression AndExpression_535_Var
		 = (AndExpression)Expr_534_list.get(0);
		Assert.assertNotNull(AndExpression_535_Var
		);
		final EList<? extends EObject> Expr_535_list = AndExpression_535_Var
		.getExpr();
		Assert.assertNotNull(Expr_535_list);
		Assert.assertEquals(1, Expr_535_list.size());
		//535
		final EqualityExpression EqualityExpression_536_Var
		 = (EqualityExpression)Expr_535_list.get(0);
		Assert.assertNotNull(EqualityExpression_536_Var
		);
		final EList<? extends EObject> Expr_536_list = EqualityExpression_536_Var
		.getExpr();
		Assert.assertNotNull(Expr_536_list);
		Assert.assertEquals(1, Expr_536_list.size());
		//536
		final RelationalExpression RelationalExpression_537_Var
		 = (RelationalExpression)Expr_536_list.get(0);
		Assert.assertNotNull(RelationalExpression_537_Var
		);
		final EList<? extends EObject> Expr_537_list = RelationalExpression_537_Var
		.getExpr();
		Assert.assertNotNull(Expr_537_list);
		Assert.assertEquals(1, Expr_537_list.size());
		//537
		final ShiftExpression ShiftExpression_538_Var
		 = (ShiftExpression)Expr_537_list.get(0);
		Assert.assertNotNull(ShiftExpression_538_Var
		);
		final EList<? extends EObject> Expr_538_list = ShiftExpression_538_Var
		.getExpr();
		Assert.assertNotNull(Expr_538_list);
		Assert.assertEquals(1, Expr_538_list.size());
		//538
		final AdditiveExpression AdditiveExpression_539_Var
		 = (AdditiveExpression)Expr_538_list.get(0);
		Assert.assertNotNull(AdditiveExpression_539_Var
		);
		final EList<? extends EObject> Expr_539_list = AdditiveExpression_539_Var
		.getExpr();
		Assert.assertNotNull(Expr_539_list);
		Assert.assertEquals(1, Expr_539_list.size());
		//539
		final MultiplicativeExpression MultiplicativeExpression_540_Var
		 = (MultiplicativeExpression)Expr_539_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_540_Var
		);
		final EList<? extends EObject> Expr_540_list = MultiplicativeExpression_540_Var
		.getExpr();
		Assert.assertNotNull(Expr_540_list);
		Assert.assertEquals(1, Expr_540_list.size());
		//540
		final CastExpression CastExpression_541_Var
		 = (CastExpression)Expr_540_list.get(0);
		Assert.assertNotNull(CastExpression_541_Var
		);
		//541
		final UnaryExpression UnaryExpression_542_Var
		 = (UnaryExpression)CastExpression_541_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_542_Var
		);
		//542
		final PostfixExpression PostfixExpression_543_Var
		 = (PostfixExpression)UnaryExpression_542_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_543_Var
		);
		final EList<? extends EObject> Expr_543_list = PostfixExpression_543_Var
		.getExpr();
		Assert.assertNotNull(Expr_543_list);
		Assert.assertEquals(1, Expr_543_list.size());
		//543
		final PrimaryExpression PrimaryExpression_544_Var
		 = (PrimaryExpression)Expr_543_list.get(0);
		Assert.assertNotNull(PrimaryExpression_544_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_544_Var
		.getId());
		final EList<? extends EObject> Suffix_544_list = PostfixExpression_543_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_544_list);
		Assert.assertEquals(1, Suffix_544_list.size());
		//544
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_545_Var
		 = (PostfixExpressionSuffixArgument)Suffix_544_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_545_Var
		);
		//545
		final ArgumentExpressionList ArgumentExpressionList_546_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_545_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_546_Var
		);
		final EList<? extends EObject> Expr_546_list = ArgumentExpressionList_546_Var
		.getExpr();
		Assert.assertNotNull(Expr_546_list);
		Assert.assertEquals(2, Expr_546_list.size());
		//546
		final AssignmentExpression AssignmentExpression_547_Var
		 = (AssignmentExpression)Expr_546_list.get(0);
		Assert.assertNotNull(AssignmentExpression_547_Var
		);
		//547
		final ConditionalExpression ConditionalExpression_548_Var
		 = (ConditionalExpression)AssignmentExpression_547_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_548_Var
		);
		//548
		final LogicalOrExpression LogicalOrExpression_549_Var
		 = (LogicalOrExpression)ConditionalExpression_548_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_549_Var
		);
		final EList<? extends EObject> Expr_549_list = LogicalOrExpression_549_Var
		.getExpr();
		Assert.assertNotNull(Expr_549_list);
		Assert.assertEquals(1, Expr_549_list.size());
		//549
		final LogicalAndExpression LogicalAndExpression_550_Var
		 = (LogicalAndExpression)Expr_549_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_550_Var
		);
		final EList<? extends EObject> Expr_550_list = LogicalAndExpression_550_Var
		.getExpr();
		Assert.assertNotNull(Expr_550_list);
		Assert.assertEquals(1, Expr_550_list.size());
		//550
		final InclusiveOrExpression InclusiveOrExpression_551_Var
		 = (InclusiveOrExpression)Expr_550_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_551_Var
		);
		final EList<? extends EObject> Expr_551_list = InclusiveOrExpression_551_Var
		.getExpr();
		Assert.assertNotNull(Expr_551_list);
		Assert.assertEquals(1, Expr_551_list.size());
		//551
		final ExclusiveOrExpression ExclusiveOrExpression_552_Var
		 = (ExclusiveOrExpression)Expr_551_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_552_Var
		);
		final EList<? extends EObject> Expr_552_list = ExclusiveOrExpression_552_Var
		.getExpr();
		Assert.assertNotNull(Expr_552_list);
		Assert.assertEquals(1, Expr_552_list.size());
		//552
		final AndExpression AndExpression_553_Var
		 = (AndExpression)Expr_552_list.get(0);
		Assert.assertNotNull(AndExpression_553_Var
		);
		final EList<? extends EObject> Expr_553_list = AndExpression_553_Var
		.getExpr();
		Assert.assertNotNull(Expr_553_list);
		Assert.assertEquals(1, Expr_553_list.size());
		//553
		final EqualityExpression EqualityExpression_554_Var
		 = (EqualityExpression)Expr_553_list.get(0);
		Assert.assertNotNull(EqualityExpression_554_Var
		);
		final EList<? extends EObject> Expr_554_list = EqualityExpression_554_Var
		.getExpr();
		Assert.assertNotNull(Expr_554_list);
		Assert.assertEquals(1, Expr_554_list.size());
		//554
		final RelationalExpression RelationalExpression_555_Var
		 = (RelationalExpression)Expr_554_list.get(0);
		Assert.assertNotNull(RelationalExpression_555_Var
		);
		final EList<? extends EObject> Expr_555_list = RelationalExpression_555_Var
		.getExpr();
		Assert.assertNotNull(Expr_555_list);
		Assert.assertEquals(1, Expr_555_list.size());
		//555
		final ShiftExpression ShiftExpression_556_Var
		 = (ShiftExpression)Expr_555_list.get(0);
		Assert.assertNotNull(ShiftExpression_556_Var
		);
		final EList<? extends EObject> Expr_556_list = ShiftExpression_556_Var
		.getExpr();
		Assert.assertNotNull(Expr_556_list);
		Assert.assertEquals(1, Expr_556_list.size());
		//556
		final AdditiveExpression AdditiveExpression_557_Var
		 = (AdditiveExpression)Expr_556_list.get(0);
		Assert.assertNotNull(AdditiveExpression_557_Var
		);
		final EList<? extends EObject> Expr_557_list = AdditiveExpression_557_Var
		.getExpr();
		Assert.assertNotNull(Expr_557_list);
		Assert.assertEquals(1, Expr_557_list.size());
		//557
		final MultiplicativeExpression MultiplicativeExpression_558_Var
		 = (MultiplicativeExpression)Expr_557_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_558_Var
		);
		final EList<? extends EObject> Expr_558_list = MultiplicativeExpression_558_Var
		.getExpr();
		Assert.assertNotNull(Expr_558_list);
		Assert.assertEquals(1, Expr_558_list.size());
		//558
		final CastExpression CastExpression_559_Var
		 = (CastExpression)Expr_558_list.get(0);
		Assert.assertNotNull(CastExpression_559_Var
		);
		//559
		final UnaryExpression UnaryExpression_560_Var
		 = (UnaryExpression)CastExpression_559_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_560_Var
		);
		//560
		final PostfixExpression PostfixExpression_561_Var
		 = (PostfixExpression)UnaryExpression_560_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_561_Var
		);
		final EList<? extends EObject> Expr_561_list = PostfixExpression_561_Var
		.getExpr();
		Assert.assertNotNull(Expr_561_list);
		Assert.assertEquals(1, Expr_561_list.size());
		//561
		final PrimaryExpression PrimaryExpression_562_Var
		 = (PrimaryExpression)Expr_561_list.get(0);
		Assert.assertNotNull(PrimaryExpression_562_Var
		);
		//562
		final Constant2 Constant2_563_Var
		 = (Constant2)PrimaryExpression_562_Var
		.getConst();
		Assert.assertNotNull(Constant2_563_Var
		);
		Assert.assertEquals("\"The %d. day of the week is my favourite!\\n\"", Constant2_563_Var
		.getStr());
		//563
		final AssignmentExpression AssignmentExpression_564_Var
		 = (AssignmentExpression)Expr_546_list.get(1);
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
		Assert.assertEquals("iAmInLove", PrimaryExpression_579_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_527_Var
		.getSemi());
		//579
		final Statement Statement_580_Var
		 = (Statement)Statement_285_list.get(6);
		Assert.assertNotNull(Statement_580_Var
		);
		//580
		final ExpressionStatement ExpressionStatement_581_Var
		 = (ExpressionStatement)Statement_580_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_581_Var
		);
		//581
		final Expression Expression_582_Var
		 = (Expression)ExpressionStatement_581_Var
		.getExpression();
		Assert.assertNotNull(Expression_582_Var
		);
		final EList<? extends EObject> ExprExpr_582_list = Expression_582_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_582_list);
		Assert.assertEquals(1, ExprExpr_582_list.size());
		//582
		final AssignmentExpression AssignmentExpression_583_Var
		 = (AssignmentExpression)ExprExpr_582_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_598_Var
		.getId());
		final EList<? extends EObject> Suffix_598_list = PostfixExpression_597_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_598_list);
		Assert.assertEquals(1, Suffix_598_list.size());
		//598
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_599_Var
		 = (PostfixExpressionSuffixArgument)Suffix_598_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_599_Var
		);
		//599
		final ArgumentExpressionList ArgumentExpressionList_600_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_599_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_600_Var
		);
		final EList<? extends EObject> Expr_600_list = ArgumentExpressionList_600_Var
		.getExpr();
		Assert.assertNotNull(Expr_600_list);
		Assert.assertEquals(2, Expr_600_list.size());
		//600
		final AssignmentExpression AssignmentExpression_601_Var
		 = (AssignmentExpression)Expr_600_list.get(0);
		Assert.assertNotNull(AssignmentExpression_601_Var
		);
		//601
		final ConditionalExpression ConditionalExpression_602_Var
		 = (ConditionalExpression)AssignmentExpression_601_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_602_Var
		);
		//602
		final LogicalOrExpression LogicalOrExpression_603_Var
		 = (LogicalOrExpression)ConditionalExpression_602_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_603_Var
		);
		final EList<? extends EObject> Expr_603_list = LogicalOrExpression_603_Var
		.getExpr();
		Assert.assertNotNull(Expr_603_list);
		Assert.assertEquals(1, Expr_603_list.size());
		//603
		final LogicalAndExpression LogicalAndExpression_604_Var
		 = (LogicalAndExpression)Expr_603_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_604_Var
		);
		final EList<? extends EObject> Expr_604_list = LogicalAndExpression_604_Var
		.getExpr();
		Assert.assertNotNull(Expr_604_list);
		Assert.assertEquals(1, Expr_604_list.size());
		//604
		final InclusiveOrExpression InclusiveOrExpression_605_Var
		 = (InclusiveOrExpression)Expr_604_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_605_Var
		);
		final EList<? extends EObject> Expr_605_list = InclusiveOrExpression_605_Var
		.getExpr();
		Assert.assertNotNull(Expr_605_list);
		Assert.assertEquals(1, Expr_605_list.size());
		//605
		final ExclusiveOrExpression ExclusiveOrExpression_606_Var
		 = (ExclusiveOrExpression)Expr_605_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_606_Var
		);
		final EList<? extends EObject> Expr_606_list = ExclusiveOrExpression_606_Var
		.getExpr();
		Assert.assertNotNull(Expr_606_list);
		Assert.assertEquals(1, Expr_606_list.size());
		//606
		final AndExpression AndExpression_607_Var
		 = (AndExpression)Expr_606_list.get(0);
		Assert.assertNotNull(AndExpression_607_Var
		);
		final EList<? extends EObject> Expr_607_list = AndExpression_607_Var
		.getExpr();
		Assert.assertNotNull(Expr_607_list);
		Assert.assertEquals(1, Expr_607_list.size());
		//607
		final EqualityExpression EqualityExpression_608_Var
		 = (EqualityExpression)Expr_607_list.get(0);
		Assert.assertNotNull(EqualityExpression_608_Var
		);
		final EList<? extends EObject> Expr_608_list = EqualityExpression_608_Var
		.getExpr();
		Assert.assertNotNull(Expr_608_list);
		Assert.assertEquals(1, Expr_608_list.size());
		//608
		final RelationalExpression RelationalExpression_609_Var
		 = (RelationalExpression)Expr_608_list.get(0);
		Assert.assertNotNull(RelationalExpression_609_Var
		);
		final EList<? extends EObject> Expr_609_list = RelationalExpression_609_Var
		.getExpr();
		Assert.assertNotNull(Expr_609_list);
		Assert.assertEquals(1, Expr_609_list.size());
		//609
		final ShiftExpression ShiftExpression_610_Var
		 = (ShiftExpression)Expr_609_list.get(0);
		Assert.assertNotNull(ShiftExpression_610_Var
		);
		final EList<? extends EObject> Expr_610_list = ShiftExpression_610_Var
		.getExpr();
		Assert.assertNotNull(Expr_610_list);
		Assert.assertEquals(1, Expr_610_list.size());
		//610
		final AdditiveExpression AdditiveExpression_611_Var
		 = (AdditiveExpression)Expr_610_list.get(0);
		Assert.assertNotNull(AdditiveExpression_611_Var
		);
		final EList<? extends EObject> Expr_611_list = AdditiveExpression_611_Var
		.getExpr();
		Assert.assertNotNull(Expr_611_list);
		Assert.assertEquals(1, Expr_611_list.size());
		//611
		final MultiplicativeExpression MultiplicativeExpression_612_Var
		 = (MultiplicativeExpression)Expr_611_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_612_Var
		);
		final EList<? extends EObject> Expr_612_list = MultiplicativeExpression_612_Var
		.getExpr();
		Assert.assertNotNull(Expr_612_list);
		Assert.assertEquals(1, Expr_612_list.size());
		//612
		final CastExpression CastExpression_613_Var
		 = (CastExpression)Expr_612_list.get(0);
		Assert.assertNotNull(CastExpression_613_Var
		);
		//613
		final UnaryExpression UnaryExpression_614_Var
		 = (UnaryExpression)CastExpression_613_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_614_Var
		);
		//614
		final PostfixExpression PostfixExpression_615_Var
		 = (PostfixExpression)UnaryExpression_614_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_615_Var
		);
		final EList<? extends EObject> Expr_615_list = PostfixExpression_615_Var
		.getExpr();
		Assert.assertNotNull(Expr_615_list);
		Assert.assertEquals(1, Expr_615_list.size());
		//615
		final PrimaryExpression PrimaryExpression_616_Var
		 = (PrimaryExpression)Expr_615_list.get(0);
		Assert.assertNotNull(PrimaryExpression_616_Var
		);
		//616
		final Constant2 Constant2_617_Var
		 = (Constant2)PrimaryExpression_616_Var
		.getConst();
		Assert.assertNotNull(Constant2_617_Var
		);
		Assert.assertEquals("\"The %d. day of the week is my favourite!\\n\"", Constant2_617_Var
		.getStr());
		//617
		final AssignmentExpression AssignmentExpression_618_Var
		 = (AssignmentExpression)Expr_600_list.get(1);
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
		Assert.assertEquals("my_weekday", PrimaryExpression_633_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_581_Var
		.getSemi());
		//633
		final Statement Statement_634_Var
		 = (Statement)Statement_285_list.get(7);
		Assert.assertNotNull(Statement_634_Var
		);
		//634
		final JumpStatement JumpStatement_635_Var
		 = (JumpStatement)Statement_634_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_635_Var
		);
		//635
		final Expression Expression_636_Var
		 = (Expression)JumpStatement_635_Var
		.getExpr();
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
		//652
		final Constant2 Constant2_653_Var
		 = (Constant2)PrimaryExpression_652_Var
		.getConst();
		Assert.assertNotNull(Constant2_653_Var
		);
		Assert.assertEquals("0", Constant2_653_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_635_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_635_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0031_Enums.c");
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
				method.invoke(this.generator, "Test0031_Enums.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0031_Enums.c");
		final String expected = this.getTextFromFile(
			"res/Test0031_Enums.c"
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


