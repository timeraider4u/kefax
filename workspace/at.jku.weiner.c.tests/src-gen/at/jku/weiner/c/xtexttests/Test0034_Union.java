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
import at.jku.weiner.c.c.StructOrUnionSpecifier;
import at.jku.weiner.c.c.StructOrUnion;
import at.jku.weiner.c.c.StructDeclarationList;
import at.jku.weiner.c.c.StructDeclaration;
import at.jku.weiner.c.c.SpecifierQualifierList;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.StructDeclaratorList;
import at.jku.weiner.c.c.StructDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.StructDeclaration;
import at.jku.weiner.c.c.SpecifierQualifierList;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.StructDeclaratorList;
import at.jku.weiner.c.c.StructDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.StructOrUnionSpecifier;
import at.jku.weiner.c.c.StructOrUnion;
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
import at.jku.weiner.c.c.FunctionDefinition;
import at.jku.weiner.c.c.BodyStatement;
import at.jku.weiner.c.c.BlockList;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.Initializer;
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
import at.jku.weiner.c.c.TypeName;
import at.jku.weiner.c.c.SpecifierQualifierList;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
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
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
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
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
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
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
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
import at.jku.weiner.c.c.PostfixExpressionSuffixDot;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
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
import at.jku.weiner.c.c.TypeName;
import at.jku.weiner.c.c.SpecifierQualifierList;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.PostfixExpressionSuffixDot;
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
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
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
import at.jku.weiner.c.c.PostfixExpressionSuffixDot;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
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
import at.jku.weiner.c.c.PostfixExpressionSuffixDot;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
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
import at.jku.weiner.c.c.PostfixExpressionSuffixDot;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.PostfixExpressionSuffixDot;
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
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
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
import at.jku.weiner.c.c.PostfixExpressionSuffixDot;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.ExpressionStatement;
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
import at.jku.weiner.c.c.PostfixExpressionSuffixDot;
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
import at.jku.weiner.c.c.Constant;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0034_Union {
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
			"res/Test0034_Union.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_LINEDIRECTIVE", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_UNION", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_CHAR", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_FLOAT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_RIGHTBRACE", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_UNION", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
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
				"RULE_KW_UNSIGNED", 
				"RULE_WHITESPACE", 
				"RULE_KW_LONG", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTPAREN", 
				"RULE_KW_UNSIGNED", 
				"RULE_WHITESPACE", 
				"RULE_KW_LONG", 
				"RULE_RIGHTPAREN", 
				"RULE_KW_SIZEOF", 
				"RULE_LEFTPAREN", 
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
				"RULE_KW_SIZEOF", 
				"RULE_LEFTPAREN", 
				"RULE_ID", 
				"RULE_DOT", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_KW_SIZEOF", 
				"RULE_LEFTPAREN", 
				"RULE_KW_FLOAT", 
				"RULE_RIGHTPAREN", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_DOT", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_DOT", 
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
				"RULE_DOT", 
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
				"RULE_DOT", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_DOT", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_FLOAT_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_DOT", 
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
				"RULE_DOT", 
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
			"res/Test0034_Union.c");
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
		Assert.assertEquals(3, External_1_list.size());
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
		Assert.assertEquals(1, DeclarationSpecifier_4_list.size());
		//4
		final StructOrUnionSpecifier StructOrUnionSpecifier_5_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_4_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_5_Var
		);
		//5
		final StructOrUnion StructOrUnion_6_Var
		 = (StructOrUnion)StructOrUnionSpecifier_5_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_6_Var
		);
		Assert.assertEquals("union", StructOrUnion_6_Var
		.getName());
		Assert.assertEquals("num", StructOrUnionSpecifier_5_Var
		.getId());
		//6
		final StructDeclarationList StructDeclarationList_7_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_5_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_7_Var
		);
		final EList<? extends EObject> StructDeclaration_7_list = StructDeclarationList_7_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_7_list);
		Assert.assertEquals(2, StructDeclaration_7_list.size());
		//7
		final StructDeclaration StructDeclaration_8_Var
		 = (StructDeclaration)StructDeclaration_7_list.get(0);
		Assert.assertNotNull(StructDeclaration_8_Var
		);
		//8
		final SpecifierQualifierList SpecifierQualifierList_9_Var
		 = (SpecifierQualifierList)StructDeclaration_8_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_9_Var
		);
		final EList<? extends EObject> TypeSpecifier_9_list = SpecifierQualifierList_9_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_9_list);
		Assert.assertEquals(1, TypeSpecifier_9_list.size());
		//9
		final TypeSpecifier TypeSpecifier_10_Var
		 = (TypeSpecifier)TypeSpecifier_9_list.get(0);
		Assert.assertNotNull(TypeSpecifier_10_Var
		);
		Assert.assertEquals("char", TypeSpecifier_10_Var
		.getName());
		//10
		final StructDeclaratorList StructDeclaratorList_11_Var
		 = (StructDeclaratorList)StructDeclaration_8_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_11_Var
		);
		final EList<? extends EObject> StructDeclarator_11_list = StructDeclaratorList_11_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_11_list);
		Assert.assertEquals(1, StructDeclarator_11_list.size());
		//11
		final StructDeclarator StructDeclarator_12_Var
		 = (StructDeclarator)StructDeclarator_11_list.get(0);
		Assert.assertNotNull(StructDeclarator_12_Var
		);
		//12
		final Declarator Declarator_13_Var
		 = (Declarator)StructDeclarator_12_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_13_Var
		);
		//13
		final DirectDeclarator DirectDeclarator_14_Var
		 = (DirectDeclarator)Declarator_13_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_14_Var
		);
		Assert.assertEquals("numChar", DirectDeclarator_14_Var
		.getId());
		//14
		final StructDeclaration StructDeclaration_15_Var
		 = (StructDeclaration)StructDeclaration_7_list.get(1);
		Assert.assertNotNull(StructDeclaration_15_Var
		);
		//15
		final SpecifierQualifierList SpecifierQualifierList_16_Var
		 = (SpecifierQualifierList)StructDeclaration_15_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_16_Var
		);
		final EList<? extends EObject> TypeSpecifier_16_list = SpecifierQualifierList_16_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_16_list);
		Assert.assertEquals(1, TypeSpecifier_16_list.size());
		//16
		final TypeSpecifier TypeSpecifier_17_Var
		 = (TypeSpecifier)TypeSpecifier_16_list.get(0);
		Assert.assertNotNull(TypeSpecifier_17_Var
		);
		Assert.assertEquals("float", TypeSpecifier_17_Var
		.getName());
		//17
		final StructDeclaratorList StructDeclaratorList_18_Var
		 = (StructDeclaratorList)StructDeclaration_15_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_18_Var
		);
		final EList<? extends EObject> StructDeclarator_18_list = StructDeclaratorList_18_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_18_list);
		Assert.assertEquals(1, StructDeclarator_18_list.size());
		//18
		final StructDeclarator StructDeclarator_19_Var
		 = (StructDeclarator)StructDeclarator_18_list.get(0);
		Assert.assertNotNull(StructDeclarator_19_Var
		);
		//19
		final Declarator Declarator_20_Var
		 = (Declarator)StructDeclarator_19_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_20_Var
		);
		//20
		final DirectDeclarator DirectDeclarator_21_Var
		 = (DirectDeclarator)Declarator_20_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_21_Var
		);
		Assert.assertEquals("numFloat", DirectDeclarator_21_Var
		.getId());
		//21
		final ExternalDeclaration ExternalDeclaration_22_Var
		 = (ExternalDeclaration)External_1_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_22_Var
		);
		//22
		final Declaration Declaration_23_Var
		 = (Declaration)ExternalDeclaration_22_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_23_Var
		);
		//23
		final DeclarationSpecifiers DeclarationSpecifiers_24_Var
		 = (DeclarationSpecifiers)Declaration_23_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_24_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_24_list = DeclarationSpecifiers_24_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_24_list);
		Assert.assertEquals(1, DeclarationSpecifier_24_list.size());
		//24
		final StructOrUnionSpecifier StructOrUnionSpecifier_25_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_24_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_25_Var
		);
		//25
		final StructOrUnion StructOrUnion_26_Var
		 = (StructOrUnion)StructOrUnionSpecifier_25_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_26_Var
		);
		Assert.assertEquals("union", StructOrUnion_26_Var
		.getName());
		Assert.assertEquals("num", StructOrUnionSpecifier_25_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_26_list = Declaration_23_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_26_list);
		Assert.assertEquals(1, InitDeclaratorList_26_list.size());
		//26
		final InitDeclaratorList InitDeclaratorList_27_Var
		 = (InitDeclaratorList)InitDeclaratorList_26_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_27_Var
		);
		final EList<? extends EObject> InitDeclarator_27_list = InitDeclaratorList_27_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_27_list);
		Assert.assertEquals(1, InitDeclarator_27_list.size());
		//27
		final InitDeclarator InitDeclarator_28_Var
		 = (InitDeclarator)InitDeclarator_27_list.get(0);
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
		Assert.assertEquals("number", DirectDeclarator_30_Var
		.getId());
		//30
		final ExternalDeclaration ExternalDeclaration_31_Var
		 = (ExternalDeclaration)External_1_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_31_Var
		);
		//31
		final FunctionDefHead FunctionDefHead_32_Var
		 = (FunctionDefHead)ExternalDeclaration_31_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_32_Var
		);
		//32
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_33_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_32_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_33_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_33_list = FunctionDeclarationSpecifiers_33_Var
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
		 = (Declarator)FunctionDefHead_32_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_35_Var
		);
		//35
		final DirectDeclarator DirectDeclarator_36_Var
		 = (DirectDeclarator)Declarator_35_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_36_Var
		);
		Assert.assertEquals("main", DirectDeclarator_36_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_36_list = DirectDeclarator_36_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_36_list);
		Assert.assertEquals(1, DeclaratorSuffix_36_list.size());
		//36
		final DeclaratorSuffix DeclaratorSuffix_37_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_36_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_37_Var
		);
		//37
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_38_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_37_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_38_Var
		);
		final EList<? extends EObject> ParameterTypeList_38_list = DirectDeclaratorLastSuffix_38_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_38_list);
		Assert.assertEquals(1, ParameterTypeList_38_list.size());
		//38
		final ParameterTypeList ParameterTypeList_39_Var
		 = (ParameterTypeList)ParameterTypeList_38_list.get(0);
		Assert.assertNotNull(ParameterTypeList_39_Var
		);
		//39
		final ParameterList ParameterList_40_Var
		 = (ParameterList)ParameterTypeList_39_Var
		.getList();
		Assert.assertNotNull(ParameterList_40_Var
		);
		final EList<? extends EObject> ParameterDeclaration_40_list = ParameterList_40_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_40_list);
		Assert.assertEquals(1, ParameterDeclaration_40_list.size());
		//40
		final ParameterDeclaration ParameterDeclaration_41_Var
		 = (ParameterDeclaration)ParameterDeclaration_40_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_41_Var
		);
		//41
		final DeclarationSpecifiers DeclarationSpecifiers_42_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_41_Var
		.getDeclSpecifiers();
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
		Assert.assertEquals("void", TypeSpecifier_43_Var
		.getName());
		//43
		final FunctionDefinition FunctionDefinition_44_Var
		 = (FunctionDefinition)ExternalDeclaration_31_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_44_Var
		);
		//44
		final BodyStatement BodyStatement_45_Var
		 = (BodyStatement)FunctionDefinition_44_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_45_Var
		);
		final EList<? extends EObject> BlockList_45_list = BodyStatement_45_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_45_list);
		Assert.assertEquals(1, BlockList_45_list.size());
		//45
		final BlockList BlockList_46_Var
		 = (BlockList)BlockList_45_list.get(0);
		Assert.assertNotNull(BlockList_46_Var
		);
		final EList<? extends EObject> Declaration_46_list = BlockList_46_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_46_list);
		Assert.assertEquals(1, Declaration_46_list.size());
		//46
		final Declaration Declaration_47_Var
		 = (Declaration)Declaration_46_list.get(0);
		Assert.assertNotNull(Declaration_47_Var
		);
		//47
		final DeclarationSpecifiers DeclarationSpecifiers_48_Var
		 = (DeclarationSpecifiers)Declaration_47_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_48_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_48_list = DeclarationSpecifiers_48_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_48_list);
		Assert.assertEquals(2, DeclarationSpecifier_48_list.size());
		//48
		final TypeSpecifier TypeSpecifier_49_Var
		 = (TypeSpecifier)DeclarationSpecifier_48_list.get(0);
		Assert.assertNotNull(TypeSpecifier_49_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_49_Var
		.getName());
		//49
		final TypeSpecifier TypeSpecifier_50_Var
		 = (TypeSpecifier)DeclarationSpecifier_48_list.get(1);
		Assert.assertNotNull(TypeSpecifier_50_Var
		);
		Assert.assertEquals("long", TypeSpecifier_50_Var
		.getName());
		final EList<? extends EObject> InitDeclaratorList_50_list = Declaration_47_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_50_list);
		Assert.assertEquals(1, InitDeclaratorList_50_list.size());
		//50
		final InitDeclaratorList InitDeclaratorList_51_Var
		 = (InitDeclaratorList)InitDeclaratorList_50_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_51_Var
		);
		final EList<? extends EObject> InitDeclarator_51_list = InitDeclaratorList_51_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_51_list);
		Assert.assertEquals(1, InitDeclarator_51_list.size());
		//51
		final InitDeclarator InitDeclarator_52_Var
		 = (InitDeclarator)InitDeclarator_51_list.get(0);
		Assert.assertNotNull(InitDeclarator_52_Var
		);
		//52
		final Declarator Declarator_53_Var
		 = (Declarator)InitDeclarator_52_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_53_Var
		);
		//53
		final DirectDeclarator DirectDeclarator_54_Var
		 = (DirectDeclarator)Declarator_53_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_54_Var
		);
		Assert.assertEquals("size", DirectDeclarator_54_Var
		.getId());
		//54
		final Initializer Initializer_55_Var
		 = (Initializer)InitDeclarator_52_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_55_Var
		);
		//55
		final AssignmentExpression AssignmentExpression_56_Var
		 = (AssignmentExpression)Initializer_55_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_56_Var
		);
		//56
		final ConditionalExpression ConditionalExpression_57_Var
		 = (ConditionalExpression)AssignmentExpression_56_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_57_Var
		);
		//57
		final LogicalOrExpression LogicalOrExpression_58_Var
		 = (LogicalOrExpression)ConditionalExpression_57_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_58_Var
		);
		final EList<? extends EObject> Expr_58_list = LogicalOrExpression_58_Var
		.getExpr();
		Assert.assertNotNull(Expr_58_list);
		Assert.assertEquals(1, Expr_58_list.size());
		//58
		final LogicalAndExpression LogicalAndExpression_59_Var
		 = (LogicalAndExpression)Expr_58_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = LogicalAndExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final InclusiveOrExpression InclusiveOrExpression_60_Var
		 = (InclusiveOrExpression)Expr_59_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = InclusiveOrExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final ExclusiveOrExpression ExclusiveOrExpression_61_Var
		 = (ExclusiveOrExpression)Expr_60_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = ExclusiveOrExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final AndExpression AndExpression_62_Var
		 = (AndExpression)Expr_61_list.get(0);
		Assert.assertNotNull(AndExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = AndExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final EqualityExpression EqualityExpression_63_Var
		 = (EqualityExpression)Expr_62_list.get(0);
		Assert.assertNotNull(EqualityExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = EqualityExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final RelationalExpression RelationalExpression_64_Var
		 = (RelationalExpression)Expr_63_list.get(0);
		Assert.assertNotNull(RelationalExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = RelationalExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final ShiftExpression ShiftExpression_65_Var
		 = (ShiftExpression)Expr_64_list.get(0);
		Assert.assertNotNull(ShiftExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = ShiftExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final AdditiveExpression AdditiveExpression_66_Var
		 = (AdditiveExpression)Expr_65_list.get(0);
		Assert.assertNotNull(AdditiveExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = AdditiveExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final MultiplicativeExpression MultiplicativeExpression_67_Var
		 = (MultiplicativeExpression)Expr_66_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = MultiplicativeExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final CastExpression CastExpression_68_Var
		 = (CastExpression)Expr_67_list.get(0);
		Assert.assertNotNull(CastExpression_68_Var
		);
		//68
		final TypeName TypeName_69_Var
		 = (TypeName)CastExpression_68_Var
		.getType();
		Assert.assertNotNull(TypeName_69_Var
		);
		//69
		final SpecifierQualifierList SpecifierQualifierList_70_Var
		 = (SpecifierQualifierList)TypeName_69_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_70_Var
		);
		final EList<? extends EObject> TypeSpecifier_70_list = SpecifierQualifierList_70_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_70_list);
		Assert.assertEquals(2, TypeSpecifier_70_list.size());
		//70
		final TypeSpecifier TypeSpecifier_71_Var
		 = (TypeSpecifier)TypeSpecifier_70_list.get(0);
		Assert.assertNotNull(TypeSpecifier_71_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_71_Var
		.getName());
		//71
		final TypeSpecifier TypeSpecifier_72_Var
		 = (TypeSpecifier)TypeSpecifier_70_list.get(1);
		Assert.assertNotNull(TypeSpecifier_72_Var
		);
		Assert.assertEquals("long", TypeSpecifier_72_Var
		.getName());
		//72
		final CastExpression CastExpression_73_Var
		 = (CastExpression)CastExpression_68_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_73_Var
		);
		//73
		final UnaryExpression UnaryExpression_74_Var
		 = (UnaryExpression)CastExpression_73_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_74_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_74_Var
		.getSizeOf());
		//74
		final UnaryExpression UnaryExpression_75_Var
		 = (UnaryExpression)UnaryExpression_74_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_75_Var
		);
		//75
		final PostfixExpression PostfixExpression_76_Var
		 = (PostfixExpression)UnaryExpression_75_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = PostfixExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final PrimaryExpression PrimaryExpression_77_Var
		 = (PrimaryExpression)Expr_76_list.get(0);
		Assert.assertNotNull(PrimaryExpression_77_Var
		);
		//77
		final Expression Expression_78_Var
		 = (Expression)PrimaryExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expression_78_Var
		);
		final EList<? extends EObject> ExprExpr_78_list = Expression_78_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_78_list);
		Assert.assertEquals(1, ExprExpr_78_list.size());
		//78
		final AssignmentExpression AssignmentExpression_79_Var
		 = (AssignmentExpression)ExprExpr_78_list.get(0);
		Assert.assertNotNull(AssignmentExpression_79_Var
		);
		//79
		final ConditionalExpression ConditionalExpression_80_Var
		 = (ConditionalExpression)AssignmentExpression_79_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_80_Var
		);
		//80
		final LogicalOrExpression LogicalOrExpression_81_Var
		 = (LogicalOrExpression)ConditionalExpression_80_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = LogicalOrExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final LogicalAndExpression LogicalAndExpression_82_Var
		 = (LogicalAndExpression)Expr_81_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = LogicalAndExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final InclusiveOrExpression InclusiveOrExpression_83_Var
		 = (InclusiveOrExpression)Expr_82_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = InclusiveOrExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final ExclusiveOrExpression ExclusiveOrExpression_84_Var
		 = (ExclusiveOrExpression)Expr_83_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = ExclusiveOrExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final AndExpression AndExpression_85_Var
		 = (AndExpression)Expr_84_list.get(0);
		Assert.assertNotNull(AndExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = AndExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final EqualityExpression EqualityExpression_86_Var
		 = (EqualityExpression)Expr_85_list.get(0);
		Assert.assertNotNull(EqualityExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = EqualityExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final RelationalExpression RelationalExpression_87_Var
		 = (RelationalExpression)Expr_86_list.get(0);
		Assert.assertNotNull(RelationalExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = RelationalExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final ShiftExpression ShiftExpression_88_Var
		 = (ShiftExpression)Expr_87_list.get(0);
		Assert.assertNotNull(ShiftExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = ShiftExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final AdditiveExpression AdditiveExpression_89_Var
		 = (AdditiveExpression)Expr_88_list.get(0);
		Assert.assertNotNull(AdditiveExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = AdditiveExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final MultiplicativeExpression MultiplicativeExpression_90_Var
		 = (MultiplicativeExpression)Expr_89_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = MultiplicativeExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final CastExpression CastExpression_91_Var
		 = (CastExpression)Expr_90_list.get(0);
		Assert.assertNotNull(CastExpression_91_Var
		);
		//91
		final UnaryExpression UnaryExpression_92_Var
		 = (UnaryExpression)CastExpression_91_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_92_Var
		);
		//92
		final PostfixExpression PostfixExpression_93_Var
		 = (PostfixExpression)UnaryExpression_92_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_93_Var
		);
		final EList<? extends EObject> Expr_93_list = PostfixExpression_93_Var
		.getExpr();
		Assert.assertNotNull(Expr_93_list);
		Assert.assertEquals(1, Expr_93_list.size());
		//93
		final PrimaryExpression PrimaryExpression_94_Var
		 = (PrimaryExpression)Expr_93_list.get(0);
		Assert.assertNotNull(PrimaryExpression_94_Var
		);
		Assert.assertEquals("number", PrimaryExpression_94_Var
		.getId());
		final EList<? extends EObject> Statement_94_list = BlockList_46_Var
		.getStatement();
		Assert.assertNotNull(Statement_94_list);
		Assert.assertEquals(11, Statement_94_list.size());
		//94
		final Statement Statement_95_Var
		 = (Statement)Statement_94_list.get(0);
		Assert.assertNotNull(Statement_95_Var
		);
		//95
		final ExpressionStatement ExpressionStatement_96_Var
		 = (ExpressionStatement)Statement_95_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_96_Var
		);
		//96
		final Expression Expression_97_Var
		 = (Expression)ExpressionStatement_96_Var
		.getExpression();
		Assert.assertNotNull(Expression_97_Var
		);
		final EList<? extends EObject> ExprExpr_97_list = Expression_97_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_97_list);
		Assert.assertEquals(1, ExprExpr_97_list.size());
		//97
		final AssignmentExpression AssignmentExpression_98_Var
		 = (AssignmentExpression)ExprExpr_97_list.get(0);
		Assert.assertNotNull(AssignmentExpression_98_Var
		);
		//98
		final ConditionalExpression ConditionalExpression_99_Var
		 = (ConditionalExpression)AssignmentExpression_98_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_99_Var
		);
		//99
		final LogicalOrExpression LogicalOrExpression_100_Var
		 = (LogicalOrExpression)ConditionalExpression_99_Var
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
		Assert.assertEquals("printf", PrimaryExpression_113_Var
		.getId());
		final EList<? extends EObject> Suffix_113_list = PostfixExpression_112_Var
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
		Assert.assertEquals(2, Expr_115_list.size());
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
		//131
		final Constant Constant_132_Var
		 = (Constant)PrimaryExpression_131_Var
		.getConst();
		Assert.assertNotNull(Constant_132_Var
		);
		Assert.assertEquals("\"sizeof(number)=%lu\\n\"", Constant_132_Var
		.getStr());
		//132
		final AssignmentExpression AssignmentExpression_133_Var
		 = (AssignmentExpression)Expr_115_list.get(1);
		Assert.assertNotNull(AssignmentExpression_133_Var
		);
		//133
		final ConditionalExpression ConditionalExpression_134_Var
		 = (ConditionalExpression)AssignmentExpression_133_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_134_Var
		);
		//134
		final LogicalOrExpression LogicalOrExpression_135_Var
		 = (LogicalOrExpression)ConditionalExpression_134_Var
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
		Assert.assertEquals("size", PrimaryExpression_148_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_96_Var
		.getSemi());
		//148
		final Statement Statement_149_Var
		 = (Statement)Statement_94_list.get(1);
		Assert.assertNotNull(Statement_149_Var
		);
		//149
		final ExpressionStatement ExpressionStatement_150_Var
		 = (ExpressionStatement)Statement_149_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_150_Var
		);
		//150
		final Expression Expression_151_Var
		 = (Expression)ExpressionStatement_150_Var
		.getExpression();
		Assert.assertNotNull(Expression_151_Var
		);
		final EList<? extends EObject> ExprExpr_151_list = Expression_151_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_151_list);
		Assert.assertEquals(1, ExprExpr_151_list.size());
		//151
		final AssignmentExpression AssignmentExpression_152_Var
		 = (AssignmentExpression)ExprExpr_151_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_167_Var
		.getId());
		final EList<? extends EObject> Suffix_167_list = PostfixExpression_166_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_167_list);
		Assert.assertEquals(1, Suffix_167_list.size());
		//167
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_168_Var
		 = (PostfixExpressionSuffixArgument)Suffix_167_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_168_Var
		);
		//168
		final ArgumentExpressionList ArgumentExpressionList_169_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_168_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_169_Var
		);
		final EList<? extends EObject> Expr_169_list = ArgumentExpressionList_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(2, Expr_169_list.size());
		//169
		final AssignmentExpression AssignmentExpression_170_Var
		 = (AssignmentExpression)Expr_169_list.get(0);
		Assert.assertNotNull(AssignmentExpression_170_Var
		);
		//170
		final ConditionalExpression ConditionalExpression_171_Var
		 = (ConditionalExpression)AssignmentExpression_170_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_171_Var
		);
		//171
		final LogicalOrExpression LogicalOrExpression_172_Var
		 = (LogicalOrExpression)ConditionalExpression_171_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = LogicalOrExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final LogicalAndExpression LogicalAndExpression_173_Var
		 = (LogicalAndExpression)Expr_172_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = LogicalAndExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final InclusiveOrExpression InclusiveOrExpression_174_Var
		 = (InclusiveOrExpression)Expr_173_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = InclusiveOrExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final ExclusiveOrExpression ExclusiveOrExpression_175_Var
		 = (ExclusiveOrExpression)Expr_174_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = ExclusiveOrExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final AndExpression AndExpression_176_Var
		 = (AndExpression)Expr_175_list.get(0);
		Assert.assertNotNull(AndExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = AndExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final EqualityExpression EqualityExpression_177_Var
		 = (EqualityExpression)Expr_176_list.get(0);
		Assert.assertNotNull(EqualityExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = EqualityExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final RelationalExpression RelationalExpression_178_Var
		 = (RelationalExpression)Expr_177_list.get(0);
		Assert.assertNotNull(RelationalExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = RelationalExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final ShiftExpression ShiftExpression_179_Var
		 = (ShiftExpression)Expr_178_list.get(0);
		Assert.assertNotNull(ShiftExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = ShiftExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final AdditiveExpression AdditiveExpression_180_Var
		 = (AdditiveExpression)Expr_179_list.get(0);
		Assert.assertNotNull(AdditiveExpression_180_Var
		);
		final EList<? extends EObject> Expr_180_list = AdditiveExpression_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final MultiplicativeExpression MultiplicativeExpression_181_Var
		 = (MultiplicativeExpression)Expr_180_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_181_Var
		);
		final EList<? extends EObject> Expr_181_list = MultiplicativeExpression_181_Var
		.getExpr();
		Assert.assertNotNull(Expr_181_list);
		Assert.assertEquals(1, Expr_181_list.size());
		//181
		final CastExpression CastExpression_182_Var
		 = (CastExpression)Expr_181_list.get(0);
		Assert.assertNotNull(CastExpression_182_Var
		);
		//182
		final UnaryExpression UnaryExpression_183_Var
		 = (UnaryExpression)CastExpression_182_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_183_Var
		);
		//183
		final PostfixExpression PostfixExpression_184_Var
		 = (PostfixExpression)UnaryExpression_183_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = PostfixExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final PrimaryExpression PrimaryExpression_185_Var
		 = (PrimaryExpression)Expr_184_list.get(0);
		Assert.assertNotNull(PrimaryExpression_185_Var
		);
		//185
		final Constant Constant_186_Var
		 = (Constant)PrimaryExpression_185_Var
		.getConst();
		Assert.assertNotNull(Constant_186_Var
		);
		Assert.assertEquals("\"sizeof(number.numChar)=%lu\\n\"", Constant_186_Var
		.getStr());
		//186
		final AssignmentExpression AssignmentExpression_187_Var
		 = (AssignmentExpression)Expr_169_list.get(1);
		Assert.assertNotNull(AssignmentExpression_187_Var
		);
		//187
		final ConditionalExpression ConditionalExpression_188_Var
		 = (ConditionalExpression)AssignmentExpression_187_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_188_Var
		);
		//188
		final LogicalOrExpression LogicalOrExpression_189_Var
		 = (LogicalOrExpression)ConditionalExpression_188_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = LogicalOrExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final LogicalAndExpression LogicalAndExpression_190_Var
		 = (LogicalAndExpression)Expr_189_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = LogicalAndExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final InclusiveOrExpression InclusiveOrExpression_191_Var
		 = (InclusiveOrExpression)Expr_190_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_191_Var
		);
		final EList<? extends EObject> Expr_191_list = InclusiveOrExpression_191_Var
		.getExpr();
		Assert.assertNotNull(Expr_191_list);
		Assert.assertEquals(1, Expr_191_list.size());
		//191
		final ExclusiveOrExpression ExclusiveOrExpression_192_Var
		 = (ExclusiveOrExpression)Expr_191_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = ExclusiveOrExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final AndExpression AndExpression_193_Var
		 = (AndExpression)Expr_192_list.get(0);
		Assert.assertNotNull(AndExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = AndExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final EqualityExpression EqualityExpression_194_Var
		 = (EqualityExpression)Expr_193_list.get(0);
		Assert.assertNotNull(EqualityExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = EqualityExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final RelationalExpression RelationalExpression_195_Var
		 = (RelationalExpression)Expr_194_list.get(0);
		Assert.assertNotNull(RelationalExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = RelationalExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final ShiftExpression ShiftExpression_196_Var
		 = (ShiftExpression)Expr_195_list.get(0);
		Assert.assertNotNull(ShiftExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = ShiftExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final AdditiveExpression AdditiveExpression_197_Var
		 = (AdditiveExpression)Expr_196_list.get(0);
		Assert.assertNotNull(AdditiveExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = AdditiveExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final MultiplicativeExpression MultiplicativeExpression_198_Var
		 = (MultiplicativeExpression)Expr_197_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = MultiplicativeExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final CastExpression CastExpression_199_Var
		 = (CastExpression)Expr_198_list.get(0);
		Assert.assertNotNull(CastExpression_199_Var
		);
		//199
		final UnaryExpression UnaryExpression_200_Var
		 = (UnaryExpression)CastExpression_199_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_200_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_200_Var
		.getSizeOf());
		//200
		final UnaryExpression UnaryExpression_201_Var
		 = (UnaryExpression)UnaryExpression_200_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_201_Var
		);
		//201
		final PostfixExpression PostfixExpression_202_Var
		 = (PostfixExpression)UnaryExpression_201_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_202_Var
		);
		final EList<? extends EObject> Expr_202_list = PostfixExpression_202_Var
		.getExpr();
		Assert.assertNotNull(Expr_202_list);
		Assert.assertEquals(1, Expr_202_list.size());
		//202
		final PrimaryExpression PrimaryExpression_203_Var
		 = (PrimaryExpression)Expr_202_list.get(0);
		Assert.assertNotNull(PrimaryExpression_203_Var
		);
		//203
		final Expression Expression_204_Var
		 = (Expression)PrimaryExpression_203_Var
		.getExpr();
		Assert.assertNotNull(Expression_204_Var
		);
		final EList<? extends EObject> ExprExpr_204_list = Expression_204_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_204_list);
		Assert.assertEquals(1, ExprExpr_204_list.size());
		//204
		final AssignmentExpression AssignmentExpression_205_Var
		 = (AssignmentExpression)ExprExpr_204_list.get(0);
		Assert.assertNotNull(AssignmentExpression_205_Var
		);
		//205
		final ConditionalExpression ConditionalExpression_206_Var
		 = (ConditionalExpression)AssignmentExpression_205_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_206_Var
		);
		//206
		final LogicalOrExpression LogicalOrExpression_207_Var
		 = (LogicalOrExpression)ConditionalExpression_206_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = LogicalOrExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final LogicalAndExpression LogicalAndExpression_208_Var
		 = (LogicalAndExpression)Expr_207_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = LogicalAndExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final InclusiveOrExpression InclusiveOrExpression_209_Var
		 = (InclusiveOrExpression)Expr_208_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = InclusiveOrExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final ExclusiveOrExpression ExclusiveOrExpression_210_Var
		 = (ExclusiveOrExpression)Expr_209_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = ExclusiveOrExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final AndExpression AndExpression_211_Var
		 = (AndExpression)Expr_210_list.get(0);
		Assert.assertNotNull(AndExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = AndExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final EqualityExpression EqualityExpression_212_Var
		 = (EqualityExpression)Expr_211_list.get(0);
		Assert.assertNotNull(EqualityExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = EqualityExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final RelationalExpression RelationalExpression_213_Var
		 = (RelationalExpression)Expr_212_list.get(0);
		Assert.assertNotNull(RelationalExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = RelationalExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final ShiftExpression ShiftExpression_214_Var
		 = (ShiftExpression)Expr_213_list.get(0);
		Assert.assertNotNull(ShiftExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = ShiftExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final AdditiveExpression AdditiveExpression_215_Var
		 = (AdditiveExpression)Expr_214_list.get(0);
		Assert.assertNotNull(AdditiveExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = AdditiveExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final MultiplicativeExpression MultiplicativeExpression_216_Var
		 = (MultiplicativeExpression)Expr_215_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = MultiplicativeExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final CastExpression CastExpression_217_Var
		 = (CastExpression)Expr_216_list.get(0);
		Assert.assertNotNull(CastExpression_217_Var
		);
		//217
		final UnaryExpression UnaryExpression_218_Var
		 = (UnaryExpression)CastExpression_217_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_218_Var
		);
		//218
		final PostfixExpression PostfixExpression_219_Var
		 = (PostfixExpression)UnaryExpression_218_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = PostfixExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final PrimaryExpression PrimaryExpression_220_Var
		 = (PrimaryExpression)Expr_219_list.get(0);
		Assert.assertNotNull(PrimaryExpression_220_Var
		);
		Assert.assertEquals("number", PrimaryExpression_220_Var
		.getId());
		final EList<? extends EObject> Suffix_220_list = PostfixExpression_219_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_220_list);
		Assert.assertEquals(1, Suffix_220_list.size());
		//220
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_221_Var
		 = (PostfixExpressionSuffixDot)Suffix_220_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_221_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_221_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_150_Var
		.getSemi());
		//221
		final Statement Statement_222_Var
		 = (Statement)Statement_94_list.get(2);
		Assert.assertNotNull(Statement_222_Var
		);
		//222
		final ExpressionStatement ExpressionStatement_223_Var
		 = (ExpressionStatement)Statement_222_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_223_Var
		);
		//223
		final Expression Expression_224_Var
		 = (Expression)ExpressionStatement_223_Var
		.getExpression();
		Assert.assertNotNull(Expression_224_Var
		);
		final EList<? extends EObject> ExprExpr_224_list = Expression_224_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_224_list);
		Assert.assertEquals(1, ExprExpr_224_list.size());
		//224
		final AssignmentExpression AssignmentExpression_225_Var
		 = (AssignmentExpression)ExprExpr_224_list.get(0);
		Assert.assertNotNull(AssignmentExpression_225_Var
		);
		//225
		final ConditionalExpression ConditionalExpression_226_Var
		 = (ConditionalExpression)AssignmentExpression_225_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_226_Var
		);
		//226
		final LogicalOrExpression LogicalOrExpression_227_Var
		 = (LogicalOrExpression)ConditionalExpression_226_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = LogicalOrExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final LogicalAndExpression LogicalAndExpression_228_Var
		 = (LogicalAndExpression)Expr_227_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = LogicalAndExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final InclusiveOrExpression InclusiveOrExpression_229_Var
		 = (InclusiveOrExpression)Expr_228_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = InclusiveOrExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final ExclusiveOrExpression ExclusiveOrExpression_230_Var
		 = (ExclusiveOrExpression)Expr_229_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = ExclusiveOrExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final AndExpression AndExpression_231_Var
		 = (AndExpression)Expr_230_list.get(0);
		Assert.assertNotNull(AndExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = AndExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final EqualityExpression EqualityExpression_232_Var
		 = (EqualityExpression)Expr_231_list.get(0);
		Assert.assertNotNull(EqualityExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = EqualityExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final RelationalExpression RelationalExpression_233_Var
		 = (RelationalExpression)Expr_232_list.get(0);
		Assert.assertNotNull(RelationalExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = RelationalExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final ShiftExpression ShiftExpression_234_Var
		 = (ShiftExpression)Expr_233_list.get(0);
		Assert.assertNotNull(ShiftExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = ShiftExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final AdditiveExpression AdditiveExpression_235_Var
		 = (AdditiveExpression)Expr_234_list.get(0);
		Assert.assertNotNull(AdditiveExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = AdditiveExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final MultiplicativeExpression MultiplicativeExpression_236_Var
		 = (MultiplicativeExpression)Expr_235_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = MultiplicativeExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final CastExpression CastExpression_237_Var
		 = (CastExpression)Expr_236_list.get(0);
		Assert.assertNotNull(CastExpression_237_Var
		);
		//237
		final UnaryExpression UnaryExpression_238_Var
		 = (UnaryExpression)CastExpression_237_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_238_Var
		);
		//238
		final PostfixExpression PostfixExpression_239_Var
		 = (PostfixExpression)UnaryExpression_238_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = PostfixExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final PrimaryExpression PrimaryExpression_240_Var
		 = (PrimaryExpression)Expr_239_list.get(0);
		Assert.assertNotNull(PrimaryExpression_240_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_240_Var
		.getId());
		final EList<? extends EObject> Suffix_240_list = PostfixExpression_239_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_240_list);
		Assert.assertEquals(1, Suffix_240_list.size());
		//240
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_241_Var
		 = (PostfixExpressionSuffixArgument)Suffix_240_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_241_Var
		);
		//241
		final ArgumentExpressionList ArgumentExpressionList_242_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_241_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_242_Var
		);
		final EList<? extends EObject> Expr_242_list = ArgumentExpressionList_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(2, Expr_242_list.size());
		//242
		final AssignmentExpression AssignmentExpression_243_Var
		 = (AssignmentExpression)Expr_242_list.get(0);
		Assert.assertNotNull(AssignmentExpression_243_Var
		);
		//243
		final ConditionalExpression ConditionalExpression_244_Var
		 = (ConditionalExpression)AssignmentExpression_243_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_244_Var
		);
		//244
		final LogicalOrExpression LogicalOrExpression_245_Var
		 = (LogicalOrExpression)ConditionalExpression_244_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = LogicalOrExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final LogicalAndExpression LogicalAndExpression_246_Var
		 = (LogicalAndExpression)Expr_245_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = LogicalAndExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final InclusiveOrExpression InclusiveOrExpression_247_Var
		 = (InclusiveOrExpression)Expr_246_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = InclusiveOrExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final ExclusiveOrExpression ExclusiveOrExpression_248_Var
		 = (ExclusiveOrExpression)Expr_247_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = ExclusiveOrExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final AndExpression AndExpression_249_Var
		 = (AndExpression)Expr_248_list.get(0);
		Assert.assertNotNull(AndExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = AndExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final EqualityExpression EqualityExpression_250_Var
		 = (EqualityExpression)Expr_249_list.get(0);
		Assert.assertNotNull(EqualityExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = EqualityExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final RelationalExpression RelationalExpression_251_Var
		 = (RelationalExpression)Expr_250_list.get(0);
		Assert.assertNotNull(RelationalExpression_251_Var
		);
		final EList<? extends EObject> Expr_251_list = RelationalExpression_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(1, Expr_251_list.size());
		//251
		final ShiftExpression ShiftExpression_252_Var
		 = (ShiftExpression)Expr_251_list.get(0);
		Assert.assertNotNull(ShiftExpression_252_Var
		);
		final EList<? extends EObject> Expr_252_list = ShiftExpression_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(1, Expr_252_list.size());
		//252
		final AdditiveExpression AdditiveExpression_253_Var
		 = (AdditiveExpression)Expr_252_list.get(0);
		Assert.assertNotNull(AdditiveExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = AdditiveExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final MultiplicativeExpression MultiplicativeExpression_254_Var
		 = (MultiplicativeExpression)Expr_253_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_254_Var
		);
		final EList<? extends EObject> Expr_254_list = MultiplicativeExpression_254_Var
		.getExpr();
		Assert.assertNotNull(Expr_254_list);
		Assert.assertEquals(1, Expr_254_list.size());
		//254
		final CastExpression CastExpression_255_Var
		 = (CastExpression)Expr_254_list.get(0);
		Assert.assertNotNull(CastExpression_255_Var
		);
		//255
		final UnaryExpression UnaryExpression_256_Var
		 = (UnaryExpression)CastExpression_255_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_256_Var
		);
		//256
		final PostfixExpression PostfixExpression_257_Var
		 = (PostfixExpression)UnaryExpression_256_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_257_Var
		);
		final EList<? extends EObject> Expr_257_list = PostfixExpression_257_Var
		.getExpr();
		Assert.assertNotNull(Expr_257_list);
		Assert.assertEquals(1, Expr_257_list.size());
		//257
		final PrimaryExpression PrimaryExpression_258_Var
		 = (PrimaryExpression)Expr_257_list.get(0);
		Assert.assertNotNull(PrimaryExpression_258_Var
		);
		//258
		final Constant Constant_259_Var
		 = (Constant)PrimaryExpression_258_Var
		.getConst();
		Assert.assertNotNull(Constant_259_Var
		);
		Assert.assertEquals("\"sizeof(float)=%lu\\n\"", Constant_259_Var
		.getStr());
		//259
		final AssignmentExpression AssignmentExpression_260_Var
		 = (AssignmentExpression)Expr_242_list.get(1);
		Assert.assertNotNull(AssignmentExpression_260_Var
		);
		//260
		final ConditionalExpression ConditionalExpression_261_Var
		 = (ConditionalExpression)AssignmentExpression_260_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_261_Var
		);
		//261
		final LogicalOrExpression LogicalOrExpression_262_Var
		 = (LogicalOrExpression)ConditionalExpression_261_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_262_Var
		);
		final EList<? extends EObject> Expr_262_list = LogicalOrExpression_262_Var
		.getExpr();
		Assert.assertNotNull(Expr_262_list);
		Assert.assertEquals(1, Expr_262_list.size());
		//262
		final LogicalAndExpression LogicalAndExpression_263_Var
		 = (LogicalAndExpression)Expr_262_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_263_Var
		);
		final EList<? extends EObject> Expr_263_list = LogicalAndExpression_263_Var
		.getExpr();
		Assert.assertNotNull(Expr_263_list);
		Assert.assertEquals(1, Expr_263_list.size());
		//263
		final InclusiveOrExpression InclusiveOrExpression_264_Var
		 = (InclusiveOrExpression)Expr_263_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_264_Var
		);
		final EList<? extends EObject> Expr_264_list = InclusiveOrExpression_264_Var
		.getExpr();
		Assert.assertNotNull(Expr_264_list);
		Assert.assertEquals(1, Expr_264_list.size());
		//264
		final ExclusiveOrExpression ExclusiveOrExpression_265_Var
		 = (ExclusiveOrExpression)Expr_264_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_265_Var
		);
		final EList<? extends EObject> Expr_265_list = ExclusiveOrExpression_265_Var
		.getExpr();
		Assert.assertNotNull(Expr_265_list);
		Assert.assertEquals(1, Expr_265_list.size());
		//265
		final AndExpression AndExpression_266_Var
		 = (AndExpression)Expr_265_list.get(0);
		Assert.assertNotNull(AndExpression_266_Var
		);
		final EList<? extends EObject> Expr_266_list = AndExpression_266_Var
		.getExpr();
		Assert.assertNotNull(Expr_266_list);
		Assert.assertEquals(1, Expr_266_list.size());
		//266
		final EqualityExpression EqualityExpression_267_Var
		 = (EqualityExpression)Expr_266_list.get(0);
		Assert.assertNotNull(EqualityExpression_267_Var
		);
		final EList<? extends EObject> Expr_267_list = EqualityExpression_267_Var
		.getExpr();
		Assert.assertNotNull(Expr_267_list);
		Assert.assertEquals(1, Expr_267_list.size());
		//267
		final RelationalExpression RelationalExpression_268_Var
		 = (RelationalExpression)Expr_267_list.get(0);
		Assert.assertNotNull(RelationalExpression_268_Var
		);
		final EList<? extends EObject> Expr_268_list = RelationalExpression_268_Var
		.getExpr();
		Assert.assertNotNull(Expr_268_list);
		Assert.assertEquals(1, Expr_268_list.size());
		//268
		final ShiftExpression ShiftExpression_269_Var
		 = (ShiftExpression)Expr_268_list.get(0);
		Assert.assertNotNull(ShiftExpression_269_Var
		);
		final EList<? extends EObject> Expr_269_list = ShiftExpression_269_Var
		.getExpr();
		Assert.assertNotNull(Expr_269_list);
		Assert.assertEquals(1, Expr_269_list.size());
		//269
		final AdditiveExpression AdditiveExpression_270_Var
		 = (AdditiveExpression)Expr_269_list.get(0);
		Assert.assertNotNull(AdditiveExpression_270_Var
		);
		final EList<? extends EObject> Expr_270_list = AdditiveExpression_270_Var
		.getExpr();
		Assert.assertNotNull(Expr_270_list);
		Assert.assertEquals(1, Expr_270_list.size());
		//270
		final MultiplicativeExpression MultiplicativeExpression_271_Var
		 = (MultiplicativeExpression)Expr_270_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_271_Var
		);
		final EList<? extends EObject> Expr_271_list = MultiplicativeExpression_271_Var
		.getExpr();
		Assert.assertNotNull(Expr_271_list);
		Assert.assertEquals(1, Expr_271_list.size());
		//271
		final CastExpression CastExpression_272_Var
		 = (CastExpression)Expr_271_list.get(0);
		Assert.assertNotNull(CastExpression_272_Var
		);
		//272
		final UnaryExpression UnaryExpression_273_Var
		 = (UnaryExpression)CastExpression_272_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_273_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_273_Var
		.getSizeOf());
		//273
		final TypeName TypeName_274_Var
		 = (TypeName)UnaryExpression_273_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_274_Var
		);
		//274
		final SpecifierQualifierList SpecifierQualifierList_275_Var
		 = (SpecifierQualifierList)TypeName_274_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_275_Var
		);
		final EList<? extends EObject> TypeSpecifier_275_list = SpecifierQualifierList_275_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_275_list);
		Assert.assertEquals(1, TypeSpecifier_275_list.size());
		//275
		final TypeSpecifier TypeSpecifier_276_Var
		 = (TypeSpecifier)TypeSpecifier_275_list.get(0);
		Assert.assertNotNull(TypeSpecifier_276_Var
		);
		Assert.assertEquals("float", TypeSpecifier_276_Var
		.getName());
		Assert.assertEquals(";", ExpressionStatement_223_Var
		.getSemi());
		//276
		final Statement Statement_277_Var
		 = (Statement)Statement_94_list.get(3);
		Assert.assertNotNull(Statement_277_Var
		);
		//277
		final ExpressionStatement ExpressionStatement_278_Var
		 = (ExpressionStatement)Statement_277_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_278_Var
		);
		//278
		final Expression Expression_279_Var
		 = (Expression)ExpressionStatement_278_Var
		.getExpression();
		Assert.assertNotNull(Expression_279_Var
		);
		final EList<? extends EObject> ExprExpr_279_list = Expression_279_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_279_list);
		Assert.assertEquals(1, ExprExpr_279_list.size());
		//279
		final AssignmentExpression AssignmentExpression_280_Var
		 = (AssignmentExpression)ExprExpr_279_list.get(0);
		Assert.assertNotNull(AssignmentExpression_280_Var
		);
		//280
		final UnaryExpression UnaryExpression_281_Var
		 = (UnaryExpression)AssignmentExpression_280_Var
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
		Assert.assertEquals("number", PrimaryExpression_283_Var
		.getId());
		final EList<? extends EObject> Suffix_283_list = PostfixExpression_282_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_283_list);
		Assert.assertEquals(1, Suffix_283_list.size());
		//283
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_284_Var
		 = (PostfixExpressionSuffixDot)Suffix_283_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_284_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_284_Var
		.getId());
		//284
		final AssignmentOperator AssignmentOperator_285_Var
		 = (AssignmentOperator)AssignmentExpression_280_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_285_Var
		);
		Assert.assertEquals("=", AssignmentOperator_285_Var
		.getOp());
		//285
		final AssignmentExpression AssignmentExpression_286_Var
		 = (AssignmentExpression)AssignmentExpression_280_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_286_Var
		);
		//286
		final ConditionalExpression ConditionalExpression_287_Var
		 = (ConditionalExpression)AssignmentExpression_286_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_287_Var
		);
		//287
		final LogicalOrExpression LogicalOrExpression_288_Var
		 = (LogicalOrExpression)ConditionalExpression_287_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_288_Var
		);
		final EList<? extends EObject> Expr_288_list = LogicalOrExpression_288_Var
		.getExpr();
		Assert.assertNotNull(Expr_288_list);
		Assert.assertEquals(1, Expr_288_list.size());
		//288
		final LogicalAndExpression LogicalAndExpression_289_Var
		 = (LogicalAndExpression)Expr_288_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_289_Var
		);
		final EList<? extends EObject> Expr_289_list = LogicalAndExpression_289_Var
		.getExpr();
		Assert.assertNotNull(Expr_289_list);
		Assert.assertEquals(1, Expr_289_list.size());
		//289
		final InclusiveOrExpression InclusiveOrExpression_290_Var
		 = (InclusiveOrExpression)Expr_289_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_290_Var
		);
		final EList<? extends EObject> Expr_290_list = InclusiveOrExpression_290_Var
		.getExpr();
		Assert.assertNotNull(Expr_290_list);
		Assert.assertEquals(1, Expr_290_list.size());
		//290
		final ExclusiveOrExpression ExclusiveOrExpression_291_Var
		 = (ExclusiveOrExpression)Expr_290_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_291_Var
		);
		final EList<? extends EObject> Expr_291_list = ExclusiveOrExpression_291_Var
		.getExpr();
		Assert.assertNotNull(Expr_291_list);
		Assert.assertEquals(1, Expr_291_list.size());
		//291
		final AndExpression AndExpression_292_Var
		 = (AndExpression)Expr_291_list.get(0);
		Assert.assertNotNull(AndExpression_292_Var
		);
		final EList<? extends EObject> Expr_292_list = AndExpression_292_Var
		.getExpr();
		Assert.assertNotNull(Expr_292_list);
		Assert.assertEquals(1, Expr_292_list.size());
		//292
		final EqualityExpression EqualityExpression_293_Var
		 = (EqualityExpression)Expr_292_list.get(0);
		Assert.assertNotNull(EqualityExpression_293_Var
		);
		final EList<? extends EObject> Expr_293_list = EqualityExpression_293_Var
		.getExpr();
		Assert.assertNotNull(Expr_293_list);
		Assert.assertEquals(1, Expr_293_list.size());
		//293
		final RelationalExpression RelationalExpression_294_Var
		 = (RelationalExpression)Expr_293_list.get(0);
		Assert.assertNotNull(RelationalExpression_294_Var
		);
		final EList<? extends EObject> Expr_294_list = RelationalExpression_294_Var
		.getExpr();
		Assert.assertNotNull(Expr_294_list);
		Assert.assertEquals(1, Expr_294_list.size());
		//294
		final ShiftExpression ShiftExpression_295_Var
		 = (ShiftExpression)Expr_294_list.get(0);
		Assert.assertNotNull(ShiftExpression_295_Var
		);
		final EList<? extends EObject> Expr_295_list = ShiftExpression_295_Var
		.getExpr();
		Assert.assertNotNull(Expr_295_list);
		Assert.assertEquals(1, Expr_295_list.size());
		//295
		final AdditiveExpression AdditiveExpression_296_Var
		 = (AdditiveExpression)Expr_295_list.get(0);
		Assert.assertNotNull(AdditiveExpression_296_Var
		);
		final EList<? extends EObject> Expr_296_list = AdditiveExpression_296_Var
		.getExpr();
		Assert.assertNotNull(Expr_296_list);
		Assert.assertEquals(1, Expr_296_list.size());
		//296
		final MultiplicativeExpression MultiplicativeExpression_297_Var
		 = (MultiplicativeExpression)Expr_296_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_297_Var
		);
		final EList<? extends EObject> Expr_297_list = MultiplicativeExpression_297_Var
		.getExpr();
		Assert.assertNotNull(Expr_297_list);
		Assert.assertEquals(1, Expr_297_list.size());
		//297
		final CastExpression CastExpression_298_Var
		 = (CastExpression)Expr_297_list.get(0);
		Assert.assertNotNull(CastExpression_298_Var
		);
		//298
		final UnaryExpression UnaryExpression_299_Var
		 = (UnaryExpression)CastExpression_298_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_299_Var
		);
		//299
		final PostfixExpression PostfixExpression_300_Var
		 = (PostfixExpression)UnaryExpression_299_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_300_Var
		);
		final EList<? extends EObject> Expr_300_list = PostfixExpression_300_Var
		.getExpr();
		Assert.assertNotNull(Expr_300_list);
		Assert.assertEquals(1, Expr_300_list.size());
		//300
		final PrimaryExpression PrimaryExpression_301_Var
		 = (PrimaryExpression)Expr_300_list.get(0);
		Assert.assertNotNull(PrimaryExpression_301_Var
		);
		//301
		final Constant Constant_302_Var
		 = (Constant)PrimaryExpression_301_Var
		.getConst();
		Assert.assertNotNull(Constant_302_Var
		);
		Assert.assertEquals("65", Constant_302_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_278_Var
		.getSemi());
		//302
		final Statement Statement_303_Var
		 = (Statement)Statement_94_list.get(4);
		Assert.assertNotNull(Statement_303_Var
		);
		//303
		final ExpressionStatement ExpressionStatement_304_Var
		 = (ExpressionStatement)Statement_303_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_304_Var
		);
		//304
		final Expression Expression_305_Var
		 = (Expression)ExpressionStatement_304_Var
		.getExpression();
		Assert.assertNotNull(Expression_305_Var
		);
		final EList<? extends EObject> ExprExpr_305_list = Expression_305_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_305_list);
		Assert.assertEquals(1, ExprExpr_305_list.size());
		//305
		final AssignmentExpression AssignmentExpression_306_Var
		 = (AssignmentExpression)ExprExpr_305_list.get(0);
		Assert.assertNotNull(AssignmentExpression_306_Var
		);
		//306
		final ConditionalExpression ConditionalExpression_307_Var
		 = (ConditionalExpression)AssignmentExpression_306_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_307_Var
		);
		//307
		final LogicalOrExpression LogicalOrExpression_308_Var
		 = (LogicalOrExpression)ConditionalExpression_307_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_308_Var
		);
		final EList<? extends EObject> Expr_308_list = LogicalOrExpression_308_Var
		.getExpr();
		Assert.assertNotNull(Expr_308_list);
		Assert.assertEquals(1, Expr_308_list.size());
		//308
		final LogicalAndExpression LogicalAndExpression_309_Var
		 = (LogicalAndExpression)Expr_308_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_309_Var
		);
		final EList<? extends EObject> Expr_309_list = LogicalAndExpression_309_Var
		.getExpr();
		Assert.assertNotNull(Expr_309_list);
		Assert.assertEquals(1, Expr_309_list.size());
		//309
		final InclusiveOrExpression InclusiveOrExpression_310_Var
		 = (InclusiveOrExpression)Expr_309_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_310_Var
		);
		final EList<? extends EObject> Expr_310_list = InclusiveOrExpression_310_Var
		.getExpr();
		Assert.assertNotNull(Expr_310_list);
		Assert.assertEquals(1, Expr_310_list.size());
		//310
		final ExclusiveOrExpression ExclusiveOrExpression_311_Var
		 = (ExclusiveOrExpression)Expr_310_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = ExclusiveOrExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final AndExpression AndExpression_312_Var
		 = (AndExpression)Expr_311_list.get(0);
		Assert.assertNotNull(AndExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = AndExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final EqualityExpression EqualityExpression_313_Var
		 = (EqualityExpression)Expr_312_list.get(0);
		Assert.assertNotNull(EqualityExpression_313_Var
		);
		final EList<? extends EObject> Expr_313_list = EqualityExpression_313_Var
		.getExpr();
		Assert.assertNotNull(Expr_313_list);
		Assert.assertEquals(1, Expr_313_list.size());
		//313
		final RelationalExpression RelationalExpression_314_Var
		 = (RelationalExpression)Expr_313_list.get(0);
		Assert.assertNotNull(RelationalExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = RelationalExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final ShiftExpression ShiftExpression_315_Var
		 = (ShiftExpression)Expr_314_list.get(0);
		Assert.assertNotNull(ShiftExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = ShiftExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final AdditiveExpression AdditiveExpression_316_Var
		 = (AdditiveExpression)Expr_315_list.get(0);
		Assert.assertNotNull(AdditiveExpression_316_Var
		);
		final EList<? extends EObject> Expr_316_list = AdditiveExpression_316_Var
		.getExpr();
		Assert.assertNotNull(Expr_316_list);
		Assert.assertEquals(1, Expr_316_list.size());
		//316
		final MultiplicativeExpression MultiplicativeExpression_317_Var
		 = (MultiplicativeExpression)Expr_316_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_317_Var
		);
		final EList<? extends EObject> Expr_317_list = MultiplicativeExpression_317_Var
		.getExpr();
		Assert.assertNotNull(Expr_317_list);
		Assert.assertEquals(1, Expr_317_list.size());
		//317
		final CastExpression CastExpression_318_Var
		 = (CastExpression)Expr_317_list.get(0);
		Assert.assertNotNull(CastExpression_318_Var
		);
		//318
		final UnaryExpression UnaryExpression_319_Var
		 = (UnaryExpression)CastExpression_318_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_319_Var
		);
		//319
		final PostfixExpression PostfixExpression_320_Var
		 = (PostfixExpression)UnaryExpression_319_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_320_Var
		);
		final EList<? extends EObject> Expr_320_list = PostfixExpression_320_Var
		.getExpr();
		Assert.assertNotNull(Expr_320_list);
		Assert.assertEquals(1, Expr_320_list.size());
		//320
		final PrimaryExpression PrimaryExpression_321_Var
		 = (PrimaryExpression)Expr_320_list.get(0);
		Assert.assertNotNull(PrimaryExpression_321_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_321_Var
		.getId());
		final EList<? extends EObject> Suffix_321_list = PostfixExpression_320_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_321_list);
		Assert.assertEquals(1, Suffix_321_list.size());
		//321
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_322_Var
		 = (PostfixExpressionSuffixArgument)Suffix_321_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_322_Var
		);
		//322
		final ArgumentExpressionList ArgumentExpressionList_323_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_322_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_323_Var
		);
		final EList<? extends EObject> Expr_323_list = ArgumentExpressionList_323_Var
		.getExpr();
		Assert.assertNotNull(Expr_323_list);
		Assert.assertEquals(2, Expr_323_list.size());
		//323
		final AssignmentExpression AssignmentExpression_324_Var
		 = (AssignmentExpression)Expr_323_list.get(0);
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
		final PostfixExpression PostfixExpression_338_Var
		 = (PostfixExpression)UnaryExpression_337_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = PostfixExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final PrimaryExpression PrimaryExpression_339_Var
		 = (PrimaryExpression)Expr_338_list.get(0);
		Assert.assertNotNull(PrimaryExpression_339_Var
		);
		//339
		final Constant Constant_340_Var
		 = (Constant)PrimaryExpression_339_Var
		.getConst();
		Assert.assertNotNull(Constant_340_Var
		);
		Assert.assertEquals("\"number.numChar(as decimal)=%d\\n\"", Constant_340_Var
		.getStr());
		//340
		final AssignmentExpression AssignmentExpression_341_Var
		 = (AssignmentExpression)Expr_323_list.get(1);
		Assert.assertNotNull(AssignmentExpression_341_Var
		);
		//341
		final ConditionalExpression ConditionalExpression_342_Var
		 = (ConditionalExpression)AssignmentExpression_341_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_342_Var
		);
		//342
		final LogicalOrExpression LogicalOrExpression_343_Var
		 = (LogicalOrExpression)ConditionalExpression_342_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_343_Var
		);
		final EList<? extends EObject> Expr_343_list = LogicalOrExpression_343_Var
		.getExpr();
		Assert.assertNotNull(Expr_343_list);
		Assert.assertEquals(1, Expr_343_list.size());
		//343
		final LogicalAndExpression LogicalAndExpression_344_Var
		 = (LogicalAndExpression)Expr_343_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_344_Var
		);
		final EList<? extends EObject> Expr_344_list = LogicalAndExpression_344_Var
		.getExpr();
		Assert.assertNotNull(Expr_344_list);
		Assert.assertEquals(1, Expr_344_list.size());
		//344
		final InclusiveOrExpression InclusiveOrExpression_345_Var
		 = (InclusiveOrExpression)Expr_344_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_345_Var
		);
		final EList<? extends EObject> Expr_345_list = InclusiveOrExpression_345_Var
		.getExpr();
		Assert.assertNotNull(Expr_345_list);
		Assert.assertEquals(1, Expr_345_list.size());
		//345
		final ExclusiveOrExpression ExclusiveOrExpression_346_Var
		 = (ExclusiveOrExpression)Expr_345_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_346_Var
		);
		final EList<? extends EObject> Expr_346_list = ExclusiveOrExpression_346_Var
		.getExpr();
		Assert.assertNotNull(Expr_346_list);
		Assert.assertEquals(1, Expr_346_list.size());
		//346
		final AndExpression AndExpression_347_Var
		 = (AndExpression)Expr_346_list.get(0);
		Assert.assertNotNull(AndExpression_347_Var
		);
		final EList<? extends EObject> Expr_347_list = AndExpression_347_Var
		.getExpr();
		Assert.assertNotNull(Expr_347_list);
		Assert.assertEquals(1, Expr_347_list.size());
		//347
		final EqualityExpression EqualityExpression_348_Var
		 = (EqualityExpression)Expr_347_list.get(0);
		Assert.assertNotNull(EqualityExpression_348_Var
		);
		final EList<? extends EObject> Expr_348_list = EqualityExpression_348_Var
		.getExpr();
		Assert.assertNotNull(Expr_348_list);
		Assert.assertEquals(1, Expr_348_list.size());
		//348
		final RelationalExpression RelationalExpression_349_Var
		 = (RelationalExpression)Expr_348_list.get(0);
		Assert.assertNotNull(RelationalExpression_349_Var
		);
		final EList<? extends EObject> Expr_349_list = RelationalExpression_349_Var
		.getExpr();
		Assert.assertNotNull(Expr_349_list);
		Assert.assertEquals(1, Expr_349_list.size());
		//349
		final ShiftExpression ShiftExpression_350_Var
		 = (ShiftExpression)Expr_349_list.get(0);
		Assert.assertNotNull(ShiftExpression_350_Var
		);
		final EList<? extends EObject> Expr_350_list = ShiftExpression_350_Var
		.getExpr();
		Assert.assertNotNull(Expr_350_list);
		Assert.assertEquals(1, Expr_350_list.size());
		//350
		final AdditiveExpression AdditiveExpression_351_Var
		 = (AdditiveExpression)Expr_350_list.get(0);
		Assert.assertNotNull(AdditiveExpression_351_Var
		);
		final EList<? extends EObject> Expr_351_list = AdditiveExpression_351_Var
		.getExpr();
		Assert.assertNotNull(Expr_351_list);
		Assert.assertEquals(1, Expr_351_list.size());
		//351
		final MultiplicativeExpression MultiplicativeExpression_352_Var
		 = (MultiplicativeExpression)Expr_351_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_352_Var
		);
		final EList<? extends EObject> Expr_352_list = MultiplicativeExpression_352_Var
		.getExpr();
		Assert.assertNotNull(Expr_352_list);
		Assert.assertEquals(1, Expr_352_list.size());
		//352
		final CastExpression CastExpression_353_Var
		 = (CastExpression)Expr_352_list.get(0);
		Assert.assertNotNull(CastExpression_353_Var
		);
		//353
		final UnaryExpression UnaryExpression_354_Var
		 = (UnaryExpression)CastExpression_353_Var
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
		Assert.assertEquals("number", PrimaryExpression_356_Var
		.getId());
		final EList<? extends EObject> Suffix_356_list = PostfixExpression_355_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_356_list);
		Assert.assertEquals(1, Suffix_356_list.size());
		//356
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_357_Var
		 = (PostfixExpressionSuffixDot)Suffix_356_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_357_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_357_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_304_Var
		.getSemi());
		//357
		final Statement Statement_358_Var
		 = (Statement)Statement_94_list.get(5);
		Assert.assertNotNull(Statement_358_Var
		);
		//358
		final ExpressionStatement ExpressionStatement_359_Var
		 = (ExpressionStatement)Statement_358_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_359_Var
		);
		//359
		final Expression Expression_360_Var
		 = (Expression)ExpressionStatement_359_Var
		.getExpression();
		Assert.assertNotNull(Expression_360_Var
		);
		final EList<? extends EObject> ExprExpr_360_list = Expression_360_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_360_list);
		Assert.assertEquals(1, ExprExpr_360_list.size());
		//360
		final AssignmentExpression AssignmentExpression_361_Var
		 = (AssignmentExpression)ExprExpr_360_list.get(0);
		Assert.assertNotNull(AssignmentExpression_361_Var
		);
		//361
		final ConditionalExpression ConditionalExpression_362_Var
		 = (ConditionalExpression)AssignmentExpression_361_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_362_Var
		);
		//362
		final LogicalOrExpression LogicalOrExpression_363_Var
		 = (LogicalOrExpression)ConditionalExpression_362_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_363_Var
		);
		final EList<? extends EObject> Expr_363_list = LogicalOrExpression_363_Var
		.getExpr();
		Assert.assertNotNull(Expr_363_list);
		Assert.assertEquals(1, Expr_363_list.size());
		//363
		final LogicalAndExpression LogicalAndExpression_364_Var
		 = (LogicalAndExpression)Expr_363_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_364_Var
		);
		final EList<? extends EObject> Expr_364_list = LogicalAndExpression_364_Var
		.getExpr();
		Assert.assertNotNull(Expr_364_list);
		Assert.assertEquals(1, Expr_364_list.size());
		//364
		final InclusiveOrExpression InclusiveOrExpression_365_Var
		 = (InclusiveOrExpression)Expr_364_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = InclusiveOrExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final ExclusiveOrExpression ExclusiveOrExpression_366_Var
		 = (ExclusiveOrExpression)Expr_365_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_366_Var
		);
		final EList<? extends EObject> Expr_366_list = ExclusiveOrExpression_366_Var
		.getExpr();
		Assert.assertNotNull(Expr_366_list);
		Assert.assertEquals(1, Expr_366_list.size());
		//366
		final AndExpression AndExpression_367_Var
		 = (AndExpression)Expr_366_list.get(0);
		Assert.assertNotNull(AndExpression_367_Var
		);
		final EList<? extends EObject> Expr_367_list = AndExpression_367_Var
		.getExpr();
		Assert.assertNotNull(Expr_367_list);
		Assert.assertEquals(1, Expr_367_list.size());
		//367
		final EqualityExpression EqualityExpression_368_Var
		 = (EqualityExpression)Expr_367_list.get(0);
		Assert.assertNotNull(EqualityExpression_368_Var
		);
		final EList<? extends EObject> Expr_368_list = EqualityExpression_368_Var
		.getExpr();
		Assert.assertNotNull(Expr_368_list);
		Assert.assertEquals(1, Expr_368_list.size());
		//368
		final RelationalExpression RelationalExpression_369_Var
		 = (RelationalExpression)Expr_368_list.get(0);
		Assert.assertNotNull(RelationalExpression_369_Var
		);
		final EList<? extends EObject> Expr_369_list = RelationalExpression_369_Var
		.getExpr();
		Assert.assertNotNull(Expr_369_list);
		Assert.assertEquals(1, Expr_369_list.size());
		//369
		final ShiftExpression ShiftExpression_370_Var
		 = (ShiftExpression)Expr_369_list.get(0);
		Assert.assertNotNull(ShiftExpression_370_Var
		);
		final EList<? extends EObject> Expr_370_list = ShiftExpression_370_Var
		.getExpr();
		Assert.assertNotNull(Expr_370_list);
		Assert.assertEquals(1, Expr_370_list.size());
		//370
		final AdditiveExpression AdditiveExpression_371_Var
		 = (AdditiveExpression)Expr_370_list.get(0);
		Assert.assertNotNull(AdditiveExpression_371_Var
		);
		final EList<? extends EObject> Expr_371_list = AdditiveExpression_371_Var
		.getExpr();
		Assert.assertNotNull(Expr_371_list);
		Assert.assertEquals(1, Expr_371_list.size());
		//371
		final MultiplicativeExpression MultiplicativeExpression_372_Var
		 = (MultiplicativeExpression)Expr_371_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_372_Var
		);
		final EList<? extends EObject> Expr_372_list = MultiplicativeExpression_372_Var
		.getExpr();
		Assert.assertNotNull(Expr_372_list);
		Assert.assertEquals(1, Expr_372_list.size());
		//372
		final CastExpression CastExpression_373_Var
		 = (CastExpression)Expr_372_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_376_Var
		.getId());
		final EList<? extends EObject> Suffix_376_list = PostfixExpression_375_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_376_list);
		Assert.assertEquals(1, Suffix_376_list.size());
		//376
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_377_Var
		 = (PostfixExpressionSuffixArgument)Suffix_376_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_377_Var
		);
		//377
		final ArgumentExpressionList ArgumentExpressionList_378_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_377_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_378_Var
		);
		final EList<? extends EObject> Expr_378_list = ArgumentExpressionList_378_Var
		.getExpr();
		Assert.assertNotNull(Expr_378_list);
		Assert.assertEquals(2, Expr_378_list.size());
		//378
		final AssignmentExpression AssignmentExpression_379_Var
		 = (AssignmentExpression)Expr_378_list.get(0);
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
		//394
		final Constant Constant_395_Var
		 = (Constant)PrimaryExpression_394_Var
		.getConst();
		Assert.assertNotNull(Constant_395_Var
		);
		Assert.assertEquals("\"number.numChar(as char)=%c\\n\"", Constant_395_Var
		.getStr());
		//395
		final AssignmentExpression AssignmentExpression_396_Var
		 = (AssignmentExpression)Expr_378_list.get(1);
		Assert.assertNotNull(AssignmentExpression_396_Var
		);
		//396
		final ConditionalExpression ConditionalExpression_397_Var
		 = (ConditionalExpression)AssignmentExpression_396_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_397_Var
		);
		//397
		final LogicalOrExpression LogicalOrExpression_398_Var
		 = (LogicalOrExpression)ConditionalExpression_397_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_398_Var
		);
		final EList<? extends EObject> Expr_398_list = LogicalOrExpression_398_Var
		.getExpr();
		Assert.assertNotNull(Expr_398_list);
		Assert.assertEquals(1, Expr_398_list.size());
		//398
		final LogicalAndExpression LogicalAndExpression_399_Var
		 = (LogicalAndExpression)Expr_398_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_399_Var
		);
		final EList<? extends EObject> Expr_399_list = LogicalAndExpression_399_Var
		.getExpr();
		Assert.assertNotNull(Expr_399_list);
		Assert.assertEquals(1, Expr_399_list.size());
		//399
		final InclusiveOrExpression InclusiveOrExpression_400_Var
		 = (InclusiveOrExpression)Expr_399_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_400_Var
		);
		final EList<? extends EObject> Expr_400_list = InclusiveOrExpression_400_Var
		.getExpr();
		Assert.assertNotNull(Expr_400_list);
		Assert.assertEquals(1, Expr_400_list.size());
		//400
		final ExclusiveOrExpression ExclusiveOrExpression_401_Var
		 = (ExclusiveOrExpression)Expr_400_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_401_Var
		);
		final EList<? extends EObject> Expr_401_list = ExclusiveOrExpression_401_Var
		.getExpr();
		Assert.assertNotNull(Expr_401_list);
		Assert.assertEquals(1, Expr_401_list.size());
		//401
		final AndExpression AndExpression_402_Var
		 = (AndExpression)Expr_401_list.get(0);
		Assert.assertNotNull(AndExpression_402_Var
		);
		final EList<? extends EObject> Expr_402_list = AndExpression_402_Var
		.getExpr();
		Assert.assertNotNull(Expr_402_list);
		Assert.assertEquals(1, Expr_402_list.size());
		//402
		final EqualityExpression EqualityExpression_403_Var
		 = (EqualityExpression)Expr_402_list.get(0);
		Assert.assertNotNull(EqualityExpression_403_Var
		);
		final EList<? extends EObject> Expr_403_list = EqualityExpression_403_Var
		.getExpr();
		Assert.assertNotNull(Expr_403_list);
		Assert.assertEquals(1, Expr_403_list.size());
		//403
		final RelationalExpression RelationalExpression_404_Var
		 = (RelationalExpression)Expr_403_list.get(0);
		Assert.assertNotNull(RelationalExpression_404_Var
		);
		final EList<? extends EObject> Expr_404_list = RelationalExpression_404_Var
		.getExpr();
		Assert.assertNotNull(Expr_404_list);
		Assert.assertEquals(1, Expr_404_list.size());
		//404
		final ShiftExpression ShiftExpression_405_Var
		 = (ShiftExpression)Expr_404_list.get(0);
		Assert.assertNotNull(ShiftExpression_405_Var
		);
		final EList<? extends EObject> Expr_405_list = ShiftExpression_405_Var
		.getExpr();
		Assert.assertNotNull(Expr_405_list);
		Assert.assertEquals(1, Expr_405_list.size());
		//405
		final AdditiveExpression AdditiveExpression_406_Var
		 = (AdditiveExpression)Expr_405_list.get(0);
		Assert.assertNotNull(AdditiveExpression_406_Var
		);
		final EList<? extends EObject> Expr_406_list = AdditiveExpression_406_Var
		.getExpr();
		Assert.assertNotNull(Expr_406_list);
		Assert.assertEquals(1, Expr_406_list.size());
		//406
		final MultiplicativeExpression MultiplicativeExpression_407_Var
		 = (MultiplicativeExpression)Expr_406_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_407_Var
		);
		final EList<? extends EObject> Expr_407_list = MultiplicativeExpression_407_Var
		.getExpr();
		Assert.assertNotNull(Expr_407_list);
		Assert.assertEquals(1, Expr_407_list.size());
		//407
		final CastExpression CastExpression_408_Var
		 = (CastExpression)Expr_407_list.get(0);
		Assert.assertNotNull(CastExpression_408_Var
		);
		//408
		final UnaryExpression UnaryExpression_409_Var
		 = (UnaryExpression)CastExpression_408_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_409_Var
		);
		//409
		final PostfixExpression PostfixExpression_410_Var
		 = (PostfixExpression)UnaryExpression_409_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_410_Var
		);
		final EList<? extends EObject> Expr_410_list = PostfixExpression_410_Var
		.getExpr();
		Assert.assertNotNull(Expr_410_list);
		Assert.assertEquals(1, Expr_410_list.size());
		//410
		final PrimaryExpression PrimaryExpression_411_Var
		 = (PrimaryExpression)Expr_410_list.get(0);
		Assert.assertNotNull(PrimaryExpression_411_Var
		);
		Assert.assertEquals("number", PrimaryExpression_411_Var
		.getId());
		final EList<? extends EObject> Suffix_411_list = PostfixExpression_410_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_411_list);
		Assert.assertEquals(1, Suffix_411_list.size());
		//411
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_412_Var
		 = (PostfixExpressionSuffixDot)Suffix_411_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_412_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_412_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_359_Var
		.getSemi());
		//412
		final Statement Statement_413_Var
		 = (Statement)Statement_94_list.get(6);
		Assert.assertNotNull(Statement_413_Var
		);
		//413
		final ExpressionStatement ExpressionStatement_414_Var
		 = (ExpressionStatement)Statement_413_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_414_Var
		);
		//414
		final Expression Expression_415_Var
		 = (Expression)ExpressionStatement_414_Var
		.getExpression();
		Assert.assertNotNull(Expression_415_Var
		);
		final EList<? extends EObject> ExprExpr_415_list = Expression_415_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_415_list);
		Assert.assertEquals(1, ExprExpr_415_list.size());
		//415
		final AssignmentExpression AssignmentExpression_416_Var
		 = (AssignmentExpression)ExprExpr_415_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_431_Var
		.getId());
		final EList<? extends EObject> Suffix_431_list = PostfixExpression_430_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_431_list);
		Assert.assertEquals(1, Suffix_431_list.size());
		//431
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_432_Var
		 = (PostfixExpressionSuffixArgument)Suffix_431_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_432_Var
		);
		//432
		final ArgumentExpressionList ArgumentExpressionList_433_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_432_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_433_Var
		);
		final EList<? extends EObject> Expr_433_list = ArgumentExpressionList_433_Var
		.getExpr();
		Assert.assertNotNull(Expr_433_list);
		Assert.assertEquals(2, Expr_433_list.size());
		//433
		final AssignmentExpression AssignmentExpression_434_Var
		 = (AssignmentExpression)Expr_433_list.get(0);
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
		//449
		final Constant Constant_450_Var
		 = (Constant)PrimaryExpression_449_Var
		.getConst();
		Assert.assertNotNull(Constant_450_Var
		);
		Assert.assertEquals("\"number.numFloat=%f\\n\"", Constant_450_Var
		.getStr());
		//450
		final AssignmentExpression AssignmentExpression_451_Var
		 = (AssignmentExpression)Expr_433_list.get(1);
		Assert.assertNotNull(AssignmentExpression_451_Var
		);
		//451
		final ConditionalExpression ConditionalExpression_452_Var
		 = (ConditionalExpression)AssignmentExpression_451_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_452_Var
		);
		//452
		final LogicalOrExpression LogicalOrExpression_453_Var
		 = (LogicalOrExpression)ConditionalExpression_452_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_453_Var
		);
		final EList<? extends EObject> Expr_453_list = LogicalOrExpression_453_Var
		.getExpr();
		Assert.assertNotNull(Expr_453_list);
		Assert.assertEquals(1, Expr_453_list.size());
		//453
		final LogicalAndExpression LogicalAndExpression_454_Var
		 = (LogicalAndExpression)Expr_453_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_454_Var
		);
		final EList<? extends EObject> Expr_454_list = LogicalAndExpression_454_Var
		.getExpr();
		Assert.assertNotNull(Expr_454_list);
		Assert.assertEquals(1, Expr_454_list.size());
		//454
		final InclusiveOrExpression InclusiveOrExpression_455_Var
		 = (InclusiveOrExpression)Expr_454_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_455_Var
		);
		final EList<? extends EObject> Expr_455_list = InclusiveOrExpression_455_Var
		.getExpr();
		Assert.assertNotNull(Expr_455_list);
		Assert.assertEquals(1, Expr_455_list.size());
		//455
		final ExclusiveOrExpression ExclusiveOrExpression_456_Var
		 = (ExclusiveOrExpression)Expr_455_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_456_Var
		);
		final EList<? extends EObject> Expr_456_list = ExclusiveOrExpression_456_Var
		.getExpr();
		Assert.assertNotNull(Expr_456_list);
		Assert.assertEquals(1, Expr_456_list.size());
		//456
		final AndExpression AndExpression_457_Var
		 = (AndExpression)Expr_456_list.get(0);
		Assert.assertNotNull(AndExpression_457_Var
		);
		final EList<? extends EObject> Expr_457_list = AndExpression_457_Var
		.getExpr();
		Assert.assertNotNull(Expr_457_list);
		Assert.assertEquals(1, Expr_457_list.size());
		//457
		final EqualityExpression EqualityExpression_458_Var
		 = (EqualityExpression)Expr_457_list.get(0);
		Assert.assertNotNull(EqualityExpression_458_Var
		);
		final EList<? extends EObject> Expr_458_list = EqualityExpression_458_Var
		.getExpr();
		Assert.assertNotNull(Expr_458_list);
		Assert.assertEquals(1, Expr_458_list.size());
		//458
		final RelationalExpression RelationalExpression_459_Var
		 = (RelationalExpression)Expr_458_list.get(0);
		Assert.assertNotNull(RelationalExpression_459_Var
		);
		final EList<? extends EObject> Expr_459_list = RelationalExpression_459_Var
		.getExpr();
		Assert.assertNotNull(Expr_459_list);
		Assert.assertEquals(1, Expr_459_list.size());
		//459
		final ShiftExpression ShiftExpression_460_Var
		 = (ShiftExpression)Expr_459_list.get(0);
		Assert.assertNotNull(ShiftExpression_460_Var
		);
		final EList<? extends EObject> Expr_460_list = ShiftExpression_460_Var
		.getExpr();
		Assert.assertNotNull(Expr_460_list);
		Assert.assertEquals(1, Expr_460_list.size());
		//460
		final AdditiveExpression AdditiveExpression_461_Var
		 = (AdditiveExpression)Expr_460_list.get(0);
		Assert.assertNotNull(AdditiveExpression_461_Var
		);
		final EList<? extends EObject> Expr_461_list = AdditiveExpression_461_Var
		.getExpr();
		Assert.assertNotNull(Expr_461_list);
		Assert.assertEquals(1, Expr_461_list.size());
		//461
		final MultiplicativeExpression MultiplicativeExpression_462_Var
		 = (MultiplicativeExpression)Expr_461_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_462_Var
		);
		final EList<? extends EObject> Expr_462_list = MultiplicativeExpression_462_Var
		.getExpr();
		Assert.assertNotNull(Expr_462_list);
		Assert.assertEquals(1, Expr_462_list.size());
		//462
		final CastExpression CastExpression_463_Var
		 = (CastExpression)Expr_462_list.get(0);
		Assert.assertNotNull(CastExpression_463_Var
		);
		//463
		final UnaryExpression UnaryExpression_464_Var
		 = (UnaryExpression)CastExpression_463_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_464_Var
		);
		//464
		final PostfixExpression PostfixExpression_465_Var
		 = (PostfixExpression)UnaryExpression_464_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_465_Var
		);
		final EList<? extends EObject> Expr_465_list = PostfixExpression_465_Var
		.getExpr();
		Assert.assertNotNull(Expr_465_list);
		Assert.assertEquals(1, Expr_465_list.size());
		//465
		final PrimaryExpression PrimaryExpression_466_Var
		 = (PrimaryExpression)Expr_465_list.get(0);
		Assert.assertNotNull(PrimaryExpression_466_Var
		);
		Assert.assertEquals("number", PrimaryExpression_466_Var
		.getId());
		final EList<? extends EObject> Suffix_466_list = PostfixExpression_465_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_466_list);
		Assert.assertEquals(1, Suffix_466_list.size());
		//466
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_467_Var
		 = (PostfixExpressionSuffixDot)Suffix_466_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_467_Var
		);
		Assert.assertEquals("numFloat", PostfixExpressionSuffixDot_467_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_414_Var
		.getSemi());
		//467
		final Statement Statement_468_Var
		 = (Statement)Statement_94_list.get(7);
		Assert.assertNotNull(Statement_468_Var
		);
		//468
		final ExpressionStatement ExpressionStatement_469_Var
		 = (ExpressionStatement)Statement_468_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_469_Var
		);
		//469
		final Expression Expression_470_Var
		 = (Expression)ExpressionStatement_469_Var
		.getExpression();
		Assert.assertNotNull(Expression_470_Var
		);
		final EList<? extends EObject> ExprExpr_470_list = Expression_470_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_470_list);
		Assert.assertEquals(1, ExprExpr_470_list.size());
		//470
		final AssignmentExpression AssignmentExpression_471_Var
		 = (AssignmentExpression)ExprExpr_470_list.get(0);
		Assert.assertNotNull(AssignmentExpression_471_Var
		);
		//471
		final UnaryExpression UnaryExpression_472_Var
		 = (UnaryExpression)AssignmentExpression_471_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_472_Var
		);
		//472
		final PostfixExpression PostfixExpression_473_Var
		 = (PostfixExpression)UnaryExpression_472_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_473_Var
		);
		final EList<? extends EObject> Expr_473_list = PostfixExpression_473_Var
		.getExpr();
		Assert.assertNotNull(Expr_473_list);
		Assert.assertEquals(1, Expr_473_list.size());
		//473
		final PrimaryExpression PrimaryExpression_474_Var
		 = (PrimaryExpression)Expr_473_list.get(0);
		Assert.assertNotNull(PrimaryExpression_474_Var
		);
		Assert.assertEquals("number", PrimaryExpression_474_Var
		.getId());
		final EList<? extends EObject> Suffix_474_list = PostfixExpression_473_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_474_list);
		Assert.assertEquals(1, Suffix_474_list.size());
		//474
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_475_Var
		 = (PostfixExpressionSuffixDot)Suffix_474_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_475_Var
		);
		Assert.assertEquals("numFloat", PostfixExpressionSuffixDot_475_Var
		.getId());
		//475
		final AssignmentOperator AssignmentOperator_476_Var
		 = (AssignmentOperator)AssignmentExpression_471_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_476_Var
		);
		Assert.assertEquals("=", AssignmentOperator_476_Var
		.getOp());
		//476
		final AssignmentExpression AssignmentExpression_477_Var
		 = (AssignmentExpression)AssignmentExpression_471_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_477_Var
		);
		//477
		final ConditionalExpression ConditionalExpression_478_Var
		 = (ConditionalExpression)AssignmentExpression_477_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_478_Var
		);
		//478
		final LogicalOrExpression LogicalOrExpression_479_Var
		 = (LogicalOrExpression)ConditionalExpression_478_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_479_Var
		);
		final EList<? extends EObject> Expr_479_list = LogicalOrExpression_479_Var
		.getExpr();
		Assert.assertNotNull(Expr_479_list);
		Assert.assertEquals(1, Expr_479_list.size());
		//479
		final LogicalAndExpression LogicalAndExpression_480_Var
		 = (LogicalAndExpression)Expr_479_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_480_Var
		);
		final EList<? extends EObject> Expr_480_list = LogicalAndExpression_480_Var
		.getExpr();
		Assert.assertNotNull(Expr_480_list);
		Assert.assertEquals(1, Expr_480_list.size());
		//480
		final InclusiveOrExpression InclusiveOrExpression_481_Var
		 = (InclusiveOrExpression)Expr_480_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_481_Var
		);
		final EList<? extends EObject> Expr_481_list = InclusiveOrExpression_481_Var
		.getExpr();
		Assert.assertNotNull(Expr_481_list);
		Assert.assertEquals(1, Expr_481_list.size());
		//481
		final ExclusiveOrExpression ExclusiveOrExpression_482_Var
		 = (ExclusiveOrExpression)Expr_481_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_482_Var
		);
		final EList<? extends EObject> Expr_482_list = ExclusiveOrExpression_482_Var
		.getExpr();
		Assert.assertNotNull(Expr_482_list);
		Assert.assertEquals(1, Expr_482_list.size());
		//482
		final AndExpression AndExpression_483_Var
		 = (AndExpression)Expr_482_list.get(0);
		Assert.assertNotNull(AndExpression_483_Var
		);
		final EList<? extends EObject> Expr_483_list = AndExpression_483_Var
		.getExpr();
		Assert.assertNotNull(Expr_483_list);
		Assert.assertEquals(1, Expr_483_list.size());
		//483
		final EqualityExpression EqualityExpression_484_Var
		 = (EqualityExpression)Expr_483_list.get(0);
		Assert.assertNotNull(EqualityExpression_484_Var
		);
		final EList<? extends EObject> Expr_484_list = EqualityExpression_484_Var
		.getExpr();
		Assert.assertNotNull(Expr_484_list);
		Assert.assertEquals(1, Expr_484_list.size());
		//484
		final RelationalExpression RelationalExpression_485_Var
		 = (RelationalExpression)Expr_484_list.get(0);
		Assert.assertNotNull(RelationalExpression_485_Var
		);
		final EList<? extends EObject> Expr_485_list = RelationalExpression_485_Var
		.getExpr();
		Assert.assertNotNull(Expr_485_list);
		Assert.assertEquals(1, Expr_485_list.size());
		//485
		final ShiftExpression ShiftExpression_486_Var
		 = (ShiftExpression)Expr_485_list.get(0);
		Assert.assertNotNull(ShiftExpression_486_Var
		);
		final EList<? extends EObject> Expr_486_list = ShiftExpression_486_Var
		.getExpr();
		Assert.assertNotNull(Expr_486_list);
		Assert.assertEquals(1, Expr_486_list.size());
		//486
		final AdditiveExpression AdditiveExpression_487_Var
		 = (AdditiveExpression)Expr_486_list.get(0);
		Assert.assertNotNull(AdditiveExpression_487_Var
		);
		final EList<? extends EObject> Expr_487_list = AdditiveExpression_487_Var
		.getExpr();
		Assert.assertNotNull(Expr_487_list);
		Assert.assertEquals(1, Expr_487_list.size());
		//487
		final MultiplicativeExpression MultiplicativeExpression_488_Var
		 = (MultiplicativeExpression)Expr_487_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_488_Var
		);
		final EList<? extends EObject> Expr_488_list = MultiplicativeExpression_488_Var
		.getExpr();
		Assert.assertNotNull(Expr_488_list);
		Assert.assertEquals(1, Expr_488_list.size());
		//488
		final CastExpression CastExpression_489_Var
		 = (CastExpression)Expr_488_list.get(0);
		Assert.assertNotNull(CastExpression_489_Var
		);
		//489
		final UnaryExpression UnaryExpression_490_Var
		 = (UnaryExpression)CastExpression_489_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_490_Var
		);
		//490
		final PostfixExpression PostfixExpression_491_Var
		 = (PostfixExpression)UnaryExpression_490_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_491_Var
		);
		final EList<? extends EObject> Expr_491_list = PostfixExpression_491_Var
		.getExpr();
		Assert.assertNotNull(Expr_491_list);
		Assert.assertEquals(1, Expr_491_list.size());
		//491
		final PrimaryExpression PrimaryExpression_492_Var
		 = (PrimaryExpression)Expr_491_list.get(0);
		Assert.assertNotNull(PrimaryExpression_492_Var
		);
		//492
		final Constant Constant_493_Var
		 = (Constant)PrimaryExpression_492_Var
		.getConst();
		Assert.assertNotNull(Constant_493_Var
		);
		Assert.assertEquals("0.56789", Constant_493_Var
		.getFloat());
		Assert.assertEquals(";", ExpressionStatement_469_Var
		.getSemi());
		//493
		final Statement Statement_494_Var
		 = (Statement)Statement_94_list.get(8);
		Assert.assertNotNull(Statement_494_Var
		);
		//494
		final ExpressionStatement ExpressionStatement_495_Var
		 = (ExpressionStatement)Statement_494_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_495_Var
		);
		//495
		final Expression Expression_496_Var
		 = (Expression)ExpressionStatement_495_Var
		.getExpression();
		Assert.assertNotNull(Expression_496_Var
		);
		final EList<? extends EObject> ExprExpr_496_list = Expression_496_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_496_list);
		Assert.assertEquals(1, ExprExpr_496_list.size());
		//496
		final AssignmentExpression AssignmentExpression_497_Var
		 = (AssignmentExpression)ExprExpr_496_list.get(0);
		Assert.assertNotNull(AssignmentExpression_497_Var
		);
		//497
		final ConditionalExpression ConditionalExpression_498_Var
		 = (ConditionalExpression)AssignmentExpression_497_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_498_Var
		);
		//498
		final LogicalOrExpression LogicalOrExpression_499_Var
		 = (LogicalOrExpression)ConditionalExpression_498_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_499_Var
		);
		final EList<? extends EObject> Expr_499_list = LogicalOrExpression_499_Var
		.getExpr();
		Assert.assertNotNull(Expr_499_list);
		Assert.assertEquals(1, Expr_499_list.size());
		//499
		final LogicalAndExpression LogicalAndExpression_500_Var
		 = (LogicalAndExpression)Expr_499_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_500_Var
		);
		final EList<? extends EObject> Expr_500_list = LogicalAndExpression_500_Var
		.getExpr();
		Assert.assertNotNull(Expr_500_list);
		Assert.assertEquals(1, Expr_500_list.size());
		//500
		final InclusiveOrExpression InclusiveOrExpression_501_Var
		 = (InclusiveOrExpression)Expr_500_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_501_Var
		);
		final EList<? extends EObject> Expr_501_list = InclusiveOrExpression_501_Var
		.getExpr();
		Assert.assertNotNull(Expr_501_list);
		Assert.assertEquals(1, Expr_501_list.size());
		//501
		final ExclusiveOrExpression ExclusiveOrExpression_502_Var
		 = (ExclusiveOrExpression)Expr_501_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_502_Var
		);
		final EList<? extends EObject> Expr_502_list = ExclusiveOrExpression_502_Var
		.getExpr();
		Assert.assertNotNull(Expr_502_list);
		Assert.assertEquals(1, Expr_502_list.size());
		//502
		final AndExpression AndExpression_503_Var
		 = (AndExpression)Expr_502_list.get(0);
		Assert.assertNotNull(AndExpression_503_Var
		);
		final EList<? extends EObject> Expr_503_list = AndExpression_503_Var
		.getExpr();
		Assert.assertNotNull(Expr_503_list);
		Assert.assertEquals(1, Expr_503_list.size());
		//503
		final EqualityExpression EqualityExpression_504_Var
		 = (EqualityExpression)Expr_503_list.get(0);
		Assert.assertNotNull(EqualityExpression_504_Var
		);
		final EList<? extends EObject> Expr_504_list = EqualityExpression_504_Var
		.getExpr();
		Assert.assertNotNull(Expr_504_list);
		Assert.assertEquals(1, Expr_504_list.size());
		//504
		final RelationalExpression RelationalExpression_505_Var
		 = (RelationalExpression)Expr_504_list.get(0);
		Assert.assertNotNull(RelationalExpression_505_Var
		);
		final EList<? extends EObject> Expr_505_list = RelationalExpression_505_Var
		.getExpr();
		Assert.assertNotNull(Expr_505_list);
		Assert.assertEquals(1, Expr_505_list.size());
		//505
		final ShiftExpression ShiftExpression_506_Var
		 = (ShiftExpression)Expr_505_list.get(0);
		Assert.assertNotNull(ShiftExpression_506_Var
		);
		final EList<? extends EObject> Expr_506_list = ShiftExpression_506_Var
		.getExpr();
		Assert.assertNotNull(Expr_506_list);
		Assert.assertEquals(1, Expr_506_list.size());
		//506
		final AdditiveExpression AdditiveExpression_507_Var
		 = (AdditiveExpression)Expr_506_list.get(0);
		Assert.assertNotNull(AdditiveExpression_507_Var
		);
		final EList<? extends EObject> Expr_507_list = AdditiveExpression_507_Var
		.getExpr();
		Assert.assertNotNull(Expr_507_list);
		Assert.assertEquals(1, Expr_507_list.size());
		//507
		final MultiplicativeExpression MultiplicativeExpression_508_Var
		 = (MultiplicativeExpression)Expr_507_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_508_Var
		);
		final EList<? extends EObject> Expr_508_list = MultiplicativeExpression_508_Var
		.getExpr();
		Assert.assertNotNull(Expr_508_list);
		Assert.assertEquals(1, Expr_508_list.size());
		//508
		final CastExpression CastExpression_509_Var
		 = (CastExpression)Expr_508_list.get(0);
		Assert.assertNotNull(CastExpression_509_Var
		);
		//509
		final UnaryExpression UnaryExpression_510_Var
		 = (UnaryExpression)CastExpression_509_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_510_Var
		);
		//510
		final PostfixExpression PostfixExpression_511_Var
		 = (PostfixExpression)UnaryExpression_510_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_511_Var
		);
		final EList<? extends EObject> Expr_511_list = PostfixExpression_511_Var
		.getExpr();
		Assert.assertNotNull(Expr_511_list);
		Assert.assertEquals(1, Expr_511_list.size());
		//511
		final PrimaryExpression PrimaryExpression_512_Var
		 = (PrimaryExpression)Expr_511_list.get(0);
		Assert.assertNotNull(PrimaryExpression_512_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_512_Var
		.getId());
		final EList<? extends EObject> Suffix_512_list = PostfixExpression_511_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_512_list);
		Assert.assertEquals(1, Suffix_512_list.size());
		//512
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_513_Var
		 = (PostfixExpressionSuffixArgument)Suffix_512_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_513_Var
		);
		//513
		final ArgumentExpressionList ArgumentExpressionList_514_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_513_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_514_Var
		);
		final EList<? extends EObject> Expr_514_list = ArgumentExpressionList_514_Var
		.getExpr();
		Assert.assertNotNull(Expr_514_list);
		Assert.assertEquals(2, Expr_514_list.size());
		//514
		final AssignmentExpression AssignmentExpression_515_Var
		 = (AssignmentExpression)Expr_514_list.get(0);
		Assert.assertNotNull(AssignmentExpression_515_Var
		);
		//515
		final ConditionalExpression ConditionalExpression_516_Var
		 = (ConditionalExpression)AssignmentExpression_515_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_516_Var
		);
		//516
		final LogicalOrExpression LogicalOrExpression_517_Var
		 = (LogicalOrExpression)ConditionalExpression_516_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_517_Var
		);
		final EList<? extends EObject> Expr_517_list = LogicalOrExpression_517_Var
		.getExpr();
		Assert.assertNotNull(Expr_517_list);
		Assert.assertEquals(1, Expr_517_list.size());
		//517
		final LogicalAndExpression LogicalAndExpression_518_Var
		 = (LogicalAndExpression)Expr_517_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_518_Var
		);
		final EList<? extends EObject> Expr_518_list = LogicalAndExpression_518_Var
		.getExpr();
		Assert.assertNotNull(Expr_518_list);
		Assert.assertEquals(1, Expr_518_list.size());
		//518
		final InclusiveOrExpression InclusiveOrExpression_519_Var
		 = (InclusiveOrExpression)Expr_518_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_519_Var
		);
		final EList<? extends EObject> Expr_519_list = InclusiveOrExpression_519_Var
		.getExpr();
		Assert.assertNotNull(Expr_519_list);
		Assert.assertEquals(1, Expr_519_list.size());
		//519
		final ExclusiveOrExpression ExclusiveOrExpression_520_Var
		 = (ExclusiveOrExpression)Expr_519_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_520_Var
		);
		final EList<? extends EObject> Expr_520_list = ExclusiveOrExpression_520_Var
		.getExpr();
		Assert.assertNotNull(Expr_520_list);
		Assert.assertEquals(1, Expr_520_list.size());
		//520
		final AndExpression AndExpression_521_Var
		 = (AndExpression)Expr_520_list.get(0);
		Assert.assertNotNull(AndExpression_521_Var
		);
		final EList<? extends EObject> Expr_521_list = AndExpression_521_Var
		.getExpr();
		Assert.assertNotNull(Expr_521_list);
		Assert.assertEquals(1, Expr_521_list.size());
		//521
		final EqualityExpression EqualityExpression_522_Var
		 = (EqualityExpression)Expr_521_list.get(0);
		Assert.assertNotNull(EqualityExpression_522_Var
		);
		final EList<? extends EObject> Expr_522_list = EqualityExpression_522_Var
		.getExpr();
		Assert.assertNotNull(Expr_522_list);
		Assert.assertEquals(1, Expr_522_list.size());
		//522
		final RelationalExpression RelationalExpression_523_Var
		 = (RelationalExpression)Expr_522_list.get(0);
		Assert.assertNotNull(RelationalExpression_523_Var
		);
		final EList<? extends EObject> Expr_523_list = RelationalExpression_523_Var
		.getExpr();
		Assert.assertNotNull(Expr_523_list);
		Assert.assertEquals(1, Expr_523_list.size());
		//523
		final ShiftExpression ShiftExpression_524_Var
		 = (ShiftExpression)Expr_523_list.get(0);
		Assert.assertNotNull(ShiftExpression_524_Var
		);
		final EList<? extends EObject> Expr_524_list = ShiftExpression_524_Var
		.getExpr();
		Assert.assertNotNull(Expr_524_list);
		Assert.assertEquals(1, Expr_524_list.size());
		//524
		final AdditiveExpression AdditiveExpression_525_Var
		 = (AdditiveExpression)Expr_524_list.get(0);
		Assert.assertNotNull(AdditiveExpression_525_Var
		);
		final EList<? extends EObject> Expr_525_list = AdditiveExpression_525_Var
		.getExpr();
		Assert.assertNotNull(Expr_525_list);
		Assert.assertEquals(1, Expr_525_list.size());
		//525
		final MultiplicativeExpression MultiplicativeExpression_526_Var
		 = (MultiplicativeExpression)Expr_525_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_526_Var
		);
		final EList<? extends EObject> Expr_526_list = MultiplicativeExpression_526_Var
		.getExpr();
		Assert.assertNotNull(Expr_526_list);
		Assert.assertEquals(1, Expr_526_list.size());
		//526
		final CastExpression CastExpression_527_Var
		 = (CastExpression)Expr_526_list.get(0);
		Assert.assertNotNull(CastExpression_527_Var
		);
		//527
		final UnaryExpression UnaryExpression_528_Var
		 = (UnaryExpression)CastExpression_527_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_528_Var
		);
		//528
		final PostfixExpression PostfixExpression_529_Var
		 = (PostfixExpression)UnaryExpression_528_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_529_Var
		);
		final EList<? extends EObject> Expr_529_list = PostfixExpression_529_Var
		.getExpr();
		Assert.assertNotNull(Expr_529_list);
		Assert.assertEquals(1, Expr_529_list.size());
		//529
		final PrimaryExpression PrimaryExpression_530_Var
		 = (PrimaryExpression)Expr_529_list.get(0);
		Assert.assertNotNull(PrimaryExpression_530_Var
		);
		//530
		final Constant Constant_531_Var
		 = (Constant)PrimaryExpression_530_Var
		.getConst();
		Assert.assertNotNull(Constant_531_Var
		);
		Assert.assertEquals("\"number.numChar(as decimal)=%d\\n\"", Constant_531_Var
		.getStr());
		//531
		final AssignmentExpression AssignmentExpression_532_Var
		 = (AssignmentExpression)Expr_514_list.get(1);
		Assert.assertNotNull(AssignmentExpression_532_Var
		);
		//532
		final ConditionalExpression ConditionalExpression_533_Var
		 = (ConditionalExpression)AssignmentExpression_532_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_533_Var
		);
		//533
		final LogicalOrExpression LogicalOrExpression_534_Var
		 = (LogicalOrExpression)ConditionalExpression_533_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_534_Var
		);
		final EList<? extends EObject> Expr_534_list = LogicalOrExpression_534_Var
		.getExpr();
		Assert.assertNotNull(Expr_534_list);
		Assert.assertEquals(1, Expr_534_list.size());
		//534
		final LogicalAndExpression LogicalAndExpression_535_Var
		 = (LogicalAndExpression)Expr_534_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_535_Var
		);
		final EList<? extends EObject> Expr_535_list = LogicalAndExpression_535_Var
		.getExpr();
		Assert.assertNotNull(Expr_535_list);
		Assert.assertEquals(1, Expr_535_list.size());
		//535
		final InclusiveOrExpression InclusiveOrExpression_536_Var
		 = (InclusiveOrExpression)Expr_535_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_536_Var
		);
		final EList<? extends EObject> Expr_536_list = InclusiveOrExpression_536_Var
		.getExpr();
		Assert.assertNotNull(Expr_536_list);
		Assert.assertEquals(1, Expr_536_list.size());
		//536
		final ExclusiveOrExpression ExclusiveOrExpression_537_Var
		 = (ExclusiveOrExpression)Expr_536_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_537_Var
		);
		final EList<? extends EObject> Expr_537_list = ExclusiveOrExpression_537_Var
		.getExpr();
		Assert.assertNotNull(Expr_537_list);
		Assert.assertEquals(1, Expr_537_list.size());
		//537
		final AndExpression AndExpression_538_Var
		 = (AndExpression)Expr_537_list.get(0);
		Assert.assertNotNull(AndExpression_538_Var
		);
		final EList<? extends EObject> Expr_538_list = AndExpression_538_Var
		.getExpr();
		Assert.assertNotNull(Expr_538_list);
		Assert.assertEquals(1, Expr_538_list.size());
		//538
		final EqualityExpression EqualityExpression_539_Var
		 = (EqualityExpression)Expr_538_list.get(0);
		Assert.assertNotNull(EqualityExpression_539_Var
		);
		final EList<? extends EObject> Expr_539_list = EqualityExpression_539_Var
		.getExpr();
		Assert.assertNotNull(Expr_539_list);
		Assert.assertEquals(1, Expr_539_list.size());
		//539
		final RelationalExpression RelationalExpression_540_Var
		 = (RelationalExpression)Expr_539_list.get(0);
		Assert.assertNotNull(RelationalExpression_540_Var
		);
		final EList<? extends EObject> Expr_540_list = RelationalExpression_540_Var
		.getExpr();
		Assert.assertNotNull(Expr_540_list);
		Assert.assertEquals(1, Expr_540_list.size());
		//540
		final ShiftExpression ShiftExpression_541_Var
		 = (ShiftExpression)Expr_540_list.get(0);
		Assert.assertNotNull(ShiftExpression_541_Var
		);
		final EList<? extends EObject> Expr_541_list = ShiftExpression_541_Var
		.getExpr();
		Assert.assertNotNull(Expr_541_list);
		Assert.assertEquals(1, Expr_541_list.size());
		//541
		final AdditiveExpression AdditiveExpression_542_Var
		 = (AdditiveExpression)Expr_541_list.get(0);
		Assert.assertNotNull(AdditiveExpression_542_Var
		);
		final EList<? extends EObject> Expr_542_list = AdditiveExpression_542_Var
		.getExpr();
		Assert.assertNotNull(Expr_542_list);
		Assert.assertEquals(1, Expr_542_list.size());
		//542
		final MultiplicativeExpression MultiplicativeExpression_543_Var
		 = (MultiplicativeExpression)Expr_542_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_543_Var
		);
		final EList<? extends EObject> Expr_543_list = MultiplicativeExpression_543_Var
		.getExpr();
		Assert.assertNotNull(Expr_543_list);
		Assert.assertEquals(1, Expr_543_list.size());
		//543
		final CastExpression CastExpression_544_Var
		 = (CastExpression)Expr_543_list.get(0);
		Assert.assertNotNull(CastExpression_544_Var
		);
		//544
		final UnaryExpression UnaryExpression_545_Var
		 = (UnaryExpression)CastExpression_544_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_545_Var
		);
		//545
		final PostfixExpression PostfixExpression_546_Var
		 = (PostfixExpression)UnaryExpression_545_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_546_Var
		);
		final EList<? extends EObject> Expr_546_list = PostfixExpression_546_Var
		.getExpr();
		Assert.assertNotNull(Expr_546_list);
		Assert.assertEquals(1, Expr_546_list.size());
		//546
		final PrimaryExpression PrimaryExpression_547_Var
		 = (PrimaryExpression)Expr_546_list.get(0);
		Assert.assertNotNull(PrimaryExpression_547_Var
		);
		Assert.assertEquals("number", PrimaryExpression_547_Var
		.getId());
		final EList<? extends EObject> Suffix_547_list = PostfixExpression_546_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_547_list);
		Assert.assertEquals(1, Suffix_547_list.size());
		//547
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_548_Var
		 = (PostfixExpressionSuffixDot)Suffix_547_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_548_Var
		);
		Assert.assertEquals("numChar", PostfixExpressionSuffixDot_548_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_495_Var
		.getSemi());
		//548
		final Statement Statement_549_Var
		 = (Statement)Statement_94_list.get(9);
		Assert.assertNotNull(Statement_549_Var
		);
		//549
		final ExpressionStatement ExpressionStatement_550_Var
		 = (ExpressionStatement)Statement_549_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_550_Var
		);
		//550
		final Expression Expression_551_Var
		 = (Expression)ExpressionStatement_550_Var
		.getExpression();
		Assert.assertNotNull(Expression_551_Var
		);
		final EList<? extends EObject> ExprExpr_551_list = Expression_551_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_551_list);
		Assert.assertEquals(1, ExprExpr_551_list.size());
		//551
		final AssignmentExpression AssignmentExpression_552_Var
		 = (AssignmentExpression)ExprExpr_551_list.get(0);
		Assert.assertNotNull(AssignmentExpression_552_Var
		);
		//552
		final ConditionalExpression ConditionalExpression_553_Var
		 = (ConditionalExpression)AssignmentExpression_552_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_553_Var
		);
		//553
		final LogicalOrExpression LogicalOrExpression_554_Var
		 = (LogicalOrExpression)ConditionalExpression_553_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_554_Var
		);
		final EList<? extends EObject> Expr_554_list = LogicalOrExpression_554_Var
		.getExpr();
		Assert.assertNotNull(Expr_554_list);
		Assert.assertEquals(1, Expr_554_list.size());
		//554
		final LogicalAndExpression LogicalAndExpression_555_Var
		 = (LogicalAndExpression)Expr_554_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_555_Var
		);
		final EList<? extends EObject> Expr_555_list = LogicalAndExpression_555_Var
		.getExpr();
		Assert.assertNotNull(Expr_555_list);
		Assert.assertEquals(1, Expr_555_list.size());
		//555
		final InclusiveOrExpression InclusiveOrExpression_556_Var
		 = (InclusiveOrExpression)Expr_555_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_556_Var
		);
		final EList<? extends EObject> Expr_556_list = InclusiveOrExpression_556_Var
		.getExpr();
		Assert.assertNotNull(Expr_556_list);
		Assert.assertEquals(1, Expr_556_list.size());
		//556
		final ExclusiveOrExpression ExclusiveOrExpression_557_Var
		 = (ExclusiveOrExpression)Expr_556_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_557_Var
		);
		final EList<? extends EObject> Expr_557_list = ExclusiveOrExpression_557_Var
		.getExpr();
		Assert.assertNotNull(Expr_557_list);
		Assert.assertEquals(1, Expr_557_list.size());
		//557
		final AndExpression AndExpression_558_Var
		 = (AndExpression)Expr_557_list.get(0);
		Assert.assertNotNull(AndExpression_558_Var
		);
		final EList<? extends EObject> Expr_558_list = AndExpression_558_Var
		.getExpr();
		Assert.assertNotNull(Expr_558_list);
		Assert.assertEquals(1, Expr_558_list.size());
		//558
		final EqualityExpression EqualityExpression_559_Var
		 = (EqualityExpression)Expr_558_list.get(0);
		Assert.assertNotNull(EqualityExpression_559_Var
		);
		final EList<? extends EObject> Expr_559_list = EqualityExpression_559_Var
		.getExpr();
		Assert.assertNotNull(Expr_559_list);
		Assert.assertEquals(1, Expr_559_list.size());
		//559
		final RelationalExpression RelationalExpression_560_Var
		 = (RelationalExpression)Expr_559_list.get(0);
		Assert.assertNotNull(RelationalExpression_560_Var
		);
		final EList<? extends EObject> Expr_560_list = RelationalExpression_560_Var
		.getExpr();
		Assert.assertNotNull(Expr_560_list);
		Assert.assertEquals(1, Expr_560_list.size());
		//560
		final ShiftExpression ShiftExpression_561_Var
		 = (ShiftExpression)Expr_560_list.get(0);
		Assert.assertNotNull(ShiftExpression_561_Var
		);
		final EList<? extends EObject> Expr_561_list = ShiftExpression_561_Var
		.getExpr();
		Assert.assertNotNull(Expr_561_list);
		Assert.assertEquals(1, Expr_561_list.size());
		//561
		final AdditiveExpression AdditiveExpression_562_Var
		 = (AdditiveExpression)Expr_561_list.get(0);
		Assert.assertNotNull(AdditiveExpression_562_Var
		);
		final EList<? extends EObject> Expr_562_list = AdditiveExpression_562_Var
		.getExpr();
		Assert.assertNotNull(Expr_562_list);
		Assert.assertEquals(1, Expr_562_list.size());
		//562
		final MultiplicativeExpression MultiplicativeExpression_563_Var
		 = (MultiplicativeExpression)Expr_562_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_563_Var
		);
		final EList<? extends EObject> Expr_563_list = MultiplicativeExpression_563_Var
		.getExpr();
		Assert.assertNotNull(Expr_563_list);
		Assert.assertEquals(1, Expr_563_list.size());
		//563
		final CastExpression CastExpression_564_Var
		 = (CastExpression)Expr_563_list.get(0);
		Assert.assertNotNull(CastExpression_564_Var
		);
		//564
		final UnaryExpression UnaryExpression_565_Var
		 = (UnaryExpression)CastExpression_564_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_565_Var
		);
		//565
		final PostfixExpression PostfixExpression_566_Var
		 = (PostfixExpression)UnaryExpression_565_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_566_Var
		);
		final EList<? extends EObject> Expr_566_list = PostfixExpression_566_Var
		.getExpr();
		Assert.assertNotNull(Expr_566_list);
		Assert.assertEquals(1, Expr_566_list.size());
		//566
		final PrimaryExpression PrimaryExpression_567_Var
		 = (PrimaryExpression)Expr_566_list.get(0);
		Assert.assertNotNull(PrimaryExpression_567_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_567_Var
		.getId());
		final EList<? extends EObject> Suffix_567_list = PostfixExpression_566_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_567_list);
		Assert.assertEquals(1, Suffix_567_list.size());
		//567
		final PostfixExpressionSuffixArgument PostfixExpressionSuffixArgument_568_Var
		 = (PostfixExpressionSuffixArgument)Suffix_567_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixArgument_568_Var
		);
		//568
		final ArgumentExpressionList ArgumentExpressionList_569_Var
		 = (ArgumentExpressionList)PostfixExpressionSuffixArgument_568_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_569_Var
		);
		final EList<? extends EObject> Expr_569_list = ArgumentExpressionList_569_Var
		.getExpr();
		Assert.assertNotNull(Expr_569_list);
		Assert.assertEquals(2, Expr_569_list.size());
		//569
		final AssignmentExpression AssignmentExpression_570_Var
		 = (AssignmentExpression)Expr_569_list.get(0);
		Assert.assertNotNull(AssignmentExpression_570_Var
		);
		//570
		final ConditionalExpression ConditionalExpression_571_Var
		 = (ConditionalExpression)AssignmentExpression_570_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_571_Var
		);
		//571
		final LogicalOrExpression LogicalOrExpression_572_Var
		 = (LogicalOrExpression)ConditionalExpression_571_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_572_Var
		);
		final EList<? extends EObject> Expr_572_list = LogicalOrExpression_572_Var
		.getExpr();
		Assert.assertNotNull(Expr_572_list);
		Assert.assertEquals(1, Expr_572_list.size());
		//572
		final LogicalAndExpression LogicalAndExpression_573_Var
		 = (LogicalAndExpression)Expr_572_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_573_Var
		);
		final EList<? extends EObject> Expr_573_list = LogicalAndExpression_573_Var
		.getExpr();
		Assert.assertNotNull(Expr_573_list);
		Assert.assertEquals(1, Expr_573_list.size());
		//573
		final InclusiveOrExpression InclusiveOrExpression_574_Var
		 = (InclusiveOrExpression)Expr_573_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_574_Var
		);
		final EList<? extends EObject> Expr_574_list = InclusiveOrExpression_574_Var
		.getExpr();
		Assert.assertNotNull(Expr_574_list);
		Assert.assertEquals(1, Expr_574_list.size());
		//574
		final ExclusiveOrExpression ExclusiveOrExpression_575_Var
		 = (ExclusiveOrExpression)Expr_574_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_575_Var
		);
		final EList<? extends EObject> Expr_575_list = ExclusiveOrExpression_575_Var
		.getExpr();
		Assert.assertNotNull(Expr_575_list);
		Assert.assertEquals(1, Expr_575_list.size());
		//575
		final AndExpression AndExpression_576_Var
		 = (AndExpression)Expr_575_list.get(0);
		Assert.assertNotNull(AndExpression_576_Var
		);
		final EList<? extends EObject> Expr_576_list = AndExpression_576_Var
		.getExpr();
		Assert.assertNotNull(Expr_576_list);
		Assert.assertEquals(1, Expr_576_list.size());
		//576
		final EqualityExpression EqualityExpression_577_Var
		 = (EqualityExpression)Expr_576_list.get(0);
		Assert.assertNotNull(EqualityExpression_577_Var
		);
		final EList<? extends EObject> Expr_577_list = EqualityExpression_577_Var
		.getExpr();
		Assert.assertNotNull(Expr_577_list);
		Assert.assertEquals(1, Expr_577_list.size());
		//577
		final RelationalExpression RelationalExpression_578_Var
		 = (RelationalExpression)Expr_577_list.get(0);
		Assert.assertNotNull(RelationalExpression_578_Var
		);
		final EList<? extends EObject> Expr_578_list = RelationalExpression_578_Var
		.getExpr();
		Assert.assertNotNull(Expr_578_list);
		Assert.assertEquals(1, Expr_578_list.size());
		//578
		final ShiftExpression ShiftExpression_579_Var
		 = (ShiftExpression)Expr_578_list.get(0);
		Assert.assertNotNull(ShiftExpression_579_Var
		);
		final EList<? extends EObject> Expr_579_list = ShiftExpression_579_Var
		.getExpr();
		Assert.assertNotNull(Expr_579_list);
		Assert.assertEquals(1, Expr_579_list.size());
		//579
		final AdditiveExpression AdditiveExpression_580_Var
		 = (AdditiveExpression)Expr_579_list.get(0);
		Assert.assertNotNull(AdditiveExpression_580_Var
		);
		final EList<? extends EObject> Expr_580_list = AdditiveExpression_580_Var
		.getExpr();
		Assert.assertNotNull(Expr_580_list);
		Assert.assertEquals(1, Expr_580_list.size());
		//580
		final MultiplicativeExpression MultiplicativeExpression_581_Var
		 = (MultiplicativeExpression)Expr_580_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_581_Var
		);
		final EList<? extends EObject> Expr_581_list = MultiplicativeExpression_581_Var
		.getExpr();
		Assert.assertNotNull(Expr_581_list);
		Assert.assertEquals(1, Expr_581_list.size());
		//581
		final CastExpression CastExpression_582_Var
		 = (CastExpression)Expr_581_list.get(0);
		Assert.assertNotNull(CastExpression_582_Var
		);
		//582
		final UnaryExpression UnaryExpression_583_Var
		 = (UnaryExpression)CastExpression_582_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_583_Var
		);
		//583
		final PostfixExpression PostfixExpression_584_Var
		 = (PostfixExpression)UnaryExpression_583_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_584_Var
		);
		final EList<? extends EObject> Expr_584_list = PostfixExpression_584_Var
		.getExpr();
		Assert.assertNotNull(Expr_584_list);
		Assert.assertEquals(1, Expr_584_list.size());
		//584
		final PrimaryExpression PrimaryExpression_585_Var
		 = (PrimaryExpression)Expr_584_list.get(0);
		Assert.assertNotNull(PrimaryExpression_585_Var
		);
		//585
		final Constant Constant_586_Var
		 = (Constant)PrimaryExpression_585_Var
		.getConst();
		Assert.assertNotNull(Constant_586_Var
		);
		Assert.assertEquals("\"number.numFloat=%f\\n\"", Constant_586_Var
		.getStr());
		//586
		final AssignmentExpression AssignmentExpression_587_Var
		 = (AssignmentExpression)Expr_569_list.get(1);
		Assert.assertNotNull(AssignmentExpression_587_Var
		);
		//587
		final ConditionalExpression ConditionalExpression_588_Var
		 = (ConditionalExpression)AssignmentExpression_587_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_588_Var
		);
		//588
		final LogicalOrExpression LogicalOrExpression_589_Var
		 = (LogicalOrExpression)ConditionalExpression_588_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_589_Var
		);
		final EList<? extends EObject> Expr_589_list = LogicalOrExpression_589_Var
		.getExpr();
		Assert.assertNotNull(Expr_589_list);
		Assert.assertEquals(1, Expr_589_list.size());
		//589
		final LogicalAndExpression LogicalAndExpression_590_Var
		 = (LogicalAndExpression)Expr_589_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_590_Var
		);
		final EList<? extends EObject> Expr_590_list = LogicalAndExpression_590_Var
		.getExpr();
		Assert.assertNotNull(Expr_590_list);
		Assert.assertEquals(1, Expr_590_list.size());
		//590
		final InclusiveOrExpression InclusiveOrExpression_591_Var
		 = (InclusiveOrExpression)Expr_590_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_591_Var
		);
		final EList<? extends EObject> Expr_591_list = InclusiveOrExpression_591_Var
		.getExpr();
		Assert.assertNotNull(Expr_591_list);
		Assert.assertEquals(1, Expr_591_list.size());
		//591
		final ExclusiveOrExpression ExclusiveOrExpression_592_Var
		 = (ExclusiveOrExpression)Expr_591_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_592_Var
		);
		final EList<? extends EObject> Expr_592_list = ExclusiveOrExpression_592_Var
		.getExpr();
		Assert.assertNotNull(Expr_592_list);
		Assert.assertEquals(1, Expr_592_list.size());
		//592
		final AndExpression AndExpression_593_Var
		 = (AndExpression)Expr_592_list.get(0);
		Assert.assertNotNull(AndExpression_593_Var
		);
		final EList<? extends EObject> Expr_593_list = AndExpression_593_Var
		.getExpr();
		Assert.assertNotNull(Expr_593_list);
		Assert.assertEquals(1, Expr_593_list.size());
		//593
		final EqualityExpression EqualityExpression_594_Var
		 = (EqualityExpression)Expr_593_list.get(0);
		Assert.assertNotNull(EqualityExpression_594_Var
		);
		final EList<? extends EObject> Expr_594_list = EqualityExpression_594_Var
		.getExpr();
		Assert.assertNotNull(Expr_594_list);
		Assert.assertEquals(1, Expr_594_list.size());
		//594
		final RelationalExpression RelationalExpression_595_Var
		 = (RelationalExpression)Expr_594_list.get(0);
		Assert.assertNotNull(RelationalExpression_595_Var
		);
		final EList<? extends EObject> Expr_595_list = RelationalExpression_595_Var
		.getExpr();
		Assert.assertNotNull(Expr_595_list);
		Assert.assertEquals(1, Expr_595_list.size());
		//595
		final ShiftExpression ShiftExpression_596_Var
		 = (ShiftExpression)Expr_595_list.get(0);
		Assert.assertNotNull(ShiftExpression_596_Var
		);
		final EList<? extends EObject> Expr_596_list = ShiftExpression_596_Var
		.getExpr();
		Assert.assertNotNull(Expr_596_list);
		Assert.assertEquals(1, Expr_596_list.size());
		//596
		final AdditiveExpression AdditiveExpression_597_Var
		 = (AdditiveExpression)Expr_596_list.get(0);
		Assert.assertNotNull(AdditiveExpression_597_Var
		);
		final EList<? extends EObject> Expr_597_list = AdditiveExpression_597_Var
		.getExpr();
		Assert.assertNotNull(Expr_597_list);
		Assert.assertEquals(1, Expr_597_list.size());
		//597
		final MultiplicativeExpression MultiplicativeExpression_598_Var
		 = (MultiplicativeExpression)Expr_597_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_598_Var
		);
		final EList<? extends EObject> Expr_598_list = MultiplicativeExpression_598_Var
		.getExpr();
		Assert.assertNotNull(Expr_598_list);
		Assert.assertEquals(1, Expr_598_list.size());
		//598
		final CastExpression CastExpression_599_Var
		 = (CastExpression)Expr_598_list.get(0);
		Assert.assertNotNull(CastExpression_599_Var
		);
		//599
		final UnaryExpression UnaryExpression_600_Var
		 = (UnaryExpression)CastExpression_599_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_600_Var
		);
		//600
		final PostfixExpression PostfixExpression_601_Var
		 = (PostfixExpression)UnaryExpression_600_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_601_Var
		);
		final EList<? extends EObject> Expr_601_list = PostfixExpression_601_Var
		.getExpr();
		Assert.assertNotNull(Expr_601_list);
		Assert.assertEquals(1, Expr_601_list.size());
		//601
		final PrimaryExpression PrimaryExpression_602_Var
		 = (PrimaryExpression)Expr_601_list.get(0);
		Assert.assertNotNull(PrimaryExpression_602_Var
		);
		Assert.assertEquals("number", PrimaryExpression_602_Var
		.getId());
		final EList<? extends EObject> Suffix_602_list = PostfixExpression_601_Var
		.getSuffix();
		Assert.assertNotNull(Suffix_602_list);
		Assert.assertEquals(1, Suffix_602_list.size());
		//602
		final PostfixExpressionSuffixDot PostfixExpressionSuffixDot_603_Var
		 = (PostfixExpressionSuffixDot)Suffix_602_list.get(0);
		Assert.assertNotNull(PostfixExpressionSuffixDot_603_Var
		);
		Assert.assertEquals("numFloat", PostfixExpressionSuffixDot_603_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_550_Var
		.getSemi());
		//603
		final Statement Statement_604_Var
		 = (Statement)Statement_94_list.get(10);
		Assert.assertNotNull(Statement_604_Var
		);
		//604
		final JumpStatement JumpStatement_605_Var
		 = (JumpStatement)Statement_604_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_605_Var
		);
		//605
		final Expression Expression_606_Var
		 = (Expression)JumpStatement_605_Var
		.getExpr();
		Assert.assertNotNull(Expression_606_Var
		);
		final EList<? extends EObject> ExprExpr_606_list = Expression_606_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_606_list);
		Assert.assertEquals(1, ExprExpr_606_list.size());
		//606
		final AssignmentExpression AssignmentExpression_607_Var
		 = (AssignmentExpression)ExprExpr_606_list.get(0);
		Assert.assertNotNull(AssignmentExpression_607_Var
		);
		//607
		final ConditionalExpression ConditionalExpression_608_Var
		 = (ConditionalExpression)AssignmentExpression_607_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_608_Var
		);
		//608
		final LogicalOrExpression LogicalOrExpression_609_Var
		 = (LogicalOrExpression)ConditionalExpression_608_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_609_Var
		);
		final EList<? extends EObject> Expr_609_list = LogicalOrExpression_609_Var
		.getExpr();
		Assert.assertNotNull(Expr_609_list);
		Assert.assertEquals(1, Expr_609_list.size());
		//609
		final LogicalAndExpression LogicalAndExpression_610_Var
		 = (LogicalAndExpression)Expr_609_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_610_Var
		);
		final EList<? extends EObject> Expr_610_list = LogicalAndExpression_610_Var
		.getExpr();
		Assert.assertNotNull(Expr_610_list);
		Assert.assertEquals(1, Expr_610_list.size());
		//610
		final InclusiveOrExpression InclusiveOrExpression_611_Var
		 = (InclusiveOrExpression)Expr_610_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_611_Var
		);
		final EList<? extends EObject> Expr_611_list = InclusiveOrExpression_611_Var
		.getExpr();
		Assert.assertNotNull(Expr_611_list);
		Assert.assertEquals(1, Expr_611_list.size());
		//611
		final ExclusiveOrExpression ExclusiveOrExpression_612_Var
		 = (ExclusiveOrExpression)Expr_611_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_612_Var
		);
		final EList<? extends EObject> Expr_612_list = ExclusiveOrExpression_612_Var
		.getExpr();
		Assert.assertNotNull(Expr_612_list);
		Assert.assertEquals(1, Expr_612_list.size());
		//612
		final AndExpression AndExpression_613_Var
		 = (AndExpression)Expr_612_list.get(0);
		Assert.assertNotNull(AndExpression_613_Var
		);
		final EList<? extends EObject> Expr_613_list = AndExpression_613_Var
		.getExpr();
		Assert.assertNotNull(Expr_613_list);
		Assert.assertEquals(1, Expr_613_list.size());
		//613
		final EqualityExpression EqualityExpression_614_Var
		 = (EqualityExpression)Expr_613_list.get(0);
		Assert.assertNotNull(EqualityExpression_614_Var
		);
		final EList<? extends EObject> Expr_614_list = EqualityExpression_614_Var
		.getExpr();
		Assert.assertNotNull(Expr_614_list);
		Assert.assertEquals(1, Expr_614_list.size());
		//614
		final RelationalExpression RelationalExpression_615_Var
		 = (RelationalExpression)Expr_614_list.get(0);
		Assert.assertNotNull(RelationalExpression_615_Var
		);
		final EList<? extends EObject> Expr_615_list = RelationalExpression_615_Var
		.getExpr();
		Assert.assertNotNull(Expr_615_list);
		Assert.assertEquals(1, Expr_615_list.size());
		//615
		final ShiftExpression ShiftExpression_616_Var
		 = (ShiftExpression)Expr_615_list.get(0);
		Assert.assertNotNull(ShiftExpression_616_Var
		);
		final EList<? extends EObject> Expr_616_list = ShiftExpression_616_Var
		.getExpr();
		Assert.assertNotNull(Expr_616_list);
		Assert.assertEquals(1, Expr_616_list.size());
		//616
		final AdditiveExpression AdditiveExpression_617_Var
		 = (AdditiveExpression)Expr_616_list.get(0);
		Assert.assertNotNull(AdditiveExpression_617_Var
		);
		final EList<? extends EObject> Expr_617_list = AdditiveExpression_617_Var
		.getExpr();
		Assert.assertNotNull(Expr_617_list);
		Assert.assertEquals(1, Expr_617_list.size());
		//617
		final MultiplicativeExpression MultiplicativeExpression_618_Var
		 = (MultiplicativeExpression)Expr_617_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_618_Var
		);
		final EList<? extends EObject> Expr_618_list = MultiplicativeExpression_618_Var
		.getExpr();
		Assert.assertNotNull(Expr_618_list);
		Assert.assertEquals(1, Expr_618_list.size());
		//618
		final CastExpression CastExpression_619_Var
		 = (CastExpression)Expr_618_list.get(0);
		Assert.assertNotNull(CastExpression_619_Var
		);
		//619
		final UnaryExpression UnaryExpression_620_Var
		 = (UnaryExpression)CastExpression_619_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_620_Var
		);
		//620
		final PostfixExpression PostfixExpression_621_Var
		 = (PostfixExpression)UnaryExpression_620_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_621_Var
		);
		final EList<? extends EObject> Expr_621_list = PostfixExpression_621_Var
		.getExpr();
		Assert.assertNotNull(Expr_621_list);
		Assert.assertEquals(1, Expr_621_list.size());
		//621
		final PrimaryExpression PrimaryExpression_622_Var
		 = (PrimaryExpression)Expr_621_list.get(0);
		Assert.assertNotNull(PrimaryExpression_622_Var
		);
		//622
		final Constant Constant_623_Var
		 = (Constant)PrimaryExpression_622_Var
		.getConst();
		Assert.assertNotNull(Constant_623_Var
		);
		Assert.assertEquals("0", Constant_623_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_605_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_605_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0034_Union.c");
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
				method.invoke(this.generator, "Test0034_Union.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0034_Union.c");
		final String expected = this.getTextFromFile(
			"res/Test0034_Union.c"
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


