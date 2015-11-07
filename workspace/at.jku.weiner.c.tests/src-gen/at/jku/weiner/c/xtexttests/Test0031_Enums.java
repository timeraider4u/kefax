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
import at.jku.weiner.c.c.TypeQualifier;
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
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
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
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
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
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
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
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
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
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
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
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
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
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Constant;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.EnumSpecifier;
import at.jku.weiner.c.c.EnumeratorList;
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.ConstantExpression;
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
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.EnumSpecifier;
import at.jku.weiner.c.c.EnumeratorList;
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.ConstantExpression;
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
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.EnumSpecifier;
import at.jku.weiner.c.c.EnumeratorList;
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.ConstantExpression;
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
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.Enumerator;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.EnumSpecifier;
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
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
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
public class Test0031_Enums {
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
		final EList<? extends EObject> ArgumentExpressionList_305_list = PostfixExpression_304_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_305_list);
		Assert.assertEquals(1, ArgumentExpressionList_305_list.size());
		//305
		final ArgumentExpressionList ArgumentExpressionList_306_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_305_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_306_Var
		);
		final EList<? extends EObject> Expr_306_list = ArgumentExpressionList_306_Var
		.getExpr();
		Assert.assertNotNull(Expr_306_list);
		Assert.assertEquals(2, Expr_306_list.size());
		//306
		final AssignmentExpression AssignmentExpression_307_Var
		 = (AssignmentExpression)Expr_306_list.get(0);
		Assert.assertNotNull(AssignmentExpression_307_Var
		);
		//307
		final ConditionalExpression ConditionalExpression_308_Var
		 = (ConditionalExpression)AssignmentExpression_307_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_308_Var
		);
		//308
		final LogicalOrExpression LogicalOrExpression_309_Var
		 = (LogicalOrExpression)ConditionalExpression_308_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_309_Var
		);
		final EList<? extends EObject> Expr_309_list = LogicalOrExpression_309_Var
		.getExpr();
		Assert.assertNotNull(Expr_309_list);
		Assert.assertEquals(1, Expr_309_list.size());
		//309
		final LogicalAndExpression LogicalAndExpression_310_Var
		 = (LogicalAndExpression)Expr_309_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_310_Var
		);
		final EList<? extends EObject> Expr_310_list = LogicalAndExpression_310_Var
		.getExpr();
		Assert.assertNotNull(Expr_310_list);
		Assert.assertEquals(1, Expr_310_list.size());
		//310
		final InclusiveOrExpression InclusiveOrExpression_311_Var
		 = (InclusiveOrExpression)Expr_310_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_311_Var
		);
		final EList<? extends EObject> Expr_311_list = InclusiveOrExpression_311_Var
		.getExpr();
		Assert.assertNotNull(Expr_311_list);
		Assert.assertEquals(1, Expr_311_list.size());
		//311
		final ExclusiveOrExpression ExclusiveOrExpression_312_Var
		 = (ExclusiveOrExpression)Expr_311_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_312_Var
		);
		final EList<? extends EObject> Expr_312_list = ExclusiveOrExpression_312_Var
		.getExpr();
		Assert.assertNotNull(Expr_312_list);
		Assert.assertEquals(1, Expr_312_list.size());
		//312
		final AndExpression AndExpression_313_Var
		 = (AndExpression)Expr_312_list.get(0);
		Assert.assertNotNull(AndExpression_313_Var
		);
		final EList<? extends EObject> Expr_313_list = AndExpression_313_Var
		.getExpr();
		Assert.assertNotNull(Expr_313_list);
		Assert.assertEquals(1, Expr_313_list.size());
		//313
		final EqualityExpression EqualityExpression_314_Var
		 = (EqualityExpression)Expr_313_list.get(0);
		Assert.assertNotNull(EqualityExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = EqualityExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final RelationalExpression RelationalExpression_315_Var
		 = (RelationalExpression)Expr_314_list.get(0);
		Assert.assertNotNull(RelationalExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = RelationalExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final ShiftExpression ShiftExpression_316_Var
		 = (ShiftExpression)Expr_315_list.get(0);
		Assert.assertNotNull(ShiftExpression_316_Var
		);
		final EList<? extends EObject> Expr_316_list = ShiftExpression_316_Var
		.getExpr();
		Assert.assertNotNull(Expr_316_list);
		Assert.assertEquals(1, Expr_316_list.size());
		//316
		final AdditiveExpression AdditiveExpression_317_Var
		 = (AdditiveExpression)Expr_316_list.get(0);
		Assert.assertNotNull(AdditiveExpression_317_Var
		);
		final EList<? extends EObject> Expr_317_list = AdditiveExpression_317_Var
		.getExpr();
		Assert.assertNotNull(Expr_317_list);
		Assert.assertEquals(1, Expr_317_list.size());
		//317
		final MultiplicativeExpression MultiplicativeExpression_318_Var
		 = (MultiplicativeExpression)Expr_317_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_318_Var
		);
		final EList<? extends EObject> Expr_318_list = MultiplicativeExpression_318_Var
		.getExpr();
		Assert.assertNotNull(Expr_318_list);
		Assert.assertEquals(1, Expr_318_list.size());
		//318
		final CastExpression CastExpression_319_Var
		 = (CastExpression)Expr_318_list.get(0);
		Assert.assertNotNull(CastExpression_319_Var
		);
		//319
		final UnaryExpression UnaryExpression_320_Var
		 = (UnaryExpression)CastExpression_319_Var
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
		//322
		final Constant Constant_323_Var
		 = (Constant)PrimaryExpression_322_Var
		.getConst();
		Assert.assertNotNull(Constant_323_Var
		);
		Assert.assertEquals("\"Monday is %d. day of week\\n\"", Constant_323_Var
		.getStr());
		//323
		final AssignmentExpression AssignmentExpression_324_Var
		 = (AssignmentExpression)Expr_306_list.get(1);
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
		Assert.assertEquals("W_MONDAY", PrimaryExpression_339_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_288_Var
		.getSemi());
		//339
		final Statement Statement_340_Var
		 = (Statement)Statement_286_list.get(1);
		Assert.assertNotNull(Statement_340_Var
		);
		//340
		final ExpressionStatement ExpressionStatement_341_Var
		 = (ExpressionStatement)Statement_340_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_341_Var
		);
		//341
		final Expression Expression_342_Var
		 = (Expression)ExpressionStatement_341_Var
		.getExpression();
		Assert.assertNotNull(Expression_342_Var
		);
		final EList<? extends EObject> ExprExpr_342_list = Expression_342_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_342_list);
		Assert.assertEquals(1, ExprExpr_342_list.size());
		//342
		final AssignmentExpression AssignmentExpression_343_Var
		 = (AssignmentExpression)ExprExpr_342_list.get(0);
		Assert.assertNotNull(AssignmentExpression_343_Var
		);
		//343
		final ConditionalExpression ConditionalExpression_344_Var
		 = (ConditionalExpression)AssignmentExpression_343_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_344_Var
		);
		//344
		final LogicalOrExpression LogicalOrExpression_345_Var
		 = (LogicalOrExpression)ConditionalExpression_344_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_345_Var
		);
		final EList<? extends EObject> Expr_345_list = LogicalOrExpression_345_Var
		.getExpr();
		Assert.assertNotNull(Expr_345_list);
		Assert.assertEquals(1, Expr_345_list.size());
		//345
		final LogicalAndExpression LogicalAndExpression_346_Var
		 = (LogicalAndExpression)Expr_345_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_346_Var
		);
		final EList<? extends EObject> Expr_346_list = LogicalAndExpression_346_Var
		.getExpr();
		Assert.assertNotNull(Expr_346_list);
		Assert.assertEquals(1, Expr_346_list.size());
		//346
		final InclusiveOrExpression InclusiveOrExpression_347_Var
		 = (InclusiveOrExpression)Expr_346_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_347_Var
		);
		final EList<? extends EObject> Expr_347_list = InclusiveOrExpression_347_Var
		.getExpr();
		Assert.assertNotNull(Expr_347_list);
		Assert.assertEquals(1, Expr_347_list.size());
		//347
		final ExclusiveOrExpression ExclusiveOrExpression_348_Var
		 = (ExclusiveOrExpression)Expr_347_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_348_Var
		);
		final EList<? extends EObject> Expr_348_list = ExclusiveOrExpression_348_Var
		.getExpr();
		Assert.assertNotNull(Expr_348_list);
		Assert.assertEquals(1, Expr_348_list.size());
		//348
		final AndExpression AndExpression_349_Var
		 = (AndExpression)Expr_348_list.get(0);
		Assert.assertNotNull(AndExpression_349_Var
		);
		final EList<? extends EObject> Expr_349_list = AndExpression_349_Var
		.getExpr();
		Assert.assertNotNull(Expr_349_list);
		Assert.assertEquals(1, Expr_349_list.size());
		//349
		final EqualityExpression EqualityExpression_350_Var
		 = (EqualityExpression)Expr_349_list.get(0);
		Assert.assertNotNull(EqualityExpression_350_Var
		);
		final EList<? extends EObject> Expr_350_list = EqualityExpression_350_Var
		.getExpr();
		Assert.assertNotNull(Expr_350_list);
		Assert.assertEquals(1, Expr_350_list.size());
		//350
		final RelationalExpression RelationalExpression_351_Var
		 = (RelationalExpression)Expr_350_list.get(0);
		Assert.assertNotNull(RelationalExpression_351_Var
		);
		final EList<? extends EObject> Expr_351_list = RelationalExpression_351_Var
		.getExpr();
		Assert.assertNotNull(Expr_351_list);
		Assert.assertEquals(1, Expr_351_list.size());
		//351
		final ShiftExpression ShiftExpression_352_Var
		 = (ShiftExpression)Expr_351_list.get(0);
		Assert.assertNotNull(ShiftExpression_352_Var
		);
		final EList<? extends EObject> Expr_352_list = ShiftExpression_352_Var
		.getExpr();
		Assert.assertNotNull(Expr_352_list);
		Assert.assertEquals(1, Expr_352_list.size());
		//352
		final AdditiveExpression AdditiveExpression_353_Var
		 = (AdditiveExpression)Expr_352_list.get(0);
		Assert.assertNotNull(AdditiveExpression_353_Var
		);
		final EList<? extends EObject> Expr_353_list = AdditiveExpression_353_Var
		.getExpr();
		Assert.assertNotNull(Expr_353_list);
		Assert.assertEquals(1, Expr_353_list.size());
		//353
		final MultiplicativeExpression MultiplicativeExpression_354_Var
		 = (MultiplicativeExpression)Expr_353_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_354_Var
		);
		final EList<? extends EObject> Expr_354_list = MultiplicativeExpression_354_Var
		.getExpr();
		Assert.assertNotNull(Expr_354_list);
		Assert.assertEquals(1, Expr_354_list.size());
		//354
		final CastExpression CastExpression_355_Var
		 = (CastExpression)Expr_354_list.get(0);
		Assert.assertNotNull(CastExpression_355_Var
		);
		//355
		final UnaryExpression UnaryExpression_356_Var
		 = (UnaryExpression)CastExpression_355_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_356_Var
		);
		//356
		final PostfixExpression PostfixExpression_357_Var
		 = (PostfixExpression)UnaryExpression_356_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_357_Var
		);
		final EList<? extends EObject> Expr_357_list = PostfixExpression_357_Var
		.getExpr();
		Assert.assertNotNull(Expr_357_list);
		Assert.assertEquals(1, Expr_357_list.size());
		//357
		final PrimaryExpression PrimaryExpression_358_Var
		 = (PrimaryExpression)Expr_357_list.get(0);
		Assert.assertNotNull(PrimaryExpression_358_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_358_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_358_list = PostfixExpression_357_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_358_list);
		Assert.assertEquals(1, ArgumentExpressionList_358_list.size());
		//358
		final ArgumentExpressionList ArgumentExpressionList_359_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_358_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_359_Var
		);
		final EList<? extends EObject> Expr_359_list = ArgumentExpressionList_359_Var
		.getExpr();
		Assert.assertNotNull(Expr_359_list);
		Assert.assertEquals(2, Expr_359_list.size());
		//359
		final AssignmentExpression AssignmentExpression_360_Var
		 = (AssignmentExpression)Expr_359_list.get(0);
		Assert.assertNotNull(AssignmentExpression_360_Var
		);
		//360
		final ConditionalExpression ConditionalExpression_361_Var
		 = (ConditionalExpression)AssignmentExpression_360_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_361_Var
		);
		//361
		final LogicalOrExpression LogicalOrExpression_362_Var
		 = (LogicalOrExpression)ConditionalExpression_361_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_362_Var
		);
		final EList<? extends EObject> Expr_362_list = LogicalOrExpression_362_Var
		.getExpr();
		Assert.assertNotNull(Expr_362_list);
		Assert.assertEquals(1, Expr_362_list.size());
		//362
		final LogicalAndExpression LogicalAndExpression_363_Var
		 = (LogicalAndExpression)Expr_362_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_363_Var
		);
		final EList<? extends EObject> Expr_363_list = LogicalAndExpression_363_Var
		.getExpr();
		Assert.assertNotNull(Expr_363_list);
		Assert.assertEquals(1, Expr_363_list.size());
		//363
		final InclusiveOrExpression InclusiveOrExpression_364_Var
		 = (InclusiveOrExpression)Expr_363_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_364_Var
		);
		final EList<? extends EObject> Expr_364_list = InclusiveOrExpression_364_Var
		.getExpr();
		Assert.assertNotNull(Expr_364_list);
		Assert.assertEquals(1, Expr_364_list.size());
		//364
		final ExclusiveOrExpression ExclusiveOrExpression_365_Var
		 = (ExclusiveOrExpression)Expr_364_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_365_Var
		);
		final EList<? extends EObject> Expr_365_list = ExclusiveOrExpression_365_Var
		.getExpr();
		Assert.assertNotNull(Expr_365_list);
		Assert.assertEquals(1, Expr_365_list.size());
		//365
		final AndExpression AndExpression_366_Var
		 = (AndExpression)Expr_365_list.get(0);
		Assert.assertNotNull(AndExpression_366_Var
		);
		final EList<? extends EObject> Expr_366_list = AndExpression_366_Var
		.getExpr();
		Assert.assertNotNull(Expr_366_list);
		Assert.assertEquals(1, Expr_366_list.size());
		//366
		final EqualityExpression EqualityExpression_367_Var
		 = (EqualityExpression)Expr_366_list.get(0);
		Assert.assertNotNull(EqualityExpression_367_Var
		);
		final EList<? extends EObject> Expr_367_list = EqualityExpression_367_Var
		.getExpr();
		Assert.assertNotNull(Expr_367_list);
		Assert.assertEquals(1, Expr_367_list.size());
		//367
		final RelationalExpression RelationalExpression_368_Var
		 = (RelationalExpression)Expr_367_list.get(0);
		Assert.assertNotNull(RelationalExpression_368_Var
		);
		final EList<? extends EObject> Expr_368_list = RelationalExpression_368_Var
		.getExpr();
		Assert.assertNotNull(Expr_368_list);
		Assert.assertEquals(1, Expr_368_list.size());
		//368
		final ShiftExpression ShiftExpression_369_Var
		 = (ShiftExpression)Expr_368_list.get(0);
		Assert.assertNotNull(ShiftExpression_369_Var
		);
		final EList<? extends EObject> Expr_369_list = ShiftExpression_369_Var
		.getExpr();
		Assert.assertNotNull(Expr_369_list);
		Assert.assertEquals(1, Expr_369_list.size());
		//369
		final AdditiveExpression AdditiveExpression_370_Var
		 = (AdditiveExpression)Expr_369_list.get(0);
		Assert.assertNotNull(AdditiveExpression_370_Var
		);
		final EList<? extends EObject> Expr_370_list = AdditiveExpression_370_Var
		.getExpr();
		Assert.assertNotNull(Expr_370_list);
		Assert.assertEquals(1, Expr_370_list.size());
		//370
		final MultiplicativeExpression MultiplicativeExpression_371_Var
		 = (MultiplicativeExpression)Expr_370_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_371_Var
		);
		final EList<? extends EObject> Expr_371_list = MultiplicativeExpression_371_Var
		.getExpr();
		Assert.assertNotNull(Expr_371_list);
		Assert.assertEquals(1, Expr_371_list.size());
		//371
		final CastExpression CastExpression_372_Var
		 = (CastExpression)Expr_371_list.get(0);
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
		Assert.assertEquals("\"Monday is %d. day of week\\n\"", Constant_376_Var
		.getStr());
		//376
		final AssignmentExpression AssignmentExpression_377_Var
		 = (AssignmentExpression)Expr_359_list.get(1);
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
		Assert.assertEquals("MONDAY", PrimaryExpression_392_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_341_Var
		.getSemi());
		//392
		final Statement Statement_393_Var
		 = (Statement)Statement_286_list.get(2);
		Assert.assertNotNull(Statement_393_Var
		);
		//393
		final ExpressionStatement ExpressionStatement_394_Var
		 = (ExpressionStatement)Statement_393_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_394_Var
		);
		//394
		final Expression Expression_395_Var
		 = (Expression)ExpressionStatement_394_Var
		.getExpression();
		Assert.assertNotNull(Expression_395_Var
		);
		final EList<? extends EObject> ExprExpr_395_list = Expression_395_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_395_list);
		Assert.assertEquals(1, ExprExpr_395_list.size());
		//395
		final AssignmentExpression AssignmentExpression_396_Var
		 = (AssignmentExpression)ExprExpr_395_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_411_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_411_list = PostfixExpression_410_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_411_list);
		Assert.assertEquals(1, ArgumentExpressionList_411_list.size());
		//411
		final ArgumentExpressionList ArgumentExpressionList_412_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_411_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_412_Var
		);
		final EList<? extends EObject> Expr_412_list = ArgumentExpressionList_412_Var
		.getExpr();
		Assert.assertNotNull(Expr_412_list);
		Assert.assertEquals(2, Expr_412_list.size());
		//412
		final AssignmentExpression AssignmentExpression_413_Var
		 = (AssignmentExpression)Expr_412_list.get(0);
		Assert.assertNotNull(AssignmentExpression_413_Var
		);
		//413
		final ConditionalExpression ConditionalExpression_414_Var
		 = (ConditionalExpression)AssignmentExpression_413_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_414_Var
		);
		//414
		final LogicalOrExpression LogicalOrExpression_415_Var
		 = (LogicalOrExpression)ConditionalExpression_414_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_415_Var
		);
		final EList<? extends EObject> Expr_415_list = LogicalOrExpression_415_Var
		.getExpr();
		Assert.assertNotNull(Expr_415_list);
		Assert.assertEquals(1, Expr_415_list.size());
		//415
		final LogicalAndExpression LogicalAndExpression_416_Var
		 = (LogicalAndExpression)Expr_415_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_416_Var
		);
		final EList<? extends EObject> Expr_416_list = LogicalAndExpression_416_Var
		.getExpr();
		Assert.assertNotNull(Expr_416_list);
		Assert.assertEquals(1, Expr_416_list.size());
		//416
		final InclusiveOrExpression InclusiveOrExpression_417_Var
		 = (InclusiveOrExpression)Expr_416_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_417_Var
		);
		final EList<? extends EObject> Expr_417_list = InclusiveOrExpression_417_Var
		.getExpr();
		Assert.assertNotNull(Expr_417_list);
		Assert.assertEquals(1, Expr_417_list.size());
		//417
		final ExclusiveOrExpression ExclusiveOrExpression_418_Var
		 = (ExclusiveOrExpression)Expr_417_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_418_Var
		);
		final EList<? extends EObject> Expr_418_list = ExclusiveOrExpression_418_Var
		.getExpr();
		Assert.assertNotNull(Expr_418_list);
		Assert.assertEquals(1, Expr_418_list.size());
		//418
		final AndExpression AndExpression_419_Var
		 = (AndExpression)Expr_418_list.get(0);
		Assert.assertNotNull(AndExpression_419_Var
		);
		final EList<? extends EObject> Expr_419_list = AndExpression_419_Var
		.getExpr();
		Assert.assertNotNull(Expr_419_list);
		Assert.assertEquals(1, Expr_419_list.size());
		//419
		final EqualityExpression EqualityExpression_420_Var
		 = (EqualityExpression)Expr_419_list.get(0);
		Assert.assertNotNull(EqualityExpression_420_Var
		);
		final EList<? extends EObject> Expr_420_list = EqualityExpression_420_Var
		.getExpr();
		Assert.assertNotNull(Expr_420_list);
		Assert.assertEquals(1, Expr_420_list.size());
		//420
		final RelationalExpression RelationalExpression_421_Var
		 = (RelationalExpression)Expr_420_list.get(0);
		Assert.assertNotNull(RelationalExpression_421_Var
		);
		final EList<? extends EObject> Expr_421_list = RelationalExpression_421_Var
		.getExpr();
		Assert.assertNotNull(Expr_421_list);
		Assert.assertEquals(1, Expr_421_list.size());
		//421
		final ShiftExpression ShiftExpression_422_Var
		 = (ShiftExpression)Expr_421_list.get(0);
		Assert.assertNotNull(ShiftExpression_422_Var
		);
		final EList<? extends EObject> Expr_422_list = ShiftExpression_422_Var
		.getExpr();
		Assert.assertNotNull(Expr_422_list);
		Assert.assertEquals(1, Expr_422_list.size());
		//422
		final AdditiveExpression AdditiveExpression_423_Var
		 = (AdditiveExpression)Expr_422_list.get(0);
		Assert.assertNotNull(AdditiveExpression_423_Var
		);
		final EList<? extends EObject> Expr_423_list = AdditiveExpression_423_Var
		.getExpr();
		Assert.assertNotNull(Expr_423_list);
		Assert.assertEquals(1, Expr_423_list.size());
		//423
		final MultiplicativeExpression MultiplicativeExpression_424_Var
		 = (MultiplicativeExpression)Expr_423_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_424_Var
		);
		final EList<? extends EObject> Expr_424_list = MultiplicativeExpression_424_Var
		.getExpr();
		Assert.assertNotNull(Expr_424_list);
		Assert.assertEquals(1, Expr_424_list.size());
		//424
		final CastExpression CastExpression_425_Var
		 = (CastExpression)Expr_424_list.get(0);
		Assert.assertNotNull(CastExpression_425_Var
		);
		//425
		final UnaryExpression UnaryExpression_426_Var
		 = (UnaryExpression)CastExpression_425_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_426_Var
		);
		//426
		final PostfixExpression PostfixExpression_427_Var
		 = (PostfixExpression)UnaryExpression_426_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_427_Var
		);
		final EList<? extends EObject> Expr_427_list = PostfixExpression_427_Var
		.getExpr();
		Assert.assertNotNull(Expr_427_list);
		Assert.assertEquals(1, Expr_427_list.size());
		//427
		final PrimaryExpression PrimaryExpression_428_Var
		 = (PrimaryExpression)Expr_427_list.get(0);
		Assert.assertNotNull(PrimaryExpression_428_Var
		);
		//428
		final Constant Constant_429_Var
		 = (Constant)PrimaryExpression_428_Var
		.getConst();
		Assert.assertNotNull(Constant_429_Var
		);
		Assert.assertEquals("\"Sunday is %d. day of week\\n\"", Constant_429_Var
		.getStr());
		//429
		final AssignmentExpression AssignmentExpression_430_Var
		 = (AssignmentExpression)Expr_412_list.get(1);
		Assert.assertNotNull(AssignmentExpression_430_Var
		);
		//430
		final ConditionalExpression ConditionalExpression_431_Var
		 = (ConditionalExpression)AssignmentExpression_430_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_431_Var
		);
		//431
		final LogicalOrExpression LogicalOrExpression_432_Var
		 = (LogicalOrExpression)ConditionalExpression_431_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_432_Var
		);
		final EList<? extends EObject> Expr_432_list = LogicalOrExpression_432_Var
		.getExpr();
		Assert.assertNotNull(Expr_432_list);
		Assert.assertEquals(1, Expr_432_list.size());
		//432
		final LogicalAndExpression LogicalAndExpression_433_Var
		 = (LogicalAndExpression)Expr_432_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_433_Var
		);
		final EList<? extends EObject> Expr_433_list = LogicalAndExpression_433_Var
		.getExpr();
		Assert.assertNotNull(Expr_433_list);
		Assert.assertEquals(1, Expr_433_list.size());
		//433
		final InclusiveOrExpression InclusiveOrExpression_434_Var
		 = (InclusiveOrExpression)Expr_433_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_434_Var
		);
		final EList<? extends EObject> Expr_434_list = InclusiveOrExpression_434_Var
		.getExpr();
		Assert.assertNotNull(Expr_434_list);
		Assert.assertEquals(1, Expr_434_list.size());
		//434
		final ExclusiveOrExpression ExclusiveOrExpression_435_Var
		 = (ExclusiveOrExpression)Expr_434_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_435_Var
		);
		final EList<? extends EObject> Expr_435_list = ExclusiveOrExpression_435_Var
		.getExpr();
		Assert.assertNotNull(Expr_435_list);
		Assert.assertEquals(1, Expr_435_list.size());
		//435
		final AndExpression AndExpression_436_Var
		 = (AndExpression)Expr_435_list.get(0);
		Assert.assertNotNull(AndExpression_436_Var
		);
		final EList<? extends EObject> Expr_436_list = AndExpression_436_Var
		.getExpr();
		Assert.assertNotNull(Expr_436_list);
		Assert.assertEquals(1, Expr_436_list.size());
		//436
		final EqualityExpression EqualityExpression_437_Var
		 = (EqualityExpression)Expr_436_list.get(0);
		Assert.assertNotNull(EqualityExpression_437_Var
		);
		final EList<? extends EObject> Expr_437_list = EqualityExpression_437_Var
		.getExpr();
		Assert.assertNotNull(Expr_437_list);
		Assert.assertEquals(1, Expr_437_list.size());
		//437
		final RelationalExpression RelationalExpression_438_Var
		 = (RelationalExpression)Expr_437_list.get(0);
		Assert.assertNotNull(RelationalExpression_438_Var
		);
		final EList<? extends EObject> Expr_438_list = RelationalExpression_438_Var
		.getExpr();
		Assert.assertNotNull(Expr_438_list);
		Assert.assertEquals(1, Expr_438_list.size());
		//438
		final ShiftExpression ShiftExpression_439_Var
		 = (ShiftExpression)Expr_438_list.get(0);
		Assert.assertNotNull(ShiftExpression_439_Var
		);
		final EList<? extends EObject> Expr_439_list = ShiftExpression_439_Var
		.getExpr();
		Assert.assertNotNull(Expr_439_list);
		Assert.assertEquals(1, Expr_439_list.size());
		//439
		final AdditiveExpression AdditiveExpression_440_Var
		 = (AdditiveExpression)Expr_439_list.get(0);
		Assert.assertNotNull(AdditiveExpression_440_Var
		);
		final EList<? extends EObject> Expr_440_list = AdditiveExpression_440_Var
		.getExpr();
		Assert.assertNotNull(Expr_440_list);
		Assert.assertEquals(1, Expr_440_list.size());
		//440
		final MultiplicativeExpression MultiplicativeExpression_441_Var
		 = (MultiplicativeExpression)Expr_440_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_441_Var
		);
		final EList<? extends EObject> Expr_441_list = MultiplicativeExpression_441_Var
		.getExpr();
		Assert.assertNotNull(Expr_441_list);
		Assert.assertEquals(1, Expr_441_list.size());
		//441
		final CastExpression CastExpression_442_Var
		 = (CastExpression)Expr_441_list.get(0);
		Assert.assertNotNull(CastExpression_442_Var
		);
		//442
		final UnaryExpression UnaryExpression_443_Var
		 = (UnaryExpression)CastExpression_442_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_443_Var
		);
		//443
		final PostfixExpression PostfixExpression_444_Var
		 = (PostfixExpression)UnaryExpression_443_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_444_Var
		);
		final EList<? extends EObject> Expr_444_list = PostfixExpression_444_Var
		.getExpr();
		Assert.assertNotNull(Expr_444_list);
		Assert.assertEquals(1, Expr_444_list.size());
		//444
		final PrimaryExpression PrimaryExpression_445_Var
		 = (PrimaryExpression)Expr_444_list.get(0);
		Assert.assertNotNull(PrimaryExpression_445_Var
		);
		Assert.assertEquals("W_SUNDAY", PrimaryExpression_445_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_394_Var
		.getSemi());
		//445
		final Statement Statement_446_Var
		 = (Statement)Statement_286_list.get(3);
		Assert.assertNotNull(Statement_446_Var
		);
		//446
		final ExpressionStatement ExpressionStatement_447_Var
		 = (ExpressionStatement)Statement_446_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_447_Var
		);
		//447
		final Expression Expression_448_Var
		 = (Expression)ExpressionStatement_447_Var
		.getExpression();
		Assert.assertNotNull(Expression_448_Var
		);
		final EList<? extends EObject> ExprExpr_448_list = Expression_448_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_448_list);
		Assert.assertEquals(1, ExprExpr_448_list.size());
		//448
		final AssignmentExpression AssignmentExpression_449_Var
		 = (AssignmentExpression)ExprExpr_448_list.get(0);
		Assert.assertNotNull(AssignmentExpression_449_Var
		);
		//449
		final ConditionalExpression ConditionalExpression_450_Var
		 = (ConditionalExpression)AssignmentExpression_449_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_450_Var
		);
		//450
		final LogicalOrExpression LogicalOrExpression_451_Var
		 = (LogicalOrExpression)ConditionalExpression_450_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_451_Var
		);
		final EList<? extends EObject> Expr_451_list = LogicalOrExpression_451_Var
		.getExpr();
		Assert.assertNotNull(Expr_451_list);
		Assert.assertEquals(1, Expr_451_list.size());
		//451
		final LogicalAndExpression LogicalAndExpression_452_Var
		 = (LogicalAndExpression)Expr_451_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_452_Var
		);
		final EList<? extends EObject> Expr_452_list = LogicalAndExpression_452_Var
		.getExpr();
		Assert.assertNotNull(Expr_452_list);
		Assert.assertEquals(1, Expr_452_list.size());
		//452
		final InclusiveOrExpression InclusiveOrExpression_453_Var
		 = (InclusiveOrExpression)Expr_452_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_453_Var
		);
		final EList<? extends EObject> Expr_453_list = InclusiveOrExpression_453_Var
		.getExpr();
		Assert.assertNotNull(Expr_453_list);
		Assert.assertEquals(1, Expr_453_list.size());
		//453
		final ExclusiveOrExpression ExclusiveOrExpression_454_Var
		 = (ExclusiveOrExpression)Expr_453_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_454_Var
		);
		final EList<? extends EObject> Expr_454_list = ExclusiveOrExpression_454_Var
		.getExpr();
		Assert.assertNotNull(Expr_454_list);
		Assert.assertEquals(1, Expr_454_list.size());
		//454
		final AndExpression AndExpression_455_Var
		 = (AndExpression)Expr_454_list.get(0);
		Assert.assertNotNull(AndExpression_455_Var
		);
		final EList<? extends EObject> Expr_455_list = AndExpression_455_Var
		.getExpr();
		Assert.assertNotNull(Expr_455_list);
		Assert.assertEquals(1, Expr_455_list.size());
		//455
		final EqualityExpression EqualityExpression_456_Var
		 = (EqualityExpression)Expr_455_list.get(0);
		Assert.assertNotNull(EqualityExpression_456_Var
		);
		final EList<? extends EObject> Expr_456_list = EqualityExpression_456_Var
		.getExpr();
		Assert.assertNotNull(Expr_456_list);
		Assert.assertEquals(1, Expr_456_list.size());
		//456
		final RelationalExpression RelationalExpression_457_Var
		 = (RelationalExpression)Expr_456_list.get(0);
		Assert.assertNotNull(RelationalExpression_457_Var
		);
		final EList<? extends EObject> Expr_457_list = RelationalExpression_457_Var
		.getExpr();
		Assert.assertNotNull(Expr_457_list);
		Assert.assertEquals(1, Expr_457_list.size());
		//457
		final ShiftExpression ShiftExpression_458_Var
		 = (ShiftExpression)Expr_457_list.get(0);
		Assert.assertNotNull(ShiftExpression_458_Var
		);
		final EList<? extends EObject> Expr_458_list = ShiftExpression_458_Var
		.getExpr();
		Assert.assertNotNull(Expr_458_list);
		Assert.assertEquals(1, Expr_458_list.size());
		//458
		final AdditiveExpression AdditiveExpression_459_Var
		 = (AdditiveExpression)Expr_458_list.get(0);
		Assert.assertNotNull(AdditiveExpression_459_Var
		);
		final EList<? extends EObject> Expr_459_list = AdditiveExpression_459_Var
		.getExpr();
		Assert.assertNotNull(Expr_459_list);
		Assert.assertEquals(1, Expr_459_list.size());
		//459
		final MultiplicativeExpression MultiplicativeExpression_460_Var
		 = (MultiplicativeExpression)Expr_459_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_460_Var
		);
		final EList<? extends EObject> Expr_460_list = MultiplicativeExpression_460_Var
		.getExpr();
		Assert.assertNotNull(Expr_460_list);
		Assert.assertEquals(1, Expr_460_list.size());
		//460
		final CastExpression CastExpression_461_Var
		 = (CastExpression)Expr_460_list.get(0);
		Assert.assertNotNull(CastExpression_461_Var
		);
		//461
		final UnaryExpression UnaryExpression_462_Var
		 = (UnaryExpression)CastExpression_461_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_462_Var
		);
		//462
		final PostfixExpression PostfixExpression_463_Var
		 = (PostfixExpression)UnaryExpression_462_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_463_Var
		);
		final EList<? extends EObject> Expr_463_list = PostfixExpression_463_Var
		.getExpr();
		Assert.assertNotNull(Expr_463_list);
		Assert.assertEquals(1, Expr_463_list.size());
		//463
		final PrimaryExpression PrimaryExpression_464_Var
		 = (PrimaryExpression)Expr_463_list.get(0);
		Assert.assertNotNull(PrimaryExpression_464_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_464_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_464_list = PostfixExpression_463_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_464_list);
		Assert.assertEquals(1, ArgumentExpressionList_464_list.size());
		//464
		final ArgumentExpressionList ArgumentExpressionList_465_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_464_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_465_Var
		);
		final EList<? extends EObject> Expr_465_list = ArgumentExpressionList_465_Var
		.getExpr();
		Assert.assertNotNull(Expr_465_list);
		Assert.assertEquals(2, Expr_465_list.size());
		//465
		final AssignmentExpression AssignmentExpression_466_Var
		 = (AssignmentExpression)Expr_465_list.get(0);
		Assert.assertNotNull(AssignmentExpression_466_Var
		);
		//466
		final ConditionalExpression ConditionalExpression_467_Var
		 = (ConditionalExpression)AssignmentExpression_466_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_467_Var
		);
		//467
		final LogicalOrExpression LogicalOrExpression_468_Var
		 = (LogicalOrExpression)ConditionalExpression_467_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_468_Var
		);
		final EList<? extends EObject> Expr_468_list = LogicalOrExpression_468_Var
		.getExpr();
		Assert.assertNotNull(Expr_468_list);
		Assert.assertEquals(1, Expr_468_list.size());
		//468
		final LogicalAndExpression LogicalAndExpression_469_Var
		 = (LogicalAndExpression)Expr_468_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_469_Var
		);
		final EList<? extends EObject> Expr_469_list = LogicalAndExpression_469_Var
		.getExpr();
		Assert.assertNotNull(Expr_469_list);
		Assert.assertEquals(1, Expr_469_list.size());
		//469
		final InclusiveOrExpression InclusiveOrExpression_470_Var
		 = (InclusiveOrExpression)Expr_469_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_470_Var
		);
		final EList<? extends EObject> Expr_470_list = InclusiveOrExpression_470_Var
		.getExpr();
		Assert.assertNotNull(Expr_470_list);
		Assert.assertEquals(1, Expr_470_list.size());
		//470
		final ExclusiveOrExpression ExclusiveOrExpression_471_Var
		 = (ExclusiveOrExpression)Expr_470_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_471_Var
		);
		final EList<? extends EObject> Expr_471_list = ExclusiveOrExpression_471_Var
		.getExpr();
		Assert.assertNotNull(Expr_471_list);
		Assert.assertEquals(1, Expr_471_list.size());
		//471
		final AndExpression AndExpression_472_Var
		 = (AndExpression)Expr_471_list.get(0);
		Assert.assertNotNull(AndExpression_472_Var
		);
		final EList<? extends EObject> Expr_472_list = AndExpression_472_Var
		.getExpr();
		Assert.assertNotNull(Expr_472_list);
		Assert.assertEquals(1, Expr_472_list.size());
		//472
		final EqualityExpression EqualityExpression_473_Var
		 = (EqualityExpression)Expr_472_list.get(0);
		Assert.assertNotNull(EqualityExpression_473_Var
		);
		final EList<? extends EObject> Expr_473_list = EqualityExpression_473_Var
		.getExpr();
		Assert.assertNotNull(Expr_473_list);
		Assert.assertEquals(1, Expr_473_list.size());
		//473
		final RelationalExpression RelationalExpression_474_Var
		 = (RelationalExpression)Expr_473_list.get(0);
		Assert.assertNotNull(RelationalExpression_474_Var
		);
		final EList<? extends EObject> Expr_474_list = RelationalExpression_474_Var
		.getExpr();
		Assert.assertNotNull(Expr_474_list);
		Assert.assertEquals(1, Expr_474_list.size());
		//474
		final ShiftExpression ShiftExpression_475_Var
		 = (ShiftExpression)Expr_474_list.get(0);
		Assert.assertNotNull(ShiftExpression_475_Var
		);
		final EList<? extends EObject> Expr_475_list = ShiftExpression_475_Var
		.getExpr();
		Assert.assertNotNull(Expr_475_list);
		Assert.assertEquals(1, Expr_475_list.size());
		//475
		final AdditiveExpression AdditiveExpression_476_Var
		 = (AdditiveExpression)Expr_475_list.get(0);
		Assert.assertNotNull(AdditiveExpression_476_Var
		);
		final EList<? extends EObject> Expr_476_list = AdditiveExpression_476_Var
		.getExpr();
		Assert.assertNotNull(Expr_476_list);
		Assert.assertEquals(1, Expr_476_list.size());
		//476
		final MultiplicativeExpression MultiplicativeExpression_477_Var
		 = (MultiplicativeExpression)Expr_476_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_477_Var
		);
		final EList<? extends EObject> Expr_477_list = MultiplicativeExpression_477_Var
		.getExpr();
		Assert.assertNotNull(Expr_477_list);
		Assert.assertEquals(1, Expr_477_list.size());
		//477
		final CastExpression CastExpression_478_Var
		 = (CastExpression)Expr_477_list.get(0);
		Assert.assertNotNull(CastExpression_478_Var
		);
		//478
		final UnaryExpression UnaryExpression_479_Var
		 = (UnaryExpression)CastExpression_478_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_479_Var
		);
		//479
		final PostfixExpression PostfixExpression_480_Var
		 = (PostfixExpression)UnaryExpression_479_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_480_Var
		);
		final EList<? extends EObject> Expr_480_list = PostfixExpression_480_Var
		.getExpr();
		Assert.assertNotNull(Expr_480_list);
		Assert.assertEquals(1, Expr_480_list.size());
		//480
		final PrimaryExpression PrimaryExpression_481_Var
		 = (PrimaryExpression)Expr_480_list.get(0);
		Assert.assertNotNull(PrimaryExpression_481_Var
		);
		//481
		final Constant Constant_482_Var
		 = (Constant)PrimaryExpression_481_Var
		.getConst();
		Assert.assertNotNull(Constant_482_Var
		);
		Assert.assertEquals("\"Sunday is %d. day of week\\n\"", Constant_482_Var
		.getStr());
		//482
		final AssignmentExpression AssignmentExpression_483_Var
		 = (AssignmentExpression)Expr_465_list.get(1);
		Assert.assertNotNull(AssignmentExpression_483_Var
		);
		//483
		final ConditionalExpression ConditionalExpression_484_Var
		 = (ConditionalExpression)AssignmentExpression_483_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_484_Var
		);
		//484
		final LogicalOrExpression LogicalOrExpression_485_Var
		 = (LogicalOrExpression)ConditionalExpression_484_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_485_Var
		);
		final EList<? extends EObject> Expr_485_list = LogicalOrExpression_485_Var
		.getExpr();
		Assert.assertNotNull(Expr_485_list);
		Assert.assertEquals(1, Expr_485_list.size());
		//485
		final LogicalAndExpression LogicalAndExpression_486_Var
		 = (LogicalAndExpression)Expr_485_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_486_Var
		);
		final EList<? extends EObject> Expr_486_list = LogicalAndExpression_486_Var
		.getExpr();
		Assert.assertNotNull(Expr_486_list);
		Assert.assertEquals(1, Expr_486_list.size());
		//486
		final InclusiveOrExpression InclusiveOrExpression_487_Var
		 = (InclusiveOrExpression)Expr_486_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_487_Var
		);
		final EList<? extends EObject> Expr_487_list = InclusiveOrExpression_487_Var
		.getExpr();
		Assert.assertNotNull(Expr_487_list);
		Assert.assertEquals(1, Expr_487_list.size());
		//487
		final ExclusiveOrExpression ExclusiveOrExpression_488_Var
		 = (ExclusiveOrExpression)Expr_487_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_488_Var
		);
		final EList<? extends EObject> Expr_488_list = ExclusiveOrExpression_488_Var
		.getExpr();
		Assert.assertNotNull(Expr_488_list);
		Assert.assertEquals(1, Expr_488_list.size());
		//488
		final AndExpression AndExpression_489_Var
		 = (AndExpression)Expr_488_list.get(0);
		Assert.assertNotNull(AndExpression_489_Var
		);
		final EList<? extends EObject> Expr_489_list = AndExpression_489_Var
		.getExpr();
		Assert.assertNotNull(Expr_489_list);
		Assert.assertEquals(1, Expr_489_list.size());
		//489
		final EqualityExpression EqualityExpression_490_Var
		 = (EqualityExpression)Expr_489_list.get(0);
		Assert.assertNotNull(EqualityExpression_490_Var
		);
		final EList<? extends EObject> Expr_490_list = EqualityExpression_490_Var
		.getExpr();
		Assert.assertNotNull(Expr_490_list);
		Assert.assertEquals(1, Expr_490_list.size());
		//490
		final RelationalExpression RelationalExpression_491_Var
		 = (RelationalExpression)Expr_490_list.get(0);
		Assert.assertNotNull(RelationalExpression_491_Var
		);
		final EList<? extends EObject> Expr_491_list = RelationalExpression_491_Var
		.getExpr();
		Assert.assertNotNull(Expr_491_list);
		Assert.assertEquals(1, Expr_491_list.size());
		//491
		final ShiftExpression ShiftExpression_492_Var
		 = (ShiftExpression)Expr_491_list.get(0);
		Assert.assertNotNull(ShiftExpression_492_Var
		);
		final EList<? extends EObject> Expr_492_list = ShiftExpression_492_Var
		.getExpr();
		Assert.assertNotNull(Expr_492_list);
		Assert.assertEquals(1, Expr_492_list.size());
		//492
		final AdditiveExpression AdditiveExpression_493_Var
		 = (AdditiveExpression)Expr_492_list.get(0);
		Assert.assertNotNull(AdditiveExpression_493_Var
		);
		final EList<? extends EObject> Expr_493_list = AdditiveExpression_493_Var
		.getExpr();
		Assert.assertNotNull(Expr_493_list);
		Assert.assertEquals(1, Expr_493_list.size());
		//493
		final MultiplicativeExpression MultiplicativeExpression_494_Var
		 = (MultiplicativeExpression)Expr_493_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_494_Var
		);
		final EList<? extends EObject> Expr_494_list = MultiplicativeExpression_494_Var
		.getExpr();
		Assert.assertNotNull(Expr_494_list);
		Assert.assertEquals(1, Expr_494_list.size());
		//494
		final CastExpression CastExpression_495_Var
		 = (CastExpression)Expr_494_list.get(0);
		Assert.assertNotNull(CastExpression_495_Var
		);
		//495
		final UnaryExpression UnaryExpression_496_Var
		 = (UnaryExpression)CastExpression_495_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_496_Var
		);
		//496
		final PostfixExpression PostfixExpression_497_Var
		 = (PostfixExpression)UnaryExpression_496_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_497_Var
		);
		final EList<? extends EObject> Expr_497_list = PostfixExpression_497_Var
		.getExpr();
		Assert.assertNotNull(Expr_497_list);
		Assert.assertEquals(1, Expr_497_list.size());
		//497
		final PrimaryExpression PrimaryExpression_498_Var
		 = (PrimaryExpression)Expr_497_list.get(0);
		Assert.assertNotNull(PrimaryExpression_498_Var
		);
		Assert.assertEquals("SUNDAY", PrimaryExpression_498_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_447_Var
		.getSemi());
		//498
		final Statement Statement_499_Var
		 = (Statement)Statement_286_list.get(4);
		Assert.assertNotNull(Statement_499_Var
		);
		//499
		final ExpressionStatement ExpressionStatement_500_Var
		 = (ExpressionStatement)Statement_499_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_500_Var
		);
		//500
		final Expression Expression_501_Var
		 = (Expression)ExpressionStatement_500_Var
		.getExpression();
		Assert.assertNotNull(Expression_501_Var
		);
		final EList<? extends EObject> ExprExpr_501_list = Expression_501_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_501_list);
		Assert.assertEquals(1, ExprExpr_501_list.size());
		//501
		final AssignmentExpression AssignmentExpression_502_Var
		 = (AssignmentExpression)ExprExpr_501_list.get(0);
		Assert.assertNotNull(AssignmentExpression_502_Var
		);
		//502
		final UnaryExpression UnaryExpression_503_Var
		 = (UnaryExpression)AssignmentExpression_502_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_503_Var
		);
		//503
		final PostfixExpression PostfixExpression_504_Var
		 = (PostfixExpression)UnaryExpression_503_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_504_Var
		);
		final EList<? extends EObject> Expr_504_list = PostfixExpression_504_Var
		.getExpr();
		Assert.assertNotNull(Expr_504_list);
		Assert.assertEquals(1, Expr_504_list.size());
		//504
		final PrimaryExpression PrimaryExpression_505_Var
		 = (PrimaryExpression)Expr_504_list.get(0);
		Assert.assertNotNull(PrimaryExpression_505_Var
		);
		Assert.assertEquals("iAmInLove", PrimaryExpression_505_Var
		.getId());
		//505
		final AssignmentOperator AssignmentOperator_506_Var
		 = (AssignmentOperator)AssignmentExpression_502_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_506_Var
		);
		Assert.assertEquals("=", AssignmentOperator_506_Var
		.getOp());
		//506
		final AssignmentExpression AssignmentExpression_507_Var
		 = (AssignmentExpression)AssignmentExpression_502_Var
		.getAssignmentExpr();
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
		Assert.assertEquals("I_FRIDAY", PrimaryExpression_522_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_500_Var
		.getSemi());
		//522
		final Statement Statement_523_Var
		 = (Statement)Statement_286_list.get(5);
		Assert.assertNotNull(Statement_523_Var
		);
		//523
		final ExpressionStatement ExpressionStatement_524_Var
		 = (ExpressionStatement)Statement_523_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_524_Var
		);
		//524
		final Expression Expression_525_Var
		 = (Expression)ExpressionStatement_524_Var
		.getExpression();
		Assert.assertNotNull(Expression_525_Var
		);
		final EList<? extends EObject> ExprExpr_525_list = Expression_525_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_525_list);
		Assert.assertEquals(1, ExprExpr_525_list.size());
		//525
		final AssignmentExpression AssignmentExpression_526_Var
		 = (AssignmentExpression)ExprExpr_525_list.get(0);
		Assert.assertNotNull(AssignmentExpression_526_Var
		);
		//526
		final ConditionalExpression ConditionalExpression_527_Var
		 = (ConditionalExpression)AssignmentExpression_526_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_527_Var
		);
		//527
		final LogicalOrExpression LogicalOrExpression_528_Var
		 = (LogicalOrExpression)ConditionalExpression_527_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_528_Var
		);
		final EList<? extends EObject> Expr_528_list = LogicalOrExpression_528_Var
		.getExpr();
		Assert.assertNotNull(Expr_528_list);
		Assert.assertEquals(1, Expr_528_list.size());
		//528
		final LogicalAndExpression LogicalAndExpression_529_Var
		 = (LogicalAndExpression)Expr_528_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_529_Var
		);
		final EList<? extends EObject> Expr_529_list = LogicalAndExpression_529_Var
		.getExpr();
		Assert.assertNotNull(Expr_529_list);
		Assert.assertEquals(1, Expr_529_list.size());
		//529
		final InclusiveOrExpression InclusiveOrExpression_530_Var
		 = (InclusiveOrExpression)Expr_529_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_530_Var
		);
		final EList<? extends EObject> Expr_530_list = InclusiveOrExpression_530_Var
		.getExpr();
		Assert.assertNotNull(Expr_530_list);
		Assert.assertEquals(1, Expr_530_list.size());
		//530
		final ExclusiveOrExpression ExclusiveOrExpression_531_Var
		 = (ExclusiveOrExpression)Expr_530_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_531_Var
		);
		final EList<? extends EObject> Expr_531_list = ExclusiveOrExpression_531_Var
		.getExpr();
		Assert.assertNotNull(Expr_531_list);
		Assert.assertEquals(1, Expr_531_list.size());
		//531
		final AndExpression AndExpression_532_Var
		 = (AndExpression)Expr_531_list.get(0);
		Assert.assertNotNull(AndExpression_532_Var
		);
		final EList<? extends EObject> Expr_532_list = AndExpression_532_Var
		.getExpr();
		Assert.assertNotNull(Expr_532_list);
		Assert.assertEquals(1, Expr_532_list.size());
		//532
		final EqualityExpression EqualityExpression_533_Var
		 = (EqualityExpression)Expr_532_list.get(0);
		Assert.assertNotNull(EqualityExpression_533_Var
		);
		final EList<? extends EObject> Expr_533_list = EqualityExpression_533_Var
		.getExpr();
		Assert.assertNotNull(Expr_533_list);
		Assert.assertEquals(1, Expr_533_list.size());
		//533
		final RelationalExpression RelationalExpression_534_Var
		 = (RelationalExpression)Expr_533_list.get(0);
		Assert.assertNotNull(RelationalExpression_534_Var
		);
		final EList<? extends EObject> Expr_534_list = RelationalExpression_534_Var
		.getExpr();
		Assert.assertNotNull(Expr_534_list);
		Assert.assertEquals(1, Expr_534_list.size());
		//534
		final ShiftExpression ShiftExpression_535_Var
		 = (ShiftExpression)Expr_534_list.get(0);
		Assert.assertNotNull(ShiftExpression_535_Var
		);
		final EList<? extends EObject> Expr_535_list = ShiftExpression_535_Var
		.getExpr();
		Assert.assertNotNull(Expr_535_list);
		Assert.assertEquals(1, Expr_535_list.size());
		//535
		final AdditiveExpression AdditiveExpression_536_Var
		 = (AdditiveExpression)Expr_535_list.get(0);
		Assert.assertNotNull(AdditiveExpression_536_Var
		);
		final EList<? extends EObject> Expr_536_list = AdditiveExpression_536_Var
		.getExpr();
		Assert.assertNotNull(Expr_536_list);
		Assert.assertEquals(1, Expr_536_list.size());
		//536
		final MultiplicativeExpression MultiplicativeExpression_537_Var
		 = (MultiplicativeExpression)Expr_536_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_537_Var
		);
		final EList<? extends EObject> Expr_537_list = MultiplicativeExpression_537_Var
		.getExpr();
		Assert.assertNotNull(Expr_537_list);
		Assert.assertEquals(1, Expr_537_list.size());
		//537
		final CastExpression CastExpression_538_Var
		 = (CastExpression)Expr_537_list.get(0);
		Assert.assertNotNull(CastExpression_538_Var
		);
		//538
		final UnaryExpression UnaryExpression_539_Var
		 = (UnaryExpression)CastExpression_538_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_539_Var
		);
		//539
		final PostfixExpression PostfixExpression_540_Var
		 = (PostfixExpression)UnaryExpression_539_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_540_Var
		);
		final EList<? extends EObject> Expr_540_list = PostfixExpression_540_Var
		.getExpr();
		Assert.assertNotNull(Expr_540_list);
		Assert.assertEquals(1, Expr_540_list.size());
		//540
		final PrimaryExpression PrimaryExpression_541_Var
		 = (PrimaryExpression)Expr_540_list.get(0);
		Assert.assertNotNull(PrimaryExpression_541_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_541_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_541_list = PostfixExpression_540_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_541_list);
		Assert.assertEquals(1, ArgumentExpressionList_541_list.size());
		//541
		final ArgumentExpressionList ArgumentExpressionList_542_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_541_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_542_Var
		);
		final EList<? extends EObject> Expr_542_list = ArgumentExpressionList_542_Var
		.getExpr();
		Assert.assertNotNull(Expr_542_list);
		Assert.assertEquals(2, Expr_542_list.size());
		//542
		final AssignmentExpression AssignmentExpression_543_Var
		 = (AssignmentExpression)Expr_542_list.get(0);
		Assert.assertNotNull(AssignmentExpression_543_Var
		);
		//543
		final ConditionalExpression ConditionalExpression_544_Var
		 = (ConditionalExpression)AssignmentExpression_543_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_544_Var
		);
		//544
		final LogicalOrExpression LogicalOrExpression_545_Var
		 = (LogicalOrExpression)ConditionalExpression_544_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_545_Var
		);
		final EList<? extends EObject> Expr_545_list = LogicalOrExpression_545_Var
		.getExpr();
		Assert.assertNotNull(Expr_545_list);
		Assert.assertEquals(1, Expr_545_list.size());
		//545
		final LogicalAndExpression LogicalAndExpression_546_Var
		 = (LogicalAndExpression)Expr_545_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_546_Var
		);
		final EList<? extends EObject> Expr_546_list = LogicalAndExpression_546_Var
		.getExpr();
		Assert.assertNotNull(Expr_546_list);
		Assert.assertEquals(1, Expr_546_list.size());
		//546
		final InclusiveOrExpression InclusiveOrExpression_547_Var
		 = (InclusiveOrExpression)Expr_546_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_547_Var
		);
		final EList<? extends EObject> Expr_547_list = InclusiveOrExpression_547_Var
		.getExpr();
		Assert.assertNotNull(Expr_547_list);
		Assert.assertEquals(1, Expr_547_list.size());
		//547
		final ExclusiveOrExpression ExclusiveOrExpression_548_Var
		 = (ExclusiveOrExpression)Expr_547_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_548_Var
		);
		final EList<? extends EObject> Expr_548_list = ExclusiveOrExpression_548_Var
		.getExpr();
		Assert.assertNotNull(Expr_548_list);
		Assert.assertEquals(1, Expr_548_list.size());
		//548
		final AndExpression AndExpression_549_Var
		 = (AndExpression)Expr_548_list.get(0);
		Assert.assertNotNull(AndExpression_549_Var
		);
		final EList<? extends EObject> Expr_549_list = AndExpression_549_Var
		.getExpr();
		Assert.assertNotNull(Expr_549_list);
		Assert.assertEquals(1, Expr_549_list.size());
		//549
		final EqualityExpression EqualityExpression_550_Var
		 = (EqualityExpression)Expr_549_list.get(0);
		Assert.assertNotNull(EqualityExpression_550_Var
		);
		final EList<? extends EObject> Expr_550_list = EqualityExpression_550_Var
		.getExpr();
		Assert.assertNotNull(Expr_550_list);
		Assert.assertEquals(1, Expr_550_list.size());
		//550
		final RelationalExpression RelationalExpression_551_Var
		 = (RelationalExpression)Expr_550_list.get(0);
		Assert.assertNotNull(RelationalExpression_551_Var
		);
		final EList<? extends EObject> Expr_551_list = RelationalExpression_551_Var
		.getExpr();
		Assert.assertNotNull(Expr_551_list);
		Assert.assertEquals(1, Expr_551_list.size());
		//551
		final ShiftExpression ShiftExpression_552_Var
		 = (ShiftExpression)Expr_551_list.get(0);
		Assert.assertNotNull(ShiftExpression_552_Var
		);
		final EList<? extends EObject> Expr_552_list = ShiftExpression_552_Var
		.getExpr();
		Assert.assertNotNull(Expr_552_list);
		Assert.assertEquals(1, Expr_552_list.size());
		//552
		final AdditiveExpression AdditiveExpression_553_Var
		 = (AdditiveExpression)Expr_552_list.get(0);
		Assert.assertNotNull(AdditiveExpression_553_Var
		);
		final EList<? extends EObject> Expr_553_list = AdditiveExpression_553_Var
		.getExpr();
		Assert.assertNotNull(Expr_553_list);
		Assert.assertEquals(1, Expr_553_list.size());
		//553
		final MultiplicativeExpression MultiplicativeExpression_554_Var
		 = (MultiplicativeExpression)Expr_553_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_554_Var
		);
		final EList<? extends EObject> Expr_554_list = MultiplicativeExpression_554_Var
		.getExpr();
		Assert.assertNotNull(Expr_554_list);
		Assert.assertEquals(1, Expr_554_list.size());
		//554
		final CastExpression CastExpression_555_Var
		 = (CastExpression)Expr_554_list.get(0);
		Assert.assertNotNull(CastExpression_555_Var
		);
		//555
		final UnaryExpression UnaryExpression_556_Var
		 = (UnaryExpression)CastExpression_555_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_556_Var
		);
		//556
		final PostfixExpression PostfixExpression_557_Var
		 = (PostfixExpression)UnaryExpression_556_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_557_Var
		);
		final EList<? extends EObject> Expr_557_list = PostfixExpression_557_Var
		.getExpr();
		Assert.assertNotNull(Expr_557_list);
		Assert.assertEquals(1, Expr_557_list.size());
		//557
		final PrimaryExpression PrimaryExpression_558_Var
		 = (PrimaryExpression)Expr_557_list.get(0);
		Assert.assertNotNull(PrimaryExpression_558_Var
		);
		//558
		final Constant Constant_559_Var
		 = (Constant)PrimaryExpression_558_Var
		.getConst();
		Assert.assertNotNull(Constant_559_Var
		);
		Assert.assertEquals("\"The %d. day of the week is my favourite!\\n\"", Constant_559_Var
		.getStr());
		//559
		final AssignmentExpression AssignmentExpression_560_Var
		 = (AssignmentExpression)Expr_542_list.get(1);
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
		Assert.assertEquals("iAmInLove", PrimaryExpression_575_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_524_Var
		.getSemi());
		//575
		final Statement Statement_576_Var
		 = (Statement)Statement_286_list.get(6);
		Assert.assertNotNull(Statement_576_Var
		);
		//576
		final ExpressionStatement ExpressionStatement_577_Var
		 = (ExpressionStatement)Statement_576_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_577_Var
		);
		//577
		final Expression Expression_578_Var
		 = (Expression)ExpressionStatement_577_Var
		.getExpression();
		Assert.assertNotNull(Expression_578_Var
		);
		final EList<? extends EObject> ExprExpr_578_list = Expression_578_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_578_list);
		Assert.assertEquals(1, ExprExpr_578_list.size());
		//578
		final AssignmentExpression AssignmentExpression_579_Var
		 = (AssignmentExpression)ExprExpr_578_list.get(0);
		Assert.assertNotNull(AssignmentExpression_579_Var
		);
		//579
		final ConditionalExpression ConditionalExpression_580_Var
		 = (ConditionalExpression)AssignmentExpression_579_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_580_Var
		);
		//580
		final LogicalOrExpression LogicalOrExpression_581_Var
		 = (LogicalOrExpression)ConditionalExpression_580_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_581_Var
		);
		final EList<? extends EObject> Expr_581_list = LogicalOrExpression_581_Var
		.getExpr();
		Assert.assertNotNull(Expr_581_list);
		Assert.assertEquals(1, Expr_581_list.size());
		//581
		final LogicalAndExpression LogicalAndExpression_582_Var
		 = (LogicalAndExpression)Expr_581_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_582_Var
		);
		final EList<? extends EObject> Expr_582_list = LogicalAndExpression_582_Var
		.getExpr();
		Assert.assertNotNull(Expr_582_list);
		Assert.assertEquals(1, Expr_582_list.size());
		//582
		final InclusiveOrExpression InclusiveOrExpression_583_Var
		 = (InclusiveOrExpression)Expr_582_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_583_Var
		);
		final EList<? extends EObject> Expr_583_list = InclusiveOrExpression_583_Var
		.getExpr();
		Assert.assertNotNull(Expr_583_list);
		Assert.assertEquals(1, Expr_583_list.size());
		//583
		final ExclusiveOrExpression ExclusiveOrExpression_584_Var
		 = (ExclusiveOrExpression)Expr_583_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_584_Var
		);
		final EList<? extends EObject> Expr_584_list = ExclusiveOrExpression_584_Var
		.getExpr();
		Assert.assertNotNull(Expr_584_list);
		Assert.assertEquals(1, Expr_584_list.size());
		//584
		final AndExpression AndExpression_585_Var
		 = (AndExpression)Expr_584_list.get(0);
		Assert.assertNotNull(AndExpression_585_Var
		);
		final EList<? extends EObject> Expr_585_list = AndExpression_585_Var
		.getExpr();
		Assert.assertNotNull(Expr_585_list);
		Assert.assertEquals(1, Expr_585_list.size());
		//585
		final EqualityExpression EqualityExpression_586_Var
		 = (EqualityExpression)Expr_585_list.get(0);
		Assert.assertNotNull(EqualityExpression_586_Var
		);
		final EList<? extends EObject> Expr_586_list = EqualityExpression_586_Var
		.getExpr();
		Assert.assertNotNull(Expr_586_list);
		Assert.assertEquals(1, Expr_586_list.size());
		//586
		final RelationalExpression RelationalExpression_587_Var
		 = (RelationalExpression)Expr_586_list.get(0);
		Assert.assertNotNull(RelationalExpression_587_Var
		);
		final EList<? extends EObject> Expr_587_list = RelationalExpression_587_Var
		.getExpr();
		Assert.assertNotNull(Expr_587_list);
		Assert.assertEquals(1, Expr_587_list.size());
		//587
		final ShiftExpression ShiftExpression_588_Var
		 = (ShiftExpression)Expr_587_list.get(0);
		Assert.assertNotNull(ShiftExpression_588_Var
		);
		final EList<? extends EObject> Expr_588_list = ShiftExpression_588_Var
		.getExpr();
		Assert.assertNotNull(Expr_588_list);
		Assert.assertEquals(1, Expr_588_list.size());
		//588
		final AdditiveExpression AdditiveExpression_589_Var
		 = (AdditiveExpression)Expr_588_list.get(0);
		Assert.assertNotNull(AdditiveExpression_589_Var
		);
		final EList<? extends EObject> Expr_589_list = AdditiveExpression_589_Var
		.getExpr();
		Assert.assertNotNull(Expr_589_list);
		Assert.assertEquals(1, Expr_589_list.size());
		//589
		final MultiplicativeExpression MultiplicativeExpression_590_Var
		 = (MultiplicativeExpression)Expr_589_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_590_Var
		);
		final EList<? extends EObject> Expr_590_list = MultiplicativeExpression_590_Var
		.getExpr();
		Assert.assertNotNull(Expr_590_list);
		Assert.assertEquals(1, Expr_590_list.size());
		//590
		final CastExpression CastExpression_591_Var
		 = (CastExpression)Expr_590_list.get(0);
		Assert.assertNotNull(CastExpression_591_Var
		);
		//591
		final UnaryExpression UnaryExpression_592_Var
		 = (UnaryExpression)CastExpression_591_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_592_Var
		);
		//592
		final PostfixExpression PostfixExpression_593_Var
		 = (PostfixExpression)UnaryExpression_592_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_593_Var
		);
		final EList<? extends EObject> Expr_593_list = PostfixExpression_593_Var
		.getExpr();
		Assert.assertNotNull(Expr_593_list);
		Assert.assertEquals(1, Expr_593_list.size());
		//593
		final PrimaryExpression PrimaryExpression_594_Var
		 = (PrimaryExpression)Expr_593_list.get(0);
		Assert.assertNotNull(PrimaryExpression_594_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_594_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_594_list = PostfixExpression_593_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_594_list);
		Assert.assertEquals(1, ArgumentExpressionList_594_list.size());
		//594
		final ArgumentExpressionList ArgumentExpressionList_595_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_594_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_595_Var
		);
		final EList<? extends EObject> Expr_595_list = ArgumentExpressionList_595_Var
		.getExpr();
		Assert.assertNotNull(Expr_595_list);
		Assert.assertEquals(2, Expr_595_list.size());
		//595
		final AssignmentExpression AssignmentExpression_596_Var
		 = (AssignmentExpression)Expr_595_list.get(0);
		Assert.assertNotNull(AssignmentExpression_596_Var
		);
		//596
		final ConditionalExpression ConditionalExpression_597_Var
		 = (ConditionalExpression)AssignmentExpression_596_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_597_Var
		);
		//597
		final LogicalOrExpression LogicalOrExpression_598_Var
		 = (LogicalOrExpression)ConditionalExpression_597_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_598_Var
		);
		final EList<? extends EObject> Expr_598_list = LogicalOrExpression_598_Var
		.getExpr();
		Assert.assertNotNull(Expr_598_list);
		Assert.assertEquals(1, Expr_598_list.size());
		//598
		final LogicalAndExpression LogicalAndExpression_599_Var
		 = (LogicalAndExpression)Expr_598_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_599_Var
		);
		final EList<? extends EObject> Expr_599_list = LogicalAndExpression_599_Var
		.getExpr();
		Assert.assertNotNull(Expr_599_list);
		Assert.assertEquals(1, Expr_599_list.size());
		//599
		final InclusiveOrExpression InclusiveOrExpression_600_Var
		 = (InclusiveOrExpression)Expr_599_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_600_Var
		);
		final EList<? extends EObject> Expr_600_list = InclusiveOrExpression_600_Var
		.getExpr();
		Assert.assertNotNull(Expr_600_list);
		Assert.assertEquals(1, Expr_600_list.size());
		//600
		final ExclusiveOrExpression ExclusiveOrExpression_601_Var
		 = (ExclusiveOrExpression)Expr_600_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_601_Var
		);
		final EList<? extends EObject> Expr_601_list = ExclusiveOrExpression_601_Var
		.getExpr();
		Assert.assertNotNull(Expr_601_list);
		Assert.assertEquals(1, Expr_601_list.size());
		//601
		final AndExpression AndExpression_602_Var
		 = (AndExpression)Expr_601_list.get(0);
		Assert.assertNotNull(AndExpression_602_Var
		);
		final EList<? extends EObject> Expr_602_list = AndExpression_602_Var
		.getExpr();
		Assert.assertNotNull(Expr_602_list);
		Assert.assertEquals(1, Expr_602_list.size());
		//602
		final EqualityExpression EqualityExpression_603_Var
		 = (EqualityExpression)Expr_602_list.get(0);
		Assert.assertNotNull(EqualityExpression_603_Var
		);
		final EList<? extends EObject> Expr_603_list = EqualityExpression_603_Var
		.getExpr();
		Assert.assertNotNull(Expr_603_list);
		Assert.assertEquals(1, Expr_603_list.size());
		//603
		final RelationalExpression RelationalExpression_604_Var
		 = (RelationalExpression)Expr_603_list.get(0);
		Assert.assertNotNull(RelationalExpression_604_Var
		);
		final EList<? extends EObject> Expr_604_list = RelationalExpression_604_Var
		.getExpr();
		Assert.assertNotNull(Expr_604_list);
		Assert.assertEquals(1, Expr_604_list.size());
		//604
		final ShiftExpression ShiftExpression_605_Var
		 = (ShiftExpression)Expr_604_list.get(0);
		Assert.assertNotNull(ShiftExpression_605_Var
		);
		final EList<? extends EObject> Expr_605_list = ShiftExpression_605_Var
		.getExpr();
		Assert.assertNotNull(Expr_605_list);
		Assert.assertEquals(1, Expr_605_list.size());
		//605
		final AdditiveExpression AdditiveExpression_606_Var
		 = (AdditiveExpression)Expr_605_list.get(0);
		Assert.assertNotNull(AdditiveExpression_606_Var
		);
		final EList<? extends EObject> Expr_606_list = AdditiveExpression_606_Var
		.getExpr();
		Assert.assertNotNull(Expr_606_list);
		Assert.assertEquals(1, Expr_606_list.size());
		//606
		final MultiplicativeExpression MultiplicativeExpression_607_Var
		 = (MultiplicativeExpression)Expr_606_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_607_Var
		);
		final EList<? extends EObject> Expr_607_list = MultiplicativeExpression_607_Var
		.getExpr();
		Assert.assertNotNull(Expr_607_list);
		Assert.assertEquals(1, Expr_607_list.size());
		//607
		final CastExpression CastExpression_608_Var
		 = (CastExpression)Expr_607_list.get(0);
		Assert.assertNotNull(CastExpression_608_Var
		);
		//608
		final UnaryExpression UnaryExpression_609_Var
		 = (UnaryExpression)CastExpression_608_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_609_Var
		);
		//609
		final PostfixExpression PostfixExpression_610_Var
		 = (PostfixExpression)UnaryExpression_609_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_610_Var
		);
		final EList<? extends EObject> Expr_610_list = PostfixExpression_610_Var
		.getExpr();
		Assert.assertNotNull(Expr_610_list);
		Assert.assertEquals(1, Expr_610_list.size());
		//610
		final PrimaryExpression PrimaryExpression_611_Var
		 = (PrimaryExpression)Expr_610_list.get(0);
		Assert.assertNotNull(PrimaryExpression_611_Var
		);
		//611
		final Constant Constant_612_Var
		 = (Constant)PrimaryExpression_611_Var
		.getConst();
		Assert.assertNotNull(Constant_612_Var
		);
		Assert.assertEquals("\"The %d. day of the week is my favourite!\\n\"", Constant_612_Var
		.getStr());
		//612
		final AssignmentExpression AssignmentExpression_613_Var
		 = (AssignmentExpression)Expr_595_list.get(1);
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
		Assert.assertEquals("my_weekday", PrimaryExpression_628_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_577_Var
		.getSemi());
		//628
		final Statement Statement_629_Var
		 = (Statement)Statement_286_list.get(7);
		Assert.assertNotNull(Statement_629_Var
		);
		//629
		final JumpStatement JumpStatement_630_Var
		 = (JumpStatement)Statement_629_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_630_Var
		);
		//630
		final Expression Expression_631_Var
		 = (Expression)JumpStatement_630_Var
		.getExpr();
		Assert.assertNotNull(Expression_631_Var
		);
		final EList<? extends EObject> ExprExpr_631_list = Expression_631_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_631_list);
		Assert.assertEquals(1, ExprExpr_631_list.size());
		//631
		final AssignmentExpression AssignmentExpression_632_Var
		 = (AssignmentExpression)ExprExpr_631_list.get(0);
		Assert.assertNotNull(AssignmentExpression_632_Var
		);
		//632
		final ConditionalExpression ConditionalExpression_633_Var
		 = (ConditionalExpression)AssignmentExpression_632_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_633_Var
		);
		//633
		final LogicalOrExpression LogicalOrExpression_634_Var
		 = (LogicalOrExpression)ConditionalExpression_633_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_634_Var
		);
		final EList<? extends EObject> Expr_634_list = LogicalOrExpression_634_Var
		.getExpr();
		Assert.assertNotNull(Expr_634_list);
		Assert.assertEquals(1, Expr_634_list.size());
		//634
		final LogicalAndExpression LogicalAndExpression_635_Var
		 = (LogicalAndExpression)Expr_634_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_635_Var
		);
		final EList<? extends EObject> Expr_635_list = LogicalAndExpression_635_Var
		.getExpr();
		Assert.assertNotNull(Expr_635_list);
		Assert.assertEquals(1, Expr_635_list.size());
		//635
		final InclusiveOrExpression InclusiveOrExpression_636_Var
		 = (InclusiveOrExpression)Expr_635_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_636_Var
		);
		final EList<? extends EObject> Expr_636_list = InclusiveOrExpression_636_Var
		.getExpr();
		Assert.assertNotNull(Expr_636_list);
		Assert.assertEquals(1, Expr_636_list.size());
		//636
		final ExclusiveOrExpression ExclusiveOrExpression_637_Var
		 = (ExclusiveOrExpression)Expr_636_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_637_Var
		);
		final EList<? extends EObject> Expr_637_list = ExclusiveOrExpression_637_Var
		.getExpr();
		Assert.assertNotNull(Expr_637_list);
		Assert.assertEquals(1, Expr_637_list.size());
		//637
		final AndExpression AndExpression_638_Var
		 = (AndExpression)Expr_637_list.get(0);
		Assert.assertNotNull(AndExpression_638_Var
		);
		final EList<? extends EObject> Expr_638_list = AndExpression_638_Var
		.getExpr();
		Assert.assertNotNull(Expr_638_list);
		Assert.assertEquals(1, Expr_638_list.size());
		//638
		final EqualityExpression EqualityExpression_639_Var
		 = (EqualityExpression)Expr_638_list.get(0);
		Assert.assertNotNull(EqualityExpression_639_Var
		);
		final EList<? extends EObject> Expr_639_list = EqualityExpression_639_Var
		.getExpr();
		Assert.assertNotNull(Expr_639_list);
		Assert.assertEquals(1, Expr_639_list.size());
		//639
		final RelationalExpression RelationalExpression_640_Var
		 = (RelationalExpression)Expr_639_list.get(0);
		Assert.assertNotNull(RelationalExpression_640_Var
		);
		final EList<? extends EObject> Expr_640_list = RelationalExpression_640_Var
		.getExpr();
		Assert.assertNotNull(Expr_640_list);
		Assert.assertEquals(1, Expr_640_list.size());
		//640
		final ShiftExpression ShiftExpression_641_Var
		 = (ShiftExpression)Expr_640_list.get(0);
		Assert.assertNotNull(ShiftExpression_641_Var
		);
		final EList<? extends EObject> Expr_641_list = ShiftExpression_641_Var
		.getExpr();
		Assert.assertNotNull(Expr_641_list);
		Assert.assertEquals(1, Expr_641_list.size());
		//641
		final AdditiveExpression AdditiveExpression_642_Var
		 = (AdditiveExpression)Expr_641_list.get(0);
		Assert.assertNotNull(AdditiveExpression_642_Var
		);
		final EList<? extends EObject> Expr_642_list = AdditiveExpression_642_Var
		.getExpr();
		Assert.assertNotNull(Expr_642_list);
		Assert.assertEquals(1, Expr_642_list.size());
		//642
		final MultiplicativeExpression MultiplicativeExpression_643_Var
		 = (MultiplicativeExpression)Expr_642_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_643_Var
		);
		final EList<? extends EObject> Expr_643_list = MultiplicativeExpression_643_Var
		.getExpr();
		Assert.assertNotNull(Expr_643_list);
		Assert.assertEquals(1, Expr_643_list.size());
		//643
		final CastExpression CastExpression_644_Var
		 = (CastExpression)Expr_643_list.get(0);
		Assert.assertNotNull(CastExpression_644_Var
		);
		//644
		final UnaryExpression UnaryExpression_645_Var
		 = (UnaryExpression)CastExpression_644_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_645_Var
		);
		//645
		final PostfixExpression PostfixExpression_646_Var
		 = (PostfixExpression)UnaryExpression_645_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_646_Var
		);
		final EList<? extends EObject> Expr_646_list = PostfixExpression_646_Var
		.getExpr();
		Assert.assertNotNull(Expr_646_list);
		Assert.assertEquals(1, Expr_646_list.size());
		//646
		final PrimaryExpression PrimaryExpression_647_Var
		 = (PrimaryExpression)Expr_646_list.get(0);
		Assert.assertNotNull(PrimaryExpression_647_Var
		);
		//647
		final Constant Constant_648_Var
		 = (Constant)PrimaryExpression_647_Var
		.getConst();
		Assert.assertNotNull(Constant_648_Var
		);
		Assert.assertEquals("0", Constant_648_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_630_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_630_Var
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
			"res/Test0031_Enums.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
		// System.out.println("Code generation finished.");
	}
	
}


