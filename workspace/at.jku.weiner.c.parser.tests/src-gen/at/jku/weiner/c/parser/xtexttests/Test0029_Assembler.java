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
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
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
import at.jku.weiner.c.common.common.Constant2;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
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
		final AsmLine AsmLine_48_Var
		 = (AsmLine)AsmStatement_47_Var
		.getAsmLine1();
		Assert.assertNotNull(AsmLine_48_Var
		);
		//48
		final LogicalOrExpression LogicalOrExpression_49_Var
		 = (LogicalOrExpression)AsmLine_48_Var
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
		final EList<? extends EObject> AsmLines_64_list = AsmLineWithoutColon_64_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_64_list);
		Assert.assertEquals(4, AsmLines_64_list.size());
		//64
		final AsmLine AsmLine_65_Var
		 = (AsmLine)AsmLines_64_list.get(0);
		Assert.assertNotNull(AsmLine_65_Var
		);
		//65
		final LogicalOrExpression LogicalOrExpression_66_Var
		 = (LogicalOrExpression)AsmLine_65_Var
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
		Assert.assertEquals("[\"=a\"]", PrimaryExpression_79_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_79_list = PostfixExpression_78_Var
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
		final AsmLine AsmLine_98_Var
		 = (AsmLine)AsmLines_64_list.get(1);
		Assert.assertNotNull(AsmLine_98_Var
		);
		//98
		final LogicalOrExpression LogicalOrExpression_99_Var
		 = (LogicalOrExpression)AsmLine_98_Var
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
		Assert.assertEquals("[\"+b\"]", PrimaryExpression_112_Var
		.getString().toString());
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
		Assert.assertEquals(1, Expr_114_list.size());
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
		Assert.assertEquals("arg1", PrimaryExpression_130_Var
		.getId());
		//130
		final AsmLine AsmLine_131_Var
		 = (AsmLine)AsmLines_64_list.get(2);
		Assert.assertNotNull(AsmLine_131_Var
		);
		//131
		final LogicalOrExpression LogicalOrExpression_132_Var
		 = (LogicalOrExpression)AsmLine_131_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = LogicalOrExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final LogicalAndExpression LogicalAndExpression_133_Var
		 = (LogicalAndExpression)Expr_132_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = LogicalAndExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final InclusiveOrExpression InclusiveOrExpression_134_Var
		 = (InclusiveOrExpression)Expr_133_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = InclusiveOrExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final ExclusiveOrExpression ExclusiveOrExpression_135_Var
		 = (ExclusiveOrExpression)Expr_134_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = ExclusiveOrExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final AndExpression AndExpression_136_Var
		 = (AndExpression)Expr_135_list.get(0);
		Assert.assertNotNull(AndExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = AndExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final EqualityExpression EqualityExpression_137_Var
		 = (EqualityExpression)Expr_136_list.get(0);
		Assert.assertNotNull(EqualityExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = EqualityExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final RelationalExpression RelationalExpression_138_Var
		 = (RelationalExpression)Expr_137_list.get(0);
		Assert.assertNotNull(RelationalExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = RelationalExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final ShiftExpression ShiftExpression_139_Var
		 = (ShiftExpression)Expr_138_list.get(0);
		Assert.assertNotNull(ShiftExpression_139_Var
		);
		final EList<? extends EObject> Expr_139_list = ShiftExpression_139_Var
		.getExpr();
		Assert.assertNotNull(Expr_139_list);
		Assert.assertEquals(1, Expr_139_list.size());
		//139
		final AdditiveExpression AdditiveExpression_140_Var
		 = (AdditiveExpression)Expr_139_list.get(0);
		Assert.assertNotNull(AdditiveExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = AdditiveExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final MultiplicativeExpression MultiplicativeExpression_141_Var
		 = (MultiplicativeExpression)Expr_140_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = MultiplicativeExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final CastExpression CastExpression_142_Var
		 = (CastExpression)Expr_141_list.get(0);
		Assert.assertNotNull(CastExpression_142_Var
		);
		//142
		final UnaryExpression UnaryExpression_143_Var
		 = (UnaryExpression)CastExpression_142_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_143_Var
		);
		//143
		final PostfixExpression PostfixExpression_144_Var
		 = (PostfixExpression)UnaryExpression_143_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_144_Var
		);
		final EList<? extends EObject> Expr_144_list = PostfixExpression_144_Var
		.getExpr();
		Assert.assertNotNull(Expr_144_list);
		Assert.assertEquals(1, Expr_144_list.size());
		//144
		final PrimaryExpression PrimaryExpression_145_Var
		 = (PrimaryExpression)Expr_144_list.get(0);
		Assert.assertNotNull(PrimaryExpression_145_Var
		);
		Assert.assertEquals("[\"+c\"]", PrimaryExpression_145_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_145_list = PostfixExpression_144_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_145_list);
		Assert.assertEquals(1, Suffix_145_list.size());
		//145
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_146_Var
		 = (PostfixExpressionSuffixArgument)Suffix_145_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_146_Var
		);
		//146
		final ArgumentExpressionList ArgumentExpressionList_147_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_146_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_147_Var
		);
		final EList<? extends EObject> Expr_147_list = ArgumentExpressionList_147_Var
		.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(1, Expr_147_list.size());
		//147
		final AssignmentExpression AssignmentExpression_148_Var
		 = (AssignmentExpression)Expr_147_list.get(0);
		Assert.assertNotNull(AssignmentExpression_148_Var
		);
		//148
		final ConditionalExpression ConditionalExpression_149_Var
		 = (ConditionalExpression)AssignmentExpression_148_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_149_Var
		);
		//149
		final LogicalOrExpression LogicalOrExpression_150_Var
		 = (LogicalOrExpression)ConditionalExpression_149_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_150_Var
		);
		final EList<? extends EObject> Expr_150_list = LogicalOrExpression_150_Var
		.getExpr();
		Assert.assertNotNull(Expr_150_list);
		Assert.assertEquals(1, Expr_150_list.size());
		//150
		final LogicalAndExpression LogicalAndExpression_151_Var
		 = (LogicalAndExpression)Expr_150_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_151_Var
		);
		final EList<? extends EObject> Expr_151_list = LogicalAndExpression_151_Var
		.getExpr();
		Assert.assertNotNull(Expr_151_list);
		Assert.assertEquals(1, Expr_151_list.size());
		//151
		final InclusiveOrExpression InclusiveOrExpression_152_Var
		 = (InclusiveOrExpression)Expr_151_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_152_Var
		);
		final EList<? extends EObject> Expr_152_list = InclusiveOrExpression_152_Var
		.getExpr();
		Assert.assertNotNull(Expr_152_list);
		Assert.assertEquals(1, Expr_152_list.size());
		//152
		final ExclusiveOrExpression ExclusiveOrExpression_153_Var
		 = (ExclusiveOrExpression)Expr_152_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_153_Var
		);
		final EList<? extends EObject> Expr_153_list = ExclusiveOrExpression_153_Var
		.getExpr();
		Assert.assertNotNull(Expr_153_list);
		Assert.assertEquals(1, Expr_153_list.size());
		//153
		final AndExpression AndExpression_154_Var
		 = (AndExpression)Expr_153_list.get(0);
		Assert.assertNotNull(AndExpression_154_Var
		);
		final EList<? extends EObject> Expr_154_list = AndExpression_154_Var
		.getExpr();
		Assert.assertNotNull(Expr_154_list);
		Assert.assertEquals(1, Expr_154_list.size());
		//154
		final EqualityExpression EqualityExpression_155_Var
		 = (EqualityExpression)Expr_154_list.get(0);
		Assert.assertNotNull(EqualityExpression_155_Var
		);
		final EList<? extends EObject> Expr_155_list = EqualityExpression_155_Var
		.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		//155
		final RelationalExpression RelationalExpression_156_Var
		 = (RelationalExpression)Expr_155_list.get(0);
		Assert.assertNotNull(RelationalExpression_156_Var
		);
		final EList<? extends EObject> Expr_156_list = RelationalExpression_156_Var
		.getExpr();
		Assert.assertNotNull(Expr_156_list);
		Assert.assertEquals(1, Expr_156_list.size());
		//156
		final ShiftExpression ShiftExpression_157_Var
		 = (ShiftExpression)Expr_156_list.get(0);
		Assert.assertNotNull(ShiftExpression_157_Var
		);
		final EList<? extends EObject> Expr_157_list = ShiftExpression_157_Var
		.getExpr();
		Assert.assertNotNull(Expr_157_list);
		Assert.assertEquals(1, Expr_157_list.size());
		//157
		final AdditiveExpression AdditiveExpression_158_Var
		 = (AdditiveExpression)Expr_157_list.get(0);
		Assert.assertNotNull(AdditiveExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = AdditiveExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final MultiplicativeExpression MultiplicativeExpression_159_Var
		 = (MultiplicativeExpression)Expr_158_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = MultiplicativeExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final CastExpression CastExpression_160_Var
		 = (CastExpression)Expr_159_list.get(0);
		Assert.assertNotNull(CastExpression_160_Var
		);
		//160
		final UnaryExpression UnaryExpression_161_Var
		 = (UnaryExpression)CastExpression_160_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_161_Var
		);
		//161
		final PostfixExpression PostfixExpression_162_Var
		 = (PostfixExpression)UnaryExpression_161_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_162_Var
		);
		final EList<? extends EObject> Expr_162_list = PostfixExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		//162
		final PrimaryExpression PrimaryExpression_163_Var
		 = (PrimaryExpression)Expr_162_list.get(0);
		Assert.assertNotNull(PrimaryExpression_163_Var
		);
		Assert.assertEquals("arg2", PrimaryExpression_163_Var
		.getId());
		//163
		final AsmLine AsmLine_164_Var
		 = (AsmLine)AsmLines_64_list.get(3);
		Assert.assertNotNull(AsmLine_164_Var
		);
		//164
		final LogicalOrExpression LogicalOrExpression_165_Var
		 = (LogicalOrExpression)AsmLine_164_Var
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
		Assert.assertEquals("[\"+d\"]", PrimaryExpression_178_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_178_list = PostfixExpression_177_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_178_list);
		Assert.assertEquals(1, Suffix_178_list.size());
		//178
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_179_Var
		 = (PostfixExpressionSuffixArgument)Suffix_178_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_179_Var
		);
		//179
		final ArgumentExpressionList ArgumentExpressionList_180_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_179_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_180_Var
		);
		final EList<? extends EObject> Expr_180_list = ArgumentExpressionList_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final AssignmentExpression AssignmentExpression_181_Var
		 = (AssignmentExpression)Expr_180_list.get(0);
		Assert.assertNotNull(AssignmentExpression_181_Var
		);
		//181
		final ConditionalExpression ConditionalExpression_182_Var
		 = (ConditionalExpression)AssignmentExpression_181_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_182_Var
		);
		//182
		final LogicalOrExpression LogicalOrExpression_183_Var
		 = (LogicalOrExpression)ConditionalExpression_182_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = LogicalOrExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final LogicalAndExpression LogicalAndExpression_184_Var
		 = (LogicalAndExpression)Expr_183_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = LogicalAndExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final InclusiveOrExpression InclusiveOrExpression_185_Var
		 = (InclusiveOrExpression)Expr_184_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_185_Var
		);
		final EList<? extends EObject> Expr_185_list = InclusiveOrExpression_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final ExclusiveOrExpression ExclusiveOrExpression_186_Var
		 = (ExclusiveOrExpression)Expr_185_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_186_Var
		);
		final EList<? extends EObject> Expr_186_list = ExclusiveOrExpression_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(1, Expr_186_list.size());
		//186
		final AndExpression AndExpression_187_Var
		 = (AndExpression)Expr_186_list.get(0);
		Assert.assertNotNull(AndExpression_187_Var
		);
		final EList<? extends EObject> Expr_187_list = AndExpression_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(1, Expr_187_list.size());
		//187
		final EqualityExpression EqualityExpression_188_Var
		 = (EqualityExpression)Expr_187_list.get(0);
		Assert.assertNotNull(EqualityExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = EqualityExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final RelationalExpression RelationalExpression_189_Var
		 = (RelationalExpression)Expr_188_list.get(0);
		Assert.assertNotNull(RelationalExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = RelationalExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final ShiftExpression ShiftExpression_190_Var
		 = (ShiftExpression)Expr_189_list.get(0);
		Assert.assertNotNull(ShiftExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = ShiftExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final AdditiveExpression AdditiveExpression_191_Var
		 = (AdditiveExpression)Expr_190_list.get(0);
		Assert.assertNotNull(AdditiveExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = AdditiveExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final MultiplicativeExpression MultiplicativeExpression_192_Var
		 = (MultiplicativeExpression)Expr_191_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = MultiplicativeExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final CastExpression CastExpression_193_Var
		 = (CastExpression)Expr_192_list.get(0);
		Assert.assertNotNull(CastExpression_193_Var
		);
		//193
		final UnaryExpression UnaryExpression_194_Var
		 = (UnaryExpression)CastExpression_193_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_194_Var
		);
		//194
		final PostfixExpression PostfixExpression_195_Var
		 = (PostfixExpression)UnaryExpression_194_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = PostfixExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final PrimaryExpression PrimaryExpression_196_Var
		 = (PrimaryExpression)Expr_195_list.get(0);
		Assert.assertNotNull(PrimaryExpression_196_Var
		);
		Assert.assertEquals("arg3", PrimaryExpression_196_Var
		.getId());
		//196
		final AsmLineWithColon AsmLineWithColon_197_Var
		 = (AsmLineWithColon)AsmLines_62_list.get(1);
		Assert.assertNotNull(AsmLineWithColon_197_Var
		);
		//197
		final AsmLineWithoutColon AsmLineWithoutColon_198_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_197_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_198_Var
		);
		final EList<? extends EObject> AsmLines_198_list = AsmLineWithoutColon_198_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_198_list);
		Assert.assertEquals(1, AsmLines_198_list.size());
		//198
		final AsmLine AsmLine_199_Var
		 = (AsmLine)AsmLines_198_list.get(0);
		Assert.assertNotNull(AsmLine_199_Var
		);
		//199
		final LogicalOrExpression LogicalOrExpression_200_Var
		 = (LogicalOrExpression)AsmLine_199_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = LogicalOrExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final LogicalAndExpression LogicalAndExpression_201_Var
		 = (LogicalAndExpression)Expr_200_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = LogicalAndExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final InclusiveOrExpression InclusiveOrExpression_202_Var
		 = (InclusiveOrExpression)Expr_201_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = InclusiveOrExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final ExclusiveOrExpression ExclusiveOrExpression_203_Var
		 = (ExclusiveOrExpression)Expr_202_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = ExclusiveOrExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final AndExpression AndExpression_204_Var
		 = (AndExpression)Expr_203_list.get(0);
		Assert.assertNotNull(AndExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = AndExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final EqualityExpression EqualityExpression_205_Var
		 = (EqualityExpression)Expr_204_list.get(0);
		Assert.assertNotNull(EqualityExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = EqualityExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final RelationalExpression RelationalExpression_206_Var
		 = (RelationalExpression)Expr_205_list.get(0);
		Assert.assertNotNull(RelationalExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = RelationalExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final ShiftExpression ShiftExpression_207_Var
		 = (ShiftExpression)Expr_206_list.get(0);
		Assert.assertNotNull(ShiftExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = ShiftExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final AdditiveExpression AdditiveExpression_208_Var
		 = (AdditiveExpression)Expr_207_list.get(0);
		Assert.assertNotNull(AdditiveExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = AdditiveExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final MultiplicativeExpression MultiplicativeExpression_209_Var
		 = (MultiplicativeExpression)Expr_208_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = MultiplicativeExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final CastExpression CastExpression_210_Var
		 = (CastExpression)Expr_209_list.get(0);
		Assert.assertNotNull(CastExpression_210_Var
		);
		//210
		final UnaryExpression UnaryExpression_211_Var
		 = (UnaryExpression)CastExpression_210_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_211_Var
		);
		//211
		final PostfixExpression PostfixExpression_212_Var
		 = (PostfixExpression)UnaryExpression_211_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = PostfixExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final PrimaryExpression PrimaryExpression_213_Var
		 = (PrimaryExpression)Expr_212_list.get(0);
		Assert.assertNotNull(PrimaryExpression_213_Var
		);
		Assert.assertEquals("[\"a\"]", PrimaryExpression_213_Var
		.getString().toString());
		final EList<? extends EObject> Suffix_213_list = PostfixExpression_212_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_213_list);
		Assert.assertEquals(1, Suffix_213_list.size());
		//213
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_214_Var
		 = (PostfixExpressionSuffixArgument)Suffix_213_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_214_Var
		);
		//214
		final ArgumentExpressionList ArgumentExpressionList_215_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_214_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_215_Var
		);
		final EList<? extends EObject> Expr_215_list = ArgumentExpressionList_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final AssignmentExpression AssignmentExpression_216_Var
		 = (AssignmentExpression)Expr_215_list.get(0);
		Assert.assertNotNull(AssignmentExpression_216_Var
		);
		//216
		final ConditionalExpression ConditionalExpression_217_Var
		 = (ConditionalExpression)AssignmentExpression_216_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_217_Var
		);
		//217
		final LogicalOrExpression LogicalOrExpression_218_Var
		 = (LogicalOrExpression)ConditionalExpression_217_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = LogicalOrExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final LogicalAndExpression LogicalAndExpression_219_Var
		 = (LogicalAndExpression)Expr_218_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = LogicalAndExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final InclusiveOrExpression InclusiveOrExpression_220_Var
		 = (InclusiveOrExpression)Expr_219_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = InclusiveOrExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final ExclusiveOrExpression ExclusiveOrExpression_221_Var
		 = (ExclusiveOrExpression)Expr_220_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = ExclusiveOrExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final AndExpression AndExpression_222_Var
		 = (AndExpression)Expr_221_list.get(0);
		Assert.assertNotNull(AndExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = AndExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final EqualityExpression EqualityExpression_223_Var
		 = (EqualityExpression)Expr_222_list.get(0);
		Assert.assertNotNull(EqualityExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = EqualityExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final RelationalExpression RelationalExpression_224_Var
		 = (RelationalExpression)Expr_223_list.get(0);
		Assert.assertNotNull(RelationalExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = RelationalExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final ShiftExpression ShiftExpression_225_Var
		 = (ShiftExpression)Expr_224_list.get(0);
		Assert.assertNotNull(ShiftExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = ShiftExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final AdditiveExpression AdditiveExpression_226_Var
		 = (AdditiveExpression)Expr_225_list.get(0);
		Assert.assertNotNull(AdditiveExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = AdditiveExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final MultiplicativeExpression MultiplicativeExpression_227_Var
		 = (MultiplicativeExpression)Expr_226_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = MultiplicativeExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final CastExpression CastExpression_228_Var
		 = (CastExpression)Expr_227_list.get(0);
		Assert.assertNotNull(CastExpression_228_Var
		);
		//228
		final UnaryExpression UnaryExpression_229_Var
		 = (UnaryExpression)CastExpression_228_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_229_Var
		);
		//229
		final PostfixExpression PostfixExpression_230_Var
		 = (PostfixExpression)UnaryExpression_229_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = PostfixExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final PrimaryExpression PrimaryExpression_231_Var
		 = (PrimaryExpression)Expr_230_list.get(0);
		Assert.assertNotNull(PrimaryExpression_231_Var
		);
		//231
		final Constant2 Constant2_232_Var
		 = (Constant2)PrimaryExpression_231_Var
		.getConst();
		Assert.assertNotNull(Constant2_232_Var
		);
		Assert.assertEquals("128", Constant2_232_Var
		.getDec());
		//232
		final AsmLineWithColon AsmLineWithColon_233_Var
		 = (AsmLineWithColon)AsmLines_62_list.get(2);
		Assert.assertNotNull(AsmLineWithColon_233_Var
		);
		//233
		final AsmLineWithoutColon AsmLineWithoutColon_234_Var
		 = (AsmLineWithoutColon)AsmLineWithColon_233_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLineWithoutColon_234_Var
		);
		final EList<? extends EObject> AsmLines_234_list = AsmLineWithoutColon_234_Var
		.getAsmLines();
		Assert.assertNotNull(AsmLines_234_list);
		Assert.assertEquals(2, AsmLines_234_list.size());
		//234
		final AsmLine AsmLine_235_Var
		 = (AsmLine)AsmLines_234_list.get(0);
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
		Assert.assertEquals("[\"memory\"]", PrimaryExpression_249_Var
		.getString().toString());
		//249
		final AsmLine AsmLine_250_Var
		 = (AsmLine)AsmLines_234_list.get(1);
		Assert.assertNotNull(AsmLine_250_Var
		);
		//250
		final LogicalOrExpression LogicalOrExpression_251_Var
		 = (LogicalOrExpression)AsmLine_250_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = LogicalOrExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final LogicalAndExpression LogicalAndExpression_252_Var
		 = (LogicalAndExpression)Expr_251_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_252_Var
		);
		final EList<? extends EObject> Expr_252_list = LogicalAndExpression_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(1, Expr_252_list.size());
		//252
		final InclusiveOrExpression InclusiveOrExpression_253_Var
		 = (InclusiveOrExpression)Expr_252_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = InclusiveOrExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final ExclusiveOrExpression ExclusiveOrExpression_254_Var
		 = (ExclusiveOrExpression)Expr_253_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = ExclusiveOrExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final AndExpression AndExpression_255_Var
		 = (AndExpression)Expr_254_list.get(0);
		Assert.assertNotNull(AndExpression_255_Var
		);
		final EList<? extends EObject> Expr_255_list = AndExpression_255_Var
		.getExpr();
		Assert.assertNotNull(Expr_255_list);
		Assert.assertEquals(1, Expr_255_list.size());
		//255
		final EqualityExpression EqualityExpression_256_Var
		 = (EqualityExpression)Expr_255_list.get(0);
		Assert.assertNotNull(EqualityExpression_256_Var
		);
		final EList<? extends EObject> Expr_256_list = EqualityExpression_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(1, Expr_256_list.size());
		//256
		final RelationalExpression RelationalExpression_257_Var
		 = (RelationalExpression)Expr_256_list.get(0);
		Assert.assertNotNull(RelationalExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = RelationalExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final ShiftExpression ShiftExpression_258_Var
		 = (ShiftExpression)Expr_257_list.get(0);
		Assert.assertNotNull(ShiftExpression_258_Var
		);
		final EList<? extends EObject> Expr_258_list = ShiftExpression_258_Var
		.getExpr();
		Assert.assertNotNull(Expr_258_list);
		Assert.assertEquals(1, Expr_258_list.size());
		//258
		final AdditiveExpression AdditiveExpression_259_Var
		 = (AdditiveExpression)Expr_258_list.get(0);
		Assert.assertNotNull(AdditiveExpression_259_Var
		);
		final EList<? extends EObject> Expr_259_list = AdditiveExpression_259_Var
		.getExpr();
		Assert.assertNotNull(Expr_259_list);
		Assert.assertEquals(1, Expr_259_list.size());
		//259
		final MultiplicativeExpression MultiplicativeExpression_260_Var
		 = (MultiplicativeExpression)Expr_259_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = MultiplicativeExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final CastExpression CastExpression_261_Var
		 = (CastExpression)Expr_260_list.get(0);
		Assert.assertNotNull(CastExpression_261_Var
		);
		//261
		final UnaryExpression UnaryExpression_262_Var
		 = (UnaryExpression)CastExpression_261_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_262_Var
		);
		//262
		final PostfixExpression PostfixExpression_263_Var
		 = (PostfixExpression)UnaryExpression_262_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_263_Var
		);
		final EList<? extends EObject> Expr_263_list = PostfixExpression_263_Var
		.getExpr();
		Assert.assertNotNull(Expr_263_list);
		Assert.assertEquals(1, Expr_263_list.size());
		//263
		final PrimaryExpression PrimaryExpression_264_Var
		 = (PrimaryExpression)Expr_263_list.get(0);
		Assert.assertNotNull(PrimaryExpression_264_Var
		);
		Assert.assertEquals("[\"cc\"]", PrimaryExpression_264_Var
		.getString().toString());
		Assert.assertEquals(";", AsmStatement_47_Var
		.getSemi());
		//264
		final Statement Statement_265_Var
		 = (Statement)Statement_45_list.get(1);
		Assert.assertNotNull(Statement_265_Var
		);
		//265
		final SelectionStatement SelectionStatement_266_Var
		 = (SelectionStatement)Statement_265_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_266_Var
		);
		Assert.assertEquals("if", SelectionStatement_266_Var
		.getIf());
		//266
		final Expression Expression_267_Var
		 = (Expression)SelectionStatement_266_Var
		.getExpr();
		Assert.assertNotNull(Expression_267_Var
		);
		final EList<? extends EObject> ExprExpr_267_list = Expression_267_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_267_list);
		Assert.assertEquals(1, ExprExpr_267_list.size());
		//267
		final AssignmentExpression AssignmentExpression_268_Var
		 = (AssignmentExpression)ExprExpr_267_list.get(0);
		Assert.assertNotNull(AssignmentExpression_268_Var
		);
		//268
		final ConditionalExpression ConditionalExpression_269_Var
		 = (ConditionalExpression)AssignmentExpression_268_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_269_Var
		);
		//269
		final LogicalOrExpression LogicalOrExpression_270_Var
		 = (LogicalOrExpression)ConditionalExpression_269_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_270_Var
		);
		final EList<? extends EObject> Expr_270_list = LogicalOrExpression_270_Var
		.getExpr();
		Assert.assertNotNull(Expr_270_list);
		Assert.assertEquals(1, Expr_270_list.size());
		//270
		final LogicalAndExpression LogicalAndExpression_271_Var
		 = (LogicalAndExpression)Expr_270_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_271_Var
		);
		final EList<? extends EObject> Expr_271_list = LogicalAndExpression_271_Var
		.getExpr();
		Assert.assertNotNull(Expr_271_list);
		Assert.assertEquals(2, Expr_271_list.size());
		//271
		final InclusiveOrExpression InclusiveOrExpression_272_Var
		 = (InclusiveOrExpression)Expr_271_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_272_Var
		);
		final EList<? extends EObject> Expr_272_list = InclusiveOrExpression_272_Var
		.getExpr();
		Assert.assertNotNull(Expr_272_list);
		Assert.assertEquals(1, Expr_272_list.size());
		//272
		final ExclusiveOrExpression ExclusiveOrExpression_273_Var
		 = (ExclusiveOrExpression)Expr_272_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_273_Var
		);
		final EList<? extends EObject> Expr_273_list = ExclusiveOrExpression_273_Var
		.getExpr();
		Assert.assertNotNull(Expr_273_list);
		Assert.assertEquals(1, Expr_273_list.size());
		//273
		final AndExpression AndExpression_274_Var
		 = (AndExpression)Expr_273_list.get(0);
		Assert.assertNotNull(AndExpression_274_Var
		);
		final EList<? extends EObject> Expr_274_list = AndExpression_274_Var
		.getExpr();
		Assert.assertNotNull(Expr_274_list);
		Assert.assertEquals(1, Expr_274_list.size());
		//274
		final EqualityExpression EqualityExpression_275_Var
		 = (EqualityExpression)Expr_274_list.get(0);
		Assert.assertNotNull(EqualityExpression_275_Var
		);
		final EList<? extends EObject> Expr_275_list = EqualityExpression_275_Var
		.getExpr();
		Assert.assertNotNull(Expr_275_list);
		Assert.assertEquals(1, Expr_275_list.size());
		//275
		final RelationalExpression RelationalExpression_276_Var
		 = (RelationalExpression)Expr_275_list.get(0);
		Assert.assertNotNull(RelationalExpression_276_Var
		);
		Assert.assertEquals("[<=]", RelationalExpression_276_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_276_list = RelationalExpression_276_Var
		.getExpr();
		Assert.assertNotNull(Expr_276_list);
		Assert.assertEquals(2, Expr_276_list.size());
		//276
		final ShiftExpression ShiftExpression_277_Var
		 = (ShiftExpression)Expr_276_list.get(0);
		Assert.assertNotNull(ShiftExpression_277_Var
		);
		final EList<? extends EObject> Expr_277_list = ShiftExpression_277_Var
		.getExpr();
		Assert.assertNotNull(Expr_277_list);
		Assert.assertEquals(1, Expr_277_list.size());
		//277
		final AdditiveExpression AdditiveExpression_278_Var
		 = (AdditiveExpression)Expr_277_list.get(0);
		Assert.assertNotNull(AdditiveExpression_278_Var
		);
		final EList<? extends EObject> Expr_278_list = AdditiveExpression_278_Var
		.getExpr();
		Assert.assertNotNull(Expr_278_list);
		Assert.assertEquals(1, Expr_278_list.size());
		//278
		final MultiplicativeExpression MultiplicativeExpression_279_Var
		 = (MultiplicativeExpression)Expr_278_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_279_Var
		);
		final EList<? extends EObject> Expr_279_list = MultiplicativeExpression_279_Var
		.getExpr();
		Assert.assertNotNull(Expr_279_list);
		Assert.assertEquals(1, Expr_279_list.size());
		//279
		final CastExpression CastExpression_280_Var
		 = (CastExpression)Expr_279_list.get(0);
		Assert.assertNotNull(CastExpression_280_Var
		);
		//280
		final UnaryExpression UnaryExpression_281_Var
		 = (UnaryExpression)CastExpression_280_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_281_Var
		);
		//281
		final CastExpression CastExpression_282_Var
		 = (CastExpression)UnaryExpression_281_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_282_Var
		);
		//282
		final UnaryExpression UnaryExpression_283_Var
		 = (UnaryExpression)CastExpression_282_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_283_Var
		);
		//283
		final PostfixExpression PostfixExpression_284_Var
		 = (PostfixExpression)UnaryExpression_283_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_284_Var
		);
		final EList<? extends EObject> Expr_284_list = PostfixExpression_284_Var
		.getExpr();
		Assert.assertNotNull(Expr_284_list);
		Assert.assertEquals(1, Expr_284_list.size());
		//284
		final PrimaryExpression PrimaryExpression_285_Var
		 = (PrimaryExpression)Expr_284_list.get(0);
		Assert.assertNotNull(PrimaryExpression_285_Var
		);
		//285
		final Constant2 Constant2_286_Var
		 = (Constant2)PrimaryExpression_285_Var
		.getConst();
		Assert.assertNotNull(Constant2_286_Var
		);
		Assert.assertEquals("125", Constant2_286_Var
		.getDec());
		//286
		final UnaryOperator UnaryOperator_287_Var
		 = (UnaryOperator)UnaryExpression_281_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_287_Var
		);
		Assert.assertEquals("-", UnaryOperator_287_Var
		.getOp());
		//287
		final ShiftExpression ShiftExpression_288_Var
		 = (ShiftExpression)Expr_276_list.get(1);
		Assert.assertNotNull(ShiftExpression_288_Var
		);
		final EList<? extends EObject> Expr_288_list = ShiftExpression_288_Var
		.getExpr();
		Assert.assertNotNull(Expr_288_list);
		Assert.assertEquals(1, Expr_288_list.size());
		//288
		final AdditiveExpression AdditiveExpression_289_Var
		 = (AdditiveExpression)Expr_288_list.get(0);
		Assert.assertNotNull(AdditiveExpression_289_Var
		);
		final EList<? extends EObject> Expr_289_list = AdditiveExpression_289_Var
		.getExpr();
		Assert.assertNotNull(Expr_289_list);
		Assert.assertEquals(1, Expr_289_list.size());
		//289
		final MultiplicativeExpression MultiplicativeExpression_290_Var
		 = (MultiplicativeExpression)Expr_289_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_290_Var
		);
		final EList<? extends EObject> Expr_290_list = MultiplicativeExpression_290_Var
		.getExpr();
		Assert.assertNotNull(Expr_290_list);
		Assert.assertEquals(1, Expr_290_list.size());
		//290
		final CastExpression CastExpression_291_Var
		 = (CastExpression)Expr_290_list.get(0);
		Assert.assertNotNull(CastExpression_291_Var
		);
		//291
		final UnaryExpression UnaryExpression_292_Var
		 = (UnaryExpression)CastExpression_291_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_292_Var
		);
		//292
		final PostfixExpression PostfixExpression_293_Var
		 = (PostfixExpression)UnaryExpression_292_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = PostfixExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final PrimaryExpression PrimaryExpression_294_Var
		 = (PrimaryExpression)Expr_293_list.get(0);
		Assert.assertNotNull(PrimaryExpression_294_Var
		);
		Assert.assertEquals("res", PrimaryExpression_294_Var
		.getId());
		//294
		final InclusiveOrExpression InclusiveOrExpression_295_Var
		 = (InclusiveOrExpression)Expr_271_list.get(1);
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
		Assert.assertEquals("[<]", RelationalExpression_299_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_299_list = RelationalExpression_299_Var
		.getExpr();
		Assert.assertNotNull(Expr_299_list);
		Assert.assertEquals(2, Expr_299_list.size());
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
		Assert.assertEquals("res", PrimaryExpression_306_Var
		.getId());
		//306
		final ShiftExpression ShiftExpression_307_Var
		 = (ShiftExpression)Expr_299_list.get(1);
		Assert.assertNotNull(ShiftExpression_307_Var
		);
		final EList<? extends EObject> Expr_307_list = ShiftExpression_307_Var
		.getExpr();
		Assert.assertNotNull(Expr_307_list);
		Assert.assertEquals(1, Expr_307_list.size());
		//307
		final AdditiveExpression AdditiveExpression_308_Var
		 = (AdditiveExpression)Expr_307_list.get(0);
		Assert.assertNotNull(AdditiveExpression_308_Var
		);
		final EList<? extends EObject> Expr_308_list = AdditiveExpression_308_Var
		.getExpr();
		Assert.assertNotNull(Expr_308_list);
		Assert.assertEquals(1, Expr_308_list.size());
		//308
		final MultiplicativeExpression MultiplicativeExpression_309_Var
		 = (MultiplicativeExpression)Expr_308_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_309_Var
		);
		final EList<? extends EObject> Expr_309_list = MultiplicativeExpression_309_Var
		.getExpr();
		Assert.assertNotNull(Expr_309_list);
		Assert.assertEquals(1, Expr_309_list.size());
		//309
		final CastExpression CastExpression_310_Var
		 = (CastExpression)Expr_309_list.get(0);
		Assert.assertNotNull(CastExpression_310_Var
		);
		//310
		final UnaryExpression UnaryExpression_311_Var
		 = (UnaryExpression)CastExpression_310_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_311_Var
		);
		//311
		final PostfixExpression PostfixExpression_312_Var
		 = (PostfixExpression)UnaryExpression_311_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = PostfixExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final PrimaryExpression PrimaryExpression_313_Var
		 = (PrimaryExpression)Expr_312_list.get(0);
		Assert.assertNotNull(PrimaryExpression_313_Var
		);
		//313
		final Constant2 Constant2_314_Var
		 = (Constant2)PrimaryExpression_313_Var
		.getConst();
		Assert.assertNotNull(Constant2_314_Var
		);
		Assert.assertEquals("0", Constant2_314_Var
		.getDec());
		//314
		final Statement Statement_315_Var
		 = (Statement)SelectionStatement_266_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_315_Var
		);
		//315
		final CompoundStatement CompoundStatement_316_Var
		 = (CompoundStatement)Statement_315_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_316_Var
		);
		//316
		final BodyStatement BodyStatement_317_Var
		 = (BodyStatement)CompoundStatement_316_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_317_Var
		);
		final EList<? extends EObject> BlockList_317_list = BodyStatement_317_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_317_list);
		Assert.assertEquals(1, BlockList_317_list.size());
		//317
		final BlockList BlockList_318_Var
		 = (BlockList)BlockList_317_list.get(0);
		Assert.assertNotNull(BlockList_318_Var
		);
		final EList<? extends EObject> Statement_318_list = BlockList_318_Var
		.getStatement();
		Assert.assertNotNull(Statement_318_list);
		Assert.assertEquals(2, Statement_318_list.size());
		//318
		final Statement Statement_319_Var
		 = (Statement)Statement_318_list.get(0);
		Assert.assertNotNull(Statement_319_Var
		);
		//319
		final ExpressionStatement ExpressionStatement_320_Var
		 = (ExpressionStatement)Statement_319_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_320_Var
		);
		//320
		final Expression Expression_321_Var
		 = (Expression)ExpressionStatement_320_Var
		.getExpression();
		Assert.assertNotNull(Expression_321_Var
		);
		final EList<? extends EObject> ExprExpr_321_list = Expression_321_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_321_list);
		Assert.assertEquals(1, ExprExpr_321_list.size());
		//321
		final AssignmentExpression AssignmentExpression_322_Var
		 = (AssignmentExpression)ExprExpr_321_list.get(0);
		Assert.assertNotNull(AssignmentExpression_322_Var
		);
		//322
		final UnaryExpression UnaryExpression_323_Var
		 = (UnaryExpression)AssignmentExpression_322_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_323_Var
		);
		//323
		final PostfixExpression PostfixExpression_324_Var
		 = (PostfixExpression)UnaryExpression_323_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_324_Var
		);
		final EList<? extends EObject> Expr_324_list = PostfixExpression_324_Var
		.getExpr();
		Assert.assertNotNull(Expr_324_list);
		Assert.assertEquals(1, Expr_324_list.size());
		//324
		final PrimaryExpression PrimaryExpression_325_Var
		 = (PrimaryExpression)Expr_324_list.get(0);
		Assert.assertNotNull(PrimaryExpression_325_Var
		);
		Assert.assertEquals("errno", PrimaryExpression_325_Var
		.getId());
		//325
		final AssignmentOperator AssignmentOperator_326_Var
		 = (AssignmentOperator)AssignmentExpression_322_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_326_Var
		);
		Assert.assertEquals("=", AssignmentOperator_326_Var
		.getOp());
		//326
		final AssignmentExpression AssignmentExpression_327_Var
		 = (AssignmentExpression)AssignmentExpression_322_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_327_Var
		);
		//327
		final ConditionalExpression ConditionalExpression_328_Var
		 = (ConditionalExpression)AssignmentExpression_327_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_328_Var
		);
		//328
		final LogicalOrExpression LogicalOrExpression_329_Var
		 = (LogicalOrExpression)ConditionalExpression_328_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_329_Var
		);
		final EList<? extends EObject> Expr_329_list = LogicalOrExpression_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final LogicalAndExpression LogicalAndExpression_330_Var
		 = (LogicalAndExpression)Expr_329_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_330_Var
		);
		final EList<? extends EObject> Expr_330_list = LogicalAndExpression_330_Var
		.getExpr();
		Assert.assertNotNull(Expr_330_list);
		Assert.assertEquals(1, Expr_330_list.size());
		//330
		final InclusiveOrExpression InclusiveOrExpression_331_Var
		 = (InclusiveOrExpression)Expr_330_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = InclusiveOrExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final ExclusiveOrExpression ExclusiveOrExpression_332_Var
		 = (ExclusiveOrExpression)Expr_331_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_332_Var
		);
		final EList<? extends EObject> Expr_332_list = ExclusiveOrExpression_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final AndExpression AndExpression_333_Var
		 = (AndExpression)Expr_332_list.get(0);
		Assert.assertNotNull(AndExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = AndExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final EqualityExpression EqualityExpression_334_Var
		 = (EqualityExpression)Expr_333_list.get(0);
		Assert.assertNotNull(EqualityExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = EqualityExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final RelationalExpression RelationalExpression_335_Var
		 = (RelationalExpression)Expr_334_list.get(0);
		Assert.assertNotNull(RelationalExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = RelationalExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final ShiftExpression ShiftExpression_336_Var
		 = (ShiftExpression)Expr_335_list.get(0);
		Assert.assertNotNull(ShiftExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = ShiftExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final AdditiveExpression AdditiveExpression_337_Var
		 = (AdditiveExpression)Expr_336_list.get(0);
		Assert.assertNotNull(AdditiveExpression_337_Var
		);
		final EList<? extends EObject> Expr_337_list = AdditiveExpression_337_Var
		.getExpr();
		Assert.assertNotNull(Expr_337_list);
		Assert.assertEquals(1, Expr_337_list.size());
		//337
		final MultiplicativeExpression MultiplicativeExpression_338_Var
		 = (MultiplicativeExpression)Expr_337_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = MultiplicativeExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final CastExpression CastExpression_339_Var
		 = (CastExpression)Expr_338_list.get(0);
		Assert.assertNotNull(CastExpression_339_Var
		);
		//339
		final UnaryExpression UnaryExpression_340_Var
		 = (UnaryExpression)CastExpression_339_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_340_Var
		);
		//340
		final UnaryOperator UnaryOperator_341_Var
		 = (UnaryOperator)UnaryExpression_340_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_341_Var
		);
		Assert.assertEquals("-", UnaryOperator_341_Var
		.getOp());
		//341
		final CastExpression CastExpression_342_Var
		 = (CastExpression)UnaryExpression_340_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_342_Var
		);
		//342
		final UnaryExpression UnaryExpression_343_Var
		 = (UnaryExpression)CastExpression_342_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_343_Var
		);
		//343
		final PostfixExpression PostfixExpression_344_Var
		 = (PostfixExpression)UnaryExpression_343_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_344_Var
		);
		final EList<? extends EObject> Expr_344_list = PostfixExpression_344_Var
		.getExpr();
		Assert.assertNotNull(Expr_344_list);
		Assert.assertEquals(1, Expr_344_list.size());
		//344
		final PrimaryExpression PrimaryExpression_345_Var
		 = (PrimaryExpression)Expr_344_list.get(0);
		Assert.assertNotNull(PrimaryExpression_345_Var
		);
		Assert.assertEquals("res", PrimaryExpression_345_Var
		.getId());
		//345
		final Statement Statement_346_Var
		 = (Statement)Statement_318_list.get(1);
		Assert.assertNotNull(Statement_346_Var
		);
		//346
		final ExpressionStatement ExpressionStatement_347_Var
		 = (ExpressionStatement)Statement_346_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_347_Var
		);
		//347
		final Expression Expression_348_Var
		 = (Expression)ExpressionStatement_347_Var
		.getExpression();
		Assert.assertNotNull(Expression_348_Var
		);
		final EList<? extends EObject> ExprExpr_348_list = Expression_348_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_348_list);
		Assert.assertEquals(1, ExprExpr_348_list.size());
		//348
		final AssignmentExpression AssignmentExpression_349_Var
		 = (AssignmentExpression)ExprExpr_348_list.get(0);
		Assert.assertNotNull(AssignmentExpression_349_Var
		);
		//349
		final UnaryExpression UnaryExpression_350_Var
		 = (UnaryExpression)AssignmentExpression_349_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_350_Var
		);
		//350
		final PostfixExpression PostfixExpression_351_Var
		 = (PostfixExpression)UnaryExpression_350_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_351_Var
		);
		final EList<? extends EObject> Expr_351_list = PostfixExpression_351_Var
		.getExpr();
		Assert.assertNotNull(Expr_351_list);
		Assert.assertEquals(1, Expr_351_list.size());
		//351
		final PrimaryExpression PrimaryExpression_352_Var
		 = (PrimaryExpression)Expr_351_list.get(0);
		Assert.assertNotNull(PrimaryExpression_352_Var
		);
		Assert.assertEquals("res", PrimaryExpression_352_Var
		.getId());
		//352
		final AssignmentOperator AssignmentOperator_353_Var
		 = (AssignmentOperator)AssignmentExpression_349_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_353_Var
		);
		Assert.assertEquals("=", AssignmentOperator_353_Var
		.getOp());
		//353
		final AssignmentExpression AssignmentExpression_354_Var
		 = (AssignmentExpression)AssignmentExpression_349_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_354_Var
		);
		//354
		final ConditionalExpression ConditionalExpression_355_Var
		 = (ConditionalExpression)AssignmentExpression_354_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_355_Var
		);
		//355
		final LogicalOrExpression LogicalOrExpression_356_Var
		 = (LogicalOrExpression)ConditionalExpression_355_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_356_Var
		);
		final EList<? extends EObject> Expr_356_list = LogicalOrExpression_356_Var
		.getExpr();
		Assert.assertNotNull(Expr_356_list);
		Assert.assertEquals(1, Expr_356_list.size());
		//356
		final LogicalAndExpression LogicalAndExpression_357_Var
		 = (LogicalAndExpression)Expr_356_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_357_Var
		);
		final EList<? extends EObject> Expr_357_list = LogicalAndExpression_357_Var
		.getExpr();
		Assert.assertNotNull(Expr_357_list);
		Assert.assertEquals(1, Expr_357_list.size());
		//357
		final InclusiveOrExpression InclusiveOrExpression_358_Var
		 = (InclusiveOrExpression)Expr_357_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_358_Var
		);
		final EList<? extends EObject> Expr_358_list = InclusiveOrExpression_358_Var
		.getExpr();
		Assert.assertNotNull(Expr_358_list);
		Assert.assertEquals(1, Expr_358_list.size());
		//358
		final ExclusiveOrExpression ExclusiveOrExpression_359_Var
		 = (ExclusiveOrExpression)Expr_358_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_359_Var
		);
		final EList<? extends EObject> Expr_359_list = ExclusiveOrExpression_359_Var
		.getExpr();
		Assert.assertNotNull(Expr_359_list);
		Assert.assertEquals(1, Expr_359_list.size());
		//359
		final AndExpression AndExpression_360_Var
		 = (AndExpression)Expr_359_list.get(0);
		Assert.assertNotNull(AndExpression_360_Var
		);
		final EList<? extends EObject> Expr_360_list = AndExpression_360_Var
		.getExpr();
		Assert.assertNotNull(Expr_360_list);
		Assert.assertEquals(1, Expr_360_list.size());
		//360
		final EqualityExpression EqualityExpression_361_Var
		 = (EqualityExpression)Expr_360_list.get(0);
		Assert.assertNotNull(EqualityExpression_361_Var
		);
		final EList<? extends EObject> Expr_361_list = EqualityExpression_361_Var
		.getExpr();
		Assert.assertNotNull(Expr_361_list);
		Assert.assertEquals(1, Expr_361_list.size());
		//361
		final RelationalExpression RelationalExpression_362_Var
		 = (RelationalExpression)Expr_361_list.get(0);
		Assert.assertNotNull(RelationalExpression_362_Var
		);
		final EList<? extends EObject> Expr_362_list = RelationalExpression_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(1, Expr_362_list.size());
		//362
		final ShiftExpression ShiftExpression_363_Var
		 = (ShiftExpression)Expr_362_list.get(0);
		Assert.assertNotNull(ShiftExpression_363_Var
		);
		final EList<? extends EObject> Expr_363_list = ShiftExpression_363_Var
		.getExpr();
		Assert.assertNotNull(Expr_363_list);
		Assert.assertEquals(1, Expr_363_list.size());
		//363
		final AdditiveExpression AdditiveExpression_364_Var
		 = (AdditiveExpression)Expr_363_list.get(0);
		Assert.assertNotNull(AdditiveExpression_364_Var
		);
		final EList<? extends EObject> Expr_364_list = AdditiveExpression_364_Var
		.getExpr();
		Assert.assertNotNull(Expr_364_list);
		Assert.assertEquals(1, Expr_364_list.size());
		//364
		final MultiplicativeExpression MultiplicativeExpression_365_Var
		 = (MultiplicativeExpression)Expr_364_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = MultiplicativeExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final CastExpression CastExpression_366_Var
		 = (CastExpression)Expr_365_list.get(0);
		Assert.assertNotNull(CastExpression_366_Var
		);
		//366
		final UnaryExpression UnaryExpression_367_Var
		 = (UnaryExpression)CastExpression_366_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_367_Var
		);
		//367
		final UnaryOperator UnaryOperator_368_Var
		 = (UnaryOperator)UnaryExpression_367_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_368_Var
		);
		Assert.assertEquals("-", UnaryOperator_368_Var
		.getOp());
		//368
		final CastExpression CastExpression_369_Var
		 = (CastExpression)UnaryExpression_367_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_369_Var
		);
		//369
		final UnaryExpression UnaryExpression_370_Var
		 = (UnaryExpression)CastExpression_369_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_370_Var
		);
		//370
		final PostfixExpression PostfixExpression_371_Var
		 = (PostfixExpression)UnaryExpression_370_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_371_Var
		);
		final EList<? extends EObject> Expr_371_list = PostfixExpression_371_Var
		.getExpr();
		Assert.assertNotNull(Expr_371_list);
		Assert.assertEquals(1, Expr_371_list.size());
		//371
		final PrimaryExpression PrimaryExpression_372_Var
		 = (PrimaryExpression)Expr_371_list.get(0);
		Assert.assertNotNull(PrimaryExpression_372_Var
		);
		//372
		final Constant2 Constant2_373_Var
		 = (Constant2)PrimaryExpression_372_Var
		.getConst();
		Assert.assertNotNull(Constant2_373_Var
		);
		Assert.assertEquals("1", Constant2_373_Var
		.getDec());
		//373
		final Statement Statement_374_Var
		 = (Statement)Statement_45_list.get(2);
		Assert.assertNotNull(Statement_374_Var
		);
		//374
		final JumpStatement JumpStatement_375_Var
		 = (JumpStatement)Statement_374_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_375_Var
		);
		//375
		final Expression Expression_376_Var
		 = (Expression)JumpStatement_375_Var
		.getExpr();
		Assert.assertNotNull(Expression_376_Var
		);
		final EList<? extends EObject> ExprExpr_376_list = Expression_376_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_376_list);
		Assert.assertEquals(1, ExprExpr_376_list.size());
		//376
		final AssignmentExpression AssignmentExpression_377_Var
		 = (AssignmentExpression)ExprExpr_376_list.get(0);
		Assert.assertNotNull(AssignmentExpression_377_Var
		);
		//377
		final ConditionalExpression ConditionalExpression_378_Var
		 = (ConditionalExpression)AssignmentExpression_377_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_378_Var
		);
		//378
		final LogicalOrExpression LogicalOrExpression_379_Var
		 = (LogicalOrExpression)ConditionalExpression_378_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_379_Var
		);
		final EList<? extends EObject> Expr_379_list = LogicalOrExpression_379_Var
		.getExpr();
		Assert.assertNotNull(Expr_379_list);
		Assert.assertEquals(1, Expr_379_list.size());
		//379
		final LogicalAndExpression LogicalAndExpression_380_Var
		 = (LogicalAndExpression)Expr_379_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_380_Var
		);
		final EList<? extends EObject> Expr_380_list = LogicalAndExpression_380_Var
		.getExpr();
		Assert.assertNotNull(Expr_380_list);
		Assert.assertEquals(1, Expr_380_list.size());
		//380
		final InclusiveOrExpression InclusiveOrExpression_381_Var
		 = (InclusiveOrExpression)Expr_380_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_381_Var
		);
		final EList<? extends EObject> Expr_381_list = InclusiveOrExpression_381_Var
		.getExpr();
		Assert.assertNotNull(Expr_381_list);
		Assert.assertEquals(1, Expr_381_list.size());
		//381
		final ExclusiveOrExpression ExclusiveOrExpression_382_Var
		 = (ExclusiveOrExpression)Expr_381_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_382_Var
		);
		final EList<? extends EObject> Expr_382_list = ExclusiveOrExpression_382_Var
		.getExpr();
		Assert.assertNotNull(Expr_382_list);
		Assert.assertEquals(1, Expr_382_list.size());
		//382
		final AndExpression AndExpression_383_Var
		 = (AndExpression)Expr_382_list.get(0);
		Assert.assertNotNull(AndExpression_383_Var
		);
		final EList<? extends EObject> Expr_383_list = AndExpression_383_Var
		.getExpr();
		Assert.assertNotNull(Expr_383_list);
		Assert.assertEquals(1, Expr_383_list.size());
		//383
		final EqualityExpression EqualityExpression_384_Var
		 = (EqualityExpression)Expr_383_list.get(0);
		Assert.assertNotNull(EqualityExpression_384_Var
		);
		final EList<? extends EObject> Expr_384_list = EqualityExpression_384_Var
		.getExpr();
		Assert.assertNotNull(Expr_384_list);
		Assert.assertEquals(1, Expr_384_list.size());
		//384
		final RelationalExpression RelationalExpression_385_Var
		 = (RelationalExpression)Expr_384_list.get(0);
		Assert.assertNotNull(RelationalExpression_385_Var
		);
		final EList<? extends EObject> Expr_385_list = RelationalExpression_385_Var
		.getExpr();
		Assert.assertNotNull(Expr_385_list);
		Assert.assertEquals(1, Expr_385_list.size());
		//385
		final ShiftExpression ShiftExpression_386_Var
		 = (ShiftExpression)Expr_385_list.get(0);
		Assert.assertNotNull(ShiftExpression_386_Var
		);
		final EList<? extends EObject> Expr_386_list = ShiftExpression_386_Var
		.getExpr();
		Assert.assertNotNull(Expr_386_list);
		Assert.assertEquals(1, Expr_386_list.size());
		//386
		final AdditiveExpression AdditiveExpression_387_Var
		 = (AdditiveExpression)Expr_386_list.get(0);
		Assert.assertNotNull(AdditiveExpression_387_Var
		);
		final EList<? extends EObject> Expr_387_list = AdditiveExpression_387_Var
		.getExpr();
		Assert.assertNotNull(Expr_387_list);
		Assert.assertEquals(1, Expr_387_list.size());
		//387
		final MultiplicativeExpression MultiplicativeExpression_388_Var
		 = (MultiplicativeExpression)Expr_387_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_388_Var
		);
		final EList<? extends EObject> Expr_388_list = MultiplicativeExpression_388_Var
		.getExpr();
		Assert.assertNotNull(Expr_388_list);
		Assert.assertEquals(1, Expr_388_list.size());
		//388
		final CastExpression CastExpression_389_Var
		 = (CastExpression)Expr_388_list.get(0);
		Assert.assertNotNull(CastExpression_389_Var
		);
		//389
		final UnaryExpression UnaryExpression_390_Var
		 = (UnaryExpression)CastExpression_389_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_390_Var
		);
		//390
		final PostfixExpression PostfixExpression_391_Var
		 = (PostfixExpression)UnaryExpression_390_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_391_Var
		);
		final EList<? extends EObject> Expr_391_list = PostfixExpression_391_Var
		.getExpr();
		Assert.assertNotNull(Expr_391_list);
		Assert.assertEquals(1, Expr_391_list.size());
		//391
		final PrimaryExpression PrimaryExpression_392_Var
		 = (PrimaryExpression)Expr_391_list.get(0);
		Assert.assertNotNull(PrimaryExpression_392_Var
		);
		Assert.assertEquals("res", PrimaryExpression_392_Var
		.getId());
		Assert.assertEquals("return", JumpStatement_375_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_375_Var
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


