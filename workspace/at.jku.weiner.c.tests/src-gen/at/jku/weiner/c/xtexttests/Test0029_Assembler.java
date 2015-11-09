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
		final EList<? extends EObject> ArgumentExpressionList_80_list = PostfixExpression_78_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_80_list);
		Assert.assertEquals(1, ArgumentExpressionList_80_list.size());
		//80
		final ArgumentExpressionList ArgumentExpressionList_81_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_80_list.get(0);
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
		 = (AsmLineWithComma)AsmLine_48_list.get(2);
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
		final Constant Constant_113_Var
		 = (Constant)PrimaryExpression_112_Var
		.getConst();
		Assert.assertNotNull(Constant_113_Var
		);
		Assert.assertEquals("\"+b\"", Constant_113_Var
		.getStr());
		final EList<? extends EObject> ArgumentExpressionList_113_list = PostfixExpression_111_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_113_list);
		Assert.assertEquals(1, ArgumentExpressionList_113_list.size());
		//113
		final ArgumentExpressionList ArgumentExpressionList_114_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_113_list.get(0);
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
		final AsmLineWithComma AsmLineWithComma_131_Var
		 = (AsmLineWithComma)AsmLine_48_list.get(3);
		Assert.assertNotNull(AsmLineWithComma_131_Var
		);
		//131
		final LogicalOrExpression LogicalOrExpression_132_Var
		 = (LogicalOrExpression)AsmLineWithComma_131_Var
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
		//145
		final Constant Constant_146_Var
		 = (Constant)PrimaryExpression_145_Var
		.getConst();
		Assert.assertNotNull(Constant_146_Var
		);
		Assert.assertEquals("\"+c\"", Constant_146_Var
		.getStr());
		final EList<? extends EObject> ArgumentExpressionList_146_list = PostfixExpression_144_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_146_list);
		Assert.assertEquals(1, ArgumentExpressionList_146_list.size());
		//146
		final ArgumentExpressionList ArgumentExpressionList_147_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_146_list.get(0);
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
		final AsmLineWithComma AsmLineWithComma_164_Var
		 = (AsmLineWithComma)AsmLine_48_list.get(4);
		Assert.assertNotNull(AsmLineWithComma_164_Var
		);
		//164
		final LogicalOrExpression LogicalOrExpression_165_Var
		 = (LogicalOrExpression)AsmLineWithComma_164_Var
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
		final Constant Constant_179_Var
		 = (Constant)PrimaryExpression_178_Var
		.getConst();
		Assert.assertNotNull(Constant_179_Var
		);
		Assert.assertEquals("\"+d\"", Constant_179_Var
		.getStr());
		final EList<? extends EObject> ArgumentExpressionList_179_list = PostfixExpression_177_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_179_list);
		Assert.assertEquals(1, ArgumentExpressionList_179_list.size());
		//179
		final ArgumentExpressionList ArgumentExpressionList_180_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_179_list.get(0);
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
		 = (AsmLineWithColon)AsmLine_48_list.get(5);
		Assert.assertNotNull(AsmLineWithColon_197_Var
		);
		//197
		final LogicalOrExpression LogicalOrExpression_198_Var
		 = (LogicalOrExpression)AsmLineWithColon_197_Var
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
		//211
		final Constant Constant_212_Var
		 = (Constant)PrimaryExpression_211_Var
		.getConst();
		Assert.assertNotNull(Constant_212_Var
		);
		Assert.assertEquals("\"a\"", Constant_212_Var
		.getStr());
		final EList<? extends EObject> ArgumentExpressionList_212_list = PostfixExpression_210_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_212_list);
		Assert.assertEquals(1, ArgumentExpressionList_212_list.size());
		//212
		final ArgumentExpressionList ArgumentExpressionList_213_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_212_list.get(0);
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
		final Constant Constant_230_Var
		 = (Constant)PrimaryExpression_229_Var
		.getConst();
		Assert.assertNotNull(Constant_230_Var
		);
		Assert.assertEquals("128", Constant_230_Var
		.getDec());
		//230
		final AsmLine AsmLine_231_Var
		 = (AsmLine)AsmLine_48_list.get(6);
		Assert.assertNotNull(AsmLine_231_Var
		);
		//231
		final LogicalOrExpression LogicalOrExpression_232_Var
		 = (LogicalOrExpression)AsmLine_231_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = LogicalOrExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final LogicalAndExpression LogicalAndExpression_233_Var
		 = (LogicalAndExpression)Expr_232_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = LogicalAndExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final InclusiveOrExpression InclusiveOrExpression_234_Var
		 = (InclusiveOrExpression)Expr_233_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = InclusiveOrExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final ExclusiveOrExpression ExclusiveOrExpression_235_Var
		 = (ExclusiveOrExpression)Expr_234_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = ExclusiveOrExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final AndExpression AndExpression_236_Var
		 = (AndExpression)Expr_235_list.get(0);
		Assert.assertNotNull(AndExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = AndExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final EqualityExpression EqualityExpression_237_Var
		 = (EqualityExpression)Expr_236_list.get(0);
		Assert.assertNotNull(EqualityExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = EqualityExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final RelationalExpression RelationalExpression_238_Var
		 = (RelationalExpression)Expr_237_list.get(0);
		Assert.assertNotNull(RelationalExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = RelationalExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final ShiftExpression ShiftExpression_239_Var
		 = (ShiftExpression)Expr_238_list.get(0);
		Assert.assertNotNull(ShiftExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = ShiftExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final AdditiveExpression AdditiveExpression_240_Var
		 = (AdditiveExpression)Expr_239_list.get(0);
		Assert.assertNotNull(AdditiveExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = AdditiveExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final MultiplicativeExpression MultiplicativeExpression_241_Var
		 = (MultiplicativeExpression)Expr_240_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = MultiplicativeExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final CastExpression CastExpression_242_Var
		 = (CastExpression)Expr_241_list.get(0);
		Assert.assertNotNull(CastExpression_242_Var
		);
		//242
		final UnaryExpression UnaryExpression_243_Var
		 = (UnaryExpression)CastExpression_242_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_243_Var
		);
		//243
		final PostfixExpression PostfixExpression_244_Var
		 = (PostfixExpression)UnaryExpression_243_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = PostfixExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final PrimaryExpression PrimaryExpression_245_Var
		 = (PrimaryExpression)Expr_244_list.get(0);
		Assert.assertNotNull(PrimaryExpression_245_Var
		);
		//245
		final Constant Constant_246_Var
		 = (Constant)PrimaryExpression_245_Var
		.getConst();
		Assert.assertNotNull(Constant_246_Var
		);
		Assert.assertEquals("\"memory\"", Constant_246_Var
		.getStr());
		//246
		final AsmLineWithComma AsmLineWithComma_247_Var
		 = (AsmLineWithComma)AsmLine_48_list.get(7);
		Assert.assertNotNull(AsmLineWithComma_247_Var
		);
		//247
		final LogicalOrExpression LogicalOrExpression_248_Var
		 = (LogicalOrExpression)AsmLineWithComma_247_Var
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
		//261
		final Constant Constant_262_Var
		 = (Constant)PrimaryExpression_261_Var
		.getConst();
		Assert.assertNotNull(Constant_262_Var
		);
		Assert.assertEquals("\"cc\"", Constant_262_Var
		.getStr());
		Assert.assertEquals(";", AsmStatement_48_Var
		.getSemi());
		//262
		final Statement Statement_263_Var
		 = (Statement)Statement_46_list.get(1);
		Assert.assertNotNull(Statement_263_Var
		);
		//263
		final SelectionStatement SelectionStatement_264_Var
		 = (SelectionStatement)Statement_263_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_264_Var
		);
		Assert.assertEquals("if", SelectionStatement_264_Var
		.getIf());
		//264
		final Expression Expression_265_Var
		 = (Expression)SelectionStatement_264_Var
		.getExpr();
		Assert.assertNotNull(Expression_265_Var
		);
		final EList<? extends EObject> ExprExpr_265_list = Expression_265_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_265_list);
		Assert.assertEquals(1, ExprExpr_265_list.size());
		//265
		final AssignmentExpression AssignmentExpression_266_Var
		 = (AssignmentExpression)ExprExpr_265_list.get(0);
		Assert.assertNotNull(AssignmentExpression_266_Var
		);
		//266
		final ConditionalExpression ConditionalExpression_267_Var
		 = (ConditionalExpression)AssignmentExpression_266_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_267_Var
		);
		//267
		final LogicalOrExpression LogicalOrExpression_268_Var
		 = (LogicalOrExpression)ConditionalExpression_267_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_268_Var
		);
		final EList<? extends EObject> Expr_268_list = LogicalOrExpression_268_Var
		.getExpr();
		Assert.assertNotNull(Expr_268_list);
		Assert.assertEquals(1, Expr_268_list.size());
		//268
		final LogicalAndExpression LogicalAndExpression_269_Var
		 = (LogicalAndExpression)Expr_268_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_269_Var
		);
		final EList<? extends EObject> Expr_269_list = LogicalAndExpression_269_Var
		.getExpr();
		Assert.assertNotNull(Expr_269_list);
		Assert.assertEquals(2, Expr_269_list.size());
		//269
		final InclusiveOrExpression InclusiveOrExpression_270_Var
		 = (InclusiveOrExpression)Expr_269_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_270_Var
		);
		final EList<? extends EObject> Expr_270_list = InclusiveOrExpression_270_Var
		.getExpr();
		Assert.assertNotNull(Expr_270_list);
		Assert.assertEquals(1, Expr_270_list.size());
		//270
		final ExclusiveOrExpression ExclusiveOrExpression_271_Var
		 = (ExclusiveOrExpression)Expr_270_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_271_Var
		);
		final EList<? extends EObject> Expr_271_list = ExclusiveOrExpression_271_Var
		.getExpr();
		Assert.assertNotNull(Expr_271_list);
		Assert.assertEquals(1, Expr_271_list.size());
		//271
		final AndExpression AndExpression_272_Var
		 = (AndExpression)Expr_271_list.get(0);
		Assert.assertNotNull(AndExpression_272_Var
		);
		final EList<? extends EObject> Expr_272_list = AndExpression_272_Var
		.getExpr();
		Assert.assertNotNull(Expr_272_list);
		Assert.assertEquals(1, Expr_272_list.size());
		//272
		final EqualityExpression EqualityExpression_273_Var
		 = (EqualityExpression)Expr_272_list.get(0);
		Assert.assertNotNull(EqualityExpression_273_Var
		);
		final EList<? extends EObject> Expr_273_list = EqualityExpression_273_Var
		.getExpr();
		Assert.assertNotNull(Expr_273_list);
		Assert.assertEquals(1, Expr_273_list.size());
		//273
		final RelationalExpression RelationalExpression_274_Var
		 = (RelationalExpression)Expr_273_list.get(0);
		Assert.assertNotNull(RelationalExpression_274_Var
		);
		Assert.assertEquals("[<=]", RelationalExpression_274_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_274_list = RelationalExpression_274_Var
		.getExpr();
		Assert.assertNotNull(Expr_274_list);
		Assert.assertEquals(2, Expr_274_list.size());
		//274
		final ShiftExpression ShiftExpression_275_Var
		 = (ShiftExpression)Expr_274_list.get(0);
		Assert.assertNotNull(ShiftExpression_275_Var
		);
		final EList<? extends EObject> Expr_275_list = ShiftExpression_275_Var
		.getExpr();
		Assert.assertNotNull(Expr_275_list);
		Assert.assertEquals(1, Expr_275_list.size());
		//275
		final AdditiveExpression AdditiveExpression_276_Var
		 = (AdditiveExpression)Expr_275_list.get(0);
		Assert.assertNotNull(AdditiveExpression_276_Var
		);
		final EList<? extends EObject> Expr_276_list = AdditiveExpression_276_Var
		.getExpr();
		Assert.assertNotNull(Expr_276_list);
		Assert.assertEquals(1, Expr_276_list.size());
		//276
		final MultiplicativeExpression MultiplicativeExpression_277_Var
		 = (MultiplicativeExpression)Expr_276_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_277_Var
		);
		final EList<? extends EObject> Expr_277_list = MultiplicativeExpression_277_Var
		.getExpr();
		Assert.assertNotNull(Expr_277_list);
		Assert.assertEquals(1, Expr_277_list.size());
		//277
		final CastExpression CastExpression_278_Var
		 = (CastExpression)Expr_277_list.get(0);
		Assert.assertNotNull(CastExpression_278_Var
		);
		//278
		final UnaryExpression UnaryExpression_279_Var
		 = (UnaryExpression)CastExpression_278_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_279_Var
		);
		//279
		final CastExpression CastExpression_280_Var
		 = (CastExpression)UnaryExpression_279_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_280_Var
		);
		//280
		final UnaryExpression UnaryExpression_281_Var
		 = (UnaryExpression)CastExpression_280_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_281_Var
		);
		//281
		final PostfixExpression PostfixExpression_282_Var
		 = (PostfixExpression)UnaryExpression_281_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_282_Var
		);
		final EList<? extends EObject> Expr_282_list = PostfixExpression_282_Var
		.getExpr();
		Assert.assertNotNull(Expr_282_list);
		Assert.assertEquals(1, Expr_282_list.size());
		//282
		final PrimaryExpression PrimaryExpression_283_Var
		 = (PrimaryExpression)Expr_282_list.get(0);
		Assert.assertNotNull(PrimaryExpression_283_Var
		);
		//283
		final Constant Constant_284_Var
		 = (Constant)PrimaryExpression_283_Var
		.getConst();
		Assert.assertNotNull(Constant_284_Var
		);
		Assert.assertEquals("125", Constant_284_Var
		.getDec());
		//284
		final UnaryOperator UnaryOperator_285_Var
		 = (UnaryOperator)UnaryExpression_279_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_285_Var
		);
		Assert.assertEquals("-", UnaryOperator_285_Var
		.getOp());
		//285
		final ShiftExpression ShiftExpression_286_Var
		 = (ShiftExpression)Expr_274_list.get(1);
		Assert.assertNotNull(ShiftExpression_286_Var
		);
		final EList<? extends EObject> Expr_286_list = ShiftExpression_286_Var
		.getExpr();
		Assert.assertNotNull(Expr_286_list);
		Assert.assertEquals(1, Expr_286_list.size());
		//286
		final AdditiveExpression AdditiveExpression_287_Var
		 = (AdditiveExpression)Expr_286_list.get(0);
		Assert.assertNotNull(AdditiveExpression_287_Var
		);
		final EList<? extends EObject> Expr_287_list = AdditiveExpression_287_Var
		.getExpr();
		Assert.assertNotNull(Expr_287_list);
		Assert.assertEquals(1, Expr_287_list.size());
		//287
		final MultiplicativeExpression MultiplicativeExpression_288_Var
		 = (MultiplicativeExpression)Expr_287_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_288_Var
		);
		final EList<? extends EObject> Expr_288_list = MultiplicativeExpression_288_Var
		.getExpr();
		Assert.assertNotNull(Expr_288_list);
		Assert.assertEquals(1, Expr_288_list.size());
		//288
		final CastExpression CastExpression_289_Var
		 = (CastExpression)Expr_288_list.get(0);
		Assert.assertNotNull(CastExpression_289_Var
		);
		//289
		final UnaryExpression UnaryExpression_290_Var
		 = (UnaryExpression)CastExpression_289_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_290_Var
		);
		//290
		final PostfixExpression PostfixExpression_291_Var
		 = (PostfixExpression)UnaryExpression_290_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_291_Var
		);
		final EList<? extends EObject> Expr_291_list = PostfixExpression_291_Var
		.getExpr();
		Assert.assertNotNull(Expr_291_list);
		Assert.assertEquals(1, Expr_291_list.size());
		//291
		final PrimaryExpression PrimaryExpression_292_Var
		 = (PrimaryExpression)Expr_291_list.get(0);
		Assert.assertNotNull(PrimaryExpression_292_Var
		);
		Assert.assertEquals("res", PrimaryExpression_292_Var
		.getId());
		//292
		final InclusiveOrExpression InclusiveOrExpression_293_Var
		 = (InclusiveOrExpression)Expr_269_list.get(1);
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
		Assert.assertEquals("[<]", RelationalExpression_297_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_297_list = RelationalExpression_297_Var
		.getExpr();
		Assert.assertNotNull(Expr_297_list);
		Assert.assertEquals(2, Expr_297_list.size());
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
		Assert.assertEquals("res", PrimaryExpression_304_Var
		.getId());
		//304
		final ShiftExpression ShiftExpression_305_Var
		 = (ShiftExpression)Expr_297_list.get(1);
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
		//311
		final Constant Constant_312_Var
		 = (Constant)PrimaryExpression_311_Var
		.getConst();
		Assert.assertNotNull(Constant_312_Var
		);
		Assert.assertEquals("0", Constant_312_Var
		.getDec());
		//312
		final Statement Statement_313_Var
		 = (Statement)SelectionStatement_264_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_313_Var
		);
		//313
		final CompoundStatement CompoundStatement_314_Var
		 = (CompoundStatement)Statement_313_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_314_Var
		);
		//314
		final BodyStatement BodyStatement_315_Var
		 = (BodyStatement)CompoundStatement_314_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_315_Var
		);
		final EList<? extends EObject> BlockList_315_list = BodyStatement_315_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_315_list);
		Assert.assertEquals(1, BlockList_315_list.size());
		//315
		final BlockList BlockList_316_Var
		 = (BlockList)BlockList_315_list.get(0);
		Assert.assertNotNull(BlockList_316_Var
		);
		final EList<? extends EObject> Statement_316_list = BlockList_316_Var
		.getStatement();
		Assert.assertNotNull(Statement_316_list);
		Assert.assertEquals(2, Statement_316_list.size());
		//316
		final Statement Statement_317_Var
		 = (Statement)Statement_316_list.get(0);
		Assert.assertNotNull(Statement_317_Var
		);
		//317
		final ExpressionStatement ExpressionStatement_318_Var
		 = (ExpressionStatement)Statement_317_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_318_Var
		);
		//318
		final Expression Expression_319_Var
		 = (Expression)ExpressionStatement_318_Var
		.getExpression();
		Assert.assertNotNull(Expression_319_Var
		);
		final EList<? extends EObject> ExprExpr_319_list = Expression_319_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_319_list);
		Assert.assertEquals(1, ExprExpr_319_list.size());
		//319
		final AssignmentExpression AssignmentExpression_320_Var
		 = (AssignmentExpression)ExprExpr_319_list.get(0);
		Assert.assertNotNull(AssignmentExpression_320_Var
		);
		//320
		final UnaryExpression UnaryExpression_321_Var
		 = (UnaryExpression)AssignmentExpression_320_Var
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
		Assert.assertEquals("errno", PrimaryExpression_323_Var
		.getId());
		//323
		final AssignmentOperator AssignmentOperator_324_Var
		 = (AssignmentOperator)AssignmentExpression_320_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_324_Var
		);
		Assert.assertEquals("=", AssignmentOperator_324_Var
		.getOp());
		//324
		final AssignmentExpression AssignmentExpression_325_Var
		 = (AssignmentExpression)AssignmentExpression_320_Var
		.getAssignmentExpr();
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
		final UnaryOperator UnaryOperator_339_Var
		 = (UnaryOperator)UnaryExpression_338_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_339_Var
		);
		Assert.assertEquals("-", UnaryOperator_339_Var
		.getOp());
		//339
		final CastExpression CastExpression_340_Var
		 = (CastExpression)UnaryExpression_338_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_340_Var
		);
		//340
		final UnaryExpression UnaryExpression_341_Var
		 = (UnaryExpression)CastExpression_340_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_341_Var
		);
		//341
		final PostfixExpression PostfixExpression_342_Var
		 = (PostfixExpression)UnaryExpression_341_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_342_Var
		);
		final EList<? extends EObject> Expr_342_list = PostfixExpression_342_Var
		.getExpr();
		Assert.assertNotNull(Expr_342_list);
		Assert.assertEquals(1, Expr_342_list.size());
		//342
		final PrimaryExpression PrimaryExpression_343_Var
		 = (PrimaryExpression)Expr_342_list.get(0);
		Assert.assertNotNull(PrimaryExpression_343_Var
		);
		Assert.assertEquals("res", PrimaryExpression_343_Var
		.getId());
		//343
		final Statement Statement_344_Var
		 = (Statement)Statement_316_list.get(1);
		Assert.assertNotNull(Statement_344_Var
		);
		//344
		final ExpressionStatement ExpressionStatement_345_Var
		 = (ExpressionStatement)Statement_344_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_345_Var
		);
		//345
		final Expression Expression_346_Var
		 = (Expression)ExpressionStatement_345_Var
		.getExpression();
		Assert.assertNotNull(Expression_346_Var
		);
		final EList<? extends EObject> ExprExpr_346_list = Expression_346_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_346_list);
		Assert.assertEquals(1, ExprExpr_346_list.size());
		//346
		final AssignmentExpression AssignmentExpression_347_Var
		 = (AssignmentExpression)ExprExpr_346_list.get(0);
		Assert.assertNotNull(AssignmentExpression_347_Var
		);
		//347
		final UnaryExpression UnaryExpression_348_Var
		 = (UnaryExpression)AssignmentExpression_347_Var
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
		final AssignmentOperator AssignmentOperator_351_Var
		 = (AssignmentOperator)AssignmentExpression_347_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_351_Var
		);
		Assert.assertEquals("=", AssignmentOperator_351_Var
		.getOp());
		//351
		final AssignmentExpression AssignmentExpression_352_Var
		 = (AssignmentExpression)AssignmentExpression_347_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_352_Var
		);
		//352
		final ConditionalExpression ConditionalExpression_353_Var
		 = (ConditionalExpression)AssignmentExpression_352_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_353_Var
		);
		//353
		final LogicalOrExpression LogicalOrExpression_354_Var
		 = (LogicalOrExpression)ConditionalExpression_353_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_354_Var
		);
		final EList<? extends EObject> Expr_354_list = LogicalOrExpression_354_Var
		.getExpr();
		Assert.assertNotNull(Expr_354_list);
		Assert.assertEquals(1, Expr_354_list.size());
		//354
		final LogicalAndExpression LogicalAndExpression_355_Var
		 = (LogicalAndExpression)Expr_354_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_355_Var
		);
		final EList<? extends EObject> Expr_355_list = LogicalAndExpression_355_Var
		.getExpr();
		Assert.assertNotNull(Expr_355_list);
		Assert.assertEquals(1, Expr_355_list.size());
		//355
		final InclusiveOrExpression InclusiveOrExpression_356_Var
		 = (InclusiveOrExpression)Expr_355_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_356_Var
		);
		final EList<? extends EObject> Expr_356_list = InclusiveOrExpression_356_Var
		.getExpr();
		Assert.assertNotNull(Expr_356_list);
		Assert.assertEquals(1, Expr_356_list.size());
		//356
		final ExclusiveOrExpression ExclusiveOrExpression_357_Var
		 = (ExclusiveOrExpression)Expr_356_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_357_Var
		);
		final EList<? extends EObject> Expr_357_list = ExclusiveOrExpression_357_Var
		.getExpr();
		Assert.assertNotNull(Expr_357_list);
		Assert.assertEquals(1, Expr_357_list.size());
		//357
		final AndExpression AndExpression_358_Var
		 = (AndExpression)Expr_357_list.get(0);
		Assert.assertNotNull(AndExpression_358_Var
		);
		final EList<? extends EObject> Expr_358_list = AndExpression_358_Var
		.getExpr();
		Assert.assertNotNull(Expr_358_list);
		Assert.assertEquals(1, Expr_358_list.size());
		//358
		final EqualityExpression EqualityExpression_359_Var
		 = (EqualityExpression)Expr_358_list.get(0);
		Assert.assertNotNull(EqualityExpression_359_Var
		);
		final EList<? extends EObject> Expr_359_list = EqualityExpression_359_Var
		.getExpr();
		Assert.assertNotNull(Expr_359_list);
		Assert.assertEquals(1, Expr_359_list.size());
		//359
		final RelationalExpression RelationalExpression_360_Var
		 = (RelationalExpression)Expr_359_list.get(0);
		Assert.assertNotNull(RelationalExpression_360_Var
		);
		final EList<? extends EObject> Expr_360_list = RelationalExpression_360_Var
		.getExpr();
		Assert.assertNotNull(Expr_360_list);
		Assert.assertEquals(1, Expr_360_list.size());
		//360
		final ShiftExpression ShiftExpression_361_Var
		 = (ShiftExpression)Expr_360_list.get(0);
		Assert.assertNotNull(ShiftExpression_361_Var
		);
		final EList<? extends EObject> Expr_361_list = ShiftExpression_361_Var
		.getExpr();
		Assert.assertNotNull(Expr_361_list);
		Assert.assertEquals(1, Expr_361_list.size());
		//361
		final AdditiveExpression AdditiveExpression_362_Var
		 = (AdditiveExpression)Expr_361_list.get(0);
		Assert.assertNotNull(AdditiveExpression_362_Var
		);
		final EList<? extends EObject> Expr_362_list = AdditiveExpression_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(1, Expr_362_list.size());
		//362
		final MultiplicativeExpression MultiplicativeExpression_363_Var
		 = (MultiplicativeExpression)Expr_362_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_363_Var
		);
		final EList<? extends EObject> Expr_363_list = MultiplicativeExpression_363_Var
		.getExpr();
		Assert.assertNotNull(Expr_363_list);
		Assert.assertEquals(1, Expr_363_list.size());
		//363
		final CastExpression CastExpression_364_Var
		 = (CastExpression)Expr_363_list.get(0);
		Assert.assertNotNull(CastExpression_364_Var
		);
		//364
		final UnaryExpression UnaryExpression_365_Var
		 = (UnaryExpression)CastExpression_364_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_365_Var
		);
		//365
		final UnaryOperator UnaryOperator_366_Var
		 = (UnaryOperator)UnaryExpression_365_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_366_Var
		);
		Assert.assertEquals("-", UnaryOperator_366_Var
		.getOp());
		//366
		final CastExpression CastExpression_367_Var
		 = (CastExpression)UnaryExpression_365_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_367_Var
		);
		//367
		final UnaryExpression UnaryExpression_368_Var
		 = (UnaryExpression)CastExpression_367_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_368_Var
		);
		//368
		final PostfixExpression PostfixExpression_369_Var
		 = (PostfixExpression)UnaryExpression_368_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_369_Var
		);
		final EList<? extends EObject> Expr_369_list = PostfixExpression_369_Var
		.getExpr();
		Assert.assertNotNull(Expr_369_list);
		Assert.assertEquals(1, Expr_369_list.size());
		//369
		final PrimaryExpression PrimaryExpression_370_Var
		 = (PrimaryExpression)Expr_369_list.get(0);
		Assert.assertNotNull(PrimaryExpression_370_Var
		);
		//370
		final Constant Constant_371_Var
		 = (Constant)PrimaryExpression_370_Var
		.getConst();
		Assert.assertNotNull(Constant_371_Var
		);
		Assert.assertEquals("1", Constant_371_Var
		.getDec());
		//371
		final Statement Statement_372_Var
		 = (Statement)Statement_46_list.get(2);
		Assert.assertNotNull(Statement_372_Var
		);
		//372
		final JumpStatement JumpStatement_373_Var
		 = (JumpStatement)Statement_372_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_373_Var
		);
		//373
		final Expression Expression_374_Var
		 = (Expression)JumpStatement_373_Var
		.getExpr();
		Assert.assertNotNull(Expression_374_Var
		);
		final EList<? extends EObject> ExprExpr_374_list = Expression_374_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_374_list);
		Assert.assertEquals(1, ExprExpr_374_list.size());
		//374
		final AssignmentExpression AssignmentExpression_375_Var
		 = (AssignmentExpression)ExprExpr_374_list.get(0);
		Assert.assertNotNull(AssignmentExpression_375_Var
		);
		//375
		final ConditionalExpression ConditionalExpression_376_Var
		 = (ConditionalExpression)AssignmentExpression_375_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_376_Var
		);
		//376
		final LogicalOrExpression LogicalOrExpression_377_Var
		 = (LogicalOrExpression)ConditionalExpression_376_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_377_Var
		);
		final EList<? extends EObject> Expr_377_list = LogicalOrExpression_377_Var
		.getExpr();
		Assert.assertNotNull(Expr_377_list);
		Assert.assertEquals(1, Expr_377_list.size());
		//377
		final LogicalAndExpression LogicalAndExpression_378_Var
		 = (LogicalAndExpression)Expr_377_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_378_Var
		);
		final EList<? extends EObject> Expr_378_list = LogicalAndExpression_378_Var
		.getExpr();
		Assert.assertNotNull(Expr_378_list);
		Assert.assertEquals(1, Expr_378_list.size());
		//378
		final InclusiveOrExpression InclusiveOrExpression_379_Var
		 = (InclusiveOrExpression)Expr_378_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_379_Var
		);
		final EList<? extends EObject> Expr_379_list = InclusiveOrExpression_379_Var
		.getExpr();
		Assert.assertNotNull(Expr_379_list);
		Assert.assertEquals(1, Expr_379_list.size());
		//379
		final ExclusiveOrExpression ExclusiveOrExpression_380_Var
		 = (ExclusiveOrExpression)Expr_379_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_380_Var
		);
		final EList<? extends EObject> Expr_380_list = ExclusiveOrExpression_380_Var
		.getExpr();
		Assert.assertNotNull(Expr_380_list);
		Assert.assertEquals(1, Expr_380_list.size());
		//380
		final AndExpression AndExpression_381_Var
		 = (AndExpression)Expr_380_list.get(0);
		Assert.assertNotNull(AndExpression_381_Var
		);
		final EList<? extends EObject> Expr_381_list = AndExpression_381_Var
		.getExpr();
		Assert.assertNotNull(Expr_381_list);
		Assert.assertEquals(1, Expr_381_list.size());
		//381
		final EqualityExpression EqualityExpression_382_Var
		 = (EqualityExpression)Expr_381_list.get(0);
		Assert.assertNotNull(EqualityExpression_382_Var
		);
		final EList<? extends EObject> Expr_382_list = EqualityExpression_382_Var
		.getExpr();
		Assert.assertNotNull(Expr_382_list);
		Assert.assertEquals(1, Expr_382_list.size());
		//382
		final RelationalExpression RelationalExpression_383_Var
		 = (RelationalExpression)Expr_382_list.get(0);
		Assert.assertNotNull(RelationalExpression_383_Var
		);
		final EList<? extends EObject> Expr_383_list = RelationalExpression_383_Var
		.getExpr();
		Assert.assertNotNull(Expr_383_list);
		Assert.assertEquals(1, Expr_383_list.size());
		//383
		final ShiftExpression ShiftExpression_384_Var
		 = (ShiftExpression)Expr_383_list.get(0);
		Assert.assertNotNull(ShiftExpression_384_Var
		);
		final EList<? extends EObject> Expr_384_list = ShiftExpression_384_Var
		.getExpr();
		Assert.assertNotNull(Expr_384_list);
		Assert.assertEquals(1, Expr_384_list.size());
		//384
		final AdditiveExpression AdditiveExpression_385_Var
		 = (AdditiveExpression)Expr_384_list.get(0);
		Assert.assertNotNull(AdditiveExpression_385_Var
		);
		final EList<? extends EObject> Expr_385_list = AdditiveExpression_385_Var
		.getExpr();
		Assert.assertNotNull(Expr_385_list);
		Assert.assertEquals(1, Expr_385_list.size());
		//385
		final MultiplicativeExpression MultiplicativeExpression_386_Var
		 = (MultiplicativeExpression)Expr_385_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_386_Var
		);
		final EList<? extends EObject> Expr_386_list = MultiplicativeExpression_386_Var
		.getExpr();
		Assert.assertNotNull(Expr_386_list);
		Assert.assertEquals(1, Expr_386_list.size());
		//386
		final CastExpression CastExpression_387_Var
		 = (CastExpression)Expr_386_list.get(0);
		Assert.assertNotNull(CastExpression_387_Var
		);
		//387
		final UnaryExpression UnaryExpression_388_Var
		 = (UnaryExpression)CastExpression_387_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_388_Var
		);
		//388
		final PostfixExpression PostfixExpression_389_Var
		 = (PostfixExpression)UnaryExpression_388_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_389_Var
		);
		final EList<? extends EObject> Expr_389_list = PostfixExpression_389_Var
		.getExpr();
		Assert.assertNotNull(Expr_389_list);
		Assert.assertEquals(1, Expr_389_list.size());
		//389
		final PrimaryExpression PrimaryExpression_390_Var
		 = (PrimaryExpression)Expr_389_list.get(0);
		Assert.assertNotNull(PrimaryExpression_390_Var
		);
		Assert.assertEquals("res", PrimaryExpression_390_Var
		.getId());
		Assert.assertEquals("return", JumpStatement_373_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_373_Var
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


