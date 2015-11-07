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
import at.jku.weiner.c.c.DeclaratorSuffix;
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
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
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
import at.jku.weiner.c.c.Initializer;
import at.jku.weiner.c.c.InitializerList;
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
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
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
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
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
public class Test0037_Struct {
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
	
	private String preprocess(final String string) {
		final String lineComment = string.replaceAll("//.*\n", " ");
		final String blockComment = lineComment.replaceAll("/\\*.*\\*/", " ");
		final String lines = blockComment.replaceAll("\n", " ").trim();
		final String multi = lines.replaceAll("\\s{2,}", " ").trim();
		final String sign = multi.replaceAll("\\s+([^a-zA-Z0-9_])", "$1")
				.trim();
		final String sign2 = sign.replaceAll("([^a-zA-Z0-9_])\\s+", "$1")
				.trim();
	
		// System.out.println(sign2);
		return sign2;
	}
	
	@Test
	public void checkLexerTokens() throws Exception{
		final String text = this.getTextFromFile(
			"res/Test0037_Struct.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_LINEDIRECTIVE", 
				"RULE_NEWLINE", 
				"RULE_LINEDIRECTIVE", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_STRUCT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_INT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_CHAR", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTBRACKET", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_RIGHTBRACKET", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_RIGHTBRACE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_STRUCT", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_HEX_LITERAL", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
				"RULE_RIGHTBRACE", 
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
				"RULE_ID", 
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
				"RULE_HEX_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_ID", 
				"RULE_DOT", 
				"RULE_ID", 
				"RULE_COMMA", 
				"RULE_WHITESPACE", 
				"RULE_STRING_LITERAL", 
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
			"res/Test0037_Struct.c");
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
		Assert.assertEquals("struct", StructOrUnion_6_Var
		.getName());
		Assert.assertEquals("employee", StructOrUnionSpecifier_5_Var
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
		Assert.assertEquals("int", TypeSpecifier_10_Var
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
		Assert.assertEquals("id", DirectDeclarator_14_Var
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
		Assert.assertEquals("char", TypeSpecifier_17_Var
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
		Assert.assertEquals("name", DirectDeclarator_21_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_21_list = DirectDeclarator_21_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_21_list);
		Assert.assertEquals(1, DeclaratorSuffix_21_list.size());
		//21
		final DeclaratorSuffix DeclaratorSuffix_22_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_21_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_22_Var
		);
		//22
		final AssignmentExpression AssignmentExpression_23_Var
		 = (AssignmentExpression)DeclaratorSuffix_22_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_23_Var
		);
		//23
		final ConditionalExpression ConditionalExpression_24_Var
		 = (ConditionalExpression)AssignmentExpression_23_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_24_Var
		);
		//24
		final LogicalOrExpression LogicalOrExpression_25_Var
		 = (LogicalOrExpression)ConditionalExpression_24_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_25_Var
		);
		final EList<? extends EObject> Expr_25_list = LogicalOrExpression_25_Var
		.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		//25
		final LogicalAndExpression LogicalAndExpression_26_Var
		 = (LogicalAndExpression)Expr_25_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = LogicalAndExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final InclusiveOrExpression InclusiveOrExpression_27_Var
		 = (InclusiveOrExpression)Expr_26_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = InclusiveOrExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final ExclusiveOrExpression ExclusiveOrExpression_28_Var
		 = (ExclusiveOrExpression)Expr_27_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = ExclusiveOrExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final AndExpression AndExpression_29_Var
		 = (AndExpression)Expr_28_list.get(0);
		Assert.assertNotNull(AndExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = AndExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final EqualityExpression EqualityExpression_30_Var
		 = (EqualityExpression)Expr_29_list.get(0);
		Assert.assertNotNull(EqualityExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = EqualityExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final RelationalExpression RelationalExpression_31_Var
		 = (RelationalExpression)Expr_30_list.get(0);
		Assert.assertNotNull(RelationalExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = RelationalExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final ShiftExpression ShiftExpression_32_Var
		 = (ShiftExpression)Expr_31_list.get(0);
		Assert.assertNotNull(ShiftExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = ShiftExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final AdditiveExpression AdditiveExpression_33_Var
		 = (AdditiveExpression)Expr_32_list.get(0);
		Assert.assertNotNull(AdditiveExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = AdditiveExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final MultiplicativeExpression MultiplicativeExpression_34_Var
		 = (MultiplicativeExpression)Expr_33_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = MultiplicativeExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final CastExpression CastExpression_35_Var
		 = (CastExpression)Expr_34_list.get(0);
		Assert.assertNotNull(CastExpression_35_Var
		);
		//35
		final UnaryExpression UnaryExpression_36_Var
		 = (UnaryExpression)CastExpression_35_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_36_Var
		);
		//36
		final PostfixExpression PostfixExpression_37_Var
		 = (PostfixExpression)UnaryExpression_36_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_37_Var
		);
		final EList<? extends EObject> Expr_37_list = PostfixExpression_37_Var
		.getExpr();
		Assert.assertNotNull(Expr_37_list);
		Assert.assertEquals(1, Expr_37_list.size());
		//37
		final PrimaryExpression PrimaryExpression_38_Var
		 = (PrimaryExpression)Expr_37_list.get(0);
		Assert.assertNotNull(PrimaryExpression_38_Var
		);
		//38
		final Constant Constant_39_Var
		 = (Constant)PrimaryExpression_38_Var
		.getConst();
		Assert.assertNotNull(Constant_39_Var
		);
		Assert.assertEquals("250", Constant_39_Var
		.getDec());
		final EList<? extends EObject> InitDeclaratorList_39_list = Declaration_3_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_39_list);
		Assert.assertEquals(1, InitDeclaratorList_39_list.size());
		//39
		final InitDeclaratorList InitDeclaratorList_40_Var
		 = (InitDeclaratorList)InitDeclaratorList_39_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_40_Var
		);
		final EList<? extends EObject> InitDeclarator_40_list = InitDeclaratorList_40_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_40_list);
		Assert.assertEquals(1, InitDeclarator_40_list.size());
		//40
		final InitDeclarator InitDeclarator_41_Var
		 = (InitDeclarator)InitDeclarator_40_list.get(0);
		Assert.assertNotNull(InitDeclarator_41_Var
		);
		//41
		final Declarator Declarator_42_Var
		 = (Declarator)InitDeclarator_41_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_42_Var
		);
		//42
		final DirectDeclarator DirectDeclarator_43_Var
		 = (DirectDeclarator)Declarator_42_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_43_Var
		);
		Assert.assertEquals("phil", DirectDeclarator_43_Var
		.getId());
		//43
		final ExternalDeclaration ExternalDeclaration_44_Var
		 = (ExternalDeclaration)External_1_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_44_Var
		);
		//44
		final Declaration Declaration_45_Var
		 = (Declaration)ExternalDeclaration_44_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_45_Var
		);
		//45
		final DeclarationSpecifiers DeclarationSpecifiers_46_Var
		 = (DeclarationSpecifiers)Declaration_45_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_46_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_46_list = DeclarationSpecifiers_46_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_46_list);
		Assert.assertEquals(1, DeclarationSpecifier_46_list.size());
		//46
		final StructOrUnionSpecifier StructOrUnionSpecifier_47_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_46_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_47_Var
		);
		//47
		final StructOrUnion StructOrUnion_48_Var
		 = (StructOrUnion)StructOrUnionSpecifier_47_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_48_Var
		);
		Assert.assertEquals("struct", StructOrUnion_48_Var
		.getName());
		Assert.assertEquals("employee", StructOrUnionSpecifier_47_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_48_list = Declaration_45_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_48_list);
		Assert.assertEquals(1, InitDeclaratorList_48_list.size());
		//48
		final InitDeclaratorList InitDeclaratorList_49_Var
		 = (InitDeclaratorList)InitDeclaratorList_48_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_49_Var
		);
		final EList<? extends EObject> InitDeclarator_49_list = InitDeclaratorList_49_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_49_list);
		Assert.assertEquals(1, InitDeclarator_49_list.size());
		//49
		final InitDeclarator InitDeclarator_50_Var
		 = (InitDeclarator)InitDeclarator_49_list.get(0);
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
		Assert.assertEquals("joe", DirectDeclarator_52_Var
		.getId());
		//52
		final Initializer Initializer_53_Var
		 = (Initializer)InitDeclarator_50_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_53_Var
		);
		//53
		final InitializerList InitializerList_54_Var
		 = (InitializerList)Initializer_53_Var
		.getList();
		Assert.assertNotNull(InitializerList_54_Var
		);
		final EList<? extends EObject> Initializer_54_list = InitializerList_54_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_54_list);
		Assert.assertEquals(2, Initializer_54_list.size());
		//54
		final Initializer Initializer_55_Var
		 = (Initializer)Initializer_54_list.get(0);
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
		final UnaryExpression UnaryExpression_69_Var
		 = (UnaryExpression)CastExpression_68_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_69_Var
		);
		//69
		final PostfixExpression PostfixExpression_70_Var
		 = (PostfixExpression)UnaryExpression_69_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = PostfixExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final PrimaryExpression PrimaryExpression_71_Var
		 = (PrimaryExpression)Expr_70_list.get(0);
		Assert.assertNotNull(PrimaryExpression_71_Var
		);
		//71
		final Constant Constant_72_Var
		 = (Constant)PrimaryExpression_71_Var
		.getConst();
		Assert.assertNotNull(Constant_72_Var
		);
		Assert.assertEquals("0x007", Constant_72_Var
		.getHex());
		//72
		final Initializer Initializer_73_Var
		 = (Initializer)Initializer_54_list.get(1);
		Assert.assertNotNull(Initializer_73_Var
		);
		//73
		final AssignmentExpression AssignmentExpression_74_Var
		 = (AssignmentExpression)Initializer_73_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_74_Var
		);
		//74
		final ConditionalExpression ConditionalExpression_75_Var
		 = (ConditionalExpression)AssignmentExpression_74_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_75_Var
		);
		//75
		final LogicalOrExpression LogicalOrExpression_76_Var
		 = (LogicalOrExpression)ConditionalExpression_75_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_76_Var
		);
		final EList<? extends EObject> Expr_76_list = LogicalOrExpression_76_Var
		.getExpr();
		Assert.assertNotNull(Expr_76_list);
		Assert.assertEquals(1, Expr_76_list.size());
		//76
		final LogicalAndExpression LogicalAndExpression_77_Var
		 = (LogicalAndExpression)Expr_76_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_77_Var
		);
		final EList<? extends EObject> Expr_77_list = LogicalAndExpression_77_Var
		.getExpr();
		Assert.assertNotNull(Expr_77_list);
		Assert.assertEquals(1, Expr_77_list.size());
		//77
		final InclusiveOrExpression InclusiveOrExpression_78_Var
		 = (InclusiveOrExpression)Expr_77_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_78_Var
		);
		final EList<? extends EObject> Expr_78_list = InclusiveOrExpression_78_Var
		.getExpr();
		Assert.assertNotNull(Expr_78_list);
		Assert.assertEquals(1, Expr_78_list.size());
		//78
		final ExclusiveOrExpression ExclusiveOrExpression_79_Var
		 = (ExclusiveOrExpression)Expr_78_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_79_Var
		);
		final EList<? extends EObject> Expr_79_list = ExclusiveOrExpression_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final AndExpression AndExpression_80_Var
		 = (AndExpression)Expr_79_list.get(0);
		Assert.assertNotNull(AndExpression_80_Var
		);
		final EList<? extends EObject> Expr_80_list = AndExpression_80_Var
		.getExpr();
		Assert.assertNotNull(Expr_80_list);
		Assert.assertEquals(1, Expr_80_list.size());
		//80
		final EqualityExpression EqualityExpression_81_Var
		 = (EqualityExpression)Expr_80_list.get(0);
		Assert.assertNotNull(EqualityExpression_81_Var
		);
		final EList<? extends EObject> Expr_81_list = EqualityExpression_81_Var
		.getExpr();
		Assert.assertNotNull(Expr_81_list);
		Assert.assertEquals(1, Expr_81_list.size());
		//81
		final RelationalExpression RelationalExpression_82_Var
		 = (RelationalExpression)Expr_81_list.get(0);
		Assert.assertNotNull(RelationalExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = RelationalExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final ShiftExpression ShiftExpression_83_Var
		 = (ShiftExpression)Expr_82_list.get(0);
		Assert.assertNotNull(ShiftExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = ShiftExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final AdditiveExpression AdditiveExpression_84_Var
		 = (AdditiveExpression)Expr_83_list.get(0);
		Assert.assertNotNull(AdditiveExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = AdditiveExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final MultiplicativeExpression MultiplicativeExpression_85_Var
		 = (MultiplicativeExpression)Expr_84_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = MultiplicativeExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final CastExpression CastExpression_86_Var
		 = (CastExpression)Expr_85_list.get(0);
		Assert.assertNotNull(CastExpression_86_Var
		);
		//86
		final UnaryExpression UnaryExpression_87_Var
		 = (UnaryExpression)CastExpression_86_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_87_Var
		);
		//87
		final PostfixExpression PostfixExpression_88_Var
		 = (PostfixExpression)UnaryExpression_87_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = PostfixExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final PrimaryExpression PrimaryExpression_89_Var
		 = (PrimaryExpression)Expr_88_list.get(0);
		Assert.assertNotNull(PrimaryExpression_89_Var
		);
		//89
		final Constant Constant_90_Var
		 = (Constant)PrimaryExpression_89_Var
		.getConst();
		Assert.assertNotNull(Constant_90_Var
		);
		Assert.assertEquals("\"Joe Nobody\"", Constant_90_Var
		.getStr());
		//90
		final ExternalDeclaration ExternalDeclaration_91_Var
		 = (ExternalDeclaration)External_1_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_91_Var
		);
		//91
		final FunctionDefHead FunctionDefHead_92_Var
		 = (FunctionDefHead)ExternalDeclaration_91_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_92_Var
		);
		//92
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_93_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_92_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_93_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_93_list = FunctionDeclarationSpecifiers_93_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_93_list);
		Assert.assertEquals(1, DeclarationSpecifier_93_list.size());
		//93
		final TypeSpecifier TypeSpecifier_94_Var
		 = (TypeSpecifier)DeclarationSpecifier_93_list.get(0);
		Assert.assertNotNull(TypeSpecifier_94_Var
		);
		Assert.assertEquals("int", TypeSpecifier_94_Var
		.getName());
		//94
		final Declarator Declarator_95_Var
		 = (Declarator)FunctionDefHead_92_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_95_Var
		);
		//95
		final DirectDeclarator DirectDeclarator_96_Var
		 = (DirectDeclarator)Declarator_95_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_96_Var
		);
		Assert.assertEquals("main", DirectDeclarator_96_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_96_list = DirectDeclarator_96_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_96_list);
		Assert.assertEquals(1, DeclaratorSuffix_96_list.size());
		//96
		final DeclaratorSuffix DeclaratorSuffix_97_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_96_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_97_Var
		);
		//97
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_98_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_97_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_98_Var
		);
		final EList<? extends EObject> ParameterTypeList_98_list = DirectDeclaratorLastSuffix_98_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_98_list);
		Assert.assertEquals(1, ParameterTypeList_98_list.size());
		//98
		final ParameterTypeList ParameterTypeList_99_Var
		 = (ParameterTypeList)ParameterTypeList_98_list.get(0);
		Assert.assertNotNull(ParameterTypeList_99_Var
		);
		//99
		final ParameterList ParameterList_100_Var
		 = (ParameterList)ParameterTypeList_99_Var
		.getList();
		Assert.assertNotNull(ParameterList_100_Var
		);
		final EList<? extends EObject> ParameterDeclaration_100_list = ParameterList_100_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_100_list);
		Assert.assertEquals(1, ParameterDeclaration_100_list.size());
		//100
		final ParameterDeclaration ParameterDeclaration_101_Var
		 = (ParameterDeclaration)ParameterDeclaration_100_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_101_Var
		);
		//101
		final DeclarationSpecifiers DeclarationSpecifiers_102_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_101_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_102_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_102_list = DeclarationSpecifiers_102_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_102_list);
		Assert.assertEquals(1, DeclarationSpecifier_102_list.size());
		//102
		final TypeSpecifier TypeSpecifier_103_Var
		 = (TypeSpecifier)DeclarationSpecifier_102_list.get(0);
		Assert.assertNotNull(TypeSpecifier_103_Var
		);
		Assert.assertEquals("void", TypeSpecifier_103_Var
		.getName());
		//103
		final FunctionDefinition FunctionDefinition_104_Var
		 = (FunctionDefinition)ExternalDeclaration_91_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_104_Var
		);
		//104
		final BodyStatement BodyStatement_105_Var
		 = (BodyStatement)FunctionDefinition_104_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_105_Var
		);
		final EList<? extends EObject> BlockList_105_list = BodyStatement_105_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_105_list);
		Assert.assertEquals(1, BlockList_105_list.size());
		//105
		final BlockList BlockList_106_Var
		 = (BlockList)BlockList_105_list.get(0);
		Assert.assertNotNull(BlockList_106_Var
		);
		final EList<? extends EObject> Statement_106_list = BlockList_106_Var
		.getStatement();
		Assert.assertNotNull(Statement_106_list);
		Assert.assertEquals(10, Statement_106_list.size());
		//106
		final Statement Statement_107_Var
		 = (Statement)Statement_106_list.get(0);
		Assert.assertNotNull(Statement_107_Var
		);
		//107
		final ExpressionStatement ExpressionStatement_108_Var
		 = (ExpressionStatement)Statement_107_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_108_Var
		);
		//108
		final Expression Expression_109_Var
		 = (Expression)ExpressionStatement_108_Var
		.getExpression();
		Assert.assertNotNull(Expression_109_Var
		);
		final EList<? extends EObject> ExprExpr_109_list = Expression_109_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_109_list);
		Assert.assertEquals(1, ExprExpr_109_list.size());
		//109
		final AssignmentExpression AssignmentExpression_110_Var
		 = (AssignmentExpression)ExprExpr_109_list.get(0);
		Assert.assertNotNull(AssignmentExpression_110_Var
		);
		//110
		final ConditionalExpression ConditionalExpression_111_Var
		 = (ConditionalExpression)AssignmentExpression_110_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_111_Var
		);
		//111
		final LogicalOrExpression LogicalOrExpression_112_Var
		 = (LogicalOrExpression)ConditionalExpression_111_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = LogicalOrExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final LogicalAndExpression LogicalAndExpression_113_Var
		 = (LogicalAndExpression)Expr_112_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = LogicalAndExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final InclusiveOrExpression InclusiveOrExpression_114_Var
		 = (InclusiveOrExpression)Expr_113_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = InclusiveOrExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final ExclusiveOrExpression ExclusiveOrExpression_115_Var
		 = (ExclusiveOrExpression)Expr_114_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = ExclusiveOrExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final AndExpression AndExpression_116_Var
		 = (AndExpression)Expr_115_list.get(0);
		Assert.assertNotNull(AndExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = AndExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final EqualityExpression EqualityExpression_117_Var
		 = (EqualityExpression)Expr_116_list.get(0);
		Assert.assertNotNull(EqualityExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = EqualityExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final RelationalExpression RelationalExpression_118_Var
		 = (RelationalExpression)Expr_117_list.get(0);
		Assert.assertNotNull(RelationalExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = RelationalExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final ShiftExpression ShiftExpression_119_Var
		 = (ShiftExpression)Expr_118_list.get(0);
		Assert.assertNotNull(ShiftExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = ShiftExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final AdditiveExpression AdditiveExpression_120_Var
		 = (AdditiveExpression)Expr_119_list.get(0);
		Assert.assertNotNull(AdditiveExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = AdditiveExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final MultiplicativeExpression MultiplicativeExpression_121_Var
		 = (MultiplicativeExpression)Expr_120_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = MultiplicativeExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final CastExpression CastExpression_122_Var
		 = (CastExpression)Expr_121_list.get(0);
		Assert.assertNotNull(CastExpression_122_Var
		);
		//122
		final UnaryExpression UnaryExpression_123_Var
		 = (UnaryExpression)CastExpression_122_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_123_Var
		);
		//123
		final PostfixExpression PostfixExpression_124_Var
		 = (PostfixExpression)UnaryExpression_123_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = PostfixExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final PrimaryExpression PrimaryExpression_125_Var
		 = (PrimaryExpression)Expr_124_list.get(0);
		Assert.assertNotNull(PrimaryExpression_125_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_125_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_125_list = PostfixExpression_124_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_125_list);
		Assert.assertEquals(1, ArgumentExpressionList_125_list.size());
		//125
		final ArgumentExpressionList ArgumentExpressionList_126_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_125_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_126_Var
		);
		final EList<? extends EObject> Expr_126_list = ArgumentExpressionList_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(2, Expr_126_list.size());
		//126
		final AssignmentExpression AssignmentExpression_127_Var
		 = (AssignmentExpression)Expr_126_list.get(0);
		Assert.assertNotNull(AssignmentExpression_127_Var
		);
		//127
		final ConditionalExpression ConditionalExpression_128_Var
		 = (ConditionalExpression)AssignmentExpression_127_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_128_Var
		);
		//128
		final LogicalOrExpression LogicalOrExpression_129_Var
		 = (LogicalOrExpression)ConditionalExpression_128_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = LogicalOrExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final LogicalAndExpression LogicalAndExpression_130_Var
		 = (LogicalAndExpression)Expr_129_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = LogicalAndExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final InclusiveOrExpression InclusiveOrExpression_131_Var
		 = (InclusiveOrExpression)Expr_130_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = InclusiveOrExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final ExclusiveOrExpression ExclusiveOrExpression_132_Var
		 = (ExclusiveOrExpression)Expr_131_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = ExclusiveOrExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final AndExpression AndExpression_133_Var
		 = (AndExpression)Expr_132_list.get(0);
		Assert.assertNotNull(AndExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = AndExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final EqualityExpression EqualityExpression_134_Var
		 = (EqualityExpression)Expr_133_list.get(0);
		Assert.assertNotNull(EqualityExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = EqualityExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final RelationalExpression RelationalExpression_135_Var
		 = (RelationalExpression)Expr_134_list.get(0);
		Assert.assertNotNull(RelationalExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = RelationalExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final ShiftExpression ShiftExpression_136_Var
		 = (ShiftExpression)Expr_135_list.get(0);
		Assert.assertNotNull(ShiftExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = ShiftExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final AdditiveExpression AdditiveExpression_137_Var
		 = (AdditiveExpression)Expr_136_list.get(0);
		Assert.assertNotNull(AdditiveExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = AdditiveExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final MultiplicativeExpression MultiplicativeExpression_138_Var
		 = (MultiplicativeExpression)Expr_137_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_138_Var
		);
		final EList<? extends EObject> Expr_138_list = MultiplicativeExpression_138_Var
		.getExpr();
		Assert.assertNotNull(Expr_138_list);
		Assert.assertEquals(1, Expr_138_list.size());
		//138
		final CastExpression CastExpression_139_Var
		 = (CastExpression)Expr_138_list.get(0);
		Assert.assertNotNull(CastExpression_139_Var
		);
		//139
		final UnaryExpression UnaryExpression_140_Var
		 = (UnaryExpression)CastExpression_139_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_140_Var
		);
		//140
		final PostfixExpression PostfixExpression_141_Var
		 = (PostfixExpression)UnaryExpression_140_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_141_Var
		);
		final EList<? extends EObject> Expr_141_list = PostfixExpression_141_Var
		.getExpr();
		Assert.assertNotNull(Expr_141_list);
		Assert.assertEquals(1, Expr_141_list.size());
		//141
		final PrimaryExpression PrimaryExpression_142_Var
		 = (PrimaryExpression)Expr_141_list.get(0);
		Assert.assertNotNull(PrimaryExpression_142_Var
		);
		//142
		final Constant Constant_143_Var
		 = (Constant)PrimaryExpression_142_Var
		.getConst();
		Assert.assertNotNull(Constant_143_Var
		);
		Assert.assertEquals("\"sizeof(joe.id)=%lu\\n\"", Constant_143_Var
		.getStr());
		//143
		final AssignmentExpression AssignmentExpression_144_Var
		 = (AssignmentExpression)Expr_126_list.get(1);
		Assert.assertNotNull(AssignmentExpression_144_Var
		);
		//144
		final ConditionalExpression ConditionalExpression_145_Var
		 = (ConditionalExpression)AssignmentExpression_144_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_145_Var
		);
		//145
		final LogicalOrExpression LogicalOrExpression_146_Var
		 = (LogicalOrExpression)ConditionalExpression_145_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_146_Var
		);
		final EList<? extends EObject> Expr_146_list = LogicalOrExpression_146_Var
		.getExpr();
		Assert.assertNotNull(Expr_146_list);
		Assert.assertEquals(1, Expr_146_list.size());
		//146
		final LogicalAndExpression LogicalAndExpression_147_Var
		 = (LogicalAndExpression)Expr_146_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_147_Var
		);
		final EList<? extends EObject> Expr_147_list = LogicalAndExpression_147_Var
		.getExpr();
		Assert.assertNotNull(Expr_147_list);
		Assert.assertEquals(1, Expr_147_list.size());
		//147
		final InclusiveOrExpression InclusiveOrExpression_148_Var
		 = (InclusiveOrExpression)Expr_147_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_148_Var
		);
		final EList<? extends EObject> Expr_148_list = InclusiveOrExpression_148_Var
		.getExpr();
		Assert.assertNotNull(Expr_148_list);
		Assert.assertEquals(1, Expr_148_list.size());
		//148
		final ExclusiveOrExpression ExclusiveOrExpression_149_Var
		 = (ExclusiveOrExpression)Expr_148_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_149_Var
		);
		final EList<? extends EObject> Expr_149_list = ExclusiveOrExpression_149_Var
		.getExpr();
		Assert.assertNotNull(Expr_149_list);
		Assert.assertEquals(1, Expr_149_list.size());
		//149
		final AndExpression AndExpression_150_Var
		 = (AndExpression)Expr_149_list.get(0);
		Assert.assertNotNull(AndExpression_150_Var
		);
		final EList<? extends EObject> Expr_150_list = AndExpression_150_Var
		.getExpr();
		Assert.assertNotNull(Expr_150_list);
		Assert.assertEquals(1, Expr_150_list.size());
		//150
		final EqualityExpression EqualityExpression_151_Var
		 = (EqualityExpression)Expr_150_list.get(0);
		Assert.assertNotNull(EqualityExpression_151_Var
		);
		final EList<? extends EObject> Expr_151_list = EqualityExpression_151_Var
		.getExpr();
		Assert.assertNotNull(Expr_151_list);
		Assert.assertEquals(1, Expr_151_list.size());
		//151
		final RelationalExpression RelationalExpression_152_Var
		 = (RelationalExpression)Expr_151_list.get(0);
		Assert.assertNotNull(RelationalExpression_152_Var
		);
		final EList<? extends EObject> Expr_152_list = RelationalExpression_152_Var
		.getExpr();
		Assert.assertNotNull(Expr_152_list);
		Assert.assertEquals(1, Expr_152_list.size());
		//152
		final ShiftExpression ShiftExpression_153_Var
		 = (ShiftExpression)Expr_152_list.get(0);
		Assert.assertNotNull(ShiftExpression_153_Var
		);
		final EList<? extends EObject> Expr_153_list = ShiftExpression_153_Var
		.getExpr();
		Assert.assertNotNull(Expr_153_list);
		Assert.assertEquals(1, Expr_153_list.size());
		//153
		final AdditiveExpression AdditiveExpression_154_Var
		 = (AdditiveExpression)Expr_153_list.get(0);
		Assert.assertNotNull(AdditiveExpression_154_Var
		);
		final EList<? extends EObject> Expr_154_list = AdditiveExpression_154_Var
		.getExpr();
		Assert.assertNotNull(Expr_154_list);
		Assert.assertEquals(1, Expr_154_list.size());
		//154
		final MultiplicativeExpression MultiplicativeExpression_155_Var
		 = (MultiplicativeExpression)Expr_154_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_155_Var
		);
		final EList<? extends EObject> Expr_155_list = MultiplicativeExpression_155_Var
		.getExpr();
		Assert.assertNotNull(Expr_155_list);
		Assert.assertEquals(1, Expr_155_list.size());
		//155
		final CastExpression CastExpression_156_Var
		 = (CastExpression)Expr_155_list.get(0);
		Assert.assertNotNull(CastExpression_156_Var
		);
		//156
		final UnaryExpression UnaryExpression_157_Var
		 = (UnaryExpression)CastExpression_156_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_157_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_157_Var
		.getSizeOf());
		//157
		final UnaryExpression UnaryExpression_158_Var
		 = (UnaryExpression)UnaryExpression_157_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_158_Var
		);
		//158
		final PostfixExpression PostfixExpression_159_Var
		 = (PostfixExpression)UnaryExpression_158_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_159_Var
		);
		final EList<? extends EObject> Expr_159_list = PostfixExpression_159_Var
		.getExpr();
		Assert.assertNotNull(Expr_159_list);
		Assert.assertEquals(1, Expr_159_list.size());
		//159
		final PrimaryExpression PrimaryExpression_160_Var
		 = (PrimaryExpression)Expr_159_list.get(0);
		Assert.assertNotNull(PrimaryExpression_160_Var
		);
		//160
		final Expression Expression_161_Var
		 = (Expression)PrimaryExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expression_161_Var
		);
		final EList<? extends EObject> ExprExpr_161_list = Expression_161_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_161_list);
		Assert.assertEquals(1, ExprExpr_161_list.size());
		//161
		final AssignmentExpression AssignmentExpression_162_Var
		 = (AssignmentExpression)ExprExpr_161_list.get(0);
		Assert.assertNotNull(AssignmentExpression_162_Var
		);
		//162
		final ConditionalExpression ConditionalExpression_163_Var
		 = (ConditionalExpression)AssignmentExpression_162_Var
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
		Assert.assertEquals("joe", PrimaryExpression_177_Var
		.getId());
		Assert.assertEquals("[.]", PostfixExpression_176_Var
		.getDot().toString());
		Assert.assertEquals("[id]", PostfixExpression_176_Var
		.getId().toString());
		Assert.assertEquals(";", ExpressionStatement_108_Var
		.getSemi());
		//177
		final Statement Statement_178_Var
		 = (Statement)Statement_106_list.get(1);
		Assert.assertNotNull(Statement_178_Var
		);
		//178
		final ExpressionStatement ExpressionStatement_179_Var
		 = (ExpressionStatement)Statement_178_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_179_Var
		);
		//179
		final Expression Expression_180_Var
		 = (Expression)ExpressionStatement_179_Var
		.getExpression();
		Assert.assertNotNull(Expression_180_Var
		);
		final EList<? extends EObject> ExprExpr_180_list = Expression_180_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_180_list);
		Assert.assertEquals(1, ExprExpr_180_list.size());
		//180
		final AssignmentExpression AssignmentExpression_181_Var
		 = (AssignmentExpression)ExprExpr_180_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_196_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_196_list = PostfixExpression_195_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_196_list);
		Assert.assertEquals(1, ArgumentExpressionList_196_list.size());
		//196
		final ArgumentExpressionList ArgumentExpressionList_197_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_196_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_197_Var
		);
		final EList<? extends EObject> Expr_197_list = ArgumentExpressionList_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(2, Expr_197_list.size());
		//197
		final AssignmentExpression AssignmentExpression_198_Var
		 = (AssignmentExpression)Expr_197_list.get(0);
		Assert.assertNotNull(AssignmentExpression_198_Var
		);
		//198
		final ConditionalExpression ConditionalExpression_199_Var
		 = (ConditionalExpression)AssignmentExpression_198_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_199_Var
		);
		//199
		final LogicalOrExpression LogicalOrExpression_200_Var
		 = (LogicalOrExpression)ConditionalExpression_199_Var
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
		//213
		final Constant Constant_214_Var
		 = (Constant)PrimaryExpression_213_Var
		.getConst();
		Assert.assertNotNull(Constant_214_Var
		);
		Assert.assertEquals("\"sizeof(joe.name)=%lu\\n\"", Constant_214_Var
		.getStr());
		//214
		final AssignmentExpression AssignmentExpression_215_Var
		 = (AssignmentExpression)Expr_197_list.get(1);
		Assert.assertNotNull(AssignmentExpression_215_Var
		);
		//215
		final ConditionalExpression ConditionalExpression_216_Var
		 = (ConditionalExpression)AssignmentExpression_215_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_216_Var
		);
		//216
		final LogicalOrExpression LogicalOrExpression_217_Var
		 = (LogicalOrExpression)ConditionalExpression_216_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = LogicalOrExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final LogicalAndExpression LogicalAndExpression_218_Var
		 = (LogicalAndExpression)Expr_217_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = LogicalAndExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final InclusiveOrExpression InclusiveOrExpression_219_Var
		 = (InclusiveOrExpression)Expr_218_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = InclusiveOrExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final ExclusiveOrExpression ExclusiveOrExpression_220_Var
		 = (ExclusiveOrExpression)Expr_219_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = ExclusiveOrExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final AndExpression AndExpression_221_Var
		 = (AndExpression)Expr_220_list.get(0);
		Assert.assertNotNull(AndExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = AndExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final EqualityExpression EqualityExpression_222_Var
		 = (EqualityExpression)Expr_221_list.get(0);
		Assert.assertNotNull(EqualityExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = EqualityExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final RelationalExpression RelationalExpression_223_Var
		 = (RelationalExpression)Expr_222_list.get(0);
		Assert.assertNotNull(RelationalExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = RelationalExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final ShiftExpression ShiftExpression_224_Var
		 = (ShiftExpression)Expr_223_list.get(0);
		Assert.assertNotNull(ShiftExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = ShiftExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final AdditiveExpression AdditiveExpression_225_Var
		 = (AdditiveExpression)Expr_224_list.get(0);
		Assert.assertNotNull(AdditiveExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = AdditiveExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final MultiplicativeExpression MultiplicativeExpression_226_Var
		 = (MultiplicativeExpression)Expr_225_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = MultiplicativeExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final CastExpression CastExpression_227_Var
		 = (CastExpression)Expr_226_list.get(0);
		Assert.assertNotNull(CastExpression_227_Var
		);
		//227
		final UnaryExpression UnaryExpression_228_Var
		 = (UnaryExpression)CastExpression_227_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_228_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_228_Var
		.getSizeOf());
		//228
		final UnaryExpression UnaryExpression_229_Var
		 = (UnaryExpression)UnaryExpression_228_Var
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
		final Expression Expression_232_Var
		 = (Expression)PrimaryExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expression_232_Var
		);
		final EList<? extends EObject> ExprExpr_232_list = Expression_232_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_232_list);
		Assert.assertEquals(1, ExprExpr_232_list.size());
		//232
		final AssignmentExpression AssignmentExpression_233_Var
		 = (AssignmentExpression)ExprExpr_232_list.get(0);
		Assert.assertNotNull(AssignmentExpression_233_Var
		);
		//233
		final ConditionalExpression ConditionalExpression_234_Var
		 = (ConditionalExpression)AssignmentExpression_233_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_234_Var
		);
		//234
		final LogicalOrExpression LogicalOrExpression_235_Var
		 = (LogicalOrExpression)ConditionalExpression_234_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_235_Var
		);
		final EList<? extends EObject> Expr_235_list = LogicalOrExpression_235_Var
		.getExpr();
		Assert.assertNotNull(Expr_235_list);
		Assert.assertEquals(1, Expr_235_list.size());
		//235
		final LogicalAndExpression LogicalAndExpression_236_Var
		 = (LogicalAndExpression)Expr_235_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_236_Var
		);
		final EList<? extends EObject> Expr_236_list = LogicalAndExpression_236_Var
		.getExpr();
		Assert.assertNotNull(Expr_236_list);
		Assert.assertEquals(1, Expr_236_list.size());
		//236
		final InclusiveOrExpression InclusiveOrExpression_237_Var
		 = (InclusiveOrExpression)Expr_236_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = InclusiveOrExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final ExclusiveOrExpression ExclusiveOrExpression_238_Var
		 = (ExclusiveOrExpression)Expr_237_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_238_Var
		);
		final EList<? extends EObject> Expr_238_list = ExclusiveOrExpression_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(1, Expr_238_list.size());
		//238
		final AndExpression AndExpression_239_Var
		 = (AndExpression)Expr_238_list.get(0);
		Assert.assertNotNull(AndExpression_239_Var
		);
		final EList<? extends EObject> Expr_239_list = AndExpression_239_Var
		.getExpr();
		Assert.assertNotNull(Expr_239_list);
		Assert.assertEquals(1, Expr_239_list.size());
		//239
		final EqualityExpression EqualityExpression_240_Var
		 = (EqualityExpression)Expr_239_list.get(0);
		Assert.assertNotNull(EqualityExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = EqualityExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final RelationalExpression RelationalExpression_241_Var
		 = (RelationalExpression)Expr_240_list.get(0);
		Assert.assertNotNull(RelationalExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = RelationalExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final ShiftExpression ShiftExpression_242_Var
		 = (ShiftExpression)Expr_241_list.get(0);
		Assert.assertNotNull(ShiftExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = ShiftExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final AdditiveExpression AdditiveExpression_243_Var
		 = (AdditiveExpression)Expr_242_list.get(0);
		Assert.assertNotNull(AdditiveExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = AdditiveExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final MultiplicativeExpression MultiplicativeExpression_244_Var
		 = (MultiplicativeExpression)Expr_243_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = MultiplicativeExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final CastExpression CastExpression_245_Var
		 = (CastExpression)Expr_244_list.get(0);
		Assert.assertNotNull(CastExpression_245_Var
		);
		//245
		final UnaryExpression UnaryExpression_246_Var
		 = (UnaryExpression)CastExpression_245_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_246_Var
		);
		//246
		final PostfixExpression PostfixExpression_247_Var
		 = (PostfixExpression)UnaryExpression_246_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = PostfixExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final PrimaryExpression PrimaryExpression_248_Var
		 = (PrimaryExpression)Expr_247_list.get(0);
		Assert.assertNotNull(PrimaryExpression_248_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_248_Var
		.getId());
		Assert.assertEquals("[.]", PostfixExpression_247_Var
		.getDot().toString());
		Assert.assertEquals("[name]", PostfixExpression_247_Var
		.getId().toString());
		Assert.assertEquals(";", ExpressionStatement_179_Var
		.getSemi());
		//248
		final Statement Statement_249_Var
		 = (Statement)Statement_106_list.get(2);
		Assert.assertNotNull(Statement_249_Var
		);
		//249
		final ExpressionStatement ExpressionStatement_250_Var
		 = (ExpressionStatement)Statement_249_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_250_Var
		);
		//250
		final Expression Expression_251_Var
		 = (Expression)ExpressionStatement_250_Var
		.getExpression();
		Assert.assertNotNull(Expression_251_Var
		);
		final EList<? extends EObject> ExprExpr_251_list = Expression_251_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_251_list);
		Assert.assertEquals(1, ExprExpr_251_list.size());
		//251
		final AssignmentExpression AssignmentExpression_252_Var
		 = (AssignmentExpression)ExprExpr_251_list.get(0);
		Assert.assertNotNull(AssignmentExpression_252_Var
		);
		//252
		final ConditionalExpression ConditionalExpression_253_Var
		 = (ConditionalExpression)AssignmentExpression_252_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_253_Var
		);
		//253
		final LogicalOrExpression LogicalOrExpression_254_Var
		 = (LogicalOrExpression)ConditionalExpression_253_Var
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
		Assert.assertEquals("printf", PrimaryExpression_267_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_267_list = PostfixExpression_266_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_267_list);
		Assert.assertEquals(1, ArgumentExpressionList_267_list.size());
		//267
		final ArgumentExpressionList ArgumentExpressionList_268_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_267_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_268_Var
		);
		final EList<? extends EObject> Expr_268_list = ArgumentExpressionList_268_Var
		.getExpr();
		Assert.assertNotNull(Expr_268_list);
		Assert.assertEquals(2, Expr_268_list.size());
		//268
		final AssignmentExpression AssignmentExpression_269_Var
		 = (AssignmentExpression)Expr_268_list.get(0);
		Assert.assertNotNull(AssignmentExpression_269_Var
		);
		//269
		final ConditionalExpression ConditionalExpression_270_Var
		 = (ConditionalExpression)AssignmentExpression_269_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_270_Var
		);
		//270
		final LogicalOrExpression LogicalOrExpression_271_Var
		 = (LogicalOrExpression)ConditionalExpression_270_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_271_Var
		);
		final EList<? extends EObject> Expr_271_list = LogicalOrExpression_271_Var
		.getExpr();
		Assert.assertNotNull(Expr_271_list);
		Assert.assertEquals(1, Expr_271_list.size());
		//271
		final LogicalAndExpression LogicalAndExpression_272_Var
		 = (LogicalAndExpression)Expr_271_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_272_Var
		);
		final EList<? extends EObject> Expr_272_list = LogicalAndExpression_272_Var
		.getExpr();
		Assert.assertNotNull(Expr_272_list);
		Assert.assertEquals(1, Expr_272_list.size());
		//272
		final InclusiveOrExpression InclusiveOrExpression_273_Var
		 = (InclusiveOrExpression)Expr_272_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_273_Var
		);
		final EList<? extends EObject> Expr_273_list = InclusiveOrExpression_273_Var
		.getExpr();
		Assert.assertNotNull(Expr_273_list);
		Assert.assertEquals(1, Expr_273_list.size());
		//273
		final ExclusiveOrExpression ExclusiveOrExpression_274_Var
		 = (ExclusiveOrExpression)Expr_273_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_274_Var
		);
		final EList<? extends EObject> Expr_274_list = ExclusiveOrExpression_274_Var
		.getExpr();
		Assert.assertNotNull(Expr_274_list);
		Assert.assertEquals(1, Expr_274_list.size());
		//274
		final AndExpression AndExpression_275_Var
		 = (AndExpression)Expr_274_list.get(0);
		Assert.assertNotNull(AndExpression_275_Var
		);
		final EList<? extends EObject> Expr_275_list = AndExpression_275_Var
		.getExpr();
		Assert.assertNotNull(Expr_275_list);
		Assert.assertEquals(1, Expr_275_list.size());
		//275
		final EqualityExpression EqualityExpression_276_Var
		 = (EqualityExpression)Expr_275_list.get(0);
		Assert.assertNotNull(EqualityExpression_276_Var
		);
		final EList<? extends EObject> Expr_276_list = EqualityExpression_276_Var
		.getExpr();
		Assert.assertNotNull(Expr_276_list);
		Assert.assertEquals(1, Expr_276_list.size());
		//276
		final RelationalExpression RelationalExpression_277_Var
		 = (RelationalExpression)Expr_276_list.get(0);
		Assert.assertNotNull(RelationalExpression_277_Var
		);
		final EList<? extends EObject> Expr_277_list = RelationalExpression_277_Var
		.getExpr();
		Assert.assertNotNull(Expr_277_list);
		Assert.assertEquals(1, Expr_277_list.size());
		//277
		final ShiftExpression ShiftExpression_278_Var
		 = (ShiftExpression)Expr_277_list.get(0);
		Assert.assertNotNull(ShiftExpression_278_Var
		);
		final EList<? extends EObject> Expr_278_list = ShiftExpression_278_Var
		.getExpr();
		Assert.assertNotNull(Expr_278_list);
		Assert.assertEquals(1, Expr_278_list.size());
		//278
		final AdditiveExpression AdditiveExpression_279_Var
		 = (AdditiveExpression)Expr_278_list.get(0);
		Assert.assertNotNull(AdditiveExpression_279_Var
		);
		final EList<? extends EObject> Expr_279_list = AdditiveExpression_279_Var
		.getExpr();
		Assert.assertNotNull(Expr_279_list);
		Assert.assertEquals(1, Expr_279_list.size());
		//279
		final MultiplicativeExpression MultiplicativeExpression_280_Var
		 = (MultiplicativeExpression)Expr_279_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_280_Var
		);
		final EList<? extends EObject> Expr_280_list = MultiplicativeExpression_280_Var
		.getExpr();
		Assert.assertNotNull(Expr_280_list);
		Assert.assertEquals(1, Expr_280_list.size());
		//280
		final CastExpression CastExpression_281_Var
		 = (CastExpression)Expr_280_list.get(0);
		Assert.assertNotNull(CastExpression_281_Var
		);
		//281
		final UnaryExpression UnaryExpression_282_Var
		 = (UnaryExpression)CastExpression_281_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_282_Var
		);
		//282
		final PostfixExpression PostfixExpression_283_Var
		 = (PostfixExpression)UnaryExpression_282_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_283_Var
		);
		final EList<? extends EObject> Expr_283_list = PostfixExpression_283_Var
		.getExpr();
		Assert.assertNotNull(Expr_283_list);
		Assert.assertEquals(1, Expr_283_list.size());
		//283
		final PrimaryExpression PrimaryExpression_284_Var
		 = (PrimaryExpression)Expr_283_list.get(0);
		Assert.assertNotNull(PrimaryExpression_284_Var
		);
		//284
		final Constant Constant_285_Var
		 = (Constant)PrimaryExpression_284_Var
		.getConst();
		Assert.assertNotNull(Constant_285_Var
		);
		Assert.assertEquals("\"sizeof(joe)=%lu\\n\"", Constant_285_Var
		.getStr());
		//285
		final AssignmentExpression AssignmentExpression_286_Var
		 = (AssignmentExpression)Expr_268_list.get(1);
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
		Assert.assertEquals("sizeof", UnaryExpression_299_Var
		.getSizeOf());
		//299
		final UnaryExpression UnaryExpression_300_Var
		 = (UnaryExpression)UnaryExpression_299_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_300_Var
		);
		//300
		final PostfixExpression PostfixExpression_301_Var
		 = (PostfixExpression)UnaryExpression_300_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_301_Var
		);
		final EList<? extends EObject> Expr_301_list = PostfixExpression_301_Var
		.getExpr();
		Assert.assertNotNull(Expr_301_list);
		Assert.assertEquals(1, Expr_301_list.size());
		//301
		final PrimaryExpression PrimaryExpression_302_Var
		 = (PrimaryExpression)Expr_301_list.get(0);
		Assert.assertNotNull(PrimaryExpression_302_Var
		);
		//302
		final Expression Expression_303_Var
		 = (Expression)PrimaryExpression_302_Var
		.getExpr();
		Assert.assertNotNull(Expression_303_Var
		);
		final EList<? extends EObject> ExprExpr_303_list = Expression_303_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_303_list);
		Assert.assertEquals(1, ExprExpr_303_list.size());
		//303
		final AssignmentExpression AssignmentExpression_304_Var
		 = (AssignmentExpression)ExprExpr_303_list.get(0);
		Assert.assertNotNull(AssignmentExpression_304_Var
		);
		//304
		final ConditionalExpression ConditionalExpression_305_Var
		 = (ConditionalExpression)AssignmentExpression_304_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_305_Var
		);
		//305
		final LogicalOrExpression LogicalOrExpression_306_Var
		 = (LogicalOrExpression)ConditionalExpression_305_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_306_Var
		);
		final EList<? extends EObject> Expr_306_list = LogicalOrExpression_306_Var
		.getExpr();
		Assert.assertNotNull(Expr_306_list);
		Assert.assertEquals(1, Expr_306_list.size());
		//306
		final LogicalAndExpression LogicalAndExpression_307_Var
		 = (LogicalAndExpression)Expr_306_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_307_Var
		);
		final EList<? extends EObject> Expr_307_list = LogicalAndExpression_307_Var
		.getExpr();
		Assert.assertNotNull(Expr_307_list);
		Assert.assertEquals(1, Expr_307_list.size());
		//307
		final InclusiveOrExpression InclusiveOrExpression_308_Var
		 = (InclusiveOrExpression)Expr_307_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_308_Var
		);
		final EList<? extends EObject> Expr_308_list = InclusiveOrExpression_308_Var
		.getExpr();
		Assert.assertNotNull(Expr_308_list);
		Assert.assertEquals(1, Expr_308_list.size());
		//308
		final ExclusiveOrExpression ExclusiveOrExpression_309_Var
		 = (ExclusiveOrExpression)Expr_308_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_309_Var
		);
		final EList<? extends EObject> Expr_309_list = ExclusiveOrExpression_309_Var
		.getExpr();
		Assert.assertNotNull(Expr_309_list);
		Assert.assertEquals(1, Expr_309_list.size());
		//309
		final AndExpression AndExpression_310_Var
		 = (AndExpression)Expr_309_list.get(0);
		Assert.assertNotNull(AndExpression_310_Var
		);
		final EList<? extends EObject> Expr_310_list = AndExpression_310_Var
		.getExpr();
		Assert.assertNotNull(Expr_310_list);
		Assert.assertEquals(1, Expr_310_list.size());
		//310
		final EqualityExpression EqualityExpression_311_Var
		 = (EqualityExpression)Expr_310_list.get(0);
		Assert.assertNotNull(EqualityExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = EqualityExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final RelationalExpression RelationalExpression_312_Var
		 = (RelationalExpression)Expr_311_list.get(0);
		Assert.assertNotNull(RelationalExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = RelationalExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final ShiftExpression ShiftExpression_313_Var
		 = (ShiftExpression)Expr_312_list.get(0);
		Assert.assertNotNull(ShiftExpression_313_Var
		);
		final EList<? extends EObject> Expr_313_list = ShiftExpression_313_Var
		.getExpr();
		Assert.assertNotNull(Expr_313_list);
		Assert.assertEquals(1, Expr_313_list.size());
		//313
		final AdditiveExpression AdditiveExpression_314_Var
		 = (AdditiveExpression)Expr_313_list.get(0);
		Assert.assertNotNull(AdditiveExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = AdditiveExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final MultiplicativeExpression MultiplicativeExpression_315_Var
		 = (MultiplicativeExpression)Expr_314_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = MultiplicativeExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final CastExpression CastExpression_316_Var
		 = (CastExpression)Expr_315_list.get(0);
		Assert.assertNotNull(CastExpression_316_Var
		);
		//316
		final UnaryExpression UnaryExpression_317_Var
		 = (UnaryExpression)CastExpression_316_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_317_Var
		);
		//317
		final PostfixExpression PostfixExpression_318_Var
		 = (PostfixExpression)UnaryExpression_317_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_318_Var
		);
		final EList<? extends EObject> Expr_318_list = PostfixExpression_318_Var
		.getExpr();
		Assert.assertNotNull(Expr_318_list);
		Assert.assertEquals(1, Expr_318_list.size());
		//318
		final PrimaryExpression PrimaryExpression_319_Var
		 = (PrimaryExpression)Expr_318_list.get(0);
		Assert.assertNotNull(PrimaryExpression_319_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_319_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_250_Var
		.getSemi());
		//319
		final Statement Statement_320_Var
		 = (Statement)Statement_106_list.get(3);
		Assert.assertNotNull(Statement_320_Var
		);
		//320
		final ExpressionStatement ExpressionStatement_321_Var
		 = (ExpressionStatement)Statement_320_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_321_Var
		);
		//321
		final Expression Expression_322_Var
		 = (Expression)ExpressionStatement_321_Var
		.getExpression();
		Assert.assertNotNull(Expression_322_Var
		);
		final EList<? extends EObject> ExprExpr_322_list = Expression_322_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_322_list);
		Assert.assertEquals(1, ExprExpr_322_list.size());
		//322
		final AssignmentExpression AssignmentExpression_323_Var
		 = (AssignmentExpression)ExprExpr_322_list.get(0);
		Assert.assertNotNull(AssignmentExpression_323_Var
		);
		//323
		final UnaryExpression UnaryExpression_324_Var
		 = (UnaryExpression)AssignmentExpression_323_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_324_Var
		);
		//324
		final PostfixExpression PostfixExpression_325_Var
		 = (PostfixExpression)UnaryExpression_324_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_325_Var
		);
		final EList<? extends EObject> Expr_325_list = PostfixExpression_325_Var
		.getExpr();
		Assert.assertNotNull(Expr_325_list);
		Assert.assertEquals(1, Expr_325_list.size());
		//325
		final PrimaryExpression PrimaryExpression_326_Var
		 = (PrimaryExpression)Expr_325_list.get(0);
		Assert.assertNotNull(PrimaryExpression_326_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_326_Var
		.getId());
		Assert.assertEquals("[.]", PostfixExpression_325_Var
		.getDot().toString());
		Assert.assertEquals("[id]", PostfixExpression_325_Var
		.getId().toString());
		//326
		final AssignmentOperator AssignmentOperator_327_Var
		 = (AssignmentOperator)AssignmentExpression_323_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_327_Var
		);
		Assert.assertEquals("=", AssignmentOperator_327_Var
		.getOp());
		//327
		final AssignmentExpression AssignmentExpression_328_Var
		 = (AssignmentExpression)AssignmentExpression_323_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_328_Var
		);
		//328
		final ConditionalExpression ConditionalExpression_329_Var
		 = (ConditionalExpression)AssignmentExpression_328_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_329_Var
		);
		//329
		final LogicalOrExpression LogicalOrExpression_330_Var
		 = (LogicalOrExpression)ConditionalExpression_329_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_330_Var
		);
		final EList<? extends EObject> Expr_330_list = LogicalOrExpression_330_Var
		.getExpr();
		Assert.assertNotNull(Expr_330_list);
		Assert.assertEquals(1, Expr_330_list.size());
		//330
		final LogicalAndExpression LogicalAndExpression_331_Var
		 = (LogicalAndExpression)Expr_330_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_331_Var
		);
		final EList<? extends EObject> Expr_331_list = LogicalAndExpression_331_Var
		.getExpr();
		Assert.assertNotNull(Expr_331_list);
		Assert.assertEquals(1, Expr_331_list.size());
		//331
		final InclusiveOrExpression InclusiveOrExpression_332_Var
		 = (InclusiveOrExpression)Expr_331_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_332_Var
		);
		final EList<? extends EObject> Expr_332_list = InclusiveOrExpression_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final ExclusiveOrExpression ExclusiveOrExpression_333_Var
		 = (ExclusiveOrExpression)Expr_332_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_333_Var
		);
		final EList<? extends EObject> Expr_333_list = ExclusiveOrExpression_333_Var
		.getExpr();
		Assert.assertNotNull(Expr_333_list);
		Assert.assertEquals(1, Expr_333_list.size());
		//333
		final AndExpression AndExpression_334_Var
		 = (AndExpression)Expr_333_list.get(0);
		Assert.assertNotNull(AndExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = AndExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final EqualityExpression EqualityExpression_335_Var
		 = (EqualityExpression)Expr_334_list.get(0);
		Assert.assertNotNull(EqualityExpression_335_Var
		);
		final EList<? extends EObject> Expr_335_list = EqualityExpression_335_Var
		.getExpr();
		Assert.assertNotNull(Expr_335_list);
		Assert.assertEquals(1, Expr_335_list.size());
		//335
		final RelationalExpression RelationalExpression_336_Var
		 = (RelationalExpression)Expr_335_list.get(0);
		Assert.assertNotNull(RelationalExpression_336_Var
		);
		final EList<? extends EObject> Expr_336_list = RelationalExpression_336_Var
		.getExpr();
		Assert.assertNotNull(Expr_336_list);
		Assert.assertEquals(1, Expr_336_list.size());
		//336
		final ShiftExpression ShiftExpression_337_Var
		 = (ShiftExpression)Expr_336_list.get(0);
		Assert.assertNotNull(ShiftExpression_337_Var
		);
		final EList<? extends EObject> Expr_337_list = ShiftExpression_337_Var
		.getExpr();
		Assert.assertNotNull(Expr_337_list);
		Assert.assertEquals(1, Expr_337_list.size());
		//337
		final AdditiveExpression AdditiveExpression_338_Var
		 = (AdditiveExpression)Expr_337_list.get(0);
		Assert.assertNotNull(AdditiveExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = AdditiveExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final MultiplicativeExpression MultiplicativeExpression_339_Var
		 = (MultiplicativeExpression)Expr_338_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_339_Var
		);
		final EList<? extends EObject> Expr_339_list = MultiplicativeExpression_339_Var
		.getExpr();
		Assert.assertNotNull(Expr_339_list);
		Assert.assertEquals(1, Expr_339_list.size());
		//339
		final CastExpression CastExpression_340_Var
		 = (CastExpression)Expr_339_list.get(0);
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
		//343
		final Constant Constant_344_Var
		 = (Constant)PrimaryExpression_343_Var
		.getConst();
		Assert.assertNotNull(Constant_344_Var
		);
		Assert.assertEquals("0x008", Constant_344_Var
		.getHex());
		Assert.assertEquals(";", ExpressionStatement_321_Var
		.getSemi());
		//344
		final Statement Statement_345_Var
		 = (Statement)Statement_106_list.get(4);
		Assert.assertNotNull(Statement_345_Var
		);
		//345
		final ExpressionStatement ExpressionStatement_346_Var
		 = (ExpressionStatement)Statement_345_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_346_Var
		);
		//346
		final Expression Expression_347_Var
		 = (Expression)ExpressionStatement_346_Var
		.getExpression();
		Assert.assertNotNull(Expression_347_Var
		);
		final EList<? extends EObject> ExprExpr_347_list = Expression_347_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_347_list);
		Assert.assertEquals(1, ExprExpr_347_list.size());
		//347
		final AssignmentExpression AssignmentExpression_348_Var
		 = (AssignmentExpression)ExprExpr_347_list.get(0);
		Assert.assertNotNull(AssignmentExpression_348_Var
		);
		//348
		final ConditionalExpression ConditionalExpression_349_Var
		 = (ConditionalExpression)AssignmentExpression_348_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_349_Var
		);
		//349
		final LogicalOrExpression LogicalOrExpression_350_Var
		 = (LogicalOrExpression)ConditionalExpression_349_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_350_Var
		);
		final EList<? extends EObject> Expr_350_list = LogicalOrExpression_350_Var
		.getExpr();
		Assert.assertNotNull(Expr_350_list);
		Assert.assertEquals(1, Expr_350_list.size());
		//350
		final LogicalAndExpression LogicalAndExpression_351_Var
		 = (LogicalAndExpression)Expr_350_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_351_Var
		);
		final EList<? extends EObject> Expr_351_list = LogicalAndExpression_351_Var
		.getExpr();
		Assert.assertNotNull(Expr_351_list);
		Assert.assertEquals(1, Expr_351_list.size());
		//351
		final InclusiveOrExpression InclusiveOrExpression_352_Var
		 = (InclusiveOrExpression)Expr_351_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_352_Var
		);
		final EList<? extends EObject> Expr_352_list = InclusiveOrExpression_352_Var
		.getExpr();
		Assert.assertNotNull(Expr_352_list);
		Assert.assertEquals(1, Expr_352_list.size());
		//352
		final ExclusiveOrExpression ExclusiveOrExpression_353_Var
		 = (ExclusiveOrExpression)Expr_352_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_353_Var
		);
		final EList<? extends EObject> Expr_353_list = ExclusiveOrExpression_353_Var
		.getExpr();
		Assert.assertNotNull(Expr_353_list);
		Assert.assertEquals(1, Expr_353_list.size());
		//353
		final AndExpression AndExpression_354_Var
		 = (AndExpression)Expr_353_list.get(0);
		Assert.assertNotNull(AndExpression_354_Var
		);
		final EList<? extends EObject> Expr_354_list = AndExpression_354_Var
		.getExpr();
		Assert.assertNotNull(Expr_354_list);
		Assert.assertEquals(1, Expr_354_list.size());
		//354
		final EqualityExpression EqualityExpression_355_Var
		 = (EqualityExpression)Expr_354_list.get(0);
		Assert.assertNotNull(EqualityExpression_355_Var
		);
		final EList<? extends EObject> Expr_355_list = EqualityExpression_355_Var
		.getExpr();
		Assert.assertNotNull(Expr_355_list);
		Assert.assertEquals(1, Expr_355_list.size());
		//355
		final RelationalExpression RelationalExpression_356_Var
		 = (RelationalExpression)Expr_355_list.get(0);
		Assert.assertNotNull(RelationalExpression_356_Var
		);
		final EList<? extends EObject> Expr_356_list = RelationalExpression_356_Var
		.getExpr();
		Assert.assertNotNull(Expr_356_list);
		Assert.assertEquals(1, Expr_356_list.size());
		//356
		final ShiftExpression ShiftExpression_357_Var
		 = (ShiftExpression)Expr_356_list.get(0);
		Assert.assertNotNull(ShiftExpression_357_Var
		);
		final EList<? extends EObject> Expr_357_list = ShiftExpression_357_Var
		.getExpr();
		Assert.assertNotNull(Expr_357_list);
		Assert.assertEquals(1, Expr_357_list.size());
		//357
		final AdditiveExpression AdditiveExpression_358_Var
		 = (AdditiveExpression)Expr_357_list.get(0);
		Assert.assertNotNull(AdditiveExpression_358_Var
		);
		final EList<? extends EObject> Expr_358_list = AdditiveExpression_358_Var
		.getExpr();
		Assert.assertNotNull(Expr_358_list);
		Assert.assertEquals(1, Expr_358_list.size());
		//358
		final MultiplicativeExpression MultiplicativeExpression_359_Var
		 = (MultiplicativeExpression)Expr_358_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_359_Var
		);
		final EList<? extends EObject> Expr_359_list = MultiplicativeExpression_359_Var
		.getExpr();
		Assert.assertNotNull(Expr_359_list);
		Assert.assertEquals(1, Expr_359_list.size());
		//359
		final CastExpression CastExpression_360_Var
		 = (CastExpression)Expr_359_list.get(0);
		Assert.assertNotNull(CastExpression_360_Var
		);
		//360
		final UnaryExpression UnaryExpression_361_Var
		 = (UnaryExpression)CastExpression_360_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_361_Var
		);
		//361
		final PostfixExpression PostfixExpression_362_Var
		 = (PostfixExpression)UnaryExpression_361_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_362_Var
		);
		final EList<? extends EObject> Expr_362_list = PostfixExpression_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(1, Expr_362_list.size());
		//362
		final PrimaryExpression PrimaryExpression_363_Var
		 = (PrimaryExpression)Expr_362_list.get(0);
		Assert.assertNotNull(PrimaryExpression_363_Var
		);
		Assert.assertEquals("strcpy", PrimaryExpression_363_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_363_list = PostfixExpression_362_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_363_list);
		Assert.assertEquals(1, ArgumentExpressionList_363_list.size());
		//363
		final ArgumentExpressionList ArgumentExpressionList_364_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_363_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_364_Var
		);
		final EList<? extends EObject> Expr_364_list = ArgumentExpressionList_364_Var
		.getExpr();
		Assert.assertNotNull(Expr_364_list);
		Assert.assertEquals(2, Expr_364_list.size());
		//364
		final AssignmentExpression AssignmentExpression_365_Var
		 = (AssignmentExpression)Expr_364_list.get(0);
		Assert.assertNotNull(AssignmentExpression_365_Var
		);
		//365
		final ConditionalExpression ConditionalExpression_366_Var
		 = (ConditionalExpression)AssignmentExpression_365_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_366_Var
		);
		//366
		final LogicalOrExpression LogicalOrExpression_367_Var
		 = (LogicalOrExpression)ConditionalExpression_366_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_367_Var
		);
		final EList<? extends EObject> Expr_367_list = LogicalOrExpression_367_Var
		.getExpr();
		Assert.assertNotNull(Expr_367_list);
		Assert.assertEquals(1, Expr_367_list.size());
		//367
		final LogicalAndExpression LogicalAndExpression_368_Var
		 = (LogicalAndExpression)Expr_367_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_368_Var
		);
		final EList<? extends EObject> Expr_368_list = LogicalAndExpression_368_Var
		.getExpr();
		Assert.assertNotNull(Expr_368_list);
		Assert.assertEquals(1, Expr_368_list.size());
		//368
		final InclusiveOrExpression InclusiveOrExpression_369_Var
		 = (InclusiveOrExpression)Expr_368_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_369_Var
		);
		final EList<? extends EObject> Expr_369_list = InclusiveOrExpression_369_Var
		.getExpr();
		Assert.assertNotNull(Expr_369_list);
		Assert.assertEquals(1, Expr_369_list.size());
		//369
		final ExclusiveOrExpression ExclusiveOrExpression_370_Var
		 = (ExclusiveOrExpression)Expr_369_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_370_Var
		);
		final EList<? extends EObject> Expr_370_list = ExclusiveOrExpression_370_Var
		.getExpr();
		Assert.assertNotNull(Expr_370_list);
		Assert.assertEquals(1, Expr_370_list.size());
		//370
		final AndExpression AndExpression_371_Var
		 = (AndExpression)Expr_370_list.get(0);
		Assert.assertNotNull(AndExpression_371_Var
		);
		final EList<? extends EObject> Expr_371_list = AndExpression_371_Var
		.getExpr();
		Assert.assertNotNull(Expr_371_list);
		Assert.assertEquals(1, Expr_371_list.size());
		//371
		final EqualityExpression EqualityExpression_372_Var
		 = (EqualityExpression)Expr_371_list.get(0);
		Assert.assertNotNull(EqualityExpression_372_Var
		);
		final EList<? extends EObject> Expr_372_list = EqualityExpression_372_Var
		.getExpr();
		Assert.assertNotNull(Expr_372_list);
		Assert.assertEquals(1, Expr_372_list.size());
		//372
		final RelationalExpression RelationalExpression_373_Var
		 = (RelationalExpression)Expr_372_list.get(0);
		Assert.assertNotNull(RelationalExpression_373_Var
		);
		final EList<? extends EObject> Expr_373_list = RelationalExpression_373_Var
		.getExpr();
		Assert.assertNotNull(Expr_373_list);
		Assert.assertEquals(1, Expr_373_list.size());
		//373
		final ShiftExpression ShiftExpression_374_Var
		 = (ShiftExpression)Expr_373_list.get(0);
		Assert.assertNotNull(ShiftExpression_374_Var
		);
		final EList<? extends EObject> Expr_374_list = ShiftExpression_374_Var
		.getExpr();
		Assert.assertNotNull(Expr_374_list);
		Assert.assertEquals(1, Expr_374_list.size());
		//374
		final AdditiveExpression AdditiveExpression_375_Var
		 = (AdditiveExpression)Expr_374_list.get(0);
		Assert.assertNotNull(AdditiveExpression_375_Var
		);
		final EList<? extends EObject> Expr_375_list = AdditiveExpression_375_Var
		.getExpr();
		Assert.assertNotNull(Expr_375_list);
		Assert.assertEquals(1, Expr_375_list.size());
		//375
		final MultiplicativeExpression MultiplicativeExpression_376_Var
		 = (MultiplicativeExpression)Expr_375_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_376_Var
		);
		final EList<? extends EObject> Expr_376_list = MultiplicativeExpression_376_Var
		.getExpr();
		Assert.assertNotNull(Expr_376_list);
		Assert.assertEquals(1, Expr_376_list.size());
		//376
		final CastExpression CastExpression_377_Var
		 = (CastExpression)Expr_376_list.get(0);
		Assert.assertNotNull(CastExpression_377_Var
		);
		//377
		final UnaryExpression UnaryExpression_378_Var
		 = (UnaryExpression)CastExpression_377_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_378_Var
		);
		//378
		final PostfixExpression PostfixExpression_379_Var
		 = (PostfixExpression)UnaryExpression_378_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_379_Var
		);
		final EList<? extends EObject> Expr_379_list = PostfixExpression_379_Var
		.getExpr();
		Assert.assertNotNull(Expr_379_list);
		Assert.assertEquals(1, Expr_379_list.size());
		//379
		final PrimaryExpression PrimaryExpression_380_Var
		 = (PrimaryExpression)Expr_379_list.get(0);
		Assert.assertNotNull(PrimaryExpression_380_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_380_Var
		.getId());
		Assert.assertEquals("[.]", PostfixExpression_379_Var
		.getDot().toString());
		Assert.assertEquals("[name]", PostfixExpression_379_Var
		.getId().toString());
		//380
		final AssignmentExpression AssignmentExpression_381_Var
		 = (AssignmentExpression)Expr_364_list.get(1);
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
		//396
		final Constant Constant_397_Var
		 = (Constant)PrimaryExpression_396_Var
		.getConst();
		Assert.assertNotNull(Constant_397_Var
		);
		Assert.assertEquals("\"Phil Morrison\"", Constant_397_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_346_Var
		.getSemi());
		//397
		final Statement Statement_398_Var
		 = (Statement)Statement_106_list.get(5);
		Assert.assertNotNull(Statement_398_Var
		);
		//398
		final ExpressionStatement ExpressionStatement_399_Var
		 = (ExpressionStatement)Statement_398_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_399_Var
		);
		//399
		final Expression Expression_400_Var
		 = (Expression)ExpressionStatement_399_Var
		.getExpression();
		Assert.assertNotNull(Expression_400_Var
		);
		final EList<? extends EObject> ExprExpr_400_list = Expression_400_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_400_list);
		Assert.assertEquals(1, ExprExpr_400_list.size());
		//400
		final AssignmentExpression AssignmentExpression_401_Var
		 = (AssignmentExpression)ExprExpr_400_list.get(0);
		Assert.assertNotNull(AssignmentExpression_401_Var
		);
		//401
		final ConditionalExpression ConditionalExpression_402_Var
		 = (ConditionalExpression)AssignmentExpression_401_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_402_Var
		);
		//402
		final LogicalOrExpression LogicalOrExpression_403_Var
		 = (LogicalOrExpression)ConditionalExpression_402_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_403_Var
		);
		final EList<? extends EObject> Expr_403_list = LogicalOrExpression_403_Var
		.getExpr();
		Assert.assertNotNull(Expr_403_list);
		Assert.assertEquals(1, Expr_403_list.size());
		//403
		final LogicalAndExpression LogicalAndExpression_404_Var
		 = (LogicalAndExpression)Expr_403_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_404_Var
		);
		final EList<? extends EObject> Expr_404_list = LogicalAndExpression_404_Var
		.getExpr();
		Assert.assertNotNull(Expr_404_list);
		Assert.assertEquals(1, Expr_404_list.size());
		//404
		final InclusiveOrExpression InclusiveOrExpression_405_Var
		 = (InclusiveOrExpression)Expr_404_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_405_Var
		);
		final EList<? extends EObject> Expr_405_list = InclusiveOrExpression_405_Var
		.getExpr();
		Assert.assertNotNull(Expr_405_list);
		Assert.assertEquals(1, Expr_405_list.size());
		//405
		final ExclusiveOrExpression ExclusiveOrExpression_406_Var
		 = (ExclusiveOrExpression)Expr_405_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_406_Var
		);
		final EList<? extends EObject> Expr_406_list = ExclusiveOrExpression_406_Var
		.getExpr();
		Assert.assertNotNull(Expr_406_list);
		Assert.assertEquals(1, Expr_406_list.size());
		//406
		final AndExpression AndExpression_407_Var
		 = (AndExpression)Expr_406_list.get(0);
		Assert.assertNotNull(AndExpression_407_Var
		);
		final EList<? extends EObject> Expr_407_list = AndExpression_407_Var
		.getExpr();
		Assert.assertNotNull(Expr_407_list);
		Assert.assertEquals(1, Expr_407_list.size());
		//407
		final EqualityExpression EqualityExpression_408_Var
		 = (EqualityExpression)Expr_407_list.get(0);
		Assert.assertNotNull(EqualityExpression_408_Var
		);
		final EList<? extends EObject> Expr_408_list = EqualityExpression_408_Var
		.getExpr();
		Assert.assertNotNull(Expr_408_list);
		Assert.assertEquals(1, Expr_408_list.size());
		//408
		final RelationalExpression RelationalExpression_409_Var
		 = (RelationalExpression)Expr_408_list.get(0);
		Assert.assertNotNull(RelationalExpression_409_Var
		);
		final EList<? extends EObject> Expr_409_list = RelationalExpression_409_Var
		.getExpr();
		Assert.assertNotNull(Expr_409_list);
		Assert.assertEquals(1, Expr_409_list.size());
		//409
		final ShiftExpression ShiftExpression_410_Var
		 = (ShiftExpression)Expr_409_list.get(0);
		Assert.assertNotNull(ShiftExpression_410_Var
		);
		final EList<? extends EObject> Expr_410_list = ShiftExpression_410_Var
		.getExpr();
		Assert.assertNotNull(Expr_410_list);
		Assert.assertEquals(1, Expr_410_list.size());
		//410
		final AdditiveExpression AdditiveExpression_411_Var
		 = (AdditiveExpression)Expr_410_list.get(0);
		Assert.assertNotNull(AdditiveExpression_411_Var
		);
		final EList<? extends EObject> Expr_411_list = AdditiveExpression_411_Var
		.getExpr();
		Assert.assertNotNull(Expr_411_list);
		Assert.assertEquals(1, Expr_411_list.size());
		//411
		final MultiplicativeExpression MultiplicativeExpression_412_Var
		 = (MultiplicativeExpression)Expr_411_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_412_Var
		);
		final EList<? extends EObject> Expr_412_list = MultiplicativeExpression_412_Var
		.getExpr();
		Assert.assertNotNull(Expr_412_list);
		Assert.assertEquals(1, Expr_412_list.size());
		//412
		final CastExpression CastExpression_413_Var
		 = (CastExpression)Expr_412_list.get(0);
		Assert.assertNotNull(CastExpression_413_Var
		);
		//413
		final UnaryExpression UnaryExpression_414_Var
		 = (UnaryExpression)CastExpression_413_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_414_Var
		);
		//414
		final PostfixExpression PostfixExpression_415_Var
		 = (PostfixExpression)UnaryExpression_414_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_415_Var
		);
		final EList<? extends EObject> Expr_415_list = PostfixExpression_415_Var
		.getExpr();
		Assert.assertNotNull(Expr_415_list);
		Assert.assertEquals(1, Expr_415_list.size());
		//415
		final PrimaryExpression PrimaryExpression_416_Var
		 = (PrimaryExpression)Expr_415_list.get(0);
		Assert.assertNotNull(PrimaryExpression_416_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_416_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_416_list = PostfixExpression_415_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_416_list);
		Assert.assertEquals(1, ArgumentExpressionList_416_list.size());
		//416
		final ArgumentExpressionList ArgumentExpressionList_417_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_416_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_417_Var
		);
		final EList<? extends EObject> Expr_417_list = ArgumentExpressionList_417_Var
		.getExpr();
		Assert.assertNotNull(Expr_417_list);
		Assert.assertEquals(2, Expr_417_list.size());
		//417
		final AssignmentExpression AssignmentExpression_418_Var
		 = (AssignmentExpression)Expr_417_list.get(0);
		Assert.assertNotNull(AssignmentExpression_418_Var
		);
		//418
		final ConditionalExpression ConditionalExpression_419_Var
		 = (ConditionalExpression)AssignmentExpression_418_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_419_Var
		);
		//419
		final LogicalOrExpression LogicalOrExpression_420_Var
		 = (LogicalOrExpression)ConditionalExpression_419_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_420_Var
		);
		final EList<? extends EObject> Expr_420_list = LogicalOrExpression_420_Var
		.getExpr();
		Assert.assertNotNull(Expr_420_list);
		Assert.assertEquals(1, Expr_420_list.size());
		//420
		final LogicalAndExpression LogicalAndExpression_421_Var
		 = (LogicalAndExpression)Expr_420_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_421_Var
		);
		final EList<? extends EObject> Expr_421_list = LogicalAndExpression_421_Var
		.getExpr();
		Assert.assertNotNull(Expr_421_list);
		Assert.assertEquals(1, Expr_421_list.size());
		//421
		final InclusiveOrExpression InclusiveOrExpression_422_Var
		 = (InclusiveOrExpression)Expr_421_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_422_Var
		);
		final EList<? extends EObject> Expr_422_list = InclusiveOrExpression_422_Var
		.getExpr();
		Assert.assertNotNull(Expr_422_list);
		Assert.assertEquals(1, Expr_422_list.size());
		//422
		final ExclusiveOrExpression ExclusiveOrExpression_423_Var
		 = (ExclusiveOrExpression)Expr_422_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_423_Var
		);
		final EList<? extends EObject> Expr_423_list = ExclusiveOrExpression_423_Var
		.getExpr();
		Assert.assertNotNull(Expr_423_list);
		Assert.assertEquals(1, Expr_423_list.size());
		//423
		final AndExpression AndExpression_424_Var
		 = (AndExpression)Expr_423_list.get(0);
		Assert.assertNotNull(AndExpression_424_Var
		);
		final EList<? extends EObject> Expr_424_list = AndExpression_424_Var
		.getExpr();
		Assert.assertNotNull(Expr_424_list);
		Assert.assertEquals(1, Expr_424_list.size());
		//424
		final EqualityExpression EqualityExpression_425_Var
		 = (EqualityExpression)Expr_424_list.get(0);
		Assert.assertNotNull(EqualityExpression_425_Var
		);
		final EList<? extends EObject> Expr_425_list = EqualityExpression_425_Var
		.getExpr();
		Assert.assertNotNull(Expr_425_list);
		Assert.assertEquals(1, Expr_425_list.size());
		//425
		final RelationalExpression RelationalExpression_426_Var
		 = (RelationalExpression)Expr_425_list.get(0);
		Assert.assertNotNull(RelationalExpression_426_Var
		);
		final EList<? extends EObject> Expr_426_list = RelationalExpression_426_Var
		.getExpr();
		Assert.assertNotNull(Expr_426_list);
		Assert.assertEquals(1, Expr_426_list.size());
		//426
		final ShiftExpression ShiftExpression_427_Var
		 = (ShiftExpression)Expr_426_list.get(0);
		Assert.assertNotNull(ShiftExpression_427_Var
		);
		final EList<? extends EObject> Expr_427_list = ShiftExpression_427_Var
		.getExpr();
		Assert.assertNotNull(Expr_427_list);
		Assert.assertEquals(1, Expr_427_list.size());
		//427
		final AdditiveExpression AdditiveExpression_428_Var
		 = (AdditiveExpression)Expr_427_list.get(0);
		Assert.assertNotNull(AdditiveExpression_428_Var
		);
		final EList<? extends EObject> Expr_428_list = AdditiveExpression_428_Var
		.getExpr();
		Assert.assertNotNull(Expr_428_list);
		Assert.assertEquals(1, Expr_428_list.size());
		//428
		final MultiplicativeExpression MultiplicativeExpression_429_Var
		 = (MultiplicativeExpression)Expr_428_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_429_Var
		);
		final EList<? extends EObject> Expr_429_list = MultiplicativeExpression_429_Var
		.getExpr();
		Assert.assertNotNull(Expr_429_list);
		Assert.assertEquals(1, Expr_429_list.size());
		//429
		final CastExpression CastExpression_430_Var
		 = (CastExpression)Expr_429_list.get(0);
		Assert.assertNotNull(CastExpression_430_Var
		);
		//430
		final UnaryExpression UnaryExpression_431_Var
		 = (UnaryExpression)CastExpression_430_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_431_Var
		);
		//431
		final PostfixExpression PostfixExpression_432_Var
		 = (PostfixExpression)UnaryExpression_431_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_432_Var
		);
		final EList<? extends EObject> Expr_432_list = PostfixExpression_432_Var
		.getExpr();
		Assert.assertNotNull(Expr_432_list);
		Assert.assertEquals(1, Expr_432_list.size());
		//432
		final PrimaryExpression PrimaryExpression_433_Var
		 = (PrimaryExpression)Expr_432_list.get(0);
		Assert.assertNotNull(PrimaryExpression_433_Var
		);
		//433
		final Constant Constant_434_Var
		 = (Constant)PrimaryExpression_433_Var
		.getConst();
		Assert.assertNotNull(Constant_434_Var
		);
		Assert.assertEquals("\"joe.id=%d\\n\"", Constant_434_Var
		.getStr());
		//434
		final AssignmentExpression AssignmentExpression_435_Var
		 = (AssignmentExpression)Expr_417_list.get(1);
		Assert.assertNotNull(AssignmentExpression_435_Var
		);
		//435
		final ConditionalExpression ConditionalExpression_436_Var
		 = (ConditionalExpression)AssignmentExpression_435_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_436_Var
		);
		//436
		final LogicalOrExpression LogicalOrExpression_437_Var
		 = (LogicalOrExpression)ConditionalExpression_436_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_437_Var
		);
		final EList<? extends EObject> Expr_437_list = LogicalOrExpression_437_Var
		.getExpr();
		Assert.assertNotNull(Expr_437_list);
		Assert.assertEquals(1, Expr_437_list.size());
		//437
		final LogicalAndExpression LogicalAndExpression_438_Var
		 = (LogicalAndExpression)Expr_437_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_438_Var
		);
		final EList<? extends EObject> Expr_438_list = LogicalAndExpression_438_Var
		.getExpr();
		Assert.assertNotNull(Expr_438_list);
		Assert.assertEquals(1, Expr_438_list.size());
		//438
		final InclusiveOrExpression InclusiveOrExpression_439_Var
		 = (InclusiveOrExpression)Expr_438_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_439_Var
		);
		final EList<? extends EObject> Expr_439_list = InclusiveOrExpression_439_Var
		.getExpr();
		Assert.assertNotNull(Expr_439_list);
		Assert.assertEquals(1, Expr_439_list.size());
		//439
		final ExclusiveOrExpression ExclusiveOrExpression_440_Var
		 = (ExclusiveOrExpression)Expr_439_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_440_Var
		);
		final EList<? extends EObject> Expr_440_list = ExclusiveOrExpression_440_Var
		.getExpr();
		Assert.assertNotNull(Expr_440_list);
		Assert.assertEquals(1, Expr_440_list.size());
		//440
		final AndExpression AndExpression_441_Var
		 = (AndExpression)Expr_440_list.get(0);
		Assert.assertNotNull(AndExpression_441_Var
		);
		final EList<? extends EObject> Expr_441_list = AndExpression_441_Var
		.getExpr();
		Assert.assertNotNull(Expr_441_list);
		Assert.assertEquals(1, Expr_441_list.size());
		//441
		final EqualityExpression EqualityExpression_442_Var
		 = (EqualityExpression)Expr_441_list.get(0);
		Assert.assertNotNull(EqualityExpression_442_Var
		);
		final EList<? extends EObject> Expr_442_list = EqualityExpression_442_Var
		.getExpr();
		Assert.assertNotNull(Expr_442_list);
		Assert.assertEquals(1, Expr_442_list.size());
		//442
		final RelationalExpression RelationalExpression_443_Var
		 = (RelationalExpression)Expr_442_list.get(0);
		Assert.assertNotNull(RelationalExpression_443_Var
		);
		final EList<? extends EObject> Expr_443_list = RelationalExpression_443_Var
		.getExpr();
		Assert.assertNotNull(Expr_443_list);
		Assert.assertEquals(1, Expr_443_list.size());
		//443
		final ShiftExpression ShiftExpression_444_Var
		 = (ShiftExpression)Expr_443_list.get(0);
		Assert.assertNotNull(ShiftExpression_444_Var
		);
		final EList<? extends EObject> Expr_444_list = ShiftExpression_444_Var
		.getExpr();
		Assert.assertNotNull(Expr_444_list);
		Assert.assertEquals(1, Expr_444_list.size());
		//444
		final AdditiveExpression AdditiveExpression_445_Var
		 = (AdditiveExpression)Expr_444_list.get(0);
		Assert.assertNotNull(AdditiveExpression_445_Var
		);
		final EList<? extends EObject> Expr_445_list = AdditiveExpression_445_Var
		.getExpr();
		Assert.assertNotNull(Expr_445_list);
		Assert.assertEquals(1, Expr_445_list.size());
		//445
		final MultiplicativeExpression MultiplicativeExpression_446_Var
		 = (MultiplicativeExpression)Expr_445_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_446_Var
		);
		final EList<? extends EObject> Expr_446_list = MultiplicativeExpression_446_Var
		.getExpr();
		Assert.assertNotNull(Expr_446_list);
		Assert.assertEquals(1, Expr_446_list.size());
		//446
		final CastExpression CastExpression_447_Var
		 = (CastExpression)Expr_446_list.get(0);
		Assert.assertNotNull(CastExpression_447_Var
		);
		//447
		final UnaryExpression UnaryExpression_448_Var
		 = (UnaryExpression)CastExpression_447_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_448_Var
		);
		//448
		final PostfixExpression PostfixExpression_449_Var
		 = (PostfixExpression)UnaryExpression_448_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_449_Var
		);
		final EList<? extends EObject> Expr_449_list = PostfixExpression_449_Var
		.getExpr();
		Assert.assertNotNull(Expr_449_list);
		Assert.assertEquals(1, Expr_449_list.size());
		//449
		final PrimaryExpression PrimaryExpression_450_Var
		 = (PrimaryExpression)Expr_449_list.get(0);
		Assert.assertNotNull(PrimaryExpression_450_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_450_Var
		.getId());
		Assert.assertEquals("[.]", PostfixExpression_449_Var
		.getDot().toString());
		Assert.assertEquals("[id]", PostfixExpression_449_Var
		.getId().toString());
		Assert.assertEquals(";", ExpressionStatement_399_Var
		.getSemi());
		//450
		final Statement Statement_451_Var
		 = (Statement)Statement_106_list.get(6);
		Assert.assertNotNull(Statement_451_Var
		);
		//451
		final ExpressionStatement ExpressionStatement_452_Var
		 = (ExpressionStatement)Statement_451_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_452_Var
		);
		//452
		final Expression Expression_453_Var
		 = (Expression)ExpressionStatement_452_Var
		.getExpression();
		Assert.assertNotNull(Expression_453_Var
		);
		final EList<? extends EObject> ExprExpr_453_list = Expression_453_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_453_list);
		Assert.assertEquals(1, ExprExpr_453_list.size());
		//453
		final AssignmentExpression AssignmentExpression_454_Var
		 = (AssignmentExpression)ExprExpr_453_list.get(0);
		Assert.assertNotNull(AssignmentExpression_454_Var
		);
		//454
		final ConditionalExpression ConditionalExpression_455_Var
		 = (ConditionalExpression)AssignmentExpression_454_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_455_Var
		);
		//455
		final LogicalOrExpression LogicalOrExpression_456_Var
		 = (LogicalOrExpression)ConditionalExpression_455_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_456_Var
		);
		final EList<? extends EObject> Expr_456_list = LogicalOrExpression_456_Var
		.getExpr();
		Assert.assertNotNull(Expr_456_list);
		Assert.assertEquals(1, Expr_456_list.size());
		//456
		final LogicalAndExpression LogicalAndExpression_457_Var
		 = (LogicalAndExpression)Expr_456_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_457_Var
		);
		final EList<? extends EObject> Expr_457_list = LogicalAndExpression_457_Var
		.getExpr();
		Assert.assertNotNull(Expr_457_list);
		Assert.assertEquals(1, Expr_457_list.size());
		//457
		final InclusiveOrExpression InclusiveOrExpression_458_Var
		 = (InclusiveOrExpression)Expr_457_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_458_Var
		);
		final EList<? extends EObject> Expr_458_list = InclusiveOrExpression_458_Var
		.getExpr();
		Assert.assertNotNull(Expr_458_list);
		Assert.assertEquals(1, Expr_458_list.size());
		//458
		final ExclusiveOrExpression ExclusiveOrExpression_459_Var
		 = (ExclusiveOrExpression)Expr_458_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_459_Var
		);
		final EList<? extends EObject> Expr_459_list = ExclusiveOrExpression_459_Var
		.getExpr();
		Assert.assertNotNull(Expr_459_list);
		Assert.assertEquals(1, Expr_459_list.size());
		//459
		final AndExpression AndExpression_460_Var
		 = (AndExpression)Expr_459_list.get(0);
		Assert.assertNotNull(AndExpression_460_Var
		);
		final EList<? extends EObject> Expr_460_list = AndExpression_460_Var
		.getExpr();
		Assert.assertNotNull(Expr_460_list);
		Assert.assertEquals(1, Expr_460_list.size());
		//460
		final EqualityExpression EqualityExpression_461_Var
		 = (EqualityExpression)Expr_460_list.get(0);
		Assert.assertNotNull(EqualityExpression_461_Var
		);
		final EList<? extends EObject> Expr_461_list = EqualityExpression_461_Var
		.getExpr();
		Assert.assertNotNull(Expr_461_list);
		Assert.assertEquals(1, Expr_461_list.size());
		//461
		final RelationalExpression RelationalExpression_462_Var
		 = (RelationalExpression)Expr_461_list.get(0);
		Assert.assertNotNull(RelationalExpression_462_Var
		);
		final EList<? extends EObject> Expr_462_list = RelationalExpression_462_Var
		.getExpr();
		Assert.assertNotNull(Expr_462_list);
		Assert.assertEquals(1, Expr_462_list.size());
		//462
		final ShiftExpression ShiftExpression_463_Var
		 = (ShiftExpression)Expr_462_list.get(0);
		Assert.assertNotNull(ShiftExpression_463_Var
		);
		final EList<? extends EObject> Expr_463_list = ShiftExpression_463_Var
		.getExpr();
		Assert.assertNotNull(Expr_463_list);
		Assert.assertEquals(1, Expr_463_list.size());
		//463
		final AdditiveExpression AdditiveExpression_464_Var
		 = (AdditiveExpression)Expr_463_list.get(0);
		Assert.assertNotNull(AdditiveExpression_464_Var
		);
		final EList<? extends EObject> Expr_464_list = AdditiveExpression_464_Var
		.getExpr();
		Assert.assertNotNull(Expr_464_list);
		Assert.assertEquals(1, Expr_464_list.size());
		//464
		final MultiplicativeExpression MultiplicativeExpression_465_Var
		 = (MultiplicativeExpression)Expr_464_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_465_Var
		);
		final EList<? extends EObject> Expr_465_list = MultiplicativeExpression_465_Var
		.getExpr();
		Assert.assertNotNull(Expr_465_list);
		Assert.assertEquals(1, Expr_465_list.size());
		//465
		final CastExpression CastExpression_466_Var
		 = (CastExpression)Expr_465_list.get(0);
		Assert.assertNotNull(CastExpression_466_Var
		);
		//466
		final UnaryExpression UnaryExpression_467_Var
		 = (UnaryExpression)CastExpression_466_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_467_Var
		);
		//467
		final PostfixExpression PostfixExpression_468_Var
		 = (PostfixExpression)UnaryExpression_467_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_468_Var
		);
		final EList<? extends EObject> Expr_468_list = PostfixExpression_468_Var
		.getExpr();
		Assert.assertNotNull(Expr_468_list);
		Assert.assertEquals(1, Expr_468_list.size());
		//468
		final PrimaryExpression PrimaryExpression_469_Var
		 = (PrimaryExpression)Expr_468_list.get(0);
		Assert.assertNotNull(PrimaryExpression_469_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_469_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_469_list = PostfixExpression_468_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_469_list);
		Assert.assertEquals(1, ArgumentExpressionList_469_list.size());
		//469
		final ArgumentExpressionList ArgumentExpressionList_470_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_469_list.get(0);
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
		final Constant Constant_487_Var
		 = (Constant)PrimaryExpression_486_Var
		.getConst();
		Assert.assertNotNull(Constant_487_Var
		);
		Assert.assertEquals("\"joe.name=%s\\n\"", Constant_487_Var
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
		Assert.assertEquals("joe", PrimaryExpression_503_Var
		.getId());
		Assert.assertEquals("[.]", PostfixExpression_502_Var
		.getDot().toString());
		Assert.assertEquals("[name]", PostfixExpression_502_Var
		.getId().toString());
		Assert.assertEquals(";", ExpressionStatement_452_Var
		.getSemi());
		//503
		final Statement Statement_504_Var
		 = (Statement)Statement_106_list.get(7);
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
		final ConditionalExpression ConditionalExpression_508_Var
		 = (ConditionalExpression)AssignmentExpression_507_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_508_Var
		);
		//508
		final LogicalOrExpression LogicalOrExpression_509_Var
		 = (LogicalOrExpression)ConditionalExpression_508_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_509_Var
		);
		final EList<? extends EObject> Expr_509_list = LogicalOrExpression_509_Var
		.getExpr();
		Assert.assertNotNull(Expr_509_list);
		Assert.assertEquals(1, Expr_509_list.size());
		//509
		final LogicalAndExpression LogicalAndExpression_510_Var
		 = (LogicalAndExpression)Expr_509_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_510_Var
		);
		final EList<? extends EObject> Expr_510_list = LogicalAndExpression_510_Var
		.getExpr();
		Assert.assertNotNull(Expr_510_list);
		Assert.assertEquals(1, Expr_510_list.size());
		//510
		final InclusiveOrExpression InclusiveOrExpression_511_Var
		 = (InclusiveOrExpression)Expr_510_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_511_Var
		);
		final EList<? extends EObject> Expr_511_list = InclusiveOrExpression_511_Var
		.getExpr();
		Assert.assertNotNull(Expr_511_list);
		Assert.assertEquals(1, Expr_511_list.size());
		//511
		final ExclusiveOrExpression ExclusiveOrExpression_512_Var
		 = (ExclusiveOrExpression)Expr_511_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_512_Var
		);
		final EList<? extends EObject> Expr_512_list = ExclusiveOrExpression_512_Var
		.getExpr();
		Assert.assertNotNull(Expr_512_list);
		Assert.assertEquals(1, Expr_512_list.size());
		//512
		final AndExpression AndExpression_513_Var
		 = (AndExpression)Expr_512_list.get(0);
		Assert.assertNotNull(AndExpression_513_Var
		);
		final EList<? extends EObject> Expr_513_list = AndExpression_513_Var
		.getExpr();
		Assert.assertNotNull(Expr_513_list);
		Assert.assertEquals(1, Expr_513_list.size());
		//513
		final EqualityExpression EqualityExpression_514_Var
		 = (EqualityExpression)Expr_513_list.get(0);
		Assert.assertNotNull(EqualityExpression_514_Var
		);
		final EList<? extends EObject> Expr_514_list = EqualityExpression_514_Var
		.getExpr();
		Assert.assertNotNull(Expr_514_list);
		Assert.assertEquals(1, Expr_514_list.size());
		//514
		final RelationalExpression RelationalExpression_515_Var
		 = (RelationalExpression)Expr_514_list.get(0);
		Assert.assertNotNull(RelationalExpression_515_Var
		);
		final EList<? extends EObject> Expr_515_list = RelationalExpression_515_Var
		.getExpr();
		Assert.assertNotNull(Expr_515_list);
		Assert.assertEquals(1, Expr_515_list.size());
		//515
		final ShiftExpression ShiftExpression_516_Var
		 = (ShiftExpression)Expr_515_list.get(0);
		Assert.assertNotNull(ShiftExpression_516_Var
		);
		final EList<? extends EObject> Expr_516_list = ShiftExpression_516_Var
		.getExpr();
		Assert.assertNotNull(Expr_516_list);
		Assert.assertEquals(1, Expr_516_list.size());
		//516
		final AdditiveExpression AdditiveExpression_517_Var
		 = (AdditiveExpression)Expr_516_list.get(0);
		Assert.assertNotNull(AdditiveExpression_517_Var
		);
		final EList<? extends EObject> Expr_517_list = AdditiveExpression_517_Var
		.getExpr();
		Assert.assertNotNull(Expr_517_list);
		Assert.assertEquals(1, Expr_517_list.size());
		//517
		final MultiplicativeExpression MultiplicativeExpression_518_Var
		 = (MultiplicativeExpression)Expr_517_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_518_Var
		);
		final EList<? extends EObject> Expr_518_list = MultiplicativeExpression_518_Var
		.getExpr();
		Assert.assertNotNull(Expr_518_list);
		Assert.assertEquals(1, Expr_518_list.size());
		//518
		final CastExpression CastExpression_519_Var
		 = (CastExpression)Expr_518_list.get(0);
		Assert.assertNotNull(CastExpression_519_Var
		);
		//519
		final UnaryExpression UnaryExpression_520_Var
		 = (UnaryExpression)CastExpression_519_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_520_Var
		);
		//520
		final PostfixExpression PostfixExpression_521_Var
		 = (PostfixExpression)UnaryExpression_520_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_521_Var
		);
		final EList<? extends EObject> Expr_521_list = PostfixExpression_521_Var
		.getExpr();
		Assert.assertNotNull(Expr_521_list);
		Assert.assertEquals(1, Expr_521_list.size());
		//521
		final PrimaryExpression PrimaryExpression_522_Var
		 = (PrimaryExpression)Expr_521_list.get(0);
		Assert.assertNotNull(PrimaryExpression_522_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_522_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_522_list = PostfixExpression_521_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_522_list);
		Assert.assertEquals(1, ArgumentExpressionList_522_list.size());
		//522
		final ArgumentExpressionList ArgumentExpressionList_523_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_522_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_523_Var
		);
		final EList<? extends EObject> Expr_523_list = ArgumentExpressionList_523_Var
		.getExpr();
		Assert.assertNotNull(Expr_523_list);
		Assert.assertEquals(2, Expr_523_list.size());
		//523
		final AssignmentExpression AssignmentExpression_524_Var
		 = (AssignmentExpression)Expr_523_list.get(0);
		Assert.assertNotNull(AssignmentExpression_524_Var
		);
		//524
		final ConditionalExpression ConditionalExpression_525_Var
		 = (ConditionalExpression)AssignmentExpression_524_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_525_Var
		);
		//525
		final LogicalOrExpression LogicalOrExpression_526_Var
		 = (LogicalOrExpression)ConditionalExpression_525_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_526_Var
		);
		final EList<? extends EObject> Expr_526_list = LogicalOrExpression_526_Var
		.getExpr();
		Assert.assertNotNull(Expr_526_list);
		Assert.assertEquals(1, Expr_526_list.size());
		//526
		final LogicalAndExpression LogicalAndExpression_527_Var
		 = (LogicalAndExpression)Expr_526_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_527_Var
		);
		final EList<? extends EObject> Expr_527_list = LogicalAndExpression_527_Var
		.getExpr();
		Assert.assertNotNull(Expr_527_list);
		Assert.assertEquals(1, Expr_527_list.size());
		//527
		final InclusiveOrExpression InclusiveOrExpression_528_Var
		 = (InclusiveOrExpression)Expr_527_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_528_Var
		);
		final EList<? extends EObject> Expr_528_list = InclusiveOrExpression_528_Var
		.getExpr();
		Assert.assertNotNull(Expr_528_list);
		Assert.assertEquals(1, Expr_528_list.size());
		//528
		final ExclusiveOrExpression ExclusiveOrExpression_529_Var
		 = (ExclusiveOrExpression)Expr_528_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_529_Var
		);
		final EList<? extends EObject> Expr_529_list = ExclusiveOrExpression_529_Var
		.getExpr();
		Assert.assertNotNull(Expr_529_list);
		Assert.assertEquals(1, Expr_529_list.size());
		//529
		final AndExpression AndExpression_530_Var
		 = (AndExpression)Expr_529_list.get(0);
		Assert.assertNotNull(AndExpression_530_Var
		);
		final EList<? extends EObject> Expr_530_list = AndExpression_530_Var
		.getExpr();
		Assert.assertNotNull(Expr_530_list);
		Assert.assertEquals(1, Expr_530_list.size());
		//530
		final EqualityExpression EqualityExpression_531_Var
		 = (EqualityExpression)Expr_530_list.get(0);
		Assert.assertNotNull(EqualityExpression_531_Var
		);
		final EList<? extends EObject> Expr_531_list = EqualityExpression_531_Var
		.getExpr();
		Assert.assertNotNull(Expr_531_list);
		Assert.assertEquals(1, Expr_531_list.size());
		//531
		final RelationalExpression RelationalExpression_532_Var
		 = (RelationalExpression)Expr_531_list.get(0);
		Assert.assertNotNull(RelationalExpression_532_Var
		);
		final EList<? extends EObject> Expr_532_list = RelationalExpression_532_Var
		.getExpr();
		Assert.assertNotNull(Expr_532_list);
		Assert.assertEquals(1, Expr_532_list.size());
		//532
		final ShiftExpression ShiftExpression_533_Var
		 = (ShiftExpression)Expr_532_list.get(0);
		Assert.assertNotNull(ShiftExpression_533_Var
		);
		final EList<? extends EObject> Expr_533_list = ShiftExpression_533_Var
		.getExpr();
		Assert.assertNotNull(Expr_533_list);
		Assert.assertEquals(1, Expr_533_list.size());
		//533
		final AdditiveExpression AdditiveExpression_534_Var
		 = (AdditiveExpression)Expr_533_list.get(0);
		Assert.assertNotNull(AdditiveExpression_534_Var
		);
		final EList<? extends EObject> Expr_534_list = AdditiveExpression_534_Var
		.getExpr();
		Assert.assertNotNull(Expr_534_list);
		Assert.assertEquals(1, Expr_534_list.size());
		//534
		final MultiplicativeExpression MultiplicativeExpression_535_Var
		 = (MultiplicativeExpression)Expr_534_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_535_Var
		);
		final EList<? extends EObject> Expr_535_list = MultiplicativeExpression_535_Var
		.getExpr();
		Assert.assertNotNull(Expr_535_list);
		Assert.assertEquals(1, Expr_535_list.size());
		//535
		final CastExpression CastExpression_536_Var
		 = (CastExpression)Expr_535_list.get(0);
		Assert.assertNotNull(CastExpression_536_Var
		);
		//536
		final UnaryExpression UnaryExpression_537_Var
		 = (UnaryExpression)CastExpression_536_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_537_Var
		);
		//537
		final PostfixExpression PostfixExpression_538_Var
		 = (PostfixExpression)UnaryExpression_537_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_538_Var
		);
		final EList<? extends EObject> Expr_538_list = PostfixExpression_538_Var
		.getExpr();
		Assert.assertNotNull(Expr_538_list);
		Assert.assertEquals(1, Expr_538_list.size());
		//538
		final PrimaryExpression PrimaryExpression_539_Var
		 = (PrimaryExpression)Expr_538_list.get(0);
		Assert.assertNotNull(PrimaryExpression_539_Var
		);
		//539
		final Constant Constant_540_Var
		 = (Constant)PrimaryExpression_539_Var
		.getConst();
		Assert.assertNotNull(Constant_540_Var
		);
		Assert.assertEquals("\"phil.id=%d\\n\"", Constant_540_Var
		.getStr());
		//540
		final AssignmentExpression AssignmentExpression_541_Var
		 = (AssignmentExpression)Expr_523_list.get(1);
		Assert.assertNotNull(AssignmentExpression_541_Var
		);
		//541
		final ConditionalExpression ConditionalExpression_542_Var
		 = (ConditionalExpression)AssignmentExpression_541_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_542_Var
		);
		//542
		final LogicalOrExpression LogicalOrExpression_543_Var
		 = (LogicalOrExpression)ConditionalExpression_542_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_543_Var
		);
		final EList<? extends EObject> Expr_543_list = LogicalOrExpression_543_Var
		.getExpr();
		Assert.assertNotNull(Expr_543_list);
		Assert.assertEquals(1, Expr_543_list.size());
		//543
		final LogicalAndExpression LogicalAndExpression_544_Var
		 = (LogicalAndExpression)Expr_543_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_544_Var
		);
		final EList<? extends EObject> Expr_544_list = LogicalAndExpression_544_Var
		.getExpr();
		Assert.assertNotNull(Expr_544_list);
		Assert.assertEquals(1, Expr_544_list.size());
		//544
		final InclusiveOrExpression InclusiveOrExpression_545_Var
		 = (InclusiveOrExpression)Expr_544_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_545_Var
		);
		final EList<? extends EObject> Expr_545_list = InclusiveOrExpression_545_Var
		.getExpr();
		Assert.assertNotNull(Expr_545_list);
		Assert.assertEquals(1, Expr_545_list.size());
		//545
		final ExclusiveOrExpression ExclusiveOrExpression_546_Var
		 = (ExclusiveOrExpression)Expr_545_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_546_Var
		);
		final EList<? extends EObject> Expr_546_list = ExclusiveOrExpression_546_Var
		.getExpr();
		Assert.assertNotNull(Expr_546_list);
		Assert.assertEquals(1, Expr_546_list.size());
		//546
		final AndExpression AndExpression_547_Var
		 = (AndExpression)Expr_546_list.get(0);
		Assert.assertNotNull(AndExpression_547_Var
		);
		final EList<? extends EObject> Expr_547_list = AndExpression_547_Var
		.getExpr();
		Assert.assertNotNull(Expr_547_list);
		Assert.assertEquals(1, Expr_547_list.size());
		//547
		final EqualityExpression EqualityExpression_548_Var
		 = (EqualityExpression)Expr_547_list.get(0);
		Assert.assertNotNull(EqualityExpression_548_Var
		);
		final EList<? extends EObject> Expr_548_list = EqualityExpression_548_Var
		.getExpr();
		Assert.assertNotNull(Expr_548_list);
		Assert.assertEquals(1, Expr_548_list.size());
		//548
		final RelationalExpression RelationalExpression_549_Var
		 = (RelationalExpression)Expr_548_list.get(0);
		Assert.assertNotNull(RelationalExpression_549_Var
		);
		final EList<? extends EObject> Expr_549_list = RelationalExpression_549_Var
		.getExpr();
		Assert.assertNotNull(Expr_549_list);
		Assert.assertEquals(1, Expr_549_list.size());
		//549
		final ShiftExpression ShiftExpression_550_Var
		 = (ShiftExpression)Expr_549_list.get(0);
		Assert.assertNotNull(ShiftExpression_550_Var
		);
		final EList<? extends EObject> Expr_550_list = ShiftExpression_550_Var
		.getExpr();
		Assert.assertNotNull(Expr_550_list);
		Assert.assertEquals(1, Expr_550_list.size());
		//550
		final AdditiveExpression AdditiveExpression_551_Var
		 = (AdditiveExpression)Expr_550_list.get(0);
		Assert.assertNotNull(AdditiveExpression_551_Var
		);
		final EList<? extends EObject> Expr_551_list = AdditiveExpression_551_Var
		.getExpr();
		Assert.assertNotNull(Expr_551_list);
		Assert.assertEquals(1, Expr_551_list.size());
		//551
		final MultiplicativeExpression MultiplicativeExpression_552_Var
		 = (MultiplicativeExpression)Expr_551_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_552_Var
		);
		final EList<? extends EObject> Expr_552_list = MultiplicativeExpression_552_Var
		.getExpr();
		Assert.assertNotNull(Expr_552_list);
		Assert.assertEquals(1, Expr_552_list.size());
		//552
		final CastExpression CastExpression_553_Var
		 = (CastExpression)Expr_552_list.get(0);
		Assert.assertNotNull(CastExpression_553_Var
		);
		//553
		final UnaryExpression UnaryExpression_554_Var
		 = (UnaryExpression)CastExpression_553_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_554_Var
		);
		//554
		final PostfixExpression PostfixExpression_555_Var
		 = (PostfixExpression)UnaryExpression_554_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_555_Var
		);
		final EList<? extends EObject> Expr_555_list = PostfixExpression_555_Var
		.getExpr();
		Assert.assertNotNull(Expr_555_list);
		Assert.assertEquals(1, Expr_555_list.size());
		//555
		final PrimaryExpression PrimaryExpression_556_Var
		 = (PrimaryExpression)Expr_555_list.get(0);
		Assert.assertNotNull(PrimaryExpression_556_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_556_Var
		.getId());
		Assert.assertEquals("[.]", PostfixExpression_555_Var
		.getDot().toString());
		Assert.assertEquals("[id]", PostfixExpression_555_Var
		.getId().toString());
		Assert.assertEquals(";", ExpressionStatement_505_Var
		.getSemi());
		//556
		final Statement Statement_557_Var
		 = (Statement)Statement_106_list.get(8);
		Assert.assertNotNull(Statement_557_Var
		);
		//557
		final ExpressionStatement ExpressionStatement_558_Var
		 = (ExpressionStatement)Statement_557_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_558_Var
		);
		//558
		final Expression Expression_559_Var
		 = (Expression)ExpressionStatement_558_Var
		.getExpression();
		Assert.assertNotNull(Expression_559_Var
		);
		final EList<? extends EObject> ExprExpr_559_list = Expression_559_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_559_list);
		Assert.assertEquals(1, ExprExpr_559_list.size());
		//559
		final AssignmentExpression AssignmentExpression_560_Var
		 = (AssignmentExpression)ExprExpr_559_list.get(0);
		Assert.assertNotNull(AssignmentExpression_560_Var
		);
		//560
		final ConditionalExpression ConditionalExpression_561_Var
		 = (ConditionalExpression)AssignmentExpression_560_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_561_Var
		);
		//561
		final LogicalOrExpression LogicalOrExpression_562_Var
		 = (LogicalOrExpression)ConditionalExpression_561_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_562_Var
		);
		final EList<? extends EObject> Expr_562_list = LogicalOrExpression_562_Var
		.getExpr();
		Assert.assertNotNull(Expr_562_list);
		Assert.assertEquals(1, Expr_562_list.size());
		//562
		final LogicalAndExpression LogicalAndExpression_563_Var
		 = (LogicalAndExpression)Expr_562_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_563_Var
		);
		final EList<? extends EObject> Expr_563_list = LogicalAndExpression_563_Var
		.getExpr();
		Assert.assertNotNull(Expr_563_list);
		Assert.assertEquals(1, Expr_563_list.size());
		//563
		final InclusiveOrExpression InclusiveOrExpression_564_Var
		 = (InclusiveOrExpression)Expr_563_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_564_Var
		);
		final EList<? extends EObject> Expr_564_list = InclusiveOrExpression_564_Var
		.getExpr();
		Assert.assertNotNull(Expr_564_list);
		Assert.assertEquals(1, Expr_564_list.size());
		//564
		final ExclusiveOrExpression ExclusiveOrExpression_565_Var
		 = (ExclusiveOrExpression)Expr_564_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_565_Var
		);
		final EList<? extends EObject> Expr_565_list = ExclusiveOrExpression_565_Var
		.getExpr();
		Assert.assertNotNull(Expr_565_list);
		Assert.assertEquals(1, Expr_565_list.size());
		//565
		final AndExpression AndExpression_566_Var
		 = (AndExpression)Expr_565_list.get(0);
		Assert.assertNotNull(AndExpression_566_Var
		);
		final EList<? extends EObject> Expr_566_list = AndExpression_566_Var
		.getExpr();
		Assert.assertNotNull(Expr_566_list);
		Assert.assertEquals(1, Expr_566_list.size());
		//566
		final EqualityExpression EqualityExpression_567_Var
		 = (EqualityExpression)Expr_566_list.get(0);
		Assert.assertNotNull(EqualityExpression_567_Var
		);
		final EList<? extends EObject> Expr_567_list = EqualityExpression_567_Var
		.getExpr();
		Assert.assertNotNull(Expr_567_list);
		Assert.assertEquals(1, Expr_567_list.size());
		//567
		final RelationalExpression RelationalExpression_568_Var
		 = (RelationalExpression)Expr_567_list.get(0);
		Assert.assertNotNull(RelationalExpression_568_Var
		);
		final EList<? extends EObject> Expr_568_list = RelationalExpression_568_Var
		.getExpr();
		Assert.assertNotNull(Expr_568_list);
		Assert.assertEquals(1, Expr_568_list.size());
		//568
		final ShiftExpression ShiftExpression_569_Var
		 = (ShiftExpression)Expr_568_list.get(0);
		Assert.assertNotNull(ShiftExpression_569_Var
		);
		final EList<? extends EObject> Expr_569_list = ShiftExpression_569_Var
		.getExpr();
		Assert.assertNotNull(Expr_569_list);
		Assert.assertEquals(1, Expr_569_list.size());
		//569
		final AdditiveExpression AdditiveExpression_570_Var
		 = (AdditiveExpression)Expr_569_list.get(0);
		Assert.assertNotNull(AdditiveExpression_570_Var
		);
		final EList<? extends EObject> Expr_570_list = AdditiveExpression_570_Var
		.getExpr();
		Assert.assertNotNull(Expr_570_list);
		Assert.assertEquals(1, Expr_570_list.size());
		//570
		final MultiplicativeExpression MultiplicativeExpression_571_Var
		 = (MultiplicativeExpression)Expr_570_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_571_Var
		);
		final EList<? extends EObject> Expr_571_list = MultiplicativeExpression_571_Var
		.getExpr();
		Assert.assertNotNull(Expr_571_list);
		Assert.assertEquals(1, Expr_571_list.size());
		//571
		final CastExpression CastExpression_572_Var
		 = (CastExpression)Expr_571_list.get(0);
		Assert.assertNotNull(CastExpression_572_Var
		);
		//572
		final UnaryExpression UnaryExpression_573_Var
		 = (UnaryExpression)CastExpression_572_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_573_Var
		);
		//573
		final PostfixExpression PostfixExpression_574_Var
		 = (PostfixExpression)UnaryExpression_573_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_574_Var
		);
		final EList<? extends EObject> Expr_574_list = PostfixExpression_574_Var
		.getExpr();
		Assert.assertNotNull(Expr_574_list);
		Assert.assertEquals(1, Expr_574_list.size());
		//574
		final PrimaryExpression PrimaryExpression_575_Var
		 = (PrimaryExpression)Expr_574_list.get(0);
		Assert.assertNotNull(PrimaryExpression_575_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_575_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_575_list = PostfixExpression_574_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_575_list);
		Assert.assertEquals(1, ArgumentExpressionList_575_list.size());
		//575
		final ArgumentExpressionList ArgumentExpressionList_576_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_575_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_576_Var
		);
		final EList<? extends EObject> Expr_576_list = ArgumentExpressionList_576_Var
		.getExpr();
		Assert.assertNotNull(Expr_576_list);
		Assert.assertEquals(2, Expr_576_list.size());
		//576
		final AssignmentExpression AssignmentExpression_577_Var
		 = (AssignmentExpression)Expr_576_list.get(0);
		Assert.assertNotNull(AssignmentExpression_577_Var
		);
		//577
		final ConditionalExpression ConditionalExpression_578_Var
		 = (ConditionalExpression)AssignmentExpression_577_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_578_Var
		);
		//578
		final LogicalOrExpression LogicalOrExpression_579_Var
		 = (LogicalOrExpression)ConditionalExpression_578_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_579_Var
		);
		final EList<? extends EObject> Expr_579_list = LogicalOrExpression_579_Var
		.getExpr();
		Assert.assertNotNull(Expr_579_list);
		Assert.assertEquals(1, Expr_579_list.size());
		//579
		final LogicalAndExpression LogicalAndExpression_580_Var
		 = (LogicalAndExpression)Expr_579_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_580_Var
		);
		final EList<? extends EObject> Expr_580_list = LogicalAndExpression_580_Var
		.getExpr();
		Assert.assertNotNull(Expr_580_list);
		Assert.assertEquals(1, Expr_580_list.size());
		//580
		final InclusiveOrExpression InclusiveOrExpression_581_Var
		 = (InclusiveOrExpression)Expr_580_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_581_Var
		);
		final EList<? extends EObject> Expr_581_list = InclusiveOrExpression_581_Var
		.getExpr();
		Assert.assertNotNull(Expr_581_list);
		Assert.assertEquals(1, Expr_581_list.size());
		//581
		final ExclusiveOrExpression ExclusiveOrExpression_582_Var
		 = (ExclusiveOrExpression)Expr_581_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_582_Var
		);
		final EList<? extends EObject> Expr_582_list = ExclusiveOrExpression_582_Var
		.getExpr();
		Assert.assertNotNull(Expr_582_list);
		Assert.assertEquals(1, Expr_582_list.size());
		//582
		final AndExpression AndExpression_583_Var
		 = (AndExpression)Expr_582_list.get(0);
		Assert.assertNotNull(AndExpression_583_Var
		);
		final EList<? extends EObject> Expr_583_list = AndExpression_583_Var
		.getExpr();
		Assert.assertNotNull(Expr_583_list);
		Assert.assertEquals(1, Expr_583_list.size());
		//583
		final EqualityExpression EqualityExpression_584_Var
		 = (EqualityExpression)Expr_583_list.get(0);
		Assert.assertNotNull(EqualityExpression_584_Var
		);
		final EList<? extends EObject> Expr_584_list = EqualityExpression_584_Var
		.getExpr();
		Assert.assertNotNull(Expr_584_list);
		Assert.assertEquals(1, Expr_584_list.size());
		//584
		final RelationalExpression RelationalExpression_585_Var
		 = (RelationalExpression)Expr_584_list.get(0);
		Assert.assertNotNull(RelationalExpression_585_Var
		);
		final EList<? extends EObject> Expr_585_list = RelationalExpression_585_Var
		.getExpr();
		Assert.assertNotNull(Expr_585_list);
		Assert.assertEquals(1, Expr_585_list.size());
		//585
		final ShiftExpression ShiftExpression_586_Var
		 = (ShiftExpression)Expr_585_list.get(0);
		Assert.assertNotNull(ShiftExpression_586_Var
		);
		final EList<? extends EObject> Expr_586_list = ShiftExpression_586_Var
		.getExpr();
		Assert.assertNotNull(Expr_586_list);
		Assert.assertEquals(1, Expr_586_list.size());
		//586
		final AdditiveExpression AdditiveExpression_587_Var
		 = (AdditiveExpression)Expr_586_list.get(0);
		Assert.assertNotNull(AdditiveExpression_587_Var
		);
		final EList<? extends EObject> Expr_587_list = AdditiveExpression_587_Var
		.getExpr();
		Assert.assertNotNull(Expr_587_list);
		Assert.assertEquals(1, Expr_587_list.size());
		//587
		final MultiplicativeExpression MultiplicativeExpression_588_Var
		 = (MultiplicativeExpression)Expr_587_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_588_Var
		);
		final EList<? extends EObject> Expr_588_list = MultiplicativeExpression_588_Var
		.getExpr();
		Assert.assertNotNull(Expr_588_list);
		Assert.assertEquals(1, Expr_588_list.size());
		//588
		final CastExpression CastExpression_589_Var
		 = (CastExpression)Expr_588_list.get(0);
		Assert.assertNotNull(CastExpression_589_Var
		);
		//589
		final UnaryExpression UnaryExpression_590_Var
		 = (UnaryExpression)CastExpression_589_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_590_Var
		);
		//590
		final PostfixExpression PostfixExpression_591_Var
		 = (PostfixExpression)UnaryExpression_590_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_591_Var
		);
		final EList<? extends EObject> Expr_591_list = PostfixExpression_591_Var
		.getExpr();
		Assert.assertNotNull(Expr_591_list);
		Assert.assertEquals(1, Expr_591_list.size());
		//591
		final PrimaryExpression PrimaryExpression_592_Var
		 = (PrimaryExpression)Expr_591_list.get(0);
		Assert.assertNotNull(PrimaryExpression_592_Var
		);
		//592
		final Constant Constant_593_Var
		 = (Constant)PrimaryExpression_592_Var
		.getConst();
		Assert.assertNotNull(Constant_593_Var
		);
		Assert.assertEquals("\"phil.name=%s\\n\"", Constant_593_Var
		.getStr());
		//593
		final AssignmentExpression AssignmentExpression_594_Var
		 = (AssignmentExpression)Expr_576_list.get(1);
		Assert.assertNotNull(AssignmentExpression_594_Var
		);
		//594
		final ConditionalExpression ConditionalExpression_595_Var
		 = (ConditionalExpression)AssignmentExpression_594_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_595_Var
		);
		//595
		final LogicalOrExpression LogicalOrExpression_596_Var
		 = (LogicalOrExpression)ConditionalExpression_595_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_596_Var
		);
		final EList<? extends EObject> Expr_596_list = LogicalOrExpression_596_Var
		.getExpr();
		Assert.assertNotNull(Expr_596_list);
		Assert.assertEquals(1, Expr_596_list.size());
		//596
		final LogicalAndExpression LogicalAndExpression_597_Var
		 = (LogicalAndExpression)Expr_596_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_597_Var
		);
		final EList<? extends EObject> Expr_597_list = LogicalAndExpression_597_Var
		.getExpr();
		Assert.assertNotNull(Expr_597_list);
		Assert.assertEquals(1, Expr_597_list.size());
		//597
		final InclusiveOrExpression InclusiveOrExpression_598_Var
		 = (InclusiveOrExpression)Expr_597_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_598_Var
		);
		final EList<? extends EObject> Expr_598_list = InclusiveOrExpression_598_Var
		.getExpr();
		Assert.assertNotNull(Expr_598_list);
		Assert.assertEquals(1, Expr_598_list.size());
		//598
		final ExclusiveOrExpression ExclusiveOrExpression_599_Var
		 = (ExclusiveOrExpression)Expr_598_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_599_Var
		);
		final EList<? extends EObject> Expr_599_list = ExclusiveOrExpression_599_Var
		.getExpr();
		Assert.assertNotNull(Expr_599_list);
		Assert.assertEquals(1, Expr_599_list.size());
		//599
		final AndExpression AndExpression_600_Var
		 = (AndExpression)Expr_599_list.get(0);
		Assert.assertNotNull(AndExpression_600_Var
		);
		final EList<? extends EObject> Expr_600_list = AndExpression_600_Var
		.getExpr();
		Assert.assertNotNull(Expr_600_list);
		Assert.assertEquals(1, Expr_600_list.size());
		//600
		final EqualityExpression EqualityExpression_601_Var
		 = (EqualityExpression)Expr_600_list.get(0);
		Assert.assertNotNull(EqualityExpression_601_Var
		);
		final EList<? extends EObject> Expr_601_list = EqualityExpression_601_Var
		.getExpr();
		Assert.assertNotNull(Expr_601_list);
		Assert.assertEquals(1, Expr_601_list.size());
		//601
		final RelationalExpression RelationalExpression_602_Var
		 = (RelationalExpression)Expr_601_list.get(0);
		Assert.assertNotNull(RelationalExpression_602_Var
		);
		final EList<? extends EObject> Expr_602_list = RelationalExpression_602_Var
		.getExpr();
		Assert.assertNotNull(Expr_602_list);
		Assert.assertEquals(1, Expr_602_list.size());
		//602
		final ShiftExpression ShiftExpression_603_Var
		 = (ShiftExpression)Expr_602_list.get(0);
		Assert.assertNotNull(ShiftExpression_603_Var
		);
		final EList<? extends EObject> Expr_603_list = ShiftExpression_603_Var
		.getExpr();
		Assert.assertNotNull(Expr_603_list);
		Assert.assertEquals(1, Expr_603_list.size());
		//603
		final AdditiveExpression AdditiveExpression_604_Var
		 = (AdditiveExpression)Expr_603_list.get(0);
		Assert.assertNotNull(AdditiveExpression_604_Var
		);
		final EList<? extends EObject> Expr_604_list = AdditiveExpression_604_Var
		.getExpr();
		Assert.assertNotNull(Expr_604_list);
		Assert.assertEquals(1, Expr_604_list.size());
		//604
		final MultiplicativeExpression MultiplicativeExpression_605_Var
		 = (MultiplicativeExpression)Expr_604_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_605_Var
		);
		final EList<? extends EObject> Expr_605_list = MultiplicativeExpression_605_Var
		.getExpr();
		Assert.assertNotNull(Expr_605_list);
		Assert.assertEquals(1, Expr_605_list.size());
		//605
		final CastExpression CastExpression_606_Var
		 = (CastExpression)Expr_605_list.get(0);
		Assert.assertNotNull(CastExpression_606_Var
		);
		//606
		final UnaryExpression UnaryExpression_607_Var
		 = (UnaryExpression)CastExpression_606_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_607_Var
		);
		//607
		final PostfixExpression PostfixExpression_608_Var
		 = (PostfixExpression)UnaryExpression_607_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_608_Var
		);
		final EList<? extends EObject> Expr_608_list = PostfixExpression_608_Var
		.getExpr();
		Assert.assertNotNull(Expr_608_list);
		Assert.assertEquals(1, Expr_608_list.size());
		//608
		final PrimaryExpression PrimaryExpression_609_Var
		 = (PrimaryExpression)Expr_608_list.get(0);
		Assert.assertNotNull(PrimaryExpression_609_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_609_Var
		.getId());
		Assert.assertEquals("[.]", PostfixExpression_608_Var
		.getDot().toString());
		Assert.assertEquals("[name]", PostfixExpression_608_Var
		.getId().toString());
		Assert.assertEquals(";", ExpressionStatement_558_Var
		.getSemi());
		//609
		final Statement Statement_610_Var
		 = (Statement)Statement_106_list.get(9);
		Assert.assertNotNull(Statement_610_Var
		);
		//610
		final JumpStatement JumpStatement_611_Var
		 = (JumpStatement)Statement_610_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_611_Var
		);
		//611
		final Expression Expression_612_Var
		 = (Expression)JumpStatement_611_Var
		.getExpr();
		Assert.assertNotNull(Expression_612_Var
		);
		final EList<? extends EObject> ExprExpr_612_list = Expression_612_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_612_list);
		Assert.assertEquals(1, ExprExpr_612_list.size());
		//612
		final AssignmentExpression AssignmentExpression_613_Var
		 = (AssignmentExpression)ExprExpr_612_list.get(0);
		Assert.assertNotNull(AssignmentExpression_613_Var
		);
		//613
		final ConditionalExpression ConditionalExpression_614_Var
		 = (ConditionalExpression)AssignmentExpression_613_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_614_Var
		);
		//614
		final LogicalOrExpression LogicalOrExpression_615_Var
		 = (LogicalOrExpression)ConditionalExpression_614_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_615_Var
		);
		final EList<? extends EObject> Expr_615_list = LogicalOrExpression_615_Var
		.getExpr();
		Assert.assertNotNull(Expr_615_list);
		Assert.assertEquals(1, Expr_615_list.size());
		//615
		final LogicalAndExpression LogicalAndExpression_616_Var
		 = (LogicalAndExpression)Expr_615_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_616_Var
		);
		final EList<? extends EObject> Expr_616_list = LogicalAndExpression_616_Var
		.getExpr();
		Assert.assertNotNull(Expr_616_list);
		Assert.assertEquals(1, Expr_616_list.size());
		//616
		final InclusiveOrExpression InclusiveOrExpression_617_Var
		 = (InclusiveOrExpression)Expr_616_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_617_Var
		);
		final EList<? extends EObject> Expr_617_list = InclusiveOrExpression_617_Var
		.getExpr();
		Assert.assertNotNull(Expr_617_list);
		Assert.assertEquals(1, Expr_617_list.size());
		//617
		final ExclusiveOrExpression ExclusiveOrExpression_618_Var
		 = (ExclusiveOrExpression)Expr_617_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_618_Var
		);
		final EList<? extends EObject> Expr_618_list = ExclusiveOrExpression_618_Var
		.getExpr();
		Assert.assertNotNull(Expr_618_list);
		Assert.assertEquals(1, Expr_618_list.size());
		//618
		final AndExpression AndExpression_619_Var
		 = (AndExpression)Expr_618_list.get(0);
		Assert.assertNotNull(AndExpression_619_Var
		);
		final EList<? extends EObject> Expr_619_list = AndExpression_619_Var
		.getExpr();
		Assert.assertNotNull(Expr_619_list);
		Assert.assertEquals(1, Expr_619_list.size());
		//619
		final EqualityExpression EqualityExpression_620_Var
		 = (EqualityExpression)Expr_619_list.get(0);
		Assert.assertNotNull(EqualityExpression_620_Var
		);
		final EList<? extends EObject> Expr_620_list = EqualityExpression_620_Var
		.getExpr();
		Assert.assertNotNull(Expr_620_list);
		Assert.assertEquals(1, Expr_620_list.size());
		//620
		final RelationalExpression RelationalExpression_621_Var
		 = (RelationalExpression)Expr_620_list.get(0);
		Assert.assertNotNull(RelationalExpression_621_Var
		);
		final EList<? extends EObject> Expr_621_list = RelationalExpression_621_Var
		.getExpr();
		Assert.assertNotNull(Expr_621_list);
		Assert.assertEquals(1, Expr_621_list.size());
		//621
		final ShiftExpression ShiftExpression_622_Var
		 = (ShiftExpression)Expr_621_list.get(0);
		Assert.assertNotNull(ShiftExpression_622_Var
		);
		final EList<? extends EObject> Expr_622_list = ShiftExpression_622_Var
		.getExpr();
		Assert.assertNotNull(Expr_622_list);
		Assert.assertEquals(1, Expr_622_list.size());
		//622
		final AdditiveExpression AdditiveExpression_623_Var
		 = (AdditiveExpression)Expr_622_list.get(0);
		Assert.assertNotNull(AdditiveExpression_623_Var
		);
		final EList<? extends EObject> Expr_623_list = AdditiveExpression_623_Var
		.getExpr();
		Assert.assertNotNull(Expr_623_list);
		Assert.assertEquals(1, Expr_623_list.size());
		//623
		final MultiplicativeExpression MultiplicativeExpression_624_Var
		 = (MultiplicativeExpression)Expr_623_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_624_Var
		);
		final EList<? extends EObject> Expr_624_list = MultiplicativeExpression_624_Var
		.getExpr();
		Assert.assertNotNull(Expr_624_list);
		Assert.assertEquals(1, Expr_624_list.size());
		//624
		final CastExpression CastExpression_625_Var
		 = (CastExpression)Expr_624_list.get(0);
		Assert.assertNotNull(CastExpression_625_Var
		);
		//625
		final UnaryExpression UnaryExpression_626_Var
		 = (UnaryExpression)CastExpression_625_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_626_Var
		);
		//626
		final PostfixExpression PostfixExpression_627_Var
		 = (PostfixExpression)UnaryExpression_626_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_627_Var
		);
		final EList<? extends EObject> Expr_627_list = PostfixExpression_627_Var
		.getExpr();
		Assert.assertNotNull(Expr_627_list);
		Assert.assertEquals(1, Expr_627_list.size());
		//627
		final PrimaryExpression PrimaryExpression_628_Var
		 = (PrimaryExpression)Expr_627_list.get(0);
		Assert.assertNotNull(PrimaryExpression_628_Var
		);
		//628
		final Constant Constant_629_Var
		 = (Constant)PrimaryExpression_628_Var
		.getConst();
		Assert.assertNotNull(Constant_629_Var
		);
		Assert.assertEquals("0", Constant_629_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_611_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_611_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0037_Struct.c");
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
				method.invoke(this.generator, "greetings.txt");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/greetings.txt");
		final String expected = this.getTextFromFile(
			"res/Test0037_Struct.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
		// System.out.println("Code generation finished.");
	}
	
}


