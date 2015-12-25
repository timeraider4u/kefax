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
		Assert.assertEquals(6, External_2_list.size());
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
		final TypeQualifier TypeQualifier_6_Var
		 = (TypeQualifier)DeclarationSpecifier_5_list.get(0);
		Assert.assertNotNull(TypeQualifier_6_Var
		);
		Assert.assertEquals("const", TypeQualifier_6_Var
		.getType());
		//6
		final TypeSpecifier TypeSpecifier_7_Var
		 = (TypeSpecifier)DeclarationSpecifier_5_list.get(1);
		Assert.assertNotNull(TypeSpecifier_7_Var
		);
		Assert.assertEquals("int", TypeSpecifier_7_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_7_list = Declaration_4_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_7_list);
		Assert.assertEquals(1, InitDeclaratorList_7_list.size());
		//7
		final InitDeclaratorList InitDeclaratorList_8_Var
		 = (InitDeclaratorList)InitDeclaratorList_7_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_8_Var
		);
		final EList<? extends EObject> InitDeclarator_8_list = InitDeclaratorList_8_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_8_list);
		Assert.assertEquals(7, InitDeclarator_8_list.size());
		//8
		final InitDeclarator InitDeclarator_9_Var
		 = (InitDeclarator)InitDeclarator_8_list.get(0);
		Assert.assertNotNull(InitDeclarator_9_Var
		);
		//9
		final Declarator Declarator_10_Var
		 = (Declarator)InitDeclarator_9_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_10_Var
		);
		//10
		final DirectDeclarator DirectDeclarator_11_Var
		 = (DirectDeclarator)Declarator_10_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_11_Var
		);
		Assert.assertEquals("W_MONDAY", DirectDeclarator_11_Var
		.getId());
		//11
		final Initializer Initializer_12_Var
		 = (Initializer)InitDeclarator_9_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_12_Var
		);
		//12
		final AssignmentExpression AssignmentExpression_13_Var
		 = (AssignmentExpression)Initializer_12_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_13_Var
		);
		//13
		final ConditionalExpression ConditionalExpression_14_Var
		 = (ConditionalExpression)AssignmentExpression_13_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_14_Var
		);
		//14
		final LogicalOrExpression LogicalOrExpression_15_Var
		 = (LogicalOrExpression)ConditionalExpression_14_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = LogicalOrExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final LogicalAndExpression LogicalAndExpression_16_Var
		 = (LogicalAndExpression)Expr_15_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = LogicalAndExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final InclusiveOrExpression InclusiveOrExpression_17_Var
		 = (InclusiveOrExpression)Expr_16_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = InclusiveOrExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final ExclusiveOrExpression ExclusiveOrExpression_18_Var
		 = (ExclusiveOrExpression)Expr_17_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = ExclusiveOrExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final AndExpression AndExpression_19_Var
		 = (AndExpression)Expr_18_list.get(0);
		Assert.assertNotNull(AndExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = AndExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final EqualityExpression EqualityExpression_20_Var
		 = (EqualityExpression)Expr_19_list.get(0);
		Assert.assertNotNull(EqualityExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = EqualityExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final RelationalExpression RelationalExpression_21_Var
		 = (RelationalExpression)Expr_20_list.get(0);
		Assert.assertNotNull(RelationalExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = RelationalExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final ShiftExpression ShiftExpression_22_Var
		 = (ShiftExpression)Expr_21_list.get(0);
		Assert.assertNotNull(ShiftExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = ShiftExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final AdditiveExpression AdditiveExpression_23_Var
		 = (AdditiveExpression)Expr_22_list.get(0);
		Assert.assertNotNull(AdditiveExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = AdditiveExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final MultiplicativeExpression MultiplicativeExpression_24_Var
		 = (MultiplicativeExpression)Expr_23_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_24_Var
		);
		final EList<? extends EObject> Expr_24_list = MultiplicativeExpression_24_Var
		.getExpr();
		Assert.assertNotNull(Expr_24_list);
		Assert.assertEquals(1, Expr_24_list.size());
		//24
		final CastExpression CastExpression_25_Var
		 = (CastExpression)Expr_24_list.get(0);
		Assert.assertNotNull(CastExpression_25_Var
		);
		//25
		final UnaryExpression UnaryExpression_26_Var
		 = (UnaryExpression)CastExpression_25_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_26_Var
		);
		//26
		final PostfixExpression PostfixExpression_27_Var
		 = (PostfixExpression)UnaryExpression_26_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = PostfixExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final PrimaryExpression PrimaryExpression_28_Var
		 = (PrimaryExpression)Expr_27_list.get(0);
		Assert.assertNotNull(PrimaryExpression_28_Var
		);
		//28
		final Constant2 Constant2_29_Var
		 = (Constant2)PrimaryExpression_28_Var
		.getConst();
		Assert.assertNotNull(Constant2_29_Var
		);
		Assert.assertEquals("1", Constant2_29_Var
		.getDec());
		//29
		final InitDeclarator InitDeclarator_30_Var
		 = (InitDeclarator)InitDeclarator_8_list.get(1);
		Assert.assertNotNull(InitDeclarator_30_Var
		);
		//30
		final Declarator Declarator_31_Var
		 = (Declarator)InitDeclarator_30_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_31_Var
		);
		//31
		final DirectDeclarator DirectDeclarator_32_Var
		 = (DirectDeclarator)Declarator_31_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_32_Var
		);
		Assert.assertEquals("W_TUESDAY", DirectDeclarator_32_Var
		.getId());
		//32
		final Initializer Initializer_33_Var
		 = (Initializer)InitDeclarator_30_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_33_Var
		);
		//33
		final AssignmentExpression AssignmentExpression_34_Var
		 = (AssignmentExpression)Initializer_33_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_34_Var
		);
		//34
		final ConditionalExpression ConditionalExpression_35_Var
		 = (ConditionalExpression)AssignmentExpression_34_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_35_Var
		);
		//35
		final LogicalOrExpression LogicalOrExpression_36_Var
		 = (LogicalOrExpression)ConditionalExpression_35_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = LogicalOrExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final LogicalAndExpression LogicalAndExpression_37_Var
		 = (LogicalAndExpression)Expr_36_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = LogicalAndExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final InclusiveOrExpression InclusiveOrExpression_38_Var
		 = (InclusiveOrExpression)Expr_37_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = InclusiveOrExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final ExclusiveOrExpression ExclusiveOrExpression_39_Var
		 = (ExclusiveOrExpression)Expr_38_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = ExclusiveOrExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final AndExpression AndExpression_40_Var
		 = (AndExpression)Expr_39_list.get(0);
		Assert.assertNotNull(AndExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = AndExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final EqualityExpression EqualityExpression_41_Var
		 = (EqualityExpression)Expr_40_list.get(0);
		Assert.assertNotNull(EqualityExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = EqualityExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final RelationalExpression RelationalExpression_42_Var
		 = (RelationalExpression)Expr_41_list.get(0);
		Assert.assertNotNull(RelationalExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = RelationalExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final ShiftExpression ShiftExpression_43_Var
		 = (ShiftExpression)Expr_42_list.get(0);
		Assert.assertNotNull(ShiftExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = ShiftExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final AdditiveExpression AdditiveExpression_44_Var
		 = (AdditiveExpression)Expr_43_list.get(0);
		Assert.assertNotNull(AdditiveExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = AdditiveExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final MultiplicativeExpression MultiplicativeExpression_45_Var
		 = (MultiplicativeExpression)Expr_44_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_45_Var
		);
		final EList<? extends EObject> Expr_45_list = MultiplicativeExpression_45_Var
		.getExpr();
		Assert.assertNotNull(Expr_45_list);
		Assert.assertEquals(1, Expr_45_list.size());
		//45
		final CastExpression CastExpression_46_Var
		 = (CastExpression)Expr_45_list.get(0);
		Assert.assertNotNull(CastExpression_46_Var
		);
		//46
		final UnaryExpression UnaryExpression_47_Var
		 = (UnaryExpression)CastExpression_46_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_47_Var
		);
		//47
		final PostfixExpression PostfixExpression_48_Var
		 = (PostfixExpression)UnaryExpression_47_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_48_Var
		);
		final EList<? extends EObject> Expr_48_list = PostfixExpression_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(1, Expr_48_list.size());
		//48
		final PrimaryExpression PrimaryExpression_49_Var
		 = (PrimaryExpression)Expr_48_list.get(0);
		Assert.assertNotNull(PrimaryExpression_49_Var
		);
		//49
		final Constant2 Constant2_50_Var
		 = (Constant2)PrimaryExpression_49_Var
		.getConst();
		Assert.assertNotNull(Constant2_50_Var
		);
		Assert.assertEquals("2", Constant2_50_Var
		.getDec());
		//50
		final InitDeclarator InitDeclarator_51_Var
		 = (InitDeclarator)InitDeclarator_8_list.get(2);
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
		Assert.assertEquals("W_WEDNESDAY", DirectDeclarator_53_Var
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
		final UnaryExpression UnaryExpression_68_Var
		 = (UnaryExpression)CastExpression_67_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_68_Var
		);
		//68
		final PostfixExpression PostfixExpression_69_Var
		 = (PostfixExpression)UnaryExpression_68_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = PostfixExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final PrimaryExpression PrimaryExpression_70_Var
		 = (PrimaryExpression)Expr_69_list.get(0);
		Assert.assertNotNull(PrimaryExpression_70_Var
		);
		//70
		final Constant2 Constant2_71_Var
		 = (Constant2)PrimaryExpression_70_Var
		.getConst();
		Assert.assertNotNull(Constant2_71_Var
		);
		Assert.assertEquals("3", Constant2_71_Var
		.getDec());
		//71
		final InitDeclarator InitDeclarator_72_Var
		 = (InitDeclarator)InitDeclarator_8_list.get(3);
		Assert.assertNotNull(InitDeclarator_72_Var
		);
		//72
		final Declarator Declarator_73_Var
		 = (Declarator)InitDeclarator_72_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_73_Var
		);
		//73
		final DirectDeclarator DirectDeclarator_74_Var
		 = (DirectDeclarator)Declarator_73_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_74_Var
		);
		Assert.assertEquals("W_THURSDAY", DirectDeclarator_74_Var
		.getId());
		//74
		final Initializer Initializer_75_Var
		 = (Initializer)InitDeclarator_72_Var
		.getInitializer();
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
		Assert.assertEquals("4", Constant2_92_Var
		.getDec());
		//92
		final InitDeclarator InitDeclarator_93_Var
		 = (InitDeclarator)InitDeclarator_8_list.get(4);
		Assert.assertNotNull(InitDeclarator_93_Var
		);
		//93
		final Declarator Declarator_94_Var
		 = (Declarator)InitDeclarator_93_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_94_Var
		);
		//94
		final DirectDeclarator DirectDeclarator_95_Var
		 = (DirectDeclarator)Declarator_94_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_95_Var
		);
		Assert.assertEquals("W_FRIDAY", DirectDeclarator_95_Var
		.getId());
		//95
		final Initializer Initializer_96_Var
		 = (Initializer)InitDeclarator_93_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_96_Var
		);
		//96
		final AssignmentExpression AssignmentExpression_97_Var
		 = (AssignmentExpression)Initializer_96_Var
		.getExpr();
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
		//112
		final Constant2 Constant2_113_Var
		 = (Constant2)PrimaryExpression_112_Var
		.getConst();
		Assert.assertNotNull(Constant2_113_Var
		);
		Assert.assertEquals("5", Constant2_113_Var
		.getDec());
		//113
		final InitDeclarator InitDeclarator_114_Var
		 = (InitDeclarator)InitDeclarator_8_list.get(5);
		Assert.assertNotNull(InitDeclarator_114_Var
		);
		//114
		final Declarator Declarator_115_Var
		 = (Declarator)InitDeclarator_114_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_115_Var
		);
		//115
		final DirectDeclarator DirectDeclarator_116_Var
		 = (DirectDeclarator)Declarator_115_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_116_Var
		);
		Assert.assertEquals("W_SATURDAY", DirectDeclarator_116_Var
		.getId());
		//116
		final Initializer Initializer_117_Var
		 = (Initializer)InitDeclarator_114_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_117_Var
		);
		//117
		final AssignmentExpression AssignmentExpression_118_Var
		 = (AssignmentExpression)Initializer_117_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_118_Var
		);
		//118
		final ConditionalExpression ConditionalExpression_119_Var
		 = (ConditionalExpression)AssignmentExpression_118_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_119_Var
		);
		//119
		final LogicalOrExpression LogicalOrExpression_120_Var
		 = (LogicalOrExpression)ConditionalExpression_119_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = LogicalOrExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final LogicalAndExpression LogicalAndExpression_121_Var
		 = (LogicalAndExpression)Expr_120_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = LogicalAndExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final InclusiveOrExpression InclusiveOrExpression_122_Var
		 = (InclusiveOrExpression)Expr_121_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = InclusiveOrExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final ExclusiveOrExpression ExclusiveOrExpression_123_Var
		 = (ExclusiveOrExpression)Expr_122_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = ExclusiveOrExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final AndExpression AndExpression_124_Var
		 = (AndExpression)Expr_123_list.get(0);
		Assert.assertNotNull(AndExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = AndExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final EqualityExpression EqualityExpression_125_Var
		 = (EqualityExpression)Expr_124_list.get(0);
		Assert.assertNotNull(EqualityExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = EqualityExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final RelationalExpression RelationalExpression_126_Var
		 = (RelationalExpression)Expr_125_list.get(0);
		Assert.assertNotNull(RelationalExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = RelationalExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final ShiftExpression ShiftExpression_127_Var
		 = (ShiftExpression)Expr_126_list.get(0);
		Assert.assertNotNull(ShiftExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = ShiftExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final AdditiveExpression AdditiveExpression_128_Var
		 = (AdditiveExpression)Expr_127_list.get(0);
		Assert.assertNotNull(AdditiveExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = AdditiveExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final MultiplicativeExpression MultiplicativeExpression_129_Var
		 = (MultiplicativeExpression)Expr_128_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = MultiplicativeExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final CastExpression CastExpression_130_Var
		 = (CastExpression)Expr_129_list.get(0);
		Assert.assertNotNull(CastExpression_130_Var
		);
		//130
		final UnaryExpression UnaryExpression_131_Var
		 = (UnaryExpression)CastExpression_130_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_131_Var
		);
		//131
		final PostfixExpression PostfixExpression_132_Var
		 = (PostfixExpression)UnaryExpression_131_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = PostfixExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final PrimaryExpression PrimaryExpression_133_Var
		 = (PrimaryExpression)Expr_132_list.get(0);
		Assert.assertNotNull(PrimaryExpression_133_Var
		);
		//133
		final Constant2 Constant2_134_Var
		 = (Constant2)PrimaryExpression_133_Var
		.getConst();
		Assert.assertNotNull(Constant2_134_Var
		);
		Assert.assertEquals("6", Constant2_134_Var
		.getDec());
		//134
		final InitDeclarator InitDeclarator_135_Var
		 = (InitDeclarator)InitDeclarator_8_list.get(6);
		Assert.assertNotNull(InitDeclarator_135_Var
		);
		//135
		final Declarator Declarator_136_Var
		 = (Declarator)InitDeclarator_135_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_136_Var
		);
		//136
		final DirectDeclarator DirectDeclarator_137_Var
		 = (DirectDeclarator)Declarator_136_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_137_Var
		);
		Assert.assertEquals("W_SUNDAY", DirectDeclarator_137_Var
		.getId());
		//137
		final Initializer Initializer_138_Var
		 = (Initializer)InitDeclarator_135_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_138_Var
		);
		//138
		final AssignmentExpression AssignmentExpression_139_Var
		 = (AssignmentExpression)Initializer_138_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_139_Var
		);
		//139
		final ConditionalExpression ConditionalExpression_140_Var
		 = (ConditionalExpression)AssignmentExpression_139_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_140_Var
		);
		//140
		final LogicalOrExpression LogicalOrExpression_141_Var
		 = (LogicalOrExpression)ConditionalExpression_140_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = LogicalOrExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final LogicalAndExpression LogicalAndExpression_142_Var
		 = (LogicalAndExpression)Expr_141_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = LogicalAndExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final InclusiveOrExpression InclusiveOrExpression_143_Var
		 = (InclusiveOrExpression)Expr_142_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = InclusiveOrExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final ExclusiveOrExpression ExclusiveOrExpression_144_Var
		 = (ExclusiveOrExpression)Expr_143_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = ExclusiveOrExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final AndExpression AndExpression_145_Var
		 = (AndExpression)Expr_144_list.get(0);
		Assert.assertNotNull(AndExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = AndExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final EqualityExpression EqualityExpression_146_Var
		 = (EqualityExpression)Expr_145_list.get(0);
		Assert.assertNotNull(EqualityExpression_146_Var
		);
		final EList<? extends EObject> Expr_146_list = EqualityExpression_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final RelationalExpression RelationalExpression_147_Var
		 = (RelationalExpression)Expr_146_list.get(0);
		Assert.assertNotNull(RelationalExpression_147_Var
		);
		final EList<? extends EObject> Expr_147_list = RelationalExpression_147_Var
		.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(1, Expr_147_list.size());
		//147
		final ShiftExpression ShiftExpression_148_Var
		 = (ShiftExpression)Expr_147_list.get(0);
		Assert.assertNotNull(ShiftExpression_148_Var
		);
		final EList<? extends EObject> Expr_148_list = ShiftExpression_148_Var
		.getExpr();
		Assert.assertNotNull(Expr_148_list);
		Assert.assertEquals(1, Expr_148_list.size());
		//148
		final AdditiveExpression AdditiveExpression_149_Var
		 = (AdditiveExpression)Expr_148_list.get(0);
		Assert.assertNotNull(AdditiveExpression_149_Var
		);
		final EList<? extends EObject> Expr_149_list = AdditiveExpression_149_Var
		.getExpr();
		Assert.assertNotNull(Expr_149_list);
		Assert.assertEquals(1, Expr_149_list.size());
		//149
		final MultiplicativeExpression MultiplicativeExpression_150_Var
		 = (MultiplicativeExpression)Expr_149_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_150_Var
		);
		final EList<? extends EObject> Expr_150_list = MultiplicativeExpression_150_Var
		.getExpr();
		Assert.assertNotNull(Expr_150_list);
		Assert.assertEquals(1, Expr_150_list.size());
		//150
		final CastExpression CastExpression_151_Var
		 = (CastExpression)Expr_150_list.get(0);
		Assert.assertNotNull(CastExpression_151_Var
		);
		//151
		final UnaryExpression UnaryExpression_152_Var
		 = (UnaryExpression)CastExpression_151_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_152_Var
		);
		//152
		final PostfixExpression PostfixExpression_153_Var
		 = (PostfixExpression)UnaryExpression_152_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_153_Var
		);
		final EList<? extends EObject> Expr_153_list = PostfixExpression_153_Var
		.getExpr();
		Assert.assertNotNull(Expr_153_list);
		Assert.assertEquals(1, Expr_153_list.size());
		//153
		final PrimaryExpression PrimaryExpression_154_Var
		 = (PrimaryExpression)Expr_153_list.get(0);
		Assert.assertNotNull(PrimaryExpression_154_Var
		);
		//154
		final Constant2 Constant2_155_Var
		 = (Constant2)PrimaryExpression_154_Var
		.getConst();
		Assert.assertNotNull(Constant2_155_Var
		);
		Assert.assertEquals("7", Constant2_155_Var
		.getDec());
		Assert.assertEquals(";", Declaration_4_Var
		.getSemi());
		//155
		final ExternalDeclaration ExternalDeclaration_156_Var
		 = (ExternalDeclaration)External_2_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_156_Var
		);
		//156
		final Declaration Declaration_157_Var
		 = (Declaration)ExternalDeclaration_156_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_157_Var
		);
		//157
		final DeclarationSpecifiers DeclarationSpecifiers_158_Var
		 = (DeclarationSpecifiers)Declaration_157_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_158_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_158_list = DeclarationSpecifiers_158_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_158_list);
		Assert.assertEquals(1, DeclarationSpecifier_158_list.size());
		//158
		final TypeSpecifier TypeSpecifier_159_Var
		 = (TypeSpecifier)DeclarationSpecifier_158_list.get(0);
		Assert.assertNotNull(TypeSpecifier_159_Var
		);
		//159
		final EnumSpecifier EnumSpecifier_160_Var
		 = (EnumSpecifier)TypeSpecifier_159_Var
		.getSpecifier();
		Assert.assertNotNull(EnumSpecifier_160_Var
		);
		//160
		final EnumeratorList EnumeratorList_161_Var
		 = (EnumeratorList)EnumSpecifier_160_Var
		.getEnumList();
		Assert.assertNotNull(EnumeratorList_161_Var
		);
		final EList<? extends EObject> Enumerator_161_list = EnumeratorList_161_Var
		.getEnumerator();
		Assert.assertNotNull(Enumerator_161_list);
		Assert.assertEquals(7, Enumerator_161_list.size());
		//161
		final Enumerator Enumerator_162_Var
		 = (Enumerator)Enumerator_161_list.get(0);
		Assert.assertNotNull(Enumerator_162_Var
		);
		Assert.assertEquals("MONDAY", Enumerator_162_Var
		.getId());
		//162
		final ConstantExpression ConstantExpression_163_Var
		 = (ConstantExpression)Enumerator_162_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_163_Var
		);
		//163
		final ConditionalExpression ConditionalExpression_164_Var
		 = (ConditionalExpression)ConstantExpression_163_Var
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
		//178
		final Constant2 Constant2_179_Var
		 = (Constant2)PrimaryExpression_178_Var
		.getConst();
		Assert.assertNotNull(Constant2_179_Var
		);
		Assert.assertEquals("1", Constant2_179_Var
		.getDec());
		//179
		final Enumerator Enumerator_180_Var
		 = (Enumerator)Enumerator_161_list.get(1);
		Assert.assertNotNull(Enumerator_180_Var
		);
		Assert.assertEquals("TUESDAY", Enumerator_180_Var
		.getId());
		//180
		final Enumerator Enumerator_181_Var
		 = (Enumerator)Enumerator_161_list.get(2);
		Assert.assertNotNull(Enumerator_181_Var
		);
		Assert.assertEquals("WEDNESDAY", Enumerator_181_Var
		.getId());
		//181
		final Enumerator Enumerator_182_Var
		 = (Enumerator)Enumerator_161_list.get(3);
		Assert.assertNotNull(Enumerator_182_Var
		);
		Assert.assertEquals("THURSDAY", Enumerator_182_Var
		.getId());
		//182
		final Enumerator Enumerator_183_Var
		 = (Enumerator)Enumerator_161_list.get(4);
		Assert.assertNotNull(Enumerator_183_Var
		);
		Assert.assertEquals("FRIDAY", Enumerator_183_Var
		.getId());
		//183
		final Enumerator Enumerator_184_Var
		 = (Enumerator)Enumerator_161_list.get(5);
		Assert.assertNotNull(Enumerator_184_Var
		);
		Assert.assertEquals("SATURDAY", Enumerator_184_Var
		.getId());
		//184
		final Enumerator Enumerator_185_Var
		 = (Enumerator)Enumerator_161_list.get(6);
		Assert.assertNotNull(Enumerator_185_Var
		);
		Assert.assertEquals("SUNDAY", Enumerator_185_Var
		.getId());
		//185
		final ExternalDeclaration ExternalDeclaration_186_Var
		 = (ExternalDeclaration)External_2_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_186_Var
		);
		//186
		final Declaration Declaration_187_Var
		 = (Declaration)ExternalDeclaration_186_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_187_Var
		);
		//187
		final DeclarationSpecifiers DeclarationSpecifiers_188_Var
		 = (DeclarationSpecifiers)Declaration_187_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_188_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_188_list = DeclarationSpecifiers_188_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_188_list);
		Assert.assertEquals(1, DeclarationSpecifier_188_list.size());
		//188
		final TypeSpecifier TypeSpecifier_189_Var
		 = (TypeSpecifier)DeclarationSpecifier_188_list.get(0);
		Assert.assertNotNull(TypeSpecifier_189_Var
		);
		//189
		final EnumSpecifier EnumSpecifier_190_Var
		 = (EnumSpecifier)TypeSpecifier_189_Var
		.getSpecifier();
		Assert.assertNotNull(EnumSpecifier_190_Var
		);
		//190
		final EnumeratorList EnumeratorList_191_Var
		 = (EnumeratorList)EnumSpecifier_190_Var
		.getEnumList();
		Assert.assertNotNull(EnumeratorList_191_Var
		);
		final EList<? extends EObject> Enumerator_191_list = EnumeratorList_191_Var
		.getEnumerator();
		Assert.assertNotNull(Enumerator_191_list);
		Assert.assertEquals(7, Enumerator_191_list.size());
		//191
		final Enumerator Enumerator_192_Var
		 = (Enumerator)Enumerator_191_list.get(0);
		Assert.assertNotNull(Enumerator_192_Var
		);
		Assert.assertEquals("I_MONDAY", Enumerator_192_Var
		.getId());
		//192
		final ConstantExpression ConstantExpression_193_Var
		 = (ConstantExpression)Enumerator_192_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_193_Var
		);
		//193
		final ConditionalExpression ConditionalExpression_194_Var
		 = (ConditionalExpression)ConstantExpression_193_Var
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
		final Constant2 Constant2_209_Var
		 = (Constant2)PrimaryExpression_208_Var
		.getConst();
		Assert.assertNotNull(Constant2_209_Var
		);
		Assert.assertEquals("1", Constant2_209_Var
		.getDec());
		//209
		final Enumerator Enumerator_210_Var
		 = (Enumerator)Enumerator_191_list.get(1);
		Assert.assertNotNull(Enumerator_210_Var
		);
		Assert.assertEquals("I_TUESDAY", Enumerator_210_Var
		.getId());
		//210
		final Enumerator Enumerator_211_Var
		 = (Enumerator)Enumerator_191_list.get(2);
		Assert.assertNotNull(Enumerator_211_Var
		);
		Assert.assertEquals("I_WEDNESDAY", Enumerator_211_Var
		.getId());
		//211
		final Enumerator Enumerator_212_Var
		 = (Enumerator)Enumerator_191_list.get(3);
		Assert.assertNotNull(Enumerator_212_Var
		);
		Assert.assertEquals("I_THURSDAY", Enumerator_212_Var
		.getId());
		//212
		final Enumerator Enumerator_213_Var
		 = (Enumerator)Enumerator_191_list.get(4);
		Assert.assertNotNull(Enumerator_213_Var
		);
		Assert.assertEquals("I_FRIDAY", Enumerator_213_Var
		.getId());
		//213
		final Enumerator Enumerator_214_Var
		 = (Enumerator)Enumerator_191_list.get(5);
		Assert.assertNotNull(Enumerator_214_Var
		);
		Assert.assertEquals("I_SATURDAY", Enumerator_214_Var
		.getId());
		//214
		final Enumerator Enumerator_215_Var
		 = (Enumerator)Enumerator_191_list.get(6);
		Assert.assertNotNull(Enumerator_215_Var
		);
		Assert.assertEquals("I_SUNDAY", Enumerator_215_Var
		.getId());
		//215
		final ExternalDeclaration ExternalDeclaration_216_Var
		 = (ExternalDeclaration)External_2_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_216_Var
		);
		//216
		final Declaration Declaration_217_Var
		 = (Declaration)ExternalDeclaration_216_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_217_Var
		);
		//217
		final DeclarationSpecifiers DeclarationSpecifiers_218_Var
		 = (DeclarationSpecifiers)Declaration_217_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_218_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_218_list = DeclarationSpecifiers_218_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_218_list);
		Assert.assertEquals(1, DeclarationSpecifier_218_list.size());
		//218
		final TypeSpecifier TypeSpecifier_219_Var
		 = (TypeSpecifier)DeclarationSpecifier_218_list.get(0);
		Assert.assertNotNull(TypeSpecifier_219_Var
		);
		//219
		final EnumSpecifier EnumSpecifier_220_Var
		 = (EnumSpecifier)TypeSpecifier_219_Var
		.getSpecifier();
		Assert.assertNotNull(EnumSpecifier_220_Var
		);
		Assert.assertEquals("weekdays", EnumSpecifier_220_Var
		.getId());
		//220
		final EnumeratorList EnumeratorList_221_Var
		 = (EnumeratorList)EnumSpecifier_220_Var
		.getEnumList();
		Assert.assertNotNull(EnumeratorList_221_Var
		);
		final EList<? extends EObject> Enumerator_221_list = EnumeratorList_221_Var
		.getEnumerator();
		Assert.assertNotNull(Enumerator_221_list);
		Assert.assertEquals(7, Enumerator_221_list.size());
		//221
		final Enumerator Enumerator_222_Var
		 = (Enumerator)Enumerator_221_list.get(0);
		Assert.assertNotNull(Enumerator_222_Var
		);
		Assert.assertEquals("M_MONDAY", Enumerator_222_Var
		.getId());
		//222
		final ConstantExpression ConstantExpression_223_Var
		 = (ConstantExpression)Enumerator_222_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_223_Var
		);
		//223
		final ConditionalExpression ConditionalExpression_224_Var
		 = (ConditionalExpression)ConstantExpression_223_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_224_Var
		);
		//224
		final LogicalOrExpression LogicalOrExpression_225_Var
		 = (LogicalOrExpression)ConditionalExpression_224_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = LogicalOrExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final LogicalAndExpression LogicalAndExpression_226_Var
		 = (LogicalAndExpression)Expr_225_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = LogicalAndExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final InclusiveOrExpression InclusiveOrExpression_227_Var
		 = (InclusiveOrExpression)Expr_226_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = InclusiveOrExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final ExclusiveOrExpression ExclusiveOrExpression_228_Var
		 = (ExclusiveOrExpression)Expr_227_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = ExclusiveOrExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final AndExpression AndExpression_229_Var
		 = (AndExpression)Expr_228_list.get(0);
		Assert.assertNotNull(AndExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = AndExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final EqualityExpression EqualityExpression_230_Var
		 = (EqualityExpression)Expr_229_list.get(0);
		Assert.assertNotNull(EqualityExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = EqualityExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final RelationalExpression RelationalExpression_231_Var
		 = (RelationalExpression)Expr_230_list.get(0);
		Assert.assertNotNull(RelationalExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = RelationalExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final ShiftExpression ShiftExpression_232_Var
		 = (ShiftExpression)Expr_231_list.get(0);
		Assert.assertNotNull(ShiftExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = ShiftExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final AdditiveExpression AdditiveExpression_233_Var
		 = (AdditiveExpression)Expr_232_list.get(0);
		Assert.assertNotNull(AdditiveExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = AdditiveExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final MultiplicativeExpression MultiplicativeExpression_234_Var
		 = (MultiplicativeExpression)Expr_233_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = MultiplicativeExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final CastExpression CastExpression_235_Var
		 = (CastExpression)Expr_234_list.get(0);
		Assert.assertNotNull(CastExpression_235_Var
		);
		//235
		final UnaryExpression UnaryExpression_236_Var
		 = (UnaryExpression)CastExpression_235_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_236_Var
		);
		//236
		final PostfixExpression PostfixExpression_237_Var
		 = (PostfixExpression)UnaryExpression_236_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = PostfixExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final PrimaryExpression PrimaryExpression_238_Var
		 = (PrimaryExpression)Expr_237_list.get(0);
		Assert.assertNotNull(PrimaryExpression_238_Var
		);
		//238
		final Constant2 Constant2_239_Var
		 = (Constant2)PrimaryExpression_238_Var
		.getConst();
		Assert.assertNotNull(Constant2_239_Var
		);
		Assert.assertEquals("1", Constant2_239_Var
		.getDec());
		//239
		final Enumerator Enumerator_240_Var
		 = (Enumerator)Enumerator_221_list.get(1);
		Assert.assertNotNull(Enumerator_240_Var
		);
		Assert.assertEquals("M_TUESDAY", Enumerator_240_Var
		.getId());
		//240
		final Enumerator Enumerator_241_Var
		 = (Enumerator)Enumerator_221_list.get(2);
		Assert.assertNotNull(Enumerator_241_Var
		);
		Assert.assertEquals("M_WEDNESDAY", Enumerator_241_Var
		.getId());
		//241
		final Enumerator Enumerator_242_Var
		 = (Enumerator)Enumerator_221_list.get(3);
		Assert.assertNotNull(Enumerator_242_Var
		);
		Assert.assertEquals("M_THURSDAY", Enumerator_242_Var
		.getId());
		//242
		final Enumerator Enumerator_243_Var
		 = (Enumerator)Enumerator_221_list.get(4);
		Assert.assertNotNull(Enumerator_243_Var
		);
		Assert.assertEquals("M_FRIDAY", Enumerator_243_Var
		.getId());
		//243
		final Enumerator Enumerator_244_Var
		 = (Enumerator)Enumerator_221_list.get(5);
		Assert.assertNotNull(Enumerator_244_Var
		);
		Assert.assertEquals("M_SATURDAY", Enumerator_244_Var
		.getId());
		//244
		final Enumerator Enumerator_245_Var
		 = (Enumerator)Enumerator_221_list.get(6);
		Assert.assertNotNull(Enumerator_245_Var
		);
		Assert.assertEquals("M_SUNDAY", Enumerator_245_Var
		.getId());
		//245
		final ExternalDeclaration ExternalDeclaration_246_Var
		 = (ExternalDeclaration)External_2_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_246_Var
		);
		//246
		final Declaration Declaration_247_Var
		 = (Declaration)ExternalDeclaration_246_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_247_Var
		);
		//247
		final DeclarationSpecifiers DeclarationSpecifiers_248_Var
		 = (DeclarationSpecifiers)Declaration_247_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_248_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_248_list = DeclarationSpecifiers_248_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_248_list);
		Assert.assertEquals(1, DeclarationSpecifier_248_list.size());
		//248
		final TypeSpecifier TypeSpecifier_249_Var
		 = (TypeSpecifier)DeclarationSpecifier_248_list.get(0);
		Assert.assertNotNull(TypeSpecifier_249_Var
		);
		//249
		final EnumSpecifier EnumSpecifier_250_Var
		 = (EnumSpecifier)TypeSpecifier_249_Var
		.getSpecifier();
		Assert.assertNotNull(EnumSpecifier_250_Var
		);
		Assert.assertEquals("weekdays", EnumSpecifier_250_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_250_list = Declaration_247_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_250_list);
		Assert.assertEquals(1, InitDeclaratorList_250_list.size());
		//250
		final InitDeclaratorList InitDeclaratorList_251_Var
		 = (InitDeclaratorList)InitDeclaratorList_250_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_251_Var
		);
		final EList<? extends EObject> InitDeclarator_251_list = InitDeclaratorList_251_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_251_list);
		Assert.assertEquals(1, InitDeclarator_251_list.size());
		//251
		final InitDeclarator InitDeclarator_252_Var
		 = (InitDeclarator)InitDeclarator_251_list.get(0);
		Assert.assertNotNull(InitDeclarator_252_Var
		);
		//252
		final Declarator Declarator_253_Var
		 = (Declarator)InitDeclarator_252_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_253_Var
		);
		//253
		final DirectDeclarator DirectDeclarator_254_Var
		 = (DirectDeclarator)Declarator_253_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_254_Var
		);
		Assert.assertEquals("my_weekday", DirectDeclarator_254_Var
		.getId());
		//254
		final Initializer Initializer_255_Var
		 = (Initializer)InitDeclarator_252_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_255_Var
		);
		//255
		final AssignmentExpression AssignmentExpression_256_Var
		 = (AssignmentExpression)Initializer_255_Var
		.getExpr();
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
		Assert.assertEquals("M_FRIDAY", PrimaryExpression_271_Var
		.getId());
		//271
		final ExternalDeclaration ExternalDeclaration_272_Var
		 = (ExternalDeclaration)External_2_list.get(5);
		Assert.assertNotNull(ExternalDeclaration_272_Var
		);
		//272
		final FunctionDefHead FunctionDefHead_273_Var
		 = (FunctionDefHead)ExternalDeclaration_272_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_273_Var
		);
		//273
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_274_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_273_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_274_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_274_list = FunctionDeclarationSpecifiers_274_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_274_list);
		Assert.assertEquals(1, DeclarationSpecifier_274_list.size());
		//274
		final TypeSpecifier TypeSpecifier_275_Var
		 = (TypeSpecifier)DeclarationSpecifier_274_list.get(0);
		Assert.assertNotNull(TypeSpecifier_275_Var
		);
		Assert.assertEquals("int", TypeSpecifier_275_Var
		.getName());
		//275
		final Declarator Declarator_276_Var
		 = (Declarator)FunctionDefHead_273_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_276_Var
		);
		//276
		final DirectDeclarator DirectDeclarator_277_Var
		 = (DirectDeclarator)Declarator_276_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_277_Var
		);
		Assert.assertEquals("main", DirectDeclarator_277_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_277_list = DirectDeclarator_277_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_277_list);
		Assert.assertEquals(1, DeclaratorSuffix_277_list.size());
		//277
		final DeclaratorSuffix DeclaratorSuffix_278_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_277_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_278_Var
		);
		//278
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_279_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_278_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_279_Var
		);
		final EList<? extends EObject> ParameterTypeList_279_list = DirectDeclaratorLastSuffix_279_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_279_list);
		Assert.assertEquals(1, ParameterTypeList_279_list.size());
		//279
		final ParameterTypeList ParameterTypeList_280_Var
		 = (ParameterTypeList)ParameterTypeList_279_list.get(0);
		Assert.assertNotNull(ParameterTypeList_280_Var
		);
		//280
		final ParameterList ParameterList_281_Var
		 = (ParameterList)ParameterTypeList_280_Var
		.getList();
		Assert.assertNotNull(ParameterList_281_Var
		);
		final EList<? extends EObject> ParameterDeclaration_281_list = ParameterList_281_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_281_list);
		Assert.assertEquals(1, ParameterDeclaration_281_list.size());
		//281
		final ParameterDeclaration ParameterDeclaration_282_Var
		 = (ParameterDeclaration)ParameterDeclaration_281_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_282_Var
		);
		//282
		final DeclarationSpecifiers DeclarationSpecifiers_283_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_282_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_283_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_283_list = DeclarationSpecifiers_283_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_283_list);
		Assert.assertEquals(1, DeclarationSpecifier_283_list.size());
		//283
		final TypeSpecifier TypeSpecifier_284_Var
		 = (TypeSpecifier)DeclarationSpecifier_283_list.get(0);
		Assert.assertNotNull(TypeSpecifier_284_Var
		);
		Assert.assertEquals("void", TypeSpecifier_284_Var
		.getName());
		//284
		final FunctionDefinition FunctionDefinition_285_Var
		 = (FunctionDefinition)ExternalDeclaration_272_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_285_Var
		);
		//285
		final BodyStatement BodyStatement_286_Var
		 = (BodyStatement)FunctionDefinition_285_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_286_Var
		);
		final EList<? extends EObject> BlockList_286_list = BodyStatement_286_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_286_list);
		Assert.assertEquals(1, BlockList_286_list.size());
		//286
		final BlockList BlockList_287_Var
		 = (BlockList)BlockList_286_list.get(0);
		Assert.assertNotNull(BlockList_287_Var
		);
		final EList<? extends EObject> Statement_287_list = BlockList_287_Var
		.getStatement();
		Assert.assertNotNull(Statement_287_list);
		Assert.assertEquals(8, Statement_287_list.size());
		//287
		final Statement Statement_288_Var
		 = (Statement)Statement_287_list.get(0);
		Assert.assertNotNull(Statement_288_Var
		);
		//288
		final ExpressionStatement ExpressionStatement_289_Var
		 = (ExpressionStatement)Statement_288_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_289_Var
		);
		//289
		final Expression Expression_290_Var
		 = (Expression)ExpressionStatement_289_Var
		.getExpression();
		Assert.assertNotNull(Expression_290_Var
		);
		final EList<? extends EObject> ExprExpr_290_list = Expression_290_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_290_list);
		Assert.assertEquals(1, ExprExpr_290_list.size());
		//290
		final AssignmentExpression AssignmentExpression_291_Var
		 = (AssignmentExpression)ExprExpr_290_list.get(0);
		Assert.assertNotNull(AssignmentExpression_291_Var
		);
		//291
		final ConditionalExpression ConditionalExpression_292_Var
		 = (ConditionalExpression)AssignmentExpression_291_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_292_Var
		);
		//292
		final LogicalOrExpression LogicalOrExpression_293_Var
		 = (LogicalOrExpression)ConditionalExpression_292_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = LogicalOrExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final LogicalAndExpression LogicalAndExpression_294_Var
		 = (LogicalAndExpression)Expr_293_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_294_Var
		);
		final EList<? extends EObject> Expr_294_list = LogicalAndExpression_294_Var
		.getExpr();
		Assert.assertNotNull(Expr_294_list);
		Assert.assertEquals(1, Expr_294_list.size());
		//294
		final InclusiveOrExpression InclusiveOrExpression_295_Var
		 = (InclusiveOrExpression)Expr_294_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_295_Var
		);
		final EList<? extends EObject> Expr_295_list = InclusiveOrExpression_295_Var
		.getExpr();
		Assert.assertNotNull(Expr_295_list);
		Assert.assertEquals(1, Expr_295_list.size());
		//295
		final ExclusiveOrExpression ExclusiveOrExpression_296_Var
		 = (ExclusiveOrExpression)Expr_295_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_296_Var
		);
		final EList<? extends EObject> Expr_296_list = ExclusiveOrExpression_296_Var
		.getExpr();
		Assert.assertNotNull(Expr_296_list);
		Assert.assertEquals(1, Expr_296_list.size());
		//296
		final AndExpression AndExpression_297_Var
		 = (AndExpression)Expr_296_list.get(0);
		Assert.assertNotNull(AndExpression_297_Var
		);
		final EList<? extends EObject> Expr_297_list = AndExpression_297_Var
		.getExpr();
		Assert.assertNotNull(Expr_297_list);
		Assert.assertEquals(1, Expr_297_list.size());
		//297
		final EqualityExpression EqualityExpression_298_Var
		 = (EqualityExpression)Expr_297_list.get(0);
		Assert.assertNotNull(EqualityExpression_298_Var
		);
		final EList<? extends EObject> Expr_298_list = EqualityExpression_298_Var
		.getExpr();
		Assert.assertNotNull(Expr_298_list);
		Assert.assertEquals(1, Expr_298_list.size());
		//298
		final RelationalExpression RelationalExpression_299_Var
		 = (RelationalExpression)Expr_298_list.get(0);
		Assert.assertNotNull(RelationalExpression_299_Var
		);
		final EList<? extends EObject> Expr_299_list = RelationalExpression_299_Var
		.getExpr();
		Assert.assertNotNull(Expr_299_list);
		Assert.assertEquals(1, Expr_299_list.size());
		//299
		final ShiftExpression ShiftExpression_300_Var
		 = (ShiftExpression)Expr_299_list.get(0);
		Assert.assertNotNull(ShiftExpression_300_Var
		);
		final EList<? extends EObject> Expr_300_list = ShiftExpression_300_Var
		.getExpr();
		Assert.assertNotNull(Expr_300_list);
		Assert.assertEquals(1, Expr_300_list.size());
		//300
		final AdditiveExpression AdditiveExpression_301_Var
		 = (AdditiveExpression)Expr_300_list.get(0);
		Assert.assertNotNull(AdditiveExpression_301_Var
		);
		final EList<? extends EObject> Expr_301_list = AdditiveExpression_301_Var
		.getExpr();
		Assert.assertNotNull(Expr_301_list);
		Assert.assertEquals(1, Expr_301_list.size());
		//301
		final MultiplicativeExpression MultiplicativeExpression_302_Var
		 = (MultiplicativeExpression)Expr_301_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_302_Var
		);
		final EList<? extends EObject> Expr_302_list = MultiplicativeExpression_302_Var
		.getExpr();
		Assert.assertNotNull(Expr_302_list);
		Assert.assertEquals(1, Expr_302_list.size());
		//302
		final CastExpression CastExpression_303_Var
		 = (CastExpression)Expr_302_list.get(0);
		Assert.assertNotNull(CastExpression_303_Var
		);
		//303
		final UnaryExpression UnaryExpression_304_Var
		 = (UnaryExpression)CastExpression_303_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_304_Var
		);
		//304
		final PostfixExpression PostfixExpression_305_Var
		 = (PostfixExpression)UnaryExpression_304_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_305_Var
		);
		final EList<? extends EObject> Expr_305_list = PostfixExpression_305_Var
		.getExpr();
		Assert.assertNotNull(Expr_305_list);
		Assert.assertEquals(1, Expr_305_list.size());
		//305
		final PrimaryExpression PrimaryExpression_306_Var
		 = (PrimaryExpression)Expr_305_list.get(0);
		Assert.assertNotNull(PrimaryExpression_306_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_306_Var
		.getId());
		final EList<? extends EObject> Suffix_306_list = PostfixExpression_305_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_306_list);
		Assert.assertEquals(1, Suffix_306_list.size());
		//306
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_307_Var
		 = (PostfixExpressionSuffixArgument)Suffix_306_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_307_Var
		);
		//307
		final ArgumentExpressionList ArgumentExpressionList_308_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_307_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_308_Var
		);
		final EList<? extends EObject> Expr_308_list = ArgumentExpressionList_308_Var
		.getExpr();
		Assert.assertNotNull(Expr_308_list);
		Assert.assertEquals(2, Expr_308_list.size());
		//308
		final AssignmentExpression AssignmentExpression_309_Var
		 = (AssignmentExpression)Expr_308_list.get(0);
		Assert.assertNotNull(AssignmentExpression_309_Var
		);
		//309
		final ConditionalExpression ConditionalExpression_310_Var
		 = (ConditionalExpression)AssignmentExpression_309_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_310_Var
		);
		//310
		final LogicalOrExpression LogicalOrExpression_311_Var
		 = (LogicalOrExpression)ConditionalExpression_310_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = LogicalOrExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final LogicalAndExpression LogicalAndExpression_312_Var
		 = (LogicalAndExpression)Expr_311_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = LogicalAndExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final InclusiveOrExpression InclusiveOrExpression_313_Var
		 = (InclusiveOrExpression)Expr_312_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_313_Var
		);
		final EList<? extends EObject> Expr_313_list = InclusiveOrExpression_313_Var
		.getExpr();
		Assert.assertNotNull(Expr_313_list);
		Assert.assertEquals(1, Expr_313_list.size());
		//313
		final ExclusiveOrExpression ExclusiveOrExpression_314_Var
		 = (ExclusiveOrExpression)Expr_313_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = ExclusiveOrExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final AndExpression AndExpression_315_Var
		 = (AndExpression)Expr_314_list.get(0);
		Assert.assertNotNull(AndExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = AndExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final EqualityExpression EqualityExpression_316_Var
		 = (EqualityExpression)Expr_315_list.get(0);
		Assert.assertNotNull(EqualityExpression_316_Var
		);
		final EList<? extends EObject> Expr_316_list = EqualityExpression_316_Var
		.getExpr();
		Assert.assertNotNull(Expr_316_list);
		Assert.assertEquals(1, Expr_316_list.size());
		//316
		final RelationalExpression RelationalExpression_317_Var
		 = (RelationalExpression)Expr_316_list.get(0);
		Assert.assertNotNull(RelationalExpression_317_Var
		);
		final EList<? extends EObject> Expr_317_list = RelationalExpression_317_Var
		.getExpr();
		Assert.assertNotNull(Expr_317_list);
		Assert.assertEquals(1, Expr_317_list.size());
		//317
		final ShiftExpression ShiftExpression_318_Var
		 = (ShiftExpression)Expr_317_list.get(0);
		Assert.assertNotNull(ShiftExpression_318_Var
		);
		final EList<? extends EObject> Expr_318_list = ShiftExpression_318_Var
		.getExpr();
		Assert.assertNotNull(Expr_318_list);
		Assert.assertEquals(1, Expr_318_list.size());
		//318
		final AdditiveExpression AdditiveExpression_319_Var
		 = (AdditiveExpression)Expr_318_list.get(0);
		Assert.assertNotNull(AdditiveExpression_319_Var
		);
		final EList<? extends EObject> Expr_319_list = AdditiveExpression_319_Var
		.getExpr();
		Assert.assertNotNull(Expr_319_list);
		Assert.assertEquals(1, Expr_319_list.size());
		//319
		final MultiplicativeExpression MultiplicativeExpression_320_Var
		 = (MultiplicativeExpression)Expr_319_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_320_Var
		);
		final EList<? extends EObject> Expr_320_list = MultiplicativeExpression_320_Var
		.getExpr();
		Assert.assertNotNull(Expr_320_list);
		Assert.assertEquals(1, Expr_320_list.size());
		//320
		final CastExpression CastExpression_321_Var
		 = (CastExpression)Expr_320_list.get(0);
		Assert.assertNotNull(CastExpression_321_Var
		);
		//321
		final UnaryExpression UnaryExpression_322_Var
		 = (UnaryExpression)CastExpression_321_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_322_Var
		);
		//322
		final PostfixExpression PostfixExpression_323_Var
		 = (PostfixExpression)UnaryExpression_322_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_323_Var
		);
		final EList<? extends EObject> Expr_323_list = PostfixExpression_323_Var
		.getExpr();
		Assert.assertNotNull(Expr_323_list);
		Assert.assertEquals(1, Expr_323_list.size());
		//323
		final PrimaryExpression PrimaryExpression_324_Var
		 = (PrimaryExpression)Expr_323_list.get(0);
		Assert.assertNotNull(PrimaryExpression_324_Var
		);
		//324
		final Constant2 Constant2_325_Var
		 = (Constant2)PrimaryExpression_324_Var
		.getConst();
		Assert.assertNotNull(Constant2_325_Var
		);
		Assert.assertEquals("\"Monday is %d. day of week\\n\"", Constant2_325_Var
		.getStr());
		//325
		final AssignmentExpression AssignmentExpression_326_Var
		 = (AssignmentExpression)Expr_308_list.get(1);
		Assert.assertNotNull(AssignmentExpression_326_Var
		);
		//326
		final ConditionalExpression ConditionalExpression_327_Var
		 = (ConditionalExpression)AssignmentExpression_326_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_327_Var
		);
		//327
		final LogicalOrExpression LogicalOrExpression_328_Var
		 = (LogicalOrExpression)ConditionalExpression_327_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_328_Var
		);
		final EList<? extends EObject> Expr_328_list = LogicalOrExpression_328_Var
		.getExpr();
		Assert.assertNotNull(Expr_328_list);
		Assert.assertEquals(1, Expr_328_list.size());
		//328
		final LogicalAndExpression LogicalAndExpression_329_Var
		 = (LogicalAndExpression)Expr_328_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_329_Var
		);
		final EList<? extends EObject> Expr_329_list = LogicalAndExpression_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final InclusiveOrExpression InclusiveOrExpression_330_Var
		 = (InclusiveOrExpression)Expr_329_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_330_Var
		);
		final EList<? extends EObject> Expr_330_list = InclusiveOrExpression_330_Var
		.getExpr();
		Assert.assertNotNull(Expr_330_list);
		Assert.assertEquals(1, Expr_330_list.size());
		//330
		final ExclusiveOrExpression ExclusiveOrExpression_331_Var
		 = (ExclusiveOrExpression)Expr_330_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = ExclusiveOrExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final AndExpression AndExpression_332_Var
		 = (AndExpression)Expr_331_list.get(0);
		Assert.assertNotNull(AndExpression_332_Var
		);
		final EList<? extends EObject> Expr_332_list = AndExpression_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final EqualityExpression EqualityExpression_333_Var
		 = (EqualityExpression)Expr_332_list.get(0);
		Assert.assertNotNull(EqualityExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = EqualityExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final RelationalExpression RelationalExpression_334_Var
		 = (RelationalExpression)Expr_333_list.get(0);
		Assert.assertNotNull(RelationalExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = RelationalExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final ShiftExpression ShiftExpression_335_Var
		 = (ShiftExpression)Expr_334_list.get(0);
		Assert.assertNotNull(ShiftExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = ShiftExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final AdditiveExpression AdditiveExpression_336_Var
		 = (AdditiveExpression)Expr_335_list.get(0);
		Assert.assertNotNull(AdditiveExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = AdditiveExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final MultiplicativeExpression MultiplicativeExpression_337_Var
		 = (MultiplicativeExpression)Expr_336_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_337_Var
		);
		final EList<? extends EObject> Expr_337_list = MultiplicativeExpression_337_Var
		.getExpr();
		Assert.assertNotNull(Expr_337_list);
		Assert.assertEquals(1, Expr_337_list.size());
		//337
		final CastExpression CastExpression_338_Var
		 = (CastExpression)Expr_337_list.get(0);
		Assert.assertNotNull(CastExpression_338_Var
		);
		//338
		final UnaryExpression UnaryExpression_339_Var
		 = (UnaryExpression)CastExpression_338_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_339_Var
		);
		//339
		final PostfixExpression PostfixExpression_340_Var
		 = (PostfixExpression)UnaryExpression_339_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_340_Var
		);
		final EList<? extends EObject> Expr_340_list = PostfixExpression_340_Var
		.getExpr();
		Assert.assertNotNull(Expr_340_list);
		Assert.assertEquals(1, Expr_340_list.size());
		//340
		final PrimaryExpression PrimaryExpression_341_Var
		 = (PrimaryExpression)Expr_340_list.get(0);
		Assert.assertNotNull(PrimaryExpression_341_Var
		);
		Assert.assertEquals("W_MONDAY", PrimaryExpression_341_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_289_Var
		.getSemi());
		//341
		final Statement Statement_342_Var
		 = (Statement)Statement_287_list.get(1);
		Assert.assertNotNull(Statement_342_Var
		);
		//342
		final ExpressionStatement ExpressionStatement_343_Var
		 = (ExpressionStatement)Statement_342_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_343_Var
		);
		//343
		final Expression Expression_344_Var
		 = (Expression)ExpressionStatement_343_Var
		.getExpression();
		Assert.assertNotNull(Expression_344_Var
		);
		final EList<? extends EObject> ExprExpr_344_list = Expression_344_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_344_list);
		Assert.assertEquals(1, ExprExpr_344_list.size());
		//344
		final AssignmentExpression AssignmentExpression_345_Var
		 = (AssignmentExpression)ExprExpr_344_list.get(0);
		Assert.assertNotNull(AssignmentExpression_345_Var
		);
		//345
		final ConditionalExpression ConditionalExpression_346_Var
		 = (ConditionalExpression)AssignmentExpression_345_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_346_Var
		);
		//346
		final LogicalOrExpression LogicalOrExpression_347_Var
		 = (LogicalOrExpression)ConditionalExpression_346_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_347_Var
		);
		final EList<? extends EObject> Expr_347_list = LogicalOrExpression_347_Var
		.getExpr();
		Assert.assertNotNull(Expr_347_list);
		Assert.assertEquals(1, Expr_347_list.size());
		//347
		final LogicalAndExpression LogicalAndExpression_348_Var
		 = (LogicalAndExpression)Expr_347_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_348_Var
		);
		final EList<? extends EObject> Expr_348_list = LogicalAndExpression_348_Var
		.getExpr();
		Assert.assertNotNull(Expr_348_list);
		Assert.assertEquals(1, Expr_348_list.size());
		//348
		final InclusiveOrExpression InclusiveOrExpression_349_Var
		 = (InclusiveOrExpression)Expr_348_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_349_Var
		);
		final EList<? extends EObject> Expr_349_list = InclusiveOrExpression_349_Var
		.getExpr();
		Assert.assertNotNull(Expr_349_list);
		Assert.assertEquals(1, Expr_349_list.size());
		//349
		final ExclusiveOrExpression ExclusiveOrExpression_350_Var
		 = (ExclusiveOrExpression)Expr_349_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_350_Var
		);
		final EList<? extends EObject> Expr_350_list = ExclusiveOrExpression_350_Var
		.getExpr();
		Assert.assertNotNull(Expr_350_list);
		Assert.assertEquals(1, Expr_350_list.size());
		//350
		final AndExpression AndExpression_351_Var
		 = (AndExpression)Expr_350_list.get(0);
		Assert.assertNotNull(AndExpression_351_Var
		);
		final EList<? extends EObject> Expr_351_list = AndExpression_351_Var
		.getExpr();
		Assert.assertNotNull(Expr_351_list);
		Assert.assertEquals(1, Expr_351_list.size());
		//351
		final EqualityExpression EqualityExpression_352_Var
		 = (EqualityExpression)Expr_351_list.get(0);
		Assert.assertNotNull(EqualityExpression_352_Var
		);
		final EList<? extends EObject> Expr_352_list = EqualityExpression_352_Var
		.getExpr();
		Assert.assertNotNull(Expr_352_list);
		Assert.assertEquals(1, Expr_352_list.size());
		//352
		final RelationalExpression RelationalExpression_353_Var
		 = (RelationalExpression)Expr_352_list.get(0);
		Assert.assertNotNull(RelationalExpression_353_Var
		);
		final EList<? extends EObject> Expr_353_list = RelationalExpression_353_Var
		.getExpr();
		Assert.assertNotNull(Expr_353_list);
		Assert.assertEquals(1, Expr_353_list.size());
		//353
		final ShiftExpression ShiftExpression_354_Var
		 = (ShiftExpression)Expr_353_list.get(0);
		Assert.assertNotNull(ShiftExpression_354_Var
		);
		final EList<? extends EObject> Expr_354_list = ShiftExpression_354_Var
		.getExpr();
		Assert.assertNotNull(Expr_354_list);
		Assert.assertEquals(1, Expr_354_list.size());
		//354
		final AdditiveExpression AdditiveExpression_355_Var
		 = (AdditiveExpression)Expr_354_list.get(0);
		Assert.assertNotNull(AdditiveExpression_355_Var
		);
		final EList<? extends EObject> Expr_355_list = AdditiveExpression_355_Var
		.getExpr();
		Assert.assertNotNull(Expr_355_list);
		Assert.assertEquals(1, Expr_355_list.size());
		//355
		final MultiplicativeExpression MultiplicativeExpression_356_Var
		 = (MultiplicativeExpression)Expr_355_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_356_Var
		);
		final EList<? extends EObject> Expr_356_list = MultiplicativeExpression_356_Var
		.getExpr();
		Assert.assertNotNull(Expr_356_list);
		Assert.assertEquals(1, Expr_356_list.size());
		//356
		final CastExpression CastExpression_357_Var
		 = (CastExpression)Expr_356_list.get(0);
		Assert.assertNotNull(CastExpression_357_Var
		);
		//357
		final UnaryExpression UnaryExpression_358_Var
		 = (UnaryExpression)CastExpression_357_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_358_Var
		);
		//358
		final PostfixExpression PostfixExpression_359_Var
		 = (PostfixExpression)UnaryExpression_358_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_359_Var
		);
		final EList<? extends EObject> Expr_359_list = PostfixExpression_359_Var
		.getExpr();
		Assert.assertNotNull(Expr_359_list);
		Assert.assertEquals(1, Expr_359_list.size());
		//359
		final PrimaryExpression PrimaryExpression_360_Var
		 = (PrimaryExpression)Expr_359_list.get(0);
		Assert.assertNotNull(PrimaryExpression_360_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_360_Var
		.getId());
		final EList<? extends EObject> Suffix_360_list = PostfixExpression_359_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_360_list);
		Assert.assertEquals(1, Suffix_360_list.size());
		//360
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_361_Var
		 = (PostfixExpressionSuffixArgument)Suffix_360_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_361_Var
		);
		//361
		final ArgumentExpressionList ArgumentExpressionList_362_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_361_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_362_Var
		);
		final EList<? extends EObject> Expr_362_list = ArgumentExpressionList_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(2, Expr_362_list.size());
		//362
		final AssignmentExpression AssignmentExpression_363_Var
		 = (AssignmentExpression)Expr_362_list.get(0);
		Assert.assertNotNull(AssignmentExpression_363_Var
		);
		//363
		final ConditionalExpression ConditionalExpression_364_Var
		 = (ConditionalExpression)AssignmentExpression_363_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_364_Var
		);
		//364
		final LogicalOrExpression LogicalOrExpression_365_Var
		 = (LogicalOrExpression)ConditionalExpression_364_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = LogicalOrExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final LogicalAndExpression LogicalAndExpression_366_Var
		 = (LogicalAndExpression)Expr_365_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_366_Var
		);
		final EList<? extends EObject> Expr_366_list = LogicalAndExpression_366_Var
		.getExpr();
		Assert.assertNotNull(Expr_366_list);
		Assert.assertEquals(1, Expr_366_list.size());
		//366
		final InclusiveOrExpression InclusiveOrExpression_367_Var
		 = (InclusiveOrExpression)Expr_366_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_367_Var
		);
		final EList<? extends EObject> Expr_367_list = InclusiveOrExpression_367_Var
		.getExpr();
		Assert.assertNotNull(Expr_367_list);
		Assert.assertEquals(1, Expr_367_list.size());
		//367
		final ExclusiveOrExpression ExclusiveOrExpression_368_Var
		 = (ExclusiveOrExpression)Expr_367_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_368_Var
		);
		final EList<? extends EObject> Expr_368_list = ExclusiveOrExpression_368_Var
		.getExpr();
		Assert.assertNotNull(Expr_368_list);
		Assert.assertEquals(1, Expr_368_list.size());
		//368
		final AndExpression AndExpression_369_Var
		 = (AndExpression)Expr_368_list.get(0);
		Assert.assertNotNull(AndExpression_369_Var
		);
		final EList<? extends EObject> Expr_369_list = AndExpression_369_Var
		.getExpr();
		Assert.assertNotNull(Expr_369_list);
		Assert.assertEquals(1, Expr_369_list.size());
		//369
		final EqualityExpression EqualityExpression_370_Var
		 = (EqualityExpression)Expr_369_list.get(0);
		Assert.assertNotNull(EqualityExpression_370_Var
		);
		final EList<? extends EObject> Expr_370_list = EqualityExpression_370_Var
		.getExpr();
		Assert.assertNotNull(Expr_370_list);
		Assert.assertEquals(1, Expr_370_list.size());
		//370
		final RelationalExpression RelationalExpression_371_Var
		 = (RelationalExpression)Expr_370_list.get(0);
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
		//378
		final Constant2 Constant2_379_Var
		 = (Constant2)PrimaryExpression_378_Var
		.getConst();
		Assert.assertNotNull(Constant2_379_Var
		);
		Assert.assertEquals("\"Monday is %d. day of week\\n\"", Constant2_379_Var
		.getStr());
		//379
		final AssignmentExpression AssignmentExpression_380_Var
		 = (AssignmentExpression)Expr_362_list.get(1);
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
		Assert.assertEquals("MONDAY", PrimaryExpression_395_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_343_Var
		.getSemi());
		//395
		final Statement Statement_396_Var
		 = (Statement)Statement_287_list.get(2);
		Assert.assertNotNull(Statement_396_Var
		);
		//396
		final ExpressionStatement ExpressionStatement_397_Var
		 = (ExpressionStatement)Statement_396_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_397_Var
		);
		//397
		final Expression Expression_398_Var
		 = (Expression)ExpressionStatement_397_Var
		.getExpression();
		Assert.assertNotNull(Expression_398_Var
		);
		final EList<? extends EObject> ExprExpr_398_list = Expression_398_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_398_list);
		Assert.assertEquals(1, ExprExpr_398_list.size());
		//398
		final AssignmentExpression AssignmentExpression_399_Var
		 = (AssignmentExpression)ExprExpr_398_list.get(0);
		Assert.assertNotNull(AssignmentExpression_399_Var
		);
		//399
		final ConditionalExpression ConditionalExpression_400_Var
		 = (ConditionalExpression)AssignmentExpression_399_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_400_Var
		);
		//400
		final LogicalOrExpression LogicalOrExpression_401_Var
		 = (LogicalOrExpression)ConditionalExpression_400_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_401_Var
		);
		final EList<? extends EObject> Expr_401_list = LogicalOrExpression_401_Var
		.getExpr();
		Assert.assertNotNull(Expr_401_list);
		Assert.assertEquals(1, Expr_401_list.size());
		//401
		final LogicalAndExpression LogicalAndExpression_402_Var
		 = (LogicalAndExpression)Expr_401_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_402_Var
		);
		final EList<? extends EObject> Expr_402_list = LogicalAndExpression_402_Var
		.getExpr();
		Assert.assertNotNull(Expr_402_list);
		Assert.assertEquals(1, Expr_402_list.size());
		//402
		final InclusiveOrExpression InclusiveOrExpression_403_Var
		 = (InclusiveOrExpression)Expr_402_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_403_Var
		);
		final EList<? extends EObject> Expr_403_list = InclusiveOrExpression_403_Var
		.getExpr();
		Assert.assertNotNull(Expr_403_list);
		Assert.assertEquals(1, Expr_403_list.size());
		//403
		final ExclusiveOrExpression ExclusiveOrExpression_404_Var
		 = (ExclusiveOrExpression)Expr_403_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_404_Var
		);
		final EList<? extends EObject> Expr_404_list = ExclusiveOrExpression_404_Var
		.getExpr();
		Assert.assertNotNull(Expr_404_list);
		Assert.assertEquals(1, Expr_404_list.size());
		//404
		final AndExpression AndExpression_405_Var
		 = (AndExpression)Expr_404_list.get(0);
		Assert.assertNotNull(AndExpression_405_Var
		);
		final EList<? extends EObject> Expr_405_list = AndExpression_405_Var
		.getExpr();
		Assert.assertNotNull(Expr_405_list);
		Assert.assertEquals(1, Expr_405_list.size());
		//405
		final EqualityExpression EqualityExpression_406_Var
		 = (EqualityExpression)Expr_405_list.get(0);
		Assert.assertNotNull(EqualityExpression_406_Var
		);
		final EList<? extends EObject> Expr_406_list = EqualityExpression_406_Var
		.getExpr();
		Assert.assertNotNull(Expr_406_list);
		Assert.assertEquals(1, Expr_406_list.size());
		//406
		final RelationalExpression RelationalExpression_407_Var
		 = (RelationalExpression)Expr_406_list.get(0);
		Assert.assertNotNull(RelationalExpression_407_Var
		);
		final EList<? extends EObject> Expr_407_list = RelationalExpression_407_Var
		.getExpr();
		Assert.assertNotNull(Expr_407_list);
		Assert.assertEquals(1, Expr_407_list.size());
		//407
		final ShiftExpression ShiftExpression_408_Var
		 = (ShiftExpression)Expr_407_list.get(0);
		Assert.assertNotNull(ShiftExpression_408_Var
		);
		final EList<? extends EObject> Expr_408_list = ShiftExpression_408_Var
		.getExpr();
		Assert.assertNotNull(Expr_408_list);
		Assert.assertEquals(1, Expr_408_list.size());
		//408
		final AdditiveExpression AdditiveExpression_409_Var
		 = (AdditiveExpression)Expr_408_list.get(0);
		Assert.assertNotNull(AdditiveExpression_409_Var
		);
		final EList<? extends EObject> Expr_409_list = AdditiveExpression_409_Var
		.getExpr();
		Assert.assertNotNull(Expr_409_list);
		Assert.assertEquals(1, Expr_409_list.size());
		//409
		final MultiplicativeExpression MultiplicativeExpression_410_Var
		 = (MultiplicativeExpression)Expr_409_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_410_Var
		);
		final EList<? extends EObject> Expr_410_list = MultiplicativeExpression_410_Var
		.getExpr();
		Assert.assertNotNull(Expr_410_list);
		Assert.assertEquals(1, Expr_410_list.size());
		//410
		final CastExpression CastExpression_411_Var
		 = (CastExpression)Expr_410_list.get(0);
		Assert.assertNotNull(CastExpression_411_Var
		);
		//411
		final UnaryExpression UnaryExpression_412_Var
		 = (UnaryExpression)CastExpression_411_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_412_Var
		);
		//412
		final PostfixExpression PostfixExpression_413_Var
		 = (PostfixExpression)UnaryExpression_412_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_413_Var
		);
		final EList<? extends EObject> Expr_413_list = PostfixExpression_413_Var
		.getExpr();
		Assert.assertNotNull(Expr_413_list);
		Assert.assertEquals(1, Expr_413_list.size());
		//413
		final PrimaryExpression PrimaryExpression_414_Var
		 = (PrimaryExpression)Expr_413_list.get(0);
		Assert.assertNotNull(PrimaryExpression_414_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_414_Var
		.getId());
		final EList<? extends EObject> Suffix_414_list = PostfixExpression_413_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_414_list);
		Assert.assertEquals(1, Suffix_414_list.size());
		//414
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_415_Var
		 = (PostfixExpressionSuffixArgument)Suffix_414_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_415_Var
		);
		//415
		final ArgumentExpressionList ArgumentExpressionList_416_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_415_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_416_Var
		);
		final EList<? extends EObject> Expr_416_list = ArgumentExpressionList_416_Var
		.getExpr();
		Assert.assertNotNull(Expr_416_list);
		Assert.assertEquals(2, Expr_416_list.size());
		//416
		final AssignmentExpression AssignmentExpression_417_Var
		 = (AssignmentExpression)Expr_416_list.get(0);
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
		final PostfixExpression PostfixExpression_431_Var
		 = (PostfixExpression)UnaryExpression_430_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_431_Var
		);
		final EList<? extends EObject> Expr_431_list = PostfixExpression_431_Var
		.getExpr();
		Assert.assertNotNull(Expr_431_list);
		Assert.assertEquals(1, Expr_431_list.size());
		//431
		final PrimaryExpression PrimaryExpression_432_Var
		 = (PrimaryExpression)Expr_431_list.get(0);
		Assert.assertNotNull(PrimaryExpression_432_Var
		);
		//432
		final Constant2 Constant2_433_Var
		 = (Constant2)PrimaryExpression_432_Var
		.getConst();
		Assert.assertNotNull(Constant2_433_Var
		);
		Assert.assertEquals("\"Sunday is %d. day of week\\n\"", Constant2_433_Var
		.getStr());
		//433
		final AssignmentExpression AssignmentExpression_434_Var
		 = (AssignmentExpression)Expr_416_list.get(1);
		Assert.assertNotNull(AssignmentExpression_434_Var
		);
		//434
		final ConditionalExpression ConditionalExpression_435_Var
		 = (ConditionalExpression)AssignmentExpression_434_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_435_Var
		);
		//435
		final LogicalOrExpression LogicalOrExpression_436_Var
		 = (LogicalOrExpression)ConditionalExpression_435_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_436_Var
		);
		final EList<? extends EObject> Expr_436_list = LogicalOrExpression_436_Var
		.getExpr();
		Assert.assertNotNull(Expr_436_list);
		Assert.assertEquals(1, Expr_436_list.size());
		//436
		final LogicalAndExpression LogicalAndExpression_437_Var
		 = (LogicalAndExpression)Expr_436_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_437_Var
		);
		final EList<? extends EObject> Expr_437_list = LogicalAndExpression_437_Var
		.getExpr();
		Assert.assertNotNull(Expr_437_list);
		Assert.assertEquals(1, Expr_437_list.size());
		//437
		final InclusiveOrExpression InclusiveOrExpression_438_Var
		 = (InclusiveOrExpression)Expr_437_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_438_Var
		);
		final EList<? extends EObject> Expr_438_list = InclusiveOrExpression_438_Var
		.getExpr();
		Assert.assertNotNull(Expr_438_list);
		Assert.assertEquals(1, Expr_438_list.size());
		//438
		final ExclusiveOrExpression ExclusiveOrExpression_439_Var
		 = (ExclusiveOrExpression)Expr_438_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_439_Var
		);
		final EList<? extends EObject> Expr_439_list = ExclusiveOrExpression_439_Var
		.getExpr();
		Assert.assertNotNull(Expr_439_list);
		Assert.assertEquals(1, Expr_439_list.size());
		//439
		final AndExpression AndExpression_440_Var
		 = (AndExpression)Expr_439_list.get(0);
		Assert.assertNotNull(AndExpression_440_Var
		);
		final EList<? extends EObject> Expr_440_list = AndExpression_440_Var
		.getExpr();
		Assert.assertNotNull(Expr_440_list);
		Assert.assertEquals(1, Expr_440_list.size());
		//440
		final EqualityExpression EqualityExpression_441_Var
		 = (EqualityExpression)Expr_440_list.get(0);
		Assert.assertNotNull(EqualityExpression_441_Var
		);
		final EList<? extends EObject> Expr_441_list = EqualityExpression_441_Var
		.getExpr();
		Assert.assertNotNull(Expr_441_list);
		Assert.assertEquals(1, Expr_441_list.size());
		//441
		final RelationalExpression RelationalExpression_442_Var
		 = (RelationalExpression)Expr_441_list.get(0);
		Assert.assertNotNull(RelationalExpression_442_Var
		);
		final EList<? extends EObject> Expr_442_list = RelationalExpression_442_Var
		.getExpr();
		Assert.assertNotNull(Expr_442_list);
		Assert.assertEquals(1, Expr_442_list.size());
		//442
		final ShiftExpression ShiftExpression_443_Var
		 = (ShiftExpression)Expr_442_list.get(0);
		Assert.assertNotNull(ShiftExpression_443_Var
		);
		final EList<? extends EObject> Expr_443_list = ShiftExpression_443_Var
		.getExpr();
		Assert.assertNotNull(Expr_443_list);
		Assert.assertEquals(1, Expr_443_list.size());
		//443
		final AdditiveExpression AdditiveExpression_444_Var
		 = (AdditiveExpression)Expr_443_list.get(0);
		Assert.assertNotNull(AdditiveExpression_444_Var
		);
		final EList<? extends EObject> Expr_444_list = AdditiveExpression_444_Var
		.getExpr();
		Assert.assertNotNull(Expr_444_list);
		Assert.assertEquals(1, Expr_444_list.size());
		//444
		final MultiplicativeExpression MultiplicativeExpression_445_Var
		 = (MultiplicativeExpression)Expr_444_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_445_Var
		);
		final EList<? extends EObject> Expr_445_list = MultiplicativeExpression_445_Var
		.getExpr();
		Assert.assertNotNull(Expr_445_list);
		Assert.assertEquals(1, Expr_445_list.size());
		//445
		final CastExpression CastExpression_446_Var
		 = (CastExpression)Expr_445_list.get(0);
		Assert.assertNotNull(CastExpression_446_Var
		);
		//446
		final UnaryExpression UnaryExpression_447_Var
		 = (UnaryExpression)CastExpression_446_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_447_Var
		);
		//447
		final PostfixExpression PostfixExpression_448_Var
		 = (PostfixExpression)UnaryExpression_447_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_448_Var
		);
		final EList<? extends EObject> Expr_448_list = PostfixExpression_448_Var
		.getExpr();
		Assert.assertNotNull(Expr_448_list);
		Assert.assertEquals(1, Expr_448_list.size());
		//448
		final PrimaryExpression PrimaryExpression_449_Var
		 = (PrimaryExpression)Expr_448_list.get(0);
		Assert.assertNotNull(PrimaryExpression_449_Var
		);
		Assert.assertEquals("W_SUNDAY", PrimaryExpression_449_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_397_Var
		.getSemi());
		//449
		final Statement Statement_450_Var
		 = (Statement)Statement_287_list.get(3);
		Assert.assertNotNull(Statement_450_Var
		);
		//450
		final ExpressionStatement ExpressionStatement_451_Var
		 = (ExpressionStatement)Statement_450_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_451_Var
		);
		//451
		final Expression Expression_452_Var
		 = (Expression)ExpressionStatement_451_Var
		.getExpression();
		Assert.assertNotNull(Expression_452_Var
		);
		final EList<? extends EObject> ExprExpr_452_list = Expression_452_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_452_list);
		Assert.assertEquals(1, ExprExpr_452_list.size());
		//452
		final AssignmentExpression AssignmentExpression_453_Var
		 = (AssignmentExpression)ExprExpr_452_list.get(0);
		Assert.assertNotNull(AssignmentExpression_453_Var
		);
		//453
		final ConditionalExpression ConditionalExpression_454_Var
		 = (ConditionalExpression)AssignmentExpression_453_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_454_Var
		);
		//454
		final LogicalOrExpression LogicalOrExpression_455_Var
		 = (LogicalOrExpression)ConditionalExpression_454_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_455_Var
		);
		final EList<? extends EObject> Expr_455_list = LogicalOrExpression_455_Var
		.getExpr();
		Assert.assertNotNull(Expr_455_list);
		Assert.assertEquals(1, Expr_455_list.size());
		//455
		final LogicalAndExpression LogicalAndExpression_456_Var
		 = (LogicalAndExpression)Expr_455_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_456_Var
		);
		final EList<? extends EObject> Expr_456_list = LogicalAndExpression_456_Var
		.getExpr();
		Assert.assertNotNull(Expr_456_list);
		Assert.assertEquals(1, Expr_456_list.size());
		//456
		final InclusiveOrExpression InclusiveOrExpression_457_Var
		 = (InclusiveOrExpression)Expr_456_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_457_Var
		);
		final EList<? extends EObject> Expr_457_list = InclusiveOrExpression_457_Var
		.getExpr();
		Assert.assertNotNull(Expr_457_list);
		Assert.assertEquals(1, Expr_457_list.size());
		//457
		final ExclusiveOrExpression ExclusiveOrExpression_458_Var
		 = (ExclusiveOrExpression)Expr_457_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_458_Var
		);
		final EList<? extends EObject> Expr_458_list = ExclusiveOrExpression_458_Var
		.getExpr();
		Assert.assertNotNull(Expr_458_list);
		Assert.assertEquals(1, Expr_458_list.size());
		//458
		final AndExpression AndExpression_459_Var
		 = (AndExpression)Expr_458_list.get(0);
		Assert.assertNotNull(AndExpression_459_Var
		);
		final EList<? extends EObject> Expr_459_list = AndExpression_459_Var
		.getExpr();
		Assert.assertNotNull(Expr_459_list);
		Assert.assertEquals(1, Expr_459_list.size());
		//459
		final EqualityExpression EqualityExpression_460_Var
		 = (EqualityExpression)Expr_459_list.get(0);
		Assert.assertNotNull(EqualityExpression_460_Var
		);
		final EList<? extends EObject> Expr_460_list = EqualityExpression_460_Var
		.getExpr();
		Assert.assertNotNull(Expr_460_list);
		Assert.assertEquals(1, Expr_460_list.size());
		//460
		final RelationalExpression RelationalExpression_461_Var
		 = (RelationalExpression)Expr_460_list.get(0);
		Assert.assertNotNull(RelationalExpression_461_Var
		);
		final EList<? extends EObject> Expr_461_list = RelationalExpression_461_Var
		.getExpr();
		Assert.assertNotNull(Expr_461_list);
		Assert.assertEquals(1, Expr_461_list.size());
		//461
		final ShiftExpression ShiftExpression_462_Var
		 = (ShiftExpression)Expr_461_list.get(0);
		Assert.assertNotNull(ShiftExpression_462_Var
		);
		final EList<? extends EObject> Expr_462_list = ShiftExpression_462_Var
		.getExpr();
		Assert.assertNotNull(Expr_462_list);
		Assert.assertEquals(1, Expr_462_list.size());
		//462
		final AdditiveExpression AdditiveExpression_463_Var
		 = (AdditiveExpression)Expr_462_list.get(0);
		Assert.assertNotNull(AdditiveExpression_463_Var
		);
		final EList<? extends EObject> Expr_463_list = AdditiveExpression_463_Var
		.getExpr();
		Assert.assertNotNull(Expr_463_list);
		Assert.assertEquals(1, Expr_463_list.size());
		//463
		final MultiplicativeExpression MultiplicativeExpression_464_Var
		 = (MultiplicativeExpression)Expr_463_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_464_Var
		);
		final EList<? extends EObject> Expr_464_list = MultiplicativeExpression_464_Var
		.getExpr();
		Assert.assertNotNull(Expr_464_list);
		Assert.assertEquals(1, Expr_464_list.size());
		//464
		final CastExpression CastExpression_465_Var
		 = (CastExpression)Expr_464_list.get(0);
		Assert.assertNotNull(CastExpression_465_Var
		);
		//465
		final UnaryExpression UnaryExpression_466_Var
		 = (UnaryExpression)CastExpression_465_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_466_Var
		);
		//466
		final PostfixExpression PostfixExpression_467_Var
		 = (PostfixExpression)UnaryExpression_466_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_467_Var
		);
		final EList<? extends EObject> Expr_467_list = PostfixExpression_467_Var
		.getExpr();
		Assert.assertNotNull(Expr_467_list);
		Assert.assertEquals(1, Expr_467_list.size());
		//467
		final PrimaryExpression PrimaryExpression_468_Var
		 = (PrimaryExpression)Expr_467_list.get(0);
		Assert.assertNotNull(PrimaryExpression_468_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_468_Var
		.getId());
		final EList<? extends EObject> Suffix_468_list = PostfixExpression_467_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_468_list);
		Assert.assertEquals(1, Suffix_468_list.size());
		//468
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_469_Var
		 = (PostfixExpressionSuffixArgument)Suffix_468_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_469_Var
		);
		//469
		final ArgumentExpressionList ArgumentExpressionList_470_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_469_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_470_Var
		);
		final EList<? extends EObject> Expr_470_list = ArgumentExpressionList_470_Var
		.getExpr();
		Assert.assertNotNull(Expr_470_list);
		Assert.assertEquals(2, Expr_470_list.size());
		//470
		final AssignmentExpression AssignmentExpression_471_Var
		 = (AssignmentExpression)Expr_470_list.get(0);
		Assert.assertNotNull(AssignmentExpression_471_Var
		);
		//471
		final ConditionalExpression ConditionalExpression_472_Var
		 = (ConditionalExpression)AssignmentExpression_471_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_472_Var
		);
		//472
		final LogicalOrExpression LogicalOrExpression_473_Var
		 = (LogicalOrExpression)ConditionalExpression_472_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_473_Var
		);
		final EList<? extends EObject> Expr_473_list = LogicalOrExpression_473_Var
		.getExpr();
		Assert.assertNotNull(Expr_473_list);
		Assert.assertEquals(1, Expr_473_list.size());
		//473
		final LogicalAndExpression LogicalAndExpression_474_Var
		 = (LogicalAndExpression)Expr_473_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_474_Var
		);
		final EList<? extends EObject> Expr_474_list = LogicalAndExpression_474_Var
		.getExpr();
		Assert.assertNotNull(Expr_474_list);
		Assert.assertEquals(1, Expr_474_list.size());
		//474
		final InclusiveOrExpression InclusiveOrExpression_475_Var
		 = (InclusiveOrExpression)Expr_474_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_475_Var
		);
		final EList<? extends EObject> Expr_475_list = InclusiveOrExpression_475_Var
		.getExpr();
		Assert.assertNotNull(Expr_475_list);
		Assert.assertEquals(1, Expr_475_list.size());
		//475
		final ExclusiveOrExpression ExclusiveOrExpression_476_Var
		 = (ExclusiveOrExpression)Expr_475_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_476_Var
		);
		final EList<? extends EObject> Expr_476_list = ExclusiveOrExpression_476_Var
		.getExpr();
		Assert.assertNotNull(Expr_476_list);
		Assert.assertEquals(1, Expr_476_list.size());
		//476
		final AndExpression AndExpression_477_Var
		 = (AndExpression)Expr_476_list.get(0);
		Assert.assertNotNull(AndExpression_477_Var
		);
		final EList<? extends EObject> Expr_477_list = AndExpression_477_Var
		.getExpr();
		Assert.assertNotNull(Expr_477_list);
		Assert.assertEquals(1, Expr_477_list.size());
		//477
		final EqualityExpression EqualityExpression_478_Var
		 = (EqualityExpression)Expr_477_list.get(0);
		Assert.assertNotNull(EqualityExpression_478_Var
		);
		final EList<? extends EObject> Expr_478_list = EqualityExpression_478_Var
		.getExpr();
		Assert.assertNotNull(Expr_478_list);
		Assert.assertEquals(1, Expr_478_list.size());
		//478
		final RelationalExpression RelationalExpression_479_Var
		 = (RelationalExpression)Expr_478_list.get(0);
		Assert.assertNotNull(RelationalExpression_479_Var
		);
		final EList<? extends EObject> Expr_479_list = RelationalExpression_479_Var
		.getExpr();
		Assert.assertNotNull(Expr_479_list);
		Assert.assertEquals(1, Expr_479_list.size());
		//479
		final ShiftExpression ShiftExpression_480_Var
		 = (ShiftExpression)Expr_479_list.get(0);
		Assert.assertNotNull(ShiftExpression_480_Var
		);
		final EList<? extends EObject> Expr_480_list = ShiftExpression_480_Var
		.getExpr();
		Assert.assertNotNull(Expr_480_list);
		Assert.assertEquals(1, Expr_480_list.size());
		//480
		final AdditiveExpression AdditiveExpression_481_Var
		 = (AdditiveExpression)Expr_480_list.get(0);
		Assert.assertNotNull(AdditiveExpression_481_Var
		);
		final EList<? extends EObject> Expr_481_list = AdditiveExpression_481_Var
		.getExpr();
		Assert.assertNotNull(Expr_481_list);
		Assert.assertEquals(1, Expr_481_list.size());
		//481
		final MultiplicativeExpression MultiplicativeExpression_482_Var
		 = (MultiplicativeExpression)Expr_481_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_482_Var
		);
		final EList<? extends EObject> Expr_482_list = MultiplicativeExpression_482_Var
		.getExpr();
		Assert.assertNotNull(Expr_482_list);
		Assert.assertEquals(1, Expr_482_list.size());
		//482
		final CastExpression CastExpression_483_Var
		 = (CastExpression)Expr_482_list.get(0);
		Assert.assertNotNull(CastExpression_483_Var
		);
		//483
		final UnaryExpression UnaryExpression_484_Var
		 = (UnaryExpression)CastExpression_483_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_484_Var
		);
		//484
		final PostfixExpression PostfixExpression_485_Var
		 = (PostfixExpression)UnaryExpression_484_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_485_Var
		);
		final EList<? extends EObject> Expr_485_list = PostfixExpression_485_Var
		.getExpr();
		Assert.assertNotNull(Expr_485_list);
		Assert.assertEquals(1, Expr_485_list.size());
		//485
		final PrimaryExpression PrimaryExpression_486_Var
		 = (PrimaryExpression)Expr_485_list.get(0);
		Assert.assertNotNull(PrimaryExpression_486_Var
		);
		//486
		final Constant2 Constant2_487_Var
		 = (Constant2)PrimaryExpression_486_Var
		.getConst();
		Assert.assertNotNull(Constant2_487_Var
		);
		Assert.assertEquals("\"Sunday is %d. day of week\\n\"", Constant2_487_Var
		.getStr());
		//487
		final AssignmentExpression AssignmentExpression_488_Var
		 = (AssignmentExpression)Expr_470_list.get(1);
		Assert.assertNotNull(AssignmentExpression_488_Var
		);
		//488
		final ConditionalExpression ConditionalExpression_489_Var
		 = (ConditionalExpression)AssignmentExpression_488_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_489_Var
		);
		//489
		final LogicalOrExpression LogicalOrExpression_490_Var
		 = (LogicalOrExpression)ConditionalExpression_489_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_490_Var
		);
		final EList<? extends EObject> Expr_490_list = LogicalOrExpression_490_Var
		.getExpr();
		Assert.assertNotNull(Expr_490_list);
		Assert.assertEquals(1, Expr_490_list.size());
		//490
		final LogicalAndExpression LogicalAndExpression_491_Var
		 = (LogicalAndExpression)Expr_490_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_491_Var
		);
		final EList<? extends EObject> Expr_491_list = LogicalAndExpression_491_Var
		.getExpr();
		Assert.assertNotNull(Expr_491_list);
		Assert.assertEquals(1, Expr_491_list.size());
		//491
		final InclusiveOrExpression InclusiveOrExpression_492_Var
		 = (InclusiveOrExpression)Expr_491_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_492_Var
		);
		final EList<? extends EObject> Expr_492_list = InclusiveOrExpression_492_Var
		.getExpr();
		Assert.assertNotNull(Expr_492_list);
		Assert.assertEquals(1, Expr_492_list.size());
		//492
		final ExclusiveOrExpression ExclusiveOrExpression_493_Var
		 = (ExclusiveOrExpression)Expr_492_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_493_Var
		);
		final EList<? extends EObject> Expr_493_list = ExclusiveOrExpression_493_Var
		.getExpr();
		Assert.assertNotNull(Expr_493_list);
		Assert.assertEquals(1, Expr_493_list.size());
		//493
		final AndExpression AndExpression_494_Var
		 = (AndExpression)Expr_493_list.get(0);
		Assert.assertNotNull(AndExpression_494_Var
		);
		final EList<? extends EObject> Expr_494_list = AndExpression_494_Var
		.getExpr();
		Assert.assertNotNull(Expr_494_list);
		Assert.assertEquals(1, Expr_494_list.size());
		//494
		final EqualityExpression EqualityExpression_495_Var
		 = (EqualityExpression)Expr_494_list.get(0);
		Assert.assertNotNull(EqualityExpression_495_Var
		);
		final EList<? extends EObject> Expr_495_list = EqualityExpression_495_Var
		.getExpr();
		Assert.assertNotNull(Expr_495_list);
		Assert.assertEquals(1, Expr_495_list.size());
		//495
		final RelationalExpression RelationalExpression_496_Var
		 = (RelationalExpression)Expr_495_list.get(0);
		Assert.assertNotNull(RelationalExpression_496_Var
		);
		final EList<? extends EObject> Expr_496_list = RelationalExpression_496_Var
		.getExpr();
		Assert.assertNotNull(Expr_496_list);
		Assert.assertEquals(1, Expr_496_list.size());
		//496
		final ShiftExpression ShiftExpression_497_Var
		 = (ShiftExpression)Expr_496_list.get(0);
		Assert.assertNotNull(ShiftExpression_497_Var
		);
		final EList<? extends EObject> Expr_497_list = ShiftExpression_497_Var
		.getExpr();
		Assert.assertNotNull(Expr_497_list);
		Assert.assertEquals(1, Expr_497_list.size());
		//497
		final AdditiveExpression AdditiveExpression_498_Var
		 = (AdditiveExpression)Expr_497_list.get(0);
		Assert.assertNotNull(AdditiveExpression_498_Var
		);
		final EList<? extends EObject> Expr_498_list = AdditiveExpression_498_Var
		.getExpr();
		Assert.assertNotNull(Expr_498_list);
		Assert.assertEquals(1, Expr_498_list.size());
		//498
		final MultiplicativeExpression MultiplicativeExpression_499_Var
		 = (MultiplicativeExpression)Expr_498_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_499_Var
		);
		final EList<? extends EObject> Expr_499_list = MultiplicativeExpression_499_Var
		.getExpr();
		Assert.assertNotNull(Expr_499_list);
		Assert.assertEquals(1, Expr_499_list.size());
		//499
		final CastExpression CastExpression_500_Var
		 = (CastExpression)Expr_499_list.get(0);
		Assert.assertNotNull(CastExpression_500_Var
		);
		//500
		final UnaryExpression UnaryExpression_501_Var
		 = (UnaryExpression)CastExpression_500_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_501_Var
		);
		//501
		final PostfixExpression PostfixExpression_502_Var
		 = (PostfixExpression)UnaryExpression_501_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_502_Var
		);
		final EList<? extends EObject> Expr_502_list = PostfixExpression_502_Var
		.getExpr();
		Assert.assertNotNull(Expr_502_list);
		Assert.assertEquals(1, Expr_502_list.size());
		//502
		final PrimaryExpression PrimaryExpression_503_Var
		 = (PrimaryExpression)Expr_502_list.get(0);
		Assert.assertNotNull(PrimaryExpression_503_Var
		);
		Assert.assertEquals("SUNDAY", PrimaryExpression_503_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_451_Var
		.getSemi());
		//503
		final Statement Statement_504_Var
		 = (Statement)Statement_287_list.get(4);
		Assert.assertNotNull(Statement_504_Var
		);
		//504
		final ExpressionStatement ExpressionStatement_505_Var
		 = (ExpressionStatement)Statement_504_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_505_Var
		);
		//505
		final Expression Expression_506_Var
		 = (Expression)ExpressionStatement_505_Var
		.getExpression();
		Assert.assertNotNull(Expression_506_Var
		);
		final EList<? extends EObject> ExprExpr_506_list = Expression_506_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_506_list);
		Assert.assertEquals(1, ExprExpr_506_list.size());
		//506
		final AssignmentExpression AssignmentExpression_507_Var
		 = (AssignmentExpression)ExprExpr_506_list.get(0);
		Assert.assertNotNull(AssignmentExpression_507_Var
		);
		//507
		final UnaryExpression UnaryExpression_508_Var
		 = (UnaryExpression)AssignmentExpression_507_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_508_Var
		);
		//508
		final PostfixExpression PostfixExpression_509_Var
		 = (PostfixExpression)UnaryExpression_508_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_509_Var
		);
		final EList<? extends EObject> Expr_509_list = PostfixExpression_509_Var
		.getExpr();
		Assert.assertNotNull(Expr_509_list);
		Assert.assertEquals(1, Expr_509_list.size());
		//509
		final PrimaryExpression PrimaryExpression_510_Var
		 = (PrimaryExpression)Expr_509_list.get(0);
		Assert.assertNotNull(PrimaryExpression_510_Var
		);
		Assert.assertEquals("iAmInLove", PrimaryExpression_510_Var
		.getId());
		//510
		final AssignmentOperator AssignmentOperator_511_Var
		 = (AssignmentOperator)AssignmentExpression_507_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_511_Var
		);
		Assert.assertEquals("=", AssignmentOperator_511_Var
		.getOp());
		//511
		final AssignmentExpression AssignmentExpression_512_Var
		 = (AssignmentExpression)AssignmentExpression_507_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_512_Var
		);
		//512
		final ConditionalExpression ConditionalExpression_513_Var
		 = (ConditionalExpression)AssignmentExpression_512_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_513_Var
		);
		//513
		final LogicalOrExpression LogicalOrExpression_514_Var
		 = (LogicalOrExpression)ConditionalExpression_513_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_514_Var
		);
		final EList<? extends EObject> Expr_514_list = LogicalOrExpression_514_Var
		.getExpr();
		Assert.assertNotNull(Expr_514_list);
		Assert.assertEquals(1, Expr_514_list.size());
		//514
		final LogicalAndExpression LogicalAndExpression_515_Var
		 = (LogicalAndExpression)Expr_514_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_515_Var
		);
		final EList<? extends EObject> Expr_515_list = LogicalAndExpression_515_Var
		.getExpr();
		Assert.assertNotNull(Expr_515_list);
		Assert.assertEquals(1, Expr_515_list.size());
		//515
		final InclusiveOrExpression InclusiveOrExpression_516_Var
		 = (InclusiveOrExpression)Expr_515_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_516_Var
		);
		final EList<? extends EObject> Expr_516_list = InclusiveOrExpression_516_Var
		.getExpr();
		Assert.assertNotNull(Expr_516_list);
		Assert.assertEquals(1, Expr_516_list.size());
		//516
		final ExclusiveOrExpression ExclusiveOrExpression_517_Var
		 = (ExclusiveOrExpression)Expr_516_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_517_Var
		);
		final EList<? extends EObject> Expr_517_list = ExclusiveOrExpression_517_Var
		.getExpr();
		Assert.assertNotNull(Expr_517_list);
		Assert.assertEquals(1, Expr_517_list.size());
		//517
		final AndExpression AndExpression_518_Var
		 = (AndExpression)Expr_517_list.get(0);
		Assert.assertNotNull(AndExpression_518_Var
		);
		final EList<? extends EObject> Expr_518_list = AndExpression_518_Var
		.getExpr();
		Assert.assertNotNull(Expr_518_list);
		Assert.assertEquals(1, Expr_518_list.size());
		//518
		final EqualityExpression EqualityExpression_519_Var
		 = (EqualityExpression)Expr_518_list.get(0);
		Assert.assertNotNull(EqualityExpression_519_Var
		);
		final EList<? extends EObject> Expr_519_list = EqualityExpression_519_Var
		.getExpr();
		Assert.assertNotNull(Expr_519_list);
		Assert.assertEquals(1, Expr_519_list.size());
		//519
		final RelationalExpression RelationalExpression_520_Var
		 = (RelationalExpression)Expr_519_list.get(0);
		Assert.assertNotNull(RelationalExpression_520_Var
		);
		final EList<? extends EObject> Expr_520_list = RelationalExpression_520_Var
		.getExpr();
		Assert.assertNotNull(Expr_520_list);
		Assert.assertEquals(1, Expr_520_list.size());
		//520
		final ShiftExpression ShiftExpression_521_Var
		 = (ShiftExpression)Expr_520_list.get(0);
		Assert.assertNotNull(ShiftExpression_521_Var
		);
		final EList<? extends EObject> Expr_521_list = ShiftExpression_521_Var
		.getExpr();
		Assert.assertNotNull(Expr_521_list);
		Assert.assertEquals(1, Expr_521_list.size());
		//521
		final AdditiveExpression AdditiveExpression_522_Var
		 = (AdditiveExpression)Expr_521_list.get(0);
		Assert.assertNotNull(AdditiveExpression_522_Var
		);
		final EList<? extends EObject> Expr_522_list = AdditiveExpression_522_Var
		.getExpr();
		Assert.assertNotNull(Expr_522_list);
		Assert.assertEquals(1, Expr_522_list.size());
		//522
		final MultiplicativeExpression MultiplicativeExpression_523_Var
		 = (MultiplicativeExpression)Expr_522_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_523_Var
		);
		final EList<? extends EObject> Expr_523_list = MultiplicativeExpression_523_Var
		.getExpr();
		Assert.assertNotNull(Expr_523_list);
		Assert.assertEquals(1, Expr_523_list.size());
		//523
		final CastExpression CastExpression_524_Var
		 = (CastExpression)Expr_523_list.get(0);
		Assert.assertNotNull(CastExpression_524_Var
		);
		//524
		final UnaryExpression UnaryExpression_525_Var
		 = (UnaryExpression)CastExpression_524_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_525_Var
		);
		//525
		final PostfixExpression PostfixExpression_526_Var
		 = (PostfixExpression)UnaryExpression_525_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_526_Var
		);
		final EList<? extends EObject> Expr_526_list = PostfixExpression_526_Var
		.getExpr();
		Assert.assertNotNull(Expr_526_list);
		Assert.assertEquals(1, Expr_526_list.size());
		//526
		final PrimaryExpression PrimaryExpression_527_Var
		 = (PrimaryExpression)Expr_526_list.get(0);
		Assert.assertNotNull(PrimaryExpression_527_Var
		);
		Assert.assertEquals("I_FRIDAY", PrimaryExpression_527_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_505_Var
		.getSemi());
		//527
		final Statement Statement_528_Var
		 = (Statement)Statement_287_list.get(5);
		Assert.assertNotNull(Statement_528_Var
		);
		//528
		final ExpressionStatement ExpressionStatement_529_Var
		 = (ExpressionStatement)Statement_528_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_529_Var
		);
		//529
		final Expression Expression_530_Var
		 = (Expression)ExpressionStatement_529_Var
		.getExpression();
		Assert.assertNotNull(Expression_530_Var
		);
		final EList<? extends EObject> ExprExpr_530_list = Expression_530_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_530_list);
		Assert.assertEquals(1, ExprExpr_530_list.size());
		//530
		final AssignmentExpression AssignmentExpression_531_Var
		 = (AssignmentExpression)ExprExpr_530_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_546_Var
		.getId());
		final EList<? extends EObject> Suffix_546_list = PostfixExpression_545_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_546_list);
		Assert.assertEquals(1, Suffix_546_list.size());
		//546
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_547_Var
		 = (PostfixExpressionSuffixArgument)Suffix_546_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_547_Var
		);
		//547
		final ArgumentExpressionList ArgumentExpressionList_548_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_547_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_548_Var
		);
		final EList<? extends EObject> Expr_548_list = ArgumentExpressionList_548_Var
		.getExpr();
		Assert.assertNotNull(Expr_548_list);
		Assert.assertEquals(2, Expr_548_list.size());
		//548
		final AssignmentExpression AssignmentExpression_549_Var
		 = (AssignmentExpression)Expr_548_list.get(0);
		Assert.assertNotNull(AssignmentExpression_549_Var
		);
		//549
		final ConditionalExpression ConditionalExpression_550_Var
		 = (ConditionalExpression)AssignmentExpression_549_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_550_Var
		);
		//550
		final LogicalOrExpression LogicalOrExpression_551_Var
		 = (LogicalOrExpression)ConditionalExpression_550_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_551_Var
		);
		final EList<? extends EObject> Expr_551_list = LogicalOrExpression_551_Var
		.getExpr();
		Assert.assertNotNull(Expr_551_list);
		Assert.assertEquals(1, Expr_551_list.size());
		//551
		final LogicalAndExpression LogicalAndExpression_552_Var
		 = (LogicalAndExpression)Expr_551_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_552_Var
		);
		final EList<? extends EObject> Expr_552_list = LogicalAndExpression_552_Var
		.getExpr();
		Assert.assertNotNull(Expr_552_list);
		Assert.assertEquals(1, Expr_552_list.size());
		//552
		final InclusiveOrExpression InclusiveOrExpression_553_Var
		 = (InclusiveOrExpression)Expr_552_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_553_Var
		);
		final EList<? extends EObject> Expr_553_list = InclusiveOrExpression_553_Var
		.getExpr();
		Assert.assertNotNull(Expr_553_list);
		Assert.assertEquals(1, Expr_553_list.size());
		//553
		final ExclusiveOrExpression ExclusiveOrExpression_554_Var
		 = (ExclusiveOrExpression)Expr_553_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_554_Var
		);
		final EList<? extends EObject> Expr_554_list = ExclusiveOrExpression_554_Var
		.getExpr();
		Assert.assertNotNull(Expr_554_list);
		Assert.assertEquals(1, Expr_554_list.size());
		//554
		final AndExpression AndExpression_555_Var
		 = (AndExpression)Expr_554_list.get(0);
		Assert.assertNotNull(AndExpression_555_Var
		);
		final EList<? extends EObject> Expr_555_list = AndExpression_555_Var
		.getExpr();
		Assert.assertNotNull(Expr_555_list);
		Assert.assertEquals(1, Expr_555_list.size());
		//555
		final EqualityExpression EqualityExpression_556_Var
		 = (EqualityExpression)Expr_555_list.get(0);
		Assert.assertNotNull(EqualityExpression_556_Var
		);
		final EList<? extends EObject> Expr_556_list = EqualityExpression_556_Var
		.getExpr();
		Assert.assertNotNull(Expr_556_list);
		Assert.assertEquals(1, Expr_556_list.size());
		//556
		final RelationalExpression RelationalExpression_557_Var
		 = (RelationalExpression)Expr_556_list.get(0);
		Assert.assertNotNull(RelationalExpression_557_Var
		);
		final EList<? extends EObject> Expr_557_list = RelationalExpression_557_Var
		.getExpr();
		Assert.assertNotNull(Expr_557_list);
		Assert.assertEquals(1, Expr_557_list.size());
		//557
		final ShiftExpression ShiftExpression_558_Var
		 = (ShiftExpression)Expr_557_list.get(0);
		Assert.assertNotNull(ShiftExpression_558_Var
		);
		final EList<? extends EObject> Expr_558_list = ShiftExpression_558_Var
		.getExpr();
		Assert.assertNotNull(Expr_558_list);
		Assert.assertEquals(1, Expr_558_list.size());
		//558
		final AdditiveExpression AdditiveExpression_559_Var
		 = (AdditiveExpression)Expr_558_list.get(0);
		Assert.assertNotNull(AdditiveExpression_559_Var
		);
		final EList<? extends EObject> Expr_559_list = AdditiveExpression_559_Var
		.getExpr();
		Assert.assertNotNull(Expr_559_list);
		Assert.assertEquals(1, Expr_559_list.size());
		//559
		final MultiplicativeExpression MultiplicativeExpression_560_Var
		 = (MultiplicativeExpression)Expr_559_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_560_Var
		);
		final EList<? extends EObject> Expr_560_list = MultiplicativeExpression_560_Var
		.getExpr();
		Assert.assertNotNull(Expr_560_list);
		Assert.assertEquals(1, Expr_560_list.size());
		//560
		final CastExpression CastExpression_561_Var
		 = (CastExpression)Expr_560_list.get(0);
		Assert.assertNotNull(CastExpression_561_Var
		);
		//561
		final UnaryExpression UnaryExpression_562_Var
		 = (UnaryExpression)CastExpression_561_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_562_Var
		);
		//562
		final PostfixExpression PostfixExpression_563_Var
		 = (PostfixExpression)UnaryExpression_562_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_563_Var
		);
		final EList<? extends EObject> Expr_563_list = PostfixExpression_563_Var
		.getExpr();
		Assert.assertNotNull(Expr_563_list);
		Assert.assertEquals(1, Expr_563_list.size());
		//563
		final PrimaryExpression PrimaryExpression_564_Var
		 = (PrimaryExpression)Expr_563_list.get(0);
		Assert.assertNotNull(PrimaryExpression_564_Var
		);
		//564
		final Constant2 Constant2_565_Var
		 = (Constant2)PrimaryExpression_564_Var
		.getConst();
		Assert.assertNotNull(Constant2_565_Var
		);
		Assert.assertEquals("\"The %d. day of the week is my favourite!\\n\"", Constant2_565_Var
		.getStr());
		//565
		final AssignmentExpression AssignmentExpression_566_Var
		 = (AssignmentExpression)Expr_548_list.get(1);
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
		Assert.assertEquals("iAmInLove", PrimaryExpression_581_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_529_Var
		.getSemi());
		//581
		final Statement Statement_582_Var
		 = (Statement)Statement_287_list.get(6);
		Assert.assertNotNull(Statement_582_Var
		);
		//582
		final ExpressionStatement ExpressionStatement_583_Var
		 = (ExpressionStatement)Statement_582_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_583_Var
		);
		//583
		final Expression Expression_584_Var
		 = (Expression)ExpressionStatement_583_Var
		.getExpression();
		Assert.assertNotNull(Expression_584_Var
		);
		final EList<? extends EObject> ExprExpr_584_list = Expression_584_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_584_list);
		Assert.assertEquals(1, ExprExpr_584_list.size());
		//584
		final AssignmentExpression AssignmentExpression_585_Var
		 = (AssignmentExpression)ExprExpr_584_list.get(0);
		Assert.assertNotNull(AssignmentExpression_585_Var
		);
		//585
		final ConditionalExpression ConditionalExpression_586_Var
		 = (ConditionalExpression)AssignmentExpression_585_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_586_Var
		);
		//586
		final LogicalOrExpression LogicalOrExpression_587_Var
		 = (LogicalOrExpression)ConditionalExpression_586_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_587_Var
		);
		final EList<? extends EObject> Expr_587_list = LogicalOrExpression_587_Var
		.getExpr();
		Assert.assertNotNull(Expr_587_list);
		Assert.assertEquals(1, Expr_587_list.size());
		//587
		final LogicalAndExpression LogicalAndExpression_588_Var
		 = (LogicalAndExpression)Expr_587_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_588_Var
		);
		final EList<? extends EObject> Expr_588_list = LogicalAndExpression_588_Var
		.getExpr();
		Assert.assertNotNull(Expr_588_list);
		Assert.assertEquals(1, Expr_588_list.size());
		//588
		final InclusiveOrExpression InclusiveOrExpression_589_Var
		 = (InclusiveOrExpression)Expr_588_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_589_Var
		);
		final EList<? extends EObject> Expr_589_list = InclusiveOrExpression_589_Var
		.getExpr();
		Assert.assertNotNull(Expr_589_list);
		Assert.assertEquals(1, Expr_589_list.size());
		//589
		final ExclusiveOrExpression ExclusiveOrExpression_590_Var
		 = (ExclusiveOrExpression)Expr_589_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_590_Var
		);
		final EList<? extends EObject> Expr_590_list = ExclusiveOrExpression_590_Var
		.getExpr();
		Assert.assertNotNull(Expr_590_list);
		Assert.assertEquals(1, Expr_590_list.size());
		//590
		final AndExpression AndExpression_591_Var
		 = (AndExpression)Expr_590_list.get(0);
		Assert.assertNotNull(AndExpression_591_Var
		);
		final EList<? extends EObject> Expr_591_list = AndExpression_591_Var
		.getExpr();
		Assert.assertNotNull(Expr_591_list);
		Assert.assertEquals(1, Expr_591_list.size());
		//591
		final EqualityExpression EqualityExpression_592_Var
		 = (EqualityExpression)Expr_591_list.get(0);
		Assert.assertNotNull(EqualityExpression_592_Var
		);
		final EList<? extends EObject> Expr_592_list = EqualityExpression_592_Var
		.getExpr();
		Assert.assertNotNull(Expr_592_list);
		Assert.assertEquals(1, Expr_592_list.size());
		//592
		final RelationalExpression RelationalExpression_593_Var
		 = (RelationalExpression)Expr_592_list.get(0);
		Assert.assertNotNull(RelationalExpression_593_Var
		);
		final EList<? extends EObject> Expr_593_list = RelationalExpression_593_Var
		.getExpr();
		Assert.assertNotNull(Expr_593_list);
		Assert.assertEquals(1, Expr_593_list.size());
		//593
		final ShiftExpression ShiftExpression_594_Var
		 = (ShiftExpression)Expr_593_list.get(0);
		Assert.assertNotNull(ShiftExpression_594_Var
		);
		final EList<? extends EObject> Expr_594_list = ShiftExpression_594_Var
		.getExpr();
		Assert.assertNotNull(Expr_594_list);
		Assert.assertEquals(1, Expr_594_list.size());
		//594
		final AdditiveExpression AdditiveExpression_595_Var
		 = (AdditiveExpression)Expr_594_list.get(0);
		Assert.assertNotNull(AdditiveExpression_595_Var
		);
		final EList<? extends EObject> Expr_595_list = AdditiveExpression_595_Var
		.getExpr();
		Assert.assertNotNull(Expr_595_list);
		Assert.assertEquals(1, Expr_595_list.size());
		//595
		final MultiplicativeExpression MultiplicativeExpression_596_Var
		 = (MultiplicativeExpression)Expr_595_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_596_Var
		);
		final EList<? extends EObject> Expr_596_list = MultiplicativeExpression_596_Var
		.getExpr();
		Assert.assertNotNull(Expr_596_list);
		Assert.assertEquals(1, Expr_596_list.size());
		//596
		final CastExpression CastExpression_597_Var
		 = (CastExpression)Expr_596_list.get(0);
		Assert.assertNotNull(CastExpression_597_Var
		);
		//597
		final UnaryExpression UnaryExpression_598_Var
		 = (UnaryExpression)CastExpression_597_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_598_Var
		);
		//598
		final PostfixExpression PostfixExpression_599_Var
		 = (PostfixExpression)UnaryExpression_598_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_599_Var
		);
		final EList<? extends EObject> Expr_599_list = PostfixExpression_599_Var
		.getExpr();
		Assert.assertNotNull(Expr_599_list);
		Assert.assertEquals(1, Expr_599_list.size());
		//599
		final PrimaryExpression PrimaryExpression_600_Var
		 = (PrimaryExpression)Expr_599_list.get(0);
		Assert.assertNotNull(PrimaryExpression_600_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_600_Var
		.getId());
		final EList<? extends EObject> Suffix_600_list = PostfixExpression_599_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_600_list);
		Assert.assertEquals(1, Suffix_600_list.size());
		//600
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_601_Var
		 = (PostfixExpressionSuffixArgument)Suffix_600_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_601_Var
		);
		//601
		final ArgumentExpressionList ArgumentExpressionList_602_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_601_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_602_Var
		);
		final EList<? extends EObject> Expr_602_list = ArgumentExpressionList_602_Var
		.getExpr();
		Assert.assertNotNull(Expr_602_list);
		Assert.assertEquals(2, Expr_602_list.size());
		//602
		final AssignmentExpression AssignmentExpression_603_Var
		 = (AssignmentExpression)Expr_602_list.get(0);
		Assert.assertNotNull(AssignmentExpression_603_Var
		);
		//603
		final ConditionalExpression ConditionalExpression_604_Var
		 = (ConditionalExpression)AssignmentExpression_603_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_604_Var
		);
		//604
		final LogicalOrExpression LogicalOrExpression_605_Var
		 = (LogicalOrExpression)ConditionalExpression_604_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_605_Var
		);
		final EList<? extends EObject> Expr_605_list = LogicalOrExpression_605_Var
		.getExpr();
		Assert.assertNotNull(Expr_605_list);
		Assert.assertEquals(1, Expr_605_list.size());
		//605
		final LogicalAndExpression LogicalAndExpression_606_Var
		 = (LogicalAndExpression)Expr_605_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_606_Var
		);
		final EList<? extends EObject> Expr_606_list = LogicalAndExpression_606_Var
		.getExpr();
		Assert.assertNotNull(Expr_606_list);
		Assert.assertEquals(1, Expr_606_list.size());
		//606
		final InclusiveOrExpression InclusiveOrExpression_607_Var
		 = (InclusiveOrExpression)Expr_606_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_607_Var
		);
		final EList<? extends EObject> Expr_607_list = InclusiveOrExpression_607_Var
		.getExpr();
		Assert.assertNotNull(Expr_607_list);
		Assert.assertEquals(1, Expr_607_list.size());
		//607
		final ExclusiveOrExpression ExclusiveOrExpression_608_Var
		 = (ExclusiveOrExpression)Expr_607_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_608_Var
		);
		final EList<? extends EObject> Expr_608_list = ExclusiveOrExpression_608_Var
		.getExpr();
		Assert.assertNotNull(Expr_608_list);
		Assert.assertEquals(1, Expr_608_list.size());
		//608
		final AndExpression AndExpression_609_Var
		 = (AndExpression)Expr_608_list.get(0);
		Assert.assertNotNull(AndExpression_609_Var
		);
		final EList<? extends EObject> Expr_609_list = AndExpression_609_Var
		.getExpr();
		Assert.assertNotNull(Expr_609_list);
		Assert.assertEquals(1, Expr_609_list.size());
		//609
		final EqualityExpression EqualityExpression_610_Var
		 = (EqualityExpression)Expr_609_list.get(0);
		Assert.assertNotNull(EqualityExpression_610_Var
		);
		final EList<? extends EObject> Expr_610_list = EqualityExpression_610_Var
		.getExpr();
		Assert.assertNotNull(Expr_610_list);
		Assert.assertEquals(1, Expr_610_list.size());
		//610
		final RelationalExpression RelationalExpression_611_Var
		 = (RelationalExpression)Expr_610_list.get(0);
		Assert.assertNotNull(RelationalExpression_611_Var
		);
		final EList<? extends EObject> Expr_611_list = RelationalExpression_611_Var
		.getExpr();
		Assert.assertNotNull(Expr_611_list);
		Assert.assertEquals(1, Expr_611_list.size());
		//611
		final ShiftExpression ShiftExpression_612_Var
		 = (ShiftExpression)Expr_611_list.get(0);
		Assert.assertNotNull(ShiftExpression_612_Var
		);
		final EList<? extends EObject> Expr_612_list = ShiftExpression_612_Var
		.getExpr();
		Assert.assertNotNull(Expr_612_list);
		Assert.assertEquals(1, Expr_612_list.size());
		//612
		final AdditiveExpression AdditiveExpression_613_Var
		 = (AdditiveExpression)Expr_612_list.get(0);
		Assert.assertNotNull(AdditiveExpression_613_Var
		);
		final EList<? extends EObject> Expr_613_list = AdditiveExpression_613_Var
		.getExpr();
		Assert.assertNotNull(Expr_613_list);
		Assert.assertEquals(1, Expr_613_list.size());
		//613
		final MultiplicativeExpression MultiplicativeExpression_614_Var
		 = (MultiplicativeExpression)Expr_613_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_614_Var
		);
		final EList<? extends EObject> Expr_614_list = MultiplicativeExpression_614_Var
		.getExpr();
		Assert.assertNotNull(Expr_614_list);
		Assert.assertEquals(1, Expr_614_list.size());
		//614
		final CastExpression CastExpression_615_Var
		 = (CastExpression)Expr_614_list.get(0);
		Assert.assertNotNull(CastExpression_615_Var
		);
		//615
		final UnaryExpression UnaryExpression_616_Var
		 = (UnaryExpression)CastExpression_615_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_616_Var
		);
		//616
		final PostfixExpression PostfixExpression_617_Var
		 = (PostfixExpression)UnaryExpression_616_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_617_Var
		);
		final EList<? extends EObject> Expr_617_list = PostfixExpression_617_Var
		.getExpr();
		Assert.assertNotNull(Expr_617_list);
		Assert.assertEquals(1, Expr_617_list.size());
		//617
		final PrimaryExpression PrimaryExpression_618_Var
		 = (PrimaryExpression)Expr_617_list.get(0);
		Assert.assertNotNull(PrimaryExpression_618_Var
		);
		//618
		final Constant2 Constant2_619_Var
		 = (Constant2)PrimaryExpression_618_Var
		.getConst();
		Assert.assertNotNull(Constant2_619_Var
		);
		Assert.assertEquals("\"The %d. day of the week is my favourite!\\n\"", Constant2_619_Var
		.getStr());
		//619
		final AssignmentExpression AssignmentExpression_620_Var
		 = (AssignmentExpression)Expr_602_list.get(1);
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
		Assert.assertEquals("my_weekday", PrimaryExpression_635_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_583_Var
		.getSemi());
		//635
		final Statement Statement_636_Var
		 = (Statement)Statement_287_list.get(7);
		Assert.assertNotNull(Statement_636_Var
		);
		//636
		final JumpStatement JumpStatement_637_Var
		 = (JumpStatement)Statement_636_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_637_Var
		);
		//637
		final Expression Expression_638_Var
		 = (Expression)JumpStatement_637_Var
		.getExpr();
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
		//654
		final Constant2 Constant2_655_Var
		 = (Constant2)PrimaryExpression_654_Var
		.getConst();
		Assert.assertNotNull(Constant2_655_Var
		);
		Assert.assertEquals("0", Constant2_655_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_637_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_637_Var
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


