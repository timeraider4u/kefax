package at.jku.weiner.c.xtexttests;

import com.google.inject.Inject;
import com.google.inject.Provider;

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
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.TypedefName;
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
import at.jku.weiner.c.c.TypedefName;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.Pointer;
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
import at.jku.weiner.c.c.UnaryOperator;
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
import at.jku.weiner.c.c.TypedefName;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.Pointer;
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
import at.jku.weiner.c.c.TypeName;
import at.jku.weiner.c.c.SpecifierQualifierList;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.TypedefName;
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
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.Statement;
import at.jku.weiner.c.c.CompoundStatement;
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
import at.jku.weiner.c.c.UnaryOperator;
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
import at.jku.weiner.c.c.UnaryOperator;
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
public class Test0038_StructAdvanced {
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
		final String lines = string.replaceAll("\n", " ").trim();
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
			"res/Test0038_StructAdvanced.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_LINEDIRECTIVE", 
				"RULE_NEWLINE", 
				"RULE_LINEDIRECTIVE", 
				"RULE_NEWLINE", 
				"RULE_LINEDIRECTIVE", 
				"RULE_NEWLINE", 
				"RULE_NEWLINE", 
				"RULE_KW_TYPEDEF", 
				"RULE_WHITESPACE", 
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
				"RULE_KW_VOID", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_STAR", 
				"RULE_ID", 
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
				"RULE_LEFTPAREN", 
				"RULE_STAR", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
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
				"RULE_ARROW", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_RIGHTBRACE", 
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
				"RULE_WHITESPACE", 
				"RULE_STAR", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_ASSIGN", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_KW_SIZEOF", 
				"RULE_LEFTPAREN", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_IF", 
				"RULE_WHITESPACE", 
				"RULE_LEFTPAREN", 
				"RULE_ID", 
				"RULE_WHITESPACE", 
				"RULE_EQUAL", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_WHITESPACE", 
				"RULE_LEFTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_STRING_LITERAL", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_KW_RETURN", 
				"RULE_WHITESPACE", 
				"RULE_MINUS", 
				"RULE_DECIMAL_LITERAL", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_RIGHTBRACE", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_AND", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
				"RULE_AND", 
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_ARROW", 
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
				"RULE_ARROW", 
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
				"RULE_ID", 
				"RULE_RIGHTPAREN", 
				"RULE_SEMI", 
				"RULE_NEWLINE", 
				"RULE_WHITESPACE", 
				"RULE_ID", 
				"RULE_LEFTPAREN", 
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
			"res/Test0038_StructAdvanced.c");
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
		Assert.assertEquals(5, External_1_list.size());
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
		Assert.assertEquals("typedef", StorageClassSpecifier_5_Var
		.getName());
		//5
		final StructOrUnionSpecifier StructOrUnionSpecifier_6_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_4_list.get(1);
		Assert.assertNotNull(StructOrUnionSpecifier_6_Var
		);
		//6
		final StructOrUnion StructOrUnion_7_Var
		 = (StructOrUnion)StructOrUnionSpecifier_6_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_7_Var
		);
		Assert.assertEquals("struct", StructOrUnion_7_Var
		.getName());
		Assert.assertEquals("empStruct", StructOrUnionSpecifier_6_Var
		.getId());
		//7
		final StructDeclarationList StructDeclarationList_8_Var
		 = (StructDeclarationList)StructOrUnionSpecifier_6_Var
		.getStructDeclList();
		Assert.assertNotNull(StructDeclarationList_8_Var
		);
		final EList<? extends EObject> StructDeclaration_8_list = StructDeclarationList_8_Var
		.getStructDeclaration();
		Assert.assertNotNull(StructDeclaration_8_list);
		Assert.assertEquals(2, StructDeclaration_8_list.size());
		//8
		final StructDeclaration StructDeclaration_9_Var
		 = (StructDeclaration)StructDeclaration_8_list.get(0);
		Assert.assertNotNull(StructDeclaration_9_Var
		);
		//9
		final SpecifierQualifierList SpecifierQualifierList_10_Var
		 = (SpecifierQualifierList)StructDeclaration_9_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_10_Var
		);
		final EList<? extends EObject> TypeSpecifier_10_list = SpecifierQualifierList_10_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_10_list);
		Assert.assertEquals(1, TypeSpecifier_10_list.size());
		//10
		final TypeSpecifier TypeSpecifier_11_Var
		 = (TypeSpecifier)TypeSpecifier_10_list.get(0);
		Assert.assertNotNull(TypeSpecifier_11_Var
		);
		Assert.assertEquals("int", TypeSpecifier_11_Var
		.getName());
		//11
		final StructDeclaratorList StructDeclaratorList_12_Var
		 = (StructDeclaratorList)StructDeclaration_9_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_12_Var
		);
		final EList<? extends EObject> StructDeclarator_12_list = StructDeclaratorList_12_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_12_list);
		Assert.assertEquals(1, StructDeclarator_12_list.size());
		//12
		final StructDeclarator StructDeclarator_13_Var
		 = (StructDeclarator)StructDeclarator_12_list.get(0);
		Assert.assertNotNull(StructDeclarator_13_Var
		);
		//13
		final Declarator Declarator_14_Var
		 = (Declarator)StructDeclarator_13_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_14_Var
		);
		//14
		final DirectDeclarator DirectDeclarator_15_Var
		 = (DirectDeclarator)Declarator_14_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_15_Var
		);
		Assert.assertEquals("id", DirectDeclarator_15_Var
		.getId());
		//15
		final StructDeclaration StructDeclaration_16_Var
		 = (StructDeclaration)StructDeclaration_8_list.get(1);
		Assert.assertNotNull(StructDeclaration_16_Var
		);
		//16
		final SpecifierQualifierList SpecifierQualifierList_17_Var
		 = (SpecifierQualifierList)StructDeclaration_16_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_17_Var
		);
		final EList<? extends EObject> TypeSpecifier_17_list = SpecifierQualifierList_17_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_17_list);
		Assert.assertEquals(1, TypeSpecifier_17_list.size());
		//17
		final TypeSpecifier TypeSpecifier_18_Var
		 = (TypeSpecifier)TypeSpecifier_17_list.get(0);
		Assert.assertNotNull(TypeSpecifier_18_Var
		);
		Assert.assertEquals("char", TypeSpecifier_18_Var
		.getName());
		//18
		final StructDeclaratorList StructDeclaratorList_19_Var
		 = (StructDeclaratorList)StructDeclaration_16_Var
		.getStructDeclarationList();
		Assert.assertNotNull(StructDeclaratorList_19_Var
		);
		final EList<? extends EObject> StructDeclarator_19_list = StructDeclaratorList_19_Var
		.getStructDeclarator();
		Assert.assertNotNull(StructDeclarator_19_list);
		Assert.assertEquals(1, StructDeclarator_19_list.size());
		//19
		final StructDeclarator StructDeclarator_20_Var
		 = (StructDeclarator)StructDeclarator_19_list.get(0);
		Assert.assertNotNull(StructDeclarator_20_Var
		);
		//20
		final Declarator Declarator_21_Var
		 = (Declarator)StructDeclarator_20_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_21_Var
		);
		//21
		final DirectDeclarator DirectDeclarator_22_Var
		 = (DirectDeclarator)Declarator_21_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_22_Var
		);
		Assert.assertEquals("name", DirectDeclarator_22_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_22_list = DirectDeclarator_22_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_22_list);
		Assert.assertEquals(1, DeclaratorSuffix_22_list.size());
		//22
		final DeclaratorSuffix DeclaratorSuffix_23_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_22_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_23_Var
		);
		//23
		final AssignmentExpression AssignmentExpression_24_Var
		 = (AssignmentExpression)DeclaratorSuffix_23_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_24_Var
		);
		//24
		final ConditionalExpression ConditionalExpression_25_Var
		 = (ConditionalExpression)AssignmentExpression_24_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_25_Var
		);
		//25
		final LogicalOrExpression LogicalOrExpression_26_Var
		 = (LogicalOrExpression)ConditionalExpression_25_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_26_Var
		);
		final EList<? extends EObject> Expr_26_list = LogicalOrExpression_26_Var
		.getExpr();
		Assert.assertNotNull(Expr_26_list);
		Assert.assertEquals(1, Expr_26_list.size());
		//26
		final LogicalAndExpression LogicalAndExpression_27_Var
		 = (LogicalAndExpression)Expr_26_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_27_Var
		);
		final EList<? extends EObject> Expr_27_list = LogicalAndExpression_27_Var
		.getExpr();
		Assert.assertNotNull(Expr_27_list);
		Assert.assertEquals(1, Expr_27_list.size());
		//27
		final InclusiveOrExpression InclusiveOrExpression_28_Var
		 = (InclusiveOrExpression)Expr_27_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_28_Var
		);
		final EList<? extends EObject> Expr_28_list = InclusiveOrExpression_28_Var
		.getExpr();
		Assert.assertNotNull(Expr_28_list);
		Assert.assertEquals(1, Expr_28_list.size());
		//28
		final ExclusiveOrExpression ExclusiveOrExpression_29_Var
		 = (ExclusiveOrExpression)Expr_28_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_29_Var
		);
		final EList<? extends EObject> Expr_29_list = ExclusiveOrExpression_29_Var
		.getExpr();
		Assert.assertNotNull(Expr_29_list);
		Assert.assertEquals(1, Expr_29_list.size());
		//29
		final AndExpression AndExpression_30_Var
		 = (AndExpression)Expr_29_list.get(0);
		Assert.assertNotNull(AndExpression_30_Var
		);
		final EList<? extends EObject> Expr_30_list = AndExpression_30_Var
		.getExpr();
		Assert.assertNotNull(Expr_30_list);
		Assert.assertEquals(1, Expr_30_list.size());
		//30
		final EqualityExpression EqualityExpression_31_Var
		 = (EqualityExpression)Expr_30_list.get(0);
		Assert.assertNotNull(EqualityExpression_31_Var
		);
		final EList<? extends EObject> Expr_31_list = EqualityExpression_31_Var
		.getExpr();
		Assert.assertNotNull(Expr_31_list);
		Assert.assertEquals(1, Expr_31_list.size());
		//31
		final RelationalExpression RelationalExpression_32_Var
		 = (RelationalExpression)Expr_31_list.get(0);
		Assert.assertNotNull(RelationalExpression_32_Var
		);
		final EList<? extends EObject> Expr_32_list = RelationalExpression_32_Var
		.getExpr();
		Assert.assertNotNull(Expr_32_list);
		Assert.assertEquals(1, Expr_32_list.size());
		//32
		final ShiftExpression ShiftExpression_33_Var
		 = (ShiftExpression)Expr_32_list.get(0);
		Assert.assertNotNull(ShiftExpression_33_Var
		);
		final EList<? extends EObject> Expr_33_list = ShiftExpression_33_Var
		.getExpr();
		Assert.assertNotNull(Expr_33_list);
		Assert.assertEquals(1, Expr_33_list.size());
		//33
		final AdditiveExpression AdditiveExpression_34_Var
		 = (AdditiveExpression)Expr_33_list.get(0);
		Assert.assertNotNull(AdditiveExpression_34_Var
		);
		final EList<? extends EObject> Expr_34_list = AdditiveExpression_34_Var
		.getExpr();
		Assert.assertNotNull(Expr_34_list);
		Assert.assertEquals(1, Expr_34_list.size());
		//34
		final MultiplicativeExpression MultiplicativeExpression_35_Var
		 = (MultiplicativeExpression)Expr_34_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_35_Var
		);
		final EList<? extends EObject> Expr_35_list = MultiplicativeExpression_35_Var
		.getExpr();
		Assert.assertNotNull(Expr_35_list);
		Assert.assertEquals(1, Expr_35_list.size());
		//35
		final CastExpression CastExpression_36_Var
		 = (CastExpression)Expr_35_list.get(0);
		Assert.assertNotNull(CastExpression_36_Var
		);
		//36
		final UnaryExpression UnaryExpression_37_Var
		 = (UnaryExpression)CastExpression_36_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_37_Var
		);
		//37
		final PostfixExpression PostfixExpression_38_Var
		 = (PostfixExpression)UnaryExpression_37_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_38_Var
		);
		final EList<? extends EObject> Expr_38_list = PostfixExpression_38_Var
		.getExpr();
		Assert.assertNotNull(Expr_38_list);
		Assert.assertEquals(1, Expr_38_list.size());
		//38
		final PrimaryExpression PrimaryExpression_39_Var
		 = (PrimaryExpression)Expr_38_list.get(0);
		Assert.assertNotNull(PrimaryExpression_39_Var
		);
		//39
		final Constant Constant_40_Var
		 = (Constant)PrimaryExpression_39_Var
		.getConst();
		Assert.assertNotNull(Constant_40_Var
		);
		Assert.assertEquals("250", Constant_40_Var
		.getDec());
		final EList<? extends EObject> InitDeclaratorList_40_list = Declaration_3_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_40_list);
		Assert.assertEquals(1, InitDeclaratorList_40_list.size());
		//40
		final InitDeclaratorList InitDeclaratorList_41_Var
		 = (InitDeclaratorList)InitDeclaratorList_40_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_41_Var
		);
		final EList<? extends EObject> InitDeclarator_41_list = InitDeclaratorList_41_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_41_list);
		Assert.assertEquals(1, InitDeclarator_41_list.size());
		//41
		final InitDeclarator InitDeclarator_42_Var
		 = (InitDeclarator)InitDeclarator_41_list.get(0);
		Assert.assertNotNull(InitDeclarator_42_Var
		);
		//42
		final Declarator Declarator_43_Var
		 = (Declarator)InitDeclarator_42_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_43_Var
		);
		//43
		final DirectDeclarator DirectDeclarator_44_Var
		 = (DirectDeclarator)Declarator_43_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_44_Var
		);
		Assert.assertEquals("employee", DirectDeclarator_44_Var
		.getId());
		//44
		final ExternalDeclaration ExternalDeclaration_45_Var
		 = (ExternalDeclaration)External_1_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_45_Var
		);
		//45
		final Declaration Declaration_46_Var
		 = (Declaration)ExternalDeclaration_45_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_46_Var
		);
		//46
		final DeclarationSpecifiers DeclarationSpecifiers_47_Var
		 = (DeclarationSpecifiers)Declaration_46_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_47_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_47_list = DeclarationSpecifiers_47_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_47_list);
		Assert.assertEquals(1, DeclarationSpecifier_47_list.size());
		//47
		final StructOrUnionSpecifier StructOrUnionSpecifier_48_Var
		 = (StructOrUnionSpecifier)DeclarationSpecifier_47_list.get(0);
		Assert.assertNotNull(StructOrUnionSpecifier_48_Var
		);
		//48
		final StructOrUnion StructOrUnion_49_Var
		 = (StructOrUnion)StructOrUnionSpecifier_48_Var
		.getType();
		Assert.assertNotNull(StructOrUnion_49_Var
		);
		Assert.assertEquals("struct", StructOrUnion_49_Var
		.getName());
		Assert.assertEquals("empStruct", StructOrUnionSpecifier_48_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_49_list = Declaration_46_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_49_list);
		Assert.assertEquals(1, InitDeclaratorList_49_list.size());
		//49
		final InitDeclaratorList InitDeclaratorList_50_Var
		 = (InitDeclaratorList)InitDeclaratorList_49_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_50_Var
		);
		final EList<? extends EObject> InitDeclarator_50_list = InitDeclaratorList_50_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_50_list);
		Assert.assertEquals(1, InitDeclarator_50_list.size());
		//50
		final InitDeclarator InitDeclarator_51_Var
		 = (InitDeclarator)InitDeclarator_50_list.get(0);
		Assert.assertNotNull(InitDeclarator_51_Var
		);
		//51
		final Declarator Declarator_52_Var
		 = (Declarator)InitDeclarator_51_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_52_Var
		);
		//52
		final DirectDeclarator DirectDeclarator_53_Var
		 = (DirectDeclarator)Declarator_52_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_53_Var
		);
		Assert.assertEquals("joe", DirectDeclarator_53_Var
		.getId());
		//53
		final Initializer Initializer_54_Var
		 = (Initializer)InitDeclarator_51_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_54_Var
		);
		//54
		final InitializerList InitializerList_55_Var
		 = (InitializerList)Initializer_54_Var
		.getList();
		Assert.assertNotNull(InitializerList_55_Var
		);
		final EList<? extends EObject> Initializer_55_list = InitializerList_55_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_55_list);
		Assert.assertEquals(2, Initializer_55_list.size());
		//55
		final Initializer Initializer_56_Var
		 = (Initializer)Initializer_55_list.get(0);
		Assert.assertNotNull(Initializer_56_Var
		);
		//56
		final AssignmentExpression AssignmentExpression_57_Var
		 = (AssignmentExpression)Initializer_56_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_57_Var
		);
		//57
		final ConditionalExpression ConditionalExpression_58_Var
		 = (ConditionalExpression)AssignmentExpression_57_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_58_Var
		);
		//58
		final LogicalOrExpression LogicalOrExpression_59_Var
		 = (LogicalOrExpression)ConditionalExpression_58_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_59_Var
		);
		final EList<? extends EObject> Expr_59_list = LogicalOrExpression_59_Var
		.getExpr();
		Assert.assertNotNull(Expr_59_list);
		Assert.assertEquals(1, Expr_59_list.size());
		//59
		final LogicalAndExpression LogicalAndExpression_60_Var
		 = (LogicalAndExpression)Expr_59_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_60_Var
		);
		final EList<? extends EObject> Expr_60_list = LogicalAndExpression_60_Var
		.getExpr();
		Assert.assertNotNull(Expr_60_list);
		Assert.assertEquals(1, Expr_60_list.size());
		//60
		final InclusiveOrExpression InclusiveOrExpression_61_Var
		 = (InclusiveOrExpression)Expr_60_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_61_Var
		);
		final EList<? extends EObject> Expr_61_list = InclusiveOrExpression_61_Var
		.getExpr();
		Assert.assertNotNull(Expr_61_list);
		Assert.assertEquals(1, Expr_61_list.size());
		//61
		final ExclusiveOrExpression ExclusiveOrExpression_62_Var
		 = (ExclusiveOrExpression)Expr_61_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_62_Var
		);
		final EList<? extends EObject> Expr_62_list = ExclusiveOrExpression_62_Var
		.getExpr();
		Assert.assertNotNull(Expr_62_list);
		Assert.assertEquals(1, Expr_62_list.size());
		//62
		final AndExpression AndExpression_63_Var
		 = (AndExpression)Expr_62_list.get(0);
		Assert.assertNotNull(AndExpression_63_Var
		);
		final EList<? extends EObject> Expr_63_list = AndExpression_63_Var
		.getExpr();
		Assert.assertNotNull(Expr_63_list);
		Assert.assertEquals(1, Expr_63_list.size());
		//63
		final EqualityExpression EqualityExpression_64_Var
		 = (EqualityExpression)Expr_63_list.get(0);
		Assert.assertNotNull(EqualityExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = EqualityExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final RelationalExpression RelationalExpression_65_Var
		 = (RelationalExpression)Expr_64_list.get(0);
		Assert.assertNotNull(RelationalExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = RelationalExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final ShiftExpression ShiftExpression_66_Var
		 = (ShiftExpression)Expr_65_list.get(0);
		Assert.assertNotNull(ShiftExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = ShiftExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final AdditiveExpression AdditiveExpression_67_Var
		 = (AdditiveExpression)Expr_66_list.get(0);
		Assert.assertNotNull(AdditiveExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = AdditiveExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final MultiplicativeExpression MultiplicativeExpression_68_Var
		 = (MultiplicativeExpression)Expr_67_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = MultiplicativeExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final CastExpression CastExpression_69_Var
		 = (CastExpression)Expr_68_list.get(0);
		Assert.assertNotNull(CastExpression_69_Var
		);
		//69
		final UnaryExpression UnaryExpression_70_Var
		 = (UnaryExpression)CastExpression_69_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_70_Var
		);
		//70
		final PostfixExpression PostfixExpression_71_Var
		 = (PostfixExpression)UnaryExpression_70_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = PostfixExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final PrimaryExpression PrimaryExpression_72_Var
		 = (PrimaryExpression)Expr_71_list.get(0);
		Assert.assertNotNull(PrimaryExpression_72_Var
		);
		//72
		final Constant Constant_73_Var
		 = (Constant)PrimaryExpression_72_Var
		.getConst();
		Assert.assertNotNull(Constant_73_Var
		);
		Assert.assertEquals("0x007", Constant_73_Var
		.getHex());
		//73
		final Initializer Initializer_74_Var
		 = (Initializer)Initializer_55_list.get(1);
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
		Assert.assertEquals("\"Joe Nobody\"", Constant_91_Var
		.getStr());
		//91
		final ExternalDeclaration ExternalDeclaration_92_Var
		 = (ExternalDeclaration)External_1_list.get(2);
		Assert.assertNotNull(ExternalDeclaration_92_Var
		);
		//92
		final Declaration Declaration_93_Var
		 = (Declaration)ExternalDeclaration_92_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_93_Var
		);
		//93
		final DeclarationSpecifiers DeclarationSpecifiers_94_Var
		 = (DeclarationSpecifiers)Declaration_93_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_94_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_94_list = DeclarationSpecifiers_94_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_94_list);
		Assert.assertEquals(1, DeclarationSpecifier_94_list.size());
		//94
		final TypeSpecifier TypeSpecifier_95_Var
		 = (TypeSpecifier)DeclarationSpecifier_94_list.get(0);
		Assert.assertNotNull(TypeSpecifier_95_Var
		);
		//95
		final TypedefName TypedefName_96_Var
		 = (TypedefName)TypeSpecifier_95_Var
		.getType();
		Assert.assertNotNull(TypedefName_96_Var
		);
		Assert.assertEquals("employee", TypedefName_96_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_96_list = Declaration_93_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_96_list);
		Assert.assertEquals(1, InitDeclaratorList_96_list.size());
		//96
		final InitDeclaratorList InitDeclaratorList_97_Var
		 = (InitDeclaratorList)InitDeclaratorList_96_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_97_Var
		);
		final EList<? extends EObject> InitDeclarator_97_list = InitDeclaratorList_97_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_97_list);
		Assert.assertEquals(1, InitDeclarator_97_list.size());
		//97
		final InitDeclarator InitDeclarator_98_Var
		 = (InitDeclarator)InitDeclarator_97_list.get(0);
		Assert.assertNotNull(InitDeclarator_98_Var
		);
		//98
		final Declarator Declarator_99_Var
		 = (Declarator)InitDeclarator_98_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_99_Var
		);
		//99
		final DirectDeclarator DirectDeclarator_100_Var
		 = (DirectDeclarator)Declarator_99_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_100_Var
		);
		Assert.assertEquals("phil", DirectDeclarator_100_Var
		.getId());
		//100
		final Initializer Initializer_101_Var
		 = (Initializer)InitDeclarator_98_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_101_Var
		);
		//101
		final InitializerList InitializerList_102_Var
		 = (InitializerList)Initializer_101_Var
		.getList();
		Assert.assertNotNull(InitializerList_102_Var
		);
		final EList<? extends EObject> Initializer_102_list = InitializerList_102_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_102_list);
		Assert.assertEquals(2, Initializer_102_list.size());
		//102
		final Initializer Initializer_103_Var
		 = (Initializer)Initializer_102_list.get(0);
		Assert.assertNotNull(Initializer_103_Var
		);
		//103
		final AssignmentExpression AssignmentExpression_104_Var
		 = (AssignmentExpression)Initializer_103_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_104_Var
		);
		//104
		final ConditionalExpression ConditionalExpression_105_Var
		 = (ConditionalExpression)AssignmentExpression_104_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_105_Var
		);
		//105
		final LogicalOrExpression LogicalOrExpression_106_Var
		 = (LogicalOrExpression)ConditionalExpression_105_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_106_Var
		);
		final EList<? extends EObject> Expr_106_list = LogicalOrExpression_106_Var
		.getExpr();
		Assert.assertNotNull(Expr_106_list);
		Assert.assertEquals(1, Expr_106_list.size());
		//106
		final LogicalAndExpression LogicalAndExpression_107_Var
		 = (LogicalAndExpression)Expr_106_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_107_Var
		);
		final EList<? extends EObject> Expr_107_list = LogicalAndExpression_107_Var
		.getExpr();
		Assert.assertNotNull(Expr_107_list);
		Assert.assertEquals(1, Expr_107_list.size());
		//107
		final InclusiveOrExpression InclusiveOrExpression_108_Var
		 = (InclusiveOrExpression)Expr_107_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = InclusiveOrExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final ExclusiveOrExpression ExclusiveOrExpression_109_Var
		 = (ExclusiveOrExpression)Expr_108_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_109_Var
		);
		final EList<? extends EObject> Expr_109_list = ExclusiveOrExpression_109_Var
		.getExpr();
		Assert.assertNotNull(Expr_109_list);
		Assert.assertEquals(1, Expr_109_list.size());
		//109
		final AndExpression AndExpression_110_Var
		 = (AndExpression)Expr_109_list.get(0);
		Assert.assertNotNull(AndExpression_110_Var
		);
		final EList<? extends EObject> Expr_110_list = AndExpression_110_Var
		.getExpr();
		Assert.assertNotNull(Expr_110_list);
		Assert.assertEquals(1, Expr_110_list.size());
		//110
		final EqualityExpression EqualityExpression_111_Var
		 = (EqualityExpression)Expr_110_list.get(0);
		Assert.assertNotNull(EqualityExpression_111_Var
		);
		final EList<? extends EObject> Expr_111_list = EqualityExpression_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final RelationalExpression RelationalExpression_112_Var
		 = (RelationalExpression)Expr_111_list.get(0);
		Assert.assertNotNull(RelationalExpression_112_Var
		);
		final EList<? extends EObject> Expr_112_list = RelationalExpression_112_Var
		.getExpr();
		Assert.assertNotNull(Expr_112_list);
		Assert.assertEquals(1, Expr_112_list.size());
		//112
		final ShiftExpression ShiftExpression_113_Var
		 = (ShiftExpression)Expr_112_list.get(0);
		Assert.assertNotNull(ShiftExpression_113_Var
		);
		final EList<? extends EObject> Expr_113_list = ShiftExpression_113_Var
		.getExpr();
		Assert.assertNotNull(Expr_113_list);
		Assert.assertEquals(1, Expr_113_list.size());
		//113
		final AdditiveExpression AdditiveExpression_114_Var
		 = (AdditiveExpression)Expr_113_list.get(0);
		Assert.assertNotNull(AdditiveExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = AdditiveExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final MultiplicativeExpression MultiplicativeExpression_115_Var
		 = (MultiplicativeExpression)Expr_114_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = MultiplicativeExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final CastExpression CastExpression_116_Var
		 = (CastExpression)Expr_115_list.get(0);
		Assert.assertNotNull(CastExpression_116_Var
		);
		//116
		final UnaryExpression UnaryExpression_117_Var
		 = (UnaryExpression)CastExpression_116_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_117_Var
		);
		//117
		final PostfixExpression PostfixExpression_118_Var
		 = (PostfixExpression)UnaryExpression_117_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = PostfixExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final PrimaryExpression PrimaryExpression_119_Var
		 = (PrimaryExpression)Expr_118_list.get(0);
		Assert.assertNotNull(PrimaryExpression_119_Var
		);
		//119
		final Constant Constant_120_Var
		 = (Constant)PrimaryExpression_119_Var
		.getConst();
		Assert.assertNotNull(Constant_120_Var
		);
		Assert.assertEquals("0x008", Constant_120_Var
		.getHex());
		//120
		final Initializer Initializer_121_Var
		 = (Initializer)Initializer_102_list.get(1);
		Assert.assertNotNull(Initializer_121_Var
		);
		//121
		final AssignmentExpression AssignmentExpression_122_Var
		 = (AssignmentExpression)Initializer_121_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_122_Var
		);
		//122
		final ConditionalExpression ConditionalExpression_123_Var
		 = (ConditionalExpression)AssignmentExpression_122_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_123_Var
		);
		//123
		final LogicalOrExpression LogicalOrExpression_124_Var
		 = (LogicalOrExpression)ConditionalExpression_123_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_124_Var
		);
		final EList<? extends EObject> Expr_124_list = LogicalOrExpression_124_Var
		.getExpr();
		Assert.assertNotNull(Expr_124_list);
		Assert.assertEquals(1, Expr_124_list.size());
		//124
		final LogicalAndExpression LogicalAndExpression_125_Var
		 = (LogicalAndExpression)Expr_124_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_125_Var
		);
		final EList<? extends EObject> Expr_125_list = LogicalAndExpression_125_Var
		.getExpr();
		Assert.assertNotNull(Expr_125_list);
		Assert.assertEquals(1, Expr_125_list.size());
		//125
		final InclusiveOrExpression InclusiveOrExpression_126_Var
		 = (InclusiveOrExpression)Expr_125_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = InclusiveOrExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final ExclusiveOrExpression ExclusiveOrExpression_127_Var
		 = (ExclusiveOrExpression)Expr_126_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_127_Var
		);
		final EList<? extends EObject> Expr_127_list = ExclusiveOrExpression_127_Var
		.getExpr();
		Assert.assertNotNull(Expr_127_list);
		Assert.assertEquals(1, Expr_127_list.size());
		//127
		final AndExpression AndExpression_128_Var
		 = (AndExpression)Expr_127_list.get(0);
		Assert.assertNotNull(AndExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = AndExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final EqualityExpression EqualityExpression_129_Var
		 = (EqualityExpression)Expr_128_list.get(0);
		Assert.assertNotNull(EqualityExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = EqualityExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final RelationalExpression RelationalExpression_130_Var
		 = (RelationalExpression)Expr_129_list.get(0);
		Assert.assertNotNull(RelationalExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = RelationalExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final ShiftExpression ShiftExpression_131_Var
		 = (ShiftExpression)Expr_130_list.get(0);
		Assert.assertNotNull(ShiftExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = ShiftExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final AdditiveExpression AdditiveExpression_132_Var
		 = (AdditiveExpression)Expr_131_list.get(0);
		Assert.assertNotNull(AdditiveExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = AdditiveExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final MultiplicativeExpression MultiplicativeExpression_133_Var
		 = (MultiplicativeExpression)Expr_132_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = MultiplicativeExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final CastExpression CastExpression_134_Var
		 = (CastExpression)Expr_133_list.get(0);
		Assert.assertNotNull(CastExpression_134_Var
		);
		//134
		final UnaryExpression UnaryExpression_135_Var
		 = (UnaryExpression)CastExpression_134_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_135_Var
		);
		//135
		final PostfixExpression PostfixExpression_136_Var
		 = (PostfixExpression)UnaryExpression_135_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = PostfixExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final PrimaryExpression PrimaryExpression_137_Var
		 = (PrimaryExpression)Expr_136_list.get(0);
		Assert.assertNotNull(PrimaryExpression_137_Var
		);
		//137
		final Constant Constant_138_Var
		 = (Constant)PrimaryExpression_137_Var
		.getConst();
		Assert.assertNotNull(Constant_138_Var
		);
		Assert.assertEquals("\"Phil Morrison\"", Constant_138_Var
		.getStr());
		//138
		final ExternalDeclaration ExternalDeclaration_139_Var
		 = (ExternalDeclaration)External_1_list.get(3);
		Assert.assertNotNull(ExternalDeclaration_139_Var
		);
		//139
		final FunctionDefHead FunctionDefHead_140_Var
		 = (FunctionDefHead)ExternalDeclaration_139_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_140_Var
		);
		//140
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_141_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_140_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_141_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_141_list = FunctionDeclarationSpecifiers_141_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_141_list);
		Assert.assertEquals(1, DeclarationSpecifier_141_list.size());
		//141
		final TypeSpecifier TypeSpecifier_142_Var
		 = (TypeSpecifier)DeclarationSpecifier_141_list.get(0);
		Assert.assertNotNull(TypeSpecifier_142_Var
		);
		Assert.assertEquals("void", TypeSpecifier_142_Var
		.getName());
		//142
		final Declarator Declarator_143_Var
		 = (Declarator)FunctionDefHead_140_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_143_Var
		);
		//143
		final DirectDeclarator DirectDeclarator_144_Var
		 = (DirectDeclarator)Declarator_143_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_144_Var
		);
		Assert.assertEquals("print", DirectDeclarator_144_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_144_list = DirectDeclarator_144_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_144_list);
		Assert.assertEquals(1, DeclaratorSuffix_144_list.size());
		//144
		final DeclaratorSuffix DeclaratorSuffix_145_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_144_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_145_Var
		);
		//145
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_146_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_145_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_146_Var
		);
		final EList<? extends EObject> ParameterTypeList_146_list = DirectDeclaratorLastSuffix_146_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_146_list);
		Assert.assertEquals(1, ParameterTypeList_146_list.size());
		//146
		final ParameterTypeList ParameterTypeList_147_Var
		 = (ParameterTypeList)ParameterTypeList_146_list.get(0);
		Assert.assertNotNull(ParameterTypeList_147_Var
		);
		//147
		final ParameterList ParameterList_148_Var
		 = (ParameterList)ParameterTypeList_147_Var
		.getList();
		Assert.assertNotNull(ParameterList_148_Var
		);
		final EList<? extends EObject> ParameterDeclaration_148_list = ParameterList_148_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_148_list);
		Assert.assertEquals(1, ParameterDeclaration_148_list.size());
		//148
		final ParameterDeclaration ParameterDeclaration_149_Var
		 = (ParameterDeclaration)ParameterDeclaration_148_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_149_Var
		);
		//149
		final DeclarationSpecifiers DeclarationSpecifiers_150_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_149_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_150_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_150_list = DeclarationSpecifiers_150_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_150_list);
		Assert.assertEquals(1, DeclarationSpecifier_150_list.size());
		//150
		final TypeSpecifier TypeSpecifier_151_Var
		 = (TypeSpecifier)DeclarationSpecifier_150_list.get(0);
		Assert.assertNotNull(TypeSpecifier_151_Var
		);
		//151
		final TypedefName TypedefName_152_Var
		 = (TypedefName)TypeSpecifier_151_Var
		.getType();
		Assert.assertNotNull(TypedefName_152_Var
		);
		Assert.assertEquals("employee", TypedefName_152_Var
		.getId());
		//152
		final Declarator Declarator_153_Var
		 = (Declarator)ParameterDeclaration_149_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_153_Var
		);
		//153
		final DirectDeclarator DirectDeclarator_154_Var
		 = (DirectDeclarator)Declarator_153_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_154_Var
		);
		Assert.assertEquals("emp", DirectDeclarator_154_Var
		.getId());
		//154
		final Pointer Pointer_155_Var
		 = (Pointer)Declarator_153_Var
		.getPointer();
		Assert.assertNotNull(Pointer_155_Var
		);
		Assert.assertEquals("[*]", Pointer_155_Var
		.getStar().toString());
		//155
		final FunctionDefinition FunctionDefinition_156_Var
		 = (FunctionDefinition)ExternalDeclaration_139_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_156_Var
		);
		//156
		final BodyStatement BodyStatement_157_Var
		 = (BodyStatement)FunctionDefinition_156_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_157_Var
		);
		final EList<? extends EObject> BlockList_157_list = BodyStatement_157_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_157_list);
		Assert.assertEquals(1, BlockList_157_list.size());
		//157
		final BlockList BlockList_158_Var
		 = (BlockList)BlockList_157_list.get(0);
		Assert.assertNotNull(BlockList_158_Var
		);
		final EList<? extends EObject> Statement_158_list = BlockList_158_Var
		.getStatement();
		Assert.assertNotNull(Statement_158_list);
		Assert.assertEquals(2, Statement_158_list.size());
		//158
		final Statement Statement_159_Var
		 = (Statement)Statement_158_list.get(0);
		Assert.assertNotNull(Statement_159_Var
		);
		//159
		final ExpressionStatement ExpressionStatement_160_Var
		 = (ExpressionStatement)Statement_159_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_160_Var
		);
		//160
		final Expression Expression_161_Var
		 = (Expression)ExpressionStatement_160_Var
		.getExpression();
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
		Assert.assertEquals("printf", PrimaryExpression_177_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_177_list = PostfixExpression_176_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_177_list);
		Assert.assertEquals(1, ArgumentExpressionList_177_list.size());
		//177
		final ArgumentExpressionList ArgumentExpressionList_178_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_177_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_178_Var
		);
		final EList<? extends EObject> Expr_178_list = ArgumentExpressionList_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(2, Expr_178_list.size());
		//178
		final AssignmentExpression AssignmentExpression_179_Var
		 = (AssignmentExpression)Expr_178_list.get(0);
		Assert.assertNotNull(AssignmentExpression_179_Var
		);
		//179
		final ConditionalExpression ConditionalExpression_180_Var
		 = (ConditionalExpression)AssignmentExpression_179_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_180_Var
		);
		//180
		final LogicalOrExpression LogicalOrExpression_181_Var
		 = (LogicalOrExpression)ConditionalExpression_180_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_181_Var
		);
		final EList<? extends EObject> Expr_181_list = LogicalOrExpression_181_Var
		.getExpr();
		Assert.assertNotNull(Expr_181_list);
		Assert.assertEquals(1, Expr_181_list.size());
		//181
		final LogicalAndExpression LogicalAndExpression_182_Var
		 = (LogicalAndExpression)Expr_181_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_182_Var
		);
		final EList<? extends EObject> Expr_182_list = LogicalAndExpression_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(1, Expr_182_list.size());
		//182
		final InclusiveOrExpression InclusiveOrExpression_183_Var
		 = (InclusiveOrExpression)Expr_182_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = InclusiveOrExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final ExclusiveOrExpression ExclusiveOrExpression_184_Var
		 = (ExclusiveOrExpression)Expr_183_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = ExclusiveOrExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final AndExpression AndExpression_185_Var
		 = (AndExpression)Expr_184_list.get(0);
		Assert.assertNotNull(AndExpression_185_Var
		);
		final EList<? extends EObject> Expr_185_list = AndExpression_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final EqualityExpression EqualityExpression_186_Var
		 = (EqualityExpression)Expr_185_list.get(0);
		Assert.assertNotNull(EqualityExpression_186_Var
		);
		final EList<? extends EObject> Expr_186_list = EqualityExpression_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(1, Expr_186_list.size());
		//186
		final RelationalExpression RelationalExpression_187_Var
		 = (RelationalExpression)Expr_186_list.get(0);
		Assert.assertNotNull(RelationalExpression_187_Var
		);
		final EList<? extends EObject> Expr_187_list = RelationalExpression_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(1, Expr_187_list.size());
		//187
		final ShiftExpression ShiftExpression_188_Var
		 = (ShiftExpression)Expr_187_list.get(0);
		Assert.assertNotNull(ShiftExpression_188_Var
		);
		final EList<? extends EObject> Expr_188_list = ShiftExpression_188_Var
		.getExpr();
		Assert.assertNotNull(Expr_188_list);
		Assert.assertEquals(1, Expr_188_list.size());
		//188
		final AdditiveExpression AdditiveExpression_189_Var
		 = (AdditiveExpression)Expr_188_list.get(0);
		Assert.assertNotNull(AdditiveExpression_189_Var
		);
		final EList<? extends EObject> Expr_189_list = AdditiveExpression_189_Var
		.getExpr();
		Assert.assertNotNull(Expr_189_list);
		Assert.assertEquals(1, Expr_189_list.size());
		//189
		final MultiplicativeExpression MultiplicativeExpression_190_Var
		 = (MultiplicativeExpression)Expr_189_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = MultiplicativeExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final CastExpression CastExpression_191_Var
		 = (CastExpression)Expr_190_list.get(0);
		Assert.assertNotNull(CastExpression_191_Var
		);
		//191
		final UnaryExpression UnaryExpression_192_Var
		 = (UnaryExpression)CastExpression_191_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_192_Var
		);
		//192
		final PostfixExpression PostfixExpression_193_Var
		 = (PostfixExpression)UnaryExpression_192_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = PostfixExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final PrimaryExpression PrimaryExpression_194_Var
		 = (PrimaryExpression)Expr_193_list.get(0);
		Assert.assertNotNull(PrimaryExpression_194_Var
		);
		//194
		final Constant Constant_195_Var
		 = (Constant)PrimaryExpression_194_Var
		.getConst();
		Assert.assertNotNull(Constant_195_Var
		);
		Assert.assertEquals("\"(*employee).id=%d\\n\"", Constant_195_Var
		.getStr());
		//195
		final AssignmentExpression AssignmentExpression_196_Var
		 = (AssignmentExpression)Expr_178_list.get(1);
		Assert.assertNotNull(AssignmentExpression_196_Var
		);
		//196
		final ConditionalExpression ConditionalExpression_197_Var
		 = (ConditionalExpression)AssignmentExpression_196_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_197_Var
		);
		//197
		final LogicalOrExpression LogicalOrExpression_198_Var
		 = (LogicalOrExpression)ConditionalExpression_197_Var
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
		final Expression Expression_212_Var
		 = (Expression)PrimaryExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expression_212_Var
		);
		final EList<? extends EObject> ExprExpr_212_list = Expression_212_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_212_list);
		Assert.assertEquals(1, ExprExpr_212_list.size());
		//212
		final AssignmentExpression AssignmentExpression_213_Var
		 = (AssignmentExpression)ExprExpr_212_list.get(0);
		Assert.assertNotNull(AssignmentExpression_213_Var
		);
		//213
		final ConditionalExpression ConditionalExpression_214_Var
		 = (ConditionalExpression)AssignmentExpression_213_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_214_Var
		);
		//214
		final LogicalOrExpression LogicalOrExpression_215_Var
		 = (LogicalOrExpression)ConditionalExpression_214_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = LogicalOrExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final LogicalAndExpression LogicalAndExpression_216_Var
		 = (LogicalAndExpression)Expr_215_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = LogicalAndExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final InclusiveOrExpression InclusiveOrExpression_217_Var
		 = (InclusiveOrExpression)Expr_216_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = InclusiveOrExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final ExclusiveOrExpression ExclusiveOrExpression_218_Var
		 = (ExclusiveOrExpression)Expr_217_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = ExclusiveOrExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final AndExpression AndExpression_219_Var
		 = (AndExpression)Expr_218_list.get(0);
		Assert.assertNotNull(AndExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = AndExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final EqualityExpression EqualityExpression_220_Var
		 = (EqualityExpression)Expr_219_list.get(0);
		Assert.assertNotNull(EqualityExpression_220_Var
		);
		final EList<? extends EObject> Expr_220_list = EqualityExpression_220_Var
		.getExpr();
		Assert.assertNotNull(Expr_220_list);
		Assert.assertEquals(1, Expr_220_list.size());
		//220
		final RelationalExpression RelationalExpression_221_Var
		 = (RelationalExpression)Expr_220_list.get(0);
		Assert.assertNotNull(RelationalExpression_221_Var
		);
		final EList<? extends EObject> Expr_221_list = RelationalExpression_221_Var
		.getExpr();
		Assert.assertNotNull(Expr_221_list);
		Assert.assertEquals(1, Expr_221_list.size());
		//221
		final ShiftExpression ShiftExpression_222_Var
		 = (ShiftExpression)Expr_221_list.get(0);
		Assert.assertNotNull(ShiftExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = ShiftExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final AdditiveExpression AdditiveExpression_223_Var
		 = (AdditiveExpression)Expr_222_list.get(0);
		Assert.assertNotNull(AdditiveExpression_223_Var
		);
		final EList<? extends EObject> Expr_223_list = AdditiveExpression_223_Var
		.getExpr();
		Assert.assertNotNull(Expr_223_list);
		Assert.assertEquals(1, Expr_223_list.size());
		//223
		final MultiplicativeExpression MultiplicativeExpression_224_Var
		 = (MultiplicativeExpression)Expr_223_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_224_Var
		);
		final EList<? extends EObject> Expr_224_list = MultiplicativeExpression_224_Var
		.getExpr();
		Assert.assertNotNull(Expr_224_list);
		Assert.assertEquals(1, Expr_224_list.size());
		//224
		final CastExpression CastExpression_225_Var
		 = (CastExpression)Expr_224_list.get(0);
		Assert.assertNotNull(CastExpression_225_Var
		);
		//225
		final UnaryExpression UnaryExpression_226_Var
		 = (UnaryExpression)CastExpression_225_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_226_Var
		);
		//226
		final UnaryOperator UnaryOperator_227_Var
		 = (UnaryOperator)UnaryExpression_226_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_227_Var
		);
		Assert.assertEquals("*", UnaryOperator_227_Var
		.getOp());
		//227
		final CastExpression CastExpression_228_Var
		 = (CastExpression)UnaryExpression_226_Var
		.getExpr();
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
		Assert.assertEquals("emp", PrimaryExpression_231_Var
		.getId());
		Assert.assertEquals("[.]", PostfixExpression_210_Var
		.getDot().toString());
		Assert.assertEquals("[id]", PostfixExpression_210_Var
		.getId().toString());
		Assert.assertEquals(";", ExpressionStatement_160_Var
		.getSemi());
		//231
		final Statement Statement_232_Var
		 = (Statement)Statement_158_list.get(1);
		Assert.assertNotNull(Statement_232_Var
		);
		//232
		final ExpressionStatement ExpressionStatement_233_Var
		 = (ExpressionStatement)Statement_232_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_233_Var
		);
		//233
		final Expression Expression_234_Var
		 = (Expression)ExpressionStatement_233_Var
		.getExpression();
		Assert.assertNotNull(Expression_234_Var
		);
		final EList<? extends EObject> ExprExpr_234_list = Expression_234_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_234_list);
		Assert.assertEquals(1, ExprExpr_234_list.size());
		//234
		final AssignmentExpression AssignmentExpression_235_Var
		 = (AssignmentExpression)ExprExpr_234_list.get(0);
		Assert.assertNotNull(AssignmentExpression_235_Var
		);
		//235
		final ConditionalExpression ConditionalExpression_236_Var
		 = (ConditionalExpression)AssignmentExpression_235_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_236_Var
		);
		//236
		final LogicalOrExpression LogicalOrExpression_237_Var
		 = (LogicalOrExpression)ConditionalExpression_236_Var
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
		Assert.assertEquals("printf", PrimaryExpression_250_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_250_list = PostfixExpression_249_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_250_list);
		Assert.assertEquals(1, ArgumentExpressionList_250_list.size());
		//250
		final ArgumentExpressionList ArgumentExpressionList_251_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_250_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_251_Var
		);
		final EList<? extends EObject> Expr_251_list = ArgumentExpressionList_251_Var
		.getExpr();
		Assert.assertNotNull(Expr_251_list);
		Assert.assertEquals(2, Expr_251_list.size());
		//251
		final AssignmentExpression AssignmentExpression_252_Var
		 = (AssignmentExpression)Expr_251_list.get(0);
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
		//267
		final Constant Constant_268_Var
		 = (Constant)PrimaryExpression_267_Var
		.getConst();
		Assert.assertNotNull(Constant_268_Var
		);
		Assert.assertEquals("\"employee->name=%s\\n\"", Constant_268_Var
		.getStr());
		//268
		final AssignmentExpression AssignmentExpression_269_Var
		 = (AssignmentExpression)Expr_251_list.get(1);
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
		Assert.assertEquals("emp", PrimaryExpression_284_Var
		.getId());
		Assert.assertEquals("[]", PostfixExpression_283_Var
		.getDot().toString());
		Assert.assertEquals("[->]", PostfixExpression_283_Var
		.getArrow().toString());
		Assert.assertEquals("[name]", PostfixExpression_283_Var
		.getId().toString());
		Assert.assertEquals(";", ExpressionStatement_233_Var
		.getSemi());
		//284
		final ExternalDeclaration ExternalDeclaration_285_Var
		 = (ExternalDeclaration)External_1_list.get(4);
		Assert.assertNotNull(ExternalDeclaration_285_Var
		);
		//285
		final FunctionDefHead FunctionDefHead_286_Var
		 = (FunctionDefHead)ExternalDeclaration_285_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_286_Var
		);
		//286
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_287_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_286_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_287_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_287_list = FunctionDeclarationSpecifiers_287_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_287_list);
		Assert.assertEquals(1, DeclarationSpecifier_287_list.size());
		//287
		final TypeSpecifier TypeSpecifier_288_Var
		 = (TypeSpecifier)DeclarationSpecifier_287_list.get(0);
		Assert.assertNotNull(TypeSpecifier_288_Var
		);
		Assert.assertEquals("int", TypeSpecifier_288_Var
		.getName());
		//288
		final Declarator Declarator_289_Var
		 = (Declarator)FunctionDefHead_286_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_289_Var
		);
		//289
		final DirectDeclarator DirectDeclarator_290_Var
		 = (DirectDeclarator)Declarator_289_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_290_Var
		);
		Assert.assertEquals("main", DirectDeclarator_290_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_290_list = DirectDeclarator_290_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_290_list);
		Assert.assertEquals(1, DeclaratorSuffix_290_list.size());
		//290
		final DeclaratorSuffix DeclaratorSuffix_291_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_290_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_291_Var
		);
		//291
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_292_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_291_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_292_Var
		);
		final EList<? extends EObject> ParameterTypeList_292_list = DirectDeclaratorLastSuffix_292_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_292_list);
		Assert.assertEquals(1, ParameterTypeList_292_list.size());
		//292
		final ParameterTypeList ParameterTypeList_293_Var
		 = (ParameterTypeList)ParameterTypeList_292_list.get(0);
		Assert.assertNotNull(ParameterTypeList_293_Var
		);
		//293
		final ParameterList ParameterList_294_Var
		 = (ParameterList)ParameterTypeList_293_Var
		.getList();
		Assert.assertNotNull(ParameterList_294_Var
		);
		final EList<? extends EObject> ParameterDeclaration_294_list = ParameterList_294_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_294_list);
		Assert.assertEquals(1, ParameterDeclaration_294_list.size());
		//294
		final ParameterDeclaration ParameterDeclaration_295_Var
		 = (ParameterDeclaration)ParameterDeclaration_294_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_295_Var
		);
		//295
		final DeclarationSpecifiers DeclarationSpecifiers_296_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_295_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_296_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_296_list = DeclarationSpecifiers_296_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_296_list);
		Assert.assertEquals(1, DeclarationSpecifier_296_list.size());
		//296
		final TypeSpecifier TypeSpecifier_297_Var
		 = (TypeSpecifier)DeclarationSpecifier_296_list.get(0);
		Assert.assertNotNull(TypeSpecifier_297_Var
		);
		Assert.assertEquals("void", TypeSpecifier_297_Var
		.getName());
		//297
		final FunctionDefinition FunctionDefinition_298_Var
		 = (FunctionDefinition)ExternalDeclaration_285_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_298_Var
		);
		//298
		final BodyStatement BodyStatement_299_Var
		 = (BodyStatement)FunctionDefinition_298_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_299_Var
		);
		final EList<? extends EObject> BlockList_299_list = BodyStatement_299_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_299_list);
		Assert.assertEquals(1, BlockList_299_list.size());
		//299
		final BlockList BlockList_300_Var
		 = (BlockList)BlockList_299_list.get(0);
		Assert.assertNotNull(BlockList_300_Var
		);
		final EList<? extends EObject> Declaration_300_list = BlockList_300_Var
		.getDeclaration();
		Assert.assertNotNull(Declaration_300_list);
		Assert.assertEquals(1, Declaration_300_list.size());
		//300
		final Declaration Declaration_301_Var
		 = (Declaration)Declaration_300_list.get(0);
		Assert.assertNotNull(Declaration_301_Var
		);
		//301
		final DeclarationSpecifiers DeclarationSpecifiers_302_Var
		 = (DeclarationSpecifiers)Declaration_301_Var
		.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_302_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_302_list = DeclarationSpecifiers_302_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_302_list);
		Assert.assertEquals(1, DeclarationSpecifier_302_list.size());
		//302
		final TypeSpecifier TypeSpecifier_303_Var
		 = (TypeSpecifier)DeclarationSpecifier_302_list.get(0);
		Assert.assertNotNull(TypeSpecifier_303_Var
		);
		//303
		final TypedefName TypedefName_304_Var
		 = (TypedefName)TypeSpecifier_303_Var
		.getType();
		Assert.assertNotNull(TypedefName_304_Var
		);
		Assert.assertEquals("employee", TypedefName_304_Var
		.getId());
		final EList<? extends EObject> InitDeclaratorList_304_list = Declaration_301_Var
		.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_304_list);
		Assert.assertEquals(1, InitDeclaratorList_304_list.size());
		//304
		final InitDeclaratorList InitDeclaratorList_305_Var
		 = (InitDeclaratorList)InitDeclaratorList_304_list.get(0);
		Assert.assertNotNull(InitDeclaratorList_305_Var
		);
		final EList<? extends EObject> InitDeclarator_305_list = InitDeclaratorList_305_Var
		.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_305_list);
		Assert.assertEquals(1, InitDeclarator_305_list.size());
		//305
		final InitDeclarator InitDeclarator_306_Var
		 = (InitDeclarator)InitDeclarator_305_list.get(0);
		Assert.assertNotNull(InitDeclarator_306_Var
		);
		//306
		final Declarator Declarator_307_Var
		 = (Declarator)InitDeclarator_306_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_307_Var
		);
		//307
		final Pointer Pointer_308_Var
		 = (Pointer)Declarator_307_Var
		.getPointer();
		Assert.assertNotNull(Pointer_308_Var
		);
		Assert.assertEquals("[*]", Pointer_308_Var
		.getStar().toString());
		//308
		final DirectDeclarator DirectDeclarator_309_Var
		 = (DirectDeclarator)Declarator_307_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_309_Var
		);
		Assert.assertEquals("newEmployee", DirectDeclarator_309_Var
		.getId());
		//309
		final Initializer Initializer_310_Var
		 = (Initializer)InitDeclarator_306_Var
		.getInitializer();
		Assert.assertNotNull(Initializer_310_Var
		);
		//310
		final AssignmentExpression AssignmentExpression_311_Var
		 = (AssignmentExpression)Initializer_310_Var
		.getExpr();
		Assert.assertNotNull(AssignmentExpression_311_Var
		);
		//311
		final ConditionalExpression ConditionalExpression_312_Var
		 = (ConditionalExpression)AssignmentExpression_311_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_312_Var
		);
		//312
		final LogicalOrExpression LogicalOrExpression_313_Var
		 = (LogicalOrExpression)ConditionalExpression_312_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_313_Var
		);
		final EList<? extends EObject> Expr_313_list = LogicalOrExpression_313_Var
		.getExpr();
		Assert.assertNotNull(Expr_313_list);
		Assert.assertEquals(1, Expr_313_list.size());
		//313
		final LogicalAndExpression LogicalAndExpression_314_Var
		 = (LogicalAndExpression)Expr_313_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = LogicalAndExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final InclusiveOrExpression InclusiveOrExpression_315_Var
		 = (InclusiveOrExpression)Expr_314_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_315_Var
		);
		final EList<? extends EObject> Expr_315_list = InclusiveOrExpression_315_Var
		.getExpr();
		Assert.assertNotNull(Expr_315_list);
		Assert.assertEquals(1, Expr_315_list.size());
		//315
		final ExclusiveOrExpression ExclusiveOrExpression_316_Var
		 = (ExclusiveOrExpression)Expr_315_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_316_Var
		);
		final EList<? extends EObject> Expr_316_list = ExclusiveOrExpression_316_Var
		.getExpr();
		Assert.assertNotNull(Expr_316_list);
		Assert.assertEquals(1, Expr_316_list.size());
		//316
		final AndExpression AndExpression_317_Var
		 = (AndExpression)Expr_316_list.get(0);
		Assert.assertNotNull(AndExpression_317_Var
		);
		final EList<? extends EObject> Expr_317_list = AndExpression_317_Var
		.getExpr();
		Assert.assertNotNull(Expr_317_list);
		Assert.assertEquals(1, Expr_317_list.size());
		//317
		final EqualityExpression EqualityExpression_318_Var
		 = (EqualityExpression)Expr_317_list.get(0);
		Assert.assertNotNull(EqualityExpression_318_Var
		);
		final EList<? extends EObject> Expr_318_list = EqualityExpression_318_Var
		.getExpr();
		Assert.assertNotNull(Expr_318_list);
		Assert.assertEquals(1, Expr_318_list.size());
		//318
		final RelationalExpression RelationalExpression_319_Var
		 = (RelationalExpression)Expr_318_list.get(0);
		Assert.assertNotNull(RelationalExpression_319_Var
		);
		final EList<? extends EObject> Expr_319_list = RelationalExpression_319_Var
		.getExpr();
		Assert.assertNotNull(Expr_319_list);
		Assert.assertEquals(1, Expr_319_list.size());
		//319
		final ShiftExpression ShiftExpression_320_Var
		 = (ShiftExpression)Expr_319_list.get(0);
		Assert.assertNotNull(ShiftExpression_320_Var
		);
		final EList<? extends EObject> Expr_320_list = ShiftExpression_320_Var
		.getExpr();
		Assert.assertNotNull(Expr_320_list);
		Assert.assertEquals(1, Expr_320_list.size());
		//320
		final AdditiveExpression AdditiveExpression_321_Var
		 = (AdditiveExpression)Expr_320_list.get(0);
		Assert.assertNotNull(AdditiveExpression_321_Var
		);
		final EList<? extends EObject> Expr_321_list = AdditiveExpression_321_Var
		.getExpr();
		Assert.assertNotNull(Expr_321_list);
		Assert.assertEquals(1, Expr_321_list.size());
		//321
		final MultiplicativeExpression MultiplicativeExpression_322_Var
		 = (MultiplicativeExpression)Expr_321_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_322_Var
		);
		final EList<? extends EObject> Expr_322_list = MultiplicativeExpression_322_Var
		.getExpr();
		Assert.assertNotNull(Expr_322_list);
		Assert.assertEquals(1, Expr_322_list.size());
		//322
		final CastExpression CastExpression_323_Var
		 = (CastExpression)Expr_322_list.get(0);
		Assert.assertNotNull(CastExpression_323_Var
		);
		//323
		final UnaryExpression UnaryExpression_324_Var
		 = (UnaryExpression)CastExpression_323_Var
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
		Assert.assertEquals("malloc", PrimaryExpression_326_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_326_list = PostfixExpression_325_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_326_list);
		Assert.assertEquals(1, ArgumentExpressionList_326_list.size());
		//326
		final ArgumentExpressionList ArgumentExpressionList_327_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_326_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_327_Var
		);
		final EList<? extends EObject> Expr_327_list = ArgumentExpressionList_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final AssignmentExpression AssignmentExpression_328_Var
		 = (AssignmentExpression)Expr_327_list.get(0);
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
		Assert.assertEquals("sizeof", UnaryExpression_341_Var
		.getSizeOf());
		//341
		final TypeName TypeName_342_Var
		 = (TypeName)UnaryExpression_341_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_342_Var
		);
		//342
		final SpecifierQualifierList SpecifierQualifierList_343_Var
		 = (SpecifierQualifierList)TypeName_342_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_343_Var
		);
		final EList<? extends EObject> TypeSpecifier_343_list = SpecifierQualifierList_343_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_343_list);
		Assert.assertEquals(1, TypeSpecifier_343_list.size());
		//343
		final TypeSpecifier TypeSpecifier_344_Var
		 = (TypeSpecifier)TypeSpecifier_343_list.get(0);
		Assert.assertNotNull(TypeSpecifier_344_Var
		);
		//344
		final TypedefName TypedefName_345_Var
		 = (TypedefName)TypeSpecifier_344_Var
		.getType();
		Assert.assertNotNull(TypedefName_345_Var
		);
		Assert.assertEquals("employee", TypedefName_345_Var
		.getId());
		final EList<? extends EObject> Statement_345_list = BlockList_300_Var
		.getStatement();
		Assert.assertNotNull(Statement_345_list);
		Assert.assertEquals(8, Statement_345_list.size());
		//345
		final Statement Statement_346_Var
		 = (Statement)Statement_345_list.get(0);
		Assert.assertNotNull(Statement_346_Var
		);
		//346
		final SelectionStatement SelectionStatement_347_Var
		 = (SelectionStatement)Statement_346_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_347_Var
		);
		Assert.assertEquals("if", SelectionStatement_347_Var
		.getIf());
		//347
		final Expression Expression_348_Var
		 = (Expression)SelectionStatement_347_Var
		.getExpr();
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
		final ConditionalExpression ConditionalExpression_350_Var
		 = (ConditionalExpression)AssignmentExpression_349_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_350_Var
		);
		//350
		final LogicalOrExpression LogicalOrExpression_351_Var
		 = (LogicalOrExpression)ConditionalExpression_350_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_351_Var
		);
		final EList<? extends EObject> Expr_351_list = LogicalOrExpression_351_Var
		.getExpr();
		Assert.assertNotNull(Expr_351_list);
		Assert.assertEquals(1, Expr_351_list.size());
		//351
		final LogicalAndExpression LogicalAndExpression_352_Var
		 = (LogicalAndExpression)Expr_351_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_352_Var
		);
		final EList<? extends EObject> Expr_352_list = LogicalAndExpression_352_Var
		.getExpr();
		Assert.assertNotNull(Expr_352_list);
		Assert.assertEquals(1, Expr_352_list.size());
		//352
		final InclusiveOrExpression InclusiveOrExpression_353_Var
		 = (InclusiveOrExpression)Expr_352_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_353_Var
		);
		final EList<? extends EObject> Expr_353_list = InclusiveOrExpression_353_Var
		.getExpr();
		Assert.assertNotNull(Expr_353_list);
		Assert.assertEquals(1, Expr_353_list.size());
		//353
		final ExclusiveOrExpression ExclusiveOrExpression_354_Var
		 = (ExclusiveOrExpression)Expr_353_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_354_Var
		);
		final EList<? extends EObject> Expr_354_list = ExclusiveOrExpression_354_Var
		.getExpr();
		Assert.assertNotNull(Expr_354_list);
		Assert.assertEquals(1, Expr_354_list.size());
		//354
		final AndExpression AndExpression_355_Var
		 = (AndExpression)Expr_354_list.get(0);
		Assert.assertNotNull(AndExpression_355_Var
		);
		final EList<? extends EObject> Expr_355_list = AndExpression_355_Var
		.getExpr();
		Assert.assertNotNull(Expr_355_list);
		Assert.assertEquals(1, Expr_355_list.size());
		//355
		final EqualityExpression EqualityExpression_356_Var
		 = (EqualityExpression)Expr_355_list.get(0);
		Assert.assertNotNull(EqualityExpression_356_Var
		);
		Assert.assertEquals("[==]", EqualityExpression_356_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_356_list = EqualityExpression_356_Var
		.getExpr();
		Assert.assertNotNull(Expr_356_list);
		Assert.assertEquals(2, Expr_356_list.size());
		//356
		final RelationalExpression RelationalExpression_357_Var
		 = (RelationalExpression)Expr_356_list.get(0);
		Assert.assertNotNull(RelationalExpression_357_Var
		);
		final EList<? extends EObject> Expr_357_list = RelationalExpression_357_Var
		.getExpr();
		Assert.assertNotNull(Expr_357_list);
		Assert.assertEquals(1, Expr_357_list.size());
		//357
		final ShiftExpression ShiftExpression_358_Var
		 = (ShiftExpression)Expr_357_list.get(0);
		Assert.assertNotNull(ShiftExpression_358_Var
		);
		final EList<? extends EObject> Expr_358_list = ShiftExpression_358_Var
		.getExpr();
		Assert.assertNotNull(Expr_358_list);
		Assert.assertEquals(1, Expr_358_list.size());
		//358
		final AdditiveExpression AdditiveExpression_359_Var
		 = (AdditiveExpression)Expr_358_list.get(0);
		Assert.assertNotNull(AdditiveExpression_359_Var
		);
		final EList<? extends EObject> Expr_359_list = AdditiveExpression_359_Var
		.getExpr();
		Assert.assertNotNull(Expr_359_list);
		Assert.assertEquals(1, Expr_359_list.size());
		//359
		final MultiplicativeExpression MultiplicativeExpression_360_Var
		 = (MultiplicativeExpression)Expr_359_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_360_Var
		);
		final EList<? extends EObject> Expr_360_list = MultiplicativeExpression_360_Var
		.getExpr();
		Assert.assertNotNull(Expr_360_list);
		Assert.assertEquals(1, Expr_360_list.size());
		//360
		final CastExpression CastExpression_361_Var
		 = (CastExpression)Expr_360_list.get(0);
		Assert.assertNotNull(CastExpression_361_Var
		);
		//361
		final UnaryExpression UnaryExpression_362_Var
		 = (UnaryExpression)CastExpression_361_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_362_Var
		);
		//362
		final PostfixExpression PostfixExpression_363_Var
		 = (PostfixExpression)UnaryExpression_362_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_363_Var
		);
		final EList<? extends EObject> Expr_363_list = PostfixExpression_363_Var
		.getExpr();
		Assert.assertNotNull(Expr_363_list);
		Assert.assertEquals(1, Expr_363_list.size());
		//363
		final PrimaryExpression PrimaryExpression_364_Var
		 = (PrimaryExpression)Expr_363_list.get(0);
		Assert.assertNotNull(PrimaryExpression_364_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_364_Var
		.getId());
		//364
		final RelationalExpression RelationalExpression_365_Var
		 = (RelationalExpression)Expr_356_list.get(1);
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
		Assert.assertEquals("NULL", PrimaryExpression_372_Var
		.getId());
		//372
		final Statement Statement_373_Var
		 = (Statement)SelectionStatement_347_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_373_Var
		);
		//373
		final CompoundStatement CompoundStatement_374_Var
		 = (CompoundStatement)Statement_373_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_374_Var
		);
		//374
		final BodyStatement BodyStatement_375_Var
		 = (BodyStatement)CompoundStatement_374_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_375_Var
		);
		final EList<? extends EObject> BlockList_375_list = BodyStatement_375_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_375_list);
		Assert.assertEquals(1, BlockList_375_list.size());
		//375
		final BlockList BlockList_376_Var
		 = (BlockList)BlockList_375_list.get(0);
		Assert.assertNotNull(BlockList_376_Var
		);
		final EList<? extends EObject> Statement_376_list = BlockList_376_Var
		.getStatement();
		Assert.assertNotNull(Statement_376_list);
		Assert.assertEquals(2, Statement_376_list.size());
		//376
		final Statement Statement_377_Var
		 = (Statement)Statement_376_list.get(0);
		Assert.assertNotNull(Statement_377_Var
		);
		//377
		final ExpressionStatement ExpressionStatement_378_Var
		 = (ExpressionStatement)Statement_377_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_378_Var
		);
		//378
		final Expression Expression_379_Var
		 = (Expression)ExpressionStatement_378_Var
		.getExpression();
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
		Assert.assertEquals("printf", PrimaryExpression_395_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_395_list = PostfixExpression_394_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_395_list);
		Assert.assertEquals(1, ArgumentExpressionList_395_list.size());
		//395
		final ArgumentExpressionList ArgumentExpressionList_396_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_395_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_396_Var
		);
		final EList<? extends EObject> Expr_396_list = ArgumentExpressionList_396_Var
		.getExpr();
		Assert.assertNotNull(Expr_396_list);
		Assert.assertEquals(1, Expr_396_list.size());
		//396
		final AssignmentExpression AssignmentExpression_397_Var
		 = (AssignmentExpression)Expr_396_list.get(0);
		Assert.assertNotNull(AssignmentExpression_397_Var
		);
		//397
		final ConditionalExpression ConditionalExpression_398_Var
		 = (ConditionalExpression)AssignmentExpression_397_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_398_Var
		);
		//398
		final LogicalOrExpression LogicalOrExpression_399_Var
		 = (LogicalOrExpression)ConditionalExpression_398_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_399_Var
		);
		final EList<? extends EObject> Expr_399_list = LogicalOrExpression_399_Var
		.getExpr();
		Assert.assertNotNull(Expr_399_list);
		Assert.assertEquals(1, Expr_399_list.size());
		//399
		final LogicalAndExpression LogicalAndExpression_400_Var
		 = (LogicalAndExpression)Expr_399_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_400_Var
		);
		final EList<? extends EObject> Expr_400_list = LogicalAndExpression_400_Var
		.getExpr();
		Assert.assertNotNull(Expr_400_list);
		Assert.assertEquals(1, Expr_400_list.size());
		//400
		final InclusiveOrExpression InclusiveOrExpression_401_Var
		 = (InclusiveOrExpression)Expr_400_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_401_Var
		);
		final EList<? extends EObject> Expr_401_list = InclusiveOrExpression_401_Var
		.getExpr();
		Assert.assertNotNull(Expr_401_list);
		Assert.assertEquals(1, Expr_401_list.size());
		//401
		final ExclusiveOrExpression ExclusiveOrExpression_402_Var
		 = (ExclusiveOrExpression)Expr_401_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_402_Var
		);
		final EList<? extends EObject> Expr_402_list = ExclusiveOrExpression_402_Var
		.getExpr();
		Assert.assertNotNull(Expr_402_list);
		Assert.assertEquals(1, Expr_402_list.size());
		//402
		final AndExpression AndExpression_403_Var
		 = (AndExpression)Expr_402_list.get(0);
		Assert.assertNotNull(AndExpression_403_Var
		);
		final EList<? extends EObject> Expr_403_list = AndExpression_403_Var
		.getExpr();
		Assert.assertNotNull(Expr_403_list);
		Assert.assertEquals(1, Expr_403_list.size());
		//403
		final EqualityExpression EqualityExpression_404_Var
		 = (EqualityExpression)Expr_403_list.get(0);
		Assert.assertNotNull(EqualityExpression_404_Var
		);
		final EList<? extends EObject> Expr_404_list = EqualityExpression_404_Var
		.getExpr();
		Assert.assertNotNull(Expr_404_list);
		Assert.assertEquals(1, Expr_404_list.size());
		//404
		final RelationalExpression RelationalExpression_405_Var
		 = (RelationalExpression)Expr_404_list.get(0);
		Assert.assertNotNull(RelationalExpression_405_Var
		);
		final EList<? extends EObject> Expr_405_list = RelationalExpression_405_Var
		.getExpr();
		Assert.assertNotNull(Expr_405_list);
		Assert.assertEquals(1, Expr_405_list.size());
		//405
		final ShiftExpression ShiftExpression_406_Var
		 = (ShiftExpression)Expr_405_list.get(0);
		Assert.assertNotNull(ShiftExpression_406_Var
		);
		final EList<? extends EObject> Expr_406_list = ShiftExpression_406_Var
		.getExpr();
		Assert.assertNotNull(Expr_406_list);
		Assert.assertEquals(1, Expr_406_list.size());
		//406
		final AdditiveExpression AdditiveExpression_407_Var
		 = (AdditiveExpression)Expr_406_list.get(0);
		Assert.assertNotNull(AdditiveExpression_407_Var
		);
		final EList<? extends EObject> Expr_407_list = AdditiveExpression_407_Var
		.getExpr();
		Assert.assertNotNull(Expr_407_list);
		Assert.assertEquals(1, Expr_407_list.size());
		//407
		final MultiplicativeExpression MultiplicativeExpression_408_Var
		 = (MultiplicativeExpression)Expr_407_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_408_Var
		);
		final EList<? extends EObject> Expr_408_list = MultiplicativeExpression_408_Var
		.getExpr();
		Assert.assertNotNull(Expr_408_list);
		Assert.assertEquals(1, Expr_408_list.size());
		//408
		final CastExpression CastExpression_409_Var
		 = (CastExpression)Expr_408_list.get(0);
		Assert.assertNotNull(CastExpression_409_Var
		);
		//409
		final UnaryExpression UnaryExpression_410_Var
		 = (UnaryExpression)CastExpression_409_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_410_Var
		);
		//410
		final PostfixExpression PostfixExpression_411_Var
		 = (PostfixExpression)UnaryExpression_410_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_411_Var
		);
		final EList<? extends EObject> Expr_411_list = PostfixExpression_411_Var
		.getExpr();
		Assert.assertNotNull(Expr_411_list);
		Assert.assertEquals(1, Expr_411_list.size());
		//411
		final PrimaryExpression PrimaryExpression_412_Var
		 = (PrimaryExpression)Expr_411_list.get(0);
		Assert.assertNotNull(PrimaryExpression_412_Var
		);
		//412
		final Constant Constant_413_Var
		 = (Constant)PrimaryExpression_412_Var
		.getConst();
		Assert.assertNotNull(Constant_413_Var
		);
		Assert.assertEquals("\"Could not reserve space for new employee!\\n\"", Constant_413_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_378_Var
		.getSemi());
		//413
		final Statement Statement_414_Var
		 = (Statement)Statement_376_list.get(1);
		Assert.assertNotNull(Statement_414_Var
		);
		//414
		final JumpStatement JumpStatement_415_Var
		 = (JumpStatement)Statement_414_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_415_Var
		);
		//415
		final Expression Expression_416_Var
		 = (Expression)JumpStatement_415_Var
		.getExpr();
		Assert.assertNotNull(Expression_416_Var
		);
		final EList<? extends EObject> ExprExpr_416_list = Expression_416_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_416_list);
		Assert.assertEquals(1, ExprExpr_416_list.size());
		//416
		final AssignmentExpression AssignmentExpression_417_Var
		 = (AssignmentExpression)ExprExpr_416_list.get(0);
		Assert.assertNotNull(AssignmentExpression_417_Var
		);
		//417
		final ConditionalExpression ConditionalExpression_418_Var
		 = (ConditionalExpression)AssignmentExpression_417_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_418_Var
		);
		//418
		final LogicalOrExpression LogicalOrExpression_419_Var
		 = (LogicalOrExpression)ConditionalExpression_418_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_419_Var
		);
		final EList<? extends EObject> Expr_419_list = LogicalOrExpression_419_Var
		.getExpr();
		Assert.assertNotNull(Expr_419_list);
		Assert.assertEquals(1, Expr_419_list.size());
		//419
		final LogicalAndExpression LogicalAndExpression_420_Var
		 = (LogicalAndExpression)Expr_419_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_420_Var
		);
		final EList<? extends EObject> Expr_420_list = LogicalAndExpression_420_Var
		.getExpr();
		Assert.assertNotNull(Expr_420_list);
		Assert.assertEquals(1, Expr_420_list.size());
		//420
		final InclusiveOrExpression InclusiveOrExpression_421_Var
		 = (InclusiveOrExpression)Expr_420_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_421_Var
		);
		final EList<? extends EObject> Expr_421_list = InclusiveOrExpression_421_Var
		.getExpr();
		Assert.assertNotNull(Expr_421_list);
		Assert.assertEquals(1, Expr_421_list.size());
		//421
		final ExclusiveOrExpression ExclusiveOrExpression_422_Var
		 = (ExclusiveOrExpression)Expr_421_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_422_Var
		);
		final EList<? extends EObject> Expr_422_list = ExclusiveOrExpression_422_Var
		.getExpr();
		Assert.assertNotNull(Expr_422_list);
		Assert.assertEquals(1, Expr_422_list.size());
		//422
		final AndExpression AndExpression_423_Var
		 = (AndExpression)Expr_422_list.get(0);
		Assert.assertNotNull(AndExpression_423_Var
		);
		final EList<? extends EObject> Expr_423_list = AndExpression_423_Var
		.getExpr();
		Assert.assertNotNull(Expr_423_list);
		Assert.assertEquals(1, Expr_423_list.size());
		//423
		final EqualityExpression EqualityExpression_424_Var
		 = (EqualityExpression)Expr_423_list.get(0);
		Assert.assertNotNull(EqualityExpression_424_Var
		);
		final EList<? extends EObject> Expr_424_list = EqualityExpression_424_Var
		.getExpr();
		Assert.assertNotNull(Expr_424_list);
		Assert.assertEquals(1, Expr_424_list.size());
		//424
		final RelationalExpression RelationalExpression_425_Var
		 = (RelationalExpression)Expr_424_list.get(0);
		Assert.assertNotNull(RelationalExpression_425_Var
		);
		final EList<? extends EObject> Expr_425_list = RelationalExpression_425_Var
		.getExpr();
		Assert.assertNotNull(Expr_425_list);
		Assert.assertEquals(1, Expr_425_list.size());
		//425
		final ShiftExpression ShiftExpression_426_Var
		 = (ShiftExpression)Expr_425_list.get(0);
		Assert.assertNotNull(ShiftExpression_426_Var
		);
		final EList<? extends EObject> Expr_426_list = ShiftExpression_426_Var
		.getExpr();
		Assert.assertNotNull(Expr_426_list);
		Assert.assertEquals(1, Expr_426_list.size());
		//426
		final AdditiveExpression AdditiveExpression_427_Var
		 = (AdditiveExpression)Expr_426_list.get(0);
		Assert.assertNotNull(AdditiveExpression_427_Var
		);
		final EList<? extends EObject> Expr_427_list = AdditiveExpression_427_Var
		.getExpr();
		Assert.assertNotNull(Expr_427_list);
		Assert.assertEquals(1, Expr_427_list.size());
		//427
		final MultiplicativeExpression MultiplicativeExpression_428_Var
		 = (MultiplicativeExpression)Expr_427_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_428_Var
		);
		final EList<? extends EObject> Expr_428_list = MultiplicativeExpression_428_Var
		.getExpr();
		Assert.assertNotNull(Expr_428_list);
		Assert.assertEquals(1, Expr_428_list.size());
		//428
		final CastExpression CastExpression_429_Var
		 = (CastExpression)Expr_428_list.get(0);
		Assert.assertNotNull(CastExpression_429_Var
		);
		//429
		final UnaryExpression UnaryExpression_430_Var
		 = (UnaryExpression)CastExpression_429_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_430_Var
		);
		//430
		final UnaryOperator UnaryOperator_431_Var
		 = (UnaryOperator)UnaryExpression_430_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_431_Var
		);
		Assert.assertEquals("-", UnaryOperator_431_Var
		.getOp());
		//431
		final CastExpression CastExpression_432_Var
		 = (CastExpression)UnaryExpression_430_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_432_Var
		);
		//432
		final UnaryExpression UnaryExpression_433_Var
		 = (UnaryExpression)CastExpression_432_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_433_Var
		);
		//433
		final PostfixExpression PostfixExpression_434_Var
		 = (PostfixExpression)UnaryExpression_433_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_434_Var
		);
		final EList<? extends EObject> Expr_434_list = PostfixExpression_434_Var
		.getExpr();
		Assert.assertNotNull(Expr_434_list);
		Assert.assertEquals(1, Expr_434_list.size());
		//434
		final PrimaryExpression PrimaryExpression_435_Var
		 = (PrimaryExpression)Expr_434_list.get(0);
		Assert.assertNotNull(PrimaryExpression_435_Var
		);
		//435
		final Constant Constant_436_Var
		 = (Constant)PrimaryExpression_435_Var
		.getConst();
		Assert.assertNotNull(Constant_436_Var
		);
		Assert.assertEquals("1", Constant_436_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_415_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_415_Var
		.getSemi());
		//436
		final Statement Statement_437_Var
		 = (Statement)Statement_345_list.get(1);
		Assert.assertNotNull(Statement_437_Var
		);
		//437
		final ExpressionStatement ExpressionStatement_438_Var
		 = (ExpressionStatement)Statement_437_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_438_Var
		);
		//438
		final Expression Expression_439_Var
		 = (Expression)ExpressionStatement_438_Var
		.getExpression();
		Assert.assertNotNull(Expression_439_Var
		);
		final EList<? extends EObject> ExprExpr_439_list = Expression_439_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_439_list);
		Assert.assertEquals(1, ExprExpr_439_list.size());
		//439
		final AssignmentExpression AssignmentExpression_440_Var
		 = (AssignmentExpression)ExprExpr_439_list.get(0);
		Assert.assertNotNull(AssignmentExpression_440_Var
		);
		//440
		final ConditionalExpression ConditionalExpression_441_Var
		 = (ConditionalExpression)AssignmentExpression_440_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_441_Var
		);
		//441
		final LogicalOrExpression LogicalOrExpression_442_Var
		 = (LogicalOrExpression)ConditionalExpression_441_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_442_Var
		);
		final EList<? extends EObject> Expr_442_list = LogicalOrExpression_442_Var
		.getExpr();
		Assert.assertNotNull(Expr_442_list);
		Assert.assertEquals(1, Expr_442_list.size());
		//442
		final LogicalAndExpression LogicalAndExpression_443_Var
		 = (LogicalAndExpression)Expr_442_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_443_Var
		);
		final EList<? extends EObject> Expr_443_list = LogicalAndExpression_443_Var
		.getExpr();
		Assert.assertNotNull(Expr_443_list);
		Assert.assertEquals(1, Expr_443_list.size());
		//443
		final InclusiveOrExpression InclusiveOrExpression_444_Var
		 = (InclusiveOrExpression)Expr_443_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_444_Var
		);
		final EList<? extends EObject> Expr_444_list = InclusiveOrExpression_444_Var
		.getExpr();
		Assert.assertNotNull(Expr_444_list);
		Assert.assertEquals(1, Expr_444_list.size());
		//444
		final ExclusiveOrExpression ExclusiveOrExpression_445_Var
		 = (ExclusiveOrExpression)Expr_444_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_445_Var
		);
		final EList<? extends EObject> Expr_445_list = ExclusiveOrExpression_445_Var
		.getExpr();
		Assert.assertNotNull(Expr_445_list);
		Assert.assertEquals(1, Expr_445_list.size());
		//445
		final AndExpression AndExpression_446_Var
		 = (AndExpression)Expr_445_list.get(0);
		Assert.assertNotNull(AndExpression_446_Var
		);
		final EList<? extends EObject> Expr_446_list = AndExpression_446_Var
		.getExpr();
		Assert.assertNotNull(Expr_446_list);
		Assert.assertEquals(1, Expr_446_list.size());
		//446
		final EqualityExpression EqualityExpression_447_Var
		 = (EqualityExpression)Expr_446_list.get(0);
		Assert.assertNotNull(EqualityExpression_447_Var
		);
		final EList<? extends EObject> Expr_447_list = EqualityExpression_447_Var
		.getExpr();
		Assert.assertNotNull(Expr_447_list);
		Assert.assertEquals(1, Expr_447_list.size());
		//447
		final RelationalExpression RelationalExpression_448_Var
		 = (RelationalExpression)Expr_447_list.get(0);
		Assert.assertNotNull(RelationalExpression_448_Var
		);
		final EList<? extends EObject> Expr_448_list = RelationalExpression_448_Var
		.getExpr();
		Assert.assertNotNull(Expr_448_list);
		Assert.assertEquals(1, Expr_448_list.size());
		//448
		final ShiftExpression ShiftExpression_449_Var
		 = (ShiftExpression)Expr_448_list.get(0);
		Assert.assertNotNull(ShiftExpression_449_Var
		);
		final EList<? extends EObject> Expr_449_list = ShiftExpression_449_Var
		.getExpr();
		Assert.assertNotNull(Expr_449_list);
		Assert.assertEquals(1, Expr_449_list.size());
		//449
		final AdditiveExpression AdditiveExpression_450_Var
		 = (AdditiveExpression)Expr_449_list.get(0);
		Assert.assertNotNull(AdditiveExpression_450_Var
		);
		final EList<? extends EObject> Expr_450_list = AdditiveExpression_450_Var
		.getExpr();
		Assert.assertNotNull(Expr_450_list);
		Assert.assertEquals(1, Expr_450_list.size());
		//450
		final MultiplicativeExpression MultiplicativeExpression_451_Var
		 = (MultiplicativeExpression)Expr_450_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_451_Var
		);
		final EList<? extends EObject> Expr_451_list = MultiplicativeExpression_451_Var
		.getExpr();
		Assert.assertNotNull(Expr_451_list);
		Assert.assertEquals(1, Expr_451_list.size());
		//451
		final CastExpression CastExpression_452_Var
		 = (CastExpression)Expr_451_list.get(0);
		Assert.assertNotNull(CastExpression_452_Var
		);
		//452
		final UnaryExpression UnaryExpression_453_Var
		 = (UnaryExpression)CastExpression_452_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_453_Var
		);
		//453
		final PostfixExpression PostfixExpression_454_Var
		 = (PostfixExpression)UnaryExpression_453_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_454_Var
		);
		final EList<? extends EObject> Expr_454_list = PostfixExpression_454_Var
		.getExpr();
		Assert.assertNotNull(Expr_454_list);
		Assert.assertEquals(1, Expr_454_list.size());
		//454
		final PrimaryExpression PrimaryExpression_455_Var
		 = (PrimaryExpression)Expr_454_list.get(0);
		Assert.assertNotNull(PrimaryExpression_455_Var
		);
		Assert.assertEquals("print", PrimaryExpression_455_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_455_list = PostfixExpression_454_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_455_list);
		Assert.assertEquals(1, ArgumentExpressionList_455_list.size());
		//455
		final ArgumentExpressionList ArgumentExpressionList_456_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_455_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_456_Var
		);
		final EList<? extends EObject> Expr_456_list = ArgumentExpressionList_456_Var
		.getExpr();
		Assert.assertNotNull(Expr_456_list);
		Assert.assertEquals(1, Expr_456_list.size());
		//456
		final AssignmentExpression AssignmentExpression_457_Var
		 = (AssignmentExpression)Expr_456_list.get(0);
		Assert.assertNotNull(AssignmentExpression_457_Var
		);
		//457
		final ConditionalExpression ConditionalExpression_458_Var
		 = (ConditionalExpression)AssignmentExpression_457_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_458_Var
		);
		//458
		final LogicalOrExpression LogicalOrExpression_459_Var
		 = (LogicalOrExpression)ConditionalExpression_458_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_459_Var
		);
		final EList<? extends EObject> Expr_459_list = LogicalOrExpression_459_Var
		.getExpr();
		Assert.assertNotNull(Expr_459_list);
		Assert.assertEquals(1, Expr_459_list.size());
		//459
		final LogicalAndExpression LogicalAndExpression_460_Var
		 = (LogicalAndExpression)Expr_459_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_460_Var
		);
		final EList<? extends EObject> Expr_460_list = LogicalAndExpression_460_Var
		.getExpr();
		Assert.assertNotNull(Expr_460_list);
		Assert.assertEquals(1, Expr_460_list.size());
		//460
		final InclusiveOrExpression InclusiveOrExpression_461_Var
		 = (InclusiveOrExpression)Expr_460_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_461_Var
		);
		final EList<? extends EObject> Expr_461_list = InclusiveOrExpression_461_Var
		.getExpr();
		Assert.assertNotNull(Expr_461_list);
		Assert.assertEquals(1, Expr_461_list.size());
		//461
		final ExclusiveOrExpression ExclusiveOrExpression_462_Var
		 = (ExclusiveOrExpression)Expr_461_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_462_Var
		);
		final EList<? extends EObject> Expr_462_list = ExclusiveOrExpression_462_Var
		.getExpr();
		Assert.assertNotNull(Expr_462_list);
		Assert.assertEquals(1, Expr_462_list.size());
		//462
		final AndExpression AndExpression_463_Var
		 = (AndExpression)Expr_462_list.get(0);
		Assert.assertNotNull(AndExpression_463_Var
		);
		final EList<? extends EObject> Expr_463_list = AndExpression_463_Var
		.getExpr();
		Assert.assertNotNull(Expr_463_list);
		Assert.assertEquals(1, Expr_463_list.size());
		//463
		final EqualityExpression EqualityExpression_464_Var
		 = (EqualityExpression)Expr_463_list.get(0);
		Assert.assertNotNull(EqualityExpression_464_Var
		);
		final EList<? extends EObject> Expr_464_list = EqualityExpression_464_Var
		.getExpr();
		Assert.assertNotNull(Expr_464_list);
		Assert.assertEquals(1, Expr_464_list.size());
		//464
		final RelationalExpression RelationalExpression_465_Var
		 = (RelationalExpression)Expr_464_list.get(0);
		Assert.assertNotNull(RelationalExpression_465_Var
		);
		final EList<? extends EObject> Expr_465_list = RelationalExpression_465_Var
		.getExpr();
		Assert.assertNotNull(Expr_465_list);
		Assert.assertEquals(1, Expr_465_list.size());
		//465
		final ShiftExpression ShiftExpression_466_Var
		 = (ShiftExpression)Expr_465_list.get(0);
		Assert.assertNotNull(ShiftExpression_466_Var
		);
		final EList<? extends EObject> Expr_466_list = ShiftExpression_466_Var
		.getExpr();
		Assert.assertNotNull(Expr_466_list);
		Assert.assertEquals(1, Expr_466_list.size());
		//466
		final AdditiveExpression AdditiveExpression_467_Var
		 = (AdditiveExpression)Expr_466_list.get(0);
		Assert.assertNotNull(AdditiveExpression_467_Var
		);
		final EList<? extends EObject> Expr_467_list = AdditiveExpression_467_Var
		.getExpr();
		Assert.assertNotNull(Expr_467_list);
		Assert.assertEquals(1, Expr_467_list.size());
		//467
		final MultiplicativeExpression MultiplicativeExpression_468_Var
		 = (MultiplicativeExpression)Expr_467_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_468_Var
		);
		final EList<? extends EObject> Expr_468_list = MultiplicativeExpression_468_Var
		.getExpr();
		Assert.assertNotNull(Expr_468_list);
		Assert.assertEquals(1, Expr_468_list.size());
		//468
		final CastExpression CastExpression_469_Var
		 = (CastExpression)Expr_468_list.get(0);
		Assert.assertNotNull(CastExpression_469_Var
		);
		//469
		final UnaryExpression UnaryExpression_470_Var
		 = (UnaryExpression)CastExpression_469_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_470_Var
		);
		//470
		final UnaryOperator UnaryOperator_471_Var
		 = (UnaryOperator)UnaryExpression_470_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_471_Var
		);
		Assert.assertEquals("&", UnaryOperator_471_Var
		.getOp());
		//471
		final CastExpression CastExpression_472_Var
		 = (CastExpression)UnaryExpression_470_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_472_Var
		);
		//472
		final UnaryExpression UnaryExpression_473_Var
		 = (UnaryExpression)CastExpression_472_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_473_Var
		);
		//473
		final PostfixExpression PostfixExpression_474_Var
		 = (PostfixExpression)UnaryExpression_473_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_474_Var
		);
		final EList<? extends EObject> Expr_474_list = PostfixExpression_474_Var
		.getExpr();
		Assert.assertNotNull(Expr_474_list);
		Assert.assertEquals(1, Expr_474_list.size());
		//474
		final PrimaryExpression PrimaryExpression_475_Var
		 = (PrimaryExpression)Expr_474_list.get(0);
		Assert.assertNotNull(PrimaryExpression_475_Var
		);
		Assert.assertEquals("joe", PrimaryExpression_475_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_438_Var
		.getSemi());
		//475
		final Statement Statement_476_Var
		 = (Statement)Statement_345_list.get(2);
		Assert.assertNotNull(Statement_476_Var
		);
		//476
		final ExpressionStatement ExpressionStatement_477_Var
		 = (ExpressionStatement)Statement_476_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_477_Var
		);
		//477
		final Expression Expression_478_Var
		 = (Expression)ExpressionStatement_477_Var
		.getExpression();
		Assert.assertNotNull(Expression_478_Var
		);
		final EList<? extends EObject> ExprExpr_478_list = Expression_478_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_478_list);
		Assert.assertEquals(1, ExprExpr_478_list.size());
		//478
		final AssignmentExpression AssignmentExpression_479_Var
		 = (AssignmentExpression)ExprExpr_478_list.get(0);
		Assert.assertNotNull(AssignmentExpression_479_Var
		);
		//479
		final ConditionalExpression ConditionalExpression_480_Var
		 = (ConditionalExpression)AssignmentExpression_479_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_480_Var
		);
		//480
		final LogicalOrExpression LogicalOrExpression_481_Var
		 = (LogicalOrExpression)ConditionalExpression_480_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_481_Var
		);
		final EList<? extends EObject> Expr_481_list = LogicalOrExpression_481_Var
		.getExpr();
		Assert.assertNotNull(Expr_481_list);
		Assert.assertEquals(1, Expr_481_list.size());
		//481
		final LogicalAndExpression LogicalAndExpression_482_Var
		 = (LogicalAndExpression)Expr_481_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_482_Var
		);
		final EList<? extends EObject> Expr_482_list = LogicalAndExpression_482_Var
		.getExpr();
		Assert.assertNotNull(Expr_482_list);
		Assert.assertEquals(1, Expr_482_list.size());
		//482
		final InclusiveOrExpression InclusiveOrExpression_483_Var
		 = (InclusiveOrExpression)Expr_482_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_483_Var
		);
		final EList<? extends EObject> Expr_483_list = InclusiveOrExpression_483_Var
		.getExpr();
		Assert.assertNotNull(Expr_483_list);
		Assert.assertEquals(1, Expr_483_list.size());
		//483
		final ExclusiveOrExpression ExclusiveOrExpression_484_Var
		 = (ExclusiveOrExpression)Expr_483_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_484_Var
		);
		final EList<? extends EObject> Expr_484_list = ExclusiveOrExpression_484_Var
		.getExpr();
		Assert.assertNotNull(Expr_484_list);
		Assert.assertEquals(1, Expr_484_list.size());
		//484
		final AndExpression AndExpression_485_Var
		 = (AndExpression)Expr_484_list.get(0);
		Assert.assertNotNull(AndExpression_485_Var
		);
		final EList<? extends EObject> Expr_485_list = AndExpression_485_Var
		.getExpr();
		Assert.assertNotNull(Expr_485_list);
		Assert.assertEquals(1, Expr_485_list.size());
		//485
		final EqualityExpression EqualityExpression_486_Var
		 = (EqualityExpression)Expr_485_list.get(0);
		Assert.assertNotNull(EqualityExpression_486_Var
		);
		final EList<? extends EObject> Expr_486_list = EqualityExpression_486_Var
		.getExpr();
		Assert.assertNotNull(Expr_486_list);
		Assert.assertEquals(1, Expr_486_list.size());
		//486
		final RelationalExpression RelationalExpression_487_Var
		 = (RelationalExpression)Expr_486_list.get(0);
		Assert.assertNotNull(RelationalExpression_487_Var
		);
		final EList<? extends EObject> Expr_487_list = RelationalExpression_487_Var
		.getExpr();
		Assert.assertNotNull(Expr_487_list);
		Assert.assertEquals(1, Expr_487_list.size());
		//487
		final ShiftExpression ShiftExpression_488_Var
		 = (ShiftExpression)Expr_487_list.get(0);
		Assert.assertNotNull(ShiftExpression_488_Var
		);
		final EList<? extends EObject> Expr_488_list = ShiftExpression_488_Var
		.getExpr();
		Assert.assertNotNull(Expr_488_list);
		Assert.assertEquals(1, Expr_488_list.size());
		//488
		final AdditiveExpression AdditiveExpression_489_Var
		 = (AdditiveExpression)Expr_488_list.get(0);
		Assert.assertNotNull(AdditiveExpression_489_Var
		);
		final EList<? extends EObject> Expr_489_list = AdditiveExpression_489_Var
		.getExpr();
		Assert.assertNotNull(Expr_489_list);
		Assert.assertEquals(1, Expr_489_list.size());
		//489
		final MultiplicativeExpression MultiplicativeExpression_490_Var
		 = (MultiplicativeExpression)Expr_489_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_490_Var
		);
		final EList<? extends EObject> Expr_490_list = MultiplicativeExpression_490_Var
		.getExpr();
		Assert.assertNotNull(Expr_490_list);
		Assert.assertEquals(1, Expr_490_list.size());
		//490
		final CastExpression CastExpression_491_Var
		 = (CastExpression)Expr_490_list.get(0);
		Assert.assertNotNull(CastExpression_491_Var
		);
		//491
		final UnaryExpression UnaryExpression_492_Var
		 = (UnaryExpression)CastExpression_491_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_492_Var
		);
		//492
		final PostfixExpression PostfixExpression_493_Var
		 = (PostfixExpression)UnaryExpression_492_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_493_Var
		);
		final EList<? extends EObject> Expr_493_list = PostfixExpression_493_Var
		.getExpr();
		Assert.assertNotNull(Expr_493_list);
		Assert.assertEquals(1, Expr_493_list.size());
		//493
		final PrimaryExpression PrimaryExpression_494_Var
		 = (PrimaryExpression)Expr_493_list.get(0);
		Assert.assertNotNull(PrimaryExpression_494_Var
		);
		Assert.assertEquals("print", PrimaryExpression_494_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_494_list = PostfixExpression_493_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_494_list);
		Assert.assertEquals(1, ArgumentExpressionList_494_list.size());
		//494
		final ArgumentExpressionList ArgumentExpressionList_495_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_494_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_495_Var
		);
		final EList<? extends EObject> Expr_495_list = ArgumentExpressionList_495_Var
		.getExpr();
		Assert.assertNotNull(Expr_495_list);
		Assert.assertEquals(1, Expr_495_list.size());
		//495
		final AssignmentExpression AssignmentExpression_496_Var
		 = (AssignmentExpression)Expr_495_list.get(0);
		Assert.assertNotNull(AssignmentExpression_496_Var
		);
		//496
		final ConditionalExpression ConditionalExpression_497_Var
		 = (ConditionalExpression)AssignmentExpression_496_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_497_Var
		);
		//497
		final LogicalOrExpression LogicalOrExpression_498_Var
		 = (LogicalOrExpression)ConditionalExpression_497_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_498_Var
		);
		final EList<? extends EObject> Expr_498_list = LogicalOrExpression_498_Var
		.getExpr();
		Assert.assertNotNull(Expr_498_list);
		Assert.assertEquals(1, Expr_498_list.size());
		//498
		final LogicalAndExpression LogicalAndExpression_499_Var
		 = (LogicalAndExpression)Expr_498_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_499_Var
		);
		final EList<? extends EObject> Expr_499_list = LogicalAndExpression_499_Var
		.getExpr();
		Assert.assertNotNull(Expr_499_list);
		Assert.assertEquals(1, Expr_499_list.size());
		//499
		final InclusiveOrExpression InclusiveOrExpression_500_Var
		 = (InclusiveOrExpression)Expr_499_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_500_Var
		);
		final EList<? extends EObject> Expr_500_list = InclusiveOrExpression_500_Var
		.getExpr();
		Assert.assertNotNull(Expr_500_list);
		Assert.assertEquals(1, Expr_500_list.size());
		//500
		final ExclusiveOrExpression ExclusiveOrExpression_501_Var
		 = (ExclusiveOrExpression)Expr_500_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_501_Var
		);
		final EList<? extends EObject> Expr_501_list = ExclusiveOrExpression_501_Var
		.getExpr();
		Assert.assertNotNull(Expr_501_list);
		Assert.assertEquals(1, Expr_501_list.size());
		//501
		final AndExpression AndExpression_502_Var
		 = (AndExpression)Expr_501_list.get(0);
		Assert.assertNotNull(AndExpression_502_Var
		);
		final EList<? extends EObject> Expr_502_list = AndExpression_502_Var
		.getExpr();
		Assert.assertNotNull(Expr_502_list);
		Assert.assertEquals(1, Expr_502_list.size());
		//502
		final EqualityExpression EqualityExpression_503_Var
		 = (EqualityExpression)Expr_502_list.get(0);
		Assert.assertNotNull(EqualityExpression_503_Var
		);
		final EList<? extends EObject> Expr_503_list = EqualityExpression_503_Var
		.getExpr();
		Assert.assertNotNull(Expr_503_list);
		Assert.assertEquals(1, Expr_503_list.size());
		//503
		final RelationalExpression RelationalExpression_504_Var
		 = (RelationalExpression)Expr_503_list.get(0);
		Assert.assertNotNull(RelationalExpression_504_Var
		);
		final EList<? extends EObject> Expr_504_list = RelationalExpression_504_Var
		.getExpr();
		Assert.assertNotNull(Expr_504_list);
		Assert.assertEquals(1, Expr_504_list.size());
		//504
		final ShiftExpression ShiftExpression_505_Var
		 = (ShiftExpression)Expr_504_list.get(0);
		Assert.assertNotNull(ShiftExpression_505_Var
		);
		final EList<? extends EObject> Expr_505_list = ShiftExpression_505_Var
		.getExpr();
		Assert.assertNotNull(Expr_505_list);
		Assert.assertEquals(1, Expr_505_list.size());
		//505
		final AdditiveExpression AdditiveExpression_506_Var
		 = (AdditiveExpression)Expr_505_list.get(0);
		Assert.assertNotNull(AdditiveExpression_506_Var
		);
		final EList<? extends EObject> Expr_506_list = AdditiveExpression_506_Var
		.getExpr();
		Assert.assertNotNull(Expr_506_list);
		Assert.assertEquals(1, Expr_506_list.size());
		//506
		final MultiplicativeExpression MultiplicativeExpression_507_Var
		 = (MultiplicativeExpression)Expr_506_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_507_Var
		);
		final EList<? extends EObject> Expr_507_list = MultiplicativeExpression_507_Var
		.getExpr();
		Assert.assertNotNull(Expr_507_list);
		Assert.assertEquals(1, Expr_507_list.size());
		//507
		final CastExpression CastExpression_508_Var
		 = (CastExpression)Expr_507_list.get(0);
		Assert.assertNotNull(CastExpression_508_Var
		);
		//508
		final UnaryExpression UnaryExpression_509_Var
		 = (UnaryExpression)CastExpression_508_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_509_Var
		);
		//509
		final UnaryOperator UnaryOperator_510_Var
		 = (UnaryOperator)UnaryExpression_509_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_510_Var
		);
		Assert.assertEquals("&", UnaryOperator_510_Var
		.getOp());
		//510
		final CastExpression CastExpression_511_Var
		 = (CastExpression)UnaryExpression_509_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_511_Var
		);
		//511
		final UnaryExpression UnaryExpression_512_Var
		 = (UnaryExpression)CastExpression_511_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_512_Var
		);
		//512
		final PostfixExpression PostfixExpression_513_Var
		 = (PostfixExpression)UnaryExpression_512_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_513_Var
		);
		final EList<? extends EObject> Expr_513_list = PostfixExpression_513_Var
		.getExpr();
		Assert.assertNotNull(Expr_513_list);
		Assert.assertEquals(1, Expr_513_list.size());
		//513
		final PrimaryExpression PrimaryExpression_514_Var
		 = (PrimaryExpression)Expr_513_list.get(0);
		Assert.assertNotNull(PrimaryExpression_514_Var
		);
		Assert.assertEquals("phil", PrimaryExpression_514_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_477_Var
		.getSemi());
		//514
		final Statement Statement_515_Var
		 = (Statement)Statement_345_list.get(3);
		Assert.assertNotNull(Statement_515_Var
		);
		//515
		final ExpressionStatement ExpressionStatement_516_Var
		 = (ExpressionStatement)Statement_515_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_516_Var
		);
		//516
		final Expression Expression_517_Var
		 = (Expression)ExpressionStatement_516_Var
		.getExpression();
		Assert.assertNotNull(Expression_517_Var
		);
		final EList<? extends EObject> ExprExpr_517_list = Expression_517_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_517_list);
		Assert.assertEquals(1, ExprExpr_517_list.size());
		//517
		final AssignmentExpression AssignmentExpression_518_Var
		 = (AssignmentExpression)ExprExpr_517_list.get(0);
		Assert.assertNotNull(AssignmentExpression_518_Var
		);
		//518
		final UnaryExpression UnaryExpression_519_Var
		 = (UnaryExpression)AssignmentExpression_518_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_519_Var
		);
		//519
		final PostfixExpression PostfixExpression_520_Var
		 = (PostfixExpression)UnaryExpression_519_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_520_Var
		);
		final EList<? extends EObject> Expr_520_list = PostfixExpression_520_Var
		.getExpr();
		Assert.assertNotNull(Expr_520_list);
		Assert.assertEquals(1, Expr_520_list.size());
		//520
		final PrimaryExpression PrimaryExpression_521_Var
		 = (PrimaryExpression)Expr_520_list.get(0);
		Assert.assertNotNull(PrimaryExpression_521_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_521_Var
		.getId());
		Assert.assertEquals("[->]", PostfixExpression_520_Var
		.getArrow().toString());
		Assert.assertEquals("[id]", PostfixExpression_520_Var
		.getId().toString());
		//521
		final AssignmentOperator AssignmentOperator_522_Var
		 = (AssignmentOperator)AssignmentExpression_518_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_522_Var
		);
		Assert.assertEquals("=", AssignmentOperator_522_Var
		.getOp());
		//522
		final AssignmentExpression AssignmentExpression_523_Var
		 = (AssignmentExpression)AssignmentExpression_518_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_523_Var
		);
		//523
		final ConditionalExpression ConditionalExpression_524_Var
		 = (ConditionalExpression)AssignmentExpression_523_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_524_Var
		);
		//524
		final LogicalOrExpression LogicalOrExpression_525_Var
		 = (LogicalOrExpression)ConditionalExpression_524_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_525_Var
		);
		final EList<? extends EObject> Expr_525_list = LogicalOrExpression_525_Var
		.getExpr();
		Assert.assertNotNull(Expr_525_list);
		Assert.assertEquals(1, Expr_525_list.size());
		//525
		final LogicalAndExpression LogicalAndExpression_526_Var
		 = (LogicalAndExpression)Expr_525_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_526_Var
		);
		final EList<? extends EObject> Expr_526_list = LogicalAndExpression_526_Var
		.getExpr();
		Assert.assertNotNull(Expr_526_list);
		Assert.assertEquals(1, Expr_526_list.size());
		//526
		final InclusiveOrExpression InclusiveOrExpression_527_Var
		 = (InclusiveOrExpression)Expr_526_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_527_Var
		);
		final EList<? extends EObject> Expr_527_list = InclusiveOrExpression_527_Var
		.getExpr();
		Assert.assertNotNull(Expr_527_list);
		Assert.assertEquals(1, Expr_527_list.size());
		//527
		final ExclusiveOrExpression ExclusiveOrExpression_528_Var
		 = (ExclusiveOrExpression)Expr_527_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_528_Var
		);
		final EList<? extends EObject> Expr_528_list = ExclusiveOrExpression_528_Var
		.getExpr();
		Assert.assertNotNull(Expr_528_list);
		Assert.assertEquals(1, Expr_528_list.size());
		//528
		final AndExpression AndExpression_529_Var
		 = (AndExpression)Expr_528_list.get(0);
		Assert.assertNotNull(AndExpression_529_Var
		);
		final EList<? extends EObject> Expr_529_list = AndExpression_529_Var
		.getExpr();
		Assert.assertNotNull(Expr_529_list);
		Assert.assertEquals(1, Expr_529_list.size());
		//529
		final EqualityExpression EqualityExpression_530_Var
		 = (EqualityExpression)Expr_529_list.get(0);
		Assert.assertNotNull(EqualityExpression_530_Var
		);
		final EList<? extends EObject> Expr_530_list = EqualityExpression_530_Var
		.getExpr();
		Assert.assertNotNull(Expr_530_list);
		Assert.assertEquals(1, Expr_530_list.size());
		//530
		final RelationalExpression RelationalExpression_531_Var
		 = (RelationalExpression)Expr_530_list.get(0);
		Assert.assertNotNull(RelationalExpression_531_Var
		);
		final EList<? extends EObject> Expr_531_list = RelationalExpression_531_Var
		.getExpr();
		Assert.assertNotNull(Expr_531_list);
		Assert.assertEquals(1, Expr_531_list.size());
		//531
		final ShiftExpression ShiftExpression_532_Var
		 = (ShiftExpression)Expr_531_list.get(0);
		Assert.assertNotNull(ShiftExpression_532_Var
		);
		final EList<? extends EObject> Expr_532_list = ShiftExpression_532_Var
		.getExpr();
		Assert.assertNotNull(Expr_532_list);
		Assert.assertEquals(1, Expr_532_list.size());
		//532
		final AdditiveExpression AdditiveExpression_533_Var
		 = (AdditiveExpression)Expr_532_list.get(0);
		Assert.assertNotNull(AdditiveExpression_533_Var
		);
		final EList<? extends EObject> Expr_533_list = AdditiveExpression_533_Var
		.getExpr();
		Assert.assertNotNull(Expr_533_list);
		Assert.assertEquals(1, Expr_533_list.size());
		//533
		final MultiplicativeExpression MultiplicativeExpression_534_Var
		 = (MultiplicativeExpression)Expr_533_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_534_Var
		);
		final EList<? extends EObject> Expr_534_list = MultiplicativeExpression_534_Var
		.getExpr();
		Assert.assertNotNull(Expr_534_list);
		Assert.assertEquals(1, Expr_534_list.size());
		//534
		final CastExpression CastExpression_535_Var
		 = (CastExpression)Expr_534_list.get(0);
		Assert.assertNotNull(CastExpression_535_Var
		);
		//535
		final UnaryExpression UnaryExpression_536_Var
		 = (UnaryExpression)CastExpression_535_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_536_Var
		);
		//536
		final PostfixExpression PostfixExpression_537_Var
		 = (PostfixExpression)UnaryExpression_536_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_537_Var
		);
		final EList<? extends EObject> Expr_537_list = PostfixExpression_537_Var
		.getExpr();
		Assert.assertNotNull(Expr_537_list);
		Assert.assertEquals(1, Expr_537_list.size());
		//537
		final PrimaryExpression PrimaryExpression_538_Var
		 = (PrimaryExpression)Expr_537_list.get(0);
		Assert.assertNotNull(PrimaryExpression_538_Var
		);
		//538
		final Constant Constant_539_Var
		 = (Constant)PrimaryExpression_538_Var
		.getConst();
		Assert.assertNotNull(Constant_539_Var
		);
		Assert.assertEquals("0x009", Constant_539_Var
		.getHex());
		Assert.assertEquals(";", ExpressionStatement_516_Var
		.getSemi());
		//539
		final Statement Statement_540_Var
		 = (Statement)Statement_345_list.get(4);
		Assert.assertNotNull(Statement_540_Var
		);
		//540
		final ExpressionStatement ExpressionStatement_541_Var
		 = (ExpressionStatement)Statement_540_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_541_Var
		);
		//541
		final Expression Expression_542_Var
		 = (Expression)ExpressionStatement_541_Var
		.getExpression();
		Assert.assertNotNull(Expression_542_Var
		);
		final EList<? extends EObject> ExprExpr_542_list = Expression_542_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_542_list);
		Assert.assertEquals(1, ExprExpr_542_list.size());
		//542
		final AssignmentExpression AssignmentExpression_543_Var
		 = (AssignmentExpression)ExprExpr_542_list.get(0);
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
		Assert.assertEquals("strcpy", PrimaryExpression_558_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_558_list = PostfixExpression_557_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_558_list);
		Assert.assertEquals(1, ArgumentExpressionList_558_list.size());
		//558
		final ArgumentExpressionList ArgumentExpressionList_559_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_558_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_559_Var
		);
		final EList<? extends EObject> Expr_559_list = ArgumentExpressionList_559_Var
		.getExpr();
		Assert.assertNotNull(Expr_559_list);
		Assert.assertEquals(2, Expr_559_list.size());
		//559
		final AssignmentExpression AssignmentExpression_560_Var
		 = (AssignmentExpression)Expr_559_list.get(0);
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
		Assert.assertEquals("newEmployee", PrimaryExpression_575_Var
		.getId());
		Assert.assertEquals("[->]", PostfixExpression_574_Var
		.getArrow().toString());
		Assert.assertEquals("[name]", PostfixExpression_574_Var
		.getId().toString());
		//575
		final AssignmentExpression AssignmentExpression_576_Var
		 = (AssignmentExpression)Expr_559_list.get(1);
		Assert.assertNotNull(AssignmentExpression_576_Var
		);
		//576
		final ConditionalExpression ConditionalExpression_577_Var
		 = (ConditionalExpression)AssignmentExpression_576_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_577_Var
		);
		//577
		final LogicalOrExpression LogicalOrExpression_578_Var
		 = (LogicalOrExpression)ConditionalExpression_577_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_578_Var
		);
		final EList<? extends EObject> Expr_578_list = LogicalOrExpression_578_Var
		.getExpr();
		Assert.assertNotNull(Expr_578_list);
		Assert.assertEquals(1, Expr_578_list.size());
		//578
		final LogicalAndExpression LogicalAndExpression_579_Var
		 = (LogicalAndExpression)Expr_578_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_579_Var
		);
		final EList<? extends EObject> Expr_579_list = LogicalAndExpression_579_Var
		.getExpr();
		Assert.assertNotNull(Expr_579_list);
		Assert.assertEquals(1, Expr_579_list.size());
		//579
		final InclusiveOrExpression InclusiveOrExpression_580_Var
		 = (InclusiveOrExpression)Expr_579_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_580_Var
		);
		final EList<? extends EObject> Expr_580_list = InclusiveOrExpression_580_Var
		.getExpr();
		Assert.assertNotNull(Expr_580_list);
		Assert.assertEquals(1, Expr_580_list.size());
		//580
		final ExclusiveOrExpression ExclusiveOrExpression_581_Var
		 = (ExclusiveOrExpression)Expr_580_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_581_Var
		);
		final EList<? extends EObject> Expr_581_list = ExclusiveOrExpression_581_Var
		.getExpr();
		Assert.assertNotNull(Expr_581_list);
		Assert.assertEquals(1, Expr_581_list.size());
		//581
		final AndExpression AndExpression_582_Var
		 = (AndExpression)Expr_581_list.get(0);
		Assert.assertNotNull(AndExpression_582_Var
		);
		final EList<? extends EObject> Expr_582_list = AndExpression_582_Var
		.getExpr();
		Assert.assertNotNull(Expr_582_list);
		Assert.assertEquals(1, Expr_582_list.size());
		//582
		final EqualityExpression EqualityExpression_583_Var
		 = (EqualityExpression)Expr_582_list.get(0);
		Assert.assertNotNull(EqualityExpression_583_Var
		);
		final EList<? extends EObject> Expr_583_list = EqualityExpression_583_Var
		.getExpr();
		Assert.assertNotNull(Expr_583_list);
		Assert.assertEquals(1, Expr_583_list.size());
		//583
		final RelationalExpression RelationalExpression_584_Var
		 = (RelationalExpression)Expr_583_list.get(0);
		Assert.assertNotNull(RelationalExpression_584_Var
		);
		final EList<? extends EObject> Expr_584_list = RelationalExpression_584_Var
		.getExpr();
		Assert.assertNotNull(Expr_584_list);
		Assert.assertEquals(1, Expr_584_list.size());
		//584
		final ShiftExpression ShiftExpression_585_Var
		 = (ShiftExpression)Expr_584_list.get(0);
		Assert.assertNotNull(ShiftExpression_585_Var
		);
		final EList<? extends EObject> Expr_585_list = ShiftExpression_585_Var
		.getExpr();
		Assert.assertNotNull(Expr_585_list);
		Assert.assertEquals(1, Expr_585_list.size());
		//585
		final AdditiveExpression AdditiveExpression_586_Var
		 = (AdditiveExpression)Expr_585_list.get(0);
		Assert.assertNotNull(AdditiveExpression_586_Var
		);
		final EList<? extends EObject> Expr_586_list = AdditiveExpression_586_Var
		.getExpr();
		Assert.assertNotNull(Expr_586_list);
		Assert.assertEquals(1, Expr_586_list.size());
		//586
		final MultiplicativeExpression MultiplicativeExpression_587_Var
		 = (MultiplicativeExpression)Expr_586_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_587_Var
		);
		final EList<? extends EObject> Expr_587_list = MultiplicativeExpression_587_Var
		.getExpr();
		Assert.assertNotNull(Expr_587_list);
		Assert.assertEquals(1, Expr_587_list.size());
		//587
		final CastExpression CastExpression_588_Var
		 = (CastExpression)Expr_587_list.get(0);
		Assert.assertNotNull(CastExpression_588_Var
		);
		//588
		final UnaryExpression UnaryExpression_589_Var
		 = (UnaryExpression)CastExpression_588_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_589_Var
		);
		//589
		final PostfixExpression PostfixExpression_590_Var
		 = (PostfixExpression)UnaryExpression_589_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_590_Var
		);
		final EList<? extends EObject> Expr_590_list = PostfixExpression_590_Var
		.getExpr();
		Assert.assertNotNull(Expr_590_list);
		Assert.assertEquals(1, Expr_590_list.size());
		//590
		final PrimaryExpression PrimaryExpression_591_Var
		 = (PrimaryExpression)Expr_590_list.get(0);
		Assert.assertNotNull(PrimaryExpression_591_Var
		);
		//591
		final Constant Constant_592_Var
		 = (Constant)PrimaryExpression_591_Var
		.getConst();
		Assert.assertNotNull(Constant_592_Var
		);
		Assert.assertEquals("\"Billy The Kid\"", Constant_592_Var
		.getStr());
		Assert.assertEquals(";", ExpressionStatement_541_Var
		.getSemi());
		//592
		final Statement Statement_593_Var
		 = (Statement)Statement_345_list.get(5);
		Assert.assertNotNull(Statement_593_Var
		);
		//593
		final ExpressionStatement ExpressionStatement_594_Var
		 = (ExpressionStatement)Statement_593_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_594_Var
		);
		//594
		final Expression Expression_595_Var
		 = (Expression)ExpressionStatement_594_Var
		.getExpression();
		Assert.assertNotNull(Expression_595_Var
		);
		final EList<? extends EObject> ExprExpr_595_list = Expression_595_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_595_list);
		Assert.assertEquals(1, ExprExpr_595_list.size());
		//595
		final AssignmentExpression AssignmentExpression_596_Var
		 = (AssignmentExpression)ExprExpr_595_list.get(0);
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
		Assert.assertEquals("print", PrimaryExpression_611_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_611_list = PostfixExpression_610_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_611_list);
		Assert.assertEquals(1, ArgumentExpressionList_611_list.size());
		//611
		final ArgumentExpressionList ArgumentExpressionList_612_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_611_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_612_Var
		);
		final EList<? extends EObject> Expr_612_list = ArgumentExpressionList_612_Var
		.getExpr();
		Assert.assertNotNull(Expr_612_list);
		Assert.assertEquals(1, Expr_612_list.size());
		//612
		final AssignmentExpression AssignmentExpression_613_Var
		 = (AssignmentExpression)Expr_612_list.get(0);
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
		Assert.assertEquals("newEmployee", PrimaryExpression_628_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_594_Var
		.getSemi());
		//628
		final Statement Statement_629_Var
		 = (Statement)Statement_345_list.get(6);
		Assert.assertNotNull(Statement_629_Var
		);
		//629
		final ExpressionStatement ExpressionStatement_630_Var
		 = (ExpressionStatement)Statement_629_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_630_Var
		);
		//630
		final Expression Expression_631_Var
		 = (Expression)ExpressionStatement_630_Var
		.getExpression();
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
		Assert.assertEquals("free", PrimaryExpression_647_Var
		.getId());
		final EList<? extends EObject> ArgumentExpressionList_647_list = PostfixExpression_646_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_647_list);
		Assert.assertEquals(1, ArgumentExpressionList_647_list.size());
		//647
		final ArgumentExpressionList ArgumentExpressionList_648_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_647_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_648_Var
		);
		final EList<? extends EObject> Expr_648_list = ArgumentExpressionList_648_Var
		.getExpr();
		Assert.assertNotNull(Expr_648_list);
		Assert.assertEquals(1, Expr_648_list.size());
		//648
		final AssignmentExpression AssignmentExpression_649_Var
		 = (AssignmentExpression)Expr_648_list.get(0);
		Assert.assertNotNull(AssignmentExpression_649_Var
		);
		//649
		final ConditionalExpression ConditionalExpression_650_Var
		 = (ConditionalExpression)AssignmentExpression_649_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_650_Var
		);
		//650
		final LogicalOrExpression LogicalOrExpression_651_Var
		 = (LogicalOrExpression)ConditionalExpression_650_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_651_Var
		);
		final EList<? extends EObject> Expr_651_list = LogicalOrExpression_651_Var
		.getExpr();
		Assert.assertNotNull(Expr_651_list);
		Assert.assertEquals(1, Expr_651_list.size());
		//651
		final LogicalAndExpression LogicalAndExpression_652_Var
		 = (LogicalAndExpression)Expr_651_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_652_Var
		);
		final EList<? extends EObject> Expr_652_list = LogicalAndExpression_652_Var
		.getExpr();
		Assert.assertNotNull(Expr_652_list);
		Assert.assertEquals(1, Expr_652_list.size());
		//652
		final InclusiveOrExpression InclusiveOrExpression_653_Var
		 = (InclusiveOrExpression)Expr_652_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_653_Var
		);
		final EList<? extends EObject> Expr_653_list = InclusiveOrExpression_653_Var
		.getExpr();
		Assert.assertNotNull(Expr_653_list);
		Assert.assertEquals(1, Expr_653_list.size());
		//653
		final ExclusiveOrExpression ExclusiveOrExpression_654_Var
		 = (ExclusiveOrExpression)Expr_653_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_654_Var
		);
		final EList<? extends EObject> Expr_654_list = ExclusiveOrExpression_654_Var
		.getExpr();
		Assert.assertNotNull(Expr_654_list);
		Assert.assertEquals(1, Expr_654_list.size());
		//654
		final AndExpression AndExpression_655_Var
		 = (AndExpression)Expr_654_list.get(0);
		Assert.assertNotNull(AndExpression_655_Var
		);
		final EList<? extends EObject> Expr_655_list = AndExpression_655_Var
		.getExpr();
		Assert.assertNotNull(Expr_655_list);
		Assert.assertEquals(1, Expr_655_list.size());
		//655
		final EqualityExpression EqualityExpression_656_Var
		 = (EqualityExpression)Expr_655_list.get(0);
		Assert.assertNotNull(EqualityExpression_656_Var
		);
		final EList<? extends EObject> Expr_656_list = EqualityExpression_656_Var
		.getExpr();
		Assert.assertNotNull(Expr_656_list);
		Assert.assertEquals(1, Expr_656_list.size());
		//656
		final RelationalExpression RelationalExpression_657_Var
		 = (RelationalExpression)Expr_656_list.get(0);
		Assert.assertNotNull(RelationalExpression_657_Var
		);
		final EList<? extends EObject> Expr_657_list = RelationalExpression_657_Var
		.getExpr();
		Assert.assertNotNull(Expr_657_list);
		Assert.assertEquals(1, Expr_657_list.size());
		//657
		final ShiftExpression ShiftExpression_658_Var
		 = (ShiftExpression)Expr_657_list.get(0);
		Assert.assertNotNull(ShiftExpression_658_Var
		);
		final EList<? extends EObject> Expr_658_list = ShiftExpression_658_Var
		.getExpr();
		Assert.assertNotNull(Expr_658_list);
		Assert.assertEquals(1, Expr_658_list.size());
		//658
		final AdditiveExpression AdditiveExpression_659_Var
		 = (AdditiveExpression)Expr_658_list.get(0);
		Assert.assertNotNull(AdditiveExpression_659_Var
		);
		final EList<? extends EObject> Expr_659_list = AdditiveExpression_659_Var
		.getExpr();
		Assert.assertNotNull(Expr_659_list);
		Assert.assertEquals(1, Expr_659_list.size());
		//659
		final MultiplicativeExpression MultiplicativeExpression_660_Var
		 = (MultiplicativeExpression)Expr_659_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_660_Var
		);
		final EList<? extends EObject> Expr_660_list = MultiplicativeExpression_660_Var
		.getExpr();
		Assert.assertNotNull(Expr_660_list);
		Assert.assertEquals(1, Expr_660_list.size());
		//660
		final CastExpression CastExpression_661_Var
		 = (CastExpression)Expr_660_list.get(0);
		Assert.assertNotNull(CastExpression_661_Var
		);
		//661
		final UnaryExpression UnaryExpression_662_Var
		 = (UnaryExpression)CastExpression_661_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_662_Var
		);
		//662
		final PostfixExpression PostfixExpression_663_Var
		 = (PostfixExpression)UnaryExpression_662_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_663_Var
		);
		final EList<? extends EObject> Expr_663_list = PostfixExpression_663_Var
		.getExpr();
		Assert.assertNotNull(Expr_663_list);
		Assert.assertEquals(1, Expr_663_list.size());
		//663
		final PrimaryExpression PrimaryExpression_664_Var
		 = (PrimaryExpression)Expr_663_list.get(0);
		Assert.assertNotNull(PrimaryExpression_664_Var
		);
		Assert.assertEquals("newEmployee", PrimaryExpression_664_Var
		.getId());
		Assert.assertEquals(";", ExpressionStatement_630_Var
		.getSemi());
		//664
		final Statement Statement_665_Var
		 = (Statement)Statement_345_list.get(7);
		Assert.assertNotNull(Statement_665_Var
		);
		//665
		final JumpStatement JumpStatement_666_Var
		 = (JumpStatement)Statement_665_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_666_Var
		);
		//666
		final Expression Expression_667_Var
		 = (Expression)JumpStatement_666_Var
		.getExpr();
		Assert.assertNotNull(Expression_667_Var
		);
		final EList<? extends EObject> ExprExpr_667_list = Expression_667_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_667_list);
		Assert.assertEquals(1, ExprExpr_667_list.size());
		//667
		final AssignmentExpression AssignmentExpression_668_Var
		 = (AssignmentExpression)ExprExpr_667_list.get(0);
		Assert.assertNotNull(AssignmentExpression_668_Var
		);
		//668
		final ConditionalExpression ConditionalExpression_669_Var
		 = (ConditionalExpression)AssignmentExpression_668_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_669_Var
		);
		//669
		final LogicalOrExpression LogicalOrExpression_670_Var
		 = (LogicalOrExpression)ConditionalExpression_669_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_670_Var
		);
		final EList<? extends EObject> Expr_670_list = LogicalOrExpression_670_Var
		.getExpr();
		Assert.assertNotNull(Expr_670_list);
		Assert.assertEquals(1, Expr_670_list.size());
		//670
		final LogicalAndExpression LogicalAndExpression_671_Var
		 = (LogicalAndExpression)Expr_670_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_671_Var
		);
		final EList<? extends EObject> Expr_671_list = LogicalAndExpression_671_Var
		.getExpr();
		Assert.assertNotNull(Expr_671_list);
		Assert.assertEquals(1, Expr_671_list.size());
		//671
		final InclusiveOrExpression InclusiveOrExpression_672_Var
		 = (InclusiveOrExpression)Expr_671_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_672_Var
		);
		final EList<? extends EObject> Expr_672_list = InclusiveOrExpression_672_Var
		.getExpr();
		Assert.assertNotNull(Expr_672_list);
		Assert.assertEquals(1, Expr_672_list.size());
		//672
		final ExclusiveOrExpression ExclusiveOrExpression_673_Var
		 = (ExclusiveOrExpression)Expr_672_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_673_Var
		);
		final EList<? extends EObject> Expr_673_list = ExclusiveOrExpression_673_Var
		.getExpr();
		Assert.assertNotNull(Expr_673_list);
		Assert.assertEquals(1, Expr_673_list.size());
		//673
		final AndExpression AndExpression_674_Var
		 = (AndExpression)Expr_673_list.get(0);
		Assert.assertNotNull(AndExpression_674_Var
		);
		final EList<? extends EObject> Expr_674_list = AndExpression_674_Var
		.getExpr();
		Assert.assertNotNull(Expr_674_list);
		Assert.assertEquals(1, Expr_674_list.size());
		//674
		final EqualityExpression EqualityExpression_675_Var
		 = (EqualityExpression)Expr_674_list.get(0);
		Assert.assertNotNull(EqualityExpression_675_Var
		);
		final EList<? extends EObject> Expr_675_list = EqualityExpression_675_Var
		.getExpr();
		Assert.assertNotNull(Expr_675_list);
		Assert.assertEquals(1, Expr_675_list.size());
		//675
		final RelationalExpression RelationalExpression_676_Var
		 = (RelationalExpression)Expr_675_list.get(0);
		Assert.assertNotNull(RelationalExpression_676_Var
		);
		final EList<? extends EObject> Expr_676_list = RelationalExpression_676_Var
		.getExpr();
		Assert.assertNotNull(Expr_676_list);
		Assert.assertEquals(1, Expr_676_list.size());
		//676
		final ShiftExpression ShiftExpression_677_Var
		 = (ShiftExpression)Expr_676_list.get(0);
		Assert.assertNotNull(ShiftExpression_677_Var
		);
		final EList<? extends EObject> Expr_677_list = ShiftExpression_677_Var
		.getExpr();
		Assert.assertNotNull(Expr_677_list);
		Assert.assertEquals(1, Expr_677_list.size());
		//677
		final AdditiveExpression AdditiveExpression_678_Var
		 = (AdditiveExpression)Expr_677_list.get(0);
		Assert.assertNotNull(AdditiveExpression_678_Var
		);
		final EList<? extends EObject> Expr_678_list = AdditiveExpression_678_Var
		.getExpr();
		Assert.assertNotNull(Expr_678_list);
		Assert.assertEquals(1, Expr_678_list.size());
		//678
		final MultiplicativeExpression MultiplicativeExpression_679_Var
		 = (MultiplicativeExpression)Expr_678_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_679_Var
		);
		final EList<? extends EObject> Expr_679_list = MultiplicativeExpression_679_Var
		.getExpr();
		Assert.assertNotNull(Expr_679_list);
		Assert.assertEquals(1, Expr_679_list.size());
		//679
		final CastExpression CastExpression_680_Var
		 = (CastExpression)Expr_679_list.get(0);
		Assert.assertNotNull(CastExpression_680_Var
		);
		//680
		final UnaryExpression UnaryExpression_681_Var
		 = (UnaryExpression)CastExpression_680_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_681_Var
		);
		//681
		final PostfixExpression PostfixExpression_682_Var
		 = (PostfixExpression)UnaryExpression_681_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_682_Var
		);
		final EList<? extends EObject> Expr_682_list = PostfixExpression_682_Var
		.getExpr();
		Assert.assertNotNull(Expr_682_list);
		Assert.assertEquals(1, Expr_682_list.size());
		//682
		final PrimaryExpression PrimaryExpression_683_Var
		 = (PrimaryExpression)Expr_682_list.get(0);
		Assert.assertNotNull(PrimaryExpression_683_Var
		);
		//683
		final Constant Constant_684_Var
		 = (Constant)PrimaryExpression_683_Var
		.getConst();
		Assert.assertNotNull(Constant_684_Var
		);
		Assert.assertEquals("0", Constant_684_Var
		.getDec());
		Assert.assertEquals("return", JumpStatement_666_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_666_Var
		.getSemi());
	}
	
	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0038_StructAdvanced.c");
		Resource resource = set.getResource(uri, true);
		// validate the resource
		List<Issue> list = this.validator.validate(resource, 
			CheckMode.ALL,CancelIndicator.NullImpl);
		Assert.assertTrue(list.isEmpty());
		
		// configure and start the generator
		this.fileAccessSystem.setOutputPath("bin");
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/greetings.txt");
		final String expected = this.getTextFromFile(
			"res/Test0038_StructAdvanced.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
		// System.out.println("Code generation finished.");
	}
	
}


