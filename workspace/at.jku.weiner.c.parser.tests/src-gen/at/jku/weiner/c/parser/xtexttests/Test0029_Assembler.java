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
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
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
		//47
		final AsmLineWithoutColon AsmLineWithoutColon_48_Var
		 = (AsmLineWithoutColon)AsmStatement_47_Var
		.getAsmLine1();
		Assert.assertNotNull(AsmLineWithoutColon_48_Var
		);
		//48
		final LogicalOrExpression LogicalOrExpression_49_Var
		 = (LogicalOrExpression)AsmLineWithoutColon_48_Var
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
		final EList<? extends EObject> AsmLines_63_list = AsmStatement_47_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_63_list);
		Assert.assertEquals(3, AsmLines_63_list.size());
		//63
		final AsmLineWithColon AsmLineWithColon_64_Var
		 = (AsmLineWithColon)AsmLines_63_list.get(0);
		Assert.assertNotNull(AsmLineWithColon_64_Var
		);
		//64
		final AsmLineWithoutColon AsmLineWithoutColon_65_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_64_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_65_Var
		);
		//65
		final LogicalOrExpression LogicalOrExpression_66_Var
		 = (LogicalOrExpression)AsmLineWithoutColon_65_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = LogicalOrExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final LogicalAndExpression LogicalAndExpression_67_Var
		 = (LogicalAndExpression)Expr_66_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = LogicalAndExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final InclusiveOrExpression InclusiveOrExpression_68_Var
		 = (InclusiveOrExpression)Expr_67_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = InclusiveOrExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final ExclusiveOrExpression ExclusiveOrExpression_69_Var
		 = (ExclusiveOrExpression)Expr_68_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = ExclusiveOrExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final AndExpression AndExpression_70_Var
		 = (AndExpression)Expr_69_list.get(0);
		Assert.assertNotNull(AndExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = AndExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final EqualityExpression EqualityExpression_71_Var
		 = (EqualityExpression)Expr_70_list.get(0);
		Assert.assertNotNull(EqualityExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = EqualityExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final RelationalExpression RelationalExpression_72_Var
		 = (RelationalExpression)Expr_71_list.get(0);
		Assert.assertNotNull(RelationalExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = RelationalExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final ShiftExpression ShiftExpression_73_Var
		 = (ShiftExpression)Expr_72_list.get(0);
		Assert.assertNotNull(ShiftExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = ShiftExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final AdditiveExpression AdditiveExpression_74_Var
		 = (AdditiveExpression)Expr_73_list.get(0);
		Assert.assertNotNull(AdditiveExpression_74_Var
		);
		final EList<? extends EObject> Expr_74_list = AdditiveExpression_74_Var
		.getExpr();
		Assert.assertNotNull(Expr_74_list);
		Assert.assertEquals(1, Expr_74_list.size());
		//74
		final MultiplicativeExpression MultiplicativeExpression_75_Var
		 = (MultiplicativeExpression)Expr_74_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_75_Var
		);
		final EList<? extends EObject> Expr_75_list = MultiplicativeExpression_75_Var
		.getExpr();
		Assert.assertNotNull(Expr_75_list);
		Assert.assertEquals(1, Expr_75_list.size());
		//75
		final CastExpression CastExpression_76_Var
		 = (CastExpression)Expr_75_list.get(0);
		Assert.assertNotNull(CastExpression_76_Var
		);
		//76
		final UnaryExpression UnaryExpression_77_Var
		 = (UnaryExpression)CastExpression_76_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_77_Var
		);
		//77
		final PostfixExpression PostfixExpression_78_Var
		 = (PostfixExpression)UnaryExpression_77_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = PostfixExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final PrimaryExpression PrimaryExpression_79_Var
		 = (PrimaryExpression)Expr_78_list.get(0);
		Assert.assertNotNull(PrimaryExpression_79_Var
		);
		//79
		final Constant2 Constant2_80_Var
		 = (Constant2)PrimaryExpression_79_Var
		.getConst();
		Assert.assertNotNull(Constant2_80_Var
		);
		Assert.assertEquals("\"=a\"", Constant2_80_Var
		.getStr());
		final EList<? extends EObject> Suffix_80_list = PostfixExpression_78_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_80_list);
		Assert.assertEquals(1, Suffix_80_list.size());
		//80
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_81_Var
		 = (PostfixExpressionSuffixArgument)Suffix_80_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_81_Var
		);
		//81
		final ArgumentExpressionList ArgumentExpressionList_82_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_81_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_82_Var
		);
		final EList<? extends EObject> Expr_82_list = ArgumentExpressionList_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final AssignmentExpression AssignmentExpression_83_Var
		 = (AssignmentExpression)Expr_82_list.get(0);
		Assert.assertNotNull(AssignmentExpression_83_Var
		);
		//83
		final ConditionalExpression ConditionalExpression_84_Var
		 = (ConditionalExpression)AssignmentExpression_83_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_84_Var
		);
		//84
		final LogicalOrExpression LogicalOrExpression_85_Var
		 = (LogicalOrExpression)ConditionalExpression_84_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = LogicalOrExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final LogicalAndExpression LogicalAndExpression_86_Var
		 = (LogicalAndExpression)Expr_85_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = LogicalAndExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final InclusiveOrExpression InclusiveOrExpression_87_Var
		 = (InclusiveOrExpression)Expr_86_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = InclusiveOrExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final ExclusiveOrExpression ExclusiveOrExpression_88_Var
		 = (ExclusiveOrExpression)Expr_87_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = ExclusiveOrExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final AndExpression AndExpression_89_Var
		 = (AndExpression)Expr_88_list.get(0);
		Assert.assertNotNull(AndExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = AndExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final EqualityExpression EqualityExpression_90_Var
		 = (EqualityExpression)Expr_89_list.get(0);
		Assert.assertNotNull(EqualityExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = EqualityExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final RelationalExpression RelationalExpression_91_Var
		 = (RelationalExpression)Expr_90_list.get(0);
		Assert.assertNotNull(RelationalExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = RelationalExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final ShiftExpression ShiftExpression_92_Var
		 = (ShiftExpression)Expr_91_list.get(0);
		Assert.assertNotNull(ShiftExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = ShiftExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final AdditiveExpression AdditiveExpression_93_Var
		 = (AdditiveExpression)Expr_92_list.get(0);
		Assert.assertNotNull(AdditiveExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = AdditiveExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final MultiplicativeExpression MultiplicativeExpression_94_Var
		 = (MultiplicativeExpression)Expr_93_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = MultiplicativeExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final CastExpression CastExpression_95_Var
		 = (CastExpression)Expr_94_list.get(0);
		Assert.assertNotNull(CastExpression_95_Var
		);
		//95
		final UnaryExpression UnaryExpression_96_Var
		 = (UnaryExpression)CastExpression_95_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_96_Var
		);
		//96
		final PostfixExpression PostfixExpression_97_Var
		 = (PostfixExpression)UnaryExpression_96_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = PostfixExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final PrimaryExpression PrimaryExpression_98_Var
		 = (PrimaryExpression)Expr_97_list.get(0);
		Assert.assertNotNull(PrimaryExpression_98_Var
		);
		Assert.assertEquals("res", PrimaryExpression_98_Var
		.getId());
		final EList<? extends EObject> AsmLines_98_list = AsmLineWithoutColon_65_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_98_list);
		Assert.assertEquals(3, AsmLines_98_list.size());
		//98
		final AsmLine AsmLine_99_Var
		 = (AsmLine)AsmLines_98_list.get(0);
		Assert.assertNotNull(AsmLine_99_Var
		);
		Assert.assertTrue(AsmLine_99_Var
		.isComma());
		//99
		final LogicalOrExpression LogicalOrExpression_100_Var
		 = (LogicalOrExpression)AsmLine_99_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = LogicalOrExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final LogicalAndExpression LogicalAndExpression_101_Var
		 = (LogicalAndExpression)Expr_100_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = LogicalAndExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final InclusiveOrExpression InclusiveOrExpression_102_Var
		 = (InclusiveOrExpression)Expr_101_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = InclusiveOrExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final ExclusiveOrExpression ExclusiveOrExpression_103_Var
		 = (ExclusiveOrExpression)Expr_102_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = ExclusiveOrExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final AndExpression AndExpression_104_Var
		 = (AndExpression)Expr_103_list.get(0);
		Assert.assertNotNull(AndExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = AndExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final EqualityExpression EqualityExpression_105_Var
		 = (EqualityExpression)Expr_104_list.get(0);
		Assert.assertNotNull(EqualityExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = EqualityExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final RelationalExpression RelationalExpression_106_Var
		 = (RelationalExpression)Expr_105_list.get(0);
		Assert.assertNotNull(RelationalExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = RelationalExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final ShiftExpression ShiftExpression_107_Var
		 = (ShiftExpression)Expr_106_list.get(0);
		Assert.assertNotNull(ShiftExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = ShiftExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final AdditiveExpression AdditiveExpression_108_Var
		 = (AdditiveExpression)Expr_107_list.get(0);
		Assert.assertNotNull(AdditiveExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = AdditiveExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final MultiplicativeExpression MultiplicativeExpression_109_Var
		 = (MultiplicativeExpression)Expr_108_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = MultiplicativeExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final CastExpression CastExpression_110_Var
		 = (CastExpression)Expr_109_list.get(0);
		Assert.assertNotNull(CastExpression_110_Var
		);
		//110
		final UnaryExpression UnaryExpression_111_Var
		 = (UnaryExpression)CastExpression_110_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_111_Var
		);
		//111
		final PostfixExpression PostfixExpression_112_Var
		 = (PostfixExpression)UnaryExpression_111_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = PostfixExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final PrimaryExpression PrimaryExpression_113_Var
		 = (PrimaryExpression)Expr_112_list.get(0);
		Assert.assertNotNull(PrimaryExpression_113_Var
		);
		//113
		final Constant2 Constant2_114_Var
		 = (Constant2)PrimaryExpression_113_Var
		.getConst();
		Assert.assertNotNull(Constant2_114_Var
		);
		Assert.assertEquals("\"+b\"", Constant2_114_Var
		.getStr());
		final EList<? extends EObject> Suffix_114_list = PostfixExpression_112_Var
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
		Assert.assertEquals(1, Expr_116_list.size());
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
		Assert.assertEquals("arg1", PrimaryExpression_132_Var
		.getId());
		//132
		final AsmLine AsmLine_133_Var
		 = (AsmLine)AsmLines_98_list.get(1);
		Assert.assertNotNull(AsmLine_133_Var
		);
		Assert.assertTrue(AsmLine_133_Var
		.isComma());
		//133
		final LogicalOrExpression LogicalOrExpression_134_Var
		 = (LogicalOrExpression)AsmLine_133_Var
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
		//147
		final Constant2 Constant2_148_Var
		 = (Constant2)PrimaryExpression_147_Var
		.getConst();
		Assert.assertNotNull(Constant2_148_Var
		);
		Assert.assertEquals("\"+c\"", Constant2_148_Var
		.getStr());
		final EList<? extends EObject> Suffix_148_list = PostfixExpression_146_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_148_list);
		Assert.assertEquals(1, Suffix_148_list.size());
		//148
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_149_Var
		 = (PostfixExpressionSuffixArgument)Suffix_148_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_149_Var
		);
		//149
		final ArgumentExpressionList ArgumentExpressionList_150_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_149_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_150_Var
		);
		final EList<? extends EObject> Expr_150_list = ArgumentExpressionList_150_Var
		.getExpr();
		Assert.assertNotNull(Expr_150_list);
		Assert.assertEquals(1, Expr_150_list.size());
		//150
		final AssignmentExpression AssignmentExpression_151_Var
		 = (AssignmentExpression)Expr_150_list.get(0);
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
		Assert.assertEquals("arg2", PrimaryExpression_166_Var
		.getId());
		//166
		final AsmLine AsmLine_167_Var
		 = (AsmLine)AsmLines_98_list.get(2);
		Assert.assertNotNull(AsmLine_167_Var
		);
		Assert.assertTrue(AsmLine_167_Var
		.isComma());
		//167
		final LogicalOrExpression LogicalOrExpression_168_Var
		 = (LogicalOrExpression)AsmLine_167_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_168_Var
		);
		final EList<? extends EObject> Expr_168_list = LogicalOrExpression_168_Var
		.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(1, Expr_168_list.size());
		//168
		final LogicalAndExpression LogicalAndExpression_169_Var
		 = (LogicalAndExpression)Expr_168_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_169_Var
		);
		final EList<? extends EObject> Expr_169_list = LogicalAndExpression_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		//169
		final InclusiveOrExpression InclusiveOrExpression_170_Var
		 = (InclusiveOrExpression)Expr_169_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_170_Var
		);
		final EList<? extends EObject> Expr_170_list = InclusiveOrExpression_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		//170
		final ExclusiveOrExpression ExclusiveOrExpression_171_Var
		 = (ExclusiveOrExpression)Expr_170_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_171_Var
		);
		final EList<? extends EObject> Expr_171_list = ExclusiveOrExpression_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		//171
		final AndExpression AndExpression_172_Var
		 = (AndExpression)Expr_171_list.get(0);
		Assert.assertNotNull(AndExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = AndExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final EqualityExpression EqualityExpression_173_Var
		 = (EqualityExpression)Expr_172_list.get(0);
		Assert.assertNotNull(EqualityExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = EqualityExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final RelationalExpression RelationalExpression_174_Var
		 = (RelationalExpression)Expr_173_list.get(0);
		Assert.assertNotNull(RelationalExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = RelationalExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final ShiftExpression ShiftExpression_175_Var
		 = (ShiftExpression)Expr_174_list.get(0);
		Assert.assertNotNull(ShiftExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = ShiftExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final AdditiveExpression AdditiveExpression_176_Var
		 = (AdditiveExpression)Expr_175_list.get(0);
		Assert.assertNotNull(AdditiveExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = AdditiveExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final MultiplicativeExpression MultiplicativeExpression_177_Var
		 = (MultiplicativeExpression)Expr_176_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = MultiplicativeExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final CastExpression CastExpression_178_Var
		 = (CastExpression)Expr_177_list.get(0);
		Assert.assertNotNull(CastExpression_178_Var
		);
		//178
		final UnaryExpression UnaryExpression_179_Var
		 = (UnaryExpression)CastExpression_178_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_179_Var
		);
		//179
		final PostfixExpression PostfixExpression_180_Var
		 = (PostfixExpression)UnaryExpression_179_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_180_Var
		);
		final EList<? extends EObject> Expr_180_list = PostfixExpression_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final PrimaryExpression PrimaryExpression_181_Var
		 = (PrimaryExpression)Expr_180_list.get(0);
		Assert.assertNotNull(PrimaryExpression_181_Var
		);
		//181
		final Constant2 Constant2_182_Var
		 = (Constant2)PrimaryExpression_181_Var
		.getConst();
		Assert.assertNotNull(Constant2_182_Var
		);
		Assert.assertEquals("\"+d\"", Constant2_182_Var
		.getStr());
		final EList<? extends EObject> Suffix_182_list = PostfixExpression_180_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_182_list);
		Assert.assertEquals(1, Suffix_182_list.size());
		//182
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_183_Var
		 = (PostfixExpressionSuffixArgument)Suffix_182_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_183_Var
		);
		//183
		final ArgumentExpressionList ArgumentExpressionList_184_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_183_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_184_Var
		);
		final EList<? extends EObject> Expr_184_list = ArgumentExpressionList_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final AssignmentExpression AssignmentExpression_185_Var
		 = (AssignmentExpression)Expr_184_list.get(0);
		Assert.assertNotNull(AssignmentExpression_185_Var
		);
		//185
		final ConditionalExpression ConditionalExpression_186_Var
		 = (ConditionalExpression)AssignmentExpression_185_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_186_Var
		);
		//186
		final LogicalOrExpression LogicalOrExpression_187_Var
		 = (LogicalOrExpression)ConditionalExpression_186_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_187_Var
		);
		final EList<? extends EObject> Expr_187_list = LogicalOrExpression_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(1, Expr_187_list.size());
		//187
		final LogicalAndExpression LogicalAndExpression_188_Var
		 = (LogicalAndExpression)Expr_187_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = LogicalAndExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final InclusiveOrExpression InclusiveOrExpression_189_Var
		 = (InclusiveOrExpression)Expr_188_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = InclusiveOrExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final ExclusiveOrExpression ExclusiveOrExpression_190_Var
		 = (ExclusiveOrExpression)Expr_189_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = ExclusiveOrExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final AndExpression AndExpression_191_Var
		 = (AndExpression)Expr_190_list.get(0);
		Assert.assertNotNull(AndExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = AndExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final EqualityExpression EqualityExpression_192_Var
		 = (EqualityExpression)Expr_191_list.get(0);
		Assert.assertNotNull(EqualityExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = EqualityExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final RelationalExpression RelationalExpression_193_Var
		 = (RelationalExpression)Expr_192_list.get(0);
		Assert.assertNotNull(RelationalExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = RelationalExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final ShiftExpression ShiftExpression_194_Var
		 = (ShiftExpression)Expr_193_list.get(0);
		Assert.assertNotNull(ShiftExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = ShiftExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final AdditiveExpression AdditiveExpression_195_Var
		 = (AdditiveExpression)Expr_194_list.get(0);
		Assert.assertNotNull(AdditiveExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = AdditiveExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final MultiplicativeExpression MultiplicativeExpression_196_Var
		 = (MultiplicativeExpression)Expr_195_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = MultiplicativeExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final CastExpression CastExpression_197_Var
		 = (CastExpression)Expr_196_list.get(0);
		Assert.assertNotNull(CastExpression_197_Var
		);
		//197
		final UnaryExpression UnaryExpression_198_Var
		 = (UnaryExpression)CastExpression_197_Var
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
		Assert.assertEquals("arg3", PrimaryExpression_200_Var
		.getId());
		//200
		final AsmLineWithColon AsmLineWithColon_201_Var
		 = (AsmLineWithColon)AsmLines_63_list.get(1);
		Assert.assertNotNull(AsmLineWithColon_201_Var
		);
		//201
		final AsmLineWithoutColon AsmLineWithoutColon_202_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_201_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_202_Var
		);
		//202
		final LogicalOrExpression LogicalOrExpression_203_Var
		 = (LogicalOrExpression)AsmLineWithoutColon_202_Var
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
		final AsmLineWithColon AsmLineWithColon_237_Var
		 = (AsmLineWithColon)AsmLines_63_list.get(2);
		Assert.assertNotNull(AsmLineWithColon_237_Var
		);
		//237
		final AsmLineWithoutColon AsmLineWithoutColon_238_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_237_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_238_Var
		);
		//238
		final LogicalOrExpression LogicalOrExpression_239_Var
		 = (LogicalOrExpression)AsmLineWithoutColon_238_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = LogicalOrExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final LogicalAndExpression LogicalAndExpression_240_Var
		 = (LogicalAndExpression)Expr_239_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = LogicalAndExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final InclusiveOrExpression InclusiveOrExpression_241_Var
		 = (InclusiveOrExpression)Expr_240_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = InclusiveOrExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final ExclusiveOrExpression ExclusiveOrExpression_242_Var
		 = (ExclusiveOrExpression)Expr_241_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = ExclusiveOrExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final AndExpression AndExpression_243_Var
		 = (AndExpression)Expr_242_list.get(0);
		Assert.assertNotNull(AndExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = AndExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final EqualityExpression EqualityExpression_244_Var
		 = (EqualityExpression)Expr_243_list.get(0);
		Assert.assertNotNull(EqualityExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = EqualityExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final RelationalExpression RelationalExpression_245_Var
		 = (RelationalExpression)Expr_244_list.get(0);
		Assert.assertNotNull(RelationalExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = RelationalExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final ShiftExpression ShiftExpression_246_Var
		 = (ShiftExpression)Expr_245_list.get(0);
		Assert.assertNotNull(ShiftExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = ShiftExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final AdditiveExpression AdditiveExpression_247_Var
		 = (AdditiveExpression)Expr_246_list.get(0);
		Assert.assertNotNull(AdditiveExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = AdditiveExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final MultiplicativeExpression MultiplicativeExpression_248_Var
		 = (MultiplicativeExpression)Expr_247_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = MultiplicativeExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final CastExpression CastExpression_249_Var
		 = (CastExpression)Expr_248_list.get(0);
		Assert.assertNotNull(CastExpression_249_Var
		);
		//249
		final UnaryExpression UnaryExpression_250_Var
		 = (UnaryExpression)CastExpression_249_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_250_Var
		);
		//250
		final PostfixExpression PostfixExpression_251_Var
		 = (PostfixExpression)UnaryExpression_250_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = PostfixExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final PrimaryExpression PrimaryExpression_252_Var
		 = (PrimaryExpression)Expr_251_list.get(0);
		Assert.assertNotNull(PrimaryExpression_252_Var
		);
		//252
		final Constant2 Constant2_253_Var
		 = (Constant2)PrimaryExpression_252_Var
		.getConst();
		Assert.assertNotNull(Constant2_253_Var
		);
		Assert.assertEquals("\"memory\"", Constant2_253_Var
		.getStr());
		final EList<? extends EObject> AsmLines_253_list = AsmLineWithoutColon_238_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_253_list);
		Assert.assertEquals(1, AsmLines_253_list.size());
		//253
		final AsmLine AsmLine_254_Var
		 = (AsmLine)AsmLines_253_list.get(0);
		Assert.assertNotNull(AsmLine_254_Var
		);
		Assert.assertTrue(AsmLine_254_Var
		.isComma());
		//254
		final LogicalOrExpression LogicalOrExpression_255_Var
		 = (LogicalOrExpression)AsmLine_254_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_255_Var
		);
		final EList<? extends EObject> Expr_255_list = LogicalOrExpression_255_Var
		.getExpr();
		Assert.assertNotNull(Expr_255_list);
		Assert.assertEquals(1, Expr_255_list.size());
		//255
		final LogicalAndExpression LogicalAndExpression_256_Var
		 = (LogicalAndExpression)Expr_255_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_256_Var
		);
		final EList<? extends EObject> Expr_256_list = LogicalAndExpression_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(1, Expr_256_list.size());
		//256
		final InclusiveOrExpression InclusiveOrExpression_257_Var
		 = (InclusiveOrExpression)Expr_256_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = InclusiveOrExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final ExclusiveOrExpression ExclusiveOrExpression_258_Var
		 = (ExclusiveOrExpression)Expr_257_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_258_Var
		);
		final EList<? extends EObject> Expr_258_list = ExclusiveOrExpression_258_Var
		.getExpr();
		Assert.assertNotNull(Expr_258_list);
		Assert.assertEquals(1, Expr_258_list.size());
		//258
		final AndExpression AndExpression_259_Var
		 = (AndExpression)Expr_258_list.get(0);
		Assert.assertNotNull(AndExpression_259_Var
		);
		final EList<? extends EObject> Expr_259_list = AndExpression_259_Var
		.getExpr();
		Assert.assertNotNull(Expr_259_list);
		Assert.assertEquals(1, Expr_259_list.size());
		//259
		final EqualityExpression EqualityExpression_260_Var
		 = (EqualityExpression)Expr_259_list.get(0);
		Assert.assertNotNull(EqualityExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = EqualityExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final RelationalExpression RelationalExpression_261_Var
		 = (RelationalExpression)Expr_260_list.get(0);
		Assert.assertNotNull(RelationalExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = RelationalExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final ShiftExpression ShiftExpression_262_Var
		 = (ShiftExpression)Expr_261_list.get(0);
		Assert.assertNotNull(ShiftExpression_262_Var
		);
		final EList<? extends EObject> Expr_262_list = ShiftExpression_262_Var
		.getExpr();
		Assert.assertNotNull(Expr_262_list);
		Assert.assertEquals(1, Expr_262_list.size());
		//262
		final AdditiveExpression AdditiveExpression_263_Var
		 = (AdditiveExpression)Expr_262_list.get(0);
		Assert.assertNotNull(AdditiveExpression_263_Var
		);
		final EList<? extends EObject> Expr_263_list = AdditiveExpression_263_Var
		.getExpr();
		Assert.assertNotNull(Expr_263_list);
		Assert.assertEquals(1, Expr_263_list.size());
		//263
		final MultiplicativeExpression MultiplicativeExpression_264_Var
		 = (MultiplicativeExpression)Expr_263_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_264_Var
		);
		final EList<? extends EObject> Expr_264_list = MultiplicativeExpression_264_Var
		.getExpr();
		Assert.assertNotNull(Expr_264_list);
		Assert.assertEquals(1, Expr_264_list.size());
		//264
		final CastExpression CastExpression_265_Var
		 = (CastExpression)Expr_264_list.get(0);
		Assert.assertNotNull(CastExpression_265_Var
		);
		//265
		final UnaryExpression UnaryExpression_266_Var
		 = (UnaryExpression)CastExpression_265_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_266_Var
		);
		//266
		final PostfixExpression PostfixExpression_267_Var
		 = (PostfixExpression)UnaryExpression_266_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_267_Var
		);
		final EList<? extends EObject> Expr_267_list = PostfixExpression_267_Var
		.getExpr();
		Assert.assertNotNull(Expr_267_list);
		Assert.assertEquals(1, Expr_267_list.size());
		//267
		final PrimaryExpression PrimaryExpression_268_Var
		 = (PrimaryExpression)Expr_267_list.get(0);
		Assert.assertNotNull(PrimaryExpression_268_Var
		);
		//268
		final Constant2 Constant2_269_Var
		 = (Constant2)PrimaryExpression_268_Var
		.getConst();
		Assert.assertNotNull(Constant2_269_Var
		);
		Assert.assertEquals("\"cc\"", Constant2_269_Var
		.getStr());
		Assert.assertEquals(";", AsmStatement_47_Var
		.getSemi());
		//269
		final Statement Statement_270_Var
		 = (Statement)Statement_45_list.get(1);
		Assert.assertNotNull(Statement_270_Var
		);
		//270
		final SelectionStatement SelectionStatement_271_Var
		 = (SelectionStatement)Statement_270_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_271_Var
		);
		Assert.assertEquals("if", SelectionStatement_271_Var
		.getIf());
		//271
		final Expression Expression_272_Var
		 = (Expression)SelectionStatement_271_Var
		.getExpr();
		Assert.assertNotNull(Expression_272_Var
		);
		final EList<? extends EObject> ExprExpr_272_list = Expression_272_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_272_list);
		Assert.assertEquals(1, ExprExpr_272_list.size());
		//272
		final AssignmentExpression AssignmentExpression_273_Var
		 = (AssignmentExpression)ExprExpr_272_list.get(0);
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
		Assert.assertEquals(2, Expr_276_list.size());
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
		Assert.assertEquals("[<=]", RelationalExpression_281_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_281_list = RelationalExpression_281_Var
		.getExpr();
		Assert.assertNotNull(Expr_281_list);
		Assert.assertEquals(2, Expr_281_list.size());
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
		final CastExpression CastExpression_287_Var
		 = (CastExpression)UnaryExpression_286_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_287_Var
		);
		//287
		final UnaryExpression UnaryExpression_288_Var
		 = (UnaryExpression)CastExpression_287_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_288_Var
		);
		//288
		final PostfixExpression PostfixExpression_289_Var
		 = (PostfixExpression)UnaryExpression_288_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_289_Var
		);
		final EList<? extends EObject> Expr_289_list = PostfixExpression_289_Var
		.getExpr();
		Assert.assertNotNull(Expr_289_list);
		Assert.assertEquals(1, Expr_289_list.size());
		//289
		final PrimaryExpression PrimaryExpression_290_Var
		 = (PrimaryExpression)Expr_289_list.get(0);
		Assert.assertNotNull(PrimaryExpression_290_Var
		);
		//290
		final Constant2 Constant2_291_Var
		 = (Constant2)PrimaryExpression_290_Var
		.getConst();
		Assert.assertNotNull(Constant2_291_Var
		);
		Assert.assertEquals("125", Constant2_291_Var
		.getDec());
		//291
		final UnaryOperator UnaryOperator_292_Var
		 = (UnaryOperator)UnaryExpression_286_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_292_Var
		);
		Assert.assertEquals("-", UnaryOperator_292_Var
		.getOp());
		//292
		final ShiftExpression ShiftExpression_293_Var
		 = (ShiftExpression)Expr_281_list.get(1);
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
		Assert.assertEquals("res", PrimaryExpression_299_Var
		.getId());
		//299
		final InclusiveOrExpression InclusiveOrExpression_300_Var
		 = (InclusiveOrExpression)Expr_276_list.get(1);
		Assert.assertNotNull(InclusiveOrExpression_300_Var
		);
		final EList<? extends EObject> Expr_300_list = InclusiveOrExpression_300_Var
		.getExpr();
		Assert.assertNotNull(Expr_300_list);
		Assert.assertEquals(1, Expr_300_list.size());
		//300
		final ExclusiveOrExpression ExclusiveOrExpression_301_Var
		 = (ExclusiveOrExpression)Expr_300_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_301_Var
		);
		final EList<? extends EObject> Expr_301_list = ExclusiveOrExpression_301_Var
		.getExpr();
		Assert.assertNotNull(Expr_301_list);
		Assert.assertEquals(1, Expr_301_list.size());
		//301
		final AndExpression AndExpression_302_Var
		 = (AndExpression)Expr_301_list.get(0);
		Assert.assertNotNull(AndExpression_302_Var
		);
		final EList<? extends EObject> Expr_302_list = AndExpression_302_Var
		.getExpr();
		Assert.assertNotNull(Expr_302_list);
		Assert.assertEquals(1, Expr_302_list.size());
		//302
		final EqualityExpression EqualityExpression_303_Var
		 = (EqualityExpression)Expr_302_list.get(0);
		Assert.assertNotNull(EqualityExpression_303_Var
		);
		final EList<? extends EObject> Expr_303_list = EqualityExpression_303_Var
		.getExpr();
		Assert.assertNotNull(Expr_303_list);
		Assert.assertEquals(1, Expr_303_list.size());
		//303
		final RelationalExpression RelationalExpression_304_Var
		 = (RelationalExpression)Expr_303_list.get(0);
		Assert.assertNotNull(RelationalExpression_304_Var
		);
		Assert.assertEquals("[<]", RelationalExpression_304_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_304_list = RelationalExpression_304_Var
		.getExpr();
		Assert.assertNotNull(Expr_304_list);
		Assert.assertEquals(2, Expr_304_list.size());
		//304
		final ShiftExpression ShiftExpression_305_Var
		 = (ShiftExpression)Expr_304_list.get(0);
		Assert.assertNotNull(ShiftExpression_305_Var
		);
		final EList<? extends EObject> Expr_305_list = ShiftExpression_305_Var
		.getExpr();
		Assert.assertNotNull(Expr_305_list);
		Assert.assertEquals(1, Expr_305_list.size());
		//305
		final AdditiveExpression AdditiveExpression_306_Var
		 = (AdditiveExpression)Expr_305_list.get(0);
		Assert.assertNotNull(AdditiveExpression_306_Var
		);
		final EList<? extends EObject> Expr_306_list = AdditiveExpression_306_Var
		.getExpr();
		Assert.assertNotNull(Expr_306_list);
		Assert.assertEquals(1, Expr_306_list.size());
		//306
		final MultiplicativeExpression MultiplicativeExpression_307_Var
		 = (MultiplicativeExpression)Expr_306_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_307_Var
		);
		final EList<? extends EObject> Expr_307_list = MultiplicativeExpression_307_Var
		.getExpr();
		Assert.assertNotNull(Expr_307_list);
		Assert.assertEquals(1, Expr_307_list.size());
		//307
		final CastExpression CastExpression_308_Var
		 = (CastExpression)Expr_307_list.get(0);
		Assert.assertNotNull(CastExpression_308_Var
		);
		//308
		final UnaryExpression UnaryExpression_309_Var
		 = (UnaryExpression)CastExpression_308_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_309_Var
		);
		//309
		final PostfixExpression PostfixExpression_310_Var
		 = (PostfixExpression)UnaryExpression_309_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_310_Var
		);
		final EList<? extends EObject> Expr_310_list = PostfixExpression_310_Var
		.getExpr();
		Assert.assertNotNull(Expr_310_list);
		Assert.assertEquals(1, Expr_310_list.size());
		//310
		final PrimaryExpression PrimaryExpression_311_Var
		 = (PrimaryExpression)Expr_310_list.get(0);
		Assert.assertNotNull(PrimaryExpression_311_Var
		);
		Assert.assertEquals("res", PrimaryExpression_311_Var
		.getId());
		//311
		final ShiftExpression ShiftExpression_312_Var
		 = (ShiftExpression)Expr_304_list.get(1);
		Assert.assertNotNull(ShiftExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = ShiftExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final AdditiveExpression AdditiveExpression_313_Var
		 = (AdditiveExpression)Expr_312_list.get(0);
		Assert.assertNotNull(AdditiveExpression_313_Var
		);
		final EList<? extends EObject> Expr_313_list = AdditiveExpression_313_Var
		.getExpr();
		Assert.assertNotNull(Expr_313_list);
		Assert.assertEquals(1, Expr_313_list.size());
		//313
		final MultiplicativeExpression MultiplicativeExpression_314_Var
		 = (MultiplicativeExpression)Expr_313_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = MultiplicativeExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final CastExpression CastExpression_315_Var
		 = (CastExpression)Expr_314_list.get(0);
		Assert.assertNotNull(CastExpression_315_Var
		);
		//315
		final UnaryExpression UnaryExpression_316_Var
		 = (UnaryExpression)CastExpression_315_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_316_Var
		);
		//316
		final PostfixExpression PostfixExpression_317_Var
		 = (PostfixExpression)UnaryExpression_316_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_317_Var
		);
		final EList<? extends EObject> Expr_317_list = PostfixExpression_317_Var
		.getExpr();
		Assert.assertNotNull(Expr_317_list);
		Assert.assertEquals(1, Expr_317_list.size());
		//317
		final PrimaryExpression PrimaryExpression_318_Var
		 = (PrimaryExpression)Expr_317_list.get(0);
		Assert.assertNotNull(PrimaryExpression_318_Var
		);
		//318
		final Constant2 Constant2_319_Var
		 = (Constant2)PrimaryExpression_318_Var
		.getConst();
		Assert.assertNotNull(Constant2_319_Var
		);
		Assert.assertEquals("0", Constant2_319_Var
		.getDec());
		//319
		final Statement Statement_320_Var
		 = (Statement)SelectionStatement_271_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_320_Var
		);
		//320
		final CompoundStatement CompoundStatement_321_Var
		 = (CompoundStatement)Statement_320_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_321_Var
		);
		//321
		final BodyStatement BodyStatement_322_Var
		 = (BodyStatement)CompoundStatement_321_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_322_Var
		);
		final EList<? extends EObject> BlockList_322_list = BodyStatement_322_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_322_list);
		Assert.assertEquals(1, BlockList_322_list.size());
		//322
		final BlockList BlockList_323_Var
		 = (BlockList)BlockList_322_list.get(0);
		Assert.assertNotNull(BlockList_323_Var
		);
		final EList<? extends EObject> Statement_323_list = BlockList_323_Var
		.getStatement();
		Assert.assertNotNull(Statement_323_list);
		Assert.assertEquals(2, Statement_323_list.size());
		//323
		final Statement Statement_324_Var
		 = (Statement)Statement_323_list.get(0);
		Assert.assertNotNull(Statement_324_Var
		);
		//324
		final ExpressionStatement ExpressionStatement_325_Var
		 = (ExpressionStatement)Statement_324_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_325_Var
		);
		//325
		final Expression Expression_326_Var
		 = (Expression)ExpressionStatement_325_Var
		.getExpression();
		Assert.assertNotNull(Expression_326_Var
		);
		final EList<? extends EObject> ExprExpr_326_list = Expression_326_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_326_list);
		Assert.assertEquals(1, ExprExpr_326_list.size());
		//326
		final AssignmentExpression AssignmentExpression_327_Var
		 = (AssignmentExpression)ExprExpr_326_list.get(0);
		Assert.assertNotNull(AssignmentExpression_327_Var
		);
		//327
		final UnaryExpression UnaryExpression_328_Var
		 = (UnaryExpression)AssignmentExpression_327_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_328_Var
		);
		//328
		final PostfixExpression PostfixExpression_329_Var
		 = (PostfixExpression)UnaryExpression_328_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_329_Var
		);
		final EList<? extends EObject> Expr_329_list = PostfixExpression_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final PrimaryExpression PrimaryExpression_330_Var
		 = (PrimaryExpression)Expr_329_list.get(0);
		Assert.assertNotNull(PrimaryExpression_330_Var
		);
		Assert.assertEquals("errno", PrimaryExpression_330_Var
		.getId());
		//330
		final AssignmentOperator AssignmentOperator_331_Var
		 = (AssignmentOperator)AssignmentExpression_327_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_331_Var
		);
		Assert.assertEquals("=", AssignmentOperator_331_Var
		.getOp());
		//331
		final AssignmentExpression AssignmentExpression_332_Var
		 = (AssignmentExpression)AssignmentExpression_327_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_332_Var
		);
		//332
		final ConditionalExpression ConditionalExpression_333_Var
		 = (ConditionalExpression)AssignmentExpression_332_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_333_Var
		);
		//333
		final LogicalOrExpression LogicalOrExpression_334_Var
		 = (LogicalOrExpression)ConditionalExpression_333_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = LogicalOrExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final LogicalAndExpression LogicalAndExpression_335_Var
		 = (LogicalAndExpression)Expr_334_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = LogicalAndExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final InclusiveOrExpression InclusiveOrExpression_336_Var
		 = (InclusiveOrExpression)Expr_335_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = InclusiveOrExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final ExclusiveOrExpression ExclusiveOrExpression_337_Var
		 = (ExclusiveOrExpression)Expr_336_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_337_Var
		);
		final EList<? extends EObject> Expr_337_list = ExclusiveOrExpression_337_Var
		.getExpr();
		Assert.assertNotNull(Expr_337_list);
		Assert.assertEquals(1, Expr_337_list.size());
		//337
		final AndExpression AndExpression_338_Var
		 = (AndExpression)Expr_337_list.get(0);
		Assert.assertNotNull(AndExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = AndExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final EqualityExpression EqualityExpression_339_Var
		 = (EqualityExpression)Expr_338_list.get(0);
		Assert.assertNotNull(EqualityExpression_339_Var
		);
		final EList<? extends EObject> Expr_339_list = EqualityExpression_339_Var
		.getExpr();
		Assert.assertNotNull(Expr_339_list);
		Assert.assertEquals(1, Expr_339_list.size());
		//339
		final RelationalExpression RelationalExpression_340_Var
		 = (RelationalExpression)Expr_339_list.get(0);
		Assert.assertNotNull(RelationalExpression_340_Var
		);
		final EList<? extends EObject> Expr_340_list = RelationalExpression_340_Var
		.getExpr();
		Assert.assertNotNull(Expr_340_list);
		Assert.assertEquals(1, Expr_340_list.size());
		//340
		final ShiftExpression ShiftExpression_341_Var
		 = (ShiftExpression)Expr_340_list.get(0);
		Assert.assertNotNull(ShiftExpression_341_Var
		);
		final EList<? extends EObject> Expr_341_list = ShiftExpression_341_Var
		.getExpr();
		Assert.assertNotNull(Expr_341_list);
		Assert.assertEquals(1, Expr_341_list.size());
		//341
		final AdditiveExpression AdditiveExpression_342_Var
		 = (AdditiveExpression)Expr_341_list.get(0);
		Assert.assertNotNull(AdditiveExpression_342_Var
		);
		final EList<? extends EObject> Expr_342_list = AdditiveExpression_342_Var
		.getExpr();
		Assert.assertNotNull(Expr_342_list);
		Assert.assertEquals(1, Expr_342_list.size());
		//342
		final MultiplicativeExpression MultiplicativeExpression_343_Var
		 = (MultiplicativeExpression)Expr_342_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_343_Var
		);
		final EList<? extends EObject> Expr_343_list = MultiplicativeExpression_343_Var
		.getExpr();
		Assert.assertNotNull(Expr_343_list);
		Assert.assertEquals(1, Expr_343_list.size());
		//343
		final CastExpression CastExpression_344_Var
		 = (CastExpression)Expr_343_list.get(0);
		Assert.assertNotNull(CastExpression_344_Var
		);
		//344
		final UnaryExpression UnaryExpression_345_Var
		 = (UnaryExpression)CastExpression_344_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_345_Var
		);
		//345
		final UnaryOperator UnaryOperator_346_Var
		 = (UnaryOperator)UnaryExpression_345_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_346_Var
		);
		Assert.assertEquals("-", UnaryOperator_346_Var
		.getOp());
		//346
		final CastExpression CastExpression_347_Var
		 = (CastExpression)UnaryExpression_345_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_347_Var
		);
		//347
		final UnaryExpression UnaryExpression_348_Var
		 = (UnaryExpression)CastExpression_347_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_348_Var
		);
		//348
		final PostfixExpression PostfixExpression_349_Var
		 = (PostfixExpression)UnaryExpression_348_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_349_Var
		);
		final EList<? extends EObject> Expr_349_list = PostfixExpression_349_Var
		.getExpr();
		Assert.assertNotNull(Expr_349_list);
		Assert.assertEquals(1, Expr_349_list.size());
		//349
		final PrimaryExpression PrimaryExpression_350_Var
		 = (PrimaryExpression)Expr_349_list.get(0);
		Assert.assertNotNull(PrimaryExpression_350_Var
		);
		Assert.assertEquals("res", PrimaryExpression_350_Var
		.getId());
		//350
		final Statement Statement_351_Var
		 = (Statement)Statement_323_list.get(1);
		Assert.assertNotNull(Statement_351_Var
		);
		//351
		final ExpressionStatement ExpressionStatement_352_Var
		 = (ExpressionStatement)Statement_351_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_352_Var
		);
		//352
		final Expression Expression_353_Var
		 = (Expression)ExpressionStatement_352_Var
		.getExpression();
		Assert.assertNotNull(Expression_353_Var
		);
		final EList<? extends EObject> ExprExpr_353_list = Expression_353_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_353_list);
		Assert.assertEquals(1, ExprExpr_353_list.size());
		//353
		final AssignmentExpression AssignmentExpression_354_Var
		 = (AssignmentExpression)ExprExpr_353_list.get(0);
		Assert.assertNotNull(AssignmentExpression_354_Var
		);
		//354
		final UnaryExpression UnaryExpression_355_Var
		 = (UnaryExpression)AssignmentExpression_354_Var
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
		Assert.assertEquals("res", PrimaryExpression_357_Var
		.getId());
		//357
		final AssignmentOperator AssignmentOperator_358_Var
		 = (AssignmentOperator)AssignmentExpression_354_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_358_Var
		);
		Assert.assertEquals("=", AssignmentOperator_358_Var
		.getOp());
		//358
		final AssignmentExpression AssignmentExpression_359_Var
		 = (AssignmentExpression)AssignmentExpression_354_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_359_Var
		);
		//359
		final ConditionalExpression ConditionalExpression_360_Var
		 = (ConditionalExpression)AssignmentExpression_359_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_360_Var
		);
		//360
		final LogicalOrExpression LogicalOrExpression_361_Var
		 = (LogicalOrExpression)ConditionalExpression_360_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_361_Var
		);
		final EList<? extends EObject> Expr_361_list = LogicalOrExpression_361_Var
		.getExpr();
		Assert.assertNotNull(Expr_361_list);
		Assert.assertEquals(1, Expr_361_list.size());
		//361
		final LogicalAndExpression LogicalAndExpression_362_Var
		 = (LogicalAndExpression)Expr_361_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_362_Var
		);
		final EList<? extends EObject> Expr_362_list = LogicalAndExpression_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(1, Expr_362_list.size());
		//362
		final InclusiveOrExpression InclusiveOrExpression_363_Var
		 = (InclusiveOrExpression)Expr_362_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_363_Var
		);
		final EList<? extends EObject> Expr_363_list = InclusiveOrExpression_363_Var
		.getExpr();
		Assert.assertNotNull(Expr_363_list);
		Assert.assertEquals(1, Expr_363_list.size());
		//363
		final ExclusiveOrExpression ExclusiveOrExpression_364_Var
		 = (ExclusiveOrExpression)Expr_363_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_364_Var
		);
		final EList<? extends EObject> Expr_364_list = ExclusiveOrExpression_364_Var
		.getExpr();
		Assert.assertNotNull(Expr_364_list);
		Assert.assertEquals(1, Expr_364_list.size());
		//364
		final AndExpression AndExpression_365_Var
		 = (AndExpression)Expr_364_list.get(0);
		Assert.assertNotNull(AndExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = AndExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final EqualityExpression EqualityExpression_366_Var
		 = (EqualityExpression)Expr_365_list.get(0);
		Assert.assertNotNull(EqualityExpression_366_Var
		);
		final EList<? extends EObject> Expr_366_list = EqualityExpression_366_Var
		.getExpr();
		Assert.assertNotNull(Expr_366_list);
		Assert.assertEquals(1, Expr_366_list.size());
		//366
		final RelationalExpression RelationalExpression_367_Var
		 = (RelationalExpression)Expr_366_list.get(0);
		Assert.assertNotNull(RelationalExpression_367_Var
		);
		final EList<? extends EObject> Expr_367_list = RelationalExpression_367_Var
		.getExpr();
		Assert.assertNotNull(Expr_367_list);
		Assert.assertEquals(1, Expr_367_list.size());
		//367
		final ShiftExpression ShiftExpression_368_Var
		 = (ShiftExpression)Expr_367_list.get(0);
		Assert.assertNotNull(ShiftExpression_368_Var
		);
		final EList<? extends EObject> Expr_368_list = ShiftExpression_368_Var
		.getExpr();
		Assert.assertNotNull(Expr_368_list);
		Assert.assertEquals(1, Expr_368_list.size());
		//368
		final AdditiveExpression AdditiveExpression_369_Var
		 = (AdditiveExpression)Expr_368_list.get(0);
		Assert.assertNotNull(AdditiveExpression_369_Var
		);
		final EList<? extends EObject> Expr_369_list = AdditiveExpression_369_Var
		.getExpr();
		Assert.assertNotNull(Expr_369_list);
		Assert.assertEquals(1, Expr_369_list.size());
		//369
		final MultiplicativeExpression MultiplicativeExpression_370_Var
		 = (MultiplicativeExpression)Expr_369_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_370_Var
		);
		final EList<? extends EObject> Expr_370_list = MultiplicativeExpression_370_Var
		.getExpr();
		Assert.assertNotNull(Expr_370_list);
		Assert.assertEquals(1, Expr_370_list.size());
		//370
		final CastExpression CastExpression_371_Var
		 = (CastExpression)Expr_370_list.get(0);
		Assert.assertNotNull(CastExpression_371_Var
		);
		//371
		final UnaryExpression UnaryExpression_372_Var
		 = (UnaryExpression)CastExpression_371_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_372_Var
		);
		//372
		final UnaryOperator UnaryOperator_373_Var
		 = (UnaryOperator)UnaryExpression_372_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_373_Var
		);
		Assert.assertEquals("-", UnaryOperator_373_Var
		.getOp());
		//373
		final CastExpression CastExpression_374_Var
		 = (CastExpression)UnaryExpression_372_Var
		.getExpr();
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
		final Constant2 Constant2_378_Var
		 = (Constant2)PrimaryExpression_377_Var
		.getConst();
		Assert.assertNotNull(Constant2_378_Var
		);
		Assert.assertEquals("1", Constant2_378_Var
		.getDec());
		//378
		final Statement Statement_379_Var
		 = (Statement)Statement_45_list.get(2);
		Assert.assertNotNull(Statement_379_Var
		);
		//379
		final JumpStatement JumpStatement_380_Var
		 = (JumpStatement)Statement_379_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_380_Var
		);
		//380
		final Expression Expression_381_Var
		 = (Expression)JumpStatement_380_Var
		.getExpr();
		Assert.assertNotNull(Expression_381_Var
		);
		final EList<? extends EObject> ExprExpr_381_list = Expression_381_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_381_list);
		Assert.assertEquals(1, ExprExpr_381_list.size());
		//381
		final AssignmentExpression AssignmentExpression_382_Var
		 = (AssignmentExpression)ExprExpr_381_list.get(0);
		Assert.assertNotNull(AssignmentExpression_382_Var
		);
		//382
		final ConditionalExpression ConditionalExpression_383_Var
		 = (ConditionalExpression)AssignmentExpression_382_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_383_Var
		);
		//383
		final LogicalOrExpression LogicalOrExpression_384_Var
		 = (LogicalOrExpression)ConditionalExpression_383_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_384_Var
		);
		final EList<? extends EObject> Expr_384_list = LogicalOrExpression_384_Var
		.getExpr();
		Assert.assertNotNull(Expr_384_list);
		Assert.assertEquals(1, Expr_384_list.size());
		//384
		final LogicalAndExpression LogicalAndExpression_385_Var
		 = (LogicalAndExpression)Expr_384_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_385_Var
		);
		final EList<? extends EObject> Expr_385_list = LogicalAndExpression_385_Var
		.getExpr();
		Assert.assertNotNull(Expr_385_list);
		Assert.assertEquals(1, Expr_385_list.size());
		//385
		final InclusiveOrExpression InclusiveOrExpression_386_Var
		 = (InclusiveOrExpression)Expr_385_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_386_Var
		);
		final EList<? extends EObject> Expr_386_list = InclusiveOrExpression_386_Var
		.getExpr();
		Assert.assertNotNull(Expr_386_list);
		Assert.assertEquals(1, Expr_386_list.size());
		//386
		final ExclusiveOrExpression ExclusiveOrExpression_387_Var
		 = (ExclusiveOrExpression)Expr_386_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_387_Var
		);
		final EList<? extends EObject> Expr_387_list = ExclusiveOrExpression_387_Var
		.getExpr();
		Assert.assertNotNull(Expr_387_list);
		Assert.assertEquals(1, Expr_387_list.size());
		//387
		final AndExpression AndExpression_388_Var
		 = (AndExpression)Expr_387_list.get(0);
		Assert.assertNotNull(AndExpression_388_Var
		);
		final EList<? extends EObject> Expr_388_list = AndExpression_388_Var
		.getExpr();
		Assert.assertNotNull(Expr_388_list);
		Assert.assertEquals(1, Expr_388_list.size());
		//388
		final EqualityExpression EqualityExpression_389_Var
		 = (EqualityExpression)Expr_388_list.get(0);
		Assert.assertNotNull(EqualityExpression_389_Var
		);
		final EList<? extends EObject> Expr_389_list = EqualityExpression_389_Var
		.getExpr();
		Assert.assertNotNull(Expr_389_list);
		Assert.assertEquals(1, Expr_389_list.size());
		//389
		final RelationalExpression RelationalExpression_390_Var
		 = (RelationalExpression)Expr_389_list.get(0);
		Assert.assertNotNull(RelationalExpression_390_Var
		);
		final EList<? extends EObject> Expr_390_list = RelationalExpression_390_Var
		.getExpr();
		Assert.assertNotNull(Expr_390_list);
		Assert.assertEquals(1, Expr_390_list.size());
		//390
		final ShiftExpression ShiftExpression_391_Var
		 = (ShiftExpression)Expr_390_list.get(0);
		Assert.assertNotNull(ShiftExpression_391_Var
		);
		final EList<? extends EObject> Expr_391_list = ShiftExpression_391_Var
		.getExpr();
		Assert.assertNotNull(Expr_391_list);
		Assert.assertEquals(1, Expr_391_list.size());
		//391
		final AdditiveExpression AdditiveExpression_392_Var
		 = (AdditiveExpression)Expr_391_list.get(0);
		Assert.assertNotNull(AdditiveExpression_392_Var
		);
		final EList<? extends EObject> Expr_392_list = AdditiveExpression_392_Var
		.getExpr();
		Assert.assertNotNull(Expr_392_list);
		Assert.assertEquals(1, Expr_392_list.size());
		//392
		final MultiplicativeExpression MultiplicativeExpression_393_Var
		 = (MultiplicativeExpression)Expr_392_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_393_Var
		);
		final EList<? extends EObject> Expr_393_list = MultiplicativeExpression_393_Var
		.getExpr();
		Assert.assertNotNull(Expr_393_list);
		Assert.assertEquals(1, Expr_393_list.size());
		//393
		final CastExpression CastExpression_394_Var
		 = (CastExpression)Expr_393_list.get(0);
		Assert.assertNotNull(CastExpression_394_Var
		);
		//394
		final UnaryExpression UnaryExpression_395_Var
		 = (UnaryExpression)CastExpression_394_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_395_Var
		);
		//395
		final PostfixExpression PostfixExpression_396_Var
		 = (PostfixExpression)UnaryExpression_395_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_396_Var
		);
		final EList<? extends EObject> Expr_396_list = PostfixExpression_396_Var
		.getExpr();
		Assert.assertNotNull(Expr_396_list);
		Assert.assertEquals(1, Expr_396_list.size());
		//396
		final PrimaryExpression PrimaryExpression_397_Var
		 = (PrimaryExpression)Expr_396_list.get(0);
		Assert.assertNotNull(PrimaryExpression_397_Var
		);
		Assert.assertEquals("res", PrimaryExpression_397_Var
		.getId());
		Assert.assertEquals("return", JumpStatement_380_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_380_Var
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


