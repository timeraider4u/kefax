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
		Assert.assertEquals("[\"int $0x80\"]", PrimaryExpression_62_Var
		.getString().toString());
		final EList<? extends EObject> AsmLines_62_list = AsmStatement_47_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_62_list);
		Assert.assertEquals(3, AsmLines_62_list.size());
		//62
		final AsmLineWithColon AsmLineWithColon_63_Var
		 = (AsmLineWithColon)AsmLines_62_list.get(0);
		Assert.assertNotNull(AsmLineWithColon_63_Var
		);
		//63
		final AsmLineWithoutColon AsmLineWithoutColon_64_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_63_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_64_Var
		);
		//64
		final LogicalOrExpression LogicalOrExpression_65_Var
		 = (LogicalOrExpression)AsmLineWithoutColon_64_Var
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
		Assert.assertEquals("[\"=a\"]", PrimaryExpression_78_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_78_list = PostfixExpression_77_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_78_list);
		Assert.assertEquals(1, Suffix_78_list.size());
		//78
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_79_Var
		 = (PostfixExpressionSuffixArgument)Suffix_78_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_79_Var
		);
		//79
		final ArgumentExpressionList ArgumentExpressionList_80_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_79_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_80_Var
		);
		final EList<? extends EObject> Expr_80_list = ArgumentExpressionList_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final AssignmentExpression AssignmentExpression_81_Var
		 = (AssignmentExpression)Expr_80_list.get(0);
		Assert.assertNotNull(AssignmentExpression_81_Var
		);
		//81
		final ConditionalExpression ConditionalExpression_82_Var
		 = (ConditionalExpression)AssignmentExpression_81_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_82_Var
		);
		//82
		final LogicalOrExpression LogicalOrExpression_83_Var
		 = (LogicalOrExpression)ConditionalExpression_82_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = LogicalOrExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final LogicalAndExpression LogicalAndExpression_84_Var
		 = (LogicalAndExpression)Expr_83_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = LogicalAndExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final InclusiveOrExpression InclusiveOrExpression_85_Var
		 = (InclusiveOrExpression)Expr_84_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = InclusiveOrExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final ExclusiveOrExpression ExclusiveOrExpression_86_Var
		 = (ExclusiveOrExpression)Expr_85_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = ExclusiveOrExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final AndExpression AndExpression_87_Var
		 = (AndExpression)Expr_86_list.get(0);
		Assert.assertNotNull(AndExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = AndExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final EqualityExpression EqualityExpression_88_Var
		 = (EqualityExpression)Expr_87_list.get(0);
		Assert.assertNotNull(EqualityExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = EqualityExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final RelationalExpression RelationalExpression_89_Var
		 = (RelationalExpression)Expr_88_list.get(0);
		Assert.assertNotNull(RelationalExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = RelationalExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final ShiftExpression ShiftExpression_90_Var
		 = (ShiftExpression)Expr_89_list.get(0);
		Assert.assertNotNull(ShiftExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = ShiftExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final AdditiveExpression AdditiveExpression_91_Var
		 = (AdditiveExpression)Expr_90_list.get(0);
		Assert.assertNotNull(AdditiveExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = AdditiveExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final MultiplicativeExpression MultiplicativeExpression_92_Var
		 = (MultiplicativeExpression)Expr_91_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_92_Var
		);
		final EList<? extends EObject> Expr_92_list = MultiplicativeExpression_92_Var
		.getExpr();
		Assert.assertNotNull(Expr_92_list);
		Assert.assertEquals(1, Expr_92_list.size());
		//92
		final CastExpression CastExpression_93_Var
		 = (CastExpression)Expr_92_list.get(0);
		Assert.assertNotNull(CastExpression_93_Var
		);
		//93
		final UnaryExpression UnaryExpression_94_Var
		 = (UnaryExpression)CastExpression_93_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_94_Var
		);
		//94
		final PostfixExpression PostfixExpression_95_Var
		 = (PostfixExpression)UnaryExpression_94_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_95_Var
		);
		final EList<? extends EObject> Expr_95_list = PostfixExpression_95_Var
		.getExpr();
		Assert.assertNotNull(Expr_95_list);
		Assert.assertEquals(1, Expr_95_list.size());
		//95
		final PrimaryExpression PrimaryExpression_96_Var
		 = (PrimaryExpression)Expr_95_list.get(0);
		Assert.assertNotNull(PrimaryExpression_96_Var
		);
		Assert.assertEquals("res", PrimaryExpression_96_Var
		.getId());
		final EList<? extends EObject> AsmLines_96_list = AsmLineWithoutColon_64_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_96_list);
		Assert.assertEquals(3, AsmLines_96_list.size());
		//96
		final AsmLine AsmLine_97_Var
		 = (AsmLine)AsmLines_96_list.get(0);
		Assert.assertNotNull(AsmLine_97_Var
		);
		Assert.assertTrue(AsmLine_97_Var
		.isComma());
		//97
		final LogicalOrExpression LogicalOrExpression_98_Var
		 = (LogicalOrExpression)AsmLine_97_Var
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
		Assert.assertEquals("[\"+b\"]", PrimaryExpression_111_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_111_list = PostfixExpression_110_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_111_list);
		Assert.assertEquals(1, Suffix_111_list.size());
		//111
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_112_Var
		 = (PostfixExpressionSuffixArgument)Suffix_111_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_112_Var
		);
		//112
		final ArgumentExpressionList ArgumentExpressionList_113_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_112_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_113_Var
		);
		final EList<? extends EObject> Expr_113_list = ArgumentExpressionList_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final AssignmentExpression AssignmentExpression_114_Var
		 = (AssignmentExpression)Expr_113_list.get(0);
		Assert.assertNotNull(AssignmentExpression_114_Var
		);
		//114
		final ConditionalExpression ConditionalExpression_115_Var
		 = (ConditionalExpression)AssignmentExpression_114_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_115_Var
		);
		//115
		final LogicalOrExpression LogicalOrExpression_116_Var
		 = (LogicalOrExpression)ConditionalExpression_115_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = LogicalOrExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final LogicalAndExpression LogicalAndExpression_117_Var
		 = (LogicalAndExpression)Expr_116_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = LogicalAndExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final InclusiveOrExpression InclusiveOrExpression_118_Var
		 = (InclusiveOrExpression)Expr_117_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = InclusiveOrExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final ExclusiveOrExpression ExclusiveOrExpression_119_Var
		 = (ExclusiveOrExpression)Expr_118_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = ExclusiveOrExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final AndExpression AndExpression_120_Var
		 = (AndExpression)Expr_119_list.get(0);
		Assert.assertNotNull(AndExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = AndExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final EqualityExpression EqualityExpression_121_Var
		 = (EqualityExpression)Expr_120_list.get(0);
		Assert.assertNotNull(EqualityExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = EqualityExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final RelationalExpression RelationalExpression_122_Var
		 = (RelationalExpression)Expr_121_list.get(0);
		Assert.assertNotNull(RelationalExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = RelationalExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final ShiftExpression ShiftExpression_123_Var
		 = (ShiftExpression)Expr_122_list.get(0);
		Assert.assertNotNull(ShiftExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = ShiftExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final AdditiveExpression AdditiveExpression_124_Var
		 = (AdditiveExpression)Expr_123_list.get(0);
		Assert.assertNotNull(AdditiveExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = AdditiveExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final MultiplicativeExpression MultiplicativeExpression_125_Var
		 = (MultiplicativeExpression)Expr_124_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = MultiplicativeExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final CastExpression CastExpression_126_Var
		 = (CastExpression)Expr_125_list.get(0);
		Assert.assertNotNull(CastExpression_126_Var
		);
		//126
		final UnaryExpression UnaryExpression_127_Var
		 = (UnaryExpression)CastExpression_126_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_127_Var
		);
		//127
		final PostfixExpression PostfixExpression_128_Var
		 = (PostfixExpression)UnaryExpression_127_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = PostfixExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final PrimaryExpression PrimaryExpression_129_Var
		 = (PrimaryExpression)Expr_128_list.get(0);
		Assert.assertNotNull(PrimaryExpression_129_Var
		);
		Assert.assertEquals("arg1", PrimaryExpression_129_Var
		.getId());
		//129
		final AsmLine AsmLine_130_Var
		 = (AsmLine)AsmLines_96_list.get(1);
		Assert.assertNotNull(AsmLine_130_Var
		);
		Assert.assertTrue(AsmLine_130_Var
		.isComma());
		//130
		final LogicalOrExpression LogicalOrExpression_131_Var
		 = (LogicalOrExpression)AsmLine_130_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = LogicalOrExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final LogicalAndExpression LogicalAndExpression_132_Var
		 = (LogicalAndExpression)Expr_131_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = LogicalAndExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final InclusiveOrExpression InclusiveOrExpression_133_Var
		 = (InclusiveOrExpression)Expr_132_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = InclusiveOrExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final ExclusiveOrExpression ExclusiveOrExpression_134_Var
		 = (ExclusiveOrExpression)Expr_133_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = ExclusiveOrExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final AndExpression AndExpression_135_Var
		 = (AndExpression)Expr_134_list.get(0);
		Assert.assertNotNull(AndExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = AndExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final EqualityExpression EqualityExpression_136_Var
		 = (EqualityExpression)Expr_135_list.get(0);
		Assert.assertNotNull(EqualityExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = EqualityExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final RelationalExpression RelationalExpression_137_Var
		 = (RelationalExpression)Expr_136_list.get(0);
		Assert.assertNotNull(RelationalExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = RelationalExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final ShiftExpression ShiftExpression_138_Var
		 = (ShiftExpression)Expr_137_list.get(0);
		Assert.assertNotNull(ShiftExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = ShiftExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final AdditiveExpression AdditiveExpression_139_Var
		 = (AdditiveExpression)Expr_138_list.get(0);
		Assert.assertNotNull(AdditiveExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = AdditiveExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final MultiplicativeExpression MultiplicativeExpression_140_Var
		 = (MultiplicativeExpression)Expr_139_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = MultiplicativeExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final CastExpression CastExpression_141_Var
		 = (CastExpression)Expr_140_list.get(0);
		Assert.assertNotNull(CastExpression_141_Var
		);
		//141
		final UnaryExpression UnaryExpression_142_Var
		 = (UnaryExpression)CastExpression_141_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_142_Var
		);
		//142
		final PostfixExpression PostfixExpression_143_Var
		 = (PostfixExpression)UnaryExpression_142_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_143_Var
		);
		final EList<? extends EObject> Expr_143_list = PostfixExpression_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final PrimaryExpression PrimaryExpression_144_Var
		 = (PrimaryExpression)Expr_143_list.get(0);
		Assert.assertNotNull(PrimaryExpression_144_Var
		);
		Assert.assertEquals("[\"+c\"]", PrimaryExpression_144_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_144_list = PostfixExpression_143_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_144_list);
		Assert.assertEquals(1, Suffix_144_list.size());
		//144
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_145_Var
		 = (PostfixExpressionSuffixArgument)Suffix_144_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_145_Var
		);
		//145
		final ArgumentExpressionList ArgumentExpressionList_146_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_145_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_146_Var
		);
		final EList<? extends EObject> Expr_146_list = ArgumentExpressionList_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final AssignmentExpression AssignmentExpression_147_Var
		 = (AssignmentExpression)Expr_146_list.get(0);
		Assert.assertNotNull(AssignmentExpression_147_Var
		);
		//147
		final ConditionalExpression ConditionalExpression_148_Var
		 = (ConditionalExpression)AssignmentExpression_147_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_148_Var
		);
		//148
		final LogicalOrExpression LogicalOrExpression_149_Var
		 = (LogicalOrExpression)ConditionalExpression_148_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_149_Var
		);
		final EList<? extends EObject> Expr_149_list = LogicalOrExpression_149_Var
		.getExpr();
		Assert.assertNotNull(Expr_149_list);
		Assert.assertEquals(1, Expr_149_list.size());
		//149
		final LogicalAndExpression LogicalAndExpression_150_Var
		 = (LogicalAndExpression)Expr_149_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_150_Var
		);
		final EList<? extends EObject> Expr_150_list = LogicalAndExpression_150_Var
		.getExpr();
		Assert.assertNotNull(Expr_150_list);
		Assert.assertEquals(1, Expr_150_list.size());
		//150
		final InclusiveOrExpression InclusiveOrExpression_151_Var
		 = (InclusiveOrExpression)Expr_150_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_151_Var
		);
		final EList<? extends EObject> Expr_151_list = InclusiveOrExpression_151_Var
		.getExpr();
		Assert.assertNotNull(Expr_151_list);
		Assert.assertEquals(1, Expr_151_list.size());
		//151
		final ExclusiveOrExpression ExclusiveOrExpression_152_Var
		 = (ExclusiveOrExpression)Expr_151_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_152_Var
		);
		final EList<? extends EObject> Expr_152_list = ExclusiveOrExpression_152_Var
		.getExpr();
		Assert.assertNotNull(Expr_152_list);
		Assert.assertEquals(1, Expr_152_list.size());
		//152
		final AndExpression AndExpression_153_Var
		 = (AndExpression)Expr_152_list.get(0);
		Assert.assertNotNull(AndExpression_153_Var
		);
		final EList<? extends EObject> Expr_153_list = AndExpression_153_Var
		.getExpr();
		Assert.assertNotNull(Expr_153_list);
		Assert.assertEquals(1, Expr_153_list.size());
		//153
		final EqualityExpression EqualityExpression_154_Var
		 = (EqualityExpression)Expr_153_list.get(0);
		Assert.assertNotNull(EqualityExpression_154_Var
		);
		final EList<? extends EObject> Expr_154_list = EqualityExpression_154_Var
		.getExpr();
		Assert.assertNotNull(Expr_154_list);
		Assert.assertEquals(1, Expr_154_list.size());
		//154
		final RelationalExpression RelationalExpression_155_Var
		 = (RelationalExpression)Expr_154_list.get(0);
		Assert.assertNotNull(RelationalExpression_155_Var
		);
		final EList<? extends EObject> Expr_155_list = RelationalExpression_155_Var
		.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		//155
		final ShiftExpression ShiftExpression_156_Var
		 = (ShiftExpression)Expr_155_list.get(0);
		Assert.assertNotNull(ShiftExpression_156_Var
		);
		final EList<? extends EObject> Expr_156_list = ShiftExpression_156_Var
		.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		//156
		final AdditiveExpression AdditiveExpression_157_Var
		 = (AdditiveExpression)Expr_156_list.get(0);
		Assert.assertNotNull(AdditiveExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = AdditiveExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final MultiplicativeExpression MultiplicativeExpression_158_Var
		 = (MultiplicativeExpression)Expr_157_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = MultiplicativeExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final CastExpression CastExpression_159_Var
		 = (CastExpression)Expr_158_list.get(0);
		Assert.assertNotNull(CastExpression_159_Var
		);
		//159
		final UnaryExpression UnaryExpression_160_Var
		 = (UnaryExpression)CastExpression_159_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_160_Var
		);
		//160
		final PostfixExpression PostfixExpression_161_Var
		 = (PostfixExpression)UnaryExpression_160_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = PostfixExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final PrimaryExpression PrimaryExpression_162_Var
		 = (PrimaryExpression)Expr_161_list.get(0);
		Assert.assertNotNull(PrimaryExpression_162_Var
		);
		Assert.assertEquals("arg2", PrimaryExpression_162_Var
		.getId());
		//162
		final AsmLine AsmLine_163_Var
		 = (AsmLine)AsmLines_96_list.get(2);
		Assert.assertNotNull(AsmLine_163_Var
		);
		Assert.assertTrue(AsmLine_163_Var
		.isComma());
		//163
		final LogicalOrExpression LogicalOrExpression_164_Var
		 = (LogicalOrExpression)AsmLine_163_Var
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
		Assert.assertEquals("[\"+d\"]", PrimaryExpression_177_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_177_list = PostfixExpression_176_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_177_list);
		Assert.assertEquals(1, Suffix_177_list.size());
		//177
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_178_Var
		 = (PostfixExpressionSuffixArgument)Suffix_177_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_178_Var
		);
		//178
		final ArgumentExpressionList ArgumentExpressionList_179_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_178_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_179_Var
		);
		final EList<? extends EObject> Expr_179_list = ArgumentExpressionList_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final AssignmentExpression AssignmentExpression_180_Var
		 = (AssignmentExpression)Expr_179_list.get(0);
		Assert.assertNotNull(AssignmentExpression_180_Var
		);
		//180
		final ConditionalExpression ConditionalExpression_181_Var
		 = (ConditionalExpression)AssignmentExpression_180_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_181_Var
		);
		//181
		final LogicalOrExpression LogicalOrExpression_182_Var
		 = (LogicalOrExpression)ConditionalExpression_181_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_182_Var
		);
		final EList<? extends EObject> Expr_182_list = LogicalOrExpression_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(1, Expr_182_list.size());
		//182
		final LogicalAndExpression LogicalAndExpression_183_Var
		 = (LogicalAndExpression)Expr_182_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = LogicalAndExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final InclusiveOrExpression InclusiveOrExpression_184_Var
		 = (InclusiveOrExpression)Expr_183_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = InclusiveOrExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final ExclusiveOrExpression ExclusiveOrExpression_185_Var
		 = (ExclusiveOrExpression)Expr_184_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_185_Var
		);
		final EList<? extends EObject> Expr_185_list = ExclusiveOrExpression_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final AndExpression AndExpression_186_Var
		 = (AndExpression)Expr_185_list.get(0);
		Assert.assertNotNull(AndExpression_186_Var
		);
		final EList<? extends EObject> Expr_186_list = AndExpression_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(1, Expr_186_list.size());
		//186
		final EqualityExpression EqualityExpression_187_Var
		 = (EqualityExpression)Expr_186_list.get(0);
		Assert.assertNotNull(EqualityExpression_187_Var
		);
		final EList<? extends EObject> Expr_187_list = EqualityExpression_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(1, Expr_187_list.size());
		//187
		final RelationalExpression RelationalExpression_188_Var
		 = (RelationalExpression)Expr_187_list.get(0);
		Assert.assertNotNull(RelationalExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = RelationalExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final ShiftExpression ShiftExpression_189_Var
		 = (ShiftExpression)Expr_188_list.get(0);
		Assert.assertNotNull(ShiftExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = ShiftExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final AdditiveExpression AdditiveExpression_190_Var
		 = (AdditiveExpression)Expr_189_list.get(0);
		Assert.assertNotNull(AdditiveExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = AdditiveExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final MultiplicativeExpression MultiplicativeExpression_191_Var
		 = (MultiplicativeExpression)Expr_190_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = MultiplicativeExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final CastExpression CastExpression_192_Var
		 = (CastExpression)Expr_191_list.get(0);
		Assert.assertNotNull(CastExpression_192_Var
		);
		//192
		final UnaryExpression UnaryExpression_193_Var
		 = (UnaryExpression)CastExpression_192_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_193_Var
		);
		//193
		final PostfixExpression PostfixExpression_194_Var
		 = (PostfixExpression)UnaryExpression_193_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = PostfixExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final PrimaryExpression PrimaryExpression_195_Var
		 = (PrimaryExpression)Expr_194_list.get(0);
		Assert.assertNotNull(PrimaryExpression_195_Var
		);
		Assert.assertEquals("arg3", PrimaryExpression_195_Var
		.getId());
		//195
		final AsmLineWithColon AsmLineWithColon_196_Var
		 = (AsmLineWithColon)AsmLines_62_list.get(1);
		Assert.assertNotNull(AsmLineWithColon_196_Var
		);
		//196
		final AsmLineWithoutColon AsmLineWithoutColon_197_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_196_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_197_Var
		);
		//197
		final LogicalOrExpression LogicalOrExpression_198_Var
		 = (LogicalOrExpression)AsmLineWithoutColon_197_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = LogicalOrExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final LogicalAndExpression LogicalAndExpression_199_Var
		 = (LogicalAndExpression)Expr_198_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = LogicalAndExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final InclusiveOrExpression InclusiveOrExpression_200_Var
		 = (InclusiveOrExpression)Expr_199_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = InclusiveOrExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final ExclusiveOrExpression ExclusiveOrExpression_201_Var
		 = (ExclusiveOrExpression)Expr_200_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = ExclusiveOrExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final AndExpression AndExpression_202_Var
		 = (AndExpression)Expr_201_list.get(0);
		Assert.assertNotNull(AndExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = AndExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final EqualityExpression EqualityExpression_203_Var
		 = (EqualityExpression)Expr_202_list.get(0);
		Assert.assertNotNull(EqualityExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = EqualityExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final RelationalExpression RelationalExpression_204_Var
		 = (RelationalExpression)Expr_203_list.get(0);
		Assert.assertNotNull(RelationalExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = RelationalExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final ShiftExpression ShiftExpression_205_Var
		 = (ShiftExpression)Expr_204_list.get(0);
		Assert.assertNotNull(ShiftExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = ShiftExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final AdditiveExpression AdditiveExpression_206_Var
		 = (AdditiveExpression)Expr_205_list.get(0);
		Assert.assertNotNull(AdditiveExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = AdditiveExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final MultiplicativeExpression MultiplicativeExpression_207_Var
		 = (MultiplicativeExpression)Expr_206_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = MultiplicativeExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final CastExpression CastExpression_208_Var
		 = (CastExpression)Expr_207_list.get(0);
		Assert.assertNotNull(CastExpression_208_Var
		);
		//208
		final UnaryExpression UnaryExpression_209_Var
		 = (UnaryExpression)CastExpression_208_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_209_Var
		);
		//209
		final PostfixExpression PostfixExpression_210_Var
		 = (PostfixExpression)UnaryExpression_209_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = PostfixExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final PrimaryExpression PrimaryExpression_211_Var
		 = (PrimaryExpression)Expr_210_list.get(0);
		Assert.assertNotNull(PrimaryExpression_211_Var
		);
		Assert.assertEquals("[\"a\"]", PrimaryExpression_211_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_211_list = PostfixExpression_210_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_211_list);
		Assert.assertEquals(1, Suffix_211_list.size());
		//211
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_212_Var
		 = (PostfixExpressionSuffixArgument)Suffix_211_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_212_Var
		);
		//212
		final ArgumentExpressionList ArgumentExpressionList_213_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_212_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_213_Var
		);
		final EList<? extends EObject> Expr_213_list = ArgumentExpressionList_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final AssignmentExpression AssignmentExpression_214_Var
		 = (AssignmentExpression)Expr_213_list.get(0);
		Assert.assertNotNull(AssignmentExpression_214_Var
		);
		//214
		final ConditionalExpression ConditionalExpression_215_Var
		 = (ConditionalExpression)AssignmentExpression_214_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_215_Var
		);
		//215
		final LogicalOrExpression LogicalOrExpression_216_Var
		 = (LogicalOrExpression)ConditionalExpression_215_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = LogicalOrExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final LogicalAndExpression LogicalAndExpression_217_Var
		 = (LogicalAndExpression)Expr_216_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = LogicalAndExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final InclusiveOrExpression InclusiveOrExpression_218_Var
		 = (InclusiveOrExpression)Expr_217_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = InclusiveOrExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final ExclusiveOrExpression ExclusiveOrExpression_219_Var
		 = (ExclusiveOrExpression)Expr_218_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = ExclusiveOrExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final AndExpression AndExpression_220_Var
		 = (AndExpression)Expr_219_list.get(0);
		Assert.assertNotNull(AndExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = AndExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final EqualityExpression EqualityExpression_221_Var
		 = (EqualityExpression)Expr_220_list.get(0);
		Assert.assertNotNull(EqualityExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = EqualityExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final RelationalExpression RelationalExpression_222_Var
		 = (RelationalExpression)Expr_221_list.get(0);
		Assert.assertNotNull(RelationalExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = RelationalExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final ShiftExpression ShiftExpression_223_Var
		 = (ShiftExpression)Expr_222_list.get(0);
		Assert.assertNotNull(ShiftExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = ShiftExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final AdditiveExpression AdditiveExpression_224_Var
		 = (AdditiveExpression)Expr_223_list.get(0);
		Assert.assertNotNull(AdditiveExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = AdditiveExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final MultiplicativeExpression MultiplicativeExpression_225_Var
		 = (MultiplicativeExpression)Expr_224_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = MultiplicativeExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final CastExpression CastExpression_226_Var
		 = (CastExpression)Expr_225_list.get(0);
		Assert.assertNotNull(CastExpression_226_Var
		);
		//226
		final UnaryExpression UnaryExpression_227_Var
		 = (UnaryExpression)CastExpression_226_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_227_Var
		);
		//227
		final PostfixExpression PostfixExpression_228_Var
		 = (PostfixExpression)UnaryExpression_227_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = PostfixExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final PrimaryExpression PrimaryExpression_229_Var
		 = (PrimaryExpression)Expr_228_list.get(0);
		Assert.assertNotNull(PrimaryExpression_229_Var
		);
		//229
		final Constant2 Constant2_230_Var
		 = (Constant2)PrimaryExpression_229_Var
		.getConst();
		Assert.assertNotNull(Constant2_230_Var
		);
		Assert.assertEquals("128", Constant2_230_Var
		.getDec());
		//230
		final AsmLineWithColon AsmLineWithColon_231_Var
		 = (AsmLineWithColon)AsmLines_62_list.get(2);
		Assert.assertNotNull(AsmLineWithColon_231_Var
		);
		//231
		final AsmLineWithoutColon AsmLineWithoutColon_232_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_231_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_232_Var
		);
		//232
		final LogicalOrExpression LogicalOrExpression_233_Var
		 = (LogicalOrExpression)AsmLineWithoutColon_232_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = LogicalOrExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final LogicalAndExpression LogicalAndExpression_234_Var
		 = (LogicalAndExpression)Expr_233_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = LogicalAndExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final InclusiveOrExpression InclusiveOrExpression_235_Var
		 = (InclusiveOrExpression)Expr_234_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = InclusiveOrExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final ExclusiveOrExpression ExclusiveOrExpression_236_Var
		 = (ExclusiveOrExpression)Expr_235_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = ExclusiveOrExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final AndExpression AndExpression_237_Var
		 = (AndExpression)Expr_236_list.get(0);
		Assert.assertNotNull(AndExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = AndExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final EqualityExpression EqualityExpression_238_Var
		 = (EqualityExpression)Expr_237_list.get(0);
		Assert.assertNotNull(EqualityExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = EqualityExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final RelationalExpression RelationalExpression_239_Var
		 = (RelationalExpression)Expr_238_list.get(0);
		Assert.assertNotNull(RelationalExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = RelationalExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final ShiftExpression ShiftExpression_240_Var
		 = (ShiftExpression)Expr_239_list.get(0);
		Assert.assertNotNull(ShiftExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = ShiftExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final AdditiveExpression AdditiveExpression_241_Var
		 = (AdditiveExpression)Expr_240_list.get(0);
		Assert.assertNotNull(AdditiveExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = AdditiveExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final MultiplicativeExpression MultiplicativeExpression_242_Var
		 = (MultiplicativeExpression)Expr_241_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = MultiplicativeExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final CastExpression CastExpression_243_Var
		 = (CastExpression)Expr_242_list.get(0);
		Assert.assertNotNull(CastExpression_243_Var
		);
		//243
		final UnaryExpression UnaryExpression_244_Var
		 = (UnaryExpression)CastExpression_243_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_244_Var
		);
		//244
		final PostfixExpression PostfixExpression_245_Var
		 = (PostfixExpression)UnaryExpression_244_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = PostfixExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final PrimaryExpression PrimaryExpression_246_Var
		 = (PrimaryExpression)Expr_245_list.get(0);
		Assert.assertNotNull(PrimaryExpression_246_Var
		);
		Assert.assertEquals("[\"memory\"]", PrimaryExpression_246_Var
		.getString().toString());
		final EList<? extends EObject> AsmLines_246_list = AsmLineWithoutColon_232_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_246_list);
		Assert.assertEquals(1, AsmLines_246_list.size());
		//246
		final AsmLine AsmLine_247_Var
		 = (AsmLine)AsmLines_246_list.get(0);
		Assert.assertNotNull(AsmLine_247_Var
		);
		Assert.assertTrue(AsmLine_247_Var
		.isComma());
		//247
		final LogicalOrExpression LogicalOrExpression_248_Var
		 = (LogicalOrExpression)AsmLine_247_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = LogicalOrExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final LogicalAndExpression LogicalAndExpression_249_Var
		 = (LogicalAndExpression)Expr_248_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = LogicalAndExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final InclusiveOrExpression InclusiveOrExpression_250_Var
		 = (InclusiveOrExpression)Expr_249_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = InclusiveOrExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final ExclusiveOrExpression ExclusiveOrExpression_251_Var
		 = (ExclusiveOrExpression)Expr_250_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = ExclusiveOrExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final AndExpression AndExpression_252_Var
		 = (AndExpression)Expr_251_list.get(0);
		Assert.assertNotNull(AndExpression_252_Var
		);
		final EList<? extends EObject> Expr_252_list = AndExpression_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(1, Expr_252_list.size());
		//252
		final EqualityExpression EqualityExpression_253_Var
		 = (EqualityExpression)Expr_252_list.get(0);
		Assert.assertNotNull(EqualityExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = EqualityExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final RelationalExpression RelationalExpression_254_Var
		 = (RelationalExpression)Expr_253_list.get(0);
		Assert.assertNotNull(RelationalExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = RelationalExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final ShiftExpression ShiftExpression_255_Var
		 = (ShiftExpression)Expr_254_list.get(0);
		Assert.assertNotNull(ShiftExpression_255_Var
		);
		final EList<? extends EObject> Expr_255_list = ShiftExpression_255_Var
		.getExpr();
		Assert.assertNotNull(Expr_255_list);
		Assert.assertEquals(1, Expr_255_list.size());
		//255
		final AdditiveExpression AdditiveExpression_256_Var
		 = (AdditiveExpression)Expr_255_list.get(0);
		Assert.assertNotNull(AdditiveExpression_256_Var
		);
		final EList<? extends EObject> Expr_256_list = AdditiveExpression_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(1, Expr_256_list.size());
		//256
		final MultiplicativeExpression MultiplicativeExpression_257_Var
		 = (MultiplicativeExpression)Expr_256_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = MultiplicativeExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final CastExpression CastExpression_258_Var
		 = (CastExpression)Expr_257_list.get(0);
		Assert.assertNotNull(CastExpression_258_Var
		);
		//258
		final UnaryExpression UnaryExpression_259_Var
		 = (UnaryExpression)CastExpression_258_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_259_Var
		);
		//259
		final PostfixExpression PostfixExpression_260_Var
		 = (PostfixExpression)UnaryExpression_259_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = PostfixExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final PrimaryExpression PrimaryExpression_261_Var
		 = (PrimaryExpression)Expr_260_list.get(0);
		Assert.assertNotNull(PrimaryExpression_261_Var
		);
		Assert.assertEquals("[\"cc\"]", PrimaryExpression_261_Var
		.getString().toString());
		Assert.assertEquals(";", AsmStatement_47_Var
		.getSemi());
		//261
		final Statement Statement_262_Var
		 = (Statement)Statement_45_list.get(1);
		Assert.assertNotNull(Statement_262_Var
		);
		//262
		final SelectionStatement SelectionStatement_263_Var
		 = (SelectionStatement)Statement_262_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_263_Var
		);
		Assert.assertEquals("if", SelectionStatement_263_Var
		.getIf());
		//263
		final Expression Expression_264_Var
		 = (Expression)SelectionStatement_263_Var
		.getExpr();
		Assert.assertNotNull(Expression_264_Var
		);
		final EList<? extends EObject> ExprExpr_264_list = Expression_264_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_264_list);
		Assert.assertEquals(1, ExprExpr_264_list.size());
		//264
		final AssignmentExpression AssignmentExpression_265_Var
		 = (AssignmentExpression)ExprExpr_264_list.get(0);
		Assert.assertNotNull(AssignmentExpression_265_Var
		);
		//265
		final ConditionalExpression ConditionalExpression_266_Var
		 = (ConditionalExpression)AssignmentExpression_265_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_266_Var
		);
		//266
		final LogicalOrExpression LogicalOrExpression_267_Var
		 = (LogicalOrExpression)ConditionalExpression_266_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_267_Var
		);
		final EList<? extends EObject> Expr_267_list = LogicalOrExpression_267_Var
		.getExpr();
		Assert.assertNotNull(Expr_267_list);
		Assert.assertEquals(1, Expr_267_list.size());
		//267
		final LogicalAndExpression LogicalAndExpression_268_Var
		 = (LogicalAndExpression)Expr_267_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_268_Var
		);
		final EList<? extends EObject> Expr_268_list = LogicalAndExpression_268_Var
		.getExpr();
		Assert.assertNotNull(Expr_268_list);
		Assert.assertEquals(2, Expr_268_list.size());
		//268
		final InclusiveOrExpression InclusiveOrExpression_269_Var
		 = (InclusiveOrExpression)Expr_268_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_269_Var
		);
		final EList<? extends EObject> Expr_269_list = InclusiveOrExpression_269_Var
		.getExpr();
		Assert.assertNotNull(Expr_269_list);
		Assert.assertEquals(1, Expr_269_list.size());
		//269
		final ExclusiveOrExpression ExclusiveOrExpression_270_Var
		 = (ExclusiveOrExpression)Expr_269_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_270_Var
		);
		final EList<? extends EObject> Expr_270_list = ExclusiveOrExpression_270_Var
		.getExpr();
		Assert.assertNotNull(Expr_270_list);
		Assert.assertEquals(1, Expr_270_list.size());
		//270
		final AndExpression AndExpression_271_Var
		 = (AndExpression)Expr_270_list.get(0);
		Assert.assertNotNull(AndExpression_271_Var
		);
		final EList<? extends EObject> Expr_271_list = AndExpression_271_Var
		.getExpr();
		Assert.assertNotNull(Expr_271_list);
		Assert.assertEquals(1, Expr_271_list.size());
		//271
		final EqualityExpression EqualityExpression_272_Var
		 = (EqualityExpression)Expr_271_list.get(0);
		Assert.assertNotNull(EqualityExpression_272_Var
		);
		final EList<? extends EObject> Expr_272_list = EqualityExpression_272_Var
		.getExpr();
		Assert.assertNotNull(Expr_272_list);
		Assert.assertEquals(1, Expr_272_list.size());
		//272
		final RelationalExpression RelationalExpression_273_Var
		 = (RelationalExpression)Expr_272_list.get(0);
		Assert.assertNotNull(RelationalExpression_273_Var
		);
		Assert.assertEquals("[<=]", RelationalExpression_273_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_273_list = RelationalExpression_273_Var
		.getExpr();
		Assert.assertNotNull(Expr_273_list);
		Assert.assertEquals(2, Expr_273_list.size());
		//273
		final ShiftExpression ShiftExpression_274_Var
		 = (ShiftExpression)Expr_273_list.get(0);
		Assert.assertNotNull(ShiftExpression_274_Var
		);
		final EList<? extends EObject> Expr_274_list = ShiftExpression_274_Var
		.getExpr();
		Assert.assertNotNull(Expr_274_list);
		Assert.assertEquals(1, Expr_274_list.size());
		//274
		final AdditiveExpression AdditiveExpression_275_Var
		 = (AdditiveExpression)Expr_274_list.get(0);
		Assert.assertNotNull(AdditiveExpression_275_Var
		);
		final EList<? extends EObject> Expr_275_list = AdditiveExpression_275_Var
		.getExpr();
		Assert.assertNotNull(Expr_275_list);
		Assert.assertEquals(1, Expr_275_list.size());
		//275
		final MultiplicativeExpression MultiplicativeExpression_276_Var
		 = (MultiplicativeExpression)Expr_275_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_276_Var
		);
		final EList<? extends EObject> Expr_276_list = MultiplicativeExpression_276_Var
		.getExpr();
		Assert.assertNotNull(Expr_276_list);
		Assert.assertEquals(1, Expr_276_list.size());
		//276
		final CastExpression CastExpression_277_Var
		 = (CastExpression)Expr_276_list.get(0);
		Assert.assertNotNull(CastExpression_277_Var
		);
		//277
		final UnaryExpression UnaryExpression_278_Var
		 = (UnaryExpression)CastExpression_277_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_278_Var
		);
		//278
		final CastExpression CastExpression_279_Var
		 = (CastExpression)UnaryExpression_278_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_279_Var
		);
		//279
		final UnaryExpression UnaryExpression_280_Var
		 = (UnaryExpression)CastExpression_279_Var
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
		//282
		final Constant2 Constant2_283_Var
		 = (Constant2)PrimaryExpression_282_Var
		.getConst();
		Assert.assertNotNull(Constant2_283_Var
		);
		Assert.assertEquals("125", Constant2_283_Var
		.getDec());
		//283
		final UnaryOperator UnaryOperator_284_Var
		 = (UnaryOperator)UnaryExpression_278_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_284_Var
		);
		Assert.assertEquals("-", UnaryOperator_284_Var
		.getOp());
		//284
		final ShiftExpression ShiftExpression_285_Var
		 = (ShiftExpression)Expr_273_list.get(1);
		Assert.assertNotNull(ShiftExpression_285_Var
		);
		final EList<? extends EObject> Expr_285_list = ShiftExpression_285_Var
		.getExpr();
		Assert.assertNotNull(Expr_285_list);
		Assert.assertEquals(1, Expr_285_list.size());
		//285
		final AdditiveExpression AdditiveExpression_286_Var
		 = (AdditiveExpression)Expr_285_list.get(0);
		Assert.assertNotNull(AdditiveExpression_286_Var
		);
		final EList<? extends EObject> Expr_286_list = AdditiveExpression_286_Var
		.getExpr();
		Assert.assertNotNull(Expr_286_list);
		Assert.assertEquals(1, Expr_286_list.size());
		//286
		final MultiplicativeExpression MultiplicativeExpression_287_Var
		 = (MultiplicativeExpression)Expr_286_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_287_Var
		);
		final EList<? extends EObject> Expr_287_list = MultiplicativeExpression_287_Var
		.getExpr();
		Assert.assertNotNull(Expr_287_list);
		Assert.assertEquals(1, Expr_287_list.size());
		//287
		final CastExpression CastExpression_288_Var
		 = (CastExpression)Expr_287_list.get(0);
		Assert.assertNotNull(CastExpression_288_Var
		);
		//288
		final UnaryExpression UnaryExpression_289_Var
		 = (UnaryExpression)CastExpression_288_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_289_Var
		);
		//289
		final PostfixExpression PostfixExpression_290_Var
		 = (PostfixExpression)UnaryExpression_289_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_290_Var
		);
		final EList<? extends EObject> Expr_290_list = PostfixExpression_290_Var
		.getExpr();
		Assert.assertNotNull(Expr_290_list);
		Assert.assertEquals(1, Expr_290_list.size());
		//290
		final PrimaryExpression PrimaryExpression_291_Var
		 = (PrimaryExpression)Expr_290_list.get(0);
		Assert.assertNotNull(PrimaryExpression_291_Var
		);
		Assert.assertEquals("res", PrimaryExpression_291_Var
		.getId());
		//291
		final InclusiveOrExpression InclusiveOrExpression_292_Var
		 = (InclusiveOrExpression)Expr_268_list.get(1);
		Assert.assertNotNull(InclusiveOrExpression_292_Var
		);
		final EList<? extends EObject> Expr_292_list = InclusiveOrExpression_292_Var
		.getExpr();
		Assert.assertNotNull(Expr_292_list);
		Assert.assertEquals(1, Expr_292_list.size());
		//292
		final ExclusiveOrExpression ExclusiveOrExpression_293_Var
		 = (ExclusiveOrExpression)Expr_292_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = ExclusiveOrExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final AndExpression AndExpression_294_Var
		 = (AndExpression)Expr_293_list.get(0);
		Assert.assertNotNull(AndExpression_294_Var
		);
		final EList<? extends EObject> Expr_294_list = AndExpression_294_Var
		.getExpr();
		Assert.assertNotNull(Expr_294_list);
		Assert.assertEquals(1, Expr_294_list.size());
		//294
		final EqualityExpression EqualityExpression_295_Var
		 = (EqualityExpression)Expr_294_list.get(0);
		Assert.assertNotNull(EqualityExpression_295_Var
		);
		final EList<? extends EObject> Expr_295_list = EqualityExpression_295_Var
		.getExpr();
		Assert.assertNotNull(Expr_295_list);
		Assert.assertEquals(1, Expr_295_list.size());
		//295
		final RelationalExpression RelationalExpression_296_Var
		 = (RelationalExpression)Expr_295_list.get(0);
		Assert.assertNotNull(RelationalExpression_296_Var
		);
		Assert.assertEquals("[<]", RelationalExpression_296_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_296_list = RelationalExpression_296_Var
		.getExpr();
		Assert.assertNotNull(Expr_296_list);
		Assert.assertEquals(2, Expr_296_list.size());
		//296
		final ShiftExpression ShiftExpression_297_Var
		 = (ShiftExpression)Expr_296_list.get(0);
		Assert.assertNotNull(ShiftExpression_297_Var
		);
		final EList<? extends EObject> Expr_297_list = ShiftExpression_297_Var
		.getExpr();
		Assert.assertNotNull(Expr_297_list);
		Assert.assertEquals(1, Expr_297_list.size());
		//297
		final AdditiveExpression AdditiveExpression_298_Var
		 = (AdditiveExpression)Expr_297_list.get(0);
		Assert.assertNotNull(AdditiveExpression_298_Var
		);
		final EList<? extends EObject> Expr_298_list = AdditiveExpression_298_Var
		.getExpr();
		Assert.assertNotNull(Expr_298_list);
		Assert.assertEquals(1, Expr_298_list.size());
		//298
		final MultiplicativeExpression MultiplicativeExpression_299_Var
		 = (MultiplicativeExpression)Expr_298_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_299_Var
		);
		final EList<? extends EObject> Expr_299_list = MultiplicativeExpression_299_Var
		.getExpr();
		Assert.assertNotNull(Expr_299_list);
		Assert.assertEquals(1, Expr_299_list.size());
		//299
		final CastExpression CastExpression_300_Var
		 = (CastExpression)Expr_299_list.get(0);
		Assert.assertNotNull(CastExpression_300_Var
		);
		//300
		final UnaryExpression UnaryExpression_301_Var
		 = (UnaryExpression)CastExpression_300_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_301_Var
		);
		//301
		final PostfixExpression PostfixExpression_302_Var
		 = (PostfixExpression)UnaryExpression_301_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_302_Var
		);
		final EList<? extends EObject> Expr_302_list = PostfixExpression_302_Var
		.getExpr();
		Assert.assertNotNull(Expr_302_list);
		Assert.assertEquals(1, Expr_302_list.size());
		//302
		final PrimaryExpression PrimaryExpression_303_Var
		 = (PrimaryExpression)Expr_302_list.get(0);
		Assert.assertNotNull(PrimaryExpression_303_Var
		);
		Assert.assertEquals("res", PrimaryExpression_303_Var
		.getId());
		//303
		final ShiftExpression ShiftExpression_304_Var
		 = (ShiftExpression)Expr_296_list.get(1);
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
		//310
		final Constant2 Constant2_311_Var
		 = (Constant2)PrimaryExpression_310_Var
		.getConst();
		Assert.assertNotNull(Constant2_311_Var
		);
		Assert.assertEquals("0", Constant2_311_Var
		.getDec());
		//311
		final Statement Statement_312_Var
		 = (Statement)SelectionStatement_263_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_312_Var
		);
		//312
		final CompoundStatement CompoundStatement_313_Var
		 = (CompoundStatement)Statement_312_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_313_Var
		);
		//313
		final BodyStatement BodyStatement_314_Var
		 = (BodyStatement)CompoundStatement_313_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_314_Var
		);
		final EList<? extends EObject> BlockList_314_list = BodyStatement_314_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_314_list);
		Assert.assertEquals(1, BlockList_314_list.size());
		//314
		final BlockList BlockList_315_Var
		 = (BlockList)BlockList_314_list.get(0);
		Assert.assertNotNull(BlockList_315_Var
		);
		final EList<? extends EObject> Statement_315_list = BlockList_315_Var
		.getStatement();
		Assert.assertNotNull(Statement_315_list);
		Assert.assertEquals(2, Statement_315_list.size());
		//315
		final Statement Statement_316_Var
		 = (Statement)Statement_315_list.get(0);
		Assert.assertNotNull(Statement_316_Var
		);
		//316
		final ExpressionStatement ExpressionStatement_317_Var
		 = (ExpressionStatement)Statement_316_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_317_Var
		);
		//317
		final Expression Expression_318_Var
		 = (Expression)ExpressionStatement_317_Var
		.getExpression();
		Assert.assertNotNull(Expression_318_Var
		);
		final EList<? extends EObject> ExprExpr_318_list = Expression_318_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_318_list);
		Assert.assertEquals(1, ExprExpr_318_list.size());
		//318
		final AssignmentExpression AssignmentExpression_319_Var
		 = (AssignmentExpression)ExprExpr_318_list.get(0);
		Assert.assertNotNull(AssignmentExpression_319_Var
		);
		//319
		final UnaryExpression UnaryExpression_320_Var
		 = (UnaryExpression)AssignmentExpression_319_Var
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
		Assert.assertEquals("errno", PrimaryExpression_322_Var
		.getId());
		//322
		final AssignmentOperator AssignmentOperator_323_Var
		 = (AssignmentOperator)AssignmentExpression_319_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_323_Var
		);
		Assert.assertEquals("=", AssignmentOperator_323_Var
		.getOp());
		//323
		final AssignmentExpression AssignmentExpression_324_Var
		 = (AssignmentExpression)AssignmentExpression_319_Var
		.getAssignmentExpr();
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
		final UnaryOperator UnaryOperator_338_Var
		 = (UnaryOperator)UnaryExpression_337_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_338_Var
		);
		Assert.assertEquals("-", UnaryOperator_338_Var
		.getOp());
		//338
		final CastExpression CastExpression_339_Var
		 = (CastExpression)UnaryExpression_337_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_339_Var
		);
		//339
		final UnaryExpression UnaryExpression_340_Var
		 = (UnaryExpression)CastExpression_339_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_340_Var
		);
		//340
		final PostfixExpression PostfixExpression_341_Var
		 = (PostfixExpression)UnaryExpression_340_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_341_Var
		);
		final EList<? extends EObject> Expr_341_list = PostfixExpression_341_Var
		.getExpr();
		Assert.assertNotNull(Expr_341_list);
		Assert.assertEquals(1, Expr_341_list.size());
		//341
		final PrimaryExpression PrimaryExpression_342_Var
		 = (PrimaryExpression)Expr_341_list.get(0);
		Assert.assertNotNull(PrimaryExpression_342_Var
		);
		Assert.assertEquals("res", PrimaryExpression_342_Var
		.getId());
		//342
		final Statement Statement_343_Var
		 = (Statement)Statement_315_list.get(1);
		Assert.assertNotNull(Statement_343_Var
		);
		//343
		final ExpressionStatement ExpressionStatement_344_Var
		 = (ExpressionStatement)Statement_343_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_344_Var
		);
		//344
		final Expression Expression_345_Var
		 = (Expression)ExpressionStatement_344_Var
		.getExpression();
		Assert.assertNotNull(Expression_345_Var
		);
		final EList<? extends EObject> ExprExpr_345_list = Expression_345_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_345_list);
		Assert.assertEquals(1, ExprExpr_345_list.size());
		//345
		final AssignmentExpression AssignmentExpression_346_Var
		 = (AssignmentExpression)ExprExpr_345_list.get(0);
		Assert.assertNotNull(AssignmentExpression_346_Var
		);
		//346
		final UnaryExpression UnaryExpression_347_Var
		 = (UnaryExpression)AssignmentExpression_346_Var
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
		final AssignmentOperator AssignmentOperator_350_Var
		 = (AssignmentOperator)AssignmentExpression_346_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_350_Var
		);
		Assert.assertEquals("=", AssignmentOperator_350_Var
		.getOp());
		//350
		final AssignmentExpression AssignmentExpression_351_Var
		 = (AssignmentExpression)AssignmentExpression_346_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_351_Var
		);
		//351
		final ConditionalExpression ConditionalExpression_352_Var
		 = (ConditionalExpression)AssignmentExpression_351_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_352_Var
		);
		//352
		final LogicalOrExpression LogicalOrExpression_353_Var
		 = (LogicalOrExpression)ConditionalExpression_352_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_353_Var
		);
		final EList<? extends EObject> Expr_353_list = LogicalOrExpression_353_Var
		.getExpr();
		Assert.assertNotNull(Expr_353_list);
		Assert.assertEquals(1, Expr_353_list.size());
		//353
		final LogicalAndExpression LogicalAndExpression_354_Var
		 = (LogicalAndExpression)Expr_353_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_354_Var
		);
		final EList<? extends EObject> Expr_354_list = LogicalAndExpression_354_Var
		.getExpr();
		Assert.assertNotNull(Expr_354_list);
		Assert.assertEquals(1, Expr_354_list.size());
		//354
		final InclusiveOrExpression InclusiveOrExpression_355_Var
		 = (InclusiveOrExpression)Expr_354_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_355_Var
		);
		final EList<? extends EObject> Expr_355_list = InclusiveOrExpression_355_Var
		.getExpr();
		Assert.assertNotNull(Expr_355_list);
		Assert.assertEquals(1, Expr_355_list.size());
		//355
		final ExclusiveOrExpression ExclusiveOrExpression_356_Var
		 = (ExclusiveOrExpression)Expr_355_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_356_Var
		);
		final EList<? extends EObject> Expr_356_list = ExclusiveOrExpression_356_Var
		.getExpr();
		Assert.assertNotNull(Expr_356_list);
		Assert.assertEquals(1, Expr_356_list.size());
		//356
		final AndExpression AndExpression_357_Var
		 = (AndExpression)Expr_356_list.get(0);
		Assert.assertNotNull(AndExpression_357_Var
		);
		final EList<? extends EObject> Expr_357_list = AndExpression_357_Var
		.getExpr();
		Assert.assertNotNull(Expr_357_list);
		Assert.assertEquals(1, Expr_357_list.size());
		//357
		final EqualityExpression EqualityExpression_358_Var
		 = (EqualityExpression)Expr_357_list.get(0);
		Assert.assertNotNull(EqualityExpression_358_Var
		);
		final EList<? extends EObject> Expr_358_list = EqualityExpression_358_Var
		.getExpr();
		Assert.assertNotNull(Expr_358_list);
		Assert.assertEquals(1, Expr_358_list.size());
		//358
		final RelationalExpression RelationalExpression_359_Var
		 = (RelationalExpression)Expr_358_list.get(0);
		Assert.assertNotNull(RelationalExpression_359_Var
		);
		final EList<? extends EObject> Expr_359_list = RelationalExpression_359_Var
		.getExpr();
		Assert.assertNotNull(Expr_359_list);
		Assert.assertEquals(1, Expr_359_list.size());
		//359
		final ShiftExpression ShiftExpression_360_Var
		 = (ShiftExpression)Expr_359_list.get(0);
		Assert.assertNotNull(ShiftExpression_360_Var
		);
		final EList<? extends EObject> Expr_360_list = ShiftExpression_360_Var
		.getExpr();
		Assert.assertNotNull(Expr_360_list);
		Assert.assertEquals(1, Expr_360_list.size());
		//360
		final AdditiveExpression AdditiveExpression_361_Var
		 = (AdditiveExpression)Expr_360_list.get(0);
		Assert.assertNotNull(AdditiveExpression_361_Var
		);
		final EList<? extends EObject> Expr_361_list = AdditiveExpression_361_Var
		.getExpr();
		Assert.assertNotNull(Expr_361_list);
		Assert.assertEquals(1, Expr_361_list.size());
		//361
		final MultiplicativeExpression MultiplicativeExpression_362_Var
		 = (MultiplicativeExpression)Expr_361_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_362_Var
		);
		final EList<? extends EObject> Expr_362_list = MultiplicativeExpression_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(1, Expr_362_list.size());
		//362
		final CastExpression CastExpression_363_Var
		 = (CastExpression)Expr_362_list.get(0);
		Assert.assertNotNull(CastExpression_363_Var
		);
		//363
		final UnaryExpression UnaryExpression_364_Var
		 = (UnaryExpression)CastExpression_363_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_364_Var
		);
		//364
		final UnaryOperator UnaryOperator_365_Var
		 = (UnaryOperator)UnaryExpression_364_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_365_Var
		);
		Assert.assertEquals("-", UnaryOperator_365_Var
		.getOp());
		//365
		final CastExpression CastExpression_366_Var
		 = (CastExpression)UnaryExpression_364_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_366_Var
		);
		//366
		final UnaryExpression UnaryExpression_367_Var
		 = (UnaryExpression)CastExpression_366_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_367_Var
		);
		//367
		final PostfixExpression PostfixExpression_368_Var
		 = (PostfixExpression)UnaryExpression_367_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_368_Var
		);
		final EList<? extends EObject> Expr_368_list = PostfixExpression_368_Var
		.getExpr();
		Assert.assertNotNull(Expr_368_list);
		Assert.assertEquals(1, Expr_368_list.size());
		//368
		final PrimaryExpression PrimaryExpression_369_Var
		 = (PrimaryExpression)Expr_368_list.get(0);
		Assert.assertNotNull(PrimaryExpression_369_Var
		);
		//369
		final Constant2 Constant2_370_Var
		 = (Constant2)PrimaryExpression_369_Var
		.getConst();
		Assert.assertNotNull(Constant2_370_Var
		);
		Assert.assertEquals("1", Constant2_370_Var
		.getDec());
		//370
		final Statement Statement_371_Var
		 = (Statement)Statement_45_list.get(2);
		Assert.assertNotNull(Statement_371_Var
		);
		//371
		final JumpStatement JumpStatement_372_Var
		 = (JumpStatement)Statement_371_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_372_Var
		);
		//372
		final Expression Expression_373_Var
		 = (Expression)JumpStatement_372_Var
		.getExpr();
		Assert.assertNotNull(Expression_373_Var
		);
		final EList<? extends EObject> ExprExpr_373_list = Expression_373_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_373_list);
		Assert.assertEquals(1, ExprExpr_373_list.size());
		//373
		final AssignmentExpression AssignmentExpression_374_Var
		 = (AssignmentExpression)ExprExpr_373_list.get(0);
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
		Assert.assertEquals("res", PrimaryExpression_389_Var
		.getId());
		Assert.assertEquals("return", JumpStatement_372_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_372_Var
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


