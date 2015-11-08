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
		final EList<? extends EObject> ArgumentExpressionList_113_list = PostfixExpression_112_Var
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
		Assert.assertEquals(2, Expr_114_list.size());
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
		//130
		final Constant Constant_131_Var
		 = (Constant)PrimaryExpression_130_Var
		.getConst();
		Assert.assertNotNull(Constant_131_Var
		);
		Assert.assertEquals("\"sizeof(number)=%lu\\n\"", Constant_131_Var
		.getStr());
		//131
		final AssignmentExpression AssignmentExpression_132_Var
		 = (AssignmentExpression)Expr_114_list.get(1);
		Assert.assertNotNull(AssignmentExpression_132_Var
		);
		//132
		final ConditionalExpression ConditionalExpression_133_Var
		 = (ConditionalExpression)AssignmentExpression_132_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_133_Var
		);
		//133
		final LogicalOrExpression LogicalOrExpression_134_Var
		 = (LogicalOrExpression)ConditionalExpression_133_Var
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
		Assert.assertEquals("size", PrimaryExpression_147_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_96_Var
		.getSemi());
		//147
		final Statement Statement_148_Var
		 = (Statement)Statement_94_list.get(1);
		Assert.assertNotNull(Statement_148_Var
		);
		//148
		final ExpressionStatement ExpressionStatement_149_Var
		 = (ExpressionStatement)Statement_148_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_149_Var
		);
		//149
		final Expression Expression_150_Var
		 = (Expression)ExpressionStatement_149_Var
		.getExpression();
		Assert.assertNotNull(Expression_150_Var
		);
		final EList<? extends EObject> ExprExpr_150_list = Expression_150_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_150_list);
		Assert.assertEquals(1, ExprExpr_150_list.size());
		//150
		final AssignmentExpression AssignmentExpression_151_Var
		 = (AssignmentExpression)ExprExpr_150_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_166_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_166_list = PostfixExpression_165_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_166_list);
		Assert.assertEquals(1, ArgumentExpressionList_166_list.size());
		//166
		final ArgumentExpressionList ArgumentExpressionList_167_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_166_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_167_Var
		);
		final EList<? extends EObject> Expr_167_list = ArgumentExpressionList_167_Var
		.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(2, Expr_167_list.size());
		//167
		final AssignmentExpression AssignmentExpression_168_Var
		 = (AssignmentExpression)Expr_167_list.get(0);
		Assert.assertNotNull(AssignmentExpression_168_Var
		);
		//168
		final ConditionalExpression ConditionalExpression_169_Var
		 = (ConditionalExpression)AssignmentExpression_168_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_169_Var
		);
		//169
		final LogicalOrExpression LogicalOrExpression_170_Var
		 = (LogicalOrExpression)ConditionalExpression_169_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_170_Var
		);
		final EList<? extends EObject> Expr_170_list = LogicalOrExpression_170_Var
		.getExpr();
		Assert.assertNotNull(Expr_170_list);
		Assert.assertEquals(1, Expr_170_list.size());
		//170
		final LogicalAndExpression LogicalAndExpression_171_Var
		 = (LogicalAndExpression)Expr_170_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_171_Var
		);
		final EList<? extends EObject> Expr_171_list = LogicalAndExpression_171_Var
		.getExpr();
		Assert.assertNotNull(Expr_171_list);
		Assert.assertEquals(1, Expr_171_list.size());
		//171
		final InclusiveOrExpression InclusiveOrExpression_172_Var
		 = (InclusiveOrExpression)Expr_171_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = InclusiveOrExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final ExclusiveOrExpression ExclusiveOrExpression_173_Var
		 = (ExclusiveOrExpression)Expr_172_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_173_Var
		);
		final EList<? extends EObject> Expr_173_list = ExclusiveOrExpression_173_Var
		.getExpr();
		Assert.assertNotNull(Expr_173_list);
		Assert.assertEquals(1, Expr_173_list.size());
		//173
		final AndExpression AndExpression_174_Var
		 = (AndExpression)Expr_173_list.get(0);
		Assert.assertNotNull(AndExpression_174_Var
		);
		final EList<? extends EObject> Expr_174_list = AndExpression_174_Var
		.getExpr();
		Assert.assertNotNull(Expr_174_list);
		Assert.assertEquals(1, Expr_174_list.size());
		//174
		final EqualityExpression EqualityExpression_175_Var
		 = (EqualityExpression)Expr_174_list.get(0);
		Assert.assertNotNull(EqualityExpression_175_Var
		);
		final EList<? extends EObject> Expr_175_list = EqualityExpression_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final RelationalExpression RelationalExpression_176_Var
		 = (RelationalExpression)Expr_175_list.get(0);
		Assert.assertNotNull(RelationalExpression_176_Var
		);
		final EList<? extends EObject> Expr_176_list = RelationalExpression_176_Var
		.getExpr();
		Assert.assertNotNull(Expr_176_list);
		Assert.assertEquals(1, Expr_176_list.size());
		//176
		final ShiftExpression ShiftExpression_177_Var
		 = (ShiftExpression)Expr_176_list.get(0);
		Assert.assertNotNull(ShiftExpression_177_Var
		);
		final EList<? extends EObject> Expr_177_list = ShiftExpression_177_Var
		.getExpr();
		Assert.assertNotNull(Expr_177_list);
		Assert.assertEquals(1, Expr_177_list.size());
		//177
		final AdditiveExpression AdditiveExpression_178_Var
		 = (AdditiveExpression)Expr_177_list.get(0);
		Assert.assertNotNull(AdditiveExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = AdditiveExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final MultiplicativeExpression MultiplicativeExpression_179_Var
		 = (MultiplicativeExpression)Expr_178_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = MultiplicativeExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final CastExpression CastExpression_180_Var
		 = (CastExpression)Expr_179_list.get(0);
		Assert.assertNotNull(CastExpression_180_Var
		);
		//180
		final UnaryExpression UnaryExpression_181_Var
		 = (UnaryExpression)CastExpression_180_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_181_Var
		);
		//181
		final PostfixExpression PostfixExpression_182_Var
		 = (PostfixExpression)UnaryExpression_181_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_182_Var
		);
		final EList<? extends EObject> Expr_182_list = PostfixExpression_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(1, Expr_182_list.size());
		//182
		final PrimaryExpression PrimaryExpression_183_Var
		 = (PrimaryExpression)Expr_182_list.get(0);
		Assert.assertNotNull(PrimaryExpression_183_Var
		);
		//183
		final Constant Constant_184_Var
		 = (Constant)PrimaryExpression_183_Var
		.getConst();
		Assert.assertNotNull(Constant_184_Var
		);
		Assert.assertEquals("\"sizeof(number.numChar)=%lu\\n\"", Constant_184_Var
		.getStr());
		//184
		final AssignmentExpression AssignmentExpression_185_Var
		 = (AssignmentExpression)Expr_167_list.get(1);
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
		Assert.assertEquals("sizeof", UnaryExpression_198_Var
		.getSizeOf());
		//198
		final UnaryExpression UnaryExpression_199_Var
		 = (UnaryExpression)UnaryExpression_198_Var
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
		//201
		final Expression Expression_202_Var
		 = (Expression)PrimaryExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expression_202_Var
		);
		final EList<? extends EObject> ExprExpr_202_list = Expression_202_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_202_list);
		Assert.assertEquals(1, ExprExpr_202_list.size());
		//202
		final AssignmentExpression AssignmentExpression_203_Var
		 = (AssignmentExpression)ExprExpr_202_list.get(0);
		Assert.assertNotNull(AssignmentExpression_203_Var
		);
		//203
		final ConditionalExpression ConditionalExpression_204_Var
		 = (ConditionalExpression)AssignmentExpression_203_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_204_Var
		);
		//204
		final LogicalOrExpression LogicalOrExpression_205_Var
		 = (LogicalOrExpression)ConditionalExpression_204_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_205_Var
		);
		final EList<? extends EObject> Expr_205_list = LogicalOrExpression_205_Var
		.getExpr();
		Assert.assertNotNull(Expr_205_list);
		Assert.assertEquals(1, Expr_205_list.size());
		//205
		final LogicalAndExpression LogicalAndExpression_206_Var
		 = (LogicalAndExpression)Expr_205_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_206_Var
		);
		final EList<? extends EObject> Expr_206_list = LogicalAndExpression_206_Var
		.getExpr();
		Assert.assertNotNull(Expr_206_list);
		Assert.assertEquals(1, Expr_206_list.size());
		//206
		final InclusiveOrExpression InclusiveOrExpression_207_Var
		 = (InclusiveOrExpression)Expr_206_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_207_Var
		);
		final EList<? extends EObject> Expr_207_list = InclusiveOrExpression_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final ExclusiveOrExpression ExclusiveOrExpression_208_Var
		 = (ExclusiveOrExpression)Expr_207_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_208_Var
		);
		final EList<? extends EObject> Expr_208_list = ExclusiveOrExpression_208_Var
		.getExpr();
		Assert.assertNotNull(Expr_208_list);
		Assert.assertEquals(1, Expr_208_list.size());
		//208
		final AndExpression AndExpression_209_Var
		 = (AndExpression)Expr_208_list.get(0);
		Assert.assertNotNull(AndExpression_209_Var
		);
		final EList<? extends EObject> Expr_209_list = AndExpression_209_Var
		.getExpr();
		Assert.assertNotNull(Expr_209_list);
		Assert.assertEquals(1, Expr_209_list.size());
		//209
		final EqualityExpression EqualityExpression_210_Var
		 = (EqualityExpression)Expr_209_list.get(0);
		Assert.assertNotNull(EqualityExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = EqualityExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final RelationalExpression RelationalExpression_211_Var
		 = (RelationalExpression)Expr_210_list.get(0);
		Assert.assertNotNull(RelationalExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = RelationalExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final ShiftExpression ShiftExpression_212_Var
		 = (ShiftExpression)Expr_211_list.get(0);
		Assert.assertNotNull(ShiftExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = ShiftExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final AdditiveExpression AdditiveExpression_213_Var
		 = (AdditiveExpression)Expr_212_list.get(0);
		Assert.assertNotNull(AdditiveExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = AdditiveExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final MultiplicativeExpression MultiplicativeExpression_214_Var
		 = (MultiplicativeExpression)Expr_213_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = MultiplicativeExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final CastExpression CastExpression_215_Var
		 = (CastExpression)Expr_214_list.get(0);
		Assert.assertNotNull(CastExpression_215_Var
		);
		//215
		final UnaryExpression UnaryExpression_216_Var
		 = (UnaryExpression)CastExpression_215_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_216_Var
		);
		//216
		final PostfixExpression PostfixExpression_217_Var
		 = (PostfixExpression)UnaryExpression_216_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = PostfixExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final PrimaryExpression PrimaryExpression_218_Var
		 = (PrimaryExpression)Expr_217_list.get(0);
		Assert.assertNotNull(PrimaryExpression_218_Var
		);
		Assert.assertEquals("number", PrimaryExpression_218_Var
		.getId());
		Assert.assertEquals("[.]", PostfixExpression_217_Var
		.getDot().toString());
		Assert.assertEquals("[numChar]", PostfixExpression_217_Var
		.getId().toString());
		Assert.assertEquals(";", ExpressionStatement_149_Var
		.getSemi());
		//218
		final Statement Statement_219_Var
		 = (Statement)Statement_94_list.get(2);
		Assert.assertNotNull(Statement_219_Var
		);
		//219
		final ExpressionStatement ExpressionStatement_220_Var
		 = (ExpressionStatement)Statement_219_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_220_Var
		);
		//220
		final Expression Expression_221_Var
		 = (Expression)ExpressionStatement_220_Var
		.getExpression();
		Assert.assertNotNull(Expression_221_Var
		);
		final EList<? extends EObject> ExprExpr_221_list = Expression_221_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_221_list);
		Assert.assertEquals(1, ExprExpr_221_list.size());
		//221
		final AssignmentExpression AssignmentExpression_222_Var
		 = (AssignmentExpression)ExprExpr_221_list.get(0);
		Assert.assertNotNull(AssignmentExpression_222_Var
		);
		//222
		final ConditionalExpression ConditionalExpression_223_Var
		 = (ConditionalExpression)AssignmentExpression_222_Var
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
		Assert.assertEquals("printf", PrimaryExpression_237_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_237_list = PostfixExpression_236_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_237_list);
		Assert.assertEquals(1, ArgumentExpressionList_237_list.size());
		//237
		final ArgumentExpressionList ArgumentExpressionList_238_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_237_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_238_Var
		);
		final EList<? extends EObject> Expr_238_list = ArgumentExpressionList_238_Var
		.getExpr();
		Assert.assertNotNull(Expr_238_list);
		Assert.assertEquals(2, Expr_238_list.size());
		//238
		final AssignmentExpression AssignmentExpression_239_Var
		 = (AssignmentExpression)Expr_238_list.get(0);
		Assert.assertNotNull(AssignmentExpression_239_Var
		);
		//239
		final ConditionalExpression ConditionalExpression_240_Var
		 = (ConditionalExpression)AssignmentExpression_239_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_240_Var
		);
		//240
		final LogicalOrExpression LogicalOrExpression_241_Var
		 = (LogicalOrExpression)ConditionalExpression_240_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = LogicalOrExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final LogicalAndExpression LogicalAndExpression_242_Var
		 = (LogicalAndExpression)Expr_241_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = LogicalAndExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final InclusiveOrExpression InclusiveOrExpression_243_Var
		 = (InclusiveOrExpression)Expr_242_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = InclusiveOrExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final ExclusiveOrExpression ExclusiveOrExpression_244_Var
		 = (ExclusiveOrExpression)Expr_243_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = ExclusiveOrExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final AndExpression AndExpression_245_Var
		 = (AndExpression)Expr_244_list.get(0);
		Assert.assertNotNull(AndExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = AndExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final EqualityExpression EqualityExpression_246_Var
		 = (EqualityExpression)Expr_245_list.get(0);
		Assert.assertNotNull(EqualityExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = EqualityExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final RelationalExpression RelationalExpression_247_Var
		 = (RelationalExpression)Expr_246_list.get(0);
		Assert.assertNotNull(RelationalExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = RelationalExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final ShiftExpression ShiftExpression_248_Var
		 = (ShiftExpression)Expr_247_list.get(0);
		Assert.assertNotNull(ShiftExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = ShiftExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final AdditiveExpression AdditiveExpression_249_Var
		 = (AdditiveExpression)Expr_248_list.get(0);
		Assert.assertNotNull(AdditiveExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = AdditiveExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final MultiplicativeExpression MultiplicativeExpression_250_Var
		 = (MultiplicativeExpression)Expr_249_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_250_Var
		);
		final EList<? extends EObject> Expr_250_list = MultiplicativeExpression_250_Var
		.getExpr();
		Assert.assertNotNull(Expr_250_list);
		Assert.assertEquals(1, Expr_250_list.size());
		//250
		final CastExpression CastExpression_251_Var
		 = (CastExpression)Expr_250_list.get(0);
		Assert.assertNotNull(CastExpression_251_Var
		);
		//251
		final UnaryExpression UnaryExpression_252_Var
		 = (UnaryExpression)CastExpression_251_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_252_Var
		);
		//252
		final PostfixExpression PostfixExpression_253_Var
		 = (PostfixExpression)UnaryExpression_252_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_253_Var
		);
		final EList<? extends EObject> Expr_253_list = PostfixExpression_253_Var
		.getExpr();
		Assert.assertNotNull(Expr_253_list);
		Assert.assertEquals(1, Expr_253_list.size());
		//253
		final PrimaryExpression PrimaryExpression_254_Var
		 = (PrimaryExpression)Expr_253_list.get(0);
		Assert.assertNotNull(PrimaryExpression_254_Var
		);
		//254
		final Constant Constant_255_Var
		 = (Constant)PrimaryExpression_254_Var
		.getConst();
		Assert.assertNotNull(Constant_255_Var
		);
		Assert.assertEquals("\"sizeof(float)=%lu\\n\"", Constant_255_Var
		.getStr());
		//255
		final AssignmentExpression AssignmentExpression_256_Var
		 = (AssignmentExpression)Expr_238_list.get(1);
		Assert.assertNotNull(AssignmentExpression_256_Var
		);
		//256
		final ConditionalExpression ConditionalExpression_257_Var
		 = (ConditionalExpression)AssignmentExpression_256_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_257_Var
		);
		//257
		final LogicalOrExpression LogicalOrExpression_258_Var
		 = (LogicalOrExpression)ConditionalExpression_257_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_258_Var
		);
		final EList<? extends EObject> Expr_258_list = LogicalOrExpression_258_Var
		.getExpr();
		Assert.assertNotNull(Expr_258_list);
		Assert.assertEquals(1, Expr_258_list.size());
		//258
		final LogicalAndExpression LogicalAndExpression_259_Var
		 = (LogicalAndExpression)Expr_258_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_259_Var
		);
		final EList<? extends EObject> Expr_259_list = LogicalAndExpression_259_Var
		.getExpr();
		Assert.assertNotNull(Expr_259_list);
		Assert.assertEquals(1, Expr_259_list.size());
		//259
		final InclusiveOrExpression InclusiveOrExpression_260_Var
		 = (InclusiveOrExpression)Expr_259_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = InclusiveOrExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final ExclusiveOrExpression ExclusiveOrExpression_261_Var
		 = (ExclusiveOrExpression)Expr_260_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = ExclusiveOrExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(1, Expr_261_list.size());
		//261
		final AndExpression AndExpression_262_Var
		 = (AndExpression)Expr_261_list.get(0);
		Assert.assertNotNull(AndExpression_262_Var
		);
		final EList<? extends EObject> Expr_262_list = AndExpression_262_Var
		.getExpr();
		Assert.assertNotNull(Expr_262_list);
		Assert.assertEquals(1, Expr_262_list.size());
		//262
		final EqualityExpression EqualityExpression_263_Var
		 = (EqualityExpression)Expr_262_list.get(0);
		Assert.assertNotNull(EqualityExpression_263_Var
		);
		final EList<? extends EObject> Expr_263_list = EqualityExpression_263_Var
		.getExpr();
		Assert.assertNotNull(Expr_263_list);
		Assert.assertEquals(1, Expr_263_list.size());
		//263
		final RelationalExpression RelationalExpression_264_Var
		 = (RelationalExpression)Expr_263_list.get(0);
		Assert.assertNotNull(RelationalExpression_264_Var
		);
		final EList<? extends EObject> Expr_264_list = RelationalExpression_264_Var
		.getExpr();
		Assert.assertNotNull(Expr_264_list);
		Assert.assertEquals(1, Expr_264_list.size());
		//264
		final ShiftExpression ShiftExpression_265_Var
		 = (ShiftExpression)Expr_264_list.get(0);
		Assert.assertNotNull(ShiftExpression_265_Var
		);
		final EList<? extends EObject> Expr_265_list = ShiftExpression_265_Var
		.getExpr();
		Assert.assertNotNull(Expr_265_list);
		Assert.assertEquals(1, Expr_265_list.size());
		//265
		final AdditiveExpression AdditiveExpression_266_Var
		 = (AdditiveExpression)Expr_265_list.get(0);
		Assert.assertNotNull(AdditiveExpression_266_Var
		);
		final EList<? extends EObject> Expr_266_list = AdditiveExpression_266_Var
		.getExpr();
		Assert.assertNotNull(Expr_266_list);
		Assert.assertEquals(1, Expr_266_list.size());
		//266
		final MultiplicativeExpression MultiplicativeExpression_267_Var
		 = (MultiplicativeExpression)Expr_266_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_267_Var
		);
		final EList<? extends EObject> Expr_267_list = MultiplicativeExpression_267_Var
		.getExpr();
		Assert.assertNotNull(Expr_267_list);
		Assert.assertEquals(1, Expr_267_list.size());
		//267
		final CastExpression CastExpression_268_Var
		 = (CastExpression)Expr_267_list.get(0);
		Assert.assertNotNull(CastExpression_268_Var
		);
		//268
		final UnaryExpression UnaryExpression_269_Var
		 = (UnaryExpression)CastExpression_268_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_269_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_269_Var
		.getSizeOf());
		//269
		final TypeName TypeName_270_Var
		 = (TypeName)UnaryExpression_269_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_270_Var
		);
		//270
		final SpecifierQualifierList SpecifierQualifierList_271_Var
		 = (SpecifierQualifierList)TypeName_270_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_271_Var
		);
		final EList<? extends EObject> TypeSpecifier_271_list = SpecifierQualifierList_271_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_271_list);
		Assert.assertEquals(1, TypeSpecifier_271_list.size());
		//271
		final TypeSpecifier TypeSpecifier_272_Var
		 = (TypeSpecifier)TypeSpecifier_271_list.get(0);
		Assert.assertNotNull(TypeSpecifier_272_Var
		);
		Assert.assertEquals("float", TypeSpecifier_272_Var
		.getName());
		Assert.assertEquals(";", ExpressionStatement_220_Var
		.getSemi());
		//272
		final Statement Statement_273_Var
		 = (Statement)Statement_94_list.get(3);
		Assert.assertNotNull(Statement_273_Var
		);
		//273
		final ExpressionStatement ExpressionStatement_274_Var
		 = (ExpressionStatement)Statement_273_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_274_Var
		);
		//274
		final Expression Expression_275_Var
		 = (Expression)ExpressionStatement_274_Var
		.getExpression();
		Assert.assertNotNull(Expression_275_Var
		);
		final EList<? extends EObject> ExprExpr_275_list = Expression_275_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_275_list);
		Assert.assertEquals(1, ExprExpr_275_list.size());
		//275
		final AssignmentExpression AssignmentExpression_276_Var
		 = (AssignmentExpression)ExprExpr_275_list.get(0);
		Assert.assertNotNull(AssignmentExpression_276_Var
		);
		//276
		final UnaryExpression UnaryExpression_277_Var
		 = (UnaryExpression)AssignmentExpression_276_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_277_Var
		);
		//277
		final PostfixExpression PostfixExpression_278_Var
		 = (PostfixExpression)UnaryExpression_277_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_278_Var
		);
		final EList<? extends EObject> Expr_278_list = PostfixExpression_278_Var
		.getExpr();
		Assert.assertNotNull(Expr_278_list);
		Assert.assertEquals(1, Expr_278_list.size());
		//278
		final PrimaryExpression PrimaryExpression_279_Var
		 = (PrimaryExpression)Expr_278_list.get(0);
		Assert.assertNotNull(PrimaryExpression_279_Var
		);
		Assert.assertEquals("number", PrimaryExpression_279_Var
		.getId());
		Assert.assertEquals("[.]", PostfixExpression_278_Var
		.getDot().toString());
		Assert.assertEquals("[numChar]", PostfixExpression_278_Var
		.getId().toString());
		//279
		final AssignmentOperator AssignmentOperator_280_Var
		 = (AssignmentOperator)AssignmentExpression_276_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_280_Var
		);
		Assert.assertEquals("=", AssignmentOperator_280_Var
		.getOp());
		//280
		final AssignmentExpression AssignmentExpression_281_Var
		 = (AssignmentExpression)AssignmentExpression_276_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_281_Var
		);
		//281
		final ConditionalExpression ConditionalExpression_282_Var
		 = (ConditionalExpression)AssignmentExpression_281_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_282_Var
		);
		//282
		final LogicalOrExpression LogicalOrExpression_283_Var
		 = (LogicalOrExpression)ConditionalExpression_282_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_283_Var
		);
		final EList<? extends EObject> Expr_283_list = LogicalOrExpression_283_Var
		.getExpr();
		Assert.assertNotNull(Expr_283_list);
		Assert.assertEquals(1, Expr_283_list.size());
		//283
		final LogicalAndExpression LogicalAndExpression_284_Var
		 = (LogicalAndExpression)Expr_283_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_284_Var
		);
		final EList<? extends EObject> Expr_284_list = LogicalAndExpression_284_Var
		.getExpr();
		Assert.assertNotNull(Expr_284_list);
		Assert.assertEquals(1, Expr_284_list.size());
		//284
		final InclusiveOrExpression InclusiveOrExpression_285_Var
		 = (InclusiveOrExpression)Expr_284_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_285_Var
		);
		final EList<? extends EObject> Expr_285_list = InclusiveOrExpression_285_Var
		.getExpr();
		Assert.assertNotNull(Expr_285_list);
		Assert.assertEquals(1, Expr_285_list.size());
		//285
		final ExclusiveOrExpression ExclusiveOrExpression_286_Var
		 = (ExclusiveOrExpression)Expr_285_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_286_Var
		);
		final EList<? extends EObject> Expr_286_list = ExclusiveOrExpression_286_Var
		.getExpr();
		Assert.assertNotNull(Expr_286_list);
		Assert.assertEquals(1, Expr_286_list.size());
		//286
		final AndExpression AndExpression_287_Var
		 = (AndExpression)Expr_286_list.get(0);
		Assert.assertNotNull(AndExpression_287_Var
		);
		final EList<? extends EObject> Expr_287_list = AndExpression_287_Var
		.getExpr();
		Assert.assertNotNull(Expr_287_list);
		Assert.assertEquals(1, Expr_287_list.size());
		//287
		final EqualityExpression EqualityExpression_288_Var
		 = (EqualityExpression)Expr_287_list.get(0);
		Assert.assertNotNull(EqualityExpression_288_Var
		);
		final EList<? extends EObject> Expr_288_list = EqualityExpression_288_Var
		.getExpr();
		Assert.assertNotNull(Expr_288_list);
		Assert.assertEquals(1, Expr_288_list.size());
		//288
		final RelationalExpression RelationalExpression_289_Var
		 = (RelationalExpression)Expr_288_list.get(0);
		Assert.assertNotNull(RelationalExpression_289_Var
		);
		final EList<? extends EObject> Expr_289_list = RelationalExpression_289_Var
		.getExpr();
		Assert.assertNotNull(Expr_289_list);
		Assert.assertEquals(1, Expr_289_list.size());
		//289
		final ShiftExpression ShiftExpression_290_Var
		 = (ShiftExpression)Expr_289_list.get(0);
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
		//296
		final Constant Constant_297_Var
		 = (Constant)PrimaryExpression_296_Var
		.getConst();
		Assert.assertNotNull(Constant_297_Var
		);
		Assert.assertEquals("65", Constant_297_Var
		.getDec());
		Assert.assertEquals(";", ExpressionStatement_274_Var
		.getSemi());
		//297
		final Statement Statement_298_Var
		 = (Statement)Statement_94_list.get(4);
		Assert.assertNotNull(Statement_298_Var
		);
		//298
		final ExpressionStatement ExpressionStatement_299_Var
		 = (ExpressionStatement)Statement_298_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_299_Var
		);
		//299
		final Expression Expression_300_Var
		 = (Expression)ExpressionStatement_299_Var
		.getExpression();
		Assert.assertNotNull(Expression_300_Var
		);
		final EList<? extends EObject> ExprExpr_300_list = Expression_300_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_300_list);
		Assert.assertEquals(1, ExprExpr_300_list.size());
		//300
		final AssignmentExpression AssignmentExpression_301_Var
		 = (AssignmentExpression)ExprExpr_300_list.get(0);
		Assert.assertNotNull(AssignmentExpression_301_Var
		);
		//301
		final ConditionalExpression ConditionalExpression_302_Var
		 = (ConditionalExpression)AssignmentExpression_301_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_302_Var
		);
		//302
		final LogicalOrExpression LogicalOrExpression_303_Var
		 = (LogicalOrExpression)ConditionalExpression_302_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_303_Var
		);
		final EList<? extends EObject> Expr_303_list = LogicalOrExpression_303_Var
		.getExpr();
		Assert.assertNotNull(Expr_303_list);
		Assert.assertEquals(1, Expr_303_list.size());
		//303
		final LogicalAndExpression LogicalAndExpression_304_Var
		 = (LogicalAndExpression)Expr_303_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_304_Var
		);
		final EList<? extends EObject> Expr_304_list = LogicalAndExpression_304_Var
		.getExpr();
		Assert.assertNotNull(Expr_304_list);
		Assert.assertEquals(1, Expr_304_list.size());
		//304
		final InclusiveOrExpression InclusiveOrExpression_305_Var
		 = (InclusiveOrExpression)Expr_304_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_305_Var
		);
		final EList<? extends EObject> Expr_305_list = InclusiveOrExpression_305_Var
		.getExpr();
		Assert.assertNotNull(Expr_305_list);
		Assert.assertEquals(1, Expr_305_list.size());
		//305
		final ExclusiveOrExpression ExclusiveOrExpression_306_Var
		 = (ExclusiveOrExpression)Expr_305_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_306_Var
		);
		final EList<? extends EObject> Expr_306_list = ExclusiveOrExpression_306_Var
		.getExpr();
		Assert.assertNotNull(Expr_306_list);
		Assert.assertEquals(1, Expr_306_list.size());
		//306
		final AndExpression AndExpression_307_Var
		 = (AndExpression)Expr_306_list.get(0);
		Assert.assertNotNull(AndExpression_307_Var
		);
		final EList<? extends EObject> Expr_307_list = AndExpression_307_Var
		.getExpr();
		Assert.assertNotNull(Expr_307_list);
		Assert.assertEquals(1, Expr_307_list.size());
		//307
		final EqualityExpression EqualityExpression_308_Var
		 = (EqualityExpression)Expr_307_list.get(0);
		Assert.assertNotNull(EqualityExpression_308_Var
		);
		final EList<? extends EObject> Expr_308_list = EqualityExpression_308_Var
		.getExpr();
		Assert.assertNotNull(Expr_308_list);
		Assert.assertEquals(1, Expr_308_list.size());
		//308
		final RelationalExpression RelationalExpression_309_Var
		 = (RelationalExpression)Expr_308_list.get(0);
		Assert.assertNotNull(RelationalExpression_309_Var
		);
		final EList<? extends EObject> Expr_309_list = RelationalExpression_309_Var
		.getExpr();
		Assert.assertNotNull(Expr_309_list);
		Assert.assertEquals(1, Expr_309_list.size());
		//309
		final ShiftExpression ShiftExpression_310_Var
		 = (ShiftExpression)Expr_309_list.get(0);
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
		Assert.assertEquals("printf", PrimaryExpression_316_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_316_list = PostfixExpression_315_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_316_list);
		Assert.assertEquals(1, ArgumentExpressionList_316_list.size());
		//316
		final ArgumentExpressionList ArgumentExpressionList_317_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_316_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_317_Var
		);
		final EList<? extends EObject> Expr_317_list = ArgumentExpressionList_317_Var
		.getExpr();
		Assert.assertNotNull(Expr_317_list);
		Assert.assertEquals(2, Expr_317_list.size());
		//317
		final AssignmentExpression AssignmentExpression_318_Var
		 = (AssignmentExpression)Expr_317_list.get(0);
		Assert.assertNotNull(AssignmentExpression_318_Var
		);
		//318
		final ConditionalExpression ConditionalExpression_319_Var
		 = (ConditionalExpression)AssignmentExpression_318_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_319_Var
		);
		//319
		final LogicalOrExpression LogicalOrExpression_320_Var
		 = (LogicalOrExpression)ConditionalExpression_319_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_320_Var
		);
		final EList<? extends EObject> Expr_320_list = LogicalOrExpression_320_Var
		.getExpr();
		Assert.assertNotNull(Expr_320_list);
		Assert.assertEquals(1, Expr_320_list.size());
		//320
		final LogicalAndExpression LogicalAndExpression_321_Var
		 = (LogicalAndExpression)Expr_320_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_321_Var
		);
		final EList<? extends EObject> Expr_321_list = LogicalAndExpression_321_Var
		.getExpr();
		Assert.assertNotNull(Expr_321_list);
		Assert.assertEquals(1, Expr_321_list.size());
		//321
		final InclusiveOrExpression InclusiveOrExpression_322_Var
		 = (InclusiveOrExpression)Expr_321_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_322_Var
		);
		final EList<? extends EObject> Expr_322_list = InclusiveOrExpression_322_Var
		.getExpr();
		Assert.assertNotNull(Expr_322_list);
		Assert.assertEquals(1, Expr_322_list.size());
		//322
		final ExclusiveOrExpression ExclusiveOrExpression_323_Var
		 = (ExclusiveOrExpression)Expr_322_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_323_Var
		);
		final EList<? extends EObject> Expr_323_list = ExclusiveOrExpression_323_Var
		.getExpr();
		Assert.assertNotNull(Expr_323_list);
		Assert.assertEquals(1, Expr_323_list.size());
		//323
		final AndExpression AndExpression_324_Var
		 = (AndExpression)Expr_323_list.get(0);
		Assert.assertNotNull(AndExpression_324_Var
		);
		final EList<? extends EObject> Expr_324_list = AndExpression_324_Var
		.getExpr();
		Assert.assertNotNull(Expr_324_list);
		Assert.assertEquals(1, Expr_324_list.size());
		//324
		final EqualityExpression EqualityExpression_325_Var
		 = (EqualityExpression)Expr_324_list.get(0);
		Assert.assertNotNull(EqualityExpression_325_Var
		);
		final EList<? extends EObject> Expr_325_list = EqualityExpression_325_Var
		.getExpr();
		Assert.assertNotNull(Expr_325_list);
		Assert.assertEquals(1, Expr_325_list.size());
		//325
		final RelationalExpression RelationalExpression_326_Var
		 = (RelationalExpression)Expr_325_list.get(0);
		Assert.assertNotNull(RelationalExpression_326_Var
		);
		final EList<? extends EObject> Expr_326_list = RelationalExpression_326_Var
		.getExpr();
		Assert.assertNotNull(Expr_326_list);
		Assert.assertEquals(1, Expr_326_list.size());
		//326
		final ShiftExpression ShiftExpression_327_Var
		 = (ShiftExpression)Expr_326_list.get(0);
		Assert.assertNotNull(ShiftExpression_327_Var
		);
		final EList<? extends EObject> Expr_327_list = ShiftExpression_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final AdditiveExpression AdditiveExpression_328_Var
		 = (AdditiveExpression)Expr_327_list.get(0);
		Assert.assertNotNull(AdditiveExpression_328_Var
		);
		final EList<? extends EObject> Expr_328_list = AdditiveExpression_328_Var
		.getExpr();
		Assert.assertNotNull(Expr_328_list);
		Assert.assertEquals(1, Expr_328_list.size());
		//328
		final MultiplicativeExpression MultiplicativeExpression_329_Var
		 = (MultiplicativeExpression)Expr_328_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_329_Var
		);
		final EList<? extends EObject> Expr_329_list = MultiplicativeExpression_329_Var
		.getExpr();
		Assert.assertNotNull(Expr_329_list);
		Assert.assertEquals(1, Expr_329_list.size());
		//329
		final CastExpression CastExpression_330_Var
		 = (CastExpression)Expr_329_list.get(0);
		Assert.assertNotNull(CastExpression_330_Var
		);
		//330
		final UnaryExpression UnaryExpression_331_Var
		 = (UnaryExpression)CastExpression_330_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_331_Var
		);
		//331
		final PostfixExpression PostfixExpression_332_Var
		 = (PostfixExpression)UnaryExpression_331_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_332_Var
		);
		final EList<? extends EObject> Expr_332_list = PostfixExpression_332_Var
		.getExpr();
		Assert.assertNotNull(Expr_332_list);
		Assert.assertEquals(1, Expr_332_list.size());
		//332
		final PrimaryExpression PrimaryExpression_333_Var
		 = (PrimaryExpression)Expr_332_list.get(0);
		Assert.assertNotNull(PrimaryExpression_333_Var
		);
		//333
		final Constant Constant_334_Var
		 = (Constant)PrimaryExpression_333_Var
		.getConst();
		Assert.assertNotNull(Constant_334_Var
		);
		Assert.assertEquals("\"number.numChar(as decimal)=%d\\n\"", Constant_334_Var
		.getStr());
		//334
		final AssignmentExpression AssignmentExpression_335_Var
		 = (AssignmentExpression)Expr_317_list.get(1);
		Assert.assertNotNull(AssignmentExpression_335_Var
		);
		//335
		final ConditionalExpression ConditionalExpression_336_Var
		 = (ConditionalExpression)AssignmentExpression_335_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_336_Var
		);
		//336
		final LogicalOrExpression LogicalOrExpression_337_Var
		 = (LogicalOrExpression)ConditionalExpression_336_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_337_Var
		);
		final EList<? extends EObject> Expr_337_list = LogicalOrExpression_337_Var
		.getExpr();
		Assert.assertNotNull(Expr_337_list);
		Assert.assertEquals(1, Expr_337_list.size());
		//337
		final LogicalAndExpression LogicalAndExpression_338_Var
		 = (LogicalAndExpression)Expr_337_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_338_Var
		);
		final EList<? extends EObject> Expr_338_list = LogicalAndExpression_338_Var
		.getExpr();
		Assert.assertNotNull(Expr_338_list);
		Assert.assertEquals(1, Expr_338_list.size());
		//338
		final InclusiveOrExpression InclusiveOrExpression_339_Var
		 = (InclusiveOrExpression)Expr_338_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_339_Var
		);
		final EList<? extends EObject> Expr_339_list = InclusiveOrExpression_339_Var
		.getExpr();
		Assert.assertNotNull(Expr_339_list);
		Assert.assertEquals(1, Expr_339_list.size());
		//339
		final ExclusiveOrExpression ExclusiveOrExpression_340_Var
		 = (ExclusiveOrExpression)Expr_339_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_340_Var
		);
		final EList<? extends EObject> Expr_340_list = ExclusiveOrExpression_340_Var
		.getExpr();
		Assert.assertNotNull(Expr_340_list);
		Assert.assertEquals(1, Expr_340_list.size());
		//340
		final AndExpression AndExpression_341_Var
		 = (AndExpression)Expr_340_list.get(0);
		Assert.assertNotNull(AndExpression_341_Var
		);
		final EList<? extends EObject> Expr_341_list = AndExpression_341_Var
		.getExpr();
		Assert.assertNotNull(Expr_341_list);
		Assert.assertEquals(1, Expr_341_list.size());
		//341
		final EqualityExpression EqualityExpression_342_Var
		 = (EqualityExpression)Expr_341_list.get(0);
		Assert.assertNotNull(EqualityExpression_342_Var
		);
		final EList<? extends EObject> Expr_342_list = EqualityExpression_342_Var
		.getExpr();
		Assert.assertNotNull(Expr_342_list);
		Assert.assertEquals(1, Expr_342_list.size());
		//342
		final RelationalExpression RelationalExpression_343_Var
		 = (RelationalExpression)Expr_342_list.get(0);
		Assert.assertNotNull(RelationalExpression_343_Var
		);
		final EList<? extends EObject> Expr_343_list = RelationalExpression_343_Var
		.getExpr();
		Assert.assertNotNull(Expr_343_list);
		Assert.assertEquals(1, Expr_343_list.size());
		//343
		final ShiftExpression ShiftExpression_344_Var
		 = (ShiftExpression)Expr_343_list.get(0);
		Assert.assertNotNull(ShiftExpression_344_Var
		);
		final EList<? extends EObject> Expr_344_list = ShiftExpression_344_Var
		.getExpr();
		Assert.assertNotNull(Expr_344_list);
		Assert.assertEquals(1, Expr_344_list.size());
		//344
		final AdditiveExpression AdditiveExpression_345_Var
		 = (AdditiveExpression)Expr_344_list.get(0);
		Assert.assertNotNull(AdditiveExpression_345_Var
		);
		final EList<? extends EObject> Expr_345_list = AdditiveExpression_345_Var
		.getExpr();
		Assert.assertNotNull(Expr_345_list);
		Assert.assertEquals(1, Expr_345_list.size());
		//345
		final MultiplicativeExpression MultiplicativeExpression_346_Var
		 = (MultiplicativeExpression)Expr_345_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_346_Var
		);
		final EList<? extends EObject> Expr_346_list = MultiplicativeExpression_346_Var
		.getExpr();
		Assert.assertNotNull(Expr_346_list);
		Assert.assertEquals(1, Expr_346_list.size());
		//346
		final CastExpression CastExpression_347_Var
		 = (CastExpression)Expr_346_list.get(0);
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
		Assert.assertEquals("number", PrimaryExpression_350_Var
		.getId());
		Assert.assertEquals("[.]", PostfixExpression_349_Var
		.getDot().toString());
		Assert.assertEquals("[numChar]", PostfixExpression_349_Var
		.getId().toString());
		Assert.assertEquals(";", ExpressionStatement_299_Var
		.getSemi());
		//350
		final Statement Statement_351_Var
		 = (Statement)Statement_94_list.get(5);
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
		Assert.assertEquals("printf", PrimaryExpression_369_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_369_list = PostfixExpression_368_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_369_list);
		Assert.assertEquals(1, ArgumentExpressionList_369_list.size());
		//369
		final ArgumentExpressionList ArgumentExpressionList_370_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_369_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_370_Var
		);
		final EList<? extends EObject> Expr_370_list = ArgumentExpressionList_370_Var
		.getExpr();
		Assert.assertNotNull(Expr_370_list);
		Assert.assertEquals(2, Expr_370_list.size());
		//370
		final AssignmentExpression AssignmentExpression_371_Var
		 = (AssignmentExpression)Expr_370_list.get(0);
		Assert.assertNotNull(AssignmentExpression_371_Var
		);
		//371
		final ConditionalExpression ConditionalExpression_372_Var
		 = (ConditionalExpression)AssignmentExpression_371_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_372_Var
		);
		//372
		final LogicalOrExpression LogicalOrExpression_373_Var
		 = (LogicalOrExpression)ConditionalExpression_372_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_373_Var
		);
		final EList<? extends EObject> Expr_373_list = LogicalOrExpression_373_Var
		.getExpr();
		Assert.assertNotNull(Expr_373_list);
		Assert.assertEquals(1, Expr_373_list.size());
		//373
		final LogicalAndExpression LogicalAndExpression_374_Var
		 = (LogicalAndExpression)Expr_373_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_374_Var
		);
		final EList<? extends EObject> Expr_374_list = LogicalAndExpression_374_Var
		.getExpr();
		Assert.assertNotNull(Expr_374_list);
		Assert.assertEquals(1, Expr_374_list.size());
		//374
		final InclusiveOrExpression InclusiveOrExpression_375_Var
		 = (InclusiveOrExpression)Expr_374_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_375_Var
		);
		final EList<? extends EObject> Expr_375_list = InclusiveOrExpression_375_Var
		.getExpr();
		Assert.assertNotNull(Expr_375_list);
		Assert.assertEquals(1, Expr_375_list.size());
		//375
		final ExclusiveOrExpression ExclusiveOrExpression_376_Var
		 = (ExclusiveOrExpression)Expr_375_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_376_Var
		);
		final EList<? extends EObject> Expr_376_list = ExclusiveOrExpression_376_Var
		.getExpr();
		Assert.assertNotNull(Expr_376_list);
		Assert.assertEquals(1, Expr_376_list.size());
		//376
		final AndExpression AndExpression_377_Var
		 = (AndExpression)Expr_376_list.get(0);
		Assert.assertNotNull(AndExpression_377_Var
		);
		final EList<? extends EObject> Expr_377_list = AndExpression_377_Var
		.getExpr();
		Assert.assertNotNull(Expr_377_list);
		Assert.assertEquals(1, Expr_377_list.size());
		//377
		final EqualityExpression EqualityExpression_378_Var
		 = (EqualityExpression)Expr_377_list.get(0);
		Assert.assertNotNull(EqualityExpression_378_Var
		);
		final EList<? extends EObject> Expr_378_list = EqualityExpression_378_Var
		.getExpr();
		Assert.assertNotNull(Expr_378_list);
		Assert.assertEquals(1, Expr_378_list.size());
		//378
		final RelationalExpression RelationalExpression_379_Var
		 = (RelationalExpression)Expr_378_list.get(0);
		Assert.assertNotNull(RelationalExpression_379_Var
		);
		final EList<? extends EObject> Expr_379_list = RelationalExpression_379_Var
		.getExpr();
		Assert.assertNotNull(Expr_379_list);
		Assert.assertEquals(1, Expr_379_list.size());
		//379
		final ShiftExpression ShiftExpression_380_Var
		 = (ShiftExpression)Expr_379_list.get(0);
		Assert.assertNotNull(ShiftExpression_380_Var
		);
		final EList<? extends EObject> Expr_380_list = ShiftExpression_380_Var
		.getExpr();
		Assert.assertNotNull(Expr_380_list);
		Assert.assertEquals(1, Expr_380_list.size());
		//380
		final AdditiveExpression AdditiveExpression_381_Var
		 = (AdditiveExpression)Expr_380_list.get(0);
		Assert.assertNotNull(AdditiveExpression_381_Var
		);
		final EList<? extends EObject> Expr_381_list = AdditiveExpression_381_Var
		.getExpr();
		Assert.assertNotNull(Expr_381_list);
		Assert.assertEquals(1, Expr_381_list.size());
		//381
		final MultiplicativeExpression MultiplicativeExpression_382_Var
		 = (MultiplicativeExpression)Expr_381_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_382_Var
		);
		final EList<? extends EObject> Expr_382_list = MultiplicativeExpression_382_Var
		.getExpr();
		Assert.assertNotNull(Expr_382_list);
		Assert.assertEquals(1, Expr_382_list.size());
		//382
		final CastExpression CastExpression_383_Var
		 = (CastExpression)Expr_382_list.get(0);
		Assert.assertNotNull(CastExpression_383_Var
		);
		//383
		final UnaryExpression UnaryExpression_384_Var
		 = (UnaryExpression)CastExpression_383_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_384_Var
		);
		//384
		final PostfixExpression PostfixExpression_385_Var
		 = (PostfixExpression)UnaryExpression_384_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_385_Var
		);
		final EList<? extends EObject> Expr_385_list = PostfixExpression_385_Var
		.getExpr();
		Assert.assertNotNull(Expr_385_list);
		Assert.assertEquals(1, Expr_385_list.size());
		//385
		final PrimaryExpression PrimaryExpression_386_Var
		 = (PrimaryExpression)Expr_385_list.get(0);
		Assert.assertNotNull(PrimaryExpression_386_Var
		);
		//386
		final Constant Constant_387_Var
		 = (Constant)PrimaryExpression_386_Var
		.getConst();
		Assert.assertNotNull(Constant_387_Var
		);
		Assert.assertEquals("\"number.numChar(as char)=%c\\n\"", Constant_387_Var
		.getStr());
		//387
		final AssignmentExpression AssignmentExpression_388_Var
		 = (AssignmentExpression)Expr_370_list.get(1);
		Assert.assertNotNull(AssignmentExpression_388_Var
		);
		//388
		final ConditionalExpression ConditionalExpression_389_Var
		 = (ConditionalExpression)AssignmentExpression_388_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_389_Var
		);
		//389
		final LogicalOrExpression LogicalOrExpression_390_Var
		 = (LogicalOrExpression)ConditionalExpression_389_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_390_Var
		);
		final EList<? extends EObject> Expr_390_list = LogicalOrExpression_390_Var
		.getExpr();
		Assert.assertNotNull(Expr_390_list);
		Assert.assertEquals(1, Expr_390_list.size());
		//390
		final LogicalAndExpression LogicalAndExpression_391_Var
		 = (LogicalAndExpression)Expr_390_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_391_Var
		);
		final EList<? extends EObject> Expr_391_list = LogicalAndExpression_391_Var
		.getExpr();
		Assert.assertNotNull(Expr_391_list);
		Assert.assertEquals(1, Expr_391_list.size());
		//391
		final InclusiveOrExpression InclusiveOrExpression_392_Var
		 = (InclusiveOrExpression)Expr_391_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_392_Var
		);
		final EList<? extends EObject> Expr_392_list = InclusiveOrExpression_392_Var
		.getExpr();
		Assert.assertNotNull(Expr_392_list);
		Assert.assertEquals(1, Expr_392_list.size());
		//392
		final ExclusiveOrExpression ExclusiveOrExpression_393_Var
		 = (ExclusiveOrExpression)Expr_392_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_393_Var
		);
		final EList<? extends EObject> Expr_393_list = ExclusiveOrExpression_393_Var
		.getExpr();
		Assert.assertNotNull(Expr_393_list);
		Assert.assertEquals(1, Expr_393_list.size());
		//393
		final AndExpression AndExpression_394_Var
		 = (AndExpression)Expr_393_list.get(0);
		Assert.assertNotNull(AndExpression_394_Var
		);
		final EList<? extends EObject> Expr_394_list = AndExpression_394_Var
		.getExpr();
		Assert.assertNotNull(Expr_394_list);
		Assert.assertEquals(1, Expr_394_list.size());
		//394
		final EqualityExpression EqualityExpression_395_Var
		 = (EqualityExpression)Expr_394_list.get(0);
		Assert.assertNotNull(EqualityExpression_395_Var
		);
		final EList<? extends EObject> Expr_395_list = EqualityExpression_395_Var
		.getExpr();
		Assert.assertNotNull(Expr_395_list);
		Assert.assertEquals(1, Expr_395_list.size());
		//395
		final RelationalExpression RelationalExpression_396_Var
		 = (RelationalExpression)Expr_395_list.get(0);
		Assert.assertNotNull(RelationalExpression_396_Var
		);
		final EList<? extends EObject> Expr_396_list = RelationalExpression_396_Var
		.getExpr();
		Assert.assertNotNull(Expr_396_list);
		Assert.assertEquals(1, Expr_396_list.size());
		//396
		final ShiftExpression ShiftExpression_397_Var
		 = (ShiftExpression)Expr_396_list.get(0);
		Assert.assertNotNull(ShiftExpression_397_Var
		);
		final EList<? extends EObject> Expr_397_list = ShiftExpression_397_Var
		.getExpr();
		Assert.assertNotNull(Expr_397_list);
		Assert.assertEquals(1, Expr_397_list.size());
		//397
		final AdditiveExpression AdditiveExpression_398_Var
		 = (AdditiveExpression)Expr_397_list.get(0);
		Assert.assertNotNull(AdditiveExpression_398_Var
		);
		final EList<? extends EObject> Expr_398_list = AdditiveExpression_398_Var
		.getExpr();
		Assert.assertNotNull(Expr_398_list);
		Assert.assertEquals(1, Expr_398_list.size());
		//398
		final MultiplicativeExpression MultiplicativeExpression_399_Var
		 = (MultiplicativeExpression)Expr_398_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_399_Var
		);
		final EList<? extends EObject> Expr_399_list = MultiplicativeExpression_399_Var
		.getExpr();
		Assert.assertNotNull(Expr_399_list);
		Assert.assertEquals(1, Expr_399_list.size());
		//399
		final CastExpression CastExpression_400_Var
		 = (CastExpression)Expr_399_list.get(0);
		Assert.assertNotNull(CastExpression_400_Var
		);
		//400
		final UnaryExpression UnaryExpression_401_Var
		 = (UnaryExpression)CastExpression_400_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_401_Var
		);
		//401
		final PostfixExpression PostfixExpression_402_Var
		 = (PostfixExpression)UnaryExpression_401_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_402_Var
		);
		final EList<? extends EObject> Expr_402_list = PostfixExpression_402_Var
		.getExpr();
		Assert.assertNotNull(Expr_402_list);
		Assert.assertEquals(1, Expr_402_list.size());
		//402
		final PrimaryExpression PrimaryExpression_403_Var
		 = (PrimaryExpression)Expr_402_list.get(0);
		Assert.assertNotNull(PrimaryExpression_403_Var
		);
		Assert.assertEquals("number", PrimaryExpression_403_Var
		.getId());
		Assert.assertEquals("[.]", PostfixExpression_402_Var
		.getDot().toString());
		Assert.assertEquals("[numChar]", PostfixExpression_402_Var
		.getId().toString());
		Assert.assertEquals(";", ExpressionStatement_352_Var
		.getSemi());
		//403
		final Statement Statement_404_Var
		 = (Statement)Statement_94_list.get(6);
		Assert.assertNotNull(Statement_404_Var
		);
		//404
		final ExpressionStatement ExpressionStatement_405_Var
		 = (ExpressionStatement)Statement_404_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_405_Var
		);
		//405
		final Expression Expression_406_Var
		 = (Expression)ExpressionStatement_405_Var
		.getExpression();
		Assert.assertNotNull(Expression_406_Var
		);
		final EList<? extends EObject> ExprExpr_406_list = Expression_406_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_406_list);
		Assert.assertEquals(1, ExprExpr_406_list.size());
		//406
		final AssignmentExpression AssignmentExpression_407_Var
		 = (AssignmentExpression)ExprExpr_406_list.get(0);
		Assert.assertNotNull(AssignmentExpression_407_Var
		);
		//407
		final ConditionalExpression ConditionalExpression_408_Var
		 = (ConditionalExpression)AssignmentExpression_407_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_408_Var
		);
		//408
		final LogicalOrExpression LogicalOrExpression_409_Var
		 = (LogicalOrExpression)ConditionalExpression_408_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_409_Var
		);
		final EList<? extends EObject> Expr_409_list = LogicalOrExpression_409_Var
		.getExpr();
		Assert.assertNotNull(Expr_409_list);
		Assert.assertEquals(1, Expr_409_list.size());
		//409
		final LogicalAndExpression LogicalAndExpression_410_Var
		 = (LogicalAndExpression)Expr_409_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_410_Var
		);
		final EList<? extends EObject> Expr_410_list = LogicalAndExpression_410_Var
		.getExpr();
		Assert.assertNotNull(Expr_410_list);
		Assert.assertEquals(1, Expr_410_list.size());
		//410
		final InclusiveOrExpression InclusiveOrExpression_411_Var
		 = (InclusiveOrExpression)Expr_410_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_411_Var
		);
		final EList<? extends EObject> Expr_411_list = InclusiveOrExpression_411_Var
		.getExpr();
		Assert.assertNotNull(Expr_411_list);
		Assert.assertEquals(1, Expr_411_list.size());
		//411
		final ExclusiveOrExpression ExclusiveOrExpression_412_Var
		 = (ExclusiveOrExpression)Expr_411_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_412_Var
		);
		final EList<? extends EObject> Expr_412_list = ExclusiveOrExpression_412_Var
		.getExpr();
		Assert.assertNotNull(Expr_412_list);
		Assert.assertEquals(1, Expr_412_list.size());
		//412
		final AndExpression AndExpression_413_Var
		 = (AndExpression)Expr_412_list.get(0);
		Assert.assertNotNull(AndExpression_413_Var
		);
		final EList<? extends EObject> Expr_413_list = AndExpression_413_Var
		.getExpr();
		Assert.assertNotNull(Expr_413_list);
		Assert.assertEquals(1, Expr_413_list.size());
		//413
		final EqualityExpression EqualityExpression_414_Var
		 = (EqualityExpression)Expr_413_list.get(0);
		Assert.assertNotNull(EqualityExpression_414_Var
		);
		final EList<? extends EObject> Expr_414_list = EqualityExpression_414_Var
		.getExpr();
		Assert.assertNotNull(Expr_414_list);
		Assert.assertEquals(1, Expr_414_list.size());
		//414
		final RelationalExpression RelationalExpression_415_Var
		 = (RelationalExpression)Expr_414_list.get(0);
		Assert.assertNotNull(RelationalExpression_415_Var
		);
		final EList<? extends EObject> Expr_415_list = RelationalExpression_415_Var
		.getExpr();
		Assert.assertNotNull(Expr_415_list);
		Assert.assertEquals(1, Expr_415_list.size());
		//415
		final ShiftExpression ShiftExpression_416_Var
		 = (ShiftExpression)Expr_415_list.get(0);
		Assert.assertNotNull(ShiftExpression_416_Var
		);
		final EList<? extends EObject> Expr_416_list = ShiftExpression_416_Var
		.getExpr();
		Assert.assertNotNull(Expr_416_list);
		Assert.assertEquals(1, Expr_416_list.size());
		//416
		final AdditiveExpression AdditiveExpression_417_Var
		 = (AdditiveExpression)Expr_416_list.get(0);
		Assert.assertNotNull(AdditiveExpression_417_Var
		);
		final EList<? extends EObject> Expr_417_list = AdditiveExpression_417_Var
		.getExpr();
		Assert.assertNotNull(Expr_417_list);
		Assert.assertEquals(1, Expr_417_list.size());
		//417
		final MultiplicativeExpression MultiplicativeExpression_418_Var
		 = (MultiplicativeExpression)Expr_417_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_418_Var
		);
		final EList<? extends EObject> Expr_418_list = MultiplicativeExpression_418_Var
		.getExpr();
		Assert.assertNotNull(Expr_418_list);
		Assert.assertEquals(1, Expr_418_list.size());
		//418
		final CastExpression CastExpression_419_Var
		 = (CastExpression)Expr_418_list.get(0);
		Assert.assertNotNull(CastExpression_419_Var
		);
		//419
		final UnaryExpression UnaryExpression_420_Var
		 = (UnaryExpression)CastExpression_419_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_420_Var
		);
		//420
		final PostfixExpression PostfixExpression_421_Var
		 = (PostfixExpression)UnaryExpression_420_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_421_Var
		);
		final EList<? extends EObject> Expr_421_list = PostfixExpression_421_Var
		.getExpr();
		Assert.assertNotNull(Expr_421_list);
		Assert.assertEquals(1, Expr_421_list.size());
		//421
		final PrimaryExpression PrimaryExpression_422_Var
		 = (PrimaryExpression)Expr_421_list.get(0);
		Assert.assertNotNull(PrimaryExpression_422_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_422_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_422_list = PostfixExpression_421_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_422_list);
		Assert.assertEquals(1, ArgumentExpressionList_422_list.size());
		//422
		final ArgumentExpressionList ArgumentExpressionList_423_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_422_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_423_Var
		);
		final EList<? extends EObject> Expr_423_list = ArgumentExpressionList_423_Var
		.getExpr();
		Assert.assertNotNull(Expr_423_list);
		Assert.assertEquals(2, Expr_423_list.size());
		//423
		final AssignmentExpression AssignmentExpression_424_Var
		 = (AssignmentExpression)Expr_423_list.get(0);
		Assert.assertNotNull(AssignmentExpression_424_Var
		);
		//424
		final ConditionalExpression ConditionalExpression_425_Var
		 = (ConditionalExpression)AssignmentExpression_424_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_425_Var
		);
		//425
		final LogicalOrExpression LogicalOrExpression_426_Var
		 = (LogicalOrExpression)ConditionalExpression_425_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_426_Var
		);
		final EList<? extends EObject> Expr_426_list = LogicalOrExpression_426_Var
		.getExpr();
		Assert.assertNotNull(Expr_426_list);
		Assert.assertEquals(1, Expr_426_list.size());
		//426
		final LogicalAndExpression LogicalAndExpression_427_Var
		 = (LogicalAndExpression)Expr_426_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_427_Var
		);
		final EList<? extends EObject> Expr_427_list = LogicalAndExpression_427_Var
		.getExpr();
		Assert.assertNotNull(Expr_427_list);
		Assert.assertEquals(1, Expr_427_list.size());
		//427
		final InclusiveOrExpression InclusiveOrExpression_428_Var
		 = (InclusiveOrExpression)Expr_427_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_428_Var
		);
		final EList<? extends EObject> Expr_428_list = InclusiveOrExpression_428_Var
		.getExpr();
		Assert.assertNotNull(Expr_428_list);
		Assert.assertEquals(1, Expr_428_list.size());
		//428
		final ExclusiveOrExpression ExclusiveOrExpression_429_Var
		 = (ExclusiveOrExpression)Expr_428_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_429_Var
		);
		final EList<? extends EObject> Expr_429_list = ExclusiveOrExpression_429_Var
		.getExpr();
		Assert.assertNotNull(Expr_429_list);
		Assert.assertEquals(1, Expr_429_list.size());
		//429
		final AndExpression AndExpression_430_Var
		 = (AndExpression)Expr_429_list.get(0);
		Assert.assertNotNull(AndExpression_430_Var
		);
		final EList<? extends EObject> Expr_430_list = AndExpression_430_Var
		.getExpr();
		Assert.assertNotNull(Expr_430_list);
		Assert.assertEquals(1, Expr_430_list.size());
		//430
		final EqualityExpression EqualityExpression_431_Var
		 = (EqualityExpression)Expr_430_list.get(0);
		Assert.assertNotNull(EqualityExpression_431_Var
		);
		final EList<? extends EObject> Expr_431_list = EqualityExpression_431_Var
		.getExpr();
		Assert.assertNotNull(Expr_431_list);
		Assert.assertEquals(1, Expr_431_list.size());
		//431
		final RelationalExpression RelationalExpression_432_Var
		 = (RelationalExpression)Expr_431_list.get(0);
		Assert.assertNotNull(RelationalExpression_432_Var
		);
		final EList<? extends EObject> Expr_432_list = RelationalExpression_432_Var
		.getExpr();
		Assert.assertNotNull(Expr_432_list);
		Assert.assertEquals(1, Expr_432_list.size());
		//432
		final ShiftExpression ShiftExpression_433_Var
		 = (ShiftExpression)Expr_432_list.get(0);
		Assert.assertNotNull(ShiftExpression_433_Var
		);
		final EList<? extends EObject> Expr_433_list = ShiftExpression_433_Var
		.getExpr();
		Assert.assertNotNull(Expr_433_list);
		Assert.assertEquals(1, Expr_433_list.size());
		//433
		final AdditiveExpression AdditiveExpression_434_Var
		 = (AdditiveExpression)Expr_433_list.get(0);
		Assert.assertNotNull(AdditiveExpression_434_Var
		);
		final EList<? extends EObject> Expr_434_list = AdditiveExpression_434_Var
		.getExpr();
		Assert.assertNotNull(Expr_434_list);
		Assert.assertEquals(1, Expr_434_list.size());
		//434
		final MultiplicativeExpression MultiplicativeExpression_435_Var
		 = (MultiplicativeExpression)Expr_434_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_435_Var
		);
		final EList<? extends EObject> Expr_435_list = MultiplicativeExpression_435_Var
		.getExpr();
		Assert.assertNotNull(Expr_435_list);
		Assert.assertEquals(1, Expr_435_list.size());
		//435
		final CastExpression CastExpression_436_Var
		 = (CastExpression)Expr_435_list.get(0);
		Assert.assertNotNull(CastExpression_436_Var
		);
		//436
		final UnaryExpression UnaryExpression_437_Var
		 = (UnaryExpression)CastExpression_436_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_437_Var
		);
		//437
		final PostfixExpression PostfixExpression_438_Var
		 = (PostfixExpression)UnaryExpression_437_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_438_Var
		);
		final EList<? extends EObject> Expr_438_list = PostfixExpression_438_Var
		.getExpr();
		Assert.assertNotNull(Expr_438_list);
		Assert.assertEquals(1, Expr_438_list.size());
		//438
		final PrimaryExpression PrimaryExpression_439_Var
		 = (PrimaryExpression)Expr_438_list.get(0);
		Assert.assertNotNull(PrimaryExpression_439_Var
		);
		//439
		final Constant Constant_440_Var
		 = (Constant)PrimaryExpression_439_Var
		.getConst();
		Assert.assertNotNull(Constant_440_Var
		);
		Assert.assertEquals("\"number.numFloat=%f\\n\"", Constant_440_Var
		.getStr());
		//440
		final AssignmentExpression AssignmentExpression_441_Var
		 = (AssignmentExpression)Expr_423_list.get(1);
		Assert.assertNotNull(AssignmentExpression_441_Var
		);
		//441
		final ConditionalExpression ConditionalExpression_442_Var
		 = (ConditionalExpression)AssignmentExpression_441_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_442_Var
		);
		//442
		final LogicalOrExpression LogicalOrExpression_443_Var
		 = (LogicalOrExpression)ConditionalExpression_442_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_443_Var
		);
		final EList<? extends EObject> Expr_443_list = LogicalOrExpression_443_Var
		.getExpr();
		Assert.assertNotNull(Expr_443_list);
		Assert.assertEquals(1, Expr_443_list.size());
		//443
		final LogicalAndExpression LogicalAndExpression_444_Var
		 = (LogicalAndExpression)Expr_443_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_444_Var
		);
		final EList<? extends EObject> Expr_444_list = LogicalAndExpression_444_Var
		.getExpr();
		Assert.assertNotNull(Expr_444_list);
		Assert.assertEquals(1, Expr_444_list.size());
		//444
		final InclusiveOrExpression InclusiveOrExpression_445_Var
		 = (InclusiveOrExpression)Expr_444_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_445_Var
		);
		final EList<? extends EObject> Expr_445_list = InclusiveOrExpression_445_Var
		.getExpr();
		Assert.assertNotNull(Expr_445_list);
		Assert.assertEquals(1, Expr_445_list.size());
		//445
		final ExclusiveOrExpression ExclusiveOrExpression_446_Var
		 = (ExclusiveOrExpression)Expr_445_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_446_Var
		);
		final EList<? extends EObject> Expr_446_list = ExclusiveOrExpression_446_Var
		.getExpr();
		Assert.assertNotNull(Expr_446_list);
		Assert.assertEquals(1, Expr_446_list.size());
		//446
		final AndExpression AndExpression_447_Var
		 = (AndExpression)Expr_446_list.get(0);
		Assert.assertNotNull(AndExpression_447_Var
		);
		final EList<? extends EObject> Expr_447_list = AndExpression_447_Var
		.getExpr();
		Assert.assertNotNull(Expr_447_list);
		Assert.assertEquals(1, Expr_447_list.size());
		//447
		final EqualityExpression EqualityExpression_448_Var
		 = (EqualityExpression)Expr_447_list.get(0);
		Assert.assertNotNull(EqualityExpression_448_Var
		);
		final EList<? extends EObject> Expr_448_list = EqualityExpression_448_Var
		.getExpr();
		Assert.assertNotNull(Expr_448_list);
		Assert.assertEquals(1, Expr_448_list.size());
		//448
		final RelationalExpression RelationalExpression_449_Var
		 = (RelationalExpression)Expr_448_list.get(0);
		Assert.assertNotNull(RelationalExpression_449_Var
		);
		final EList<? extends EObject> Expr_449_list = RelationalExpression_449_Var
		.getExpr();
		Assert.assertNotNull(Expr_449_list);
		Assert.assertEquals(1, Expr_449_list.size());
		//449
		final ShiftExpression ShiftExpression_450_Var
		 = (ShiftExpression)Expr_449_list.get(0);
		Assert.assertNotNull(ShiftExpression_450_Var
		);
		final EList<? extends EObject> Expr_450_list = ShiftExpression_450_Var
		.getExpr();
		Assert.assertNotNull(Expr_450_list);
		Assert.assertEquals(1, Expr_450_list.size());
		//450
		final AdditiveExpression AdditiveExpression_451_Var
		 = (AdditiveExpression)Expr_450_list.get(0);
		Assert.assertNotNull(AdditiveExpression_451_Var
		);
		final EList<? extends EObject> Expr_451_list = AdditiveExpression_451_Var
		.getExpr();
		Assert.assertNotNull(Expr_451_list);
		Assert.assertEquals(1, Expr_451_list.size());
		//451
		final MultiplicativeExpression MultiplicativeExpression_452_Var
		 = (MultiplicativeExpression)Expr_451_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_452_Var
		);
		final EList<? extends EObject> Expr_452_list = MultiplicativeExpression_452_Var
		.getExpr();
		Assert.assertNotNull(Expr_452_list);
		Assert.assertEquals(1, Expr_452_list.size());
		//452
		final CastExpression CastExpression_453_Var
		 = (CastExpression)Expr_452_list.get(0);
		Assert.assertNotNull(CastExpression_453_Var
		);
		//453
		final UnaryExpression UnaryExpression_454_Var
		 = (UnaryExpression)CastExpression_453_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_454_Var
		);
		//454
		final PostfixExpression PostfixExpression_455_Var
		 = (PostfixExpression)UnaryExpression_454_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_455_Var
		);
		final EList<? extends EObject> Expr_455_list = PostfixExpression_455_Var
		.getExpr();
		Assert.assertNotNull(Expr_455_list);
		Assert.assertEquals(1, Expr_455_list.size());
		//455
		final PrimaryExpression PrimaryExpression_456_Var
		 = (PrimaryExpression)Expr_455_list.get(0);
		Assert.assertNotNull(PrimaryExpression_456_Var
		);
		Assert.assertEquals("number", PrimaryExpression_456_Var
		.getId());
		Assert.assertEquals("[.]", PostfixExpression_455_Var
		.getDot().toString());
		Assert.assertEquals("[numFloat]", PostfixExpression_455_Var
		.getId().toString());
		Assert.assertEquals(";", ExpressionStatement_405_Var
		.getSemi());
		//456
		final Statement Statement_457_Var
		 = (Statement)Statement_94_list.get(7);
		Assert.assertNotNull(Statement_457_Var
		);
		//457
		final ExpressionStatement ExpressionStatement_458_Var
		 = (ExpressionStatement)Statement_457_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_458_Var
		);
		//458
		final Expression Expression_459_Var
		 = (Expression)ExpressionStatement_458_Var
		.getExpression();
		Assert.assertNotNull(Expression_459_Var
		);
		final EList<? extends EObject> ExprExpr_459_list = Expression_459_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_459_list);
		Assert.assertEquals(1, ExprExpr_459_list.size());
		//459
		final AssignmentExpression AssignmentExpression_460_Var
		 = (AssignmentExpression)ExprExpr_459_list.get(0);
		Assert.assertNotNull(AssignmentExpression_460_Var
		);
		//460
		final UnaryExpression UnaryExpression_461_Var
		 = (UnaryExpression)AssignmentExpression_460_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_461_Var
		);
		//461
		final PostfixExpression PostfixExpression_462_Var
		 = (PostfixExpression)UnaryExpression_461_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_462_Var
		);
		final EList<? extends EObject> Expr_462_list = PostfixExpression_462_Var
		.getExpr();
		Assert.assertNotNull(Expr_462_list);
		Assert.assertEquals(1, Expr_462_list.size());
		//462
		final PrimaryExpression PrimaryExpression_463_Var
		 = (PrimaryExpression)Expr_462_list.get(0);
		Assert.assertNotNull(PrimaryExpression_463_Var
		);
		Assert.assertEquals("number", PrimaryExpression_463_Var
		.getId());
		Assert.assertEquals("[.]", PostfixExpression_462_Var
		.getDot().toString());
		Assert.assertEquals("[numFloat]", PostfixExpression_462_Var
		.getId().toString());
		//463
		final AssignmentOperator AssignmentOperator_464_Var
		 = (AssignmentOperator)AssignmentExpression_460_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_464_Var
		);
		Assert.assertEquals("=", AssignmentOperator_464_Var
		.getOp());
		//464
		final AssignmentExpression AssignmentExpression_465_Var
		 = (AssignmentExpression)AssignmentExpression_460_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_465_Var
		);
		//465
		final ConditionalExpression ConditionalExpression_466_Var
		 = (ConditionalExpression)AssignmentExpression_465_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_466_Var
		);
		//466
		final LogicalOrExpression LogicalOrExpression_467_Var
		 = (LogicalOrExpression)ConditionalExpression_466_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_467_Var
		);
		final EList<? extends EObject> Expr_467_list = LogicalOrExpression_467_Var
		.getExpr();
		Assert.assertNotNull(Expr_467_list);
		Assert.assertEquals(1, Expr_467_list.size());
		//467
		final LogicalAndExpression LogicalAndExpression_468_Var
		 = (LogicalAndExpression)Expr_467_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_468_Var
		);
		final EList<? extends EObject> Expr_468_list = LogicalAndExpression_468_Var
		.getExpr();
		Assert.assertNotNull(Expr_468_list);
		Assert.assertEquals(1, Expr_468_list.size());
		//468
		final InclusiveOrExpression InclusiveOrExpression_469_Var
		 = (InclusiveOrExpression)Expr_468_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_469_Var
		);
		final EList<? extends EObject> Expr_469_list = InclusiveOrExpression_469_Var
		.getExpr();
		Assert.assertNotNull(Expr_469_list);
		Assert.assertEquals(1, Expr_469_list.size());
		//469
		final ExclusiveOrExpression ExclusiveOrExpression_470_Var
		 = (ExclusiveOrExpression)Expr_469_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_470_Var
		);
		final EList<? extends EObject> Expr_470_list = ExclusiveOrExpression_470_Var
		.getExpr();
		Assert.assertNotNull(Expr_470_list);
		Assert.assertEquals(1, Expr_470_list.size());
		//470
		final AndExpression AndExpression_471_Var
		 = (AndExpression)Expr_470_list.get(0);
		Assert.assertNotNull(AndExpression_471_Var
		);
		final EList<? extends EObject> Expr_471_list = AndExpression_471_Var
		.getExpr();
		Assert.assertNotNull(Expr_471_list);
		Assert.assertEquals(1, Expr_471_list.size());
		//471
		final EqualityExpression EqualityExpression_472_Var
		 = (EqualityExpression)Expr_471_list.get(0);
		Assert.assertNotNull(EqualityExpression_472_Var
		);
		final EList<? extends EObject> Expr_472_list = EqualityExpression_472_Var
		.getExpr();
		Assert.assertNotNull(Expr_472_list);
		Assert.assertEquals(1, Expr_472_list.size());
		//472
		final RelationalExpression RelationalExpression_473_Var
		 = (RelationalExpression)Expr_472_list.get(0);
		Assert.assertNotNull(RelationalExpression_473_Var
		);
		final EList<? extends EObject> Expr_473_list = RelationalExpression_473_Var
		.getExpr();
		Assert.assertNotNull(Expr_473_list);
		Assert.assertEquals(1, Expr_473_list.size());
		//473
		final ShiftExpression ShiftExpression_474_Var
		 = (ShiftExpression)Expr_473_list.get(0);
		Assert.assertNotNull(ShiftExpression_474_Var
		);
		final EList<? extends EObject> Expr_474_list = ShiftExpression_474_Var
		.getExpr();
		Assert.assertNotNull(Expr_474_list);
		Assert.assertEquals(1, Expr_474_list.size());
		//474
		final AdditiveExpression AdditiveExpression_475_Var
		 = (AdditiveExpression)Expr_474_list.get(0);
		Assert.assertNotNull(AdditiveExpression_475_Var
		);
		final EList<? extends EObject> Expr_475_list = AdditiveExpression_475_Var
		.getExpr();
		Assert.assertNotNull(Expr_475_list);
		Assert.assertEquals(1, Expr_475_list.size());
		//475
		final MultiplicativeExpression MultiplicativeExpression_476_Var
		 = (MultiplicativeExpression)Expr_475_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_476_Var
		);
		final EList<? extends EObject> Expr_476_list = MultiplicativeExpression_476_Var
		.getExpr();
		Assert.assertNotNull(Expr_476_list);
		Assert.assertEquals(1, Expr_476_list.size());
		//476
		final CastExpression CastExpression_477_Var
		 = (CastExpression)Expr_476_list.get(0);
		Assert.assertNotNull(CastExpression_477_Var
		);
		//477
		final UnaryExpression UnaryExpression_478_Var
		 = (UnaryExpression)CastExpression_477_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_478_Var
		);
		//478
		final PostfixExpression PostfixExpression_479_Var
		 = (PostfixExpression)UnaryExpression_478_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_479_Var
		);
		final EList<? extends EObject> Expr_479_list = PostfixExpression_479_Var
		.getExpr();
		Assert.assertNotNull(Expr_479_list);
		Assert.assertEquals(1, Expr_479_list.size());
		//479
		final PrimaryExpression PrimaryExpression_480_Var
		 = (PrimaryExpression)Expr_479_list.get(0);
		Assert.assertNotNull(PrimaryExpression_480_Var
		);
		//480
		final Constant Constant_481_Var
		 = (Constant)PrimaryExpression_480_Var
		.getConst();
		Assert.assertNotNull(Constant_481_Var
		);
		Assert.assertEquals("0.56789", Constant_481_Var
		.getFloat());
		Assert.assertEquals(";", ExpressionStatement_458_Var
		.getSemi());
		//481
		final Statement Statement_482_Var
		 = (Statement)Statement_94_list.get(8);
		Assert.assertNotNull(Statement_482_Var
		);
		//482
		final ExpressionStatement ExpressionStatement_483_Var
		 = (ExpressionStatement)Statement_482_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_483_Var
		);
		//483
		final Expression Expression_484_Var
		 = (Expression)ExpressionStatement_483_Var
		.getExpression();
		Assert.assertNotNull(Expression_484_Var
		);
		final EList<? extends EObject> ExprExpr_484_list = Expression_484_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_484_list);
		Assert.assertEquals(1, ExprExpr_484_list.size());
		//484
		final AssignmentExpression AssignmentExpression_485_Var
		 = (AssignmentExpression)ExprExpr_484_list.get(0);
		Assert.assertNotNull(AssignmentExpression_485_Var
		);
		//485
		final ConditionalExpression ConditionalExpression_486_Var
		 = (ConditionalExpression)AssignmentExpression_485_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_486_Var
		);
		//486
		final LogicalOrExpression LogicalOrExpression_487_Var
		 = (LogicalOrExpression)ConditionalExpression_486_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_487_Var
		);
		final EList<? extends EObject> Expr_487_list = LogicalOrExpression_487_Var
		.getExpr();
		Assert.assertNotNull(Expr_487_list);
		Assert.assertEquals(1, Expr_487_list.size());
		//487
		final LogicalAndExpression LogicalAndExpression_488_Var
		 = (LogicalAndExpression)Expr_487_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_488_Var
		);
		final EList<? extends EObject> Expr_488_list = LogicalAndExpression_488_Var
		.getExpr();
		Assert.assertNotNull(Expr_488_list);
		Assert.assertEquals(1, Expr_488_list.size());
		//488
		final InclusiveOrExpression InclusiveOrExpression_489_Var
		 = (InclusiveOrExpression)Expr_488_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_489_Var
		);
		final EList<? extends EObject> Expr_489_list = InclusiveOrExpression_489_Var
		.getExpr();
		Assert.assertNotNull(Expr_489_list);
		Assert.assertEquals(1, Expr_489_list.size());
		//489
		final ExclusiveOrExpression ExclusiveOrExpression_490_Var
		 = (ExclusiveOrExpression)Expr_489_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_490_Var
		);
		final EList<? extends EObject> Expr_490_list = ExclusiveOrExpression_490_Var
		.getExpr();
		Assert.assertNotNull(Expr_490_list);
		Assert.assertEquals(1, Expr_490_list.size());
		//490
		final AndExpression AndExpression_491_Var
		 = (AndExpression)Expr_490_list.get(0);
		Assert.assertNotNull(AndExpression_491_Var
		);
		final EList<? extends EObject> Expr_491_list = AndExpression_491_Var
		.getExpr();
		Assert.assertNotNull(Expr_491_list);
		Assert.assertEquals(1, Expr_491_list.size());
		//491
		final EqualityExpression EqualityExpression_492_Var
		 = (EqualityExpression)Expr_491_list.get(0);
		Assert.assertNotNull(EqualityExpression_492_Var
		);
		final EList<? extends EObject> Expr_492_list = EqualityExpression_492_Var
		.getExpr();
		Assert.assertNotNull(Expr_492_list);
		Assert.assertEquals(1, Expr_492_list.size());
		//492
		final RelationalExpression RelationalExpression_493_Var
		 = (RelationalExpression)Expr_492_list.get(0);
		Assert.assertNotNull(RelationalExpression_493_Var
		);
		final EList<? extends EObject> Expr_493_list = RelationalExpression_493_Var
		.getExpr();
		Assert.assertNotNull(Expr_493_list);
		Assert.assertEquals(1, Expr_493_list.size());
		//493
		final ShiftExpression ShiftExpression_494_Var
		 = (ShiftExpression)Expr_493_list.get(0);
		Assert.assertNotNull(ShiftExpression_494_Var
		);
		final EList<? extends EObject> Expr_494_list = ShiftExpression_494_Var
		.getExpr();
		Assert.assertNotNull(Expr_494_list);
		Assert.assertEquals(1, Expr_494_list.size());
		//494
		final AdditiveExpression AdditiveExpression_495_Var
		 = (AdditiveExpression)Expr_494_list.get(0);
		Assert.assertNotNull(AdditiveExpression_495_Var
		);
		final EList<? extends EObject> Expr_495_list = AdditiveExpression_495_Var
		.getExpr();
		Assert.assertNotNull(Expr_495_list);
		Assert.assertEquals(1, Expr_495_list.size());
		//495
		final MultiplicativeExpression MultiplicativeExpression_496_Var
		 = (MultiplicativeExpression)Expr_495_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_496_Var
		);
		final EList<? extends EObject> Expr_496_list = MultiplicativeExpression_496_Var
		.getExpr();
		Assert.assertNotNull(Expr_496_list);
		Assert.assertEquals(1, Expr_496_list.size());
		//496
		final CastExpression CastExpression_497_Var
		 = (CastExpression)Expr_496_list.get(0);
		Assert.assertNotNull(CastExpression_497_Var
		);
		//497
		final UnaryExpression UnaryExpression_498_Var
		 = (UnaryExpression)CastExpression_497_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_498_Var
		);
		//498
		final PostfixExpression PostfixExpression_499_Var
		 = (PostfixExpression)UnaryExpression_498_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_499_Var
		);
		final EList<? extends EObject> Expr_499_list = PostfixExpression_499_Var
		.getExpr();
		Assert.assertNotNull(Expr_499_list);
		Assert.assertEquals(1, Expr_499_list.size());
		//499
		final PrimaryExpression PrimaryExpression_500_Var
		 = (PrimaryExpression)Expr_499_list.get(0);
		Assert.assertNotNull(PrimaryExpression_500_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_500_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_500_list = PostfixExpression_499_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_500_list);
		Assert.assertEquals(1, ArgumentExpressionList_500_list.size());
		//500
		final ArgumentExpressionList ArgumentExpressionList_501_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_500_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_501_Var
		);
		final EList<? extends EObject> Expr_501_list = ArgumentExpressionList_501_Var
		.getExpr();
		Assert.assertNotNull(Expr_501_list);
		Assert.assertEquals(2, Expr_501_list.size());
		//501
		final AssignmentExpression AssignmentExpression_502_Var
		 = (AssignmentExpression)Expr_501_list.get(0);
		Assert.assertNotNull(AssignmentExpression_502_Var
		);
		//502
		final ConditionalExpression ConditionalExpression_503_Var
		 = (ConditionalExpression)AssignmentExpression_502_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_503_Var
		);
		//503
		final LogicalOrExpression LogicalOrExpression_504_Var
		 = (LogicalOrExpression)ConditionalExpression_503_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_504_Var
		);
		final EList<? extends EObject> Expr_504_list = LogicalOrExpression_504_Var
		.getExpr();
		Assert.assertNotNull(Expr_504_list);
		Assert.assertEquals(1, Expr_504_list.size());
		//504
		final LogicalAndExpression LogicalAndExpression_505_Var
		 = (LogicalAndExpression)Expr_504_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_505_Var
		);
		final EList<? extends EObject> Expr_505_list = LogicalAndExpression_505_Var
		.getExpr();
		Assert.assertNotNull(Expr_505_list);
		Assert.assertEquals(1, Expr_505_list.size());
		//505
		final InclusiveOrExpression InclusiveOrExpression_506_Var
		 = (InclusiveOrExpression)Expr_505_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_506_Var
		);
		final EList<? extends EObject> Expr_506_list = InclusiveOrExpression_506_Var
		.getExpr();
		Assert.assertNotNull(Expr_506_list);
		Assert.assertEquals(1, Expr_506_list.size());
		//506
		final ExclusiveOrExpression ExclusiveOrExpression_507_Var
		 = (ExclusiveOrExpression)Expr_506_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_507_Var
		);
		final EList<? extends EObject> Expr_507_list = ExclusiveOrExpression_507_Var
		.getExpr();
		Assert.assertNotNull(Expr_507_list);
		Assert.assertEquals(1, Expr_507_list.size());
		//507
		final AndExpression AndExpression_508_Var
		 = (AndExpression)Expr_507_list.get(0);
		Assert.assertNotNull(AndExpression_508_Var
		);
		final EList<? extends EObject> Expr_508_list = AndExpression_508_Var
		.getExpr();
		Assert.assertNotNull(Expr_508_list);
		Assert.assertEquals(1, Expr_508_list.size());
		//508
		final EqualityExpression EqualityExpression_509_Var
		 = (EqualityExpression)Expr_508_list.get(0);
		Assert.assertNotNull(EqualityExpression_509_Var
		);
		final EList<? extends EObject> Expr_509_list = EqualityExpression_509_Var
		.getExpr();
		Assert.assertNotNull(Expr_509_list);
		Assert.assertEquals(1, Expr_509_list.size());
		//509
		final RelationalExpression RelationalExpression_510_Var
		 = (RelationalExpression)Expr_509_list.get(0);
		Assert.assertNotNull(RelationalExpression_510_Var
		);
		final EList<? extends EObject> Expr_510_list = RelationalExpression_510_Var
		.getExpr();
		Assert.assertNotNull(Expr_510_list);
		Assert.assertEquals(1, Expr_510_list.size());
		//510
		final ShiftExpression ShiftExpression_511_Var
		 = (ShiftExpression)Expr_510_list.get(0);
		Assert.assertNotNull(ShiftExpression_511_Var
		);
		final EList<? extends EObject> Expr_511_list = ShiftExpression_511_Var
		.getExpr();
		Assert.assertNotNull(Expr_511_list);
		Assert.assertEquals(1, Expr_511_list.size());
		//511
		final AdditiveExpression AdditiveExpression_512_Var
		 = (AdditiveExpression)Expr_511_list.get(0);
		Assert.assertNotNull(AdditiveExpression_512_Var
		);
		final EList<? extends EObject> Expr_512_list = AdditiveExpression_512_Var
		.getExpr();
		Assert.assertNotNull(Expr_512_list);
		Assert.assertEquals(1, Expr_512_list.size());
		//512
		final MultiplicativeExpression MultiplicativeExpression_513_Var
		 = (MultiplicativeExpression)Expr_512_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_513_Var
		);
		final EList<? extends EObject> Expr_513_list = MultiplicativeExpression_513_Var
		.getExpr();
		Assert.assertNotNull(Expr_513_list);
		Assert.assertEquals(1, Expr_513_list.size());
		//513
		final CastExpression CastExpression_514_Var
		 = (CastExpression)Expr_513_list.get(0);
		Assert.assertNotNull(CastExpression_514_Var
		);
		//514
		final UnaryExpression UnaryExpression_515_Var
		 = (UnaryExpression)CastExpression_514_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_515_Var
		);
		//515
		final PostfixExpression PostfixExpression_516_Var
		 = (PostfixExpression)UnaryExpression_515_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_516_Var
		);
		final EList<? extends EObject> Expr_516_list = PostfixExpression_516_Var
		.getExpr();
		Assert.assertNotNull(Expr_516_list);
		Assert.assertEquals(1, Expr_516_list.size());
		//516
		final PrimaryExpression PrimaryExpression_517_Var
		 = (PrimaryExpression)Expr_516_list.get(0);
		Assert.assertNotNull(PrimaryExpression_517_Var
		);
		//517
		final Constant Constant_518_Var
		 = (Constant)PrimaryExpression_517_Var
		.getConst();
		Assert.assertNotNull(Constant_518_Var
		);
		Assert.assertEquals("\"number.numChar(as decimal)=%d\\n\"", Constant_518_Var
		.getStr());
		//518
		final AssignmentExpression AssignmentExpression_519_Var
		 = (AssignmentExpression)Expr_501_list.get(1);
		Assert.assertNotNull(AssignmentExpression_519_Var
		);
		//519
		final ConditionalExpression ConditionalExpression_520_Var
		 = (ConditionalExpression)AssignmentExpression_519_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_520_Var
		);
		//520
		final LogicalOrExpression LogicalOrExpression_521_Var
		 = (LogicalOrExpression)ConditionalExpression_520_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_521_Var
		);
		final EList<? extends EObject> Expr_521_list = LogicalOrExpression_521_Var
		.getExpr();
		Assert.assertNotNull(Expr_521_list);
		Assert.assertEquals(1, Expr_521_list.size());
		//521
		final LogicalAndExpression LogicalAndExpression_522_Var
		 = (LogicalAndExpression)Expr_521_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_522_Var
		);
		final EList<? extends EObject> Expr_522_list = LogicalAndExpression_522_Var
		.getExpr();
		Assert.assertNotNull(Expr_522_list);
		Assert.assertEquals(1, Expr_522_list.size());
		//522
		final InclusiveOrExpression InclusiveOrExpression_523_Var
		 = (InclusiveOrExpression)Expr_522_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_523_Var
		);
		final EList<? extends EObject> Expr_523_list = InclusiveOrExpression_523_Var
		.getExpr();
		Assert.assertNotNull(Expr_523_list);
		Assert.assertEquals(1, Expr_523_list.size());
		//523
		final ExclusiveOrExpression ExclusiveOrExpression_524_Var
		 = (ExclusiveOrExpression)Expr_523_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_524_Var
		);
		final EList<? extends EObject> Expr_524_list = ExclusiveOrExpression_524_Var
		.getExpr();
		Assert.assertNotNull(Expr_524_list);
		Assert.assertEquals(1, Expr_524_list.size());
		//524
		final AndExpression AndExpression_525_Var
		 = (AndExpression)Expr_524_list.get(0);
		Assert.assertNotNull(AndExpression_525_Var
		);
		final EList<? extends EObject> Expr_525_list = AndExpression_525_Var
		.getExpr();
		Assert.assertNotNull(Expr_525_list);
		Assert.assertEquals(1, Expr_525_list.size());
		//525
		final EqualityExpression EqualityExpression_526_Var
		 = (EqualityExpression)Expr_525_list.get(0);
		Assert.assertNotNull(EqualityExpression_526_Var
		);
		final EList<? extends EObject> Expr_526_list = EqualityExpression_526_Var
		.getExpr();
		Assert.assertNotNull(Expr_526_list);
		Assert.assertEquals(1, Expr_526_list.size());
		//526
		final RelationalExpression RelationalExpression_527_Var
		 = (RelationalExpression)Expr_526_list.get(0);
		Assert.assertNotNull(RelationalExpression_527_Var
		);
		final EList<? extends EObject> Expr_527_list = RelationalExpression_527_Var
		.getExpr();
		Assert.assertNotNull(Expr_527_list);
		Assert.assertEquals(1, Expr_527_list.size());
		//527
		final ShiftExpression ShiftExpression_528_Var
		 = (ShiftExpression)Expr_527_list.get(0);
		Assert.assertNotNull(ShiftExpression_528_Var
		);
		final EList<? extends EObject> Expr_528_list = ShiftExpression_528_Var
		.getExpr();
		Assert.assertNotNull(Expr_528_list);
		Assert.assertEquals(1, Expr_528_list.size());
		//528
		final AdditiveExpression AdditiveExpression_529_Var
		 = (AdditiveExpression)Expr_528_list.get(0);
		Assert.assertNotNull(AdditiveExpression_529_Var
		);
		final EList<? extends EObject> Expr_529_list = AdditiveExpression_529_Var
		.getExpr();
		Assert.assertNotNull(Expr_529_list);
		Assert.assertEquals(1, Expr_529_list.size());
		//529
		final MultiplicativeExpression MultiplicativeExpression_530_Var
		 = (MultiplicativeExpression)Expr_529_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_530_Var
		);
		final EList<? extends EObject> Expr_530_list = MultiplicativeExpression_530_Var
		.getExpr();
		Assert.assertNotNull(Expr_530_list);
		Assert.assertEquals(1, Expr_530_list.size());
		//530
		final CastExpression CastExpression_531_Var
		 = (CastExpression)Expr_530_list.get(0);
		Assert.assertNotNull(CastExpression_531_Var
		);
		//531
		final UnaryExpression UnaryExpression_532_Var
		 = (UnaryExpression)CastExpression_531_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_532_Var
		);
		//532
		final PostfixExpression PostfixExpression_533_Var
		 = (PostfixExpression)UnaryExpression_532_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_533_Var
		);
		final EList<? extends EObject> Expr_533_list = PostfixExpression_533_Var
		.getExpr();
		Assert.assertNotNull(Expr_533_list);
		Assert.assertEquals(1, Expr_533_list.size());
		//533
		final PrimaryExpression PrimaryExpression_534_Var
		 = (PrimaryExpression)Expr_533_list.get(0);
		Assert.assertNotNull(PrimaryExpression_534_Var
		);
		Assert.assertEquals("number", PrimaryExpression_534_Var
		.getId());
		Assert.assertEquals("[.]", PostfixExpression_533_Var
		.getDot().toString());
		Assert.assertEquals("[numChar]", PostfixExpression_533_Var
		.getId().toString());
		Assert.assertEquals(";", ExpressionStatement_483_Var
		.getSemi());
		//534
		final Statement Statement_535_Var
		 = (Statement)Statement_94_list.get(9);
		Assert.assertNotNull(Statement_535_Var
		);
		//535
		final ExpressionStatement ExpressionStatement_536_Var
		 = (ExpressionStatement)Statement_535_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_536_Var
		);
		//536
		final Expression Expression_537_Var
		 = (Expression)ExpressionStatement_536_Var
		.getExpression();
		Assert.assertNotNull(Expression_537_Var
		);
		final EList<? extends EObject> ExprExpr_537_list = Expression_537_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_537_list);
		Assert.assertEquals(1, ExprExpr_537_list.size());
		//537
		final AssignmentExpression AssignmentExpression_538_Var
		 = (AssignmentExpression)ExprExpr_537_list.get(0);
		Assert.assertNotNull(AssignmentExpression_538_Var
		);
		//538
		final ConditionalExpression ConditionalExpression_539_Var
		 = (ConditionalExpression)AssignmentExpression_538_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_539_Var
		);
		//539
		final LogicalOrExpression LogicalOrExpression_540_Var
		 = (LogicalOrExpression)ConditionalExpression_539_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_540_Var
		);
		final EList<? extends EObject> Expr_540_list = LogicalOrExpression_540_Var
		.getExpr();
		Assert.assertNotNull(Expr_540_list);
		Assert.assertEquals(1, Expr_540_list.size());
		//540
		final LogicalAndExpression LogicalAndExpression_541_Var
		 = (LogicalAndExpression)Expr_540_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_541_Var
		);
		final EList<? extends EObject> Expr_541_list = LogicalAndExpression_541_Var
		.getExpr();
		Assert.assertNotNull(Expr_541_list);
		Assert.assertEquals(1, Expr_541_list.size());
		//541
		final InclusiveOrExpression InclusiveOrExpression_542_Var
		 = (InclusiveOrExpression)Expr_541_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_542_Var
		);
		final EList<? extends EObject> Expr_542_list = InclusiveOrExpression_542_Var
		.getExpr();
		Assert.assertNotNull(Expr_542_list);
		Assert.assertEquals(1, Expr_542_list.size());
		//542
		final ExclusiveOrExpression ExclusiveOrExpression_543_Var
		 = (ExclusiveOrExpression)Expr_542_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_543_Var
		);
		final EList<? extends EObject> Expr_543_list = ExclusiveOrExpression_543_Var
		.getExpr();
		Assert.assertNotNull(Expr_543_list);
		Assert.assertEquals(1, Expr_543_list.size());
		//543
		final AndExpression AndExpression_544_Var
		 = (AndExpression)Expr_543_list.get(0);
		Assert.assertNotNull(AndExpression_544_Var
		);
		final EList<? extends EObject> Expr_544_list = AndExpression_544_Var
		.getExpr();
		Assert.assertNotNull(Expr_544_list);
		Assert.assertEquals(1, Expr_544_list.size());
		//544
		final EqualityExpression EqualityExpression_545_Var
		 = (EqualityExpression)Expr_544_list.get(0);
		Assert.assertNotNull(EqualityExpression_545_Var
		);
		final EList<? extends EObject> Expr_545_list = EqualityExpression_545_Var
		.getExpr();
		Assert.assertNotNull(Expr_545_list);
		Assert.assertEquals(1, Expr_545_list.size());
		//545
		final RelationalExpression RelationalExpression_546_Var
		 = (RelationalExpression)Expr_545_list.get(0);
		Assert.assertNotNull(RelationalExpression_546_Var
		);
		final EList<? extends EObject> Expr_546_list = RelationalExpression_546_Var
		.getExpr();
		Assert.assertNotNull(Expr_546_list);
		Assert.assertEquals(1, Expr_546_list.size());
		//546
		final ShiftExpression ShiftExpression_547_Var
		 = (ShiftExpression)Expr_546_list.get(0);
		Assert.assertNotNull(ShiftExpression_547_Var
		);
		final EList<? extends EObject> Expr_547_list = ShiftExpression_547_Var
		.getExpr();
		Assert.assertNotNull(Expr_547_list);
		Assert.assertEquals(1, Expr_547_list.size());
		//547
		final AdditiveExpression AdditiveExpression_548_Var
		 = (AdditiveExpression)Expr_547_list.get(0);
		Assert.assertNotNull(AdditiveExpression_548_Var
		);
		final EList<? extends EObject> Expr_548_list = AdditiveExpression_548_Var
		.getExpr();
		Assert.assertNotNull(Expr_548_list);
		Assert.assertEquals(1, Expr_548_list.size());
		//548
		final MultiplicativeExpression MultiplicativeExpression_549_Var
		 = (MultiplicativeExpression)Expr_548_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_549_Var
		);
		final EList<? extends EObject> Expr_549_list = MultiplicativeExpression_549_Var
		.getExpr();
		Assert.assertNotNull(Expr_549_list);
		Assert.assertEquals(1, Expr_549_list.size());
		//549
		final CastExpression CastExpression_550_Var
		 = (CastExpression)Expr_549_list.get(0);
		Assert.assertNotNull(CastExpression_550_Var
		);
		//550
		final UnaryExpression UnaryExpression_551_Var
		 = (UnaryExpression)CastExpression_550_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_551_Var
		);
		//551
		final PostfixExpression PostfixExpression_552_Var
		 = (PostfixExpression)UnaryExpression_551_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_552_Var
		);
		final EList<? extends EObject> Expr_552_list = PostfixExpression_552_Var
		.getExpr();
		Assert.assertNotNull(Expr_552_list);
		Assert.assertEquals(1, Expr_552_list.size());
		//552
		final PrimaryExpression PrimaryExpression_553_Var
		 = (PrimaryExpression)Expr_552_list.get(0);
		Assert.assertNotNull(PrimaryExpression_553_Var
		);
		Assert.assertEquals("printf", PrimaryExpression_553_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_553_list = PostfixExpression_552_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_553_list);
		Assert.assertEquals(1, ArgumentExpressionList_553_list.size());
		//553
		final ArgumentExpressionList ArgumentExpressionList_554_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_553_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_554_Var
		);
		final EList<? extends EObject> Expr_554_list = ArgumentExpressionList_554_Var
		.getExpr();
		Assert.assertNotNull(Expr_554_list);
		Assert.assertEquals(2, Expr_554_list.size());
		//554
		final AssignmentExpression AssignmentExpression_555_Var
		 = (AssignmentExpression)Expr_554_list.get(0);
		Assert.assertNotNull(AssignmentExpression_555_Var
		);
		//555
		final ConditionalExpression ConditionalExpression_556_Var
		 = (ConditionalExpression)AssignmentExpression_555_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_556_Var
		);
		//556
		final LogicalOrExpression LogicalOrExpression_557_Var
		 = (LogicalOrExpression)ConditionalExpression_556_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_557_Var
		);
		final EList<? extends EObject> Expr_557_list = LogicalOrExpression_557_Var
		.getExpr();
		Assert.assertNotNull(Expr_557_list);
		Assert.assertEquals(1, Expr_557_list.size());
		//557
		final LogicalAndExpression LogicalAndExpression_558_Var
		 = (LogicalAndExpression)Expr_557_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_558_Var
		);
		final EList<? extends EObject> Expr_558_list = LogicalAndExpression_558_Var
		.getExpr();
		Assert.assertNotNull(Expr_558_list);
		Assert.assertEquals(1, Expr_558_list.size());
		//558
		final InclusiveOrExpression InclusiveOrExpression_559_Var
		 = (InclusiveOrExpression)Expr_558_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_559_Var
		);
		final EList<? extends EObject> Expr_559_list = InclusiveOrExpression_559_Var
		.getExpr();
		Assert.assertNotNull(Expr_559_list);
		Assert.assertEquals(1, Expr_559_list.size());
		//559
		final ExclusiveOrExpression ExclusiveOrExpression_560_Var
		 = (ExclusiveOrExpression)Expr_559_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_560_Var
		);
		final EList<? extends EObject> Expr_560_list = ExclusiveOrExpression_560_Var
		.getExpr();
		Assert.assertNotNull(Expr_560_list);
		Assert.assertEquals(1, Expr_560_list.size());
		//560
		final AndExpression AndExpression_561_Var
		 = (AndExpression)Expr_560_list.get(0);
		Assert.assertNotNull(AndExpression_561_Var
		);
		final EList<? extends EObject> Expr_561_list = AndExpression_561_Var
		.getExpr();
		Assert.assertNotNull(Expr_561_list);
		Assert.assertEquals(1, Expr_561_list.size());
		//561
		final EqualityExpression EqualityExpression_562_Var
		 = (EqualityExpression)Expr_561_list.get(0);
		Assert.assertNotNull(EqualityExpression_562_Var
		);
		final EList<? extends EObject> Expr_562_list = EqualityExpression_562_Var
		.getExpr();
		Assert.assertNotNull(Expr_562_list);
		Assert.assertEquals(1, Expr_562_list.size());
		//562
		final RelationalExpression RelationalExpression_563_Var
		 = (RelationalExpression)Expr_562_list.get(0);
		Assert.assertNotNull(RelationalExpression_563_Var
		);
		final EList<? extends EObject> Expr_563_list = RelationalExpression_563_Var
		.getExpr();
		Assert.assertNotNull(Expr_563_list);
		Assert.assertEquals(1, Expr_563_list.size());
		//563
		final ShiftExpression ShiftExpression_564_Var
		 = (ShiftExpression)Expr_563_list.get(0);
		Assert.assertNotNull(ShiftExpression_564_Var
		);
		final EList<? extends EObject> Expr_564_list = ShiftExpression_564_Var
		.getExpr();
		Assert.assertNotNull(Expr_564_list);
		Assert.assertEquals(1, Expr_564_list.size());
		//564
		final AdditiveExpression AdditiveExpression_565_Var
		 = (AdditiveExpression)Expr_564_list.get(0);
		Assert.assertNotNull(AdditiveExpression_565_Var
		);
		final EList<? extends EObject> Expr_565_list = AdditiveExpression_565_Var
		.getExpr();
		Assert.assertNotNull(Expr_565_list);
		Assert.assertEquals(1, Expr_565_list.size());
		//565
		final MultiplicativeExpression MultiplicativeExpression_566_Var
		 = (MultiplicativeExpression)Expr_565_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_566_Var
		);
		final EList<? extends EObject> Expr_566_list = MultiplicativeExpression_566_Var
		.getExpr();
		Assert.assertNotNull(Expr_566_list);
		Assert.assertEquals(1, Expr_566_list.size());
		//566
		final CastExpression CastExpression_567_Var
		 = (CastExpression)Expr_566_list.get(0);
		Assert.assertNotNull(CastExpression_567_Var
		);
		//567
		final UnaryExpression UnaryExpression_568_Var
		 = (UnaryExpression)CastExpression_567_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_568_Var
		);
		//568
		final PostfixExpression PostfixExpression_569_Var
		 = (PostfixExpression)UnaryExpression_568_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_569_Var
		);
		final EList<? extends EObject> Expr_569_list = PostfixExpression_569_Var
		.getExpr();
		Assert.assertNotNull(Expr_569_list);
		Assert.assertEquals(1, Expr_569_list.size());
		//569
		final PrimaryExpression PrimaryExpression_570_Var
		 = (PrimaryExpression)Expr_569_list.get(0);
		Assert.assertNotNull(PrimaryExpression_570_Var
		);
		//570
		final Constant Constant_571_Var
		 = (Constant)PrimaryExpression_570_Var
		.getConst();
		Assert.assertNotNull(Constant_571_Var
		);
		Assert.assertEquals("\"number.numFloat=%f\\n\"", Constant_571_Var
		.getStr());
		//571
		final AssignmentExpression AssignmentExpression_572_Var
		 = (AssignmentExpression)Expr_554_list.get(1);
		Assert.assertNotNull(AssignmentExpression_572_Var
		);
		//572
		final ConditionalExpression ConditionalExpression_573_Var
		 = (ConditionalExpression)AssignmentExpression_572_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_573_Var
		);
		//573
		final LogicalOrExpression LogicalOrExpression_574_Var
		 = (LogicalOrExpression)ConditionalExpression_573_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_574_Var
		);
		final EList<? extends EObject> Expr_574_list = LogicalOrExpression_574_Var
		.getExpr();
		Assert.assertNotNull(Expr_574_list);
		Assert.assertEquals(1, Expr_574_list.size());
		//574
		final LogicalAndExpression LogicalAndExpression_575_Var
		 = (LogicalAndExpression)Expr_574_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_575_Var
		);
		final EList<? extends EObject> Expr_575_list = LogicalAndExpression_575_Var
		.getExpr();
		Assert.assertNotNull(Expr_575_list);
		Assert.assertEquals(1, Expr_575_list.size());
		//575
		final InclusiveOrExpression InclusiveOrExpression_576_Var
		 = (InclusiveOrExpression)Expr_575_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_576_Var
		);
		final EList<? extends EObject> Expr_576_list = InclusiveOrExpression_576_Var
		.getExpr();
		Assert.assertNotNull(Expr_576_list);
		Assert.assertEquals(1, Expr_576_list.size());
		//576
		final ExclusiveOrExpression ExclusiveOrExpression_577_Var
		 = (ExclusiveOrExpression)Expr_576_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_577_Var
		);
		final EList<? extends EObject> Expr_577_list = ExclusiveOrExpression_577_Var
		.getExpr();
		Assert.assertNotNull(Expr_577_list);
		Assert.assertEquals(1, Expr_577_list.size());
		//577
		final AndExpression AndExpression_578_Var
		 = (AndExpression)Expr_577_list.get(0);
		Assert.assertNotNull(AndExpression_578_Var
		);
		final EList<? extends EObject> Expr_578_list = AndExpression_578_Var
		.getExpr();
		Assert.assertNotNull(Expr_578_list);
		Assert.assertEquals(1, Expr_578_list.size());
		//578
		final EqualityExpression EqualityExpression_579_Var
		 = (EqualityExpression)Expr_578_list.get(0);
		Assert.assertNotNull(EqualityExpression_579_Var
		);
		final EList<? extends EObject> Expr_579_list = EqualityExpression_579_Var
		.getExpr();
		Assert.assertNotNull(Expr_579_list);
		Assert.assertEquals(1, Expr_579_list.size());
		//579
		final RelationalExpression RelationalExpression_580_Var
		 = (RelationalExpression)Expr_579_list.get(0);
		Assert.assertNotNull(RelationalExpression_580_Var
		);
		final EList<? extends EObject> Expr_580_list = RelationalExpression_580_Var
		.getExpr();
		Assert.assertNotNull(Expr_580_list);
		Assert.assertEquals(1, Expr_580_list.size());
		//580
		final ShiftExpression ShiftExpression_581_Var
		 = (ShiftExpression)Expr_580_list.get(0);
		Assert.assertNotNull(ShiftExpression_581_Var
		);
		final EList<? extends EObject> Expr_581_list = ShiftExpression_581_Var
		.getExpr();
		Assert.assertNotNull(Expr_581_list);
		Assert.assertEquals(1, Expr_581_list.size());
		//581
		final AdditiveExpression AdditiveExpression_582_Var
		 = (AdditiveExpression)Expr_581_list.get(0);
		Assert.assertNotNull(AdditiveExpression_582_Var
		);
		final EList<? extends EObject> Expr_582_list = AdditiveExpression_582_Var
		.getExpr();
		Assert.assertNotNull(Expr_582_list);
		Assert.assertEquals(1, Expr_582_list.size());
		//582
		final MultiplicativeExpression MultiplicativeExpression_583_Var
		 = (MultiplicativeExpression)Expr_582_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_583_Var
		);
		final EList<? extends EObject> Expr_583_list = MultiplicativeExpression_583_Var
		.getExpr();
		Assert.assertNotNull(Expr_583_list);
		Assert.assertEquals(1, Expr_583_list.size());
		//583
		final CastExpression CastExpression_584_Var
		 = (CastExpression)Expr_583_list.get(0);
		Assert.assertNotNull(CastExpression_584_Var
		);
		//584
		final UnaryExpression UnaryExpression_585_Var
		 = (UnaryExpression)CastExpression_584_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_585_Var
		);
		//585
		final PostfixExpression PostfixExpression_586_Var
		 = (PostfixExpression)UnaryExpression_585_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_586_Var
		);
		final EList<? extends EObject> Expr_586_list = PostfixExpression_586_Var
		.getExpr();
		Assert.assertNotNull(Expr_586_list);
		Assert.assertEquals(1, Expr_586_list.size());
		//586
		final PrimaryExpression PrimaryExpression_587_Var
		 = (PrimaryExpression)Expr_586_list.get(0);
		Assert.assertNotNull(PrimaryExpression_587_Var
		);
		Assert.assertEquals("number", PrimaryExpression_587_Var
		.getId());
		Assert.assertEquals("[.]", PostfixExpression_586_Var
		.getDot().toString());
		Assert.assertEquals("[numFloat]", PostfixExpression_586_Var
		.getId().toString());
		Assert.assertEquals(";", ExpressionStatement_536_Var
		.getSemi());
		//587
		final Statement Statement_588_Var
		 = (Statement)Statement_94_list.get(10);
		Assert.assertNotNull(Statement_588_Var
		);
		//588
		final JumpStatement JumpStatement_589_Var
		 = (JumpStatement)Statement_588_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_589_Var
		);
		//589
		final Expression Expression_590_Var
		 = (Expression)JumpStatement_589_Var
		.getExpr();
		Assert.assertNotNull(Expression_590_Var
		);
		final EList<? extends EObject> ExprExpr_590_list = Expression_590_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_590_list);
		Assert.assertEquals(1, ExprExpr_590_list.size());
		//590
		final AssignmentExpression AssignmentExpression_591_Var
		 = (AssignmentExpression)ExprExpr_590_list.get(0);
		Assert.assertNotNull(AssignmentExpression_591_Var
		);
		//591
		final ConditionalExpression ConditionalExpression_592_Var
		 = (ConditionalExpression)AssignmentExpression_591_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_592_Var
		);
		//592
		final LogicalOrExpression LogicalOrExpression_593_Var
		 = (LogicalOrExpression)ConditionalExpression_592_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_593_Var
		);
		final EList<? extends EObject> Expr_593_list = LogicalOrExpression_593_Var
		.getExpr();
		Assert.assertNotNull(Expr_593_list);
		Assert.assertEquals(1, Expr_593_list.size());
		//593
		final LogicalAndExpression LogicalAndExpression_594_Var
		 = (LogicalAndExpression)Expr_593_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_594_Var
		);
		final EList<? extends EObject> Expr_594_list = LogicalAndExpression_594_Var
		.getExpr();
		Assert.assertNotNull(Expr_594_list);
		Assert.assertEquals(1, Expr_594_list.size());
		//594
		final InclusiveOrExpression InclusiveOrExpression_595_Var
		 = (InclusiveOrExpression)Expr_594_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_595_Var
		);
		final EList<? extends EObject> Expr_595_list = InclusiveOrExpression_595_Var
		.getExpr();
		Assert.assertNotNull(Expr_595_list);
		Assert.assertEquals(1, Expr_595_list.size());
		//595
		final ExclusiveOrExpression ExclusiveOrExpression_596_Var
		 = (ExclusiveOrExpression)Expr_595_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_596_Var
		);
		final EList<? extends EObject> Expr_596_list = ExclusiveOrExpression_596_Var
		.getExpr();
		Assert.assertNotNull(Expr_596_list);
		Assert.assertEquals(1, Expr_596_list.size());
		//596
		final AndExpression AndExpression_597_Var
		 = (AndExpression)Expr_596_list.get(0);
		Assert.assertNotNull(AndExpression_597_Var
		);
		final EList<? extends EObject> Expr_597_list = AndExpression_597_Var
		.getExpr();
		Assert.assertNotNull(Expr_597_list);
		Assert.assertEquals(1, Expr_597_list.size());
		//597
		final EqualityExpression EqualityExpression_598_Var
		 = (EqualityExpression)Expr_597_list.get(0);
		Assert.assertNotNull(EqualityExpression_598_Var
		);
		final EList<? extends EObject> Expr_598_list = EqualityExpression_598_Var
		.getExpr();
		Assert.assertNotNull(Expr_598_list);
		Assert.assertEquals(1, Expr_598_list.size());
		//598
		final RelationalExpression RelationalExpression_599_Var
		 = (RelationalExpression)Expr_598_list.get(0);
		Assert.assertNotNull(RelationalExpression_599_Var
		);
		final EList<? extends EObject> Expr_599_list = RelationalExpression_599_Var
		.getExpr();
		Assert.assertNotNull(Expr_599_list);
		Assert.assertEquals(1, Expr_599_list.size());
		//599
		final ShiftExpression ShiftExpression_600_Var
		 = (ShiftExpression)Expr_599_list.get(0);
		Assert.assertNotNull(ShiftExpression_600_Var
		);
		final EList<? extends EObject> Expr_600_list = ShiftExpression_600_Var
		.getExpr();
		Assert.assertNotNull(Expr_600_list);
		Assert.assertEquals(1, Expr_600_list.size());
		//600
		final AdditiveExpression AdditiveExpression_601_Var
		 = (AdditiveExpression)Expr_600_list.get(0);
		Assert.assertNotNull(AdditiveExpression_601_Var
		);
		final EList<? extends EObject> Expr_601_list = AdditiveExpression_601_Var
		.getExpr();
		Assert.assertNotNull(Expr_601_list);
		Assert.assertEquals(1, Expr_601_list.size());
		//601
		final MultiplicativeExpression MultiplicativeExpression_602_Var
		 = (MultiplicativeExpression)Expr_601_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_602_Var
		);
		final EList<? extends EObject> Expr_602_list = MultiplicativeExpression_602_Var
		.getExpr();
		Assert.assertNotNull(Expr_602_list);
		Assert.assertEquals(1, Expr_602_list.size());
		//602
		final CastExpression CastExpression_603_Var
		 = (CastExpression)Expr_602_list.get(0);
		Assert.assertNotNull(CastExpression_603_Var
		);
		//603
		final UnaryExpression UnaryExpression_604_Var
		 = (UnaryExpression)CastExpression_603_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_604_Var
		);
		//604
		final PostfixExpression PostfixExpression_605_Var
		 = (PostfixExpression)UnaryExpression_604_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_605_Var
		);
		final EList<? extends EObject> Expr_605_list = PostfixExpression_605_Var
		.getExpr();
		Assert.assertNotNull(Expr_605_list);
		Assert.assertEquals(1, Expr_605_list.size());
		//605
		final PrimaryExpression PrimaryExpression_606_Var
		 = (PrimaryExpression)Expr_605_list.get(0);
		Assert.assertNotNull(PrimaryExpression_606_Var
		);
		//606
		final Constant Constant_607_Var
		 = (Constant)PrimaryExpression_606_Var
		.getConst();
		Assert.assertNotNull(Constant_607_Var
		);
		Assert.assertEquals("0", Constant_607_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_589_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_589_Var
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


