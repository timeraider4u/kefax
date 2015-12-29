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
				"RULE_KW_ASM3", 
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
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0029_Assembler.c");
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
		Assert.assertEquals(2, External_0_list.size());
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
		Assert.assertEquals("extern", StorageClassSpecifier_4_Var
		.getName());
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
		Assert.assertEquals(1, InitDeclarator_6_list.size());
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
		Assert.assertEquals("errno", DirectDeclarator_9_Var
		.getId());
		Assert.assertEquals(";", Declaration_2_Var
		.getSemi());
		//9
		final ExternalDeclaration ExternalDeclaration_10_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_10_Var
		);
		//10
		final FunctionDefHead FunctionDefHead_11_Var
		 = (FunctionDefHead)ExternalDeclaration_10_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_11_Var
		);
		//11
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_12_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_11_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_12_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_12_list = FunctionDeclarationSpecifiers_12_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_12_list);
		Assert.assertEquals(1, DeclarationSpecifier_12_list.size());
		//12
		final TypeSpecifier TypeSpecifier_13_Var
		 = (TypeSpecifier)DeclarationSpecifier_12_list.get(0);
		Assert.assertNotNull(TypeSpecifier_13_Var
		);
		Assert.assertEquals("int", TypeSpecifier_13_Var
		.getName());
		//13
		final Declarator Declarator_14_Var
		 = (Declarator)FunctionDefHead_11_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_14_Var
		);
		//14
		final DirectDeclarator DirectDeclarator_15_Var
		 = (DirectDeclarator)Declarator_14_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_15_Var
		);
		Assert.assertEquals("funcname", DirectDeclarator_15_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_15_list = DirectDeclarator_15_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_15_list);
		Assert.assertEquals(1, DeclaratorSuffix_15_list.size());
		//15
		final DeclaratorSuffix DeclaratorSuffix_16_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_15_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_16_Var
		);
		//16
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_17_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_16_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_17_Var
		);
		final EList<? extends EObject> ParameterTypeList_17_list = DirectDeclaratorLastSuffix_17_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_17_list);
		Assert.assertEquals(1, ParameterTypeList_17_list.size());
		//17
		final ParameterTypeList ParameterTypeList_18_Var
		 = (ParameterTypeList)ParameterTypeList_17_list.get(0);
		Assert.assertNotNull(ParameterTypeList_18_Var
		);
		//18
		final ParameterList ParameterList_19_Var
		 = (ParameterList)ParameterTypeList_18_Var
		.getList();
		Assert.assertNotNull(ParameterList_19_Var
		);
		final EList<? extends EObject> ParameterDeclaration_19_list = ParameterList_19_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_19_list);
		Assert.assertEquals(3, ParameterDeclaration_19_list.size());
		//19
		final ParameterDeclaration ParameterDeclaration_20_Var
		 = (ParameterDeclaration)ParameterDeclaration_19_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_20_Var
		);
		//20
		final DeclarationSpecifiers DeclarationSpecifiers_21_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_20_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_21_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_21_list = DeclarationSpecifiers_21_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_21_list);
		Assert.assertEquals(1, DeclarationSpecifier_21_list.size());
		//21
		final TypeSpecifier TypeSpecifier_22_Var
		 = (TypeSpecifier)DeclarationSpecifier_21_list.get(0);
		Assert.assertNotNull(TypeSpecifier_22_Var
		);
		Assert.assertEquals("int", TypeSpecifier_22_Var
		.getName());
		//22
		final Declarator Declarator_23_Var
		 = (Declarator)ParameterDeclaration_20_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_23_Var
		);
		//23
		final DirectDeclarator DirectDeclarator_24_Var
		 = (DirectDeclarator)Declarator_23_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_24_Var
		);
		Assert.assertEquals("arg1", DirectDeclarator_24_Var
		.getId());
		//24
		final ParameterDeclaration ParameterDeclaration_25_Var
		 = (ParameterDeclaration)ParameterDeclaration_19_list.get(1);
		Assert.assertNotNull(ParameterDeclaration_25_Var
		);
		//25
		final DeclarationSpecifiers DeclarationSpecifiers_26_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_25_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_26_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_26_list = DeclarationSpecifiers_26_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_26_list);
		Assert.assertEquals(1, DeclarationSpecifier_26_list.size());
		//26
		final TypeSpecifier TypeSpecifier_27_Var
		 = (TypeSpecifier)DeclarationSpecifier_26_list.get(0);
		Assert.assertNotNull(TypeSpecifier_27_Var
		);
		Assert.assertEquals("int", TypeSpecifier_27_Var
		.getName());
		//27
		final Declarator Declarator_28_Var
		 = (Declarator)ParameterDeclaration_25_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_28_Var
		);
		//28
		final DirectDeclarator DirectDeclarator_29_Var
		 = (DirectDeclarator)Declarator_28_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_29_Var
		);
		Assert.assertEquals("arg2", DirectDeclarator_29_Var
		.getId());
		//29
		final Pointer Pointer_30_Var
		 = (Pointer)Declarator_28_Var
		.getPointer();
		Assert.assertNotNull(Pointer_30_Var
		);
		Assert.assertEquals("[*]", Pointer_30_Var
		.getStar().toString());
		//30
		final ParameterDeclaration ParameterDeclaration_31_Var
		 = (ParameterDeclaration)ParameterDeclaration_19_list.get(2);
		Assert.assertNotNull(ParameterDeclaration_31_Var
		);
		//31
		final DeclarationSpecifiers DeclarationSpecifiers_32_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_31_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_32_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_32_list = DeclarationSpecifiers_32_Var
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
		 = (Declarator)ParameterDeclaration_31_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_34_Var
		);
		//34
		final DirectDeclarator DirectDeclarator_35_Var
		 = (DirectDeclarator)Declarator_34_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_35_Var
		);
		Assert.assertEquals("arg3", DirectDeclarator_35_Var
		.getId());
		//35
		final FunctionDefinition FunctionDefinition_36_Var
		 = (FunctionDefinition)ExternalDeclaration_10_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_36_Var
		);
		//36
		final BodyStatement BodyStatement_37_Var
		 = (BodyStatement)FunctionDefinition_36_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_37_Var
		);
		final EList<? extends EObject> BlockList_37_list = BodyStatement_37_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_37_list);
		Assert.assertEquals(1, BlockList_37_list.size());
		//37
		final BlockList BlockList_38_Var
		 = (BlockList)BlockList_37_list.get(0);
		Assert.assertNotNull(BlockList_38_Var
		);
		final EList<? extends EObject> Declaration_38_list = BlockList_38_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_38_list);
		Assert.assertEquals(1, Declaration_38_list.size());
		//38
		final Declaration Declaration_39_Var
		 = (Declaration)Declaration_38_list.get(0);
		Assert.assertNotNull(Declaration_39_Var
		);
		//39
		final DeclarationSpecifiers DeclarationSpecifiers_40_Var
		 = (DeclarationSpecifiers)Declaration_39_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_40_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_40_list = DeclarationSpecifiers_40_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_40_list);
		Assert.assertEquals(1, DeclarationSpecifier_40_list.size());
		//40
		final TypeSpecifier TypeSpecifier_41_Var
		 = (TypeSpecifier)DeclarationSpecifier_40_list.get(0);
		Assert.assertNotNull(TypeSpecifier_41_Var
		);
		Assert.assertEquals("int", TypeSpecifier_41_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_41_list = Declaration_39_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_41_list);
		Assert.assertEquals(1, InitDeclaratorList_41_list.size());
		//41
		final InitDeclaratorList InitDeclaratorList_42_Var
		 = (InitDeclaratorList)InitDeclaratorList_41_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_42_Var
		);
		final EList<? extends EObject> InitDeclarator_42_list = InitDeclaratorList_42_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_42_list);
		Assert.assertEquals(1, InitDeclarator_42_list.size());
		//42
		final InitDeclarator InitDeclarator_43_Var
		 = (InitDeclarator)InitDeclarator_42_list.get(0);
		Assert.assertNotNull(InitDeclarator_43_Var
		);
		//43
		final Declarator Declarator_44_Var
		 = (Declarator)InitDeclarator_43_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_44_Var
		);
		//44
		final DirectDeclarator DirectDeclarator_45_Var
		 = (DirectDeclarator)Declarator_44_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_45_Var
		);
		Assert.assertEquals("res", DirectDeclarator_45_Var
		.getId());
		Assert.assertEquals(";", Declaration_39_Var
		.getSemi());
		final EList<? extends EObject> Statement_45_list = BlockList_38_Var
		.getStatement();
		Assert.assertNotNull(Statement_45_list);
		Assert.assertEquals(3, Statement_45_list.size());
		//45
		final Statement Statement_46_Var
		 = (Statement)Statement_45_list.get(0);
		Assert.assertNotNull(Statement_46_Var
		);
		//46
		final AsmStatement AsmStatement_47_Var
		 = (AsmStatement)Statement_46_Var
		.getStmt();
		Assert.assertNotNull(AsmStatement_47_Var
		);
		final EList<? extends EObject> AsmLine_47_list = AsmStatement_47_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLine_47_list);
		Assert.assertEquals(8, AsmLine_47_list.size());
		//47
		final AsmLineWithColon AsmLineWithColon_48_Var
		 = (AsmLineWithColon)AsmLine_47_list.get(0);
		Assert.assertNotNull(AsmLineWithColon_48_Var
		);
		//48
		final LogicalOrExpression LogicalOrExpression_49_Var
		 = (LogicalOrExpression)AsmLineWithColon_48_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_49_Var
		);
		final EList<? extends EObject> Expr_49_list = LogicalOrExpression_49_Var
		.getExpr();
		Assert.assertNotNull(Expr_49_list);
		Assert.assertEquals(1, Expr_49_list.size());
		//49
		final LogicalAndExpression LogicalAndExpression_50_Var
		 = (LogicalAndExpression)Expr_49_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = LogicalAndExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final InclusiveOrExpression InclusiveOrExpression_51_Var
		 = (InclusiveOrExpression)Expr_50_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = InclusiveOrExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final ExclusiveOrExpression ExclusiveOrExpression_52_Var
		 = (ExclusiveOrExpression)Expr_51_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = ExclusiveOrExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final AndExpression AndExpression_53_Var
		 = (AndExpression)Expr_52_list.get(0);
		Assert.assertNotNull(AndExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = AndExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final EqualityExpression EqualityExpression_54_Var
		 = (EqualityExpression)Expr_53_list.get(0);
		Assert.assertNotNull(EqualityExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = EqualityExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final RelationalExpression RelationalExpression_55_Var
		 = (RelationalExpression)Expr_54_list.get(0);
		Assert.assertNotNull(RelationalExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = RelationalExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final ShiftExpression ShiftExpression_56_Var
		 = (ShiftExpression)Expr_55_list.get(0);
		Assert.assertNotNull(ShiftExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = ShiftExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final AdditiveExpression AdditiveExpression_57_Var
		 = (AdditiveExpression)Expr_56_list.get(0);
		Assert.assertNotNull(AdditiveExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = AdditiveExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final MultiplicativeExpression MultiplicativeExpression_58_Var
		 = (MultiplicativeExpression)Expr_57_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = MultiplicativeExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final CastExpression CastExpression_59_Var
		 = (CastExpression)Expr_58_list.get(0);
		Assert.assertNotNull(CastExpression_59_Var
		);
		//59
		final UnaryExpression UnaryExpression_60_Var
		 = (UnaryExpression)CastExpression_59_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_60_Var
		);
		//60
		final PostfixExpression PostfixExpression_61_Var
		 = (PostfixExpression)UnaryExpression_60_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = PostfixExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final PrimaryExpression PrimaryExpression_62_Var
		 = (PrimaryExpression)Expr_61_list.get(0);
		Assert.assertNotNull(PrimaryExpression_62_Var
		);
		//62
		final Constant2 Constant2_63_Var
		 = (Constant2)PrimaryExpression_62_Var
		.getConst();
		Assert.assertNotNull(Constant2_63_Var
		);
		Assert.assertEquals("\"int $0x80\"", Constant2_63_Var
		.getStr());
		//63
		final AsmLineWithColon AsmLineWithColon_64_Var
		 = (AsmLineWithColon)AsmLine_47_list.get(1);
		Assert.assertNotNull(AsmLineWithColon_64_Var
		);
		//64
		final LogicalOrExpression LogicalOrExpression_65_Var
		 = (LogicalOrExpression)AsmLineWithColon_64_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = LogicalOrExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final LogicalAndExpression LogicalAndExpression_66_Var
		 = (LogicalAndExpression)Expr_65_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = LogicalAndExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final InclusiveOrExpression InclusiveOrExpression_67_Var
		 = (InclusiveOrExpression)Expr_66_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = InclusiveOrExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final ExclusiveOrExpression ExclusiveOrExpression_68_Var
		 = (ExclusiveOrExpression)Expr_67_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = ExclusiveOrExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final AndExpression AndExpression_69_Var
		 = (AndExpression)Expr_68_list.get(0);
		Assert.assertNotNull(AndExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = AndExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final EqualityExpression EqualityExpression_70_Var
		 = (EqualityExpression)Expr_69_list.get(0);
		Assert.assertNotNull(EqualityExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = EqualityExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final RelationalExpression RelationalExpression_71_Var
		 = (RelationalExpression)Expr_70_list.get(0);
		Assert.assertNotNull(RelationalExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = RelationalExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final ShiftExpression ShiftExpression_72_Var
		 = (ShiftExpression)Expr_71_list.get(0);
		Assert.assertNotNull(ShiftExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = ShiftExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final AdditiveExpression AdditiveExpression_73_Var
		 = (AdditiveExpression)Expr_72_list.get(0);
		Assert.assertNotNull(AdditiveExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = AdditiveExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final MultiplicativeExpression MultiplicativeExpression_74_Var
		 = (MultiplicativeExpression)Expr_73_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = MultiplicativeExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final CastExpression CastExpression_75_Var
		 = (CastExpression)Expr_74_list.get(0);
		Assert.assertNotNull(CastExpression_75_Var
		);
		//75
		final UnaryExpression UnaryExpression_76_Var
		 = (UnaryExpression)CastExpression_75_Var
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
		final Constant2 Constant2_79_Var
		 = (Constant2)PrimaryExpression_78_Var
		.getConst();
		Assert.assertNotNull(Constant2_79_Var
		);
		Assert.assertEquals("\"=a\"", Constant2_79_Var
		.getStr());
		final EList<? extends EObject> Suffix_79_list = PostfixExpression_77_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_79_list);
		Assert.assertEquals(1, Suffix_79_list.size());
		//79
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_80_Var
		 = (PostfixExpressionSuffixArgument)Suffix_79_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_80_Var
		);
		//80
		final ArgumentExpressionList ArgumentExpressionList_81_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_80_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_81_Var
		);
		final EList<? extends EObject> Expr_81_list = ArgumentExpressionList_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final AssignmentExpression AssignmentExpression_82_Var
		 = (AssignmentExpression)Expr_81_list.get(0);
		Assert.assertNotNull(AssignmentExpression_82_Var
		);
		//82
		final ConditionalExpression ConditionalExpression_83_Var
		 = (ConditionalExpression)AssignmentExpression_82_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_83_Var
		);
		//83
		final LogicalOrExpression LogicalOrExpression_84_Var
		 = (LogicalOrExpression)ConditionalExpression_83_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = LogicalOrExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final LogicalAndExpression LogicalAndExpression_85_Var
		 = (LogicalAndExpression)Expr_84_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = LogicalAndExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final InclusiveOrExpression InclusiveOrExpression_86_Var
		 = (InclusiveOrExpression)Expr_85_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = InclusiveOrExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final ExclusiveOrExpression ExclusiveOrExpression_87_Var
		 = (ExclusiveOrExpression)Expr_86_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = ExclusiveOrExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final AndExpression AndExpression_88_Var
		 = (AndExpression)Expr_87_list.get(0);
		Assert.assertNotNull(AndExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = AndExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final EqualityExpression EqualityExpression_89_Var
		 = (EqualityExpression)Expr_88_list.get(0);
		Assert.assertNotNull(EqualityExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = EqualityExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final RelationalExpression RelationalExpression_90_Var
		 = (RelationalExpression)Expr_89_list.get(0);
		Assert.assertNotNull(RelationalExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = RelationalExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final ShiftExpression ShiftExpression_91_Var
		 = (ShiftExpression)Expr_90_list.get(0);
		Assert.assertNotNull(ShiftExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = ShiftExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final AdditiveExpression AdditiveExpression_92_Var
		 = (AdditiveExpression)Expr_91_list.get(0);
		Assert.assertNotNull(AdditiveExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = AdditiveExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final MultiplicativeExpression MultiplicativeExpression_93_Var
		 = (MultiplicativeExpression)Expr_92_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = MultiplicativeExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final CastExpression CastExpression_94_Var
		 = (CastExpression)Expr_93_list.get(0);
		Assert.assertNotNull(CastExpression_94_Var
		);
		//94
		final UnaryExpression UnaryExpression_95_Var
		 = (UnaryExpression)CastExpression_94_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_95_Var
		);
		//95
		final PostfixExpression PostfixExpression_96_Var
		 = (PostfixExpression)UnaryExpression_95_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = PostfixExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final PrimaryExpression PrimaryExpression_97_Var
		 = (PrimaryExpression)Expr_96_list.get(0);
		Assert.assertNotNull(PrimaryExpression_97_Var
		);
		Assert.assertEquals("res", PrimaryExpression_97_Var
		.getId());
		//97
		final AsmLineWithComma AsmLineWithComma_98_Var
		 = (AsmLineWithComma)AsmLine_47_list.get(2);
		Assert.assertNotNull(AsmLineWithComma_98_Var
		);
		//98
		final LogicalOrExpression LogicalOrExpression_99_Var
		 = (LogicalOrExpression)AsmLineWithComma_98_Var
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
		Assert.assertEquals("\"+b\"", Constant2_113_Var
		.getStr());
		final EList<? extends EObject> Suffix_113_list = PostfixExpression_111_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_113_list);
		Assert.assertEquals(1, Suffix_113_list.size());
		//113
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_114_Var
		 = (PostfixExpressionSuffixArgument)Suffix_113_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_114_Var
		);
		//114
		final ArgumentExpressionList ArgumentExpressionList_115_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_114_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_115_Var
		);
		final EList<? extends EObject> Expr_115_list = ArgumentExpressionList_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final AssignmentExpression AssignmentExpression_116_Var
		 = (AssignmentExpression)Expr_115_list.get(0);
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
		Assert.assertEquals("arg1", PrimaryExpression_131_Var
		.getId());
		//131
		final AsmLineWithComma AsmLineWithComma_132_Var
		 = (AsmLineWithComma)AsmLine_47_list.get(3);
		Assert.assertNotNull(AsmLineWithComma_132_Var
		);
		//132
		final LogicalOrExpression LogicalOrExpression_133_Var
		 = (LogicalOrExpression)AsmLineWithComma_132_Var
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
		//146
		final Constant2 Constant2_147_Var
		 = (Constant2)PrimaryExpression_146_Var
		.getConst();
		Assert.assertNotNull(Constant2_147_Var
		);
		Assert.assertEquals("\"+c\"", Constant2_147_Var
		.getStr());
		final EList<? extends EObject> Suffix_147_list = PostfixExpression_145_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_147_list);
		Assert.assertEquals(1, Suffix_147_list.size());
		//147
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_148_Var
		 = (PostfixExpressionSuffixArgument)Suffix_147_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_148_Var
		);
		//148
		final ArgumentExpressionList ArgumentExpressionList_149_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_148_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_149_Var
		);
		final EList<? extends EObject> Expr_149_list = ArgumentExpressionList_149_Var
		.getExpr();
		Assert.assertNotNull(Expr_149_list);
		Assert.assertEquals(1, Expr_149_list.size());
		//149
		final AssignmentExpression AssignmentExpression_150_Var
		 = (AssignmentExpression)Expr_149_list.get(0);
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
		Assert.assertEquals("arg2", PrimaryExpression_165_Var
		.getId());
		//165
		final AsmLineWithComma AsmLineWithComma_166_Var
		 = (AsmLineWithComma)AsmLine_47_list.get(4);
		Assert.assertNotNull(AsmLineWithComma_166_Var
		);
		//166
		final LogicalOrExpression LogicalOrExpression_167_Var
		 = (LogicalOrExpression)AsmLineWithComma_166_Var
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
		//180
		final Constant2 Constant2_181_Var
		 = (Constant2)PrimaryExpression_180_Var
		.getConst();
		Assert.assertNotNull(Constant2_181_Var
		);
		Assert.assertEquals("\"+d\"", Constant2_181_Var
		.getStr());
		final EList<? extends EObject> Suffix_181_list = PostfixExpression_179_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_181_list);
		Assert.assertEquals(1, Suffix_181_list.size());
		//181
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_182_Var
		 = (PostfixExpressionSuffixArgument)Suffix_181_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_182_Var
		);
		//182
		final ArgumentExpressionList ArgumentExpressionList_183_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_182_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_183_Var
		);
		final EList<? extends EObject> Expr_183_list = ArgumentExpressionList_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final AssignmentExpression AssignmentExpression_184_Var
		 = (AssignmentExpression)Expr_183_list.get(0);
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
		//197
		final PostfixExpression PostfixExpression_198_Var
		 = (PostfixExpression)UnaryExpression_197_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = PostfixExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final PrimaryExpression PrimaryExpression_199_Var
		 = (PrimaryExpression)Expr_198_list.get(0);
		Assert.assertNotNull(PrimaryExpression_199_Var
		);
		Assert.assertEquals("arg3", PrimaryExpression_199_Var
		.getId());
		//199
		final AsmLineWithColon AsmLineWithColon_200_Var
		 = (AsmLineWithColon)AsmLine_47_list.get(5);
		Assert.assertNotNull(AsmLineWithColon_200_Var
		);
		//200
		final LogicalOrExpression LogicalOrExpression_201_Var
		 = (LogicalOrExpression)AsmLineWithColon_200_Var
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
		final Constant2 Constant2_215_Var
		 = (Constant2)PrimaryExpression_214_Var
		.getConst();
		Assert.assertNotNull(Constant2_215_Var
		);
		Assert.assertEquals("\"a\"", Constant2_215_Var
		.getStr());
		final EList<? extends EObject> Suffix_215_list = PostfixExpression_213_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_215_list);
		Assert.assertEquals(1, Suffix_215_list.size());
		//215
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_216_Var
		 = (PostfixExpressionSuffixArgument)Suffix_215_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_216_Var
		);
		//216
		final ArgumentExpressionList ArgumentExpressionList_217_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_216_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_217_Var
		);
		final EList<? extends EObject> Expr_217_list = ArgumentExpressionList_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final AssignmentExpression AssignmentExpression_218_Var
		 = (AssignmentExpression)Expr_217_list.get(0);
		Assert.assertNotNull(AssignmentExpression_218_Var
		);
		//218
		final ConditionalExpression ConditionalExpression_219_Var
		 = (ConditionalExpression)AssignmentExpression_218_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_219_Var
		);
		//219
		final LogicalOrExpression LogicalOrExpression_220_Var
		 = (LogicalOrExpression)ConditionalExpression_219_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = LogicalOrExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final LogicalAndExpression LogicalAndExpression_221_Var
		 = (LogicalAndExpression)Expr_220_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = LogicalAndExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final InclusiveOrExpression InclusiveOrExpression_222_Var
		 = (InclusiveOrExpression)Expr_221_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = InclusiveOrExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final ExclusiveOrExpression ExclusiveOrExpression_223_Var
		 = (ExclusiveOrExpression)Expr_222_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = ExclusiveOrExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final AndExpression AndExpression_224_Var
		 = (AndExpression)Expr_223_list.get(0);
		Assert.assertNotNull(AndExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = AndExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final EqualityExpression EqualityExpression_225_Var
		 = (EqualityExpression)Expr_224_list.get(0);
		Assert.assertNotNull(EqualityExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = EqualityExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final RelationalExpression RelationalExpression_226_Var
		 = (RelationalExpression)Expr_225_list.get(0);
		Assert.assertNotNull(RelationalExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = RelationalExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final ShiftExpression ShiftExpression_227_Var
		 = (ShiftExpression)Expr_226_list.get(0);
		Assert.assertNotNull(ShiftExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = ShiftExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final AdditiveExpression AdditiveExpression_228_Var
		 = (AdditiveExpression)Expr_227_list.get(0);
		Assert.assertNotNull(AdditiveExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = AdditiveExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final MultiplicativeExpression MultiplicativeExpression_229_Var
		 = (MultiplicativeExpression)Expr_228_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = MultiplicativeExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final CastExpression CastExpression_230_Var
		 = (CastExpression)Expr_229_list.get(0);
		Assert.assertNotNull(CastExpression_230_Var
		);
		//230
		final UnaryExpression UnaryExpression_231_Var
		 = (UnaryExpression)CastExpression_230_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_231_Var
		);
		//231
		final PostfixExpression PostfixExpression_232_Var
		 = (PostfixExpression)UnaryExpression_231_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = PostfixExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final PrimaryExpression PrimaryExpression_233_Var
		 = (PrimaryExpression)Expr_232_list.get(0);
		Assert.assertNotNull(PrimaryExpression_233_Var
		);
		//233
		final Constant2 Constant2_234_Var
		 = (Constant2)PrimaryExpression_233_Var
		.getConst();
		Assert.assertNotNull(Constant2_234_Var
		);
		Assert.assertEquals("128", Constant2_234_Var
		.getDec());
		//234
		final AsmLine AsmLine_235_Var
		 = (AsmLine)AsmLine_47_list.get(6);
		Assert.assertNotNull(AsmLine_235_Var
		);
		//235
		final LogicalOrExpression LogicalOrExpression_236_Var
		 = (LogicalOrExpression)AsmLine_235_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = LogicalOrExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final LogicalAndExpression LogicalAndExpression_237_Var
		 = (LogicalAndExpression)Expr_236_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = LogicalAndExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final InclusiveOrExpression InclusiveOrExpression_238_Var
		 = (InclusiveOrExpression)Expr_237_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = InclusiveOrExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final ExclusiveOrExpression ExclusiveOrExpression_239_Var
		 = (ExclusiveOrExpression)Expr_238_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = ExclusiveOrExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final AndExpression AndExpression_240_Var
		 = (AndExpression)Expr_239_list.get(0);
		Assert.assertNotNull(AndExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = AndExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final EqualityExpression EqualityExpression_241_Var
		 = (EqualityExpression)Expr_240_list.get(0);
		Assert.assertNotNull(EqualityExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = EqualityExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final RelationalExpression RelationalExpression_242_Var
		 = (RelationalExpression)Expr_241_list.get(0);
		Assert.assertNotNull(RelationalExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = RelationalExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final ShiftExpression ShiftExpression_243_Var
		 = (ShiftExpression)Expr_242_list.get(0);
		Assert.assertNotNull(ShiftExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = ShiftExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final AdditiveExpression AdditiveExpression_244_Var
		 = (AdditiveExpression)Expr_243_list.get(0);
		Assert.assertNotNull(AdditiveExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = AdditiveExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final MultiplicativeExpression MultiplicativeExpression_245_Var
		 = (MultiplicativeExpression)Expr_244_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = MultiplicativeExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final CastExpression CastExpression_246_Var
		 = (CastExpression)Expr_245_list.get(0);
		Assert.assertNotNull(CastExpression_246_Var
		);
		//246
		final UnaryExpression UnaryExpression_247_Var
		 = (UnaryExpression)CastExpression_246_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_247_Var
		);
		//247
		final PostfixExpression PostfixExpression_248_Var
		 = (PostfixExpression)UnaryExpression_247_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = PostfixExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final PrimaryExpression PrimaryExpression_249_Var
		 = (PrimaryExpression)Expr_248_list.get(0);
		Assert.assertNotNull(PrimaryExpression_249_Var
		);
		//249
		final Constant2 Constant2_250_Var
		 = (Constant2)PrimaryExpression_249_Var
		.getConst();
		Assert.assertNotNull(Constant2_250_Var
		);
		Assert.assertEquals("\"memory\"", Constant2_250_Var
		.getStr());
		//250
		final AsmLineWithComma AsmLineWithComma_251_Var
		 = (AsmLineWithComma)AsmLine_47_list.get(7);
		Assert.assertNotNull(AsmLineWithComma_251_Var
		);
		//251
		final LogicalOrExpression LogicalOrExpression_252_Var
		 = (LogicalOrExpression)AsmLineWithComma_251_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_252_Var
		);
		final EList<? extends EObject> Expr_252_list = LogicalOrExpression_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(1, Expr_252_list.size());
		//252
		final LogicalAndExpression LogicalAndExpression_253_Var
		 = (LogicalAndExpression)Expr_252_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = LogicalAndExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final InclusiveOrExpression InclusiveOrExpression_254_Var
		 = (InclusiveOrExpression)Expr_253_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = InclusiveOrExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final ExclusiveOrExpression ExclusiveOrExpression_255_Var
		 = (ExclusiveOrExpression)Expr_254_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_255_Var
		);
		final EList<? extends EObject> Expr_255_list = ExclusiveOrExpression_255_Var
		.getExpr();
		Assert.assertNotNull(Expr_255_list);
		Assert.assertEquals(1, Expr_255_list.size());
		//255
		final AndExpression AndExpression_256_Var
		 = (AndExpression)Expr_255_list.get(0);
		Assert.assertNotNull(AndExpression_256_Var
		);
		final EList<? extends EObject> Expr_256_list = AndExpression_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(1, Expr_256_list.size());
		//256
		final EqualityExpression EqualityExpression_257_Var
		 = (EqualityExpression)Expr_256_list.get(0);
		Assert.assertNotNull(EqualityExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = EqualityExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final RelationalExpression RelationalExpression_258_Var
		 = (RelationalExpression)Expr_257_list.get(0);
		Assert.assertNotNull(RelationalExpression_258_Var
		);
		final EList<? extends EObject> Expr_258_list = RelationalExpression_258_Var
		.getExpr();
		Assert.assertNotNull(Expr_258_list);
		Assert.assertEquals(1, Expr_258_list.size());
		//258
		final ShiftExpression ShiftExpression_259_Var
		 = (ShiftExpression)Expr_258_list.get(0);
		Assert.assertNotNull(ShiftExpression_259_Var
		);
		final EList<? extends EObject> Expr_259_list = ShiftExpression_259_Var
		.getExpr();
		Assert.assertNotNull(Expr_259_list);
		Assert.assertEquals(1, Expr_259_list.size());
		//259
		final AdditiveExpression AdditiveExpression_260_Var
		 = (AdditiveExpression)Expr_259_list.get(0);
		Assert.assertNotNull(AdditiveExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = AdditiveExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final MultiplicativeExpression MultiplicativeExpression_261_Var
		 = (MultiplicativeExpression)Expr_260_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = MultiplicativeExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final CastExpression CastExpression_262_Var
		 = (CastExpression)Expr_261_list.get(0);
		Assert.assertNotNull(CastExpression_262_Var
		);
		//262
		final UnaryExpression UnaryExpression_263_Var
		 = (UnaryExpression)CastExpression_262_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_263_Var
		);
		//263
		final PostfixExpression PostfixExpression_264_Var
		 = (PostfixExpression)UnaryExpression_263_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_264_Var
		);
		final EList<? extends EObject> Expr_264_list = PostfixExpression_264_Var
		.getExpr();
		Assert.assertNotNull(Expr_264_list);
		Assert.assertEquals(1, Expr_264_list.size());
		//264
		final PrimaryExpression PrimaryExpression_265_Var
		 = (PrimaryExpression)Expr_264_list.get(0);
		Assert.assertNotNull(PrimaryExpression_265_Var
		);
		//265
		final Constant2 Constant2_266_Var
		 = (Constant2)PrimaryExpression_265_Var
		.getConst();
		Assert.assertNotNull(Constant2_266_Var
		);
		Assert.assertEquals("\"cc\"", Constant2_266_Var
		.getStr());
		Assert.assertEquals(";", AsmStatement_47_Var
		.getSemi());
		//266
		final Statement Statement_267_Var
		 = (Statement)Statement_45_list.get(1);
		Assert.assertNotNull(Statement_267_Var
		);
		//267
		final SelectionStatement SelectionStatement_268_Var
		 = (SelectionStatement)Statement_267_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_268_Var
		);
		Assert.assertEquals("if", SelectionStatement_268_Var
		.getIf());
		//268
		final Expression Expression_269_Var
		 = (Expression)SelectionStatement_268_Var
		.getExpr();
		Assert.assertNotNull(Expression_269_Var
		);
		final EList<? extends EObject> ExprExpr_269_list = Expression_269_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_269_list);
		Assert.assertEquals(1, ExprExpr_269_list.size());
		//269
		final AssignmentExpression AssignmentExpression_270_Var
		 = (AssignmentExpression)ExprExpr_269_list.get(0);
		Assert.assertNotNull(AssignmentExpression_270_Var
		);
		//270
		final ConditionalExpression ConditionalExpression_271_Var
		 = (ConditionalExpression)AssignmentExpression_270_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_271_Var
		);
		//271
		final LogicalOrExpression LogicalOrExpression_272_Var
		 = (LogicalOrExpression)ConditionalExpression_271_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_272_Var
		);
		final EList<? extends EObject> Expr_272_list = LogicalOrExpression_272_Var
		.getExpr();
		Assert.assertNotNull(Expr_272_list);
		Assert.assertEquals(1, Expr_272_list.size());
		//272
		final LogicalAndExpression LogicalAndExpression_273_Var
		 = (LogicalAndExpression)Expr_272_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_273_Var
		);
		final EList<? extends EObject> Expr_273_list = LogicalAndExpression_273_Var
		.getExpr();
		Assert.assertNotNull(Expr_273_list);
		Assert.assertEquals(2, Expr_273_list.size());
		//273
		final InclusiveOrExpression InclusiveOrExpression_274_Var
		 = (InclusiveOrExpression)Expr_273_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_274_Var
		);
		final EList<? extends EObject> Expr_274_list = InclusiveOrExpression_274_Var
		.getExpr();
		Assert.assertNotNull(Expr_274_list);
		Assert.assertEquals(1, Expr_274_list.size());
		//274
		final ExclusiveOrExpression ExclusiveOrExpression_275_Var
		 = (ExclusiveOrExpression)Expr_274_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_275_Var
		);
		final EList<? extends EObject> Expr_275_list = ExclusiveOrExpression_275_Var
		.getExpr();
		Assert.assertNotNull(Expr_275_list);
		Assert.assertEquals(1, Expr_275_list.size());
		//275
		final AndExpression AndExpression_276_Var
		 = (AndExpression)Expr_275_list.get(0);
		Assert.assertNotNull(AndExpression_276_Var
		);
		final EList<? extends EObject> Expr_276_list = AndExpression_276_Var
		.getExpr();
		Assert.assertNotNull(Expr_276_list);
		Assert.assertEquals(1, Expr_276_list.size());
		//276
		final EqualityExpression EqualityExpression_277_Var
		 = (EqualityExpression)Expr_276_list.get(0);
		Assert.assertNotNull(EqualityExpression_277_Var
		);
		final EList<? extends EObject> Expr_277_list = EqualityExpression_277_Var
		.getExpr();
		Assert.assertNotNull(Expr_277_list);
		Assert.assertEquals(1, Expr_277_list.size());
		//277
		final RelationalExpression RelationalExpression_278_Var
		 = (RelationalExpression)Expr_277_list.get(0);
		Assert.assertNotNull(RelationalExpression_278_Var
		);
		Assert.assertEquals("[<=]", RelationalExpression_278_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_278_list = RelationalExpression_278_Var
		.getExpr();
		Assert.assertNotNull(Expr_278_list);
		Assert.assertEquals(2, Expr_278_list.size());
		//278
		final ShiftExpression ShiftExpression_279_Var
		 = (ShiftExpression)Expr_278_list.get(0);
		Assert.assertNotNull(ShiftExpression_279_Var
		);
		final EList<? extends EObject> Expr_279_list = ShiftExpression_279_Var
		.getExpr();
		Assert.assertNotNull(Expr_279_list);
		Assert.assertEquals(1, Expr_279_list.size());
		//279
		final AdditiveExpression AdditiveExpression_280_Var
		 = (AdditiveExpression)Expr_279_list.get(0);
		Assert.assertNotNull(AdditiveExpression_280_Var
		);
		final EList<? extends EObject> Expr_280_list = AdditiveExpression_280_Var
		.getExpr();
		Assert.assertNotNull(Expr_280_list);
		Assert.assertEquals(1, Expr_280_list.size());
		//280
		final MultiplicativeExpression MultiplicativeExpression_281_Var
		 = (MultiplicativeExpression)Expr_280_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_281_Var
		);
		final EList<? extends EObject> Expr_281_list = MultiplicativeExpression_281_Var
		.getExpr();
		Assert.assertNotNull(Expr_281_list);
		Assert.assertEquals(1, Expr_281_list.size());
		//281
		final CastExpression CastExpression_282_Var
		 = (CastExpression)Expr_281_list.get(0);
		Assert.assertNotNull(CastExpression_282_Var
		);
		//282
		final UnaryExpression UnaryExpression_283_Var
		 = (UnaryExpression)CastExpression_282_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_283_Var
		);
		//283
		final CastExpression CastExpression_284_Var
		 = (CastExpression)UnaryExpression_283_Var
		.getExpr();
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
		//287
		final Constant2 Constant2_288_Var
		 = (Constant2)PrimaryExpression_287_Var
		.getConst();
		Assert.assertNotNull(Constant2_288_Var
		);
		Assert.assertEquals("125", Constant2_288_Var
		.getDec());
		//288
		final UnaryOperator UnaryOperator_289_Var
		 = (UnaryOperator)UnaryExpression_283_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_289_Var
		);
		Assert.assertEquals("-", UnaryOperator_289_Var
		.getOp());
		//289
		final ShiftExpression ShiftExpression_290_Var
		 = (ShiftExpression)Expr_278_list.get(1);
		Assert.assertNotNull(ShiftExpression_290_Var
		);
		final EList<? extends EObject> Expr_290_list = ShiftExpression_290_Var
		.getExpr();
		Assert.assertNotNull(Expr_290_list);
		Assert.assertEquals(1, Expr_290_list.size());
		//290
		final AdditiveExpression AdditiveExpression_291_Var
		 = (AdditiveExpression)Expr_290_list.get(0);
		Assert.assertNotNull(AdditiveExpression_291_Var
		);
		final EList<? extends EObject> Expr_291_list = AdditiveExpression_291_Var
		.getExpr();
		Assert.assertNotNull(Expr_291_list);
		Assert.assertEquals(1, Expr_291_list.size());
		//291
		final MultiplicativeExpression MultiplicativeExpression_292_Var
		 = (MultiplicativeExpression)Expr_291_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_292_Var
		);
		final EList<? extends EObject> Expr_292_list = MultiplicativeExpression_292_Var
		.getExpr();
		Assert.assertNotNull(Expr_292_list);
		Assert.assertEquals(1, Expr_292_list.size());
		//292
		final CastExpression CastExpression_293_Var
		 = (CastExpression)Expr_292_list.get(0);
		Assert.assertNotNull(CastExpression_293_Var
		);
		//293
		final UnaryExpression UnaryExpression_294_Var
		 = (UnaryExpression)CastExpression_293_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_294_Var
		);
		//294
		final PostfixExpression PostfixExpression_295_Var
		 = (PostfixExpression)UnaryExpression_294_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_295_Var
		);
		final EList<? extends EObject> Expr_295_list = PostfixExpression_295_Var
		.getExpr();
		Assert.assertNotNull(Expr_295_list);
		Assert.assertEquals(1, Expr_295_list.size());
		//295
		final PrimaryExpression PrimaryExpression_296_Var
		 = (PrimaryExpression)Expr_295_list.get(0);
		Assert.assertNotNull(PrimaryExpression_296_Var
		);
		Assert.assertEquals("res", PrimaryExpression_296_Var
		.getId());
		//296
		final InclusiveOrExpression InclusiveOrExpression_297_Var
		 = (InclusiveOrExpression)Expr_273_list.get(1);
		Assert.assertNotNull(InclusiveOrExpression_297_Var
		);
		final EList<? extends EObject> Expr_297_list = InclusiveOrExpression_297_Var
		.getExpr();
		Assert.assertNotNull(Expr_297_list);
		Assert.assertEquals(1, Expr_297_list.size());
		//297
		final ExclusiveOrExpression ExclusiveOrExpression_298_Var
		 = (ExclusiveOrExpression)Expr_297_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_298_Var
		);
		final EList<? extends EObject> Expr_298_list = ExclusiveOrExpression_298_Var
		.getExpr();
		Assert.assertNotNull(Expr_298_list);
		Assert.assertEquals(1, Expr_298_list.size());
		//298
		final AndExpression AndExpression_299_Var
		 = (AndExpression)Expr_298_list.get(0);
		Assert.assertNotNull(AndExpression_299_Var
		);
		final EList<? extends EObject> Expr_299_list = AndExpression_299_Var
		.getExpr();
		Assert.assertNotNull(Expr_299_list);
		Assert.assertEquals(1, Expr_299_list.size());
		//299
		final EqualityExpression EqualityExpression_300_Var
		 = (EqualityExpression)Expr_299_list.get(0);
		Assert.assertNotNull(EqualityExpression_300_Var
		);
		final EList<? extends EObject> Expr_300_list = EqualityExpression_300_Var
		.getExpr();
		Assert.assertNotNull(Expr_300_list);
		Assert.assertEquals(1, Expr_300_list.size());
		//300
		final RelationalExpression RelationalExpression_301_Var
		 = (RelationalExpression)Expr_300_list.get(0);
		Assert.assertNotNull(RelationalExpression_301_Var
		);
		Assert.assertEquals("[<]", RelationalExpression_301_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_301_list = RelationalExpression_301_Var
		.getExpr();
		Assert.assertNotNull(Expr_301_list);
		Assert.assertEquals(2, Expr_301_list.size());
		//301
		final ShiftExpression ShiftExpression_302_Var
		 = (ShiftExpression)Expr_301_list.get(0);
		Assert.assertNotNull(ShiftExpression_302_Var
		);
		final EList<? extends EObject> Expr_302_list = ShiftExpression_302_Var
		.getExpr();
		Assert.assertNotNull(Expr_302_list);
		Assert.assertEquals(1, Expr_302_list.size());
		//302
		final AdditiveExpression AdditiveExpression_303_Var
		 = (AdditiveExpression)Expr_302_list.get(0);
		Assert.assertNotNull(AdditiveExpression_303_Var
		);
		final EList<? extends EObject> Expr_303_list = AdditiveExpression_303_Var
		.getExpr();
		Assert.assertNotNull(Expr_303_list);
		Assert.assertEquals(1, Expr_303_list.size());
		//303
		final MultiplicativeExpression MultiplicativeExpression_304_Var
		 = (MultiplicativeExpression)Expr_303_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_304_Var
		);
		final EList<? extends EObject> Expr_304_list = MultiplicativeExpression_304_Var
		.getExpr();
		Assert.assertNotNull(Expr_304_list);
		Assert.assertEquals(1, Expr_304_list.size());
		//304
		final CastExpression CastExpression_305_Var
		 = (CastExpression)Expr_304_list.get(0);
		Assert.assertNotNull(CastExpression_305_Var
		);
		//305
		final UnaryExpression UnaryExpression_306_Var
		 = (UnaryExpression)CastExpression_305_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_306_Var
		);
		//306
		final PostfixExpression PostfixExpression_307_Var
		 = (PostfixExpression)UnaryExpression_306_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_307_Var
		);
		final EList<? extends EObject> Expr_307_list = PostfixExpression_307_Var
		.getExpr();
		Assert.assertNotNull(Expr_307_list);
		Assert.assertEquals(1, Expr_307_list.size());
		//307
		final PrimaryExpression PrimaryExpression_308_Var
		 = (PrimaryExpression)Expr_307_list.get(0);
		Assert.assertNotNull(PrimaryExpression_308_Var
		);
		Assert.assertEquals("res", PrimaryExpression_308_Var
		.getId());
		//308
		final ShiftExpression ShiftExpression_309_Var
		 = (ShiftExpression)Expr_301_list.get(1);
		Assert.assertNotNull(ShiftExpression_309_Var
		);
		final EList<? extends EObject> Expr_309_list = ShiftExpression_309_Var
		.getExpr();
		Assert.assertNotNull(Expr_309_list);
		Assert.assertEquals(1, Expr_309_list.size());
		//309
		final AdditiveExpression AdditiveExpression_310_Var
		 = (AdditiveExpression)Expr_309_list.get(0);
		Assert.assertNotNull(AdditiveExpression_310_Var
		);
		final EList<? extends EObject> Expr_310_list = AdditiveExpression_310_Var
		.getExpr();
		Assert.assertNotNull(Expr_310_list);
		Assert.assertEquals(1, Expr_310_list.size());
		//310
		final MultiplicativeExpression MultiplicativeExpression_311_Var
		 = (MultiplicativeExpression)Expr_310_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = MultiplicativeExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final CastExpression CastExpression_312_Var
		 = (CastExpression)Expr_311_list.get(0);
		Assert.assertNotNull(CastExpression_312_Var
		);
		//312
		final UnaryExpression UnaryExpression_313_Var
		 = (UnaryExpression)CastExpression_312_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_313_Var
		);
		//313
		final PostfixExpression PostfixExpression_314_Var
		 = (PostfixExpression)UnaryExpression_313_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = PostfixExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final PrimaryExpression PrimaryExpression_315_Var
		 = (PrimaryExpression)Expr_314_list.get(0);
		Assert.assertNotNull(PrimaryExpression_315_Var
		);
		//315
		final Constant2 Constant2_316_Var
		 = (Constant2)PrimaryExpression_315_Var
		.getConst();
		Assert.assertNotNull(Constant2_316_Var
		);
		Assert.assertEquals("0", Constant2_316_Var
		.getDec());
		//316
		final Statement Statement_317_Var
		 = (Statement)SelectionStatement_268_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_317_Var
		);
		//317
		final CompoundStatement CompoundStatement_318_Var
		 = (CompoundStatement)Statement_317_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_318_Var
		);
		//318
		final BodyStatement BodyStatement_319_Var
		 = (BodyStatement)CompoundStatement_318_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_319_Var
		);
		final EList<? extends EObject> BlockList_319_list = BodyStatement_319_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_319_list);
		Assert.assertEquals(1, BlockList_319_list.size());
		//319
		final BlockList BlockList_320_Var
		 = (BlockList)BlockList_319_list.get(0);
		Assert.assertNotNull(BlockList_320_Var
		);
		final EList<? extends EObject> Statement_320_list = BlockList_320_Var
		.getStatement();
		Assert.assertNotNull(Statement_320_list);
		Assert.assertEquals(2, Statement_320_list.size());
		//320
		final Statement Statement_321_Var
		 = (Statement)Statement_320_list.get(0);
		Assert.assertNotNull(Statement_321_Var
		);
		//321
		final ExpressionStatement ExpressionStatement_322_Var
		 = (ExpressionStatement)Statement_321_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_322_Var
		);
		//322
		final Expression Expression_323_Var
		 = (Expression)ExpressionStatement_322_Var
		.getExpression();
		Assert.assertNotNull(Expression_323_Var
		);
		final EList<? extends EObject> ExprExpr_323_list = Expression_323_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_323_list);
		Assert.assertEquals(1, ExprExpr_323_list.size());
		//323
		final AssignmentExpression AssignmentExpression_324_Var
		 = (AssignmentExpression)ExprExpr_323_list.get(0);
		Assert.assertNotNull(AssignmentExpression_324_Var
		);
		//324
		final UnaryExpression UnaryExpression_325_Var
		 = (UnaryExpression)AssignmentExpression_324_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_325_Var
		);
		//325
		final PostfixExpression PostfixExpression_326_Var
		 = (PostfixExpression)UnaryExpression_325_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_326_Var
		);
		final EList<? extends EObject> Expr_326_list = PostfixExpression_326_Var
		.getExpr();
		Assert.assertNotNull(Expr_326_list);
		Assert.assertEquals(1, Expr_326_list.size());
		//326
		final PrimaryExpression PrimaryExpression_327_Var
		 = (PrimaryExpression)Expr_326_list.get(0);
		Assert.assertNotNull(PrimaryExpression_327_Var
		);
		Assert.assertEquals("errno", PrimaryExpression_327_Var
		.getId());
		//327
		final AssignmentOperator AssignmentOperator_328_Var
		 = (AssignmentOperator)AssignmentExpression_324_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_328_Var
		);
		Assert.assertEquals("=", AssignmentOperator_328_Var
		.getOp());
		//328
		final AssignmentExpression AssignmentExpression_329_Var
		 = (AssignmentExpression)AssignmentExpression_324_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_329_Var
		);
		//329
		final ConditionalExpression ConditionalExpression_330_Var
		 = (ConditionalExpression)AssignmentExpression_329_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_330_Var
		);
		//330
		final LogicalOrExpression LogicalOrExpression_331_Var
		 = (LogicalOrExpression)ConditionalExpression_330_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = LogicalOrExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final LogicalAndExpression LogicalAndExpression_332_Var
		 = (LogicalAndExpression)Expr_331_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_332_Var
		);
		final EList<? extends EObject> Expr_332_list = LogicalAndExpression_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final InclusiveOrExpression InclusiveOrExpression_333_Var
		 = (InclusiveOrExpression)Expr_332_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = InclusiveOrExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final ExclusiveOrExpression ExclusiveOrExpression_334_Var
		 = (ExclusiveOrExpression)Expr_333_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = ExclusiveOrExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final AndExpression AndExpression_335_Var
		 = (AndExpression)Expr_334_list.get(0);
		Assert.assertNotNull(AndExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = AndExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final EqualityExpression EqualityExpression_336_Var
		 = (EqualityExpression)Expr_335_list.get(0);
		Assert.assertNotNull(EqualityExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = EqualityExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final RelationalExpression RelationalExpression_337_Var
		 = (RelationalExpression)Expr_336_list.get(0);
		Assert.assertNotNull(RelationalExpression_337_Var
		);
		final EList<? extends EObject> Expr_337_list = RelationalExpression_337_Var
		.getExpr();
		Assert.assertNotNull(Expr_337_list);
		Assert.assertEquals(1, Expr_337_list.size());
		//337
		final ShiftExpression ShiftExpression_338_Var
		 = (ShiftExpression)Expr_337_list.get(0);
		Assert.assertNotNull(ShiftExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = ShiftExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final AdditiveExpression AdditiveExpression_339_Var
		 = (AdditiveExpression)Expr_338_list.get(0);
		Assert.assertNotNull(AdditiveExpression_339_Var
		);
		final EList<? extends EObject> Expr_339_list = AdditiveExpression_339_Var
		.getExpr();
		Assert.assertNotNull(Expr_339_list);
		Assert.assertEquals(1, Expr_339_list.size());
		//339
		final MultiplicativeExpression MultiplicativeExpression_340_Var
		 = (MultiplicativeExpression)Expr_339_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_340_Var
		);
		final EList<? extends EObject> Expr_340_list = MultiplicativeExpression_340_Var
		.getExpr();
		Assert.assertNotNull(Expr_340_list);
		Assert.assertEquals(1, Expr_340_list.size());
		//340
		final CastExpression CastExpression_341_Var
		 = (CastExpression)Expr_340_list.get(0);
		Assert.assertNotNull(CastExpression_341_Var
		);
		//341
		final UnaryExpression UnaryExpression_342_Var
		 = (UnaryExpression)CastExpression_341_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_342_Var
		);
		//342
		final UnaryOperator UnaryOperator_343_Var
		 = (UnaryOperator)UnaryExpression_342_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_343_Var
		);
		Assert.assertEquals("-", UnaryOperator_343_Var
		.getOp());
		//343
		final CastExpression CastExpression_344_Var
		 = (CastExpression)UnaryExpression_342_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_344_Var
		);
		//344
		final UnaryExpression UnaryExpression_345_Var
		 = (UnaryExpression)CastExpression_344_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_345_Var
		);
		//345
		final PostfixExpression PostfixExpression_346_Var
		 = (PostfixExpression)UnaryExpression_345_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_346_Var
		);
		final EList<? extends EObject> Expr_346_list = PostfixExpression_346_Var
		.getExpr();
		Assert.assertNotNull(Expr_346_list);
		Assert.assertEquals(1, Expr_346_list.size());
		//346
		final PrimaryExpression PrimaryExpression_347_Var
		 = (PrimaryExpression)Expr_346_list.get(0);
		Assert.assertNotNull(PrimaryExpression_347_Var
		);
		Assert.assertEquals("res", PrimaryExpression_347_Var
		.getId());
		//347
		final Statement Statement_348_Var
		 = (Statement)Statement_320_list.get(1);
		Assert.assertNotNull(Statement_348_Var
		);
		//348
		final ExpressionStatement ExpressionStatement_349_Var
		 = (ExpressionStatement)Statement_348_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_349_Var
		);
		//349
		final Expression Expression_350_Var
		 = (Expression)ExpressionStatement_349_Var
		.getExpression();
		Assert.assertNotNull(Expression_350_Var
		);
		final EList<? extends EObject> ExprExpr_350_list = Expression_350_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_350_list);
		Assert.assertEquals(1, ExprExpr_350_list.size());
		//350
		final AssignmentExpression AssignmentExpression_351_Var
		 = (AssignmentExpression)ExprExpr_350_list.get(0);
		Assert.assertNotNull(AssignmentExpression_351_Var
		);
		//351
		final UnaryExpression UnaryExpression_352_Var
		 = (UnaryExpression)AssignmentExpression_351_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_352_Var
		);
		//352
		final PostfixExpression PostfixExpression_353_Var
		 = (PostfixExpression)UnaryExpression_352_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_353_Var
		);
		final EList<? extends EObject> Expr_353_list = PostfixExpression_353_Var
		.getExpr();
		Assert.assertNotNull(Expr_353_list);
		Assert.assertEquals(1, Expr_353_list.size());
		//353
		final PrimaryExpression PrimaryExpression_354_Var
		 = (PrimaryExpression)Expr_353_list.get(0);
		Assert.assertNotNull(PrimaryExpression_354_Var
		);
		Assert.assertEquals("res", PrimaryExpression_354_Var
		.getId());
		//354
		final AssignmentOperator AssignmentOperator_355_Var
		 = (AssignmentOperator)AssignmentExpression_351_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_355_Var
		);
		Assert.assertEquals("=", AssignmentOperator_355_Var
		.getOp());
		//355
		final AssignmentExpression AssignmentExpression_356_Var
		 = (AssignmentExpression)AssignmentExpression_351_Var
		.getAssignmentExpr();
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
		final UnaryOperator UnaryOperator_370_Var
		 = (UnaryOperator)UnaryExpression_369_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_370_Var
		);
		Assert.assertEquals("-", UnaryOperator_370_Var
		.getOp());
		//370
		final CastExpression CastExpression_371_Var
		 = (CastExpression)UnaryExpression_369_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_371_Var
		);
		//371
		final UnaryExpression UnaryExpression_372_Var
		 = (UnaryExpression)CastExpression_371_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_372_Var
		);
		//372
		final PostfixExpression PostfixExpression_373_Var
		 = (PostfixExpression)UnaryExpression_372_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_373_Var
		);
		final EList<? extends EObject> Expr_373_list = PostfixExpression_373_Var
		.getExpr();
		Assert.assertNotNull(Expr_373_list);
		Assert.assertEquals(1, Expr_373_list.size());
		//373
		final PrimaryExpression PrimaryExpression_374_Var
		 = (PrimaryExpression)Expr_373_list.get(0);
		Assert.assertNotNull(PrimaryExpression_374_Var
		);
		//374
		final Constant2 Constant2_375_Var
		 = (Constant2)PrimaryExpression_374_Var
		.getConst();
		Assert.assertNotNull(Constant2_375_Var
		);
		Assert.assertEquals("1", Constant2_375_Var
		.getDec());
		//375
		final Statement Statement_376_Var
		 = (Statement)Statement_45_list.get(2);
		Assert.assertNotNull(Statement_376_Var
		);
		//376
		final JumpStatement JumpStatement_377_Var
		 = (JumpStatement)Statement_376_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_377_Var
		);
		//377
		final Expression Expression_378_Var
		 = (Expression)JumpStatement_377_Var
		.getExpr();
		Assert.assertNotNull(Expression_378_Var
		);
		final EList<? extends EObject> ExprExpr_378_list = Expression_378_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_378_list);
		Assert.assertEquals(1, ExprExpr_378_list.size());
		//378
		final AssignmentExpression AssignmentExpression_379_Var
		 = (AssignmentExpression)ExprExpr_378_list.get(0);
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
		Assert.assertEquals("res", PrimaryExpression_394_Var
		.getId());
		Assert.assertEquals("return", JumpStatement_377_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_377_Var
		.getSemi());
	}
	
	@Test
	(timeout=1000
	)
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


