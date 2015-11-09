package at.jku.weiner.c.xtexttests;

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
import at.jku.weiner.c.tests.CInjectorProvider;
import at.jku.weiner.c.parser.antlr.CParser;
import at.jku.weiner.c.parser.antlr.internal.InternalCLexer;
import at.jku.weiner.c.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.c.Model;
import at.jku.weiner.c.c.TranslationUnit;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.StorageClassSpecifier;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.FunctionDefHead;
import at.jku.weiner.c.c.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.DeclaratorSuffix;
import at.jku.weiner.c.c.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.c.ParameterTypeList;
import at.jku.weiner.c.c.ParameterList;
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.Pointer;
import at.jku.weiner.c.c.ParameterDeclaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.FunctionDefinition;
import at.jku.weiner.c.c.BodyStatement;
import at.jku.weiner.c.c.BlockList;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.AsmStatement;
import at.jku.weiner.c.c.AsmLineWithColon;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.AsmLineWithColon;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.c.ArgumentExpressionList;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.AsmLineWithComma;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.c.ArgumentExpressionList;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.AsmLineWithComma;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.c.ArgumentExpressionList;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.AsmLineWithComma;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.c.ArgumentExpressionList;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.AsmLineWithColon;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.c.ArgumentExpressionList;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.AsmLine;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.AsmLineWithComma;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.SelectionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.UnaryOperator;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.CompoundStatement;
import at.jku.weiner.c.c.BodyStatement;
import at.jku.weiner.c.c.BlockList;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.AssignmentOperator;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.UnaryOperator;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.AssignmentOperator;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.UnaryOperator;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.JumpStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0029_Assembler {
	@Inject
	private ParseHelper<Model> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalCLexer lexer;
	@Inject
	private CParser parser;
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
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_STAR", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_NEWLINE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_ASM2", 
				"RULE_WHITESPACE", 
				"RULE_KW_VOLATILE", 
				"RULE_LEFTPAREN", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_COLON", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_LEFTPAREN", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_LEFTPAREN", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_LEFTPAREN", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_LEFTPAREN", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_COLON", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_LEFTPAREN", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_COLON", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_BLOCK_COMMENT", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_IF", 
				"RULE_WHITESPACE", 
				"RULE_LEFTPAREN", 
				"RULE_MINUS", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_WHITESPACE", 
				"RULE_LESSEQUAL", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ANDAND", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_LESS", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_MINUS", 
				"RULE_ID", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_MINUS", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_RIGHTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
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
			"res/Test0029_Assembler.c");
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
		Assert.assertEquals(2, External_1_list.size());
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
		final StorageClassSpecifier StorageClassSpecifier_5_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_4_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_5_Var
		);
		Assert.assertEquals("extern", StorageClassSpecifier_5_Var
		.getName());
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
		Assert.assertEquals(1, InitDeclarator_7_list.size());
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
		Assert.assertEquals("errno", DirectDeclarator_10_Var
		.getId());
		Assert.assertEquals(";", Declaration_3_Var
		.getSemi());
		//10
		final ExternalDeclaration ExternalDeclaration_11_Var
		 = (ExternalDeclaration)External_1_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_11_Var
		);
		//11
		final FunctionDefHead FunctionDefHead_12_Var
		 = (FunctionDefHead)ExternalDeclaration_11_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_12_Var
		);
		//12
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_13_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_12_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_13_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_13_list = FunctionDeclarationSpecifiers_13_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_13_list);
		Assert.assertEquals(1, DeclarationSpecifier_13_list.size());
		//13
		final TypeSpecifier TypeSpecifier_14_Var
		 = (TypeSpecifier)DeclarationSpecifier_13_list.get(0);
		Assert.assertNotNull(TypeSpecifier_14_Var
		);
		Assert.assertEquals("int", TypeSpecifier_14_Var
		.getName());
		//14
		final Declarator Declarator_15_Var
		 = (Declarator)FunctionDefHead_12_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_15_Var
		);
		//15
		final DirectDeclarator DirectDeclarator_16_Var
		 = (DirectDeclarator)Declarator_15_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_16_Var
		);
		Assert.assertEquals("funcname", DirectDeclarator_16_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_16_list = DirectDeclarator_16_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_16_list);
		Assert.assertEquals(1, DeclaratorSuffix_16_list.size());
		//16
		final DeclaratorSuffix DeclaratorSuffix_17_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_16_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_17_Var
		);
		//17
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_18_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_17_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_18_Var
		);
		final EList<? extends EObject> ParameterTypeList_18_list = DirectDeclaratorLastSuffix_18_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_18_list);
		Assert.assertEquals(1, ParameterTypeList_18_list.size());
		//18
		final ParameterTypeList ParameterTypeList_19_Var
		 = (ParameterTypeList)ParameterTypeList_18_list.get(0);
		Assert.assertNotNull(ParameterTypeList_19_Var
		);
		//19
		final ParameterList ParameterList_20_Var
		 = (ParameterList)ParameterTypeList_19_Var
		.getList();
		Assert.assertNotNull(ParameterList_20_Var
		);
		final EList<? extends EObject> ParameterDeclaration_20_list = ParameterList_20_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_20_list);
		Assert.assertEquals(3, ParameterDeclaration_20_list.size());
		//20
		final ParameterDeclaration ParameterDeclaration_21_Var
		 = (ParameterDeclaration)ParameterDeclaration_20_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_21_Var
		);
		//21
		final DeclarationSpecifiers DeclarationSpecifiers_22_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_21_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_22_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_22_list = DeclarationSpecifiers_22_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_22_list);
		Assert.assertEquals(1, DeclarationSpecifier_22_list.size());
		//22
		final TypeSpecifier TypeSpecifier_23_Var
		 = (TypeSpecifier)DeclarationSpecifier_22_list.get(0);
		Assert.assertNotNull(TypeSpecifier_23_Var
		);
		Assert.assertEquals("int", TypeSpecifier_23_Var
		.getName());
		//23
		final Declarator Declarator_24_Var
		 = (Declarator)ParameterDeclaration_21_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_24_Var
		);
		//24
		final DirectDeclarator DirectDeclarator_25_Var
		 = (DirectDeclarator)Declarator_24_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_25_Var
		);
		Assert.assertEquals("arg1", DirectDeclarator_25_Var
		.getId());
		//25
		final ParameterDeclaration ParameterDeclaration_26_Var
		 = (ParameterDeclaration)ParameterDeclaration_20_list.get(1);
		Assert.assertNotNull(ParameterDeclaration_26_Var
		);
		//26
		final DeclarationSpecifiers DeclarationSpecifiers_27_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_26_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_27_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_27_list = DeclarationSpecifiers_27_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_27_list);
		Assert.assertEquals(1, DeclarationSpecifier_27_list.size());
		//27
		final TypeSpecifier TypeSpecifier_28_Var
		 = (TypeSpecifier)DeclarationSpecifier_27_list.get(0);
		Assert.assertNotNull(TypeSpecifier_28_Var
		);
		Assert.assertEquals("int", TypeSpecifier_28_Var
		.getName());
		//28
		final Declarator Declarator_29_Var
		 = (Declarator)ParameterDeclaration_26_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_29_Var
		);
		//29
		final DirectDeclarator DirectDeclarator_30_Var
		 = (DirectDeclarator)Declarator_29_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_30_Var
		);
		Assert.assertEquals("arg2", DirectDeclarator_30_Var
		.getId());
		//30
		final Pointer Pointer_31_Var
		 = (Pointer)Declarator_29_Var
		.getPointer();
		Assert.assertNotNull(Pointer_31_Var
		);
		Assert.assertEquals("[*]", Pointer_31_Var
		.getStar().toString());
		//31
		final ParameterDeclaration ParameterDeclaration_32_Var
		 = (ParameterDeclaration)ParameterDeclaration_20_list.get(2);
		Assert.assertNotNull(ParameterDeclaration_32_Var
		);
		//32
		final DeclarationSpecifiers DeclarationSpecifiers_33_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_32_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_33_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_33_list = DeclarationSpecifiers_33_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_33_list);
		Assert.assertEquals(1, DeclarationSpecifier_33_list.size());
		//33
		final TypeSpecifier TypeSpecifier_34_Var
		 = (TypeSpecifier)DeclarationSpecifier_33_list.get(0);
		Assert.assertNotNull(TypeSpecifier_34_Var
		);
		Assert.assertEquals("int", TypeSpecifier_34_Var
		.getName());
		//34
		final Declarator Declarator_35_Var
		 = (Declarator)ParameterDeclaration_32_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_35_Var
		);
		//35
		final DirectDeclarator DirectDeclarator_36_Var
		 = (DirectDeclarator)Declarator_35_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_36_Var
		);
		Assert.assertEquals("arg3", DirectDeclarator_36_Var
		.getId());
		//36
		final FunctionDefinition FunctionDefinition_37_Var
		 = (FunctionDefinition)ExternalDeclaration_11_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_37_Var
		);
		//37
		final BodyStatement BodyStatement_38_Var
		 = (BodyStatement)FunctionDefinition_37_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_38_Var
		);
		final EList<? extends EObject> BlockList_38_list = BodyStatement_38_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_38_list);
		Assert.assertEquals(1, BlockList_38_list.size());
		//38
		final BlockList BlockList_39_Var
		 = (BlockList)BlockList_38_list.get(0);
		Assert.assertNotNull(BlockList_39_Var
		);
		final EList<? extends EObject> Declaration_39_list = BlockList_39_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_39_list);
		Assert.assertEquals(1, Declaration_39_list.size());
		//39
		final Declaration Declaration_40_Var
		 = (Declaration)Declaration_39_list.get(0);
		Assert.assertNotNull(Declaration_40_Var
		);
		//40
		final DeclarationSpecifiers DeclarationSpecifiers_41_Var
		 = (DeclarationSpecifiers)Declaration_40_Var
		.getSpecifiers();
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
		Assert.assertEquals("int", TypeSpecifier_42_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_42_list = Declaration_40_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_42_list);
		Assert.assertEquals(1, InitDeclaratorList_42_list.size());
		//42
		final InitDeclaratorList InitDeclaratorList_43_Var
		 = (InitDeclaratorList)InitDeclaratorList_42_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_43_Var
		);
		final EList<? extends EObject> InitDeclarator_43_list = InitDeclaratorList_43_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_43_list);
		Assert.assertEquals(1, InitDeclarator_43_list.size());
		//43
		final InitDeclarator InitDeclarator_44_Var
		 = (InitDeclarator)InitDeclarator_43_list.get(0);
		Assert.assertNotNull(InitDeclarator_44_Var
		);
		//44
		final Declarator Declarator_45_Var
		 = (Declarator)InitDeclarator_44_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_45_Var
		);
		//45
		final DirectDeclarator DirectDeclarator_46_Var
		 = (DirectDeclarator)Declarator_45_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_46_Var
		);
		Assert.assertEquals("res", DirectDeclarator_46_Var
		.getId());
		Assert.assertEquals(";", Declaration_40_Var
		.getSemi());
		final EList<? extends EObject> Statement_46_list = BlockList_39_Var
		.getStatement();
		Assert.assertNotNull(Statement_46_list);
		Assert.assertEquals(3, Statement_46_list.size());
		//46
		final Statement Statement_47_Var
		 = (Statement)Statement_46_list.get(0);
		Assert.assertNotNull(Statement_47_Var
		);
		//47
		final AsmStatement AsmStatement_48_Var
		 = (AsmStatement)Statement_47_Var
		.getStmt();
		Assert.assertNotNull(AsmStatement_48_Var
		);
		final EList<? extends EObject> AsmLine_48_list = AsmStatement_48_Var
		.getAsmLine();
		Assert.assertNotNull(AsmLine_48_list);
		Assert.assertEquals(8, AsmLine_48_list.size());
		//48
		final AsmLineWithColon AsmLineWithColon_49_Var
		 = (AsmLineWithColon)AsmLine_48_list.get(0);
		Assert.assertNotNull(AsmLineWithColon_49_Var
		);
		//49
		final LogicalOrExpression LogicalOrExpression_50_Var
		 = (LogicalOrExpression)AsmLineWithColon_49_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_50_Var
		);
		final EList<? extends EObject> Expr_50_list = LogicalOrExpression_50_Var
		.getExpr();
		Assert.assertNotNull(Expr_50_list);
		Assert.assertEquals(1, Expr_50_list.size());
		//50
		final LogicalAndExpression LogicalAndExpression_51_Var
		 = (LogicalAndExpression)Expr_50_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_51_Var
		);
		final EList<? extends EObject> Expr_51_list = LogicalAndExpression_51_Var
		.getExpr();
		Assert.assertNotNull(Expr_51_list);
		Assert.assertEquals(1, Expr_51_list.size());
		//51
		final InclusiveOrExpression InclusiveOrExpression_52_Var
		 = (InclusiveOrExpression)Expr_51_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_52_Var
		);
		final EList<? extends EObject> Expr_52_list = InclusiveOrExpression_52_Var
		.getExpr();
		Assert.assertNotNull(Expr_52_list);
		Assert.assertEquals(1, Expr_52_list.size());
		//52
		final ExclusiveOrExpression ExclusiveOrExpression_53_Var
		 = (ExclusiveOrExpression)Expr_52_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_53_Var
		);
		final EList<? extends EObject> Expr_53_list = ExclusiveOrExpression_53_Var
		.getExpr();
		Assert.assertNotNull(Expr_53_list);
		Assert.assertEquals(1, Expr_53_list.size());
		//53
		final AndExpression AndExpression_54_Var
		 = (AndExpression)Expr_53_list.get(0);
		Assert.assertNotNull(AndExpression_54_Var
		);
		final EList<? extends EObject> Expr_54_list = AndExpression_54_Var
		.getExpr();
		Assert.assertNotNull(Expr_54_list);
		Assert.assertEquals(1, Expr_54_list.size());
		//54
		final EqualityExpression EqualityExpression_55_Var
		 = (EqualityExpression)Expr_54_list.get(0);
		Assert.assertNotNull(EqualityExpression_55_Var
		);
		final EList<? extends EObject> Expr_55_list = EqualityExpression_55_Var
		.getExpr();
		Assert.assertNotNull(Expr_55_list);
		Assert.assertEquals(1, Expr_55_list.size());
		//55
		final RelationalExpression RelationalExpression_56_Var
		 = (RelationalExpression)Expr_55_list.get(0);
		Assert.assertNotNull(RelationalExpression_56_Var
		);
		final EList<? extends EObject> Expr_56_list = RelationalExpression_56_Var
		.getExpr();
		Assert.assertNotNull(Expr_56_list);
		Assert.assertEquals(1, Expr_56_list.size());
		//56
		final ShiftExpression ShiftExpression_57_Var
		 = (ShiftExpression)Expr_56_list.get(0);
		Assert.assertNotNull(ShiftExpression_57_Var
		);
		final EList<? extends EObject> Expr_57_list = ShiftExpression_57_Var
		.getExpr();
		Assert.assertNotNull(Expr_57_list);
		Assert.assertEquals(1, Expr_57_list.size());
		//57
		final AdditiveExpression AdditiveExpression_58_Var
		 = (AdditiveExpression)Expr_57_list.get(0);
		Assert.assertNotNull(AdditiveExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = AdditiveExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final MultiplicativeExpression MultiplicativeExpression_59_Var
		 = (MultiplicativeExpression)Expr_58_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = MultiplicativeExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final CastExpression CastExpression_60_Var
		 = (CastExpression)Expr_59_list.get(0);
		Assert.assertNotNull(CastExpression_60_Var
		);
		//60
		final UnaryExpression UnaryExpression_61_Var
		 = (UnaryExpression)CastExpression_60_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_61_Var
		);
		//61
		final PostfixExpression PostfixExpression_62_Var
		 = (PostfixExpression)UnaryExpression_61_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = PostfixExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final PrimaryExpression PrimaryExpression_63_Var
		 = (PrimaryExpression)Expr_62_list.get(0);
		Assert.assertNotNull(PrimaryExpression_63_Var
		);
		//63
		final Constant Constant_64_Var
		 = (Constant)PrimaryExpression_63_Var
		.getConst();
		Assert.assertNotNull(Constant_64_Var
		);
		Assert.assertEquals("\"int $0x80\"", Constant_64_Var
		.getStr());
		//64
		final AsmLineWithColon AsmLineWithColon_65_Var
		 = (AsmLineWithColon)AsmLine_48_list.get(1);
		Assert.assertNotNull(AsmLineWithColon_65_Var
		);
		//65
		final LogicalOrExpression LogicalOrExpression_66_Var
		 = (LogicalOrExpression)AsmLineWithColon_65_Var
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
		final Constant Constant_80_Var
		 = (Constant)PrimaryExpression_79_Var
		.getConst();
		Assert.assertNotNull(Constant_80_Var
		);
		Assert.assertEquals("\"=a\"", Constant_80_Var
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
		//98
		final AsmLineWithComma AsmLineWithComma_99_Var
		 = (AsmLineWithComma)AsmLine_48_list.get(2);
		Assert.assertNotNull(AsmLineWithComma_99_Var
		);
		//99
		final LogicalOrExpression LogicalOrExpression_100_Var
		 = (LogicalOrExpression)AsmLineWithComma_99_Var
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
		final Constant Constant_114_Var
		 = (Constant)PrimaryExpression_113_Var
		.getConst();
		Assert.assertNotNull(Constant_114_Var
		);
		Assert.assertEquals("\"+b\"", Constant_114_Var
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
		final AsmLineWithComma AsmLineWithComma_133_Var
		 = (AsmLineWithComma)AsmLine_48_list.get(3);
		Assert.assertNotNull(AsmLineWithComma_133_Var
		);
		//133
		final LogicalOrExpression LogicalOrExpression_134_Var
		 = (LogicalOrExpression)AsmLineWithComma_133_Var
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
		final Constant Constant_148_Var
		 = (Constant)PrimaryExpression_147_Var
		.getConst();
		Assert.assertNotNull(Constant_148_Var
		);
		Assert.assertEquals("\"+c\"", Constant_148_Var
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
		final AsmLineWithComma AsmLineWithComma_167_Var
		 = (AsmLineWithComma)AsmLine_48_list.get(4);
		Assert.assertNotNull(AsmLineWithComma_167_Var
		);
		//167
		final LogicalOrExpression LogicalOrExpression_168_Var
		 = (LogicalOrExpression)AsmLineWithComma_167_Var
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
		final Constant Constant_182_Var
		 = (Constant)PrimaryExpression_181_Var
		.getConst();
		Assert.assertNotNull(Constant_182_Var
		);
		Assert.assertEquals("\"+d\"", Constant_182_Var
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
		 = (AsmLineWithColon)AsmLine_48_list.get(5);
		Assert.assertNotNull(AsmLineWithColon_201_Var
		);
		//201
		final LogicalOrExpression LogicalOrExpression_202_Var
		 = (LogicalOrExpression)AsmLineWithColon_201_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = LogicalOrExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final LogicalAndExpression LogicalAndExpression_203_Var
		 = (LogicalAndExpression)Expr_202_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_203_Var
		);
		final EList<? extends EObject> Expr_203_list = LogicalAndExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expr_203_list);
		Assert.assertEquals(1, Expr_203_list.size());
		//203
		final InclusiveOrExpression InclusiveOrExpression_204_Var
		 = (InclusiveOrExpression)Expr_203_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = InclusiveOrExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final ExclusiveOrExpression ExclusiveOrExpression_205_Var
		 = (ExclusiveOrExpression)Expr_204_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = ExclusiveOrExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final AndExpression AndExpression_206_Var
		 = (AndExpression)Expr_205_list.get(0);
		Assert.assertNotNull(AndExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = AndExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final EqualityExpression EqualityExpression_207_Var
		 = (EqualityExpression)Expr_206_list.get(0);
		Assert.assertNotNull(EqualityExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = EqualityExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final RelationalExpression RelationalExpression_208_Var
		 = (RelationalExpression)Expr_207_list.get(0);
		Assert.assertNotNull(RelationalExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = RelationalExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final ShiftExpression ShiftExpression_209_Var
		 = (ShiftExpression)Expr_208_list.get(0);
		Assert.assertNotNull(ShiftExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = ShiftExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final AdditiveExpression AdditiveExpression_210_Var
		 = (AdditiveExpression)Expr_209_list.get(0);
		Assert.assertNotNull(AdditiveExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = AdditiveExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final MultiplicativeExpression MultiplicativeExpression_211_Var
		 = (MultiplicativeExpression)Expr_210_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = MultiplicativeExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final CastExpression CastExpression_212_Var
		 = (CastExpression)Expr_211_list.get(0);
		Assert.assertNotNull(CastExpression_212_Var
		);
		//212
		final UnaryExpression UnaryExpression_213_Var
		 = (UnaryExpression)CastExpression_212_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_213_Var
		);
		//213
		final PostfixExpression PostfixExpression_214_Var
		 = (PostfixExpression)UnaryExpression_213_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = PostfixExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final PrimaryExpression PrimaryExpression_215_Var
		 = (PrimaryExpression)Expr_214_list.get(0);
		Assert.assertNotNull(PrimaryExpression_215_Var
		);
		//215
		final Constant Constant_216_Var
		 = (Constant)PrimaryExpression_215_Var
		.getConst();
		Assert.assertNotNull(Constant_216_Var
		);
		Assert.assertEquals("\"a\"", Constant_216_Var
		.getStr());
		final EList<? extends EObject> Suffix_216_list = PostfixExpression_214_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_216_list);
		Assert.assertEquals(1, Suffix_216_list.size());
		//216
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_217_Var
		 = (PostfixExpressionSuffixArgument)Suffix_216_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_217_Var
		);
		//217
		final ArgumentExpressionList ArgumentExpressionList_218_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_217_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_218_Var
		);
		final EList<? extends EObject> Expr_218_list = ArgumentExpressionList_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final AssignmentExpression AssignmentExpression_219_Var
		 = (AssignmentExpression)Expr_218_list.get(0);
		Assert.assertNotNull(AssignmentExpression_219_Var
		);
		//219
		final ConditionalExpression ConditionalExpression_220_Var
		 = (ConditionalExpression)AssignmentExpression_219_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_220_Var
		);
		//220
		final LogicalOrExpression LogicalOrExpression_221_Var
		 = (LogicalOrExpression)ConditionalExpression_220_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = LogicalOrExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final LogicalAndExpression LogicalAndExpression_222_Var
		 = (LogicalAndExpression)Expr_221_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = LogicalAndExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final InclusiveOrExpression InclusiveOrExpression_223_Var
		 = (InclusiveOrExpression)Expr_222_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = InclusiveOrExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final ExclusiveOrExpression ExclusiveOrExpression_224_Var
		 = (ExclusiveOrExpression)Expr_223_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = ExclusiveOrExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final AndExpression AndExpression_225_Var
		 = (AndExpression)Expr_224_list.get(0);
		Assert.assertNotNull(AndExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = AndExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final EqualityExpression EqualityExpression_226_Var
		 = (EqualityExpression)Expr_225_list.get(0);
		Assert.assertNotNull(EqualityExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = EqualityExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final RelationalExpression RelationalExpression_227_Var
		 = (RelationalExpression)Expr_226_list.get(0);
		Assert.assertNotNull(RelationalExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = RelationalExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final ShiftExpression ShiftExpression_228_Var
		 = (ShiftExpression)Expr_227_list.get(0);
		Assert.assertNotNull(ShiftExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = ShiftExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final AdditiveExpression AdditiveExpression_229_Var
		 = (AdditiveExpression)Expr_228_list.get(0);
		Assert.assertNotNull(AdditiveExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = AdditiveExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final MultiplicativeExpression MultiplicativeExpression_230_Var
		 = (MultiplicativeExpression)Expr_229_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = MultiplicativeExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final CastExpression CastExpression_231_Var
		 = (CastExpression)Expr_230_list.get(0);
		Assert.assertNotNull(CastExpression_231_Var
		);
		//231
		final UnaryExpression UnaryExpression_232_Var
		 = (UnaryExpression)CastExpression_231_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_232_Var
		);
		//232
		final PostfixExpression PostfixExpression_233_Var
		 = (PostfixExpression)UnaryExpression_232_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = PostfixExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final PrimaryExpression PrimaryExpression_234_Var
		 = (PrimaryExpression)Expr_233_list.get(0);
		Assert.assertNotNull(PrimaryExpression_234_Var
		);
		//234
		final Constant Constant_235_Var
		 = (Constant)PrimaryExpression_234_Var
		.getConst();
		Assert.assertNotNull(Constant_235_Var
		);
		Assert.assertEquals("128", Constant_235_Var
		.getDec());
		//235
		final AsmLine AsmLine_236_Var
		 = (AsmLine)AsmLine_48_list.get(6);
		Assert.assertNotNull(AsmLine_236_Var
		);
		//236
		final LogicalOrExpression LogicalOrExpression_237_Var
		 = (LogicalOrExpression)AsmLine_236_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = LogicalOrExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final LogicalAndExpression LogicalAndExpression_238_Var
		 = (LogicalAndExpression)Expr_237_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = LogicalAndExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final InclusiveOrExpression InclusiveOrExpression_239_Var
		 = (InclusiveOrExpression)Expr_238_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = InclusiveOrExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final ExclusiveOrExpression ExclusiveOrExpression_240_Var
		 = (ExclusiveOrExpression)Expr_239_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = ExclusiveOrExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final AndExpression AndExpression_241_Var
		 = (AndExpression)Expr_240_list.get(0);
		Assert.assertNotNull(AndExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = AndExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final EqualityExpression EqualityExpression_242_Var
		 = (EqualityExpression)Expr_241_list.get(0);
		Assert.assertNotNull(EqualityExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = EqualityExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final RelationalExpression RelationalExpression_243_Var
		 = (RelationalExpression)Expr_242_list.get(0);
		Assert.assertNotNull(RelationalExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = RelationalExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final ShiftExpression ShiftExpression_244_Var
		 = (ShiftExpression)Expr_243_list.get(0);
		Assert.assertNotNull(ShiftExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = ShiftExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final AdditiveExpression AdditiveExpression_245_Var
		 = (AdditiveExpression)Expr_244_list.get(0);
		Assert.assertNotNull(AdditiveExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = AdditiveExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final MultiplicativeExpression MultiplicativeExpression_246_Var
		 = (MultiplicativeExpression)Expr_245_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = MultiplicativeExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final CastExpression CastExpression_247_Var
		 = (CastExpression)Expr_246_list.get(0);
		Assert.assertNotNull(CastExpression_247_Var
		);
		//247
		final UnaryExpression UnaryExpression_248_Var
		 = (UnaryExpression)CastExpression_247_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_248_Var
		);
		//248
		final PostfixExpression PostfixExpression_249_Var
		 = (PostfixExpression)UnaryExpression_248_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = PostfixExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final PrimaryExpression PrimaryExpression_250_Var
		 = (PrimaryExpression)Expr_249_list.get(0);
		Assert.assertNotNull(PrimaryExpression_250_Var
		);
		//250
		final Constant Constant_251_Var
		 = (Constant)PrimaryExpression_250_Var
		.getConst();
		Assert.assertNotNull(Constant_251_Var
		);
		Assert.assertEquals("\"memory\"", Constant_251_Var
		.getStr());
		//251
		final AsmLineWithComma AsmLineWithComma_252_Var
		 = (AsmLineWithComma)AsmLine_48_list.get(7);
		Assert.assertNotNull(AsmLineWithComma_252_Var
		);
		//252
		final LogicalOrExpression LogicalOrExpression_253_Var
		 = (LogicalOrExpression)AsmLineWithComma_252_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = LogicalOrExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final LogicalAndExpression LogicalAndExpression_254_Var
		 = (LogicalAndExpression)Expr_253_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = LogicalAndExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final InclusiveOrExpression InclusiveOrExpression_255_Var
		 = (InclusiveOrExpression)Expr_254_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_255_Var
		);
		final EList<? extends EObject> Expr_255_list = InclusiveOrExpression_255_Var
		.getExpr();
		Assert.assertNotNull(Expr_255_list);
		Assert.assertEquals(1, Expr_255_list.size());
		//255
		final ExclusiveOrExpression ExclusiveOrExpression_256_Var
		 = (ExclusiveOrExpression)Expr_255_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_256_Var
		);
		final EList<? extends EObject> Expr_256_list = ExclusiveOrExpression_256_Var
		.getExpr();
		Assert.assertNotNull(Expr_256_list);
		Assert.assertEquals(1, Expr_256_list.size());
		//256
		final AndExpression AndExpression_257_Var
		 = (AndExpression)Expr_256_list.get(0);
		Assert.assertNotNull(AndExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = AndExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final EqualityExpression EqualityExpression_258_Var
		 = (EqualityExpression)Expr_257_list.get(0);
		Assert.assertNotNull(EqualityExpression_258_Var
		);
		final EList<? extends EObject> Expr_258_list = EqualityExpression_258_Var
		.getExpr();
		Assert.assertNotNull(Expr_258_list);
		Assert.assertEquals(1, Expr_258_list.size());
		//258
		final RelationalExpression RelationalExpression_259_Var
		 = (RelationalExpression)Expr_258_list.get(0);
		Assert.assertNotNull(RelationalExpression_259_Var
		);
		final EList<? extends EObject> Expr_259_list = RelationalExpression_259_Var
		.getExpr();
		Assert.assertNotNull(Expr_259_list);
		Assert.assertEquals(1, Expr_259_list.size());
		//259
		final ShiftExpression ShiftExpression_260_Var
		 = (ShiftExpression)Expr_259_list.get(0);
		Assert.assertNotNull(ShiftExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = ShiftExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final AdditiveExpression AdditiveExpression_261_Var
		 = (AdditiveExpression)Expr_260_list.get(0);
		Assert.assertNotNull(AdditiveExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = AdditiveExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final MultiplicativeExpression MultiplicativeExpression_262_Var
		 = (MultiplicativeExpression)Expr_261_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_262_Var
		);
		final EList<? extends EObject> Expr_262_list = MultiplicativeExpression_262_Var
		.getExpr();
		Assert.assertNotNull(Expr_262_list);
		Assert.assertEquals(1, Expr_262_list.size());
		//262
		final CastExpression CastExpression_263_Var
		 = (CastExpression)Expr_262_list.get(0);
		Assert.assertNotNull(CastExpression_263_Var
		);
		//263
		final UnaryExpression UnaryExpression_264_Var
		 = (UnaryExpression)CastExpression_263_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_264_Var
		);
		//264
		final PostfixExpression PostfixExpression_265_Var
		 = (PostfixExpression)UnaryExpression_264_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_265_Var
		);
		final EList<? extends EObject> Expr_265_list = PostfixExpression_265_Var
		.getExpr();
		Assert.assertNotNull(Expr_265_list);
		Assert.assertEquals(1, Expr_265_list.size());
		//265
		final PrimaryExpression PrimaryExpression_266_Var
		 = (PrimaryExpression)Expr_265_list.get(0);
		Assert.assertNotNull(PrimaryExpression_266_Var
		);
		//266
		final Constant Constant_267_Var
		 = (Constant)PrimaryExpression_266_Var
		.getConst();
		Assert.assertNotNull(Constant_267_Var
		);
		Assert.assertEquals("\"cc\"", Constant_267_Var
		.getStr());
		Assert.assertEquals(";", AsmStatement_48_Var
		.getSemi());
		//267
		final Statement Statement_268_Var
		 = (Statement)Statement_46_list.get(1);
		Assert.assertNotNull(Statement_268_Var
		);
		//268
		final SelectionStatement SelectionStatement_269_Var
		 = (SelectionStatement)Statement_268_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_269_Var
		);
		Assert.assertEquals("if", SelectionStatement_269_Var
		.getIf());
		//269
		final Expression Expression_270_Var
		 = (Expression)SelectionStatement_269_Var
		.getExpr();
		Assert.assertNotNull(Expression_270_Var
		);
		final EList<? extends EObject> ExprExpr_270_list = Expression_270_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_270_list);
		Assert.assertEquals(1, ExprExpr_270_list.size());
		//270
		final AssignmentExpression AssignmentExpression_271_Var
		 = (AssignmentExpression)ExprExpr_270_list.get(0);
		Assert.assertNotNull(AssignmentExpression_271_Var
		);
		//271
		final ConditionalExpression ConditionalExpression_272_Var
		 = (ConditionalExpression)AssignmentExpression_271_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_272_Var
		);
		//272
		final LogicalOrExpression LogicalOrExpression_273_Var
		 = (LogicalOrExpression)ConditionalExpression_272_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_273_Var
		);
		final EList<? extends EObject> Expr_273_list = LogicalOrExpression_273_Var
		.getExpr();
		Assert.assertNotNull(Expr_273_list);
		Assert.assertEquals(1, Expr_273_list.size());
		//273
		final LogicalAndExpression LogicalAndExpression_274_Var
		 = (LogicalAndExpression)Expr_273_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_274_Var
		);
		final EList<? extends EObject> Expr_274_list = LogicalAndExpression_274_Var
		.getExpr();
		Assert.assertNotNull(Expr_274_list);
		Assert.assertEquals(2, Expr_274_list.size());
		//274
		final InclusiveOrExpression InclusiveOrExpression_275_Var
		 = (InclusiveOrExpression)Expr_274_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_275_Var
		);
		final EList<? extends EObject> Expr_275_list = InclusiveOrExpression_275_Var
		.getExpr();
		Assert.assertNotNull(Expr_275_list);
		Assert.assertEquals(1, Expr_275_list.size());
		//275
		final ExclusiveOrExpression ExclusiveOrExpression_276_Var
		 = (ExclusiveOrExpression)Expr_275_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_276_Var
		);
		final EList<? extends EObject> Expr_276_list = ExclusiveOrExpression_276_Var
		.getExpr();
		Assert.assertNotNull(Expr_276_list);
		Assert.assertEquals(1, Expr_276_list.size());
		//276
		final AndExpression AndExpression_277_Var
		 = (AndExpression)Expr_276_list.get(0);
		Assert.assertNotNull(AndExpression_277_Var
		);
		final EList<? extends EObject> Expr_277_list = AndExpression_277_Var
		.getExpr();
		Assert.assertNotNull(Expr_277_list);
		Assert.assertEquals(1, Expr_277_list.size());
		//277
		final EqualityExpression EqualityExpression_278_Var
		 = (EqualityExpression)Expr_277_list.get(0);
		Assert.assertNotNull(EqualityExpression_278_Var
		);
		final EList<? extends EObject> Expr_278_list = EqualityExpression_278_Var
		.getExpr();
		Assert.assertNotNull(Expr_278_list);
		Assert.assertEquals(1, Expr_278_list.size());
		//278
		final RelationalExpression RelationalExpression_279_Var
		 = (RelationalExpression)Expr_278_list.get(0);
		Assert.assertNotNull(RelationalExpression_279_Var
		);
		Assert.assertEquals("[<=]", RelationalExpression_279_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_279_list = RelationalExpression_279_Var
		.getExpr();
		Assert.assertNotNull(Expr_279_list);
		Assert.assertEquals(2, Expr_279_list.size());
		//279
		final ShiftExpression ShiftExpression_280_Var
		 = (ShiftExpression)Expr_279_list.get(0);
		Assert.assertNotNull(ShiftExpression_280_Var
		);
		final EList<? extends EObject> Expr_280_list = ShiftExpression_280_Var
		.getExpr();
		Assert.assertNotNull(Expr_280_list);
		Assert.assertEquals(1, Expr_280_list.size());
		//280
		final AdditiveExpression AdditiveExpression_281_Var
		 = (AdditiveExpression)Expr_280_list.get(0);
		Assert.assertNotNull(AdditiveExpression_281_Var
		);
		final EList<? extends EObject> Expr_281_list = AdditiveExpression_281_Var
		.getExpr();
		Assert.assertNotNull(Expr_281_list);
		Assert.assertEquals(1, Expr_281_list.size());
		//281
		final MultiplicativeExpression MultiplicativeExpression_282_Var
		 = (MultiplicativeExpression)Expr_281_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_282_Var
		);
		final EList<? extends EObject> Expr_282_list = MultiplicativeExpression_282_Var
		.getExpr();
		Assert.assertNotNull(Expr_282_list);
		Assert.assertEquals(1, Expr_282_list.size());
		//282
		final CastExpression CastExpression_283_Var
		 = (CastExpression)Expr_282_list.get(0);
		Assert.assertNotNull(CastExpression_283_Var
		);
		//283
		final UnaryExpression UnaryExpression_284_Var
		 = (UnaryExpression)CastExpression_283_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_284_Var
		);
		//284
		final CastExpression CastExpression_285_Var
		 = (CastExpression)UnaryExpression_284_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_285_Var
		);
		//285
		final UnaryExpression UnaryExpression_286_Var
		 = (UnaryExpression)CastExpression_285_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_286_Var
		);
		//286
		final PostfixExpression PostfixExpression_287_Var
		 = (PostfixExpression)UnaryExpression_286_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_287_Var
		);
		final EList<? extends EObject> Expr_287_list = PostfixExpression_287_Var
		.getExpr();
		Assert.assertNotNull(Expr_287_list);
		Assert.assertEquals(1, Expr_287_list.size());
		//287
		final PrimaryExpression PrimaryExpression_288_Var
		 = (PrimaryExpression)Expr_287_list.get(0);
		Assert.assertNotNull(PrimaryExpression_288_Var
		);
		//288
		final Constant Constant_289_Var
		 = (Constant)PrimaryExpression_288_Var
		.getConst();
		Assert.assertNotNull(Constant_289_Var
		);
		Assert.assertEquals("125", Constant_289_Var
		.getDec());
		//289
		final UnaryOperator UnaryOperator_290_Var
		 = (UnaryOperator)UnaryExpression_284_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_290_Var
		);
		Assert.assertEquals("-", UnaryOperator_290_Var
		.getOp());
		//290
		final ShiftExpression ShiftExpression_291_Var
		 = (ShiftExpression)Expr_279_list.get(1);
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
		Assert.assertEquals("res", PrimaryExpression_297_Var
		.getId());
		//297
		final InclusiveOrExpression InclusiveOrExpression_298_Var
		 = (InclusiveOrExpression)Expr_274_list.get(1);
		Assert.assertNotNull(InclusiveOrExpression_298_Var
		);
		final EList<? extends EObject> Expr_298_list = InclusiveOrExpression_298_Var
		.getExpr();
		Assert.assertNotNull(Expr_298_list);
		Assert.assertEquals(1, Expr_298_list.size());
		//298
		final ExclusiveOrExpression ExclusiveOrExpression_299_Var
		 = (ExclusiveOrExpression)Expr_298_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_299_Var
		);
		final EList<? extends EObject> Expr_299_list = ExclusiveOrExpression_299_Var
		.getExpr();
		Assert.assertNotNull(Expr_299_list);
		Assert.assertEquals(1, Expr_299_list.size());
		//299
		final AndExpression AndExpression_300_Var
		 = (AndExpression)Expr_299_list.get(0);
		Assert.assertNotNull(AndExpression_300_Var
		);
		final EList<? extends EObject> Expr_300_list = AndExpression_300_Var
		.getExpr();
		Assert.assertNotNull(Expr_300_list);
		Assert.assertEquals(1, Expr_300_list.size());
		//300
		final EqualityExpression EqualityExpression_301_Var
		 = (EqualityExpression)Expr_300_list.get(0);
		Assert.assertNotNull(EqualityExpression_301_Var
		);
		final EList<? extends EObject> Expr_301_list = EqualityExpression_301_Var
		.getExpr();
		Assert.assertNotNull(Expr_301_list);
		Assert.assertEquals(1, Expr_301_list.size());
		//301
		final RelationalExpression RelationalExpression_302_Var
		 = (RelationalExpression)Expr_301_list.get(0);
		Assert.assertNotNull(RelationalExpression_302_Var
		);
		Assert.assertEquals("[<]", RelationalExpression_302_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_302_list = RelationalExpression_302_Var
		.getExpr();
		Assert.assertNotNull(Expr_302_list);
		Assert.assertEquals(2, Expr_302_list.size());
		//302
		final ShiftExpression ShiftExpression_303_Var
		 = (ShiftExpression)Expr_302_list.get(0);
		Assert.assertNotNull(ShiftExpression_303_Var
		);
		final EList<? extends EObject> Expr_303_list = ShiftExpression_303_Var
		.getExpr();
		Assert.assertNotNull(Expr_303_list);
		Assert.assertEquals(1, Expr_303_list.size());
		//303
		final AdditiveExpression AdditiveExpression_304_Var
		 = (AdditiveExpression)Expr_303_list.get(0);
		Assert.assertNotNull(AdditiveExpression_304_Var
		);
		final EList<? extends EObject> Expr_304_list = AdditiveExpression_304_Var
		.getExpr();
		Assert.assertNotNull(Expr_304_list);
		Assert.assertEquals(1, Expr_304_list.size());
		//304
		final MultiplicativeExpression MultiplicativeExpression_305_Var
		 = (MultiplicativeExpression)Expr_304_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_305_Var
		);
		final EList<? extends EObject> Expr_305_list = MultiplicativeExpression_305_Var
		.getExpr();
		Assert.assertNotNull(Expr_305_list);
		Assert.assertEquals(1, Expr_305_list.size());
		//305
		final CastExpression CastExpression_306_Var
		 = (CastExpression)Expr_305_list.get(0);
		Assert.assertNotNull(CastExpression_306_Var
		);
		//306
		final UnaryExpression UnaryExpression_307_Var
		 = (UnaryExpression)CastExpression_306_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_307_Var
		);
		//307
		final PostfixExpression PostfixExpression_308_Var
		 = (PostfixExpression)UnaryExpression_307_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_308_Var
		);
		final EList<? extends EObject> Expr_308_list = PostfixExpression_308_Var
		.getExpr();
		Assert.assertNotNull(Expr_308_list);
		Assert.assertEquals(1, Expr_308_list.size());
		//308
		final PrimaryExpression PrimaryExpression_309_Var
		 = (PrimaryExpression)Expr_308_list.get(0);
		Assert.assertNotNull(PrimaryExpression_309_Var
		);
		Assert.assertEquals("res", PrimaryExpression_309_Var
		.getId());
		//309
		final ShiftExpression ShiftExpression_310_Var
		 = (ShiftExpression)Expr_302_list.get(1);
		Assert.assertNotNull(ShiftExpression_310_Var
		);
		final EList<? extends EObject> Expr_310_list = ShiftExpression_310_Var
		.getExpr();
		Assert.assertNotNull(Expr_310_list);
		Assert.assertEquals(1, Expr_310_list.size());
		//310
		final AdditiveExpression AdditiveExpression_311_Var
		 = (AdditiveExpression)Expr_310_list.get(0);
		Assert.assertNotNull(AdditiveExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = AdditiveExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final MultiplicativeExpression MultiplicativeExpression_312_Var
		 = (MultiplicativeExpression)Expr_311_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = MultiplicativeExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final CastExpression CastExpression_313_Var
		 = (CastExpression)Expr_312_list.get(0);
		Assert.assertNotNull(CastExpression_313_Var
		);
		//313
		final UnaryExpression UnaryExpression_314_Var
		 = (UnaryExpression)CastExpression_313_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_314_Var
		);
		//314
		final PostfixExpression PostfixExpression_315_Var
		 = (PostfixExpression)UnaryExpression_314_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = PostfixExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final PrimaryExpression PrimaryExpression_316_Var
		 = (PrimaryExpression)Expr_315_list.get(0);
		Assert.assertNotNull(PrimaryExpression_316_Var
		);
		//316
		final Constant Constant_317_Var
		 = (Constant)PrimaryExpression_316_Var
		.getConst();
		Assert.assertNotNull(Constant_317_Var
		);
		Assert.assertEquals("0", Constant_317_Var
		.getDec());
		//317
		final Statement Statement_318_Var
		 = (Statement)SelectionStatement_269_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_318_Var
		);
		//318
		final CompoundStatement CompoundStatement_319_Var
		 = (CompoundStatement)Statement_318_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_319_Var
		);
		//319
		final BodyStatement BodyStatement_320_Var
		 = (BodyStatement)CompoundStatement_319_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_320_Var
		);
		final EList<? extends EObject> BlockList_320_list = BodyStatement_320_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_320_list);
		Assert.assertEquals(1, BlockList_320_list.size());
		//320
		final BlockList BlockList_321_Var
		 = (BlockList)BlockList_320_list.get(0);
		Assert.assertNotNull(BlockList_321_Var
		);
		final EList<? extends EObject> Statement_321_list = BlockList_321_Var
		.getStatement();
		Assert.assertNotNull(Statement_321_list);
		Assert.assertEquals(2, Statement_321_list.size());
		//321
		final Statement Statement_322_Var
		 = (Statement)Statement_321_list.get(0);
		Assert.assertNotNull(Statement_322_Var
		);
		//322
		final ExpressionStatement ExpressionStatement_323_Var
		 = (ExpressionStatement)Statement_322_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_323_Var
		);
		//323
		final Expression Expression_324_Var
		 = (Expression)ExpressionStatement_323_Var
		.getExpression();
		Assert.assertNotNull(Expression_324_Var
		);
		final EList<? extends EObject> ExprExpr_324_list = Expression_324_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_324_list);
		Assert.assertEquals(1, ExprExpr_324_list.size());
		//324
		final AssignmentExpression AssignmentExpression_325_Var
		 = (AssignmentExpression)ExprExpr_324_list.get(0);
		Assert.assertNotNull(AssignmentExpression_325_Var
		);
		//325
		final UnaryExpression UnaryExpression_326_Var
		 = (UnaryExpression)AssignmentExpression_325_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_326_Var
		);
		//326
		final PostfixExpression PostfixExpression_327_Var
		 = (PostfixExpression)UnaryExpression_326_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_327_Var
		);
		final EList<? extends EObject> Expr_327_list = PostfixExpression_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final PrimaryExpression PrimaryExpression_328_Var
		 = (PrimaryExpression)Expr_327_list.get(0);
		Assert.assertNotNull(PrimaryExpression_328_Var
		);
		Assert.assertEquals("errno", PrimaryExpression_328_Var
		.getId());
		//328
		final AssignmentOperator AssignmentOperator_329_Var
		 = (AssignmentOperator)AssignmentExpression_325_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_329_Var
		);
		Assert.assertEquals("=", AssignmentOperator_329_Var
		.getOp());
		//329
		final AssignmentExpression AssignmentExpression_330_Var
		 = (AssignmentExpression)AssignmentExpression_325_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_330_Var
		);
		//330
		final ConditionalExpression ConditionalExpression_331_Var
		 = (ConditionalExpression)AssignmentExpression_330_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_331_Var
		);
		//331
		final LogicalOrExpression LogicalOrExpression_332_Var
		 = (LogicalOrExpression)ConditionalExpression_331_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_332_Var
		);
		final EList<? extends EObject> Expr_332_list = LogicalOrExpression_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final LogicalAndExpression LogicalAndExpression_333_Var
		 = (LogicalAndExpression)Expr_332_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = LogicalAndExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final InclusiveOrExpression InclusiveOrExpression_334_Var
		 = (InclusiveOrExpression)Expr_333_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = InclusiveOrExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final ExclusiveOrExpression ExclusiveOrExpression_335_Var
		 = (ExclusiveOrExpression)Expr_334_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = ExclusiveOrExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final AndExpression AndExpression_336_Var
		 = (AndExpression)Expr_335_list.get(0);
		Assert.assertNotNull(AndExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = AndExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final EqualityExpression EqualityExpression_337_Var
		 = (EqualityExpression)Expr_336_list.get(0);
		Assert.assertNotNull(EqualityExpression_337_Var
		);
		final EList<? extends EObject> Expr_337_list = EqualityExpression_337_Var
		.getExpr();
		Assert.assertNotNull(Expr_337_list);
		Assert.assertEquals(1, Expr_337_list.size());
		//337
		final RelationalExpression RelationalExpression_338_Var
		 = (RelationalExpression)Expr_337_list.get(0);
		Assert.assertNotNull(RelationalExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = RelationalExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final ShiftExpression ShiftExpression_339_Var
		 = (ShiftExpression)Expr_338_list.get(0);
		Assert.assertNotNull(ShiftExpression_339_Var
		);
		final EList<? extends EObject> Expr_339_list = ShiftExpression_339_Var
		.getExpr();
		Assert.assertNotNull(Expr_339_list);
		Assert.assertEquals(1, Expr_339_list.size());
		//339
		final AdditiveExpression AdditiveExpression_340_Var
		 = (AdditiveExpression)Expr_339_list.get(0);
		Assert.assertNotNull(AdditiveExpression_340_Var
		);
		final EList<? extends EObject> Expr_340_list = AdditiveExpression_340_Var
		.getExpr();
		Assert.assertNotNull(Expr_340_list);
		Assert.assertEquals(1, Expr_340_list.size());
		//340
		final MultiplicativeExpression MultiplicativeExpression_341_Var
		 = (MultiplicativeExpression)Expr_340_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_341_Var
		);
		final EList<? extends EObject> Expr_341_list = MultiplicativeExpression_341_Var
		.getExpr();
		Assert.assertNotNull(Expr_341_list);
		Assert.assertEquals(1, Expr_341_list.size());
		//341
		final CastExpression CastExpression_342_Var
		 = (CastExpression)Expr_341_list.get(0);
		Assert.assertNotNull(CastExpression_342_Var
		);
		//342
		final UnaryExpression UnaryExpression_343_Var
		 = (UnaryExpression)CastExpression_342_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_343_Var
		);
		//343
		final UnaryOperator UnaryOperator_344_Var
		 = (UnaryOperator)UnaryExpression_343_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_344_Var
		);
		Assert.assertEquals("-", UnaryOperator_344_Var
		.getOp());
		//344
		final CastExpression CastExpression_345_Var
		 = (CastExpression)UnaryExpression_343_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_345_Var
		);
		//345
		final UnaryExpression UnaryExpression_346_Var
		 = (UnaryExpression)CastExpression_345_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_346_Var
		);
		//346
		final PostfixExpression PostfixExpression_347_Var
		 = (PostfixExpression)UnaryExpression_346_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_347_Var
		);
		final EList<? extends EObject> Expr_347_list = PostfixExpression_347_Var
		.getExpr();
		Assert.assertNotNull(Expr_347_list);
		Assert.assertEquals(1, Expr_347_list.size());
		//347
		final PrimaryExpression PrimaryExpression_348_Var
		 = (PrimaryExpression)Expr_347_list.get(0);
		Assert.assertNotNull(PrimaryExpression_348_Var
		);
		Assert.assertEquals("res", PrimaryExpression_348_Var
		.getId());
		//348
		final Statement Statement_349_Var
		 = (Statement)Statement_321_list.get(1);
		Assert.assertNotNull(Statement_349_Var
		);
		//349
		final ExpressionStatement ExpressionStatement_350_Var
		 = (ExpressionStatement)Statement_349_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_350_Var
		);
		//350
		final Expression Expression_351_Var
		 = (Expression)ExpressionStatement_350_Var
		.getExpression();
		Assert.assertNotNull(Expression_351_Var
		);
		final EList<? extends EObject> ExprExpr_351_list = Expression_351_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_351_list);
		Assert.assertEquals(1, ExprExpr_351_list.size());
		//351
		final AssignmentExpression AssignmentExpression_352_Var
		 = (AssignmentExpression)ExprExpr_351_list.get(0);
		Assert.assertNotNull(AssignmentExpression_352_Var
		);
		//352
		final UnaryExpression UnaryExpression_353_Var
		 = (UnaryExpression)AssignmentExpression_352_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_353_Var
		);
		//353
		final PostfixExpression PostfixExpression_354_Var
		 = (PostfixExpression)UnaryExpression_353_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_354_Var
		);
		final EList<? extends EObject> Expr_354_list = PostfixExpression_354_Var
		.getExpr();
		Assert.assertNotNull(Expr_354_list);
		Assert.assertEquals(1, Expr_354_list.size());
		//354
		final PrimaryExpression PrimaryExpression_355_Var
		 = (PrimaryExpression)Expr_354_list.get(0);
		Assert.assertNotNull(PrimaryExpression_355_Var
		);
		Assert.assertEquals("res", PrimaryExpression_355_Var
		.getId());
		//355
		final AssignmentOperator AssignmentOperator_356_Var
		 = (AssignmentOperator)AssignmentExpression_352_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_356_Var
		);
		Assert.assertEquals("=", AssignmentOperator_356_Var
		.getOp());
		//356
		final AssignmentExpression AssignmentExpression_357_Var
		 = (AssignmentExpression)AssignmentExpression_352_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_357_Var
		);
		//357
		final ConditionalExpression ConditionalExpression_358_Var
		 = (ConditionalExpression)AssignmentExpression_357_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_358_Var
		);
		//358
		final LogicalOrExpression LogicalOrExpression_359_Var
		 = (LogicalOrExpression)ConditionalExpression_358_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_359_Var
		);
		final EList<? extends EObject> Expr_359_list = LogicalOrExpression_359_Var
		.getExpr();
		Assert.assertNotNull(Expr_359_list);
		Assert.assertEquals(1, Expr_359_list.size());
		//359
		final LogicalAndExpression LogicalAndExpression_360_Var
		 = (LogicalAndExpression)Expr_359_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_360_Var
		);
		final EList<? extends EObject> Expr_360_list = LogicalAndExpression_360_Var
		.getExpr();
		Assert.assertNotNull(Expr_360_list);
		Assert.assertEquals(1, Expr_360_list.size());
		//360
		final InclusiveOrExpression InclusiveOrExpression_361_Var
		 = (InclusiveOrExpression)Expr_360_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_361_Var
		);
		final EList<? extends EObject> Expr_361_list = InclusiveOrExpression_361_Var
		.getExpr();
		Assert.assertNotNull(Expr_361_list);
		Assert.assertEquals(1, Expr_361_list.size());
		//361
		final ExclusiveOrExpression ExclusiveOrExpression_362_Var
		 = (ExclusiveOrExpression)Expr_361_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_362_Var
		);
		final EList<? extends EObject> Expr_362_list = ExclusiveOrExpression_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(1, Expr_362_list.size());
		//362
		final AndExpression AndExpression_363_Var
		 = (AndExpression)Expr_362_list.get(0);
		Assert.assertNotNull(AndExpression_363_Var
		);
		final EList<? extends EObject> Expr_363_list = AndExpression_363_Var
		.getExpr();
		Assert.assertNotNull(Expr_363_list);
		Assert.assertEquals(1, Expr_363_list.size());
		//363
		final EqualityExpression EqualityExpression_364_Var
		 = (EqualityExpression)Expr_363_list.get(0);
		Assert.assertNotNull(EqualityExpression_364_Var
		);
		final EList<? extends EObject> Expr_364_list = EqualityExpression_364_Var
		.getExpr();
		Assert.assertNotNull(Expr_364_list);
		Assert.assertEquals(1, Expr_364_list.size());
		//364
		final RelationalExpression RelationalExpression_365_Var
		 = (RelationalExpression)Expr_364_list.get(0);
		Assert.assertNotNull(RelationalExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = RelationalExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final ShiftExpression ShiftExpression_366_Var
		 = (ShiftExpression)Expr_365_list.get(0);
		Assert.assertNotNull(ShiftExpression_366_Var
		);
		final EList<? extends EObject> Expr_366_list = ShiftExpression_366_Var
		.getExpr();
		Assert.assertNotNull(Expr_366_list);
		Assert.assertEquals(1, Expr_366_list.size());
		//366
		final AdditiveExpression AdditiveExpression_367_Var
		 = (AdditiveExpression)Expr_366_list.get(0);
		Assert.assertNotNull(AdditiveExpression_367_Var
		);
		final EList<? extends EObject> Expr_367_list = AdditiveExpression_367_Var
		.getExpr();
		Assert.assertNotNull(Expr_367_list);
		Assert.assertEquals(1, Expr_367_list.size());
		//367
		final MultiplicativeExpression MultiplicativeExpression_368_Var
		 = (MultiplicativeExpression)Expr_367_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_368_Var
		);
		final EList<? extends EObject> Expr_368_list = MultiplicativeExpression_368_Var
		.getExpr();
		Assert.assertNotNull(Expr_368_list);
		Assert.assertEquals(1, Expr_368_list.size());
		//368
		final CastExpression CastExpression_369_Var
		 = (CastExpression)Expr_368_list.get(0);
		Assert.assertNotNull(CastExpression_369_Var
		);
		//369
		final UnaryExpression UnaryExpression_370_Var
		 = (UnaryExpression)CastExpression_369_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_370_Var
		);
		//370
		final UnaryOperator UnaryOperator_371_Var
		 = (UnaryOperator)UnaryExpression_370_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_371_Var
		);
		Assert.assertEquals("-", UnaryOperator_371_Var
		.getOp());
		//371
		final CastExpression CastExpression_372_Var
		 = (CastExpression)UnaryExpression_370_Var
		.getExpr();
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
		//375
		final Constant Constant_376_Var
		 = (Constant)PrimaryExpression_375_Var
		.getConst();
		Assert.assertNotNull(Constant_376_Var
		);
		Assert.assertEquals("1", Constant_376_Var
		.getDec());
		//376
		final Statement Statement_377_Var
		 = (Statement)Statement_46_list.get(2);
		Assert.assertNotNull(Statement_377_Var
		);
		//377
		final JumpStatement JumpStatement_378_Var
		 = (JumpStatement)Statement_377_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_378_Var
		);
		//378
		final Expression Expression_379_Var
		 = (Expression)JumpStatement_378_Var
		.getExpr();
		Assert.assertNotNull(Expression_379_Var
		);
		final EList<? extends EObject> ExprExpr_379_list = Expression_379_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_379_list);
		Assert.assertEquals(1, ExprExpr_379_list.size());
		//379
		final AssignmentExpression AssignmentExpression_380_Var
		 = (AssignmentExpression)ExprExpr_379_list.get(0);
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
		Assert.assertEquals("res", PrimaryExpression_395_Var
		.getId());
		Assert.assertEquals("return", JumpStatement_378_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_378_Var
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


