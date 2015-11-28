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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
import at.jku.weiner.c.parser.parser.Constant;
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
	
	@Before
	public void initialize(){
		this.testHelper = new LexerAndParserTest(lexer, 
			parser, tokenDefProvider);
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
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_ENUM", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_ASSIGN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_RIGHTBRACE", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_ENUM", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_ASSIGN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_RIGHTBRACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_ENUM", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_ASSIGN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_RIGHTBRACE", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_KW_ENUM", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_KW_VOID", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_RIGHTBRACE", 
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
		Assert.assertEquals(6, External_1_list.size());
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
		final TypeQualifier TypeQualifier_5_Var
		 = (TypeQualifier)DeclarationSpecifier_4_list.get(0);
		Assert.assertNotNull(TypeQualifier_5_Var
		);
		Assert.assertEquals("const", TypeQualifier_5_Var
		.getType());
		//5
		final TypeSpecifier TypeSpecifier_6_Var
		 = (TypeSpecifier)DeclarationSpecifier_4_list.get(1);
		Assert.assertNotNull(TypeSpecifier_6_Var
		);
		Assert.assertEquals("int", TypeSpecifier_6_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_6_list = Declaration_3_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_6_list);
		Assert.assertEquals(1, InitDeclaratorList_6_list.size());
		//6
		final InitDeclaratorList InitDeclaratorList_7_Var
		 = (InitDeclaratorList)InitDeclaratorList_6_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_7_Var
		);
		final EList<? extends EObject> InitDeclarator_7_list = InitDeclaratorList_7_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_7_list);
		Assert.assertEquals(7, InitDeclarator_7_list.size());
		//7
		final InitDeclarator InitDeclarator_8_Var
		 = (InitDeclarator)InitDeclarator_7_list.get(0);
		Assert.assertNotNull(InitDeclarator_8_Var
		);
		//8
		final Declarator Declarator_9_Var
		 = (Declarator)InitDeclarator_8_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_9_Var
		);
		//9
		final DirectDeclarator DirectDeclarator_10_Var
		 = (DirectDeclarator)Declarator_9_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_10_Var
		);
		Assert.assertEquals("W_MONDAY", DirectDeclarator_10_Var
		.getId());
		//10
		final Initializer Initializer_11_Var
		 = (Initializer)InitDeclarator_8_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_11_Var
		);
		//11
		final AssignmentExpression AssignmentExpression_12_Var
		 = (AssignmentExpression)Initializer_11_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_12_Var
		);
		//12
		final ConditionalExpression ConditionalExpression_13_Var
		 = (ConditionalExpression)AssignmentExpression_12_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_13_Var
		);
		//13
		final LogicalOrExpression LogicalOrExpression_14_Var
		 = (LogicalOrExpression)ConditionalExpression_13_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_14_Var
		);
		final EList<? extends EObject> Expr_14_list = LogicalOrExpression_14_Var
		.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		//14
		final LogicalAndExpression LogicalAndExpression_15_Var
		 = (LogicalAndExpression)Expr_14_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_15_Var
		);
		final EList<? extends EObject> Expr_15_list = LogicalAndExpression_15_Var
		.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		//15
		final InclusiveOrExpression InclusiveOrExpression_16_Var
		 = (InclusiveOrExpression)Expr_15_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_16_Var
		);
		final EList<? extends EObject> Expr_16_list = InclusiveOrExpression_16_Var
		.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		//16
		final ExclusiveOrExpression ExclusiveOrExpression_17_Var
		 = (ExclusiveOrExpression)Expr_16_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_17_Var
		);
		final EList<? extends EObject> Expr_17_list = ExclusiveOrExpression_17_Var
		.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		//17
		final AndExpression AndExpression_18_Var
		 = (AndExpression)Expr_17_list.get(0);
		Assert.assertNotNull(AndExpression_18_Var
		);
		final EList<? extends EObject> Expr_18_list = AndExpression_18_Var
		.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		//18
		final EqualityExpression EqualityExpression_19_Var
		 = (EqualityExpression)Expr_18_list.get(0);
		Assert.assertNotNull(EqualityExpression_19_Var
		);
		final EList<? extends EObject> Expr_19_list = EqualityExpression_19_Var
		.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		//19
		final RelationalExpression RelationalExpression_20_Var
		 = (RelationalExpression)Expr_19_list.get(0);
		Assert.assertNotNull(RelationalExpression_20_Var
		);
		final EList<? extends EObject> Expr_20_list = RelationalExpression_20_Var
		.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		//20
		final ShiftExpression ShiftExpression_21_Var
		 = (ShiftExpression)Expr_20_list.get(0);
		Assert.assertNotNull(ShiftExpression_21_Var
		);
		final EList<? extends EObject> Expr_21_list = ShiftExpression_21_Var
		.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		//21
		final AdditiveExpression AdditiveExpression_22_Var
		 = (AdditiveExpression)Expr_21_list.get(0);
		Assert.assertNotNull(AdditiveExpression_22_Var
		);
		final EList<? extends EObject> Expr_22_list = AdditiveExpression_22_Var
		.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		//22
		final MultiplicativeExpression MultiplicativeExpression_23_Var
		 = (MultiplicativeExpression)Expr_22_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_23_Var
		);
		final EList<? extends EObject> Expr_23_list = MultiplicativeExpression_23_Var
		.getExpr();
		Assert.assertNotNull(Expr_23_list);
		Assert.assertEquals(1, Expr_23_list.size());
		//23
		final CastExpression CastExpression_24_Var
		 = (CastExpression)Expr_23_list.get(0);
		Assert.assertNotNull(CastExpression_24_Var
		);
		//24
		final UnaryExpression UnaryExpression_25_Var
		 = (UnaryExpression)CastExpression_24_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_25_Var
		);
		//25
		final PostfixExpression PostfixExpression_26_Var
		 = (PostfixExpression)UnaryExpression_25_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = PostfixExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final PrimaryExpression PrimaryExpression_27_Var
		 = (PrimaryExpression)Expr_26_list.get(0);
		Assert.assertNotNull(PrimaryExpression_27_Var
		);
		//27
		final Constant Constant_28_Var
		 = (Constant)PrimaryExpression_27_Var
		.getConst();
		Assert.assertNotNull(Constant_28_Var
		);
		Assert.assertEquals("1", Constant_28_Var
		.getDec());
		//28
		final InitDeclarator InitDeclarator_29_Var
		 = (InitDeclarator)InitDeclarator_7_list.get(1);
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
		Assert.assertEquals("W_TUESDAY", DirectDeclarator_31_Var
		.getId());
		//31
		final Initializer Initializer_32_Var
		 = (Initializer)InitDeclarator_29_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_32_Var
		);
		//32
		final AssignmentExpression AssignmentExpression_33_Var
		 = (AssignmentExpression)Initializer_32_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_33_Var
		);
		//33
		final ConditionalExpression ConditionalExpression_34_Var
		 = (ConditionalExpression)AssignmentExpression_33_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_34_Var
		);
		//34
		final LogicalOrExpression LogicalOrExpression_35_Var
		 = (LogicalOrExpression)ConditionalExpression_34_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = LogicalOrExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final LogicalAndExpression LogicalAndExpression_36_Var
		 = (LogicalAndExpression)Expr_35_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_36_Var
		);
		final EList<? extends EObject> Expr_36_list = LogicalAndExpression_36_Var
		.getExpr();
		Assert.assertNotNull(Expr_36_list);
		Assert.assertEquals(1, Expr_36_list.size());
		//36
		final InclusiveOrExpression InclusiveOrExpression_37_Var
		 = (InclusiveOrExpression)Expr_36_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = InclusiveOrExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final ExclusiveOrExpression ExclusiveOrExpression_38_Var
		 = (ExclusiveOrExpression)Expr_37_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = ExclusiveOrExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final AndExpression AndExpression_39_Var
		 = (AndExpression)Expr_38_list.get(0);
		Assert.assertNotNull(AndExpression_39_Var
		);
		final EList<? extends EObject> Expr_39_list = AndExpression_39_Var
		.getExpr();
		Assert.assertNotNull(Expr_39_list);
		Assert.assertEquals(1, Expr_39_list.size());
		//39
		final EqualityExpression EqualityExpression_40_Var
		 = (EqualityExpression)Expr_39_list.get(0);
		Assert.assertNotNull(EqualityExpression_40_Var
		);
		final EList<? extends EObject> Expr_40_list = EqualityExpression_40_Var
		.getExpr();
		Assert.assertNotNull(Expr_40_list);
		Assert.assertEquals(1, Expr_40_list.size());
		//40
		final RelationalExpression RelationalExpression_41_Var
		 = (RelationalExpression)Expr_40_list.get(0);
		Assert.assertNotNull(RelationalExpression_41_Var
		);
		final EList<? extends EObject> Expr_41_list = RelationalExpression_41_Var
		.getExpr();
		Assert.assertNotNull(Expr_41_list);
		Assert.assertEquals(1, Expr_41_list.size());
		//41
		final ShiftExpression ShiftExpression_42_Var
		 = (ShiftExpression)Expr_41_list.get(0);
		Assert.assertNotNull(ShiftExpression_42_Var
		);
		final EList<? extends EObject> Expr_42_list = ShiftExpression_42_Var
		.getExpr();
		Assert.assertNotNull(Expr_42_list);
		Assert.assertEquals(1, Expr_42_list.size());
		//42
		final AdditiveExpression AdditiveExpression_43_Var
		 = (AdditiveExpression)Expr_42_list.get(0);
		Assert.assertNotNull(AdditiveExpression_43_Var
		);
		final EList<? extends EObject> Expr_43_list = AdditiveExpression_43_Var
		.getExpr();
		Assert.assertNotNull(Expr_43_list);
		Assert.assertEquals(1, Expr_43_list.size());
		//43
		final MultiplicativeExpression MultiplicativeExpression_44_Var
		 = (MultiplicativeExpression)Expr_43_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_44_Var
		);
		final EList<? extends EObject> Expr_44_list = MultiplicativeExpression_44_Var
		.getExpr();
		Assert.assertNotNull(Expr_44_list);
		Assert.assertEquals(1, Expr_44_list.size());
		//44
		final CastExpression CastExpression_45_Var
		 = (CastExpression)Expr_44_list.get(0);
		Assert.assertNotNull(CastExpression_45_Var
		);
		//45
		final UnaryExpression UnaryExpression_46_Var
		 = (UnaryExpression)CastExpression_45_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_46_Var
		);
		//46
		final PostfixExpression PostfixExpression_47_Var
		 = (PostfixExpression)UnaryExpression_46_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_47_Var
		);
		final EList<? extends EObject> Expr_47_list = PostfixExpression_47_Var
		.getExpr();
		Assert.assertNotNull(Expr_47_list);
		Assert.assertEquals(1, Expr_47_list.size());
		//47
		final PrimaryExpression PrimaryExpression_48_Var
		 = (PrimaryExpression)Expr_47_list.get(0);
		Assert.assertNotNull(PrimaryExpression_48_Var
		);
		//48
		final Constant Constant_49_Var
		 = (Constant)PrimaryExpression_48_Var
		.getConst();
		Assert.assertNotNull(Constant_49_Var
		);
		Assert.assertEquals("2", Constant_49_Var
		.getDec());
		//49
		final InitDeclarator InitDeclarator_50_Var
		 = (InitDeclarator)InitDeclarator_7_list.get(2);
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
		Assert.assertEquals("W_WEDNESDAY", DirectDeclarator_52_Var
		.getId());
		//52
		final Initializer Initializer_53_Var
		 = (Initializer)InitDeclarator_50_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_53_Var
		);
		//53
		final AssignmentExpression AssignmentExpression_54_Var
		 = (AssignmentExpression)Initializer_53_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_54_Var
		);
		//54
		final ConditionalExpression ConditionalExpression_55_Var
		 = (ConditionalExpression)AssignmentExpression_54_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_55_Var
		);
		//55
		final LogicalOrExpression LogicalOrExpression_56_Var
		 = (LogicalOrExpression)ConditionalExpression_55_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = LogicalOrExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final LogicalAndExpression LogicalAndExpression_57_Var
		 = (LogicalAndExpression)Expr_56_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = LogicalAndExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final InclusiveOrExpression InclusiveOrExpression_58_Var
		 = (InclusiveOrExpression)Expr_57_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = InclusiveOrExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final ExclusiveOrExpression ExclusiveOrExpression_59_Var
		 = (ExclusiveOrExpression)Expr_58_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = ExclusiveOrExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final AndExpression AndExpression_60_Var
		 = (AndExpression)Expr_59_list.get(0);
		Assert.assertNotNull(AndExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = AndExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final EqualityExpression EqualityExpression_61_Var
		 = (EqualityExpression)Expr_60_list.get(0);
		Assert.assertNotNull(EqualityExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = EqualityExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final RelationalExpression RelationalExpression_62_Var
		 = (RelationalExpression)Expr_61_list.get(0);
		Assert.assertNotNull(RelationalExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = RelationalExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final ShiftExpression ShiftExpression_63_Var
		 = (ShiftExpression)Expr_62_list.get(0);
		Assert.assertNotNull(ShiftExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = ShiftExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final AdditiveExpression AdditiveExpression_64_Var
		 = (AdditiveExpression)Expr_63_list.get(0);
		Assert.assertNotNull(AdditiveExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = AdditiveExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final MultiplicativeExpression MultiplicativeExpression_65_Var
		 = (MultiplicativeExpression)Expr_64_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = MultiplicativeExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final CastExpression CastExpression_66_Var
		 = (CastExpression)Expr_65_list.get(0);
		Assert.assertNotNull(CastExpression_66_Var
		);
		//66
		final UnaryExpression UnaryExpression_67_Var
		 = (UnaryExpression)CastExpression_66_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_67_Var
		);
		//67
		final PostfixExpression PostfixExpression_68_Var
		 = (PostfixExpression)UnaryExpression_67_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = PostfixExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final PrimaryExpression PrimaryExpression_69_Var
		 = (PrimaryExpression)Expr_68_list.get(0);
		Assert.assertNotNull(PrimaryExpression_69_Var
		);
		//69
		final Constant Constant_70_Var
		 = (Constant)PrimaryExpression_69_Var
		.getConst();
		Assert.assertNotNull(Constant_70_Var
		);
		Assert.assertEquals("3", Constant_70_Var
		.getDec());
		//70
		final InitDeclarator InitDeclarator_71_Var
		 = (InitDeclarator)InitDeclarator_7_list.get(3);
		Assert.assertNotNull(InitDeclarator_71_Var
		);
		//71
		final Declarator Declarator_72_Var
		 = (Declarator)InitDeclarator_71_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_72_Var
		);
		//72
		final DirectDeclarator DirectDeclarator_73_Var
		 = (DirectDeclarator)Declarator_72_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_73_Var
		);
		Assert.assertEquals("W_THURSDAY", DirectDeclarator_73_Var
		.getId());
		//73
		final Initializer Initializer_74_Var
		 = (Initializer)InitDeclarator_71_Var
		.getInitializer();
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
		Assert.assertEquals("4", Constant_91_Var
		.getDec());
		//91
		final InitDeclarator InitDeclarator_92_Var
		 = (InitDeclarator)InitDeclarator_7_list.get(4);
		Assert.assertNotNull(InitDeclarator_92_Var
		);
		//92
		final Declarator Declarator_93_Var
		 = (Declarator)InitDeclarator_92_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_93_Var
		);
		//93
		final DirectDeclarator DirectDeclarator_94_Var
		 = (DirectDeclarator)Declarator_93_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_94_Var
		);
		Assert.assertEquals("W_FRIDAY", DirectDeclarator_94_Var
		.getId());
		//94
		final Initializer Initializer_95_Var
		 = (Initializer)InitDeclarator_92_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_95_Var
		);
		//95
		final AssignmentExpression AssignmentExpression_96_Var
		 = (AssignmentExpression)Initializer_95_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_96_Var
		);
		//96
		final ConditionalExpression ConditionalExpression_97_Var
		 = (ConditionalExpression)AssignmentExpression_96_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_97_Var
		);
		//97
		final LogicalOrExpression LogicalOrExpression_98_Var
		 = (LogicalOrExpression)ConditionalExpression_97_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = LogicalOrExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final LogicalAndExpression LogicalAndExpression_99_Var
		 = (LogicalAndExpression)Expr_98_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = LogicalAndExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final InclusiveOrExpression InclusiveOrExpression_100_Var
		 = (InclusiveOrExpression)Expr_99_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = InclusiveOrExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final ExclusiveOrExpression ExclusiveOrExpression_101_Var
		 = (ExclusiveOrExpression)Expr_100_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = ExclusiveOrExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final AndExpression AndExpression_102_Var
		 = (AndExpression)Expr_101_list.get(0);
		Assert.assertNotNull(AndExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = AndExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final EqualityExpression EqualityExpression_103_Var
		 = (EqualityExpression)Expr_102_list.get(0);
		Assert.assertNotNull(EqualityExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = EqualityExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final RelationalExpression RelationalExpression_104_Var
		 = (RelationalExpression)Expr_103_list.get(0);
		Assert.assertNotNull(RelationalExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = RelationalExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final ShiftExpression ShiftExpression_105_Var
		 = (ShiftExpression)Expr_104_list.get(0);
		Assert.assertNotNull(ShiftExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = ShiftExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final AdditiveExpression AdditiveExpression_106_Var
		 = (AdditiveExpression)Expr_105_list.get(0);
		Assert.assertNotNull(AdditiveExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = AdditiveExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final MultiplicativeExpression MultiplicativeExpression_107_Var
		 = (MultiplicativeExpression)Expr_106_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = MultiplicativeExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final CastExpression CastExpression_108_Var
		 = (CastExpression)Expr_107_list.get(0);
		Assert.assertNotNull(CastExpression_108_Var
		);
		//108
		final UnaryExpression UnaryExpression_109_Var
		 = (UnaryExpression)CastExpression_108_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_109_Var
		);
		//109
		final PostfixExpression PostfixExpression_110_Var
		 = (PostfixExpression)UnaryExpression_109_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = PostfixExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final PrimaryExpression PrimaryExpression_111_Var
		 = (PrimaryExpression)Expr_110_list.get(0);
		Assert.assertNotNull(PrimaryExpression_111_Var
		);
		//111
		final Constant Constant_112_Var
		 = (Constant)PrimaryExpression_111_Var
		.getConst();
		Assert.assertNotNull(Constant_112_Var
		);
		Assert.assertEquals("5", Constant_112_Var
		.getDec());
		//112
		final InitDeclarator InitDeclarator_113_Var
		 = (InitDeclarator)InitDeclarator_7_list.get(5);
		Assert.assertNotNull(InitDeclarator_113_Var
		);
		//113
		final Declarator Declarator_114_Var
		 = (Declarator)InitDeclarator_113_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_114_Var
		);
		//114
		final DirectDeclarator DirectDeclarator_115_Var
		 = (DirectDeclarator)Declarator_114_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_115_Var
		);
		Assert.assertEquals("W_SATURDAY", DirectDeclarator_115_Var
		.getId());
		//115
		final Initializer Initializer_116_Var
		 = (Initializer)InitDeclarator_113_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_116_Var
		);
		//116
		final AssignmentExpression AssignmentExpression_117_Var
		 = (AssignmentExpression)Initializer_116_Var
		.getExpr();
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
		//132
		final Constant Constant_133_Var
		 = (Constant)PrimaryExpression_132_Var
		.getConst();
		Assert.assertNotNull(Constant_133_Var
		);
		Assert.assertEquals("6", Constant_133_Var
		.getDec());
		//133
		final InitDeclarator InitDeclarator_134_Var
		 = (InitDeclarator)InitDeclarator_7_list.get(6);
		Assert.assertNotNull(InitDeclarator_134_Var
		);
		//134
		final Declarator Declarator_135_Var
		 = (Declarator)InitDeclarator_134_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_135_Var
		);
		//135
		final DirectDeclarator DirectDeclarator_136_Var
		 = (DirectDeclarator)Declarator_135_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_136_Var
		);
		Assert.assertEquals("W_SUNDAY", DirectDeclarator_136_Var
		.getId());
		//136
		final Initializer Initializer_137_Var
		 = (Initializer)InitDeclarator_134_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_137_Var
		);
		//137
		final AssignmentExpression AssignmentExpression_138_Var
		 = (AssignmentExpression)Initializer_137_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_138_Var
		);
		//138
		final ConditionalExpression ConditionalExpression_139_Var
		 = (ConditionalExpression)AssignmentExpression_138_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_139_Var
		);
		//139
		final LogicalOrExpression LogicalOrExpression_140_Var
		 = (LogicalOrExpression)ConditionalExpression_139_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = LogicalOrExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final LogicalAndExpression LogicalAndExpression_141_Var
		 = (LogicalAndExpression)Expr_140_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = LogicalAndExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final InclusiveOrExpression InclusiveOrExpression_142_Var
		 = (InclusiveOrExpression)Expr_141_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_142_Var
		);
		final EList<? extends EObject> Expr_142_list = InclusiveOrExpression_142_Var
		.getExpr();
		Assert.assertNotNull(Expr_142_list);
		Assert.assertEquals(1, Expr_142_list.size());
		//142
		final ExclusiveOrExpression ExclusiveOrExpression_143_Var
		 = (ExclusiveOrExpression)Expr_142_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = ExclusiveOrExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final AndExpression AndExpression_144_Var
		 = (AndExpression)Expr_143_list.get(0);
		Assert.assertNotNull(AndExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = AndExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final EqualityExpression EqualityExpression_145_Var
		 = (EqualityExpression)Expr_144_list.get(0);
		Assert.assertNotNull(EqualityExpression_145_Var
		);
		final EList<? extends EObject> Expr_145_list = EqualityExpression_145_Var
		.getExpr();
		Assert.assertNotNull(Expr_145_list);
		Assert.assertEquals(1, Expr_145_list.size());
		//145
		final RelationalExpression RelationalExpression_146_Var
		 = (RelationalExpression)Expr_145_list.get(0);
		Assert.assertNotNull(RelationalExpression_146_Var
		);
		final EList<? extends EObject> Expr_146_list = RelationalExpression_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final ShiftExpression ShiftExpression_147_Var
		 = (ShiftExpression)Expr_146_list.get(0);
		Assert.assertNotNull(ShiftExpression_147_Var
		);
		final EList<? extends EObject> Expr_147_list = ShiftExpression_147_Var
		.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(1, Expr_147_list.size());
		//147
		final AdditiveExpression AdditiveExpression_148_Var
		 = (AdditiveExpression)Expr_147_list.get(0);
		Assert.assertNotNull(AdditiveExpression_148_Var
		);
		final EList<? extends EObject> Expr_148_list = AdditiveExpression_148_Var
		.getExpr();
		Assert.assertNotNull(Expr_148_list);
		Assert.assertEquals(1, Expr_148_list.size());
		//148
		final MultiplicativeExpression MultiplicativeExpression_149_Var
		 = (MultiplicativeExpression)Expr_148_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_149_Var
		);
		final EList<? extends EObject> Expr_149_list = MultiplicativeExpression_149_Var
		.getExpr();
		Assert.assertNotNull(Expr_149_list);
		Assert.assertEquals(1, Expr_149_list.size());
		//149
		final CastExpression CastExpression_150_Var
		 = (CastExpression)Expr_149_list.get(0);
		Assert.assertNotNull(CastExpression_150_Var
		);
		//150
		final UnaryExpression UnaryExpression_151_Var
		 = (UnaryExpression)CastExpression_150_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_151_Var
		);
		//151
		final PostfixExpression PostfixExpression_152_Var
		 = (PostfixExpression)UnaryExpression_151_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_152_Var
		);
		final EList<? extends EObject> Expr_152_list = PostfixExpression_152_Var
		.getExpr();
		Assert.assertNotNull(Expr_152_list);
		Assert.assertEquals(1, Expr_152_list.size());
		//152
		final PrimaryExpression PrimaryExpression_153_Var
		 = (PrimaryExpression)Expr_152_list.get(0);
		Assert.assertNotNull(PrimaryExpression_153_Var
		);
		//153
		final Constant Constant_154_Var
		 = (Constant)PrimaryExpression_153_Var
		.getConst();
		Assert.assertNotNull(Constant_154_Var
		);
		Assert.assertEquals("7", Constant_154_Var
		.getDec());
		Assert.assertEquals(";", Declaration_3_Var
		.getSemi());
		//154
		final ExternalDeclaration ExternalDeclaration_155_Var
		 = (ExternalDeclaration)External_1_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_155_Var
		);
		//155
		final Declaration Declaration_156_Var
		 = (Declaration)ExternalDeclaration_155_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_156_Var
		);
		//156
		final DeclarationSpecifiers DeclarationSpecifiers_157_Var
		 = (DeclarationSpecifiers)Declaration_156_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_157_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_157_list = DeclarationSpecifiers_157_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_157_list);
		Assert.assertEquals(1, DeclarationSpecifier_157_list.size());
		//157
		final TypeSpecifier TypeSpecifier_158_Var
		 = (TypeSpecifier)DeclarationSpecifier_157_list.get(0);
		Assert.assertNotNull(TypeSpecifier_158_Var
		);
		//158
		final EnumSpecifier EnumSpecifier_159_Var
		 = (EnumSpecifier)TypeSpecifier_158_Var
		.getSpecifier();
		Assert.assertNotNull(EnumSpecifier_159_Var
		);
		//159
		final EnumeratorList EnumeratorList_160_Var
		 = (EnumeratorList)EnumSpecifier_159_Var
		.getEnumList();
		Assert.assertNotNull(EnumeratorList_160_Var
		);
		final EList<? extends EObject> Enumerator_160_list = EnumeratorList_160_Var
		.getEnumerator();
		Assert.assertNotNull(Enumerator_160_list);
		Assert.assertEquals(7, Enumerator_160_list.size());
		//160
		final Enumerator Enumerator_161_Var
		 = (Enumerator)Enumerator_160_list.get(0);
		Assert.assertNotNull(Enumerator_161_Var
		);
		Assert.assertEquals("MONDAY", Enumerator_161_Var
		.getId());
		//161
		final ConstantExpression ConstantExpression_162_Var
		 = (ConstantExpression)Enumerator_161_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_162_Var
		);
		//162
		final ConditionalExpression ConditionalExpression_163_Var
		 = (ConditionalExpression)ConstantExpression_162_Var
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
		//177
		final Constant Constant_178_Var
		 = (Constant)PrimaryExpression_177_Var
		.getConst();
		Assert.assertNotNull(Constant_178_Var
		);
		Assert.assertEquals("1", Constant_178_Var
		.getDec());
		//178
		final Enumerator Enumerator_179_Var
		 = (Enumerator)Enumerator_160_list.get(1);
		Assert.assertNotNull(Enumerator_179_Var
		);
		Assert.assertEquals("TUESDAY", Enumerator_179_Var
		.getId());
		//179
		final Enumerator Enumerator_180_Var
		 = (Enumerator)Enumerator_160_list.get(2);
		Assert.assertNotNull(Enumerator_180_Var
		);
		Assert.assertEquals("WEDNESDAY", Enumerator_180_Var
		.getId());
		//180
		final Enumerator Enumerator_181_Var
		 = (Enumerator)Enumerator_160_list.get(3);
		Assert.assertNotNull(Enumerator_181_Var
		);
		Assert.assertEquals("THURSDAY", Enumerator_181_Var
		.getId());
		//181
		final Enumerator Enumerator_182_Var
		 = (Enumerator)Enumerator_160_list.get(4);
		Assert.assertNotNull(Enumerator_182_Var
		);
		Assert.assertEquals("FRIDAY", Enumerator_182_Var
		.getId());
		//182
		final Enumerator Enumerator_183_Var
		 = (Enumerator)Enumerator_160_list.get(5);
		Assert.assertNotNull(Enumerator_183_Var
		);
		Assert.assertEquals("SATURDAY", Enumerator_183_Var
		.getId());
		//183
		final Enumerator Enumerator_184_Var
		 = (Enumerator)Enumerator_160_list.get(6);
		Assert.assertNotNull(Enumerator_184_Var
		);
		Assert.assertEquals("SUNDAY", Enumerator_184_Var
		.getId());
		//184
		final ExternalDeclaration ExternalDeclaration_185_Var
		 = (ExternalDeclaration)External_1_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_185_Var
		);
		//185
		final Declaration Declaration_186_Var
		 = (Declaration)ExternalDeclaration_185_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_186_Var
		);
		//186
		final DeclarationSpecifiers DeclarationSpecifiers_187_Var
		 = (DeclarationSpecifiers)Declaration_186_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_187_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_187_list = DeclarationSpecifiers_187_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_187_list);
		Assert.assertEquals(1, DeclarationSpecifier_187_list.size());
		//187
		final TypeSpecifier TypeSpecifier_188_Var
		 = (TypeSpecifier)DeclarationSpecifier_187_list.get(0);
		Assert.assertNotNull(TypeSpecifier_188_Var
		);
		//188
		final EnumSpecifier EnumSpecifier_189_Var
		 = (EnumSpecifier)TypeSpecifier_188_Var
		.getSpecifier();
		Assert.assertNotNull(EnumSpecifier_189_Var
		);
		//189
		final EnumeratorList EnumeratorList_190_Var
		 = (EnumeratorList)EnumSpecifier_189_Var
		.getEnumList();
		Assert.assertNotNull(EnumeratorList_190_Var
		);
		final EList<? extends EObject> Enumerator_190_list = EnumeratorList_190_Var
		.getEnumerator();
		Assert.assertNotNull(Enumerator_190_list);
		Assert.assertEquals(7, Enumerator_190_list.size());
		//190
		final Enumerator Enumerator_191_Var
		 = (Enumerator)Enumerator_190_list.get(0);
		Assert.assertNotNull(Enumerator_191_Var
		);
		Assert.assertEquals("I_MONDAY", Enumerator_191_Var
		.getId());
		//191
		final ConstantExpression ConstantExpression_192_Var
		 = (ConstantExpression)Enumerator_191_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_192_Var
		);
		//192
		final ConditionalExpression ConditionalExpression_193_Var
		 = (ConditionalExpression)ConstantExpression_192_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_193_Var
		);
		//193
		final LogicalOrExpression LogicalOrExpression_194_Var
		 = (LogicalOrExpression)ConditionalExpression_193_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = LogicalOrExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final LogicalAndExpression LogicalAndExpression_195_Var
		 = (LogicalAndExpression)Expr_194_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = LogicalAndExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final InclusiveOrExpression InclusiveOrExpression_196_Var
		 = (InclusiveOrExpression)Expr_195_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = InclusiveOrExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final ExclusiveOrExpression ExclusiveOrExpression_197_Var
		 = (ExclusiveOrExpression)Expr_196_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = ExclusiveOrExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final AndExpression AndExpression_198_Var
		 = (AndExpression)Expr_197_list.get(0);
		Assert.assertNotNull(AndExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = AndExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final EqualityExpression EqualityExpression_199_Var
		 = (EqualityExpression)Expr_198_list.get(0);
		Assert.assertNotNull(EqualityExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = EqualityExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final RelationalExpression RelationalExpression_200_Var
		 = (RelationalExpression)Expr_199_list.get(0);
		Assert.assertNotNull(RelationalExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = RelationalExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final ShiftExpression ShiftExpression_201_Var
		 = (ShiftExpression)Expr_200_list.get(0);
		Assert.assertNotNull(ShiftExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = ShiftExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final AdditiveExpression AdditiveExpression_202_Var
		 = (AdditiveExpression)Expr_201_list.get(0);
		Assert.assertNotNull(AdditiveExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = AdditiveExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final MultiplicativeExpression MultiplicativeExpression_203_Var
		 = (MultiplicativeExpression)Expr_202_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = MultiplicativeExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final CastExpression CastExpression_204_Var
		 = (CastExpression)Expr_203_list.get(0);
		Assert.assertNotNull(CastExpression_204_Var
		);
		//204
		final UnaryExpression UnaryExpression_205_Var
		 = (UnaryExpression)CastExpression_204_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_205_Var
		);
		//205
		final PostfixExpression PostfixExpression_206_Var
		 = (PostfixExpression)UnaryExpression_205_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = PostfixExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final PrimaryExpression PrimaryExpression_207_Var
		 = (PrimaryExpression)Expr_206_list.get(0);
		Assert.assertNotNull(PrimaryExpression_207_Var
		);
		//207
		final Constant Constant_208_Var
		 = (Constant)PrimaryExpression_207_Var
		.getConst();
		Assert.assertNotNull(Constant_208_Var
		);
		Assert.assertEquals("1", Constant_208_Var
		.getDec());
		//208
		final Enumerator Enumerator_209_Var
		 = (Enumerator)Enumerator_190_list.get(1);
		Assert.assertNotNull(Enumerator_209_Var
		);
		Assert.assertEquals("I_TUESDAY", Enumerator_209_Var
		.getId());
		//209
		final Enumerator Enumerator_210_Var
		 = (Enumerator)Enumerator_190_list.get(2);
		Assert.assertNotNull(Enumerator_210_Var
		);
		Assert.assertEquals("I_WEDNESDAY", Enumerator_210_Var
		.getId());
		//210
		final Enumerator Enumerator_211_Var
		 = (Enumerator)Enumerator_190_list.get(3);
		Assert.assertNotNull(Enumerator_211_Var
		);
		Assert.assertEquals("I_THURSDAY", Enumerator_211_Var
		.getId());
		//211
		final Enumerator Enumerator_212_Var
		 = (Enumerator)Enumerator_190_list.get(4);
		Assert.assertNotNull(Enumerator_212_Var
		);
		Assert.assertEquals("I_FRIDAY", Enumerator_212_Var
		.getId());
		//212
		final Enumerator Enumerator_213_Var
		 = (Enumerator)Enumerator_190_list.get(5);
		Assert.assertNotNull(Enumerator_213_Var
		);
		Assert.assertEquals("I_SATURDAY", Enumerator_213_Var
		.getId());
		//213
		final Enumerator Enumerator_214_Var
		 = (Enumerator)Enumerator_190_list.get(6);
		Assert.assertNotNull(Enumerator_214_Var
		);
		Assert.assertEquals("I_SUNDAY", Enumerator_214_Var
		.getId());
		//214
		final ExternalDeclaration ExternalDeclaration_215_Var
		 = (ExternalDeclaration)External_1_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_215_Var
		);
		//215
		final Declaration Declaration_216_Var
		 = (Declaration)ExternalDeclaration_215_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_216_Var
		);
		//216
		final DeclarationSpecifiers DeclarationSpecifiers_217_Var
		 = (DeclarationSpecifiers)Declaration_216_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_217_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_217_list = DeclarationSpecifiers_217_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_217_list);
		Assert.assertEquals(1, DeclarationSpecifier_217_list.size());
		//217
		final TypeSpecifier TypeSpecifier_218_Var
		 = (TypeSpecifier)DeclarationSpecifier_217_list.get(0);
		Assert.assertNotNull(TypeSpecifier_218_Var
		);
		//218
		final EnumSpecifier EnumSpecifier_219_Var
		 = (EnumSpecifier)TypeSpecifier_218_Var
		.getSpecifier();
		Assert.assertNotNull(EnumSpecifier_219_Var
		);
		Assert.assertEquals("weekdays", EnumSpecifier_219_Var
		.getId());
		//219
		final EnumeratorList EnumeratorList_220_Var
		 = (EnumeratorList)EnumSpecifier_219_Var
		.getEnumList();
		Assert.assertNotNull(EnumeratorList_220_Var
		);
		final EList<? extends EObject> Enumerator_220_list = EnumeratorList_220_Var
		.getEnumerator();
		Assert.assertNotNull(Enumerator_220_list);
		Assert.assertEquals(7, Enumerator_220_list.size());
		//220
		final Enumerator Enumerator_221_Var
		 = (Enumerator)Enumerator_220_list.get(0);
		Assert.assertNotNull(Enumerator_221_Var
		);
		Assert.assertEquals("M_MONDAY", Enumerator_221_Var
		.getId());
		//221
		final ConstantExpression ConstantExpression_222_Var
		 = (ConstantExpression)Enumerator_221_Var
		.getExpr();
		Assert.assertNotNull(ConstantExpression_222_Var
		);
		//222
		final ConditionalExpression ConditionalExpression_223_Var
		 = (ConditionalExpression)ConstantExpression_222_Var
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
		//237
		final Constant Constant_238_Var
		 = (Constant)PrimaryExpression_237_Var
		.getConst();
		Assert.assertNotNull(Constant_238_Var
		);
		Assert.assertEquals("1", Constant_238_Var
		.getDec());
		//238
		final Enumerator Enumerator_239_Var
		 = (Enumerator)Enumerator_220_list.get(1);
		Assert.assertNotNull(Enumerator_239_Var
		);
		Assert.assertEquals("M_TUESDAY", Enumerator_239_Var
		.getId());
		//239
		final Enumerator Enumerator_240_Var
		 = (Enumerator)Enumerator_220_list.get(2);
		Assert.assertNotNull(Enumerator_240_Var
		);
		Assert.assertEquals("M_WEDNESDAY", Enumerator_240_Var
		.getId());
		//240
		final Enumerator Enumerator_241_Var
		 = (Enumerator)Enumerator_220_list.get(3);
		Assert.assertNotNull(Enumerator_241_Var
		);
		Assert.assertEquals("M_THURSDAY", Enumerator_241_Var
		.getId());
		//241
		final Enumerator Enumerator_242_Var
		 = (Enumerator)Enumerator_220_list.get(4);
		Assert.assertNotNull(Enumerator_242_Var
		);
		Assert.assertEquals("M_FRIDAY", Enumerator_242_Var
		.getId());
		//242
		final Enumerator Enumerator_243_Var
		 = (Enumerator)Enumerator_220_list.get(5);
		Assert.assertNotNull(Enumerator_243_Var
		);
		Assert.assertEquals("M_SATURDAY", Enumerator_243_Var
		.getId());
		//243
		final Enumerator Enumerator_244_Var
		 = (Enumerator)Enumerator_220_list.get(6);
		Assert.assertNotNull(Enumerator_244_Var
		);
		Assert.assertEquals("M_SUNDAY", Enumerator_244_Var
		.getId());
		//244
		final ExternalDeclaration ExternalDeclaration_245_Var
		 = (ExternalDeclaration)External_1_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_245_Var
		);
		//245
		final Declaration Declaration_246_Var
		 = (Declaration)ExternalDeclaration_245_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_246_Var
		);
		//246
		final DeclarationSpecifiers DeclarationSpecifiers_247_Var
		 = (DeclarationSpecifiers)Declaration_246_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_247_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_247_list = DeclarationSpecifiers_247_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_247_list);
		Assert.assertEquals(1, DeclarationSpecifier_247_list.size());
		//247
		final TypeSpecifier TypeSpecifier_248_Var
		 = (TypeSpecifier)DeclarationSpecifier_247_list.get(0);
		Assert.assertNotNull(TypeSpecifier_248_Var
		);
		//248
		final EnumSpecifier EnumSpecifier_249_Var
		 = (EnumSpecifier)TypeSpecifier_248_Var
		.getSpecifier();
		Assert.assertNotNull(EnumSpecifier_249_Var
		);
		Assert.assertEquals("weekdays", EnumSpecifier_249_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_249_list = Declaration_246_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_249_list);
		Assert.assertEquals(1, InitDeclaratorList_249_list.size());
		//249
		final InitDeclaratorList InitDeclaratorList_250_Var
		 = (InitDeclaratorList)InitDeclaratorList_249_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_250_Var
		);
		final EList<? extends EObject> InitDeclarator_250_list = InitDeclaratorList_250_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_250_list);
		Assert.assertEquals(1, InitDeclarator_250_list.size());
		//250
		final InitDeclarator InitDeclarator_251_Var
		 = (InitDeclarator)InitDeclarator_250_list.get(0);
		Assert.assertNotNull(InitDeclarator_251_Var
		);
		//251
		final Declarator Declarator_252_Var
		 = (Declarator)InitDeclarator_251_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_252_Var
		);
		//252
		final DirectDeclarator DirectDeclarator_253_Var
		 = (DirectDeclarator)Declarator_252_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_253_Var
		);
		Assert.assertEquals("my_weekday", DirectDeclarator_253_Var
		.getId());
		//253
		final Initializer Initializer_254_Var
		 = (Initializer)InitDeclarator_251_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_254_Var
		);
		//254
		final AssignmentExpression AssignmentExpression_255_Var
		 = (AssignmentExpression)Initializer_254_Var
		.getExpr();
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
		Assert.assertEquals("M_FRIDAY", PrimaryExpression_270_Var
		.getId());
		//270
		final ExternalDeclaration ExternalDeclaration_271_Var
		 = (ExternalDeclaration)External_1_list.get(5);
		Assert.assertNotNull(ExternalDeclaration_271_Var
		);
		//271
		final FunctionDefHead FunctionDefHead_272_Var
		 = (FunctionDefHead)ExternalDeclaration_271_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_272_Var
		);
		//272
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_273_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_272_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_273_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_273_list = FunctionDeclarationSpecifiers_273_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_273_list);
		Assert.assertEquals(1, DeclarationSpecifier_273_list.size());
		//273
		final TypeSpecifier TypeSpecifier_274_Var
		 = (TypeSpecifier)DeclarationSpecifier_273_list.get(0);
		Assert.assertNotNull(TypeSpecifier_274_Var
		);
		Assert.assertEquals("int", TypeSpecifier_274_Var
		.getName());
		//274
		final Declarator Declarator_275_Var
		 = (Declarator)FunctionDefHead_272_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_275_Var
		);
		//275
		final DirectDeclarator DirectDeclarator_276_Var
		 = (DirectDeclarator)Declarator_275_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_276_Var
		);
		Assert.assertEquals("main", DirectDeclarator_276_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_276_list = DirectDeclarator_276_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_276_list);
		Assert.assertEquals(1, DeclaratorSuffix_276_list.size());
		//276
		final DeclaratorSuffix DeclaratorSuffix_277_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_276_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_277_Var
		);
		//277
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_278_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_277_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_278_Var
		);
		final EList<? extends EObject> ParameterTypeList_278_list = DirectDeclaratorLastSuffix_278_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_278_list);
		Assert.assertEquals(1, ParameterTypeList_278_list.size());
		//278
		final ParameterTypeList ParameterTypeList_279_Var
		 = (ParameterTypeList)ParameterTypeList_278_list.get(0);
		Assert.assertNotNull(ParameterTypeList_279_Var
		);
		//279
		final ParameterList ParameterList_280_Var
		 = (ParameterList)ParameterTypeList_279_Var
		.getList();
		Assert.assertNotNull(ParameterList_280_Var
		);
		final EList<? extends EObject> ParameterDeclaration_280_list = ParameterList_280_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_280_list);
		Assert.assertEquals(1, ParameterDeclaration_280_list.size());
		//280
		final ParameterDeclaration ParameterDeclaration_281_Var
		 = (ParameterDeclaration)ParameterDeclaration_280_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_281_Var
		);
		//281
		final DeclarationSpecifiers DeclarationSpecifiers_282_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_281_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_282_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_282_list = DeclarationSpecifiers_282_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_282_list);
		Assert.assertEquals(1, DeclarationSpecifier_282_list.size());
		//282
		final TypeSpecifier TypeSpecifier_283_Var
		 = (TypeSpecifier)DeclarationSpecifier_282_list.get(0);
		Assert.assertNotNull(TypeSpecifier_283_Var
		);
		Assert.assertEquals("void", TypeSpecifier_283_Var
		.getName());
		//283
		final FunctionDefinition FunctionDefinition_284_Var
		 = (FunctionDefinition)ExternalDeclaration_271_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_284_Var
		);
		//284
		final BodyStatement BodyStatement_285_Var
		 = (BodyStatement)FunctionDefinition_284_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_285_Var
		);
		final EList<? extends EObject> BlockList_285_list = BodyStatement_285_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_285_list);
		Assert.assertEquals(1, BlockList_285_list.size());
		//285
		final BlockList BlockList_286_Var
		 = (BlockList)BlockList_285_list.get(0);
		Assert.assertNotNull(BlockList_286_Var
		);
		final EList<? extends EObject> Statement_286_list = BlockList_286_Var
		.getStatement();
		Assert.assertNotNull(Statement_286_list);
		Assert.assertEquals(8, Statement_286_list.size());
		//286
		final Statement Statement_287_Var
		 = (Statement)Statement_286_list.get(0);
		Assert.assertNotNull(Statement_287_Var
		);
		//287
		final ExpressionStatement ExpressionStatement_288_Var
		 = (ExpressionStatement)Statement_287_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_288_Var
		);
		//288
		final Expression Expression_289_Var
		 = (Expression)ExpressionStatement_288_Var
		.getExpression();
		Assert.assertNotNull(Expression_289_Var
		);
		final EList<? extends EObject> ExprExpr_289_list = Expression_289_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_289_list);
		Assert.assertEquals(1, ExprExpr_289_list.size());
		//289
		final AssignmentExpression AssignmentExpression_290_Var
		 = (AssignmentExpression)ExprExpr_289_list.get(0);
		Assert.assertNotNull(AssignmentExpression_290_Var
		);
		//290
		final ConditionalExpression ConditionalExpression_291_Var
		 = (ConditionalExpression)AssignmentExpression_290_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_291_Var
		);
		//291
		final LogicalOrExpression LogicalOrExpression_292_Var
		 = (LogicalOrExpression)ConditionalExpression_291_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_292_Var
		);
		final EList<? extends EObject> Expr_292_list = LogicalOrExpression_292_Var
		.getExpr();
		Assert.assertNotNull(Expr_292_list);
		Assert.assertEquals(1, Expr_292_list.size());
		//292
		final LogicalAndExpression LogicalAndExpression_293_Var
		 = (LogicalAndExpression)Expr_292_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = LogicalAndExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final InclusiveOrExpression InclusiveOrExpression_294_Var
		 = (InclusiveOrExpression)Expr_293_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_294_Var
		);
		final EList<? extends EObject> Expr_294_list = InclusiveOrExpression_294_Var
		.getExpr();
		Assert.assertNotNull(Expr_294_list);
		Assert.assertEquals(1, Expr_294_list.size());
		//294
		final ExclusiveOrExpression ExclusiveOrExpression_295_Var
		 = (ExclusiveOrExpression)Expr_294_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_295_Var
		);
		final EList<? extends EObject> Expr_295_list = ExclusiveOrExpression_295_Var
		.getExpr();
		Assert.assertNotNull(Expr_295_list);
		Assert.assertEquals(1, Expr_295_list.size());
		//295
		final AndExpression AndExpression_296_Var
		 = (AndExpression)Expr_295_list.get(0);
		Assert.assertNotNull(AndExpression_296_Var
		);
		final EList<? extends EObject> Expr_296_list = AndExpression_296_Var
		.getExpr();
		Assert.assertNotNull(Expr_296_list);
		Assert.assertEquals(1, Expr_296_list.size());
		//296
		final EqualityExpression EqualityExpression_297_Var
		 = (EqualityExpression)Expr_296_list.get(0);
		Assert.assertNotNull(EqualityExpression_297_Var
		);
		final EList<? extends EObject> Expr_297_list = EqualityExpression_297_Var
		.getExpr();
		Assert.assertNotNull(Expr_297_list);
		Assert.assertEquals(1, Expr_297_list.size());
		//297
		final RelationalExpression RelationalExpression_298_Var
		 = (RelationalExpression)Expr_297_list.get(0);
		Assert.assertNotNull(RelationalExpression_298_Var
		);
		final EList<? extends EObject> Expr_298_list = RelationalExpression_298_Var
		.getExpr();
		Assert.assertNotNull(Expr_298_list);
		Assert.assertEquals(1, Expr_298_list.size());
		//298
		final ShiftExpression ShiftExpression_299_Var
		 = (ShiftExpression)Expr_298_list.get(0);
		Assert.assertNotNull(ShiftExpression_299_Var
		);
		final EList<? extends EObject> Expr_299_list = ShiftExpression_299_Var
		.getExpr();
		Assert.assertNotNull(Expr_299_list);
		Assert.assertEquals(1, Expr_299_list.size());
		//299
		final AdditiveExpression AdditiveExpression_300_Var
		 = (AdditiveExpression)Expr_299_list.get(0);
		Assert.assertNotNull(AdditiveExpression_300_Var
		);
		final EList<? extends EObject> Expr_300_list = AdditiveExpression_300_Var
		.getExpr();
		Assert.assertNotNull(Expr_300_list);
		Assert.assertEquals(1, Expr_300_list.size());
		//300
		final MultiplicativeExpression MultiplicativeExpression_301_Var
		 = (MultiplicativeExpression)Expr_300_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_301_Var
		);
		final EList<? extends EObject> Expr_301_list = MultiplicativeExpression_301_Var
		.getExpr();
		Assert.assertNotNull(Expr_301_list);
		Assert.assertEquals(1, Expr_301_list.size());
		//301
		final CastExpression CastExpression_302_Var
		 = (CastExpression)Expr_301_list.get(0);
		Assert.assertNotNull(CastExpression_302_Var
		);
		//302
		final UnaryExpression UnaryExpression_303_Var
		 = (UnaryExpression)CastExpression_302_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_303_Var
		);
		//303
		final PostfixExpression PostfixExpression_304_Var
		 = (PostfixExpression)UnaryExpression_303_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_304_Var
		);
		final EList<? extends EObject> Expr_304_list = PostfixExpression_304_Var
		.getExpr();
		Assert.assertNotNull(Expr_304_list);
		Assert.assertEquals(1, Expr_304_list.size());
		//304
		final PrimaryExpression PrimaryExpression_305_Var
		 = (PrimaryExpression)Expr_304_list.get(0);
		Assert.assertNotNull(PrimaryExpression_305_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_305_Var
		.getId());
		final EList<? extends EObject> Suffix_305_list = PostfixExpression_304_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_305_list);
		Assert.assertEquals(1, Suffix_305_list.size());
		//305
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_306_Var
		 = (PostfixExpressionSuffixArgument)Suffix_305_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_306_Var
		);
		//306
		final ArgumentExpressionList ArgumentExpressionList_307_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_306_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_307_Var
		);
		final EList<? extends EObject> Expr_307_list = ArgumentExpressionList_307_Var
		.getExpr();
		Assert.assertNotNull(Expr_307_list);
		Assert.assertEquals(2, Expr_307_list.size());
		//307
		final AssignmentExpression AssignmentExpression_308_Var
		 = (AssignmentExpression)Expr_307_list.get(0);
		Assert.assertNotNull(AssignmentExpression_308_Var
		);
		//308
		final ConditionalExpression ConditionalExpression_309_Var
		 = (ConditionalExpression)AssignmentExpression_308_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_309_Var
		);
		//309
		final LogicalOrExpression LogicalOrExpression_310_Var
		 = (LogicalOrExpression)ConditionalExpression_309_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_310_Var
		);
		final EList<? extends EObject> Expr_310_list = LogicalOrExpression_310_Var
		.getExpr();
		Assert.assertNotNull(Expr_310_list);
		Assert.assertEquals(1, Expr_310_list.size());
		//310
		final LogicalAndExpression LogicalAndExpression_311_Var
		 = (LogicalAndExpression)Expr_310_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = LogicalAndExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final InclusiveOrExpression InclusiveOrExpression_312_Var
		 = (InclusiveOrExpression)Expr_311_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = InclusiveOrExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final ExclusiveOrExpression ExclusiveOrExpression_313_Var
		 = (ExclusiveOrExpression)Expr_312_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_313_Var
		);
		final EList<? extends EObject> Expr_313_list = ExclusiveOrExpression_313_Var
		.getExpr();
		Assert.assertNotNull(Expr_313_list);
		Assert.assertEquals(1, Expr_313_list.size());
		//313
		final AndExpression AndExpression_314_Var
		 = (AndExpression)Expr_313_list.get(0);
		Assert.assertNotNull(AndExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = AndExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final EqualityExpression EqualityExpression_315_Var
		 = (EqualityExpression)Expr_314_list.get(0);
		Assert.assertNotNull(EqualityExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = EqualityExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final RelationalExpression RelationalExpression_316_Var
		 = (RelationalExpression)Expr_315_list.get(0);
		Assert.assertNotNull(RelationalExpression_316_Var
		);
		final EList<? extends EObject> Expr_316_list = RelationalExpression_316_Var
		.getExpr();
		Assert.assertNotNull(Expr_316_list);
		Assert.assertEquals(1, Expr_316_list.size());
		//316
		final ShiftExpression ShiftExpression_317_Var
		 = (ShiftExpression)Expr_316_list.get(0);
		Assert.assertNotNull(ShiftExpression_317_Var
		);
		final EList<? extends EObject> Expr_317_list = ShiftExpression_317_Var
		.getExpr();
		Assert.assertNotNull(Expr_317_list);
		Assert.assertEquals(1, Expr_317_list.size());
		//317
		final AdditiveExpression AdditiveExpression_318_Var
		 = (AdditiveExpression)Expr_317_list.get(0);
		Assert.assertNotNull(AdditiveExpression_318_Var
		);
		final EList<? extends EObject> Expr_318_list = AdditiveExpression_318_Var
		.getExpr();
		Assert.assertNotNull(Expr_318_list);
		Assert.assertEquals(1, Expr_318_list.size());
		//318
		final MultiplicativeExpression MultiplicativeExpression_319_Var
		 = (MultiplicativeExpression)Expr_318_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_319_Var
		);
		final EList<? extends EObject> Expr_319_list = MultiplicativeExpression_319_Var
		.getExpr();
		Assert.assertNotNull(Expr_319_list);
		Assert.assertEquals(1, Expr_319_list.size());
		//319
		final CastExpression CastExpression_320_Var
		 = (CastExpression)Expr_319_list.get(0);
		Assert.assertNotNull(CastExpression_320_Var
		);
		//320
		final UnaryExpression UnaryExpression_321_Var
		 = (UnaryExpression)CastExpression_320_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_321_Var
		);
		//321
		final PostfixExpression PostfixExpression_322_Var
		 = (PostfixExpression)UnaryExpression_321_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_322_Var
		);
		final EList<? extends EObject> Expr_322_list = PostfixExpression_322_Var
		.getExpr();
		Assert.assertNotNull(Expr_322_list);
		Assert.assertEquals(1, Expr_322_list.size());
		//322
		final PrimaryExpression PrimaryExpression_323_Var
		 = (PrimaryExpression)Expr_322_list.get(0);
		Assert.assertNotNull(PrimaryExpression_323_Var
		);
		//323
		final Constant Constant_324_Var
		 = (Constant)PrimaryExpression_323_Var
		.getConst();
		Assert.assertNotNull(Constant_324_Var
		);
		Assert.assertEquals("\"Monday is %d. day of week\\n\"", Constant_324_Var
		.getStr());
		//324
		final AssignmentExpression AssignmentExpression_325_Var
		 = (AssignmentExpression)Expr_307_list.get(1);
		Assert.assertNotNull(AssignmentExpression_325_Var
		);
		//325
		final ConditionalExpression ConditionalExpression_326_Var
		 = (ConditionalExpression)AssignmentExpression_325_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_326_Var
		);
		//326
		final LogicalOrExpression LogicalOrExpression_327_Var
		 = (LogicalOrExpression)ConditionalExpression_326_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_327_Var
		);
		final EList<? extends EObject> Expr_327_list = LogicalOrExpression_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final LogicalAndExpression LogicalAndExpression_328_Var
		 = (LogicalAndExpression)Expr_327_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_328_Var
		);
		final EList<? extends EObject> Expr_328_list = LogicalAndExpression_328_Var
		.getExpr();
		Assert.assertNotNull(Expr_328_list);
		Assert.assertEquals(1, Expr_328_list.size());
		//328
		final InclusiveOrExpression InclusiveOrExpression_329_Var
		 = (InclusiveOrExpression)Expr_328_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_329_Var
		);
		final EList<? extends EObject> Expr_329_list = InclusiveOrExpression_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final ExclusiveOrExpression ExclusiveOrExpression_330_Var
		 = (ExclusiveOrExpression)Expr_329_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_330_Var
		);
		final EList<? extends EObject> Expr_330_list = ExclusiveOrExpression_330_Var
		.getExpr();
		Assert.assertNotNull(Expr_330_list);
		Assert.assertEquals(1, Expr_330_list.size());
		//330
		final AndExpression AndExpression_331_Var
		 = (AndExpression)Expr_330_list.get(0);
		Assert.assertNotNull(AndExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = AndExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final EqualityExpression EqualityExpression_332_Var
		 = (EqualityExpression)Expr_331_list.get(0);
		Assert.assertNotNull(EqualityExpression_332_Var
		);
		final EList<? extends EObject> Expr_332_list = EqualityExpression_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final RelationalExpression RelationalExpression_333_Var
		 = (RelationalExpression)Expr_332_list.get(0);
		Assert.assertNotNull(RelationalExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = RelationalExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final ShiftExpression ShiftExpression_334_Var
		 = (ShiftExpression)Expr_333_list.get(0);
		Assert.assertNotNull(ShiftExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = ShiftExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final AdditiveExpression AdditiveExpression_335_Var
		 = (AdditiveExpression)Expr_334_list.get(0);
		Assert.assertNotNull(AdditiveExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = AdditiveExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final MultiplicativeExpression MultiplicativeExpression_336_Var
		 = (MultiplicativeExpression)Expr_335_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = MultiplicativeExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final CastExpression CastExpression_337_Var
		 = (CastExpression)Expr_336_list.get(0);
		Assert.assertNotNull(CastExpression_337_Var
		);
		//337
		final UnaryExpression UnaryExpression_338_Var
		 = (UnaryExpression)CastExpression_337_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_338_Var
		);
		//338
		final PostfixExpression PostfixExpression_339_Var
		 = (PostfixExpression)UnaryExpression_338_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_339_Var
		);
		final EList<? extends EObject> Expr_339_list = PostfixExpression_339_Var
		.getExpr();
		Assert.assertNotNull(Expr_339_list);
		Assert.assertEquals(1, Expr_339_list.size());
		//339
		final PrimaryExpression PrimaryExpression_340_Var
		 = (PrimaryExpression)Expr_339_list.get(0);
		Assert.assertNotNull(PrimaryExpression_340_Var
		);
		Assert.assertEquals("W_MONDAY", PrimaryExpression_340_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_288_Var
		.getSemi());
		//340
		final Statement Statement_341_Var
		 = (Statement)Statement_286_list.get(1);
		Assert.assertNotNull(Statement_341_Var
		);
		//341
		final ExpressionStatement ExpressionStatement_342_Var
		 = (ExpressionStatement)Statement_341_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_342_Var
		);
		//342
		final Expression Expression_343_Var
		 = (Expression)ExpressionStatement_342_Var
		.getExpression();
		Assert.assertNotNull(Expression_343_Var
		);
		final EList<? extends EObject> ExprExpr_343_list = Expression_343_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_343_list);
		Assert.assertEquals(1, ExprExpr_343_list.size());
		//343
		final AssignmentExpression AssignmentExpression_344_Var
		 = (AssignmentExpression)ExprExpr_343_list.get(0);
		Assert.assertNotNull(AssignmentExpression_344_Var
		);
		//344
		final ConditionalExpression ConditionalExpression_345_Var
		 = (ConditionalExpression)AssignmentExpression_344_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_345_Var
		);
		//345
		final LogicalOrExpression LogicalOrExpression_346_Var
		 = (LogicalOrExpression)ConditionalExpression_345_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_346_Var
		);
		final EList<? extends EObject> Expr_346_list = LogicalOrExpression_346_Var
		.getExpr();
		Assert.assertNotNull(Expr_346_list);
		Assert.assertEquals(1, Expr_346_list.size());
		//346
		final LogicalAndExpression LogicalAndExpression_347_Var
		 = (LogicalAndExpression)Expr_346_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_347_Var
		);
		final EList<? extends EObject> Expr_347_list = LogicalAndExpression_347_Var
		.getExpr();
		Assert.assertNotNull(Expr_347_list);
		Assert.assertEquals(1, Expr_347_list.size());
		//347
		final InclusiveOrExpression InclusiveOrExpression_348_Var
		 = (InclusiveOrExpression)Expr_347_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_348_Var
		);
		final EList<? extends EObject> Expr_348_list = InclusiveOrExpression_348_Var
		.getExpr();
		Assert.assertNotNull(Expr_348_list);
		Assert.assertEquals(1, Expr_348_list.size());
		//348
		final ExclusiveOrExpression ExclusiveOrExpression_349_Var
		 = (ExclusiveOrExpression)Expr_348_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_349_Var
		);
		final EList<? extends EObject> Expr_349_list = ExclusiveOrExpression_349_Var
		.getExpr();
		Assert.assertNotNull(Expr_349_list);
		Assert.assertEquals(1, Expr_349_list.size());
		//349
		final AndExpression AndExpression_350_Var
		 = (AndExpression)Expr_349_list.get(0);
		Assert.assertNotNull(AndExpression_350_Var
		);
		final EList<? extends EObject> Expr_350_list = AndExpression_350_Var
		.getExpr();
		Assert.assertNotNull(Expr_350_list);
		Assert.assertEquals(1, Expr_350_list.size());
		//350
		final EqualityExpression EqualityExpression_351_Var
		 = (EqualityExpression)Expr_350_list.get(0);
		Assert.assertNotNull(EqualityExpression_351_Var
		);
		final EList<? extends EObject> Expr_351_list = EqualityExpression_351_Var
		.getExpr();
		Assert.assertNotNull(Expr_351_list);
		Assert.assertEquals(1, Expr_351_list.size());
		//351
		final RelationalExpression RelationalExpression_352_Var
		 = (RelationalExpression)Expr_351_list.get(0);
		Assert.assertNotNull(RelationalExpression_352_Var
		);
		final EList<? extends EObject> Expr_352_list = RelationalExpression_352_Var
		.getExpr();
		Assert.assertNotNull(Expr_352_list);
		Assert.assertEquals(1, Expr_352_list.size());
		//352
		final ShiftExpression ShiftExpression_353_Var
		 = (ShiftExpression)Expr_352_list.get(0);
		Assert.assertNotNull(ShiftExpression_353_Var
		);
		final EList<? extends EObject> Expr_353_list = ShiftExpression_353_Var
		.getExpr();
		Assert.assertNotNull(Expr_353_list);
		Assert.assertEquals(1, Expr_353_list.size());
		//353
		final AdditiveExpression AdditiveExpression_354_Var
		 = (AdditiveExpression)Expr_353_list.get(0);
		Assert.assertNotNull(AdditiveExpression_354_Var
		);
		final EList<? extends EObject> Expr_354_list = AdditiveExpression_354_Var
		.getExpr();
		Assert.assertNotNull(Expr_354_list);
		Assert.assertEquals(1, Expr_354_list.size());
		//354
		final MultiplicativeExpression MultiplicativeExpression_355_Var
		 = (MultiplicativeExpression)Expr_354_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_355_Var
		);
		final EList<? extends EObject> Expr_355_list = MultiplicativeExpression_355_Var
		.getExpr();
		Assert.assertNotNull(Expr_355_list);
		Assert.assertEquals(1, Expr_355_list.size());
		//355
		final CastExpression CastExpression_356_Var
		 = (CastExpression)Expr_355_list.get(0);
		Assert.assertNotNull(CastExpression_356_Var
		);
		//356
		final UnaryExpression UnaryExpression_357_Var
		 = (UnaryExpression)CastExpression_356_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_357_Var
		);
		//357
		final PostfixExpression PostfixExpression_358_Var
		 = (PostfixExpression)UnaryExpression_357_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_358_Var
		);
		final EList<? extends EObject> Expr_358_list = PostfixExpression_358_Var
		.getExpr();
		Assert.assertNotNull(Expr_358_list);
		Assert.assertEquals(1, Expr_358_list.size());
		//358
		final PrimaryExpression PrimaryExpression_359_Var
		 = (PrimaryExpression)Expr_358_list.get(0);
		Assert.assertNotNull(PrimaryExpression_359_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_359_Var
		.getId());
		final EList<? extends EObject> Suffix_359_list = PostfixExpression_358_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_359_list);
		Assert.assertEquals(1, Suffix_359_list.size());
		//359
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_360_Var
		 = (PostfixExpressionSuffixArgument)Suffix_359_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_360_Var
		);
		//360
		final ArgumentExpressionList ArgumentExpressionList_361_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_360_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_361_Var
		);
		final EList<? extends EObject> Expr_361_list = ArgumentExpressionList_361_Var
		.getExpr();
		Assert.assertNotNull(Expr_361_list);
		Assert.assertEquals(2, Expr_361_list.size());
		//361
		final AssignmentExpression AssignmentExpression_362_Var
		 = (AssignmentExpression)Expr_361_list.get(0);
		Assert.assertNotNull(AssignmentExpression_362_Var
		);
		//362
		final ConditionalExpression ConditionalExpression_363_Var
		 = (ConditionalExpression)AssignmentExpression_362_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_363_Var
		);
		//363
		final LogicalOrExpression LogicalOrExpression_364_Var
		 = (LogicalOrExpression)ConditionalExpression_363_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_364_Var
		);
		final EList<? extends EObject> Expr_364_list = LogicalOrExpression_364_Var
		.getExpr();
		Assert.assertNotNull(Expr_364_list);
		Assert.assertEquals(1, Expr_364_list.size());
		//364
		final LogicalAndExpression LogicalAndExpression_365_Var
		 = (LogicalAndExpression)Expr_364_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = LogicalAndExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final InclusiveOrExpression InclusiveOrExpression_366_Var
		 = (InclusiveOrExpression)Expr_365_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_366_Var
		);
		final EList<? extends EObject> Expr_366_list = InclusiveOrExpression_366_Var
		.getExpr();
		Assert.assertNotNull(Expr_366_list);
		Assert.assertEquals(1, Expr_366_list.size());
		//366
		final ExclusiveOrExpression ExclusiveOrExpression_367_Var
		 = (ExclusiveOrExpression)Expr_366_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_367_Var
		);
		final EList<? extends EObject> Expr_367_list = ExclusiveOrExpression_367_Var
		.getExpr();
		Assert.assertNotNull(Expr_367_list);
		Assert.assertEquals(1, Expr_367_list.size());
		//367
		final AndExpression AndExpression_368_Var
		 = (AndExpression)Expr_367_list.get(0);
		Assert.assertNotNull(AndExpression_368_Var
		);
		final EList<? extends EObject> Expr_368_list = AndExpression_368_Var
		.getExpr();
		Assert.assertNotNull(Expr_368_list);
		Assert.assertEquals(1, Expr_368_list.size());
		//368
		final EqualityExpression EqualityExpression_369_Var
		 = (EqualityExpression)Expr_368_list.get(0);
		Assert.assertNotNull(EqualityExpression_369_Var
		);
		final EList<? extends EObject> Expr_369_list = EqualityExpression_369_Var
		.getExpr();
		Assert.assertNotNull(Expr_369_list);
		Assert.assertEquals(1, Expr_369_list.size());
		//369
		final RelationalExpression RelationalExpression_370_Var
		 = (RelationalExpression)Expr_369_list.get(0);
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
		//377
		final Constant Constant_378_Var
		 = (Constant)PrimaryExpression_377_Var
		.getConst();
		Assert.assertNotNull(Constant_378_Var
		);
		Assert.assertEquals("\"Monday is %d. day of week\\n\"", Constant_378_Var
		.getStr());
		//378
		final AssignmentExpression AssignmentExpression_379_Var
		 = (AssignmentExpression)Expr_361_list.get(1);
		Assert.assertNotNull(AssignmentExpression_379_Var
		);
		//379
		final ConditionalExpression ConditionalExpression_380_Var
		 = (ConditionalExpression)AssignmentExpression_379_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_380_Var
		);
		//380
		final LogicalOrExpression LogicalOrExpression_381_Var
		 = (LogicalOrExpression)ConditionalExpression_380_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_381_Var
		);
		final EList<? extends EObject> Expr_381_list = LogicalOrExpression_381_Var
		.getExpr();
		Assert.assertNotNull(Expr_381_list);
		Assert.assertEquals(1, Expr_381_list.size());
		//381
		final LogicalAndExpression LogicalAndExpression_382_Var
		 = (LogicalAndExpression)Expr_381_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_382_Var
		);
		final EList<? extends EObject> Expr_382_list = LogicalAndExpression_382_Var
		.getExpr();
		Assert.assertNotNull(Expr_382_list);
		Assert.assertEquals(1, Expr_382_list.size());
		//382
		final InclusiveOrExpression InclusiveOrExpression_383_Var
		 = (InclusiveOrExpression)Expr_382_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_383_Var
		);
		final EList<? extends EObject> Expr_383_list = InclusiveOrExpression_383_Var
		.getExpr();
		Assert.assertNotNull(Expr_383_list);
		Assert.assertEquals(1, Expr_383_list.size());
		//383
		final ExclusiveOrExpression ExclusiveOrExpression_384_Var
		 = (ExclusiveOrExpression)Expr_383_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_384_Var
		);
		final EList<? extends EObject> Expr_384_list = ExclusiveOrExpression_384_Var
		.getExpr();
		Assert.assertNotNull(Expr_384_list);
		Assert.assertEquals(1, Expr_384_list.size());
		//384
		final AndExpression AndExpression_385_Var
		 = (AndExpression)Expr_384_list.get(0);
		Assert.assertNotNull(AndExpression_385_Var
		);
		final EList<? extends EObject> Expr_385_list = AndExpression_385_Var
		.getExpr();
		Assert.assertNotNull(Expr_385_list);
		Assert.assertEquals(1, Expr_385_list.size());
		//385
		final EqualityExpression EqualityExpression_386_Var
		 = (EqualityExpression)Expr_385_list.get(0);
		Assert.assertNotNull(EqualityExpression_386_Var
		);
		final EList<? extends EObject> Expr_386_list = EqualityExpression_386_Var
		.getExpr();
		Assert.assertNotNull(Expr_386_list);
		Assert.assertEquals(1, Expr_386_list.size());
		//386
		final RelationalExpression RelationalExpression_387_Var
		 = (RelationalExpression)Expr_386_list.get(0);
		Assert.assertNotNull(RelationalExpression_387_Var
		);
		final EList<? extends EObject> Expr_387_list = RelationalExpression_387_Var
		.getExpr();
		Assert.assertNotNull(Expr_387_list);
		Assert.assertEquals(1, Expr_387_list.size());
		//387
		final ShiftExpression ShiftExpression_388_Var
		 = (ShiftExpression)Expr_387_list.get(0);
		Assert.assertNotNull(ShiftExpression_388_Var
		);
		final EList<? extends EObject> Expr_388_list = ShiftExpression_388_Var
		.getExpr();
		Assert.assertNotNull(Expr_388_list);
		Assert.assertEquals(1, Expr_388_list.size());
		//388
		final AdditiveExpression AdditiveExpression_389_Var
		 = (AdditiveExpression)Expr_388_list.get(0);
		Assert.assertNotNull(AdditiveExpression_389_Var
		);
		final EList<? extends EObject> Expr_389_list = AdditiveExpression_389_Var
		.getExpr();
		Assert.assertNotNull(Expr_389_list);
		Assert.assertEquals(1, Expr_389_list.size());
		//389
		final MultiplicativeExpression MultiplicativeExpression_390_Var
		 = (MultiplicativeExpression)Expr_389_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_390_Var
		);
		final EList<? extends EObject> Expr_390_list = MultiplicativeExpression_390_Var
		.getExpr();
		Assert.assertNotNull(Expr_390_list);
		Assert.assertEquals(1, Expr_390_list.size());
		//390
		final CastExpression CastExpression_391_Var
		 = (CastExpression)Expr_390_list.get(0);
		Assert.assertNotNull(CastExpression_391_Var
		);
		//391
		final UnaryExpression UnaryExpression_392_Var
		 = (UnaryExpression)CastExpression_391_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_392_Var
		);
		//392
		final PostfixExpression PostfixExpression_393_Var
		 = (PostfixExpression)UnaryExpression_392_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_393_Var
		);
		final EList<? extends EObject> Expr_393_list = PostfixExpression_393_Var
		.getExpr();
		Assert.assertNotNull(Expr_393_list);
		Assert.assertEquals(1, Expr_393_list.size());
		//393
		final PrimaryExpression PrimaryExpression_394_Var
		 = (PrimaryExpression)Expr_393_list.get(0);
		Assert.assertNotNull(PrimaryExpression_394_Var
		);
		Assert.assertEquals("MONDAY", PrimaryExpression_394_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_342_Var
		.getSemi());
		//394
		final Statement Statement_395_Var
		 = (Statement)Statement_286_list.get(2);
		Assert.assertNotNull(Statement_395_Var
		);
		//395
		final ExpressionStatement ExpressionStatement_396_Var
		 = (ExpressionStatement)Statement_395_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_396_Var
		);
		//396
		final Expression Expression_397_Var
		 = (Expression)ExpressionStatement_396_Var
		.getExpression();
		Assert.assertNotNull(Expression_397_Var
		);
		final EList<? extends EObject> ExprExpr_397_list = Expression_397_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_397_list);
		Assert.assertEquals(1, ExprExpr_397_list.size());
		//397
		final AssignmentExpression AssignmentExpression_398_Var
		 = (AssignmentExpression)ExprExpr_397_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_413_Var
		.getId());
		final EList<? extends EObject> Suffix_413_list = PostfixExpression_412_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_413_list);
		Assert.assertEquals(1, Suffix_413_list.size());
		//413
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_414_Var
		 = (PostfixExpressionSuffixArgument)Suffix_413_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_414_Var
		);
		//414
		final ArgumentExpressionList ArgumentExpressionList_415_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_414_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_415_Var
		);
		final EList<? extends EObject> Expr_415_list = ArgumentExpressionList_415_Var
		.getExpr();
		Assert.assertNotNull(Expr_415_list);
		Assert.assertEquals(2, Expr_415_list.size());
		//415
		final AssignmentExpression AssignmentExpression_416_Var
		 = (AssignmentExpression)Expr_415_list.get(0);
		Assert.assertNotNull(AssignmentExpression_416_Var
		);
		//416
		final ConditionalExpression ConditionalExpression_417_Var
		 = (ConditionalExpression)AssignmentExpression_416_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_417_Var
		);
		//417
		final LogicalOrExpression LogicalOrExpression_418_Var
		 = (LogicalOrExpression)ConditionalExpression_417_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_418_Var
		);
		final EList<? extends EObject> Expr_418_list = LogicalOrExpression_418_Var
		.getExpr();
		Assert.assertNotNull(Expr_418_list);
		Assert.assertEquals(1, Expr_418_list.size());
		//418
		final LogicalAndExpression LogicalAndExpression_419_Var
		 = (LogicalAndExpression)Expr_418_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_419_Var
		);
		final EList<? extends EObject> Expr_419_list = LogicalAndExpression_419_Var
		.getExpr();
		Assert.assertNotNull(Expr_419_list);
		Assert.assertEquals(1, Expr_419_list.size());
		//419
		final InclusiveOrExpression InclusiveOrExpression_420_Var
		 = (InclusiveOrExpression)Expr_419_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_420_Var
		);
		final EList<? extends EObject> Expr_420_list = InclusiveOrExpression_420_Var
		.getExpr();
		Assert.assertNotNull(Expr_420_list);
		Assert.assertEquals(1, Expr_420_list.size());
		//420
		final ExclusiveOrExpression ExclusiveOrExpression_421_Var
		 = (ExclusiveOrExpression)Expr_420_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_421_Var
		);
		final EList<? extends EObject> Expr_421_list = ExclusiveOrExpression_421_Var
		.getExpr();
		Assert.assertNotNull(Expr_421_list);
		Assert.assertEquals(1, Expr_421_list.size());
		//421
		final AndExpression AndExpression_422_Var
		 = (AndExpression)Expr_421_list.get(0);
		Assert.assertNotNull(AndExpression_422_Var
		);
		final EList<? extends EObject> Expr_422_list = AndExpression_422_Var
		.getExpr();
		Assert.assertNotNull(Expr_422_list);
		Assert.assertEquals(1, Expr_422_list.size());
		//422
		final EqualityExpression EqualityExpression_423_Var
		 = (EqualityExpression)Expr_422_list.get(0);
		Assert.assertNotNull(EqualityExpression_423_Var
		);
		final EList<? extends EObject> Expr_423_list = EqualityExpression_423_Var
		.getExpr();
		Assert.assertNotNull(Expr_423_list);
		Assert.assertEquals(1, Expr_423_list.size());
		//423
		final RelationalExpression RelationalExpression_424_Var
		 = (RelationalExpression)Expr_423_list.get(0);
		Assert.assertNotNull(RelationalExpression_424_Var
		);
		final EList<? extends EObject> Expr_424_list = RelationalExpression_424_Var
		.getExpr();
		Assert.assertNotNull(Expr_424_list);
		Assert.assertEquals(1, Expr_424_list.size());
		//424
		final ShiftExpression ShiftExpression_425_Var
		 = (ShiftExpression)Expr_424_list.get(0);
		Assert.assertNotNull(ShiftExpression_425_Var
		);
		final EList<? extends EObject> Expr_425_list = ShiftExpression_425_Var
		.getExpr();
		Assert.assertNotNull(Expr_425_list);
		Assert.assertEquals(1, Expr_425_list.size());
		//425
		final AdditiveExpression AdditiveExpression_426_Var
		 = (AdditiveExpression)Expr_425_list.get(0);
		Assert.assertNotNull(AdditiveExpression_426_Var
		);
		final EList<? extends EObject> Expr_426_list = AdditiveExpression_426_Var
		.getExpr();
		Assert.assertNotNull(Expr_426_list);
		Assert.assertEquals(1, Expr_426_list.size());
		//426
		final MultiplicativeExpression MultiplicativeExpression_427_Var
		 = (MultiplicativeExpression)Expr_426_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_427_Var
		);
		final EList<? extends EObject> Expr_427_list = MultiplicativeExpression_427_Var
		.getExpr();
		Assert.assertNotNull(Expr_427_list);
		Assert.assertEquals(1, Expr_427_list.size());
		//427
		final CastExpression CastExpression_428_Var
		 = (CastExpression)Expr_427_list.get(0);
		Assert.assertNotNull(CastExpression_428_Var
		);
		//428
		final UnaryExpression UnaryExpression_429_Var
		 = (UnaryExpression)CastExpression_428_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_429_Var
		);
		//429
		final PostfixExpression PostfixExpression_430_Var
		 = (PostfixExpression)UnaryExpression_429_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_430_Var
		);
		final EList<? extends EObject> Expr_430_list = PostfixExpression_430_Var
		.getExpr();
		Assert.assertNotNull(Expr_430_list);
		Assert.assertEquals(1, Expr_430_list.size());
		//430
		final PrimaryExpression PrimaryExpression_431_Var
		 = (PrimaryExpression)Expr_430_list.get(0);
		Assert.assertNotNull(PrimaryExpression_431_Var
		);
		//431
		final Constant Constant_432_Var
		 = (Constant)PrimaryExpression_431_Var
		.getConst();
		Assert.assertNotNull(Constant_432_Var
		);
		Assert.assertEquals("\"Sunday is %d. day of week\\n\"", Constant_432_Var
		.getStr());
		//432
		final AssignmentExpression AssignmentExpression_433_Var
		 = (AssignmentExpression)Expr_415_list.get(1);
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
		Assert.assertEquals("W_SUNDAY", PrimaryExpression_448_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_396_Var
		.getSemi());
		//448
		final Statement Statement_449_Var
		 = (Statement)Statement_286_list.get(3);
		Assert.assertNotNull(Statement_449_Var
		);
		//449
		final ExpressionStatement ExpressionStatement_450_Var
		 = (ExpressionStatement)Statement_449_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_450_Var
		);
		//450
		final Expression Expression_451_Var
		 = (Expression)ExpressionStatement_450_Var
		.getExpression();
		Assert.assertNotNull(Expression_451_Var
		);
		final EList<? extends EObject> ExprExpr_451_list = Expression_451_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_451_list);
		Assert.assertEquals(1, ExprExpr_451_list.size());
		//451
		final AssignmentExpression AssignmentExpression_452_Var
		 = (AssignmentExpression)ExprExpr_451_list.get(0);
		Assert.assertNotNull(AssignmentExpression_452_Var
		);
		//452
		final ConditionalExpression ConditionalExpression_453_Var
		 = (ConditionalExpression)AssignmentExpression_452_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_453_Var
		);
		//453
		final LogicalOrExpression LogicalOrExpression_454_Var
		 = (LogicalOrExpression)ConditionalExpression_453_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_454_Var
		);
		final EList<? extends EObject> Expr_454_list = LogicalOrExpression_454_Var
		.getExpr();
		Assert.assertNotNull(Expr_454_list);
		Assert.assertEquals(1, Expr_454_list.size());
		//454
		final LogicalAndExpression LogicalAndExpression_455_Var
		 = (LogicalAndExpression)Expr_454_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_455_Var
		);
		final EList<? extends EObject> Expr_455_list = LogicalAndExpression_455_Var
		.getExpr();
		Assert.assertNotNull(Expr_455_list);
		Assert.assertEquals(1, Expr_455_list.size());
		//455
		final InclusiveOrExpression InclusiveOrExpression_456_Var
		 = (InclusiveOrExpression)Expr_455_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_456_Var
		);
		final EList<? extends EObject> Expr_456_list = InclusiveOrExpression_456_Var
		.getExpr();
		Assert.assertNotNull(Expr_456_list);
		Assert.assertEquals(1, Expr_456_list.size());
		//456
		final ExclusiveOrExpression ExclusiveOrExpression_457_Var
		 = (ExclusiveOrExpression)Expr_456_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_457_Var
		);
		final EList<? extends EObject> Expr_457_list = ExclusiveOrExpression_457_Var
		.getExpr();
		Assert.assertNotNull(Expr_457_list);
		Assert.assertEquals(1, Expr_457_list.size());
		//457
		final AndExpression AndExpression_458_Var
		 = (AndExpression)Expr_457_list.get(0);
		Assert.assertNotNull(AndExpression_458_Var
		);
		final EList<? extends EObject> Expr_458_list = AndExpression_458_Var
		.getExpr();
		Assert.assertNotNull(Expr_458_list);
		Assert.assertEquals(1, Expr_458_list.size());
		//458
		final EqualityExpression EqualityExpression_459_Var
		 = (EqualityExpression)Expr_458_list.get(0);
		Assert.assertNotNull(EqualityExpression_459_Var
		);
		final EList<? extends EObject> Expr_459_list = EqualityExpression_459_Var
		.getExpr();
		Assert.assertNotNull(Expr_459_list);
		Assert.assertEquals(1, Expr_459_list.size());
		//459
		final RelationalExpression RelationalExpression_460_Var
		 = (RelationalExpression)Expr_459_list.get(0);
		Assert.assertNotNull(RelationalExpression_460_Var
		);
		final EList<? extends EObject> Expr_460_list = RelationalExpression_460_Var
		.getExpr();
		Assert.assertNotNull(Expr_460_list);
		Assert.assertEquals(1, Expr_460_list.size());
		//460
		final ShiftExpression ShiftExpression_461_Var
		 = (ShiftExpression)Expr_460_list.get(0);
		Assert.assertNotNull(ShiftExpression_461_Var
		);
		final EList<? extends EObject> Expr_461_list = ShiftExpression_461_Var
		.getExpr();
		Assert.assertNotNull(Expr_461_list);
		Assert.assertEquals(1, Expr_461_list.size());
		//461
		final AdditiveExpression AdditiveExpression_462_Var
		 = (AdditiveExpression)Expr_461_list.get(0);
		Assert.assertNotNull(AdditiveExpression_462_Var
		);
		final EList<? extends EObject> Expr_462_list = AdditiveExpression_462_Var
		.getExpr();
		Assert.assertNotNull(Expr_462_list);
		Assert.assertEquals(1, Expr_462_list.size());
		//462
		final MultiplicativeExpression MultiplicativeExpression_463_Var
		 = (MultiplicativeExpression)Expr_462_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_463_Var
		);
		final EList<? extends EObject> Expr_463_list = MultiplicativeExpression_463_Var
		.getExpr();
		Assert.assertNotNull(Expr_463_list);
		Assert.assertEquals(1, Expr_463_list.size());
		//463
		final CastExpression CastExpression_464_Var
		 = (CastExpression)Expr_463_list.get(0);
		Assert.assertNotNull(CastExpression_464_Var
		);
		//464
		final UnaryExpression UnaryExpression_465_Var
		 = (UnaryExpression)CastExpression_464_Var
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
		Assert.assertEquals("printf", PrimaryExpression_467_Var
		.getId());
		final EList<? extends EObject> Suffix_467_list = PostfixExpression_466_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_467_list);
		Assert.assertEquals(1, Suffix_467_list.size());
		//467
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_468_Var
		 = (PostfixExpressionSuffixArgument)Suffix_467_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_468_Var
		);
		//468
		final ArgumentExpressionList ArgumentExpressionList_469_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_468_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_469_Var
		);
		final EList<? extends EObject> Expr_469_list = ArgumentExpressionList_469_Var
		.getExpr();
		Assert.assertNotNull(Expr_469_list);
		Assert.assertEquals(2, Expr_469_list.size());
		//469
		final AssignmentExpression AssignmentExpression_470_Var
		 = (AssignmentExpression)Expr_469_list.get(0);
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
		final Constant Constant_486_Var
		 = (Constant)PrimaryExpression_485_Var
		.getConst();
		Assert.assertNotNull(Constant_486_Var
		);
		Assert.assertEquals("\"Sunday is %d. day of week\\n\"", Constant_486_Var
		.getStr());
		//486
		final AssignmentExpression AssignmentExpression_487_Var
		 = (AssignmentExpression)Expr_469_list.get(1);
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
		Assert.assertEquals("SUNDAY", PrimaryExpression_502_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_450_Var
		.getSemi());
		//502
		final Statement Statement_503_Var
		 = (Statement)Statement_286_list.get(4);
		Assert.assertNotNull(Statement_503_Var
		);
		//503
		final ExpressionStatement ExpressionStatement_504_Var
		 = (ExpressionStatement)Statement_503_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_504_Var
		);
		//504
		final Expression Expression_505_Var
		 = (Expression)ExpressionStatement_504_Var
		.getExpression();
		Assert.assertNotNull(Expression_505_Var
		);
		final EList<? extends EObject> ExprExpr_505_list = Expression_505_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_505_list);
		Assert.assertEquals(1, ExprExpr_505_list.size());
		//505
		final AssignmentExpression AssignmentExpression_506_Var
		 = (AssignmentExpression)ExprExpr_505_list.get(0);
		Assert.assertNotNull(AssignmentExpression_506_Var
		);
		//506
		final UnaryExpression UnaryExpression_507_Var
		 = (UnaryExpression)AssignmentExpression_506_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_507_Var
		);
		//507
		final PostfixExpression PostfixExpression_508_Var
		 = (PostfixExpression)UnaryExpression_507_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_508_Var
		);
		final EList<? extends EObject> Expr_508_list = PostfixExpression_508_Var
		.getExpr();
		Assert.assertNotNull(Expr_508_list);
		Assert.assertEquals(1, Expr_508_list.size());
		//508
		final PrimaryExpression PrimaryExpression_509_Var
		 = (PrimaryExpression)Expr_508_list.get(0);
		Assert.assertNotNull(PrimaryExpression_509_Var
		);
		Assert.assertEquals("iAmInLove", PrimaryExpression_509_Var
		.getId());
		//509
		final AssignmentOperator AssignmentOperator_510_Var
		 = (AssignmentOperator)AssignmentExpression_506_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_510_Var
		);
		Assert.assertEquals("=", AssignmentOperator_510_Var
		.getOp());
		//510
		final AssignmentExpression AssignmentExpression_511_Var
		 = (AssignmentExpression)AssignmentExpression_506_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_511_Var
		);
		//511
		final ConditionalExpression ConditionalExpression_512_Var
		 = (ConditionalExpression)AssignmentExpression_511_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_512_Var
		);
		//512
		final LogicalOrExpression LogicalOrExpression_513_Var
		 = (LogicalOrExpression)ConditionalExpression_512_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_513_Var
		);
		final EList<? extends EObject> Expr_513_list = LogicalOrExpression_513_Var
		.getExpr();
		Assert.assertNotNull(Expr_513_list);
		Assert.assertEquals(1, Expr_513_list.size());
		//513
		final LogicalAndExpression LogicalAndExpression_514_Var
		 = (LogicalAndExpression)Expr_513_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_514_Var
		);
		final EList<? extends EObject> Expr_514_list = LogicalAndExpression_514_Var
		.getExpr();
		Assert.assertNotNull(Expr_514_list);
		Assert.assertEquals(1, Expr_514_list.size());
		//514
		final InclusiveOrExpression InclusiveOrExpression_515_Var
		 = (InclusiveOrExpression)Expr_514_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_515_Var
		);
		final EList<? extends EObject> Expr_515_list = InclusiveOrExpression_515_Var
		.getExpr();
		Assert.assertNotNull(Expr_515_list);
		Assert.assertEquals(1, Expr_515_list.size());
		//515
		final ExclusiveOrExpression ExclusiveOrExpression_516_Var
		 = (ExclusiveOrExpression)Expr_515_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_516_Var
		);
		final EList<? extends EObject> Expr_516_list = ExclusiveOrExpression_516_Var
		.getExpr();
		Assert.assertNotNull(Expr_516_list);
		Assert.assertEquals(1, Expr_516_list.size());
		//516
		final AndExpression AndExpression_517_Var
		 = (AndExpression)Expr_516_list.get(0);
		Assert.assertNotNull(AndExpression_517_Var
		);
		final EList<? extends EObject> Expr_517_list = AndExpression_517_Var
		.getExpr();
		Assert.assertNotNull(Expr_517_list);
		Assert.assertEquals(1, Expr_517_list.size());
		//517
		final EqualityExpression EqualityExpression_518_Var
		 = (EqualityExpression)Expr_517_list.get(0);
		Assert.assertNotNull(EqualityExpression_518_Var
		);
		final EList<? extends EObject> Expr_518_list = EqualityExpression_518_Var
		.getExpr();
		Assert.assertNotNull(Expr_518_list);
		Assert.assertEquals(1, Expr_518_list.size());
		//518
		final RelationalExpression RelationalExpression_519_Var
		 = (RelationalExpression)Expr_518_list.get(0);
		Assert.assertNotNull(RelationalExpression_519_Var
		);
		final EList<? extends EObject> Expr_519_list = RelationalExpression_519_Var
		.getExpr();
		Assert.assertNotNull(Expr_519_list);
		Assert.assertEquals(1, Expr_519_list.size());
		//519
		final ShiftExpression ShiftExpression_520_Var
		 = (ShiftExpression)Expr_519_list.get(0);
		Assert.assertNotNull(ShiftExpression_520_Var
		);
		final EList<? extends EObject> Expr_520_list = ShiftExpression_520_Var
		.getExpr();
		Assert.assertNotNull(Expr_520_list);
		Assert.assertEquals(1, Expr_520_list.size());
		//520
		final AdditiveExpression AdditiveExpression_521_Var
		 = (AdditiveExpression)Expr_520_list.get(0);
		Assert.assertNotNull(AdditiveExpression_521_Var
		);
		final EList<? extends EObject> Expr_521_list = AdditiveExpression_521_Var
		.getExpr();
		Assert.assertNotNull(Expr_521_list);
		Assert.assertEquals(1, Expr_521_list.size());
		//521
		final MultiplicativeExpression MultiplicativeExpression_522_Var
		 = (MultiplicativeExpression)Expr_521_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_522_Var
		);
		final EList<? extends EObject> Expr_522_list = MultiplicativeExpression_522_Var
		.getExpr();
		Assert.assertNotNull(Expr_522_list);
		Assert.assertEquals(1, Expr_522_list.size());
		//522
		final CastExpression CastExpression_523_Var
		 = (CastExpression)Expr_522_list.get(0);
		Assert.assertNotNull(CastExpression_523_Var
		);
		//523
		final UnaryExpression UnaryExpression_524_Var
		 = (UnaryExpression)CastExpression_523_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_524_Var
		);
		//524
		final PostfixExpression PostfixExpression_525_Var
		 = (PostfixExpression)UnaryExpression_524_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_525_Var
		);
		final EList<? extends EObject> Expr_525_list = PostfixExpression_525_Var
		.getExpr();
		Assert.assertNotNull(Expr_525_list);
		Assert.assertEquals(1, Expr_525_list.size());
		//525
		final PrimaryExpression PrimaryExpression_526_Var
		 = (PrimaryExpression)Expr_525_list.get(0);
		Assert.assertNotNull(PrimaryExpression_526_Var
		);
		Assert.assertEquals("I_FRIDAY", PrimaryExpression_526_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_504_Var
		.getSemi());
		//526
		final Statement Statement_527_Var
		 = (Statement)Statement_286_list.get(5);
		Assert.assertNotNull(Statement_527_Var
		);
		//527
		final ExpressionStatement ExpressionStatement_528_Var
		 = (ExpressionStatement)Statement_527_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_528_Var
		);
		//528
		final Expression Expression_529_Var
		 = (Expression)ExpressionStatement_528_Var
		.getExpression();
		Assert.assertNotNull(Expression_529_Var
		);
		final EList<? extends EObject> ExprExpr_529_list = Expression_529_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_529_list);
		Assert.assertEquals(1, ExprExpr_529_list.size());
		//529
		final AssignmentExpression AssignmentExpression_530_Var
		 = (AssignmentExpression)ExprExpr_529_list.get(0);
		Assert.assertNotNull(AssignmentExpression_530_Var
		);
		//530
		final ConditionalExpression ConditionalExpression_531_Var
		 = (ConditionalExpression)AssignmentExpression_530_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_531_Var
		);
		//531
		final LogicalOrExpression LogicalOrExpression_532_Var
		 = (LogicalOrExpression)ConditionalExpression_531_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_532_Var
		);
		final EList<? extends EObject> Expr_532_list = LogicalOrExpression_532_Var
		.getExpr();
		Assert.assertNotNull(Expr_532_list);
		Assert.assertEquals(1, Expr_532_list.size());
		//532
		final LogicalAndExpression LogicalAndExpression_533_Var
		 = (LogicalAndExpression)Expr_532_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_533_Var
		);
		final EList<? extends EObject> Expr_533_list = LogicalAndExpression_533_Var
		.getExpr();
		Assert.assertNotNull(Expr_533_list);
		Assert.assertEquals(1, Expr_533_list.size());
		//533
		final InclusiveOrExpression InclusiveOrExpression_534_Var
		 = (InclusiveOrExpression)Expr_533_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_534_Var
		);
		final EList<? extends EObject> Expr_534_list = InclusiveOrExpression_534_Var
		.getExpr();
		Assert.assertNotNull(Expr_534_list);
		Assert.assertEquals(1, Expr_534_list.size());
		//534
		final ExclusiveOrExpression ExclusiveOrExpression_535_Var
		 = (ExclusiveOrExpression)Expr_534_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_535_Var
		);
		final EList<? extends EObject> Expr_535_list = ExclusiveOrExpression_535_Var
		.getExpr();
		Assert.assertNotNull(Expr_535_list);
		Assert.assertEquals(1, Expr_535_list.size());
		//535
		final AndExpression AndExpression_536_Var
		 = (AndExpression)Expr_535_list.get(0);
		Assert.assertNotNull(AndExpression_536_Var
		);
		final EList<? extends EObject> Expr_536_list = AndExpression_536_Var
		.getExpr();
		Assert.assertNotNull(Expr_536_list);
		Assert.assertEquals(1, Expr_536_list.size());
		//536
		final EqualityExpression EqualityExpression_537_Var
		 = (EqualityExpression)Expr_536_list.get(0);
		Assert.assertNotNull(EqualityExpression_537_Var
		);
		final EList<? extends EObject> Expr_537_list = EqualityExpression_537_Var
		.getExpr();
		Assert.assertNotNull(Expr_537_list);
		Assert.assertEquals(1, Expr_537_list.size());
		//537
		final RelationalExpression RelationalExpression_538_Var
		 = (RelationalExpression)Expr_537_list.get(0);
		Assert.assertNotNull(RelationalExpression_538_Var
		);
		final EList<? extends EObject> Expr_538_list = RelationalExpression_538_Var
		.getExpr();
		Assert.assertNotNull(Expr_538_list);
		Assert.assertEquals(1, Expr_538_list.size());
		//538
		final ShiftExpression ShiftExpression_539_Var
		 = (ShiftExpression)Expr_538_list.get(0);
		Assert.assertNotNull(ShiftExpression_539_Var
		);
		final EList<? extends EObject> Expr_539_list = ShiftExpression_539_Var
		.getExpr();
		Assert.assertNotNull(Expr_539_list);
		Assert.assertEquals(1, Expr_539_list.size());
		//539
		final AdditiveExpression AdditiveExpression_540_Var
		 = (AdditiveExpression)Expr_539_list.get(0);
		Assert.assertNotNull(AdditiveExpression_540_Var
		);
		final EList<? extends EObject> Expr_540_list = AdditiveExpression_540_Var
		.getExpr();
		Assert.assertNotNull(Expr_540_list);
		Assert.assertEquals(1, Expr_540_list.size());
		//540
		final MultiplicativeExpression MultiplicativeExpression_541_Var
		 = (MultiplicativeExpression)Expr_540_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_541_Var
		);
		final EList<? extends EObject> Expr_541_list = MultiplicativeExpression_541_Var
		.getExpr();
		Assert.assertNotNull(Expr_541_list);
		Assert.assertEquals(1, Expr_541_list.size());
		//541
		final CastExpression CastExpression_542_Var
		 = (CastExpression)Expr_541_list.get(0);
		Assert.assertNotNull(CastExpression_542_Var
		);
		//542
		final UnaryExpression UnaryExpression_543_Var
		 = (UnaryExpression)CastExpression_542_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_543_Var
		);
		//543
		final PostfixExpression PostfixExpression_544_Var
		 = (PostfixExpression)UnaryExpression_543_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_544_Var
		);
		final EList<? extends EObject> Expr_544_list = PostfixExpression_544_Var
		.getExpr();
		Assert.assertNotNull(Expr_544_list);
		Assert.assertEquals(1, Expr_544_list.size());
		//544
		final PrimaryExpression PrimaryExpression_545_Var
		 = (PrimaryExpression)Expr_544_list.get(0);
		Assert.assertNotNull(PrimaryExpression_545_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_545_Var
		.getId());
		final EList<? extends EObject> Suffix_545_list = PostfixExpression_544_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_545_list);
		Assert.assertEquals(1, Suffix_545_list.size());
		//545
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_546_Var
		 = (PostfixExpressionSuffixArgument)Suffix_545_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_546_Var
		);
		//546
		final ArgumentExpressionList ArgumentExpressionList_547_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_546_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_547_Var
		);
		final EList<? extends EObject> Expr_547_list = ArgumentExpressionList_547_Var
		.getExpr();
		Assert.assertNotNull(Expr_547_list);
		Assert.assertEquals(2, Expr_547_list.size());
		//547
		final AssignmentExpression AssignmentExpression_548_Var
		 = (AssignmentExpression)Expr_547_list.get(0);
		Assert.assertNotNull(AssignmentExpression_548_Var
		);
		//548
		final ConditionalExpression ConditionalExpression_549_Var
		 = (ConditionalExpression)AssignmentExpression_548_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_549_Var
		);
		//549
		final LogicalOrExpression LogicalOrExpression_550_Var
		 = (LogicalOrExpression)ConditionalExpression_549_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_550_Var
		);
		final EList<? extends EObject> Expr_550_list = LogicalOrExpression_550_Var
		.getExpr();
		Assert.assertNotNull(Expr_550_list);
		Assert.assertEquals(1, Expr_550_list.size());
		//550
		final LogicalAndExpression LogicalAndExpression_551_Var
		 = (LogicalAndExpression)Expr_550_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_551_Var
		);
		final EList<? extends EObject> Expr_551_list = LogicalAndExpression_551_Var
		.getExpr();
		Assert.assertNotNull(Expr_551_list);
		Assert.assertEquals(1, Expr_551_list.size());
		//551
		final InclusiveOrExpression InclusiveOrExpression_552_Var
		 = (InclusiveOrExpression)Expr_551_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_552_Var
		);
		final EList<? extends EObject> Expr_552_list = InclusiveOrExpression_552_Var
		.getExpr();
		Assert.assertNotNull(Expr_552_list);
		Assert.assertEquals(1, Expr_552_list.size());
		//552
		final ExclusiveOrExpression ExclusiveOrExpression_553_Var
		 = (ExclusiveOrExpression)Expr_552_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_553_Var
		);
		final EList<? extends EObject> Expr_553_list = ExclusiveOrExpression_553_Var
		.getExpr();
		Assert.assertNotNull(Expr_553_list);
		Assert.assertEquals(1, Expr_553_list.size());
		//553
		final AndExpression AndExpression_554_Var
		 = (AndExpression)Expr_553_list.get(0);
		Assert.assertNotNull(AndExpression_554_Var
		);
		final EList<? extends EObject> Expr_554_list = AndExpression_554_Var
		.getExpr();
		Assert.assertNotNull(Expr_554_list);
		Assert.assertEquals(1, Expr_554_list.size());
		//554
		final EqualityExpression EqualityExpression_555_Var
		 = (EqualityExpression)Expr_554_list.get(0);
		Assert.assertNotNull(EqualityExpression_555_Var
		);
		final EList<? extends EObject> Expr_555_list = EqualityExpression_555_Var
		.getExpr();
		Assert.assertNotNull(Expr_555_list);
		Assert.assertEquals(1, Expr_555_list.size());
		//555
		final RelationalExpression RelationalExpression_556_Var
		 = (RelationalExpression)Expr_555_list.get(0);
		Assert.assertNotNull(RelationalExpression_556_Var
		);
		final EList<? extends EObject> Expr_556_list = RelationalExpression_556_Var
		.getExpr();
		Assert.assertNotNull(Expr_556_list);
		Assert.assertEquals(1, Expr_556_list.size());
		//556
		final ShiftExpression ShiftExpression_557_Var
		 = (ShiftExpression)Expr_556_list.get(0);
		Assert.assertNotNull(ShiftExpression_557_Var
		);
		final EList<? extends EObject> Expr_557_list = ShiftExpression_557_Var
		.getExpr();
		Assert.assertNotNull(Expr_557_list);
		Assert.assertEquals(1, Expr_557_list.size());
		//557
		final AdditiveExpression AdditiveExpression_558_Var
		 = (AdditiveExpression)Expr_557_list.get(0);
		Assert.assertNotNull(AdditiveExpression_558_Var
		);
		final EList<? extends EObject> Expr_558_list = AdditiveExpression_558_Var
		.getExpr();
		Assert.assertNotNull(Expr_558_list);
		Assert.assertEquals(1, Expr_558_list.size());
		//558
		final MultiplicativeExpression MultiplicativeExpression_559_Var
		 = (MultiplicativeExpression)Expr_558_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_559_Var
		);
		final EList<? extends EObject> Expr_559_list = MultiplicativeExpression_559_Var
		.getExpr();
		Assert.assertNotNull(Expr_559_list);
		Assert.assertEquals(1, Expr_559_list.size());
		//559
		final CastExpression CastExpression_560_Var
		 = (CastExpression)Expr_559_list.get(0);
		Assert.assertNotNull(CastExpression_560_Var
		);
		//560
		final UnaryExpression UnaryExpression_561_Var
		 = (UnaryExpression)CastExpression_560_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_561_Var
		);
		//561
		final PostfixExpression PostfixExpression_562_Var
		 = (PostfixExpression)UnaryExpression_561_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_562_Var
		);
		final EList<? extends EObject> Expr_562_list = PostfixExpression_562_Var
		.getExpr();
		Assert.assertNotNull(Expr_562_list);
		Assert.assertEquals(1, Expr_562_list.size());
		//562
		final PrimaryExpression PrimaryExpression_563_Var
		 = (PrimaryExpression)Expr_562_list.get(0);
		Assert.assertNotNull(PrimaryExpression_563_Var
		);
		//563
		final Constant Constant_564_Var
		 = (Constant)PrimaryExpression_563_Var
		.getConst();
		Assert.assertNotNull(Constant_564_Var
		);
		Assert.assertEquals("\"The %d. day of the week is my favourite!\\n\"", Constant_564_Var
		.getStr());
		//564
		final AssignmentExpression AssignmentExpression_565_Var
		 = (AssignmentExpression)Expr_547_list.get(1);
		Assert.assertNotNull(AssignmentExpression_565_Var
		);
		//565
		final ConditionalExpression ConditionalExpression_566_Var
		 = (ConditionalExpression)AssignmentExpression_565_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_566_Var
		);
		//566
		final LogicalOrExpression LogicalOrExpression_567_Var
		 = (LogicalOrExpression)ConditionalExpression_566_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_567_Var
		);
		final EList<? extends EObject> Expr_567_list = LogicalOrExpression_567_Var
		.getExpr();
		Assert.assertNotNull(Expr_567_list);
		Assert.assertEquals(1, Expr_567_list.size());
		//567
		final LogicalAndExpression LogicalAndExpression_568_Var
		 = (LogicalAndExpression)Expr_567_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_568_Var
		);
		final EList<? extends EObject> Expr_568_list = LogicalAndExpression_568_Var
		.getExpr();
		Assert.assertNotNull(Expr_568_list);
		Assert.assertEquals(1, Expr_568_list.size());
		//568
		final InclusiveOrExpression InclusiveOrExpression_569_Var
		 = (InclusiveOrExpression)Expr_568_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_569_Var
		);
		final EList<? extends EObject> Expr_569_list = InclusiveOrExpression_569_Var
		.getExpr();
		Assert.assertNotNull(Expr_569_list);
		Assert.assertEquals(1, Expr_569_list.size());
		//569
		final ExclusiveOrExpression ExclusiveOrExpression_570_Var
		 = (ExclusiveOrExpression)Expr_569_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_570_Var
		);
		final EList<? extends EObject> Expr_570_list = ExclusiveOrExpression_570_Var
		.getExpr();
		Assert.assertNotNull(Expr_570_list);
		Assert.assertEquals(1, Expr_570_list.size());
		//570
		final AndExpression AndExpression_571_Var
		 = (AndExpression)Expr_570_list.get(0);
		Assert.assertNotNull(AndExpression_571_Var
		);
		final EList<? extends EObject> Expr_571_list = AndExpression_571_Var
		.getExpr();
		Assert.assertNotNull(Expr_571_list);
		Assert.assertEquals(1, Expr_571_list.size());
		//571
		final EqualityExpression EqualityExpression_572_Var
		 = (EqualityExpression)Expr_571_list.get(0);
		Assert.assertNotNull(EqualityExpression_572_Var
		);
		final EList<? extends EObject> Expr_572_list = EqualityExpression_572_Var
		.getExpr();
		Assert.assertNotNull(Expr_572_list);
		Assert.assertEquals(1, Expr_572_list.size());
		//572
		final RelationalExpression RelationalExpression_573_Var
		 = (RelationalExpression)Expr_572_list.get(0);
		Assert.assertNotNull(RelationalExpression_573_Var
		);
		final EList<? extends EObject> Expr_573_list = RelationalExpression_573_Var
		.getExpr();
		Assert.assertNotNull(Expr_573_list);
		Assert.assertEquals(1, Expr_573_list.size());
		//573
		final ShiftExpression ShiftExpression_574_Var
		 = (ShiftExpression)Expr_573_list.get(0);
		Assert.assertNotNull(ShiftExpression_574_Var
		);
		final EList<? extends EObject> Expr_574_list = ShiftExpression_574_Var
		.getExpr();
		Assert.assertNotNull(Expr_574_list);
		Assert.assertEquals(1, Expr_574_list.size());
		//574
		final AdditiveExpression AdditiveExpression_575_Var
		 = (AdditiveExpression)Expr_574_list.get(0);
		Assert.assertNotNull(AdditiveExpression_575_Var
		);
		final EList<? extends EObject> Expr_575_list = AdditiveExpression_575_Var
		.getExpr();
		Assert.assertNotNull(Expr_575_list);
		Assert.assertEquals(1, Expr_575_list.size());
		//575
		final MultiplicativeExpression MultiplicativeExpression_576_Var
		 = (MultiplicativeExpression)Expr_575_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_576_Var
		);
		final EList<? extends EObject> Expr_576_list = MultiplicativeExpression_576_Var
		.getExpr();
		Assert.assertNotNull(Expr_576_list);
		Assert.assertEquals(1, Expr_576_list.size());
		//576
		final CastExpression CastExpression_577_Var
		 = (CastExpression)Expr_576_list.get(0);
		Assert.assertNotNull(CastExpression_577_Var
		);
		//577
		final UnaryExpression UnaryExpression_578_Var
		 = (UnaryExpression)CastExpression_577_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_578_Var
		);
		//578
		final PostfixExpression PostfixExpression_579_Var
		 = (PostfixExpression)UnaryExpression_578_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_579_Var
		);
		final EList<? extends EObject> Expr_579_list = PostfixExpression_579_Var
		.getExpr();
		Assert.assertNotNull(Expr_579_list);
		Assert.assertEquals(1, Expr_579_list.size());
		//579
		final PrimaryExpression PrimaryExpression_580_Var
		 = (PrimaryExpression)Expr_579_list.get(0);
		Assert.assertNotNull(PrimaryExpression_580_Var
		);
		Assert.assertEquals("iAmInLove", PrimaryExpression_580_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_528_Var
		.getSemi());
		//580
		final Statement Statement_581_Var
		 = (Statement)Statement_286_list.get(6);
		Assert.assertNotNull(Statement_581_Var
		);
		//581
		final ExpressionStatement ExpressionStatement_582_Var
		 = (ExpressionStatement)Statement_581_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_582_Var
		);
		//582
		final Expression Expression_583_Var
		 = (Expression)ExpressionStatement_582_Var
		.getExpression();
		Assert.assertNotNull(Expression_583_Var
		);
		final EList<? extends EObject> ExprExpr_583_list = Expression_583_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_583_list);
		Assert.assertEquals(1, ExprExpr_583_list.size());
		//583
		final AssignmentExpression AssignmentExpression_584_Var
		 = (AssignmentExpression)ExprExpr_583_list.get(0);
		Assert.assertNotNull(AssignmentExpression_584_Var
		);
		//584
		final ConditionalExpression ConditionalExpression_585_Var
		 = (ConditionalExpression)AssignmentExpression_584_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_585_Var
		);
		//585
		final LogicalOrExpression LogicalOrExpression_586_Var
		 = (LogicalOrExpression)ConditionalExpression_585_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_586_Var
		);
		final EList<? extends EObject> Expr_586_list = LogicalOrExpression_586_Var
		.getExpr();
		Assert.assertNotNull(Expr_586_list);
		Assert.assertEquals(1, Expr_586_list.size());
		//586
		final LogicalAndExpression LogicalAndExpression_587_Var
		 = (LogicalAndExpression)Expr_586_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_587_Var
		);
		final EList<? extends EObject> Expr_587_list = LogicalAndExpression_587_Var
		.getExpr();
		Assert.assertNotNull(Expr_587_list);
		Assert.assertEquals(1, Expr_587_list.size());
		//587
		final InclusiveOrExpression InclusiveOrExpression_588_Var
		 = (InclusiveOrExpression)Expr_587_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_588_Var
		);
		final EList<? extends EObject> Expr_588_list = InclusiveOrExpression_588_Var
		.getExpr();
		Assert.assertNotNull(Expr_588_list);
		Assert.assertEquals(1, Expr_588_list.size());
		//588
		final ExclusiveOrExpression ExclusiveOrExpression_589_Var
		 = (ExclusiveOrExpression)Expr_588_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_589_Var
		);
		final EList<? extends EObject> Expr_589_list = ExclusiveOrExpression_589_Var
		.getExpr();
		Assert.assertNotNull(Expr_589_list);
		Assert.assertEquals(1, Expr_589_list.size());
		//589
		final AndExpression AndExpression_590_Var
		 = (AndExpression)Expr_589_list.get(0);
		Assert.assertNotNull(AndExpression_590_Var
		);
		final EList<? extends EObject> Expr_590_list = AndExpression_590_Var
		.getExpr();
		Assert.assertNotNull(Expr_590_list);
		Assert.assertEquals(1, Expr_590_list.size());
		//590
		final EqualityExpression EqualityExpression_591_Var
		 = (EqualityExpression)Expr_590_list.get(0);
		Assert.assertNotNull(EqualityExpression_591_Var
		);
		final EList<? extends EObject> Expr_591_list = EqualityExpression_591_Var
		.getExpr();
		Assert.assertNotNull(Expr_591_list);
		Assert.assertEquals(1, Expr_591_list.size());
		//591
		final RelationalExpression RelationalExpression_592_Var
		 = (RelationalExpression)Expr_591_list.get(0);
		Assert.assertNotNull(RelationalExpression_592_Var
		);
		final EList<? extends EObject> Expr_592_list = RelationalExpression_592_Var
		.getExpr();
		Assert.assertNotNull(Expr_592_list);
		Assert.assertEquals(1, Expr_592_list.size());
		//592
		final ShiftExpression ShiftExpression_593_Var
		 = (ShiftExpression)Expr_592_list.get(0);
		Assert.assertNotNull(ShiftExpression_593_Var
		);
		final EList<? extends EObject> Expr_593_list = ShiftExpression_593_Var
		.getExpr();
		Assert.assertNotNull(Expr_593_list);
		Assert.assertEquals(1, Expr_593_list.size());
		//593
		final AdditiveExpression AdditiveExpression_594_Var
		 = (AdditiveExpression)Expr_593_list.get(0);
		Assert.assertNotNull(AdditiveExpression_594_Var
		);
		final EList<? extends EObject> Expr_594_list = AdditiveExpression_594_Var
		.getExpr();
		Assert.assertNotNull(Expr_594_list);
		Assert.assertEquals(1, Expr_594_list.size());
		//594
		final MultiplicativeExpression MultiplicativeExpression_595_Var
		 = (MultiplicativeExpression)Expr_594_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_595_Var
		);
		final EList<? extends EObject> Expr_595_list = MultiplicativeExpression_595_Var
		.getExpr();
		Assert.assertNotNull(Expr_595_list);
		Assert.assertEquals(1, Expr_595_list.size());
		//595
		final CastExpression CastExpression_596_Var
		 = (CastExpression)Expr_595_list.get(0);
		Assert.assertNotNull(CastExpression_596_Var
		);
		//596
		final UnaryExpression UnaryExpression_597_Var
		 = (UnaryExpression)CastExpression_596_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_597_Var
		);
		//597
		final PostfixExpression PostfixExpression_598_Var
		 = (PostfixExpression)UnaryExpression_597_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_598_Var
		);
		final EList<? extends EObject> Expr_598_list = PostfixExpression_598_Var
		.getExpr();
		Assert.assertNotNull(Expr_598_list);
		Assert.assertEquals(1, Expr_598_list.size());
		//598
		final PrimaryExpression PrimaryExpression_599_Var
		 = (PrimaryExpression)Expr_598_list.get(0);
		Assert.assertNotNull(PrimaryExpression_599_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_599_Var
		.getId());
		final EList<? extends EObject> Suffix_599_list = PostfixExpression_598_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_599_list);
		Assert.assertEquals(1, Suffix_599_list.size());
		//599
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_600_Var
		 = (PostfixExpressionSuffixArgument)Suffix_599_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_600_Var
		);
		//600
		final ArgumentExpressionList ArgumentExpressionList_601_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_600_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_601_Var
		);
		final EList<? extends EObject> Expr_601_list = ArgumentExpressionList_601_Var
		.getExpr();
		Assert.assertNotNull(Expr_601_list);
		Assert.assertEquals(2, Expr_601_list.size());
		//601
		final AssignmentExpression AssignmentExpression_602_Var
		 = (AssignmentExpression)Expr_601_list.get(0);
		Assert.assertNotNull(AssignmentExpression_602_Var
		);
		//602
		final ConditionalExpression ConditionalExpression_603_Var
		 = (ConditionalExpression)AssignmentExpression_602_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_603_Var
		);
		//603
		final LogicalOrExpression LogicalOrExpression_604_Var
		 = (LogicalOrExpression)ConditionalExpression_603_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_604_Var
		);
		final EList<? extends EObject> Expr_604_list = LogicalOrExpression_604_Var
		.getExpr();
		Assert.assertNotNull(Expr_604_list);
		Assert.assertEquals(1, Expr_604_list.size());
		//604
		final LogicalAndExpression LogicalAndExpression_605_Var
		 = (LogicalAndExpression)Expr_604_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_605_Var
		);
		final EList<? extends EObject> Expr_605_list = LogicalAndExpression_605_Var
		.getExpr();
		Assert.assertNotNull(Expr_605_list);
		Assert.assertEquals(1, Expr_605_list.size());
		//605
		final InclusiveOrExpression InclusiveOrExpression_606_Var
		 = (InclusiveOrExpression)Expr_605_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_606_Var
		);
		final EList<? extends EObject> Expr_606_list = InclusiveOrExpression_606_Var
		.getExpr();
		Assert.assertNotNull(Expr_606_list);
		Assert.assertEquals(1, Expr_606_list.size());
		//606
		final ExclusiveOrExpression ExclusiveOrExpression_607_Var
		 = (ExclusiveOrExpression)Expr_606_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_607_Var
		);
		final EList<? extends EObject> Expr_607_list = ExclusiveOrExpression_607_Var
		.getExpr();
		Assert.assertNotNull(Expr_607_list);
		Assert.assertEquals(1, Expr_607_list.size());
		//607
		final AndExpression AndExpression_608_Var
		 = (AndExpression)Expr_607_list.get(0);
		Assert.assertNotNull(AndExpression_608_Var
		);
		final EList<? extends EObject> Expr_608_list = AndExpression_608_Var
		.getExpr();
		Assert.assertNotNull(Expr_608_list);
		Assert.assertEquals(1, Expr_608_list.size());
		//608
		final EqualityExpression EqualityExpression_609_Var
		 = (EqualityExpression)Expr_608_list.get(0);
		Assert.assertNotNull(EqualityExpression_609_Var
		);
		final EList<? extends EObject> Expr_609_list = EqualityExpression_609_Var
		.getExpr();
		Assert.assertNotNull(Expr_609_list);
		Assert.assertEquals(1, Expr_609_list.size());
		//609
		final RelationalExpression RelationalExpression_610_Var
		 = (RelationalExpression)Expr_609_list.get(0);
		Assert.assertNotNull(RelationalExpression_610_Var
		);
		final EList<? extends EObject> Expr_610_list = RelationalExpression_610_Var
		.getExpr();
		Assert.assertNotNull(Expr_610_list);
		Assert.assertEquals(1, Expr_610_list.size());
		//610
		final ShiftExpression ShiftExpression_611_Var
		 = (ShiftExpression)Expr_610_list.get(0);
		Assert.assertNotNull(ShiftExpression_611_Var
		);
		final EList<? extends EObject> Expr_611_list = ShiftExpression_611_Var
		.getExpr();
		Assert.assertNotNull(Expr_611_list);
		Assert.assertEquals(1, Expr_611_list.size());
		//611
		final AdditiveExpression AdditiveExpression_612_Var
		 = (AdditiveExpression)Expr_611_list.get(0);
		Assert.assertNotNull(AdditiveExpression_612_Var
		);
		final EList<? extends EObject> Expr_612_list = AdditiveExpression_612_Var
		.getExpr();
		Assert.assertNotNull(Expr_612_list);
		Assert.assertEquals(1, Expr_612_list.size());
		//612
		final MultiplicativeExpression MultiplicativeExpression_613_Var
		 = (MultiplicativeExpression)Expr_612_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_613_Var
		);
		final EList<? extends EObject> Expr_613_list = MultiplicativeExpression_613_Var
		.getExpr();
		Assert.assertNotNull(Expr_613_list);
		Assert.assertEquals(1, Expr_613_list.size());
		//613
		final CastExpression CastExpression_614_Var
		 = (CastExpression)Expr_613_list.get(0);
		Assert.assertNotNull(CastExpression_614_Var
		);
		//614
		final UnaryExpression UnaryExpression_615_Var
		 = (UnaryExpression)CastExpression_614_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_615_Var
		);
		//615
		final PostfixExpression PostfixExpression_616_Var
		 = (PostfixExpression)UnaryExpression_615_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_616_Var
		);
		final EList<? extends EObject> Expr_616_list = PostfixExpression_616_Var
		.getExpr();
		Assert.assertNotNull(Expr_616_list);
		Assert.assertEquals(1, Expr_616_list.size());
		//616
		final PrimaryExpression PrimaryExpression_617_Var
		 = (PrimaryExpression)Expr_616_list.get(0);
		Assert.assertNotNull(PrimaryExpression_617_Var
		);
		//617
		final Constant Constant_618_Var
		 = (Constant)PrimaryExpression_617_Var
		.getConst();
		Assert.assertNotNull(Constant_618_Var
		);
		Assert.assertEquals("\"The %d. day of the week is my favourite!\\n\"", Constant_618_Var
		.getStr());
		//618
		final AssignmentExpression AssignmentExpression_619_Var
		 = (AssignmentExpression)Expr_601_list.get(1);
		Assert.assertNotNull(AssignmentExpression_619_Var
		);
		//619
		final ConditionalExpression ConditionalExpression_620_Var
		 = (ConditionalExpression)AssignmentExpression_619_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_620_Var
		);
		//620
		final LogicalOrExpression LogicalOrExpression_621_Var
		 = (LogicalOrExpression)ConditionalExpression_620_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_621_Var
		);
		final EList<? extends EObject> Expr_621_list = LogicalOrExpression_621_Var
		.getExpr();
		Assert.assertNotNull(Expr_621_list);
		Assert.assertEquals(1, Expr_621_list.size());
		//621
		final LogicalAndExpression LogicalAndExpression_622_Var
		 = (LogicalAndExpression)Expr_621_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_622_Var
		);
		final EList<? extends EObject> Expr_622_list = LogicalAndExpression_622_Var
		.getExpr();
		Assert.assertNotNull(Expr_622_list);
		Assert.assertEquals(1, Expr_622_list.size());
		//622
		final InclusiveOrExpression InclusiveOrExpression_623_Var
		 = (InclusiveOrExpression)Expr_622_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_623_Var
		);
		final EList<? extends EObject> Expr_623_list = InclusiveOrExpression_623_Var
		.getExpr();
		Assert.assertNotNull(Expr_623_list);
		Assert.assertEquals(1, Expr_623_list.size());
		//623
		final ExclusiveOrExpression ExclusiveOrExpression_624_Var
		 = (ExclusiveOrExpression)Expr_623_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_624_Var
		);
		final EList<? extends EObject> Expr_624_list = ExclusiveOrExpression_624_Var
		.getExpr();
		Assert.assertNotNull(Expr_624_list);
		Assert.assertEquals(1, Expr_624_list.size());
		//624
		final AndExpression AndExpression_625_Var
		 = (AndExpression)Expr_624_list.get(0);
		Assert.assertNotNull(AndExpression_625_Var
		);
		final EList<? extends EObject> Expr_625_list = AndExpression_625_Var
		.getExpr();
		Assert.assertNotNull(Expr_625_list);
		Assert.assertEquals(1, Expr_625_list.size());
		//625
		final EqualityExpression EqualityExpression_626_Var
		 = (EqualityExpression)Expr_625_list.get(0);
		Assert.assertNotNull(EqualityExpression_626_Var
		);
		final EList<? extends EObject> Expr_626_list = EqualityExpression_626_Var
		.getExpr();
		Assert.assertNotNull(Expr_626_list);
		Assert.assertEquals(1, Expr_626_list.size());
		//626
		final RelationalExpression RelationalExpression_627_Var
		 = (RelationalExpression)Expr_626_list.get(0);
		Assert.assertNotNull(RelationalExpression_627_Var
		);
		final EList<? extends EObject> Expr_627_list = RelationalExpression_627_Var
		.getExpr();
		Assert.assertNotNull(Expr_627_list);
		Assert.assertEquals(1, Expr_627_list.size());
		//627
		final ShiftExpression ShiftExpression_628_Var
		 = (ShiftExpression)Expr_627_list.get(0);
		Assert.assertNotNull(ShiftExpression_628_Var
		);
		final EList<? extends EObject> Expr_628_list = ShiftExpression_628_Var
		.getExpr();
		Assert.assertNotNull(Expr_628_list);
		Assert.assertEquals(1, Expr_628_list.size());
		//628
		final AdditiveExpression AdditiveExpression_629_Var
		 = (AdditiveExpression)Expr_628_list.get(0);
		Assert.assertNotNull(AdditiveExpression_629_Var
		);
		final EList<? extends EObject> Expr_629_list = AdditiveExpression_629_Var
		.getExpr();
		Assert.assertNotNull(Expr_629_list);
		Assert.assertEquals(1, Expr_629_list.size());
		//629
		final MultiplicativeExpression MultiplicativeExpression_630_Var
		 = (MultiplicativeExpression)Expr_629_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_630_Var
		);
		final EList<? extends EObject> Expr_630_list = MultiplicativeExpression_630_Var
		.getExpr();
		Assert.assertNotNull(Expr_630_list);
		Assert.assertEquals(1, Expr_630_list.size());
		//630
		final CastExpression CastExpression_631_Var
		 = (CastExpression)Expr_630_list.get(0);
		Assert.assertNotNull(CastExpression_631_Var
		);
		//631
		final UnaryExpression UnaryExpression_632_Var
		 = (UnaryExpression)CastExpression_631_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_632_Var
		);
		//632
		final PostfixExpression PostfixExpression_633_Var
		 = (PostfixExpression)UnaryExpression_632_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_633_Var
		);
		final EList<? extends EObject> Expr_633_list = PostfixExpression_633_Var
		.getExpr();
		Assert.assertNotNull(Expr_633_list);
		Assert.assertEquals(1, Expr_633_list.size());
		//633
		final PrimaryExpression PrimaryExpression_634_Var
		 = (PrimaryExpression)Expr_633_list.get(0);
		Assert.assertNotNull(PrimaryExpression_634_Var
		);
		Assert.assertEquals("my_weekday", PrimaryExpression_634_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_582_Var
		.getSemi());
		//634
		final Statement Statement_635_Var
		 = (Statement)Statement_286_list.get(7);
		Assert.assertNotNull(Statement_635_Var
		);
		//635
		final JumpStatement JumpStatement_636_Var
		 = (JumpStatement)Statement_635_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_636_Var
		);
		//636
		final Expression Expression_637_Var
		 = (Expression)JumpStatement_636_Var
		.getExpr();
		Assert.assertNotNull(Expression_637_Var
		);
		final EList<? extends EObject> ExprExpr_637_list = Expression_637_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_637_list);
		Assert.assertEquals(1, ExprExpr_637_list.size());
		//637
		final AssignmentExpression AssignmentExpression_638_Var
		 = (AssignmentExpression)ExprExpr_637_list.get(0);
		Assert.assertNotNull(AssignmentExpression_638_Var
		);
		//638
		final ConditionalExpression ConditionalExpression_639_Var
		 = (ConditionalExpression)AssignmentExpression_638_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_639_Var
		);
		//639
		final LogicalOrExpression LogicalOrExpression_640_Var
		 = (LogicalOrExpression)ConditionalExpression_639_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_640_Var
		);
		final EList<? extends EObject> Expr_640_list = LogicalOrExpression_640_Var
		.getExpr();
		Assert.assertNotNull(Expr_640_list);
		Assert.assertEquals(1, Expr_640_list.size());
		//640
		final LogicalAndExpression LogicalAndExpression_641_Var
		 = (LogicalAndExpression)Expr_640_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_641_Var
		);
		final EList<? extends EObject> Expr_641_list = LogicalAndExpression_641_Var
		.getExpr();
		Assert.assertNotNull(Expr_641_list);
		Assert.assertEquals(1, Expr_641_list.size());
		//641
		final InclusiveOrExpression InclusiveOrExpression_642_Var
		 = (InclusiveOrExpression)Expr_641_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_642_Var
		);
		final EList<? extends EObject> Expr_642_list = InclusiveOrExpression_642_Var
		.getExpr();
		Assert.assertNotNull(Expr_642_list);
		Assert.assertEquals(1, Expr_642_list.size());
		//642
		final ExclusiveOrExpression ExclusiveOrExpression_643_Var
		 = (ExclusiveOrExpression)Expr_642_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_643_Var
		);
		final EList<? extends EObject> Expr_643_list = ExclusiveOrExpression_643_Var
		.getExpr();
		Assert.assertNotNull(Expr_643_list);
		Assert.assertEquals(1, Expr_643_list.size());
		//643
		final AndExpression AndExpression_644_Var
		 = (AndExpression)Expr_643_list.get(0);
		Assert.assertNotNull(AndExpression_644_Var
		);
		final EList<? extends EObject> Expr_644_list = AndExpression_644_Var
		.getExpr();
		Assert.assertNotNull(Expr_644_list);
		Assert.assertEquals(1, Expr_644_list.size());
		//644
		final EqualityExpression EqualityExpression_645_Var
		 = (EqualityExpression)Expr_644_list.get(0);
		Assert.assertNotNull(EqualityExpression_645_Var
		);
		final EList<? extends EObject> Expr_645_list = EqualityExpression_645_Var
		.getExpr();
		Assert.assertNotNull(Expr_645_list);
		Assert.assertEquals(1, Expr_645_list.size());
		//645
		final RelationalExpression RelationalExpression_646_Var
		 = (RelationalExpression)Expr_645_list.get(0);
		Assert.assertNotNull(RelationalExpression_646_Var
		);
		final EList<? extends EObject> Expr_646_list = RelationalExpression_646_Var
		.getExpr();
		Assert.assertNotNull(Expr_646_list);
		Assert.assertEquals(1, Expr_646_list.size());
		//646
		final ShiftExpression ShiftExpression_647_Var
		 = (ShiftExpression)Expr_646_list.get(0);
		Assert.assertNotNull(ShiftExpression_647_Var
		);
		final EList<? extends EObject> Expr_647_list = ShiftExpression_647_Var
		.getExpr();
		Assert.assertNotNull(Expr_647_list);
		Assert.assertEquals(1, Expr_647_list.size());
		//647
		final AdditiveExpression AdditiveExpression_648_Var
		 = (AdditiveExpression)Expr_647_list.get(0);
		Assert.assertNotNull(AdditiveExpression_648_Var
		);
		final EList<? extends EObject> Expr_648_list = AdditiveExpression_648_Var
		.getExpr();
		Assert.assertNotNull(Expr_648_list);
		Assert.assertEquals(1, Expr_648_list.size());
		//648
		final MultiplicativeExpression MultiplicativeExpression_649_Var
		 = (MultiplicativeExpression)Expr_648_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_649_Var
		);
		final EList<? extends EObject> Expr_649_list = MultiplicativeExpression_649_Var
		.getExpr();
		Assert.assertNotNull(Expr_649_list);
		Assert.assertEquals(1, Expr_649_list.size());
		//649
		final CastExpression CastExpression_650_Var
		 = (CastExpression)Expr_649_list.get(0);
		Assert.assertNotNull(CastExpression_650_Var
		);
		//650
		final UnaryExpression UnaryExpression_651_Var
		 = (UnaryExpression)CastExpression_650_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_651_Var
		);
		//651
		final PostfixExpression PostfixExpression_652_Var
		 = (PostfixExpression)UnaryExpression_651_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_652_Var
		);
		final EList<? extends EObject> Expr_652_list = PostfixExpression_652_Var
		.getExpr();
		Assert.assertNotNull(Expr_652_list);
		Assert.assertEquals(1, Expr_652_list.size());
		//652
		final PrimaryExpression PrimaryExpression_653_Var
		 = (PrimaryExpression)Expr_652_list.get(0);
		Assert.assertNotNull(PrimaryExpression_653_Var
		);
		//653
		final Constant Constant_654_Var
		 = (Constant)PrimaryExpression_653_Var
		.getConst();
		Assert.assertNotNull(Constant_654_Var
		);
		Assert.assertEquals("0", Constant_654_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_636_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_636_Var
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


