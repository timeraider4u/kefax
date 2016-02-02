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
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
	
	@Test (timeout=1000)
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
				"RULE_SKW_COMMA",
				"RULE_WHITESPACE",
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
	
	@Test (timeout=1000)
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
		Assert.assertEquals("[\"Monday is %d. day of week\\n\"]", PrimaryExpression_322_Var
		.getString().toString());
		//322
		final AssignmentExpression AssignmentExpression_323_Var
		 = (AssignmentExpression)Expr_306_list.get(1);
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
		Assert.assertEquals("W_MONDAY", PrimaryExpression_338_Var
		.getId());
		//338
		final Statement Statement_339_Var
		 = (Statement)Statement_285_list.get(1);
		Assert.assertNotNull(Statement_339_Var
		);
		//339
		final ExpressionStatement ExpressionStatement_340_Var
		 = (ExpressionStatement)Statement_339_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_340_Var
		);
		//340
		final Expression Expression_341_Var
		 = (Expression)ExpressionStatement_340_Var
		.getExpression();
		Assert.assertNotNull(Expression_341_Var
		);
		final EList<? extends EObject> ExprExpr_341_list = Expression_341_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_341_list);
		Assert.assertEquals(1, ExprExpr_341_list.size());
		//341
		final AssignmentExpression AssignmentExpression_342_Var
		 = (AssignmentExpression)ExprExpr_341_list.get(0);
		Assert.assertNotNull(AssignmentExpression_342_Var
		);
		//342
		final ConditionalExpression ConditionalExpression_343_Var
		 = (ConditionalExpression)AssignmentExpression_342_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_343_Var
		);
		//343
		final LogicalOrExpression LogicalOrExpression_344_Var
		 = (LogicalOrExpression)ConditionalExpression_343_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_344_Var
		);
		final EList<? extends EObject> Expr_344_list = LogicalOrExpression_344_Var
		.getExpr();
		Assert.assertNotNull(Expr_344_list);
		Assert.assertEquals(1, Expr_344_list.size());
		//344
		final LogicalAndExpression LogicalAndExpression_345_Var
		 = (LogicalAndExpression)Expr_344_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_345_Var
		);
		final EList<? extends EObject> Expr_345_list = LogicalAndExpression_345_Var
		.getExpr();
		Assert.assertNotNull(Expr_345_list);
		Assert.assertEquals(1, Expr_345_list.size());
		//345
		final InclusiveOrExpression InclusiveOrExpression_346_Var
		 = (InclusiveOrExpression)Expr_345_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_346_Var
		);
		final EList<? extends EObject> Expr_346_list = InclusiveOrExpression_346_Var
		.getExpr();
		Assert.assertNotNull(Expr_346_list);
		Assert.assertEquals(1, Expr_346_list.size());
		//346
		final ExclusiveOrExpression ExclusiveOrExpression_347_Var
		 = (ExclusiveOrExpression)Expr_346_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_347_Var
		);
		final EList<? extends EObject> Expr_347_list = ExclusiveOrExpression_347_Var
		.getExpr();
		Assert.assertNotNull(Expr_347_list);
		Assert.assertEquals(1, Expr_347_list.size());
		//347
		final AndExpression AndExpression_348_Var
		 = (AndExpression)Expr_347_list.get(0);
		Assert.assertNotNull(AndExpression_348_Var
		);
		final EList<? extends EObject> Expr_348_list = AndExpression_348_Var
		.getExpr();
		Assert.assertNotNull(Expr_348_list);
		Assert.assertEquals(1, Expr_348_list.size());
		//348
		final EqualityExpression EqualityExpression_349_Var
		 = (EqualityExpression)Expr_348_list.get(0);
		Assert.assertNotNull(EqualityExpression_349_Var
		);
		final EList<? extends EObject> Expr_349_list = EqualityExpression_349_Var
		.getExpr();
		Assert.assertNotNull(Expr_349_list);
		Assert.assertEquals(1, Expr_349_list.size());
		//349
		final RelationalExpression RelationalExpression_350_Var
		 = (RelationalExpression)Expr_349_list.get(0);
		Assert.assertNotNull(RelationalExpression_350_Var
		);
		final EList<? extends EObject> Expr_350_list = RelationalExpression_350_Var
		.getExpr();
		Assert.assertNotNull(Expr_350_list);
		Assert.assertEquals(1, Expr_350_list.size());
		//350
		final ShiftExpression ShiftExpression_351_Var
		 = (ShiftExpression)Expr_350_list.get(0);
		Assert.assertNotNull(ShiftExpression_351_Var
		);
		final EList<? extends EObject> Expr_351_list = ShiftExpression_351_Var
		.getExpr();
		Assert.assertNotNull(Expr_351_list);
		Assert.assertEquals(1, Expr_351_list.size());
		//351
		final AdditiveExpression AdditiveExpression_352_Var
		 = (AdditiveExpression)Expr_351_list.get(0);
		Assert.assertNotNull(AdditiveExpression_352_Var
		);
		final EList<? extends EObject> Expr_352_list = AdditiveExpression_352_Var
		.getExpr();
		Assert.assertNotNull(Expr_352_list);
		Assert.assertEquals(1, Expr_352_list.size());
		//352
		final MultiplicativeExpression MultiplicativeExpression_353_Var
		 = (MultiplicativeExpression)Expr_352_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_353_Var
		);
		final EList<? extends EObject> Expr_353_list = MultiplicativeExpression_353_Var
		.getExpr();
		Assert.assertNotNull(Expr_353_list);
		Assert.assertEquals(1, Expr_353_list.size());
		//353
		final CastExpression CastExpression_354_Var
		 = (CastExpression)Expr_353_list.get(0);
		Assert.assertNotNull(CastExpression_354_Var
		);
		//354
		final UnaryExpression UnaryExpression_355_Var
		 = (UnaryExpression)CastExpression_354_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_355_Var
		);
		//355
		final PostfixExpression PostfixExpression_356_Var
		 = (PostfixExpression)UnaryExpression_355_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_356_Var
		);
		final EList<? extends EObject> Expr_356_list = PostfixExpression_356_Var
		.getExpr();
		Assert.assertNotNull(Expr_356_list);
		Assert.assertEquals(1, Expr_356_list.size());
		//356
		final PrimaryExpression PrimaryExpression_357_Var
		 = (PrimaryExpression)Expr_356_list.get(0);
		Assert.assertNotNull(PrimaryExpression_357_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_357_Var
		.getId());
		final EList<? extends EObject> Suffix_357_list = PostfixExpression_356_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_357_list);
		Assert.assertEquals(1, Suffix_357_list.size());
		//357
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_358_Var
		 = (PostfixExpressionSuffixArgument)Suffix_357_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_358_Var
		);
		//358
		final ArgumentExpressionList ArgumentExpressionList_359_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_358_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_359_Var
		);
		final EList<? extends EObject> Expr_359_list = ArgumentExpressionList_359_Var
		.getExpr();
		Assert.assertNotNull(Expr_359_list);
		Assert.assertEquals(2, Expr_359_list.size());
		//359
		final AssignmentExpression AssignmentExpression_360_Var
		 = (AssignmentExpression)Expr_359_list.get(0);
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
		Assert.assertEquals("[\"Monday is %d. day of week\\n\"]", PrimaryExpression_375_Var
		.getString().toString());
		//375
		final AssignmentExpression AssignmentExpression_376_Var
		 = (AssignmentExpression)Expr_359_list.get(1);
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
		Assert.assertEquals("MONDAY", PrimaryExpression_391_Var
		.getId());
		//391
		final Statement Statement_392_Var
		 = (Statement)Statement_285_list.get(2);
		Assert.assertNotNull(Statement_392_Var
		);
		//392
		final ExpressionStatement ExpressionStatement_393_Var
		 = (ExpressionStatement)Statement_392_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_393_Var
		);
		//393
		final Expression Expression_394_Var
		 = (Expression)ExpressionStatement_393_Var
		.getExpression();
		Assert.assertNotNull(Expression_394_Var
		);
		final EList<? extends EObject> ExprExpr_394_list = Expression_394_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_394_list);
		Assert.assertEquals(1, ExprExpr_394_list.size());
		//394
		final AssignmentExpression AssignmentExpression_395_Var
		 = (AssignmentExpression)ExprExpr_394_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_410_Var
		.getId());
		final EList<? extends EObject> Suffix_410_list = PostfixExpression_409_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_410_list);
		Assert.assertEquals(1, Suffix_410_list.size());
		//410
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_411_Var
		 = (PostfixExpressionSuffixArgument)Suffix_410_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_411_Var
		);
		//411
		final ArgumentExpressionList ArgumentExpressionList_412_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_411_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_412_Var
		);
		final EList<? extends EObject> Expr_412_list = ArgumentExpressionList_412_Var
		.getExpr();
		Assert.assertNotNull(Expr_412_list);
		Assert.assertEquals(2, Expr_412_list.size());
		//412
		final AssignmentExpression AssignmentExpression_413_Var
		 = (AssignmentExpression)Expr_412_list.get(0);
		Assert.assertNotNull(AssignmentExpression_413_Var
		);
		//413
		final ConditionalExpression ConditionalExpression_414_Var
		 = (ConditionalExpression)AssignmentExpression_413_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_414_Var
		);
		//414
		final LogicalOrExpression LogicalOrExpression_415_Var
		 = (LogicalOrExpression)ConditionalExpression_414_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_415_Var
		);
		final EList<? extends EObject> Expr_415_list = LogicalOrExpression_415_Var
		.getExpr();
		Assert.assertNotNull(Expr_415_list);
		Assert.assertEquals(1, Expr_415_list.size());
		//415
		final LogicalAndExpression LogicalAndExpression_416_Var
		 = (LogicalAndExpression)Expr_415_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_416_Var
		);
		final EList<? extends EObject> Expr_416_list = LogicalAndExpression_416_Var
		.getExpr();
		Assert.assertNotNull(Expr_416_list);
		Assert.assertEquals(1, Expr_416_list.size());
		//416
		final InclusiveOrExpression InclusiveOrExpression_417_Var
		 = (InclusiveOrExpression)Expr_416_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_417_Var
		);
		final EList<? extends EObject> Expr_417_list = InclusiveOrExpression_417_Var
		.getExpr();
		Assert.assertNotNull(Expr_417_list);
		Assert.assertEquals(1, Expr_417_list.size());
		//417
		final ExclusiveOrExpression ExclusiveOrExpression_418_Var
		 = (ExclusiveOrExpression)Expr_417_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_418_Var
		);
		final EList<? extends EObject> Expr_418_list = ExclusiveOrExpression_418_Var
		.getExpr();
		Assert.assertNotNull(Expr_418_list);
		Assert.assertEquals(1, Expr_418_list.size());
		//418
		final AndExpression AndExpression_419_Var
		 = (AndExpression)Expr_418_list.get(0);
		Assert.assertNotNull(AndExpression_419_Var
		);
		final EList<? extends EObject> Expr_419_list = AndExpression_419_Var
		.getExpr();
		Assert.assertNotNull(Expr_419_list);
		Assert.assertEquals(1, Expr_419_list.size());
		//419
		final EqualityExpression EqualityExpression_420_Var
		 = (EqualityExpression)Expr_419_list.get(0);
		Assert.assertNotNull(EqualityExpression_420_Var
		);
		final EList<? extends EObject> Expr_420_list = EqualityExpression_420_Var
		.getExpr();
		Assert.assertNotNull(Expr_420_list);
		Assert.assertEquals(1, Expr_420_list.size());
		//420
		final RelationalExpression RelationalExpression_421_Var
		 = (RelationalExpression)Expr_420_list.get(0);
		Assert.assertNotNull(RelationalExpression_421_Var
		);
		final EList<? extends EObject> Expr_421_list = RelationalExpression_421_Var
		.getExpr();
		Assert.assertNotNull(Expr_421_list);
		Assert.assertEquals(1, Expr_421_list.size());
		//421
		final ShiftExpression ShiftExpression_422_Var
		 = (ShiftExpression)Expr_421_list.get(0);
		Assert.assertNotNull(ShiftExpression_422_Var
		);
		final EList<? extends EObject> Expr_422_list = ShiftExpression_422_Var
		.getExpr();
		Assert.assertNotNull(Expr_422_list);
		Assert.assertEquals(1, Expr_422_list.size());
		//422
		final AdditiveExpression AdditiveExpression_423_Var
		 = (AdditiveExpression)Expr_422_list.get(0);
		Assert.assertNotNull(AdditiveExpression_423_Var
		);
		final EList<? extends EObject> Expr_423_list = AdditiveExpression_423_Var
		.getExpr();
		Assert.assertNotNull(Expr_423_list);
		Assert.assertEquals(1, Expr_423_list.size());
		//423
		final MultiplicativeExpression MultiplicativeExpression_424_Var
		 = (MultiplicativeExpression)Expr_423_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_424_Var
		);
		final EList<? extends EObject> Expr_424_list = MultiplicativeExpression_424_Var
		.getExpr();
		Assert.assertNotNull(Expr_424_list);
		Assert.assertEquals(1, Expr_424_list.size());
		//424
		final CastExpression CastExpression_425_Var
		 = (CastExpression)Expr_424_list.get(0);
		Assert.assertNotNull(CastExpression_425_Var
		);
		//425
		final UnaryExpression UnaryExpression_426_Var
		 = (UnaryExpression)CastExpression_425_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_426_Var
		);
		//426
		final PostfixExpression PostfixExpression_427_Var
		 = (PostfixExpression)UnaryExpression_426_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_427_Var
		);
		final EList<? extends EObject> Expr_427_list = PostfixExpression_427_Var
		.getExpr();
		Assert.assertNotNull(Expr_427_list);
		Assert.assertEquals(1, Expr_427_list.size());
		//427
		final PrimaryExpression PrimaryExpression_428_Var
		 = (PrimaryExpression)Expr_427_list.get(0);
		Assert.assertNotNull(PrimaryExpression_428_Var
		);
		Assert.assertEquals("[\"Sunday is %d. day of week\\n\"]", PrimaryExpression_428_Var
		.getString().toString());
		//428
		final AssignmentExpression AssignmentExpression_429_Var
		 = (AssignmentExpression)Expr_412_list.get(1);
		Assert.assertNotNull(AssignmentExpression_429_Var
		);
		//429
		final ConditionalExpression ConditionalExpression_430_Var
		 = (ConditionalExpression)AssignmentExpression_429_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_430_Var
		);
		//430
		final LogicalOrExpression LogicalOrExpression_431_Var
		 = (LogicalOrExpression)ConditionalExpression_430_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_431_Var
		);
		final EList<? extends EObject> Expr_431_list = LogicalOrExpression_431_Var
		.getExpr();
		Assert.assertNotNull(Expr_431_list);
		Assert.assertEquals(1, Expr_431_list.size());
		//431
		final LogicalAndExpression LogicalAndExpression_432_Var
		 = (LogicalAndExpression)Expr_431_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_432_Var
		);
		final EList<? extends EObject> Expr_432_list = LogicalAndExpression_432_Var
		.getExpr();
		Assert.assertNotNull(Expr_432_list);
		Assert.assertEquals(1, Expr_432_list.size());
		//432
		final InclusiveOrExpression InclusiveOrExpression_433_Var
		 = (InclusiveOrExpression)Expr_432_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_433_Var
		);
		final EList<? extends EObject> Expr_433_list = InclusiveOrExpression_433_Var
		.getExpr();
		Assert.assertNotNull(Expr_433_list);
		Assert.assertEquals(1, Expr_433_list.size());
		//433
		final ExclusiveOrExpression ExclusiveOrExpression_434_Var
		 = (ExclusiveOrExpression)Expr_433_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_434_Var
		);
		final EList<? extends EObject> Expr_434_list = ExclusiveOrExpression_434_Var
		.getExpr();
		Assert.assertNotNull(Expr_434_list);
		Assert.assertEquals(1, Expr_434_list.size());
		//434
		final AndExpression AndExpression_435_Var
		 = (AndExpression)Expr_434_list.get(0);
		Assert.assertNotNull(AndExpression_435_Var
		);
		final EList<? extends EObject> Expr_435_list = AndExpression_435_Var
		.getExpr();
		Assert.assertNotNull(Expr_435_list);
		Assert.assertEquals(1, Expr_435_list.size());
		//435
		final EqualityExpression EqualityExpression_436_Var
		 = (EqualityExpression)Expr_435_list.get(0);
		Assert.assertNotNull(EqualityExpression_436_Var
		);
		final EList<? extends EObject> Expr_436_list = EqualityExpression_436_Var
		.getExpr();
		Assert.assertNotNull(Expr_436_list);
		Assert.assertEquals(1, Expr_436_list.size());
		//436
		final RelationalExpression RelationalExpression_437_Var
		 = (RelationalExpression)Expr_436_list.get(0);
		Assert.assertNotNull(RelationalExpression_437_Var
		);
		final EList<? extends EObject> Expr_437_list = RelationalExpression_437_Var
		.getExpr();
		Assert.assertNotNull(Expr_437_list);
		Assert.assertEquals(1, Expr_437_list.size());
		//437
		final ShiftExpression ShiftExpression_438_Var
		 = (ShiftExpression)Expr_437_list.get(0);
		Assert.assertNotNull(ShiftExpression_438_Var
		);
		final EList<? extends EObject> Expr_438_list = ShiftExpression_438_Var
		.getExpr();
		Assert.assertNotNull(Expr_438_list);
		Assert.assertEquals(1, Expr_438_list.size());
		//438
		final AdditiveExpression AdditiveExpression_439_Var
		 = (AdditiveExpression)Expr_438_list.get(0);
		Assert.assertNotNull(AdditiveExpression_439_Var
		);
		final EList<? extends EObject> Expr_439_list = AdditiveExpression_439_Var
		.getExpr();
		Assert.assertNotNull(Expr_439_list);
		Assert.assertEquals(1, Expr_439_list.size());
		//439
		final MultiplicativeExpression MultiplicativeExpression_440_Var
		 = (MultiplicativeExpression)Expr_439_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_440_Var
		);
		final EList<? extends EObject> Expr_440_list = MultiplicativeExpression_440_Var
		.getExpr();
		Assert.assertNotNull(Expr_440_list);
		Assert.assertEquals(1, Expr_440_list.size());
		//440
		final CastExpression CastExpression_441_Var
		 = (CastExpression)Expr_440_list.get(0);
		Assert.assertNotNull(CastExpression_441_Var
		);
		//441
		final UnaryExpression UnaryExpression_442_Var
		 = (UnaryExpression)CastExpression_441_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_442_Var
		);
		//442
		final PostfixExpression PostfixExpression_443_Var
		 = (PostfixExpression)UnaryExpression_442_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_443_Var
		);
		final EList<? extends EObject> Expr_443_list = PostfixExpression_443_Var
		.getExpr();
		Assert.assertNotNull(Expr_443_list);
		Assert.assertEquals(1, Expr_443_list.size());
		//443
		final PrimaryExpression PrimaryExpression_444_Var
		 = (PrimaryExpression)Expr_443_list.get(0);
		Assert.assertNotNull(PrimaryExpression_444_Var
		);
		Assert.assertEquals("W_SUNDAY", PrimaryExpression_444_Var
		.getId());
		//444
		final Statement Statement_445_Var
		 = (Statement)Statement_285_list.get(3);
		Assert.assertNotNull(Statement_445_Var
		);
		//445
		final ExpressionStatement ExpressionStatement_446_Var
		 = (ExpressionStatement)Statement_445_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_446_Var
		);
		//446
		final Expression Expression_447_Var
		 = (Expression)ExpressionStatement_446_Var
		.getExpression();
		Assert.assertNotNull(Expression_447_Var
		);
		final EList<? extends EObject> ExprExpr_447_list = Expression_447_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_447_list);
		Assert.assertEquals(1, ExprExpr_447_list.size());
		//447
		final AssignmentExpression AssignmentExpression_448_Var
		 = (AssignmentExpression)ExprExpr_447_list.get(0);
		Assert.assertNotNull(AssignmentExpression_448_Var
		);
		//448
		final ConditionalExpression ConditionalExpression_449_Var
		 = (ConditionalExpression)AssignmentExpression_448_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_449_Var
		);
		//449
		final LogicalOrExpression LogicalOrExpression_450_Var
		 = (LogicalOrExpression)ConditionalExpression_449_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_450_Var
		);
		final EList<? extends EObject> Expr_450_list = LogicalOrExpression_450_Var
		.getExpr();
		Assert.assertNotNull(Expr_450_list);
		Assert.assertEquals(1, Expr_450_list.size());
		//450
		final LogicalAndExpression LogicalAndExpression_451_Var
		 = (LogicalAndExpression)Expr_450_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_451_Var
		);
		final EList<? extends EObject> Expr_451_list = LogicalAndExpression_451_Var
		.getExpr();
		Assert.assertNotNull(Expr_451_list);
		Assert.assertEquals(1, Expr_451_list.size());
		//451
		final InclusiveOrExpression InclusiveOrExpression_452_Var
		 = (InclusiveOrExpression)Expr_451_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_452_Var
		);
		final EList<? extends EObject> Expr_452_list = InclusiveOrExpression_452_Var
		.getExpr();
		Assert.assertNotNull(Expr_452_list);
		Assert.assertEquals(1, Expr_452_list.size());
		//452
		final ExclusiveOrExpression ExclusiveOrExpression_453_Var
		 = (ExclusiveOrExpression)Expr_452_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_453_Var
		);
		final EList<? extends EObject> Expr_453_list = ExclusiveOrExpression_453_Var
		.getExpr();
		Assert.assertNotNull(Expr_453_list);
		Assert.assertEquals(1, Expr_453_list.size());
		//453
		final AndExpression AndExpression_454_Var
		 = (AndExpression)Expr_453_list.get(0);
		Assert.assertNotNull(AndExpression_454_Var
		);
		final EList<? extends EObject> Expr_454_list = AndExpression_454_Var
		.getExpr();
		Assert.assertNotNull(Expr_454_list);
		Assert.assertEquals(1, Expr_454_list.size());
		//454
		final EqualityExpression EqualityExpression_455_Var
		 = (EqualityExpression)Expr_454_list.get(0);
		Assert.assertNotNull(EqualityExpression_455_Var
		);
		final EList<? extends EObject> Expr_455_list = EqualityExpression_455_Var
		.getExpr();
		Assert.assertNotNull(Expr_455_list);
		Assert.assertEquals(1, Expr_455_list.size());
		//455
		final RelationalExpression RelationalExpression_456_Var
		 = (RelationalExpression)Expr_455_list.get(0);
		Assert.assertNotNull(RelationalExpression_456_Var
		);
		final EList<? extends EObject> Expr_456_list = RelationalExpression_456_Var
		.getExpr();
		Assert.assertNotNull(Expr_456_list);
		Assert.assertEquals(1, Expr_456_list.size());
		//456
		final ShiftExpression ShiftExpression_457_Var
		 = (ShiftExpression)Expr_456_list.get(0);
		Assert.assertNotNull(ShiftExpression_457_Var
		);
		final EList<? extends EObject> Expr_457_list = ShiftExpression_457_Var
		.getExpr();
		Assert.assertNotNull(Expr_457_list);
		Assert.assertEquals(1, Expr_457_list.size());
		//457
		final AdditiveExpression AdditiveExpression_458_Var
		 = (AdditiveExpression)Expr_457_list.get(0);
		Assert.assertNotNull(AdditiveExpression_458_Var
		);
		final EList<? extends EObject> Expr_458_list = AdditiveExpression_458_Var
		.getExpr();
		Assert.assertNotNull(Expr_458_list);
		Assert.assertEquals(1, Expr_458_list.size());
		//458
		final MultiplicativeExpression MultiplicativeExpression_459_Var
		 = (MultiplicativeExpression)Expr_458_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_459_Var
		);
		final EList<? extends EObject> Expr_459_list = MultiplicativeExpression_459_Var
		.getExpr();
		Assert.assertNotNull(Expr_459_list);
		Assert.assertEquals(1, Expr_459_list.size());
		//459
		final CastExpression CastExpression_460_Var
		 = (CastExpression)Expr_459_list.get(0);
		Assert.assertNotNull(CastExpression_460_Var
		);
		//460
		final UnaryExpression UnaryExpression_461_Var
		 = (UnaryExpression)CastExpression_460_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_461_Var
		);
		//461
		final PostfixExpression PostfixExpression_462_Var
		 = (PostfixExpression)UnaryExpression_461_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_462_Var
		);
		final EList<? extends EObject> Expr_462_list = PostfixExpression_462_Var
		.getExpr();
		Assert.assertNotNull(Expr_462_list);
		Assert.assertEquals(1, Expr_462_list.size());
		//462
		final PrimaryExpression PrimaryExpression_463_Var
		 = (PrimaryExpression)Expr_462_list.get(0);
		Assert.assertNotNull(PrimaryExpression_463_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_463_Var
		.getId());
		final EList<? extends EObject> Suffix_463_list = PostfixExpression_462_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_463_list);
		Assert.assertEquals(1, Suffix_463_list.size());
		//463
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_464_Var
		 = (PostfixExpressionSuffixArgument)Suffix_463_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_464_Var
		);
		//464
		final ArgumentExpressionList ArgumentExpressionList_465_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_464_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_465_Var
		);
		final EList<? extends EObject> Expr_465_list = ArgumentExpressionList_465_Var
		.getExpr();
		Assert.assertNotNull(Expr_465_list);
		Assert.assertEquals(2, Expr_465_list.size());
		//465
		final AssignmentExpression AssignmentExpression_466_Var
		 = (AssignmentExpression)Expr_465_list.get(0);
		Assert.assertNotNull(AssignmentExpression_466_Var
		);
		//466
		final ConditionalExpression ConditionalExpression_467_Var
		 = (ConditionalExpression)AssignmentExpression_466_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_467_Var
		);
		//467
		final LogicalOrExpression LogicalOrExpression_468_Var
		 = (LogicalOrExpression)ConditionalExpression_467_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_468_Var
		);
		final EList<? extends EObject> Expr_468_list = LogicalOrExpression_468_Var
		.getExpr();
		Assert.assertNotNull(Expr_468_list);
		Assert.assertEquals(1, Expr_468_list.size());
		//468
		final LogicalAndExpression LogicalAndExpression_469_Var
		 = (LogicalAndExpression)Expr_468_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_469_Var
		);
		final EList<? extends EObject> Expr_469_list = LogicalAndExpression_469_Var
		.getExpr();
		Assert.assertNotNull(Expr_469_list);
		Assert.assertEquals(1, Expr_469_list.size());
		//469
		final InclusiveOrExpression InclusiveOrExpression_470_Var
		 = (InclusiveOrExpression)Expr_469_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_470_Var
		);
		final EList<? extends EObject> Expr_470_list = InclusiveOrExpression_470_Var
		.getExpr();
		Assert.assertNotNull(Expr_470_list);
		Assert.assertEquals(1, Expr_470_list.size());
		//470
		final ExclusiveOrExpression ExclusiveOrExpression_471_Var
		 = (ExclusiveOrExpression)Expr_470_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_471_Var
		);
		final EList<? extends EObject> Expr_471_list = ExclusiveOrExpression_471_Var
		.getExpr();
		Assert.assertNotNull(Expr_471_list);
		Assert.assertEquals(1, Expr_471_list.size());
		//471
		final AndExpression AndExpression_472_Var
		 = (AndExpression)Expr_471_list.get(0);
		Assert.assertNotNull(AndExpression_472_Var
		);
		final EList<? extends EObject> Expr_472_list = AndExpression_472_Var
		.getExpr();
		Assert.assertNotNull(Expr_472_list);
		Assert.assertEquals(1, Expr_472_list.size());
		//472
		final EqualityExpression EqualityExpression_473_Var
		 = (EqualityExpression)Expr_472_list.get(0);
		Assert.assertNotNull(EqualityExpression_473_Var
		);
		final EList<? extends EObject> Expr_473_list = EqualityExpression_473_Var
		.getExpr();
		Assert.assertNotNull(Expr_473_list);
		Assert.assertEquals(1, Expr_473_list.size());
		//473
		final RelationalExpression RelationalExpression_474_Var
		 = (RelationalExpression)Expr_473_list.get(0);
		Assert.assertNotNull(RelationalExpression_474_Var
		);
		final EList<? extends EObject> Expr_474_list = RelationalExpression_474_Var
		.getExpr();
		Assert.assertNotNull(Expr_474_list);
		Assert.assertEquals(1, Expr_474_list.size());
		//474
		final ShiftExpression ShiftExpression_475_Var
		 = (ShiftExpression)Expr_474_list.get(0);
		Assert.assertNotNull(ShiftExpression_475_Var
		);
		final EList<? extends EObject> Expr_475_list = ShiftExpression_475_Var
		.getExpr();
		Assert.assertNotNull(Expr_475_list);
		Assert.assertEquals(1, Expr_475_list.size());
		//475
		final AdditiveExpression AdditiveExpression_476_Var
		 = (AdditiveExpression)Expr_475_list.get(0);
		Assert.assertNotNull(AdditiveExpression_476_Var
		);
		final EList<? extends EObject> Expr_476_list = AdditiveExpression_476_Var
		.getExpr();
		Assert.assertNotNull(Expr_476_list);
		Assert.assertEquals(1, Expr_476_list.size());
		//476
		final MultiplicativeExpression MultiplicativeExpression_477_Var
		 = (MultiplicativeExpression)Expr_476_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_477_Var
		);
		final EList<? extends EObject> Expr_477_list = MultiplicativeExpression_477_Var
		.getExpr();
		Assert.assertNotNull(Expr_477_list);
		Assert.assertEquals(1, Expr_477_list.size());
		//477
		final CastExpression CastExpression_478_Var
		 = (CastExpression)Expr_477_list.get(0);
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
		Assert.assertEquals("[\"Sunday is %d. day of week\\n\"]", PrimaryExpression_481_Var
		.getString().toString());
		//481
		final AssignmentExpression AssignmentExpression_482_Var
		 = (AssignmentExpression)Expr_465_list.get(1);
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
		Assert.assertEquals("SUNDAY", PrimaryExpression_497_Var
		.getId());
		//497
		final Statement Statement_498_Var
		 = (Statement)Statement_285_list.get(4);
		Assert.assertNotNull(Statement_498_Var
		);
		//498
		final ExpressionStatement ExpressionStatement_499_Var
		 = (ExpressionStatement)Statement_498_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_499_Var
		);
		//499
		final Expression Expression_500_Var
		 = (Expression)ExpressionStatement_499_Var
		.getExpression();
		Assert.assertNotNull(Expression_500_Var
		);
		final EList<? extends EObject> ExprExpr_500_list = Expression_500_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_500_list);
		Assert.assertEquals(1, ExprExpr_500_list.size());
		//500
		final AssignmentExpression AssignmentExpression_501_Var
		 = (AssignmentExpression)ExprExpr_500_list.get(0);
		Assert.assertNotNull(AssignmentExpression_501_Var
		);
		//501
		final UnaryExpression UnaryExpression_502_Var
		 = (UnaryExpression)AssignmentExpression_501_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_502_Var
		);
		//502
		final PostfixExpression PostfixExpression_503_Var
		 = (PostfixExpression)UnaryExpression_502_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_503_Var
		);
		final EList<? extends EObject> Expr_503_list = PostfixExpression_503_Var
		.getExpr();
		Assert.assertNotNull(Expr_503_list);
		Assert.assertEquals(1, Expr_503_list.size());
		//503
		final PrimaryExpression PrimaryExpression_504_Var
		 = (PrimaryExpression)Expr_503_list.get(0);
		Assert.assertNotNull(PrimaryExpression_504_Var
		);
		Assert.assertEquals("iAmInLove", PrimaryExpression_504_Var
		.getId());
		//504
		final AssignmentOperator AssignmentOperator_505_Var
		 = (AssignmentOperator)AssignmentExpression_501_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_505_Var
		);
		Assert.assertEquals("=", AssignmentOperator_505_Var
		.getOp());
		//505
		final AssignmentExpression AssignmentExpression_506_Var
		 = (AssignmentExpression)AssignmentExpression_501_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_506_Var
		);
		//506
		final ConditionalExpression ConditionalExpression_507_Var
		 = (ConditionalExpression)AssignmentExpression_506_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_507_Var
		);
		//507
		final LogicalOrExpression LogicalOrExpression_508_Var
		 = (LogicalOrExpression)ConditionalExpression_507_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_508_Var
		);
		final EList<? extends EObject> Expr_508_list = LogicalOrExpression_508_Var
		.getExpr();
		Assert.assertNotNull(Expr_508_list);
		Assert.assertEquals(1, Expr_508_list.size());
		//508
		final LogicalAndExpression LogicalAndExpression_509_Var
		 = (LogicalAndExpression)Expr_508_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_509_Var
		);
		final EList<? extends EObject> Expr_509_list = LogicalAndExpression_509_Var
		.getExpr();
		Assert.assertNotNull(Expr_509_list);
		Assert.assertEquals(1, Expr_509_list.size());
		//509
		final InclusiveOrExpression InclusiveOrExpression_510_Var
		 = (InclusiveOrExpression)Expr_509_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_510_Var
		);
		final EList<? extends EObject> Expr_510_list = InclusiveOrExpression_510_Var
		.getExpr();
		Assert.assertNotNull(Expr_510_list);
		Assert.assertEquals(1, Expr_510_list.size());
		//510
		final ExclusiveOrExpression ExclusiveOrExpression_511_Var
		 = (ExclusiveOrExpression)Expr_510_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_511_Var
		);
		final EList<? extends EObject> Expr_511_list = ExclusiveOrExpression_511_Var
		.getExpr();
		Assert.assertNotNull(Expr_511_list);
		Assert.assertEquals(1, Expr_511_list.size());
		//511
		final AndExpression AndExpression_512_Var
		 = (AndExpression)Expr_511_list.get(0);
		Assert.assertNotNull(AndExpression_512_Var
		);
		final EList<? extends EObject> Expr_512_list = AndExpression_512_Var
		.getExpr();
		Assert.assertNotNull(Expr_512_list);
		Assert.assertEquals(1, Expr_512_list.size());
		//512
		final EqualityExpression EqualityExpression_513_Var
		 = (EqualityExpression)Expr_512_list.get(0);
		Assert.assertNotNull(EqualityExpression_513_Var
		);
		final EList<? extends EObject> Expr_513_list = EqualityExpression_513_Var
		.getExpr();
		Assert.assertNotNull(Expr_513_list);
		Assert.assertEquals(1, Expr_513_list.size());
		//513
		final RelationalExpression RelationalExpression_514_Var
		 = (RelationalExpression)Expr_513_list.get(0);
		Assert.assertNotNull(RelationalExpression_514_Var
		);
		final EList<? extends EObject> Expr_514_list = RelationalExpression_514_Var
		.getExpr();
		Assert.assertNotNull(Expr_514_list);
		Assert.assertEquals(1, Expr_514_list.size());
		//514
		final ShiftExpression ShiftExpression_515_Var
		 = (ShiftExpression)Expr_514_list.get(0);
		Assert.assertNotNull(ShiftExpression_515_Var
		);
		final EList<? extends EObject> Expr_515_list = ShiftExpression_515_Var
		.getExpr();
		Assert.assertNotNull(Expr_515_list);
		Assert.assertEquals(1, Expr_515_list.size());
		//515
		final AdditiveExpression AdditiveExpression_516_Var
		 = (AdditiveExpression)Expr_515_list.get(0);
		Assert.assertNotNull(AdditiveExpression_516_Var
		);
		final EList<? extends EObject> Expr_516_list = AdditiveExpression_516_Var
		.getExpr();
		Assert.assertNotNull(Expr_516_list);
		Assert.assertEquals(1, Expr_516_list.size());
		//516
		final MultiplicativeExpression MultiplicativeExpression_517_Var
		 = (MultiplicativeExpression)Expr_516_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_517_Var
		);
		final EList<? extends EObject> Expr_517_list = MultiplicativeExpression_517_Var
		.getExpr();
		Assert.assertNotNull(Expr_517_list);
		Assert.assertEquals(1, Expr_517_list.size());
		//517
		final CastExpression CastExpression_518_Var
		 = (CastExpression)Expr_517_list.get(0);
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
		Assert.assertEquals("I_FRIDAY", PrimaryExpression_521_Var
		.getId());
		//521
		final Statement Statement_522_Var
		 = (Statement)Statement_285_list.get(5);
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
		final ConditionalExpression ConditionalExpression_526_Var
		 = (ConditionalExpression)AssignmentExpression_525_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_526_Var
		);
		//526
		final LogicalOrExpression LogicalOrExpression_527_Var
		 = (LogicalOrExpression)ConditionalExpression_526_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_527_Var
		);
		final EList<? extends EObject> Expr_527_list = LogicalOrExpression_527_Var
		.getExpr();
		Assert.assertNotNull(Expr_527_list);
		Assert.assertEquals(1, Expr_527_list.size());
		//527
		final LogicalAndExpression LogicalAndExpression_528_Var
		 = (LogicalAndExpression)Expr_527_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_528_Var
		);
		final EList<? extends EObject> Expr_528_list = LogicalAndExpression_528_Var
		.getExpr();
		Assert.assertNotNull(Expr_528_list);
		Assert.assertEquals(1, Expr_528_list.size());
		//528
		final InclusiveOrExpression InclusiveOrExpression_529_Var
		 = (InclusiveOrExpression)Expr_528_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_529_Var
		);
		final EList<? extends EObject> Expr_529_list = InclusiveOrExpression_529_Var
		.getExpr();
		Assert.assertNotNull(Expr_529_list);
		Assert.assertEquals(1, Expr_529_list.size());
		//529
		final ExclusiveOrExpression ExclusiveOrExpression_530_Var
		 = (ExclusiveOrExpression)Expr_529_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_530_Var
		);
		final EList<? extends EObject> Expr_530_list = ExclusiveOrExpression_530_Var
		.getExpr();
		Assert.assertNotNull(Expr_530_list);
		Assert.assertEquals(1, Expr_530_list.size());
		//530
		final AndExpression AndExpression_531_Var
		 = (AndExpression)Expr_530_list.get(0);
		Assert.assertNotNull(AndExpression_531_Var
		);
		final EList<? extends EObject> Expr_531_list = AndExpression_531_Var
		.getExpr();
		Assert.assertNotNull(Expr_531_list);
		Assert.assertEquals(1, Expr_531_list.size());
		//531
		final EqualityExpression EqualityExpression_532_Var
		 = (EqualityExpression)Expr_531_list.get(0);
		Assert.assertNotNull(EqualityExpression_532_Var
		);
		final EList<? extends EObject> Expr_532_list = EqualityExpression_532_Var
		.getExpr();
		Assert.assertNotNull(Expr_532_list);
		Assert.assertEquals(1, Expr_532_list.size());
		//532
		final RelationalExpression RelationalExpression_533_Var
		 = (RelationalExpression)Expr_532_list.get(0);
		Assert.assertNotNull(RelationalExpression_533_Var
		);
		final EList<? extends EObject> Expr_533_list = RelationalExpression_533_Var
		.getExpr();
		Assert.assertNotNull(Expr_533_list);
		Assert.assertEquals(1, Expr_533_list.size());
		//533
		final ShiftExpression ShiftExpression_534_Var
		 = (ShiftExpression)Expr_533_list.get(0);
		Assert.assertNotNull(ShiftExpression_534_Var
		);
		final EList<? extends EObject> Expr_534_list = ShiftExpression_534_Var
		.getExpr();
		Assert.assertNotNull(Expr_534_list);
		Assert.assertEquals(1, Expr_534_list.size());
		//534
		final AdditiveExpression AdditiveExpression_535_Var
		 = (AdditiveExpression)Expr_534_list.get(0);
		Assert.assertNotNull(AdditiveExpression_535_Var
		);
		final EList<? extends EObject> Expr_535_list = AdditiveExpression_535_Var
		.getExpr();
		Assert.assertNotNull(Expr_535_list);
		Assert.assertEquals(1, Expr_535_list.size());
		//535
		final MultiplicativeExpression MultiplicativeExpression_536_Var
		 = (MultiplicativeExpression)Expr_535_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_536_Var
		);
		final EList<? extends EObject> Expr_536_list = MultiplicativeExpression_536_Var
		.getExpr();
		Assert.assertNotNull(Expr_536_list);
		Assert.assertEquals(1, Expr_536_list.size());
		//536
		final CastExpression CastExpression_537_Var
		 = (CastExpression)Expr_536_list.get(0);
		Assert.assertNotNull(CastExpression_537_Var
		);
		//537
		final UnaryExpression UnaryExpression_538_Var
		 = (UnaryExpression)CastExpression_537_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_538_Var
		);
		//538
		final PostfixExpression PostfixExpression_539_Var
		 = (PostfixExpression)UnaryExpression_538_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_539_Var
		);
		final EList<? extends EObject> Expr_539_list = PostfixExpression_539_Var
		.getExpr();
		Assert.assertNotNull(Expr_539_list);
		Assert.assertEquals(1, Expr_539_list.size());
		//539
		final PrimaryExpression PrimaryExpression_540_Var
		 = (PrimaryExpression)Expr_539_list.get(0);
		Assert.assertNotNull(PrimaryExpression_540_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_540_Var
		.getId());
		final EList<? extends EObject> Suffix_540_list = PostfixExpression_539_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_540_list);
		Assert.assertEquals(1, Suffix_540_list.size());
		//540
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_541_Var
		 = (PostfixExpressionSuffixArgument)Suffix_540_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_541_Var
		);
		//541
		final ArgumentExpressionList ArgumentExpressionList_542_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_541_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_542_Var
		);
		final EList<? extends EObject> Expr_542_list = ArgumentExpressionList_542_Var
		.getExpr();
		Assert.assertNotNull(Expr_542_list);
		Assert.assertEquals(2, Expr_542_list.size());
		//542
		final AssignmentExpression AssignmentExpression_543_Var
		 = (AssignmentExpression)Expr_542_list.get(0);
		Assert.assertNotNull(AssignmentExpression_543_Var
		);
		//543
		final ConditionalExpression ConditionalExpression_544_Var
		 = (ConditionalExpression)AssignmentExpression_543_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_544_Var
		);
		//544
		final LogicalOrExpression LogicalOrExpression_545_Var
		 = (LogicalOrExpression)ConditionalExpression_544_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_545_Var
		);
		final EList<? extends EObject> Expr_545_list = LogicalOrExpression_545_Var
		.getExpr();
		Assert.assertNotNull(Expr_545_list);
		Assert.assertEquals(1, Expr_545_list.size());
		//545
		final LogicalAndExpression LogicalAndExpression_546_Var
		 = (LogicalAndExpression)Expr_545_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_546_Var
		);
		final EList<? extends EObject> Expr_546_list = LogicalAndExpression_546_Var
		.getExpr();
		Assert.assertNotNull(Expr_546_list);
		Assert.assertEquals(1, Expr_546_list.size());
		//546
		final InclusiveOrExpression InclusiveOrExpression_547_Var
		 = (InclusiveOrExpression)Expr_546_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_547_Var
		);
		final EList<? extends EObject> Expr_547_list = InclusiveOrExpression_547_Var
		.getExpr();
		Assert.assertNotNull(Expr_547_list);
		Assert.assertEquals(1, Expr_547_list.size());
		//547
		final ExclusiveOrExpression ExclusiveOrExpression_548_Var
		 = (ExclusiveOrExpression)Expr_547_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_548_Var
		);
		final EList<? extends EObject> Expr_548_list = ExclusiveOrExpression_548_Var
		.getExpr();
		Assert.assertNotNull(Expr_548_list);
		Assert.assertEquals(1, Expr_548_list.size());
		//548
		final AndExpression AndExpression_549_Var
		 = (AndExpression)Expr_548_list.get(0);
		Assert.assertNotNull(AndExpression_549_Var
		);
		final EList<? extends EObject> Expr_549_list = AndExpression_549_Var
		.getExpr();
		Assert.assertNotNull(Expr_549_list);
		Assert.assertEquals(1, Expr_549_list.size());
		//549
		final EqualityExpression EqualityExpression_550_Var
		 = (EqualityExpression)Expr_549_list.get(0);
		Assert.assertNotNull(EqualityExpression_550_Var
		);
		final EList<? extends EObject> Expr_550_list = EqualityExpression_550_Var
		.getExpr();
		Assert.assertNotNull(Expr_550_list);
		Assert.assertEquals(1, Expr_550_list.size());
		//550
		final RelationalExpression RelationalExpression_551_Var
		 = (RelationalExpression)Expr_550_list.get(0);
		Assert.assertNotNull(RelationalExpression_551_Var
		);
		final EList<? extends EObject> Expr_551_list = RelationalExpression_551_Var
		.getExpr();
		Assert.assertNotNull(Expr_551_list);
		Assert.assertEquals(1, Expr_551_list.size());
		//551
		final ShiftExpression ShiftExpression_552_Var
		 = (ShiftExpression)Expr_551_list.get(0);
		Assert.assertNotNull(ShiftExpression_552_Var
		);
		final EList<? extends EObject> Expr_552_list = ShiftExpression_552_Var
		.getExpr();
		Assert.assertNotNull(Expr_552_list);
		Assert.assertEquals(1, Expr_552_list.size());
		//552
		final AdditiveExpression AdditiveExpression_553_Var
		 = (AdditiveExpression)Expr_552_list.get(0);
		Assert.assertNotNull(AdditiveExpression_553_Var
		);
		final EList<? extends EObject> Expr_553_list = AdditiveExpression_553_Var
		.getExpr();
		Assert.assertNotNull(Expr_553_list);
		Assert.assertEquals(1, Expr_553_list.size());
		//553
		final MultiplicativeExpression MultiplicativeExpression_554_Var
		 = (MultiplicativeExpression)Expr_553_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_554_Var
		);
		final EList<? extends EObject> Expr_554_list = MultiplicativeExpression_554_Var
		.getExpr();
		Assert.assertNotNull(Expr_554_list);
		Assert.assertEquals(1, Expr_554_list.size());
		//554
		final CastExpression CastExpression_555_Var
		 = (CastExpression)Expr_554_list.get(0);
		Assert.assertNotNull(CastExpression_555_Var
		);
		//555
		final UnaryExpression UnaryExpression_556_Var
		 = (UnaryExpression)CastExpression_555_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_556_Var
		);
		//556
		final PostfixExpression PostfixExpression_557_Var
		 = (PostfixExpression)UnaryExpression_556_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_557_Var
		);
		final EList<? extends EObject> Expr_557_list = PostfixExpression_557_Var
		.getExpr();
		Assert.assertNotNull(Expr_557_list);
		Assert.assertEquals(1, Expr_557_list.size());
		//557
		final PrimaryExpression PrimaryExpression_558_Var
		 = (PrimaryExpression)Expr_557_list.get(0);
		Assert.assertNotNull(PrimaryExpression_558_Var
		);
		Assert.assertEquals("[\"The %d. day of the week is my favourite!\\n\"]", PrimaryExpression_558_Var
		.getString().toString());
		//558
		final AssignmentExpression AssignmentExpression_559_Var
		 = (AssignmentExpression)Expr_542_list.get(1);
		Assert.assertNotNull(AssignmentExpression_559_Var
		);
		//559
		final ConditionalExpression ConditionalExpression_560_Var
		 = (ConditionalExpression)AssignmentExpression_559_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_560_Var
		);
		//560
		final LogicalOrExpression LogicalOrExpression_561_Var
		 = (LogicalOrExpression)ConditionalExpression_560_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_561_Var
		);
		final EList<? extends EObject> Expr_561_list = LogicalOrExpression_561_Var
		.getExpr();
		Assert.assertNotNull(Expr_561_list);
		Assert.assertEquals(1, Expr_561_list.size());
		//561
		final LogicalAndExpression LogicalAndExpression_562_Var
		 = (LogicalAndExpression)Expr_561_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_562_Var
		);
		final EList<? extends EObject> Expr_562_list = LogicalAndExpression_562_Var
		.getExpr();
		Assert.assertNotNull(Expr_562_list);
		Assert.assertEquals(1, Expr_562_list.size());
		//562
		final InclusiveOrExpression InclusiveOrExpression_563_Var
		 = (InclusiveOrExpression)Expr_562_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_563_Var
		);
		final EList<? extends EObject> Expr_563_list = InclusiveOrExpression_563_Var
		.getExpr();
		Assert.assertNotNull(Expr_563_list);
		Assert.assertEquals(1, Expr_563_list.size());
		//563
		final ExclusiveOrExpression ExclusiveOrExpression_564_Var
		 = (ExclusiveOrExpression)Expr_563_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_564_Var
		);
		final EList<? extends EObject> Expr_564_list = ExclusiveOrExpression_564_Var
		.getExpr();
		Assert.assertNotNull(Expr_564_list);
		Assert.assertEquals(1, Expr_564_list.size());
		//564
		final AndExpression AndExpression_565_Var
		 = (AndExpression)Expr_564_list.get(0);
		Assert.assertNotNull(AndExpression_565_Var
		);
		final EList<? extends EObject> Expr_565_list = AndExpression_565_Var
		.getExpr();
		Assert.assertNotNull(Expr_565_list);
		Assert.assertEquals(1, Expr_565_list.size());
		//565
		final EqualityExpression EqualityExpression_566_Var
		 = (EqualityExpression)Expr_565_list.get(0);
		Assert.assertNotNull(EqualityExpression_566_Var
		);
		final EList<? extends EObject> Expr_566_list = EqualityExpression_566_Var
		.getExpr();
		Assert.assertNotNull(Expr_566_list);
		Assert.assertEquals(1, Expr_566_list.size());
		//566
		final RelationalExpression RelationalExpression_567_Var
		 = (RelationalExpression)Expr_566_list.get(0);
		Assert.assertNotNull(RelationalExpression_567_Var
		);
		final EList<? extends EObject> Expr_567_list = RelationalExpression_567_Var
		.getExpr();
		Assert.assertNotNull(Expr_567_list);
		Assert.assertEquals(1, Expr_567_list.size());
		//567
		final ShiftExpression ShiftExpression_568_Var
		 = (ShiftExpression)Expr_567_list.get(0);
		Assert.assertNotNull(ShiftExpression_568_Var
		);
		final EList<? extends EObject> Expr_568_list = ShiftExpression_568_Var
		.getExpr();
		Assert.assertNotNull(Expr_568_list);
		Assert.assertEquals(1, Expr_568_list.size());
		//568
		final AdditiveExpression AdditiveExpression_569_Var
		 = (AdditiveExpression)Expr_568_list.get(0);
		Assert.assertNotNull(AdditiveExpression_569_Var
		);
		final EList<? extends EObject> Expr_569_list = AdditiveExpression_569_Var
		.getExpr();
		Assert.assertNotNull(Expr_569_list);
		Assert.assertEquals(1, Expr_569_list.size());
		//569
		final MultiplicativeExpression MultiplicativeExpression_570_Var
		 = (MultiplicativeExpression)Expr_569_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_570_Var
		);
		final EList<? extends EObject> Expr_570_list = MultiplicativeExpression_570_Var
		.getExpr();
		Assert.assertNotNull(Expr_570_list);
		Assert.assertEquals(1, Expr_570_list.size());
		//570
		final CastExpression CastExpression_571_Var
		 = (CastExpression)Expr_570_list.get(0);
		Assert.assertNotNull(CastExpression_571_Var
		);
		//571
		final UnaryExpression UnaryExpression_572_Var
		 = (UnaryExpression)CastExpression_571_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_572_Var
		);
		//572
		final PostfixExpression PostfixExpression_573_Var
		 = (PostfixExpression)UnaryExpression_572_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_573_Var
		);
		final EList<? extends EObject> Expr_573_list = PostfixExpression_573_Var
		.getExpr();
		Assert.assertNotNull(Expr_573_list);
		Assert.assertEquals(1, Expr_573_list.size());
		//573
		final PrimaryExpression PrimaryExpression_574_Var
		 = (PrimaryExpression)Expr_573_list.get(0);
		Assert.assertNotNull(PrimaryExpression_574_Var
		);
		Assert.assertEquals("iAmInLove", PrimaryExpression_574_Var
		.getId());
		//574
		final Statement Statement_575_Var
		 = (Statement)Statement_285_list.get(6);
		Assert.assertNotNull(Statement_575_Var
		);
		//575
		final ExpressionStatement ExpressionStatement_576_Var
		 = (ExpressionStatement)Statement_575_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_576_Var
		);
		//576
		final Expression Expression_577_Var
		 = (Expression)ExpressionStatement_576_Var
		.getExpression();
		Assert.assertNotNull(Expression_577_Var
		);
		final EList<? extends EObject> ExprExpr_577_list = Expression_577_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_577_list);
		Assert.assertEquals(1, ExprExpr_577_list.size());
		//577
		final AssignmentExpression AssignmentExpression_578_Var
		 = (AssignmentExpression)ExprExpr_577_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_593_Var
		.getId());
		final EList<? extends EObject> Suffix_593_list = PostfixExpression_592_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_593_list);
		Assert.assertEquals(1, Suffix_593_list.size());
		//593
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_594_Var
		 = (PostfixExpressionSuffixArgument)Suffix_593_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_594_Var
		);
		//594
		final ArgumentExpressionList ArgumentExpressionList_595_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_594_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_595_Var
		);
		final EList<? extends EObject> Expr_595_list = ArgumentExpressionList_595_Var
		.getExpr();
		Assert.assertNotNull(Expr_595_list);
		Assert.assertEquals(2, Expr_595_list.size());
		//595
		final AssignmentExpression AssignmentExpression_596_Var
		 = (AssignmentExpression)Expr_595_list.get(0);
		Assert.assertNotNull(AssignmentExpression_596_Var
		);
		//596
		final ConditionalExpression ConditionalExpression_597_Var
		 = (ConditionalExpression)AssignmentExpression_596_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_597_Var
		);
		//597
		final LogicalOrExpression LogicalOrExpression_598_Var
		 = (LogicalOrExpression)ConditionalExpression_597_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_598_Var
		);
		final EList<? extends EObject> Expr_598_list = LogicalOrExpression_598_Var
		.getExpr();
		Assert.assertNotNull(Expr_598_list);
		Assert.assertEquals(1, Expr_598_list.size());
		//598
		final LogicalAndExpression LogicalAndExpression_599_Var
		 = (LogicalAndExpression)Expr_598_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_599_Var
		);
		final EList<? extends EObject> Expr_599_list = LogicalAndExpression_599_Var
		.getExpr();
		Assert.assertNotNull(Expr_599_list);
		Assert.assertEquals(1, Expr_599_list.size());
		//599
		final InclusiveOrExpression InclusiveOrExpression_600_Var
		 = (InclusiveOrExpression)Expr_599_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_600_Var
		);
		final EList<? extends EObject> Expr_600_list = InclusiveOrExpression_600_Var
		.getExpr();
		Assert.assertNotNull(Expr_600_list);
		Assert.assertEquals(1, Expr_600_list.size());
		//600
		final ExclusiveOrExpression ExclusiveOrExpression_601_Var
		 = (ExclusiveOrExpression)Expr_600_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_601_Var
		);
		final EList<? extends EObject> Expr_601_list = ExclusiveOrExpression_601_Var
		.getExpr();
		Assert.assertNotNull(Expr_601_list);
		Assert.assertEquals(1, Expr_601_list.size());
		//601
		final AndExpression AndExpression_602_Var
		 = (AndExpression)Expr_601_list.get(0);
		Assert.assertNotNull(AndExpression_602_Var
		);
		final EList<? extends EObject> Expr_602_list = AndExpression_602_Var
		.getExpr();
		Assert.assertNotNull(Expr_602_list);
		Assert.assertEquals(1, Expr_602_list.size());
		//602
		final EqualityExpression EqualityExpression_603_Var
		 = (EqualityExpression)Expr_602_list.get(0);
		Assert.assertNotNull(EqualityExpression_603_Var
		);
		final EList<? extends EObject> Expr_603_list = EqualityExpression_603_Var
		.getExpr();
		Assert.assertNotNull(Expr_603_list);
		Assert.assertEquals(1, Expr_603_list.size());
		//603
		final RelationalExpression RelationalExpression_604_Var
		 = (RelationalExpression)Expr_603_list.get(0);
		Assert.assertNotNull(RelationalExpression_604_Var
		);
		final EList<? extends EObject> Expr_604_list = RelationalExpression_604_Var
		.getExpr();
		Assert.assertNotNull(Expr_604_list);
		Assert.assertEquals(1, Expr_604_list.size());
		//604
		final ShiftExpression ShiftExpression_605_Var
		 = (ShiftExpression)Expr_604_list.get(0);
		Assert.assertNotNull(ShiftExpression_605_Var
		);
		final EList<? extends EObject> Expr_605_list = ShiftExpression_605_Var
		.getExpr();
		Assert.assertNotNull(Expr_605_list);
		Assert.assertEquals(1, Expr_605_list.size());
		//605
		final AdditiveExpression AdditiveExpression_606_Var
		 = (AdditiveExpression)Expr_605_list.get(0);
		Assert.assertNotNull(AdditiveExpression_606_Var
		);
		final EList<? extends EObject> Expr_606_list = AdditiveExpression_606_Var
		.getExpr();
		Assert.assertNotNull(Expr_606_list);
		Assert.assertEquals(1, Expr_606_list.size());
		//606
		final MultiplicativeExpression MultiplicativeExpression_607_Var
		 = (MultiplicativeExpression)Expr_606_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_607_Var
		);
		final EList<? extends EObject> Expr_607_list = MultiplicativeExpression_607_Var
		.getExpr();
		Assert.assertNotNull(Expr_607_list);
		Assert.assertEquals(1, Expr_607_list.size());
		//607
		final CastExpression CastExpression_608_Var
		 = (CastExpression)Expr_607_list.get(0);
		Assert.assertNotNull(CastExpression_608_Var
		);
		//608
		final UnaryExpression UnaryExpression_609_Var
		 = (UnaryExpression)CastExpression_608_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_609_Var
		);
		//609
		final PostfixExpression PostfixExpression_610_Var
		 = (PostfixExpression)UnaryExpression_609_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_610_Var
		);
		final EList<? extends EObject> Expr_610_list = PostfixExpression_610_Var
		.getExpr();
		Assert.assertNotNull(Expr_610_list);
		Assert.assertEquals(1, Expr_610_list.size());
		//610
		final PrimaryExpression PrimaryExpression_611_Var
		 = (PrimaryExpression)Expr_610_list.get(0);
		Assert.assertNotNull(PrimaryExpression_611_Var
		);
		Assert.assertEquals("[\"The %d. day of the week is my favourite!\\n\"]", PrimaryExpression_611_Var
		.getString().toString());
		//611
		final AssignmentExpression AssignmentExpression_612_Var
		 = (AssignmentExpression)Expr_595_list.get(1);
		Assert.assertNotNull(AssignmentExpression_612_Var
		);
		//612
		final ConditionalExpression ConditionalExpression_613_Var
		 = (ConditionalExpression)AssignmentExpression_612_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_613_Var
		);
		//613
		final LogicalOrExpression LogicalOrExpression_614_Var
		 = (LogicalOrExpression)ConditionalExpression_613_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_614_Var
		);
		final EList<? extends EObject> Expr_614_list = LogicalOrExpression_614_Var
		.getExpr();
		Assert.assertNotNull(Expr_614_list);
		Assert.assertEquals(1, Expr_614_list.size());
		//614
		final LogicalAndExpression LogicalAndExpression_615_Var
		 = (LogicalAndExpression)Expr_614_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_615_Var
		);
		final EList<? extends EObject> Expr_615_list = LogicalAndExpression_615_Var
		.getExpr();
		Assert.assertNotNull(Expr_615_list);
		Assert.assertEquals(1, Expr_615_list.size());
		//615
		final InclusiveOrExpression InclusiveOrExpression_616_Var
		 = (InclusiveOrExpression)Expr_615_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_616_Var
		);
		final EList<? extends EObject> Expr_616_list = InclusiveOrExpression_616_Var
		.getExpr();
		Assert.assertNotNull(Expr_616_list);
		Assert.assertEquals(1, Expr_616_list.size());
		//616
		final ExclusiveOrExpression ExclusiveOrExpression_617_Var
		 = (ExclusiveOrExpression)Expr_616_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_617_Var
		);
		final EList<? extends EObject> Expr_617_list = ExclusiveOrExpression_617_Var
		.getExpr();
		Assert.assertNotNull(Expr_617_list);
		Assert.assertEquals(1, Expr_617_list.size());
		//617
		final AndExpression AndExpression_618_Var
		 = (AndExpression)Expr_617_list.get(0);
		Assert.assertNotNull(AndExpression_618_Var
		);
		final EList<? extends EObject> Expr_618_list = AndExpression_618_Var
		.getExpr();
		Assert.assertNotNull(Expr_618_list);
		Assert.assertEquals(1, Expr_618_list.size());
		//618
		final EqualityExpression EqualityExpression_619_Var
		 = (EqualityExpression)Expr_618_list.get(0);
		Assert.assertNotNull(EqualityExpression_619_Var
		);
		final EList<? extends EObject> Expr_619_list = EqualityExpression_619_Var
		.getExpr();
		Assert.assertNotNull(Expr_619_list);
		Assert.assertEquals(1, Expr_619_list.size());
		//619
		final RelationalExpression RelationalExpression_620_Var
		 = (RelationalExpression)Expr_619_list.get(0);
		Assert.assertNotNull(RelationalExpression_620_Var
		);
		final EList<? extends EObject> Expr_620_list = RelationalExpression_620_Var
		.getExpr();
		Assert.assertNotNull(Expr_620_list);
		Assert.assertEquals(1, Expr_620_list.size());
		//620
		final ShiftExpression ShiftExpression_621_Var
		 = (ShiftExpression)Expr_620_list.get(0);
		Assert.assertNotNull(ShiftExpression_621_Var
		);
		final EList<? extends EObject> Expr_621_list = ShiftExpression_621_Var
		.getExpr();
		Assert.assertNotNull(Expr_621_list);
		Assert.assertEquals(1, Expr_621_list.size());
		//621
		final AdditiveExpression AdditiveExpression_622_Var
		 = (AdditiveExpression)Expr_621_list.get(0);
		Assert.assertNotNull(AdditiveExpression_622_Var
		);
		final EList<? extends EObject> Expr_622_list = AdditiveExpression_622_Var
		.getExpr();
		Assert.assertNotNull(Expr_622_list);
		Assert.assertEquals(1, Expr_622_list.size());
		//622
		final MultiplicativeExpression MultiplicativeExpression_623_Var
		 = (MultiplicativeExpression)Expr_622_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_623_Var
		);
		final EList<? extends EObject> Expr_623_list = MultiplicativeExpression_623_Var
		.getExpr();
		Assert.assertNotNull(Expr_623_list);
		Assert.assertEquals(1, Expr_623_list.size());
		//623
		final CastExpression CastExpression_624_Var
		 = (CastExpression)Expr_623_list.get(0);
		Assert.assertNotNull(CastExpression_624_Var
		);
		//624
		final UnaryExpression UnaryExpression_625_Var
		 = (UnaryExpression)CastExpression_624_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_625_Var
		);
		//625
		final PostfixExpression PostfixExpression_626_Var
		 = (PostfixExpression)UnaryExpression_625_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_626_Var
		);
		final EList<? extends EObject> Expr_626_list = PostfixExpression_626_Var
		.getExpr();
		Assert.assertNotNull(Expr_626_list);
		Assert.assertEquals(1, Expr_626_list.size());
		//626
		final PrimaryExpression PrimaryExpression_627_Var
		 = (PrimaryExpression)Expr_626_list.get(0);
		Assert.assertNotNull(PrimaryExpression_627_Var
		);
		Assert.assertEquals("my_weekday", PrimaryExpression_627_Var
		.getId());
		//627
		final Statement Statement_628_Var
		 = (Statement)Statement_285_list.get(7);
		Assert.assertNotNull(Statement_628_Var
		);
		//628
		final JumpStatement JumpStatement_629_Var
		 = (JumpStatement)Statement_628_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_629_Var
		);
		//629
		final Expression Expression_630_Var
		 = (Expression)JumpStatement_629_Var
		.getExpr();
		Assert.assertNotNull(Expression_630_Var
		);
		final EList<? extends EObject> ExprExpr_630_list = Expression_630_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_630_list);
		Assert.assertEquals(1, ExprExpr_630_list.size());
		//630
		final AssignmentExpression AssignmentExpression_631_Var
		 = (AssignmentExpression)ExprExpr_630_list.get(0);
		Assert.assertNotNull(AssignmentExpression_631_Var
		);
		//631
		final ConditionalExpression ConditionalExpression_632_Var
		 = (ConditionalExpression)AssignmentExpression_631_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_632_Var
		);
		//632
		final LogicalOrExpression LogicalOrExpression_633_Var
		 = (LogicalOrExpression)ConditionalExpression_632_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_633_Var
		);
		final EList<? extends EObject> Expr_633_list = LogicalOrExpression_633_Var
		.getExpr();
		Assert.assertNotNull(Expr_633_list);
		Assert.assertEquals(1, Expr_633_list.size());
		//633
		final LogicalAndExpression LogicalAndExpression_634_Var
		 = (LogicalAndExpression)Expr_633_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_634_Var
		);
		final EList<? extends EObject> Expr_634_list = LogicalAndExpression_634_Var
		.getExpr();
		Assert.assertNotNull(Expr_634_list);
		Assert.assertEquals(1, Expr_634_list.size());
		//634
		final InclusiveOrExpression InclusiveOrExpression_635_Var
		 = (InclusiveOrExpression)Expr_634_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_635_Var
		);
		final EList<? extends EObject> Expr_635_list = InclusiveOrExpression_635_Var
		.getExpr();
		Assert.assertNotNull(Expr_635_list);
		Assert.assertEquals(1, Expr_635_list.size());
		//635
		final ExclusiveOrExpression ExclusiveOrExpression_636_Var
		 = (ExclusiveOrExpression)Expr_635_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_636_Var
		);
		final EList<? extends EObject> Expr_636_list = ExclusiveOrExpression_636_Var
		.getExpr();
		Assert.assertNotNull(Expr_636_list);
		Assert.assertEquals(1, Expr_636_list.size());
		//636
		final AndExpression AndExpression_637_Var
		 = (AndExpression)Expr_636_list.get(0);
		Assert.assertNotNull(AndExpression_637_Var
		);
		final EList<? extends EObject> Expr_637_list = AndExpression_637_Var
		.getExpr();
		Assert.assertNotNull(Expr_637_list);
		Assert.assertEquals(1, Expr_637_list.size());
		//637
		final EqualityExpression EqualityExpression_638_Var
		 = (EqualityExpression)Expr_637_list.get(0);
		Assert.assertNotNull(EqualityExpression_638_Var
		);
		final EList<? extends EObject> Expr_638_list = EqualityExpression_638_Var
		.getExpr();
		Assert.assertNotNull(Expr_638_list);
		Assert.assertEquals(1, Expr_638_list.size());
		//638
		final RelationalExpression RelationalExpression_639_Var
		 = (RelationalExpression)Expr_638_list.get(0);
		Assert.assertNotNull(RelationalExpression_639_Var
		);
		final EList<? extends EObject> Expr_639_list = RelationalExpression_639_Var
		.getExpr();
		Assert.assertNotNull(Expr_639_list);
		Assert.assertEquals(1, Expr_639_list.size());
		//639
		final ShiftExpression ShiftExpression_640_Var
		 = (ShiftExpression)Expr_639_list.get(0);
		Assert.assertNotNull(ShiftExpression_640_Var
		);
		final EList<? extends EObject> Expr_640_list = ShiftExpression_640_Var
		.getExpr();
		Assert.assertNotNull(Expr_640_list);
		Assert.assertEquals(1, Expr_640_list.size());
		//640
		final AdditiveExpression AdditiveExpression_641_Var
		 = (AdditiveExpression)Expr_640_list.get(0);
		Assert.assertNotNull(AdditiveExpression_641_Var
		);
		final EList<? extends EObject> Expr_641_list = AdditiveExpression_641_Var
		.getExpr();
		Assert.assertNotNull(Expr_641_list);
		Assert.assertEquals(1, Expr_641_list.size());
		//641
		final MultiplicativeExpression MultiplicativeExpression_642_Var
		 = (MultiplicativeExpression)Expr_641_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_642_Var
		);
		final EList<? extends EObject> Expr_642_list = MultiplicativeExpression_642_Var
		.getExpr();
		Assert.assertNotNull(Expr_642_list);
		Assert.assertEquals(1, Expr_642_list.size());
		//642
		final CastExpression CastExpression_643_Var
		 = (CastExpression)Expr_642_list.get(0);
		Assert.assertNotNull(CastExpression_643_Var
		);
		//643
		final UnaryExpression UnaryExpression_644_Var
		 = (UnaryExpression)CastExpression_643_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_644_Var
		);
		//644
		final PostfixExpression PostfixExpression_645_Var
		 = (PostfixExpression)UnaryExpression_644_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_645_Var
		);
		final EList<? extends EObject> Expr_645_list = PostfixExpression_645_Var
		.getExpr();
		Assert.assertNotNull(Expr_645_list);
		Assert.assertEquals(1, Expr_645_list.size());
		//645
		final PrimaryExpression PrimaryExpression_646_Var
		 = (PrimaryExpression)Expr_645_list.get(0);
		Assert.assertNotNull(PrimaryExpression_646_Var
		);
		//646
		final Constant2 Constant2_647_Var
		 = (Constant2)PrimaryExpression_646_Var
		.getConst();
		Assert.assertNotNull(Constant2_647_Var
		);
		Assert.assertEquals("0", Constant2_647_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_629_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
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


