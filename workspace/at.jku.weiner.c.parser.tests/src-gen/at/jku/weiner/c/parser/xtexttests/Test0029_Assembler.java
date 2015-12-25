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
import at.jku.weiner.c.parser.parser.TypeSpecifier;
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
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.AsmStatement;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
import at.jku.weiner.c.parser.parser.AsmLineWithComma;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
import at.jku.weiner.c.parser.parser.AsmLineWithComma;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
import at.jku.weiner.c.parser.parser.AsmLineWithComma;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
import at.jku.weiner.c.parser.parser.AsmLineWithComma;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.UnaryOperator;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.CompoundStatement;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
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
import at.jku.weiner.c.parser.parser.UnaryOperator;
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
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0029_Assembler {
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
			"res/Test0029_Assembler.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_KW_EXTERN", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_SKW_STAR", 
				"RULE_ID", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_NEWLINE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_ASM2", 
				"RULE_WHITESPACE", 
				"RULE_KW_VOLATILE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_SKW_COLON", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_ID", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_SKW_COLON", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_SKW_COLON", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_SKW_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_IF", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTPAREN", 
				"RULE_SKW_MINUS", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LESSEQUAL", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ANDAND", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LESS", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_MINUS", 
				"RULE_ID", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_SKW_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_SKW_MINUS", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SKW_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_SKW_RIGHTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
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
			"res/Test0029_Assembler.c");
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
		Assert.assertEquals(2, External_2_list.size());
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
		Assert.assertEquals("extern", StorageClassSpecifier_6_Var
		.getName());
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
		Assert.assertEquals(1, InitDeclarator_8_list.size());
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
		Assert.assertEquals("errno", DirectDeclarator_11_Var
		.getId());
		Assert.assertEquals(";", Declaration_4_Var
		.getSemi());
		//11
		final ExternalDeclaration ExternalDeclaration_12_Var
		 = (ExternalDeclaration)External_2_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_12_Var
		);
		//12
		final FunctionDefHead FunctionDefHead_13_Var
		 = (FunctionDefHead)ExternalDeclaration_12_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_13_Var
		);
		//13
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_14_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_13_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_14_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_14_list = FunctionDeclarationSpecifiers_14_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_14_list);
		Assert.assertEquals(1, DeclarationSpecifier_14_list.size());
		//14
		final TypeSpecifier TypeSpecifier_15_Var
		 = (TypeSpecifier)DeclarationSpecifier_14_list.get(0);
		Assert.assertNotNull(TypeSpecifier_15_Var
		);
		Assert.assertEquals("int", TypeSpecifier_15_Var
		.getName());
		//15
		final Declarator Declarator_16_Var
		 = (Declarator)FunctionDefHead_13_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_16_Var
		);
		//16
		final DirectDeclarator DirectDeclarator_17_Var
		 = (DirectDeclarator)Declarator_16_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_17_Var
		);
		Assert.assertEquals("funcname", DirectDeclarator_17_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_17_list = DirectDeclarator_17_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_17_list);
		Assert.assertEquals(1, DeclaratorSuffix_17_list.size());
		//17
		final DeclaratorSuffix DeclaratorSuffix_18_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_17_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_18_Var
		);
		//18
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_19_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_18_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_19_Var
		);
		final EList<? extends EObject> ParameterTypeList_19_list = DirectDeclaratorLastSuffix_19_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_19_list);
		Assert.assertEquals(1, ParameterTypeList_19_list.size());
		//19
		final ParameterTypeList ParameterTypeList_20_Var
		 = (ParameterTypeList)ParameterTypeList_19_list.get(0);
		Assert.assertNotNull(ParameterTypeList_20_Var
		);
		//20
		final ParameterList ParameterList_21_Var
		 = (ParameterList)ParameterTypeList_20_Var
		.getList();
		Assert.assertNotNull(ParameterList_21_Var
		);
		final EList<? extends EObject> ParameterDeclaration_21_list = ParameterList_21_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_21_list);
		Assert.assertEquals(3, ParameterDeclaration_21_list.size());
		//21
		final ParameterDeclaration ParameterDeclaration_22_Var
		 = (ParameterDeclaration)ParameterDeclaration_21_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_22_Var
		);
		//22
		final DeclarationSpecifiers DeclarationSpecifiers_23_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_22_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_23_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_23_list = DeclarationSpecifiers_23_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_23_list);
		Assert.assertEquals(1, DeclarationSpecifier_23_list.size());
		//23
		final TypeSpecifier TypeSpecifier_24_Var
		 = (TypeSpecifier)DeclarationSpecifier_23_list.get(0);
		Assert.assertNotNull(TypeSpecifier_24_Var
		);
		Assert.assertEquals("int", TypeSpecifier_24_Var
		.getName());
		//24
		final Declarator Declarator_25_Var
		 = (Declarator)ParameterDeclaration_22_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_25_Var
		);
		//25
		final DirectDeclarator DirectDeclarator_26_Var
		 = (DirectDeclarator)Declarator_25_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_26_Var
		);
		Assert.assertEquals("arg1", DirectDeclarator_26_Var
		.getId());
		//26
		final ParameterDeclaration ParameterDeclaration_27_Var
		 = (ParameterDeclaration)ParameterDeclaration_21_list.get(1);
		Assert.assertNotNull(ParameterDeclaration_27_Var
		);
		//27
		final DeclarationSpecifiers DeclarationSpecifiers_28_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_27_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_28_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_28_list = DeclarationSpecifiers_28_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_28_list);
		Assert.assertEquals(1, DeclarationSpecifier_28_list.size());
		//28
		final TypeSpecifier TypeSpecifier_29_Var
		 = (TypeSpecifier)DeclarationSpecifier_28_list.get(0);
		Assert.assertNotNull(TypeSpecifier_29_Var
		);
		Assert.assertEquals("int", TypeSpecifier_29_Var
		.getName());
		//29
		final Declarator Declarator_30_Var
		 = (Declarator)ParameterDeclaration_27_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_30_Var
		);
		//30
		final DirectDeclarator DirectDeclarator_31_Var
		 = (DirectDeclarator)Declarator_30_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_31_Var
		);
		Assert.assertEquals("arg2", DirectDeclarator_31_Var
		.getId());
		//31
		final Pointer Pointer_32_Var
		 = (Pointer)Declarator_30_Var
		.getPointer();
		Assert.assertNotNull(Pointer_32_Var
		);
		Assert.assertEquals("[*]", Pointer_32_Var
		.getStar().toString());
		//32
		final ParameterDeclaration ParameterDeclaration_33_Var
		 = (ParameterDeclaration)ParameterDeclaration_21_list.get(2);
		Assert.assertNotNull(ParameterDeclaration_33_Var
		);
		//33
		final DeclarationSpecifiers DeclarationSpecifiers_34_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_33_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_34_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_34_list = DeclarationSpecifiers_34_Var
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
		 = (Declarator)ParameterDeclaration_33_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_36_Var
		);
		//36
		final DirectDeclarator DirectDeclarator_37_Var
		 = (DirectDeclarator)Declarator_36_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_37_Var
		);
		Assert.assertEquals("arg3", DirectDeclarator_37_Var
		.getId());
		//37
		final FunctionDefinition FunctionDefinition_38_Var
		 = (FunctionDefinition)ExternalDeclaration_12_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_38_Var
		);
		//38
		final BodyStatement BodyStatement_39_Var
		 = (BodyStatement)FunctionDefinition_38_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_39_Var
		);
		final EList<? extends EObject> BlockList_39_list = BodyStatement_39_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_39_list);
		Assert.assertEquals(1, BlockList_39_list.size());
		//39
		final BlockList BlockList_40_Var
		 = (BlockList)BlockList_39_list.get(0);
		Assert.assertNotNull(BlockList_40_Var
		);
		final EList<? extends EObject> Declaration_40_list = BlockList_40_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_40_list);
		Assert.assertEquals(1, Declaration_40_list.size());
		//40
		final Declaration Declaration_41_Var
		 = (Declaration)Declaration_40_list.get(0);
		Assert.assertNotNull(Declaration_41_Var
		);
		//41
		final DeclarationSpecifiers DeclarationSpecifiers_42_Var
		 = (DeclarationSpecifiers)Declaration_41_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_42_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_42_list = DeclarationSpecifiers_42_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_42_list);
		Assert.assertEquals(1, DeclarationSpecifier_42_list.size());
		//42
		final TypeSpecifier TypeSpecifier_43_Var
		 = (TypeSpecifier)DeclarationSpecifier_42_list.get(0);
		Assert.assertNotNull(TypeSpecifier_43_Var
		);
		Assert.assertEquals("int", TypeSpecifier_43_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_43_list = Declaration_41_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_43_list);
		Assert.assertEquals(1, InitDeclaratorList_43_list.size());
		//43
		final InitDeclaratorList InitDeclaratorList_44_Var
		 = (InitDeclaratorList)InitDeclaratorList_43_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_44_Var
		);
		final EList<? extends EObject> InitDeclarator_44_list = InitDeclaratorList_44_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_44_list);
		Assert.assertEquals(1, InitDeclarator_44_list.size());
		//44
		final InitDeclarator InitDeclarator_45_Var
		 = (InitDeclarator)InitDeclarator_44_list.get(0);
		Assert.assertNotNull(InitDeclarator_45_Var
		);
		//45
		final Declarator Declarator_46_Var
		 = (Declarator)InitDeclarator_45_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_46_Var
		);
		//46
		final DirectDeclarator DirectDeclarator_47_Var
		 = (DirectDeclarator)Declarator_46_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_47_Var
		);
		Assert.assertEquals("res", DirectDeclarator_47_Var
		.getId());
		Assert.assertEquals(";", Declaration_41_Var
		.getSemi());
		final EList<? extends EObject> Statement_47_list = BlockList_40_Var
		.getStatement();
		Assert.assertNotNull(Statement_47_list);
		Assert.assertEquals(3, Statement_47_list.size());
		//47
		final Statement Statement_48_Var
		 = (Statement)Statement_47_list.get(0);
		Assert.assertNotNull(Statement_48_Var
		);
		//48
		final AsmStatement AsmStatement_49_Var
		 = (AsmStatement)Statement_48_Var
		.getStmt();
		Assert.assertNotNull(AsmStatement_49_Var
		);
		final EList<? extends EObject> AsmLine_49_list = AsmStatement_49_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLine_49_list);
		Assert.assertEquals(8, AsmLine_49_list.size());
		//49
		final AsmLineWithColon AsmLineWithColon_50_Var
		 = (AsmLineWithColon)AsmLine_49_list.get(0);
		Assert.assertNotNull(AsmLineWithColon_50_Var
		);
		//50
		final LogicalOrExpression LogicalOrExpression_51_Var
		 = (LogicalOrExpression)AsmLineWithColon_50_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = LogicalOrExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final LogicalAndExpression LogicalAndExpression_52_Var
		 = (LogicalAndExpression)Expr_51_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = LogicalAndExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final InclusiveOrExpression InclusiveOrExpression_53_Var
		 = (InclusiveOrExpression)Expr_52_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = InclusiveOrExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final ExclusiveOrExpression ExclusiveOrExpression_54_Var
		 = (ExclusiveOrExpression)Expr_53_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = ExclusiveOrExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final AndExpression AndExpression_55_Var
		 = (AndExpression)Expr_54_list.get(0);
		Assert.assertNotNull(AndExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = AndExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final EqualityExpression EqualityExpression_56_Var
		 = (EqualityExpression)Expr_55_list.get(0);
		Assert.assertNotNull(EqualityExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = EqualityExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final RelationalExpression RelationalExpression_57_Var
		 = (RelationalExpression)Expr_56_list.get(0);
		Assert.assertNotNull(RelationalExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = RelationalExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final ShiftExpression ShiftExpression_58_Var
		 = (ShiftExpression)Expr_57_list.get(0);
		Assert.assertNotNull(ShiftExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = ShiftExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final AdditiveExpression AdditiveExpression_59_Var
		 = (AdditiveExpression)Expr_58_list.get(0);
		Assert.assertNotNull(AdditiveExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = AdditiveExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final MultiplicativeExpression MultiplicativeExpression_60_Var
		 = (MultiplicativeExpression)Expr_59_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = MultiplicativeExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final CastExpression CastExpression_61_Var
		 = (CastExpression)Expr_60_list.get(0);
		Assert.assertNotNull(CastExpression_61_Var
		);
		//61
		final UnaryExpression UnaryExpression_62_Var
		 = (UnaryExpression)CastExpression_61_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_62_Var
		);
		//62
		final PostfixExpression PostfixExpression_63_Var
		 = (PostfixExpression)UnaryExpression_62_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = PostfixExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final PrimaryExpression PrimaryExpression_64_Var
		 = (PrimaryExpression)Expr_63_list.get(0);
		Assert.assertNotNull(PrimaryExpression_64_Var
		);
		//64
		final Constant2 Constant2_65_Var
		 = (Constant2)PrimaryExpression_64_Var
		.getConst();
		Assert.assertNotNull(Constant2_65_Var
		);
		Assert.assertEquals("\"int $0x80\"", Constant2_65_Var
		.getStr());
		//65
		final AsmLineWithColon AsmLineWithColon_66_Var
		 = (AsmLineWithColon)AsmLine_49_list.get(1);
		Assert.assertNotNull(AsmLineWithColon_66_Var
		);
		//66
		final LogicalOrExpression LogicalOrExpression_67_Var
		 = (LogicalOrExpression)AsmLineWithColon_66_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = LogicalOrExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final LogicalAndExpression LogicalAndExpression_68_Var
		 = (LogicalAndExpression)Expr_67_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = LogicalAndExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final InclusiveOrExpression InclusiveOrExpression_69_Var
		 = (InclusiveOrExpression)Expr_68_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = InclusiveOrExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final ExclusiveOrExpression ExclusiveOrExpression_70_Var
		 = (ExclusiveOrExpression)Expr_69_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = ExclusiveOrExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final AndExpression AndExpression_71_Var
		 = (AndExpression)Expr_70_list.get(0);
		Assert.assertNotNull(AndExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = AndExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final EqualityExpression EqualityExpression_72_Var
		 = (EqualityExpression)Expr_71_list.get(0);
		Assert.assertNotNull(EqualityExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = EqualityExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final RelationalExpression RelationalExpression_73_Var
		 = (RelationalExpression)Expr_72_list.get(0);
		Assert.assertNotNull(RelationalExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = RelationalExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final ShiftExpression ShiftExpression_74_Var
		 = (ShiftExpression)Expr_73_list.get(0);
		Assert.assertNotNull(ShiftExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = ShiftExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final AdditiveExpression AdditiveExpression_75_Var
		 = (AdditiveExpression)Expr_74_list.get(0);
		Assert.assertNotNull(AdditiveExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = AdditiveExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final MultiplicativeExpression MultiplicativeExpression_76_Var
		 = (MultiplicativeExpression)Expr_75_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = MultiplicativeExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final CastExpression CastExpression_77_Var
		 = (CastExpression)Expr_76_list.get(0);
		Assert.assertNotNull(CastExpression_77_Var
		);
		//77
		final UnaryExpression UnaryExpression_78_Var
		 = (UnaryExpression)CastExpression_77_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_78_Var
		);
		//78
		final PostfixExpression PostfixExpression_79_Var
		 = (PostfixExpression)UnaryExpression_78_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = PostfixExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final PrimaryExpression PrimaryExpression_80_Var
		 = (PrimaryExpression)Expr_79_list.get(0);
		Assert.assertNotNull(PrimaryExpression_80_Var
		);
		//80
		final Constant2 Constant2_81_Var
		 = (Constant2)PrimaryExpression_80_Var
		.getConst();
		Assert.assertNotNull(Constant2_81_Var
		);
		Assert.assertEquals("\"=a\"", Constant2_81_Var
		.getStr());
		final EList<? extends EObject> Suffix_81_list = PostfixExpression_79_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_81_list);
		Assert.assertEquals(1, Suffix_81_list.size());
		//81
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_82_Var
		 = (PostfixExpressionSuffixArgument)Suffix_81_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_82_Var
		);
		//82
		final ArgumentExpressionList ArgumentExpressionList_83_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_82_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_83_Var
		);
		final EList<? extends EObject> Expr_83_list = ArgumentExpressionList_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final AssignmentExpression AssignmentExpression_84_Var
		 = (AssignmentExpression)Expr_83_list.get(0);
		Assert.assertNotNull(AssignmentExpression_84_Var
		);
		//84
		final ConditionalExpression ConditionalExpression_85_Var
		 = (ConditionalExpression)AssignmentExpression_84_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_85_Var
		);
		//85
		final LogicalOrExpression LogicalOrExpression_86_Var
		 = (LogicalOrExpression)ConditionalExpression_85_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = LogicalOrExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final LogicalAndExpression LogicalAndExpression_87_Var
		 = (LogicalAndExpression)Expr_86_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = LogicalAndExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final InclusiveOrExpression InclusiveOrExpression_88_Var
		 = (InclusiveOrExpression)Expr_87_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = InclusiveOrExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final ExclusiveOrExpression ExclusiveOrExpression_89_Var
		 = (ExclusiveOrExpression)Expr_88_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = ExclusiveOrExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final AndExpression AndExpression_90_Var
		 = (AndExpression)Expr_89_list.get(0);
		Assert.assertNotNull(AndExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = AndExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final EqualityExpression EqualityExpression_91_Var
		 = (EqualityExpression)Expr_90_list.get(0);
		Assert.assertNotNull(EqualityExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = EqualityExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final RelationalExpression RelationalExpression_92_Var
		 = (RelationalExpression)Expr_91_list.get(0);
		Assert.assertNotNull(RelationalExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = RelationalExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final ShiftExpression ShiftExpression_93_Var
		 = (ShiftExpression)Expr_92_list.get(0);
		Assert.assertNotNull(ShiftExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = ShiftExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final AdditiveExpression AdditiveExpression_94_Var
		 = (AdditiveExpression)Expr_93_list.get(0);
		Assert.assertNotNull(AdditiveExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = AdditiveExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final MultiplicativeExpression MultiplicativeExpression_95_Var
		 = (MultiplicativeExpression)Expr_94_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = MultiplicativeExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final CastExpression CastExpression_96_Var
		 = (CastExpression)Expr_95_list.get(0);
		Assert.assertNotNull(CastExpression_96_Var
		);
		//96
		final UnaryExpression UnaryExpression_97_Var
		 = (UnaryExpression)CastExpression_96_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_97_Var
		);
		//97
		final PostfixExpression PostfixExpression_98_Var
		 = (PostfixExpression)UnaryExpression_97_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = PostfixExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final PrimaryExpression PrimaryExpression_99_Var
		 = (PrimaryExpression)Expr_98_list.get(0);
		Assert.assertNotNull(PrimaryExpression_99_Var
		);
		Assert.assertEquals("res", PrimaryExpression_99_Var
		.getId());
		//99
		final AsmLineWithComma AsmLineWithComma_100_Var
		 = (AsmLineWithComma)AsmLine_49_list.get(2);
		Assert.assertNotNull(AsmLineWithComma_100_Var
		);
		//100
		final LogicalOrExpression LogicalOrExpression_101_Var
		 = (LogicalOrExpression)AsmLineWithComma_100_Var
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
		//114
		final Constant2 Constant2_115_Var
		 = (Constant2)PrimaryExpression_114_Var
		.getConst();
		Assert.assertNotNull(Constant2_115_Var
		);
		Assert.assertEquals("\"+b\"", Constant2_115_Var
		.getStr());
		final EList<? extends EObject> Suffix_115_list = PostfixExpression_113_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_115_list);
		Assert.assertEquals(1, Suffix_115_list.size());
		//115
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_116_Var
		 = (PostfixExpressionSuffixArgument)Suffix_115_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_116_Var
		);
		//116
		final ArgumentExpressionList ArgumentExpressionList_117_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_116_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_117_Var
		);
		final EList<? extends EObject> Expr_117_list = ArgumentExpressionList_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final AssignmentExpression AssignmentExpression_118_Var
		 = (AssignmentExpression)Expr_117_list.get(0);
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
		Assert.assertEquals("arg1", PrimaryExpression_133_Var
		.getId());
		//133
		final AsmLineWithComma AsmLineWithComma_134_Var
		 = (AsmLineWithComma)AsmLine_49_list.get(3);
		Assert.assertNotNull(AsmLineWithComma_134_Var
		);
		//134
		final LogicalOrExpression LogicalOrExpression_135_Var
		 = (LogicalOrExpression)AsmLineWithComma_134_Var
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
		//148
		final Constant2 Constant2_149_Var
		 = (Constant2)PrimaryExpression_148_Var
		.getConst();
		Assert.assertNotNull(Constant2_149_Var
		);
		Assert.assertEquals("\"+c\"", Constant2_149_Var
		.getStr());
		final EList<? extends EObject> Suffix_149_list = PostfixExpression_147_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_149_list);
		Assert.assertEquals(1, Suffix_149_list.size());
		//149
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_150_Var
		 = (PostfixExpressionSuffixArgument)Suffix_149_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_150_Var
		);
		//150
		final ArgumentExpressionList ArgumentExpressionList_151_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_150_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_151_Var
		);
		final EList<? extends EObject> Expr_151_list = ArgumentExpressionList_151_Var
		.getExpr();
		Assert.assertNotNull(Expr_151_list);
		Assert.assertEquals(1, Expr_151_list.size());
		//151
		final AssignmentExpression AssignmentExpression_152_Var
		 = (AssignmentExpression)Expr_151_list.get(0);
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
		Assert.assertEquals("arg2", PrimaryExpression_167_Var
		.getId());
		//167
		final AsmLineWithComma AsmLineWithComma_168_Var
		 = (AsmLineWithComma)AsmLine_49_list.get(4);
		Assert.assertNotNull(AsmLineWithComma_168_Var
		);
		//168
		final LogicalOrExpression LogicalOrExpression_169_Var
		 = (LogicalOrExpression)AsmLineWithComma_168_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_169_Var
		);
		final EList<? extends EObject> Expr_169_list = LogicalOrExpression_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		//169
		final LogicalAndExpression LogicalAndExpression_170_Var
		 = (LogicalAndExpression)Expr_169_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_170_Var
		);
		final EList<? extends EObject> Expr_170_list = LogicalAndExpression_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		//170
		final InclusiveOrExpression InclusiveOrExpression_171_Var
		 = (InclusiveOrExpression)Expr_170_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_171_Var
		);
		final EList<? extends EObject> Expr_171_list = InclusiveOrExpression_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		//171
		final ExclusiveOrExpression ExclusiveOrExpression_172_Var
		 = (ExclusiveOrExpression)Expr_171_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = ExclusiveOrExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final AndExpression AndExpression_173_Var
		 = (AndExpression)Expr_172_list.get(0);
		Assert.assertNotNull(AndExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = AndExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final EqualityExpression EqualityExpression_174_Var
		 = (EqualityExpression)Expr_173_list.get(0);
		Assert.assertNotNull(EqualityExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = EqualityExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final RelationalExpression RelationalExpression_175_Var
		 = (RelationalExpression)Expr_174_list.get(0);
		Assert.assertNotNull(RelationalExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = RelationalExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final ShiftExpression ShiftExpression_176_Var
		 = (ShiftExpression)Expr_175_list.get(0);
		Assert.assertNotNull(ShiftExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = ShiftExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final AdditiveExpression AdditiveExpression_177_Var
		 = (AdditiveExpression)Expr_176_list.get(0);
		Assert.assertNotNull(AdditiveExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = AdditiveExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final MultiplicativeExpression MultiplicativeExpression_178_Var
		 = (MultiplicativeExpression)Expr_177_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = MultiplicativeExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final CastExpression CastExpression_179_Var
		 = (CastExpression)Expr_178_list.get(0);
		Assert.assertNotNull(CastExpression_179_Var
		);
		//179
		final UnaryExpression UnaryExpression_180_Var
		 = (UnaryExpression)CastExpression_179_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_180_Var
		);
		//180
		final PostfixExpression PostfixExpression_181_Var
		 = (PostfixExpression)UnaryExpression_180_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_181_Var
		);
		final EList<? extends EObject> Expr_181_list = PostfixExpression_181_Var
		.getExpr();
		Assert.assertNotNull(Expr_181_list);
		Assert.assertEquals(1, Expr_181_list.size());
		//181
		final PrimaryExpression PrimaryExpression_182_Var
		 = (PrimaryExpression)Expr_181_list.get(0);
		Assert.assertNotNull(PrimaryExpression_182_Var
		);
		//182
		final Constant2 Constant2_183_Var
		 = (Constant2)PrimaryExpression_182_Var
		.getConst();
		Assert.assertNotNull(Constant2_183_Var
		);
		Assert.assertEquals("\"+d\"", Constant2_183_Var
		.getStr());
		final EList<? extends EObject> Suffix_183_list = PostfixExpression_181_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_183_list);
		Assert.assertEquals(1, Suffix_183_list.size());
		//183
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_184_Var
		 = (PostfixExpressionSuffixArgument)Suffix_183_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_184_Var
		);
		//184
		final ArgumentExpressionList ArgumentExpressionList_185_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_184_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_185_Var
		);
		final EList<? extends EObject> Expr_185_list = ArgumentExpressionList_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final AssignmentExpression AssignmentExpression_186_Var
		 = (AssignmentExpression)Expr_185_list.get(0);
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
		//199
		final PostfixExpression PostfixExpression_200_Var
		 = (PostfixExpression)UnaryExpression_199_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = PostfixExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final PrimaryExpression PrimaryExpression_201_Var
		 = (PrimaryExpression)Expr_200_list.get(0);
		Assert.assertNotNull(PrimaryExpression_201_Var
		);
		Assert.assertEquals("arg3", PrimaryExpression_201_Var
		.getId());
		//201
		final AsmLineWithColon AsmLineWithColon_202_Var
		 = (AsmLineWithColon)AsmLine_49_list.get(5);
		Assert.assertNotNull(AsmLineWithColon_202_Var
		);
		//202
		final LogicalOrExpression LogicalOrExpression_203_Var
		 = (LogicalOrExpression)AsmLineWithColon_202_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = LogicalOrExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final LogicalAndExpression LogicalAndExpression_204_Var
		 = (LogicalAndExpression)Expr_203_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = LogicalAndExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final InclusiveOrExpression InclusiveOrExpression_205_Var
		 = (InclusiveOrExpression)Expr_204_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = InclusiveOrExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final ExclusiveOrExpression ExclusiveOrExpression_206_Var
		 = (ExclusiveOrExpression)Expr_205_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = ExclusiveOrExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final AndExpression AndExpression_207_Var
		 = (AndExpression)Expr_206_list.get(0);
		Assert.assertNotNull(AndExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = AndExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final EqualityExpression EqualityExpression_208_Var
		 = (EqualityExpression)Expr_207_list.get(0);
		Assert.assertNotNull(EqualityExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = EqualityExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final RelationalExpression RelationalExpression_209_Var
		 = (RelationalExpression)Expr_208_list.get(0);
		Assert.assertNotNull(RelationalExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = RelationalExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final ShiftExpression ShiftExpression_210_Var
		 = (ShiftExpression)Expr_209_list.get(0);
		Assert.assertNotNull(ShiftExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = ShiftExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final AdditiveExpression AdditiveExpression_211_Var
		 = (AdditiveExpression)Expr_210_list.get(0);
		Assert.assertNotNull(AdditiveExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = AdditiveExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final MultiplicativeExpression MultiplicativeExpression_212_Var
		 = (MultiplicativeExpression)Expr_211_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = MultiplicativeExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final CastExpression CastExpression_213_Var
		 = (CastExpression)Expr_212_list.get(0);
		Assert.assertNotNull(CastExpression_213_Var
		);
		//213
		final UnaryExpression UnaryExpression_214_Var
		 = (UnaryExpression)CastExpression_213_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_214_Var
		);
		//214
		final PostfixExpression PostfixExpression_215_Var
		 = (PostfixExpression)UnaryExpression_214_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = PostfixExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final PrimaryExpression PrimaryExpression_216_Var
		 = (PrimaryExpression)Expr_215_list.get(0);
		Assert.assertNotNull(PrimaryExpression_216_Var
		);
		//216
		final Constant2 Constant2_217_Var
		 = (Constant2)PrimaryExpression_216_Var
		.getConst();
		Assert.assertNotNull(Constant2_217_Var
		);
		Assert.assertEquals("\"a\"", Constant2_217_Var
		.getStr());
		final EList<? extends EObject> Suffix_217_list = PostfixExpression_215_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_217_list);
		Assert.assertEquals(1, Suffix_217_list.size());
		//217
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_218_Var
		 = (PostfixExpressionSuffixArgument)Suffix_217_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_218_Var
		);
		//218
		final ArgumentExpressionList ArgumentExpressionList_219_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_218_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_219_Var
		);
		final EList<? extends EObject> Expr_219_list = ArgumentExpressionList_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final AssignmentExpression AssignmentExpression_220_Var
		 = (AssignmentExpression)Expr_219_list.get(0);
		Assert.assertNotNull(AssignmentExpression_220_Var
		);
		//220
		final ConditionalExpression ConditionalExpression_221_Var
		 = (ConditionalExpression)AssignmentExpression_220_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_221_Var
		);
		//221
		final LogicalOrExpression LogicalOrExpression_222_Var
		 = (LogicalOrExpression)ConditionalExpression_221_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = LogicalOrExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final LogicalAndExpression LogicalAndExpression_223_Var
		 = (LogicalAndExpression)Expr_222_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = LogicalAndExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final InclusiveOrExpression InclusiveOrExpression_224_Var
		 = (InclusiveOrExpression)Expr_223_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = InclusiveOrExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final ExclusiveOrExpression ExclusiveOrExpression_225_Var
		 = (ExclusiveOrExpression)Expr_224_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = ExclusiveOrExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final AndExpression AndExpression_226_Var
		 = (AndExpression)Expr_225_list.get(0);
		Assert.assertNotNull(AndExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = AndExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final EqualityExpression EqualityExpression_227_Var
		 = (EqualityExpression)Expr_226_list.get(0);
		Assert.assertNotNull(EqualityExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = EqualityExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final RelationalExpression RelationalExpression_228_Var
		 = (RelationalExpression)Expr_227_list.get(0);
		Assert.assertNotNull(RelationalExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = RelationalExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final ShiftExpression ShiftExpression_229_Var
		 = (ShiftExpression)Expr_228_list.get(0);
		Assert.assertNotNull(ShiftExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = ShiftExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final AdditiveExpression AdditiveExpression_230_Var
		 = (AdditiveExpression)Expr_229_list.get(0);
		Assert.assertNotNull(AdditiveExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = AdditiveExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final MultiplicativeExpression MultiplicativeExpression_231_Var
		 = (MultiplicativeExpression)Expr_230_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = MultiplicativeExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final CastExpression CastExpression_232_Var
		 = (CastExpression)Expr_231_list.get(0);
		Assert.assertNotNull(CastExpression_232_Var
		);
		//232
		final UnaryExpression UnaryExpression_233_Var
		 = (UnaryExpression)CastExpression_232_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_233_Var
		);
		//233
		final PostfixExpression PostfixExpression_234_Var
		 = (PostfixExpression)UnaryExpression_233_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = PostfixExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final PrimaryExpression PrimaryExpression_235_Var
		 = (PrimaryExpression)Expr_234_list.get(0);
		Assert.assertNotNull(PrimaryExpression_235_Var
		);
		//235
		final Constant2 Constant2_236_Var
		 = (Constant2)PrimaryExpression_235_Var
		.getConst();
		Assert.assertNotNull(Constant2_236_Var
		);
		Assert.assertEquals("128", Constant2_236_Var
		.getDec());
		//236
		final AsmLine AsmLine_237_Var
		 = (AsmLine)AsmLine_49_list.get(6);
		Assert.assertNotNull(AsmLine_237_Var
		);
		//237
		final LogicalOrExpression LogicalOrExpression_238_Var
		 = (LogicalOrExpression)AsmLine_237_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = LogicalOrExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final LogicalAndExpression LogicalAndExpression_239_Var
		 = (LogicalAndExpression)Expr_238_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = LogicalAndExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final InclusiveOrExpression InclusiveOrExpression_240_Var
		 = (InclusiveOrExpression)Expr_239_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = InclusiveOrExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final ExclusiveOrExpression ExclusiveOrExpression_241_Var
		 = (ExclusiveOrExpression)Expr_240_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = ExclusiveOrExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final AndExpression AndExpression_242_Var
		 = (AndExpression)Expr_241_list.get(0);
		Assert.assertNotNull(AndExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = AndExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final EqualityExpression EqualityExpression_243_Var
		 = (EqualityExpression)Expr_242_list.get(0);
		Assert.assertNotNull(EqualityExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = EqualityExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final RelationalExpression RelationalExpression_244_Var
		 = (RelationalExpression)Expr_243_list.get(0);
		Assert.assertNotNull(RelationalExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = RelationalExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final ShiftExpression ShiftExpression_245_Var
		 = (ShiftExpression)Expr_244_list.get(0);
		Assert.assertNotNull(ShiftExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = ShiftExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final AdditiveExpression AdditiveExpression_246_Var
		 = (AdditiveExpression)Expr_245_list.get(0);
		Assert.assertNotNull(AdditiveExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = AdditiveExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final MultiplicativeExpression MultiplicativeExpression_247_Var
		 = (MultiplicativeExpression)Expr_246_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = MultiplicativeExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final CastExpression CastExpression_248_Var
		 = (CastExpression)Expr_247_list.get(0);
		Assert.assertNotNull(CastExpression_248_Var
		);
		//248
		final UnaryExpression UnaryExpression_249_Var
		 = (UnaryExpression)CastExpression_248_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_249_Var
		);
		//249
		final PostfixExpression PostfixExpression_250_Var
		 = (PostfixExpression)UnaryExpression_249_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = PostfixExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final PrimaryExpression PrimaryExpression_251_Var
		 = (PrimaryExpression)Expr_250_list.get(0);
		Assert.assertNotNull(PrimaryExpression_251_Var
		);
		//251
		final Constant2 Constant2_252_Var
		 = (Constant2)PrimaryExpression_251_Var
		.getConst();
		Assert.assertNotNull(Constant2_252_Var
		);
		Assert.assertEquals("\"memory\"", Constant2_252_Var
		.getStr());
		//252
		final AsmLineWithComma AsmLineWithComma_253_Var
		 = (AsmLineWithComma)AsmLine_49_list.get(7);
		Assert.assertNotNull(AsmLineWithComma_253_Var
		);
		//253
		final LogicalOrExpression LogicalOrExpression_254_Var
		 = (LogicalOrExpression)AsmLineWithComma_253_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = LogicalOrExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final LogicalAndExpression LogicalAndExpression_255_Var
		 = (LogicalAndExpression)Expr_254_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_255_Var
		);
		final EList<? extends EObject> Expr_255_list = LogicalAndExpression_255_Var
		.getExpr();
		Assert.assertNotNull(Expr_255_list);
		Assert.assertEquals(1, Expr_255_list.size());
		//255
		final InclusiveOrExpression InclusiveOrExpression_256_Var
		 = (InclusiveOrExpression)Expr_255_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_256_Var
		);
		final EList<? extends EObject> Expr_256_list = InclusiveOrExpression_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(1, Expr_256_list.size());
		//256
		final ExclusiveOrExpression ExclusiveOrExpression_257_Var
		 = (ExclusiveOrExpression)Expr_256_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = ExclusiveOrExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final AndExpression AndExpression_258_Var
		 = (AndExpression)Expr_257_list.get(0);
		Assert.assertNotNull(AndExpression_258_Var
		);
		final EList<? extends EObject> Expr_258_list = AndExpression_258_Var
		.getExpr();
		Assert.assertNotNull(Expr_258_list);
		Assert.assertEquals(1, Expr_258_list.size());
		//258
		final EqualityExpression EqualityExpression_259_Var
		 = (EqualityExpression)Expr_258_list.get(0);
		Assert.assertNotNull(EqualityExpression_259_Var
		);
		final EList<? extends EObject> Expr_259_list = EqualityExpression_259_Var
		.getExpr();
		Assert.assertNotNull(Expr_259_list);
		Assert.assertEquals(1, Expr_259_list.size());
		//259
		final RelationalExpression RelationalExpression_260_Var
		 = (RelationalExpression)Expr_259_list.get(0);
		Assert.assertNotNull(RelationalExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = RelationalExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final ShiftExpression ShiftExpression_261_Var
		 = (ShiftExpression)Expr_260_list.get(0);
		Assert.assertNotNull(ShiftExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = ShiftExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final AdditiveExpression AdditiveExpression_262_Var
		 = (AdditiveExpression)Expr_261_list.get(0);
		Assert.assertNotNull(AdditiveExpression_262_Var
		);
		final EList<? extends EObject> Expr_262_list = AdditiveExpression_262_Var
		.getExpr();
		Assert.assertNotNull(Expr_262_list);
		Assert.assertEquals(1, Expr_262_list.size());
		//262
		final MultiplicativeExpression MultiplicativeExpression_263_Var
		 = (MultiplicativeExpression)Expr_262_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_263_Var
		);
		final EList<? extends EObject> Expr_263_list = MultiplicativeExpression_263_Var
		.getExpr();
		Assert.assertNotNull(Expr_263_list);
		Assert.assertEquals(1, Expr_263_list.size());
		//263
		final CastExpression CastExpression_264_Var
		 = (CastExpression)Expr_263_list.get(0);
		Assert.assertNotNull(CastExpression_264_Var
		);
		//264
		final UnaryExpression UnaryExpression_265_Var
		 = (UnaryExpression)CastExpression_264_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_265_Var
		);
		//265
		final PostfixExpression PostfixExpression_266_Var
		 = (PostfixExpression)UnaryExpression_265_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_266_Var
		);
		final EList<? extends EObject> Expr_266_list = PostfixExpression_266_Var
		.getExpr();
		Assert.assertNotNull(Expr_266_list);
		Assert.assertEquals(1, Expr_266_list.size());
		//266
		final PrimaryExpression PrimaryExpression_267_Var
		 = (PrimaryExpression)Expr_266_list.get(0);
		Assert.assertNotNull(PrimaryExpression_267_Var
		);
		//267
		final Constant2 Constant2_268_Var
		 = (Constant2)PrimaryExpression_267_Var
		.getConst();
		Assert.assertNotNull(Constant2_268_Var
		);
		Assert.assertEquals("\"cc\"", Constant2_268_Var
		.getStr());
		Assert.assertEquals(";", AsmStatement_49_Var
		.getSemi());
		//268
		final Statement Statement_269_Var
		 = (Statement)Statement_47_list.get(1);
		Assert.assertNotNull(Statement_269_Var
		);
		//269
		final SelectionStatement SelectionStatement_270_Var
		 = (SelectionStatement)Statement_269_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_270_Var
		);
		Assert.assertEquals("if", SelectionStatement_270_Var
		.getIf());
		//270
		final Expression Expression_271_Var
		 = (Expression)SelectionStatement_270_Var
		.getExpr();
		Assert.assertNotNull(Expression_271_Var
		);
		final EList<? extends EObject> ExprExpr_271_list = Expression_271_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_271_list);
		Assert.assertEquals(1, ExprExpr_271_list.size());
		//271
		final AssignmentExpression AssignmentExpression_272_Var
		 = (AssignmentExpression)ExprExpr_271_list.get(0);
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
		Assert.assertEquals(2, Expr_275_list.size());
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
		Assert.assertEquals("[<=]", RelationalExpression_280_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_280_list = RelationalExpression_280_Var
		.getExpr();
		Assert.assertNotNull(Expr_280_list);
		Assert.assertEquals(2, Expr_280_list.size());
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
		final CastExpression CastExpression_286_Var
		 = (CastExpression)UnaryExpression_285_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_286_Var
		);
		//286
		final UnaryExpression UnaryExpression_287_Var
		 = (UnaryExpression)CastExpression_286_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_287_Var
		);
		//287
		final PostfixExpression PostfixExpression_288_Var
		 = (PostfixExpression)UnaryExpression_287_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_288_Var
		);
		final EList<? extends EObject> Expr_288_list = PostfixExpression_288_Var
		.getExpr();
		Assert.assertNotNull(Expr_288_list);
		Assert.assertEquals(1, Expr_288_list.size());
		//288
		final PrimaryExpression PrimaryExpression_289_Var
		 = (PrimaryExpression)Expr_288_list.get(0);
		Assert.assertNotNull(PrimaryExpression_289_Var
		);
		//289
		final Constant2 Constant2_290_Var
		 = (Constant2)PrimaryExpression_289_Var
		.getConst();
		Assert.assertNotNull(Constant2_290_Var
		);
		Assert.assertEquals("125", Constant2_290_Var
		.getDec());
		//290
		final UnaryOperator UnaryOperator_291_Var
		 = (UnaryOperator)UnaryExpression_285_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_291_Var
		);
		Assert.assertEquals("-", UnaryOperator_291_Var
		.getOp());
		//291
		final ShiftExpression ShiftExpression_292_Var
		 = (ShiftExpression)Expr_280_list.get(1);
		Assert.assertNotNull(ShiftExpression_292_Var
		);
		final EList<? extends EObject> Expr_292_list = ShiftExpression_292_Var
		.getExpr();
		Assert.assertNotNull(Expr_292_list);
		Assert.assertEquals(1, Expr_292_list.size());
		//292
		final AdditiveExpression AdditiveExpression_293_Var
		 = (AdditiveExpression)Expr_292_list.get(0);
		Assert.assertNotNull(AdditiveExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = AdditiveExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final MultiplicativeExpression MultiplicativeExpression_294_Var
		 = (MultiplicativeExpression)Expr_293_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_294_Var
		);
		final EList<? extends EObject> Expr_294_list = MultiplicativeExpression_294_Var
		.getExpr();
		Assert.assertNotNull(Expr_294_list);
		Assert.assertEquals(1, Expr_294_list.size());
		//294
		final CastExpression CastExpression_295_Var
		 = (CastExpression)Expr_294_list.get(0);
		Assert.assertNotNull(CastExpression_295_Var
		);
		//295
		final UnaryExpression UnaryExpression_296_Var
		 = (UnaryExpression)CastExpression_295_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_296_Var
		);
		//296
		final PostfixExpression PostfixExpression_297_Var
		 = (PostfixExpression)UnaryExpression_296_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_297_Var
		);
		final EList<? extends EObject> Expr_297_list = PostfixExpression_297_Var
		.getExpr();
		Assert.assertNotNull(Expr_297_list);
		Assert.assertEquals(1, Expr_297_list.size());
		//297
		final PrimaryExpression PrimaryExpression_298_Var
		 = (PrimaryExpression)Expr_297_list.get(0);
		Assert.assertNotNull(PrimaryExpression_298_Var
		);
		Assert.assertEquals("res", PrimaryExpression_298_Var
		.getId());
		//298
		final InclusiveOrExpression InclusiveOrExpression_299_Var
		 = (InclusiveOrExpression)Expr_275_list.get(1);
		Assert.assertNotNull(InclusiveOrExpression_299_Var
		);
		final EList<? extends EObject> Expr_299_list = InclusiveOrExpression_299_Var
		.getExpr();
		Assert.assertNotNull(Expr_299_list);
		Assert.assertEquals(1, Expr_299_list.size());
		//299
		final ExclusiveOrExpression ExclusiveOrExpression_300_Var
		 = (ExclusiveOrExpression)Expr_299_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_300_Var
		);
		final EList<? extends EObject> Expr_300_list = ExclusiveOrExpression_300_Var
		.getExpr();
		Assert.assertNotNull(Expr_300_list);
		Assert.assertEquals(1, Expr_300_list.size());
		//300
		final AndExpression AndExpression_301_Var
		 = (AndExpression)Expr_300_list.get(0);
		Assert.assertNotNull(AndExpression_301_Var
		);
		final EList<? extends EObject> Expr_301_list = AndExpression_301_Var
		.getExpr();
		Assert.assertNotNull(Expr_301_list);
		Assert.assertEquals(1, Expr_301_list.size());
		//301
		final EqualityExpression EqualityExpression_302_Var
		 = (EqualityExpression)Expr_301_list.get(0);
		Assert.assertNotNull(EqualityExpression_302_Var
		);
		final EList<? extends EObject> Expr_302_list = EqualityExpression_302_Var
		.getExpr();
		Assert.assertNotNull(Expr_302_list);
		Assert.assertEquals(1, Expr_302_list.size());
		//302
		final RelationalExpression RelationalExpression_303_Var
		 = (RelationalExpression)Expr_302_list.get(0);
		Assert.assertNotNull(RelationalExpression_303_Var
		);
		Assert.assertEquals("[<]", RelationalExpression_303_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_303_list = RelationalExpression_303_Var
		.getExpr();
		Assert.assertNotNull(Expr_303_list);
		Assert.assertEquals(2, Expr_303_list.size());
		//303
		final ShiftExpression ShiftExpression_304_Var
		 = (ShiftExpression)Expr_303_list.get(0);
		Assert.assertNotNull(ShiftExpression_304_Var
		);
		final EList<? extends EObject> Expr_304_list = ShiftExpression_304_Var
		.getExpr();
		Assert.assertNotNull(Expr_304_list);
		Assert.assertEquals(1, Expr_304_list.size());
		//304
		final AdditiveExpression AdditiveExpression_305_Var
		 = (AdditiveExpression)Expr_304_list.get(0);
		Assert.assertNotNull(AdditiveExpression_305_Var
		);
		final EList<? extends EObject> Expr_305_list = AdditiveExpression_305_Var
		.getExpr();
		Assert.assertNotNull(Expr_305_list);
		Assert.assertEquals(1, Expr_305_list.size());
		//305
		final MultiplicativeExpression MultiplicativeExpression_306_Var
		 = (MultiplicativeExpression)Expr_305_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_306_Var
		);
		final EList<? extends EObject> Expr_306_list = MultiplicativeExpression_306_Var
		.getExpr();
		Assert.assertNotNull(Expr_306_list);
		Assert.assertEquals(1, Expr_306_list.size());
		//306
		final CastExpression CastExpression_307_Var
		 = (CastExpression)Expr_306_list.get(0);
		Assert.assertNotNull(CastExpression_307_Var
		);
		//307
		final UnaryExpression UnaryExpression_308_Var
		 = (UnaryExpression)CastExpression_307_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_308_Var
		);
		//308
		final PostfixExpression PostfixExpression_309_Var
		 = (PostfixExpression)UnaryExpression_308_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_309_Var
		);
		final EList<? extends EObject> Expr_309_list = PostfixExpression_309_Var
		.getExpr();
		Assert.assertNotNull(Expr_309_list);
		Assert.assertEquals(1, Expr_309_list.size());
		//309
		final PrimaryExpression PrimaryExpression_310_Var
		 = (PrimaryExpression)Expr_309_list.get(0);
		Assert.assertNotNull(PrimaryExpression_310_Var
		);
		Assert.assertEquals("res", PrimaryExpression_310_Var
		.getId());
		//310
		final ShiftExpression ShiftExpression_311_Var
		 = (ShiftExpression)Expr_303_list.get(1);
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
		//317
		final Constant2 Constant2_318_Var
		 = (Constant2)PrimaryExpression_317_Var
		.getConst();
		Assert.assertNotNull(Constant2_318_Var
		);
		Assert.assertEquals("0", Constant2_318_Var
		.getDec());
		//318
		final Statement Statement_319_Var
		 = (Statement)SelectionStatement_270_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_319_Var
		);
		//319
		final CompoundStatement CompoundStatement_320_Var
		 = (CompoundStatement)Statement_319_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_320_Var
		);
		//320
		final BodyStatement BodyStatement_321_Var
		 = (BodyStatement)CompoundStatement_320_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_321_Var
		);
		final EList<? extends EObject> BlockList_321_list = BodyStatement_321_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_321_list);
		Assert.assertEquals(1, BlockList_321_list.size());
		//321
		final BlockList BlockList_322_Var
		 = (BlockList)BlockList_321_list.get(0);
		Assert.assertNotNull(BlockList_322_Var
		);
		final EList<? extends EObject> Statement_322_list = BlockList_322_Var
		.getStatement();
		Assert.assertNotNull(Statement_322_list);
		Assert.assertEquals(2, Statement_322_list.size());
		//322
		final Statement Statement_323_Var
		 = (Statement)Statement_322_list.get(0);
		Assert.assertNotNull(Statement_323_Var
		);
		//323
		final ExpressionStatement ExpressionStatement_324_Var
		 = (ExpressionStatement)Statement_323_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_324_Var
		);
		//324
		final Expression Expression_325_Var
		 = (Expression)ExpressionStatement_324_Var
		.getExpression();
		Assert.assertNotNull(Expression_325_Var
		);
		final EList<? extends EObject> ExprExpr_325_list = Expression_325_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_325_list);
		Assert.assertEquals(1, ExprExpr_325_list.size());
		//325
		final AssignmentExpression AssignmentExpression_326_Var
		 = (AssignmentExpression)ExprExpr_325_list.get(0);
		Assert.assertNotNull(AssignmentExpression_326_Var
		);
		//326
		final UnaryExpression UnaryExpression_327_Var
		 = (UnaryExpression)AssignmentExpression_326_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_327_Var
		);
		//327
		final PostfixExpression PostfixExpression_328_Var
		 = (PostfixExpression)UnaryExpression_327_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_328_Var
		);
		final EList<? extends EObject> Expr_328_list = PostfixExpression_328_Var
		.getExpr();
		Assert.assertNotNull(Expr_328_list);
		Assert.assertEquals(1, Expr_328_list.size());
		//328
		final PrimaryExpression PrimaryExpression_329_Var
		 = (PrimaryExpression)Expr_328_list.get(0);
		Assert.assertNotNull(PrimaryExpression_329_Var
		);
		Assert.assertEquals("errno", PrimaryExpression_329_Var
		.getId());
		//329
		final AssignmentOperator AssignmentOperator_330_Var
		 = (AssignmentOperator)AssignmentExpression_326_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_330_Var
		);
		Assert.assertEquals("=", AssignmentOperator_330_Var
		.getOp());
		//330
		final AssignmentExpression AssignmentExpression_331_Var
		 = (AssignmentExpression)AssignmentExpression_326_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_331_Var
		);
		//331
		final ConditionalExpression ConditionalExpression_332_Var
		 = (ConditionalExpression)AssignmentExpression_331_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_332_Var
		);
		//332
		final LogicalOrExpression LogicalOrExpression_333_Var
		 = (LogicalOrExpression)ConditionalExpression_332_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = LogicalOrExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final LogicalAndExpression LogicalAndExpression_334_Var
		 = (LogicalAndExpression)Expr_333_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = LogicalAndExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final InclusiveOrExpression InclusiveOrExpression_335_Var
		 = (InclusiveOrExpression)Expr_334_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = InclusiveOrExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final ExclusiveOrExpression ExclusiveOrExpression_336_Var
		 = (ExclusiveOrExpression)Expr_335_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = ExclusiveOrExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final AndExpression AndExpression_337_Var
		 = (AndExpression)Expr_336_list.get(0);
		Assert.assertNotNull(AndExpression_337_Var
		);
		final EList<? extends EObject> Expr_337_list = AndExpression_337_Var
		.getExpr();
		Assert.assertNotNull(Expr_337_list);
		Assert.assertEquals(1, Expr_337_list.size());
		//337
		final EqualityExpression EqualityExpression_338_Var
		 = (EqualityExpression)Expr_337_list.get(0);
		Assert.assertNotNull(EqualityExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = EqualityExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final RelationalExpression RelationalExpression_339_Var
		 = (RelationalExpression)Expr_338_list.get(0);
		Assert.assertNotNull(RelationalExpression_339_Var
		);
		final EList<? extends EObject> Expr_339_list = RelationalExpression_339_Var
		.getExpr();
		Assert.assertNotNull(Expr_339_list);
		Assert.assertEquals(1, Expr_339_list.size());
		//339
		final ShiftExpression ShiftExpression_340_Var
		 = (ShiftExpression)Expr_339_list.get(0);
		Assert.assertNotNull(ShiftExpression_340_Var
		);
		final EList<? extends EObject> Expr_340_list = ShiftExpression_340_Var
		.getExpr();
		Assert.assertNotNull(Expr_340_list);
		Assert.assertEquals(1, Expr_340_list.size());
		//340
		final AdditiveExpression AdditiveExpression_341_Var
		 = (AdditiveExpression)Expr_340_list.get(0);
		Assert.assertNotNull(AdditiveExpression_341_Var
		);
		final EList<? extends EObject> Expr_341_list = AdditiveExpression_341_Var
		.getExpr();
		Assert.assertNotNull(Expr_341_list);
		Assert.assertEquals(1, Expr_341_list.size());
		//341
		final MultiplicativeExpression MultiplicativeExpression_342_Var
		 = (MultiplicativeExpression)Expr_341_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_342_Var
		);
		final EList<? extends EObject> Expr_342_list = MultiplicativeExpression_342_Var
		.getExpr();
		Assert.assertNotNull(Expr_342_list);
		Assert.assertEquals(1, Expr_342_list.size());
		//342
		final CastExpression CastExpression_343_Var
		 = (CastExpression)Expr_342_list.get(0);
		Assert.assertNotNull(CastExpression_343_Var
		);
		//343
		final UnaryExpression UnaryExpression_344_Var
		 = (UnaryExpression)CastExpression_343_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_344_Var
		);
		//344
		final UnaryOperator UnaryOperator_345_Var
		 = (UnaryOperator)UnaryExpression_344_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_345_Var
		);
		Assert.assertEquals("-", UnaryOperator_345_Var
		.getOp());
		//345
		final CastExpression CastExpression_346_Var
		 = (CastExpression)UnaryExpression_344_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_346_Var
		);
		//346
		final UnaryExpression UnaryExpression_347_Var
		 = (UnaryExpression)CastExpression_346_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_347_Var
		);
		//347
		final PostfixExpression PostfixExpression_348_Var
		 = (PostfixExpression)UnaryExpression_347_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_348_Var
		);
		final EList<? extends EObject> Expr_348_list = PostfixExpression_348_Var
		.getExpr();
		Assert.assertNotNull(Expr_348_list);
		Assert.assertEquals(1, Expr_348_list.size());
		//348
		final PrimaryExpression PrimaryExpression_349_Var
		 = (PrimaryExpression)Expr_348_list.get(0);
		Assert.assertNotNull(PrimaryExpression_349_Var
		);
		Assert.assertEquals("res", PrimaryExpression_349_Var
		.getId());
		//349
		final Statement Statement_350_Var
		 = (Statement)Statement_322_list.get(1);
		Assert.assertNotNull(Statement_350_Var
		);
		//350
		final ExpressionStatement ExpressionStatement_351_Var
		 = (ExpressionStatement)Statement_350_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_351_Var
		);
		//351
		final Expression Expression_352_Var
		 = (Expression)ExpressionStatement_351_Var
		.getExpression();
		Assert.assertNotNull(Expression_352_Var
		);
		final EList<? extends EObject> ExprExpr_352_list = Expression_352_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_352_list);
		Assert.assertEquals(1, ExprExpr_352_list.size());
		//352
		final AssignmentExpression AssignmentExpression_353_Var
		 = (AssignmentExpression)ExprExpr_352_list.get(0);
		Assert.assertNotNull(AssignmentExpression_353_Var
		);
		//353
		final UnaryExpression UnaryExpression_354_Var
		 = (UnaryExpression)AssignmentExpression_353_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_354_Var
		);
		//354
		final PostfixExpression PostfixExpression_355_Var
		 = (PostfixExpression)UnaryExpression_354_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_355_Var
		);
		final EList<? extends EObject> Expr_355_list = PostfixExpression_355_Var
		.getExpr();
		Assert.assertNotNull(Expr_355_list);
		Assert.assertEquals(1, Expr_355_list.size());
		//355
		final PrimaryExpression PrimaryExpression_356_Var
		 = (PrimaryExpression)Expr_355_list.get(0);
		Assert.assertNotNull(PrimaryExpression_356_Var
		);
		Assert.assertEquals("res", PrimaryExpression_356_Var
		.getId());
		//356
		final AssignmentOperator AssignmentOperator_357_Var
		 = (AssignmentOperator)AssignmentExpression_353_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_357_Var
		);
		Assert.assertEquals("=", AssignmentOperator_357_Var
		.getOp());
		//357
		final AssignmentExpression AssignmentExpression_358_Var
		 = (AssignmentExpression)AssignmentExpression_353_Var
		.getAssignmentExpr();
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
		final UnaryOperator UnaryOperator_372_Var
		 = (UnaryOperator)UnaryExpression_371_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_372_Var
		);
		Assert.assertEquals("-", UnaryOperator_372_Var
		.getOp());
		//372
		final CastExpression CastExpression_373_Var
		 = (CastExpression)UnaryExpression_371_Var
		.getExpr();
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
		Assert.assertEquals("1", Constant2_377_Var
		.getDec());
		//377
		final Statement Statement_378_Var
		 = (Statement)Statement_47_list.get(2);
		Assert.assertNotNull(Statement_378_Var
		);
		//378
		final JumpStatement JumpStatement_379_Var
		 = (JumpStatement)Statement_378_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_379_Var
		);
		//379
		final Expression Expression_380_Var
		 = (Expression)JumpStatement_379_Var
		.getExpr();
		Assert.assertNotNull(Expression_380_Var
		);
		final EList<? extends EObject> ExprExpr_380_list = Expression_380_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_380_list);
		Assert.assertEquals(1, ExprExpr_380_list.size());
		//380
		final AssignmentExpression AssignmentExpression_381_Var
		 = (AssignmentExpression)ExprExpr_380_list.get(0);
		Assert.assertNotNull(AssignmentExpression_381_Var
		);
		//381
		final ConditionalExpression ConditionalExpression_382_Var
		 = (ConditionalExpression)AssignmentExpression_381_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_382_Var
		);
		//382
		final LogicalOrExpression LogicalOrExpression_383_Var
		 = (LogicalOrExpression)ConditionalExpression_382_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_383_Var
		);
		final EList<? extends EObject> Expr_383_list = LogicalOrExpression_383_Var
		.getExpr();
		Assert.assertNotNull(Expr_383_list);
		Assert.assertEquals(1, Expr_383_list.size());
		//383
		final LogicalAndExpression LogicalAndExpression_384_Var
		 = (LogicalAndExpression)Expr_383_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_384_Var
		);
		final EList<? extends EObject> Expr_384_list = LogicalAndExpression_384_Var
		.getExpr();
		Assert.assertNotNull(Expr_384_list);
		Assert.assertEquals(1, Expr_384_list.size());
		//384
		final InclusiveOrExpression InclusiveOrExpression_385_Var
		 = (InclusiveOrExpression)Expr_384_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_385_Var
		);
		final EList<? extends EObject> Expr_385_list = InclusiveOrExpression_385_Var
		.getExpr();
		Assert.assertNotNull(Expr_385_list);
		Assert.assertEquals(1, Expr_385_list.size());
		//385
		final ExclusiveOrExpression ExclusiveOrExpression_386_Var
		 = (ExclusiveOrExpression)Expr_385_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_386_Var
		);
		final EList<? extends EObject> Expr_386_list = ExclusiveOrExpression_386_Var
		.getExpr();
		Assert.assertNotNull(Expr_386_list);
		Assert.assertEquals(1, Expr_386_list.size());
		//386
		final AndExpression AndExpression_387_Var
		 = (AndExpression)Expr_386_list.get(0);
		Assert.assertNotNull(AndExpression_387_Var
		);
		final EList<? extends EObject> Expr_387_list = AndExpression_387_Var
		.getExpr();
		Assert.assertNotNull(Expr_387_list);
		Assert.assertEquals(1, Expr_387_list.size());
		//387
		final EqualityExpression EqualityExpression_388_Var
		 = (EqualityExpression)Expr_387_list.get(0);
		Assert.assertNotNull(EqualityExpression_388_Var
		);
		final EList<? extends EObject> Expr_388_list = EqualityExpression_388_Var
		.getExpr();
		Assert.assertNotNull(Expr_388_list);
		Assert.assertEquals(1, Expr_388_list.size());
		//388
		final RelationalExpression RelationalExpression_389_Var
		 = (RelationalExpression)Expr_388_list.get(0);
		Assert.assertNotNull(RelationalExpression_389_Var
		);
		final EList<? extends EObject> Expr_389_list = RelationalExpression_389_Var
		.getExpr();
		Assert.assertNotNull(Expr_389_list);
		Assert.assertEquals(1, Expr_389_list.size());
		//389
		final ShiftExpression ShiftExpression_390_Var
		 = (ShiftExpression)Expr_389_list.get(0);
		Assert.assertNotNull(ShiftExpression_390_Var
		);
		final EList<? extends EObject> Expr_390_list = ShiftExpression_390_Var
		.getExpr();
		Assert.assertNotNull(Expr_390_list);
		Assert.assertEquals(1, Expr_390_list.size());
		//390
		final AdditiveExpression AdditiveExpression_391_Var
		 = (AdditiveExpression)Expr_390_list.get(0);
		Assert.assertNotNull(AdditiveExpression_391_Var
		);
		final EList<? extends EObject> Expr_391_list = AdditiveExpression_391_Var
		.getExpr();
		Assert.assertNotNull(Expr_391_list);
		Assert.assertEquals(1, Expr_391_list.size());
		//391
		final MultiplicativeExpression MultiplicativeExpression_392_Var
		 = (MultiplicativeExpression)Expr_391_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_392_Var
		);
		final EList<? extends EObject> Expr_392_list = MultiplicativeExpression_392_Var
		.getExpr();
		Assert.assertNotNull(Expr_392_list);
		Assert.assertEquals(1, Expr_392_list.size());
		//392
		final CastExpression CastExpression_393_Var
		 = (CastExpression)Expr_392_list.get(0);
		Assert.assertNotNull(CastExpression_393_Var
		);
		//393
		final UnaryExpression UnaryExpression_394_Var
		 = (UnaryExpression)CastExpression_393_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_394_Var
		);
		//394
		final PostfixExpression PostfixExpression_395_Var
		 = (PostfixExpression)UnaryExpression_394_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_395_Var
		);
		final EList<? extends EObject> Expr_395_list = PostfixExpression_395_Var
		.getExpr();
		Assert.assertNotNull(Expr_395_list);
		Assert.assertEquals(1, Expr_395_list.size());
		//395
		final PrimaryExpression PrimaryExpression_396_Var
		 = (PrimaryExpression)Expr_395_list.get(0);
		Assert.assertNotNull(PrimaryExpression_396_Var
		);
		Assert.assertEquals("res", PrimaryExpression_396_Var
		.getId());
		Assert.assertEquals("return", JumpStatement_379_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_379_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0029_Assembler.c");
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
				method.invoke(this.generator, "Test0029_Assembler.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0029_Assembler.c");
		final String expected = this.getTextFromFile(
			"res/Test0029_Assembler.c"
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


